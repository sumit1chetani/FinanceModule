//define([ 'hospital/accounts/accounts', 'jqGrid' ], function(module) {

'use strict';
app.controller('trialBalanceCtrl', function($templateCache,$timeout,$stateParams, $scope, $rootScope, $http, logger, $log, ngDialog, $modal, $location, $sce, $filter,utilsService) {

   $('#tb_fromDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime: false
    });
    
    $('#tb_toDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime: false
    });

    $scope.companyList = [];

    $scope.companyCodes='';
    
    $scope.trialBalance = {
            subGroupCode:'',
            companyCode:'C0002',
            companyName :'',
            fromDate:'',
            toDate:'',
            acctHeadCode:'',
            filterCode:'',
            relatedParty:'N',
            opnchk:'Y',
            opncre:'Y',
            opndeb:'Y',
            opnbal:'Y',
            subAccountId:'',
            costCenter :'',
            acctHeadId:'',
            subAccountFilterId:'',
            isGenerate : false,

    };
    
    var originalDatas = angular.copy($scope.trialBalance);


    $scope.formreset = function() {
        $scope.trialBalance = {
                subGroupCode:'',
                companyCode:'',
                companyName :'',
                fromDate:'',
                toDate:'',
                acctHeadCode:'',
                filterCode:'',
                relatedParty:'N',
                subAccountId:'',
                acctHeadId:'',
                subAccountFilterId:''
        };
    };

    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.subGroupList = [];
    $scope.companyList = [];
    $("#txtCompanyCode").multiselect({
        maxHeight: 200,   
        includeSelectAllOption: true,
        disableIfEmpty: true,
        enableCaseInsensitiveFiltering: true,
        onDropdownHide: function (event) {
            
        }
      });
    
    

    
    
    // $scope.agent=function(id){
        // if(id=='Y'){
             /*$scope.agentid=true;
             $scope.companyList=[];
             $scope.getcompanyList=function(){
             $http.get('app/commonUtility/getCompanyList').success(function(data) {

          //   $http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(data) { 
             debugger
             $scope.companyList = data;
             console.log("companyList");
             console.log( $scope.companyList);
             $timeout(function() {
             
             $("#companyCode").multiselect({
             maxHeight: 200, 
             includeSelectAllOption: true,
             selectAllText : 'Select All',
             enableFiltering : true, 
             disableIfEmpty: true,
             enableCaseInsensitiveFiltering: true,
             numberDisplayed: 1,
             onDropdownHide: function (event) {

             }
             });
             $("#multiselect-button").addClass("width_100 input-sm line-height-5");

             }, 2, false);
             
             });

             };
             
             
             
             $scope.getcompanyList();*/
        /* }else{
             $scope.agentid=false;
             $scope.EmployeeMasterData.customerName="";
         }
     */
     
