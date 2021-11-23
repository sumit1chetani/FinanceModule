//define([ 'hospital/purchase/purchase' ], function(module) {

    'use strict';
    app.controller('orderdciAddCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, $stateParams, $filter, validationService) {

        var globalId = 1;
        var purchaseQty = 0;
        // $scope.checkiteminPO = [];
        $scope.validate = function(PurchaseOrderForm, purchaseOrder) {
            if (new validationService().checkFormValidity($scope.PurchaseOrderForm)) {
                if (!$rootScope.isEdit) {
                    $scope.BudgetAmount(PurchaseOrderForm, purchaseOrder);
                } else {
                    $scope.update(PurchaseOrderForm, purchaseOrder);

                }
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.PurchaseOrderForm.$validationSummary), 555000, 'trustedHtml');
                // toaster.pop('error', "Please fill the required fields",
                // logger.getErrorHtmlNew($scope.PurchaseOrderForm.$validationSummary),
                // 555000, 'trustedHtml');

            }
        };

        $scope.deletedIds = [];
        $scope.purchaseData = {
            vendorId : '',
            city : '',
            state : '',
            zipcode : '',
            country : '',
            desCity : '',
            desState : '',
            desZipcode : '',
            desCountry : '',
            meterialrequest : false,
            quotation : false
        };
        $scope.purchaseOrder = {
            vendorId : '',
            locationId :5620,
            purchaseFor : '',
            companyId : '',
            costcenter : '',
            purchaseOrderDate : '',
            reqType : 'PO',
            purchaseType : '31',
            statusId : '',
            termsCondition : '',
            remarks : '',
            remarksforother : '',
            advanceamt : '',
            currency : 'INR',
            budgetType : '',
            purchaseOrderNum : '',
            otherCharges : '',
            freight : '',
            freightTax : '',
            freightAmount : '',
            paymentTerms : '25',
            purchaseFor : '28',
            purchaseStatus:'',
        /*
         * deleiverySchedule : ''
         */
        };

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
            discountPercent : '',
            potype : '',
            woType : ''

        }
        // PQ

        $scope.purchaseQuotation = {
            quotationNo : '',
            quoteDate : '',
            purchaseFor : '',
            purchaseType : '',
            vendorId : '',
            validFromDate : '',
            validToDate : '',
            paymentTerms : '',
            fixedPrice : 'N',
            fixedQty : 'N',
            subTotal : 0,
            totalDiscount : 0,
            totalTax : 0,
            grandTotal : 0,
            companyId : '',
            vendorLocId : '',
            vendorLocName : '',
            poNumber : '',
            quotationDetailList : []
        };

        $scope.requestTypeDropDown = [ {
            id : 'PO',
            text : 'Purchase Order'
        }, {
            id : 'WO',
            text : 'Work Order'
        } ];

        
        
        
        $scope.requestTypeDropDownnew = [ {
            id : '28',
            text : 'Stock'
        }, {
            id : '30',
            text : 'Consumable'
        },
        {
            id : '29',
            text : 'Asset'
        }];


        
        
        $scope.purchaseTypeListNew  = [ {
            id : '31',
            text : 'Regular'
        }, {
            id : '32',
            text : 'Rate Contract'
        },
        {
            id : '124',
            text : 'Consignment'
        }];

        $scope.requestTypeOrderDropDown = [ {
            id : 'Capex WO',
            text : 'Capex WO'
        }, {
            id : 'Revex WO',
            text : 'Revex WO'
        } ];
        $scope.uomCategoryList = [];

        $http.get("app/hospital/inventory/manageUOM/uomCategoryList").success(function(datas) {
            $scope.uomCategoryList = datas.uomCategoryList;
        });
        var currentDate = new Date();
        currentDate = ('0' + currentDate.getDate()).slice(-2) + "/" + ('0' + (Number(currentDate.getMonth()) + 1)).slice(-2) + "/" + currentDate.getFullYear();
        $scope.purchaseOrder.purchaseOrderDate = currentDate;
        $rootScope.isEdit = false;
        $rootScope.check = false;
        $scope.isCancel = false;
        $scope.cancel = function() {
            $scope.isCancel = true;
            // if()
            $scope.deleteonclickreset();
            $scope.tableDetails1 = [];
            $scope.purchaseQuotation.quotationDetailList = [];
            $state.go("app.sea.orderdci.list");
        };
        $scope.viewCancel = function() {
            //$state.go("app.hospital.purchase.purchaseOrder.list");
            $state.go("app.sea.orderdci.list");
        }
        $scope.rowCollectionItem = [];
        $scope.displayedCollectionItem = [];
        $scope.purchaseOrder.quotationDetailList = [];

        $scope.destinationList = [];
        $scope.addressList = [];
        $scope.vendorList = [];
        $scope.location = {};
        $scope.vendor = {};
        $scope.potypelist = [];
        $scope.termsAndConditions = "";
        $scope.getListOfDropdowns = function() {
            $http.get('app/purchaseOrder/getListOfDropdowns').success(function(data) {
                if (data.success == true) {
                    $scope.purchaseForList = data.purchaseFrom;
                    // $scope.hospitalList=data.companyList;
                    $scope.destinationList = data.locationList;
                    $scope.addressList = data.commonUtilityBeans;
//                    $scope.purchaseTypeList = data.purchaseTo;
                    $scope.vendorList = data.vendorList;
                    $scope.statusList = data.purchaseStatus;
//                    $scope.purchaseOrder.purchaseType = "43";
                    $scope.purchaseOrder.statusId = "46";
                    $scope.purchaseOrder.termsCondition = data.termsAndConditions;
                    $scope.termsAndConditions = data.termsAndConditions;
                }
            });

            $http.get(  $stateParams.tenantid + '/app/commonUtility/getCompanyListPurchase').success(function(datas) {
                $scope.hospitalList = datas;
            }).error(function(datas) {
            });

            $scope.getDropdownvalue = function() {

                // $http.get('app/hospital/purchase/consignmentRequest/employeeList').success(function(datas)
                // {
                // $scope.costList = datas.costList;
                // });
                $http.get('app/purchaseOrder/currencyList').success(function(datas) {
                    $scope.currencyList = datas;
                });

            }
            $scope.getDropdownvalue();
        };
        $scope.getListOfDropdowns();

        /*
         * var data1 ={ 'id':'Select', 'text':'Select' };
         * $scope.potypelist.push(data1);
         */
        var data2 = {
            'id' : 'Capex PO',
            'text' : 'Capex PO'
        };
        $scope.potypelist.push(data2);
        var data3 = {
            'id' : 'Revex PO',
            'text' : 'Revex PO'
        };
        $scope.potypelist.push(data3);

        $scope.budgetType = false;

        $scope.po_req_Type = true;
        $scope.$watch("purchaseOrder.reqType", function(newValue, oldValue) {
            var po_reqtype = $scope.purchaseOrder.reqType;
            if (po_reqtype != null && po_reqtype != undefined && po_reqtype != '') {
                if (po_reqtype == 'WO') {
                    $scope.po_req_Type = false;
                    $scope.getCompanydropdowm($scope.purchaseOrder.companyId)
                } else {
                    $scope.po_req_Type = true;
                    $scope.getCompanydropdowm($scope.purchaseOrder.companyId)

                }
            }
        });
        $scope.$watch("purchaseOrder.potype", function(newValue, oldValue) {

            var potype = $scope.purchaseOrder.potype;

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

                    $scope.purchaseOrder.purchaseOrderNum = data.message;
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

        });

        // Purchase Date validation
        $scope.$watch("purchaseOrder.purchaseOrderDate", function(newValue, oldValue) {
            if (!$scope.isEdit) {

                var date = $scope.purchaseOrder.purchaseOrderDate;
                var currentDate1 = new Date();
                var date1 = new Date(currentDate1);
                date1.setDate(date1.getDate() - 4);
                // document.write(date1);
                // alert(date1);
                var PickedDate = newValue.split("/");
                var PickedDate1 = new Date(+PickedDate[2], PickedDate[1] - 1, +PickedDate[0]);
                var date2 = new Date(newValue);
                date2.setDate(date2.getDate());
                //             

                if (PickedDate1 < date1) {
                    logger.logError("Purchase Order Date allow only Three days before !!");
                    var currentDate = new Date();
                    currentDate = ('0' + currentDate.getDate()).slice(-2) + "/" + ('0' + (Number(currentDate.getMonth()) + 1)).slice(-2) + "/" + currentDate.getFullYear();

                    $scope.purchaseOrder.purchaseOrderDate = currentDate;
                }
            }
        });

        $scope.type = false;

        $scope.chkAll = false;
        $scope.checkAll = function(rowCollectionItem, checkBox) {
            if (checkBox) {
                $scope.chkAll = true;
            } else {
                $scope.chkAll = false;
            }
            angular.forEach($scope.rowCollectionItem, function(value, key) {
                value.select = $scope.chkAll;
            });
        };

        $scope.loadVendorAddress = function() {
            var foundItemVen = $filter('filter')($scope.vendorList, {
                id : $scope.purchaseOrder.vendorId
            })[0];
            var indexVen = $scope.vendorList.indexOf(foundItemVen);
            if (indexVen > -1) {
                $scope.purchaseData.desCity1 = $scope.vendorList[indexVen].city;
                $scope.purchaseData.desAddress1 = $scope.vendorList[indexVen].address;
                $scope.purchaseData.desState1 = $scope.vendorList[indexVen].state;
                $scope.purchaseData.desCountry1 = $scope.vendorList[indexVen].country;
                $scope.purchaseData.desZipcode1 = $scope.vendorList[indexVen].zipCode;
                // $scope.purchaseOrder.paymentTerms=
                // $scope.vendorList[indexVen].paymentTerms;
            } else {
                $scope.purchaseData.desCity1 = '';
                $scope.purchaseData.desAddress1 = '';
                $scope.purchaseData.desState1 = '';
                $scope.purchaseData.desCountry1 = '';
                $scope.purchaseData.desZipcode1 = '';
                $scope.purchaseData.paymentTerms = '';
            }
        };
        var subTotal1 = 0;
        $scope.$watch("purchaseOrder.vendorId", function(newValue, oldValue) {
            var vendorId = $scope.purchaseOrder.vendorId;
//            $scope.getVendordetails(vendorId);

         /*   if (newValue != "" && newValue != undefined && newValue != null) {
                if (oldValue != "" && oldValue != undefined && oldValue != null) {
                    if ($scope.isEdit == false) {
                        if (oldValue != newValue) {
                            // $scope.rowCollectionItem = [];
                            $scope.purchaseOrder.subTotal = 0;
                            $scope.purchaseOrder.totalTaxCGST = 0;
                            $scope.purchaseOrder.totalTaxSGST = 0;
                            $scope.purchaseOrder.totalTaxIGST = 0;

                            $scope.purchaseOrder.totalDiscount = 0;
                            $scope.purchaseOrder.totalTax = 0;
                            $scope.purchaseOrder.freight = 0;
                            $scope.purchaseOrder.otherCharges = 0;
                            $scope.purchaseOrder.totalAmount = 0;

                        }
                    }
                }
                console.log($scope.vendorList);
                
                 * angular.forEach($scope.vendorList, function(value, key) { if
                 * (value.id == newValue) { if ($scope.isEdit == false) {
                 * $scope.purchaseOrder.paymentTerms = value.paymentTerms; }
                 *  } });
                 
            }*/

        });
        var cityId;
        $scope.getVendordetails = function(vendorId) {
            // if (cityId != '' && cityId != undefined) {
            // $http.get('app/purchaseOrder/getVendordetails?vendorId=' +
            // vendorId).success(function(datas) {
            $http.get("hospital/purchase/quotation/getVendorDetails?vendorId=" + vendorId).success(function(response) {

                if (response.success == true) {
                    $scope.purchaseData.desCity1 = response.purchaseQuotation.cityName;
                    $scope.purchaseData.desState1 = response.purchaseQuotation.state;
                    $scope.purchaseData.desZipcode1 = response.purchaseQuotation.zipcode;
                    $scope.purchaseData.desCountry1 = response.purchaseQuotation.country;
                    $scope.purchaseData.desAddress1 = response.purchaseQuotation.vendorAddress;
                }

                else {
                    $scope.purchaseData.desCity1 = "";
                    $scope.purchaseData.desState1 = "";
                    $scope.purchaseData.desZipcode1 = "";
                    $scope.purchaseData.desCountry1 = "";
                    $scope.purchaseData.desAddress1 = "";

                }
            }).error(function(data) {
            });

        }
        $scope.loadDestAddress = function() {
            var foundItemDest = $filter('filter')($scope.destinationList, {
                id : $scope.purchaseOrder.locationId
            })[0];
            var indexDest = $scope.destinationList.indexOf(foundItemDest);
            if (indexDest > -1) {
                $scope.purchaseData.desCity = $scope.destinationList[indexDest].city;
                $scope.purchaseData.desAddress = $scope.destinationList[indexDest].address;
                $scope.purchaseData.desState = $scope.destinationList[indexDest].state;
                $scope.purchaseData.desCountry = $scope.destinationList[indexDest].country;
                $scope.purchaseData.desZipcode = $scope.destinationList[indexDest].zipCode;
            } else {
                $scope.purchaseData.desCity = '';
                $scope.purchaseData.desAddress = '';
                $scope.purchaseData.desState = '';
                $scope.purchaseData.desCountry = '';
                $scope.purchaseData.desZipcode = '';
            }
        };

        $scope.purchaseOrder['subTotal'] = 0.0;
        $scope.purchaseOrder['totalDiscount'] = 0.0;
        $scope.purchaseOrder['totalTax'] = 0.0;
        $scope.purchaseOrder['freight'] = 0.0;

        
        
//         Budget Amount Validation
        
        $scope.BudgetAmount = function(form,purchaseOrderBean){
            $scope.formdata = form;
            $scope.formdataNew = purchaseOrderBean;
             if( purchaseOrderBean.totalAmount == '' ||  purchaseOrderBean.totalAmount == null ||
                     purchaseOrderBean.totalAmount == undefined){
                 purchaseOrderBean.totalAmount = 0;
             }
             $scope.po = {
                     budgetType : purchaseOrderBean.budgetType,
                     costcenter : purchaseOrderBean.costcenter
             }
        $http.post('app/purchaseOrder/geYearlytBudgetAmount',  $scope.po).success(function(datas) {
           $scope.budgetAmt = datas.budgetAmt;
           $scope.budgetUtilizedAmt = datas.budgetUtilizedAmt;
           $scope.budgetBalAmt = datas.budgetBalAmt;
            
           if(Number(datas.budgetBalAmt) < Number(purchaseOrderBean.totalAmount))
//           if(Number(purchaseOrderBean.totalAmount) < Number(datas.budgetBalAmt))
//            if(1==1)
                {
                ngDialog.open({
                    template : 'views/sea/orderdci/purchaseOrderBudgetView',
                    
                    scope :$scope
                });
                }else{
                  
                    $scope.save(form, purchaseOrderBean);
                   
                }
        });
    }
    
    $scope.Yes = function(){
        ngDialog.close();
        $scope.save($scope.formdata, $scope.formdataNew);
    }
    $scope.Noo = function(){
        ngDialog.close();
    }
    
