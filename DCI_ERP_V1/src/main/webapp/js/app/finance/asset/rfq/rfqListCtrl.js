define([ 'hospital/purchase/purchase' ], function(module) {

    'use strict';

    module.registerController('rfqListCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, $stateParams, $filter, validationService) {

        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.isUpload = true;

        $scope.requestQuotation = {
            rfqId : '',
            rfqNum : '',
            rfqDate : '',
            rfqsendBy : '',
            rfqStatus : ''
        };

        $scope.add = function() {
            $state.go("app.hospital.asset.rfq.add");
        };

        $scope.getRfqList = function() {
            $http.get("app/requestQuotation/getrfqlist?isAsset=true").success(function(response) {
                $scope.rowCollection = response.lRequestQuotationBean;
            });
        };
        $scope.getRfqList();

        //Edit functionality
        $scope.editRow = function(collection) {
            var rfqId = collection.rfqId;
            $location.url('hospital/asset/rfq/edit?rfqId=' + rfqId);
        };

        //Delete functionality
        $scope.deleteRow = function(collection) {
            var rfqId = collection.rfqId;
            ngDialog.openConfirm().then(function() {
                $http.post("app/requestQuotation/delete", rfqId).success(function(response) {
                    if (response.success == true) {
                        logger.logSuccess("Deleted successfully!");
                        $scope.getList();
                    } else
                        logger.logError("You can't delete this record,Deletion Failed");
                }).error(function(result) {
                    logger.logError("Error Please Try Again");
                });
            });
        };

    });

});