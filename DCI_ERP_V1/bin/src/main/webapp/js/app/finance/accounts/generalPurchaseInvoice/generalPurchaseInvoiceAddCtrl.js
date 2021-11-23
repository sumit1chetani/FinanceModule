//define([ 'hospital/accounts/accounts' ], function(module) {

    //'use strict';
    app.controller('generalPurchaseInvoiceAddCtrl', function($scope, $state,$stateParams, $rootScope,$stateParams, $filter, sharedProperties, logger, $http, $location, $stateParams, validationService, toaster) {

        var today = new Date();
        var dd = String(today.getDate()).padStart(2, '0');
        var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
        var yyyy = today.getFullYear();

        today = dd + '/' + mm + '/' + yyyy;

        $scope.purchaseInvoiceData = {
            puchaseInvoiceNo : '',
            puchaseInvoiceDate : '',
            company : 'C0002',
            prodDtlId : '',
            companyCode : '',

            accountHeadCode : '',
            grnNo : '',
            supplier : '',
            currency : "INR",
            exchangeRate : 0.0,
            partyInvoiceNo : '',
            partyInvoiceDate : '',
            dueDate : '',
            description : '',
            wonumber : '',
            costCenter : '',
            amount : 0.0,
            tcamount : 0.0,
            bcamount : 0.0,
            productTotal : 0.0,
            chargeTotal : 0.0,
            ahTotal : 0.0,
            grantamount : 0.0,
            departmentCode : '',
            countryCode : '',
            customerCode : '',
            supplierCode : '',
            designationCode : '',
            companyCode : '',
            assetCode : '',
            patientCode : '',
            purInvoiceNo : '',
            costCenter : '',
            acctHeadCode : '',
            subAccountName : '',
            accountHeadName : '',
            wotype : '',
            budgetType : '',
            taxAccountList : [],
            purchaseInvoiceDetail : [],
            purchaseAHInvoiceDetail : [],
            purchaseInvoiceProdDetail : [],
            invoiceDueDate : '',
            nonPo : ''

        };
        $scope.purchaseInvoiceData.company = "C0002";


        $scope.quotationDetail = {
            taxId : '',
            taxIdslist : [],
            taxTypeId : '',
            taxType : '',
            taxCode : '',
            taxName : '',
            subTaxTypeId : '',
            subTaxType : '',
            subTaxTypePercent : '',
            subTaxTypeAmt : '',
            discountTypeId : '',
            discountType : '',
            percentage : '',
            amount : '',
            disAmt : 0,
            taxAmt : 0,
            deliveryLeadTime : '',
            taxPercentage : 0,
            taxAmount : 0,
            subTaxPercentage : 0,
            subTaxAmount : 0,
            rowSubTotal : 0,
            discountAmount : '',
            discountPercent : ''

        }

        $scope.isGRNNo = false;

        $scope.isCurrency = true;
        $scope.chargeList = [];
        $scope.companyList = [];
        $scope.supplierList = [];
        $scope.grnList = [];
        $scope.wonumberist = [];
        $scope.costList = [];
        $scope.currencyList = [];
        $scope.itemList = [];
        $scope.budgetTypeList = [];

        $scope.frieghtAmount = 0;
        $scope.poTotalAmount = 0;
        $scope.isEdit = false;

        $scope.nonPOflag = true;
        $scope.nonPO = function(flag) {
            if (flag)
                $scope.nonPOflag = false;
            else
                $scope.nonPOflag = true;
        }

        //DATE VALIDATION

        var currentDate = new Date();
        currentDate = ('0' + currentDate.getDate()).slice(-2) + "/" + ('0' + (Number(currentDate.getMonth()) + 1)).slice(-2) + "/" + currentDate.getFullYear();
        $scope.purchaseInvoiceData.puchaseInvoiceDate = currentDate;

        $scope.$watch("purchaseInvoiceData.puchaseInvoiceDate", function(newValue, oldValue) {
            if (!$scope.isEdit) {

                var date = $scope.purchaseInvoiceData.puchaseInvoiceDate;
                var currentDate1 = new Date();
                var date1 = new Date(currentDate1);
                date1.setDate(date1.getDate() - 3);
                // document.write(date1);
                // alert(date1);
                var PickedDate = newValue.split("/");
                var PickedDate1 = new Date(+PickedDate[2], PickedDate[1] - 1, +PickedDate[0]);
                var date2 = new Date(newValue);
                date2.setDate(date2.getDate());
                //             

                if (PickedDate1 < date1) {
                    logger.logError("Purchase Invoice Date allow only Two days before !!");
                    var currentDate = new Date();
                    currentDate = ('0' + currentDate.getDate()).slice(-2) + "/" + ('0' + (Number(currentDate.getMonth()) + 1)).slice(-2) + "/" + currentDate.getFullYear();

                    $scope.purchaseInvoiceData.puchaseInvoiceDate = currentDate;
                }

                /*  if(PickedDate1 > date1) {
                      logger.logError("Purchase Invoice Date Should not allowed future date !!");
                      $scope.purchaseInvoiceData.puchaseInvoiceDate = '';
                  }*/
            }
        });

        $scope.$watch('purchaseInvoiceData.puchaseInvoiceDate', function(newValue, oldValue) {
            if (newValue != undefined && newValue != null && newValue != '') {
                var isValid = true;

                var todayDate = $scope.date;
                var issuedDate = $scope.purchaseInvoiceData.puchaseInvoiceDate;
                var toDate = newValue;
                toDate = toDate.split("/");
                toDate = new Date(toDate[2], toDate[1] - 1, toDate[0]);
                todayDate = todayDate.split("/");
                todayDate = new Date(todayDate[2], todayDate[1] - 1, todayDate[0]);
                issuedDate = issuedDate.split("/");
                issuedDate = new Date(issuedDate[2], issuedDate[1] - 1, issuedDate[0]);
                if (toDate > todayDate) {
                    isValid = false;
                    $scope.purchaseInvoiceData.puchaseInvoiceDate = "";
                }
                if (toDate > issuedDate) {
                    isValid = false;
                    $scope.purchaseInvoiceData.puchaseInvoiceDate = "";
                }
                if (isValid == false) {
                    logger.logError("Purchase Invoice Date Should not allow future date");
                }
            }
        });

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
            $scope.purchaseInvoiceData.puchaseInvoiceDate = $scope.date;
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

        $http.get("app/generalpurchaseinvoice/getWoList").success(function(datas) {
            $scope.wonumberist = datas;
        });

        /*$http.get("app/generalpurchaseinvoice/getCostCenterList").success(function(datas) {
            $scope.costList = datas;
        });*/

        var today = new Date();
        var dd = today.getDate();
        var mm = today.getMonth() + 1; // January is 0!
        var yyyy = today.getFullYear();

        if (dd < 10) {
            dd = '0' + dd;
        }
        if (mm < 10) {
            mm = '0' + mm;
        }

        var today = dd + '/' + mm + '/' + yyyy;
        $scope.date = today;

        if (!$scope.edit) {
            $scope.purchaseInvoiceData.dueDate = $scope.date;
        }

        $scope.chkAll = false;
        $scope.checkAll = function(purchaseInvoiceProdDetail, checkBox) {
            if (checkBox) {
                $scope.chkAll = true;
            } else {
                $scope.chkAll = false;
            }

            angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceProdDetail, function(purchase) {
                purchase.select = $scope.chkAll;
            });

        };

        /**
         * fetch Current Date into PQ Date, Valid From Date
         */
        $scope.getCurrentDate = function() {
            if ($scope.edit == false) {
                $scope.date = '';

                var today = new Date();
                var dd = today.getDate();
                var mm = today.getMonth() + 1; // January is 0!
                var yyyy = today.getFullYear();

                if (dd < 10) {
                    dd = '0' + dd;
                }
                if (mm < 10) {
                    mm = '0' + mm;
                }

                var today = dd + '/' + mm + '/' + yyyy;
                $scope.date = today;
                $scope.purchaseInvoiceData.invoiceDueDate = $scope.date;
            }
        }

        $scope.getCurrentDate();
        $scope.currencyList = [];

        $http.get("hrms/master/country/currencylist").success(function(datas) {
            $scope.currencyList = datas.currencyList;
        });

        //        $http.get('app/purchaseOrder/BudgetTypeList').success(function(datas) {
        //            $scope.budgetTypeList = datas;
        //        });
        $scope.getExchangeRate = function(currencyCode) {
            $http.post('app/purchaseinvoice/getExchangeRates', currencyCode).success(function(datas) {
                if (datas.exchangeRatelist.length > 0) {
                    $scope.purchaseInvoiceData.exchangeRate = datas.exchangeRatelist[0].exchangeRate;
                    $scope.purchaseInvoiceData.tcamount = Number($scope.purchaseInvoiceData.bcamount) * Number($scope.purchaseInvoiceData.exchangeRate);
                    $scope.purchaseInvoiceData.tcamount = $scope.purchaseInvoiceData.tcamount.toFixed(2);
                } else {
                    $scope.purchaseInvoiceData.exchangeRate = 1;
                    $scope.purchaseInvoiceData.tcamount = 0;
                }

            })
        }

        $scope.$watch('purchaseInvoiceData.currency', function(newValue, oldValue) {

            if (newValue != null && newValue != undefined && newValue != '') {
                if ($scope.purchaseInvoiceData.bcamount > 0) {
                    $scope.getExchangeRate(newValue);
                } else {
                    $scope.purchaseInvoiceData.exchangeRate = 1;
                    //                    $scope.purchaseInvoiceData.tcamount = 0;
                }
            }

        });

        /* 
          $scope.budgetType = false;
          $scope.$watch("purchaseInvoiceData.wotype", function(newValue, oldValue) {
              
            var woType =   $scope.purchaseInvoiceData.wotype ;
            
            if (woType == "Capex PO") {
                $scope.budgetType = true;
                var flag = 'C';
                $http.get('app/generalpurchaseinvoice/BudgetTypeList?wotype=' + flag).success(function(datas) {
                    $scope.budgetTypeList = datas;
                });

            } else if (woType == "Revex PO") {
                $scope.budgetType = true;
                var flag = 'R';
                $http.get('app/generalpurchaseinvoice/BudgetTypeList?wotype=' + flag).success(function(datas) {
                    $scope.budgetTypeList = datas;
                });
            }

        });*/

        /*        if(woType == "Capex WO") {
         $scope.budgetType = true;
        
         }else {
         $scope.budgetType = false;
        
         }
        
         });*/

        /*$scope.$watch('purchaseInvoiceData.dueDate', function(newValue, oldValue) {
            if (newValue != undefined && newValue != null && newValue != '') {
                var isValid = true;

                var todayDate = $scope.date;
                var issuedDate = $scope.purchaseInvoiceData.puchaseInvoiceDate;
                var toDate = newValue;
                toDate = toDate.split("/");
                toDate = new Date(toDate[2], toDate[1] - 1, toDate[0]);
                todayDate = todayDate.split("/");
                todayDate = new Date(todayDate[2], todayDate[1] - 1, todayDate[0]);
                issuedDate = issuedDate.split("/");
                issuedDate = new Date(issuedDate[2], issuedDate[1] - 1, issuedDate[0]);
                if (toDate < todayDate) {
                    isValid = false;
                    $scope.purchaseInvoiceData.dueDate = "";
                }
                if (toDate < issuedDate) {
                    isValid = false;
                    $scope.purchaseInvoiceData.dueDate = "";
                }
                if (isValid == false) {
                    logger.logError("Due date should be greater than the invoice date and current date");
                }
            }
        });*/

        $scope.$watch('purchaseInvoiceData.dueDate', function(newValue, oldValue) {
            if ($scope.edit == false) {

                if (newValue != undefined && newValue != null && newValue != '') {
                    var isValid = true;

                    var todayDate = $scope.date;
                    var issuedDate = $scope.purchaseInvoiceData.invoiceDueDate;
                    var toDate = newValue;
                    toDate = toDate.split("/");
                    toDate = new Date(toDate[2], toDate[1] - 1, toDate[0]);
                    todayDate = todayDate.split("/");
                    todayDate = new Date(todayDate[2], todayDate[1] - 1, todayDate[0]);
                    issuedDate = issuedDate.split("/");
                    issuedDate = new Date(issuedDate[2], issuedDate[1] - 1, issuedDate[0]);
                    if (toDate < todayDate) {
                        isValid = false;
                        $scope.purchaseInvoiceData.dueDate = "";
                    }
                    if (toDate < issuedDate) {
                        isValid = false;
                        $scope.purchaseInvoiceData.dueDate = "";
                    }
                    if (isValid == false) {
                        logger.logError("Due date should be greater than the invoice date and current date");
                    }
                }
            }
        });

        /**
         * validate ***********************
         */
        $scope.validate = function(purchaseInvoiceForm, purchaseInvoiceData) {
            
            angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceProdDetail, function(key, index) {
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
            });
            
            
            
            if (new validationService().checkFormValidity($scope.purchaseInvoiceForm)) {
                if (!$scope.edit) {
                    if ($scope.isNaNCheck($scope.purchaseInvoiceData.productwithTaxTotal) > 0) {
                        $scope.save(purchaseInvoiceForm, purchaseInvoiceData);
                    } else {
                        logger.logError('Total Should be greater than zero');
                    }
                } else {
                    if ($scope.purchaseInvoiceData.productwithTaxTotal > 0) {
                        $scope.update(purchaseInvoiceForm, purchaseInvoiceData);
                    } else {
                        logger.logError('Total Should be greater than zero!');
                    }
                }
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.purchaseInvoiceForm.$validationSummary), 555, 'trustedHtml');
            }
        };
        /**
         * load Charges Table
         */
        ///////////////////////////
        $scope.wonumberonchange = function(wonumber) {

            var obj = $filter('filter')($scope.wonumberist, {
                id : wonumber
            });

            $http.get("app/generalpurchaseinvoice/getDtl?num=" + wonumber).success(function(response) {

                $scope.ItemList = response.itemList;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail = [];
                $scope.loadTable();
                $scope.assignValues($scope.ItemList);
            }).error(function(result) {
                logger.logError("Error Please Try Again");
            });
        }

        $scope.$watch('purchaseInvoiceData.wonumber', function(newValue, oldValue) {
            if ($scope.edit == false) {
                if (newValue != undefined && newValue != '') {
                    $scope.wonumberonchange(newValue);
                } else {

                    $scope.ItemList = [];
                    $scope.purchaseInvoiceData.purchaseInvoiceDetail = [];

                }
            }
        });

        $scope.assignValues = function(obj) {
            $scope.purchaseInvoiceData.purchaseInvoiceProdDetail = [];
            var i = 0;
            for (i; i < obj.length; i++) {

                $scope.addRow($scope.purchaseInvoiceData.purchaseInvoiceProdDetail);
                $scope.purchaseInvoiceData.purchaseInvoiceProdDetail[i].accountHeadCode = obj[i].accountHeadCode;
                $scope.purchaseInvoiceData.purchaseInvoiceProdDetail[i].servicedetail = obj[i].servicedetail;
                $scope.purchaseInvoiceData.purchaseInvoiceProdDetail[i].amount = 0;
                $scope.purchaseInvoiceData.purchaseInvoiceProdDetail[i].taxAmount = 0;
                $scope.purchaseInvoiceData.purchaseInvoiceProdDetail[i].totalAmount = 0;

            }

        }

        $scope.loadTable = function() {
            var table = {};
            table = {
                siNo : 1,

                accountHeadCode : '',
                subaccountHeadCode : '',
                servicedetail : '',
           //     isCostCenter : false,


                amount : '',

            };

            $scope.purchaseInvoiceData.purchaseInvoiceDetail.push(table);

        }

        $scope.loadTable();

        $scope.addRow = function(purchaseInvoiceDetail) {
            var len = purchaseInvoiceDetail.length;
            var table = {
                siNo : 1,
                accountHeadCode : '',
                subaccountHeadCode : '',
                servicedetail : '',
                amount : '',
                costCenter: '',
               // isCostCenter : false,


            };
            table.siNo = len + 1;
            $scope.purchaseInvoiceData.purchaseInvoiceProdDetail.push(table);

        };

        $scope.removeRow = function(purchaseInvoiceDetail) {

            $scope.tablerow = [];
            angular.forEach(purchaseInvoiceDetail, function(row, index) {
                var check = row.select;
                if (check == undefined || check == "") {
                    $scope.tablerow.push(row);
                } else {

                }
            });
            //alert("tablerow"+$scope.purchaseInvoiceData.purchaseInvoiceDetail);
            $scope.purchaseInvoiceData.purchaseInvoiceDetail = $scope.tablerow;
            $scope.calculateChargeAmount($scope.purchaseInvoiceData.purchaseInvoiceDetail);
            $scope.calculateAHAmount($scope.purchaseInvoiceData.purchaseInvoiceDetail);

        };

        /**
         * load Product Table
         */
        $scope.loadProdTable = function() {

            var table = {};
            table = {
                siNo : 1,
                itemId : '',
                quantity : '',
                unitprice : '',
                amount : '0',
                taxAmount : '0',
                costCenter: ''
               // isCostCenter : false,

            };
            $scope.purchaseInvoiceData.purchaseInvoiceProdDetail.push(table);
        }

        $scope.loadProdTable();

        $scope.addProdRow = function(purchaseInvoiceProdDetail) {
            var len = purchaseInvoiceProdDetail.length;
            var table = {
                siNo : 1,
                itemId : '',
                quantity : '',
                unitprice : '',
                amount : '0',
                taxAmount : '0',

              //  isCostCenter : false,

            };
            table.siNo = len + 1;
            purchaseInvoiceProdDetail.push(table);

        };

        $scope.removeProdRow = function(purchaseInvoiceProdDetail) {

            $scope.tableProdrow = [];
            angular.forEach(purchaseInvoiceProdDetail, function(row, index) {
                var check = row.select;
                if (check == undefined || check == "") {
                    $scope.tableProdrow.push(row);
                } else {

                }
            });
            $scope.purchaseInvoiceData.purchaseInvoiceProdDetail = $scope.tableProdrow;
            $scope.calculateProductAmount($scope.purchaseInvoiceData.purchaseInvoiceProdDetail);
        };

        $scope.cancel = function() {
          //  $location.path("/hospital/accounts/generalPurchaseInvoice/list");
        	$state.go('app.finance.accounts.generalpurchaseinvoice.list');
        };
        var gblPrdtdetLen = 0;
        //  Account head List...................................

        /**
         * Fetch product details from GRN No
         */
        /*
         $scope.$watch("purchaseInvoiceData.supplier", function(newValue, oldValue) {

         if (newValue != undefined && newValue != null && newValue != '') {

         if (!$scope.isGRNNo) {

         $http.post('app/purchaseinvoice/getCurrencyCode', newValue).success(function(response) {
         if (response.currencyList != undefined && response.currencyList != null && response.currencyList != '') {
         $scope.purchaseInvoiceData.currency = response.currencyList[0].currency;
         } else {
         $scope.purchaseInvoiceData.currency = '';
         }
         });

         }
         }
         });
         */
        // Top find which object Property is Updated
        var purchaseInvObj = angular.copy($scope.purchaseInvoiceData, purchaseInvObj);
        var arrayOfValues = Object.keys(purchaseInvObj);
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
            case "grnNo":
                break;
            }
        };
        $scope.wotypelist = [];
        var data2 = {
            'id' : 'Capex WO',
            'text' : 'Capex WO'
        };
        $scope.wotypelist.push(data2);
        var data3 = {
            'id' : 'Revex WO',
            'text' : 'Revex WO'
        };
        $scope.wotypelist.push(data3);

        $scope.budgetType = false;
        $scope.$watch("purchaseInvoiceData.wotype", function(newValue, oldValue) {

            var woType = $scope.purchaseInvoiceData.wotype;
            $scope.getbudgetType(woType);

        });

        $scope.getbudgetType = function(woType) {
            if (woType == "Capex WO") {
                $scope.budgetType = true;
                var flag = 'C';
                $http.get('app/purchaseOrder/BudgetTypeList?potype=' + flag).success(function(datas) {
                    $scope.budgetTypeList = datas;
                });

            } else if (woType == "Revex WO") {
                $scope.budgetType = true;
                var flag = 'R';
                $http.get('app/purchaseOrder/BudgetTypeList?potype=' + flag).success(function(datas) {
                    $scope.budgetTypeList = datas;
                });
            }

        }

        // To watch a Object Collection
        $scope.$watchCollection('purchaseInvoiceData', function(newVal, oldVal) {
            if (newVal != undefined) {
                var last_changed = $scope.checkWhichVariableHasUpdated(arrayOfValues, newVal, oldVal);
                if (angular.isDefined(last_changed) && last_changed != null) {
                    $scope.loadDropDown(last_changed);
                }
            }
        }, true);

        $scope.formatDateDDMMYYYY = function(input) {
            var datePart = input.match(/\d+/g), year = datePart[0].substring(2), // get
            // only
            // two
            // digits
            month = datePart[1], day = datePart[2];

            return day + '/' + month + '/' + year;
        }

        /**
         * Drop Down Functionality
         */
        $scope.getDropdownvalue = function() {

            $http.get($stateParams.tenantid+'/app/commonUtility/getAssetList').success(function(datas) {
                $scope.assetList = datas;
            }).error(function(datas) {
            });

            $http.get($stateParams.tenantid+'/app/commonUtility/getCompanyList').success(function(datas) {
                $scope.companyList = datas;

                var foundItemDest = $filter('filter')($scope.companyList, {
                    baseCompany : 0

                })[0];
              //  $scope.purchaseInvoiceData.company = foundItemDest.id;
            }).error(function(datas) {
            });
            $http.get('app/purchaseinvoice/getSupplierList').success(function(datas) {
                $scope.supplierList = datas;
            }).error(function(datas) {
            });
            $http.get('app/purchaseinvoice/getGrnList').success(function(datas) {
                $scope.grnList = datas;
            }).error(function(datas) {
            });

            $http.get( 'app/purchaseinvoice/getChargeList').success(function(datas) {
                $scope.chargeList = datas;
            }).error(function(datas) {
            });

            $http.get($stateParams.tenantid+'/app/commonUtility/getCostCenter').success(function(datas) {
                $scope.costCenterListHr = datas;
            }).error(function(datas) {
            });

            $http.get('app/generalpurchaseinvoice/getItemList').success(function(datas) {
                $scope.itemList = datas;
            }).error(function(datas) {
            });

            $http.get($stateParams.tenantid+'/app/commonUtility/getEmployeeList').success(function(datas) {
                $scope.employeeList = datas;
            }).error(function(datas) {
            });

            $http.get($stateParams.tenantid+'/app/commonUtility/getCountryList').success(function(datas) {
                $scope.countryList = datas;
            }).error(function(datas) {
            });

            $http.get($stateParams.tenantid+'/app/commonUtility/getDepartmentList').success(function(datas) {
                $scope.departmentList = datas;
            }).error(function(datas) {
            });
            $http.get($stateParams.tenantid+'/app/commonUtility/getDesignationList').success(function(datas) {
                $scope.designationList = datas;
            }).error(function(datas) {
            });

            $http.get($stateParams.tenantid+'/app/commonUtility/getCustomerAttributeList').success(function(datas) {
                $scope.customerList = datas;
            }).error(function(datas) {
            });
            
            
            $http.get($stateParams.tenantid+'/app/commonUtility/getstudentList').success(function(datas) {
                $scope.studentList = datas;
            }).error(function(datas) {
            });

            /*
             $http.get('app/commonUtility/getCompanyListWithUser').success(function(datas) {
             // $scope.journalVoucher.companyCode = datas.commonUtilityBean[0].value;
             $scope.journalVoucher.company = datas.commonUtilityBean[0].description;

             })*/
            $http.get($stateParams.tenantid+'/app/commonUtility/getSubAccountCodeLists').success(function(datas) {

                var subAcctList = [];
                angular.forEach(datas.commonUtilityBean, function(item, key) {
                    var subAccHdObj = new Object();
                    subAccHdObj.id = datas.commonUtilityBean[key].subAccountCode;
                    subAccHdObj.text = datas.commonUtilityBean[key].subAccountName;
                    subAcctList.push(subAccHdObj);
                });
                $scope.subAccountCodedetailList = subAcctList;
            });

        };

        ///////////////////// cost list/////
        $scope.$watch('purchaseInvoiceData.company', function(newValue, oldValue) {
            $scope.costList = [];
            if (newValue != '') {
                $scope.onChangeCompany($scope.purchaseInvoiceData.company);
            }
        });
        $scope.onChangeCompany = function(companyCode) {
            $http.get('app/generalpurchaseinvoice/getCostCenterList?companyCode=' + companyCode).success(function(data) {
                $scope.costList = data;

            });
        };

        $scope.getDropdownvalue();

        $scope.getSupplierAccountAttributeList = function() {

        }

        if (!$scope.edit) {
            $scope.getSupplierAccountAttributeList();
        }

        $scope.amountCalculation = function(localAmount) {
            var tcAmt = parseFloat(localAmount, 10) / parseFloat($scope.purchaseInvoiceData.exchangeRate);
            $scope.purchaseInvoiceData.tcamount = tcAmt.toFixed(2);
        }

        $scope.amountLocalCalculation = function(USDAmount) {
            var bcAmt = parseFloat(USDAmount, 10) * parseFloat($scope.purchaseInvoiceData.exchangeRate);
            $scope.purchaseInvoiceData.amount = bcAmt.toFixed(2);
        }

        $scope.calculateChargeAmount = function(purchanceInvoiceDetail) {

            var chargeTotal = 0.0;
            angular.forEach(purchanceInvoiceDetail, function(row, index) {
                chargeTotal = chargeTotal + parseFloat(row.amount);

            });

            $scope.purchaseInvoiceData.chargeTotal = chargeTotal;
            //            alert("charge"+chargeTotal);
            $scope.calculateTotalAmount();
        };
        $scope.calculateAHAmount = function(purchanceInvoiceDetail) {

            var ahTotal = 0.0;
            angular.forEach(purchanceInvoiceDetail, function(row, index) {

                ahTotal = ahTotal + parseFloat(row.ahamount);
            });
            //alert("hhhtttttttt"+ahTotal);
            $scope.purchaseInvoiceData.ahTotal = ahTotal;
            $scope.calculateTotalAmount();
        };

        var i = 0;
        $scope.totalTaxAmount = 0;
        // Tax Calculations

        $scope.calculateTaxDetails = function(rowcollection, taxIdObjects, amount, quantity) {
            var arrayLength = taxIdObjects.length;
            if (arrayLength != i) {
                if (taxIdObjects[i] != "" && taxIdObjects[i] != undefined && taxIdObjects[i] != null) {
                    var taxId = taxIdObjects[i]
                    $http.get("hospital/purchase/quotation/getTaxDetails?taxId=" + taxIdObjects[i]).success(function(response) {
                        if (response.success == true) {
                            $scope.taxPercentage = 0;
                            $scope.taxAmount = 0;
                            $scope.subTaxPercentage = 0;
                            $scope.subTaxAmount = 0;
                            $scope.quotationDetail.subTaxTypeAmt = "";
                            $scope.quotationDetail.subTaxTypePercent = "";
                            $scope.quotationDetail.unitPrice = $scope.isNaNCheck(parseFloat(amount));
                            $scope.quotationDetail.quantity = quantity;
                            if (response.purchaseQuotationDetail.taxType == "Percentage") {
                                $scope.taxPercentage = response.purchaseQuotationDetail.taxPercentage;
                                $scope.quotationDetail.taxType = response.purchaseQuotationDetail.taxType;
                                if ($scope.quotationDetail.taxCode != null && $scope.quotationDetail.taxCode != '' && $scope.quotationDetail.taxCode != undefined) {
                                    $scope.quotationDetail.taxCode = $scope.quotationDetail.taxCode + "," + response.purchaseQuotationDetail.taxCode;
                                } else {
                                    $scope.quotationDetail.taxCode = $scope.quotationDetail.taxCode + response.purchaseQuotationDetail.taxCode;
                                }
                            } else if (response.purchaseQuotationDetail.taxType == "Fixed Amount") {
                                $scope.taxAmount = response.purchaseQuotationDetail.taxAmount;
                                $scope.quotationDetail.taxType = response.purchaseQuotationDetail.taxType;
                                if ($scope.quotationDetail.taxCode != null && $scope.quotationDetail.taxCode != '' && $scope.quotationDetail.taxCode != undefined) {
                                    $scope.quotationDetail.taxCode = $scope.quotationDetail.taxCode + "," + response.purchaseQuotationDetail.taxCode;
                                } else {
                                    $scope.quotationDetail.taxCode = $scope.quotationDetail.taxCode + response.purchaseQuotationDetail.taxCode;
                                }
                            }
                            angular.forEach(response.purchaseQuotationDetail.subTaxList, function(key, index) {
                                if (key.subTaxType == "Percentage") {
                                    $scope.subTaxPercentage = key.subTaxPercentage;
                                    $scope.quotationDetail.subTaxTypePercent = key.subTaxType;
                                }
                                if (key.subTaxType == "Fixed Amount") {
                                    $scope.subTaxAmount = key.subTaxAmount;
                                    $scope.quotationDetail.subTaxTypeAmt = key.subTaxType;
                                }
                            });
                            $scope.quotationDetail.taxPercentage = $scope.isNaNCheck(parseFloat($scope.taxPercentage));
                            $scope.quotationDetail.taxAmount = $scope.isNaNCheck(parseFloat($scope.taxAmount));
                            $scope.quotationDetail.taxAccountId = response.purchaseQuotationDetail.taxAccountId;

                            $scope.quotationDetail.subTaxPercentage = $scope.isNaNCheck(parseFloat($scope.subTaxPercentage));
                            $scope.quotationDetail.subTaxAmount = $scope.isNaNCheck(parseFloat($scope.subTaxAmount));
                            $scope.quotationDetail.amount = (parseFloat($scope.quotationDetail.unitPrice) * parseFloat($scope.quotationDetail.quantity)).toFixed(2);

                            // Tax Details - Tax Percentage
                            var totalTaxPercentage = (parseFloat($scope.quotationDetail.taxPercentage)) + (parseFloat($scope.quotationDetail.subTaxPercentage));

                            if ($scope.quotationDetail.taxPercentage != "" || $scope.quotationDetail.taxPercentage != 0) { // tax_percentage
                                if ($scope.quotationDetail.taxType == 'Percentage') { // tax
                                    // Type
                                    if ($scope.quotationDetail.subTaxTypePercent == 'Percentage') {
                                        // sub Tax Type
                                        $scope.quotationDetail.taxAmt = (parseFloat($scope.quotationDetail.amount) * (totalTaxPercentage / 100)).toFixed(2);
                                    }
                                    if ($scope.quotationDetail.subTaxTypeAmt == "Fixed Amount") { // sub
                                        // Tax
                                        // Type
                                        var taxPercentAmt = (parseFloat($scope.quotationDetail.amount) * (totalTaxPercentage / 100)).toFixed(2);
                                        $scope.quotationDetail.taxAmt = (parseFloat(taxPercentAmt) + parseFloat($scope.quotationDetail.subTaxAmount)).toFixed(2);
                                    }
                                    if (($scope.quotationDetail.subTaxTypePercent == '' || $scope.quotationDetail.subTaxTypePercent == null || $scope.quotationDetail.subTaxTypePercent == undefined || $scope.quotationDetail.subTaxTypePercent == " ") && ($scope.quotationDetail.subTaxTypeAmt == '' || $scope.quotationDetail.subTaxTypeAmt == undefined || $scope.quotationDetail.subTaxTypeAmt == null || $scope.quotationDetail.subTaxTypeAmt == " ")) {
                                        $scope.quotationDetail.taxAmt = ((parseFloat($scope.quotationDetail.amount)) * parseFloat($scope.quotationDetail.taxPercentage / 100)).toFixed(2);
                                    }
                                }
                            }
                            // Tax Details - Tax Amount
                            if ($scope.quotationDetail.taxAmount != "" || $scope.quotationDetail.taxAmount != 0) { // tax_amount
                                if ($scope.quotationDetail.taxType == "Fixed Amount") { // tax
                                    // type
                                    if ($scope.quotationDetail.subTaxTypePercent == 'Percentage') { // sub
                                        // Tax
                                        // Type
                                        var totalSubTaxPercentAmt = parseFloat($scope.quotationDetail.amount) * (totalTaxPercentage / 100);
                                        $scope.quotationDetail.taxAmt = (parseFloat($scope.quotationDetail.taxAmount) + parseFloat(totalSubTaxPercentAmt)).toFixed(2);
                                    }
                                    if ($scope.quotationDetail.subTaxTypeAmt == "Fixed Amount") {
                                        // sub Tax Type
                                        var totalTaxAmt = parseFloat($scope.quotationDetail.taxAmount) + parseFloat($scope.quotationDetail.subTaxAmount);
                                        $scope.quotationDetail.taxAmt = parseFloat(totalTaxAmt).toFixed(2);
                                    }
                                    if (($scope.quotationDetail.subTaxTypePercent == '' || $scope.quotationDetail.subTaxTypePercent == null || $scope.quotationDetail.subTaxTypePercent == undefined || $scope.quotationDetail.subTaxTypePercent == " ") && ($scope.quotationDetail.subTaxTypeAmt == '' || $scope.quotationDetail.subTaxTypeAmt == undefined || $scope.quotationDetail.subTaxTypeAmt == null || $scope.quotationDetail.subTaxTypeAmt == " ")) {
                                        $scope.quotationDetail.taxAmt = parseFloat($scope.quotationDetail.taxAmount).toFixed(2);
                                    }
                                }
                            }

                            $scope.totalTaxAmount = Number($scope.totalTaxAmount) + Number($scope.quotationDetail.taxAmt);

                            $scope.totalTaxAmount = $scope.totalTaxAmount.toFixed(2);

                            $scope.purchaseInvoiceData.taxAccountList.push({
                                "taxAccountId" : $scope.quotationDetail.taxAccountId,
                                "taxAmount" : Number($scope.quotationDetail.taxAmt),
                                "itemId" : rowcollection.itemId
                            });

                            $scope.totalTaxPercentageValue = Number($scope.totalTaxPercentageValue) + Number(totalTaxPercentage);

                            $scope.totalTaxPercentageValue = $scope.totalTaxPercentageValue.toFixed(2);
                            i++;
                            $scope.calculateTaxDetails(rowcollection, taxIdObjects, amount, quantity);
                        } else {
                            $scope.taxPercentage = '';
                            $scope.taxAmount = '';
                            $scope.quotationDetail.taxType = '';
                            $scope.quotationDetail.taxCode = '';
                            $scope.subTaxPercentage = '';
                            $scope.subTaxAmount = '';
                            $scope.quotationDetail.subTaxType = '';
                            i++;
                            $scope.calculateTaxDetails(rowcollection, taxIdObjects, amount, quantity);
                        }
                    });
                } else {
                    $scope.taxPercentage = '';
                    $scope.taxAmount = '';
                    $scope.quotationDetail.taxType = '';
                    $scope.quotationDetail.taxCode = '';
                    $scope.subTaxPercentage = '';
                    $scope.subTaxAmount = '';
                    $scope.quotationDetail.subTaxType = '';
                }
            }
            if (arrayLength == i) {
                rowcollection.taxAmount = $scope.totalTaxAmount;
                gblPrdtdetLen++;
                $scope.loadpurchaseInvoiceProdDetail();
                $scope.calculateProductAmount($scope.purchaseInvoiceData.purchaseInvoiceProdDetail);

            }
        }

        $scope.calculateProductAmount = function(purchanceInvoiceProductDetail) {
            var productTotal = 0.0;
            var productWithTaxTotal = 0.0;
            angular.forEach(purchanceInvoiceProductDetail, function(row, index) {

                row.totalAmount = parseFloat(row.taxAmount) + parseFloat(row.amount);

                productWithTaxTotal = productWithTaxTotal + parseFloat(row.totalAmount);
            });
            $scope.purchaseInvoiceData.productwithTaxTotal = $scope.isNaNCheck(productWithTaxTotal);
            $scope.purchaseInvoiceData.bcamount = $scope.purchaseInvoiceData.productwithTaxTotal;

            $scope.calculateTotalAmount();
        };

        $scope.calculateTotalAmount = function() {
            $scope.purchaseInvoiceData.grantamount = $scope.purchaseInvoiceData.productwithTaxTotal + $scope.purchaseInvoiceData.chargeTotal + $scope.purchaseInvoiceData.ahTotal;

            $scope.purOrderTotal = $scope.purchaseInvoiceData.productwithTaxTotal;

            if ($scope.purchaseInvoiceData.currency != undefined && $scope.purchaseInvoiceData.currency != null && $scope.purchaseInvoiceData.currency != '') {
                $scope.getExchangeRate($scope.purchaseInvoiceData.currency);
            }
        };

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
        /**
         * Edit Functionality
         */
        var purchaseInvoiceNo = $stateParams.purchaseInvoiceNo;
        if (purchaseInvoiceNo == undefined || purchaseInvoiceNo == null || purchaseInvoiceNo == "") {
            $scope.edit = false;
        } else {
            // fetching edit details
            $scope.edit = true;
            
            $http.get('app/generalpurchaseinvoice/getPurchaseInvoiceDetail?purchaseInvoiceNo=' + purchaseInvoiceNo).success(function(data) {

                data.grnNo = (data.grnNo).toString();
                data.budgetType = (data.budgetType).toString();
                data.company = (data.company).toString();
                if(data.costCenter != null)
                data.costCenter = (data.costCenter).toString();
//                data.supplier = (data.supplier).toString();
                $scope.nonPO(data.nonPo);
                angular.forEach(data.purchaseInvoiceProdDetail, function(row, index) {
                    //                    row.accountHeadCode=row.accountHeadCode.toString();
                    //                   row.itemId = row.itemId.toString();
                    row.prodDtlId = row.prodDtlId;
                    row.costCenter = row.costCenter;
                    row = row;
                });
                $scope.purchaseInvoiceData = data;
                angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceProdDetail, function(row, index) {
                    $scope.purchaseInvoiceData.purchaseInvoiceProdDetail[index].costCenter = parseInt(row.costCenter);
                });
                //  
                //                $scope.getDropdownvalue();

            }).error(function(data) {
            });

        }
        /**
         * Save and Update functionality if(parseFloat($scope.purOrderTotal) >=
         * parseFloat($scope.purchaseInvoiceData.grantamount)){ //PO Total and
         * PI Grand Total.. else{ logger.logError("Item wise Total Should not be
         * Greater than Purchase Order Total"); }
         * 
         */

        /*       
               $scope.save = function() {

                   if ($scope.edit == false) {
                       $http.post('app/generalpurchaseinvoice/savePurInv', $scope.purchaseInvoiceData).success(function(result) {
                           if (result == true) {
                               logger.logSuccess("Saved Successfully!");
                               $location.path('/hospital/accounts/generalPurchaseInvoice/list');
                           } else {
                               logger.logError("Error in Save!");
                           }
                       }).error(function(result) {
                       });
                   } else {
                       $http.post('app/generalpurchaseinvoice/updatePurchaseInvoice', $scope.purchaseInvoiceData).success(function(result) {
                           if (result.success) {
                               logger.logSuccess("Updated Successfully!");
                               $location.path('/hospital/accounts/generalPurchaseInvoice/list');
                           } else {
                               logger.logError("Error in Update");
                           }
                       }).error(function(result) {
                       });
                   }

               };
               
               
         */

        
        $http.get($stateParams.tenantid+'/app/commonUtility/getCostCenterList').success(function(datas) {
            $scope.costCenterList = datas;
        }).error(function(datas) {
        });
        var check=true;
        $scope.save = function(purchaseInvoiceForm, purchaseInvoiceData) {
            
        if($scope.purchaseInvoiceData.nonPo!=true){
               if($scope.purchaseInvoiceData.wonumber==null || $scope.purchaseInvoiceData.wonumber=='' || $scope.purchaseInvoiceData.wonumber==undefined){
                   check=false; 
               }
           }
           if(check==true){
            $http.post('app/generalpurchaseinvoice/savePurInv', $scope.purchaseInvoiceData).success(function(result) {
                if (result == false) {
                    logger.logError("Purchase Invoice Already Exist");
                } else {
                    $location.path($stateParams.tenantid+'/hospital/accounts/generalPurchaseInvoice/list');
                    logger.logSuccess("General Purchase Invoice added successfully");
                }
            }).error(function(data) {
            });
              }else{
                  logger.logError("Please select WO number");

                  }
        };

        $scope.update = function(purchaseInvoiceForm, purchaseInvoiceData) {

            $http.post('app/generalpurchaseinvoice/updatePurchaseInvoice', $scope.purchaseInvoiceData).success(function(result) {
                if (result == false) {
                    logger.logError("Purchase Invoice Already Exist");
                } else {
                    $location.path($stateParams.tenantid+'/hospital/accounts/generalPurchaseInvoice/list');
                    logger.logSuccess("General Purchase Invoice updated successfully");
                }
            }).error(function(data) {
            });
        };

    });

    app.controller('tableCtrl', function($scope, $http, $filter, logger) {
        $scope.isSub = true;
        $scope.$watch('purchaseInvoiceData.purchaseInvoiceProdDetail[trIndex].accountHeadCode', function(newValue, oldValue) {
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

                    $http.get($stateParams.tenantid+'/app/commonUtility/getSubAccountCodeListNew?type=' + type).success(function(datas) {

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

                $http.get($stateParams.tenantid+'/app/commonUtility/getAttributesList?accountCode=' + newValue).success(function(datas) {
                    $scope.purchaseInvoiceData.purchaseInvoiceProdDetail[$scope.$index].attributeList = datas;
                    if (newValue == oldValue) {
                        $scope.isOnChange = false;
                    } else {
                        $scope.isOnChange = true;
                    }
                    if (!$scope.edit || $scope.isOnChange) {

                        $scope.purchaseInvoiceData.purchaseInvoiceProdDetail[$scope.$index].employeeCode = '';
                        $scope.purchaseInvoiceData.purchaseInvoiceProdDetail[$scope.$index].departmentCode = '';
                        $scope.purchaseInvoiceData.purchaseInvoiceProdDetail[$scope.$index].countryCode = '';
                        $scope.purchaseInvoiceData.purchaseInvoiceProdDetail[$scope.$index].customerCode = '';
                        $scope.purchaseInvoiceData.purchaseInvoiceProdDetail[$scope.$index].supplierCode = '';
                        $scope.purchaseInvoiceData.purchaseInvoiceProdDetail[$scope.$index].designationCode = '';
                        $scope.purchaseInvoiceData.purchaseInvoiceProdDetail[$scope.$index].costCenter = '';
                        $scope.purchaseInvoiceData.purchaseInvoiceProdDetail[$scope.$index].companyCode = '';
                        $scope.purchaseInvoiceData.purchaseInvoiceProdDetail[$scope.$index].assetCode = '';
                    }

                    $scope.purchaseInvoiceData.purchaseInvoiceProdDetail[$scope.$index].isEmployee = false;

                    $scope.purchaseInvoiceData.purchaseInvoiceProdDetail[$scope.$index].isDepartment = false;

                    $scope.purchaseInvoiceData.purchaseInvoiceProdDetail[$scope.$index].isLocation = false;
                    $scope.purchaseInvoiceData.purchaseInvoiceProdDetail[$scope.$index].isCustomer = false;
                    $scope.purchaseInvoiceData.purchaseInvoiceProdDetail[$scope.$index].isSupplier = false;
                    $scope.purchaseInvoiceData.purchaseInvoiceProdDetail[$scope.$index].isDesignation = false;
                    $scope.purchaseInvoiceData.purchaseInvoiceProdDetail[$scope.$index].isCostCenter = false;
                    $scope.purchaseInvoiceData.purchaseInvoiceProdDetail[$scope.$index].isCompany = false;

                    $scope.purchaseInvoiceData.purchaseInvoiceProdDetail[$scope.$index].isAsset = false;

                    angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceProdDetail[$scope.$index].attributeList, function(row, rowindex) {
                        if (row.attributeName == "Employee") {
                            $scope.purchaseInvoiceData.purchaseInvoiceProdDetail[$scope.$index].isEmployee = true;
                        } else if (row.attributeName == "Students") {
                            $scope.purchaseInvoiceData.purchaseInvoiceProdDetail[$scope.$index].isDepartment = true;
                        } else if (row.attributeName == "Location") {
                            $scope.purchaseInvoiceData.purchaseInvoiceProdDetail[$scope.$index].isLocation = true;
                        } else if (row.attributeName == "Customer") {
                            $scope.purchaseInvoiceData.purchaseInvoiceProdDetail[$scope.$index].isCustomer = true;
                        } else if (row.attributeName == "Supplier") {
                            $scope.purchaseInvoiceData.purchaseInvoiceProdDetail[$scope.$index].isSupplier = true;
                        } else if (row.attributeName == "Designation") {
                            $scope.purchaseInvoiceData.purchaseInvoiceProdDetail[$scope.$index].isDesignation = true;
                        } else if (row.attributeName == "Cost Center") {
                            $scope.purchaseInvoiceData.purchaseInvoiceProdDetail[$scope.$index].isCostCenter = true;
                        } else if (row.attributeName == "Company") {
                            $scope.purchaseInvoiceData.purchaseInvoiceProdDetail[$scope.$index].isCompany = true;
                        } else if (row.attributeName == "Asset") {
                            $scope.purchaseInvoiceData.purchaseInvoiceProdDetail[$scope.$index].isAsset = true;
                        }
                    });
                }).error(function(datas) {
                });

            }
        });

    });

//});