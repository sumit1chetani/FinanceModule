'use strict';
//module.registerController('employeeTdsCtrl', function($scope,$state,$http,ngDialog, logger,$location,$controller,$injector, sharedProperties, toaster,$rootScope,validationService)  {
	app.controller('employeeTdsCtrl', function($stateParams,$scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService,utilsService, $window,$timeout) {

$scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.isEdit = false;
    $scope.isAdd=true;
    $scope.isDelete=true;
    $scope.isUpload=true;
    
    $scope.isAuthorized=false;
    
    $scope.employeeTds = {
            departmentId:'',
            branchId:'',
            tds:'',
            actualTds:'',
            estimatedTds:'',
            branchName:'',
            companyName:'',
            companyId:'',
            month:'',
            year:'',
            monthYear:'',
            isOnLoad : false,
            isEdit:false  
     };
    $scope.employeeTds.isEdit = false;
   
    
    $scope.getCompanyList = function(){
    	$http.get($stateParams.tenantid	+ '/app/usermaster/getCompanyList?formCode='
				+ 'F0375').success(
		function(datas) {  
       // $http.get("payroll/payroll/payrollgeneration/getCompanyList").success(function(datas) {
              console.log("getCompanyList");
              $scope.companyList = datas;
              if ($scope.companyList.length >= 1) {
                  $scope.employeeTds.companyId = $scope.companyList[0].id;
                  $scope.employeeTds.companyName = $scope.companyList[0].companyName;
              }
              
              console.log(datas);
          })
    }
    
    
   
    
    $scope.getMonthYearList = function(){
        
        $http.get("payroll/payroll/payrollgeneration/getMonthYearList").success(function(datas) {
              console.log("MonthYearList");
              $scope.monthYearList = datas.monthYearList;
              console.log(datas);
          })
    }
    
    $scope.getMonthYearList();
    
    $scope.$watch('employeeTds.companyId', function(newValue, oldValue) {
        var companyId = newValue;
        if($scope.employeeTds.companyId != '' && $scope.employeeTds.isOnLoad == false){
            $scope.employeeTds.branchId='';
            $scope.employeeTds.branchName='';
        }
            
        $http.post("payroll/payroll/payrollgeneration/getBranchList",companyId).success(function(datas) {
                console.log("getBranchList");
                $scope.branchList = datas.branchList;
                if($scope.branchList.length==1){
                    $scope.employeeTds.branchId=$scope.branchList[0].id;
                    $scope.employeeTds.branchName=$scope.branchList[0].text;
                }
                $scope.employeeTds.isOnLoad = false;
                $scope.employeeTds.departmentId='';
                $scope.departmentList=[];
                console.log($scope.branchList);
            })
    
    });
    
    $scope.getBranchList = function(companyId,branchID){
        $http.post("payroll/payroll/payrollgeneration/getBranchList",companyId).success(function(datas) {
                console.log("getBranchList");
                $scope.branchList = datas.branchList;
                console.log(branchID);
                $scope.employeeTds.branchId=branchID;
                $scope.departmentList=[];
                console.log($scope.branchList);
            })
      }
    
    
    $scope.$watch('employeeTds.branchId', function(newValue, oldValue) {
        var branchId = newValue;
        $http.post("payroll/payroll/payrollgeneration/getDepartmentList",branchId).success(function(datas) {
               console.log("LoginUseDepartmentList");
               console.log(datas);
               $scope.departmentList = datas.departmentList;
               $scope.employeeTds.departmentId='';
               $scope.employeeList=[];
        })
     
    });
  
    
    $scope.getDepartment = function(branchId){
        console.log("branchID");
       $http.post("payroll/payroll/payrollgeneration/getDepartmentList",branchId).success(function(datas) {
              console.log("LoginUseDepartmentList");
              console.log(datas);
              $scope.departmentList = datas.departmentList;
              $scope.employeeTds.departmentId='';
              $scope.employeeList=[];
       })
    }
    
    $scope.getEmployeeDetails = function(){
        
        $http.get("payroll/payroll/payrollgeneration/getUserDetail").success(function(datas) {
              console.log("LoginUser");
              console.log(datas);
              $scope.getCompanyList();
              $scope.employeeTds.companyId=datas.companyId;
              $scope.employeeTds.companyName=datas.companyName;
              $scope.employeeTds.isOnLoad = true;
              $scope.getBranchList($scope.employeeTds.companyId,datas.branchId);
              $scope.getDepartment(datas.branchId);
              
          });
    }
    
    
    $scope.getMonthYearList = function(){
        
        $http.get("payroll/payroll/payrollgeneration/getMonthYearList").success(function(datas) {
              console.log("MonthYearList");
              $scope.monthYearList = datas.monthYearList;
              console.log($scope.monthYearList);
          })
    }
    
    $scope.getMonthYearList();
      
    $scope.getEmployeeDetails();
    
    $scope.getemployeeTds=function(employeeTdsForm){
      if (new validationService().checkFormValidity(employeeTdsForm)){
        var companyId = $scope.employeeTds.companyId;
        var branchId = $scope.employeeTds.branchId;
        var dept = $scope.employeeTds.departmentId;
        var monthYear = $scope.employeeTds.monthYear;
        var resultBean = {
                companyId : companyId,
                branchId : branchId,
                dept:dept,
                monthYear:monthYear
            }
                console.log("resultBean");
                console.log(resultBean);
                $http.post("payroll/payroll/employeetds/list",resultBean).success(function(response) {
                    console.log("response");
                    console.log(response);
                     if(response.emptdsList!=null && response.emptdsList!="" && response.emptdsList!=undefined){
                          $scope.rowCollection =response.emptdsList;
                          $scope.employeeTds.isEdit = true;
                      }else{
                          $scope.employeeTds.isEdit = false;
                          $scope.rowCollection=[];
                      }
                  }).error(function(data) {
                      console.log(datas);
                  });
        }else {
            toaster.pop('error', "Please fill the required fields",
                    logger.getErrorHtmlNew(employeeTdsForm.$validationSummary),5000, 'trustedHtml');
        }
              
        
}
        
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
        
        
        $rootScope.uploadTds = function() {
           
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
                        url : "payroll/payroll/employeetds/uploadfile",
                        data : frmData,
                        contentType : false,
                        processData : false,
                        success : function(result) {
                            console.log("result")
                            console.log(result)
                            if (result.success) {
                                console.log("error"+result);
                               if(result.eTdsBean.isValid){
                                    logger.logSuccess("File Uploaded Successfully");
                                    if($scope.employeeTds.companyId!=undefined && $scope.employeeTds.companyId!=null && $scope.employeeTds.companyId!='' &&
                                            $scope.employeeTds.departmentId!=undefined && $scope.employeeTds.departmentId!=null && $scope.employeeTds.departmentId!='' && 
                                            $scope.employeeTds.branchId!=undefined && $scope.employeeTds.branchId!=null && $scope.employeeTds.branchId!='' && 
                                            $scope.employeeTds.monthYear!=undefined && $scope.employeeTds.monthYear!=null && $scope.employeeTds.monthYear!=''){
                                        
                                        var resultBean = {
                                                companyId : $scope.employeeTds.companyId,
                                                dept : $scope.employeeTds.departmentId,
                                                branchId : $scope.employeeTds.branchId,
                                                monthYear : $scope.employeeTds.monthYear,
                                                
                                            }
                                        console.log("result bean");
                                        console.log(resultBean);
                                        $http.post("payroll/payroll/employeetds/list",resultBean).success(function(response) {
                                            console.log("response");
                                            console.log(response);
                                             if(response.emptdsList!=null && response.emptdsList!="" && response.emptdsList!=undefined){
                                                  $scope.rowCollection =response.emptdsList;
                                                  $scope.employeeTds.isEdit = true;
                                              }else{
                                                  $scope.employeeTds.isEdit = false;
                                                  $scope.rowCollection=[];
                                              }
                                          })
                                        
                                    }
                                    
                                    
                                    $scope.employeeTds.Show = false;
                                    
                                    
                                }
                                else{
                                    logger.logError(result.eTdsBean.errorMessage);
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
        
        $scope.exportExcel = function(employeeTdsForm) { 
            if (new validationService().checkFormValidity(employeeTdsForm)){
            var companyId = $scope.employeeTds.companyId;
            var branchId = $scope.employeeTds.branchId;
            var dept = $scope.employeeTds.departmentId;
            var monthYear = $scope.employeeTds.monthYear;
            var resultBean = {
                    companyId : companyId,
                    branchId : branchId,
                    dept:dept,
                    monthYear:monthYear
            }
            
            $http.post('payroll/payroll/employeetds/exportExcel', resultBean).success(function(data) {
                
                console.log("export report");
                console.log(data);
                if (data.success == true) {
                   $scope.employeeTds.Show = true;
                   $("#Export").bind('click', function() {
                   });
                   $('#Export').simulateClick('click');
                   logger.logSuccess("File Exported Successfully");
                 /*  $('#btnRowDivId').append('<a id="captainMsglink" href="tempdoc/Employee_Tds_File.xls" class="control-label" download="Employee_Tds_Tax.xls"></a>');
                   $("#captainMsglink").bind('click', function() {
                   });
                   $('#captainMsglink').simulateClick('click');*/
                } else {
                    $scope.employeeTds.Show = false;
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
        
       
        
        $scope.updateemployeeTds=function(){
           console.log("Updated Values");
            console.log($scope.rowCollection);
            console.log("Length:"+$scope.rowCollection.length);
            if($scope.rowCollection.length>0){
                $http.post("payroll/payroll/employeetds/save", $scope.rowCollection).success(function(result) {
                    if (result.success == false) {
                    }else{
                       // logger.logSuccess("Tds List Updated successfully");
                       if (result.errorMessage != null && result.errorMessage != "" && result.errorMessage != undefined) {
                           logger.logError(result.errorMessage);
                       }
                       if (result.successMessage != null && result.successMessage != "" && result.successMessage != undefined) {
                           logger.logSuccess(result.successMessage);
                       }
                    }
                    
                })   
            }
        };




});
