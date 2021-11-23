//define([ 'hospital/accounts/accounts', 'jqGrid' ], function(module) {

  ///  'use strict';
    app.controller('balanceSheetListCtrl', function($scope, $state, $stateParams,$http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, $window, validationService) {
        $scope.balsheet = {
            fromDate : '',
            company : 'C0002',
		    costCenter:''

        }
        $scope.currentPeriodEarning='';
        $scope.totalLiablities='';
        $scope.totalAsset='';
        $scope.totalAssetWithCurrent='';

        
        
        $('#bs_fromDate').datetimepicker({
			format : 'DD/MM/YYYY',
			pickTime : false
		});
        $http.get($stateParams.tenantid+'/app/commonUtility/getCompanyList').success(function(data) {
//            $scope.companyList = data;

            $scope.companyList = [
                 {id: 'ALL', text: 'ALL'}
                 ]
            angular.forEach(data, function(row,index){
                
                $scope.companyList.push(row);

            })
             
            
//            var data = {};
//            data["id"] = "ALL";
//            data["text"] = "ALL";
//            $scope.companyList.push(data);
        }).error(function(data) {
        });


     /*   $http.get('app/balanceSheet/getCompanyList').success(function(datas) {
            $scope.companyList = datas;
        }).error(function(datas) {
        });*/
        
      //Excel PDF       
    	 $scope.exportPDF = function(){
    		  var flag = false;
    		  //if(bean.port != "" && bean.port != undefined && bean.port != null){
    	       // $scope.balsheet.fromDate = $('#fromDate').val();
    	//        $scope.balsheet.toDate = $('#toDate').val();
   	     	   	 $http.post('app/balanceSheet/ExportPDF',$scope.balsheet).success(function(response) {

    	                if(response){
    	                    debugger;
    	                    $("#exportPDF").bind('click', function() {
    	                    	
    	                    });
    	                    $('#exportPDF').simulateClick('click');
    	                    logger.logSuccess("Exported successfully!");
    	                }else{
   					        logger.logError(response.message);
    	                }
    	                
    	            }).error(function(response) {
    	                logger.logError("Error Please Try Again");
    	            });
   	     	   	 
    	      
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
    	    

        $scope.excelBSExport = function() {
            $http.post('app/balanceSheet/excelBSExport', $scope.balsheet).success(function(data) {
                if (data.success) {
                    $window.open(data.filePath);
                }
            }).error(function(datas) {
                logger.logError("No Records Found");

            });
        }

        $scope.generateBalanceSheetReport = function(permanentprobationhead) {
            
            if (new validationService().checkFormValidity(permanentprobationhead)) {
                $scope.lGroupHeadLevelAssetList=[];
                $scope.lGroupHeadLevelLiabilitiesList=[];

                $http.post('app/balanceSheet/generateBalanceSheetReport', $scope.balsheet).success(function(datas) {
                    $scope.lGroupHeadLevelAssetList=datas.lGroupHeadLevelList;
                    $scope.lGroupHeadLevelLiabilitiesList=datas.lGroupHeadLevelLiabilitiesList;
                    
                    $scope.currentPeriodEarning=datas.currentPeriodEarning;
                    $scope.totalLiablities=datas.totalLiablities+datas.currentPeriodEarning;
                    $scope.totalAsset=datas.totalAsset;
                    $scope.totalAssetWithCurrent=datas.totalAsset;

                    
                }).error(function(datas) {
                });
            } else {
                toaster.pop('Error', "Please Fill The Required Fields", logger.getErrorHtmlNew(permanentprobationhead.$validationSummary), 5000, 'trustedHtml');
            }
        }

 $scope.costList =[];
        
        
        
        $scope.$watch('balsheet.company', function(newValue, oldValue) {
            //  alert(newValue);
               if(newValue!=null && newValue!=undefined && newValue != ''){
               //    $http.post($stateParams.tenantid+ '/app/commonUtility/getVoyageListByVessel',newValue).success(function(data) {
                    $http.get('app/purchaseinvoice/getcompanycost?company=' + $scope.balsheet.company).success(function(data) {

                        $scope.balsheet.company = newValue;


                         if(data.length > 0)
                       {
                       $scope.costList = data;
                       }
                         else{
                             
                             logger.logError("Not Available");
                             
                         }
                   });
               }
             });
        
        $scope.populateBalanceSheetGrid = function(data) {
            $("#balanceSheetGrid").GridUnload();
            $("#balanceSheetGrid").jqGrid({
                data : data,
                datatype : "local",
                multiboxonly : true,
                autowidth : true,
                autoheight : true,
                rowList : [ 5, 10, 20 ],
                gridview : true,
                multiselect : true,
                multiboxonly : false,
                colNames : [ 'Group Code', 'Group Name', 'Balance' ],
                colModel : [ {
                    name : 'groupHeadCode',
                    index : 'groupHeadCode',
                    width : 100,
                    align : "left",
                    sorttype : 'text',
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    resizable : false
                },// Added for avoid resizing the grid.
                {
                    name : 'groupHeadName',
                    index : 'groupHeadName',
                    width : 400,
                    align : "left",
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    resizable : false,
                    sorttype : 'text'
                }, {
                    name : 'balance',
                    index : 'balance',
                    width : 250,
                    align : "right",
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    resizable : false,
                    sorttype : 'number'
                }

                ],
                loadOnce : true,
                pager : '#masterBalancePage',
                height : '100%',
                rowNum : 10,
                subGrid : true,
                subGridOptions : {
                    "plusicon" : 'fa fa-plus-circle',
                    "minusicon" : 'fa fa-minus-circle'
                },
                gridComplete: function(){ 
                    var rowIds = $("#jqgrid_id").getDataIDs();
                    $.each(rowIds, function (index, rowId) {
                      $("#jqgrid_id").expandSubGridRow(rowId); 
                    });
                 },
                subGridRowExpanded : function(subgrid_id, row_id) {
                    var subgrid_table_id, pager_id;
                    subgrid_table_id = subgrid_id + "_t";
                    pager_id = "p_" + subgrid_table_id;
                    var rowData = jQuery('#balanceSheetGrid').jqGrid('getRowData', row_id);
                    $("#" + subgrid_id).html("<table id='" + subgrid_table_id + "' class='scroll'></table><div id='" + pager_id + "' class='scroll'></div>");
                    var mainCode;

                    if (rowData.groupHeadCode == 'A')
                        mainCode = '100%'
                    else
                        mainCode = '200%'
                    $scope.balsheet.groupHeadCode = mainCode;

                    var subdata = [];
                    $http.post('app/balanceSheet/generateBalanceSheetReportDtl', $scope.balsheet).success(function(datas) {

                        subdata = datas;

                        $("#" + subgrid_table_id).jqGrid({
                            datatype : "local",
                            data : subdata,
                            colNames : [ 'Account Code', 'Account Name', 'Balance' ],
                            colModel : [ {
                                name : 'groupHeadCode',
                                index : 'groupHeadCode',
                                width : 100,
                                align : "left",
                                sorttype : 'text',
                                searchoptions : {
                                    sopt : [ 'cn' ]
                                },
                                resizable : false
                            }, {
                                name : 'groupHeadName',
                                index : 'groupHeadName',
                                width : 400,
                                align : "left",
                                searchoptions : {
                                    sopt : [ 'cn' ]
                                },
                                resizable : false,
                                sorttype : 'text'
                            }, {
                                name : 'balance',
                                index : 'balance',
                                width : 250,
                                align : "right",
                                searchoptions : {
                                    sopt : [ 'cn' ]
                                },
                                resizable : false,
                                sorttype : 'number'
                            } ],
                            rowNum : 20,
                            pager : pager_id,
                            sortname : 'num',
                            sortorder : "asc",
                            height : '100%',
                            subGrid : true,
                            subGridOptions : {
                                "plusicon" : 'fa fa-plus-circle',
                                "minusicon" : 'fa fa-minus-circle'
                            },
                            subGridRowExpanded : function(subgridah_id, rowah_id) {

                                var subgridah_table_id, pagerah_id;
                                subgridah_table_id = subgridah_id + "_t";
                                pagerah_id = "p_" + subgridah_table_id;
                                var rowData = jQuery('#' + subgrid_table_id).jqGrid('getRowData', rowah_id);
                                $("#" + subgridah_id).html("<table id='" + subgridah_table_id + "' class='scroll'></table><div id='" + pagerah_id + "' class='scroll'></div>");

                                $scope.balsheet.groupHeadCode = rowData.groupHeadCode;

                                var subahdata = [];
                                $http.post('app/balanceSheet/generateBalanceSheetReportAHDtl', $scope.balsheet).success(function(datas) {

                                    subahdata = datas;

                                    $("#" + subgridah_table_id).jqGrid({
                                        datatype : "local",
                                        data : subahdata,
                                        colNames : [ 'Account Code', 'Account Name', 'Balance' ],
                                        colModel : [ {
                                            name : 'groupHeadCode',
                                            index : 'groupHeadCode',
                                            width : 100,
                                            align : "left",
                                            sorttype : 'text',
                                            searchoptions : {
                                                sopt : [ 'cn' ]
                                            },
                                            resizable : false
                                        }, {
                                            name : 'groupHeadName',
                                            index : 'groupHeadName',
                                            width : 400,
                                            align : "left",
                                            searchoptions : {
                                                sopt : [ 'cn' ]
                                            },
                                            resizable : false,
                                            sorttype : 'text'
                                        }, {
                                            name : 'balance',
                                            index : 'balance',
                                            width : 250,
                                            align : "right",
                                            searchoptions : {
                                                sopt : [ 'cn' ]
                                            },
                                            resizable : false,
                                            sorttype : 'number'
                                        } ],
                                        rowNum : 20,
                                        pager : pagerah_id,
                                        sortname : 'num',
                                        sortorder : "asc",
                                        height : '100%'
                                    }).jqGrid('setGridParam', {
                                        data : subahdata
                                    }).trigger("reloadGrid");
                                    $("#" + subgridah_table_id).jqGrid('navGrid', "#" + pagerah_id, {
                                        edit : false,
                                        search : false,
                                        refresh : false,
                                        add : false,
                                        del : false
                                    });

                                }).error(function(datas) {
                                });

                            }
                        }).jqGrid('setGridParam', {
                            data : subdata
                        }).trigger("reloadGrid");
                        $("#" + subgrid_table_id).jqGrid('navGrid', "#" + pager_id, {
                            edit : false,
                            search : false,
                            refresh : false,
                            add : false,
                            del : false
                        });

                    }).error(function(datas) {
                    });
                }
            });
            $("#balanceSheetGrid").jqGrid('navGrid', '#masterBalancePage', {
                edit : false,
                add : false,
                del : false,
                search : false,
                refresh : true
            });

        }

    //});

});