define([ 'payroll/tds/tds' ], function(module) {

    'use strict';

    module.registerController('nscintersetCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService) {

        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;

        $scope.nscinterest = {
            financialYear : '',
            rateOfInterest : '',
            isEdit : false
        };

        $scope.isEdit = false;

        $scope.editRow = function(financialYear) {
            $scope.nscinterest.isEdit = true;
            $http.post('payroll/tds/nscinterest/edit', financialYear).success(function(result) {
                if (result.isEdit == false) {
                    logger.logError("Please Try Again");
                } else {
                    $scope.nscinterest = result.nscInterestBean;

                }

            });

        }

        $scope.getList = function() {

            $http.get("payroll/tds/nscinterest/list").success(function(response) {
                $scope.rowCollection = response.nscInterestList;

            });
        }
        $scope.getList();

        $scope.getFinancialYear = function() {

            $http.get("payroll/tds/ptslab/getLoginfinancialYear").success(function(datas) {
                $scope.financialYearList = datas.financialYearList;

            })
        }

        $scope.submit = function(nscIntersetForm) {
            if (new validationService().checkFormValidity(nscIntersetForm)) {
                if ($scope.nscinterest.isEdit != true) {
                    var saveData = $scope.nscinterest;

                    $http.post("payroll/tds/nscinterest/save", saveData).success(function(result) {
                        if (result == false) {
                            logger.logError("Nsc interest Code already exist");
                        } else {
                            $scope.getList();

                        }

                    });

                } else {
                    toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(nscIntersetForm.$validationSummary), 5000, 'trustedHtml');
                }

            }
        }

        $scope.update = function(nscIntersetForm) {
            if (new validationService().checkFormValidity(nscIntersetForm)) {
                var updateData = $scope.nscinterest;
                $http.post('payroll/tds/nscinterest/update', updateData).success(function(result) {
                    if (result == false) {

                    } else {
                        logger.logSuccess("Nsc Interest updated successfully");
                        $scope.getList();
                        $scope.nscinterest.financialYear = "";
                        $scope.nscinterest.rateOfInterest = "";
                        $scope.nscinterest.isEdit = false;

                    }
                });
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(nscIntersetForm.$validationSummary), 5000, 'trustedHtml');
            }
        }

        $scope.getFinancialYear();

    });

})