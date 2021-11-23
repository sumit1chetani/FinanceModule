
app.controller('BankBookCtrl', function($templateCache, $scope, $rootScope, $http, logger, $log, ngDialog, $modal, $location, $sce, $filter,$timeout,$stateParams) {

    
    $scope.accountList = [];
    
    
    $scope.companyList = []; 
   
    $scope.BankBook = { fromDate:'', toDate : '', accountCode: '', companyCode:'', objCompanyCodes:[] }
    
//getAccountList
    $('#bb_fromDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime: false
    });
    
    $('#bb_toDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime: false
    });
    
    $scope.$watch('BankBook.companyCode', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
        	
        	//if(newValue!='C0001'){
           	$http.get($stateParams.tenantid+'/finance/bank/getAccountList').success(function(datas) {
         	   
    	    	$scope.accountList = datas;
   			 var data = {};
		        
				data["id"] = "ALL";
				data["text"] = "ALL";
				$scope.accountList.push(data);
				
    	          }).error(function(datas) {
            });
       // }
        	//else{
        		/*
        	$scope.accountList = [];
  			 var data = {};
		        
  			 $scope.temp = [{
   			 	id:'ALL',
   			 	text:'ALL'
   			 	},{
 				id:'10030003',
   			 	text:'OVERSEA-CHINESE BANKING CORPORATION LIMITED-USD'
   			 	},{
   			 	id:'10030004',
   			 	text:'OVERSEA-CHINESE BANKING CORPORATION LIMITED-SGD'	
   			 	}];
 		        
 		        $scope.accountList =  $scope.temp;
 		        
				data["id"] = "ALL";
				data["text"] = "ALL";
				$scope.accountList.push(data);
				data["id"] = "10030003";
				data["text"] = "OVERSEA-CHINESE BANKING CORPORATION LIMITED-USD";
				$scope.accountList.push(data);
				data["id"] = "10030004";
				data["text"] = "OVERSEA-CHINESE BANKING CORPORATION LIMITED-SGD";
				$scope.accountList.push(data);
    		
        */
        	//}
        }
   });
	
    
    $scope.getDropDownList = function() {
    	/*$http.get($stateParams.tenantid+'/finance/bank/getAccountList').success(function(datas) {
    	   
    	    	$scope.accountList = datas;
   			 var data = {};
		        
				data["id"] = "ALL";
				data["text"] = "ALL";
				$scope.accountList.push(data);
				
    	          }).error(function(datas) {
    	      });*/
    	
        $http.get($stateParams.tenantid+'/app/usermaster/getCompanyList?formCode='+$('#form_code_id').val()).success(function(data) {
            $scope.companyList = data;
            console.log($scope.companyList);
            data["id"] = "All";
 			data["text"] = "ALL";
 			$scope.companyList.push(data);
            console.log($scope.companyList);
          
            console.log("company")
            console.log($scope.companyList)
            var foundItemDest = $filter('filter')($scope.companyList, { baseCompany:  1 })[0];
          $scope.BankBook.companyCode=foundItemDest.id;
            /*  $timeout(function() { // You might need this timeout to be sure its run after DOM render.          
                 $("#txtCompanyCode").multiselect({
                    maxHeight: 400,
                    includeSelectAllOption: true,
                    selectAllText: 'Select All',
                    enableFiltering: true,
                    enableCaseInsensitiveFiltering: true,
                    filterPlaceholder: 'Search',
                    onChange: function(element, checked) {
                      var companyCodes = "";
                      if($scope.BankBook.objCompanyCodes.length>0){
                          angular.forEach($scope.BankBook.objCompanyCodes, function (item, key) {
                              if($scope.BankBook.objCompanyCodes.length>0){
                                  if($scope.BankBook.objCompanyCodes[key]!=undefined){
                                      var companyCode = item.id;
                                      if(companyCodes==""){
                                          companyCodes = item.id;
                                      }else{
                                          companyCodes +=","+ item.id;
                                      }       
                                      $scope.BankBook.companyCode = companyCodes;
                                  }                             
                              }                              
                          });
                      }else{
                          $scope.BankBook.companyCode = '';
                      }
                    }
                  });
                $("#multiselect-button").addClass("width_100 input-sm line-height-5");
                }, 2, false);*/
            }).error(function(data) {
        });
    }
   
    $scope.getDropDownList();
        
   
        $scope.getBankReport = function(){
            $scope.BankBook.fromDate = $('#fromDate').val();
            $scope.BankBook.toDate = $('#toDate').val();
            
            if($scope.BankBook.toDate !='' && $scope.BankBook.fromDate != '' && $scope.BankBook.companyCode !='' && $scope.BankBook.accountCode !=''){
                      
                $scope.offsetCount = 0;
               $scope.limitCount = 100;
           
               $http.post($stateParams.tenantid+'/finance/bank/getMainGrid', $scope.BankBook).success(function(datas) {
                      $scope.BankBookMainGrid = $('#BankBookMainGrid').jqGrid('clearGridData');
                       
                       $scope.populateBankBookGrid(datas.lBankBook);
                   }).error(function(datas) {
               });
            }else{
                if(($scope.BankBook.toDate =='' || $scope.BankBook.fromDate == '') && $scope.BankBook.companyCode =='' && $scope.BankBook.accountCode =='')
                    logger.logError("Please select Company, Bank Account Code and valid date range");
                else if($scope.BankBook.companyCode =='' && $scope.BankBook.accountCode =='')
                    logger.logError("Please select Company and Bank Account Code");
                else if($scope.BankBook.toDate =='' && $scope.BankBook.fromDate == '' && $scope.BankBook.accountCode =='')
                    logger.logError("Please select valid date range and Bank Account Code");
                else if($scope.BankBook.toDate =='' && $scope.BankBook.fromDate == '')
                    logger.logError("Please select valid date range");
                else if($scope.BankBook.companyCode =='')
                    logger.logError("Please select Company");
                else if($scope.BankBook.accountCode =='')
                    logger.logError("Please select Bank Account Code");
            }
        }
        $scope.populateBankBookGrid=function(listdata){
            var data=[];
               $("#BankBookMainGrid").jqGrid({
                   data: listdata,
                   datatype: "local",
                   multiboxonly: true,
                   autowidth:true,
                   autoheight:true,
                   rowList: [5, 10, 20],
                   gridview: true,
                   multiselect: false,
                   multiboxonly: false,
                   colNames:['Account Code','Account Name','Opening Balance','Debit BC','Debit TC','Credit BC','Credit TC','Closing Balance'],
                   colModel:[
                       {name:'accountCode',index:'accountCode', width:100, align: "left",sorttype:'text',searchoptions:{sopt:['cn']},resizable: false},//Added for avoid resizing the grid.
                       {name:'accountName',index:'accountName', width:400, align: "left",searchoptions:{sopt:['cn']},resizable: false,sorttype:'text'},
                       {name:'openingBalance',index:'debit', width:250, align: "right",searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','},resizable: false,sorttype:'number'},
                       {name:'debit',index:'debit', width:250, align: "right",searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','},resizable: false,sorttype:'number'},
                       {name:'tcDebit',index:'tcDebit', width:250, align: "right",searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','},resizable: false,sorttype:'number'},
                       {name:'credit',index:'credit', width:250, align: "right",searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','},resizable: false,sorttype:'number'},
                       {name:'tcCredit',index:'tcCredit', width:250, align: "right",searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','},resizable: false,sorttype:'number'},
                       {name:'currentBalance',index:'currentBalance', width:250, align: "right",searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','},resizable: false,sorttype:'number'}
                   ],
                   loadOnce : true,
                   pager: '#bankBookPage',
                   viewrecords: true,
                   ignoreCase: true,
                   subGrid: true,
                   subGridOptions: {
                       "plusicon" : 'ui-icon-plus',
                       "minusicon" : 'ui-icon-minus'
                   },
                   footerrow: true,
                   height: '100%',
                   rowNum: 10,
                   subGridRowExpanded: function(subgrid_id, row_id) {
                	   
                       var subgrid_table_id, pager_id; subgrid_table_id = subgrid_id+"_t";
                       pager_id = "p_"+subgrid_table_id;
                       var rowData = jQuery('#BankBookMainGrid').jqGrid ('getRowData', row_id);
                       console.log("rowData:::::::::::SUB GRID::::::::");
                       console.log(rowData.accountCode);
                       $scope.BankBook.accountCode = rowData.accountCode;
                       $("#"+subgrid_id).html("<table id='"+subgrid_table_id+"' class='scroll'></table><div id='"+pager_id+"' class='scroll'></div>");
                   $http.post($stateParams.tenantid+'/finance/bank/getSubGrid',$scope.BankBook).success(function(dtlData) {
                                  console.log(dtlData.lBankBook);
                                  
                                  
                                  var openingBal = rowData.openingBalance;
                                  var openBal=0;
                                  var ii=0;
                                  angular.forEach(dtlData.lBankBook, function (item, key) {
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
                               data: dtlData.lBankBook,
                               colNames:['Transaction Date','Transaction No.','Narration','Debit BC','Debit TC','Credit TC','Credit BC','Closing Balance'],
                               colModel:[
                                   {name:'transactionDate',index:'transactionDate', width:50, align:"left",searchoptions:{sopt:['cn']}},
                                   {name:'transactionNo',index:'transactionNo', width:50, align:"left",searchoptions:{sopt:['cn']}},
                                   {name:'narration',index:'narration', width:50, align:"left",searchoptions:{sopt:['cn']}},
                                   {name:'bcDebit',index:'bcDebit', width:50, align:"right",searchoptions:{sopt:['cn']},hidden:false},
                                   {name:'tcDebit',index:'tcDebit', width:50, align:"right",searchoptions:{sopt:['cn']},hidden:false},
                                   {name:'bcCredit',index:'bcCredit', width:50, align:"right",searchoptions:{sopt:['cn']},hidden:false},
                                   {name:'tcCredit',index:'tcCredit', width:50, align:"right",searchoptions:{sopt:['cn']},hidden:false},
                                   {name:'currentBalance',index:'currentBalance', width:50, align:"right",searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','},resizable: false,sorttype:'number'},

                                   
                                   /* {name:'tcDebit',index:'bcDebit', width:50, align:"right",searchoptions:{sopt:['cn']},hidden:false},
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
               $("#BankBookMainGrid").jqGrid('setGridParam', { data : listdata }).trigger('reloadGrid');
             
           }
        
        $scope.exportBankBook = function(){
            debugger;
            $scope.BankBook.fromDate = $('#fromDate').val();
            $scope.BankBook.toDate = $('#toDate').val();
            
            if($scope.BankBook.toDate !='' && $scope.BankBook.fromDate != ''){
                $http.post($stateParams.tenantid+'/finance/bank/exportBankBookExcel', $scope.BankBook).success(function(data) {
                    if(data){
                        debugger;
                        $("#BBExport").bind('click', function() {
                        });
                        $('#BBExport').simulateClick('click');
                        logger.logSuccess("Exported successfully!");
                    }else{
                        logger.logSuccess("Failed to export");
                    }
                    
                }).error(function(data) {
                    logger.logError("Error Please Try Again");
                });
            }else{
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
 });
