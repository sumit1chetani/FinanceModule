//define([ 'hospital/accounts/accounts' ], function(module) {

    'use strict';
    app.controller('debitNoteListCtrl', function($scope, $state, $stateParams,$http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, utilsService) {

        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages = 0;
        $scope.isUpload = true;
        $scope.isDelete = true;
        $scope.getList = function(limit, offset) {
            var start = new Date().getTime();
            var url = 'app/debitnote/list?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount;
            $http.get(url).success(function(data) {
                if (data.success == true) {
                    $scope.pushDebitNoteListUtil(data);
                    $scope.dataLoopCount++;

                    var url = 'app/debitnote/debitCodelist';
                    $http.get(url).success(function(data) {
                       
                            $scope.debitNoteList = data;
                       
                    }).error(function(data) {
                        logger.logError("Error Please Try Again");
                    });
                    
                    
                } else {
                    if ($scope.dataLoopCount == 0) {
                        $scope.showEmptyLabel = true;
                    }
                    logger.logError("Error Please Try Again");
                }
                var end = new Date().getTime();
                var time = end - start;
                
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });

        };
        $scope.debitNoteList = [];
        var url = 'app/debitnote/debitCodelist';
        $http.get(url).success(function(data) {
           
                $scope.debitNoteList = data;
           
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
        $scope.pushDebitNoteListUtil = function(data) {
            if (utilsService.isUndefinedOrNull(data.lDebitNoteBean)) {

                $scope.showEmptyLabel = true;

            } else {

                $scope.rowCollection = data.lDebitNoteBean;

            }
        };

        $scope.getList();

        $scope.add = function() {
            $state.go("app.finance.accounts.debitNote.add");
        };
        $scope.editDebitNoteRow = function(collections) {
            $location.url( $stateParams.tenantid+ '/hospital/accounts/debitNote/edit/' + collections.debitNoteNo);
        };
        
        $scope.viewDebitNoteRow = function(collections) {
            $location.url( $stateParams.tenantid+'/hospital/accounts/debitNote/view/' + collections.debitNoteNo);
        };
        $scope.deleteDebitNoteRow = function(collections, index) {
            ngDialog.openConfirm().then(function() {
                var myURL = 'app/debitnote/delete';
                $http({
                    method : 'post',
                    url : myURL,
                    data : collections.debitNoteNo,
                }).success(function(data) {
                    if (data == true) {
                        var tableData = $scope.rowCollection;
                        $scope.rowCollection.splice(index, 1);
                        logger.logSuccess("Deleted Successfully");
                        $state.getList();
                    } else {
                        logger.logError("Error in Deleting Record!");
                    }
                }).error(function(data) {
                    logger.logSuccess("Error in Delete!");
                });
            });
        };


        /**
         * reverse payment
         */
        $scope.reverseConfirm = function() {
            if ($scope.debitCode == "" || $scope.debitCode == undefined) {
                logger.logError("Please Select Debit No!");
            } else {
                if($scope.debitNoteBean.debitDate != null && $scope.debitNoteBean.debitDate != "" && 
                        $scope.debitNoteBean.debitDate != ""){
                    $http.get('app/debitnote/reverseDebit?debitCode='+ $scope.debitCode
                            +'&createdDate='+$scope.debitNoteBean.debitDate).success(function(datas) {

                    if (datas.success == true) {
                        logger.logSuccess(datas.message);
                        ngDialog.close();   
                        $scope.getList();
                    } else {
                        
                        logger.logError(datas.message);
                    }
                }).error(function(datas) {
                });
                }else{
                    logger.logError("Please Select Debit Date!");
 
                }
            }
        }
        

        $scope.debitNoteBean = {
                debitDate:''
        }
        $scope.reversePayment = function() {

            var today = new Date();
            var dd = today.getDate();
            var mm = today.getMonth() + 1;

            var yyyy = today.getFullYear();
            var hh = today.getHours();

            var min = today.getMinutes();
            if (dd < 10) {
                dd = '0' + dd;
            }
            if (mm < 10) {
                mm = '0' + mm;
            }
            var today = dd + '/' + mm + '/' + yyyy+" "+hh+":"+min;
            var today1 = dd + '/' + mm + '/' + yyyy;

            $scope.debitNoteBean.debitDate = today1;
            $scope.screenNames = "DebitNote";
            if($scope.debitCode =="" || $scope.debitCode ==undefined){
                logger.logError("Please Select Receipt Voucher");
            }else{         
                ngDialog.open({
                    template : 'views/finance/accounts/paymentreceipt/transactionCBRreverse',
                    scope :$scope
                });
            }
              
        };

        $scope.closeCBPReverseDialog = function() {
            ngDialog.close();    
        };
    });

    app.controller('debitNoteAddCtrl', function($scope, $state, $http, $location, sharedProperties, toaster, $injector, logger, $stateParams, $timeout, validationService) {

        sharedProperties.getObject();

        $scope.dataLoopCount = 0;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];

        $scope.accountHeadList = [];
        $scope.dtlSubAcctList = [];
        $scope.drdtlAcctHeadList = [];
        $scope.invoiceNoList = [];
        $scope.paymentList=[];

        $scope.companyList = [];

        $scope.validated = false;

        $scope.edit = false;

        $scope.debitNoteMasterData = {
            acctHeadName : '',
            invoiceNo : '',
            invoiceDate : '',
            currencyCode : '',
            exchangeRate : '',
            debitNoteDate : '',
            companyCode : '',
            companyName : '',
            company : '',
            narration : '',
            amount : '',
            amountUSD : '',
            dtlNarration : '',
            debittables : [],
            accountHeadList : []
        };
        $scope.debitnoteDtlTotalAmt = {
            totalBCAmount : '',
            totalTCAmount : ''
        }

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
            $scope.debitNoteMasterData.debitNoteDate = $scope.date;
        }
        $scope.getCurrentDate();

        $scope.compareDate = function(debitNoteDate) {

            var isValidDate = false;
            var dateEntered = debitNoteDate;
            var date = dateEntered.substring(0, 2);
            var month = dateEntered.substring(3, 5);
            var year = dateEntered.substring(6, 10);

            var dateToCompare = new Date(year, month - 1, date);
            var currentDate = new Date();

            if (dateToCompare > currentDate) {
                isValidDate = false;
            } else {
                isValidDate = true;
            }

            return isValidDate;
        }

        /**
         * validation
         */
        $scope.checkBCAmount = function() {
            var isFlag = true;
            angular.forEach($scope.debitNoteMasterData.debittables, function(row, index) {
                if (row.amount == 0)
                    isFlag = false;
                else if (parseFloat($scope.isNaNCheck(row.amount)) == 0)
                    isFlag = false;
                else if (parseFloat($scope.isUndefinedAndNullCheck(row.amount)) == 0)
                    isFlag = false;
            });
            return isFlag;
        }

        $scope.checkDtlTblRows = function() {
            var isFlag = true;
            var drLength = $scope.debitNoteMasterData.debittables;
            if (drLength == 0) {
                isFlag = false;
            }
            return isFlag;
        }

        /**
         * is NaNCheck
         */
        $scope.isNaNCheck = function(value) {
            if (isNaN(value)) {
                value = 0;
            }
            return value;
        }
        $scope.isUndefinedAndNullCheck = function(value) {
            if (value == undefined && value == null && value == "") {
                value = 0;
            }
            return value;
        }

        $scope.validate = function(debitNoteForm, debitNoteMasterData) {

            var isValidDate = $scope.compareDate($scope.debitNoteMasterData.debitNoteDate);
            if (isValidDate) {
                if (new validationService().checkFormValidity($scope.debitNoteForm)) {
                    if (!$scope.edit) {
                        $scope.save(debitNoteForm, debitNoteMasterData);
                    } else {
                        $scope.save(debitNoteForm, debitNoteMasterData);
                    }
                } else {
                    toaster.pop('Error', "Please Fill the Required Fields", logger.getErrorHtmlNew($scope.debitNoteForm.$validationSummary), 555000, 'trustedHtml');
                }
            } else {
                logger.logError("Debit Note Date Should not be a Future Date");
            }

        };

        /**
         * dropdown Datas ***********************************
         */
        $scope.getDropDownList = function() {
            $http.get( $stateParams.tenantid+'/app/commonUtility/getCompanyListWithUser').success(function(datas) {
                $scope.debitNoteMasterData.companyCode = datas.commonUtilityBean[0].value;
                $scope.debitNoteMasterData.company = datas.commonUtilityBean[0].description;

            }).error(function(data) {
            });

            $http.get( $stateParams.tenantid+'/app/commonUtility/getCrDtlAccountHeadData').success(function(datas) {
                if (datas.commonUtilityBean.length > 0) {
                    var acctHeadList = [];
                    angular.forEach(datas.commonUtilityBean, function(item, key) {
                        var accHdObj = new Object();
                        accHdObj.id = datas.commonUtilityBean[key].accountHeadCode;
                        accHdObj.text = datas.commonUtilityBean[key].accountHeadName;
                        acctHeadList.push(accHdObj);
                    });
                    $scope.drdtlAcctHeadList = acctHeadList;
                }
            }).error(function(data) {
            });

            $http.get( $stateParams.tenantid+'/app/commonUtility/getSubAccountCodeLists').success(function(datas) {
                var subAcctList = [];
                angular.forEach(datas.commonUtilityBean, function(item, key) {
                    var subAccHdObj = new Object();
                    subAccHdObj.id = datas.commonUtilityBean[key].subaccountcode;
                    subAccHdObj.text = datas.commonUtilityBean[key].subaccountname;
                    subAcctList.push(subAccHdObj);
                });
                $scope.dtlSubAcctList = subAcctList; // Detail Sub Account
                                                        // field - load customer
                                                        // and supplier
                $scope.accountHeadList = subAcctList; // Header Account Head
                                                        // field -- load
                                                        // customer and supplier
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });

            $http.get( $stateParams.tenantid+'/app/commonUtility/getEmployeeList').success(function(datas) {
                $scope.employeeList = datas;
            }).error(function(datas) {
            });

            $http.get( $stateParams.tenantid+'/app/commonUtility/getDepartmentList').success(function(datas) {
                $scope.departmentList = datas;
            }).error(function(datas) {
            });

            $http.get( $stateParams.tenantid+'/app/commonUtility/getCountryList').success(function(datas) {
                $scope.countryList = datas;
            }).error(function(datas) {
            });

            $http.get( $stateParams.tenantid+'/app/commonUtility/getSupplierList').success(function(datas) {
                $scope.supplierList = datas;
            }).error(function(datas) {
            });
            $http.get( $stateParams.tenantid+'/app/commonUtility/getCustomerAttributeList').success(function(datas) {

                $scope.customerList = datas;
            }).error(function(datas) {
            });

            $http.get( $stateParams.tenantid+'/app/commonUtility/getDesignationList').success(function(datas) {
                $scope.designationList = datas;
            }).error(function(datas) {
            });

            $http.get( $stateParams.tenantid+'/app/commonUtility/getCostCenter').success(function(datas) {
                $scope.costCenterList = datas;
            }).error(function(datas) {
            });
            
            
            $http.get( $stateParams.tenantid+'/app/commonUtility/getstudentList').success(function(datas) {
                $scope.studentList = datas;
            }).error(function(datas) {
            });

            $http.get( $stateParams.tenantid+'/app/purchaseinvoice/getCompanyList').success(function(datas) {
                $scope.companyList = datas;
            }).error(function(datas) {
            });
            $http.get( $stateParams.tenantid+'/app/commonUtility/getPatientList').success(function(datas) {
                $scope.patientList = datas;
            }).error(function(datas) {
            });
        };
        $scope.getDropDownList();

        /**
         * Fetching Invoice Dropdown with AcctHead Code
         * *****************************************************************
         */

        $scope.$watch('debitNoteMasterData.acctHeadName', function(newValue, oldValue) {
            if (newValue != '' && newValue != undefined) {
                $http.get('app/creditNote/getInvoiceNo?acctHeadCode=' + newValue).success(function(datas) {
                    if (datas.length > 0) {
                        $scope.invoiceNoList = datas;
                    } else {
                        $scope.debitNoteMasterData.invoiceDate = "";
                        $scope.debitNoteMasterData.currencyCode = "";
                        $scope.debitNoteMasterData.exchangeRate = "";
                        $scope.invoiceNoList = [];
                    }
                }).error(function(data) {
                });
            } else {
                $scope.invoiceNoList = [];
                $scope.debitNoteMasterData.invoiceDate = "";
                $scope.debitNoteMasterData.currencyCode = "";
                $scope.debitNoteMasterData.exchangeRate = "";
            }
        });

        /**
         * fetch invoice date, currency code, exchange rate from invoice No
         * ***********************************************
         */
        $scope.$watch('debitNoteMasterData.invoiceNo', function(newValue, oldValue, invoices) {

            if (newValue != '' && newValue != undefined) {
                angular.forEach(invoices.invoiceNoList, function(item, key) {
                    if (newValue == invoices.invoiceNoList[key].invoiceNo) {
                        $scope.debitNoteMasterData.invoiceDate = invoices.invoiceNoList[key].invoiceDate;
                        $scope.debitNoteMasterData.currencyCode = invoices.invoiceNoList[key].currencyCode;
                        $scope.debitNoteMasterData.exchangeRate = invoices.invoiceNoList[key].exgRate;
                    }
                });

            } else {
                $scope.debitNoteMasterData.invoiceDate = "";
                $scope.debitNoteMasterData.currencyCode = "";
                $scope.debitNoteMasterData.exchangeRate = "";
            }
        });

        $scope.totalAmountCalculation = function() {
            var drDtlRowDatas = $scope.debitNoteMasterData.debittables;
            var bcAmt = 0, tcAmt = 0;
            angular.forEach(drDtlRowDatas, function(item, key) {
                bcAmt += parseFloat(drDtlRowDatas[key].amount);
                tcAmt += parseFloat(drDtlRowDatas[key].amountUSD);
                $scope.debitnoteDtlTotalAmt.totalBCAmount = bcAmt.toFixed(2);
                $scope.debitnoteDtlTotalAmt.totalTCAmount = tcAmt.toFixed(2);
            });

        }

        $scope.amountCalculation = function(amount, index, row) {

            if (amount != undefined && amount != "") {
                row.amount = parseFloat(amount);
                if ($scope.debitNoteMasterData.exchangeRate != 0 && $scope.debitNoteMasterData.exchangeRate != "") {
                    var tcAmt = parseFloat(amount) / parseFloat($scope.debitNoteMasterData.exchangeRate);
                    row.amountUSD = tcAmt.toFixed(2);
                    $scope.totalAmountCalculation();
                } else {
                    row.amountUSD = 0;
                    $scope.totalAmountCalculation();
                }
            }
        }
        /**
         * Debit Note Detail Table
         * ******************************************************************************************
         */
        $scope.loadDrTable = function() {
            var drtable = {};

            drtable = {
                select : '',
                drdtlAccountHead : '',
                subAcctCode : '',
                dtlNarration : '',
                amount : '',
                amountUSD : '',
                slNo : 1,
                cbpdtlpaymentreceipt :'',
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
                attributeList : []

            };
            $scope.debitNoteMasterData.debittables.push(drtable);

        }
        // add Row
        $scope.addCredRow = function(tables) {
            var len = tables.length;
            var table = {
                select : '',
                drdtlAccountHead : '',
                subAcctCode : '',
                dtlNarration : '',
                amount : '',
                amountUSD : '',
                slNo : 1,
                cbpdtlpaymentreceipt :'',
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
                attributeList : []

            };
            table.slNo = len + 1;
            tables.push(table);
        };

        // remove Row
        $scope.removeCredRow = function(table) {
            $scope.tablerow = [];
            angular.forEach(table, function(row, index) {
                var check = row.select;// $('#section' + index +
                                        // ':checked').val();
                if (check == undefined || check == "") {
                    $scope.tablerow.push(row);
                } else {

                }
            });
            angular.forEach($scope.tablerow, function(row, index) {
                row.slNo = index + 1;
            });
            $scope.debitNoteMasterData.debittables = $scope.tablerow;

            $scope.totalAmountCalculation();
        };
        $scope.loadDrTable();
        /**
         * save and update functionality
         * ************************************************
         */

        $scope.save = function() {
            $scope.debitNoteMasterData.amount = $scope.debitnoteDtlTotalAmt.totalBCAmount;
            $scope.debitNoteMasterData.amountUSD = $scope.debitnoteDtlTotalAmt.totalTCAmount;
            var isBcAmount = $scope.checkBCAmount();
            var isCrDtlRows = $scope.checkDtlTblRows();
            if (isCrDtlRows) {
                if (isBcAmount) {
                    angular.forEach($scope.debitNoteMasterData.debittables, function(key, index) {

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
                    });

                    if ($scope.edit == false) {
                        $http.post('app/debitnote/save', $scope.debitNoteMasterData).success(function(result) {
                            if (result) {
                                logger.logSuccess("Saved Successfully!");
                                $location.path($stateParams.tenantid+'/hospital/accounts/debitNote/list');
                            } else {
                                $location.path($stateParams.tenantid+'/hospital/accounts/debitNote/list');
                                logger.logError("Not Saved!");
                            }
                        }).error(function(result) {
                        });
                    } else {
                        $http.post('app/debitnote/update', $scope.debitNoteMasterData).success(function(result) {
                            if (result) {
                                logger.logSuccess("Updated Successfully!");
                                $location.path($stateParams.tenantid+'/hospital/accounts/debitNote/list');
                            } else {
                                logger.logError("Not Updated!");
                            }
                        }).error(function(data) {
                        });
                    }
                } else {
                    logger.logError("Please Enter  Amount!");
                }
            } else {
                logger.logError("Please Add Atleast One Row!");
            }

        };

        /***********************************************************************
         * Edit Functionality *******************************
         */

        $scope.fetchEditData = function() {
            var debitNoteNo = $stateParams.debitNoteCode;

            if (debitNoteNo == undefined || debitNoteNo == null || debitNoteNo == "") {
            } else {
                $scope.edit = true;
                $timeout(function() {
                    $http.get('app/debitnote/getDebitNoteForEdit?debitCode=' + debitNoteNo).success(function(data) {
                        $scope.debitNoteMasterData = data;
                        $scope.totalAmountCalculation();
                    }).error(function(data) {
                    });
                }, 2, false);
            }
        }
        $scope.fetchEditData();

        /**
         * Reset Functionality ******************************
         */
        var originalCNAcctDatas = angular.copy($scope.debitNoteMasterData);
        var originalCNAcctTotal = angular.copy($scope.debitnoteDtlTotalAmt);

        $scope.reset = function(debitNoteForm, debitNoteMasterData) {

            if ($scope.edit == false) {
                $scope.debitNoteMasterData = angular.copy(originalCNAcctDatas);
                $scope.debitnoteDtlTotalAmt = angular.copy(originalCNAcctTotal);
                $scope.debitNoteForm.$setPristine();
            } else {
                $scope.fetchEditData();
            }
            $scope.getDropDownList();
        }

        $scope.cancel = function() {
            $location.path($stateParams.tenantid+'/hospital/accounts/debitNote/list');
        };

    });
    app.controller('tableCtrl', function($scope, $http, $filter, logger,$stateParams) {
       
    	  $http.get("app/cashbankPayment/paymentreceiptList").success(function(datas) {
              $scope.paymentList = datas;
          });
       
    	
    	$scope.$watch('debitNoteMasterData.debittables[trIndex].drdtlAccountHead', function(newValue, oldValue) {
            if (newValue != '' && newValue != undefined) {
                $http.get($stateParams.tenantid+'/app/commonUtility/getAttributesList?accountCode=' + newValue).success(function(datas) {
                    $scope.debitNoteMasterData.debittables[$scope.$index].attributeList = datas;
                    if (newValue == oldValue) {
                        $scope.isOnChange = false;
                    } else {
                        $scope.isOnChange = true;
                    }
                    if (!$scope.edit || $scope.isOnChange) {

                        $scope.debitNoteMasterData.debittables[$scope.$index].employeeCode = '';
                        $scope.debitNoteMasterData.debittables[$scope.$index].departmentCode = '';
                        $scope.debitNoteMasterData.debittables[$scope.$index].countryCode = '';
                        $scope.debitNoteMasterData.debittables[$scope.$index].customerCode = '';
                        $scope.debitNoteMasterData.debittables[$scope.$index].supplierCode = '';
                        $scope.debitNoteMasterData.debittables[$scope.$index].designationCode = '';
                        $scope.debitNoteMasterData.debittables[$scope.$index].costCenter = '';
                        $scope.debitNoteMasterData.debittables[$scope.$index].companyCode = '';
                        $scope.debitNoteMasterData.debittables[$scope.$index].patientCode = '';
                    }

                    $scope.debitNoteMasterData.debittables[$scope.$index].isEmployee = false;

                    $scope.debitNoteMasterData.debittables[$scope.$index].isDepartment = false;

                    $scope.debitNoteMasterData.debittables[$scope.$index].isLocation = false;
                    $scope.debitNoteMasterData.debittables[$scope.$index].isCustomer = false;
                    $scope.debitNoteMasterData.debittables[$scope.$index].isSupplier = false;
                    $scope.debitNoteMasterData.debittables[$scope.$index].isDesignation = false;
                    $scope.debitNoteMasterData.debittables[$scope.$index].isCostCenter = false;
                    $scope.debitNoteMasterData.debittables[$scope.$index].isCompany = false;

                    $scope.debitNoteMasterData.debittables[$scope.$index].isPatient = false;

                    angular.forEach($scope.debitNoteMasterData.debittables[$scope.$index].attributeList, function(row, rowindex) {
                        if (row.attributeName == "Employee") {
                            $scope.debitNoteMasterData.debittables[$scope.$index].isEmployee = true;
                        } else if (row.attributeName == "Students") {
                            $scope.debitNoteMasterData.debittables[$scope.$index].isDepartment = true;
                        } else if (row.attributeName == "Location") {
                            $scope.debitNoteMasterData.debittables[$scope.$index].isLocation = true;
                        } else if (row.attributeName == "Customer") {
                            $scope.debitNoteMasterData.debittables[$scope.$index].isCustomer = true;
                        } else if (row.attributeName == "Supplier") {
                            $scope.debitNoteMasterData.debittables[$scope.$index].isSupplier = true;
                        } else if (row.attributeName == "Designation") {
                            $scope.debitNoteMasterData.debittables[$scope.$index].isDesignation = true;
                        } else if (row.attributeName == "Cost Center") {
                            $scope.debitNoteMasterData.debittables[$scope.$index].isCostCenter = true;
                        } else if (row.attributeName == "Company") {
                            $scope.debitNoteMasterData.debittables[$scope.$index].isCompany = true;
                        } else if (row.attributeName == "Patient") {
                            $scope.debitNoteMasterData.debittables[$scope.$index].isPatient = true;
                        }
                    });
                }).error(function(datas) {
                });

            }
        });
    });
    app.directive('numbersOnly', function(logger) {
        return {
            require : 'ngModel',
            link : function(scope, element, attrs, modelCtrl) {

                modelCtrl.$parsers.push(function(inputValue) {
                    var inputValue = modelCtrl.$viewValue;
                    if (inputValue == undefined)
                        return ''
                    var transformedInput = inputValue.replace(/[^0-9\.]/g, '');
                    if (transformedInput != inputValue) {
                        modelCtrl.$setViewValue(transformedInput);
                        modelCtrl.$render();
                    } else {
                    }

                    return transformedInput;
                });
            }
        };
   //});
});/**
     * 
     */
