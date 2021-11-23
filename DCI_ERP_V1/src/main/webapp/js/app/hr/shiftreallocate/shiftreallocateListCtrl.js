
    'use strict';

    app.controller('shiftreallocateListCtrl', function($scope, $state, $http, $stateParams ,$location, ngDialog, logger) {


        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.isDelete = true;
        $scope.isUpload = true;
        $scope.numPages = 0;

        $scope.add = function() {
            $state.go("app.hr.shiftreallocate.add",{tenantid:$stateParams.tenantid});
        };

        $scope.getList = function() {
            $http.get("hrms/hr/shiftreallocationnew/list").success(function(response) {
                $scope.rowCollection = response.shiftReAllocationList;
            });
        };

        $scope.getList();

        $scope.editRow = function(employeeId, fromDate, toDate) {
            $location.url('/hrms/hr/shiftReAllocationnew/edit?employeeId=' + employeeId + '&fromDate=' + fromDate + '&toDate=' + toDate);
        }

        /**
         * Delete Row
         */
        $scope.deleteRow = function(employeeId, shiftCode, index) {
            ngDialog.openConfirm().then(function() {
                var url = 'hrms/hr/shiftreallocationnew/delete?shiftCode=' + shiftCode + '&employeeId=' + employeeId;
                $http.get(url).success(function(data) {

                    if (data == true) {
                        var tableData = $scope.rowCollection;
                        $scope.rowCollection.splice(index, 1);
                        logger.logSuccess("Deleted successfully");
                        $state.reload();
                    } else {
                        logger.logError("Error in deleting Shift ReAllocation!");
                    }
                }).error(function(data) {
                    logger.logError("Error in Delete!");
                });
            });

        };

    });
