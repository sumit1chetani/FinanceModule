define([ 'hospital/asset/asset' ], function(module) {

    'use strict';

    module.registerController('purchaseAssetRequisitionListCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {

        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages = 0;

        $scope.add = function() {
            $state.go("app.hospital.asset.assetPurchaseRequisitions.add");
        }

        $scope.getAssetRequisitionList = function() {
            var url = 'hospital/asset/assetRequisition/listForPurchaseAssetRequisition?formCode='+$('#form_code_id').val();
            $http.get(url).success(function(data) {
                if (data.success) {
                    $scope.rowCollection = data.listPurchaseAssetRequisitionBeans;
                } else {
                    logger.logError("Error Please Try Again");
                }
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        };

        $scope.getAssetRequisitionList();

        $scope.editRow = function(assetReqid, type) {
            $state.go('app.hospital.asset.assetPurchaseRequisitions.edit', ({
                'assetPRId' : assetReqid,
                'type' : type
            }));
        }

        $scope.viewRow = function(assetReqid, type) {
            $state.go('app.hospital.asset.assetPurchaseRequisitions.view', ({
                'assetPRId' : assetReqid,
            }));
        }

        $scope.deleteRow = function(assetReqId, index) {

            var myURL = 'hospital/asset/assetRequisition/deletePurchaseAssetRequisition';
            $http({
                method : 'post',
                url : myURL,
                data : assetReqId,
            }).success(function(data) {
                if (data) {
                    var tableData = $scope.rowCollection;
                    $scope.rowCollection.splice(index, 1);
                    logger.logSuccess("Deleted successfully");
                    $state.reload();
                } else {
                    logger.logError("Error in delete!");
                }
            }).error(function(data) {
                logger.logSuccess("Error in Delete!");
            });
        }

    });

});