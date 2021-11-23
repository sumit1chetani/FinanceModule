define([ 'payroll/tds/tds' ], function(module) {

    'use strict';

    module.registerController('taxSubSectionAddCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService) {

        $scope.taxSubSection = {
            taxSubSectionCode : '',
            taxSectionCode : '',
            taxSubSectionDescription : '',
            taxSubSectionMaxLimit : '',
            computed : '',
            displayOrder : '',
            taxSubSectionStatus : false,
            isEdit : false

        };
        $scope.isDisplay = true;
        $scope.taxSectionList = [];

        $scope.isEdit = false;
        $scope.getTaxSectionList = function() {

            $http.get("payroll/tds/taxsubsection/taxsectionlist").success(function(response) {
                $scope.taxSectionList = response.taxSectionList;

            });
        }

        $scope.getTaxSectionList();

        var taxSubSectionCode = $location.search().taxSubSectionCode;
        if (taxSubSectionCode == undefined) {
            $scope.taxSubSection.isEdit = false;
        } else {

            $http.post('payroll/tds/taxsubsection/edit', taxSubSectionCode).success(function(result) {
                if (result.isEdit == false) {
                    logger.logError("Please Try Again");
                } else {
                    $scope.getTaxSectionList();
                    $scope.taxSubSection = result.taxSubSection;
                }

            }).error(function(data) {

            });
        }

        $scope.cancel = function() {
            $state.go('app.payroll.tds.taxsubsection.list');
        };

        $scope.submit = function(taxSubSectionForm) {
            if (new validationService().checkFormValidity(taxSubSectionForm)) {
                if ($scope.taxSection.isEdit != true) {
                    var saveData = $scope.taxSubSection;

                    $http.post("payroll/tds/taxsubsection/save", saveData).success(function(result) {
                        if (result == false) {
                            logger.logError("Error occurred Please try again later");
                        } else {
                            $state.go('app.payroll.tds.taxsubsection.list');
                        }

                    });

                }
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(taxSubSectionForm.$validationSummary), 5000, 'trustedHtml');
            }
        }
        $scope.update = function(taxSubSectionForm) {
            if (new validationService().checkFormValidity(taxSubSectionForm)) {
                var updateData = $scope.taxSubSection;
                $http.post('payroll/tds/taxsubsection/save', updateData).success(function(result) {
                    if (result == false) {
                        logger.logError("Sorry some error occurred. Please try again later.");
                    } else {
                        logger.logSuccess("Tax Section Code updated successfully");
                        $state.go('app.payroll.tds.taxsubsection.list');
                    }
                });

            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(taxSubSectionForm.$validationSummary), 5000, 'trustedHtml');
            }
        }
    });

});