define([ 'payroll/tds/tds' ], function(module) {

    'use strict';

    module.registerController('slabRateAddCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService) {

        $scope.slabRate = {
            taxRateId : '',
            financialYear : '',
            taxPayerTypeId : '',
            rangeFrom : '',
            rangeTo : '',
            rateInPercentage : '',
            isEdit : false

        };

        $scope.isEdit = false;

        $scope.payerTypeList = [];

        var taxRateId = $location.search().taxRateId;
        if (taxRateId == undefined) {
            $scope.slabRate.isEdit = false;
        } else {

            $http.post("payroll/tds/slabrate/edit", taxRateId).success(function(response) {
                if (response.slabRate != null) {
                    $scope.slabRate = response.slabRate;
                    $scope.slabRate.isEdit = true;
                }
            });

        }

        $scope.getPayerTypeList = function() {
            $http.get("payroll/tds/slabrate/payertypelist").success(function(datas) {
                $scope.payerTypeList = datas.payerTypeList;
            }).error(function(data) {

            });
        };

        $scope.getFinancialYear = function() {
            $http.get("payroll/tds/ptslab/getLoginfinancialYear").success(function(datas) {
                $scope.financialYearList = datas.financialYearList;

            })
        }

        $scope.getFinancialYear();

        $scope.getPayerTypeList();

        $scope.submit = function(slabRateForm) {
            if (new validationService().checkFormValidity(slabRateForm)) {
                if ($scope.slabRate.isEdit != true) {
                    var saveData = {
                        taxRateId : '',
                        financialYear : $scope.slabRate.financialYear,
                        taxPayerTypeId : $scope.slabRate.taxPayerTypeId,
                        rangeFrom : $scope.slabRate.rangeFrom,
                        rangeTo : $scope.slabRate.rangeTo,
                        rateInPercentage : $scope.slabRate.rateInPercentage
                    };

                    if ($scope.slabRate.rangeTo > $scope.slabRate.rangeFrom) {
                        $http.post("payroll/tds/slabrate/save", saveData).success(function(result) {
                            if (result == false) {
                                logger.logError("Sorry Some Error occurred");
                            } else {
                                logger.logSuccess("New Slab Rate entry added successfully");
                                $state.go('app.payroll.tds.slabrate.list');
                            }

                        });

                    } else {
                        logger.logError("Ranage To value should be greater than the Range From");
                    }

                }
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(slabRateForm.$validationSummary), 5000, 'trustedHtml');
            }
        }

        $scope.update = function(slabRateForm) {
            if (new validationService().checkFormValidity(slabRateForm)) {
                var slabRateBean = {
                    taxRateId : $scope.slabRate.taxRateId,
                    financialYear : $scope.slabRate.financialYear,
                    taxPayerTypeId : $scope.slabRate.taxPayerTypeId,
                    rangeFrom : $scope.slabRate.rangeFrom,
                    rangeTo : $scope.slabRate.rangeTo,
                    rateInPercentage : $scope.slabRate.rateInPercentage
                };
                if ($scope.slabRate.rangeTo > $scope.slabRate.rangeFrom) {
                    $http.post('payroll/tds/slabrate/update', slabRateBean).success(function(result) {
                        if (result == false) {
                            logger.logError("Sorry Some Error occurred");
                        } else {
                            logger.logSuccess("Slab Rate changes updated successfully");
                            $state.go('app.payroll.tds.slabrate.list');
                        }
                    });
                } else {
                    logger.logError("Ranage To value should be greater than the Range From");

                }

            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(slabRateForm.$validationSummary), 5000, 'trustedHtml');
            }
        }
        $scope.cancel = function() {
            $state.go('app.payroll.tds.slabrate.list');
        };
    });

    module.registerDirective('phonenumbersOnly', function(logger) {

        return {
            require : 'ngModel',
            link : function(scope, element, attrs, modelCtrl) {

                modelCtrl.$parsers.push(function(inputValue) {
                    var inputValue = modelCtrl.$viewValue;
                    if (inputValue == undefined)
                        return ''
                    var transformedInput = inputValue.replace(/[^0-9]/g, '');
                    if (transformedInput != inputValue) {
                        modelCtrl.$setViewValue(transformedInput);
                        modelCtrl.$render();
                    } else {

                    }

                    return transformedInput;
                });
            }
        };
    });

});