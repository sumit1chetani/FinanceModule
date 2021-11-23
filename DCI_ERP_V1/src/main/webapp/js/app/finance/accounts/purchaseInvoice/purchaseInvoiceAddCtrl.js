//define([ 'hospital/accounts/accounts' ], function(module) {

    //'use strict';
    app.controller('purchaseInvoiceAddCtrl', function($scope, $rootScope,$filter, sharedProperties, $state,
            logger, $http, $location, $stateParams, validationService, toaster) {

        $scope.purchaseInvoiceData = {
            puchaseInvoiceNo : '',
            puchaseInvoiceDate : '',
            company :'C0002',
            grnNo : '',
            potype:'',
            budgetType:'',
            supplier : '',
            currency : '',
            exchangeRate : 0.0,
            partyInvoiceNo : '',
            partyInvoiceDate : '',
            dueDate : '',
            description : '',
            costCenter : '',
            amount : 0.0,
            tcamount : 0.0,
            bcamount : 0.0,
            productTotal : 0.0,
            chargeTotal : 0.0,
            ahTotal: 0.0,
            grantamount : 0.0,
            departmentCode : '',
            countryCode : '',
            costdtl :'',
            customerCode : '',
            supplierCode : '',
            designationCode : '',
            companyCode : '',
            assetCode : '',
            patientCode : '',
            purInvoiceNo : '',
            acctHeadCode : '',
            subAccountName : '',
            accountHeadName : '',
            totalTaxPo: 0.0,
            grantamountGst:'',
            taxAccountList : [],
            purchaseInvoiceDetail : [],
            purchaseAHInvoiceDetail : [],
            purchaseInvoiceProdDetail : [],
            purchaseInvoiceDetailacct : []
  
        };
        
        $scope.purchaseInvoiceData.company = "C0002";
        $scope.potypelist=[];
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
            ahamount : '',
            disAmt : 0,
            taxAmt : 0,
            deliveryLeadTime : '',
            taxPercentage : 0,
            taxAmount : 0,
            subTaxPercentage : 0,
            subTaxAmount : 0,
            rowSubTotal : 0,
            discountAmount : 0.0,
            discountPercent : '',
                costdtl:''

        }

        $scope.isGRNNo = false;

        $scope.isCurrency = true;
        $scope.chargeList = [];
        $scope.companyList = [];
        $scope.supplierList = [];
        $scope.grnList = [];
        $scope.currencyList = [];
        $scope.itemList = [];
        $scope.frieghtAmount = 0;
        $scope.poTotalAmount = 0;
        $scope.isEdit = false;

        $scope.onChangeDecimal = function(id, num) {
            num = num.replace(/[^0-9/.]/g, 0);
            var floatnum = parseFloat(Math.round(num * 100) / 100).toFixed(2);
            $('#' + id).val(floatnum);
            return floatnum;
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
       
    $scope.$watch('purchaseInvoiceData.supplier', function(newValue, oldValue) {
        //  alert(newValue);
           if(newValue!=null && newValue!=undefined && newValue != ''){
           //    $http.post($stateParams.tenantid+ '/app/commonUtility/getVoyageListByVessel',newValue).success(function(data) {
                $http.get('app/purchaseinvoice/getGrnList?supplier=' + $scope.purchaseInvoiceData.supplier).success(function(data) {

                    $scope.purchaseInvoiceData.supplier = newValue;


                     if(data.length > 0)
                   {
                   $scope.grnList = data;
                   }
                   /*  else{
                         
                         logger.logError("Not Available");
                         
                     }*/
               });
           }
         });
      
  
    $scope.potypelist = [ {
        
            id : 'Capex PO',
            text : 'Capex PO'
        }, {
            id : 'Revex PO',
            text : 'Revex PO'
        } ];
   
    /*    id : 'Capex PO',
        text : 'Capex PO'
    }, {
        id : 'Revex PO'
        text : 'Revex PO'
    } ];*/
    $scope.$watch("purchaseInvoiceData.potype", function(newValue, oldValue) {
        if ($scope.isEdit == false) {
        var potype = $scope.purchaseInvoiceData.potype;

        /*
         * $http.get("app/purchaseOrder/getPOSequenceNumber?POType="+potype).success(function(data) {
         * 
         * $scope.purchaseOrder.purchaseOrderNum = data.message; //
         * alert("hh"+data);
         * 
         * });
         */
        // get POtype based On Organization
        if ($rootScope.isEdit == false) {
            $http.get("app/purchaseOrder/getPOSequenceNumberbasedonCompany?POType=" + potype + "&companyId=" + $scope.purchaseOrder.companyId).success(function(data) {

                $scope.purchaseInvoiceData.purchaseOrderNum = data.message;
                // alert("hh"+data);

            });
        }

        if (potype == "Capex PO") {
            $scope.budgetType = true;
            var flag = 'C';
            $http.get('app/purchaseOrder/BudgetTypeList?potype=' + flag).success(function(datas) {
                $scope.budgetTypeList = datas;
            });

        } else if (potype == "Revex PO") {
            $scope.budgetType = true;
            var flag = 'R';
            $http.get('app/purchaseOrder/BudgetTypeList?potype=' + flag).success(function(datas) {
                $scope.budgetTypeList = datas;
            });
        } else if (potype == "Capex WO") {
            $scope.budgetType = true;
            var flag = 'C';
            $http.get('app/purchaseOrder/BudgetTypeList?potype=' + flag).success(function(datas) {
                $scope.budgetTypeList = datas;
            });
        } else if (potype == "Revex WO") {
            $scope.budgetType = true;
            var flag = 'R';
            $http.get('app/purchaseOrder/BudgetTypeList?potype=' + flag).success(function(datas) {
                $scope.budgetTypeList = datas;
            });
        }
//        $scope.purchaseInvoiceData.budgetType = parseInt(data.budgetType);

    }
    });
    
    
    $http.get("app/purchaseinvoice/costcenterlist").success(function(datas) {
        $scope.grnListCost = datas;

    });
    
        $scope.$watch('purchaseInvoiceData.grnNo', function(newValue, oldValue) {
                  //  alert(newValue);
            if($scope.edit == false){
                     if(newValue!=null && newValue!=undefined && newValue != ''){
                         
                         $http.get('app/purchaseinvoice/budpo?grnNo=' + $scope.purchaseInvoiceData.grnNo).success(function(datas) {
                             if(datas){
                                 $scope.purchaseInvoiceData.potype=datas.potype;
                                 $scope.purchaseInvoiceData.budgetType=datas.budgetType;

                             }
                         });
                          $http.get('app/purchaseinvoice/getgrnNo?grnNo=' + $scope.purchaseInvoiceData.grnNo).success(function(data) {

                              $scope.purchaseInvoiceData.grnNo = newValue;


                               if(data.length > 0)                                                                                       
                             {
                                   if(data[0].id != null && data[0].id != "" ){
                             $scope.grnListCost = data;

                                   }    else
                                       {
                                       $http.get("app/purchaseinvoice/costcenterlist").success(function(datas) {
                                           $scope.grnListCost = datas;

                                       });
                                       

                                       }
                             }
                               else{
                                   
                                   $http.get("app/purchaseinvoice/costcenterlist").success(function(datas) {
                                       $scope.grnListCost = datas;

                                   });
                                   

                               }
                         });
                     }
        }
                   });

        $scope.$watch("purchaseInvoiceData.company", function(newValue, oldValue) {
            var companyCode = newValue;
            $http.get('app/purchaseOrder/costcenterList?companyId=' + companyCode).success(function(datas) {
                $scope.grnListCost = datas;
                $scope.costList = datas;

            });

        });
        
      
        
        $scope.getdropdown = function(){

        /*    $http.get('app/purchaseinvoice/getGrnList').success(function(datas) {
             $scope.grnList = datas;
         }).error(function(datas) {
         });
             */
//             $http.get('app/purchaseinvoice/getSupplierList').success(function(datas) {
                 $http.get($stateParams.tenantid +'/app/commonUtility/getSupplierList').success(function(datas) {

                 $scope.supplierList = datas;
             }).error(function(datas) {
             });
        }
        $scope.getdropdown();
    
        
        
        /*
        $scope.$watch('purchaseInvoiceData.supplier', function(newValue, oldValue) {
            //  alert(newValue);
               if(newValue!=null && newValue!=undefined && newValue != ''){
               //    $http.post($stateParams.tenantid+ '/app/commonUtility/getVoyageListByVessel',newValue).success(function(data) {
                    $http.get('app/purchaseinvoice/getgrnsupplier?supplier=' + $scope.purchaseInvoiceData.supplier).success(function(data) {

                        $scope.purchaseInvoiceData.supplier = newValue;


                         if(data.length > 0)
                       {
                       $scope.grnList = data;
                       }
                         else{
                             
                             logger.logError("Not Available");
                             
                         }
                   });
               }
             });*/
          
        
        $scope.costList = [];

             
             $http.get("app/purchaseinvoice/costcenterlist").success(function(datas) {
                 $scope.costList = datas;
             });

        $scope.onChangeNumber = function(id, num) {
            num = num.replace(/[^0-9]/g, '');
            $('#' + id).val(num);
            return num;
        }

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
            $scope.purchaseInvoiceData.puchaseInvoiceDate = $scope.date;
        }

        $scope.getCurrentDate();
        $scope.currencyList = [];

      /*  $http.get("hrms/master/country/currencylist").success(function(datas) {
            $scope.currencyList = datas.currencyList;
        });*/
        
        $http.get('app/exchangerate/getCurrencyList').success(function(datas) {
            $scope.currencyList = datas.currencyList;
        }).error(function(data) {
        });

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

        $scope.$watch('purchaseInvoiceData.dueDate', function(newValue, oldValue) {
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
                if($scope.edit == false){
                
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
            }else{
                if (toDate < issuedDate) {
                    isValid = false;
                    $scope.purchaseInvoiceData.dueDate = "";
                }
                if (isValid == false) {
                    logger.logError("Due date should be greater than the invoice date ");
                }
            }
            }
        });
     

        $scope.checkundefined = function(value) {
            var invalid = false;
            if (value == undefined || value == 'undefined' || value == null || value == 'null' || value == '') {
                invalid = true;
            }
            return invalid;

        }
        $scope.changecolor = function(id) {
            $('#' + id + ' .selectivityId').find('input').css(
                    "border-color", "red");
        }

        $scope.changecolor = function(id) {
            $('#' + id + ' .selectivityId').find('input').css(
                    "border-color", "red");

        }
        $scope.clearcolor = function(id) {
            $('#' + id + ' .selectivityId').find('input').css(
                    "border-color", "#e8dddd");

        }
        
        //add valid
        $scope.checkValidation = function() {

            var alertmsg = "<ui><h4 backgroundcolor=green>Please fill the required fields</h4>";
            var msg = "";
            angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceProdDetail,function(rowdata,index){
//                angular.forEach(purchaseInvoiceDetail, function(row, index) {
            if ($scope.checkundefined(rowdata.itemId)) {
                msg = msg + "<li>Item Name :Field is required.</li>";         
                $scope.changecolor('itemCode');
            }else{
                $scope.clearcolor('itemCode');
            }
        });
            alertmsg = alertmsg + msg + "</ui>";
            if ($scope.checkundefined(msg)) {
                return '';
            } else {
                return alertmsg;
            }
        }
        
        /**
         * validate ***********************
         */
        $scope.validate = function(purchaseInvoiceForm, purchaseInvoiceData) {
            if (new validationService().checkFormValidity($scope.purchaseInvoiceForm)) {
                var msg=$scope.checkValidation();
                if(!$scope.checkundefined(msg)){   
                    logger.logError(msg);   
                }else{
                if (!$scope.edit) {
                    if ($scope.isNaNCheck($scope.purchaseInvoiceData.productwithTaxTotal) > 0) {
                        $scope.save(purchaseInvoiceForm, purchaseInvoiceData);
                    } else {
                        logger.logError('Total Should be greater than zero');
                    }
                } else {
                    if ($scope.purchaseInvoiceData.productwithTaxTotal > 0) {
                        $scope.save(purchaseInvoiceForm, purchaseInvoiceData);
                    } else {
                        logger.logError('Total Should be greater than zero!');
                    }
                }
                }
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.purchaseInvoiceForm.$validationSummary), 1000, 'trustedHtml');
            }
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
                costdtl   :'',
                amount : ''
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
                costdtl   :'',
                amount : ''
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
        
        
        
        /**
         * load Charges Table
         */

        $scope.loadTable = function() {
            var table = {};
            table = {
                siNo : 1,
                subGrpCode : '',
                accountHeadCode : '',
                shortDetail : '',
                amount : '',
                ahamount : '',
                employeeCode : '',
                departmentCode : '',
                countryCode : '',
                customerCode : '',
                supplierCode : '',
                designationCode : '',
                costCenter : '',
                companyCode : '',
                costdtl   :'',
                assetCode : '',
                isEmployee : false,
                isDepartment : false,
                isLocation : false,
                isCustomer : false,
                isSupplier : false,
                isDesignation : false,
                isCostCenter : false,
                isCompany : false,
                isAsset : false,
                attributeList : [],

            };

            $scope.purchaseInvoiceData.purchaseInvoiceDetail.push(table);

        }

        $scope.loadTable();

        $scope.addRow = function(purchaseInvoiceDetail) {
            var len = purchaseInvoiceDetail.length;
            var table = {
                siNo : 1,
                subGrpCode : '',
                accountHeadCode : '',
                shortDetail : '',
                amount : '',
                ahamount : '',
                employeeCode : '',
                departmentCode : '',
                countryCode : '',
                customerCode : '',
                supplierCode : '',
                designationCode : '',
                costCenter : '',
                companyCode : '',
                costdtl :'',
                assetCode : '',
                isEmployee : false,
                isDepartment : false,
                isLocation : false,
                isCustomer : false,
                isSupplier : false,
                isDesignation : false,
                isCostCenter : false,
                isCompany : false,
                isAsset : false,
                attributeList : []
            };
            table.siNo = len + 1;
            purchaseInvoiceDetail.push(table);

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
           // $scope.calculateAHAmount($scope.purchaseInvoiceData.purchaseInvoiceDetail);

        };

        
        //ACCT HEAD ROW
        
        
        
        
       
        $scope.loadAcctTable = function() {

            var table = {};
            table = {
                    siNo : 1,
                    ahaccountHeadCode : '',
                    ahshortDetail : '',
                    ahamount : '',
                    isEmployee : false,
                    isDepartment : false,
                    isLocation : false,
                    isCustomer : false,
                    isSupplier : false,
                    isDesignation : false,
                    isCostCenter : false,
                    isCompany : false,
                    isAsset : false,
                    attributeList : []
            };
            $scope.purchaseInvoiceData.purchaseInvoiceDetailacct.push(table);
        }

        $scope.loadAcctTable();

        $scope.addRowacct = function(purchaseInvoiceDetailacct) {
            var len = purchaseInvoiceDetailacct.length;
            var table = {
                    siNo : 1,
                    ahaccountHeadCode : '',
                    ahshortDetail : '',
                    ahamount : '',
                    isEmployee : false,
                    isDepartment : false,
                    isLocation : false,
                    isCustomer : false,
                    isSupplier : false,
                    isDesignation : false,
                    isCostCenter : false,
                    isCompany : false,
                    isAsset : false,
                    attributeList : []
            };
            table.siNo = len + 1;
            purchaseInvoiceDetailacct.push(table);

        };

        $scope.removeRowacct = function(purchaseInvoiceDetailacct) {

            $scope.tableProdrow = [];
            angular.forEach(purchaseInvoiceDetailacct, function(row, index) {
                var check = row.select;
                if (check == undefined || check == "") {
                    $scope.tableProdrow.push(row);
                } else {

                }
            });
            $scope.purchaseInvoiceData.purchaseInvoiceDetailacct = $scope.tableProdrow;
            $scope.calculateAHAmount($scope.purchaseInvoiceData.purchaseInvoiceDetailacct);
        };


        $scope.cancel = function() {
           // $location.path("/accounts/purchaseInvoice/list");
        	$state.go('app.finance.accounts.purchaseinvoice.list')
        };
        var gblPrdtdetLen = 0;
