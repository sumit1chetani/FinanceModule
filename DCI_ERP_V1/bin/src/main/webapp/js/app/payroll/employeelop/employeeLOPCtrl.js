'use strict';
	app.controller('employeeLOPCtrl', function($stateParams,$scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService,utilsService, $window,$timeout) {


    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.isEdit = false;
    $scope.isAuthorized=false;
    
    $scope.isAdd=true;
    $scope.isDelete=true;
    $scope.isUpload=true;
    
    $scope.loplist = {
            departmentId:'',
            branchId:'',
            branchName:'',
            companyName:'',
            companyId:'',
            monthYear:'',
            month:'',
            year:'',
            isEdit:false,
            isOnLoad : false
     };
    $scope.loplist.isEdit = false;
    $scope.lopList=[];
    
    $scope.getCompanyList = function(){
    	$http.get($stateParams.tenantid	+ '/app/usermaster/getCompanyList?formCode='
				+ 'F0395').success(
		function(datas) {  
       // $http.get("payroll/payroll/payrollgeneration/getCompanyList").success(function(datas) {
              console.log("getCompanyList");
              $scope.companyList = datas;
              if ($scope.companyList.length >= 1) {
                  $scope.loplist.companyId = $scope.companyList[0].id;
                  $scope.loplist.companyName = $scope.companyList[0].companyName;
              }
           
              console.log(datas);
          })
    }
    
    $scope.$watch('loplist.companyId', function(newValue, oldValue) {
        var companyId = newValue;
        if($scope.loplist.companyId != '' && $scope.loplist.isOnLoad == false){
            $scope.loplist.branchId='';
            $scope.loplist.branchName='';
        }
        $http.post("payroll/payroll/payrollgeneration/getBranchList",companyId).success(function(datas) {
                console.log("getBranchList");
                $scope.loplist.isOnLoad=false;
                $scope.branchList = datas.branchList;
                if($scope.branchList.length==1){
                    $scope.loplist.branchId=$scope.branchList[0].id;
                    $scope.loplist.branchName=$scope.branchList[0].text;
                }
                $scope.loplist.departmentId='';
                $scope.departmentList=[];
                console.log($scope.branchList);
            })
    
    });
    
    
    $scope.getBranchList = function(companyId,branchID){
        $http.post("payroll/payroll/payrollgeneration/getBranchList",companyId).success(function(datas) {
                console.log("getBranchList");
                $scope.branchList = datas.branchList;
                console.log(branchID);
                $scope.loplist.branchId=branchID;
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
              $scope.loplist.departmentId='';
              $scope.employeeList=[];
       })
    }
    
    
    $scope.$watch('loplist.branchId', function(newValue, oldValue) {
        var branchId = newValue;
        $http.post("payroll/payroll/payrollgeneration/getDepartmentList",branchId).success(function(datas) {
               console.log("LoginUseDepartmentList");
               console.log(datas);
               $scope.departmentList = datas.departmentList;
               $scope.loplist.departmentId='';
               $scope.employeeList=[];
        })
     
    });
  
    
    $scope.getEmployeeDetails = function(){
        
        $http.get("payroll/payroll/payrollgeneration/getUserDetail").success(function(datas) {
              console.log("LoginUser");
              console.log(datas);
              $scope.getCompanyList();
              $scope.loplist.companyId=datas.companyId;
              $scope.loplist.companyName=datas.companyName;
              $scope.loplist.isOnLoad=true;
              $scope.getBranchList($scope.loplist.companyId,datas.branchId);
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
    
    $scope.daysInMonth=function(year,month){
        return new Date(year, month, 0).getDate();
      
    };
    
    $scope.checkPercentageValue=function(date,days,index){
        var monthinDate;
        angular.forEach($scope.monthYearList, function(value, key) {
            if(value.monthValue==date){
                date=value.monthYear;
                var date1 = date.substring(0, 2);
                var date2 = date.substring(2,6);
                monthinDate= $scope.daysInMonth(date2,date1);
              
            }
        });
        if(monthinDate!=undefined && monthinDate!=null && monthinDate!=''){
            if(days<=monthinDate){
                
            }else{
                logger.logError("Days Should not exceed "+monthinDate);
                $scope.rowCollection[index].days=0;
            }
        }
      
    }
    
    $scope.getLOPList=function(lopListForm){
        if (new validationService().checkFormValidity(lopListForm)){
        var companyId = $scope.loplist.companyId;
        var branchId = $scope.loplist.branchId;
        var dept = $scope.loplist.departmentId;
        var monthYear =$scope.loplist.monthYear;
        var resultBean = {
                companyId : companyId,
                branchId : branchId,
                //departmentId:departmentId,
                dept:dept,

                monthYear:monthYear
            }
        console.log("resultBean")
       console.log(resultBean);
        $http.post("payroll/payroll/employeelop/list",resultBean).success(function(response) {
          console.log(response.empLopList);
            if(response.empLopList!=null && response.empLopList!="" && response.empLopList!=undefined){
                console.log(response.empLopList);
                $scope.rowCollection =response.empLopList;
                $scope.loplist.isEdit = true;
            }else{
                $scope.loplist.isEdit = false;
                $scope.rowCollection=[];
            }
        }).error(function(data) {
            console.log(datas);
        });
        }else {
            toaster.pop('error', "Please fill the required fields",
                    logger.getErrorHtmlNew(lopListForm.$validationSummary),5000, 'trustedHtml');
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
        
        
        $rootScope.uploadLop = function() {
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
                        url : "payroll/payroll/employeelop/uploadfile",
                        data : frmData,
                        contentType : false,
                        processData : false,
                        success : function(result) {
                            console.log("result")
                            console.log(result)
                            if (result.success) {
                                console.log("error"+result.empLopBean.isValid);
                                if(result.empLopBean.isValid){
                                    
                                    logger.logSuccess("File Uploaded Successfully");
                                    if($scope.loplist.companyId!=undefined && $scope.loplist.companyId!=null && $scope.loplist.companyId!='' &&
                                            $scope.loplist.departmentId!=undefined && $scope.loplist.departmentId!=null && $scope.loplist.departmentId!='' && 
                                            $scope.loplist.branchId!=undefined && $scope.loplist.branchId!=null && $scope.loplist.branchId!='' && 
                                            $scope.loplist.monthYear!=undefined && $scope.loplist.monthYear!=null && $scope.loplist.monthYear!=''){
                                       
                                        
                                        var resultBean = {
                                                companyId : $scope.loplist.companyId,
                                                dept : $scope.loplist.departmentId,
                                                branchId : $scope.loplist.branchId,
                                                monthYear : $scope.loplist.monthYear,
                                                
                                            }
                                        
                                        $http.post("payroll/payroll/employeelop/list",resultBean).success(function(response) {
                                            console.log("After Success");
                                            console.log(response.empLopList);
                                              if(response.empLopList!=null && response.empLopList!="" && response.empLopList!=undefined){
                                                  console.log(response.empLopList);
                                                
                                                  $scope.rowCollection =response.empLopList;
                                                  $scope.loplist.isEdit = true;
                                              }else{
                                                  $scope.loplist.isEdit = false;
                                                  $scope.rowCollection=[];
                                              }
                                          })
                                        console.log("result bean");
                                        console.log(resultBean);
                                       
                                    }
                                    
                                    
                                }
                                else{
                                    logger.logError(result.empLopBean.errorMessage);
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
        
        $scope.exportExcel = function(lopListForm) { 
            if (new validationService().checkFormValidity(lopListForm)){
             var companyId = $scope.loplist.companyId;
            var branchId = $scope.loplist.branchId;
            var dept = $scope.loplist.departmentId;
            var monthYear = $scope.loplist.monthYear;
            var resultBean = {
                    companyId : companyId,
                    branchId : branchId,
                    dept:dept,
                    monthYear:monthYear
            }
            
            $http.post('payroll/payroll/employeelop/exportExcel', resultBean).success(function(data) {
                
                console.log("export report");
                console.log(data);
                if (data.success == true) {
                   $scope.loplist.Show = true;
                   logger.logSuccess("File Exported Successfully");
                   $('#btnRowDivId').append('<a id="captainMsglink" href="tempdoc/Employee_LOP_File.xls" class="control-label" download="Employee_LOP_File.xls"></a>');
                   $("#captainMsglink").bind('click', function() {
                   });
                   $('#captainMsglink').simulateClick('click');
                } else {
                    $scope.loplist.Show = false;
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
        
        
        
        $scope.updateLOPList=function(){
            debugger;
            console.log("Updated Values");
            console.log($scope.rowCollection);
            console.log("Length:"+$scope.rowCollection.length);
            if($scope.rowCollection.length>0){
                $http.post("payroll/payroll/employeelop/save", $scope.rowCollection).success(function(result) {
                    if (result == false) {
                    }else{
                        logger.logSuccess("LOP List Updated successfully");
                        if($scope.loplist.companyId!=undefined && $scope.loplist.companyId!=null && $scope.loplist.companyId!='' &&
                                $scope.loplist.departmentId!=undefined && $scope.loplist.departmentId!=null && $scope.loplist.departmentId!='' && 
                                $scope.loplist.branchId!=undefined && $scope.loplist.branchId!=null && $scope.loplist.branchId!='' && 
                                $scope.loplist.monthYear!=undefined && $scope.loplist.monthYear!=null && $scope.loplist.monthYear!=''){
                           
                            
                            var resultBean = {
                                    companyId : $scope.loplist.companyId,
                                    dept : $scope.loplist.departmentId,
                                    branchId : $scope.loplist.branchId,
                                    monthYear : $scope.loplist.monthYear,
                                    
                                }
                            
                            $http.post("payroll/payroll/employeelop/list",resultBean).success(function(response) {
                                console.log("After Success");
                                console.log(response.empLopList);
                                  if(response.empLopList!=null && response.empLopList!="" && response.empLopList!=undefined){
                                      console.log(response.empLopList);
                                    
                                      $scope.rowCollection =response.empLopList;
                                      $scope.loplist.isEdit = true;
                                  }else{
                                      $scope.loplist.isEdit = false;
                                      $scope.rowCollection=[];
                                  }
                              })
                            console.log("result bean");
                            console.log(resultBean);
                           
                        }
                        
                    }
                    
                })   
            }
        };




});
