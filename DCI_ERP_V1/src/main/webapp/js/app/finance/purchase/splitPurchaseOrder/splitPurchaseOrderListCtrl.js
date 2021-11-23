define([ 'hospital/purchase/purchase' ], function(module) {

    'use strict';

    module.registerController('splitPurchaseOrderListCtrl', function($scope, $state, $http, ngDialog, logger, $location,
            $controller, $injector, sharedProperties, toaster, $rootScope) {

        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages = 0;
        $scope.isUpload = false;
        $scope.rowCollection = [];
        $scope.statusList=[];
        $scope.itemList = [];
        $scope.vendorList = [];
        
        $scope.isDisplay = true;
        $scope.getPurchaseOrderList = function(){
            var url = 'app/purchaseOrder/purchaseSplitList';
            $http.get(url).success(function(data) {
                if (data.success == true) {
                    $scope.rowCollection = data.purchaseOrders;
                 }
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        };
        $scope.getPurchaseOrderList();
        
        $scope.getListOfDropdowns = function() {
            $http.get('app/purchaseOrder/filterDropDownList').success(function(data) {
                if (data.success == true) {
                    $scope.itemList=data.itemList;
                    $scope.vendorList = data.vendorList;
                    $scope.statusList= data.purchaseStatus;
                   
                  
                }
            });
        };
        $scope.getListOfDropdowns();
        
        $scope.editRow =function(collections){
            $location.url('/hospital/purchase/splitPurchaseOrder/add?purchaseOrderId='+collections.purchaseOrderId);
           
        };
        
    
        
        
    });
    
});