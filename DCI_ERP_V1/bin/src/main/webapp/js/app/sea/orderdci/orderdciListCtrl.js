
'use strict';

app.controller('orderdciListCtrl', function($scope, $rootScope,ngDialog, $http, $location, logger,
        utilsService,$state,sharedProperties,$window,validationService,toaster,$stateParams) {
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages = 0;
        $scope.isUpload=true;
        $scope.isDelete=true;
        $scope.rowCollection = [];
        $scope.statusList=[];
        $scope.itemList = [];
        $scope.vendorList = [];
        $scope.add = function(){
            $state.go("app.sea.orderdci.add");
        };
       
        $scope.getPurchaseOrderList = function(){
            debugger
            var url = 'app/purchaseOrder/purchaseList?purchaseType='+43+'&formCode='+$('#form_code_id').val();
            $http.get(url).success(function(data) {
                if (data.success == true) {
                    $scope.rowCollection = data.purchaseOrders;
                    console.log("data.purchaseOrders List :::::::::::::::::");
                    console.log(data.purchaseOrders);
//                    $scope.poAmendmentLog($scope.rowCollection);
                 }
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        };
        $scope.getPurchaseOrderList();
        
        $scope.getListOfDropdowns = function() {
            $http.get('app/purchaseOrder/filterDropDownList').success(function(data) {
                if (data.success == true) {
                    $scope.itemList=data.itemList;
                    $scope.vendorList = data.vendorList;
                    $scope.statusList= data.purchaseStatus;
                }
            });
        };
        $scope.getListOfDropdowns();
        
        $scope.editRow =function(collections){
            $location.url('/master/orderdci/add?purchaseOrderId='+collections.purchaseOrderId);
           
        };
        
        $scope.deleteRow=function(collections){
            ngDialog.openConfirm().then(function() { 
            var url='app/purchaseOrder/deletePurchaseOrder?purchaseOrderId='+collections.purchaseOrderId;
            $http.get(url).success(function(success){
                if(success){
                    logger.logSuccess("Purchase Order deleted successfully");
                    $scope.getPurchaseOrderList();
                }else{
                    logger.logError("Error Please Try Again");
                }
            }).error(function(data) {
                logger.logSuccess("Error in Delete!");
            });
            }, function(reason) {
                console.log('Modal promise rejected. Reason: ', reason);
            });
        };
        $scope.viewRow = function(collections){
            $location.url('/master/orderdci/view?purchaseOrderId='+collections.purchaseOrderId); 
//            $location.url('/hospital/purchase/purchaseOrder/Edit?purchaseOrderId='+collections.purchaseOrderId); 

        };
       $scope.printRow = function(collections){
           var url='app/purchaseOrder/exportPurchaseOrderPdf?purchaseOrderId='+collections.purchaseOrderId;
           $http.get(url).success(function(data){
               if(data.success){
                   $window.open('tempdoc/Purchase_Order.pdf','Title','width=500,height=700');
               }else{
                   logger.logError("Error Please Try Again");
               }
           }).error(function(data) {
               logger.logSuccess("Error in Delete!");
           }); 
       } 

       $scope.printPDF = function(collections){       
           var url = 'app/purchaseOrder/printPurchaseOrderPDF?purchaseOrderId=' +collections.purchaseOrderId;
           var wnd = $window.open(url, 'Omega School', 'height=400,width=750,top=100,left=100,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
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
      
       $scope.printRowforcurrecny = function(collections){
           var url='app/purchaseOrder/exportPurchaseOrderPdf?purchaseOrderId='+collections.purchaseOrderId;
           $http.get(url).success(function(data){
               if(data.success){
                   $window.open('tempdoc/Purchase_Order.pdf','Title','width=500,height=700');
               }else{
                   logger.logError("Error Please Try Again");
               }
           }).error(function(data) {
               logger.logSuccess("Error in Delete!");
           }); 
       } 
       $scope.poAmendmentLog = function(PoNo,PoANo){
//           if(PoNo)
           if (PoNo != undefined) {
               var editUrl = 'app/purchaseOrder/editPurchaseOrderLog';
               $http({
                   url : editUrl,
                   params : {
                       "purchaseOrderNumber" : PoNo
                   },
                   method : "GET",
                   datatype : 'JSON',
                   'Accept' : 'application/json',
                   headers : {
                       'Content-Type' : 'application/json'
                   }

               }).success(function(data) {

                   $scope.purchaseOrdeList = data;
                  if($scope.purchaseOrdeList != "" &&$scope.purchaseOrdeList != "" &&  $scope.purchaseOrdeList != undefined &&
                           $scope.purchaseOrdeAmendmentList != null && $scope.purchaseOrdeAmendmentList != "" && $scope.purchaseOrdeAmendmentList != undefined)
                   $scope.compareLogValue($scope.purchaseOrdeList,$scope.purchaseOrdeAmendmentList);
                  
                   

               });
           }
           if (PoANo != undefined) {
               var editUrl = 'app/purchaseOrder/editPurchaseOrderLog';
               $http({
                   url : editUrl,
                   params : {
                       "purchaseOrderNumber" : PoANo
                   },
                   method : "GET",
                   datatype : 'JSON',
                   'Accept' : 'application/json',
                   headers : {
                       'Content-Type' : 'application/json'
                   }

               }).success(function(data) {
                   $scope.purchaseOrdeAmendmentList = data;                                  
                   if($scope.purchaseOrdeList != "" &&$scope.purchaseOrdeList != "" && $scope.purchaseOrdeList != undefined &&
                           $scope.purchaseOrdeAmendmentList != null && $scope.purchaseOrdeAmendmentList != ""  && $scope.purchaseOrdeAmendmentList != undefined )
                   $scope.compareLogValue($scope.purchaseOrdeList,$scope.purchaseOrdeAmendmentList);                   

               });
           }
        };
       
    
       $scope.compareLogValue = function(POdata,POAdata){
           
           $scope.callDialog($scope, 0, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope,POdata,POAdata);

                      
       }
       $scope.callDialog = function($scope, requestCode, $http, ngDialog, logger, 
               $injector, sharedProperties, toaster, $rootScope,POdata,POAdata) {
           requestCode = angular.copy($scope.vendor, requestCode);
           ngDialog.open({
               scope : $scope,
               template : 'views/master/orderdci/purchaseOrderLog',
               controller : $controller('LogCtrl', {
                   $scope : $scope,
                   requestCode : requestCode,
                   $http : $http,
                   ngDialog : ngDialog,
                   logger : logger,
                   $injector : $injector,
                   sharedProperties : sharedProperties,
                   toaster : toaster,
                   $rootScope : $rootScope,
                   POdata : POdata,
                   POAdata : POAdata
                   
               }),
               className : 'ngdialog-theme-plain',
               showClose : false,
               closeByDocument : false,
               closeByEscape : false,
               preCloseCallback : $scope.getList
           });
       };
       
//       Export Excel

       $scope.exportExcel = function(){    
         

           $scope.po = {
                   purchaseType :43
           }
           
           
               $http.post('app/purchaseOrder/exportExcel',$scope.po).success(function(data) {
                   if(data){
                       debugger;
                       $("#purOrder").bind('click', function() {
                       });
                       $('#purOrder').simulateClick('click');
                       logger.logSuccess("Exported successfully!");
                   }else{
                       logger.logError("Failed to export");
                   }
                   
               }).error(function(data) {
                   logger.logError("Error Please Try Again");
               });
        
       
       }

       $.fn.simulateClick = function() {
           return this.each(function() {
               if ('createEvent' in document) {
                   var doc = this.ownerDocument, evt = doc.createEvent('MouseEvents');
                   evt.initMouseEvent('click', true, true, doc.defaultView, 1, 0, 0, 0, 0, false, false, false, false, 0, null);
                   this.dispatchEvent(evt);
               } else {
                   this.click(); // IE
               }
           });
       }
       
//       END
       
       
    });

    app.controller('LogCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, 
            $injector, sharedProperties, toaster, $rootScope,$window,POdata,POAdata) {
//        alert(5);
//        var POdata1 =POdata;
        $scope.rowCollectionItem = [];
        $scope.rowCollectionItemA = [];
        $scope.back = function(){
            $scope.rowCollectionItem = [];
            $scope.rowCollectionItemA = [];
           ngDialog.close();
        }
        $scope.POvalues = POdata;
        $scope.POAvalues = POAdata;
$scope.rowCollectionItem = POAdata.purchaseQuoteDetails;
$scope.rowCollectionItemA = POdata.purchaseQuoteDetails;

$scope.calculateTaxDiscount = function(rowCollection) {
    var disc = 0;
    rowCollection.price = Number(Number(rowCollection.quantity) * rowCollection.unitPrice).toFixed(2);
    if (rowCollection.quoteTaxDetail.discountType == "Percentage") {
        rowCollection.quoteTaxDetail.discountType = "Percentage";

        disc = (rowCollection.price * (rowCollection.quoteTaxDetail.dicountPercentage / 100));
 
    } else if (rowCollection.quoteTaxDetail.discountType == "Amount") {
        rowCollection.quoteTaxDetail.discountType = "Amount";
        disc = rowCollection.quoteTaxDetail.discountAmount;
        // rowCollection['discount'] = rowCollection.discount;
    } else {
        rowCollection.quoteTaxDetail.discountType = "";
    }

    rowCollection['finalTotal'] = 0;
    rowCollection['total'] = 0;

    if (rowCollection.price >= disc) {
        rowCollection['total'] = Number(Number(rowCollection.price) - Number(disc)).toFixed(2);
        rowCollection['finalTotal'] = 0;
    } else if (rowCollection.price < disc) {
        rowCollection['total'] = Number(Number(rowCollection.price) - Number(disc)).toFixed(2);
        rowCollection['finalTotal'] = 0;
    }else{
        rowCollection['total'] =Number(rowCollection.price);
         
    }

    rowCollection['discount'] = Number(disc).toFixed(2);


    rowCollection['finalTotal'] = (Number(rowCollection.total) + Number(rowCollection.quoteTaxDetail.taxCGST) + Number(rowCollection.quoteTaxDetail.taxSGST) + Number(rowCollection.quoteTaxDetail.taxIGST)).toFixed(2);

};
$scope.calculateTaxDiscount1 = function(rowCollection) {
    var disc = "";
    rowCollection.price = Number(Number(rowCollection.quantity) * rowCollection.unitPrice).toFixed(2);

    if (rowCollection.quoteTaxDetail.discountType == "Percentage") {
        rowCollection.quoteTaxDetail.discountType = "Percentage";

        disc = (rowCollection.price * (rowCollection.quoteTaxDetail.dicountPercentage / 100));
 
    } else if (rowCollection.quoteTaxDetail.discountType == "Amount") {
        rowCollection.quoteTaxDetail.discountType = "Amount";
        disc = rowCollection.quoteTaxDetail.discountAmount;
        // rowCollection['discount'] = rowCollection.discount;
    } else {
        rowCollection.quoteTaxDetail.discountType = "";
    }

    rowCollection['finalTotal'] = 0;
    rowCollection['total'] = 0;

    if (rowCollection.price >= disc) {
        rowCollection['total'] = Number(Number(rowCollection.price) - Number(disc)).toFixed(2);
        rowCollection['finalTotal'] = 0;
    } else if (rowCollection.price < disc) {
        rowCollection['total'] = Number(Number(rowCollection.price) - Number(disc)).toFixed(2);
        rowCollection['finalTotal'] = 0;
    }else{
        rowCollection['total'] = Number(rowCollection.price);
        
    }

    rowCollection['discount'] = Number(disc).toFixed(2);


    rowCollection['finalTotal'] = (Number(rowCollection.total) + Number(rowCollection.quoteTaxDetail.taxCGST) + Number(rowCollection.quoteTaxDetail.taxSGST) + Number(rowCollection.quoteTaxDetail.taxIGST)).toFixed(2);

};
    
    });
    app.controller('parentCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {

        $scope.validateQty = function(quantity) {
            if (quantity <= 0) {
                logger.logError("Quantity Should be Greater than 0!");
                $scope.rowCollectionItem[$scope.$index].quantity = '';
            }
        };
    });

 