//  Account head List...................................
        
        /**
         * Fetch product details from GRN No
         */
        $scope.$watch("purchaseInvoiceData.grnNo", function(newValue, oldValue) {
            if($scope.edit == false){
            if (newValue != "" && newValue != undefined && newValue != null && newValue != 0) {
                $http.get('app/purchaseinvoice/getGrnDetail?grnNo=' + newValue).success(function(data) {
                    if (!$scope.isEdit) {
                        i = 0;
                        $scope.totalTaxAmount = 0;
                        $scope.totalTaxPercentageValue = 0;
                        $scope.quotationDetail.taxCode = "";
                        gblPrdtdetLen = 0;
                        if ($scope.edit == false) {
                            $scope.purchaseInvoiceData.costCenter = data.costCenterId.toString();
                         //   $scope.purchaseInvoiceData.supplier = data.supplier;
                            $scope.purchaseInvoiceData.company = data.company;
                            $scope.purchaseInvoiceData.currency = data.currency;
                            $scope.purchaseInvoiceData.dueDate = data.dueDate;
                            $scope.purchaseInvoiceData.partyInvoiceNo = data.partyInvoiceNo;
                            $scope.purchaseInvoiceData.partyInvoiceDate = data.partyInvoiceDate;
                            $scope.purchaseInvoiceData.description =  data.description;

                           // $scope.purchaseInvoiceData.totalTaxPo =  data.totalTaxPo;
                        }

                        if (data.paymentTerms != undefined && data.paymentTerms != '' && data.paymentTerms != null) {
                            var toDate = $scope.date;
                            toDate = toDate.split("/");
                            toDate = new Date(toDate[2], toDate[1] - 1, toDate[0]);
                            var newdate = new Date(toDate);
                            newdate.setDate(newdate.getDate() + data.paymentTerms);
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
//                            $scope.purchaseInvoiceData.dueDate = someFormattedDate;

                        } else {
//                            $scope.purchaseInvoiceData.dueDate = $scope.date;
                        }

                        if (data.partyInvoiceDate != null || data.partyInvoiceDate != undefined != data.partyInvoiceDate != "") {
                            var partyinvDate = data.partyInvoiceDate;
                            $scope.purchaseInvoiceData.partyInvoiceDate = partyinvDate;
                        }
                        if (data.purchaseInvoiceProdDetail.length > 0) {
                            $scope.purchaseInvoiceData.purchaseInvoiceProdDetail = [];
                            var purchaseInvoicePrdLength = data.purchaseInvoiceProdDetail.length;
                            $scope.purchaseInvoiceData.taxAccountList = [];
                            var totalTaxPin=0;
                            var totalDiscountPin=0;
                            angular.forEach(data.purchaseInvoiceProdDetail, function(row, index) {
                                var length = $scope.purchaseInvoiceData.purchaseInvoiceProdDetail.length;
                                row.siNo = index + 1;
                                row.itemId = (row.itemId).toString();
                                row.quantity = row.quantity;
                                if(row.costdtl !=null && row.costdtl != "" && row.costdtl != undefined)
                                row.costdtl = row.costdtl.toString();
                                var unitPrice = Number(row.unitprice);
                                var ratio = 0;
                                var oneunitPrice = 0;
                                var price = 0;
                             /*   if (row.vendorQuantity > 0) {
                                    ratio = row.purchaseQuanity / row.vendorQuantity;
                                    oneunitPrice = unitPrice / ratio;
                                    row.unitprice = $scope.isNaNCheck(parseFloat(oneunitPrice).toFixed(2));
                                    price = row.unitprice * row.quantity;
                                } else {
                                    row.unitprice = 0;
                                    row.quantity = 0;
                                    row.amount = 0;
                                }*/
/*
                              if (row.discountType > 0) {
                                    if (row.discountType == 58) {
                                        row.discountAmount = Number(price * (row.discountPercentage / 100)).toFixed(2);
                                    }
                                    if (row.discountType == 59) {
                                        var discountAmount = row.discountAmount / row.purchaseQuanity;
                                        discountAmount = discountAmount * row.convertedQuantity;
                                        row.discountAmount = discountAmount;

                                    }
                                } else {
                                    row.discountAmount = 0;
                                }
                                */
                                
                                
                                
                                totalTaxPin=totalTaxPin +row.totalTaxPo;
                                totalDiscountPin=totalDiscountPin +row.discountAmount;

                                $scope.purchaseInvoiceData.purchaseInvoiceProdDetail.push(row);
                                $scope.calculateDiscountAmount($scope.purchaseInvoiceData.purchaseInvoiceProdDetail);
                                $scope.calculateTaxPoAmount($scope.purchaseInvoiceData.purchaseInvoiceProdDetail);
                                
                            });
                            
//                         var polength =  $scope.purchaseInvoiceData.purchaseInvoiceProdDetail.length-1;
                            $scope.purchaseInvoiceData.totalTaxPo=Number(totalTaxPin).toFixed(2);
                            $scope.purchaseInvoiceData.discountAmount=Number(totalDiscountPin).toFixed(2);
                            $scope.loadpurchaseInvoiceProdDetail();

                        }
                    }
                    $scope.isGRNNo = true;
                }).error(function(datas) {
                });

                $scope.loadpurchaseInvoiceProdDetail = function() {
                    if ($scope.purchaseInvoiceData.purchaseInvoiceProdDetail.length > 0) {
                        var purchaseInvoicePrdLength = $scope.purchaseInvoiceData.purchaseInvoiceProdDetail.length;
                        if (gblPrdtdetLen < purchaseInvoicePrdLength) {
                            i = 0;
                            $scope.totalTaxAmount = 0;
                            $scope.totalTaxPercentageValue = 0;
                            $scope.quotationDetail.taxCode = "";
                            $scope.calculateTaxDetails($scope.purchaseInvoiceData.purchaseInvoiceProdDetail[gblPrdtdetLen], $scope.purchaseInvoiceData.purchaseInvoiceProdDetail[gblPrdtdetLen].taxIdslist, $scope.purchaseInvoiceData.purchaseInvoiceProdDetail[gblPrdtdetLen].unitprice, $scope.purchaseInvoiceData.purchaseInvoiceProdDetail[gblPrdtdetLen].quantity);

                        }
                        if ($scope.purchaseInvoiceData.currency != undefined && $scope.purchaseInvoiceData.currency != null && $scope.purchaseInvoiceData.currency != '') {

                            $scope.getExchangeRate($scope.purchaseInvoiceData.currency);
                        }

                    }

                }
                
                

                $scope.calculateDiscountAmount = function(purchaseInvoiceProdDetail) {

                    var discountAmount = 0.0;
                    angular.forEach(purchaseInvoiceProdDetail, function(row, index) {
                        discountAmount = discountAmount + parseFloat(row.discountAmount);

                    });

                    $scope.purchaseInvoiceData.discountAmount = discountAmount;
//                    alert("charge"+chargeTotal);
                   // $scope.calculateTotalAmount();
                };

                
                
                
                $scope.calculateTaxPoAmount = function(purchaseInvoiceProdDetail) {

                    var totalTaxPo = 0.0;
                    angular.forEach(purchaseInvoiceProdDetail, function(row, index) {
                        totalTaxPo = totalTaxPo + parseFloat(row.totalTaxPo);

                    });

                    $scope.purchaseInvoiceData.totalTaxPo = totalTaxPo;
//                    alert("charge"+chargeTotal);
                   // $scope.calculateTotalAmount();
                };

                $http.get('app/purchaseinvoice/checkFreightCharges?grnNo=' + newValue).success(function(response) {

                    if (response.frieghtTotal == undefined || response.frieghtTotal == null) {
                        response.frieghtTotal = 1;
                    }
                    $scope.frieghtAmount = response.frieghtTotal;

                    $scope.poTotalAmount = response.poTotalAmount;
                });

            } else {
                if ($scope.purchaseInvoiceData.grnNo != 0 || $scope.purchaseInvoiceData.grnNo == '') {
                    $scope.isGRNNo = false;
                    $scope.purchaseInvoiceData.purchaseInvoiceProdDetail = [];
                    $scope.loadProdTable();
                    $scope.purchaseInvoiceData.supplier = ''
//                    $scope.purchaseInvoiceData.company = ''
                    $scope.purchaseInvoiceData.exchangeRate = '1'
                    $scope.purchaseInvoiceData.tcamount = ''
                    $scope.purchaseInvoiceData.currency = 'INR'
                    $scope.purchaseInvoiceData.bcamount = ''

                }

            }
        }
        });

     /*   $scope.$watch("purchaseInvoiceData.supplier", function(newValue, oldValue) {

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
        });*/

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

            $http.get('app/commonUtility/getAssetList').success(function(datas) {
                $scope.assetList = datas;
            }).error(function(datas) {
            });

            $http.get( $stateParams.tenantid+ '/app/commonUtility/getCompanyList').success(function(datas) {
                $scope.companyList = datas;
               
//                    var foundItemDest = $filter('filter')($scope.companyList, {
//                        baseCompany : 0
//                        
//                    })[0];
                  //  $scope.purchaseInvoiceData.company=foundItemDest.id;
            }).error(function(datas) {
            });
