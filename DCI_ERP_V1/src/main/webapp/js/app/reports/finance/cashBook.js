
app.controller('cashBookCtrl', function($templateCache, $scope, $rootScope, $http, logger, $log, ngDialog, 
        $modal, $location, $sce, $filter, $timeout,$stateParams) {

    $scope.accountList = [];    
    $scope.companyList = []; 
    $scope.CashBook = { fromDate:'', toDate : '', accountCode: '',companyCode:'', objCompanyCodes:[] }
    
    $('#cb_fromDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime: false
    });
    
    $('#cb_toDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime: false
    });
    
    $scope.getDropDownList = function() {
        $http.post($stateParams.tenantid+'/finance/cash/getAccountList').success(function(datas) {
            $scope.accountList = datas.lAccountList;
            }).error(function(datas) {
        });
        
        $http.get($stateParams.tenantid+'/app/usermaster/getCompanyList?formCode='+$('#form_code_id').val()).success(function(data) 
        		{
       /* $http.get('app/trialBalance/getCompanyList').success(function(data) {*/
        	
            $scope.companyList = data;
            var data = {};
 			data["id"] = "All";
 			data["text"] = "ALL";
 			$scope.companyList.push(data);
            console.log($scope.companyList);
           
            
            console.log("company")
            console.log($scope.companyList)
            var foundItemDest = $filter('filter')($scope.companyList, { baseCompany:  1 })[0];
          $scope.CashBook.companyCode=foundItemDest.id;
            
            /* $timeout(function() { // You might need this timeout to be sure its run after DOM render.          
                 $("#txtCompanyCode").multiselect({
                    maxHeight: 400,
                    includeSelectAllOption: true,
                    selectAllText: 'Select All',
                    enableFiltering: true,
                    enableCaseInsensitiveFiltering: true,
                    filterPlaceholder: 'Search',
                    onChange: function(element, checked) {
                      var companyCodes = "";
                      if($scope.CashBook.objCompanyCodes.length>0){
                          angular.forEach($scope.CashBook.objCompanyCodes, function (item, key) {
                              if($scope.CashBook.objCompanyCodes.length>0){
                                  if($scope.CashBook.objCompanyCodes[key]!=undefined){
                                      var companyCode = item.id;
                                      if(companyCodes==""){
                                          companyCodes = item.id;
                                      }else{
                                          companyCodes +=","+ item.id;
                                      }       
                                      $scope.CashBook.companyCode = companyCodes;
                                  }                             
                              }                              
                          });
                      }else{
                          $scope.CashBook.companyCode = '';
                      }
                    }
                  });
                $("#multiselect-button").addClass("width_100 input-sm line-height-5");
                }, 2, false);*/
            }).error(function(data) {
        });
    }
    $scope.getDropDownList();
        
    
        $scope.getCashReport = function(){
            $scope.CashBook.fromDate = $('#fromDate').val();
            $scope.CashBook.toDate = $('#toDate').val();
            if($scope.CashBook.toDate !='' && $scope.CashBook.fromDate != '' && $scope.CashBook.companyCode !='' && $scope.CashBook.accountCode !=''){
                $http.post($stateParams.tenantid+'/finance/cash/getMainGrid', $scope.CashBook).success(function(datas) {
                    $("#cashBookMainGrid").jqGrid('clearGridData'); 
                     $scope.populateCashBookGrid(datas.lCashBook);
                       }).error(function(datas) {
                   });
            }else{
                if(($scope.CashBook.toDate =='' || $scope.CashBook.fromDate == '') && $scope.CashBook.companyCode =='' && $scope.CashBook.accountCode =='')
                    logger.logError("Please select Company,Cash Account Code and valid date range");
                else if($scope.CashBook.toDate =='' || $scope.CashBook.fromDate == '')
                    logger.logError("Please select valid date range");
                else if($scope.CashBook.companyCode =='')
                    logger.logError("Please select Company");
                else if($scope.CashBook.accountCode =='')
                    logger.logError("Please select Cash Account Code");
            }
        }
        
        
        
        $scope.populateCashBookGrid=function(listdata){
            var date=[];
               debugger;
               var data=[];
               $("#cashBookMainGrid").jqGrid({
                   data: listdata,
                   datatype: "local",
                   multiboxonly: false,
                   autowidth: true,
                   height: '100%',
                   rowList: [10,20,30],
                   multiselect: false,
                   loadonce: true,
                   gridview:true,
                   colNames:['Account Code','Account Name','Opening Balance','Debit BC','Debit TC','Credit BC','Credit TC','Closing Balance'],
                   colModel:[
                       {name:'accountCode',index:'accountCode', width:100, align: "left",sorttype:'text',searchoptions:{sopt:['cn']},resizable: false},//Added for avoid resizing the grid.
                       {name:'accountName',index:'accountName', width:400, align: "left",searchoptions:{sopt:['cn']},resizable: false,sorttype:'text'},
                       {name:'openingBalance',index:'currentBalance', width:250, align: "right",searchoptions:{sopt:['cn']},resizable: false,sorttype:'number'},
                       {name:'debit',index:'debit', width:250, align: "right",searchoptions:{sopt:['cn']},resizable: false,sorttype:'number'},
                       {name:'tcDebit',index:'tcDebit', width:250, align: "right",searchoptions:{sopt:['cn']},resizable: false,sorttype:'number'},
                       {name:'credit',index:'credit', width:250, align: "right",searchoptions:{sopt:['cn']},resizable: false,sorttype:'number'},
                       {name:'tcCredit',index:'tcCredit', width:250, align: "right",searchoptions:{sopt:['cn']},resizable: false,sorttype:'number'},
                       {name:'currentBalance',index:'currentBalance', width:250, align: "right",searchoptions:{sopt:['cn']},resizable: false,sorttype:'number'}

                       ],
                   pager: '#cashBookPage',
                   viewrecords: true,
                   ignoreCase: true,
                   subGrid: true,
                   subGridOptions: {
                       "plusicon" : 'ui-icon-plus',
                       "minusicon" : 'ui-icon-minus'
                   },
                   footerrow: true,
                   rowNum: 10,
                   
                   
                   
                   
                   
                   
                   subGridRowExpanded: function(subgrid_id, row_id) {
                       var subgrid_table_id, pager_id; subgrid_table_id = subgrid_id+"_t";
                       pager_id = "p_"+subgrid_table_id;
                       var rowData = jQuery('#cashBookMainGrid').jqGrid ('getRowData', row_id);
                       console.log("rowData:::::::::::SUB GRID::::::::");
                       console.log(rowData.accountCode);
                       $scope.CashBook.accountCode = rowData.accountCode;
                       $("#"+subgrid_id).html("<table id='"+subgrid_table_id+"' class='scroll'></table><div id='"+pager_id+"' class='scroll'></div>");
                       $http.post($stateParams.tenantid+'/finance/cash/getSubGrid',$scope.CashBook).success(function(dtlData) {
                                  console.log(dtlData.lCashBook);
                                  
                                  
                                 var openingBal = rowData.openingBalance;
                                  var openBal=0;
                                  var ii=0;
                                  angular.forEach(dtlData.lCashBook, function (item, key) {
                                	  if(ii==0){
                                		  openBal =parseFloat(openingBal)+parseFloat(item.bcDebit)-parseFloat(item.bcCredit);
                                		  item.currentBalance =parseFloat(openBal);
                                	  
                                	  }
                                	  else{
                                		  openBal=parseFloat(openBal)+parseFloat(item.bcDebit)-parseFloat(item.bcCredit);
                                    	  item.currentBalance = parseFloat(openBal); 
                                	  }
                                	  ii++;
                                	  
                                  });
                                  
                           $("#"+subgrid_table_id).jqGrid({
                               datatype: "local",
                               data: dtlData.lCashBook,
                               colNames:['Transaction Date','Transaction No.','Customer/Supplier','Account Head Name','Narration','Debit BC','Debit TC','Credit BC','Credit TC','Closing Balance'],
                               colModel:[
                                   {name:'transactionDate',index:'transactionDate', width:50, align:"left",searchoptions:{sopt:['cn']}},
                                   {name:'transactionNo',index:'transactionNo', width:50, align:"left",searchoptions:{sopt:['cn']}},
                                   {name:'customer',index:'customer', width:50, align:"left",searchoptions:{sopt:['cn']}},
                                   {name:'acctheadname',index:'acctheadname', width:50, align:"left",searchoptions:{sopt:['cn']}},
                                   {name:'narration',index:'narration', width:50, align:"left",searchoptions:{sopt:['cn']}},
                                   {name:'bcDebit',index:'bcDebit', width:50, align:"right",searchoptions:{sopt:['cn']},hidden:false},
                                   {name:'tcDebit',index:'tcDebit', width:50, align:"right",searchoptions:{sopt:['cn']},hidden:false},
                                   {name:'bcCredit',index:'bcCredit', width:50, align:"right",searchoptions:{sopt:['cn']},hidden:false},
                                   {name:'tcCredit',index:'tcCredit', width:50, align:"right",searchoptions:{sopt:['cn']},hidden:false},
                                   {name:'currentBalance',index:'currentBalance', width:50, align:"right",searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','},resizable: false,sorttype:'number'},

                                   /*{name:'tcDebit',index:'bcDebit', width:50, align:"right",searchoptions:{sopt:['cn']},hidden:false},
                                   {name:'tcCredit',index:'bcCredit', width:50, align:"right",searchoptions:{sopt:['cn']},hidden:false},*/
                               ],
                               autowidth: true,
                               height: '100%',
                               pager: pager_id,
                               sortname: 'num',
                               sortorder: "asc",            
                           });
                           
                           
                           }).error(function(dtlData) {
                       });
                    }
               });
               $("#cashBookMainGrid").jqGrid('setGridParam', { data : listdata }).trigger('reloadGrid');
               
           
           }
        
            $scope.exportCashBook = function(){
            debugger;
            $scope.CashBook.fromDate = $('#fromDate').val();
            $scope.CashBook.toDate = $('#toDate').val();
            if($scope.CashBook.toDate !='' && $scope.CashBook.fromDate != '' && $scope.CashBook.companyCode !=''){
                $http.post($stateParams.tenantid+'/finance/cash/exportCashBookExcel', $scope.CashBook).success(function(data) {
                    if(data){
                        debugger;
                        $("#CBExport").bind('click', function() {
                        });
                        $('#CBExport').simulateClick('click');
                        logger.logSuccess("Exported successfully!");
                    }else{
                        logger.logSuccess("Failed to export");
                    }
                    
                }).error(function(data) {
                    logger.logError("Error Please Try Again");
                });
            }else{
                    logger.logError("Please select Company and valid date range");
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
