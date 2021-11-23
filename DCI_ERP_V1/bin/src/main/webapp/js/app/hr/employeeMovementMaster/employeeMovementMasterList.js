//define([ 'hrms/hr/hr' ], function(module) {

    'use strict';

    app.Controller('movementMasterListCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {
        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.isDelete = true;
        $scope.isUpload = true;

        $scope.getList = function() {
            $http.get("hrms/hr/employeeinfo/employeeMovementMaster/list").success(function(response) {
                $scope.rowCollection = response.employeeMovementMasterList;
            });
        };
        $scope.getList();

        $scope.add = function() {
            $state.go("app.hr.employeeMovementMaster.add");
        }

        $scope.editRow = function(empMovementMaster) {
            $location.url('/employeeInfo/employeeMovementMaster/add?empMoveId=' + empMovementMaster.empSk);
        }

        $scope.deleteRow = function(empMovementMasterDel) {
            ngDialog.openConfirm().then(function() {
                if (empMovementMasterDel.status == 1) {
                    logger.logError("Approved record cannot be deleted")
                } else {
                    $http.post("hrms/hr/employeeinfo/employeeMovementMaster/delete", empMovementMasterDel.empSk).success(function(response) {
                        if (response.success == true) {
                            logger.logSuccess("Deleted Successfully!");
                            $scope.getList();
                        } else {
                            if (response.message != '') {
                                logger.logError(response.message);
                            }
                        }
                    }).error(function(result) {
                        logger.logError("Error Please Try Again");
                    });
                }
            });
        };
    });
//});