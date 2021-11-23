/*define([ 'hospital/inventory/inventory' ], function(module) {

    'use strict';

    module.registerController('gatePassAddCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, $filter, validationService,$timeout) {*/
    app.controller('gatePassAddCtrl', function($scope, $state, $http, $location, sharedProperties,
           toaster,$injector,logger,ngDialog,$rootScope,$stateParams,$controller,$filter, validationService,$timeout) {
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.rowCollectionItem = [];
        $scope.displayedCollection = [];
        $scope.displayedCollection1 = [];
        $scope.companyList = [];
        $scope.itemsByPage = 10;
        $scope.numPages = 0;
        $scope.isEdit = false;
        $scope.isItemEdit = false;

        $scope.uomCategoryList = [];

        $scope.itemListconv= [];
        
        $http.get("app/hospital/inventory/manageUOM/uomCategoryList").success(function(datas) {
            $scope.uomCategoryList = datas.uomCategoryList;
        });
        // Gate Pass Data
        $scope.gatePass = {
            gatepassId : '',
            gatePassNo : '',
            gatePassManualNo : '',
            vendorId : '',
            location : '',
            cusStreet : '',
            cusCity : '',
            cusZipcode : '',
            cusState : '',
            cusCountry : '',
            deliveryorderNo : '',
            invoiceNo : '',
            returnable : 'false',
            date : '',
            wardType : '',
            party : '',
            modeofdelivery : '',
            personname : '',
            couriername : '',
            vehicleno: '',
            docno : '',
            totalqty : 0,
            noofpackage : '',
            remarks : '',
            companyId : '',
            gatepassTables : [],
            ldeletedIds : [],
//            dataObjectFormat : '',
            return_date : ''
        };
        $scope.gatePassAddItem = {
                itemname : '',
                uom:'',
                quantity:0,
                altuom:'',
                altquantity:0,
                description:'',
                value:'',
                recevingQty:'',
                convertedQty:'',
                availQuantity:''
        }
        $scope.$watch('gatePass.companyId', function(newValue, oldValue) {
            if (newValue != '' && newValue != undefined) {
                $scope.companyDetails(newValue);
            }
        });

        $scope.getListOfDropdowns = function() {
            $http.get('app/purchaseOrder/getListOfDropdowns').success(function(data) {
                if (data.success == true) {
                    $scope.vendorList = data.vendorList;
                }
            });
            $http.get('his/inventory/gatePass/itemListconv').success(function(datas) {
                $scope.itemListconv = datas.itemList;
               }).error(function(data) {

            });  
        };
        $scope.getListOfDropdowns();

        $scope.$watch('gatePass.vendorId', function(newValue, oldVal) {
            if (newValue != '' && newValue != undefined) {
                if($scope.gatePass.companyId != null && $scope.gatePass.companyId != undefined
                        && $scope.gatePass.companyId != '' &&
                        $scope.gatePass.vendorId != null && $scope.gatePass.vendorId != undefined
                        && $scope.gatePass.vendorId != ''  )
                    {
                $http.get('his/inventory/gatePass/getPOListbasedonVendor?vendorId=' + $scope.gatePass.vendorId).success(function(datas) {
                    $scope.poList = datas;
                });
                    }
            }
        })
        
        
        
        $scope.companyDetails = function(companyId) {
            var obj = $filter('filter')($scope.companyList, {
                id : companyId
            });
            $http.post("his/inventory/gatePass/getCompanyDetails", companyId).success(function(response) {
                if (response.success == true) {
                    $scope.gatePass.cusCountry = response.gatePass.cusCountry;
                    $scope.gatePass.cusState = response.gatePass.cusState;
                    $scope.gatePass.cusZipcode = response.gatePass.cusZipcode;
                    $scope.gatePass.cusCity = response.gatePass.cusCity;
                    $scope.gatePass.deliveryorderNo = response.gatePass.deliveryorderNo;
                    $scope.gatePass.cusStreet = response.gatePass.cusStreet;
                    $scope.gatePass.location = response.gatePass.locationName;
                }

            }).error(function(result) {
                logger.logError("Error Please Try Again");
            });

        }

        $scope.calculateTotalAmount = function() {
            var totalQyty = 0;

            angular.forEach($scope.rowCollectionItem, function(value, key) {
                totalQyty = Number(value.quantity) + Number(totalQyty);
            });
            $scope.gatePass.totalqty = totalQyty;

        }

        $scope.convertedQtyValidation = function(){
            var convertedQtyValidationFlag = true;

            angular.forEach($scope.displayedCollection,function(row,index){
                
                if(row.uom != row.altuom)
                {
                    if(row.convertedpurchaseQty == 0 || row.convertedpurchaseQty == "" || 
                            row.convertedpurchaseQty == undefined  ){
                        convertedQtyValidationFlag = false;
                        logger.logError("Row - "+ (index+1)+" Please Enter Converted Quantity Details!");

                    }
                }
            });
            
           return convertedQtyValidationFlag; 
        }
        
        // Saving Data for GATEPASS
        $scope.save = function(gatePassForm) {
           
            if (new validationService().checkFormValidity(gatePassForm)) {
//                var flag  = $scope.convertedQtyValidation();
//                if(flag == true){
                //date
                var gatePassDate= $scope.gatePass.date;
                
                var date = new Date();
                $scope.ddMMyyyy = $filter('date')(new Date(), 'dd/MM/yyyy');
                var todayDate = $scope.ddMMyyyy;
                
                var dateParts = todayDate.split("/");
                var dateObject = new Date(+dateParts[2], dateParts[1] - 1, +dateParts[0]);
              
//previous date
                var prevDate = new Date(dateObject);
                prevDate.setDate(prevDate.getDate() - 2);
                var prevDateFormat= moment.unix(prevDate).format("dd/MM/yyyy");
                console.log(prevDateFormat);

  //after date
                
                var AftDate = new Date(dateObject);
                AftDate.setDate(AftDate.getDate() + 2);
              
                console.log(AftDate);
                

                 var date = gatePassDate.split("/");
                var gatePassDatef = new Date(+date[2], date[1] - 1, +date[0]);
                
                
                var dateParts = todayDate.split("/");
                var dateObject = new Date(+dateParts[2], dateParts[1] - 1, +dateParts[0]);
              
//                return date validation -- Rohini

                var requestDtAry = $scope.gatePass.date.split('/');
                var oldDateAry = $scope.gatePass.return_date.split('/');
                var requestDtObj = new Date(
                        requestDtAry[2],
                        requestDtAry[1] - 1,
                        requestDtAry[0]);
                var oldDateObj = new Date(
                        oldDateAry[2],
                        oldDateAry[1] - 1,
                        oldDateAry[0]);
                
            
//                end
                
                if(prevDate<=gatePassDatef && AftDate>=gatePassDatef){
//                    if (oldDateObj >=requestDtObj ) {                                                         
                $scope.gatePass.gatepassTables = $scope.displayedCollection;            
                if ($scope.gatePass.gatepassTables.length >= 1) {
                    $http.post("his/inventory/gatePass/save", $scope.gatePass).success(function(response) {
                        if (response.success == true) {
                            logger.logSuccess("Saved Successfully!");
                            $scope.cancel();
                        } else {
                            logger.logError(response.message);
                        }
                    });
                }
                
            
                else {
                    logger.logError("Atleast one item should be present");
                }
//                    }
//                    else {
//                        logger.logError("Retun Date Should Greater then Gate pass date ! ");
//                    }
                }
                else {
                    logger.logError("Date Should allow only two days before and after");
                }
//            }
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(gatePassForm.$validationSummary), 5000, 'trustedHtml');
            }
        
        };

        // Edit Data for GATEPASS
        var gatepassId = $location.search().gatepassId;
        if (gatepassId != undefined && gatepassId != '') {
            $scope.isEdit = true;
            $scope.isItemEdit = true;
            $http.post("his/inventory/gatePass/edit", gatepassId).success(function(response) {
                if (response.success == true) {
                    $scope.gatePass.gatePassNo = response.gatePassObj.gatePassNo;
                    $scope.gatePass.location = response.gatePassObj.location;
                    $scope.gatePass.cusStreet = response.gatePassObj.cusStreet;
                    $scope.gatePass.cusCity = response.gatePassObj.cusCity;
                    $scope.gatePass.cusZipcode = response.gatePassObj.cusZipcode;
                    $scope.gatePass.cusState = response.gatePassObj.cusState;
                    $scope.gatePass.cusCountry = response.gatePassObj.cusCountry;
                    $scope.gatePass.deliveryorderNo = response.gatePassObj.deliveryorderNo;
                    $scope.gatePass.invoiceNo = response.gatePassObj.invoiceNo;
                    $scope.gatePass.returnable = response.gatePassObj.returnable;
                    $scope.gatePass.date = response.gatePassObj.date;
                    $scope.gatePass.wardType = response.gatePassObj.wardType;
                    $scope.gatePass.party = response.gatePassObj.party;
                    $scope.gatePass.modeofdelivery = response.gatePassObj.modeofdelivery;
                    $scope.gatePass.personname = response.gatePassObj.personname;
                    $scope.gatePass.couriername = response.gatePassObj.couriername;
                    $scope.gatePass.vehicleno = response.gatePassObj.vehicleno;
                    if(response.gatePassObj.poId != null)
                    $scope.gatePass.poId = response.gatePassObj.poId.toString();
                    
                    $scope.gatePass.docno = response.gatePassObj.docno;
                    $scope.gatePass.noofpackage = response.gatePassObj.noofpackage;
                    $scope.gatePass.remarks = response.gatePassObj.remarks;
                    $scope.gatePass.companyId = response.gatePassObj.companyId;
                    $scope.gatePass.return_date = response.gatePassObj.return_date;
                    $scope.gatePass.vendorId = response.gatePassObj.vendorId;
                    $scope.gatePass.gatePassManualNo = response.gatePassObj.gatePassManualNo;
                    $scope.rowCollectionItem = response.gatePassObj.gatepassTables;
                    $scope.isDisable = false;
                    $scope.calculateTotalAmount();
                } else {
                    if (response.message != '') {
                        logger.logError(response.message);
                    }
                }
            });
        }

        $scope.update = function(gatePassForm) {
            var gatepassTables = $scope.displayedCollection;
            var updateGatePass = {
                'gatepassId' : gatepassId,
                'gatePassNo' : $scope.gatePass.gatePassNo,
                'location' : $scope.gatePass.location,
                'cusStreet' : $scope.gatePass.cusStreet,
                'cusCity' : $scope.gatePass.cusCity,
                'cusZipcode' : $scope.gatePass.cusZipcode,
                'cusState' : $scope.gatePass.cusState,
                'cusCountry' : $scope.gatePass.cusCountry,
                'deliveryorderNo' : $scope.gatePass.deliveryorderNo,
                'invoiceNo' : $scope.gatePass.invoiceNo,
                'returnable' : $scope.gatePass.returnable,
                'date' : $scope.gatePass.date,
                
                'wardType' : $scope.gatePass.wardType,
                'party' : $scope.gatePass.party,
                'modeofdelivery' : $scope.gatePass.modeofdelivery,
                'personname' : $scope.gatePass.personname,
                'couriername' : $scope.gatePass.couriername,
                'vehicleno' : $scope.gatePass.vehicleno,

                'docno' : $scope.gatePass.docno,
                'noofpackage' : $scope.gatePass.noofpackage,
                'remarks' : $scope.gatePass.remarks,
                'companyId' : $scope.gatePass.companyId,
                'return_date' : $scope.gatePass.return_date,
                'gatepassTables' : gatepassTables,
                'vendorId' : $scope.gatePass.vendorId,
                'gatePassManualNo' : $scope.gatePass.gatePassManualNo
            }
            
           var gatePassDate= $scope.gatePass.date;
            
            var date = new Date();
            $scope.ddMMyyyy = $filter('date')(new Date(), 'dd/MM/yyyy');
            var todayDate = $scope.ddMMyyyy;
            
            var dateParts = todayDate.split("/");
            var dateObject = new Date(+dateParts[2], dateParts[1] - 1, +dateParts[0]);
          
//previous date
            var prevDate = new Date(dateObject);
            prevDate.setDate(prevDate.getDate() - 2);
            var prevDateFormat= moment.unix(prevDate).format("dd/MM/yyyy");
            console.log(prevDateFormat);

//after date
            
            var AftDate = new Date(dateObject);
            AftDate.setDate(AftDate.getDate() + 2);
          
            console.log(AftDate);
            

             var date = gatePassDate.split("/");
            var gatePassDatef = new Date(+date[2], date[1] - 1, +date[0]);
            
            if(prevDate<=gatePassDatef && AftDate>=gatePassDatef){
            
            sharedProperties.clearObject();
            if (gatepassTables.length >= 1) {
                $http.post("his/inventory/gatePass/update", updateGatePass).success(function(response) {
                    if (response.success == true) {
                        logger.logSuccess("Updated Successfully!");
                        $scope.cancel();
                    } else {
                        logger.logError(response.message);
                    }
                });
            } else {
                logger.logError("Atleast One item should be present");
            }
            }
            else {
                logger.logError("Date Should allow only two days before and after");
            }

        };

        $scope.resetfun = function() {
            if ($scope.isEdit != true) {
                $scope.gatePass.location = '';
                $scope.gatePass.cusStreet = '';
                $scope.gatePass.cusCity = '';
                $scope.gatePass.cusZipcode = '';
                $scope.gatePass.cusState = '';
                $scope.gatePass.cusCountry = '';
                $scope.gatePass.deliveryorderNo = '';
                $scope.gatePass.invoiceNo = '';
                $scope.gatePass.returnable = '';
                $scope.gatePass.personname = '';
                $scope.gatePass.vehicleno= '';

                $scope.gatePass.noofpackage = '';
                $scope.gatePass.remarks = '';
                $scope.gatePass.companyId = '';
                $scope.gatePass.return_date = '';
                $scope.gatePass.modeofdelivery = '';
                $scope.gatePass.couriername = ''
                $scope.gatePass.party = '';
                $scope.gatePass.date = '';
                $scope.gatePass.gatePassNo = '';
                $scope.gatePass.totalqty = 0;
                $scope.rowCollectionItem = [];

            } else {
                if (gatepassId != undefined && gatepassId != '') {
                    $scope.isEdit = true;
                    $http.post("his/inventory/gatePass/edit", gatepassId).success(function(response) {
                        if (response.success == true) {
                            $scope.gatePass.gatePassNo = response.gatePassObj.gatePassNo;
                            $scope.gatePass.location = response.gatePassObj.location;
                            $scope.gatePass.cusStreet = response.gatePassObj.cusStreet;
                            $scope.gatePass.cusCity = response.gatePassObj.cusCity;
                            $scope.gatePass.cusZipcode = response.gatePassObj.cusZipcode;
                            $scope.gatePass.cusState = response.gatePassObj.cusState;
                            $scope.gatePass.cusCountry = response.gatePassObj.cusCountry;
                            $scope.gatePass.deliveryorderNo = response.gatePassObj.deliveryorderNo;
                            $scope.gatePass.invoiceNo = response.gatePassObj.invoiceNo;
                            $scope.gatePass.returnable = response.gatePassObj.returnable;
                            $scope.gatePass.date = response.gatePassObj.date;
                            $scope.gatePass.wardType = response.gatePassObj.wardType;
                            $scope.gatePass.party = response.gatePassObj.party;
                            $scope.gatePass.modeofdelivery = response.gatePassObj.modeofdelivery;
                            $scope.gatePass.personname = response.gatePassObj.personname;
                            $scope.gatePass.vehicleno = response.gatePassObj.vehicleno;

                            $scope.gatePass.couriername = response.gatePassObj.couriername;
                            $scope.gatePass.docno = response.gatePassObj.docno;
                            $scope.gatePass.noofpackage = response.gatePassObj.noofpackage;
                            $scope.gatePass.remarks = response.gatePassObj.remarks;
                            $scope.gatePass.companyId = response.gatePassObj.companyId;
                            $scope.rowCollectionItem = response.gatePassObj.gatepassTables;
                            $scope.isDisable = true;
                            $scope.calculateTotalAmount();
                        } else {
                            if (response.message != '') {
                                logger.logError(response.message);
                            }
                        }
                    });
                }
            }
        }

        // LIST
        $scope.getGatePassItemList = function() {
            $http.get("his/inventory/gatePass/listAddItem").success(function(response) {
                $scope.rowCollection = response.gatePassItemList;
            });

           /* $http.get('app/commonUtility/getCompanyList').success(function(datas) {
                $scope.companyList = datas;
            }).error(function(datas) {
            });*/
           /* $http.get('app/commonUtility/getCompanyListPurchase').success(function(datas) {
                $scope.companyList = datas;
                }).error(function(datas) {
            });*/
            
             $http.get($stateParams.tenantid + '/app/commonUtility/getCompanyListPurchase').success(function(datas) {
                $scope.companyList = datas;
            }).error(function(datas) {
            });
        }
        $scope.getGatePassItemList();
        

        

//        $scope.gatePassAddItem.uom = "120";
        $scope.$watch('gatePassAddItem.itemname', function(newValue, oldValue) {
           
            if (newValue != '' && newValue != undefined) {
               angular.forEach($scope.itemList,function(row,index){
                   if(row.id == newValue){
                       $scope.gatePassAddItem.uom = row.uom;
                       $scope.gatePassAddItem.quantity = row.purchaseQty;
                       $scope.gatePassAddItem.altuom = row.altuom;
                       $scope.gatePassAddItem.altquantity = row.altqty;
                       $scope.gatePassAddItem.availQuantity = row.availQuantity;
                   }
               });
            }
        });

//      $scope.gatePassAddItem.uom = "120";
      $scope.$watch('gatePassItemConvertedQty.convitemname', function(newValue, oldValue) {
         
          if (newValue != '' && newValue != undefined) {
             angular.forEach($scope.itemListconv,function(row,index){
                 if(row.id == newValue){
                     $scope.gatePassItemConvertedQty.convpurchaseuom = row.uom;
//                     $scope.gatePassItemConvertedQty.quantity = row.purchaseQty;
                     $scope.gatePassItemConvertedQty.convvendoruom = row.altuom;
//                     $scope.gatePassItemConvertedQty.altquantity = row.altqty;
                     $scope.gatePassItemConvertedQty.availQuantity = row.availQuantity;
                 }
             });
          }
      });
        // Saving Data for GATEPASS ADDITEM
        $scope.saveAddItem = function(gatePassItemForm, gatePassAddItem) {
            if (new validationService().checkFormValidity(gatePassItemForm)) {
                //if(Number(gatePassAddItem.quantity) <= Number(gatePassAddItem.availQuantity)){
                if (gatePassAddItem.quantity == 0) {
                    ngDialog.close();
                    
                    $scope.gatePassAddItembn = {
                            itemname : gatePassAddItem.itemname,
                            uom : gatePassAddItem.uom,
                            altuom : gatePassAddItem.altuom,
                    }
                                        
                    //$http.post("his/inventory/gatePass/itemName",  $scope.gatePassAddItembn).success(function(response) {
                    				         $http.post("app/hospital/purchase/consignmentRequest/itemName", $scope.gatePassAddItembn).success(function(response) {
                    
                        gatePassAddItem.itemNamenew = response.itemName;
                        gatePassAddItem.uomName = response.uomName;
                        gatePassAddItem.altuomName = response.altUomName;

                    });
                    if(gatePassAddItem.altquantity !=0 && gatePassAddItem.altquantity != ''
                        && gatePassAddItem.altquantity != undefined)
                    gatePassAddItem.altquantity = gatePassAddItem.altquantity;
                    else
                        gatePassAddItem.altquantity =   gatePassAddItem.quantity;

                    if(gatePassAddItem.altuom !=0 && gatePassAddItem.altuom != ''
                        && gatePassAddItem.altuom != undefined)
                    gatePassAddItem.altuom = gatePassAddItem.altuom;
                    else
                        gatePassAddItem.altuom =   gatePassAddItem.uom;
                    
                    $scope.rowCollectionItem.push(gatePassAddItem);
                    $scope.calculateTotalAmount();

                } else {
                    logger.logError("Quantity cannot be zero");
                }
            
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(gatePassItemForm.$validationSummary), 5000, 'trustedHtml');
            }

        };

        $scope.editAddItem = function(gatePassAddItem, index) {
//            $scope.callDialog($scope, gatePassAddItem, index, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope,$timeout);
//            $scope.callDialog($scope, 0, null, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope,$timeout);
            $scope.callDialog($scope, gatePassAddItem, index,  $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope,$timeout);

        };

        $scope.removeGateItem = function(displayedCollection) {
            $scope.tablerow = [];
            angular.forEach($scope.rowCollectionItem, function(row, index) {
                if (row.select == "" || row.select == null) {
                    $scope.tablerow.push(row);
                } else {
                    if (row.select == true) {
                        $scope.gatePass.ldeletedIds.push(row);
                    }
                }
            });
            $scope.rowCollectionItem = $scope.tablerow;

        }

        $scope.cancel = function() {
            $state.go("app.finance.inventory.gatePass.list");
        };

        $scope.add = function() {
            $scope.callDialog($scope, 0, null, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope,$timeout);
        };

        $scope.callDialog = function($scope, requestCode, editIndex, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope,$timeout) {
            ngDialog.open({
                scope : $scope,
                template : 'views/finance/inventory/gatePass/gatePassAddItem',
                controller : $controller('gatePassItemAddCtrl', {
                    $scope : $scope,
                    requestCode : requestCode,
                    editIndex : editIndex,
                    $http : $http,
                    ngDialog : ngDialog,
                    logger : logger,
                    $injector : $injector,
                    /* sharedProperties : sharedProperties, */
                    toaster : toaster,
                    $rootScope : $rootScope
                }),
                className : 'ngdialog-theme-plain',
                showClose : false,
                closeByDocument : false,
                closeByEscape : false,
            /* preCloseCallback : $scope.getList */
            });
        };

        $scope.updateAddItem = function(gatePassItemForm, gatePassAddItem, editRowIndex) {
            if (new validationService().checkFormValidity(gatePassItemForm)) {

                if(Number(gatePassAddItem.quantity) <= Number(gatePassAddItem.availQuantity)){
                if (gatePassAddItem.quantity > 0) {
                    ngDialog.close();

                    $scope.gatePassAddItembn = {
                            itemname : gatePassAddItem.itemname,
                            uom : gatePassAddItem.uom,
                            altuom : gatePassAddItem.altuom,
                    }

                    if(gatePassAddItem.altquantity !=0 && gatePassAddItem.altquantity != ''
                        && gatePassAddItem.altquantity != undefined)
                    gatePassAddItem.altquantity = gatePassAddItem.altquantity;
                    else
                        gatePassAddItem.altquantity =   gatePassAddItem.quantity;

                    if(gatePassAddItem.altuom !=0 && gatePassAddItem.altuom != ''
                        && gatePassAddItem.altuom != undefined)
                    gatePassAddItem.altuom = gatePassAddItem.altuom;
                    else
                        gatePassAddItem.altuom =   gatePassAddItem.uom;
/*                    $http.post("his/inventory/gatePass/itemName",  $scope.gatePassAddItembn).success(function(response) {

*/                        

				         $http.post("app/hospital/purchase/consignmentRequest/itemName", newValue).success(function(response) {
						
						gatePassAddItem.itemNamenew = response.itemName;

                        gatePassAddItem.uomName = response.uomName;
                        gatePassAddItem.altuomName = response.altUomName;
                        angular.forEach(  $scope.rowCollectionItem,function(row,index){
                            if(editRowIndex == index){
                                
                                $scope.rowCollectionItem[index].itemname = gatePassAddItem.itemname;                                
                                $scope.rowCollectionItem[index].itemNamenew = gatePassAddItem.itemNamenew;
                                $scope.rowCollectionItem[index].uom= gatePassAddItem.uom;
                                $scope.rowCollectionItem[index].uomName= gatePassAddItem.uomName;
                                $scope.rowCollectionItem[index].quantity= gatePassAddItem.quantity;
                                $scope.rowCollectionItem[index].altuom=gatePassAddItem.altuom;
                                $scope.rowCollectionItem[index].altuomName=gatePassAddItem.altuomName;
                                $scope.rowCollectionItem[index].altquantity= gatePassAddItem.altquantity;
                                $scope.rowCollectionItem[index].description= gatePassAddItem.description;
                                $scope.rowCollectionItem[index].value=gatePassAddItem.value;

                                $scope.rowCollectionItem[index].availQuantity=gatePassAddItem.availQuantity;
                        
                            }
                        })
                        $scope.calculateTotalAmount();

                    });
//                    $scope.rowCollectionItem[editRowIndex] = gatePassAddItem;

                   
                    
                } else {
                    logger.logError("Quantity cannot be zero");
                }
            }else {
                logger.logError("Quantity Cannot be Increased!");
            }
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(gatePassItemForm.$validationSummary), 5000, 'trustedHtml');
            }

        }
