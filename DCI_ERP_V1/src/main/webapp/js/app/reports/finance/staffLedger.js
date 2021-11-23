'use strict';
app.controller('staffLedgerController', function($templateCache, $scope, $rootScope, $http, logger, $log, ngDialog, $modal, $location, $sce, $filter, $state,$stateParams) {

    $('#gl_fromDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime: false
    });
    
    $('#gl_toDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime: false
    });

    $scope.staffLedger = {
            companyCode:'',
            fromDate:'',
            toDate:'',
            employeeCode:'',
            fromCode:'',
            toCode:'',
            isActive:'',
            status:''
    };

    $scope.formreset = function() {
        $scope.staffLedger = {};
    };

    
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.subGroupList = [];
    $scope.companyList = [];
    
    $scope.staffLedger.isActive = 'Y';
    $scope.subAccountCodeList=[];
    $scope.getDropDownList = function() {
/*        $http.get('app/trialBalance/getCompanyList').success(function(data) {
            $scope.companyList = data;
        }).error(function(data) {
        });
        */
        $http.get($stateParams.tenantid+'/app/usermaster/getCompanyList?formCode='+$('#form_code_id').val()).success(function(datas) {
            debugger;           
            $scope.companyList = datas;   
            console.log("company")
            console.log($scope.companyList)
            var foundItemDest = $filter('filter')($scope.companyList, { baseCompany:  1 })[0];
            $scope.staffLedger.companyCode=foundItemDest.id;
            var company=$scope.staffLedger.companyCode
         
            $http.post($stateParams.tenantid+'/app/staffLedger/getActiveEmployeeList', company).success(function(datas) {
                console.log(datas)
                $scope.subAccountCodeList = datas;
                }).error(function(datas) {
            }); 
            }).error(function(datas) {
            	
        });
        
        $scope.subAccountCodeList=[];
      
      /*  $scope.employee=function(){
        	

            $http.post($stateParams.tenantid+'/app/staffLedger/getActiveEmployeeList',  $scope.staffLedger.companyCode).success(function(datas) {
                console.log(datas)
                $scope.subAccountCodeList = datas;
                }).error(function(datas) {
            }); 
        }*/
      
        
    /*    $scope.onChangecompany = function(company) {
       	var c= $location.search().companyCode;
    	    
    	  
        var	company=$scope.staffLedger.companyCode
          //  alert(company);
        $http.post($stateParams.tenantid+'/app/staffLedger/getActiveEmployeeList', company).success(function(datas) {
            console.log(datas)
            $scope.subAccountCodeList = datas;
            }).error(function(datas) {
        });  
    };*/
};  
    
    $scope.getDropDownList();
    
    
    $scope.viewSubLedgerReport = function(){
        debugger;
        $scope.staffLedger.fromDate = $('#fromDate').val();
        $scope.staffLedger.toDate = $('#toDate').val();
        console.log($scope.staffLedger);
        if($scope.staffLedger.fromDate!="" && $scope.staffLedger.toDate!=""){
            $http.post($stateParams.tenantid+'/app/staffLedger/getstaffLedgerReport', $scope.staffLedger).success(function(data) {
                if(data.success){
                    debugger;
                    console.log(data.lStaffLedger);
                    $("#staffLedgerGrid").jqGrid('clearGridData'); 
                    $scope.populateStaffLedgerGrid(data.lStaffLedger);
                }else{
                    
                }
                
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        }else{
            logger.logError("Please Select Date Range");
        }
       
    };
    
    $scope.printStaffLedger = function(){
        $scope.staffLedger.fromDate = $('#fromDate').val();
        $scope.staffLedger.toDate = $('#toDate').val();
        if($scope.staffLedger.fromDate!="" && $scope.staffLedger.toDate!=""){
            $http.post($stateParams.tenantid+'/app/staffLedger/printstaffLedgerReport', $scope.staffLedger).success(function(data) {
                var mywindow = window.open('', 'InterAfrica', 'height=400,width=750,top=100,left=100,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
                mywindow.document.write(data);
                mywindow.document.close(); // necessary for IE >= 10
                mywindow.focus(); // necessary for IE >= 10
                mywindow.print();
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        }else{
            logger.logError("Please Select Date Range");
        }
        
    }
    
    $scope.exportSubLedgerExcel = function(){
        debugger;
        $scope.staffLedger.fromDate = $('#fromDate').val();
        $scope.staffLedger.toDate = $('#toDate').val();
        //console.log($scope.staffLedger);
        if($scope.staffLedger.fromDate!="" && $scope.staffLedger.toDate!=""){
            $http.post($stateParams.tenantid+'/app/staffLedger/exportStaffLedgerExcel', $scope.staffLedger).success(function(data) {
                if(data){
                    debugger;
                    $("#SLExport").bind('click', function() {
                    });
                    $('#SLExport').simulateClick('click');
                    logger.logSuccess("Exported successfully!");
                }else{
                    logger.logSuccess("Failed to export");
                }
                
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        }else{
            logger.logError("Please Select Date Range");
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
    
    $scope.populateStaffLedgerGrid = function(ListData){
        debugger;
        console.log("ListData::::::::::::::::STAFF_LEDGER:::::::::::::");
        console.log(ListData);
        var data=[];
        $("#staffLedgerGrid").jqGrid({
            data: ListData,
            datatype: "local",
            multiboxonly: false,
            autowidth: true,
            height: '100%',
            rowList: [10,20,30],
            multiselect: false,
            loadonce: true,
            gridview:true,
            colNames : [ 'Employee Code', 'Employee Name','BC Debit','BC Credit','Balance'],
            colModel:[
                {name:'employeeCode',index:'employeeCode', width:80, align:"left",searchoptions:{sopt:['cn']}},
                {name:'employeeName',index:'employeeName', width:80, align:"left",searchoptions:{sopt:['cn']},hidden:false},
                {name:'totalBCDebit',index:'totalBCDebit', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false},
                {name:'totalBCCredit',index:'totalBCCredit', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false},
                {name:'closingBalanceBC',index:'closingBalanceBC', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false},
                ],
            pager: "#staffLedgerPage",
            viewrecords: true,
            ignoreCase: true,
            subGrid: true,
            subGridOptions: {
                "plusicon" : 'ui-icon-plus',
                "minusicon" : 'ui-icon-minus'
            },
            loadComplete: function () {
                var $grid = $('#staffLedgerGrid');
                var credit = $grid.jqGrid('getCol', 'totalBCCredit', false, 'sum');
                var debit = $grid.jqGrid('getCol', 'totalBCDebit', false, 'sum');
                var difference = debit - credit;
            },
          
            subGridRowExpanded: function(subgrid_id, row_id) {
                debugger;
                var subgrid_table_id, pager_id; subgrid_table_id = subgrid_id+"_t";
                pager_id = "p_"+subgrid_table_id;
                var rowData = jQuery('#staffLedgerGrid').jqGrid ('getRowData', row_id);
                $scope.staffLedger.filterEmployeeCode =rowData.employeeCode;
                $("#"+subgrid_id).html("<table id='"+subgrid_table_id+"' class='scroll'></table><div id='"+pager_id+"' class='scroll'></div>");
                $http.post($stateParams.tenantid+'/app/staffLedger/getstaffLedgerDtlReport',$scope.staffLedger).success(function(data) {
                 if(data.success){
                     debugger;
                     var dtllist =data.lStaffLedger;
                     console.log(dtllist);
                     $("#"+subgrid_table_id).jqGrid({
                     datatype: "local",
                     data: dtllist,
                     colNames:['Transaction Dt','Transaction No.','Narration','Currency','Exchange Rate','BC Debit','BC Credit','TC Debit','TC Credit'],
                     colModel:[
                            {name:'transactionDate',index:'transactionDate', width:200, align:"left",searchoptions:{sopt:['cn']},hidden:false},
                            {name:'transactionNo',index:'transactionNo', width:200, align:"left",searchoptions:{sopt:['cn']}},
                            {name:'narration',index:'narration', width:200, align:"left",searchoptions:{sopt:['cn']},hidden:false},
                            {name:'currency',index:'currency', width:200,align:"left", searchoptions:{sopt:['cn']},hidden:false},
                            {name:'exchangeRate',index:'exchangeRate', width:200, align:"right",searchoptions:{sopt:['cn']},hidden:false},
                            {name:'bcDebit',index:'bcDebit', width:200,align:"right", searchoptions:{sopt:['cn']},hidden:false},
                            {name:'bcCredit',index:'bcCredit', width:200,align:"right", searchoptions:{sopt:['cn']},hidden:false},
                            {name:'tcDebit',index:'tcDebit', width:200,align:"right", searchoptions:{sopt:['cn']},hidden:false},
                            {name:'tcCredit',index:'tcCredit', width:200,align:"right", searchoptions:{sopt:['cn']},hidden:false}
                        ],
                     autowidth: true,
                     height: '100%',
                     pager: pager_id,
                     sortname: 'num',
                     sortorder: "asc"
                    
                     }).jqGrid('setGridParam', { data : dtllist }).trigger("reloadGrid");
                 }
                
                }).error(function(dtllist) {
                });
             }
        }).jqGrid('setGridParam', { data : ListData }).trigger("reloadGrid");
        
    }
    
    $scope.employeeStatus=function(){
        //console.log($scope.staffLedger);
        //$location.path('/reports/finance/staffLedgerEmpStatus')
        $state.go('app.reports.finance.staffLedgerEmpStatus',{company:$scope.staffLedger.companyCode, employee:$scope.staffLedger.employeeCode, status:$scope.staffLedger.isActive});
    }
    
    
});


app.controller('staffLedgerEmpStatusController', function($templateCache, $scope, $rootScope, $http, logger, $log, ngDialog, $modal, $location, $sce, $filter, utilsService, $window, $state, $stateParams) {
																
    $scope.offsetCount = 0;
    $scope.limitCount = 100;
    $scope.rowCollection = [];
    $scope.itemsByPage = 10;
    //console.log($stateParams);
    
    $scope.staffLedger = {
            employeeName:'',
            employeeCode:'',
            companyName:'',
            companyCode:'',
            department:'',
            position:'',
            status:''
    };
    
    $scope.staff = {
            employeeName:'',
            companyName:'',
            status:''
    };
    
    $scope.staff.companyName = $stateParams.company;
    $scope.staff.employeeName = $stateParams.employee;
    $scope.staff.status = $stateParams.status;
    
    $scope.getEmpList = function() {
        console.log($scope.staff);
                $http.post($stateParams.tenantid+'/app/staffLedger/getstaffLedgerEmpList',$scope.staff).success(function(datas) {
                    debugger;           
                    $scope.rowCollection = [];
                    if (datas.success == true && !utilsService.isUndefinedOrNull(datas.lStaffLedger)) {
                        $scope.rowCollection = $scope.rowCollection.concat(datas.lStaffLedger);
                        console.log($scope.rowCollection);
                    }
                    $scope.showEmptyLabel = $scope.rowCollection.length == 0 ? true : false;
                    }).error(function(datas) {
                });
                $scope.offsetCount = $scope.limitCount + $scope.offsetCount;
            };            
   $scope.getEmpList();
   
   $scope.cancelfrm = function(){
	   $state.go('app.finance.staffLedger.staffLedgerReport',{tenantid:$stateParams.tenantid});
//	  	  $state.go('app.finance.reports.financial.staffLedger',{tenantid:$stateParams.tenantid});

   }
   
   $scope.checkBoxVal = function(index,status) {
               angular.forEach($scope.rowCollectionAdvice, function(index,status) {
                   if(status == 'Y' ){
                       $scope.rowCollectionAdvice[index].status = 'Y';
                   }
                   else{
                       $scope.rowCollectionAdvice[index].status = 'N';
                   }
               });
   };
   
   $scope.btnaction = function(stus,empCode){
       
       if(stus!=null && empCode!=null){
           if(stus=='Y'){ stus = 'N';}
           else if(stus=='N'){stus = 'Y';}
           var dataUrl = $stateParams.tenantid+'/app/staffLedger/editstaffLedgerEmpList/'+stus+'/'+empCode;
           console.log(dataUrl);
           $http.get(dataUrl).success(function(datas) {
                   $scope.getEmpList();
               }).error(function(datas) {
           });
       }       
   }
   
   $scope.savefrm = function(){
       console.log("SAVE STAFF");
       console.log($scope.staffLedger);
   }
});
