define([ 'hospital/asset/asset' ], function(module) {

'use strict';

    module.registerController('deprecationAppricationMethodListCtrl', function($scope,$state,$http,$location,ngDialog,logger) {
    
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.rowCollection = [];
        $scope.numPages=0

        $scope.getList=function(){
        $http.get("app/depreciationmethod/list").success(function(response) {
            $scope.rowCollection = response.depreciationList;
            // console.log($scope.rowCollection);
        });
    }
        $scope.getList();
        $scope.editRow = function(objItemCategory) {
            $location.url('/app/hospital/asset/depreciationAppreciationMethod/add?id='+ objItemCategory.depreciationMethodsId );
        };
        
        $scope.deleteRow = function(objItemCategory) {
            ngDialog.openConfirm().then(function() {
                $http.post("app/depreciationmethod/delete", objItemCategory.depreciationMethodsId).success(function(response) {
                    if (response.success == true) {
                        logger.logSuccess("Deleted successfully!");
                        $scope.getList();
                    }
                }).error(function(result) {
                    logger.logError("Error");
                });
            });
        }
        
        $scope.add = function(){
            $state.go("app.hospital.asset.deprecationApprecationMethod.add");
        };
        
    });
    
});