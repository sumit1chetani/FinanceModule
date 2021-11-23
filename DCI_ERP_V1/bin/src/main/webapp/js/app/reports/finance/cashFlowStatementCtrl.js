app.filter('totaldata', function () {
    return function (data, key1, key2, key3, key4, key5, key6) {
        if (typeof (data) === 'undefined') {
            return 0;
        }

        var amount = 0;
      
       for (var i = data.length - 1; i >= 0; i--) {            
            if(data[i].accountHeadCode==key1 || data[i].accountHeadCode==key2 ||data[i].accountHeadCode==key3 ||data[i].accountHeadCode==key4 ||
                    data[i].accountHeadCode==key5 ||data[i].accountHeadCode==key6){
                amount=amount+data[i].amount
            }
         
        }

        return amount;
    };
});
app.filter('finddata', function () {
    return function (data, key,sumofdata) {
        if (typeof (data) === 'undefined' || typeof (key) === 'undefined') {
            return 0;
        }

        var amount = 0;
        for (var i = data.length - 1; i >= 0; i--) {            
            if(data[i].accountHeadCode==key){
                amount=data[i].amount;
                sumofdata=sumofdata+data[i].amount;
            }
         
        }

        return amount;
    };
});
'use strict';
    app.controller('cashflowStatementController', function($scope, $timeout, $rootScope,$http, logger, $log, ngDialog, $modal, $window,$location,$filter,$stateParams) {
        $scope.cashflow={
                fromDate:'',
                toDate:'',
                company:'',
                rowid:''
             }
        
        $scope.toggleBlock = function(blockId) {
            $('#'+blockId).slideToggle(10);
    }
        $scope.operatingcost=0;
        $scope.cashflowdata=[];
        $("#company_id").multiselect({
            maxHeight: 200,   
            includeSelectAllOption: true,
            disableIfEmpty: true,
            enableCaseInsensitiveFiltering: true,
            onDropdownHide: function (event) {
                
            }
          });
        $('#cf_fromDate').datetimepicker({
            format : 'DD/MM/YYYY',
            pickTime: false
        });
        
        $('#cf_toDate').datetimepicker({
            format : 'DD/MM/YYYY',
            pickTime: false
        });
        var date=new Date();
        $scope.month = $filter('date')(date, 'MMMM');//December-November like
        $scope.day = $filter('date')(date, 'dd'); //01-31 like
        $scope.year = $filter('date')(date,'yyyy');
        
        $scope.currYear = Number($scope.year);
        $scope.prevYear = Number($scope.year) - 1;
     /*   $http.get('app/profitloss/getCompanyList').success(function(datas) {
            $scope.companyList = datas;
            }).error(function(datas) {
        });
        */
        
        $http.get($stateParams.tenantid+'/app/usermaster/getCompanyList?formCode='+$('#form_code_id').val()).success(function(datas) {
            debugger;           
            $scope.companyList = datas;   
            
            
            console.log("company")
            console.log($scope.companyList)
            var foundItemDest = $filter('filter')($scope.companyList, { baseCompany:  1 })[0];
            $scope.cashflow.company=foundItemDest.id;
            
            
            
            
            
          /*  $timeout(function() {
                $('#company_id').multiselect('deselectAll', false);
                $('#company_id').multiselect('updateButtonText');
                $("#company_id").multiselect('rebuild');
            
            }, 2, false);*/
            
            }).error(function(datas) {
        });
        
        $scope.resetData=function(){
            $scope.cashflow={
                    fromDate:'',
                    toDate:'',
                    company:'',
                    rowid:''
                 }
            $timeout(function() {
                $('#company_id').multiselect('deselectAll', false);
                $('#company_id').multiselect('updateButtonText');
                $("#company_id").multiselect('rebuild');
            
            }, 2, false);
            $scope.cashflowdata=[];
        }
        
        $scope.viewProfitLoss = function(){
            $scope.cashflow.fromDate = $('#fromDate').val();
            $scope.cashflow.toDate = $('#toDate').val();
            
            $scope.cashflow.company='';
            if($scope.company!=undefined && $scope.company.length>0){
                $scope.cashflow.company=$scope.company.join("','");
            }
            
            $http.post($stateParams.tenantid+'/app/cashflow/cashflowstatement',$scope.cashflow).success(function(datas) {
                debugger;
                $scope.cashflowdata=datas.lCashFlowStatementList;                
                }).error(function(datas) {
            });
        }
        
        $scope.exportPLExcel = function(){
            $scope.pl.fromDate = $('#fromDate').val();
            $scope.pl.toDate = $('#toDate').val();
            $http.post('app/profitloss/exportPLExcel',$scope.pl).success(function(data) {
                if(data){
                    debugger;
                    $("#PLExport").bind('click', function() {
                    });
                    $('#PLExport').simulateClick('click');
                    logger.logSuccess("Exported successfully!");
                }else{
                    logger.logSuccess("Failed to export");
                }
                }).error(function(datas) {
            });
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
        
        $scope.populateCashFlowGrid = function(cfListData){
            debugger;
            $("#cashflowReportGrid").jqGrid({
                data: cfListData,
                datatype: "local",
                multiboxonly: false,
                autowidth: true,
                height: '100%',
               // rowList: [10,20,30],
                multiselect: false,
                loadonce: true,
                gridview:true,
                colNames:['Name','Amount'],
                colModel:[
                          {name:'accountHeadName',index:'accountHeadName', width:350, align:"left",searchoptions:{sopt:['cn']}},
                          {name:'amount',index:'amount', width:350,align:"right", searchoptions:{sopt:['cn']},hidden:false}
                          ],
               // pager: "#cashflowReportGridPage",
                viewrecords: true,
                //caption: 'Income and Expenditure List',
                ignoreCase: true,
                subGrid: true,
                subGridOptions: {
                    "plusicon" : 'ui-icon-plus',
                    "minusicon" : 'ui-icon-minus'/*
                    "openicon" : 'fa fa-plus-circle',
                    "reloadOnExpand" : true*/
                },
                

                footerrow: false,

                subGridRowExpanded: function(subgrid_id, row_id) {
                    debugger;
                    var subgrid_table_id, pager_id; subgrid_table_id = subgrid_id+"_t";
                    pager_id = "p_"+subgrid_table_id;
                    $scope.cashflow.rowid=row_id;
                    
                    $("#"+subgrid_id).html("<table id='"+subgrid_table_id+"' class='scroll'></table><div id='"+pager_id+"' class='scroll'></div>");
                    $http.post($stateParams.tenantid+'/app/cashflow/generateCashFlowDtl',$scope.cashflow).success(function(dtlData) {
                        console.log(dtlData);
                        debugger;
                        $("#"+subgrid_table_id).jqGrid({
                            datatype: "local",
                            data: dtlData.lCashFlowStatementList,
                            colNames:['Account Head Code','Account Head Name','Amount'],
                            colModel:[
                                {name:'accountHeadCode',index:'accountHeadCode', width:50, align:"left",searchoptions:{sopt:['cn']}},
                                {name:'accountHeadName',index:'accountHeadName', width:50, align:"left",searchoptions:{sopt:['cn']},hidden:false},
                                {name:'amount',index:'amount', width:50,align:"right", searchoptions:{sopt:['cn']},hidden:false},
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
            
        }
    });