// }


             $scope.getDropDownList = function() {
                 $http.get($stateParams.tenantid+'/app/commonUtility/getSubGroupAcctList').success(function(data) {
                     $scope.subGroupList = data;
                    
                 }).error(function(data) {
                 });
                 
                 $http.get('app/trialBalance/getSubAccountList').success(function(result) {
                     $scope.subAccountList = result;
                    
                 }).error(function(data) {
                 });

             

                 $http.get($stateParams.tenantid+'/app/commonUtility/getCompanyList').success(function(data) {

                     $scope.companyList = [
                          {id: 'ALL', text: 'ALL'}
                          ]
                     angular.forEach(data, function(row,index){
                         
                         $scope.companyList.push(row);

                     })
                      
                     
//                     var data = {};
//                     data["id"] = "ALL";
//                     data["text"] = "ALL";
//                     $scope.companyList.push(data);
                 }).error(function(data) {
                 });
             };
             
             
             $scope.$watch('trialBalance.subGroupCode', function(newValue, oldValue) {
                 if (newValue != '' && newValue != undefined) {
                     
                     $http.get('app/trialBalance/getAccountHeadList?subGroupCode='+newValue).success(function(datas) {
                         
                         $scope.accountHeadList=datas;
                      
                         
                         }).error(function(datas) {
                     });
                 }
            });


       $scope.costList =[];
             
             
             
             $scope.$watch('trialBalance.companyCode', function(newValue, oldValue) {
                 //  alert(newValue);
                    if(newValue!=null && newValue!=undefined && newValue != ''){
                    //    $http.post($stateParams.tenantid+ '/app/commonUtility/getVoyageListByVessel',newValue).success(function(data) {
                         $http.get('app/purchaseinvoice/getcompanycost?company=' + $scope.trialBalance.companyCode).success(function(data) {

                             $scope.trialBalance.companyCode = newValue;


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
     /*
    
    $scope.getDropDownList = function() {
        $http.get('app/trialBalance/getSubGroupList').success(function(data) {
            $scope.subGroupList = data;
        }).error(function(data) {
        });
        
       
        $http.get('app/usermaster/getCompanyList?formCode='+$('#form_code_id').val()).success(function(datas) {
            debugger;           
            $scope.companyList = datas; 
            var data = {};
            data["id"] = "ALL";
            data["text"] = "ALL";
            $scope.companyList.push(data);
           
            
            console.log("company")
            console.log($scope.companyList)
            var foundItemDest = $filter('filter')($scope.companyList, { baseCompany:  1 })[0];
            $scope.trialBalance.companyCode=foundItemDest.id;
            
             
            $timeout(function() {
                $('#txtCompanyCode').multiselect('deselectAll', false);
                $('#txtCompanyCode').multiselect('updateButtonText');
                $("#txtCompanyCode").multiselect('rebuild');
            
            }, 2, false);
            $("#multiselect-button").addClass("width_100 input-sm line-height-5");
            }).error(function(datas) {
        });
        
    };*/
    
    
    
    $scope.getDropDownList();
    
    $scope.submit=function(){
        if($scope.isRelatedParty)
            $scope.splitRelatedParty();
        else
            $scope.viewTrialBalanceReport();
    }
    
    $scope.viewTrialBalanceReport = function(){
        debugger;
        $scope.trialBalance.isGenerate = false;

        if($scope.companyCodes.length>0){
            $scope.trialBalance.companyCode=$scope.companyCodes.join(",");
        }
        console.log($scope.trialBalance.companyCode);
        
        $scope.trialBalance.fromDate = $('#fromDate').val();
        $scope.trialBalance.toDate = $('#toDate').val();
        if($scope.trialBalance.companyCode !=''){
        if($scope.trialBalance.toDate !='' && $scope.trialBalance.fromDate != '' /*&& $scope.trialBalance.companyCode !=''*/){
            $http.post('app/trialBalance/getTrialBalanceReport', $scope.trialBalance).success(function(data) {
                if(data.success){
                    debugger;
                    $scope.trialBalance.isGenerate = true;

                    console.log(data.lTrialBalanceSGLevelList);
                    $("#trialBalanceGrid").jqGrid('clearGridData'); 
                    
                    $scope.populateTrialBalanceGrid(data.lTrialBalanceSGLevelList,$scope.trialBalance);
                }else{
                    
                }
                
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        }else{
           /* if(($scope.trialBalance.toDate =='' || $scope.trialBalance.fromDate == '') && $scope.trialBalance.companyCode =='')
                logger.logError("Please select Company and valid date range");
            else if($scope.trialBalance.companyCode =='')
                logger.logError("Please select Company");
            else*/ if($scope.trialBalance.toDate =='' || $scope.trialBalance.fromDate == '')
                logger.logError("Please select valid date range");
        }
        }else{
            logger.logError("Please select atleast one company");
        }
    };
    
    $scope.splitRelatedParty = function(){
        debugger;
        $scope.trialBalance.relatedParty ='Y';
        $scope.trialBalance.fromDate = $('#fromDate').val();
        $scope.trialBalance.toDate = $('#toDate').val();
        $scope.trialBalance.txtCompanyCode = $('#txtCompanyCode').val();
       

           // $scope.trialBalance.companyCode=$scope.trialBalance.txtCompanyCode.join(",");
        
        
        if($scope.trialBalance.toDate !='' && $scope.trialBalance.fromDate != '' /*&& $scope.trialBalance.companyCode !=''*/){
            $http.post('app/trialBalance/getTrialBalanceReportRPSplitup', $scope.trialBalance).success(function(data) {
                if(data.success){
                    debugger;
                    console.log(data.lTrialBalanceSGLevelList);
                    $("#trialBalanceGrid").jqGrid('clearGridData'); 
                    $scope.populateTrialBalanceGrid(data.lTrialBalanceSGLevelList,$scope.trialBalance);
                }else{
                    
                }
                
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        }else{
            /*if(($scope.trialBalance.toDate =='' || $scope.trialBalance.fromDate == '') && $scope.trialBalance.companyCode =='')
                logger.logError("Please select Company and valid date range");
            else if($scope.trialBalance.companyCode =='')
                logger.logError("Please select Company");
            else*/ if($scope.trialBalance.toDate =='' && $scope.trialBalance.fromDate == '')
                logger.logError("Please select valid date range");
        }
    };
    
    $scope.exportExcel=function(){
        if($scope.isRelatedParty)
            $scope.exportTBExcelRPSplitup();
        else
            $scope.exportTBExcel();
    }
    
    $scope.exportExcelReport=function(){
        
          debugger;
          
          
          if($scope.companyCodes.length>0){
              $scope.trialBalance.companyCode=$scope.companyCodes.join(",");
          }
          
          
          $scope.trialBalance.fromDate = $('#fromDate').val();
          $scope.trialBalance.toDate = $('#toDate').val();
       

          
          if($scope.companyCodes.length>0){
              $scope.trialBalance.companyCode=$scope.companyCodes.join(",");
          }

          if($scope.trialBalance.toDate !='' && $scope.trialBalance.fromDate != '' /*&& $scope.trialBalance.companyCode !=''*/){
              $http.post('app/trialBalance/exportTBExcelFormatNew', $scope.trialBalance).success(function(data) {
                  if(data){
                      debugger;
                      $("#TrialBalanceReport").bind('click', function() {
                      });
                      $('#TrialBalanceReport').simulateClick('click');
                      logger.logSuccess("Exported successfully!");
                  }else{
                      logger.logError("No records found");
                  }
                  
              }).error(function(data) {
                  logger.logError("Error Please Try Again");
              });
          }else{
              /*if(($scope.trialBalance.toDate =='' || $scope.trialBalance.fromDate == '') && $scope.trialBalance.companyCode =='')
                  logger.logError("Please select Company and valid date range");
              else if($scope.trialBalance.companyCode =='')
                  logger.logError("Please select Company");
              else*/ if($scope.trialBalance.toDate =='' && $scope.trialBalance.fromDate == '')
                  logger.logError("Please select valid date range");
          }
       
    }
    
    $scope.exportTBExcel = function(){
        debugger;
        /*
        $scope.trialBalance.fromDate = $('#fromDate').val();
        $scope.trialBalance.toDate = $('#toDate').val();
       $scope.trialBalance.companyCode='';
        
       $scope.trialBalance.companyCode='';
        if($scope.companyCodes.length>0){
            $scope.trialBalance.companyCode=$scope.companyCodes.join(",");
        }
        console.log($scope.trialBalance.companyCode);*/
        
        
        if($scope.companyCodes.length>0){
            $scope.trialBalance.companyCode=$scope.companyCodes.join(",");
        }
        console.log($scope.trialBalance.companyCode);
        
        $scope.trialBalance.fromDate = $('#fromDate').val();
        $scope.trialBalance.toDate = $('#toDate').val();
        if($scope.trialBalance.companyCode !=''){
            
        
        if($scope.trialBalance.toDate !='' && $scope.trialBalance.fromDate != '' /*&& $scope.trialBalance.companyCode !=''*/){
            $http.post('app/trialBalance/exportTBExcel', $scope.trialBalance).success(function(data) {
                if(data){
                    debugger;
                    $("#TBExport").bind('click', function() {
                    });
                    $('#TBExport').simulateClick('click');
                   logger.logSuccess("Exported successfully!");
                 //   logger.logError("No records found");
 
                }else{
                    logger.logError("No Records Found");
                }
                
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        }else{
            /*if(($scope.trialBalance.toDate =='' || $scope.trialBalance.fromDate == '') && $scope.trialBalance.companyCode =='')
                logger.logError("Please select Company and valid date range");
            else if($scope.trialBalance.companyCode =='')
                logger.logError("Please select Company");
            else*/ if($scope.trialBalance.toDate =='' && $scope.trialBalance.fromDate == '')
                logger.logError("Please select valid date range");
        }
        }else{
            logger.logError("Please select atleast one company");
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
    
   
    
    $scope.exportTBExcelRPSplitup = function(){
        debugger;
        $scope.trialBalance.fromDate = $('#fromDate').val();
        $scope.trialBalance.toDate = $('#toDate').val();
        if($scope.trialBalance.toDate !='' && $scope.trialBalance.fromDate != '' /*&& $scope.trialBalance.companyCode !=''*/){
            $http.post('app/trialBalance/exportTBExcelSplitRP', $scope.trialBalance).success(function(data) {
                if(data){
                    debugger;
                    $("#TBExport").bind('click', function() {
                    });
                    $('#TBExport').simulateClick('click');
                    logger.logSuccess("Exported successfully!");
                }else{
                    //logger.logSuccess("Failed to export");
                    logger.logError("No Records Found");

                }
                
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        }else{
            /*if(($scope.trialBalance.toDate =='' || $scope.trialBalance.fromDate == '') && $scope.trialBalance.companyCode =='')
                logger.logError("Please select Company and valid date range");
            else if($scope.trialBalance.companyCode =='')
                logger.logError("Please select Company");
            else */if($scope.trialBalance.toDate =='' && $scope.trialBalance.fromDate == '')
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
    
    $scope.exportExcelWithPlain = function(){
        debugger;
        $scope.trialBalance.fromDate = $('#fromDate').val();
        $scope.trialBalance.toDate = $('#toDate').val();
       // $scope.trialBalance.companyCode='';
        
       $scope.trialBalance.companyCode='';
        if($scope.companyCodes.length>0){
            $scope.trialBalance.companyCode=$scope.companyCodes.join(",");
        }
        console.log($scope.trialBalance.companyCode);
        if($scope.trialBalance.toDate !='' && $scope.trialBalance.fromDate != ''){
            $http.post('app/trialBalance/exportTBExcelWithPlain', $scope.trialBalance).success(function(data) {
                if(data){
                    debugger;
                    $("#TBExportWithPlain").bind('click', function() {
                    });
                    $('#TBExportWithPlain').simulateClick('click');
                    logger.logSuccess("Exported successfully!");
                }else{
                    logger.logError("No Records Found");
                }
                
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        }else{
            if(($scope.trialBalance.toDate =='' || $scope.trialBalance.fromDate == '') && $scope.trialBalance.companyCode =='')
                logger.logError("Please select Company and valid date range");
            else if($scope.trialBalance.companyCode =='')
                logger.logError("Please select Company");
            else if($scope.trialBalance.toDate =='' && $scope.trialBalance.fromDate == '')
                logger.logError("Please select valid date range");
        }
    }
    
    
    //Excel PDF	
  	 $scope.exportPDF = function(){
  		  var flag = false;
  		  //if(bean.port != "" && bean.port != undefined && bean.port != null){
  	        $scope.trialBalance.fromDate = $('#fromDate').val();
  	        $scope.trialBalance.toDate = $('#toDate').val();
  	    
  	        if($scope.trialBalance.toDate !='' && $scope.trialBalance.fromDate != '' && $scope.trialBalance.companyCode !=''){
  	     	   	 $http.post('app/trialBalance/ExportPDF',$scope.trialBalance).success(function(response) {
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
  	       }else{
  	            if(($scope.trialBalance.toDate =='' || $scope.trialBalance.fromDate == '') && $scope.trialBalance.companyCode =='')
  	                logger.logError("Please select Company and valid date range");
  	            else if($scope.trialBalance.companyCode =='')
  	                logger.logError("Please select Company");
  	            else if($scope.trialBalance.toDate =='' && $scope.trialBalance.fromDate == '')
  	                logger.logError("Please select valid date range");
  	        }
  	    }
    
    function addLink(cellvalue, options, rowObject) 
    {
        $scope.companyId = $scope.trialBalance.companyCode;
        $scope.fromDate = $scope.trialBalance.fromDate;
        $scope.toDate = $scope.trialBalance.toDate ; 
        $scope.costCenter=$location.search().costCenter;
        $scope.subGroupCode = rowObject.subGroupCode;
        $scope.id=cellvalue;
        
    
      return "<a href='#/"+$stateParams.tenantid+"/reports/finance/generalLedgersubgroup?companyId="+$scope.trialBalance.companyCode+"&subGroupCode="+$scope.subGroupCode+"&id="+cellvalue+"&fromDate="+$scope.trialBalance.fromDate+"&toDate="+$scope.trialBalance.toDate +"&costCenter="+$scope.trialBalance.costCenter +"'  style='height:25px;width:120px;' type='button' title='Click to here view ledger'  target=\"_blank\" >"+cellvalue+"</a>";
        
      
    }
     $scope.ShowHideColumn = function(){
    	
        if($scope.trialBalance.opnchk=="Y"){
        	
    	  $('#trialBalanceGrid').jqGrid('showCol',["openingBalance"])

        }
       
        else{
        
    		  $('#trialBalanceGrid').jqGrid('hideCol',["openingBalance"])

        }
    }
    
    
    
    
    
 $scope.Showdebit = function(){
    	
        if($scope.trialBalance.opndeb=="Y"){
        	
    	  $('#trialBalanceGrid').jqGrid('showCol',["debitAmount"])
     	  $('#trialBalanceGrid').jqGrid('showCol',["creditAmount"])


        }
       
        else{
        
    		  $('#trialBalanceGrid').jqGrid('hideCol',["debitAmount"])
     		  $('#trialBalanceGrid').jqGrid('hideCol',["creditAmount"])

        }
    }
    
    
    $scope.Showbalance = function(){
	 	
     if($scope.trialBalance.opnbal=="Y"){
     	
 	  $('#trialBalanceGrid').jqGrid('showCol',["currentBalance"])

     }
    
     else{
     
 		  $('#trialBalanceGrid').jqGrid('hideCol',["currentBalance"])

     }
 }
    $scope.ShowHideColumn1 = function(){
	 
	// var self = this;
     //self.dealers = $('#trialBalanceGrid').jqGrid();
/*     self.dealers= $("#trialBalanceGrid").jqGrid({
     }).jqGrid('setGridParam', { data : sgListData }).trigger("reloadGrid");
*/
	 
/*	 self.dealers=  jqGrid('setGridParam', { data : sgListData }).trigger("reloadGrid"); 

     self.expandAll = function(expanded) {
       // $scope is required here, hence the injection above, even though we're using "controller as" syntax
       $scope.$broadcast('onExpandAll', {
         expanded: expanded
       });*/
    // };
 	
	 var grid = $("#trialBalanceGrid").data("jqGrid");
	 grid.expandRow(".k-master-row:first");

     
    

     
    
 }
   
    $scope.populateTrialBalanceGrid = function(sgListData,trialBalance){
        var companyCode = $("#companyCode").val();
        debugger;
        if(companyCode=='C0002'){
            $scope.currencCode= "(INR)";
        }else{
            $scope.currencCode= "";
        }
        var data=[];
        $("#trialBalanceGrid").jqGrid({
            data: sgListData,
            datatype: "local",
            multiboxonly: true,
            autowidth: true,
            height: '100%',
            rowNum: 100,
            rowList: [100,200,300],
            multiselect: false,
            loadonce: true,
            gridview:true,
            colNames : [ 'Sub Group Head Code', 'Sub Group Head Name','Opening Balance'+$scope.currencCode,'Debit'+$scope.currencCode, 'Credit'+$scope.currencCode, 'Balance'+$scope.currencCode,'Related Party' ],
            colModel:[
                {name:'subGroupCode',index:'subGroupCode', width:80, align:"left",searchoptions:{sopt:['cn']},classes: 'level_class1'},
                {name:'subGroupName',index:'subGroupName', formatter: addLink , width:80, align:"left",searchoptions:{sopt:['cn']},hidden:false,classes: 'level_class1'},
                {name:'openingBalance',index:'openingBalance', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false,classes: 'level_class1',formatter:'currency',formatoptions: { thousandsSeparator:','}},
                {name:'debitAmount',index:'debitAmount', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false,classes: 'level_class1',formatter:'currency',formatoptions: { thousandsSeparator:','}},
                {name:'creditAmount',index:'creditAmount', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false,classes: 'level_class1',formatter:'currency',formatoptions: { thousandsSeparator:','}},
                {name:'currentBalance',index:'currentBalance', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false,classes: 'level_class1',formatter:'currency',formatoptions: { thousandsSeparator:','}},
                {name:'relatedParty',index:'relatedParty', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:true,classes: 'level_class1'},
                ],
            pager: "#trialBalancePage",
            viewrecords: true,
            ignoreCase: true,
            subGrid: true,
            subGridOptions: {
                "plusicon" : 'ui-icon-plus',
                "minusicon" : 'ui-icon-minus'
            },
            footerrow: true,
           
            loadComplete: function () {
                var $grid = $('#trialBalanceGrid');
                var credit = $grid.jqGrid('getCol', 'creditAmount', false, 'sum');
                var debit = $grid.jqGrid('getCol', 'debitAmount', false, 'sum');
                credit = credit.toFixed(2);
                debit=debit.toFixed(2);
                var difference = (debit - credit).toFixed(2);
                $(this).jqGrid('footerData','set',{ subGroupName:'Total', creditAmount:credit,debitAmount:debit,currentBalance:difference});
                
                var celValue = $('#trialBalanceGrid').getCol('subGroupCode',true);
               var grid =$('#trialBalanceGrid');
                if(celValue != undefined){
                    debugger;
                    for ( var i = 0; i < celValue.length; i++) {                            
                        var highlightid =celValue[i].id;
                        var highlightvalue = celValue[i].value;
                        if (highlightvalue=="RELATED PARTY") {
                            $("#trialBalanceGrid").jqGrid('setCell',highlightid,"subGroupCode","",{'background-color':'#FFFF00','color':'#000000','background-image':'none','opacity':'0.75'});
                            $("#trialBalanceGrid").jqGrid('setCell',highlightid,"subGroupName","",{'background-color':'#FFFF00','color':'#FFFF00','background-image':'none','opacity':'0.75'});
                            $("#trialBalanceGrid").jqGrid('setCell',highlightid,"debitAmount","",{'background-color':'#FFFF00','color':'#FFFF00','background-image':'none','opacity':'0.75'});
                            $("#trialBalanceGrid").jqGrid('setCell',highlightid,"creditAmount","",{'background-color':'#FFFF00','color':'#FFFF00','background-image':'none','opacity':'0.75'});
                            $("#trialBalanceGrid").jqGrid('setCell',highlightid,"currentBalance","",{'background-color':'#FFFF00','color':'#FFFF00','background-image':'none','opacity':'0.75'});
                            $("#trialBalanceGrid").jqGrid('setCell',highlightid,"creditAmount","");
                            $('tr#'+highlightid, grid).children("td.sgcollapsed").html("")
                            .removeClass('ui-sgcollapsed sgcollapsed');
                        }

                    }
                }
            },
           
          
            subGridRowExpanded: function(subgrid_id, row_id) {
                debugger;
                var subgrid_table_id, pager_id; subgrid_table_id = subgrid_id+"_t";
                pager_id = "p_"+subgrid_table_id;
                var rowData = jQuery('#trialBalanceGrid').jqGrid ('getRowData', row_id);
                $scope.trialBalance.filterCode =rowData.subGroupCode;
                var Ahurl ='';
                if($scope.trialBalance.relatedParty =='N'){
                    Ahurl ='app/trialBalance/getTrialBalanceAHLevel';
                }else{
                    if(rowData.relatedParty=='Y')
                        Ahurl='app/trialBalance/getTrialBalanceAHLevelRPonly';
                    else
                        Ahurl='app/trialBalance/getTrialBalanceAHLevelExcludeRp';
                }
                    
                $("#"+subgrid_id).html("<table id='"+subgrid_table_id+"' class='scroll'></table><div id='"+pager_id+"' class='scroll'></div>");
                $http.post(Ahurl,$scope.trialBalance).success(function(data) {
                 if(data.success){
                     debugger;
                     var tbAHlevelDataList =data.lTrialBalanceAHLevelList;
                     $("#"+subgrid_table_id).jqGrid({
                     datatype: "local",
                     data: tbAHlevelDataList,
                     colNames:['Acct Head Code','Acct Head Name','Opening Bal','Debit','Credit','Current Bal','Related Party'],
                     colModel:[
                            {name:'acctHeadCode',index:'acctHeadCode', width:200, align:"left",searchoptions:{sopt:['cn']},classes: 'level_class2'},
                            {name:'acctHeadName',index:'acctHeadName', width:200, align:"left",searchoptions:{sopt:['cn']},hidden:false,classes: 'level_class2'},
                            {name:'openingBalance',index:'openingBalance', width:200,align:"right", searchoptions:{sopt:['cn']},hidden:false,classes: 'level_class2'},
                            {name:'debitAmount',index:'debitAmount', width:200,align:"right", searchoptions:{sopt:['cn']},hidden:false,classes: 'level_class2'},
                            {name:'creditAmount',index:'creditAmount', width:200,align:"right", searchoptions:{sopt:['cn']},hidden:false,classes: 'level_class2'},
                            {name:'currentBalance',index:'currentBalance', width:200,align:"right", searchoptions:{sopt:['cn']},hidden:false,classes: 'level_class2'},
                            {name:'relatedParty',index:'relatedParty', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:true,classes: 'level_class2'},
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
                     

                     subGridRowExpanded: function(subgrid_child_id, row_id) {
                         debugger;
                         var subgridchild_table_id, pager_id; subgridchild_table_id = subgrid_child_id+"_t";
                         pager_id = "p_"+subgridchild_table_id;
                         var ahrowData = jQuery('#'+subgrid_table_id).jqGrid ('getRowData', row_id);
                         $scope.trialBalance.acctHeadCode =ahrowData.acctHeadCode;
                         var transactionURL='';
                         if($scope.trialBalance.relatedParty =='N'){
                             transactionURL ='app/trialBalance/getTrialBalanceSALevel';
                         }else{
                             if(ahrowData.relatedParty=='Y')
                                 transactionURL='app/trialBalance/getTrialBalanceSALevelRPonly';
                             else
                                 transactionURL='app/trialBalance/getTrialBalanceSALevelExcludeRP';
                         }
                         
                         $("#"+subgrid_child_id).html("<table id='"+subgridchild_table_id+"' class='scroll'></table><div id='"+pager_id+"' class='scroll'></div>");
                         $http.post(transactionURL,$scope.trialBalance).success(function(data) {
                          if(data.success){
                              debugger;
                              var tbTransactionlevelDataList =data.lTrialBalanceTransactionLevelList;
                              $("#"+subgridchild_table_id).jqGrid({
                              datatype: "local",
                              data: tbTransactionlevelDataList,
                              colNames:['Transaction No','Sub Account code','Sub Account Name','Opening Bal','Debit','Credit','Current Bal'],
                              colModel:[
                                  {name:'transactionNo',index:'transactionNo', width:200, align:"left",searchoptions:{sopt:['cn']},hidden:false,classes: 'level_class3'},
                                 {name:'subAccountCode',index:'subAccountCode', width:200, align:"left",searchoptions:{sopt:['cn']},
                                     classes: 'level_class3 cursor-pointer'},
                                 {name:'subAccountName',index:'subAccountName', width:200, align:"left",searchoptions:{sopt:['cn']},hidden:false,classes: 'level_class3'},
                                 {name:'openingBalance',index:'openingBalance', width:200,align:"right", searchoptions:{sopt:['cn']},hidden:false,classes: 'level_class3'},
                                 {name:'debitAmount',index:'debitAmount', width:200,align:"right", searchoptions:{sopt:['cn']},hidden:false,classes: 'level_class3'},
                                 {name:'creditAmount',index:'creditAmount', width:200,align:"right", searchoptions:{sopt:['cn']},hidden:false,classes: 'level_class3'},
                                 {name:'currentBalance',index:'currentBalance', width:200,align:"right", 
                                     searchoptions:{sopt:['cn']},hidden:false,classes: 'level_class3'},
                                 ],
                                 onCellSelect: function(rowid, iCol){
                                     var cm = jQuery("#"+subgridchild_table_id).jqGrid("getGridParam", "colModel");
                                     var transactionNoCell = jQuery("#"+subgridchild_table_id).jqGrid("getCell", rowid, "transactionNo");
                                     var colName = cm[iCol];
                                     console.log(colName);
                                     if(colName.name=="transactionNo"){
                                         utilsService.reportVoucherPrint(transactionNoCell);
                                     }
                                 },
                              autowidth: true,
                              height: '100%',
                              pager: pager_id,
                              sortname: 'num',
                              sortorder: "asc", }).jqGrid('setGridParam', { data : tbTransactionlevelDataList }).trigger("reloadGrid");
                          }
                         
                         }).error(function(tbAHlevelDataList) {
                         });
                      } }).jqGrid('setGridParam', { data : tbAHlevelDataList }).trigger("reloadGrid");
                 }
                
                }).error(function(tbAHlevelDataList) {
                });
             }
        }).jqGrid('setGridParam', { data : sgListData }).trigger("reloadGrid");
        
    }
})
//});