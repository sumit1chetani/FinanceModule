'use strict';
app.controller('lpoAddCtrl', function($scope, $rootScope,sharedProperties, logger,$http,$filter, $location,
        $stateParams, validationService, toaster, $window, $timeout) {
        $scope.lpoData = {
               lpoNo :'',
               lpoDate :'',
             //  partyInvoiceNo :'',
               currency :'',
               description :'',
               supplier :'',
             //  partyInvoiceDate :'',
               exchangeRate:'',
               bcAmount:'',
             //  purchaseOrderNo :'',
             //  dueDate :'',
               company :'',
               tcAmount:'',
               lpoDetail : [],
               pOList:[],
               subAccountCodeList:[]
        };
        $scope.accountListData=[];
        $scope.subAccountListData=[];
        $scope.companyList = [];
        $scope.supplierList = [];
        $scope.purchaseOrderList = [];
        $scope.currencyList =[];
        $scope.supplierCur = [];
        $scope.purchaseCur = [];
        $scope.isEdit =false;
        $scope.isOnChange=false;
        
        // code added for attribute listing
        $scope.voyageList =[];
        $scope.vesselList =[];
        $scope.sectorList = [];
        $scope.employeeList = [];
        $scope.portList = [];
        $scope.departmentList = [];
        $scope.agentList = [];
        $scope.countryList =[];
        $scope.customerList = [];
        $scope.companyList = [];
        $scope.designationList = [];
       
        $scope.currentURL=$location.protocol() + '://'+ $location.host() +':'+  $location.port()+"/#" +$location.path();
        
        if(window.localStorage.getItem('lpo')==$scope.currentURL){
            alert('window ' + $scope.currentURL + ' is already opened');
           // window.focus();
            setTimeout(window.close(),1000);
            //localStorage.removeItem('lpo');
           // window.close();
            
        }else{
            window.localStorage.setItem('lpo', $scope.currentURL);
        }  
        $(window).unload(function(){
           // debugger;
          // alert("INSIDE UNLOAD")
             localStorage.removeItem('lpo');
           });
        $('#pi_date').datetimepicker({
            format : 'DD/MM/YYYY',
            pickTime: false
        });
        $('#party_date').datetimepicker({
            format : 'DD/MM/YYYY',
            pickTime: false
        });
         $('#du_date').datetimepicker({
            format : 'DD/MM/YYYY',
            pickTime: false
        });

        var today = new Date();
        var dd = today.getDate();
        var mm = today.getMonth() + 1;

        var yyyy = today.getFullYear();
        if (dd < 10) {
            dd = '0' + dd;
        }
        if (mm < 10) {
            mm = '0' + mm;
        }
        var today = dd + '/' + mm + '/' + yyyy;
        $scope.lpoData.lpoDate = today;
        $scope.checkDatesCL = function(lpoDate){
            var res = $scope.lpoData.lpoDate.split("/");
            $http.get($stateParams.tenantid+'/app/cashbankreceipt/getloggedcompany?closingDate='+$scope.lpoData.lpoDate).success(function(datas) {
                if(datas){
                    logger.logError("Account closed for year "+ res[2]);
                    $scope.lpoData.lpoDate = today;
                }
            })
        }
        
        /**
         * LPO Detail Table
         */

        $scope.loadTable = function() {
              var table = {};
              table = {
                  siNo: 1,
                  subGrpCode :'',
                  accountHeadCode : '',
                  subAccountCode:'',
                  shortDetail : '',
                  currency : '',
                  exchangeRate : '',
                  bcAmount : '',
                  tcAmount : '',
                  voyageCode : '',
                  vesselCode : '',
                  sectorCode : '',
                  employeeCode :'',
                  portCode :'',
                  portSequence :'',
                  departmentCode :'',
                  agentCode :'',
                  countryCode :'',
                  customerCode:'',
                  supplierCode:'',
                  designationCode:'',
                  costCenter :'',
                  companyCode:'',
                  quantityGO:'',
                  quantityFO:'',
                  assetCode:'',
                  isVoyage :false,
                  isVessel :false,
                  isService:false,
                  isEmployee:false,
                  isPort:false,
                  isDepartment:false,
                  isAgent:false,
                  isLocation:false,
                  isCustomer:false,
                  isSupplier:false,
                  isDesignation:false,
                  isCostCenter:false,
                  isCompany:false,
                  isQuantityGO:false,
                  isQuantityFO:false,
                  isPortSequence:false,
                  isSubAccountCode:false,
                  attributeList :[],
                  subAccountCodeList:[]
               };

              $scope.lpoData.lpoDetail.push(table);
              
          }

         $scope.loadTable();

         /**
          * LPO Detail Table - add Row
          */
         $scope.addRow = function(lpoDetail) {
              var len = lpoDetail.length;
              var table = {
                      siNo: 1,
                      subGrpCode :'',
                      accountHeadCode : '',
                      subAccountCode:'',
                      shortDetail : '',
                      currency : '',
                      exchangeRate : '',
                      bcAmount : '',
                      tcAmount : '',
                      voyageCode : '',
                      vesselCode : '',
                      sectorCode : '',
                      employeeCode :'',
                      portCode :'',
                      portSequence :'',
                      departmentCode :'',
                      agentCode :'',
                      countryCode :'',
                      customerCode:'',
                      supplierCode:'',
                      designationCode:'',
                      costCenter :'',
                      companyCode:'',
                      quantityGO:'',
                      quantityFO:'',
                      assetCode:'',
                      isVoyage :false,
                      isVessel :false,
                      isService:false,
                      isEmployee:false,
                      isPort:false,
                      isDepartment:false,
                      isAgent:false,
                      isLocation:false,
                      isCustomer:false,
                      isSupplier:false,
                      isDesignation:false,
                      isCostCenter:false,
                      isCompany:false,
                      isQuantityGO:false,
                      isQuantityFO:false,
                      isPortSequence:false,
                      isSubAccountCode:false,
                      attributeList :[],
                      subAccountCodeList:[]
                   };
              table.siNo = len+1;
              lpoDetail.push(table);
              
          };

          /**
           * LPO Detail Table - remove Row
           */
          $scope.removeRow = function(lpoDetail) {
              $scope.tablerow = [];
              angular.forEach(lpoDetail, function(row, index) {
                  var check = row.select;
                
                  if (check == undefined || check == "") {
                      $scope.tablerow.push(row);
                  } else {

                  }
              });
              $scope.lpoData.lpoDetail = $scope.tablerow;

          };

        $scope.cancel = function() {
              $location.path($stateParams.tenantid+"/invoice/lpo/LPOList");
        };


      /*  $scope.$watch('lpoData.supplier', function(newValue, oldValue) {
             ;
            if (newValue != '' && newValue != undefined) {
                $http.post('app/invoice/lpo/getSupplierCur', newValue).success(function(datas) {
                    $scope.supplierCur = datas;
                    $scope.lpoData.currency = $scope.supplierCur[0].currency;
                    $http.get('app/commonUtility/getExchangeRate?currencyCode='+$scope.lpoData.currency).success(function(data) {
                         ;
                        $scope.lpoData.exchangeRate=data;
                    }).error(function(data) {
                    });
                }).error(function(datas) {
                    logger.logError("Error Please Try Again");
                });
            }else{
                $scope.supplierCur = [];
                $scope.lpoData.currency = '';
                $scope.lpoData.exchangeRate = '';
            }
       });
        */
        
        
  $scope.isFeederCompanyCurrency=false;
        
        $scope.currencyObj = {fromCurrency:0, toCurrency:0,exchangeRate:0.0}
        
        $scope.$watch('lpoData.supplier', function(newValue, oldValue) {
             ;
            if(!$scope.edit){
                if (newValue != '' && newValue != undefined) {
                    $http.post($stateParams.tenantid+'/app/purchaseinvoice/getSupplierCur', newValue).success(function(datas) {
                         ;
                        $scope.supplierCur = datas;
                        $scope.lpoData.currency = $scope.supplierCur[0].currency;
                        $scope.lpoData.exchangeRate=$scope.supplierCur[0].exchangeRate;
                        $scope.lpoData.fromCurrency=$scope.supplierCur[0].fromCurrency;
                        $scope.lpoData.toCurrency=$scope.supplierCur[0].toCurrency;
                        
                        if($scope.supplierCur[0].isAgent != 'N' && $scope.supplierCur[0].isAgent != '' && $scope.supplierCur[0].isAgent != undefined && $scope.supplierCur[0].isAgent == 'Y')
                            $scope.isCurrencyBlocked=true;
                        else
                            $scope.isCurrencyBlocked=false;
                        
                        if($scope.lpoData.exchangeRate >= $scope.currencyObj.fromCurrency && 
                                $scope.lpoData.exchangeRate <= $scope.currencyObj.toCurrency){
                            logger.logError("Please Enter Exchange Rate Between "+$scope.currencyObj.fromCurrency+" and "+
                                    $scope.currencyObj.toCurrency);
                            $scope.lpoData.exchangeRate='';
                        }                        
                        
                    }).error(function(datas) {
                        logger.logError("Error Please Try Again");
                    });
                }else{
                    $scope.supplierCur = [];
                    $scope.lpoData.currency = '';
                    $scope.lpoData.exchangeRate = '';
                }
            }
       });



        $scope.$watch('lpoData.company', function(newValue, oldValue) {
             ;
            if (newValue != '' && newValue != undefined) {
            $http.get($stateParams.tenantid+'/app/generalinvoice/getCompanyCurrency?CompanyCode='+newValue).success(function(datas) {
                $scope.companyCurrency=datas.CurrencyCode;
                }).error(function(datas) {
            });
            }
       });
        
      /*  $scope.$watch('lpoData.currency', function(newValue, oldValue) {
             ;
            if (newValue != '' && newValue != undefined) {
                $http.get('app/commonUtility/getExchangeRate?currencyCode='+newValue).success(function(data) {
                     ;
                    $scope.lpoData.exchangeRate=data;
                }).error(function(data) {
                });
            }
       });*/
        
        $scope.$watch('lpoData.currency', function(newValue, oldValue) {
            if(newValue!="" && newValue!=undefined && newValue!=null){
                $scope.lpoData.lpoDetail[0].currency=newValue;
                
                $http.get($stateParams.tenantid+'/app/commonUtility/getExchangeRateWithCurrency?currencyCode='+newValue).success(function(data){
                    if(data.success){
                        $scope.lpoData.exchangeRate=data.exchangeRate;
                        $scope.lpoData.fromCurrency=data.fromCurrency;
                        $scope.lpoData.toCurrency=data.toCurrency;                         
                    }else{
                        $scope.lpoData.lpoDetail[$scope.$index].exchangeRate='';
                    }                
                }).error(function(data) {
                });
            }
        });
     
        // Drop Down Functionality

       $scope.getDropdownvalue = function() {
           
        
           $http.get($stateParams.tenantid+'/app/usermaster/getCompanyList?formCode='+$('#form_code_id').val()).success(function(datas) {
               $scope.companyList = datas;
           
               var foundItemDest = $filter('filter')($scope.companyList, { baseCompany:  1 })[0];
               $scope.lpoData.company=foundItemDest.id;
               }).error(function(datas) {
           });
           
           $http.get($stateParams.tenantid+'/app/invoice/lpo/getSupplierList').success(function(datas) {
               $scope.supplierList = datas;
               }).error(function(datas) {
           });
           
          $http.get($stateParams.tenantid+'/app/invoice/lpo/getAccountList').success(function(datas) {
               $scope.accountList = datas;
               $scope.accountListData.push($scope.accountList);

               }).error(function(datas) {
           });

          $http.get($stateParams.tenantid+'/app/invoice/lpo/getSubAccountList').success(function(datas) {
              $scope.subAccountList = datas;
              }).error(function(datas) {
          });
          
          $http.get($stateParams.tenantid+'/app/invoice/lpo/getCurrencyList').success(function(datas) {
              $scope.currencyList = datas;
              }).error(function(datas) {
          });
         

          // code added for attribute dropdown list
          
          
          
      
          
          
          $http.get($stateParams.tenantid+'/app/commonUtility/getTripList').success(function(datas) {
              $scope.voyageList = datas;
              }).error(function(datas) {
          });
          
      	
          /*$http.get($stateParams.tenantid+'/trucktrailermapping/trucklist').success(function(datas) {
              }).error(function(datas) {
          });*/

          
          $http.get($stateParams.tenantid+'/trucktrailermapping/trucklist').success(function(datas) {
              $scope.vesselList = datas.truckList;;
              }).error(function(datas) {
          });
          
          
          $http.get($stateParams.tenantid+'/app/commonUtility/getSectorList').success(function(datas) {
              $scope.sectorList = datas;
              }).error(function(datas) {
          });
          
          $http.get($stateParams.tenantid+'/app/commonUtility/getEmployeeList').success(function(datas) {
              $scope.employeeList = datas;
              }).error(function(datas) {
          });
          
          $http.get($stateParams.tenantid+'/app/commonUtility/getPortList').success(function(datas) {
              $scope.portList = datas;
              }).error(function(datas) {
          });
          
          $http.get($stateParams.tenantid+'/app/commonUtility/getDepartmentList').success(function(datas) {
              $scope.departmentList = datas;
              }).error(function(datas) {
          });
          
          $http.get($stateParams.tenantid+'/app/commonUtility/getAgentList').success(function(datas) {
              $scope.agentList = datas;
              }).error(function(datas) {
          });
          
          $http.get($stateParams.tenantid+'/app/commonUtility/getCountryList').success(function(datas) {
              $scope.countryList = datas;
              }).error(function(datas) {
          });
          
          $http.get($stateParams.tenantid+'/app/commonUtility/getCustomerList').success(function(datas) {
              $scope.customerList = datas;
              }).error(function(datas) {
          });
          
          $http.get($stateParams.tenantid+'/app/commonUtility/getDesignationList').success(function(datas) {
              $scope.designationList = datas;
              }).error(function(datas) {
          });

       };

       $scope.getDropdownvalue();

       
       
       
      

       
       /**
        * BC to TC Amount Calculation on Header
        */
       /*$scope.amountCalculation= function(localAmount){
           $scope.lpoData.tcAmount = (parseFloat(localAmount) * parseFloat($scope.lpoData.exchangeRate)).toFixed(2);
       }*/
       
       $scope.amountCalculation= function(bcamount){
           /*if(bcamount!=undefined && bcamount!=0 && bcamount!=''){
               if($scope.lpoData.exchangeRate!=undefined 
                       && $scope.lpoData.exchangeRate!=0 && $scope.lpoData.exchangeRate!=""){
                   var tcAmt = Number((parseFloat(bcamount) * $scope.lpoData.exchangeRate));
                   $scope.lpoData.tcAmount = parseFloat($scope.checkIsNaN(tcAmt)).toFixed(2);
               }else{
                   $scope.lpoData.exchangeRate=1;
                   var bcAmt = Number((parseFloat(bcamount) * $scope.lpoData.exchangeRate));
                   $scope.lpoData.tcAmount = parseFloat($scope.checkIsNaN(bcAmt)).toFixed(2);
               }
           }*/
           if(bcamount!=undefined && bcamount!=0 && bcamount!=''){
               if($scope.lpoData.tcAmount!=undefined && $scope.lpoData.tcAmount!=0 && $scope.lpoData.tcAmount!=""){
                   var tcAmount = Number(parseFloat($scope.lpoData.tcAmount) /(parseFloat(bcamount)));
                   $scope.lpoData.exchangeRate = parseFloat($scope.checkIsNaN(tcAmount)).toFixed(3);
               }
           else if($scope.lpoData.exchangeRate!=undefined && $scope.lpoData.exchangeRate!=0 && $scope.lpoData.exchangeRate!=""){
                   var tcAmount = Number((parseFloat(bcamount) * $scope.lpoData.exchangeRate));
                   $scope.lpoData.tcAmount = parseFloat($scope.checkIsNaN(tcAmount)).toFixed(2);
               }else{
                   $scope.lpoData.exchangeRate=1;
                   var bcAmount =Number((parseFloat(bcamount) * $scope.lpoData.exchangeRate));
                   $scope.lpoData.tcAmount = parseFloat($scope.checkIsNaN(bcAmount)).toFixed(2);
               }
           }
        }

     
       
       /**
        * TC to BC Amount Calculation on Header
        */
       /*$scope.amountLocalCalculation= function(USDAmount){
           $scope.lpoData.bcAmount =  (parseFloat(USDAmount) / parseFloat($scope.lpoData.exchangeRate)).toFixed(2);
       }*/

       $scope.amountLocalCalculation= function(tcAmount){
           /* ;
           if($scope.lpoData.exchangeRate!=0 && $scope.lpoData.exchangeRate!=""){
               var bcAmt = Math.floor((parseFloat(tcAmount) / $scope.lpoData.exchangeRate)*100)/100;
               $scope.lpoData.bcAmount = parseFloat(bcAmt).toFixed(2);
           }
           else{
               $scope.lpoData.exchangeRate=1.0;
               var bcAmt = Math.floor((parseFloat(tcAmount) / $scope.lpoData.exchangeRate)*100/100);
               $scope.lpoData.bcAmount = parseFloat(bcAmt).toFixed(2);
           }*/
           if(tcAmount!=undefined && tcAmount!=0 && tcAmount!=''){
               if($scope.lpoData.exchangeRate!=undefined 
                       && $scope.lpoData.exchangeRate!=0 && $scope.lpoData.exchangeRate!=""){
                   var bcAmt = Number((parseFloat(tcAmount) / $scope.lpoData.exchangeRate));
                   $scope.lpoData.bcAmount = parseFloat($scope.checkIsNaN(bcAmt)).toFixed(2);
               }else{
                   $scope.lpoData.exchangeRate=1;
                   var bcAmt = Number((parseFloat(tcAmount) / $scope.lpoData.exchangeRate));
                   $scope.lpoData.bcAmount = parseFloat($scope.checkIsNaN(bcAmt)).toFixed(2);
               }
           }
       }
       $scope.checkIsNaN = function(value){
           if(isNaN(value))
               value = 0
               
           return value;
       }
        
       /**
        * Calculate bc and tc amount with Exchange Rate
        */
       $scope.calculateExchangeRateOnHdr=function(excahgerate){
            ;
           if(excahgerate>0){
               if(isNaN(parseFloat($scope.lpoData.tcAmount, 10))){
                   if(isNaN(parseFloat($scope.lpoData.bcAmount, 10))){
                       var bcAmt = Math.floor(((isNaN(parseFloat( $scope.lpoData.tcAmount, 10))?0: $scope.lpoData.tcAmount) / parseFloat(excahgerate))*100)/100;
                       var tcAmt = Math.floor(((isNaN(parseFloat($scope.lpoData.bcAmount, 10))?0:$scope.lpoData.bcAmount) * parseFloat(excahgerate))*100)/100;
                       
                       $scope.lpoData.tcAmount = parseFloat(tcAmt).toFixed(2);
                       $scope.lpoData.bcAmount = parseFloat(bcAmt).toFixed(2);
                   }else{
                       var tcAmt = Math.floor(((isNaN(parseFloat($scope.lpoData.bcAmount, 10))?0:$scope.lpoData.bcAmount) * parseFloat(excahgerate))*100)/100;
                       $scope.lpoData.tcAmount = parseFloat(tcAmt).toFixed(2);
                   }
               }else {
                   var bcAmt = Math.floor(((isNaN(parseFloat( $scope.lpoData.tcAmount, 10))?0: $scope.lpoData.tcAmount) / parseFloat(excahgerate))*100)/100;
                   $scope.lpoData.bcAmount = parseFloat(bcAmt).toFixed(2);
               }    
           }else{
               $scope.lpoData.bcAmount = parseFloat(0).toFixed(2);
           }           
        }
       
       
       /**
        * Calculate bc and tc amount with Exchange Rate
        */
       $scope.exchageratehdr=function(excahgerate){
            ;
           if(excahgerate>0){
               if(parseFloat(excahgerate) < $scope.lpoData.fromCurrency || parseFloat(excahgerate) > $scope.lpoData.toCurrency){
                   logger.logError("Please Enter Exchange Rate Between "+$scope.lpoData.fromCurrency+" and "+
                           $scope.lpoData.toCurrency);       
                   $scope.lpoData.exchangeRate=0;
                   
               }else{
                   if(isNaN(parseFloat($scope.lpoData.tcAmount, 10))){                   
                       if(isNaN(parseFloat($scope.lpoData.bcAmount, 10))){
                           var bcAmt = Math.floor(((isNaN(parseFloat( $scope.lpoData.tcAmount, 10))?0: $scope.lpoData.tcAmount) / parseFloat(excahgerate))*100)/100;
                           var tcAmt = Math.floor(((isNaN(parseFloat($scope.lpoData.bcAmount, 10))?0:$scope.lpoData.bcAmount) * parseFloat(excahgerate))*100)/100;
                           
                           $scope.lpoData.tcAmount = parseFloat(tcAmt).toFixed(2);
                           $scope.lpoData.bcAmount = parseFloat(bcAmt).toFixed(2);
                       }else{
                           var tcAmt = Math.floor(((isNaN(parseFloat($scope.lpoData.bcAmount, 10))?0:$scope.lpoData.bcAmount) * parseFloat(excahgerate))*100)/100;
                           $scope.lpoData.tcAmount = parseFloat(tcAmt).toFixed(2);
                       }
                   }else {
                       var bcAmt = Math.floor(((isNaN(parseFloat( $scope.lpoData.tcAmount, 10))?0: $scope.lpoData.tcAmount) / parseFloat(excahgerate))*100)/100;
                       $scope.lpoData.bcAmount = parseFloat(bcAmt).toFixed(2);
                   }
               } 
           }else{
               excahgerate=0;
               if(parseFloat(excahgerate) < $scope.lpoData.fromCurrency || parseFloat(excahgerate) > $scope.lpoData.toCurrency){
                   logger.logError("Please Enter Exchange Rate Between "+$scope.lpoData.fromCurrency+" and "+
                           $scope.lpoData.toCurrency);       
                   excahgerate=0;
               }else{
                   $scope.lpoData.bcAmount = parseFloat(0).toFixed(2);
               }             
           }           
        }
       
       $scope.amountCalculationexchange= function(exchagerate,index,row){
           if(exchagerate>0){
               if(parseFloat(exchagerate) < row.fromCurrency || parseFloat(exchagerate) > row.toCurrency){
                   logger.logError("Row "+row.siNo+" : Please Enter Exchange Rate Between "+row.fromCurrency+" and "+
                           row.toCurrency);      
                   row.exchangeRate=0;
               }else{
                   if(isNaN(parseFloat(row.tcAmount, 10))){
                       if(isNaN(parseFloat(row.bcAmount, 10))){
                           var bcAmt = Math.floor(((isNaN(parseFloat(row.tcAmount, 10))?0:row.tcAmount) / parseFloat(exchagerate))*100)/100;
                           var tcAmt =  Math.floor(((isNaN(parseFloat(row.bcAmount, 10))?0:row.bcAmount) * parseFloat(exchagerate))*100)/100;
                           
                           row.bcAmount = parseFloat(bcAmt).toFixed(2);
                           row.tcAmount = parseFloat(tcAmt).toFixed(2);
                       }else{
                           var tcAmt =  Math.floor(((isNaN(parseFloat(row.bcAmount, 10))?0:row.bcAmount) * parseFloat(exchagerate))*100)/100;
                           row.tcAmount = parseFloat(tcAmt).toFixed(2);
                       }
                   }else {
                       var bcAmt = Math.floor(((isNaN(parseFloat(row.tcAmount, 10))?0:row.tcAmount) / parseFloat(exchagerate))*100)/100;
                       row.bcAmount = parseFloat(bcAmt).toFixed(2);
                   }
                
                   $scope.calculateTotalAmount($scope.lpoData.lpoDetail);
               }
               
           }else{
               row.bcAmount = 0;
               $scope.calculateTotalAmount($scope.lpoData.lpoDetail);
           }
       }
       
      
       
       /**
        * calculation On Detail Table ***********************************************
        */
       /**
        * bc to tc Amount Calculation on Detail Table
        */
       $scope.amountCalculationBCTable= function(bcAmount,index,row){           
           /*if(bcAmount!=undefined && bcAmount!=0 && bcAmount!=''){
               if($scope.lpoData.exchangeRate!=undefined 
                       && $scope.lpoData.exchangeRate!=0 && $scope.lpoData.exchangeRate!=""){
                   var tcAmt = Number((parseFloat(bcAmount) * $scope.lpoData.exchangeRate));
                   row.tcAmount= parseFloat($scope.checkIsNaN(tcAmt)).toFixed(3);
                   $scope.calculateTotalAmount($scope.lpoData.lpoDetail);
               }else{
                   $scope.lpoData.exchangeRate=1;
                   var bcAmt = Number((parseFloat(bcAmount) * $scope.lpoData.exchangeRate));
                   row.tcAmount = parseFloat($scope.checkIsNaN(bcAmt)).toFixed(3);
                   $scope.calculateTotalAmount($scope.lpoData.lpoDetail);
               }
           }*/
           if(bcAmount!=undefined && bcAmount!=0 && bcAmount!=''){
               if(row.tcAmount!=undefined && row.tcAmount!=0 && row.tcAmount!=""){
                   var tcAmount = Number((parseFloat(row.tcAmount)/parseFloat(bcAmount)));
                   row.exchangeRate = parseFloat($scope.checkIsNaN(tcAmount)).toFixed(3);
                   $scope.calculateTotalAmount($scope.lpoData.lpoDetail);
               }
               else if(row.exchangeRate!=undefined && row.exchangeRate!=0 && row.exchangeRate!=""){
                   var tcAmount = Number((parseFloat(bcAmount) * row.exchangeRate));
                   row.tcAmount = parseFloat($scope.checkIsNaN(tcAmount)).toFixed(3);
                   $scope.calculateTotalAmount($scope.lpoData.lpoDetail);
               }else{
                   $scope.lpoData.exchangeRate=1;
                   var bcAmount = Number((parseFloat(bcAmount) * row.exchangeRate));
                   row.tcAmount = parseFloat($scope.checkIsNaN(bcAmount)).toFixed(3);
                   $scope.calculateTotalAmount($scope.lpoData.lpoDetail);
               }
           }
       }
       


       
       /**
        * tc to bc Amount Calculation on Detail Table
        */
       $scope.amountCalculationTCTable= function(tcAmount,index,row){
          /* if(row.exchangeRate!=0 && row.exchangeRate!=""){
               var bcAmt = Math.floor((parseFloat(tcAmount) / row.exchangeRate)*100)/100;
               row.bcAmount = parseFloat(bcAmt).toFixed(2);
               $scope.calculateTotalAmount();
           }
           else{
               row.exchangeRate=1.0;
               
               var bcAmt  = Math.floor((parseFloat(tcAmount) / row.exchangeRate)*100/100);
               row.bcAmount = parseFloat(bcAmt).toFixed(2);
               $scope.calculateTotalAmount();
           }*/
           if(tcAmount!=undefined && tcAmount!=0 && tcAmount!=''){
               if(row.exchangeRate!=undefined 
                       && row.exchangeRate!=0 && row.exchangeRate!=""){
                   var bcAmt = Number((parseFloat(tcAmount) / row.exchangeRate));
                   row.bcAmount = parseFloat($scope.checkIsNaN(bcAmt)).toFixed(2);
                   $scope.calculateTotalAmount($scope.lpoData.lpoDetail);
               }else{
                   $scope.lpoData.exchangeRate=1;
                   var bcAmt = Number((parseFloat(tcAmount) / row.exchangeRate));
                   row.bcAmount = parseFloat($scope.checkIsNaN(bcAmt)).toFixed(2);
                   $scope.calculateTotalAmount($scope.lpoData.lpoDetail);
               }
           }
       }
       
       $scope.calculateExchangeRateOnDtlTbl= function(exchagerate,index,row){
           if(exchagerate>0){
               if(isNaN(parseFloat(row.tcAmount, 10))){
                   if(isNaN(parseFloat(row.bcAmount, 10))){
                       var bcAmt = Math.floor(((isNaN(parseFloat(row.tcAmount, 10))?0:row.tcAmount) / parseFloat(exchagerate))*100)/100;
                       var tcAmt =  Math.floor(((isNaN(parseFloat(row.bcAmount, 10))?0:row.bcAmount) * parseFloat(exchagerate))*100)/100;
                       
                       row.bcAmount = parseFloat(bcAmt).toFixed(2);
                       row.tcAmount = parseFloat(tcAmt).toFixed(2);
                   }else{
                       var tcAmt =  Math.floor(((isNaN(parseFloat(row.bcAmount, 10))?0:row.bcAmount) * parseFloat(exchagerate))*100)/100;
                       row.tcAmount = parseFloat(tcAmt).toFixed(2);
                   }
               }else {
                   var bcAmt = Math.floor(((isNaN(parseFloat(row.tcAmount, 10))?0:row.tcAmount) / parseFloat(exchagerate))*100)/100;
                   row.bcAmount = parseFloat(bcAmt).toFixed(2);
               }
            
               $scope.calculateTotalAmount();
           }else{
               row.bcAmount = 0;
               $scope.calculateTotalAmount();
           }
           
       }
       
       
       
       /**
        * calculate total amount from detail table rows
        */
       $scope.calculateTotalAmount = function(lpoDetail){
           var totalBCAmount=0.0,totalTCAmount=0.0;
           angular.forEach(lpoDetail, function(row, index) {
               totalBCAmount = totalBCAmount+parseFloat(row.bcAmount);
               totalTCAmount = totalTCAmount+parseFloat(row.tcAmount);
           });
           $scope.totalTCAmount = totalTCAmount.toFixed(2);
           $scope.totalBCAmount = totalBCAmount.toFixed(2);
       };
      /* $scope.calculateTotalAmount = function(){
           var purchanceInvoiceDetail = $scope.lpoData.lpoDetail;
           var bcAmt=0,tcAmt=0;
           angular.forEach(purchanceInvoiceDetail, function (item, key) {
               var lpoData = purchanceInvoiceDetail[key];
               
                  bcAmt = bcAmt+parseFloat(item.bcAmount);
                  tcAmt = tcAmt+parseFloat(item.tcAmount);
                  $scope.totalBCAmount=bcAmt;
                  $scope.totalTCAmount=tcAmt;
               
            });
       };*/
       

       /**
        * Reverse functionality
        */
       
//       $scope.currentURL=$location.protocol() + '://'+ $location.host() +':'+  $location.port()+"/#" +$location.path();
       
//       if(window.localStorage.getItem('lpo')==$scope.currentURL){
//           alert('window ' + $scope.currentURL + ' is already opened');
//           window.focus();
//           window.close();
//           
//       }else{
//           window.localStorage.setItem('lpo', $scope.currentURL);
//       }  

       $scope.isEdit1 = false;
       var reverseLpoNo = $stateParams.reverseLpoNo;
       console.log("reverseLpoNo" + reverseLpoNo)
   
        if(reverseLpoNo == undefined || reverseLpoNo == null || reverseLpoNo == ""){
            $scope.copy =false;
        }
        else
            {
            $scope.copy =true;
            console.log("copy")
            $http.get($stateParams.tenantid+'/app/invoice/lpo/getLpoDetail?lpoNo='+reverseLpoNo).success(function(data) {
                $scope.isEdit1 = true;
                console.log("Kathir Check copy detail");
                console.log(data);
                 ;
                $scope.subAccountList=data.subAccountCodeList;
                $scope.purchaseOrderList= data.pOList;
                
                console.log($scope.purchaseOrderList);
                $scope.lpoData = data;
                console.log($scope.lpoData);
                $scope.calculateTotalAmount($scope.lpoData.lpoDetail);
            }).error(function(data) {
            });   
            
        }
       //edit
debugger;

$scope.isEdit1 = false;
       var lpoNo=$stateParams.lpoNo;
       console.log("lpoNo" + lpoNo)
       if(lpoNo == undefined || lpoNo == null || lpoNo ==""){
           $scope.edit=false;
       }else{
           console.log("edit")
           $scope.edit=true;
           $http.get($stateParams.tenantid+'/app/invoice/lpo/getLpoDetail?lpoNo='+lpoNo).success(function(data) {
               $scope.isEdit1 = true;
               console.log("Kathir Check edit detail");
               console.log(data);
                ;
               $scope.subAccountList=data.subAccountCodeList;
               $scope.purchaseOrderList= data.pOList;
               
               console.log($scope.purchaseOrderList);
               $scope.lpoData = data;
               console.log($scope.lpoData);
               $scope.calculateTotalAmount($scope.lpoData.lpoDetail);
           }).error(function(data) {
           });
       }
       
       $scope.onSubmit = function(lpoForm,lpoData) {
           console.log($scope.lpoData);
           //$scope.lpoData.lpoDate = $('#lpoDate').val();
         //  $scope.lpoData.partyInvoiceDate = $('#party_invoice_date').val();
       //    $scope.lpoData.dueDate = $('#due_date').val();

           if (new validationService().checkFormValidity($scope.lpoForm)) {
               $scope.save();
           } else {
               toaster.pop('error', "Please fill the required fields", 
                       logger.getErrorHtmlNew($scope.lpoForm.$validationSummary), 5000, 'trustedHtml');
           }
       };
       
       
       $scope.save = function(){
           console.log("on save")
           console.log($scope.lpoData)
           if(!$scope.edit){
               if(($scope.totalBCAmount==$scope.lpoData.bcAmount)){
                   $http.post($stateParams.tenantid+'/app/invoice/lpo/savePurInv', $scope.lpoData).success(function(result) {
                   if (result.success) {
                       $location.path($stateParams.tenantid+"/invoice/lpo/LPOList");
                       logger.logSuccess("LPO added successfully");
                       
                       var lpoNo = result.lpoNo;
                       $timeout(function() {
                           var url = $stateParams.tenantid+'/app/invoice/lpo/print?lpoNo=' + lpoNo;
                           var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
                           wnd.print();   
                       }, 1000);
                   } else {
                           if(result.message != null && result.message != ''){
                               logger.logError(result.message);
                           }else{
                           logger.logError("LPO Already Exist");
                           }

                   }
               }).error(function(data) {
                  
               });
               }
               else
                   logger.logError("Amount Should Be Same");
           }else{
               // update
               
               if(($scope.totalBCAmount==$scope.lpoData.bcAmount)){
                   $http.post($stateParams.tenantid+'/app/invoice/lpo/updateLpo', $scope.lpoData).success(function(result) {
                       if (result == false) {
                           logger.logError("Failed to update");
                       } else {
                           $location.path($stateParams.tenantid+"/invoice/lpo/LPOList");
                           logger.logSuccess("LPO updated successfully");
                       }

                   }).

                   error(function(data) {
                       console.log(data);
                   });
                   }
               else
                   logger.logError("Amount Should Be Same");
           }
       }

       /**
        * print PIN...
        */
       $scope.printLPO= function(lpoData){
           var url = $stateParams.tenantid+'/app/invoice/lpo/print?lpoNo=' + lpoData.lpoNo;
           var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
           wnd.print();   
        }
       
       $scope.isOwner = false;
       $scope.checkOwner = function(){
           $http.get($stateParams.tenantid+'/app/cashbankreceipt/checkOwnerUser').success(function(data) {
                   console.log("owner")
                   console.log(data)
                   $scope.isOwner = data;
           });
       }
       $scope.checkOwner();
       
       
});

