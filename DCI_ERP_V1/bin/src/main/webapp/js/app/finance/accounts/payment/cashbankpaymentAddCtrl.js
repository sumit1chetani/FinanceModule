//define([ 'hospital/accounts/accounts' ], function(module) {

    'use strict';

    app.controller('CashBankPaymentAddCtrl', function($scope, $state,$filter, $http, $location, sharedProperties, 
            toaster, $injector, logger, ListService, $stateParams, ngDialog, $rootScope, $controller, validationService) {

        $scope.dataLoopCount = 0;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.companyList = [];
        $scope.disabled = false;

        $scope.pmtTypeList = [ {
            id : 'bank',
            text : 'Bank'
        }, {
            id : 'cash',
            text : 'Cash'
        } ]
        $scope.dataList = [];
        $scope.bankAccountList = [];
        $scope.cashAccountList = [];
        $scope.cbpdtlAcctHeadList = [];
        $scope.subAccountCodeList = [];
        $scope.currencyList = [];
        $scope.voyageList = [];
        $scope.vesselList = [];
        $scope.sectorList = [];
        $scope.pmtOrderNoList = [];
        $scope.paidToList = [];
        $scope.chequeList = [];
        $scope.chequeEditList = [];
        $scope.validated = false;
        $scope.edit = false;

        $scope.cashbankpaymentModelData = {
            cbVoucherNo : '',
            cbVoucherNo1:'',
            cashbankPmtDate : '',
            cbpmtDate : '',
            pmtType : 'bank',
            companyName : 'C0002',
            accountName : '',
            currencyCode : 'INR',
            exchangeRate : 1.0,costCenter : '87',
            paidTo : '',
            chequeNo : '',
            chequeDate : '',
            chequeDt : '',
            bcAmountHdr : '',
            narration : '',
            tcAmountHdr : '',
            denomAmt : '',
            countamt : '',
            totalCashAmount : '',
            rupessAmt : '',
            cbptables : [],
            cbptablescash : [],
            
            
            employeeCode : '',
            departmentCode : '',
            countryCode : '',
            customerCode : '',
            supplierCode : '',
            designationCode : '',
            costCenter : '',
            companyCode : '',
            patientCode : '',
            approvenote :'',

          
        };
$scope.costList1=[];
$scope.paymentList=[];


        $scope.cbpmtDtlTotalAmt = {
            totalBCAmount : 0,
            totalTCAmount : 0,
            denomAmt : 0,
            countamt : 0,
            rupessAmt : 0,
            totalCashAmount : 0,
        }
      
      


        $scope.receiptList=[];
		$scope.getreceiveStatus = function() {
		    var  data = {};
		    data["id"] = "Vendor";
		    data["text"] = "Vendor";
		    $scope.receiptList.push(data);
		    data = {};
		    data["id"] = "Others";
		    data["text"] = "Others";
		    $scope.receiptList.push(data); 
		    
		    
		}
		$scope.getreceiveStatus();
        
        $scope.$watch('cashbankpaymentModelData.cashbankPmtDate', function(value, oldValue) {
            debugger
            if (value != '' && value != undefined) {
            var res = value.split("/");
            var formCode='F3817';
            $http.get('app/journalVoucher/getloggedcompany?closingDate='+value+'&formCode='+formCode).success(function(datas) {
            if(datas){
            logger.logError("Account closed for year "+ res[2]);
            $scope.cashbankpaymentModelData.cashbankPmtDate = '';
            }
            })
            }
            });

       
        
        
        $scope.$watch('cashbankpaymentModelData.chequeDate', function(newValue, oldValue) {
            if (newValue != '' && newValue != undefined) {
                var toDate = $scope.cashbankpaymentModelData.cashbankPmtDate;
                var fromDate = newValue;
                fromDate = fromDate.split("/");
                fromDate = new Date(fromDate[2], fromDate[1] - 1, fromDate[0]);
                toDate = toDate.split("/");
                toDate = new Date(toDate[2], toDate[1] - 1, toDate[0]);
                if (fromDate < toDate) {
                    logger.logError("Cheque Date Should be greater than Payment Date");
                    $scope.cashbankpaymentModelData.chequeDate = '';
                }
            }
        });
        
        $scope.$watch('cashbankpaymentModelData.companyName', function(newValue, oldValue) {
            //  alert(newValue);
               if(newValue!=null && newValue!=undefined && newValue != ''){
               //    $http.post($stateParams.tenantid+ '/app/commonUtility/getVoyageListByVessel',newValue).success(function(data) {
                    $http.get('app/purchaseinvoice/getcompanycost?company=' + $scope.cashbankpaymentModelData.companyName).success(function(data) {

                        $scope.cashbankpaymentModelData.companyName = newValue;


                         if(data.length > 0)
                       {
                       $scope.costList = data;
                        $scope.cashbankpaymentModelData.costCenter ='87';
                       }
                         else{
                        	 
                             
                             logger.logError("Not Available");
                             
                         }
                   });
               }
             });
          
      /*  $scope.$watch('cashbankpaymentModelData.cbptables[trIndex].cbpdtlAccountHead', function(newValue, oldValue) {

            if(newValue=='10080001'){

                $http.get('app/journalVoucher/getSubAcctHeadList').success(function(datas) {
                    $scope.subAccountCodeList1 = datas;
                }).error(function(datas) {
                    logger.logError("Error Please Try Again");
                });
        }
        }); */

        //$http.get("app/purchaseinvoice/costcenterlist").success(function(datas) {
       //     $scope.costList = datas;
      //  });
        $http.get("app/purchaseinvoice/costcenterlist_1").success(function(datas) {
            $scope.costList1 = datas;
        });
   

   
//      Budget defn validation
     var budgetFlag =false;
     $scope.budgetValidation = function(){
         
         $http.post('app/cashbankPayment/budgetdefnvalidation', $scope.cashbankpaymentModelData).success(function(result) {
             if (result.success)
                 budgetFlag = true;
             else {
                 budgetFlag = false;
                 logger.LogError(result. message);
             }
         });
         return budgetFlag;
     }
     
     
//
     $scope.checkBudgetFlag = function(){
         var BudgetFlag = true;
         angular.forEach($scope.cashbankpaymentModelData.cbptables, function(key, index) {
             if(key.budgetDefnId != null && key.budgetDefnId != "" && key.budgetDefnId != undefined ){
             if ((key.budgetAmt -  key.budgetUtilizedAmt) == 0){
                 logger.logError("Row "+(index+1)+" The cost center you have entered is not having any budget allocated ! ");
                 BudgetFlag = false;
             }else if(key.cbpDtlBcAmount > (key.budgetAmt -  key.budgetUtilizedAmt))
             {
                 logger.logError("Row "+(index+1)+" Amount entered is greater than the Allocated/Balance budget " + (key.budgetAmt -  key.budgetUtilizedAmt ));
                 BudgetFlag = false;
             } 
             }
         });
         return BudgetFlag;
     }
        
        /**
         * validation
         */
        $scope.validate = function(cashBankPaymentForm, cashbankpaymentModelData) {
            if (new validationService().checkFormValidity($scope.cashBankPaymentForm)) {
                if ($scope.cashbankpaymentModelData.bcAmountHdr > 0) {
                    if ($scope.cashbankpaymentModelData.bcAmountHdr == $scope.cbpmtDtlTotalAmt.totalBCAmount) {
//                   /     if ($scope.cbpmtDtlTotalAmt.totalBCAmount == $scope.cashbankpaymentModelData.totalCashAmount) {

                        angular.forEach($scope.cashbankpaymentModelData.cbptables, function(key, index) {
                            delete key['select'];
                            delete key['isEmployee'];
                            delete key['isDepartment'];
                            delete key['isLocation'];
                            delete key['isCustomer'];
                            delete key['isSupplier'];
                            delete key['isDesignation'];
                            delete key['isCostCenter'];
                            delete key['isPatient'];
                            delete key['isCompany'];
                            delete key['attributeList'];
                            delete key['isInvoiceNo'];
                            delete key['departmentCode'];
                            delete key['countryCode'];
                            delete key['customerCode'];
                            delete key['supplierCode'];
                            delete key['designationCode'];
                            delete key['costCenter'];
                            delete key['companyCode'];
                            delete key['patientCode'];
                        });
                        var BudgetFlag = $scope.checkBudgetFlag();
                        if(BudgetFlag){
//                        var budgetFlag = $scope.budgetValidation();
//                        if(budgetFlag){
//                        $http.post('app/cashbankPayment/budgetdefnvalidation', $scope.cashbankpaymentModelData).success(function(result) {
//                            if (result.success){
                        $http.post('app/cashbankPayment/validateBudget', $scope.cashbankpaymentModelData).success(function(result) {
                            result.success=true;
                            if (result.success)
                                $scope.save(cashBankPaymentForm, cashbankpaymentModelData);
                            else {

                                ngDialog.openConfirm({
                                    template : 'modalDialogId',
                                    className : 'ngdialog-theme-default'
                                }).then(function(value) {
                                    $scope.save(cashBankPaymentForm, cashbankpaymentModelData);
                                }, function(reason) {
                                });

                            }
                        });
//                            }
//                            else{
//                                logger.logError(result.message);
//                            }
//                        });
                    }else{
                        
                    }
                       
//                        }
//                        else{
//                            
//                        }

                  /*  } else {
                        logger.logError('Cash Denomination and  Total amout shoud be match!');
                    }*/
                    } else {
                        logger.logError('Amount should match!');
                    }
                } else {
                    logger.logError('Please Enter Amount!');
                }
                    
                    

            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.cashBankPaymentForm.$validationSummary), 555000, 'trustedHtml');
            }
        };
        /**
         * fetch Current Date into PQ Date, Valid From Date
         */
        $scope.getCurrentDate = function() {
            var d = new Date();
            var year = d.getFullYear();
            var month = d.getMonth() + 1;
            if (month < 10) {
                month = "0" + month;
            }
            ;
            var day = d.getDate();
            if (day < 10) {
                day = "0" + day;
            }
            $scope.date = day + "/" + month + "/" + year;
            $scope.cashbankpaymentModelData.cashbankPmtDate = $scope.date;
        }
        $scope.getCurrentDate();
        /** get Type of Payment - Bank/Cash ****************** */

        $scope.tempPmtTypeList = ListService.getPmtTypeList();

        $scope.tempPmtTypeList.then(function(data) {
            $scope.pmtTypeList = data;
        });

        $scope.tempCompanyList = ListService.getCompanyList();
        
