define([ 'hospital/purchase/purchase' ], function(module) {

    'use strict';

    module.registerController('mergePurchaseOrderListCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller,
            $injector, sharedProperties, toaster, $rootScope,$filter) {


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
            var url = 'app/purchaseOrder/purchaseMergeList';
            $http.get(url).success(function(data) {
                if (data.success == true) {
                    $scope.rowCollection = data.purchaseOrders;
                 }
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        };
        $scope.getPurchaseOrderList();
        
        
        $scope.mergePurchaseOrder =function(displayedCollection){
            var foundItem = $filter('filter')($scope.rowCollection, { isSelected: true });
            if(foundItem.length > 2){
                for(var i=0;i<foundItem.length;i++){
                      var index =  $scope.rowCollection.indexOf(foundItem[i]); 
                      $scope.rowCollection[index].isSelected = false;
                }
                logger.logError("Please select only two Purchase Orders to merge.");
            }else if(foundItem.length == 2){
                var cancelPurchaseOrder = foundItem[0];
                var foundEqualItem = $filter('filter')(foundItem, { locationId: cancelPurchaseOrder.locationId,
                    statusId :cancelPurchaseOrder.statusId,vendorId:cancelPurchaseOrder.vendorId  });
               if(foundEqualItem.length ==2){
                   var cancelPurchaseOrderId = foundEqualItem[0].purchaseOrderId;
                   var mergePurchaseOrderId =  foundEqualItem[1].purchaseOrderId;
                   $scope.save(cancelPurchaseOrderId,mergePurchaseOrderId);
               }else{
                   logger.logError("Please select two Purchase Orders having same Location Status and Vendor.");
                   foundItem[0].isSelected =false;
                   foundItem[1].isSelected = false;
               }
            }
            else{
                var index =  $scope.rowCollection.indexOf(foundItem[0]);
                $scope.rowCollection[index].isSelected = false;
                logger.logError("Please select two Purchase Orders to merge.");
            }
        };
        
        $scope.save = function(cancelPurchaseOrderId,mergePurchaseOrderId){
            var url = 'app/purchaseOrder/updatemergePurchaseOrder?cancelpurchaseOrderId='+ cancelPurchaseOrderId+
            '&mergepurchaseOrderId='+mergePurchaseOrderId;
            $http.get(url).success(function(result) {
                console.log(result);
                if(result.success){
                    logger.logSuccess("Purchase Order Merged successfully");
                    $scope.getPurchaseOrderList();
                }else{
                    logger.logError("Purchase not updated");
                    return false;
                }
            });
        };
        
    });
    
});