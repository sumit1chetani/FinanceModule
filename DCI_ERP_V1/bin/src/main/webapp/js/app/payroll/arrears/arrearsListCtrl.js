define([ 'payroll/payroll/payroll' ], function(module) {
'use strict';
module.registerController('arrearsListCtrl', function($scope,$state,$http,ngDialog, logger,$location,$controller,$injector, sharedProperties, toaster,$rootScope,validationService)  {
    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.isEdit = false;
    $scope.isAuthorized=false;
    $scope.isDisplay= true;
    
    $scope.arrears = {
            departmentId:'',
            branchId:'',
            branchName:'',
            companyName:'',
            companyId:'',
            otherCharges:'',
            monthYear:'',
            month:'',
            year:'',
            isEdit:false,
            isOnLoad : false
     };
    $scope.loplist={
            monthYear:''
    }
       
    
    $scope.arrears.isEdit = false;
    $scope.arrears=[];
    
    $scope.getCompanyList = function(){
        
        $http.get("payroll/payroll/payrollgeneration/getCompanyList").success(function(datas) {
              console.log("getCompanyList");
              $scope.companyList = datas.companyList;
              console.log(datas);
          })
    }
    
    $scope.$watch('arrears.companyId', function(newValue, oldValue) {
        var companyId = newValue;
        debugger;
        if($scope.arrears.companyId != '' && $scope.arrears.isOnLoad == false){
            $scope.arrears.branchId='';
            $scope.arrears.branchName='';
        }
        $http.post("payroll/payroll/payrollgeneration/getBranchList",companyId).success(function(datas) {
                console.log("getBranchList");
                $scope.arrears.isOnLoad=false;
                $scope.branchList = datas.branchList;
                if($scope.branchList.length==1){
                    $scope.arrears.branchId=$scope.branchList[0].branchId;
                    $scope.arrears.branchName=$scope.branchList[0].branchName;
                }
                $scope.arrears.departmentId='';
                $scope.departmentList=[];
                console.log($scope.branchList);
            })
    
    });
    
    
    $scope.getBranchList = function(companyId,branchID){
        $http.post("payroll/payroll/payrollgeneration/getBranchList",companyId).success(function(datas) {
                console.log("getBranchList");
                $scope.branchList = datas.branchList;
                console.log(branchID);
                $scope.arrears.branchId=branchID;
                $scope.departmentList=[];
                console.log($scope.branchList);
            })
      }
    
    $scope.getDepartment = function(branchId){
        console.log("branchID");
       $http.post("payroll/payroll/payrollgeneration/getDepartmentList",branchId).success(function(datas) {
              console.log("LoginUseDepartmentList");
              console.log(datas);
              $scope.departmentList = datas.departmentList;
              $scope.arrears.departmentId='';
              $scope.employeeList=[];
       })
    }
    
    
    $scope.$watch('arrears.branchId', function(newValue, oldValue) {
        var branchId = newValue;
        $http.post("payroll/payroll/payrollgeneration/getDepartmentList",branchId).success(function(datas) {
               console.log("LoginUseDepartmentList");
               console.log(datas);
               $scope.departmentList = datas.departmentList;
               $scope.arrears.departmentId='';
               $scope.employeeList=[];
        })
     
    });
  
    
    $scope.getEmployeeDetails = function(){
        
        $http.get("payroll/payroll/payrollgeneration/getUserDetail").success(function(datas) {
              console.log("LoginUser");
              console.log(datas);
              $scope.getCompanyList();
              $scope.arrears.companyId=datas.companyId;
              $scope.arrears.companyName=datas.companyName;
              $scope.arrears.isOnLoad=true;
              $scope.getBranchList($scope.arrears.companyId,datas.branchId);
              $scope.getDepartment(datas.branchId);
              
          });
    }
    
    $scope.getEmployeeDetails();
    
    $scope.getMonthYearList = function(){
        
        $http.get("payroll/payroll/payrollgeneration/getMonthYearList").success(function(datas) {
              console.log("MonthYearList");
              $scope.monthYearList = datas.monthYearList;
              console.log(datas);
          })
    }
    
    $scope.getMonthYearList();
    

    $scope.getarrears=function(arrearsForm){
        debugger;
       // sharedProperties.clearObject();
        if (new validationService().checkFormValidity(arrearsForm)){
        var companyId = $scope.arrears.companyId;
        var branchId = $scope.arrears.branchId;
        var departmentId = $scope.arrears.departmentId;
        var monthYear =$scope.loplist.monthYear;
        var resultBean = {
                companyId : companyId,
                branchId : branchId,
                departmentId:departmentId,
                monthYear:monthYear
            }
        console.log("resultBean")
       console.log(resultBean);
        $http.post("payroll/payroll/arrears/list",resultBean).success(function(response) {
          console.log(response);
            if(response.arrearsBeanList!=null && response.arrearsBeanList!="" && response.arrearsBeanList!=undefined){
                console.log(response.arrearsBeanList);
                $scope.rowCollection =response.arrearsBeanList;
                $scope.arrears.isEdit = true;
            }else{
                $scope.arrears.isEdit = false;
                $scope.rowCollection=[];
            }
        }).error(function(data) {
            
        });
        }else {
            toaster.pop('error', "Please fill the required fields",
                    logger.getErrorHtmlNew(arrearsForm.$validationSummary),5000, 'trustedHtml');
        }
      
   };
        
        $scope.fileUpload = function() {
            ngDialog.close();
            ngDialog.open({
                template : 'fileModal',
                scope : $scope
            });
        };
        
            $rootScope.uploadFile = function(element) {
            
            console.log("excel file");
            $scope.excelfile = element.files[0];
            console.log($scope.excelfile);
        }
        
        $rootScope.closeFileDialog = function() {
            ngDialog.close();
        };
        
        
        $rootScope.uploadArrearCharge = function() {
            ngDialog.close();
            var excelfile = $scope.excelfile;
            var fileExtension = excelfile.name;
            var fName = [];
            fName = fileExtension.split(".");
            for (var i = 0; i < fName.length; i++) {
                if (fName[i] == "xls" || fName[i] == "xlsx") {
                    var frmData = new FormData();
                    frmData.append("file", excelfile);
                    $.ajax({
                        type : "POST",
                        url : "payroll/payroll/arrears/uploadfile",
                        data : frmData,
                        contentType : false,
                        processData : false,
                        success : function(result) {
                            console.log("result")
                            console.log(result)
                            if (result.success) {
                                console.log("result");
                                console.log(result);
                                if(result.arrearsBean.isValid){
                                    logger.logSuccess("File Uploaded Successfully");
                                   
                                }
                                else{
                                    logger.logError(result.arrearsBean.errorMessage);
                                }
                                   
                                } else {
                                    logger.logError("Fail to upload");
                                }

                        }

                    });
                }

            }
        }
        
        
        // Export to xl
        
        $scope.exportExcel = function(ebListForm) { 
           debugger;
            if (new validationService().checkFormValidity(ebListForm)){
             var companyId = $scope.arrears.companyId;
            var branchId = $scope.arrears.branchId;
            var departmentId = $scope.arrears.departmentId;
            var monthYear = $scope.loplist.monthYear;
            var resultBean = {
                    companyId : companyId,
                    branchId : branchId,
                    departmentId:departmentId,
                    monthYear:monthYear
            }
            
            $http.post('payroll/payroll/arrears/exportExcel', resultBean).success(function(data) {
                
                console.log("export report");
                console.log(data);
                if (data.success == true) {
                   $scope.arrears.Show = true;
                   logger.logSuccess("File Exported Successfully");
                   $('#btnRowDivId').append('<a id="captainMsglink" href="tempdoc/Employee_Arrear_Salary_File.xls" class="control-label" download="Employee_Arrear_Salary_File.xls"></a>');
                   $("#captainMsglink").bind('click', function() {
                   });
                   $('#captainMsglink').simulateClick('click');
                } else {
                    $scope.arrears.Show = false;
                    logger.logError("Error Please Try Again")
                   
                  
               
                }
            }).error(function(data) {
            }); 
            
            }else {
                toaster.pop('error', "Please fill the required fields",
                        logger.getErrorHtmlNew(employeeTdsForm.$validationSummary),5000, 'trustedHtml');
            }
                  
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
        
     
        
        $scope.updatearrears=function(){
            console.log("Updated Values");
            console.log($scope.rowCollection);
            console.log("Length:"+$scope.rowCollection.length);
            if($scope.rowCollection.length>0){
                $http.post("payroll/payroll/arrears/insert", $scope.rowCollection).success(function(result) {
                    if (result == false) {
                    }else{
                        logger.logSuccess("Arrears List Updated successfully");
                        
                        if($scope.arrears.companyId!=undefined && $scope.arrears.companyId!=null && $scope.arrears.companyId!='' &&
                                $scope.arrears.departmentId!=undefined && $scope.arrears.departmentId!=null && $scope.arrears.departmentId!='' && 
                                $scope.arrears.branchId!=undefined && $scope.arrears.branchId!=null && $scope.arrears.branchId!='' && 
                                $scope.loplist.monthYear!=undefined && $scope.loplist.monthYear!=null && $scope.loplist.monthYearr!=''){
                           
                            
                            var resultBean = {
                                    companyId : $scope.arrears.companyId,
                                    departmentId : $scope.arrears.departmentId,
                                    branchId : $scope.arrears.branchId,
                                    monthYear : $scope.loplist.monthYear,
                                    
                                }
                            
                            $http.post("payroll/payroll/arrears/list",resultBean).success(function(response) {
                                console.log(response);
                                  if(response.arrearsBeanList!=null && response.arrearsBeanList!="" && response.arrearsBeanList!=undefined){
                                      console.log(response.arrearsBeanList);
                                      $scope.rowCollection =response.arrearsBeanList;
                                      $scope.arrears.isEdit = true;
                                  }else{
                                      $scope.arrears.isEdit = false;
                                      $scope.rowCollection=[];
                                  }
                              }).error(function(data) {
                                  
                              });
                          
                           
                        }
                        
                      
                    }
                    
                })   
            }
        };
        
        
        
        $scope.updatePayComponent=function(){
            console.log("Updated Values");
            console.log($scope.rowCollection);
            console.log("Length:"+$scope.rowCollection.length);
            if($scope.rowCollection.length>0){
                $http.post("payroll/payroll/arrears/savePayComponent", $scope.rowCollection).success(function(result) {
                    if (result == false) {
                    }else{
                        logger.logSuccess("Arrears List Updated successfully");
                      
                    }
                    
                })   
            }
        };
});



});
