//define([ 'hospital/purchase/purchase' ], function(module) {

    'use strict';
    app.controller('orderappAddCtrl', function($scope, $state, $http, ngDialog, logger, $location, 
            $controller, $injector, sharedProperties, toaster, $rootScope,$filter) {
      
        $scope.isConsignment=false;
        
        $scope.purchaseData = {
                vendorId : '',
                city : '',
                state : '',
                zipcode : '',
                country : '',
                desCity : '',
                desState : '',
                desZipcode : '',
                desCountry : '',

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
                TypeId:'',
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

        $scope.purchaseOrder = {};
        $scope.cancel = function(){
            $state.go("app.sea.orderapp.list");
        };
        $scope.rowCollectionItem =[];
        $scope.copyRowCollectionItem = [];
        
        $scope.copyrowCollectionItem =[];
        $scope.displayedCollectionItem = [];
        $scope.destinationList = [];
        $scope.addressList = [];
        $scope.location = {};
        $scope.vendor = {};
        $scope.isRecmnd = false;
        $scope.isRecmndEdit = false;
        $scope.poStatus = [];
        var i=0;
        
        $scope.getListOfDropdowns = function() {
            $http.get('app/purchaseOrder/getListOfDropdowns').success(function(data) {
                if (data.success == true) {
                    $scope.purchaseForList=data.purchaseFrom;
                    $scope.hospitalList=data.companyList;
                    $scope.destinationList=data.locationList;
                    $scope.purchaseTypeList = data.purchaseTo;
                    $scope.vendorList = data.vendorList;
                    $scope.addressList = data.commonUtilityBeans;
                    var foundLocation = $filter('filter')(data.purchaseStatus, { text: 'Approved' })[0];
                    var index = (data.purchaseStatus).indexOf(foundLocation);
                    data.purchaseStatus[index].state = true;
                    var foundRecommend = $filter('filter')(data.purchaseStatus, { text: 'Recommend' })[0];
                    var indexRecommend = (data.purchaseStatus).indexOf(foundRecommend);
                    data.purchaseStatus[indexRecommend].state = true;
                    $scope.poStatus.push(data.purchaseStatus[indexRecommend]);
                    $scope.poStatus.push(data.purchaseStatus[index]);
                    /*$scope.purchaseOrder.purchaseType = "43";
                    $scope.purchaseOrder.statusId = "46";*/
                  
                }
            });
            $http.get('app/purchaseOrder/currencyList').success(function(datas) {
                $scope.currencyList = datas;
            });
//            $http.get('app/purchaseOrder/BudgetTypeList').success(function(datas) {
//                $scope.budgetTypeList = datas;
//            });
        };
        $scope.getListOfDropdowns();
        
        $scope.$watch("purchaseOrder.companyId", function(newValue, oldValue) {
            var companyCode = $scope.purchaseOrder.companyId;
            // $scope.purchaseOrder.purchaseOrderNum = "";
            $scope.getCompanydropdowm(companyCode);

            /*
             * $http.post("hospital/purchase/quotation/getRequsitionListbasedonCompany",companyCode).success(function(response) {
             * 
             * var reqNoList = []; angular.forEach(response.requisitionList,
             * function (item, key) { var reqObj = new Object(); reqObj.id =
             * response.requisitionList[key].purchaseRequisitionId; reqObj.text =
             * response.requisitionList[key].requisitionNumber;
             * reqNoList.push(reqObj); }); $scope.requisitionList = reqNoList;
             * });
             */
            $http.post("hospital/purchase/quotation/getpotype", companyCode).success(function(response) {

                var reqNoList = [];
                angular.forEach(response.requisitionList, function(item, key) {
                    var reqObj = new Object();
                    reqObj.id = response.requisitionList[key].purchaseRequisitionId;
                    reqObj.text = response.requisitionList[key].requisitionNumber;
                    reqNoList.push(reqObj);
                });
                $scope.requisitionList = reqNoList;
            });
            $http.get('app/purchaseOrder/costcenterList?companyId=' + companyCode).success(function(datas) {
                $scope.costList = datas;
            });

        });
        
        
        $scope.getCompanydropdowm = function(companyCode) {
            if (companyCode != null && companyCode != undefined && companyCode != '') {
                if ($scope.purchaseOrder.reqType == 'PO') {
                    $http.post("hospital/purchase/quotation/getRequsitionListbasedonCompany", companyCode).success(function(response) {
                        var reqNoList = [];
                        angular.forEach(response.requisitionList, function(item, key) {
                            var reqObj = new Object();
                            reqObj.id = response.requisitionList[key].purchaseRequisitionId;
                            reqObj.text = response.requisitionList[key].requisitionNumber;
                            reqNoList.push(reqObj);
                        });
                        $scope.requisitionList = reqNoList;
                    });
                } else {
                    $http.post("hospital/purchase/quotation/getWorkOrderLists", companyCode).success(function(response) {
                        var reqNoList = [];
                        angular.forEach(response.requisitionList, function(item, key) {
                            var reqObj = new Object();
                            reqObj.id = response.requisitionList[key].purchaseRequisitionId;
                            reqObj.text = response.requisitionList[key].requisitionNumber;
                            reqNoList.push(reqObj);
                        });
                        $scope.requisitionList = reqNoList;
                    });
                }
            }
        }
        
        $scope.qtchkAll=false;
        $scope.qtchkAllfun = function (rowCollectionDeliveryItem,checkBox) {
          if(checkBox) {
                $scope.qtchkAll=true;
            } else {
                $scope.qtchkAll = false;
            }
            var i=0;
            angular.forEach($scope.rowCollectionDeliveryItem, function (value, key) {
                value.select=$scope.qtchkAll;
            });
        };
        
        $scope.loadVendorAddress = function(){
            $scope.purchaseOrder.vendorId = $scope.vendor.id ;
            $scope.purchaseData.desCity1= $scope.vendor.city;
            $scope.purchaseData.desAddress1 = $scope.vendor.address;
            $scope.purchaseData.desState1 = $scope.vendor.state;
            $scope.purchaseData.desCountry1 =  $scope.vendor.country;
            $scope.purchaseData.desZipcode1 = $scope.vendor.zipCode;
            
        };
        $scope.loadDestAddress = function(){
           $scope.purchaseOrder.locationId = $scope.location.id ;
           $scope.purchaseData.desCity= $scope.location.city;
           $scope.purchaseData.desAddress = $scope.location.address;
           $scope.purchaseData.desState = $scope.location.state;
           $scope.purchaseData.desCountry =  $scope.location.country;
           $scope.purchaseData.desZipcode = $scope.location.zipCode;
        };
        
        $scope.purchaseOrder['subTotal'] = 0.0;
        $scope.purchaseOrder['totalDiscount'] = 0.0;
        $scope.purchaseOrder['totalTax']=0.0;
        $scope.purchaseOrder['freight'] = 0.0;
        
        
        
        
//        Budget amoutn validation

        $scope.BudgetAmount = function(purchaseOrder){
//            $scope.formdata = form;
            $scope.formdataNew = purchaseOrder;
             if( purchaseOrder.totalAmount == '' ||  purchaseOrder.totalAmount == null ||
                     purchaseOrder.totalAmount == undefined){
                 purchaseOrder.totalAmount = 0;
             }
             $scope.po = {
                     budgetType : purchaseOrder.budgetType,
                     costcenter : purchaseOrder.costcenter
             }
        $http.post('app/purchaseOrder/geYearlytBudgetAmount',  $scope.po).success(function(datas) {
//            $http.post('app/purchaseOrder/geYearlytBudgetAmount',  $scope.po).success(function(datas) {
                $scope.budgetAmt = datas.budgetAmt;
                $scope.budgetUtilizedAmt = datas.budgetUtilizedAmt;
                $scope.budgetBalAmt = datas.budgetBalAmt;
                 
                 
                 if(Number(datas.budgetBalAmt) < Number(purchaseOrder.totalAmount))
//                     if(Number(purchaseOrder.totalAmount) < Number(datas.budgetBalAmt))
//            if(datas.amount < purchaseOrder.totalAmount)
//            if(1==1)
                {
                ngDialog.open({
                    template : 'views/sea/orderdci/purchaseOrderBudgetView',
                    scope :$scope
                });
                }else{
                  
                    $scope.save(purchaseOrder);
                   
                }
        });
    }
    
    $scope.Yes = function(){
        ngDialog.close();
        $scope.save($scope.formdataNew);
    }
    $scope.Noo = function(){
        ngDialog.close();
    }
    
//        END         
    
        
        
        
        $scope.save = function(purchaseOrder){
            debugger
            var isDelivered=true;
            if($scope.rowCollectionDeliveryItem.length >0){
                angular.forEach($scope.rowCollectionItem,function(value,key){
                    var itemId=value.itemId;
                    var quantity=value.quantity;
                    var deliveredquantity=0;
                    angular.forEach($scope.rowCollectionDeliveryItem,function(value1,key1){
                       if(itemId==value1.itemId){
                           deliveredquantity=deliveredquantity+Number(value1.quantity);
                            
                        }
                    })
                    if(quantity==deliveredquantity){
                    }else{
                        isDelivered=false;
                    }
                });
                
                
                }if(isDelivered){

                   
                        if($scope.purchaseOrder.statusId !=167){
                            console.log("List is");
                            console.log($scope.rowCollectionItem);
                            console.log($scope.rowCollectionDeliveryItem);
                                var url = 'app/purchaseOrder/updatePurchaseOrderStatus?statusId='+ $scope.purchaseOrder.statusId+'&costCenter='+ $scope.purchaseOrder.costcenter+'&purchaseOrderId='+$scope.purchaseOrder.purchaseOrderId+'&budget='+ $scope.purchaseOrder.budgetType;
                                $http.get(url).success(function(result) {
                                    console.log(result);
                                    if(result.success){
                                        logger.logSuccess("Purchase Order Status Updated successfully");
                                        $state.go("app.sea.orderapp.list");
                                    }else{
                                        logger.logError("Purchase does not updated.Something went wrong.");
                                        return false;
                                    }
                                });
                           
                 
                    }else{
                        $scope.saveRecommend(purchaseOrder);
                    } 
            }else{
                logger.logError("The delivery schedule is not completed for certain items in this PO");
            }
            
         };
        
         
         //budgetType
         
         $scope.budgetType = false;
         

         $scope.po_req_Type = true;
         $scope.$watch("purchaseOrder.reqType", function(newValue, oldValue) {
             var po_reqtype = $scope.purchaseOrder.reqType;
             if (po_reqtype != null && po_reqtype != undefined && po_reqtype != '') {
                 if (po_reqtype == 'WO') {
                     $scope.po_req_Type = false;   
                     $scope.getCompanydropdowm($scope.purchaseOrder.companyId)
                 }else {
                     $scope.po_req_Type = true;      
                     $scope.getCompanydropdowm($scope.purchaseOrder.companyId)
                     
                 }
                 }
         });
         
         $scope.$watch("purchaseOrder.potype", function(newValue, oldValue) {
             
           var potype =   $scope.purchaseOrder.potype ;
           


           if (potype == "Capex PO") {
               $scope.budgetType = true;
               var flag = 'C';
               $http.get('app/purchaseOrder/BudgetTypeList?potype=' + flag).success(function(datas) {
                   $scope.budgetTypeList = datas;
               });

           } else  if (potype == "Revex PO"){
               $scope.budgetType = true;
               var flag = 'R';
               $http.get('app/purchaseOrder/BudgetTypeList?potype=' + flag).success(function(datas) {
                   $scope.budgetTypeList = datas;
               });
           }
           else if (potype == "Capex WO") {
               $scope.budgetType = true;
               var flag = 'C';
               $http.get('app/purchaseOrder/BudgetTypeList?potype=' + flag).success(function(datas) {
                   $scope.budgetTypeList = datas;
               });
           }else if (potype == "Revex WO") {
               $scope.budgetType = true;
               var flag = 'R';
               $http.get('app/purchaseOrder/BudgetTypeList?potype=' + flag).success(function(datas) {
                   $scope.budgetTypeList = datas;
               });
           }
         });
         
         $scope.isNaNCheck = function(value){
             if(isNaN(value)){
                 value=0;
             }
             return value;
         }
     
          $scope.checkPartiallyVerified = function(row){
             if(row.vendorMinQty !=null){
                 if(Number(row.quantity) < Number(row.vendorMinQty)){ 
                    row.quantity = Number(row.vendorMinQty);
                    row.quantity = Number(row.vendorMinQty);
                    var price = row.vendorMinQty * row.unitPrice;
                    row.price = (Number(price).toFixed(2)).toString();
                    $scope.calculateTaxDiscountEdit(row);
                    logger.logError("For the selected item, the Vendor minimum qty is greater than the requested quantity.");
                 }else{
                     $scope.calculateTaxDiscountEdit(row);
                
                 }
           }else{
               $scope.calculateTaxDiscountEdit(row);
           }
         };
         
         $scope.saveRecommend = function(purchaseOrderBean){
                
                var isCheck = false;
                $scope.loadcalculation($scope.rowCollectionItem);
                
                if($scope.purchaseOrderDetails.length > 0){
                    
                    purchaseOrderBean["purchaseOrderDetails"] = $scope.purchaseOrderDetails;
                    var tableEnteredData = purchaseOrderBean;
                    delete tableEnteredData.purchaseQuoteDetails;
                    
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
                            var url = 'app/purchaseOrder/updatePurchaseRecommend';
                            $http.post(url,tableEnteredData).success(function(result) {
                                if(result.success){
                                    logger.logSuccess("Purchase Order Recommend Updated successfully");
                                    $state.go("app.sea.orderapp.list");
                                }else{
                                    logger.logError("Purchase Order Recommend does not updated.Something went wrong.");
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
        
        $scope.loadcalculation = function(rowCollectionItem){
            $scope.purchaseOrderDetails = [];
            for(var i=0;i<rowCollectionItem.length;i++){
                var obj = {
                        purchaseQuoteDetailId : rowCollectionItem[i].purchaseQuoteDetailId,
                        purchaseItemId :rowCollectionItem[i].itemId,
                        unitPrice :Number(rowCollectionItem[i].unitPrice).toFixed(2),
                        quantity : Number(rowCollectionItem[i].quantity).toFixed(2) ,
                        purchaseStatusId : rowCollectionItem[i].statusId,
                        discount: Number(rowCollectionItem[i].discount).toFixed(2),
                        tax: Number(rowCollectionItem[i].tax).toFixed(2),
                        requestedQty:Number(rowCollectionItem[i].recmnQty),
                        purchaseOrderDetailId:rowCollectionItem[i].purchaseOrderDetailId,
                        costcenter:rowCollectionItem[i].costcenter

                };
                $scope.purchaseOrderDetails.push(obj);
            }
        };
        $scope.potypelist = [];   
        var data2 ={
                'id':'Capex PO',
                'text':'Capex PO'
        };
        $scope.potypelist.push(data2);
        var data3 ={
                'id':'Revex PO',
                'text':'Revex PO'
        };
        $scope.potypelist.push(data3);

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
                
                if (data.termsCondition != null && data.termsCondition != '' && data.termsCondition != undefined) {
                    var text = data.termsCondition;
                    text = text.replace(/\r?<br>/g, '\n');
                    data.termsCondition = text;
                }

                
                
                
                $scope.purchaseOrder = data;
                $scope.purchaseOrder.budgetType = data.budgetType.toString();

                if($scope.purchaseOrder.purchaseType=="45"){
                    $scope.isConsignment = true;
                }else{
                    $scope.isConsignment = false;
                }
                
                if(data.locationId != null){
                data.locationId = Number(data.locationId);
                var foundLocation = $filter('filter')($scope.destinationList, { id: data.locationId })[0];
                $scope.location = foundLocation;
                $scope.loadDestAddress();
                $scope.purchaseOrder.locationId = data.locationId;
                }
                if(data.locationId != null){
                data.vendorId = data.vendorId.toString();
                var foundVendorLocation = $filter('filter')($scope.vendorList, { id: data.vendorId })[0];
                $scope.vendor = foundVendorLocation;
                $scope.loadVendorAddress();
                }
                if(data.statusId == 167){
                    $scope.isRecmndEdit = true;
                }
                    $scope.purchaseOrder.statusId = "47"; 
                if(data.purchaseFor !=null){
                    $scope.purchaseOrder.purchaseFor = data.purchaseFor.toString();
                }
                $scope.purchaseOrder.potype = data.potype.toString();
                
                if(data.purchaseType !=null){
                    $scope.purchaseOrder.purchaseType = data.purchaseType.toString();
                }
                var copyrowCollectionItem =data.purchaseQuoteDetails;
                var rowCollectionItemData = data.purchaseQuoteDetails;
                
                for(var i=0;i<rowCollectionItemData.length;i++){
                    if(rowCollectionItemData[i].requestedQty==null)
                    {rowCollectionItemData[i]['recmnQty'] = rowCollectionItemData[i].quantity;}
                    else{rowCollectionItemData[i]['recmnQty'] = rowCollectionItemData[i].requestedQty;}
                    rowCollectionItemData[i].unitPrice = Number(rowCollectionItemData[i].unitPrice).toFixed(2);
                    rowCollectionItemData[i].price = Number(rowCollectionItemData[i].quantity*rowCollectionItemData[i].unitPrice).toFixed(2);
//                    data[i].netPrice = Number((Number(data[i].quantity) * data[i].unitPrice)-Number(data[i].discount)).toFixed(2);
                    rowCollectionItemData[i].netPrice = Number(rowCollectionItemData[i].price)-Number(rowCollectionItemData[i].quoteTaxDetail.discountAmount).toFixed(2);
                    
                    
                    $scope.rowCollectionItem.push(rowCollectionItemData[i]);
                }
                
                for(var j=0;j<copyrowCollectionItem.length;j++){
                    if(copyrowCollectionItem[j].requestedQty==null)
                    {copyrowCollectionItem[j]['recmnQty'] = copyrowCollectionItem[j].quantity;}
                    else{copyrowCollectionItem[j]['recmnQty'] = copyrowCollectionItem[j].requestedQty;}
                    copyrowCollectionItem[j].unitPrice = Number(copyrowCollectionItem[j].unitPrice).toFixed(2);
                    copyrowCollectionItem[j].price = Number(copyrowCollectionItem[j].quantity*copyrowCollectionItem[j].unitPrice).toFixed(2);
                    $scope.copyrowCollectionItem.push({"detailId":copyrowCollectionItem[j].purchaseOrderDetailId,"purchaseStatusId":copyrowCollectionItem[j].purchaseStatusId,"itemId":copyrowCollectionItem[j].itemId,"qty":copyrowCollectionItem[j].quantity,"price":copyrowCollectionItem[j].price});
                   
                }
                
                $scope.rowCollectionItem = data.purchaseQuoteDetails;
                $scope.gstGroup = [];
                $scope.gstGroup = data.gstgropuList;


//              decimal
           $scope.purchaseOrder.subTotal = Number(data.subTotal).toFixed(2);
           $scope.purchaseOrder.totalDiscount = Number(data.totalDiscount).toFixed(2);
           $scope.purchaseOrder.totalTaxCGST = Number(data.totalTaxCGST).toFixed(2);
           $scope.purchaseOrder.totalTaxSGST = Number(data.totalTaxSGST).toFixed(2);
           $scope.purchaseOrder.totalTaxIGST = Number(data.totalTaxIGST).toFixed(2);
           $scope.purchaseOrder.freight = Number(data.freight).toFixed(2);
           $scope.purchaseOrder.freightTax = Number(data.freightTax).toFixed(2);
           $scope.purchaseOrder.freightAmount = Number(data.freightAmount).toFixed(2);
           $scope.purchaseOrder.otherCharges = Number(data.otherCharges).toFixed(2);
           $scope.purchaseOrder.totalAmount = Number(data.totalAmount).toFixed(2);
           
           angular.forEach($scope.gstGroup, function(row, index) {
              
               $scope.gstGroup[index].gstAmtgroupbyPercent = Number(row.gstAmtgroupbyPercent).toFixed(2);
               
           });
           
//           end
                
                
                var datas = $scope.rowCollectionItem;

                angular.forEach(datas, function(datas, index) {

                    if (datas.quantity <= 0) {
                        logger.logError("Quantity Should be Greater than 0!");
                        datas.quantity = '';
                    } else {
                        datas['finalTotal'] = 0;
                        datas['total'] = 0;
                        datas.price = Number(datas.price);
                        if (datas.quantity != null && angular.isString(datas.quantity)) {
                            datas.quantity = datas.quantity.replace(/[^0-9]/g, '');
                        }
                        datas.price = Number(Number(datas.quantity) * datas.unitPrice).toFixed(2);

                        var discountTaxDetail = datas.quoteTaxDetail;

//                        var unitIGST = Number(datas.quoteTaxDetail.taxIGST) / datas.vendorQuantity;
//                        datas.quoteTaxDetail.taxIGST = Number(Number(datas.quantity) * Number(unitIGST)).toFixed(2);
//                        var unitSGST = Number(datas.quoteTaxDetail.taxSGST) / datas.vendorQuantity;
//                        datas.quoteTaxDetail.taxSGST = Number(Number(datas.quantity) * Number(unitSGST)).toFixed(2);
//                        var unitCGST = Number(datas.quoteTaxDetail.taxCGST) / datas.vendorQuantity;
//                        datas.quoteTaxDetail.taxCGST = Number(Number(datas.quantity) * Number(unitCGST)).toFixed(2);

                      
                        if (discountTaxDetail.discountType == "Amount") {
                            discountTaxDetail.discountAmount = discountTaxDetail.discountAmount ? discountTaxDetail.discountAmount : 0;
                            if (datas.vendorQuantity > 0) {
                                var unitDiscount = discountTaxDetail.discountAmount / datas.vendorQuantity;
                                datas.discount = Number(Number(datas.quantity) * Number(unitDiscount)).toFixed(2);
                                if (datas.discount != 0 && datas.discount != null) {
                                    datas.netPrice = Number(Number(datas.price) - datas.discount).toFixed(2);

                                } else {
                                    datas.netPrice = Number(datas.price).toFixed(2);
                                }

                            } else {
                                datas.discount = Number(discountTaxDetail.discountAmount).toFixed(2);
                                if (datas.discount != 0 && datas.discount != null) {
                                    datas.netPrice = Number(Number(datas.price) - datas.discount).toFixed(2);

                                } else {
                                    datas.netPrice = Number(datas.price).toFixed(2);
                                }
                            }
                        } else if (discountTaxDetail.discountType == "Percentage") {
                            discountTaxDetail.dicountPercentage = discountTaxDetail.dicountPercentage ? discountTaxDetail.dicountPercentage : 0;
                            datas.discount = Number(Number(datas.price) * (discountTaxDetail.dicountPercentage / 100)).toFixed(2);
                            if (datas.discount != 0 && datas.discount != null) {
                                datas.netPrice = Number(Number(datas.price) - datas.discount).toFixed(2);

                            } else {
                                datas.netPrice = Number(datas.price).toFixed(2);
                            }
                        } else {
                            // discountTaxDetail.dicountPercentage =
                            // discountTaxDetail.dicountPercentage ?
                            // discountTaxDetail.dicountPercentage : 0;
                            // datas.discount =
                            // Number(Number(datas.price)*(discountTaxDetail.dicountPercentage/100)).toFixed(2);
                            // if(datas.discount !=0 && datas.discount
                            // !=null){
                            // datas.netPrice = Number(Number(datas.price) -
                            // datas.discount).toFixed(2);
                            //
                            // }
                            // else{
                            datas.netPrice = Number(datas.price).toFixed(2);
                            // }
                        }
                        
                        datas.quoteTaxDetail.taxIGST= Number((datas.netPrice * ((datas.quoteTaxDetail.taxIGSTinPercent) / 100))).toFixed(2);
                        datas.quoteTaxDetail.taxSGST= Number((datas.netPrice * ((datas.quoteTaxDetail.taxSGSTinPercent) / 100))).toFixed(2);
                        datas.quoteTaxDetail.taxCGST= Number((datas.netPrice * ((datas.quoteTaxDetail.taxCGSTinPercent) / 100))).toFixed(2);
                       
                        if (datas.price >= datas.discount) {
                            datas['total'] = Number(Number(datas.price) - Number(datas.discount)).toFixed(2);
                            datas['finalTotal'] = 0;
                        } else if (datas.price < datas.discount) {
                            datas['total'] = Number(Number(datas.price) - Number(datas.discount)).toFixed(2);
                            datas['finalTotal'] = 0;
                        }
                        datas['finalTotal'] = (Number(datas.total) + Number(datas.taxCGST) + Number(datas.taxSGST) + Number(datas.taxIGST)).toFixed(2);
//                        totalTaxCGST
                        // i=0;
                        // $scope.totalTaxAmount=0;
                        // $scope.totalTaxPercentageValue=0;
                        // $scope.quotationDetail.taxCode="";
                        // $scope.calculateTaxDetails(rowCollection,rowCollection.quoteTaxDetail.taxIdslist);
                        // $scope.calculateTaxDiscount(datas)

                    }
//                    $scope.calculateTotal();


                });
                
                
                if(data.purchaseTypeName == "Rate Contract"){
                    $scope.getRateContractDetails(purchaseOrderId);
                }
            });
        }
        };
        //temp for calculation
       /* $scope.calculateTaxDiscount=function(rowCollection){
            
            rowCollection['finalTotal'] = 0;
            rowCollection['total'] = 0;
            rowCollection.price = Number(rowCollection.price);
            
            if(rowCollection.quantity != null && angular.isString(rowCollection.quantity)){
                rowCollection.quantity = rowCollection.quantity.replace(/[^0-9]/g, '');
                }
                rowCollection.price =Number( Number(rowCollection.quantity) * rowCollection.unitPrice).toFixed(2);
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
                    rowCollection.discount = Number(rowCollection.price*(discountTaxDetail.dicountPercentage/100)).toFixed(2);
                }
                if(rowCollection.price >= rowCollection.discount){
                    rowCollection['total'] =Number( rowCollection.price - rowCollection.discount).toFixed(2);
                    rowCollection['finalTotal'] = 0;
                }
                else if(rowCollection.price < rowCollection.discount){
                    rowCollection['total'] = Number(Number(rowCollection.price) - Number(rowCollection.discount)).toFixed(2);
                    rowCollection['finalTotal'] = 0;
                }
                if(discountTaxDetail.taxType == "Fixed Amount"){
                    discountTaxDetail.taxAmount = discountTaxDetail.taxAmount ? discountTaxDetail.taxAmount : 0;
                    rowCollection.tax = discountTaxDetail.taxAmount;
                    rowCollection.tax = Number(discountTaxDetail.taxAmount).toFixed(2);
                }else if(discountTaxDetail.taxType == "Percentage"){
                    discountTaxDetail.taxPercentage = discountTaxDetail.taxPercentage ? discountTaxDetail.taxPercentage : 0;
                    rowCollection.tax = rowCollection.price*(discountTaxDetail.taxPercentage/100);
                    rowCollection.tax = Number(rowCollection.tax).toFixed(2);
                }
                if(discountTaxDetail.subTaxType == "Fixed Amount"){
                    discountTaxDetail.subTaxAmount = discountTaxDetail.subTaxAmount ? discountTaxDetail.subTaxAmount:0;
                    var tax1  =  discountTaxDetail.subTaxAmount;
                    rowCollection.tax =Number(rowCollection.tax) +tax1;
                    rowCollection.tax = Number(rowCollection.tax).toFixed(2);
                }else if(discountTaxDetail.subTaxType == "Percentage"){
                    discountTaxDetail.subTaxPercentage = discountTaxDetail.subTaxPercentage ? discountTaxDetail.subTaxPercentage : 0;
                    var tax1 = rowCollection.price*(discountTaxDetail.subTaxPercentage/100);
                    rowCollection.tax = Number(rowCollection.tax)+tax1;
                    rowCollection.tax = Number(rowCollection.tax).toFixed(2);
                }
                //if(rowCollection.total >= rowCollection.tax)
                rowCollection['finalTotal'] = (Number(rowCollection.total) + Number(rowCollection.tax));
                $scope.calculateTotal();
                
                rowCollection['finalTotal'] = (Number(rowCollection.total) + Number(rowCollection.tax));
                $scope.calculateTotal(); 
              
            };*/
        $scope.calculateTaxDiscount=function(rowCollection){
            var disc = "";
       /*if (rowCollection.quoteTaxDetail.discountType == "59") 
            {
            rowCollection.quoteTaxDetail.discountType =  "Amount";

            }else if(rowCollection.quoteTaxDetail.discountType == "58"){
     rowCollection.quoteTaxDetail.discountType =  "Percentage";

            }*/
//       discount =   rowCollection.discount ;
            
       if(rowCollection.quoteTaxDetail.discountType == "Percentage"){
           rowCollection.quoteTaxDetail.discountType =  "Percentage";
       rowCollection.price = Number(Number(rowCollection.quantity) * rowCollection.unitPrice).toFixed(2);
//       var taxAmtSGST =( totalamount * ((PQitemlist[i].taxSGST)/100));
       
       disc = (rowCollection.price * (rowCollection.quoteTaxDetail.dicountPercentage/100));
//       rowCollection['discount']  = (rowCollection.price * (rowCollection.discount/100));

       }
       else if(rowCollection.quoteTaxDetail.discountType == "Amount"){
           rowCollection.quoteTaxDetail.discountType =  "Amount";
          disc = rowCollection.quoteTaxDetail.discountAmount;
//           rowCollection['discount']  = rowCollection.discount;
       }
        
       rowCollection['finalTotal'] = 0;
       rowCollection['total'] = 0;
       
       if (rowCollection.price >= disc) {
           rowCollection['total'] = Number(Number(rowCollection.price) - Number(disc)).toFixed(2);
           rowCollection['finalTotal'] = 0;
       } else if (rowCollection.price < disc) {
           rowCollection['total'] = Number(Number(rowCollection.price) - Number(disc)).toFixed(2);
           rowCollection['finalTotal'] = 0;
       }
       
       
       /* console.log("Row Collection is");
        console.log(rowCollection);
        debugger;
        rowCollection['finalTotal'] = 0;
        rowCollection['total'] = 0;
        rowCollection.price = Number(rowCollection.price);
        if (rowCollection.quantity != null && angular.isString(rowCollection.quantity)) {
            rowCollection.quantity = rowCollection.quantity.replace(/[^0-9]/g, '');
        }
        rowCollection.price = Number(Number(rowCollection.quantity) * rowCollection.unitPrice).toFixed(2);
        var discountTaxDetail = rowCollection.quoteTaxDetail;
        if (discountTaxDetail.discountType == "8") {
            discountTaxDetail.discountType =  "Amount";
//            discountTaxDetail.discountAmount = discountTaxDetail.discountAmount ? discountTaxDetail.discountAmount : 0;
            //if($rootScope.isEdit==true){
            if (rowCollection.quantity > 0) {
                var unitDiscount = discountTaxDetail.discount / rowCollection.quantity;
                rowCollection.discount = Number(Number(rowCollection.quantity) * Number(unitDiscount)).toFixed(2);
            } else {
                rowCollection.discount = Number(discountTaxDetail.discountAmount).toFixed(2);
            }
             }else{
                 rowCollection.discount = Number(discountTaxDetail.discountAmount).toFixed(2);
             }
        } else if (discountTaxDetail.discountType == "50") {
            discountTaxDetail.discountType =  "Percentage";
            discountTaxDetail.dicountPercentage = discountTaxDetail.dicountPercentage ? discountTaxDetail.dicountPercentage : 0;
            rowCollection.discount = Number(Number(rowCollection.price) * (discountTaxDetail.dicountPercentage / 100)).toFixed(2);
        }
        if (rowCollection.price >= rowCollection.discount) {
            rowCollection['total'] = Number(Number(rowCollection.price) - Number(rowCollection.discount)).toFixed(2);
            rowCollection['finalTotal'] = 0;
        } else if (rowCollection.price < rowCollection.quoteTaxDetail.discount) {
            rowCollection['total'] = Number(Number(rowCollection.price) - Number(rowCollection.discount)).toFixed(2);
            rowCollection['finalTotal'] = 0;
        }
        if(discountTaxDetail.taxType == "Fixed Amount"){
            discountTaxDetail.taxAmount = discountTaxDetail.taxAmount ? discountTaxDetail.taxAmount : 0;
            rowCollection.tax = Number(discountTaxDetail.taxAmount).toFixed(2);
        }else if(discountTaxDetail.taxType == "Percentage"){
            discountTaxDetail.taxPercentage = discountTaxDetail.taxPercentage ? discountTaxDetail.taxPercentage : 0;
            rowCollection.tax = Number(rowCollection.price)*(discountTaxDetail.taxPercentage/100);
            rowCollection.tax = Number(rowCollection.tax).toFixed(2);
        }
         */

        i = 0;
        $scope.totalTaxAmount = 0;
        $scope.totalTaxPercentageValue = 0;
        $scope.quotationDetail.taxCode = "";
        rowCollection['totalDiscount'] = Number(disc).toFixed(2);
        rowCollection['finalTotal'] = (Number(rowCollection.total) + Number(rowCollection.quoteTaxDetail.taxCGST)+ Number(rowCollection.quoteTaxDetail.taxSGST)+ Number(rowCollection.quoteTaxDetail.taxIGST)).toFixed(2);
//        $scope.calculateTotal();

        }
            
            $scope.calculateTaxDiscountEdit=function(rowCollection){
                rowCollection['finalTotal'] = 0;
                rowCollection['total'] = 0;
                rowCollection.price = Number(rowCollection.price);
                
                if(rowCollection.quantity != null && angular.isString(rowCollection.quantity)){
                    rowCollection.quantity = rowCollection.quantity.replace(/[^0-9]/g, '');
                    }
                    rowCollection.price =Number( Number(rowCollection.quantity) * rowCollection.unitPrice).toFixed(2);
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
                        rowCollection.discount = Number(rowCollection.price*(discountTaxDetail.dicountPercentage/100)).toFixed(2);
                    }
                    if(rowCollection.price >= rowCollection.discount){
                        rowCollection['total'] =Number( rowCollection.price - rowCollection.discount).toFixed(2);
                        rowCollection['finalTotal'] = 0;
                    }
                    else if(rowCollection.price < rowCollection.discount){
                        rowCollection['total'] = Number(Number(rowCollection.price) - Number(rowCollection.discount)).toFixed(2);
                        rowCollection['finalTotal'] = 0;
                    }
                    if(discountTaxDetail.taxType == "Fixed Amount"){
                        discountTaxDetail.taxAmount = discountTaxDetail.taxAmount ? discountTaxDetail.taxAmount : 0;
                        rowCollection.tax = discountTaxDetail.taxAmount;
                        rowCollection.tax = Number(discountTaxDetail.taxAmount).toFixed(2);
                    }else if(discountTaxDetail.taxType == "Percentage"){
                        discountTaxDetail.taxPercentage = discountTaxDetail.taxPercentage ? discountTaxDetail.taxPercentage : 0;
                        rowCollection.tax = rowCollection.price*(discountTaxDetail.taxPercentage/100);
                        rowCollection.tax = Number(rowCollection.tax).toFixed(2);
                    }
                
                /*if(discountTaxDetail.taxType == "Fixed Amount"){
                    discountTaxDetail.taxAmount = discountTaxDetail.taxAmount ? discountTaxDetail.taxAmount : 0;
                    rowCollection.tax = Number(discountTaxDetail.taxAmount).toFixed(2);
                }else if(discountTaxDetail.taxType == "Percentage"){
                    discountTaxDetail.taxPercentage = discountTaxDetail.taxPercentage ? discountTaxDetail.taxPercentage : 0;
                    rowCollection.tax = Number(rowCollection.price)*(discountTaxDetail.taxPercentage/100);
                    rowCollection.tax = Number(rowCollection.tax).toFixed(2);
                }
            */
               
                i=0;
                $scope.totalTaxAmount=0;
                $scope.totalTaxPercentageValue=0;
                $scope.quotationDetail.taxCode="";
                console.log(rowCollection.quoteTaxDetail.taxIdslist);
                $scope.calculateTaxDetails(rowCollection,rowCollection.quoteTaxDetail.taxIdslist);
               
              
            };
            
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
                    rowCollection['finalTotal'] = (Number(rowCollection.total) + Number(rowCollection.tax)).toFixed(2);;
//                    $scope.calculateTotal();
                  
                }
                
            }
            
            
            
        /*$scope.calculateTotal = function(){
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
            
            if($scope.purchaseOrder.statusId=="47"){
                $scope.copyRowCollectionItem=angular.copy($scope.rowCollectionItem);
            }
        };*/
            var subTotal1 = 0;
            $scope.calculateTotal = function(){
            var subTotal = 0;
            var totalDiscount = 0;
            var totalTax = 0;
            var totalAmount = 0;
            var totalTaxCGST = 0;
            var totalTaxSGST = 0;
            var totalTaxIGST = 0;
            for (var i = 0; i < $scope.rowCollectionItem.length; i++) {
                if ($scope.rowCollectionItem[i].edit != 2) {
                    var rowObj = $scope.rowCollectionItem[i];
                    // alert("price"+rowObj.price);
                    rowObj.price = rowObj.price ? rowObj.price : 0;
                    rowObj.totalDiscount = rowObj.totalDiscount ? rowObj.totalDiscount : 0;
//                    rowObj.tax = rowObj.tax ? rowObj.tax : 0;
                    subTotal += Number(rowObj.price);
                    totalDiscount += Number(rowObj.totalDiscount);
//                    totalTax += Number(rowObj.tax);
                    totalAmount += Number(rowObj.finalTotal);
                    totalTaxCGST += Number(rowObj.quoteTaxDetail.taxCGST);
                    totalTaxSGST+= Number(rowObj.quoteTaxDetail.taxSGST);
                    totalTaxIGST += Number(rowObj.quoteTaxDetail.taxIGST);

                }
            }
            $scope.purchaseOrder.subTotal = Number(subTotal).toFixed(2);
            subTotal1 = Number(subTotal).toFixed(2);
            $scope.purchaseOrder.totalTaxCGST = Number(totalTaxCGST).toFixed(2);
            $scope.purchaseOrder.totalTaxSGST = Number(totalTaxSGST).toFixed(2);
            $scope.purchaseOrder.totalTaxIGST = Number(totalTaxIGST).toFixed(2);

            totalDiscount = totalDiscount ? totalDiscount : 0;
            $scope.purchaseOrder.totalDiscount = Number(totalDiscount).toFixed(2);
//            totalTax = totalTax ? totalTax : 0;
//            $scope.purchaseOrder.totalTax = Number(totalTax).toFixed(2);
//            $scope.purchaseOrder.otherCharges = 0;

            var freight = angular.copy($scope.purchaseOrder.freightAmount);
            var othercharges = angular.copy($scope.purchaseOrder.otherCharges);
            var cal = freight+othercharges;
            
            
            $scope.purchaseOrder.totalAmount = Number(Number(subTotal) + Number(cal)).toFixed(2);
//            totalAmt = $scope.purchaseOrder.totalAmount ;

            }
            
            $scope.$watchCollection('[purchaseOrder.totalDiscount,purchaseOrder.totalTaxCGST,purchaseOrder.totalTaxSGST,purchaseOrder.totalTaxIGST,purchaseOrder.freightAmount,purchaseOrder.otherCharges]', function(newValue, oldValue) {
                
                var freight =    Number( $scope.purchaseOrder.freightAmount);
              var otherCharges =    Number( $scope.purchaseOrder.otherCharges);
              var totalTaxCGST= Number(  $scope.purchaseOrder.totalTaxCGST);
              var totalTaxSGST=  Number( $scope.purchaseOrder.totalTaxSGST);
              var totalTaxIGST=  Number( $scope.purchaseOrder.totalTaxIGST);
              var totalDiscount =  Number( $scope.purchaseOrder.totalDiscount);
//              var total = Number($scope.purchaseOrder.totalAmount);
              var subTotal = Numer($scope.purchaseOrder.subTotal);
              var total =Number(subTotal);
              var allTotal = Number((total+freight+otherCharges+totalTaxCGST+totalTaxSGST+totalTaxIGST)-totalDiscount);
            $scope.purchaseOrder.totalAmount =  allTotal; 
                
            });
            
        $scope.rowCollectionDeliveryItem = [];
        $scope.getRateContractDetails = function(purchaseOrderId){
            $scope.loadDeliverySchedule($scope.rowCollectionItem);
            var editUrl = 'app/purchaseOrder/editPurchaseOrderDelivery';
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
                $scope.rowCollectionDeliveryItem = data.rateContractDetails;
            });
        };
        $scope.loadDeliverySchedule = function(rows){
            $scope.itemList = [];
            for(var i=0;i<rows.length;i++){
                var obj = {};
                obj.id = rows[i].itemId;
                obj.code = rows[i].purchaseItemCode;
                obj.text = rows[i].purchaseItemName;
                $scope.itemList.push(obj);   
            }
        }
        
        $scope.chkAll=false;
        $scope.checkAllRateContract = function (rowCollectionItem,checkBox) {
          if(checkBox) {
                $scope.chkAll=true;
            } else {
                $scope.chkAll = false;
            }
            var i=0;
            angular.forEach($scope.rowCollectionItem, function (value, key) {
                value.select=$scope.chkAll;
            });
       
        };
        
        $scope.chkAllDeliverySchedule=false;
        $scope.checkAllDeliverySchedule = function (rowCollectionDeliveryItem,checkBox) {
          if(checkBox) {
                $scope.chkAllDeliverySchedule=true;
            } else {
                $scope.chkAllDeliverySchedule = false;
            }
            var i=0;
            angular.forEach($scope.rowCollectionDeliveryItem, function (value, key) {
                value.select=$scope.chkAll;
            });
       
        };
        
        $scope.checkStatus =function(){
           if($scope.purchaseOrder.statusId == 167){
                $scope.isRecmnd =true;
                var currentDate = new Date();
                currentDate = ('0' + currentDate.getDate()).slice(-2)+"/"+('0' + (Number(currentDate.getMonth())+1)).slice(-2)+"/"+currentDate.getFullYear();
                $scope.purchaseOrder.recmndDate = currentDate;
               
            }else{
                $scope.rowCollectionItem=[];
                $scope.rowCollectionItem=$scope.copyRowCollectionItem;
                angular.forEach($scope.rowCollectionItem, function(value, key){
                    var detailId=value.purchaseOrderDetailId;
                    var itemId=value.itemId;
                    var qty;
                    var price;
                     angular.forEach($scope.copyrowCollectionItem, function(value1, key1){
                       if(value1.detailId==detailId && value1.itemId==itemId){
                           qty=value1.qty;
                           price = value1.price;
                        }
                    });
                    value.quantity=qty;
                    value.price=price;
                 });
                $scope.isRecmnd = false;
            }
            
        }
      
       $scope.openDialog = function(){
           ngDialog.open({
               template : 'errorDialog',
               scope :$scope
           });   
       } 
        $rootScope.closeErrorDialog = function() {
            ngDialog.close();
         };
         $scope.TOtalCal1 = function(index)
         {
         $scope.freight = 0;
         $scope.freightTax = 0;
         var totalvalue ;
         totalvalue = ($scope.purchaseOrder.freight)*(($scope.purchaseOrder.freightTax)/100).toFixed(2);
         $scope.purchaseOrder.freightAmount = (totalvalue + Number(($scope.purchaseOrder.freight))); 
         }; 
    });
    
    app.controller('parentCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {
        
        $scope.validateQty = function(quantity){
            console.log("Row Collection item");
            console.log($scope.rowCollectionItem[$scope.$index]);
            if(quantity<=0){
             
                
                logger.logError("Quantity Should be Greater than 0!");
                $scope.rowCollectionItem[$scope.$index].quantity='';
            }
        };
    });
 
//});