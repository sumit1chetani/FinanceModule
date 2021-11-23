//define([ 'hospital/purchase/purchase', 'jqGrid' ], function(module, app) {

    'use strict';
    app.controller('manageItemAddCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, ManageItemService, validationService, $filter) {
        $scope.manageItemObjValidate = {
            isEdit : true
        }
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages = 0;
        $scope.isDisplay = true;

        $scope.manageItemObj = {
            itemTypeId : '',
            itemCode : '',
            itemName : '',
            itemDescription : '',
            itemCategoryId : '',
            saleable : false,
            purchaseable : false,
            servicetype : false,
            requestable : true,
            isEditCate:true,
            purchaseId : '',
            uomId : '',
            altuom:'',
            altqty:'',
            reorderLevel : '',
            minQuantity : '',
            maxQuantity : '',
            costingId : '',
            warranty : '',
            costPrice : '',
            leadTime : '',
            inventoryValuationId : '',
            issueId : '',
            id : '',
            typeinput : '',
            labelName : '',
            defaultvalue : '',
            attributevalue : '',
            attributeId : '',
            itemSpecificationId : '',
            tax:'',
            cgst:'',
            sgst:'',
            igst:'',
            isMrp : false,
            isBatch : false,
            isExpiry : false,
            isManfactureDetails : false,
            specificationList : [],
            tables : []
        };

        $scope.tables = [];
        $scope.loadTable = function() {
            var table = {};
            table.row = [ {
                tableId : '',
                entityId : '',
                vendorItemName : '',
                vendorItemCode : '',
                vendorMinimumQuantity : '',
                vendorUom : '',
                pricingType : '',
                vendorLeadTime : '',

            } ];
            $scope.manageItemObj.tables.push(table);
        }

        $scope.loadTable();

        $scope.addRow = function(tables) {
            var table = {
                tableId : '',
                entityId : '',
                vendorItemName : '',
                vendorItemCode : '',
                vendorMinimumQuantity : '',
                vendorUom : '',
                pricingType : '',
                vendorLeadTime : '',

            };

            tables.row.push(table);
        }
        
        $scope.uomCategoryList = [];
        
        $http.get("app/hospital/inventory/manageUOM/uomCategoryList").success(function(datas) {
            $scope.uomCategoryList = datas.uomCategoryList; 
        });
        
        $scope.getUOMCategoryBasedList=function(uomId){
            if(uomId!=""){
                $http.get('hospital/inventory/manageitem/uomCategoryBasedList?uomId=' + uomId).success(function(datas) {
                    $scope.uomList = datas.uomList; 
                }).error(function(datas) {
                });
            }else{
                $scope.uomList = [];
            }   
        }

        $scope.cancelItem = function() {
            $state.go("app.finance.accounts.manageitem.list");
        };
        
        $scope.checkCostPrice = function(costPrice)
        {
            $scope.manageItemObj.costPrice = (costPrice).toFixed(2);
        }
        
        $scope.checkCostPriceDigits = function(value){
            var regex = /^\d{1,20}\.?\d{0,2}$/;
            var isValid = false;
            isValid = regex.test(value);
            if(value == ""){
            }
            if(isValid==true){
                $scope.manageItemObj.costPrice=value;
            }else if(isValid==false){
                $scope.manageItemObj.costPrice = value.slice(0,-1);
            }
        }

        $scope.removeRowForm = function(table) {
            $scope.tablerow = [];
            if (table.row.length > 1) {
                angular.forEach(table.row, function(row, index) {

                    var check = row.tableId;
                    if (check == undefined || check == "") {
                        $scope.tablerow.push(row);
                    } else {

                    }

                });
                table.row = $scope.tablerow;
            } else {
                logger.logError("Minimum 1!");

            }

        }
        
    	$scope.itemTypeList = [
   	     {id: '15', text: 'Asset'},
   	    {id: '16', text: 'Consumable'},
   	    {id: '17', text: 'Stockable Product'},
    	    {id: '13', text: 'Service'},
   	

   	  ];

    
        
        $scope.chkAll=false;
        $scope.checkAllVendor = function (rowCollection,checkBox) {
          if(checkBox) {
                $scope.chkAll=true;
            } else {
                $scope.chkAll = false;
            }
            var i=0;
            angular.forEach($scope.manageItemObj.tables[0].row, function (value, key) {
                value.tableId=$scope.chkAll;
            });
       
        };
        
        /*$scope.onchangeItemCategoryList = function(itemTypeId) {
            // For Only Asset
            debugger
                if(itemTypeId !== null){
            if (itemTypeId === 15) {
                var obj = $filter('filter')($scope.globalcategoryList, {
                    itemCategorytype : itemTypeId
                });
                $scope.categoryList = obj;
            } else {
                var obj = $filter('filter')($scope.globalcategoryList, {
                    itemCategorytype : '!' + 15
                });
                $scope.categoryList = obj;
            }
            }else{
                $scope.categoryList=$scope.globalcategoryList
            }
        }
        */
        
        $scope.$watch('manageItemObj.itemTypeId', function(itemTypeId, oldValue) {
            if(itemTypeId != "" && itemTypeId!=undefined && itemTypeId!=''){
                if(itemTypeId !== null){
                    if (itemTypeId === 15) {
                        var obj = $filter('filter')($scope.globalcategoryList, {
                            itemCategorytype : itemTypeId
                        });
                        $scope.categoryList = obj;
                    } else {
                        var obj = $filter('filter')($scope.globalcategoryList, {
                            itemCategorytype : '!' + 15
                        });
                        $scope.categoryList = obj;
                    }
                    }else{
                        $scope.categoryList=$scope.globalcategoryList
                    }
               
           }
        });
        

        ManageItemService.dropDownList().then(function(result) {
            $scope.globalcategoryList = result.data.itemCategoryList;
            $scope.categoryList = result.data.itemCategoryList;
            $scope.uomList = result.data.uomList;
            $scope.entityList = result.data.entityList;
        });

        ManageItemService.defList().then(function(result) {
            $scope.costingList = result.data.costingList;
            $scope.inventoryValuvationList = result.data.inventoryValuvationList;
            $scope.issueList = result.data.issueList;
            $scope.itemCategoryList = result.data.itemCategoryList;
          //  $scope.itemTypeList = result.data.itemTypeList;
            $scope.pricingTypeList = result.data.pricingTypeList;
            $scope.purchaseList = result.data.purchaseList;
        });
        $http.get('hospital/inventory/manageitem/defList').then(function(result)
                {
            
            $scope.itemTypeList1 = result.data.itemTypeList;
                })
        
        $scope.$watch('manageItemObj.itemCategoryId', function(newValue, oldValue) {
            if(newValue != ""){
                $scope.getSpecification(newValue)
           }
        });
        
          $scope.checkItemName = function(itemName){
              if(itemName!=''){
                  $http.get('hospital/inventory/manageitem/checkItemName?checkItemName=' + itemName).success(function(datas) {
                      if(datas!=0){
                          logger.logError('Item Name Already Exist!');
                          $scope.manageItemObj.itemName = '';
                      }
                      
                  }).error(function(datas) {
                  });
              }
        }
          
          $scope.checkItemCode = function(itemCode){
              if(itemCode!=''){
                  $http.get('hospital/inventory/manageitem/checkItemCode?checkItemCode=' + itemCode).success(function(datas) {
                      if(datas!=0){
                          logger.logError('Item Code Already Exist!');
                          $scope.manageItemObj.itemCode = '';
                      }
                  }).error(function(datas) {
                  });
              }
          }
        
        $scope.getSpecification = function(itemCategoryId) {

            $http.get("hospital/inventory/manageitem/attributeDetails?itemCategoryId=" + itemCategoryId).success(function(response) {
                if (response.success == true) {
                    var data = response.specificationList;
                    $scope.specificationDetails = [];
                    $scope.manageItemObj.specificationList = [];
                    angular.forEach(data, function(specificationDetails, index) {
                        $scope.specificationDetails.push(specificationDetails);
                        console.log("specificationDetails"+specificationDetails);
                        $scope.specificationDetails[index].defaultvalue = specificationDetails.defaultvalue.split(",");
                        var atri = {
                            attributeId : specificationDetails.id,
                            attributevalue : ''
                        }
                        $scope.manageItemObj.specificationList.push(atri);
                    });
                }
            });
            $http.get("hospital/inventory/manageitem/grnattributeDetails?itemCategoryId=" + itemCategoryId).success(function(response) {
                if(response.length>0){
                    $scope.manageItemObj.isMrp = response[0].isMrp;
                    $scope.manageItemObj.isBatch = response[0].isBatch;
                    $scope.manageItemObj.isExpiry = response[0].isExpiry;
                    $scope.manageItemObj.isManfactureDetails = response[0].isManfactureDetails;
                }

            });

        };
        
        $scope.reset=function(){
            
            $scope.manageItemObj.itemTypeId = '';
            $scope.manageItemObj.itemCode = '';
            $scope.manageItemObj.itemName = '';
            $scope.manageItemObj.itemDescription = '';
            $scope.manageItemObj.itemCategoryId = '';
            $scope.manageItemObj.saleable = '';
            $scope.manageItemObj.purchaseable = '';
            $scope.manageItemObj.requestable = '';
            $scope.manageItemObj.purchaseId= '';
            $scope.manageItemObj.uomId = '';
            $scope.manageItemObj.reorderLevel = '';
            $scope.manageItemObj.minQuantity = '';
            $scope.manageItemObj.maxQuantity = '';
            $scope.manageItemObj.costingId = '';
            $scope.manageItemObj.warranty = '';
            $scope.manageItemObj.costPrice = '';
            $scope.manageItemObj.leadTime = '';
            $scope.manageItemObj.isMrp = '';
            $scope.manageItemObj.isBatch = '';
            $scope.manageItemObj.isExpiry = '';
            $scope.manageItemObj.isManfactureDetails = '';
            $scope.manageItemObj.inventoryValuationId = '';
            $scope.manageItemObj.issueId = '';
            $scope.manageItemObj.tax = '';
            $scope.manageItemObj.cgst = '';
            $scope.manageItemObj.sgst = '';
            $scope.manageItemObj.igst = '';
        };

        $scope.submit = function(manageItemAddForm, manageItemObj) {
            if (new validationService().checkFormValidity($scope.manageItemAddForm)) {
//                if( $scope.manageItemObj.uomId !=  $scope.manageItemObj.altuom){
                $scope.save(manageItemObj);
//                }else{
//                    logger.logError("Alternate Quantity is required !");
//                }
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.manageItemAddForm.$validationSummary), 555000, 'trustedHtml');
            }
        };

        $scope.save = function(manageItemObj) {
            var objWholeData = {
                'itemTypeId' : manageItemObj.itemTypeId,
                'itemCode' : manageItemObj.itemCode,
                'itemName' : manageItemObj.itemName,
                'itemDescription' : manageItemObj.itemDescription,
                'itemCategoryId' : manageItemObj.itemCategoryId,
                'isSaleable' : manageItemObj.saleable,
                'isPurchaseable' : manageItemObj.purchaseable,
                'isRequestable' : manageItemObj.requestable,
                'purchaseId' : manageItemObj.purchaseId,
                'uomId' : manageItemObj.uomId,
                'reorderLevel' : manageItemObj.reorderLevel,
                'minQuantity' : manageItemObj.minQuantity,
                'maxQuantity' : manageItemObj.maxQuantity,
                'costingId' : manageItemObj.costingId,
                'warranty' : manageItemObj.warranty,
                'costPrice' : manageItemObj.costPrice,
                'leadTime' : manageItemObj.leadTime,
                'isMrp' : manageItemObj.isMrp,
                'isBatch' : manageItemObj.isBatch,
                'isAutoIssue' :manageItemObj.isAutoIssue,
                'isServiceType' :manageItemObj.isServiceType,
                'isExpiry' : manageItemObj.isExpiry,
                'isManfactureDetails' : manageItemObj.isManfactureDetails,
                'inventoryValuationId' : manageItemObj.inventoryValuationId,
                'issueId' : manageItemObj.issueId,
                'tax' :manageItemObj.tax,
                'cgst' :manageItemObj.cgst,
                'sgst' :manageItemObj.sgst,
                'igst' :manageItemObj.igst,
                'altuom' :manageItemObj.altuom,
                'altqty' :manageItemObj.altqty,
                'lmanageitemvendor' : manageItemObj.tables[0].row,
                'specificationList' : manageItemObj.specificationList,
                'vendorId' : manageItemObj.entityId,
                'openingQty' : manageItemObj.openingQty
                 
            };
          
            if(manageItemObj.saleable==false && manageItemObj.purchaseable==false){
                logger.logError("Please Select Either Saleable or Purchaseable!");
            }else{
                
                var isVendor = false;
                var isVendorItemName = false;
                var isVendorItemCode = false;
                var isVendorMinimumQuantity = false;
                var isVendorUom = false;
                var isVendorLeadTime = false;
                var isPricingType = false;
                
                angular.forEach(manageItemObj.tables[0].row,function(value,key){
                    
                    if(value.entityId!='' || value.vendorItemName!=''){
                        if(value.entityId=="" || value.entityId==null || value.entityId==undefined){
                            isVendor = true;
                        }
                        if(value.vendorItemName=="" || value.vendorItemName==null || value.vendorItemName==undefined){
                            isVendorItemName = true;
                        }
                        if(value.vendorItemCode=="" || value.vendorItemCode==null || value.vendorItemCode==undefined){
                            isVendorItemCode = true;
                        }
                        
                        if(value.vendorMinimumQuantity=="" || value.vendorMinimumQuantity==null || value.vendorMinimumQuantity==undefined){
                            isVendorMinimumQuantity = true;
                        }
                        if(value.vendorUom=="" || value.vendorUom==null || value.vendorUom==undefined){
                            isVendorUom = true;
                        }
                        if(value.vendorLeadTime=="" || value.vendorLeadTime==null || value.vendorLeadTime==undefined){
                            isVendorLeadTime = true;
                        }
                        if(value.pricingType=="" || value.pricingType==null || value.pricingType==undefined){
                            isPricingType = true;
                        }
                    }
                    
                });
                
                if(isVendor){
                    logger.logError("Please Select Vendor!");
                }else{
                    if(isVendorItemName){
                        logger.logError("Please Enter Vendor Item Name!");
                    }else{
                        if(isVendorItemCode){
                            logger.logError("Please Enter Vendor Item Code!");
                        }else{
                            if(isVendorMinimumQuantity){
                                logger.logError("Please Enter Vendor Minimum Quantity!");
                            }else{
                                if(isVendorUom){
                                    logger.logError("Please Select Vendor UOM!");
                                }else{
                                    if(isVendorLeadTime){
                                        logger.logError("Please Enter Delivery Lead Time!");
                                    }else{
                                        if(isPricingType){
                                            logger.logError("Please Select Pricing Type!");
                                        }else{
                                            var myURL = 'hospital/inventory/manageitem/save';
                                            $http({
                                                url : myURL,
                                                data : objWholeData,
                                                method : 'post',
                                                dataType : 'json',
                                                headers : {
                                                    'Accept' : 'application/json',
                                                    'Content-Type' : 'application/json'
                                                }

                                            }).success(function(data) {
                                                if (data) {
                                                    logger.logSuccess("Item Saved Successfully!");
                                                    $state.go("app.finance.accounts.manageitem.list");
                                                } else {
                                                    logger.logError("Item Not Saved!");
                                                }
                                            }).error(function(data) {
                                                logger.logError("Error Not Saved!");
                                            });
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        };
        $scope.outgoing = true;
        $scope.InventoryNone1 = false;
        $scope.InventoryNone = true;

    });


        app.controller('manageItemEditCtrl', function($scope, $stateParams, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, ManageItemService,validationService) {
	
    	
    	
        $scope.outgoing = true;
        $scope.gblId = 0;
        var itemCode = $stateParams.itemId;
        $scope.manageItemObj = {
            itemId : '',
            itemTypeId : '',
            itemCode : '',
            itemName : '',
            itemDescription : '',
            itemCategoryId : '',
            saleable : true,
            purchaseable : true,
            isEditCate:true,
            requestable : true,
            purchaseId : '',
            uomId : '',
            altuom:'',
            altqty:'',
            reorderLevel : '',
            minQuantity : '',
            maxQuantity : '',
            costingId : '',
            warranty : '',
            costPrice : '',
            leadTime : '',
            inventoryValuationId : '',
            issueId : '',
            id : '',
            tax :'',
            cgst :'',
            sgst :'',
            igst :'',
            typeinput : '',
            labelName : '',
            defaultvalue : '',
            attributevalue : '',
            attributeId : '',
            itemSpecificationId : '',
            rdoDays : '',
            isMrp : false,
            isBatch : false,
            isExpiry : false,
            isManfactureDetails : false,
            specificationList : [],
            tables : [],
            deleteIds : []
        };
        
        $scope.itemOldCode ='';
        $scope.itemOldName ='';
        $scope.manageItemObj.tables = [ {
            row : []
        } ];

        $scope.addRow = function(tables) {
            var table = {
                tableId : '',
                entityId : '',
                vendorItemName : '',
                vendorItemCode : '',
                vendorMinimumQuantity : '',
                vendorUom : '',
                pricingType : '',
                vendorLeadTime : '',
                vendorId : 0
            };

            tables.row.push(table);
        }
        
        $scope.uomCategoryList = [];
        
        $http.get("app/hospital/inventory/manageUOM/uomCategoryList").success(function(datas) {
            $scope.uomCategoryList = datas.uomCategoryList; 
        });
        
        $scope.getUOMCategoryBasedList=function(uomId){
            if(uomId!=""){
                $http.get('hospital/inventory/manageitem/uomCategoryBasedList?uomId=' + uomId).success(function(datas) {
                    $scope.uomList = datas.uomList; 
                }).error(function(datas) {
                });
                
            }else{
                $scope.uomList = [];
            }   
        }

        $scope.manageItemObjValidate = {
            isEdit : false
        }
        $scope.cancelItem = function() {
            $state.go("app.finance.accounts.manageitem.list");
        };

        $scope.removeRowForm = function(table) {
            $scope.tablerow = [];
            angular.forEach(table.row, function(row, index) {
                var check = row.tableId;
                if (check == undefined || check == "") {
                    $scope.tablerow.push(row);
                } else {
                    if (row.vendorId > 0) {
                        $scope.manageItemObj.deleteIds.push(row.vendorId);
                    }
                }

            });
            table.row = $scope.tablerow;

        }

       /* ManageItemService.dropDownList().then(function(result) {
            $scope.globalcategoryList = result.data.itemCategoryList;
            $scope.categoryList = result.data.itemCategoryList;
            $scope.uomList = result.data.uomList;
            $scope.entityList = result.data.entityList;
        });

        ManageItemService.defList().then(function(result) {
            $scope.costingList = result.data.costingList;
            $scope.inventoryValuvationList = result.data.inventoryValuvationList;
            $scope.issueList = result.data.issueList;
            $scope.itemCategoryList = result.data.itemCategoryList;
          //  $scope.itemTypeList = result.data.itemTypeList;
            $scope.pricingTypeList = result.data.pricingTypeList;
            $scope.purchaseList = result.data.purchaseList;
        });*/
        
        
        ManageItemService.dropDownList().then(function(result) {
            $scope.globalcategoryList = result.data.itemCategoryList;
            $scope.categoryList = result.data.itemCategoryList;
            $scope.uomList = result.data.uomList;
            $scope.entityList = result.data.entityList;
        });

        ManageItemService.defList().then(function(result) {
            $scope.costingList = result.data.costingList;
            $scope.inventoryValuvationList = result.data.inventoryValuvationList;
            $scope.issueList = result.data.issueList;
            $scope.itemCategoryList = result.data.itemCategoryList;
          //  $scope.itemTypeList = result.data.itemTypeList;
            $scope.pricingTypeList = result.data.pricingTypeList;
            $scope.purchaseList = result.data.purchaseList;
        });
       /* $http.get('hospital/inventory/manageitem/defList').then(function(result)
                {
            
            $scope.itemTypeList1 = result.data.itemTypeList;
                })*/
        $scope.onchangeItemCategoryList = function(itemTypeId) {
            // For Only Asset
            console.log($scope.globalcategoryList);
            if (itemTypeId === 15) {
                var obj = $filter('filter')($scope.globalcategoryList, {
                    itemCategorytype : itemTypeId
                });
                $scope.categoryList = obj;
            } else {
                var obj = $filter('filter')($scope.globalcategoryList, {
                    itemCategorytype : '!' + 15
                });
                $scope.categoryList = obj;
            }
        }
      
       
        
        
        $scope.checkItemName = function(itemName){
           var itemName =  itemName;
           $scope.manageItemObj.itemName = itemName;
           if(itemName!=$scope.itemOldName){
                $http.get('hospital/inventory/manageitem/checkItemName?checkItemName=' + itemName).success(function(datas) {
                    if(datas!=0){
                        logger.logError('Item Name Already Exist!');
                        $scope.manageItemObj.itemName = $scope.itemOldName;
                    }
                    
                }).error(function(datas) {
                });
           }
            
        }
        
        $scope.checkItemCode = function(itemCode){
            var itemCode =  itemCode;
            $scope.manageItemObj.itemCode = itemCode;
            if(itemCode!=$scope.itemOldCode){
                $http.get('hospital/inventory/manageitem/checkItemCode?checkItemCode=' + itemCode).success(function(datas) {
                    if(datas!=0){
                        logger.logError('Item Code Already Exist!');
                        $scope.manageItemObj.itemCode = $scope.itemOldCode;
                    }
                }).error(function(datas) {
                });
            }
        }
     
         $scope.getSpecification = function(itemCategoryId,editspecificationList) {
            if(itemCategoryId > 0){
            $http.get("hospital/inventory/manageitem/attributeDetails?itemCategoryId=" + itemCategoryId).success(function(response) {
                if (response.success == true) {
                    var data = response.specificationList;
                    $scope.specificationDetails = [];
                    $scope.manageItemObj.specificationList = [];
                    angular.forEach(data, function(specificationDetails, index) {
                        console.log("specificationDetails");
                        console.log(specificationDetails);
                        $scope.specificationDetails.push(specificationDetails);
                        $scope.specificationDetails[index].defaultvalue = specificationDetails.defaultvalue.split(",");
                        var atri = {
                            attributeId : specificationDetails.id,
                            attributevalue : ''
                        }
                        $scope.manageItemObj.specificationList.push(atri);
                    });
                }
                console.log("SpecificationList");
                console.log($scope.manageItemObj.specificationList);
                angular.forEach($scope.manageItemObj.specificationList, function(value, index) {
                   var attributeId=value.attributeId;
                   var defaultvalue;
                   angular.forEach(editspecificationList, function(value1, index1) {
                       if(attributeId==value1.attributeId){
                           defaultvalue=value1.defaultvalue;
                       }
                   });
                   value.attributevalue=defaultvalue;
                });
                console.log("Final SpecificationList");
                console.log($scope.manageItemObj.specificationList);
            });
            }

        };
        
        $scope.reset=function(){
            $scope.getEditManageItemList(itemCode); 
        };

        
        
        $scope.$watch('manageItemObj.itemCategoryId', function(newValue, oldValue) {
            if(newValue != "" && newValue!=undefined && newValue!=''){
               if($scope.gblId==1){
                   var itemCategoryId=newValue;
                    if(itemCategoryId > 0){
                        $http.get("hospital/inventory/manageitem/attributeDetails?itemCategoryId=" + itemCategoryId).success(function(response) {
                            if (response.success == true) {
                                var data = response.specificationList;
                                $scope.specificationDetails = [];
                                $scope.manageItemObj.specificationList = [];
                                angular.forEach(data, function(specificationDetails, index) {
                                    console.log("specificatiwatchonDetails");
                                    console.log(specificationDetails);
                                    $scope.specificationDetails.push(specificationDetails);
                                    $scope.specificationDetails[index].defaultvalue = specificationDetails.defaultvalue.split(",");
                                    var atri = {
                                        attributeId : specificationDetails.id,
                                        attributevalue : '',
                                    }
                                    $scope.manageItemObj.specificationList.push(atri);
                                });
                            }
                        });
                    }
                }else{
                    $scope.gblId=1;
                }
               
           }
        });
        
        $scope.getEditManageItemList = function(itemCode) {
            var url = 'hospital/inventory/manageitem/getManageItemEditList?ItemCode=' + itemCode;
            $http.get(url).success(function(result) {
                $scope.manageItemObj.itemId = result.itemList[0].itemId;
                $scope.manageItemObj.itemTypeId = result.itemList[0].itemTypeId;
                if ($scope.manageItemObj.itemTypeId === 16) {
                    $scope.consumPattern = true;
                    $scope.manageItemObj.rdoDays = 30;
                    $scope.getItemConsumptionReport(itemCode, $scope.manageItemObj.rdoDays);
                }

                $scope.manageItemObj.itemCode = result.itemList[0].itemCode;
                $scope.itemOldName=result.itemList[0].itemName;
                $scope.itemOldCode = result.itemList[0].itemCode;
                $scope.manageItemObj.itemName = result.itemList[0].itemName;
                $scope.manageItemObj.itemDescription = result.itemList[0].itemDescription;
                $scope.manageItemObj.itemCategoryId = result.itemList[0].itemCategoryId;
                $scope.manageItemObj.saleable = result.itemList[0].saleable;
                $scope.manageItemObj.purchaseable = result.itemList[0].purchaseable;
                $scope.manageItemObj.requestable = result.itemList[0].requestable;
                $scope.manageItemObj.purchaseId = result.itemList[0].purchaseId;
                $scope.manageItemObj.uomId = result.itemList[0].uomId;
                $scope.manageItemObj.altuom = result.itemList[0].altuom;
                $scope.manageItemObj.altqty = result.itemList[0].altqty;
                $scope.getUOMCategoryBasedList($scope.manageItemObj.uomId);
                $scope.manageItemObj.reorderLevel = result.itemList[0].reorderLevel;
                $scope.manageItemObj.minQuantity = result.itemList[0].minQuantity;
                $scope.manageItemObj.maxQuantity = result.itemList[0].maxQuantity;
                $scope.manageItemObj.costingId = result.itemList[0].costingId;
                $scope.manageItemObj.warranty = result.itemList[0].warranty;
                $scope.manageItemObj.costPrice = result.itemList[0].costPrice.toFixed(2);
                $scope.manageItemObj.leadTime = result.itemList[0].leadTime;
                $scope.manageItemObj.inventoryValuationId = result.itemList[0].inventoryValuationId;
                $scope.manageItemObj.issueId = result.itemList[0].issueId;
                $scope.manageItemObj.tax = result.itemList[0].tax;
                $scope.manageItemObj.cgst = result.itemList[0].cgst;
                $scope.manageItemObj.sgst = result.itemList[0].sgst;
                $scope.manageItemObj.igst = result.itemList[0].igst;
                $scope.manageItemObj.openingQty = result.itemList[0].openingQty;
                
                $scope.manageItemObj.isAutoIssue = result.itemList[0].isAutoIssue;
                $scope.manageItemObj.isServiceType = result.itemList[0].isServiceType;
                $scope.manageItemObj.isEditCate = result.itemList[0].editCate;

                $scope.manageItemObj.isMrp = result.itemList[0].isMrp
                $scope.manageItemObj.isBatch = result.itemList[0].isBatch
                $scope.manageItemObj.isExpiry = result.itemList[0].isExpiry
                $scope.manageItemObj.isManfactureDetails = result.itemList[0].isManfactureDetails
                $scope.manageItemObj.tables[0].row = result.itemvendorList;
                
                // $scope.getSpecification($scope.manageItemObj.itemCategoryId);
               //  $scope.manageItemObj.specificationList = result.specificationList;
                
                console.log("ITemList");
                console.log(result.itemspecificationList);
               
               // $scope.specificationDetails=result.itemspecificationList;
                $scope.getSpecification($scope.manageItemObj.itemCategoryId,result.itemspecificationList);
               // $scope.manageItemObj.tables[0].row = result.itemvendorList;
                $scope.manageItemObj.specificationList = result.itemspecificationList;
              //  $scope.gblId=0;

                $scope.rowCollection1 = result.listItemLocation;
                if (result.listItemLocation === null) {
                    $scope.InventoryNone1 = false;
                    $scope.InventoryNone = true;

                } else if (result.listItemLocation.length > 0) {
                    $scope.InventoryNone1 = true;
                    $scope.InventoryNone = false;
                    $scope.createGrid(result.listItemLocation);
                }

            }).error(function(result) {
                logger.logError("Error Please Try Again");
            });

        }
        $scope.getEditManageItemList(itemCode);

        $scope.reloadGrid = function(data) {
            $('#grid').setGridParam({
                data : data,
                rowNum : data.length
            }).trigger('reloadGrid');
        };

        $scope.getSubGridList = function(item, location, subgridDivId) {
            var invDate = '';
            $http.get('app/inventoryRprt/inventroySubList?item=' + item + '&location=' + location+'&invDate='+invDate).success(function(data) {
                var subgridTableId = subgridDivId + "_t";
                $("#" + subgridTableId).setGridParam({
                    data : data.inventorySubList,
                    rowNum : data.inventorySubList.length
                }).trigger('reloadGrid');
            });
        };

        $scope.createGrid = function(inventoryList) {
            $("#grid").jqGrid({
                data : inventoryList,
                datatype : "local",
                autowidth : true,
                autoheight : true,
                rowList : [ 5, 10, 20 ],
                gridview : true,
                sortname : 'invdate',
                viewrecords : true,
                sortorder : 'desc',
                multiselect : false,
                multiboxonly : false,
                colNames : [ 'Item Id', 'Item Name', 'Item Desc', 'Location Id', 'Location', 'Quantity' ],
                colModel : [ {
                    name : 'itemId',
                    width : 250,
                    align : "left",
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    hidden : true
                }, {
                    name : 'itemName',
                    width : 250,
                    align : "left",
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    hidden : false
                }, {
                    name : 'itemDesc',
                    width : 250,
                    align : "left",
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    hidden : false
                }, {
                    name : 'locationId',
                    width : 250,
                    align : "left",
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    hidden : true
                }, {
                    name : 'locationName',
                    width : 250,
                    align : "left",
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    hidden : false
                }, {
                    name : 'qty',
                    width : 250,
                    align : "right",
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    hidden : false
                }

                ],
                loadOnce : true,
                pager : '#inventorypage',
                height : '100%',
                rowNum : 10,
                subGrid : true,
                subGridOptions : {
                    "plusicon" : 'fa fa-plus-circle',
                    "minusicon" : 'fa fa-minus-circle'

                },
                subGridRowExpanded : function(subgridDivId, rowId) {

                    var rowData = $('#grid').jqGrid('getRowData', rowId);
                    $scope.getSubGridList(rowData.itemId, rowData.locationId, subgridDivId);
                    var subgridTableId = subgridDivId + "_t";
                    var pager_child_id = "p_" + subgridTableId;
                    $("#" + subgridDivId).html("<table id='" + subgridTableId + "'></table><div id='" + pager_child_id + "' class='scroll'></div>");
                    $("#" + subgridTableId).jqGrid({
                        datatype : 'local',
                        data : "",
                        colNames : [ 'ledger Id', 'Date', 'Doc. Type', 'Doc. Ref', 'Src. Location', 'Dst. Location', 'InQty', 'OutQty' ],
                        autowidth : true,
                        colModel : [ {
                            name : 'ledgerId',
                            index : 'storageId',
                            width : 100,
                            align : "right",
                            searchoptions : {
                                sopt : [ 'cn' ]
                            },
                            hidden : true
                        }, {
                            name : 'inventoryDate',
                            index : 'inventoryDate',
                            width : 80,
                            searchoptions : {
                                sopt : [ 'cn' ]
                            },
                            hidden : false
                        }, {
                            name : 'docType',
                            index : 'docType',
                            width : 150,
                            align : "left",
                            searchoptions : {
                                sopt : [ 'cn' ]
                            }
                        }, {
                            name : 'refDoc',
                            index : 'refDoc',
                            width : 150,
                            align : "left",
                            searchoptions : {
                                sopt : [ 'cn' ]
                            }
                        }, {
                            name : 'srcLocation',
                            index : 'srcLocation',
                            width : 150,
                            align : "left",
                            searchoptions : {
                                sopt : [ 'cn' ]
                            },
                            hidden : true
                        }, {
                            name : 'dstLocation',
                            index : 'dstLocation',
                            width : 150,
                            align : "left",
                            searchoptions : {
                                sopt : [ 'cn' ]
                            },
                            hidden : true
                        }, {
                            name : 'inQty',
                            index : 'inQty',
                            width : 80,
                            align : "right",
                            searchoptions : {
                                sopt : [ 'cn' ]
                            }
                        }, {
                            name : 'outQty',
                            index : 'outQty',
                            width : 80,
                            align : "right",
                            searchoptions : {
                                sopt : [ 'cn' ]
                            }
                        } ],
                        autoheight : true,
                        height : '100%',
                        /* pager: pager_child_id, */
                        sortname : 'num',
                        sortorder : "asc",
                    });

                    // $("#"+subgridTableId).jqGrid('navGrid','#'+pager_child_id,{edit:false,add:false,del:false,search:false,refresh:false});

                }
            });
            $("#grid").jqGrid('navGrid', '#inventorypage', {
                edit : false,
                add : false,
                del : false,
                search : false,
                refresh : false
            });

            $("#grid").jqGrid('filterToolbar', {
                searchOperators : true,
                searchOnEnter : false
            });
            $("#grid").jqGrid('navButtonAdd', "#inventorypage", {
                caption : "",
                title : "Show/Hide Search box",
                buttonicon : 'ui-icon icon-thumb-tack',
                onClickButton : function() {
                    var myGrid = $('#grid');
                    myGrid[0].toggleToolbar();
                }
            });
            $("#grid")[0].toggleToolbar();
        };

        $scope.update = function(manageItemObj) {
            
            if (new validationService().checkFormValidity($scope.manageItemAddForm)) {
                var objWholeData = {
                        'itemId' : manageItemObj.itemId,
                        'itemTypeId' : manageItemObj.itemTypeId,
                        'itemCode' : manageItemObj.itemCode,
                        'itemName' : manageItemObj.itemName,
                        'itemDescription' : manageItemObj.itemDescription,
                        'itemCategoryId' : manageItemObj.itemCategoryId,
                        'isSaleable' : manageItemObj.saleable,
                        'isPurchaseable' : manageItemObj.purchaseable,
                        'isRequestable' : manageItemObj.requestable,
                        'purchaseId' : manageItemObj.purchaseId,
                        'uomId' : manageItemObj.uomId,
                        'reorderLevel' : manageItemObj.reorderLevel,
                        'minQuantity' : manageItemObj.minQuantity,
                        'maxQuantity' : manageItemObj.maxQuantity,
                        'costingId' : manageItemObj.costingId,
                        'warranty' : manageItemObj.warranty,
                        'costPrice' : manageItemObj.costPrice,
                        'leadTime' : manageItemObj.leadTime,
                        'inventoryValuationId' : manageItemObj.inventoryValuationId,
                        'issueId' : manageItemObj.issueId,
                        'ldeleteIds' : manageItemObj.deleteIds,
                        'isMrp' : manageItemObj.isMrp,
                        'isBatch' : manageItemObj.isBatch,
                        'isAutoIssue' :manageItemObj.isAutoIssue,
                        'isServiceType' :manageItemObj.isServiceType,
                        'isExpiry' : manageItemObj.isExpiry,
                        'tax' :manageItemObj.tax,
                        'cgst' :manageItemObj.cgst,
                        'sgst' :manageItemObj.sgst,
                        'igst' :manageItemObj.igst,
                        'altuom' :manageItemObj.altuom,
                        'altqty' :manageItemObj.altqty,
                        'isManfactureDetails' : manageItemObj.isManfactureDetails,
                        'lmanageitemvendor' : manageItemObj.tables[0].row,
                        'specificationList' : manageItemObj.specificationList,
                        'vendorId' : manageItemObj.entityId,
                        'openingQty' : manageItemObj.openingQty
                    };
                    
                    if(manageItemObj.saleable==false && manageItemObj.purchaseable==false){
                        logger.logError("Please Select Either Saleable or Purchaseable!");
                    }else{
                        var isVendor = false;
                        var isVendorItemName = false;
                        var isVendorItemCode = false;
                        var isVendorMinimumQuantity = false;
                        var isVendorUom = false;
                        var isVendorLeadTime = false;
                        var isPricingType = false;
                        
                        angular.forEach(manageItemObj.tables[0].row,function(value,key){
                            
                            if(value.entityId!='' || value.vendorItemName!=''){
                                if(value.entityId=="" || value.entityId==null || value.entityId==undefined){
                                    isVendor = true;
                                }
                                if(value.vendorItemName=="" || value.vendorItemName==null || value.vendorItemName==undefined){
                                    isVendorItemName = true;
                                }
                                if(value.vendorItemCode=="" || value.vendorItemCode==null || value.vendorItemCode==undefined){
                                    isVendorItemCode = true;
                                }
                                
                                if(value.vendorMinimumQuantity=="" || value.vendorMinimumQuantity==null || value.vendorMinimumQuantity==undefined){
                                    isVendorMinimumQuantity = true;
                                }
                                if(value.vendorUom=="" || value.vendorUom==null || value.vendorUom==undefined){
                                    isVendorUom = true;
                                }
                                if(value.vendorLeadTime=="" || value.vendorLeadTime==null || value.vendorLeadTime==undefined){
                                    isVendorLeadTime = true;
                                }
                                if(value.pricingType=="" || value.pricingType==null || value.pricingType==undefined){
                                    isPricingType = true;
                                }
                            }
                            
                        });
                        
                        if(isVendor){
                            logger.logError("Please Select Vendor!");
                        }else{
                            if(isVendorItemName){
                                logger.logError("Please Enter Vendor Item Name!");
                            }else{
                                if(isVendorItemCode){
                                    logger.logError("Please Enter Vendor Item Code!");
                                }else{
                                    if(isVendorMinimumQuantity){
                                        logger.logError("Please Enter Vendor Minimum Quantity!");
                                    }else{
                                        if(isVendorUom){
                                            logger.logError("Please Select Vendor UOM!");
                                        }else{
                                            if(isVendorLeadTime){
                                                logger.logError("Please Enter Delivery Lead Time!");
                                            }else{
                                                if(isPricingType){
                                                    logger.logError("Please Select Pricing Type!");
                                                }else{
                                                    var myURL = 'hospital/inventory/manageitem/update';
                                                    $http({
                                                        url : myURL,
                                                        data : objWholeData,
                                                        method : 'post',
                                                        dataType : 'json',
                                                        headers : {
                                                            'Accept' : 'application/json',
                                                            'Content-Type' : 'application/json'
                                                        }

                                                    }).success(function(data) {
                                                        if (data) {
                                                            logger.logSuccess("Item Updated Successfully!");
                                                            $state.go("app.finance.accounts.manageitem.list");
                                                        } else {
                                                            logger.logError("Item Not Updated!");
                                                        }
                                                    }).error(function(data) {
                                                        logger.logError("Error Not Updated!");
                                                    });
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        
                    }

            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.manageItemAddForm.$validationSummary), 555000, 'trustedHtml');
            }
            
        };

        //Line Chart for Items
        $scope.onValueChange = function(value) {
            $scope.getItemConsumptionReport(itemCode, value);
        }

        $scope.getItemConsumptionReport = function(itemCode, rdoDays) {
            var itm;
            rdoDays = rdoDays - 1;
            $scope.itemMasterlist = [];
            $scope.itemDatelist = [];
            $scope.itemMaxlist = [];
            $scope.itemMinlist = [];
            $scope.itemAvglist = [];
            if ($scope.manageItemObj.itemId != undefined && $scope.manageItemObj.itemId != '') {
                itm = $scope.manageItemObj.itemId;
            }

            $http.get('hospital/inventory/manageitem/itemconsumptionList?itm=' + itm + '&rdoDays=' + rdoDays).success(function(response) {

                console.log("getConsumptionReport :::::::::::::::::");
                console.log(response);

                angular.forEach(response.itemConsumptionMasterList, function(value, index) {
                    $scope.itemMasterlist.push(value.qty);
                    $scope.itemDatelist.push(value.docDate);
                });
                angular.forEach(response.itemConsumptionMax, function(value, index) {
                    for (var i = 0; i <= rdoDays; i++) {
                        // maxQty = $scope.datelist[i];
                        $scope.itemMaxlist.push(value.maxQty);
                    }
                });
                angular.forEach(response.itemConsumptionMin, function(value, index) {
                    for (var i = 0; i <= rdoDays; i++) {
                        // minQty = $scope.datelist[i];
                        $scope.itemMinlist.push(value.minQty);
                    }
                });
                angular.forEach(response.itemConsumptionAvg, function(value, index) {
                    for (var i = 0; i <= rdoDays; i++) {
                        // avgQty = $scope.datelist[i];
                        $scope.itemAvglist.push(value.avgQty);
                    }
                });

                // Basic Line Chart
                $scope.chartConfig = {
                    title : {
                        text : 'Consumption Pattern',
                        x : -20
                    // centers
                    },
                    xAxis : {
                        title : {
                            text : 'Monthly Consumption'
                        },

                        categories : $scope.itemDatelist
                    },
                    yAxis : {
                        title : {
                            text : 'Item Quantity(Qty)'
                        },
                        plotLines : [ {
                            value : 0,
                            width : 0.1,
                            color : '#808080'
                        } ]
                    },
                    tooltip : {
                        valueSuffix : 'Qty'
                    },
                    legend : {
                        layout : 'vertical',
                        align : 'right',
                        verticalAlign : 'middle',
                        borderWidth : 0
                    },
                    series : [ {
                        name : 'Minimum',
                        showInLegend: true, 
                        connectNulls: true,
                        data : $scope.itemMinlist
                    }, {
                        name : 'Maximum',
                        showInLegend: true, 
                        connectNulls: true,
                        data : $scope.itemMaxlist
                    }, {
                        name : 'Average',
                        showInLegend: true, 
                        connectNulls: true,
                        data : $scope.itemAvglist
                    }, {
                        name : 'Rate of Consumption',
                        showInLegend: true, 
                        connectNulls: true,
                        data : $scope.itemMasterlist
                    } ]
                }

            }).error(function(response) {
            });
        };

    });
   
    app.directive('phonenumbersOnly', function(logger){
       
        return {
          require: 'ngModel',
          link: function(scope, element, attrs, modelCtrl) {
             
            modelCtrl.$parsers.push(function (inputValue) {
                var inputValue=modelCtrl.$viewValue;
                if (inputValue == undefined) return '' 
               var transformedInput = inputValue.replace(/[^0-9]/g, ''); 
               if (transformedInput!=inputValue) {
                  modelCtrl.$setViewValue(transformedInput);
                  modelCtrl.$render();
               }else{
                 
               }         

               return transformedInput;  
            });
          }
        };
     });
    
    
    


    app.controller('parentCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope,$filter) {
        
        
        $scope.$watch('manageItemObj.tables[0].row[trIndex].entityId', function(newValue, oldValue) {

            if(newValue!=undefined && newValue!=''){
                var length=  $scope.manageItemObj.tables[0].row.length;
                
                  for(var i=0;i<length;i++){
                      for(var j=0;j<length;j++){
                          if(i!=j){
                              if($scope.manageItemObj.tables[0].row[i].entityId!=undefined && $scope.manageItemObj.tables[0].row[i].entityId!='' && $scope.manageItemObj.tables[0].row[i].entityId!=''
                                &&  $scope.manageItemObj.tables[0].row[j].entityId!=undefined && $scope.manageItemObj.tables[0].row[j].entityId!='' && $scope.manageItemObj.tables[0].row[j].entityId!='')   
                              {
                                  if($scope.manageItemObj.tables[0].row[i].entityId ==$scope.manageItemObj.tables[0].row[j].entityId){
                                      logger.logError("Vendor Name already added");
                                      $scope.manageItemObj.tables[0].row[$scope.$index].entityId='';
                                      $scope.manageItemObj.tables[0].row[$scope.$index].vendorItemName = '';
                                      $scope.manageItemObj.tables[0].row[$scope.$index].vendorItemCode = '';
                                      $scope.manageItemObj.tables[0].row[$scope.$index].vendorMinimumQuantity ='';
                                      $scope.manageItemObj.tables[0].row[$scope.$index].vendorLeadTime='';
                                      return false;
                                  }
                              }
                             
                          }
                      }
                  }
             

                }else{
                    $scope.manageItemObj.tables[0].row[$scope.$index].entityId='';
                    $scope.manageItemObj.tables[0].row[$scope.$index].vendorItemName = '';
                    $scope.manageItemObj.tables[0].row[$scope.$index].vendorItemCode = '';
                    $scope.manageItemObj.tables[0].row[$scope.$index].vendorMinimumQuantity ='';
                    $scope.manageItemObj.tables[0].row[$scope.$index].vendorLeadTime='';
              }

        });
        
    });
    

    //$scope.consumPattern
    app.factory('ManageItemService', function($http) {

        return {
            dropDownList : function() {
                return $http.get('hospital/inventory/manageitem/dropDownList').then(function(result) {
                    return result;
                });
            },
            defList : function() {
                return $http.get('hospital/inventory/manageitem/defList').then(function(result) {
                    return result;
                });
            }
        }

    });
    
  
//});