//        END         
        
        
        
        $scope.save = function(form, purchaseOrderBean) {

            var isQty = false;
            var isVendorQty = true;

            $scope.purchaseOrder = {

            }
            // $scope.calculationDiscDetails($scope.rowCollectionItem);
            $scope.loadcalculation($scope.rowCollectionItem);
            if ($scope.purchaseOrderDetails.length > 0) {
                // purchaseOrderBean["purchaseOrderDetails"] =
                // $scope.purchaseOrderDetails;
                purchaseOrderBean["purchaseOrderDetails"] = $scope.purchaseOrderDetails;

                var tableEnteredData = purchaseOrderBean;
                angular.forEach($scope.rowCollectionItem, function(value, key) {
                    if (value.quantity <= 0) {
                        isQty = true;
                    }
                });

                if (isQty) {
                    logger.logError("Quantity Should be Greater than 0!");
                } else {
                    /*
                     * for(var j=0;j< $scope.rowCollectionItem.length;j++){
                     * if($scope.rowCollectionItem[j].vendorMinQty!=undefined &&
                     * $scope.rowCollectionItem[j].vendorMinQty!=null &&
                     * $scope.rowCollectionItem[j].vendorMinQty!=null){
                     * if($scope.rowCollectionItem[j].quantity<
                     * $scope.rowCollectionItem[j].vendorMinQty){
                     * isVendorQty=false; } } } if(isVendorQty){
                     */
                    var termsCondition = tableEnteredData.termsCondition;
                    if (tableEnteredData.termsCondition != null && tableEnteredData.termsCondition != '' && tableEnteredData.termsCondition != undefined) {
                        var text = tableEnteredData.termsCondition;
                        text = text.replace(/\r?\n/g, '<br>');
                        var res = text.replace("–", "-");
                        tableEnteredData.termsCondition = res;
                    }
                    var poNo = tableEnteredData.purchaseOrderNum;
                    delete tableEnteredData.quotationDetailList;
                    
                    $http.post('app/purchaseOrder/savePurchaseOrder', tableEnteredData).success(function(result) {
                        console.log(result);
                        if (result.success) {
                            logger.logSuccess("Purchase Order  added successfully");
                            if (result.type != poNo) {
                                logger.logSuccess(result.message);
                            }
                            //$state.go("app.hospital.purchase.purchaseOrder.list");
                            $state.go("app.sea.orderdci.list");
                        } else {
                            $scope.purchaseOrder.termsCondition = termsCondition;
                            // $scope.deleteonclickreset();
                            logger.logError("Purchase does not added.Something went wrong.");
                            return false;
                        }
                    });
                    /*
                     * }else{ logger.logError("Quantity Cannot Be Lower than
                     * Vendor Miniumum Quantity."); }
                     */

                }

            } else {
                logger.logError("Atleast one item should be present");
            }
        };

        $scope.update = function(purchaseOrderForm, purchaseOrderBean) {
            var isVendorQty = true;
            var isQty = false;
            $scope.loadUpdateCalculation($scope.rowCollectionItem);

            if ($scope.purchaseOrderDetails.length > 0) {
                purchaseOrderBean["purchaseOrderDetails"] = $scope.purchaseOrderDetails;
                delete purchaseOrderBean.purchaseQuoteDetails;
                purchaseOrderBean.isDeletedIds = $scope.deletedIds;
                var tableEnteredData = purchaseOrderBean;

                angular.forEach($scope.rowCollectionItem, function(value, key) {
                    if (value.quantity <= 0) {
                        isQty = true;
                    }
                });

                if (isQty) {
                    logger.logError("Quantity Should be Greater than 0!");
                } else {
                    /*
                     * for(var j=0;j<$scope.rowCollectionItem.length;j++){
                     * if($scope.rowCollectionItem[j].vendorMinQty!=undefined &&
                     * $scope.rowCollectionItem[j].vendorMinQty!=null &&
                     * $scope.rowCollectionItem[j].vendorMinQty!=null){ var qty=
                     * Number($scope.rowCollectionItem[j].quantity); var
                     * vendotqty=
                     * Number($scope.rowCollectionItem[j].vendorMinQty);
                     * alert("Qty") if(qty<vendotqty){ isVendorQty=false; } } }
                     * if(isVendorQty){
                     */

                    // if (tableEnteredData.potype == "Revex PO") {
                    // // tableEnteredData.budgetType = 0;
                    // }
                    var termsCondition = tableEnteredData.termsCondition;
                    if (tableEnteredData.termsCondition != null && tableEnteredData.termsCondition != '' && tableEnteredData.termsCondition != undefined) {
                        var text = tableEnteredData.termsCondition;
                        text = text.replace(/\r?\n/g, '<br>');
                        var res = text.replace("–", "-");
                        tableEnteredData.termsCondition = res;
                    }
                    delete tableEnteredData.quotationDetailList;
                    $http.post('app/purchaseOrder/updatePurchaseOrder', tableEnteredData).success(function(result) {
                        console.log(result);
                        if (result.success) {
                            logger.logSuccess("Purchase Order  Updated Successfully");
                           // $state.go("app.hospital.purchase.purchaseOrder.list");
                            $state.go("app.sea.orderdci.list");
                        } else {
                            $scope.purchaseOrder.termsCondition = termsCondition;
                            logger.logError("Purchase does not added.Something went wrong.");
                            return false;
                        }
                    });
                    /*
                     * }else{ logger.logError("Quantity Cannot Be Lower than
                     * Vendor Miniumum Quantity."); }
                     */

                }

            } else {
                logger.logError("Atleast one item should be present");
            }
        };
        $scope.addPurchaseRow = function(purchaseOrder) {
            $scope.tableDetails1 = [];
            debugger;
            $rootScope.purchaseOrder = purchaseOrder;
            if ($scope.purchaseOrder.companyId != undefined && $scope.purchaseOrder.companyId != null && $scope.purchaseOrder.companyId != '') {
                if ($scope.purchaseOrder.vendorId != undefined && $scope.purchaseOrder.vendorId != null && $scope.purchaseOrder.vendorId != '') {
                    if ($scope.purchaseOrder.reqType != undefined && $scope.purchaseOrder.reqType != null && $scope.purchaseOrder.reqType != '') {
                        if ($scope.purchaseOrder.potype != undefined && $scope.purchaseOrder.potype != null && $scope.purchaseOrder.potype != '') {
                            // $scope.callDialog($scope, 0, $http, ngDialog,
                            // logger,
                            // $injector, sharedProperties, toaster,
                            // $rootScope);

                            $scope.getCompanydropdowm($scope.purchaseOrder.companyId);
                            $scope.showPurchaseQuotationDetailDialog($scope, 0, $http, ngDialog, logger, $injector,$stateParams, sharedProperties, toaster, $rootScope,$scope.purchaseOrder.purchaseOrderNum);
                        } else {
                            logger.logError("Please select PO Type to add Purchase Order!");
                        }
                    } else {
                        logger.logError("Please select Request Type to add Purchase Order!");
                    }
                } else {
                    logger.logError("Please select a vendor to add Purchase Order!");
                }
            } else {
                logger.logError("Please select a Organization to add Purchase Order!");
            }
        };

        $scope.callDialog = function($scope, requestCode, $http, ngDialog, logger, $injector, sharedProperties, toaster,$stateParams, $rootScope) {
            requestCode = angular.copy($scope.vendor, requestCode);
            ngDialog.open({
                scope : $scope,
                template : 'views/sea/orderdci/orderdciRequestAdd',
                controller : $controller('purchaseOrderRequestAddCtrl', {
                    $scope : $scope,
                    requestCode : requestCode,
                    $http : $http,
                    ngDialog : ngDialog,
                    logger : logger,
                    $injector : $injector,
                    sharedProperties : sharedProperties,
                    toaster : toaster,
                    $rootScope : $rootScope
                }),
                className : 'ngdialog-theme-plain',
                showClose : false,
                closeByDocument : false,
                closeByEscape : false,
                preCloseCallback : $scope.getList
            });
        };
        $scope.showPurchaseQuotationDetailDialog = function($scope, requestCode, $http, ngDialog, logger, $injector, sharedProperties,$stateParams, toaster, $rootScope, poNumber) {
            requestCode = angular.copy($scope.vendor, requestCode);
            ngDialog.open({
                scope : $scope,
                template : 'views/sea/orderdci/purchaseQuotationRequestAdd',
                controller : $controller('purchaseQuotationDetailCtrlPO', {
                    $scope : $scope,
                    requestCode : requestCode,
                    $http : $http,
                    ngDialog : ngDialog,
                    logger : logger,
                    $injector : $injector,
                    sharedProperties : sharedProperties,
                    toaster : toaster,
                    $rootScope : $rootScope,
                    poNumber : poNumber
                }),
                className : 'ngdialog-theme-plain',
                showClose : false,
                closeByDocument : false,
                closeByEscape : false
            });
        }

        var gblLength = 0;
        $scope.getListValue = function(data, addQuoteStatus) {
            gblLength = 0;
            var isDetailSelected = false;
            var isExists = 0;
            var isFreight = 0;
            var isSelect = 0;

            // $scope.pur
            if (data != undefined) {
                for (var i = 0; i < data.length; i++) {
                    isExists = 0;

                    if (data[i].isSelected) {
                        isDetailSelected = true;
                        if ($scope.purchaseData.vendorId != undefined) {
                            data[i].vendorId = $scope.purchaseData.vendorId;
                            data[i].vendorName = $scope.vendor.text;
                        }
                        data[i].isSelected = false;

                        data[i].unitPrice = Number(data[i].unitPrice).toFixed(2);
                        data[i].price = Number(Number(data[i].quantity) * data[i].unitPrice).toFixed(2);
                        data[i].statusId = addQuoteStatus;

                        /*
                         * if ($scope.purchaseOrder.paymentTerms == 0 ||
                         * $scope.purchaseOrder.paymentTerms == null ||
                         * $scope.purchaseOrder.paymentTerms == '') {
                         * $scope.purchaseOrder.paymentTerms =
                         * data[i].paymentTerms; }
                         */

                        angular.forEach($scope.rowCollectionItem, function(value, key) {
                            if (value.purchaseRequestNum == data[i].purchaseRequestNum && value.purchaseItemName == data[i].purchaseItemName) {
                                isExists = 1;
                            }
                        });

                        if (isExists == 1) {
                            /*
                             * logger.logError("Selected Purchase Requisition No
                             * and Item Name Already Exists!");
                             */
                        } else {
                            if (data[i].frieght != null) {
                                var isFrieghtExist = true;
                                angular.forEach($scope.rowCollectionItem, function(value1, key1) {
                                    if (value1.purchaseQuoteId == data[i].purchaseQuoteId) {
                                        isFrieghtExist = false;
                                    }
                                });
                                if (isFrieghtExist == true) {
                                    isFreight = isFreight + data[i].frieght;
                                }
                            }

                            if (Number(data[i].quantity) < Number(data[i].vendorMinQty)) {
                                data[i].quantity = Number(data[i].vendorMinQty);
                            }

                            $scope.rowCollectionItem.push(data[i]);
                            if (isDetailSelected) {
                                ngDialog.close();
                            } else {
                                logger.logError("Please select an item to add purchase Order!");
                            }

                        }

                        isSelect = 1;

                    }

                }

                if (isSelect == 0) {
                    logger.logError("Please Select Atleast One Row!");
                }

                if ($scope.purchaseOrder.freight != undefined && $scope.purchaseOrder.freight != null && $scope.purchaseOrder.freight != '') {
                    // $scope.purchaseOrder.freight =
                    // Number($scope.purchaseOrder.freight) + isFreight;
                } else {
                    // $scope.purchaseOrder.freight = isFreight;
                }
            } else {
                logger.logError("Please Filter a purchase Quote and add an item!");
            }
            gblLength = 0;
            $scope.calculateMultiTax();
        };
        $scope.getListValue1 = function(data, addQuoteStatus) {
            gblLength = 0;
            var isDetailSelected = false;
            var isExists = 0;
            var isFreight = 0;
            var isSelect = 0;

            // $scope.pur
            if (data != undefined) {
                for (var i = 0; i < data.length; i++) {
                    isExists = 0;
                    ngDialog.close();
                    // if (data[i].isSelected) {
                    isDetailSelected = true;
                    if ($scope.purchaseData.vendorId != undefined) {
                        data[i].vendorId = $scope.purchaseData.vendorId;
                        data[i].vendorName = $scope.vendor.text;
                    }
                    // data[i].isSelected = false;

                    data[i].unitPrice = Number(data[i].unitPrice).toFixed(2);
                    data[i].price = Number(Number(data[i].quantity) * data[i].unitPrice).toFixed(2);
                    if (data[i].discount != 0 && data[i].discount != null) {
                        data[i].netPrice = Number((Number(data[i].quantity) * data[i].unitPrice) - Number(data[i].discount)).toFixed(2);

                    } else {
                        data[i].netPrice = Number((Number(data[i].quantity) * data[i].unitPrice)).toFixed(2);

                    }
                    data[i].statusId = addQuoteStatus;
                    $scope.calculateTaxDiscount(data[i]);

                    /*
                     * if ($scope.purchaseOrder.paymentTerms == 0 ||
                     * $scope.purchaseOrder.paymentTerms == null ||
                     * $scope.purchaseOrder.paymentTerms == '') {
                     * $scope.purchaseOrder.paymentTerms = data[i].paymentTerms; }
                     */

                    // angular.forEach($scope.rowCollectionItem, function(value,
                    // key) {
                    // if (value.purchaseRequestNum ==
                    // data[i].purchaseRequestNum && value.purchaseItemName ==
                    // data[i].purchaseItemName) {
                    // isExists = 1;
                    // }
                    // });
                    /*
                     * if (isExists == 1) { logger.logError("Selected Purchase
                     * Requisition No and Item Name Already Exists!"); } else {
                     * if (data[i].frieght != null) { var isFrieghtExist = true;
                     * angular.forEach($scope.rowCollectionItem,
                     * function(value1, key1) { if (value1.purchaseQuoteId ==
                     * data[i].purchaseQuoteId) { isFrieghtExist = false; } });
                     * if (isFrieghtExist == true) { isFreight = isFreight +
                     * data[i].frieght; } }
                     * 
                     * if (Number(data[i].quantity) <
                     * Number(data[i].vendorMinQty)) { data[i].quantity =
                     * Number(data[i].vendorMinQty); }
                     * 
                     * 
                     * $scope.rowCollectionItem.push(data[i]); if
                     * (isDetailSelected) { ngDialog.close(); } else {
                     * logger.logError("Please select an item to add purchase
                     * Order!"); } }
                     * 
                     * isSelect = 1;
                     */
                    // }
                }

                // if (isSelect == 0) {
                // logger.logError("Please Select Atleast One Row!");
                // }

                // if ($scope.purchaseOrder.freight != undefined &&
                // $scope.purchaseOrder.freight != null &&
                // $scope.purchaseOrder.freight != '') {
                // $scope.purchaseOrder.freight =
                // Number($scope.purchaseOrder.freight) + isFreight;
                // } else {
                // $scope.purchaseOrder.freight = isFreight;
                // }
            }
            // else {
            // logger.logError("Please Filter a purchase Quote and add an
            // item!");
            // }
            // gblLength = 0;
            $scope.calculateTotal();
        };
        $scope.calculateMultiTax = function() {

            if (gblLength <= $scope.rowCollectionItem.length) {

                i = 0;
                $scope.totalTaxAmount = 0;
                $scope.totalTaxPercentageValue = 0;
                $scope.quotationDetail.taxCode = "";
                console.log("Row collection");
                console.log($scope.rowCollectionItem);
                console.log($scope.rowCollectionItem[gblLength].quoteTaxDetail.taxIdslist);
                $scope.calculateTaxDetailsInitCalculate($scope.rowCollectionItem[gblLength], $scope.rowCollectionItem[gblLength].quoteTaxDetail.taxIdslist);
            }

        }

        $scope.loadcalculation = function(rowCollectionItem) {
            $scope.purchaseOrderDetails = [];

            angular.forEach(rowCollectionItem, function(key, index) {

                var discount = 0;
                var totalamount = key.netPrice;
                if (key.quoteTaxDetail.discountType == 59) {
                    rowCollectionItem[index].quoteTaxDetail.discountAmount = key.discount1;

                } else if (key.quoteTaxDetail.discountType == 58) {
                    rowCollectionItem[index].quoteTaxDetail.discountAmount = key.discount1;
                    rowCollectionItem[index].quoteTaxDetail.dicountPercentage = key.discount;

                } else {
                    rowCollectionItem[index].quoteTaxDetail.discountType = 14;
                }

            });

            for (var i = 0; i < rowCollectionItem.length; i++) {
                var obj = {
                    purchaseQuoteDetailId : rowCollectionItem[i].purchaseQuoteDetailId,
                    purchaseItemId : rowCollectionItem[i].itemId,
                    purchaseItemDesc : rowCollectionItem[i].purchaseItemDesc,
                    unitPrice : Number(rowCollectionItem[i].unitPrice).toFixed(2),
                    quantity : Number(rowCollectionItem[i].quantity).toFixed(2),
                    purchaseStatusId : rowCollectionItem[i].statusId,
                    discount : Number(rowCollectionItem[i].discount).toFixed(2),
                    purchaseUOM : rowCollectionItem[i].purchaseUOM,
                    vendorUOM : rowCollectionItem[i].uom,
                    purchaseUOMName : rowCollectionItem[i].purchaseUOMName,
                    purchaseQty : rowCollectionItem[i].purchaseQty,
                    costcenter : rowCollectionItem[i].costcenter,
                    // tax : Number(rowCollectionItem[i].tax).toFixed(2)
                    prRequestNo : rowCollectionItem[i].requisitionNo,
                    taxCGST : rowCollectionItem[i].quoteTaxDetail.taxCGST,
                    taxSGST : rowCollectionItem[i].quoteTaxDetail.taxSGST,
                    taxIGST : rowCollectionItem[i].quoteTaxDetail.taxIGST,
                    requisitionId : rowCollectionItem[i].requisitionId,
                    vendorQuantity : rowCollectionItem[i].vendorQuantity,
                    discountAmount : rowCollectionItem[i].quoteTaxDetail.discountAmount,
                    discountPercent : rowCollectionItem[i].quoteTaxDetail.dicountPercentage,
                    taxCGSTinPercent : rowCollectionItem[i].quoteTaxDetail.taxCGSTinPercent,
                    taxSGSTinPercent : rowCollectionItem[i].quoteTaxDetail.taxSGSTinPercent,
                    taxIGSTinPercent : rowCollectionItem[i].quoteTaxDetail.taxIGSTinPercent,
                    discountType : rowCollectionItem[i].quoteTaxDetail.discountType

                // purchaseQuoteId : ''
                };
                $scope.purchaseOrderDetails.push(obj);
            }
        };
        $scope.loadUpdateCalculation = function(rowCollectionItem) {
            $scope.purchaseOrderDetails = [];

            angular.forEach(rowCollectionItem, function(key, index) {

                var discount = 0;
                var totalamount = key.netPrice;
                if (key.quoteTaxDetail.discountType == 59) {
                    rowCollectionItem[index].quoteTaxDetail.discountAmount = key.discount1;

                } else if (key.quoteTaxDetail.discountType == 58) {
                    rowCollectionItem[index].quoteTaxDetail.discountAmount = key.discount1;
                    rowCollectionItem[index].quoteTaxDetail.dicountPercentage = key.discount;

                } else {
                    rowCollectionItem[index].quoteTaxDetail.discountType = 14;
                }

            });

            for (var i = 0; i < rowCollectionItem.length; i++) {
                var obj = {
                    purchaseQuoteDetailId : rowCollectionItem[i].purchaseQuoteDetailId,
                    purchaseItemId : rowCollectionItem[i].itemId,
                    purchaseItemDesc : rowCollectionItem[i].purchaseItemDesc,

                    unitPrice : Number(rowCollectionItem[i].unitPrice).toFixed(2),
                    quantity : Number(rowCollectionItem[i].quantity).toFixed(2),
                    purchaseStatusId : 72,
                    discount : Number(rowCollectionItem[i].discount).toFixed(2),
                    vendorUOM : rowCollectionItem[i].uom,

                    purchaseUOM : rowCollectionItem[i].purchaseUOM,
                    purchaseUOMName : rowCollectionItem[i].purchaseUOMName,
                    purchaseQty : rowCollectionItem[i].purchaseQty,
                    costcenter : rowCollectionItem[i].costcenter,
                    // tax : Number(rowCollectionItem[i].tax).toFixed(2),
                    edit : rowCollectionItem[i].edit,
                    purchaseOrderDetailId : rowCollectionItem[i].purchaseOrderDetailId,
                    prRequestNo : rowCollectionItem[i].requisitionNo,
                    taxCGST : rowCollectionItem[i].quoteTaxDetail.taxCGST,
                    taxSGST : rowCollectionItem[i].quoteTaxDetail.taxSGST,
                    taxIGST : rowCollectionItem[i].quoteTaxDetail.taxIGST,
                    requisitionId : rowCollectionItem[i].requisitionId,
                    vendorQuantity : rowCollectionItem[i].vendorQuantity,
                    discountAmount : rowCollectionItem[i].quoteTaxDetail.discountAmount,
                    discountPercent : rowCollectionItem[i].quoteTaxDetail.dicountPercentage,
                    taxCGSTinPercent : rowCollectionItem[i].quoteTaxDetail.taxCGSTinPercent,
                    taxSGSTinPercent : rowCollectionItem[i].quoteTaxDetail.taxSGSTinPercent,
                    taxIGSTinPercent : rowCollectionItem[i].quoteTaxDetail.taxIGSTinPercent,
                    discountType : rowCollectionItem[i].quoteTaxDetail.discountType
                // discountAmount :
                // rowCollectionItem[i].quoteTaxDetail.discountAmount,
                // discountPercent :
                // rowCollectionItem[i].quoteTaxDetail.dicountPercentage,
                // purchaseQuoteId : ''
                };
                $scope.purchaseOrderDetails.push(obj);
            }

        };
        $scope.gstGroup = [];
        $scope.$watch('destinationList', function(newVal, oldVal) {
            if (newVal.length > 0) {
                $scope.callEdit();
            }
        });
        var purchaseOrderId = $location.search().purchaseOrderId;
        $scope.callEdit = function() {
            if (purchaseOrderId != undefined) {
                var editUrl = 'app/purchaseOrder/editPurchaseOrder';
                $http({
                    url : editUrl,
                    params : {
                        "purchaseOrderId" : purchaseOrderId
                    },
                    method : "GET",
                    datatype : 'JSON',
                    'Accept' : 'application/json',
                    headers : {
                        'Content-Type' : 'application/json'
                    }

                }).success(function(data) {
                    if (data.termsCondition != null && data.termsCondition != '' && data.termsCondition != undefined) {
                        var text = data.termsCondition;
                        text = text.replace(/\r?<br>/g, '\n');
                        data.termsCondition = text;
                    }

                    // $rootScope.isEdit = true;
                    console.log("Edit dsfffffffffffff data is");
                    console.log(data);
                    // var termsforPayment = data.paymentTerms;
                    $scope.purchaseOrder = data;
                    $scope.purchaseOrder.purchaseOrderNum = data.purchaseOrderNum;
                    $scope.gstGroup = data.gstgropuList;
                    $scope.purchaseOrder.budgetType = data.budgetType.toString();
                    $scope.purchaseOrder.purchaseFor = data.purchaseFor;
                    $scope.purchaseOrder.purchaseStatus = data.purchaseStatus;

                    
//                       decimal
                    $scope.purchaseOrder.subTotal = Number(data.subTotal).toFixed(2);
                    $scope.purchaseOrder.totalDiscount = Number(data.totalDiscount).toFixed(2);
                    $scope.purchaseOrder.totalTaxCGST = Number(data.totalTaxCGST).toFixed(2);
                    $scope.purchaseOrder.totalTaxSGST = Number(data.totalTaxSGST).toFixed(2);
                    $scope.purchaseOrder.totalTaxIGST = Number(data.totalTaxIGST).toFixed(2);
                    $scope.purchaseOrder.freight = Number(data.freight).toFixed(2);
                    $scope.purchaseOrder.freightTax = Number(data.freightTax).toFixed(2);
                    $scope.purchaseOrder.freightAmount = Number(data.freightAmount).toFixed(2);
                    $scope.purchaseOrder.otherCharges = Number(data.otherCharges).toFixed(2);
                    $scope.purchaseOrder.totalAmount = Number(data.totalAmount).toFixed(2);
                    $scope.purchaseOrder.locationId = data.locationId.toString();
                    
                    angular.forEach($scope.gstGroup, function(row, index) {
                       
                        $scope.gstGroup[index].gstAmtgroupbyPercent = Number(row.gstAmtgroupbyPercent).toFixed(2);
                        
                    });
                    
//                    end
//                    data.locationId = data.locationId;
                    data.vendorId = data.vendorId.toString();
                    var foundLocation = $filter('filter')($scope.destinationList, {
                        id : data.locationId
                    })[0];
                    $scope.location = foundLocation;
                    $scope.location = data.locationId;
                    $scope.getAddDetails();
                    /*
                     * var foundVendorLocation =
                     * $filter('filter')($scope.vendorList, { id: data.vendorId
                     * })[0]; $scope.vendor = foundVendorLocation;
                     */

                    angular.forEach($scope.vendorList, function(value, key) {
                        if (data.vendorId == value.id) {
                            $scope.vendor.id = value.id;
                            $scope.vendor.text = value.text;
                        }
                    });

                    $scope.loadDestAddress();
                    $scope.loadVendorAddress();
                    if (data.statusId != null) {
                        $scope.purchaseOrder.statusId = data.statusId.toString();
                    }
                    if (data.purchaseFor != null) {
                        $scope.purchaseOrder.purchaseFor = data.purchaseFor.toString();
                    }
                    if (data.purchaseType != null) {
                        $scope.purchaseOrder.purchaseType = data.purchaseType.toString();
                    }
                    $scope.rowCollectionItem = data.purchaseQuoteDetails;

                    var datas = $scope.rowCollectionItem;
                    var subTotal = 0;
                    angular.forEach(datas, function(datas, index) {

                        if (datas.quantity <= 0) {
                            logger.logError("Quantity Should be Greater than 0!");
                            datas.quantity = '';
                        } else {
                            datas['finalTotal'] = 0;
                            datas['total'] = 0;
                            datas.price = Number(datas.price);
                            if (datas.quantity != null && angular.isString(datas.quantity)) {
                                datas.quantity = datas.quantity.replace(/[^0-9]/g, '');
                            }
                            datas.price = Number(Number(datas.quantity) * datas.unitPrice).toFixed(2);

                            // var discountTaxDetail = datas.quoteTaxDetail;
                            //
                            // // var unitIGST =
                            // // Number(datas.quoteTaxDetail.taxIGST) /
                            // // datas.vendorQuantity;
                            // // datas.quoteTaxDetail.taxIGST =
                            // // Number(Number(datas.quantity) *
                            // // Number(unitIGST)).toFixed(2);
                            // // var unitSGST =
                            // // Number(datas.quoteTaxDetail.taxSGST) /
                            // // datas.vendorQuantity;
                            // // datas.quoteTaxDetail.taxSGST =
                            // // Number(Number(datas.quantity) *
                            // // Number(unitSGST)).toFixed(2);
                            // // var unitCGST =
                            // // Number(datas.quoteTaxDetail.taxCGST) /
                            // // datas.vendorQuantity;
                            // // datas.quoteTaxDetail.taxCGST =
                            // // Number(Number(datas.quantity) *
                            // // Number(unitCGST)).toFixed(2);
                            //
                            // // if (discountTaxDetail.discountType ==
                            // "Amount") {
                            // // discountTaxDetail.discountAmount =
                            // discountTaxDetail.discountAmount ?
                            // discountTaxDetail.discountAmount : 0;
                            // // if (datas.vendorQuantity > 0) {
                            // // var unitDiscount =
                            // discountTaxDetail.discountAmount /
                            // datas.vendorQuantity;
                            // // datas.discount = Number(Number(datas.quantity)
                            // * Number(unitDiscount)).toFixed(2);
                            // // if (datas.discount != 0 && datas.discount !=
                            // null) {
                            // // datas.netPrice = Number(Number(datas.price) -
                            // datas.discount).toFixed(2);
                            // //
                            // // } else {
                            // // datas.netPrice =
                            // Number(datas.price).toFixed(2);
                            // // }
                            // //
                            // // } else {
                            // // datas.discount =
                            // Number(discountTaxDetail.discountAmount).toFixed(2);
                            // // if (datas.discount != 0 && datas.discount !=
                            // null) {
                            // // datas.netPrice = Number(Number(datas.price) -
                            // datas.discount).toFixed(2);
                            // //
                            // // } else {
                            // // datas.netPrice =
                            // Number(datas.price).toFixed(2);
                            // // }
                            // // }
                            // // } else if (discountTaxDetail.discountType ==
                            // "Percentage") {
                            // // discountTaxDetail.dicountPercentage =
                            // discountTaxDetail.dicountPercentage ?
                            // discountTaxDetail.dicountPercentage : 0;
                            // // datas.discount = Number(Number(datas.price) *
                            // (discountTaxDetail.dicountPercentage /
                            // 100)).toFixed(2);
                            // // if (datas.discount != 0 && datas.discount !=
                            // null) {
                            // // datas.netPrice = Number(Number(datas.price) -
                            // datas.discount).toFixed(2);
                            // //
                            // // } else {
                            // // datas.netPrice =
                            // Number(datas.price).toFixed(2);
                            // // }
                            // // } else {
                            // // // discountTaxDetail.dicountPercentage =
                            // // // discountTaxDetail.dicountPercentage ?
                            // // // discountTaxDetail.dicountPercentage : 0;
                            // // // datas.discount =
                            // // //
                            // Number(Number(datas.price)*(discountTaxDetail.dicountPercentage/100)).toFixed(2);
                            // // // if(datas.discount !=0 && datas.discount
                            // // // !=null){
                            // // // datas.netPrice = Number(Number(datas.price)
                            // -
                            // // // datas.discount).toFixed(2);
                            // // //
                            // // // }
                            // // // else{
                            // // datas.netPrice =
                            // Number(datas.price).toFixed(2);
                            // // // }
                            // // }
                            //                            
                            // // subTotal += Number(datas.price);
                            //
                            // datas.quoteTaxDetail.taxIGST =
                            // Number((datas.netPrice *
                            // ((datas.quoteTaxDetail.taxIGSTinPercent) /
                            // 100))).toFixed(2);
                            // datas.quoteTaxDetail.taxSGST =
                            // Number((datas.netPrice *
                            // ((datas.quoteTaxDetail.taxSGSTinPercent) /
                            // 100))).toFixed(2);
                            // datas.quoteTaxDetail.taxCGST =
                            // Number((datas.netPrice *
                            // ((datas.quoteTaxDetail.taxCGSTinPercent) /
                            // 100))).toFixed(2);
                            //
                            // if (datas.price >= datas.discount) {
                            // datas['total'] = Number(Number(datas.price) -
                            // Number(datas.discount)).toFixed(2);
                            // datas['finalTotal'] = 0;
                            // } else if (datas.price < datas.discount) {
                            // datas['total'] = Number(Number(datas.price) -
                            // Number(datas.discount)).toFixed(2);
                            // datas['finalTotal'] = 0;
                            // }
                            // datas['finalTotal'] = (Number(datas.total) +
                            // Number(datas.taxCGST) + Number(datas.taxSGST) +
                            // Number(datas.taxIGST)).toFixed(2);
                            //                            

                            var discountTaxDetail = datas.quoteTaxDetail;

                            var unitIGST = Number(datas.quoteTaxDetail.taxIGST) / datas.vendorQuantity;
                            datas.quoteTaxDetail.taxIGST = Number(Number(datas.quantity) * Number(unitIGST)).toFixed(2);
                            var unitSGST = Number(datas.quoteTaxDetail.taxSGST) / datas.vendorQuantity;
                            datas.quoteTaxDetail.taxSGST = Number(Number(datas.quantity) * Number(unitSGST)).toFixed(2);
                            var unitCGST = Number(datas.quoteTaxDetail.taxCGST) / datas.vendorQuantity;
                            datas.quoteTaxDetail.taxCGST = Number(Number(datas.quantity) * Number(unitCGST)).toFixed(2);

                            datas.netPrice = Number(Number(datas.price) - datas.quoteTaxDetail.discountAmount).toFixed(2);

                            /*
                             * if (discountTaxDetail.discountType == "Amount") {
                             * datas.quoteTaxDetail.discountType = 59; // //
                             * $scope.getAddDetails(); // if(data.purchaseType ==
                             * 'Percentage') //
                             * $scope.purchaseOrder.purchaseType = 58; // //
                             * $scope.getAddDetails();
                             * discountTaxDetail.discountAmount =
                             * discountTaxDetail.discountAmount ?
                             * discountTaxDetail.discountAmount : 0; if
                             * (datas.vendorQuantity > 0) { var unitDiscount =
                             * discountTaxDetail.discountAmount /
                             * datas.vendorQuantity; datas.discount =
                             * Number(Number(datas.quantity) *
                             * Number(unitDiscount)).toFixed(2); datas.discount1 =
                             * Number(Number(datas.quantity) *
                             * Number(unitDiscount)).toFixed(2);
                             * 
                             * datas.netPrice = Number(Number(datas.price) -
                             * datas.discount).toFixed(2);
                             *  } else { datas.discount =
                             * Number(discountTaxDetail.discountAmount).toFixed(2);
                             * datas.netPrice = Number(Number(datas.price) -
                             * datas.discount).toFixed(2);
                             *  } } else if (discountTaxDetail.discountType ==
                             * "Percentage") { datas.quoteTaxDetail.discountType =
                             * 58;
                             * 
                             * discountTaxDetail.dicountPercentage =
                             * discountTaxDetail.dicountPercentage ?
                             * discountTaxDetail.dicountPercentage : 0;
                             * datas.discount1 = Number(Number(datas.price) *
                             * (discountTaxDetail.dicountPercentage /
                             * 100)).toFixed(2); datas.netPrice =
                             * Number(Number(datas.price) -
                             * datas.discount1).toFixed(2); datas.discount =
                             * discountTaxDetail.dicountPercentage;
                             *  }
                             */

                            if (discountTaxDetail.discountType == "Amount") {
                                datas.quoteTaxDetail.discountType = 59;
                                // // $scope.getAddDetails();
                                // if(data.purchaseType == 'Percentage')
                                // $scope.purchaseOrder.purchaseType = 58;
                                // // $scope.getAddDetails();
                                discountTaxDetail.discountAmount = discountTaxDetail.discountAmount ? discountTaxDetail.discountAmount : 0;
                                if (datas.vendorQuantity > 0) {
                                    var unitDiscount = discountTaxDetail.discountAmount / datas.vendorQuantity;
                                    datas.discount = Number(Number(datas.quantity) * Number(unitDiscount)).toFixed(2);
                                    datas.discount1 = Number(Number(datas.quantity) * Number(unitDiscount)).toFixed(2);

                                    datas.netPrice = Number(Number(datas.price) - datas.discount).toFixed(2);

                                } else {
                                    datas.discount = Number(discountTaxDetail.discountAmount).toFixed(2);
                                    datas.netPrice = Number(Number(datas.price) - datas.discount).toFixed(2);

                                }
                            } else if (discountTaxDetail.discountType == "Percentage") {
                                datas.quoteTaxDetail.discountType = 58;

                                discountTaxDetail.dicountPercentage = discountTaxDetail.dicountPercentage ? discountTaxDetail.dicountPercentage : 0;
                                datas.discount1 = Number(Number(datas.price) * (discountTaxDetail.dicountPercentage / 100)).toFixed(2);
                                datas.netPrice = Number(Number(datas.price) - datas.discount1).toFixed(2);
                                datas.discount = discountTaxDetail.dicountPercentage;

                            }

                            if (datas.price >= datas.discountAmount) {
                                datas['total'] = Number(Number(datas.price) - Number(datas.discount1)).toFixed(2);
                                datas['finalTotal'] = 0;
                            } else if (datas.price < datas.discountAmlount) {
                                datas['total'] = Number(Number(datas.price) - Number(datas.discount1)).toFixed(2);
                                datas['finalTotal'] = 0;
                            }
                            datas['finalTotal'] = (Number(datas.total) + Number(datas.taxCGST) + Number(datas.taxSGST) + Number(datas.taxIGST)).toFixed(2);

                            // data['subTotal'] = subTotal;

                            // i=0;
                            // $scope.totalTaxAmount=0;
                            // $scope.totalTaxPercentageValue=0;
                            // $scope.quotationDetail.taxCode="";
                            // $scope.calculateTaxDetails(rowCollection,rowCollection.quoteTaxDetail.taxIdslist);
                            // $scope.calculateTaxDiscount(datas)

                        }

                    });
                    $rootScope.isEdit = true;
                    $scope.isEdit = true;
                    $scope.type = true;
                    $rootScope.check = true;

                    // $scope.calculateTotal();

                });
            }
        };
        var i;
        $scope.totalTaxAmount = 0;

        $scope.calculateTaxDiscount = function(rowCollection) {/*
                                                                 * var disc =
                                                                 * "";
                                                                 * 
                                                                 * if
                                                                 * (rowCollection.quoteTaxDetail.discountType ==
                                                                 * "59") {
                                                                 * rowCollection.quoteTaxDetail.discountType =
                                                                 * "Amount";
                                                                 * 
                                                                 * }else
                                                                 * if(rowCollection.quoteTaxDetail.discountType ==
                                                                 * "58"){
                                                                 * rowCollection.quoteTaxDetail.discountType =
                                                                 * "Percentage"; }
                                                                 *  // discount =
                                                                 * rowCollection.discount ;
                                                                 * if
                                                                 * (rowCollection.quoteTaxDetail.discountType ==
                                                                 * "Percentage") {
                                                                 * rowCollection.quoteTaxDetail.discountType =
                                                                 * "Percentage";
                                                                 * rowCollection.price =
                                                                 * Number(Number(rowCollection.quantity) *
                                                                 * rowCollection.unitPrice).toFixed(2); //
                                                                 * var
                                                                 * taxAmtSGST =(
                                                                 * totalamount * //
                                                                 * ((PQitemlist[i].taxSGST)/100));
                                                                 * 
                                                                 * disc =
                                                                 * (rowCollection.price *
                                                                 * (rowCollection.quoteTaxDetail.dicountPercentage /
                                                                 * 100)); //
                                                                 * disc =
                                                                 * rowCollection.discount; //
                                                                 * rowCollection['discount'] =
                                                                 * (rowCollection.price * //
                                                                 * (rowCollection.discount/100));
                                                                 *  } else if
                                                                 * (rowCollection.quoteTaxDetail.discountType ==
                                                                 * "Amount") {
                                                                 * rowCollection.quoteTaxDetail.discountType =
                                                                 * "Amount";
                                                                 * disc =
                                                                 * rowCollection.discount;
                                                                 *  //
                                                                 * rowCollection['discount'] =
                                                                 * rowCollection.discount; }
                                                                 * else {
                                                                 * rowCollection.quoteTaxDetail.discountType =
                                                                 * ""; }
                                                                 * 
                                                                 * rowCollection['finalTotal'] =
                                                                 * 0;
                                                                 * rowCollection['total'] =
                                                                 * 0;
                                                                 * 
                                                                 * if
                                                                 * (rowCollection.price >=
                                                                 * disc) {
                                                                 * rowCollection['total'] =
                                                                 * Number(Number(rowCollection.price) -
                                                                 * Number(disc)).toFixed(2);
                                                                 * rowCollection['finalTotal'] =
                                                                 * 0; } else if
                                                                 * (rowCollection.price <
                                                                 * disc) {
                                                                 * rowCollection['total'] =
                                                                 * Number(Number(rowCollection.price) -
                                                                 * Number(disc)).toFixed(2);
                                                                 * rowCollection['finalTotal'] =
                                                                 * 0; }
                                                                 * 
                                                                 * 
                                                                 * console.log("Row
                                                                 * Collection
                                                                 * is");
                                                                 * console.log(rowCollection);
                                                                 * debugger;
                                                                 * rowCollection['finalTotal'] =
                                                                 * 0;
                                                                 * rowCollection['total'] =
                                                                 * 0;
                                                                 * rowCollection.price =
                                                                 * Number(rowCollection.price);
                                                                 * if
                                                                 * (rowCollection.quantity !=
                                                                 * null &&
                                                                 * angular.isString(rowCollection.quantity)) {
                                                                 * rowCollection.quantity =
                                                                 * rowCollection.quantity.replace(/[^0-9]/g,
                                                                 * ''); }
                                                                 * rowCollection.price =
                                                                 * Number(Number(rowCollection.quantity) *
                                                                 * rowCollection.unitPrice).toFixed(2);
                                                                 * var
                                                                 * discountTaxDetail =
                                                                 * rowCollection.quoteTaxDetail;
                                                                 * if
                                                                 * (discountTaxDetail.discountType ==
                                                                 * "8") {
                                                                 * discountTaxDetail.discountType =
                                                                 * "Amount"; //
                                                                 * discountTaxDetail.discountAmount =
                                                                 * discountTaxDetail.discountAmount ?
                                                                 * discountTaxDetail.discountAmount :
                                                                 * 0;
                                                                 * //if($rootScope.isEdit==true){
                                                                 * if
                                                                 * (rowCollection.quantity >
                                                                 * 0) { var
                                                                 * unitDiscount =
                                                                 * discountTaxDetail.discount /
                                                                 * rowCollection.quantity;
                                                                 * rowCollection.discount =
                                                                 * Number(Number(rowCollection.quantity) *
                                                                 * Number(unitDiscount)).toFixed(2); }
                                                                 * else {
                                                                 * rowCollection.discount =
                                                                 * Number(discountTaxDetail.discountAmount).toFixed(2); }
                                                                 * }else{
                                                                 * rowCollection.discount =
                                                                 * Number(discountTaxDetail.discountAmount).toFixed(2); } }
                                                                 * else if
                                                                 * (discountTaxDetail.discountType ==
                                                                 * "50") {
                                                                 * discountTaxDetail.discountType =
                                                                 * "Percentage";
                                                                 * discountTaxDetail.dicountPercentage =
                                                                 * discountTaxDetail.dicountPercentage ?
                                                                 * discountTaxDetail.dicountPercentage :
                                                                 * 0;
                                                                 * rowCollection.discount =
                                                                 * Number(Number(rowCollection.price) *
                                                                 * (discountTaxDetail.dicountPercentage /
                                                                 * 100)).toFixed(2); }
                                                                 * if
                                                                 * (rowCollection.price >=
                                                                 * rowCollection.discount) {
                                                                 * rowCollection['total'] =
                                                                 * Number(Number(rowCollection.price) -
                                                                 * Number(rowCollection.discount)).toFixed(2);
                                                                 * rowCollection['finalTotal'] =
                                                                 * 0; } else if
                                                                 * (rowCollection.price <
                                                                 * rowCollection.quoteTaxDetail.discount) {
                                                                 * rowCollection['total'] =
                                                                 * Number(Number(rowCollection.price) -
                                                                 * Number(rowCollection.discount)).toFixed(2);
                                                                 * rowCollection['finalTotal'] =
                                                                 * 0; }
                                                                 * if(discountTaxDetail.taxType ==
                                                                 * "Fixed
                                                                 * Amount"){
                                                                 * discountTaxDetail.taxAmount =
                                                                 * discountTaxDetail.taxAmount ?
                                                                 * discountTaxDetail.taxAmount :
                                                                 * 0;
                                                                 * rowCollection.tax =
                                                                 * Number(discountTaxDetail.taxAmount).toFixed(2);
                                                                 * }else
                                                                 * if(discountTaxDetail.taxType ==
                                                                 * "Percentage"){
                                                                 * discountTaxDetail.taxPercentage =
                                                                 * discountTaxDetail.taxPercentage ?
                                                                 * discountTaxDetail.taxPercentage :
                                                                 * 0;
                                                                 * rowCollection.tax =
                                                                 * Number(rowCollection.price)*(discountTaxDetail.taxPercentage/100);
                                                                 * rowCollection.tax =
                                                                 * Number(rowCollection.tax).toFixed(2); }
                                                                 * 
                                                                 *  // i = 0; //
                                                                 * $scope.totalTaxAmount =
                                                                 * 0; //
                                                                 * $scope.totalTaxPercentageValue =
                                                                 * 0; //
                                                                 * $scope.quotationDetail.taxCode =
                                                                 * "";
                                                                 * rowCollection['discount'] =
                                                                 * Number(disc).toFixed(2); //
                                                                 * rowCollection.['netPrice'] =
                                                                 * Number(Number(rowCollection.price) - //
                                                                 * Number(disc)
                                                                 * ).toFixed(2);
                                                                 * 
                                                                 * rowCollection['finalTotal'] =
                                                                 * (Number(rowCollection.total) +
                                                                 * Number(rowCollection.quoteTaxDetail.taxCGST) +
                                                                 * Number(rowCollection.quoteTaxDetail.taxSGST) +
                                                                 * Number(rowCollection.quoteTaxDetail.taxIGST)).toFixed(2); //
                                                                 * $scope.calculateTotal();
                                                                 * 
                                                                 */

            if (rowCollection.quantity <= 0) {
                logger.logError("Quantity Should be Greater than 0!");
                rowCollection.quantity = '';
            } else {
                rowCollection['finalTotal'] = 0;
                rowCollection['total'] = 0;
                rowCollection.price = Number(rowCollection.price);
                if (rowCollection.quantity != null && angular.isString(rowCollection.quantity)) {
                    rowCollection.quantity = rowCollection.quantity.replace(/[^0-9]/g, '');
                }
                rowCollection.price = Number(Number(rowCollection.quantity) * rowCollection.unitPrice).toFixed(2);
                var discountTaxDetail = rowCollection.quoteTaxDetail;
                if (discountTaxDetail.discountType == "Amount" || discountTaxDetail.discountType == 59) {/*
                                                                                                             * discountTaxDetail.discountAmount =
                                                                                                             * discountTaxDetail.discountAmount ?
                                                                                                             * discountTaxDetail.discountAmount :
                                                                                                             * 0;
                                                                                                             * if
                                                                                                             * ($rootScope.isEdit ==
                                                                                                             * true) {
                                                                                                             * if
                                                                                                             * (rowCollection.vendorQuantity >
                                                                                                             * 0) {
                                                                                                             * var
                                                                                                             * unitDiscount =
                                                                                                             * discountTaxDetail.discountAmount /
                                                                                                             * rowCollection.vendorQuantity;
                                                                                                             * rowCollection.discount =
                                                                                                             * Number(Number(rowCollection.quantity) *
                                                                                                             * Number(unitDiscount)).toFixed(2); }
                                                                                                             * else {
                                                                                                             * rowCollection.discount =
                                                                                                             * Number(discountTaxDetail.discountAmount).toFixed(2); } }
                                                                                                             * else {
                                                                                                             * rowCollection.discount =
                                                                                                             * Number(discountTaxDetail.discountAmount).toFixed(2); }
                                                                                                             */

                    rowCollection.quoteTaxDetail.discountType = 59;
                    discountTaxDetail.discountAmount = discountTaxDetail.discountAmount ? discountTaxDetail.discountAmount : 0;
                    if (rowCollection.vendorQuantity > 0) {
                        if (discountTaxDetail.discountAmount != 0) {

                            // var unitDiscount =
                            // discountTaxDetail.discountAmount /
                            // rowCollection.vendorQuantity;
                            var unitDiscount = rowCollection.discount / rowCollection.vendorQuantity;

                            rowCollection.discount = Number(Number(rowCollection.quantity) * Number(unitDiscount)).toFixed(2);
                            rowCollection.discount1 = rowCollection.discount;
                        } else {
                            rowCollection.discount1 = rowCollection.discount;
                        }
                    } else {
                        rowCollection.discount = Number(discountTaxDetail.discount).toFixed(2);
                    }

                } /*
                     * else if (discountTaxDetail.discountType == "Percentage") {
                     * discountTaxDetail.dicountPercentage =
                     * discountTaxDetail.dicountPercentage ?
                     * discountTaxDetail.dicountPercentage : 0;
                     * rowCollection.discount =
                     * Number(Number(rowCollection.price) *
                     * (discountTaxDetail.dicountPercentage / 100)).toFixed(2); }
                     */

                else if (discountTaxDetail.discountType == "Percentage" || discountTaxDetail.discountType == 58) {

                    discountTaxDetail.dicountPercentage = discountTaxDetail.dicountPercentage ? discountTaxDetail.dicountPercentage : 0;
                    // rowCollection.discount =
                    // Number(Number(rowCollection.price) *
                    // (discountTaxDetail.dicountPercentage / 100)).toFixed(2);
                    // rowCollection.discount = rowCollection.discount;
                    var flag = false;
                    if (discountTaxDetail.discountType == "Percentage") {
                        rowCollection.discount = discountTaxDetail.dicountPercentage;
                        rowCollection.discount1 = Number(Number(rowCollection.price) * (discountTaxDetail.dicountPercentage / 100)).toFixed(2);
                        rowCollection.quoteTaxDetail.discountType = 58;
                        flag = true;
                    } else if (flag == false) {
                        rowCollection.quoteTaxDetail.discountType = 58;
                        rowCollection.discount1 = Number(Number(rowCollection.price) * (rowCollection.discount / 100)).toFixed(2);
                    }

                }
                // else if (discountTaxDetail.discountType == 58) {
                // // rowCollection.discountAmount = 0;
                // rowCollection.quoteTaxDetail.discountAmount =
                // Number(Number(rowCollection.price) *
                // (Number(rowCollection.discount) / 100)).toFixed(2);
                // // alert(rowCollection.quoteTaxDetail.discountAmount);
                // }

                else if (discountTaxDetail.discountType == '') {
                    rowCollection.discount = 0;

                }

                else {
                    rowCollection.discount = Number(discountTaxDetail.discountAmount).toFixed(2);
                }
                rowCollection.netPrice = rowCollection.price - rowCollection.discount1;

                if (rowCollection.price >= rowCollection.discount1) {
                    rowCollection['total'] = Number(Number(rowCollection.price) - Number(rowCollection.discount1)).toFixed(2);
                    rowCollection['finalTotal'] = 0;
                } else if (rowCollection.price < rowCollection.discount1) {
                    rowCollection['total'] = Number(Number(rowCollection.price) - Number(rowCollection.discount1)).toFixed(2);
                    rowCollection['finalTotal'] = 0;
                }
                /*
                 * if(discountTaxDetail.taxType == "Fixed Amount"){
                 * discountTaxDetail.taxAmount = discountTaxDetail.taxAmount ?
                 * discountTaxDetail.taxAmount : 0; rowCollection.tax =
                 * Number(discountTaxDetail.taxAmount).toFixed(2); }else
                 * if(discountTaxDetail.taxType == "Percentage"){
                 * discountTaxDetail.taxPercentage =
                 * discountTaxDetail.taxPercentage ?
                 * discountTaxDetail.taxPercentage : 0; rowCollection.tax =
                 * Number(rowCollection.price)*(discountTaxDetail.taxPercentage/100);
                 * rowCollection.tax = Number(rowCollection.tax).toFixed(2); }
                 */
                /*
                 * if(discountTaxDetail.subTaxType == "Fixed Amount"){
                 * discountTaxDetail.subTaxAmount =
                 * discountTaxDetail.subTaxAmount ?
                 * discountTaxDetail.subTaxAmount:0; var tax1 =
                 * discountTaxDetail.subTaxAmount; rowCollection.tax
                 * =Number(rowCollection.tax) +tax1; rowCollection.tax =
                 * Number(rowCollection.tax).toFixed(2); }else
                 * if(discountTaxDetail.subTaxType == "Percentage"){
                 * discountTaxDetail.subTaxPercentage =
                 * discountTaxDetail.subTaxPercentage ?
                 * discountTaxDetail.subTaxPercentage : 0; var tax1 =
                 * Number(rowCollection.price)*(discountTaxDetail.subTaxPercentage/100);
                 * rowCollection.tax = Number(rowCollection.tax)+tax1;
                 * rowCollection.tax = Number(rowCollection.tax).toFixed(2); }
                 */
                i = 0;
                $scope.totalTaxAmount = 0;
                $scope.totalTaxPercentageValue = 0;
                $scope.quotationDetail.taxCode = "";
                // rowCollection['finalTotal'] = (Number(rowCollection.total) +
                // Number(rowCollection.tax)).toFixed(2);
                rowCollection['finalTotal'] = (Number(rowCollection.total) + Number(Number(rowCollection.total) * (rowCollection.taxCGSTinPercent) / 100) + Number(Number(rowCollection.total) * (rowCollection.taxSGSTinPercent) / 100) + Number(Number(rowCollection.total) * (rowCollection.taxIGSTinPercent) / 100)).toFixed(2);

                // $scope.calculateTotal();
                // $scope.checkPartiallyVerified(rowCollection);

            }

        };

        $scope.calculateTaxDetails = function(rowCollection, taxArray) {

            var arrayLength = taxArray.length;

            if (arrayLength != i) {
                if (taxArray[i] != "" && taxArray[i] != undefined && taxArray[i] != null) {
                    var taxId = taxArray[i]
                    $http.get("hospital/purchase/quotation/getTaxDetails?taxId=" + taxArray[i]).success(function(response) {
                        if (response.success == true) {
                            console.log("response");
                            console.log(response);
                            $scope.taxPercentage = 0;
                            $scope.taxAmount = 0;
                            $scope.subTaxPercentage = 0;
                            $scope.subTaxAmount = 0;
                            $scope.quotationDetail.subTaxTypeAmt = "";
                            $scope.quotationDetail.subTaxTypePercent = "";

                            $scope.quotationDetail.quantity = rowCollection.quantity;
                            $scope.quotationDetail.unitPrice = rowCollection.unitPrice;

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

                            $scope.quotationDetail.subTaxPercentage = $scope.isNaNCheck(parseFloat($scope.subTaxPercentage));

                            $scope.quotationDetail.subTaxAmount = $scope.isNaNCheck(parseFloat($scope.subTaxAmount));

                            $scope.quotationDetail.unitPrice = $scope.isNaNCheck(parseFloat($scope.quotationDetail.unitPrice));

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

                            // alert("$scope.totalTaxAmount"+$scope.totalTaxAmount);

                            // alert("taxAmt"+$scope.quotationDetail.taxAmt);
                            $scope.totalTaxAmount = Number($scope.totalTaxAmount) + Number($scope.quotationDetail.taxAmt);

                            $scope.totalTaxAmount = $scope.totalTaxAmount.toFixed(2);

                            $scope.totalTaxPercentageValue = Number($scope.totalTaxPercentageValue) + Number(totalTaxPercentage);
                            $scope.totalTaxPercentageValue = $scope.totalTaxPercentageValue.toFixed(2);

                            i++;
                            $scope.calculateTaxDetails(rowCollection, taxArray);
                        } else {

                            $scope.taxPercentage = '';
                            $scope.taxAmount = '';
                            $scope.quotationDetail.taxType = '';
                            $scope.quotationDetail.taxCode = '';

                            $scope.subTaxPercentage = '';
                            $scope.subTaxAmount = '';
                            $scope.quotationDetail.subTaxType = '';
                            i++;
                            $scope.calculateTaxDetails(rowCollection, taxArray);
                        }
                    });
                } else {
                    $scope.taxPercentage = '';
                    $scope.taxAmount = '';
                    $scope.quotationDetail.taxType = '';

                    $scope.subTaxPercentage = '';
                    $scope.subTaxAmount = '';
                    $scope.quotationDetail.subTaxType = '';
                }
            }
            if (arrayLength == i) {

                rowCollection.tax = $scope.totalTaxAmount;

                rowCollection.finalTotal = (Number(rowCollection.total) + Number(rowCollection.tax)).toFixed(2);
                $scope.calculateTotal();
                $scope.checkPartiallyVerified(rowCollection);

            }

        }

        $scope.$watchCollection('[purchaseOrder.totalDiscount,purchaseOrder.totalTaxCGST,purchaseOrder.totalTaxSGST,purchaseOrder.totalTaxIGST,purchaseOrder.freightAmount,purchaseOrder.otherCharges]', function(newValue, oldValue) {

            var freight = Number($scope.purchaseOrder.freight);
            var freightAmount = Number($scope.purchaseOrder.freightAmount);
            var otherCharges = Number($scope.purchaseOrder.otherCharges);
            var totalTaxCGST = Number($scope.purchaseOrder.totalTaxCGST);
            var totalTaxSGST = Number($scope.purchaseOrder.totalTaxSGST);
            var totalTaxIGST = Number($scope.purchaseOrder.totalTaxIGST);
            var totalDiscount = Number($scope.purchaseOrder.totalDiscount);
            // var total = Number($scope.purchaseOrder.totalAmount);
            var subTotal = Number($scope.purchaseOrder.subTotal);
            var total = Number(subTotal);
            // var allTotal = Number((total + freight + otherCharges +
            // totalTaxCGST + totalTaxSGST + totalTaxIGST) - totalDiscount);
            var allTotal = Number((total + freightAmount + otherCharges + totalTaxCGST + totalTaxSGST + totalTaxIGST) - totalDiscount).toFixed(2);

            // var round =Math.round(5.8);
//            allTotal = Math.round(allTotal);
            $scope.purchaseOrder.totalAmount = allTotal;

        });

        var txCGST = 0;
        var txSGST = 0;
        var txIGST = 0;

        $scope.calculateTaxDiscountEdit = function(rowCollection, index,GST) {

            var taxCGST = Number(rowCollection.quoteTaxDetail.taxCGSTinPercent);
            var taxSGST = Number(rowCollection.quoteTaxDetail.taxSGSTinPercent);
            var taxIGST = Number(rowCollection.quoteTaxDetail.taxIGSTinPercent);

            var Tot = taxCGST + taxSGST;
            if (Tot != 0 && taxIGST != 0) {
                rowCollection.quoteTaxDetail.taxIGSTinPercent = 0;
                ++index;
                logger.logError("Row" + "  " + index + "  " + "IGST Shouldn't be Create because CGST and SGST Already Created!");
                readonly = true;
            } else if (taxIGST != 0 && Tot != 0) {
                rowCollection.quoteTaxDetail.taxCGST = 0;
                rowCollection.quoteTaxDetail.taxSGST = 0;
                ++index;
                logger.logError("Row" + "  " + index + "  " + "CGST & SGST Shouldn't be Create because IGST Already Created!");

            }
           
            if(GST == "CGST"){
                rowCollection.quoteTaxDetail.taxSGSTinPercent = taxCGST;
            }
            if(GST == "SGST"){
                rowCollection.quoteTaxDetail.taxCGSTinPercent = taxSGST;
            }
            
            if (rowCollection.quantity <= 0) {
                logger.logError("Quantity Should be Greater than 0!");
                rowCollection.quantity = rowCollection.vendorQuantity;
            }
            /*
             * else if(rowCollection.quantity>(rowCollection.requestedQty -
             * rowCollection.pqQuantity)){ logger.logError("Available Requested
             * Quantity is :" +(rowCollection.requestedQty -
             * rowCollection.pqQuantity));
             * rowCollection.quantity=rowCollection.vendorQuantity; }
             */
            // else if (rowCollection.quantity > rowCollection.vendorQuantity) {
            // // logger.logError("Quantity Should be Greater than 0!");
            // rowCollection.quantity = rowCollection.vendorQuantity;
            // }
            var poId = $location.search().purchaseOrderId;
            if (poId == undefined || poId == null) {
                poId = 0;
            }
            $http.get("app/purchaseOrder/getqtyValidation?requisitionId=" + rowCollection.requisitionId + '&itemId=' + rowCollection.itemId + '&poId=' + poId).success(function(data) {

                if ($rootScope.isEdit == true) {

                    // $http.get("app/purchaseOrder/getqtycheckFromPO?requisitionId="
                    // + rowCollection.requisitionId + '&itemId=' +
                    // rowCollection.itemId + '&poId=' +
                    // poId).success(function(data) {
                    if (data.count == 0) {
                        var qty = data.checkqty;
                    } else if (data.count > 0)
                        var qty = rowCollection.vendorQuantity + data.checkqty;

                    // });

                    // if (rowCollection.requestedQty == data.checkqty)
                    // var qty = data.checkqty;
                    // else if (rowCollection.requestedQty - (data.checkqty +
                    // rowCollection.vendorQuantity) == 0)

                    // if(data.checkqty + rowCollection.vendorQuantity){
                    //                            
                    // }
                    // else if (rowCollection.vendorQuantity == data.checkqty ||
                    // data.checkqty == 0)
                    // var qty = rowCollection.vendorQuantity;
                    // else var qty = rowCollection.checkqty;

                    // else if (Math.abs(data.checkqty -
                    // rowCollection.vendorQuantity) > 0)
                    //
                    // var qty = rowCollection.vendorQuantity + data.checkqty;

                } else {
                    var qty = data.checkqty;

                }

                if (rowCollection.quantity > qty) {
                    logger.logError("Available Requested Quantity is :" + qty);
                    rowCollection.quantity = rowCollection.vendorQuantity;
                } else {

                    // else {
                    rowCollection['finalTotal'] = 0;
                    rowCollection['total'] = 0;
                    rowCollection.price = Number(rowCollection.price);
                    if (rowCollection.quantity != null && angular.isString(rowCollection.quantity)) {
                        // rowCollection.quantity =
                        // rowCollection.quantity.replace(/[^0-9]/g, '');
                    }
                    rowCollection.price = Number(Number(rowCollection.quantity) * rowCollection.unitPrice).toFixed(2);

                    var discountTaxDetail = rowCollection.quoteTaxDetail;

                    // var unitIGST =
                    // Number(rowCollection.quoteTaxDetail.taxIGST) /
                    // rowCollection.vendorQuantity;

                    // rowCollection.quoteTaxDetail.taxIGST =
                    // Number(Number(rowCollection.quantity) *
                    // Number(unitIGST)).toFixed(2);

                    /*
                     * if (discountTaxDetail.discountType == "Amount") {
                     * discountTaxDetail.discountAmount =
                     * discountTaxDetail.discountAmount ?
                     * discountTaxDetail.discountAmount : 0; // if
                     * (rowCollection.vendorQuantity > 0) { // var unitDiscount =
                     * discountTaxDetail.discountAmount / //
                     * rowCollection.vendorQuantity; // rowCollection.discount = //
                     * Number(Number(rowCollection.quantity) * //
                     * Number(unitDiscount)).toFixed(2); // } else { // var
                     * unitDiscount = discountTaxDetail.discountAmount / //
                     * rowCollection.vendorQuantity; // rowCollection.discount = //
                     * Number(Number(rowCollection.quantity) * //
                     * Number(unitDiscount)).toFixed(2);
                     *  // rowCollection.discount = //
                     * Number(Number(rowCollection.quantity) * //
                     * Number(unitDiscount)).toFixed(2);
                     * 
                     * rowCollection.discount =
                     * Number(discountTaxDetail.discountAmount).toFixed(2); // } }
                     * else if (discountTaxDetail.discountType == "Percentage") {
                     * discountTaxDetail.dicountPercentage =
                     * discountTaxDetail.dicountPercentage ?
                     * discountTaxDetail.dicountPercentage : 0;
                     * rowCollection.discount =
                     * Number(Number(rowCollection.price) *
                     * (discountTaxDetail.dicountPercentage / 100)).toFixed(2); }
                     * else { // discountTaxDetail.discountPercentage = //
                     * discountTaxDetail.discountPercentage ? //
                     * discountTaxDetail.discountPercentage : 0; //
                     * rowCollection.discount = //
                     * Number(discountTaxDetail.discountAmount).toFixed(2); if
                     * (rowCollection.vendorQuantity > 0) { var unitDiscount =
                     * discountTaxDetail.discountAmount /
                     * rowCollection.vendorQuantity; rowCollection.discount =
                     * Number(Number(rowCollection.quantity) *
                     * Number(unitDiscount)).toFixed(2); } }
                     */
                    if (discountTaxDetail.discountType == "Amount" || discountTaxDetail.discountType == 59) {

                        rowCollection.discount1 = rowCollection.discount;
                    }

                    else if (discountTaxDetail.discountType == "Percentage" || discountTaxDetail.discountType == 58) {

                        discountTaxDetail.dicountPercentage = discountTaxDetail.dicountPercentage ? discountTaxDetail.dicountPercentage : 0;

                        rowCollection.discount1 = Number(Number(rowCollection.price) * (rowCollection.discount / 100)).toFixed(2);

                    }

                    else if (discountTaxDetail.discountType == '') {
                        rowCollection.discount = 0;

                    } else {
                        rowCollection.discount = Number(discountTaxDetail.discountAmount).toFixed(2);
                    }
                    rowCollection.netPrice = rowCollection.price - rowCollection.discount1;

                    rowCollection.quoteTaxDetail.taxIGST = Number((rowCollection.netPrice * ((rowCollection.quoteTaxDetail.taxIGSTinPercent) / 100))).toFixed(2);
                    rowCollection.quoteTaxDetail.taxSGST = Number((rowCollection.netPrice * ((rowCollection.quoteTaxDetail.taxSGSTinPercent) / 100))).toFixed(2);
                    rowCollection.quoteTaxDetail.taxCGST = Number((rowCollection.netPrice * ((rowCollection.quoteTaxDetail.taxCGSTinPercent) / 100))).toFixed(2);

                    // var unitSGST =
                    // Number(rowCollection.quoteTaxDetail.taxSGST) /
                    // rowCollection.vendorQuantity;
                    // rowCollection.quoteTaxDetail.taxSGST =
                    // Number(Number(rowCollection.quantity) *
                    // Number(unitSGST)).toFixed(2);
                    // var unitCGST =
                    // Number(rowCollection.quoteTaxDetail.taxCGST) /
                    // rowCollection.vendorQuantity;
                    // rowCollection.quoteTaxDetail.taxCGST =
                    // Number(Number(rowCollection.quantity) *
                    // Number(unitCGST)).toFixed(2);

                    if (rowCollection.price >= rowCollection.discount1) {
                        rowCollection['total'] = Number(Number(rowCollection.price) - Number(rowCollection.discount1)).toFixed(2);
                        rowCollection['finalTotal'] = 0;
                    } else if (rowCollection.price < rowCollection.discount) {
                        rowCollection['total'] = Number(Number(rowCollection.price) - Number(rowCollection.discount1)).toFixed(2);
                        rowCollection['finalTotal'] = 0;
                    }
                    // rowCollection['finalTotal'] =
                    // (Number(rowCollection.total) +
                    // Number(rowCollection.taxCGST) +
                    // Number(rowCollection.taxSGST) +
                    // Number(rowCollection.taxIGST)).toFixed(2);
                    rowCollection['finalTotal'] = (Number(rowCollection.total) + Number(Number(rowCollection.total) * (rowCollection.quoteTaxDetail.taxCGSTinPercent) / 100) + Number(Number(rowCollection.total) * (rowCollection.quoteTaxDetail.taxSGSTinPercent) / 100) + Number(Number(rowCollection.total) * (rowCollection.quoteTaxDetail.taxIGSTinPercent) / 100)).toFixed(2);

                    i = 0;
                    $scope.totalTaxAmount = 0;
                    $scope.totalTaxPercentageValue = 0;
                    $scope.quotationDetail.taxCode = "";
                    // $scope.calculateTaxDetails(rowCollection,rowCollection.quoteTaxDetail.taxIdslist);

                    $scope.calculateTotal();
                }
            });
        };

        $scope.isNaNCheck = function(value) {
            if (isNaN(value)) {
                value = 0;
            }
            return value;
        }
        var totalAmt = '';
        var totalAmount = 0;
        $scope.calculateTotal = function() {
            var subTotal = 0;
            var totalDiscount = 0;
            var totalTax = 0;
            var otherCharges = 0;
            var totalTaxCGST = 0;
            var totalTaxSGST = 0;
            var totalTaxIGST = 0;
            for (var i = 0; i < $scope.rowCollectionItem.length; i++) {
                if ($scope.rowCollectionItem[i].edit != 2) {
                    var rowObj = $scope.rowCollectionItem[i];
                    // alert("price"+rowObj.price);
                    // rowObj.price = rowObj.price ? rowObj.price : 0;
                    rowObj.price = rowObj.price ? rowObj.price : 0;
                    rowObj.discount1 = rowObj.discount ? rowObj.discount1 : 0;
                    rowObj.tax = rowObj.tax ? rowObj.tax : 0;
                    // subTotal += Number(rowObj.price);
                    subTotal += Number(rowObj.price);

                    totalDiscount += Number(rowObj.discount1);
                    totalTax += Number(rowObj.tax);
                    // totalAmount += Number(rowObj.finalTotal);
                    totalTaxCGST += Number(rowObj.quoteTaxDetail.taxCGST);
                    totalTaxSGST += Number(rowObj.quoteTaxDetail.taxSGST);
                    totalTaxIGST += Number(rowObj.quoteTaxDetail.taxIGST);
                }
            }

            $scope.purchaseOrder.subTotal = Number(subTotal).toFixed(2);
            subTotal1 = Number(subTotal).toFixed(2);
            $scope.purchaseOrder.totalTaxCGST = Number(totalTaxCGST).toFixed(2);
            $scope.purchaseOrder.totalTaxSGST = Number(totalTaxSGST).toFixed(2);
            $scope.purchaseOrder.totalTaxIGST = Number(totalTaxIGST).toFixed(2);

            totalDiscount = totalDiscount ? totalDiscount : 0;
            $scope.purchaseOrder.totalDiscount = Number(totalDiscount).toFixed(2);
            totalTax = totalTax ? totalTax : 0;
            // $scope.purchaseOrder.totalTax = Number(totalTax).toFixed(2);
            // $scope.purchaseOrder.otherCharges = 0;

            // var freight = angular.copy($scope.purchaseOrder.freight);

            var freight = $scope.purchaseOrder.freightAmount;

            if ($scope.purchaseOrder.otherCharges != '') {
                otherCharges = $scope.purchaseOrder.otherCharges;

            }
            // var cal = freight+othercharges;
            // cal = (Number(totalTaxCGST) + Number(totalTaxSGST) +
            // Number(totalTaxIGST))- ;

            // $scope.purchaseOrder.totalAmount = Number(Number(subTotal) +
            // Number(cal)).toFixed(2);
            // totalAmt = $scope.purchaseOrder.totalAmount ;
            var cal = freight + Number(otherCharges) + Number($scope.purchaseOrder.totalTaxCGST) + Number($scope.purchaseOrder.totalTaxSGST) + Number($scope.purchaseOrder.totalTaxIGST);
            var totalDiscount = Number($scope.purchaseOrder.totalDiscount);
            var tAmount = Number((subTotal + Number(cal)) - totalDiscount).toFixed(2);

            $scope.purchaseOrder.totalAmount = Math.round(tAmount);

        };

        $scope.removePurchaseRow = function() {
            console.log("Row collection ITem in delete");
            console.log($scope.rowCollectionItem);
            $scope.purchaseQuotation.quotationDetailList = [];
            $scope.copytablerow = [];
            var isSelectItem = false;
            angular.forEach($scope.rowCollectionItem, function(value, index) {
                if (value.select == true) {
                    $scope.deletedIds.push({
                        "purchaseOrderDetailId" : value.purchaseOrderDetailId,
                        "itemId" : value.itemId
                    });
                    var purchaseQuantity = value.purchaseQuantity;
                    var vendorQty = value.vendorQuantity;
                    var requsitionId = value.requisitionId;
                    var itemId = value.itemId;
                    var Pendingqty = value.pendingQty
                    if (Pendingqty == vendorQty) {
                        if (purchaseQuantity == vendorQty) {
                            var qty = purchaseQuantity;

                        } else {
                            var qty = Pendingqty + vendorQty;
                        }
                    } else {
                        var qty = Pendingqty + vendorQty;

                    }

                    // $scope.rowCollectionItem[index].purchaseQuantity =
                    isSelectItem = true;

                    // $http.get("app/purchaseOrder/updatePendingqty?requisitionId="
                    // + requsitionId + '&itemId=' + itemId + '&qty=' +
                    // qty).success(function(data) {

                    $http.get("app/purchaseOrder/deletepqdetail1?purchaseOrderDetailId=" + value.purchaseQuoteDetailId).success(function(response) {
                        $http.get("app/purchaseOrder/deletePurchaseOrderDetail?purchaseOrderDetailId=" + value.purchaseOrderDetailId).success(function(response1) {
                        });
                        if (response) {
                            value.purchaseQuoteId = 0;
                            logger.logSuccess("Deleted Successfully");
                            // $state.go("app.hospital.purchase.purchaseOrder.add");
                        }
                    });
                    // });
                } else {
                    value.purchaseQuoteId = 0;
                    $scope.purchaseQuotation.quotationDetailList.push(value);
                    // $scope.purchaseQuotation.quotationDetailList
                }
            });
            if (isSelectItem == false) {
                logger.logError("Please select atleast one item to delete");
            }
            $scope.rowCollectionItem = $scope.purchaseQuotation.quotationDetailList;
            $scope.calculateTotal();
            /*
             * var isFreight = 0; for (var i = 0; i <
             * $scope.rowCollectionItem.length; i++) { if
             * ($scope.rowCollectionItem[i].edit != 2) { if
             * ($scope.rowCollectionItem[i].frieght != null) { var
             * isFrieghtExist = true; angular.forEach($scope.copytablerow,
             * function(value1, key1) { if (value1.purchaseQuoteId ==
             * $scope.rowCollectionItem[i].purchaseQuoteId) { isFrieghtExist =
             * false; } }); if (isFrieghtExist == true) { isFreight = isFreight +
             * $scope.rowCollectionItem[i].frieght; }
             * $scope.copytablerow.push($scope.rowCollectionItem[i]); } } }
             */

            // $scope.purchaseOrder.freight = isFreight;
        };
        $scope.deleteonclickreset = function() {

            if ($scope.rowCollectionItem.length > 0) {
                console.log("Row collection ITem in delete");
                console.log($scope.rowCollectionItem);
                $scope.purchaseQuotation.quotationDetailList = [];
                $scope.copytablerow = [];
                // var isSelectItem = false;
                if ($rootScope.isEdit == false) {
                    angular.forEach($scope.rowCollectionItem, function(value, index) {
                        // if (value.isSelected == true) {
                        $scope.deletedIds.push({
                            "purchaseOrderDetailId" : value.purchaseQuoteDetailId,
                            "itemId" : value.itemId
                        });
                        // isSelectItem = true;
                        var purchaseQuantity = value.purchaseQuantity;
                        var vendorQty = value.vendorQuantity;
                        var requsitionId = value.requisitionId;
                        var itemId = value.itemId;
                        var Pendingqty = value.pendingQty;
                        if (Pendingqty == vendorQty) {
                            if (purchaseQuantity == vendorQty) {
                                var qty = purchaseQuantity;

                            } else {
                                var qty = Pendingqty + vendorQty;
                            }
                        } else {
                            var qty = Pendingqty + vendorQty;

                        }

                        // $http.get("app/purchaseOrder/updatePendingqty?requisitionId="
                        // + requsitionId + '&itemId=' + itemId + '&qty=' +
                        // qty).success(function(data) {

                        $http.get("app/purchaseOrder/deletepqdetail?purchaseOrderDetailId=" + value.purchaseQuoteDetailId).success(function(response) {
                            $http.get("app/purchaseOrder/deletePurchaseOrderDetail?purchaseOrderDetailId=" + value.purchaseOrderDetailId).success(function(response1) {
                            });
                            if (response) {
                                // logger.logSuccess("Deleted
                                // Successfully");
                            }
                        });
                        // });
                        // } else {
                        // $scope.purchaseQuotation.quotationDetailList.push(value);
                        // }
                    });
                }
                // else if ($rootScope.isEdit == true) {
                // $scope.callEdit();
                // }

                else {

                    // $scope.callEdit();
                    // $scope.rowCollectionItem.requisitionNo =

                    $scope.allValues = $scope.rowCollectionItem;
                    // $scope.callEdit();
                    var purchaseOrderId = $location.search().purchaseOrderId;
                    // $scope.callEdit = function(){
                    if (purchaseOrderId != undefined) {
                        var editUrl = 'app/purchaseOrder/editPurchaseOrder';
                        $http({
                            url : editUrl,
                            params : {
                                "purchaseOrderId" : purchaseOrderId
                            },
                            method : "GET",
                            datatype : 'JSON',
                            'Accept' : 'application/json',
                            headers : {
                                'Content-Type' : 'application/json'
                            }

                        }).success(function(data) {

                            $scope.rowCollectionItem = data.purchaseQuoteDetails;

                            var flag = false;
                            angular.forEach($scope.allValues, function(value, index) {

                                for (var i = 0; i < $scope.rowCollectionItem.length; i++) {
                                    if (value.purchaseQuoteDetailId == $scope.rowCollectionItem[i].purchaseQuoteDetailId) {
                                        flag = true;
                                        break;
                                    } else
                                        flag = false;

                                }
                                if (!flag) {

                                    $scope.deletedIds.push({
                                        "purchaseOrderDetailId" : value.purchaseQuoteDetailId,
                                        "itemId" : value.itemId
                                    });
                                    var purchaseQuantity = value.purchaseQuantity;
                                    var vendorQty = value.vendorQuantity;
                                    var requsitionId = value.requisitionId;
                                    var itemId = value.itemId;
                                    var Pendingqty = value.pendingQty
                                    if (Pendingqty == vendorQty) {
                                        if (purchaseQuantity == vendorQty) {
                                            var qty = purchaseQuantity;

                                        } else {
                                            var qty = Pendingqty + vendorQty;
                                        }
                                    } else {
                                        var qty = Pendingqty + vendorQty;

                                    }
                                    // isSelectItem = true;

                                    // $http.get("app/purchaseOrder/updatePendingqty?requisitionId="
                                    // + requsitionId + '&itemId=' + itemId +
                                    // '&qty=' + qty).success(function(data) {

                                    $http.get("app/purchaseOrder/deletepqdetail?purchaseOrderDetailId=" + value.purchaseQuoteDetailId).success(function(response) {
                                        $http.get("app/purchaseOrder/deletePurchaseOrderDetail?purchaseOrderDetailId=" + value.purchaseOrderDetailId).success(function(response1) {
                                        });
                                        if (response) {
                                        }
                                    });
                                    // });

                                }

                            });
                        });
                    }
                    if ($scope.isCancel == true) {
                        //$state.go("app.hospital.purchase.purchaseOrder.list");
                    	$state.go("app.sea.orderdci.list");
                    }
                }
                // if (isSelectItem == false) {
                // logger.logError("Please select atleast one item to delete");
                // }
                $scope.rowCollectionItem = $scope.purchaseQuotation.quotationDetailList;
                // $scope.calculateTotal();
                var isFreight = 0;
                for (var i = 0; i < $scope.rowCollectionItem.length; i++) {
                    if ($scope.rowCollectionItem[i].edit != 2) {
                        if ($scope.rowCollectionItem[i].frieght != null) {
                            var isFrieghtExist = true;
                            angular.forEach($scope.copytablerow, function(value1, key1) {
                                if (value1.purchaseQuoteId == $scope.rowCollectionItem[i].purchaseQuoteId) {
                                    isFrieghtExist = false;
                                }
                            });
                            if (isFrieghtExist == true) {
                                isFreight = isFreight + $scope.rowCollectionItem[i].frieght;
                            }
                            $scope.copytablerow.push($scope.rowCollectionItem[i]);
                        }

                    }
                }

                $scope.purchaseOrder.freight = isFreight;
            } else {
                if ($scope.isCancel == true) {
                    //$state.go("app.hospital.purchase.purchaseOrder.list");
                	$state.go("app.sea.orderdci.list");
                }
            }
        }
        // Top find which object Property is Updated
        /*
         * var purchaseObj = angular.copy($scope.purchaseOrder, purchaseObj);
         * var arrayOfValues = Object.keys(purchaseObj);
         * $scope.checkWhichVariableHasUpdated = function(watchGroupList,
         * newValuesObj, oldValuesObj) { var _lastUpdatedValue = null;
         * angular.forEach(watchGroupList, function(value) { if
         * (newValuesObj[value] != oldValuesObj[value]) _lastUpdatedValue =
         * value; }); $scope.selectedObj = newValuesObj; return
         * _lastUpdatedValue; };
         */

        // To load Dependent DropDown
        $scope.loadDropDown = function(changedVariable) {
            switch (changedVariable) {
            case "locationId":
                $scope.loadDestAddress();
                break;
            case "vendorId":
                $scope.loadVendorAddress();
                break;
            case "freight":
                $scope.calculateTotal();
                break;
            }
        };

        // To watch a Object Collection
        /*
         * $scope.$watchCollection('purchaseOrder', function(newVal, oldVal) {
         * if (newVal != undefined) { var last_changed =
         * $scope.checkWhichVariableHasUpdated(arrayOfValues, newVal, oldVal);
         * if (angular.isDefined(last_changed) && last_changed != null) {
         * $scope.loadDropDown(last_changed); } } }, true);
         */
        $scope.checkPartiallyVerified = function(row) {
            if (row.vendorMinQty != null) {
                if (Number(row.quantity) < Number(row.vendorMinQty)) {
                    row.quantity = Number(row.vendorMinQty);
                    var price = row.vendorMinQty * row.unitPrice;
                    row.price = (Number(price).toFixed(2)).toString();
                    $scope.calculateTaxDiscountEdit(row);
                    logger.logError("For the selected item, the Vendor minimum qty is greater than the requested quantity");
                } else {
                    $scope.calculateTaxDiscountEdit(row);

                }
            } else {
                $scope.calculateTaxDiscountEdit(row);
            }
        };

        /**
         * Reset Functionality ******************************
         */
        var originalDatas = angular.copy($scope.purchaseOrder);
        var originalTableDatas = angular.copy($scope.rowCollectionItem);
        var originalAddress = angular.copy($scope.purchaseData);
        var originalVendorAddress = angular.copy($scope.vendor);

        $scope.reset = function() {
            if ($rootScope.isEdit == false) {
                $scope.deleteonclickreset();

                $scope.purchaseOrder = angular.copy(originalDatas);
                $scope.purchaseData = angular.copy(originalAddress);
                $scope.rowCollectionItem = angular.copy(originalTableDatas);
                $scope.vendor = angular.copy(originalVendorAddress);
                $scope.purchaseOrder.purchaseType = "43";
                $scope.purchaseOrder.statusId = "46";
                $scope.PurchaseOrderForm.$setPristine();
                $scope.deletedIds = [];
                $scope.tableDetails1 = [];
                $scope.purchaseQuotation.quotationDetailList = [];
                $scope.purchaseOrder.termsCondition = $scope.termsAndConditions;

            } else {
                $scope.deleteonclickreset();
                $scope.callEdit();
                $scope.deletedIds = [];
            }
        }
        var i = 0;
        $scope.totalTaxAmount = 0;

        $scope.getAddDetails = function() {
            $http.get("hospital/purchase/quotation/getAddDetails").success(function(response) {
                if (response.success == true) {
                    var purchaseList = [];
                    angular.forEach(response.purchaseForList, function(item, key) {
                        var purchaseObj = new Object();
                        purchaseObj.id = response.purchaseForList[key].id;
                        purchaseObj.text = response.purchaseForList[key].text;
                        purchaseList.push(purchaseObj);
                    });
                    $scope.purchaseForList = purchaseList;
                    // purchase_for combo
                    // $scope.purchaseForList = response.purchaseForList;
                    /*
                     * var purchaseList = [];
                     * angular.forEach(response.purchaseForList, function (item,
                     * key) { var purchaseObj = new Object(); purchaseObj.id =
                     * response.purchaseForList[key].value; // vendorObj.text =
                     * response.purchaseForList[key].entityName;
                     * purchaseList.push(purchaseObj); });
                     * $scope.purchaseForList = purchaseList;
                     */
                    // purchase_type combo
//                    $scope.purchaseTypeList = response.purchaseTypeList;

                    // vendor combo
                    var venList = [];
                    angular.forEach(response.vendorList, function(item, key) {
                        var vendorObj = new Object();
                        vendorObj.id = response.vendorList[key].entityId;
                        vendorObj.text = response.vendorList[key].entityName;
                        venList.push(vendorObj);
                    });
                    // $scope.vendorList = venList;
                    var statusList = [];
                    angular.forEach(response.statusList, function(item, key) {
                        var statusObj = new Object();
                        statusObj.id = response.statusList[key].id;
                        statusObj.text = response.statusList[key].text;
                        statusList.push(statusObj);
                    });
                    $scope.statusList = statusList;
                    var discountTypeList = [];
                    angular.forEach(response.discountTypeList, function(item, key) {
                        var disObj = new Object();
                        disObj.id = response.discountTypeList[key].id;
                        disObj.text = response.discountTypeList[key].text;
                        discountTypeList.push(disObj);
                    });
                    $scope.discountTypeList = discountTypeList;
                    // $scope.statusList = response.statusList;
                    // $scope.discountTypeList =response.discountTypeList;

                    $scope.taxList = response.taxList;

                    $timeout(function() {
                        $("#txtTaxId").multiselect({
                            maxHeight : 400,
                            includeSelectAllOption : false,
                            selectAllText : 'Select All',
                            enableFiltering : true,
                            enableCaseInsensitiveFiltering : true,
                            filterPlaceholder : 'Search',
                            numberDisplayed : 1,
                        /*
                         * onChange : function(element, checked) {
                         * jQuery(function(){ var max = 5; var checkboxes =
                         * $('input[type="checkbox"]');
                         * checkboxes.change(function(){ var current =
                         * checkboxes.filter(':checked').length;
                         * checkboxes.filter(':not(:checked)').prop('disabled',
                         * current >= max); }); }); }
                         */
                        });
                    }, 3, false);

                    /*
                     * var reqNoList = [];
                     * angular.forEach(response.requisitionList, function (item,
                     * key) { var reqObj = new Object(); reqObj.id =
                     * response.requisitionList[key].purchaseRequisitionId;
                     * reqObj.text =
                     * response.requisitionList[key].requisitionNumber;
                     * reqNoList.push(reqObj); }); $scope.requisitionList =
                     * reqNoList;
                     */

                }
            });

        }

        $scope.$watch("purchaseOrder.companyId", function(newValue, oldValue) {
            var companyCode = $scope.purchaseOrder.companyId;
            // $scope.purchaseOrder.purchaseOrderNum = "";
            $scope.getCompanydropdowm(companyCode);

            /*
             * $http.post("hospital/purchase/quotation/getRequsitionListbasedonCompany",companyCode).success(function(response) {
             * 
             * var reqNoList = []; angular.forEach(response.requisitionList,
             * function (item, key) { var reqObj = new Object(); reqObj.id =
             * response.requisitionList[key].purchaseRequisitionId; reqObj.text =
             * response.requisitionList[key].requisitionNumber;
             * reqNoList.push(reqObj); }); $scope.requisitionList = reqNoList;
             * });
             */
            $http.post("hospital/purchase/quotation/getpotype", companyCode).success(function(response) {

                var reqNoList = [];
                angular.forEach(response.requisitionList, function(item, key) {
                    var reqObj = new Object();
                    reqObj.id = response.requisitionList[key].purchaseRequisitionId;
                    reqObj.text = response.requisitionList[key].requisitionNumber;
                    reqNoList.push(reqObj);
                });
                $scope.requisitionList = reqNoList;
            });
            $http.get('app/purchaseOrder/costcenterList?companyId=' + companyCode).success(function(datas) {
                $scope.costList = datas;
            });

        });
        $scope.getCompanydropdowm = function(companyCode) {
            if (companyCode != null && companyCode != undefined && companyCode != '') {
                if ($scope.purchaseOrder.reqType == 'PO') {
                    $http.post("hospital/purchase/quotation/getRequsitionListbasedonCompany", companyCode).success(function(response) {
                        var reqNoList = [];
                        angular.forEach(response.requisitionList, function(item, key) {
                            var reqObj = new Object();
                            reqObj.id = response.requisitionList[key].purchaseRequisitionId;
                            reqObj.text = response.requisitionList[key].requisitionNumber;
                            reqNoList.push(reqObj);
                        });
                        $scope.requisitionList = reqNoList;
                    });
                } else {
                    $http.post("hospital/purchase/quotation/getWorkOrderLists", companyCode).success(function(response) {
                        var reqNoList = [];
                        angular.forEach(response.requisitionList, function(item, key) {
                            var reqObj = new Object();
                            reqObj.id = response.requisitionList[key].purchaseRequisitionId;
                            reqObj.text = response.requisitionList[key].requisitionNumber;
                            reqNoList.push(reqObj);
                        });
                        $scope.requisitionList = reqNoList;
                    });
                }
            }
        }

        /*
         * $scope.$watch('manageVendorObj.cityId', function(newValue, oldValue) {
         * if (newValue != '' && newValue != undefined) {
         * $scope.onChangeMainCity($scope.manageVendorObj.cityId); } });
         */
        /*
         * $scope.onChangeMainCity = function(cityId) { if (cityId != '' &&
         * cityId != undefined) {
         * $http.get('app/customerMaster/getCityStateCountryList?cityId=' +
         * cityId).success(function(datas) { if
         * (datas.lManageCustomerBean.length > 0) {
         * angular.forEach(datas.lManageCustomerBean, function(item, key) {
         * $scope.manageVendorObj.desStateCode =
         * datas.lManageCustomerBean[key].stateCode;
         * $scope.manageVendorObj.desState =
         * datas.lManageCustomerBean[key].stateName;
         * $scope.manageVendorObj.desZipcode =
         * datas.lManageCustomerBean[key].pincode;
         * $scope.manageVendorObj.desCountry =
         * datas.lManageCustomerBean[key].countryName;
         * $scope.manageVendorObj.desCountryCode =
         * datas.lManageCustomerBean[key].countryCode;
         * 
         * }); } else { $scope.manageVendorObj.desStateCode = '';
         * $scope.manageVendorObj.desState = '';
         * $scope.manageVendorObj.desZipcode = '';
         * $scope.manageVendorObj.desCountryCode = '';
         * $scope.manageVendorObj.desCountry = ''; } }).error(function(data) {
         * }); } else { $scope.manageVendorObj.desStateCode = '';
         * $scope.manageVendorObj.desState = '';
         * $scope.manageVendorObj.desZipcode = '';
         * $scope.manageVendorObj.desCountryCode = '';
         * $scope.manageVendorObj.desCountry = ''; } }
         */

        $scope.TOtalCal1 = function(index) {
            $scope.freight = 0;
            $scope.freightTax = 0;
            var totalvalue;
            // totalvalue =
            // ($scope.purchaseOrder.freight)*(($scope.purchaseOrder.freightTax)/100).toFixed(2);
            // $scope.purchaseOrder.freightAmount = (totalvalue +
            // Number(($scope.purchaseOrder.freight)));
            if ($scope.purchaseOrder.freight == 0) {
                $scope.purchaseOrder.freightTax = 0;
                $scope.purchaseOrder.freightAmount = 0;
            } else {

                totalvalue = ($scope.purchaseOrder.freight) * (($scope.purchaseOrder.freightTax) / 100).toFixed(2);
                $scope.purchaseOrder.freightAmount = (totalvalue + Number(($scope.purchaseOrder.freight)));

            }
        };

    });

  app.controller('purchaseOrderRequestAddCtrl', function($scope, $http, ngDialog, logger, requestCode, $injector, sharedProperties,$stateParams, toaster, $rootScope, validationService) {

        var currentDate = new Date();
        currentDate = ('0' + currentDate.getDate()).slice(-2) + "/" + ('0' + (Number(currentDate.getMonth()) + 1)).slice(-2) + "/" + currentDate.getFullYear();
        $scope.purchaseData.requestFromDate = currentDate;
        $scope.purchaseData.requestToDate = currentDate;

        $scope.cancelReq = function() {
            $scope.itemList = [];
            $scope.quotationDetail.requisitionId = "";
            ngDialog.close();
            if ($rootScope.isEdit == true) {
                $rootScope.isEdit = true;
            } else {
                $rootScope.isEdit = false;

            }

        };

        $scope.addQuoteStatus = "72";

        $scope.getListOfDropdowns = function() {
            $http.get('app/purchaseOrder/getDetailStatus').success(function(data) {
                if (data.success == true) {
                    $scope.statusList = data.purchaseStatus;
                }
            });
        };
        $scope.getListOfDropdowns();
        $scope.departmentCollections = [];
        $scope.rowCollection = [];

        $scope.vendorName = requestCode.text;
        $scope.changeStatus = function(ac) {
            $scope.addQuoteStatus = ac;
        };
        $scope.purchaseData.meterialrequest = false;
        $scope.meterial = function(meterial) {
            if (meterial == true) {

                $scope.showPurchaseQuotationDetailDialog($scope, 0, $http, ngDialog, logger, $injector, sharedProperties,$stateParams, toaster, $rootScope);

            }
        }

        // impo
        $scope.getApprovedPurchaseQuotation = function(purchaseData, purchaseOrderRequestForm) {
            if (new validationService().checkFormValidity(purchaseOrderRequestForm)) {
                $scope.getQuoteStatus($scope.addQuoteStatus);
                var url = 'app/purchaseOrder/getApprovedPurchasedDetail?purchaseDateFrom=' + purchaseData.requestFromDate + '&purchaseDateTo=' + purchaseData.requestToDate + '&status=' + $scope.declaredValue + '&entityId=' + requestCode.id + '&quoteStatus=' + 31 + '&purchaseType=' + $scope.purchaseOrder.purchaseType;
                $http.get(url).success(function(data) {
                    if (data) {
                        console.log("TotalResponse is");
                        console.log(data);
                        $scope.rowCollection = data;

                    }
                }).error(function(data) {
                    logger.logError("Error Please Try Again");
                });
            } else {
                // toaster.pop('error', "Please fill the required fields",
                // logger.getErrorHtmlNew(purchaseOrderRequestForm.$validationSummary),
                // 555000, 'trustedHtml');
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.purchaseOrderRequestForm.$validationSummary), 555000, 'trustedHtml');

            }
        };

        $scope.getQuoteStatus = function(value) {
            switch (value) {
            case "71":
                $scope.declaredValue = 33;
                break;
            case "72":
                $scope.declaredValue = 34;
                break;
            case "73":
                $scope.declaredValue = 35;
                break;
            case "74":
                $scope.declaredValue = 36;
                break;
            }

        };

        $scope.chkAllPurchase = false;
        $scope.checkAllPurchase = function(rowCollection, checkBox) {
            if (checkBox) {
                $scope.chkAllPurchase = true;
            } else {
                $scope.chkAllPurchase = false;
            }
            console.log("Row Collection");
            console.log($scope.rowCollection);
            angular.forEach($scope.rowCollection, function(value) {
                if (value.vendorMinQty != null) {
                    if (Number(value.quantity) < Number(value.vendorMinQty)) {
                        // value.quantity = Number(value.vendorMinQty);
                        // $scope.
                        (value);
                        logger.logError("For few items, the order quantity is lower than the minimum order quantity.");

                    }
                }

                value.isSelected = $scope.chkAllPurchase;

            });

            /*
             * angular.forEach($scope.rowCollection, function (value,key) {
             * value.isSelected = $scope.chkAllPurchase; });
             */

        };

        $scope.checkAllPurchaseDisabled = function(itemId) {

            angular.forEach($scope.rowCollection, function(value) {
                if (itemId == value.itemId) {
                    if (value.vendorMinQty != null) {
                        if (Number(value.quantity) < Number(value.vendorMinQty)) {
                            // value.quantity = Number(value.vendorMinQty);
                            // $scope.calculateTaxDiscountEdit(value);
                            logger.logError("For the selected item, the Vendor minimum qty is greater than the requested quantity.");

                        }
                    }

                }

            });
        }
        // }

    });

    app.controller('purchaseQuotationDetailCtrlPO', function($scope, $location, $http, ngDialog, logger, requestCode, $injector, sharedProperties, toaster, $rootScope, validationService, $timeout, poNumber) {

        $scope.isEditDetail = false;
        $scope.isUpload = false;
        $scope.tableDetails1 = [];
        $scope.purchaseQuotation.quotationDetailList = [];
        $scope.cancelReq = function() {
            $scope.purchaseQuotation.quotationDetailList = [];
            $scope.tableDetails1 = [];
            $scope.itemList = [];
            $scope.quotationDetail.requisitionId = "";
            ngDialog.close();
            if ($rootScope.isEdit == true) {
                $rootScope.isEdit = true;
                $scope.isEdit = true;
            }
        };

        $scope.vendorUomId = {};

        $scope.quotationDetail = {
            quotationDetailId : 0,
            quotationId : 0,
            requisitionId : '',
            requisitionNo : '',
            itemId : '',
            quantity : '',
            eddDate : '',
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
            statuschange : false,
            percentage : '',
            amount : '',
            disAmt : 0,
            taxAmt : 0,
            deliveryLeadTime : '',
            queryStatus : 34,
            unitPrice : '',
            itemCode : '',
            status : '',
            reqDate : '',
            itemName : '',
            itemDescription : '',
            taxPercentage : 0,
            taxAmount : 0,
            subTaxPercentage : 0,
            subTaxAmount : 0,
            rowSubTotal : 0,
            discountAmount : '',
            discountPercent : '',
            uom : 0,
            uomName : '',
            cityName : '',
            stateName : '',
            pincode : '',
            country : '',
            vendoruom : '',
            vendorQuantity : '',
            vendorConvertedQuantity : '',
            vendorId : ''
        }
        $scope.purchaseQuotation = {
            quotationNo : '',
            quoteDate : '',
            purchaseFor : '',
            purchaseType : '',
            vendorId : '',
            validFromDate : '',
            validToDate : '',
            paymentTerms : '',
            fixedPrice : 'N',
            fixedQty : 'N',
            subTotal : 0,
            totalDiscount : 0,
            totalTax : 0,
            grandTotal : 0,
            companyId : '',
            vendorLocId : '',
            vendorLocName : '',
            quotationDetailList : []
        };
        $scope.ItemDetailTable = [ {
            itemCode : '',
            itemName : '',
            itemDesc : '',
            EDD : '',
            purchaseUOM : '',
            purchaseReqQuantity : '',
            vendorUOM : '',
            vendorQuantity : '',
            unitPrice : '',
            tax : '',
            taxType : '',
            discount : '',
            discountType : '',
            leadTime : ''
        } ];
        $scope.isEdit = false;
        $scope.purchaseQuotation = $rootScope.purchaseOrder;

        $scope.po_wo_check = $scope.purchaseQuotation.reqType;
        // $scope.purchaseQuotation.quotationDetailList = '';
        $scope.resetPurchaseQuotationDetail = function(purchaseQuoteRequestForm) {
            $scope.quotationDetail = {
                quotationDetailId : 0,
                quotationId : 0,
                requisitionId : '',
                requisitionNo : '',
                itemId : '',
                quantity : '',
                eddDate : '',
                taxId : '',
                statuschange : false,
                taxTypeId : '',
                taxIdslist : [],
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
                queryStatus : 33,
                unitPrice : '',
                itemCode : '',
                status : '',
                reqDate : '',
                itemName : '',
                itemDescription : '',
                taxPercentage : 0,
                taxAmount : 0,
                subTaxPercentage : 0,
                subTaxAmount : 0,
                rowSubTotal : 0,
                discountAmount : '',
                discountPercent : '',
                uom : 0,
                uomName : '',
                cityName : '',
                stateName : '',
                pincode : '',
                country : '',
                vendoruom : '',
                vendorQuantity : '',
                vendorConvertedQuantity : '',
                purchaserequest : false
            }

        };
        $scope.uomCategoryList = [];

        $http.get("app/hospital/inventory/manageUOM/uomCategoryList").success(function(datas) {
            $scope.uomCategoryList = datas.uomCategoryList;
        });
        $scope.$watch("quotationDetail.vendoruom", function(newValue, oldValue) {
            if (newValue != '') {
                angular.forEach($scope.uomCategoryList, function(value, key) {
                    if (value.id == newValue) {
                        $scope.quotationDetail.vendorUomName = value.text;
                    }
                });
            }
        });

        var readonly = false;
        $scope.checkgstexist = function(trindex) {
            // angular.forEach($scope.tableDetails1, function(value, index) {
            var taxCGST = Number($scope.tableDetails1[trindex].taxCGST);
            var taxSGST = Number($scope.tableDetails1[trindex].taxSGST);
            var taxIGST = Number($scope.tableDetails1[trindex].taxIGST);

            var Tot = taxCGST + taxSGST;
            if (Tot != 0) {
                $scope.tableDetails1[trindex].taxIGST = 0;
                ++trindex;
                logger.logError("Row" + "  " + trindex + "  " + "IGST Shouldn't be Create because CGST and SGST Already Created!");
                readonly = true;
            } else if (Tot == 0) {

            }/*
                 * else if(taxIGST !=0){ logger.logError("CGST & SGST Shouldn't
                 * be Create because IGST Already Created!"); }
                 */

            // });
        }
        $scope.checkgstexistIGST = function(trIndex,GST) {
            var taxCGST = Number($scope.tableDetails1[trIndex].taxCGST);
            var taxSGST = Number($scope.tableDetails1[trIndex].taxSGST);
            var taxIGST = Number($scope.tableDetails1[trIndex].taxIGST);
            
            if(GST == "CGST"){
                $scope.tableDetails1[trIndex].taxSGST = taxCGST;
            }
            if(GST == "SGST"){
                $scope.tableDetails1[trIndex].taxCGST = taxSGST;
            }
            
            if (taxIGST != 0) {
                $scope.tableDetails1[trIndex].taxCGST = 0;
                $scope.tableDetails1[trIndex].taxSGST = 0;
                ++trIndex;
                logger.logError("Row" + "  " + trIndex + "  " + "CGST & SGST Shouldn't be Create because IGST Already Created!");

            }
            
            
            
        }
        // select All

        $scope.selectAllrows = function(flag) {
            debugger;

            if ($scope.tableDetails1.length > 0) {
                if (flag) {
                    angular.forEach($scope.tableDetails1, function(row, index) {
                        row.selectCheckBox = true;
                    });
                } else {
                    angular.forEach($scope.tableDetails1, function(row, index) {
                        row.selectCheckBox = false;
                    });
                }
            } else {
                if (flag) {
                    $scope.selectAll = false;
                    logger.logError("No Records Found!...");
                }

            }

        }

        // $scope.quotationDetail.purchaserequest = ;
        $scope.purchaserequest = function(purchaserequest) {
            if (purchaserequest == true) {
                $scope.callDialog($scope, 0, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope);

            }
        }

        /**
         * validation
         */
        $rootScope.validatePQDetail = function(purchaseQuoteRequestForm, quotationDetail) {
            var flag = true;
            var success = false;
            $scope.purchaseQuotation.quotationDetailList = [];
            $scope.copytablerow = [];
            var isSelectItem = false;
            if ($scope.tableDetails1.length > 0) {
                var selectFlagPQ = false;
                var UnitpriceFlag = false;
                angular.forEach($scope.tableDetails1, function(rw, id) {
                    if (rw.selectCheckBox) {
                        selectFlagPQ = true;
                        if(rw.unitPrice ==0 || rw.unitPrice ==undefined || rw.unitPrice =='')
                        UnitpriceFlag = true;
                    }
                });
                angular.forEach($scope.tableDetails1, function(value, index) {
                    if (value.selectCheckBox) {
                        if(UnitpriceFlag == false){
                        if (value.vendorUOM != '' && value.vendorUOM != undefined && value.vendorUOM != null) {
                            if (value.vendorQuantity != '' && value.vendorQuantity != undefined && value.vendorQuantity != null) {
//                                if (value.unitPrice != '' && value.unitPrice != undefined && value.unitPrice != null) {

//                                    if (value.vendorQuantity <= value.quantity ) {
                                    // if (value.taxCGST != '' && value.taxCGST
                                    // != undefined && value.taxCGST != null) {
                                    /*
                                     * if (value.taxSGST != '' && value.taxSGST !=
                                     * undefined && value.taxSGST != null) { if
                                     * (value.taxIGST != '' && value.taxIGST !=
                                     * undefined && value.taxIGST != null) {
                                     */
                                    success = true;
                                    // $scope.tablerow.push(value);
                                    $scope.purchaseQuotation.quotationDetailList.push(value);
                                    $scope.getListPQ = {
                                        status : '',
                                        entityId : '',
                                        purchaseType : '',
                                        poNumber : ''
                                    }
                                    /* if (arrayLength == i) { */
                                    // $scope.saveDetail($scope.totalTaxAmount);
                                    // $scope.saveQuotation = function(){
                                    /*
                                     * } else { logger.logError("Row
                                     * "+(index+1)+", please fill Tax IGST"); } }
                                     * else { logger.logError("Row
                                     * "+(index+1)+", please fill Tax SGST"); }
                                     */
                                    // } else {
                                    // logger.logError("Row "+(index+1)+",
                                    // please fill Tax CGST");
                                    // }
                                    
//                                    } else {
//                                        logger.logError("Row " + (index + 1) + ", Vendor quanity should be less or equal to the Purchase quantity");
//                                    }
                                    
//                                    } else {
//                                    logger.logError("Row " + (index + 1) + ", please fill Unit Price");
//                                }

                            } else {
                                logger.logError("Row " + (index + 1) + ", please fill Vendor Quantity");
                            }
                        } else {
                            logger.logError("Row " + (index + 1) + ", please fill Vendor UOM");
                        }
                        }else {
                            logger.logError("Row " + (index + 1) + ", please fill Unit Price");
                        }

                    } else {
                      
                            if(!selectFlagPQ)
                        logger.logError("Select Atleast one Row!");
                    }
                });
                if ($scope.purchaseQuotation.quotationDetailList.length > 0) {

                    var flag = false;
                    var existsItem = false;
                    if ($scope.rowCollectionItem.length > 0) {

                        var length = $scope.rowCollectionItem.length;
                        var length1 = $scope.purchaseQuotation.quotationDetailList.length

                        for (var i = 0; i < length1; i++) {
                            angular.forEach($scope.rowCollectionItem, function(value, index) {

                                if (angular.equals($scope.purchaseQuotation.quotationDetailList[i].itemId, value.itemId) && angular.equals($scope.purchaseQuotation.quotationDetailList[i].prRequestNo, value.requisitionNo)) {

                                    existsItem = true;
                                    logger.logError("Row " + (++i) + " " + "Item Already added in PurchaseOrder");

                                }
                                ;

                            });
                        }

                    }
                    if (existsItem == false) {
                        $scope.calculationTaxDetails($scope.purchaseQuotation.quotationDetailList);
                        $http.post("hospital/purchase/quotation/save", $scope.purchaseQuotation).success(function(response) {

                            if (response.success == true) {
                                // logger.logSuccess("Saved Successfully");
                                //                       
                                $scope.getListPQ.status = $scope.purchaseQuotation.quotationDetailList[0].queryStatus;
                                $scope.getListPQ.entityId = $scope.purchaseQuotation.vendorId;
                                // $scope.quoteStatus
                                $scope.getListPQ.purchaseType = $scope.purchaseQuotation.purchaseType;

                                $scope.getListPQ.poNumber = $scope.purchaseQuotation.purchaseOrderNum;

                                $scope.getApprovedPurchaseQuotation1($scope.getListPQ);

                                // $scope.purchaseOrderDetails =
                                // $scope.purchaseQuotation.quotationDetailList;
                                // $scope.getListValue($scope.purchaseOrderDetails,true);
                                // $state.go("app.hospital.purchase.purchaseQuotation.list");
                            } else {
                                logger.logError("Unable to Save the records.");
                            }
                        });
                    }
                }
            } else {
                logger.logError("Please select atleast 1 row!");
            }
            /*
             * if (success) { $scope.tableDetails1 = $scope.tablerow; if (new
             * validationService().checkFormValidity(purchaseQuoteRequestForm)) {
             * angular.forEach($scope.tableDetails1, function(value, index) { if
             * (value.selectCheckBox == true) { $scope.tablerow.push(value); }
             * else { isSelectItem = true; } }); for (var i=0; i<$scope.tableDetails1.length;
             * i++) { if($scope.tableDetails1[i].unitPrice<=0){ }else{ var
             * isVendorQuantity=true;
             * angular.forEach($scope.itemList,function(key,index){
             * if(key.id==$scope.tableDetails1[i].itemId){
             * if(key.vendorMinQty!=0){ if($scope.tableDetails1[i].quantity<
             * key.vendorMinQty){ isVendorQuantity=false;
             * $scope.tableDetails1[i].quantity=key.vendorMinQty; } } } });
             * 
             * if(parseInt(quotationDetail[i].vendorQuantity)>0){ var
             * isCheckValid = false; var validQty =
             * (parseInt(quotationDetail[i].purchaseReqQuantity) /
             * quotationDetail[i].vendorQuantity);
             * if(validQty.toString().indexOf('.') == -1){ i=0;
             * $scope.totalTaxAmount=0; $scope.totalTaxPercentageValue=0;
             * $scope.tableDetails1[i].taxCode="";
             * $scope.tableDetails1[i].vendorConvertedQuantity =
             * parseInt(quotationDetail[i].purchaseReqQuantity);
             * $scope.tableDetails1[i].quantity =
             * parseInt(quotationDetail[i].vendorQuantity);
             * 
             * $scope.calculateTaxDetails(quotationDetail[i].tax);
             * 
             * }else{ logger.logError("Invalid Vendor Quantity!"); } }else{
             * logger.logError("Vendor Quantity Should be greater than 0!"); } } } }
             */
            /*
             * } else { toaster.pop('error', "Please fill the required fields",
             * logger.getErrorHtmlNew(purchaseQuoteRequestForm.$validationSummary),
             * 555000, 'trustedHtml'); }
             */
        };

        // assign values in PO itemList
        $scope.rowCollectionItemList = {
            purchaseItemName : '',
            purchaseQuoteId : '',
            edd : '',
            uomName : '',
            unitPrice : '',
            quantity : '',
            oldUnitPrice : '',
            price : '',
            discount : '',
            quoteTaxDetail : [],
            finalTotal : '',
            statusId : ''
        }
        var list = {
            discountType : '',
            taxCGST : '',

            taxSGST : '',
            taxIGST : '',

        }
        $scope.rowCollectionItem1 = [];
        $scope.assignValuesinPO = function(PQitemlist) {
            // $scope.rowCollectionItemList.quoteTaxDetail.push(list);

            var i = 0;
            // angular.forEach(PQitemlist,function(key,index){
            for (var i; i < PQitemlist.length; i++) {
                $scope.rowCollectionItemList.purchaseItemName = PQitemlist[i].itemName;
                $scope.rowCollectionItemList.prRequestNo = PQitemlist[i].prRequestNo;
                $scope.rowCollectionItemList.edd = PQitemlist[i].eddDate;
                $scope.rowCollectionItemList.uomName = PQitemlist[i].uomName;
                $scope.rowCollectionItemList.quantity = PQitemlist[i].vendorQuantity;
                $scope.rowCollectionItemList.purchaseItemId = PQitemlist[i].itemId;
                $scope.rowCollectionItemList.unitPrice = PQitemlist[i].unitPrice;
                $scope.rowCollectionItemList.price = Number(Number(PQitemlist[i].vendorQuantity) * PQitemlist[i].unitPrice).toFixed(2);

                // $scope.rowCollectionItemList.quoteTaxDetail.discountType =
                // PQitemlist[i].discountType;
                $scope.rowCollectionItemList.discount = PQitemlist[i].discount;
                $scope.rowCollectionItemList.finalTotal = 0;
                // $scope.rowCollectionItemList.quoteTaxDetail.taxCGST =
                // PQitemlist[i].taxCGST;
                // $scope.rowCollectionItemList.quoteTaxDetail.taxSGST =
                // PQitemlist[i].taxSGST;
                // $scope.rowCollectionItemList.quoteTaxDetail.taxIGST =
                // PQitemlist[i].taxIGST;
                $scope.rowCollectionItemList.statusId = "72";
                var totalamount = (PQitemlist[i].vendorQuantity) * (PQitemlist[i].unitPrice);
                if (PQitemlist[i].taxCGST != 0) {
                    var taxAmtCGST = (totalamount * ((PQitemlist[i].taxCGST) / 100));
                } else {
                    var taxAmtCGST = 0;
                }
                if (PQitemlist[i].taxAmtSGST != 0) {
                    var taxAmtSGST = (totalamount * ((PQitemlist[i].taxSGST) / 100));
                } else {
                    var taxAmtSGST = 0;
                }
                if (PQitemlist[i].taxAmtIGST != 0) {
                    var taxAmtIGST = (totalamount * ((PQitemlist[i].taxIGST) / 100));
                } else {
                    var taxAmtIGST = 0;
                }
                if (PQitemlist[i].discountType == "58") {
                    // $scope.rowCollectionItemList.quoteTaxDetail.discountType
                    // = PQitemlist[i].discountType;
                    $scope.rowCollectionItemList.quoteTaxDetail.discountType = "Percentage";
                } else if (PQitemlist[i].discountType == "59") {
                    $scope.rowCollectionItemList.quoteTaxDetail.discountType = "Amount";

                }
                // var discountType = PQitemlist[i].discountType;
                // $scope.rowCollectionItemList.quoteTaxDetail.push();
                // $scope.rowCollectionItemList = $scope.itemdetailsList;
                $scope.rowCollectionItemList.quoteTaxDetail.taxCGST = taxAmtCGST.toFixed(2);
                $scope.rowCollectionItemList.quoteTaxDetail.taxSGST = taxAmtSGST.toFixed(2);
                $scope.rowCollectionItemList.quoteTaxDetail.taxIGST = taxAmtIGST.toFixed(2);
                // $scope.rowCollectionItemList.quoteTaxDetail.discountType =
                // PQitemlist[i].discountType;

                $scope.rowCollectionItem1.push($scope.rowCollectionItemList);

                // $scope.rowCollectionItemList = "";
                $scope.rowCollectionItemList = {
                    purchaseItemName : '',
                    purchaseQuoteId : '',
                    edd : '',
                    uomName : '',
                    unitPrice : '',
                    oldUnitPrice : '',
                    price : '',
                    discount : '',
                    quoteTaxDetail : [],
                    finalTotal : ''
                }
                // $scope.rowCollectionItem1[i] = $scope.rowCollectionItemList;
            }

            $scope.rowCollectionItem = $scope.rowCollectionItem1;
            ngDialog.close();
            // $scope.calculationTaxDetails($scope.rowCollectionItem);
            // $scope.addQuoteStatus = "72";
            // $scope.getListValue($scope.rowCollectionItemList.addQuoteStatus);
        }

        $scope.calculationTaxDetails = function(value) {
            $scope.itemdetailsList = value;
            // $scope.itemdetailsList =
            // value.purchaseQuotation.quotationDetailList;
            angular.forEach($scope.itemdetailsList, function(key, index) {

                $scope.purchaseQuotation.quotationDetailList[index].taxCGSTinPercent = $scope.itemdetailsList[index].taxCGST;
                $scope.purchaseQuotation.quotationDetailList[index].taxSGSTinPercent = $scope.itemdetailsList[index].taxSGST;
                $scope.purchaseQuotation.quotationDetailList[index].taxIGSTinPercent = $scope.itemdetailsList[index].taxIGST;

                var discount = 0;
                var totalamount = ($scope.itemdetailsList[index].vendorQuantity) * ($scope.itemdetailsList[index].unitPrice);

                if ($scope.itemdetailsList[index].discountType == 59) {
                    // $scope.itemdetailsList[index].discountType = "Amount";
                    discount = $scope.itemdetailsList[index].discount;

                } else if ($scope.itemdetailsList[index].discountType == 58) {
                    // $scope.itemdetailsList[index].discountType =
                    // "Percentage";

                    // discount =
                    // (Number($scope.itemdetailsList[index].unitPrice) *
                    // Number(($scope.itemdetailsList[index].discount)/100));
                    discount = (Number(totalamount) * Number(($scope.itemdetailsList[index].discount) / 100));
                    $scope.purchaseQuotation.quotationDetailList[index].discountPercent = $scope.itemdetailsList[index].discount;

                } else {
                    $scope.itemdetailsList[index].discountType = 14;
                }
                totalamount = totalamount - discount;

                // var totalamount =
                // ($scope.itemdetailsList[index].vendorQuantity)
                // *($scope.itemdetailsList[index].unitPrice);
                var taxAmtCGST = (totalamount * (($scope.itemdetailsList[index].taxCGST) / 100));
                var taxAmtSGST = (totalamount * (($scope.itemdetailsList[index].taxSGST) / 100));
                var taxAmtIGST = (totalamount * (($scope.itemdetailsList[index].taxIGST) / 100));

                $scope.purchaseQuotation.quotationDetailList[index].taxCGST = taxAmtCGST;
                $scope.purchaseQuotation.quotationDetailList[index].taxSGST = taxAmtSGST;
                $scope.purchaseQuotation.quotationDetailList[index].taxIGST = taxAmtIGST;
                $scope.purchaseQuotation.quotationDetailList[index].discount = discount;
                // $scope.rowCollectionItemList = $scope.itemdetailsList;
                // $scope.rowCollectionItemList.quoteTaxDetail[index].taxCGST =
                // taxAmtCGST;
                // $scope.rowCollectionItemList.quoteTaxDetail[index].taxSGST =
                // taxAmtSGST;
                // $scope.rowCollectionItemList.quoteTaxDetail[index].taxIGST =
                // taxAmtIGST;

            });
            // $scope.addQuoteStatus = "72";
            // $scope.getListValue($scope.rowCollectionItemList.addQuoteStatus);
        }

        $scope.calculationDiscDetails = function(value) {
            $scope.itemdetailsList = value;
            angular.forEach($scope.itemdetailsList, function(key, index) {

                var discount = 0;
                var totalamount = key.netPrice;
                if ($scope.itemdetailsList[index].discountType == 59) {
                    discount = $scope.itemdetailsList[index].discount;

                } else if ($scope.itemdetailsList[index].discountType == 58) {
                    discount = (Number(totalamount) * Number(($scope.itemdetailsList[index].discount) / 100));
                    $scope.rowCollectionItem[index].discountPercent = $scope.itemdetailsList[index].discount;

                } else {
                    $scope.itemdetailsList[index].discountType = 14;
                }

            });
        }

        $scope.validateQuantity = function(quantity) {

            if (quantity <= 0) {
                logger.logError("Quantity Should be Greater than 0!");
                $scope.quotationDetail.quantity = '';
            }
        };

        $scope.validateVendorQuantity = function(quantity, vendorQuantity, trIndex) {
            if (vendorQuantity > quantity) {
                logger.logError("Vendor Quantity Should be lesser than Purchase Quantity!");
                $scope.tableDetails1[trIndex].vendorQuantity = '';
            }
        };

        $scope.validateUnitPrice = function(unitPrice) {
            if (unitPrice <= 0) {
                logger.logError("Unit Price Should be Greater than 0!");
                $scope.quotationDetail.unitPrice = '';
            }
        };

        $scope.onChangeDecimal = function(model, num) {
            if (num <= 0) {
                logger.logError("Unit Price Should be Greater than 0!");
                $scope.quotationDetail.unitPrice = '';
            }
            var floatnum = parseFloat(Math.round(num * 100) / 100).toFixed(2);
            $('#txt' + model).val(floatnum);

            return floatnum;
        }

        $scope.validatePercent = function(discountPercent) {
            if (discountPercent > 100) {
                logger.logError("Percentage Should be Lesser than or Equal to 100!");
                $scope.quotationDetail.discountPercent = '';
            }
        }
        var i = 0;
        $scope.totalTaxAmount = 0;

        $scope.getAddDetails = function() {
            $http.get("hospital/purchase/quotation/getAddDetails").success(function(response) {
                if (response.success == true) {
                    var purchaseList = [];
                    angular.forEach(response.purchaseForList, function(item, key) {
                        var purchaseObj = new Object();
                        purchaseObj.id = response.purchaseForList[key].id;
                        purchaseObj.text = response.purchaseForList[key].text;
                        purchaseList.push(purchaseObj);
                    });
                    $scope.purchaseForList = purchaseList;
                    // purchase_for combo
                    // $scope.purchaseForList = response.purchaseForList;
                    /*
                     * var purchaseList = [];
                     * angular.forEach(response.purchaseForList, function (item,
                     * key) { var purchaseObj = new Object(); purchaseObj.id =
                     * response.purchaseForList[key].value; // vendorObj.text =
                     * response.purchaseForList[key].entityName;
                     * purchaseList.push(purchaseObj); });
                     * $scope.purchaseForList = purchaseList;
                     */
                    // purchase_type combo
//                    $scope.purchaseTypeList = response.purchaseTypeList;

                    // vendor combo
                    var venList = [];
                    angular.forEach(response.vendorList, function(item, key) {
                        var vendorObj = new Object();
                        vendorObj.id = response.vendorList[key].entityId;
                        vendorObj.text = response.vendorList[key].entityName;
                        venList.push(vendorObj);
                    });
                    // $scope.vendorList = venList;
                    var statusList = [];
                    angular.forEach(response.statusList, function(item, key) {
                        var statusObj = new Object();
                        statusObj.id = response.statusList[key].id;
                        statusObj.text = response.statusList[key].text;
                        statusList.push(statusObj);
                    });
                    $scope.statusList = statusList;
                    var discountTypeList = [];
                    angular.forEach(response.discountTypeList, function(item, key) {
                        var disObj = new Object();
                        disObj.id = response.discountTypeList[key].id;
                        disObj.text = response.discountTypeList[key].text;
                        discountTypeList.push(disObj);
                    });
                    $scope.discountTypeList = discountTypeList;
                    // $scope.statusList = response.statusList;
                    // $scope.discountTypeList =response.discountTypeList;

                    $scope.taxList = response.taxList;

                    $timeout(function() {
                        $("#txtTaxId").multiselect({
                            maxHeight : 400,
                            includeSelectAllOption : false,
                            selectAllText : 'Select All',
                            enableFiltering : true,
                            enableCaseInsensitiveFiltering : true,
                            filterPlaceholder : 'Search',
                            numberDisplayed : 1,
                        /*
                         * onChange : function(element, checked) {
                         * jQuery(function(){ var max = 5; var checkboxes =
                         * $('input[type="checkbox"]');
                         * checkboxes.change(function(){ var current =
                         * checkboxes.filter(':checked').length;
                         * checkboxes.filter(':not(:checked)').prop('disabled',
                         * current >= max); }); }); }
                         */
                        });
                    }, 3, false);

                }
            });

        }

        $scope.getAddDetails();

        /**
         * get Tax Details *******************************************
         */

        $scope.addQuoteStatus = "72";
        $scope.getApprovedPurchaseQuotation1 = function(PQvalue) {
            $scope.isEdit = false;
            // if (new
            // validationService().checkFormValidity(purchaseOrderRequestForm))
            // {
            $scope.getQuoteStatus($scope.addQuoteStatus);
            // $scope.callEdit();
            var url = 'app/purchaseOrder/getApprovedPurchasedDetail1?status=' + PQvalue.status + '&entityId=' + PQvalue.entityId + '&purchaseType=' + PQvalue.purchaseType + '&poNumber=' + PQvalue.poNumber;
            $http.get(url).success(function(data) {
                if (data) {
                    console.log("TotalResponse is");
                    console.log(data);
                    if ($rootScope.isEdit == false) {
                        $scope.rowCollectionItem = data;

                        $scope.getListValue1(data, $scope.addQuoteStatus);

                    } else {
                        $scope.isEdit = true;

                        var flag = false;
                        angular.forEach(data, function(value, index) {

                            for (var i = 0; i < $scope.rowCollectionItem.length; i++) {
                                if (value.itemId == $scope.rowCollectionItem[i].itemId && value.requisitionNo == $scope.rowCollectionItem[i].requisitionNo) {
                                    flag = true;
                                }

                            }
                            if (!flag)
                                $scope.rowCollectionItem.push(data[index]);
                            flag = false;

                        });
                        $scope.getListValue1($scope.rowCollectionItem, $scope.addQuoteStatus);

                    }

                }
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });

        };
        $scope.getQuoteStatus = function(value) {
            switch (value) {
            case "71":
                $scope.declaredValue = 33;
                break;
            case "72":
                $scope.declaredValue = 34;
                break;
            case "73":
                $scope.declaredValue = 35;
                break;
            case "74":
                $scope.declaredValue = 36;
                break;
            }

        };
        /**
         * get Discount Details either Discount 'Percentage' or Discount
         * 'Amount' field via ng-show
         */
        $scope.discountPercent = false;
        $scope.discountAmt = false;
        $scope.getDiscountDetails = function(discountTypeId, discountTypeList) {
            angular.forEach(discountTypeList, function(key, index) {
                if (discountTypeList[index].defTableId == discountTypeId) {
                    $scope.quotationDetail.discountType = discountTypeList[index].value;
                    if (discountTypeList[index].value == "Percentage") {
                        $scope.discountAmt = false;
                        $scope.discountPercent = true;
                        $scope.quotationDetail.discountAmount = '';
                    } else if (discountTypeList[index].value == "Amount") {
                        $scope.discountAmt = true;
                        $scope.discountPercent = false;
                        $scope.quotationDetail.discountPercent = '';
                    }
                }
            });
        }

        $scope.onChangeNumber = function(num) {
            num = num.replace(/[^0-9 .]/g, '');
            $('#paymentTerms').val(num);
            return num;
        }

        $scope.removeItemRow = function() {
            console.log("Row collection ITem in delete");
            $scope.purchaseQuotation.quotationDetailList = [];
            $scope.copytablerow = [];
            var isSelectItem = false;
            angular.forEach($scope.tableDetails1, function(value, index) {
                if (value.selectCheckBox == true) {
                    isSelectItem = true;
                } else {
                    $scope.purchaseQuotation.quotationDetailList.push(value);
                }
            });
            if (isSelectItem == false) {
                logger.logError("Please select atleast one item to delete");
            }
            $scope.tableDetails1 = $scope.purchaseQuotation.quotationDetailList;
        };
        $scope.deleteUnselectItem = function() {
            console.log("Row collection ITem in delete");
            $scope.purchaseQuotation.quotationDetailList = [];
            $scope.copytablerow = [];
            var isSelectItem = false;
            angular.forEach($scope.tableDetails1, function(value, index) {
                if (value.selectCheckBox == false) {
                    isSelectItem = true;
                } else {
                    $scope.purchaseQuotation.quotationDetailList.push(value);
                }
            });
            if (isSelectItem == false) {
                logger.logError("Please un select atleast one item to delete");
            }
            $scope.tableDetails1 = $scope.purchaseQuotation.quotationDetailList;
        };

        /**
         * Get Item List with Requisition Number
         */
        $scope.tableDetails1 = [];
        $scope.purchaseQuotation.quotationDetailList = [];
        var countItem = 1;
        var requisitionid = "";
        var PRId = "";
        $scope.$watch("quotationDetail.requisitionId", function(newValue) {
            $scope.purchaseQuotation.quotationDetailList = [];
            var isAvail = false;
            var isExist = false;
            requisitionid = newValue;
            PRId = newValue;

            console.log("QuotationList");
            if (newValue != "" && newValue != undefined && newValue != null) {

                console.log("resultbean");

                // console.log(resultbean);
                // if ($scope.po_wo_check == 'PO') {
                var resultbean = {
                    requisitionId : $scope.quotationDetail.requisitionId,
                    vendorId : $scope.purchaseOrder.vendorId
                }
                $http.post("hospital/purchase/quotation/getItemList", resultbean).success(function(response) {
                    console.log("response.itemList::::::::::::::::getItemList:::::::::::::");
                    console.log(response);
                    if (response.success == true) {
                        var itemsList = [];

                        angular.forEach(response.itemList, function(item, key) {
                            var itemObj = new Object();
                            itemObj.id = response.itemList[key].itemId;
                            itemObj.text = response.itemList[key].itemCode;
                            itemObj.vendorMinQty = response.itemList[key].vendorMinQty;
                            itemsList.push(itemObj);
                        });
                        $scope.itemList = itemsList;
                        $scope.quotationDetail.requisitionNo = response.purchaseQuotationDetail.requisitionNo;
                        $scope.quotationDetail.reqDate = response.purchaseQuotationDetail.reqDate;
                        $scope.quotationDetail.locationName = response.purchaseQuotationDetail.locationName;
                        $scope.quotationDetail.pincode = response.purchaseQuotationDetail.pincode;
                        $scope.quotationDetail.stateName = response.purchaseQuotationDetail.stateName;
                        $scope.quotationDetail.cityName = response.purchaseQuotationDetail.cityName;
                        $scope.quotationDetail.country = response.purchaseQuotationDetail.country;
                        $scope.getitemlist($scope.itemList);
                    } else {
                        $scope.itemList = [];
                        $scope.quotationDetail.requisitionNo = '';
                        $scope.quotationDetail.reqDate = '';
                        $scope.quotationDetail.locationName = '';
                        $scope.quotationDetail.pincode = '';
                        $scope.quotationDetail.stateName = '';
                        $scope.quotationDetail.cityName = '';
                        $scope.quotationDetail.country = '';
                    }
                });
            }

        });

        $scope.getitemlist = function(itemList) {
            $scope.itemList = itemList;
            angular.forEach($scope.itemList, function(item, key) {
                PRId = requisitionid;
                $scope.quotationDetail.requisitionId = "";
                if ($scope.purchaseOrder.reqType == 'PO') {
                    $http.get("hospital/purchase/quotation/getItemIndividual?requisitionId=" + requisitionid + '&itemId=' + item.id).success(function(response1) {
                        var isAvail = false;
                        if (response1.success == true) {
                            if (response1.purchaseQuotationDetail.itemId != "" && response1.purchaseQuotationDetail.itemId != null && response1.purchaseQuotationDetail.itemId != undefined) {
                                // if(response1.purchaseQuotationDetail.quantity
                                // !=
                                // response1.purchaseQuotationDetail.pedningQuantity
                                // )
                                // {
                                $scope.quotationDetail.itemCode = response1.purchaseQuotationDetail.itemCode;
                                $scope.quotationDetail.itemId = response1.purchaseQuotationDetail.itemId;

                                var length = $scope.purchaseQuotation.quotationDetailList.length;
                                for (var i = 0; i < length; i++) {
                                    if ($scope.purchaseQuotation.quotationDetailList[i].itemCode == response1.purchaseQuotationDetail.itemCode && $scope.purchaseQuotation.quotationDetailList[i].requisitionId == $scope.quotationDetail.requisitionId) {
                                        isAvail = true;
                                    }
                                }
                                // isAvail = true;
                                if (isAvail) {
                                    $scope.cnt += 1;
                                    if ($scope.cnt == 1) {
                                        logger.logError("Item already added");
                                    }
                                    $scope.quotationDetail.itemId = '';
                                    $scope.quotationDetail.itemCode = '';
                                    return false;

                                } else {
                                    var table = {
                                        selectCheckBox : '',
                                        prRequestNo : '',
                                        itemCode : '',
                                        itemName : '',
                                        itemDescription : '',
                                        eddDate : '',
                                        purchaseReqQuantity : '',
                                        vendorUOM : '',
                                        vendorQuantity : '',
                                        uom : '',
                                        uomName : '',
                                        vendorUomName : '',
                                        unitPrice : '',
                                        taxCGST : '',
                                        taxSGST : '',
                                        taxIGST : '',
                                        discount : '',
                                        discountType : '',
                                        deliveryLeadTime : ''
                                    };
                                    table.requisitionId = response1.purchaseQuotationDetail.requisitionId;
                                    ;
                                    table.quotationDetailId =  response1.purchaseQuotationDetail.quotationDetailId ;
                                    table.prRequestNo = $scope.quotationDetail.requisitionNo;
                                    table.itemName = response1.purchaseQuotationDetail.itemName;
                                    table.itemDescription = response1.purchaseQuotationDetail.itemDescription;
                                    // $scope.itemDescriptionforTooltip =
                                    // table.itemDescription;
                                    table.eddDate = response1.purchaseQuotationDetail.eddDate;
                                    // table.quantity =
                                    // response1.purchaseQuotationDetail.quantity;
                                    table.uom = response1.purchaseQuotationDetail.uom;
                                    table.uomName = response1.purchaseQuotationDetail.uomName;
                                    // table.vendorUOM =
                                    // response1.purchaseQuotationDetail.vendoruom;
                                    if(response1.purchaseQuotationDetail.altuom != null && 
                                            response1.purchaseQuotationDetail.altuom != undefined &&
                                        response1.purchaseQuotationDetail.altuom != "")
                                    table.vendorUOM = response1.purchaseQuotationDetail.altuom;
                                    else
                                        table.vendorUOM =  response1.purchaseQuotationDetail.uom;
                                    // if
                                    // (response1.purchaseQuotationDetail.pedningQuantity
                                    // > 0) {
                                    var vendorQuantity = response1.purchaseQuotationDetail.quantity;
                                    var pedningQuantity = response1.purchaseQuotationDetail.pedningQuantity;
                                    var qty = pedningQuantity;
                                    table.vendorQuantity = response1.purchaseQuotationDetail.altqty;
                                    table.quantity = qty;

                                    // }
                                    // else {
                                    // table.vendorQuantity =
                                    // response1.purchaseQuotationDetail.quantity;
                                    // table.quantity =
                                    // response1.purchaseQuotationDetail.quantity;
                                    //
                                    // }
                                    table.vendorUomName = response1.purchaseQuotationDetail.vendorUomName;
                                    table.taxCGST = response1.purchaseQuotationDetail.taxCGST;
                                    table.taxSGST = response1.purchaseQuotationDetail.taxSGST;
                                    table.taxIGST = response1.purchaseQuotationDetail.taxIGST;
                                    table.statuschange = false;
                                    table.selectCheckBox = false;
                                    table.queryStatus = 33;
                                    table.availableQty = response1.purchaseQuotationDetail.availableQty;
                                    
                                    table.oldunitPrice = response1.purchaseQuotationDetail.oldunitPrice;
                                    
                                    table.itemId = $scope.quotationDetail.itemId;

                                    // $http.get("app/purchaseOrder/getItemIndividual?requisitionId="
                                    // + table.requisitionId + '&itemId=' +
                                    // table.itemId + '&qty=' +
                                    // table.quantity).success(function(data) {
                                    /*
                                     * $scope.list = data.itemList; if
                                     * ($scope.list.length > 0) {
                                     * angular.forEach($scope.list,
                                     * function(value1, index) {
                                     * 
                                     * 
                                     * 
                                     * if ($scope.tableDetails1.length > 0) {
                                     * var exists = false;
                                     * angular.forEach($scope.tableDetails1,
                                     * function(value, index) {
                                     * 
                                     * if (angular.equals(table.itemId,
                                     * value.itemId)) {
                                     * 
                                     * if (angular.equals(table.itemDescription,
                                     * value.itemDescription)) { exists = true; } } ; })
                                     * if (exists == false && table.itemId !=
                                     * "") { $scope.tableDetails1.push(table); } }
                                     * else { $scope.tableDetails1.push(table); }
                                     * }); // } else {
                                     */if ($scope.tableDetails1.length == 0) {
                                        var flag = false;
                                        var poQty = 0;
                                        var length = $scope.rowCollectionItem.length;
                                        if (length > 0) {
                                            // if($rootScope.isEdit == false){
                                            for (var j = 0; j < length; j++) {
                                                if (angular.equals(table.itemId, $scope.rowCollectionItem[j].itemId) && angular.equals(table.requisitionId, $scope.rowCollectionItem[j].requisitionId)) {

                                                    if (angular.equals(table.itemId, $scope.rowCollectionItem[j].itemId) && angular.equals(table.quantity, Number($scope.rowCollectionItem[j].quantity)) && angular.equals(table.requisitionId, $scope.rowCollectionItem[j].requisitionId)) {
                                                        var POqty = response1.purchaseQuotationDetail.checkQuantity;
                                                        var MRqty = response1.purchaseQuotationDetail.requestedQty;
                                                        if ($rootScope.isEdit == false) {
                                                            flag = false;
                                                        } else {
                                                            if (table.quantity - Number($scope.rowCollectionItem[j].quantity) > 0) {
                                                                flag = true;

                                                            } else if (table.quantity - Number($scope.rowCollectionItem[j].quantity) == 0) {
                                                                if ((MRqty - POqty) > 0)
                                                                    flag = true;
                                                                else
                                                                    flag = false;
                                                            }
                                                        }
                                                        break;
                                                    } else {
                                                        if (angular.equals(table.itemId, $scope.rowCollectionItem[j].itemId) && angular.equals(table.requisitionId, $scope.rowCollectionItem[j].requisitionId)) {
                                                            var MRqty = response1.purchaseQuotationDetail.requestedQty;
                                                            var POqty = response1.purchaseQuotationDetail.checkQuantity;
                                                            var rowQty = POqty - $scope.rowCollectionItem[j].quantity;
//                                                            if (POqty == $scope.rowCollectionItem[j].quantity) {
//
//                                                                poQty = 0;
//                                                            } else {

                                                                if ($rootScope.isEdit == false) {
                                                                    flag = true;

                                                                    var qt = $scope.rowCollectionItem[j].quantity;

                                                                    poQty = qt;
                                                                } else {
                                                                    flag = false;
                                                                    var poId = $location.search().purchaseOrderId;
                                                                    if (poId == undefined || poId == null) {
                                                                        poId = 0;
                                                                    }
                                                                    // flag=
                                                                    // false;
                                                                    $http.get("app/purchaseOrder/getqtyValidation?requisitionId=" + table.requisitionId + '&itemId=' + table.itemId + '&poId=' + poId).success(function(data) {
                                                                        // alert(6);
                                                                        poQty = $scope.rowCollectionItem[j].quantity;
                                                                        // var
                                                                        // Vqt =
                                                                        // response1.purchaseQuotationDetail.pedningQuantity;
                                                                        // if
                                                                        // (Vqt
                                                                        // == 0)
                                                                        // {
                                                                        // table.quantity
                                                                        // =
                                                                        // $scope.rowCollectionItem[j].vendorQuantity;
                                                                        // }

                                                                        var orginalqty = MRqty - POqty;
                                                                        if (data.count > 0) {
                                                                            // table.quantity
                                                                            // =
                                                                            // orginalqty
                                                                            // +
                                                                            // $scope.rowCollectionItem[j].vendorQuantity;

                                                                            var qt = $scope.rowCollectionItem[j].quantity;
                                                                            var Vqt = $scope.rowCollectionItem[j].vendorQuantity;
                                                                            if (data.checkqty + Vqt == qt) {
                                                                                table.quantity = 0;
                                                                                poQty = 0;
                                                                            } else {
                                                                                if (qt > Vqt) {
                                                                                    poQty = qt - Vqt;
                                                                                } else if (qt < Vqt) {
                                                                                    poQty = qt - Vqt;

                                                                                } else if (qt == Vqt) {
                                                                                    poQty = 0;
                                                                                }
                                                                            }

                                                                            table.quantity = table.quantity - poQty;
                                                                            table.vendorQuantity = table.quantity;
                                                                            if (table.quantity > 0)
                                                                                $scope.tableDetails1.push(table);

                                                                        }
                                                                        // table.quantity
                                                                        // =
                                                                        // POqty;
                                                                        else {
                                                                            if (data.checkqty == qt) {
                                                                                table.quantity = 0;
                                                                                poQty = 0;
                                                                            } else {
                                                                                var qt = $scope.rowCollectionItem[j].quantity;
                                                                                // var
                                                                                // orginalqty
                                                                                // =
                                                                                // MRqty
                                                                                // -
                                                                                // POqty;
                                                                                poQty = qt;
                                                                            }

                                                                            table.quantity = table.quantity - poQty;
                                                                            table.vendorQuantity = table.quantity;
                                                                            if (table.quantity > 0)
                                                                                $scope.tableDetails1.push(table);

                                                                        }

                                                                    });
                                                                    break;
                                                                }
//                                                            }
                                                            // flag = true;
                                                            // break;
                                                        }

                                                    }
                                                } else {
                                                    // poQty = 0;
                                                    flag = true;

                                                }

                                            }
                                            if (flag == true) {
                                                table.quantity = table.quantity - poQty;
                                                table.vendorQuantity = table.quantity;
                                                if (table.quantity > 0)
                                                    $scope.tableDetails1.push(table);
                                            }

                                        } else {
                                            if (table.quantity > 0)
                                                $scope.tableDetails1.push(table);
                                        }
                                    } else {
                                        var exists = false;
                                        angular.forEach($scope.tableDetails1, function(value, index) {

                                            if (angular.equals(table.itemId, value.itemId)) {
                                                if (angular.equals(table.prRequestNo, value.prRequestNo)) {
                                                    exists = true;
                                                }
                                            }
                                            ;

                                        })
                                        if (exists == false && table.itemId != "") {
                                            var length = $scope.rowCollectionItem.length;
                                            var flag = false;
                                            var poQty = 0;
                                            if (length > 0) {

                                                for (var j = 0; j < length; j++) {
                                                    if (angular.equals(table.itemId, $scope.rowCollectionItem[j].itemId) && angular.equals(table.requisitionId, $scope.rowCollectionItem[j].requisitionId)) {

                                                        if (angular.equals(table.itemId, $scope.rowCollectionItem[j].itemId) && angular.equals(table.quantity, Number($scope.rowCollectionItem[j].quantity)) && angular.equals(table.requisitionId, $scope.rowCollectionItem[j].requisitionId)) {
                                                            var POqty = response1.purchaseQuotationDetail.checkQuantity;
                                                            var MRqty = response1.purchaseQuotationDetail.requestedQty;
                                                            if ($rootScope.isEdit == false) {
                                                                flag = false;
                                                            } else {
                                                                if (table.quantity - Number($scope.rowCollectionItem[j].quantity) > 0) {
                                                                    flag = true;

                                                                } else if (table.quantity - Number($scope.rowCollectionItem[j].quantity) == 0) {

                                                                    if ((MRqty - POqty) > 0)
                                                                        flag = true;
                                                                    else
                                                                        flag = false;
                                                                }
                                                            }
                                                            break;
                                                        } else {
                                                            if (angular.equals(table.itemId, $scope.rowCollectionItem[j].itemId) && angular.equals(table.requisitionId, $scope.rowCollectionItem[j].requisitionId)) {

                                                                var MRqty = response1.purchaseQuotationDetail.requestedQty;
                                                                var POqty = response1.purchaseQuotationDetail.checkQuantity;
                                                                var rowQty = POqty - $scope.rowCollectionItem[j].quantity;
//                                                                if (POqty == $scope.rowCollectionItem[j].quantity) {
//                                                                    poQty = 0;
//                                                                } else {

                                                                    if ($rootScope.isEdit == false) {
                                                                        flag = true;

                                                                        var qt = $scope.rowCollectionItem[j].quantity;

                                                                        poQty = qt;
                                                                    }

                                                                    else {
                                                                        flag = false;
                                                                        var poId = $location.search().purchaseOrderId;
                                                                        if (poId == undefined || poId == null) {
                                                                            poId = 0;
                                                                        }

                                                                        $http.get("app/purchaseOrder/getqtyValidation?requisitionId=" + table.requisitionId + '&itemId=' + table.itemId + '&poId=' + poId).success(function(data) {

                                                                            var orginalqty = MRqty - POqty;
                                                                            if (data.count > 0) {

                                                                                var qt = $scope.rowCollectionItem[j].quantity;
                                                                                var Vqt = $scope.rowCollectionItem[j].vendorQuantity;
                                                                                if (data.checkqty + Vqt == qt) {
                                                                                    table.quantity = 0;
                                                                                    poQty = 0;
                                                                                } else {
                                                                                    if (qt > Vqt) {
                                                                                        poQty = qt - Vqt;
                                                                                    } else if (qt < Vqt) {
                                                                                        poQty = qt - Vqt;

                                                                                    } else if (qt == Vqt) {
                                                                                        poQty = 0;
                                                                                    }
                                                                                }

                                                                                table.quantity = table.quantity - poQty;
                                                                                table.vendorQuantity = table.quantity;
                                                                                if (table.quantity > 0)
                                                                                    $scope.tableDetails1.push(table);

                                                                            }
                                                                            // table.quantity
                                                                            // =
                                                                            // POqty;
                                                                            else {
                                                                                if (data.checkqty == qt) {
                                                                                    table.quantity = 0;
                                                                                    poQty = 0;
                                                                                } else {
                                                                                    var qt = $scope.rowCollectionItem[j].quantity;

                                                                                    poQty = qt;
                                                                                }

                                                                                table.quantity = table.quantity - poQty;
                                                                                table.vendorQuantity = table.quantity;
                                                                                if (table.quantity > 0)
                                                                                    $scope.tableDetails1.push(table);

                                                                            }

                                                                        });
                                                                        break;
                                                                    }
//                                                                }

                                                                // flag = true;
                                                                // break;
                                                            }

                                                        }
                                                    } else {
                                                        // poQty = 0;
                                                        flag = true;

                                                    }
                                                }
                                                if (flag == true) {

                                                    table.quantity = table.quantity - poQty;
                                                    table.vendorQuantity = table.quantity;
                                                    if (table.quantity > 0)
                                                        $scope.tableDetails1.push(table);
                                                }

                                            } else {
                                                if (table.quantity > 0)
                                                    $scope.tableDetails1.push(table);

                                            }
                                        }
                                    }

                                }

                            }
                        } else {
                            $scope.quotationDetail.itemCode = '';
                            $scope.quotationDetail.itemName = '';
                            $scope.quotationDetail.itemDescription = '';
                            $scope.quotationDetail.eddDate = '';
                            $scope.quotationDetail.quantity = '';
                            $scope.quotationDetail.uom = '';
                            $scope.quotationDetail.uomName = '';
                            $scope.quotationDetail.vendoruom = '';
                            $scope.quotationDetail.vendorUomName = '';
                        }
//                        $scope.tableDetails1
                        $scope.tableDetails1.sort(function (a, b) {
                            return a.quotationDetailId - b.quotationDetailId;
                          });
                    });
                } else {

                    $http.get("hospital/purchase/quotation/getWOitemList?requisitionId=" + requisitionid + '&itemId=' + item.id).success(function(response1) {
                        var isAvail = false;
                        if (response1.success == true) {

                            // if(response1.purchaseQuotationDetail.quantity !=
                            // response1.purchaseQuotationDetail.pedningQuantity
                            // )
                            // {
                            $scope.quotationDetail.itemCode = response1.purchaseQuotationDetail.itemCode;
                            $scope.quotationDetail.itemId = response1.purchaseQuotationDetail.itemId;

                            var length = $scope.purchaseQuotation.quotationDetailList.length;
                            for (var i = 0; i < length; i++) {
                                if ($scope.purchaseQuotation.quotationDetailList[i].itemCode == response1.purchaseQuotationDetail.itemCode && $scope.purchaseQuotation.quotationDetailList[i].requisitionId == $scope.quotationDetail.requisitionId) {
                                    isAvail = true;
                                }
                            }
                            // isAvail = true;
                            if (isAvail) {
                                $scope.cnt += 1;
                                if ($scope.cnt == 1) {
                                    logger.logError("Item already added");
                                }
                                $scope.quotationDetail.itemId = '';
                                $scope.quotationDetail.itemCode = '';
                                return false;

                            } else {
                                var table = {
                                    selectCheckBox : '',
                                    prRequestNo : '',
                                    itemCode : '',
                                    itemName : '',
                                    itemDescription : '',
                                    eddDate : '',
                                    purchaseReqQuantity : '',
                                    vendorUOM : '',
                                    vendorQuantity : '',
                                    uom : '',
                                    uomName : '',
                                    vendorUomName : '',
                                    unitPrice : '',
                                    taxCGST : '',
                                    taxSGST : '',
                                    taxIGST : '',
                                    discount : '',
                                    discountType : '',
                                    deliveryLeadTime : ''
                                };
                                table.requisitionId = response1.purchaseQuotationDetail.requisitionId;
                                ;
                                table.prRequestNo = $scope.quotationDetail.requisitionNo;
                                table.itemName = response1.purchaseQuotationDetail.itemName;
                                table.itemDescription = response1.purchaseQuotationDetail.itemDescription;
                                // $scope.itemDescriptionforTooltip =
                                // table.itemDescription;
                                table.eddDate = response1.purchaseQuotationDetail.eddDate;
                                // table.quantity =
                                // response1.purchaseQuotationDetail.quantity;
                                table.uom = response1.purchaseQuotationDetail.uom;
                                table.uomName = response1.purchaseQuotationDetail.uomName;
                                // table.vendorUOM =
                                // response1.purchaseQuotationDetail.vendoruom;
                                table.vendorUOM = response1.purchaseQuotationDetail.uom;
                                // if
                                // (response1.purchaseQuotationDetail.pedningQuantity
                                // > 0) {
                                var vendorQuantity = response1.purchaseQuotationDetail.quantity;
                                var pedningQuantity = response1.purchaseQuotationDetail.pedningQuantity;
                                var qty = pedningQuantity;
                                table.vendorQuantity = qty;
                                table.quantity = qty;

                                // } else {
                                // table.vendorQuantity =
                                // response1.purchaseQuotationDetail.quantity;
                                // table.quantity =
                                // response1.purchaseQuotationDetail.quantity;
                                //
                                // }
                                table.vendorUomName = response1.purchaseQuotationDetail.vendorUomName;
                                table.taxCGST = response1.purchaseQuotationDetail.taxCGST;
                                table.taxSGST = response1.purchaseQuotationDetail.taxSGST;
                                table.taxIGST = response1.purchaseQuotationDetail.taxIGST;
                                table.statuschange = false;
                                table.selectCheckBox = false;
                                table.queryStatus = 33;

                                table.itemId = $scope.quotationDetail.itemId;

                                /*
                                 * $http.get("app/purchaseOrder/getItemIndividual?requisitionId=" +
                                 * table.requisitionId + '&itemId=' +
                                 * table.itemId + '&qty=' +
                                 * table.quantity).success(function(data) {
                                 * $scope.list = data.itemList; if
                                 * ($scope.list.length > 0) {
                                 * angular.forEach($scope.list, function(value1,
                                 * index) {
                                 * 
                                 * 
                                 * if ($scope.tableDetails1.length > 0) { var
                                 * exists = false;
                                 * angular.forEach($scope.tableDetails1,
                                 * function(value, index) {
                                 * 
                                 * if (angular.equals(table.itemId,
                                 * value.itemId)) { if
                                 * (angular.equals(table.prRequestNo,
                                 * value.prRequestNo)) { exists = true; } } ; })
                                 * if (exists == false && table.itemId != "") {
                                 * $scope.tableDetails1.push(table); } } else {
                                 * $scope.tableDetails1.push(table); } }); }
                                 * else {
                                 */
                                if ($scope.tableDetails1.length == 0) {
                                    if (table.quantity > 0)
                                        $scope.tableDetails1.push(table);
                                } else {
                                    var exists = false;
                                    angular.forEach($scope.tableDetails1, function(value, index) {

                                        if (angular.equals(table.itemId, value.itemId)) {
                                            if (angular.equals(table.prRequestNo, value.prRequestNo)) {
                                                exists = true;
                                            }
                                        }
                                        ;

                                    })
                                    if (exists == false && table.itemId != "") {
                                        var length = $scope.rowCollectionItem.length;
                                        // alert(length);
                                        // angular.forEach($scope.rowCollectionItem,
                                        // function(POitemDetail, index) {
                                        //
                                        // if (angular.equals(table.itemId,
                                        // POitemDetail.itemId)) {
                                        // if (angular.equals(table.quantity,
                                        // POitemDetail.quantity)) {
                                        //
                                        // }
                                        // }
                                        // });
                                        if (table.quantity > 0)
                                            $scope.tableDetails1.push(table);
                                    }
                                }
                                // }
                                // });
                            }

                        } else {
                            $scope.quotationDetail.itemCode = '';
                            $scope.quotationDetail.itemName = '';
                            $scope.quotationDetail.itemDescription = '';
                            $scope.quotationDetail.eddDate = '';
                            $scope.quotationDetail.quantity = '';
                            $scope.quotationDetail.uom = '';
                            $scope.quotationDetail.uomName = '';
                            $scope.quotationDetail.vendoruom = '';
                            $scope.quotationDetail.vendorUomName = '';
                        }
                    });

                }
            });
        }

        $scope.cnt = 0;
        $scope.$watch("quotationDetail.itemId", function(newValue, oldValue, itemobj) {

            if (newValue != "" && newValue != undefined && newValue != null) {
                $http.post("hospital/purchase/quotation/getItem", itemobj.quotationDetail).success(function(response) {
                    var isAvail = false;
                    if (response.success == true) {
                        $scope.quotationDetail.itemCode = response.purchaseQuotationDetail.itemCode;
                        var length = $scope.purchaseQuotation.quotationDetailList.length;
                        for (var i = 0; i < length; i++) {
                            if ($scope.purchaseQuotation.quotationDetailList[i].itemCode == response.purchaseQuotationDetail.itemCode && $scope.purchaseQuotation.quotationDetailList[i].requisitionId == $scope.quotationDetail.requisitionId) {
                                isAvail = true;
                            }
                        }
                        if (isAvail) {
                            $scope.cnt += 1;
                            if ($scope.cnt == 1) {
                                logger.logError("Item already added");
                            }
                            $scope.quotationDetail.itemId = '';
                            $scope.quotationDetail.itemCode = '';
                            return false;

                        } else {
                            $scope.quotationDetail.itemName = response.purchaseQuotationDetail.itemName;
                            $scope.quotationDetail.itemDescription = response.purchaseQuotationDetail.itemDescription;
                            $scope.quotationDetail.eddDate = response.purchaseQuotationDetail.eddDate;
                            $scope.quotationDetail.quantity = response.purchaseQuotationDetail.quantity;
                            $scope.quotationDetail.uom = response.purchaseQuotationDetail.uom;
                            $scope.quotationDetail.uomName = response.purchaseQuotationDetail.uomName;
                            $scope.quotationDetail.vendoruom = response.purchaseQuotationDetail.vendoruom;
                            $scope.quotationDetail.vendorUomName = response.purchaseQuotationDetail.vendorUomName;
                            $scope.quotationDetail.statuschange = false;
                        }
                    } else {
                        $scope.quotationDetail.itemCode = '';
                        $scope.quotationDetail.itemName = '';
                        $scope.quotationDetail.itemDescription = '';
                        $scope.quotationDetail.eddDate = '';
                        $scope.quotationDetail.quantity = '';
                        $scope.quotationDetail.uom = '';
                        $scope.quotationDetail.uomName = '';
                        $scope.quotationDetail.vendoruom = '';
                        $scope.quotationDetail.vendorUomName = '';
                    }
                });
            } else {
                $scope.quotationDetail.itemCode = '';
                $scope.quotationDetail.itemName = '';
                $scope.quotationDetail.itemDescription = '';
                $scope.quotationDetail.eddDate = '';
                $scope.quotationDetail.quantity = '';
                $scope.quotationDetail.uom = '';
                $scope.quotationDetail.uomName = '';
            }
        });

        /**
         * isNan Check...
         */

        $scope.isNaNCheck = function(value) {
            if (isNaN(value)) {
                value = 0;
            }
            return value;
        }
        /**
         * Calculate subTotal, totalDiscount, totalTax, grandTotal and also
         * total Freight...
         */
        /*
         * $scope.calculateGrandTotalAndTaxInfo = function() {
         * 
         * var subTotal = 0, totalDiscount = 0, totalTax = 0, grandTot = 0,
         * totalFreight = 0, totalTaxCGST = 0, totalTaxSGST = 0, totalTaxIGST =
         * 0; angular.forEach($scope.purchaseQuotation.quotationDetailList,
         * function(key, index) { // subTotal = subTotal +
         * parseFloat(key.amount); totalDiscount = totalDiscount +
         * parseFloat(key.disAmt); totalTax = totalTax + parseFloat(key.taxAmt);
         * grandTot = parseFloat(subTotal) + parseFloat(totalTax) -
         * parseFloat(totalDiscount); totalTaxCGST = totalTaxCGST +
         * $scope.purchaseQuotation.quotationDetailList[index].quoteTaxDetail.taxCGST;
         * totalTaxSGST = totalTaxSGST +
         * $scope.purchaseQuotation.quotationDetailList[index].quoteTaxDetail.taxSGST;
         * totalTaxIGST = totalTaxIGST +
         * $scope.purchaseQuotation.quotationDetailList[index].quoteTaxDetail.taxIGST;
         * 
         * }); var totalFreightAmt = $scope.purchaseQuotation.totalFreight; if
         * (totalFreightAmt != "" && totalFreightAmt != undefined) totalFreight =
         * totalFreight + parseFloat(totalFreightAmt);
         * 
         * if (!isNaN(totalFreight)) grandTot = grandTot +
         * parseFloat(totalFreight) // $scope.purchaseQuotation.subTotal =
         * subTotal.toFixed(2); $scope.purchaseQuotation.totalDiscount =
         * totalDiscount.toFixed(2); $scope.purchaseQuotation.totalTaxCGST =
         * totalTaxCGST.toFixed(2); $scope.purchaseQuotation.totalTaxSGST =
         * totalTax.toFixed(2);
         * 
         * $scope.purchaseQuotation.totalTaxIGST = totalTax.toFixed(2);
         * 
         * if (!isNaN(grandTot)) $scope.purchaseQuotation.grandTotal =
         * grandTot.toFixed(2); }
         */

        $scope.editDetail = function() {
            $scope.purchaseQuotation.push($scope.quotationDetail);
        }

        $scope.deleteDetail = function(index) {
            $scope.purchaseQuotation.quotationDetailList.splice(index, 1);
        }

    });
    app.controller('parentCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {

        $scope.validateQty = function(quantity) {
            if (quantity <= 0) {
                logger.logError("Quantity Should be Greater than 0!");
                $scope.rowCollectionItem[$scope.$index].quantity = '';
            }
        };
    });

//});

app.controller('tableCtrlJV', function($scope, $http, $filter, logger) {

    $scope.$watch('ItemDetailTable[trIndex].itemCode', function(newValue, oldValue) {

    });
});