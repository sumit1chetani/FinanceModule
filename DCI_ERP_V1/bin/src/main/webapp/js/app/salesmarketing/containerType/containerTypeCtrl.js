'use strict';
app.controller('containerTypeCtrl', function($scope, $rootScope, $http, $location, logger, $log, ngDialog, $modal, utilsService, $window,$state,sharedProperties) {

    $scope.showEmptyLabel = false;
    $scope.offsetCount = 0;
    $scope.limitCount = 100;
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    
    
   $scope.add = function() {
       sharedProperties.setObject($scope.emptyObject);
             $state.go('app.salesmarketing.containerType.add');
        };
    
    $scope.getList = function() {
        var url = 'containertype/request/list?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount;
        $http.get(url).success(function(data) {
            
            if (data.success == true && !utilsService.isUndefinedOrNull(data.lContainerRequest)) {
                $scope.rowCollection = $scope.rowCollection.concat(data.lContainerRequest);
               //sharedProperties.setObject($scope.emptyObject);
            }
            $scope.showEmptyLabel = $scope.rowCollection.length == 0 ? true : false;
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
        $scope.offsetCount = $scope.limitCount + $scope.offsetCount;
    };

    $scope.getList();
    
    $scope.editbookingRequest = function(objItem) {            
        sharedProperties.setObject(objItem);
        $state.go('app.salesmarketing.containerType.add');
   } 
    
    $scope.deleteRow = function(container_type_id) {
             
        

        ngDialog.openConfirm().then(function() {
            var myURL = 'containertype/request/delete';
            $http({
                method : 'post',
                url : myURL,
                data : container_type_id,
            }).success(function(data) {
                if (data == true) {
                    logger.logSuccess("Data Deleted successfullyy");
                    $state.reload();
                } else {
                    logger.logError("Data Not Deleted!");
                }
            }).error(function(data) {
                logger.logSuccess("Error in Updating Type!");
            });
            console.log('Modal promise resolved. Value: ');
        }, function(reason) {
            console.log('Modal promise rejected. Reason: ', reason);
        });
    };

});