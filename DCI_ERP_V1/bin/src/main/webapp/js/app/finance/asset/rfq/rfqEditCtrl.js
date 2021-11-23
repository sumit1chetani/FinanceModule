define([ 'hospital/asset/asset', 'jqGrid' ], function(module) {
    'use strict';
    module.registerController('rfqEditCtrl', function($scope, $stateParams, $state, $http, ngDialog, logger, $location, $controller, $injector, validationService, sharedProperties, toaster, $rootScope, utilsService) {

        $scope.showId = -1;

        $scope.requestQuotationBean = {
            rfqId : 0
        };

        $scope.lRFQItemBean = [];
        $scope.lRFQItemSubBean = [];
        $scope.lRFQItemVendorBean = [];
        $scope.saveDisabled = false;
        $scope.vendorStatus = false;

        $scope.back = function() {
            $state.go('app.hospital.asset.rfq.list');
        };

        /** *********** Get Data ******************* */

        $scope.getRFQItemVendorBeanList = function() {
            var myURL = 'app/requestQuotation/getrfqitemvendorbeanlist';
            $http.post(myURL, $scope.lRFQItemBean).success(function(data) {
                if (data.success != false) {
                    $scope.lRFQItemVendorBean = data.lRFQItemVendorBean;
                } else {
                    logger.logError("Error in List");
                }
            }).error(function(data) {
            });
        };

        $scope.getRfq = function(rfqId) {
            var myURL = 'app/requestQuotation/getrfq?rfqId=' + rfqId;
            $http.get(myURL).success(function(data) {
                if (data.success != false) {
                    $scope.lRFQItemBean = data.lRFQItemBean;
                    $scope.requestQuotationBean = data.requestQuotationBean;
//                    $scope.saveDisabled = $scope.requestQuotationBean.rfqStatus == 166 ? true : false;
                    $scope.lRFQItemVendorBean = data.lRFQItemVendorBean;
                    $scope.setVendorStatus();
                } else {
                    logger.logError("Error in List");
                }
            }).error(function(data) {
            });
        };

        if (!utilsService.isUndefinedOrNull($location.search().rfqId)) {
            $scope.requestQuotationBean.rfqId = $location.search().rfqId;
            $scope.getRfq($scope.requestQuotationBean.rfqId);
        } else {
            $scope.lRFQItemBean = sharedProperties.getObject();
            $scope.getRFQItemVendorBeanList();
        }

        /** *********Check box************ */
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

        $scope.changeVendorStatus = function() {
            for ( var listIndex in $scope.lRFQItemVendorBean) {
                $scope.lRFQItemVendorBean[listIndex].status = $scope.vendorStatus;
            }
        };

        $scope.setVendorStatus = function() {
            var falseCnt = 0;
            for ( var listIndex in $scope.lRFQItemVendorBean) {
                if ($scope.lRFQItemVendorBean[listIndex].status == false) {
                    falseCnt++
                }
            }
            $scope.vendorStatus = falseCnt > 0 ? false : true;
        };

        function isVendorSelected() {
            var trueCnt = 0;
            for ( var listIndex in $scope.lRFQItemVendorBean) {
                if ($scope.lRFQItemVendorBean[listIndex].status == true) {
                    trueCnt++
                }
            }
            return trueCnt > 0 ? true : false;
        }

        /** ************Save**************** */

        $scope.saveRfq = function(sendMail) {
            if (new validationService().checkFormValidity($scope.requestEditForm)) {
                if (isVendorSelected()) {
                    var rfqData = {
                        'requestQuotationBean' : $scope.requestQuotationBean,
                        'lRFQItemVendorBean' : $scope.lRFQItemVendorBean,
                        'lRFQItemBean' : $scope.lRFQItemBean
                    };
                    var myURL = 'app/requestQuotation/saverfq?isAsset=true&sendMail=' + sendMail;
                    $http.post(myURL, rfqData).success(function(data) {
                        if (sendMail == 'Y') {
                            logger.logSuccess("Saved & Email sent successfully");
                        } else {
                            logger.logSuccess("Saved successfully");
                        }
                        $state.go('app.hospital.asset.rfq.list')
                    }).error(function(data) {
                    });
                } else {
                    logger.logError("Select atleast one vendor");
                }

            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.requestEditForm.$validationSummary), 555000, 'trustedHtml');
            }
        };
    });
});
