define([ 'payroll/tds/tds' ], function(module) {

    'use strict';

    module.registerController('taxSectionAddCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService) {

        $scope.taxSection = {
            taxSectionCode : '',
            taxSectionDescription : '',
            taxSectionMaxLimit : '',
            displayOrder : '',
            taxSectionStatus : false,
            isEdit : false

        };

        $scope.isEdit = false;

        $scope.departmentList = [];
        $scope.employeeList = [];
        $scope.empDataList = [];

        var taxSectionCode = $location.search().taxSectionCode;
        if (taxSectionCode == undefined) {
            $scope.taxSection.isEdit = false;
        } else {

            $http.post('payroll/tds/taxsection/edit', taxSectionCode).success(function(result) {
                if (result.isEdit == false) {
                    logger.logError("Please Try Again");
                } else {
                    $scope.taxSection = result;
                }

            }).error(function(data) {

            });
        }

        $scope.cancel = function() {

            $state.go('app.payroll.tds.taxsection.list');
        };

        $scope.submit = function(taxSectionForm) {
            if (new validationService().checkFormValidity(taxSectionForm)) {
                if ($scope.taxSection.isEdit != true) {
                    var saveData = $scope.taxSection;
                    $http.post("payroll/tds/taxsection/save", saveData).success(function(result) {
                        if (result == false) {
                            logger.logError("Tax Section Code already exist");
                        } else {
                            $state.go('app.payroll.tds.taxsection.list');
                        }

                    })
                }
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(taxSectionForm.$validationSummary), 5000, 'trustedHtml');
            }

        }
        $scope.update = function(taxSectionForm) {
            if (new validationService().checkFormValidity(taxSectionForm)) {
                var updateData = $scope.taxSection;
                $http.post('payroll/tds/taxsection/update', updateData).success(function(result) {
                    if (result == false) {

                    } else {
                        logger.logSuccess("Tax Section Code updated successfully");
                        $state.go('app.payroll.tds.taxsection.list');
                    }
                });
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(taxSectionForm.$validationSummary), 5000, 'trustedHtml');
            }

        }

    });

})