app.controller('tableCtrl', function($scope,$http, $filter,logger,$stateParams){
    var lpoNo=$stateParams.lpoNo;
    
    $scope.$watch('lpoData.lpoDetail[trIndex].companyCode', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
            if(!$scope.isEdit1)
                $scope.lpoData.lpoDetail[$scope.$index].accountHeadCode = '';
        }
    });
    
    $scope.$watch('lpoData.lpoDetail[trIndex].accountHeadCode', function(newValue, oldValue) {
         ;
        if (newValue != '' && newValue != undefined) {
            console.log("acct head code="+newValue);
                if(newValue == '10080001'){
                    $http.get($stateParams.tenantid+'/app/commonUtility/getSubAccountCodeListTradeDebtors').success(function(datas) {
                         ;
                        $scope.lpoData.lpoDetail[$scope.$index].subAccountCodeList = datas;
                        $scope.lpoData.lpoDetail[$scope.$index].isSubAccountCode =true;
                        }).error(function(datas) {
                    });
                }else if(newValue == '20010001'){
                    $http.get($stateParams.tenantid+'/app/commonUtility/getSubAccountCodeListTradeCreditors').success(function(datas) {
                        $scope.lpoData.lpoDetail[$scope.$index].subAccountCodeList = datas;
                        $scope.lpoData.lpoDetail[$scope.$index].isSubAccountCode=true;
                        }).error(function(datas) {
                    });   
                }else if(newValue == '10070001'){
                    if($scope.lpoData.lpoDetail[$scope.$index].companyCode == 'C0003')
                        $scope.currencyList = [{id:'SGD',text:'SGD'}];
                    $http.get($stateParams.tenantid+'/app/commonUtility/getStaffListForAdvances').success(function(datas) {
                        $scope.lpoData.lpoDetail[$scope.$index].subAccountCodeList = datas;
                        $scope.lpoData.lpoDetail[$scope.$index].isSubAccountCode=true;
                        }).error(function(datas) {
                    });   
                }else if(newValue == '20010004'){
                    $http.get($stateParams.tenantid+'/app/commonUtility/getJvPartnerAccount').success(function(datas) {
                        $scope.lpoData.lpoDetail[$scope.$index].subAccountCodeList = datas;
                        $scope.lpoData.lpoDetail[$scope.$index].isSubAccountCode=true;
                        }).error(function(datas) {
                    });   
                }else if(newValue == '10090017'){
                    $http.get($stateParams.tenantid+'/app/commonUtility/getonlySupplier').success(function(datas) {
                        $scope.lpoData.lpoDetail[$scope.$index].subAccountCodeList = datas;
                        $scope.lpoData.lpoDetail[$scope.$index].isSubAccountCode=true;
                        }).error(function(datas) {
                    });   
                }else{
                    $scope.lpoData.lpoDetail[$scope.$index].subAccountCodeList=[];
                    $scope.lpoData.lpoDetail[$scope.$index].isSubAccountCode=false;
                }
            
                if(newValue.substring(0, 4)=='1000'){
                    $scope.lpoData.lpoDetail[$scope.$index].isAsset=true;
                    $http.get($stateParams.tenantid+'/app/commonUtility/getassetList').success(function(datas) {
                         ;
                        $scope.lpoData.lpoDetail[$scope.$index].assetList = datas;
                        }).error(function(datas) {
                    });
                }
                
                $http.get($stateParams.tenantid+'/app/commonUtility/getAttributesList?accountCode='+newValue).success(function(datas) {
                 ;
                $scope.lpoData.lpoDetail[$scope.$index].attributeList=datas;
                if(newValue==oldValue){
                    $scope.isOnChange =false;
                }else{
                    $scope.isOnChange =true;
                }
                if(!$scope.edit || $scope.isOnChange){
                    
                $scope.lpoData.lpoDetail[$scope.$index].voyageCode='';
                $scope.lpoData.lpoDetail[$scope.$index].vesselCode='';
                $scope.lpoData.lpoDetail[$scope.$index].sectorCode='';
                $scope.lpoData.lpoDetail[$scope.$index].employeeCode='';
                $scope.lpoData.lpoDetail[$scope.$index].portCode='';
                $scope.lpoData.lpoDetail[$scope.$index].portSequence='';
                $scope.lpoData.lpoDetail[$scope.$index].departmentCode='';
                $scope.lpoData.lpoDetail[$scope.$index].agentCode='';
                $scope.lpoData.lpoDetail[$scope.$index].countryCode='';
                $scope.lpoData.lpoDetail[$scope.$index].customerCode='';
                $scope.lpoData.lpoDetail[$scope.$index].supplierCode='';
                $scope.lpoData.lpoDetail[$scope.$index].designationCode='';
                $scope.lpoData.lpoDetail[$scope.$index].costCenter='';
                // commented for inter-company transaction
                /*$scope.lpoData.lpoDetail[$scope.$index].companyCode='';*/
                $scope.lpoData.lpoDetail[$scope.$index].quantityGO='';
                $scope.lpoData.lpoDetail[$scope.$index].quantityFO='';
                }
                
                $scope.lpoData.lpoDetail[$scope.$index].isVoyage=false;
                $scope.lpoData.lpoDetail[$scope.$index].isVessel=false;
                $scope.lpoData.lpoDetail[$scope.$index].isService=false;
                $scope.lpoData.lpoDetail[$scope.$index].isEmployee=false;
                $scope.lpoData.lpoDetail[$scope.$index].isPort=false;
                $scope.lpoData.lpoDetail[$scope.$index].isDepartment=false;
                $scope.lpoData.lpoDetail[$scope.$index].isAgent=false;
                $scope.lpoData.lpoDetail[$scope.$index].isLocation=false;
                $scope.lpoData.lpoDetail[$scope.$index].isCustomer=false;
                $scope.lpoData.lpoDetail[$scope.$index].isSupplier=false;
                $scope.lpoData.lpoDetail[$scope.$index].isDesignation=false;
                $scope.lpoData.lpoDetail[$scope.$index].isCostCenter=false;
                // commented for inter-company transaction
                /*$scope.lpoData.lpoDetail[$scope.$index].isCompany=false;*/
                $scope.lpoData.lpoDetail[$scope.$index].isQuantityGO=false;
                $scope.lpoData.lpoDetail[$scope.$index].isQuantityFO=false;
                $scope.lpoData.lpoDetail[$scope.$index].isPortSequence=false;
                
             // code added for mandatory
                $scope.lpoData.lpoDetail[$scope.$index].isVoyageMan=false;
                $scope.lpoData.lpoDetail[$scope.$index].isVesselMan=false;
                $scope.lpoData.lpoDetail[$scope.$index].isServiceMan=false;
             
                angular.forEach($scope.lpoData.lpoDetail[$scope.$index].attributeList, function(row, rowindex) {
                     ;
                     if(row.attributeName == "Voyage"){
                         $scope.lpoData.lpoDetail[$scope.$index].isVoyage=true;
                         if(row.isMandatory == 'Y' && $scope.lpoData.lpoDetail[$scope.$index].companyCode != 'C0002'){
                             if($scope.isOwner)
                                 $scope.lpoData.lpoDetail[$scope.$index].isVoyageMan=false;
                             else
                                 $scope.lpoData.lpoDetail[$scope.$index].isVoyageMan=true;
                         }
                     }else if(row.attributeName == "Vessel"){
                         $scope.lpoData.lpoDetail[$scope.$index].isVessel=true;
                         if(row.isMandatory == 'Y' && $scope.lpoData.lpoDetail[$scope.$index].companyCode != 'C0002'){
                             if($scope.isOwner)
                                 $scope.lpoData.lpoDetail[$scope.$index].isVesselMan=false;
                             else
                                 $scope.lpoData.lpoDetail[$scope.$index].isVesselMan=true;
                         }
                     }else if(row.attributeName == "Service"){
                         $scope.lpoData.lpoDetail[$scope.$index].isService=true;
                         if(row.isMandatory == 'Y' && $scope.lpoData.lpoDetail[$scope.$index].companyCode != 'C0002'){
                             if($scope.isOwner)
                                 $scope.lpoData.lpoDetail[$scope.$index].isServiceMan=false;
                             else
                                 $scope.lpoData.lpoDetail[$scope.$index].isServiceMan=true;
                         }
                     }else if(row.attributeName == "Employee"){
                        $scope.lpoData.lpoDetail[$scope.$index].isEmployee=true;
                    }else if(row.attributeName == "Port"){
                        $scope.lpoData.lpoDetail[$scope.$index].isPort=true;
                    }else if(row.attributeName == "Department"){
                        $scope.lpoData.lpoDetail[$scope.$index].isDepartment=true;
                    }else if(row.attributeName == "Agent"){
                        $scope.lpoData.lpoDetail[$scope.$index].isAgent=true;
                    }else if(row.attributeName == "Location"){
                        $scope.lpoData.lpoDetail[$scope.$index].isLocation=true;
                    }else if(row.attributeName == "Customer"){
                        $scope.lpoData.lpoDetail[$scope.$index].isCustomer=true;
                    }else if(row.attributeName == "Supplier"){
                        $scope.lpoData.lpoDetail[$scope.$index].isSupplier=true;
                    }else if(row.attributeName == "Designation"){
                        $scope.lpoData.lpoDetail[$scope.$index].isDesignation=true;
                    }else if(row.attributeName == "Cost Center"){
                        $scope.lpoData.lpoDetail[$scope.$index].isCostCenter=true;
                    }else if(row.attributeName == "Company"){
                        $scope.lpoData.lpoDetail[$scope.$index].isCompany=true;
                    }else if(row.attributeName == "Quantity (MT) GO"){
                        $scope.lpoData.lpoDetail[$scope.$index].isQuantityGO=true;
                    }else if(row.attributeName == "Quantity (MT) FO"){
                        $scope.lpoData.lpoDetail[$scope.$index].isQuantityFO=true;
                    }else if(row.attributeName == "Port with Sequence"){
                        $scope.lpoData.lpoDetail[$scope.$index].isPortSequence=true;
                    }
                    });
                }).error(function(datas) {
            });
             
                
          /*  angular.forEach($scope.accountList, function(value, indexs) {
                if(newValue == value.accountHeadCode){
                    $scope.lpoData.lpoDetail[$scope.$index].currency=value.currency;
                    // get exchange rate for currency
                    $http.get('app/commonUtility/getExchangeRate?currencyCode='+value.currency).success(function(data) {
                         ;
                        $scope.lpoData.lpoDetail[$scope.$index].exchangeRate=data;
                    }).error(function(data) {
                    });
                    
                }
            });*/
                if(lpoNo == undefined || lpoNo == null || lpoNo ==""){
                if($scope.$index !=0){
                    angular.forEach($scope.accountList, function(value, indexs) {
                        if(newValue == value.accountHeadCode){
                            $scope.lpoData.lpoDetail[$scope.$index].currency=value.currency;
                            // get exchange rate for currency
                            $http.get($stateParams.tenantid+'/app/commonUtility/getExchangeRateWithCurrency?currencyCode='+value.currency).success(function(data) {
                                //$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].exchangeRate=data;
                                if(data.success){
                                    $scope.lpoData.lpoDetail[$scope.$index].fromCurrency=data.fromCurrency;
                                    $scope.lpoData.lpoDetail[$scope.$index].toCurrency=data.toCurrency;
                                    $scope.lpoData.lpoDetail[$scope.$index].exchangeRate=data.exchangeRate;    
                                }else{
                                    $scope.lpoData.lpoDetail[$scope.$index].exchangeRate='';
                                    $scope.lpoData.lpoDetail[$scope.$index].fromCurrency='';
                                    $scope.lpoData.lpoDetail[$scope.$index].toCurrency='';
                                }
                            }).error(function(data) {
                            });                        
                        }
                    });
                }
                }
        }else{
            $scope.lpoData.lpoDetail[$scope.$index].currency='';
            $scope.lpoData.lpoDetail[$scope.$index].exchangeRate='';
            $scope.lpoData.lpoDetail[$scope.$index].subAccountCodeList = [];
        }
    });
    
    /*Voyage On Change...............*/
    $scope.$watch('lpoData.lpoDetail[trIndex].voyageCode', function(newValue, oldValue) {
         ;
        if (newValue != '' && newValue != undefined) {

            angular.forEach($scope.voyageList, function(value, indexs) {
                 ;
                if(newValue == value.voyageCode){
                    $scope.lpoData.lpoDetail[$scope.$index].vesselCode=value.vesselCode;
                    $scope.lpoData.lpoDetail[$scope.$index].sectorCode=value.sectorCode;
                }
            });
        }else{
            $scope.lpoData.lpoDetail[$scope.$index].vesselCode='';
            $scope.lpoData.lpoDetail[$scope.$index].sectorCode='';
        }
    });
    
    $scope.$watch('lpoData.lpoDetail[trIndex].currency', function(newValue, oldValue) {
         ;
       /* if (newValue != '' && newValue != undefined) {
            // get exchange rate for currency
            $http.get('app/commonUtility/getExchangeRate?currencyCode='+newValue).success(function(data) {
                 ;
                $scope.lpoData.lpoDetail[$scope.$index].exchangeRate=data;
            }).error(function(data) {
            });
            
        }*/
        if (newValue != '' && newValue != undefined) {
            // get exchange rate for currency
            /*$http.get('app/commonUtility/getDefaultExchangeRate?currencyCode='+newValue).success(function(data)*/
            $http.get($stateParams.tenantid+'/app/commonUtility/getExchangeRateWithCurrency?currencyCode='+newValue).success(function(data){
                if(data.success){
                    $scope.lpoData.lpoDetail[$scope.$index].fromCurrency=data.fromCurrency;
                    $scope.lpoData.lpoDetail[$scope.$index].toCurrency=data.toCurrency;
                    $scope.lpoData.lpoDetail[$scope.$index].exchangeRate=data.exchangeRate;    
                }else{
                    $scope.lpoData.lpoDetail[$scope.$index].exchangeRate='';
                }                
            }).error(function(data) {
            });
        }
    });
});
