    'use strict';
    app.controller('budgetOverviewListCtrl', function($scope,$filter, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService,$stateParams) {
        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.companyList=[];
        $scope.isDelete = true;
        $scope.isUpload = true;
        $scope.budget = {
            companyId : '',
            financialyear : '',
            startdate : '',
            enddate : '',
            subGroupAcctCode : ''
        }

        $scope.budgetList = [];

        $scope.getList = function(resultbean) {
        	
            $http.post($stateParams.tenantid+'/app/budgetOverview/list', resultbean).success(function(response) {
                $scope.budgetList = [];
                $scope.createGrid($scope.budgetList);
                angular.forEach(response.lBudgetOverview, function(value, key) {
                    value.balance = value.allocated - value.paidBcAmt;
                    value.companyId = resultbean.companyId;
                    value.enddate = resultbean.enddate;
                    value.startdate = resultbean.startdate;

                });
                $scope.budgetList = response.lBudgetOverview;
                $scope.reloadGrid($scope.budgetList);

            });
        }

        $scope.getDropdownValue = function() {
            $http.get($stateParams.tenantid+'/app/budget/getFinYear').success(function(datas) {
                if (datas.finYearList.length > 0) {
                    $scope.finYearList = datas.finYearList;
                } else {
                    $scope.finYearList = [];
                    $scope.budgetData.financial_year = "";
                }
            }).error(function(data) {
            });
    }
    $scope.getDropdownValue();

        $scope.$watch('budget.financialyear', function(newValue, oldValue) {
            $scope.budgetList = [];
            $scope.reloadGrid($scope.budgetList);
        });

        $scope.getDropdownValue = function() {
           /* var expenseObj = [], stausObj = [];
            $http.get($stateParams.tenantid+'/app/budget/getDropDownList').success(function(datas) {
                $scope.companyList = datas.companyList;
                // $scope.finYearList = datas.finYearList;
            }).error(function(datas) {
            });
*/
        	 $http.get($stateParams.tenantid+'/app/usermaster/getCompanyList?formCode='+$('#form_code_id').val()).success(function(datas) {
                 debugger;           
                 $scope.companyList = datas; 
                
                 
                 console.log("company")
                 console.log($scope.companyList)
                 var foundItemDest = $filter('filter')($scope.companyList, { baseCompany:  1 })[0];
                 $scope.budget.companyId=foundItemDest.id;
                 
                 /* 
                 $timeout(function() {
                     $('#txtCompanyCode').multiselect('deselectAll', false);
                     $('#txtCompanyCode').multiselect('updateButtonText');
                     $("#txtCompanyCode").multiselect('rebuild');
                 
                 }, 2, false);
                 $("#multiselect-button").addClass("width_100 input-sm line-height-5");*/
                 }).error(function(datas) {
             });
        }
        $scope.getDropdownValue();

        
       /* $scope.getCompanyList = function() {
            $http.get($stateParams.tenantid+'/app/commonUtility/getCompanyList').success(function(datas) {
                $scope.companyList = datas;

            })
        }

        $scope.getCompanyList();
*/
        $scope.getSubGridList = function(accountcode, subgridDivId) {
            $scope.budget.subGroupAcctCode = accountcode;
            $http.post($stateParams.tenantid+'/app/budgetOverview/getDetailList', $scope.budget).success(function(datas) {
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
                $scope.budget.startdate = startdate[0] + "-01-01";
                $scope.budget.enddate =  startdate[0] + "-12-31";

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

    })
