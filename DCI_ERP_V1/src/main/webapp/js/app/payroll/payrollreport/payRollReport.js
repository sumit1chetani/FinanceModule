//define([ 'payroll/payroll/payroll' ], function(module) {
'use strict';
	app.controller('payRollReportCtrl', function($stateParams,$scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService,utilsService, $window,$timeout) {
//module.registerController('payRollReportCtrl', function($scope,$state,$http,ngDialog, logger,$location,$controller,$injector, sharedProperties, toaster,$rootScope, validationService)  {
    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.isEdit = false;
    $scope.isDisplay= true;
    $scope.isAuthorized=false;
    
    $scope.payrollreport = {
            payComponentName:'',
            amount:'',
            BASIC:'',
            HRA:'',
            DA:'',
            CONVE:'',
            MEDIC:'',
            PFCOM:'',
            PFSEL:'',
            availleave:'',
            PT:'',
            TDS:'',
            departmentId:'',
            branchId:'',
            companyId:'',
            companyName:'',
            monthYear:'',
            month:'',
            year:'',
            isEdit:false,
            isOnLoad : false
     };
    $scope.payRollList=[];
    $scope.calenderList=[];
    

            var temp = [ {
            id : '01',
            text : 'January'
        }, {
            id : '02',
            text : 'February'
        }, {
            id : '03',
            text : 'March'
        }, {
            id : '04',
            text : 'April'
        }, {
            id : '05',
            text : 'May'
        }, {
            id : '06',
            text : 'June'
        }, {
            id : '07',
            text : 'July'
        }, {
            id : '08',
            text : 'August'
        }, {
            id : '09',
            text : 'September'
        }, {
            id : '10',
            text : 'October'
        }, {
            id : '11',
            text : 'November'
        }, {
            id : '12',
            text : 'December'
        }, ]
     
    
    $scope.monthList = temp;
    
    
    $scope.getCalenderList=function(){
        var today =new Date();
        var month = currentdate.getMonth()+1;
        var year = currentdate.getFullYear();
        var currentMonthYear = month+"-"+year;
        
        
    }
    
    $scope.getCompanyList = function(){
    	$http.get($stateParams.tenantid	+ '/app/usermaster/getCompanyList?formCode='
				+ 'F0383').success(
		function(datas) {  
       //$http.get("payroll/payroll/payrollgeneration/getCompanyList").success(function(datas) {
              console.log("getCompanyList");
              $scope.companyList = datas;
              if ($scope.companyList.length >= 1) {
                  $scope.payrollreport.companyId = $scope.companyList[0].id;
                  $scope.payrollreport.companyName = $scope.companyList[0].companyName;
              }
              console.log(datas);
          })
    }
    
    $scope.getBranchList = function(companyId,branchID){
        $http.post("payroll/payroll/payrollgeneration/getBranchList",companyId).success(function(datas) {
            if(datas.branchList.length==1){
                $scope.branchList = datas.branchList;
                $scope.payrollreport.branchId = datas.branchList[0].branchId;
            }else{
                $scope.branchList = datas.branchList;
                $scope.departmentList=[];
                $scope.employeeList=[];
            }
              
            })
      }
        
        $scope.$watch("payrollreport.companyId", function(newValue, oldValue) {
            var companyId = newValue;
            if($scope.payrollreport.companyId != '' && $scope.payrollreport.isOnLoad == false){
                $scope.payrollreport.branchId='';
                $scope.payrollreport.branchName='';
            }
            $http.post("payroll/payroll/payrollgeneration/getBranchList",companyId).success(function(datas) {
                console.log("getBranchList");
                $scope.payrollreport.isOnLoad=false;
                $scope.branchList = datas.branchList;
                if($scope.branchList.length==1){
                    $scope.payrollreport.branchId=$scope.branchList[0].id;
                    $scope.payrollreport.branchName=$scope.branchList[0].text;
                }
                $scope.payrollreport.departmentId='';
                $scope.departmentList=[];
                $scope.employeeList=[];
                console.log($scope.branchList);
            })
      });
    
        
        $scope.getDepartment = function(branchId){
            $http.post("payroll/payroll/payrollgeneration/getDepartmentList",branchId).success(function(datas) {
                   $scope.departmentList = datas.departmentList;
                   $scope.payrollreport.departmentId='';
                   $scope.employeeList=[];
            })
         }
         
        
      $scope.$watch("payrollreport.branchId", function(newValue, oldValue) {
            var branchId = newValue;
       $http.post("payroll/payroll/payrollgeneration/getDepartmentList",branchId).success(function(datas) {
              console.log("LoginUseDepartmentList");
              console.log(datas);
              $scope.departmentList = datas.departmentList;
              $scope.payrollreport.departmentId='';
              $scope.employeeList=[];
       })
    });
    
    $scope.getEmployeeDetails = function(){
        
        $http.get("payroll/payroll/payrollgeneration/getUserDetail").success(function(datas) {
              console.log("LoginUser");
              console.log(datas);
              $scope.getCompanyList();
              $scope.payrollreport.companyId=datas.companyId;
              $scope.payrollreport.companyName=datas.companyName;
              $scope.payrollreport.branchId=datas.branchId;
              $scope.payrollreport.isOnLoad=true;
              $scope.getBranchList($scope.payrollreport.companyId,datas.branchId);
              $scope.payrollreport.branchName=datas.branchName;
              $scope.getDepartment(datas.branchId);
              
          });
    }
    
    $scope.getEmployeeDetails();
    
    $scope.getPaySlipYearList = function(){
        $http.get("payroll/payroll/payrollgeneration/getPaySlipYearList").success(function(datas) {
              console.log("PayRollYear List");
              $scope.payRollYearList = datas.paySlipYearList;
              console.log(datas);
          })
    }
    
    $scope.fileUpload = function() {
        ngDialog.close();
        ngDialog.open({
            template : 'fileModal',
            scope : $scope
        });
    };
    
    
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
    
    
    $scope.exportExcel = function() { 
         if (new validationService().checkFormValidity($scope.payrollReportForm)){
             var companyId = $scope.payrollreport.companyId;
             var branchId = $scope.payrollreport.branchId;
             var dept = $scope.payrollreport.departmentId;
             var monthYear = $scope.payrollreport.month+$scope.payrollreport.year;
             var isValid=true;
             if(companyId=='' || companyId==undefined){
                 companyId=null;     
             }
             if(branchId=='' || branchId==undefined){
                 branchId=null;      
             }
             if(dept=='' || dept==undefined){
            	 dept=null;  
             } 
             var resultBean = {
                     companyId : companyId,
                     branchId : branchId,
                     dept:dept,
                     monthYear:monthYear
                 }
         
             console.log("exportResultBean");
             console.log(resultBean);
         $http.post('payroll/payroll/payrollreport/exportExcel', resultBean).success(function(data) {
             
             console.log("export report");
             console.log(data);
             if (data.success == true) {
               
                logger.logSuccess("File Exported Successfully");
              //  $('#btnRowDivId').append('<a id="captainMsglink" href="tempdoc/Salary.xls" class="control-label" download="Salary.xls"></a>');
                $("#Export").bind('click', function() {
                });
                $('#Export').simulateClick('click');
             } else {
                
                 logger.logError("Error Please Try Again")
                
               
            
             }
         }).error(function(data) {
         }); 
             
             
            
         
         }else {
             toaster.pop('error', "Please fill the required fields",
                     logger.getErrorHtmlNew($scope.payrollReportForm.$validationSummary),5000, 'trustedHtml');
         }
               
     };
    
    
    $scope.getPaySlipYearList();
    
    $scope.getPayrollList=function(){
        if (new validationService().checkFormValidity($scope.payrollReportForm)) {
        var companyId = $scope.payrollreport.companyId;
        var branchId = $scope.payrollreport.branchId;
        var dept = $scope.payrollreport.departmentId;
        var monthYear = $scope.payrollreport.month+$scope.payrollreport.year;
        var isValid=true;
        if(companyId=='' || companyId==undefined){
            companyId=null;     
        }
        if(branchId=='' || branchId==undefined){
            branchId=null;      
        }
        if(dept=='' || dept==undefined){
        	dept=null;  
        } 
        var resultBean = {
                companyId : companyId,
                branchId : branchId,
                dept:dept,
                monthYear:monthYear
            }
        
        console.log("ResultBean");
        console.log(resultBean);
        
        $http.post("payroll/payroll/payrollreport/list",resultBean).success(function(response) {
          // console.log("Inside List");
            console.log(response.payrollList);
            if(response.payRollList!=null && response.payRollList!="" && response.payRollList!=undefined){
               // console.log("payrollreport");
                console.log(response.payRollList);
                $scope.rowCollection =response.payRollList;
//                angular.forEach($scope.rowCollection, function(value, key) {
//                    value.BASIC = Math.round(value.BASIC);
//                    value.DA = Math.round(value.DA);
//                    value.HRA = Math.round(value.HRA);
//                    value.CONVE = Math.round(value.CONVE);
//                    value.SPL = Math.round(value.SPL);
//                    value.CONS = Math.round(value.CONS);
//                    value.OTEAR = Math.round(value.OTEAR);
//                    value.GROSS = Math.round(value.GROSS);
//                    value.MEDIC = Math.round(value.MEDIC);
//                    value.PFSEL = Math.round(value.PFSEL);
//                    value.WF = Math.round(value.WF);
//                    value.PT = Math.round(value.PT);
//                    value.TDS = Math.round(value.TDS);
//                    value.Tele = Math.round(value.Tele);
//                    value.US = Math.round(value.US);
//                    value.TR1 = Math.round(value.TR1);
//                    value.OTDED = Math.round(value.OTDED);
//                    value.NET = Math.round(value.NET);
//                   
//                });

            }else{
                logger.logError("Payroll List Empty");
                $scope.rowCollection=[];
            }
        }).error(function(data) {
            console.log(datas);
        });
       
        } else {
            toaster.pop('error', "Please fill the required fields", 
                    logger.getErrorHtmlNew($scope.payrollReportForm.$validationSummary), 555000, 'trustedHtml');
        }
        };
       // $scope.getPayrollList(); 
});