//           $http.get('app/purchaseinvoice/getSupplierList').success(function(datas) {
            $http.get($stateParams.tenantid+'/app/commonUtility/getSupplierList').success(function(datas) {

                $scope.supplierList = datas;
            }).error(function(datas) {
            });
           /* $http.get('app/purchaseinvoice/getGrnList').success(function(datas) {
                $scope.grnList = datas;
            }).error(function(datas) {
            });*/

            $http.get('app/purchaseinvoice/getChargeList').success(function(datas) {
                $scope.chargeList = datas;
            }).error(function(datas) {
            });

            $http.get($stateParams.tenantid+'/app/commonUtility/getCostCenter').success(function(datas) {
                $scope.costCenterListHr = datas;
            }).error(function(datas) {
            });

            $http.get($stateParams.tenantid+'/app/commonUtility/getCostCenterList').success(function(datas) {
                $scope.costCenterList = datas;
            }).error(function(datas) {
            });
            $http.get('app/purchaseinvoice/getItemList').success(function(datas) {
                $scope.itemList = datas;
            }).error(function(datas) {
            });

            $http.get($stateParams.tenantid+'/app/commonUtility/getEmployeeList').success(function(datas) {
                $scope.employeeList = datas;
            }).error(function(datas) {
            });

            $http.get( $stateParams.tenantid+ '/app/commonUtility/getCountryList').success(function(datas) {
                $scope.countryList = datas;
            }).error(function(datas) {
            });

            $http.get($stateParams.tenantid+ '/app/commonUtility/getDepartmentList').success(function(datas) {
                $scope.departmentList = datas;
            }).error(function(datas) {
            });
            $http.get($stateParams.tenantid+ '/app/commonUtility/getDesignationList').success(function(datas) {
                $scope.designationList = datas;
            }).error(function(datas) {
            });

            $http.get($stateParams.tenantid+'/app/commonUtility/getCustomerAttributeList').success(function(datas) {
                $scope.customerList = datas;
            }).error(function(datas) {
            });
            
            $http.get($stateParams.tenantid+ '/app/commonUtility/getstudentList').success(function(datas) {
                $scope.studentList = datas;
            }).error(function(datas) {
            });

        };

        $scope.getDropdownvalue();

        $scope.getSupplierAccountAttributeList = function() {
            $scope.$index = 0;
            $http.get('app/commonUtility/getAttributesList?accountCode=' + "20080001").success(function(datas) {
                $scope.purchaseInvoiceData.attributeList = datas;
                if (!$scope.edit) {
                    $scope.purchaseInvoiceData.employeeCode = '';
                    $scope.purchaseInvoiceData.departmentCode = '';
                    $scope.purchaseInvoiceData.countryCode = '';
                    $scope.purchaseInvoiceData.customerCode = '';
                    $scope.purchaseInvoiceData.supplierCode = '';
                    $scope.purchaseInvoiceData.designationCode = '';
                    $scope.purchaseInvoiceData.costCenter = '';
                    $scope.purchaseInvoiceData.companyCode = '';
                    $scope.purchaseInvoiceData.assetCode = '';
                }

                
                
                
                $scope.purchaseInvoiceData.isEmployee = false;

                $scope.purchaseInvoiceData.isDepartment = false;

                $scope.purchaseInvoiceData.isLocation = false;
                $scope.purchaseInvoiceData.isCustomer = false;
                $scope.purchaseInvoiceData.isSupplier = false;
                $scope.purchaseInvoiceData.isDesignation = false;
                $scope.purchaseInvoiceData.isCostCenter = false;
                $scope.purchaseInvoiceData.isCompany = false;

                $scope.purchaseInvoiceData.isAsset = false;

                angular.forEach($scope.purchaseInvoiceData.attributeList, function(row, rowindex) {
                    if (row.attributeName == "Employee") {
                        $scope.purchaseInvoiceData.isEmployee = true;
                    } else if (row.attributeName == "Students") {
                        $scope.purchaseInvoiceData.isDepartment = true;
                    } else if (row.attributeName == "Location") {
                        $scope.purchaseInvoiceData.isLocation = true;
                    } else if (row.attributeName == "Customer") {
                        $scope.purchaseInvoiceData.isCustomer = true;
                    } else if (row.attributeName == "Supplier") {
                        $scope.purchaseInvoiceData.isSupplier = true;
                    } else if (row.attributeName == "Designation") {
                        $scope.purchaseInvoiceData.isDesignation = true;
                    } else if (row.attributeName == "Cost Center") {
                        $scope.purchaseInvoiceData.isCostCenter = true;
                    } else if (row.attributeName == "Company") {
                        $scope.purchaseInvoiceData.isCompany = true;
                    } else if (row.attributeName == "Asset") {
                        $scope.purchaseInvoiceData.isAsset = true;
                    }
                });
            }).error(function(datas) {
            });

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
                        if (response.success == true) {/*
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
                            i++;*/
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
//            if (arrayLength == i) {
                rowcollection.taxAmount = $scope.totalTaxAmount;
                gblPrdtdetLen++;
                $scope.loadpurchaseInvoiceProdDetail();
                $scope.calculateProductAmount($scope.purchaseInvoiceData.purchaseInvoiceProdDetail);
                $scope.calculateProductTaxAmount($scope.purchaseInvoiceData.purchaseInvoiceProdDetail);

//            }
        }
        
        
        
        
        
        
        
        
        
        

        
        
        
        

        $scope.calculateProductAmount = function(purchanceInvoiceProductDetail) {
            var productTotal = 0.0;
            var productWithTaxTotal = 0.0;
            var discountTotal = 0;
            var taxTotal = 0 ;
            angular.forEach(purchanceInvoiceProductDetail, function(row, index) {
                if (row.quantity == "")
                    row.quantity = 0;
                if (row.unitprice == "")
                    row.unitprice = 0;
                row.amount = parseFloat(row.quantity) * parseFloat(row.unitprice).toFixed(2);
                row.amount = row.amount.toFixed(2);
                row.taxAmount = parseFloat($scope.isNaNCheck($scope.isUndefinedAndNullCheck(row.taxAmount)));

                row.totalAmount = parseFloat(row.amount) -

                parseFloat($scope.isNaNCheck($scope.isUndefinedAndNullCheck(row.discountAmount)));

                row.totalAmount = parseFloat($scope.isNaNCheck($scope.isUndefinedAndNullCheck(row.totalAmount)));

                row.totalAmount = row.totalAmount.toFixed(2);
                discountTotal = discountTotal +parseFloat(row.discountAmount);
                taxTotal = taxTotal + row.taxAmount;
               // row.totalAmount = row.totalAmount-parseFloat(row.discountAmount);
                if (row.totalAmount <= 0) {
                    if (row.unitprice > 0 || row.discountAmount > 0) {
                        row.discountAmount = 0;
                        row.totalAmount = parseFloat(row.amount)  - parseFloat($scope.isNaNCheck($scope.isUndefinedAndNullCheck(row.discountAmount)));
                        logger.logError("Total Amount should not be negative value");
                    }

                }

                productTotal = productTotal + (parseFloat(row.amount) - parseFloat($scope.isUndefinedAndNullCheck(row.discountAmount)));

               // productTotal = productTotal + (parseFloat(row.amount) - parseFloat($scope.isUndefinedAndNullCheck(row.discountAmount)));
                productWithTaxTotal = productWithTaxTotal + parseFloat(row.amount);
              //  grantamountGst =grantamountGst+ parseFloat(row.totalTaxPo);
                
            });
            
            $scope.purchaseInvoiceData.totalTaxPo = taxTotal;
            $scope.purchaseInvoiceData.discountAmount = $scope.isNaNCheck(discountTotal);
            $scope.purchaseInvoiceData.productTotal = $scope.isNaNCheck(productTotal);
            $scope.purchaseInvoiceData.productwithTaxTotal = $scope.isNaNCheck(productWithTaxTotal);
            $scope.purchaseInvoiceData.bcamount = $scope.purchaseInvoiceData.productwithTaxTotal;
         //   $scope.purchaseInvoiceData.grantamountGst = $scope.purchaseInvoiceData.totalTaxPo+$scope.purchaseInvoiceData.productwithTaxTotal;
            $scope.calculateTotalAmount();
            $scope.calculateTotalGSTAmount();
//            $scope.calculateTotalTnEWAmount();
        };
        
        
        
        
       
        
        
        
        
        
        
        
        
        
        
        
        
//        
//        $scope.calculateProductTaxAmount = function(purchanceInvoiceProductDetail) {
//            var productTaxTotal = 0.0;
//            var grantamountGst = 0.0;
//            angular.forEach(purchanceInvoiceProductDetail, function(row, index) {
//           
//
//            
//
//               // productTaxTotal = productTaxTotal + (parseFloat(row.totalTaxPo));
//                grantamountGst = grantamountGst + productWithTaxTotal;
//            });
//           // $scope.purchaseInvoiceData.productTotal = $scope.isNaNCheck(productTotal);
//            $scope.purchaseInvoiceData.grantamountGst = $scope.isNaNCheck(grantamountGst);
//           // $scope.purchaseInvoiceData.bcamount = $scope.purchaseInvoiceData.productwithTaxTotal;
//
//            $scope.calculateTotalAmount();
//            $scope.calculateTotalGSTAmount();
//            $scope.calculateTotalTAxAmount();
//        };
//        
        
        /*
        $scope.calculateTotalTnEWAmount = function() {
            $scope.purchaseInvoiceData.grantamount = (Number(($scope.purchaseInvoiceData.productwithTaxTotal + parseFloat($scope.purchaseInvoiceData.totalTaxPo))).toFixed(2)-Number($scope.purchaseInvoiceData.discountAmount).toFixed(2));
            $scope.purchaseInvoiceData.grantamount=    ($scope.purchaseInvoiceData.grantamount).toFixed(2);  
                };
               */
        
        $scope.calculateTotalAmount = function() {
//         //   $scope.purchaseInvoiceData.grantamount = $scope.purchaseInvoiceData.productwithTaxTotal + $scope.purchaseInvoiceData.chargeTotal + $scope.purchaseInvoiceData.ahTotal;
        // $scope.purchaseInvoiceData.grantamount = $scope.purchaseInvoiceData.productwithTaxTotal + $scope.purchaseInvoiceData.chargeTotal;discountAmount

         $scope.purchaseInvoiceData.grantamount = ($scope.purchaseInvoiceData.productwithTaxTotal + $scope.purchaseInvoiceData.chargeTotal )-($scope.purchaseInvoiceData.discountAmount);
         $scope.purchaseInvoiceData.grantamount= ($scope.purchaseInvoiceData.grantamount).toFixed(2);
           $scope.purOrderTotal = $scope.purchaseInvoiceData.productwithTaxTotal;

          if ($scope.purchaseInvoiceData.currency != undefined && $scope.purchaseInvoiceData.currency != null && $scope.purchaseInvoiceData.currency != '') {
                $scope.getExchangeRate($scope.purchaseInvoiceData.currency);
            }
       };
        
        
        $scope.calculateTotalGSTAmount = function() {
           // $scope.purchaseInvoiceData.totalTaxPo=0.9;
           // $scope.purchaseInvoiceData.discountAmount=0.9;
    $scope.purchaseInvoiceData.grantamountGst = (Number(($scope.purchaseInvoiceData.productwithTaxTotal)).toFixed(2)-Number($scope.purchaseInvoiceData.discountAmount).toFixed(2));
    $scope.purchaseInvoiceData.grantamountGst=    ($scope.purchaseInvoiceData.grantamountGst).toFixed(2);
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
            $http.get('app/purchaseinvoice/getPurchaseInvoiceDetail?purchaseInvoiceNo=' + purchaseInvoiceNo).success(function(data) {
//                data.supplier = (data.suppliertoString();
                data.grnNo = (data.grnNo).toString();
                angular.forEach(data.purchaseInvoiceProdDetail, function(row, index) {
                    row.itemId = (row.itemId).toString();
                    
                    if(row.costdtl !=null && row.costdtl != "" && row.costdtl != undefined)
                    row.costdtl = row.costdtl.toString();

                    row.prodDtlId = row.prodDtlId;
                    row = row;
                });
                $scope.purchaseInvoiceData = data;
//                angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceProdDetail, function(row, index) {
//                    $scope.purchaseInvoiceData.purchaseInvoiceProdDetail[index].taxAmount = 4555;
//                    $scope.purchaseInvoiceData.purchaseInvoiceProdDetail[index].discountAmount = 555555555555555;
//                });
                $scope.purchaseInvoiceData.supplier = data.supplier;
                $scope.purchaseInvoiceData.totalTaxPo = data.totalTaxPo;
                $scope.purchaseInvoiceData.potype = data.potype;
                $scope.purchaseInvoiceData.costCenter = data.costCenter;


//                $scope.poTypefun();
//                $scope.purchaseInvoiceData.budgetType = parseInt(data.budgetType);
                if (data.grnNo != undefined && data.grnNo != '' && data.grnNo != null && data.grnNo != 0) {

                    $http.get('app/purchaseinvoice/getEditcheckFreightCharges?grnNo=' + data.grnNo).success(function(response) {
                        if (response.frieghtTotal == undefined || response.frieghtTotal == null) {
                            response.frieghtTotal = 0;
                        }
                        if ($scope.purchaseInvoiceData.grnCode != "")
                            $scope.isGRNNo = true;
                        else
                            $scope.isGRNNo = false;

                        $scope.frieghtAmount = response.frieghtTotal;

                        $scope.poTotalAmount = response.poTotalAmount;

                    });
                }
                $scope.calculateAHAmount($scope.purchaseInvoiceData.purchaseInvoiceDetailacct);
                $scope.calculateChargeAmount($scope.purchaseInvoiceData.purchaseInvoiceDetail);
                $scope.calculateProductAmount($scope.purchaseInvoiceData.purchaseInvoiceProdDetail);
                $scope.calculateTotalGSTAmount();
                $scope.getSupplierAccountAttributeList();

              //  $scope.purchaseInvoiceData.costCenter = data.purchaseInvoiceProdDetail[0].costCenter;
                $scope.purchaseInvoiceData.employeeCode = data.purchaseInvoiceProdDetail[0].employeeCode;
                $scope.purchaseInvoiceData.countryCode = data.purchaseInvoiceProdDetail[0].countryCode;
                $scope.purchaseInvoiceData.customerCode = data.purchaseInvoiceProdDetail[0].customerCode;
                $scope.purchaseInvoiceData.supplierCode = data.purchaseInvoiceProdDetail[0].supplierCode;
                $scope.purchaseInvoiceData.designationCode = data.purchaseInvoiceProdDetail[0].designationCode;
                $scope.purchaseInvoiceData.companyCode = data.purchaseInvoiceProdDetail[0].companyCode;
                $scope.purchaseInvoiceData.costdtl = data.purchaseInvoiceProdDetail[0].costdtl;

                if (data.purchaseInvoiceProdDetail[0].assetCode != "" && data.purchaseInvoiceProdDetail[0].assetCode != undefined && data.purchaseInvoiceProdDetail[0].assetCode != null) {
                    $scope.purchaseInvoiceData.assetCode = (data.purchaseInvoiceProdDetail[0].assetCode).toString();
                }
                $scope.purchaseInvoiceData.departmentCode = data.purchaseInvoiceProdDetail[0].departmentCode;

                if ($scope.purchaseInvoiceData.employeeCode == "" || $scope.purchaseInvoiceData.employeeCode == undefined || $scope.purchaseInvoiceData.employeeCode == null) {
                    $scope.purchaseInvoiceData.employeeCode = "";
                }
                if ($scope.purchaseInvoiceData.departmentCode == "" || $scope.purchaseInvoiceData.departmentCode == undefined || $scope.purchaseInvoiceData.departmentCode == null) {
                    $scope.purchaseInvoiceData.departmentCode = "";
                }
                if ($scope.purchaseInvoiceData.countryCode == "" || $scope.purchaseInvoiceData.countryCode == undefined || $scope.purchaseInvoiceData.countryCode == null) {
                    $scope.purchaseInvoiceData.countryCode = "";
                }
                if ($scope.purchaseInvoiceData.customerCode == "" || $scope.purchaseInvoiceData.customerCode == undefined || $scope.purchaseInvoiceData.customerCode == null) {
                    $scope.purchaseInvoiceData.customerCode = "";
                }
                if ($scope.purchaseInvoiceData.supplierCode == "" || $scope.purchaseInvoiceData.supplierCode == undefined || $scope.purchaseInvoiceData.supplierCode == null) {
                    $scope.purchaseInvoiceData.supplierCode = "";
                }
                if ($scope.purchaseInvoiceData.designationCode == "" || $scope.purchaseInvoiceData.designationCode == undefined || $scope.purchaseInvoiceData.designationCode == null) {
                    $scope.purchaseInvoiceData.designationCode = "";
                }
                /*if ($scope.purchaseInvoiceData.costCenter == "" || $scope.purchaseInvoiceData.costCenter == undefined || $scope.purchaseInvoiceData.costCenter == null) {
                    $scope.purchaseInvoiceData.costCenter = "";
                }*/

                
                if ($scope.purchaseInvoiceData.costdtl == "" || $scope.purchaseInvoiceData.costdtl == undefined || $scope.purchaseInvoiceData.costdtl == null) {
                    $scope.purchaseInvoiceData.costdtl = "";
                }

                if ($scope.purchaseInvoiceData.companyCode == "" || $scope.purchaseInvoiceData.companyCode == undefined || $scope.purchaseInvoiceData.companyCode == null) {
                    $scope.purchaseInvoiceData.companyCode = "";
                }

                angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceDetail, function(row, index) {

                    if (row.assetCode != "" && row.assetCode != undefined && row.assetCode != null) {
                        row.assetCode = (row.assetCode).toString();
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
                    if (row.costCenter == "" || row.costCenter == undefined || row.costCenter == null) {
                        row.costCenter = "";
                    }
                    
                    if (row.costdtl == "" || row.costdtl == undefined || row.costdtl == null) {
                        row.costdtl = "";
                    }

                    if (row.companyCode == "" || row.companyCode == undefined || row.companyCode == null) {
                        row.companyCode = "";
                    }

                    if (row.assetCode == "" || row.assetCode == undefined || row.assetCode == null) {
                        row.assetCode = "";

                    }

                });
                
                
                angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceDetailacct, function(row, index) {

                  
                    if (row.ahaccountHeadCode == "" || row.ahaccountHeadCode == undefined || row.ahaccountHeadCode == null) {
                        row.ahaccountHeadCode = "";
                    }
                    if (row.ahshortDetail == "" || row.ahshortDetail == undefined || row.ahshortDetail == null) {
                        row.ahshortDetail = "";
                    }
                    if (row.ahamount == "" || row.ahamount == undefined || row.ahamount == null) {
                        row.ahamount = "";
                    }
                   

                });

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
        $scope.save = function(purchaseInvoiceForm, purchaseInvoiceData) {
            $scope.purchaseInvoiceData.amount = $scope.purchaseInvoiceData.grantamount;
            if (!$scope.edit) {
                if ($scope.purchaseInvoiceData.grantamount == $scope.purchaseInvoiceData.ahTotal) { // Function
                    // to
                    // check
                    // frieght
                    // values
                    if ($scope.isGRNNo) {
                        //alert("feightamount"+$scope.frieghtAmount)
                      //  if ($scope.purchaseInvoiceData.chargeTotal <= $scope.frieghtAmount) {
                          //  if (parseFloat($scope.purchaseInvoiceData.grantamount) <= parseFloat($scope.poTotalAmount)) { // PO
                                // Total
                                // and
                                // PI
                                // Grand
                                // Total..
                                angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceDetail, function(key, index) {
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
                                angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceDetailacct, function(key, index) {
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

                                delete $scope.purchaseInvoiceData['isEmployee'];
                                delete $scope.purchaseInvoiceData['isDepartment'];
                                delete $scope.purchaseInvoiceData['isLocation'];
                                delete $scope.purchaseInvoiceData['isCustomer'];
                                delete $scope.purchaseInvoiceData['isSupplier'];
                                delete $scope.purchaseInvoiceData['isDesignation'];
                                delete $scope.purchaseInvoiceData['isCostCenter'];
                                delete $scope.purchaseInvoiceData['isAsset'];
                                delete $scope.purchaseInvoiceData['isCompany'];
                                delete $scope.purchaseInvoiceData['attributeList'];
                                delete $scope.purchaseInvoiceData['isInvoiceNo'];

                                $http.post('app/purchaseinvoice/savePurInv', $scope.purchaseInvoiceData).success(function(result) {
                                    if (result == false) {
                                        logger.logError("Purchase Invoice Already Exist");
                                    } else {
                                        $location.path($stateParams.tenantid +'/hospital/accounts/purchaseInvoice/list');
                                        logger.logSuccess("Purchase Invoice added successfully");
                                    }
                                }).error(function(data) {
                                });
                           /* } else {
                                logger.logError("Item wise Total Should not be Greater than Purchase Order Total");
                            }*/
                       /* } else {
//                            logger.logError("Total charges should not exceed " + $scope.frieghtAmount);
                            logger.logError("Total charges should be match  with freight and others in PO");
                        
                        }*/

                    } else {
                        angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceDetail, function(key, index) {
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
                        
                        
                        
                        angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceDetailacct, function(key, index) {
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

                        delete $scope.purchaseInvoiceData['isEmployee'];
                        delete $scope.purchaseInvoiceData['isDepartment'];
                        delete $scope.purchaseInvoiceData['isLocation'];
                        delete $scope.purchaseInvoiceData['isCustomer'];
                        delete $scope.purchaseInvoiceData['isSupplier'];
                        delete $scope.purchaseInvoiceData['isDesignation'];
                        delete $scope.purchaseInvoiceData['isCostCenter'];
                        delete $scope.purchaseInvoiceData['isAsset'];
                        delete $scope.purchaseInvoiceData['isCompany'];
                        delete $scope.purchaseInvoiceData['attributeList'];
                        delete $scope.purchaseInvoiceData['isInvoiceNo'];

                        $http.post('app/purchaseinvoice/savePurInv', $scope.purchaseInvoiceData).success(function(result) {
                            if (result == false) {
                                logger.logError("Purchase Invoice Already Exist");
                            } else {
                                $location.path("/hospital/accounts/purchaseInvoice/list");
                                logger.logSuccess("Purchase Invoice added successfully");
                            }
                        }).error(function(data) {
                        });
                    }
                } else {
                    logger.logError("Account Head total amount and grand total amount Should Be Same");
                }

            } else {
                // update
                if ($scope.isGRNNo) {
                    angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceDetail, function(key, index) {
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
                    
                    
                    angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceDetailacct, function(key, index) {
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

                    delete $scope.purchaseInvoiceData['isEmployee'];
                    delete $scope.purchaseInvoiceData['isDepartment'];
                    delete $scope.purchaseInvoiceData['isLocation'];
                    delete $scope.purchaseInvoiceData['isCustomer'];
                    delete $scope.purchaseInvoiceData['isSupplier'];
                    delete $scope.purchaseInvoiceData['isDesignation'];
                    delete $scope.purchaseInvoiceData['isCostCenter'];
                    delete $scope.purchaseInvoiceData['isAsset'];
                    delete $scope.purchaseInvoiceData['isCompany'];
                    delete $scope.purchaseInvoiceData['attributeList'];
                    delete $scope.purchaseInvoiceData['isInvoiceNo'];
                    $http.post('app/purchaseinvoice/updatePurchaseInvoice', $scope.purchaseInvoiceData).success(function(result) {
                        if (result == false) {
                            logger.logError("Failed to update");
                        } else {
                            $location.path("/hospital/accounts/purchaseInvoice/list");
                            logger.logSuccess("Purchase Invoice updated successfully");
                        }
                    }).error(function(data) {
                    });
                } else {
                    angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceDetail, function(key, index) {
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
                    
                    angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceDetailacct, function(key, index) {
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

                    delete $scope.purchaseInvoiceData['isEmployee'];
                    delete $scope.purchaseInvoiceData['isDepartment'];
                    delete $scope.purchaseInvoiceData['isLocation'];
                    delete $scope.purchaseInvoiceData['isCustomer'];
                    delete $scope.purchaseInvoiceData['isSupplier'];
                    delete $scope.purchaseInvoiceData['isDesignation'];
                    delete $scope.purchaseInvoiceData['isCostCenter'];
                    delete $scope.purchaseInvoiceData['isAsset'];
                    delete $scope.purchaseInvoiceData['isCompany'];
                    delete $scope.purchaseInvoiceData['attributeList'];
                    delete $scope.purchaseInvoiceData['isInvoiceNo'];

                    $http.post('app/purchaseinvoice/updatePurchaseInvoice', $scope.purchaseInvoiceData).success(function(result) {
                        if (result == false) {
                            logger.logError("Failed to update");
                        } else {
                            $location.path("/hospital/accounts/purchaseInvoice/list");
                            logger.logSuccess("Purchase Invoice updated successfully");
                        }
                    }).error(function(data) {
                    });
                }
            }

        };

    });

    app.controller('tableCtrl', function($scope, $http, $filter, logger) {
        $scope.isSub = true;
        $scope.$watch('purchaseInvoiceData.purchaseInvoiceDetail[trIndex].accountHeadCode', function(newValue, oldValue) {
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

                    $http.get( 'app/commonUtility/getSubAccountCodeListNew?type=' + type).success(function(datas) {

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

                $http.get('app/commonUtility/getAttributesList?accountCode=' + newValue).success(function(datas) {
                    $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].attributeList = datas;

                    if (newValue == oldValue) {
                        $scope.isOnChange = false;
                    } else {
                        $scope.isOnChange = true;
                    }
                    if (!$scope.edit || $scope.isOnChange) {

                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].employeeCode = '';
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].departmentCode = '';
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].countryCode = '';
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].customerCode = '';
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].supplierCode = '';
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].designationCode = '';
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].costCenter = '';
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode = '';
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].assetCode = '';
                        
                        
                        $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].costCenter = '';

                    }

                    $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isEmployee = false;

                    $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isDepartment = false;

                    $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isLocation = false;
                    $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCustomer = false;
                    $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isSupplier = false;
                    $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isDesignation = false;
                    $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCostCenter = false;
                    $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCompany = false;

                    $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isAsset = false;
                    
                    $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isCostCenter = false;


                    angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].attributeList, function(row, rowindex) {
                        if (row.attributeName == "Employee") {
                            $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isEmployee = true;
                        } else if (row.attributeName == "Students") {
                            $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isDepartment = true;
                        } else if (row.attributeName == "Location") {
                            $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isLocation = true;
                        } else if (row.attributeName == "Customer") {
                            $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCustomer = true;
                        } else if (row.attributeName == "Supplier") {
                            $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isSupplier = true;
                        } else if (row.attributeName == "Designation") {
                            $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isDesignation = true;
                        } else if (row.attributeName == "Cost Center") {
                            $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCostCenter = true;
                        } else if (row.attributeName == "Company") {
                            $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCompany = true;
                        } else if (row.attributeName == "Asset") {
                            $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isAsset = true;
                        }
                        
                    });
                    
                    
                    
                    
                   
                }).error(function(datas) {
                });

                
                
              /*  $http.get('app/commonUtility/getAttributesList?accountCode=' + newValue).success(function(datas) {
                    $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].attributeList = datas;

                    if (newValue == oldValue) {
                        $scope.isOnChange = false;
                    } else {
                        $scope.isOnChange = true;
                    }
                    if (!$scope.edit || $scope.isOnChange) {

                        $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].employeeCode = '';
                        $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].departmentCode = '';
                        $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].countryCode = '';
                        $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].customerCode = '';
                        $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].supplierCode = '';
                        $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].designationCode = '';
                        $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].costCenter = '';
                        $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].companyCode = '';
                        $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].assetCode = '';
                        
                        

                    }

                    $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isEmployee = false;

                    $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isDepartment = false;

                    $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isLocation = false;
                    $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isCustomer = false;
                    $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isSupplier = false;
                    $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isDesignation = false;
                    $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isCostCenter = false;
                    $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isCompany = false;

                    $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isAsset = false;
                    


                    
                    angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].attributeList, function(row, rowindex) {
                        if (row.attributeName == "Employee") {
                            $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isEmployee = true;
                        } else if (row.attributeName == "Department") {
                            $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isDepartment = true;
                        } else if (row.attributeName == "Location") {
                            $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isLocation = true;
                        } else if (row.attributeName == "Customer") {
                            $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isCustomer = true;
                        } else if (row.attributeName == "Supplier") {
                            $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isSupplier = true;
                        } else if (row.attributeName == "Designation") {
                            $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isDesignation = true;
                        } else if (row.attributeName == "Cost Center") {
                            $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isCostCenter = true;
                        } else if (row.attributeName == "Company") {
                            $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isCompany = true;
                        } else if (row.attributeName == "Asset") {
                            $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isAsset = true;
                        }
                        
                    });
                   
                }).error(function(datas) {
                });*/

            }
        });

        
        
        
        
        
        
        
        
        
    });

    

    app.controller('tableCtrl1', function($scope, $http, $filter, logger) {
        $scope.isSub = true;
        $scope.$watch('purchaseInvoiceData.purchaseInvoiceDetailacct[trIndex].ahaccountHeadCode', function(newValue, oldValue) {
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

                    $http.get( $stateParams.tenantid +'/app/commonUtility/getSubAccountCodeListNew?type=' + type).success(function(datas) {

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

                $http.get('app/commonUtility/getAttributesList?accountCode=' + newValue).success(function(datas) {
                    $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].attributeList = datas;

                    if (newValue == oldValue) {
                        $scope.isOnChange = false;
                    } else {
                        $scope.isOnChange = true;
                    }
                    if (!$scope.edit || $scope.isOnChange) {

                        $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].employeeCode = '';
                        $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].departmentCode = '';
                        $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].countryCode = '';
                        $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].customerCode = '';
                        $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].supplierCode = '';
                        $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].designationCode = '';
                        $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].costCenter = '';
                        $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].companyCode = '';
                        $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].assetCode = '';
                        
                        
                        $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].costCenter = '';

                    }

                    $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isEmployee = false;

                    $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isDepartment = false;

                    $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isLocation = false;
                    $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isCustomer = false;
                    $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isSupplier = false;
                    $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isDesignation = false;
                    $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isCostCenter = false;
                    $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isCompany = false;

                    $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isAsset = false;
                    
                    $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isCostCenter = false;


                    angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].attributeList, function(row, rowindex) {
                        if (row.attributeName == "Employee") {
                            $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isEmployee = true;
                        } else if (row.attributeName == "Students") {
                            $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isDepartment = true;
                        } else if (row.attributeName == "Location") {
                            $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isLocation = true;
                        } else if (row.attributeName == "Customer") {
                            $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isCustomer = true;
                        } else if (row.attributeName == "Supplier") {
                            $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isSupplier = true;
                        } else if (row.attributeName == "Designation") {
                            $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isDesignation = true;
                        } else if (row.attributeName == "Cost Center") {
                            $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isCostCenter = true;
                        } else if (row.attributeName == "Company") {
                            $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isCompany = true;
                        } else if (row.attributeName == "Asset") {
                            $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isAsset = true;
                        }
                        
                    });
                    
                    
                    
                    
                   
                }).error(function(datas) {
                });

                
                
              /*  $http.get('app/commonUtility/getAttributesList?accountCode=' + newValue).success(function(datas) {
                    $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].attributeList = datas;

                    if (newValue == oldValue) {
                        $scope.isOnChange = false;
                    } else {
                        $scope.isOnChange = true;
                    }
                    if (!$scope.edit || $scope.isOnChange) {

                        $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].employeeCode = '';
                        $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].departmentCode = '';
                        $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].countryCode = '';
                        $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].customerCode = '';
                        $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].supplierCode = '';
                        $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].designationCode = '';
                        $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].costCenter = '';
                        $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].companyCode = '';
                        $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].assetCode = '';
                        
                        

                    }

                    $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isEmployee = false;

                    $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isDepartment = false;

                    $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isLocation = false;
                    $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isCustomer = false;
                    $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isSupplier = false;
                    $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isDesignation = false;
                    $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isCostCenter = false;
                    $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isCompany = false;

                    $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isAsset = false;
                    


                    
                    angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].attributeList, function(row, rowindex) {
                        if (row.attributeName == "Employee") {
                            $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isEmployee = true;
                        } else if (row.attributeName == "Department") {
                            $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isDepartment = true;
                        } else if (row.attributeName == "Location") {
                            $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isLocation = true;
                        } else if (row.attributeName == "Customer") {
                            $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isCustomer = true;
                        } else if (row.attributeName == "Supplier") {
                            $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isSupplier = true;
                        } else if (row.attributeName == "Designation") {
                            $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isDesignation = true;
                        } else if (row.attributeName == "Cost Center") {
                            $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isCostCenter = true;
                        } else if (row.attributeName == "Company") {
                            $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isCompany = true;
                        } else if (row.attributeName == "Asset") {
                            $scope.purchaseInvoiceData.purchaseInvoiceDetailacct[$scope.$index].isAsset = true;
                        }
                        
                    });
                   
                }).error(function(datas) {
                });*/

            }
        });

        
        
        
        
        
        
        
        
        
    //}); 
    
    
});