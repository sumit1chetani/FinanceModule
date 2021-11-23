///define([ 'hospital/accounts/accounts', 'jqGrid' ], function(module) {

   /// 'use strict';

    app.controller('accountsRecivableCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, $window) {

        $scope.accountsRecivable = {
            arDate : '',
            customerCode : ''
        }

        $scope.exportReceivableAgewiseExcel = function() {
            if ($scope.accountsRecivable.arDate != '') {
               /* $http.post('app/receivableAgewise/exportReceivableAgewiseExcel', $scope.accountsRecivable.arDate).success(function(data) {
                    if (data.success) {
                        $window.open(data.filePath);
                        logger.logSuccess("Exported Sucessfully!...");
                    } else {
                        logger.logError("Failed to export");
                    }

                }).error(function(data) {
                    logger.logError("Error Please Try Again");
                });*/
            	
            	$http.post('app/receivableAgewise/exportReceivableAgewiseExcel', $scope.accountsRecivable.arDate).success(function(data) {                    
            		if(data){
                         debugger;
                         $("#payableAgewiseExport").bind('click', function() {
                         });
                         $('#payableAgewiseExport').simulateClick('click');
                         logger.logSuccess("Exported Successfully!");
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

        $scope.viewReceivableAgewiseReport = function() {
            if ($scope.accountsRecivable.arDate != '') {
                $http.post('app/receivableAgewise/getReceivableAgewiseReport', $scope.accountsRecivable.arDate).success(function(data) {
                    if (data.success) {
                        $("#ReceivableAgewiseGrid").jqGrid('clearGridData');
                        $scope.populateReceivableAgewiseGrid(data.lReceivableAgewiseList);
                    } else {

                    }

                }).error(function(data) {
                    logger.logError("Error Please Try Again");
                });
            } else {
                logger.logError("Please select date!....");
            }
        };

        $scope.populateReceivableAgewiseGrid = function(lReceivableAgewiseList) {
            var data = [];
            $("#ReceivableAgewiseGrid").jqGrid({
                data : lReceivableAgewiseList,
                datatype : "local",
                multiboxonly : false,
                height : '100%',
                rowList : [ 10, 20, 30 ],
                multiselect : false,
                loadonce : true,
                search : true,
                gridview : true,
                colNames : [ 'Customer Code', 'Customer Name', 'Below 15 days', 'Below 30 days', 'Below 45 days', 'Below 90 days', 'Below 180 days', 'Above 180 days' ],
                colModel : [ {
                    name : 'customerCode',
                    index : 'customerCode',
                    width : 110,
                    align : "left",
                    searchoptions : {
                        sopt : [ 'cn' ]
                    }
                }, {
                    name : 'customerName',
                    index : 'customerName',
                    width : 180,
                    align : "left",
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    hidden : false
                }, {
                    name : 'below15days',
                    index : 'below15days',
                    width : 120,
                    align : "right",
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    hidden : false
                }, {
                    name : 'days30',
                    index : 'days30',
                    width : 130,
                    align : "right",
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    hidden : false
                }, {
                    name : 'days45',
                    index : 'days45',
                    width : 130,
                    align : "right",
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    hidden : false
                }, {
                    name : 'days90',
                    index : 'days90',
                    width : 130,
                    align : "right",
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    hidden : false
                }, {
                    name : 'days180',
                    index : 'days180',
                    width : 130,
                    align : "right",
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    hidden : false
                }, {
                    name : 'above180days',
                    index : 'above180days',
                    width : 125,
                    align : "right",
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    hidden : false
                } ],
                pager : "#ReceivableAgewisePage",
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
                    var rowData = jQuery('#ReceivableAgewiseGrid').jqGrid('getRowData', row_id);
                    $scope.accountsRecivable.customerCode = rowData.customerCode;
                    $("#" + subgrid_id).html("<table id='" + subgrid_table_id + "' class='scroll'></table><div id='" + pager_id + "' class='scroll'></div>");
                    $http.post('app/receivableAgewise/getReceivableAgewiseReportDtl', $scope.accountsRecivable).success(function(data) {
                        if (data.success) {
                            var ReceivableAgewiseDtlList = data.lReceivableAgewiseList;
                            $("#" + subgrid_table_id).jqGrid({
                                datatype : "local",
                                data : ReceivableAgewiseDtlList,
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
                                data : ReceivableAgewiseDtlList
                            }).trigger("reloadGrid");
                        }

                    }).error(function(ReceivableAgewiseDtlList) {
                    });
                }
            }).jqGrid('setGridParam', {
                data : lReceivableAgewiseList
            }).trigger("reloadGrid");

        }

   // })

});
