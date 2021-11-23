'use strict';
app.controller('shiftAllocationAddCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService,$stateParams) {
	  
	/*$('#validityFrom').datetimepicker({
	         format : 'DD/MM/YYYY'
	     })*/
	$scope.displayedCollection = [];
     $scope.itemsByPage = 10;
     $scope.numPages = 0;
     $scope.isEdit = false;

     $scope.cancel = function() {
         $state.go("app.hr.shiftAllocation.list");
     };

     $scope.date = '';
     var today = new Date();
     var dd = today.getDate();
     var mm = today.getMonth() + 1; // January is 0!
     var yyyy = today.getFullYear();
     if (dd < 10) {
         dd = '0' + dd;
     }
     if (mm < 10) {
         mm = '0' + mm;
     }
   
     var today = dd + '/' + mm + '/' + yyyy;
     $scope.date = today;

     $('#departmentName').show();
     $('#departmentNameReadOnly').hide();
     $('#branchName').show();
     $('#branchNameReadOnly').hide();
     $('#employeeNo').show();
     $('#employeeNoReadOnly').hide();
     $('#SchemeName').show();
     $('#SchemeNameReadOnly').hide();
     $('#validityFromValue').show();
     $('#validityFromReadOnly').hide();
     $scope.departmentList = [];
     $scope.employeeList = [];
     $scope.schemeList = [];
     $scope.shiftList = [];
     $scope.shiftAllocationobj = {
         shiftSchemeName : '',
         employeeNo : '',
         employeeName : '',
         companyName : '',
         branchName : '',
         departmentName : '',
         companyId : '',
         branchId : '',
         employeeId : '',
         designationName : '',
         firstName : '',
         validFrom : '',
         validTo : '',
         validityFrom : '',
         validityTo : '',
         schemeName : '',
         schemeId : '',
         departmentId : '',
        // formCode:'F0275'
     };
     
     $scope.companyList=[{
     	id:'C0001',
     	text:'MBK'
     }]
     $http.post($stateParams.tenantid+'/app/hr/holiday/branchlist').success(function(data) {
	      	
   		$scope.branchList=data;
   		        		
 	});/*
     $scope.getBranchList = function(companyId) {

         if (companyId != "") {
             $http.post($stateParams.tenantid+'/hr/shiftAllocation/getBranchList', companyId).success(function(datas) {
                 $scope.branchList = datas;
                 if (datas.branchList.length == 1) {

                     $scope.shiftAllocationobj.branchId = datas.branchList[0].branchId;
                     //$scope.shiftAllocationobj.branchName = datas.branchList[0].branchName;
                     $scope.getDepartment($scope.shiftAllocationobj.branchId);
                 }
             });
         }

     }

     $scope.getCompanyList1 = function() {
     	var formCode= $scope.shiftAllocationobj.formCode;

    	 //var formCode = document.getElementById('formCode').value;
         $http.post($stateParams.tenantid+"/app/commonUtility/getCompanyList ",formCode).success(function(response) {

             $scope.companyList = response;
             if ($scope.companyList.length == 1) {
                 $scope.shiftAllocationobj.companyId = $scope.companyList[0].id;
                 $scope.disable = true;
                 $scope.getBranchList($scope.shiftAllocationobj.companyId);
             }
         })
     }
     $scope.getCompanyList1();
     
     $scope.$watch('shiftAllocationobj.companyId', function(newValue, oldValue) {
         if (newValue != null && newValue != "") {
             $scope.getBranchList(newValue);
         }
     });
     $scope.branchList = [ {
         id : '1',
         text : 'INTER AFRICA'
     } ];
    */
     

     $scope.dropdown = false;

     $http.get($stateParams.tenantid+'/hr/shiftAllocation/getShiftList').success(function(data) {
         debugger
         $scope.shiftList = data.shiftList;
     });

     $scope.$watch('shiftAllocationobj.branchId', function(newValue, oldValue) {
         if (newValue != null && newValue != "") {
             $scope.shiftAllocationobj.departmentId = '';
             $scope.shiftAllocationobj.employeeId = '';
             $scope.getDepartment(newValue);
         }

     });

     $scope.getDepartment = function(branchId) {

         var myURL = $stateParams.tenantid+'/hr/shiftAllocation/getDepartmentList?branchId';
         $http({
             method : 'post',
             url : myURL,
             data : branchId,
         }).success(function(data) {
             $scope.departmentList = data.departmentList;
         });
     }
     var empId = '';
     $scope.$watch('shiftAllocationobj.departmentId', function(newValue, oldValue) {
         debugger
         var resultbean = {
             branchId : $scope.shiftAllocationobj.branchId,
             deptId : newValue
         }
         var departmentId = newValue;
         if (newValue != undefined && newValue != "") {
             var myURL = $stateParams.tenantid+'/hr/shiftAllocation/getEmployeeList';
             $http({
                 method : 'post',
                 url : myURL,
                 data : resultbean,
             }).success(function(data) {
                 $scope.employeeList = data.employeeList;
                 var i= 0;
                 $scope.shiftAllocationobj.employeeId = '';
                 for(i ;i < data.employeeList.length; i++)
                     {
                     
                 $scope.shiftAllocationobj.employeeId   += ','+data.employeeList[i].employeeId;  
                      
                     }
                  empId=  $scope.shiftAllocationobj.employeeId;
//                 $scope.shiftAllocationobj.employeeId = '';

             });
         }
     });

     $scope.getEmployee = function(departmentId) {
         debugger
         var resultbean = {
             branchId : $scope.shiftAllocationobj.branchId,
             deptId : departmentId
         }
         if (departmentId != undefined && departmentId != "") {
             var myURL = $stateParams.tenantid+'/hr/shiftAllocation/getEmployeeList';
             $http({
                 method : 'post',
                 url : myURL,
                 data : resultbean,
             }).success(function(data) {
                 $scope.employeeList = data.employeeList;
             });
         }
     }

     /* Clearing the value while changing the Employee Drop-down */
     $scope.clearValue = function() {
         $scope.shiftAllocationobj.validityFrom = '';
         $scope.shiftAllocationobj.validityTo = '';
         $scope.schemeList = [];
         $scope.shiftAllocationobj.schemeName = '';
     }

     // Watch method
     $scope.$watch('shiftAllocationobj.validityFrom', function(newValue) {
         if (newValue != "") {
             var fromDate = newValue;
             var toDate = $scope.date;
             fromDate = fromDate.split("/");
             fromDate = new Date(fromDate[2], fromDate[1], fromDate[0]);
             toDate = toDate.split("/");
             toDate = new Date(toDate[2], toDate[1], toDate[0]);
         }
     });

     $scope.$watch('[shiftAllocationobj.validityFrom,shiftAllocationobj.validityTo]', function(newValue) {
         if (newValue != "") {
             debugger
             if ($scope.shiftAllocationobj.validityFrom != '' && $scope.shiftAllocationobj.validityTo != '') {
                 var fromDate = $scope.shiftAllocationobj.validityFrom;
                 var toDate = $scope.shiftAllocationobj.validityTo;
                 fromDate = fromDate.split("/");
                 fromDate = new Date(fromDate[2], fromDate[1], fromDate[0]);
                 toDate = toDate.split("/");
                 toDate = new Date(toDate[2], toDate[1], toDate[0]);
                // if (fromDate < toDate) {
    // $scope.$watch('[shiftAllocationobj.validityFrom,shiftAllocationobj.validityTo]', function(newValue) {
                     $http.post($stateParams.tenantid+'/hr/shiftAllocation/getSchemeList', $scope.shiftAllocationobj).success(function(response) {
                         if (response) {
                             $scope.schemeList = response.schemeList;
                         } else {
                             logger.logError(response.message);
                             $scope.schemeList = [];
                         }

                     
     });

                 /*} else {
                     $scope.shiftAllocationobj.validityTo = '';
                     $scope.schemeList = [];
                     logger.logError("Validity From Date Should be greater than Validity To Date");
                 }
*/             } else {
                 $scope.schemeList = [];
             }
         }
     });

     $scope.getDateList = function(schemeName) {
         if (schemeName != "" && schemeName != null) {
             var myURL = $stateParams.tenantid+'/hr/shiftAllocation/getDateList?schemeName';
             $http({
                 method : 'post',
                 url : myURL,
                 data : schemeName,
             }).success(function(data) {
                 $scope.shiftAllocationobj.validityFrom = data.dateList[0].validityFrom;
                 $scope.shiftAllocationobj.validityTo = data.dateList[0].validityTo;
             });

         } else {
             $scope.shiftAllocationobj.validityFrom = '';
             $scope.shiftAllocationobj.validityTo = '';
         }
     }

     var $validationProvider = $injector.get('$validation');
     debugger
     $scope.save = function(shiftAllocationAddForm, shiftAllocationobj) {
         sharedProperties.clearObject();
         if($scope.shiftAllocationobj.employeeId =='')
             {
         $scope.shiftAllocationobj.employeeId = empId;
             }
         if (new validationService().checkFormValidity($scope.shiftAllocationAddForm)) {
        	 var data = {
                     'shiftAllocationobj' : $scope.shiftAllocationobj

                 }
         }

         //$validationProvider.validate($scope.shiftAllocationAddForm).success(function() {
             $http.post($stateParams.tenantid+'/hr/shiftAllocation/add', shiftAllocationobj).success(function(result) {
                 if (result.success == true && result.dsatesuccess == true) {
                     logger.logSuccess("Saved Successfully!");
                     $state.go('app.hr.shiftAllocation.list');
                 } else {
                     if (result.dsatesuccess == false) {
                         logger.logError(result.errorMessage);
                     } else {
                         logger.logError("Not Saved");
                     }

                 }
             
         }).error(function() {
             toaster.pop('error', "Please correct the errors", logger.getErrorHtml(sharedProperties.getErrorObject()), 5000, 'trustedHtml');
         });
     };

     $scope.reset = function() {

         $scope.shiftAllocationobj.shiftSchemeName = '';
         $scope.shiftAllocationobj.employeeNo = '';
         $scope.shiftAllocationobj.employeeName = '';
         $scope.shiftAllocationobj.branchName = '';
         $scope.shiftAllocationobj.departmentId = '';
         $scope.shiftAllocationobj.departmentName = '';
         $scope.shiftAllocationobj.branchId = '';
         $scope.shiftAllocationobj.employeeId = '';
         $scope.shiftAllocationobj.designationName = '';
         $scope.shiftAllocationobj.firstName = '';
         $scope.shiftAllocationobj.validFrom = '';
         $scope.shiftAllocationobj.validTo = '';
         $scope.shiftAllocationobj.validityFrom = '';
         $scope.shiftAllocationobj.validityTo = '';
         $scope.shiftAllocationobj.schemeName = '';
         $scope.shiftAllocationobj.schemeId = '';

     };

 });

