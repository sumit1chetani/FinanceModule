'use strict';
    app.controller('loansAndAdvancesController', function($scope, $rootScope,$http, logger, $log, ngDialog, $modal, $window,$location,$filter,$stateParams) {
        $scope.loanAndAdvances={
                
                category:'',
                department:'',
                employee:'',
                customer:'',
                supplier:''
             }
        
        
       $http.get($stateParams.tenantid+'/app/laonsadvances/getDepartmentList').success(function(datas) {
            $scope.departmentList = datas;
            }).error(function(datas) {
        });
                
        $http.get($stateParams.tenantid+'/app/laonsadvances/getCustomerList').success(function(datas) {
            $scope.customerList = datas;
            }).error(function(datas) {
        });
        
        $http.get($stateParams.tenantid+'/app/laonsadvances/getSupplierList').success(function(datas) {
            $scope.supplierList = datas;
            }).error(function(datas) {
        });
        
        $scope.$watch('loanAndAdvances.department', function(newValue, oldValue) {          
            $scope.employeeList=[];
            $scope.loanAndAdvances.employee='';
                 if(newValue != ''){              
                     $scope.getEmployee($scope.loanAndAdvances.department);
                 }
             });
        $scope.getEmployee = function(department) {
            debugger
            var url = $stateParams.tenantid+'/app/laonsadvances/getEmployeeList?department='+department;
            $http.get(url).success(function(data) {
                console.log(data);
                if(data.success){
                    $scope.employeeList = data.employeeList;
                }
            });
        };
        
        $scope.showLoanAdvCategory = function(){
            $("#deptEmp").show();
            $("#acctHd").hide();
            $("#supplierDropDn").hide();            
        }
        $scope.showCustSupp = function(){
            $("#deptEmp").hide();
            $("#acctHd").show();
            $("#supplierDropDn").hide();
        }  
        
        $scope.showSupplier = function(){
            $("#deptEmp").hide();
            $("#acctHd").hide();
            $("#supplierDropDn").show();
        }  
        
        $scope.onLoadLA=function(){
            $("#acctHd").hide();
            $("#supplierDropDn").hide();
        }
        $scope.onLoadLA();
        
        
        $scope.viewLoanAndAdvances = function(){             
            var supplierCust = $scope.loanAndAdvances.category;
            if(supplierCust=="supplier"){           
                $("#laGrid").hide();
                $("#suppGrid").show();
                $("#custGrid").hide();
                $http.post($stateParams.tenantid+'/app/laonsadvances/generateLoanAdvanceReport',$scope.loanAndAdvances).success(function(datas) {                   
                    $scope.populateCustomerSupplier(datas);
                    console.log("Supplier Datas");
                    console.log(datas);
                    }).error(function(datas) {
                });                                
            }else if (supplierCust=="customer"){
                $("#laGrid").hide();
                $("#suppGrid").hide();
                $("#custGrid").show();
                $http.post($stateParams.tenantid+'/app/laonsadvances/generateLoanAdvanceReport',$scope.loanAndAdvances).success(function(datas) {                   
                    $scope.populateCustomer(datas);
                    console.log("Supplier Datas");
                    console.log(datas);
                    }).error(function(datas) {
                });
            }
                
           else{
               $("#laGrid").show();
               $("#suppGrid").hide();
               $("#custGrid").hide();
                $http.post($stateParams.tenantid+'/app/laonsadvances/generateLoanAdvanceReport',$scope.loanAndAdvances).success(function(datas) {
                    debugger;
                    $scope.populateLoanAndAdvances(datas);
                    console.log(datas);
                    }).error(function(datas) {
                });    
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
        
       $scope.populateLoanAndAdvances = function(cListData){            
            $("#laGrid").show();
            $("#suppGrid").hide();
            $("#custGrid").hide();
            $("#plReportGrid").jqGrid({
                data: cListData,
                datatype: "local",
                multiboxonly: true,
                autowidth: true,
                height: '100%',
                rowList: [10,20,30],
                multiselect: true,
                loadonce: true,
                gridview:true,
                colNames:['Employee Name','Loan Availed','Loan', 'Loan From','Loan To','Payed From','Payed To','Balance'],
                colModel:[
                          {name:'employeeName',index:'employeeName', width:200, align:"left",searchoptions:{sopt:['cn']}},
                          {name:'loanAvailed',index:'loanAvailed', width:100, align:"right",searchoptions:{sopt:['cn']},hidden:false},
                          {name:'loan',index:'loan', width:100, align:"right", searchoptions:{sopt:['cn']},hidden:false},
                          {name:'loanFromDate',index:'loanFromDate', width:75, align:"right", searchoptions:{sopt:['cn']},hidden:false},
                          {name:'loanToDate',index:'loanToDate', width:75, align:"right", searchoptions:{sopt:['cn']},hidden:false},
                          {name:'payFromDate',index:'payFromDate', width:75, align:"right", searchoptions:{sopt:['cn']},hidden:false},
                          {name:'payToDate',index:'payToDate', width:75, align:"right", searchoptions:{sopt:['cn']},hidden:false},                          
                          {name:'balance',index:'balance', width:100, align:"right", searchoptions:{sopt:['cn']},hidden:false}                          
                          ],                 
                          
                pager: "#plReportGridPage",
                viewrecords: true,
                //caption: 'Profit And Loss List',
                ignoreCase: true,
                subGrid: false,
                subGridOptions: {
                    "plusicon" : 'ui-icon-plus',
                    "minusicon" : 'ui-icon-minus',
                    "openicon" : 'fa fa-plus-circle',
                    "reloadOnExpand" : true
                },
                

                footerrow: true,

                
            });
            
        } 
       //Customer Suppler Grid       
       $scope.populateCustomerSupplier = function(cListData){
           $("#laGrid").hide();
           $("#suppGrid").show();
           $("#custGrid").hide();
           $("#plSupplierGrid").jqGrid({
               data: cListData,
               datatype: "local",
               multiboxonly: true,
               autowidth: true,
               height: '100%',
               rowList: [10,20,30],
               multiselect: true,
               loadonce: true,
               gridview:true,
               colNames:['Supplier Name','Credit','Debit', 'Balance'],
               colModel:[
                         {name:'supplier',index:'supplier', width:200, align:"left",searchoptions:{sopt:['cn']}},
                         {name:'credit',index:'credit', width:100, align:"right",searchoptions:{sopt:['cn']},hidden:false},
                         {name:'debit',index:'debit', width:100, align:"right", searchoptions:{sopt:['cn']},hidden:false},
                         {name:'balance',index:'balance', width:75, align:"right", searchoptions:{sopt:['cn']},hidden:false}                                                 
                         ],                 
                         
               pager: "#plSupplierGridPage",
               viewrecords: true,
               //caption: 'Profit And Loss List',
               ignoreCase: true,
               subGrid: false,
               subGridOptions: {
                   "plusicon" : 'ui-icon-plus',
                   "minusicon" : 'ui-icon-minus',
                   "openicon" : 'fa fa-plus-circle',
                   "reloadOnExpand" : true
               },
               

               footerrow: true,

               
           });
           
       } 
       
       $scope.populateCustomer = function(cListData){
           $("#laGrid").hide();
           $("#suppGrid").hide();
           $("#custGrid").show();
           $("#plCustomerGrid").jqGrid({
               data: cListData,
               datatype: "local",
               multiboxonly: true,
               autowidth: true,
               height: '100%',
               rowList: [10,20,30],
               multiselect: true,
               loadonce: true,
               gridview:true,
               colNames:['Customer Name','Credit','Debit', 'Balance'],
               colModel:[
                         {name:'customer',index:'customer', width:200, align:"left",searchoptions:{sopt:['cn']}},
                         {name:'credit',index:'credit', width:100, align:"right",searchoptions:{sopt:['cn']},hidden:false},
                         {name:'debit',index:'debit', width:100, align:"right", searchoptions:{sopt:['cn']},hidden:false},
                         {name:'balance',index:'balance', width:75, align:"right", searchoptions:{sopt:['cn']},hidden:false}                                                 
                         ],                 
                         
               pager: "#plCustomerGridPage",
               viewrecords: true,
               //caption: 'Profit And Loss List',
               ignoreCase: true,
               subGrid: false,
               subGridOptions: {
                   "plusicon" : 'ui-icon-plus',
                   "minusicon" : 'ui-icon-minus',
                   "openicon" : 'fa fa-plus-circle',
                   "reloadOnExpand" : true
               },
               

               footerrow: true,

               
           });
           
       }

       
    });


