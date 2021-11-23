define([ 'hospital/inventory/inventory' ], function(module) {

    'use strict';

    module.registerController('itemWiseVendorAddCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope,validationService) {

        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages = 0;
        $scope.isEdit = false;
        $scope.isEditVendor = false;
        
        $scope.itemNameList = [];
        $scope.itemValueList = [];
        $scope.rowCollectionVendor = [];
        $scope.displayedCollectionVendor = [];
        
        $scope.itemWiseVendorMappingObj = {
             itemId : 0,
             itemName : '',
             itemTypeName : '',
             itemDescription : '',
             itemCode : '',
             itemCategoryName : '',
             itemCategoryId : 0            
                
        };
        
        $scope.itemWiseVendorObj = {
                vendorId : 0,
                vendorName : '',
                vendorItemCode : '',
                uomName : '',
                uomId : 0,
                deliveryLeadTime : '',
                vendorItemName : '',
                minimumQty : '',
                pricingTypeId : 0,
                pricingTypeName : '',
                itemVendorId : 0
        };
        
        $scope.reset = function(itemWiseVendorAddForm){
            $scope.itemWiseVendorMappingObj=[];
            $scope.itemWiseVendorObj = [];
            $scope.rowCollectionVendor = [];
        };
        
        $http.get('hospital/inventory/itemwisevendormapping/getItemNameList').success(function(datas) {
            $scope.itemNameList = datas.itemNameList; 
        });
        
        $scope.getItemValues = function(itemId){
            if(itemId!=null){
                var myURL = 'hospital/inventory/itemwisevendormapping/getItemValues?itemId';
                $http({
                    method : 'post',
                    url : myURL,
                    data : itemId,
                }).success(function(data) {
                    console.log(data);
                    if(data.success==true){
                        $scope.itemWiseVendorMappingObj.itemTypeName = data.itemValueList[0].itemTypeName;
                        $scope.itemWiseVendorMappingObj.itemDescription = data.itemValueList[0].itemDescription;
                        $scope.itemWiseVendorMappingObj.itemCode = data.itemValueList[0].itemCode;
                        $scope.itemWiseVendorMappingObj.itemCategoryName = data.itemValueList[0].itemCategoryName;
                        $scope.itemWiseVendorMappingObj.itemCategoryId = data.itemValueList[0].itemCategoryId;
                    }
                    
                    
                });
            }else{
                $scope.itemWiseVendorMappingObj.itemTypeName = '';
                $scope.itemWiseVendorMappingObj.itemDescription = '';
                $scope.itemWiseVendorMappingObj.itemCode = '';
                $scope.itemWiseVendorMappingObj.itemCategoryName = '';
                $scope.itemWiseVendorMappingObj.itemCategoryId = '';
            }
            
        }

        $scope.cancelVendor = function() {
            $state.go("app.hospital.inventory.itemwisevendor.list");
        };
        
        $scope.validate = function(itemWiseVendorMappingAddForm,itemWiseVendorMappingObj,vendorDetail){
            if(new validationService().checkFormValidity($scope.itemWiseVendorMappingAddForm)){
                if(!$scope.isEdit){
                    $scope.save(itemWiseVendorMappingAddForm,itemWiseVendorMappingObj,vendorDetail);
                }
            }else{
                toaster.pop('error', "Please fill the required fields", 
                        logger.getErrorHtmlNew($scope.itemWiseVendorMappingAddForm.$validationSummary), 555000, 'trustedHtml');
            }
        };
        
        $scope.save = function(itemWiseVendorMappingAddForm, itemWiseVendorMappingObj,vendorDetail){
            var saveData = {
                    'vendorId': $scope.itemWiseVendorObj.vendorId,
                    'vendorItemCode': $scope.itemWiseVendorObj.vendorItemCode,
                    'uomId' : $scope.itemWiseVendorObj.uomId,
                    'deliveryLeadTime' : $scope.itemWiseVendorObj.deliveryLeadTime,
                    'vendorItemName' : $scope.itemWiseVendorObj.vendorItemName,
                    'minimumQty' : $scope.itemWiseVendorObj.minimumQty,
                    'pricingTypeId' : $scope.itemWiseVendorObj.pricingTypeId,
                    'itemId': $scope.itemWiseVendorMappingObj.itemId                    
            };
            
            if($scope.itemWiseVendorObj.vendorId==0){
                logger.logError("Please Add Atleast One Vendor Details!");
            }else{
                $http.post("hospital/inventory/itemwisevendormapping/saveVendor",saveData).success(function(response) {
                    if(response==true){
                        logger.logSuccess("Saved successfully!");
                        $state.go('app.hospital.inventory.itemwisevendor.list');
                    }else{
                        logger.logError("Unable To add Record!");
                    }
                 });
            }
        
        };

        $scope.addNewRow = function(){
            var itemId = $scope.itemWiseVendorMappingObj.itemId;
            if(itemId!=0){
                $scope.callDialog($scope, $http, ngDialog, logger,$injector, sharedProperties, toaster,$rootScope);
            }else{
                logger.logError('Please Select Item Name!');
            }
        };
        
        $scope.callDialog = function($scope, $http, ngDialog, logger,$injector, sharedProperties, toaster,$rootScope){
            ngDialog.open({
                scope: $scope,
                template: 'views/hospital/inventory/itemwisevendor/itemWiseVendorItemAdd',
                controller: $controller('itemWiseVendorAddItemCtrl', {
                    $scope: $scope,
                    $http:$http,
                    ngDialog:ngDialog,
                    logger:logger,
                    $injector:$injector, 
                    sharedProperties:sharedProperties, 
                    toaster:toaster,
                    $rootScope:$rootScope
                }),
                className: 'ngdialog-theme-plain',
                showClose: false,
                closeByDocument: false,
                closeByEscape: false,
            });
        };
        
        $scope.submit = function(itemWiseVendorAddForm,itemWiseVendorObj) {
            if (new validationService().checkFormValidity(itemWiseVendorAddForm)) {
                if(!$scope.isEditVendor){
                    $scope.saveVendor(itemWiseVendorAddForm, itemWiseVendorObj);
                }
            } else {
                toaster.pop('error', "Please fill the required fields", 
                        logger.getErrorHtmlNew(itemWiseVendorAddForm.$validationSummary), 555000, 'trustedHtml');
            }
        };
        
        $scope.saveVendor = function(itemWiseVendorAddForm, itemWiseVendorObj){
            $scope.rowCollectionVendor.push(itemWiseVendorObj);
            ngDialog.close();
        };
        
    });
    
    module.registerController('itemWiseVendorAddItemCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope,validationService) {
        
        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.isEditVendor = false;
        
        $scope.vendorList = [];
        $scope.vendorUOMList = [];
        $scope.pricingTypeList = [];
        
        $scope.itemWiseVendorObj = {
              vendorId : 0,
              vendorName : '',
              vendorItemCode : '',
              uomName : '',
              uomId : 0,
              deliveryLeadTime : '',
              vendorItemName : '',
              minimumQty : '',
              pricingTypeId : 0,
              pricingTypeName : '',
              itemVendorId : 0
        }
        
        $scope.cancel = function() {
            ngDialog.close();
        };
        
        $http.get('hospital/inventory/itemwisevendormapping/getVendorList').success(function(datas) {
            $scope.vendorList = datas.vendorList; 
        });
        
        $http.get('hospital/inventory/itemwisevendormapping/getVendorUOMList').success(function(datas) {
            $scope.vendorUOMList = datas.vendorUOMList; 
        });
        
        $http.get('hospital/inventory/itemwisevendormapping/getPricingTypeList').success(function(datas) {
            $scope.pricingTypeList = datas.pricingTypeList; 
        });
        
    });
    
    module.registerController('itemWiseVendorEditCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope,validationService,$stateParams) {

        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages = 0;
        $scope.isEdit = true;
        $scope.isEditVendor = true;
        
        $scope.itemNameList = [];
        $scope.itemValueList = [];
        $scope.rowCollectionVendor = [];
        $scope.displayedCollectionVendor = [];
        
        $scope.itemWiseVendorMappingObj = {
             itemId : 0,
             itemName : '',
             itemTypeName : '',
             itemDescription : '',
             itemCode : '',
             itemCategoryName : '',
             itemCategoryId : 0            
        };
        
        $scope.itemWiseVendorObj = {
            vendorId : 0,
            vendorName : '',
            vendorItemCode : '',
            uomName : '',
            uomId : 0,
            deliveryLeadTime : '',
            vendorItemName : '',
            minimumQty : '',
            pricingTypeId : 0,
            pricingTypeName : '',
            itemVendorId : 0
        };
        
        var itemId = $stateParams.itemId;
        $http.get('hospital/inventory/itemwisevendormapping/getItemNameList').success(function(datas) {
            $scope.itemNameList = datas.itemNameList; 
        });
        
        $scope.itemWiseVendorMappingObj.itemId = $stateParams.itemId;
        
        $scope.getItemValues = function(itemId){
            if(itemId!=null){
                var myURL = 'hospital/inventory/itemwisevendormapping/getItemValues?itemId';
                $http({
                    method : 'post',
                    url : myURL,
                    data : itemId,
                }).success(function(data) {
                    console.log(data);
                    if(data.success==true){
                        $scope.itemWiseVendorMappingObj.itemTypeName = data.itemValueList[0].itemTypeName;
                        $scope.itemWiseVendorMappingObj.itemDescription = data.itemValueList[0].itemDescription;
                        $scope.itemWiseVendorMappingObj.itemCode = data.itemValueList[0].itemCode;
                        $scope.itemWiseVendorMappingObj.itemCategoryName = data.itemValueList[0].itemCategoryName;
                        $scope.itemWiseVendorMappingObj.itemCategoryId = data.itemValueList[0].itemCategoryId;
                    }
                    
                });
            }else{
                $scope.itemWiseVendorMappingObj.itemTypeName = '';
                $scope.itemWiseVendorMappingObj.itemDescription = '';
                $scope.itemWiseVendorMappingObj.itemCode = '';
                $scope.itemWiseVendorMappingObj.itemCategoryName = '';
                $scope.itemWiseVendorMappingObj.itemCategoryId = '';
            }
            
        }

        $scope.cancelVendor = function() {
            $state.go("app.hospital.inventory.itemwisevendor.list");
        };
        
        var url = 'hospital/inventory/itemwisevendormapping/vendorlist?itemId=' + itemId;
        $http.get(url).success(function(response) {
            $scope.rowCollectionVendor = response.vendorMainList;
            $scope.getItemValues(itemId);
        });
        
        $scope.validate = function(itemWiseVendorMappingAddForm,itemWiseVendorMappingObj,vendorDetail){
            if(new validationService().checkFormValidity($scope.itemWiseVendorMappingAddForm)){
                if($scope.isEdit){
                    $scope.update(itemWiseVendorMappingAddForm,itemWiseVendorMappingObj,vendorDetail);
                }
            }else{
                toaster.pop('error', "Please fill the required fields",logger.getErrorHtmlNew($scope.itemWiseVendorMappingAddForm.$validationSummary), 555000, 'trustedHtml');
            }
        };
        
        $scope.update = function(itemWiseVendorMappingAddForm, itemWiseVendorMappingObj,vendorDetail){
            logger.logSuccess("Updated successfully!");
            $state.go('app.hospital.inventory.itemwisevendor.list');
        };

        $scope.addNewRow = function(){
            var itemId = $scope.itemWiseVendorMappingObj.itemId;
            if(itemId!=0){
                $scope.callDialog($scope, $http, ngDialog, logger,$injector, sharedProperties, toaster,$rootScope);
            }else{
                logger.logError('Please Select Item Name!');
            }
        };
        
        $scope.editRowVendor = function(itemVendorId){
            $scope.callDialog1($scope,itemVendorId,$http, ngDialog, logger,$injector, sharedProperties, toaster,$rootScope);
        }
        
        $scope.callDialog = function($scope, $http, ngDialog, logger,$injector, sharedProperties, toaster,$rootScope){
            ngDialog.open({
                scope: $scope,
                template: 'views/hospital/inventory/itemwisevendor/itemWiseVendorItemAdd',
                controller: $controller('itemWiseVendorAddItemCtrl', {
                    $scope: $scope,
                    $http:$http,
                    ngDialog:ngDialog,
                    logger:logger,
                    $injector:$injector, 
                    sharedProperties:sharedProperties, 
                    toaster:toaster,
                    $rootScope:$rootScope
                }),
                className: 'ngdialog-theme-plain',
                showClose: false,
                closeByDocument: false,
                closeByEscape: false,
            });
        };
        
        $scope.callDialog1 = function($scope,itemVendorId,$http, ngDialog, logger,$injector, sharedProperties, toaster,$rootScope){
            ngDialog.open({
                scope: $scope,
                template: 'views/hospital/inventory/itemwisevendor/itemWiseVendorItemAdd',
                controller: $controller('itemWiseVendorEditItemCtrl', {
                    $scope: $scope,
                    itemVendorId : itemVendorId,
                    $http:$http,
                    ngDialog:ngDialog,
                    logger:logger,
                    $injector:$injector, 
                    sharedProperties:sharedProperties, 
                    toaster:toaster,
                    $rootScope:$rootScope
                }),
                className: 'ngdialog-theme-plain',
                showClose: false,
                closeByDocument: false,
                closeByEscape: false,
            });
        };
        
        $scope.validateUpdateVendor = function(itemWiseVendorAddForm,itemWiseVendorObj) {
            if (new validationService().checkFormValidity(itemWiseVendorAddForm)) {
                if($scope.isEdit){
                    $scope.updateVendor(itemWiseVendorAddForm, itemWiseVendorObj);
                }
            } else {
                toaster.pop('error', "Please fill the required fields", 
                        logger.getErrorHtmlNew(itemWiseVendorAddForm.$validationSummary), 555000, 'trustedHtml');
            }
        };
        
        $scope.saveVendor = function(itemWiseVendorAddForm, itemWiseVendorObj){
            var saveData = {
                    'vendorId': itemWiseVendorObj.vendorId,
                    'vendorItemCode': itemWiseVendorObj.vendorItemCode,
                    'uomId' : itemWiseVendorObj.uomId,
                    'deliveryLeadTime' : itemWiseVendorObj.deliveryLeadTime,
                    'vendorItemName' : itemWiseVendorObj.vendorItemName,
                    'minimumQty' : itemWiseVendorObj.minimumQty,
                    'pricingTypeId' : itemWiseVendorObj.pricingTypeId,
                    'itemId': $scope.itemWiseVendorMappingObj.itemId                    
            };
            
            $http.post("hospital/inventory/itemwisevendormapping/saveVendor",saveData).success(function(response) {
               if(response==true){
                   ngDialog.close();
                   
                   var url = 'hospital/inventory/itemwisevendormapping/vendorlist?itemId=' + itemId;
                   $http.get(url).success(function(response) {
                       $scope.rowCollectionVendor = response.vendorMainList;
                   });
                   
               }else{
                   logger.logError("Unable To add Record!");
                   ngDialog.close();
               }
            });
            
        };
        
        $scope.updateVendor = function(itemWiseVendorAddForm, itemWiseVendorObj){
            var updateData = {
                    'vendorId': itemWiseVendorObj.vendorId,
                    'vendorItemCode': itemWiseVendorObj.vendorItemCode,
                    'uomId' : itemWiseVendorObj.uomId,
                    'deliveryLeadTime' : itemWiseVendorObj.deliveryLeadTime,
                    'vendorItemName' : itemWiseVendorObj.vendorItemName,
                    'minimumQty' : itemWiseVendorObj.minimumQty,
                    'pricingTypeId' : itemWiseVendorObj.pricingTypeId,
                    'itemId': $scope.itemWiseVendorMappingObj.itemId,
                    'itemVendorId': itemWiseVendorObj.itemVendorId
            };
            
            $http.post("hospital/inventory/itemwisevendormapping/updateVendor",updateData).success(function(response) {
               if(response==true){
                   ngDialog.close();
                   
                   var url = 'hospital/inventory/itemwisevendormapping/vendorlist?itemId=' + itemId;
                   $http.get(url).success(function(response) {
                       $scope.rowCollectionVendor = response.vendorMainList;
                   });
                   
               }else{
                   logger.logError("Unable To Update Record!");
                   ngDialog.close();
               }
            });
        };
        
        $scope.deleteRowVendor = function(itemVendorId, index) {
            ngDialog.openConfirm().then(function() {
                var myURL = 'hospital/inventory/itemwisevendormapping/deleteVendor?itemVendorId';
                $http({
                    method : 'post',
                    url : myURL,
                    data : itemVendorId,
                }).success(function(data) {
                    if (data == true) {
                        var tableData = $scope.rowCollectionVendor;
                        $scope.rowCollectionVendor.splice(index, 1);
                        $state.reload();
                        
                        var url = 'hospital/inventory/itemwisevendormapping/vendorlist?itemId=' + itemId;
                        $http.get(url).success(function(response) {
                            $scope.rowCollectionVendor = response.vendorMainList;
                        });
                        
                    } 
                }).error(function(data) {
                    logger.logError("Error in Delete!");
                });
            });
        };
        
        $scope.submit = function(itemWiseVendorAddForm,itemWiseVendorObj) {
            if (new validationService().checkFormValidity(itemWiseVendorAddForm)) {
                if(!$scope.isEditVendor){
                    $scope.saveVendor(itemWiseVendorAddForm, itemWiseVendorObj);
                }
            } else {
                toaster.pop('error', "Please fill the required fields", 
                        logger.getErrorHtmlNew(itemWiseVendorAddForm.$validationSummary), 555000, 'trustedHtml');
            }
        };
        
        $scope.saveVendor = function(itemWiseVendorAddForm, itemWiseVendorObj){
            $scope.rowCollectionVendor.push(itemWiseVendorObj);
            ngDialog.close();
        };
        
        $scope.reset = function(itemWiseVendorAddForm){
            var url = 'hospital/inventory/itemwisevendormapping/vendorlist?itemId=' + itemId;
            $http.get(url).success(function(response) {
                $scope.rowCollectionVendor = response.vendorMainList;
                $scope.getItemValues(itemId);
            });
        };
        
    });
    
    module.registerController('itemWiseVendorEditItemCtrl', function($scope,itemVendorId, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope,validationService) {
        
        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.isEditVendor = true;
        
        $scope.vendorList = [];
        $scope.vendorUOMList = [];
        $scope.pricingTypeList = [];
        
        $scope.itemWiseVendorObj = {
              vendorId : 0,
              vendorName : '',
              vendorItemCode : '',
              uomName : '',
              uomId : 0,
              deliveryLeadTime : '',
              vendorItemName : '',
              minimumQty : '',
              pricingTypeId : 0,
              pricingTypeName : '',
              itemVendorId : 0
        }
        
        $scope.itemWiseVendorObj.itemVendorId = itemVendorId;
        
        $scope.cancel = function() {
            ngDialog.close();
        };
        
        $http.get('hospital/inventory/itemwisevendormapping/getVendorList').success(function(datas) {
            $scope.vendorList = datas.vendorList; 
        });
        
        $http.get('hospital/inventory/itemwisevendormapping/getVendorUOMList').success(function(datas) {
            $scope.vendorUOMList = datas.vendorUOMList; 
        });
        
        $http.get('hospital/inventory/itemwisevendormapping/getPricingTypeList').success(function(datas) {
            $scope.pricingTypeList = datas.pricingTypeList; 
        });
        
        $http.post("hospital/inventory/itemwisevendormapping/editVendorList",$scope.itemWiseVendorObj.itemVendorId).success(function(response) {
            if(response){
                
                $scope.itemWiseVendorObj.vendorId = response.vendorId;
                $scope.itemWiseVendorObj.vendorName = response.vendorName;
                $scope.itemWiseVendorObj.vendorItemCode = response.vendorItemCode;
                $scope.itemWiseVendorObj.uomName = response.uomName;
                $scope.itemWiseVendorObj.uomId = response.uomId;
                $scope.itemWiseVendorObj.deliveryLeadTime = response.deliveryLeadTime;
                $scope.itemWiseVendorObj.vendorItemName = response.vendorItemName;
                $scope.itemWiseVendorObj.minimumQty = response.minimumQty;
                $scope.itemWiseVendorObj.pricingTypeId = response.pricingTypeId;
                $scope.itemWiseVendorObj.pricingTypeName = response.pricingTypeName;
                $scope.itemWiseVendorObj.itemVendorId = response.itemVendorId;
                
            }else{
                if(response.message == ''){
                    logger.logError(response.message);
                }
            }
         });
        
    });

});