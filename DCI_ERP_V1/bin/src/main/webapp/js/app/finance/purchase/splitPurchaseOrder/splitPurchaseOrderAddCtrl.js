define([ 'hospital/purchase/purchase' ], function(module) {

    'use strict';
    module.registerController('splitPurchaseOrderAddCtrl', function($scope, $state, $http, ngDialog, logger, $location,
            $controller, $injector, sharedProperties, toaster, $rootScope,$filter,validationService) {
        $scope.validate = function(PurchaseOrderForm,purchaseOrder) {
            if (new validationService().checkFormValidity($scope.PurchaseOrderForm)) {
                if(!$rootScope.isEdit){
                    $scope.save(PurchaseOrderForm,purchaseOrder);
                }else{
                    $scope.update(purchaseOrderForm,purchaseOrder);
                    
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
        };
        var currentDate = new Date();
        currentDate = ('0' + currentDate.getDate()).slice(-2)+"/"+('0' + (Number(currentDate.getMonth())+1)).slice(-2)+"/"+currentDate.getFullYear();
        $scope.purchaseOrder.purchaseOrderDate = currentDate;
        $rootScope.isEdit = false;
        $scope.cancel = function(){
            $state.go("app.hospital.purchase.splitPurchaseOrder.list");
        };
        $scope.rowCollectionItem =[];
        $scope.splitCollectionItem =[];
        $scope.displayedCollectionItem = [];
        $scope.destinationList = [];
        $scope.addressList = [];
        $scope.location = {};
        $scope.vendor = {};
        $scope.getListOfDropdowns = function() {
            $http.get('app/purchaseOrder/getListOfDropdowns').success(function(data) {
                if (data.success == true) {
                    $scope.purchaseForList=data.purchaseFrom;
                    $scope.hospitalList=data.companyList;
                    $scope.destinationList=data.locationList;
                    $scope.addressList = data.commonUtilityBeans;
                    $scope.purchaseTypeList = data.purchaseTo;
                    $scope.vendorList = data.vendorList;
                    $scope.statusList= data.purchaseStatus;
                   /* $scope.purchaseOrder.purchaseType = "43";
                    $scope.purchaseOrder.statusId = "46";*/
                  
                }
            });
        };
        $scope.getListOfDropdowns();
        
        $scope.loadVendorAddress = function(){
            var foundItemVen = $filter('filter')($scope.vendorList, { id:  $scope.purchaseOrder.vendorId })[0];
                var indexVen = $scope.vendorList.indexOf(foundItemVen);
                if(indexVen>-1){
                $scope.purchaseData.desCity1= $scope.vendorList[indexVen].city;
                $scope.purchaseData.desAddress1 = $scope.vendorList[indexVen].address;
                $scope.purchaseData.desState1 = $scope.vendorList[indexVen].state;
                $scope.purchaseData.desCountry1 =  $scope.vendorList[indexVen].country;
                $scope.purchaseData.desZipcode1 = $scope.vendorList[indexVen].zipCode;
                }else{
                    $scope.purchaseData.desCity1= '';
                    $scope.purchaseData.desAddress1 = '';
                    $scope.purchaseData.desState1 = '';
                    $scope.purchaseData.desCountry1 =  '';
                    $scope.purchaseData.desZipcode1 = ''; 
                }
        };
        $scope.loadDestAddress = function(){
        var foundItemDest = $filter('filter')($scope.destinationList, { id:  $scope.purchaseOrder.locationId })[0];
        var indexDest = $scope.destinationList.indexOf(foundItemDest);
        if(indexDest>-1){
               $scope.purchaseData.desCity= $scope.destinationList[indexDest].city;
               $scope.purchaseData.desAddress = $scope.destinationList[indexDest].address;
               $scope.purchaseData.desState = $scope.destinationList[indexDest].state;
               $scope.purchaseData.desCountry =  $scope.destinationList[indexDest].country;
               $scope.purchaseData.desZipcode = $scope.destinationList[indexDest].zipCode;
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
        $scope.purchaseOrder['freight'] =0.0;
   
        
        $scope.save = function(form,purchaseOrderBean){
           console.log(purchaseOrderBean);
           if($scope.splitRowItem.length>0){
           var purchaseOrder = angular.copy(purchaseOrderBean);
            $scope.loadcalculation($scope.splitRowItem);
            purchaseOrder["purchaseOrderDetails"] = $scope.purchaseOrderDetails;
            $scope.calculateSplitTotal();
            purchaseOrder.subTotal=$scope.subTotal;
            purchaseOrder.totalDiscount = $scope.totalDiscount;
            purchaseOrder.totalTax = $scope.totalTax;
            purchaseOrder.totalAmount = $scope.totalAmount;
            console.log(purchaseOrder);
            delete purchaseOrder.purchaseQuoteDetails;
            var tableEnteredData = purchaseOrder;
            $http.post('app/purchaseOrder/savePurchaseOrder', tableEnteredData).success(function(result) {
                console.log(result);
                if(result.success){
                    logger.logSuccess("Purchase Order  added successfully");
                    $state.go("app.hospital.purchase.splitPurchaseOrder.list");
                }else{
                    logger.logError("Purchase not added");
                    return false;
                }
            });
           }
           else{
               logger.logError("Please select and add quantity to Purchase Order Item.");
           }
        };
           
        $scope.getListValue = function(data,addQuoteStatus){
            for(var i=0;i<data.length;i++){
                if(data[i].isSelected){
                    if($scope.purchaseData.vendorId!=undefined){
                    data[i].vendorId = $scope.purchaseData.vendorId;
                    data[i].vendorName = $scope.vendor.text;
                    }
                    data[i].unitPrice = Number(data[i].unitPrice).toFixed(2);
                    data[i].price =Number( Number(data[i].quantity)*data[i].unitPrice).toFixed(2);
                    data[i].statusId = addQuoteStatus;
                    data[i].isSelected = false;
                    $scope.rowCollectionItem.push(data[i]);
            }
            }
            ngDialog.close();
         };
       
        $scope.loadcalculation = function(rowCollectionItem){
            $scope.purchaseOrderDetails = [];
            for(var i=0;i<rowCollectionItem.length;i++){
                var obj = {
                        purchaseQuoteDetailId : rowCollectionItem[i].purchaseQuoteDetailId,
                        purchaseItemId :rowCollectionItem[i].itemId,
                        unitPrice :Number(rowCollectionItem[i].unitPrice).toFixed(2),
                        quantity : Number(rowCollectionItem[i].quantity).toFixed(2) ,
                        purchaseStatusId : rowCollectionItem[i].purchaseStatusId,
                        discount: Number(rowCollectionItem[i].discount).toFixed(2),
                        tax: Number(rowCollectionItem[i].tax).toFixed(2)
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
            var editUrl = 'app/purchaseOrder/editPurchaseOrderAmendment';
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
                data.locationId = Number(data.locationId);
                data.vendorId = data.vendorId.toString();
                var foundLocation = $filter('filter')($scope.destinationList, { id: data.locationId })[0];
                $scope.location = foundLocation;
                $scope.location  =  Number(data.locationId);
                var foundVendorLocation = $filter('filter')($scope.vendorList, { id: data.vendorId })[0];
                $scope.vendor = foundVendorLocation;
                $scope.loadDestAddress();
                $scope.loadVendorAddress();
                if(data.statusId != null){
                    $scope.purchaseOrder.statusId = data.statusId.toString(); 
                }
                if(data.purchaseFor !=null){
                    $scope.purchaseOrder.purchaseFor = data.purchaseFor.toString();
                }
                if(data.purchaseType !=null){
                    $scope.purchaseOrder.purchaseType = data.purchaseType.toString();
                }
                $scope.rowCollectionItem = data.purchaseQuoteDetails;
                $scope.splitCollectionItem = angular.copy(data.purchaseQuoteDetails);  
                for(var i=0;i<data.length;i++){
                    if(data[i].statusId){
                        if($scope.purchaseData.vendorId.length>0){
                        data[i].vendorId = $scope.purchaseData.vendorId;
                        data[i].vendorName = $scope.vendor.text;
                        }
                        data[i].unitPrice = Number(data[i].unitPrice).toFixed(2);
                        data[i].price = Number(data[i].quantity*data[i].unitPrice).toFixed(2);
                        data[i].statusId = addQuoteStatus;
                        $scope.rowCollectionItem.push(data[i]);
                }
                }
                $rootScope.isEdit = true;
            });
        }
        };
        
        $scope.calculateTaxDiscount=function(rowCollection,isSplit){
            rowCollection['finalTotal'] = 0;
            rowCollection['total'] = 0;
            rowCollection.price = Number(rowCollection.price);
            if(rowCollection.quantity != null && angular.isString(rowCollection.quantity)){
            rowCollection.quantity = rowCollection.quantity.replace(/[^0-9]/g, '');
            }
            rowCollection.price = Number(Number(rowCollection.quantity) * rowCollection.unitPrice).toFixed(2);
            var discountTaxDetail = rowCollection.quoteTaxDetail;
            if(discountTaxDetail.discountType == "Amount"){
                discountTaxDetail.discountAmount = discountTaxDetail.discountAmount ? discountTaxDetail.discountAmount : 0;
                rowCollection.discount = Number(discountTaxDetail.discountAmount).toFixed(2);
            }
            else if(discountTaxDetail.discountType == "Percentage"){
                discountTaxDetail.dicountPercentage = discountTaxDetail.dicountPercentage ? discountTaxDetail.dicountPercentage : 0;
                rowCollection.discount = Number(Number(rowCollection.price)*(discountTaxDetail.dicountPercentage/100)).toFixed(2);
            }
            if(rowCollection.price >= rowCollection.discount){
                rowCollection['total'] = Number(Number(rowCollection.price) - Number(rowCollection.discount)).toFixed(2);
                rowCollection['finalTotal'] = 0;
            }else if(rowCollection.price < rowCollection.discount){
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
            /*if(discountTaxDetail.subTaxType == "Fixed Amount"){
                discountTaxDetail.subTaxAmount = discountTaxDetail.subTaxAmount ? discountTaxDetail.subTaxAmount:0;
                var tax1  =  discountTaxDetail.subTaxAmount;
                rowCollection.tax =Number(rowCollection.tax) +tax1;
                rowCollection.tax = Number(rowCollection.tax).toFixed(2);
            }else if(discountTaxDetail.subTaxType == "Percentage"){
                discountTaxDetail.subTaxPercentage = discountTaxDetail.subTaxPercentage ? discountTaxDetail.subTaxPercentage : 0;
                  var tax1 = Number(rowCollection.price)*(discountTaxDetail.subTaxPercentage/100);
                  rowCollection.tax = Number(rowCollection.tax)+tax1;
                rowCollection.tax = Number(rowCollection.tax).toFixed(2);
            }*/
                rowCollection['finalTotal'] = (Number(rowCollection.total) + Number(rowCollection.tax)).toFixed(2);
            if(!isSplit)
            {
             $scope.calculateTotal();
            $scope.checkPartiallyVerified(rowCollection);
            }
            else{$scope.calculateSplitTotal();}
           
                
        };
        
        $scope.calculateTotal = function(){
            var subTotal = 0;var totalDiscount = 0;var totalTax =0 ;var totalAmount = 0;
            for(var i=0;i<$scope.rowCollectionItem.length;i++){
                if($scope.rowCollectionItem[i].edit !=2){
                    var rowObj = $scope.rowCollectionItem[i];
                    rowObj.price = rowObj.price ? rowObj.price : 0;
                    rowObj.discount = rowObj.discount  ? rowObj.discount : 0;
                    rowObj.tax = rowObj.tax ? rowObj.tax : 0;
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
            $scope.purchaseOrder.totalTax = Number(totalTax).toFixed(2);
            var frieght = angular.copy($scope.purchaseOrder.freight);
            $scope.purchaseOrder.totalAmount = Number(totalAmount+Number(frieght)).toFixed(2);
        };
        
        $scope.calculateSplitTotal = function(){
            var subTotal = 0;var totalDiscount = 0;var totalTax =0 ;var totalAmount = 0;
            for(var i=0;i<$scope.splitRowItem.length;i++){
                if($scope.splitRowItem[i].edit !=2){
                    var rowObj = $scope.splitRowItem[i];
                    rowObj.price = rowObj.price ? rowObj.price : 0;
                    rowObj.discount = rowObj.discount  ? rowObj.discount : 0;
                    rowObj.tax = rowObj.tax ? rowObj.tax : 0;
                    subTotal += Number(rowObj.price);
                    totalDiscount += Number(rowObj.discount);
                    totalTax += Number(rowObj.tax);
                    totalAmount += Number(rowObj.finalTotal);    
                }
            }
            $scope.subTotal = Number(subTotal).toFixed(2);
            totalDiscount = totalDiscount ? totalDiscount: 0; 
            $scope.totalDiscount = Number(totalDiscount).toFixed(2);
            totalTax = totalTax ? totalTax : 0;
            $scope.totalTax = Number(totalTax).toFixed(2);
            var frieght = angular.copy($scope.purchaseOrder.freight);
            $scope.totalAmount = Number(totalAmount+Number(frieght)).toFixed(2);
        };
        
        $scope.removePurchaseRow =function(){
            for(var i=0;i< $scope.rowCollectionItem.length;i++){
                  if($scope.rowCollectionItem[i].isSelected)
                       {  if($scope.rowCollectionItem[i].edit!=1)
                       {
                           $scope.rowCollectionItem[i].edit=2; 
                       }else{
                           $scope.rowCollectionItem.splice(i, 1);
                       }
                      }
            }
            $scope.calculateTotal();
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
                  $scope.loadDestAddress() ;
                  break;
              case "vendorId":
                  $scope.loadVendorAddress();
                  break;
              case "freight":
                  $scope.calculateTotal();
                  break;
               }
      };

      $scope.checkPartiallyVerified = function(row){
          var foundItem = $filter('filter')($scope.splitCollectionItem, { purchaseOrderDetailId: row.purchaseOrderDetailId})[0];
          var index = $scope.splitCollectionItem.indexOf(foundItem);
          var quantity = $scope.splitCollectionItem[index].quantity ;
          if(row.pendingQnty != null && row.pendingQnty > 0){
              if(Number(row.quantity) < quantity){
                  row.quantity = quantity;
                  logger.logError("Partially Recieved Quantity Cannot Be Reduced.");
              }
          }else if(Number(row.quantity) < quantity){
              row.quantity = quantity;
              logger.logError("Quantity Cannot Be Reduced.");
          }
      }
      
      $scope.splitRowItem = [];
      $scope.splitPurchaseOrder =function(departmentCollections){
          var foundItemDest = $filter('filter')($scope.splitCollectionItem, { purchaseOrderDetailId:  departmentCollections.purchaseOrderDetailId })[0];
          if(departmentCollections.isSelected){
              var indexDest = $scope.splitCollectionItem.indexOf(foundItemDest);
              if(indexDest > -1){
                  var selectedRow = angular.copy(departmentCollections);
                  $scope.oldQuantityRow = angular.copy($scope.splitCollectionItem[indexDest]);
                  $scope.oldQuantityRow.quantity = selectedRow.quantity-$scope.oldQuantityRow.quantity;
                  $scope.calculateTaxDiscount($scope.oldQuantityRow,true);
                  var oldQuantityRow = angular.copy($scope.oldQuantityRow);
                  $scope.splitRowItem.push(oldQuantityRow);
              }
          }else{
              var foundSplitItem = $filter('filter')($scope.splitRowItem, { purchaseOrderDetailId:  departmentCollections.purchaseOrderDetailId })[0];
              var indexSplitItem = $scope.splitRowItem.indexOf(foundSplitItem);
              $scope.splitRowItem.splice(indexSplitItem, 1);
              
              var indexSplitItem = $scope.splitCollectionItem.indexOf(foundItemDest);
              if(indexSplitItem > -1){
                  var oldQuantityRow = angular.copy($scope.splitCollectionItem[indexSplitItem]);
                  departmentCollections.quantity = oldQuantityRow.quantity;
              }
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
        
    });

});