'use strict';

app.controller('amendmentListCtrl', function($scope, $rootScope,ngDialog, $http, $location, logger,
        utilsService,$state,sharedProperties,$window,validationService,toaster,$stateParams) {

        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages = 0;
        $scope.isDisplay = true;
        $scope.getPurchaseOrderList = function(){
            var url = 'app/purchaseOrder/getPurchaseAmendmentList';
            $http.get(url).success(function(data) {
                if (data.success == true) {
                    $scope.rowCollection = data.purchaseOrders;
                 }
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        }
        $scope.getPurchaseOrderList();
        
        $scope.add = function(){
            $state.go("app.sea.amendment.add");
        }
        $scope.editRow =function(collections){
            $location.url('/master/amendment/add?purchaseOrderId='+collections.purchaseOrderId);
//            $location.url('/hospital/purchase/purchaseOrder/add?purchaseOrderId='+collections.purchaseOrderId);
            
        }
        
    
    
});