'use strict';
app.controller('truckListCtrl', function($scope,$stateParams,logger , ngDialog,$rootScope, $http, $location, $log,  $modal, $window,$state) {

    $scope.showEmptyLabel = false;
    $scope.offsetCount = 0;
    $scope.limitCount = 100;
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    
    
    $scope.getList=function(){
        $http.get($stateParams.tenantid+'/truck/list').success(function(datas) {
            console.log(datas);
            $scope.rowCollection = datas.list;
        	
            }).error(function(datas) {
        });
        };
        $scope.getList();
    
   $scope.add = function() {
//	   $location.url(oldUrl);
             $state.go('app.truck.add');
        };
    
    $scope.editRow = function(obj){
    	$location.url('/' + $stateParams.tenantid+'/truck/edit?truckId=' + obj.truckid);
    }
    
 $scope.deleteRow = function(rowid) {
    	
        ngDialog.openConfirm().then(function() {
            var myURL = $stateParams.tenantid+'/truck/delete';
            $http({
                method : 'post',
                url : myURL,
                data : rowid.truckid,
            }).success(function(data) {
                if (data == true) {                    
                    logger.logSuccess("Deleted Successfully");
                    $state.reload();
                } else {
                    logger.logError("Unable to delete Record!");
                }
            }).error(function(data) {
                logger.logSuccess("Error in Delete!");
            });
        });

    };
    

    
  
    $scope.view = function(obj){
    	$location.url('/' + $stateParams.tenantid+'/truck/view?viewId=' + obj.truckid);
    }
    
    
       

});

