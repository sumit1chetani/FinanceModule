'use strict';

app.controller('consListCtrl', function($scope, $rootScope,ngDialog, $http, $location, logger,
        utilsService,$state,sharedProperties,$window,validationService,toaster,$stateParams) {

        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages = 0;
        $scope.isUpload=true;
        $scope.isDelete=true;
        $scope.rowCollection = [];
        $scope.add = function(){
            $state.go("app.sea.cons.add");
        }
        $scope.getPurchaseOrderList = function(){
            var url = 'app/purchaseOrder/purchaseList?purchaseType='+45+'&formCode='+$('#form_code_id').val();
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
            $location.url('/master/cons/add?purchaseOrderId='+collections.purchaseOrderId);
           
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
            $location.url('/master/cons/view?purchaseOrderId='+collections.purchaseOrderId); 
        }
        
        $scope.printRow = function(collections){
            var url='app/purchaseOrder/exportPurchaseOrderPdf?purchaseOrderId='+collections.purchaseOrderId;
            $http.get(url).success(function(data){
                if(data.success){
                    $window.open('tempdoc/Purchase_Order.pdf','Title','width=500,height=700');
                }else{
                    logger.logError("Error Please Try Again");
                }
            }).error(function(data) {
                logger.logSuccess("Error in Delete!");
            }); 
        } 
        
    });
    
