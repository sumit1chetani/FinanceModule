define([ 'payroll/tds/tds' ], function(module) {
'use strict';
module.registerController('employeetaxCtrl', function($scope,$state,$http,ngDialog, logger,$location,$controller,$injector, sharedProperties, toaster,$rootScope,validationService)  {
     
        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.departmentList=[];
        $scope.employeeList=[];
        $scope.isDelete=true;
        $scope.isUpload=true;
        $scope.empTaxParam = {
                companyId:'',
                branchId:'',
                departmentId:'',
                employeeId:'',
                companyName:'',
                branchName:'',
                isShowList:false,
                isOnLoad : false
               
         };
        
        $scope.isAuthorized=false;
        $scope.empTaxParam.isShowList=false;
        
        var employeeId = $location.search().employeeId;
        var departmentId = $location.search().departmentId;
        departmentId=Number(departmentId);
        var companyId= $location.search().companyId;
        var branchId =  $location.search().branchId;
        
        
        $scope.getCompanyList = function(){
            
            $http.get("payroll/payroll/payrollgeneration/getCompanyList").success(function(datas) {
                  console.log("getCompanyList");
                  $scope.companyList = datas.companyList;
                  console.log(datas);
              })
        }
        
        $scope.getBranchList = function(companyId,branchID){
            $http.post("payroll/payroll/payrollgeneration/getBranchList",companyId).success(function(datas) {
                    console.log("getBranchList");
                    $scope.branchList = datas.branchList;
                    console.log(branchID);
                    $scope.empTaxParam.branchId=branchID;
                    console.log($scope.branchList);
                })
          }
        
        

        $scope.getDepartment = function(branchId){
            console.log("branchID");
           $http.post("payroll/payroll/payrollgeneration/getDepartmentList",branchId).success(function(datas) {
                  console.log("LoginUseDepartmentList");
                  console.log(datas);
                  $scope.departmentList = datas.departmentList;
           })
        }
        

        $scope.getEmployeeDetails = function(){
            
            $http.get("payroll/payroll/payrollgeneration/getUserDetail").success(function(datas) {
                
                console.log("LoginUser");
                console.log(datas);
                $scope.getCompanyList();
                $scope.empTaxParam.isOnLoad = true;
                $scope.empTaxParam.companyId=datas.companyId;
                $scope.empTaxParam.companyName=datas.companyName;
                $scope.empTaxParam.branchId=datas.branchId;
                $scope.empTaxParam.branchName=datas.branchName;
                //$scope.getBranchList($scope.tdsDeclarationList.companyId,datas.branchId);
                $scope.empTaxParam.branchName=datas.branchName;
                $scope.getDepartment(datas.branchId);
                
               /* console.log("LoginUser");
                console.log(datas);
                $scope.getCompanyList();
                if(companyId==undefined || companyId=='' || companyId==null){
                    $scope.empTaxParam.companyId=datas.companyId;
                    $scope.empTaxParam.companyName=datas.companyName;
                    $scope.getBranchList($scope.empTaxParam.companyId,datas.branchId);
                }else{
                    var branchnewId;
                    if(branchId==undefined || branchId=='' || branchId==null){
                        $scope.empTaxParam.branchId=datas.branchId;
                        $scope.empTaxParam.branchName=datas.branchName;
                    }else{
                        branchnewId=branchId
                    }
                    $scope.empTaxParam.companyId=companyId;
                   
                    $scope.getBranchList(companyId,branchnewId);
                    $scope.getDepartment(branchnewId);
                }if(branchId==undefined || branchId==''|| branchId==null){
                    $scope.getDepartment(datas.branchId);
                   // $scope.empTaxParam.branchId=datas.branchId;
                }else{
                    $scope.getDepartment(branchId);
                    //$scope.empTaxParam.branchId=branchId;
                }*/
           })
        }
        
        $scope.getEmployeeDetails();
        
        $scope.getEmployeeList = function(departmentId){
            $scope.empTaxParam.departmentId=departmentId;
            $scope.rowCollection=[];
            console.log("Department ID:"+departmentId);
            console.log("Branch ID:"+$scope.empTaxParam.branchId);
            var resultBean={
                    branchId:$scope.empTaxParam.branchId,
                    departmentId:departmentId
                    };
            $http.post("payroll/payroll/payrollgeneration/getEmployeeList",resultBean).success(function(datas) {
                  console.log("LoginUseEmployeeList");
                  $scope.employeeList = datas.employeeList;
                  console.log(datas);
              })
        }
        
        $scope.$watch('empTaxParam.departmentId', function(newValue, oldValue) {
            var departmentId = newValue;
            var branchId =  $scope.empTaxParam.branchId;
            console.log("Department ID:"+departmentId);
            console.log("Branch ID:"+branchId);
            var resultBean={
                    branchId:branchId,
                    departmentId:departmentId
                    };
            $http.post("payroll/payroll/payrollgeneration/getEmployeeList",resultBean).success(function(datas) {
                  console.log("LoginUseEmployeeList");
                  $scope.employeeList = datas.employeeList;
                  $scope.empTaxParam.employeeId='';
                  console.log(datas);
              })
         
        });  
        
        $scope.getBranchChange = function(companyId,branchID){
            $http.post("payroll/payroll/payrollgeneration/getBranchList",companyId).success(function(datas) {
                    console.log("getBranchList");
                    $scope.branchList = datas.branchList;
                    $scope.rowCollection=[];
                    console.log(branchID);
                    $scope.empTaxParam.branchId=branchID;
                    console.log($scope.branchList);
                    $scope.departmentList=[];
                    $scope.employeeList=[];
                })
          }
        
        $scope.$watch('empTaxParam.companyId', function(newValue, oldValue) {
            var companyId = newValue;
            
            if($scope.empTaxParam.companyId != '' && $scope.empTaxParam.isOnLoad == false){
                $scope.empTaxParam.branchId='';
                $scope.empTaxParam.branchName='';
            }
              
            $http.post("payroll/payroll/payrollgeneration/getBranchList",companyId).success(function(datas) {
                    console.log("getBranchList");
                    console.log(datas.branchList)
                    $scope.empTaxParam.isOnLoad=false;
                    $scope.branchList = datas.branchList;
                    if(datas.branchList.length == 1){
                        $scope.empTaxParam.branchId=datas.branchList[0].branchId;
                        $scope.empTaxParam.branchName=datas.branchList[0].branchName;
                    }
                    $scope.empTaxParam.departmentId='';
                    $scope.departmentList=[];
                    $scope.employeeList=[];
                    console.log($scope.branchList);
                })
            
          });
        
        $scope.getDepartmentChange = function(branchId){
            console.log("branchID");
           $http.post("payroll/payroll/payrollgeneration/getDepartmentList",branchId).success(function(datas) {
                  console.log("LoginUseDepartmentList");
                  $scope.rowCollection=[];
                  console.log(datas);
                  $scope.departmentList = datas.departmentList;
                  $scope.empTaxParam.departmentId='';
                  $scope.employeeList=[];
           })
        }
        
        $scope.$watch('empTaxParam.branchId', function(newValue, oldValue) {
            var branchId = newValue;
            $http.post("payroll/payroll/payrollgeneration/getDepartmentList",branchId).success(function(datas) {
                   console.log("LoginUseDepartmentList");
                   console.log(datas);
                   $scope.departmentList = datas.departmentList;
                   $scope.empTaxParam.departmentId='';
                   $scope.employeeList=[];
            })
         
        });
        
        
        $scope.getEmployeeChange = function(departmentId){
            $scope.empTaxParam.departmentId=departmentId;
            $scope.rowCollection=[];
            console.log("Department ID:"+departmentId);
            console.log("Branch ID:"+$scope.empTaxParam.branchId);
            var resultBean={
                    branchId:$scope.empTaxParam.branchId,
                    departmentId:departmentId
                    };
            $http.post("payroll/payroll/payrollgeneration/getEmployeeList",resultBean).success(function(datas) {
                  console.log("LoginUseEmployeeList");
                  $scope.employeeList = datas.employeeList;
                 $scope.empTaxParam.employeeId='';
                  console.log(datas);
              })
        }
        
            $scope.getList = function(reimbursememtReqAddForm){
                if (new validationService().checkFormValidity(reimbursememtReqAddForm)) {
                $scope.empTaxParam.isShowList=true;
                var companyId =$scope.empTaxParam.companyId;
                var branchId = $scope.empTaxParam.branchId;
                var departmentId = $scope.empTaxParam.departmentId;
                if(departmentId==''){
                    departmentId=null;   
                }
                var employeeId = $scope.empTaxParam.employeeId;
                if(employeeId==''){
                    employeeId=null;   
                }
                var resultBean={
                        companyId:companyId,
                        branchId:branchId,
                        departmentId:departmentId,
                        employeeId:employeeId
                }
                console.log("Dept ID:"+departmentId);
                console.log("Emp ID:"+employeeId);
            $http.post("payroll/tds/employeeTaxParameter/list",resultBean)
            .success(function(response) {
                console.log("test");
                console.log(response);
                $scope.rowCollection =response.employeeTaxParameterList;

            });
        }else {
            toaster.pop('error', "Please fill the required fields",
                    logger.getErrorHtmlNew(reimbursememtReqAddForm.$validationSummary),5000, 'trustedHtml');
        }
            }

        
        $scope.add=function(){
            var companyId = $scope.empTaxParam.companyId;
            var branchId = $scope.empTaxParam.branchId;
            var departmentId = $scope.empTaxParam.departmentId;
            var employeeId=$scope.empTaxParam.employeeId;
            if(employeeId!=undefined && employeeId!=''){
                console.log("Coming inside Add Employee ID");
                $http.post("payroll/tds/employeeTaxParameter/edit", employeeId).success(function(response) {
                    
                    if(response.employeeTaxParameter!=null){
                        $location.url('/payroll/employeetax/edit?employeeId=' + employeeId);   
                    }else{
                        $location.url('/payroll/employeetax/add?departmentId=' + departmentId + '&employeeId=' + employeeId+ '&companyId=' + companyId+ '&branchId=' + branchId);
                    }
                }); 
                
            }else{
                $location.url('/payroll/employeetax/add?departmentId=' + departmentId + '&employeeId=' + employeeId+ '&companyId=' + companyId+ '&branchId=' + branchId);    
            }
            
            
         };
        
            $scope.editRow = function (employeeId){
                //alert("Hello"+employeeId);
                $location.url('/payroll/employeetax/edit?employeeId=' + employeeId);
              };
       
        $scope.cancel=function(){
            $state.go('app.payroll.tds.employeetax.list');
        };
        
        $scope.deleteRow = function(employeeId) {
            ngDialog.openConfirm().then(function() {
                 $http.post("payroll/tds/employeeTaxParameter/delete",employeeId)
                 .success(function(response) {
                     //console.log("result is");
                     console.log(response);
                    if(response == true){
                        logger.logSuccess("Deleted Successfully!");
                        $scope.getList();
                    }
                 }).error(function(result) {
                     logger.logError("Error Please Try Again");
                 });
             });
         };
    })
    
});