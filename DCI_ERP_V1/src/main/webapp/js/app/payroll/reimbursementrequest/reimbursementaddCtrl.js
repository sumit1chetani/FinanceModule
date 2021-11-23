define([ 'payroll/payroll/payroll' ], function(module) {
'use strict';
module.registerController('reimbursementaddCtr', function($scope,$state,$http,ngDialog, logger,$location,$controller,$injector, sharedProperties, toaster,$rootScope,validationService)  {

    $scope.reimbursementReq = {
            departmentId:'',
            reimbursementTypeId:'',
            reimbusementName:'',
            currencyName:'',
            currencyCode:'',
            branchId:'',
            companyId:'',
            companyName:'',
            branchName:'',
            employeeId:'',
            employeeName:'',
            paymentMode:'',
            amount:'',
            fileName:'',
            departmentName:'',
            description:'',
            requestedby:'',
            requesteddate:'',
            reimbursementId:'',
            isEdit:false,
            isOnLoad : false
    };
    
    var temp = [ {
        id : 'cash',
        text : 'Cash'
    }, {
        id : 'cheque',
        text : 'Cheque'
    },]
 

    $scope.paymentList = temp;
                  

    
    $scope.isEdit=false;
    var reimbursementId = $location.search().reimbursementId;
    if (reimbursementId == undefined) {
        $scope.reimbursementReq.isEdit = false;
    } else {
        $scope.reimbursementReq.isEdit = true;
        $http.post('payroll/payroll/reimbursementreq/edit', reimbursementId).success(function(result) {
            if (result.isEdit == false) {
                logger.logError("Please Try Again");
            } else {
                
                $scope.reimbursementReq=result;
           }

        }).error(function(data) {

        });
    }
   
    $scope.cancel=function(){
        $state.go('app.payroll.payroll.reimbursementreq.list');
    };
    
    $scope.getCompanyList = function(){
        if(!$scope.reimbursementReq.isEdit){
        $http.get("payroll/payroll/payrollgeneration/getCompanyList").success(function(datas) {
              $scope.companyList = datas.companyList;
              $scope.departmentList=[];
          })
          
        }  
    };

    $scope.$watch('reimbursementReq.companyId', function(newValue, oldValue) {
        if(!$scope.reimbursementReq.isEdit){
        var companyId = newValue;
        
        if($scope.reimbursementReq.companyId != '' && $scope.reimbursementReq.isOnLoad == false)
            $scope.reimbursementReq.branchId='';
            $scope.reimbursementReq.branchName='';
        $http.post("payroll/payroll/payrollgeneration/getBranchList",companyId).success(function(datas) {
                $scope.reimbursementReq.isOnLoad=false;
                $scope.branchList = datas.branchList;
                if(datas.branchList.length == 1){
                    $scope.reimbursementReq.branchId=datas.branchList[0].branchId;
                    $scope.reimbursementReq.branchName=$scope.branchList[0].branchName;
                }
                $scope.reimbursementReq.departmentId='';
                $scope.departmentList=[];
                $scope.employeeList=[];
            })
        }
      });
   
    $scope.getBranchList = function(companyId,bid){
        if(!$scope.reimbursementReq.isEdit){
        $scope.reimbursementReq.branchId=bid;
        $http.post("payroll/payroll/payrollgeneration/getBranchList",companyId).success(function(datas) {
                $scope.branchList = datas.branchList;
                $scope.reimbursementReq.departmentId='';
                $scope.departmentList=[];
                $scope.employeeList=[];
            });
        }
      }
    
  
    $scope.getDepartment = function(branchId){
        if(!$scope.reimbursementReq.isEdit){
       $http.post("payroll/payroll/payrollgeneration/getDepartmentList",branchId).success(function(datas) {
              $scope.departmentList = datas.departmentList;
              $scope.reimbursementReq.departmentId='';
              $scope.employeeList=[];
       })
        }
    };
    
    $scope.$watch('reimbursementReq.branchId', function(newValue, oldValue) {
        if(!$scope.reimbursementReq.isEdit){
        var branchId = newValue;
        $http.post("payroll/payroll/payrollgeneration/getDepartmentList",branchId).success(function(datas) {
               $scope.departmentList = datas.departmentList;
               $scope.reimbursementReq.departmentId='';
               $scope.employeeList=[];
        })
     
        }
    });
    
    
     
    $scope.getEmployeeDetails = function(){
        if(!$scope.reimbursementReq.isEdit){
       
        $http.get("payroll/payroll/payrollgeneration/getUserDetail").success(function(datas) {
              $scope.reimbursementReq.isOnLoad = true;
              $scope.getCompanyList();
              $scope.reimbursementReq.companyId=datas.companyId;
              $scope.reimbursementReq.companyName=datas.companyName;
              $scope.reimbursementReq.branchId=datas.branchId;
              $scope.reimbursementReq.branchName=datas.branchName;
              $scope.getDepartment(datas.branchId);
              
          })
        }
    };
    
    $scope.getEmployeeDetails();
    
    $scope.getEmployeeList = function(departmentId){
        if(!$scope.reimbursementReq.isEdit){
        var branchId =  $scope.reimbursementReq.branchId;
        var resultBean={
                branchId:branchId,
                departmentId:departmentId
                };
        $http.post("payroll/payroll/payrollgeneration/getEmployeeList",resultBean).success(function(datas) {
              $scope.employeeList = datas.employeeList;
              $scope.reimbursementReq.employeeId='';
          })
        }
    };
    
    $scope.$watch('reimbursementReq.departmentId', function(newValue, oldValue) {
        if(!$scope.reimbursementReq.isEdit){
        var departmentId = newValue;
        var branchId =  $scope.reimbursementReq.branchId;
        var resultBean={
                branchId:branchId,
                departmentId:departmentId
                };
        $http.post("payroll/payroll/payrollgeneration/getEmployeeList",resultBean).success(function(datas) {
              $scope.employeeList = datas.employeeList;
              $scope.reimbursementReq.employeeId='';
          })
        }
     
    });
  
  
    $scope.save=function(reimbursememtReqAddForm){
         if (new validationService().checkFormValidity(reimbursememtReqAddForm)) {
            var rightNow = new Date();
            var rightNowDate = rightNow.toISOString().slice(0,10).replace(/-/g,"/");
            rightNowDate=rightNowDate.split("/");
            var currentDate =rightNowDate[2]+"/"+ rightNowDate[1]+"/"+ rightNowDate[0];
            $scope.reimbursementReq.requestedby=$scope.reimbursementReq.employeeId;
            $scope.reimbursementReq.requesteddate=currentDate;
            $scope.reimbursementReq.status="1";
            var saveData =$scope.reimbursementReq;
            var resultbean={
                        amount: $scope.reimbursementReq.amount,
                        branchId:  $scope.reimbursementReq.branchId,
                        branchName:  $scope.reimbursementReq.branchName,
                        companyId:  $scope.reimbursementReq.companyId,
                        companyName:  $scope.reimbursementReq.companyName,
                        currencyCode:  $scope.reimbursementReq.currencyCode,
                        departmentId:  $scope.reimbursementReq.departmentId,
                        description:$scope.reimbursementReq.description,
                        employeeId:  $scope.reimbursementReq.employeeId,
                        employeeName:  $scope.reimbursementReq.employeeName,
                        fileName:  $scope.reimbursementReq.fileName,
                        paymentMode:  $scope.reimbursementReq.paymentMode,
                        reimbursementId:  $scope.reimbursementReq.reimbursementId,
                        reimbursementTypeId:  $scope.reimbursementReq.reimbursementTypeId,
                        requestedby:  $scope.reimbursementReq.requestedby,
                        requesteddate:  $scope.reimbursementReq.requesteddate,
                        status:  $scope.reimbursementReq.status
            }
            if($scope.reimbursementReq.isEdit !=true){
                $http.post("payroll/payroll/reimbursementreq/save", resultbean).success(function(result) {
                    if (result == false) {
                        logger.logError("Error in save")
                    }else{
                        logger.logSuccess("Saved Successfully")
                        $state.go('app.payroll.payroll.reimbursementreq.list');
                    }
                });  
                    
          
           }
     }else {
         toaster.pop('error', "Please fill the required fields",
                 logger.getErrorHtmlNew(reimbursememtReqAddForm.$validationSummary),5000, 'trustedHtml');
     }
    }
   
    $scope.getCurrencyList = function(){
        $http.get("payroll/payroll/reimbursementreq/getCurrencyList").success(function(response) {
            $scope.currencyList = response.currencyList;
        });
    };
    
   $scope.getCurrencyList();
    
    
    $scope.getReimburseMentList = function(){
        $http.get("payroll/payroll/reimbursementreq/getReimburseMentTypeList").success(function(response) {
            $scope.reimbursementTypeList = response.reimbursementTypeList;
        });
    };
    
    $scope.getReimburseMentList();
    
    
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
        frmData.append("fileName",$scope.reimbursementReq.employeeId+"_"+datetime);
        var isValid=true;
        var employeeName=$scope.reimbursementReq.employeeId;
        if(employeeName=="" || employeeName==null || employeeName==undefined){
            isValid=false;
            logger.logError("Employee Name is Required!!!");   
        }
        
        $scope.docfile=frmData;
        if(isValid){
        $.ajax({
            type : "POST",
            url : "payroll/payroll/reimbursementreq/uploadDocfile",
            data : frmData,
            contentType: false,
            processData: false,
           success:  function(result) {
               $scope.docFileName=result.docFileName;
               $scope.docFilePath=result.docPath;
               $scope.reimbursementReq.fileName = result.docPath;
               if(result.success){
                   logger.logSuccess("Document Uploaded Successfully");
               }else{
                   logger.logError("Fail to Upload");    
               }
               
            }
        
     });
        
        }
    };
    
    $scope.reset = function(reimbursememtReqAddForm) {
        if($scope.reimbursementReq.isEdit !=true){
            $scope.reimbursementReq.amount='';
           $scope.reimbursementReq.currencyCode='',
            $scope.reimbursementReq.departmentId='',
            $scope.reimbursementReq.description='',
            $scope.reimbursementReq.employeeId='',
             $scope.reimbursementReq.employeeName='',
             $scope.reimbursementReq.fileName='',
            $scope.reimbursementReq.paymentMode='',
             $scope.reimbursementReq.reimbursementId='',
             $scope.reimbursementReq.reimbursementTypeId='',
            $scope.reimbursementReq.requestedby='',
             $scope.reimbursementReq.requesteddate='',
             $scope.reimbursementReq.status=''
        }else{
            $scope.reimbursementReq.amount='';
           $scope.reimbursementReq.currencyCode='',
            $scope.reimbursementReq.departmentId='',
            $scope.reimbursementReq.description='',
            $scope.reimbursementReq.employeeId='',
             $scope.reimbursementReq.employeeName='',
             $scope.reimbursementReq.fileName='',
            $scope.reimbursementReq.paymentMode='',
             $scope.reimbursementReq.reimbursementId='',
             $scope.reimbursementReq.reimbursementTypeId='',
            $scope.reimbursementReq.requestedby='',
             $scope.reimbursementReq.requesteddate='',
             $scope.reimbursementReq.status=''
            
        }
    }
  
    $scope.update = function(reimbursememtReqAddForm) {
        if (new validationService().checkFormValidity(reimbursememtReqAddForm)) {
        var resultbean={
                amount: $scope.reimbursementReq.amount,
                branchId:  $scope.reimbursementReq.branchId,
                branchName:  $scope.reimbursementReq.branchName,
                companyId:  $scope.reimbursementReq.companyId,
                companyName:  $scope.reimbursementReq.companyName,
                currencyCode:  $scope.reimbursementReq.currencyCode,
                departmentId:  $scope.reimbursementReq.departmentId,
                description:$scope.reimbursementReq.description,
                employeeId:  $scope.reimbursementReq.employeeId,
                employeeName:  $scope.reimbursementReq.employeeName,
                fileName:  $scope.reimbursementReq.fileName,
                paymentMode:  $scope.reimbursementReq.paymentMode,
                reimbursementId:  $scope.reimbursementReq.reimbursementId,
                reimbursementTypeId:  $scope.reimbursementReq.reimbursementTypeId,
                requestedby:  $scope.reimbursementReq.requestedby,
                requesteddate:  $scope.reimbursementReq.requesteddate,
                status:  $scope.reimbursementReq.status
    }
        $http.post('payroll/payroll/reimbursementreq/update', resultbean).success(function(result) {
                if (result == false) {
                    logger.logError("loan entryAlready Exist");
                } else {
                    logger.logSuccess("Reimbursement Request Updated successfully");
                    $state.go('app.payroll.payroll.reimbursementreq.list');
                }
            });
     
      }else {
          toaster.pop('error', "Please fill the required fields",
                  logger.getErrorHtmlNew(reimbursememtReqAddForm.$validationSummary),5000, 'trustedHtml');
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


});
   

