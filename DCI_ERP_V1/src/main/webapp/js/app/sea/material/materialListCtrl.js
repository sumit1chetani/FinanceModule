//define([ 'hospital/purchase/purchase' ], function(module) {

    'use strict';

    app.controller('materialListCtrl', function($scope, $state,$stateParams, $http, $controller, logger, ngDialog, $location, $injector, sharedProperties, toaster, $rootScope, $window) {

        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages = 0
        $scope.isDisplay = false;
        $scope.isUpload = true;
        $scope.isDelete = true;

        $scope.consignmentRequestData = {
            purchaseRequisitionId : '',
            requisitionNumber : '',
            requisitionDate : '',
            employeeId : '',
            employeeName : '',
            requisitionType : '',
            designationName : '',
            sourceLocation : '',
            locationName : '',
            destinationLocation : '',
            designationId : '',
            prReqNo : '',
            requestTypeName : '',
            tables : []
        };
        
//        for direct issue
        
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
                sourceLoc:'',
                destLoc:''
            };
        
        
        $scope.getList = function() {

            $http.get("app/hospital/purchase/consignmentRequest/list").success(function(response) {
                $scope.rowCollection = response.employeeList;
            });
        };
        $scope.getList();

        $scope.editRow = function(purchaseRequisitionId,stat) {
            if(stat == 'Pending')
                $location.url($stateParams.tenantid + '/hospital/purchase/consignmentRequest/edit1?purchaseRequisitionId=' + purchaseRequisitionId);
            else
            $location.url($stateParams.tenantid + '/hospital/purchase/consignmentRequest/edit?purchaseRequisitionId=' + purchaseRequisitionId);
        };

        $scope.approve = function(purchaseRequisitionList, issue) {
            
            var purchaseRequisitionId = purchaseRequisitionList.purchaseRequisitionId;
            if (purchaseRequisitionList.requestTypeflag == 't') {
                if (issue == "Pending") {
                    $http.post('app/hospital/purchase/storeApproval/approve', purchaseRequisitionId).success(function(response) {
                        if (response) {
                            logger.logSuccess("Material Approved Successfully");
                            $scope.getList();
                        }

                    });
                } else {
                    logger.logError("Pending Request Only will Approve!");
                }
            }else  if (purchaseRequisitionList.requestTypeflag == 'f') {
                if (issue == "Pending") {
                $http.post('app/hospital/purchase/consignmentRequest/edit', purchaseRequisitionId).success(function(result) {
                    
                    $scope.MaterialIssue(result);
                });
                }else {
                    logger.logError("Meterial Already Issued!");                }
            }
        };

        $scope.issue = function(purchaseRequisitionId, issue) {
            if (issue == "Approved") {
                $rootScope.purchaseRequisitionId = purchaseRequisitionId;
                $location.url(  $stateParams.tenantid +'/hospital/inventory/stockMovement/add');
            } else if (issue == "Issued") {
                logger.logError("Meterial Already Issued!");
            } else if (issue == "Partially Issued") {
                $rootScope.purchaseRequisitionId = purchaseRequisitionId;
                $location.url($stateParams.tenantid +'/hospital/inventory/stockMovement/add');
            } else if (issue == "Pending") {
                logger.logError("Please Approve Your Request!");
            }
        };

        $scope.add = function() {
            $state.go("app.sea.material.add");
        };
        $scope.fileUpload = function() {
            ngDialog.close();
            ngDialog.open({
                template : 'fileModal',
                scope : $scope
            });
        };

        $rootScope.uploadFile = function(element) {

            console.log("excel file");
            $scope.excelfile = element.files[0];
            console.log($scope.excelfile);
        };

        $rootScope.closeFileDialog = function() {
            ngDialog.close();
        };

        $rootScope.uploadEmployee = function() {
            ngDialog.close();
            var excelfile = $scope.excelfile;
            var fileExtension = excelfile.name;
            var fName = [];
            fName = fileExtension.split(".");
            for (var i = 0; i < fName.length; i++) {
                if (fName[i] == "xls" || fName[i] == "xlsx") {
                    var frmData = new FormData();
                    frmData.append("file", excelfile);
                    $.ajax({
                        type : "POST",
                        url : "app/hospital/purchase/consignmentRequest/uploadExefile",
                        data : frmData,
                        contentType : false,
                        processData : false,
                        success : function(result) {
                            console.log("result");
                            console.log(result);
                            if (result.success) {
                                logger.logSuccess("File Uploaded Successfully");
                                $scope.getList();
                                $scope.getEmployeeList();
                            } else {
                                var value = result.message;
                                // document.getElementById("id").innerHTML =
                                // result.message;

                                // logger.logError("Fail to Upload\n" +
                                // result.message);
                                // alert("I will get back to you soon\nThanks
                                // and Regards\nSaurav Kumar");
                                // ngDialog.openConfirm({
                                //                                    
                                // template : 'modalDialogId6',
                                // className : 'ngdialog-theme-default'
                                // })

                                $scope.callDialog($scope, value, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope);
                                //                            
                            }

                        }

                    });
                }

            }
        };
        $scope.callDialog = function($scope, value, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope) {
            ngDialog.open({
                scope : $scope,
                template : 'modalDialogId6',
                controller : $controller('ConsErrorCtrl', {
                    $scope : $scope,
                    value : value,
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
        }
        $scope.deleteRow = function(purchaseRequisitionId, index) {
            ngDialog.openConfirm().then(function() {
                var myURL = 'app/hospital/purchase/consignmentRequest/delete';
                $http({
                    url : myURL,
                    data : purchaseRequisitionId,
                    method : 'post',
                    dataType : 'json',
                    headers : {
                        'Accept' : 'application/json',
                        'Content-Type' : 'application/json'
                    }
                }).success(function(data) {
                    if (data == true) {
                        $scope.displayedCollection.splice(index, 1);
                        logger.logSuccess("Material Request Record Deleted Successfully");
                    } else
                        logger.logError("You Can't Delete this record, Related Data Exist!");
                }).error(function(data) {
                });
            }, function(reason) {
                console.log('Modal promise rejected. Reason: ', reason);
            });

        };

        $scope.printRow = function(materialRequest) {
            var url = 'app/hospital/purchase/consignmentRequest/printMaterialRequestPDF?materialReqId=' + materialRequest.purchaseRequisitionId;
            var wnd = $window.open(url, 'Omega', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
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


        // Material Isuue Save

        $scope.MaterialIssue = function(data)
        {
              
//            $scope.grnData = grnData;
                
                    $scope.StockTransfor.companyId= data.headerData.companyId;
                    $scope.StockTransfor.deliveryMet= 66;
                
                 //check
                    $scope.StockTransfor.transportType= data.headerData.transMode;
                    
                    
                    
                    $scope.StockTransfor.stockId= "";
//                    $scope.StockTransfor.sourceLocName=data.headerData.locId;
                    
                    $scope.StockTransfor.sourceLoc= data.headerData.sourceLocation;
                    
                    $scope.StockTransfor.destLoc= data.headerData.destinationLocation;
//                    $scope.StockTransfor.destLocName= data.headerData.dstLocId;
                    $scope.StockTransfor.serviceName= "";
                    $scope.StockTransfor.personName= "";
                    $scope.StockTransfor.requisition=data.headerData.purchaseRequisitionId;
                    $scope.StockTransforrowCollection = {
                            
                            attributeBeans:[],
                            batchDetails:[],
                            batchNoExist:false,
                            disable:false,
                            itemCode:'',
                            itemName:'',
                            originalQty:'',
                            prquantity:'',
                            quantity:'',
                            reqDetailId:'',
                            uom:''
                    }
                    angular.forEach(data.subData, function(value, index) {
                        
                        $scope.StockTransforrowCollection = {
                                
                                attributeBeans:[],
                                batchDetails:[],
                                batchNoExist:false,
                                disable:false,
                                itemCode:'',
                                itemName:'',
                                originalQty:'',
                                prquantity:'',
                                quantity:'',
                                reqDetailId:'',
                                uom:''
                        }
                        var purchaseQty = parseInt(value.quantity);
                        var vendorQuantity = parseInt(value.vendorQuantity);
//                        var vendorQuantity = parseInt(value.vendorQuantity);
                        var batAttrbutList = [];
//                    angular.forEach(value.batchDtls, function(value1, index1) {
                        var obj = {
                            itemId :value.itemId ,
                            batchNo : '',
                            batchQty : '',
                            manufacturer : '',
                            mrpPrice : '',
                            expiryDate : '',
                        }
//                        var convertedQty = (parseInt(purchaseQty) / vendorQuantity);
//                        value1.originalConvertedQty = value1.batchQty * convertedQty;
//                        obj.batchNo = value1.lotNo;
//                        obj.batchQty = value1.originalConvertedQty;
//                        obj.manufacturer = value1.manufactureDef;
//                        obj.mrpPrice = value1.mrp;
//                        obj.itemId = value1.batchItemId;
//                        if ($scope.itemExpDate == true) {
//                            obj.expiryDate = value1.expiryDate;
//                        } else {
//                            if ($scope.itemExpDate == false) {
//                                obj.expiryDate = "";
//                            }
//
//                        }
//                        obj.originalConvertedQty = value1.originalConvertedQty;
                        $scope.StockTransforrowCollection.batchDetails.push(obj);
//                        batAttrbutList.push(obj);
//                    });
//                    value.attributeBeans = batAttrbutList;
                    $scope.StockTransforrowCollection.attributeBeans = batAttrbutList;

//                    $scope.StockTransforrowCollection.batchNoExist = $scope.grnData.grnTables[index].batchNoExist;
//                    $scope.StockTransforrowCollection.disable =  $scope.grnData.grnTables[index].batchNoExist;
                    $scope.StockTransforrowCollection.itemCode = value.itemId.toString();
                    $scope.StockTransforrowCollection.itemName =  value.dtlItemName;
                    $scope.StockTransforrowCollection.originalQty =  value.quantity;
                    $scope.StockTransforrowCollection.prquantity =  value.quantity;
                    $scope.StockTransforrowCollection.quantity =  value.quantity;
                    $scope.StockTransforrowCollection.reqDetailId = value.purchaseRequisitionSubId;
                    $scope.StockTransforrowCollection.uom =  value.uomId;
                    $scope.StockTransfor.rowCollection.push($scope.StockTransforrowCollection);

                    
                    });
                    
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

//                        $scope.StockTransfor.requisition = $rootScope.purchaseRequisitionId;
                        
                        $scope.dropdownvalue = function() {

                            $http.get("hospital/inventory/stocktransfer/getDropdownData").success(function(response) {
                                if (response.success == true) {

//                                    $scope.RequisitionList = response.oStockTransferBean[1];
//                                    $scope.Transportation = response.oStockTransferBean[3];
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
        var requisitionId = "" ;
                $scope.saveMaterialIssue = function(StockTransfor) {
                    var isQuantity = true;
                    var batchValid = true;
//                    if (new validationService().checkFormValidity($scope.ondutyrequestForm)) {
                        // if($scope.validateQty()){
                        if ($scope.StockTransfor.rowCollection.length >= 1) {
                            angular.forEach($scope.StockTransfor.rowCollection, function(value, key) {
                                var originalqty = value.originalQty;
                                var enteredqty = value.quantity;
                               if(enteredqty < originalqty)
                                    {
                                   requisitionId =   parseInt($scope.StockTransfor.requisition);
                                   issueStatus = 213;
                                    }
                                if(enteredqty == originalqty)
                                    {
                                    requisitionId =   parseInt($scope.StockTransfor.requisition);
                                    issueStatus = 214;
                                    }
                                
                                if (value.quantity > 0) {
                                } else {
                                    isQuantity = false;
                                }
                             /*   if (value.batchNoExist == true) {
                                    if (value.batchDetails.length == 0) {
                                        batchValid = false
                                    }
                                }*/
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
                                    obj.batchNo = batchValue.batchNo;
                                    obj.batchQty = batchValue.batchQty;
                                    obj.manufacturer = batchValue.manufacturer;
                                    obj.mrpPrice = batchValue.mrpPrice;
                                    obj.itemId = batchValue.itemId;
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

                                            if(issueStatus != ""& requisitionId !="")
                                                {
                                                $http.get("app/hospital/purchase/consignmentRequest/issueStatus?requisitionId=" + requisitionId + "&issueStatus=" +issueStatus).success(function(response) {
//                                                    if (response.success == true) {
//                                                    }
                                                    $scope.getList();

                                                });
                                                }
                                            logger.logSuccess("Data Saved Successfully");
                                       
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
//                    } else {
//                        toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.ondutyrequestForm.$validationSummary), 555000, 'trustedHtml');
//                    }

                }
                
                
        
        
        
        
    });
    app.controller('ConsErrorCtrl', function($scope, $state, $http, $controller, logger, ngDialog, $location, $injector, sharedProperties, toaster, $rootScope, value) {
        $scope.value = value;
        //        alert($scope.value);
    });

//});