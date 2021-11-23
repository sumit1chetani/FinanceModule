   
'use strict';
     app.controller('tdsTaxListCtrl', function($scope, $rootScope, $http, $location, logger, $log, ngDialog, $modal, utilsService,$filter,$stateParams,sharedProperties,$state) {

         $scope.pageCounters = [ 10,15, 25, 50, 75, 100, 125,150 ];
         $scope.index=[];
         $scope.checked = [];
         var index="";
         $scope.itemsByPage = 10;
         $scope.hideUploadIcon=true;
       
         //Add
         $scope.add = function(){
             $state.go('app.finance.tax.tds.tdstax.add',{tenantid:$stateParams.tenantid});
         };
         $scope.edit = function(natureCode){
             $state.go('app.finance.tax.tds.tdstax.edit',{natureCode:natureCode},{tenantid:$stateParams.tenantid});
         };
         $scope.tdsTax={
                 tdsTaxCode:'',
                 vendorNatureCode:'',
                 vendorName:'',
                 vendorCode:'',
                 tdsNatureCode:'',
                 tdsNature:'',
                 tdsNatureType:'',
                 description:'',
                 userId:'',
                 id:'',
                 text:'',
                 currencyCode:'',
                 exchangeRate:0.0,
                 date:'',
                 purchaseAmountLocal:0.0,
                 purchaseAmountUsd:0.0,
                 creditAmountLocal:0.0,
                 creditAmountUsd:0.0,
                 tdsTaxRate:0.0,
                 tdsTaxAmountLocal:0.0,
                 tdsTaxAmountUsd:0.0,
                 surchargeExRate:0.0,
                 surchargeAmountLocal:0.0,
                 surchargeAmountUsd:0.0,
                 tdsSurchargeAmtLocal:0.0,
                 tdsSurcharegeAmtUsd:0.0,
                 eduCessExRate:0.0,
                 eduCessAmtLocal:0.0,
                 eduCessAmtUsd:0.0,
                 tdsNetAmtLocal:0.0,
                 tdsNetAmtUsd:0.0,
                 accountHeadCode:'',
                 individualTax:0.0
             }
                 
         $scope.getTdsNatureList = function() {
             $scope.dataLoopCount = 0;
             $scope.showEmptyLabel = false;
             $scope.from = 0;
             $scope.to = 100;
             $scope.rowCollection = [];

             var url = $stateParams.tenantid+'/app/tdstax/list';
             $http.get(url).success(function(data) {
                 console.log(data);
                     $scope.rowCollection = $scope.rowCollection.concat(data);
             });
         };
         $scope.getTdsNatureList();
         
         
         $scope.deleteTdsNature=function(natureCode,index){
             ngDialog.openConfirm().then(function() { 
             var url=$stateParams.tenantid+'/app/tdstax/deleteTdsNature?natureCode='+natureCode;
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
         }; 
        
         
    });


     app.controller('tdsTaxAddCtrl', function($scope, $rootScope, $http, $location, logger, $log, ngDialog, $modal, utilsService,$filter,sharedProperties,$state,$injector,validationService,toaster,$stateParams) {

         $scope.tdsTax={
                 tdsTaxCode:'',
                 vendorNatureCode:'',
                 vendorName:'',
                 vendorCode:'',
                 tdsNatureCode:'',
                 tdsNature:'',
                 tdsNatureType:'',
                 description:'',
                 userId:'',
                 id:'',
                 text:'',
                 currencyCode:'INR',
                 exchangeRate:'1',
                 date:'',
                 purchaseAmountLocal:0.0,
                 purchaseAmountUsd:0.0,
                 creditAmountLocal:0.0,
                 creditAmountUsd:0.0,
                 tdsTaxRate:0.0,
                 tdsTaxAmountLocal:0.0,
                 tdsTaxAmountUsd:0.0,
                 surchargeExRate:0.0,
                 surchargeAmountLocal:0.0,
                 surchargeAmountUsd:0.0,
                 tdsSurchargeAmtUsd:0.0,
                 tdsSurchargeAmtLocal:0.0,
                 tdsSurcharegeAmtUsd:0.0,
                 eduCessExRate:0.0,
                 eduCessAmtLocal:0.0,
                 eduCessAmtUsd:0.0,
                 tdsNetAmtLocal:0.0,
                 tdsNetAmtUsd:0.0,
                 accountHeadCode:'',
                	 branch:'',
                	 invNo:''
             }
         $scope.tempDropDownObj={};
         $scope.branchList = [];
         $scope.invoiceList = [];
         $scope.isEdit=false;
         $('.datetimepick').datetimepicker({
             format : 'DD/MM/YYYY',
         });
         
         var today = new Date();
         var dd = today.getDate();
         var mm = today.getMonth() + 1;

         var yyyy = today.getFullYear();
         if (dd < 10) {
             dd = '0' + dd
         }
         if (mm < 10) {
             mm = '0' + mm
         }
         var today = dd + '/' + mm + '/' + yyyy;
         $scope.tdsTax.date = today;
         
         var $validationProvider = $injector.get('$validation');
         $scope.checkValid = $validationProvider.checkValid;
         $scope.submit = function(vendorNatureForm) {
             /*sharedProperties.clearObject();
             $validationProvider.validate(vendorNatureForm).success($scope.success).error($scope.error);*/
             if (new validationService().checkFormValidity(vendorNatureForm)) {
                 $scope.save();
             }else {
                 toaster.pop('error', "Please fill the required fields",logger.getErrorHtmlNew(vendorNatureForm.$validationSummary), 5500, 'trustedHtml');
             }

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
             //$scope.tdsTax.date=$('#date').val();
             console.log($scope.tdsTax);
                 $http.post($stateParams.tenantid+'/app/tdstax/save', $scope.tdsTax).success(function(result) {
                     if(result.success) {
                         logger.logSuccess("Saved successfully!");
                         $location.path($stateParams.tenantid+'/tds/tdstax/list');
                     } else {
                         logger.logError("Record Not Saved!");
                     }
                 }).error(function(result) {
                     console.log("data" + result);
                 });
         };

         $scope.$watch('tdsTax.branch', function(newValue, oldValue) {          
              if(newValue != ''){
            	  $http.get($stateParams.tenantid+'/app/tdstax/getDropDownOne?branch='+newValue).success(function(data) {
                 	 debugger
                      console.log(data);
                      if(data.success){
                          $scope.vendorList = data.vendorList;
                          //$scope.tdsNatureList = data.tdsNatureList;
                          //$scope.currencyList = data.currencyList;
                         // $scope.accountHeadList = data.accountHeadList;
                         // $scope.branchList  = data.branchList;
                      }
                      
                  });
              }
          });
         
         $scope.$watch('tdsTax.invNo', function(newValue, oldValue) {          
             if(newValue != ''){
           	  $http.get($stateParams.tenantid+'/app/tdstax/getInvAmount?inv='+newValue).success(function(data) {
                	 debugger
                     console.log(data);
                     if(data){
                         $scope.tdsTax.purchaseAmountLocal = data.invAmount;
                         $scope.calculatingTax();
                     }
                     
                 });
             }
         });
         $scope.$watch('tdsTax.vendorCode', function(newValue, oldValue) {          
             if(newValue != ''){
           	  $http.get($stateParams.tenantid+'/app/tdstax/getInvoice?vendor='+newValue).success(function(data) {
                	 debugger
                     console.log(data);
                     if(data.success){
                         $scope.invoiceList = data.invoiceList;
                     }
                     
                 });
             }
         });
         
         $scope.$watch('tdsTax.tdsNatureType', function(newValue, oldValue) {          
             if(newValue != ''){
            	 if($scope.tdsTax.tdsNatureCode !='' && $scope.tdsTax.tdsNatureCode !=undefined && $scope.tdsTax.tdsNatureCode !=null){
            		 
            		 $http.get($stateParams.tenantid+'/app/tdstax/getTdsNatureTax?type='+newValue+'&nature='+$scope.tdsTax.tdsNatureCode).success(function(data) {
                    	 debugger
                         console.log(data);
                         if(data){
                        	 $scope.tdsTax.tdsTaxRate=data.tdsTaxRate;
                        	 $scope.calculatingTax();
                         }
                         
                     });
            	 }else{
            		 logger.logError("Please select Nature!"); 
            	 }
           	  
             }
         });
         
          $scope.getDropDown = function() {          
             var url = $stateParams.tenantid+'/app/tdstax/getDropDown';
             $http.get(url).success(function(data) {
            	 debugger
                 console.log(data);
                 if(data.success){
                     $scope.vendorList = data.vendorList;
                     $scope.tdsNatureList = data.tdsNatureList;
                     $scope.currencyList = data.currencyList;
                     $scope.accountHeadList = data.accountHeadList;
                     $scope.branchList  = data.branchList;
                 }
                 
             });
         };
         $scope.getDropDown ();
         /*$scope.$watch('tdsTax.vendorCode', function(newValue, oldValue) {          
             $scope.tdsNatureList=[];
             $scope.tdsTax.tdsNatureCode='';
                  if(newValue != ''){              
                      $scope.getTdsNature($scope.tdsTax.vendorCode);
                  }
              });
         $scope.getTdsNature = function(vendorCode) {
             //alert("gettds nature()="+vendorCode);
             var url = $stateParams.tenantid+'/app/tdstax/getTdsNature?vendorCode='+vendorCode;
             $http.get(url).success(function(data) {
                 console.log(data);
                 if(data.success){
                     $scope.tdsNatureList = data.tdsNatureList;
                 }
             });
         };*/
         /*$scope.$watch('tdsTax.currencyCode', function(newValue, oldValue) {          
              console.log("currency watch");
              console.log($scope.tempDropDownObj);
               if(newValue != ''){
                   if($scope.tempDropDownObj.exchangeRate!=undefined){
                       $scope.tdsTax.exchangeRate=$scope.tempDropDownObj.exchangeRate;         
                       }
               }
           });*/
       
        /* $scope.$watch('tdsTax.tdsNatureCode', function(newValue, oldValue) {          
             console.log("tdsNatureCode watch");
              if(newValue != ''){
                  $scope.getTdsNatureData($scope.tdsTax.tdsNatureCode);
              }
          });
         
         $scope.getTdsNatureData = function(natureCode) {
             //alert("gettds nature val="+vendorCode+"="+natureCode);
             var url = $stateParams.tenantid+'/app/tdstax/getTdsNatureData?natureCode='+natureCode;
             $http.get(url).success(function(data) {
                 console.log(data);
                 $scope.tdsTax.tdsNatureType=data.tdsNatureType;
                 $scope.tdsTax.tdsTaxRate=data.tdsTaxRate;
                 $scope.tdsTax.surchargeExRate=data.surchargeExRate;
                 $scope.tdsTax.eduCessExRate=data.eduCessExRate;
                 $scope.tdsTax.accountHeadCode=data.accountHeadCode;
                 
             });
         };*/
         
         $scope.calculatingTaxPaid = function(){
        	 
        	 var percentage = $scope.tdsTax.exchangeRate;
        	 
        	 if (percentage>0) // && parseFloat(document.getElementById("cashBankPaymentAddList[" + i + "].amount0").value) >0)
             {
                 if(!$scope.tdsTax.creditAmountLocal==""){
                 $scope.tdsTax.creditAmountUsd = parseFloat($scope.tdsTax.creditAmountLocal) / parseFloat(percentage);
                 $scope.tdsTax.creditAmountUsd = $scope.tdsTax.creditAmountUsd.toFixed(2);
                 }
             }
        	 
         }
       
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
                 $scope.tdsTax.tdsTaxAmountLocal=itaxForLocal.toFixed(2);
             
             
           /*  if((!IsNumeric($scope.tdsTax.surchargeExRate))){
                 $scope.tdsTax.surchargeExRate=0;
             }*/
                /* var surcharg=$scope.tdsTax.surchargeExRate;
                 var surForLocal=(parseFloat(itaxForLocal))*(parseFloat(surcharg)/100);
                 $scope.tdsTax.surchargeAmountLocal=surForLocal;
             
             
             
             var itaxWithSurg=parseFloat(itaxForLocal)+parseFloat(surForLocal);
             $scope.tdsTax.tdsSurchargeAmtLocal=itaxWithSurg;
             
             
             if((!IsNumeric($scope.tdsTax.eduCessExRate))){
                 $scope.tdsTax.eduCessExRate=0;
             }
             
             var educess=$scope.tdsTax.eduCessExRate;
             var educessLocal=(parseFloat(itaxWithSurg))*(parseFloat(educess)/100);
             $scope.tdsTax.eduCessAmtLocal=educessLocal;
             
             var netTds=parseFloat(educessLocal)+parseFloat(itaxForLocal)+parseFloat(surForLocal);
             $scope.tdsTax.tdsNetAmtLocal=netTds;*/
             $scope.tdsTax.tdsNetAmtLocal=$scope.tdsTax.tdsTaxAmountLocal;
             
             //$scope.calculatingUSD();
             
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
                     $scope.tdsTax.purchaseAmountUsd = $scope.tdsTax.purchaseAmountUsd.toFixed(2);
                     }
                     
                     if(!$scope.tdsTax.creditAmountLocal==""){
                     $scope.tdsTax.creditAmountUsd= parseFloat($scope.tdsTax.creditAmountLocal) / parseFloat(ex_rate);
                     $scope.tdsTax.creditAmountUsd =$scope.tdsTax.creditAmountUsd.toFixed(2);
                     }
                     
                     if(!$scope.tdsTax.tdsTaxAmountLocal==""){
                     $scope.tdsTax.tdsTaxAmountUsd = parseFloat($scope.tdsTax.tdsTaxAmountLocal) / parseFloat(ex_rate);
                     $scope.tdsTax.tdsTaxAmountUsd =$scope.tdsTax.tdsTaxAmountUsd.toFixed(2);
                     }
                     
                     if(!$scope.tdsTax.surchargeAmountLocal==""){
                         $scope.tdsTax.surchargeAmountUsd = parseFloat($scope.tdsTax.surchargeAmountLocal) / parseFloat(ex_rate);
                         $scope.tdsTax.surchargeAmountUsd =$scope.tdsTax.surchargeAmountUsd.toFixed(2);
                     }
                     
                     if(!$scope.tdsTax.tdsSurchargeAmtLocal==""){
                     $scope.tdsTax.tdsSurchargeAmtUsd = parseFloat($scope.tdsTax.tdsSurchargeAmtLocal) / parseFloat(ex_rate);
                     $scope.tdsTax.tdsSurchargeAmtUsd =$scope.tdsTax.tdsSurchargeAmtUsd.toFixed(2);
                     }
                     
                     if(!$scope.tdsTax.eduCessAmtLocal==""){
                     $scope.tdsTax.eduCessAmtUsd = parseFloat($scope.tdsTax.eduCessAmtLocal) / parseFloat(ex_rate);
                     $scope.tdsTax.eduCessAmtUsd =$scope.tdsTax.eduCessAmtUsd.toFixed(2);
                     }
                     
                     if(!$scope.tdsTax.tdsNetAmtLocal==""){
                     $scope.tdsTax.tdsNetAmtUsd= parseFloat($scope.tdsTax.tdsNetAmtLocal) / parseFloat(ex_rate);
                     $scope.tdsTax.tdsNetAmtUsd =$scope.tdsTax.tdsNetAmtUsd.toFixed(2);
                     
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
             $location.path($stateParams.tenantid+"/tds/tdstax/list");
         };
    });

     app.controller('tdsTaxEditCtrl', function($scope, $rootScope, $http, $location, logger, $log, ngDialog, $modal, utilsService,$filter,sharedProperties,$state,$stateParams,validationService,toaster) {

         $scope.tdsTax={
                 tdsTaxCode:'',
                 vendorNatureCode:'',
                 vendorName:'',
                 vendorCode:'',
                 tdsNatureCode:'',
                 tdsNature:'',
                 tdsNatureType:'',
                 description:'',
                 userId:'',
                 id:'',
                 text:'',
                 currencyCode:'INR',
                 exchangeRate:'1',
                 date:'',
                 purchaseAmountLocal:0.0,
                 purchaseAmountUsd:0.0,
                 creditAmountLocal:0.0,
                 creditAmountUsd:0.0,
                 tdsTaxRate:0.0,
                 tdsTaxAmountLocal:0.0,
                 tdsTaxAmountUsd:0.0,
                 surchargeExRate:0.0,
                 surchargeAmountLocal:0.0,
                 surchargeAmountUsd:0.0,
                 tdsSurchargeAmtLocal:0.0,
                 tdsSurcharegeAmtUsd:0.0,
                 eduCessExRate:0.0,
                 eduCessAmtLocal:0.0,
                 eduCessAmtUsd:0.0,
                 tdsNetAmtLocal:0.0,
                 tdsNetAmtUsd:0.0,
                 accountHeadCode:'',
            	 branch:'',
            	 invNo:''
             }
         $scope.branchList = [];
         $scope.invoiceList = [];
         $scope.isEdit=true;
         $('.datetimepick').datetimepicker({
             format : 'DD/MM/YYYY',
         });
         
         $scope.$watch('tdsTax.branch', function(newValue, oldValue) {          
             if(newValue != ''){
           	  $http.get($stateParams.tenantid+'/app/tdstax/getDropDownOne?branch='+newValue).success(function(data) {
                	 debugger
                     console.log(data);
                     if(data.success){
                         $scope.vendorList = data.vendorList;
                         //$scope.tdsNatureList = data.tdsNatureList;
                         //$scope.currencyList = data.currencyList;
                         //$scope.accountHeadList = data.accountHeadList;
                         //$scope.branchList  = data.branchList;
                     }
                     
                 });
             }
         });
         
         $scope.getDropDown = function() {          
             var url = $stateParams.tenantid+'/app/tdstax/getDropDown';
             $http.get(url).success(function(data) {
                 console.log(data);
                 if(data.success)
                	 $scope.vendorList = data.vendorList;
                     $scope.tdsNatureList = data.tdsNatureList;
                     $scope.currencyList = data.currencyList;
                     $scope.accountHeadList = data.accountHeadList;
                     $scope.branchList  = data.branchList;
             });
         };
         $scope.getDropDown ();
         var num=$stateParams;
         var num1=$stateParams.naturCode;
         
         /*$scope.$watch('tdsTax.currencyCode', function(newValue, oldValue) {          
             console.log("currency watch");
             console.log($scope.tempDropDownObj);
              if(newValue != ''){
                  if($scope.tempDropDownObj.exchangeRate!=undefined){
                      $scope.tdsTax.exchangeRate=$scope.tempDropDownObj.exchangeRate;         
                      }
              }
          });*/
      
        /*$scope.$watch('tdsTax.tdsNatureCode', function(newValue, oldValue) {          
            console.log("tdsNatureCode watch");
             if(newValue != ''){
                 $scope.getTdsNatureData($scope.tdsTax.tdsNatureCode);
             }
         });
        
        $scope.getTdsNatureData = function(natureCode) {
            //alert("gettds nature val="+vendorCode+"="+natureCode);
            var url = $stateParams.tenantid+'/app/tdstax/getTdsNatureData?natureCode='+natureCode;
            $http.get(url).success(function(data) {
                console.log(data);

                $scope.tdsTax.accountHeadCode=data.accountHeadCode;
                
            });
        };*/
        
        $scope.$watch('tdsTax.tdsNatureType', function(newValue, oldValue) {          
            if(newValue != ''){
           	 if($scope.tdsTax.tdsNatureCode !='' && $scope.tdsTax.tdsNatureCode !=undefined && $scope.tdsTax.tdsNatureCode !=null){
           		 
           		 $http.get($stateParams.tenantid+'/app/tdstax/getTdsNatureTax?type='+newValue+'&nature='+$scope.tdsTax.tdsNatureCode).success(function(data) {
                   	 debugger
                        console.log(data);
                        if(data){
                       	 $scope.tdsTax.tdsTaxRate=data.tdsTaxRate;
                       	$scope.calculatingTax();
                        }
                        
                    });
           	 }else{
           		 logger.logError("Please select Nature!"); 
           	 }
          	  
            }
        });
        
        
        $scope.$watch('tdsTax.vendorCode', function(newValue, oldValue) {          
            if(newValue != ''){
          	  $http.get($stateParams.tenantid+'/app/tdstax/getInvoice?vendor='+newValue).success(function(data) {
               	 debugger
                    console.log(data);
                    if(data.success){
                        $scope.invoiceList = data.invoiceList;
                    }
                    
                });
            }
        });
        
        /*$scope.$watch('tdsTax.invNo', function(newValue, oldValue) {          
            if(newValue != ''){
          	  $http.get($stateParams.tenantid+'/app/tdstax/getInvAmount?inv='+newValue).success(function(data) {
               	 debugger
                    console.log(data);
                    if(data){
                        $scope.tdsTax.purchaseAmountLocal = data.invAmount;
                        $scope.calculatingTax();
                    }
                    
                });
            }
        });*/

         $scope.edit = function() {

        		
        		    		
             console.log("edit");
                 $http.get($stateParams.tenantid+'/app/tdstax/edit?natureCode='+$stateParams.natureCode).success(function(result) {
                     $scope.tdsTax=result;
                     
                     
                     
                     
//                     $scope.calculatingTaxPaid = function(){
                    	 
                    	/* var percentage = $scope.tdsTax.exchangeRate;
                    	 
                    	 if (percentage>0) 
                         {
                             if(!$scope.tdsTax.creditAmountLocal==""){
                             $scope.tdsTax.creditAmountUsd = parseFloat($scope.tdsTax.creditAmountLocal) / parseFloat(percentage);
                             $scope.tdsTax.creditAmountUsd = $scope.tdsTax.creditAmountUsd.toFixed(2);
                             }
                         }*/
                    	 
//                     }
                   
//                     $scope.calculatingTax = function() {   

                             var itax=$scope.tdsTax.tdsTaxRate;
                             var itaxForLocal=parseFloat($scope.tdsTax.purchaseAmountLocal)* (parseFloat(itax)/100);
                             $scope.tdsTax.tdsTaxAmountLocal=itaxForLocal.toFixed(2);
                         
                         

                             /*var surcharg=$scope.tdsTax.surchargeExRate;
                             var surForLocal=(parseFloat(itaxForLocal))*(parseFloat(surcharg)/100);
                             $scope.tdsTax.surchargeAmountLocal=surForLocal;
                         
                         
                         
                         var itaxWithSurg=parseFloat(itaxForLocal)+parseFloat(surForLocal);
                         $scope.tdsTax.tdsSurchargeAmtLocal=itaxWithSurg;
                         
                         
                         
                         var educess=$scope.tdsTax.eduCessExRate;
                         var educessLocal=(parseFloat(itaxWithSurg))*(parseFloat(educess)/100);
                         $scope.tdsTax.eduCessAmtLocal=educessLocal;
                         
                         var netTds=parseFloat(educessLocal)+parseFloat(itaxForLocal)+parseFloat(surForLocal);
                         $scope.tdsTax.tdsNetAmtLocal=netTds;*/
                         
                         $scope.tdsTax.tdsNetAmtLocal=$scope.tdsTax.tdsTaxAmountLocal.toFixed(2);

                         
                         //$scope.calculatingUSD();
                         
//                     }


//                     $scope.calculatingUSD = function() {   
                    
                             /*var ex_rate,AmountUsd;

                             if ($scope.tdsTax.exchangeRate.length==0)
                             {

                             }
                             else
                             {
                                 ex_rate = $scope.tdsTax.exchangeRate;
                             }


                             if (ex_rate>0) // && parseFloat(document.getElementById("cashBankPaymentAddList[" + i + "].amount0").value) >0)
                             {
                            	 if(!$scope.tdsTax.purchaseAmountLocal==""){
                                     $scope.tdsTax.purchaseAmountUsd = parseFloat($scope.tdsTax.purchaseAmountLocal) / parseFloat(ex_rate);
                                     $scope.tdsTax.purchaseAmountUsd = $scope.tdsTax.purchaseAmountUsd.toFixed(2);
                                     }
                                     
                                     if(!$scope.tdsTax.creditAmountLocal==""){
                                     $scope.tdsTax.creditAmountUsd= parseFloat($scope.tdsTax.creditAmountLocal) / parseFloat(ex_rate);
                                     $scope.tdsTax.creditAmountUsd =$scope.tdsTax.creditAmountUsd.toFixed(2);
                                     }
                                     
                                     if(!$scope.tdsTax.tdsTaxAmountLocal==""){
                                     $scope.tdsTax.tdsTaxAmountUsd = parseFloat($scope.tdsTax.tdsTaxAmountLocal) / parseFloat(ex_rate);
                                     $scope.tdsTax.tdsTaxAmountUsd =$scope.tdsTax.tdsTaxAmountUsd.toFixed(2);
                                     }
                                     
                                     if(!$scope.tdsTax.surchargeAmountLocal==""){
                                         $scope.tdsTax.surchargeAmountUsd = parseFloat($scope.tdsTax.surchargeAmountLocal) / parseFloat(ex_rate);
                                         $scope.tdsTax.surchargeAmountUsd =$scope.tdsTax.surchargeAmountUsd.toFixed(2);
                                     }
                                     
                                     if(!$scope.tdsTax.tdsSurchargeAmtLocal==""){
                                     $scope.tdsTax.tdsSurchargeAmtUsd = parseFloat($scope.tdsTax.tdsSurchargeAmtLocal) / parseFloat(ex_rate);
                                     $scope.tdsTax.tdsSurchargeAmtUsd =$scope.tdsTax.tdsSurchargeAmtUsd.toFixed(2);
                                     }
                                     
                                     if(!$scope.tdsTax.eduCessAmtLocal==""){
                                     $scope.tdsTax.eduCessAmtUsd = parseFloat($scope.tdsTax.eduCessAmtLocal) / parseFloat(ex_rate);
                                     $scope.tdsTax.eduCessAmtUsd =$scope.tdsTax.eduCessAmtUsd.toFixed(2);
                                     }
                                     
                                     if(!$scope.tdsTax.tdsNetAmtLocal==""){
                                     $scope.tdsTax.tdsNetAmtUsd= parseFloat($scope.tdsTax.tdsNetAmtLocal) / parseFloat(ex_rate);
                                     $scope.tdsTax.tdsNetAmtUsd =$scope.tdsTax.tdsNetAmtUsd.toFixed(2);
                                     
                                  //   document.forms[0].tdsVendorAmtLocal.value = parseFloat($scope.tdsTax.creditAmountLocal)- parseFloat($scope.tdsTax.tdsNetAmtLocal);
                                   //  document.forms[0].tdsVendorAmtUsd.value = parseFloat(document.forms[0].tdsCreditAmtUsd.value)- parseFloat(document.forms[0].tdsNetAmtUsd.value);
                                         
                                     }
                                         
                                 
                                 
                                 
                             }
                             else
                             {
                                 $scope.tdsTax.purchaseAmountUsd=0;
                                 $scope.tdsTax.creditAmountUsd=0;
                             }*/
                             //totalCalculation();   
//                     }
                     
                     
                     
                     
                     
                     console.log(result);
                 }).error(function(result) {
                     console.log("data" + result);
                 });
         };
         $scope.edit();
         
         
         
         $scope.calculatingTaxPaid = function(){
        	 
        	 var percentage = $scope.tdsTax.exchangeRate;
        	 
        	 if (percentage>0) // && parseFloat(document.getElementById("cashBankPaymentAddList[" + i + "].amount0").value) >0)
             {
                 if(!$scope.tdsTax.creditAmountLocal==""){
                 $scope.tdsTax.creditAmountUsd = parseFloat($scope.tdsTax.creditAmountLocal) / parseFloat(percentage);
                 $scope.tdsTax.creditAmountUsd = $scope.tdsTax.creditAmountUsd.toFixed(2);
                 }
             }
        	 
         }
       
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
                 $scope.tdsTax.tdsTaxAmountLocal=itaxForLocal.toFixed(2);
             
             
           /*  if((!IsNumeric($scope.tdsTax.surchargeExRate))){
                 $scope.tdsTax.surchargeExRate=0;
             }*/
                 /*var surcharg=$scope.tdsTax.surchargeExRate;
                 var surForLocal=(parseFloat(itaxForLocal))*(parseFloat(surcharg)/100);
                 $scope.tdsTax.surchargeAmountLocal=surForLocal;
             
             
             
             var itaxWithSurg=parseFloat(itaxForLocal)+parseFloat(surForLocal);
             $scope.tdsTax.tdsSurchargeAmtLocal=itaxWithSurg;
             
             
             if((!IsNumeric($scope.tdsTax.eduCessExRate))){
                 $scope.tdsTax.eduCessExRate=0;
             }
             
             var educess=$scope.tdsTax.eduCessExRate;
             var educessLocal=(parseFloat(itaxWithSurg))*(parseFloat(educess)/100);
             $scope.tdsTax.eduCessAmtLocal=educessLocal;
             
             var netTds=parseFloat(educessLocal)+parseFloat(itaxForLocal)+parseFloat(surForLocal);
             $scope.tdsTax.tdsNetAmtLocal=netTds;*/
                 $scope.tdsTax.tdsNetAmtLocal=$scope.tdsTax.tdsTaxAmountLocal.toFixed(2);
             
//             $scope.calculatingUSD();
             
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
                     $scope.tdsTax.purchaseAmountUsd = $scope.tdsTax.purchaseAmountUsd.toFixed(2);
                     }
                     
                     if(!$scope.tdsTax.creditAmountLocal==""){
                     $scope.tdsTax.creditAmountUsd= parseFloat($scope.tdsTax.creditAmountLocal) / parseFloat(ex_rate);
                     $scope.tdsTax.creditAmountUsd = $scope.tdsTax.creditAmountUsd.toFixed(2);
                     }
                     
                     if(!$scope.tdsTax.tdsTaxAmountLocal==""){
                     $scope.tdsTax.tdsTaxAmountUsd = parseFloat($scope.tdsTax.tdsTaxAmountLocal) / parseFloat(ex_rate);
                     $scope.tdsTax.tdsTaxAmountUsd = $scope.tdsTax.tdsTaxAmountUsd.toFixed(2);
                     }
                     
                     if(!$scope.tdsTax.surchargeAmountLocal==""){
                         $scope.tdsTax.surchargeAmountUsd = parseFloat($scope.tdsTax.surchargeAmountLocal) / parseFloat(ex_rate);
                         $scope.tdsTax.surchargeAmountUsd = $scope.tdsTax.surchargeAmountUsd.toFixed(2);
                     }
                     
                     if(!$scope.tdsTax.tdsSurchargeAmtLocal==""){
                     $scope.tdsTax.tdsSurchargeAmtUsd = parseFloat($scope.tdsTax.tdsSurchargeAmtLocal) / parseFloat(ex_rate);
                     $scope.tdsTax.tdsSurchargeAmtUsd = $scope.tdsTax.tdsSurchargeAmtUsd.toFixed(2);
                     }
                     
                     if(!$scope.tdsTax.eduCessAmtLocal==""){
                     $scope.tdsTax.eduCessAmtUsd = parseFloat($scope.tdsTax.eduCessAmtLocal) / parseFloat(ex_rate);
                     $scope.tdsTax.eduCessAmtUsd = $scope.tdsTax.eduCessAmtUsd.toFixed(2);
                     }
                     
                     if(!$scope.tdsTax.tdsNetAmtLocal==""){
                     $scope.tdsTax.tdsNetAmtUsd= parseFloat($scope.tdsTax.tdsNetAmtLocal) / parseFloat(ex_rate);
                     $scope.tdsTax.tdsNetAmtUsd = $scope.tdsTax.tdsNetAmtUsd.toFixed(2);
                     
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
         
         $scope.update = function(vendorNatureForm) {
        	 var obj=$scope.tdsTax;
             if (new validationService().checkFormValidity(vendorNatureForm)) {
                 $http.post($stateParams.tenantid+'/app/tdstax/update', obj).success(function(result) {
                     if(result.success) {
                         logger.logSuccess("Update successfully!");
                         $location.path($stateParams.tenantid+'/tds/tdstax/list');
                     } else {
                         logger.logError("Record Not Update!");
                     }
                 }).error(function(result) {
                     console.log("data" + result);
                 });
             }else {
                 toaster.pop('error', "Please fill the required fields",logger.getErrorHtmlNew(vendorNatureForm.$validationSummary), 5500, 'trustedHtml');
             }
         };
         
         $scope.cancel = function() {
             $location.path($stateParams.tenantid+"/tds/tdstax/list");
         };
    });



