//define([ 'hospital/accounts/accounts' ], function(module) {
    'use strict';
    app.controller('journalVoucherTypeCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {
        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;

        $scope.isDelete = true;
        $scope.isUpload = true;

        $scope.getList = function() {
            $http.get("app/JournalVoucherType/list").success(function(response) {
                $scope.rowCollection = response.journalVoucherTypeBeans;
            });
        }
        $scope.getList();

        $scope.add = function() {
            $scope.callDialog($scope, 0, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope);
        };

        $scope.callDialog = function($scope, journalVoucherTypeId, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope) {
            ngDialog.open({
                scope : $scope,
                template : 'views/finance/accounts/journalVoucherType/journalVoucherTypeAdd',
                controller : $controller('journalVoucherTypeAddCtrl', {
                    $scope : $scope,
                    journalVoucherTypeId : journalVoucherTypeId,
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
        }

        $scope.editRow = function(journalVoucherTypeId) {
            $scope.callDialog($scope, journalVoucherTypeId, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope);
        }

        $scope.deleteRow = function(journalVoucherTypeId) {
            ngDialog.openConfirm().then(function() {
                $http.post("app/JournalVoucherType/delete", journalVoucherTypeId).success(function(response) {
                    if (response == true) {
                        logger.logSuccess("Deleted Successfully!");
                        $scope.getList();
                    }
                }).error(function(result) {
                    logger.logError("Error Please Try Again");
                });
            });
        };

    })

    app.controller('journalVoucherTypeAddCtrl', function($scope, $http, ngDialog, logger, journalVoucherTypeId, $injector, sharedProperties, toaster, $rootScope, validationService) {

        $scope.journalVoucherTypeAdd = {
            jbTypename : '',
            description : '',
            active : '',
            journalVoucherTypeId : ''
        };

        $scope.journalVoucherTypeAdd.isEdit = false;
        $scope.cancel = function() {
            ngDialog.close();
        };

        if (journalVoucherTypeId != 0 && journalVoucherTypeId != undefined && journalVoucherTypeId != null) {
            $http.post("app/JournalVoucherType/edit", journalVoucherTypeId).success(function(response) {
                $scope.journalVoucherTypeAdd.active = response.journalVoucherTypeBean.active;
                $scope.journalVoucherTypeAdd.jbTypename = response.journalVoucherTypeBean.name;
                $scope.journalVoucherTypeAdd.description = response.journalVoucherTypeBean.description;
                $scope.journalVoucherTypeAdd.journalVoucherTypeId = response.journalVoucherTypeBean.journalVoucherTypeId;
                $scope.journalVoucherTypeAdd.isEdit = true;

            });
        }

        $scope.save = function(journalVoucherTypeAddForm) {
            if (new validationService().checkFormValidity(journalVoucherTypeAddForm)) {
                var resultbean = {
                    name : $scope.journalVoucherTypeAdd.jbTypename,
                    description : $scope.journalVoucherTypeAdd.description,
                    active : $scope.journalVoucherTypeAdd.active,

                }
                $http.post("app/JournalVoucherType/save", resultbean).success(function(response) {
                    if (response == true) {
                        logger.logSuccess("Saved Successfully!");
                        ngDialog.close();
                    } else {
                        logger.logError("Error Ocuured Please Try again later");
                    }
                });

            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(journalVoucherTypeAddForm.$validationSummary), 5000, 'trustedHtml');

            }

        };

        $scope.update = function(journalVoucherTypeAddForm) {
            if (new validationService().checkFormValidity(journalVoucherTypeAddForm)) {
                var resultbean = {
                    name : $scope.journalVoucherTypeAdd.jbTypename,
                    description : $scope.journalVoucherTypeAdd.description,
                    active : $scope.journalVoucherTypeAdd.active,
                    journalVoucherTypeId : $scope.journalVoucherTypeAdd.journalVoucherTypeId

                }
                $http.post("app/JournalVoucherType/update", resultbean).success(function(response) {
                    if (response == true) {
                        logger.logSuccess("Updated Successfully!");
                        ngDialog.close();
                    } else {
                        logger.logError("Error Ocuured Please Try again later");
                    }
                });

            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(journalVoucherTypeAddForm.$validationSummary), 5000, 'trustedHtml');
            }
        };

        $scope.resetUpdate = function() {
            $http.post("app/JournalVoucherType/edit", journalVoucherTypeId).success(function(response) {
                $scope.journalVoucherTypeAdd.active = response.journalVoucherTypeBean.active;
                $scope.journalVoucherTypeAdd.jbTypename = response.journalVoucherTypeBean.name;
                $scope.journalVoucherTypeAdd.description = response.journalVoucherTypeBean.description;
                $scope.journalVoucherTypeAdd.journalVoucherTypeId = response.journalVoucherTypeBean.journalVoucherTypeId;
                $scope.journalVoucherTypeAdd.isEdit = true;

            });
        };

        $scope.reset = function() {

            $scope.journalVoucherTypeAdd = {
                jbTypename : '',
                description : '',
                active : '',
                journalVoucherTypeId : ''
            };

        };

    //});

});