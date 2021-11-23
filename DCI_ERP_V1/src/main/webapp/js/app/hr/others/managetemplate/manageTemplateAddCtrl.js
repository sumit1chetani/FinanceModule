define([ 'hrms/hr/hr' ], function(module) {
    'use strict';
    module.registerController('manageTemplateAddCtrl', function($scope, $state, $http, ngDialog, logger, $stateParams, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService) {
        $scope.rowCollection = [];
        $scope.rowCollectionItem = [];
        $scope.displayedCollectionItem = [];
        $scope.displayedCollection = [];
        $scope.template = {
            template_id : '',
            valid_from : '',
            designation : '',
            template_name : '',
            valid_to : '',
            status : '',
        }
        $scope.reset = function() {
            $scope.template.valid_from = '';
            $scope.template.designation = '';
            $scope.template.template_name = '';
            $scope.template.valid_to = '';
            $scope.template.status = '';
            $scope.rowCollectionItem = [];
        }

        $scope.templateObj = {
            edit : false
        };

        $scope.cancel = function() {
            $state.go('app.hrms.hr.others.managetemplate.list');
        };
        $scope.cancelReq = function() {
            ngDialog.close();
        };

        $scope.getQuestionList = function() {
            $http.get('hrms/hr/others/managequestion/list').success(function(response) {
                $('#inventoryDetails').show();
                $scope.rowCollection = response.questionList;
                $scope.rowCollectionSearch = response.questionList;
            });
        }
        $scope.getQuestionList();

        $scope.getDesignationList = function() {
            $http.get('hrms/master/employeeMaster/getDesignationList').success(function(datas) {
                $scope.designationList = datas.designationList;
            }).error(function(data) {

            });
        }
        $scope.getDesignationList();

        $scope.getAutoGenarateNumber = function() {
            $http.get('hrms/hr/others/managetemplate/getAutoGenarateNumber').success(function(response) {
                $scope.template.template_id = response.template_id;
            });
        }
        $scope.getAutoGenarateNumber();

        $scope.addQuestions = function() {
            $scope.callDialog($scope, 0, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope);
        };

        $scope.callDialog = function($scope, requestCode, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope) {
            requestCode = angular.copy($scope.vendor, requestCode);
            ngDialog.open({
                scope : $scope,
                template : 'views/hrms/hr/others/managetemplate/manageTemplateQuestionAdd',
                controller : $controller('manageTemplatePopAddCtrl', {
                    $scope : $scope,
                    requestCode : requestCode,
                    $http : $http,
                    ngDialog : ngDialog,
                    logger : logger,
                    $injector : $injector,
                    sharedProperties : sharedProperties,
                    toaster : toaster,
                    $rootScope : $rootScope
                }),
                className : 'ngdialog-theme-plain',
                showClose : false,
                closeByDocument : false,
                closeByEscape : false,
                preCloseCallback : $scope.getList
            });
        };
        $scope.chkAll = false;
        $scope.checkAll = function(rowCollectionItem, checkBox) {
            if (checkBox) {
                $scope.chkAll = true;
            } else {
                $scope.chkAll = false;
            }
            angular.forEach($scope.rowCollectionItem, function(value, key) {
                value.select = $scope.chkAll;
            });
        };
        $scope.deletedIds = [];

        $scope.removeQuestions = function() {
            $scope.tablerow = [];
            $scope.copytablerow = [];
            angular.forEach($scope.rowCollectionItem, function(value, index) {
                if (value.select == true) {
                    $scope.deletedIds.push({
                        "questionId" : value.question_id
                    });
                } else {
                    $scope.tablerow.push(value);
                }
            });
            $scope.rowCollectionItem = $scope.tablerow;
        };

        $scope.$watch('template.valid_to', function(newValue, oldValue) {
            if (newValue != '' && newValue != undefined) {
                if ($scope.template.valid_from == '') {
                    logger.logError("Please Select Valid From");
                    $scope.template.valid_to = '';
                }
                var toDate = $scope.template.valid_from;
                var fromDate = newValue;
                fromDate = fromDate.split("/");
                fromDate = new Date(fromDate[2], fromDate[1] - 1, fromDate[0]);
                toDate = toDate.split("/");
                toDate = new Date(toDate[2], toDate[1] - 1, toDate[0]);
                if (fromDate < toDate) {
                    logger.logError("Selected date is lesser than the from Date");
                    $scope.template.valid_to = '';
                }
            }
        });

        $scope.submit = function(templateForm, template) {
            if (new validationService().checkFormValidity(templateForm)) {
                $scope.save(template);
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.templateForm.$validationSummary), 5000, 'trustedHtml');
            }
        };

        $scope.save = function(template) {
            var jsonData = {
                'templateData' : template,
                'templatedtlData' : $scope.rowCollectionItem,
            }
            debugger;
            var isCheck = false;
            angular.forEach($scope.rowCollectionItem, function(value, key) {
                if (value.select == true) {
                    isCheck = true;
                }
            });
            if (!isCheck) {
                logger.logError("Please Select Atleast One Question!");
            } else {
                $http.post('hrms/hr/others/managetemplate/checkTemplateAlreadyExist', template).success(function(data) {
                    if (data) {
                        logger.logError("Template Already Exist For this Designation!");
                    } else {
                        $http.post('hrms/hr/others/managetemplate/save', jsonData).success(function(data) {
                            if (data) {
                                logger.logSuccess("Template Successfully Added!");
                                $state.go('app.hrms.hr.others.managetemplate.list');

                            } else {
                                logger.logError("Error Not Saved!");
                            }
                        });
                    }

                });

            }

        }

    });

    module.registerController('manageTemplatePopAddCtrl', function($scope, $state, $http, ngDialog, logger, $stateParams, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService) {
        $scope.cancelReq = function() {
            ngDialog.close();
        };

        $scope.getQuestionList = function() {
            $http.get('hrms/hr/others/managequestion/list').success(function(response) {
                $('#inventoryDetails').show();
                $scope.rowCollection = response.questionList;
                $scope.rowCollectionSearch = response.questionList;
            });
        }
        $scope.getQuestionList();

        $scope.chkAllPurchase = false;
        $scope.checkAllPurchase = function(rowCollection, checkBox) {
            if (checkBox) {
                $scope.chkAllPurchase = true;
            } else {
                $scope.chkAllPurchase = false;
            }
            angular.forEach($scope.rowCollection, function(value, key) {
                value.select = $scope.chkAllPurchase;
            });

        };

        $scope.getListValue = function(data) {

            var isExists = 0;
            debugger;
            var select = false;
            if (data != undefined) {
                for (var i = 0; i < data.length; i++) {
                    if (data[i].select) {
                        isExists = 0;
                        angular.forEach($scope.rowCollectionItem, function(value, key) {
                            if (value.question_id == data[i].question_id) {
                                isExists = 1;
                                data[i].select = false;
                            }
                        });
                        if (isExists == 1) {
                            logger.logError("Selected Question Already Exists!");
                        } else {
                            $scope.rowCollectionItem.push(data[i]);
                            select = true;
                            if (select) {
                                ngDialog.close();
                            } else {
                                logger.logError("Please select atleast one question!");
                            }
                        }
                    }
                }
            }
        };

    });
    module.registerController('manageTemplateEditCtrl', function($scope, $state, $http, ngDialog, logger, $stateParams, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService) {
        $scope.rowCollection = [];
        $scope.cancel = function() {
            $state.go('app.hrms.hr.others.managetemplate.list');
        };
        $scope.templateObj = {
            edit : true
        };
        $scope.reset = function() {
            $state.reload();
        }
        $scope.$watch('template.valid_to', function(newValue, oldValue) {
            if (newValue != '' && newValue != undefined) {
                if ($scope.template.valid_from == '') {
                    logger.logError("Please Select Valid From");
                    $scope.template.valid_to = '';
                }
                var toDate = $scope.template.valid_from;
                var fromDate = newValue;
                fromDate = fromDate.split("/");
                fromDate = new Date(fromDate[2], fromDate[1] - 1, fromDate[0]);
                toDate = toDate.split("/");
                toDate = new Date(toDate[2], toDate[1] - 1, toDate[0]);
                if (fromDate < toDate) {
                    logger.logError("Selected date is lesser than the from Date");
                    $scope.template.valid_to = '';
                }
            }
        });
        $scope.getDesignationList = function() {
            $http.get('hrms/master/employeeMaster/getDesignationList').success(function(datas) {
                $scope.designationList = datas.designationList;
            }).error(function(data) {

            });
        }
        $scope.getDesignationList();
        $scope.getQuestionList = function() {
            $http.get('hrms/hr/others/managequestion/list').success(function(response) {
                $('#inventoryDetails').show();
                $scope.rowCollection = response.questionList;
                $scope.rowCollectionSearch = response.questionList;
            });
        }
        $scope.getQuestionList();

        $scope.question = {
            question_id : '',
            question_desc : '',
            status : '',
        }

        var id = $stateParams.id;
        if (id == undefined) {
            $scope.templateObj.edit = false;
        } else {
            $scope.templateObj.edit = true;
            $http.post('hrms/hr/others/managetemplate/getTemplateDataEdit?templateId=' + id).success(function(result) {
                $scope.template = result;
                $scope.rowCollectionItem = result.templatedtlData;
                // angular.forEach(result.templatedtlData,function(value,key){
                // angular.forEach($scope.rowCollectionItem,function(valueRow,keyRow){
                // debugger
                // if(value.select==true){
                // if(value.id==valueRow.id){
                // valueRow.select = true;
                // }
                // }
                // });
                // });

            }).error(function(data) {
            });
        }

        $scope.deletedIds = [];

        $scope.removeQuestions = function() {
            $scope.tablerow = [];
            $scope.copytablerow = [];
            angular.forEach($scope.rowCollectionItem, function(value, index) {
                if (value.select == true) {
                    $scope.deletedIds.push({
                        "questionId" : value.question_id
                    });
                } else {
                    $scope.tablerow.push(value);
                }
            });
            $scope.rowCollectionItem = $scope.tablerow;
        };

        $scope.chkAll = false;
        $scope.checkAll = function(rowCollectionItem, checkBox) {
            if (checkBox) {
                $scope.chkAll = true;
            } else {
                $scope.chkAll = false;
            }
            angular.forEach($scope.rowCollectionItem, function(value, key) {
                value.select = $scope.chkAll;
            });
        };
        $scope.addQuestions = function() {
            $scope.callDialog($scope, 0, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope);
        };

        $scope.callDialog = function($scope, requestCode, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope) {
            requestCode = angular.copy($scope.vendor, requestCode);
            ngDialog.open({
                scope : $scope,
                template : 'views/hrms/hr/others/managetemplate/manageTemplateQuestionAdd',
                controller : $controller('manageTemplatePopAddCtrl', {
                    $scope : $scope,
                    requestCode : requestCode,
                    $http : $http,
                    ngDialog : ngDialog,
                    logger : logger,
                    $injector : $injector,
                    sharedProperties : sharedProperties,
                    toaster : toaster,
                    $rootScope : $rootScope
                }),
                className : 'ngdialog-theme-plain',
                showClose : false,
                closeByDocument : false,
                closeByEscape : false,
                preCloseCallback : $scope.getList
            });
        };

        $scope.submit = function(templateForm, template) {
            if (new validationService().checkFormValidity(templateForm)) {
                $scope.save(template);
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.templateForm.$validationSummary), 5000, 'trustedHtml');
            }
        };

        $scope.save = function(template) {
            var jsonData = {
                'templateData' : template,
                'templatedtlData' : $scope.rowCollectionItem,
            }
            debugger;
            var isCheck = false;
            angular.forEach($scope.rowCollectionItem, function(value, key) {
                if (value.select == true) {
                    isCheck = true;
                }
            });
            if (!isCheck) {
                logger.logError("Please Select Atleast One Question!");
            } else {
                $http.post('hrms/hr/others/managetemplate/update', jsonData).success(function(data) {
                    if (data) {
                        logger.logSuccess("Template Successfully Updated!");
                        $state.go('app.hrms.hr.others.managetemplate.list');
                    } else {
                        logger.logError("Error Not Updated!");
                    }
                }).error(function(data) {
                    logger.logSuccess("Error Not Updated!");
                });
            }

        }

    });

});
