//define([ 'hospital/accounts/accounts', 'jqGrid' ], function(module) {

    'use strict';
    app.controller('cashbookCtrl', function($scope,$stateParams, $state, $http, $location, ngDialog, logger) {

        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.inventoryModel = {
            itemId : '',
            itemName : '',
            locationId : '',
            locationName : '',
            totQty : ''

        };
           $scope.generalLedger = {
                subGroupCode:'',
                groupCode:'',
                companyCode:'C0002',
                fromDate:'',
                toDate:'',
                accountHeadCode:'',
                filterAccountHeadCode:'',
                mainAccountCode:'',
                subAccountCode:'',
                costCenter :'',
                totalAmount:'',
              
        };
        $scope.itemLists = [];
        $scope.locationLists = [];
 $scope.companyList=[];
                 $scope.getcompanyList=function(){
                 $http.get($stateParams.tenantid +'/app/commonUtility/getCompanyList').success(function(data) {

                 $scope.companyList = data;
                 var data = {};
            data["id"] = "All";
            data["text"] = "ALL";
            $scope.companyList.push(data);
                 })
} 
$scope.getcompanyList();
        $scope.inventoryList = function() {
          $scope.generalLedger.type='cash';
            $http.post('hospital/accounts/cashBankBook/getData',  $scope.generalLedger).success(function(response) {
                $scope.createGrid(response.lCashBankBook);
            }).error(function(response) {
            });

        };

       // $scope.inventoryList();
        $scope.reloadGrid = function(data) {
            $('#cashBookGrid').setGridParam({
                data : data,
                rowNum : data.length
            }).trigger('reloadGrid');
        };

        $scope.getSubGridList = function(parentCode, accountname, subgridDivId) {
            var acctCode = parentCode + "," + accountname;
            $http.post('hospital/accounts/cashBankBook/getSubData', acctCode).success(function(data) {
                var subgridTableId = subgridDivId + "_t";
                $("#" + subgridTableId).setGridParam({
                    data : data.lCashBankBook,
                    rowNum : data.lCashBankBook.length
                }).trigger('reloadGrid');

            });
        };

        $scope.totalInventory = function() {

            var prdQty = 0;
            var data = $("#cashBookGrid").jqGrid('getGridParam', 'data');
            if (data != undefined && data.length > 0) {
                var jsonPrdlist = {
                    "table" : data
                };
                for (var j = 0; j < jsonPrdlist.table.length; j++) {
                    prdQty = prdQty + parseInt(jsonPrdlist.table[j].currentBalance);
                }

            }
            if (!isNaN(prdQty))
                $('#totalQty').val(prdQty);
            else
                $('#totalQty').val(0);

        }

        $scope.createGrid = function(inventoryList) {
            $("#cashBookGrid").jqGrid({
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
                colNames : [ 'Parent Code', 'Account Code', 'Account Name', 'Debit', 'Credit', 'Balance' ],
                colModel : [ {
                    name : 'parentCode',
                    index : 'parentCode',
                    align : 'left',
                    width : 80,
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    hidden : true
                }, {
                    name : 'accountCode',
                    index : 'accountCode',
                    align : 'left',
                    width : 80,
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    hidden : false
                }, {
                    name : 'accountName',
                    index : 'accountName',
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
                    align : 'right',
                    width : 100,
                    searchoptions : {
                        sopt : [ 'cn' ]
                    }
                }, {
                    name : 'currentBalance',
                    index : 'currentBalance',
                    width : 150,
                    align : "right",
                    searchoptions : {
                        sopt : [ 'cn' ]
                    }
                },

                ],
                loadOnce : true,
                pager : '#cashbookdiv',
                height : '100%',
                rowNum : 10,
                subGrid : true,
                subGridOptions : {
                    "plusicon" : 'fa fa-plus-circle',
                    "minusicon" : 'fa fa-minus-circle'
                },
                subGridRowExpanded : function(subgridDivId, rowId) {

                    var rowData = $('#cashBookGrid').jqGrid('getRowData', rowId);
                    $scope.getSubGridList(rowData.parentCode, rowData.accountCode, subgridDivId);
                    var subgridTableId = subgridDivId + "_t";
                    var pager_child_id = "p_" + subgridTableId;
                    $("#" + subgridDivId).html("<table id='" + subgridTableId + "'></table><div id='" + pager_child_id + "' class='scroll'></div>");
                    $("#" + subgridTableId).jqGrid({
                        datatype : 'local',
                        data : "",
                        colNames : [ 'Transaction No', 'Transaction Date', 'Debit', 'Credit' ],
                        colModel : [ {
                            name : 'transactionNo',
                            index : 'transactionNo',
                            width : 270,
                            searchoptions : {
                                sopt : [ 'cn' ]
                            }
                        }, {
                            name : 'ledgerDate',
                            index : 'ledgerDate',
                            width : 270,
                            align : "left",
                            searchoptions : {
                                sopt : [ 'cn' ]
                            }
                        }, {
                            name : 'trnsDebit',
                            index : 'trnsDebit',
                            width : 267,
                            align : "right",
                            searchoptions : {
                                sopt : [ 'cn' ]
                            }
                        }, {
                            name : 'trnsCredit',
                            index : 'trnsCredit',
                            width : 267,
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

                },
                loadComplete : function() {
                    $scope.totalInventory();
                }
            });
            $("#cashBookGrid").jqGrid('navGrid', '#cashbookdiv', {
                edit : false,
                add : false,
                del : false,
                search : false,
                refresh : false
            });

            $("#cashBookGrid").jqGrid('filterToolbar', {
                searchOperators : true,
                searchOnEnter : false
            });
            $("#cashBookGrid").jqGrid('navButtonAdd', "#cashbookdiv", {
                caption : "",
                title : "Show/Hide Search box",
                buttonicon : 'ui-icon icon-thumb-tack',
                onClickButton : function() {
                    var myGrid = $('#cashBookGrid');
                    myGrid[0].toggleToolbar();
                }
            });
            $("#cashBookGrid")[0].toggleToolbar();
        };

    });

//});