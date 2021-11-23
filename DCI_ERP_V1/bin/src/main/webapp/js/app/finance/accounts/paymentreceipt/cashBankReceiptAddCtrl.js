//define([ 'hospital/accounts/accounts' ], function(module) {

    'use strict';

    app.controller('cashBankReceiptAddCtrl', function($scope, 
            $rootScope, $http, logger, $log, ngDialog, $modal, $location,
            $filter, utilsService, CBRECEIPT, $state, sharedProperties, 
            $stateParams, validationService, toaster, $injector, $controller) {
        $scope.pmtTypeShow = true;
        $scope.accountListData = [];
        $scope.typeList = [];
        $scope.bankList = [];
        $scope.cashList = [];
        $scope.companyList = [];
    	$scope.receiptList=[];

        $scope.globalAccountListData = [];
        $scope.receivedFromList = [];
        $scope.objCBReceipt = {
            paymentMode : "B",
            accountName : '',
            companyCode : 'C0002',
            bankAcc : '',
            receipt :'',
            cashAcc : '',
            bcAmountHdr : '',
            tcAmountHdr : '',costCenter : 'OS',
            exchangeRate : '1',
            currency : 'INR',
            narration : '',
            receivedFrom : '',
            cbReceiptDate : '',
            chequeDate : '',
            chequeNO : '',
            voucherNo1:'',
            cshBankDetail : [],
            receiptfrom:'',
            approvenote :''
        };
        $scope.edit = false;
        $scope.view = false;
        $scope.cbRcptDtlTotalAmt = {
            totalBCAmount : 0.0,
            totalTCAmount : 0.0
        }

        
        
        
        
        $scope.$watch('objCBReceipt.cbReceiptDate', function(value, oldValue) {
            debugger
            if (value != '' && value != undefined) {
            var res = value.split("/");
            var formCode='F3817';
            $http.get('app/journalVoucher/getloggedcompany?closingDate='+value+'&formCode='+formCode).success(function(datas) {
            if(datas){
            logger.logError("Account closed for year "+ res[2]);
            $scope.objCBReceipt.cbReceiptDate = '';
            }
            })
            }
            });
        
        


 /*       
        $scope.receiptList=[];
		$scope.getreceiveStatus = function() {
		    var  data = {};
		    data["id"] = "College";
		    data["text"] = "College";
		    $scope.receiptList.push(data);
		    data = {};
		    data["id"] = "Others";
		    data["text"] = "Others";
		    $scope.receiptList.push(data); 
		    
		    
		}
		$scope.getreceiveStatus();
        */
        
        

        
        $scope.$watch('objCBReceipt.companyCode', function(newValue, oldValue) {
            //  alert(newValue);
               if(newValue!=null && newValue!=undefined && newValue != '' && $scope.objCBReceipt.paymentMode == "B"){
               //    $http.post($stateParams.tenantid+ '/app/commonUtility/getVoyageListByVessel',newValue).success(function(data) {
                   
                   
                   if ($scope.objCBReceipt.paymentMode == "B") {
                    
                   $http.get('app/cashbankPayment/getBankAcctListcompanyNew?companyName=' + $scope.objCBReceipt.companyCode).success(function(data) {

                        $scope.objCBReceipt.companyCode = newValue;


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
        
        
        $scope.$watch('objCBReceipt.companyCode', function(newValue, oldValue) {
            //  alert(newValue);
               if(newValue!=null && newValue!=undefined && newValue != '' && $scope.objCBReceipt.paymentMode == "C"){
               //    $http.post($stateParams.tenantid+ '/app/commonUtility/getVoyageListByVessel',newValue).success(function(data) {
                
                    
                   if ($scope.objCBReceipt.paymentMode == "C") {
                    
                    $http.get('app/cashbankPayment/getCashAcctListcompanyNew?companyName=' + $scope.objCBReceipt.companyCode).success(function(data) {

                        $scope.objCBReceipt.companyCode = newValue;
                        


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
        
        
        
        
        
        
        
        $scope.$watch('objCBReceipt.companyCode', function(newValue, oldValue) {
            // alert(newValue);
              if($scope.view==false){
              if(newValue!=null && newValue!=undefined && newValue != ''){
              //    $http.post($stateParams.tenantid+ '/app/commonUtility/getVoyageListByVessel',newValue).success(function(data) {
                   $http.get('app/cashbankPayment/getBankAcctListcompanycode?companyCode=' + $scope.objCBReceipt.companyCode).success(function(data) {

                       $scope.objCBReceipt.companyCode = newValue;

                        if(data.length > 0)
                      {
                      $scope.bankList = data;
                      }
                       /* else{
                            
                            logger.logError("Voyage is not available for the given vessel");
                            
                        }*/
                  });
              }
              } 
            });
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
            $scope.objCBReceipt.cbReceiptDate = $scope.date;
        }
        $scope.getCurrentDate();
        
   $scope.costList = [];

        
        $http.get("app/purchaseinvoice/costcenterlist").success(function(datas) {
            $scope.costList = datas;
        });

        /**
         * validation
         */
        $scope.validate = function(cashBankReceiptForm, objCBReceipt) {
            if (new validationService().checkFormValidity($scope.cashBankReceiptForm)) {

                if (!$scope.edit) {
                    if ($scope.objCBReceipt.bcAmountHdr > 0) {
                        if (parseFloat($scope.objCBReceipt.bcAmountHdr) ==parseFloat($scope.cbRcptDtlTotalAmt.totalTCAmount)) {
                            $scope.save(cashBankReceiptForm, objCBReceipt);
                        } else {
                            logger.logError('Amount should match!');
                        }
                    } else {
                        logger.logError('Please Enter Amount!');
                    }
                } else {
                    $scope.save(cashBankReceiptForm, objCBReceipt);
                }
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.cashBankReceiptForm.$validationSummary), 555000, 'trustedHtml');
            }
        };

        /** GET TYPE OF RECEIPT - Bank/Cash ****************** */
        $scope.tempList = CBRECEIPT.getTypeList();

        $scope.tempList.then(function(data) {
            $scope.typeList = data;
        });

        $scope.tempCompanyList = CBRECEIPT.getCompanyList();
        
      /*  $http.get( $stateParams.tenantid +'/app/commonUtility/getCompanyList').success(function(datas) {
            $scope.companyList = datas;
                var foundItemDest = $filter('filter')($scope.companyList, {
                    baseCompany : 1
                    
                })[0];
       

                $scope.objCBReceipt.companyCode=foundItemDest.id;
        }).error(function(datas) {
        });
*/
        $scope.tempCompanyList.then(function(data) {
            $scope.companyList = data;
        });

        $scope.getCompanyCodeWithUser = function() {
            $http.get( $stateParams.tenantid +'/app/commonUtility/getCompanyListWithUser').success(function(datas) {
                $scope.objCBReceipt.companyCode = datas.commonUtilityBean[0].value;
                $scope.objCBReceipt.compLocationName = datas.commonUtilityBean[0].description;
            }).error(function(datas) {
                logger.logError("Error Please Try Again");
            });
        }
        $scope.$watch('objCBReceipt.paymentMode', function(newValue, oldValue) {
            var com=  $scope.objCBReceipt.companyCode;

            if (newValue == "C") {
                $scope.pmtTypeShow = false;

                $scope.getCashList();
                $scope.bankList = [];
                $scope.objCBReceipt.chequeDate = '';
                $scope.objCBReceipt.chequeNO = '';
                $scope.objCBReceipt.paymentMode = "C";
            } else if (newValue == "B") {
                $scope.pmtTypeShow = true;
                $scope.getBankList(com);
                $scope.cashList = [];
            }
        });

        /**
         * ************** ******* cash account onchange - fetch into currency,
         * exchange rate ****************
         */
        $scope.$watch('objCBReceipt.cashAcc', function(newValue, oldValue) {
            if (newValue != '' && newValue != undefined) {
                $scope.objCBReceipt.cashAcc = newValue;
                $scope.objCBReceipt.bankAcc = '';
                $scope.objCBReceipt.accountName = newValue;

                $http.post('app/cashbankreceipt/getCurrencyAndExchangeRate', newValue).success(function(datas) {
                    $scope.objCBReceipt.exchangeRate = datas.objCashBankReceiptListListBean[0].exchangeRate;
                    $scope.objCBReceipt.currency = datas.objCashBankReceiptListListBean[0].acctCurrency;
                }).error(function(datas) {
                    logger.logError("Error Please Try Again");
                });
            }
        });

        /**
         * ************** ******* bankaccount onchange - fetch into currency,
         * exchange rate ****************
         */
        $scope.$watch('objCBReceipt.bankAcc', function(newValue, oldValue) {
            if (newValue != '' && newValue != undefined) {
                $scope.objCBReceipt.bankAcc = newValue;
                $scope.objCBReceipt.cashAcc = '';
                $scope.objCBReceipt.accountName = newValue;
                $http.post('app/cashbankreceipt/getCurrencyAndExchangeRate', newValue).success(function(datas) {
                    $scope.objCBReceipt.exchangeRate = datas.objCashBankReceiptListListBean[0].exchangeRate;
                    $scope.objCBReceipt.currency = datas.objCashBankReceiptListListBean[0].acctCurrency;
                }).error(function(datas) {
                    logger.logError("Error Please Try Again");
                });
            }
        });

        /**
         * **************** Bank / Cash Acct List *********** Dropdown in
         * selectivity ******************
         */
        $scope.getBankList = function(com) {
            $scope.tempList = CBRECEIPT.getBankList(com);
            $scope.tempList.then(function(data) {
                $scope.bankList = data;
            });
        };
        $scope.getCashList = function() {
            $scope.tempList = CBRECEIPT.getCashList();
            $scope.tempList.then(function(data) {
                $scope.cashList = data;
            });
        };

        /**
         * ********************** Header Amount Calculation to Amount
         * USD******************************************
         */
        /**
         * BC To TC Amount Calculation - Header
         */
        $scope.bcToTcHdrAmtCalculation = function(bcAmount) {
            if ($scope.objCBReceipt.exchangeRate != 0 && $scope.objCBReceipt.exchangeRate != "") {
                $scope.objCBReceipt.tcAmountHdr = parseFloat(bcAmount) / $scope.objCBReceipt.exchangeRate;
            } else {
                $scope.objCBReceipt.tcAmountHdr = 1;
            }

        }
        /**
         * TC To BC Amount Calculation - Header
         */
        $scope.tcToBcHdrAmtCalculation = function(tcAmount) {
            if ($scope.objCBReceipt.exchangeRate != 0 && $scope.objCBReceipt.exchangeRate != "") {
                $scope.objCBReceipt.bcAmountHdr = parseFloat(tcAmount) * $scope.objCBReceipt.exchangeRate;
            } else {
                $scope.objCBReceipt.bcAmountHdr = 1;
            }

        }

        // cancel Functionality
        $scope.cancel = function() {
            $location.path( $stateParams.tenantid +'/hospital/accounts/paymentreceipt/list');
//            $state.go('app.hospital.accounts.paymentreceipt.list');
        };

        $scope.onChangeNumber = function(ids, num) {

            num = num.replace(/[^0-9 .]/g, '');
            $('#' + ids).val(num);
            return num;
        }

        /**
         * 1st table ******************* cbp receipt detail
         * **********************************
         */

        $scope.getDropdownValues = function() {
            $http.get('app/cashbankreceipt/getReceivedFromList').success(function(datas) {
                $scope.receivedFromList = datas;
            }).error(function(datas) {
            });
           /* $http.get('app/commonUtility/getCrDtlAccountHeadData').success(function(datas) {
                $scope.globalAccountListData = datas.commonUtilityBean;
                if (datas.commonUtilityBean.length > 0) {
                    var acctHeadList = [];
                    angular.forEach(datas.commonUtilityBean, function(item, key) {
                        var accHdObj = new Object();
                        accHdObj.id = datas.commonUtilityBean[key].accountHeadCode;
                        accHdObj.text = datas.commonUtilityBean[key].accountHeadName;

                        acctHeadList.push(accHdObj);
                    });
                    $scope.accountList = acctHeadList;
                }
            }).error(function(data) {
            });*/
            
            $http.get('app/journalVoucher/getAccountNewHeadList').success(function(datas) {
                $scope.accountList = datas;
            }).error(function(datas) {
                logger.logError("Error Please Try Again");
            });


        /*    $http.get('app/commonUtility/getSubAccountCodeList?type=receipt').success(function(datas) {
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
            // Attributes Dropdown

            $http.get( $stateParams.tenantid +'/app/commonUtility/getEmployeeList').success(function(datas) {
                $scope.employeeList = datas;
            }).error(function(datas) {
            });

            $http.get( $stateParams.tenantid +'/app/commonUtility/getDepartmentList').success(function(datas) {
                $scope.departmentList = datas;
            }).error(function(datas) {
            });

            $http.get( $stateParams.tenantid +'/app/commonUtility/getCountryList').success(function(datas) {
                $scope.countryList = datas;
            }).error(function(datas) {
            });
            $http.get( $stateParams.tenantid +'/app/commonUtility/getSupplierList').success(function(datas) {
                $scope.supplierList = datas;
            }).error(function(datas) {
            });
            $http.get('app/commonUtility/getCustomerAttributeList').success(function(datas) {
                $scope.customerList = datas;
            }).error(function(datas) {
            });

            $http.get( $stateParams.tenantid +'/app/commonUtility/getDesignationList').success(function(datas) {
                $scope.designationList = datas;
            }).error(function(datas) {
            });
            
            
            $http.get('app/commonUtility/getstudentList').success(function(datas) {
                $scope.studentList = datas;
            }).error(function(datas) {
            });

            $http.get( $stateParams.tenantid +'/app/commonUtility/getCostCenter').success(function(datas) {
                $scope.costCenterList = datas;
            }).error(function(datas) {
            });

            $http.get( $stateParams.tenantid +'/app/commonUtility/getCompanyList').success(function(datas) {
                $scope.companyList = datas;
            }).error(function(datas) {
            });
            $http.get( $stateParams.tenantid +'/app/commonUtility/getPatientList').success(function(datas) {
                $scope.patientList = datas;
            }).error(function(datas) {
            });
        }
        $scope.getDropdownValues();

        $scope.loadCBRcptTable = function() {
            var cashBankReceiptDetail = {};

            cashBankReceiptDetail = {
                siNo : 1,
                subgroupcode : '',
                acctName : '',
                subAccountCode : '',
                shortDetail : '',
                currency : 'INR',
                exgRate : 1.0,
                bcamount : '',
                tcamount : '',

                employeeCode : '',
                departmentCode : '',
                countryCode : '',
                customerCode : '',
                supplierCode : '',
                designationCode : '',
                costCenter : '',
                companyCode : '',
                patientCode : '',
                genInvoiceNo : '',
                invoiceReceiptList : [],

                isEmployee : false,
                isDepartment : false,
                isLocation : false,
                isCustomer : false,
                isSupplier : false,
                isDesignation : false,
                isCostCenter : false,
                isCompany : false,
                isPatient : false,
                attributeList : []
            };
            $scope.objCBReceipt.cshBankDetail.push(cashBankReceiptDetail);

        };

        $scope.loadCBRcptTable();

        $scope.addCBRcptDtlRow = function(tables) {
            var len = tables.length;
            var table = {};
            table = {
                siNo : 1,
                subgroupcode : '',
                acctName : '',
                subAccountCode : '',
                shortDetail : '',
                currency : '',
                exgRate : 1.0,
                bcamount : '',
                tcamount : '',

                employeeCode : '',
                departmentCode : '',
                countryCode : '',
                customerCode : '',
                supplierCode : '',
                designationCode : '',
                costCenter : '',
                companyCode : '',
                patientCode : '',
                genInvoiceNo : '',
                invoiceReceiptList : [],
                invoicePaymentList : [],
                isEmployee : false,
                isDepartment : false,
                isLocation : false,
                isCustomer : false,
                isSupplier : false,
                isDesignation : false,
                isCostCenter : false,
                isCompany : false,
                isPatient : false,
                attributeList : []
            };
            table.siNo = len + 1;
            tables.push(table);
        };

        
      /* 
        $http.get('app/commonUtility/getSubAccountCodeLists').success(function(datas) {

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
        });
        */
        
        $scope.removeCBRcptRow = function(table) {
            $scope.tablerow = [];

            angular.forEach(table, function(row, index) {
                var check = row.select;

                if (check == undefined || check == "") {

                    $scope.tablerow.push(row);
                } else {

                }
            });
            $scope.objCBReceipt.cshBankDetail = $scope.tablerow;
            $scope.totalAmountCalculation();

        };

        $scope.BCtoTCAmountCalculationForPartyAccountDetTbl = function(bcAmt, trIndex, row) {
            row.bcamount = parseFloat(bcAmt);
            if (row.exgRate != 0 && row.exgRate != "") {
                row.tcamount = parseFloat(bcAmt) / row.exgRate;
                $scope.totalAmountCalculation();
            } else {
                row.tcamount = 1;
                $scope.totalAmountCalculation();
            }
        }

        $scope.TCtoBCAmountCalculationForPartyAccountDetTbl = function(tcAmt, trIndex, row) {

            row.tcamount = parseFloat(tcAmt);
            if (row.exgRate != 0 && row.exgRate != "") {
                row.bcamount = parseFloat(tcAmt) * row.exgRate;
                $scope.totalAmountCalculation();
            } else {
                row.bcamount = 1;
                $scope.totalAmountCalculation();
            }
        }

        $scope.totalAmountCalculation = function() {
            var cbrDtlPartyAcctRowDatas = $scope.objCBReceipt.cshBankDetail;
            var bcAmt = 0, tcAmt = 0, totalBCAmt = 0.0, totalTCAmt = 0.0;

            angular.forEach(cbrDtlPartyAcctRowDatas, function(item, key) {
                if (cbrDtlPartyAcctRowDatas[key].bcamount != "" || cbrDtlPartyAcctRowDatas[key].tcamount != "") {
                    bcAmt += parseFloat(cbrDtlPartyAcctRowDatas[key].bcamount);
                    tcAmt += parseFloat(cbrDtlPartyAcctRowDatas[key].tcamount);

                }
            });

            totalBCAmt += bcAmt;
            totalTCAmt += tcAmt;

            $scope.cbRcptDtlTotalAmt.totalBCAmount = totalBCAmt.toFixed(2);
            $scope.cbRcptDtlTotalAmt.totalTCAmount = totalTCAmt.toFixed(2);

        }

        /**
         * Edit Functionality
         */
        var voucherNo = $stateParams.voucherNo;
        if (voucherNo == undefined || voucherNo == null || voucherNo == "") {
        } else {
            $scope.view = true;
            $scope.isDisabled = true;

            $http.get('app/cashbankreceipt/getReceiptVoucherDetailforEdit?voucherNo=' + voucherNo).success(function(data) {

                $scope.objCBReceipt = data;
                
             
                if ($scope.objCBReceipt.paymentMode == "B") {
                    $scope.cashList = [];
                    $scope.bankList = data.lCashBankAccountList;
                    $scope.objCBReceipt.bankAcc = data.accountName;
                    $scope.objCBReceipt.accountName = data.accountName;
                } else {
                    $scope.bankList = [];
                    $scope.cashList = data.lCashBankAccountList;
                    $scope.objCBReceipt.cashAcc = data.accountName;
                    $scope.objCBReceipt.accountName = data.accountName;
                }

                angular.forEach($scope.objCBReceipt.cshBankDetail, function(row, index) {

                    row.employeeCode = row.employeeCode;
                    row.departmentCode = row.departmentCode;
                    row.countryCode = row.countryCode;
                    row.customerCode = row.customerCode;
                    row.supplierCode = row.supplierCode;
                    row.designationCode = row.designationCode;
                    row.costCenter = row.costCenter;
                    row.companyCode = row.companyCode;
                    row.patientCode = row.patientCode;
                    row.acctName = row.acctName;


                    if (row.genInvoiceNo != "") {
                        row.isInvoiceNo = true;
                        if (row.employeeCode != "") {
                            row.isEmployee = true;
                        } else {
                            row.isEmployee = false;
                        }
                        if (row.companyCode != "") {
                            row.isCompany = true;
                        } else {
                            row.isCompany = false;
                        }
                    } else {
                        row.isInvoiceNo = false;
                    }
                });

                $scope.totalAmountCalculation();
            }).error(function(data) {
            });
        }

        /***********************************************************************
         * save functionality
         * ******************************************************************************************
         */

        $scope.save = function(cashBankReceiptForm, objCBReceipt) {

            if (!$scope.edit) {
                angular.forEach($scope.objCBReceipt.cshBankDetail, function(key, index) {

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

                });
                $http.post('app/cashbankreceipt/saveCashBankReceiptData', $scope.objCBReceipt).success(function(result) {
                    if (result == false) {
                        logger.logError("Receipt Code Already Exist");
                        angular.forEach($scope.objCBReceipt.cshBankDetail, function(key, index) {

                            key.isEmployee = true;
                            key.isDepartment = true;
                            key.isLocation = true;
                            key.isCustomer = true;
                            key.isSupplier = true;
                            key.isDesignation = true;
                            key.isCostCenter = true;
                            key.isPatient = true;
                            key.isCompany = true;
                            key.attributeList = true;
                        });
                    } else {
                        logger.logSuccess("Saved successfully!");
                      //  $state.go('app.hospital.accounts.paymentreceipt.list');
                        $location.path( $stateParams.tenantid +'/hospital/accounts/paymentreceipt/list');

                     ///   $state.go('app.hospital.accounts.paymentreceipt.list');

                    }

                }).error(function(data) {
                });
            } else {
                angular.forEach($scope.objCBReceipt.cshBankDetail, function(key, index) {

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
                });
                $http.post('app/cashbankreceipt/updateCashBankReceiptData', $scope.objCBReceipt).success(function(result) {
                    if (result == false) {
                        logger.logError("Receipt Code Already Exist");
                        angular.forEach($scope.objCBReceipt.cshBankDetail, function(key, index) {

                            key.isEmployee = true;
                            key.isDepartment = true;
                            key.isLocation = true;
                            key.isCustomer = true;
                            key.isSupplier = true;
                            key.isDesignation = true;
                            key.isCostCenter = true;
                            key.isPatient = true;
                            key.isCompany = true;
                            key.attributeList = true;
                        });
                    } else {
                        logger.logSuccess("Updated successfully!");
                        $state.go('app.finance.accounts.paymentreceipt.list');

                    }

                }).error(function(data) {
                });
            }
        }

        /**
         * show Pending Receipt - Invoice Details
         */
        $scope.showReceiptPriceDialog = function(cashBankReceiptForm, subAccountCode, selectedIndex) {

            if (subAccountCode != undefined || subAccountCode != "") {
                $scope.callReceiptPriceDialog($scope, subAccountCode, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, selectedIndex);
            } else {
                logger.logError("Please select a 'SubAccountCode (Customer)' to add Invoice Details.");
                ngDialog.close();
            }
        }

        
        
        
        $scope.showReceiptPriceDialogView = function(row, subAccountCode, selectedIndex) {
           
            if (row.invoiceReceiptList != undefined || row.invoiceReceiptList != "") {
                var invoiceReceiptList=row.invoiceReceiptList;
                $scope.callReceiptPriceDialogView($scope, invoiceReceiptList, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, selectedIndex);
            } else {
                logger.logError("No Invoice Details.");
                ngDialog.close();
            }
        }
        
        $scope.callReceiptPriceDialog = function($scope, receivedFrom, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, selectedIndex) {

            ngDialog.open({
                scope : $scope,
                template : 'views/finance/accounts/paymentreceipt/cashbankReceiptPriceDialog',
                controller : $controller('cashbankReceiptInvoiceDtlAddCtrl', {
                    $scope : $scope,
                    receivedFromCode : receivedFrom,
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
        }
        
        $scope.callReceiptPriceDialogView = function($scope, invoiceReceiptList, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, selectedIndex) {

            ngDialog.open({
                scope : $scope,
                template : 'views/finance/accounts/paymentreceipt/cashBankReceiptPriceDialogView',
                controller : $controller('cashbankReceiptInvoiceDtlViewCtrl', {
                    $scope : $scope,
                    invoiceReceiptList : invoiceReceiptList,
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
        }


        
        $scope.showPaymentInvoicePopup = function(selectedIndex, rowData ) {
            rowData.companyCode=$scope.objCBReceipt.companyCode;
            if (rowData.subAccountCode == ""
                || rowData.subAccountCode == undefined) {
            logger.logError("please select Sub account code");
        }else if (rowData.companyCode == ""
            || rowData.companyCode == undefined) {
            logger.logError("please select Company");
            } else {
                ngDialog.open({
                    scope : $scope,
                    template : 'views/finance/accounts/payment/cashBankInvoiceDialog',
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
    
    app.controller('cashbankPaymentInvoiceDtlAddCtrlNew',function($scope,
            $http, $filter,$controller, logger, $rootScope, ngDialog,
            rowData,selectedRowId, $stateParams) {
        $scope.totalBCAmount = 0.0;
        $scope.totalTCAmount = 0.0;
        
        $rootScope.tempList = [];
        $rootScope.check = false;
        debugger;
        if (rowData.subAccountCode == ""
                || rowData.subAccountCode == undefined) {
            logger.logError("please select Sub account code");
        } else {
            $scope.paymentInformation = {

                supplierName : rowData.subAccountCode,
                companyCode : rowData.companyCode,
                accountHeadCode : rowData.acctName
            };

            var sVoucherNo=$stateParams.voucherNo
         
            
            $http
                    .post( 'app/paymentInformation/showPendingReceiptInformationList',
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
                rowData.tcamount = $scope.totalBCAmount;
                rowData.tcamount = $scope.totalBCAmount;
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

    


    

    app.controller('cashbankReceiptInvoiceDtlAddCtrl', function($scope, $http, ngDialog, logger, $stateParams,
            receivedFromCode, $injector, sharedProperties, toaster, $rootScope, validationService, selectedRowId) {
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

        $scope.getPendingInvoiceDetails = function() {
            if (receivedFromCode != "") {
                $http.get('app/cashbankreceipt/getPendingInvoiceDetails?customerCode=' + receivedFromCode).success(function(datas) {
                    $scope.rowCollection = datas.pendingInvoiceDtls;

                    for (var i = 0; i < datas.pendingInvoiceDtls.length; i++) {
                        $scope.rowCollection[i].bcPaidAmt = datas.pendingInvoiceDtls[i].bcBalanceAmt;
                        $scope.rowCollection[i].tcPaidAmt = datas.pendingInvoiceDtls[i].tcBalanceAmt;
                    }

                }).error(function(data) {
                });
            } else {
                logger.logError("Unavailable Invoice Details in selected 'Sub Account Code' (Customer), !");
            }
        }
        $scope.getPendingInvoiceDetails();

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
                }
                $scope.isValid = false;
            } else {
                paymentCollections.bcPaidAmt = 0;
                $scope.isValid = true;
            }
        }

        $scope.isCheckAmt = false;
        $scope.checkPaidAmount = function(receiptCollections) {

            var isAmtExceed = $scope.isReceivedAmountExceed(receiptCollections);

            if (isAmtExceed) {
                $scope.isValid = false;
            } else {
                $scope.isValid = true;
                logger.logError("'BC Paid Amt' exceeding BC Balance Amount");
            }

        }

        $scope.isReceivedAmountExceed = function(receiptCollections) {
            var isFlag = true;
            angular.forEach(receiptCollections, function(row, index) {

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
                        gInvoiceNo : key.gInvoiceNo,
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
                    if ($scope.objCBReceipt.cshBankDetail[selectedRowId].genInvoiceNo == "") {
                        $scope.objCBReceipt.cshBankDetail[selectedRowId].genInvoiceNo = $scope.paymentInvoiceDetails[iRowCtr].gInvoiceNo;
                    } else {
                        $scope.objCBReceipt.cshBankDetail[selectedRowId].genInvoiceNo += "," + $scope.paymentInvoiceDetails[iRowCtr].gInvoiceNo;
                    }
                }

                // Fetch Currency and ExchangeRate;
                var currency = "", exchangerate = 0, paidBcAmt = 0, paidTcAmt = 0;

                for (var iRowCtr = 0; iRowCtr < $scope.paymentInvoiceDetails.length; iRowCtr++) {

                    if (currency != '') {
                        if (currency == $scope.paymentInvoiceDetails[iRowCtr].currency) {
                            currency = $scope.paymentInvoiceDetails[iRowCtr].currency + ",";
                            currency = currency.slice(0, currency.lastIndexOf(","));
                            $scope.objCBReceipt.cshBankDetail[selectedRowId].currency = currency;
                        } else {
                            currency += $scope.paymentInvoiceDetails[iRowCtr].currency + ",";
                            currency = currency.slice(0, currency.lastIndexOf(","));
                            $scope.objCBReceipt.cshBankDetail[selectedRowId].currency = currency;
                        }
                    } else {
                        currency = $scope.paymentInvoiceDetails[iRowCtr].currency + ",";
                        currency = currency.slice(0, currency.lastIndexOf(","));
                        $scope.objCBReceipt.cshBankDetail[selectedRowId].currency = currency;
                    }

                    exchangerate = parseFloat($scope.paymentInvoiceDetails[iRowCtr].exchangeRate).toFixed(2);
                    $scope.objCBReceipt.cshBankDetail[selectedRowId].exgRate = exchangerate;

                    paidBcAmt = paidBcAmt + parseFloat($scope.paymentInvoiceDetails[iRowCtr].bcPaidAmt);
                    $scope.objCBReceipt.cshBankDetail[selectedRowId].bcamount = paidBcAmt;

                    paidTcAmt = paidTcAmt + parseFloat($scope.paymentInvoiceDetails[iRowCtr].tcPaidAmt);
                    $scope.objCBReceipt.cshBankDetail[selectedRowId].tcamount = paidTcAmt;
                }

                if ($scope.objCBReceipt.cshBankDetail[selectedRowId].genInvoiceNo != "") {
                    $scope.objCBReceipt.cshBankDetail[selectedRowId].isInvoiceNo = true;
                }

                $scope.objCBReceipt.cshBankDetail[selectedRowId].invoiceReceiptList = $scope.paymentInvoiceDetails;
                ngDialog.close();
                $scope.totalAmountCalculation();
            } else {
                logger.logError("Please Select an Pending Invoice Details!")
            }
        }

        $scope.totalAmountCalculation = function() {
            var cbrDtlPartyAcctRowDatas = $scope.objCBReceipt.cshBankDetail;
            var bcAmt = 0, tcAmt = 0, totalBCAmt = 0.0, totalTCAmt = 0.0;

            angular.forEach(cbrDtlPartyAcctRowDatas, function(item, key) {
                if (cbrDtlPartyAcctRowDatas[key].bcamount != "" || cbrDtlPartyAcctRowDatas[key].tcamount != "") {
                    bcAmt += parseFloat(cbrDtlPartyAcctRowDatas[key].bcamount);
                    tcAmt += parseFloat(cbrDtlPartyAcctRowDatas[key].tcamount);
                }
            });
            totalBCAmt += bcAmt;
            totalTCAmt += tcAmt;
            $scope.cbRcptDtlTotalAmt.totalBCAmount = totalBCAmt;
            $scope.cbRcptDtlTotalAmt.totalTCAmount = totalTCAmt;
        }

        $scope.cancelInvoicePriceDialog = function() {
            ngDialog.close();
        };
    });

    
    app.controller('cashbankReceiptInvoiceDtlViewCtrl', function($scope, $http, ngDialog, logger, invoiceReceiptList, $injector, sharedProperties, toaster, $rootScope, validationService, selectedRowId,$stateParams) {
        $scope.departmentCollections = [];
        $scope.rowCollection = [];
        $scope.isValid = false;
        $scope.chkAll = false;
        
      
    
        
        $scope.rowCollection=invoiceReceiptList;
        
        $scope.cancelInvoicePriceDialog = function() {
            ngDialog.close();
        };
    });
    
    app.controller('tableCtrl', function($scope, $http, $filter, logger,$stateParams) {

        /* Account On Change............... */
    	

    	$http.get("app/cashbankPayment/receiptList").success(function(datas) {
    	    $scope.receiptList = datas;
    	});

    	 $scope.$watch('objCBReceipt.receiptfrom', function(newValue, oldValue) {

             
             if($scope.objCBReceipt.receiptfrom == "College"){

                 $http.get('app/journalVoucher/getSubcollHeadList').success(function(datas) {
                     $scope.subAccountCodeList = datas;
                 }).error(function(datas) {
                     logger.logError("Error Please Try Again");
                 });
         }
             
             
             if($scope.objCBReceipt.receiptfrom == "Others"){

                 $http.get('app/journalVoucher/getSubotherHeadList').success(function(datas) {
                     $scope.subAccountCodeList = datas;
                 }).error(function(datas) {
                     logger.logError("Error Please Try Again");
                 });
         }
                 

               
         });
    	
    	
       /* $scope.$watch('objCBReceipt.cshBankDetail[trIndex].acctName', function(newValue, oldValue) {

                
            if(newValue =='10080001'  ){
                $http.get('app/journalVoucher/getSubAcctHeadList').success(function(datas) {
                    $scope.subAccountCodeList = datas;
                }).error(function(datas) {
                    logger.logError("Error Please Try Again");
                });
        }
            
            
            if(newValue =='20060001' ||  newValue =='20000001'){

                $http.get('app/journalVoucher/getSubAcctHeadVendorList').success(function(datas) {
                    $scope.subAccountCodeList = datas;
                }).error(function(datas) {
                    logger.logError("Error Please Try Again");
                });
        }
                

                if (newValue != '' && newValue != undefined) {
                    debugger;
                    if (newValue == '10080001') {
                     //   $scope.objCBReceipt.cshBankDetail[$scope.$index].isTradeDebtors = true;
                        $http.get('app/commonUtility/getSubAccountCodeListsDebtors').success(function(datas) {
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
            }  
                    //else {
//                       // $scope.objCBReceipt.cshBankDetail[$scope.$index].isTradeDebtors = false;
//                       // $scope.objCBReceipt.cshBankDetail[$scope.$index].subAccountCodeList = [];
//                      //  $scope.objCBReceipt.cshBankDetail[$scope.$index].isSubAccountCode = false;
//                    }

                
                
                $http.get( $stateParams.tenantid +'/app/commonUtility/getAttributesList?accountCode=' + newValue).success(function(datas) {
                    $scope.objCBReceipt.cshBankDetail[$scope.$index].attributeList = datas;
                    if (newValue == oldValue) {
                        $scope.isOnChange = false;
                    } else {
                        $scope.isOnChange = true;
                    }
//                    if (!$scope.edit || $scope.isOnChange) {
//                        $scope.objCBReceipt.cshBankDetail[$scope.$index].employeeCode = '';
//                        $scope.objCBReceipt.cshBankDetail[$scope.$index].departmentCode = '';
//                        $scope.objCBReceipt.cshBankDetail[$scope.$index].countryCode = '';
//                        $scope.objCBReceipt.cshBankDetail[$scope.$index].customerCode = '';
//                        $scope.objCBReceipt.cshBankDetail[$scope.$index].supplierCode = '';
//                        $scope.objCBReceipt.cshBankDetail[$scope.$index].designationCode = '';
//                        $scope.objCBReceipt.cshBankDetail[$scope.$index].costCenter = '';
//                        $scope.objCBReceipt.cshBankDetail[$scope.$index].companyCode = '';
//                        $scope.objCBReceipt.cshBankDetail[$scope.$index].patientCode = '';
//                    }

                    $scope.objCBReceipt.cshBankDetail[$scope.$index].isEmployee = false;
                    $scope.objCBReceipt.cshBankDetail[$scope.$index].isDepartment = false;
                    $scope.objCBReceipt.cshBankDetail[$scope.$index].isLocation = false;
                    $scope.objCBReceipt.cshBankDetail[$scope.$index].isCustomer = false;
                    $scope.objCBReceipt.cshBankDetail[$scope.$index].isSupplier = false;
                    $scope.objCBReceipt.cshBankDetail[$scope.$index].isDesignation = false;
                    $scope.objCBReceipt.cshBankDetail[$scope.$index].isCostCenter = false;
                    $scope.objCBReceipt.cshBankDetail[$scope.$index].isCompany = false;

                    $scope.objCBReceipt.cshBankDetail[$scope.$index].isPatient = false;
                    angular.forEach($scope.objCBReceipt.cshBankDetail[$scope.$index].attributeList, function(row, rowindex) {
                        if (row.attributeName == "Employee") {
                            $scope.objCBReceipt.cshBankDetail[$scope.$index].isEmployee = true;
                        } else if (row.attributeName == "Students") {
                            $scope.objCBReceipt.cshBankDetail[$scope.$index].isDepartment = true;
                        } else if (row.attributeName == "Location") {
                            $scope.objCBReceipt.cshBankDetail[$scope.$index].isLocation = true;
                        } else if (row.attributeName == "Customer") {
                            $scope.objCBReceipt.cshBankDetail[$scope.$index].isCustomer = true;
                        } else if (row.attributeName == "Supplier") {
                            $scope.objCBReceipt.cshBankDetail[$scope.$index].isSupplier = true;
                        } else if (row.attributeName == "Designation") {
                            $scope.objCBReceipt.cshBankDetail[$scope.$index].isDesignation = true;
                        } else if (row.attributeName == "Cost Center") {
                            $scope.objCBReceipt.cshBankDetail[$scope.$index].isCostCenter = true;
                        } else if (row.attributeName == "Company") {
                            $scope.objCBReceipt.cshBankDetail[$scope.$index].isCompany = true;
                        } else if (row.attributeName == "Patient") {
                            $scope.objCBReceipt.cshBankDetail[$scope.$index].isPatient = true;
                        }
                    });

                }).error(function(datas) {
                });

                angular.forEach($scope.globalAccountListData, function(values, indexs) {
                    if (newValue == values.accountHeadCode) {
                        $scope.objCBReceipt.cshBankDetail[$scope.$index].currency = values.currencyCode;
                        $scope.objCBReceipt.cshBankDetail[$scope.$index].exgRate = values.exchangeRate;
                    }
                });
            } else {
                $scope.objCBReceipt.cshBankDetail[$scope.$index].currency = '';
                $scope.objCBReceipt.cshBankDetail[$scope.$index].exgRate = 1.0;
            }
        });*/
    });

    app.factory('CBRECEIPT', function($http, $q, logger,$stateParams) {
        var CBRECEIPT = new Object();
        CBRECEIPT.getBankList = function(com,i) {
            var bankData = $q.defer();
            var bankList;
            if(com!=null && com!='' && com!= undefined){

            $http.get('app/cashbankPayment/getBankAcctListcompanycode?companyCode=' + com).success(function(data) {


                 if(data.length > 0)
               {
                     bankData.resolve(data);
               }
                /* else{
                     
                     logger.logError("Voyage is not available for the given vessel");
                     
                 }*/
           });
            }
            else{
            $http.get('app/cashbankreceipt/getBankDrpDwn').success(function(datas) {
                bankList = datas.objCashBankReceiptListBean;
                if (datas.message == "success") {
                    bankData.resolve(bankList);
                } else {
                    logger.logError("Error Please Try Again");
                }
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
            }
            return bankData.promise
        }
        CBRECEIPT.getCashList = function(i) {
            var cashData = $q.defer();
            var cashList;
            $http.get('app/cashbankreceipt/getCashDrpDwn').success(function(datas) {

                cashList = datas.objCashBankReceiptListBean;
                if (datas.message == "success") {
                    cashData.resolve(cashList);
                } else {
                    //logger.logError("Error Please Try Again");
                }
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
            return cashData.promise
        }
        CBRECEIPT.getTypeList = function(i) {
            var typeData = $q.defer();
            var typeList = [ {
                "id" : "B",
                "text" : "Bank"
            }, {
                "id" : "C",
                "text" : "Cash"
            } ];
            typeData.resolve(typeList);
            return typeData.promise
        }

        CBRECEIPT.getCompanyList = function() {
            var companyList = $q.defer();

            $http.get($stateParams.tenantid +'/app/commonUtility/getCompanyList').success(function(datas) {

                companyList.resolve(datas);

            }).error(function(datas) {
                companyList.reject("Failed to get Company List");
            });
            return companyList.promise;
        }

        return CBRECEIPT;
    });
//});
//define([ 'hospital/accounts/accounts' ], function(module) {

    'use strict';

    app.controller('cashBankReceiptAddCtrl', function($scope,$rootScope, $http, logger, $log, ngDialog, $modal, $location, $filter, utilsService, CBRECEIPT, $state, sharedProperties, $stateParams, validationService, toaster, $injector, $controller) {
        $scope.pmtTypeShow = true;
        $scope.accountListData = [];
        $scope.typeList = [];
        $scope.bankList = [];
        $scope.cashList = [];
        $scope.companyList = [];
        $scope.globalAccountListData = [];
        $scope.receivedFromList = [];
        $scope.objCBReceipt = {
            paymentMode : "B",
            accountName : '',
            companyCode : 'C0002',
            bankAcc : '',costCenter : 'OS',
            cashAcc : '',
            bcAmountHdr : '',
            tcAmountHdr : '',
            exchangeRate : '',
            currency : '',
            narration : '',
            receivedFrom : '',
            cbReceiptDate : '',
            chequeDate : '',
            receipt :'',
            chequeNO : '',
            costCenter:'87',
            cshBankDetail : [],
            receiptfrom:'',
        };
        $scope.edit = false;
        $scope.cbRcptDtlTotalAmt = {
            totalBCAmount : 0.0,
            totalTCAmount : 0.0
        }

        $scope.objCBReceipt.paymentMode = "B";
        $scope.receiptList=[];
		$scope.getreceiveStatus = function() {
		    var  data = {};
		    data["id"] = "College";
		    data["text"] = "College";
		    $scope.receiptList.push(data);
		    data = {};
		    data["id"] = "Others";
		    data["text"] = "Others";
		    $scope.receiptList.push(data); 
		    
		    
		}
		$scope.getreceiveStatus();
        
       /* $scope.$watch('objCBReceipt.companyCode', function(newValue, oldValue) {
            // alert(newValue);
              if(newValue!=null && newValue!=undefined && newValue != ''){
              //    $http.post($stateParams.tenantid+ '/app/commonUtility/getVoyageListByVessel',newValue).success(function(data) {
                   $http.get('app/cashbankPayment/getBankAcctListcompanycode?companyCode=' + $scope.objCBReceipt.companyCode).success(function(data) {

                       $scope.objCBReceipt.companyCode = newValue;

                        if(data.length > 0)
                      {
                      $scope.bankList = data;
                      }
                        else{
                            
                            logger.logError("Voyage is not available for the given vessel");
                            
                        }
                  });
              }
            });*/
            
            
            
        $scope.showPaymentInvoicePopup = function(selectedIndex, rowData ) {
            rowData.companyCode=$scope.objCBReceipt.companyCode;
            if (rowData.subAccountCode == ""
                || rowData.subAccountCode == undefined) {
            logger.logError("please select Sub account code");
        }else if (rowData.companyCode == ""
            || rowData.companyCode == undefined) {
            logger.logError("please select Company");
            } else {
                ngDialog.open({
                    scope : $scope,
                    template : 'views/finance/accounts/payment/cashBankInvoiceDialog',
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
        
        
            
              $scope.$watch('objCBReceipt.companyCode', function(newValue, oldValue) {
            //  alert(newValue);
               if(newValue!=null && newValue!=undefined && newValue != '' && $scope.objCBReceipt.paymentMode == "B"){
               //    $http.post($stateParams.tenantid+ '/app/commonUtility/getVoyageListByVessel',newValue).success(function(data) {
                   
                   
                   if ($scope.objCBReceipt.paymentMode == "B") {
                   $http.get('app/cashbankPayment/getBankAcctListcompanyNew?companyName=' + $scope.objCBReceipt.companyCode).success(function(data) {

                        $scope.objCBReceipt.companyCode = newValue;
                        $scope.bankAccountNewList = [];

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
              
              
              $scope.$watch('objCBReceipt.companyCode', function(newValue, oldValue) {
                  //  alert(newValue);
                     if(newValue!=null && newValue!=undefined && newValue != '' && $scope.objCBReceipt.paymentMode == "B"){
                     //    $http.post($stateParams.tenantid+ '/app/commonUtility/getVoyageListByVessel',newValue).success(function(data) {
                         
                         
                         if ($scope.objCBReceipt.paymentMode == "B") {
                         $http.get('app/cashbankPayment/getBankAcctListcompanyNew?companyName=' + $scope.objCBReceipt.companyCode).success(function(data) {

                              $scope.objCBReceipt.companyCode = newValue;
                              $scope.bankAccountNewList = [];

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
              
             /* $scope.$watch('objCBReceipt.companyCode', function(newValue, oldValue) {
                    //alert(newValue);
                     if(newValue!=null && newValue!=undefined && newValue != '' && $scope.objCBReceipt.paymentMode == "C"){
                     //    $http.post($stateParams.tenantid+ '/app/commonUtility/getVoyageListByVessel',newValue).success(function(data) {
                         
                         
                         if ($scope.objCBReceipt.paymentMode == "C") {
                         $http.get('app/cashbankPayment/getCashAcctListcompanyNew?companyName=' + $scope.objCBReceipt.companyCode).success(function(data) {

                              $scope.objCBReceipt.companyCode = newValue;
                              $scope.cashAccountListNew = [];

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
                   });*/
              
              
        $scope.$watch('objCBReceipt.companyCode', function(newValue, oldValue) {
            // alert(newValue);
              if(newValue!=null && newValue!=undefined && newValue != ''){
              //    $http.post($stateParams.tenantid+ '/app/commonUtility/getVoyageListByVessel',newValue).success(function(data) {
                   $http.get('app/cashbankPayment/getBankAcctListcompanycode?companyCode=' + $scope.objCBReceipt.companyCode).success(function(data) {

                       $scope.objCBReceipt.companyCode = newValue;

                        if(data.length > 0)
                      {
                      $scope.bankList = data;
                      }
                       /* else{
                            
                            logger.logError("Voyage is not available for the given vessel");
                            
                        }*/
                  });
              }
            });
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
            $scope.objCBReceipt.cbReceiptDate = $scope.date;
        }
        $scope.getCurrentDate();
        
   $scope.costList = [];

        
        $http.get("app/purchaseinvoice/costcenterlist").success(function(datas) {
            $scope.costList = datas;
        });

        /**
         * validation
         */
        $scope.validate = function(cashBankReceiptForm, objCBReceipt) {
            if (new validationService().checkFormValidity($scope.cashBankReceiptForm)) {

                if (!$scope.edit) {
                    if ($scope.objCBReceipt.bcAmountHdr > 0) {
                        if (parseFloat($scope.objCBReceipt.bcAmountHdr) ==parseFloat($scope.cbRcptDtlTotalAmt.totalTCAmount)) {
                            $scope.save(cashBankReceiptForm, objCBReceipt);
                        } else {
                            logger.logError('Amount should match!');
                        }
                    } else {
                        logger.logError('Please Enter Amount!');
                    }
                } else {
                    $scope.save(cashBankReceiptForm, objCBReceipt);
                }
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.cashBankReceiptForm.$validationSummary), 555000, 'trustedHtml');
            }
        };

        /** GET TYPE OF RECEIPT - Bank/Cash ****************** */
        $scope.tempList = CBRECEIPT.getTypeList();

        $scope.tempList.then(function(data) {
            $scope.typeList = data;
        });

        $scope.tempCompanyList = CBRECEIPT.getCompanyList();
      /*  
        $http.get($stateParams.tenantid +'/app/commonUtility/getCompanyList').success(function(datas) {
            $scope.companyList = datas;
                var foundItemDest = $filter('filter')($scope.companyList, {
                    baseCompany : 1
                    
                })[0];
       

                $scope.objCBReceipt.companyCode=foundItemDest.id;
        }).error(function(datas) {
        });*/

        $scope.tempCompanyList.then(function(data) {
            $scope.companyList = data;
        });

        $scope.getCompanyCodeWithUser = function() {
            $http.get($stateParams.tenantid +'/app/commonUtility/getCompanyListWithUser').success(function(datas) {
                $scope.objCBReceipt.companyCode = datas.commonUtilityBean[0].value;
                $scope.objCBReceipt.compLocationName = datas.commonUtilityBean[0].description;
            }).error(function(datas) {
                logger.logError("Error Please Try Again");
            });
        }
        $scope.$watch('objCBReceipt.paymentMode', function(newValue, oldValue) {
            var com=  $scope.objCBReceipt.companyCode;

            if (newValue == "C") {
                $scope.pmtTypeShow = false;

                $scope.getCashList();
                $scope.bankList = [];
                $scope.objCBReceipt.chequeDate = '';
                $scope.objCBReceipt.chequeNO = '';
                $scope.objCBReceipt.paymentMode = "C";
            } else if (newValue == "B") {
                $scope.pmtTypeShow = true;
                $scope.getBankList(com);
                $scope.cashList = [];
            }
        });

        /**
         * ************** ******* cash account onchange - fetch into currency,
         * exchange rate ****************
         */
        $scope.$watch('objCBReceipt.cashAcc', function(newValue, oldValue) {
            if (newValue != '' && newValue != undefined) {
                $scope.objCBReceipt.cashAcc = newValue;
                $scope.objCBReceipt.bankAcc = '';
                $scope.objCBReceipt.accountName = newValue;

                $http.post('app/cashbankreceipt/getCurrencyAndExchangeRate', newValue).success(function(datas) {
                    $scope.objCBReceipt.exchangeRate = datas.objCashBankReceiptListListBean[0].exchangeRate;
                    $scope.objCBReceipt.currency = datas.objCashBankReceiptListListBean[0].acctCurrency;
                }).error(function(datas) {
                    logger.logError("Error Please Try Again");
                });
            }
        });

        /**
         * ************** ******* bankaccount onchange - fetch into currency,
         * exchange rate ****************
         */
        $scope.$watch('objCBReceipt.bankAcc', function(newValue, oldValue) {
            if (newValue != '' && newValue != undefined) {
                $scope.objCBReceipt.bankAcc = newValue;
                $scope.objCBReceipt.cashAcc = '';
                $scope.objCBReceipt.accountName = newValue;
                $http.post('app/cashbankreceipt/getCurrencyAndExchangeRate', newValue).success(function(datas) {
                    $scope.objCBReceipt.exchangeRate = datas.objCashBankReceiptListListBean[0].exchangeRate;
                    $scope.objCBReceipt.currency = datas.objCashBankReceiptListListBean[0].acctCurrency;
                }).error(function(datas) {
                    logger.logError("Error Please Try Again");
                });
            }
        });

        /**
         * **************** Bank / Cash Acct List *********** Dropdown in
         * selectivity ******************
         */
        $scope.getBankList = function(com) {
            $scope.tempList = CBRECEIPT.getBankList(com);
            $scope.tempList.then(function(data) {
                $scope.bankList = data;
            });
        };
        $scope.getCashList = function() {
            $scope.tempList = CBRECEIPT.getCashList();
            $scope.tempList.then(function(data) {
                $scope.cashList = data;
            });
        };

        /**
         * ********************** Header Amount Calculation to Amount
         * USD******************************************
         */
        /**
         * BC To TC Amount Calculation - Header
         */
        $scope.bcToTcHdrAmtCalculation = function(bcAmount) {
            if ($scope.objCBReceipt.exchangeRate != 0 && $scope.objCBReceipt.exchangeRate != "") {
                $scope.objCBReceipt.tcAmountHdr = parseFloat(bcAmount) / $scope.objCBReceipt.exchangeRate;
            } else {
                $scope.objCBReceipt.tcAmountHdr = 1;
            }

        }
        /**
         * TC To BC Amount Calculation - Header
         */
        $scope.tcToBcHdrAmtCalculation = function(tcAmount) {
            if ($scope.objCBReceipt.exchangeRate != 0 && $scope.objCBReceipt.exchangeRate != "") {
                $scope.objCBReceipt.bcAmountHdr = parseFloat(tcAmount) * $scope.objCBReceipt.exchangeRate;
            } else {
                $scope.objCBReceipt.bcAmountHdr = 1;
            }

        }

        // cancel Functionality
        $scope.cancel = function() {
            //$location.path("hospital/accounts/paymentreceipt/list");
            $state.go('app.finance.accounts.paymentreceipt.list');
        };

        $scope.onChangeNumber = function(ids, num) {

            num = num.replace(/[^0-9 .]/g, '');
            $('#' + ids).val(num);
            return num;
        }

        /**
         * 1st table ******************* cbp receipt detail
         * **********************************
         */

        $scope.getDropdownValues = function() {
            $http.get('app/cashbankreceipt/getReceivedFromList').success(function(datas) {
                $scope.receivedFromList = datas;
            }).error(function(datas) {
            });
            
            
       
            
            
           /* $http.get('app/commonUtility/getCrDtlAccountHeadData').success(function(datas) {
                $scope.globalAccountListData = datas.commonUtilityBean;
                if (datas.commonUtilityBean.length > 0) {
                    var acctHeadList = [];
                    angular.forEach(datas.commonUtilityBean, function(item, key) {
                        var accHdObj = new Object();
                        accHdObj.id = datas.commonUtilityBean[key].accountHeadCode;
                        accHdObj.text = datas.commonUtilityBean[key].accountHeadName;

                        acctHeadList.push(accHdObj);
                    });
                    $scope.accountList = acctHeadList;
                }
            }).error(function(data) {
            });*/
            
            $http.get('app/journalVoucher/getAccountNewHeadList').success(function(datas) {
                $scope.accountList = datas;
            }).error(function(datas) {
                logger.logError("Error Please Try Again");
            });

            
            //vochuer No

            $http.get('app/cashbankreceipt/GetvoucherNo?pmtype=' + $scope.objCBReceipt.paymentMode+'&cbReceiptDate='+$scope.objCBReceipt.cbReceiptDate ).success(function(data) {
                   // $scope.receivedFromList = datas;
         		   $scope.objCBReceipt.voucherNo=data.voucherNo;     
                }).error(function(datas) {
                });
            
            
        /*    $scope.$watch('objCBReceipt.receiptfrom', function(newValue, oldValue) {

                
                if($scope.objCBReceipt.receiptfrom == "college"){

                    $http.get('app/journalVoucher/getSubcollHeadList').success(function(datas) {
                        $scope.subAccountCodeList = datas;
                    }).error(function(datas) {
                        logger.logError("Error Please Try Again");
                    });
            }
                
                
                if($scope.objCBReceipt.receiptfrom == "others"){

                    $http.get('app/journalVoucher/getSubcollHeadList').success(function(datas) {
                        $scope.subAccountCodeList = datas;
                    }).error(function(datas) {
                        logger.logError("Error Please Try Again");
                    });
            }
                    

                  
            });
*/
        /*    $http.get('app/commonUtility/getSubAccountCodeList?type=receipt').success(function(datas) {
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
            // Attributes Dropdown

            $http.get($stateParams.tenantid +'/app/commonUtility/getEmployeeList').success(function(datas) {
                $scope.employeeList = datas;
            }).error(function(datas) {
            });

            $http.get($stateParams.tenantid +'/app/commonUtility/getDepartmentList').success(function(datas) {
                $scope.departmentList = datas;
            }).error(function(datas) {
            });

            $http.get($stateParams.tenantid +'/app/commonUtility/getCountryList').success(function(datas) {
                $scope.countryList = datas;
            }).error(function(datas) {
            });
            $http.get($stateParams.tenantid +'/app/commonUtility/getSupplierList').success(function(datas) {
                $scope.supplierList = datas;
            }).error(function(datas) {
            });
            $http.get($stateParams.tenantid +'/app/commonUtility/getCustomerAttributeList').success(function(datas) {
                $scope.customerList = datas;
            }).error(function(datas) {
            });

            $http.get($stateParams.tenantid +'/app/commonUtility/getDesignationList').success(function(datas) {
                $scope.designationList = datas;
            }).error(function(datas) {
            });

            $http.get($stateParams.tenantid +'/app/commonUtility/getCostCenter').success(function(datas) {
                $scope.costCenterList = datas;
            }).error(function(datas) {
            });

            $http.get($stateParams.tenantid +'/app/commonUtility/getCompanyList').success(function(datas) {
                $scope.companyList = datas;
            }).error(function(datas) {
            });
            $http.get($stateParams.tenantid +'/app/commonUtility/getPatientList').success(function(datas) {
                $scope.patientList = datas;
            }).error(function(datas) {
            });
        }
        $scope.getDropdownValues();

        $scope.loadCBRcptTable = function() {
            var cashBankReceiptDetail = {};

            cashBankReceiptDetail = {
                siNo : 1,
                subgroupcode : '',
                acctName : '',
                subAccountCode : '',
                shortDetail : '',
                currency : '',
                exgRate : 1.0,
                bcamount : '',
                tcamount : '',

                employeeCode : '',
                departmentCode : '',
                countryCode : '',
                customerCode : '',
                supplierCode : '',
                designationCode : '',
                costCenter : '',
                companyCode : '',
                patientCode : '',
                genInvoiceNo : '',
                invoiceReceiptList : [],
                receipt :'',

                isEmployee : false,
                isDepartment : false,
                isLocation : false,
                isCustomer : false,
                isSupplier : false,
                isDesignation : false,
                isCostCenter : false,
                isCompany : false,
                isPatient : false,
                attributeList : []
            };
            $scope.objCBReceipt.cshBankDetail.push(cashBankReceiptDetail);

        };

        $scope.loadCBRcptTable();

        $scope.addCBRcptDtlRow = function(tables) {
            var len = tables.length;
            var table = {};
            table = {
                siNo : 1,
                subgroupcode : '',
                acctName : '',
                subAccountCode : '',
                shortDetail : '',
                currency : '',
                exgRate : 1.0,
                bcamount : '',
                tcamount : '',
                receipt :'',

                employeeCode : '',
                departmentCode : '',
                countryCode : '',
                customerCode : '',
                supplierCode : '',
                designationCode : '',
                costCenter : '',
                companyCode : '',
                patientCode : '',
                genInvoiceNo : '',
                invoiceReceiptList : [],

                isEmployee : false,
                isDepartment : false,
                isLocation : false,
                isCustomer : false,
                isSupplier : false,
                isDesignation : false,
                isCostCenter : false,
                isCompany : false,
                isPatient : false,
                attributeList : []
            };
            table.siNo = len + 1;
            tables.push(table);
        };

        
      /* 
        $http.get('app/commonUtility/getSubAccountCodeLists').success(function(datas) {

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
        });
        */
        
       
        
        $scope.$watch('objCBReceipt.paymentMode', function(newValue, oldValue) {
            debugger
            if (newValue != '' && newValue != undefined) {
                if ($scope.objCBReceipt.paymentMode == "C") {

            $http.get('app/cashbankreceipt/GetvoucherNo?pmtype=' + $scope.objCBReceipt.paymentMode+'&cbReceiptDate='+$scope.objCBReceipt.cbReceiptDate ).success(function(data) {
                // $scope.receivedFromList = datas;
      		   $scope.objCBReceipt.voucherNo=data.voucherNo;     
             }).error(function(datas) {
             });
            }else if($scope.objCBReceipt.paymentMode == "B"){
            	  $http.get('app/cashbankreceipt/GetvoucherNo?pmtype=' + $scope.objCBReceipt.paymentMode+'&cbReceiptDate='+$scope.objCBReceipt.cbReceiptDate ).success(function(data) {
                      // $scope.receivedFromList = datas;
            		   $scope.objCBReceipt.voucherNo=data.voucherNo;     
                   }).error(function(datas) {
                   });	
            }
            }
            });
        
        $scope.removeCBRcptRow = function(table) {
            $scope.tablerow = [];

            angular.forEach(table, function(row, index) {
                var check = row.select;

                if (check == undefined || check == "") {

                    $scope.tablerow.push(row);
                } else {

                }
            });
            $scope.objCBReceipt.cshBankDetail = $scope.tablerow;
            $scope.totalAmountCalculation();

        };

        $scope.BCtoTCAmountCalculationForPartyAccountDetTbl = function(bcAmt, trIndex, row) {
            row.bcamount = parseFloat(bcAmt);
            if (row.exgRate != 0 && row.exgRate != "") {
                row.tcamount = parseFloat(bcAmt) / row.exgRate;
                $scope.totalAmountCalculation();
            } else {
                row.tcamount = 1;
                $scope.totalAmountCalculation();
            }
        }

        $scope.TCtoBCAmountCalculationForPartyAccountDetTbl = function(tcAmt, trIndex, row) {

            row.tcamount = parseFloat(tcAmt);
            if (row.exgRate != 0 && row.exgRate != "") {
                row.bcamount = parseFloat(tcAmt) * row.exgRate;
                $scope.totalAmountCalculation();
            } else {
                row.bcamount = 1;
                $scope.totalAmountCalculation();
            }
        }

        $scope.totalAmountCalculation = function() {
            var cbrDtlPartyAcctRowDatas = $scope.objCBReceipt.cshBankDetail;
            var bcAmt = 0, tcAmt = 0, totalBCAmt = 0.0, totalTCAmt = 0.0;

            angular.forEach(cbrDtlPartyAcctRowDatas, function(item, key) {
                if (cbrDtlPartyAcctRowDatas[key].bcamount != "" || cbrDtlPartyAcctRowDatas[key].tcamount != "") {
                    bcAmt += parseFloat(cbrDtlPartyAcctRowDatas[key].bcamount);
                    tcAmt += parseFloat(cbrDtlPartyAcctRowDatas[key].tcamount);

                }
            });

            totalBCAmt += bcAmt;
            totalTCAmt += tcAmt;

            $scope.cbRcptDtlTotalAmt.totalBCAmount = totalBCAmt.toFixed(2);
            $scope.cbRcptDtlTotalAmt.totalTCAmount = totalTCAmt.toFixed(2);

        }

        /**
         * Edit Functionality
         */
        var voucherNo = $stateParams.voucherNo;
        if (voucherNo == undefined || voucherNo == null || voucherNo == "") {
        } else {
            $scope.view = true;
            $scope.isDisabled = true;

            $http.get('app/cashbankreceipt/getReceiptVoucherDetailforEdit?voucherNo=' + voucherNo).success(function(data) {

                $scope.objCBReceipt = data;
                
             
                if ($scope.objCBReceipt.paymentMode == "B") {
                    $scope.cashList = [];
                    $scope.bankList = data.lCashBankAccountList;
                    $scope.objCBReceipt.bankAcc = data.accountName;
                    $scope.objCBReceipt.accountName = data.accountName;
                } else {
                    $scope.bankList = [];
                    $scope.cashList = data.lCashBankAccountList;
                    $scope.objCBReceipt.cashAcc = data.accountName;
                    $scope.objCBReceipt.accountName = data.accountName;
                }

                angular.forEach($scope.objCBReceipt.cshBankDetail, function(row, index) {

                    row.employeeCode = row.employeeCode;
                    row.departmentCode = row.departmentCode;
                    row.countryCode = row.countryCode;
                    row.customerCode = row.customerCode;
                    row.supplierCode = row.supplierCode;
                    row.designationCode = row.designationCode;
                    row.costCenter = row.costCenter;
                    row.companyCode = row.companyCode;
                    row.patientCode = row.patientCode;
                    row.acctName = row.acctName;

/*
                    if (row.genInvoiceNo != "") {
                        row.isInvoiceNo = true;
                        if (row.employeeCode != "") {
                            row.isEmployee = true;
                        } else {
                            row.isEmployee = false;
                        }
                        if (row.companyCode != "") {
                            row.isCompany = true;
                        } else {
                            row.isCompany = false;
                        }
                    } else {
                        row.isInvoiceNo = false;
                    }*/
                });

                $scope.totalAmountCalculation();
            }).error(function(data) {
            });
        }

        /***********************************************************************
         * save functionality
         * ******************************************************************************************
         */

        $scope.save = function(cashBankReceiptForm, objCBReceipt) {

            if (!$scope.edit) {
                angular.forEach($scope.objCBReceipt.cshBankDetail, function(key, index) {

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
                });
                $http.post('app/cashbankreceipt/saveCashBankReceiptData', $scope.objCBReceipt).success(function(result) {
                    if (result == false) {
                        logger.logError("Receipt Code Already Exist");
                        angular.forEach($scope.objCBReceipt.cshBankDetail, function(key, index) {

                            key.isEmployee = true;
                            key.isDepartment = true;
                            key.isLocation = true;
                            key.isCustomer = true;
                            key.isSupplier = true;
                            key.isDesignation = true;
                            key.isCostCenter = true;
                            key.isPatient = true;
                            key.isCompany = true;
                            key.attributeList = true;
                        });
                    } else {
                        logger.logSuccess("Saved successfully!");
                        $state.go('app.finance.accounts.paymentreceipt.list');


                    }

                }).error(function(data) {
                });
            } else {
                angular.forEach($scope.objCBReceipt.cshBankDetail, function(key, index) {

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
                });
                $http.post('app/cashbankreceipt/updateCashBankReceiptData', $scope.objCBReceipt).success(function(result) {
                    if (result == false) {
                        logger.logError("Receipt Code Already Exist");
                        angular.forEach($scope.objCBReceipt.cshBankDetail, function(key, index) {

                            key.isEmployee = true;
                            key.isDepartment = true;
                            key.isLocation = true;
                            key.isCustomer = true;
                            key.isSupplier = true;
                            key.isDesignation = true;
                            key.isCostCenter = true;
                            key.isPatient = true;
                            key.isCompany = true;
                            key.attributeList = true;
                        });
                    } else {
                        logger.logSuccess("Updated successfully!");
                        $state.go('app.finance.accounts.paymentreceipt.list');


                    }

                }).error(function(data) {
                });
            }
        }

        /**
         * show Pending Receipt - Invoice Details
         */
        $scope.showReceiptPriceDialog = function(cashBankReceiptForm, subAccountCode, selectedIndex) {

            if (subAccountCode != undefined || subAccountCode != "") {
                $scope.callReceiptPriceDialog($scope, subAccountCode, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, selectedIndex);
            } else {
                logger.logError("Please select a 'SubAccountCode (Customer)' to add Invoice Details.");
                ngDialog.close();
            }
        }

        
        
        
        $scope.showReceiptPriceDialogView = function(row, subAccountCode, selectedIndex) {
           
            if (row.invoiceReceiptList != undefined || row.invoiceReceiptList != "") {
                var invoiceReceiptList=row.invoiceReceiptList;
                $scope.callReceiptPriceDialogView($scope, invoiceReceiptList, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, selectedIndex);
            } else {
                logger.logError("No Invoice Details.");
                ngDialog.close();
            }
        }
        
        $scope.callReceiptPriceDialog = function($scope, receivedFrom, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, selectedIndex) {

            ngDialog.open({
                scope : $scope,
                template : 'views/finance/accounts/paymentreceipt/cashbankReceiptPriceDialog',
                controller : $controller('cashbankReceiptInvoiceDtlAddCtrl', {
                    $scope : $scope,
                    receivedFromCode : receivedFrom,
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
        }
        
        $scope.callReceiptPriceDialogView = function($scope, invoiceReceiptList, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, selectedIndex) {

            ngDialog.open({
                scope : $scope,
                template : 'views/finance/accounts/paymentreceipt/cashBankReceiptPriceDialogView',
                controller : $controller('cashbankReceiptInvoiceDtlViewCtrl', {
                    $scope : $scope,
                    invoiceReceiptList : invoiceReceiptList,
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
        }

    });
    
    
    


    

    app.controller('cashbankReceiptInvoiceDtlAddCtrl', function($scope, $http, ngDialog, logger, $stateParams,
            receivedFromCode, $injector, sharedProperties, toaster, $rootScope, validationService, selectedRowId) {
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

        $scope.getPendingInvoiceDetails = function() {
            if (receivedFromCode != "") {
                $http.get('app/cashbankreceipt/getPendingInvoiceDetails?customerCode=' + receivedFromCode).success(function(datas) {
                    $scope.rowCollection = datas.pendingInvoiceDtls;

                    for (var i = 0; i < datas.pendingInvoiceDtls.length; i++) {
                        $scope.rowCollection[i].bcPaidAmt = datas.pendingInvoiceDtls[i].bcBalanceAmt;
                        $scope.rowCollection[i].tcPaidAmt = datas.pendingInvoiceDtls[i].tcBalanceAmt;
                    }

                }).error(function(data) {
                });
            } else {
                logger.logError("Unavailable Invoice Details in selected 'Sub Account Code' (Customer), !");
            }
        }
        $scope.getPendingInvoiceDetails();

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
                }
                $scope.isValid = false;
            } else {
                paymentCollections.bcPaidAmt = 0;
                $scope.isValid = true;
            }
        }

        $scope.isCheckAmt = false;
        $scope.checkPaidAmount = function(receiptCollections) {

            var isAmtExceed = $scope.isReceivedAmountExceed(receiptCollections);

            if (isAmtExceed) {
                $scope.isValid = false;
            } else {
                $scope.isValid = true;
                logger.logError("'BC Paid Amt' exceeding BC Balance Amount");
            }

        }

        $scope.isReceivedAmountExceed = function(receiptCollections) {
            var isFlag = true;
            angular.forEach(receiptCollections, function(row, index) {

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
                        gInvoiceNo : key.gInvoiceNo,
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
                    if ($scope.objCBReceipt.cshBankDetail[selectedRowId].genInvoiceNo == "") {
                        $scope.objCBReceipt.cshBankDetail[selectedRowId].genInvoiceNo = $scope.paymentInvoiceDetails[iRowCtr].gInvoiceNo;
                    } else {
                        $scope.objCBReceipt.cshBankDetail[selectedRowId].genInvoiceNo += "," + $scope.paymentInvoiceDetails[iRowCtr].gInvoiceNo;
                    }
                }

                // Fetch Currency and ExchangeRate;
                var currency = "", exchangerate = 0, paidBcAmt = 0, paidTcAmt = 0;

                for (var iRowCtr = 0; iRowCtr < $scope.paymentInvoiceDetails.length; iRowCtr++) {

                    if (currency != '') {
                        if (currency == $scope.paymentInvoiceDetails[iRowCtr].currency) {
                            currency = $scope.paymentInvoiceDetails[iRowCtr].currency + ",";
                            currency = currency.slice(0, currency.lastIndexOf(","));
                            $scope.objCBReceipt.cshBankDetail[selectedRowId].currency = currency;
                        } else {
                            currency += $scope.paymentInvoiceDetails[iRowCtr].currency + ",";
                            currency = currency.slice(0, currency.lastIndexOf(","));
                            $scope.objCBReceipt.cshBankDetail[selectedRowId].currency = currency;
                        }
                    } else {
                        currency = $scope.paymentInvoiceDetails[iRowCtr].currency + ",";
                        currency = currency.slice(0, currency.lastIndexOf(","));
                        $scope.objCBReceipt.cshBankDetail[selectedRowId].currency = currency;
                    }

                    exchangerate = parseFloat($scope.paymentInvoiceDetails[iRowCtr].exchangeRate).toFixed(2);
                    $scope.objCBReceipt.cshBankDetail[selectedRowId].exgRate = exchangerate;

                    paidBcAmt = paidBcAmt + parseFloat($scope.paymentInvoiceDetails[iRowCtr].bcPaidAmt);
                    $scope.objCBReceipt.cshBankDetail[selectedRowId].bcamount = paidBcAmt;

                    paidTcAmt = paidTcAmt + parseFloat($scope.paymentInvoiceDetails[iRowCtr].tcPaidAmt);
                    $scope.objCBReceipt.cshBankDetail[selectedRowId].tcamount = paidTcAmt;
                }

                if ($scope.objCBReceipt.cshBankDetail[selectedRowId].genInvoiceNo != "") {
                    $scope.objCBReceipt.cshBankDetail[selectedRowId].isInvoiceNo = true;
                }

                $scope.objCBReceipt.cshBankDetail[selectedRowId].invoiceReceiptList = $scope.paymentInvoiceDetails;
                ngDialog.close();
                $scope.totalAmountCalculation();
            } else {
                logger.logError("Please Select an Pending Invoice Details!")
            }
        }

        $scope.totalAmountCalculation = function() {
            var cbrDtlPartyAcctRowDatas = $scope.objCBReceipt.cshBankDetail;
            var bcAmt = 0, tcAmt = 0, totalBCAmt = 0.0, totalTCAmt = 0.0;

            angular.forEach(cbrDtlPartyAcctRowDatas, function(item, key) {
                if (cbrDtlPartyAcctRowDatas[key].bcamount != "" || cbrDtlPartyAcctRowDatas[key].tcamount != "") {
                    bcAmt += parseFloat(cbrDtlPartyAcctRowDatas[key].bcamount);
                    tcAmt += parseFloat(cbrDtlPartyAcctRowDatas[key].tcamount);
                }
            });
            totalBCAmt += bcAmt;
            totalTCAmt += tcAmt;
            $scope.cbRcptDtlTotalAmt.totalBCAmount = totalBCAmt;
            $scope.cbRcptDtlTotalAmt.totalTCAmount = totalTCAmt;
        }

        $scope.cancelInvoicePriceDialog = function() {
            ngDialog.close();
        };
    });


    app.controller('cashbankReceiptInvoiceDtlViewCtrl', function($scope, $http, ngDialog, logger,$stateParams, invoiceReceiptList, $injector, sharedProperties, toaster, $rootScope, validationService, selectedRowId) {
        $scope.departmentCollections = [];
        $scope.rowCollection = [];
        $scope.isValid = false;
        $scope.chkAll = false;
        
      
    
        
        $scope.rowCollection=invoiceReceiptList;
        
        $scope.cancelInvoicePriceDialog = function() {
            ngDialog.close();
        };
    });
    
    app.controller('tableCtrl1', function($scope, $http, $filter, logger,$stateParams) {

        /* Account On Change............... */

 
    	$http.get("app/cashbankPayment/receiptList").success(function(datas) {
    	    $scope.receiptList = datas;
    	});
    	
        $scope.$watch('objCBReceipt.cshBankDetail[trIndex].acctName', function(newValue, oldValue) {

                
                
                

                if (newValue != '' && newValue != undefined) {
                    debugger;
                    if (newValue == '20060001' || newValue == '20000001') {
                     //   $scope.objCBReceipt.cshBankDetail[$scope.$index].isTradeDebtors = true;
                        $http.get($stateParams.tenantid +'/app/commonUtility/getSubAccountCodeLists').success(function(datas) {
                         /*   $scope.objCBReceipt.cshBankDetail[$scope.$index].subAccountCodeList = datas.commonUtilityBean;
                            $scope.objCBReceipt.cshBankDetail[$scope.$index].isSubAccountCode = true;*/
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
                    }  else {
                       // $scope.objCBReceipt.cshBankDetail[$scope.$index].isTradeDebtors = false;
                       // $scope.objCBReceipt.cshBankDetail[$scope.$index].subAccountCodeList = [];
                      //  $scope.objCBReceipt.cshBankDetail[$scope.$index].isSubAccountCode = false;
                    }

                
                
                $http.get($stateParams.tenantid +'/app/commonUtility/getAttributesList?accountCode=' + newValue).success(function(datas) {
                    $scope.objCBReceipt.cshBankDetail[$scope.$index].attributeList = datas;
                    if (newValue == oldValue) {
                        $scope.isOnChange = false;
                    } else {
                        $scope.isOnChange = true;
                    }
//                    if (!$scope.edit || $scope.isOnChange) {
////                        $scope.objCBReceipt.cshBankDetail[$scope.$index].employeeCode = '';
////                        $scope.objCBReceipt.cshBankDetail[$scope.$index].departmentCode = '';
//                        $scope.objCBReceipt.cshBankDetail[$scope.$index].countryCode = '';
////                        $scope.objCBReceipt.cshBankDetail[$scope.$index].customerCode = '';
//                        $scope.objCBReceipt.cshBankDetail[$scope.$index].supplierCode = '';
//                        $scope.objCBReceipt.cshBankDetail[$scope.$index].designationCode = '';
////                        $scope.objCBReceipt.cshBankDetail[$scope.$index].costCenter = '';
//                        $scope.objCBReceipt.cshBankDetail[$scope.$index].companyCode = '';
//                        $scope.objCBReceipt.cshBankDetail[$scope.$index].patientCode = '';
//                    }

                    $scope.objCBReceipt.cshBankDetail[$scope.$index].isEmployee = false;
                    $scope.objCBReceipt.cshBankDetail[$scope.$index].isDepartment = false;
                    $scope.objCBReceipt.cshBankDetail[$scope.$index].isLocation = false;
                    $scope.objCBReceipt.cshBankDetail[$scope.$index].isCustomer = false;
                    $scope.objCBReceipt.cshBankDetail[$scope.$index].isSupplier = false;
                    $scope.objCBReceipt.cshBankDetail[$scope.$index].isDesignation = false;
                    $scope.objCBReceipt.cshBankDetail[$scope.$index].isCostCenter = false;
                    $scope.objCBReceipt.cshBankDetail[$scope.$index].isCompany = false;

                    $scope.objCBReceipt.cshBankDetail[$scope.$index].isPatient = false;
                    angular.forEach($scope.objCBReceipt.cshBankDetail[$scope.$index].attributeList, function(row, rowindex) {
                        if (row.attributeName == "Employee") {
                            $scope.objCBReceipt.cshBankDetail[$scope.$index].isEmployee = true;
                        } else if (row.attributeName == "Students") {
                            $scope.objCBReceipt.cshBankDetail[$scope.$index].isDepartment = true;
                        } else if (row.attributeName == "Location") {
                            $scope.objCBReceipt.cshBankDetail[$scope.$index].isLocation = true;
                        } else if (row.attributeName == "Customer") {
                            $scope.objCBReceipt.cshBankDetail[$scope.$index].isCustomer = true;
                        } else if (row.attributeName == "Supplier") {
                            $scope.objCBReceipt.cshBankDetail[$scope.$index].isSupplier = true;
                        } else if (row.attributeName == "Designation") {
                            $scope.objCBReceipt.cshBankDetail[$scope.$index].isDesignation = true;
                        } else if (row.attributeName == "Cost Center") {
                            $scope.objCBReceipt.cshBankDetail[$scope.$index].isCostCenter = true;
                        } else if (row.attributeName == "Company") {
                            $scope.objCBReceipt.cshBankDetail[$scope.$index].isCompany = true;
                        } else if (row.attributeName == "Patient") {
                            $scope.objCBReceipt.cshBankDetail[$scope.$index].isPatient = true;
                        }
                    });

                }).error(function(datas) {
                });

                angular.forEach($scope.globalAccountListData, function(values, indexs) {
                    if (newValue == values.accountHeadCode) {
                        $scope.objCBReceipt.cshBankDetail[$scope.$index].currency = values.currencyCode;
                        $scope.objCBReceipt.cshBankDetail[$scope.$index].exgRate = values.exchangeRate;
                    }
                });
            } else {
                $scope.objCBReceipt.cshBankDetail[$scope.$index].currency = '';
                $scope.objCBReceipt.cshBankDetail[$scope.$index].exgRate = 1.0;
            }
        });
    });

    app.factory('CBRECEIPT', function($http, $q, logger,$stateParams) {
        var CBRECEIPT = new Object();
        CBRECEIPT.getBankList = function(com,i) {
            var bankData = $q.defer();
            var bankList;
            if(com!=null && com!='' && com!= undefined){

            $http.get('app/cashbankPayment/getBankAcctListcompanycode?companyCode=' + com).success(function(data) {


                 if(data.length > 0)
               {
                     bankData.resolve(data);
               }
                /* else{
                     
                     logger.logError("Voyage is not available for the given vessel");
                     
                 }*/
           });
            }
            else{
            $http.get('app/cashbankreceipt/getBankDrpDwn').success(function(datas) {
                bankList = datas.objCashBankReceiptListBean;
                if (datas.message == "success") {
                    bankData.resolve(bankList);
                } else {
                    logger.logError("Error Please Try Again");
                }
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
            }
            return bankData.promise
        }
        CBRECEIPT.getCashList = function(i) {
            var cashData = $q.defer();
            var cashList;
            $http.get('app/cashbankreceipt/getCashDrpDwn').success(function(datas) {
                cashList = datas.objCashBankReceiptListBean;
                if (datas.message == "success") {
                    cashData.resolve(cashList);
                } else {
                    logger.logError("Error Please Try Again");
                }
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
            return cashData.promise
        }
        CBRECEIPT.getTypeList = function(i) {
            var typeData = $q.defer();
            var typeList = [ {
                "id" : "B",
                "text" : "Bank"
            }, {
                "id" : "C",
                "text" : "Cash"
            } ];
            typeData.resolve(typeList);
            return typeData.promise
        }

        CBRECEIPT.getCompanyList = function() {
            var companyList = $q.defer();

            $http.get($stateParams.tenantid +'/app/commonUtility/getCompanyList').success(function(datas) {

                companyList.resolve(datas);

            }).error(function(datas) {
                companyList.reject("Failed to get Company List");
            });
            return companyList.promise;
        }

        return CBRECEIPT;
    });
//});
