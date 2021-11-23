//define([ 'hospital/accounts/accounts', 'jqGrid' ], function(module) {

    'use strict';

    app.controller('accountspayableCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, $window) {

        $scope.accountsPayable = {
            apDate : '',
            supplierCode : ''
        }

        $scope.exportPayableAgewiseExcel = function() {
            if ($scope.accountsPayable.apDate != '') {
               /* $http.post('app/payableAgewise/exportPayableAgewiseExcel', $scope.accountsPayable.apDate).success(function(data) {
                    if (data.success) {
                       $window.open(data.filePath);
                        logger.logSuccess("Exported Sucessfully!...");
                    } else {
                        logger.logError("Failed to export");
                    }

                }).error(function(data) {
                    logger.logError("Error Please Try Again");
                });*/
            	
            	
            	$http.post('app/payableAgewise/exportPayableAgewiseExcel', $scope.accountsPayable.apDate).success(function(data) {
            		if(data){
                         debugger;
                         $("#payableAgewiseExport").bind('click', function() {
                         });
                         $('#payableAgewiseExport').simulateClick('click');
                         logger.logSuccess("Exported successfully!");
                     }else{
                         logger.logError("No Records Found");
                     }
                     
                 }).error(function(data) {
                     logger.logError("Error Please Try Again");
                 });
            } else {
                logger.logError("Please select date!....");
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
        }

        $scope.viewPayableAgewiseReport = function() {
            if ($scope.accountsPayable.apDate != '') {
                $http.post('app/payableAgewise/getPayableAgewiseReport', $scope.accountsPayable.apDate).success(function(data) {
                    if (data.success) {
                        $("#payableAgewiseGrid").jqGrid('clearGridData');
                        $scope.populatePayableAgewiseGrid(data.lPayableAgewiseList);
                    } else {

                    }

                }).error(function(data) {
                    logger.logError("Error Please Try Again");
                });
            } else {
                logger.logError("Please select date!....");
            }
        };

        $scope.populatePayableAgewiseGrid = function(lPayableAgewiseList) {
            var data = [];
            $("#payableAgewiseGrid").jqGrid({
                data : lPayableAgewiseList,
                datatype : "local",
                multiboxonly : false,
                autoheight : true,
                height : '100%',
                rowList : [ 10, 20, 30 ],
                multiselect : false,
                loadonce : true,
                gridview : true,
                colNames : [ 'Vendor Code', 'Vendor Name', 'Below 15 days', 'Below 30 days', 'Below 45 days', 'Below 90 days', 'Below 180 days', 'Above 180 days' ],
                colModel : [ {
                    name : 'supplierCode',
                    index : 'supplierCode',
                    width : 110,
                    align : "left",
                    sorttype : 'text',
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    resizable : false
                }, {
                    name : 'supplierName',
                    index : 'supplierName',
                    width : 180,
                    align : "left",
                    sorttype : 'text',
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    resizable : false,
                    hidden : false
                }, {
                    name : 'below15days',
                    index : 'below15days',
                    width : 120,
                    align : "right",
                    sorttype : 'text',
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    resizable : false,
                    hidden : false
                }, {
                    name : 'days30',
                    index : 'days30',
                    width : 130,
                    align : "right",
                    sorttype : 'text',
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    resizable : false,
                    hidden : false
                }, {
                    name : 'days45',
                    index : 'days45',
                    width : 130,
                    align : "right",
                    sorttype : 'text',
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    resizable : false,
                    hidden : false
                }, {
                    name : 'days90',
                    index : 'days90',
                    width : 130,
                    align : "right",
                    sorttype : 'text',
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    resizable : false,
                    hidden : false
                }, {
                    name : 'days180',
                    index : 'days180',
                    width : 130,
                    align : "right",
                    sorttype : 'text',
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    resizable : false,
                    hidden : false
                }, {
                    name : 'above180days',
                    index : 'above180days',
                    width : 125,
                    align : "right",
                    sorttype : 'text',
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    resizable : false,
                    hidden : false
                } ],
                pager : "#payableAgewisePage",
                viewrecords : true,
                ignoreCase : true,
                subGrid : true,
                subGridOptions : {
                    "plusicon" : 'ui-icon-plus',
                    "minusicon" : 'ui-icon-minus'
                },
                footerrow : true,
                subGridRowExpanded : function(subgrid_id, row_id) {
                    var subgrid_table_id, pager_id;
                    subgrid_table_id = subgrid_id + "_t";
                    pager_id = "p_" + subgrid_table_id;
                    var rowData = jQuery('#payableAgewiseGrid').jqGrid('getRowData', row_id);
                    $scope.accountsPayable.supplierCode = rowData.supplierCode;
                    $("#" + subgrid_id).html("<table id='" + subgrid_table_id + "' class='scroll'></table><div id='" + pager_id + "' class='scroll'></div>");
                    $http.post('app/payableAgewise/getPayableAgewiseReportDtl', $scope.accountsPayable).success(function(data) {
                        if (data.success) {
                            var PayableAgewiseDtlList = data.lPayableAgewiseList;
                            $("#" + subgrid_table_id).jqGrid({
                                datatype : "local",
                                data : PayableAgewiseDtlList,
                                colNames : [ 'Invoice no', 'Invoice Date', 'Invoice Amt', 'Paid Amount', 'Balance Amount', 'Below 15 days', 'Below 30 days', 'Below 45 days', 'Below 90 days', 'Below 180 days', 'Above 180 days' ],
                                colModel : [ {
                                    name : 'invoiceNo',
                                    index : 'invoiceNo',
                                    width : 110,
                                    align : "left",
                                    searchoptions : {
                                        sopt : [ 'cn' ]
                                    }
                                }, {
                                    name : 'invoiceDate',
                                    index : 'invoiceDate',
                                    width : 90,
                                    align : "left",
                                    searchoptions : {
                                        sopt : [ 'cn' ]
                                    },
                                    hidden : false
                                }, {
                                    name : 'invoiceAmount',
                                    index : 'invoiceAmount',
                                    width : 110,
                                    align : "right",
                                    searchoptions : {
                                        sopt : [ 'cn' ]
                                    },
                                    hidden : false,
                                    formatter : 'number',
                                    formatoptions : {
                                        decimalPlaces : 2
                                    }
                                }, {
                                    name : 'paidAmount',
                                    index : 'paidAmount',
                                    width : 110,
                                    align : "right",
                                    searchoptions : {
                                        sopt : [ 'cn' ]
                                    },
                                    hidden : false,
                                    formatter : 'number',
                                    formatoptions : {
                                        decimalPlaces : 2
                                    }
                                }, {
                                    name : 'balanceAmount',
                                    index : 'balanceAmount',
                                    width : 100,
                                    align : "right",
                                    searchoptions : {
                                        sopt : [ 'cn' ]
                                    },
                                    hidden : false,
                                    formatter : 'number',
                                    formatoptions : {
                                        decimalPlaces : 2
                                    }
                                }, {
                                    name : 'below15days',
                                    index : 'below15days',
                                    width : 85,
                                    align : "right",
                                    searchoptions : {
                                        sopt : [ 'cn' ]
                                    },
                                    hidden : false,
                                    formatter : 'number',
                                    formatoptions : {
                                        decimalPlaces : 2
                                    }
                                }, {
                                    name : 'days30',
                                    index : 'days30',
                                    width : 85,
                                    align : "right",
                                    searchoptions : {
                                        sopt : [ 'cn' ]
                                    },
                                    hidden : false,
                                    formatter : 'number',
                                    formatoptions : {
                                        decimalPlaces : 2
                                    }
                                }, {
                                    name : 'days45',
                                    index : 'days45',
                                    width : 85,
                                    align : "right",
                                    searchoptions : {
                                        sopt : [ 'cn' ]
                                    },
                                    hidden : false,
                                    formatter : 'number',
                                    formatoptions : {
                                        decimalPlaces : 2
                                    }
                                }, {
                                    name : 'days90',
                                    index : 'days90',
                                    width : 85,
                                    align : "right",
                                    searchoptions : {
                                        sopt : [ 'cn' ]
                                    },
                                    hidden : false,
                                    formatter : 'number',
                                    formatoptions : {
                                        decimalPlaces : 2
                                    }
                                }, {
                                    name : 'days180',
                                    index : 'days180',
                                    width : 85,
                                    align : "right",
                                    searchoptions : {
                                        sopt : [ 'cn' ]
                                    },
                                    hidden : false,
                                    formatter : 'number',
                                    formatoptions : {
                                        decimalPlaces : 2
                                    }
                                }, {
                                    name : 'above180days',
                                    index : 'above180days',
                                    width : 85,
                                    align : "right",
                                    searchoptions : {
                                        sopt : [ 'cn' ]
                                    },
                                    hidden : false,
                                    formatter : 'number',
                                    formatoptions : {
                                        decimalPlaces : 2
                                    }
                                } ],
                                height : '100%',
                                pager : pager_id,
                                sortname : 'num',
                                sortorder : "asc"
                            }).jqGrid('setGridParam', {
                                data : PayableAgewiseDtlList
                            }).trigger("reloadGrid");
                        }

                    }).error(function(PayableAgewiseDtlList) {
                    });
                }

            }).jqGrid('setGridParam', {
                data : lPayableAgewiseList
            }).trigger("reloadGrid");

            $("#payableAgewiseGrid").jqGrid('navGrid', '#payableAgewisePage', {
                edit : false,
                add : false,
                del : false,
                search : false,
                refresh : false
            });
            $("#payableAgewiseGrid").jqGrid('filterToolbar', {
                searchOnEnter : false,
                searchOperators : false
            });

        }

   // })

});
