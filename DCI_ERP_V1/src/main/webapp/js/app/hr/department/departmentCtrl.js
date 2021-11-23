'use strict';
app.controller('departmentCtrl', function($scope, $rootScope, $http, $location, logger, utilsService,$state,sharedProperties,$window,ngDialog) {

        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.hideUploadIcon = true;
       
        $scope.emptyObject={};
        $scope.add = function() {
            $state.go('app.master.employee.department-Add');    
        };
        
        // Redirecting Page For Edit Functionality
        $scope.editRow = function(deptCode) {
            $location.url('/department/edit?deptCode='+deptCode);
        };
        
        
        $scope.getList = function() {
            var url = 'app/department/list?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount;
            $http.get(url).success(function(data) {
                if (data.success == true && !utilsService.isUndefinedOrNull(data.lDepartmentBean)) {
                    $scope.rowCollection = $scope.rowCollection.concat(data.lDepartmentBean);
                    sharedProperties.setObject($scope.emptyObject);
                }
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
            $scope.offsetCount = $scope.offsetCount + $scope.limitCount;
        };

        $scope.getList();
        
      

/**
 * Delete Row
 */
$scope.deleteRow = function(dCode) {
    ngDialog.openConfirm().then(function() {
    
        var url = 'app/department/delete?deptCode=' + dCode;
        $http.get(url).success(function(result){
            if (result ==  true) {
                logger.logSuccess("Deleted successfully");
                $state.reload();
           } else {
                logger.logError("You Can't Delete this Record, Related Data Exist! ");
            }
        }).error(function(result) {
            logger.logError("Error Please Try Again");
        });
    }, function(reason) {
        console.log('Modal promise rejected. Reason: ', reason);
    });
};




    });

