define([ 'payroll/tds/tds' ], function(module) {

    'use strict';
    
    module.registerController('employeeTaxAddCtrl', function($scope,$state,$http,ngDialog, logger,$location,$controller,$injector, sharedProperties, toaster,$rootScope,validationService)  {
        
        $scope.empTaxParam = {
                employeeId:'',
                departmentId:'',
                departmentName:'',
                employeeName:'',
                companyId:'',
                branchId:'',
                companyName:'',
                branchName:'',
                livingInMetro:'',
                selfOccupiedHouse:'',
                taxPayerTypeId:'',
                phType:'',
                isEdit:false,
                isOnLoad : false
               
         };
        
        var temp = [ {
            id : 1,
            text : 'Normal'
        }, {
            id : 2,
            text : 'Physically Handicapped'
        },{
            id : 3,
            text : 'Severe'
        },]
     

        $scope.phTypeList = temp;
        $scope.payerTypeList=[];
        $scope.isEdit = false;
        
      
        $scope.departmentList=[];
        $scope.employeeList=[];
        
        var departmentId = $location.search().departmentId;
        departmentId=Number(departmentId);
        var employeeId = $location.search().employeeId;
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
                  if(companyId==undefined || companyId=='' || companyId==null){
                      $scope.empTaxParam.companyId=datas.companyId;
                      $scope.empTaxParam.companyName=datas.companyName;
                      $scope.getBranchList($scope.empTaxParam.companyId,datas.branchId);
                      $scope.empTaxParam.branchName=datas.branchName;
                  }else{
                      var branchnewId;
                      if(branchId==undefined || branchId=='' || branchId==null){
                          branchnewId=datas.branchId;
                      }else{
                          branchnewId=branchId
                      }
                      $scope.empTaxParam.companyId=companyId;
                     
                      $scope.getBranchList(companyId,branchnewId);
                      $scope.getDepartment(branchnewId);
                  }if(branchId==undefined || branchId==''|| branchId==null){
                      $scope.getDepartment(datas.branchId);
                    
                  }else{
                      $scope.getDepartment(branchId);
                     
                  }
             })
        }
        
        $scope.edit=function(employeeId){
            $http.post("payroll/tds/employeeTaxParameter/edit", employeeId).success(function(response) {
                console.log("Edit Tax Param");
                console.log("PayrollObject"+response.employeeTaxParameter);
                if(response.employeeTaxParameter!=null){
                    console.log("Edit List");
                    $scope.empTaxParam=response.employeeTaxParameter;
                    console.log("Employee Tax Param");
                    $scope.empTaxParam.isEdit = true;
                   // $scope.empTaxParam.taxPayerTypeId=
                    console.log($scope.empTaxParam);
                   
                }else{
                    if($location.search().departmentId!=undefined && $location.search().departmentId!=''){
                        $scope.getEmployeeList($location.search().departmentId);
                        $scope.empTaxParam.employeeId=$location.search().employeeId;
                        $scope.empTaxParam.departmentId=Number($location.search().departmentId);
                        } else{
                            $state.go('app.payroll.tds.employeetax.add');    
                        }
                }
            });    
        }
       
        
        $scope.getEmployeeList = function(departmentId){       
            var branchId =  $scope.empTaxParam.branchId;
            if($scope.empTaxParam.branchId=='' || $scope.empTaxParam.branchId==null || $scope.empTaxParam.branchId==undefined){
                if(branchId=='' || branchId==null || branchId==undefined){
                    branchId= $location.search().branchId;
                } 
            }
            console.log("Department ID:"+departmentId);
            console.log("Branch ID:"+branchId);
            
            var resultBean={
                    branchId:branchId,
                    departmentId:departmentId
                    };
            $http.post("payroll/payroll/payrollgeneration/getEmployeeList",resultBean).success(function(datas) {
                  console.log("LoginUseEmployeeList");
                  $scope.employeeList = datas.employeeList;
                  console.log(datas);
              })
        }
         
        $scope.$watch('empTaxParam.branchId', function(newValue, oldValue) {
            if(departmentId!=undefined){
                var branchId = newValue;
                $http.post("payroll/payroll/payrollgeneration/getDepartmentList",branchId).success(function(datas) {
                       console.log("LoginUseDepartmentList");
                       console.log(datas);
                       $scope.departmentList = datas.departmentList;
                       $scope.empTaxParam.departmentId='';
                       $scope.employeeList=[];
                })
            }
        });
        
        $scope.getPayerTypeList=function(){
            $http.get("payroll/tds/slabrate/payertypelist").success(function(datas) {
              $scope.payerTypeList = datas.payerTypeList;
                console.log("payerTypeList");
                console.log($scope.payerTypeList);
            }).error(function(data) {

            });
        };
        
        $scope.getPayerTypeList();
        
        
        $scope.getBranchChange = function(companyId,branchID){
            $http.post("payroll/payroll/payrollgeneration/getBranchList",companyId).success(function(datas) {
                    console.log("getBranchList");
                    $scope.branchList = datas.branchList;
                    console.log(branchID);
                    $scope.empTaxParam.branchId=branchID;
                    console.log($scope.branchList);
                    $scope.departmentList=[];
                    $scope.employeeList=[];
                })
          }
        
        $scope.$watch('empTaxParam.companyId', function(newValue, oldValue) {
            var companyId = newValue;
            if(branchId!=undefined){
           
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
                    }
                    $scope.empTaxParam.departmentId='';
                    $scope.departmentList=[];
                    $scope.employeeList=[];
                   
                })
            }
          });
        
        $scope.getDepartmentChange = function(branchId){
            console.log("branchID");
           $http.post("payroll/payroll/payrollgeneration/getDepartmentList",branchId).success(function(datas) {
                  console.log("LoginUseDepartmentList");
                  console.log(datas);
                  $scope.departmentList = datas.departmentList;
                  $scope.empTaxParam.departmentId='';
                  $scope.employeeList=[];
           })
        }
        
        
        
        $scope.getEmployeeChange = function(departmentId){
            $scope.empTaxParam.departmentId=departmentId;
            $scope.rowCollection=[];
            var branchId =  $scope.empTaxParam.branchId;
            if($scope.empTaxParam.branchId=='' || $scope.empTaxParam.branchId==null || $scope.empTaxParam.branchId==undefined){
                if(branchId=='' || branchId==null || branchId==undefined){
                    branchId= $location.search().branchId;
                } 
            }
            console.log("Department ID1:"+departmentId);
            console.log("Branch ID1:"+branchId);
            var resultBean={
                    branchId:branchId,
                    departmentId:departmentId
                    };
            $http.post("payroll/payroll/payrollgeneration/getEmployeeList",resultBean).success(function(datas) {
                  console.log("LoginUseEmployeeList11111");
                 $scope.employeeList = datas.employeeList;
                 $scope.empTaxParam.employeeId='';
                  console.log(datas);
              })
        }
        
        $scope.$watch('empTaxParam.departmentId', function(newValue, oldValue) {
            if(employeeId!=undefined){
                var departmentId = newValue;
                $scope.empTaxParam.departmentId=departmentId;
                $scope.rowCollection=[];
                var branchId =  $scope.empTaxParam.branchId;
                if($scope.empTaxParam.branchId=='' || $scope.empTaxParam.branchId==null || $scope.empTaxParam.branchId==undefined){
                    if(branchId=='' || branchId==null || branchId==undefined){
                        branchId= $location.search().branchId;
                    } 
                }
                console.log("Department ID:"+departmentId);
                console.log("Branch ID:"+branchId);
                var resultBean={
                        branchId:branchId,
                        departmentId:departmentId
                        };
                $http.post("payroll/payroll/payrollgeneration/getEmployeeList",resultBean).success(function(datas) {
                    console.log("LoginUseEmployeeList11111");
                   $scope.employeeList = datas.employeeList;
                   $scope.empTaxParam.employeeId='';
                    console.log(datas);
                })
            }
        });  
        
        $scope.getEmployeeDetails();
      
        
        
        
        
        var employeeId = $location.search().employeeId;
        var departmentId=$location.search().departmentId;
        
        console.log("EMPloyee ID:"+employeeId);
        if (employeeId != undefined && employeeId!='') {
            
            $scope.edit(employeeId); 
        } else {
            console.log("Coming inside Else");
              
        }
        
        
        if($location.search().employeeId!=undefined && $location.search().departmentId!=undefined && $location.search().employeeId!='' && $location.search().departmentId!=''){
            console.log("Coming Inside Add Details");
           // $scope.getEmployeeDetails();
            
            $scope.empTaxParam.employeeId=$location.search().employeeId;
            $scope.empTaxParam.departmentId=Number($location.search().departmentId);
        } 
        
        
        $scope.submit=function(empTaxParamForm){
           if (new validationService().checkFormValidity(empTaxParamForm)) {
            if($scope.empTaxParam.isEdit !=true){
                var saveData = {
                        employeeId:$scope.empTaxParam.employeeId,
                        departmentId:$scope.empTaxParam.departmentId,
                        livingInMetro:$scope.empTaxParam.livingInMetro,
                        selfOccupiedHouse:$scope.empTaxParam.selfOccupiedHouse,
                        taxPayerTypeId:$scope.empTaxParam.taxPayerTypeId,
                        phType:$scope.empTaxParam.phType
                        };
              
                $http.post("payroll/tds/employeeTaxParameter/save", saveData).success(function(result) {
                    if (result == false) {
                        logger.logError("Sorry Some Error occurred"); 
                    }else{
                        logger.logSuccess("Employee Tax Parameter added successfully");
                       $state.go('app.payroll.tds.employeetax.list');
                    }
                    
                });
           } 
           }else {
               toaster.pop('error', "Please fill the required fields",
                       logger.getErrorHtmlNew(empTaxParamForm.$validationSummary),5000, 'trustedHtml');
           }
        }
       
       $scope.update = function(empTaxParamForm) {
           if (new validationService().checkFormValidity(empTaxParamForm)) {
               var employeeId = $location.search().employeeId;
           var updateBean = {
                   employeeId:employeeId,
                   departmentId:$scope.empTaxParam.departmentId,
                   livingInMetro:$scope.empTaxParam.livingInMetro,
                   selfOccupiedHouse:$scope.empTaxParam.selfOccupiedHouse,
                   taxPayerTypeId:$scope.empTaxParam.taxPayerTypeId,
                   phType:$scope.empTaxParam.phType
                   };
              console.log("updatebean");
              console.log(updateBean);
               $http.post('payroll/tds/employeeTaxParameter/save', updateBean).success(function(result) {
                   if (result == false) {
                       logger.logError("Sorry Some Error occurred"); 
                   } else {
                       logger.logSuccess("Employee Tax Parameters updated successfully");
                       $state.go('app.payroll.tds.employeetax.list');
                   }
               });
           
         }else {
             toaster.pop('error', "Please fill the required fields",
                     logger.getErrorHtmlNew(empTaxParamForm.$validationSummary),5000, 'trustedHtml');
         }
       }
     
        $scope.cancel=function(){
            $state.go('app.payroll.tds.employeetax.list');
        };
    });     
});