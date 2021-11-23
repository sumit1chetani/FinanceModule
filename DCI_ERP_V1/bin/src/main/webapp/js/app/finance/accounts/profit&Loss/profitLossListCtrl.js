//define([ 'hospital/accounts/accounts' ], function(module) {

    //'use strict';

    app.controller('profitLossListCtrl', function($scope, $state, $http, $controller, logger, ngDialog, $location, $injector, sharedProperties, toaster, $rootScope) {

        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages = 0;
        $scope.isDisplay = true;

        $scope.cancel = function() {
            $state.go("app.hospital.accounts.profit&Loss.searchlist")
        };
        $scope.deleteRow = function(automaticAttendanceList) {
            ngDialog.openConfirm().then(function() {
                $http.post("").success(function(response) {
                    if (response.success == true) {
                        logger.logSuccess("Deleted Successfully!");
                        $scope.getList();
                    }
                }).error(function(result) {
                    logger.logError("Error Please Try Again");
                });
            });
        };

   // })
});