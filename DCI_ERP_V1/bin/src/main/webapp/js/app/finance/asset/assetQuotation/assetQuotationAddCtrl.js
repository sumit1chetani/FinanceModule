define([ 'hospital/asset/asset' ], function(module) {

    'use strict';
    module.registerController('assetQuotationAddCtrl', function($scope, $state, $http, ngDialog, logger, 
            $location, $controller, $injector, sharedProperties, toaster, $rootScope,$timeout,validationService ) {
        $scope.assetForList = [];
        $scope.purchaseTypeList = [];
        $scope.vendorList = [];
        $scope.statusList = [];
        $scope.discountTypeList = [];
        $scope.taxList = [];
        $scope.requisitionList = [];
        $scope.itemList = [];
        $scope.edit = false;
        $scope.quotationDetailList = [];
        $scope.tableSelection=[];
        $scope.fixedPriceAndQuantity=false;
        $scope.consignmentQtyLabel=false;
        $scope.isPmtTerms = false;
        $scope.assetQuotation = {
                assetNo:'',quoteDate:'', assetFor:'',purchaseType:'', vendorId:'', 
                  fixedPrice:'N', fixedQty:'N',validFromDate:'', validToDate:'', paymentTerms:'',companyId:'', assetDetailList:[]
        };
      
        
        $scope.cancel = function(){
            $state.go("app.hospital.asset.assetQuotation.list");
        }
        
        $http.get('app/commonUtility/getCompanyList').success(function(datas) {
            $scope.companyList = datas;
            }).error(function(datas) {
        });
        /**
         * validation
         */
        $scope.validate = function(assetQuotationForm,assetQuotation) {
            console.log($scope.assetQuotationForm.$validationSummary);
            console.log(new validationService());
            if (new validationService().checkFormValidity($scope.assetQuotationForm)) {
                if(!$scope.edit){
                   $scope.save(assetQuotationForm,assetQuotation);
                }else{
                    $scope.save(assetQuotationForm,assetQuotation);
                    
                }
            } else {
                toaster.pop('error', "Please fill the required fields", 
                        logger.getErrorHtmlNew($scope.assetQuotationForm.$validationSummary), 555000, 'trustedHtml');
            }
        };
        
        
        /***
         * get Add Details with Dropdown values ************************************
         */
        
        
        
        
        
        $scope.getAddDetails = function(){
            $http.get("hospital/purchase/quotation/getAddDetails").success(function(response) {
                if (response.success == true) {
                    //purchase_for combo
                    var assForList = [];
                    angular.forEach(response.assetForList, function (item, key) {
                        var pforObj = new Object();
                        pforObj.id = response.assetForList[key].defTableId;
                        pforObj.text = response.assetForList[key].value;
                        assForList.push(pforObj);
                    });
                    $scope.assetForList = assForList;
                    
                    $scope.purchaseTypeList = response.purchaseTypeList;
                  
                    //vendor combo
                    var venList = [];
                    angular.forEach(response.vendorList, function (item, key) {
                        var vendorObj = new Object();
                        vendorObj.id = response.vendorList[key].entityId;
                        vendorObj.text = response.vendorList[key].entityName;                
                        venList.push(vendorObj);    
                    });   
                    $scope.vendorList = venList;
                    
                    
                    $scope.statusList = response.statusList;
                    $scope.discountTypeList =response.discountTypeList;
                   // $scope.taxList = response.taxList;
                    $scope.taxList = response.taxList;
                    var taxLists = [];
                    angular.forEach(response.taxList, function (item, key) {
                        var taxObj = new Object();
                        taxObj.id = response.taxList[key].defTableId;
                        taxObj.text = response.taxList[key].value;                
                        taxLists.push(taxObj);    
                    });   
                    $scope.taxList = taxLists;
                    
                    
                    
                   // $scope.requisitionList = response.requisitionList;
                    /*$scope.purchaseQuotation = response.purchaseQuotation;*/
                    
                    
               /*     //fetch current date
                    var currentDate = new Date();
                    currentDate = ('0' + currentDate.getDate()).slice(-2)+"/"+('0' + currentDate.getMonth()).slice(-2)+"/"+currentDate.getFullYear();
                    $scope.purchaseQuotation.quoteDate = currentDate;    */
                    $scope.getCurrentDate();
                }
            });
        }
        $scope.getAddDetails();
        
        $scope.getAddDetail = function(){
            $http.get("hospital/asset/quotation/getAddDetail").success(function(response) {
                if (response.success == true) {
                   
                    // $scope.requisitionList = response.requisitionList;
                    var reqNoList = [];
                    angular.forEach(response.requisitionList, function (item, key) {
                        var reqObj = new Object();
                        reqObj.id = response.requisitionList[key].purchaseRequisitionId;
                        reqObj.text = response.requisitionList[key].requisitionNumber;                
                        reqNoList.push(reqObj);    
                    });   
                    $scope.requisitionList = reqNoList;
                    
                  
                }
            });
        }
        $scope.getAddDetail();

        $scope.getAssetTypeDetails = function(assetType,purchaseTypeList){
            debugger;
            angular.forEach(purchaseTypeList, function(key,index){
               if(key.defTableId==assetType){
                   if(key.value=='Rate Contract'){
                       $scope.fixedPriceAndQuantity=true;   
                       $scope.consignmentQtyLabel=false;
                       
                   }else if(key.value=='Consignment'){
                       $scope.consignmentQtyLabel=true;
                       $scope.assetQuotation.fixedPrice='N';
                       $scope.assetQuotation.fixedQty='N';
                   }else{
                       $scope.fixedPriceAndQuantity=false;
                       $scope.consignmentQtyLabel=false;
                       $scope.assetQuotation.fixedPrice='N';
                       $scope.assetQuotation.fixedQty='N';
                   }
                   
               }else{
                   $scope.fixedPriceAndQuantity=false;
                   $scope.assetQuotation.fixedPrice='N';
                   $scope.assetQuotation.fixedQty='N';
               }
            });
        }
        
        
        
        $scope.getCurrentDate = function(){
            var d=new Date();
            var year=d.getFullYear();
            var month=d.getMonth()+1;
            if (month<10){
                month="0" + month;
            };
            var day=d.getDate();
            $scope.date=day + "/" + month + "/" + year;
            
            $scope.assetQuotation.quoteDate=$scope.date;
        }
        
        
        
        
        
        $scope.$watch("assetQuotation.vendorId", function(newValue, oldValue) {
            if(newValue != "" && newValue!=undefined && newValue!=null){
                $http.get("hospital/purchase/quotation/getVendorDetails?vendorId="+newValue).success(function(response) {
                    console.log("response:::::::::::::::::::::getVendorDetails::::::::::::::");
                    console.log(response.purchaseQuotation);
                    if (response.success == true) {
                        $scope.assetQuotation.vendorAddress = response.purchaseQuotation.vendorAddress;
                        $scope.assetQuotation.cityName = response.purchaseQuotation.cityName;
                        $scope.assetQuotation.state = response.purchaseQuotation.state;
                        $scope.assetQuotation.zipcode = response.purchaseQuotation.zipcode;
                        $scope.assetQuotation.country = response.purchaseQuotation.country;    
                        debugger;                
                       
                        if(response.purchaseQuotation.pmtTermsId!="" && response.purchaseQuotation.pmtTermsId!=null){
                            /*if(newValue==oldValue || oldValue ==""){
                                $scope.isOnChange =false;
                            }else{
                                $scope.isOnChange =true;
                            }
                            if($scope.edit || $scope.isOnChange){
                                $scope.isPmtTerms = true;
                                $scope.assetQuotation.paymentTerms = response.purchaseQuotation.pmtTermsId;
                            }else if(!$scope.edit){
                                
                            }*/
                            $scope.isPmtTerms = true;
                            $scope.assetQuotation.paymentTerms = response.purchaseQuotation.pmtTermsId;                            
                        }else{
                            $scope.isPmtTerms = false;
                            $scope.assetQuotation.paymentTerms = '';
                        }    
                        
                        
                    }else{
                        $scope.assetQuotation.vendorAddress = '';
                        $scope.assetQuotation.cityName = '';
                        $scope.assetQuotation.state = '';
                        $scope.assetQuotation.zipcode = '';
                        $scope.assetQuotation.country = '';
                    }
                });
            }else{
                $scope.assetQuotation.vendorAddress = '';
                $scope.assetQuotation.cityName = '';
                $scope.assetQuotation.state = '';
                $scope.assetQuotation.zipcode = '';
                $scope.assetQuotation.country = '';
            }
        });
        
       /*$scope.calGrandTotalWithFreight = function(totalFreight){
            if(totalFreight!=""){                    
                    $scope.assetQuotation.grandTotal = parseFloat($scope.assetQuotation.grandTotal) + parseFloat(totalFreight);
            }else{
                $scope.calculateGrandTotalAndTaxInfo();
            }                        
        }*/
        
        $scope.calGrandTotalWithFreight = function(totalFreightAmt){
            debugger;
            var subTotal=0, totalDiscount=0, totalTax=0, grandTot=0, totalFreight=0;
            angular.forEach($scope.assetQuotation.assetDetailList,function(key,index){
                subTotal = subTotal + parseFloat(key.amount);
                totalDiscount = totalDiscount + parseFloat(key.disAmt);
                totalTax = totalTax + parseFloat(key.taxAmt);
                
                grandTot=parseFloat(subTotal) + parseFloat(totalTax) - parseFloat(totalDiscount);                    
            });
            if(totalFreightAmt!="")
                totalFreight =  totalFreight + parseFloat(totalFreightAmt);
            
            grandTot = grandTot + parseFloat(totalFreight) 
            
            $scope.assetQuotation.subTotal = subTotal;
            $scope.assetQuotation.totalDiscount = totalDiscount;
            $scope.assetQuotation.totalTax = totalTax;
            if(!isNaN(grandTot)){
                $scope.assetQuotation.grandTotal = grandTot.toFixed(2);    
            }            
        }
        
        $scope.save = function(form){
            if($scope.edit==false){
                console.log("$scope.AssetQuotation:::::::::::::::::SAVE_DATA:::::::::::::::::::::::::");
                console.log($scope.assetQuotation);
                $http.post("hospital/asset/quotation/save",$scope.assetQuotation).success(function(response) {
                    if (response.success == true) {
                        logger.logSuccess("Saved Successfully");
                        $state.go("app.hospital.asset.assetQuotation.list");
                    }else{
                        logger.logSuccess("Unable to Save the records.");
                    }
                });
            }else{
                console.log("$scope.AssetQuotation:::::::::::::::::UPDATE_DATA:::::::::::::::::::::::::");
                console.log($scope.assetQuotation);
                $http.post("hospital/asset/quotation/update",$scope.assetQuotation).success(function(response) {
                    if (response.success == true) {
                        logger.logSuccess("Updated Successfully");
                        $state.go("app.hospital.asset.assetQuotation.list");
                    }else{
                        logger.logSuccess("Unable to Update the records.");
                    }
                });
            }
            
        }
        
        
        $scope.addAssetRow = function() {
            $scope.callDialog($scope, 0, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope);
        }
        
        $scope.removeAssetRow = function() {
            for (var i = $scope.assetQuotation.assetDetailList.length - 1; i >= 0; i--) {
              if ($scope.tableSelection[i]) {
                  $scope.assetQuotation.assetDetailList.splice(i, 1);
                delete $scope.tableSelection[i];
              }
            }
            $scope.calculateGrandTotalAndTaxInfo();
          };
          
        
        $scope.callDialog = function($scope, requestCode, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope) {
            ngDialog.open({
                scope : $scope,
                template : 'views/hospital/asset/assetQuotation/assetQuotationRequestAdd',
                controller : $controller('assetQuotationRequestAddCtrl', {
                    $scope : $scope,
                    requestCode : requestCode,
                    $http : $http,
                    ngDialog : ngDialog,
                    logger : logger,
                    $injector : $injector,
                    sharedProperties : sharedProperties,
                    toaster : toaster,
                    $rootScope : $rootScope
                }),
                className : 'ngdialog-theme-plain',
                showClose : false,
                closeByDocument : false,
                closeByEscape : false,
                preCloseCallback : $scope.getList
            });
        }
        
        /***
         * Edit Functionality *******************************
         **/
        var assetId = $location.search().assetId;
        
        if(assetId == undefined || assetId == null || assetId ==""){
        }else{
            $scope.edit =true;
          
                $http.get('hospital/asset/quotation/getAssetQuotationDataOnEdit?assetId='+assetId).success(function(data) {
                    console.log("Kathir Edit Records :::::::::::::");
                    console.log(data);
                    debugger;
                    $scope.edit =true;   
                    $scope.assetQuotation = data;
                    $scope.assetQuotation.assetDetailList = data.assetDetailList;
                    angular.forEach(data.assetDetailList,function(value,index){
                        debugger;
                        $scope.assetQuotation.assetDetailList[index].rowSubTotal = value.amount+value.taxAmt-value.disAmt;   
                    })
                    $scope.assetQuotation = data;
                    if(data.fixedPrice=="t"){
                        $scope.assetQuotation.fixedPrice='Y';}
                    else{
                        $scope.assetQuotation.fixedPrice='N';
                    }
                    if(data.fixedQty=="t"){
                        $scope.assetQuotation.fixedQty='Y';}
                    else{
                        $scope.assetQuotation.fixedQty='N';
                    }
                    $scope.assetQuotation.paymentTerms = data.paymentTerms;
                    $scope.getAssetTypeDetails($scope.assetQuotation.assetType,$scope.purchaseTypeList);
                }).error(function(data) {
                });              
          
        }  
        
        
    });
    
    module.registerController('assetQuotationRequestAddCtrl', function($scope, $http, ngDialog, logger, requestCode, $injector, sharedProperties, toaster, $rootScope, validationService) {
        
        $scope.isEdit = false;
        $scope.cancelReq = function() {
            ngDialog.close();
        };
        
        $scope.quotationDetail = {
                quotationDetailId:0, 
                quotationId:0, 
                requisitionId:'', 
                requisitionNo:'', 
                itemId:'',
                quantity:'', 
                eddDate:'', 
                taxId:'', 
                taxTypeId:'', 
                taxType:'', 
                
                subTaxTypeId:'',
                subTaxType:'',
                subTaxTypePercent:'',
                subTaxTypeAmt:'',
                
                discountTypeId:'', 
                discountType:'',
                percentage:'',
                amount:'', 
                disAmt:0, 
                taxAmt: 0, 
                deliveryLeadTime:'',
                queryStatus:33, 
                unitPrice:'', 
                itemCode:'', 
                status:'',
                reqDate : '', 
                itemName : '',
                itemDescription : '',
                taxPercentage : 0,
                taxAmount : 0,
                
                subTaxPercentage:0,
                subTaxAmount:0,
                rowSubTotal: 0,
                
                discountAmount:'',
                discountPercent:'',                
                uom:0,
                uomName: '',
                cityName:'',
                stateName:'',
                pincode:'',country:''
        }

        $scope.isEdit = false;
        /**
         * validation
         */
        $rootScope.validateAQDetail = function(assetQuoteForm,quotationDetail) {
            debugger;
            
            if (new validationService().checkFormValidity(assetQuoteForm)) {
                debugger;
                if(!$scope.isEdit){
                    $scope.saveDetail(assetQuoteForm,quotationDetail);
                }else{
                    $scope.saveDetail(assetQuoteForm,quotationDetail);
                    
                }
            } else {
                toaster.pop('error', "Please fill the required fields", 
                        logger.getErrorHtmlNew(assetQuoteForm.$validationSummary), 555000, 'trustedHtml');
            }
        };
        
        $scope.onChangeDecimal =function(model,num){
            var floatnum=parseFloat(Math.round(num * 100) / 100).toFixed(2);
            $('#txt'+model).val(floatnum);
            
            return floatnum;
        }

        
        /**
         * get Tax Details *******************************************
         */
        
        $scope.$watch("quotationDetail.taxId", function(newValue, oldValue) {
            if(newValue != "" && newValue!=undefined && newValue!=null){
                $http.get("hospital/purchase/quotation/getTaxDetails?taxId="+newValue).success(function(response) {
                        if (response.success == true) {
                            if(response.purchaseQuotationDetail.taxType=="Percentage"){
                                $scope.taxPercentage = response.purchaseQuotationDetail.taxPercentage;                    
                                $scope.quotationDetail.taxType = response.purchaseQuotationDetail.taxType;
                            }else if(response.purchaseQuotationDetail.taxType=="Fixed Amount"){
                                $scope.taxAmount = response.purchaseQuotationDetail.taxAmount;
                                $scope.quotationDetail.taxType = response.purchaseQuotationDetail.taxType;
                            }
                            angular.forEach(response.purchaseQuotationDetail.subTaxList,function(key,index){
                                if(key.subTaxType=="Percentage"){
                                    $scope.subTaxPercentage = key.subTaxPercentage;
                                    $scope.quotationDetail.subTaxTypePercent = key.subTaxType;
                                }else if(key.subTaxType=="Fixed Amount"){
                                    $scope.subTaxAmount = key.subTaxAmount;
                                    $scope.quotationDetail.subTaxTypeAmt = key.subTaxType;
                                }
                            });                          
                        }else{
                            $scope.taxPercentage = '';
                            $scope.taxAmount = '';
                            $scope.quotationDetail.taxType = '';
                            
                            $scope.subTaxPercentage = '';
                            $scope.subTaxAmount = '';
                            $scope.quotationDetail.subTaxType = '';
                        }
                    });
            }else{
                $scope.taxPercentage = '';
                $scope.taxAmount = '';
                $scope.quotationDetail.taxType = '';
                
                $scope.subTaxPercentage = '';
                $scope.subTaxAmount = '';
                $scope.quotationDetail.subTaxType = '';
            }
           
        });
        
        $scope.discountPercent= false; $scope.discountAmt=false;
        $scope.getDiscountDetails = function(discountTypeId,discountTypeList){
            angular.forEach(discountTypeList,function(key,index){
                if(discountTypeList[index].defTableId == discountTypeId){
                    $scope.quotationDetail.discountType=discountTypeList[index].value;
                    if(discountTypeList[index].value=="Percentage"){
                        $scope.discountAmt=false;
                        $scope.discountPercent= true;
                        $scope.quotationDetail.discountAmount='';
                        
                    }                        
                    else if(discountTypeList[index].value=="Amount"){
                        $scope.discountAmt=true;
                        $scope.discountPercent= false;
                        $scope.quotationDetail.discountPercent='';                        
                    }                        
                }
            });
        }       
     
        /**
         * Get Item List with Requisition Number
         */
        $scope.$watch("quotationDetail.requisitionId", function(newValue, oldValue) {
            debugger;
            if(newValue != "" && newValue!=undefined && newValue!=null){
                $http.post("hospital/asset/quotation/getItemList",newValue).success(function(response) {
                   
                    debugger;
                    console.log("response.itemList::::::::::::::::getItemList:::::::::::::");
                    if (response.success == true) {
                        //$scope.itemList = response.itemList;
                        var itemsList = [];
                        angular.forEach(response.itemList, function (item, key) {
                            var itemObj = new Object();
                            itemObj.id = response.itemList[key].itemId;
                            itemObj.text = response.itemList[key].itemCode;                
                            itemsList.push(itemObj);    
                        });   
                        $scope.itemList = itemsList;
                        $scope.quotationDetail.requisitionNo = response.assetQuotationDetail.requisitionNo;
                        $scope.quotationDetail.reqDate = response.assetQuotationDetail.reqDate;
                        $scope.quotationDetail.locationName = response.assetQuotationDetail.locationName;
                        $scope.quotationDetail.pincode = response.assetQuotationDetail.pincode;
                        $scope.quotationDetail.stateName = response.assetQuotationDetail.stateName;
                        $scope.quotationDetail.cityName = response.assetQuotationDetail.cityName;
                        $scope.quotationDetail.country = response.assetQuotationDetail.country;
                    }else{
                        $scope.itemList = [];
                        $scope.quotationDetail.requisitionNo = '';
                        $scope.quotationDetail.reqDate = '';
                        $scope.quotationDetail.locationName = '';
                        $scope.quotationDetail.pincode = '';
                        $scope.quotationDetail.stateName = '';
                        $scope.quotationDetail.cityName = '';
                        $scope.quotationDetail.country = '';
                    }
                });
            }else{
                $scope.itemList = [];
                $scope.quotationDetail.requisitionNo = '';
                $scope.quotationDetail.reqDate = '';
                $scope.quotationDetail.locationName = '';
                $scope.quotationDetail.pincode = '';
                $scope.quotationDetail.stateName = '';
                $scope.quotationDetail.cityName = '';
                $scope.quotationDetail.country = '';
            }
        });
        $scope.$watch("quotationDetail.itemId", function(newValue, oldValue, itemobj) {
            if(newValue != "" && newValue!=undefined && newValue!=null){
                $http.post("hospital/asset/quotation/getItem", itemobj.quotationDetail).success(function(response) {
                    console.log("data");
                    console.log(response);
                    if (response.success == true) {
                        $scope.quotationDetail.itemCode = response.assetQuotationDetail.itemCode;
                        $scope.quotationDetail.itemName = response.assetQuotationDetail.itemName;
                        $scope.quotationDetail.itemDescription = response.assetQuotationDetail.itemDescription;
                        $scope.quotationDetail.eddDate = response.assetQuotationDetail.eddDate;
                        $scope.quotationDetail.quantity = response.assetQuotationDetail.quantity;
                        $scope.quotationDetail.uom = response.assetQuotationDetail.uom;
                        $scope.quotationDetail.uomName=response.assetQuotationDetail.uomName;
                    }else{
                        $scope.quotationDetail.itemCode = '';
                        $scope.quotationDetail.itemName = '';
                        $scope.quotationDetail.itemDescription = '';
                        $scope.quotationDetail.eddDate = '';
                        $scope.quotationDetail.quantity = '';
                        $scope.quotationDetail.uom ='';
                        $scope.quotationDetail.uomName='';
                    }
                });
            }else{
                $scope.quotationDetail.itemCode = '';
                $scope.quotationDetail.itemName = '';
                $scope.quotationDetail.itemDescription = '';
                $scope.quotationDetail.eddDate = '';
                $scope.quotationDetail.quantity = '';
                $scope.quotationDetail.uom ='';
                $scope.quotationDetail.uomName='';
            }
        });
        
        
         
         /*$scope.saveDetail = function(){
            debugger;
            $scope.quotationDetail.taxPercentage = $scope.taxPercentage;
            $scope.quotationDetail.taxAmount = $scope.taxAmount;
             
            console.log("$scope.quotationDetail::::::::::::::::::::::::::::::::::");
            console.log($scope.quotationDetail);
            $scope.quotationDetail.amount = $scope.quotationDetail.unitPrice * $scope.quotationDetail.quantity;
             
            //Discount
            if($scope.quotationDetail.discountPercent!="" || $scope.quotationDetail.discountPercent!=0){                
                    $scope.quotationDetail.disAmt = $scope.quotationDetail.amount * ($scope.quotationDetail.discountPercent/100);  
            }else if($scope.quotationDetail.discountAmount!="" || $scope.quotationDetail.discountAmount!=undefined 
                    || $scope.quotationDetail.discountAmount!=null){
                $scope.quotationDetail.disAmt = $scope.quotationDetail.discountAmount;
            }  
            else{
                $scope.quotationDetail.disAmt = 0;
            }
            //Tax Details
            if($scope.quotationDetail.taxPercentage!="" || $scope.quotationDetail.taxPercentage!=0){
                $scope.quotationDetail.taxAmt = (parseFloat($scope.quotationDetail.amount) - parseFloat($scope.quotationDetail.disAmt)) * parseFloat($scope.quotationDetail.taxPercentage/100);  
            }else if($scope.quotationDetail.taxAmount!="" || $scope.quotationDetail.taxAmount!=0){
                $scope.quotationDetail.taxAmt =(parseFloat($scope.quotationDetail.amount) - parseFloat($scope.quotationDetail.disAmt)) 
                + parseFloat($scope.quotationDetail.taxAmount);
            }
             
            $scope.assetQuotation.assetDetailList.push($scope.quotationDetail);           
            
            $scope.calculateGrandTotalAndTaxInfo();
                       
            ngDialog.close();
         }*/
                
         /**
          * Save Detail -- fetch dialog data into detail table with calculation subTotal,Tax, Discount, grandTotal 
          */
         
         $scope.saveDetail = function(){
            debugger;
            $scope.quotationDetail.taxPercentage = $scope.isNaNCheck(parseFloat($scope.taxPercentage));
            $scope.quotationDetail.taxAmount = $scope.isNaNCheck(parseFloat($scope.taxAmount));
            $scope.quotationDetail.subTaxPercentage = $scope.isNaNCheck(parseFloat($scope.subTaxPercentage));
            $scope.quotationDetail.subTaxAmount = $scope.isNaNCheck(parseFloat($scope.subTaxAmount));
           // $scope.quotationDetail.subTaxTypePercent =
            $scope.quotationDetail.unitPrice = $scope.isNaNCheck(parseFloat($scope.quotationDetail.unitPrice));
            $scope.quotationDetail.amount = (parseFloat($scope.quotationDetail.unitPrice) * parseFloat($scope.quotationDetail.quantity)).toFixed(2);
             
            //Discount
            if($scope.quotationDetail.discountPercent!="" || $scope.quotationDetail.discountPercent!=0){                
                    $scope.quotationDetail.disAmt = ($scope.quotationDetail.amount * ($scope.quotationDetail.discountPercent/100)).toFixed(2);  
            }else if($scope.quotationDetail.discountAmount!="" || $scope.quotationDetail.discountAmount!=undefined 
                    || $scope.quotationDetail.discountAmount!=null){
                $scope.quotationDetail.disAmt = parseFloat($scope.quotationDetail.discountAmount).toFixed(2);
            }  
            else{
                $scope.quotationDetail.disAmt = 0;
            }
            
            //Tax Details - Tax Percentage
            var totalTaxPercentage = (parseFloat($scope.quotationDetail.taxPercentage)) 
                                    + (parseFloat($scope.quotationDetail.subTaxPercentage));
            if($scope.quotationDetail.taxPercentage!="" || $scope.quotationDetail.taxPercentage!=0){//tax_percentage
                debugger;
                if($scope.quotationDetail.taxType=='Percentage'){ //tax Type
                    
                    if($scope.quotationDetail.subTaxTypePercent=='Percentage'){ //sub Tax Type                     
                        
                        $scope.quotationDetail.taxAmt = (parseFloat($scope.quotationDetail.amount) * (totalTaxPercentage/100)).toFixed(2);
                        
                    }if($scope.quotationDetail.subTaxTypeAmt=="Fixed Amount"){  //sub Tax Type
                        
                        var taxPercentAmt  = (parseFloat($scope.quotationDetail.amount) * (totalTaxPercentage/100)).toFixed(2);
                        
                        $scope.quotationDetail.taxAmt = $scope.quotationDetail.taxAmt + (parseFloat(taxPercentAmt) + parseFloat($scope.quotationDetail.subTaxAmount)).toFixed(2);    
                    }else{                       
                        $scope.quotationDetail.taxAmt = ((parseFloat($scope.quotationDetail.amount)) * 
                                parseFloat($scope.quotationDetail.taxPercentage/100)).toFixed(2);
                    }                  
                }              
                  
            }
          //Tax Details - Tax Amount
            if($scope.quotationDetail.taxAmount!="" || $scope.quotationDetail.taxAmount!=0){//tax_amount
                debugger;
                if($scope.quotationDetail.taxType=="Fixed Amount"){ //tax type
                    if($scope.quotationDetail.subTaxTypePercent=='Percentage'){ //sub Tax Type
                        
                      var totalSubTaxPercentAmt = parseFloat($scope.quotationDetail.amount) * (totalTaxPercentage/100);
                        
                      $scope.quotationDetail.taxAmt = (parseFloat($scope.quotationDetail.taxAmount) + parseFloat(totalSubTaxPercentAmt)).toFixed(2);
                        
                    }if($scope.quotationDetail.subTaxTypeAmt=="Fixed Amount"){  //sub Tax Type                       
                        var totalTaxAmt = parseFloat($scope.quotationDetail.taxAmount) + parseFloat($scope.quotationDetail.subTaxAmount);
                        
                        $scope.quotationDetail.taxAmt = parseFloat($scope.quotationDetail.taxAmt) + parseFloat(totalTaxAmt);
                    }else{
                        $scope.quotationDetail.taxAmt = parseFloat($scope.quotationDetail.taxAmount).toFixed(2);
                    }
                }         
                   
            }
             
            //row wise Sub Total
            if($scope.quotationDetail.rowSubTotal=="" || $scope.quotationDetail.rowSubTotal==0){
                $scope.quotationDetail.rowSubTotal = parseFloat($scope.quotationDetail.amount) - 
                                                     parseFloat($scope.quotationDetail.disAmt) +
                                                     parseFloat($scope.quotationDetail.taxAmt); 
            }
            $scope.assetQuotation.assetDetailList.push($scope.quotationDetail);           
            
            debugger;
            $scope.calculateGrandTotalAndTaxInfo();
                       
            ngDialog.close();
         }      
         
         
         /**
          * isNan Check... 
          */

         $scope.isNaNCheck = function(value){
             if(isNaN(value)){
                 value=0;
             }
             return value;
         }
         
         /*$scope.calculateGrandTotalAndTaxInfo = function(){
             var subTotal=0, totalDiscount=0, totalTax=0, grandTot=0;
             angular.forEach($scope.assetQuotation.assetDetailList,function(key,index){
                 subTotal = subTotal + parseFloat(key.amount);
                 totalDiscount = totalDiscount + parseFloat(key.disAmt);
                 totalTax = totalTax + parseFloat(key.taxAmt);
                 grandTot=parseFloat(subTotal) + parseFloat(totalTax) - parseFloat(totalDiscount);                
             });
             $scope.assetQuotation.subTotal = subTotal;
             $scope.assetQuotation.totalDiscount = totalDiscount;
             $scope.assetQuotation.totalTax = totalTax;
             $scope.assetQuotation.grandTotal = grandTot.toFixed(2);
         }*/
         /**
          * Calculate subTotal, totalDiscount, totalTax, grandTotal and also total Freight...
          */
         $scope.calculateGrandTotalAndTaxInfo = function(){
             var subTotal=0, totalDiscount=0, totalTax=0, grandTot=0,totalFreight=0;
             angular.forEach($scope.assetQuotation.assetDetailList,function(key,index){
                 subTotal = subTotal + parseFloat(key.amount);
                 totalDiscount = totalDiscount + parseFloat(key.disAmt);
                 totalTax = totalTax + parseFloat(key.taxAmt);
                 grandTot=parseFloat(subTotal) + parseFloat(totalTax) - parseFloat(totalDiscount);                
             });
            var totalFreightAmt = $scope.assetQuotation.totalFreight;
             if(totalFreightAmt!="" && totalFreightAmt!=undefined)
                 totalFreight =  totalFreight + parseFloat(totalFreightAmt);
             
             if(!isNaN(totalFreight))
                 grandTot = grandTot + parseFloat(totalFreight) 
             
             $scope.assetQuotation.subTotal = subTotal.toFixed(2);
             $scope.assetQuotation.totalDiscount = totalDiscount.toFixed(2);
             $scope.assetQuotation.totalTax = totalTax.toFixed(2);
             if(!isNaN(grandTot))
                 $scope.assetQuotation.grandTotal = grandTot.toFixed(2);
         }
    });
});