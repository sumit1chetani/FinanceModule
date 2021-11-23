define([ 'payroll/tds/tds' ], function(module) {
    'use strict';
    module.registerController('ratesCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {
        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;

        $scope.rate = {
            id : '',
            rangeFrom : '',
            rangeTo : '',
            unitCharge : ''

        };

        $scope.getList = function() {

            $http.get("payroll/payroll/rate/list").success(function(response) {
                $scope.rowCollection = response.rateList;

            });
        }
        $scope.getList();

        $scope.add = function() {

            $scope.callDialog($scope, 0, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope);
        };

        $scope.callDialog = function($scope, id, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope) {
            ngDialog.open({
                scope : $scope,
                template : 'views/payroll/payroll/electricityCharges/rates/ratesAdd',
                controller : $controller('rateAddCtrl', {
                    $scope : $scope,
                    id : id,
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

        $scope.editRow = function(id) {
            $scope.callDialog($scope, id, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope);
        };

        $scope.cancel = function() {
            $state.go('app.payroll.payroll.electricityCharges.rates.list');
        };

        $scope.deleteRow = function(taxRateId) {
            ngDialog.openConfirm().then(function() {
                $http.post("payroll/payroll/rate/delete", taxRateId).success(function(response) {
                    if (response == true) {
                        logger.logSuccess("Deleted Successfully!");
                        $scope.getList();
                    }
                }).error(function(result) {
                    logger.logError("Error Please Try Again");
                });
            });
        };
    });

    module.registerController('rateAddCtrl', function($scope, $http, ngDialog, logger, id, $injector, sharedProperties, toaster, $rootScope, validationService) {
        $scope.rateAdd = {
            id : '',
            rangeFrom : '',
            rangeTo : '',
            unitCharge : '',
            isEdit : false
        };
        $scope.rateAdd.isEdit = false;
        $scope.cancel = function() {
            ngDialog.close();
        };

        if (id != 0 && id != undefined && id != null) {
            $http.post("payroll/payroll/rate/edit", id).success(function(response) {
                $scope.rateAdd = response.rateBean
                $scope.rateAdd.isEdit = true;

            });
        }

        $scope.save = function(rateTypeAdd) {
            if (new validationService().checkFormValidity(rateTypeAdd)) {
                var resultBean = {
                    id : $scope.rateAdd.id,
                    rangeFrom : $scope.rateAdd.rangeFrom,
                    rangeTo : $scope.rateAdd.rangeTo,
                    unitCharge : $scope.rateAdd.unitCharge
                };

                $http.post("payroll/payroll/rate/save", resultBean).success(function(response) {
                    if (response == true) {

                        logger.logSuccess("Saved Successfully!");
                        ngDialog.close();
                    } else {
                        logger.logError("Sorry Rate Id Already Exists!");
                    }
                });
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(rateTypeAdd.$validationSummary), 5000, 'trustedHtml');
            }

        };

        $scope.update = function(rateTypeAdd) {
            if (new validationService().checkFormValidity(rateTypeAdd)) {
                var resultBean = {
                    id : $scope.rateAdd.id,
                    rangeFrom : $scope.rateAdd.rangeFrom,
                    rangeTo : $scope.rateAdd.rangeTo,
                    unitCharge : $scope.rateAdd.unitCharge
                };

                $http.post("payroll/payroll/rate/update", resultBean).success(function(response) {
                    if (response == true) {

                        logger.logSuccess("Updated Successfully!");
                        ngDialog.close();
                    } else {
                        logger.logError("Sorry Rate Id Already Exists!");
                    }
                });
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(rateTypeAdd.$validationSummary), 5000, 'trustedHtml');
            }

        };
    });

});