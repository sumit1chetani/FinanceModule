define([ 'hospital/inventory/inventory' ], function(module) {

    'use strict';

        module.registerController('qualityAddCtrl', function($scope, $state, $http, $location, sharedProperties,toaster,$injector,logger,ngDialog,$rootScope,$controller) {
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages=0
        $scope.isEdit = false;
        $scope.locationList =[];
        $scope.vendorList =[];
        $scope.poList =[];
        $scope.poDtlList;
        $scope.dtlList=[];
        $scope.reqDtlList;
        $scope.isRate =false;
        $scope.rowCollectionDeliveryItem=[];
        $scope.batchListItem=[];
        $scope.grnQCData=[];
        var productRowId = 0;
        $scope.grnData = {
                grnId :'',
                grnCode :'',
                locId :'',
                locName :'',
                vendorId :'',
                poId :'',
                poNo :'',
                poType :'',
                grnDate :'',
                poRequisitionId :'',
                poRequisition :'',
                delOrderNo :'',
                delOrderDate :'',
                invoiceNo :'',
                invoiceDate :'',
                deliveryMthd :'',
                transMode :'',
                dstLocId :'',
                conTransferNo :'',
                grnTables : [],
                schDtlList :[]
        }

        $scope.purchaseData = {
                vendorId : '',
                city : '',
                state : '',
                zipCode : '',
                country : '',
                address : ''
        }

        $scope.cancel = function() {
            $state.go("app.finance.inventory.quality.list");
        };

        //Grn Detail table
        $scope.loadgrnTable = function() {
            var grnTable = {};

            grnTable = {
                poId :'',
                poNo : '',
                poDate:'',
                dtlItemId : '',
                dtlItemCode : '',
                dtlItemName : '',
                dtlItemDesc : '',
                dtlPrice:'',
                dtlQty:'',
                dtlStatus:'',
                dtlPODtlId :'',
                qualityCheck :'',
                sampleQty :'',
                qcStatus :'',
                qcRemarks :'',
                batchDtls :[],
                scheduleList :[]
            };
            $scope.grnData.grnTables.push(grnTable);
        }
        $scope.loadgrnTable();

        /*Purchsae Order View .. Starts...*/
        $scope.ggrnData = {
                ggrnTables : [],
                poId :'',
                poNo : '',
                poDate:'',
                dtlItemId : '',
                dtlItemCode : '',
                dtlItemName : '',
                dtlItemDesc : '',
                dtlPrice:'',
                dtlQty:'',
                dtlStatus:'',
                isQC :'',
                dtlPODtlId :''

        }

        /*Purchsae Requisition View .. Starts...*/
        $scope.grnReqData ={
                ggrnTables : [],
                poId :'',
                poNo : '',
                poDate:'',
                dtlItemId : '',
                dtlItemCode : '',
                dtlItemName : '',
                dtlItemDesc : '',
                dtlPrice:'',
                dtlQty:'',
                dtlStatus:'',
        };
        $scope.rowReqCollection = [];

        var currentDate = new Date();
        currentDate = ('0' + currentDate.getDate()).slice(-2)+"/"+('0' + (Number(currentDate.getMonth())+1)).slice(-2)+"/"+currentDate.getFullYear();
        $scope.grnData.grnDate = currentDate;
        $scope.grnData.delOrderDate = currentDate;
        $scope.grnData.invoiceDate = currentDate;
        $scope.poFullList=[];

        $scope.getDropdownvalue = function() {
            $http.get('app/grn/getLocationList').success(function(datas) {
                $scope.locationList = datas.lLocationLst;
                }).error(function(datas) {
            });

            $http.get('app/grn/getVendorList').success(function(datas) {
                $scope.vendorList = datas.lVendor;
                }).error(function(datas) {
            });

            $http.get('app/grn/getPOList').success(function(datas) {
                $scope.poList = datas.lPurchaseOrder;
                $scope.poFullList = datas.lPurchaseOrder;
                }).error(function(datas) {
            });

        };

        $scope.getDropdownvalue();

        $scope.getPODtlList = function(model) {
            $http.get('app/grn/getPODtlList?poId='+model).success(function(datas) {
                $scope.poDtlList =[];
                $scope.poDtlListFinal =[];
                console.log(" :::::::::::::::::::datas.lPurchaseOrderDtl");
                console.log(datas.lPurchaseOrderDtl);
                angular.forEach(datas.lPurchaseOrderDtl,function(value,index){

                    $scope.poDtlListFinal[index] = value;
                    $scope.poDtlListFinal[index].dtlPrice = parseFloat(value.dtlPrice).toFixed(2);

                });
                $scope.poDtlList = $scope.poDtlListFinal;
                }).error(function(datas) {
            });

            $http.get('app/grn/getRequisition?poId='+model).success(function(datas) {
                console.log("Reqisition :::::::::");
                console.log(datas);

                if(datas.lRequisitionList != undefined && datas.lRequisitionList.length >0){
                    angular.forEach(datas.lRequisitionList ,function(value,index){
                        if(index>0){
                            $scope.grnData.poRequisition += " , "+value.poRequisition;
                            $scope.grnData.poRequisitionId += ","+value.poRequisitionId;
                        }else{
                            $scope.grnData.poRequisition = value.poRequisition;
                            $scope.grnData.poRequisitionId = value.poRequisitionId;
                        }

                    });
                }else{
                    $scope.grnData.poRequisition = '';
                    $scope.grnData.poRequisitionId = '';
                }

                $scope.reqDtlList =[];
                if(datas.lRequisitionDtl != undefined && datas.lRequisitionDtl.length >0){
                    $scope.reqDtlList = datas.lRequisitionDtl;
                }

                }).error(function(datas) {
            });
        };

        $scope.$watch('grnData.vendorId',function(newValue, oldVal){
            debugger;
            if (newValue != '' && newValue != undefined) {
                $http.get('app/grn/getVendorAddress?vendorId='+newValue).success(function(datas) {
                    $scope.purchaseData.city = datas.lVendorAddressDtl[0].city;
                    $scope.purchaseData.state = datas.lVendorAddressDtl[0].state;
                    $scope.purchaseData.address = datas.lVendorAddressDtl[0].address;
                    $scope.purchaseData.country = datas.lVendorAddressDtl[0].country;
                    $scope.purchaseData.zipCode = datas.lVendorAddressDtl[0].zipCode;

                    if($scope.grnData.poId ==''){
                        $scope.poList = datas.lPurchaseOrder;
                    }

                    }).error(function(datas) {
                });
            }else{
                $scope.purchaseData.city = '';
                $scope.purchaseData.state = '';
                $scope.purchaseData.address = '';
                $scope.purchaseData.country = '';
                $scope.purchaseData.zipCode = '';
                $scope.poList = $scope.poFullList;
            }
         });

        $scope.$watch('grnData.poId',function(newValue, oldVal){
            debugger;
            var isFlag =true;
            if (newValue != '' && newValue != undefined) {
                angular.forEach($scope.poList ,function(value,index){
                    debugger;
                    if(isFlag){
                        if (newValue === value.id){
                            $scope.grnData.poId = value.id;
                            $scope.grnData.poNo = value.text;
                            $scope.grnData.poType = value.poType;
                            if($scope.grnData.vendorId == ''){
                                $scope.grnData.vendorId = value.vendorId;
                            }
                            if(value.poType == 'Rate Contract'){
                                $scope.isRate =true;
                            }else{
                                $scope.isRate =false;
                            }
                            $scope.grnData.conTransferNo = value.conTransferNo;
                            $scope.getPODtlList(value.id);
                            isFlag =false;
                        }else{
                            $scope.grnData.poId = '';
                            $scope.grnData.poNo = '';
                            $scope.grnData.poType ='';
                            $scope.grnData.conTransferNo ='';
                            $scope.poDtlList =[];
                        }
                    }
                });
            }
         });

        $scope.loadVendorAddress = function(){
            var vendorId = $scope.grnData.vendorId;
            $http.get('app/grn/getVendorAddress?vendorId='+vendorId).success(function(datas) {
                $scope.purchaseData.city = datas.lVendorAddressDtl[0].city;
                $scope.purchaseData.state = datas.lVendorAddressDtl[0].state;
                $scope.purchaseData.address = datas.lVendorAddressDtl[0].address;
                $scope.purchaseData.country = datas.lVendorAddressDtl[0].country;
                $scope.purchaseData.zipCode = datas.lVendorAddressDtl[0].zipCode;
                }).error(function(datas) {
            });
        }


        /**** Auto suggestion text box for Purchase order *****/

        $scope.formatLabel = function(model) {
            debugger;
            var isFlag =true;
            if($scope.poList.length>0){
                for (var i=0; i< $scope.poList.length; i++) {
                    debugger;
                    if(isFlag){
                        if (model === $scope.poList[i].poId)
                        {
                            debugger;
                            $scope.grnData.poId = $scope.poList[i].poId;
                            $scope.grnData.poNo = $scope.poList[i].poNo;
                            $scope.getPODtlList(model);
                            isFlag = false;
                        }else{
                           // $scope.grnData.poId=model ;
                        }
                    }
                }
            }else{
                $scope.grnData.poId=model ;
                $scope.poDtlList =[];
            }
            return $scope.grnData.poNo;
          }

        $scope.calculateExpDate = function(str){
            debugger;
            var expDate="";
            if( /^\d{2}\/\d{2}\/\d{4}$/i.test( str ) ) {

                var parts = str.split("/");
                var day = parts[0] && parseInt( parts[0], 10 );
                var month = parts[1] && parseInt( parts[1], 10 );
                var year = parts[2] && parseInt( parts[2], 10 );
                var duration = parseInt( 1, 10);

                if( day <= 31 && day >= 1 && month <= 12 && month >= 1 ) {

                    var expiryDate = new Date( year, month - 1, day );
                    expiryDate.setFullYear( expiryDate.getFullYear() + duration );

                    var day = ( '0' + expiryDate.getDate() ).slice( -2 );
                    var month = ( '0' + ( expiryDate.getMonth() + 1 ) ).slice( -2 );
                    var year = expiryDate.getFullYear();

                    expDate = day + "/" + month + "/" + year;

                } else {
                    // display error message
                }
            }
            return expDate;
    }


     //NG DIALOG FOR PURCHASE ORDER DETAILS
       $scope.getPurchaseInfo = function(){
           $scope.callPurchaseDialog($scope,$http, ngDialog, logger,$injector, sharedProperties, toaster,$rootScope);
       };

       $scope.callPurchaseDialog = function($scope,$http, ngDialog, logger,$injector, sharedProperties, toaster,$rootScope){
           ngDialog.open({
               scope: $scope,
               template: 'views/hospital/inventory/ggrn/ggrnviewpurchase',
               controller: $controller('poPopupCtrl', {
                   $scope: $scope,

                   $http:$http,
                   ngDialog:ngDialog,
                   logger:logger,
                   $injector:$injector,
                   sharedProperties:sharedProperties,
                   toaster:toaster,
                   $rootScope:$rootScope
               }),
               className: 'ngdialog-theme-plain',
               showClose: false,
               closeByDocument: false,
               closeByEscape: false,
               preCloseCallback : $scope.getList
           });

           $scope.ggrnData = $scope.poDtlList;
           $scope.rowCollection = $scope.ggrnData;

       }

       $scope.fetchDetail=function(value){
           $scope.finalList=[];
           var schIndx=0;
           var scheduleLt=[],batchLst=[];
           angular.forEach(value, function(row, index) {
               var scheduleList=[];
               debugger;
               if(row.select != undefined && row.select != false){
                   var obj='';
                   obj = row;
                   if(!$scope.isRate){
                       obj.dtlQty =  row.pendingQty;
                   }else{
                       obj.dtlQty =  0;
                   }
                   obj.mrp ='';
                   $scope.finalList.push(obj);
                   if($scope.isRate){
                       if(row.scheduleList != undefined && row.scheduleList.length != 0){
                           angular.forEach(row.scheduleList, function(rowData, indexs) {
                               debugger;
                               scheduleList[indexs]= rowData;
                           });
                       }
                   }

                   angular.forEach(scheduleList, function(data, dataindex) {
                       debugger;
                       scheduleLt[schIndx]=data;
                       schIndx++;
                   });
                   row.batchDtls = batchLst;
               }else{
                   //$scope.finalList =[];
               }
           });
           $scope.grnData.grnTables = $scope.finalList;
           console.log("$scope. $scope.finalList;::::::::::::");
           console.log($scope.grnData.grnTables);

           $scope.rowCollectionDeliveryItem = scheduleLt;
           $scope.grnData.schDtlList = scheduleLt;
           $scope.ngcancel();
       }

      //NG DIALOG FOR REQ ORDER DETAILS
        $scope.getReqInfo = function(){
            $scope.callreqDialog($scope,$http, ngDialog, logger,$injector, sharedProperties, toaster,$rootScope);
        };

        $scope.callreqDialog = function($scope,$http, ngDialog, logger,$injector, sharedProperties, toaster,$rootScope){
            ngDialog.open({
                scope: $scope,
                template: 'views/hospital/inventory/ggrn/ggrnviewreq',
                controller: $controller('poPopupCtrl', {
                    $scope: $scope,
                    $http:$http,
                    ngDialog:ngDialog,
                    logger:logger,
                    $injector:$injector,
                    //sharedProperties:sharedProperties,
                    toaster:toaster,
                    $rootScope:$rootScope
                }),
                className: 'ngdialog-theme-plain',
                showClose: false,
                closeByDocument: false,
                closeByEscape: false,
                preCloseCallback : $scope.getList
            });

            $scope.grnReqData = $scope.reqDtlList;
            $scope.rowReqCollection = $scope.grnReqData;

        }

        /*Batch Dtls.. Starts...*/
        $scope.loadgrnBatchDtls = function() {
            var grnBatchDtls = [],
            grnBatchDtlObj = {
                    batchItemId : '',
                    batchItemName : '',
                    batchQty :'',
                    lotNo :'',
                    expiryDate : '',
                    manufactureDef:'',
                    mrp : ''
                }
            debugger;
            grnBatchDtls.splice(0, 0,grnBatchDtlObj);
            $scope.grnData.grnTables[productRowId].batchDtls = grnBatchDtls;
           // $scope.grnData.grnTables[productRowId].batchDtls.splice(0, 0,grnBatchDtls);
        }

        //add Batch Row
        $scope.addBatchRow = function(tables) {
          var table = {
                  batchItemId : $scope.grnData.grnTables[productRowId].batchDtls[0].batchItemId,
                  batchItemName : $scope.grnData.grnTables[productRowId].batchDtls[0].batchItemName,
                  batchQty :'',
                  lotNo :'',
                  expiryDate : $scope.grnData.grnTables[productRowId].batchDtls[0].expiryDate,
                  manufactureDef:'',
                  mrp : ''
          };
          $scope.grnData.grnTables[productRowId].batchDtls.push(table);
        };

        //remove Row
        $scope.removeBatchRow = function(table) {
            $scope.tablerow = [];
            var table = $scope.grnData.grnTables[productRowId].batchDtls
            angular.forEach(table, function(row, index) {
                debugger;
                var check = row.select;
                console.log(index);
                if (check == undefined || check == "") {
                    debugger;
                    $scope.tablerow.push(row);
                } else {

                }
            });
            table = $scope.tablerow;
            $scope.grnData.grnTables[productRowId].batchDtls = $scope.tablerow;
            $scope.batchListItem = $scope.tablerow;

        };

      //NG DIALOG FOR Batch Details
        $scope.getProductInfo = function(rowId){
            productRowId = rowId;
            $scope.callDialog($scope,$http, ngDialog, logger,$injector, sharedProperties, toaster,$rootScope,rowId);
        };

        $scope.callDialog = function($scope,$http, ngDialog, logger,$injector, sharedProperties, toaster,$rootScope,rowId){
            ngDialog.open({
                scope: $scope,
                template: 'views/hospital/inventory/ggrn/ggrnviewproductinfo',
                controller: $controller('poPopupCtrl', {
                    $scope: $scope,
                    $http:$http,
                    ngDialog:ngDialog,
                    logger:logger,
                    $injector:$injector,
                    sharedProperties:sharedProperties,
                    toaster:toaster,
                    $rootScope:$rootScope
                }),
                className: 'ngdialog-theme-plain',
                showClose: false,
                closeByDocument: false,
                closeByEscape: false,
                preCloseCallback : $scope.getList
            });
            debugger;

            console.log("$scope.grnData.batchDtls ::::::::::::::::");
            console.log($scope.grnData.grnTables[rowId]);
            if($scope.grnData.grnTables[rowId].batchDtls.length ==0){
                $scope.loadgrnBatchDtls();
            }

            if($scope.grnData.grnTables[rowId].batchDtls[0].batchItemId == '' || $scope.grnData.grnTables[rowId].batchDtls[0].batchItemId == null){
                $scope.grnData.grnTables[rowId].batchDtls[0].batchItemId = $scope.grnData.grnTables[rowId].dtlItemId;
                $scope.grnData.grnTables[rowId].batchDtls[0].batchItemName = $scope.grnData.grnTables[rowId].dtlItemCode+" - "+$scope.grnData.grnTables[rowId].dtlItemName;
            }
            if($scope.grnData.grnTables[rowId].batchDtls[0].expiryDate == '' || $scope.grnData.grnTables[rowId].batchDtls[0].expiryDate == null){
                $scope.grnData.grnTables[rowId].batchDtls[0].expiryDate = $scope.calculateExpDate(currentDate);
            }

            console.log("$scope.grnData.batchDtls ::::::::::::::::");
            console.log($scope.grnData.grnTables[rowId].batchDtls);

            $scope.batchListItem = $scope.grnData.grnTables[rowId].batchDtls;

            angular.forEach($scope.batchListItem ,function(value,index){

                $scope.batchListItem[index] = value;
                if(!isNaN(parseFloat(value.mrp))){
                    $scope.batchListItem[index].mrp = parseFloat(value.mrp).toFixed(2);
                }

            });
        }


        //NG DIALOG FOR QC Details
        $scope.getQCInfo = function(rowId){
            debugger;
            $scope.grnQCData.rowId = rowId;
            $scope.grnQCData.dtlItemDesc = $scope.grnData.grnTables[rowId].dtlItemCode +" - "+$scope.grnData.grnTables[rowId].dtlItemName;
            $scope.grnQCData.qcRemarks = $scope.grnData.grnTables[rowId].qcRemarks;
            $scope.grnQCData.qcStatus = $scope.grnData.grnTables[rowId].qcStatus;

            if(!isNaN(parseFloat($scope.grnData.grnTables[rowId].mrp)))
                $scope.grnQCData.sampleQty = $scope.grnData.grnTables[rowId].sampleQty;
            else
                $scope.grnQCData.sampleQty ='';

            $scope.callQCDialog($scope,$http, ngDialog, logger,$injector, sharedProperties, toaster,$rootScope,$scope.grnQCData);

        };

        $scope.callQCDialog = function($scope,$http, ngDialog, logger,$injector, sharedProperties, toaster,$rootScope,rowData){
            ngDialog.open({
                scope: $scope,
                template: 'views/hospital/inventory/ggrn/ggrnviewproductQC',
                controller: $controller('poPopupCtrl', {
                    $scope: $scope,
                    $http:$http,
                    ngDialog:ngDialog,
                    logger:logger,
                    $injector:$injector,
                    sharedProperties:sharedProperties,
                    toaster:toaster,
                    $rootScope:$rootScope
                }),
                className: 'ngdialog-theme-plain',
                showClose: false,
                closeByDocument: false,
                closeByEscape: false,
                preCloseCallback : $scope.getList
            });
            debugger;
            console.log("$scope.grnQCData ::::::::::::::::");
            console.log($scope.grnQCData);

        }

        $scope.saveQCDtls = function(value){
            debugger;
            $scope.grnData.grnTables[value.rowId].dtlItemDesc = $scope.grnQCData.dtlItemDesc;
            $scope.grnData.grnTables[value.rowId].qcRemarks = $scope.grnQCData.qcRemarks;
            $scope.grnData.grnTables[value.rowId].qcStatus = $scope.grnQCData.qcStatus;
            $scope.grnData.grnTables[value.rowId].sampleQty = $scope.grnQCData.sampleQty;
            $scope.ngcancel();
        }

        $scope.ngcancel = function(){
            ngDialog.close();
        }


        $scope.saveBtchDtls = function(value){
            debugger;
            console.log("$scope.grnData.batchDtls ::::SAveeeeeeeeee::::::::::::");
            console.log($scope.grnData.grnTables[productRowId].batchDtls);
            $scope.ngcancel();
        }

        $scope.validateQty = function(tables){
            var flag =true,msg='';
            angular.forEach(tables, function(row, index) {
                debugger;
                console.log("row :::::::::::::::::::::;");
                console.log(row);
                var batchQty =0;

                if(row.batchDtls.length == 0){
                    msg ="Please Add Batch Details For Item - "+ row.dtlItemName;
                    flag =false;
                }else{
                    angular.forEach(row.batchDtls, function(subrow, subindex) {
                        if(subrow.batchQty == 0 || subrow.batchQty ==''){
                            msg ="Please Add Batch Details For Item - "+ row.dtlItemName;
                            flag =false;
                        }
                        if(!isNaN(parseInt(subrow.batchQty))){
                            batchQty = parseInt(batchQty)+parseInt(subrow.batchQty);
                        }
                    });

                    if(batchQty != row.dtlQty){
                        msg ="Batch Qty should match with Receiving Qty For Item - "+ row.dtlItemName;
                        flag =false;
                    }
                }
                if(row.pendingQty < row.dtlQty ){
                    msg ="Receiving Qty should not Exceed Pending Qty For Item - "+ row.dtlItemName;
                    flag =false;
                }

                if(row.dtlItemCode =='' || row.dtlItemName =='' ){
                    msg ="Please Select Items From Purchase Order Details";
                    flag =false;
                }

            });
            if(!flag){
                logger.logError(msg);
            }
            return flag;
        }

        $scope.onSubmit = function(grnData) {
            debugger;
            $scope.grnData.deliveryMthd =2;
            console.log("$scope.grnData ::::::;;;");
            console.log($scope.grnData);
            console.log($scope.grnData.grnTables);
            if($scope.grnData.locId != ""){
                if($scope.grnData.dstLocId != ""){
                if($scope.grnData.poId != ""){
                    if($scope.grnData.deliveryMthd != ""){
                        if($scope.grnData.transMode != ""){
                            if($scope.grnData.vendorId != ""){
                                if($scope.validateQty($scope.grnData.grnTables)){
                                        $scope.save();
                                }
                        }else
                            logger.logError("Please Select Vendor");

                        } else
                            logger.logError("Please Select Transport Mode");
                    } else
                        logger.logError("Please Select Delivery Method");
                }else
                    logger.logError("Please Select Purchase Order");
                }else
                    logger.logError("Please Select Destination Location");
            }else
                logger.logError("Please Select Source Location");

        };

        $scope.save = function(){
                $http.post('app/grn/updateQC', $scope.grnData).success(function(result) {
                    if (result == false) {
                        logger.logError("Quality Check Not updated...");
                    } else {
                        $location.path("/hospital/inventory/qualityCtrl/list");
                        logger.logSuccess("GRN updated successfully");
                    }

                }).
                error(function(data) {
                    console.log(data);
                });
        };

        debugger;
        var grnCode=$location.search().grnCode;
        if(grnCode == undefined || grnCode == null || grnCode ==""){
            $scope.isEdit=false;
        }else{
            // fetching edit details
            $scope.isEdit=true;
            $scope.grnTablesList=[];
            var schList=[],schFnlList=[],schIndx=0;
            $http.get('app/grn/getGrnEditData?grnCode='+grnCode).success(function(data) {
                debugger;
                angular.forEach(data.editBeanData.grnTables, function(value,index){

                    $scope.grnTablesList[index] = value;
                    $scope.grnTablesList[index].dtlPrice = parseFloat(value.dtlPrice).toFixed(2);
                    $scope.grnTablesList[index].mrp = parseFloat(value.mrp).toFixed(2);

                });
                debugger;
                data.editBeanData.grnTables = $scope.grnTablesList;
                $scope.grnData = data.editBeanData;
                $scope.loadVendorAddress();
                $scope.getPODtlList(data.editBeanData.poId);

                if($scope.grnData.poType == "Rate Contract"){
                    $scope.isRate =true;
                    angular.forEach(data.editBeanData.grnTables, function(rowData, index) {
                        debugger;
                        angular.forEach(rowData.scheduleList, function(data, indexs) {
                            schList[indexs]= data;
                        });

                        angular.forEach(schList, function(data, indexs) {
                            schFnlList[schIndx]=data;
                            schIndx++;
                        });

                        $scope.batchListItem = rowData.batchDtls;
                    });

                }
                console.log(" Edit data :Dtl List::::::::::::::::::");
                console.log(schFnlList);
                $scope.rowCollectionDeliveryItem = schFnlList;
                $scope.grnData.schDtlList = schFnlList;
            }).error(function(data) {
            });

        }

        $scope.onChangeDecimal =function(id,num){
            debugger;
            num = num.replace(/[^0-9]/g, 0);
            var floatnum=parseFloat(Math.round(num * 100) / 100).toFixed(2);
            $('#'+id).val(floatnum);
            return floatnum;
        }

        $scope.onChangeNumber =function(id,num){
            debugger;
            num = num.replace(/[^0-9]/g, '');
            $('#'+id).val(num);
            return num;
        }

        $scope.getScheduleQty = function(schCollections,isChange){
            debugger;
            var item = schCollections.scheduleItemCode,
            qty = schCollections.scheduleItemQty;
            console.log("curSchQty :::::::::::::: "+curSchQty);
            console.log("isChange :::::::::::::: "+isChange);
            if(schCollections.select != undefined && schCollections.select != false){
                angular.forEach($scope.grnData.grnTables, function(rowData, index) {
                    debugger;
                    if(rowData.dtlItemCode == item ){
                        if(isChange == true)
                            rowData.dtlQty = parseInt(rowData.dtlQty)-parseInt(curSchQty)+parseInt(qty);
                        else
                            rowData.dtlQty = parseInt(rowData.dtlQty)+parseInt(qty);
                    }
                });
            }else{
                angular.forEach($scope.grnData.grnTables, function(rowData, index) {
                    debugger;
                    if(rowData.dtlItemCode == item ){
                        if(parseInt(rowData.dtlQty) >0 && isChange == false){
                            rowData.dtlQty = parseInt(rowData.dtlQty)-parseInt(qty);
                        }
                    }
                });
            }

            if(schCollections.scheduleItemQty > schCollections.schedulePendingQty){
                logger.logError("Receiving Qty should not Exceed Pending Qty...");
            }

        }

        var curSchQty =0;
        $scope.getCurrentQty = function(schCollections){
            debugger;
            curSchQty = schCollections.scheduleItemQty;
        }

    });

    module.registerController('poPopupCtrl', function($scope, $state, $http, $location, sharedProperties,toaster,
            $injector,logger,ngDialog,$rootScope,$controller) {

        $scope.addDtlRowValues = function(poCollection){
            $scope.finalList=[];
            angular.forEach(poCollection, function(row, index) {
                debugger;
                if(row.select != undefined && row.select != false){
                    $scope.finalList.push(row);
                }else{
                    //$scope.finalList =[];
                }
            });

            $rootScope.dtlList = $scope.finalList;
            ngDialog.close();
        }

    });

});