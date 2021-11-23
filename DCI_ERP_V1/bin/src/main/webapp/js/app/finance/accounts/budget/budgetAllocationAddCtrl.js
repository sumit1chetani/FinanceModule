//define([ 'hospital/accounts/accounts' ], function(module) {

    'use strict';

    app.controller('budgetAllocationAddCtrl', function($scope, $state, $http, $location, sharedProperties, toaster, $injector, logger, $stateParams, $compile, $timeout, $parse, validationService) {

        $scope.dataLoopCount = 0;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.expenseList = [];
        $scope.companyList = [];
        $scope.finYearList = [];
        $scope.statusList = [];
        $scope.columnList = [];

        $scope.budgetData = {
            budget_allocation_id : '',
            company : '',
            financial_year : '',
            expense_type : 'Admin',
            misc_expenses : '',
            salaries : '',
            communication : '',
            travel_entertainment : '',
            prof_fees : '',
            maintanance : '',
            asset_purchase : '',
            supplier_payment : '',
            companyName : '',
            subGrpName : '',
            status : 'Pending',
            amount:'',
            expenseColumns : []
        };
        $scope.columns = {};
        $scope.edit = false;

        /**
         * fetch Current Date into PQ Date, Valid From Date
         */
        $scope.getCurrentDate = function() {
            var d = new Date();
            var year = d.getFullYear();
            var month = d.getMonth() + 1;
            if (month < 10) {
                month = "0" + month;
            }
            ;
            var day = d.getDate();
            if (day < 10) {
                day = "0" + day;
            }
            $scope.date = day + "/" + month + "/" + year;

        }
        $scope.getCurrentDate();
        $scope.getDropdownValue = function() {
            var expenseObj = [], stausObj = [];
          /*  $http.get('app/budget/getDropDownList').success(function(datas) {
                $scope.companyList = datas.companyList;
                // $scope.finYearList = datas.finYearList;
            }).error(function(datas) {
            });
*/
            
            
            
            
            $http.get('app/commonUtility/getCompanyListcompany').success(function(datas) {
                $scope.companyList = datas;

                    var foundItemDest = $filter('filter')($scope.companyList, {
                        baseCompany : 1
                        
                    })[0];
                    $scope.budgetReportData.company=foundItemDest.id;
            }).error(function(datas) {
            });
            
            
            
            
            
            expenseObj.push({
                'id' : 'Admin',
                'text' : 'Admin'
            });
            expenseObj.push({
                'id' : 'Operational',
                'text' : 'Operational'
            });
            $scope.expenseList = expenseObj;

            stausObj.push({
                'id' : 'Pending',
                'text' : 'Pending'
            });
            /*
             * stausObj.push({'id' : 'Approved' ,'text' : 'Approved'});
             * stausObj.push({'id' : 'Rejected' ,'text' : 'Rejected'});
             */
            $scope.statusList = stausObj;

        }
        $scope.getDropdownValue();

        $scope.$watch('budgetData.expense_type', function(newValue, oldValue) {
            if (newValue != '' && newValue != undefined) {
                $http.get('app/budget/getDynamicColumns?type=' + newValue).success(function(datas) {
                    $scope.columnList = datas.columnList;
                    getDynamicColumns(newValue);
                }).error(function(data) {
                });
            } else {
                $scope.columnList = [];
            }
        });

        $scope.$watch('budgetData.company', function(newValue, oldValue) {
            if (newValue != '' && newValue != undefined) {
                $http.get('app/budget/getFinYear?company=' + newValue).success(function(datas) {
                    if (datas.finYearList.length > 0) {
                        $scope.finYearList = datas.finYearList;
                    } else {
                        $scope.finYearList = [];
                        $scope.budgetData.financial_year = "";
                    }
                }).error(function(data) {
                });
            } else {
                $scope.finYearList = [];
                $scope.budgetData.financial_year = "";
            }
        });

        /**
         * validation
         */
        $scope.validate = function() {
            if (new validationService().checkFormValidity($scope.budgetAllocationForm)) {

                if ($scope.edit == false) {
                    $http.post('app/budget/getAvailablity', $scope.budgetData).success(function(result) {
                        if (result.success)
                            $scope.save();
                        else
                            logger.logError("Budget Already Exist!");
                    })
                } else {
                    if ($scope.editData.company != $scope.budgetData.company || $scope.editData.financial_year != $scope.budgetData.financial_year || $scope.editData.expense_type != $scope.budgetData.expense_type) {
                        $http.post('app/budget/getAvailablity', $scope.budgetData).success(function(result) {
                            if (result.success)
                                $scope.save();
                            else
                                logger.logError("Budget Already Exist!");
                        })
                    } else
                        $scope.save();

                }
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.budgetAllocationForm.$validationSummary), 555000, 'trustedHtml');
            }
        };

        $scope.save = function() {

            if ($scope.edit == false) {
                $http.post('app/budget/save', $scope.budgetData).success(function(result) {
                    if (result.success) {
                        logger.logSuccess("Saved Successfully!");
                        $location.path($stateParams.tenantid+'hospital/accounts/budgetAllocation/list');
                    } else {
                        logger.logError("Error in Save!");
                    }
                }).error(function(result) {
                });
            } else {
                $http.post('app/budget/update', $scope.budgetData).success(function(result) {
                    if (result.success) {
                        logger.logSuccess("Updated Successfully!");
                        $location.path($stateParams.tenantid+'/hospital/accounts/budgetAllocation/list');
                    } else {
                        logger.logError("Error in Update");
                    }
                }).error(function(result) {
                });
            }

        };

        /***********************************************************************
         * Edit Functionality *******************************
         */
        $scope.fetchEditData = function() {
            var allocationId = $location.search().allocationId;

            if (allocationId == undefined || allocationId == null || allocationId == "") {
            } else {
                $scope.edit = true;
                $http.get('app/budget/getAllocationEdit?allocationId=' + allocationId).success(function(data) {
                    $scope.budgetData = data.budgetAllocationBean;
                    $scope.editData = data.budgetAllocationBean;

                    $timeout(function() {
                        angular.forEach($scope.budgetData.expenseColumns, function(value, key) {

                            var expColumn = value.keyColumn.replace(/[^a-zA-Z0-9]/g, '');

                            // Get the model
                            var model = $parse(expColumn);

                            // Assigns a value to it
                            model.assign($scope.columns, value.keyValue);

                            // Apply it to the scope
                            $scope.$apply();

                            // $scope.columns.expColumn = value.amount;
                        });
                    }, 3, false);

                }).error(function(data) {
                });
            }
        }
        $scope.fetchEditData();

        $scope.cancel = function() {
            $location.path('/hospital/accounts/budgetAllocation/list');
        };

        /**
         * Reset Functionality ******************************
         */
        var originalCNAcctDatas = angular.copy($scope.budgetData);
        var originalCNAcctTotal = angular.copy($scope.creditnoteDtlTotalAmt);

        $scope.reset = function(creditNoteForm, budgetData) {
            if ($scope.edit == false) {
                $scope.budgetData = angular.copy(originalCNAcctDatas);
                $scope.creditnoteDtlTotalAmt = angular.copy(originalCNAcctTotal);
                $scope.creditNoteForm.$setPristine();
            } else {
                $scope.fetchEditData();
            }
        }

        $scope.isEditChanged = function() {
            return !angular.equals($scope.budgetData, originalCNAcctDatas);
        };

        function getDynamicColumns(type) {
            var strLeft = "", strRight = "";
            angular.forEach($scope.columnList, function(value, key) {
                var columnName = "'" + value + "'", model = value.replace(/[^a-zA-Z0-9]/g, '');

                if (key % 2 == 0) {
                    strLeft += '<div class="form-group">' + '<label class="col-md-4 control-label">' + value + '<span style="color:red;"> *</span></label>' + '<div class="col-md-7">' + '<input type="text" name="' + value + '" class="form-control input-sm text-right" ng-model="columns.' + model + '"' + 'ng-blur="pushColumnsToModelData(columns.' + model + ',' + columnName + ');"' + 'validation="required" friendly-name="' + value + '" ng-pattern-restrict="{{numExp}}" />' + '</div>' + '</div>';
                } else {
                    strRight += '<div class="form-group">' + '<label class="col-md-4 control-label">' + value + '<span style="color:red;"> *</span></label>' + '<div class="col-md-7">' + '<input type="text" name="' + value + '" class="form-control input-sm text-right" ng-model="columns.' + model + '"' + 'ng-blur="pushColumnsToModelData(columns.' + model + ',' + columnName + ');"' + 'validation="required" friendly-name="' + value + '" ng-pattern-restrict="{{numExp}}" />' + '</div>' + '</div>';
                }

            });

            if (type == "Admin") {
                if (strLeft == '' && strRight != '') {
                    $('#leftDivAd').html($compile(strRight)($scope));
                    $('#rightDivAd').html($compile(strLeft)($scope));
                } else {
                    $('#leftDivAd').html($compile(strLeft)($scope));
                    $('#rightDivAd').html($compile(strRight)($scope));
                }
            } else {
                if (strLeft == '' && strRight != '') {

                    $('#leftDivOp').html($compile(strRight)($scope));
                    $('#rightDivOp').html($compile(strLeft)($scope));
                } else {
                    $('#leftDivOp').html($compile(strLeft)($scope));
                    $('#rightDivOp').html($compile(strRight)($scope));
                }
            }
        }

        $scope.pushColumnsToModelData = function(model, column) {

            var object = new Object();
            if (model != undefined && column != undefined) {

                object.keyColumn = column;
                object.keyValue = model;
                angular.forEach($scope.budgetData.expenseColumns, function(row, index) {
                    if (row.keyColumn == column) {
                        $scope.budgetData.expenseColumns.splice(index, 1);
                    }
                });
                $scope.budgetData.expenseColumns.push(object);
            }
        }
    });

    app.controller('budgetApprovalAddCtrl', function($scope, $state, $http, $location, sharedProperties, toaster, $injector, logger, $stateParams, $compile, $timeout, $parse, validationService) {

        $scope.dataLoopCount = 0;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.expenseList = [];
        $scope.companyList = [];
        $scope.finYearList = [];
        $scope.statusList = [];
        $scope.columnList = [];

        $scope.budgetData = {
            budget_allocation_id : '',
            company : '',
            financial_year : '',
            expense_type : 'Admin',
            misc_expenses : '',
            salaries : '',
            communication : '',
            travel_entertainment : '',
            prof_fees : '',
            maintanance : '',
            asset_purchase : '',
            supplier_payment : '',
            companyName : '',
            subGrpName : '',
            status : 'Pending',
            expenseColumns : []
        };
        $scope.edit = false;
        $scope.columns = {};

        /**
         * fetch Current Date into PQ Date, Valid From Date
         */
        $scope.getCurrentDate = function() {
            var d = new Date();
            var year = d.getFullYear();
            var month = d.getMonth() + 1;
            if (month < 10) {
                month = "0" + month;
            }
            ;
            var day = d.getDate();
            if (day < 10) {
                day = "0" + day;
            }
            $scope.date = day + "/" + month + "/" + year;

        }
        $scope.getCurrentDate();
        $scope.getDropdownValue = function() {
            var expenseObj = [], stausObj = [];
            $http.get('app/budget/getDropDownList').success(function(datas) {
                $scope.companyList = datas.companyList;
                // $scope.finYearList = datas.finYearList;
            }).error(function(datas) {
            });

            expenseObj.push({
                'id' : 'Admin',
                'text' : 'Admin'
            });
            expenseObj.push({
                'id' : 'Operational',
                'text' : 'Operational'
            });
            $scope.expenseList = expenseObj;

            stausObj.push({
                'id' : 'Pending',
                'text' : 'Pending'
            });
            stausObj.push({
                'id' : 'Approved',
                'text' : 'Approved'
            });
            stausObj.push({
                'id' : 'Rejected',
                'text' : 'Rejected'
            });
            $scope.statusList = stausObj;
        }
        $scope.getDropdownValue();

        $scope.$watch('budgetData.company', function(newValue, oldValue) {
            if (newValue != '' && newValue != undefined) {
                $http.get('app/budget/getFinYear?company=' + newValue).success(function(datas) {
                    if (datas.finYearList.length > 0) {
                        $scope.finYearList = datas.finYearList;
                    } else {
                        $scope.finYearList = [];
                        $scope.budgetData.financial_year = "";
                    }
                }).error(function(data) {
                });
            } else {
                $scope.finYearList = [];
                $scope.budgetData.financial_year = "";
            }
        });

        $scope.$watch('budgetData.expense_type', function(newValue, oldValue) {
            if (newValue != '' && newValue != undefined) {
                $http.get('app/budget/getDynamicColumns?type=' + newValue).success(function(datas) {
                    $scope.columnList = datas.columnList;
                    getDynamicColumns(newValue);
                }).error(function(data) {
                });
            } else {
                $scope.columnList = [];
            }
        });

        /**
         * validation
         */
        $scope.validate = function() {
            if (new validationService().checkFormValidity($scope.budgetAllocationForm)) {
                $scope.approve();
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.budgetAllocationForm.$validationSummary), 555000, 'trustedHtml');
            }
        };

        $scope.approve = function() {

            $http.post('app/budget/approve', $scope.budgetData).success(function(result) {

                if (result.success) {
                    logger.logSuccess("Updated Successfully!");
                    $location.path('/hospital/accounts/approval/list');
                } else {
                    logger.logError("Error in Update!");
                }
            }).error(function(result) {
            });

        };

        /***********************************************************************
         * Edit Functionality *******************************
         */
        $scope.fetchEditData = function() {
            var allocationId = $location.search().allocationId;

            if (allocationId == undefined || allocationId == null || allocationId == "") {
            } else {
                $scope.edit = true;
                $http.get('app/budget/getAllocationEdit?allocationId=' + allocationId).success(function(data) {
                    $scope.budgetData = data.budgetAllocationBean;

                    $timeout(function() {
                        angular.forEach($scope.budgetData.expenseColumns, function(value, key) {

                            var expColumn = value.keyColumn.replace(/[^a-zA-Z0-9]/g, '');

                            // Get the model
                            var model = $parse(expColumn);

                            // Assigns a value to it
                            model.assign($scope.columns, value.keyValue);

                            // Apply it to the scope
                            $scope.$apply();

                        });
                    }, 3, false);

                }).error(function(data) {
                });
            }
        }
        $scope.fetchEditData();

        $scope.cancel = function() {
            $location.path('/hospital/accounts/approval/list');
        };

        /**
         * Reset Functionality ******************************
         */
        var originalCNAcctDatas = angular.copy($scope.budgetData);
        var originalCNAcctTotal = angular.copy($scope.creditnoteDtlTotalAmt);

        $scope.reset = function(creditNoteForm, budgetData) {
            if ($scope.edit == false) {
                $scope.budgetData = angular.copy(originalCNAcctDatas);
                $scope.creditnoteDtlTotalAmt = angular.copy(originalCNAcctTotal);
                $scope.creditNoteForm.$setPristine();
            } else {
                $scope.fetchEditData();
            }
        }

        $scope.isEditChanged = function() {
            return !angular.equals($scope.budgetData, originalCNAcctDatas);
        };

        function getDynamicColumns(type) {
            var strLeft = "", strRight = "";
            angular.forEach($scope.columnList, function(value, key) {
                var columnName = "'" + value + "'", model = value.replace(/[^a-zA-Z0-9]/g, '');

                if (key % 2 == 0) {
                    strLeft += '<div class="form-group">' + '<label class="col-md-4 control-label">' + value + '<spring:message' + 'code="label.asterisk.symbol"></spring:message></label>' + '<div class="col-md-7">' + '<input type="text" name="' + value + '" class="form-control input-sm text-right" ng-model="columns.' + model + '"' + 'ng-blur="pushColumnsToModelData(columns.' + model + ',' + columnName + ');"' + 'validation="required" friendly-name="' + value + '" ng-pattern-restrict="{{numExp}}" readonly/>' + '</div>' + '</div>';
                } else {
                    strRight += '<div class="form-group">' + '<label class="col-md-4 control-label">' + value + '<spring:message' + 'code="label.asterisk.symbol"></spring:message></label>' + '<div class="col-md-7">' + '<input type="text" name="' + value + '" class="form-control input-sm text-right" ng-model="columns.' + model + '"' + 'ng-blur="pushColumnsToModelData(columns.' + model + ',' + columnName + ');"' + 'validation="required" friendly-name="' + value + '" ng-pattern-restrict="{{numExp}}" readonly/>' + '</div>' + '</div>';
                }

            });

            if (type == "Admin") {
                if (strLeft == '' && strRight != '') {
                    $('#leftDivAd').html($compile(strRight)($scope));
                    $('#rightDivAd').html($compile(strLeft)($scope));
                } else {
                    $('#leftDivAd').html($compile(strLeft)($scope));
                    $('#rightDivAd').html($compile(strRight)($scope));
                }
            } else {
                if (strLeft == '' && strRight != '') {

                    $('#leftDivOp').html($compile(strRight)($scope));
                    $('#rightDivOp').html($compile(strLeft)($scope));
                } else {
                    $('#leftDivOp').html($compile(strLeft)($scope));
                    $('#rightDivOp').html($compile(strRight)($scope));
                }
            }
        }

        $scope.pushColumnsToModelData = function(model, column) {

            var object = new Object();
            if (model != undefined && column != undefined) {

                object.keyColumn = column;
                object.keyValue = model;
                angular.forEach($scope.budgetData.expenseColumns, function(row, index) {
                    if (row.keyColumn == column) {
                        $scope.budgetData.expenseColumns.splice(index, 1);
                    }
                });
                $scope.budgetData.expenseColumns.push(object);
            }
        }

    });

//});