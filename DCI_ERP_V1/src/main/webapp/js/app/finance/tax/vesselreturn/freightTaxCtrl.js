   
'use strict';
     app.controller('freightTaxListCtrl', function($scope, $rootScope, $http, $location, logger, $log, ngDialog, $modal, utilsService,$filter,sharedProperties,$state,$stateParams) {

         $scope.pageCounters = [ 10,15, 25, 50, 75, 100, 125,150 ];
         $scope.index=[];
         $scope.checked = [];
         var index="";
         $scope.itemsByPage = 10;
         $scope.hideUploadIcon=true;
       
         //Add
         $scope.add = function(){
             $state.go('app.finance.tax.vesselreturn.freighttax.add',{tenantid:$stateParams.tenantid});
         };
         $scope.edit = function(freightTaxCode){
             $state.go('app.finance.tax.vesselreturn.freighttax.edit',{freightTaxCode:freightTaxCode});
         };
         $scope.freightTax={
                 freightTaxCode:'',
                 vesselCode:'',
                 vesselName:'',
                 voyageNo:'',
                 portCode:'',
                 portName:'',
                 portSequence:0,
                 tdsNatureType:'',
                 arrivalDate:'',
                 departureDate:'',
                 userId:'',
                 id:'',
                 text:'',
                 currencyCode:'',                 
                 exchangeRate:0.0,
                 prepaidAmtLocal:0.0,
                 prepaidAmtUsd:0.0,
                 payableAtDestAmtLocal:0.0,
                 payableAtDestAmtUsd:0.0,
                 collectedOnImportAmtLocal:0.0,
                 collectedOnImportAmtUsd:0.0,
                 thcAmtLocal:0.0,
                 thcAmtUsd:0.0,
                 haulageAmtLocal:0.0,
                 haulageAmtUsd:0.0,
                 bunkerAdjustAmtLocal:0.0,
                 bunkerAdjustAmtUsd:0.0,
                 totalAmtLocal:0.0,
                 totalAmtUsd:0.0,
                 incomePercOfGrosRate:0.0,
                 taxPayablePercRate:0.0,
                 surchargePercRate:0.0,
                 educationalCessPercRate:0.0,
                 taxPayablePercAmtLocal:0.0,
                 taxPayablePercAmtUsd:0.0,
                 incomePercOfGrosAmtLocal:0.0,
                 incomePercOfGrosAmtUsd:0.0,
                 surchargePercAmtLocal:0.0,
                 surchargePercAmtUsd:0.0,
                 educationalCessLocal:0.0,
                 educationalCessUsd:0.0,
                 grossTaxAmtLocal:0.0,
                 grossTaxAmtUsd:0.0,
                 netTaxPayableAmtLocal:0.0,
                 netTaxPayableAmtUsd:0.0,
                 advanceTaxPaidAmtLocal:0.0,
                 advanceTaxPaidAmtUsd:0.0,
                 finalTaxPaidAmtLocal:0.0,
                 finalTaxPaidAmtUsd:0.0,
                 refundAmtLocal:0.0,
                 refundAmtUsd:0.0             
                 }
                 
         $scope.getFreightTaxList = function() {
             $scope.dataLoopCount = 0;
             $scope.showEmptyLabel = false;
             $scope.from = 0;
             $scope.to = 100;
             $scope.rowCollection = [];

             var url = $stateParams.tenantid+'/app/freighttax/list';
             $http.get(url).success(function(data) {
                 console.log(data);
                     $scope.rowCollection = $scope.rowCollection.concat(data);
             });
         };
         $scope.getFreightTaxList();
         
         
         $scope.deleteFreightTax=function(freightTaxCode,index){
             ngDialog.openConfirm().then(function() { 
             var url=$stateParams.tenantid+'/app/freighttax/deleteFreightTax?freightTaxCode='+freightTaxCode;
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


     app.controller('freightTaxAddCtrl', function($scope, $rootScope, $http, $location, logger, $log, ngDialog, $modal, utilsService,$filter,sharedProperties,$state,$injector,validationService,toaster,$stateParams) {
         $scope.freightTax={
                 freightTaxCode:'',
                 vesselCode:'',
                 vesselName:'',
                 voyageNo:'',
                 portCode:'',
                 portName:'',               
                 portSequence:0,
                 tdsNatureType:'',
                 arrivalDate:'',
                 departureDate:'',
                 userId:'',
                 id:'',
                 text:'',
                 currencyCode:'',                 
                 exchangeRate:0.0,
                 prepaidAmtLocal:0.0,
                 prepaidAmtUsd:0.0,
                 payableAtDestAmtLocal:0.0,
                 payableAtDestAmtUsd:0.0,
                 collectedOnImportAmtLocal:0.0,
                 collectedOnImportAmtUsd:0.0,
                 thcAmtLocal:0.0,
                 thcAmtUsd:0.0,
                 haulageAmtLocal:0.0,
                 haulageAmtUsd:0.0,
                 bunkerAdjustAmtLocal:0.0,
                 bunkerAdjustAmtUsd:0.0,
                 totalAmtLocal:0.0,
                 totalAmtUsd:0.0,
                 incomePercOfGrosRate:0.0,
                 taxPayablePercRate:0.0,
                 surchargePercRate:0.0,
                 educationalCessPercRate:0.0,
                 taxPayablePercAmtLocal:0.0,
                 taxPayablePercAmtUsd:0.0,
                 incomePercOfGrosAmtLocal:0.0,
                 incomePercOfGrosAmtUsd:0.0,
                 surchargePercAmtLocal:0.0,
                 surchargePercAmtUsd:0.0,
                 educationalCessLocal:0.0,
                 educationalCessUsd:0.0,
                 grossTaxAmtLocal:0.0,
                 grossTaxAmtUsd:0.0,
                 netTaxPayableAmtLocal:0.0,
                 netTaxPayableAmtUsd:0.0,
                 advanceTaxPaidAmtLocal:0.0,
                 advanceTaxPaidAmtUsd:0.0,
                 finalTaxPaidAmtLocal:0.0,
                 finalTaxPaidAmtUsd:0.0,
                 refundAmtLocal:0.0,
                 refundAmtUsd:0.0             
             }
         $scope.tempDropDownObj={};
         $scope.isEdit=false;
         $('.datetimepick').datetimepicker({
             format : 'DD/MM/YYYY',
         });
         
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
             if($scope.freightTax.vesselCode==undefined || $scope.freightTax.vesselCode==null || $scope.freightTax.vesselCode==""){
                 msg+="vessel Name - This should be Required!!"
             }else if($scope.freightTax.voyageNo==undefined || $scope.freightTax.voyageNo==null || $scope.freightTax.voyageNo==""){
                 msg+="Voyage - This should be Required!!"
             }
             else if($scope.freightTax.portName==undefined || $scope.freightTax.portName==null || $scope.freightTax.portName==""){
                 msg+="Port - This should be Required!!"
             }
             else if($scope.freightTax.currencyCode==undefined || $scope.freightTax.currencyCode==null || $scope.freightTax.currencyCode==""){
                 msg+="Currency - This should be Required!!"
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
             console.log($scope.freightTax);
                 $http.post($stateParams.tenantid+'/app/freighttax/save', $scope.freightTax).success(function(result) {
                     if(result.success) {
                         logger.logSuccess("Saved successfully!");
                         $location.path($stateParams.tenantid+'/tax/freighttax/list');
                     } else {
                         logger.logError("Record Not Saved!");
                     }
                 }).error(function(result) {
                     console.log("data" + result);
                 });
         };

         $scope.getDropDown = function() {          
             var url = $stateParams.tenantid+'/app/freighttax/getDropDown';
             $http.get(url).success(function(data) {
                 console.log(data);
                 if(data.success){
                     $scope.vesselList = data.vesselList;
                     $scope.currencyList = data.currencyList;
                 }
                 
             });
         };
         $scope.getDropDown ();
         $scope.$watch('freightTax.vendorCode', function(newValue, oldValue) {          
             $scope.tdsNatureList=[];
             $scope.freightTax.tdsNatureCode='';
                  if(newValue != ''){              
                      $scope.getTdsNature($scope.freightTax.vendorCode);
                  }
              });
         
         
         $scope.getVoyage = function(vesselId) {     
                $http.post($stateParams.tenantid+'/app/freighttax/getVoyage', vesselId).success(function(data) {
                    console.log("voyage");
                    console.log(data);
                    $scope.voyageList = data;
                }).error(function(data) {
                });

            };
           
            $scope.$watch('freightTax.vesselCode', function(newValue, oldValue) {          
                console.log("vessel code11");
                console.log($scope.freightTax.vesselCode);
                $scope.voyageList = [];
                if(newValue != ''){                   
                    $scope.getVoyage($scope.freightTax.vesselCode);
                }
            });
            
            $scope.$watch('freightTax.voyageNo', function(newValue, oldValue) {          
                $scope.portList = [];
                if(newValue != ''){
                    $scope.getPort($scope.freightTax.voyageNo,$scope.freightTax.portName);
                }
            });
                       
         
            $scope.getPort = function(voyageNo,portName) {
                $http.post($stateParams.tenantid+'/app/freighttax/port', voyageNo).success(function(data) {
                    console.log('port');
                    console.log(data);
                    $scope.portList = data;
                    $scope.freightTax.portName=portName;
                }).error(function(data) {
                });

            };
            
            
            
            $scope.$watch('freightTax.portName', function(newValue, oldValue) {          
                  if(newValue != ''){
                      $scope.getVesselDate($scope.freightTax.portName);
                  }
              });
            
            
            $scope.getVesselDate = function(port) {
                if(port!=undefined && port!=null && port!=""){
                    var portArr=port.split("-");
                    $scope.freightTax.portSequence=portArr[0];
                    $scope.freightTax.portCode=portArr[1];
                    $http.post($stateParams.tenantid+'/app/freighttax/getVesselDate', $scope.freightTax).success(function(data) {
                        console.log('get vessel date');
                        console.log(data);
                        $scope.freightTax.arrivalDate=data.arrivalDate;
                        $scope.freightTax.departureDate=data.departureDate;
                    }).error(function(data) {
                    });
  
                }
                
            };
         
         $scope.getTdsNature = function(vendorCode) {
             var url = $stateParams.tenantid+'/app/freighttax/getTdsNature?vendorCode='+vendorCode;
             $http.get(url).success(function(data) {
                 console.log(data);
                 if(data.success){
                     $scope.tdsNatureList = data.tdsNatureList;
                 }
             });
         };
         $scope.$watch('freightTax.currencyCode', function(newValue, oldValue) {          
              console.log("currency watch");
              console.log($scope.tempDropDownObj);
               if(newValue != ''){
                   if($scope.tempDropDownObj.exchangeRate!=undefined){
                       $scope.freightTax.exchangeRate=$scope.tempDropDownObj.exchangeRate;         
                       }
               }
           });
         $scope.$watch('freightTax.currencyCode', function(newValue, oldValue) {          
             console.log("currency watch");
             console.log($scope.tempDropDownObj);
              if(newValue != ''){
                  if($scope.tempDropDownObj.exchangeRate!=undefined){
                      $scope.freightTax.exchangeRate=$scope.tempDropDownObj.exchangeRate;    
                      $scope.calculatingTotal();
                      }
              }
          }); 
       
         $scope.$watch('freightTax.tdsNatureCode', function(newValue, oldValue) {          
             console.log("tdsNatureCode watch");
              if(newValue != ''){
                  $scope.getTdsNatureData($scope.freightTax.vendorCode,$scope.freightTax.tdsNatureCode);
              }
          });
         
         $scope.getTdsNatureData = function(vendorCode,natureCode) {
             var url = $stateParams.tenantid+'/app/freighttax/getTdsNatureData?vendorCode='+vendorCode+'&natureCode='+natureCode;
             $http.get(url).success(function(data) {
                 console.log(data);
                 $scope.freightTax.tdsNatureType=data.tdsNatureType;
                 $scope.freightTax.tdsTaxRate=data.tdsTaxRate;
                 $scope.freightTax.surchargeExRate=data.surchargeExRate;
                 $scope.freightTax.eduCessExRate=data.eduCessExRate;
                 
             });
         };
         
       

         $scope.calculatingTotal=function (){
             console.log(isNaN($scope.freightTax.prepaidAmtLocal));
             if((isNaN($scope.freightTax.prepaidAmtLocal)) || $scope.freightTax.prepaidAmtLocal==""){
                 $scope.freightTax.prepaidAmtLocal=0;
             }
             if((isNaN($scope.freightTax.payableAtDestAmtLocal)) || $scope.freightTax.payableAtDestAmtLocal==""){
                 $scope.freightTax.payableAtDestAmtLocal=0;
             }
             if((isNaN($scope.freightTax.collectedOnImportAmtLocal)) || $scope.freightTax.collectedOnImportAmtLocal==""){
                 $scope.freightTax.collectedOnImportAmtLocal=0;
             }
             if((isNaN($scope.freightTax.thcAmtLocal)) || $scope.freightTax.thcAmtLocal==""){
                 $scope.freightTax.thcAmtLocal=0;
             }
             if((isNaN($scope.freightTax.haulageAmtLocal)) || $scope.freightTax.haulageAmtLocal==""){
                 $scope.freightTax.haulageAmtLocal=0;
             }
             if((isNaN($scope.freightTax.bunkerAdjustAmtLocal)) || $scope.freightTax.bunkerAdjustAmtLocal==""){
                 $scope.freightTax.bunkerAdjustAmtLocal=0;
             }
              var localtotal = ( parseFloat($scope.freightTax.prepaidAmtLocal) )+ 
              (parseFloat($scope.freightTax.payableAtDestAmtLocal)) + (parseFloat($scope.freightTax.collectedOnImportAmtLocal)) + 
              (parseFloat($scope.freightTax.thcAmtLocal)) + (parseFloat($scope.freightTax.haulageAmtLocal)) + 
              (parseFloat($scope.freightTax.bunkerAdjustAmtLocal));
              $scope.freightTax.totalAmtLocal = (localtotal).toFixed(2);
             

              if(isNaN($scope.freightTax.incomePercOfGrosRate) || $scope.freightTax.incomePercOfGrosRate=="" ){
                  $scope.freightTax.incomePercOfGrosRate=0;
          }

                 var incomeLocal=(parseFloat($scope.freightTax.totalAmtLocal)* 
                 (parseFloat($scope.freightTax.incomePercOfGrosRate)/100));
                 $scope.freightTax.incomePercOfGrosAmtLocal=(incomeLocal).toFixed(2);
                 
                 if(isNaN($scope.freightTax.taxPayablePercRate) || $scope.freightTax.taxPayablePercRate=="" ){
                     $scope.freightTax.taxPayablePercRate=0;
                 }
                
                 var taxLocal=(parseFloat($scope.freightTax.incomePercOfGrosAmtLocal)* 
                 (parseFloat($scope.freightTax.taxPayablePercRate)/100));
                 $scope.freightTax.taxPayablePercAmtLocal=(taxLocal).toFixed(2);


                 if(isNaN($scope.freightTax.surchargePercRate) || $scope.freightTax.taxPayablePercRate==""){
                     $scope.freightTax.surchargePercRate=0;
                 }
             var surlocal = (parseFloat($scope.freightTax.taxPayablePercAmtLocal) * 
             (parseFloat($scope.freightTax.surchargePercRate) / 100));
             $scope.freightTax.surchargePercAmtLocal = (surlocal).toFixed(2);
             
             if(isNaN($scope.freightTax.educationalCessPercRate) || $scope.freightTax.educationalCessPercRate==""){
                 $scope.freightTax.educationalCessPercRate=0;
             }
             
             var edulocal = (((parseFloat($scope.freightTax.taxPayablePercAmtLocal)) + 
                 (parseFloat($scope.freightTax.surchargePercAmtLocal))) * 
             (parseFloat($scope.freightTax.educationalCessPercRate) / 100));
             $scope.freightTax.educationalCessLocal = (edulocal).toFixed(2);

              var localgross =  (parseFloat($scope.freightTax.taxPayablePercAmtLocal)) + 
              (parseFloat($scope.freightTax.surchargePercAmtLocal)) + (parseFloat($scope.freightTax.educationalCessLocal));
              $scope.freightTax.grossTaxAmtLocal = (localgross).toFixed(2);
              
              $scope.freightTax.netTaxPayableAmtLocal = $scope.freightTax.grossTaxAmtLocal;
              if(isNaN($scope.freightTax.advanceTaxPaidAmtLocal) || $scope.freightTax.advanceTaxPaidAmtLocal==""){
                  $scope.freightTax.advanceTaxPaidAmtLocal=0;
              }
             var finallocal = (parseFloat($scope.freightTax.netTaxPayableAmtLocal)) - 
             (parseFloat($scope.freightTax.advanceTaxPaidAmtLocal));
             $scope.freightTax.finalTaxPaidAmtLocal = (finallocal).toFixed(2);
             
             if((parseFloat($scope.freightTax.advanceTaxPaidAmtLocal)) > (parseFloat($scope.freightTax.netTaxPayableAmtLocal))){
                 var refundlocal = (parseFloat($scope.freightTax.advanceTaxPaidAmtLocal)) - 
             (parseFloat($scope.freightTax.netTaxPayableAmtLocal));
             $scope.freightTax.refundAmtLocal = (refundlocal).toFixed(2);
             }else{
                 $scope.freightTax.refundAmtLocal = 0;
             } 
             
             $scope.calculatingUSD();
         }


         $scope.calculatingUSD=function(){
                 //fraction=document.forms[0].ex_rate.value;
                 //if (fdecimal("amount",parseInt(18)-parseInt(fraction),fraction,"Amount")==false) return false;

                 var ex_rate,AmountUsd;

               
                 ex_rate=$scope.freightTax.exchangeRate;
                 //USDFraction=document.getElementById("cashBankPaymentAddList[" + i + "].rate0").value;
                 if (ex_rate>0) // && parseFloat(document.getElementById("cashBankPaymentAddList[" + i + "].amount0").value) >0)
                 {
                     if(!isNaN($scope.freightTax.prepaidAmtLocal) && $scope.freightTax.prepaidAmtLocal!=""){
                     $scope.freightTax.prepaidAmtUsd = (parseFloat($scope.freightTax.prepaidAmtLocal) / parseFloat(ex_rate)).toFixed(2);
                     }else{
                         $scope.freightTax.prepaidAmtUsd = 0;
                     }
                     
                     if(!isNaN($scope.freightTax.payableAtDestAmtLocal) && $scope.freightTax.payableAtDestAmtLocal!=""){
                     $scope.freightTax.payableAtDestAmtUsd = (parseFloat($scope.freightTax.payableAtDestAmtLocal) / parseFloat(ex_rate)).toFixed(2);
                     }else{
                         $scope.freightTax.payableAtDestAmtUsd = 0;
                     }
                     
             
                     if(!isNaN($scope.freightTax.collectedOnImportAmtLocal)  && $scope.freightTax.collectedOnImportAmtLocal!=""){
                     $scope.freightTax.collectedOnImportAmtUsd = (parseFloat($scope.freightTax.collectedOnImportAmtLocal) / parseFloat(ex_rate)).toFixed(2);
                     }else{
                         $scope.freightTax.collectedOnImportAmtUsd = 0;
                     }
                     
                     if(!isNaN($scope.freightTax.thcAmtLocal)  && $scope.freightTax.thcAmtLocal!=""){
                     $scope.freightTax.thcAmtUsd = (parseFloat($scope.freightTax.thcAmtLocal) / parseFloat(ex_rate)).toFixed(2);
                     }
                     else{
                         $scope.freightTax.thcAmtUsd = 0;
                     }
                     if(!isNaN($scope.freightTax.haulageAmtLocal)  && $scope.freightTax.haulageAmtLocal!=""){
                     $scope.freightTax.haulageAmtUsd = (parseFloat($scope.freightTax.haulageAmtLocal) / parseFloat(ex_rate)).toFixed(2);
                     }else{
                         $scope.freightTax.haulageAmtUsd = 0;
                     }
                     
                     if(!isNaN($scope.freightTax.bunkerAdjustAmtLocal)  && $scope.freightTax.bunkerAdjustAmtLocal!=""){
                     $scope.freightTax.bunkerAdjustAmtUsd = (parseFloat($scope.freightTax.bunkerAdjustAmtLocal) / parseFloat(ex_rate)).toFixed(2);
                     }else{
                         $scope.freightTax.bunkerAdjustAmtUsd = 0;
                     }
                 //  document.forms[0].tdsVendorAmtLocal.value = parseFloat(document.forms[0].tdsCreditAmtLocal.value)- parseFloat(document.forms[0].tdsNetAmtLocal.value));
             //      document.forms[0].tdsVendorAmtUsd.value = parseFloat(document.forms[0].tdsCreditAmtUsd.value)- parseFloat(document.forms[0].tdsNetAmtUsd.value));

                      var usdtotal =  (parseFloat($scope.freightTax.prepaidAmtUsd)) + 
                      (parseFloat($scope.freightTax.payableAtDestAmtUsd)) + (parseFloat($scope.freightTax.collectedOnImportAmtUsd)) + 
                      (parseFloat($scope.freightTax.thcAmtUsd)) + (parseFloat($scope.freightTax.haulageAmtUsd)) + 
                      (parseFloat($scope.freightTax.bunkerAdjustAmtUsd));
                      $scope.freightTax.totalAmtUsd= (usdtotal).toFixed(2);;
                         
                         
                     
                     if(!isNaN($scope.freightTax.incomePercOfGrosAmtLocal)  && $scope.freightTax.incomePercOfGrosAmtLocal!=""){
                     $scope.freightTax.incomePercOfGrosAmtUsd = (parseFloat($scope.freightTax.incomePercOfGrosAmtLocal) / parseFloat(ex_rate)).toFixed(2);
                     }else{
                         $scope.freightTax.incomePercOfGrosAmtUsd=0;
                     }

                     if(!isNaN($scope.freightTax.taxPayablePercAmtLocal)  && $scope.freightTax.taxPayablePercAmtLocal!=""){
                     $scope.freightTax.taxPayablePercAmtUsd = (parseFloat($scope.freightTax.taxPayablePercAmtLocal) / parseFloat(ex_rate)).toFixed(2);
                     }
                     else{
                         $scope.freightTax.taxPayablePercAmtUsd=0;
                     }
                     if(!isNaN($scope.freightTax.surchargePercAmtLocal)  && $scope.freightTax.surchargePercAmtLocal!=""){
                     $scope.freightTax.surchargePercAmtUsd = (parseFloat($scope.freightTax.surchargePercAmtLocal) / parseFloat(ex_rate)).toFixed(2);
                     }else{
                         $scope.freightTax.surchargePercAmtUsd=0;
                     }
                     if(!isNaN($scope.freightTax.educationalCessLocal)  && $scope.freightTax.educationalCessLocal!=""){
                     $scope.freightTax.educationalCessUsd = (parseFloat($scope.freightTax.educationalCessLocal) / parseFloat(ex_rate)).toFixed(2);
                     }else{
                         $scope.freightTax.educationalCessUsd=0;
                     }

                      var usdgross =  (parseFloat($scope.freightTax.taxPayablePercAmtUsd)) + 
                      (parseFloat($scope.freightTax.surchargePercAmtUsd)) + (parseFloat($scope.freightTax.educationalCessUsd));
                      $scope.freightTax.grossTaxAmtUsd= (usdgross).toFixed(2);;
                     
                     $scope.freightTax.netTaxPayableAmtUsd = (parseFloat($scope.freightTax.netTaxPayableAmtLocal) / parseFloat(ex_rate)).toFixed(2);     
                     
                     if(!isNaN($scope.freightTax.advanceTaxPaidAmtLocal)  && $scope.freightTax.advanceTaxPaidAmtLocal!=""){
                     $scope.freightTax.advanceTaxPaidAmtUsd = (parseFloat($scope.freightTax.advanceTaxPaidAmtLocal) / parseFloat(ex_rate)).toFixed(2);
                     }else{
                         $scope.freightTax.advanceTaxPaidAmtUsd=0;
                     }

                     if(!isNaN($scope.freightTax.finalTaxPaidAmtLocal)  && $scope.freightTax.finalTaxPaidAmtLocal!=""){
                     $scope.freightTax.finalTaxPaidAmtUsd= (parseFloat($scope.freightTax.finalTaxPaidAmtLocal) / parseFloat(ex_rate)).toFixed(2);
                     }else{
                         $scope.freightTax.finalTaxPaidAmtUsd=0;
                     }
                     
                     $scope.freightTax.refundAmtUsd = (parseFloat($scope.freightTax.refundAmtLocal) / parseFloat(ex_rate)).toFixed(2);
                 }
                 else
                 {
                     $scope.freightTax.prepaidAmtUsd=0;
                     $scope.freightTax.payableAtDestAmtUsd=0;
                     $scope.freightTax.collectedOnImportAmtUsd=0;
                     $scope.freightTax.thcAmtUsd=0;
                     $scope.freightTax.haulageAmtUsd=0;
                     $scope.freightTax.bunkerAdjustAmtUsd=0;
                     $scope.freightTax.incomePercOfGrosAmtUsd=0;
                     $scope.freightTax.taxPayablePercAmtUsd = 0;
                     $scope.freightTax.surchargePercAmtUsd = 0;
                     $scope.freightTax.educationalCessUsd = 0;
                 }
                 //totalCalculation();
         }

         
         
         $scope.cancel = function() {
             $location.path($stateParams.tenantid+"/tax/freighttax/list");
         };
    });

     app.controller('freightTaxEditCtrl', function($scope, $rootScope, $http, $location, logger, $log, ngDialog, $modal, utilsService,$filter,sharedProperties,$state,$stateParams,$injector,validationService,toaster) {

         $scope.freightTax={
                 freightTaxCode:'',
                 vesselCode:'',
                 vesselName:'',
                 voyageNo:'',
                 portCode:'',
                 portName:'',               
                 portSequence:0,
                 tdsNatureType:'',
                 arrivalDate:'',
                 departureDate:'',
                 userId:'',
                 id:'',
                 text:'',
                 currencyCode:'',                 
                 exchangeRate:0.0,
                 prepaidAmtLocal:0.0,
                 prepaidAmtUsd:0.0,
                 payableAtDestAmtLocal:0.0,
                 payableAtDestAmtUsd:0.0,
                 collectedOnImportAmtLocal:0.0,
                 collectedOnImportAmtUsd:0.0,
                 thcAmtLocal:0.0,
                 thcAmtUsd:0.0,
                 haulageAmtLocal:0.0,
                 haulageAmtUsd:0.0,
                 bunkerAdjustAmtLocal:0.0,
                 bunkerAdjustAmtUsd:0.0,
                 totalAmtLocal:0.0,
                 totalAmtUsd:0.0,
                 incomePercOfGrosRate:0.0,
                 taxPayablePercRate:0.0,
                 surchargePercRate:0.0,
                 educationalCessPercRate:0.0,
                 taxPayablePercAmtLocal:0.0,
                 taxPayablePercAmtUsd:0.0,
                 incomePercOfGrosAmtLocal:0.0,
                 incomePercOfGrosAmtUsd:0.0,
                 surchargePercAmtLocal:0.0,
                 surchargePercAmtUsd:0.0,
                 educationalCessLocal:0.0,
                 educationalCessUsd:0.0,
                 grossTaxAmtLocal:0.0,
                 grossTaxAmtUsd:0.0,
                 netTaxPayableAmtLocal:0.0,
                 netTaxPayableAmtUsd:0.0,
                 advanceTaxPaidAmtLocal:0.0,
                 advanceTaxPaidAmtUsd:0.0,
                 finalTaxPaidAmtLocal:0.0,
                 finalTaxPaidAmtUsd:0.0,
                 refundAmtLocal:0.0,
                 refundAmtUsd:0.0             
             }
         $scope.tempDropDownObj={};
         $scope.isEdit=true;
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
             if($scope.freightTax.vesselCode==undefined || $scope.freightTax.vesselCode==null || $scope.freightTax.vesselCode==""){
                 msg+="vessel Name - This should be Required!!"
             }else if($scope.freightTax.voyageNo==undefined || $scope.freightTax.voyageNo==null || $scope.freightTax.voyageNo==""){
                 msg+="Voyage - This should be Required!!"
             }
             else if($scope.freightTax.portName==undefined || $scope.freightTax.portName==null || $scope.freightTax.portName==""){
                 msg+="Port - This should be Required!!"
             }
             else if($scope.freightTax.currencyCode==undefined || $scope.freightTax.currencyCode==null || $scope.freightTax.currencyCode==""){
                 msg+="Currency - This should be Required!!"
             }
             
             if(msg!=""){
                 logger.logError('Please correct the errors  <bar>'+ msg);
             }
             else{
             $scope.update();
             }
         };
         $scope.error = function(message) {
            // toaster.pop('error', "Please correct the errors", logger.getErrorHtml(sharedProperties.getErrorObject()), 555000, 'trustedHtml');
             logger.logError('Please correct the errors'+ logger.getErrorHtml(sharedProperties.getErrorObject()));
         };
         
              

         $scope.getDropDown = function() {          
             var url = $stateParams.tenantid+'/app/freighttax/getDropDown';
             $http.get(url).success(function(data) {
                 console.log(data);
                 if(data.success){
                     $scope.vesselList = data.vesselList;
                     $scope.currencyList = data.currencyList;
                 }
                 
             });
         };
         $scope.getDropDown ();
         $scope.$watch('freightTax.vendorCode', function(newValue, oldValue) {          
             $scope.tdsNatureList=[];
             $scope.freightTax.tdsNatureCode='';
                  if(newValue != ''){              
                      $scope.getTdsNature($scope.freightTax.vendorCode);
                  }
              });
         
         
         $scope.getVoyage = function(vesselId) {     
                $http.post($stateParams.tenantid+'/app/freighttax/getVoyage', vesselId).success(function(data) {
                    console.log("voyage");
                    console.log(data);
                    $scope.voyageList = data;
                }).error(function(data) {
                });

            };
           
            $scope.$watch('freightTax.vesselCode', function(newValue, oldValue) {          
                console.log("vessel code11");
                console.log($scope.freightTax.vesselCode);
                $scope.voyageList = [];
                if(newValue != ''){                   
                    $scope.getVoyage($scope.freightTax.vesselCode);
                }
            });
            
            $scope.$watch('freightTax.voyageNo', function(newValue, oldValue) {          
                $scope.portList = [];
                if(newValue != ''){
                    $scope.getPort($scope.freightTax.voyageNo,$scope.freightTax.portName);
                }
            });
                       
         
            $scope.getPort = function(voyageNo,portName) {
                $http.post($stateParams.tenantid+'/app/freighttax/port', voyageNo).success(function(data) {
                    console.log('port');
                    console.log(data);
                    $scope.portList = data;
                    $scope.freightTax.portName=portName;
                }).error(function(data) {
                });

            };
            
            
            
            $scope.$watch('freightTax.portName', function(newValue, oldValue) {          
                  if(newValue != ''){
                      $scope.getVesselDate($scope.freightTax.portName);
                  }
              });
            
            
            $scope.getVesselDate = function(port) {
                if(port!=undefined && port!=null && port!=""){
                    var portArr=port.split("-");
                    $scope.freightTax.portSequence=portArr[0];
                    $scope.freightTax.portCode=portArr[1];
                    $http.post($stateParams.tenantid+'/app/freighttax/getVesselDate', $scope.freightTax).success(function(data) {
                        console.log('get vessel date');
                        console.log(data);
                        $scope.freightTax.arrivalDate=data.arrivalDate;
                        $scope.freightTax.departureDate=data.departureDate;
                    }).error(function(data) {
                    });
  
                }
                
            };
         
         $scope.getTdsNature = function(vendorCode) {
             var url = $stateParams.tenantid+'/app/freighttax/getTdsNature?vendorCode='+vendorCode;
             $http.get(url).success(function(data) {
                 console.log(data);
                 if(data.success){
                     $scope.tdsNatureList = data.tdsNatureList;
                 }
             });
         };
         $scope.$watch('freightTax.currencyCode', function(newValue, oldValue) {          
              console.log("currency watch");
              console.log($scope.tempDropDownObj);
               if(newValue != ''){
                   if($scope.tempDropDownObj.exchangeRate!=undefined){
                       $scope.freightTax.exchangeRate=$scope.tempDropDownObj.exchangeRate;  
                       $scope.calculatingTotal();
                       }
               }
           });
         
       
      /*   $scope.$watch('freightTax.tdsNatureCode', function(newValue, oldValue) {          
             console.log("tdsNatureCode watch");
              if(newValue != ''){
                  $scope.getTdsNatureData($scope.freightTax.vendorCode,$scope.freightTax.tdsNatureCode);
              }
          });*/
         
        
         $scope.edit = function() {
             console.log("edit");
                 $http.get($stateParams.tenantid+'/app/freighttax/edit?freightTaxCode='+$stateParams.freightTaxCode).success(function(result) {
                     $scope.freightTax=result;
                     console.log(result);
                     $scope.calculatingTotal();
                 }).error(function(result) {
                     console.log("data" + result);
                 });
         };
         $scope.edit();
         
         $scope.update = function(vendorNatureForm) {
             if (new validationService().checkFormValidity(vendorNatureForm)) {
                 $http.post($stateParams.tenantid+'/app/freighttax/update', $scope.freightTax).success(function(result) {
                     if(result.success) {
                         logger.logSuccess("Update successfully!");
                         $location.path($stateParams.tenantid+'/tax/freighttax/list');
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
             $location.path($stateParams.tenantid+"/tax/freighttax/list");
         };
         
         

         $scope.calculatingTotal=function (){
             console.log(isNaN($scope.freightTax.prepaidAmtLocal));
             if((isNaN($scope.freightTax.prepaidAmtLocal)) || $scope.freightTax.prepaidAmtLocal==""){
                 $scope.freightTax.prepaidAmtLocal=0;
             }
             if((isNaN($scope.freightTax.payableAtDestAmtLocal)) || $scope.freightTax.payableAtDestAmtLocal==""){
                 $scope.freightTax.payableAtDestAmtLocal=0;
             }
             if((isNaN($scope.freightTax.collectedOnImportAmtLocal)) || $scope.freightTax.collectedOnImportAmtLocal==""){
                 $scope.freightTax.collectedOnImportAmtLocal=0;
             }
             if((isNaN($scope.freightTax.thcAmtLocal)) || $scope.freightTax.thcAmtLocal==""){
                 $scope.freightTax.thcAmtLocal=0;
             }
             if((isNaN($scope.freightTax.haulageAmtLocal)) || $scope.freightTax.haulageAmtLocal==""){
                 $scope.freightTax.haulageAmtLocal=0;
             }
             if((isNaN($scope.freightTax.bunkerAdjustAmtLocal)) || $scope.freightTax.bunkerAdjustAmtLocal==""){
                 $scope.freightTax.bunkerAdjustAmtLocal=0;
             }
              var localtotal = ( parseFloat($scope.freightTax.prepaidAmtLocal) )+ 
              (parseFloat($scope.freightTax.payableAtDestAmtLocal)) + (parseFloat($scope.freightTax.collectedOnImportAmtLocal)) + 
              (parseFloat($scope.freightTax.thcAmtLocal)) + (parseFloat($scope.freightTax.haulageAmtLocal)) + 
              (parseFloat($scope.freightTax.bunkerAdjustAmtLocal));
              $scope.freightTax.totalAmtLocal = (localtotal).toFixed(2);
             

              if(isNaN($scope.freightTax.incomePercOfGrosRate) || $scope.freightTax.incomePercOfGrosRate=="" ){
                  $scope.freightTax.incomePercOfGrosRate=0;
          }

                 var incomeLocal=(parseFloat($scope.freightTax.totalAmtLocal)* 
                 (parseFloat($scope.freightTax.incomePercOfGrosRate)/100));
                 $scope.freightTax.incomePercOfGrosAmtLocal=(incomeLocal).toFixed(2);
                 
                 if(isNaN($scope.freightTax.taxPayablePercRate) || $scope.freightTax.taxPayablePercRate=="" ){
                     $scope.freightTax.taxPayablePercRate=0;
                 }
                
                 var taxLocal=(parseFloat($scope.freightTax.incomePercOfGrosAmtLocal)* 
                 (parseFloat($scope.freightTax.taxPayablePercRate)/100));
                 $scope.freightTax.taxPayablePercAmtLocal=(taxLocal).toFixed(2);


                 if(isNaN($scope.freightTax.surchargePercRate) || $scope.freightTax.taxPayablePercRate==""){
                     $scope.freightTax.surchargePercRate=0;
                 }
             var surlocal = (parseFloat($scope.freightTax.taxPayablePercAmtLocal) * 
             (parseFloat($scope.freightTax.surchargePercRate) / 100));
             $scope.freightTax.surchargePercAmtLocal = (surlocal).toFixed(2);
             
             if(isNaN($scope.freightTax.educationalCessPercRate) || $scope.freightTax.educationalCessPercRate==""){
                 $scope.freightTax.educationalCessPercRate=0;
             }
             
             var edulocal = (((parseFloat($scope.freightTax.taxPayablePercAmtLocal)) + 
                 (parseFloat($scope.freightTax.surchargePercAmtLocal))) * 
             (parseFloat($scope.freightTax.educationalCessPercRate) / 100));
             $scope.freightTax.educationalCessLocal = (edulocal).toFixed(2);

              var localgross =  (parseFloat($scope.freightTax.taxPayablePercAmtLocal)) + 
              (parseFloat($scope.freightTax.surchargePercAmtLocal)) + (parseFloat($scope.freightTax.educationalCessLocal));
              $scope.freightTax.grossTaxAmtLocal = (localgross).toFixed(2);
              
              $scope.freightTax.netTaxPayableAmtLocal = $scope.freightTax.grossTaxAmtLocal;
              if(isNaN($scope.freightTax.advanceTaxPaidAmtLocal) || $scope.freightTax.advanceTaxPaidAmtLocal==""){
                  $scope.freightTax.advanceTaxPaidAmtLocal=0;
              }
             var finallocal = (parseFloat($scope.freightTax.netTaxPayableAmtLocal)) - 
             (parseFloat($scope.freightTax.advanceTaxPaidAmtLocal));
             $scope.freightTax.finalTaxPaidAmtLocal = (finallocal).toFixed(2);
             
             if((parseFloat($scope.freightTax.advanceTaxPaidAmtLocal)) > (parseFloat($scope.freightTax.netTaxPayableAmtLocal))){
                 var refundlocal = (parseFloat($scope.freightTax.advanceTaxPaidAmtLocal)) - 
             (parseFloat($scope.freightTax.netTaxPayableAmtLocal));
             $scope.freightTax.refundAmtLocal = (refundlocal).toFixed(2);
             }else{
                 $scope.freightTax.refundAmtLocal = 0;
             } 
             
             $scope.calculatingUSD();
         }


         $scope.calculatingUSD=function(){
                 //fraction=document.forms[0].ex_rate.value;
                 //if (fdecimal("amount",parseInt(18)-parseInt(fraction),fraction,"Amount")==false) return false;

                 var ex_rate,AmountUsd;

               
                 ex_rate=$scope.freightTax.exchangeRate;
                 //USDFraction=document.getElementById("cashBankPaymentAddList[" + i + "].rate0").value;
                 if (ex_rate>0) // && parseFloat(document.getElementById("cashBankPaymentAddList[" + i + "].amount0").value) >0)
                 {
                     if(!isNaN($scope.freightTax.prepaidAmtLocal) && $scope.freightTax.prepaidAmtLocal!=""){
                     $scope.freightTax.prepaidAmtUsd = (parseFloat($scope.freightTax.prepaidAmtLocal) / parseFloat(ex_rate)).toFixed(2);
                     }else{
                         $scope.freightTax.prepaidAmtUsd = 0;
                     }
                     
                     if(!isNaN($scope.freightTax.payableAtDestAmtLocal) && $scope.freightTax.payableAtDestAmtLocal!=""){
                     $scope.freightTax.payableAtDestAmtUsd = (parseFloat($scope.freightTax.payableAtDestAmtLocal) / parseFloat(ex_rate)).toFixed(2);
                     }else{
                         $scope.freightTax.payableAtDestAmtUsd = 0;
                     }
                     
             
                     if(!isNaN($scope.freightTax.collectedOnImportAmtLocal)  && $scope.freightTax.collectedOnImportAmtLocal!=""){
                     $scope.freightTax.collectedOnImportAmtUsd = (parseFloat($scope.freightTax.collectedOnImportAmtLocal) / parseFloat(ex_rate)).toFixed(2);
                     }else{
                         $scope.freightTax.collectedOnImportAmtUsd = 0;
                     }
                     
                     if(!isNaN($scope.freightTax.thcAmtLocal)  && $scope.freightTax.thcAmtLocal!=""){
                     $scope.freightTax.thcAmtUsd = (parseFloat($scope.freightTax.thcAmtLocal) / parseFloat(ex_rate)).toFixed(2);
                     }
                     else{
                         $scope.freightTax.thcAmtUsd = 0;
                     }
                     if(!isNaN($scope.freightTax.haulageAmtLocal)  && $scope.freightTax.haulageAmtLocal!=""){
                     $scope.freightTax.haulageAmtUsd = (parseFloat($scope.freightTax.haulageAmtLocal) / parseFloat(ex_rate)).toFixed(2);
                     }else{
                         $scope.freightTax.haulageAmtUsd = 0;
                     }
                     
                     if(!isNaN($scope.freightTax.bunkerAdjustAmtLocal)  && $scope.freightTax.bunkerAdjustAmtLocal!=""){
                     $scope.freightTax.bunkerAdjustAmtUsd = (parseFloat($scope.freightTax.bunkerAdjustAmtLocal) / parseFloat(ex_rate)).toFixed(2);
                     }else{
                         $scope.freightTax.bunkerAdjustAmtUsd = 0;
                     }
                 //  document.forms[0].tdsVendorAmtLocal.value = parseFloat(document.forms[0].tdsCreditAmtLocal.value)- parseFloat(document.forms[0].tdsNetAmtLocal.value));
             //      document.forms[0].tdsVendorAmtUsd.value = parseFloat(document.forms[0].tdsCreditAmtUsd.value)- parseFloat(document.forms[0].tdsNetAmtUsd.value));

                      var usdtotal =  (parseFloat($scope.freightTax.prepaidAmtUsd)) + 
                      (parseFloat($scope.freightTax.payableAtDestAmtUsd)) + (parseFloat($scope.freightTax.collectedOnImportAmtUsd)) + 
                      (parseFloat($scope.freightTax.thcAmtUsd)) + (parseFloat($scope.freightTax.haulageAmtUsd)) + 
                      (parseFloat($scope.freightTax.bunkerAdjustAmtUsd));
                      $scope.freightTax.totalAmtUsd= (usdtotal).toFixed(2);;
                         
                         
                     
                     if(!isNaN($scope.freightTax.incomePercOfGrosAmtLocal)  && $scope.freightTax.incomePercOfGrosAmtLocal!=""){
                     $scope.freightTax.incomePercOfGrosAmtUsd = (parseFloat($scope.freightTax.incomePercOfGrosAmtLocal) / parseFloat(ex_rate)).toFixed(2);
                     }else{
                         $scope.freightTax.incomePercOfGrosAmtUsd=0;
                     }

                     if(!isNaN($scope.freightTax.taxPayablePercAmtLocal)  && $scope.freightTax.taxPayablePercAmtLocal!=""){
                     $scope.freightTax.taxPayablePercAmtUsd = (parseFloat($scope.freightTax.taxPayablePercAmtLocal) / parseFloat(ex_rate)).toFixed(2);
                     }
                     else{
                         $scope.freightTax.taxPayablePercAmtUsd=0;
                     }
                     if(!isNaN($scope.freightTax.surchargePercAmtLocal)  && $scope.freightTax.surchargePercAmtLocal!=""){
                     $scope.freightTax.surchargePercAmtUsd = (parseFloat($scope.freightTax.surchargePercAmtLocal) / parseFloat(ex_rate)).toFixed(2);
                     }else{
                         $scope.freightTax.surchargePercAmtUsd=0;
                     }
                     if(!isNaN($scope.freightTax.educationalCessLocal)  && $scope.freightTax.educationalCessLocal!=""){
                     $scope.freightTax.educationalCessUsd = (parseFloat($scope.freightTax.educationalCessLocal) / parseFloat(ex_rate)).toFixed(2);
                     }else{
                         $scope.freightTax.educationalCessUsd=0;
                     }

                      var usdgross =  (parseFloat($scope.freightTax.taxPayablePercAmtUsd)) + 
                      (parseFloat($scope.freightTax.surchargePercAmtUsd)) + (parseFloat($scope.freightTax.educationalCessUsd));
                      $scope.freightTax.grossTaxAmtUsd= (usdgross).toFixed(2);;
                     
                     $scope.freightTax.netTaxPayableAmtUsd = (parseFloat($scope.freightTax.netTaxPayableAmtLocal) / parseFloat(ex_rate)).toFixed(2);     
                     
                     if(!isNaN($scope.freightTax.advanceTaxPaidAmtLocal)  && $scope.freightTax.advanceTaxPaidAmtLocal!=""){
                     $scope.freightTax.advanceTaxPaidAmtUsd = (parseFloat($scope.freightTax.advanceTaxPaidAmtLocal) / parseFloat(ex_rate)).toFixed(2);
                     }else{
                         $scope.freightTax.advanceTaxPaidAmtUsd=0;
                     }

                     if(!isNaN($scope.freightTax.finalTaxPaidAmtLocal)  && $scope.freightTax.finalTaxPaidAmtLocal!=""){
                     $scope.freightTax.finalTaxPaidAmtUsd= (parseFloat($scope.freightTax.finalTaxPaidAmtLocal) / parseFloat(ex_rate)).toFixed(2);
                     }else{
                         $scope.freightTax.finalTaxPaidAmtUsd=0;
                     }
                     
                     $scope.freightTax.refundAmtUsd = (parseFloat($scope.freightTax.refundAmtLocal) / parseFloat(ex_rate)).toFixed(2);
                 }
                 else
                 {
                     $scope.freightTax.prepaidAmtUsd=0;
                     $scope.freightTax.payableAtDestAmtUsd=0;
                     $scope.freightTax.collectedOnImportAmtUsd=0;
                     $scope.freightTax.thcAmtUsd=0;
                     $scope.freightTax.haulageAmtUsd=0;
                     $scope.freightTax.bunkerAdjustAmtUsd=0;
                     $scope.freightTax.incomePercOfGrosAmtUsd=0;
                     $scope.freightTax.taxPayablePercAmtUsd = 0;
                     $scope.freightTax.surchargePercAmtUsd = 0;
                     $scope.freightTax.educationalCessUsd = 0;
                 }
                 //totalCalculation();
         }
    });



