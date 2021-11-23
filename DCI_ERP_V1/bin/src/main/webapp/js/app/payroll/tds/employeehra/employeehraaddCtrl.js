define([ 'payroll/tds/tds'], function(module) {

    'use strict';
    
    module.registerController('employeehraaddCtrl', function($scope,$state,$http,ngDialog, logger,$location,$controller,$injector, sharedProperties, toaster,$rootScope,validationService)  {
       
        $scope.employeehra = {
                departmentId:'',
                branchId:'',
                companyId:'',
                companyName:'',
                branchName:'',
                employeeId:'',
                employeeName:'',
                rentPaid:'',
                hraStatus:'',
                monthYear:'',
                month:'',
                financialYear:'',
                departmentName:'',
                joinDocUpload:'',
                isOnLoad : false,
                isEdit:false
        };
        
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
    
        
        var employeeId = $location.search().employeeId;
        var monthYear= $location.search().monthYear;
        if (employeeId == undefined) {
            $scope.employeehra.isEdit = false;
        } else {
            $scope.employeehra.isEdit=true;
             console.log("Coming inside else function");
             var resultbean={
                     employeeId:employeeId,
                     monthYear:monthYear
             }
             console.log("resultbean");
             console.log(resultbean);
            $http.post('payroll/tds/employeeHraReceipts/edit', resultbean).success(function(result) {
                    console.log("Resultant Value");
                    console.log(result);
                    $scope.employeehra.branchName=result.branchName;
                    $scope.employeehra.employeeName=result.employeeName;
                    $scope.employeehra.departmentName=result.departmentName;
                    $scope.employeehra.companyName=result.companyName;
                    $scope.employeehra.employeeId=result.employeeId;
                    $scope.employeehra.rentPaid=result.rentPaid;
                    $scope.employeehra.joinDocUpload=result.fileName;
                    var month = result.monthYear.substring(0,2);
                    var financialyear = result.monthYear.substring(2, result.monthYear.length);
                    var nextyear = financialyear.substring(2, result.monthYear.length);
                    nextyear=Number(nextyear)+1;
                    var newVal = financialyear+"-"+nextyear;
                    $scope.employeehra.monthYear=newVal;
                    $scope.employeehra.month=month;
                    console.log("final");
                    console.log($scope.employeehra);
                   
            }).error(function(data) {

            });
        }
        
        $scope.getCompanyList = function(){
            
            $http.get("payroll/payroll/payrollgeneration/getCompanyList").success(function(datas) {
                  console.log("getCompanyList");
                  $scope.companyList = datas.companyList;
                  console.log(datas);
              })
        }
        
        
        
        $scope.$watch('employeehra.companyId', function(newValue, oldValue) {
            if(!$scope.employeehra.isEdit){
            var companyId = newValue;
            if($scope.employeehra.companyId != '' && $scope.employeehra.isOnLoad == false){
                $scope.employeehra.branchId='';
                $scope.employeehra.branchName='';
            }
                
            $http.post("payroll/payroll/payrollgeneration/getBranchList",companyId).success(function(datas) {
                    console.log("insidebranchwatch");
                    $scope.employeehra.isOnLoad=false;
                    $scope.branchList = datas.branchList;
                    if($scope.branchList.length==1){
                        $scope.employeehra.branchId=$scope.branchList[0].branchId;
                        $scope.employeehra.branchName=$scope.branchList[0].branchName;
                    }
                    $scope.employeehra.departmentId='';
                    $scope.departmentList=[];
                    console.log($scope.branchList);
                })
            }
        });
        
        $scope.getBranchList = function(companyId,branchID){
            if(!$scope.employeehra.isEdit){
            $http.post("payroll/payroll/payrollgeneration/getBranchList",companyId).success(function(datas) {
                    console.log("getBranchList");
                    $scope.branchList = datas.branchList;
                    console.log(branchID);
                    $scope.employeehra.branchId=branchID;
                    $scope.departmentList=[];
                    $scope.employeeList=[];
                    console.log($scope.branchList);
                })
            }  
          }
       
        $scope.cancel =function(){
            
            $state.go('app.payroll.tds.employeehra.list');
          };
      
          
          $scope.$watch('employeehra.branchId', function(newValue, oldValue) {
             
              if(!$scope.employeehra.isEdit){
              var branchId = newValue;
              $http.post("payroll/payroll/payrollgeneration/getDepartmentList",branchId).success(function(datas) {
                     console.log("insideWatch");
                     console.log(datas);
                     $scope.departmentList = datas.departmentList;
                     $scope.employeehra.departmentId='';
                     $scope.employeeList=[];
              })
              }
          });
          
        $scope.getDepartment = function(branchId){
            if(!$scope.employeehra.isEdit){
            console.log("branchID"+branchId);
           $http.post("payroll/payroll/payrollgeneration/getDepartmentList",branchId).success(function(datas) {
                  console.log("LoginUseDepartmentList");
                  console.log(datas);
                  $scope.departmentList = datas.departmentList;
                  $scope.employeehra.departmentId='';
                  $scope.employeeList=[];
           })
            }
        }
        
         
        $scope.getEmployeeDetails = function(){
            if(!$scope.employeehra.isEdit){
            $http.get("payroll/payroll/payrollgeneration/getUserDetail").success(function(datas) {
                  console.log("LoginUser");
                  console.log(datas);
                  $scope.getCompanyList();
                  $scope.employeehra.companyId=datas.companyId;
                  $scope.employeehra.isOnLoad = true;
                  $scope.employeehra.companyName=datas.companyName;
                  $scope.getBranchList($scope.employeehra.companyId,datas.branchId);
                  $scope.employeehra.branchName=datas.branchName;
                  $scope.getDepartment(datas.branchId);
                  
              })
            }
        }
        
        

        
        $scope.getEmployeeDetails();
        
       
        
        $scope.$watch('employeehra.departmentId', function(newValue, oldValue) {
            if(!$scope.employeehra.isEdit){
            var departmentId = newValue;
            var branchId =  $scope.employeehra.branchId;
            console.log("Department ID:"+departmentId);
            console.log("Branch ID:"+branchId);
            var resultBean={
                    branchId:branchId,
                    departmentId:departmentId
                    };
            $http.post("payroll/payroll/payrollgeneration/getEmployeeList",resultBean).success(function(datas) {
                  console.log("LoginUseEmployeeList");
                  $scope.employeeList = datas.employeeList;
                  $scope.employeehra.employeeId='';
                  console.log(datas);
              })
            }
        });
        
        $scope.getEmployeeList = function(departmentId){
            var branchId =  $scope.employeehra.branchId;
            if($scope.employeehra.branchId=='' || $scope.employeehra.branchId==null || $scope.employeehra.branchId==undefined){
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
                  $scope.employeehra.employeeId='';
                  console.log(datas);
              })
        }
        
        
        $scope.getFinancialYear = function(){
            
            $http.get("payroll/tds/ptslab/getLoginfinancialYear").success(function(datas) {
                  console.log("financialYearList");
                  console.log(datas);
                  $scope.financialYearList = datas.financialYearList;
                 
              })
        }
        
        $scope.getFinancialYear();
        
        $scope.reset = function(employeehraAddForm) {
            if($scope.employeehra.isEdit !=true){
                $scope.employeehra.employeeId='',
                $scope.employeehra.rentPaid='',
                $scope.employeehra.joinDocUpload='',
                $scope.employeehra.departmentId='',
                $scope.employeehra.financialYear='',
                $scope.employeehra.month=''
            }else{
                $scope.employeehra.employeeId='',
                $scope.employeehra.rentPaid='',
                $scope.employeehra.joinDocUpload='',
                $scope.employeehra.departmentId='',
                $scope.employeehra.financialYear='',
                $scope.employeehra.month=''
                
            }
        }
      
       
        $scope.submit=function(employeehraAddForm){
            if (new validationService().checkFormValidity(employeehraAddForm)){
            if($scope.employeehra.isEdit !=true){
                console.log("save data");
                var branchId = $scope.employeehra.branchId;
                var departmentId = $scope.employeehra.departmentId;
                var employeeId = $scope.employeehra.employeeId;
                var monthYear = $scope.employeehra.financialYear;
                var month =  $scope.employeehra.month;
                monthYear =monthYear.split("-");
                var  currentmonthYear=$scope.employeehra.month+monthYear[0];
                var resultBean={
                        employeeId:$scope.employeehra.employeeId,
                        monthYear:currentmonthYear,
                        hraStatus:"1",
                        rentPaid:$scope.employeehra.rentPaid,
                        fileName:$scope.employeehra.joinDocUpload
                }
                var saveData = resultBean;
                console.log(saveData);
               
                    $http.post("payroll/tds/employeeHraReceipts/save", saveData).success(function(result) {
                        if (result == false) {
                            logger.logError("Employee Id already exist");
                        }else{
                           $state.go('app.payroll.tds.employeehra.list');
                           logger.logSuccess("Employeehra Recepecipt Saved Successfully");
                        }
                        
                    })
            } 
            }else {
                toaster.pop('error', "Please fill the required fields",
                        logger.getErrorHtmlNew(employeehraAddForm.$validationSummary),5000, 'trustedHtml');
            }  
        }
        
     
        // Document Upload
        
        $rootScope.uploadDocFile = function(element){
            $scope.docfile = element.files[0];            
        } 
        $scope.docFileName="";
        $scope.docFilePath="";
        
        $rootScope.uploadDocument =function(){            
            var docfile=$scope.docfile;
            var fileExtension= docfile.name;
            var currentdate = new Date(); 
            var datetime =  currentdate.getDate() + "_"
                            + (currentdate.getMonth()+1)  + "_" 
                            + currentdate.getFullYear() + "_"  
                            + currentdate.getHours() + "_"  
                            + currentdate.getMinutes() + "_" 
                            + currentdate.getSeconds();
            var frmData=new FormData();
            frmData.append("file",docfile);
            frmData.append("fileName",$scope.employeehra.employeeId+"_"+datetime);
            var isValid=true;
            var employeeName=$scope.employeehra.employeeId;
            if(employeeName=="" || employeeName==null || employeeName==undefined){
                isValid=false;
                logger.logError("Employee Name is Required");   
            }
            if(isValid){
            $.ajax({
                type : "POST",
                url : "payroll/tds/employeeHraReceipts/uploadDocfile",
                data : frmData,
                contentType: false,
                processData: false,
               success:  function(result) {
                   console.log("result document");
                   console.log(result);
                   $scope.docFileName=result.docFileName;
                   $scope.docFilePath=result.docPath;
                   $scope.employeehra.joinDocUpload = result.docPath;
                   if(result.success){
                       console.log("result is");
                       console.log( $scope.employeehra);
                       logger.logSuccess("Document Uploaded Successfully");
                   }else{
                       logger.logError("Fail to Upload");    
                   }
                   
                }
         });
            
            } 
        };
        
        
        $scope.update=function(employeehraAddForm){
        if (new validationService().checkFormValidity(employeehraAddForm)){
            if($scope.employeehra.isEdit ==true){
                console.log("update data");
                var monthYear = $scope.employeehra.monthYear;
                monthYear =monthYear.split("-");
                var  currentmonthYear=$scope.employeehra.month+monthYear[0];
                var resultBean={
                        employeeId:$scope.employeehra.employeeId,
                        hraStatus:"1",
                        monthYear:currentmonthYear,
                        rentPaid:$scope.employeehra.rentPaid,
                        fileName:$scope.employeehra.joinDocUpload
                        
                }
                var saveData = resultBean;
                console.log(saveData);
                $http.post("payroll/tds/employeeHraReceipts/update", saveData).success(function(result) {
                    if (result == false) {
                        logger.logError("Employee Id already exist");
                    }else{
                       $state.go('app.payroll.tds.employeehra.list');
                       logger.logSuccess("Employeehra Recepecipt Updated Successfully");
                    }
                    
                })
          }
        }else {
            toaster.pop('error', "Please fill the required fields",
                    logger.getErrorHtmlNew(employeehraAddForm.$validationSummary),5000, 'trustedHtml');
        }  
        }
        
        
       
       
    });
    
    module.registerDirective('phonenumbersOnly', function(logger){
        return {
          require: 'ngModel',
          link: function(scope, element, attrs, modelCtrl) {
             
            modelCtrl.$parsers.push(function (inputValue) {
                var inputValue=modelCtrl.$viewValue;
                if (inputValue == undefined) return '' 
               var transformedInput = inputValue.replace(/[^0-9]/g, ''); 
               if (transformedInput!=inputValue) {
                  modelCtrl.$setViewValue(transformedInput);
                  modelCtrl.$render();
               }else{
                  
               }         
    
               return transformedInput;  
            });
          }
        };
     });

    
})