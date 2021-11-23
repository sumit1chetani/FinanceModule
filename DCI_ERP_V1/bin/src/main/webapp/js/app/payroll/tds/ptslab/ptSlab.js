define([ 'payroll/tds/tds' ], function(module) {
    'use strict';
    module.registerController('ptSlapCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {
        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;

        $scope.ptSlab = {
            serialNumber : '',
            branchId : '',
            rangeFrom : '',
            rangeTo : '',
            charge : '',
            branchName : '',
            companyName : '',
            companyId : '',
            financialYear : '',
            isEdit : false
        };

        $scope.getList = function() {

            $http.get("payroll/tds/ptslab/list").success(function(response) {
                $scope.rowCollection = response.professionalTaxSlabList;

            });
        }

        $scope.editRow = function(branchId, financialYear, rangeFrom) {
            $location.url('/payroll/ptslab/edit?branchId=' + branchId + '&financialYear=' + financialYear + '&rangeFrom=' + rangeFrom);
        }

        $scope.getList();

        $scope.deleteRow = function(branchId, financialYear, rangeFrom) {
            ngDialog.openConfirm().then(function() {
                var resultBean = {
                    financialYear : financialYear,
                    branchId : branchId,
                    rangeFrom : rangeFrom
                };
                $http.post("payroll/tds/ptslab/delete", resultBean).success(function(response) {
                    if (response == true) {
                        logger.logSuccess("Deleted Successfully!");
                        $scope.getList();
                    }
                }).error(function(result) {
                    logger.logError("Error Please Try Again");
                });
            });
        };

        $scope.add = function() {

            $state.go('app.payroll.tds.ptslab.add');
        };
        $scope.cancel = function() {

            $state.go('app.payroll.tds.ptslab.list');
        };
    })

});
