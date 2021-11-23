//define([ 'hospital/accounts/accounts', 'jqGrid' ], function(module) {

   // 'use strict';
    app.controller('paymentHistoryCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, utilsService, $window) {

        $scope.dataLoopCount = 0;
        $scope.from = 0;
        $scope.to = 100;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.isUpload = true;
        $scope.paymentHistoryData = {
            cbVoucherNo : ''
        }

        $scope.exportPaymentHistoryExcel = function() {

            $http.post('app/pendingPaymentRpt/exportPaymentHistoryExcel').success(function(data) {
                if (data.success) {
                    $window.open(data.filePath);
                    logger.logSuccess("Exported Sucessfully!...");
                } else {
                    logger.logError("Failed to export");
                }

            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });

        }

        $scope.viewPaymentHistoryReport = function() {
//            var url = 'app/cashbankPayment/paymentHistory1stLevelList';
            $http.get("app/cashbankPayment/paymentHistory1stLevelList").success(function(data) {
                if (data.success) {
                    $("#paymentHistoryReportGrid").jqGrid('clearGridData');
                    $scope.populatePaymentHistoryReportGrid(data.lPaymentHistoryReportBean);
                } else {

                }

            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });

        };

        $scope.viewPaymentHistoryReport();

        $scope.populatePaymentHistoryReportGrid = function(lCashbankpaymentList) {

            var data = [];
            $("#paymentHistoryReportGrid").jqGrid({
                data : lCashbankpaymentList,
               /* datatype : "local",
                multiboxonly : false,
                height : '100%',
                rowList : [ 10, 20, 30 ],
                multiselect : false,
                loadonce : true,
                gridview : true,*/
              //  data : search,
                datatype : "local",
                autowidth : true,
                autoheight : true,
                rowList : [ 5, 10, 20 ],
                gridview : true,
                sortname : 'invdate',
                viewrecords : true,
                sortorder : 'desc',
                multiselect : false,
                multiboxonly : false,
                colNames : [ 'Invoice No', 'Invoice Dt', 'Vendor Code', 'Vendor Name', 'Due Dt', ' Amount', 'TC Amount' ],
                colModel : [ {
                    name : 'purInvoiceNo',
                    index : 'purInvoiceNo',
                    width : 60,
                    align : "left",
                    sorttype : 'text',
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    resizable : false
                }, {
                    name : 'purInvoiceDate',
                    index : 'purInvoiceDate',
                    width : 80,
                    align : "left",
                    sorttype : 'text',
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    resizable : false,
                    hidden : false
                }, {
                    name : 'supplierCode',
                    index : 'supplierCode',
                    width : 60,
                    align : "left",
                    sorttype : 'text',
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    resizable : false,
                    hidden : true
                }, {
                    name : 'supplierName',
                    index : 'supplierName',
                    width : 60,
                    align : "left",
                    sorttype : 'text',
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    resizable : false,
                    hidden : false
                }, {
                    name : 'dueDate',
                    index : 'dueDate',
                    width : 160,
                    align : "left",
                    sorttype : 'text',
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    resizable : false,
                    hidden : false
                }, {
                    name : 'bcAmountHdr',
                    index : 'bcAmountHdr',
                    width : 160,
                    align : "right",
                    formatter:'currency',formatoptions: { thousandsSeparator:','},
                    sorttype : 'text',
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    resizable : false,
                    hidden : false
                }, {
                    name : 'tcAmountHdr',
                    index : 'tcAmountHdr',
                    width : 160,
                    align : "right",
                    formatter:'currency',formatoptions: { thousandsSeparator:','},
                    sorttype : 'text',
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    resizable : false,
                    hidden : true
                } ],
                pager : "#paymentHistoryReportPage",
                viewrecords : true,
                ignoreCase : true,
                subGrid : true,
                subGridOptions : {
                    "plusicon" : 'ui-icon-plus',
                    "minusicon" : 'ui-icon-minus'
                },

                subGridRowExpanded : function(subgrid_id, row_id) {
                    var subgrid_table_id, pager_id;
                    subgrid_table_id = subgrid_id + "_t";
                    pager_id = "p_" + subgrid_table_id;
                    var rowData = jQuery('#paymentHistoryReportGrid').jqGrid('getRowData', row_id);

                    $scope.paymentHistoryData.invoiceNo = rowData.purInvoiceNo;

                    $("#" + subgrid_id).html("<table id='" + subgrid_table_id + "' class='scroll'></table><div id='" + pager_id + "' class='scroll'></div>");

                    $http.post('app/cashbankPayment/getPaymentHistoryReportDtl', $scope.paymentHistoryData.invoiceNo).success(function(data) {
                        var pendingPmtRptDtlList = data.lPaymentHistoryReportDtlBean;
                        $("#" + subgrid_table_id).jqGrid({
                            datatype : "local",
                            data : pendingPmtRptDtlList,
                            colNames : [ 'Voucher No', 'Voucher Dt', 'Acct Head Code', 'Account Name', 'Pmt Dtl Id', 'Invoice no', 'Currency', 'Exchange Rate', 'Invoice Amt ', 'Invoice Amt (TC)', 'Balance Amt ', 'Balance Amt (TC)', 'Paid Amt ', 'NEFT'/*'Paid Amt (TC)'*/ ],
                            colModel : [ {
                                name : 'voucherNo',
                                index : 'voucherNo',
                                width : 120,
                                align : "left",
                                searchoptions : {
                                    sopt : [ 'cn' ]
                                },
                                hidden : false
                            }, {
                                name : 'voucherDate',
                                index : 'voucherDate',
                                width : 120,
                                align : "left",
                                searchoptions : {
                                    sopt : [ 'cn' ]
                                },
                                hidden : false
                            },

                            {
                                name : 'acctHeadCode',
                                index : 'acctHeadCode',
                                width : 200,
                                align : "left",
                                searchoptions : {
                                    sopt : [ 'cn' ]
                                },
                                hidden : true
                            }, {
                                name : 'accountName',
                                index : 'accountName',
                                width : 150,
                                align : "left",
                                searchoptions : {
                                    sopt : [ 'cn' ]
                                },
                                hidden : false
                            },

                            {
                                name : 'paymentDtlId',
                                index : 'paymentDtlId',
                                width : 125,
                                align : "left",
                                searchoptions : {
                                    sopt : [ 'cn' ]
                                },
                                hidden : true
                            }, {
                                name : 'purInvoiceNo',
                                index : 'purInvoiceNo',
                                width : 100,
                                align : "left",
                                searchoptions : {
                                    sopt : [ 'cn' ]
                                }
                            },

                            {
                                name : 'currencyCode',
                                index : 'currencyCode',
                                width : 100,
                                align : "left",
                                searchoptions : {
                                    sopt : [ 'cn' ]
                                },
                                hidden : true
                            }, {
                                name : 'exchangeRate',
                                index : 'exchangeRate',
                                width : 100,
                                align : "right",
                                searchoptions : {
                                    sopt : [ 'cn' ]
                                },
                                hidden : true
                            }, {
                                name : 'invoiceBCAmt',
                                index : 'invoiceBCAmt',
                                width : 120,
                                align : "right",
                                formatter:'currency',formatoptions: { thousandsSeparator:','},
                                searchoptions : {
                                    sopt : [ 'cn' ]
                                },
                                hidden : false
                            }, {
                                name : 'invoiceTCAmt',
                                index : 'invoiceTCAmt',
                                width : 115,
                                align : "right",
                                formatter:'currency',formatoptions: { thousandsSeparator:','},
                                searchoptions : {
                                    sopt : [ 'cn' ]
                                },
                                hidden : true
                            }, {
                                name : 'bcBalanceAmt',
                                index : 'paidAmountTC',
                                width : 120,
                                align : "right",
                                formatter:'currency',formatoptions: { thousandsSeparator:','},
                                searchoptions : {
                                    sopt : [ 'cn' ]
                                },
                                hidden : false
                            }, {
                                name : 'tcBalanceAmt',
                                index : 'paidAmountTC',
                                width : 115,
                                formatter:'currency',formatoptions: { thousandsSeparator:','},
                                align : "right",
                                searchoptions : {
                                    sopt : [ 'cn' ]
                                },
                                hidden : true
                            }, {
                                name : 'paidAmountBC',
                                index : 'paidAmountBC',
                                width : 120,
                                align : "right",
                                formatter:'currency',formatoptions: { thousandsSeparator:','},
                                searchoptions : {
                                    sopt : [ 'cn' ]
                                },
                                hidden : false
                            }, {
                                name : 'neft',
                                index : 'neft',
                                width : 115,
                                align : "right",
                                searchoptions : {
                                    sopt : [ 'cn' ]
                                },
                                hidden : false
                            }, ],
                            height : '100%',
                            pager : pager_id,
                            sortname : 'num',
                            sortorder : "asc"

                        }).jqGrid('setGridParam', {
                            data : pendingPmtRptDtlList
                        }).trigger("reloadGrid");

                    }).error(function(pendingPmtRptDtlList) {
                    });
                }

            }).jqGrid('setGridParam', {
                data : lCashbankpaymentList
            }).trigger("reloadGrid");

            $("#paymentHistoryReportGrid").jqGrid('navGrid', '#paymentHistoryReportGrid', {
                edit : false,
                add : false,
                del : false,
                search : false,
                refresh : false
            });
            $("#paymentHistoryReportGrid").jqGrid('filterToolbar', {
                searchOnEnter : false,
                searchOperators : false
            });
        }

 //   });

});