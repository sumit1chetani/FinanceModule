define([ 'hospital/asset/asset', 'jqGrid' ], function(module) {
    'use strict';
    module.registerController('rfqAddCtrl', function($scope, $stateParams, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, utilsService) {

        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.lRFQItemBean = [];
        $scope.lRFQItemSubBean = [];
        $scope.itemStatus  =false;

        $scope.back = function() {
            $state.go('app.hospital.asset.rfq.list');
        };

        $scope.getRFQItemBeanList = function() {
            $http.get('app/requestQuotation/getrfqitembeanlist?isAsset=true&limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount).success(function(response) {
                $scope.lRFQItemBean = response.lRFQItemBean;
            }).error(function(response) {
                logger.logError("Error");
            });
        };

        $scope.getRFQItemBeanList();

        $scope.setItemStatus = function() {
            var falseCnt = 0;
            for ( var listIndex in $scope.lRFQItemBean) {
                if ($scope.lRFQItemBean[listIndex].status == false) {
                    falseCnt++
                }
            }
            $scope.itemStatus = falseCnt > 0 ? false : true;
        };

        $scope.changeItemStatus = function() {
            for ( var listIndex in $scope.lRFQItemBean) {
                $scope.lRFQItemBean[listIndex].status = $scope.itemStatus;
            }
        };

        $scope.changeIndexValue = function(index, purchaseRequsitionNumber) {
            if (index == $scope.showId) {
                $scope.showId = -1;
            } else if (index != $scope.showId) {
                $scope.lRFQItemSubBean = [];
                if (!utilsService.isUndefinedOrNull(purchaseRequsitionNumber)) {
                    $http.get('app/requestQuotation/getrfqitemsubbeanlist?purchaseRequsitionNumber=' + purchaseRequsitionNumber).success(function(data) {
                        $scope.lRFQItemSubBean = data.lRFQItemSubBean;
                        $scope.showId = index;
                    });
                }
            }
        };

        $scope.requestForQuote = function() {
            var trueCnt = 0;
            var lRFQItemBeanTmp = [];
            for ( var listIndex in $scope.lRFQItemBean) {
                if ($scope.lRFQItemBean[listIndex].status == true) {
                    lRFQItemBeanTmp.push($scope.lRFQItemBean[listIndex]);
                }
            }
            if (lRFQItemBeanTmp.length > 0) {
                sharedProperties.setObject(lRFQItemBeanTmp);
                $state.go('app.hospital.asset.rfq.view');
            } else {
                logger.logError("Select atleast one item");
            }
        };

    });
});
