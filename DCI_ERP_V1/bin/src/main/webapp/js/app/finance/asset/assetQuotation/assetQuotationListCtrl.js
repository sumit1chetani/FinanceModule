define([ 'hospital/asset/asset' ], function(module) {

    'use strict';

    module.registerController('assetQuotationListCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {

        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages = 0;
        
        $scope.add = function(){
            $state.go("app.hospital.asset.assetQuotation.add");
        }
        
        $scope.getList = function(){
            $http.get("hospital/asset/quotation/getQuotationList").success(function(response) {
                console.log(response.quotationList)
                $scope.quotationList = response.quotationList;
            });
        }
        $scope.getList();
        
        
        $scope.editRow=function(collections){
            $location.url('/hospital/asset/assetQuotation/add?assetId='+collections.assetId);
        }
        
        
        $scope.deleteRow = function(quotationId){
            ngDialog.openConfirm().then(function() {
                $http.post("hospital/asset/quotation/delete",quotationId).success(function(response) {
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