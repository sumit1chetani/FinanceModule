define([ 'hospital/inventory/inventory', 'jqGrid' ], function(module) {
    'use strict';
    module.registerController('requestQuotationEditCtrl', function($scope, $stateParams, $state, $http, ngDialog, logger, $location, $controller, $injector, validationService, sharedProperties, toaster, $rootScope, utilsService) {

        $scope.showId = -1;

        $scope.requestQuotationBean = {
            rfqId : 0
        };
        
        $scope.rfqStatusName = '';

        $scope.lRFQItemBean = [];
        $scope.lRFQItemSubBean = [];
        $scope.lRFQItemVendorBean = [];
        $scope.saveDisabled = false;
        $scope.vendorStatus = false;
        
        $scope.isEdit=false;

        $scope.back = function() {
            $state.go('app.hospital.purchase.requestQuotation.list');
        };

        /** *********** Get Data ******************* */

        $scope.getRFQItemVendorBeanList = function() {
            var myURL = 'app/requestQuotation/getrfqitemvendorbeanlist';
          
            $http.post(myURL, $scope.lRFQItemBean).success(function(data) {
                if (data.success != false) {
                    console.log("vendor List");
                    console.log(data.lRFQItemVendorBean);
                    $scope.lRFQItemVendorBean = data.lRFQItemVendorBean;
                } else {
                    logger.logError("Error in List");
                }
            }).error(function(data) {
            });
        };

        $scope.getRfq = function(rfqId) {
            $scope.isEdit=true;
            var myURL = 'app/requestQuotation/getrfq?rfqId=' + rfqId;
            $http.get(myURL).success(function(data) {
                if (data.success != false) {
                    $scope.lRFQItemBean = data.lRFQItemBean;
                    $scope.requestQuotationBean = data.requestQuotationBean;
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
            $scope.rfqStatusName = $location.search().rfqStatusName;
            $scope.getRfq($scope.requestQuotationBean.rfqId);
        } else {
            console.log("list is");
            console.log(sharedProperties.getObject());
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
        
        $scope.uomCategoryList = [];
        
        $http.get("app/hospital/inventory/manageUOM/uomCategoryList").success(function(datas) {
            $scope.uomCategoryList = datas.uomCategoryList; 
        });
        
        /** ************Save**************** */

        $scope.saveRfq = function(sendMail) {
            
            var isNegative = false;
            var isVendorQty = false;
            var isVendorUOM = false;
            var valid = false;
            var isCheckValid = false;
            
            if (new validationService().checkFormValidity($scope.requestEditForm)) {
                if (isVendorSelected()) {
                   
                    var rfqData = {
                        'requestQuotationBean' : $scope.requestQuotationBean,
                        'lRFQItemVendorBean' : $scope.lRFQItemVendorBean,
                        'lRFQItemBean' : $scope.lRFQItemBean,
                        'isAsset' : false,
                        'sendMail' : sendMail
                    };
                    console.log("rfqData");
                    console.log(rfqData)
                    angular.forEach($scope.lRFQItemBean,function(value,key){
                        if(value.qtyReq<=0){
                            isNegative = true;
                        }
                    });
                    
                    angular.forEach($scope.lRFQItemVendorBean,function(valueVendor,keyVendor){
                     
                        
                        if(valueVendor.status==true){
                            if(valueVendor.vendorQty==null || valueVendor.vendorQty==""){
                                isVendorQty = true;
                            }
                            if(valueVendor.vendorUomId==null || valueVendor.vendorUomId==0){
                                isVendorUOM = true;
                            } 
                         
                           var itemId=valueVendor.itemId;
                           
                           var qty;
                          
                           angular.forEach($scope.lRFQItemBean,function(value,key){
                               if(itemId==value.itemId){
                                   qty=value.qtyReq;
                               }
                           });
                           
                         
                           if(valueVendor.vendorQty > qty){
                                valid = true;
                            }
                            var validQty = (qty / valueVendor.vendorQty);
                            
                            if(validQty.toString().indexOf('.') != -1){
                                isCheckValid = true;
                            }
                        }
                        
                    });
                    
                    if(isNegative){
                        logger.logError("Required Quantity Should be greater than 0!");
                    }else{
                        if(isVendorUOM){
                            logger.logError("Please Select Vendor UOM!");
                        }else{
                            if(isVendorQty){
                                logger.logError("Vendor Quantity Should be greater than 0!");
                            }else{
                                if(valid){
                                    logger.logError("Vendor Quantity Should be lesser than equal to Required Quantity!!");
                                }else{
                                    if(isCheckValid){
                                        logger.logError("Invalid Vendor Quantity!");
                                    }else{
                                        $http.post('app/requestQuotation/saveRequestQuote', rfqData).success(function(data) {
                                            if (sendMail == 'Y') {
                                                logger.logSuccess("Saved & Email sent successfully");
                                            } else {
                                                logger.logSuccess("Saved successfully");
                                            }
                                            $state.go('app.hospital.purchase.requestQuotation.list');
                                        }).error(function(data) {
                                        });
                                    }
                                }
                            }
                        }
                    }
                    
                } else {
                    logger.logError("Select atleast one vendor");
                }

            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.requestEditForm.$validationSummary), 555000, 'trustedHtml');
            }
        };
    });
    
    module.registerController('parentCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {
        
        $scope.validateVendorQty = function(vendorQty,index){
            debugger
            if(vendorQty<=0){
                logger.logError("Vendor Quantity should be greater than 0!");
                $scope.lRFQItemVendorBean[index].vendorQty = '';
            }else{
                $scope.lRFQItemVendorBean[index].vendorQty = parseInt(vendorQty);
            }
        };
        
        $scope.validateVendorUOM = function(vendorUomId,index){
            if(vendorUomId==null && vendorUomId==undefined){
                logger.logError("Please Select Vendor UOM!");
                $scope.lRFQItemVendorBean[index].vendorUomId = '';
            }else{
                debugger;
                $scope.lRFQItemVendorBean[index].vendorUomId = vendorUomId;
                $scope.lRFQItemVendorBean[index].vendorUomName = $("#vendorUomId option:selected").text();
            }
        };
        
    });
    
});
