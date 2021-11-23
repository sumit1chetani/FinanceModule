'use strict';

app.controller('purchAddCtrl', function($scope, $rootScope, $http, $location, logger, ngDialog,
        utilsService,$state,sharedProperties,$window,$stateParams,toaster,validationService,$injector,$controller) {
        $scope.purchaseForList = [];
        $scope.purchaseTypeList = [];
        $scope.displayedCollection1 = [];
        $scope.rowCollection1 = [];
        $scope.displayedCollection2 = [];
        $scope.rowCollection2 = [];
        $scope.displayedCollection3 = [];
        $scope.rowCollection3 = [];
        $scope.vendorList = [];
                $scope.uomCategoryList = [];
        
        $scope.statusList = [];
        $scope.discountTypeList = [];
        $scope.requisitionList = [];
        $scope.itemList = [];
        $scope.edit = false;
        $scope.quotationDetailList = [];
        $scope.tableSelection=[];
        $scope.companyList=[];
        $scope.costList=[];
        $scope.fixedPriceAndQuantity=false;
        $scope.consignmentQtyLabel=false;
        $scope.isPmtTerms = false;
        $scope.purchaseQuotation = {
                quotationNo:'',quoteDate:'', purchaseFor:'',purchaseType:'', vendorId:'',
                validFromDate:'',validToDate:'', paymentTerms:'',
                  fixedPrice:'N', fixedQty:'N',subTotal:0, totalDiscount:0,totalTax:0,grandTotal:0,companyId :'',
                  vendorLocId:'',vendorLocName:'', quotationDetailList:[]
        };
        $scope.getListOfDropdowns = function() {
            $http.get('app/purchaseOrder/getListOfDropdowns').success(function(data) {
                if (data.success == true) {
//                    $scope.purchaseForList=data.purchaseFrom;
//                    $scope.hospitalList=data.companyList;
//                    $scope.destinationList=data.locationList;
//                    $scope.addressList = data.commonUtilityBeans;
//                    $scope.purchaseTypeList = data.purchaseTo;
                    $scope.vendorList = data.vendorList;
                    $scope.statusList= data.purchaseStatus;
//                    $scope.purchaseOrder.purchaseType = "43";
//                    $scope.purchaseOrder.statusId = "46";
//                    $scope.purchaseOrder.termsCondition = data.termsAndConditions;
                }
            });
        };
        $scope.getListOfDropdowns();
        
        $scope.view1=false;
        
        $scope.gblId=1;
        $scope.itemgblId=1;
        
        //$scope.uomCategoryList = [];
        
        $http.get("app/hospital/inventory/manageUOM/uomCategoryList").success(function(datas) {
            $scope.uomCategoryList = datas.uomCategoryList; 
        });

        $scope.oldGrandTotalForTotalFreight = 0;
        
        $scope.reset = function(PurchaseQuotationForm){
            if(!$scope.edit){
                $scope.purchaseQuotation.quotationNo='';
                $scope.purchaseQuotation.vendorLocId='';
                $scope.purchaseQuotation.vendorLocName='';
                $scope.purchaseQuotation.purchaseFor='';
                $scope.purchaseQuotation.purchaseType='';
                $scope.purchaseQuotation.vendorId='';
                $scope.purchaseQuotation.vendorId1='';
                $scope.purchaseQuotation.vendorId2='';
                $scope.purchaseQuotation.vendorId3='';

                $scope.purchaseQuotation.quoteDate=$scope.date;
                $scope.purchaseQuotation.validFromDate=$scope.date;
                $scope.purchaseQuotation.validToDate='';
                $scope.purchaseQuotation.paymentTerms='';
                $scope.purchaseQuotation.fixedPrice='N';
                $scope.purchaseQuotation.fixedQty='N';
                $scope.purchaseQuotation.subTotal=0;
                $scope.purchaseQuotation.totalDiscount=0;
                $scope.purchaseQuotation.totalTax=0;
                $scope.purchaseQuotation.grandTotal=0;
                $scope.purchaseQuotation.companyId='';
                $scope.purchaseQuotation.vendorLocName='';
                $scope.purchaseQuotation.quotationDetailList = [];
                $scope.isdeletedIDs=[];
                $scope.purchaseQuotation.grandTotal = 0;
                $scope.purchaseQuotation.totalFreight = 0;
            }else{
                $timeout(function() {
                    $http.get('hospital/purchase/quotation/getPurchaseQuotationDataOnEdit?quotationId='+quotationId).success(function(data) {
                        $scope.edit =true;
                        $scope.isdeletedIDs=[];
                        $scope.purchaseQuotation = data;
                        if(data.fixedPrice=="t"){
                            $scope.purchaseQuotation.fixedPrice='Y';}
                        else{
                            $scope.purchaseQuotation.fixedPrice='N';
                        }
                        if(data.fixedQty=="t"){
                            $scope.purchaseQuotation.fixedQty='Y';}
                        else{
                            $scope.purchaseQuotation.fixedQty='N';
                        }

                        $scope.getPurchaseTypeDetails($scope.purchaseQuotation.purchaseType,$scope.purchaseTypeList);
                        
                        angular.forEach($scope.purchaseQuotation.quotationDetailList,function(key,index){
                           
                            var resultbean={
                                    quotationDetailId:key.quotationDetailId,
                                    itemId:key.itemId 
                            }
                            $http.post("hospital/purchase/quotation/checkPurchaseQuotationNumber",resultbean).success(function(response) {
                                console.log("response");
                                console.log(response);
                                if(response.success==true){
                                    key.statuschange=false;
                                   
                                }else{
                                    key.statuschange=true;
                                    
                                }
                            });
                            console.log("key :::::::::::::");
                            console.log(key); $scope.getListOfDropdowns = function() {
                                $http.get('app/purchaseOrder/getListOfDropdowns').success(function(data) {
                                    if (data.success == true) {
//                                        $scope.purchaseForList=data.purchaseFrom;
//                                        $scope.hospitalList=data.companyList;
//                                        $scope.destinationList=data.locationList;
//                                        $scope.addressList = data.commonUtilityBeans;
//                                        $scope.purchaseTypeList = data.purchaseTo;
                                        $scope.vendorList = data.vendorList;
//                                        $scope.statusList= data.purchaseStatus;
//                                        $scope.purchaseOrder.purchaseType = "43";
//                                        $scope.purchaseOrder.statusId = "46";
//                                        $scope.purchaseOrder.termsCondition = data.termsAndConditions;
                                    }
                                });
                            };
                            $scope.getListOfDropdowns();
                            
                            key.rowSubTotal = (parseFloat(key.amount) - parseFloat(key.disAmt) + parseFloat(key.taxAmt)).toFixed(2);
                        });
                        
                        if($scope.purchaseQuotation.vendorId!="" && $scope.purchaseQuotation.vendorId!=null){
                            $scope.isPmtTerms = true;
                            $scope.purchaseQuotation.paymentTerms = $scope.purchaseQuotation.paymentTerms;
                        }else{
                            $scope.isPmtTerms = false;
                            $scope.purchaseQuotation.paymentTerms = '';
                        }
                        $scope.calGrandTotalWithFreight($scope.purchaseQuotation.totalFreight);

                    }).error(function(data) {
                    });
                }, 2,false);
            }
        };

        $scope.cancel = function(){
            $state.go("app.sea.purch.list");
        }
        
        $scope.onChangeNumber =function(num){
            num = num.replace(/[^0-9 .]/g, '');
                $('#paymentTerms').val(num);
            return num;
        }

        /**
         * validation
         */
        $scope.validate = function(PurchaseQuotationForm,purchaseQuotation) {
            
            if (new validationService().checkFormValidity($scope.PurchaseQuotationForm)) {
                if($scope.purchaseQuotation.quotationDetailList.length!=0){
                     if(!$scope.edit){
                            var checkBox=false;
                            angular.forEach($scope.purchaseQuotation.quotationDetailList,function(key,index){
                                if(key.select==true){
                                    checkBox=true;
                                }
                            });
                            if(checkBox){
                                $scope.save(PurchaseQuotationForm,purchaseQuotation);
                            }else{
                                logger.logError("Please Select atleast one item");
                             }
                         }else{
                             $scope.save(PurchaseQuotationForm,purchaseQuotation);
                         }
                   
                   
                }else{
                    logger.logError("Atleast One Item Quote add in Purchase Quotation Detail List");
                }

            } else {
                toaster.pop('error', "Please fill the required fields",
                        logger.getErrorHtmlNew($scope.PurchaseQuotationForm.$validationSummary), 555000, 'trustedHtml');
            }
        };
        
        $scope.requestTypeDropDown = [
                                      {   id : 'PO',
                                          text : 'Purchase Order'},
                                      {   id : 'WO',
                                          text : 'Work Order'}];
                                  
                                  $scope.requestTypeOrderDropDown = [
                                      {   id : 'Capex WO',
                                          text : 'Capex WO'},
                                      {   id : 'Revex WO',
                                          text : 'Revex WO'}];
                                 

                                  $scope.requestTypeDropDownnew = [ {
                                      id : '28',
                                      text : 'Stock'
                                  }, {
                                      id : '30',
                                      text : 'Consumable'
                                  },
                                  {
                                      id : '29',
                                      text : 'Asset'
                                  }];
        
         $scope.purchaseTypeListNew  = [ {
                                      id : '31',
                                      text : 'Regular'
                                  }, {
                                      id : '32',
                                      text : 'Rate Contract'
                                  },
                                  {
                                      id : '124',
                                      text : 'Consignment'
                                  }];
        
        /***
         * get Add Details with Dropdown values ************************************
         */
       
        
        $scope.getAddDetails = function(){
            $http.get("hospital/purchase/quotation/getAddDetails").success(function(response) {
                if (response.success == true) {
                    //purchase_for combo
                 //   $scope.purchaseForList = response.purchaseForList;
                   var purchaseList = [];
                    angular.forEach(response.purchaseForList, function (item, key) {
                        var purchaseObj = new Object();
                        purchaseObj.id = response.purchaseForList[key].id;
                        purchaseObj.text = response.purchaseForList[key].text;
                        purchaseList.push(purchaseObj);
                    });
                    $scope.purchaseForList = purchaseList;
                       
                    
                  var purchasetypeList = [];
                    angular.forEach(response.purchaseTypeList, function (item, key) {
                        var purchasetypeObj = new Object();
                        purchasetypeObj.id = response.purchaseTypeList[key].id;
                        purchasetypeObj.text = response.purchaseTypeList[key].text;
                        purchasetypeList.push(purchasetypeObj);
                    });
                    $scope.purchaseTypeList = purchasetypeList;
                    
                    
                    
                    
                    //purchase_type combo
               //     $scope.purchaseTypeList = response.purchaseTypeList;
                           
                    //vendor combo
                    var venList = [];
                    angular.forEach(response.vendorList, function (item, key) {
                        var vendorObj = new Object();
                        vendorObj.id = response.vendorList[key].entityId;
                        vendorObj.text = response.vendorList[key].entityName;
                        venList.push(vendorObj);
                    });
//                    $scope.vendorList = venList;

                    var statusList = [];
                    angular.forEach(response.statusList, function (item, key) {
                        var statusObj = new Object();
                        statusObj.id = response.statusList[key].id;
                        statusObj.text = response.statusList[key].text;
                        statusList.push(statusObj);
                    });
                    $scope.statusList = statusList;
                  //  $scope.statusList = response.statusList;
                 //   $scope.discountTypeList =response.discountTypeList;
                    var discountTypeList = [];
                    angular.forEach(response.discountTypeList, function (item, key) {
                        var disObj = new Object();
                        disObj.id = response.discountTypeList[key].id;
                        disObj.text = response.discountTypeList[key].text;
                        discountTypeList.push(disObj);
                    });
                    $scope.discountTypeList = discountTypeList;
                    var reqNoList = [];
                    angular.forEach(response.requisitionList, function (item, key) {
                        var reqObj = new Object();
                        reqObj.id = response.requisitionList[key].purchaseRequisitionId;
                        reqObj.text = response.requisitionList[key].requisitionNumber;
                        reqNoList.push(reqObj);
                    });
                    $scope.requisitionList = reqNoList;
                    
                    $scope.taxList = response.taxList;
                    
                    $timeout(function() {   
                        $("#txtTaxId").multiselect({
                            maxHeight : 400,
                            includeSelectAllOption : false,
                            selectAllText : 'Select All',
                            enableFiltering : true,
                            enableCaseInsensitiveFiltering : true,
                            filterPlaceholder : 'Search',
                            numberDisplayed: 1,
                            onChange : function(element, checked) {
                                jQuery(function(){
                                    var max = 5;
                                    var checkboxes = $('input[type="checkbox"]');
                                    checkboxes.change(function(){
                                        var current = checkboxes.filter(':checked').length;
                                        checkboxes.filter(':not(:checked)').prop('disabled', current >= max);
                                    });
                                });
                            }
                        });
                    }, 3, false);

                }
            });

          /*  $http.get('app/commonUtility/getCompanyList').success(function(datas) {
                $scope.companyList = datas;
                }).error(function(datas) {
            });*/
            
           /* $http.get('app/commonUtility/getCompanyListPurchase').success(function(datas) {
                $scope.companyList = datas;
                }).error(function(datas) {
            });*/
            
             $http.get($stateParams.tenantid + '/app/commonUtility/getCompanyListPurchase').success(function(datas) {
                $scope.companyList = datas;
            }).error(function(datas) {
            });

        
            
            
            $scope.getDropdownvalue = function() {
                
                $http.get('app/hospital/purchase/consignmentRequest/employeeList').success(function(datas) {
                    $scope.costList = datas.costList;
                });
       
         }
            $scope.getDropdownvalue();
            
      
        }
        
        
       
        $scope.getAddDetails ();
        
        
        $scope.getPurchaseTypeDetails = function(purchaseType,purchaseTypeList){
            
            angular.forEach(purchaseTypeList, function(key,index){
                
               if(key.defTableId==purchaseType){
                   if(key.value=='Rate Contract'){
                       $scope.fixedPriceAndQuantity=true;
                       $scope.consignmentQtyLabel=false;
                       $scope.purchaseQuotation.fixedPrice='Y';
                       $scope.purchaseQuotation.fixedQty='Y';

                   }else if(key.value=='Consignment'){
                       $scope.consignmentQtyLabel=true;
                       $scope.fixedPriceAndQuantity=false;
                       $scope.purchaseQuotation.fixedPrice='N';
                       $scope.purchaseQuotation.fixedQty='N';
                   }else{
                       $scope.fixedPriceAndQuantity=false;
                       $scope.consignmentQtyLabel=false;
                       $scope.purchaseQuotation.fixedPrice='N';
                       $scope.purchaseQuotation.fixedQty='N';
                   }

               }
            });
        }
        
        /**
         * fetch Current Date into PQ Date, Valid From Date
         */
        $scope.date = '';
        
        var today = new Date();
        var dd = today.getDate();
        var mm = today.getMonth() + 1; //January is 0!
        var yyyy = today.getFullYear();

        if (dd < 10) {
            dd = '0' + dd;
        }
        if (mm < 10) {
            mm = '0' + mm;
        }

        $scope.isStatus=false;
        
        var today = dd + '/' + mm + '/' + yyyy;
        $scope.date = today;
        $scope.isdeletedIDs=[];
        $scope.purchaseQuotation.quoteDate=$scope.date;
        $scope.purchaseQuotation.validFromDate=$scope.date;

        //Watch method for Invoice From Date 
        /*$scope.$watch('purchaseQuotation.validFromDate', function(newValue, oldValue) {
           if(newValue!=""){
               if($scope.gblId==1){
                   
                   var toDate = $scope.date;
                   var fromDate = newValue;
                   fromDate = fromDate.split("/");
                   fromDate = new Date(fromDate[2], fromDate[1], fromDate[0]);
                   toDate = toDate.split("/");
                   toDate = new Date(toDate[2], toDate[1], toDate[0]);
                   
                   if(fromDate < toDate){
                       logger.logError("From Date is lesser than the Current Date");
                       $scope.purchaseQuotation.validFromDate=$scope.date;
                   }
                   
               }else{
                   $scope.gblId=1;
               }
               
            }
           
        });*/
        
        $scope.$watch('[purchaseQuotation.validFromDate,purchaseQuotation.validToDate]', function(newValue) {
            
                if(newValue!="" && newValue!=undefined && newValue!=null){
                    if($scope.purchaseQuotation.validFromDate!='' && $scope.purchaseQuotation.validToDate != ''){
                    var fromDate = $scope.purchaseQuotation.validFromDate;
                    var toDate = $scope.purchaseQuotation.validToDate;
                    fromDate = fromDate.split("/");
                    fromDate = new Date(fromDate[2], fromDate[1], fromDate[0]);
                    toDate = toDate.split("/");
                    toDate = new Date(toDate[2], toDate[1], toDate[0]);
                    if(toDate < fromDate){
                        $scope.purchaseQuotation.validToDate = '';
                        logger.logError("To Date Should be greater than From Date");
                    }   
                }
           }
        });

        /**
         * fetch Vendor related address based on vendor id
         */
        $scope.loadVendorDetails = function(){           
        
            $scope.$watch("purchaseQuotation.vendorId", function(newValue, oldValue) {
               if(newValue != "" && newValue!=undefined && newValue!=null){
                 if($scope.edit==false){
                      $scope.getVendorDetails(newValue);
                    if(oldValue!="" && oldValue!=undefined && oldValue!=null){
                        if(oldValue!=newValue){
                            $scope.purchaseQuotation.quotationDetailList=[];
                         }else{
                             $scope.getVendorDetails(newValue);
                         }
                    }else{
                        $scope.getVendorDetails(newValue);       
                     }
                   }
                
                }else{
                    $scope.purchaseQuotation.vendorAddress = '';
                    $scope.purchaseQuotation.cityName = '';
                    $scope.purchaseQuotation.state = '';
                    $scope.purchaseQuotation.zipcode = '';
                    $scope.purchaseQuotation.country = '';
                    $scope.purchaseQuotation.paymentTerms = '';
                    $scope.isPmtTerms = false;
                    $scope.purchaseQuotation.vendorLocId = '';
                    $scope.purchaseQuotation.vendorLocName = '';
                }
            });
        }

       /**
        * Filter 'Currency List', when 'Book Currency' selection based 
        */
             
        
        // Get Vendor Details
        $scope.getVendorDetails = function (newValue) {
         
            $http.get("hospital/purchase/quotation/getVendorDetails?vendorId="+newValue).success(function(response) {
                console.log("response:::::::::::::::::::::getVendorDetails::::::::::::::");
                console.log(response.purchaseQuotation);
                if (response.success == true) {
                    $scope.purchaseQuotation.vendorAddress = response.purchaseQuotation.vendorAddress;
                    $scope.purchaseQuotation.cityName = response.purchaseQuotation.cityName;
                    $scope.purchaseQuotation.state = response.purchaseQuotation.state;
                    $scope.purchaseQuotation.zipcode = response.purchaseQuotation.zipcode;
                    $scope.purchaseQuotation.country = response.purchaseQuotation.country;
                 
                    $scope.purchaseQuotation.vendorLocId = response.purchaseQuotation.vendorLocId;
                    
                    $scope.purchaseQuotation.vendorLocName = response.purchaseQuotation.vendorLocName;
                    if(response.purchaseQuotation.pmtTermsId!="" && response.purchaseQuotation.pmtTermsId!=null){
                        $scope.isPmtTerms = true;
                        $scope.purchaseQuotation.paymentTerms = response.purchaseQuotation.pmtTermsId;
                    }else{
                        $scope.isPmtTerms = false;
                        $scope.purchaseQuotation.paymentTerms = '';
                    }

                }else{
                    $scope.purchaseQuotation.vendorAddress = '';
                    $scope.purchaseQuotation.cityName = '';
                    $scope.purchaseQuotation.state = '';
                    $scope.purchaseQuotation.zipcode = '';
                    $scope.purchaseQuotation.country = '';
                    $scope.purchaseQuotation.paymentTerms = '';
                    $scope.isPmtTerms = false;
                    $scope.purchaseQuotation.vendorLocId = '';
                    $scope.purchaseQuotation.vendorLocName = '';

                }
            });
        }
        
        
        $scope.chkAll=false;
        $scope.checkAllQuotation = function (checkBox) {
            if (checkBox) {
                $scope.chkAll=true;
            } else {
                $scope.chkAll = false;
            }
            
            angular.forEach($scope.purchaseQuotation.quotationDetailList,function(value,key){
                value.select = $scope.chkAll;
            });
            
        };
        
       
       var purchaseQuotationObj = angular.copy($scope.purchaseQuotation,purchaseQuotationObj);
       var arrayOfValues = Object.keys(purchaseQuotationObj);
       $scope.checkWhichVariableHasUpdated = function(watchGroupList, newValuesObj, oldValuesObj) {
         var _lastUpdatedValue = null;
         angular.forEach(watchGroupList, function(value) {
             if (newValuesObj[value] != oldValuesObj[value])
                 _lastUpdatedValue = value;
         });
         $scope.selectedObj = newValuesObj;
         return _lastUpdatedValue;
     };

     $scope.loadVendorDetails();
     
     //To load Dependent DropDown 
     $scope.loadDropDown = function(changedVariable) {
         switch (changedVariable) {
             case "vendorId":
                // $scope.loadVendorDetails();
                 break;                               
           }
     };

     //To watch a Object Collection
     $scope.$watchCollection('purchaseQuotation', function(newVal, oldVal) {
         if(newVal !=undefined){
             var last_changed = $scope.checkWhichVariableHasUpdated(arrayOfValues, newVal, oldVal);
             if (angular.isDefined(last_changed) && last_changed != null) {
                 $scope.loadDropDown(last_changed);
             }
         }
     },true);
     
     /**
      * save and update functionality
      */

        $scope.save = function(form){
            if($scope.edit==false){
                
                $http.post("hospital/purchase/quotation/save",$scope.purchaseQuotation).success(function(response) {
                    if (response.success == true) {
                        logger.logSuccess("Saved Successfully");
                        $state.go("app.sea.purch.list");
                    }else{
                        logger.logSuccess("Unable to Save the records.");
                    }
                });
            }else{
                $scope.purchaseQuotation.deletedIl=$scope.isdeletedIDs;
                $http.post("hospital/purchase/quotation/update",$scope.purchaseQuotation).success(function(response) {
                    if (response.success == true) {
                        logger.logSuccess("Updated Successfully");
                        $state.go("app.sea.purch.list");
                    }else{
                        logger.logError("Unable to Update the records.");
                    }
                });
            }

        }

        /**
         * addRow in purchase quote detail table
         */
        $scope.addPurchaseRow = function() {
            if($scope.purchaseQuotation.vendorId!=undefined && $scope.purchaseQuotation.vendorId!=null && $scope.purchaseQuotation.vendorId!=''){
               
                $http.post("hospital/purchase/quotation/getRequisitionList",$scope.purchaseQuotation.vendorId).success(function(response) {
                    $scope.requisitionList=[];
                    var reqNoList = [];
                    console.log("response is")
                    console.log(response);
                    angular.forEach(response.requisitionList, function (item, key) {
                        var reqObj = new Object();
                        reqObj.id = response.requisitionList[key].purchaseRequisitionId;
                        reqObj.text = response.requisitionList[key].requisitionNumber;
                        reqNoList.push(reqObj);
                    });
                    $scope.requisitionList = reqNoList;
                    console.log("requisitionList is")
                    console.log($scope.requisitionList);
                   
                });
                
                $scope.showPurchaseQuotationDetailDialog($scope, 0, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope);
                
            }else{
                logger.logError("Please Select the vendor");
            }
            
           
        }
        /**
         * removeRow in purchase quote detail table
         */
        
        
        $scope.removePurchaseRow = function() {
            var isOrder=true;
            var isSelectItem=false;
            $scope.tablerow=[];
                console.log($scope.purchaseQuotation.quotationDetailList);
                angular.forEach($scope.purchaseQuotation.quotationDetailList, function(value, index) {
                        if (value.select == true) {
                            if($scope.edit==true){
                                var resultbean={
                                        quotationDetailId:value.quotationDetailId,
                                        itemId:value.itemId 
                                }
                                console.log("result");
                                console.log(resultbean);
                                $http.post("hospital/purchase/quotation/checkPurchaseQuotationNumber",resultbean).success(function(response) {
                                    console.log("response");
                                    console.log(response);
                                    if(response.success==true){
                                        $scope.isdeletedIDs.push({"quotationDetailId":value.quotationDetailId,"itemId":value.itemId});
                                    }else{
                                        $scope.tablerow.push(value);
                                        logger.logError("This Item already used in purchase order");
                                    }
                                });
                            }else{
                                
                                $scope.isdeletedIDs.push({"quotationDetailId":value.quotationDetailId,"itemId":value.itemId});
                            }
                            isSelectItem=true;
                          }else{
                           $scope.tablerow.push(value);
                          }
                         
                 });
                if(isSelectItem==false){
                    logger.logError("Please select atleast one item to delete");
                }
                console.log("Table Row");
                console.log($scope.tablerow);
                console.log("deleted Row");
                console.log($scope.isdeletedIDs);
                $scope.purchaseQuotation.quotationDetailList=$scope.tablerow;
                $scope.calculateGrandTotalAndTaxInfo(); 
                $scope.calGrandTotalWithFreight($scope.purchaseQuotation.totalFreight);
           };

           
           $scope.changeStatus = function(quotationDetailId,itemId,status){
               
               if($scope.edit==true){
             
               console.log("result");
               console.log(resultbean);
              
               
               }
               
           }
           
           
           
           
          /**
           * Calculate subTotal, totalDiscount, totalTax, grandTotal...
           */
          $scope.calculateGrandTotalAndTaxInfo = function(){
              var subTotal=0, totalDiscount=0, totalTax=0, grandTot=0;
              angular.forEach($scope.purchaseQuotation.quotationDetailList,function(key,index){

                  subTotal = subTotal + parseFloat(key.amount);
                  totalDiscount = totalDiscount + parseFloat(key.disAmt);
                  totalTax = totalTax + parseFloat(key.taxAmt);
                  grandTot=parseFloat(subTotal) + parseFloat(totalTax) - parseFloat(totalDiscount);
              });
              $scope.purchaseQuotation.subTotal = subTotal;
              $scope.purchaseQuotation.subTotal = $scope.purchaseQuotation.subTotal.toFixed(2);
              $scope.purchaseQuotation.totalDiscount = totalDiscount;
              $scope.purchaseQuotation.totalTax = totalTax;
              $scope.purchaseQuotation.grandTotal = grandTot.toFixed(2);
          }

          /**
           * calculate grand total with freight amount
           */


          $scope.calGrandTotalWithFreight = function(totalFreightAmt){
              
              var subTotal=0, totalDiscount=0, totalTax=0, grandTot=0, totalFreight=0;
             angular.forEach($scope.purchaseQuotation.quotationDetailList,function(key,index){
                  subTotal = subTotal + parseFloat(key.amount);
                  totalDiscount = totalDiscount + parseFloat(key.disAmt);
                  totalTax = totalTax + parseFloat(key.taxAmt);
                  grandTot=parseFloat(subTotal) + parseFloat(totalTax) - parseFloat(totalDiscount);
              });
              if(totalFreightAmt!=""){
                  totalFreight =  totalFreight + parseFloat(totalFreightAmt);
              }
              if(!isNaN(parseFloat(totalFreight))){
                  grandTot = grandTot + parseFloat(totalFreight)
              }
              $scope.purchaseQuotation.subTotal = subTotal;
              $scope.purchaseQuotation.totalDiscount = totalDiscount;
              $scope.purchaseQuotation.totalTax = totalTax;
             if(!isNaN(grandTot)){
                  $scope.purchaseQuotation.grandTotal = grandTot.toFixed(2);
              }

          }
         /**
          * call Purchase Quotation Detail Dialog via addPurchaseRow()
          */
        $scope.showPurchaseQuotationDetailDialog = function($scope, requestCode, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope,validationService) {
            ngDialog.open({
                scope : $scope,
                template : 'views/sea/purch/purchRequestAdd',
                controller : $controller('purchaseQuotationDetailCtrl', {
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
                closeByEscape : false
            });
        }
        
        $scope.changeAmountDiscount = function(percentage){
            if(percentage>100){
                logger.logError("Discount Percentage should not be greater than 100!");
                $scope.quotationDetail.discountPercent='';
            }
        }

        $scope.changeAmount = function(amount){
            if(amount >0){
            }else{
               // logger.logError("Discount Amount should be greater than zero");
              //  $scope.quotationDetail.discountAmount=0;
                $scope.quotationDetail.discountPercent=0;
            }
        }

        $scope.changeLeadAmount = function(amount){
            if(amount >0){
            }else{
                logger.logError("Lead Time should be greater than zero");
                $scope.quotationDetail.deliveryLeadTime='';
               
            }
        }
        
        /***
         * Edit Functionality *******************************
         */
        var quotationId = $stateParams.quotationId;
        if(quotationId == undefined || quotationId == null || quotationId ==""){
        }else{

            $scope.edit =true;
            $timeout(function() {
                $http.get('hospital/purchase/quotation/getPurchaseQuotationDataOnEdit?quotationId='+quotationId).success(function(data) {
                    $scope.edit =true;
                   
                    $scope.purchaseQuotation = data;
                    
                    if(data.fixedPrice=="t"){
                        $scope.purchaseQuotation.fixedPrice='Y';}
                    else{
                        $scope.purchaseQuotation.fixedPrice='N';
                    }
                    if(data.fixedQty=="t"){
                        $scope.purchaseQuotation.fixedQty='Y';}
                    else{
                        $scope.purchaseQuotation.fixedQty='N';
                    }

                    $scope.getPurchaseTypeDetails($scope.purchaseQuotation.purchaseType,$scope.purchaseTypeList);
                     
                     angular.forEach($scope.purchaseQuotation.quotationDetailList,function(key,index){
                        
                        var resultbean={
                                quotationDetailId:key.quotationDetailId,
                                itemId:key.itemId 
                        }
                        $http.post("hospital/purchase/quotation/checkPurchaseQuotationNumber",resultbean).success(function(response) {
                            console.log("response");
                            console.log(response);
                            if(response.success==true){
                                key.statuschange=false;
                               
                            }else{
                                key.statuschange=true;
                                
                            }
                        });
                        console.log("key :::::::::::::");
                        console.log(key);
                        key.rowSubTotal = (parseFloat(key.amount) - parseFloat(key.disAmt) + parseFloat(key.taxAmt)).toFixed(2);
                    });
                    
                    
                    if($scope.purchaseQuotation.vendorId!="" && $scope.purchaseQuotation.vendorId!=null){
                        $scope.isPmtTerms = true;
                        $scope.purchaseQuotation.paymentTerms = $scope.purchaseQuotation.paymentTerms;
                    }else{
                        $scope.isPmtTerms = false;
                        $scope.purchaseQuotation.paymentTerms = '';
                    }
                   // $scope.calculateGrandTotalAndTaxInfo();
                    $scope.calGrandTotalWithFreight($scope.purchaseQuotation.totalFreight);

                }).error(function(data) {
                });
            }, 2,false);
        }
        $scope.uploadContainerExcel = function(element) {
            debugger
            console.log("excel file");
            $scope.excelfile = element.files[0];
            console.log($scope.excelfile);

        }
        $scope.uploadContainer = function() {
           
            // loader.start();
            var excelfile = $scope.excelfile;
            var fileExtension = excelfile.name;
            var fName = [];
            fName = fileExtension.split(".");
            for (var i = 0; i < fName.length; i++) {
                if (fName[i] == "xls" || fName[i] == "xlsx") {
                    var frmData = new FormData();
                    frmData.append("file", excelfile);
                    $.ajax({
                        type : "POST",
                        url : "hospital/purchase/quotation/uploadEmployeeExcel",
                        data : frmData,
                        contentType : false,
                        processData : false,
                        success : function(response) {
                          //  loader.complete();
                            if (response.success == true) {
                                $scope.closeUpload();
                                $scope.purchaseQuotation = response.purchaseQuotation;
                              
                                //$('#purchaseFor').val(response.purchaseQuotation.purchaseFor) ;
                              //  $scope.purchaseQuotation.purchaseFor= response.purchaseQuotation.purchaseFor.toString();
                                //$scope.purchaseQuotation = response.purchaseQuotation;
                                $scope.rowCollection1 = response.purchaseQuotation.quotationDetailList;
                                logger.logSuccess(response.message);
                              
                                //$scope.purchaseQuotation.purchaseFor= response.purchaseQuotation.purchaseFor.toString();
                              //  $scope.purchaseQuotation.requisitionNo= response.purchaseQuotation.requisitionNo.toString();

                            } else if (response.success == false) {
                                $scope.error=true;
                                logger.logError("Error in Upload");
                                $scope.rowCollection1 = response.errors;
                                for (var i = 0; i < response.errors.length; i++) {
                                    logger.logError(response.errors[i]);
                                    $scope.closeUpload();
                                }
                            } else if (response.errorList.length > 0) {

                            } else {
                                logger.logError("Sorry Error Occured");
                                $scope.closeUpload();
                                $scope.getMemberList();
                            }
                        }
                    });
                }
            }
        }
        $scope.downloadFile = function() {
            $("#sampleDownload").bind('click', function() {
            });
            $('#sampleDownload').simulateClick('click');
        }

        $.fn.simulateClick = function() {
            return this.each(function() {
                if ('createEvent' in document) {
                    var doc = this.ownerDocument, evt = doc
                            .createEvent('MouseEvents');
                    evt.initMouseEvent('click', true, true,
                            doc.defaultView, 1, 0, 0, 0, 0, false,
                            false, false, false, 0, null);
                    this.dispatchEvent(evt);
                } else {
                    this.click();
                }
            });
            
            
        }
        
         $scope.closeUpload=function(){
                ngDialog.close();
            }
         
        $scope.fileUpload =function(){
             ngDialog.open({
                    template : 'fileGenModal',
                    scope :$scope
                });
            } 
        
        
        $scope.uploadContainerExcel1 = function(element) {
            debugger
            console.log("excel file");
            $scope.excelfile = element.files[0];
            console.log($scope.excelfile);

        }
        $scope.uploadContainer1 = function() {
            // loader.start();
            var excelfile = $scope.excelfile;
            var fileExtension = excelfile.name;
            var fName = [];
            fName = fileExtension.split(".");
            for (var i = 0; i < fName.length; i++) {
                if (fName[i] == "xls" || fName[i] == "xlsx") {
                    var frmData = new FormData();
                    frmData.append("file", excelfile);
                    $.ajax({
                        type : "POST",
                        url : "hospital/purchase/quotation/uploadEmployeeExcel1",
                        data : frmData,
                        contentType : false,
                        processData : false,
                        success : function(response) {
                          //  loader.complete();
                            if (response.success == true) {
                                $scope.closeUpload();
                                $scope.rowCollection2 = response.purchaseQuotation.quotationDetailList;
                                logger.logSuccess(response.message);
                             //   $scope.purchaseQuotation = response.purchaseQuotation;

                            } else if (response.success == false) {
                                $scope.error=true;
                                logger.logError("Error in Upload");
                                $scope.rowCollection1 = response.errors;
                                for (var i = 0; i < response.errors.length; i++) {
                                    logger.logError(response.errors[i]);
                                    $scope.closeUpload();
                                }
                            } else if (response.errorList.length > 0) {

                            } else {
                                logger.logError("Sorry Error Occured");
                                $scope.closeUpload();
                                $scope.getMemberList();
                            }
                        }
                    });
                }
            }
        }
        $scope.downloadFile1 = function() {
            $("#sampleDownload1").bind('click', function() {
            });
            $('#sampleDownload1').simulateClick('click');
        }

        $.fn.simulateClick = function() {
            return this.each(function() {
                if ('createEvent' in document) {
                    var doc = this.ownerDocument, evt = doc
                            .createEvent('MouseEvents');
                    evt.initMouseEvent('click', true, true,
                            doc.defaultView, 1, 0, 0, 0, 0, false,
                            false, false, false, 0, null);
                    this.dispatchEvent(evt);
                } else {
                    this.click();
                }
            });
            
            
        }
        
         $scope.closeUpload=function(){
                ngDialog.close();
            }
         
        $scope.fileUpload1 =function(){
             ngDialog.open({
                    template : 'fileGenModal1',
                    scope :$scope
                });
            } 
        
        
      
        $scope.uploadContainerExcel2 = function(element) {
            debugger
            console.log("excel file");
            $scope.excelfile = element.files[0];
            console.log($scope.excelfile);

        }
        $scope.uploadContainer2 = function() {
            // loader.start();
            var excelfile = $scope.excelfile;
            var fileExtension = excelfile.name;
            var fName = [];
            fName = fileExtension.split(".");
            for (var i = 0; i < fName.length; i++) {
                if (fName[i] == "xls" || fName[i] == "xlsx") {
                    var frmData = new FormData();
                    frmData.append("file", excelfile);
                    $.ajax({
                        type : "POST",
                        url : "hospital/purchase/quotation/uploadEmployeeExcel2",
                        data : frmData,
                        contentType : false,
                        processData : false,
                        success : function(response) {
                          //  loader.complete();
                            if (response.success == true) {
                                $scope.closeUpload();
                                $scope.rowCollection3 = response.purchaseQuotation.quotationDetailList;
                                logger.logSuccess(response.message);
                           

                            } else if (response.success == false) {
                                $scope.error=true;
                                logger.logError("Error in Upload");
                                $scope.rowCollection1 = response.errors;
                                for (var i = 0; i < response.errors.length; i++) {
                                    logger.logError(response.errors[i]);
                                    $scope.closeUpload();
                                }
                            } else if (response.errorList.length > 0) {

                            } else {
                                logger.logError("Sorry Error Occured");
                                $scope.closeUpload();
                                $scope.getMemberList();
                            }
                        }
                    });
                }
            }
        }
        $scope.downloadFile1 = function() {
            $("#sampleDownload1").bind('click', function() {
            });
            $('#sampleDownload1').simulateClick('click');
        }

        $.fn.simulateClick = function() {
            return this.each(function() {
                if ('createEvent' in document) {
                    var doc = this.ownerDocument, evt = doc
                            .createEvent('MouseEvents');
                    evt.initMouseEvent('click', true, true,
                            doc.defaultView, 1, 0, 0, 0, 0, false,
                            false, false, false, 0, null);
                    this.dispatchEvent(evt);
                } else {
                    this.click();
                }
            });
            
            
        }
        
         $scope.closeUpload=function(){
                ngDialog.close();
            }
         
        $scope.fileUpload2 =function(){
             ngDialog.open({
                    template : 'fileGenModal2',
                    scope :$scope
                });
            } 
    });
    
    
    
    
    

    app.controller('purchaseQuotationDetailCtrl', function($scope, $http, ngDialog, logger, requestCode,
            $injector, sharedProperties, toaster, $rootScope, validationService,$timeout) {

        $scope.isEditDetail = false;
        $scope.isUpload = false;
        $scope.cancelReq = function() {
            ngDialog.close();
        };
        
        $scope.vendorUomId = {};
        
        $scope.quotationDetail = {
                quotationDetailId:0,
                quotationId:0,
                requisitionId:'',
                requisitionNo:'',
                itemId:'',
                quantity:'',
                eddDate:'',
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
                statuschange:false,
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
                pincode:'',
                country:'',
                vendoruom:'',
                vendorQuantity:'',
                vendorConvertedQuantity:''
        }

        $scope.isEdit = false;
        
        $scope.resetPurchaseQuotationDetail = function(purchaseQuoteRequestForm){
            $scope.quotationDetail = {
                    quotationDetailId:0,
                    quotationId:0,
                    requisitionId:'',
                    requisitionNo:'',
                    itemId:'',
                    quantity:'',
                    eddDate:'',
                    taxId:'',
                    statuschange:false,
                    taxTypeId:'',
                    taxIdslist:[],
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
                    pincode:'',
                    country:'',
                    vendoruom:'',
                    vendorQuantity:'',
                    vendorConvertedQuantity:''
            }
          
            };
            
            $scope.$watch("quotationDetail.vendoruom", function(newValue, oldValue){
                if(newValue!=''){
                    angular.forEach($scope.uomCategoryList,function(value,key){
                        if(value.id==newValue){
                            $scope.quotationDetail.vendorUomName = value.text;
                        }
                    });
                }
            });
            
        /**
         * validation
         */
        $rootScope.validatePQDetail = function(purchaseQuoteRequestForm,quotationDetail) {
            var flag=true;
            
            if (new validationService().checkFormValidity(purchaseQuoteRequestForm)) {
                if($scope.quotationDetail.unitPrice<=0){
                }else{
                    var isVendorQuantity=true;
                    angular.forEach($scope.itemList,function(key,index){
                        if(key.id==$scope.quotationDetail.itemId){
                            if(key.vendorMinQty!=0){
                                if($scope.quotationDetail.quantity< key.vendorMinQty){
                                    isVendorQuantity=false;
                                    $scope.quotationDetail.quantity=key.vendorMinQty;
                                }
                            }
                        }
                    });  
                    
                    if(parseInt(quotationDetail.vendorQuantity)>0){
                            var isCheckValid = false;
                            var validQty = (parseInt(quotationDetail.quantity) / quotationDetail.vendorQuantity);
                            if(validQty.toString().indexOf('.') == -1){
                                i=0;
                                $scope.totalTaxAmount=0;
                                $scope.totalTaxPercentageValue=0;
                                $scope.quotationDetail.taxCode="";
                                $scope.quotationDetail.vendorConvertedQuantity = parseInt(quotationDetail.quantity);
                                $scope.quotationDetail.quantity = parseInt(quotationDetail.vendorQuantity);
                                
                                $scope.calculateTaxDetails($scope.quotationDetail.taxIdslist);
                                
                            }else{
                                logger.logError("Invalid Vendor Quantity!");
                            }
                    }else{
                        logger.logError("Vendor Quantity Should be greater than 0!");
                    }
                    
                }
            } else {
                toaster.pop('error', "Please fill the required fields",
                        logger.getErrorHtmlNew(purchaseQuoteRequestForm.$validationSummary), 555000, 'trustedHtml');
            }
        };
        
        $scope.validateQuantity = function(quantity){
            if(quantity<=0){
                logger.logError("Quantity Should be Greater than 0!");
                $scope.quotationDetail.quantity = '';
            }
        };
        
        $scope.validateVendorQuantity = function(quantity){
            if(quantity>$scope.quotationDetail.quantity){
                logger.logError("Vendor Quantity Should be lesser than Purchase Quantity!");
                $scope.quotationDetail.vendorQuantity = '';
            }
        };
        
        $scope.validateUnitPrice = function(unitPrice){
            if(unitPrice<=0){
                logger.logError("Unit Price Should be Greater than 0!");
                $scope.quotationDetail.unitPrice = '';
            }
        };
        
        $scope.onChangeDecimal =function(model,num){
            if(num<=0){
                logger.logError("Unit Price Should be Greater than 0!");
                $scope.quotationDetail.unitPrice = '';
            }
            var floatnum=parseFloat(Math.round(num * 100) / 100).toFixed(2);
            $('#txt'+model).val(floatnum);
           
            return floatnum;
        }
        
        $scope.validatePercent = function(discountPercent){
            if(discountPercent>100){
                logger.logError("Percentage Should be Lesser than or Equal to 100!");
                $scope.quotationDetail.discountPercent = '';
            }
        }
        var i=0;
        $scope.totalTaxAmount=0;
        
        $scope.getAddDetails = function(){
            $http.get("hospital/purchase/quotation/getAddDetails").success(function(response) {
                if (response.success == true) {
                    var purchaseList = [];
                    angular.forEach(response.purchaseForList, function (item, key) {
                        var purchaseObj = new Object();
                        purchaseObj.id = response.purchaseForList[key].id;
                        purchaseObj.text = response.purchaseForList[key].text;
                        purchaseList.push(purchaseObj);
                    });
                    $scope.purchaseForList = purchaseList;
                    //purchase_for combo
             //      $scope.purchaseForList = response.purchaseForList;
        /*            var purchaseList = [];
                    angular.forEach(response.purchaseForList, function (item, key) {
                        var purchaseObj = new Object();
                        purchaseObj.id = response.purchaseForList[key].value;
                   //     vendorObj.text = response.purchaseForList[key].entityName;
                        purchaseList.push(purchaseObj);
                    });
                    $scope.purchaseForList = purchaseList;*/
                    //purchase_type combo
                    $scope.purchaseTypeList = response.purchaseTypeList;

                    //vendor combo
                    var venList = [];
                    angular.forEach(response.vendorList, function (item, key) {
                        var vendorObj = new Object();
                        vendorObj.id = response.vendorList[key].entityId;
                        vendorObj.text = response.vendorList[key].entityName;
                        venList.push(vendorObj);
                    });
//                    $scope.vendorList = venList;
                    var statusList = [];
                    angular.forEach(response.statusList, function (item, key) {
                        var statusObj = new Object();
                        statusObj.id = response.statusList[key].id;
                        statusObj.text = response.statusList[key].text;
                        statusList.push(statusObj);
                    });
                    $scope.statusList = statusList;
                    var discountTypeList = [];
                    angular.forEach(response.discountTypeList, function (item, key) {
                        var disObj = new Object();
                        disObj.id = response.discountTypeList[key].id;
                        disObj.text = response.discountTypeList[key].text;
                        discountTypeList.push(disObj);
                    });
                    $scope.discountTypeList = discountTypeList;
                   // $scope.statusList = response.statusList;
                   // $scope.discountTypeList =response.discountTypeList;
                    
                    $scope.taxList = response.taxList;
                    
                    $timeout(function() {   
                        $("#txtTaxId").multiselect({
                            maxHeight : 400,
                            includeSelectAllOption : false,
                            selectAllText : 'Select All',
                            enableFiltering : true,
                            enableCaseInsensitiveFiltering : true,
                            filterPlaceholder : 'Search',
                            numberDisplayed: 1,
                            /*onChange : function(element, checked) {
                                jQuery(function(){
                                    var max = 5;
                                    var checkboxes = $('input[type="checkbox"]');
                                    checkboxes.change(function(){
                                        var current = checkboxes.filter(':checked').length;
                                        checkboxes.filter(':not(:checked)').prop('disabled', current >= max);
                                    });
                                });
                            }*/
                        });
                    }, 3, false);

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
       
        $scope.getAddDetails ();
        
        /**
         * get Tax Details *******************************************
         */
        $scope.calculateTaxDetails = function(taxIdObjects) {
            var arrayLength = taxIdObjects.length;
            if (arrayLength != i) {
                if (taxIdObjects[i] != "" && taxIdObjects[i] != undefined && taxIdObjects[i] != null) {
                    var taxId = taxIdObjects[i]
                    $http.get("hospital/purchase/quotation/getTaxDetails?taxId=" + taxIdObjects[i]).success(function(response) {
                        if (response.success == true) {
                            console.log("response");
                            console.log(response);
                            $scope.taxPercentage = 0;
                            $scope.taxAmount = 0;
                            $scope.subTaxPercentage = 0;
                            $scope.subTaxAmount = 0;
                            $scope.quotationDetail.subTaxTypeAmt = "";
                            $scope.quotationDetail.subTaxTypePercent = "";
                            if (response.purchaseQuotationDetail.taxType == "Percentage") {
                                $scope.taxPercentage = response.purchaseQuotationDetail.taxPercentage;
                                $scope.quotationDetail.taxType = response.purchaseQuotationDetail.taxType;
                                if ($scope.quotationDetail.taxCode != null && $scope.quotationDetail.taxCode != '' && $scope.quotationDetail.taxCode != undefined) {
                                    $scope.quotationDetail.taxCode = $scope.quotationDetail.taxCode + "," + response.purchaseQuotationDetail.taxCode;
                                }
                                else {
                                    $scope.quotationDetail.taxCode = $scope.quotationDetail.taxCode + response.purchaseQuotationDetail.taxCode;
                                }
                            }
                            else if (response.purchaseQuotationDetail.taxType == "Fixed Amount") {
                                $scope.taxAmount = response.purchaseQuotationDetail.taxAmount;
                                $scope.quotationDetail.taxType = response.purchaseQuotationDetail.taxType;
                                if ($scope.quotationDetail.taxCode != null && $scope.quotationDetail.taxCode != '' && $scope.quotationDetail.taxCode != undefined) {
                                    $scope.quotationDetail.taxCode = $scope.quotationDetail.taxCode + "," + response.purchaseQuotationDetail.taxCode;
                                }
                                else {
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
                            $scope.quotationDetail.subTaxAmount = $scope.quotationDetail.subTaxAmount.toFixed(2);
                            $scope.quotationDetail.unitPrice = $scope.isNaNCheck(parseFloat($scope.quotationDetail.unitPrice));
                            $scope.quotationDetail.amount = (parseFloat($scope.quotationDetail.unitPrice) * parseFloat($scope.quotationDetail.quantity)).toFixed(2);
                            //Tax Details - Tax Percentage
                            var totalTaxPercentage = (parseFloat($scope.quotationDetail.taxPercentage)) + (parseFloat($scope.quotationDetail.subTaxPercentage));
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
                                    if (($scope.quotationDetail.subTaxTypePercent == '' || $scope.quotationDetail.subTaxTypePercent == null || $scope.quotationDetail.subTaxTypePercent == undefined || $scope.quotationDetail.subTaxTypePercent == " ") && ($scope.quotationDetail.subTaxTypeAmt == '' || $scope.quotationDetail.subTaxTypeAmt == undefined || $scope.quotationDetail.subTaxTypeAmt == null || $scope.quotationDetail.subTaxTypeAmt == " ")) {
                                        $scope.quotationDetail.taxAmt = ((parseFloat($scope.quotationDetail.amount)) * parseFloat($scope.quotationDetail.taxPercentage / 100)).toFixed(2);
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
                                    if (($scope.quotationDetail.subTaxTypePercent == '' || $scope.quotationDetail.subTaxTypePercent == null || $scope.quotationDetail.subTaxTypePercent == undefined || $scope.quotationDetail.subTaxTypePercent == " ") && ($scope.quotationDetail.subTaxTypeAmt == '' || $scope.quotationDetail.subTaxTypeAmt == undefined || $scope.quotationDetail.subTaxTypeAmt == null || $scope.quotationDetail.subTaxTypeAmt == " ")) {
                                        $scope.quotationDetail.taxAmt = parseFloat($scope.quotationDetail.taxAmount).toFixed(2);
                                    }
                                }
                            }
                            $scope.totalTaxAmount = Number($scope.totalTaxAmount) + Number($scope.quotationDetail.taxAmt);
                            $scope.totalTaxAmount = $scope.totalTaxAmount.toFixed(2);
                            $scope.totalTaxPercentageValue = Number($scope.totalTaxPercentageValue) + Number(totalTaxPercentage);
                            $scope.totalTaxPercentageValue = $scope.totalTaxPercentageValue.toFixed(2);
                            i++;
                            $scope.calculateTaxDetails($scope.quotationDetail.taxIdslist);
                        }
                        else {
                            $scope.taxPercentage = '';
                            $scope.taxAmount = '';
                            $scope.quotationDetail.taxType = '';
                            $scope.quotationDetail.taxCode = '';
                            $scope.subTaxPercentage = '';
                            $scope.subTaxAmount = '';
                            $scope.quotationDetail.subTaxType = '';
                            i++;
                            $scope.calculateTaxDetails($scope.quotationDetail.taxIdslist);
                        }
                    });
                }
                else {
                    $scope.taxPercentage = '';
                    $scope.taxAmount = '';
                    $scope.quotationDetail.taxType = '';
                    $scope.subTaxPercentage = '';
                    $scope.subTaxAmount = '';
                    $scope.quotationDetail.subTaxType = '';
                }
            }
            if (arrayLength == i) {
                $scope.saveDetail($scope.totalTaxAmount);
            }
        }
        /**
         * get Discount Details
         * either Discount 'Percentage' or Discount 'Amount' field via ng-show
         */
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
        
        $scope.onChangeNumber =function(num){
            num = num.replace(/[^0-9 .]/g, '');
                $('#paymentTerms').val(num);
            return num;
        }

        /**
         * Get Item List with Requisition Number
         */
        $scope.$watch("quotationDetail.requisitionId", function(newValue, oldValue) {
            
            var isAvail = false;
            var isExist = false;
            
            $scope.existList = $scope.purchaseQuotation.quotationDetailList;
            angular.forEach($scope.existList, function (value, key) {
                if(value.requisitionId==newValue){
                    isExist = true;
                }
            });
            
            console.log("QuotationList");
            console.log("QuotationList");
           
            if(newValue != "" && newValue!=undefined && newValue!=null){
                var resultbean={
                        requisitionId:newValue,
                        vendorId:$scope.purchaseQuotation.vendorId
                }
                console.log("resultbean");
                
                console.log(resultbean);
                $http.post("hospital/purchase/quotation/getItemList",resultbean).success(function(response) {
                    console.log("response.itemList::::::::::::::::getItemList:::::::::::::");
                    console.log(response);
                    if (response.success == true) {
                        var itemsList = [];
                        angular.forEach(response.itemList, function (item, key) {
                            var itemObj = new Object();
                            itemObj.id = response.itemList[key].itemId;
                            itemObj.text = response.itemList[key].itemCode;
                            itemObj.vendorMinQty = response.itemList[key].vendorMinQty;
                            itemsList.push(itemObj);
                        });
                        $scope.itemList = itemsList;
                        $scope.quotationDetail.requisitionNo = response.purchaseQuotationDetail.requisitionNo;
                        $scope.quotationDetail.reqDate = response.purchaseQuotationDetail.reqDate;
                        $scope.quotationDetail.locationName = response.purchaseQuotationDetail.locationName;
                        $scope.quotationDetail.pincode = response.purchaseQuotationDetail.pincode;
                        $scope.quotationDetail.stateName = response.purchaseQuotationDetail.stateName;
                        $scope.quotationDetail.cityName = response.purchaseQuotationDetail.cityName;
                        $scope.quotationDetail.country = response.purchaseQuotationDetail.country;
                        
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
                
            }/*else{
                $scope.itemList = [];
                $scope.quotationDetail.requisitionNo = '';
                $scope.quotationDetail.reqDate = '';
                $scope.quotationDetail.locationName = '';
                $scope.quotationDetail.pincode = '';
                $scope.quotationDetail.stateName = '';
                $scope.quotationDetail.cityName = '';
                $scope.quotationDetail.country = '';
            }*/
        });
        
        $scope.cnt =0;
        $scope.$watch("quotationDetail.itemId", function(newValue, oldValue, itemobj) {
            
            if(newValue != "" && newValue!=undefined && newValue!=null){
                $http.post("hospital/purchase/quotation/getItem", itemobj.quotationDetail).success(function(response) {
                    var isAvail =false;
                    if (response.success == true) {
                        $scope.quotationDetail.itemCode = response.purchaseQuotationDetail.itemCode;
                        var length = $scope.purchaseQuotation.quotationDetailList.length;
                        for(var i=0;i<length;i++){
                            if($scope.purchaseQuotation.quotationDetailList[i].itemCode == response.purchaseQuotationDetail.itemCode &&
                                    $scope.purchaseQuotation.quotationDetailList[i].requisitionId == $scope.quotationDetail.requisitionId ){
                                isAvail = true;
                            }
                        }
                     
                        if(isAvail){
                            $scope.cnt+=1;
                            if($scope.cnt == 1){
                                logger.logError("Item already added");
                            }
                            $scope.quotationDetail.itemId ='';
                            $scope.quotationDetail.itemCode ='';
                            return false;
                           
                        }else{
                            $scope.quotationDetail.itemName = response.purchaseQuotationDetail.itemName;
                            $scope.quotationDetail.itemDescription = response.purchaseQuotationDetail.itemDescription;
                            $scope.quotationDetail.eddDate = response.purchaseQuotationDetail.eddDate;
                            $scope.quotationDetail.quantity = response.purchaseQuotationDetail.quantity;
                            $scope.quotationDetail.uom = response.purchaseQuotationDetail.uom;
                            $scope.quotationDetail.uomName=response.purchaseQuotationDetail.uomName;
                            $scope.quotationDetail.vendoruom = response.purchaseQuotationDetail.vendoruom;
                            $scope.quotationDetail.vendorUomName=response.purchaseQuotationDetail.vendorUomName;
                            $scope.quotationDetail.statuschange=false;
                        }
                    }else{
                        $scope.quotationDetail.itemCode = '';
                        $scope.quotationDetail.itemName = '';
                        $scope.quotationDetail.itemDescription = '';
                        $scope.quotationDetail.eddDate = '';
                        $scope.quotationDetail.quantity = '';
                        $scope.quotationDetail.uom ='';
                        $scope.quotationDetail.uomName='';
                        $scope.quotationDetail.vendoruom = '';
                        $scope.quotationDetail.vendorUomName = '';
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
        
        /**
         * Save Detail -- fetch dialog data into detail table with calculation subTotal,Tax, Discount, grandTotal
         */

        $scope.saveDetail = function(){
           
           $scope.quotationDetail.taxAmt=$scope.totalTaxAmount;
           
           $scope.quotationDetail.taxPercentage=$scope.totalTaxPercentageValue;
            
           $scope.quotationDetail.rowSubTotal="";
         debugger;
           $scope.quotationDetail.unitPrice = $scope.isNaNCheck(parseFloat($scope.quotationDetail.unitPrice));
         
           $scope.quotationDetail.amount = (parseFloat($scope.quotationDetail.unitPrice) * parseFloat($scope.quotationDetail.quantity)).toFixed(2);
          
            
            //Discount
           if($scope.quotationDetail.discountPercent!="" && $scope.quotationDetail.discountPercent!=undefined && $scope.quotationDetail.discountPercent!=null){
                 
               $scope.quotationDetail.disAmt = ($scope.quotationDetail.amount * ($scope.quotationDetail.discountPercent/100)).toFixed(2);
              
           }else if($scope.quotationDetail.discountAmount!="" &&  $scope.quotationDetail.discountAmount!=undefined
                   && $scope.quotationDetail.discountAmount!=null){
               $scope.quotationDetail.disAmt = parseFloat($scope.quotationDetail.discountAmount).toFixed(2);
              
               
           }
           else{
              $scope.quotationDetail.disAmt = 0;
           }
           
          
           if($scope.quotationDetail.discountTypeId=="" || $scope.quotationDetail.discountTypeId==undefined || $scope.quotationDetail.discountTypeId==null){
             
               $scope.quotationDetail.disAmt = 0;
           }
          
           //Tax Details - Tax Percentage
       
           //row wise Sub Total
           if($scope.quotationDetail.rowSubTotal=="" || $scope.quotationDetail.rowSubTotal==0){
               $scope.quotationDetail.rowSubTotal = parseFloat($scope.quotationDetail.amount) -
                                                    parseFloat($scope.quotationDetail.disAmt) +
                                                    parseFloat($scope.quotationDetail.taxAmt);
               $scope.quotationDetail.rowSubTotal=$scope.quotationDetail.rowSubTotal.toFixed(2);
           }
           
           if($scope.quotationDetail.discountAmount!=undefined && $scope.quotationDetail.discountAmount!='' && $scope.quotationDetail.discountAmount!=null
                   &&  $scope.quotationDetail.rowSubTotal!=undefined && $scope.quotationDetail.rowSubTotal!='' && $scope.quotationDetail.rowSubTotal!=null
           ){
               if($scope.quotationDetail.rowSubTotal < $scope.quotationDetail.discountAmount){
                   logger.logError("Discount amount should be less than sub total amount");
               }else{
                   if($scope.quotationDetail.taxIdslist.length <= 5) {
                       $scope.purchaseQuotation.quotationDetailList.push($scope.quotationDetail);
                       $scope.calculateGrandTotalAndTaxInfo();
                       ngDialog.close();
                   }else{
                       logger.logError("Number of allowed Tax count is Five only. Please remove few of them");
                       
                   }
              }
           }else{
               if($scope.quotationDetail.taxIdslist.length <= 5) {
                   $scope.purchaseQuotation.quotationDetailList.push($scope.quotationDetail);
                   $scope.calculateGrandTotalAndTaxInfo();
                   ngDialog.close();
               }else{
                   logger.logError("Number of allowed Tax count is Five only. Please remove few of them");
                   
               }
              
           }
           
            
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
        /**
         * Calculate subTotal, totalDiscount, totalTax, grandTotal and also total Freight...
         */
        $scope.calculateGrandTotalAndTaxInfo = function(){
            
            var subTotal=0, totalDiscount=0, totalTax=0, grandTot=0,totalFreight=0;
            angular.forEach($scope.purchaseQuotation.quotationDetailList,function(key,index){
                subTotal = subTotal + parseFloat(key.amount);
                totalDiscount = totalDiscount + parseFloat(key.disAmt);
                totalTax = totalTax + parseFloat(key.taxAmt);
                grandTot=parseFloat(subTotal) + parseFloat(totalTax) - parseFloat(totalDiscount);
            });
           var totalFreightAmt = $scope.purchaseQuotation.totalFreight;
            if(totalFreightAmt!="" && totalFreightAmt!=undefined)
                totalFreight =  totalFreight + parseFloat(totalFreightAmt);

            if(!isNaN(totalFreight))
                grandTot = grandTot + parseFloat(totalFreight)

            $scope.purchaseQuotation.subTotal = subTotal.toFixed(2);
            $scope.purchaseQuotation.totalDiscount = totalDiscount.toFixed(2);
            $scope.purchaseQuotation.totalTax = totalTax.toFixed(2);
            if(!isNaN(grandTot))
                $scope.purchaseQuotation.grandTotal = grandTot.toFixed(2);
        }

        $scope.editDetail = function(){
            $scope.purchaseQuotation.push($scope.quotationDetail);
        }

        $scope.deleteDetail = function(index){
            $scope.purchaseQuotation.quotationDetailList.splice(index, 1);
        }

    });