/*Converted Qty Calc*/

        $scope.callDialogPopUp = function($scope, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, rowId,rowdetail) {
            ngDialog.open({
                scope : $scope,
                template : 'views/finance/inventory/gatePass/gatePassConvertedQtyView',
                controller : $controller('gatepassconvertedQtyViewCtrl', {
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
        $scope.ItemConvertedQtyCalc = function(itemdetailList, index){
//            if(itemdetailList.uom != itemdetailList.altuom)
            $scope.callDialogPopUp($scope, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, index,itemdetailList);

            
        }    
        $scope.saveItemConvrtQty = function(gatePassItemConvertedQty, indx){
            angular.forEach(  $scope.rowCollectionItem,function(row,index){
                if(indx == index){
//                    if(Number(gatePassItemConvertedQty.receivingQtypop) <= Number($scope.rowCollectionItem[index].quantity)){
//                        if(Number(gatePassItemConvertedQty.convertedQtypop)<= Number(gatePassItemConvertedQty.receivingQtypop)){
                    
                    
                    $scope.gatePassAddItembn = {
                            itemname : gatePassItemConvertedQty.convitemname,
                            uom : gatePassItemConvertedQty.convpurchaseuom,
                            altuom : gatePassItemConvertedQty.convendoruom,
                    }
                                        
                    $http.post("his/inventory/gatePass/itemName",  $scope.gatePassAddItembn).success(function(response) {
                        gatePassItemConvertedQty.convitemNamenew = response.itemName;
                        gatePassItemConvertedQty.convpurchaseuomName = response.uomName;
                        gatePassItemConvertedQty.convvendoruomName = response.altUomName;
                        $scope.rowCollectionItem[index].convitemNamenew = gatePassItemConvertedQty.convitemNamenew;
//                        $scope.rowCollectionItem[index].convpurchaseuom = gatePassItemConvertedQty.convpurchaseuom;
                        $scope.rowCollectionItem[index].convvendoruomName = gatePassItemConvertedQty.convvendoruomName;
                        $scope.rowCollectionItem[index].convitemname = gatePassItemConvertedQty.convitemname;
//                      $scope.rowCollectionItem[index].convpurchaseuom = gatePassItemConvertedQty.convpurchaseuom;
                      $scope.rowCollectionItem[index].convendoruom = gatePassItemConvertedQty.convendoruom;
                     
                        $scope.rowCollectionItem[index].receivingvendorQty = gatePassItemConvertedQty.receivingvendorQty;
                        $scope.rowCollectionItem[index].convertedpurchaseQty = gatePassItemConvertedQty.convertedpurchaseQty;
                        ngDialog.close();
                    });
                   
//                        }else{
//                            logger.logError("Converted Quantity cannot be Greater then Receiving Quantity!");
//
//                        }
//                    }else{
//                        logger.logError("Receiving Quantity cannot be Greater then Purchase Quantity!");
//
//                    }
                }
            })
        }
        
        /*END*/
    });

    app.controller('gatePassItemAddCtrl', function($scope, $http, ngDialog, logger, requestCode, editIndex, $injector, sharedProperties, toaster, $rootScope,$timeout) {
        $scope.cancelAddItem = function() {
            ngDialog.close();
        };
        $scope.itemList= [];

        $scope.uomCategoryList = [];

        $http.get("app/hospital/inventory/manageUOM/uomCategoryList").success(function(datas) {
            $scope.uomCategoryList = datas.uomCategoryList;
        });
        
        
        $scope.getItemListfromPO = function(vendorId){
            $scope.itemList = [];
/*              $http.get('his/inventory/gatePass/itemListNew?vendorId='+vendorId).success(function(datas) {
*/               
								         $http.post("app/hospital/purchase/consignmentRequest/itemList", newValue).success(function(response) {
				
				 $scope.itemList = datas.itemList;
               }).error(function(data) {

            });        
        }
        
        
        $scope.$watch('gatePass.poId', function(newValue, oldValue) {
        
            if (newValue != '' && newValue != undefined) {
                $scope.getItemListfromPO(newValue);
            }
        });
        
        
        $scope.getDropdownvalue = function() {
            if($scope.gatePass.poId == null || $scope.gatePass.poId == "" || $scope.gatePass.poId == undefined ){
              $http.get('his/inventory/gatePass/itemList').success(function(datas) {
                $scope.itemList = datas.itemList;
               }).error(function(data) {

            });      
            }else{

                $scope.getItemListfromPO($scope.gatePass.poId);
            }
        };
        $scope.getDropdownvalue();
        
//        $scope.gatePassAddItem = requestCode;
        
        $scope.editRowIndex = editIndex;
        if (requestCode != undefined && requestCode != null && requestCode != '') {
            $scope.isItemEdit = true;

        } else {
            $scope.isItemEdit = false;
        }
        
        if( $scope.isItemEdit == false){
            $scope.gatePassAddItem = {
                    itemname : '',
                    uom:'',
                    quantity:0,
                    altuom:'',
                    altquantity:0,
                    description:'',
                    value:'',
                    recevingQty:'',
                    availQuantity:''
            }
            }   if( $scope.isItemEdit == true){
                var itembean = "";
                angular.forEach(  $scope.rowCollectionItem,function(row,index){
                    if($scope.editRowIndex == index)
                        itembean = row;
                })
                $scope.gatePassAddItem = {
                        itemname : itembean.itemname,
                        uom: itembean.uom,
                        quantity: itembean.quantity,
                        altuom: itembean.altuom,
                        altquantity: itembean.altquantity,
                        description: itembean.description,
                        value: itembean.value,
                        recevingQty:itembean.altquantity,
                        availQuantity:itembean.availQuantity
                }
                }
        
    });
  
    module.registerDirective('phonenumbersOnly', function(logger) {
        return {
            require : 'ngModel',
            link : function(scope, element, attrs, modelCtrl) {

                modelCtrl.$parsers.push(function(inputValue) {
                    var inputValue = modelCtrl.$viewValue;
                    if (inputValue == undefined)
                        return ''
                    var transformedInput = inputValue.replace(/[^0-9]/g, '');
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


    app.controller('gatepassconvertedQtyViewCtrl', function($scope, $state, $http, $location, sharedProperties, toaster, $injector, logger, ngDialog, $rootScope, $controller,rowdetailList,rowId) {
      
        $scope.cancelAddItem = function() {
            ngDialog.close();
        };
        
        $scope.ngcancel = function(){
            ngDialog.close();
        }
        

        $scope.uomCategoryList = [];



        $http.get('his/inventory/gatePass/itemListconv').success(function(datas) {
            $scope.itemListconv = datas.itemList;
           }).error(function(data) {

        });  
        
        $http.get("app/hospital/inventory/manageUOM/uomCategoryList").success(function(datas) {
            $scope.uomCategoryList = datas.uomCategoryList;
        });
        $scope.gatePassItemConvertedQty = {
                dtlItemName : '',
                uom:'',
                quantity:0,
                altuom:'',
                altquantity:0,
                description:'',
                value:'',
                convertedUom:'',
                convertedQty:0,
                availQuantity:'',
                receivingvendorQty:'',
                convertedpurchaseQty:''
        }
        
//        

        var itembean = "";
        angular.forEach(  $scope.rowCollectionItem,function(row,index){
            if(rowId == index)
                itembean = row;
        })
        $scope.gatePassItemConvertedQty = {
            dtlItemId : itembean.itemname,
            dtlItemName : itembean.itemNamenew,
                uom: itembean.uom,
                purchaseUOMName :  itembean.uomName,
                purchaseQty: itembean.quantity,
                vendorUOM: itembean.altuom,
                vendorUOMName: itembean.altuomName,
                vendorQty: itembean.altquantity,
                description: itembean.description,
                value: itembean.value,
             receivingvendorQty:itembean.altquantity,
             convertedpurchaseQty:itembean.quantity,
                rowId:rowId
        }
        
    
});