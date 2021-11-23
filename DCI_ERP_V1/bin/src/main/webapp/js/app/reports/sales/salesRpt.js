'use strict';
app.controller('salesRptCtrl', function($templateCache, $scope, $timeout, $rootScope, $http, logger, $log, ngDialog, $modal, $location, $sce, $filter, salesRptService) {

    $('#tb_fromDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime : false
    });

    $('#tb_toDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime : false
    });

    $("#pol").multiselect({
        maxHeight : 200,
        width : 412,
        includeSelectAllOption : true,
        disableIfEmpty : true,
    });

    $("#pod").multiselect({
        maxHeight : 200,
        width : 412,
        includeSelectAllOption : true,
        disableIfEmpty : true,
    });

    $("#multiselect-button").addClass("width_100 input-sm line-height-5");

    $scope.serivceHublist = [];

    $scope.serivceHublist.push('Consolidated');
    $scope.serivceHublist.push('Dubai');
    $scope.serivceHublist.push('Singapore');

    $scope.salesRpt = {
        sector : '',
        vessel : '',
        voyage : '',
        pol : '',
        pod : '',
        slot : '',
        customer : '',
        serviceHub : 'Consolidated',
        fromDate : '',
        toDate : '',
        options : '',
        polList : [],
        podList : []
    }

    /*
     * $scope.salesRpt = { subGroupCode:'', companyCode:'', fromDate:'',
     * toDate:'', acctHeadCode:'', filterCode:'', relatedParty:'N' };
     */

    $scope.formreset = function() {
        $scope.salesRpt = {
            sector : '',
            vessel : '',
            voyage : '',
            pol : '',
            pod : '',
            slot : '',
            customer : '',
            serviceHub : 'Consolidated',
            fromDate : '',
            toDate : '',
            options : '',
            polList : [],
            podList : []
        }
    };

    $scope.defaultsectorList = [];
    $scope.defaultvesselist = [];
    $scope.defaultvoyageList = [];

    $scope.getSectorList = function() {
        var url = 'app/salesRpt/defaultSectorList';
        $http.get(url).success(function(data) {
            $scope.defaultsectorList = data.listsectorList;
            $scope.sectorList = data.listsectorList;
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });

    };

    $scope.getVesselList = function() {
        var url = 'app/loadingSummary/vesselDropDownList?formCode=' + $('#form_code_id').val();
        $http.get(url).success(function(data) {

            $scope.defaultvesselist = data.vesselList;
            $scope.vesselist = data.vesselList;
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });

    };

    $scope.getSectorList();
    $scope.getVesselList();

    $scope.voyagePortList = [];
    $scope.getDefaultPort = function() {
        salesRptService.defaultPort().then(function(result) {
            /*
             * $scope.voyagePortList = result.data.listPodList;
             * $scope.voyagePortList = result.data.listPolList;
             */

            angular.forEach(result.data.listPolList, function(value, key) {
                $scope.voyagePortList.push(value.id);
            });

            $timeout(function() {
                $('#pol').multiselect('deselectAll', false);
                $('#pol').multiselect('updateButtonText');
                $("#pol").multiselect('rebuild');
            }, 2, false);

            $timeout(function() {
                $('#pod').multiselect('deselectAll', false);
                $('#pod').multiselect('updateButtonText');
                $("#pod").multiselect('rebuild');
            }, 2, false);

        });

    }

    $scope.getDefaultPort();

    $scope.$watch('salesRpt.vessel', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
            $scope.getVoyage(newValue.id);
            $scope.voyage = '';
        } else {
            $scope.voyageList = $scope.defaultvoyageList;
            $scope.voyage = '';
            $scope.salesRpt.voyage = ''
        }
    });
    $scope.$watch('vessel', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {

        } else {
            $scope.voyage = '';
            $scope.salesRpt.voyage = ''
        }
    });
    $scope.$watch('voyage', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
            $scope.getVessel(newValue.id);
            $scope.getVoyagePort(newValue);
            // $scope.getfetchingActivityService(newValue.id);
        } else {
            $scope.vessel = '';
            $scope.salesRpt.vessel = '';
            $scope.voyageList = $scope.defaultvoyageList;
        }
    });

    salesRptService.dropDownList().then(function(result) {
        $scope.defaultvoyageList = result.data.voyageList;
        $scope.voyageList = result.data.voyageList;
        $scope.slotList = result.data.slotList;
        $scope.customerList = result.data.slotList;

    });

    salesRptService.dropDownCustList().then(function(result) {
        $scope.customerList = result.data.custList;

    });

    $scope.getVoyage = function(vesselCode) {
        salesRptService.voyageList(vesselCode).then(function(result) {
            $scope.voyageList = result.data;
        });

    }

    $scope.getVoyagePort = function(voyageCode) {
        salesRptService.port(voyageCode).then(function(result) {
            /*
             * $scope.voyagePortList = result.data.listPodList;
             * $scope.voyagePortList = result.data.listPolList;
             */
            $scope.voyagePortList = [];
            angular.forEach(result.data.listPolList, function(value, key) {
                $scope.voyagePortList.push(value.id);
            });

            $timeout(function() {
                $('#pol').multiselect('deselectAll', false);
                $('#pol').multiselect('updateButtonText');
                $("#pol").multiselect('rebuild');
            }, 2, false);

            $timeout(function() {
                $('#pod').multiselect('deselectAll', false);
                $('#pod').multiselect('updateButtonText');
                $("#pod").multiselect('rebuild');
            }, 2, false);

        });

    }
    
    
    $scope.getDropDownList = function() {
        $http.get('app/commonUtility/getPortList').success(function(datas) {
            $scope.polList = datas;
            
            $timeout(function() { 
                $("#lpol").multiselect({
                    maxHeight: 200,
                    includeSelectAllOption: true,
                    selectAllText: 'Select All',
                    enableFiltering: true,
                    enableCaseInsensitiveFiltering: true,
                    filterPlaceholder: 'Search',
                    onChange: function(element, checked) {
                        debugger;
                        var ct=""; 
                      if($scope.polList.length>0){   
                          $scope.salesRpt.pol ='';
                         angular.forEach($scope.salesRpt.lpolList, function (item, key) {
                             if(ct==""){
                                 ct = "'"+item.id+"'";
                             }else{
                                 ct +=",'"+ item.id+"'";
                             }       
                             $scope.salesRpt.pol = ct;
                         });
                      }else{
                          $scope.salesRpt.pol = '';
                      }
                    }
                  });
                $("#lpol").parent().find('.btn-group #multiselect-button').addClass('width_100 input-sm line-height-5'); 
                
                }, 2, false);
            
            $timeout(function() { 
                $("#lpod").multiselect({
                    maxHeight: 200,
                    includeSelectAllOption: true,
                    selectAllText: 'Select All',
                    enableFiltering: true,
                    enableCaseInsensitiveFiltering: true,
                    filterPlaceholder: 'Search',
                    onChange: function(element, checked) {
                        debugger;
                        var ct=""; 
                      if($scope.polList.length>0){   
                          $scope.salesRpt.pod ='';
                         angular.forEach($scope.salesRpt.lpod, function (item, key) {
                             if(ct==""){
                                 ct = "'"+item.id+"'";
                             }else{
                                 ct +=",'"+ item.id+"'";
                             }       
                             $scope.salesRpt.pod = ct;
                         });
                      }else{
                          $scope.salesRpt.pod = '';
                      }
                    }
                  });
                $("#lpod").parent().find('.btn-group #multiselect-button').addClass('width_100 input-sm line-height-5'); 
                
                }, 2, false);
        }).error(function(data) {
        });

    }
    $scope.getDropDownList();
    
    $scope.getVessel = function(voyageCode) {
        salesRptService.vessel(voyageCode).then(function(result) {
            $scope.vessel = result.data[0].id;
        });
    }

    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.subGroupList = [];
    $scope.companyList = [];
    $scope.fileName = '';

    $scope.getDropDownList = function() {
        $http.get('app/salesRpt/getSubGroupList').success(function(data) {
            $scope.subGroupList = data;
        }).error(function(data) {
        });

        $http.get('app/salesRpt/getCompanyList').success(function(data) {
            $scope.companyList = data;
        }).error(function(data) {
        });
    };

    $scope.getDropDownList();

    $scope.submit = function() {
        if ($scope.isRelatedParty)
            $scope.splitRelatedParty();
        else
            $scope.viewTrialBalanceReport();
    }

    $scope.viewTrialBalanceReport = function() {
        debugger;

        $scope.salesRpt.fromDate = $('#fromDate').val();
        $scope.salesRpt.toDate = $('#toDate').val();
        if ($scope.salesRpt.toDate != '' && $scope.salesRpt.fromDate != '' && $scope.salesRpt.companyCode != '') {
            $http.post('app/salesRpt/getTrialBalanceReport', $scope.salesRpt).success(function(data) {
                if (data.success) {
                    debugger;
                    console.log(data.lTrialBalanceSGLevelList);
                    $("#salesRptGrid").jqGrid('clearGridData');
                    $scope.populateTrialBalanceGrid(data.lTrialBalanceSGLevelList);
                } else {

                }

            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        } else {
            if (($scope.salesRpt.toDate == '' || $scope.salesRpt.fromDate == '') && $scope.salesRpt.companyCode == '')
                logger.logError("Please select Company and valid date range");
            else if ($scope.salesRpt.companyCode == '')
                logger.logError("Please select Company");
            else if ($scope.salesRpt.toDate == '' && $scope.salesRpt.fromDate == '')
                logger.logError("Please select valid date range");
        }
    };

    $scope.splitRelatedParty = function() {
        debugger;
        $scope.salesRpt.relatedParty = 'Y';
        $scope.salesRpt.fromDate = $('#fromDate').val();
        $scope.salesRpt.toDate = $('#toDate').val();
        if ($scope.salesRpt.toDate != '' && $scope.salesRpt.fromDate != '' && $scope.salesRpt.companyCode != '') {
            $http.post('app/salesRpt/getTrialBalanceReportRPSplitup', $scope.salesRpt).success(function(data) {
                if (data.success) {
                    debugger;
                    console.log(data.lTrialBalanceSGLevelList);
                    $("#salesRptGrid").jqGrid('clearGridData');
                    $scope.populateTrialBalanceGrid(data.lTrialBalanceSGLevelList);
                } else {

                }

            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        } else {
            if (($scope.salesRpt.toDate == '' || $scope.salesRpt.fromDate == '') && $scope.salesRpt.companyCode == '')
                logger.logError("Please select Company and valid date range");
            else if ($scope.salesRpt.companyCode == '')
                logger.logError("Please select Company");
            else if ($scope.salesRpt.toDate == '' && $scope.salesRpt.fromDate == '')
                logger.logError("Please select valid date range");
        }
    };

    $scope.exportExcel = function(salesRpt) {

        console.log("Check 0 ");
        console.log(salesRpt);

        $scope.salesRpt.fromDate = $('#fromDate').val();
        $scope.salesRpt.toDate = $('#toDate').val();
        if ($scope.salesRpt.vessel != null && $scope.salesRpt.vessel != undefined && $scope.salesRpt.vessel != '') {
            $scope.salesRpt.vessel = $scope.salesRpt.vessel.id;
        }
        if ($scope.salesRpt.voyage != null && $scope.salesRpt.voyage != undefined && $scope.salesRpt.voyage != '') {
            $scope.salesRpt.voyage = $scope.salesRpt.voyage.id;
        }
        /*
         * if ($scope.salesRpt.pol != null && $scope.salesRpt.pol != undefined &&
         * $scope.salesRpt.pol != '') { //$scope.salesRpt.pol =
         * $scope.salesRpt.pol.id; $scope.salesRpt.polList=$scope.salesRpt.pol; }
         * if ($scope.salesRpt.pod != null && $scope.salesRpt.pod != undefined &&
         * $scope.salesRpt.pod != '') { //$scope.salesRpt.pod =
         * $scope.salesRpt.pod.id; $scope.salesRpt.podList=$scope.salesRpt.pod; }
         */
        $scope.salesRpt.options = 'both';

        // if($scope.salesRpt.toDate !='' && $scope.salesRpt.fromDate != ''){
        $http.post('app/salesRpt/exportToExcel', $scope.salesRpt).success(function(data) {
            if (data) {

                $scope.fileName = data.fileName + '.zip';
                $timeout(function() {
                    $("#RPTExport").bind('click', function() {
                    });
                    $('#RPTExport').simulateClick('click');
                }, 200);

                logger.logSuccess("Exported successfully!");

            } else {
                logger.logSuccess("Failed to export");
            }

        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
        /*
         * }else{ if(($scope.salesRpt.toDate =='' || $scope.salesRpt.fromDate ==
         * '') && $scope.salesRpt.companyCode =='') logger.logError("Please
         * select Company and valid date range"); else
         * if($scope.salesRpt.companyCode =='') logger.logError("Please select
         * Company"); else if($scope.salesRpt.toDate =='' &&
         * $scope.salesRpt.fromDate == '') logger.logError("Please select valid
         * date range"); }
         */
        $scope.getVesselList();
        $scope.getDefaultPort();
    }
    $scope.oldExportExcel = function(salesRpt) {

        console.log("Check 0 ");
        console.log(salesRpt);

        $scope.salesRpt.fromDate = $('#fromDate').val();
        $scope.salesRpt.toDate = $('#toDate').val();
        if ($scope.salesRpt.vessel != null && $scope.salesRpt.vessel != undefined && $scope.salesRpt.vessel != '') {
            $scope.salesRpt.vessel = $scope.salesRpt.vessel.id;
        }
        if ($scope.salesRpt.voyage != null && $scope.salesRpt.voyage != undefined && $scope.salesRpt.voyage != '') {
            $scope.salesRpt.voyage = $scope.salesRpt.voyage.id;
        }
        /*
         * if ($scope.salesRpt.pol != null && $scope.salesRpt.pol != undefined &&
         * $scope.salesRpt.pol != '') { //$scope.salesRpt.pol =
         * $scope.salesRpt.pol.id; $scope.salesRpt.polList=$scope.salesRpt.pol; }
         * if ($scope.salesRpt.pod != null && $scope.salesRpt.pod != undefined &&
         * $scope.salesRpt.pod != '') { //$scope.salesRpt.pod =
         * $scope.salesRpt.pod.id; $scope.salesRpt.podList =
         * $scope.salesRpt.pod; }
         */

        $scope.salesRpt.options = 'old';
        // if($scope.salesRpt.toDate !='' && $scope.salesRpt.fromDate != ''){
        $http.post('app/salesRpt/exportToExcel', $scope.salesRpt).success(function(data) {
            if (data) {

                $scope.fileName = data.fileName + '.zip';
                $timeout(function() {
                    $("#RPTExport").bind('click', function() {
                    });
                    $('#RPTExport').simulateClick('click');
                }, 200);

                logger.logSuccess("Exported successfully!");
            } else {
                logger.logSuccess("Failed to export");
            }

        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
        /*
         * }else{ if(($scope.salesRpt.toDate =='' || $scope.salesRpt.fromDate ==
         * '') && $scope.salesRpt.companyCode =='') logger.logError("Please
         * select Company and valid date range"); else
         * if($scope.salesRpt.companyCode =='') logger.logError("Please select
         * Company"); else if($scope.salesRpt.toDate =='' &&
         * $scope.salesRpt.fromDate == '') logger.logError("Please select valid
         * date range"); }
         */
        $scope.getVesselList();
        $scope.getDefaultPort();
    }

    $scope.newExportExcel = function(salesRpt) {

        console.log("Check 0 ");
        console.log(salesRpt);

        $scope.salesRpt.fromDate = $('#fromDate').val();
        $scope.salesRpt.toDate = $('#toDate').val();
        if ($scope.salesRpt.vessel != null && $scope.salesRpt.vessel != undefined && $scope.salesRpt.vessel != '') {
            $scope.salesRpt.vessel = $scope.salesRpt.vessel.id;
        }
        if ($scope.salesRpt.voyage != null && $scope.salesRpt.voyage != undefined && $scope.salesRpt.voyage != '') {
            $scope.salesRpt.voyage = $scope.salesRpt.voyage.id;
        }

        $scope.salesRpt.options = 'new';
        // if($scope.salesRpt.toDate !='' && $scope.salesRpt.fromDate != ''){
        $http.post('app/salesRpt/exportToExcel', $scope.salesRpt).success(function(data) {
            if (data) {

                $scope.fileName = data.fileName + '.zip';
                $timeout(function() {
                    $("#RPTExport").bind('click', function() {
                    });
                    $('#RPTExport').simulateClick('click');
                }, 200);

                logger.logSuccess("Exported successfully!");

                $scope.salesRpt = {
                    sector : '',
                    vessel : '',
                    voyage : '',
                    pol : '',
                    pod : '',
                    slot : '',
                    serviceHub : 'Consolidated',
                    fromDate : '',
                    toDate : '',
                    options : '',
                    polList : [],
                    podList : []
                }

            } else {
                logger.logSuccess("Failed to export");
            }

        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
        /*
         * }else{ if(($scope.salesRpt.toDate =='' || $scope.salesRpt.fromDate ==
         * '') && $scope.salesRpt.companyCode =='') logger.logError("Please
         * select Company and valid date range"); else
         * if($scope.salesRpt.companyCode =='') logger.logError("Please select
         * Company"); else if($scope.salesRpt.toDate =='' &&
         * $scope.salesRpt.fromDate == '') logger.logError("Please select valid
         * date range"); }
         */
        $scope.defaultvesselist = [];
        $scope.defaultvoyageList = [];
        $scope.getVesselList();
        $scope.getDefaultPort();

    }

    $scope.exportTBExcelRPSplitup = function() {
        debugger;
        $scope.salesRpt.fromDate = $('#fromDate').val();
        $scope.salesRpt.toDate = $('#toDate').val();
        if ($scope.salesRpt.toDate != '' && $scope.salesRpt.fromDate != '' && $scope.salesRpt.companyCode != '') {
            $http.post('app/salesRpt/exportTBExcelSplitRP', $scope.salesRpt).success(function(data) {
                if (data) {
                    debugger;
                    /*
                     * $("#TBExport").bind('click', function() { });
                     * $('#TBExport').simulateClick('click');
                     */
                    $(document).ready(function() {
                        $('#RPTExport').click();
                    });

                    logger.logSuccess("Exported successfully!");
                } else {
                    logger.logSuccess("Failed to export");
                }

            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        } else {
            if (($scope.salesRpt.toDate == '' || $scope.salesRpt.fromDate == '') && $scope.salesRpt.companyCode == '')
                logger.logError("Please select Company and valid date range");
            else if ($scope.salesRpt.companyCode == '')
                logger.logError("Please select Company");
            else if ($scope.salesRpt.toDate == '' && $scope.salesRpt.fromDate == '')
                logger.logError("Please select valid date range");
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

    $scope.populateTrialBalanceGrid = function(sgListData) {
        debugger;
        var data = [];
        $("#salesRptGrid").jqGrid({
            data : sgListData,
            datatype : "local",
            multiboxonly : true,
            autowidth : true,
            height : '100%',
            rowList : [ 10, 20, 30 ],
            multiselect : false,
            loadonce : true,
            gridview : true,
            colNames : [ 'Sub Group Head Code', 'Sub Group Head Name', 'Debit', 'Credit', 'Balance', 'Related Party' ],
            colModel : [ {
                name : 'subGroupCode',
                index : 'subGroupCode',
                width : 80,
                align : "left",
                searchoptions : {
                    sopt : [ 'cn' ]
                },
                classes : 'level_class1'
            }, {
                name : 'subGroupName',
                index : 'subGroupName',
                width : 80,
                align : "left",
                searchoptions : {
                    sopt : [ 'cn' ]
                },
                hidden : false,
                classes : 'level_class1'
            }, {
                name : 'debitAmount',
                index : 'debitAmount',
                width : 80,
                align : "right",
                searchoptions : {
                    sopt : [ 'cn' ]
                },
                hidden : false,
                classes : 'level_class1'
            }, {
                name : 'creditAmount',
                index : 'creditAmount',
                width : 80,
                align : "right",
                searchoptions : {
                    sopt : [ 'cn' ]
                },
                hidden : false,
                classes : 'level_class1'
            }, {
                name : 'currentBalance',
                index : 'currentBalance',
                width : 80,
                align : "right",
                searchoptions : {
                    sopt : [ 'cn' ]
                },
                hidden : false,
                classes : 'level_class1'
            }, {
                name : 'relatedParty',
                index : 'relatedParty',
                width : 80,
                align : "right",
                searchoptions : {
                    sopt : [ 'cn' ]
                },
                hidden : true,
                classes : 'level_class1'
            }, ],
            pager : "#plReportGridPage",
            viewrecords : true,
            ignoreCase : true,
            subGrid : true,
            subGridOptions : {
                "plusicon" : 'ui-icon-plus',
                "minusicon" : 'ui-icon-minus'
            },
            footerrow : true,

            loadComplete : function() {
                var $grid = $('#salesRptGrid');
                var credit = $grid.jqGrid('getCol', 'creditAmount', false, 'sum');
                var debit = $grid.jqGrid('getCol', 'debitAmount', false, 'sum');
                var difference = debit - credit;
                $(this).jqGrid('footerData', 'set', {
                    subGroupName : 'Total',
                    creditAmount : credit,
                    debitAmount : debit,
                    currentBalance : difference
                });

                var celValue = $('#salesRptGrid').getCol('subGroupCode', true);
                var grid = $('#salesRptGrid');
                if (celValue != undefined) {
                    debugger;
                    for ( var i = 0; i < celValue.length; i++) {
                        var highlightid = celValue[i].id;
                        var highlightvalue = celValue[i].value;
                        if (highlightvalue == "RELATED PARTY") {
                            $("#salesRptGrid").jqGrid('setCell', highlightid, "subGroupCode", "", {
                                'background-color' : '#FFFF00',
                                'color' : '#000000',
                                'background-image' : 'none',
                                'opacity' : '0.75'
                            });
                            $("#salesRptGrid").jqGrid('setCell', highlightid, "subGroupName", "", {
                                'background-color' : '#FFFF00',
                                'color' : '#FFFF00',
                                'background-image' : 'none',
                                'opacity' : '0.75'
                            });
                            $("#salesRptGrid").jqGrid('setCell', highlightid, "debitAmount", "", {
                                'background-color' : '#FFFF00',
                                'color' : '#FFFF00',
                                'background-image' : 'none',
                                'opacity' : '0.75'
                            });
                            $("#salesRptGrid").jqGrid('setCell', highlightid, "creditAmount", "", {
                                'background-color' : '#FFFF00',
                                'color' : '#FFFF00',
                                'background-image' : 'none',
                                'opacity' : '0.75'
                            });
                            $("#salesRptGrid").jqGrid('setCell', highlightid, "currentBalance", "", {
                                'background-color' : '#FFFF00',
                                'color' : '#FFFF00',
                                'background-image' : 'none',
                                'opacity' : '0.75'
                            });
                            $("#salesRptGrid").jqGrid('setCell', highlightid, "creditAmount", "");
                            $('tr#' + highlightid, grid).children("td.sgcollapsed").html("").removeClass('ui-sgcollapsed sgcollapsed');
                        }

                    }
                }
            },

            subGridRowExpanded : function(subgrid_id, row_id) {
                debugger;
                var subgrid_table_id, pager_id;
                subgrid_table_id = subgrid_id + "_t";
                pager_id = "p_" + subgrid_table_id;
                var rowData = jQuery('#salesRptGrid').jqGrid('getRowData', row_id);
                $scope.salesRpt.filterCode = rowData.subGroupCode;
                var Ahurl = '';
                if ($scope.salesRpt.relatedParty == 'N') {
                    Ahurl = 'app/salesRpt/getTrialBalanceAHLevel';
                } else {
                    if (rowData.relatedParty == 'Y')
                        Ahurl = 'app/salesRpt/getTrialBalanceAHLevelRPonly';
                    else
                        Ahurl = 'app/salesRpt/getTrialBalanceAHLevelExcludeRp';
                }

                $("#" + subgrid_id).html("<table id='" + subgrid_table_id + "' class='scroll'></table><div id='" + pager_id + "' class='scroll'></div>");
                $http.post(Ahurl, $scope.salesRpt).success(function(data) {
                    if (data.success) {
                        debugger;
                        var tbAHlevelDataList = data.lTrialBalanceAHLevelList;
                        $("#" + subgrid_table_id).jqGrid({
                            datatype : "local",
                            data : tbAHlevelDataList,
                            colNames : [ 'Acct Head Code', 'Acct Head Name', 'Opening Bal', 'Debit', 'Credit', 'Current Bal', 'Related Party' ],
                            colModel : [ {
                                name : 'acctHeadCode',
                                index : 'acctHeadCode',
                                width : 200,
                                align : "left",
                                searchoptions : {
                                    sopt : [ 'cn' ]
                                },
                                classes : 'level_class2'
                            }, {
                                name : 'acctHeadName',
                                index : 'acctHeadName',
                                width : 200,
                                align : "left",
                                searchoptions : {
                                    sopt : [ 'cn' ]
                                },
                                hidden : false,
                                classes : 'level_class2'
                            }, {
                                name : 'openingBalance',
                                index : 'openingBalance',
                                width : 200,
                                align : "right",
                                searchoptions : {
                                    sopt : [ 'cn' ]
                                },
                                hidden : false,
                                classes : 'level_class2'
                            }, {
                                name : 'debitAmount',
                                index : 'debitAmount',
                                width : 200,
                                align : "right",
                                searchoptions : {
                                    sopt : [ 'cn' ]
                                },
                                hidden : false,
                                classes : 'level_class2'
                            }, {
                                name : 'creditAmount',
                                index : 'creditAmount',
                                width : 200,
                                align : "right",
                                searchoptions : {
                                    sopt : [ 'cn' ]
                                },
                                hidden : false,
                                classes : 'level_class2'
                            }, {
                                name : 'currentBalance',
                                index : 'currentBalance',
                                width : 200,
                                align : "right",
                                searchoptions : {
                                    sopt : [ 'cn' ]
                                },
                                hidden : false,
                                classes : 'level_class2'
                            }, {
                                name : 'relatedParty',
                                index : 'relatedParty',
                                width : 80,
                                align : "right",
                                searchoptions : {
                                    sopt : [ 'cn' ]
                                },
                                hidden : true,
                                classes : 'level_class2'
                            }, ],
                            autowidth : true,
                            height : '100%',
                            pager : pager_id,
                            sortname : 'num',
                            sortorder : "asc",
                            // transaction level
                            subGrid : true,
                            subGridOptions : {
                                "plusicon" : 'ui-icon-plus',
                                "minusicon" : 'ui-icon-minus'
                            },

                            subGridRowExpanded : function(subgrid_child_id, row_id) {
                                debugger;
                                var subgridchild_table_id, pager_id;
                                subgridchild_table_id = subgrid_child_id + "_t";
                                pager_id = "p_" + subgridchild_table_id;
                                var ahrowData = jQuery('#' + subgrid_table_id).jqGrid('getRowData', row_id);
                                $scope.salesRpt.acctHeadCode = ahrowData.acctHeadCode;
                                var transactionURL = '';
                                if ($scope.salesRpt.relatedParty == 'N') {
                                    transactionURL = 'app/salesRpt/getTrialBalanceTransactionLevel';
                                } else {
                                    if (ahrowData.relatedParty == 'Y')
                                        transactionURL = 'app/salesRpt/getTrialBalanceTransactionLevelRPonly';
                                    else
                                        transactionURL = 'app/salesRpt/getTrialBalanceTransactionLevelExcludeRP';
                                }

                                $("#" + subgrid_child_id).html("<table id='" + subgridchild_table_id + "' class='scroll'></table><div id='" + pager_id + "' class='scroll'></div>");
                                $http.post(transactionURL, $scope.salesRpt).success(function(data) {
                                    if (data.success) {
                                        debugger;
                                        var tbTransactionlevelDataList = data.lTrialBalanceTransactionLevelList;
                                        $("#" + subgridchild_table_id).jqGrid({
                                            datatype : "local",
                                            data : tbTransactionlevelDataList,
                                            colNames : [ 'Transaction No', 'Ledger Dt', 'Opening Bal', 'Debit', 'Credit', 'Current Bal' ],
                                            colModel : [ {
                                                name : 'transactionNo',
                                                index : 'transactionNo',
                                                width : 200,
                                                align : "left",
                                                searchoptions : {
                                                    sopt : [ 'cn' ]
                                                },
                                                classes : 'level_class3'
                                            }, {
                                                name : 'ledgerDate',
                                                index : 'ledgerDate',
                                                width : 200,
                                                align : "left",
                                                searchoptions : {
                                                    sopt : [ 'cn' ]
                                                },
                                                hidden : false,
                                                classes : 'level_class3'
                                            }, {
                                                name : 'openingBalance',
                                                index : 'openingBalance',
                                                width : 200,
                                                align : "right",
                                                searchoptions : {
                                                    sopt : [ 'cn' ]
                                                },
                                                hidden : false,
                                                classes : 'level_class3'
                                            }, {
                                                name : 'debitAmount',
                                                index : 'debitAmount',
                                                width : 200,
                                                align : "right",
                                                searchoptions : {
                                                    sopt : [ 'cn' ]
                                                },
                                                hidden : false,
                                                classes : 'level_class3'
                                            }, {
                                                name : 'creditAmount',
                                                index : 'creditAmount',
                                                width : 200,
                                                align : "right",
                                                searchoptions : {
                                                    sopt : [ 'cn' ]
                                                },
                                                hidden : false,
                                                classes : 'level_class3'
                                            }, {
                                                name : 'currentBalance',
                                                index : 'currentBalance',
                                                width : 200,
                                                align : "right",
                                                searchoptions : {
                                                    sopt : [ 'cn' ]
                                                },
                                                hidden : false,
                                                classes : 'level_class3'
                                            }, ],
                                            autowidth : true,
                                            height : '100%',
                                            pager : pager_id,
                                            sortname : 'num',
                                            sortorder : "asc",
                                        }).jqGrid('setGridParam', {
                                            data : tbTransactionlevelDataList
                                        }).trigger("reloadGrid");
                                    }

                                }).error(function(tbAHlevelDataList) {
                                });
                            }
                        }).jqGrid('setGridParam', {
                            data : tbAHlevelDataList
                        }).trigger("reloadGrid");
                    }

                }).error(function(tbAHlevelDataList) {
                });
            }
        }).jqGrid('setGridParam', {
            data : sgListData
        }).trigger("reloadGrid");

    }

});

app.factory('salesRptService', function($http) {

    return {
        dropDownList : function() {
            return $http.get('app/loadingSummary/dropDownList').then(function(result) {
                return result;
            });
        },
        dropDownCustList : function() {
            return $http.get('app/commonUtility/dropDownList').then(function(result) {
                return result;
            });
        },
        voyageList : function(vesselCode) {
            var url = 'app/loadingSummary/voyageList?vesselCode=' + vesselCode;
            return $http.get(url).then(function(result) {
                return result;
            });
        },
        vessel : function(voyageCode) {
            var url = 'app/loadingSummary/vesselList?voyageCode=' + voyageCode;
            return $http.get(url).then(function(result) {
                return result;
            });
        },
        port : function(voyageCode) {
            var url = 'app/salesRpt/voyagePort?voyageCode=' + voyageCode;
            return $http.get(url).then(function(result) {
                return result;
            });
        },

        defaultPort : function() {
            var url = 'app/salesRpt/defaultPortList';
            return $http.get(url).then(function(result) {
                console.log(result);
                return result;
            });
        }
    }

});
