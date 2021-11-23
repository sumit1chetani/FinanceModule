define([ 'hospital/purchase/purchase' ], function(module) {

    'use strict';

    module.registerController('managePOListCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller,
            $injector, sharedProperties, toaster, $rootScope) {
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages = 0;
        $scope.isDisplay = true;
        $scope.isUpload = true;
        $scope.rowCollection = [];
        $scope.statusList=[];
        $scope.itemList = [];
        $scope.vendorList = [];
        $scope.add = function(){
            $state.go("app.hospital.purchase.purchaseOrder.add");
        }
        $scope.purchaseFilter= {
                startDate:'',
                endDate:'',
                vendorId:'',
                itemId:'',
                statusId:''
        };
       
        $scope.purchaseFilter.startDate = moment().startOf('month').format('DD/MM/YYYY');
        $scope.purchaseFilter.endDate = moment().format('DD/MM/YYYY');
        $scope.isShow = true;
        var filter = angular.copy($scope.purchaseFilter);
              
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
            $location.url('/hospital/purchase/purchaseOrder/add?purchaseOrderId='+collections.purchaseOrderId);
           
        }
        
        $scope.deleteRow=function(collections){
            ngDialog.openConfirm().then(function() { 
            var url='app/purchaseOrder/deletePurchaseOrder?purchaseOrderId='+collections.purchaseOrderId;
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
            $location.url('/hospital/purchase/purchaseOrder/view?purchaseOrderId='+collections.purchaseOrderId); 
        };
       $scope.filterPurchaseOrder = function(purchaseFilter){
          // if($scope.validateFilterOptions(purchaseFilter)){
           $http.post('app/purchaseOrder/filteredPurchaseOrderList', purchaseFilter).success(function(data) {
               if(data.success == true){
                   $scope.rowCollection = data.purchaseOrders;
                   $scope.isShow = false;
               }else{
                   logger.logError("Error Please Try Again");
               }
           });
        //   }
       };
       $scope.validateFilterOptions = function(purchaseFilter){
         $scope.isValid = true;
         if(purchaseFilter.startDate !='' && purchaseFilter.endDate != ''){
             $scope.isValid = false;
                         if(moment(purchaseFilter.startDate).isSame(purchaseFilter.endDate)||
                                 moment(purchaseFilter.endDate).isAfter(purchaseFilter.startDate)){
                             $scope.isValid = true;
                         }else{
                             logger.logError("PO End Date Should Not Be Less Than Po Start Date");
                         }
         }
         return $scope.isValid ;
       };
       
       $scope.filterPurchaseOrder(filter);
        
        
    });
    
});