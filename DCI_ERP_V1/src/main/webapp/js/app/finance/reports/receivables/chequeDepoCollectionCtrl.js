app.controller('ChequeDepoCollectionCtrl', function($scope, $rootScope, 
            $http, logger, $log, ngDialog, $modal, $window,$location,$filter,$timeout,$stateParams) {
    $scope.rowCollection = [];
    $scope.companyCode=[];
    $scope.payerCode =[];
    $scope.customerType=[];
    $scope.paymentCenter=[];
    $scope.service=[];
    
    $scope.chequeDepoObjs ={
            companyCode :'',
            companyCodes:'',
            payerCode:'',
            mlo : '',
            fromDate :'',
            toDate :'',
            payerName:'',
            customerType:'',
            service:'',
            paymentCenter:'',
            customerTypes:'',
            paymentCenters:'',
            payerCodes:'',
            services:'',
            
    };
    
    $scope.chequeDepoObj={
            companyCode :'',
            companyCodes:'',
            payerCode:'',
            mlo : '',
            fromDate :'',
            toDate :'',
            payerName:'',
            customerType:'',
            service:'',
            paymentCenter:'',
            customerTypes:'',
            paymentCenters:'',
            payerCodes:'',
            services:'',
            countryCode : ''
            
    };
    
    $('#cdcFromDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime: false
    });
    $('#cdcToDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime: false
    });
    $("#cdcFromDate").on("dp.change", function(e) {
        $scope.chequeDepoObj.fromDate=$("#txtFromDate").val();
    });
    $("cdcToDate").on("dp.change", function(e) {
        $scope.chequeDepoObj.toDate=$("#txtToDate").val();
    });
    
    $http.get($stateParams.tenantid+'/app/commonUtility/getCountryList').success(function(datas) {
        $scope.countryList = datas;
    });
    
    $scope.sendSOA=function(reportObj){
        debugger;
        $scope.chequeDepoObjs = reportObj;
        $scope.chequeDepoObjs.companyCodes=$scope.chequeDepoObj.companyCodes;
       if($scope.chequeDepoObjs.companyCodes !='' && $scope.chequeDepoObjs.payerCode != '')
       {
          $http.post($stateParams.tenantid+'/app/chqDepsit/sendCheque', $scope.chequeDepoObjs).success(function(data) {
                if(data.success){
                    logger.logSuccess("Mail sent successfully!");
                }else{
                    logger.logError("Mail not Sent"); 
                }
                    
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        }else{
            logger.logError("Please select company and payer!..");
        }
     };
     $scope.chequeview ;
     //new
     $scope.preview=function(reportObj){
        debugger;
        $scope.chequeDepoObjs = reportObj;
        $scope.chequeDepoObjs.companyCodes=$scope.chequeDepoObj.companyCodes;
        console.log("prevew")
        console.log( $scope.chequeDepoObjs)
       if($scope.chequeDepoObjs.companyCodes !='' && $scope.chequeDepoObjs.payerCode != '')
       {
           $http.post($stateParams.tenantid+'/app/chqDepsit/preview', $scope.chequeDepoObjs).success(function(data) {    
                  $scope.chequeview = data.som;
                  console.log("data preview")
             console.log($scope.chequeview)  
                 ngDialog.openConfirm({template : 'chequeview' ,  preCloseCallback : 'preCloseCallbackOnScope',
                     scope : $scope}).then(function() {
                   
                 });
             
           }).error(function(data) {
               logger.logError("Error Please Try Again");
           });
       }else{
           logger.logError("Please select company and payer!..");
       }
           /*$state.go('app.finance.transaction.presentation.justview');*/
         
        }
     
   //new
    $scope.getDropdownList = function(){
        
        $http.get($stateParams.tenantid+'/app/usermaster/getCompanyList?formCode='+$('#form_code_id').val()).success(function(data) {
            console.log("data")
            console.log(data)
            $scope.companyList = data;
       

            $timeout(function() {
                
                $("#txtCompanyCode").multiselect({
                    maxHeight: 400,
                    includeSelectAllOption: true,
                    selectAllText: 'Select All',
                    enableFiltering: true,
                    enableCaseInsensitiveFiltering: true,
                    filterPlaceholder: 'Search',
                    onChange: function(element, checked) {
                      var companyCodes = "", jvpShortNames="";
                      if($scope.companyCode.length>0){
                          angular.forEach($scope.companyCode, function (item, key) {
                              if($scope.companyCode.length>0){
                                  if($scope.companyCode[key]!=undefined){
                                      
                                      var companyCode = item.id;
                                      
                                      if(companyCodes==""){
                                          companyCodes = item.id;
                                      }else{
                                          companyCodes +=","+ item.id;
                                      }       
                                      $scope.chequeDepoObj.companyCodes = companyCodes;
                                  }                             
                              }                              
                          });
                      }else{
                          $scope.chequeDepoObj.companyCodes = '';
                      }
                      console.log( $scope.chequeDepoObj.companyCodes );
                    }
                  });
                
                $("#multiselect-button").addClass("width_100 input-sm line-height-5");
                
                }, 2, false);
        }).error(function(data) {
        });
        //customer Type
        $scope.creditCategorylist =[{id:'C',text:'CREDIT',customerType:'CREDIT'},{id:'D',text:'DEPOSIT CHEQUE' , customerType :'DEPOSIT CHEQUE'},
                                    {id:'P',text:'PRIOR LOADING',customerType : 'PRIOR LOADING' }];


      $timeout(function() {

            $("#txtCustomerType").multiselect({
                maxHeight: 400,
                includeSelectAllOption: true,
                selectAllText: 'Select All',
                enableFiltering: true,
                enableCaseInsensitiveFiltering: true,
                filterPlaceholder: 'Search',
             
              });   
                 
         
            $('#txtCustomerType').multiselect('deselectAll', false);
            $('#txtCustomerType').multiselect('updateButtonText');
            $("#txtCustomerType").multiselect('rebuild');
            
            var arr=[];
            arr.push("string:D");
            $('#txtCustomerType').multiselect('select',arr);
            debugger;
            $scope.chequeDepoObj.customerTypes = 'D';
            }, 2, false);
        
        $http.get($stateParams.tenantid+'/app/receivable/getPaymentCentreList').success(function(data) {
            $scope.paymentList = data;           
            $timeout(function() {
                
                $("#txtpaymentCenter").multiselect({
                    maxHeight: 400,
                    includeSelectAllOption: true,
                    selectAllText: 'Select All',
                    enableFiltering: true,
                    enableCaseInsensitiveFiltering: true,
                    filterPlaceholder: 'Search',
                    onChange: function(element, checked) {

                      var paymentCenters = "", jvpShortNames="";
                      if($scope.paymentCenter.length>0){
                          angular.forEach($scope.paymentCenter, function (item, key) {
              
                              if($scope.paymentCenter.length>0){
                             
                                  if($scope.paymentCenter[key]!=undefined){
                                      
                                      var paymentCenter = item.id;
                                      
                                      if(paymentCenters==""){
                                          paymentCenters = item.id;
                                      }else{
                                          paymentCenters +=","+ item.id;
                                      }       
                                      $scope.chequeDepoObj.paymentCenters = paymentCenters;
                                  }                             
                              }                              
                          });
                      }else{
                          $scope.chequeDepoObj.paymentCenters = '';
                      }
                      console.log( $scope.chequeDepoObj.paymentCenters );
                    }
                  });
                
                $("#multiselect-button").addClass("width_100 input-sm line-height-5");
                
                }, 2, false);
       
        }).error(function(data) {
        });

        
        $("#txtservice").multiselect({
            maxHeight: 400,
            includeSelectAllOption: true,
            selectAllText: 'Select All',
            enableFiltering: true,
            enableCaseInsensitiveFiltering: true,
            filterPlaceholder: 'Search',
            onChange: function(element, checked) {

              var services = "", jvpShortNames="";
              if($scope.service.length>0){
                  angular.forEach($scope.service, function (item, key) {
           
                      if($scope.service.length>0){

                          if($scope.service[key]!=undefined){
                              
                              var service = item.id;
                              
                              if(services==""){
                                  services = item.id;
                              }else{
                                  services +=","+ item.id;
                              }       
                              $scope.chequeDepoObj.services = services;
                          }                             
                      }                              
                  });
              }else{
                  $scope.chequeDepoObj.services = '';
              }
              console.log( $scope.chequeDepoObj.services );
            }
          });
        
        $("#multiselect-button").addClass("width_100 input-sm line-height-5");
        
        
        //service
        $http.get($stateParams.tenantid+'/app/agencyTariff/service').success(function(datas) {
            $scope.serviceList = datas.serviceList;
            $timeout(function() {
                $('#txtservice').multiselect('deselectAll', false);
                $('#txtservice').multiselect('updateButtonText');
                $("#txtservice").multiselect('rebuild');
            
            }, 2, false);
        }).error(function(data) {
        });

        
        $("#txtpayerCode").multiselect({
            maxHeight: 400,
            includeSelectAllOption: true,
            selectAllText: 'Select All',
            enableFiltering: true,
            enableCaseInsensitiveFiltering: true,
            filterPlaceholder: 'Search',
            onChange: function(element, checked) {
   
              var payerCodes = "", jvpShortNames="";
              if($scope.payerCode.length>0){
                  angular.forEach($scope.payerCode, function (item, key) {
   
                      if($scope.payerCode.length>0){
           
                          if($scope.payerCode[key]!=undefined){
                              
                              var payerCode = item.id;
                              
                              if(payerCodes==""){
                                  payerCodes = item.id;
                              }else{
                                  payerCodes +=","+ item.id;
                              }       
                              $scope.chequeDepoObj.payerCodes = payerCodes;
                          }                             
                      }                              
                  });
              }else{
                  $scope.chequeDepoObj.payerCodes = '';
              }
              console.log( $scope.chequeDepoObj.payerCodes );
            }
          });
        
        $("#multiselect-button").addClass("width_100 input-sm line-height-5");
        
        
        
        $http.get($stateParams.tenantid+'/app/commonUtility/getSubAccountCodeListTradeDebtorsCR').success(function(datas) {
            $scope.payerList = [];
            $scope.payerList = datas;
            $timeout(function() {
                $('#txtpayerCode').multiselect('deselectAll', false);
                $('#txtpayerCode').multiselect('updateButtonText');
                $("#txtpayerCode").multiselect('rebuild');
            
            }, 2, false);
            }).error(function(datas) {
        });
    }
    $scope.getDropdownList(); 
    
    
    $scope.viewChqDepoCollReport = function(){
        console.log("send object")
        console.log($scope.chequeDepoObj);
        $scope.isConsolidated =false;
        
      
        if($scope.customerType.length>0){
            $scope.chequeDepoObj.customerTypes='';
            $scope.chequeDepoObj.customerTypes=$scope.customerType.join();
        }
        
  if( $scope.chequeDepoObj.companyCodes !=''){
            $http.post($stateParams.tenantid+'/app/chqDepsit/getChqDepoCollReport', $scope.chequeDepoObj).success(function(data) {
                if(data.success){
                    debugger;
                    $scope.rowCollection = data.lChqDepoReportList;
                    console.log("pdcamount")
                    console.log(data.lChqDepoReportList)
                }else{
                    $scope.rowCollection = [];
                }
                
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
       }else{
                logger.logError("Please select Company");
        }
    };
    
    $scope.exportChqDepoCollExcel=function(){
        debugger;
        if( $scope.chequeDepoObj.companyCodes !=''){
            $http.post($stateParams.tenantid+'/app/chqDepsit/exportChqDepoCollReport',$scope.chequeDepoObj).success(function(data) {
                if(data){
                    debugger;
                    $("#ChqDepoCollecExport").bind('click', function() {
                    });
                    $('#ChqDepoCollecExport').simulateClick('click');
                    logger.logSuccess("Exported successfully!");
                }else{
                    logger.logSuccess("Failed to export");
                }
                
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        }
            else{
                logger.logError("Please select Company");
        }
        

    }
    
    $scope.returnEmptyForUndefined=function(value){
        if(value==undefined)
            value="";
        
        return value;
    }
    
    $.fn.simulateClick = function() {
        return this.each(function() {
            if ('createEvent' in document) {
                var doc = this.ownerDocument, evt = doc.createEvent('MouseEvents');
                evt.initMouseEvent('click', true, true, doc.defaultView, 1, 0, 0, 0, 0, false, false, false, false, 0, null);
                this.dispatchEvent(evt);
            } else {
                this.click(); // IE
            }
        });
    }
    
    
 /*   app.finance.reports.receivable.chequeDepositCollection.view*/
});

/*app.controller('chequeDepoCollectionPreviewCtrl', function($scope, $rootScope, 
        $http, logger, $log, ngDialog, $modal, $window,$location,$filter,$timeout) {

console.log("Preview Page")

});*/