app.controller('shiftAllocationEditCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, $stateParams, validationService, $timeout) {

     $scope.displayedCollection = [];
     $scope.itemsByPage = 10;
     $scope.numPages = 0;
     $scope.isEdit = true;

     $scope.cancel = function() {
         $state.go("app.hr.shiftAllocation.list");
     };

     $('#departmentName').hide();
     $('#departmentNameReadOnly').show();
     $('#branchName').hide();
     $('#branchNameReadOnly').show();
     $('#employeeNo').hide();
     $('#employeeNoReadOnly').show();
     $('#SchemeName').hide();
     $('#SchemeNameReadOnly').show();
     $('#validityFromValue').hide();
     $('#validityFromReadOnly').show();

     $scope.shiftAllocationobj = {
         shiftSchemeName : '',
         employeeNo : '',
         employeeName : '',
         companyName : '',
         branchName : '',
         departmentName : '',
         companyId : '',
         branchId : '',
         employeeId : '',
         designationName : '',
         firstName : '',
         validFrom : '',
         validTo : '',
         validityFrom : '',
         validityTo : '',
         schemeName : '',
         departmentId : ''
     };

     $scope.shiftAllocationobjClear = {};
     $scope.onLoad = false;

     $scope.branchList = [];
     $scope.departmentList = [];
     $scope.employeeList = [];
     $scope.schemeList = [];
     $scope.shiftList = [];

   /*  $scope.getCompanyList1 = function() {
         var formCode = document.getElementById('formCode').value;
         $http.post($stateParams.tenantid+"app/commonUtility/getUserCompanyList", formCode).success(function(response) {
             $scope.companyList = response.companyList;
             if (response.companyList.length == 1) {
                 $scope.shiftAllocationobj.companyId = response.companyList[0].id;
                 $scope.disable = true;
                 $scope.getBranchList($scope.shiftAllocationobj.companyId);
             }
         })
     }*/
     //$scope.getCompanyList1();

     var initializing = true

     $scope.$watch('shiftAllocationobj.validityTo', function(newValue, oldValue) {
         if (newValue != undefined && newValue != '' && newValue != null) {

             if (initializing == false) {
                 var fromDate = newValue;
                 var validityFromDt = $scope.shiftAllocationobj.validityFrom;
                 var toDate = $scope.shiftAllocationobj.validTo;
                 fromDate = fromDate.split("/");
                 fromDate = new Date(fromDate[2], fromDate[1] - 1, fromDate[0]);
                 toDate = toDate.split("/");
                 toDate = new Date(toDate[2], toDate[1] - 1, toDate[0]);
                 validityFromDt = validityFromDt.split("/");
                 validityFromDt = new Date(validityFromDt[2], validityFromDt[1], validityFromDt[0]);
                 if (fromDate <= toDate) {
                 } else {
                     $scope.shiftAllocationobj.validityTo = '';
                     logger.logError("Valid To date Should be greater than the manage shift scheme to date");
                 }
             } else {
                 initializing = false;
             }
         }

     });

     var schemeId = $location.search().schemeId;
     var employeeId = $location.search().employeeId;
     var validFrom = $location.search().validFrom;
     var validTo = $location.search().validTo;

     var url = $stateParams.tenantid+'/hr/shiftAllocation/getShiftAllocationEditList?schemeId=' + schemeId + '&employeeId=' + employeeId + '&validFrom=' + validFrom + '&validTo=' + validTo;
     $http.get(url).success(function(result) {
         $scope.shiftAllocationobj.companyId = result.companyId;
         $scope.disable = true;
         $scope.shiftAllocationobj.branchId = result.branchId;
         $scope.shiftAllocationobj.branchName = result.branchName;
         $scope.shiftAllocationobj.schemeName = result.schemeName;
         $scope.shiftAllocationobj.schemeId = result.schemeId;
         $scope.shiftAllocationobj.validityFrom = result.validityFrom;
         $scope.shiftAllocationobj.validityTo = result.validityTo;
         $scope.shiftAllocationobj.validTo = result.validTo;
         $scope.shiftAllocationobj.employeeNo = result.employeeNo;
         $scope.shiftAllocationobj.employeeName = result.employeeName;
         $scope.shiftAllocationobj.departmentName = result.departmentName;
         $scope.shiftAllocationobj.departmentId = result.departmentName;
         $scope.shiftAllocationobj.shiftId = result.shiftId;
         $scope.shiftAllocationobj.shiftName = result.shiftName;
         $scope.isOnLoad = true;

     }).error(function(result) {
         logger.logError("Error Please Try Again");
     });

     var $validationProvider = $injector.get('$validation');
     $scope.save = function(shiftAllocationAddForm, shiftAllocationobj) {
         sharedProperties.clearObject();
         $validationProvider.validate(shiftAllocationAddForm).success(function() {
             $http.post($stateParams.tenantid+'/hr/shiftAllocation/update', shiftAllocationobj).success(function(result) {
                 if (result == true) {
                     logger.logSuccess("Updated Successfully!");
                     $state.go('app.hr.shiftAllocation.list');
                 } else {
                     logger.logError("Already Exists!");
                 }
             });
         }).error(function() {
             toaster.pop('error', "Please correct the errors", logger.getErrorHtml(sharedProperties.getErrorObject()), 5000, 'trustedHtml');
         });
     };

     $scope.reset = function() {

         var url = $stateParams.tenantid+'/hr/shiftAllocation/getShiftAllocationEditList?schemeId=' + schemeId + '&employeeId=' + employeeId + '&validFrom=' + validFrom + '&validTo=' + validTo;
         $http.get(url).success(function(result) {
             $scope.shiftAllocationobj.companyId = result.companyId;
             $scope.shiftAllocationobj.branchId = result.branchId;
             $scope.shiftAllocationobj.schemeName = result.schemeName;
             $scope.shiftAllocationobj.schemeId = result.schemeId;
             $scope.shiftAllocationobj.validityFrom = result.validityFrom;
             $scope.shiftAllocationobj.validityTo = result.validityTo;
             $scope.shiftAllocationobj.employeeNo = result.employeeNo;
             $scope.shiftAllocationobj.employeeName = result.employeeName;
             $scope.shiftAllocationobj.departmentName = result.departmentName;
             $scope.shiftAllocationobj.departmentId = result.departmentName;
             $scope.shiftAllocationobj.shiftId = result.shiftId;
             $scope.shiftAllocationobj.shiftName = result.shiftName;

         }).error(function(result) {
             logger.logError("Error Please Try Again");
         });
     }

 });
