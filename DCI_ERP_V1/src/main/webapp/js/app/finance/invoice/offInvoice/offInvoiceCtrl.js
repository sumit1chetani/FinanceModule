'use strict';
app.controller('invoiceController', function($scope, $rootScope, $http, $location, logger, utilsService, $state, $window, ngDialog, $modal,$controller,$stateParams) {

    $scope.offsetCount = 0;
    $scope.limitCount = 100;
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.vesselList = [];
    $scope.customerList = [];
    $scope.voyageList = [];
    $scope.itemsByPage = 10;
    $scope.showEmptyLabel = false;
    $scope.invoiceViewHeader = {
        vesselid : '',
        vessel : '',
        voyageCode : '',
        quationNo : '',
        mloCode : '',
        invoiceNo : '',
        fromDate:'',
        toDate:''
    };
    
    $('#tb_fromDate').datetimepicker({
        format : 'DD/MM/YYYY'
    });
    
    $('#tb_toDate').datetimepicker({
        format : 'DD/MM/YYYY'
    });
    
    
    $scope.vesselObj = new Object();
    $scope.add = function() {
        $state.go('app.finance.invoice.invoiceadd',{tenantid:$stateParams.tenantid});
    }

    $scope.view = function(invoiceNo) {
        $state.go('app.finance.invoice.viewinvoice', ({
            'invoiceNo' : invoiceNo
        }),{tenantid:$stateParams.tenantid});
    }

    $scope.getTranslationListUtil = function() {
       
        var url = $stateParams.tenantid+'/app/offinvoice/list?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount;
        $http.get(url).success(function(data) {
            $scope.vesselList = data.vesselList;
            $scope.customerList = data.customerList;
            if (data.success == true && !utilsService.isUndefinedOrNull(data.invoiceBean)) {
                angular.forEach(data.invoiceBean, function(row, index) {
                    data.invoiceBean[index].printList = "both";

                });

                $scope.rowCollection = $scope.rowCollection.concat(data.invoiceBean);
            } else {
               // logger.logError("Error Please Try Again");
            }
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
    };

    $scope.getTranslationListUtil();
    $scope.formreset = function() {
        $scope.invoiceViewHeader= {
            vesselid : '',
            vessel : '',
            voyageCode : '',
            quationNo : '',
            mloCode : '',
            invoiceNo : '',
            fromDate:'',
            toDate:''
        };
   // alert("off invoice");
   // $scope.invoiceViewHeade= $scope.offInvoice;
    }
    $scope.$watch('invoiceViewHeader.vesselid', function(newValue, oldValue) {
        $scope.invoiceViewHeader.voyageCode = '';
        if ($scope.invoiceViewHeader.vesselid != '') {
            $scope.invoiceViewHeader.vessel = $scope.vesselObj.text;
            $http.post($stateParams.tenantid+'/app/offinvoice/getVoyage', $scope.invoiceViewHeader.vesselid).success(function(data) {
                $scope.voyageList = data.voyageNo;
            });
        } else {
            $scope.invoiceViewHeader.vessel = '';
        }
    })
    /**
     * Print Invoice On Entering Number
     */

    $scope.printInvoice = function(printinvoicevalue, selection, index) {
        if (utilsService.isUndefinedOrNull(selection)) {
            logger.logError("Please select Drop down");
        } else if (utilsService.isUndefinedOrNull(printinvoicevalue)) {
            logger.logError("Please Enter Invoice Number");
        } else {
            var url = $stateParams.tenantid+'/app/offinvoice/print?invoiceno=' + printinvoicevalue + '&selectedDropDown=' + selection;
            var wnd = window.open(url, 'Shipping', 'height=400,width=750,top=100,left=100,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
            wnd.print();

        }

    };

    /**
     * Print Invoice On Action
     */
    $scope.clickInvoiceFunction = function(printinvoicevalue, selection, index) {
        $scope.printInvoice(printinvoicevalue, selection, index);
    }

    /* E-mail */
    
    $scope.clickInvoiceMail = function(invoiceNo, selection) {
        ngDialog.close();
        ngDialog.open({
            template : 'invoiceMail',
            scope :$scope,
            controller: $controller('invoiceMailCtrl', {
                $scope: $scope,
                data: {"invoice":invoiceNo,"selection":selection}
               /* selectedDropDown:selection*/
            })
        });      
   };
   
   
    /*Delete Invoice*/
    
    $scope.deleteInvoice = function(invoiceNo) {
        ngDialog.close();
        ngDialog.open({
            template : 'invoiceDeleteModal',
            scope :$scope,
            controller: $controller('invoiceDeleteCtrl', {
                $scope: $scope,
                sInvoiceNo: invoiceNo
            })
        });      
   };
    
    /**
     * If needs only one value use this method in checkbox
     */
    $scope.selection = "";
    $scope.clickInvoice = function clickInvoice(printinvoicevalue) {
        var idx = $scope.selection.indexOf(printinvoicevalue);
        if (idx > -1) {
            $scope.selection = "";
        } else {
            $scope.selection = printinvoicevalue;
        }
        $scope.getFullinvoiveNo = $scope.selection;
    };

    $scope.printInvoiceAll = function printInvoiceAll() {

        var checking = $scope.getFullinvoiveNo;
        if (utilsService.isUndefinedOrNull(checking)) {
            logger.logError("Please Check Invoice ");
        } else {
            var url = $stateParams.tenantid+'/app/offinvoice/print?invoiceno=' + checking + '&';
            var wnd = window.open(url, 'Shipping', 'height=400,width=750,top=100,left=100,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
            wnd.print();
        }
    };

    $scope.searchInvoiceDtl = function() {
        $scope.rowCollection = [];
        $scope.invoiceViewHeader.fromDate = $('#fromDate').val();
        $scope.invoiceViewHeader.toDate = $('#toDate').val();
        console.log($scope.invoiceViewHeader);
        $http.post('app/offinvoice/searchInvoiceDtl', $scope.invoiceViewHeader).success(function(data) {
            if (data.success == true) {
                $scope.rowCollection = $scope.rowCollection.concat(data.invoiceBean);
                console.log($scope.rowCollection)
            } else {
                logger.logError("Error Please Try Again");
            }
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
    }
});

app.controller('invoiceMailCtrl', function($scope, $http,ngDialog,logger,data) {
    console.log(data.invoice);
    $scope.SendConfirm = function(){
        $http.get($stateParams.tenantid+'/app/offinvoice/sendMail?invoiceno=' + data.invoice + '&selectedDropDown=' + data.selection).success(function(data) {
            if (data == true) {
                logger.logSuccess("Mail Sent Successfully!");
                /*$scope.rowCollection = $scope.rowCollection.filter(function(obj) {
                    return obj.voucherNo !== sInvoiceNo;
                });*/
                ngDialog.close();
            }else{
                logger.logError("Unable to Delete");
                ngDialog.close();
            }
        }).error(function(data) {
            console.log("data" + data);
        });
       
    }
    
    $scope.closeDialog = function() {
        ngDialog.close();
     };
});


app.controller('invoiceDeleteCtrl', function($scope, $http,ngDialog,logger,sInvoiceNo) {
    console.log(sInvoiceNo);
    $scope.DeleteConfirm = function(){
        $http.get($stateParams.tenantid+'/app/offinvoice/delete?invoiceNo='+sInvoiceNo).success(function(data) {
            console.log(data.success);
            if (data.success == true) {
                logger.logSuccess("Deleted successfully!");
                $scope.rowCollection = $scope.rowCollection.filter(function(obj) {
                    console.log("GH");
                    console.log(obj);
                    return obj.invoiceNo !== sInvoiceNo;
                });
                ngDialog.close();
            }else{
                logger.logError("Unable to Delete");
                ngDialog.close();
            }
        }).error(function(data) {
            console.log("data" + data);
        });
       
    }
    
    $scope.closeDialog = function() {
        ngDialog.close();
     };
});



app.controller('invoiceViewController', function($stateParams, $scope, $rootScope, $http, $location, logger, utilsService, $state, $window) {

    $scope.viewInvoiceHeader = {
        accountHead : '',
        address1 : '',
        address2 : '',
        aedwords : '',
        agent : '',
        amountaed : '',
        amountusd : '',
        amttotal : '',
        blno : '',
        coBean : '',
        coBeanFlag : '',
        comapnyName : '',
        currency : '',
        customer : '',
        exchangeRate : '',
        faxno : '',
        footeraddr : '',
        footerfaxno : '',
        footermail : '',
        footerphno : '',
        invoiceDate : '',
        invoiceId : '',
        invoiceno : '',
        locationId : '',
        locationName : '',
        lpo : '',
        lpoFlag : '',
        officeName : '',
        officeTelephone : '',
        paymentCenter : '',
        phoneNo : '',
        pod : '',
        pol : '',
        portSeq : '',
        sailingdate : '',
        slNo : '',
        strTotalAED : '',
        strTotalUSD : '',
        surid : '',
        title : '',
        total : '',

    };

    $scope.invoiceViewObj = $stateParams;

    var invoiceNo = $scope.invoiceViewObj.invoiceNo;

    $http.get($stateParams.tenantid+'/app/offinvoice/view?invoiceNo=' + invoiceNo).success(function(data) {
        if (data.errors.length == 0) {

            $scope.viewInvoiceHeader = data.invoice;

        } else {
            logger.logError("Error Please Try Again");
        }
    });

});

app.controller('singleInvoiceViewController', function($stateParams, $scope, $rootScope, $http, $location, logger, utilsService, $state, $window) {
    $scope.viewInvoiceHeaderDtl = [ {
        slNo : '',
        accountHead : '',
        amountaed : '',
        amountusd : '',
    } ];
    $scope.offInvoiceDtl = [ {
        slNo : '',
        accountHead : '',
        amountaed : '',
        amountusd : '',
    } ];
    var invoiceNo = $stateParams.invoiceNo;

    $http.get($stateParams.tenantid+'/app/offinvoice/singleInvoiceViewNew?invoiceNo=' + invoiceNo).success(function(data) {
        console.log(data);
        if (data.errors.length == 0) {
            $scope.viewInvoiceHeader = data.invoice;
            $scope.viewInvoiceHeaderDtl = data.searchList;
            $scope.offInvoiceDtl=data.missingContainerList;
            $scope.viewInvoiceHeaderDtl[0].slNo = 0;
            angular.forEach($scope.viewInvoiceHeaderDtl, function(row, index) {
                $scope.viewInvoiceHeaderDtl[index].slNo = index + 1;
            });
            $scope.offInvoiceDtl[0].slNo = 0;
            angular.forEach($scope.offInvoiceDtl, function(row, index) {
                $scope.offInvoiceDtl[index].slNo = index + 1;
            });

        } else {
            logger.logError("Error Please Try Again");
        }
    });

    $scope.cancel = function() {
        $location.path($stateParams.tenantid+"/invoice/offinvoice");

    };
    
    $scope.printInvoice = function(printinvoicevalue, selection, index) {
        if (utilsService.isUndefinedOrNull(selection)) {
            logger.logError("Please select Drop down");
        } else if (utilsService.isUndefinedOrNull(printinvoicevalue)) {
            logger.logError("Please Enter Invoice Number");
        } else {
            console.log("Invoice view Print");
            var url = $stateParams.tenantid+'/app/offinvoice/print?invoiceno=' + printinvoicevalue + '&selectedDropDown=' + selection;
            var wnd = window.open(url, 'Shipping', 'height=400,width=750,top=100,left=100,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
            wnd.print();
        }

    };

    /**
     * Print Invoice On Action
     */
    $scope.clickInvoiceFunction = function(printinvoicevalue, selection, index) {
        console.log(printinvoicevalue);
        $scope.printInvoice(printinvoicevalue, selection, index);
    }

});
