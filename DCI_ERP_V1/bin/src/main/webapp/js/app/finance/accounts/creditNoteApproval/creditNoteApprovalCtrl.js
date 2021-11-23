//define([ 'hospital/accounts/accounts' ], function(module) {

    ///'use strict';
    app.controller('creditNoteApprovalListCtrl', function($scope, $state, $http,$stateParams ,ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, utilsService) {

        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages = 0;
        $scope.isUpload = true;
        $scope.isAdd = true;
        $scope.isDelete = true;

        $scope.getCreditNoteApprovalListUtil = function(limit, offset) {
            var start = new Date().getTime();
            var url = 'app/creditNote/cnlist?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount;
            $http.get(url).success(function(data) {
                if (data.success == true) {
                    $scope.pushCreditNoteApprovalListUtil(data);
                    $scope.dataLoopCount++;
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
        $scope.pushCreditNoteApprovalListUtil = function(data) {
            if (utilsService.isUndefinedOrNull(data.lCreditNoteBean)) {

                $scope.showEmptyLabel = true;

            } else {

                $scope.rowCollection = $scope.rowCollection.concat(data.lCreditNoteBean);

            }
        };

        $scope.getCreditNoteApprovalListUtil();

        $scope.editApprovalRow = function(collections) {
            $location.url($stateParams.tenantid +'/hospital/accounts/creditNoteApproval/approval/' + collections.creditNoteCode);
        }

        $scope.deleteApprovalRow = function(collections, index) {
            ngDialog.openConfirm().then(function() {
                var myURL = 'app/creditNote/delete';
                $http({
                    method : 'post',
                    url : myURL,
                    data : collections.creditNoteCode,
                }).success(function(data) {
                    if (data == true) {
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

    });

    app.controller('creditNoteApprovalCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, $stateParams, $timeout) {

        $scope.dataLoopCount = 0;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.acctHeadList = [];
        $scope.companyList = [];
        $scope.crdtlAcctHeadList = [];
        $scope.invoiceNoList = [];
        $scope.invoiceDetails = [];
        $scope.dtlSubAcctList = [];

        $scope.creditnoteAcctData = {
            creditNoteCode : '',
            acctName : '',
            accountName : '',
            invoiceNo : '',
            invoiceDate : '',
            currencyCode : '',
            exchangeRate : '',
            creditNoteDate : '',
            companyCode : '',
            company : '',
            narration : '',
            approveStatus : '',
            credittables : []
        };
        $scope.creditnoteDtlTotalAmt = {
            totalBCAmount : '',
            totalTCAmount : ''
        }
        $scope.edit = false;
        $scope.getDropdownValue = function() {

            $http.get($stateParams.tenantid +'app/commonUtility/getCompanyListWithUser').success(function(datas) {
                $scope.creditnoteAcctData.companyCode = datas.commonUtilityBean[0].value;
                $scope.creditnoteAcctData.company = datas.commonUtilityBean[0].description;

            }).error(function(data) {
            });

            /*
             * $http.get('app/commonUtility/getCustomerList').success(function(datas) {
             * 
             * var custList = []; angular.forEach(datas.commonUtilityBean,
             * function (item, key) { var cusObj = new Object(); cusObj.id =
             * datas.commonUtilityBean[key].value; cusObj.text =
             * datas.commonUtilityBean[key].text; custList.push(cusObj); });
             * $scope.acctHeadList = custList; }).error(function(data) { });
             */

            $http.get($stateParams.tenantid +'app/commonUtility/getCrDtlAccountHeadData').success(function(datas) {

                if (datas.commonUtilityBean.length > 0) {
                    var acctHeadList = [];
                    angular.forEach(datas.commonUtilityBean, function(item, key) {
                        var accHdObj = new Object();
                        accHdObj.id = datas.commonUtilityBean[key].accountHeadCode;
                        accHdObj.text = datas.commonUtilityBean[key].accountHeadName;
                        acctHeadList.push(accHdObj);
                    });
                    $scope.crdtlAcctHeadList = acctHeadList;
                }
            }).error(function(data) {
            });

            // sub account code --- Eg: customer, supplier will load in this
            // dropdown
            $http.get('app/commonUtility/getSubAccountCodeLists').success(function(datas) {

                var subAcctList = [];
                angular.forEach(datas.commonUtilityBean, function(item, key) {
                    var subAccHdObj = new Object();
                    subAccHdObj.id = datas.commonUtilityBean[key].subAccountCode;
                    subAccHdObj.text = datas.commonUtilityBean[key].subAccountName;
                    subAcctList.push(subAccHdObj);
                });
                $scope.dtlSubAcctList = subAcctList;
                $scope.acctHeadList = subAcctList;
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });

            // Attributes Dropdown

            $http.get('app/commonUtility/getEmployeeList').success(function(datas) {
                $scope.employeeList = datas;
            }).error(function(datas) {
            });

            $http.get('app/commonUtility/getDepartmentList').success(function(datas) {
                $scope.departmentList = datas;
            }).error(function(datas) {
            });

            $http.get('app/commonUtility/getCountryList').success(function(datas) {
                $scope.countryList = datas;
            }).error(function(datas) {
            });
            $http.get('app/commonUtility/getSupplierList').success(function(datas) {
                $scope.supplierList = datas;
            }).error(function(datas) {
            });
            $http.get('app/commonUtility/getCustomerAttributeList').success(function(datas) {
                $scope.customerList = datas;
            }).error(function(datas) {
            });

            $http.get('app/commonUtility/getDesignationList').success(function(datas) {
                $scope.designationList = datas;
            }).error(function(datas) {
            });

            $http.get('app/commonUtility/getCostCenter').success(function(datas) {

                $scope.costCenterList = datas;
            }).error(function(datas) {
            });

            $http.get('app/purchaseinvoice/getCompanyList').success(function(datas) {
                $scope.companyList = datas;
            }).error(function(datas) {
            });
            $http.get('app/commonUtility/getPatientList').success(function(datas) {
                $scope.patientList = datas;
            }).error(function(datas) {
            });
        }
        $scope.getDropdownValue();

        /**
         * Fetching Invoice Dropdown with AcctHead Code
         * *****************************************************************
         */

        $scope.$watch('creditnoteAcctData.accountName', function(newValue, oldValue) {
            if (newValue != '' && newValue != undefined) {

                $http.get('app/creditNote/getInvoiceNo?acctHeadCode=' + newValue).success(function(datas) {

                    if (datas.length > 0) {

                        $scope.invoiceNoList = datas;
                    } else {
                        $scope.creditnoteAcctData.invoiceDate = "";
                        $scope.creditnoteAcctData.currencyCode = "";
                        $scope.creditnoteAcctData.exchangeRate = "";
                    }
                }).error(function(data) {
                });
            } else {
                $scope.invoiceNoList = [];
                $scope.creditnoteAcctData.invoiceDate = "";
                $scope.creditnoteAcctData.currencyCode = "";
                $scope.creditnoteAcctData.exchangeRate = "";
            }
        });
        /**
         * fetch invoice date, currency code, exchange rate from invoice No
         * ***********************************************
         */

        $scope.$watch('creditnoteAcctData.invoiceNo', function(newValue, oldValue, invList) {

            if (newValue != '' && newValue != undefined) {
                var invoicesList = invList.invoiceNoList;

                angular.forEach(invoicesList, function(item, key) {

                    if (newValue == invoicesList[key].invoiceNo) {
                        $scope.creditnoteAcctData.invoiceDate = invoicesList[key].invoiceDate;
                        $scope.creditnoteAcctData.currencyCode = invoicesList[key].currencyCode;
                        $scope.creditnoteAcctData.exchangeRate = invoicesList[key].exgRate;
                    }
                });

            } else {
                $scope.creditnoteAcctData.invoiceNo = "";
                $scope.creditnoteAcctData.invoiceDate = "";
                $scope.creditnoteAcctData.currencyCode = "";
                $scope.creditnoteAcctData.exchangeRate = "";
            }
        });

        /***********************************************************************
         * Edit Functionality *******************************
         */
        var creditNoteCode = $stateParams.creditNoteCode;

        if (creditNoteCode == undefined || creditNoteCode == null || creditNoteCode == "") {
        } else {
            $scope.edit = true;
            $timeout(function() {
                $http.get('app/creditNote/getCreditNoteForEdit?creditCode=' + creditNoteCode).success(function(data) {
                    $scope.creditnoteAcctData = data;

                    $scope.totalAmountCalculation();
                }).error(function(data) {
                });
            }, 2, false);
        }

        /**
         * total Amount Calculation - calculate from credit note detail table..
         */
        $scope.totalAmountCalculation = function() {
            var crDtlRowDatas = $scope.creditnoteAcctData.credittables;
            var bcAmt = 0, tcAmt = 0;
            angular.forEach(crDtlRowDatas, function(item, key) {
                bcAmt += parseFloat(crDtlRowDatas[key].bcamount);
                tcAmt += parseFloat(crDtlRowDatas[key].tcamount);
                $scope.creditnoteDtlTotalAmt.totalBCAmount = bcAmt;
                $scope.creditnoteDtlTotalAmt.totalTCAmount = tcAmt;

            });

        }

        /**
         * Validate Data for Approve Record
         */

        /**
         * Approval
         */
        $scope.updateapproval = function(creditnoteAcctData) {
            $scope.selectedrow = [];
            var creditnoteCodes = creditnoteAcctData.creditNoteCode;
            var creditnoteStatus = creditnoteAcctData.approveStatus;
            if (creditnoteStatus != 'Pending') {
                if (creditnoteCodes != "" && creditnoteStatus != "") {
                    $http.post('app/creditNote/approveCreditNote?creditnoteCodes=' + creditnoteCodes + "&creditnoteStatus=" + creditnoteStatus).success(function(data) {

                        if (data) {
                            logger.logSuccess("Record Approved Successfully!");
                            $location.path("hospital/accounts/creditNoteApproval/list");

                        } else {
                            logger.logSuccess("Record Approved Successfully");
                            $location.path("hospital/accounts/creditNoteApproval/list");
                        }
                    }).error(function(data) {
                    });
                }
            } else {
                logger.logError("Please Change the Status as Approved..!");
            }

        }
        $scope.cancel = function() {
            $state.go("app.hospital.accounts.creditNoteApproval.list");
        };

    });
    app.controller('tableCtrl', function($scope, $http, $filter, logger) {
        $scope.$watch('creditnoteAcctData.credittables[trIndex].crdtlAccountHead', function(newValue, oldValue) {
            if (newValue != '' && newValue != undefined) {
                $http.get('app/commonUtility/getAttributesList?accountCode=' + newValue).success(function(datas) {
                    $scope.creditnoteAcctData.credittables[$scope.$index].attributeList = datas;
                    if (newValue == oldValue) {
                        $scope.isOnChange = false;
                    } else {
                        $scope.isOnChange = true;
                    }
                    if (!$scope.edit || $scope.isOnChange) {

                        $scope.creditnoteAcctData.credittables[$scope.$index].employeeCode = '';
                        $scope.creditnoteAcctData.credittables[$scope.$index].departmentCode = '';
                        $scope.creditnoteAcctData.credittables[$scope.$index].countryCode = '';
                        $scope.creditnoteAcctData.credittables[$scope.$index].customerCode = '';
                        $scope.creditnoteAcctData.credittables[$scope.$index].supplierCode = '';
                        $scope.creditnoteAcctData.credittables[$scope.$index].designationCode = '';
                        $scope.creditnoteAcctData.credittables[$scope.$index].costCenter = '';
                        $scope.creditnoteAcctData.credittables[$scope.$index].companyCode = '';
                        $scope.creditnoteAcctData.credittables[$scope.$index].patientCode = '';
                    }

                    $scope.creditnoteAcctData.credittables[$scope.$index].isEmployee = false;

                    $scope.creditnoteAcctData.credittables[$scope.$index].isDepartment = false;

                    $scope.creditnoteAcctData.credittables[$scope.$index].isLocation = false;
                    $scope.creditnoteAcctData.credittables[$scope.$index].isCustomer = false;
                    $scope.creditnoteAcctData.credittables[$scope.$index].isSupplier = false;
                    $scope.creditnoteAcctData.credittables[$scope.$index].isDesignation = false;
                    $scope.creditnoteAcctData.credittables[$scope.$index].isCostCenter = false;
                    $scope.creditnoteAcctData.credittables[$scope.$index].isCompany = false;

                    $scope.creditnoteAcctData.credittables[$scope.$index].isPatient = false;

                    angular.forEach($scope.creditnoteAcctData.credittables[$scope.$index].attributeList, function(row, rowindex) {
                        if (row.attributeName == "Employee") {
                            $scope.creditnoteAcctData.credittables[$scope.$index].isEmployee = true;
                        } else if (row.attributeName == "Department") {
                            $scope.creditnoteAcctData.credittables[$scope.$index].isDepartment = true;
                        } else if (row.attributeName == "Location") {
                            $scope.creditnoteAcctData.credittables[$scope.$index].isLocation = true;
                        } else if (row.attributeName == "Customer") {
                            $scope.creditnoteAcctData.credittables[$scope.$index].isCustomer = true;
                        } else if (row.attributeName == "Supplier") {
                            $scope.creditnoteAcctData.credittables[$scope.$index].isSupplier = true;
                        } else if (row.attributeName == "Designation") {
                            $scope.creditnoteAcctData.credittables[$scope.$index].isDesignation = true;
                        } else if (row.attributeName == "Cost Center") {
                            $scope.creditnoteAcctData.credittables[$scope.$index].isCostCenter = true;
                        } else if (row.attributeName == "Company") {
                            $scope.creditnoteAcctData.credittables[$scope.$index].isCompany = true;
                        } else if (row.attributeName == "Patient") {
                            $scope.creditnoteAcctData.credittables[$scope.$index].isPatient = true;
                        }
                    });
                }).error(function(datas) {
                });

            }
        });
        $scope.$watch('creditnoteAcctData.credittables[trIndex].subAcctCode', function(newValue, oldValue) {
            if (newValue != '' && newValue != undefined) {
                $scope.creditnoteAcctData.credittables[$scope.$index].subAcctCode = newValue;
            }

        });
  //  });
});