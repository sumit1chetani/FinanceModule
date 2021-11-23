define([ 'hospital/accounts/accounts' ], function(module) {

    'use strict';
    module.registerController('purchaseCreditNoteCTRL', function($scope, $stateParams,$state,
            $http,$filter, ngDialog, logger, $location,utilsService, $controller, $injector, sharedProperties,
            toaster, $rootScope) {
        var cnt=0;
        var gnlpenCnt=0;
        var compCode ;
        $scope.dataLoopCount = 0;
        $scope.from = 0;
        $scope.to = 100;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.username='';
        $scope.form_code_id='F9924';
        $scope.currentURL=$location.protocol() + '://'+ $location.host() +':'+  $location.port()+"/#" +$location.path();
        if(window.localStorage.getItem('pcn_list')==$scope.currentURL){
            alert('window ' + $scope.currentURL + ' is already opened');
            //window.focus();
            //window.open($rootScope.currentURL,'_self').close();
            setTimeout(window.close(),5000);
            //localStorage.removeItem('receipt');
         }else{
             window.localStorage.setItem('pcn', $scope.currentURL);
             localStorage.removeItem('pcn');
         }
//        $(window).unload(function(){
//            //debugger;
//           //alert("INSIDE UNLOAD")
//             
//           });
        $scope.getCreditNoteListUtil = function(limit, offset) {
            var start = new Date().getTime();
            var url = 'app/purchasecreditnote/cnlist?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount +  '&formCode='+$('#form_code_id').val();
            $http.get(url).success(function(data) {
                console.log("data::::::::::getCreditNoteListUtil:::::::::");
                console.log(data);
                console.log("company");
                compCode = data.companyCode ;
                $scope.reverseList = data.reverseList;
                if (data.success == true) {
                    $scope.pushCreditNoteListUtil(data);
                    $scope.dataLoopCount++;
                } else {
                    if ($scope.dataLoopCount == 0) {
                        $scope.showEmptyLabel = true;
                    }
                    logger.logError("Error Please Try Again");
                }
                var end = new Date().getTime();
                var time = end - start;
                console.log('Execution time: ' + time);
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });

        };
        $scope.pushCreditNoteListUtil = function(data) {
            if (utilsService.isUndefinedOrNull(data.lCreditNoteBean)) {
                $scope.showEmptyLabel = true;
            } else {
                $scope.rowCollection = data.lCreditNoteBean;

            }
        };

        $scope.validateDataforApproveRecord = function(selectedrow){
            angular.forEach(selectedrow, function(row, index) {
                $scope.isBreak=true;
                if($scope.isBreak){
                    if(row.creditNoteCode !="" && row.creditNoteDate !=null){
                        $scope.isValidateSucess =true;
                    }else{
                        $scope.isValidateSucess =false;
                        $scope.isBreak =false;
                    }
                }
            });
        }

        $scope.ApproveCreditNote = function(displayedCollection){
            $scope.selectedrow=[];
            angular.forEach(displayedCollection, function(row, index) {
                var check =row.select;
                if (check ==true) {
                    delete row['select'];
                    $scope.selectedrow.push(row);
                }else{

                }
            });
            if($scope.selectedrow.length>0){
                $scope.isValidateSucess =false;
                $scope.validateDataforApproveRecord($scope.selectedrow);

                if($scope.isValidateSucess){
                    var creditnoteCodes="";
                    $scope.lCreditNoteBean =$scope.selectedrow;
                    for(var iRowCtr=0;iRowCtr < $scope.lCreditNoteBean.length;iRowCtr++){
                        if($scope.lCreditNoteBean[iRowCtr].approveStatus!="Y"){
                            if(creditnoteCodes==""){
                                creditnoteCodes= $scope.lCreditNoteBean[iRowCtr].creditNoteCode; //creditNoteCode
                            }
                            else{
                                creditnoteCodes +=","+ $scope.lCreditNoteBean[iRowCtr].creditNoteCode;//creditNoteCode
                            }
                        }
                    }
                    console.log("$scope.lCreditNoteBean::::::::::::creditnoteCodes:::::::::::::");
                    console.log(creditnoteCodes);
                    if(creditnoteCodes!=""){
                        $http.post('app/purchasecreditnote/approveCreditNote', creditnoteCodes).success(function(data) {
                            
                            if (data) {
                                logger.logSuccess("Approve Record Successfully!");
                                $location.path("/transaction/purchasecreditNotelist/list");
                                $state.reload();
                            }else{
                                logger.logError("Approve Record Un Successfull");
                                $location.path("/transaction/purchasecreditNotelist/list");
                            }
                        }).error(function(data) {
                            console.log("data" + data);
                        });
                    }else{
                        logger.logError("Record is Already Approved...");
                    }

                }else{
                    logger.logError("Some of the selected row(s) not entered properly...");
                }

            }else{
                logger.logError("Please Select Atleast one row!...");
            }

        }

        $scope.getCreditNoteListUtil();

        $scope.add = function() {
//            $state.go('app.finance.transaction.purchasecreditNotelist.add');
//            app.hospital.accounts.purchaseCreditnote.Add
            
            $state.go('app.hospital.accounts.purchaseCreditNote.Add');
        };

        $scope.editRowBtn = function(creditCode){
            $location.url('/transaction/purchasecreditNotelist/edit?creditCode='+creditCode);
         //   $state.go('app.finance.transaction.purchaseCreditnotehdr.edit',{creditCode:creditCode});
        };

        $scope.deleteRow = function(creditCode, index) {
            
            ngDialog.openConfirm().then(function() {
                var myURL = 'app/purchasecreditnote/delete';
                $http({
                    method : 'post',
                    url : myURL,
                    data : creditCode,
                }).success(function(data) {
                    if (data == false) {
                        var tableData = $scope.rowCollection;
                        $scope.rowCollection.splice(index, 1);
                        logger.logSuccess("deleted successfully");
                        $state.reload();
                    } else {
                        logger.logError("Error in deleting Record!");
                    }
                }).error(function(data) {
                    logger.logSuccess("Error in Delete!");
                });
            });

        };
        
        
        /**
         * fetch Approved date, approved by  using  ActiveX CONTROLS WITH DIGITAL SIGNATURE   ***********************************************
         */
        
        $scope.view = function(purchasecreditCode) {
            $location.url('/transaction/purchasecreditNotelist/view?purchasecreditCode=' + purchasecreditCode);
        }
        
        $scope.getUserDetail=function(){
            $http.get('app/purchaseCreditNote/logindetail').success(function(datas) {
                console.log("logindetails");
                $scope.username=datas.username
               
                }).error(function(datas) {
            });
        }

        $scope.getUserDetail();
         $scope.selectedrow=[];
         $scope.appovedList=[];
         
         
         $scope.reverse = function() {
             if($scope.creditNoteNo =="" || $scope.creditNoteNo ==undefined){
                 logger.logError("Please select PCN");
             }else{         
                 ngDialog.open({
                     scope : $scope,
                     template : 'views/finance/transaction/transactionReverseDialog',
                     controller : $controller('pcnReverseCtrl', {
                         $scope : $scope,
                         creditNoteNo: $scope.creditNoteNo,
                         screenName: 'pcn'
                     }),
                     className : 'ngdialog-theme-plain',
                     showClose : false,
                     closeByDocument : false,
                     closeByEscape : false,
                     preCloseCallback : $scope.getCreditNoteListUtil
                 });
             }
         }  
    });
    
    
   /* module.registerController('purchaseCreditnoteAddCTRL', function($scope, $state,
            $http,$filter, ngDialog, logger, $location, $controller, $injector, sharedProperties,
            toaster, $rootScope,$timeout) {
        alert(7);*/
     /*   $scope.pcnData = {pcnDate:'', creditNoteNo:''};
        $scope.screenNames = screenName;
        
           
            $timeout(function() {
                $("#txtpcnDate").datetimepicker({
                    minDate: "01/01/2016",
                    format : 'DD/MM/YYYY',
                    pickTime: false
                });
             }, 1000);
            
        $scope.getCurrentDate = function(){
            var today = new Date();
            var dd = today.getDate();
            var mm = today.getMonth() + 1;

            var yyyy = today.getFullYear();
            if (dd < 10) { dd = '0' + dd }
            if (mm < 10) { mm = '0' + mm }
            var today = dd + '/' + mm + '/' + yyyy;
            $scope.pcnData.pcnDate = today;
        }
        $scope.getCurrentDate();
        
        $("#txtpcnDate").on("dp.change", function(e) {
            $scope.pcnData.pcnDate = $('#txtpcnDate').val();
        });
        
        $scope.pcnData.creditNoteNo = creditNoteNo;
       
        $scope.reverseConfirm = function(){
            if($scope.screenNames=="pcn"){
                if($scope.pcnData.pcnDate!=""){
                    $http.post('app/purchaseCreditNote/reversePCN',$scope.pcnData).success(function(datas) {
                        if(datas.success == true){
                            logger.logSuccess(datas.sErrorMessage);
                            ngDialog.close();
                            $scope.getCreditNoteListUtil();
                        }else{
                            logger.logError(datas.sErrorMessage);
                            ngDialog.close();
                            $scope.getCreditNoteListUtil();
                        }
                        }).error(function(datas) {
                    });
                }else{
                    logger.logError("Please Select PCN Date!");
                }
            }
        }
        $scope.closeCBPReverseDialog = function() {
            ngDialog.close();
         };*/
   

    /**
     * Add form - new entry controller
     */
    /*app.controller('purchaseCreditNoteCtrlAdd', function($scope,$filter, $window, $rootScope, $location, $http, 
            logger, $log, ngDialog, $modal, utilsService,sharedProperties,$state,$injector,
            ListService,$stateParams,validationService, toaster) {
        sharedProperties.getObject();*/
    module.registerController('purchaseCreditnoteAddCTRL', function($scope, $state,$stateParams,validationService,
            $http,$filter, ngDialog, logger, $location, $controller, $injector,utilsService ,sharedProperties,
            toaster, $rootScope,$timeout) {
        

       $scope.companyCode = $stateParams.companyCode;
       console.log("companyCode in add ") 
       console.log($scope.companyCode)
        $scope.dataLoopCount = 0;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.acctHeadList = [];
        $scope.crdtlAcctHeadList = [];
        $scope.invoiceNoList = [];
        $scope.invoiceDetails=[];
        $scope.companyDtlList = [];
        $scope.validated = false;
        $scope.creditnoteAcctData = {
                accountName : '', 
                invoiceNo : '', 
                invoiceDate :'', 
                currencyCode : '', 
                exchangeRate: '', 
                creditNoteDate: '',
                supplierCode:'',
                validCreditNoteDate :'',
                companyCode : '',company :'', narration: '',company_id_dtl :'',
                credittables: []
        };
        
        $scope.creditnoteAcctData.credittables
        $scope.edit =false;
        $scope.supplierCur = [];
        
        $scope.currentURL=$location.protocol() + '://'+ $location.host() +':'+  $location.port()+"/#" +$location.path();
        if(window.localStorage.getItem('pcn')==$scope.currentURL){
            alert('window ' + $scope.currentURL + ' is already opened');
           
            setTimeout(window.close(),5000);
            
         }else{
             window.localStorage.setItem('pcn', $scope.currentURL);
         }
        $(window).unload(function(){
           
             localStorage.removeItem('pcn');
           });
        /**
         * datepicker ******************************************************************************************************
         */
        /* $('#cn_date').datetimepicker({
            format : 'DD/MM/YYYY',
            pickTime: false,
            minDate: "01/01/2016",
         });
         
         $('#inv_date').datetimepicker({
             format : 'DD/MM/YYYY',
             pickTime: false,
             minDate: "01/01/2016",
          });*/
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
        $scope.creditnoteAcctData.creditNoteDate = today;
        
        $scope.checkDatesCL = function(cashbankPmtDate){
                var res = $scope.creditnoteAcctData.creditNoteDate.split("/");
                $http.get('app/cashbankreceipt/getloggedcompany?closingDate='+$scope.creditnoteAcctData.creditNoteDate).success(function(datas) {
                    if(datas){
                        logger.logError("Account closed for year "+ res[2]);
                        $scope.creditnoteAcctData.creditNoteDate = today;
                    }
                })
        }
        
        
        $http.get('app/commonUtility/getSubAccountCodeLists').success(function(datas) {

            var subAcctList = [];
            angular.forEach(datas.commonUtilityBean, function(item, key) {
                var subAccHdObj = new Object();
                subAccHdObj.id = datas.commonUtilityBean[key].subAcctCode;
                subAccHdObj.text = datas.commonUtilityBean[key].subAccountName;
                subAcctList.push(subAccHdObj);
            });
            $scope.subAccountCodeList = subAcctList;
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        $scope.checkdate = function() {
            
            var date = $scope.creditnoteAcctData.creditNoteDate;
            var idate = $scope.creditnoteAcctData.invoiceDate
            var pattern = /^(0[1-9]|[12][0-9]|3[01])[\- \/.](?:(0[1-9]|1[012])[\- \/.](19|20)[0-9]{2})$/;
             if (!date.match(pattern)) {
                $scope.creditnoteAcctData.creditNoteDate = "";
                logger.logError("Date Format Should be DD/MM/YYYY !");
                return false;
            }else if(!idate.match(pattern)){
                $scope.creditnoteAcctData.invoiceDate = "";
                logger.logError("Date Format Should be DD/MM/YYYY !");
                return false;
            }
            else{
                return true;
            }
             
        }
        
        
   
     
        /**
         * Fetching Acct Head Dropdown Drop Down
         */
        $scope.getAcctHeadDropdown= function() {
            $http.get('app/purchaseCreditNote/getAcctHeadCombo').success(function(datas) {
                debugger;
                console.log(datas);
                if(datas.length>0){
                    $scope.acctHeadList = datas;
                }

            }).error(function(data) {
            });
        };
        $scope.getAcctHeadDropdown();

        
     // code added for attribute dropdown list
        $scope.getDropdownList= function() {
            
            $http.get('app/commonUtility/getCompanyList?formCode='+$('#form_code_id').val()).success(function(datas) {
                debugger;
                console.log($('#form_code_id').val());
                $scope.companyList = datas;
                $scope.companyDtlList =datas;
                var foundItemDest = $filter('filter')($scope.companyList, { baseCompany:  1 })[0];
                $scope.creditnoteAcctData.companyCode=foundItemDest.id;
                }).error(function(datas) {
            });

            $http.get("hrms/master/country/currencylist").success(function(datas) {
                $scope.currencyList = datas.currencyList;
            });
            
            /*
            
            $http.get('app/commonUtility/getVoyageList').success(function(datas) {
                $scope.voyageList = datas;
                $scope.voyageListt = datas;
                }).error(function(datas) {
                logger.logError("Error Please Try Again");
            });
            
            $http.get('app/commonUtility/getVesselList').success(function(datas) {
                $scope.vesselList = datas;
                }).error(function(datas) {
            });
            
            $http.get('app/commonUtility/getSectorList').success(function(datas) {
                $scope.sectorList = datas;
                }).error(function(datas) {
            });
            
            $http.get('app/commonUtility/getEmployeeList').success(function(datas) {
                $scope.employeeList = datas;
                }).error(function(datas) {
            });
            
            $http.get('app/commonUtility/getPortList').success(function(datas) {
                $scope.portList = datas;
                }).error(function(datas) {
            });
            
            $http.get('app/commonUtility/getDepartmentList').success(function(datas) {
                $scope.departmentList = datas;
                }).error(function(datas) {
            });
            
            $http.get('app/commonUtility/getAgentList').success(function(datas) {
                $scope.agentList = datas;
                }).error(function(datas) {
            });
            
            $http.get('app/commonUtility/getCountryList').success(function(datas) {
                $scope.countryList = datas;
                }).error(function(datas) {
            });
            
            $http.get('app/commonUtility/getCustomerList').success(function(datas) {
                $scope.customerList = datas;
                }).error(function(datas) {
            });
            
            $http.get('app/commonUtility/getDesignationList').success(function(datas) {
                $scope.designationList = datas;
                }).error(function(datas) {
            });
            */
            $http.get('app/purchaseinvoice/getSupplierList').success(function(datas) {
                $scope.supplierList = datas;
            }).error(function(datas) {
            });
            
            
           /* $http.get('app/accounthead/getCurrencyList').success(function(datas) {
                $scope.currencyList = datas;
                }).error(function(datas) {
            });*/
            
    }
        $scope.getDropdownList();
        
        
        
        
        //ra
        $scope.$watch('creditnoteAcctData.accountName', function(newValue, oldValue) {
            if (newValue != '' && newValue != undefined) {
                $http.get('app/creditNote/getInvoiceNo?acctHeadCode='+newValue).success(function(datas) {
                    
                    if(datas.length>0){
                        $scope.invoiceNoList = datas;
                    }else{
                        $scope.invoiceNoList = [];
                        $scope.creditnoteAcctData.invoiceDate = "";
                        $scope.creditnoteAcctData.currencyCode = "";
                        $scope.creditnoteAcctData.exchangeRate = "";
                    }
                }).error(function(data) {
                });
            }else{
                $scope.invoiceNoList = [];
                $scope.creditnoteAcctData.invoiceDate = "";
                $scope.creditnoteAcctData.currencyCode = "";
                $scope.creditnoteAcctData.exchangeRate = "";
            }
       });
        
        
        
        /**
         * Fetching Invoice Dropdown with AcctHead Code *****************************************************************
         */

       
        
    
        
     $scope.isFeederCompanyCurrency=false;
        
        $scope.currencyObj = {fromCurrency:0, toCurrency:0,exchangeRate:0.0}

      /*  $scope.$watch('creditnoteAcctData.accountName', function(newValue, oldValue) {
            debugger;
            if (newValue != '' && newValue != undefined) {
                $http.post('app/purchaseinvoice/getSupplierList', newValue).success(function(datas) {
                    console.log("supplier")
                    debugger;
                    $scope.supplierCur = datas;
                    $scope.creditnoteAcctData.currencyCode = $scope.supplierCur[0].currency;
                    $scope.creditnoteAcctData.exchangeRate=$scope.supplierCur[0].exchangeRate;
                    $scope.creditnoteAcctData.fromCurrency=$scope.supplierCur[0].fromCurrency;
                    $scope.creditnoteAcctData.toCurrency=$scope.supplierCur[0].toCurrency;
                    
                      
                    if($scope.supplierCur[0].isAgent != 'N' && $scope.supplierCur[0].isAgent != '' && $scope.supplierCur[0].isAgent != undefined && $scope.supplierCur[0].isAgent == 'Y' && $scope.isFeederCompanyCurrency)
                        $scope.isCurrencyBlocked=true;
                    else
                        $scope.isCurrencyBlocked=false;
                    if($scope.creditnoteAcctData.exchangeRate >= $scope.currencyObj.fromCurrency && 
                            $scope.creditnoteAcctData.exchangeRate <= $scope.currencyObj.toCurrency){
                        logger.logError("Please Enter Exchange Rate Between "+$scope.currencyObj.fromCurrency+" and "+
                                $scope.currencyObj.toCurrency);
                        $scope.creditnoteAcctData.exchangeRate='';
                    }                        
                    
                }).error(function(datas) {
                    logger.logError("Error Please Try Again");
                });
                
                $http.get('app/purchaseCreditNote/getInvoiceNo?acctHeadCode='+newValue).success(function(datas) {
                    console.log(datas);
                    if(datas.length>0){
                        $scope.invoiceNoList = datas;
                    }else{
                        $scope.creditnoteAcctData.invoiceDate = "";
                    }
                }).error(function(data) {
                });
            }else{
                $scope.invoiceNoList = [];
                $scope.creditnoteAcctData.invoiceDate = "";
                $scope.supplierCur = [];
                $scope.creditnoteAcctData.currencyCode = '';
                $scope.creditnoteAcctData.exchangeRate = '';
            }
       });
*/
        /**
         * fetch invoice date, currency code, exchange rate from invoice No  ***********************************************
         */
        
        
        
        
        
        

        $scope.$watch('creditnoteAcctData.invoiceNo', function(newValue, oldValue) {
            
            var invList =  $scope.invoiceNoList;
            if (newValue != '' && newValue != undefined) {
                angular.forEach(invList, function (item, key) {
                    if(newValue==invList[key].invoiceNo){
                        $scope.creditnoteAcctData.invoiceDate = invList[key].invoiceDate;
                        $scope.creditnoteAcctData.currencyCode = invList[key].currencyCode;
                        $scope.creditnoteAcctData.exchangeRate = invList[key].exgRate;
                    }
                 });

            }else{
                $scope.creditnoteAcctData.invoiceDate = "";
                $scope.creditnoteAcctData.currencyCode = "";
                $scope.creditnoteAcctData.exchangeRate = "";
            }
       });
        

       /* $scope.$watch('creditnoteAcctData.invoiceNo', function(newValue, oldValue) {
            var invList =  $scope.invoiceNoList;
            if (newValue != '' && newValue != undefined) {
                angular.forEach(invList, function (item, key) {
                    if(newValue==invList[key].invoiceNo){
                        $scope.creditnoteAcctData.invoiceDate = invList[key].invoiceDate;
                    }
                 });

            }else{
                $scope.creditnoteAcctData.invoiceDate = "";
            }
       }); 


        $scope.$watch('creditnoteAcctData.companyCode', function(newValue, oldValue) {
            
            if (newValue != '' && newValue != undefined) {
            $http.get('app/generalinvoice/getCompanyCurrency?CompanyCode='+newValue).success(function(datas) {
                $scope.companyCurrency=datas.CurrencyCode;
                }).error(function(datas) {
            });
            }
       });
        
        $scope.$watch('creditnoteAcctData.currencyCode', function(newValue, oldValue) {
            if(newValue!="" && newValue!=undefined && newValue!=null){
                $scope.creditnoteAcctData.credittables[0].currency=newValue;
                
                $http.get('app/commonUtility/getExchangeRateWithCurrency?currencyCode='+newValue).success(function(data){
                    if(data.success){
                        $scope.creditnoteAcctData.exchangeRate=data.exchangeRate;
                        $scope.creditnoteAcctData.fromCurrency=data.fromCurrency;
                        $scope.creditnoteAcctData.toCurrency=data.toCurrency;    
                        $scope.exchageratehdr(data.exchangeRate);
                    }else{
                        $scope.creditnoteAcctData.credittables[$scope.$index].exchangeRate='';
                    }                
                }).error(function(data) {
                });
            }
        });*/
        
        $scope.exchageratehdr=function(excahgerate){
            debugger;
            if(excahgerate>0){
                if(parseFloat(excahgerate) < $scope.creditnoteAcctData.fromCurrency || parseFloat(excahgerate) > $scope.creditnoteAcctData.toCurrency){
                    logger.logError("Please Enter Exchange Rate Between "+$scope.creditnoteAcctData.fromCurrency+" and "+
                            $scope.creditnoteAcctData.toCurrency);       
                    $scope.creditnoteAcctData.exchangeRate=0;
                }else{
                    if(isNaN(parseFloat($scope.creditnoteAcctData.tcAmount, 10))){                   
                        if(isNaN(parseFloat($scope.creditnoteAcctData.bcAmount, 10))){
                            var bcAmt = Math.floor(((isNaN(parseFloat( $scope.creditnoteAcctData.tcAmount, 10))?0: $scope.creditnoteAcctData.tcAmount) / parseFloat(excahgerate))*100)/100;
                            var tcAmt = Math.floor(((isNaN(parseFloat($scope.creditnoteAcctData.bcAmount, 10))?0:$scope.creditnoteAcctData.bcAmount) * parseFloat(excahgerate))*100)/100;
                            
                            $scope.creditnoteAcctData.tcAmount = parseFloat(tcAmt).toFixed(2);
                            $scope.creditnoteAcctData.bcAmount = parseFloat(bcAmt).toFixed(2);
                        }else{
                            var tcAmt = Math.floor(((isNaN(parseFloat($scope.creditnoteAcctData.bcAmount, 10))?0:$scope.creditnoteAcctData.bcAmount) * parseFloat(excahgerate))*100)/100;
                            $scope.creditnoteAcctData.tcAmount = parseFloat(tcAmt).toFixed(2);
                        }
                    }else {
                        var bcAmt = Math.floor(((isNaN(parseFloat( $scope.creditnoteAcctData.tcAmount, 10))?0: $scope.creditnoteAcctData.tcAmount) / parseFloat(excahgerate))*100)/100;
                        $scope.creditnoteAcctData.bcAmount = parseFloat(bcAmt).toFixed(2);
                    }
                } 
            }else{
                excahgerate=0;
                if(parseFloat(excahgerate) < $scope.creditnoteAcctData.fromCurrency || parseFloat(excahgerate) > $scope.creditnoteAcctData.toCurrency){
                    logger.logError("Please Enter Exchange Rate Between "+$scope.creditnoteAcctData.fromCurrency+" and "+
                            $scope.creditnoteAcctData.toCurrency);       
                    excahgerate=0;
                }else{
                    $scope.creditnoteAcctData.bcAmount = parseFloat(0).toFixed(2);
                }             
            }           
         }
        
        // BC to TC Amt on header
        $scope.amountCalculation= function(bcamount){
            if(bcamount!=undefined && bcamount!=0 && bcamount!=''){
                if($scope.creditnoteAcctData.tcAmount!=undefined && $scope.creditnoteAcctData.tcAmount!=0 && $scope.creditnoteAcctData.tcAmount!=""){
                    var tcAmount = Number(parseFloat($scope.creditnoteAcctData.tcAmount) /(parseFloat(bcamount)));
                    $scope.creditnoteAcctData.exchangeRate = parseFloat($scope.checkIsNaN(tcAmount)).toFixed(3);
                }
            else if($scope.creditnoteAcctData.exchangeRate!=undefined && $scope.creditnoteAcctData.exchangeRate!=0 && $scope.creditnoteAcctData.exchangeRate!=""){
                    var tcAmount = Number((parseFloat(bcamount) * $scope.creditnoteAcctData.exchangeRate));
                    $scope.creditnoteAcctData.tcAmount = parseFloat($scope.checkIsNaN(tcAmount)).toFixed(2);
                }else{
                    $scope.creditnoteAcctData.exchangeRate=1;
                    var bcAmount =Number((parseFloat(bcamount) * $scope.creditnoteAcctData.exchangeRate));
                    $scope.creditnoteAcctData.tcAmount = parseFloat($scope.checkIsNaN(bcAmount)).toFixed(2);
                }
            }
        
        }
        //TC to BC Amt on header
        $scope.amountLocalCalculation= function(tcAmount){
            if(tcAmount!=undefined){
                if($scope.creditnoteAcctData.exchangeRate!=0 && $scope.creditnoteAcctData.exchangeRate!=""){
                    var bcAmt = Number((parseFloat(tcAmount) / $scope.creditnoteAcctData.exchangeRate));
                    $scope.creditnoteAcctData.bcAmount = parseFloat($scope.checkIsNaN(bcAmt)).toFixed(2);
                }
                else{
                    $scope.creditnoteAcctData.exchangeRate=1.0;
                    var bcAmt =Number((parseFloat(tcAmount) / $scope.creditnoteAcctData.exchangeRate));
                    $scope.creditnoteAcctData.bcAmount = parseFloat($scope.checkIsNaN(bcAmt)).toFixed(2);
                }
            }else{
                $scope.creditnoteAcctData.bcAmount = 0;
            }               
        }
        

        $scope.checkIsNaN = function(value){
            if(isNaN(value))
                value = 0
                
            return value;
        }
         
        
        
        /**
         * Credit Note Detail Table ******************************************************************************************
         */


        $http.get('app/journalVoucher/getAccountHeadList').success(function(datas) {
            $scope.crdtlAcctHeadList = datas;
        }).error(function(data) {
        });

        
        $scope.tcamountCalculation= function(bcamount,index,row){
            
           // row.bcamount =parseFloat(bcamount);
            if($scope.creditnoteAcctData.exchangeRate!=0 && $scope.creditnoteAcctData.exchangeRate!=""){
                var tcAmt = (parseFloat(bcamount) * $scope.creditnoteAcctData.exchangeRate).toFixed(2);
                row.tcamount = tcAmt;
                $scope.totalAmountCalculation();
            }
            else{
                $scope.creditnoteAcctData.exchangeRate=1.0;
                var tcAmt = (parseFloat(bcamount) * $scope.creditnoteAcctData.exchangeRate).toFixed(2);
                row.tcamount = tcAmt;
                $scope.totalAmountCalculation();
            }

        }
        
        
        $scope.calcbcamount=function(exrate){
            if(exrate>0){
                angular.forEach(  $scope.creditnoteAcctData.credittables, function(row, index) {
                if(exrate!=0 && exrate!=""){
                    if(row.tcamount>0){
                    var bcAmt = (parseFloat(row.tcamount) / $scope.creditnoteAcctData.exchangeRate).toFixed(2);
                    row.bcamount = bcAmt;
                    $scope.totalAmountCalculation();
                    sharedProperties.getObject();

                    $scope.companyCode = $stateParams.companyCode;
                    console.log("companyCode in add ") 
                    console.log($scope.companyCode)
                     $scope.dataLoopCount = 0;
                     $scope.rowCollection = [];
                     $scope.displayedCollection = [];
                     $scope.itemsByPage = 10;
                     $scope.acctHeadList = [];
                     $scope.crdtlAcctHeadList = [];
                     $scope.invoiceNoList = [];
                     $scope.invoiceDetails=[];
                     $scope.companyDtlList = [];
                     $scope.validated = false;
                     $scope.creditnoteAcctData = {
                             accountName : '',  invoiceNo : '', invoiceDate :'', currencyCode : '', exchangeRate: '', creditNoteDate: '', validCreditNoteDate :'',
                             companyCode : '',company :'', narration: '',company_id_dtl :'',
                             credittables: []
                     };
                     $scope.creditnoteAcctData.credittables
                     $scope.edit =false;
                     $scope.supplierCur = [];
                     
                     $scope.currentURL=$location.protocol() + '://'+ $location.host() +':'+  $location.port()+"/#" +$location.path();
                     if(window.localStorage.getItem('pcn')==$scope.currentURL){
                         alert('window ' + $scope.currentURL + ' is already opened');
                        
                         setTimeout(window.close(),5000);
                         
                      }else{
                          window.localStorage.setItem('pcn', $scope.currentURL);
                      }
                     $(window).unload(function(){
                        
                          localStorage.removeItem('pcn');
                        });
                     /**
                      * datepicker ******************************************************************************************************
                      */
                      $('#cn_date').datetimepicker({
                         format : 'DD/MM/YYYY',
                         pickTime: false,
                         minDate: "01/01/2016",
                      });
                      
                      $('#inv_date').datetimepicker({
                          format : 'DD/MM/YYYY',
                          pickTime: false,
                          minDate: "01/01/2016",
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
                     $scope.creditnoteAcctData.creditNoteDate = today;
                     
                     $scope.checkDatesCL = function(cashbankPmtDate){
                             var res = $scope.creditnoteAcctData.creditNoteDate.split("/");
                             $http.get('app/cashbankreceipt/getloggedcompany?closingDate='+$scope.creditnoteAcctData.creditNoteDate).success(function(datas) {
                                 if(datas){
                                     logger.logError("Account closed for year "+ res[2]);
                                     $scope.creditnoteAcctData.creditNoteDate = today;
                                 }
                             })
                     }
                     
                     
                     $scope.checkdate = function() {
                         
                         var date = $scope.creditnoteAcctData.creditNoteDate;
                         var idate = $scope.creditnoteAcctData.invoiceDate
                         var pattern = /^(0[1-9]|[12][0-9]|3[01])[\- \/.](?:(0[1-9]|1[012])[\- \/.](19|20)[0-9]{2})$/;
                          if (!date.match(pattern)) {
                             $scope.creditnoteAcctData.creditNoteDate = "";
                             logger.logError("Date Format Should be DD/MM/YYYY !");
                             return false;
                         }else if(!idate.match(pattern)){
                             $scope.creditnoteAcctData.invoiceDate = "";
                             logger.logError("Date Format Should be DD/MM/YYYY !");
                             return false;
                         }
                         else{
                             return true;
                         }
                          
                     }
                     
                     
                
                  
                     /**
                      * Fetching Acct Head Dropdown Drop Down
                      */
                    /* $scope.getAcctHeadDropdown= function() {
                         $http.get('app/purchaseCreditNote/getAcctHeadCombo').success(function(datas) {
                             debugger;
                             console.log(datas);
                             if(datas.length>0){
                                 $scope.acctHeadList = datas;
                             }

                         }).error(function(data) {
                         });
                     };
                     $scope.getAcctHeadDropdown();*/

                     
                  // code added for attribute dropdown list
                   /*  $scope.getDropdownList= function() {
                         
                         $http.get('app/commonUtility/getCompanyList?formCode='+$('#form_code_id').val()).success(function(datas) {
                             debugger;
                             console.log($('#form_code_id').val());
                             $scope.companyList = datas;
                             $scope.companyDtlList =datas;
                             var foundItemDest = $filter('filter')($scope.companyList, { baseCompany:  1 })[0];
                             $scope.creditnoteAcctData.companyCode=foundItemDest.id;
                             }).error(function(datas) {
                         });
                         
                         $http.get('app/commonUtility/getVoyageList').success(function(datas) {
                             $scope.voyageList = datas;
                             $scope.voyageListt = datas;
                             }).error(function(datas) {
                             logger.logError("Error Please Try Again");
                         });
                         
                         $http.get('app/commonUtility/getVesselList').success(function(datas) {
                             $scope.vesselList = datas;
                             }).error(function(datas) {
                         });
                         
                         $http.get('app/commonUtility/getSectorList').success(function(datas) {
                             $scope.sectorList = datas;
                             }).error(function(datas) {
                         });
                         
                         $http.get('app/commonUtility/getEmployeeList').success(function(datas) {
                             $scope.employeeList = datas;
                             }).error(function(datas) {
                         });
                         
                         $http.get('app/commonUtility/getPortList').success(function(datas) {
                             $scope.portList = datas;
                             }).error(function(datas) {
                         });
                         
                         $http.get('app/commonUtility/getDepartmentList').success(function(datas) {
                             $scope.departmentList = datas;
                             }).error(function(datas) {
                         });
                         
                         $http.get('app/commonUtility/getAgentList').success(function(datas) {
                             $scope.agentList = datas;
                             }).error(function(datas) {
                         });
                         
                         $http.get('app/commonUtility/getCountryList').success(function(datas) {
                             $scope.countryList = datas;
                             }).error(function(datas) {
                         });
                         
                         $http.get('app/commonUtility/getCustomerList').success(function(datas) {
                             $scope.customerList = datas;
                             }).error(function(datas) {
                         });
                         
                         $http.get('app/commonUtility/getDesignationList').success(function(datas) {
                             $scope.designationList = datas;
                             }).error(function(datas) {
                         });
                         
                         $http.get('app/purchaseinvoice/getSupplierList').success(function(datas) {
                             $scope.supplierList = datas;
                             }).error(function(datas) {
                         });
                         
                         
                         $http.get('app/purchaseinvoice/getCurrencyList').success(function(datas) {
                             $scope.currencyList = datas;
                             }).error(function(datas) {
                         });
                         
                 }
                     $scope.getDropdownList();*/
                     /**
                      * Fetching Invoice Dropdown with AcctHead Code *****************************************************************
                      */

                    
                     
                 ;
                     
                  $scope.isFeederCompanyCurrency=false;
                     
                     $scope.currencyObj = {fromCurrency:0, toCurrency:0,exchangeRate:0.0}

                     $scope.$watch('creditnoteAcctData.accountName', function(newValue, oldValue) {
                         debugger;
                         if (newValue != '' && newValue != undefined) {
                             $http.post('app/purchaseinvoice/getSupplierList', newValue).success(function(datas) {
                                 console.log("supplier")
                                 debugger;
                                 $scope.supplierCur = datas;
                                 $scope.creditnoteAcctData.currencyCode = $scope.supplierCur[0].currency;
                                 $scope.creditnoteAcctData.exchangeRate=$scope.supplierCur[0].exchangeRate;
                                 $scope.creditnoteAcctData.fromCurrency=$scope.supplierCur[0].fromCurrency;
                                 $scope.creditnoteAcctData.toCurrency=$scope.supplierCur[0].toCurrency;
                                 
                                   
                                 if($scope.supplierCur[0].isAgent != 'N' && $scope.supplierCur[0].isAgent != '' && $scope.supplierCur[0].isAgent != undefined && $scope.supplierCur[0].isAgent == 'Y' && $scope.isFeederCompanyCurrency)
                                     $scope.isCurrencyBlocked=true;
                                 else
                                     $scope.isCurrencyBlocked=false;
                                 if($scope.creditnoteAcctData.exchangeRate >= $scope.currencyObj.fromCurrency && 
                                         $scope.creditnoteAcctData.exchangeRate <= $scope.currencyObj.toCurrency){
                                     logger.logError("Please Enter Exchange Rate Between "+$scope.currencyObj.fromCurrency+" and "+
                                             $scope.currencyObj.toCurrency);
                                     $scope.creditnoteAcctData.exchangeRate='';
                                 }                        
                                 
                             }).error(function(datas) {
                                 logger.logError("Error Please Try Again");
                             });
                             
                             $http.get('app/purchaseCreditNote/getInvoiceNo?acctHeadCode='+newValue).success(function(datas) {
                                 console.log(datas);
                                 if(datas.length>0){
                                     $scope.invoiceNoList = datas;
                                 }else{
                                     $scope.creditnoteAcctData.invoiceDate = "";
                                 }
                             }).error(function(data) {
                             });
                         }else{
                             $scope.invoiceNoList = [];
                             $scope.creditnoteAcctData.invoiceDate = "";
                             $scope.supplierCur = [];
                             $scope.creditnoteAcctData.currencyCode = '';
                             $scope.creditnoteAcctData.exchangeRate = '';
                         }
                    });

                     /**
                      * fetch invoice date, currency code, exchange rate from invoice No  ***********************************************
                      */
                     

                     $scope.$watch('creditnoteAcctData.invoiceNo', function(newValue, oldValue) {
                         var invList =  $scope.invoiceNoList;
                         if (newValue != '' && newValue != undefined) {
                             angular.forEach(invList, function (item, key) {
                                 if(newValue==invList[key].invoiceNo){
                                     $scope.creditnoteAcctData.invoiceDate = invList[key].invoiceDate;
                                 }
                              });

                         }else{
                             $scope.creditnoteAcctData.invoiceDate = "";
                         }
                    }); 


                     $scope.$watch('creditnoteAcctData.companyCode', function(newValue, oldValue) {
                         
                         if (newValue != '' && newValue != undefined) {
                         $http.get('app/generalinvoice/getCompanyCurrency?CompanyCode='+newValue).success(function(datas) {
                             $scope.companyCurrency=datas.CurrencyCode;
                             }).error(function(datas) {
                         });
                         }
                    });
                     
                     $scope.$watch('creditnoteAcctData.currencyCode', function(newValue, oldValue) {
                         if(newValue!="" && newValue!=undefined && newValue!=null){
                             $scope.creditnoteAcctData.credittables[0].currency=newValue;
                             
                             $http.get('app/commonUtility/getExchangeRateWithCurrency?currencyCode='+newValue).success(function(data){
                                 if(data.success){
                                     $scope.creditnoteAcctData.exchangeRate=data.exchangeRate;
                                     $scope.creditnoteAcctData.fromCurrency=data.fromCurrency;
                                     $scope.creditnoteAcctData.toCurrency=data.toCurrency;    
                                     $scope.exchageratehdr(data.exchangeRate);
                                 }else{
                                     $scope.creditnoteAcctData.credittables[$scope.$index].exchangeRate='';
                                 }                
                             }).error(function(data) {
                             });
                         }
                     });
                     
                     $scope.exchageratehdr=function(excahgerate){
                         debugger;
                         if(excahgerate>0){
                             if(parseFloat(excahgerate) < $scope.creditnoteAcctData.fromCurrency || parseFloat(excahgerate) > $scope.creditnoteAcctData.toCurrency){
                                 logger.logError("Please Enter Exchange Rate Between "+$scope.creditnoteAcctData.fromCurrency+" and "+
                                         $scope.creditnoteAcctData.toCurrency);       
                                 $scope.creditnoteAcctData.exchangeRate=0;
                             }else{
                                 if(isNaN(parseFloat($scope.creditnoteAcctData.tcAmount, 10))){                   
                                     if(isNaN(parseFloat($scope.creditnoteAcctData.bcAmount, 10))){
                                         var bcAmt = Math.floor(((isNaN(parseFloat( $scope.creditnoteAcctData.tcAmount, 10))?0: $scope.creditnoteAcctData.tcAmount) / parseFloat(excahgerate))*100)/100;
                                         var tcAmt = Math.floor(((isNaN(parseFloat($scope.creditnoteAcctData.bcAmount, 10))?0:$scope.creditnoteAcctData.bcAmount) * parseFloat(excahgerate))*100)/100;
                                         
                                         $scope.creditnoteAcctData.tcAmount = parseFloat(tcAmt).toFixed(2);
                                         $scope.creditnoteAcctData.bcAmount = parseFloat(bcAmt).toFixed(2);
                                     }else{
                                         var tcAmt = Math.floor(((isNaN(parseFloat($scope.creditnoteAcctData.bcAmount, 10))?0:$scope.creditnoteAcctData.bcAmount) * parseFloat(excahgerate))*100)/100;
                                         $scope.creditnoteAcctData.tcAmount = parseFloat(tcAmt).toFixed(2);
                                     }
                                 }else {
                                     var bcAmt = Math.floor(((isNaN(parseFloat( $scope.creditnoteAcctData.tcAmount, 10))?0: $scope.creditnoteAcctData.tcAmount) / parseFloat(excahgerate))*100)/100;
                                     $scope.creditnoteAcctData.bcAmount = parseFloat(bcAmt).toFixed(2);
                                 }
                             } 
                         }else{
                             excahgerate=0;
                             if(parseFloat(excahgerate) < $scope.creditnoteAcctData.fromCurrency || parseFloat(excahgerate) > $scope.creditnoteAcctData.toCurrency){
                                 logger.logError("Please Enter Exchange Rate Between "+$scope.creditnoteAcctData.fromCurrency+" and "+
                                         $scope.creditnoteAcctData.toCurrency);       
                                 excahgerate=0;
                             }else{
                                 $scope.creditnoteAcctData.bcAmount = parseFloat(0).toFixed(2);
                             }             
                         }           
                      }
                     
                     // BC to TC Amt on header
                     $scope.amountCalculation= function(bcamount){
                         if(bcamount!=undefined && bcamount!=0 && bcamount!=''){
                             if($scope.creditnoteAcctData.tcAmount!=undefined && $scope.creditnoteAcctData.tcAmount!=0 && $scope.creditnoteAcctData.tcAmount!=""){
                                 var tcAmount = Number(parseFloat($scope.creditnoteAcctData.tcAmount) /(parseFloat(bcamount)));
                                 $scope.creditnoteAcctData.exchangeRate = parseFloat($scope.checkIsNaN(tcAmount)).toFixed(3);
                             }
                         else if($scope.creditnoteAcctData.exchangeRate!=undefined && $scope.creditnoteAcctData.exchangeRate!=0 && $scope.creditnoteAcctData.exchangeRate!=""){
                                 var tcAmount = Number((parseFloat(bcamount) * $scope.creditnoteAcctData.exchangeRate));
                                 $scope.creditnoteAcctData.tcAmount = parseFloat($scope.checkIsNaN(tcAmount)).toFixed(2);
                             }else{
                                 $scope.creditnoteAcctData.exchangeRate=1;
                                 var bcAmount =Number((parseFloat(bcamount) * $scope.creditnoteAcctData.exchangeRate));
                                 $scope.creditnoteAcctData.tcAmount = parseFloat($scope.checkIsNaN(bcAmount)).toFixed(2);
                             }
                         }
                     
                     }
                     //TC to BC Amt on header
                     $scope.amountLocalCalculation= function(tcAmount){
                         if(tcAmount!=undefined){
                             if($scope.creditnoteAcctData.exchangeRate!=0 && $scope.creditnoteAcctData.exchangeRate!=""){
                                 var bcAmt = Number((parseFloat(tcAmount) / $scope.creditnoteAcctData.exchangeRate));
                                 $scope.creditnoteAcctData.bcAmount = parseFloat($scope.checkIsNaN(bcAmt)).toFixed(2);
                             }
                             else{
                                 $scope.creditnoteAcctData.exchangeRate=1.0;
                                 var bcAmt =Number((parseFloat(tcAmount) / $scope.creditnoteAcctData.exchangeRate));
                                 $scope.creditnoteAcctData.bcAmount = parseFloat($scope.checkIsNaN(bcAmt)).toFixed(2);
                             }
                         }else{
                             $scope.creditnoteAcctData.bcAmount = 0;
                         }               
                     }
                     

                     $scope.checkIsNaN = function(value){
                         if(isNaN(value))
                             value = 0
                             
                         return value;
                     }
                      
                     
                     
                     /**
                      * Credit Note Detail Table ******************************************************************************************
                      */


                     $http.get('app/invoice/lpo/getAccountList').success(function(datas) {
                         $scope.crdtlAcctHeadList = datas;
                     }).error(function(data) {
                     });

                     
                     $scope.tcamountCalculation= function(bcamount,index,row){
                         
                        // row.bcamount =parseFloat(bcamount);
                         if($scope.creditnoteAcctData.exchangeRate!=0 && $scope.creditnoteAcctData.exchangeRate!=""){
                             var tcAmt = (parseFloat(bcamount) * $scope.creditnoteAcctData.exchangeRate).toFixed(2);
                             row.tcamount = tcAmt;
                             $scope.totalAmountCalculation();
                         }
                         else{
                             $scope.creditnoteAcctData.exchangeRate=1.0;
                             var tcAmt = (parseFloat(bcamount) * $scope.creditnoteAcctData.exchangeRate).toFixed(2);
                             row.tcamount = tcAmt;
                             $scope.totalAmountCalculation();
                         }

                     }
                     
                     
                     $scope.calcbcamount=function(exrate){
                         if(exrate>0){
                             angular.forEach(  $scope.creditnoteAcctData.credittables, function(row, index) {
                             if(exrate!=0 && exrate!=""){
                                 if(row.tcamount>0){
                                 var bcAmt = (parseFloat(row.tcamount) / $scope.creditnoteAcctData.exchangeRate).toFixed(2);
                                 row.bcamount = bcAmt;
                                 $scope.totalAmountCalculation();
                             }
                             }
                             else{
                                 $scope.creditnoteAcctData.exchangeRate=1.0;
                                 var bcAmt = (parseFloat(row.tcamount) / $scope.creditnoteAcctData.exchangeRate).toFixed(2);
                                 row.bcamount = bcAmt;
                                 $scope.totalAmountCalculation();
                             }
                             });
                         }
                        
                      }
                     
                      
                     
                     $scope.bcamountCalculation= function(tcamount,index,row){
                         
                        // row.tcamount =parseFloat(tcamount);
                         if($scope.creditnoteAcctData.exchangeRate!=0 && $scope.creditnoteAcctData.exchangeRate!=""){
                             var bcAmt = (parseFloat(tcamount) / $scope.creditnoteAcctData.exchangeRate).toFixed(2);
                             row.bcamount = bcAmt;
                             $scope.totalAmountCalculation();
                         }
                         else{
                             $scope.creditnoteAcctData.exchangeRate=1.0;
                             var bcAmt = (parseFloat(tcamount) / $scope.creditnoteAcctData.exchangeRate).toFixed(2);
                             row.bcamount = bcAmt;
                             $scope.totalAmountCalculation();
                         }

                     }
                     
                     
                     $scope.amountCalculationBCTable= function(bcAmount,index,row){
                         if(bcAmount!=undefined && bcAmount!=0 && bcAmount!=''){
                             if(row.tcAmount!=undefined && row.tcAmount!=0 && row.tcAmount!=""){
                                 var tcAmount = Number((parseFloat(row.tcAmount)/parseFloat(bcAmount)));
                                 row.exchangeRate = parseFloat($scope.checkIsNaN(tcAmount)).toFixed(3);
                                 $scope.calculateTotalAmount($scope.creditnoteAcctData.credittables);
                             }
                             else if(row.exchangeRate!=undefined && row.exchangeRate!=0 && row.exchangeRate!=""){
                                 var tcAmount = Number((parseFloat(bcAmount) * row.exchangeRate));
                                 row.tcAmount = parseFloat($scope.checkIsNaN(tcAmount)).toFixed(3);
                                 $scope.calculateTotalAmount($scope.creditnoteAcctData.credittables);
                             }else{
                                 $scope.creditnoteAcctData.exchangeRate=1;
                                 var bcAmount = Number((parseFloat(bcAmount) * row.exchangeRate));
                                 row.tcAmount = parseFloat($scope.checkIsNaN(bcAmount)).toFixed(3);
                                 $scope.calculateTotalAmount($scope.creditnoteAcctData.credittables);
                             }
                         }
                      }

                      
                      
                      //tc to bc amt on detail
                      $scope.amountCalculationTCTable= function(tcAmount,index,row){
                          //row.bcAmount = Math.floor((parseFloat(tcamount, 10) / parseFloat(row.exchangeRate))*100)/100
                          //$scope.calculateTotalAmount($scope.creditnoteAcctData.credittables);
                          
                          if(row.exchangeRate!=0 && row.exchangeRate!=""){
                              var bcAmt = Number((parseFloat(tcAmount) / row.exchangeRate));
                              row.bcAmount = parseFloat($scope.checkIsNaN(bcAmt)).toFixed(2);
                              $scope.calculateTotalAmount($scope.creditnoteAcctData.credittables);
                          }
                          else{
                              row.exchangeRate=1.0;
                              var bcAmt  = Number((parseFloat(tcAmount) / row.exchangeRate));
                              row.bcAmount = parseFloat($scope.checkIsNaN(bcAmt)).toFixed(2);
                              $scope.calculateTotalAmount($scope.creditnoteAcctData.credittables);
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
                               
                                  $scope.calculateTotalAmount($scope.creditnoteAcctData.credittables);
                              }
                              
                          }else{
                              row.bcAmount = 0;
                              $scope.calculateTotalAmount($scope.creditnoteAcctData.credittables);
                          }
                      }
                      
                      $scope.calculateTotalAmount = function(credittables){
                          var totalBCAmount=0.0,totalTCAmount=0.0;
                          angular.forEach(credittables, function(row, index) {
                              totalBCAmount = totalBCAmount+parseFloat(row.bcAmount);
                              totalTCAmount = totalTCAmount+parseFloat(row.tcAmount);
                          });
                          $scope.totalTCAmount = totalTCAmount.toFixed(2);
                          $scope.totalBCAmount = totalBCAmount.toFixed(2);
                      };
                      
                      
                      $scope.logValidExgRateErrorMessage = "";
                      
                      $scope.validateExchangeRate = function(creditnoteAcctData){
                          debugger;
                          var HdrLogErrMessage="",DtlLogErrMessage = "",loggerMsg="", isFlag=true;
                          if(parseFloat(creditnoteAcctData.exchangeRate) < creditnoteAcctData.fromCurrency 
                                  || parseFloat(creditnoteAcctData.exchangeRate) > creditnoteAcctData.toCurrency){
                              HdrLogErrMessage="Header: Please Enter Exchange Rate Between "+creditnoteAcctData.fromCurrency+" and "+
                              creditnoteAcctData.toCurrency+"<br><br>";      
                              creditnoteAcctData.exchangeRate=0;
                              isFlag = false;
                            
                          }
                          var pinLength= creditnoteAcctData.credittables.length;
                          if(pinLength>0){
                              angular.forEach(creditnoteAcctData.credittables,function(row,index){
                              
                                  if(parseFloat(row.exchangeRate) < row.fromCurrency 
                                          || parseFloat(row.exchangeRate) > row.toCurrency){
                                      if(DtlLogErrMessage==""){
                                          DtlLogErrMessage = "Row "+row.siNo+" : Please Enter Exchange Rate Between "+row.fromCurrency+" and "+
                                          row.toCurrency+"<br>";      
                                 
                                          row.exchangeRate=0;
                                          
                                      }else{
                                          DtlLogErrMessage += "Row "+row.siNo+" : Please Enter Exchange Rate Between "+row.fromCurrency+" and "+
                                          row.toCurrency;
                                          
                                          row.exchangeRate=0;                           
                                      }                       
                                  }
                              });   
                              loggerMsg = HdrLogErrMessage+DtlLogErrMessage;
                              if(loggerMsg !=""){
                                  isFlag = false;
                                  $scope.logValidExgRateErrorMessage = loggerMsg;                   
                              }                   
                          }         
                          
                          return isFlag;
                      }
                      
                     
                     $scope.$watch('creditnoteAcctData.credittables[trIndex].subAccountCode', function(newValue, oldValue) {
                         if (newValue != '' && newValue != undefined) {
                             if($scope.creditnoteAcctData.credittables[$scope.$index].crdtlAccountHead == '20010001' || 
                                     $scope.creditnoteAcctData.credittables[$scope.$index].crdtlAccountHead=='10120001' ||
                                     $scope.creditnoteAcctData.credittables[$scope.$index].crdtlAccountHead=='20010002'){
                                 $http.get('app/commonUtility/getSupplierCurrency?supplierCode='+newValue).success(function(data) {
                                     if(data.success){
                                         $scope.creditnoteAcctData.credittables[$scope.$index].currency=data.currencyCode;
                                         if(data.isAgent =='Y' && $scope.creditnoteAcctData.credittables[$scope.$index].companyCode == 'C0001')
                                             $scope.creditnoteAcctData.credittables[$scope.$index].isCurrencyBlocked=true;
                                         else
                                             $scope.creditnoteAcctData.credittables[$scope.$index].isCurrencyBlocked=false;
                                     }else{
                                         $scope.creditnoteAcctData.credittables[$scope.$index].isCurrencyBlocked=false;
                                     }
                                 }).error(function(data) {
                                 });
                             }else{
                                 $scope.creditnoteAcctData.credittables[$scope.$index].isCurrencyBlocked=false;
                             }
                         }else{
                             
                         }
                     });   
                     
                     $scope.$watch('creditnoteAcctData.credittables[trIndex].currency', function(newValue, oldValue) {
                         if (newValue != '' && newValue != undefined) {
                             // get exchange rate for currency
                             /*$http.get('app/commonUtility/getDefaultExchangeRate?currencyCode='+newValue).success(function(data)*/
                             $http.get('app/commonUtility/getExchangeRateWithCurrency?currencyCode='+newValue).success(function(data){
                                 if(data.success){
                                     $scope.creditnoteAcctData.credittables[$scope.$index].fromCurrency=data.fromCurrency;
                                     $scope.creditnoteAcctData.credittables[$scope.$index].toCurrency=data.toCurrency;
                                     $scope.creditnoteAcctData.credittables[$scope.$index].exchangeRate=data.exchangeRate;
                                     
                                     $scope.amountCalculationexchange(data.exchangeRate,[$scope.$index],$scope.creditnoteAcctData.credittables[$scope.$index]);
                                 }else{
                                     $scope.creditnoteAcctData.credittables[$scope.$index].exchangeRate='';
                                 }                
                             }).error(function(data) {
                             });
                         }
                     });
                     /**
                      * load Credit Note Detail Table ******************************************
                      */
                     $scope.loadCrTable = function() {
                           var crtable = {};

                           crtable = {
                               select : '',
                               slNo:1,
                               crdtlAccountHead : '',
                               subAcctCode : '',
                               narration : '',
                               bcamount : '',
                               tcamount : '',
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
                               approvedSign:'',
                               quantityGO:'',
                               quantityFO:'',
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
                               
                                   
                           };

                           $scope.creditnoteAcctData.credittables.push(crtable);

                       }
                       //add Row - detail table
                       $scope.addCredRow = function(tables) {
                         var len = tables.length;
                         var table = {
                             select : '',
                             slNo:1,
                             crdtlAccountHead : '',
                             subAcctCode : '',
                             narration : '',
                             bcamount : '',
                             tcamount : '',
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
                             
                         };
                         table.slNo = len+1;
                         tables.push(table);
                       };
                       $scope.loadCrTable();

                       //remove Row - detail table
                       $scope.removeCredRow = function(table) {
                           $scope.tablerow = [];
                           angular.forEach(table, function(row, index) {
                               var check = row.select;
                               if (check == undefined || check == "") {
                                   $scope.tablerow.push(row);
                               } else {
                               }
                           });
                           angular.forEach($scope.tablerow,function(row,index){              
                              row.slNo=index+1;             
                           });
                           $scope.creditnoteAcctData.credittables = $scope.tablerow;
                           $scope.totalAmountCalculation();
                       };

                    // Injector
                       
                      /* $scope.validateDate = function(testDate) {
                           var date_regex = /^\d{2}\/\d{2}\/\d{4}$/ ;
                           return date_regex.test(testDate);
                       }*/

                      /* $scope.submit = function(purchaseCreditNoteForm) {
                           
                           //$scope.creditnoteAcctData.creditNoteDate = $('#creditNoteDate').val();
                           if (new validationService().checkFormValidity($scope.purchaseCreditNoteForm)) {
                               //if($scope.validateDate()){
                                   $scope.save();
                               //}
                           } else {
                               toaster.pop('error', "Please fill the required fields", 
                                       logger.getErrorHtmlNew($scope.purchaseCreditNoteForm.$validationSummary), 5000, 'trustedHtml');
                           }
                       };

                       $scope.error = function(message) {
                           console.log('Error ' + message);
                           console.log(sharedProperties);
                           console.log(sharedProperties.getErrorObject());
                           logger.logErrorHtml(sharedProperties.getErrorObject());
                       };
                       
                      
                       
                       $scope.save = function() {
                           var a = $scope.validateDate($scope.creditnoteAcctData.creditNoteDate)
                           if($scope.edit==false){
                              if(a){
                                   var isExgRateValid = $scope.validateExchangeRate($scope.creditnoteAcctData);
                                   if(isExgRateValid){
                                       if((parseFloat($scope.totalBCAmount)==parseFloat($scope.creditnoteAcctData.bcAmount))){
                                    
                                  $http.post('app/purchaseCreditNote/save', $scope.creditnoteAcctData).success(function(result) {
                                       if(result) {
                                           logger.logSuccess("Saved successfully!");
                                           $location.path('/transaction/purchasecreditNotelist/list');
                                       } else {
                                           logger.logError("Purchase Credit Note Code Already Exist!");
                                       }
                                   }).error(function(result) {
                                       console.log("data" + result);
                                   });
                                       }
                                       else 
                                           logger.logError("Amount Should Be Same");
                                   }else{
                                       logger.logError($scope.logValidExgRateErrorMessage);
                                   }
                              }else{
                                  logger.logError("Date format should be dd/mm/yyyy");
                                  $scope.creditnoteAcctData.creditNoteDate = '';
                              }
                              
                           }else{
                               console.log("creditnoteMasterData ON UPDATE :::::::::::::::::::"+creditCode );
                               console.log($scope.creditnoteAcctData);
                               $scope.creditnoteAcctData.creditNoteCode =creditCode;
                               $http.post('app/purchaseCreditNote/update', $scope.creditnoteAcctData).success(function(result) {
                                   console.log("result:::::::app/purchaseCreditNote/Update:::::::::::");
                                   console.log(result);
                                   if(result) {
                                       logger.logSuccess("Updated successfully!");
                                       $location.path('/transaction/purchasecreditNotelist/list');
                                   } else {
                                       logger.logError("Purchase Credit Note Code Already Exist!");
                                   }
                               }).error(function(result) {
                                   console.log("data" + result);
                               });
                           }

                       };*/
                       /**
                        * total Amount Calculation - calculate from credit note detail table..
                        */
                       $scope.totalAmountCalculation = function(){
                           var crDtlRowDatas = $scope.creditnoteAcctData.credittables;
                           var bcAmt=0,tcAmt=0;
                           angular.forEach(crDtlRowDatas, function (item, key) {
                               bcAmt += parseFloat(crDtlRowDatas[key].bcamount);
                               tcAmt += parseFloat(crDtlRowDatas[key].tcamount);
                               $scope.creditnoteAcctData.totalBCAmount=bcAmt.toFixed(2);
                               $scope.creditnoteAcctData.totalTCAmount=tcAmt.toFixed(2);
                              
                            });

                       }


                       $scope.cancel = function() {
                           $state.go('app.hospital.accounts.purchaseCreditNote.list');
                       };

                    
                      var creditCode = $location.search().creditCode;

                      console.log('creditCode :::::::::::::::::');
                      console.log(creditCode);
                     
                     
                      if (creditCode != undefined) {
                          var formData=new FormData();
                          formData.append("creditCode", creditCode);
                          $scope.edit = true;
                          $http.get('app/purchaseCreditNote/getCreditNoteForEdit?creditCode=' + creditCode).success(function(data) {
                              console.log('Edit Data:::::::::::::::::');
                              console.log(data);
                              $scope.acctHeadList = data.acctHeadList;
                              $scope.invoiceNoList = data.invoiceList;
                              $scope.creditnoteAcctData = data;             
                              $scope.totalAmountCalculation();
                          }).error(function(data) {
                              logger.logError("Unable to Get Data");
                          });

                      } else {
                          $scope.edit = false;
                      }
                      
                      $scope.isOwner = false;
                      $scope.checkOwner = function(){
                          $http.get('app/cashbankreceipt/checkOwnerUser').success(function(data) {
                                  console.log("owner")
                                  console.log(data)
                                  $scope.isOwner = data;
                          });
                      }
                      $scope.checkOwner();
                      
                       
                 
                }
                }
                else{
                    $scope.creditnoteAcctData.exchangeRate=1.0;
                    var bcAmt = (parseFloat(row.tcamount) / $scope.creditnoteAcctData.exchangeRate).toFixed(2);
                    row.bcamount = bcAmt;
                    $scope.totalAmountCalculation();
                }
                });
            }
           
         }
        
         
        
        $scope.bcamountCalculation= function(tcamount,index,row){
            
           // row.tcamount =parseFloat(tcamount);
            if($scope.creditnoteAcctData.exchangeRate!=0 && $scope.creditnoteAcctData.exchangeRate!=""){
                var bcAmt = (parseFloat(tcamount) / $scope.creditnoteAcctData.exchangeRate).toFixed(2);
                row.bcamount = bcAmt;
                $scope.totalAmountCalculation();
            }
            else{
                $scope.creditnoteAcctData.exchangeRate=1.0;
                var bcAmt = (parseFloat(tcamount) / $scope.creditnoteAcctData.exchangeRate).toFixed(2);
                row.bcamount = bcAmt;
                $scope.totalAmountCalculation();
            }

        }
        
        
        $scope.amountCalculationBCTable= function(bcAmount,index,row){
            if(bcAmount!=undefined && bcAmount!=0 && bcAmount!=''){
                if(row.tcAmount!=undefined && row.tcAmount!=0 && row.tcAmount!=""){
                    var tcAmount = Number((parseFloat(row.tcAmount)/parseFloat(bcAmount)));
                    row.exchangeRate = parseFloat($scope.checkIsNaN(tcAmount)).toFixed(3);
                    $scope.calculateTotalAmount($scope.creditnoteAcctData.credittables);
                }
                else if(row.exchangeRate!=undefined && row.exchangeRate!=0 && row.exchangeRate!=""){
                    var tcAmount = Number((parseFloat(bcAmount) * row.exchangeRate));
                    row.tcAmount = parseFloat($scope.checkIsNaN(tcAmount)).toFixed(3);
                    $scope.calculateTotalAmount($scope.creditnoteAcctData.credittables);
                }else{
                    $scope.creditnoteAcctData.exchangeRate=1;
                    var bcAmount = Number((parseFloat(bcAmount) * row.exchangeRate));
                    row.tcAmount = parseFloat($scope.checkIsNaN(bcAmount)).toFixed(3);
                    $scope.calculateTotalAmount($scope.creditnoteAcctData.credittables);
                }
            }
         }

         
         
         //tc to bc amt on detail
         $scope.amountCalculationTCTable= function(tcAmount,index,row){
             //row.bcAmount = Math.floor((parseFloat(tcamount, 10) / parseFloat(row.exchangeRate))*100)/100
             //$scope.calculateTotalAmount($scope.creditnoteAcctData.credittables);
             
             if(row.exchangeRate!=0 && row.exchangeRate!=""){
                 var bcAmt = Number((parseFloat(tcAmount) / row.exchangeRate));
                 row.bcAmount = parseFloat($scope.checkIsNaN(bcAmt)).toFixed(2);
                 $scope.calculateTotalAmount($scope.creditnoteAcctData.credittables);
             }
             else{
                 row.exchangeRate=1.0;
                 var bcAmt  = Number((parseFloat(tcAmount) / row.exchangeRate));
                 row.bcAmount = parseFloat($scope.checkIsNaN(bcAmt)).toFixed(2);
                 $scope.calculateTotalAmount($scope.creditnoteAcctData.credittables);
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
                  
                     $scope.calculateTotalAmount($scope.creditnoteAcctData.credittables);
                 }
                 
             }else{
                 row.bcAmount = 0;
                 $scope.calculateTotalAmount($scope.creditnoteAcctData.credittables);
             }
         }
         
         $scope.calculateTotalAmount = function(credittables){
             var totalBCAmount=0.0,totalTCAmount=0.0;
             angular.forEach(credittables, function(row, index) {
                 totalBCAmount = totalBCAmount+parseFloat(row.bcAmount);
                 totalTCAmount = totalTCAmount+parseFloat(row.tcAmount);
             });
             $scope.totalTCAmount = totalTCAmount.toFixed(2);
             $scope.totalBCAmount = totalBCAmount.toFixed(2);
         };
         
         
         $scope.logValidExgRateErrorMessage = "";
         
         $scope.validateExchangeRate = function(creditnoteAcctData){
             debugger;
             var HdrLogErrMessage="",DtlLogErrMessage = "",loggerMsg="", isFlag=true;
             if(parseFloat(creditnoteAcctData.exchangeRate) < creditnoteAcctData.fromCurrency 
                     || parseFloat(creditnoteAcctData.exchangeRate) > creditnoteAcctData.toCurrency){
                 HdrLogErrMessage="Header: Please Enter Exchange Rate Between "+creditnoteAcctData.fromCurrency+" and "+
                 creditnoteAcctData.toCurrency+"<br><br>";      
                 creditnoteAcctData.exchangeRate=0;
                 isFlag = false;
               
             }
             var pinLength= creditnoteAcctData.credittables.length;
             if(pinLength>0){
                 angular.forEach(creditnoteAcctData.credittables,function(row,index){
                 
                     if(parseFloat(row.exchangeRate) < row.fromCurrency 
                             || parseFloat(row.exchangeRate) > row.toCurrency){
                         if(DtlLogErrMessage==""){
                             DtlLogErrMessage = "Row "+row.siNo+" : Please Enter Exchange Rate Between "+row.fromCurrency+" and "+
                             row.toCurrency+"<br>";      
                    
                             row.exchangeRate=0;
                             
                         }else{
                             DtlLogErrMessage += "Row "+row.siNo+" : Please Enter Exchange Rate Between "+row.fromCurrency+" and "+
                             row.toCurrency;
                             
                             row.exchangeRate=0;                           
                         }                       
                     }
                 });   
                 loggerMsg = HdrLogErrMessage+DtlLogErrMessage;
                 if(loggerMsg !=""){
                     isFlag = false;
                     $scope.logValidExgRateErrorMessage = loggerMsg;                   
                 }                   
             }         
             
             return isFlag;
         }
         
        
        $scope.$watch('creditnoteAcctData.credittables[trIndex].subAccountCode', function(newValue, oldValue) {
            if (newValue != '' && newValue != undefined) {
                if($scope.creditnoteAcctData.credittables[$scope.$index].crdtlAccountHead == '20010001' || 
                        $scope.creditnoteAcctData.credittables[$scope.$index].crdtlAccountHead=='10120001' ||
                        $scope.creditnoteAcctData.credittables[$scope.$index].crdtlAccountHead=='20010002'){
                    $http.get('app/commonUtility/getSupplierCurrency?supplierCode='+newValue).success(function(data) {
                        if(data.success){
                            $scope.creditnoteAcctData.credittables[$scope.$index].currency=data.currencyCode;
                            if(data.isAgent =='Y' && $scope.creditnoteAcctData.credittables[$scope.$index].companyCode == 'C0001')
                                $scope.creditnoteAcctData.credittables[$scope.$index].isCurrencyBlocked=true;
                            else
                                $scope.creditnoteAcctData.credittables[$scope.$index].isCurrencyBlocked=false;
                        }else{
                            $scope.creditnoteAcctData.credittables[$scope.$index].isCurrencyBlocked=false;
                        }
                    }).error(function(data) {
                    });
                }else{
                    $scope.creditnoteAcctData.credittables[$scope.$index].isCurrencyBlocked=false;
                }
            }else{
                
            }
        });   
        
        $scope.$watch('creditnoteAcctData.credittables[trIndex].currency', function(newValue, oldValue) {
            if (newValue != '' && newValue != undefined) {
                // get exchange rate for currency
                /*$http.get('app/commonUtility/getDefaultExchangeRate?currencyCode='+newValue).success(function(data)*/
                $http.get('app/commonUtility/getExchangeRateWithCurrency?currencyCode='+newValue).success(function(data){
                    if(data.success){
                        $scope.creditnoteAcctData.credittables[$scope.$index].fromCurrency=data.fromCurrency;
                        $scope.creditnoteAcctData.credittables[$scope.$index].toCurrency=data.toCurrency;
                        $scope.creditnoteAcctData.credittables[$scope.$index].exchangeRate=data.exchangeRate;
                        
                        $scope.amountCalculationexchange(data.exchangeRate,[$scope.$index],$scope.creditnoteAcctData.credittables[$scope.$index]);
                    }else{
                        $scope.creditnoteAcctData.credittables[$scope.$index].exchangeRate='';
                    }                
                }).error(function(data) {
                });
            }
        });
        /**
         * load Credit Note Detail Table ******************************************
         */
        $scope.loadCrTable = function() {
              var crtable = {};

              crtable = {
                  select : '',
                  slNo:1,
                  crdtlAccountHead : '',
                  subAcctCode : '',
                  narration : '',
                  bcamount : '',
                  tcamount : '',
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
                  approvedSign:'',
                  quantityGO:'',
                  quantityFO:'',
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
                  
                      
              };

              $scope.creditnoteAcctData.credittables.push(crtable);

          }
          //add Row - detail table
          $scope.addCredRow = function(tables) {
            var len = tables.length;
            var table = {
                select : '',
                slNo:1,
                crdtlAccountHead : '',
                subAcctCode : '',
                narration : '',
                bcamount : '',
                tcamount : '',
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
                
            };
            table.slNo = len+1;
            tables.push(table);
          };
          $scope.loadCrTable();

          //remove Row - detail table
          $scope.removeCredRow = function(table) {
              $scope.tablerow = [];
              angular.forEach(table, function(row, index) {
                  var check = row.select;
                  if (check == undefined || check == "") {
                      $scope.tablerow.push(row);
                  } else {
                  }
              });
              angular.forEach($scope.tablerow,function(row,index){              
                 row.slNo=index+1;             
              });
              $scope.creditnoteAcctData.credittables = $scope.tablerow;
              $scope.totalAmountCalculation();
          };

       // Injector
          
          $scope.validateDate = function(testDate) {
              var date_regex = /^\d{2}\/\d{2}\/\d{4}$/ ;
              return date_regex.test(testDate);
          }
          $scope.submit = function() {
              
              //$scope.creditnoteAcctData.creditNoteDate = $('#creditNoteDate').val();
              if (new validationService().checkFormValidity($scope.purchaseCreditNoteForm)) {
                  //if($scope.validateDate()){
                      $scope.save();
                  //}
              } else {
                  toaster.pop('error', "Please fill the required fields", 
                          logger.getErrorHtmlNew($scope.purchaseCreditNoteForm.$validationSummary), 5000, 'trustedHtml');
              }
          };


          $scope.error = function(message) {
              console.log('Error ' + message);
              console.log(sharedProperties);
              console.log(sharedProperties.getErrorObject());
              logger.logErrorHtml(sharedProperties.getErrorObject());
          };
          
         
          
          $scope.save = function() {
              var a = $scope.validateDate($scope.creditnoteAcctData.creditNoteDate)
              if($scope.edit==false){
                 if(a){
                      var isExgRateValid = $scope.validateExchangeRate($scope.creditnoteAcctData);
                      if(isExgRateValid){
                          if((parseFloat($scope.totalBCAmount)==parseFloat($scope.creditnoteAcctData.bcAmount))){
                       
                     $http.post('app/purchasecreditnote/save', $scope.creditnoteAcctData).success(function(result) {
                          if(result) {
                              logger.logSuccess("Saved successfully!");
                              $location.path('/hospital/accounts/purchaseCreditNote/purchaseCreditNoteList');
                          } else {
                              logger.logError("Purchase Credit Note Code Already Exist!");
                          }
                      }).error(function(result) {
                          console.log("data" + result);
                      });
                          }
                          else 
                              logger.logError("Amount Should Be Same");
                      }else{
                          logger.logError($scope.logValidExgRateErrorMessage);
                      }
                 }else{
                     logger.logError("Date format should be dd/mm/yyyy");
                     $scope.creditnoteAcctData.creditNoteDate = '';
                 }
                 
              }else{
                  console.log("creditnoteMasterData ON UPDATE :::::::::::::::::::"+creditCode );
                  console.log($scope.creditnoteAcctData);
                  $scope.creditnoteAcctData.creditNoteCode =creditCode;
                  $http.post('app/purchaseCreditNote/update', $scope.creditnoteAcctData).success(function(result) {
                      console.log("result:::::::app/purchaseCreditNote/Update:::::::::::");
                      console.log(result);
                      if(result) {
                          logger.logSuccess("Updated successfully!");
                          $location.path('/transaction/purchasecreditNotelist/list');
                      } else {
                          logger.logError("Purchase Credit Note Code Already Exist!");
                      }
                  }).error(function(result) {
                      console.log("data" + result);
                  });
              }

          };
          /**
           * total Amount Calculation - calculate from credit note detail table..
           */
          $scope.totalAmountCalculation = function(){
              var crDtlRowDatas = $scope.creditnoteAcctData.credittables;
              var bcAmt=0,tcAmt=0;
              angular.forEach(crDtlRowDatas, function (item, key) {
                  bcAmt += parseFloat(crDtlRowDatas[key].bcamount);
                  tcAmt += parseFloat(crDtlRowDatas[key].tcamount);
                  $scope.creditnoteAcctData.totalBCAmount=bcAmt.toFixed(2);
                  $scope.creditnoteAcctData.totalTCAmount=tcAmt.toFixed(2);
                 
               });

          }


          $scope.cancel = function() {
              $state.go('app.hospital.accounts.purchaseCreditNote.list');
          };

       
         var creditCode = $location.search().creditCode;

         console.log('creditCode :::::::::::::::::');
         console.log(creditCode);
        
        
         if (creditCode != undefined) {
             var formData=new FormData();
             formData.append("creditCode", creditCode);
             $scope.edit = true;
             $http.get('app/purchaseCreditNote/getCreditNoteForEdit?creditCode=' + creditCode).success(function(data) {
                 console.log('Edit Data:::::::::::::::::');
                 console.log(data);
                 $scope.acctHeadList = data.acctHeadList;
                 $scope.invoiceNoList = data.invoiceList;
                 $scope.creditnoteAcctData = data;             
                 $scope.totalAmountCalculation();
             }).error(function(data) {
                 logger.logError("Unable to Get Data");
             });

         } else {
             $scope.edit = false;
         }
         
         $scope.isOwner = false;
         $scope.checkOwner = function(){
             $http.get('app/cashbankreceipt/checkOwnerUser').success(function(data) {
                     console.log("owner")
                     console.log(data)
                     $scope.isOwner = data;
             });
         }
         $scope.checkOwner();
          
    });

/*


    app.controller('purchasecreditNoteCtrlView', function($scope, $window, $rootScope, $location, $http, logger, $log, ngDialog, 
            $modal, utilsService,sharedProperties,$state,$injector,ListService,$stateParams) {

        sharedProperties.getObject();

        $scope.dataLoopCount = 0;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.acctHeadList = [];
        $scope.crdtlAcctHeadList = [];
        $scope.invoiceNoList = [];
        $scope.invoiceDetails=[];
        $scope.companyDtlList = [];
        $scope.validated = false;
        $scope.creditnoteAcctData = {
                accountName : '',  invoiceNo : '', invoiceDate :'', currencyCode : '', exchangeRate: '', creditNoteDate: '', validCreditNoteDate :'',
                companyCode : '',company :'', narration: '',totalBCAmount:'',totalTCAmount :'',companyCurrency:'',company_id_dtl :'',
                credittables: []
        };
        
        $scope.edit =false;
        $scope.pending=false;
        $scope.isView = false;
        *//**
         * datepicker ******************************************************************************************************
         *//*
         $('#cn_date').datetimepicker({
            format : 'DD/MM/YYYY'
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
        $scope.creditnoteAcctData.creditNoteDate = today;
        $scope.creditnoteAcctData.approvedSign='';
        
        $scope.tcamountCalculation= function(bcamount,index,row){
            
            row.bcamount =parseFloat(bcamount);
            if($scope.creditnoteAcctData.exchangeRate!=0 && $scope.creditnoteAcctData.exchangeRate!=""){
                var tcAmt = (parseFloat(bcamount) * $scope.creditnoteAcctData.exchangeRate).toFixed(2);
                row.tcamount = tcAmt;
                $scope.totalAmountCalculation();
            }
            else{
                $scope.creditnoteAcctData.exchangeRate=1.0;
                var tcAmt = (parseFloat(bcamount) * $scope.creditnoteAcctData.exchangeRate).toFixed(2);
                row.tcamount = tcAmt;
                $scope.totalAmountCalculation();
            }

        }
        
        $scope.bcamountCalculation= function(tcamount,index,row){
            
            row.tcamount =parseFloat(tcamount);
            if($scope.creditnoteAcctData.exchangeRate!=0 && $scope.creditnoteAcctData.exchangeRate!=""){
                var bcAmt = (parseFloat(tcamount) / $scope.creditnoteAcctData.exchangeRate).toFixed(2);
                row.bcamount = bcAmt;
                $scope.totalAmountCalculation();
            }
            else{
                $scope.creditnoteAcctData.exchangeRate=1.0;
                var bcAmt = (parseFloat(tcamount) / $scope.creditnoteAcctData.exchangeRate).toFixed(2);
                row.bcamount = bcAmt;
                $scope.totalAmountCalculation();
            }

        }
        *//**
         * load Credit Note Detail Table ******************************************
         *//*
        $scope.loadCrTable = function() {
              var crtable = {};

              crtable = {
                  select : '',
                  slNo:1,
                  crdtlAccountHead : '',
                  subAcctCode : '',
                  subAcctName : '',
                  narration : '',
                  bcamount : '',
                  tcamount : '',
                  voyageCode : '',
                  vesselCode : '',
                  vesselName : '',
                  sectorCode : '',
                  sectorName : '',
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
                  approvedSign:'',
                  quantityGO:'',
                  quantityFO:'',
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
                  
                      
              };

              $scope.creditnoteAcctData.credittables.push(crtable);

          }
          //add Row - detail table
          $scope.addCredRow = function(tables) {
            var len = tables.length;
            var table = {
                select : '',
                slNo:1,
                crdtlAccountHead : '',
                subAcctCode : '',
                narration : '',
                bcamount : '',
                tcamount : '',
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
                
            };
            table.slNo = len+1;
            tables.push(table);
          };
          $scope.loadCrTable();

          //remove Row - detail table
          $scope.removeCredRow = function(table) {
              $scope.tablerow = [];
              angular.forEach(table, function(row, index) {
                  var check = row.select;
                  if (check == undefined || check == "") {
                      $scope.tablerow.push(row);
                  } else {
                  }
              });
              angular.forEach($scope.tablerow,function(row,index){              
                 row.slNo=index+1;             
              });
              $scope.creditnoteAcctData.credittables = $scope.tablerow;
              $scope.totalAmountCalculation();
          };

      
          *//**
           * total Amount Calculation - calculate from credit note detail table..
           *//*
          $scope.totalAmountCalculation = function(){
              var crDtlRowDatas = $scope.creditnoteAcctData.credittables;
              var bcAmt=0,tcAmt=0;
              angular.forEach(crDtlRowDatas, function (item, key) {
                  bcAmt += parseFloat(crDtlRowDatas[key].bcamount);
                  tcAmt += parseFloat(crDtlRowDatas[key].tcamount);
                  $scope.creditnoteAcctData.totalBCAmount=bcAmt.toFixed(2);
                  $scope.creditnoteAcctData.totalTCAmount=tcAmt.toFixed(2);
               });

          }


          $scope.cancel = function() {
              $state.go('app.finance.transaction.purchasecreditNotelist.list');
          };

     
         var creditCode = $location.search().creditCode;
         
         var creditCodePending = $location.search().creditPendingCode;

         console.log('creditCode :::::::::::::::::');
         console.log(creditCode);
         
         if(creditCode==undefined){
             creditCode = $stateParams.creditCode;
         }
         
         if(creditCodePending!=undefined){
             $scope.pending = true;
             creditCode = creditCodePending;
         }
         
         
         // Edit function
         var purchasecreditCode = $location.search().purchasecreditCode;
         $scope.getPendingRecordDetails=function(purchasecreditCode){
            if (purchasecreditCode != undefined) {
                $scope.isView  = true;
                var formData=new FormData();
                 formData.append("creditCode", purchasecreditCode);
                $http.get('app/purchaseCreditNote/getCreditNoteForView?creditCode=' + purchasecreditCode).success(function(data) {
                     console.log('View Data:::::::::::::::::');
                     console.log(data);
                     $scope.creditnoteAcctData = data;   
                     $scope.totalAmountCalculation();
                }).error(function(data) {
                     logger.logError("Unable to Get Data");
                 });

             } else {
                 $scope.edit = false;
             }
         }
         
         $scope.getPendingRecordDetails(purchasecreditCode);
         
         $scope.isApproval;
         
         
         
         $scope.creditNodeList=[];
         
         
         
         // Getting pending node list
         
         $scope.offsetCount = 0;
         $scope.limitCount = 1000;
         $scope.isreject=false;
         
         $scope.getCreditNoteListUtil = function() {
             $scope.rowCollection=[];
             var start = new Date().getTime();
             var url = 'app/purchaseCreditNote/cnlist?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount;
             $http.get(url).success(function(data) {
                 console.log("data::::::::::getCreditNoteListUtil:::::::::");
                 console.log(data);
                 if (data.success == true) {
                     $scope.pushCreditNoteListUtil(data);
                     $scope.dataLoopCount++;
                 } else {
                     if ($scope.dataLoopCount == 0) {
                         $scope.showEmptyLabel = true;
                     }
                     logger.logError("Error Please Try Again");
                 }
                 var end = new Date().getTime();
                 var time = end - start;
                 console.log('Execution time: ' + time);
             }).error(function(data) {
                 logger.logError("Error Please Try Again");
             });

         };
         $scope.pushCreditNoteListUtil = function(data) {
             if (utilsService.isUndefinedOrNull(data.lCreditNoteBean)) {
                 $scope.showEmptyLabel = true;
             } else {
                 $scope.rowCollection = $scope.rowCollection.concat(data.lCreditNoteBean);
                 $scope.approve($scope.rowCollection);
             }
         };

         $scope.selectedrow=[];
         
         $scope.approve = function(rowCollection){
             $scope.selectedrow=[]
             console.log("rowCollection");
             console.log(rowCollection);
             if($scope.pending){
                 var isPending=false;
                 angular.forEach(rowCollection, function(row, index) {
                     var check =row.approveStatus;
                     if (check =="N") {
                         console.log("isrecord");
                         console.log(row);
                         isPending=true;
                         $scope.selectedrow.push(row);
                     }
                 });
                 
             }

         }
         
         $scope.checkboxModel = {
                 value1 : true,
                 value2 : false
               };
         
         $scope.checkboxModel.value1='YES'
             
      
        $scope.printDiv = function(creditCode) {
            var url = 'app/purchaseCreditNote/print?creditCode=' + creditCode;
            var wnd = window.open(url, 'Simatech', 'height=400,width=750,top=100,left=100,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
            wnd.print();
       
         }
       
         
    });
*/

    app.service("ListService",function($http,$q){

        this.getDateInDDMMYYYY=function convert(str) {
            var date = new Date(str),
                mnth = ("0" + (date.getMonth()+1)).slice(-2),
                day  = ("0" + date.getDate()).slice(-2);
            return [ day, mnth, date.getFullYear() ].join("/");
        }
    });

    module.registerController('tableCtrl', function($scope,$http, $filter,logger,$timeout){
        $scope.$watch('creditnoteAcctData.credittables[trIndex].company_id_dtl', function(newValue, oldValue) {
            if (newValue != '' && newValue != undefined) {
                $scope.creditnoteAcctData.credittables[$scope.$index].crdtlAccountHead = '';
            }
        });
        
        $scope.$watch('creditnoteAcctData.credittables[trIndex].voyageCode', function(newValue, oldValue) {
            debugger;
            if (newValue != '' && newValue != undefined) {
                    $http.get('app/commonUtility/getVesselService?voyageCode='+newValue).success(function(datas) {
                        $scope.creditnoteAcctData.credittables[$scope.$index].vesselCode=datas.vesselCode;
                        $scope.creditnoteAcctData.credittables[$scope.$index].sectorCode=datas.sectorCode;
                        }).error(function(datas) {
                    });
           
            }
        });
       /* 
        $scope.$watch('creditnoteAcctData.credittables[trIndex].crdtlAccountHead', function(newValue, oldValue) 
                {
            if (newValue != '' && newValue != undefined) {
               
                $scope.creditnoteAcctData.credittables[$scope.$index].isCurrencyBlocked=false;
                if(newValue == '10080001'){
                    $http.get('app/commonUtility/getSubAccountCodeListTradeDebtors').success(function(datas) {
                        $scope.creditnoteAcctData.credittables[$scope.$index].subAccountCodeList = datas;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isSubAccountCode =true;
                        }).error(function(datas) {
                    });
                }
                
                
                else if (newValue == '10070002' || newValue == '10120001' || newValue == '20010001' || newValue == '10090017' || newValue == '10070004' || newValue == '10040007' || newValue == '10040008') {
                    $http.get('app/commonUtility/tradecreditorslist').success(function(datas) {
                        $scope.creditnoteAcctData.credittables[$scope.$index].subAccountCodeList = datas;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isSubAccountCode = true;
                    }).error(function(datas) {
                    });
                }
                else if(newValue == '20010001' || newValue=='10120001' || newValue=='10070004' || newValue=='10090017'|| newValue=='10070002'){
                    $http.get('app/commonUtility/getSubAccountCodeListTradeCreditors').success(function(datas) {
                        $scope.creditnoteAcctData.credittables[$scope.$index].subAccountCodeList = datas;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isSubAccountCode=true;
                        }).error(function(datas) {
                    });   
                }
                else if(newValue == '10070001'){
                    
                    if($scope.creditnoteAcctData.credittables[$scope.$index].company_id_dtl == 'C0003')
                        $scope.currencyList = [{id:'SGD',text:'SGD'}];
                    $http.get('app/accounthead/getCurrencyList').success(function(datas) {
                  //  $http.get('app/commonUtility/getStaffListForAdvances').success(function(datas) {
                        $scope.creditnoteAcctData.credittables[$scope.$index].subAccountCodeList = datas;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isSubAccountCode=true;
                        }).error(function(datas) {
                    });   
                }
                
                
             else if(newValue == '20010004'){
                    $http.get('app/commonUtility/getJvPartnerAccount').success(function(datas) {
                        $scope.creditnoteAcctData.credittables[$scope.$index].subAccountCodeList = datas;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isSubAccountCode=true;
                        }).error(function(datas) {
                    });   
                }else if(newValue == '20010002'){
                    $http.get('app/commonUtility/getAgentList').success(function(datas) {
                        $scope.creditnoteAcctData.credittables[$scope.$index].subAccountCodeList = datas;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isSubAccountCode=true;
                        }).error(function(datas) {
                    });   
                }
                
                else if (newValue == '10050001' || newValue == '10050002' || newValue == '50020002' || newValue == '50020001') {
                    $scope.creditnoteAcctData.credittables[$scope.$index].isSubAccountCode = true;

                    $http.get('app/commonUtility/getVessel').success(function(datas) {

                        $scope.creditnoteAcctData.credittables[$scope.$index].subAccountCodeList = datas;
                    }).error(function(datas) {
                    });
                } else if(newValue == '10090017' || newValue=='10050001'){
                    $http.get('app/commonUtility/getonlySupplier').success(function(datas) {
                        $scope.creditnoteAcctData.credittables[$scope.$index].subAccountCodeList = datas;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isSubAccountCode=true;
                        }).error(function(datas) {
                    });   
                }else{
                    $scope.creditnoteAcctData.credittables[$scope.$index].subAccountCodeList=[];
                    $scope.creditnoteAcctData.credittables[$scope.$index].isSubAccountCode=false;
                }
            
                if(newValue.substring(0, 4)=='1000'){
                    $scope.creditnoteAcctData.credittables[$scope.$index].isAsset=true;
                    $http.get('app/commonUtility/getassetList').success(function(datas) {
                        debugger;
                        $scope.creditnoteAcctData.credittables[$scope.$index].assetList = datas;
                        }).error(function(datas) {
                    });
                }
                
                $scope.creditnoteAcctData.credittables[$scope.$index].isVoyage=false;
                $scope.creditnoteAcctData.credittables[$scope.$index].isVessel=false;
                $scope.creditnoteAcctData.credittables[$scope.$index].isService=false;
                
             // code added for mandatory
                $scope.creditnoteAcctData.credittables[$scope.$index].isVoyageMan=false;
                $scope.creditnoteAcctData.credittables[$scope.$index].isVesselMan=false;
                $scope.creditnoteAcctData.credittables[$scope.$index].isServiceMan=false;
                
                    $http.get('app/commonUtility/getAttributesList?accountCode='+newValue).success(function(datas) {
                    $scope.creditnoteAcctData.credittables[$scope.$index].attributeList=datas;
                    if(newValue==oldValue){
                        $scope.isOnChange =false;
                    }else{
                        $scope.isOnChange =true;
                    }
                    if(!$scope.edit || $scope.isOnChange){
                        
                    $scope.creditnoteAcctData.credittables[$scope.$index].voyageCode='';
                    $scope.creditnoteAcctData.credittables[$scope.$index].vesselCode='';
                    $scope.creditnoteAcctData.credittables[$scope.$index].sectorCode='';
                    $scope.creditnoteAcctData.credittables[$scope.$index].employeeCode='';
                    $scope.creditnoteAcctData.credittables[$scope.$index].portCode='';
                    $scope.creditnoteAcctData.credittables[$scope.$index].portSequence='';
                    $scope.creditnoteAcctData.credittables[$scope.$index].departmentCode='';
                    $scope.creditnoteAcctData.credittables[$scope.$index].agentCode='';
                    $scope.creditnoteAcctData.credittables[$scope.$index].countryCode='';
                    $scope.creditnoteAcctData.credittables[$scope.$index].customerCode='';
                    $scope.creditnoteAcctData.credittables[$scope.$index].supplierCode='';
                    $scope.creditnoteAcctData.credittables[$scope.$index].designationCode='';
                    $scope.creditnoteAcctData.credittables[$scope.$index].costCenter='';
                    $scope.creditnoteAcctData.credittables[$scope.$index].companyCode='';
                    $scope.creditnoteAcctData.credittables[$scope.$index].quantityGO='';
                    $scope.creditnoteAcctData.credittables[$scope.$index].quantityFO='';
                    }
                    
                    $scope.creditnoteAcctData.credittables[$scope.$index].isVoyage=false;
                    $scope.creditnoteAcctData.credittables[$scope.$index].isVessel=false;
                    $scope.creditnoteAcctData.credittables[$scope.$index].isService=false;
                    $scope.creditnoteAcctData.credittables[$scope.$index].isEmployee=false;
                    $scope.creditnoteAcctData.credittables[$scope.$index].isPort=false;
                    $scope.creditnoteAcctData.credittables[$scope.$index].isDepartment=false;
                    $scope.creditnoteAcctData.credittables[$scope.$index].isAgent=false;
                    $scope.creditnoteAcctData.credittables[$scope.$index].isLocation=false;
                    $scope.creditnoteAcctData.credittables[$scope.$index].isCustomer=false;
                    $scope.creditnoteAcctData.credittables[$scope.$index].isSupplier=false;
                    $scope.creditnoteAcctData.credittables[$scope.$index].isDesignation=false;
                    $scope.creditnoteAcctData.credittables[$scope.$index].isCostCenter=false;
                    $scope.creditnoteAcctData.credittables[$scope.$index].isCompany=false;
                    $scope.creditnoteAcctData.credittables[$scope.$index].isQuantityGO=false;
                    $scope.creditnoteAcctData.credittables[$scope.$index].isQuantityFO=false;
                    $scope.creditnoteAcctData.credittables[$scope.$index].isPortSequence=false;
                 
                    angular.forEach($scope.creditnoteAcctData.credittables[$scope.$index].attributeList, function(row, rowindex) {
                        
                        if(row.attributeName == "Voyage"){
                            $scope.creditnoteAcctData.credittables[$scope.$index].isVoyage=true;
                        }else if(row.attributeName == "Vessel"){
                            $scope.creditnoteAcctData.credittables[$scope.$index].isVessel=true;
                        }else if(row.attributeName == "Service"){
                            $scope.creditnoteAcctData.credittables[$scope.$index].isService=true;
                        }else if(row.attributeName == "Employee"){
                            $scope.creditnoteAcctData.credittables[$scope.$index].isEmployee=true;
                        }else if(row.attributeName == "Port"){
                            $scope.creditnoteAcctData.credittables[$scope.$index].isPort=true;
                        }else if(row.attributeName == "Department"){
                            $scope.creditnoteAcctData.credittables[$scope.$index].isDepartment=true;
                        }else if(row.attributeName == "Agent"){
                            $scope.creditnoteAcctData.credittables[$scope.$index].isAgent=true;
                        }else if(row.attributeName == "Location"){
                            $scope.creditnoteAcctData.credittables[$scope.$index].isLocation=true;
                        }else if(row.attributeName == "Customer"){
                            $scope.creditnoteAcctData.credittables[$scope.$index].isCustomer=true;
                        }else if(row.attributeName == "Supplier"){
                            $scope.creditnoteAcctData.credittables[$scope.$index].isSupplier=true;
                        }else if(row.attributeName == "Designation"){
                            $scope.creditnoteAcctData.credittables[$scope.$index].isDesignation=true;
                        }else if(row.attributeName == "Cost Center"){
                            $scope.creditnoteAcctData.credittables[$scope.$index].isCostCenter=true;
                        }else if(row.attributeName == "Company"){
                            $scope.creditnoteAcctData.credittables[$scope.$index].isCompany=true;
                        }else if(row.attributeName == "Quantity (MT) GO"){
                            $scope.creditnoteAcctData.credittables[$scope.$index].isQuantityGO=true;
                        }else if(row.attributeName == "Quantity (MT) FO"){
                            $scope.creditnoteAcctData.credittables[$scope.$index].isQuantityFO=true;
                        }else if(row.attributeName == "Port with Sequence"){
                            $scope.creditnoteAcctData.credittables[$scope.$index].isPortSequence=true;
                        }
                        });
                    }).error(function(datas) {
                });
                
                $http.get('app/commonUtility/getAttributesList?accountCode='+newValue).success(function(datas) {
                    $scope.creditnoteAcctData.credittables[$scope.$index].attributeList=datas;
                    if(newValue==oldValue){
                        $scope.isOnChange =false;
                    }else{
                        $scope.isOnChange =true;
                    }
                    if(!$scope.isView || $scope.isOnChange){
                       
                    $scope.creditnoteAcctData.credittables[$scope.$index].voyageCode='';
                    $scope.creditnoteAcctData.credittables[$scope.$index].vesselCode='';
                    $scope.creditnoteAcctData.credittables[$scope.$index].sectorCode='';
                    $scope.creditnoteAcctData.credittables[$scope.$index].employeeCode='';
                    $scope.creditnoteAcctData.credittables[$scope.$index].portCode='';
                    $scope.creditnoteAcctData.credittables[$scope.$index].portSequence='';
                    $scope.creditnoteAcctData.credittables[$scope.$index].departmentCode='';
                    $scope.creditnoteAcctData.credittables[$scope.$index].agentCode='';
                    $scope.creditnoteAcctData.credittables[$scope.$index].countryCode='';
                    $scope.creditnoteAcctData.credittables[$scope.$index].customerCode='';
                    $scope.creditnoteAcctData.credittables[$scope.$index].supplierCode='';
                    $scope.creditnoteAcctData.credittables[$scope.$index].designationCode='';
                    $scope.creditnoteAcctData.credittables[$scope.$index].costCenter='';
                    $scope.creditnoteAcctData.credittables[$scope.$index].companyCode='';
                    $scope.creditnoteAcctData.credittables[$scope.$index].quantityGO='';
                    $scope.creditnoteAcctData.credittables[$scope.$index].quantityFO='';
                    }
                    
                    if(!$scope.edit || $scope.isOnChange){
                        
                        $scope.creditnoteAcctData.credittables[$scope.$index].voyageCode='';
                        $scope.creditnoteAcctData.credittables[$scope.$index].vesselCode='';
                        $scope.creditnoteAcctData.credittables[$scope.$index].sectorCode='';
                        $scope.creditnoteAcctData.credittables[$scope.$index].employeeCode='';
                        $scope.creditnoteAcctData.credittables[$scope.$index].portCode='';
                        $scope.creditnoteAcctData.credittables[$scope.$index].portSequence='';
                        $scope.creditnoteAcctData.credittables[$scope.$index].departmentCode='';
                        $scope.creditnoteAcctData.credittables[$scope.$index].agentCode='';
                        $scope.creditnoteAcctData.credittables[$scope.$index].countryCode='';
                        $scope.creditnoteAcctData.credittables[$scope.$index].customerCode='';
                        $scope.creditnoteAcctData.credittables[$scope.$index].supplierCode='';
                        $scope.creditnoteAcctData.credittables[$scope.$index].designationCode='';
                        $scope.creditnoteAcctData.credittables[$scope.$index].costCenter='';
                       
                        $scope.creditnoteAcctData.credittables[$scope.$index].quantityGO='';
                        $scope.creditnoteAcctData.credittables[$scope.$index].quantityFO='';
                        }
                        
                        $scope.creditnoteAcctData.credittables[$scope.$index].isVoyage=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isVessel=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isService=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isEmployee=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isPort=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isDepartment=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isAgent=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isLocation=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isCustomer=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isSupplier=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isDesignation=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isCostCenter=false;
                        // commented for inter-company transaction
                        $scope.creditnoteAcctData.credittables[$scope.$index].isCompany=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isQuantityGO=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isQuantityFO=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isPortSequence=false;
                        
                        // code added for mandatory
                        $scope.creditnoteAcctData.credittables[$scope.$index].isVoyageMan=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isVesselMan=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isServiceMan=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isEmployeeMan=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isPortMan=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isDepartmentMan=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isAgentMan=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isLocationMan=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isCustomerMan=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isSupplierMan=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isDesignationMan=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isCostCenterMan=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isQuantityGOMan=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isQuantityFOMan=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isPortSequenceMan=false;
                 
                      angular.forEach($scope.creditnoteAcctData.credittables[$scope.$index].attributeList, function(row, rowindex) {
                        debugger;
                        if(row.attributeName == "Voyage"){
                            if(newValue == '60040001'){
                                $scope.creditnoteAcctData.credittables[$scope.$index].isVoyage=true;
                                $scope.creditnoteAcctData.credittables[$scope.$index].isVoyageMan=false;
                            }else{
                                $scope.creditnoteAcctData.credittables[$scope.$index].isVoyage=true;
                                //$scope.creditnoteAcctData.credittables[$scope.$index].isVoyageMan=true;
                           // }
                            if(row.isMandatory == 'Y' && $scope.creditnoteAcctData.credittables[$scope.$index].company_id_dtl != 'C0002'){
                                if($scope.isOwner)
                                    $scope.creditnoteAcctData.credittables[$scope.$index].isVoyageMan=false;
                                else
                                    $scope.creditnoteAcctData.credittables[$scope.$index].isVoyageMan=true;
                            }
                        }else if(row.attributeName == "Vessel"){
                            if(newValue == '60040001'){
                                $scope.creditnoteAcctData.credittables[$scope.$index].isVessel=true;
                                $scope.creditnoteAcctData.credittables[$scope.$index].isVesselMan=false;
                            }else{
                                $scope.creditnoteAcctData.credittables[$scope.$index].isVessel=true;
                               // $scope.creditnoteAcctData.credittables[$scope.$index].isVesselMan=true;
                            //}
                            if(row.isMandatory == 'Y' &&$scope.creditnoteAcctData.credittables[$scope.$index].company_id_dtl != 'C0002'){
                                if($scope.isOwner)
                                    $scope.creditnoteAcctData.credittables[$scope.$index].isVesselMan=false;
                                else
                                    $scope.creditnoteAcctData.credittables[$scope.$index].isVesselMan=true;
                            }
                        }else if(row.attributeName == "Service"){
                            if(newValue == '60040001'){
                                $scope.creditnoteAcctData.credittables[$scope.$index].isService=true;
                                $scope.creditnoteAcctData.credittables[$scope.$index].isServiceMan=false;
                            }else{
                                $scope.creditnoteAcctData.credittables[$scope.$index].isService=true;
                                //$scope.creditnoteAcctData.credittables[$scope.$index].isServiceMan=true;
                            //}
                            if(row.isMandatory == 'Y' &&$scope.creditnoteAcctData.credittables[$scope.$index].company_id_dtl != 'C0002'){
                                if($scope.isOwner)
                                    $scope.creditnoteAcctData.credittables[$scope.$index].isServiceMan=false;
                                else
                                    $scope.creditnoteAcctData.credittables[$scope.$index].isServiceMan=true;
                            }
                        }else if(row.attributeName == "Employee"){
                           $scope.creditnoteAcctData.credittables[$scope.$index].isEmployee=true;
                            if(row.isMandatory == 'Y' &&$scope.creditnoteAcctData.credittables[$scope.$index].company_id_dtl == 'C0001'){
                                if($scope.isOwner)
                                    $scope.creditnoteAcctData.credittables[$scope.$index].isEmployeeMan=false;
                                else
                                    $scope.creditnoteAcctData.credittables[$scope.$index].isEmployeeMan=true;
                            }
                        }else if(row.attributeName == "Port"){
                               $scope.creditnoteAcctData.credittables[$scope.$index].isPort=true;
                            if(row.isMandatory == 'Y' &&$scope.creditnoteAcctData.credittables[$scope.$index].company_id_dtl == 'C0001'){
                                if($scope.isOwner)
                                    $scope.creditnoteAcctData.credittables[$scope.$index].isPortMan=false;
                                else
                                    $scope.creditnoteAcctData.credittables[$scope.$index].isPortMan=true;
                            }
                        }else if(row.attributeName == "Department"){
                           $scope.creditnoteAcctData.credittables[$scope.$index].isDepartment=true;
                            if(row.isMandatory == 'Y' &&$scope.creditnoteAcctData.credittables[$scope.$index].company_id_dtl == 'C0001'){
                                if($scope.isOwner)
                                    $scope.creditnoteAcctData.credittables[$scope.$index].isDepartmentMan=false;
                                else
                                    $scope.creditnoteAcctData.credittables[$scope.$index].isDepartmentMan=true;
                            }
                        }else if(row.attributeName == "Agent"){
                           $scope.creditnoteAcctData.credittables[$scope.$index].isAgent=true;
                            if(row.isMandatory == 'Y' &&$scope.creditnoteAcctData.credittables[$scope.$index].company_id_dtl == 'C0001'){
                                if($scope.isOwner)
                                    $scope.creditnoteAcctData.credittables[$scope.$index].isAgentMan=false;
                                else
                                    $scope.creditnoteAcctData.credittables[$scope.$index].isAgentMan=true;
                            }
                        }else if(row.attributeName == "Location"){
                           $scope.creditnoteAcctData.credittables[$scope.$index].isLocation=true;
                            if(row.isMandatory == 'Y' &&$scope.creditnoteAcctData.credittables[$scope.$index].company_id_dtl == 'C0001'){
                                if($scope.isOwner)
                                    $scope.creditnoteAcctData.credittables[$scope.$index].isLocationMan=false;
                                else
                                    $scope.creditnoteAcctData.credittables[$scope.$index].isLocationMan=true;
                            }
                        }else if(row.attributeName == "Customer"){
                           $scope.creditnoteAcctData.credittables[$scope.$index].isCustomer=true;
                            if(row.isMandatory == 'Y' &&$scope.creditnoteAcctData.credittables[$scope.$index].company_id_dtl == 'C0001'){
                                if($scope.isOwner)
                                    $scope.creditnoteAcctData.credittables[$scope.$index].isCustomerMan=false;
                                else
                                    $scope.creditnoteAcctData.credittables[$scope.$index].isCustomerMan=true;
                            }
                        }else if(row.attributeName == "Supplier"){
                           $scope.creditnoteAcctData.credittables[$scope.$index].isSupplier=true;
                            if(row.isMandatory == 'Y' &&$scope.creditnoteAcctData.credittables[$scope.$index].company_id_dtl == 'C0001'){
                                if($scope.isOwner)
                                    $scope.creditnoteAcctData.credittables[$scope.$index].isSupplierMan=false;
                                else
                                    $scope.creditnoteAcctData.credittables[$scope.$index].isSupplierMan=true;
                            }
                        }else if(row.attributeName == "Designation"){
                           $scope.creditnoteAcctData.credittables[$scope.$index].isDesignation=true;
                            if(row.isMandatory == 'Y' &&$scope.creditnoteAcctData.credittables[$scope.$index].company_id_dtl == 'C0001'){
                                if($scope.isOwner)
                                    $scope.creditnoteAcctData.credittables[$scope.$index].isDesignationMan=false;
                                else
                                    $scope.creditnoteAcctData.credittables[$scope.$index].isDesignationMan=true;
                            }
                        }else if(row.attributeName == "Cost Center"){
                           $scope.creditnoteAcctData.credittables[$scope.$index].isCostCenter=true;
                            if(row.isMandatory == 'Y' &&$scope.creditnoteAcctData.credittables[$scope.$index].company_id_dtl == 'C0001'){
                                if($scope.isOwner)
                                    $scope.creditnoteAcctData.credittables[$scope.$index].isCostCenterMan=false;
                                else
                                    $scope.creditnoteAcctData.credittables[$scope.$index].isCostCenterMan=true;
                            }
                        }else if(row.attributeName == "Company"){
                           $scope.creditnoteAcctData.credittables[$scope.$index].isCompany=true;
                            if(row.isMandatory == 'Y' &&$scope.creditnoteAcctData.credittables[$scope.$index].company_id_dtl == 'C0001'){
                                if($scope.isOwner)
                                    $scope.creditnoteAcctData.credittables[$scope.$index].isCompanyMan=false;
                                else
                                    $scope.creditnoteAcctData.credittables[$scope.$index].isCompanyMan=true;
                            }
                        }else if(row.attributeName == "Quantity (MT) GO"){
                           $scope.creditnoteAcctData.credittables[$scope.$index].isQuantityGO=true;
                            if(row.isMandatory == 'Y' &&$scope.creditnoteAcctData.credittables[$scope.$index].company_id_dtl == 'C0001'){
                                if($scope.isOwner)
                                    $scope.creditnoteAcctData.credittables[$scope.$index].isQuantityGOMan=false;
                                else
                                    $scope.creditnoteAcctData.credittables[$scope.$index].isQuantityGOMan=true;
                            }
                        }else if(row.attributeName == "Quantity (MT) FO"){
                           $scope.creditnoteAcctData.credittables[$scope.$index].isQuantityFO=true;
                            if(row.isMandatory == 'Y' &&$scope.creditnoteAcctData.credittables[$scope.$index].company_id_dtl == 'C0001'){
                                if($scope.isOwner)
                                    $scope.creditnoteAcctData.credittables[$scope.$index].isQuantityFOMan=false;
                                else
                                    $scope.creditnoteAcctData.credittables[$scope.$index].isQuantityFOMan=true;
                            }
                        }else if(row.attributeName == "Port with Sequence"){
                           $scope.creditnoteAcctData.credittables[$scope.$index].isPortSequence=true;
                            if(row.isMandatory == 'Y' &&$scope.creditnoteAcctData.credittables[$scope.$index].company_id_dtl == 'C0001'){
                                if($scope.isOwner)
                                    $scope.creditnoteAcctData.credittables[$scope.$index].isPortSequenceMan=false;
                                else
                                    $scope.creditnoteAcctData.credittables[$scope.$index].isPortSequenceMan=true;
                            }
                        }else if(row.attributeName == "From Date"){
                           $scope.creditnoteAcctData.credittables[$scope.$index].isFromDate=true;
                        }else if(row.attributeName == "To Date"){
                           $scope.creditnoteAcctData.credittables[$scope.$index].isToDate=true;
                        }
                        });
                      
                    }).error(function(datas) {
                });    
                    
                    $timeout(function() {
                        var len=$scope.$index;
                        if( $scope.creditnoteAcctData.credittables[$scope.$index].isFromDate==true){
                        $('#toDate' + len).datetimepicker({
                            format : 'DD/MM/YYYY',
                            pickTime: false
                        })
                        $('#fromDate' + len).datetimepicker({
                            format : 'DD/MM/YYYY',
                            pickTime: false
                        })
                       
                        
                        $("#toDate" + len).on("dp.change", function(e) {
                            var from = $("#txtfromDate" + len).val();
                            var date = from.split("/");
                            from = new Date(date[2], date[1] - 1, date[0]);
                            var to = e.date._d;
                            if (to < from) {
                                logger.logError("Please Select Valid To greater then  Valid From");
                                $("#txttoDate" + len).val('')
                            }else{
                                $scope.creditnoteAcctData.credittables[$scope.$index].toDate = $("#txttoDate" + len).val();
                            }

                        });
                        
                        $("#fromDate" + len).on("dp.change", function(e) {
                            var to = $("#txttoDate" + len).val();
                            var date = to.split("/");
                            to = new Date(date[2], date[1] - 1, date[0]);

                            var from = e.date._d;
                            if (to < from) {
                                logger.logError("Please Select Valid From less then  Valid To");
                                $("#txtfromDate" + len).val('')
                            }else{
                                $scope.creditnoteAcctData.credittables[$scope.$index].fromDate = $("#txtfromDate" + len).val(); 
                            }

                        });
                        }
                        }, 500);
                    
                    if($scope.$index !=0){
                        angular.forEach($scope.accountList, function(value, indexs) {
                            if(newValue == value.accountHeadCode){
                                $scope.creditnoteAcctData.credittables[$scope.$index].currency=value.currency;
                                // get exchange rate for currency
                                $http.get('app/commonUtility/getExchangeRateWithCurrency?currencyCode='+value.currency).success(function(data) {
                                    //$scope.creditnoteAcctData.credittables[$scope.$index].exchangeRate=data;
                                    if(data.success){
                                        $scope.creditnoteAcctData.credittables[$scope.$index].fromCurrency=data.fromCurrency;
                                        $scope.creditnoteAcctData.credittables[$scope.$index].toCurrency=data.toCurrency;
                                        $scope.creditnoteAcctData.credittables[$scope.$index].exchangeRate=data.exchangeRate;    
                                    }else{
                                        $scope.creditnoteAcctData.credittables[$scope.$index].exchangeRate='';
                                        $scope.creditnoteAcctData.credittables[$scope.$index].fromCurrency='';
                                        $scope.creditnoteAcctData.credittables[$scope.$index].toCurrency='';
                                    }
                                }).error(function(data) {
                                });                        
                            }
                        });
                    }
            }else{
                $scope.creditnoteAcctData.credittables[$scope.$index].currency='';
                $scope.creditnoteAcctData.credittables[$scope.$index].exchangeRate='';
                $scope.creditnoteAcctData.credittables[$scope.$index].subAccountCodeList = [];
            }
            });*/
        
        /*Voyage On Change...............*/
        $scope.$watch('creditnoteAcctData.credittables[trIndex].voyageCode', function(newValue, oldValue) {
            if (newValue != '' && newValue != undefined) {
                angular.forEach($scope.voyageList, function(value, indexs) {
                    if(newValue == value.voyageCode){
                        $scope.creditnoteAcctData.credittables[$scope.$index].vesselCode=value.vesselCode;
                        $scope.creditnoteAcctData.credittables[$scope.$index].sectorCode=value.sectorCode;
                    }
                });
            }else{
                $scope.creditnoteAcctData.credittables[$scope.$index].vesselCode='';
                $scope.creditnoteAcctData.credittables[$scope.$index].sectorCode='';
            }
        });    
        
     
        
        
     $scope.$watch('creditnoteAcctData.credittables[trIndex].subAcctCode', function(newValue, oldValue) {
            
            if (newValue != '' && newValue != undefined) {
                $scope.creditnoteAcctData.credittables[$scope.$index].subAcctCode=newValue;
            }
           
        });
     
     
     $scope.$watch('creditnoteAcctData.credittables[trIndex].subAccountCode', function(newValue, oldValue) {
         if (newValue != '' && newValue != undefined) {
             if($scope.creditnoteAcctData.credittables[$scope.$index].crdtlAccountHead == '20010001' || 
                     $scope.creditnoteAcctData.credittables[$scope.$index].crdtlAccountHead=='10120001' ||
                     $scope.creditnoteAcctData.credittables[$scope.$index].crdtlAccountHead=='20010002'){
                 $http.get('app/commonUtility/getSupplierCurrency?supplierCode='+newValue).success(function(data) {
                     if(data.success){
                         $scope.creditnoteAcctData.credittables[$scope.$index].currency=data.currencyCode;
                         if(data.isAgent =='Y' && $scope.creditnoteAcctData.credittables[$scope.$index].companyCode == 'C0001')
                             $scope.creditnoteAcctData.credittables[$scope.$index].isCurrencyBlocked=true;
                         else
                             $scope.creditnoteAcctData.credittables[$scope.$index].isCurrencyBlocked=false;
                     }else{
                         $scope.creditnoteAcctData.credittables[$scope.$index].isCurrencyBlocked=false;
                     }
                 }).error(function(data) {
                 });
             }else{
                 $scope.creditnoteAcctData.credittables[$scope.$index].isCurrencyBlocked=false;
             }
         }else{
             
         }
     });   
     
     $scope.$watch('creditnoteAcctData.credittables[trIndex].currency', function(newValue, oldValue) {
         if (newValue != '' && newValue != undefined) {
             // get exchange rate for currency
             /*$http.get('app/commonUtility/getDefaultExchangeRate?currencyCode='+newValue).success(function(data)*/
             $http.get('app/commonUtility/getExchangeRateWithCurrency?currencyCode='+newValue).success(function(data){
                 if(data.success){
                     $scope.creditnoteAcctData.credittables[$scope.$index].fromCurrency=data.fromCurrency;
                     $scope.creditnoteAcctData.credittables[$scope.$index].toCurrency=data.toCurrency;
                     $scope.creditnoteAcctData.credittables[$scope.$index].exchangeRate=data.exchangeRate;
                     
                     $scope.amountCalculationexchange(data.exchangeRate,[$scope.$index],$scope.creditnoteAcctData.credittables[$scope.$index]);
                 }else{
                     $scope.creditnoteAcctData.credittables[$scope.$index].exchangeRate='';
                 }                
             }).error(function(data) {
             });
         }
     });
       
        
    });

    app.controller('tableViewCtrl', function($scope,$http, $filter,logger,$timeout){/*
        
        
        $scope.$watch('creditnoteAcctData.credittables[trIndex].voyageCode', function(newValue, oldValue) {
            debugger;
            if (newValue != '' && newValue != undefined) {
                    $http.get('app/commonUtility/getVesselService?voyageCode='+newValue).success(function(datas) {
                        $scope.creditnoteAcctData.credittables[$scope.$index].vesselCode=datas.vesselCode;
                        $scope.creditnoteAcctData.credittables[$scope.$index].sectorCode=datas.sectorCode;
                        }).error(function(datas) {
                    });
           
            }
        });
        
        $scope.$watch('creditnoteAcctData.credittables[trIndex].crdtlAccountHead', function(newValue, oldValue) {
            if (newValue != '' && newValue != undefined) {
                
                $scope.creditnoteAcctData.credittables[$scope.$index].isCurrencyBlocked=false;
                if(newValue == '10080001'){
                    $http.get('app/commonUtility/getSubAccountCodeListTradeDebtors').success(function(datas) {
                        $scope.creditnoteAcctData.credittables[$scope.$index].subAccountCodeList = datas;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isSubAccountCode =true;
                        }).error(function(datas) {
                    });
                }
                
                else if (newValue == '10070002' || newValue == '10120001' || newValue == '20010001' || newValue == '10090017' || newValue == '10070004' || newValue == '10040007' || newValue == '10040008') {
                    $http.get('app/commonUtility/tradecreditorslist').success(function(datas) {
                        $scope.creditnoteAcctData.credittables[$scope.$index].subAccountCodeList = datas;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isSubAccountCode = true;
                    }).error(function(datas) {
                    });
                }else if(newValue == '20010001' || newValue=='10120001' || newValue=='10070004' || newValue=='10090017'){
                    $http.get('app/commonUtility/getSubAccountCodeListTradeCreditors').success(function(datas) {
                        $scope.creditnoteAcctData.credittables[$scope.$index].subAccountCodeList = datas;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isSubAccountCode=true;
                        }).error(function(datas) {
                    });   
                }else if(newValue == '10070001'){
                    $http.get('app/commonUtility/getStaffListForAdvances').success(function(datas) {
                        $scope.creditnoteAcctData.credittables[$scope.$index].subAccountCodeList = datas;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isSubAccountCode=true;
                        }).error(function(datas) {
                    });   
                }else if(newValue == '20010004'){
                    $http.get('app/commonUtility/getJvPartnerAccount').success(function(datas) {
                        $scope.creditnoteAcctData.credittables[$scope.$index].subAccountCodeList = datas;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isSubAccountCode=true;
                        }).error(function(datas) {
                    });   
                }else if(newValue == '20010002'){
                    $http.get('app/commonUtility/getAgentList').success(function(datas) {
                        $scope.creditnoteAcctData.credittables[$scope.$index].subAccountCodeList = datas;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isSubAccountCode=true;
                        }).error(function(datas) {
                    });   
                }else if (newValue == '10050001' || newValue == '10050002' || newValue == '50020002' || newValue == '50020001') {
                    $scope.creditnoteAcctData.credittables[$scope.$index].isSubAccountCode = true;

                    $http.get('app/commonUtility/getVessel').success(function(datas) {

                        $scope.creditnoteAcctData.credittables[$scope.$index].subAccountCodeList = datas;
                    }).error(function(datas) {
                    });
                } else{
                    $scope.creditnoteAcctData.credittables[$scope.$index].subAccountCodeList=[];
                    $scope.creditnoteAcctData.credittables[$scope.$index].isSubAccountCode=false;
                }
            
                if(newValue.substring(0, 4)=='1000'){
                    $scope.creditnoteAcctData.credittables[$scope.$index].isAsset=true;
                    $http.get('app/commonUtility/getassetList').success(function(datas) {
                        debugger;
                        $scope.creditnoteAcctData.credittables[$scope.$index].assetList = datas;
                        }).error(function(datas) {
                    });
                }
                
               
                    $http.get('app/commonUtility/getAttributesList?accountCode='+newValue).success(function(datas) {
                    $scope.creditnoteAcctData.credittables[$scope.$index].attributeList=datas;
                    if(newValue==oldValue){
                        $scope.isOnChange =false;
                    }else{
                        $scope.isOnChange =true;
                    }
                    if(!$scope.isView || $scope.isOnChange){
                        alert("hi");
                    $scope.creditnoteAcctData.credittables[$scope.$index].voyageCode='';
                    $scope.creditnoteAcctData.credittables[$scope.$index].vesselCode='';
                    $scope.creditnoteAcctData.credittables[$scope.$index].sectorCode='';
                    $scope.creditnoteAcctData.credittables[$scope.$index].employeeCode='';
                    $scope.creditnoteAcctData.credittables[$scope.$index].portCode='';
                    $scope.creditnoteAcctData.credittables[$scope.$index].portSequence='';
                    $scope.creditnoteAcctData.credittables[$scope.$index].departmentCode='';
                    $scope.creditnoteAcctData.credittables[$scope.$index].agentCode='';
                    $scope.creditnoteAcctData.credittables[$scope.$index].countryCode='';
                    $scope.creditnoteAcctData.credittables[$scope.$index].customerCode='';
                    $scope.creditnoteAcctData.credittables[$scope.$index].supplierCode='';
                    $scope.creditnoteAcctData.credittables[$scope.$index].designationCode='';
                    $scope.creditnoteAcctData.credittables[$scope.$index].costCenter='';
                    $scope.creditnoteAcctData.credittables[$scope.$index].companyCode='';
                    $scope.creditnoteAcctData.credittables[$scope.$index].quantityGO='';
                    $scope.creditnoteAcctData.credittables[$scope.$index].quantityFO='';
                    }
                    
                    if(!$scope.edit || $scope.isOnChange){
                        
                        $scope.creditnoteAcctData.credittables[$scope.$index].voyageCode='';
                        $scope.creditnoteAcctData.credittables[$scope.$index].vesselCode='';
                        $scope.creditnoteAcctData.credittables[$scope.$index].sectorCode='';
                        $scope.creditnoteAcctData.credittables[$scope.$index].employeeCode='';
                        $scope.creditnoteAcctData.credittables[$scope.$index].portCode='';
                        $scope.creditnoteAcctData.credittables[$scope.$index].portSequence='';
                        $scope.creditnoteAcctData.credittables[$scope.$index].departmentCode='';
                        $scope.creditnoteAcctData.credittables[$scope.$index].agentCode='';
                        $scope.creditnoteAcctData.credittables[$scope.$index].countryCode='';
                        $scope.creditnoteAcctData.credittables[$scope.$index].customerCode='';
                        $scope.creditnoteAcctData.credittables[$scope.$index].supplierCode='';
                        $scope.creditnoteAcctData.credittables[$scope.$index].designationCode='';
                        $scope.creditnoteAcctData.credittables[$scope.$index].costCenter='';
                        // commented for inter-company transaction
                        $scope.creditnoteAcctData.credittables[$scope.$index].companyCode='';
                        $scope.creditnoteAcctData.credittables[$scope.$index].quantityGO='';
                        $scope.creditnoteAcctData.credittables[$scope.$index].quantityFO='';
                        }
                        
                        $scope.creditnoteAcctData.credittables[$scope.$index].isVoyage=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isVessel=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isService=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isEmployee=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isPort=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isDepartment=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isAgent=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isLocation=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isCustomer=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isSupplier=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isDesignation=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isCostCenter=false;
                        // commented for inter-company transaction
                        $scope.creditnoteAcctData.credittables[$scope.$index].isCompany=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isQuantityGO=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isQuantityFO=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isPortSequence=false;
                        
                        // code added for mandatory
                        $scope.creditnoteAcctData.credittables[$scope.$index].isVoyageMan=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isVesselMan=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isServiceMan=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isEmployeeMan=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isPortMan=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isDepartmentMan=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isAgentMan=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isLocationMan=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isCustomerMan=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isSupplierMan=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isDesignationMan=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isCostCenterMan=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isQuantityGOMan=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isQuantityFOMan=false;
                        $scope.creditnoteAcctData.credittables[$scope.$index].isPortSequenceMan=false;
                 
                    angular.forEach($scope.creditnoteAcctData.credittables[$scope.$index].attributeList, function(row, rowindex) {
                        
                        if(row.attributeName == "Voyage"){
                            $scope.creditnoteAcctData.credittables[$scope.$index].isVoyage=true;
                        }else if(row.attributeName == "Vessel"){
                            $scope.creditnoteAcctData.credittables[$scope.$index].isVessel=true;
                        }else if(row.attributeName == "Service"){
                            $scope.creditnoteAcctData.credittables[$scope.$index].isService=true;
                        }else if(row.attributeName == "Employee"){
                            $scope.creditnoteAcctData.credittables[$scope.$index].isEmployee=true;
                        }else if(row.attributeName == "Port"){
                            $scope.creditnoteAcctData.credittables[$scope.$index].isPort=true;
                        }else if(row.attributeName == "Department"){
                            $scope.creditnoteAcctData.credittables[$scope.$index].isDepartment=true;
                        }else if(row.attributeName == "Agent"){
                            $scope.creditnoteAcctData.credittables[$scope.$index].isAgent=true;
                        }else if(row.attributeName == "Location"){
                            $scope.creditnoteAcctData.credittables[$scope.$index].isLocation=true;
                        }else if(row.attributeName == "Customer"){
                            $scope.creditnoteAcctData.credittables[$scope.$index].isCustomer=true;
                        }else if(row.attributeName == "Supplier"){
                            $scope.creditnoteAcctData.credittables[$scope.$index].isSupplier=true;
                        }else if(row.attributeName == "Designation"){
                            $scope.creditnoteAcctData.credittables[$scope.$index].isDesignation=true;
                        }else if(row.attributeName == "Cost Center"){
                            $scope.creditnoteAcctData.credittables[$scope.$index].isCostCenter=true;
                        }else if(row.attributeName == "Company"){
                            $scope.creditnoteAcctData.credittables[$scope.$index].isCompany=true;
                        }else if(row.attributeName == "Quantity (MT) GO"){
                            $scope.creditnoteAcctData.credittables[$scope.$index].isQuantityGO=true;
                        }else if(row.attributeName == "Quantity (MT) FO"){
                            $scope.creditnoteAcctData.credittables[$scope.$index].isQuantityFO=true;
                        }else if(row.attributeName == "Port with Sequence"){
                            $scope.creditnoteAcctData.credittables[$scope.$index].isPortSequence=true;
                        }
                        });
                    }).error(function(datas) {
                });
                    
                    angular.forEach($scope.creditnoteAcctData.credittables[$scope.$index].attributeList, function(row, rowindex) {
                        debugger;
                        if(row.attributeName == "Voyage"){
                           $scope.creditnoteAcctData.credittables[$scope.$index].isVoyage=true;
                            if(row.isMandatory == 'Y' &&$scope.creditnoteAcctData.credittables[$scope.$index].company_id_dtl == 'C0001'){
                               $scope.creditnoteAcctData.credittables[$scope.$index].isVoyageMan=true;
                            }
                        }else if(row.attributeName == "Vessel"){
                           $scope.creditnoteAcctData.credittables[$scope.$index].isVessel=true;
                            if(row.isMandatory == 'Y' &&$scope.creditnoteAcctData.credittables[$scope.$index].company_id_dtl == 'C0001'){
                               $scope.creditnoteAcctData.credittables[$scope.$index].isVesselMan=true;
                            }
                        }else if(row.attributeName == "Service"){
                           $scope.creditnoteAcctData.credittables[$scope.$index].isService=true;
                            if(row.isMandatory == 'Y' &&$scope.creditnoteAcctData.credittables[$scope.$index].company_id_dtl == 'C0001'){
                               $scope.creditnoteAcctData.credittables[$scope.$index].isServiceMan=true;
                            }
                        }else if(row.attributeName == "Employee"){
                           $scope.creditnoteAcctData.credittables[$scope.$index].isEmployee=true;
                            if(row.isMandatory == 'Y' &&$scope.creditnoteAcctData.credittables[$scope.$index].company_id_dtl == 'C0001'){
                               $scope.creditnoteAcctData.credittables[$scope.$index].isEmployeeMan=true;
                            }
                        }else if(row.attributeName == "Port"){
                           $scope.creditnoteAcctData.credittables[$scope.$index].isPort=true;
                            if(row.isMandatory == 'Y' &&$scope.creditnoteAcctData.credittables[$scope.$index].company_id_dtl == 'C0001'){
                               $scope.creditnoteAcctData.credittables[$scope.$index].isPortMan=true;
                            }
                        }else if(row.attributeName == "Department"){
                           $scope.creditnoteAcctData.credittables[$scope.$index].isDepartment=true;
                            if(row.isMandatory == 'Y' &&$scope.creditnoteAcctData.credittables[$scope.$index].company_id_dtl == 'C0001'){
                               $scope.creditnoteAcctData.credittables[$scope.$index].isDepartmentMan=true;
                            }
                        }else if(row.attributeName == "Agent"){
                           $scope.creditnoteAcctData.credittables[$scope.$index].isAgent=true;
                            if(row.isMandatory == 'Y' &&$scope.creditnoteAcctData.credittables[$scope.$index].company_id_dtl == 'C0001'){
                               $scope.creditnoteAcctData.credittables[$scope.$index].isAgentMan=true;
                            }
                        }else if(row.attributeName == "Location"){
                           $scope.creditnoteAcctData.credittables[$scope.$index].isLocation=true;
                            if(row.isMandatory == 'Y' &&$scope.creditnoteAcctData.credittables[$scope.$index].company_id_dtl == 'C0001'){
                               $scope.creditnoteAcctData.credittables[$scope.$index].isLocationMan=true;
                            }
                        }else if(row.attributeName == "Customer"){
                           $scope.creditnoteAcctData.credittables[$scope.$index].isCustomer=true;
                            if(row.isMandatory == 'Y' &&$scope.creditnoteAcctData.credittables[$scope.$index].company_id_dtl == 'C0001'){
                               $scope.creditnoteAcctData.credittables[$scope.$index].isCustomerMan=true;
                            }
                        }else if(row.attributeName == "Supplier"){
                           $scope.creditnoteAcctData.credittables[$scope.$index].isSupplier=true;
                            if(row.isMandatory == 'Y' &&$scope.creditnoteAcctData.credittables[$scope.$index].company_id_dtl == 'C0001'){
                               $scope.creditnoteAcctData.credittables[$scope.$index].isSupplierMan=true;
                            }
                        }else if(row.attributeName == "Designation"){
                           $scope.creditnoteAcctData.credittables[$scope.$index].isDesignation=true;
                            if(row.isMandatory == 'Y' &&$scope.creditnoteAcctData.credittables[$scope.$index].company_id_dtl == 'C0001'){
                               $scope.creditnoteAcctData.credittables[$scope.$index].isDesignationMan=true;
                            }
                        }else if(row.attributeName == "Cost Center"){
                           $scope.creditnoteAcctData.credittables[$scope.$index].isCostCenter=true;
                            if(row.isMandatory == 'Y' &&$scope.creditnoteAcctData.credittables[$scope.$index].company_id_dtl == 'C0001'){
                               $scope.creditnoteAcctData.credittables[$scope.$index].isCostCenterMan=true;
                            }
                        }else if(row.attributeName == "Company"){
                           $scope.creditnoteAcctData.credittables[$scope.$index].isCompany=true;
                            if(row.isMandatory == 'Y' &&$scope.creditnoteAcctData.credittables[$scope.$index].company_id_dtl == 'C0001'){
                               $scope.creditnoteAcctData.credittables[$scope.$index].isCompanyMan=true;
                            }
                        }else if(row.attributeName == "Quantity (MT) GO"){
                           $scope.creditnoteAcctData.credittables[$scope.$index].isQuantityGO=true;
                            if(row.isMandatory == 'Y' &&$scope.creditnoteAcctData.credittables[$scope.$index].company_id_dtl == 'C0001'){
                               $scope.creditnoteAcctData.credittables[$scope.$index].isQuantityGOMan=true;
                            }
                        }else if(row.attributeName == "Quantity (MT) FO"){
                           $scope.creditnoteAcctData.credittables[$scope.$index].isQuantityFO=true;
                            if(row.isMandatory == 'Y' &&$scope.creditnoteAcctData.credittables[$scope.$index].company_id_dtl == 'C0001'){
                               $scope.creditnoteAcctData.credittables[$scope.$index].isQuantityFOMan=true;
                            }
                        }else if(row.attributeName == "Port with Sequence"){
                           $scope.creditnoteAcctData.credittables[$scope.$index].isPortSequence=true;
                            if(row.isMandatory == 'Y' &&$scope.creditnoteAcctData.credittables[$scope.$index].company_id_dtl == 'C0001'){
                               $scope.creditnoteAcctData.credittables[$scope.$index].isPortSequenceMan=true;
                            }
                        }else if(row.attributeName == "From Date"){
                           $scope.creditnoteAcctData.credittables[$scope.$index].isFromDate=true;
                        }else if(row.attributeName == "To Date"){
                           $scope.creditnoteAcctData.credittables[$scope.$index].isToDate=true;
                        }
                        });
                    }).error(function(datas) {
                });    
                    
                    $timeout(function() {
                        var len=$scope.$index;
                        if( $scope.creditnoteAcctData.credittables[$scope.$index].isFromDate==true){
                        $('#toDate' + len).datetimepicker({
                            format : 'DD/MM/YYYY',
                            pickTime: false
                        })
                        $('#fromDate' + len).datetimepicker({
                            format : 'DD/MM/YYYY',
                            pickTime: false
                        })
                       
                        
                        $("#toDate" + len).on("dp.change", function(e) {
                            var from = $("#txtfromDate" + len).val();
                            var date = from.split("/");
                            from = new Date(date[2], date[1] - 1, date[0]);
                            var to = e.date._d;
                            if (to < from) {
                                logger.logError("Please Select Valid To greater then  Valid From");
                                $("#txttoDate" + len).val('')
                            }else{
                                $scope.creditnoteAcctData.credittables[$scope.$index].toDate = $("#txttoDate" + len).val();
                            }

                        });
                        
                        $("#fromDate" + len).on("dp.change", function(e) {
                            var to = $("#txttoDate" + len).val();
                            var date = to.split("/");
                            to = new Date(date[2], date[1] - 1, date[0]);

                            var from = e.date._d;
                            if (to < from) {
                                logger.logError("Please Select Valid From less then  Valid To");
                                $("#txtfromDate" + len).val('')
                            }else{
                                $scope.creditnoteAcctData.credittables[$scope.$index].fromDate = $("#txtfromDate" + len).val(); 
                            }

                        });
                        }
                        }, 500);
            
           

            }else{
                $scope.creditnoteAcctData.credittables[$scope.$index].currency='';
                $scope.creditnoteAcctData.credittables[$scope.$index].exchangeRate='';
                $scope.creditnoteAcctData.credittables[$scope.$index].subAccountCodeList = [];
            }
            });
        
        Voyage On Change...............
        $scope.$watch('creditnoteAcctData.credittables[trIndex].voyageCode', function(newValue, oldValue) {
            if (newValue != '' && newValue != undefined) {
                angular.forEach($scope.voyageList, function(value, indexs) {
                    if(newValue == value.voyageCode){
                        $scope.creditnoteAcctData.credittables[$scope.$index].vesselCode=value.vesselCode;
                        $scope.creditnoteAcctData.credittables[$scope.$index].sectorCode=value.sectorCode;
                    }
                });
            }else{
                $scope.creditnoteAcctData.credittables[$scope.$index].vesselCode='';
                $scope.creditnoteAcctData.credittables[$scope.$index].sectorCode='';
            }
        });    
     
     
        
     $scope.$watch('creditnoteAcctData.credittables[trIndex].subAcctCode', function(newValue, oldValue) {
            
            if (newValue != '' && newValue != undefined) {
                $scope.creditnoteAcctData.credittables[$scope.$index].subAcctCode=newValue;
            }
           
        });
     
       
    */});
});
    