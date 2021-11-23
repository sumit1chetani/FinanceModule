//define([ 'hospital/inventory/inventory' ], function(module) {

    'use strict';

    app.controller('ggrnAddCtrl', function($scope, $stateParams,$state, $http, $location, sharedProperties, toaster, $injector, logger, ngDialog, $rootScope, $controller, $window) {
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages = 0
        $scope.isEdit = false;
        $scope.locationList = [];
        $scope.vendorList = [];
        $scope.poList = [];
        $scope.poDtlList;
        $scope.dtlList = [];
        $scope.companyList = [];
        $scope.reqDtlList;
        $scope.isRate = false;
        $scope.qc = false;
        $scope.rowCollectionDeliveryItem = [];
        $scope.batchListItem = [];
        $scope.grnQCData = [];
        var productRowId = 0;
        $scope.grnData = {
            grnId : '',
            grnCode : '',
            locId : '',
            locName : '',
            vendorId : '',
            poId : '',
            poNo : '',
            poType : '',
            grnDate : '',
            poRequisitionId : '',
            poRequisition : '',
            delOrderNo : '',
            delOrderDate : '',
            invoiceNo : '',
            invoiceDate : '',
            dueDate : '',
            deliveryMthd : '',
            transMode : '1',
            dstLocId : '',
            conTransferNo : '',
            qcLocationId : '',
            companyId : '',
            poFreight : '',
            description : '',
            grnTables : [],
            schDtlList : []
        }

        $scope.purchaseData = {
            vendorId : '',
            city : '',
            state : '',
            zipCode : '',
            country : '',
            address : ''
        }
        $scope.StockTransfor = {
            rowCollection : [],
            transportType : '',
            stockId : '',
            sourceLocName : '',
            destLocName : '',
            serviceName : '',
            personName : '',
            requisition : '',
            companyId : '',
            deliveryMet : '',
            sourceLoc : '',
            destLoc : ''
        };
        $scope.isBatchMrp = false;
        $scope.isBatchExpired = false;
        $scope.cancel = function() {
            $state.go("app.finance.inventory.ggrn.list");
        };
        $scope.reset = function() {
            $scope.grnData = {
                grnId : '',
                grnCode : '',
                locId : '',
                locName : '',
                vendorId : '',
                poId : '',
                poNo : '',
                poType : '',
                grnDate : currentDate,
                poRequisitionId : '',
                poRequisition : '',
                delOrderNo : '',
                delOrderDate : currentDate,
                invoiceNo : '',
                invoiceDate : currentDate,
                deliveryMthd : '',
                transMode : '',
                dstLocId : '',
                conTransferNo : '',
                qcLocationId : '',
                companyId : '',
                grnTables : [],
                schDtlList : []
            }

            $scope.purchaseData = {
                vendorId : '',
                city : '',
                state : '',
                zipCode : '',
                country : '',
                address : ''
            }
            $scope.purchaseOrder = {
                vendorId : '',
                locationId : '',
                purchaseFor : '',
                companyId : '',
                costcenter : '',
                purchaseOrderDate : '',
                purchaseType : 43,
                statusId : '',
                termsCondition : '',
                remarks : '',
                remarksforother : '',
                advanceamt : '',
                currency : '',
                budgetType : '',
                purchaseOrderNum : '',

            };

        }

        // Grn Detail table
        $scope.loadgrnTable = function() {
            var grnTable = {};

            grnTable = {
                poId : '',
                poNo : '',
                poDate : '',
                dtlItemId : '',
                dtlItemCode : '',
                dtlItemName : '',
             costcenter:'',
                dtlItemDesc : '',
                dtlPrice : '',
                dtlQty : '',
                dtlStatus : '',
                dtlPODtlId : '',
                qualityCheck : '',
                sampleQty : '',
                qcStatus : '',
                qcRemarks : '',
                batchDtls : [],
                attributeBeans : [],
                scheduleList : []
            };
            $scope.grnData.grnTables.push(grnTable);
        }
        $scope.loadgrnTable();

        /* Purchsae Order View .. Starts... */
        $scope.ggrnData = {
            ggrnTables : [],
            poId : '',
            poNo : '',
            vendorId : '',
            poDate : '',
            dtlItemId : '',
            dtlItemCode : '',
            dtlItemName : '',
            costcenter:'',
            dtlItemDesc : '',
            dtlPrice : '',
            dtlQty : '',
            dtlStatus : '',
            isQC : '',
            dtlPODtlId : ''

        }

        /* Purchsae Requisition View .. Starts... */
        $scope.grnReqData = {
            ggrnTables : [],
            poId : '',
            poNo : '',
            poDate : '',
            dtlItemId : '',
            dtlItemCode : '',
            dtlItemName : '',
            costcenter:'',
            dtlItemDesc : '',
            dtlPrice : '',
            dtlQty : '',
            dtlStatus : '',
        };
        $scope.rowReqCollection = [];

        var currentDate = new Date();
        currentDate = ('0' + currentDate.getDate()).slice(-2) + "/" + ('0' + (Number(currentDate.getMonth()) + 1)).slice(-2) + "/" + currentDate.getFullYear();
        $scope.grnData.grnDate = currentDate;
        $scope.grnData.delOrderDate = currentDate;
        $scope.grnData.invoiceDate = currentDate;
        $scope.poFullList = [];

        $scope.getDropdownvalue = function() {
            $http.get('app/grn/getLocationList').success(function(datas) {
                debugger
                $scope.locationList = datas.lLocationLst;
            }).error(function(datas) {
            });

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
            /*
             * $http.get("his/inventory/settings/managestores/parentlocationlist").success(function(datas) {
             * $scope.locationList = datas.parentlocationList; });
             */

            $http.get('app/grn/getVendorList').success(function(datas) {
                $scope.vendorList = datas.lVendor;
            }).error(function(datas) {
            });

            $http.get('app/grn/getPOList').success(function(datas) {
                debugger;
                // $scope.poList = datas.lPurchaseOrder;
                $scope.poFullList = datas.lPurchaseOrder;

            }).error(function(datas) {
            });

            $http.get( $stateParams.tenantid +'/app/commonUtility/getCompanyList').success(function(datas) {
                $scope.companyList = datas;
            }).error(function(datas) {
            });
            $http.get($stateParams.tenantid +'/app/commonUtility/getCompanyListPurchase').success(function(datas) {
                $scope.companyList = datas;
            }).error(function(datas) {
            });

            $http.get("app/hospital/inventory/manageUOM/uomCategoryList").success(function(datas) {
                $scope.uomCategoryList = datas.uomCategoryList;
            });
        };

        $scope.getDropdownvalue();
        


        $scope.chkAllPurchase = false;
        $scope.chkAllPurchasefun = function(rowCollection, checkBox) {
            if (checkBox) {
                $scope.chkAllPurchase = true;
            } else {
                $scope.chkAllPurchase = false;
            }
            angular.forEach(rowCollection, function(value, key) {
                if (value.pendingQty > 0) {
                    value.select = $scope.chkAllPurchase;
                }

            });
        };
        $scope.uomdifferFlag = false;
        $scope.uomValidation = function(Puom,Vuom,Pqty,Vqty,index){
            
            if((Puom != Vuom)){
                logger.logError("Row - "+ (index+1)+" Please Enter Converted Quantity Details!");
                $scope.grnData.grnTables[index].dtlQty = 0;
                $scope.grnData.grnTables[index].convertedQtyNew  = 0;
                
            }else{
                $scope.grnData.grnTables[index].convertedQtyNew  = $scope.grnData.grnTables[index].dtlQty ;
            }
            
        }
        
        $scope.calculateConvertedQuantity = function(dtlQty, convQty, index, originalConvertedQty, purReqQuantity, vendorQuantity, pendingQty,Puom,Vuom,Pqty,Vqty) {
 
                // $scope.grnData.grnTables[index].dtlQty =
                // originalConvertedQty;
                if (!$scope.isEdit) {
                    if (dtlQty > pendingQty) {
                        logger.logError("Receiving Quantity Cannot be Increased!");
                    $scope.grnData.grnTables[index].dtlQty = 0;
                }
                // $scope.grnData.grnTables[index].dtlQty = 0;

            } else {
                // var convertedQuantity = (parseInt(purReqQuantity) /
                // parseInt(vendorQuantity));
                // var quantityConvert = parseInt(dtlQty) * convertedQuantity;
                $scope.grnData.grnTables[index].convertedQty = dtlQty;
            }
                $scope.uomValidation( Puom,Vuom,Pqty,Vqty,index);
        };

        $scope.calculateConvertedQuantityUOM = function(dtlQty, convQty, index, originalConvertedQty, purReqQuantity, vendorQuantity, pendingQty,Puom,Vuom,Pqty,Vqty) {
 
                // $scope.grnData.grnTables[index].dtlQty =
                // originalConvertedQty;
                if (!$scope.isEdit) {
                    if (dtlQty > pendingQty) {
                        logger.logError("Receiving Quantity Cannot be Increased!");
                    $scope.grnData.grnTables[index].dtlQty = 0;
                }
                // $scope.grnData.grnTables[index].dtlQty = 0;

            } else {
                // var convertedQuantity = (parseInt(purReqQuantity) /
                // parseInt(vendorQuantity));
                // var quantityConvert = parseInt(dtlQty) * convertedQuantity;
                $scope.grnData.grnTables[index].convertedQty = dtlQty;
            }
//                $scope.uomValidation( Puom,Vuom,Pqty,Vqty,index);
        };
        


        $scope.getPODtlList = function(model) {
            $http.get('app/grn/getPODtlList?poId=' + model).success(function(datas) {
                $scope.poDtlList = [];
                $scope.poDtlListFinal = [];
                $scope.grnData.grnTables = [];
//                var freightCheck = 0;
//                var otherChargesCheck = 0;
                
                //get GRN Freight and Other charges
                if(freightCheck != datas.grnFreight){
                    $scope.grnData.freight = freightCheck - datas.grnFreight;
                    freightCheck = $scope.grnData.freight;
                }else{
                    $scope.grnData.freight = freightCheck - datas.grnFreight;
                    freightCheck = $scope.grnData.freight;
                }
                    if(otherChargesCheck != datas.grnOtherCharges){
                        $scope.grnData.otherCharges = otherChargesCheck - datas.grnOtherCharges;      
                        otherChargesCheck = $scope.grnData.otherCharges;
                    }else{
//                        if(otherChargesCheck != datas.grnOtherCharges){
                            $scope.grnData.otherCharges = otherChargesCheck - datas.grnOtherCharges;      
                            otherChargesCheck = $scope.grnData.otherCharges;
//                        }
                    
                    }
              
                angular.forEach(datas.lPurchaseOrderDtl, function(value, index) {
                    if (value.pendingQty != 0) {
                        $scope.poDtlListFinal[index] = value;
                        $scope.poDtlListFinal[index].dtlPrice = parseFloat(value.dtlPrice).toFixed(2);
                        var convertedQty = (parseInt(value.purReqQuantity) / value.vendorQuantity);
                        // $scope.poDtlListFinal[index].convertedQty =
                        // value.dtlQty * convertedQty;
                        $scope.poDtlListFinal[index].convertedQty = value.dtlQty;
                        if(value.vendorUOM != "" && value.vendorUOM != null)
                        $scope.poDtlListFinal[index].vendorUOM =  parseInt(value.vendorUOM),
                        $scope.poDtlListFinal[index].dtlQty = 0;
                        $scope.poDtlListFinal[index].convertedQtyNew = 0;
                        $scope.grnData.grnTables.push(value);
                    }
                });
                $scope.poDtlList = $scope.poDtlListFinal;
                // $scope.grnData.grnTables = [];
                // $scope.grnData.grnTables = $scope.poDtlListFinal;
            }).error(function(datas) {
            });

            $http.get('app/grn/getRequisition?poId=' + model).success(function(datas) {

                if (datas.lRequisitionList != undefined && datas.lRequisitionList.length > 0) {
                    angular.forEach(datas.lRequisitionList, function(value, index) {
                        if (index > 0) {
                            $scope.grnData.poRequisition += " , " + value.poRequisition;
                            $scope.grnData.poRequisitionId += "," + value.poRequisitionId;
                        } else {
                            $scope.grnData.poRequisition = value.poRequisition;
                            $scope.grnData.poRequisitionId = value.poRequisitionId;
                        }

                    });
                } else {
                    $scope.grnData.poRequisition = '';
                    $scope.grnData.poRequisitionId = '';
                }

                $scope.reqDtlList = [];
                if (datas.lRequisitionDtl != undefined && datas.lRequisitionDtl.length > 0) {
                    $scope.reqDtlList = datas.lRequisitionDtl;
                }

            }).error(function(datas) {
            });
        };
        
        $scope.$watch("grnData.companyId", function(newValue, oldValue) {
            var companyCode = $scope.grnData.companyId;
            // $scope.purchaseOrder.purchaseOrderNum = "";
          //  $scope.getCompanydropdowm(companyCode);


            $http.get('app/purchaseOrder/costcenterList?companyId=' + companyCode).success(function(datas) {
                $scope.costList = datas;
            });

        });
        $scope.$watchCollection('[grnData.companyId,grnData.vendorId]', function(newValue, oldVal) {
            if (newValue != null && newValue != undefined && newValue != '') {
                if($scope.grnData.companyId != null && $scope.grnData.companyId != undefined && $scope.grnData.companyId != '' &&
                        $scope.grnData.vendorId != null && $scope.grnData.vendorId != undefined && $scope.grnData.vendorId != ''  )
                    {

                    $http.get('app/grn/getPOListbasedonCompany?companyId=' + $scope.grnData.companyId + '&vendorId=' + $scope.grnData.vendorId).success(function(datas) {
                        $scope.poList = datas.lPurchaseOrder;
                    });
                    }
/*                $http.get('app/purchaseOrder/costcenterList?companyId=' + $scope.grnData.companyId).success(function(datas) {
                    $scope.costList = datas;
                });
*/
            }
        });
        $scope.$watch('grnData.vendorId', function(newValue, oldVal) {
            if (newValue != '' && newValue != undefined) {
                $http.get('app/grn/getVendorAddress?vendorId=' + newValue).success(function(datas) {
                    // $scope.grnData.locId =
                    // datas.lVendorAddressDtl[0].vendorLoc;
                    $scope.purchaseData.city = datas.lVendorAddressDtl[0].city;
                    $scope.purchaseData.state = datas.lVendorAddressDtl[0].state;
                    $scope.purchaseData.address = datas.lVendorAddressDtl[0].address;
                    $scope.purchaseData.country = datas.lVendorAddressDtl[0].country;
                    $scope.purchaseData.zipCode = datas.lVendorAddressDtl[0].zipCode;

                }).error(function(datas) {
                });
            } else {
                // $scope.grnData.locId = '';
                $scope.purchaseData.city = '';
                $scope.purchaseData.state = '';
                $scope.purchaseData.address = '';
                $scope.purchaseData.country = '';
                $scope.purchaseData.zipCode = '';
            }
        });

        $scope.$watch('grnData.poId', function(newValue, oldValue) {

            if (newValue != '' && newValue != undefined && newValue != null) {
                if (oldValue != "" && oldValue != undefined && oldValue != null) {
                    if (oldValue != newValue) {
                        $scope.grnData.grnTables = [];
                        $scope.getPurchaseOrderDetails(newValue);
                    } else {
                        $scope.getPurchaseOrderDetails(newValue);
                    }
                } else {
                    $scope.getPurchaseOrderDetails(newValue);
                }

            }
        });
        $http.get("app/inventory/consignmentIn/parentlocationlist").success(function(datas) {
            $scope.parentLocationList = datas;
        });
        var freightCheck = 0;
        var otherChargesCheck = 0;
        
        $scope.getPurchaseOrderDetails = function(newValue) {
            var isFlag = true;
            if ($scope.isEdit == false) {

                $http.get('app/grn/getPOList').success(function(datas) {
                    $scope.poFullList = datas.lPurchaseOrder;

                    angular.forEach($scope.poFullList, function(value, index) {
                        if (isFlag) {
                            if (newValue === value.id) {

                                $scope.grnData.poId = value.id;
                                $scope.grnData.poNo = value.text;
                                $scope.grnData.poType = value.poType;
                                $scope.grnData.remarksforother = value.remarksforother;
                                $scope.grnData.freight = value.poFreight;
                                freightCheck = $scope.grnData.freight;
                                $scope.grnData.otherCharges = value.otherCharges;
                                otherChargesCheck = $scope.grnData.otherCharges;
                                if (!$scope.isEdit) {
                                    // var sourceLocationId =
                                    // value.sourceLocationId;
                                    $scope.grnData.dstLocId = value.locId;
                                    // $scope.grnData.locId = value.locId;

                                }
                                $scope.grnData.vendorId = value.vendorId;
                                $scope.grnData.companyId = value.companyId;
                                $scope.grnData.poFreight = value.poFreight;
                                if (value.poType == 'Rate Contract') {
                                    $scope.isRate = true;
                                } else {
                                    $scope.isRate = false;
                                }

                                $scope.grnData.conTransferNo = value.conTransferNo;

                                $scope.getPODtlList(value.id);
                                $scope.qc = false;
                                isFlag = false;

                            } else {

                                $scope.grnData.poId = '';
                                $scope.grnData.poNo = '';
                                $scope.grnData.poType = '';
                                $scope.grnData.conTransferNo = '';
                                $scope.grnData.vendorId == '';
                                $scope.grnData.poFreight = '';
                                $scope.poDtlList = [];
                            }
                        }
                    });

                }).error(function(datas) {
                });
            }

        }

        $scope.loadVendorAddress = function() {
            var vendorId = $scope.grnData.vendorId;
            $http.get('app/grn/getVendorAddress?vendorId=' + vendorId).success(function(datas) {
                $scope.purchaseData.city = datas.lVendorAddressDtl[0].city;
                $scope.purchaseData.state = datas.lVendorAddressDtl[0].state;
                $scope.purchaseData.address = datas.lVendorAddressDtl[0].address;
                $scope.purchaseData.country = datas.lVendorAddressDtl[0].country;
                $scope.purchaseData.zipCode = datas.lVendorAddressDtl[0].zipCode;
            }).error(function(datas) {
            });
        }

        /** ** Auto suggestion text box for Purchase order **** */

        $scope.formatLabel = function(model) {
            var isFlag = true;
            if ($scope.poList.length > 0) {
                for (var i = 0; i < $scope.poList.length; i++) {
                    if (isFlag) {
                        if (model === $scope.poList[i].poId) {
                            $scope.grnData.poId = $scope.poList[i].poId;
                            $scope.grnData.poNo = $scope.poList[i].poNo;
                            // $scope.getPODtlList(model);
                            isFlag = false;
                        }
                    }
                }
            } else {
                $scope.grnData.poId = model;
                $scope.poDtlList = [];
            }
            return $scope.grnData.poNo;
        }

        $scope.calculateExpDate = function(str) {
            var expDate = "";
            if (/^\d{2}\/\d{2}\/\d{4}$/i.test(str)) {

                var parts = str.split("/");
                var day = parts[0] && parseInt(parts[0], 10);
                var month = parts[1] && parseInt(parts[1], 10);
                var year = parts[2] && parseInt(parts[2], 10);
                var duration = parseInt(1, 10);

                if (day <= 31 && day >= 1 && month <= 12 && month >= 1) {

                    var expiryDate = new Date(year, month - 1, day);
                    expiryDate.setFullYear(expiryDate.getFullYear() + duration);

                    var day = ('0' + expiryDate.getDate()).slice(-2);
                    var month = ('0' + (expiryDate.getMonth() + 1)).slice(-2);
                    var year = expiryDate.getFullYear();

                    expDate = day + "/" + month + "/" + year;

                } else {
                    // display error message
                }
            }
            return expDate;
        }

        $scope.callDialogPopUp = function($scope, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, rowId,rowdetail) {
            ngDialog.open({
                scope : $scope,
                template : 'views/hospital/inventory/ggrn/convertedQtyView',
                controller : $controller('convertedQtyViewCtrl', {
                    $scope : $scope,
                    $http : $http,
                    ngDialog : ngDialog,
                    logger : logger,
                    $injector : $injector,
                    sharedProperties : sharedProperties,
                    toaster : toaster,
                    $rootScope : $rootScope,
                    rowdetailList : rowdetail,
                    rowId:rowId
                }),
                className : 'ngdialog-theme-plain',
                showClose : false,
                closeByDocument : false,
                closeByEscape : false,
                preCloseCallback : $scope.getList
            });
        }
        // NG DIALOG FOR PURCHASE ORDER DETAILS
        $scope.getPurchaseInfo = function() {
            if ($scope.grnData.poId != '' && $scope.grnData.poId != undefined)
                $scope.callPurchaseDialog($scope, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope);
            else
                logger.logError("Please Select Purchase Order..");
        };

        $scope.callPurchaseDialog = function($scope, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope) {
            ngDialog.open({
                scope : $scope,
                template : 'views/finance/inventory/ggrn/ggrnviewpurchase',
                controller : $controller('poPopupCtrl', {
                    $scope : $scope,
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

            $scope.ggrnData = $scope.poDtlList;

            $scope.rowCollection = $scope.ggrnData;

        }

        $scope.fetchDetail = function(value) {

            $scope.finalList = [];
            var schIndx = 0;
            var scheduleLt = [], batchLst = [];
            angular.forEach(value, function(row, index) {

                var scheduleList = [];
                if (row.select != undefined && row.select != false) {
                    var obj = '';
                    obj = row;
                    if (!$scope.isRate) {
                        obj.dtlQty = row.pendingQty;
                        // var convertedQty = (parseInt(row.purReqQuantity) /
                        // row.pendingQty);
                        // obj.convertedQty = row.pendingQty * convertedQty;
                        obj.convertedQty = row.pendingQty;
                    } else {
                        obj.dtlQty = 0;
                        var convertedQty = (parseInt(row.purReqQuantity) / row.vendorQuantity);
                        // obj.convertedQty = row.pendingQty * convertedQty;
                        obj.convertedQty = row.pendingQty;
                        row.scheduleList[0].convertedQty = obj.convertedQty;
                        row.scheduleList[0].originalConvertedQty = obj.originalConvertedQty;
                        row.scheduleList[0].purReqQuantity = obj.purReqQuantity;
                    }
                    if (row.qualityCheck)
                        $scope.qc = true;

                    obj.mrp = '';
                    $scope.finalList.push(obj);
                    if ($scope.isRate) {
                        if (row.scheduleList != undefined && row.scheduleList.length != 0) {
                            angular.forEach(row.scheduleList, function(rowData, indexs) {
                                scheduleList[indexs] = rowData;
                            });
                        }
                    }

                    angular.forEach(scheduleList, function(data, dataindex) {
                        scheduleLt[schIndx] = data;
                        schIndx++;
                    });
                    if ($scope.grnData.poType != "Consignment Po") {
                        row.batchDtls = batchLst;
                    }
                } else {
                    // $scope.finalList =[];
                }
            });
            if ($scope.finalList.length > 0) {
                // $scope.grnData.grnTables = $scope.finalList;
                $scope.rowCollectionDeliveryItem = scheduleLt;
                $scope.grnData.schDtlList = scheduleLt;
                $scope.ngcancel();
            } else {
                logger.logError("Please Select check box");
            }

        }

        // NG DIALOG FOR REQ ORDER DETAILS
        $scope.getReqInfo = function() {

            if ($scope.grnData.poId != '' && $scope.grnData.poId != undefined)
                $scope.callreqDialog($scope, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope);
            else
                logger.logError("Please Select Purchase Order..");

        };

        $scope.callreqDialog = function($scope, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope) {
            ngDialog.open({
                scope : $scope,
                template : 'views/finance/inventory/ggrn/ggrnviewreq',
                controller : $controller('poPopupCtrl', {
                    $scope : $scope,
                    $http : $http,
                    ngDialog : ngDialog,
                    logger : logger,
                    $injector : $injector,
                    toaster : toaster,
                    $rootScope : $rootScope
                }),
                className : 'ngdialog-theme-plain',
                showClose : false,
                closeByDocument : false,
                closeByEscape : false,
                preCloseCallback : $scope.getList
            });

            $scope.grnReqData = $scope.reqDtlList;
            $scope.rowReqCollection = $scope.grnReqData;

        }

        /* Batch Dtls.. Starts... */
        $scope.loadgrnBatchDtls = function() {

            var grnBatchDtls = [], grnBatchDtlObj = {
                batchItemId : '',
                batchItemName : '',
                batchQty : '',
                lotNo : '',
                expiryDate : '',
                originalConvertedQty : 0,
                manufactureDef : '',
                mrp : ''
            }
            grnBatchDtls.splice(0, 0, grnBatchDtlObj);
            $scope.grnData.grnTables[productRowId].batchDtls = grnBatchDtls;
        }

        // add Batch Row
        $scope.addBatchRow = function(tables) {

            $scope.isBatchMrp = false;
            $scope.isBatchExpired = false;
            var table = {
                batchItemId : $scope.grnData.grnTables[productRowId].batchDtls[0].batchItemId,
                batchItemName : $scope.grnData.grnTables[productRowId].batchDtls[0].batchItemName,
                batchQty : '',
                lotNo : '',
                originalConvertedQty : 0,
                expiryDate : $scope.calculateExpDate(currentDate),
                manufactureDef : '',
                mrp : ''
            };

            $scope.grnData.grnTables[productRowId].batchDtls.push(table);

        };

        // remove Row
        $scope.removeBatchRow = function(table) {
            $scope.tablerow = [];
            var table = $scope.grnData.grnTables[productRowId].batchDtls;

            if ($scope.grnData.grnTables[productRowId].batchDtls.length <= 1) {
                logger.logError("Item Batch Details Should be Atleast One Row!");
            } else {
                angular.forEach(table, function(row, index) {
                    var check = row.select;
                    if (check == undefined || check == "") {
                        $scope.tablerow.push(row);
                    }
                });
                table = $scope.tablerow;
                $scope.grnData.grnTables[productRowId].batchDtls = $scope.tablerow;
                $scope.batchListItem = $scope.tablerow;
            }

        };
        $scope.ConvertedQtyPopup = function(rowdetail,rowId) {
            if ($scope.grnData.grnTables[rowId].dtlItemId != '' && $scope.grnData.grnTables[rowId].dtlItemId != undefined) {
                productRowId = rowId;
                if ($scope.grnData.grnTables[rowId].purchaseUOM ==$scope.grnData.grnTables[rowId].vendorUOM) {
//                    $scope.callDialogPopUp($scope, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, rowId,rowdetail);
                } else {
                    $scope.callDialogPopUp($scope, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, rowId,rowdetail);
                }

            } else {
                logger.logError("Please Add Item From Purchase Order Details");
            }
        };
        
        
        // NG DIALOG FOR Batch Details
        $scope.getProductInfo = function(rowId) {
            if ($scope.grnData.grnTables[rowId].dtlItemId != '' && $scope.grnData.grnTables[rowId].dtlItemId != undefined) {
                productRowId = rowId;
                if ($scope.grnData.poType == "Consignment Po") {
                    $scope.callDialogConsignmentBatch($scope, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, rowId);
                } else {
                    $scope.callDialog($scope, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, rowId);
                }

            } else {
                logger.logError("Please Add Item From Purchase Order Details");
            }
        };

        $scope.callDialog = function($scope, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, rowId) {
            ngDialog.open({
                scope : $scope,
                template : 'views/finance/inventory/ggrn/ggrnviewproductinfo',
                controller : $controller('poPopupCtrl', {
                    $scope : $scope,
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

            // if ($scope.grnData.grnTables[rowId].batchDtls.length == 0) {
            $scope.loadgrnBatchDtls();
            // }

            if ($scope.grnData.grnTables[rowId].batchDtls[0].batchItemId == '' || $scope.grnData.grnTables[rowId].batchDtls[0].batchItemId == null) {
                $scope.grnData.grnTables[rowId].batchDtls[0].batchItemId = $scope.grnData.grnTables[rowId].dtlItemId;
                $scope.grnData.grnTables[rowId].batchDtls[0].batchItemName = $scope.grnData.grnTables[rowId].dtlItemCode + " - " + $scope.grnData.grnTables[rowId].dtlItemName;
            }
            if ($scope.grnData.grnTables[rowId].batchDtls[0].expiryDate == '' || $scope.grnData.grnTables[rowId].batchDtls[0].expiryDate == null) {
                $scope.grnData.grnTables[rowId].batchDtls[0].expiryDate = $scope.calculateExpDate(currentDate);
            }

            if ($scope.grnData.grnTables[rowId].dtlItemId != '' && $scope.grnData.grnTables[rowId].dtlItemId != undefined) {
                $http.get('app/grn/getItemAttributes?itemId=' + $scope.grnData.grnTables[rowId].dtlItemId).success(function(result) {
                    $scope.itemBatch = result.itemAttributes.itemBatch
                    $scope.itemExpDate = result.itemAttributes.itemExpDate
                    $scope.itemManufacture = result.itemAttributes.itemManufacture
                    $scope.itemMrp = result.itemAttributes.itemMrp
                })
            }
            $scope.batchListItem = $scope.grnData.grnTables[rowId].batchDtls;

            angular.forEach($scope.batchListItem, function(value, index) {

                $scope.batchListItem[index] = value;
                if (!isNaN(parseFloat(value.mrp))) {
                    $scope.batchListItem[index].mrp = parseFloat(value.mrp).toFixed(2);
                }

            });

        }

        $scope.callDialogConsignmentBatch = function($scope, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, rowId) {
            ngDialog.open({
                scope : $scope,
                template : 'views/finance/inventory/ggrn/ggrnConsignmentViewBatch',
                controller : $controller('poPopupConsignmentViewCtrl', {
                    $scope : $scope,
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

            if ($scope.grnData.grnTables[rowId].dtlItemId != '' && $scope.grnData.grnTables[rowId].dtlItemId != undefined) {
                $http.get('app/grn/getItemAttributes?itemId=' + $scope.grnData.grnTables[rowId].dtlItemId).success(function(result) {
                    $scope.itemBatch = result.itemAttributes.itemBatch
                    $scope.itemExpDate = result.itemAttributes.itemExpDate
                    $scope.itemManufacture = result.itemAttributes.itemManufacture
                    $scope.itemMrp = result.itemAttributes.itemMrp
                })
            }

            $scope.batchListItem = $scope.grnData.grnTables[rowId].batchDtls;

            angular.forEach($scope.batchListItem, function(value, index) {
                $scope.batchListItem[index] = value;
                if (!isNaN(parseFloat(value.mrp))) {
                    $scope.batchListItem[index].mrp = parseFloat(value.mrp).toFixed(2);
                }

            });

        }

        // NG DIALOG FOR Quality Check Details
        $scope.getQCInfo = function(rowData) {
            $scope.callQCDialog($scope, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, rowData);
        };

        $scope.callQCDialog = function($scope, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, rowData) {
            ngDialog.open({
                scope : $scope,
                template : 'views/finance/inventory/ggrn/ggrnviewproductQC',
                controller : $controller('poPopupCtrl', {
                    $scope : $scope,
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
            $scope.grnQCData = rowData;

        }

        $scope.ngcancel = function() {
            ngDialog.close();
        }

        $scope.checkItemAll = function(value) {
            if (value) {
                $scope.chkAll = true;
            } else {
                $scope.chkAll = false;
            }

            angular.forEach($scope.batchListItem, function(row) {
                row.select = $scope.chkAll;
            });
        }

        $scope.saveBtchDtls = function(dtl) {
            var isValidDate = true;
            var isValidBatch = true;
            var todayDate = currentDate;
            todayDate = todayDate.split("/");
            todayDate = new Date(todayDate[2], todayDate[1] - 1, todayDate[0]);
            angular.forEach($scope.batchListItem, function(value, index) {
                if (value.expiryDate != undefined && value.expiryDate != null && value.expiryDate != '') {
                    var expDate = value.expiryDate;
                    expDate = expDate.split("/");
                    expDate = new Date(expDate[2], expDate[1] - 1, expDate[0]);
                    if (expDate < todayDate) {
                        isValidDate = false;
                    }
                }
                if ($scope.itemBatch) {
                    if (value.lotNo == undefined || value.lotNo == null || value.lotNo == '') {
                        isValidBatch = false;
                    }
                }

            });
            if (isValidDate && isValidBatch) {
                $scope.ngcancel();
            } else {
                if (isValidDate == false) {
                    logger.logError("Expiry Date is less than the current date");
                }
                if (isValidBatch == false) {
                    logger.logError("Please Enter Batch Number");
                }

            }
        }

        $scope.validateQty = function(tables) {
            var flag = true, msg = '';
            angular.forEach(tables, function(row, index) {
                var batchQty = 0;
                if ($scope.grnData.poType != "Consignment Po") {
                    if (row.batchDtls.length == 0) {
                        msg = "Please Add Batch Details For Item - " + row.dtlItemName;
                        flag = false;
                    } else {
                        angular.forEach(row.batchDtls, function(subrow, subindex) {
                            if (subrow.batchQty == 0 || subrow.batchQty == '') {
                                msg = "Please Add Batch Details For Item - " + row.dtlItemName;
                                flag = false;
                            }
                            if (!isNaN(parseInt(subrow.batchQty))) {
                                batchQty = parseInt(batchQty) + parseInt(subrow.batchQty);
                            }
                        });

                        if (batchQty != row.dtlQty) {
                            msg = "Batch Qty should match with Receiving Qty For Item - " + row.dtlItemName;
                            flag = false;
                        }
                    }
                    if (row.pendingQty < row.dtlQty) {
                        msg = "Receiving Qty should not Exceed Pending Qty For Item - " + row.dtlItemName;
                        flag = false;
                    }

                }
                if (row.dtlItemCode == '' || row.dtlItemName == '') {
                    msg = "Please Select Items From Purchase Order Details";
                    flag = false;
                }

            });
            if (!flag) {
                logger.logError(msg);
            }

            return flag;
        }

        $scope.onSubmit = function(grnData) {

            $scope.grnData.deliveryMthd = 2;
            if ($scope.grnData.companyId != "") {
                if ($scope.grnData.vendorId != "") {
                    if ($scope.grnData.locId != "") {
                        if ($scope.grnData.dstLocId != "") {
                            if ($scope.grnData.poId != "") {
                                if ($scope.grnData.deliveryMthd != "") {
                                    if ($scope.grnData.transMode != "") {
                                        if ($scope.qc) {
                                            if ($scope.grnData.qcLocationId != "") {
                                                if ($scope.validateQty($scope.grnData.grnTables)) {
//                                                    if ($scope.grnData.locId != $scope.grnData.dstLocId)
                                                        $scope.save();
//                                                    else
//                                                        logger.logError("Source and Destination Locations Should be Different");
                                                }
                                            } else
                                                logger.logError("Please Select QC Location");
                                        } else {
                                            // if
                                            // ($scope.validateQty($scope.grnData.grnTables))
                                            // {
//                                            if ($scope.grnData.locId != $scope.grnData.dstLocId)
                                                $scope.save();
//                                            else
//                                                logger.logError("Source and Destination Locations Should be Different");
                                            // }
                                        }
                                    } else
                                        logger.logError("Please Select Transport Mode");
                                } else
                                    logger.logError("Please Select Delivery Method");
                            } else
                                logger.logError("Please Select Purchase Order");
                        } else
                            logger.logError("Please Select Destination Location");
                    } else
                        logger.logError("Please Select Source Location");
                } else
                    logger.logError("Please Select Vendor");
            } else
                logger.logError("Please Select Hospital Name");
        };

        $scope.save = function() {
            var flag = false;
            if (!$scope.isEdit) {
                angular.forEach($scope.grnData.grnTables, function(value, index) {
                    var isNegative = Number.isInteger($scope.grnData.grnTables[index].dtlQty);
                    if ($scope.grnData.grnTables[index].dtlQty != 0 && $scope.grnData.grnTables[index].dtlQty > 0) {
                        var purchaseQty = parseInt(value.purReqQuantity);
                        var vendorQuantity = parseInt(value.vendorQuantity);
                        var vendorQuantity = parseInt(value.vendorQuantity);

                        if($scope.uomdifferFlag == false){
                            $scope.grnData.grnTables[index].convertedQtyNew =     $scope.grnData.grnTables[index].dtlQty;
                            $scope.grnData.grnTables[index].balanceConvertedQtyNew =  0;
                        }
                        var batAttrbutList = [];
                        var date = new Date();
                        var BatchDetails = [];
                        var batchDetails = {
                            batchItemId : value.dtlItemId,
                            batchItemName : value.dtlItemName,
                            batchQty : '',
                            expiryDate : '',
                            lotNo : '',
                            manufactureDef : '',
                            mrp : '',
                            originalConvertedQty : ''
                        }
                        // var currentYear = d.getFullYear();
                        // batchDetails.push(value.dtlItemId)
                        // batchDetails.push(value.dtlItemName)
                        // batchDetails.push(date)
                        // batchDetails.push(lotNo)
                        // batchDetails.push(manufactureDef)
                        // batchDetails.push(mrp)
                        // batchDetails.push(originalConvertedQty)
                        BatchDetails.push(batchDetails);
                        // value.batchDtls = BatchDetails;
                        $scope.grnData.grnTables[index].batchDtls = BatchDetails;
                        // value.batchDtls =
                        angular.forEach(value.batchDtls, function(value1, index1) {
                            var obj = {
                                itemId : '',
                                batchNo : '',
                                batchQty : '',
                                manufacturer : '',
                                mrpPrice : '',
                                expiryDate : '',
                                originalConvertedQty : '',
                                costcenter:''
                                    
                            }
                            var convertedQty = (parseInt(purchaseQty) / vendorQuantity);
                            value1.originalConvertedQty = value1.batchQty * convertedQty;
                            obj.batchNo = value1.lotNo;
                            obj.batchQty = value1.originalConvertedQty;
                            obj.manufacturer = value1.manufactureDef;
                            obj.mrpPrice = value1.mrp;
                            obj.itemId = value1.batchItemId
                            if ($scope.itemExpDate == true) {
                                obj.expiryDate = value1.expiryDate;
                            } else {
                                if ($scope.itemExpDate == false) {
                                    obj.expiryDate = "";
                                }

                            }
                            obj.originalConvertedQty = value1.originalConvertedQty;
                            batAttrbutList.push(obj);
                        });

                        value.attributeBeans = batAttrbutList;
                    } else {
                        flag = true;
                        ++index;
                        logger.logError("Receiving Qty should be greater then 0 in Row" + " " + index);

                    }
                });
                //if (!flag) {
                    if (!flag) {

                    $http.post('app/grn/saveGRN', $scope.grnData).success(function(result) {
                        if (result == false) {
                            logger.logError("GRN Not Saved... ");
                        } else {
                            
                             $location.path("/hospital/inventory/ggrn/list");
                            logger.logSuccess("GRN added successfully");
                            if ($scope.grnData.grnTables[0].autoIssue == 'Y') {
                                $scope.MaterialIssue($scope.grnData);
                            } else {
                                // alert("Cant do Auto Issue")
                                $state.go("app.finance.inventory.ggrn.list");
                            }
                        }
                    }).error(function(data) {
                    });
                }
            }
        };

        // Material Issue Save

        $scope.MaterialIssue = function(grnData) {

            $scope.grnData = grnData;

            $scope.StockTransfor.companyId = $scope.grnData.companyId;
            $scope.StockTransfor.deliveryMet = 66;

            $scope.StockTransfor.transportType = $scope.grnData.transMode;
            $scope.StockTransfor.stockId = "";
            $scope.StockTransfor.sourceLocName = $scope.grnData.locId;

            $scope.StockTransfor.sourceLoc = $scope.grnData.locId;

            $scope.StockTransfor.destLoc = $scope.grnData.dstLocId;
            $scope.StockTransfor.destLocName = $scope.grnData.dstLocId;
            $scope.StockTransfor.serviceName = "";
            $scope.StockTransfor.personName = "";
            $scope.StockTransfor.requisition = $scope.grnData.poRequisitionId;
            $scope.StockTransforrowCollection = {

                attributeBeans : [],
                batchDetails : [],
                batchNoExist : false,
                disable : false,
                itemCode : '',
                itemName : '',
                originalQty : '',
                prquantity : '',
                quantity : '',
                reqDetailId : '',
                uom : ''
            }
            angular.forEach($scope.grnData.grnTables, function(value, index) {

                var purchaseQty = parseInt(value.purReqQuantity);
                var vendorQuantity = parseInt(value.vendorQuantity);
                var vendorQuantity = parseInt(value.vendorQuantity);
                var batAttrbutList = [];
                angular.forEach(value.batchDtls, function(value1, index1) {
                    var obj = {
                        itemId : '',
                        batchNo : '',
                        batchQty : '',
                        manufacturer : '',
                        mrpPrice : '',
                        expiryDate : '',
                    }
                    var convertedQty = (parseInt(purchaseQty) / vendorQuantity);
                    value1.originalConvertedQty = value1.batchQty * convertedQty;
                    obj.batchNo = value1.lotNo;
                    obj.batchQty = value1.originalConvertedQty;
                    obj.manufacturer = value1.manufactureDef;
                    obj.mrpPrice = value1.mrp;
                    obj.itemId = value1.batchItemId
                    if ($scope.itemExpDate == true) {
                        obj.expiryDate = value1.expiryDate;
                    } else {
                        if ($scope.itemExpDate == false) {
                            obj.expiryDate = "";
                        }

                    }
                    // obj.originalConvertedQty = value1.originalConvertedQty;
                    $scope.StockTransforrowCollection.batchDetails.push(obj);
                    // batAttrbutList.push(obj);
                });
                // value.attributeBeans = batAttrbutList;
                $scope.StockTransforrowCollection.attributeBeans = batAttrbutList;

                $scope.StockTransforrowCollection.batchNoExist = $scope.grnData.grnTables[index].batchNoExist;
                // $scope.StockTransforrowCollection.disable =
                // $scope.grnData.grnTables[index].batchNoExist;
                $scope.StockTransforrowCollection.itemCode = $scope.grnData.grnTables[index].dtlItemId.toString();
                $scope.StockTransforrowCollection.itemName = $scope.grnData.grnTables[index].dtlItemName;
                $scope.StockTransforrowCollection.originalQty = $scope.grnData.grnTables[index].vendorQuantity;
                $scope.StockTransforrowCollection.prquantity = $scope.grnData.grnTables[index].purReqQuantity;
                $scope.StockTransforrowCollection.quantity = $scope.grnData.grnTables[index].dtlQty;
                $scope.StockTransforrowCollection.reqDetailId = $scope.grnData.grnTables[index].reqDetailId;
                $scope.StockTransforrowCollection.uom = $scope.grnData.grnTables[index].dtlUom.toString();
            });

            $scope.StockTransfor.rowCollection.push($scope.StockTransforrowCollection);
            debugger;

            $scope.StockTransfer = {

                date : '',
                stockId : ''
            };

            $scope.date = '';

            var today = new Date();
            var dd = today.getDate();
            var mm = today.getMonth() + 1; // January is 0!
            var yyyy = today.getFullYear();
            $scope.resetValue = false;
            $scope.resetValueNew = false;
            if (dd < 10) {
                dd = '0' + dd;
            }
            if (mm < 10) {
                mm = '0' + mm;
            }

            var today = dd + '/' + mm + '/' + yyyy;
            $scope.date = today;

            $scope.StockTransfor.date = $scope.date;

            // $scope.StockTransfor.requisition =
            // $rootScope.purchaseRequisitionId;

            $scope.dropdownvalue = function() {

                $http.get("hospital/inventory/stocktransfer/getDropdownData").success(function(response) {
                    if (response.success == true) {

                        // $scope.RequisitionList =
                        // response.oStockTransferBean[1];
                        // $scope.Transportation =
                        // response.oStockTransferBean[3];
                        $scope.StockTransfor.stockId = response.oStockTransferBean[4];
                        $scope.saveMaterialIssue($scope.StockTransfor);
                    }
                }).error(function(result) {
                    logger.logError("Error Please Try Again");
                });

            }
            $scope.dropdownvalue();

        }
        var issueStatus = "";
        var requisitionId = "";
        $scope.saveMaterialIssue = function(StockTransfor) {
            var isQuantity = true;
            var batchValid = true;
            // if (new
            // validationService().checkFormValidity($scope.ondutyrequestForm))
            // {
            // if($scope.validateQty()){
            if ($scope.StockTransfor.rowCollection.length >= 1) {
                angular.forEach($scope.StockTransfor.rowCollection, function(value, key) {
                    var originalqty = value.originalQty;
                    var enteredqty = value.quantity;
                    if (enteredqty < originalqty) {
                        requisitionId = parseInt($scope.StockTransfor.requisition);
                        issueStatus = 213;
                    }
                    if (enteredqty == originalqty) {
                        requisitionId = parseInt($scope.StockTransfor.requisition);
                        issueStatus = 214;
                    }

                    if (value.quantity > 0) {
                    } else {
                        isQuantity = false;
                    }
                    /*
                     * if (value.batchNoExist == true) { if
                     * (value.batchDetails.length == 0) { batchValid = false } }
                     */
                    var batAttrbutList = [];
                    angular.forEach(value.batchDetails, function(batchValue, batchKey) {
                        var obj = {
                            itemId : '',
                            batchNo : '',
                            batchQty : '',
                            manufacturer : '',
                            mrpPrice : '',
                            expiryDate : ''
                        }
                        obj.batchNo = batchValue.lotNo;
                        obj.batchQty = batchValue.batchQty;
                        obj.manufacturer = batchValue.manufactureDef;
                        obj.mrpPrice = batchValue.mrpPrice;
                        obj.itemId = batchValue.dtlItemId;
                        if ($scope.itemExpDate == true) {
                            obj.expiryDate = batchValue.expiryDate;
                        } else {
                            if ($scope.itemExpDate == false) {
                                obj.expiryDate = "";
                            }

                        }
                        obj.originalConvertedQty = batchValue.transferQty;
                        if (batchValue.transferQty > 0) {
                            batAttrbutList.push(obj);
                        }

                    });

                    value.attributeBeans = batAttrbutList;
                });
                if (isQuantity == true) {

                    if (batchValid == true) {
                        $http.post("hospital/inventory/stocktransfer/save1", StockTransfor).success(function(response) {
                            if (response.success == true) {

                                if (issueStatus != "" & requisitionId != "") {
                                    $http.get("app/hospital/purchase/consignmentRequest/issueStatus?requisitionId=" + requisitionId + "&issueStatus=" + issueStatus).success(function(response) {
                                        // if (response.success == true) {
                                        // }
                                    });
                                }
                                logger.logSuccess("Data Saved Successfully");
                                $state.go('app.finance.inventory.stockmovement.list');
                            }
                        }).error(function(result) {
                            logger.logError("Error Please Try Again");
                        });
                    } else {
                        logger.logError("Please Add Atleast One Batch Details!");
                    }
                } else {
                    logger.logError("Quantity cannot be zero");
                }
            } else {
                logger.logError("Atleast one item should be present");
            }

            // }
            // } else {
            // toaster.pop('error', "Please fill the required fields",
            // logger.getErrorHtmlNew($scope.ondutyrequestForm.$validationSummary),
            // 555000, 'trustedHtml');
            // }

        }

        $scope.$watch('[grnData.locId,grnData.dstLocId]', function(newValue, oldValue) {

            if (newValue != "" && newValue != undefined) {

//                if ($scope.grnData.locId != '' && $scope.grnData.dstLocId != '') {
//                    if ($scope.grnData.locId === $scope.grnData.dstLocId) {
//                        logger.logError("Source and Destination Locations Should be Different");
//                    }
//                }
            }

        });

        var grnCode = $location.search().grnCode;
        if (grnCode == undefined || grnCode == null || grnCode == "") {
            $scope.isEdit = false;
        } else {
            $scope.isEdit = true;
            $scope.grnTablesList = [];
            var schList = [], schFnlList = [], schIndx = 0;
            $http.get('app/grn/getGrnEditData?grnCode=' + grnCode).success(function(data) {

                angular.forEach(data.editBeanData.grnTables, function(value, index) {

                    $scope.grnTablesList[index] = value;
                    $scope.grnTablesList[index].dtlPrice = parseFloat(value.dtlPrice).toFixed(2);
                    $scope.grnTablesList[index].mrp = parseFloat(value.mrp).toFixed(2);

                });

                data.editBeanData.grnTables = $scope.grnTablesList;
                $scope.grnData = data.editBeanData;
                $scope.loadVendorAddress();
                // $scope.getPODtlList(data.editBeanData.poId);
                // $scope.grnData.locId = '';
                if ($scope.grnData.qcLocationId > 0)
                    $scope.qc = true;

                if ($scope.grnData.poType == "Rate Contract") {
                    $scope.isRate = true;
                    angular.forEach(data.editBeanData.grnTables, function(rowData, index) {
                        angular.forEach(rowData.scheduleList, function(data, indexs) {
                            schList[indexs] = data;
                        });

                        angular.forEach(schList, function(data, indexs) {
                            schFnlList[schIndx] = data;
                            schIndx++;
                        });

                        $scope.batchListItem = rowData.batchDtls;
                    });

                }
                $scope.rowCollectionDeliveryItem = schFnlList;
                $scope.grnData.schDtlList = schFnlList;
            }).error(function(data) {
            });

        }

        $scope.onChangeDecimal = function(id, num) {

            num = num.replace(/[^0-9]/g, 0);
            var floatnum = parseFloat(Math.round(num * 100) / 100).toFixed(2);
            $('#' + id).val(floatnum);
            return floatnum;
        }

        $scope.onChangeNumber = function(id, num) {

            num = num.replace(/[^0-9]/g, '');
            $('#' + id).val(num);
            return num;
        }

        $scope.getOldBatchNumber = function(row) {
            $scope.isBatchMrp = false;
            $scope.isBatchExpired = false;
            row.mrp = '';
            row.expiryDate = $scope.calculateExpDate(currentDate);
            if (row.lotNo != undefined && row.lotNo != null && row.lotNo != '') {
                var resultbean = {
                    lotNo : row.lotNo,
                    batchItemId : row.batchItemId,
                    destinationId : $scope.grnData.locId
                }
                $http.post('app/grn/getPreviousBatch', resultbean).success(function(datas) {
                    if (datas.checkConsignmentBatch == false) {
                        if (datas.expiryDate != undefined && datas.expiryDate != null && datas.expiryDate != '') {
                            $scope.isBatchExpired = true;
                            row.expiryDate = datas.expiryDate

                        }
                        if (datas.mrp != undefined && datas.mrp != null && datas.mrp != '') {
                            $scope.isBatchMrp = true;
                            row.mrp = datas.mrp
                        }
                        var length = $scope.batchListItem.length;
                        for (var i = 0; i < length; i++) {
                            for (var j = 0; j < length; j++) {
                                if (i != j) {
                                    if ($scope.batchListItem[i].lotNo == $scope.batchListItem[j].lotNo) {
                                        row.expiryDate = $scope.calculateExpDate(currentDate);
                                        $scope.isBatchMrp = false;
                                        $scope.isBatchExpired = false;
                                        row.mrp = '';
                                        row.lotNo = '';
                                        logger.logError("Batch Number already added");
                                        return false;
                                    }
                                }
                            }
                        }
                    } else {
                        if (datas.checkConsignmentBatch == true) {
                            logger.logError("Batch Already Exists!");
                            row.lotNo = '';
                            row.expiryDate = '';
                            row.lotNo = '';
                        }
                    }

                }).error(function(datas) {
                });

            }

        }

        $scope.getScheduleQty = function(schCollections, isChange) {

            var item = schCollections.scheduleItemCode, qty = schCollections.scheduleItemQty;
            if (schCollections.select != undefined && schCollections.select != false) {
                angular.forEach($scope.grnData.grnTables, function(rowData, index) {

                    if (rowData.dtlItemCode == item) {
                        if (isChange == true) {
                            rowData.dtlQty = parseInt(rowData.dtlQty) - parseInt(curSchQty) + parseInt(qty);
                            var convertedQty = (parseInt(rowData.purReqQuantity) / rowData.vendorQuantity);
                            // rowData.convertedQty = rowData.dtlQty *
                            // convertedQty;
                            rowData.convertedQty = rowData.dtlQty;

                        } else {
                            rowData.dtlQty = parseInt(rowData.dtlQty) + parseInt(qty);
                            var convertedQty = (parseInt(rowData.purReqQuantity) / rowData.vendorQuantity);
                            // rowData.convertedQty = rowData.dtlQty *
                            // convertedQty;
                            rowData.convertedQty = rowData.dtlQty;

                        }
                    }
                });
            } else {
                angular.forEach($scope.grnData.grnTables, function(rowData, index) {
                    if (rowData.dtlItemCode == item) {
                        if (parseInt(rowData.dtlQty) > 0 && isChange == false) {
                            rowData.dtlQty = parseInt(rowData.dtlQty) - parseInt(qty);
                            var convertedQty = (parseInt(rowData.purReqQuantity) / rowData.vendorQuantity);
                            // rowData.convertedQty = rowData.dtlQty *
                            // convertedQty;
                            rowData.convertedQty = rowData.dtlQty;

                        }
                    }
                });
            }

            if (schCollections.scheduleItemQty > schCollections.schedulePendingQty) {
                logger.logError("Receiving Qty should not Exceed Pending Qty...");
            }

        }

        var curSchQty = 0;
        $scope.getCurrentQty = function(schCollections) {
            curSchQty = schCollections.scheduleItemQty;
        }

        /*
         * $scope.printGRN = function(grnData) { var url =
         * 'app/grn/printGRN?grnCode=' + $scope.grnData.grnCode; var wnd =
         * window.open(url, 'Title',
         * 'width=500,height=700,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
         * wnd.print(); }
         */

        // print
  /*      $scope.GRNprint = function(grnCode) {
            var url = 'app/grn/grnPrint?grnId=' + grnCode;
            var wnd = $window.open(url, 'Omega', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
            // wnd.print();
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

        }*/

        $scope.removeItemRow = function() {
            $scope.detail = [];
            console.log("Row collection ITem in delete");
            // $scope.purchaseQuotation.quotationDetailList = [];
            $scope.copytablerow = [];
            var isSelectItem = false;
            angular.forEach($scope.grnData.grnTables, function(value, index) {
                if (value.selectCheckBox == true) {
                    isSelectItem = true;
                } else {
                    $scope.detail.push(value);
                }
            });
            if (isSelectItem == false) {
                logger.logError("Please select atleast one item to delete");
            }
            $scope.grnData.grnTables = $scope.detail;
        };

        // PRINT

        $scope.GRNprint = function(grnCode) {
            var url = 'app/grn/grnPrint?grnId=' + grnCode;
            var wnd = $window.open(url, 'Omega', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
            if (wnd.print()) {
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

        // ITEM DETAIL VIEW AND TAX CALCULATIONS

        $scope.purchaseOrder = {
            vendorId : '',
            locationId : '',
            purchaseFor : '',
            companyId : '',
            costcenter : '',
            purchaseOrderDate : '',
            purchaseType : 43,
            statusId : '',
            termsCondition : '',
            remarks : '',
            remarksforother : '',
            advanceamt : '',
            currency : '',
            budgetType : '',
            purchaseOrderNum : '',

        };

        $scope.calculateTotal = function() {
            var subTotal = 0;
            var totalDiscount = 0;
            var totalTax = 0;

            var totalTaxCGST = 0;
            var totalTaxSGST = 0;
            var totalTaxIGST = 0;
            for (var i = 0; i < $scope.grnData.grnTables.length; i++) {
                if ($scope.grnData.grnTables[i].edit != 2) {
                    var rowObj = $scope.grnData.grnTables[i];
                    // alert("price"+rowObj.price);
                    // rowObj.price = rowObj.price ? rowObj.price : 0;
                    rowObj.price = rowObj.price ? rowObj.price : 0;
                    rowObj.discount = rowObj.discount ? rowObj.discount : 0;
                    // rowObj.tax = rowObj.tax ? rowObj.tax : 0;

                    // subTotal += Number(rowObj.price);
                    subTotal += Number(rowObj.price);

                    totalDiscount += Number(rowObj.discount);
                    totalTax += Number(rowObj.tax);
                    // totalAmount += Number(rowObj.finalTotal);
                    totalTaxCGST += Number(rowObj.taxCGST);
                    totalTaxSGST += Number(rowObj.taxSGST);
                    totalTaxIGST += Number(rowObj.taxIGST);

                }
            }

            $scope.purchaseOrder.subTotal = Number(subTotal).toFixed(2);
            // subTotal1 = Number(subTotal).toFixed(2);
            $scope.purchaseOrder.totalTaxCGST = Number(totalTaxCGST).toFixed(2);
            $scope.purchaseOrder.totalTaxSGST = Number(totalTaxSGST).toFixed(2);
            $scope.purchaseOrder.totalTaxIGST = Number(totalTaxIGST).toFixed(2);

            totalDiscount = totalDiscount ? totalDiscount : 0;
            $scope.purchaseOrder.totalDiscount = Number(totalDiscount).toFixed(2);
            totalTax = totalTax ? totalTax : 0;
            // $scope.purchaseOrder.totalTax = Number(totalTax).toFixed(2);
            // $scope.purchaseOrder.otherCharges = 0;

            var freight = angular.copy($scope.purchaseOrder.freight);
            var othercharges = angular.copy($scope.purchaseOrder.otherCharges);
            // var cal = freight+othercharges;
            // cal = (Number(totalTaxCGST) + Number(totalTaxSGST) +
            // Number(totalTaxIGST))- ;

            // $scope.purchaseOrder.totalAmount = Number(Number(subTotal) +
            // Number(cal)).toFixed(2);
            // totalAmt = $scope.purchaseOrder.totalAmount ;
            var cal = Number($scope.grnData.freight) + Number($scope.grnData.otherCharges) + Number($scope.purchaseOrder.totalTaxCGST) + Number($scope.purchaseOrder.totalTaxSGST) + Number($scope.purchaseOrder.totalTaxIGST);
            var totalDiscount = Number($scope.purchaseOrder.totalDiscount);
            var tAmount = (Number($scope.purchaseOrder.subTotal) + cal) - totalDiscount.toFixed(2);

            //$scope.grnData.totalAmount = Number(tAmount).toFixed(2);
            $scope.grnData.totalAmount =  parseFloat(Math.round(Number(tAmount) * 100) / 100);
           
        };

        $scope.calculationTaxDetails = function(value) {
            var discount = 0;
            $scope.itemdetailsList = value;
           
            angular.forEach($scope.itemdetailsList, function(key, index) {

                $scope.purchaseQuotation.taxCGSTinPercent = $scope.itemdetailsList[index].taxCGST;
                $scope.purchaseQuotation.taxSGSTinPercent = $scope.itemdetailsList[index].taxSGST;
                $scope.purchaseQuotation.taxIGSTinPercent = $scope.itemdetailsList[index].taxIGST;

                var totalamount = ($scope.itemdetailsList[index].vendorQuantity) * ($scope.itemdetailsList[index].unitPrice);

                if ($scope.itemdetailsList[index].discountType == 59) {
                    // $scope.itemdetailsList[index].discountType = "Amount";
                    discount = $scope.itemdetailsList[index].discount;

                } else if ($scope.itemdetailsList[index].discountType == 58) {
                    // $scope.itemdetailsList[index].discountType =
                    // "Percentage";
                    discount = (Number(totalamount) * Number(($scope.itemdetailsList[index].discount) / 100));
                    $scope.purchaseQuotation.discountPercent = $scope.itemdetailsList[index].discount;

                } else {
                    $scope.itemdetailsList[index].discountType = 14;
                    discount = 0;
                }
                totalamount = totalamount - discount;
                var taxAmtCGST = (totalamount * (($scope.itemdetailsList[index].taxCGST) / 100));
                var taxAmtSGST = (totalamount * (($scope.itemdetailsList[index].taxSGST) / 100));
                var taxAmtIGST = (totalamount * (($scope.itemdetailsList[index].taxIGST) / 100));

                $scope.purchaseQuotation.taxCGST = taxAmtCGST;
                $scope.purchaseQuotation.taxSGST = taxAmtSGST;
                $scope.purchaseQuotation.taxIGST = taxAmtIGST;
                $scope.purchaseQuotation.discount = discount;
 

            });

        }
        var txCGST = "";
        var txSGST = "";
        var txIGST = "";

        $scope.calculateTaxDiscountEdit = function(rowCollection, index) {
          
            rowCollection['finalTotal'] = 0;
            rowCollection['total'] = 0;
      

            // price

            rowCollection.price = Number(Number(rowCollection.dtlQty) * Number(rowCollection.dtlPrice)).toFixed(2);

            // DISCOUNT
            if (rowCollection.discountType == 59) {

                    var unitDiscount = rowCollection.discountAmount / rowCollection.originalConvertedQty;
                    rowCollection.discount = Number(Number(rowCollection.dtlQty) * Number(unitDiscount)).toFixed(2);
               

            } else if (rowCollection.discountType == 58) {

                 rowCollection.discount = Number(Number(rowCollection.price)*(rowCollection.discountPercentage/100)).toFixed(2);
            } else {

                rowCollection.discount = Number(rowCollection.discountAmount).toFixed(2);

            }

            // NET PRICE
            rowCollection.netPrice = rowCollection.price - rowCollection.discount;
            var totalamount = rowCollection.netPrice;
            // TAX CALCULATION

            var discountTaxDetail = rowCollection;

            var taxAmtCGST = (totalamount * ((rowCollection.taxCGSTinPercent) / 100));
            var taxAmtSGST = (totalamount * ((rowCollection.taxSGSTinPercent) / 100));
            var taxAmtIGST = (totalamount * ((rowCollection.taxIGSTinPercent) / 100));

            rowCollection.taxCGST = taxAmtCGST.toFixed(2);
            rowCollection.taxSGST = taxAmtSGST.toFixed(2);
            rowCollection.taxIGST = taxAmtIGST.toFixed(2);
      
            rowCollection.finalTotal = (Number(rowCollection.netPrice) + Number(rowCollection.taxCGST) + Number(rowCollection.taxSGST) + Number(rowCollection.taxIGST)).toFixed(2);

  
            $scope.calculateTotal();

        };

        // Total cal wherther othercharges and freight change

        $scope.CalculateTotalAmount = function() {
            var subTotal = 0;
            var totalDiscount = 0;
            var totalTax = 0;

            var totalTaxCGST = 0;
            var totalTaxSGST = 0;
            var totalTaxIGST = 0;
            if (freightCheck >= $scope.grnData.freight) {
                if(otherChargesCheck >= $scope.grnData.otherCharges){

                for (var i = 0; i < $scope.grnData.grnTables.length; i++) {
                    if ($scope.grnData.grnTables[i].edit != 2) {
                        var rowObj = $scope.grnData.grnTables[i];
                        rowObj.price = rowObj.price ? rowObj.price : 0;
                        rowObj.discount = rowObj.discount ? rowObj.discount : 0;
                        subTotal += Number(rowObj.price);

                        totalDiscount += Number(rowObj.discount);
                        totalTax += Number(rowObj.tax);
                        totalTaxCGST += Number(rowObj.taxCGST);
                        totalTaxSGST += Number(rowObj.taxSGST);
                        totalTaxIGST += Number(rowObj.taxIGST);

                    }
                }

                $scope.purchaseOrder.subTotal = Number(subTotal).toFixed(2);
                $scope.purchaseOrder.totalTaxCGST = Number(totalTaxCGST).toFixed(2);
                $scope.purchaseOrder.totalTaxSGST = Number(totalTaxSGST).toFixed(2);
                $scope.purchaseOrder.totalTaxIGST = Number(totalTaxIGST).toFixed(2);

                totalDiscount = totalDiscount ? totalDiscount : 0;
                $scope.purchaseOrder.totalDiscount = Number(totalDiscount).toFixed(2);
                totalTax = totalTax ? totalTax : 0;

                var freight = angular.copy($scope.purchaseOrder.freight);
                var othercharges = angular.copy($scope.purchaseOrder.otherCharges);
                var cal = Number($scope.grnData.freight) + Number($scope.grnData.otherCharges) + Number($scope.purchaseOrder.totalTaxCGST) + Number($scope.purchaseOrder.totalTaxSGST) + Number($scope.purchaseOrder.totalTaxIGST);
                var totalDiscount = Number($scope.purchaseOrder.totalDiscount);
                var tAmount = (Number($scope.purchaseOrder.subTotal) + cal) - totalDiscount.toFixed(2);

               // $scope.grnData.totalAmount = Number(tAmount).toFixed(2);
                $scope.grnData.totalAmount = parseFloat(Math.round(Number(tAmount) * 100) / 100);
                }else{
                    logger.logError("Other Charges under " + otherChargesCheck );
                    $scope.grnData.otherCharges = otherChargesCheck;
                }
            } else {
                logger.logError("Freight Charges under " + freightCheck );
                $scope.grnData.freight = freightCheck;
            }
        }
        $scope.addDtlRowValues = function(row,index) {
            $scope.finalList = [];
            $scope.grndetailtable = $scope.grnData.grnTables;
//            angular.forEach($scope.rowdetailList, function(row, index) {

                if (row.receivingQtypop != undefined && row.receivingQtypop != ""
                    && row.receivingQtypop != "0"
                    && row.receivingQtypop != null) {
                    if( row.convertedQtypop != undefined && row.convertedQtypop != ""
                        && row.convertedQtypop != "0"
                        && row.convertedQtypop != null){
                    $scope.finalList.push(row);
                    }else{
                        logger.logError("Please Enter Receving Qty!");

                    }
                }else{
                    logger.logError("Please Enter Converted Qty!"  );

                }
                
//            });
            $rootScope.dtlList = $scope.finalList;
            if( $scope.finalList.length>0){
                $scope.grnData.grnTables[index].dtlQty = row.receivingQtypop;
                $scope.grnData.grnTables[index].convertedQtyNew = row.convertedQtypop;
                $scope.grnData.grnTables[index].convertedQtyFlag = true;
                $scope.grnData.grnTables[index].balanceConvertedQtyNew = row.purchaseQty - row.convertedQtypop;
              ngDialog.close();
              $scope.uomdifferFlag = true;
              $scope.calculateConvertedQuantityUOM(row.receivingQtypop,  $scope.grnData.grnTables[index].convQty, 
                      index,  $scope.grnData.grnTables[index].originalConvertedQty, 
                      $scope.grnData.grnTables[index].purReqQuantity, 
                      $scope.grnData.grnTables[index].vendorQuantity, 
                      $scope.grnData.grnTables[index].pendingQty,
                      null, 
                     null, 
                      $scope.grnData.grnTables[index].purchaseQty, 
                      $scope.grnData.grnTables[index].vendorQty);
              
              
              $scope.calculateTaxDiscountEdit($scope.grnData.grnTables[index]);
            }
        }
    });

    app.controller('poPopupCtrl', function($scope, $state, $http, $location, sharedProperties, toaster, $injector, logger, ngDialog, $rootScope, $controller) {

        $scope.addDtlRowValues = function(poCollection) {
            $scope.finalList = [];

            angular.forEach(poCollection, function(row, index) {

                if (row.select != undefined && row.select != false) {
                    $scope.finalList.push(row);
                }
            });
            $rootScope.dtlList = $scope.finalList;
            ngDialog.close();
        }

    });


    app.controller('convertedQtyViewCtrl', function($scope, $state, $http, $location, sharedProperties, toaster, $injector, logger, ngDialog, $rootScope, $controller,rowdetailList,rowId) {

        $scope.rowdetailList = [];
        var balanceConvertedQtyNew = 0;
            if( rowdetailList.conqty >0){
                balanceConvertedQtyNew = rowdetailList.purchaseQty - rowdetailList.conqty;

            }else{
                balanceConvertedQtyNew = rowdetailList.purchaseQty;
            }
        $scope.rowdetailList = {
                dtlItemCode : rowdetailList.dtlItemCode,
                dtlItemName :  rowdetailList.dtlItemName,
                dtlItemDesc :  rowdetailList.dtlItemDesc,
                purchaseUOMName :  rowdetailList.purchaseUOMName,
                purchaseQty :  rowdetailList.purchaseQty,
                vendorUOMName :  rowdetailList.vendorUOMName,
                vendorUOM :  rowdetailList.vendorUOM,
                pendingQty :  rowdetailList.pendingQty,
                receivingQtypop : rowdetailList.pendingQty,
                convertedQtypop :  balanceConvertedQtyNew,
                rowId:rowId
        };
        
        $scope.tabledetailList = $scope.grnData.grnTables;
        
     

    });
    app.controller('poPopupConsignmentViewCtrl', function($scope, $state, $http, $location, sharedProperties, toaster, $injector, logger, ngDialog, $rootScope, $controller) {

        $scope.addDtlRowValues = function(poCollection) {
            $scope.finalList = [];

            angular.forEach(poCollection, function(row, index) {

                if (row.select != undefined && row.select != false) {
                    $scope.finalList.push(row);
                }
            });
            $rootScope.dtlList = $scope.finalList;
            ngDialog.close();
        }

    });

//});
