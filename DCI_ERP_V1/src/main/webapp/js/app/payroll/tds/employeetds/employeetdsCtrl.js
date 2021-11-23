
    'use strict';

       	app.controller('employeetdsCtrl', function($stateParams,$scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService,utilsService, $window,$timeout) {

        $scope.getBranchList = [];
        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.taxSlab = [];
        $scope.tdsotherIncome = [];
        var a = 0, fullTotal = 0, fullGross = 0;

        $scope.isDisplay = true;
        $scope.handsonData = [];
        
        $scope.TdsBean = {
                employeeId:'',
                departmentId:'',
                branchId:'',
                companyId:'',
                companyName:'',
                branchName:'',
                financialYear:'',
                declared : false,
                actual :false,
                isOnLoad : false
                 
         };
        
       
        $scope.checkdecalare = function() {
            
            $scope.TdsBean.actual=false;
         
        };
      
        $scope.checkactuval = function() {
            $scope.TdsBean.declared=false;
            
        };
        
      
            
        $scope.getFinancialYear = function(){
            $http.get("payroll/tds/ptslab/getLoginfinancialYear").success(function(datas) {
                  console.log("financialYearList");
                  console.log(datas);
                  $scope.financialYearList = datas.financialYearList;
                 
              })
        }
        
         $scope.getCompanyList = function(){
            $http.get("payroll/payroll/payrollgeneration/getCompanyList").success(function(datas) {
                  console.log("getCompanyList");
                  $scope.companyList = datas.companyList;
              })
        }
        
        $scope.getBranchList = function(companyId,branchID){
            $http.post("payroll/payroll/payrollgeneration/getBranchList",companyId).success(function(datas) {
                    console.log("getBranchList");
                    $scope.branchList = datas.branchList;
                    console.log(branchID);
                    $scope.TdsBean.branchId=branchID;
                    $scope.departmentList=[];
                    $scope.employeeList=[];
                    console.log(datas);
                })
          }
       
        
        
        $scope.$watch('TdsBean.companyId', function(newValue, oldValue) {
            var companyId = newValue;
            
            if($scope.TdsBean.companyId != '' && $scope.TdsBean.isOnLoad == false){
                $scope.TdsBean.branchId='';
                $scope.TdsBean.branchName='';
            }
            $http.post("payroll/payroll/payrollgeneration/getBranchList",companyId).success(function(datas) {
                console.log("getBranchList");
                $scope.branchList = datas.branchList;
                if($scope.branchList.length==1){
                    $scope.TdsBean.branchId=$scope.branchList[0].branchId;
                    $scope.TdsBean.branchName=$scope.branchList[0].branchName;
                }
                $scope.TdsBean.isOnLoad=false;
                $scope.TdsBean.departmentId='';
                $scope.departmentList=[];
                $scope.employeeList=[];
                console.log($scope.branchList);
            })
           
          });
        
        $scope.getDepartment = function(branchId){
            console.log("branchID"+branchId);
           $http.post("payroll/payroll/payrollgeneration/getDepartmentList",branchId).success(function(datas) {
                  console.log("LoginUseDepartmentList");
                  console.log(datas);
                  $scope.departmentList = datas.departmentList;
                  $scope.TdsBean.departmentId='';
                  $scope.employeeList=[];
           })
        }
        
        $scope.$watch('TdsBean.branchId', function(newValue, oldValue) {
            var branchId = newValue;
            $http.post("payroll/payroll/payrollgeneration/getDepartmentList",branchId).success(function(datas) {
                console.log("LoginUseDepartmentList");
                console.log(datas);
                $scope.departmentList = datas.departmentList;
                $scope.TdsBean.departmentId='';
                $scope.employeeList=[];
         })
         
        });
        
        $scope.getEmployeeDetails = function(){
            
            $http.get("payroll/payroll/payrollgeneration/getUserDetail").success(function(datas) {
                  console.log("LoginUser");
                  console.log(datas);
                  $scope.getCompanyList();
                  $scope.TdsBean.isOnLoad = true;
                  $scope.TdsBean.companyId=datas.companyId;
                  $scope.TdsBean.companyName=datas.companyName;
                  $scope.TdsBean.branchId=datas.branchId;
                  $scope.TdsBean.branchName=datas.branchName;
                  $scope.getDepartment(datas.branchId);
                  
              })
        }

       
        $scope.getEmployeeDetails();
        document.getElementById("declared").value = "True";
       
        
        $scope.$watch('TdsBean.departmentId', function(newValue, oldValue) {
            var departmentId = newValue;
            var branchId =  $scope.TdsBean.branchId;
            console.log("Department ID:"+departmentId);
            console.log("Branch ID:"+$scope.TdsBean.branchId);
            var resultBean={
                    branchId:$scope.TdsBean.branchId,
                    departmentId:departmentId
                    };
            $http.post("payroll/payroll/payrollgeneration/getEmployeeList",resultBean).success(function(datas) {
                  console.log("LoginUseEmployeeList");
                  $scope.employeeList = datas.employeeList;
                  $scope.TdsBean.employeeId='';
                  console.log(datas);
              })
         
        });
        
        $scope.getEmployeeList = function(departmentId){
            console.log("Department ID:"+departmentId);
            console.log("Branch ID:"+$scope.TdsBean.branchId);
            var resultBean={
                    branchId:$scope.TdsBean.branchId,
                    departmentId:departmentId
                    };
            $http.post("payroll/payroll/payrollgeneration/getEmployeeList",resultBean).success(function(datas) {
                  console.log("LoginUseEmployeeList");
                  $scope.employeeList = datas.employeeList;
                  $scope.TdsBean.employeeId='';
                  console.log(datas);
              })
        }
        

        $scope.generate = function() {

            $state.go('app.payroll.tds.employeetds.add');
        };

        
        $scope.getFinancialYear();

        $scope.add = function() {

            // $state.go('app.payroll.tds.employeehra.add');
        };
        $scope.cancel = function() {

            // $state.go('app.payroll.tds.employeehra');
        };
        $("#handsonGrid").hide();
        $("#result").hide();
        $scope.totalcount=0;
        $scope.focusHandson = function(payrollReportForm)
        {
            $("#handsonGrid").handsontable('clear'); 
           if (new validationService().checkFormValidity(payrollReportForm)) {
            document.getElementById("showButton").disabled = true; 
            $("#result").show();
            var resultBean = {
                    employeeId : $scope.TdsBean.employeeId,
                    financialYear : $scope.TdsBean.financialYear,
                    declared:$scope.TdsBean.declared,
                    actual:$scope.TdsBean.actual
            };
            $http.post('payroll/tds/tds/tdslist', resultBean).success(function(datas) { 
               $("#handsonGrid").show();
               console.log("Result is");
               console.log(datas);
                $scope.handsonData = datas.tdsPayList;
                $scope.tdsSlabData = datas.tdsSlabList;
                $scope.totalcount = datas.monthbean.count;
                $scope.tdsotherIncome = datas.tdsOtherIncomeList;
                $scope.tdsSubSectionData = datas.tdsSubSectionList;
                $("#handsonGrid").handsontable('clear'); 
                $scope.handsondata = [ [ "BASIC", 0,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ],
                                       [ "DA", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ], 
                                       [ "CONVE", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
                                       [ "HRA", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ], 
                                       [ "Ch. Educ", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
                                       [ "MEDIC", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ], 
                                       [ "LTA", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
                                       [ "Uniform All", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
                                       [ "Misc", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
                                       [ "Misc", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
                                       [ "Misc", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
                                       [ "Total", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
                                       [ "PFSEL", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
                                       [ "PFCOM", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
                                       [ "VPF", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ], 
                                       [ "IT", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
                                       [ "Rent", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
                                       [ "Life Insurance", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
                                       [ "Oth Ded", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
                                       [ "Oth Ded", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ], 
                                       [ "Tot Ded", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ], 
                                       [ "Net", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
                                       [ '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '' ],
                                       [],
                       /*              ['','','','','','','','','','','','','','','','',''],*/
                                    
                                        [ 'Tax Computation', '', '', '', '', '', '', '', 'Exemptions under section 10 & 17', '', '', '', '', '', '','Produced', 'Limited', '', '' ], 
                                        [ 'Gross Salary', '', '', '', '', '', 0, '', 'HRA Exemption (sec 10 (13A))', '', '', '', '', '', '', 0, 0, 'HRAE', 'declared_amount', 'limited' ],
                                        [ 'Professional Tax', '', '', '', '', '', '', '', 'Transport Exemption (sec 10(14))', '', '', '', '', '', '', 0, 0, 'TE' , 'declared_amount', 'limited' ],
                                        [ 'Exemptions under section 10 & 17', '', '', '', '', '', '', '', 'Medical Bills Exemption (sec 17(2))', '', '', '', '', '', '', 0, 0, 'MBE', 'declared_amount', 'limited' ],
                                        [ 'Gross Salary after Section 10 & 17 exemptions', '', '', '', '', '', '', '', 'Childrens Education Allowance Exemption (sec 10 (14))', '', '', '', '', '', '', 0, 0, 'CEAE' , 'declared_amount', 'limited'],
                                        [ 'Income chargeable under head House/Property', '', '', '', '', '', '', '', 'LTA exemption (sec 10(5))', '', '', '', '', '', '', 0,0, 'LTAE' , 'declared_amount', 'limited'],
                                        [ 'Income chargeable under head Other Sources', '', '', '', '', '', '', '', 'Uniform expenses (sec 10(14))', '', '', '', '', '', '',0 ,0 , 'UE','declared_amount', 'limited' ],
                                        [ 'Gross Total Income', '', '', '', '', '', '', '', 'Total Exempted Allowances', '', '', '', '', '', '','' , '', '' ,'', ''], 
                                        [ 'Deductions  under chapter VI-A', '', '', '', '', '', '', ''], 
                                        [ 'Deductions under sec 80C', '', '', '', '', '', '', '','Other income', '', '', '', '', '','', 'Produced', 'Limited', '' ], 
                                        [ 'Net taxable income', '', '', '', '', '', '', '','House/property income or loss (enter loss as negative) ', '', '', '', '', '', '', 0, 0 ,'HPI', 'amount', 'limited'],
                                        [ '', '', '', '', '', '', '', '', 'Interest on housing loan (for tax exemption) ', '', '', '', '', '', '', 0, 0 ,'HLI', 'amount', 'limited', '' ],
                                        [ 'Tax Slabs', '', '', 'Tax Rate', 'Appl Amt', 'Balance', 'Tax', '','Other income (interest, etc. excluding. SB int) ', '', '', '', '', '', '',0,0,'OI', 'amount', 'limited', '' ],
                                        [ '00000', '-', '300000', 0, ' ', '', 0, '', '', '', '', '', '', '', '', '', '', '.', '', '', ''], 
                                        [ '300001', '-', '500000',0, ' ', '', 0, '','Deductions under Chapter VI-A', '', '', '', '', '', '', 'Produced', 'Limited', '', '', '', ''],
                                        [ '500001', '-', '1000000',0, ' ', '', 0, '', 'Medical Insurance Premium / health check (sec 80D)', '', '', '', '', '', '', 0, 0 , '80D1', 'declared_amount', 'limited'  ],
                                        [ '1000001', '-', '9999999', 0, '', '', 0, '', 'Medical Insurance Premium for parents (sec 80D)', '', '', '', '', '', '', 0, 0, '80D2', 'declared_amount', 'limited'], 
                                        [ 'Tax credit (Sec 87A)', '', '', '', ' ', '', '','',  'Medical for handicapped dependents (sec 80DD)', '', '', '', '', '', '', 0, 0,'80DD', 'declared_amount', 'limited'], 
                                        [ 'Tax on Income', '', '', '', ' ', '', '', '', 'Medical for specified diseases (sec 80DDB)', '', '', '', '', '', '',0,0,'80DDB', 'declared_amount', 'limited'  ], 
                                        [ 'Surcharge on Income Tax', '', '', '', ' ', '', '','','Higher Education Loan Interest Repayment (sec 80E)', '', '', '', '', '', '',0, 0, '80E', 'declared_amount', 'limited' ],
                                        [ 'Education Cess', '', '', '', ' ', '', '', '', 'Donation to approved fund and charities (sec 80G)', '', '', '', '', '', '', 0, 0,'80E', 'declared_amount', 'limited' ],
                                        [ 'Total tax Liability', '', '', '', ' ', '', 0, '','Rent deduction (sec 80GG) only if HRA not received', '', '', '', '', '', '', 0, 0,'80G', 'declared_amount', 'limited'],
                                        [ 'Total Income tax paid from salary', '', '', '', ' ', '', 0, '','Deduction for permanent disability (sec 80U)', '', '', '', '', '', '', 0, 0,'80U', 'declared_amount', 'limited'], 
                                        [ 'Income tax due', '', '', '', ' ', '', '','', 'Any other deductions (incl. donations u/s 35AC/80GGA)', '', '', '', '', '', '', 0,0 ,'80GGA', 'declared_amount', 'limited' ], 
                                        [ 'Remaining Months in Year', '', '', '', ' ', '', '','','Total Deductibles', '', '', '', '', '', '','','','', '', '' ],
                                        [ 'Tax Per Month', '', '', '', ' ', '', '', '','', '', '', '', '', '', '','', '','', '', '' ],
                                        [ '', '', '', '', ' ', '', '','','Deductions under Chapter VI (sec 80C)', '', '', '', '', '', '','Produced', 'Limited', '' ],
                                        [ '', '', '', '', ' ', '', '', '','National Pension scheme (sec 80CCD)', '', '', '', '', '', '', 0,0, '80CCD', 'declared_amount', 'limited'], 
                                        [ '', '', '', '', ' ', '', '', '', 'Pension scheme (sec 80C)', '', '', '', '', '', '', 0, 0, '80C1', 'declared_amount',    'limited' ],
                                        [ '', '', '', '', ' ', '', '', '', 'NSC (sec 80C)', '', '', '', '', '', '', 0, 0, '80C2', 'declared_amount', 'limited'], 
                                        [ '', '', '', '', ' ', '', '', '', 'Public Provident Fund (sec 80C)', '', '', '', '', '', '', 0,0, '80C3', 'declared_amount', 'limited' ],
                                        [ '', '', '', '', ' ', '', '', '', 'Employees Provident Fund & Voluntary PF (sec 80C)', '', '', '', '', '', '', 0, 0, '80C4', 'declared_amount', 'limited' ],
                                        [ '', '', '', '', ' ', '', '', '', 'Childrens Education Tuition Fees (sec 80C)', '', '', '', '', '', '', 0, 0, '80C5', 'declared_amount', 'limited' ],
                                        [ '', '', '', '', ' ', '', '', '', 'Housing loan principal repayment, regn/stamp duty (sec 80C)', '', '', '', '', '', '', 0, 0, '80C6', 'declared_amount', 'limited' ],
                                        [ '', '', '', '', ' ', '', '', '', 'Insurance premium & others (MF, ULIP, FD, SS, etc.) (sec 80C) ', '', '', '', '', '', '', 0, 0 , '80C7', 'declared_amount', 'limited' ], 
                                        [ '', '', '', '', ' ', '', '', '', 'Rajiv Gandhi Equity Savings Scheme (sec 80CCG)', '', '', '', '', '', '', 0, 0, '80CCG', 'declared_amount', 'limited' ],
                                        [ '', '', '', '', ' ', '', '', '', 'Total Investments', '', '', '', '', '', '', '', '', '', '', '' ],
                                        [ '', '', '', '', ' ', '', '', '', ' ', '', '', '', '', '', '', '', '' , '', '', '' ], 
                                       ,


                ]
                
                    for (var j = 0; j < $scope.handsonData.length; j++) {
                    for (var i = 0; i < 19; i++) {
                        if ($scope.handsondata[i][0] == $scope.handsonData[j].pay_component_id) {
                            if ($scope.handsonData[j].mon == 'Jan') {
                                $scope.handsondata[i][10] = $scope.handsonData[j].amount;

                            }

                            if ($scope.handsonData[j].mon == 'Feb') {
                                $scope.handsondata[i][11] = $scope.handsonData[j].amount;

                            }

                            if ($scope.handsonData[j].mon == 'Mar') {
                                $scope.handsondata[i][12] = $scope.handsonData[j].amount;

                            }
                            if ($scope.handsonData[j].mon == 'Apr') {
                                $scope.handsondata[i][1] = $scope.handsonData[j].amount;

                            }
                            if ($scope.handsonData[j].mon == 'May') {
                                $scope.handsondata[i][2] = $scope.handsonData[j].amount;
  
                            }
                            if ($scope.handsonData[j].mon == 'Jun') {
                                $scope.handsondata[i][3] = $scope.handsonData[j].amount;

                            }

                            if ($scope.handsonData[j].mon == 'Jul') {
                                $scope.handsondata[i][4] = $scope.handsonData[j].amount;

                            }

                            if ($scope.handsonData[j].mon == 'Aug') {
                                $scope.handsondata[i][5] = $scope.handsonData[j].amount;

                            }
                            if ($scope.handsonData[j].mon == 'Sep') {
                                $scope.handsondata[i][6] = $scope.handsonData[j].amount;

                            }
                            if ($scope.handsonData[j].mon == 'Oct') {
                                $scope.handsondata[i][7] = $scope.handsonData[j].amount;

                            }
                            if ($scope.handsonData[j].mon == 'Nov') {
                                $scope.handsondata[i][8] = $scope.handsonData[j].amount;

                            }

                            if ($scope.handsonData[j].mon == 'Dec') {
                                $scope.handsondata[i][9] = $scope.handsonData[j].amount;

                            }
                        }

                    }

                }

                for (var j = 0; j < $scope.tdsSlabData.length; j++) {

                    for (var i = 0; i < 42; i++) {

                        if ($scope.handsondata[i][2] == $scope.tdsSlabData[j].rangeTo) {
                            $scope.handsondata[i][3] = $scope.tdsSlabData[j].rateInPercentage;
                        }
                    }
                }

             for (var j = 0; j < $scope.tdsSubSectionData.length; j++) {

                    for (var i = 0; i < 61; i++) {

                        if ($scope.handsondata[i][17] == $scope.tdsSubSectionData[j].tax_sub_section_code) {
                            if($scope.TdsBean.declared == true){
                                $scope.handsondata[i][15] = $scope.tdsSubSectionData[j].declared_amount;
                            }else{
                                if($scope.TdsBean.actual == true){
                                    $scope.handsondata[i][15] = $scope.tdsSubSectionData[j].actual_amount;
                                }
                               
                            }
                           
                            
                            $scope.handsondata[i][16] = $scope.tdsSubSectionData[j].limited;

                        }

                    }
                }
             
              for (var j = 0; j < $scope.tdsotherIncome.length; j++) {
              for (var i = 33; i <= 38 ; i++) {

                        if ($scope.handsondata[i][17] == $scope.tdsotherIncome[j].other_income_head_id) {
                            $scope.handsondata[i][15] = $scope.tdsotherIncome[j].amount;
                            $scope.handsondata[i][16] = $scope.tdsotherIncome[j].limited;
                           

                        }

                    }
                }

                var ValueRenderer = function(instance, td, row, col, prop, value, cellProperties) {
                    Handsontable.renderers.TextRenderer.apply(this, arguments);
                    
                    td.style.color = 'green';
                    td.style.fontWeight = 'bold';
                }
                
                var pinkRenderer = function(instance, td, row, col, prop, value, cellProperties) {
                    Handsontable.renderers.TextRenderer.apply(this, arguments);
                    
                    td.style.color = 'blue';
                    td.style.fontWeight = 'bold';
                }
                
                var sideRenderer = function(instance, td, row, col, prop, value, cellProperties) {
                    Handsontable.renderers.TextRenderer.apply(this, arguments);
                    td.style.color = 'black';


                }
                
                var boldRenderer = function(instance, td, row, col, prop, value, cellProperties) {
                    Handsontable.renderers.TextRenderer.apply(this, arguments);
                    td.style.color = 'black';
                    td.style.fontWeight = 'bold';

                }
                
                var redRenderer = function(instance, td, row, col, prop, value, cellProperties) {
                    Handsontable.renderers.TextRenderer.apply(this, arguments);
                    td.style.color = 'red';
                    td.style.fontWeight = 'bold';

                }
                var count = 0;

                var tdsHandson = new Handsontable(document.getElementById('employeeTDS'), {
                    data : $scope.handsondata,

                 //   rowHeaders : true,

                    mergeCells : [ {
                        row : 23,
                        col : 0,
                        rowspan : 1,
                        colspan : 5
                    }, {
                        row : 24,
                        col : 0,
                        rowspan : 1,
                        colspan : 6
                    }, {
                        row : 25,
                        col : 0,
                        rowspan : 1,
                        colspan : 6
                    }, {
                        row : 26,
                        col : 0,
                        rowspan : 1,
                        colspan : 6
                    }, {
                        row : 27,
                        col : 0,
                        rowspan : 1,
                        colspan : 6
                    }, {
                        row : 28,
                        col : 0,
                        rowspan : 1,
                        colspan : 6
                    }, {
                        row : 29,
                        col : 0,
                        rowspan : 1,
                        colspan : 6
                    }, {
                        row : 30,
                        col : 0,
                        rowspan : 1,
                        colspan : 6
                    }, {
                        row : 31,
                        col : 0,
                        rowspan : 1,
                        colspan : 6
                    }, {
                        row : 32,
                        col : 0,
                        rowspan : 1,
                        colspan : 6
                    }, {
                        row : 33,
                        col : 0,
                        rowspan : 1,
                        colspan : 6
                    }, {
                        row : 34,
                        col : 0,
                        rowspan : 1,
                        colspan : 6
                    }, {
                        row : 35,
                        col : 0,
                        rowspan : 1,
                        colspan : 6
                    }, {
                        row : 35,
                        col : 8,
                        rowspan : 1,
                        colspan : 7
                    },
                    {
                        row : 36,
                        col : 8,
                        rowspan : 1,
                        colspan : 7
                    },
                    {
                        row : 34,
                        col : 8,
                        rowspan : 1,
                        colspan : 7
                    }, {
                        row : 37,
                        col : 8,
                        rowspan : 1,
                        colspan : 7
                    }, {
                        row : 38,
                        col : 8,
                        rowspan : 1,
                        colspan : 7
                    }, {
                        row : 39,
                        col : 8,
                        rowspan : 1,
                        colspan : 7
                    }, {
                        row : 40,
                        col : 8,
                        rowspan : 1,
                        colspan : 7
                    }, {
                        row : 41,
                        col : 8,
                        rowspan : 1,
                        colspan : 7
                    }, 
                    {
                        row : 41,
                        col : 0,
                        rowspan : 1,
                        colspan : 6
                    }, {
                        row : 42,
                        col : 0,
                        rowspan : 1,
                        colspan : 6
                    },
                    //   {row: 40, col:0, rowspan:1, colspan:5},
                    {
                        row : 23,
                        col : 8,
                        rowspan : 1,
                        colspan : 6
                    }, {
                        row : 24,
                        col : 8,
                        rowspan : 1,
                        colspan : 7
                    }, {
                        row : 25,
                        col : 8,
                        rowspan : 1,
                        colspan : 7
                    }, {
                        row : 26,
                        col : 8,
                        rowspan : 1,
                        colspan : 7
                    }, {
                        row : 27,
                        col : 8,
                        rowspan : 1,
                        colspan : 7
                    }, {
                        row : 28,
                        col : 8,
                        rowspan : 1,
                        colspan : 7
                    }, {
                        row : 29,
                        col : 8,
                        rowspan : 1,
                        colspan : 7
                    }, {
                        row : 30,
                        col : 8,
                        rowspan : 1,
                        colspan : 7
                    }, {
                        row : 31,
                        col : 8,
                        rowspan : 1,
                        colspan : 7
                    }, {
                        row : 32,
                        col : 8,
                        rowspan : 1,
                        colspan : 7
                    }, {
                        row : 33,
                        col : 8,
                        rowspan : 1,
                        colspan : 7
                    },

                    {
                        row : 42,
                        col : 0,
                        rowspan : 1,
                        colspan : 6
                    }, {
                        row : 43,
                        col : 0,
                        rowspan : 1,
                        colspan : 6
                    }, {
                        row : 44,
                        col : 0,
                        rowspan : 1,
                        colspan : 6
                    }, {
                        row : 45,
                        col : 0,
                        rowspan : 1,
                        colspan : 6
                    }, {
                        row : 46,
                        col : 0,
                        rowspan : 1,
                        colspan : 6
                    }, {
                        row : 47,
                        col : 0,
                        rowspan : 1,
                        colspan : 6
                    }, {
                        row : 48,
                        col : 0,
                        rowspan : 1,
                        colspan : 6
                    }, {
                        row : 49,
                        col : 0,
                        rowspan : 1,
                        colspan : 6
                    }, {
                        row : 50,
                        col : 0,
                        rowspan : 1,
                        colspan : 6
                    },

                    {
                        row : 42,
                        col : 8,
                        rowspan : 1,
                        colspan : 7
                    }, {
                        row : 43,
                        col : 8,
                        rowspan : 1,
                        colspan : 7
                    }, {
                        row : 44,
                        col : 8,
                        rowspan : 1,
                        colspan : 7
                    }, {
                        row : 45,
                        col : 8,
                        rowspan : 1,
                        colspan : 7
                    }, {
                        row : 46,
                        col : 8,
                        rowspan : 1,
                        colspan : 7
                    }, {
                        row : 47,
                        col : 8,
                        rowspan : 1,
                        colspan : 7
                    }, {
                        row : 48,
                        col : 8,
                        rowspan : 1,
                        colspan : 7
                    }, {
                        row : 49,
                        col : 8,
                        rowspan : 1,
                        colspan : 7
                    }, {
                        row : 50,
                        col : 8,
                        rowspan : 1,
                        colspan : 7
                    }, {
                        row : 51,
                        col : 8,
                        rowspan : 1,
                        colspan : 7
                    },{
                        row : 53,
                        col : 8,
                        rowspan : 1,
                        colspan : 7
                    }, {
                        row : 54,
                        col : 8,
                        rowspan : 1,
                        colspan : 7
                    }, {
                        row : 55,
                        col : 8,
                        rowspan : 1,
                        colspan : 7
                    }, {
                        row : 56,
                        col : 8,
                        rowspan : 1,
                        colspan : 7
                    }, {
                        row : 57,
                        col : 8,
                        rowspan : 1,
                        colspan : 7
                    }, {
                        row : 58,
                        col : 8,
                        rowspan : 1,
                        colspan : 7
                    }, {
                        row : 59,
                        col : 8,
                        rowspan : 1,
                        colspan : 7
                    }, {
                        row : 60,
                        col : 8,
                        rowspan : 1,
                        colspan : 7
                    }, {
                        row : 52,
                        col : 8,
                        rowspan : 1,
                        colspan : 7
                    }, {
                        row : 61,
                        col : 8,
                        rowspan : 1,
                        colspan : 7
                    }
                    ],
                    stretchH : 'all',
                    className: "htRight",
                    colWidths : [ 60, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40 ],
                    colHeaders : [ '', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec', 'Jan', 'Feb', 'Mar', 'Total', 'Perks', 'Bonus', 'Gross' ],
                    afterInit : function() {
                        var  fullcal = 0;
                        var  fullgross = 0;var totalPf = 0;var totatlPfCom=0;
                        var count = 0;
                        for (var row = 0; row <= 11; row++) {                         
                                var a = isNaN(this.getDataAtCell(row, 0)) ? 0 : this.getDataAtCell(row, 0);
                                var b = isNaN(this.getDataAtCell(row, 1)) ? 0 : this.getDataAtCell(row, 1);
                                var c = isNaN(this.getDataAtCell(row, 2)) ? 0 : this.getDataAtCell(row, 2);
                                var d = isNaN(this.getDataAtCell(row, 3)) ? 0 : this.getDataAtCell(row, 3);
                                var e = isNaN(this.getDataAtCell(row, 4)) ? 0 : this.getDataAtCell(row, 4);
                                var f = isNaN(this.getDataAtCell(row, 5)) ? 0 : this.getDataAtCell(row, 5);
                                var g = isNaN(this.getDataAtCell(row, 6)) ? 0 : this.getDataAtCell(row, 6);
                                var h = isNaN(this.getDataAtCell(row, 7)) ? 0 : this.getDataAtCell(row, 7);
                                var i = isNaN(this.getDataAtCell(row, 8)) ? 0 : this.getDataAtCell(row, 8);
                                var j = isNaN(this.getDataAtCell(row, 9)) ? 0 : this.getDataAtCell(row, 9);
                                var k = isNaN(this.getDataAtCell(row, 10)) ? 0 : this.getDataAtCell(row, 10);
                                var l = isNaN(this.getDataAtCell(row, 11)) ? 0 : this.getDataAtCell(row, 11);
                                var m = isNaN(this.getDataAtCell(row, 12)) ? 0 : this.getDataAtCell(row, 12);
                                var n = isNaN(this.getDataAtCell(row,  14)) ? 0 : this.getDataAtCell(row, 14);
                                var o = isNaN(this.getDataAtCell(row, 15)) ? 0 : this.getDataAtCell(row, 15);
                                var Total = a + b + c + d + e + f + g + h + i + j + k +l + m ;
                                var Gross = a + b + c + d + e + f + g + h + i + j + k +l+ m +n + o;
                                this.setDataAtCell(row, 13, Total);
                                this.setDataAtCell(row, 16, Gross);
                                fullcal += Total;
                                fullgross += Gross;
                                this.setDataAtCell(11, 13, fullcal);
                                this.setDataAtCell(11, 16, fullgross);
                            
                            }
                                   this.setDataAtCell(25, 6, fullgross);
                              
                             //pf calculation
                                   for (var i = 0; i <= 12; i++) {
                                       var pf = isNaN(this.getDataAtCell(12, i)) ? 0 : this.getDataAtCell(12, i);
                                        totalPf += pf
                                       this.setDataAtCell(12, 13, totalPf);//full
                                       this.setDataAtCell(12, 16, totalPf);//gross
                                       
                                   }
                                   
                                   for (var i = 0; i <= 12; i++) {
                                       var pfcom = isNaN(this.getDataAtCell(13, i)) ? 0 : this.getDataAtCell(13, i);
                                         
                                           totatlPfCom += pfcom
                                          
                                           this.setDataAtCell(13, 13, totatlPfCom);//full
                                           this.setDataAtCell(13, 16, totatlPfCom);//gross
                                   }
                                   
                                  
                                   this.setDataAtCell(26, 6, totalPf);
                             //excemption under section 10 & 17
                                  var totalExcemption = 0;
                                  var totalExcemptionlimited = 0;
                                   for (var i = 25; i < 31 ; i++) {   
                                       var excemption = isNaN(this.getDataAtCell(i, 15)) ? 0 : this.getDataAtCell(i,15);
                                        totalExcemption += excemption
                                      this.setDataAtCell(31, 15, totalExcemption);                                 
                                   }
                                 //  this.setDataAtCell(27, 6, totalExcemption);
                                   
                                   for (var i = 25; i < 31 ; i++) {   
                                       var excemption = isNaN(this.getDataAtCell(i, 16)) ? 0 : this.getDataAtCell(i,16 );
                                        totalExcemptionlimited += excemption
                                       this.setDataAtCell(31, 16, totalExcemptionlimited);                                 
                                   }
                                   this.setDataAtCell(27, 6, totalExcemptionlimited);
                                 //  this.setDataAtCell(32, 6, totalExcemptionlimited);
                                     

                                     
                              // total deductions under chapter 6a
                                     
                                     var totalDeductionsLimited = 0;
                                     var totalDeductionsProduced = 0;
                                      for (var i = 38; i <= 47 ; i++) {   
                                          var excemption = isNaN(this.getDataAtCell(i, 15)) ? 0 :this.getDataAtCell(i,15);
                                          totalDeductionsProduced += excemption;   
                                          this.setDataAtCell(48, 15, totalDeductionsProduced); 
                                
                                      }
                                 
                                      for (var i = 38; i <= 47 ; i++) {   
                                          var excemption = isNaN(this.getDataAtCell(i, 16)) ? 0 : this.getDataAtCell(i,16);
                                          totalDeductionsLimited += excemption
                                          this.setDataAtCell(48, 16, totalDeductionsLimited);                                                   
                                      }
                                     this.setDataAtCell(32, 6, totalDeductionsLimited);
                                     var sixA =  this.getDataAtCell(32, 6, totalDeductionsLimited);
                             
                                     this.setDataAtCell(32, 6, totalDeductionsLimited);
                                     
                                     
                                      // 80C
                                      
                                   var eightyCLimited = 0;
                                      var eightyCProduced = 0;
                                       for (var i = 50; i < 60 ; i++) {   
                                           var excemption = isNaN(this.getDataAtCell(i, 15)) ? 0 :this.getDataAtCell(i,15);
                                           eightyCProduced += excemption
                                          this.setDataAtCell(60, 15, eightyCProduced);                                 
                                       }
                                       for (var i = 50; i < 60 ; i++) {   
                                           var excemption = isNaN(this.getDataAtCell(i, 16)) ? 0 : this.getDataAtCell(i,16);
                                           eightyCLimited += excemption
                                          this.setDataAtCell(60, 16, eightyCLimited);                                 
                                       }
                                       this.setDataAtCell(33, 6, eightyCLimited);
                                       var eightC =  this.getDataAtCell(33, 6, eightyCLimited);
                                       this.setDataAtCell(55, 15, totalPf);
                                       this.setDataAtCell(55, 16, 9999);
                                     
                                       
                                    // var GSAE =  this.getDataAtCell(25, 6, fullgross)-(this.getDataAtCell(26, 6, totalPf)+this.getDataAtCell(27, 6, totalExcemption));
                               var x =   isNaN(this.getDataAtCell(25, 6)) ? 0 : parseInt(this.getDataAtCell(25,6));
                               var y =   isNaN(this.getDataAtCell(26, 6)) ? 0 : parseInt(this.getDataAtCell(26,6));
                               var z =   isNaN(this.getDataAtCell(27, 6)) ? 0 : parseInt(this.getDataAtCell(27,6));
                                    var GSAE = x - ( y + z );
                                  
                                     this.setDataAtCell(28, 6, GSAE);
                                     var house = this.getDataAtCell(34, 16, '');
                                     var houseloan = this.getDataAtCell(35, 16, '');
                                     //var savBank = this.getDataAtCell(37, 16, '');
                                     var otherIncome= this.getDataAtCell(36, 16, '');
                                     var totalothersource=otherIncome;
                                     var totalhousesoruce=house-houseloan;
                                     this.setDataAtCell(29, 6, totalhousesoruce);
                                     this.setDataAtCell(32, 6, totalDeductionsLimited);
                                     var GrossTotalIncome = 0;
                                     var netTaxableIncome  = 0;
                                     GrossTotalIncome = GSAE - totalhousesoruce + totalothersource ;
                                     this.setDataAtCell(30, 6, totalothersource);
                                     this.setDataAtCell(31, 6, GrossTotalIncome);
                                     netTaxableIncome = GrossTotalIncome  - sixA - eightC ;
                                     this.setDataAtCell(34, 6, netTaxableIncome);
                                     
                                    
                                     
                  //tax slabs
                                     var tsValue1 = 0;var tsValue1=0;var tsValue1=0;var tsValue1=0; 
                             
                                     var A1 = isNaN(this.getDataAtCell(37, 0)) ? 0 : parseInt(this.getDataAtCell(37,0));
                                     var A2 = isNaN(this.getDataAtCell(38, 0)) ? 0 : parseInt(this.getDataAtCell(38,0));
                                     var A3 = isNaN(this.getDataAtCell(39, 0)) ? 0 : parseInt(this.getDataAtCell(39,0));
                                     var A4 = isNaN(this.getDataAtCell(40, 0)) ? 0 : parseInt(this.getDataAtCell(40,0));
                                     var C1 = isNaN(this.getDataAtCell(37, 2)) ? 0 : parseInt(this.getDataAtCell(37,2));
                                     var C2 = isNaN(this.getDataAtCell(38, 2)) ? 0 : parseInt(this.getDataAtCell(38,2));
                                     var C3 = isNaN(this.getDataAtCell(39, 2)) ? 0 : parseInt(this.getDataAtCell(39,2));
                                     var C4 = isNaN(this.getDataAtCell(40, 2)) ? 0 : parseInt(this.getDataAtCell(40,2));
                        //taxRate
                                     var taxRate1 = isNaN(this.getDataAtCell(37, 3)) ? 0 : parseInt(this.getDataAtCell(37,3));
                                     var taxRate2 = isNaN(this.getDataAtCell(38, 3)) ? 0 : parseInt(this.getDataAtCell(38,3));
                                     var taxRate3 = isNaN(this.getDataAtCell(39, 3)) ? 0 : parseInt(this.getDataAtCell(39,3));
                                     var taxRate4  = isNaN(this.getDataAtCell(40, 3)) ? 0 : parseInt(this.getDataAtCell(40,3));
                                     var tsValue1 =   C1 - A1
                                     var tsValue2 =   C2 - A2
                                     var tsValue3 =   C3 - A3
                                     var tsValue4 =   C4 - A4
                       
                       //application amt value
                                     var  ApplAmt1 = Math.min(netTaxableIncome, tsValue1);
                                     var  Balance1 = netTaxableIncome - ApplAmt1;
                                     this.setDataAtCell(37, 4, ApplAmt1);
                                     this.setDataAtCell(37, 5, Balance1);
       
                                     var  ApplAmt2 = Math.min(Balance1, tsValue2);
                                     var  Balance2 = Balance1 - ApplAmt2;
                                     this.setDataAtCell(38, 4, ApplAmt2);
                                     this.setDataAtCell(38, 5, Balance2);   
                                     
                                     var  ApplAmt3 = Math.min(Balance2, tsValue3);
                                     var  Balance3 = Balance2 - ApplAmt3;
                                     this.setDataAtCell(39, 4, ApplAmt3);
                                     this.setDataAtCell(39, 5, Balance3);
                                     this.setDataAtCell(40, 5, 0);
                                     
                                      var  ApplAmt4 = Math.min(Balance3, tsValue4); 
                                      this.setDataAtCell(40, 4, ApplAmt4);  
                                     
                                    var  Tax1 =  (taxRate1 * ApplAmt1)/100;    
                                    var  Tax2 =  (taxRate2 * ApplAmt2)/100;   
                                    var  Tax3 =  (taxRate3 * ApplAmt3)/100;   
                                    var  Tax4 =  (taxRate4 * ApplAmt4)/100; 
                                    this.setDataAtCell(37, 6, Math.round(Tax1));
                                    this.setDataAtCell(38, 6, Math.round(Tax2));
                                    this.setDataAtCell(39, 6, Math.round(Tax3));
                                    this.setDataAtCell(40, 6, Math.round(Tax4));
                                    var Tax5;
                                    if(netTaxableIncome < 500000)
                                        {
                                        Tax5 =  2000; 
                                        }
                                    else
                                        {
                                        Tax5 =  0; 
                                        }
                                    this.setDataAtCell(41, 6, Tax5);
                                    var TaxOnIncome = Tax1+Tax2+Tax3+Tax4 - Tax5;
                              
                                    if(TaxOnIncome < 0)
                                        {
                                    TaxOnIncome = 0;
                                    this.setDataAtCell(42, 6,0); 
                                    console.log("inside correct cond...")
                              
                                        }
                                    else
                                        {
                                    this.setDataAtCell(42, 6, Math.round(TaxOnIncome));
                                        }
                
                                    
                               //Surcharge on Income Tax
                                    
                                    var SurCharge = 0;
                                      if(netTaxableIncome > 10000000)
                                       {
                                        SurCharge =  (12 * TaxOnIncome )/100; 
                                        this.setDataAtCell(43, 6, SurCharge);
                                   
                                        
                                       }
                                    else
                                    {
                                         SurCharge =  0; 
                                         this.setDataAtCell(43, 6, 0);
          
                                    }
                                   
                                  
                              //Education cess
                                    var EducationCess = 0 ; 
                                    
                                       var SumOfExtraTax = SurCharge + TaxOnIncome;
                                       EducationCess =  (3*SumOfExtraTax)/100
                                       this.setDataAtCell(44, 6, Math.round(EducationCess));
                                      
                                       //Total income paid from salary
                                       var incomePaidFromSalary = 0;
                                       incomePaidFromSalary= this.getDataAtCell(15, 16);
                                       this.setDataAtCell(45, 6,Math.round(incomePaidFromSalary));
                                     
                                       // IncomeTaxDue
                                       
                                       var incomeTax =  (TaxOnIncome + SurCharge + EducationCess)- incomePaidFromSalary;
                                       this.setDataAtCell(45, 6,Math.round(incomeTax));
                                       this.setDataAtCell(47, 6,Math.round(incomeTax));
                                       
                                       // Remaining month in year
                                      
                                       this.setDataAtCell(48, 6,$scope.totalcount);
                                       
                                       var taxperMonth= Math.round(incomeTax/$scope.totalcount);
                                     
                                       this.setDataAtCell(49, 6,taxperMonth);
                                       
                                       // to set 0
                                       
                                       if( netTaxableIncome == 0)
                                           {
                                           this.setDataAtCell(41, 6, 0);
                                           this.setDataAtCell(42, 6,0);
                                           this.setDataAtCell(43, 6,0);
                                           this.setDataAtCell(44, 6,0);
                                           this.setDataAtCell(46, 6,0);
                                           
                                           
                                           }
                    },
                                 
                    cell: [
                           {row: 24, col: 0, className: "htLeft"},
                           {row: 25, col: 0, className: "htLeft"},
                           {row: 26, col: 0, className: "htLeft"},
                           {row: 27, col: 0, className: "htLeft"},
                           {row: 28, col: 0, className: "htLeft"},
                           {row: 29, col: 0, className: "htLeft"},
                           {row: 30, col: 0, className: "htLeft"},
                           {row: 31, col: 0, className: "htLeft"},
                           {row: 32, col: 0, className: "htLeft"},
                           {row: 33, col: 0, className: "htLeft"},
                           {row: 34, col: 0, className: "htLeft"},
                           {row: 35, col: 0, className: "htLeft"},
                           {row: 36, col: 0, className: "htLeft"},
                           {row: 36, col: 3, className: "htLeft"},
                           {row: 36, col: 4, className: "htLeft"},
                           {row: 36, col: 5, className: "htLeft"},
                           {row: 36, col: 6, className: "htLeft"},
                           {row: 36, col: 0, className: "htLeft"},
                           {row: 37, col: 1, className: "htCenter"},
                           {row: 38, col: 1, className: "htCenter"},
                           {row: 39, col: 1, className: "htCenter"},
                           {row: 40, col: 1, className: "htCenter"},
                           {row: 41, col: 0, className: "htLeft"},
                           {row: 42, col: 0, className: "htLeft"},
                           {row: 43, col: 0, className: "htLeft"},
                           {row: 44, col: 0, className: "htLeft"},
                           {row: 45, col: 0, className: "htLeft"},
                           {row: 46, col: 0, className: "htLeft"},
                           {row: 47, col: 0, className: "htLeft"},
                           {row: 48, col: 0, className: "htLeft"},
                           {row: 49, col: 0, className: "htLeft"},
                           {row: 24, col: 8, className: "htLeft"},
                           {row: 25, col: 8, className: "htLeft"},
                           {row: 26, col: 8, className: "htLeft"},
                           {row: 27, col: 8, className: "htLeft"},
                           {row: 28,  col: 8, className: "htLeft"},
                           {row: 29,  col: 8, className: "htLeft"},
                           {row: 30,  col: 8, className: "htLeft"},
                           {row: 31, col: 8, className: "htLeft"},
                           {row: 32,  col: 8, className: "htLeft"},
                           {row: 33,  col: 8, className: "htLeft"},
                           {row: 34,  col: 8, className: "htLeft"},
                           {row: 35,  col: 8, className: "htLeft"},
                           {row: 36, col: 8, className: "htLeft"},
                           {row: 37, col: 8, className: "htLeft"},
                           {row: 38, col: 8, className: "htLeft"},
                           {row: 39, col: 8, className: "htLeft"},
                           {row: 40, col: 8, className: "htLeft"},
                           {row: 41,  col: 8, className: "htLeft"},
                           {row: 42, col: 8, className: "htLeft"},
                           {row: 43,  col: 8, className: "htLeft"},
                           {row: 44,  col: 8, className: "htLeft"},
                           {row: 45,  col: 8, className: "htLeft"},
                           {row: 46,  col: 8, className: "htLeft"},
                           {row: 47,  col: 8, className: "htLeft"},
                           {row: 48,  col: 8, className: "htLeft"},
                           {row: 49,  col: 8, className: "htLeft"},
                           {row: 50,  col: 8, className: "htLeft"},
                           {row: 51,  col: 8, className: "htLeft"},
                           {row: 52,  col: 8, className: "htLeft"},
                           {row: 53,  col: 8, className: "htLeft"},
                           {row: 54,  col: 8, className: "htLeft"},
                           {row: 55,  col: 8, className: "htLeft"},
                           {row: 56,  col: 8, className: "htLeft"},
                           {row: 57,  col: 8, className: "htLeft"},
                           {row: 58,  col: 8, className: "htLeft"},
                           {row: 59,  col: 8, className: "htLeft"},
                           {row: 60,  col: 8, className: "htLeft"},
                           {row: 61,  col: 8, className: "htLeft"}
                         
                         ],
                         
                         
                    globalColumns : [ {
                        data : 'Apr',
                        type : 'numeric',

                    }, {
                        data : 'May',
                        type : 'numeric',

                    }, {
                        data : 'Jun',
                        type : 'numeric',

                    }, {
                        data : 'Jul',
                        type : 'numeric',

                    }, {
                        data : 'Aug',
                        type : 'numeric',

                    }, {
                        data : 'Sep',
                        type : 'numeric',

                    }, {
                        data : 'Oct',
                        type : 'numeric',

                    }, {
                        data : 'Nov',
                        type : 'numeric',

                    }, {
                        data : 'Dec',
                        type : 'numeric',

                    }, {
                        data : 'Jan',
                        type : 'numeric',

                    }, {
                        data : 'Feb',
                        type : 'numeric',

                    }, {
                        data : 'Mar',
                        type : 'numeric',

                    }, {
                        data : 'Total',
                        type : ValueRenderer
                    
                    },
                    {
                        data : 'Perks',
                        type : 'numeric',

                    }, {
                        data : 'Bonus',
                        type : 'numeric',

                    }, {
                        data : 'Gross',
                        type : 'numeric',

                    }, ],
                    cells : function(row, col, prop) {
                        var cellProperties = {};
                        
   
                        
                        for( var i = 25 ; i <= 34  ; i ++)
                        { 
                            if (row === i && col == 6) {
                                cellProperties.renderer = ValueRenderer; // uses function directly
                          }
                            
                        }
                        for( var i = 37 ; i <= 43  ; i ++)
                        { 
                            if (row === i && col == 3) {
                                cellProperties.renderer = ValueRenderer; // uses function directly
                          }
                        }
                           
                            for( var i = 37 ; i <= 43  ; i ++)
                            { 
                                if (row === i && col == 4 ) {
                                    cellProperties.renderer = ValueRenderer; // uses function directly
                              }
                            
                        }
                            for( var i = 37 ; i <= 43  ; i ++)
                            { 
                                if (row === i && col == 5 ) {
                                    cellProperties.renderer = ValueRenderer; // uses function directly
                              }
                            
                        }
                            
                            for( var i = 37 ; i <= 49 ; i ++)
                            { 
                                if (row === i && col == 6 ) {
                                    cellProperties.renderer = ValueRenderer; // uses function directly
                              }
                            
                        }
                        for( var i = 25 ; i <= 61  ; i ++)
                        { 
                            if (row === i && col == 15) {
                                cellProperties.renderer = ValueRenderer; // uses function directly
                          }
                            
                        }
                        for( var i = 25 ; i <= 61 ; i ++)
                        { 
                            if (row === i && col == 16) {
                                cellProperties.renderer = ValueRenderer; // uses function directly
                          }
                            
                        }

                       for( var i = 0 ; i < 22 ; i ++)
                           {                         
                        if (row === i && col == 13) {
                              cellProperties.renderer = ValueRenderer; // uses function directly
                        }
                        
                        if (row === i && col == 16) {
                            cellProperties.renderer = ValueRenderer; // uses function directly
                      }
                           }
                       for( var i = 0 ; i < 50 ; i ++)
                           {
                        if (row === i && col == 0) {
                            cellProperties.renderer = boldRenderer; // uses function directly
                      }                  
                           }
                       
                       for( var i = 37 ; i < 41 ; i ++)
                       {
                    if (row === i && col == 2) {
                        cellProperties.renderer = boldRenderer; // uses function directly
                  }                  
                       }
                       
                       for( var i = 37 ; i < 41 ; i ++)
                       {
                    if (row === i && col == 1) {
                        cellProperties.renderer = boldRenderer; // uses function directly
                  }                  
                       }
                       
                       for( var i = 25 ; i <=31 ; i ++)
                       {
                    if (row === i && col == 8) {
                        cellProperties.renderer = sideRenderer; // uses function directly
                  }              
                       }
                       for( var i = 34 ; i <= 38 ; i ++)
                       {
                    if (row === i && col == 8) {
                        cellProperties.renderer = sideRenderer; // uses function directly
                  }              
                       }
                       
                       
                       for( var i = 39; i <= 49 ; i ++)
                       {
                    if (row === i && col == 8) {
                        cellProperties.renderer = sideRenderer; // uses function directly
                  }              
                       }
                       
                       
                       for( var i = 50; i <= 60 ; i ++)
                       {
                    if (row === i && col == 8) {
                        cellProperties.renderer = sideRenderer; // uses function directly
                  }              
                       }
                       
                       if (row === 33 && col == 8 || row === 48 && col == 8 ||row === 60 && col == 8) {
                           cellProperties.renderer = boldRenderer; // uses function directly
                     }
                       
                       if (row === 24 && col == 0 || row === 24 && col == 8  || row === 36 && col == 0 || row === 36 && col == 3 || row === 36 && col == 4 || row === 36 
                               && col == 5 || row == 36 && col == 6 || row == 33 && col == 8  || row == 38 && col == 8 ||  row == 24 && col == 16
                               ||  row == 24 && col == 16 ||  row == 33 && col == 15 ||  row == 33 && col == 16 || row == 38 && col == 15 ||  
                               row == 38 && col == 16|| row == 50 && col == 16 || row == 50 && col == 15 || row == 50 && col == 8 || row == 24 && col == 15 )  
                       {
                           cellProperties.renderer = redRenderer; // uses function directly
                           }
                       
                       
                       if (row === 11 && col == 13 ||row === 11 && col == 16 ||row === 34 && col == 6 ||row === 31 && col == 15 ||
                               row === 31 && col == 16 ||row === 48 && col == 15||row === 60 && col == 15 ||row === 48 && col == 16||row === 60 && col == 16)  
                       {
                           cellProperties.renderer = pinkRenderer; // uses function directly
                           }

                        return cellProperties;
                    },
        /*            afterChange : function(change, source) {

                        if (source === 'loadData') {
                            return;
                        } else {
                            if (tdsHandson != undefined) {
                                // console.log("on chanage");
                                var rownum = change[0][0];
                             //   var rlen = tdsHandson.countRows();
                                console.log(count++);
                               var fullcal = 0; var grossAmt = 0;
                                if (rownum < 10 && change[0][1] == 1 || change[0][1] == 2 || change[0][1] == 3 || change[0][1] == 4 || change[0][1] == 5 || change[0][1] == 6 || change[0][1] == 7 || change[0][1] == 8 || change[0][1] == 9 || change[0][1] == 10 || change[0][1] == 11 || change[0][1] == 12 || change[0][1] == 'perks' || change[0][1] == 'bonus') {
                                    var i = rownum;
                                   for (var i = 0; i <=11   ; i++) {
                                     //  console.log("inside loop");
                                        var pf = (tdsHandson.getDataAtRowProp(i, 0) == null) ? 0 : tdsHandson.getDataAtRowProp(i, 0);
                                        var apl = (tdsHandson.getDataAtRowProp(i, 1) == null) ? 0 : tdsHandson.getDataAtRowProp(i, 1);
                                        var may = (tdsHandson.getDataAtRowProp(i, 2) == null) ? 0 : tdsHandson.getDataAtRowProp(i, 2);
                                        var jun = (tdsHandson.getDataAtRowProp(i, 3) == null) ? 0 : tdsHandson.getDataAtRowProp(i, 3);
                                        var july = (tdsHandson.getDataAtRowProp(i, 4) == null) ? 0 : tdsHandson.getDataAtRowProp(i, 4);
                                        var aug = (tdsHandson.getDataAtRowProp(i, 5) == null) ? 0 : tdsHandson.getDataAtRowProp(i, 5);
                                        var sep = (tdsHandson.getDataAtRowProp(i, 6) == null) ? 0 : tdsHandson.getDataAtRowProp(i, 6);
                                        var oct = (tdsHandson.getDataAtRowProp(i, 7) == null) ? 0 : tdsHandson.getDataAtRowProp(i, 7);
                                        var nov = (tdsHandson.getDataAtRowProp(i, 8) == null) ? 0 : tdsHandson.getDataAtRowProp(i, 8);
                                        var dec = (tdsHandson.getDataAtRowProp(i, 9) == null) ? 0 : tdsHandson.getDataAtRowProp(i, 9);
                                        var janR = (tdsHandson.getDataAtRowProp(i, 10) == null) ? 0 : tdsHandson.getDataAtRowProp(i, 10);
                                        var febR = (tdsHandson.getDataAtRowProp(i, 11) == null) ? 0 : tdsHandson.getDataAtRowProp(i, 11);
                                        var marchR = (tdsHandson.getDataAtRowProp(i, 12) == null) ? 0 : tdsHandson.getDataAtRowProp(i, 12);
                                        // var total = (tdsHandson.getDataAtRowProp( i, 13) == null) ? 0 : tdsHandson.getDataAtRowProp( i, 13);
                                        var perks = (tdsHandson.getDataAtRowProp(i, 14) == null) ? 0 : tdsHandson.getDataAtRowProp(i, 14);
                                        var bonus = (tdsHandson.getDataAtRowProp(i, 15) == null) ? 0 : tdsHandson.getDataAtRowProp(i, 15);
                                        var gross = (tdsHandson.getDataAtRowProp(i, 16) == null) ? 0 : tdsHandson.getDataAtRowProp(i, 16);

                                        //if (rownum == i) {
                                            var totalAmt = (isNaN(parseInt(apl)) ? 0 : parseInt(apl)) + (isNaN(parseInt(may)) ? 0 : parseInt(may)) + (isNaN(parseInt(jun)) ? 0 : parseInt(jun)) + (isNaN(parseInt(july)) ? 0 : parseInt(july)) + (isNaN(parseInt(aug)) ? 0 : parseInt(aug)) + (isNaN(parseInt(sep)) ? 0 : parseInt(sep)) + (isNaN(parseInt(oct)) ? 0 : parseInt(oct)) + (isNaN(parseInt(nov)) ? 0 : parseInt(nov)) + (isNaN(parseInt(dec)) ? 0 : parseInt(dec)) + (isNaN(parseInt(janR)) ? 0 : parseInt(janR)) + (isNaN(parseInt(febR)) ? 0 : parseInt(febR) + (isNaN(parseInt(marchR)) ? 0 : parseInt(marchR)));
                                            tdsHandson.setDataAtRowProp(rownum, 13, totalAmt);
                                            var Fgross = (isNaN(parseInt(perks)) ? 0 : parseInt(perks)) + (isNaN(parseInt(bonus)) ? 0 : parseInt(bonus)) + (isNaN(parseInt(apl)) ? 0 : parseInt(apl)) + (isNaN(parseInt(may)) ? 0 : parseInt(may)) + (isNaN(parseInt(jun)) ? 0 : parseInt(jun)) + (isNaN(parseInt(july)) ? 0 : parseInt(july)) + (isNaN(parseInt(aug)) ? 0 : parseInt(aug)) + (isNaN(parseInt(sep)) ? 0 : parseInt(sep)) + (isNaN(parseInt(oct)) ? 0 : parseInt(oct)) + (isNaN(parseInt(nov)) ? 0 : parseInt(nov)) + (isNaN(parseInt(dec)) ? 0 : parseInt(dec)) + (isNaN(parseInt(janR)) ? 0 : parseInt(janR)) + (isNaN(parseInt(febR)) ? 0 : parseInt(febR) + (isNaN(parseInt(marchR)) ? 0 : parseInt(marchR)));
                                            tdsHandson.setDataAtRowProp(rownum, 16, Fgross);

                                      //  }
                                        
                                        fullcal += totalAmt;
                                        grossAmt += Fgross;
                                        tdsHandson.setDataAtRowProp(11, 13, fullcal);
                                        tdsHandson.setDataAtRowProp(11,16,grossAmt);
                                        
                                    }

                               
                                }
                            }

                        }
                    },*/

                    customBorders : [
                          
                          
                                {
                        range : {
                            from : {
                                row : 24,
                                col : 0
                            },
                            to : {
                                row : 34,
                                col : 6
                            }
                        },

                        left : {
                            width : 2,
                            color : 'black'
                        },
                        right : {
                            width : 2,
                            color : 'black'
                        },
                        top : {
                            width : 2,
                            color : 'black'
                        },
                        bottom : {
                            width : 2,
                            color : 'black'
                        }
                    },

                    {
                        range : {
                            from : {
                                row : 36,
                                col : 0
                            },
                            to : {
                                row : 49,
                                col : 6
                            }
                        },

                        left : {
                            width : 2,
                            color : 'black'
                        },
                        right : {
                            width : 2,
                            color : 'black'
                        },
                        top : {
                            width : 2,
                            color : 'black'
                        },
                        bottom : {
                            width : 2,
                            color : 'black'
                        }
                    }, 
                 
                    {
                        range : {
                            from : {
                                row : 24,
                                col : 8
                            },
                            to : {
                                row : 31,
                                col : 16
                            }
                        },

                        left : {
                            width : 2,
                            color : 'black'
                        },
                        right : {
                            width : 2,
                            color : 'black'
                        },
                        top : {
                            width : 2,
                            color : 'black'
                        },
                        bottom : {
                            width : 2,
                            color : 'black'
                        }
                    },  
                    
                    {
                        range : {
                            from : {
                                row : 33,
                                col : 8
                            },
                            to : {
                                row : 36,
                                col : 16
                            }
                        },

                        left : {
                            width : 2,
                            color : 'black'
                        },
                        right : {
                            width : 2,
                            color : 'black'
                        },
                        top : {
                            width : 2,
                            color : 'black'
                        },
                        bottom : {
                            width : 2,
                            color : 'black'
                        }
                    },  

                    
                    {
                        range : {
                            from : {
                                row : 38,
                                col : 8
                            },
                            to : {
                                row : 48,
                                col : 16
                            }
                        },

                        left : {
                            width : 2,
                            color : 'black'
                        },
                        right : {
                            width : 2,
                            color : 'black'
                        },
                        top : {
                            width : 2,
                            color : 'black'
                        },
                        bottom : {
                            width : 2,
                            color : 'black'
                        }
                    }, 
                    
                    {
                        range : {
                            from : {
                                row : 50,
                                col : 8
                            },
                            to : {
                                row : 60,
                                col : 16
                            }
                        },

                        left : {
                            width : 2,
                            color : 'black'
                        },
                        right : {
                            width : 2,
                            color : 'black'
                        },
                        top : {
                            width : 2,
                            color : 'black'
                        },
                        bottom : {
                            width : 2,
                            color : 'black'
                        }
                    }, 

                    ]

                })
             
                $("#result").hide(); 
                document.getElementById("showButton").disabled = false; 
             
            });
     

        }else {
            toaster.pop('error', "Please fill the required fields",
                    logger.getErrorHtmlNew(payrollReportForm.$validationSummary),5000, 'trustedHtml');
        }
        }
        
/*        $scope.callHandson()
        {
            
           
             $("#handsonGrid").handsontable('clear'); 
        }*/
        
    });


