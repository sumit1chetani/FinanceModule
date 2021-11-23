//define([ 'hospital/accounts/accounts' ], function(module) {

    //'use strict';

    app.controller('currencyAddCtrl', function($scope, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, validationService, $stateParams, $state) {
        $scope.currencyList = [];
        $scope.edit = false;
        $scope.currencyMaster = {
            currencyCode : '',
            currencyName : '',
            symbol : '',
            fromCurrency : '',
            currencyDefault : '',
            toCurrency : '',
            currencyFraction : '',
            bookCurrency : 'N',
            isActive : 'Y'
        };
        $scope.uniqueCurrencyCode = false;
        $scope.uniqueCurrencyName = false;
        $scope.getCurrencyList = function() {
            $http.get("app/currencyNew/list").success(function(response) {
                if (response.lCurrencyBean.length > 0) {
                    $scope.currencyList = response.lCurrencyBean;
                } else {
                    $scope.currencyList = [];
                }

            });
        };
        $scope.getCurrencyList();

        /**
         * Duplicate
         */
        
        
//        $scope.currencyMaster.isActive = 'Y';
        
        $scope.verifyUniqueCurrencyCode = function(currency) {

            var flag = true, msg = '';
            angular.forEach($scope.currencyList, function(key, index) {

                if (currency == key.currencyCode) {
                    msg = "Currency Code Already Exists..!";
                    flag = false;
                }
            });

            if (!flag) {
                logger.logError(msg);
            }
            return flag;
        };

        /**
         * validation
         */
        $scope.validate = function(currencyForm, currencyMaster) {

            if (new validationService().checkFormValidity($scope.currencyForm)) {
                if (!$scope.edit) {
                    if ($scope.verifyUniqueCurrencyCode($scope.currencyMaster.currencyCode))
                        $scope.save(currencyForm, currencyMaster);
                } else {
                    $scope.save(currencyForm, currencyMaster);
                }
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.currencyForm.$validationSummary), 555000, 'trustedHtml');
            }
        };

        /**
         * Edit Functionality *************************************
         */
        var currencyCodes = $stateParams.currencyCode;
        if (currencyCodes != 0 && currencyCodes != undefined && currencyCodes != "") {
            $scope.edit = true;
            $http.post("app/currencyNew/edit", currencyCodes).success(function(response) {
                if (response.success == true) {
                    $scope.currencyMaster = response.objCurrencyBean;
                    if (response.objCurrencyBean.isActive == "t") {
                        $scope.currencyMaster.isActive = 'Y';
                    } else {
                        $scope.currencyMaster.isActive = 'N';
                    }

                    if (response.objCurrencyBean.bookCurrency == "t") {
                        $scope.currencyMaster.bookCurrency = 'Y';
                    } else {
                        $scope.currencyMaster.bookCurrency = 'N';
                    }
                }
            });
        }

        /**
         * save and update functionality ********************************
         */

        $scope.save = function(currencyMasterForm) {
            if (!$scope.edit) {
                $http.post("app/currencyNew/save", $scope.currencyMaster).success(function(response) {
                    if (response == true) {
                        logger.logSuccess("Saved Successfully!");
                        $state.go("app.hospital.accounts.currency.list");
                    } else {
                        logger.logError("Error In Save!");
                    }
                });
            } else {
                $http.post("app/currencyNew/update", $scope.currencyMaster).success(function(response) {
                    if (response == true) {
                        logger.logSuccess("Updated Successfully!");
                        $state.go("app.hospital.accounts.currency.list");
                    } else {
                        logger.logError("Error In Update!");
                    }
                });
            }
        };

        /**
         * Reset Functionality ********************************
         */

        var originalCurrencyDatas = angular.copy($scope.currencyMaster);

        $scope.reset = function(currencyMasterForm) {

            if ($scope.edit == true) {
                var currencyCode = $scope.currencyMaster.currencyCode;

                $http.post("app/currencyNew/edit", currencyCode).success(function(response) {
                    if (response.success == true) {
                        $scope.currencyMaster = response.objCurrencyBean;
                        if (response.objCurrencyBean.isActive == "t") {
                            $scope.currencyMaster.isActive = 'Y';
                        } else {
                            $scope.currencyMaster.isActive = 'N';
                        }

                        if (response.objCurrencyBean.bookCurrency == "t") {
                            $scope.currencyMaster.bookCurrency = 'Y';
                        } else {
                            $scope.currencyMaster.bookCurrency = 'N';
                        }
                    }
                });
            } else {
                $scope.currencyMaster = angular.copy(originalCurrencyDatas);
                $scope.currencyForm.$setPristine();
            }
        };

        $scope.cancel = function() {
            $state.go("app.finance.accounts.currency.list");
        }

    });

//});