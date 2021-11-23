'use strict';
app.controller('invoiceInformationController', function($templateCache, $scope, $rootScope, $http, logger, $log, ngDialog, $injector,
        sharedProperties, toaster,$modal, $location, $sce, $filter, $timeout,utilsService,$compile,$controller,$stateParams) {

    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.creditNoteList = [];
    $scope.debitNoteList = [];
    $scope.invoiceList = [];
    $scope.generalInvoiceList = [];
    $scope.voucherList = [];
    $scope.voucherAllList = [];
    
    $scope.detailList = [];
    $scope.invoiceTrue = false;
    $scope.generalInvoiceTrue = false;
    $scope.creditTable = false;
    $scope.debitTable = false;
    $scope.invoiceTable = false;
    $scope.generalInvoiceTable = false;
    $scope.voucherTable = false;
    $scope.journalVoucherTable = false;
    $scope.purchaseInvoiceTable = false;
    $scope.paymentOrderTable = false;
    $scope.paymentTable = false;
    $scope.receiptTable = false;
    
    $scope.invoiceInformation = {
            creditNote : '',
            debitNote : '',
            invoice : '',
            generalInvoice : '',
            voucher : '',
            generalVoucher : '',
            purchaseInvoice : '',
            paymentOrder : '',
            payment : '',
            receipt : ''
    };
    var temp = angular.copy($scope.invoiceInformation);

    $http.get($stateParams.tenantid+'/app/reports/invoiceInformation/getValues').success(function(data) {
        $scope.creditNoteList = data.creditNote;
        $scope.debitNoteList = data.debitNote;
        $scope.invoiceList = data.invoiceList;
        $scope.generalInvoiceList = data.generalInvoiceList;
        $scope.voucherList = data.voucherList;
        $scope.voucherAllList = data.voucherAllList;
    });
    
    var type = "";
    var value = "";
    $scope.viewinvoiceInformationReport = function(invoiceInformation){
        if(($scope.invoiceInformation.creditNote == '' || $scope.invoiceInformation.creditNote == null || $scope.invoiceInformation.creditNote == undefined)&&
                ($scope.invoiceInformation.debitNote == '' || $scope.invoiceInformation.debitNote == null || $scope.invoiceInformation.debitNote == undefined)&&
                ($scope.invoiceInformation.invoice == '' || $scope.invoiceInformation.invoice == null || $scope.invoiceInformation.invoice == undefined)&&
                ($scope.invoiceInformation.generalInvoice == '' || $scope.invoiceInformation.generalInvoice == null || $scope.invoiceInformation.generalInvoice == undefined)&&
                ($scope.invoiceInformation.voucher == '' || $scope.invoiceInformation.voucher == null || $scope.invoiceInformation.voucher == undefined)&&
                ($scope.invoiceInformation.generalVoucher == '' || $scope.invoiceInformation.generalVoucher == null || $scope.invoiceInformation.generalVoucher == undefined)&&
                ($scope.invoiceInformation.purchaseInvoice == '' || $scope.invoiceInformation.purchaseInvoice == null || $scope.invoiceInformation.purchaseInvoice == undefined)&&
                ($scope.invoiceInformation.paymentOrder == '' || $scope.invoiceInformation.paymentOrder == null || $scope.invoiceInformation.paymentOrder == undefined)&&
                ($scope.invoiceInformation.payment == '' || $scope.invoiceInformation.payment == null || $scope.invoiceInformation.payment == undefined)&&
                ($scope.invoiceInformation.receipt == '' || $scope.invoiceInformation.receipt == null || $scope.invoiceInformation.receipt == undefined))
            logger.logError("Please select any one");
        else{
            if($scope.invoiceInformation.creditNote != '' && $scope.invoiceInformation.creditNote != null && $scope.invoiceInformation.creditNote != undefined){
                if(($scope.invoiceInformation.debitNote != "" && $scope.invoiceInformation.debitNote != null && $scope.invoiceInformation.debitNote != undefined)||
                        ($scope.invoiceInformation.invoice != "" && $scope.invoiceInformation.invoice != null && $scope.invoiceInformation.invoice != undefined)||
                        ($scope.invoiceInformation.generalInvoice != "" && $scope.invoiceInformation.generalInvoice != null && $scope.invoiceInformation.generalInvoice != undefined)||
                        ($scope.invoiceInformation.voucher != "" && $scope.invoiceInformation.voucher != null && $scope.invoiceInformation.voucher != undefined)||
                        ($scope.invoiceInformation.generalVoucher != "" && $scope.invoiceInformation.generalVoucher != null && $scope.invoiceInformation.generalVoucher != undefined)||
                        ($scope.invoiceInformation.purchaseInvoice != "" && $scope.invoiceInformation.purchaseInvoice != null && $scope.invoiceInformation.purchaseInvoice != undefined)||
                        ($scope.invoiceInformation.paymentOrder != "" && $scope.invoiceInformation.paymentOrder != null && $scope.invoiceInformation.paymentOrder != undefined)||
                        ($scope.invoiceInformation.payment != "" && $scope.invoiceInformation.payment != null && $scope.invoiceInformation.payment != undefined)||
                        ($scope.invoiceInformation.receipt != "" && $scope.invoiceInformation.receipt != null && $scope.invoiceInformation.receipt != undefined)){
                    logger.logError("Please select any one");
                }
                else{
                    value = $scope.invoiceInformation.creditNote;
                    type = "C";
                    $scope.detailsList(invoiceInformation);
                }
                    
            }
            else if($scope.invoiceInformation.debitNote != '' && $scope.invoiceInformation.debitNote != null || $scope.invoiceInformation.debitNote && undefined){
                if(($scope.invoiceInformation.creditNote != '' && $scope.invoiceInformation.creditNote != null && $scope.invoiceInformation.creditNote != undefined)||
                        ($scope.invoiceInformation.invoice != '' && $scope.invoiceInformation.invoice != null && $scope.invoiceInformation.invoice != undefined)||
                        ($scope.invoiceInformation.generalInvoice != '' && $scope.invoiceInformation.generalInvoice != null && $scope.invoiceInformation.generalInvoice != undefined)||
                        ($scope.invoiceInformation.voucher != '' && $scope.invoiceInformation.voucher != null && $scope.invoiceInformation.voucher != undefined)||
                        ($scope.invoiceInformation.generalVoucher != '' && $scope.invoiceInformation.generalVoucher != null && $scope.invoiceInformation.generalVoucher != undefined)||
                        ($scope.invoiceInformation.purchaseInvoice != "" && $scope.invoiceInformation.purchaseInvoice != null && $scope.invoiceInformation.purchaseInvoice != undefined)||
                        ($scope.invoiceInformation.paymentOrder != "" && $scope.invoiceInformation.paymentOrder != null && $scope.invoiceInformation.paymentOrder != undefined)||
                        ($scope.invoiceInformation.payment != "" && $scope.invoiceInformation.payment != null && $scope.invoiceInformation.payment != undefined)||
                        ($scope.invoiceInformation.receipt != "" && $scope.invoiceInformation.receipt != null && $scope.invoiceInformation.receipt != undefined)){
                    logger.logError("Please select any one");
                }else{
                    value = $scope.invoiceInformation.debitNote;
                    type = "D";
                    $scope.detailsList(invoiceInformation);
                }
            }
            else if($scope.invoiceInformation.invoice != '' && $scope.invoiceInformation.invoice != null && $scope.invoiceInformation.invoice != undefined){
                if(($scope.invoiceInformation.debitNote != '' && $scope.invoiceInformation.debitNote != null && $scope.invoiceInformation.debitNote != undefined)||
                        ($scope.invoiceInformation.creditNote != '' && $scope.invoiceInformation.creditNote != null && $scope.invoiceInformation.creditNote != undefined)||
                        ($scope.invoiceInformation.generalInvoice != '' && $scope.invoiceInformation.generalInvoice != null && $scope.invoiceInformation.generalInvoice != undefined)||
                        ($scope.invoiceInformation.voucher != '' && $scope.invoiceInformation.voucher != null && $scope.invoiceInformation.voucher != undefined)||
                        ($scope.invoiceInformation.generalVoucher != '' && $scope.invoiceInformation.generalVoucher != null && $scope.invoiceInformation.generalVoucher != undefined)||
                        ($scope.invoiceInformation.purchaseInvoice != "" && $scope.invoiceInformation.purchaseInvoice != null && $scope.invoiceInformation.purchaseInvoice != undefined)||
                        ($scope.invoiceInformation.paymentOrder != "" && $scope.invoiceInformation.paymentOrder != null && $scope.invoiceInformation.paymentOrder != undefined)||
                        ($scope.invoiceInformation.payment != "" && $scope.invoiceInformation.payment != null && $scope.invoiceInformation.payment != undefined)||
                        ($scope.invoiceInformation.receipt != "" && $scope.invoiceInformation.receipt != null && $scope.invoiceInformation.receipt != undefined)){
                    logger.logError("Please select any one");
                }else{
                    value = $scope.invoiceInformation.invoice;
                    type = "I";
                    $scope.detailsList(invoiceInformation);
                }
            }
            else if($scope.invoiceInformation.generalInvoice != '' && $scope.invoiceInformation.generalInvoice != null && $scope.invoiceInformation.generalInvoice != undefined){
                if(($scope.invoiceInformation.debitNote == '' && $scope.invoiceInformation.debitNote == null && $scope.invoiceInformation.debitNote == undefined)||
                        ($scope.invoiceInformation.invoice == '' && $scope.invoiceInformation.invoice == null && $scope.invoiceInformation.invoice == undefined)||
                        ($scope.invoiceInformation.creditNote == '' && $scope.invoiceInformation.creditNote == null && $scope.invoiceInformation.creditNote == undefined)||
                        ($scope.invoiceInformation.voucher == '' && $scope.invoiceInformation.voucher == null && $scope.invoiceInformation.voucher == undefined)||
                        ($scope.invoiceInformation.generalVoucher == '' && $scope.invoiceInformation.generalVoucher == null && $scope.invoiceInformation.generalVoucher == undefined)||
                        ($scope.invoiceInformation.purchaseInvoice != "" && $scope.invoiceInformation.purchaseInvoice != null && $scope.invoiceInformation.purchaseInvoice != undefined)||
                        ($scope.invoiceInformation.paymentOrder != "" && $scope.invoiceInformation.paymentOrder != null && $scope.invoiceInformation.paymentOrder != undefined)||
                        ($scope.invoiceInformation.payment != "" && $scope.invoiceInformation.payment != null && $scope.invoiceInformation.payment != undefined)||
                        ($scope.invoiceInformation.receipt != "" && $scope.invoiceInformation.receipt != null && $scope.invoiceInformation.receipt != undefined)){
                    logger.logError("Please select any one");
                }else{
                    value = $scope.invoiceInformation.generalInvoice;
                    type = "G";
                    $scope.detailsList(invoiceInformation);
                }
            }
            else if($scope.invoiceInformation.voucher != '' && $scope.invoiceInformation.voucher != null && $scope.invoiceInformation.voucher != undefined){
                if(($scope.invoiceInformation.debitNote != '' && $scope.invoiceInformation.debitNote != null && $scope.invoiceInformation.debitNote != undefined)||
                        ($scope.invoiceInformation.invoice != '' && $scope.invoiceInformation.invoice != null && $scope.invoiceInformation.invoice != undefined)||
                        ($scope.invoiceInformation.generalInvoice != '' && $scope.invoiceInformation.generalInvoice != null && $scope.invoiceInformation.generalInvoice != undefined)||
                        ($scope.invoiceInformation.creditNote != '' && $scope.invoiceInformation.creditNote != null && $scope.invoiceInformation.creditNote != undefined)||
                        ($scope.invoiceInformation.generalVoucher != '' && $scope.invoiceInformation.generalVoucher != null && $scope.invoiceInformation.generalVoucher != undefined)||
                        ($scope.invoiceInformation.purchaseInvoice != "" && $scope.invoiceInformation.purchaseInvoice != null && $scope.invoiceInformation.purchaseInvoice != undefined)||
                        ($scope.invoiceInformation.paymentOrder != "" && $scope.invoiceInformation.paymentOrder != null && $scope.invoiceInformation.paymentOrder != undefined)||
                        ($scope.invoiceInformation.payment != "" && $scope.invoiceInformation.payment != null && $scope.invoiceInformation.payment != undefined)||
                        ($scope.invoiceInformation.receipt != "" && $scope.invoiceInformation.receipt != null && $scope.invoiceInformation.receipt != undefined)){
                    logger.logError("Please select any one");
                }else{
                    value = $scope.invoiceInformation.voucher;
                    type = "V";
                    $scope.detailsList(invoiceInformation);
                }
            }
            else if($scope.invoiceInformation.generalVoucher != '' && $scope.invoiceInformation.generalVoucher != null && $scope.invoiceInformation.generalVoucher != undefined){
                if(($scope.invoiceInformation.debitNote != '' && $scope.invoiceInformation.debitNote != null && $scope.invoiceInformation.debitNote != undefined)||
                        ($scope.invoiceInformation.invoice != '' && $scope.invoiceInformation.invoice != null && $scope.invoiceInformation.invoice != undefined)||
                        ($scope.invoiceInformation.generalInvoice != '' && $scope.invoiceInformation.generalInvoice != null && $scope.invoiceInformation.generalInvoice != undefined)||
                        ($scope.invoiceInformation.voucher != '' && $scope.invoiceInformation.voucher != null && $scope.invoiceInformation.voucher != undefined)||
                        ($scope.invoiceInformation.creditNote != '' && $scope.invoiceInformation.creditNote != null && $scope.invoiceInformation.creditNote != undefined)||
                        ($scope.invoiceInformation.purchaseInvoice != "" && $scope.invoiceInformation.purchaseInvoice != null && $scope.invoiceInformation.purchaseInvoice != undefined)||
                        ($scope.invoiceInformation.paymentOrder != "" && $scope.invoiceInformation.paymentOrder != null && $scope.invoiceInformation.paymentOrder != undefined)||
                        ($scope.invoiceInformation.payment != "" && $scope.invoiceInformation.payment != null && $scope.invoiceInformation.payment != undefined)||
                        ($scope.invoiceInformation.receipt != "" && $scope.invoiceInformation.receipt != null && $scope.invoiceInformation.receipt != undefined)){
                    logger.logError("Please select any one");
                }else{
                    value = $scope.invoiceInformation.generalVoucher;
                    type = "J";
                    $scope.detailsList(invoiceInformation);
                }
            }
            else if($scope.invoiceInformation.purchaseInvoice != '' && $scope.invoiceInformation.purchaseInvoice != null && $scope.invoiceInformation.purchaseInvoice != undefined){
                if(($scope.invoiceInformation.debitNote != '' && $scope.invoiceInformation.debitNote != null && $scope.invoiceInformation.debitNote != undefined)||
                        ($scope.invoiceInformation.invoice != '' && $scope.invoiceInformation.invoice != null && $scope.invoiceInformation.invoice != undefined)||
                        ($scope.invoiceInformation.generalInvoice != '' && $scope.invoiceInformation.generalInvoice != null && $scope.invoiceInformation.generalInvoice != undefined)||
                        ($scope.invoiceInformation.voucher != '' && $scope.invoiceInformation.voucher != null && $scope.invoiceInformation.voucher != undefined)||
                        ($scope.invoiceInformation.creditNote != '' && $scope.invoiceInformation.creditNote != null && $scope.invoiceInformation.creditNote != undefined)||
                        ($scope.invoiceInformation.generalVoucher != '' && $scope.invoiceInformation.generalVoucher != null && $scope.invoiceInformation.generalVoucher != undefined)||
                        ($scope.invoiceInformation.paymentOrder != '' && $scope.invoiceInformation.paymentOrder != null && $scope.invoiceInformation.paymentOrder != undefined)||
                        ($scope.invoiceInformation.payment != '' && $scope.invoiceInformation.payment != null && $scope.invoiceInformation.payment != undefined)||
                        ($scope.invoiceInformation.receipt != '' && $scope.invoiceInformation.receipt != null && $scope.invoiceInformation.receipt != undefined)){
                    logger.logError("Please select any one");
                }else{
                    value = $scope.invoiceInformation.purchaseInvoice;
                    type = "PI";
                    $scope.detailsList(invoiceInformation);
                }
            }
            else if($scope.invoiceInformation.paymentOrder != '' && $scope.invoiceInformation.paymentOrder != null && $scope.invoiceInformation.paymentOrder != undefined){
                if(($scope.invoiceInformation.debitNote != '' && $scope.invoiceInformation.debitNote != null && $scope.invoiceInformation.debitNote != undefined)||
                        ($scope.invoiceInformation.invoice != '' && $scope.invoiceInformation.invoice != null && $scope.invoiceInformation.invoice != undefined)||
                        ($scope.invoiceInformation.generalInvoice != '' && $scope.invoiceInformation.generalInvoice != null && $scope.invoiceInformation.generalInvoice != undefined)||
                        ($scope.invoiceInformation.voucher != '' && $scope.invoiceInformation.voucher != null && $scope.invoiceInformation.voucher != undefined)||
                        ($scope.invoiceInformation.creditNote != '' && $scope.invoiceInformation.creditNote != null && $scope.invoiceInformation.creditNote != undefined)||
                        ($scope.invoiceInformation.generalVoucher != '' && $scope.invoiceInformation.generalVoucher != null && $scope.invoiceInformation.generalVoucher != undefined)||
                        ($scope.invoiceInformation.purchaseInvoice != '' && $scope.invoiceInformation.purchaseInvoice != null && $scope.invoiceInformation.purchaseInvoice != undefined)||
                        ($scope.invoiceInformation.payment != '' && $scope.invoiceInformation.payment != null && $scope.invoiceInformation.payment != undefined)||
                        ($scope.invoiceInformation.receipt != '' && $scope.invoiceInformation.receipt != null && $scope.invoiceInformation.receipt != undefined)){
                    logger.logError("Please select any one");
                }else{
                    value = $scope.invoiceInformation.paymentOrder;
                    type = "PO";
                    $scope.detailsList(invoiceInformation);
                }
            }
            else if($scope.invoiceInformation.payment != '' && $scope.invoiceInformation.payment != null && $scope.invoiceInformation.payment != undefined){
                if(($scope.invoiceInformation.debitNote != '' && $scope.invoiceInformation.debitNote != null && $scope.invoiceInformation.debitNote != undefined)||
                        ($scope.invoiceInformation.invoice != '' && $scope.invoiceInformation.invoice != null && $scope.invoiceInformation.invoice != undefined)||
                        ($scope.invoiceInformation.generalInvoice != '' && $scope.invoiceInformation.generalInvoice != null && $scope.invoiceInformation.generalInvoice != undefined)||
                        ($scope.invoiceInformation.voucher != '' && $scope.invoiceInformation.voucher != null && $scope.invoiceInformation.voucher != undefined)||
                        ($scope.invoiceInformation.creditNote != '' && $scope.invoiceInformation.creditNote != null && $scope.invoiceInformation.creditNote != undefined)||
                        ($scope.invoiceInformation.generalVoucher != '' && $scope.invoiceInformation.generalVoucher != null && $scope.invoiceInformation.generalVoucher != undefined)||
                        ($scope.invoiceInformation.purchaseInvoice != '' && $scope.invoiceInformation.purchaseInvoice != null && $scope.invoiceInformation.purchaseInvoice != undefined)||
                        ($scope.invoiceInformation.paymentOrder != '' && $scope.invoiceInformation.paymentOrder != null && $scope.invoiceInformation.paymentOrder != undefined)||
                        ($scope.invoiceInformation.receipt != '' && $scope.invoiceInformation.receipt != null && $scope.invoiceInformation.receipt != undefined)){
                    logger.logError("Please select any one");
                }else{
                    value = $scope.invoiceInformation.payment;
                    type = "P";
                    $scope.detailsList(invoiceInformation);
                }
            }
            else if($scope.invoiceInformation.receipt != '' && $scope.invoiceInformation.receipt != null && $scope.invoiceInformation.receipt != undefined){
                if(($scope.invoiceInformation.debitNote != '' && $scope.invoiceInformation.debitNote != null && $scope.invoiceInformation.debitNote != undefined)||
                        ($scope.invoiceInformation.invoice != '' && $scope.invoiceInformation.invoice != null && $scope.invoiceInformation.invoice != undefined)||
                        ($scope.invoiceInformation.generalInvoice != '' && $scope.invoiceInformation.generalInvoice != null && $scope.invoiceInformation.generalInvoice != undefined)||
                        ($scope.invoiceInformation.voucher != '' && $scope.invoiceInformation.voucher != null && $scope.invoiceInformation.voucher != undefined)||
                        ($scope.invoiceInformation.creditNote != '' && $scope.invoiceInformation.creditNote != null && $scope.invoiceInformation.creditNote != undefined)||
                        ($scope.invoiceInformation.generalVoucher != '' && $scope.invoiceInformation.generalVoucher != null && $scope.invoiceInformation.generalVoucher != undefined)||
                        ($scope.invoiceInformation.purchaseInvoice != '' && $scope.invoiceInformation.purchaseInvoice != null && $scope.invoiceInformation.purchaseInvoice != undefined)||
                        ($scope.invoiceInformation.paymentOrder != '' && $scope.invoiceInformation.paymentOrder != null && $scope.invoiceInformation.paymentOrder != undefined)||
                        ($scope.invoiceInformation.payment != '' && $scope.invoiceInformation.payment != null && $scope.invoiceInformation.payment != undefined)){
                    logger.logError("Please select any one");
                }else{
                    value = $scope.invoiceInformation.receipt;
                    type = "R";
                    $scope.detailsList(invoiceInformation);
                }
            }
        }
    };
    
    
    $scope.detailsList = function(invoiceInformation){
        $http.get($stateParams.tenantid+'/app/reports/invoiceInformation/getValues?value=' + value + '&type=' + type).success(function(data){
            if(data.success){
                if(data.result != 0){
                     $http.post($stateParams.tenantid+'/app/reports/invoiceInformation/getList', $scope.invoiceInformation).success(function(data) {
                     if(data.success){
                        console.log("&&&&&&&&&&&&&&&&&&&&&")
                        console.log(data)
                        if($scope.invoiceInformation.creditNote != '' && $scope.invoiceInformation.creditNote != null && $scope.invoiceInformation.creditNote != undefined){
                            $scope.detailList = data.creditOrDebitList;
                            if($scope.detailList == null || $scope.detailList.length == 0){
                                logger.logError("No Records Found");
                            }else{
                                $scope.invoiceTable = false;
                                $scope.generalInvoiceTable = false;
                                $scope.creditTable = true;
                                $scope.debitTable = false;
                                $scope.voucherTable = false;
                                $scope.journalVoucherTable = false;
                            }
                        }
                        if($scope.invoiceInformation.debitNote != '' && $scope.invoiceInformation.debitNote != null || $scope.invoiceInformation.debitNote && undefined){
                            $scope.detailList = data.creditOrDebitList;
                            if($scope.detailList == null || $scope.detailList.length == 0){
                                logger.logError("No Records Found");
                            }else{
                                $scope.creditTable = false;
                                $scope.debitTable = true;
                                $scope.invoiceTable = false;
                                $scope.generalInvoiceTable = false;
                                $scope.voucherTable = false;
                                $scope.journalVoucherTable = false;
                            }
                        }
                        if($scope.invoiceInformation.invoice != '' && $scope.invoiceInformation.invoice != null || $scope.invoiceInformation.invoice && undefined){
                            $scope.detailList = data.invoiceOrGeneralList;
                            if($scope.detailList == null || $scope.detailList.length == 0){
                                logger.logError("No Records Found");
                            }else{
                                $scope.creditTable = false;
                                $scope.debitTable = false;
                                $scope.invoiceTable = true;
                                $scope.generalInvoiceTable = false;
                                $scope.voucherTable = false;
                                $scope.journalVoucherTable = false;
                            }
                        }
                        if($scope.invoiceInformation.generalInvoice != '' && $scope.invoiceInformation.generalInvoice != null || $scope.invoiceInformation.generalInvoice && undefined){
                            $scope.detailList = data.invoiceOrGeneralList;
                            if($scope.detailList == null || $scope.detailList.length == 0){
                                logger.logError("No Records Found");
                            }else{
                                $scope.creditTable = false;
                                $scope.debitTable = false;
                                $scope.invoiceTable = false;
                                $scope.generalInvoiceTable = true;
                                $scope.voucherTable = false;
                                $scope.journalVoucherTable = false;
                            }
                        }
                        if($scope.invoiceInformation.voucher != '' && $scope.invoiceInformation.voucher != null || $scope.invoiceInformation.voucher && undefined){
                            if(data.creditList != null){
                                if(data.creditList.length != 0){
                                    $scope.detailList = data.creditList;
                                    angular.forEach(data.creditList, function(dataItem, index) {
                                        $scope.detailList[index].debitNoteNo = data.creditList[index].debitNoteNo;
                                    })
                                    $scope.creditTable = true;
                                    $scope.debitTable = false;
                                    $scope.invoiceTable = false;
                                    $scope.generalInvoiceTable = false;
                                    $scope.voucherTable = false;
                                    $scope.journalVoucherTable = false;
                                }
                            }
                            else if(data.debitList != null){
                                if(data.debitList.length != 0){
                                    $scope.detailList = data.debitList;
                                    for(var i = 0;i < data.debitList.length;i++){
                                        $scope.detailList[i].debitNoteNo = data.debitList[i].debitNoteNo;
                                    }
                                    $scope.creditTable = false;
                                    $scope.debitTable = true;
                                    $scope.invoiceTable = false;
                                    $scope.generalInvoiceTable = false;
                                    $scope.voucherTable = false;
                                    $scope.journalVoucherTable = false;
                                }
                            }
                            else if(data.invoiceList.length != 0){
                                $scope.detailList = data.invoiceList;
                                $scope.creditTable = false;
                                $scope.debitTable = false;
                                $scope.invoiceTable = true;
                                $scope.generalInvoiceTable = false;
                                $scope.voucherTable = false;
                                $scope.journalVoucherTable = false;
                            }
                            else if(data.generalInvoiceList.length != 0){
                                $scope.detailList = data.generalInvoiceList;
                                $scope.creditTable = false;
                                $scope.debitTable = false;
                                $scope.invoiceTable = false;
                                $scope.generalInvoiceTable = true;
                                $scope.voucherTable = false;
                                $scope.journalVoucherTable = false;
                            }
                            else if(data.journalList.length != 0){
                                $scope.detailList = data.journalList;
                                $scope.creditTable = false;
                                $scope.debitTable = false;
                                $scope.invoiceTable = false;
                                $scope.generalInvoiceTable = false;
                                $scope.voucherTable = false;
                                $scope.journalVoucherTable = true;
                            }
                            else
                                logger.logError("No Records Found");
                        }
                        if($scope.invoiceInformation.generalVoucher != '' && $scope.invoiceInformation.generalVoucher != null || $scope.invoiceInformation.generalVoucher && undefined){
                            $scope.detailList = data.voucherOrJournalList;
                            if($scope.detailList == null || $scope.detailList.length == 0){
                                logger.logError("No Records Found");
                            }else{
                                $scope.creditTable = false;
                                $scope.debitTable = false;
                                $scope.invoiceTable = false;
                                $scope.generalInvoiceTable = false;
                                $scope.voucherTable = false;
                                $scope.journalVoucherTable = true;
                            }
                        }
                        if($scope.invoiceInformation.purchaseInvoice != '' && $scope.invoiceInformation.purchaseInvoice != null && $scope.invoiceInformation.purchaseInvoice != undefined){
                            $scope.detailList = data.purchaseInvoiceList;
                            if($scope.detailList == null || $scope.detailList.length == 0){
                                logger.logError("No Records Found");
                            }else{
                                $scope.purchaseInvoiceTable = true;
                            }
                        }
                        if($scope.invoiceInformation.paymentOrder != '' && $scope.invoiceInformation.paymentOrder != null && $scope.invoiceInformation.paymentOrder != undefined){
                            $scope.detailList = data.paymentOrderList;
                            if($scope.detailList == null || $scope.detailList.length == 0){
                                logger.logError("No Records Found");
                            }else{
                                $scope.paymentOrderTable = true;
                            }
                        }
                        if($scope.invoiceInformation.payment != '' && $scope.invoiceInformation.payment != null && $scope.invoiceInformation.payment != undefined){
                            $scope.detailList = data.paymentList;
                            if($scope.detailList == null || $scope.detailList.length == 0){
                                logger.logError("No Records Found");
                            }else{
                                $scope.paymentTable = true;
                            }
                        }
                        if($scope.invoiceInformation.receipt != '' && $scope.invoiceInformation.receipt != null && $scope.invoiceInformation.receipt != undefined){
                            $scope.detailList = data.receiptList;
                            if($scope.detailList == null || $scope.detailList.length == 0){
                                logger.logError("No Records Found");
                            }else{
                                $scope.receiptTable = true;
                            }
                        }
                    }else{
                    }
                    }).error(function(data) {
                    logger.logError("Error Please Try Again");
                    });
                }else
                    logger.logError(data.resultType);
                    
            }
        });
        
       
    };
    
  //view functionality
    
  //Add functionality
    $scope.add = function(creditNoteNo){
        $scope.callDialog($scope, creditNoteNo, $http, ngDialog, logger,$injector, sharedProperties, toaster,$rootScope);
    };
 
    $scope.creditNote = function(creditNoteNo) {
        $location.url($stateParams.tenantid+'/transaction/creditnotehdr/view1?creditNoteNo='+creditNoteNo);
    };
    
    $scope.debit = function(debitNoteNo){
        $location.url($stateParams.tenantid+'/transaction/debitnote/view?debitNoteNo1='+debitNoteNo);
    };
    
    $scope.invoice = function(invoiceNo){
        $scope.test = invoiceNo;
        if($scope.test.match("DIN") || $scope.test.match("SIN")){
            $location.path($stateParams.tenantid+'/invoice/singleInvoiceView1/' + invoiceNo);
        }else if($scope.test.match("DGI") || $scope.test.match("SIG")){
            $location.path($stateParams.tenantid+'/invoice/generalinvoice/view1/' + invoiceNo);
        }else if($scope.test.match("PHC")){
            $location.path($stateParams.tenantid+'/invoice/PHCInvoicenew/view1/' + invoiceNo);
        }else if($scope.test.match("SIPIN") || $scope.test.match("PIN") || $scope.test.match("MAPIN")){
            $location.path($stateParams.tenantid+"/invoice/purchaseinvoice/PurchaseInvoiceView1/"+purchaseInvoice);
        }
    };
    
    $scope.generalView = function(invoiceNo) {       
        $location.path($stateParams.tenantid+'/invoice/generalinvoice/view1/' + invoiceNo);
    };
        
    $scope.voucher = function(generalVoucher) {
        $location.path($stateParams.tenantid+"/transaction/journalvoucher/view1/"+jvNumber);
    };
    
    $scope.journalVoucher = function(jvNumber) {
        $location.path($stateParams.tenantid+"/transaction/journalvoucher/view1/"+jvNumber);
    };
    
    $scope.purchaseInvoice = function(purchaseInvoice){
        $location.path($stateParams.tenantid+"/invoice/purchaseinvoice/PurchaseInvoiceView1/"+purchaseInvoice);
    }
    
    $scope.paymentOrder = function(paymentOrder){
        $location.path($stateParams.tenantid+"/transaction/cashbankpayment/view1/"+paymentOrder);
    }
    
    $scope.payment = function(payment){
        $location.path($stateParams.tenantid+"/transaction/cashbankpayment/view1/"+payment);
    }
    
    $scope.receipt = function(receipt){
        $location.path($stateParams.tenantid+"/transaction/cashbankreceipt/view1/"+receipt);
    }
    
    $scope.formreset = function() {
        $scope.invoiceInformation = {};
        $scope.detailList = [];
        $scope.invoiceTrue = false;
        $scope.generalInvoiceTrue = false;
        $scope.creditTable = false;
        $scope.debitTable = false;
        $scope.invoiceTable = false;
        $scope.generalInvoiceTable = false;
        $scope.voucherTable = false;
        $scope.journalVoucherTable = false;
        $scope.purchaseInvoiceTable = false;
        $scope.paymentOrderTable = false;
        $scope.paymentTable = false;
        $scope.receiptTable = false;
        $scope.invoiceInformation = angular.copy(temp);
    };
    
});