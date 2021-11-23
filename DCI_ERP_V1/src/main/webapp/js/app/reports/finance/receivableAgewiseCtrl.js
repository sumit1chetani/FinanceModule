'use strict';
app.service('shareArAgeWiseObject',function(){
    var obj={};
    return{
        getObj:function(){
            return obj;
        },
        setObj:function(newObj){
            obj=newObj;
        }
    }
})
app.controller('receivableAgewiseCtrl', function($templateCache,shareArAgeWiseObject, $scope,$state, $rootScope, $http, logger, $log, ngDialog, $modal, $location, $sce, $filter,$stateParams) {
    
    $('#ar_fromDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime: false
    });
    $scope.depName=$('#departmentName').val();
    $scope.arAgewise = {
            companyCode:'',
            fromDate:'',
            customerCode:'',
             paymentCenter : '',
             srvcPrtnrBin:'',
             type:'',
             salesPersonCode:'',
    };
    
    $scope.typeList=[{
        id : '10080003',
        text : 'Sundry Debtors - Local'
    }, {
        id : '10080002',
        text : 'Sundry Debtors - Overseas'
    }];
    
    $http.post($stateParams.tenantid+'/app/dashboard/getUserObj').success(function(datas){
        $scope.userId = datas.userId;
        $scope.companyCode=datas.companyCode;
    }).error(function(datas) {
    });
    
    $scope.mandatoryCheck = false;
    if($scope.depName != 'Sales' && $scope.depName != 'Sales Department'){
    	$scope.mandatoryCheck = false;
    }else{
    	$scope.mandatoryCheck = true;
    }
    $http.get($stateParams.tenantid+'/app/airquotation/getSalesPerson').success(function(datas) {
		 $scope.employeeList = datas.commonUtilityBean;
		 
		 if($scope.depName != 'Sales' && $scope.depName != 'Sales Department'){
			 var data = {};
		        
				data["id"] = "ALL";
				data["text"] = "ALL";
				$scope.employeeList.push(data);
		 }
	       
	    
	});
  
  /*  $http.get($stateParams.tenantid+'/app/payer/getListOfDropdowns').success(function(data) {
        if (data.success == true) {
            $scope.paymentCenterList = data.paymentCenterList;
            console.log( "$scope.paymentCenterList")
            console.log( $scope.paymentCenterList)
        }
    });*/

    $scope.reset = function() {
    	//$scope.arAgewise = {};
        $scope.arAgewise = {
        		 companyCode:'',
                 fromDate:'',
                 customerCode:'',
                  paymentCenter : '',
                  srvcPrtnrBin:'',
                  type:'',
                  salesPersonCode:'',
        };
        $("#arAgewiseReportGrid").jqGrid('clearGridData'); 
    };
    $scope.receivableEntry=function(){

        $scope.arAgewise.fromDate = $('#fromDate').val();
        console.log("ssd")
        shareArAgeWiseObject.setObj($scope.arAgewise);
       debugger
       if($scope.arAgewise.companyCode == ''){
            logger.logError('Please select the company. ')
        }else if($scope.arAgewise.fromDate ==''){
            logger.logError('Please select date. ')
        }else{
        $state.go('app.reports.finance.receivableAgewise-entry',{tenantid:$stateParams.tenantid});
        }
    }
    
 /*   $http.get('app/commonUtility/getCompanyList').success(function(datas) {
        $scope.companyList = datas;
        }).error(function(datas) {
    });*/
    
    
    $http.get($stateParams.tenantid+'/app/usermaster/getCompanyList?formCode='+$('#form_code_id').val()).success(function(datas) {
        debugger;           
        $scope.companyList = datas; 
        if($scope.depName != 'Sales' && $scope.depName != 'Sales Department'){
        var data = {};
		data["id"] = "ALL";
		data["text"] = "ALL";
		$scope.companyList.push(data);
        }
		
        console.log("company")
        console.log($scope.companyList)
        var foundItemDest = $filter('filter')($scope.companyList, { baseCompany:  1 })[0];
      $scope.arAgewise.companyCode=foundItemDest.id;
        
        }).error(function(datas) {
    });
    
    $scope.customerList=[];
    $http.post($stateParams.tenantid+'/app/arAgewise/getCustomerList').success(function(data) {
        if(data.success){
        	$scope.customerList = data.selectivitybean;
        }else{
            logger.logError("No data found");
        }
        
    }).error(function(data) {
        
    });
    
    $scope.isPrimary=false;
    $scope.isSecondary =false;
    $scope.isFormat3 =false;
    $scope.viewARReceivableAgewise=function(){
        $scope.isPrimary=true;
        $scope.isSecondary =false;
        $scope.isFormat3 =false;
        $scope.arAgewise.fromDate = $('#fromDate').val();
        if($scope.arAgewise.fromDate != '' ){
        	if($scope.arAgewise.companyCode != ''){
        		if($scope.mandatoryCheck==true){
        			if($scope.arAgewise.salesPersonCode != ''){
        	            console.log("$scope.arAgewise")
        	            console.log($scope.arAgewise)
        	            $http.post($stateParams.tenantid+'/app/arAgewise/getArAgewiseHdr', $scope.arAgewise).success(function(data) {
        	            	if($scope.arAgewise.type == '10080002'){
        	            		$scope.dummy= true;
        	            		if(data.success){
        	                        debugger;
        	                        console.log(data.lReceivableAgewiseHdrList);
        	                        /*$('.chartsbar div').remove();
        	                        $('#arAgewiseReportGrid').append('<div id="jqgrid"></div>');*/
        	                        $("#arAgewiseReportGridTcAmount").jqGrid('clearGridData'); 
        	                        $("#arAgewiseReportSecondaryGrid").jqGrid('clearGridData');
        	                        console.log("data.lReceivableAgewiseHdrList")
        	                        console.log(data.lReceivableAgewiseHdrList)
        	              
        	                        $scope.populateARReceivableAgewiseGridTcAmount(data.lReceivableAgewiseHdrList);
        	                    }else{
        	                        logger.logError("No data found");
        	                    }
        	            	}else{
        	            		$scope.dummy= false;
        	            		if(data.success){
        	                        debugger;
        	                        console.log(data.lReceivableAgewiseHdrList);
        	                        $("#arAgewiseReportGrid").jqGrid('clearGridData'); 
        	                        $("#arAgewiseReportSecondaryGrid").jqGrid('clearGridData');
        	                        console.log("data.lReceivableAgewiseHdrList")
        	                        console.log(data.lReceivableAgewiseHdrList)
        	              
        	                        $scope.populateARReceivableAgewiseGrid(data.lReceivableAgewiseHdrList);
        	                    }else{
        	                        logger.logError("No data found");
        	                    }
        	            	}
        	                
        	                
        	            }).error(function(data) {
        	                logger.logError("Error Please Try Again");
        	            });
        	        		}else{
        	                    logger.logError("Please select sales person!");
        	            }
        		}else{

    	            console.log("$scope.arAgewise")
    	            console.log($scope.arAgewise)
    	            $http.post($stateParams.tenantid+'/app/arAgewise/getArAgewiseHdr', $scope.arAgewise).success(function(data) {
    	            	if($scope.arAgewise.type == '10080002'){
    	            		$scope.dummy= true;
    	            		if(data.success){
    	                        debugger;
    	                        console.log(data.lReceivableAgewiseHdrList);
    	                        /*$('.chartsbar div').remove();
    	                        $('#arAgewiseReportGrid').append('<div id="jqgrid"></div>');*/
    	                        $("#arAgewiseReportGridTcAmount").jqGrid('clearGridData'); 
    	                        $("#arAgewiseReportSecondaryGrid").jqGrid('clearGridData');
    	                        console.log("data.lReceivableAgewiseHdrList")
    	                        console.log(data.lReceivableAgewiseHdrList)
    	              
    	                        $scope.populateARReceivableAgewiseGridTcAmount(data.lReceivableAgewiseHdrList);
    	                    }else{
    	                        logger.logError("No data found");
    	                    }
    	            	}else{
    	            		$scope.dummy= false;
    	            		if(data.success){
    	                        debugger;
    	                        console.log(data.lReceivableAgewiseHdrList);
    	                        $("#arAgewiseReportGrid").jqGrid('clearGridData'); 
    	                        $("#arAgewiseReportSecondaryGrid").jqGrid('clearGridData');
    	                        console.log("data.lReceivableAgewiseHdrList")
    	                        console.log(data.lReceivableAgewiseHdrList)
    	              
    	                        $scope.populateARReceivableAgewiseGrid(data.lReceivableAgewiseHdrList);
    	                    }else{
    	                        logger.logError("No data found");
    	                    }
    	            	}
    	                
    	                
    	            }).error(function(data) {
    	                logger.logError("Error Please Try Again");
    	            });
    	        		
        		}
        		
        		
        	  }else{
                  logger.logError("Please select company!");
          }
        }else{
                logger.logError("Please select valid date!");
        }
    }
    
    $scope.viewARReceivableAgewiseSecondary=function(){
        $scope.isPrimary=false;
        $scope.isSecondary =true;
        $scope.isFormat3 =false;
        $scope.arAgewise.fromDate = $('#fromDate').val();
        if($scope.arAgewise.fromDate != '' ){
            $http.post($stateParams.tenantid+'/app/arAgewise/getArAgewiseHdr', $scope.arAgewise).success(function(data) {
                if(data.success){
                    debugger;
                    console.log(data.lReceivableAgewiseHdrList);
                    $("#arAgewiseReportGrid").jqGrid('clearGridData'); 
                    $("#arAgewiseReportSecondaryGrid").jqGrid('clearGridData'); 
                    $scope.populateARReceivableAgewiseGridSecondary(data.lReceivableAgewiseHdrList);
                }else{
                    logger.logError("No data found");
                }
                
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        }else{
                logger.logError("Please select valid date");
        }
    }
    
    $scope.viewARReceivableAgewiseFormat3=function(){
        $scope.isPrimary=false;
        $scope.isSecondary =false;
        $scope.isFormat3 =true;
        $scope.arAgewise.fromDate = $('#fromDate').val();
        if($scope.arAgewise.fromDate != '' ){
            $http.post($stateParams.tenantid+'/app/arAgewise/getArAgewiseHdr', $scope.arAgewise).success(function(data) {
                if(data.success){
                    debugger;
                    console.log(data.lReceivableAgewiseHdrList);
                    $("#arAgewiseReportGrid").jqGrid('clearGridData'); 
                    $("#arAgewiseReportSecondaryGrid").jqGrid('clearGridData'); 
                    $("#arAgewiseReportFomrat3Grid").jqGrid('clearGridData'); 
                    $scope.populateARReceivableAgewiseGridFormat3(data.lReceivableAgewiseHdrList);
                }else{
                    logger.logError("No data found");
                }
                
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        }else{
                logger.logError("Please select valid date");
        }
    }
    $scope.exportARReceivableAgewise=function(){
        debugger;
        $scope.arAgewise.fromDate = $('#fromDate').val();
        if($scope.arAgewise.fromDate != '' ){
            $http.post($stateParams.tenantid+'/app/arAgewise/exportARAgewiseExcel', $scope.arAgewise).success(function(data) {
                if(data.success){
                    debugger;
                    $("#ARReceivableExport").bind('click', function() {
                    });
                    $('#ARReceivableExport').simulateClick('click');
                    logger.logSuccess("Exported successfully!");
                }else{
                    logger.logSuccess("Failed to export");
                }
                
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        }else{
                logger.logError("Please select valid date");
        }
    }
    
    $scope.exportARReceivableAgewiseSecondary=function(){
        debugger;
        $scope.arAgewise.fromDate = $('#fromDate').val();
        if($scope.arAgewise.type != '' ){
            $http.post($stateParams.tenantid+'/app/arAgewise/exportARReceivableAgewiseSecondary', $scope.arAgewise).success(function(data) {
                if(data.success){
                    debugger;
                    $("#ARReceivableExport").bind('click', function() {
                    });
                    $('#ARReceivableExport').simulateClick('click');
                    logger.logSuccess("Exported successfully!");
                }else{
                    logger.logSuccess("Failed to export");
                }
                
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        }else{
                logger.logError("Please select valid date");
        }
    }
    
    $scope.exportARReceivableAgewiseFormat3=function(){
        debugger;
        $scope.arAgewise.fromDate = $('#fromDate').val();
        if($scope.arAgewise.fromDate != '' ){
            $http.post($stateParams.tenantid+'/app/arAgewise/exportARReceivableAgewiseFormat3', $scope.arAgewise).success(function(data) {
                if(data.success){
                    debugger;
                    $("#ARReceivableExport").bind('click', function() {
                    });
                    $('#ARReceivableExport').simulateClick('click');
                    logger.logSuccess("Exported successfully!");
                }else{
                    logger.logSuccess("Failed to export");
                }
                
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        }else{
                logger.logError("Please select valid date");
        }
    }
    
    $scope.exportAPPayableAgewise=function(){
        $scope.arAgewise.fromDate = $('#fromDate').val();
        if($scope.arAgewise.fromDate != '' ){
            $http.post($stateParams.tenantid+'/app/arAgewise/exportARReceivableAgewiseFormat4', $scope.arAgewise).success(function(data) {
                if(data.success){
	var fileName=data.excelExportPath.split('/');
                   /* $("#ARReceivableExport").bind('click', function() {
                    });
                    $('#ARReceivableExport').simulateClick('click');*/
 $('#ARReceivableExport').attr('href','filePath/' +fileName[4]);
			    $("#ARReceivableExport").bind('click', function() {
			   });
			   $('#ARReceivableExport').simulateClick('click');
                    logger.logSuccess("Exported successfully!");
                }else{
                    logger.logSuccess("Failed to export");
                }
                
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        }else{
                logger.logError("Please select valid date");
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
    
    $scope.populateARReceivableAgewiseGrid = function(hdrData){
        debugger;
        var data=[];
        $("#arAgewiseReportGrid").jqGrid({
            data: hdrData,
            datatype: "local",
            multiboxonly: true,
            autowidth: false,
            width: '1614.01',
            height: '100%',
            rowList: [10,20,30],
            multiselect: false,
            loadonce: true,
            gridview:true,
            colNames : [ 'Customer Code', 'Customer Name','Sales Person','Balance Amount','0-30 Days','31-45 Days','46 - 60 Days','61 - 90 Days','91 - 180 Days','180 - 360 Days','Over 360 Days' ],
            colModel:[
                {name:'customerCode',index:'customerCode', width:80, align:"left",searchoptions:{sopt:['cn']}},
                {name:'customerName',index:'customerName', width:200, align:"left",searchoptions:{sopt:['cn']},hidden:false},
                {name:'salesPerson',index:'salesPerson', width:150, align:"left",searchoptions:{sopt:['cn']},hidden:false},
                {name:'balanceAmount',index:'balanceAmount', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
               // {name:'below15Days',index:'below15Days', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false},
                {name:'days30',index:'days30', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                {name:'days45',index:'days45', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                {name:'days45to60',index:'days45to60', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                {name:'days60andabove',index:'days60andabove', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                {name:'days90andabove',index:'days90andabove', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
               // {name:'days100andabove',index:'days100andabove', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false},
               // {name:'days120andabove',index:'days120andabove', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false},
                {name:'above180days',index:'above180days', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
//                {name:'location',index:'location', width:80, align:"left",searchoptions:{sopt:['cn']}},
                {name:'above360days',index:'above360days', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                
                ],
                
            pager: "#arAgewiseReportGridPage",
            viewrecords: true,
            ignoreCase: true,
            subGrid: true,
            subGridOptions: {
                "plusicon" : 'ui-icon-plus',
                "minusicon" : 'ui-icon-minus'
            },
            footerrow: true,
            loadComplete: function () {
                var balanceAmount=0,below15Days = 0,days30=0,days45=0,days45to60=0,days60andabove=0,
                days90andabove=0, days100andabove=0,days120andabove=0,above180days=0,above360days=0;
               var rows= jQuery("#arAgewiseReportGrid").jqGrid('getRowData');
               for(var i=0;i<rows.length;i++){
                  var row=rows[i];
                 
                  balanceAmount += Number(row['balanceAmount']);
                 /* below15Days += Number(row['below15Days']);*/
                  days30 += Number(row['days30']);
                  days45 += Number(row['days45']);
                  days45to60 += Number(row['days45to60']);
                  days60andabove += Number(row['days60andabove']);
                  
                  days90andabove += Number(row['days90andabove']);
                  /*days100andabove += Number(row['days100andabove']);
                  days120andabove += Number(row['days120andabove']);*/
                  above180days += Number(row['above180days']);
above360days += Number(row['above360days']);
              }
           
               $(this).jqGrid('footerData','set',{ customerName:'Total', balanceAmount:balanceAmount.toFixed(2)});
               /*$(this).jqGrid('footerData','set',{ customerName:'Total', below15Days:below15Days.toFixed(2)});*/
               $(this).jqGrid('footerData','set',{ customerName:'Total', days30:days30.toFixed(2)});
               $(this).jqGrid('footerData','set',{ customerName:'Total', days45:days45.toFixed(2)});
               $(this).jqGrid('footerData','set',{ customerName:'Total', days45to60:days45to60.toFixed(2)});
               $(this).jqGrid('footerData','set',{ customerName:'Total', days60andabove:days60andabove.toFixed(2)});
               
               $(this).jqGrid('footerData','set',{ customerName:'Total', days90andabove:days90andabove.toFixed(2)});
        /*       $(this).jqGrid('footerData','set',{ customerName:'Total', days100andabove:days100andabove.toFixed(2)});
               $(this).jqGrid('footerData','set',{ customerName:'Total', days120andabove:days120andabove.toFixed(2)});*/
               $(this).jqGrid('footerData','set',{ customerName:'Total', above180days:above180days.toFixed(2)});
 $(this).jqGrid('footerData','set',{ customerName:'Total', above360days:above360days.toFixed(2)});
               
           },

           gridComplete: function() {
                  var $grid = $('#arAgewiseReportGrid');
                  /*var credit = $grid.jqGrid('getCol', 'credit', false, 'sum');
                  var debit = $grid.jqGrid('getCol', 'debit', false, 'sum');*/
                  var balance = $grid.jqGrid('getCol', 'balanceAmount', false, 'sum');
                  /*var below15Days = $grid.jqGrid('getCol', 'below15Days', false, 'sum');*/
                  var days30 = $grid.jqGrid('getCol', 'days30', false, 'sum');
                  var days45 = $grid.jqGrid('getCol', 'days45', false, 'sum');
                  var days45to60 = $grid.jqGrid('getCol', 'days45to60', false, 'sum');
                  var days60andabove = $grid.jqGrid('getCol', 'days60andabove', false, 'sum');
                  
                  var days90andabove = $grid.jqGrid('getCol', 'days90andabove', false, 'sum');
                  /*var days100andabove = $grid.jqGrid('getCol', 'days100andabove', false, 'sum');
                  var days120andabove = $grid.jqGrid('getCol', 'days120andabove', false, 'sum');*/
                  var above180days = $grid.jqGrid('getCol', 'above180days', false, 'sum');
var above360days = $grid.jqGrid('getCol', 'above360days', false, 'sum');
                  
                  $(this).jqGrid('footerData','set',{ groupHeadName:'Total',balance:balance,/*below15Days:below15Days,*/
                      days30:days30,days45:days45,days45to60:days45to60,days60andabove:days60andabove,days90andabove:days90andabove,
                      /*days100andabove:days100andabove,days120andabove:days120andabove,*/above180days:above180days,above360days:above360days});
              },
            subGridRowExpanded: function(subgrid_id, row_id) {
                debugger;
                var subgrid_table_id, pager_id; subgrid_table_id = subgrid_id+"_t";
                pager_id = "p_"+subgrid_table_id;
                var rowData = jQuery('#arAgewiseReportGrid').jqGrid ('getRowData', row_id);
                $scope.arAgewise.customerCode =rowData.customerCode;
                    
                $("#"+subgrid_id).html("<table id='"+subgrid_table_id+"' class='scroll'></table><div id='"+pager_id+"' class='scroll'></div>");
                $http.post($stateParams.tenantid+'/app/arAgewise/getArAgewiseDtl',$scope.arAgewise).success(function(data) {
                 if(data.success){
                     debugger;
                     var dtlDataList =data.lReceivableAgewiseDtlList;
                     $("#"+subgrid_table_id).jqGrid({
                     datatype: "local",
                     data: dtlDataList,
                     colNames : [ 'Invoice No', 'Invoice Date','Balance Amount', '0-30 Days','31-45 Days','46 - 60 Days','61 - 90 Days','91 - 180 Days','180 - 360 Days','Over 360 Days' ],
                     colModel:[
                               {name:'invoiceNo',index:'invoiceNo', width:80, align:"left",searchoptions:{sopt:['cn']}},
                               {name:'invoiceDate',index:'invoiceDate', width:80, align:"left",searchoptions:{sopt:['cn']},hidden:false},
                               {name:'balanceAmount',index:'balanceAmount', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                               /*{name:'below15Days',index:'below15Days', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false},*/
                               {name:'days30',index:'days30', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                               {name:'days45',index:'days45', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                               {name:'days45to60',index:'days45to60', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                               {name:'days60andabove',index:'days60andabove', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                               {name:'days90andabove',index:'days90andabove', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                               /*{name:'days100andabove',index:'days100andabove', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false},
                               {name:'days120andabove',index:'days120andabove', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false},*/
                               {name:'above180days',index:'above180days', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
{name:'above360days',index:'above360days', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                        ],
                     autowidth: true,
                     height: '100%',
                     pager: pager_id,
                     sortname: 'num',
                     sortorder: "asc",
                     // transaction level
                     subGrid: false,
                     }).jqGrid('setGridParam', { data : dtlDataList }).trigger("reloadGrid");
                 }
                
                }).error(function(dtlDataList) {
                });
             }
        }).jqGrid('setGridParam', { data : hdrData }).trigger("reloadGrid");
        $("#arAgewiseReportGrid").jqGrid('navGrid',"#arAgewiseReportGridPage",{edit:false,search:false,refresh:false,add:false,del:false});
    }
    
    //with TC Amount
    $scope.populateARReceivableAgewiseGridTcAmount = function(hdrData){
        debugger;
        var data=[];
        $("#arAgewiseReportGridTcAmount").jqGrid({
            data: hdrData,
            datatype: "local",
            multiboxonly: true,
            autowidth: false,
            width: '1614.01',
            height: '100%',
            rowList: [10,20,30],
            multiselect: false,
            loadonce: true,
            gridview:true,
            colNames : [ 'Customer Code', 'Customer Name','Sales Person','Balance Amount','TC Balance','0-30 Days','31-45 Days','46 - 60 Days','61 - 90 Days','91 - 180 Days','Over 180 Days' ],
            colModel:[
                {name:'customerCode',index:'customerCode', width:80, align:"left",searchoptions:{sopt:['cn']}},
                {name:'customerName',index:'customerName', width:200, align:"left",searchoptions:{sopt:['cn']},hidden:false},
                {name:'salesPerson',index:'salesPerson', width:150, align:"left",searchoptions:{sopt:['cn']},hidden:false},
                {name:'balanceAmount',index:'balanceAmount', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                {name:'balancetc',index:'balancetc', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
               // {name:'below15Days',index:'below15Days', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false},
                {name:'days30',index:'days30', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                {name:'days45',index:'days45', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                {name:'days45to60',index:'days45to60', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                {name:'days60andabove',index:'days60andabove', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                {name:'days90andabove',index:'days90andabove', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
               // {name:'days100andabove',index:'days100andabove', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false},
               // {name:'days120andabove',index:'days120andabove', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false},
                {name:'above180days',index:'above180days', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
  {name:'above360days',index:'above360days', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
//                {name:'location',index:'location', width:80, align:"left",searchoptions:{sopt:['cn']}},
                
                ],
                
            pager: "#arAgewiseReportGridPageTcAmount",
            viewrecords: true,
            ignoreCase: true,
            subGrid: true,
            subGridOptions: {
                "plusicon" : 'ui-icon-plus',
                "minusicon" : 'ui-icon-minus'
            },
            footerrow: true,
            loadComplete: function () {
                var balanceAmount=0,balancetc = 0,below15Days = 0,days30=0,days45=0,days45to60=0,days60andabove=0,
                days90andabove=0, days100andabove=0,days120andabove=0,above180days=0,above360days=0;
               var rows= jQuery("#arAgewiseReportGridTcAmount").jqGrid('getRowData');
               for(var i=0;i<rows.length;i++){
                  var row=rows[i];
                 
                  balanceAmount += Number(row['balanceAmount']);
                  balancetc += Number(row['balancetc']);
                 /* below15Days += Number(row['below15Days']);*/
                  days30 += Number(row['days30']);
                  days45 += Number(row['days45']);
                  days45to60 += Number(row['days45to60']);
                  days60andabove += Number(row['days60andabove']);
                  
                  days90andabove += Number(row['days90andabove']);
                  /*days100andabove += Number(row['days100andabove']);
                  days120andabove += Number(row['days120andabove']);*/
                  above180days += Number(row['above180days']);
above360days += Number(row['above360days']);
              }
           
               $(this).jqGrid('footerData','set',{ customerName:'Total', balanceAmount:balanceAmount.toFixed(2)});
               $(this).jqGrid('footerData','set',{ customerName:'Total', balancetc:balancetc.toFixed(2)});
               /*$(this).jqGrid('footerData','set',{ customerName:'Total', below15Days:below15Days.toFixed(2)});*/
               $(this).jqGrid('footerData','set',{ customerName:'Total', days30:days30.toFixed(2)});
               $(this).jqGrid('footerData','set',{ customerName:'Total', days45:days45.toFixed(2)});
               $(this).jqGrid('footerData','set',{ customerName:'Total', days45to60:days45to60.toFixed(2)});
               $(this).jqGrid('footerData','set',{ customerName:'Total', days60andabove:days60andabove.toFixed(2)});
               
               $(this).jqGrid('footerData','set',{ customerName:'Total', days90andabove:days90andabove.toFixed(2)});
        /*       $(this).jqGrid('footerData','set',{ customerName:'Total', days100andabove:days100andabove.toFixed(2)});
               $(this).jqGrid('footerData','set',{ customerName:'Total', days120andabove:days120andabove.toFixed(2)});*/
               $(this).jqGrid('footerData','set',{ customerName:'Total', above180days:above180days.toFixed(2)});
               $(this).jqGrid('footerData','set',{ customerName:'Total', above360days:above360days.toFixed(2)});

               
           },

           gridComplete: function() {
                  var $grid = $('#arAgewiseReportGridTcAmount');
                  /*var credit = $grid.jqGrid('getCol', 'credit', false, 'sum');
                  var debit = $grid.jqGrid('getCol', 'debit', false, 'sum');*/
                  var balance = $grid.jqGrid('getCol', 'balanceAmount', false, 'sum');
                  var balancetc = $grid.jqGrid('getCol', 'balancetc', false, 'sum');
                  /*var below15Days = $grid.jqGrid('getCol', 'below15Days', false, 'sum');*/
                  var days30 = $grid.jqGrid('getCol', 'days30', false, 'sum');
                  var days45 = $grid.jqGrid('getCol', 'days45', false, 'sum');
                  var days45to60 = $grid.jqGrid('getCol', 'days45to60', false, 'sum');
                  var days60andabove = $grid.jqGrid('getCol', 'days60andabove', false, 'sum');
                  
                  var days90andabove = $grid.jqGrid('getCol', 'days90andabove', false, 'sum');
                  /*var days100andabove = $grid.jqGrid('getCol', 'days100andabove', false, 'sum');
                  var days120andabove = $grid.jqGrid('getCol', 'days120andabove', false, 'sum');*/
                  var above180days = $grid.jqGrid('getCol', 'above180days', false, 'sum');
                   var above360days = $grid.jqGrid('getCol', 'above360days', false, 'sum');
                  $(this).jqGrid('footerData','set',{ groupHeadName:'Total',balance:balance,balancetc:balancetc,/*below15Days:below15Days,*/
                      days30:days30,days45:days45,days45to60:days45to60,days60andabove:days60andabove,days90andabove:days90andabove,
                      /*days100andabove:days100andabove,days120andabove:days120andabove,*/above180days:above180days,above360days:above360days});
              },
            subGridRowExpanded: function(subgrid_id, row_id) {
                debugger;
                var subgrid_table_id, pager_id; subgrid_table_id = subgrid_id+"_t";
                pager_id = "p_"+subgrid_table_id;
                var rowData = jQuery('#arAgewiseReportGridTcAmount').jqGrid ('getRowData', row_id);
                $scope.arAgewise.customerCode =rowData.customerCode;
                    
                $("#"+subgrid_id).html("<table id='"+subgrid_table_id+"' class='scroll'></table><div id='"+pager_id+"' class='scroll'></div>");
                $http.post($stateParams.tenantid+'/app/arAgewise/getArAgewiseDtl',$scope.arAgewise).success(function(data) {
                 if(data.success){
                     debugger;
                     var dtlDataList =data.lReceivableAgewiseDtlList;
                     $("#"+subgrid_table_id).jqGrid({
                     datatype: "local",
                     data: dtlDataList,
                     colNames : [ 'Invoice No', 'Invoice Date','Balance Amount','Tc Balance', '0-30 Days','31-45 Days','46 - 60 Days','61 - 90 Days','91 - 180 Days','180 - 360 Days','Over 360 Days' ],
                     colModel:[
                               {name:'invoiceNo',index:'invoiceNo', width:80, align:"left",searchoptions:{sopt:['cn']}},
                               {name:'invoiceDate',index:'invoiceDate', width:80, align:"left",searchoptions:{sopt:['cn']},hidden:false},
                               {name:'balanceAmount',index:'balanceAmount', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                               {name:'balancetc',index:'balancetc', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},

                               /*{name:'below15Days',index:'below15Days', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false},*/
                               {name:'days30',index:'days30', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                               {name:'days45',index:'days45', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                               {name:'days45to60',index:'days45to60', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                               {name:'days60andabove',index:'days60andabove', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                               {name:'days90andabove',index:'days90andabove', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                               /*{name:'days100andabove',index:'days100andabove', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false},
                               {name:'days120andabove',index:'days120andabove', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false},*/
                               {name:'above180days',index:'above180days', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
 {name:'above360days',index:'above360days', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                                        
    ],
                     autowidth: true,
                     height: '100%',
                     pager: pager_id,
                     sortname: 'num',
                     sortorder: "asc",
                     // transaction level
                     subGrid: false,
                     }).jqGrid('setGridParam', { data : dtlDataList }).trigger("reloadGrid");
                 }
                
                }).error(function(dtlDataList) {
                });
             }
        }).jqGrid('setGridParam', { data : hdrData }).trigger("reloadGrid");
        $("#arAgewiseReportGridTcAmount").jqGrid('navGrid',"#arAgewiseReportGridPageTcAmount",{edit:false,search:false,refresh:false,add:false,del:false});
    }
    
    
    
    
    
    $scope.populateARReceivableAgewiseGridSecondary = function(hdrData){
        debugger;
        var data=[];
        $("#arAgewiseReportSecondaryGrid").jqGrid({
            data: hdrData,
            datatype: "local",
            multiboxonly: true,
            autowidth: true,
            height: '100%',
            rowList: [10,20,30],
            multiselect: false,
            loadonce: true,
            gridview:true,
            colNames : [ 'Customer Code', 'Customer Name','Balance Amount','0 - 30 Days', '30 - 45 Days', '45 - 60 Days','Above 60 days','Location' ],
            colModel:[
                {name:'customerCode',index:'customerCode', width:80, align:"left",searchoptions:{sopt:['cn']}},
                {name:'customerName',index:'customerName', width:200, align:"left",searchoptions:{sopt:['cn']},hidden:false},
                {name:'balanceAmount',index:'balanceAmount', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                {name:'days0to30',index:'days0to30', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                {name:'days30to45',index:'days30to45', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                {name:'days45to60',index:'days45to60', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                {name:'days60andabove',index:'days60andabove', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                {name:'location',index:'location', width:80, align:"left",searchoptions:{sopt:['cn']}},
                ],
            pager: "#arAgewiseReportSecondaryGridPage",
            viewrecords: true,
            ignoreCase: true,
            subGrid: true,
            subGridOptions: {
                "plusicon" : 'ui-icon-plus',
                "minusicon" : 'ui-icon-minus'
            },
           footerrow: true,
           loadComplete: function () {
               var balanceAmount=0,days0to30 = 0,days30to45=0,days45to60=0,days45to60=0,days60andabove=0;
              var rows= jQuery("#arAgewiseReportSecondaryGrid").jqGrid('getRowData');
              for(var i=0;i<rows.length;i++){
                 var row=rows[i];
                
                 balanceAmount += Number(row['balanceAmount']);
                 days0to30 += Number(row['days0to30']);
                 days30to45 += Number(row['days30to45']);
                 days45to60 += Number(row['days45to60']);
                 days60andabove += Number(row['days60andabove']);                 
             }
          
              $(this).jqGrid('footerData','set',{ customerName:'Total', balanceAmount:balanceAmount});
              $(this).jqGrid('footerData','set',{ customerName:'Total', days0to30:days0to30});
              $(this).jqGrid('footerData','set',{ customerName:'Total', days30to45:days30to45});
              $(this).jqGrid('footerData','set',{ customerName:'Total', days45to60:days45to60});
              $(this).jqGrid('footerData','set',{ customerName:'Total', days60andabove:days60andabove});
              
              
          },

          gridComplete: function() {
                 var $grid = $('#arAgewiseReportSecondaryGrid');
                 var balance = $grid.jqGrid('getCol', 'balanceAmount', false, 'sum');
                 var days0to30 = $grid.jqGrid('getCol', 'days0to30', false, 'sum');
                 var days30to45 = $grid.jqGrid('getCol', 'days30to45', false, 'sum');
                 var days45to60 = $grid.jqGrid('getCol', 'days45to60', false, 'sum');
                 var days60andabove = $grid.jqGrid('getCol', 'days60andabove', false, 'sum');
             
                 
                 $(this).jqGrid('footerData','set',{ groupHeadName:'Total',balanceAmount:balance,days0to30:days0to30,
                     days30to45:days30to45,days45to60:days45to60,days60andabove:days60andabove});
             },
            subGridRowExpanded: function(subgrid_id, row_id) {
                debugger;
                var subgrid_table_id, pager_id; subgrid_table_id = subgrid_id+"_t";
                pager_id = "p_"+subgrid_table_id;
                var rowData = jQuery('#arAgewiseReportSecondaryGrid').jqGrid ('getRowData', row_id);
                $scope.arAgewise.customerCode =rowData.customerCode;
                    
                $("#"+subgrid_id).html("<table id='"+subgrid_table_id+"' class='scroll'></table><div id='"+pager_id+"' class='scroll'></div>");
                $http.post($stateParams.tenantid+'/app/arAgewise/getArAgewiseDtl',$scope.arAgewise).success(function(data) {
                 if(data.success){
                     debugger;
                     var dtlDataList =data.lReceivableAgewiseDtlList;
                     $("#"+subgrid_table_id).jqGrid({
                     datatype: "local",
                     data: dtlDataList,
                     colNames : [ 'Invoice No', 'Invoice Date','Balance Amount','0 - 30 Days', '30 - 45 Days', '45 - 60 Days','61 - 90 Days','91 - 180 Days','180 - 360 Days','Over 360 Days'],
                     colModel:[
                               {name:'invoiceNo',index:'invoiceNo', width:80, align:"left",searchoptions:{sopt:['cn']}},
                               {name:'invoiceDate',index:'invoiceDate', width:80, align:"left",searchoptions:{sopt:['cn']},hidden:false},
                               {name:'balanceAmount',index:'balanceAmount', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                               {name:'days0to30',index:'days0to30', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                               {name:'days30to45',index:'days30to45', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                               {name:'days45to60',index:'days45to60', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                               {name:'days60andabove',index:'days60andabove', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                               {name:'days90andabove',index:'days90andabove', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                               /*{name:'days100andabove',index:'days100andabove', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false},
                               {name:'days120andabove',index:'days120andabove', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false},*/
                               {name:'above180days',index:'above180days', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
 {name:'above360days',index:'above360days', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
  
  ],
                     autowidth: true,
                     height: '100%',
                     pager: pager_id,
                     sortname: 'num',
                     sortorder: "asc",
                     // transaction level
                     subGrid: false,
                     }).jqGrid('setGridParam', { data : dtlDataList }).trigger("reloadGrid");
                 }
                
                }).error(function(dtlDataList) {
                });
             }
        }).jqGrid('setGridParam', { data : hdrData }).trigger("reloadGrid");
        
        
    }
    
    
    $scope.populateARReceivableAgewiseGridFormat3 = function(hdrData){
        debugger;
        var data=[];
        $("#arAgewiseReportFormat3Grid").jqGrid({
            data: hdrData,
            datatype: "local",
            multiboxonly: true,
            autowidth: true,
            height: '100%',
            rowList: [10,20,30],
            multiselect: false,
            loadonce: true,
            gridview:true,
            colNames : [ 'Customer Code', 'Customer Name','Acct Manager','Credit days','Credit Limit','Balance Amount','0 - 30 Days', '30 - 45 Days', '45 - 60 Days','Above 60 days','Location','Remarks' ],
            colModel:[
                {name:'customerCode',index:'customerCode', width:80, align:"left",searchoptions:{sopt:['cn']}},
                {name:'customerName',index:'customerName', width:200, align:"left",searchoptions:{sopt:['cn']},hidden:false},
                {name:'accountManager',index:'accountManager', width:60, align:"left",searchoptions:{sopt:['cn']},hidden:false},
                {name:'creditDays',index:'creditDays', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false},
                {name:'creditLimit',index:'creditLimit', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false},
                {name:'balanceAmount',index:'balanceAmount', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                {name:'days0to30',index:'days0to30', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                {name:'days30to45',index:'days30to45', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                {name:'days45to60',index:'days45to60', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                {name:'days60andabove',index:'days60andabove', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                {name:'location',index:'location', width:80, align:"left",searchoptions:{sopt:['cn']}},
                {name:'remarks',index:'remarks', width:80, align:"left",searchoptions:{sopt:['cn']}},
                ],
            pager: "#arAgewiseReportFormat3GridPage",
            viewrecords: true,
            ignoreCase: true,
            subGrid: true,
            subGridOptions: {
                "plusicon" : 'ui-icon-plus',
                "minusicon" : 'ui-icon-minus'
            },
           footerrow: true,
           loadComplete: function () {
               var balanceAmount=0,days0to30 = 0,days30to45=0,days45to60=0,days45to60=0,days60andabove=0;
              var rows= jQuery("#arAgewiseReportFormat3Grid").jqGrid('getRowData');
              for(var i=0;i<rows.length;i++){
                 var row=rows[i];
                
                 balanceAmount += Number(row['balanceAmount']);
                 days0to30 += Number(row['days0to30']);
                 days30to45 += Number(row['days30to45']);
                 days45to60 += Number(row['days45to60']);
                 days60andabove += Number(row['days60andabove']);                 
             }
          
              $(this).jqGrid('footerData','set',{ customerName:'Total', balanceAmount:balanceAmount});
              $(this).jqGrid('footerData','set',{ customerName:'Total', days0to30:days0to30});
              $(this).jqGrid('footerData','set',{ customerName:'Total', days30to45:days30to45});
              $(this).jqGrid('footerData','set',{ customerName:'Total', days45to60:days45to60});
              $(this).jqGrid('footerData','set',{ customerName:'Total', days60andabove:days60andabove});
              
              
          },

          gridComplete: function() {
                 var $grid = $('#arAgewiseReportFormat3Grid');
                 var balance = $grid.jqGrid('getCol', 'balanceAmount', false, 'sum');
                 var days0to30 = $grid.jqGrid('getCol', 'days0to30', false, 'sum');
                 var days30to45 = $grid.jqGrid('getCol', 'days30to45', false, 'sum');
                 var days45to60 = $grid.jqGrid('getCol', 'days45to60', false, 'sum');
                 var days60andabove = $grid.jqGrid('getCol', 'days60andabove', false, 'sum');
             
                 
                 $(this).jqGrid('footerData','set',{ groupHeadName:'Total',balanceAmount:balance,days0to30:days0to30,
                     days30to45:days30to45,days45to60:days45to60,days60andabove:days60andabove});
             },
            subGridRowExpanded: function(subgrid_id, row_id) {
                debugger;
                var subgrid_table_id, pager_id; subgrid_table_id = subgrid_id+"_t";
                pager_id = "p_"+subgrid_table_id;
                var rowData = jQuery('#arAgewiseReportFormat3Grid').jqGrid ('getRowData', row_id);
                $scope.arAgewise.customerCode =rowData.customerCode;
                    
                $("#"+subgrid_id).html("<table id='"+subgrid_table_id+"' class='scroll'></table><div id='"+pager_id+"' class='scroll'></div>");
                $http.post($stateParams.tenantid+'/app/arAgewise/getArAgewiseDtl',$scope.arAgewise).success(function(data) {
                 if(data.success){
                     debugger;
                     var dtlDataList =data.lReceivableAgewiseDtlList;
                     $("#"+subgrid_table_id).jqGrid({
                     datatype: "local",
                     data: dtlDataList,
                     colNames : [ 'Invoice No', 'Invoice Date','Balance Amount','0 - 30 Days', '30 - 45 Days', '45 - 60 Days','61 - 90 Days','91 - 180 Days','180 - 360 Days','Over 360 Days' ],
                     colModel:[
                               {name:'invoiceNo',index:'invoiceNo', width:80, align:"left",searchoptions:{sopt:['cn']}},
                               {name:'invoiceDate',index:'invoiceDate', width:80, align:"left",searchoptions:{sopt:['cn']},hidden:false},
                               {name:'balanceAmount',index:'balanceAmount', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                               {name:'days0to30',index:'days0to30', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                               {name:'days30to45',index:'days30to45', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                               {name:'days45to60',index:'days45to60', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                               {name:'days60andabove',index:'days60andabove', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                               {name:'days90andabove',index:'days90andabove', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                               /*{name:'days100andabove',index:'days100andabove', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false},
                               {name:'days120andabove',index:'days120andabove', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false},*/
                               {name:'above180days',index:'above180days', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
 {name:'above360days',index:'above360days', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                        
  ],
                     autowidth: true,
                     height: '100%',
                     pager: pager_id,
                     sortname: 'num',
                     sortorder: "asc",
                     // transaction level
                     subGrid: false,
                     }).jqGrid('setGridParam', { data : dtlDataList }).trigger("reloadGrid");
                 }
                
                }).error(function(dtlDataList) {
                });
             }
        }).jqGrid('setGridParam', { data : hdrData }).trigger("reloadGrid");
        
        
    }
});
app.controller('receivableAgewiseEntryCtrl', function($templateCache,shareArAgeWiseObject,$state, $scope, $rootScope, $http, logger, $log, ngDialog, $modal, $location, $sce, $filter,$stateParams) {
   // $scope.isallow =  true;
    var userId;
    
    // $scope.pageCounters = [ 14, 16, 17, 18, 150, 500, 1000 ];
    
    $scope.itemsByPage = 150;
    $scope.fulllist = [];
    $scope.pageCounters = [ 10, 25, 50, 100, 500, 1000 ];
    $scope.itemsByPage = 10;
    $scope.rowCollection = [];
    $scope.displayedCollection1 = [];
    console.log(shareArAgeWiseObject.getObj());
    $scope.arAgewise=shareArAgeWiseObject.getObj();
    console.log("$scope.arAgewise")
     console.log($scope.arAgewise)
    var companyCode;
    var fromDate;
    console.log($scope.arAgewise.companyCode)
    companyCode = $scope.arAgewise.companyCode;
    fromDate = $scope.arAgewise.fromDate;
    
/*    $scope.validateMonthwise = function(userId){
  
        var proDay = moment().format('DD')
      //  var proDay = 16
         debugger;
        if( Number(proDay) > 15 && userId == 'E322')
           {
           $scope.isallow = true;
           }
       else if ( Number(proDay) > 15 && userId != 'E322')
           
           {
           $scope.isallow = false;
           }
       
       

        
    }*/
    $scope.viewARReceivableAgewise=function(){
        $scope.isPrimary=true;
        $scope.isSecondary =false;
        $scope.isFormat3 =false;
        console.log("companyCode")
        if($scope.arAgewise.fromDate != '' ){
            $http.post($stateParams.tenantid+'/app/arAgewise/getArAgewiseHdrForEntry', $scope.arAgewise).success(function(data) {
                if(data.success){
                    console.log("data.lReceivableAgewiseHdrList");
                    console.log(data.lReceivableAgewiseHdrList);
                    $scope.rowCollection =data.lReceivableAgewiseHdrList;
                    $scope.fulllist =data.lReceivableAgewiseHdrList;
                    console.log("data")
                     userId = data.userId;
                    console.log(data.userId)
                }else{
                    logger.logError("No data found");
                }
                
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        }else{
                logger.logError("Please select valid date");
        }
        
      //  $scope.validateMonthwise(userId);

        
    }
    $scope.viewARReceivableAgewise();
    $scope.keylist = []
    $scope.saveReceivableForeCasting=function(){
   
  /*     angular.forEach( $scope.fulllist , function(value, key) {
          
           var company = value.company;
           var amt = value.foreCastingAmt;
           var payercode = value.customerCode;   
           var  Combo = company + '~'+amt+ '~'+  payercode;      
            console.log(Combo);
            $scope.keylist.push(Combo);
       });*/
       /*console.log("Combo ++ key");
       console.log( $scope.keylist);*/
        var obj={
               'lReceivableAgewiseHdrList': $scope.fulllist,
                                  'fromDate' :fromDate
              /* 'keylist'  :$scope.keylist*/
        };
        console.log("list")
        console.log(obj)
     $http.post($stateParams.tenantid+'/app/arAgewise/saveReceivableForeCasting', obj).success(function(result) {
            console.log(obj)
            debugger;
            if (result.success) {
                $scope.viewARReceivableAgewise();
                logger.logSuccess("Save successfully");
                //$state.go("app.reports.finance.receivableAgewise");
            } else {
                logger.logError("Unable to save. Please try again");
            }}).error(function(data) {
                console.log(data)
                logger.logError("Error Please Try Again");
            });
    }
    $scope.cancel = function(){
        $state.go("app.reports.finance.receivableAgewise",{tenantid:$stateParams.tenantid});
    };
    
    $scope.fileUpload = function() {
        ngDialog.close();
        ngDialog.open({
            template : 'fileModal',
            scope : $scope
        });
    };

    $rootScope.uploadFile = function(element) {

        console.log("excel file");
        $scope.excelfile = element.files[0];
        console.log($scope.excelfile);
    }

    $rootScope.closeFileDialog = function() {
        ngDialog.close();
    };
    

    $rootScope.upload = function() {
        
        console.log("upload file");
        if($scope.excelfile != undefined && $scope.excelfile.size > 0){
            ngDialog.close();
        var excelfile = $scope.excelfile;
        var fileExtension = excelfile.name;
        var fName = [];
        fName = fileExtension.split(".");
        for (var i = 0; i < fName.length; i++) {
            if (fName[i] == "xls" || fName[i] == "xlsx") {
                var frmData = new FormData();
                frmData.append("file", excelfile);
                frmData.append("companyCode", companyCode);
                frmData.append("fromDate", fromDate);
                
                                $.ajax({
                    type : "POST",
                    url : $stateParams.tenantid+"/app/arAgewise/uploadfile",
                    data : frmData,
                    contentType : false,
                    processData : false,
                    success : function(result) {
                        console.log("result")
                        console.log(result)
                        if (result.success) {
                            $scope.viewARReceivableAgewise();
                            logger.logSuccess("File Uploaded Successfully");
                        } else {
                            logger.logError(result.message);
                        }

                    }

                });
            }

        }
      }else{
          logger.logError('Please choose a file !')
      }
    }
         
    
    $scope.exportfile =   function() {     
 
        console.log("displayedCollection")
        console.log($scope.rowCollection)
                        var objWholeData = {
                'lReceivableAgewiseHdrList': $scope.rowCollection
                               };  

                             $http.post($stateParams.tenantid+"/app/arAgewise/generateExcel",objWholeData).success(function(response) {
                            $('#exportXl').append('<a id="tbExcelExport" stype="display:none" href="filePath/ReceivableAgewise.xls" download="ReceivableAgewise.xls"></a>');
                                     $("#tbExcelExport").bind('click', function() {
                                     });
                                     $('#tbExcelExport').simulateClick('click');
                     
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

                             
       
    };
    
})
