'use strict';
app.controller('tdsReportController', function($templateCache, $scope, $rootScope, $http, logger, $log, ngDialog, 
        $modal, $location, $sce, $filter, $timeout,utilsService,$compile,$stateParams) {

    $('#gl_fromDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime: false
    });
    
    $('#gl_toDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime: false
    });

    $scope.tdsReport = {
            subGroupCode:'',
            groupCode:'',
            companyCode:'',
            fromDate:'',
            toDate:'',
            accountHeadCode:'',
            filterAccountHeadCode:'',
            mainAccountCode:'',
            subAccountCode:'',
            objCompanyCodes:[],
            objGroupCodes:[]
    };

    $scope.formreset = function() {
        debugger;
        $scope.tdsReport = {
                subGroupCode:'',
                groupCode:'',
                companyCode:'',
                fromDate:'',
                toDate:'',
                accountHeadCode:'',
                filterAccountHeadCode:'',
                mainAccountCode:'',
                subAccountCode:'',
                objCompanyCodes:[],
                objGroupCodes:[],
               
                
        };
        
        $timeout(function() {
            $("#txtCompanyCode").multiselect("refresh");
            $("#txtCompanyCode").multiselect({
                maxHeight: 400,
                includeSelectAllOption: true,
                selectAllText: 'Select All',
                enableFiltering: true,
                enableCaseInsensitiveFiltering: true,
                filterPlaceholder: 'Search',
                onChange: function(element, checked) {
                    debugger;
                  var companyCodes = "", jvpShortNames="";
                  if($scope.tdsReport.objCompanyCodes.length>0){
                      angular.forEach($scope.tdsReport.objCompanyCodes, function (item, key) {
                          debugger;
                          if($scope.tdsReport.objCompanyCodes.length>0){
                              debugger;
                              if($scope.tdsReport.objCompanyCodes[key]!=undefined){
                                  
                                  var companyCode = item.id;
                                  
                                  if(companyCodes==""){
                                      companyCodes = item.id;
                                  }else{
                                      companyCodes +=","+ item.id;
                                  }       
                                  $scope.tdsReport.companyCode = companyCodes;
                              }                             
                          }                              
                      });
                  }else{
                      $scope.tdsReport.companyCode = '';
                  }
                  
                }
              });
            
            $("#multiselect-button").addClass("width_100 input-sm line-height-5");
            
            }, 2, false);
    };

    
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.subGroupList = [];
    $scope.companyList = [];
    
    $scope.getDropDownList = function() {
        $http.get($stateParams.tenantid+'/app/trialBalance/getSubGroupList').success(function(data) {
            $scope.subGroupList = data;
        }).error(function(data) {
        });
/*        
        $http.get('app/usermaster/getCompanyList?formCode='+$('#form_code_id').val()).success(function(datas) {
            debugger;           
            $scope.companyList = datas;           
            }).error(function(datas) {
        });*/
        

        $http.get($stateParams.tenantid+'/app/usermaster/getCompanyList?formCode='+$('#form_code_id').val()).success(function(data) {
            console.log("data")
            console.log(data)
            $scope.companyList = data;
       

            
            console.log("company")
            console.log($scope.companyList)
            var foundItemDest = $filter('filter')($scope.companyList, { baseCompany:  1 })[0];
            $scope.tdsReport.companyCode=foundItemDest.id;
            
            
           /* $timeout(function() {
                $("#txtCompanyCode").multiselect({
                    maxHeight: 400,
                    includeSelectAllOption: true,
                    selectAllText: 'Select All',
                    enableFiltering: true,
                    enableCaseInsensitiveFiltering: true,
                    filterPlaceholder: 'Search',
                    onChange: function(element, checked) {
                        debugger;
                      var companyCodes = "", jvpShortNames="";
                      if($scope.tdsReport.objCompanyCodes.length>0){
                          angular.forEach($scope.tdsReport.objCompanyCodes, function (item, key) {
                              debugger;
                              if($scope.tdsReport.objCompanyCodes.length>0){
                                  debugger;
                                  if($scope.tdsReport.objCompanyCodes[key]!=undefined){
                                      
                                      var companyCode = item.id;
                                      
                                      if(companyCodes==""){
                                          companyCodes = item.id;
                                      }else{
                                          companyCodes +=","+ item.id;
                                      }       
                                      $scope.tdsReport.companyCode = companyCodes;
                                  }                             
                              }                              
                          });
                      }else{
                          $scope.tdsReport.companyCode = '';
                      }
                      
                    }
                  });
                
                $("#multiselect-button").addClass("width_100 input-sm line-height-5");
                
                }, 2, false);*/
        }).error(function(data) {
        });
        
        $http.get($stateParams.tenantid+'/app/tdsReport/getGroupHeadList').success(function(data) {
            $scope.groupHeadList = data;
            
            $timeout(function() { 
                
                $("#txtGroupCode").multiselect({
                    maxHeight: 400,
                    includeSelectAllOption: true,
                    selectAllText: 'Select All',
                    enableFiltering: true,
                    enableCaseInsensitiveFiltering: true,
                    filterPlaceholder: 'Search',
                    onChange: function(element, checked) {
                        debugger;
                      var groupCodes = "";
                      if($scope.tdsReport.objGroupCodes.length>0){
                          angular.forEach($scope.tdsReport.objGroupCodes, function (item, key) {
                              debugger;
                              if($scope.tdsReport.objGroupCodes.length>0){
                                  debugger;
                                  if($scope.tdsReport.objGroupCodes[key]!=undefined){
                                      
                                      var companyCode = item.id;
                                      
                                      if(groupCodes==""){
                                          groupCodes = item.id;
                                      }else{
                                          groupCodes +=","+ item.id;
                                      }       
                                      $scope.tdsReport.groupCode = groupCodes;
                                  }                             
                              }                              
                          });
                      }else{
                          $scope.tdsReport.groupCode = '';
                      }
                      console.log($scope.tdsReport.groupCode);
                    }
                  });
                $("#txtGroupCode").parent().find('.btn-group #multiselect-button').addClass('width_100 input-sm line-height-5'); 
                
                }, 2, false);
        }).error(function(data) {
        });
        
        
        $http.get($stateParams.tenantid+'/app/purchaseinvoice/getAccountList').success(function(datas) {
            $scope.accountHeadList = datas;
            }).error(function(datas) {
        });
    };
    
    $scope.getDropDownList();
    
    $scope.$watch('tdsReport.mainAccountCode', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
            $scope.subAccountCodeList = [];
            debugger;
            $scope.tdsReport.subGroupCode=newValue.substring(0, 4);
            if(newValue == '10080001'){
                $scope.subAccountCodeList = [];
                $http.get($stateParams.tenantid+'/app/commonUtility/getSubAccountCodeListTradeDebtors').success(function(datas) {
                    console.log("sub acct 1")
                    $scope.subAccountCodeList = datas
                    console.log(datas);
                    }).error(function(datas) {
                });               
            }else if(newValue == '20010001' || newValue =='20050015' || newValue=='10120001' || newValue =='20010002'){
                $scope.subAccountCodeList = [];
                $http.get($stateParams.tenantid+'/app/commonUtility/getSubAccountCodeListTradeCreditors').success(function(datas) {
                    console.log("sub acct 2")                   
                    $scope.subAccountCodeList = datas;
                  
                    }).error(function(datas) {
                });   
            }else if(newValue == '20010004'){
                $scope.subAccountCodeList = [];
                $http.get($stateParams.tenantid+'/app/commonUtility/getJvPartnerAccount').success(function(datas) {
                    console.log("sub acct 3")
                      console.log(datas)
                    $scope.subAccountCodeList = datas;
                    }).error(function(datas) {
                });   
            }else if(newValue == '10070001'){
                $scope.subAccountCodeList = [];
                $http.get($stateParams.tenantid+'/app/commonUtility/getStaffList').success(function(datas) {
                    console.log("sub acct 4")
                      console.log(datas)
                    $scope.subAccountCodeList = datas;
                    }).error(function(datas) {
                });   
            }
            else if(newValue == '10040004'){
                $scope.subAccountCodeList = [];
                $http.get($stateParams.tenantid+'/app/commonUtility/getVendorList').success(function(datas) {
                    console.log("sub acct 5")
                      console.log(datas)
                    $scope.subAccountCodeList = datas;
                    }).error(function(datas) {
                });   
            }else if(newValue == '10070004' || newValue == '10050001' ||newValue == '10050002' || newValue == '50060004' || newValue == '50000002'){
                
                $scope.subAccountCodeList = [];
                $http.get($stateParams.tenantid+'/app/commonUtility/getVessel').success(function(datas) {
                    console.log("sub acct 6")
                      console.log(datas)
                    $scope.subAccountCodeList = datas;
                    }).error(function(datas) {
                });   
            }/*else{
                $scope.subAccountCodeList = [];
                $http.get('app/commonUtility/getSubAccountCodeList').success(function(datas) {
                    console.log("sub acct 6")
                      console.log(datas)
                    $scope.subAccountCodeList = datas.commonUtilityBean;
                    }).error(function(datas) {
                });  
            }*/
        }else{
            $scope.subAccountCodeList = [];
            $http.get($stateParams.tenantid+'/app/commonUtility/getSubAccountCodeList').success(function(datas) {
            //    $scope.subAccountCodeList = datas;
                 $scope.subAccountCodeList = datas.commonUtilityBean;
                console.log("sub acct 7")
                console.log(datas);
                }).error(function(datas) {
            });  
        }
    });
    
    $scope.viewTdsReportReport = function(){
        debugger;
        $scope.tdsReport.fromDate = $('#fromDate').val();
        $scope.tdsReport.toDate = $('#toDate').val();
        if($scope.tdsReport.toDate !='' && $scope.tdsReport.fromDate != '' && $scope.tdsReport.companyCode !=''){
           console.log($scope.tdsReport);
           /*var arr = [], companyCodes = $scope.tdsReport.companyCode.split(",");
           for (var i=0; i<companyCodes.length; i++){
               arr.push(companyCodes[i] ); 
           }             
           console.log(arr);
           $scope.tdsReport.lCompanyCodes=arr;*/
               
           $http.post($stateParams.tenantid+'/app/tdsReport/getTdsReportReport', $scope.tdsReport).success(function(data) {
                if(data.success){
                 
                    $("#tdsReportGrid").jqGrid('clearGridData');
                    jQuery('#tdsReportGrid').jqGrid('clearGridData').jqGrid('setGridParam', {data: data, datatype: 'json'}).trigger('reloadGrid');
                    $scope.populateTdsReportGrid(data);
                }else{
                }
           }).error(function(data) {
                logger.logError("Error Please Try Again");
           });
        }else{
            if(($scope.tdsReport.toDate =='' || $scope.tdsReport.fromDate == '') && $scope.tdsReport.companyCode =='')
                logger.logError("Please select Company and valid date range");
            else if($scope.tdsReport.companyCode =='')
                logger.logError("Please select Company");
            else if($scope.tdsReport.toDate =='' || $scope.tdsReport.fromDate == '')
                logger.logError("Please select valid date range");
        }
    };
    // export excel by account head
    $scope.exportTdsReportExcel = function(){
        debugger;
        $scope.tdsReport.fromDate = $('#fromDate').val();
        $scope.tdsReport.toDate = $('#toDate').val();
        if($scope.tdsReport.toDate !='' && $scope.tdsReport.fromDate != '' && $scope.tdsReport.companyCode !=''){
            $http.post('app/tdsReport/exportTdsReportExcel', $scope.tdsReport).success(function(data) {
                if(data){
                    debugger;
                    $("#GLExport").bind('click', function() {
                    });
                    $('#GLExport').simulateClick('click');
                    logger.logSuccess("Exported successfully!");
                }else{
                    logger.logError("Failed to export");
                }
                
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        }else{
            if(($scope.tdsReport.toDate =='' || $scope.tdsReport.fromDate == '') && $scope.tdsReport.companyCode =='')
                logger.logError("Please select Company and valid date range");
            else if($scope.tdsReport.companyCode =='')
                logger.logError("Please select Company");
            else if($scope.tdsReport.toDate =='' && $scope.tdsReport.fromDate == '')
                logger.logError("Please select valid date range");
        }
    }
    //export excel
    $scope.exportTdsReportExcelOP = function(){
        debugger;
        $scope.tdsReport.fromDate = $('#fromDate').val();
        $scope.tdsReport.toDate = $('#toDate').val();
        console.log($scope.tdsReport);
        if($scope.tdsReport.toDate !='' && $scope.tdsReport.fromDate != '' && $scope.tdsReport.companyCode !=''){
            $http.post($stateParams.tenantid+'/app/tdsReport/exportTdsReportExcelOP', $scope.tdsReport).success(function(data) {
                if(data){
                    debugger;
                    $("#GLExport").bind('click', function() {
                    });
                    $('#GLExport').simulateClick('click');
                    logger.logSuccess("Exported successfully!");
                }else{
                    logger.logError("Failed to export");
                }
                
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        }else{
            if(($scope.tdsReport.toDate =='' || $scope.tdsReport.fromDate == '') && $scope.tdsReport.companyCode =='')
                logger.logError("Please select Company and valid date range");
            else if($scope.tdsReport.companyCode =='')
                logger.logError("Please select Company");
            else if($scope.tdsReport.toDate =='' && $scope.tdsReport.fromDate == '')
                logger.logError("Please select valid date range");
        }
    }
    
    
    $scope.exportTransactionLevelExcel = function(){
        debugger;
        $scope.tdsReport.fromDate = $('#fromDate').val();
        $scope.tdsReport.toDate = $('#toDate').val();
        if($scope.tdsReport.toDate !='' && $scope.tdsReport.fromDate != '' && $scope.tdsReport.companyCode !=''){
            $http.post($stateParams.tenantid+'/app/tdsReport/exportTransactionLevelExcel', $scope.tdsReport).success(function(data) {
                if(data){
                    debugger;
                    $("#GLExport").bind('click', function() {
                    });
                    $('#GLExport').simulateClick('click');
                    logger.logSuccess("Exported successfully!");
                }else{
                    logger.logError("Failed to export");
                }
                
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        }else{
            if(($scope.tdsReport.toDate =='' || $scope.tdsReport.fromDate == '') && $scope.tdsReport.companyCode =='')
                logger.logError("Please select Company and valid date range");
            else if($scope.tdsReport.companyCode =='')
                logger.logError("Please select Company");
            else if($scope.tdsReport.toDate =='' && $scope.tdsReport.fromDate == '')
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
    
    $scope.populateTdsReportGrid = function(sgListData){
        var companyCode = $("#companyCode").val();
//        alert(companyCode);
        if(companyCode=='C0017'){
            $scope.currencCode= "(MYR)";
        }else{
            $scope.currencCode= "";
        }
        console.log("sgListData")
        console.log(sgListData)
        debugger;
        var data=[];
        $("#tdsReportGrid").GridUnload();
        $("#tdsReportGrid").jqGrid({
            data: sgListData.lTdsReportList,
            datatype: "local",
            multiboxonly: false,
            autowidth: true,
            height: '100%',
            rowNum: 100,
            rowList: [100,200,300],
            multiselect: false,
            loadonce: true,
            gridview:true,
            colNames : [ 'Sub Group Head Code', 'Sub Group Head Name','Tax Amount'/*'TC Debit', 'TC Credit','BC Debit'+$scope.currencCode, 'BC Credit'+$scope.currencCode,'TC Balance','BC Balance'+$scope.currencCode*/],
            colModel:[
                {name:'subGroupCode',index:'subGroupCode', width:80, align:"left",searchoptions:{sopt:['cn']}},
                {name:'subGroupName',index:'subGroupName', width:80, align:"left",searchoptions:{sopt:['cn']},hidden:false},
               /* {name:'tcDebit',index:'tcDebit', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false},
                {name:'tcCredit',index:'tcCredit', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false},
                {name:'bcDebit',index:'tcDebit', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false},
                {name:'bcCredit',index:'tcCredit', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false},
                {name:'currentTCBalance',index:'currentTCBalance', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false},
                */{name:'currentBalance',index:'currentBalance', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false}
                ],
            pager: "#tdsReportPage",
            viewrecords: true,
            ignoreCase: true,
            subGrid: true,
            subGridOptions: {
                "plusicon" : 'ui-icon-plus',
                "minusicon" : 'ui-icon-minus'
            },
            footerrow: true,
            loadComplete: function () {
                var $grid = $('#tdsReportGrid');
                var tcCredit = $grid.jqGrid('getCol', 'tcCredit', false, 'sum');
                var tcDebit = $grid.jqGrid('getCol', 'tcDebit', false, 'sum');
                var credit = $grid.jqGrid('getCol', 'bcCredit', false, 'sum');
                var debit = $grid.jqGrid('getCol', 'bcDebit', false, 'sum');
                
                var difference = debit - credit;
                var tcDifference = tcDebit - tcCredit;
                
                console.log("difference")
                 console.log(sgListData.amt.closingBalance)

                $(this).jqGrid('footerData','set',{ subGroupName:'Total', /*tcDebit:tcDebit.toFixed(2),tcCredit:tcCredit.toFixed(2),
                    bcDebit:debit.toFixed(2),bcCredit:credit.toFixed(2),*/currentBalance:sgListData.amt.closingBalance});
            },
           
          
            subGridRowExpanded: function(subgrid_id, row_id) {
            	alert(row_id)
                debugger;
                var subgrid_table_id, pager_id; subgrid_table_id = subgrid_id+"_t";
                pager_id = "p_"+subgrid_table_id;
                var rowData = jQuery('#tdsReportGrid').jqGrid ('getRowData', row_id);
                $scope.tdsReport.subGroupCode =rowData.subGroupCode;
                $("#"+subgrid_id).html("<table id='"+subgrid_table_id+"' class='scroll'></table><div id='"+pager_id+"' class='scroll'></div>");
                $http.post($stateParams.tenantid+'/app/tdsReport/getTdsReportAHLevel',$scope.tdsReport).success(function(data) {
                 if(data.success){
                     debugger;
                     var glAHlevelDataList =data.lTdsReportAHList;
                     $("#"+subgrid_table_id).jqGrid({
                     datatype: "local",
                     data: glAHlevelDataList,
                     colNames:['Acct Head Code','Acct Head Name','TC Debit', 'TC Credit','BC Debit', 'BC Credit','TC Balance','BC Balance'],
                                        
                     colModel:[
                            {name:'accountHeadCode',index:'accountHeadCode', width:200, align:"left",searchoptions:{sopt:['cn']}},
                            {name:'accountHeadName',index:'accountHeadName', width:200, align:"left",searchoptions:{sopt:['cn']},hidden:false},
                            {name:'tcDebit',index:'tcDebit', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false},
                            {name:'tcCredit',index:'tcCredit', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false},
                            {name:'bcDebit',index:'bcDebit', width:200,align:"right", searchoptions:{sopt:['cn']},hidden:false},
                            {name:'bcCredit',index:'bcCredit', width:200,align:"right", searchoptions:{sopt:['cn']},hidden:false},
                            {name:'currentTCBalance',index:'currentTCBalance', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false},
                            {name:'currentBalance',index:'currentBalance', width:200,align:"right", searchoptions:{sopt:['cn']},hidden:false}
                        ],
                     autowidth: true,
                     height: '100%',
                     pager: pager_id,
                     sortname: 'num',
                     sortorder: "asc",
                     // transaction level
                     subGrid: true,
                     subGridOptions: {
                         "plusicon" : 'ui-icon-plus',
                         "minusicon" : 'ui-icon-minus'
                     },
                     

                     footerrow: true,

                     subGridRowExpanded: function(subgrid_child_id, row_id) {
                         debugger;
                         var subgridchild_table_id, pager_id; subgridchild_table_id = subgrid_child_id+"_t";
                         pager_id = "p_"+subgridchild_table_id;
                         var rowData = jQuery('#'+subgrid_table_id).jqGrid ('getRowData', row_id);
                         $scope.tdsReport.accountHeadCode =rowData.accountHeadCode;
                         $("#"+subgrid_child_id).html("<table id='"+subgridchild_table_id+"' class='scroll'></table><div id='"+pager_id+"' class='scroll'></div>");
                         $http.post($stateParams.tenantid+'/app/tdsReport/getGLTransactionLevel', $scope.tdsReport).success(function(data) {
                          if(data.success){
                              debugger;
                              var glTransactionlevelDataList =data.lTdsReportTransactionList;
                              $("#"+subgridchild_table_id).jqGrid({
                              datatype: "local",
                              data: glTransactionlevelDataList,
                              colNames:['Transaction No','Intra Company Voucher No','Ledger Dt','Party Inv No','Narration','SA Code','SA Name','Currency','Ex-Rate','TC Debit','TC Credit','BC Debit','BC Credit','Status','Allocated to'],
                              colModel:[
                                 {name:'transactionNo',index:'transactionNo', width:100, align:"left",
                                     searchoptions:{sopt:['cn']},classes: 'cursor-pointer'},
                                 {name:'voucherNo',index:'voucherNo', width:100, align:"left",searchoptions:{sopt:['cn']},hidden:false},    
                                 {name:'ledgerDate',index:'ledgerDate', width:100, align:"left",searchoptions:{sopt:['cn']},hidden:false},
                                 {name:'partyInvoiceNo',index:'partyInvoiceNo', width:100, align:"left",searchoptions:{sopt:['cn']},hidden:false},
                                 {name:'narration',index:'narration', width:200,align:"left", searchoptions:{sopt:['cn']},hidden:false},
                                 {name:'subAccountCode',index:'subAccountCode', width:70, align:"left",searchoptions:{sopt:['cn']}},
                                 {name:'subAccountName',index:'subAccountName', width:300, align:"left",searchoptions:{sopt:['cn']},hidden:false},
                                 {name:'currency',index:'currency', width:50,align:"left", searchoptions:{sopt:['cn']},hidden:false},
                                 {name:'exchangeRate',index:'exchangeRate', width:50,align:"right", searchoptions:{sopt:['cn']},hidden:false},
                                 {name:'tcDebit',index:'tcDebit', width:150,align:"right", searchoptions:{sopt:['cn']},hidden:false},
                                 {name:'tcCredit',index:'tcCredit', width:150,align:"right", searchoptions:{sopt:['cn']},hidden:false},
                                 {name:'bcDebit',index:'bcDebit', width:150,align:"right", searchoptions:{sopt:['cn']},hidden:false},
                                 {name:'bcCredit',index:'bcCredit', width:150,align:"right", searchoptions:{sopt:['cn']},hidden:false},
                                 {name:'allocationStatus',index:'allocationStatus', width:100, align:"left",searchoptions:{sopt:['cn']},hidden:false},
                                 {name:'allocatedTo',index:'allocatedTo', width:100, align:"left",searchoptions:{sopt:['cn']},hidden:false},
                                 
                                 ],
                                 onCellSelect: function(rowid, iCol)
                                 {
                                     debugger;
                                     /* Row Click Based Event ******************** Start */
                                     var cm = jQuery("#"+subgridchild_table_id).jqGrid("getGridParam", "colModel");
                                     var transactionNoCell = jQuery("#"+subgridchild_table_id).jqGrid("getCell", rowid, "transactionNo");
                                     var colName = cm[iCol];
                                     console.log(colName);
                                     if(colName.name=="transactionNo"){
                                         utilsService.reportVoucherPrint(transactionNoCell);
                                     }
                                     //jqGridRowClickBasedEvent('productMasterGrid',rowid,'viewRow','editrow',iCol,colName.name);
                                     /* Row Click Based Event ******************** Endss */ 
                                 },
                              autowidth: true,
                              height: '100%',
                              pager: pager_id,
                              sortname: 'num',
                              sortorder: "asc", }).jqGrid('setGridParam', { data : glTransactionlevelDataList }).trigger("reloadGrid");
                          }
                         
                         }).error(function(tbAHlevelDataList) {
                         });
                      } }).jqGrid('setGridParam', { data : glAHlevelDataList }).trigger("reloadGrid");
                 }
                
                }).error(function(glAHlevelDataList) {
                });
             }
        }).jqGrid('setGridParam', { data : sgListData }).trigger("reloadGrid");
        
    }
    
     
});

