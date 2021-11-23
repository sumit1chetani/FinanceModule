define([ 'payroll/tds/tds' ], function(module) {
    'use strict';
    module.registerController('taxSection', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {
        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.isDisplay = true;

        $scope.taxSection = {
            taxSectionCode : '',
            taxSectionDescription : '',
            taxSectionMaxLimit : '',
            displayOrder : '',
            taxSectionStatus : false,
            isEdit : false

        };

        $scope.getList = function() {

            $http.get("payroll/tds/taxsection/list").success(function(response) {
                $scope.rowCollection = response.taxsectionList;

            });
        }
        $scope.getList();

        $scope.editRow = function(taxSectionCode) {
            $location.url('/payroll/taxsection/edit?taxSectionCode=' + taxSectionCode);
        }

        $scope.cancel = function() {
            $state.go('app.payroll.tds.taxsection.list');
        };

        $scope.deleteRow = function(taxSectionCode) {
            ngDialog.openConfirm().then(function() {
                $http.post("payroll/tds/taxsection/delete", taxSectionCode).success(function(response) {
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
});