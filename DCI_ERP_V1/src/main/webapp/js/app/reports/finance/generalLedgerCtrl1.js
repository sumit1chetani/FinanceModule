'use strict';
app.controller('generalLedgerController1', function($templateCache, $scope, $rootScope, $http, logger, $log, ngDialog, 
        $modal, $location, $sce,$state, $filter, $timeout,utilsService,$compile,$stateParams) {
	
	 $scope.sub = true;
	 $scope.test=true;
	    $scope.main = true;
	    $scope.generalLedger = {
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
	    
	    $scope.companyId=$location.search().companyId;
	    $scope.fromDate=$location.search().fromDate;
	    $scope.toDate=$location.search().toDate;
	    $scope.id=$location.search().id;
	    $scope.subGroupCode=$location.search().groupCode;
	    $scope.groupCode=$location.search().groupCode;
	    $rootScope.accid=$location.search().groupCode;
	    
	    if($scope.companyId != undefined && $scope.fromDate != undefined && $scope.toDate != undefined && $scope.id !=undefined){
	    	$scope.test=false;
	    	
	    	
	    	 $scope.testing={
	 	    		companyCode : $scope.companyId,
	 	    		fromDate : $scope.fromDate,
	 	        	toDate : $scope.toDate,
	 	      subGroupCode:'',
	 	    // groupCode:$scope.groupCode,
	 	     accountHeadCode:$scope.subGroupCode
	 	    };
	    	
		    	   
	    	
	    }
	    
	    if($scope.testing!=undefined ){
	    	
	    	$scope.Report = function(){
	    		
	    			var url = $stateParams.tenantid+'/app/subgroupacct/accountcode?subgroup=' +$scope.testing.accountHeadCode;
	                $http.get(url).success(function(data) {
	                    console.log("****datasubgroup***");
	                    console.log(data);
	                    $scope.testing.subGroupCode=data.objSubGroupAccountBeanBean[0].grpHeadCode;
	                  
	                    if($scope.testing!=undefined ){
	     	               console.log($scope.generalLedger);
	     	                   
	     	               $http.post($stateParams.tenantid+'/app/generalLedger/getAccountbasedtransaction', $scope.testing).success(function(data) {
	     	                    if(data.success){
	     	                    	$scope.rowCollection=data.lGeneralLedgerAHList;
	     	                       
	     	                    }else{
	     	                    }
	     	               }).error(function(data) {
	     	                    logger.logError("Error Please Try Again");
	     	               });
	     	            }else{
	     	                if(($scope.generalLedger.toDate =='' || $scope.generalLedger.fromDate == '') && $scope.generalLedger.companyCode =='')
	     	                    logger.logError("Please select Company and valid date range");
	     	                else if($scope.generalLedger.companyCode =='')
	     	                    logger.logError("Please select Company");
	     	                else if($scope.generalLedger.toDate =='' || $scope.generalLedger.fromDate == '')
	     	                    logger.logError("Please select valid date range");
	     	            }
	                    
	                }).error(function(data) {
	                    logger.logError("Error Please Try Again");
	                });
	    		
	        	    
	        	    
	    		
	            debugger;
	            
	            
	        };
	        $scope.Report(); 
	    }

    $('#gl_fromDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime: false
    });
    
    $('#gl_toDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime: false
    });
    
    $scope.backpage=function()
   {
	   $state.go('app.finance.reports.financial.profitandloss', {
			tenantid : $stateParams.tenantid
		});
   }
   var accountHead =$rootScope.accid;
    $scope.exportGeneralLedgerExcelAccountHead = function(){
        debugger;
        console.log($scope.testing);
        var acct=$rootScope.accountHead;
        $scope.testing.accountHeadCode=accountHead;
        $scope.testing.mainAccountCode=accountHead;
        if($scope.testing.toDate !='' && $scope.testing.fromDate != '' && $scope.testing.companyCode !=''){
            $http.post($stateParams.tenantid+'/app/generalLedger/exportGeneralLedgerExcelOP', $scope.testing).success(function(data) {
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
            if(($scope.testing.toDate =='' || $scope.testing.fromDate == '') && $scope.testing.companyCode =='')
                logger.logError("Please select Company and valid date range");
            else if($scope.testing.companyCode =='')
                logger.logError("Please select Company");
            else if($scope.generalLedger.toDate =='' && $scope.generalLedger.fromDate == '')
                logger.logError("Please select valid date range");
        }
    }
    
    

    $scope.formreset = function() {
        debugger;
        $scope.generalLedger = {
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
                  if($scope.generalLedger.objCompanyCodes.length>0){
                      angular.forEach($scope.generalLedger.objCompanyCodes, function (item, key) {
                          debugger;
                          if($scope.generalLedger.objCompanyCodes.length>0){
                              debugger;
                              if($scope.generalLedger.objCompanyCodes[key]!=undefined){
                                  
                                  var companyCode = item.id;
                                  
                                  if(companyCodes==""){
                                      companyCodes = item.id;
                                  }else{
                                      companyCodes +=","+ item.id;
                                  }       
                                  $scope.generalLedger.companyCode = companyCodes;
                              }                             
                          }                              
                      });
                  }else{
                      $scope.generalLedger.companyCode = '';
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
       /* $http.get($stateParams.tenantid+'/app/trialBalance/getSubGroupList').success(function(data) {
            $scope.subGroupList = data;
        }).error(function(data) {
        });*/
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
            var data = {};
			data["id"] = "All";
			data["text"] = "ALL";
			$scope.companyList.push(data);
       

            
            console.log("company")
            console.log($scope.companyList)
            var foundItemDest = $filter('filter')($scope.companyList, { baseCompany:  1 })[0];
            $scope.generalLedger.companyCode=foundItemDest.id;
            
            
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
                      if($scope.generalLedger.objCompanyCodes.length>0){
                          angular.forEach($scope.generalLedger.objCompanyCodes, function (item, key) {
                              debugger;
                              if($scope.generalLedger.objCompanyCodes.length>0){
                                  debugger;
                                  if($scope.generalLedger.objCompanyCodes[key]!=undefined){
                                      
                                      var companyCode = item.id;
                                      
                                      if(companyCodes==""){
                                          companyCodes = item.id;
                                      }else{
                                          companyCodes +=","+ item.id;
                                      }       
                                      $scope.generalLedger.companyCode = companyCodes;
                                  }                             
                              }                              
                          });
                      }else{
                          $scope.generalLedger.companyCode = '';
                      }
                      
                    }
                  });
                
                $("#multiselect-button").addClass("width_100 input-sm line-height-5");
                
                }, 2, false);*/
        }).error(function(data) {
        });
        
        $http.get($stateParams.tenantid+'/app/generalLedger/getGroupHeadList').success(function(data) {
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
                      if($scope.generalLedger.objGroupCodes.length>0){
                          angular.forEach($scope.generalLedger.objGroupCodes, function (item, key) {
                              debugger;
                              if($scope.generalLedger.objGroupCodes.length>0){
                                  debugger;
                                  if($scope.generalLedger.objGroupCodes[key]!=undefined){
                                      
                                      var companyCode = item.id;
                                      
                                      if(groupCodes==""){
                                          groupCodes = item.id;
                                      }else{
                                          groupCodes +=","+ item.id;
                                      }       
                                      $scope.generalLedger.groupCode = groupCodes;
                                  }                             
                              }                              
                          });
                      }else{
                          $scope.generalLedger.groupCode = '';
                      }
                      console.log($scope.generalLedger.groupCode);
                    }
                  });
                $("#txtGroupCode").parent().find('.btn-group #multiselect-button').addClass('width_100 input-sm line-height-5'); 
                
                }, 2, false);
        }).error(function(data) {
        });
        
        
       /* $http.get($stateParams.tenantid+'/app/purchaseinvoice/getAccountList').success(function(datas) {
            $scope.accountHeadList = datas;
            }).error(function(datas) {
        });*/
    };
    
    $scope.getDropDownList();
    
    $scope.subAccountCodeList = [];
    $http.get($stateParams.tenantid+'/app/commonUtility/getSubAccountCodeList').success(function(datas) {
    //    $scope.subAccountCodeList = datas;
         $scope.subAccountCodeList = datas.commonUtilityBean;
        console.log("sub acct 7")
        console.log(datas);
        }).error(function(datas) {
    });  
    
    $scope.$watch('generalLedger.mainAccountCode', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
            $scope.subAccountCodeList = [];
            debugger;
            $scope.generalLedger.subGroupCode=newValue.substring(0, 4);
            if(newValue == '10080001' ||newValue == '10080003' || newValue == '10080002' ){
                $scope.subAccountCodeList = [];
                $http.get($stateParams.tenantid+'/app/commonUtility/getSubAccountCodeListTradeDebtors').success(function(datas) {
                    console.log("sub acct 1")
                    $scope.subAccountCodeList = datas
                    console.log(datas);
                    }).error(function(datas) {
                });               
            }else if(newValue == '20010001' || newValue =='20010003' || newValue=='10120001' || newValue =='20010002'){
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
    
    $scope.viewGeneralLedgerReport = function(){
        debugger;
        $scope.generalLedger.fromDate = $('#fromDate').val();
        $scope.generalLedger.toDate = $('#toDate').val();
        if($scope.generalLedger.toDate !='' && $scope.generalLedger.fromDate != '' && $scope.generalLedger.companyCode !=''){
           console.log($scope.generalLedger);
           /*var arr = [], companyCodes = $scope.generalLedger.companyCode.split(",");
           for (var i=0; i<companyCodes.length; i++){
               arr.push(companyCodes[i] ); 
           }             
           console.log(arr);
           $scope.generalLedger.lCompanyCodes=arr;*/
               
           $http.post($stateParams.tenantid+'/app/generalLedger/getGeneralLedgerReport', $scope.generalLedger).success(function(data) {
                if(data.success){
                 
                    $("#generalLedgerGrid").jqGrid('clearGridData');
                    jQuery('#generalLedgerGrid').jqGrid('clearGridData').jqGrid('setGridParam', {data: data, datatype: 'json'}).trigger('reloadGrid');
                    $scope.populateGeneralLedgerGrid(data);
                }else{
                }
           }).error(function(data) {
                logger.logError("Error Please Try Again");
           });
        }else{
            if(($scope.generalLedger.toDate =='' || $scope.generalLedger.fromDate == '') && $scope.generalLedger.companyCode =='')
                logger.logError("Please select Company and valid date range");
            else if($scope.generalLedger.companyCode =='')
                logger.logError("Please select Company");
            else if($scope.generalLedger.toDate =='' || $scope.generalLedger.fromDate == '')
                logger.logError("Please select valid date range");
        }
    };
    
    //trial to General onload
    
    
       
    // export excel by account head
    $scope.exportGeneralLedgerExcel = function(){
        debugger;
        $scope.generalLedger.fromDate = $('#fromDate').val();
        $scope.generalLedger.toDate = $('#toDate').val();
        if($scope.generalLedger.toDate !='' && $scope.generalLedger.fromDate != '' && $scope.generalLedger.companyCode !=''){
            $http.post($stateParams.tenantid+'/app/generalLedger/exportGeneralLedgerExcel', $scope.generalLedger).success(function(data) {
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
            if(($scope.generalLedger.toDate =='' || $scope.generalLedger.fromDate == '') && $scope.generalLedger.companyCode =='')
                logger.logError("Please select Company and valid date range");
            else if($scope.generalLedger.companyCode =='')
                logger.logError("Please select Company");
            else if($scope.generalLedger.toDate =='' && $scope.generalLedger.fromDate == '')
                logger.logError("Please select valid date range");
        }
    }
    
    //
   
    
    //export excel
    $scope.exportGeneralLedgerExcelOP = function(){
        debugger;
        $scope.generalLedger.fromDate = $('#fromDate').val();
        $scope.generalLedger.toDate = $('#toDate').val();
        console.log($scope.generalLedger);
        if($scope.generalLedger.toDate !='' && $scope.generalLedger.fromDate != '' && $scope.generalLedger.companyCode !=''){
            $http.post($stateParams.tenantid+'/app/generalLedger/exportGeneralLedgerExcelOP', $scope.generalLedger).success(function(data) {
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
            if(($scope.generalLedger.toDate =='' || $scope.generalLedger.fromDate == '') && $scope.generalLedger.companyCode =='')
                logger.logError("Please select Company and valid date range");
            else if($scope.generalLedger.companyCode =='')
                logger.logError("Please select Company");
            else if($scope.generalLedger.toDate =='' && $scope.generalLedger.fromDate == '')
                logger.logError("Please select valid date range");
        }
    }
    
    
    $scope.exportTransactionLevelExcel = function(){
        debugger;
        $scope.generalLedger.fromDate = $('#fromDate').val();
        $scope.generalLedger.toDate = $('#toDate').val();
        if($scope.generalLedger.toDate !='' && $scope.generalLedger.fromDate != '' && $scope.generalLedger.companyCode !=''){
            $http.post($stateParams.tenantid+'/app/generalLedger/exportTransactionLevelExcel', $scope.generalLedger).success(function(data) {
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
            if(($scope.generalLedger.toDate =='' || $scope.generalLedger.fromDate == '') && $scope.generalLedger.companyCode =='')
                logger.logError("Please select Company and valid date range");
            else if($scope.generalLedger.companyCode =='')
                logger.logError("Please select Company");
            else if($scope.generalLedger.toDate =='' && $scope.generalLedger.fromDate == '')
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
    function test(rowObject) {
    	debugger;
    	alert("rer");
    	console.log(rowObject);
    	
    	$( "#generalLeddialog" ).dialog();
    	if ($("#generalLeddialog").dialog ("isOpen")) alert ("Already open !");
    	  else $("#generalLeddialog").dialog ("open");
    }

    //
    $scope.closeThisDialog = function(){
	        
	        ngDialog.close();
	       
	    }
    $scope.populateGeneralLedgerGrid1 = function(sgListData){
    	   
    
        var companyCode = $("#companyCode").val();
        //alert(companyCode);
        if(companyCode=='C0017'){
            $scope.currencCode= "(MYR)";
        }else{
            $scope.currencCode= "";
        }
        console.log("sgListData")
        console.log(sgListData)
        
     $scope.geneSubgroupData=[];
        $http.post($stateParams.tenantid+'/app/generalLedger/getGeneralLedgerALLLevel',$scope.testing).success(function(data) {
        	$scope.geneSubgroupData =sgListData.lGeneralLedgerList ;
        	$scope.geneSubgroupData[0].lGeneralLedgerAHList=data.lGeneralLedgerAHList;
        	console.log($scope.geneSubgroupData); 
        	
        	 angular.forEach($scope.geneSubgroupData[0].lGeneralLedgerAHList, function (bean, key) {
       			$scope.geneSubgroupData[0].lGeneralLedgerAHList[key].showaccounthead=bean.accountHeadCode
       			  $("#plus" + key).css("display", "none");
          		   $("#minus" + key).css("display", "block");
       		 
       	  });
        	 
        	
        });
        
        debugger;
        var data=[];
        $("#generalLedgerGrid").GridUnload();
        $("#generalLedgerGrid").jqGrid({
            data: sgListData.lGeneralLedgerList,
            datatype: "local",
            multiboxonly: false,
            autowidth: true,
            height: '50%',
            rowNum: 100,
            rowList: [100,200,300],
            multiselect: false,
            loadonce: true,
            gridview:true,
            colNames : [ 'Sub Group Head Code', 'Sub Group Head Name','TC Debit', 'TC Credit','BC Debit'+$scope.currencCode, 'BC Credit'+$scope.currencCode,'TC Balance','BC Balance'+$scope.currencCode],
            colModel:[
                {name:'subGroupCode',index:'subGroupCode', width:80, align:"left",searchoptions:{sopt:['cn']}},
                {name:'subGroupName',index:'subGroupName', width:80, align:"left",searchoptions:{sopt:['cn']},hidden:false},
                {name:'tcDebit',index:'tcDebit', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                {name:'tcCredit',index:'tcCredit', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                {name:'bcDebit',index:'tcDebit', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                {name:'bcCredit',index:'tcCredit', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                {name:'currentTCBalance',index:'currentTCBalance', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                {name:'currentBalance',index:'currentBalance', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}}
                ],
            pager: "#generalLedgerPage",
            viewrecords: true,
            ignoreCase: true,
            subGrid: true,
            subGridOptions: {
               /* "plusicon" : 'ui-icon-plus',
                "minusicon" : 'ui-icon-minus',*/
                expandOnLoad: true, 

            },
            footerrow: true,
            loadComplete: function () {
                var $grid = $('#generalLedgerGrid');
                
                var tcCredit = $grid.jqGrid('getCol', 'tcCredit', false, 'sum');
                var tcDebit = $grid.jqGrid('getCol', 'tcDebit', false, 'sum');
                var credit = $grid.jqGrid('getCol', 'bcCredit', false, 'sum');
                var debit = $grid.jqGrid('getCol', 'bcDebit', false, 'sum');
                
                var difference = debit - credit;
                var tcDifference = tcDebit - tcCredit;
                
                console.log("difference")
                 console.log(sgListData.amt.closingBalance)

                $(this).jqGrid('footerData','set',{ subGroupName:'Total', tcDebit:tcDebit.toFixed(2),tcCredit:tcCredit.toFixed(2),
                    bcDebit:debit.toFixed(2),bcCredit:credit.toFixed(2),currentBalance:sgListData.amt.closingBalance});
            },
	         
            subGridRowExpanded: function(subgrid_id, row_id) {
            	//alert(row_id)
                debugger;
                var subgrid_table_id, pager_id; subgrid_table_id = subgrid_id+"_t";
                pager_id = "p_"+subgrid_table_id;
                $rootScope.value=$scope.testing;


                var rowData = jQuery('#generalLedgerGrid').jqGrid ('getRowData', row_id);
                $scope.generalLedger.subGroupCode =rowData.subGroupCode;
                $("#"+subgrid_id).html("<table id='"+subgrid_table_id+"' class='scroll'></table><div id='"+pager_id+"' class='scroll'></div>");
                $http.post($stateParams.tenantid+'/app/generalLedger/getGeneralLedgerAHLevel',$scope.testing).success(function(data) {
                 if(data.success){
                     debugger;
                     var glAHlevelDataList =data.lGeneralLedgerAHList;
                     $("#"+subgrid_table_id).jqGrid({
                     datatype: "local",
                     data: glAHlevelDataList,
                     colNames:['Acct Head Code','Acct Head Name','TC Debit', 'TC Credit','BC Debit', 'BC Credit','TC Balance','BC Balance','Actions'],
                                        
                     colModel:[
                            {name:'accountHeadCode',index:'accountHeadCode', width:200, align:"left",searchoptions:{sopt:['cn']}},
                            {name:'accountHeadName',index:'accountHeadName', width:200, align:"left",searchoptions:{sopt:['cn']},hidden:false},
                            {name:'tcDebit',index:'tcDebit', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                            {name:'tcCredit',index:'tcCredit', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                            {name:'bcDebit',index:'bcDebit', width:200,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                            {name:'bcCredit',index:'bcCredit', width:200,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                            {name:'currentTCBalance',index:'currentTCBalance', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                            {name:'currentBalance',index:'currentBalance', width:200,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                            /*{name:'slabact',index:'slabact', formatter: addLink1 , width:80, align:"left",searchoptions:{sopt:['cn']},hidden:false,classes: 'level_class1'},*/
                            /*{name: 'slabact', index: 'slabact', width: 100, sortable: false, align: 'center',key:true,formatter: addLink,
                            	formatter: function (cellvalue, options, rowObject) {
                 			return "<button onclick=\"slabPopup('"+rowObject+"');\"><span class=\"ui-icon ui-icon ui-icon-pencil edit-blue\"></span></button>";//\"
                 			},resizable: false} */
                            {name:'actions',index:'actions',align:"center", width: 50, search: false}
                        ],
                     autowidth: true,
                     height: '50%',
                     pager: pager_id,
                     sortname: 'num',
                     sortorder: "asc",
                     // transaction level
                     subGrid: true,
                     subGridOptions: {
                         /*"plusicon" : 'ui-icon-plus',
                         "minusicon" : 'ui-icon-minus',*/
                        // expandOnLoad: true,
                     },
                     
                 	gridComplete: function(){
                 		var ids = jQuery("#"+subgrid_table_id).jqGrid('getDataIDs');
                 		var fulldata = jQuery("#"+subgrid_table_id).jqGrid('getGridParam','data');
                 		console.log(ids);
                 		var test=$scope.testing;
                 		for(var i=0;i < ids.length;i++){
                 			var cl = fulldata[i].accountHeadCode;
                 		var	pdf = "<div style='width:20%;float:left;cursor:pointer;' title=\'"+cl+"' \" onclick=\"slabPopup('"+cl+"','"+test+"')\">" +
                 				"<span class=\"ui-icon ui-icon ui-icon-pencil edit-blue\"></span></div>";
                 			$("#"+subgrid_table_id).jqGrid('setRowData',ids[i],{actions:pdf});
                 		}
                 	},

                     footerrow: true,
                   

                     subGridRowExpanded: function(subgrid_child_id, row_id) {
                         debugger;
                       
                                console.log('it works' + new Date());
                            
                         
                         var subgridchild_table_id, pager_id; subgridchild_table_id = subgrid_child_id+"_t";
                         pager_id = "p_"+subgridchild_table_id;
                         var rowData = jQuery('#'+subgrid_table_id).jqGrid ('getRowData', row_id);
                         $scope.testing.accountHeadCode =rowData.accountHeadCode;
                         $rootScope.acc=$scope.testing.accountHeadCode
                         console.log($rootScope.acc);
                         
                         
                         $("#"+subgrid_child_id).html("<table id='"+subgridchild_table_id+"' class='scroll'></table><div id='"+pager_id+"' class='scroll'></div>");
                         $http.post($stateParams.tenantid+'/app/generalLedger/getGLTransactionLevel',$scope.testing).success(function(data) {
                          if(data.success){
                              debugger;
                              var glTransactionlevelDataList =data.lGeneralLedgerTransactionList;
                              $("#"+subgridchild_table_id).jqGrid({
                              datatype: "local",
                              data: glTransactionlevelDataList,
                              colNames:['Transaction No','Ledger Dt','Party Inv No','SA Name','Currency','Ex-Rate','TC Debit','TC Credit','BC Debit','BC Credit','Status','Allocated to'],
                              colModel:[
                                 {name:'transactionNo',index:'transactionNo', width:100, align:"left",
                                     searchoptions:{sopt:['cn']},classes: 'cursor-pointer'},
                                 /*{name:'voucherNo',index:'voucherNo', width:100, align:"left",searchoptions:{sopt:['cn']},hidden:false}, */   
                                 {name:'ledgerDate',index:'ledgerDate', width:100, align:"left",searchoptions:{sopt:['cn']},hidden:false},
                                 {name:'partyInvoiceNo',index:'partyInvoiceNo', width:100, align:"left",searchoptions:{sopt:['cn']},hidden:false},
                                 /*{name:'narration',index:'narration', width:200,align:"left", searchoptions:{sopt:['cn']},hidden:false},*/
                                 /*{name:'subAccountCode',index:'subAccountCode', width:70, align:"left",searchoptions:{sopt:['cn']}},*/
                                 {name:'subAccountName',index:'subAccountName', width:300, align:"left",searchoptions:{sopt:['cn']},hidden:false},
                                 {name:'currency',index:'currency', width:50,align:"left", searchoptions:{sopt:['cn']},hidden:false},
                                 {name:'exchangeRate',index:'exchangeRate', width:50,align:"right", searchoptions:{sopt:['cn']},hidden:false},
                                 {name:'tcDebit',index:'tcDebit', width:150,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                                 {name:'tcCredit',index:'tcCredit', width:150,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                                 {name:'bcDebit',index:'bcDebit', width:150,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                                 {name:'bcCredit',index:'bcCredit', width:150,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                                 {name:'allocationStatus',index:'allocationStatus', width:100, align:"left",searchoptions:{sopt:['cn']},hidden:false},
                                 {name:'allocatedTo',index:'allocatedTo', width:100, align:"left",searchoptions:{sopt:['cn']},hidden:false}
                         
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
                              height: '50%',
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
    $( document ).ready(function() {

    
    		
    });
   
   /* $scope.exportGeneralLedgerExcelOP1 = function(){
        debugger;
        console.log($scope.testing);
        console.log($rootScope.acc);
        var acct=$rootScope.acc;
        $scope.testing.accountHeadCode=acct;
        if($scope.testing.toDate !='' && $scope.testing.fromDate != '' && $scope.testing.companyCode !=''){
            $http.post($stateParams.tenantid+'/app/generalLedger/exportGeneralLedgerExcelOP', $scope.testing).success(function(data) {
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
            if(($scope.testing.toDate =='' || $scope.testing.fromDate == '') && $scope.testing.companyCode =='')
                logger.logError("Please select Company and valid date range");
            else if($scope.testing.companyCode =='')
                logger.logError("Please select Company");
            else if($scope.generalLedger.toDate =='' && $scope.generalLedger.fromDate == '')
                logger.logError("Please select valid date range");
        }
    }*/
    
    $scope.doubleshowTable = function(index, accounthead,status,list,showaccounthead) {
     	 if(status=='minus'){
    		   $("#plus" + index).css("display", "block");
    		   $("#minus" + index).css("display", "none");
    		   $scope.geneSubgroupData[0].lGeneralLedgerAHList[index].showaccounthead='';
    	 }else{
    		   $("#minus" + index).css("display", "block");
    		   $("#plus" + index).css("display", "none");
    		   $scope.geneSubgroupData[0].lGeneralLedgerAHList[index].showaccounthead=accounthead;
    		  
    	 }
    	
    	
       
    }
    
   
    $scope.exportGeneralLedgerExcel1 = function(){
        debugger;
        console.log($scope.testing);
        console.log($rootScope.acc);
        var acct=$rootScope.acc;
        $scope.testing.accountHeadCode=acct;
        if($scope.testing.toDate !='' && $scope.testing.fromDate != '' && $scope.testing.companyCode !=''){
            $http.post($stateParams.tenantid+'/app/generalLedger/exportGeneralLedgerExcel', $scope.testing).success(function(data) {
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
            if(($scope.testing.toDate =='' || $scope.testing.fromDate == '') && $scope.testing.companyCode =='')
                logger.logError("Please select Company and valid date range");
            else if($scope.testing.companyCode =='')
                logger.logError("Please select Company");
            else if($scope.testing.toDate =='' && $scope.testing.fromDate == '')
                logger.logError("Please select valid date range");
        }
    }
    
    $scope.exportTransactionLevelExcel1 = function(){
        debugger;
        var acct=$rootScope.acc;
        $scope.testing.accountHeadCode=acct;
        if($scope.testing.toDate !='' && $scope.testing.fromDate != '' && $scope.testing.companyCode !=''){
            $http.post($stateParams.tenantid+'/app/generalLedger/exportTransactionLevelExcel', $scope.testing).success(function(data) {
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
            if(($scope.testing.toDate =='' || $scope.testing.fromDate == '') && $scope.testing.companyCode =='')
                logger.logError("Please select Company and valid date range");
            else if($scope.testing.companyCode =='')
                logger.logError("Please select Company");
            else if($scope.testing.toDate =='' && $scope.testing.fromDate == '')
                logger.logError("Please select valid date range");
        }
    }
    
    /*function addLink1(cellvalue, options, rowObject) 
    {
    	alert("test");
    	$scope.companyId = $scope.generalLedger.companyCode;
    	$scope.fromDate = $scope.generalLedger.fromDate;
    	$scope.toDate = $scope.generalLedger.toDate ; 
    	$scope.subGroupCode = rowObject.subGroupCode;
    	$scope.id=cellvalue;
    	
    
      return "<a href='#/"+$stateParams.tenantid+"/reports/finance/generalLedger?companyId="+$scope.generalLedger.companyCode+"&subGroupCode="+$scope.subGroupCode+"&id="+cellvalue+"&fromDate="+$scope.generalLedger.fromDate+"&toDate="+$scope.generalLedger.toDate +"'  style='height:25px;width:120px;' type='button' title='Slet'  target=\"_blank\" >"+cellvalue+"</a>";
    	//return "<a $location.url=('#/athena/reports/finance/generalLedger?id="+$rootScope.test+"')style='height:25px;width:120px;' type='button' title='Slet'  target=\"_blank\" >"+cellvalue+"</a>";
      //return "<a  href="" style='height:25px;width:120px;' type='button' title='Slet' id='"+test1+"' target=\"_blank\" >"+cellvalue+"</a>";
      
    }*/
    //
    
    function addLink(cellvalue, options, rowObject) 
    {
    	$scope.companyId = $scope.generalLedger.companyCode;
    	$scope.fromDate = $scope.generalLedger.fromDate;
    	$scope.toDate = $scope.generalLedger.toDate ; 
    	$scope.subGroupCode = rowObject.subGroupCode;
    	$scope.id=cellvalue;
    	
    
      return "<a href='#/"+$stateParams.tenantid+"/reports/finance/generalLedger1?companyId="+$scope.generalLedger.companyCode+"&subGroupCode="+$scope.subGroupCode+"&id="+cellvalue+"&fromDate="+$scope.generalLedger.fromDate+"&toDate="+$scope.generalLedger.toDate +"'  style='height:25px;width:120px;' type='button' title='Click to here view ledger'  target=\"_blank\" >"+cellvalue+"</a>";
    	//return "<a $location.url=('#/athena/reports/finance/generalLedger?id="+$rootScope.test+"')style='height:25px;width:120px;' type='button' title='Slet'  target=\"_blank\" >"+cellvalue+"</a>";
      //return "<a  href="" style='height:25px;width:120px;' type='button' title='Slet' id='"+test1+"' target=\"_blank\" >"+cellvalue+"</a>";
      
    }
    $scope.populateGeneralLedgerGrid = function(sgListData){
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
        $("#generalLedgerGrid").GridUnload();
        $("#generalLedgerGrid").jqGrid({
            data: sgListData.lGeneralLedgerList,
            datatype: "local",
            multiboxonly: false,
            autowidth: true,
            height: '100%',
            rowNum: 100,
            rowList: [100,200,300],
            multiselect: false,
            loadonce: true,
            gridview:true,
            colNames : [ 'Sub Group Head Code', 'Sub Group Head Name','TC Debit', 'TC Credit','BC Debit'+$scope.currencCode, 'BC Credit'+$scope.currencCode,'TC Balance','BC Balance'+$scope.currencCode],
            colModel:[
                {name:'subGroupCode',index:'subGroupCode', width:80, align:"left",searchoptions:{sopt:['cn']}},
                {name:'subGroupName',index:'subGroupName',  formatter: addLink ,width:80, align:"left",searchoptions:{sopt:['cn']},hidden:false},
                {name:'tcDebit',index:'tcDebit', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                {name:'tcCredit',index:'tcCredit', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                {name:'bcDebit',index:'tcDebit', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                {name:'bcCredit',index:'tcCredit', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                {name:'currentTCBalance',index:'currentTCBalance', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                {name:'currentBalance',index:'currentBalance', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}}
             
                ],
            pager: "#generalLedgerPage",
            viewrecords: true,
            ignoreCase: true,
            subGrid: true,
            subGridOptions: {
                "plusicon" : 'ui-icon-plus',
                "minusicon" : 'ui-icon-minus'
            },
            footerrow: true,
            loadComplete: function () {
                var $grid = $('#generalLedgerGrid');
                var tcCredit = $grid.jqGrid('getCol', 'tcCredit', false, 'sum');
                var tcDebit = $grid.jqGrid('getCol', 'tcDebit', false, 'sum');
                var credit = $grid.jqGrid('getCol', 'bcCredit', false, 'sum');
                var debit = $grid.jqGrid('getCol', 'bcDebit', false, 'sum');
                
                var difference = debit - credit;
                var tcDifference = tcDebit - tcCredit;
                
                console.log("difference")
                 console.log(sgListData.amt.closingBalance)

                $(this).jqGrid('footerData','set',{ subGroupName:'Total', tcDebit:tcDebit.toFixed(2),tcCredit:tcCredit.toFixed(2),
                    bcDebit:debit.toFixed(2),bcCredit:credit.toFixed(2),currentBalance:sgListData.amt.closingBalance});
            },
           
          
            subGridRowExpanded: function(subgrid_id, row_id) {
            	//alert(row_id)
                debugger;
                var subgrid_table_id, pager_id; subgrid_table_id = subgrid_id+"_t";
                pager_id = "p_"+subgrid_table_id;
                var rowData = jQuery('#generalLedgerGrid').jqGrid ('getRowData', row_id);
                $scope.generalLedger.subGroupCode =rowData.subGroupCode;
                $("#"+subgrid_id).html("<table id='"+subgrid_table_id+"' class='scroll'></table><div id='"+pager_id+"' class='scroll'></div>");
                $http.post($stateParams.tenantid+'/app/generalLedger/getGeneralLedgerAHLevel',$scope.generalLedger).success(function(data) {
                 if(data.success){
                     debugger;
                     var glAHlevelDataList =data.lGeneralLedgerAHList;
                     $("#"+subgrid_table_id).jqGrid({
                     datatype: "local",
                     data: glAHlevelDataList,
                     colNames:['Acct Head Code','Acct Head Name','TC Debit', 'TC Credit','BC Debit', 'BC Credit','TC Balance','BC Balance'],
                                        
                     colModel:[
                            {name:'accountHeadCode',index:'accountHeadCode', width:200, align:"left",searchoptions:{sopt:['cn']}},
                            {name:'accountHeadName',index:'accountHeadName', width:200, align:"left",searchoptions:{sopt:['cn']},hidden:false},
                            {name:'tcDebit',index:'tcDebit', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                            {name:'tcCredit',index:'tcCredit', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                            {name:'bcDebit',index:'bcDebit', width:200,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                            {name:'bcCredit',index:'bcCredit', width:200,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                            {name:'currentTCBalance',index:'currentTCBalance', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                            {name:'currentBalance',index:'currentBalance', width:200,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}}
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
                         $scope.generalLedger.accountHeadCode =rowData.accountHeadCode;
                         $("#"+subgrid_child_id).html("<table id='"+subgridchild_table_id+"' class='scroll'></table><div id='"+pager_id+"' class='scroll'></div>");
                         $http.post($stateParams.tenantid+'/app/generalLedger/getGLTransactionLevel', $scope.generalLedger).success(function(data) {
                          if(data.success){
                              debugger;
                              var glTransactionlevelDataList =data.lGeneralLedgerTransactionList;
                              $("#"+subgridchild_table_id).jqGrid({
                              datatype: "local",
                              data: glTransactionlevelDataList,
                              colNames:['Transaction No','Ledger Dt','Party Inv No','SA Name','Currency','Ex-Rate','TC Debit','TC Credit','BC Debit','BC Credit','Status','Allocated to'],
                              colModel:[
                                 {name:'transactionNo',index:'transactionNo', width:100, align:"left",
                                     searchoptions:{sopt:['cn']},classes: 'cursor-pointer'},
                                 /*{name:'voucherNo',index:'voucherNo', width:100, align:"left",searchoptions:{sopt:['cn']},hidden:false}, */   
                                 {name:'ledgerDate',index:'ledgerDate', width:100, align:"left",searchoptions:{sopt:['cn']},hidden:false},
                                 {name:'partyInvoiceNo',index:'partyInvoiceNo', width:100, align:"left",searchoptions:{sopt:['cn']},hidden:false},
                                 /*{name:'narration',index:'narration', width:200,align:"left", searchoptions:{sopt:['cn']},hidden:false},*/
                                 /*{name:'subAccountCode',index:'subAccountCode', width:70, align:"left",searchoptions:{sopt:['cn']}},*/
                                 {name:'subAccountName',index:'subAccountName', width:300, align:"left",searchoptions:{sopt:['cn']},hidden:false},
                                 {name:'currency',index:'currency', width:50,align:"left", searchoptions:{sopt:['cn']},hidden:false},
                                 {name:'exchangeRate',index:'exchangeRate', width:50,align:"right", searchoptions:{sopt:['cn']},hidden:false},
                                 {name:'tcDebit',index:'tcDebit', width:150,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                                 {name:'tcCredit',index:'tcCredit', width:150,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                                 {name:'bcDebit',index:'bcDebit', width:150,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                                 {name:'bcCredit',index:'bcCredit', width:150,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
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
    
    
    //group code
   
    	 $scope.$watch('generalLedger.objGroupCodes', function(newValue, oldValue) {
    	    	
    	        if (newValue != '' && newValue != undefined) {
    	        	
    	        	 $scope.subcollection = [];
    	        	 $scope.test = [];
    	        	 for(var i=0;i<newValue.length;i++){
    	        		 $scope.subcollection.push(newValue[i].text);
    	        	 }
    	        	 $scope.test= $scope.subcollection;
    	        	 
    	        	 /*$scope.subcollection.push(newValue);*/
    	        	 $http.get($stateParams.tenantid+'/app/generalLedger/getsubgroupList?subgroup='+ $scope.test).success(function(datas) {
    	        		 if(datas != null){
    	        			  $scope.subGroupList = datas;
    	                      $scope.sub = false;
    	        		 }
    	               
    	                 }).error(function(datas) {
    	             });
    	        }
    	    });
    	 
   
    //sub code
    $scope.$watch('generalLedger.subGroupCode', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
        	
        	 $http.get($stateParams.tenantid+'/app/generalLedger/getmaingroupList?maingroup='+  newValue).success(function(datas) {
        		 if(datas != null){
        			  $scope.accountHeadList = datas;
                      $scope.main = false;
        		 }
               
                 }).error(function(datas) {
             });
        }
    });
    
    $scope.cancel=function(){
    	
		$state.go('app.reports.finance.generalLedger',{tenantid:$stateParams.tenantid});
	}
   
    
    
    
   
    
   
     
});
