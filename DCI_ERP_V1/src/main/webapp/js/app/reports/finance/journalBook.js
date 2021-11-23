
app.controller('journalBookCtrl', function($templateCache, $scope, $rootScope, $http, logger, $log, ngDialog, 
        $modal, $location, $sce, $filter, $timeout,$stateParams) {

	 $scope.accountList = [];    
	    $scope.companyList = []; 
	    $scope.jvData = [];
	    /*   $scope.CashBook = { fromDate:'', toDate : '', accountCode: '',companyCode:'', objCompanyCodes:[] }*/

	    $scope.JournalBook = { fromDate:'', toDate : '',companyCode:''}
	    
	    
	    $('#cb_fromDate').datetimepicker({
	        format : 'DD/MM/YYYY',
	        pickTime: false
	    });
	    
	    $('#cb_toDate').datetimepicker({
	        format : 'DD/MM/YYYY',
	        pickTime: false
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
	/*    $scope.getDropDownList = function( ) {
	        
	        $http.get('app/journalVoucher/getAccountHeadList').success(function(datas) {
	            $scope.accountHeadList = datas;
	            }).error(function(datas) {
	          // logger.logError("Error Please Try Again");
	        });
	        
	        $scope.companylist = [];
	        
	     //   $http.post($stateParams.tenantid+'/api/branch/companylist').success(function(data) {
	        $http.get('app/usermaster/getCompanyList?formCode='+$('#form_code_id').val()).success(function(data) {	
	    		$scope.companylist=data;
	    		  var foundItemDest = $filter('filter')($scope.companylist, { id:  1 })[0];
	 	         $scope.JournalBook.companyCode=foundItemDest.id;
	     	
	     		        	
	    		        		
	    });
	        
	        $http.get('app/usermaster/getCompanyList?formCode='+$('#form_code_id').val()).success(function(data) {
	            $scope.companyList = data;
	            console.log($scope.companyList);
	            $timeout(function() {      
	                 $("#txtCompanyCode").multiselect({
	                    maxHeight: 400,
	                    includeSelectAllOption: true,
	                    selectAllText: 'Select All',
	                    enableFiltering: true,
	                    enableCaseInsensitiveFiltering: true,
	                    filterPlaceholder: 'Search',
	                    onChange: function(element, checked) {
	                      var companyCodes = "";
	                      if($scope.JournalBook.objCompanyCodes.length>0){
	                          angular.forEach($scope.JournalBook.objCompanyCodes, function (item, key) {
	                              if($scope.JournalBook.objCompanyCodes.length>0){
	                                  if($scope.JournalBook.objCompanyCodes[key]!=undefined){
	                                      var companyCode = item.id;
	                                      if(companyCodes==""){
	                                          companyCodes = item.id;
	                                      }else{
	                                          companyCodes +=","+ item.id;
	                                      }       
	                                      $scope.JournalBook.companyCode = companyCodes;
	                                  }                             
	                              }                              
	                          });
	                      }else{
	                          $scope.JournalBook.companyCode = '';
	                      }
	                    }
	                  });
	                $("#multiselect-button").addClass("width_100 input-sm line-height-5");
	                }, 2, false);
	            }).error(function(data) {
	        });
	    }
	    $scope.getDropDownList();
	        */
	    
	        $scope.getCashReport = function(){

	            $scope.JournalBook.fromDate = $('#fromDate').val();
	            $scope.JournalBook.toDate = $('#toDate').val();
	            console.log("$scope.JournalBook")
	            console.log($scope.JournalBook)
	           if($scope.JournalBook.fromDate !=''  && $scope.JournalBook.toDate !=''  && $scope.JournalBook.companyCode !='' ){
	              
	        	   $http.post($stateParams.tenantid+'/app/journalVoucher/getGridData', $scope.JournalBook).success(function(datas) {
	        	   
	        	 //  $http.post('app/journalVoucher/getGridData', $scope.JournalBook).success(function(datas) {
	                    console.log("jv data");
	                    console.log(datas.journalList)    ;   
	                    $scope.jvData = datas.journalList;
	                    $("#JournalMainGrid").jqGrid('clearGridData'); 
	                     $scope.populateJournalBookGrid($scope.jvData);
	                       }).error(function(datas) {
	                   });
	            }else{
	                if(( $scope.JournalBook.fromDate == '') && $scope.JournalBook.toDate == '' && $scope.JournalBook.companyCode =='')
	                    logger.logError("Please select Company and valid date range");
	                else if($scope.JournalBook.companyCode =='')
	                    logger.logError("Please select Company");
	                else if ($scope.JournalBook.toDate == '' && $scope.JournalBook.toDate =='')
	                    {
	                    logger.logError("Please select Date Range");
	                    }
	             
	            }
	        }
	        
	        
	        
	        $scope.populateJournalBookGrid=function(listdata){
	            var date=[];
	               debugger;
	               var data=[];
	               $("#JournalMainGrid").jqGrid({
	                   data: $scope.jvData,
	                   datatype: "local",
	                   multiboxonly: false,
	                   autowidth: true,
	                   height: '100%',
	                   rowList: [10,20,30],
	                   multiselect: false,
	                   loadonce: true,
	                   gridview:true,
	                   colNames:['JV Date','Company','JV No','Particulars','Account Head Name','Sub Account','Currency','TC Credit','TC Debit','BC Credit','BC Debit'],
	                   colModel:[
	                       {name:'dataOfIssue',index:'dataOfIssue', width:200, align: "left",sorttype:'text',searchoptions:{sopt:['cn']},resizable: false},//Added for avoid resizing the grid.
	                       {name:'companyName',index:'companyName', width:200, align: "left",sorttype:'text',searchoptions:{sopt:['cn']},resizable: false},//Added for avoid resizing the grid.
	                       {name:'jvNumber',index:'jvNumber', width:200, align: "left",searchoptions:{sopt:['cn']},resizable: false,sorttype:'text'},
	                       {name:'narration',index:'narration', width:400, align: "right",searchoptions:{sopt:['cn']},resizable: false,sorttype:'number'},
	                       {name:'accountName',index:'accountName', width:400, align: "left",searchoptions:{sopt:['cn']},resizable: false,sorttype:'text'},
	                       {name:'subGroupAcctName',index:'subGroupAcctName', width:300, align: "right",searchoptions:{sopt:['cn']},resizable: false,sorttype:'text'},
	                       {name:'currency',index:'currency', width:100, align: "right",searchoptions:{sopt:['cn']},resizable: false,sorttype:'number'},
	                       {name:'tcCreditAmount',index:'tcCreditAmount', width:200, align: "right",searchoptions:{sopt:['cn']},resizable: false,sorttype:'number'},
	                       {name:'tcDebitAmount',index:'tcDebitAmount', width:200, align: "right",searchoptions:{sopt:['cn']},resizable: false,sorttype:'number'},
	                       {name:'bcCreditAmount',index:'bcCreditAmount', width:200, align: "right",searchoptions:{sopt:['cn']},resizable: false,sorttype:'number'},
	                       {name:'bcDebitAmount',index:'bcDebitAmount', width:200, align: "right",searchoptions:{sopt:['cn']},resizable: false,sorttype:'number'},
	                   ],
	                   pager: '#JournalBookPage',
	                   viewrecords: true,
	                   ignoreCase: true,
	                   footerrow: true,
	                   rowNum: 10,
	               });
	               $("#JournalMainGrid").jqGrid('setGridParam', { data : listdata }).trigger('reloadGrid');
	               
	           
	           }
	        
	        $scope.excel=function(){
	            console.log("rowCollection");
	            console.log($scope.excelBean);
	                  var objWholeData = {
	                  'journalList'  : $scope.jvData,
	                                                           };  
	                  
	                  $http.post($stateParams.tenantid+'/app/journalVoucher/exportJournalBookExcel', objWholeData).success(function(response)  {
	                                 // $http.post("app/journalVoucher/exportJournalBookExcel",objWholeData).success(function(response) {
	                                          $('#exportXl').append('<a id="tbExcelExport" stype="display:none" href="filePath/JournalBook.xlsx" download="JournalBook.xlsx"></a>');
	                                          $("#tbExcelExport").bind('click', function() {
	                                          });
	                                          $('#tbExcelExport').simulateClick('click');
	                                          
	                                          logger.logSuccess("Exported Successfully!");
	                              }).error(function(result) {
	                                       logger.logError("Error Please Try Again");
	                                   });
	                                                 $.fn.simulateClick = function() {   return this.each(function() {
	                                               if ('createEvent' in document) {
	                                                   var doc = this.ownerDocument, evt = doc.createEvent('MouseEvents');
	                                                   evt.initMouseEvent('click', true, true, doc.defaultView, 1, 0, 0, 0, 0, false, false, false, false, 0, null);
	                                                    this.dispatchEvent(evt);
	                                                } else {
	                                                   this.click(); // IE
	                                               }
	                                           });
	                                       }
	        }
            
 });
