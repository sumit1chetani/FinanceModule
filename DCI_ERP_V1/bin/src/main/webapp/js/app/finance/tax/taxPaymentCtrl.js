   
'use strict';
     app.controller('taxPaymentListCtrl', function($scope, $rootScope, $http, $location, logger, $log, ngDialog, $modal, utilsService,$filter,sharedProperties,$state) {

         $scope.pageCounters = [ 10,15, 25, 50, 75, 100, 125,150 ];
         $scope.index=[];
         $scope.checked = [];
         var index="";
         $scope.itemsByPage = 10;
         $scope.hideUploadIcon=true;
       
         //Add
         $scope.add = function(){
             $state.go('app.finance.tax.tds.tdstax.add');
         };
         $scope.edit = function(natureCode){
             $state.go('app.finance.tax.tds.tdstax.edit',{natureCode:natureCode});
         };
         $scope.taxPayment={
                 vendorCode:'',
                 vendorName:'',
                 checkValue:false,
                 taxType:'',
                 taxNo:'',
                 taxorderAmount:0.0,
                 taxorderAmountUsd:0.0,
                 cashBankAcctCode:'',
                 cashBankAcctName:'',
                 currFraction:0.0,
                 currencyCode:'',
                 exchangeRate:0.0,
                 cashBankAmount:0.0,
                 cashBankAmountUsd:0.0,
                 chequeNo:'',
                 chequeDate:'',
                 fromValue:0.0,
                 toValue:0.0,
                 narration:'',
                 paidTo:'',
                 taxorderAccHead:'',
                 taxorderCurrency:'',
                 taxorderExrate:0.0,
                 popaccountCode:'',
                 popheadName:'',
                 popcurrency:'',
                 poprate:0.0,
                 popfromRange:0.0,
                 poptoRange:0.0,
                 popcurrencyFraction:0.0

             }
                 
         $scope.getTaxPaymentList = function() {
             $scope.dataLoopCount = 0;
             $scope.showEmptyLabel = false;
             $scope.from = 0;
             $scope.to = 100;
             $scope.rowCollection = [];

             var url = 'app/taxpayment/list';
             $http.get(url).success(function(data) {
                 console.log(data);
                     $scope.rowCollection = $scope.rowCollection.concat(data);
             });
         };
         $scope.getTaxPaymentList();
         $scope.acctHeadList=[];
         $scope.getAcctList = function() {          
             var url = 'app/taxpayment/getAcctList';
             $http.get(url).success(function(data) {
                 console.log(data);
                 if(data.success){
                     $scope.acctHeadList = data.taxPaymentBeanList;
                 }
                 
             });
         };
         $scope.getAcctList();
         
         $scope.loadWatchForTbl = function (){
             debugger;
             angular.forEach($scope.objCBReceipt.cshBankDetail, function(value, index) {
                 debugger;
                 /*Account On Change...............*/
                 $scope.$watch('objCBReceipt.cshBankDetail['+index+'].acctName', function(newValue, oldValue) {
                     debugger;
                     if (newValue != '' && newValue != undefined) {

                         angular.forEach($scope.accountList, function(value, indexs) {
                             if(newValue == value.accountHeadCode){
                                 $scope.objCBReceipt.cshBankDetail[index].currency=value.currency;
                                 $scope.objCBReceipt.cshBankDetail[index].exgRate=value.exchangeRate;
                             }
                         });
                     }else{
                         $scope.objCBReceipt.cshBankDetail[index].currency='';
                         $scope.objCBReceipt.cshBankDetail[index].exgRate='';
                     }
                 });
             });
         
         }
         
         $scope.deleteTdsNature=function(natureCode,index){
             ngDialog.openConfirm().then(function() { 
             var url='app/taxpayment/deleteTdsNature?natureCode='+natureCode;
             $http.get(url).success(function(success){
                 if(success){
                     logger.logSuccess("TDS Nature deleted successfully");
                     $scope.rowCollection.splice(index,1);
                 }else{
                     logger.logError("Error Please Try Again");
                 }
             }).error(function(data) {
                 logger.logSuccess("Error in Delete!");
             });
             }, function(reason) {
                 console.log('Modal promise rejected. Reason: ', reason);
             });
        
    }

     });
     app.controller('taxPaymentAddCtrl', function($scope, $rootScope, $http, $location, logger, $log, ngDialog, $modal, utilsService,$filter,sharedProperties,$state,$injector) {

         $scope.taxPayment={
                 vendorCode:'',
                 vendorName:'',
                 checkValue:false,
                 taxType:'',
                 taxNo:'',
                 taxorderAmount:0.0,
                 taxorderAmountUsd:0.0,
                 cashBankAcctCode:'',
                 cashBankAcctName:'',
                 currFraction:0.0,
                 currency:'',
                 exchangeRate:0.0,
                 cashBankAmount:0.0,
                 cashBankAmountUsd:0.0,
                 chequeNo:'',
                 chequeDate:'',
                 fromValue:0.0,
                 toValue:0.0,
                 narration:'',
                 paidTo:'',
                 taxorderAccHead:'',
                 taxorderCurrency:'',
                 taxorderExrate:0.0,
                 popaccountCode:'',
                 popheadName:'',
                 popcurrency:'',
                 poprate:0.0,
                 popfromRange:0.0,
                 poptoRange:0.0,
                 popcurrencyFraction:0.0

             }
         $scope.tempDropDownObj={};
         $scope.isEdit=false;
         $('.datetimepick').datetimepicker({
             format : 'DD/MM/YYYY',
         });
         
         var $validationProvider = $injector.get('$validation');
         $scope.checkValid = $validationProvider.checkValid;
         $scope.submit = function(vendorNatureForm) {
             sharedProperties.clearObject();
             $validationProvider.validate(vendorNatureForm).success($scope.success).error($scope.error);

         };
         $scope.success = function(message) {
             var msg="";
             if($scope.tdsTax.vendorCode==undefined || $scope.tdsTax.vendorCode==null || $scope.tdsTax.vendorCode==""){
                 msg+="Vendor Name - This should be Required!!"
             }else if($scope.tdsTax.tdsNatureCode==undefined || $scope.tdsTax.tdsNatureCode==null || $scope.tdsTax.tdsNatureCode==""){
                 msg+="Nature - This should be Required!!"
             }
             else if($scope.tdsTax.tdsNatureType==undefined || $scope.tdsTax.tdsNatureType==null || $scope.tdsTax.tdsNatureType==""){
                 msg+="Type - This should be Required!!"
             }
             if(msg!=""){
                 logger.logError('Please correct the errors  <bar>'+ msg);
             }
             else{
             $scope.save();
             }
         };
         $scope.error = function(message) {
            // toaster.pop('error', "Please correct the errors", logger.getErrorHtml(sharedProperties.getErrorObject()), 555000, 'trustedHtml');
             logger.logError('Please correct the errors'+ logger.getErrorHtml(sharedProperties.getErrorObject()));
         };
         
         
         $scope.save = function() {
             console.log("save");
             $scope.tdsTax.date=$('#date').val();
             console.log($scope.tdsTax);
                 $http.post('app/taxpayment/save', $scope.tdsTax).success(function(result) {
                     if(result.success) {
                         logger.logSuccess("Saved successfully!");
                         $location.path('tds/taxpayment/list');
                     } else {
                         logger.logError("Record Not Saved!");
                     }
                 }).error(function(result) {
                     console.log("data" + result);
                 });
         };

         $scope.getDropDown = function() {          
             var url = 'app/taxpayment/getDropDown';
             $http.get(url).success(function(data) {
                 console.log(data);
                 if(data.success){
                     $scope.vendorList = data.vendorList;
                     $scope.tdsNatureList = data.tdsNatureList;
                     $scope.currencyList = data.currencyList;
                     $scope.accountHeadList = data.accountHeadList;
                 }
                 
             });
         };
         $scope.getDropDown ();
         $scope.$watch('tdsTax.vendorCode', function(newValue, oldValue) {          
             $scope.tdsNatureList=[];
             $scope.tdsTax.tdsNatureCode='';
                  if(newValue != ''){              
                      $scope.getTdsNature($scope.tdsTax.vendorCode);
                  }
              });
         $scope.getTdsNature = function(vendorCode) {
             //alert("gettds nature()="+vendorCode);
             var url = 'app/taxpayment/getTdsNature?vendorCode='+vendorCode;
             $http.get(url).success(function(data) {
                 console.log(data);
                 if(data.success){
                     $scope.tdsNatureList = data.tdsNatureList;
                 }
             });
         };
         $scope.$watch('tdsTax.currencyCode', function(newValue, oldValue) {          
              console.log("currency watch");
              console.log($scope.tempDropDownObj);
               if(newValue != ''){
                   if($scope.tempDropDownObj.exchangeRate!=undefined){
                       $scope.tdsTax.exchangeRate=$scope.tempDropDownObj.exchangeRate;         
                       }
               }
           });
         $scope.$watch('tdsTax.currencyCode', function(newValue, oldValue) {          
             console.log("currency watch");
             console.log($scope.tempDropDownObj);
              if(newValue != ''){
                  if($scope.tempDropDownObj.exchangeRate!=undefined){
                      $scope.tdsTax.exchangeRate=$scope.tempDropDownObj.exchangeRate;         
                      }
              }
          }); 
       
         $scope.$watch('tdsTax.tdsNatureCode', function(newValue, oldValue) {          
             console.log("tdsNatureCode watch");
              if(newValue != ''){
                  $scope.getTdsNatureData($scope.tdsTax.vendorCode,$scope.tdsTax.tdsNatureCode);
              }
          });
         
         $scope.getTdsNatureData = function(vendorCode,natureCode) {
             //alert("gettds nature val="+vendorCode+"="+natureCode);
             var url = 'app/taxpayment/getTdsNatureData?vendorCode='+vendorCode+'&natureCode='+natureCode;
             $http.get(url).success(function(data) {
                 console.log(data);
                 $scope.tdsTax.tdsNatureType=data.tdsNatureType;
                 $scope.tdsTax.tdsTaxRate=data.tdsTaxRate;
                 $scope.tdsTax.surchargeExRate=data.surchargeExRate;
                 $scope.tdsTax.eduCessExRate=data.eduCessExRate;
                 
             });
         };
         
       
         $scope.calculatingTax = function() {   
         var fraction=3;
             
            /* if($scope.tdsTax.purchaseAmountLocal!=null )){
                 $scope.tdsTax.purchaseAmountLocal=0;
             }
             
             if((!IsNumeric($scope.tdsTax.creditAmountLocal))){
                 $scope.tdsTax.creditAmountLocal=0;
             }
             
             if((!IsNumeric($scope.tdsTax.tdsTaxRate))){
                 $scope.tdsTax.tdsTaxRate=0;
             }*/
                 var itax=$scope.tdsTax.tdsTaxRate;
                 var itaxForLocal=parseFloat($scope.tdsTax.purchaseAmountLocal)* (parseFloat(itax)/100);
                 $scope.tdsTax.tdsTaxAmountLocal=itaxForLocal;
             
             
           /*  if((!IsNumeric($scope.tdsTax.surchargeExRate))){
                 $scope.tdsTax.surchargeExRate=0;
             }*/
                 var surcharg=$scope.tdsTax.surchargeExRate;
                 var surForLocal=(parseFloat(itaxForLocal))*(parseFloat(surcharg)/100);
                 $scope.tdsTax.surchargeAmountLocal=surForLocal;
             
             
             
             var itaxWithSurg=parseFloat(itaxForLocal)+parseFloat(surForLocal);
             $scope.tdsTax.tdsSurchargeAmtLocal=itaxWithSurg;
             
             
            /* if((!IsNumeric($scope.tdsTax.eduCessExRate))){
                 $scope.tdsTax.eduCessExRate=0;
             }*/
             
             var educess=$scope.tdsTax.eduCessExRate;
             var educessLocal=(parseFloat(itaxWithSurg))*(parseFloat(educess)/100);
             $scope.tdsTax.eduCessAmtLocal=educessLocal;
             
             var netTds=parseFloat(educessLocal)+parseFloat(itaxForLocal)+parseFloat(surForLocal);
             $scope.tdsTax.tdsNetAmtLocal=netTds;
             
             $scope.calculatingUSD();
             
         }


         $scope.calculatingUSD = function() {   
        
                 //fraction=$scope.tdsTax.exchangeRate;
                 //if (fdecimal("amount",parseInt(18)-parseInt(fraction),fraction,"Amount")==false) return false;

                 var ex_rate,AmountUsd;

                 if ($scope.tdsTax.exchangeRate.length==0)
                 {
                 //  ex_rate = 0;
                 }
                 else
                 {
                     ex_rate = $scope.tdsTax.exchangeRate;
                 }

                 //USDFraction=document.getElementById("cashBankPaymentAddList[" + i + "].rate0").value;
            //     USDFraction = 3;
                 if (ex_rate>0) // && parseFloat(document.getElementById("cashBankPaymentAddList[" + i + "].amount0").value) >0)
                 {
                     if(!$scope.tdsTax.purchaseAmountLocal==""){
                     $scope.tdsTax.purchaseAmountUsd = parseFloat($scope.tdsTax.purchaseAmountLocal) / parseFloat(ex_rate);
                     }
                     
                     if(!$scope.tdsTax.creditAmountLocal==""){
                     $scope.tdsTax.creditAmountUsd= parseFloat($scope.tdsTax.creditAmountLocal) / parseFloat(ex_rate);
                     }
                     
                     if(!$scope.tdsTax.tdsTaxAmountLocal==""){
                     $scope.tdsTax.tdsTaxAmountUsd = parseFloat($scope.tdsTax.tdsTaxAmountLocal) / parseFloat(ex_rate);
                     }
                     
                     if(!$scope.tdsTax.surchargeAmountLocal==""){
                         $scope.tdsTax.tdsSurRateAmtUsd = parseFloat($scope.tdsTax.surchargeAmountLocal) / parseFloat(ex_rate);
                     }
                     
                     if(!$scope.tdsTax.tdsSurchargeAmtLocal==""){
                     $scope.tdsTax.surchargeAmountUsd = parseFloat($scope.tdsTax.tdsSurchargeAmtLocal) / parseFloat(ex_rate);
                     }
                     
                     if(!$scope.tdsTax.eduCessAmtLocal==""){
                     $scope.tdsTax.eduCessAmtUsd = parseFloat($scope.tdsTax.eduCessAmtLocal) / parseFloat(ex_rate);
                     }
                     
                     if(!$scope.tdsTax.tdsNetAmtLocal==""){
                     $scope.tdsTax.tdsNetAmtUsd= parseFloat($scope.tdsTax.tdsNetAmtLocal) / parseFloat(ex_rate);
                     
                  //   document.forms[0].tdsVendorAmtLocal.value = parseFloat($scope.tdsTax.creditAmountLocal)- parseFloat($scope.tdsTax.tdsNetAmtLocal);
                   //  document.forms[0].tdsVendorAmtUsd.value = parseFloat(document.forms[0].tdsCreditAmtUsd.value)- parseFloat(document.forms[0].tdsNetAmtUsd.value);
                         
                     }
                             
                     
                     
                     
                 }
                 else
                 {
                     $scope.tdsTax.purchaseAmountUsd=0;
                     $scope.tdsTax.creditAmountUsd=0;
                 }
                 //totalCalculation();   
         }
         
         
         $scope.cancel = function() {
             $location.path("tds/taxpayment/list");
         };
    });

     app.controller('taxPaymentEditCtrl', function($scope, $rootScope, $http, $location, logger, $log, ngDialog, $modal, utilsService,$filter,sharedProperties,$state,$stateParams) {

         $scope.taxPayment={
                 vendorCode:'',
                 vendorName:'',
                 checkValue:false,
                 taxType:'',
                 taxNo:'',
                 taxorderAmount:0.0,
                 taxorderAmountUsd:0.0,
                 cashBankAcctCode:'',
                 cashBankAcctName:'',
                 currFraction:0.0,
                 currency:'',
                 exchangeRate:0.0,
                 cashBankAmount:0.0,
                 cashBankAmountUsd:0.0,
                 chequeNo:'',
                 chequeDate:'',
                 fromValue:0.0,
                 toValue:0.0,
                 narration:'',
                 paidTo:'',
                 taxorderAccHead:'',
                 taxorderCurrency:'',
                 taxorderExrate:0.0,
                 popaccountCode:'',
                 popheadName:'',
                 popcurrency:'',
                 poprate:0.0,
                 popfromRange:0.0,
                 poptoRange:0.0,
                 popcurrencyFraction:0.0

             }
         $scope.isEdit=true;
         $('.datetimepick').datetimepicker({
             format : 'DD/MM/YYYY',
         });
         
         $scope.getDropDown = function() {          
             var url = 'app/taxpayment/getDropDown';
             $http.get(url).success(function(data) {
                 console.log(data);
                 if(data.success)
                    
                     $scope.vendorList = data.vendorList;
                     $scope.tdsNatureList = data.tdsNatureList;
                     $scope.currencyList = data.currencyList;
                     $scope.accountHeadList = data.accountHeadList;
             });
         };
         $scope.getDropDown ();
         $scope.edit = function() {
             console.log("edit");
                 $http.get('app/taxpayment/edit?natureCode='+$stateParams.natureCode).success(function(result) {
                     $scope.tdsTax=result;
                     console.log(result);
                 }).error(function(result) {
                     console.log("data" + result);
                 });
         };
         $scope.edit();
         
         $scope.update = function() {
             console.log("save");
                 $http.post('app/taxpayment/update', $scope.tdsTax).success(function(result) {
                     if(result.success) {
                         logger.logSuccess("Update successfully!");
                         $location.path('tds/taxpayment/list');
                     } else {
                         logger.logError("Record Not Update!");
                     }
                 }).error(function(result) {
                     console.log("data" + result);
                 });
         };
         
         $scope.cancel = function() {
             $location.path("tds/taxpayment/list");
         };
    });



