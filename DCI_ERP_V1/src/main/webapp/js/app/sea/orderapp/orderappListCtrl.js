'use strict';

app.controller('orderappListCtrl', function($scope, $rootScope,ngDialog, $http, $location, logger,
        utilsService,$state,sharedProperties,$window,validationService,toaster,$stateParams) {
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages = 0;
        
        $scope.rowCollection = [];
        $scope.isDisplay = true;
        $scope.add = function(){
            $state.go("app.sea.orderapp.add");
        }
        $scope.getPurchaseOrderList = function(){
            var url = 'app/purchaseOrder/totalPurchaseList';
            $http.get(url).success(function(data) {
                if (data.success == true) {
                    $scope.rowCollection = data.purchaseOrders;
                 }
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        }
        $scope.getPurchaseOrderList();
        
        
        $scope.editRow =function(collections){
            $location.url('/master/orderapp/add?purchaseOrderId='+collections.purchaseOrderId);
           
        }
        
        $scope.deleteRow=function(collections){
            ngDialog.openConfirm().then(function() { 
            var url='app/master/orderapp/deletePurchaseOrder?purchaseOrderId='+collections.purchaseOrderId;
            $http.get(url).success(function(success){
                if(success){
                    logger.logSuccess("Purchase Order deleted successfully");
                    $scope.getPurchaseOrderList();
                }else{
                    logger.logError("Error Please Try Again");
                }
            }).error(function(data) {
                logger.logSuccess("Error in Delete!");
            });
            }, function(reason) {
                console.log('Modal promise rejected. Reason: ', reason);
            });
        };
        
        $scope.viewRow = function(collections){
        
                $location.url('/master/orderapp/view?purchaseOrderId='+collections.purchaseOrderId);
           
        }
        
   
    
});