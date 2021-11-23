//define([ 'hospital/accounts/accounts' ], function(module) {

    'use strict';

    app.controller('chequeReconsiderationCtrl', function($scope, $state, $http, ngDialog, logger, validationService, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {

        $scope.isDisplay = true;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.bankList = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages = 0;

        $scope.reconsidate = {
            fromdate : '',
            todate : '',
            bankAccount : '',
            differentrecli : [],
            remarks : ''
        };

        $scope.showDifferences = function(chequeReconsolationAddForm, reconsidate) {

            $scope.table = 'difference';
            $scope.reconsidate.differentrecli = [];
            if (new validationService().checkFormValidity($scope.chequeReconsolationAddForm)) {

                $http.post("hospital/accounts/chequeReconcilation/getBankandBookStatement", reconsidate).success(function(response) {
                    if (response.success == true) {

                        $scope.reconsidate.differentrecli = response.lBankReconcilationBook;
                        $scope.table = 'difference';

                        if (response.lBankReconcilationBook.length > 0) {

                        } else {
                            logger.log("No Records Found!");
                        }
                    }
                }).error(function(result) {
                    logger.logError("Error Please Try Again");
                });

            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.chequeReconsolationAddForm.$validationSummary), 555000, 'trustedHtml');
            }
        }

        $scope.showReconillation = function(chequeReconsolationAddForm, reconsidate) {

            $scope.table = 'reconcilat';
            $scope.reconsidate.differentrecli = [];
            if (new validationService().checkFormValidity($scope.chequeReconsolationAddForm)) {

                $http.post("hospital/accounts/chequeReconcilation/getReconcileStatement", reconsidate).success(function(response) {
                    if (response.success == true) {
                        $scope.reconsidate.differentrecli = response.lBankReconcilationBook;
                        $scope.table = 'reconcilat';

                        if (response.lBankReconcilationBook.length > 0) {

                        } else {
                            logger.log("No Records Found!");
                        }
                    }
                }).error(function(result) {
                    logger.logError("Error Please Try Again");
                });

            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.chequeReconsolationAddForm.$validationSummary), 555000, 'trustedHtml');
            }

        }
        $scope.saveReconcileData = function(reconsidate) {

            var flag = true;

            if (new validationService().checkFormValidity($scope.chequeReconsolationAddForm)) {
                angular.forEach(reconsidate.differentrecli, function(bean, idx) {
                    if (bean.select) {
                        if (bean.bankDate == "" || bean.bankDate == null || bean.bankDate == undefined) {
                            var idex = idx + 1;
                            logger.logError("Bank Date row(" + idex + "): required");
                            flag = false;
                        }

                    }
                });

                if (flag) {
                    $http.post("hospital/accounts/chequeReconcilation/save", reconsidate).success(function(response) {
                        $scope.reconsidate.differentrecli = [];
                        if (response.success == true) {
                            logger.logSuccess("Data Saved Successfully");
                            $scope.table = '';
                        }
                    }).error(function(result) {
                        logger.logError("Error Please Try Again");
                    });
                }

            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.chequeReconsolationAddForm.$validationSummary), 555000, 'trustedHtml');
            }
        }
        $scope.dropdownvalue = function() {

            $http.get("hospital/accounts/chequeReconcilation/getDropdown").success(function(response) {
                if (response.success == true) {
                    $scope.bankList = response.lBankReconcilationBook;
                }
            }).error(function(result) {
                logger.logError("Error Please Try Again");
            });
        }
        $scope.dropdownvalue();
   // });

});