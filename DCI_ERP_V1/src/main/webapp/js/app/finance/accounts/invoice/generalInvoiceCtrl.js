//define([ 'hospital/accounts/accounts' ], function(module) {

    //'use strict';
    app.controller('generalInvoiceCtrl', function($scope, $stateParams, $window, $rootScope, $location, $http, logger,
            $log, ngDialog, $modal, utilsService, $state) {

        $scope.dataLoopCount = 0;
        $scope.from = 0;
        $scope.to = 100;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.isUpload = true;
        $scope.isDelete = true;
        $scope.getTranslationList = function() {
            $scope.dataLoopCount = 0;
            $scope.showEmptyLabel = false;
            $scope.from = 0;
            $scope.to = 100;
            $scope.rowCollection = [];
            $scope.GeneralInvoiceList = [];
            var url = 'app/generalinvoice/list?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount;
            $http.get(url).success(function(data) {
                if (data.success == true) {
                    $scope.rowCollection = $scope.rowCollection.concat(data.lGeneralInvoiceList);
                }
            });
        };

        $scope.getTranslationList();
        $scope.add = function() {
            $state.go('app.finance.accounts.invoice.add');
       
            };

        $scope.onChangeNumber = function(ids, num) {
            num = num.replace(/[^0-9 .]/g, '');
            $('#' + ids).val(num);
            return num;
        }

        $scope.editRowBtn = function(InvoiceNo, index) {
            $location.path( $stateParams.tenantid +'/hospital/accounts/invoiceedit/' + InvoiceNo);
        }

        // remove to the real data holder
        $scope.deleteRow = function(InvoiceNo, index) {
            ngDialog.openConfirm().then(function() {
                var myURL = 'app/generalinvoice/delete';
                $http({
                    method : 'post',
                    url : myURL,
                    data : InvoiceNo,
                }).success(function(data) {
                    if (data == true) {
                        var tableData = $scope.rowCollection;
                        $scope.rowCollection.splice(index, 1);
                        logger.logSuccess("Invoice deleted successfully");
                    } else {
                        logger.logError("Error in deleting Invoice !");
                    }
                }).error(function(data) {
                    logger.logSuccess("Error in Delete Invoice !");
                });
                console.log('Modal promise resolved. Value: ');
            }, function(reason) {
                console.log('Modal promise rejected. Reason: ', reason);
            });

        };

        // Print
        $scope.printGIRow = function(invoiceNo) {
            var url = 'app/generalinvoice/exportGeneralInvoicePdf?invoiceNo=' + invoiceNo;
            $http.get(url).success(function(data) {
                if (data.success == true) {
                    $window.open('tempdoc/Invoice.pdf', 'Title', 'width=600,height=700');
                } else {
                    logger.logError("Error Please Try Again");
                }
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        }
        
        
        $scope.printPaymentVoucherDiv = function(invoiceNo) {
            var url = 'app/generalinvoice/print?invoiceNo=' + invoiceNo;
            var wnd = window.open(url, 'HISERP', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
            //wnd.print();
            if (wnd.print) {
                var done = false;
                if (wnd.document && wnd.document.readyState) {
                    var rs = wnd.document.readyState;
                    if ((rs === 'complete') || (rs === 'loaded')) {
                        done = true;
                        wnd.print();
                    }
                }
                if (!done) {
                    if (wnd.addEventListener) {
                        wnd.addEventListener('load', function() {
                            this.print();
                        });
                    } else {
                        wnd.onload = function() {
                            this.print();
                        };
                    }
                }
            }
        }

    });

   // app.controller('generalInvoiceCtrladd', function($scope,$stateParams, $window, $rootScope, $location, $filter, $http, logger, $log, ngDialog, $modal, utilsService, ListService, $stateParams, $timeout, validationService, toaster) {
    app.controller('generalInvoiceCtrladd', function($scope,$stateParams, ListService, $state,$window, $rootScope, $location, $filter, $http, logger, $log, ngDialog, $modal, $stateParams, $timeout, validationService, toaster) {

        $scope.invoiceData = {
            invoiceNo : '',
            invoiceDate : '',
            company : 'C0002',
            salesOrderNo : '',
            customer : "",
            currency : '',
            exchangeRate : 0.0,
            manualInvoiceNo : '',
            dueDate : '',
            remarks : '',
            costCenter : '',
            salesOrderCode : '',
            ginId : '',
            amount : 0.0,
            tcamount : 0.0,
            productTotal : 0.0,
            productTotalWithoutTax : 0.0,
            chargeTotal : 0.0,
            grantamount : 0.0,
            //invoiceDetail : [{tax:'0'},{accountHeadCode:''},{shortDetail :''}],
            invoiceDetail : [],
            invoiceProdDetail : []
        };
        
        

        $scope.chargeList = [];
        $scope.taxList=[];
        $scope.companyList = [];
        $scope.customerList = [];
        $scope.currencyList = [];
        $scope.salesOrderList = [];
        $scope.ginList = [];
        $scope.itemList = [];
        $scope.isEdit = false;
        $scope.isSalesOrderNo = false;
        $scope.isGINNo = false;
        $scope.cancel = function() {
            //$location.path("/hospital/accounts/invoice/list");
        	 $state.go('app.finance.accounts.invoice.list');
        };
        
        
        
        $scope.$watch('invoiceData.invoiceDate', function(value, oldValue) {
            debugger
            if (value != '' && value != undefined) {
            var res = value.split("/");
            var formCode='F3817';
            $http.get('app/journalVoucher/getloggedcompany?closingDate='+value+'&formCode='+formCode).success(function(datas) {
            if(datas){
            logger.logError("Account closed for year "+ res[2]);
            $scope.invoiceData.invoiceDate = '';
            }
            })
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
            $scope.invoiceData.invoiceDate = $scope.date;
            $scope.invoiceData.currency = 'INR';
            $scope.invoiceData.exchangeRate = 1;
        }
        $scope.getCurrentDate();

        $scope.onChangeDecimal = function(id, num) {

            num = num.replace(/[^0-9/.]/g, 0);
            var floatnum = parseFloat(Math.round(num * 100) / 100).toFixed(2);
            $('#' + id).val(floatnum);
            return floatnum;
        }

        $scope.onChangeNumber = function(id, num) {

            num = num.replace(/[^0-9]/g, '');
            $('#' + id).val(num);
            return num;
        }

        $scope.$watch('invoiceData.dueDate', function(newValue, oldValue) {
            if (newValue != undefined && newValue != null && newValue != '') {
                var isValid = true;

                var todayDate = $scope.date;
                var issuedDate = $scope.invoiceData.invoiceDate;
                var toDate = newValue;
                toDate = toDate.split("/");
                toDate = new Date(toDate[2], toDate[1] - 1, toDate[0]);
                todayDate = todayDate.split("/");
                todayDate = new Date(todayDate[2], todayDate[1] - 1, todayDate[0]);
                issuedDate = issuedDate.split("/");
                issuedDate = new Date(issuedDate[2], issuedDate[1] - 1, issuedDate[0]);
                if (toDate < todayDate) {
                    isValid = false;
                    $scope.invoiceData.dueDate = "";
                }
                if (toDate < issuedDate) {
                    isValid = false;
                    $scope.invoiceData.dueDate = "";
                }
                if (isValid == false) {
                    logger.logError("Due date should be greater than the invoice date and current date");
                }
            }
        });
        
        $http.get($stateParams.tenantid+'/app/commonUtility/getCompanyList').success(function(datas) {
            $scope.companyList = datas;
        }).error(function(datas) {
        });
        
        
        $http.get('app/generalinvoice/getCustomertrue').success(function(data) {
        	$scope.customerList =data;
        }).error(function(data) {
            //customerList.reject("Failed to get Customer List");
        });
        $timeout(function() {
            $scope.onLoadDropdowns = function() {

              /*  $http.get($stateParams.tenantid+'app/commonUtility/getCompanyList').success(function(datas) {
                    $scope.companyList = datas;
                }).error(function(datas) {
                });
*/
                $http.get($stateParams.tenantid+'/app/commonUtility/getCostCenter').success(function(datas) {
                    $scope.costCenterList = datas;
                }).error(function(datas) {
                });

                $http.get($stateParams.tenantid+'/app/commonUtility/getEmployeeList').success(function(datas) {
                    $scope.employeeList = datas;
                }).error(function(datas) {
                });

                $http.get($stateParams.tenantid+'/app/commonUtility/getstudentList').success(function(datas) {
                    $scope.studentList = datas;
                }).error(function(datas) {
                });

                
                $http.get($stateParams.tenantid+'/app/commonUtility/getCostCenterList').success(function(datas) {
                    $scope.costCenterListnew = datas;
                }).error(function(datas) {
                });
                $scope.dataList = ListService.getCurrencyList();
                $scope.dataList.then(function(currencyLists) {
                    $scope.currencyList = currencyLists;
                });

             /*   $scope.dataList = ListService.getCustomerList();
                $scope.dataList.then(function(customerLists) {
                    $scope.customerList = customerLists;
                });
*/
                $scope.dataList = ListService.getAccountHeadList();
                $scope.dataList.then(function(AccountHeadLists) {
                    $scope.chargeList = AccountHeadLists;
                });

                $scope.dataList = ListService.getSalesOrderList();
                $scope.dataList.then(function(salesOrderList) {
                    $scope.salesOrderList = salesOrderList;
                });

                $scope.ginList = ListService.getginList();
                $scope.ginList.then(function(ginList) {
                    $scope.ginList = ginList;
                });

                $scope.dataList = ListService.getItemList();
                $scope.dataList.then(function(itemList) {
                    $scope.itemList = itemList;
                });
            };
            $scope.onLoadDropdowns();
        }, 2, false);

        $scope.taxList=[
            { id: '0', text: '0' },
              { id: '5', text: '5' },
              { id: '12', text: '12' },
              { id: '18', text: '18' },
              { id: '28', text: '28' }
            
        ]
        $scope.amountCalculation = function(localAmount) {
            var tcAmt = parseFloat(localAmount, 10) / parseFloat($scope.invoiceData.exchangeRate);
            $scope.invoiceData.tcamount = tcAmt.toFixed(2);
        }

        $scope.amountLocalCalculation = function(USDAmount) {
            var bcAmt = parseFloat(USDAmount, 10) * parseFloat($scope.invoiceData.exchangeRate);
            $scope.invoiceData.amount = bcAmt.toFixed(2);
        }

        /**
         * validation
         */
        $scope.validate = function(generalInvoiceForm, invoiceData) {
            if (new validationService().checkFormValidity($scope.generalInvoiceForm)) {

                angular.forEach($scope.invoiceData.invoiceDetail, function(key, index) {
                    delete key['isEmployee'];
                    delete key['isDepartment'];
                    delete key['isLocation'];
                    delete key['isCustomer'];
                    delete key['isSupplier'];
                    delete key['isDesignation'];
                    delete key['isCostCenter'];
                    delete key['isAsset'];
                    delete key['isCompany'];
                    delete key['attributeList'];
                    delete key['isInvoiceNo'];
                    delete key['countryCode'];
                    delete key['customerCode'];
                    delete key['supplierCode'];
                    delete key['designationCode'];
                    delete key['companyCode'];
                    delete key['assetCode'];

                    
                });
                $scope.invoiceData.amount = $scope.invoiceData.grantamount;
                $scope.invoiceData.tcamount = $scope.invoiceData.grantamount;
                if (!$scope.isEdit) {
                    if ($scope.invoiceData.amount > 0) {
                        $scope.save(generalInvoiceForm, invoiceData);
                    } else {
                        logger.logError('Amount in "Item List" table is Zero, Please Enter Unit Prince and Qty..!!');
                    }
                } else {
                    if ($scope.invoiceData.amount > 0) {

                        $scope.save(generalInvoiceForm, invoiceData);

                    } else {
                        logger.logError('Amount in "Item List" table is Zero, Please Enter Unit Prince and Qty..!!');
                    }
                }

            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.generalInvoiceForm.$validationSummary), 555000, 'trustedHtml');
            }
        };

        $scope.save = function(generalInvoiceForm, invoiceData) {
            if ($scope.isEdit == false) {
                if ($scope.invoiceData.grantamount > 0) {
                    $http.post('app/generalinvoice/save', $scope.invoiceData).success(function(data) {
                        if (data == true) {
                            logger.logSuccess("Created Successfully!");
                            $location.path($stateParams.tenantid +'/hospital/accounts/invoice/list');
                        } else {
                            logger.logError("Unable to Save");
                        }
                    }).error(function(data) {
                    });
                } else {
                    logger.logError("Grand Total is Zero, It's not allow to save");
                }

            } else {
                $http.post('app/generalinvoice/update', $scope.invoiceData).success(function(data) {
                    if (data == true) {
                        logger.logSuccess("Updated Successfully!");
                        $location.path($stateParams.tenantid +'/hospital/accounts/invoice/list');
                    } else {
                        logger.logError("Unable to Update");
                    }
                }).error(function(data) {
                });
            }
        };

        /**
         * load charge table
         */
        $scope.loadTable = function() {
            var table = {};
            table = {
                siNo : 1,
                subGrpCode : '',
                accountHeadCode : '',
                shortDetail : '',
                amount : '',
                
                tax : '0'
            };

            $scope.invoiceData.invoiceDetail.push(table);

        }
        $scope.loadTable();

        $scope.addRow = function(invoiceDetail) {
            var len = invoiceDetail.length;
            var table = {
                siNo : 1,
                subGrpCode : '',
                accountHeadCode : '',
                shortDetail : '',
                amount : '',
                tax : 0
            };
            table.siNo = len + 1;
            invoiceDetail.push(table);

        };

        $scope.removeRow = function(invoiceDetail) {
            $scope.tablerow = [];
            angular.forEach(invoiceDetail, function(row, index) {
                var check = row.select;
                if (check == undefined || check == "") {
                    $scope.tablerow.push(row);
                } else {

                }
            });
            $scope.invoiceData.invoiceDetail = $scope.tablerow;
            $scope.calculateChargeAmount($scope.invoiceData.invoiceDetail);
        };

        /**
         * load item/product table
         */
        $scope.loadProdTable = function() {
            var table = {};
            table = {
                siNo : 1,
                itemId : '',
                quantity : '',
                unitprice : '',
                taxAmount : 0,
                amount : '',
                tax : 0

            };

            $scope.invoiceData.invoiceProdDetail.push(table);

        }

        $scope.loadProdTable();

        $scope.addProdRow = function(invoiceProdDetail) {
            var len = invoiceProdDetail.length;
            var table = {
                siNo : 1,
                itemId : '',
                quantity : '',
                unitprice : '',
                taxAmount : 0,
                amount : '',
                    tax : 0
            };
            table.siNo = len + 1;
            invoiceProdDetail.push(table);

        };

        $scope.removeProdRow = function(invoiceProdDetail) {
            $scope.tableProdrow = [];
            angular.forEach(invoiceProdDetail, function(row, index) {
                var check = row.select;
                if (check == undefined || check == "") {
                    $scope.tableProdrow.push(row);
                } else {

                }
            });
            $scope.invoiceData.invoiceProdDetail = $scope.tableProdrow;
            $scope.calculateProductAmount($scope.invoiceData.invoiceProdDetail);
        };

        /**
         * calculate charge amount
         */
        $scope.calculateChargeAmount = function(invoiceDetail) {
            var chargeTotal = 0.0;
            angular.forEach(invoiceDetail, function(row, index) {
                chargeTotal = chargeTotal + parseFloat(row.amount);
            });

            $scope.invoiceData.chargeTotal = chargeTotal;

            $scope.calculateTotalAmount();
        };

        /**
         * calculate product amount
         */
        $scope.calculateProductAmount = function(invoiceProductDetail) {
            var productTotal = 0.0, taxTotal = 0.0;
            angular.forEach(invoiceProductDetail, function(row, index) {

                if (row.quantity == "")
                    row.quantity = 0;
                if (row.unitprice == "")
                    row.unitprice = 0;
                if (row.taxAmount == 0)
                    row.taxAmount = 0;

                var amt = parseInt(row.quantity) * parseFloat(row.unitprice);
                row.amount = amt + parseFloat(row.taxAmount);
                productTotal = productTotal + row.amount;

            });
            $scope.invoiceData.productTotal = productTotal;
            $scope.calculateTotalAmount();
        };

        $scope.calculateTotalAmount = function() {
            $scope.invoiceData.grantamount = $scope.invoiceData.productTotal + $scope.invoiceData.chargeTotal;
        };

        $scope.loadSalesOrderNoDetails = function() {
            $scope.$watch('invoiceData.salesOrderNo', function(newValue, oldValue) {
                if (newValue != '' && newValue != undefined) {
                    $http.get('app/generalinvoice/getSODetail?soNo=' + newValue).success(function(data) {

                        if (!$scope.isEdit) {
                            $scope.invoiceData.customer = data.customer;
                            $scope.invoiceData.company = data.company;
                            if (data.invoiceProdDetail.length > 0) {
                                $scope.invoiceData.invoiceProdDetail = [];
                                if (data.invoiceProdDetail.length > 0) {
                                    angular.forEach(data.invoiceProdDetail, function(row, index) {
                                        var length = $scope.invoiceData.invoiceProdDetail.length;
                                        row.siNo = index + 1;
                                        row.itemId = (row.itemId).toString();
                                        $scope.invoiceData.invoiceProdDetail.push(row);
                                    });

                                    $scope.calculateProductAmount($scope.invoiceData.invoiceProdDetail);
                                }
                            }
                            $scope.isSalesOrderNo = true;
                        }

                    }).error(function(datas) {
                    });
                } else {
                    $scope.isSalesOrderNo = false;
                    $scope.invoiceData.invoiceProdDetail = [];
                    $scope.invoiceData.customer = '';
                    $scope.loadProdTable();
                }
            });
        }

        /**
         * isNan Check...
         */

        $scope.isNaNCheck = function(value) {
            if (isNaN(value)) {
                value = 0;
            }
            return value;
        }

        $scope.calculateTaxValue = function(taxId, quantity, unitPrice, row) {

            if (taxId != undefined && taxId != null && taxId != "" && taxId != 0) {

                $http.get("hospital/purchase/quotation/getTaxDetails?taxId=" + taxId).success(function(response) {

                    $scope.taxPercentage = 0;
                    $scope.taxAmount = 0;
                    $scope.taxAmt = 0;
                    $scope.subTaxPercentage = 0;
                    $scope.subTaxAmount = 0;

                    $scope.taxType = 0;
                    $scope.subTaxTypeAmt = 0;
                    $scope.subTaxTypePercent = 0;

                    $scope.unitPrice = $scope.isNaNCheck(unitPrice);
                    $scope.quantity = $scope.isNaNCheck(quantity);

                    if (response.purchaseQuotationDetail.taxType == "Percentage") {

                        $scope.taxPercentage = $scope.isNaNCheck(parseFloat(response.purchaseQuotationDetail.taxPercentage));
                        $scope.taxType = response.purchaseQuotationDetail.taxType;
                    } else if (response.purchaseQuotationDetail.taxType == "Fixed Amount") {
                        $scope.taxAmount = parseFloat(response.purchaseQuotationDetail.taxAmount);
                        $scope.taxType = response.purchaseQuotationDetail.taxType;
                    }

                    angular.forEach(response.purchaseQuotationDetail.subTaxList, function(key, index) {

                        if (key.subTaxType == "Percentage") {
                            $scope.subTaxPercentage = $scope.isNaNCheck(parseFloat(key.subTaxPercentage));
                            $scope.subTaxTypePercent = key.subTaxType;
                        }
                        if (key.subTaxType == "Fixed Amount") {
                            $scope.subTaxAmount = $scope.isNaNCheck(parseFloat(key.subTaxAmount));
                            $scope.subTaxTypeAmt = key.subTaxType;
                        }
                    });

                    $scope.subTaxAmount = $scope.subTaxAmount.toFixed(2);

                    $scope.amount = (parseFloat($scope.unitPrice) * parseFloat($scope.quantity)).toFixed(2);

                    var totalTaxPercentage = (parseFloat($scope.taxPercentage)) + (parseFloat($scope.subTaxPercentage));
                    if ($scope.taxPercentage != "" || $scope.taxPercentage != 0) {

                        // tax_percentage
                        if ($scope.taxType == 'Percentage') { // tax Type
                            if ($scope.subTaxTypePercent == 'Percentage') {
                                // sub Tax Type
                                $scope.taxAmt = (parseFloat($scope.amount) * (totalTaxPercentage / 100)).toFixed(2);
                            }
                            if ($scope.subTaxTypeAmt == "Fixed Amount") { // sub
                                // Tax
                                // Type

                                var taxPercentAmt = (parseFloat($scope.amount) * (totalTaxPercentage / 100)).toFixed(2);

                                $scope.taxAmt = (parseFloat(taxPercentAmt) + parseFloat($scope.subTaxAmount)).toFixed(2);
                            }
                            if (($scope.subTaxTypePercent == '' || $scope.subTaxTypePercent == null || $scope.subTaxTypePercent == undefined || $scope.subTaxTypePercent == " ") && ($scope.subTaxTypeAmt == '' || $scope.subTaxTypeAmt == undefined || $scope.subTaxTypeAmt == null || $scope.subTaxTypeAmt == " ")) {

                                $scope.taxAmt = ((parseFloat($scope.amount)) * parseFloat($scope.taxPercentage / 100)).toFixed(2);
                            }
                        }
                    }
                    // Tax Details - Tax Amount
                    if ($scope.taxAmount != "" || $scope.taxAmount != 0) { // tax_amount
                        if ($scope.taxType == "Fixed Amount") { // tax type
                            if ($scope.subTaxTypePercent == 'Percentage') { // sub
                                // Tax
                                // Type
                                var totalSubTaxPercentAmt = parseFloat($scope.amount) * (totalTaxPercentage / 100);
                                $scope.taxAmt = (parseFloat($scope.taxAmount) + parseFloat(totalSubTaxPercentAmt)).toFixed(2);
                            }
                            if ($scope.subTaxTypeAmt == "Fixed Amount") {
                                // sub Tax Type
                                var totalTaxAmt = parseFloat($scope.taxAmount) + parseFloat($scope.subTaxAmount);
                                $scope.taxAmt = parseFloat(totalTaxAmt).toFixed(2);
                            }
                            if (($scope.subTaxTypePercent == '' || $scope.subTaxTypePercent == null || $scope.subTaxTypePercent == undefined || $scope.subTaxTypePercent == " ") && ($scope.subTaxTypeAmt == '' || $scope.subTaxTypeAmt == undefined || $scope.subTaxTypeAmt == null || $scope.subTaxTypeAmt == " ")) {
                                $scope.taxAmt = parseFloat($scope.taxAmount).toFixed(2);
                            }
                        }
                    }

                    $scope.taxAmt = $scope.isNaNCheck(parseFloat($scope.taxAmt).toFixed(2));
                    row.taxAmount = $scope.taxAmt;
                    $scope.calculateProductAmount($scope.invoiceData.invoiceProdDetail);

                });
            }

        }

        $scope.loadginDetails = function() {
            $scope.$watch('invoiceData.ginId', function(newValue, oldValue) {
                if (newValue != '' && newValue != undefined) {
                    $http.get('app/generalinvoice/getGinDetailList?ginId=' + newValue).success(function(data) {

                        if (!$scope.isEdit) {
                            if (data.customer != undefined && data.customer != null && data.customer != '') {
                                $scope.invoiceData.customer = data.customer;
                            }
                            $scope.invoiceData.company = data.company;
                            if (data.invoiceProdDetail.length > 0) {
                                $scope.invoiceData.invoiceProdDetail = [];
                                if (data.invoiceProdDetail.length > 0) {
                                    angular.forEach(data.invoiceProdDetail, function(row, index) {
                                        if (row.soDtlId > 0) {
                                            var length = $scope.invoiceData.invoiceProdDetail.length;
                                            row.siNo = index + 1;
                                            row.itemId = (row.itemId).toString();
                                            $scope.invoiceData.invoiceProdDetail.push(row);
                                            $scope.calculateProductAmount($scope.invoiceData.invoiceProdDetail);
                                        } else {
                                            $scope.calculateTaxValue(row.taxId, row.quantity, row.unitprice, row);
                                            var length = $scope.invoiceData.invoiceProdDetail.length;
                                            row.siNo = index + 1;
                                            row.itemId = (row.itemId).toString();
                                            $scope.invoiceData.invoiceProdDetail.push(row);
                                        }

                                    });
                                    if (data.customerPaymentTerms != undefined && data.customerPaymentTerms != '' && data.customerPaymentTerms != null) {
                                        var toDate = $scope.date;
                                        toDate = toDate.split("/");
                                        toDate = new Date(toDate[2], toDate[1] - 1, toDate[0]);
                                        var newdate = new Date(toDate);
                                        newdate.setDate(newdate.getDate() + data.customerPaymentTerms);
                                        var dd = newdate.getDate();
                                        var mm = newdate.getMonth() + 1;
                                        var y = newdate.getFullYear();
                                        if (dd < 10) {
                                            dd = '0' + dd;
                                        }
                                        if (mm < 10) {
                                            mm = '0' + mm;
                                        }
                                        var someFormattedDate = dd + '/' + mm + '/' + y;
                                        $scope.invoiceData.dueDate = someFormattedDate;

                                    } else {
                                        $scope.invoiceData.dueDate = $scope.date;
                                    }

                                }
                            }
                            $scope.isSalesOrderNo = true;
                            $scope.isGINNo = true;
                        }

                    }).error(function(datas) {
                    });
                } else {
                    $scope.isSalesOrderNo = false;
                    $scope.isGINNo = true;
                    $scope.invoiceData.invoiceProdDetail = [];
                    $scope.loadProdTable();
                }
            });
        }

        $scope.$watch('invoiceData.customer', function(newValue, oldValue) {
            if (newValue != undefined && newValue != null && newValue != '') {
                var customerPaymentTerms = '';
                angular.forEach($scope.customerList, function(row, index) {
                    if (row.id == newValue) {
                        customerPaymentTerms = row.customerPaymentTerms;
                    }
                });
                if (customerPaymentTerms != undefined && customerPaymentTerms != '' && customerPaymentTerms != null) {
                    var toDate = $scope.date;
                    toDate = toDate.split("/");
                    toDate = new Date(toDate[2], toDate[1] - 1, toDate[0]);
                    var newdate = new Date(toDate);
                    newdate.setDate(newdate.getDate() + customerPaymentTerms);
                    var dd = newdate.getDate();
                    var mm = newdate.getMonth() + 1;
                    var y = newdate.getFullYear();
                    if (dd < 10) {
                        dd = '0' + dd;
                    }
                    if (mm < 10) {
                        mm = '0' + mm;
                    }
                    var someFormattedDate = dd + '/' + mm + '/' + y;
                    $scope.invoiceData.dueDate = someFormattedDate;

                } else {
                    $scope.invoiceData.dueDate = $scope.date;
                }

            }
        });

        /**
         * get dropdown values
         */
        // Top find which object Property is Updated
        var invoiceDataObj = angular.copy($scope.invoiceData, invoiceDataObj);
        var arrayOfValues = Object.keys(invoiceDataObj);
        $scope.checkWhichVariableHasUpdated = function(watchGroupList, newValuesObj, oldValuesObj) {
            var _lastUpdatedValue = null;
            angular.forEach(watchGroupList, function(value) {
                if (newValuesObj[value] != oldValuesObj[value])
                    _lastUpdatedValue = value;
            });
            $scope.selectedObj = newValuesObj;
            return _lastUpdatedValue;
        };

        // To load Dependent DropDown
        $scope.loadDropDown = function(changedVariable) {
            switch (changedVariable) {
            case "ginId":
                $scope.loadginDetails();
                break;
            }
        };

        // To watch a Object Collection
        $scope.$watchCollection('invoiceData', function(newVal, oldVal) {
            if (newVal != undefined) {
                var last_changed = $scope.checkWhichVariableHasUpdated(arrayOfValues, newVal, oldVal);
                if (angular.isDefined(last_changed) && last_changed != null) {
                    $scope.loadDropDown(last_changed);
                }
            }
        }, true);

        /**
         * Edit functionality *********************
         */
        var InvoiceNo = $stateParams.invoiceNo;
        if (InvoiceNo == undefined || InvoiceNo == null || InvoiceNo == "") {

        } else {
            $scope.isEdit = true;
            $http.get('app/generalinvoice/getInvoiceDetail?InvoiceNo=' + InvoiceNo).success(function(data) {

                $scope.salesOrderList = data.salesOrderList;
                angular.forEach(data.invoiceProdDetail, function(row, index) {
                    row.itemId = (row.itemId).toString();

                    row = row;
                });

                $scope.invoiceData = data;
                
                
                angular.forEach($scope.invoiceData.invoiceDetail, function(row, index) {

                    if(row.costCenter != null  && row.costCenter != "" && row.costCenter != undefined)
                        $scope.invoiceData.invoiceDetail[index].costCenter = parseInt(row.costCenter);
                });
                $scope.invoiceData.salesOrderNo = data.salesOrderNo;
                $scope.invoiceData.ginId = data.ginId;
                $scope.invoiceData.ginCode = data.ginCode;
                   if(data.invoiceProdDetail.length > 0){
                if(data.invoiceProdDetail[0].costCenter != null  && data.invoiceProdDetail[0].costCenter != "" && data.invoiceProdDetail[0].costCenter != undefined)
                $scope.invoiceData.costCenter = data.invoiceProdDetail[0].costCenter;
            }
                $scope.calculateChargeAmount($scope.invoiceData.invoiceDetail);
                $scope.calculateProductAmount($scope.invoiceData.invoiceProdDetail);

                if ($scope.invoiceData.salesOrderNo > 0) {
                    $scope.isSalesOrderNo = true;
                    $scope.isGINNo = true;
                } else {
                    $scope.isSalesOrderNo = false;
                    $scope.isGINNo = false;
                }

            }).error(function(data) {
            });

        }
    });

    app.controller('parentCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {
        $scope.$watch('invoiceData.invoiceProdDetail[trIndex].itemId', function(newValue, oldValue) {
            if (newValue != undefined && newValue != null && newValue != '') {
                var length = $scope.invoiceData.invoiceProdDetail.length;
                for (var i = 0; i < length; i++) {
                    for (var j = 0; j < length; j++) {
                        if (i != j) {
                            if ($scope.invoiceData.invoiceProdDetail[i].itemId != undefined && $scope.invoiceData.invoiceProdDetail[i].itemId != null && $scope.invoiceData.invoiceProdDetail[i].itemId != '' && $scope.invoiceData.invoiceProdDetail[j].itemId != undefined && $scope.invoiceData.invoiceProdDetail[j].itemId != null && $scope.invoiceData.invoiceProdDetail[j].itemId != '') {
                                if ($scope.invoiceData.invoiceProdDetail[i].itemId == $scope.invoiceData.invoiceProdDetail[j].itemId) {
                                    logger.logError("Item Code-Item Name already added");
                                    $scope.invoiceData.invoiceProdDetail[$scope.$index].itemId = '';
                                    return false;
                                }
                            }

                        }
                    }
                }

            }
        });

    });

    app.service("ListService", function($http, $q) {

        this.getCustomerList = function() {

            var customerList = $q.defer();
            $http.get('app/generalinvoice/getCustomertrue').success(function(data) {
                customerList.resolve(data);
            }).error(function(data) {
                customerList.reject("Failed to get Customer List");
            });
            return customerList.promise;
        }

        this.getCurrencyList = function() {

            var currencyList = $q.defer();
            $http.get('app/generalinvoice/getCurrencyList').success(function(data) {

                currencyList.resolve(data);

            }).error(function(data) {

                currencyList.reject("Failed to get Currency List");

            });
            return currencyList.promise;
        }

        this.getMloList = function(customerCode) {
            var mloList = $q.defer();
            $http.get('app/generalinvoice/getMloList?CustomerCode=' + customerCode).success(function(data) {
                mloList.resolve(data);

            }).error(function(data) {

                mloList.reject("Failed to get Mlo List");

            });
            return mloList.promise;
        }

        this.getSubAccountList = function() {
            var subAccountList = $q.defer();
            $http.get($stateParams.tenantid +'/app/commonUtility/getSubAccountCodeLists').success(function(datas) {
                subAccountList.resolve(datas.commonUtilityBean);
            }).error(function(data) {
                subAccountList.reject("Failed to get Sub Account Code List");
            });
            return subAccountList.promise;
        }

        this.getAccountHeadList = function() {
            var accountHeadList = $q.defer();
            $http.get('app/generalinvoice/getAccountHeadList').success(function(data) {
                accountHeadList.resolve(data);
            }).error(function(data) {
                accountHeadList.reject("Failed to get Account head List");
            });
            return accountHeadList.promise;
        }

        this.getSalesOrderList = function() {
            var salesOrderList = $q.defer();
            $http.get('app/generalinvoice/getSalesOrderList').success(function(data) {
                salesOrderList.resolve(data);
            }).error(function(data) {
                salesOrderList.reject("Failed to get Sales Order List");
            });
            return salesOrderList.promise;
        }

        this.getginList = function() {
            var ginList = $q.defer();
            $http.get('app/generalinvoice/getGinList').success(function(data) {
                ginList.resolve(data);
            }).error(function(data) {
                ginList.reject("Failed to get Sales Order List");
            });
            return ginList.promise;
        }

        this.getItemList = function() {
            var ItemList = $q.defer();
            $http.get('app/generalinvoice/getItemList').success(function(data) {
                ItemList.resolve(data);
            }).error(function(data) {
                ItemList.reject("Failed to get Item List");
            });
            return ItemList.promise;
        }

        this.getDateInDDMMYYYY = function convert(str) {
            var date = new Date(str), mnth = ("0" + (date.getMonth() + 1)).slice(-2), day = ("0" + date.getDate()).slice(-2);
            return [ day, mnth, date.getFullYear() ].join("-");
        }
    });
    


//    module.registerController('tableCtrl', function($scope, $http, $filter, logger) {
    app.controller('tableCtrlnew', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {

        $scope.isSub = true;
        $scope.$watch('invoiceData.invoiceDetail[trIndex].accountHeadCode', function(newValue, oldValue) {
            if (newValue != '' && newValue != undefined) {
                var type = '';

                if (newValue == '20080001')
                    type = "payment"
                else if (newValue == '10060001')
                    type = "receipt"
                else if (newValue == '10040006')
                    type = "employee"

                if (type == "payment" || type == "receipt" || type == "employee") {
                    $scope.isSub = false;

                    $http.get($stateParams.tenantid +'/app/commonUtility/getSubAccountCodeListNew?type=' + type).success(function(datas) {

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
                } else {
                    $scope.subAccountCodeList = [];
                    $scope.isSub = true;
                }

                $http.get($stateParams.tenantid +'/app/commonUtility/getAttributesList?accountCode=' + newValue).success(function(datas) {
                    $scope.invoiceData.invoiceDetail[$scope.$index].attributeList = datas;
                    if (newValue == oldValue) {
                        $scope.isOnChange = false;
                    } else {
                        $scope.isOnChange = true;
                    }
                    if (!$scope.isEdit || $scope.isOnChange) {

                        $scope.invoiceData.invoiceDetail[$scope.$index].employeeCode = '';
                        $scope.invoiceData.invoiceDetail[$scope.$index].departmentCode = '';
                        $scope.invoiceData.invoiceDetail[$scope.$index].countryCode = '';
                        $scope.invoiceData.invoiceDetail[$scope.$index].customerCode = '';
                        $scope.invoiceData.invoiceDetail[$scope.$index].supplierCode = '';
                        $scope.invoiceData.invoiceDetail[$scope.$index].designationCode = '';
                        $scope.invoiceData.invoiceDetail[$scope.$index].costCenter = '';
                        $scope.invoiceData.invoiceDetail[$scope.$index].companyCode = '';
                        $scope.invoiceData.invoiceDetail[$scope.$index].assetCode = '';
                    }

                    $scope.invoiceData.invoiceDetail[$scope.$index].isEmployee = false;

                    $scope.invoiceData.invoiceDetail[$scope.$index].isDepartment = false;

                    $scope.invoiceData.invoiceDetail[$scope.$index].isLocation = false;
                    $scope.invoiceData.invoiceDetail[$scope.$index].isCustomer = false;
                    $scope.invoiceData.invoiceDetail[$scope.$index].isSupplier = false;
                    $scope.invoiceData.invoiceDetail[$scope.$index].isDesignation = false;
                    $scope.invoiceData.invoiceDetail[$scope.$index].isCostCenter = false;
                    $scope.invoiceData.invoiceDetail[$scope.$index].isCompany = false;

                    $scope.invoiceData.invoiceDetail[$scope.$index].isAsset = false;

                    angular.forEach($scope.invoiceData.invoiceDetail[$scope.$index].attributeList, function(row, rowindex) {
                        if (row.attributeName == "Employee") {
                            $scope.invoiceData.invoiceDetail[$scope.$index].isEmployee = true;
                        } else if (row.attributeName == "Students") {
                            $scope.invoiceData.invoiceDetail[$scope.$index].isDepartment = true;
                        } else if (row.attributeName == "Location") {
                            $scope.invoiceData.invoiceDetail[$scope.$index].isLocation = true;
                        } else if (row.attributeName == "Customer") {
                            $scope.invoiceData.invoiceDetail[$scope.$index].isCustomer = true;
                        } else if (row.attributeName == "Supplier") {
                            $scope.invoiceData.invoiceDetail[$scope.$index].isSupplier = true;
                        } else if (row.attributeName == "Designation") {
                            $scope.invoiceData.invoiceDetail[$scope.$index].isDesignation = true;
                        } else if (row.attributeName == "Cost Center") {
                            $scope.invoiceData.invoiceDetail[$scope.$index].isCostCenter = true;
                        } else if (row.attributeName == "Company") {
                            $scope.invoiceData.invoiceDetail[$scope.$index].isCompany = true;
                        } else if (row.attributeName == "Asset") {
                            $scope.invoiceData.invoiceDetail[$scope.$index].isAsset = true;
                        }
                    });
                }).error(function(datas) {
                });

            }
        });

    });
//});
