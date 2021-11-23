//define([ 'hospital/accounts/accounts', 'jqGrid' ], function(module) {

    'use strict';

    app.controller('profitLossSearchCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, $window, sharedProperties, toaster, $rootScope, validationService) {

        $scope.pl = {
            fromDate : '',
            toDate : '',
            company : '',
        }


        $http.get('app/commonUtility/getCompanyList').success(function(data) {
            $scope.companyList = data;
            
            var data = {};
            data["id"] = "ALL";
            data["text"] = "ALL";
            $scope.companyList.push(data);
        }).error(function(data) {
        });

        $scope.exportExcel = function() {

            $http.post('app/profitloss/exportPLExcel', $scope.pl).success(function(data) {

                if (data.success) {

                    $window.open(data.filePath);
                }

            }).error(function(datas) {
            });
        }

        var originalDatas = angular.copy($scope.pl);

        $scope.resetPL = function(originalDatas) {

            $scope.pl = angular.copy(originalDatas);
            $scope.profitLossSearchForm.$setPristine();
        }

        $scope.viewProfitLoss = function() {

            if (new validationService().checkFormValidity($scope.profitLossSearchForm)) {
                $http.post('app/profitloss/generatePLReport', $scope.pl).success(function(datas) {
                    var schgrid = '<table id="profitAndLossGrid"></table><div id="profitAndLossPage"></div>';
                    $('#jqgrid').empty();
                    $('#jqgrid').append(schgrid);
                    $scope.populateProfitAndLossGrid(datas);

                }).error(function(datas) {
                });
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.profitLossSearchForm.$validationSummary), 555000, 'trustedHtml');
            }
        }

        $scope.$watch('[pl.fromDate,pl.toDate]', function(newValue, oldValue) {

            if (newValue != "" && newValue != undefined) {
                if ($scope.pl.fromDate != '' && $scope.pl.toDate != '') {
                    var fromDate = $scope.pl.fromDate;
                    var toDate = $scope.pl.toDate;
                    fromDate = fromDate.split("/");
                    fromDate = new Date(fromDate[2], fromDate[1], fromDate[0]);
                    toDate = toDate.split("/");
                    toDate = new Date(toDate[2], toDate[1], toDate[0]);
                    if (fromDate > toDate) {
                        $scope.pl.toDate = '';
                        logger.logError("To Date should greater than From Date");
                    }
                }
            }
        });

        $scope.populateProfitAndLossGrid = function(cListData) {

            $("#profitAndLossGrid").jqGrid({
                data : cListData,
                datatype : "local",
                multiboxonly : true,
                autowidth : true,
                height : '100%',
                rowList : [ 10, 20, 30 ],
                multiselect : true,
                loadonce : false,
                gridview : true,
                colNames : [ 'Group Head Code', 'Group Head Name', 'Debit', 'Credit' ],
                colModel : [ {
                    name : 'groupHeadCode',
                    index : 'groupHeadCode',
                    width : 40,
                    align : "left",
                    searchoptions : {
                        sopt : [ 'cn' ]
                    }
                }, {
                    name : 'groupHeadName',
                    index : 'groupHeadName',
                    width : 100,
                    align : "left",
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    hidden : false
                }, {
                    name : 'debitAmount',
                    index : 'debitAmount',
                    width : 60,
                    align : "right",
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    hidden : false
                }, {
                    name : 'creditAmount',
                    index : 'creditAmount',
                    width : 80,
                    align : "right",
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    hidden : false
                }, ],
                pager : "#profitAndLossPage",
                viewrecords : true,
                ignoreCase : true,
                subGrid : true,
                subGridOptions : {
                    "plusicon" : 'fa fa-plus-circle',
                    "minusicon" : 'fa fa-minus-circle'
                },

                footerrow : true,

                subGridRowExpanded : function(subgrid_id, row_id) {
                    var subgrid_table_id, pager_id;
                    subgrid_table_id = subgrid_id + "_t";
                    pager_id = "p_" + subgrid_table_id;
                    var rowData = jQuery('#profitAndLossGrid').jqGrid('getRowData', row_id);
                    if (rowData.groupHeadCode == 'E')
                        $scope.pl.groupHeadCode = '400%'
                    else
                        $scope.pl.groupHeadCode = '300%'
                    $("#" + subgrid_id).html("<table id='" + subgrid_table_id + "' class='scroll'></table><div id='" + pager_id + "' class='scroll'></div>");
                    $http.post('app/profitloss/generatePLReportDtl', $scope.pl).success(function(dtlData) {

                        $("#" + subgrid_table_id).jqGrid({
                            datatype : "local",
                            data : dtlData,
                            colNames : [ 'Sub Group Code', 'Sub Group Name', 'Debit', 'Credit' ],
                            colModel : [ {
                                name : 'groupHeadCode',
                                index : 'groupHeadCode',
                                width : 185,
                                align : "left",
                                searchoptions : {
                                    sopt : [ 'cn' ]
                                }
                            }, {
                                name : 'groupHeadName',
                                index : 'groupHeadName',
                                width : 335,
                                align : "left",
                                searchoptions : {
                                    sopt : [ 'cn' ]
                                },
                                hidden : false
                            }, {
                                name : 'debitAmount',
                                index : 'debitAmount',
                                width : 240,
                                align : "right",
                                searchoptions : {
                                    sopt : [ 'cn' ]
                                },
                                hidden : false
                            }, {
                                name : 'creditAmount',
                                index : 'creditAmount',
                                width : 250,
                                align : "right",
                                searchoptions : {
                                    sopt : [ 'cn' ]
                                },
                                hidden : false
                            } ],
                            height : '100%',
                            pager : pager_id,
                            sortname : 'num',
                            sortorder : "asc",
                            subGrid : true,
                            subGridOptions : {
                                "plusicon" : 'fa fa-plus-circle',
                                "minusicon" : 'fa fa-minus-circle'
                            },
                            subGridRowExpanded : function(subgridah_id, rowah_id) {

                                var subgridah_table_id, pagerah_id;
                                subgridah_table_id = subgridah_id + "_t";
                                pagerah_id = "p_" + subgrid_table_id;
                                var rowData = jQuery('#' + subgrid_table_id).jqGrid('getRowData', rowah_id);
                                $scope.pl.groupHeadCode = rowData.groupHeadCode;
                                $("#" + subgridah_id).html("<table id='" + subgridah_table_id + "' class='scroll'></table><div id='" + pagerah_id + "' class='scroll'></div>");
                                $http.post('app/profitloss/generatePLReportAHDtl', $scope.pl).success(function(dtlahData) {

                                    $("#" + subgridah_table_id).jqGrid({
                                        datatype : "local",
                                        data : dtlahData,
                                        colNames : [ 'Account Head Code', 'Account Head Name', 'Debit', 'Credit' ],
                                        colModel : [ {
                                            name : 'groupHeadCode',
                                            index : 'groupHeadCode',
                                            width : 185,
                                            align : "left",
                                            searchoptions : {
                                                sopt : [ 'cn' ]
                                            }
                                        }, {
                                            name : 'groupHeadName',
                                            index : 'groupHeadName',
                                            width : 335,
                                            align : "left",
                                            searchoptions : {
                                                sopt : [ 'cn' ]
                                            },
                                            hidden : false
                                        }, {
                                            name : 'debitAmount',
                                            index : 'debitAmount',
                                            width : 230,
                                            align : "right",
                                            searchoptions : {
                                                sopt : [ 'cn' ]
                                            },
                                            hidden : false
                                        }, {
                                            name : 'creditAmount',
                                            index : 'creditAmount',
                                            width : 235,
                                            align : "right",
                                            searchoptions : {
                                                sopt : [ 'cn' ]
                                            },
                                            hidden : false
                                        } ],
                                        height : '100%',
                                        pager : pagerah_id,
                                        sortname : 'num',
                                        sortorder : "asc",
                                        subGrid : true,
                                        subGridOptions : {
                                            "plusicon" : 'fa fa-plus-circle',
                                            "minusicon" : 'fa fa-minus-circle'
                                        },
                                        subGridRowExpanded : function(subgridtn_id, rowtn_id) {
                                            var subgridtn_table_id, pagertn_id;
                                            subgridtn_table_id = subgridtn_id + "_t";
                                            pagertn_id = "p_" + subgrid_table_id;
                                            var rowData = jQuery('#' + subgridah_table_id).jqGrid('getRowData', rowtn_id);
                                            var accountHeadCode = rowData.groupHeadCode;
                                            $("#" + subgridtn_id).html("<table id='" + subgridtn_table_id + "' class='scroll'></table><div id='" + pagertn_id + "' class='scroll'></div>");
                                            var url = 'app/profitloss/getProfitLossTransactions?accountHeadCode=' + accountHeadCode + '&fromDate=' + $scope.pl.fromDate + '&toDate=' + $scope.pl.toDate;
                                            $http.get(url).success(function(dtlahData) {
                                                $("#" + subgridtn_table_id).jqGrid({
                                                    datatype : "local",
                                                    data : dtlahData.lProfitLossTransaction,
                                                    colNames : [ 'Transaction No', 'BC Credit', 'BC Debit', 'TC Credit', 'TC Debit', 'Narration' ],
                                                    colModel : [ {
                                                        name : 'transactionNo',
                                                        index : 'transactionNo',
                                                        width : 160,
                                                        align : "left",
                                                        searchoptions : {
                                                            sopt : [ 'cn' ]
                                                        }
                                                    }, {
                                                        name : 'bcCredit',
                                                        index : 'bcCredit',
                                                        width : 160,
                                                        align : "right",
                                                        searchoptions : {
                                                            sopt : [ 'cn' ]
                                                        },
                                                        hidden : false
                                                    }, {
                                                        name : 'bcDebit',
                                                        index : 'bcDebit',
                                                        width : 165,
                                                        align : "right",
                                                        searchoptions : {
                                                            sopt : [ 'cn' ]
                                                        },
                                                        hidden : false
                                                    }, {
                                                        name : 'tcCredit',
                                                        index : 'tcCredit',
                                                        width : 160,
                                                        align : "right",
                                                        searchoptions : {
                                                            sopt : [ 'cn' ]
                                                        },
                                                        hidden : false
                                                    }, {
                                                        name : 'tcDebit',
                                                        index : 'tcDebit',
                                                        width : 165,
                                                        align : "right",
                                                        searchoptions : {
                                                            sopt : [ 'cn' ]
                                                        },
                                                        hidden : false
                                                    }, {
                                                        name : 'narration',
                                                        index : 'narration',
                                                        width : 165,
                                                        align : "left",
                                                        searchoptions : {
                                                            sopt : [ 'cn' ]
                                                        },
                                                        hidden : false
                                                    } ],
                                                    height : '100%',
                                                    pager : pagertn_id,
                                                    sortname : 'num',
                                                    sortorder : "asc",
                                                });
                                            }).error(function(dtlahData) {
                                            });
                                        }
                                    });
                                }).error(function(dtlahData) {
                                });
                            },

                        });

                    }).error(function(dtlData) {
                    });
                }
            });

        }
   // });

});