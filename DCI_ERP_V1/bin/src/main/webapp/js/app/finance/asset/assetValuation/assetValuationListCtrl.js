define([ 'hospital/inventory/inventory' ], function(module) {
'use strict';
module.registerController('assetValuationListCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {
    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
   
$scope.add=function()
{
    $state.go('app.hospital.asset.assetvaluation.add');
    }   
$scope.editRow=function(assetValList){
    $location.url('/hospital/asset/assetvaluation/add?assetValId='+assetValList.assetValId);
}


$scope.getList = function(){
    $http.get("hospital/asset/valuation/getValuationList").success(function(response) {
        console.log("List Loaded");
        console.log(response);
        $scope.rowCollection = response.valuationList;
    });
}
$scope.getList();



$scope.deleteRow = function(assetValId){
    ngDialog.openConfirm().then(function() {
        $http.post("hospital/asset/valuation/delete",assetValId).success(function(response) {
            if (response.success == true) {
                logger.logSuccess("Deleted Successfully");
                $scope.getList();
            }else{
                logger.logSuccess("Sorry, Can't delete.");
            }
        });
    });
}



});
});