//define([ 'hospital/accounts/accounts', 'jqGrid' ], function(module) {
    'use strict';
    app.controller('soaCustomerCtrl', function($scope, $state, $http, ngDialog, $window, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {
    	 $('#tb_fromDate').datetimepicker({
 	        format : 'DD/MM/YYYY',
 	        pickTime: false
 	    });
 	    
 	    $('#tb_toDate').datetimepicker({
 	        format : 'DD/MM/YYYY',
 	        pickTime: false
 	    });
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;

        $scope.soa = {
            type : '',
            fromDate:'',
            toDate:'',
            acctCode :'',
        }

        
        
        $scope.getSOACustomerReport = function() {
            var type = $scope.soa.type;
            $scope.soa.fromDate = $('#fromDate').val();
            $scope.soa.toDate = $('#toDate').val();
            if (type != '' && type != undefined) {
               // $http.get('app/soaReport/soaCustomerRprtList?type=' + type).success(function(response) {
            	$http.post('app/soaReport/soaCustomerRprtList', $scope.soa).success(function(response) {

                    $('#soagrid').setGridParam({
                        data : response.listCustomerSoa
                    }).trigger('reloadGrid');
                     $scope.reloadGrid(response.listCustomerSoa);
                    $scope.getOutstandingBalance();
                    
                    
                }).error(function(response) {
                });
            } else {
                logger.logError("Please Select a Type");
            }

        };

        $scope.getOutstandingBalance = function() {
            var type = $scope.soa.type;
            if (type != '' && type != undefined) {
            	$http.post('app/soaReport/debtorBalance', $scope.soa).success(function(response) {

               // $http.get('app/soaReport/debtorBalance?type=' + type).success(function(response) {
                    $('#totalQty').val(response);
                }).error(function(response) {
                });
            }
        };

        $scope.reloadGrid = function(data) {
            $('#soagrid').setGridParam({
                data : data,
                rowNum : data.length
            }).trigger('reloadGrid');
        };

        $scope.getSubGridList = function(code, subgridDivId,soa) {
        	$scope.soa.acctCode =code;
            	$http.post('app/soaReport/soaCustomerRprtSubList', $scope.soa).success(function(data) {
                var subgridTableId = subgridDivId + "_t";
                $("#" + subgridTableId).setGridParam({
                    data : data.subListCustomerSoa,
                    rowNum : data.subListCustomerSoa.length
                }).trigger('reloadGrid');
                $scope.reloadGrid(response.listCustomerSoa);

            });
            	
            	
        };

        $scope.createGrid = function(inventoryList) {
        	
        	
            $("#soagrid").jqGrid({
                data : inventoryList,
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
                colNames : [ 'Account Code', 'Account Name', 'Debit', 'Credit', 'Balance' ],
                colModel : [ {
                    name : 'code',
                    index : 'code',
                    align : 'left',
                    width : 40,
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    hidden : false
                }, {
                    name : 'name',
                    index : 'name',
                    width : 100,
                    align : "left",
                    searchoptions : {
                        sopt : [ 'cn' ]
                    }
                }, {
                    name : 'debit',
                    index : 'debit',
                    width : 80,
                    align : "right",
                    searchoptions : {
                        sopt : [ 'cn' ]
                    }
                }, {
                    name : 'credit',
                    index : 'credit',
                    width : 80,
                    align : "right",
                    searchoptions : {
                        sopt : [ 'cn' ]
                    }
                }, {
                    name : 'balance',
                    index : 'balance',
                    width : 100,
                    align : "right",
                    searchoptions : {
                        sopt : [ 'cn' ]
                    }
                } ],
                loadOnce : true,
                pager : '#soapage',
                height : '100%',
                rowNum : 10,
                subGrid : true,
                subGridOptions : {
                    "plusicon" : 'fa fa-plus-circle',
                    "minusicon" : 'fa fa-minus-circle'
                },
                subGridRowExpanded : function(subgridDivId, rowId) {

                    var rowData = $('#soagrid').jqGrid('getRowData', rowId);
                    $scope.getSubGridList(rowData.code, subgridDivId,$scope.soa);
                    var subgridTableId = subgridDivId + "_t";
                    var pager_child_id = "p_" + subgridTableId;
                    $("#" + subgridDivId).html("<table id='" + subgridTableId + "'></table><div id='" + pager_child_id + "' class='scroll'></div>");
                    $("#" + subgridTableId).jqGrid({
                        datatype : 'local',
                        data : "",
                        colNames : [ 'Ledger Date', 'Account Code', 'Transaction No', 'Debit', 'Credit' ],
                        colModel : [ {
                            name : 'ledgerDate',
                            index : 'ledgerDate',
                            width : 180,
                            align : "right",
                            searchoptions : {
                                sopt : [ 'cn' ]
                            }
                        }, {
                            name : 'acctCode',
                            index : 'acctCode',
                            width : 250,
                            searchoptions : {
                                sopt : [ 'cn' ]
                            },
                            hidden : true
                        }, {
                            name : 'transactionNo',
                            index : 'transactionNo',
                            width : 300,
                            align : "left",
                            searchoptions : {
                                sopt : [ 'cn' ]
                            }
                        }, {
                            name : 'debit',
                            index : 'debit',
                            width : 300,
                            align : "right",
                            searchoptions : {
                                sopt : [ 'cn' ]
                            }
                        }, {
                            name : 'credit',
                            index : 'credit',
                            width : 300,
                            align : "right",
                            searchoptions : {
                                sopt : [ 'cn' ]
                            }
                        }

                        ],
                        autoheight : true,
                        height : '100%',
                        sortname : 'num',
                        sortorder : "asc",
                    });
                }
            });
            

            $("#soagrid").jqGrid('navGrid', '#soapage', {
                edit : false,
                add : false,
                del : false,
                search : false,
                refresh : false
            });

            $("#soagrid").jqGrid('filterToolbar', {
                searchOperators : true,
                searchOnEnter : false
            });
            $("#soagrid").jqGrid('navButtonAdd', "#soapage", {
                caption : "",
                title : "Show/Hide Search box",
                buttonicon : 'ui-icon icon-thumb-tack',
                onClickButton : function() {
                    var myGrid = $('#soagrid');
                    myGrid[0].toggleToolbar();
                }
            });
            $("#soagrid")[0].toggleToolbar();
        };

        $scope.createGrid();

       /* $scope.exportChqExcel = function() {

            var type = $scope.soa.type;
            if (type != '' && type != undefined) {
               // $http.get('app/soaReport/exportExcel?type=' + type).success(function(data) {
            	$http.post('app/soaReport/exportExcel' + $scope.soa).success(function(data) {
                    if (data.success) {
                        $window.open(data.filePath);
                        logger.logSuccess("Exported Successfully!");
                    } else {
                        logger.logSuccess("Failed to export");
                    }

                }).error(function(data) {
                    logger.logError("Error Please Try Again");
                });
            } else {
                logger.logError("Please Select a Type");
            }
        }*/

   // });
        
        $scope.exportChqExcel = function() {

            var type = $scope.soa.type;
            if (type != '' && type != undefined) {
               // $http.get('app/soaReport/exportExcel?type=' + type).success(function(data) {
            	$http.post('app/soaReport/exportExcel', $scope.soa).success(function(data) {
                    if (data.success) {
                       /* $window.open(data.filePath);
                        logger.logSuccess("Exported Successfully!");*/
                    	  $("#TBExport").bind('click', function() {
                          });
                          $('#TBExport').simulateClick('click');
                          logger.logSuccess("Exported successfully!");
                    } else {
                        logger.logSuccess("No Records Found");
                    }

                }).error(function(data) {
                    logger.logError("Error Please Try Again");
                });
            } else {
                logger.logError("Please Select a Type");
            }
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
        
            
        
           
        
        
    
        
        
        
});
