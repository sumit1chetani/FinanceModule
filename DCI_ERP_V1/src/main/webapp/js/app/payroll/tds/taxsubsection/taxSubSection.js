define([ 'payroll/tds/tds' ], function(module) {
    'use strict';
    module.registerController('taxSubSectionCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {
        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;

        $scope.isDisplay = true;

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

        $scope.getList = function() {

            $http.get("payroll/tds/taxsubsection/list").success(function(response) {
                $scope.rowCollection = response.taxSubSectionList;

            });
        }
        $scope.getList();

        $scope.editRow = function(taxSubSectionCode) {
            $location.url('/payroll/taxsubsection/edit?taxSubSectionCode=' + taxSubSectionCode);
        }
        $scope.cancel = function() {
            $state.go('app.payroll.tds.taxsubsection.list');
        };
        $scope.deleteRow = function(taxSubSectionCode) {
            ngDialog.openConfirm().then(function() {
                $http.post("payroll/tds/taxsubsection/delete", taxSubSectionCode).success(function(response) {
                    if (response == true) {
                        logger.logSuccess("Taxsub section code deleted successfully!");
                        $scope.getList();
                    }
                }).error(function(result) {
                    logger.logError("Error Please Try Again");
                });
            });
        };
    });
});