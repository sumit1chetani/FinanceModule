//define([ 'hospital/accounts/accounts' ], function(module) {

   /// 'use strict';

    app.controller('exchangeRateAddCtrl', function($scope, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, validationService, $stateParams, $state, $filter) {

        $scope.currencyList = [];
        $scope.bookCurrencyList = [];
        $scope.bookCurrencyOldList = [];
        $scope.exchangeRateData = {
            currencyCode : '',
            bookCurrency : '',
            exchangeRateValue : '',
            exchangeRateDate : '',
            sourceDate : '',
            copyDate : ''
        };
        $scope.isEdit = false;

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
            $scope.exchangeRateData.exchangeRateDate = $scope.date;
            $scope.exchangeRateData.sourceDate = $scope.date;
            $scope.exchangeRateData.copyDate = $scope.date;
        }
        $scope.getCurrentDate();

        /**
         * validation
         */
        $scope.validate = function(exchangeRateForm, exchangeRateData) {
            debugger;
            if (new validationService().checkFormValidity($scope.exchangeRateForm)) {
                if (!$scope.isEdit) {
                    $scope.save(exchangeRateForm, exchangeRateData);
                } else {
                    $scope.save(exchangeRateForm, exchangeRateData);
                }
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.exchangeRateForm.$validationSummary), 555000, 'trustedHtml');
            }
        };

        /**
         * Dropdown functionality
         */
        $scope.getDropdownValue = function() {
            $http.get('app/exchangerate/getCurrencyList').success(function(datas) {
                $scope.currencyList = datas.currencyList;
            }).error(function(data) {
            });

            $http.get('app/exchangerate/getBookCurrencyList').success(function(datas) {
                $scope.bookCurrencyList = datas.currencyList;
                // $scope.bookCurrencyOldList = datas.currencyList;
            }).error(function(data) {
            });
        }
        $scope.getDropdownValue();

        /**
         * Filter 'Book Currency List' when 'Currency' selection based
         */
        $scope.loadCurrencyDetails = function() {
            $scope.$watch('exchangeRateData.currencyCode', function(newVal, oldVal, currencyObj) {
                debugger;
                if (currencyObj.bookCurrencyList.length > 0) {
                    if (newVal != undefined && newVal != "" && newVal != null) {
                        $scope.bookCurrencyList = $scope.bookCurrencyList.filter(function(obj) {
                            debugger;
                            return obj.id !== newVal;
                        });
                    }
                }
            });
        }

        /**
         * Filter 'Currency List', when 'Book Currency' selection based
         */
        $scope.loadBookCurrencyDetails = function() {
            $scope.$watch('exchangeRateData.bookCurrency', function(newVal, oldVal) {
                if (newVal != undefined && newVal != "" && newVal != null) {
                    /*
                     * $scope.currencyList =
                     * $scope.currencyList.filter(function(obj) { return obj.id
                     * !== newVal; });
                     */
                }
            });
        }

        var exchangeRateObj = angular.copy($scope.exchangeRateData, exchangeRateObj);
        var arrayOfValues = Object.keys(exchangeRateObj);
        $scope.checkWhichVariableHasUpdated = function(watchGroupList, newValuesObj, oldValuesObj) {
            var _lastUpdatedValue = null;
            angular.forEach(watchGroupList, function(value) {
                if (newValuesObj[value] != oldValuesObj[value])
                    _lastUpdatedValue = value;
            });
            $scope.selectedObj = newValuesObj;
            return _lastUpdatedValue;
        };

        // To load Dependent DropDown
        $scope.loadDropDown = function(changedVariable) {
            switch (changedVariable) {
            case "currencyCode":
                $scope.loadCurrencyDetails();
                break;
            case "bookCurrency":
                $scope.loadBookCurrencyDetails();
                break;
            }
        };

        // To watch a Object Collection
        $scope.$watchCollection('exchangeRateData', function(newVal, oldVal) {
            if (newVal != undefined) {
                var last_changed = $scope.checkWhichVariableHasUpdated(arrayOfValues, newVal, oldVal);
                if (angular.isDefined(last_changed) && last_changed != null) {
                    $scope.loadDropDown(last_changed);
                }
            }
        }, true);
        /**
         * Save and Update Functionality
         */

        $scope.save = function(exchangeRateForm, exchangeRateData) {
            if (!$scope.isEdit) {
                $http.post('app/exchangerate/save', $scope.exchangeRateData).success(function(result) {
                    if (result) {
                        logger.logSuccess("Saved Successfully!");
                        $state.go('app.finance.accounts.exchangeRate.list');
                    } else {
                        logger.logError("Not Saved!");
                        $state.go('app.finance.accounts.exchangeRate.list');
                    }
                }).error(function(result) {
                });

            } else {
                $http.post('app/exchangerate/update', $scope.exchangeRateData).success(function(result) {
                    if (result == true) {
                        logger.logSuccess("Updated Successfully!");
                        $state.go('app.finance.accounts.exchangeRate.list');
                    } else {
                        logger.logError("Not Updated!");
                        $state.go('app.finance.accounts.exchangeRate.list');
                    }
                }).error(function(result) {
                });
            }

        }
        /**
         * Edit functionality
         */
        var exchangeRateCodes = $stateParams.exchangeRateCode;
        if (exchangeRateCodes != 0 && exchangeRateCodes != undefined && exchangeRateCodes != "") {
            $scope.isEdit = true;
            $http.post("app/exchangerate/getExchangeRateListOnEdit", exchangeRateCodes).success(function(response) {
                $scope.exchangeRateData = response;
            });
        }

        /**
         * Copy Functionality
         */
        $scope.copyExchangeRate = function() {

            if ($scope.exchangeRateData.sourceDate != "" && $scope.exchangeRateData.copyDate != "") {
                var isValid = true;

                $scope.exchangeRateData.copyDate = $scope.exchangeRateData.copyDate;
                $scope.exchangeRateData.sourceDate = $scope.exchangeRateData.sourceDate;

                if ($scope.exchangeRateData.copyDate == $scope.exchangeRateData.sourceDate) {
                    isValid = false;
                }

                if (isValid) {
                    $http.post('app/exchangerate/copyExgRate', $scope.exchangeRateData).success(function(result) {
                        if (result) {
                            logger.logSuccess("Saved Successfully!");
                            $state.go('app.finance.accounts.exchangeRate.list');
                        } else {
                            logger.logError("There is no Record for these date range!");
                        }
                    }).error(function(result) {
                    });
                } else {
                    logger.logError("Source Date and Copy Date Should be Different!");
                    isValid = true;
                }
            } else {
                if ($scope.exchangeRateData.sourceDate == "")
                    logger.logError("Please Select a Source Date...!");
                else if ($scope.exchangeRateData.copyDate == "")
                    logger.logError("Please Select a Copy Date...!");
            }
        };

        /**
         * Cancel functionality
         */
        $scope.cancel = function() {
            $state.go("app.finance.accounts.exchangeRate.list");
        };

    });

//});