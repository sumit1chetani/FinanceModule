//define([ 'hospital/accounts/accounts', 'jqGrid' ], function(module) {

    'use strict';

    app.controller('bankbookCtrl', function($scope, $state,$stateParams, $http, $location, ngDialog, logger,$timeout) {

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
                pmtType:''
              
        };
 $scope.list = {
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
                 $http.get( $stateParams.tenantid +'/app/commonUtility/getCompanyList').success(function(data) {

                 $scope.companyList = data;
                 var data = {};
            data["id"] = "All";
            data["text"] = "ALL";
            $scope.companyList.push(data);
                 })
}
                 
                 
                 
                 $scope.getcompanyList();
                 
                 
                 
                 $scope.pmtTypeList = [ {
                	 
                     id : 'bank',
                     text : 'Bank'
                 }, {
                     id : 'cash',
                     text : 'Cash'
                 } ]
        
                 $scope.inventoryList = function(){ 
                if($scope.generalLedger.companyCode !='' && $scope.generalLedger.toDate !='' && $scope.generalLedger.fromDate != ''){

                 $scope.$watch('generalLedger.pmtType', function(newValue, oldValue) {
                	
                     //  alert(newValue);
                	 $scope.generalLedger.type=  newValue;

                        if(newValue!='' && newValue!=undefined){
                        	
                        	
                        	//$scope.inventoryList = function(){
                                debugger;
                               // $scope.generalLedger.fromDate = $('#fromDate').val();
                               // $scope.generalLedger.toDate = $('#toDate').val();
                             
                                   console.log($scope.generalLedger);
                                  
                                       
                                   $http.post('hospital/accounts/cashBankBook/getGeneralLedgerReport', $scope.generalLedger).success(function(response) {
                                        if(response.success){ 
                        	          $scope.createGrid(response.lCashBankBook);
                                      }else{
                                        }
                                   }).error(function(data) {
                                        logger.logError("Error Please Try Again");
                                   });
                                
                            //};
                        	
                            $scope.getSubGridList = function(parentCode, accountname, subgridDivId) {
                                var acctCode = parentCode + "," + accountname;
                                    $http.post('hospital/accounts/cashBankBook/getData', $scope.generalLedger).success(function(response) {
                                    	var subgridTableId = subgridDivId + "_t";
                                        $("#" + subgridTableId).setGridParam({
                                            data : response.lCashBankBook,
                                            rowNum : response.lCashBankBook.length
                                        }).trigger('reloadGrid');
                                    });
                                };

                               // $scope.inventoryList();
                                $scope.reloadGrid = function(data) {
                                    $('#bankbookGrid').setGridParam({
                                        data : data,
                                        rowNum : data.length
                                    }).trigger('reloadGrid');
                                };
                               
                                

                                $scope.getSubsubGridList = function(parentCode, accountname, subgridDivId_child) {
                                    var acctCode = parentCode + "," + accountname;
                                    $http.post('hospital/accounts/cashBankBook/getSubData', acctCode).success(function(data) {
                                        var subgridTableId_child = subgridDivId_child + "_t";
                                        $("#" + subgridTableId_child).setGridParam({
                                            data : data.lCashBankBook,
                                            rowNum : data.lCashBankBook.length
                                        }).trigger('reloadGrid');
                                    });
                                };
                                
                                
                                $scope.totalInventory = function() {

                                    var prdQty = 0;
                                    var data = $("#bankbookGrid").jqGrid('getGridParam', 'data');
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
                                	 $scope.reloadGrid(inventoryList);
                                	 var companyCode = $("#companyCode").val();

                                     if(companyCode==''){
                                         $scope.currencCode= "(INR)";
                                     }else{
                                         $scope.currencCode= "";
                                     }
                                    $("#bankbookGrid").jqGrid({
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
                                        colNames : [  'Sub Group Head Code', 'Sub Group Head Name','Debit'+$scope.currencCode, 'Credit'+$scope.currencCode,' Balance'+$scope.currencCode ],
                                        colModel : [ {
                                            name : 'parentCode',
                                            index : 'parentCode',
                                            align : 'left',
                                            width : 60,
                                            searchoptions : {
                                                sopt : [ 'cn' ]
                                            },
                                            hidden : false
                                        }, /*{
                                            name : 'accountCode',
                                            index : 'accountCode',
                                            align : 'left',
                                            width : 80,
                                            searchoptions : {
                                                sopt : [ 'cn' ]
                                            },
                                            hidden : false
                                        },*/ {
                                            name : 'accountName',
                                            index : 'accountName',
                                            width : 120,
                                            align : "left",
                                            searchoptions : {
                                                sopt : [ 'cn' ]
                                            }
                                        }, {
                                            name : 'debit',
                                            index : 'debit',
                                            width : 75,
                                            align : "right",
                                            formatter:'currency',formatoptions: { thousandsSeparator:','},
                                            searchoptions : {
                                                sopt : [ 'cn' ]
                                            }
                                        }, {
                                            name : 'credit',
                                            index : 'credit',
                                            align : 'right',
                                            formatter:'currency',formatoptions: { thousandsSeparator:','},
                                            width : 75,
                                            searchoptions : {
                                                sopt : [ 'cn' ]
                                            }
                                        }, {
                                            name : 'currentBalance',
                                            index : 'currentBalance',
                                            width : 115,
                                            align : "right",
                                            formatter:'currency',formatoptions: { thousandsSeparator:','},
                                            searchoptions : {
                                                sopt : [ 'cn' ]
                                            }
                                        }, ],
                                        loadOnce : true,
                                        pager : '#bankbookdiv',
                                        height : '100%',
                                        rowNum : 10,
                                        subGrid : true,
                                        subGridOptions : {
                                            "plusicon" : 'fa fa-plus-circle',
                                            "minusicon" : 'fa fa-minus-circle'
                                        },
                                        subGridRowExpanded : function(subgridDivId, rowId) {

                                            var rowData = $('#bankbookGrid').jqGrid('getRowData', rowId);
                                            $scope.getSubGridList(rowData.parentCode, rowData.accountCode, subgridDivId);
                                            var subgridTableId = subgridDivId + "_t";
                                            var pager_id = "p_" + subgridTableId;
                                            $("#" + subgridDivId).html("<table id='" + subgridTableId + "'></table><div id='" + pager_id + "' class='scroll'></div>");

                                            $("#" + subgridTableId).jqGrid({
                                                datatype : 'local',
                                                data : "",
                                                colNames : [ 'Parent Code', 'Account Code', 'Account Name', 'Debit', 'Credit', 'Balance' ],
                                                colModel : [ {
                                                    name : 'parentCode',
                                                    index : 'parentCode',
                                                    align : 'left',
                                                    width : 320,
                                                    searchoptions : {
                                                        sopt : [ 'cn' ]
                                                    },
                                                    hidden : true
                                                }, {
                                                    name : 'accountCode',
                                                    index : 'accountCode',
                                                    align : 'left',
                                                    width : 320,
                                                    searchoptions : {
                                                        sopt : [ 'cn' ]
                                                    },
                                                    hidden : false
                                                }, {
                                                    name : 'accountName',
                                                    index : 'accountName',
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
                                                    formatter:'currency',formatoptions: { thousandsSeparator:','},
                                                    searchoptions : {
                                                        sopt : [ 'cn' ]
                                                    }
                                                }, {
                                                    name : 'credit',
                                                    index : 'credit',
                                                    align : 'right',
                                                    formatter:'currency',formatoptions: { thousandsSeparator:','},
                                                    width : 300,
                                                    searchoptions : {
                                                        sopt : [ 'cn' ]
                                                    }
                                                }, {
                                                    name : 'currentBalance',
                                                    index : 'currentBalance',
                                                    width : 300,
                                                    formatter:'currency',formatoptions: { thousandsSeparator:','},
                                                    align : "right",
                                                    searchoptions : {
                                                        sopt : [ 'cn' ]
                                                    }
                                                },
                                               ],
                                             //  loadOnce : true,
                                               pager : pager_id,
                                               height : '100%',
                                               rowNum : 10,
                                              subGrid : true,
                                               subGridOptions : {
                                                   "plusicon" : 'fa fa-plus-circle',
                                                   "minusicon" : 'fa fa-minus-circle'
                                               },
                                                autoheight : true,
                                                height : '100%',
                                                sortname : 'num',
                                                sortorder : "asc",
                                                
                                                
                                                subGridRowExpanded : function(subgridDivId_child, rowId) {

                                                      var rowData = $("#" + subgridTableId).jqGrid('getRowData', rowId);
                                                //  var rowData = $("#bankbookGrid").jqGrid('getRowData', rowId);
                                                      $scope.getSubsubGridList(rowData.parentCode, rowData.accountCode, subgridDivId_child);
                                                      var subgridTableId_child = subgridDivId_child + "_t";
                                                      var pager_child_id = "p_" + subgridTableId_child;
                                                      $("#" + subgridDivId_child).html("<table id='" + subgridTableId_child + "'></table><div id='" + pager_child_id + "' class='scroll'></div>");

                                                      $("#" + subgridTableId_child).jqGrid({
                                                          datatype : 'local',
                                                          data : "",
                                                          colNames : [ 'Transaction No', 'Transaction Date', 'Debit', 'Credit' ],
                                                          colModel : [ {
                                                              name : 'transactionNo',
                                                              index : 'transactionNo',
                                                              width : 320,
                                                              searchoptions : {
                                                                  sopt : [ 'cn' ]
                                                              }
                                                          }, {
                                                              name : 'ledgerDate',
                                                              index : 'ledgerDate',
                                                              width : 320,
                                                              align : "left",
                                                              searchoptions : {
                                                                  sopt : [ 'cn' ]
                                                              }
                                                          }, {
                                                              name : 'trnsDebit',
                                                              index : 'trnsDebit',
                                                              width : 320,
                                                              align : "right",
                                                              formatter:'currency',formatoptions: { thousandsSeparator:','},
                                                              searchoptions : {
                                                                  sopt : [ 'cn' ]
                                                              }
                                                          }, {
                                                              name : 'trnsCredit',
                                                              index : 'trnsCredit',
                                                              width : 320,
                                                              align : "right",
                                                              formatter:'currency',formatoptions: { thousandsSeparator:','},
                                                              searchoptions : {
                                                                  sopt : [ 'cn' ]
                                                              }
                                                          } ],
                                                          autoheight : true,
                                                          height : '100%',
                                                          sortname : 'num',
                                                          sortorder : "asc",
                                                          pager: pager_child_id,

                                                      });
                                                  },
                                            });

                                        },
                                        

                                      
                                        
                                        
                                        loadComplete : function() {
                                            $scope.totalInventory();
                                        }
                                        
                                    });
                                    $("#bankbookGrid").jqGrid('navGrid', '#bankbookdiv', {
                                        edit : false,
                                        add : false,
                                        del : false,
                                        search : false,
                                        refresh : false
                                    });

                                    $("#bankbookGrid").jqGrid('filterToolbar', {
                                        searchOperators : true,
                                        searchOnEnter : false
                                    });
                                    $("#bankbookGrid").jqGrid('navButtonAdd', "#bankbookdiv", {
                                        caption : "",
                                        title : "Show/Hide Search box",
                                        buttonicon : 'ui-icon icon-thumb-tack',
                                        onClickButton : function() {
                                            var myGrid = $('#bankbookGrid');
                                            myGrid[0].toggleToolbar();
                                        }
                                    });
                                    $("#bankbookGrid")[0].toggleToolbar();
                                    

                                };

                                
                                
                                
                                
                                
                               
                                
                       
                        }
                        else{
                        	
                            logger.logError("Please select Payment Type");

                        	
                        }
                        
                    
                        
                        
                        
                      });
                 }
                 
    else{
        if( $scope.generalLedger.fromDate == '' && $scope.generalLedger.companyCode =='')
            logger.logError("Please select Company and valid date range");
        else if($scope.generalLedger.companyCode =='')
            logger.logError("Please select Company");
        else if($scope.generalLedger.toDate =='' || $scope.generalLedger.fromDate == '')
            logger.logError("Please select valid date range");
        
    }
                
                
                 
                 
             
                
                 
                 
                 
                
                
       
                 }   
      
       

      

    });

//});