
'use strict';

app.controller('consAddCtrl', function($scope, $rootScope, $http, $location, logger, ngDialog,
        utilsService,$state,sharedProperties,$window,$stateParams,toaster,validationService,$controller) {
        
        $scope.validate = function(PurchaseOrderForm,purchaseOrder) {
            if (new validationService().checkFormValidity($scope.PurchaseOrderForm)) {
                if(!$rootScope.isEdit){
                    $scope.save(PurchaseOrderForm,purchaseOrder);
                }else{
                    $scope.update(PurchaseOrderForm,purchaseOrder);
                }
            } else {
                toaster.pop('error', "Please fill the required fields", 
                        logger.getErrorHtmlNew($scope.PurchaseOrderForm.$validationSummary), 555000, 'trustedHtml');
            }
        };
        
        $scope.purchaseData = {
                vendorId : '',
                city : '',
                state : '',
                zipcode : '',
                country : '',
                desCity : '',
                desState : '',
                desZipcode : '',
                desCountry : ''
        };
        
        $scope.purchaseOrder = {
                vendorId : '',
                locationId : '',
                purchaseFor:'',
                companyId:'',
                purchaseOrderDate:'',
                purchaseType:'',
                statusId:'',
                termsCondition:'',
                remarks:'',
                conTransNo: ''
        };
        
        
        $scope.quotationDetail = {
                taxId:'',
                taxIdslist:[],
                taxTypeId:'',
                taxType:'',
                taxCode:'',
                taxName:'',
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
                taxPercentage : 0,
                taxAmount : 0,
                subTaxPercentage:0,
                subTaxAmount:0,
                rowSubTotal: 0,
                discountAmount:'',
                discountPercent:''
               
        }
        var i=0;
        $scope.departmentCollections = [];
        $scope.rowCollectionConsignmentPO = [];
        $scope.copyrowCollectionItem = [];
        
        $rootScope.isEdit = false;
        $scope.isEdit = false;
        $scope.contransfer = {};
        $scope.cancel = function(){
            $state.go("app.sea.cons.list");
        };
        var currentDate = new Date();
        currentDate = ('0' + currentDate.getDate()).slice(-2)+"/"+('0' + (Number(currentDate.getMonth())+1)).slice(-2)+"/"+currentDate.getFullYear();
        $scope.purchaseOrder.purchaseOrderDate = currentDate;
        $scope.rowCollectionItem =[];
        $scope.displayedCollectionItem = [];
        $scope.destinationList = [];
        $scope.addressList = [];
        $scope.location = {};
        $scope.vendor = {};
        $scope.conTransNoList = [];
        $scope.getListOfDropdowns = function() {
            $http.get('app/purchaseOrder/getListOfDropdowns1').success(function(data) {
                if (data.success == true) {
                    $scope.purchaseForList=data.purchaseFrom;
                   // $scope.hospitalList=data.companyList;
                    $scope.destinationList=data.locationList;
                    $scope.purchaseTypeList = data.purchaseTo;
                    $scope.vendorList = data.vendorList;
                    $scope.statusList= data.purchaseStatus;
                    $scope.addressList = data.commonUtilityBeans;
                    $scope.conTransNoList  = data.conTransferNoList;
                    $scope.purchaseOrder.purchaseType = "45";
                    $scope.purchaseOrder.statusId = "46";
                    $scope.purchaseOrder.termsCondition = data.termsAndConditions;
                  
                }
            });
        };
        
        $http.get('app/commonUtility/getCompanyListPurchase').success(function(datas) {
            $scope.hospitalList = datas;
            }).error(function(datas) {
        });
        
        $scope.getListOfDropdowns();
        $scope.loadVendorAddress = function(){
            var foundItem = $filter('filter')($scope.vendorList, { id:  $scope.purchaseOrder.vendorId })[0];
            var index = $scope.vendorList.indexOf(foundItem);
            if(index>-1){
            $scope.purchaseData.desCity1= $scope.vendorList[index].city;
            $scope.purchaseData.desAddress1 = $scope.vendorList[index].address;
            $scope.purchaseData.desState1 = $scope.vendorList[index].state;
            $scope.purchaseData.desCountry1 =  $scope.vendorList[index].country;
            $scope.purchaseData.desZipcode1 = $scope.vendorList[index].zipCode;
            //$scope.purchaseOrder.paymentTerms= $scope.vendorList[index].paymentTerms;
            }else{
                $scope.purchaseData.desCity1= '';
                $scope.purchaseData.desAddress1 = '';
                $scope.purchaseData.desState1 = '';
                $scope.purchaseData.desCountry1 =  '';
                $scope.purchaseData.desZipcode1 = ''; 
            }
            
        };
        $scope.loadDestAddress = function(){ 
            var foundItem = $filter('filter')($scope.destinationList, { id:  $scope.purchaseOrder.locationId })[0];
            var index = $scope.destinationList.indexOf(foundItem);
        if(index>-1){
               $scope.purchaseData.desCity= $scope.destinationList[index].city;
               $scope.purchaseData.desAddress = $scope.destinationList[index].address;
               $scope.purchaseData.desState = $scope.destinationList[index].state;
               $scope.purchaseData.desCountry =  $scope.destinationList[index].country;
               $scope.purchaseData.desZipcode = $scope.destinationList[index].zipCode;
        }
        else{
            $scope.purchaseData.desCity= '';
            $scope.purchaseData.desAddress = '';
            $scope.purchaseData.desState = '';
            $scope.purchaseData.desCountry =  '';
            $scope.purchaseData.desZipcode = '';
        }
        };
        
        $scope.purchaseOrder['subTotal'] = 0.0;
        $scope.purchaseOrder['totalDiscount'] = 0.0;
        $scope.purchaseOrder['totalTax']=0.0;
        $scope.purchaseOrder['freight'] = 0.0;
        
        $scope.save = function(purchaseOrderForm,purchaseOrderBean){
            
            var isCheck = false;
            purchaseOrderBean['conTransNo'] = $scope. purchaseOrder.conTransNo;
            $scope.loadcalculation($scope.rowCollectionItem);
            
            if($scope.purchaseOrderDetails.length > 0){
                purchaseOrderBean["purchaseOrderDetails"] = $scope.purchaseOrderDetails;
                var tableEnteredData = purchaseOrderBean;
                
                angular.forEach($scope.rowCollectionItem,function(value,key){
                    if(value.quantity<=0){
                        isCheck = true;
                        value.quantity="";
                    }
                });
                
                if(isCheck){
                    logger.logError("Quantity Should be Greater than 0!");
                }else{
                    
                    var isZero = false;
                    
                    angular.forEach($scope.rowCollectionItem,function(value,key){
                        if(value.quantity==""){
                            isZero = true;
                        }
                    });
                    
                    if(isZero){
                        logger.logError("Please Enter Quantity!");
                    }else{
                        $http.post('app/purchaseOrder/saveConsignmentOrder', tableEnteredData).success(function(result) {
                            if(result.success){
                                logger.logSuccess("Consignment PO added successfully");
                                $state.go("app.sea.cons.list");
                            }else{
                                logger.logError("Purchase does not added.Something went wrong.");
                                return false;
                            }
                        });
                    }
                    
                }
                
            }
            else{
                logger.logError("Please add an item to save the purchase order.");
            }
        };
        
        
     

        $scope.isNaNCheck = function(value){
            if(isNaN(value)){
                value=0;
            }
            return value;
        }
    
        
      
        $scope.calculateTaxDiscount=function(rowCollection){
          //  alert("Tstww");
            console.log("Row Collection is");
            console.log(rowCollection);
            debugger;
            rowCollection['finalTotal'] = 0;
            rowCollection['total'] = 0;
            rowCollection.price = Number(rowCollection.price);
            if(rowCollection.quantity != null && angular.isString(rowCollection.quantity)){
            rowCollection.quantity = Number(rowCollection.quantity.replace(/[^0-9]/g, ''));
            }
            rowCollection.price = Number(Number(rowCollection.quantity) * rowCollection.unitPrice).toFixed(2);
            var discountTaxDetail = rowCollection.quoteTaxDetail;
            if(discountTaxDetail.discountType == "Amount"){
                discountTaxDetail.discountAmount = discountTaxDetail.discountAmount ? discountTaxDetail.discountAmount : 0;
                if(rowCollection.vendorQuantity > 0){
                   var unitDiscount=discountTaxDetail.discountAmount/rowCollection.vendorQuantity;
                   rowCollection.discount=Number(Number(rowCollection.quantity)*Number(unitDiscount)).toFixed(2);
               }else{
                   rowCollection.discount = Number(discountTaxDetail.discountAmount).toFixed(2);
               }
              
            }
            else if(discountTaxDetail.discountType == "Percentage"){
                discountTaxDetail.dicountPercentage = discountTaxDetail.dicountPercentage ? discountTaxDetail.dicountPercentage : 0;
                rowCollection.discount = Number(Number(rowCollection.price)*(discountTaxDetail.dicountPercentage/100)).toFixed(2);
            }
            if(rowCollection.price >= rowCollection.discount){
                rowCollection['total'] = rowCollection.price - rowCollection.discount;
                rowCollection['finalTotal'] = 0;
            }
            else if(rowCollection.price < rowCollection.discount){
                rowCollection['total'] = Number(Number(rowCollection.price) - Number(rowCollection.discount)).toFixed(2);
                rowCollection['finalTotal'] = 0;
            }
            
            rowCollection['finalTotal'] = (Number(rowCollection.total) + Number(rowCollection.tax)).toFixed(2);
            $scope.calculateTotal();
         /*   if(discountTaxDetail.taxType == "Fixed Amount"){
                discountTaxDetail.taxAmount = discountTaxDetail.taxAmount ? discountTaxDetail.taxAmount : 0;
                rowCollection.tax = discountTaxDetail.taxAmount;
                rowCollection.tax = Number(discountTaxDetail.taxAmount).toFixed(2);
            }else if(discountTaxDetail.taxType == "Percentage"){
                discountTaxDetail.taxPercentage = discountTaxDetail.taxPercentage ? discountTaxDetail.taxPercentage : 0;
                rowCollection.tax = rowCollection.price*(discountTaxDetail.taxPercentage/100);
                rowCollection.tax = Number(rowCollection.tax).toFixed(2);
            }*/
           
          
            //$scope.checkPartiallyVerified(rowCollection);
        }
        
      
        
      
        
        
        $scope.calculateTaxDetails = function(rowCollection,taxArray) {
           
            var arrayLength = taxArray.length;
          
           if (arrayLength != i) {
                if (taxArray[i] != "" && taxArray[i] != undefined && taxArray[i] != null) {
                    var taxId = taxArray[i]
                    $http.get("hospital/purchase/quotation/getTaxDetails?taxId=" + taxArray[i]).success(function(response) {
                        if (response.success == true) {
                            console.log("response");
                            console.log(response);
                            $scope.taxPercentage = 0;
                            $scope.taxAmount = 0;
                            $scope.subTaxPercentage = 0;
                            $scope.subTaxAmount = 0;
                            $scope.quotationDetail.subTaxTypeAmt = "";
                            $scope.quotationDetail.subTaxTypePercent = "";
                            
                           
                            $scope.quotationDetail.quantity=rowCollection.quantity;
                            $scope.quotationDetail.unitPrice=rowCollection.unitPrice;
                          
                            if (response.purchaseQuotationDetail.taxType == "Percentage") {
                                $scope.taxPercentage = response.purchaseQuotationDetail.taxPercentage;
                                $scope.quotationDetail.taxType = response.purchaseQuotationDetail.taxType;
                                if ($scope.quotationDetail.taxCode != null && $scope.quotationDetail.taxCode != '' && $scope.quotationDetail.taxCode != undefined) {
                                    $scope.quotationDetail.taxCode = $scope.quotationDetail.taxCode + "," + response.purchaseQuotationDetail.taxCode;
                                } else {
                                    $scope.quotationDetail.taxCode = $scope.quotationDetail.taxCode + response.purchaseQuotationDetail.taxCode;
                                }

                            } else if (response.purchaseQuotationDetail.taxType == "Fixed Amount") {
                                $scope.taxAmount = response.purchaseQuotationDetail.taxAmount;
                                $scope.quotationDetail.taxType = response.purchaseQuotationDetail.taxType;
                                if ($scope.quotationDetail.taxCode != null && $scope.quotationDetail.taxCode != '' && $scope.quotationDetail.taxCode != undefined) {
                                    $scope.quotationDetail.taxCode = $scope.quotationDetail.taxCode + "," + response.purchaseQuotationDetail.taxCode;
                                } else {
                                    $scope.quotationDetail.taxCode = $scope.quotationDetail.taxCode + response.purchaseQuotationDetail.taxCode;
                                }


                            }
                            angular.forEach(response.purchaseQuotationDetail.subTaxList, function(key, index) {
                                if (key.subTaxType == "Percentage") {
                                    $scope.subTaxPercentage = key.subTaxPercentage;
                                    $scope.quotationDetail.subTaxTypePercent = key.subTaxType;
                                }
                                if (key.subTaxType == "Fixed Amount") {
                                    $scope.subTaxAmount = key.subTaxAmount;
                                    $scope.quotationDetail.subTaxTypeAmt = key.subTaxType;
                                }
                            });


                            $scope.quotationDetail.taxPercentage = $scope.isNaNCheck(parseFloat($scope.taxPercentage));

                            $scope.quotationDetail.taxAmount = $scope.isNaNCheck(parseFloat($scope.taxAmount));

                            $scope.quotationDetail.subTaxPercentage = $scope.isNaNCheck(parseFloat($scope.subTaxPercentage));

                            $scope.quotationDetail.subTaxAmount = $scope.isNaNCheck(parseFloat($scope.subTaxAmount));

                            $scope.quotationDetail.unitPrice = $scope.isNaNCheck(parseFloat($scope.quotationDetail.unitPrice));

                            $scope.quotationDetail.amount = (parseFloat($scope.quotationDetail.unitPrice) * parseFloat($scope.quotationDetail.quantity)).toFixed(2);

                            //Tax Details - Tax Percentage

                            var totalTaxPercentage = (parseFloat($scope.quotationDetail.taxPercentage)) +
                                (parseFloat($scope.quotationDetail.subTaxPercentage));

                            if ($scope.quotationDetail.taxPercentage != "" || $scope.quotationDetail.taxPercentage != 0) { //tax_percentage
                                if ($scope.quotationDetail.taxType == 'Percentage') { //tax Type
                                    if ($scope.quotationDetail.subTaxTypePercent == 'Percentage') {
                                        //sub Tax Type
                                        $scope.quotationDetail.taxAmt = (parseFloat($scope.quotationDetail.amount) * (totalTaxPercentage / 100)).toFixed(2);
                                    }
                                    if ($scope.quotationDetail.subTaxTypeAmt == "Fixed Amount") { //sub Tax Type

                                        var taxPercentAmt = (parseFloat($scope.quotationDetail.amount) * (totalTaxPercentage / 100)).toFixed(2);

                                        $scope.quotationDetail.taxAmt = (parseFloat(taxPercentAmt) + parseFloat($scope.quotationDetail.subTaxAmount)).toFixed(2);
                                    }

                                    if (($scope.quotationDetail.subTaxTypePercent == '' || $scope.quotationDetail.subTaxTypePercent == null || $scope.quotationDetail.subTaxTypePercent == undefined ||
                                            $scope.quotationDetail.subTaxTypePercent == " ") && ($scope.quotationDetail.subTaxTypeAmt == '' || $scope.quotationDetail.subTaxTypeAmt == undefined ||
                                            $scope.quotationDetail.subTaxTypeAmt == null || $scope.quotationDetail.subTaxTypeAmt == " ")) {

                                        $scope.quotationDetail.taxAmt = ((parseFloat($scope.quotationDetail.amount)) *
                                            parseFloat($scope.quotationDetail.taxPercentage / 100)).toFixed(2);



                                    }


                                }

                            }
                            //Tax Details - Tax Amount
                            if ($scope.quotationDetail.taxAmount != "" || $scope.quotationDetail.taxAmount != 0) { //tax_amount

                                if ($scope.quotationDetail.taxType == "Fixed Amount") { //tax type
                                    if ($scope.quotationDetail.subTaxTypePercent == 'Percentage') { //sub Tax Type

                                        var totalSubTaxPercentAmt = parseFloat($scope.quotationDetail.amount) * (totalTaxPercentage / 100);

                                        $scope.quotationDetail.taxAmt = (parseFloat($scope.quotationDetail.taxAmount) + parseFloat(totalSubTaxPercentAmt)).toFixed(2);
                                    }
                                    if ($scope.quotationDetail.subTaxTypeAmt == "Fixed Amount") {

                                        //sub Tax Type
                                        var totalTaxAmt = parseFloat($scope.quotationDetail.taxAmount) + parseFloat($scope.quotationDetail.subTaxAmount);
                                        $scope.quotationDetail.taxAmt = parseFloat(totalTaxAmt).toFixed(2);
                                    }

                                    if (($scope.quotationDetail.subTaxTypePercent == '' || $scope.quotationDetail.subTaxTypePercent == null || $scope.quotationDetail.subTaxTypePercent == undefined ||
                                            $scope.quotationDetail.subTaxTypePercent == " ") && ($scope.quotationDetail.subTaxTypeAmt == '' || $scope.quotationDetail.subTaxTypeAmt == undefined ||
                                            $scope.quotationDetail.subTaxTypeAmt == null || $scope.quotationDetail.subTaxTypeAmt == " ")) {

                                        $scope.quotationDetail.taxAmt = parseFloat($scope.quotationDetail.taxAmount).toFixed(2);
                                    }


                                }

                            }
                            
                        /*    alert("$scope.totalTaxAmount"+$scope.totalTaxAmount);
                            
                            alert("taxAmt"+$scope.quotationDetail.taxAmt);*/
                            $scope.totalTaxAmount = Number($scope.totalTaxAmount) + Number($scope.quotationDetail.taxAmt);

                            $scope.totalTaxAmount = $scope.totalTaxAmount.toFixed(2);


                            $scope.totalTaxPercentageValue = Number($scope.totalTaxPercentageValue) + Number(totalTaxPercentage);
                            $scope.totalTaxPercentageValue = $scope.totalTaxPercentageValue.toFixed(2);

                            i++;
                            $scope.calculateTaxDetails(rowCollection,taxArray);
                        } else {

                            $scope.taxPercentage = '';
                            $scope.taxAmount = '';
                            $scope.quotationDetail.taxType = '';
                            $scope.quotationDetail.taxCode = '';

                            $scope.subTaxPercentage = '';
                            $scope.subTaxAmount = '';
                            $scope.quotationDetail.subTaxType = '';
                            i++;
                            $scope.calculateTaxDetails(rowCollection,taxArray);
                        }
                    });
                } else {
                    $scope.taxPercentage = '';
                    $scope.taxAmount = '';
                    $scope.quotationDetail.taxType = '';

                    $scope.subTaxPercentage = '';
                    $scope.subTaxAmount = '';
                    $scope.quotationDetail.subTaxType = '';
                }
            }
            if (arrayLength == i) {
              
               rowCollection.tax=$scope.totalTaxAmount;
                //alert(rowCollection.tax);
               //rowCollection['tax']=$scope.totalTaxAmount;
                rowCollection.finalTotal = (Number(rowCollection.total) + Number(rowCollection.tax)).toFixed(2);
                console.log("Row collection items");
                console.log($scope.rowCollectionItem);
                gblLength++;
            
                $scope.calculateTotal();
                $scope.calculateMultiTax();
              
            }
            
        }
        
        $scope.calculateTotal = function(){
            console.log("Row collection items");
            console.log($scope.rowCollectionItem);
            var subTotal = 0;var totalDiscount = 0;var totalTax =0 ;var totalAmount = 0;
            for(var i=0;i<$scope.rowCollectionItem.length;i++){
                if($scope.rowCollectionItem[i].edit !=2){
                    var rowObj = $scope.rowCollectionItem[i];
                    rowObj.price = rowObj.price ? rowObj.price : 0;
                    rowObj.discount = rowObj.discount  ? rowObj.discount : 0;
                    rowObj.tax = rowObj.tax ? rowObj.tax : 0;
                    rowObj.finalTotal = rowObj.finalTotal ? rowObj.finalTotal : 0;
                    subTotal += Number(rowObj.price);
                    totalDiscount += Number(rowObj.discount);
                    totalTax += Number(rowObj.tax);
                    totalAmount += Number(rowObj.finalTotal);   
                }
            }
            
            $scope.purchaseOrder.subTotal = Number(subTotal).toFixed(2);
            totalDiscount = totalDiscount ? totalDiscount: 0; 
            $scope.purchaseOrder.totalDiscount = Number(totalDiscount).toFixed(2);
            totalTax = totalTax ? totalTax : 0;
            $scope.purchaseOrder.totalTax =  Number(totalTax).toFixed(2);
            var frieght = angular.copy($scope.purchaseOrder.freight);
            $scope.purchaseOrder.totalAmount = Number(totalAmount+Number(frieght)).toFixed(2);
            
        };
        
        
        $scope.update = function(purchaseOrderForm,purchaseOrderBean){
            if($scope.rowCollectionItem.length==0){
                logger.logError("Please Add Atleast One Row!");
            }else{
                
                var isCheck = false;
                purchaseOrderBean['conTransNo'] = $scope.purchaseOrder.conTransNo;
                console.log("Row Collection");
                console.log($scope.rowCollectionItem); 
                $scope.loadUpdateCalculation($scope.rowCollectionItem);
                purchaseOrderBean["purchaseOrderDetails"] = $scope.purchaseOrderDetails;
                delete purchaseOrderBean.purchaseQuoteDetails;
                purchaseOrderBean.isDeletedIds=$scope.deletedIds;
                var tableEnteredData = purchaseOrderBean;
                
                angular.forEach($scope.rowCollectionItem,function(value,key){
                    if(value.quantity<=0){
                        isCheck = true;
                        value.quantity="";
                    }
                });
                
                if(isCheck){
                    logger.logError("Quantity Should be Greater than 0!");
                }else{
                    var isZero = false;
                    
                    angular.forEach($scope.rowCollectionItem,function(value,key){
                        if(value.quantity==""){
                            isZero = true;
                        }
                    });
                    
                    if(isZero){
                        logger.logError("Please Enter Quantity!");
                    }else{
                        $http.post('app/purchaseOrder/updateConsignmentOrder', tableEnteredData).success(function(result) {
                            if(result.success){
                                logger.logSuccess("Consignment PO Updated successfully");
                                $state.go("app.sea.cons.list");
                            }else{
                                logger.logError("Purchase does not added.Something went wrong.");
                                return false;
                            }
                        });
                    }
                }
           
            }
        };
        
        $scope.chkAll=false;
        $scope.checkAll = function (rowCollectionItem,checkBox) {
            if (checkBox) {
                $scope.chkAll=true;
            } else {
                $scope.chkAll = false;
            }
            angular.forEach($scope.rowCollectionItem, function (value,key) {
                value.isSelected = $scope.chkAll;
            });
           
        };
        
        $scope.chkAll=false;
        $scope.checkAllItem = function (rowCollectionItem,checkBox) {
            if (checkBox) {
                $scope.chkAll=true;
            } else {
                $scope.chkAll = false;
            }
            angular.forEach($scope.rowCollectionItem, function (value,key) {
                value.select = $scope.chkAll;
            });
           
        };
        
        $scope.addPurchaseRow = function() {
            if(!$rootScope.isEdit){
                if($scope.vendor.id != undefined && $scope.purchaseOrder.conTransNo !=undefined ){
                    var consignmentTransNo = $scope.purchaseOrder.conTransNo;
                    $scope.callDialog($scope, 0, $http, ngDialog, logger, $injector, sharedProperties,
                            toaster, $rootScope,consignmentTransNo);
                }else{
                    logger.logError("Please select a vendor and consignment Number to add  a Purchase Order.");
                }
            }else {
                if($scope.vendor.id != undefined && $scope.purchaseOrder.conTransNo !=undefined ){
                    var consignmentTransNo = $scope.purchaseOrder.conTransNo;
                    $scope.callDialog($scope, 0, $http, ngDialog, logger, $injector, sharedProperties,
                            toaster, $rootScope,consignmentTransNo);
                }else{
                    logger.logError("Please select a vendor and consignment Number to add  a Purchase Order.");
                }
            }
        };
        
        $scope.callDialog = function($scope, requestCode, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope,consignmentTransNo) {
            requestCode = $scope.vendor;
            ngDialog.open({
                scope : $scope,
                template : 'views/sea/cons/ConsignmentPOQuoteListAdd',
                controller : $controller('consignmentPORequestAddCtrl', {
                    $scope : $scope,
                    requestCode : requestCode,
                    consignmentTransNo:consignmentTransNo,
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
        };
        
        $scope.getListValueEdit = function(data,addQuoteStatus,rowCollection){
            var isDetailSelected = false;
            var isExists = 0;
      
            if(data !=undefined){
                
                for(var i=0;i<data.length;i++){
                    isDetailSelected = true;
                    
                    if($scope.purchaseData.vendorId!=undefined){
                        data[i].vendorId = $scope.purchaseData.vendorId;
                        data[i].vendorName = $scope.vendor.text;
                    }
                     angular.forEach(rowCollection, function(value, key){
                      if(value.purchaseQuoteDetailId==data[i].purchaseQuoteDetailId && value.itemId==data[i].itemId ){
                         data[i].purchaseOrderDetailId = value.purchaseOrderDetailId;
                         data[i].quantity=value.quantity;
                        }
                    });
                  
                    data[i].unitPrice = Number(data[i].unitPrice).toFixed(2);
                    data[i].price =Number( Number(data[i].quantity)*data[i].unitPrice).toFixed(2);
                    data[i].statusId = addQuoteStatus;
                    data[i].select = true;
                    
                    if($scope.purchaseOrder.paymentTerms == 0 || $scope.purchaseOrder.paymentTerms == null || $scope.purchaseOrder.paymentTerms == ''){
                        $scope.purchaseOrder.paymentTerms = data[i].paymentTerms;
                    }
                    
                    $scope.rowCollectionItem.push(data[i]);
                    if(isDetailSelected){
                        ngDialog.close();
                    }
                        
                }
            }
            
         };
        
         
         var gblLength=0;
        $scope.getListValue = function(data,addQuoteStatus){
            gblLength=0;
            var isDetailSelected = false;
            var isExists = 0;
            var isFreight = 0;
            $scope.purchaseOrder.freight=0;
            $scope.purchaseOrder.paymentTerms = '';
            
            if(data !=undefined){
                
                for(var i=0;i<data.length;i++){
                    isDetailSelected = true;
                    
                    if($scope.purchaseData.vendorId!=undefined){
                        data[i].vendorId = $scope.purchaseData.vendorId;
                        data[i].vendorName = $scope.vendor.text;
                    }
                    
                    data[i].purchaseOrderDetailId = data[i].purchaseOrderDetailId;
                    data[i].unitPrice = Number(data[i].unitPrice).toFixed(2);
                    data[i].price =Number( Number(data[i].quantity)*data[i].unitPrice).toFixed(2);
                    data[i].statusId = addQuoteStatus;
                    data[i].select = true;
                    
                 /*   if(data[i].frieght!=null){
                        isFreight = isFreight+data[i].frieght;
                    }*/
                    
                    if($scope.purchaseOrder.paymentTerms == 0 || $scope.purchaseOrder.paymentTerms == null || $scope.purchaseOrder.paymentTerms == ''){
                        $scope.purchaseOrder.paymentTerms = data[i].paymentTerms;
                    }
                    if(data[i].frieght!=null){
                        var isFrieghtExist=true;
                        angular.forEach($scope.rowCollectionItem, function (value1, key1) {   
                            if(value1.purchaseQuoteId==data[i].purchaseQuoteId ){
                                isFrieghtExist=false;
                            }
                        });
                        if(isFrieghtExist==true){
                            isFreight = isFreight+data[i].frieght;
                        }
                    }
                    $scope.rowCollectionItem.push(data[i]);
                    if(isDetailSelected){
                        ngDialog.close();
                    }
                        
                }
                if($scope.purchaseOrder.freight!=undefined && $scope.purchaseOrder.freight!=null && $scope.purchaseOrder.freight!=''){
                    $scope.purchaseOrder.freight =  Number($scope.purchaseOrder.freight)+isFreight;
                }else{
                    $scope.purchaseOrder.freight =  isFreight;
                }
            }
            gblLength=0;
            $scope.calculateMultiTax();
            
              
         };
       
         
       
         
         $scope.calculateMultiTax = function(){
           
             if(gblLength <= $scope.rowCollectionItem.length){
              
                 i=0;
                 $scope.totalTaxAmount=0;
                 $scope.totalTaxPercentageValue=0;
                 $scope.quotationDetail.taxCode="";
                 console.log("Row collection");
                 console.log($scope.rowCollectionItem);
                 console.log($scope.rowCollectionItem[gblLength].quoteTaxDetail.taxIdslist);
                 $scope.calculateTaxDetails($scope.rowCollectionItem[gblLength],$scope.rowCollectionItem[gblLength].quoteTaxDetail.taxIdslist);
             }
            
         } 
         
         
         
         
        $scope.loadcalculation = function(rowCollectionItem){
            $scope.purchaseOrderDetails = [];
            for(var i=0;i<rowCollectionItem.length;i++){
                var obj = {
                        purchaseQuoteDetailId : rowCollectionItem[i].purchaseQuoteDetailId,
                        purchaseItemId :rowCollectionItem[i].itemId,
                        unitPrice :Number(rowCollectionItem[i].unitPrice).toFixed(2),
                        quantity : rowCollectionItem[i].quantity ,
                        purchaseStatusId : rowCollectionItem[i].statusId,
                        discount: Number(rowCollectionItem[i].discount).toFixed(2),
                        tax:  Number(rowCollectionItem[i].tax).toFixed(2)
                };
                $scope.purchaseOrderDetails.push(obj);
            }
        };
        $scope.loadUpdateCalculation = function(rowCollectionItem){
            $scope.purchaseOrderDetails = [];
            for(var i=0;i<rowCollectionItem.length;i++){
                var obj = {
                        purchaseQuoteDetailId : rowCollectionItem[i].purchaseQuoteDetailId,
                        purchaseItemId :rowCollectionItem[i].itemId,
                        unitPrice : Number(rowCollectionItem[i].unitPrice).toFixed(2),
                        quantity : rowCollectionItem[i].quantity ,
                        purchaseStatusId : rowCollectionItem[i].purchaseStatusId,
                        discount: Number(rowCollectionItem[i].discount).toFixed(2),
                        tax: Number(rowCollectionItem[i].tax).toFixed(2),
                        edit:rowCollectionItem[i].edit,
                        purchaseOrderDetailId:rowCollectionItem[i].purchaseOrderDetailId
                };
                $scope.purchaseOrderDetails .push(obj);
            }
        };
        
        $scope.$watch('destinationList',function(newVal, oldVal){
           if(newVal.length > 0){
               $scope.callEdit();
           } 
        });
        var purchaseOrderId = $location.search().purchaseOrderId;
        $scope.callEdit = function(){
        if(purchaseOrderId!=undefined){
            var editUrl = 'app/purchaseOrder/editPurchaseOrder';
            $http({
                url : editUrl,
                params : {
                    "purchaseOrderId" : purchaseOrderId
                },
                method : "GET",
                datatype : 'JSON',
                'Accept' : 'application/json',
                headers : {
                    'Content-Type' : 'application/json'
                }

            }).success(function(data) {
                console.log("Edit Respnse");
                console.log(data);
                var termsforPayment = data.paymentTerms;
                $scope.purchaseOrder = data;
                data.locationId = Number(data.locationId);
                data.vendorId = data.vendorId.toString();
                var foundLocation = $filter('filter')($scope.destinationList, { id: data.locationId })[0];
                $scope.location = foundLocation;
                var foundVendorLocation = $filter('filter')($scope.vendorList, { id: data.vendorId })[0];
                $scope.vendor = foundVendorLocation;
                $scope.loadDestAddress();
                $scope.loadVendorAddress();
                
                $scope.purchaseOrder.freight = data.freight;
                
                $http.get('app/purchaseOrder/getListOfDropdownsEdit').success(function(data) {
                    if (data.success == true) {
                        $scope.conTransNoList  = data.conTransferNoList;
                    }
                });
                
                var foundStockNumber = $filter('filter')($scope.conTransNoList, { id: data.conTransNo })[0];
                $scope.contransfer = foundStockNumber;
                if(data.conTransNo !=null){
                $scope.purchaseOrder.conTransNo = data.conTransNo.toString();
            }
                if(data.statusId != null){
                    $scope.purchaseOrder.statusId = data.statusId.toString(); 
                }
                if(data.purchaseFor !=null){
                    $scope.purchaseOrder.purchaseFor = data.purchaseFor.toString();
                }
                if(data.purchaseType !=null){
                    $scope.purchaseOrder.purchaseType = data.purchaseType.toString();
                }
                $scope.purchaseOrder.paymentTerms= termsforPayment;
                console.log("Edit is");
                
                console.log(data.purchaseQuoteDetails);
                for(var i=0;i<data.purchaseQuoteDetails.length;i++){
                   
                    data.purchaseQuoteDetails[i].purchaseOrderDetailId = data.purchaseQuoteDetails[i].purchaseOrderDetailId;
                    data.purchaseQuoteDetails[i].unitPrice = Number(data.purchaseQuoteDetails[i].unitPrice).toFixed(2);
                    data.purchaseQuoteDetails[i].price = Number(data.purchaseQuoteDetails[i].quantity*data.purchaseQuoteDetails[i].unitPrice).toFixed(2);
                 
                    $scope.rowCollectionItem.push(data.purchaseQuoteDetails[i]);
               
                }
                $rootScope.isEdit = true;
                $scope.isEdit = true;
                
                
            });
        }
        };
       
    
        $scope.deletedIds=[];
        
        $scope.removePurchaseRow =function(){
            $scope.copytablerow = [];
            for(var i=0;i< $scope.rowCollectionItem.length;i++){
                  if($scope.rowCollectionItem[i].select){
                      $scope.deletedIds.push({"purchaseOrderDetailId":$scope.rowCollectionItem[i].purchaseOrderDetailId,"itemId":$scope.rowCollectionItem[i].itemId});
                      $scope.rowCollectionItem.splice(i, 1);
                  }
            }
            
            
            var isFreight=0;
            for(var i=0;i<$scope.rowCollectionItem.length;i++){
                if($scope.rowCollectionItem[i].edit !=2){
                    if($scope.rowCollectionItem[i].frieght!=null){
                        var isFrieghtExist=true;
                        angular.forEach($scope.copytablerow, function (value1, key1) {   
                            if(value1.purchaseQuoteId==$scope.rowCollectionItem[i].purchaseQuoteId ){
                                isFrieghtExist=false;
                            }
                        });
                        if(isFrieghtExist==true){
                            isFreight = isFreight+$scope.rowCollectionItem[i].frieght;
                        }
                        $scope.copytablerow.push($scope.rowCollectionItem[i]);
                    }
                    
                }
            }
           
            $scope.purchaseOrder.freight =  isFreight;
        };
      
      //Top find which object Property is Updated  
        var purchaseObj = angular.copy($scope.purchaseOrder,purchaseObj);
        var arrayOfValues = Object.keys(purchaseObj);
        $scope.checkWhichVariableHasUpdated = function(watchGroupList, newValuesObj, oldValuesObj) {
          var _lastUpdatedValue = null;
          angular.forEach(watchGroupList, function(value) {
              if (newValuesObj[value] != oldValuesObj[value])
                  _lastUpdatedValue = value;
          });
          $scope.selectedObj = newValuesObj;
          return _lastUpdatedValue;
      };

      //To load Dependent DropDown 
      $scope.loadDropDown = function(changedVariable) {
          switch (changedVariable) {
              case "locationId":
                  $scope.loadDestAddress();
                  break;
              case "vendorId":
                  $scope.loadVendorAddress();
                  break;
              case "freight":
                  $scope.calculateTotal();
                  break;
               }
      };

      //To watch a Object Collection
      $scope.$watchCollection('purchaseOrder', function(newVal, oldVal) {
          if(newVal !=undefined){
          var last_changed = $scope.checkWhichVariableHasUpdated(arrayOfValues, newVal, oldVal);
          if (angular.isDefined(last_changed) && last_changed != null) {
              $scope.loadDropDown(last_changed);
          }
          }
      },true);
        
    /*  $scope.checkPartiallyVerified = function(row){
          if(row.vendorMinQty !=null){
              if(Number(row.quantity) < Number(row.vendorMinQty))
              {  
                 row.quantity = Number(row.vendorMinQty);
                 logger.logError("Vendor Quantity Cannot Be Lower than Miniumum Quantity.");
              } 
        }
      };*/
      
      /**
       * Reset Functionality ******************************
       */
      
      var originalDatas = angular.copy($scope.purchaseOrder);
      var originalTableDatas = angular.copy($scope.rowCollectionItem);
      var originalAddress = angular.copy($scope.purchaseData);
      var originalVendorAddress = angular.copy($scope.vendor);
      
      $scope.reset = function(){
          if($scope.isEdit==false){
              $scope.purchaseOrder = angular.copy(originalDatas);
              $scope.purchaseData = angular.copy(originalAddress);
              $scope.rowCollectionItem = angular.copy(originalTableDatas);
              $scope.vendor = angular.copy(originalVendorAddress); 
              $scope.purchaseOrder.purchaseType = "45";
              $scope.purchaseOrder.statusId = "46";
              $scope.purchaseOrder.conTransNo = '';
              $scope.PurchaseOrderForm.$setPristine();
             
          }else{
              $scope.callEdit();
          }
      }
      
      // Fetching Details
      $scope.$watch('purchaseOrder.conTransNo', function(newValue, oldValue) {
          if (newValue != '' && newValue != undefined) {
              if($scope.isEdit==false){
                  $scope.getConsignmentTransferPurchaseQuotation(newValue);
              }
          
          }else{
              $scope.rowCollectionConsignmentPO = [];
          }

      });
      
      $scope.getConsignmentTransferPurchaseQuotation = function(consignmentTransNo){
          $scope.rowCollectionConsignmentPO = [];
        
          var url = 'app/purchaseOrder/getApprovedConsignmentStockDetail?&stockTransferId='+consignmentTransNo+'&purchaseType='+$scope.purchaseOrder.purchaseType;
          $http.get(url).success(function(data) {
              if (data) {
                  $scope.rowCollectionConsignmentPO = data;
                  console.log("getListItems");
                  console.log(data);
                  angular.forEach(data, function(value, key){
                      if(value.purchaseQuantity > 0){
                          var ratio=value.purchaseQuantity/value.vendorQuantity;
                          value.quantity= value.quantity/ratio;
                      }
                     
                  });
                  
                
               }
              if($scope.isEdit==false){
                  $scope.rowCollectionItem = [];
                  $scope.getListValue($scope.rowCollectionConsignmentPO,72);    
              }else{
                  $scope.copyrowCollectionItem =$scope.rowCollectionItem;
                  $scope.rowCollectionItem=[];
                  $scope.getListValueEdit($scope.rowCollectionConsignmentPO,72,$scope.copyrowCollectionItem);    
              }
              
          }).error(function(data) {
              logger.logError("Error Please Try Again");
          });
          
      };
    
    });
    
    module.registerController('consignmentPORequestAddCtrl', function($scope, $http, ngDialog, logger, requestCode,
            $injector, sharedProperties, toaster, $rootScope,consignmentTransNo) {
       
        $scope.cancelReq = function() {
            ngDialog.close();
        };
        
        $scope.addQuoteStatus = "72";
        
        $scope.chkAll=false;
        $scope.checkAll = function (rowCollection,checkBox) {
            if (checkBox) {
                $scope.chkAll=true;
            } else {
                $scope.chkAll = false;
            }
            angular.forEach($scope.rowCollection, function (value,key) {
                value.select = $scope.chkAll;
            });
        };
        
        $scope.getListOfDropdowns = function() {
            $http.get('app/purchaseOrder/getDetailStatus').success(function(data) {
                if (data.success == true) {
                    $scope.statusList= data.purchaseStatus;
                  
                }
            });
        };
        $scope.getListOfDropdowns();
        $scope.departmentCollections = [];
        $scope.rowCollection = [];
        
        var currentDate = new Date();
        currentDate = ('0' + currentDate.getDate()).slice(-2)+"/"+('0' + (Number(currentDate.getMonth())+1)).slice(-2)+"/"+currentDate.getFullYear();
        $scope.purchaseData.requestFromDate = currentDate;
        $scope.purchaseData.requestToDate = currentDate;
        
        $scope.vendorName = requestCode.text;
        $scope.changeStatus= function (ac){
            $scope.addQuoteStatus = ac;
        };
        $scope.getApprovedPurchaseQuotation = function(purchaseData){
            $scope.getQuoteStatus($scope.addQuoteStatus);
            var url = 'app/purchaseOrder/getApprovedPurchasedStockDetail?purchaseDateFrom='+purchaseData.requestFromDate+
            '&purchaseDateTo='+purchaseData.requestToDate+'&status='+$scope.declaredValue+'&entityId='+requestCode.id+'&quoteStatus='+124+'&stockTransferId='+consignmentTransNo;
            $http.get(url).success(function(data) {
                if (data) {
                    $scope.rowCollection = data;
                 }
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        };
        
        $scope.getQuoteStatus = function(value){
            switch (value) {
            case "71":
                $scope.declaredValue = 33;
                break;
            case "72":
                $scope.declaredValue = 34;
                break;
            case "73":
                $scope.declaredValue = 35;
               break;
            case "74":
                $scope.declaredValue = 36;
                break;
         }
        };
        
    });  
    
    module.registerController('parentCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {
        
        $scope.validateQty = function(quantity,index,duplicateQuantity){
            if(quantity<=0){
                logger.logError("Quantity Should be Greater than 0!");
                $scope.rowCollectionItem[$scope.$index].quantity=duplicateQuantity;
            }else if(Number(quantity) > Number(duplicateQuantity)){
                logger.logError("Quantity Cannot be Increased!");
                $scope.rowCollectionItem[$scope.$index].quantity=duplicateQuantity;
            }
        };
    

});