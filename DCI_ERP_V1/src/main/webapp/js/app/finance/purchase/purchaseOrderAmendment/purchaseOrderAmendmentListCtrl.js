define([ 'hospital/purchase/purchase' ], function(module) {

    'use strict';

    module.registerController('purchaseOrderAmendmentListCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {

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
            $state.go("app.hospital.purchase.purchaseOrderAmendment.add");
        }
        $scope.editRow =function(collections){
            $location.url('/hospital/purchase/purchaseOrderAmendment/add?purchaseOrderId='+collections.purchaseOrderId);
           
        }
        
    });
    
});