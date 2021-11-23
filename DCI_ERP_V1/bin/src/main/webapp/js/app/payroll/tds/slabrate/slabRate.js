define([ 'payroll/tds/tds' ], function(module) {
    'use strict';
    module.registerController('slapRateCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {
        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;

        $scope.slabRate = {
            taxRateId : '',
            financialYear : '',
            taxPayerTypeId : '',
            rangeFrom : '',
            rangeTo : '',
            rateInPercentage : '',
            isEdit : false

        };

        $scope.isDelete = true;
        $scope.isUpload = true;

        $scope.getList = function() {

            $http.get("payroll/tds/slabrate/list").success(function(response) {
                $scope.rowCollection = response.slabRateList;
            });
        }
        $scope.getList();

        $scope.add = function() {
            $state.go('app.payroll.tds.slabrate.add');
        };

        $scope.editRow = function(taxRateId) {
            $location.url('/payroll/slabrate/edit?taxRateId=' + taxRateId);
        };

        $scope.cancel = function() {
            $state.go('app.payroll.tds.slabrate.list');
        };

        $scope.deleteRow = function(taxRateId) {
            ngDialog.openConfirm().then(function() {
                $http.post("payroll/tds/slabrate/delete", taxRateId).success(function(response) {
                    if (response == true) {
                        logger.logSuccess("Deleted Successfully!");
                        $scope.getList();
                    }
                }).error(function(result) {
                    logger.logError("Error Please Try Again");
                });
            });
        };
    });
});