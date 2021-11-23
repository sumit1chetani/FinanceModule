'use strict';

app.controller('cancelpurchListCtrl', function($scope, $rootScope,ngDialog, $http, $location, logger,
        utilsService,$state,sharedProperties,$window,validationService,toaster,$stateParams) {

        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages = 0;
        
        $scope.rowCollection = [];
        $scope.isDisplay = true;
        $scope.add = function(){
            $state.go("app.sea.cancelpurch.add");
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
            $location.url('/master/cancelpurch/add?purchaseOrderId='+collections.purchaseOrderId);
           
        };
          
        $scope.viewRow = function(collections){
                $location.url('/master/cancelpurch/view?purchaseOrderId='+collections.purchaseOrderId);
        };
        
    });
    