/*
        $http.get('app/commonUtility/getCompanyList').success(function(datas) {
            $scope.companyList = datas;

                var foundItemDest = $filter('filter')($scope.companyList, {
                    baseCompany : 1
                    
                })[0];
                $scope.cashbankpaymentModelData.companyName=foundItemDest.id;
        }).error(function(datas) {
        });
*/
        $scope.tempCompanyList.then(function(data) {
            $scope.companyList = data;
        });

        $scope.pmtTypeGroup = {
            show : true,
            hide : false
        };
        $scope.pmtTypeShow = true;
        /**
         * get Bank/Cash Account List and pmtTypeGroup show/hide with
         * paymentType- bank/Cash *********************************
         */
//        budgetTypeList
       // $http.get('app/commonUtility/BudgetDefList').success(function(datas) {
      //      $scope.budgetTypeList = datas.lClassBasedOnSpecificRigths;
     //   });
        
        $scope.$watch('cashbankpaymentModelData.pmtType', function(newValue, oldValue) {
            var com=  $scope.cashbankpaymentModelData.companyName;
            if (newValue != undefined && newValue != '') {
                if (newValue == "cash") {
                    $scope.getCashAccountList(newValue);
                    $scope.bankAccountList = [];
                    $scope.pmtTypeShow = false;
                    $scope.cashbankpaymentModelData.chequeNo = '';
                    $scope.cashbankpaymentModelData.chequeDate = '';
                } else if (newValue == "bank") {
                    $scope.pmtTypeShow = true;
                    $scope.cashbankpaymentModelData.accountName = '';
                    $scope.getBankAccountList(newValue,com);
                    $scope.cashAccountList = [];
                }
            }
        });

        $scope.$watch('cashbankpaymentModelData.chequeNo', function(newValue, oldValue) {
            if (newValue != undefined && newValue != '' && newValue != null) {
                if (!$scope.edit) {
                    angular.forEach($scope.chequeList, function(value, key) {
                        if (newValue == value.id) {
                            $scope.cashbankpaymentModelData.chequeNoValue = value.text;

                        }
                    });
                } else {
                    if ($scope.edit) {
                        angular.forEach($scope.chequeEditList, function(value, key) {
                            if (newValue == value.id) {
                                $scope.cashbankpaymentModelData.chequeNoValue = value.text;

                            }
                        });
                    }
                }

            }
        });
        
        
     /*   $http.get('app/commonUtility/getSubAccountCodeLists').success(function(datas) {

            var subAcctList = [];
            angular.forEach(datas.commonUtilityBean, function(item, key) {
                var subAccHdObj = new Object();
                subAccHdObj.id = datas.commonUtilityBean[key].subAccountCode;
                subAccHdObj.text = datas.commonUtilityBean[key].subAccountName;
                subAcctList.push(subAccHdObj);
            });
            $scope.subAccountCodeList = subAcctList;
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });*/
     /*   
        $http.get('app/cashbankPayment/subAccountCodeList').success(function(datas) {
            $scope.subAccountCodeList = datas;
        }).error(function(datas) {
        });*/
        
        
        //jayanthi///
        

        $scope.$watch('cashbankpaymentModelData.companyName', function(newValue, oldValue) {
          //  alert(newValue);
             if(newValue!=null && newValue!=undefined && newValue != ''){
             //    $http.post($stateParams.tenantid+ '/app/commonUtility/getVoyageListByVessel',newValue).success(function(data) {
                  $http.get('app/cashbankPayment/getBankAcctListcompany?companyName=' + $scope.cashbankpaymentModelData.companyName).success(function(data) {

                      $scope.cashbankpaymentModelData.companyName = newValue;


                       if(data.length > 0)
                     {
                     $scope.bankAccountList = data;
                     }
                       else{
                           
                           logger.logError("Not Available");
                           
                       }
                 });
             }
           });
        
        
        
        
        
        
        $scope.$watch('cashbankpaymentModelData.companyName', function(newValue, oldValue) {
            //  alert(newValue);
               if(newValue!=null && newValue!=undefined && newValue != '' && $scope.cashbankpaymentModelData.pmtType == "bank"){
               //    $http.post($stateParams.tenantid+ '/app/commonUtility/getVoyageListByVessel',newValue).success(function(data) {
                   
                   
                   if ($scope.cashbankpaymentModelData.pmtType == "bank") {
                    
                   $http.get('app/cashbankPayment/getBankAcctListcompanyNew?companyName=' + $scope.cashbankpaymentModelData.companyName).success(function(data) {

                        $scope.cashbankpaymentModelData.companyName = newValue;


                         if(data.length > 0)
                       {
                       $scope.bankAccountNewList = data;
                       }
                         else{
                             
                             logger.logError("Not Available");
                             
                         }
                   });
                   }
                    
            
               }
             });
        
        
        $scope.$watch('cashbankpaymentModelData.companyName', function(newValue, oldValue) {
            //  alert(newValue);
               if(newValue!=null && newValue!=undefined && newValue != '' && $scope.cashbankpaymentModelData.pmtType == "cash"){
               //    $http.post($stateParams.tenantid+ '/app/commonUtility/getVoyageListByVessel',newValue).success(function(data) {
                
                    
                   if ($scope.cashbankpaymentModelData.pmtType == "cash") {
                    
                    $http.get('app/cashbankPayment/getCashAcctListcompanyNew?companyName=' + $scope.cashbankpaymentModelData.companyName).success(function(data) {

                        $scope.cashbankpaymentModelData.companyName = newValue;


                         if(data.length > 0)
                       {
                       $scope.cashAccountListNew = data;
                       }
                         else{
                             
                             logger.logError("Not Available");
                             
                         }
                   });
               }
               }
             });
        $scope.$watch('cashbankpaymentModelData.accountName', function(newValue, oldValue) {
            if (newValue != '' && newValue != undefined) {
                $scope.cashbankpaymentModelData.accountName = newValue;
           //     $scope.cashbankpaymentModelData.cashAcc = '';
                $scope.cashbankpaymentModelData.accountName = newValue;
                
                $http.post('app/cashbankreceipt/getCurrencyAndExchangeRate', newValue).success(function(datas) {
                   
                  //  $scope.objCBReceipt.exchangeRate = datas.objCashBankReceiptListListBean[0].exchangeRate;
                    $scope.cashbankpaymentModelData.currencyCode = datas.objCashBankReceiptListListBean[0].acctCurrency;
               
                }).error(function(datas) {
                    logger.logError("Error Please Try Again");
                });
            }
        });

        
        //
   
        /**
         * **************** Bank / Cash Acct List *********** Dropdown in
         * selectivity ******************
         */
        $scope.getBankAccountList = function(pmtType,com) {
            $scope.dataList = ListService.getBankAcctList(pmtType,com);

            $scope.dataList.then(function(data) {
                $scope.bankAccountList = data;
            });
        };
        $scope.getCashAccountList = function(pmtType) {
            $scope.dataList = ListService.getCashAcctList(pmtType);
            $scope.dataList.then(function(data) {
                $scope.cashAccountList = data;
            });
        };

        $scope.$watch('cashbankpaymentModelData.accountName', function(newValue, oldValue, accountList) {
            if (newValue != undefined && newValue != '') {
                if (accountList.cashbankpaymentModelData.pmtType == 'bank') {
                    $scope.cashbankpaymentModelData.accountName = newValue;
                    if (newValue != '' && newValue != undefined) {
                        angular.forEach(accountList.bankAccountList, function(row, key) {
                            if (newValue == row.id) {
                                $scope.cashbankpaymentModelData.currencyCode = row.currencyCode;
                                $scope.cashbankpaymentModelData.exchangeRate = row.exchangeRate;
                            }
                        });

                        if (!$scope.edit) {

                            $http.get('app/cashbankPayment/chequeList?accountName=' + $scope.cashbankpaymentModelData.accountName).success(function(data) {

                                if (data.length > 0) {

                                    $scope.chequeList = data;
                                }
                            }).error(function(data) {
                                logger.logError("Failed to get Cheque List");
                            });
                        } else {
                            if (voucherNo != undefined && voucherNo != null && voucherNo != "") {
                                var resultBean = {
                                    cbVoucherNo : voucherNo,
                                    acctHeadCode : $scope.cashbankpaymentModelData.accountName
                                }
                                $http.post('app/cashbankPayment/chequeEditList', resultBean).success(function(data) {
                                    if (data.length > 0) {
                                        $scope.chequeEditList = data;
                                        $scope.cashbankpaymentModelData.chequeNo = $scope.oldChequeNo;
                                    }
                                }).error(function(data) {
                                    logger.logError("Failed to get Cheque List");
                                });
                            } else {
                                logger.logError("Failed to get Cheque List");
                            }

                        }

                    } else {
                        $scope.cashbankpaymentModelData.currencyCode = "";
                        $scope.cashbankpaymentModelData.exchangeRate = 0.0;
                    }
                } else if (accountList.cashbankpaymentModelData.pmtType == 'cash') {
                    $scope.cashbankpaymentModelData.accountName = newValue;

                    if (newValue != '' && newValue != undefined) {
                        angular.forEach(accountList.cashAccountList, function(row, key) {
                            if (newValue == row.id) {
                                $scope.cashbankpaymentModelData.currencyCode = row.currencyCode;
                                $scope.cashbankpaymentModelData.exchangeRate = row.exchangeRate;
                            }
                        });
                    } else {
                        $scope.cashbankpaymentModelData.currencyCode = "";
                        $scope.cashbankpaymentModelData.exchangeRate = 0.0;
                    }
                }
            }
        });

        $scope.cbphdrAmountCalculation = function(bcamount) {

            var roundedBcAmount = parseFloat(bcamount);
            $scope.cashbankpaymentModelData.bcAmountHdr = roundedBcAmount;
            $scope.cashbankpaymentModelData.bcAmountHdr = parseFloat(roundedBcAmount);
            if ($scope.cashbankpaymentModelData.exchangeRate != 0 && $scope.cashbankpaymentModelData.exchangeRate != "") {
                $scope.cashbankpaymentModelData.tcAmountHdr = parseFloat(roundedBcAmount) / $scope.cashbankpaymentModelData.exchangeRate;
            } else {
                $scope.cashbankpaymentModelData.tcAmountHdr = 1;
            }
        }

        $scope.onChangeNumber = function(ids, num) {

            num = num.replace(/[^0-9 .]/g, '');
            $('#' + ids).val(num);
            return num;
        }

        /**
         * dropdown value
         */
        $scope.getDropdownValue = function() {

            $http.get('app/cashbankPayment/getPaidToList').success(function(datas) {
                $scope.paidToList = datas;
            }).error(function(datas) {
            });
           /* $http.get('app/commonUtility/getCrDtlAccountHeadData').success(function(datas) {

                if (datas.commonUtilityBean.length > 0) {
                    var acctHeadList = [];
                    angular.forEach(datas.commonUtilityBean, function(item, key) {
                        var accHdObj = new Object();
                        accHdObj.id = datas.commonUtilityBean[key].accountHeadCode;
                        accHdObj.text = datas.commonUtilityBean[key].accountHeadName;
                        acctHeadList.push(accHdObj);
                    });
                    $scope.cbpdtlAcctHeadList = acctHeadList;
                }
            }).error(function(data) {
            });
            
            
*/
            
            
            $http.get('app/journalVoucher/getAccountNewPayHeadList').success(function(datas) {
                $scope.cbpdtlAcctHeadList = datas;
            }).error(function(datas) {
                logger.logError("Error Please Try Again");
            });
        /*    $http.get('app/journalVoucher/getCurrencyList').success(function(datas) {
                $scope.currencyList = datas;
            }).error(function(datas) {
                logger.logError("Error Please Try Again");
            });
*/
            // Attributes Dropdown

            
            
            $scope.currencyList = [ {
                id : 'INDIAN RUPEES',
                text : 'INDIAN RUPEES'
            }, {
                id : 'USD',
                text : 'USD'
            },
            
            {
                id : 'EURO',
                text : 'EURO'
            } ]

            $http.get($stateParams.tenantid + '/app/commonUtility/getEmployeeList').success(function(datas) {
                $scope.employeeList = datas;
            }).error(function(datas) {
            });

            $http.get($stateParams.tenantid + '/app/commonUtility/getDepartmentList').success(function(datas) {
                $scope.departmentList = datas;
            }).error(function(datas) {
            });
            
            
            $http.get($stateParams.tenantid + '/app/commonUtility/getstudentList').success(function(datas) {
                $scope.studentList = datas;
            }).error(function(datas) {
            });

            $http.get($stateParams.tenantid + '/app/commonUtility/getCountryList').success(function(datas) {
                $scope.countryList = datas;
            }).error(function(datas) {
            });
            $http.get($stateParams.tenantid + '/app/commonUtility/getSupplierList').success(function(datas) {
                $scope.supplierList = datas;
            }).error(function(datas) {
            });
            $http.get($stateParams.tenantid + '/app/commonUtility/getCustomerAttributeList').success(function(datas) {
                $scope.customerList = datas;
            }).error(function(datas) {
            });

            $http.get($stateParams.tenantid + '/app/commonUtility/getDesignationList').success(function(datas) {
                $scope.designationList = datas;
            }).error(function(datas) {
            });
            $http.get($stateParams.tenantid + '/app/commonUtility/getCostCenterList').success(function(datas) {
                $scope.costCenterList = datas;
            }).error(function(datas) {
            });
            $http.get($stateParams.tenantid + '/app/commonUtility/getPatientList').success(function(datas) {
                $scope.patientList = datas;
            }).error(function(datas) {
            });
            
           
            
            //vochuer No

      	  $http.get('app/cashbankPayment/GetvoucherNo?pmtype=' +  $scope.cashbankpaymentModelData.pmtType+'&cashbankPmtDate='+$scope.cashbankpaymentModelData.cashbankPmtDate +'&accountName='+$scope.cashbankpaymentModelData.accountName).success(function(data) {
                   // $scope.receivedFromList = datas;
         		   $scope.cashbankpaymentModelData.cbVoucherNo=data.cbVoucherNo;     
                }).error(function(datas) {
                });
        }
        $scope.getDropdownValue();

        /***********************************************************************
         * load CB Payment Table *******************************************
         */

        $scope.loadCbpTable = function() {
            var cbptable = {};
            cbptable = {
                select : '',
                cashBankPmtDtlId : '',
                cbpdtlSubgroupCode : '',
                cbpdtlAccountHead : '',
                cbpdtlpaymentHead :'',
                cbdtlsubAccountCode : '',
                purInvoiceNo : '',
                cbpdtlpaymentHead :'',
                cbpdtlPmtOrderNo : '',
                cbpdtlCurrencyCode : 'INDIAN RUPEES',
                cbpdtlExgRate : 1.0,
                cbpDtlBcAmount : '',
                cbpDtlTcAmount : '',
                
                denomAmt : '',
                countamt : '',
                rupessAmt : '',
                totalCashAmount : '',

                employeeCode : '',
                departmentCode : '',
                countryCode : '',
                customerCode : '',
                supplierCode : '',
                designationCode : '',
                costCenter : '',
                companyCode : '',
                patientCode : '',

                isEmployee : false,
                isDepartment : false,
                isLocation : false,
                isCustomer : false,
                isSupplier : false,
                isDesignation : false,
                isCostCenter : false,
                isCompany : false,
                isPatient : false,
                attributeList : [],
                isInvoiceNo : false,
                invoicePaymentList : []

            };
            $scope.cashbankpaymentModelData.cbptables.push(cbptable);
        }

        
        //cashbank
        
        
        $scope.$watch('cashbankpaymentModelData.pmtType', function(newValue, oldValue) {
            debugger
            if (newValue != '' && newValue != undefined) {
                if ($scope.cashbankpaymentModelData.pmtType == "cash") {

              	  $http.get('app/cashbankPayment/GetvoucherNo?pmtype=' +  $scope.cashbankpaymentModelData.pmtType+'&cashbankPmtDate='+$scope.cashbankpaymentModelData.cashbankPmtDate  +'&accountName='+$scope.cashbankpaymentModelData.accountName).success(function(data) {
                // $scope.receivedFromList = datas;
      		   $scope.cashbankpaymentModelData.cbVoucherNo=data.cbVoucherNo;     
             }).error(function(datas) {
             });
            }else if($scope.cashbankpaymentModelData.pmtType == "bank"){
            	  $http.get('app/cashbankPayment/GetvoucherNo?pmtype=' +  $scope.cashbankpaymentModelData.pmtType+'&cashbankPmtDate='+$scope.cashbankpaymentModelData.cashbankPmtDate  +'&accountName='+$scope.cashbankpaymentModelData.accountName).success(function(data) {
                      // $scope.receivedFromList = datas;
            		   $scope.cashbankpaymentModelData.cbVoucherNo=data.cbVoucherNo;     
                   }).error(function(datas) {
                   });	
            }
            }
            });
        
        
        
        $scope.$watchCollection('[cashbankpaymentModelData.pmtType,cashbankpaymentModelData.accountName]', function(newValue, oldValue) {
        	debugger
        	        if ($scope.cashbankpaymentModelData.pmtType != undefined && $scope.cashbankpaymentModelData.pmtType != "" && $scope.cashbankpaymentModelData.pmtType != null && $scope.cashbankpaymentModelData.accountName != undefined  &&   $scope.cashbankpaymentModelData.accountName != "" && $scope.cashbankpaymentModelData.accountName != null) {
        	            
        	        	if ($scope.cashbankpaymentModelData.pmtType == "cash") {

        	              	  $http.get('app/cashbankPayment/GetvoucherNo?pmtype=' +  $scope.cashbankpaymentModelData.pmtType+'&cashbankPmtDate='+$scope.cashbankpaymentModelData.cashbankPmtDate  +'&accountName='+$scope.cashbankpaymentModelData.accountName).success(function(data) {
        	                // $scope.receivedFromList = datas;
        	      		   $scope.cashbankpaymentModelData.cbVoucherNo=data.cbVoucherNo;     
        	             }).error(function(datas) {
        	             });
        	            }else if($scope.cashbankpaymentModelData.pmtType == "bank"){
        	            	  $http.get('app/cashbankPayment/GetvoucherNo?pmtype=' +  $scope.cashbankpaymentModelData.pmtType+'&cashbankPmtDate='+$scope.cashbankpaymentModelData.cashbankPmtDate  +'&accountName='+$scope.cashbankpaymentModelData.accountName).success(function(data) {
        	                      // $scope.receivedFromList = datas;
        	            		   $scope.cashbankpaymentModelData.cbVoucherNo=data.cbVoucherNo;     
        	                   }).error(function(datas) {
        	                   });	
        	            }
        	        
        	        
        	        }

        	    });
        	    
        	    
        	    
        
        
        // add Row
        $scope.addCBPmtRow = function(tables) {
            var len = tables.length;
            var table = {
                select : '',
                cashBankPmtDtlId : '',
                cbpdtlSubgroupCode : '',
                cbpdtlAccountHead : '',
                cbpdtlpaymentHead :'',
                cbdtlsubAccountCode : '',
                cbpdtlPmtOrderNo : '',
                cbpdtlCurrencyCode : 'INDIAN RUPEES',
                cbpdtlExgRate : 1.0,
                cbpDtlBcAmount : '',
                cbpDtlTcAmount : '',
                purInvoiceNo : '',

                employeeCode : '',
                departmentCode : '',
                countryCode : '',
                customerCode : '',
                supplierCode : '',
                designationCode : '',
                costCenter : '',
                companyCode : '',
                patientCode : '',
                
                denomAmt : '',
                countamt : '',
                rupessAmt : '',
                totalCashAmount : '',
                budgetAmt : 0,
                budgetUtilizedAmt : 0,


                isEmployee : false,
                isDepartment : false,
                isLocation : false,
                isCustomer : false,
                isSupplier : false,
                isDesignation : false,
                isCostCenter : false,
                isCompany : false,
                isPatient : false,
                attributeList : [],
                isInvoiceNo : false,
                invoicePaymentList : []
            };
            tables.push(table);

        };
        $scope.deletedRow = [];
        // remove Row
        $scope.removeCBPmtRow = function(table) {
            $scope.tablerow = [];
            angular.forEach(table, function(row, index) {
                var check = row.select;
                if (check == undefined || check == "") {
                    $scope.tablerow.push(row);
                } else {
                    $scope.deletedRow.push(row);
                }
            });
            $scope.cashbankpaymentModelData.cbptables = $scope.tablerow;
            $scope.totalAmountCalculation();
        };

        $scope.loadCbpTable();

        $scope.bcToTcAmountCalculation = function(bcAmount, trIndex, row) {
            row.cbpDtlBcAmount = parseFloat(bcAmount);
            if (row.cbpdtlExgRate != 0 && row.cbpdtlExgRate != "") {
                row.cbpDtlTcAmount = parseFloat(bcAmount) / row.cbpdtlExgRate;
                $scope.totalAmountCalculation();
            } else {
                row.cbpDtlTcAmount = 1;
                $scope.totalAmountCalculation();
            }
        }
        $scope.tcToBcAmountCalculation = function(tcAmount, trIndex, row) {
            row.cbpDtlTcAmount = parseFloat(tcAmount);
            if (row.cbpdtlExgRate != 0 && row.cbpdtlExgRate != "") {
                row.cbpDtlBcAmount = parseFloat(tcAmount) * row.cbpdtlExgRate;
                $scope.totalAmountCalculation();
            } else {
                row.cbpDtlBcAmount = 1;
                $scope.totalAmountCalculation();
            }
        }

        $scope.totalAmountCalculation = function() {
            var cbpDtlRowDatas = $scope.cashbankpaymentModelData.cbptables;
            var bcAmt = 0, tcAmt = 0;

            if (cbpDtlRowDatas.length > 0) {
                angular.forEach(cbpDtlRowDatas, function(item, key) {
                    var cbpTblRowData = cbpDtlRowDatas[key];
                    bcAmt += parseFloat(item.cbpDtlBcAmount);
                    tcAmt += parseFloat(item.cbpDtlTcAmount);
                    $scope.cbpmtDtlTotalAmt.totalBCAmount = bcAmt;
                    $scope.cbpmtDtlTotalAmt.totalTCAmount = tcAmt;
                });
            } else {
                $scope.cbpmtDtlTotalAmt.totalBCAmount = bcAmt;
                $scope.cbpmtDtlTotalAmt.totalTCAmount = tcAmt;
            }

        }

        /***********************************************************************
         * save and update functionality ******************************
         */

        $scope.save = function(cashBankPaymentForm, cashbankpaymentModelData) {
            if ($scope.cashbankpaymentModelData.cbptables.length > 0) {
                $scope.cashbankpaymentModelData.deletedCBPmtDtlsRow = $scope.deletedRow;
                var isCheque = true;
                if ($scope.cashbankpaymentModelData.pmtType == "bank") {
                    if ($scope.cashbankpaymentModelData.chequeNo == undefined || $scope.cashbankpaymentModelData.chequeNo == null || $scope.cashbankpaymentModelData.chequeNo == "") {
                        isCheque = false
                    }
                }
               // if (isCheque) {
                    if ($scope.edit == false) {
                        angular.forEach($scope.cashbankpaymentModelData.cbptables, function(key, index) {
                            delete key['isEmployee'];
                            delete key['isDepartment'];
                            delete key['isLocation'];
                            delete key['isCustomer'];
                            delete key['isSupplier'];
                            delete key['isDesignation'];
                            delete key['isCostCenter'];
                            delete key['isPatient'];
                            delete key['isCompany'];
                            delete key['attributeList'];
                            delete key['isInvoiceNo'];
                            delete key['departmentCode'];
                            delete key['countryCode'];
                            delete key['customerCode'];
                            delete key['supplierCode'];
                            delete key['designationCode'];
                            delete key['costCenter'];
                            delete key['companyCode'];
                            delete key['patientCode'];
                            
                        });
                        angular.forEach($scope.deletedRow, function(key, index) {
                            delete key['isEmployee'];
                            delete key['isDepartment'];
                            delete key['isLocation'];
                            delete key['isCustomer'];
                            delete key['isSupplier'];
                            delete key['isDesignation'];
                            delete key['isCostCenter'];
                            delete key['isPatient'];
                            delete key['isCompany'];
                            delete key['attributeList'];
                            delete key['isInvoiceNo'];
                            delete key['departmentCode'];
                            delete key['countryCode'];
                            delete key['customerCode'];
                            delete key['supplierCode'];
                            delete key['designationCode'];
                            delete key['costCenter'];
                            delete key['companyCode'];
                            delete key['patientCode'];
                        });

                        $http.post('app/cashbankPayment/save', $scope.cashbankpaymentModelData).success(function(result) {
                            if (result) {
                                logger.logSuccess("Saved Successfully!");
                                $location.path($stateParams.tenantid +'/hospital/accounts/payment/list');
                            } else {
                                logger.logError("Payment Code Already Exist!");
                            }
                        }).error(function(result) {
                        });
                    } else {
                        angular.forEach($scope.cashbankpaymentModelData.cbptables, function(key, index) {
                            delete key['isEmployee'];
                            delete key['isDepartment'];
                            delete key['isLocation'];
                            delete key['isCustomer'];
                            delete key['isSupplier'];
                            delete key['isDesignation'];
                            delete key['isCostCenter'];
                            delete key['isPatient'];
                            delete key['isCompany'];
                            delete key['attributeList'];
                            delete key['isInvoiceNo'];
                            delete key['departmentCode'];
                            delete key['countryCode'];
                            delete key['customerCode'];
                            delete key['supplierCode'];
                            delete key['designationCode'];
                            delete key['costCenter'];
                            delete key['companyCode'];
                            delete key['patientCode'];
                        });
                        angular.forEach($scope.deletedRow, function(key, index) {
                            delete key['isEmployee'];
                            delete key['isDepartment'];
                            delete key['isLocation'];
                            delete key['isCustomer'];
                            delete key['isSupplier'];
                            delete key['isDesignation'];
                            delete key['isCostCenter'];
                            delete key['isPatient'];
                            delete key['isCompany'];
                            delete key['attributeList'];
                            delete key['isInvoiceNo'];
                            delete key['departmentCode'];
                            delete key['countryCode'];
                            delete key['customerCode'];
                            delete key['supplierCode'];
                            delete key['designationCode'];
                            delete key['costCenter'];
                            delete key['companyCode'];
                            delete key['patientCode'];
                        });

                        if ($scope.oldChequeNo != undefined && $scope.oldChequeNo != null && $scope.oldChequeNo != '' && $scope.cashbankpaymentModelData.chequeNo != undefined && $scope.cashbankpaymentModelData.chequeNo != null && $scope.cashbankpaymentModelData.chequeNo != '') {
                            if ($scope.oldChequeNo == $scope.cashbankpaymentModelData.chequeNo) {
                                $http.post('app/cashbankPayment/update', $scope.cashbankpaymentModelData).success(function(result) {
                                    if (result) {

                                        logger.logSuccess("Updated Successfully!");
                                        $location.path('hospital/accounts/payment/list');
                                    } else {
                                        logger.logError("Unable to Update.Please try again!");
                                    }
                                }).error(function(result) {
                                });
                            } else {
                                ngDialog.open({
                                    template : 'fileDiaglog',
                                    scope : $scope
                                });

                            }
                        } else {
                            $http.post('app/cashbankPayment/update', $scope.cashbankpaymentModelData).success(function(result) {
                                if (result) {

                                    logger.logSuccess("Updated Successfully!");
                                    $location.path($stateParams.tenantid +'/hospital/accounts/payment/list');
                                } else {
                                    logger.logError("Unable to Update.Please try again!");
                                }
                            }).error(function(result) {
                            });

                        }

                    }
               /* } else {
                    logger.logError("Please Add Cheque Number");
                }
*/
            } else {
                logger.logError("Please Add Atleast Row");
            }

        };

        $scope.updateConfirm = function() {
            $http.post('app/cashbankPayment/update', $scope.cashbankpaymentModelData).success(function(result) {
                if (result) {
                    logger.logSuccess("Updated Successfully!");
                    $location.path($stateParams.tenantid +'/hospital/accounts/payment/list');
                } else {
                    logger.logError("Unable to Update.Please try again!");
                }
            }).error(function(result) {
            });
            ngDialog.close();
        }

        /**
         * Edit functionality
         * 
         * fetching the details with voucher No
         * 
         */

        
        $scope.okedit = function() {
            ngDialog.close();
        };

        
        var voucherNo = $stateParams.voucherNo;
        $scope.isPo = false;
        if (voucherNo == undefined || voucherNo == null || voucherNo == "") {
            $scope.edit = false;
        } else {
            $scope.edit = true;
            $http.get('app/cashbankPayment/getPaymentVoucherDetailforEdit?voucherNo=' + voucherNo).success(function(data) {

                $scope.disabled = true;
                $scope.oldChequeNo = data.chequeNo;

                $scope.cashbankpaymentModelData = data;
                
                if ($scope.cashbankpaymentModelData.pmtType == "B") {
                    $scope.cashbankpaymentModelData.pmtType = "Bank";
                    $scope.cashAccountList = [];
                    $scope.bankAccountList = data.lBankList;
                    $scope.cashbankpaymentModelData.accountName = data.accountName;
                    $scope.oldChequeNo = data.chequeNo;

                } else if ($scope.cashbankpaymentModelData.pmtType == "C") {
                    $scope.cashbankpaymentModelData.pmtType = "Cash";
                    $scope.bankAccountList = [];
                    $scope.cashAccountList = data.lBankList;
                    $scope.cashbankpaymentModelData.accountName = data.accountName;
                    $scope.oldChequeNo = data.chequeNo;

                }
                $scope.isPo = false;
                
                
//              budgetTypeList
              //  $http.get('app/commonUtility/BudgetDefList').success(function(datas) {
              //      $scope.budgetTypeList = datas.lClassBasedOnSpecificRigths;
             //   });
       
               

                angular.forEach($scope.cashbankpaymentModelData.cbptables, function(row, index) {
                    if (row.costCenter == "" || row.costCenter == undefined || row.costCenter == null) {
                        row.costCenter = "";
                    }else{
                        $scope.cashbankpaymentModelData.cbptables[index].costCenter = row.costCenter;
                    }
                   
                    if (row.budgetDefnId == "" || row.budgetDefnId == undefined || row.budgetDefnId == null) {
                        row.budgetDefnId = "";
                    }else{
                        $scope.cashbankpaymentModelData.cbptables[index].budgetDefnId = row.budgetDefnId.toString();
                    }
                    if (row.companyCode == "" || row.companyCode == undefined || row.companyCode == null) {
                        row.companyCode = "";
                    }
                    if (row.employeeCode == "" || row.employeeCode == undefined || row.employeeCode == null) {
                        row.employeeCode = "";
                    }
                    if (row.departmentCode == "" || row.departmentCode == undefined || row.departmentCode == null) {
                        row.departmentCode = "";
                    }
                    if (row.countryCode == "" || row.countryCode == undefined || row.countryCode == null) {
                        row.countryCode = "";
                    }
                    if (row.customerCode == "" || row.customerCode == undefined || row.customerCode == null) {
                        row.customerCode = "";
                    }
                    if (row.supplierCode == "" || row.supplierCode == undefined || row.supplierCode == null) {
                        row.supplierCode = "";
                    }
                    if (row.designationCode == "" || row.designationCode == undefined || row.designationCode == null) {
                        row.designationCode = "";
                    }
                    if (row.purInvoiceNo != "" && row.purInvoiceNo != undefined && row.purInvoiceNo != null) {
                        row.isInvoiceNo = true;
                        $scope.isPo = true;
                    } 
                   else {
                        row.isInvoiceNo = false;

                    }
                    if (row.budgetDefnId == "" || row.budgetDefnId == undefined || row.budgetDefnId == null) {
                        row.budgetDefnId = "";
                    }else{
                        $scope.cashbankpaymentModelData.cbptables[index].budgetDefnId = row.budgetDefnId;
                    }
                    
                  for(var i=0;i<$scope.cashbankpaymentModelData.cbptables.length;i++){
                        
                        $scope.cbpmtDtlTotalAmt.totalBCAmount  += $scope.cashbankpaymentModelData.cbptables[i].cbpDtlBcAmount;
                    }
                });
                
                
                
                
                $scope.isPo = false;
                angular.forEach($scope.cashbankpaymentModelData.cbptablescash, function(row, index) {
                    if (row.denomAmt == "" || row.denomAmt == undefined || row.denomAmt == null) {
                        row.denomAmt = "";
                    }
                    if (row.countamt == "" || row.countamt == undefined || row.countamt == null) {
                        row.countamt = "";
                    }
                    if (row.rupessAmt == "" || row.rupessAmt == undefined || row.rupessAmt == null) {
                        row.rupessAmt = "";
                    }
                    
                    $scope.cashbankpaymentModelData.totalCashAmount =0;
                    for(var i=0;$scope.cashbankpaymentModelData.cbptablescash.length;i++){
                        
                        $scope.cashbankpaymentModelData.totalCashAmount  += $scope.cashbankpaymentModelData.cbptablescash[i].rupessAmt;
                    }
                   /* if (row.totalCashAmount == "" || row.totalCashAmount == undefined || row.totalCashAmount == null) {
                        row.totalCashAmount = "";
                    }
*/
                    
                   // $scope.cashbankpaymentModelData.cbptablescash.totalCashAmount=data.cbptablescash[0].totalCashAmount;
                    //$scope.purchaseInvoiceData.costCenter = data.purchaseInvoiceProdDetail[0].costCenter;


                });


                $scope.totalAmountCalculation();
               //    $scope.calculateAHAmount();
            }).error(function(data) {
            });
        }

        $scope.cancel = function() {
            $state.go("app.finance.accounts.payment.list");
        };

        /**
         * show Pending Payment - Invoice Details
         */
      $scope.showPaymentPriceDialog = function(cashbankpaymentForm, paidTo, selectedIndex) {

            if (paidTo != undefined || paidTo != "") {
                $scope.callPaymentPriceDialog($scope, paidTo, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, selectedIndex);
            } else {
                logger.logError("Please select a 'Sub Account (Vendor)' to add Invoice Details.");
                ngDialog.close();
            }
        };

        $scope.callPaymentPriceDialog = function($scope, paidTo, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, selectedIndex) {

            ngDialog.open({
                scope : $scope,
                template : 'views/finance/accounts/payment/cashbankPaymentPriceDialog',
                controller : $controller('cashbankPaymentInvoiceDtlAddCtrl', {
                    $scope : $scope,
                    paidToCode : paidTo,
                    $http : $http,
                    ngDialog : ngDialog,
                    logger : logger,
                    $injector : $injector,
                    sharedProperties : sharedProperties,
                    toaster : toaster,
                    $rootScope : $rootScope,
                    selectedRowId : selectedIndex
                }),
                className : 'ngdialog-theme-plain',
                showClose : false,
                closeByDocument : false,
                closeByEscape : false,
                preCloseCallback : $scope.getList
            });
        };


      /*  $scope.calculateTotalAmount = function() {
            //   $scope.purchaseInvoiceData.grantamount = $scope.purchaseInvoiceData.productwithTaxTotal + $scope.purchaseInvoiceData.chargeTotal + $scope.purchaseInvoiceData.ahTotal;
               $scope.cashbankpaymentModelData.rupessAmt = $scope.cashbankpaymentModelData.denomAmt * $scope.purchaseInvoiceData.countamt;

             
           };*/
        
        
      
    
      
        /**
         * print payment voucher
         */
        $scope.printPaymentVoucherDiv = function(voucherNo) {
            var url = 'app/cashbankPayment/print?cbVoucherNo=' + voucherNo;
            var wnd = window.open(url, 'Simatech', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
            wnd.print();
        }
        
        
        $scope.showPaymentInvoicePopup = function(selectedIndex, rowData ) {
            rowData.companyCode=$scope.cashbankpaymentModelData.companyName;
            if (rowData.cbdtlsubAccountCode == ""
                || rowData.cbdtlsubAccountCode == undefined) {
            logger.logError("please select Sub account code");
        }else if (rowData.companyCode == ""
            || rowData.companyCode == undefined) {
            logger.logError("please select Company");
            } else {
                ngDialog.open({
                    scope : $scope,
                    template : 'views/finance/accounts/payment/cashBankPaymentInvoiceDialog',
                    controller : $controller('cashbankPaymentInvoiceDtlAddCtrlNew', {
                        $scope : $scope,
                        rowData : rowData,
                        selectedRowId : selectedIndex
                    }),
                    className : 'ngdialog-theme-plain',
                    showClose : false,
                    closeByDocument : false,
                    closeByEscape : false,
                    preCloseCallback : $scope.getList
                });
            }

        }

        

    });
    
  app.controller('cashbankPaymentInvoiceDtlAddCtrlNew',function($scope, $http, $filter,$controller, logger, $rootScope, ngDialog, rowData,selectedRowId, $stateParams) {
        $scope.totalBCAmount = 0.0;
        $scope.totalTCAmount = 0.0;
        
        $rootScope.tempList = [];
        $rootScope.check = false;
        debugger;
        if (rowData.cbdtlsubAccountCode == ""
                || rowData.cbdtlsubAccountCode == undefined) {
            logger.logError("please select Sub account code");
        } else {
            $scope.paymentInformation = {
                piFromDate : '',
                piToDate : '',
                supplierName : rowData.cbdtlsubAccountCode,
                companyCode : rowData.companyCode,
                accountHeadCode : rowData.cbpdtlAccountHead,
                cbpdtlpaymentHead :rowData.cbpdtlpaymentHead
            };

            var sVoucherNo=$stateParams.voucherNo
         
            
            $http
                    .post( 'app/paymentInformation/showPendingPaymentInformationList',
                            $scope.paymentInformation)
                    .success(
                            function(data) {
                                if (data.success == true) {
                                    $scope.rowCollection = data.lPaymentInformationList;

                                } else {
                                    logger
                                            .logError("Unable to fetch the data.Please try again later");
                                }
                            }).error(function(data) {
                        console.log("data" + data);
                    });
        }

        $scope.cancelng = function() {
            ngDialog.close();
        }

        $scope.calculateBCAmountForIA = function(rowData) {
            debugger;
            var exRate=rowData.bcAmount/rowData.tcAmount;
            
            rowData.paidTCAmount = (parseFloat(rowData.payAmount)/exRate).toFixed(2);
            rowData.paidBCAmount =parseFloat(rowData.payAmount).toFixed(2);
            rowData.paidBCAmount =parseFloat(rowData.bcAmount-rowData.paidAmount).toFixed(2);

            $scope.calculateTotalAmountForIA();
        }

        $scope.calculateTCAmountForIA = function(rowData) {
            debugger;
            rowData.paidTCAmount = (parseFloat(rowData.paidBCAmount) * parseFloat(rowData.exchangeRate))
                    .toFixed(2);
            $scope.calculateTotalAmountForIA();
        }

        $scope.calculateTotalAmountForIA = function() {
            debugger;
            $scope.totalBCAmount = 0.0;
            $scope.totalTCAmount = 0.0;
            $scope.currencyCode = '';
            $scope.exchangerate;
            var iCounter = 0;
            var totBcAmt=0.0;
            var totTcAmt=0.0;
            angular
                    .forEach(
                            $scope.rowCollection,
                            function(row, index) {
                                var check = row.select;
                                if (check == true) {
                                    console.log(row);
                                    if(row.payAmount == 0){
                                        row.payAmount=row.bcAmount-row.paidAmount;
                                    }
                                    if (iCounter == 0) {
                                        iCounter++;
//                                      $scope.currencyCode = row.currencyCode;
                                        $scope.currencyCode = row.currencyName;
                                        $scope.exchangerate = parseFloat(row.exchangeRate);
                                        totBcAmt = parseFloat($scope.totalBCAmount)
                                                + parseFloat(row.payAmount);
                                        totTcAmt = parseFloat($scope.totalTCAmount)
                                                + parseFloat(row.paidTCAmount);
                                        $scope.totalBCAmount=totBcAmt.toFixed(2);
                                        $scope.totalTCAmount=totTcAmt.toFixed(2);
                                        
                                    } else {
//                                      if ($scope.currencyCode == row.currencyCode) {
                                        if ($scope.currencyCode == row.currencyName) {
//                                          $scope.currencyCode = row.currencyCode;
                                            $scope.currencyCode = row.currencyName;
                                            $scope.exchangerate = row.exchangeRate;
                                            totBcAmt = parseFloat($scope.totalBCAmount)
                                                    + parseFloat(row.payAmount);
                                            totTcAmt = parseFloat($scope.totalTCAmount)
                                                    + parseFloat(row.paidTCAmount);
                                            $scope.totalBCAmount=totBcAmt.toFixed(2);
                                            $scope.totalTCAmount=totTcAmt.toFixed(2);
                                        } else {
                                            row.select = false;
                                            logger
                                                    .logError("System doesn't allow Multicurrency option");
                                        }
                                    }
                                } else {

                                }
                            });
        }

        $scope.saveInvoiceDtl = function(displayedCollection) {
            var isFlag = true;
              debugger;

            rowData.invoicePaymentList = [];
            angular
                    .forEach(
                            displayedCollection,
                            function(row, index) {
                                if (isFlag) {
                                    var check = row.select;
                                    if (check == true) {
                                        if (row.payAmount == 0
                                                || row.payAmount == null) {
                                            isFlag = false;
                                            logger
                                                    .logError("Amount should be greater than 0 for selected row ");
                                        } else {
                                            isFlag = true;
                                            var exRate=row.bcAmount/row.tcAmount;
                                            row.payTCAmount=row.payAmount/exRate;
                                            rowData.invoicePaymentList
                                                    .push(row);
                                        }
                                    }
                                }

                            });
              debugger;
            /*if(rowData.cbInvoiceDtl.length>0 && isFlag){
                var sInvoiceNo='';
                angular.forEach(rowData.cbInvoiceDtl, function(row, index) {
                    if(index ==0)
                        sInvoiceNo =sInvoiceNo + row.invoiceNo
                    else
                        sInvoiceNo = sInvoiceNo +','+row.invoiceNo;
                });
                rowData.bcamount = $scope.totalBCAmount.toFixed(2);
                rowData.tcamount = $scope.totalTCAmount.toFixed(2);
                rowData.currency = $scope.currencyCode;
                rowData.exgRate  = $scope.exchangerate;
                rowData.invoiceNo=sInvoiceNo;
                rowData.isTCDisable =true;
                rowData.isBCDisable =true;
                rowData.isExDisable =true;
               // rowData.shortDetail=sInvoiceNo;
                $scope.totalAmountCalculation();        
                ngDialog.close();
            }*/
            if (rowData.invoicePaymentList.length > 0 && isFlag) {
                var sInvoiceNo = '';
                angular.forEach(rowData.k, function(row,
                        index) {
                    if (index == 0)
                        sInvoiceNo = rowData.invoicePaymentList[index].invoiceNumber;
                    
                });
                rowData.cbpDtlBcAmount = $scope.totalBCAmount;
                rowData.cbpDtlTcAmount = $scope.totalTCAmount;
                rowData.currency = $scope.currencyCode;
                rowData.cbpdtlCurrencyCode = $scope.currencyCode;
                rowData.cbpdtlExgRate = $scope.exchangerate;
                rowData.invoiceNo=sInvoiceNo;
                rowData.currencyFlag=true;
                // rowData.shortDetail=sInvoiceNo;
                $scope.totalAmountCalculation();
                ngDialog.close();
            }
             
            
        }
        
         
    });


 app.controller('cashbankPaymentInvoiceDtlAddCtrl', function($scope, $state, 
            $filter,$http, ngDialog, logger, paidToCode, $injector, sharedProperties ,  toaster, $rootScope, validationService, selectedRowId) { 
         $scope.departmentCollections = [];
        $scope.rowCollection = [];
        $scope.isValid = false;
        $scope.chkAll = false;
        $scope.checkAll = function(rowCollection, checkBox) {
            if (checkBox) {
                $scope.chkAll = true;
            } else {
                $scope.chkAll = false;
            }
            var i = 0;
            angular.forEach($scope.rowCollection, function(value, key) {
                value.select = $scope.chkAll;
            });

        };
        
        
        
        
        
        /**
         * load Product Table
         */
     /*   $scope.loadProdTable = function() {

            var table = {};
            table = {
                    denomAmt : '',
                    countamt : '',
                    rupessAmt : '',
                    totalCashAmount : 0
            };
            $scope.cashbankpaymentModelData.cbptablescash.push(table);
        }

        $scope.loadProdTable();*/

        $scope.addProdRow = function(cbptablescash) {
            var len = cbptablescash.length;
            var table = {
                    denomAmt : '',
                    countamt : '',
                    rupessAmt : '',
                    totalCashAmount : '',
            };
            //table.siNo = len + 1;
            cbptablescash.push(table);

        };

        $scope.removeProdRow = function(cbptablescash) {

            $scope.tableProdrow = [];
            angular.forEach(cbptablescash, function(row, index) {
                var check = row.select;
                if (check == undefined || check == "") {
                    $scope.tableProdrow.push(row);
                } else {

                }
            });
            $scope.cashbankpaymentModelData.cbptablescash = $scope.tableProdrow;
            $scope.cashbankpaymentModelData.totalCashAmount =0;
            for(var i=0;$scope.cashbankpaymentModelData.cbptablescash.length;i++){
                
                $scope.cashbankpaymentModelData.totalCashAmount  += $scope.cashbankpaymentModelData.cbptablescash[i].rupessAmt;
            }
         //   $scope.calculateProductAmount($scope.purchaseInvoiceData.purchaseInvoiceProdDetail);
        };

        $scope.calculateTotalAmountCash = function(countamt, trIndex, row) {
            row.totalCashAmount = parseFloat(countamt);
            if (row.denomAmt != 0 && row.denomAmt != "") {
                row.rupessAmt = parseFloat(countamt) * row.denomAmt;
                $scope.calculateAHAmount($scope.cashbankpaymentModelData.cbptablescash);
            } else {
                row.rupessAmt = parseFloat(countamt) * row.denomAmt;
                $scope.calculateAHAmount($scope.cashbankpaymentModelData.cbptablescash);
            }
        }
        
        $scope.calculateAHAmount = function(cbptablescash) {

            var totalCashAmount = 0.0;
            angular.forEach(cbptablescash, function(row, index) {

                totalCashAmount = totalCashAmount + parseFloat(row.rupessAmt);
            });
//alert("hhhtttttttt"+ahTotal);
            $scope.cashbankpaymentModelData.totalCashAmount = totalCashAmount;
           // $scope.calculateTotalAmount();
        };
       
        
        
        $scope.ok = function() {
            ngDialog.close();
        };

        $scope.getPendingInvoiceDetails = function() {
            if (paidToCode != "") {
                $http.get('app/cashbankPayment/getPendingInvoiceDetails?supplierCode=' + paidToCode).success(function(datas) {
                    $scope.rowCollection = datas.pendingInvoiceDtls;
                }).error(function(data) {
                });
            } else {
                logger.logError("Unavailable Invoice Details in selected 'Sub Account Code' (Vendor), !");
            }
        }
        $scope.getPendingInvoiceDetails();

        $scope.fetchInvoicePaymentListOnEdit = function(selectedRowId) {
            var cbPmtDtlJsonObj = $scope.cashbankpaymentModelData.cbptables[selectedRowId].invoicePaymentList;
            if (cbPmtDtlJsonObj.length > 0) {
                for (var i = 0; i < cbPmtDtlJsonObj.length; i++) {

                    var slabNewcashBankPmtDtlId = cbPmtDtlJsonObj[i].cashBankPmtDtlId;
                    var slabNewbcAmount = cbPmtDtlJsonObj[i].bcInvAmt;
                    var slabNewtcAmount = cbPmtDtlJsonObj[i].tcInvAmt;
                    var slabNewReceiptId = cbPmtDtlJsonObj[i].cbPmtInvDtlId;
                    var slabNewinvoiceNo = cbPmtDtlJsonObj[i].pInvoiceNo;
                    var slabNewPaidBcAmount = cbPmtDtlJsonObj[i].bcPaidAmt;
                    var slabNewPaidTcAmount = cbPmtDtlJsonObj[i].tcPaidAmt;
                    for (var j = 0; j < $scope.rowCollection.length; j++) {
                        var slabOldIvoiceNo = $scope.rowCollection[j].pInvoiceNo;
                        if (slabNewinvoiceNo == slabOldIvoiceNo) {
                            $("#dt_basic").find('.dataTables-Main-Body > tr >td#sectiondialog' + j + ' > div.checkbox input').prop('checked', true);
                        }
                    }
                }
            }
        }
        // $scope.fetchInvoicePaymentListOnEdit();
        /**
         * Calculate BC to TC Paid Amount via ng-keyup
         */
        $scope.calculateBcPaidToTcPaidAmount = function(bcPaidAmt, paymentCollections) {
            if (parseFloat(bcPaidAmt) <= parseFloat(paymentCollections.bcBalanceAmt)) {
                if (bcPaidAmt == paymentCollections.bcPaidAmt) {
                    var tcAmt = parseFloat(bcPaidAmt) / parseFloat(paymentCollections.exchangeRate);
                    paymentCollections.tcPaidAmt = tcAmt.toFixed(2);
                }
                $scope.isValid = false;
            } else {
                paymentCollections.tcPaidAmt = 0;
                $scope.isValid = true;
            }
        }
        /**
         * Calculate TC to BC Paid Amount via ng-keyup
         */
        $scope.calculateTcPaidToBcPaidAmount = function(tcPaidAmt, paymentCollections) {
            if (parseFloat(tcPaidAmt) <= parseFloat(paymentCollections.tcBalanceAmt)) {
                if (tcPaidAmt == paymentCollections.tcPaidAmt) {
                    var bcAmt = parseFloat(tcPaidAmt) * parseFloat(paymentCollections.exchangeRate);
                    paymentCollections.bcPaidAmt = bcAmt.toFixed(2);
                    $scope.isValid = false;
                }
            } else {
                paymentCollections.bcPaidAmt = 0;
                $scope.isValid = true;
            }
        }
        $scope.isCheckAmt = false;
        $scope.checkPaidAmount = function(paymentCollections) {

            var isAmtExceed = $scope.isPaidAmountExceed(paymentCollections);

            if (isAmtExceed) {
                $scope.isValid = false;
            } else {
                $scope.isValid = true;
                logger.logError("'BC Paid Amt' exceeding BC Balance Amount");
            }

        }

        $scope.isPaidAmountExceed = function(paymentCollections) {
            var isFlag = true;
            angular.forEach(paymentCollections, function(row, index) {

                if (row.select) {
                    if (!(parseFloat(row.bcPaidAmt) <= parseFloat(row.bcBalanceAmt))) {
                        isFlag = false;
                    }
                }
            });
            return isFlag;
        }

        $scope.getSelectedList = function(data) {

            $scope.paymentInvoiceDetails = [];
            $scope.isInvoiceSelected = false;

            angular.forEach(data, function(key, index) {

                if (key.select) {
                    $scope.isInvoiceSelected = true;
                    var obj = {
                        pInvoiceNo : key.pInvoiceNo,
                        bcInvAmt : key.bcInvAmt,
                        tcInvAmt : key.tcInvAmt,
                        currency : key.currency,
                        exchangeRate : key.exchangeRate,
                        bcPaidAmt : key.bcPaidAmt,
                        tcPaidAmt : key.tcPaidAmt,
                        bcBalanceAmt : key.bcBalanceAmt,
                        tcBalanceAmt : key.tcBalanceAmt
                    }
                    $scope.paymentInvoiceDetails.push(obj);
                }
            });
            if ($scope.isInvoiceSelected) {
                // Fetch Invoice No
                for (var iRowCtr = 0; iRowCtr < $scope.paymentInvoiceDetails.length; iRowCtr++) {
                    if ($scope.cashbankpaymentModelData.cbptables[selectedRowId].purInvoiceNo == "") {
                        $scope.cashbankpaymentModelData.cbptables[selectedRowId].purInvoiceNo = $scope.paymentInvoiceDetails[iRowCtr].pInvoiceNo;
                    } else {
                        $scope.cashbankpaymentModelData.cbptables[selectedRowId].purInvoiceNo += "," + $scope.paymentInvoiceDetails[iRowCtr].pInvoiceNo;
                    }
                }

                var currency = "", exchangerate = 0, paidBcAmt = 0, paidTcAmt = 0;
                for (var iRowCtr = 0; iRowCtr < $scope.paymentInvoiceDetails.length; iRowCtr++) {

                    if (currency != '') {
                        if (currency == $scope.paymentInvoiceDetails[iRowCtr].currency) {

                            currency = $scope.paymentInvoiceDetails[iRowCtr].currency + ",";
                            currency = currency.slice(0, currency.lastIndexOf(","));
                            $scope.cashbankpaymentModelData.cbptables[selectedRowId].cbpdtlCurrencyCode = currency;
                        } else {
                            currency += $scope.paymentInvoiceDetails[iRowCtr].currency + ",";
                            currency = currency.slice(0, currency.lastIndexOf(","));
                            $scope.cashbankpaymentModelData.cbptables[selectedRowId].cbpdtlCurrencyCode = currency;
                        }
                    } else {
                        currency = $scope.paymentInvoiceDetails[iRowCtr].currency + ",";
                        currency = currency.slice(0, currency.lastIndexOf(","));
                        $scope.cashbankpaymentModelData.cbptables[selectedRowId].cbpdtlCurrencyCode = currency;
                    }

                    exchangerate = parseFloat($scope.paymentInvoiceDetails[iRowCtr].exchangeRate).toFixed(2);
                    $scope.cashbankpaymentModelData.cbptables[selectedRowId].cbpdtlExgRate = exchangerate;

                    paidBcAmt = paidBcAmt + parseFloat($scope.paymentInvoiceDetails[iRowCtr].bcPaidAmt);
                    $scope.cashbankpaymentModelData.cbptables[selectedRowId].cbpDtlBcAmount = paidBcAmt;

                    paidTcAmt = paidTcAmt + parseFloat($scope.paymentInvoiceDetails[iRowCtr].tcPaidAmt);
                    $scope.cashbankpaymentModelData.cbptables[selectedRowId].cbpDtlTcAmount = paidTcAmt;
                }

                if ($scope.cashbankpaymentModelData.cbptables[selectedRowId].purInvoiceNo != "") {
                    $scope.cashbankpaymentModelData.cbptables[selectedRowId].isInvoiceNo = true;
                }

                $scope.cashbankpaymentModelData.cbptables[selectedRowId].invoicePaymentList = $scope.paymentInvoiceDetails;
                ngDialog.close();
                $scope.totalAmountCalculation();
            } else {
                logger.logError("Please Select an Pending Invoice Details!")
            }

        };

        $scope.totalAmountCalculation = function() {
            var cbpDtlRowDatas = $scope.cashbankpaymentModelData.cbptables;
            var bcAmt = 0, tcAmt = 0;
            angular.forEach(cbpDtlRowDatas, function(item, key) {
                var cbpTblRowData = cbpDtlRowDatas[key];

                bcAmt += parseFloat(item.cbpDtlBcAmount);
                tcAmt += parseFloat(item.cbpDtlTcAmount);
                $scope.cbpmtDtlTotalAmt.totalBCAmount = bcAmt;
                $scope.cbpmtDtlTotalAmt.totalTCAmount = tcAmt;

            });
        }
        $scope.cancelInvoicePriceDialog = function() {
            ngDialog.close();
        };
    });

    app.factory("ListService", function($http, $q, logger,$filter,$stateParams  ) {
        var cbPaymentService = new Object();
        cbPaymentService.getPmtTypeList = function() {
            var typeData = $q.defer();
            var typeList = [ {
                "id" : "bank",
                "text" : "Bank"
            }, {
                "id" : "cash",
                "text" : "Cash"
            } ];
            typeData.resolve(typeList);
            return typeData.promise
        }

        cbPaymentService.getBankAcctList = function(pmtType,com) {
            var bankAccountList = $q.defer();
            if(com!=null && com!='' && com!= undefined){
            $http.get('app/cashbankPayment/getBankAcctListcompany?companyName=' + com).success(function(data) {



                 if(data.length > 0)
               {
                     bankAccountList.resolve(data);
               }
                
           });
            }else{
            $http.get('app/cashbankPayment/getBankAcctList?paymentType=' + pmtType).success(function(data) {
                var acctList = [];

                angular.forEach(data, function(item, key) {
                    var accObj = new Object();
                    accObj.id = data[key].acctHeadCode;
                    accObj.text = data[key].accountName;
                    accObj.currencyCode = data[key].currencyCode;
                    accObj.exchangeRate = data[key].exchangeRate;
                    acctList.push(accObj);
                });
                bankAccountList.resolve(acctList);

            }).error(function(data) {

                bankAccountList.reject("Failed to get Bank Account List");

            });
            }
            return bankAccountList.promise;
        }

        cbPaymentService.getCashAcctList = function(pmtType) {
            var cashAccountList = $q.defer();

            $http.get('app/cashbankPayment/getBankAcctList?paymentType=' + pmtType).success(function(data) {

                var acctList = [];

                angular.forEach(data, function(item, key) {
                    var accObj = new Object();
                    accObj.id = data[key].acctHeadCode;
                    accObj.text = data[key].accountName;
                    accObj.currencyCode = data[key].currencyCode;
                    accObj.exchangeRate = data[key].exchangeRate;
                    acctList.push(accObj);
                });

                cashAccountList.resolve(acctList);

            }).error(function(data) {

                cashAccountList.reject("Failed to get Cash Account List");

            });
            return cashAccountList.promise;
        }

        cbPaymentService.getCompanyList = function() {
            var companyList = $q.defer();

            $http.get($stateParams.tenantid + '/app/commonUtility/getCompanyList').success(function(datas) {
                companyList.resolve(datas);
//                alert("heo");
//                var foundItemDest = $filter('filter')(datas, { baseCompany:  1 })[0];
//                $scope.cashbankpaymentModelData.companyName=foundItemDest.text;
//                alert("heo"+foundItemDest.text);

            }).error(function(datas) {
                companyList.reject("Failed to get Company List");
            });
            return companyList.promise;
        }
        
        

        cbPaymentService.getSubGroupListForDtl = function() {
            var cbpdtlSubGrpAcctList = $q.defer();
            $http.get('app/purchaseinvoice/getSubGroupList').success(function(datas) {
                cbpdtlSubGrpAcctList.resolve(datas);
            }).error(function(datas) {
                cbpdtlSubGrpAcctList.reject("Failed to get Sub Group List");
            });
            return cbpdtlSubGrpAcctList.promise;
        }
        cbPaymentService.getAccountListForDtl = function() {
            var cbpdtlAcctHeadList = $q.defer();
            $http.get('app/purchaseinvoice/getAccountList').success(function(datas) {

                var acctList = [];
                angular.forEach(datas, function(item, key) {
                    var accObj = new Object();
                    accObj.id = datas[key].accountHeadCode;
                    accObj.text = datas[key].accountHeadName;
                    acctList.push(accObj);
                });

                cbpdtlAcctHeadList.resolve(acctList);
            }).error(function(datas) {
                cbpdtlAcctHeadList.reject("Failed to get Account List");
            });
            return cbpdtlAcctHeadList.promise;
        }

        return cbPaymentService;
    });

   app.controller('tableCtrl', function($scope, $http, $filter, logger,$stateParams ) {
        $scope.isSub = true;
        
        
        
        $http.get("app/cashbankPayment/paymentList").success(function(datas) {
            $scope.paymentList = datas;
        });
     
        

        

        /*$scope.$watchCollection('[cashbankpaymentModelData.cbptables[trIndex].budgetDefnId,cashbankpaymentModelData.cbptables[trIndex].costCenter]', function(newValue, oldValue) {
            if (newValue != '' && newValue != undefined && newValue != null) {
                    $scope.tempcbpdetails = [];
                    $scope.tempcbpdetails = $scope.cashbankpaymentModelData.cbptables;

//                angular.forEach($scope.tempcbpdetails, function(key, index) {
//                    delete key['select'];
//                    delete key['isEmployee'];
//                    delete key['isDepartment'];
//                    delete key['isLocation'];
//                    delete key['isCustomer'];
//                    delete key['isSupplier'];
//                    delete key['isDesignation'];
//                    delete key['isCostCenter'];
//                    delete key['isPatient'];
//                    delete key['isCompany'];
//                    delete key['attributeList'];
//                    delete key['isInvoiceNo'];
//                });
                if($scope.tempcbpdetails[$scope.trIndex].budgetDefnId != null
                    && $scope.tempcbpdetails[$scope.trIndex].budgetDefnId != ""
                        &&$scope.tempcbpdetails[$scope.trIndex].budgetDefnId != undefined){
                $http.get('app/cashbankPayment/getBudgetValue?costCenter=' + 
                        $scope.tempcbpdetails[$scope.trIndex].costCenter
                        +'&budgetDefId='+ $scope.tempcbpdetails[$scope.trIndex].budgetDefnId
                        ).success(function(data) {
//                          $http.get($stateParams.tenantid+'/app/ratequotation/getfreightType?chargeType='+newValue+'&pol='+ $scope.ratequotation.pol).success(function(datas) {

                          $scope.cashbankpaymentModelData.cbptables[$scope.trIndex].budgetAmt = data.budgetAmt;
      //
                          $scope.cashbankpaymentModelData.cbptables[$scope.trIndex].budgetUtilizedAmt = data.budgetUtilizedAmt;  
                
                });
        }
            }
        });*/
         $scope.$watch('cashbankpaymentModelData.cbptables[trIndex].budgetDefnId', function(newValue, oldValue) {
            if (newValue != '' && newValue != undefined && newValue != null) { 
                    $scope.tempcbpdetails = [];
                    $scope.tempcbpdetails = $scope.cashbankpaymentModelData.cbptables;

//                angular.forEach($scope.tempcbpdetails, function(key, index) {
//                    delete key['select'];
//                    delete key['isEmployee'];
//                    delete key['isDepartment'];
//                    delete key['isLocation'];
//                    delete key['isCustomer'];
//                    delete key['isSupplier'];
//                    delete key['isDesignation'];
//                    delete key['isCostCenter'];
//                    delete key['isPatient'];
//                    delete key['isCompany'];
//                    delete key['attributeList'];
//                    delete key['isInvoiceNo'];
//                });
                if($scope.tempcbpdetails[$scope.trIndex].budgetDefnId != null
                    && $scope.tempcbpdetails[$scope.trIndex].budgetDefnId != ""
                        &&$scope.tempcbpdetails[$scope.trIndex].budgetDefnId != undefined){
                $http.get('app/cashbankPayment/getBudgetValue?costCenter=' + 
                        $scope.tempcbpdetails[$scope.trIndex].costCenter
                        +'&budgetDefId='+ $scope.tempcbpdetails[$scope.trIndex].budgetDefnId
                        ).success(function(data) {
//                          $http.get($stateParams.tenantid+'/app/ratequotation/getfreightType?chargeType='+newValue+'&pol='+ $scope.ratequotation.pol).success(function(datas) {

                          $scope.cashbankpaymentModelData.cbptables[$scope.trIndex].budgetAmt = data.budgetAmt;
      //
                          $scope.cashbankpaymentModelData.cbptables[$scope.trIndex].budgetUtilizedAmt = data.budgetUtilizedAmt;  
                
                });
        }
            }
        });
        $scope.$watch('cashbankpaymentModelData.cbptables[trIndex].costCenter', function(newValue, oldValue) {
            if (newValue != '' && newValue != undefined && newValue != null) { 
                $http.get($stateParams.tenantid + '/app/commonUtility/BudgetDefListCC?costCenter='+newValue).success(function(datas) {
                   $scope.budgetTypeList = datas.lClassBasedOnSpecificRigths;
              }); }else if(newValue==''){
                   $scope.budgetTypeList =[];
                   $scope.cashbankpaymentModelData.cbptables[$scope.trIndex].budgetDefnId='';
                    $scope.cashbankpaymentModelData.cbptables[$scope.trIndex].budgetAmt = '';
                   $scope.cashbankpaymentModelData.cbptables[$scope.trIndex].budgetUtilizedAmt = '';  
                                      $scope.cashbankpaymentModelData.cbptables[$scope.trIndex].budgetUtilizedAmt = 0;  

              }
        });
        
        
        //vendor
        
        $scope.$watch('cashbankpaymentModelData.paidTo', function(newValue, oldValue) {


               
               if($scope.cashbankpaymentModelData.paidTo == "Vendor"){

                   $http.get('app/journalVoucher/getvendorList').success(function(datas) {
                       $scope.subAccountCodeList1 = datas;
                   }).error(function(datas) {
                       logger.logError("Error Please Try Again");
                   });
           }
               
               
               if($scope.cashbankpaymentModelData.paidTo == "Others"){

                   $http.get('app/journalVoucher/getvendorothercuList').success(function(datas) {
                       $scope.subAccountCodeList1 = datas;
                   }).error(function(datas) {
                       logger.logError("Error Please Try Again");
                   });
           }
           });
        
        
        
       /* $scope.$watch('cashbankpaymentModelData.cbptables[trIndex].cbpdtlAccountHead', function(newValue, oldValue) {

            if (newValue != '' && newValue != undefined) {
                var type = '';

                if (newValue == '20060001')
                    type = "payment"
                else if (newValue == '10060001')
                    type = "receipt"
                else if (newValue == '10040006')
                    type = "employee"

            
            if(newValue =='10080001' || newValue =='10040001' ){

                $http.get('app/journalVoucher/getSubAcctHeadList').success(function(datas) {
                    $scope.subAccountCodeList1 = datas;
                }).error(function(datas) {
                    logger.logError("Error Please Try Again");
                });
        }
            
            
            if(newValue =='20060001' || newValue =='20000001'){

                $http.get('app/journalVoucher/getSubAcctHeadVendorList').success(function(datas) {
                    $scope.subAccountCodeList1 = datas;
                }).error(function(datas) {
                    logger.logError("Error Please Try Again");
                });
        }
                        if (newValue != '' && newValue != undefined) {
                            debugger;
//                            if (newValue == '20060001') {
                             //   $scope.objCBReceipt.cshBankDetail[$scope.$index].isTradeDebtors = true;
                                $http.get('app/commonUtility/getSubAccountCodeLists').success(function(datas) {
                                    $scope.objCBReceipt.cshBankDetail[$scope.$index].subAccountCodeList = datas.commonUtilityBean;
                                    $scope.objCBReceipt.cshBankDetail[$scope.$index].isSubAccountCode = true;
                                    var subAcctList = [];
                                    angular.forEach(datas.commonUtilityBean, function(item, key) {
                                        var subAccHdObj = new Object();
                                        subAccHdObj.id = datas.commonUtilityBean[key].subAccountCode;
                                        subAccHdObj.text = datas.commonUtilityBean[key].subAccountName;
                                        subAcctList.push(subAccHdObj);
                                    });
                                    $scope.subAccountCodeList = subAcctList;
                                }).error(function(datas) {
                                });
//                            }  else {
//                             //   $scope.objCBReceipt.cshBankDetail[$scope.$index].isTradeDebtors = false;
//                              //  $scope.objCBReceipt.cshBankDetail[$scope.$index].subAccountCodeList = [];
////                               / $scope.objCBReceipt.cshBankDetail[$scope.$index].isSubAccountCode = false;
//                            }

                             
                            
                            
                $http.get($stateParams.tenantid + '/app/commonUtility/getAttributesList?accountCode=' + newValue).success(function(datas) {
                    $scope.cashbankpaymentModelData.cbptables[$scope.$index].attributeList = datas;
                    if (newValue == oldValue) {
                        $scope.isOnChange = false;
                    } else {
                        $scope.isOnChange = true;
                    }
                    if (!$scope.edit || $scope.isOnChange) {

                        $scope.cashbankpaymentModelData.cbptables[$scope.$index].employeeCode = '';
                        $scope.cashbankpaymentModelData.cbptables[$scope.$index].departmentCode = '';
                        $scope.cashbankpaymentModelData.cbptables[$scope.$index].countryCode = '';
                        $scope.cashbankpaymentModelData.cbptables[$scope.$index].customerCode = '';
                        $scope.cashbankpaymentModelData.cbptables[$scope.$index].supplierCode = '';
                        $scope.cashbankpaymentModelData.cbptables[$scope.$index].designationCode = '';
                        $scope.cashbankpaymentModelData.cbptables[$scope.$index].costCenter = '';
                        $scope.cashbankpaymentModelData.cbptables[$scope.$index].companyCode = '';
                        $scope.cashbankpaymentModelData.cbptables[$scope.$index].patientCode = '';
                    }

                    $scope.cashbankpaymentModelData.cbptables[$scope.$index].isEmployee = false;

                    $scope.cashbankpaymentModelData.cbptables[$scope.$index].isDepartment = false;

                    $scope.cashbankpaymentModelData.cbptables[$scope.$index].isLocation = false;
                    $scope.cashbankpaymentModelData.cbptables[$scope.$index].isCustomer = false;
                    $scope.cashbankpaymentModelData.cbptables[$scope.$index].isSupplier = false;
                    $scope.cashbankpaymentModelData.cbptables[$scope.$index].isDesignation = false;
                    $scope.cashbankpaymentModelData.cbptables[$scope.$index].isCostCenter = false;
                    $scope.cashbankpaymentModelData.cbptables[$scope.$index].isCompany = false;

                    $scope.cashbankpaymentModelData.cbptables[$scope.$index].isPatient = false;

                    angular.forEach($scope.cashbankpaymentModelData.cbptables[$scope.$index].attributeList, function(row, rowindex) {
                        if (row.attributeName == "Employee") {
                            $scope.cashbankpaymentModelData.cbptables[$scope.$index].isEmployee = true;
                        } else if (row.attributeName == "Department") {
                            $scope.cashbankpaymentModelData.cbptables[$scope.$index].isDepartment = true;
                        } else if (row.attributeName == "Students") {
                            $scope.cashbankpaymentModelData.cbptables[$scope.$index].isLocation = true;
                        } else if (row.attributeName == "Customer") {
                            $scope.cashbankpaymentModelData.cbptables[$scope.$index].isCustomer = true;
                        } else if (row.attributeName == "Supplier") {
                            $scope.cashbankpaymentModelData.cbptables[$scope.$index].isSupplier = true;
                        } else if (row.attributeName == "Designation") {
                            $scope.cashbankpaymentModelData.cbptables[$scope.$index].isDesignation = true;
                        } else if (row.attributeName == "Cost Center") {
                            $scope.cashbankpaymentModelData.cbptables[$scope.$index].isCostCenter = true;
                        } else if (row.attributeName == "Company") {
                            $scope.cashbankpaymentModelData.cbptables[$scope.$index].isCompany = true;
                        } else if (row.attributeName == "Patient") {
                            $scope.cashbankpaymentModelData.cbptables[$scope.$index].isPatient = true;
                        }
                    });
                }).error(function(datas) {
                });

            }
        });*/

    });

    app.directive('numbersOnly', function(logger) {
        return {
            require : 'ngModel',
            link : function(scope, element, attrs, modelCtrl) {

                modelCtrl.$parsers.push(function(inputValue) {
                    var inputValue = modelCtrl.$viewValue;

                    if (inputValue == undefined)
                        return ''
                    var transformedInput = inputValue.replace(/[^0-9.]/g, '');
                    if (transformedInput != inputValue) {
                        modelCtrl.$setViewValue(transformedInput);
                        modelCtrl.$render();
                    } else {
                    }

                    return transformedInput;
                });
            }
        };
        
        
        
        
        
    });
  
//});