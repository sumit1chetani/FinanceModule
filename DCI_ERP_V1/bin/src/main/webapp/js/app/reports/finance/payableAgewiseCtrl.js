'use strict';
app.controller('payableAgewiseCtrl', function($templateCache, $scope, $rootScope, $http, logger, $log, 
        ngDialog, $modal, $location, $sce, $filter,$timeout,$stateParams) {
    
    $('#ap_fromDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime: false
    });
    
    $('#ap_toDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime: false
    });
    
    $scope.apAgewise = {
            fromDate:'',
            toDate : '',
            supplierCode:'',
            companyCode:'',
            mode:'',
            objCompanyCodes:[],
            srvcPrtnrBin:'',
            type:'',
            
    };
    
    $scope.typeList=[{
        id : '20010002',
        text : 'Sundry Creditors - Local'
    }, {
        id : '20010003',
        text : 'Sundry Creditors - Overseas'
    }];
    
    $scope.modeList=[{
        id : '1',
        text : 'Sea'
    }, {
        id : '2',
        text : 'Air'
    }, {
        id : '3',
        text : 'All'
    }];
    $scope.reset = function() {
        $scope.apAgewise = {};
        $("#apAgewiseReportGrid").jqGrid('clearGridData'); 
    };
    
    $scope.getDropDownList = function() {
        $http.get($stateParams.tenantid+'/app/usermaster/getCompanyList?formCode='+$('#form_code_id').val()).success(function(data) {  
/*        $http.get('app/trialBalance/getCompanyList').success(function(data) {*/
            $scope.companyList = data;
            var data = {};
    		data["id"] = "ALL";
    		data["text"] = "ALL";
    		$scope.companyList.push(data);
            
            console.log("company")
            console.log($scope.companyList)
            var foundItemDest = $filter('filter')($scope.companyList, { baseCompany:  1 })[0];
          $scope.apAgewise.companyCode=foundItemDest.id;
            
            /*  $timeout(function() { // You might need this timeout to be sure its run after DOM render.          
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
                      if($scope.apAgewise.objCompanyCodes.length>0){
                          angular.forEach($scope.apAgewise.objCompanyCodes, function (item, key) {
                              debugger;
                              if($scope.apAgewise.objCompanyCodes.length>0){
                                  debugger;
                                  if($scope.apAgewise.objCompanyCodes[key]!=undefined){
                                      var companyCode = item.id;
                                      if(companyCodes==""){
                                          companyCodes = item.id;
                                      }else{
                                          companyCodes +=","+ item.id;
                                      }       
                                      $scope.apAgewise.companyCode = companyCodes;
                                  }                             
                              }                              
                          });
                      }else{
                          $scope.apAgewise.companyCode = '';
                      }
                      
                    }
                  });
                
                $("#multiselect-button").addClass("width_100 input-sm line-height-5");
                
                }, 2, false);*/
        }).error(function(data) {
        });
        
        
    };
    $scope.getDropDownList();
    /**
     * view Report
     */
    
    $scope.customerList=[];
    $http.post($stateParams.tenantid+'/app/apAgewise/getSupplierList').success(function(data) {
        if(data.success){
        	$scope.customerList = data.selectivitybean;
        }else{
            logger.logError("No data found");
        }
        
    }).error(function(data) {
        
    });
    $scope.isPrimary=false; 
    $scope.viewAPPayableAgewise=function(){
        debugger;
        $scope.isPrimary=true; 

        $scope.apAgewise.fromDate = $('#fromDate').val();
        $scope.apAgewise.toDate = $('#toDate').val();
        	
        	if($scope.apAgewise.toDate != '' && $scope.apAgewise.companyCode !='' ){
                debugger;
                $http.post($stateParams.tenantid+'/app/apAgewise/getApAgewiseHdr', $scope.apAgewise).success(function(data) {
                   
                	if($scope.apAgewise.type == '20010003'){
	            		$scope.dummy= true;
	            		if(data.success){
	                    	if($scope.apAgewise.srvcPrtnrBin !='' && $scope.apAgewise.srvcPrtnrBin != undefined && 
	                    			$scope.apAgewise.srvcPrtnrBin.length >0){
	                    		$scope.newList=[];
	                    		angular.forEach(data.lPayableAgewiseHdrList, function(value, key) {
	                        		if(value.supplierCode==$scope.apAgewise.srvcPrtnrBin){
	                        			$scope.newList.push(value);
	                        		}else{
	                        			$scope.newList.push(value);
	                        		}
	                        		
	                        	})
	                    	}else{
	                    		$scope.newList=[];
	                    		$scope.newList=data.lPayableAgewiseHdrList;
	                    	}
	                    	
	                   // 	  $("#apAgewiseReportGrid").jqGrid('clearGridData'); 
  	                        $("#apAgewiseReportSecondaryGrid").jqGrid('clearGridData');
	                        $("#apAgewiseReportGridTCAmount").jqGrid('clearGridData'); 
	                        $scope.populateAPPayableAgewiseGridTCAmount($scope.newList);
	                    }else{
	                        logger.logError("No data found");
	                    }
	            	}else{
	            		$scope.dummy= false;
	            		if(data.success){
	                    	if($scope.apAgewise.srvcPrtnrBin !='' && $scope.apAgewise.srvcPrtnrBin != undefined && 
	                    			$scope.apAgewise.srvcPrtnrBin.length >0){
	                    		$scope.newList=[];
	                    		angular.forEach(data.lPayableAgewiseHdrList, function(value, key) {
	                        		if(value.supplierCode==$scope.apAgewise.srvcPrtnrBin){
	                        			$scope.newList.push(value);
	                        		}else{
	                        			$scope.newList.push(value);
	                        		}
	                        		
	                        	})
	                    	}else{
	                    		$scope.newList=[];
	                    		$scope.newList=data.lPayableAgewiseHdrList;
	                    	}
	                    	
	                    	
	                        $("#apAgewiseReportGrid").jqGrid('clearGridData'); 
	                        $scope.populateAPPayableAgewiseGrid($scope.newList);
	                    }else{
	                        logger.logError("No data found");
	                    }
	            	}
	                
//                	
//                	if(data.success){
//                    	if($scope.apAgewise.srvcPrtnrBin !='' && $scope.apAgewise.srvcPrtnrBin != undefined && 
//                    			$scope.apAgewise.srvcPrtnrBin.length >0){
//                    		$scope.newList=[];
//                    		angular.forEach(data.lPayableAgewiseHdrList, function(value, key) {
//                        		if(value.supplierCode==$scope.apAgewise.srvcPrtnrBin){
//                        			$scope.newList.push(value);
//                        		}else{
//                        			$scope.newList.push(value);
//                        		}
//                        		
//                        	})
//                    	}else{
//                    		$scope.newList=[];
//                    		$scope.newList=data.lPayableAgewiseHdrList;
//                    	}
//                    	
//                    	
//                        $("#apAgewiseReportGrid").jqGrid('clearGridData'); 
//                        $scope.populateAPPayableAgewiseGrid($scope.newList);
//                    }else
//                        logger.logError("No data found");
//                    }
                    
                }).error(function(data) {
                    logger.logError("Error Please Try Again");
                });
            }else{
                    if($scope.apAgewise.toDate =='' && $scope.apAgewise.companyCode =='')                    
                        logger.logError("Please select Company and valid to date");
                    else if($scope.apAgewise.companyCode =='')
                        logger.logError("Please select Company");
                    else if($scope.apAgewise.toDate == '')
                        logger.logError("Please select valid to date");
            }
        
    }
    
    $scope.populateAPPayableAgewiseGrid = function(hdrData){
    var data=[];
    $("#apAgewiseReportGrid").jqGrid({
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
        colNames : [ 'Supplier Code', 'Supplier Name','Balance Amount','0-30 Days','31-45 Days','46 - 60 Days','61 - 90 Days','91 - 180 Days','180 - 360 Days','Over 360 Days'  ],
        colModel:[
            {name:'supplierCode',index:'supplierCode', width:80, align:"left",searchoptions:{sopt:['cn']}},
            {name:'supplierName',index:'supplierName', width:200, align:"left",searchoptions:{sopt:['cn']},hidden:false},
            {name:'balanceAmount',index:'balanceAmount', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
//            {name:'below15Days',index:'below15Days', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
            {name:'days30',index:'days30', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
            {name:'days45',index:'days45', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
            {name:'days45to60',index:'days45to60', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
            {name:'days60andabove',index:'days60andabove', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
            {name:'days90andabove',index:'days90andabove', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
            {name:'above180days',index:'above180days', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
{name:'above360days',index:'above360days', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
//            {name:'totalpaid',index:'totalpaid', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}}
//            {name:'balanceAmount',index:'balanceAmount', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}}
            ],  /*totalinvoiced*/
        pager: "#apAgewiseReportGridPage",
        viewrecords: true,
        ignoreCase: true,
        subGrid: true,
        subGridOptions: {
            "plusicon" : 'ui-icon-plus',
            "minusicon" : 'ui-icon-minus'
        },
        //footerrow: true,
        footerrow: true,
        loadComplete: function () {
            var balanceAmount=0,below15Days = 0,days30=0,days45=0,days45to60=0,days60andabove=0,
            days90andabove=0, days100andabove=0,days120andabove=0,above180days=0,above360days=0;
           var rows= jQuery("#apAgewiseReportGrid").jqGrid('getRowData');
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
 $(this).jqGrid('footerData','set',{ customerName:'Total', above180days:above360days.toFixed(2)});
           
       },

       gridComplete: function() {
              var $grid = $('#apAgewiseReportGrid');
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
            var subgrid_table_id, pager_id; subgrid_table_id = subgrid_id+"_t";
            pager_id = "p_"+subgrid_table_id;
            var rowData = jQuery('#apAgewiseReportGrid').jqGrid ('getRowData', row_id);            
            $scope.apAgewise.supplierCode =rowData.supplierCode;
                
            $("#"+subgrid_id).html("<table id='"+subgrid_table_id+"' class='scroll'></table><div id='"+pager_id+"' class='scroll'></div>");
            $http.post($stateParams.tenantid+'/app/apAgewise/getApAgewiseDtl',$scope.apAgewise).success(function(data) {
             if(data.success){
                 var dtlDataList =data.lPayableAgewiseDtlList;
                 $("#"+subgrid_table_id).jqGrid({
                 datatype: "local",
                 data: dtlDataList,
//                 colNames : [ 'Invoice No', 'Invoice Date','Balance Amount', '0-30 Days','31-45 Days','46 - 60 Days','61 - 90 Days','91 - 180 Days','Over 180 Days' ],

                 colNames : [ 'Invoice No', 'Invoice Date','Balance Amount','0-30 Days','31-45 Days','46 - 60 Days','61 - 90 Days','91 - 180 Days','180 - 360 Days','Over 360 Days' ],
                 colModel:[
                           {name:'invoiceNo',index:'invoiceNo', width:80, align:"left",searchoptions:{sopt:['cn']}},
                           {name:'invoiceDate',index:'invoiceDate', width:80, align:"left",searchoptions:{sopt:['cn']},hidden:false},
                           {name:'balanceAmount',index:'balanceAmount', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                           {name:'days30',index:'days30', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                           {name:'days45',index:'days45', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                           {name:'days45to60',index:'days45to60', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                           {name:'days60andabove',index:'days60andabove', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                           {name:'days90andabove',index:'days90andabove', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
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
    
    
    
    
    
    $scope.populateAPPayableAgewiseGridTCAmount = function(hdrData){
        var data=[];
        $("#apAgewiseReportGridTCAmount").jqGrid({
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

            colNames : [ 'Supplier Code', 'Supplier Name', 'Balance Amount','TC Balance','0-30 Days','31-45 Days','46 - 60 Days','61 - 90 Days','91 - 180 Days','Over 180 Days' ],
            colModel:[
            	
                {name:'supplierCode',index:'supplierCode', width:80, align:"left",searchoptions:{sopt:['cn']}},
                {name:'supplierName',index:'supplierName', width:200, align:"left",searchoptions:{sopt:['cn']},hidden:false},
                {name:'balanceAmount',index:'balanceAmount', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                {name:'balancetc',index:'balancetc', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
//                {name:'below15Days',index:'below15Days', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                {name:'days30',index:'days30', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                {name:'days45',index:'days45', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                {name:'days45to60',index:'days45to60', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                {name:'days60andabove',index:'days60andabove', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                {name:'days90andabove',index:'days90andabove', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                {name:'above180days',index:'above180days', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
 {name:'above360days',index:'above360days', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
//                {name:'invoiceAmount',index:'invoiceAmount', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
//                {name:'totalpaid',index:'totalpaid', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
//               
                ],  /*totalinvoiced*/
            pager: "#apAgewiseReportGridPageTCAmount",
            viewrecords: true,
            ignoreCase: true,
            subGrid: true,
            subGridOptions: {
                "plusicon" : 'ui-icon-plus',
                "minusicon" : 'ui-icon-minus'
            },
            //footerrow: true,
           

            footerrow: true,
            loadComplete: function () {
                var balanceAmount=0,balancetc = 0,below15Days = 0,days30=0,days45=0,days45to60=0,days60andabove=0,
                days90andabove=0, days100andabove=0,days120andabove=0,above180days=0,above360days=0;
               var rows= jQuery("#apAgewiseReportGridTCAmount").jqGrid('getRowData');
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
           
               $(this).jqGrid('footerData','set',{ supplierName:'Total', balanceAmount:balanceAmount.toFixed(2)});
               $(this).jqGrid('footerData','set',{ supplierName:'Total', balancetc:balancetc.toFixed(2)});
               /*$(this).jqGrid('footerData','set',{ customerName:'Total', below15Days:below15Days.toFixed(2)});*/
               $(this).jqGrid('footerData','set',{ supplierName:'Total', days30:days30.toFixed(2)});
               $(this).jqGrid('footerData','set',{ supplierName:'Total', days45:days45.toFixed(2)});
               $(this).jqGrid('footerData','set',{ supplierName:'Total', days45to60:days45to60.toFixed(2)});
               $(this).jqGrid('footerData','set',{ supplierName:'Total', days60andabove:days60andabove.toFixed(2)});
               
               $(this).jqGrid('footerData','set',{ supplierName:'Total', days90andabove:days90andabove.toFixed(2)});
        /*       $(this).jqGrid('footerData','set',{ customerName:'Total', days100andabove:days100andabove.toFixed(2)});
               $(this).jqGrid('footerData','set',{ customerName:'Total', days120andabove:days120andabove.toFixed(2)});*/
               $(this).jqGrid('footerData','set',{ supplierName:'Total', above180days:above180days.toFixed(2)});
$(this).jqGrid('footerData','set',{ supplierName:'Total', above360days:above360days.toFixed(2)});
               
           },

           gridComplete: function() {
                  var $grid = $('#apAgewiseReportGridTCAmount');
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
                var subgrid_table_id, pager_id; subgrid_table_id = subgrid_id+"_t";
                pager_id = "p_"+subgrid_table_id;
                var rowData = jQuery('#apAgewiseReportGridTCAmount').jqGrid ('getRowData', row_id);            
                $scope.apAgewise.supplierCode =rowData.supplierCode;
                    
                $("#"+subgrid_id).html("<table id='"+subgrid_table_id+"' class='scroll'></table><div id='"+pager_id+"' class='scroll'></div>");
                $http.post($stateParams.tenantid+'/app/apAgewise/getApAgewiseDtl',$scope.apAgewise).success(function(data) {
                 if(data.success){
                     var dtlDataList =data.lPayableAgewiseDtlList;
                     $("#"+subgrid_table_id).jqGrid({
                     datatype: "local",
                     data: dtlDataList,

                     colNames : [ 'Invoice No', 'Invoice Date','Balance Amount','TC Balance','0-30 Days','31-45 Days','46 - 60 Days','61 - 90 Days','91 - 180 Days','Over 180 Days'],
                     colModel:[
                               {name:'invoiceNo',index:'invoiceNo', width:80, align:"left",searchoptions:{sopt:['cn']}},
                               {name:'invoiceDate',index:'invoiceDate', width:80, align:"left",searchoptions:{sopt:['cn']},hidden:false},
                               {name:'balanceAmount',index:'balanceAmount', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},                               
							   
                               {name:'balancetc',index:'balancetc', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                               {name:'days30',index:'days30', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                               {name:'days45',index:'days45', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                               {name:'days45to60',index:'days45to60', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                               {name:'days60andabove',index:'days60andabove', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                               {name:'days90andabove',index:'days90andabove', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                              /* {name:'days180',index:'days180', width:60,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},*/
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
        $("#apAgewiseReportGridTCAmount").jqGrid('navGrid',"#apAgewiseReportGridPageTCAmount",{edit:false,search:false,refresh:false,add:false,del:false});
        
    }
    
    
    
    
    
    $scope.exportAPPayableAgewise=function(){
        $scope.apAgewise.fromDate = $('#fromDate').val();
        $scope.apAgewise.toDate = $('#toDate').val();
        if($scope.apAgewise.toDate != '' ){
        	
            $http.post($stateParams.tenantid+'/app/apAgewise/exportAPAgewiseExcel', $scope.apAgewise).success(function(data) {
                if(data.success){
                    $("#APPayableExport").bind('click', function() {
                    });
                    $('#APPayableExport').simulateClick('click');
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
});