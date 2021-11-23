'use strict';
app.controller('containerTypeListCtrl', function($scope,ngDialog,$stateParams,logger,$rootScope, $http, $location, $log,  $modal, $window,$state) {

    $scope.showEmptyLabel = false;
    $scope.offsetCount = 0;
    $scope.limitCount = 100;
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    
    
   $scope.add = function() {
//	   $location.url(oldUrl);
             $state.go('app.master.generalcontainertype.add');
        };
    
    $scope.editRow = function(containerType){
    	$location.url($stateParams.tenantid+'/containerType/edit?containerType=' + containerType);
    }
    
      
    $scope.view = function(containerType) {
    	$location.url($stateParams.tenantid+'/containerType/view?containerType=' + containerType); 
     }
    
    $scope.getList = function() {
        var url =$stateParams.tenantid+ '/containertype/request/list';
        $http.get(url).success(function(data) {
            
            if (data) {
                $scope.rowCollection = data;
               
            }
            $scope.showEmptyLabel = $scope.rowCollection.length == 0 ? true : false;
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
        $scope.offsetCount = $scope.limitCount + $scope.offsetCount;
    };

    $scope.getList();

    $scope.deleteRow = function(containerTypeId) {
    	
        ngDialog.openConfirm().then(function() {
            var myURL = $stateParams.tenantid+'/containertype/request/delete?containertype='+containerTypeId;
            $http({
                method : 'post',
                url : myURL,
                data : containerTypeId,
            }).success(function(data) {
                if (data == true) {                    
                    logger.logSuccess("Deleted Successfully");
                    $state.reload();
                } else {
                    logger.logError("Error in Delete");
                }
            }).error(function(data) {
                logger.logError("Error in deleting Record!");
            });
        });

    };

});

app.controller('deleteContainerTypeCtrl', function($scope, $rootScope, $modalInstance,
		$http, $state, $stateParams) {
	var containerTypeId = $modalInstance.containerTypeId;

	$scope.deleteContType = function() {
		$http.post('/' + $stateParams.tenantid + '/containertype/request/delete',containerTypeId).success(function(data) {
					if (data) {
						$scope.cancelPop();
						$state.reload();
					}
				})
	}

	$scope.cancelPop = function() {
		$modalInstance.dismiss('cancel');
	};

});