'use strict';

app.controller('cancelpurchAddCtrl', function($scope, $rootScope, $http, $location, logger, ngDialog,
        utilsService,$state,sharedProperties,$window,$stateParams,toaster,validationService,$controller) {
      
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
        
        
        $scope.purchaseOrder = {};
        $scope.cancel = function(){
            $state.go("app.sea.cancelpurch.list");
        };
        $scope.rowCollectionItem =[];
        $scope.displayedCollectionItem = [];
        $scope.destinationList = [];
                $scope.companyList = [];
        $scope.addressList = [];
        $scope.location = {};
        $scope.vendor = {};
        
         $scope.requestTypeDropDown = [ {
            id : 'PO',
            text : 'Purchase Order'
        }, {
            id : 'WO',
            text : 'Work Order'
        } ];

        
        
        
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

        $scope.requestTypeOrderDropDown = [ {
            id : 'Capex WO',
            text : 'Capex WO'
        }, {
            id : 'Revex WO',
            text : 'Revex WO'
        } ];
        $scope.getListOfDropdowns = function() {
            $http.get('app/purchaseOrder/getListOfDropdowns').success(function(data) {
                if (data.success == true) {
                    $scope.purchaseForList=data.purchaseFrom;
                    //$scope.hospitalList=data.companyList;
                    $scope.destinationList=data.locationList;
                    $scope.purchaseTypeList = data.purchaseTo;
                    $scope.vendorList = data.vendorList;
                    $scope.addressList = data.commonUtilityBeans;
                    var foundLocation = $filter('filter')(data.purchaseStatus, { text: 'Pending' })[0];
                    var index = (data.purchaseStatus).indexOf(foundLocation);
                    data.purchaseStatus.splice(index,1);
                    $scope.statusList= data.purchaseStatus;
                     $scope.purchaseOrder.termsCondition = data.termsAndConditions;
                    $scope.termsAndConditions = data.termsAndConditions;
                    
                    /*$scope.purchaseOrder.purchaseType = "43";
                    $scope.purchaseOrder.statusId = "46";*/
                  
                }
            });
            
             $http.get($stateParams.tenantid + '/app/commonUtility/getCompanyListPurchase').success(function(datas){
                $scope.companyList = datas;
            }).error(function(datas) {
            });
        };
        $scope.getListOfDropdowns();
        
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
        
        $scope.chkAll=false;
        $scope.checkAll = function (rowCollectionItem,checkBox) {
          if(checkBox) {
                $scope.chkAll=true;
            } else {
                $scope.chkAll = false;
            }
            var i=0;
            angular.forEach($scope.rowCollectionItem, function (value, key) {
                value.isSelected=$scope.chkAll;
            });
       
        };
        
        $scope.chkAllDelivery=false;
        $scope.checkAllDelivery = function (rowCollectionDeliveryItem,checkBox) {
          if(checkBox) {
                $scope.chkAllDelivery=true;
            } else {
                $scope.chkAllDelivery = false;
            }
            var i=0;
            angular.forEach($scope.rowCollectionDeliveryItem, function (value, key) {
                value.isSelected=$scope.chkAllDelivery;
            });
       
        };
   
        $scope.save = function(){
            var url = 'app/purchaseOrder/updatePurchaseOrderCancelStatus?statusId='+ $scope.purchaseOrder.statusId+
            '&purchaseOrderId='+$scope.purchaseOrder.purchaseOrderId+'&remarks='+$scope.purchaseOrder.remarks;
            $http.get(url).success(function(result) {
                console.log(result);
                if(result.success){
                    logger.logSuccess("Purchase Order Status Updated successfully");
                    $state.go("app.sea.cancelpurch.list");
                }else{
                    logger.logError("Purchase does not updated.Something went wrong.");
                    return false;
                }
            });
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
                $scope.purchaseOrder = data;
                if(data.locationId != null){
                data.locationId = Number(data.locationId);
                var foundLocation = $filter('filter')($scope.destinationList, { id: data.locationId })[0];
                $scope.location = foundLocation;
                $scope.loadDestAddress();
                $scope.purchaseOrder.locationId = Number(data.locationId);
                }
                if(data.locationId != null){
                data.vendorId = data.vendorId.toString();
                var foundVendorLocation = $filter('filter')($scope.vendorList, { id: data.vendorId })[0];
                $scope.vendor = foundVendorLocation;
                $scope.loadVendorAddress();
                }
                    $scope.purchaseOrder.statusId = "48"; 
                if(data.purchaseFor !=null){
                    $scope.purchaseOrder.purchaseFor = data.purchaseFor.toString();
                }
                if(data.purchaseType !=null){
                    $scope.purchaseOrder.purchaseType = data.purchaseType.toString();
                }
                var rowCollectionItemData = data.purchaseQuoteDetails;
                for(var i=0;i<rowCollectionItemData.length;i++){
                      
                    rowCollectionItemData[i].unitPrice = Number(rowCollectionItemData[i].unitPrice).toFixed(2);
                    rowCollectionItemData[i].price = Number(rowCollectionItemData[i].quantity*rowCollectionItemData[i].unitPrice).toFixed(2);
                    $scope.rowCollectionItem.push(rowCollectionItemData[i]);
                }
                if(data.purchaseTypeName == "Rate Contract"){
                    $scope.getRateContractDetails(purchaseOrderId);
                }
            });
        }
        };
        
        $scope.calculateTaxDiscount=function(rowCollection){
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
                    rowCollection.discount = Number(discountTaxDetail.discountAmount).toFixed(2);
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
                /*if(discountTaxDetail.subTaxType == "Fixed Amount"){
                    discountTaxDetail.subTaxAmount = discountTaxDetail.subTaxAmount ? discountTaxDetail.subTaxAmount:0;
                    var tax1  =  discountTaxDetail.subTaxAmount;
                    rowCollection.tax =Number(rowCollection.tax) +tax1;
                    rowCollection.tax = Number(rowCollection.tax).toFixed(2);
                }else if(discountTaxDetail.subTaxType == "Percentage"){
                    discountTaxDetail.subTaxPercentage = discountTaxDetail.subTaxPercentage ? discountTaxDetail.subTaxPercentage : 0;
                    var tax1 = rowCollection.price*(discountTaxDetail.subTaxPercentage/100);
                    rowCollection.tax = Number(rowCollection.tax)+tax1;
                    rowCollection.tax = Number(rowCollection.tax).toFixed(2);
                }*/
                //if(rowCollection.total >= rowCollection.tax)
                    rowCollection['finalTotal'] = (Number(rowCollection.total) + Number(rowCollection.tax));
                $scope.calculateTotal();
            };
        
        $scope.calculateTotal = function(){
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
      
    });
 