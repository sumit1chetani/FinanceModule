'use strict';
app.controller('distanceCtrl', function($scope, $rootScope, ngDialog, $http, $location, logger, utilsService, $state, sharedProperties, $window,$stateParams) {

    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.hideUploadIcon = true;

    $scope.emptyObject = {};

    $scope.add = function() {
        $state.go('app.master.general.distance-Add',{tenantid:$stateParams.tenantid});
    };

    // Redirecting Page For Edit Functionality
   /* $scope.editRow = function(DistanceData) {
        sharedProperties.setObject(DistanceData);
        $scope.add();
    };*/
    

    $scope.editRow = function(dNo){
        $location.url($stateParams.tenantid+'/general/distance/edit?dNo='+dNo);
    }
    

    $scope.getList = function() {
        var url = $stateParams.tenantid+'/app/distance/list?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount;
        $http.get(url).success(function(data) {
            if (data.success == true && !utilsService.isUndefinedOrNull(data.lDistanceBean)) {
                $scope.rowCollection = $scope.rowCollection.concat(data.lDistanceBean);
                sharedProperties.setObject($scope.emptyObject);
            }
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
        $scope.offsetCount = $scope.offsetCount + $scope.limitCount;
    };

    $scope.getList();

    // remove to the real data holder
    $scope.deleteRow = function(dNo, index) {
        ngDialog.openConfirm().then(function() {
            var myURL = $stateParams.tenantid+'/app/distance/delete';
            $http({
                method : 'post',
                url : myURL,
                data : dNo,
            }).success(function(data) {
                if (data == true) {
                    var tableData = $scope.rowCollection;
                    $scope.rowCollection.splice(index, 1);
                    logger.logSuccess("deleted successfully");
                    $state.reload();
                } else {
                    logger.logError("You Can't Delete this Record, Related Data Exist!");
                }
            }).error(function(data) {
                logger.logSuccess("Error in Delete!");
            });
        });

    };
    
    $scope.view = function(distanceNo){
        $location.url($stateParams.tenantid+'/general/distance/view?dNo='+distanceNo);
    }

});