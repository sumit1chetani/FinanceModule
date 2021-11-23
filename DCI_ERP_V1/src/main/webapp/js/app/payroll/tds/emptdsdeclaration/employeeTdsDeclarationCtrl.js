define([ 'payroll/tds/tds' ], function(module) {
'use strict';

module.registerController('employeeTdsDeclarationCtrl', function($scope,$state,$http,ngDialog, logger,$location,$controller,$injector, sharedProperties, toaster,$rootScope,validationService)  {

    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.isEdit = false;
    $scope.isDisplay= true;
    
    $scope.tdsDeclarationList = {
            departmentId:'',
            companyId:'',
            companyName:'',
            branchName:'',
            departmentName:'',
            branchId:'',
            employeeId:'',
            financialYear:'',
            filepathUrl:'',
            taxSectionCode:'',
            isEdit:false,
            isOnLoad : false
     };
    
    
     $scope.getCompanyList = function(){
        
        $http.get("payroll/payroll/payrollgeneration/getCompanyList").success(function(datas) {
              console.log("getCompanyList");
              $scope.companyList = datas.companyList;
              console.log(datas);
          })
    }
    
     
     $scope.$watch('tdsDeclarationList.companyId', function(newValue, oldValue) {
         var companyId = newValue;
         if($scope.tdsDeclarationList.companyId != '' && $scope.tdsDeclarationList.isOnLoad == false){
             $scope.tdsDeclarationList.branchId='';
             $scope.tdsDeclarationList.branchName='';
         }
         $http.post("payroll/payroll/payrollgeneration/getBranchList",companyId).success(function(datas) {
                 console.log("getBranchList");
                 $scope.tdsDeclarationList.isOnLoad=false;
                 $scope.branchList = datas.branchList;
                 if($scope.branchList.length==1){
                     $scope.tdsDeclarationList.branchId=$scope.branchList[0].branchId;
                     $scope.tdsDeclarationList.branchName=$scope.branchList[0].branchName;
                 }
                 $scope.tdsDeclarationList.departmentId='';
                 $scope.departmentList=[];
                 $scope.employeeList=[];
                 console.log($scope.branchList);
             })
     
     });
     
     
    $scope.getBranchList = function(companyId,branchID){
        $http.post("payroll/payroll/payrollgeneration/getBranchList",companyId).success(function(datas) {
                console.log("getBranchList");
                $scope.branchList = datas.branchList;
                console.log(branchID);
                $scope.tdsDeclarationList.branchId=branchID;
                $scope.departmentList=[];
                $scope.employeeList=[];
                console.log($scope.branchList);
            })
      }
   

    $scope.$watch('tdsDeclarationList.companyId', function(newValue, oldValue) {
        var companyId = newValue;
        
        if($scope.tdsDeclarationList.companyId != '' && $scope.tdsDeclarationList.isOnLoad == false)
            $scope.tdsDeclarationList.branchId='';
        $http.post("payroll/payroll/payrollgeneration/getBranchList",companyId).success(function(datas) {
                console.log("getBranchList");
                console.log(datas.branchList)
                $scope.tdsDeclarationList.isOnLoad=false;
                $scope.branchList = datas.branchList;
                if(datas.branchList.length == 1){
                    $scope.tdsDeclarationList.branchId=datas.branchList[0].branchId;
                }
                $scope.tdsDeclarationList.departmentId='';
                $scope.departmentList=[];
                $scope.employeeList=[];
                console.log($scope.branchList);
            })
        
      });
  

    
    $scope.$watch('tdsDeclarationList.branchId', function(newValue, oldValue) {
        var branchId = newValue;
        $http.post("payroll/payroll/payrollgeneration/getDepartmentList",branchId).success(function(datas) {
               console.log("LoginUseDepartmentList");
               console.log(datas);
               $scope.departmentList = datas.departmentList;
               $scope.tdsDeclarationList.departmentId='';
               $scope.employeeList=[];
        })
     
    });
    

    $scope.getDepartment = function(branchId){
        console.log("branchID"+branchId);
       $http.post("payroll/payroll/payrollgeneration/getDepartmentList",branchId).success(function(datas) {
              console.log("LoginUseDepartmentList");
              console.log(datas);
              $scope.departmentList = datas.departmentList;
              $scope.tdsDeclarationList.departmentId='';
              $scope.employeeList=[];
       })
    }
    
    $scope.$watch('tdsDeclarationList.branchId', function(newValue, oldValue) {
        var branchId = newValue;
        $http.post("payroll/payroll/payrollgeneration/getDepartmentList",branchId).success(function(datas) {
               console.log("LoginUseDepartmentList");
               $scope.departmentList = datas.departmentList;
               $scope.tdsDeclarationList.departmentId='';
               $scope.employeeList=[];
        })
     
    });
  
    $scope.getEmployeeDetails = function(){
        
        $http.get("payroll/payroll/payrollgeneration/getUserDetail").success(function(datas) {
              console.log("LoginUser");
              console.log(datas);
              $scope.getCompanyList();
              $scope.tdsDeclarationList.isOnLoad = true;
              $scope.tdsDeclarationList.companyId=datas.companyId;
              $scope.tdsDeclarationList.companyName=datas.companyName;
              $scope.tdsDeclarationList.branchId=datas.branchId;
              $scope.tdsDeclarationList.branchName=datas.branchName;
              //$scope.getBranchList($scope.tdsDeclarationList.companyId,datas.branchId);
              $scope.tdsDeclarationList.branchName=datas.branchName;
              $scope.getDepartment(datas.branchId);
              
          })
    }
    
    
    $scope.$watch('tdsDeclarationList.departmentId', function(newValue, oldValue) {
        var departmentId = newValue;
        var branchId =  $scope.tdsDeclarationList.branchId;
        console.log("Department ID:"+departmentId);
        console.log("Branch ID:"+branchId);
        var resultBean={
                branchId:branchId,
                departmentId:departmentId
                };
        $http.post("payroll/payroll/payrollgeneration/getEmployeeList",resultBean).success(function(datas) {
              console.log("LoginUseEmployeeList");
              $scope.employeeList = datas.employeeList;
              $scope.tdsDeclarationList.employeeId='';
              console.log(datas);
          })
     
    });
  
    
    $scope.getTaxSectionList = function(){
        
        $http.get("payroll/tds/taxsection/list").success(function(datas) {
              console.log("gettaxSectionList");
              $scope.taxsectionList = datas.taxsectionList;
              console.log(datas);
          })
    }
    
    $scope.getTaxSectionList();
    
    $scope.getEmployeeList = function(departmentId){
        console.log("Department ID:"+departmentId);
        console.log("Branch ID:"+$scope.tdsDeclarationList.branchId);
        var resultBean={
                branchId:$scope.tdsDeclarationList.branchId,
                departmentId:departmentId
                };
        $http.post("payroll/payroll/payrollgeneration/getEmployeeList",resultBean).success(function(datas) {
              console.log("LoginUseEmployeeList");
              $scope.employeeList = datas.employeeList;
              $scope.tdsDeclarationList.employeeId='';
              console.log(datas);
          })
    }
    
    $scope.$watch('tdsDeclarationList.departmentId', function(newValue, oldValue) {
        var departmentId = newValue;
        var branchId =  $scope.tdsDeclarationList.branchId;
        console.log("Department ID:"+departmentId);
        console.log("Branch ID:"+branchId);
        var resultBean={
                branchId:branchId,
                departmentId:departmentId
                };
        $http.post("payroll/payroll/payrollgeneration/getEmployeeList",resultBean).success(function(datas) {
              console.log("LoginUseEmployeeList");
              $scope.employeeList = datas.employeeList;
              $scope.tdsDeclarationList.employeeId='';
              console.log(datas);
          })
     
    });
    
    $scope.getFinancialYear = function(){
        
        $http.get("payroll/tds/ptslab/getLoginfinancialYear").success(function(datas) {
              console.log("financialYearList");
              console.log(datas);
              $scope.financialYearList = datas.financialYearList;
             
          })
    }
    
    
    $scope.getEmployeeDetails();
    
    $scope.getFinancialYear();
    

    $scope.getTDSDeclarationList=function(empTdsDeclarationForm){
        if (new validationService().checkFormValidity(empTdsDeclarationForm)){

        var employeeId = $scope.tdsDeclarationList.employeeId;
        var financialYearId = $scope.tdsDeclarationList.financialYear;
        var taxSectionCode=$scope.tdsDeclarationList.taxSectionCode;
        var isValid=true;
        var resultBean = {
                employeeId :employeeId,
                financialYearId : financialYearId,
                taxSectionCode:taxSectionCode
            }

        console.log("result bean");
                console.log(resultBean);

        $http.post("payroll/tds/tdsDeclaration/list",resultBean).success(function(response) {
            console.log("Inside List");
            console.log(response.tdsDeclarationList);
         
            if(response.tdsDeclarationList!=null && response.tdsDeclarationList!="" && response.tdsDeclarationList!=undefined){
                angular.forEach(response.tdsDeclarationList, function(value, key) {
                   value.employeeId=$scope.tdsDeclarationList.employeeId;
                   value.financialYearId=$scope.tdsDeclarationList.financialYear;
                   
                 });
                $scope.rowCollection =response.tdsDeclarationList;
                console.log("tdsDeclarationList");
                console.log(response.tdsDeclarationList);
                $scope.tdsDeclarationList.isEdit = true;
               
            }else{
                $scope.tdsDeclarationList.isEdit = false;
                $scope.rowCollection=[];
            }
        });

        }else {
            toaster.pop('error', "Please fill the required fields",
                    logger.getErrorHtmlNew(empTdsDeclarationForm.$validationSummary),5000, 'trustedHtml');
        }

        }
         
        
  // Document Upload
        
        $rootScope.uploadDocFile = function(element){
            $scope.docfile = element.files[0];            
        } 
        $scope.docFileName="";
        $scope.docFilePath="";
        
        $rootScope.uploadDocument =function(taxSubSectionCode,taxSectionCode){
            var docfile=$scope.docfile;
            var fileExtension= docfile.name;
            var currentdate = new Date(); 
            var employeeName =$scope.tdsDeclarationList.employeeId;
            var datetime =  currentdate.getDate() + "_"
            + (currentdate.getMonth()+1)  + "_" 
            + currentdate.getFullYear() + "_"  
            + currentdate.getHours() + "_"  
            + currentdate.getMinutes() + "_" 
            + currentdate.getSeconds();
            var frmData=new FormData();
            frmData.append("file",docfile);
            frmData.append("fileName",$scope.tdsDeclarationList.employeeId+"_"+taxSubSectionCode+"_"+datetime);
            $.ajax({
                type : "POST",
                url : "payroll/tds/tdsDeclaration/uploadDocfile",
                
                data : frmData,
                contentType: false,
                processData: false,
               success:  function(result) {
                   $scope.docFileName=result.docFileName;
                   $scope.docFilePath=result.docPath;
                   if(result.success){
                       angular.forEach($scope.rowCollection, function(value, key) {
                           console.log("value is"+value.taxSubSectionCode);
                           if(value.taxSubSectionCode==taxSubSectionCode){
                                   value.filepathUrl=result.docPath;
                               }
                      });
                       
                       console.log("result is");
                       console.log($scope.rowCollection);
                       logger.logSuccess("Document Uploaded Successfully");
                   }else{
                       logger.logError("Fail to Upload");    
                   }
                   
                }
         });
            
          
        };
      
        
        $scope.getTdsUpdatedList=function(){
            
            if($scope.tdsDeclarationList.employeeId!=undefined && $scope.tdsDeclarationList.employeeId!=null && $scope.tdsDeclarationList.employeeId!='' &&
                    $scope.tdsDeclarationList.taxSectionCode!=undefined && $scope.tdsDeclarationList.taxSectionCode!=null && $scope.tdsDeclarationList.taxSectionCode!='' && 
                    $scope.tdsDeclarationList.financialYear!=undefined && $scope.tdsDeclarationList.financialYear!=null && $scope.tdsDeclarationList.financialYear!=''){
                
                var resultBean = {
                        employeeId : $scope.tdsDeclarationList.employeeId,
                        taxSectionCode : $scope.tdsDeclarationList.taxSectionCode,
                        financialYearId : $scope.tdsDeclarationList.financialYear
                        
                    }
                console.log("after update bean");
                console.log(resultBean);
                $http.post("payroll/tds/tdsDeclaration/list",resultBean).success(function(response) {
                    console.log("Inside List");
                    console.log(response.tdsDeclarationList);
                 
                    if(response.tdsDeclarationList!=null && response.tdsDeclarationList!="" && response.tdsDeclarationList!=undefined){
                        angular.forEach(response.tdsDeclarationList, function(value, key) {
                           value.employeeId=$scope.tdsDeclarationList.employeeId;
                           value.financialYearId=$scope.tdsDeclarationList.financialYear;
                           
                         });
                      
                        $scope.rowCollection =response.tdsDeclarationList;
                        console.log("tdsDeclarationList");
                        console.log(response.tdsDeclarationList);
                        $scope.tdsDeclarationList.isEdit = true;
                       
                    }else{
                        $scope.tdsDeclarationList.isEdit = false;
                        $scope.rowCollection=[];
                    }
                });
                
            }
            
        }
        
        
        
        
        $scope.updateTdsList=function(){
            if($scope.rowCollection.length>0){
              
                angular.forEach($scope.rowCollection, function(value, key) {
                    value.actualAmount=0;
                    value.status=0;
                 });
                
                console.log("rowCollection");
                console.log($scope.rowCollection);
                $http.post("payroll/tds/tdsDeclaration/save", $scope.rowCollection).success(function(result) {
                    if (result == false) {
                    }else{
                        logger.logSuccess("Employee TDS Declaration List Updated successfully");
                        $scope.getTdsUpdatedList();
                        
                    }
                    
                })  
            }
        };
        
        
        
        $scope.updateTdsActualList=function(){
           
            console.log("$scope.rowCollection");
            console.log($scope.rowCollection);
            if($scope.rowCollection.length>0){
                angular.forEach($scope.rowCollection, function(value, key) {
                    value.status=1;
                    
                  });
               
                $http.post("payroll/tds/tdsDeclaration/updateActualList", $scope.rowCollection).success(function(result) {
                    if (result == false) {
                    }else{
                        logger.logSuccess("Employee TDS Actual List Updated successfully");
                        $scope.getTdsUpdatedList();
                    }
                    
                })  
            }
        };
        
    });

    module.registerController('parentCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {
        
        $scope.validateActualAmount = function(actualAmount,limited,index){
            if(actualAmount>limited){
                logger.logError("Actual Amount Should be Lesser than Limited!");
                $scope.rowCollection[$scope.$index].actualAmount=0;
            }
        };
    });


});