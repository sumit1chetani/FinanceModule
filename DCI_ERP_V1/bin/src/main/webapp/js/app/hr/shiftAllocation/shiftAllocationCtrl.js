'use strict';
app.controller('shiftAllocationCtrl', function($scope, $state, $http, $location, ngDialog, logger,$stateParams) {
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;

    $scope.numPages = 0;
    $scope.isDelete = true;
    $scope.isUpload = true;

    $scope.add = function() {
        $state.go("app.hr.shiftAllocation.add");
    };

    $scope.getList = function() {
    	debugger;
        $http.get($stateParams.tenantid+"/hr/shiftAllocation/list").success(function(response) {
            $scope.rowCollection = response.shiftAllocationList;
        });
    };

    $scope.getList();

    $scope.editRow = function(schemeId, employeeId, validFrom, validTo) {
        $location.url($stateParams.tenantid+'/hr/shiftAllocation/edit?schemeId=' + schemeId + '&employeeId=' + employeeId + '&validFrom=' + validFrom + '&validTo=' + validTo);
    }

    /**
     * Delete Row
     */
    $scope.deleteRow = function(objShiftAllocation, index) {
        ngDialog.openConfirm().then(function() {
            var url = $stateParams.tenantid+'/hr/shiftAllocation/delete?schemeId=' + objShiftAllocation.schemeId + '&employeeId=' + objShiftAllocation.employeeId + '&validFrom=' + objShiftAllocation.validFrom + '&validTo=' + objShiftAllocation.validTo;
            $http.get(url).success(function(data) {
                if (data == true) {

                    logger.logSuccess("Deleted successfully");
                    $scope.getList();

                } else {
                    logger.logError("Error in deleting Shift Allocation!");
                }
            }).error(function(data) {
                logger.logError("Error in Delete!");
            });
        });

    };

});
