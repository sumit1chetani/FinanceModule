define([ 'hospital/purchase/purchase' ], function(module) {

    'use strict';

    module.registerController('cancelPurchaseOrderListCtrl', function($scope, $state, $http, ngDialog, logger, $location,
            $controller, $injector, sharedProperties, toaster, $rootScope) {

        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages = 0;
        
        $scope.rowCollection = [];
        $scope.isDisplay = true;
        $scope.add = function(){
            $state.go("app.hospital.purchase.cancelPurchaseOrder.add");
        };
        $scope.getPurchaseOrderList = function(){
            var url = 'app/purchaseOrder/cancelPurchaseList';
            $http.get(url).success(function(data) {
                if (data.success == true) {
                    $scope.rowCollection = data.purchaseOrders;
                 }
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        };
        $scope.getPurchaseOrderList();
        
        
        $scope.editRow =function(collections){
            $location.url('/hospital/purchase/cancelPurchaseOrder/add?purchaseOrderId='+collections.purchaseOrderId);
           
        };
          
        $scope.viewRow = function(collections){
                $location.url('/hospital/purchase/cancelPurchaseOrder/view?purchaseOrderId='+collections.purchaseOrderId);
        };
        
    });
    
});