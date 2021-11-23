//define([ 'hospital/accounts/accounts', 'jqGrid' ], function(module) {
    //'use strict';
    app.controller('budgetOverviewListCtrl', function($scope, $state, $stateParams,$http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService) {
        $scope.dataLoopCount = 0;
        $scope.from = 0;
        $scope.to = 100;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.isUpload = true;
        $scope.isDelete = true;
        
        
        $scope.budget = {
            companyId : 'C0002',
            financialyear : '',
            startdate : '',
            enddate : '',
            subGroupAcctCode : ''
        }

        $scope.budgetList = [];

        $scope.getList = function(resultbean) {
            $http.post("hospital/accounts/budgetOverview/list", resultbean).success(function(response) {
                $scope.budgetList = [];
//                $scope.createGrid($scope.budgetList);
//                angular.forEach(response.lBudgetOverview, function(value, key) {
//                    value.balance = value.allocated - value.paidBcAmt;
//                    value.companyId = resultbean.companyId;
//                    value.enddate = resultbean.enddate;
//                    value.startdate = resultbean.startdate;
//
//                });
                $scope.budgetList = response.lBudgetOverview;
//                $scope.reloadGrid($scope.budgetList);

            });
        }

        $scope.$watch('budget.companyId', function(newValue, oldValue) {
            if (newValue != undefined && newValue != null && newValue != '') {
                $http.post("hospital/accounts/budgetOverview/getFinancialYear", newValue).success(function(response) {
                    $scope.financeList = [];
                    angular.forEach(response.lFinanceYear, function(value, key) {
                        $scope.financeList.push({
                            'id' : value.financialyear,
                            'text' : value.financialyear,
                            'financialyear' : value.financialyear
                        });
                    });

                });
            }

        });

        $scope.$watch('budget.financialyear', function(newValue, oldValue) {
            $scope.budgetList = [];
            $scope.reloadGrid($scope.budgetList);
        });

        $scope.getCompanyList = function() {
            $http.get(  $stateParams.tenantid+'/app/commonUtility/getCompanyList').success(function(datas) {
                $scope.companyList = datas;

            })
        }

        $scope.getCompanyList();

        $scope.getSubGridList = function(accountcode, subgridDivId) {
            $scope.budget.subGroupAcctCode = accountcode;
            $http.post('hospital/accounts/budgetOverview/getDetailList', $scope.budget).success(function(datas) {
                var subgridTableId = subgridDivId + "_t";
                $("#" + subgridTableId).setGridParam({
                    data : datas.ldetailList,
                    rowNum : datas.ldetailList.length
                }).trigger('reloadGrid');

            })
        }

        $scope.submit = function(budgetReportForm) {
            if (new validationService().checkFormValidity(budgetReportForm)) {
                $scope.budgetList = [];
                var stdate;
                var end;
                var startdate = $scope.budget.financialyear;
                startdate = startdate.split("-");
                $scope.budget.startdate = startdate[0] + "-04-01";
                $scope.budget.enddate = "20" + startdate[1] + "-03-31";
                $scope.getList($scope.budget);
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(budgetReportForm.$validationSummary), 5000, 'trustedHtml');
            }

        }

        $scope.reloadGrid = function(data) {
            $('#budgetOverviewGrid').clearGridData(true);
            $('#budgetOverviewGrid').setGridParam({
                data : data,
                rowNum : data.length
            }).trigger('reloadGrid');
        };

        $scope.createGrid = function(inventoryList) {
            $("#budgetOverviewGrid").jqGrid({
                data : inventoryList,
                datatype : "local",
                autowidth : true,
                autoheight : true,
                rowList : [ 5, 10, 20 ],
                gridview : true,
                sortname : 'accounts',
                viewrecords : true,
                sortorder : 'desc',
                multiselect : false,
                multiboxonly : false,
                colNames : [ 'Name', 'Allocated Amount', 'Allocated Utilized', 'Balance', 'Account  code' ],
                colModel : [ {
                    name : 'accounts',
                    width : 250,
                    align : "left",
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    hidden : false
                }, {
                    name : 'allocated',
                    width : 250,
                    align : "left",
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    hidden : false
                }, {
                    name : 'paidBcAmt',
                    width : 250,
                    align : "left",
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    hidden : false
                }, {
                    name : 'balance',
                    width : 250,
                    align : "left",
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    hidden : false
                }, {
                    name : 'subGroupAcctCode',
                    width : 250,
                    align : "left",
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    hidden : true
                }

                ],
                loadOnce : true,
                pager : '#budgetOverviewPage',
                height : '100%',
                rowNum : 10,
                subGrid : true,
                subGridOptions : {
                    "plusicon" : 'fa fa-plus-circle',
                    "minusicon" : 'fa fa-minus-circle'
                },
                subGridRowExpanded : function(subgridDivId, rowId) {
                    var rowData = $('#budgetOverviewGrid').jqGrid('getRowData', rowId);
                    $scope.getSubGridList(rowData.subGroupAcctCode, subgridDivId);
                    var subgridTableId = subgridDivId + "_t";
                    var pager_child_id = "p_" + subgridTableId;
                    $("#" + subgridDivId).html("<table id='" + subgridTableId + "'></table><div id='" + pager_child_id + "' class='scroll'></div>");
                    $("#" + subgridTableId).jqGrid({
                        datatype : 'local',
                        data : "",
                        colNames : [ 'Voucher No', 'Voucher Date', 'Amt.local', 'Paid To' ],
                        colModel : [ {
                            name : 'cbVoucherNo',
                            index : 'cbVoucherNo',
                            width : 270,
                            align : "left",
                            searchoptions : {
                                sopt : [ 'cn' ]
                            }
                        }, {
                            name : 'voucherDate',
                            index : 'voucherDate',
                            width : 270,
                            align : "left",
                            searchoptions : {
                                sopt : [ 'cn' ]
                            }
                        }, {
                            name : 'loacalAmount',
                            index : 'loacalAmount',
                            width : 260,
                            align : "left",
                            searchoptions : {
                                sopt : [ 'cn' ]
                            }
                        }, {
                            name : 'paidTo',
                            index : 'paidTo',
                            width : 260,
                            align : "left",
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

            });
            $("#budgetOverviewGrid").jqGrid('navGrid', '#budgetOverviewPage', {
                edit : false,
                add : false,
                del : false,
                search : false,
                refresh : false
            });

        };

    //})
});