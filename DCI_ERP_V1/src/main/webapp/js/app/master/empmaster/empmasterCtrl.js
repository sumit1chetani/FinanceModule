'use strict';
app.controller('empmasterCtrl', function($scope,$stateParams, $rootScope, $http, $location,ngDialog, logger, utilsService,$state,sharedProperties,$window) {

	             $scope.offsetCount = 0;
	            $scope.limitCount = 1000;
	            $scope.rowCollection = [];
	            $scope.displayedCollection = [];
	            $scope.itemsByPage = 10;
	            $scope.numPages=0                        
	            $scope.isDelete=true;      
	            $scope.EmployeeMasterData={
	                    status1 : '0',
	                    donorCode : '',
	                    employeeNo : '',
	                    firstName : '',
	                    middleName : '',
	                    lastName : '',
	                    empId : '',
	                    pwd : '',
	                    gender : '',
	                    dob : '',
	                    emailId : '',
	                    mobileNo : '',
	                    doj : '',
	                    esic : '',
	                    fixedGross : '',
	                    isActive : 'N',
	                    status : 'N',
	                    accessCardNo : '',
	                    uploadPhoto : '',
	                    companyCode : '',
	                    companyName : '',
	                    branch : '',
	                    branchName : '',
	                    departmentId : '',
	                    departmentCode : '',
	                    designation : '',
	                    designationName : '',
	                    division : '',
	                    divisionName : '',
	                    grade : '',
	                    gradeName : '',
	                    reportToBranch : '',
	                    reportToBranchName : '',
	                    reportDeptId : '',
	                    reportToDept : '',
	                    reportDesigId : '',
	                    reportToDesig : '',
	                    reportMangr : '',
	                    typeOfEmp : '',
	                    empTypeName : '',
	                    relieveDate : '',
	                    epfNo    : '',
	                    isEdit:false
	            };            
	                   
	            $scope.status1 = [ {
	                id : '0',
	                text : 'Active'
	            }, {
	                id : '1',
	                text : 'InActive'
	            }, {
	                id : '2',
	                text : 'All'
	            },];
	            $scope.add = function() {
	            	
	                $state.go('app.master.employee.employeeMasteradd-add',{tenantid:$stateParams.tenantid});   
	            };
	        
	        
	        
	        $scope.editRow = function (empId){
	           // alert(empId);
	            //$location.url('hrms/master/employeeMaster/edit?empId='+empId);
	            var empId=empId;
	            $state.go('app.master.employee.employeeMasteredit-Edit',{empId:empId});
	        }
	        $scope.view = function(obj){
	        	var empId=obj.empId;
	            $state.go('app.master.employee.employeeMasterview-View',{empId:empId});

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
	        };
	        
	        $rootScope.closeFileDialog = function() {
	            ngDialog.close();
	        };
	        
	        $rootScope.uploadEmployee = function() {
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
	                        url : $stateParams.tenantid+"/hrms/master/employeeAdminMaster/uploadExefile",
	                        data : frmData,
	                        contentType : false,
	                        processData : false,
	                        success : function(result) {
	                            console.log("result");
	                            console.log(result);
	                            if (result.success) {
	                                logger.logSuccess("File Uploaded Successfully");
	                                $scope.getEmployeeList();  
	                            } else {
	                                logger.logError("Fail to Upload");
	                            }

	                        }

	                    });
	                }

	            }
	        };
	        
	        // remove to the real data holder
	        $scope.deleteRow = function(empId, index) {
	            ngDialog.openConfirm().then(function() {
	                var myURL =$stateParams.tenantid+'/hrms/master/employeeAdminMaster/delete';
	                $http({
	                    method : 'post',
	                    url : myURL,
	                    data : empId,
	                }).success(function(data) {
	                    if (data == true) {
	                        $scope.displayedCollection.splice(index, 1);
	                        logger.logSuccess("Employee deleted successfully");
	                        $scope.getEmployeeList();
	                    } else {
	                        logger.logGeneric(data.message, data.type);
	                    }
	                }).error(function(data) {
	                    logger.logGeneric(data.message, data.type);                   
	                });
	                console.log('Modal promise resolved. Value: ');
	            }, function(reason) {
	                console.log('Modal promise rejected. Reason: ', reason);
	            });

	        };
	        
	        $scope.$watch('EmployeeMasterData.status1', function(newVal, oldVal) {

	            if (newVal != undefined && newVal != '') {
	             //alert(newVal);
	                
	              //Populate Grid
	                $scope.getEmployeeList = function() {
	                    $scope.dataLoopCount = 0;
	                    $scope.showEmptyLabel = false;
	                    $scope.from = 0;
	                    $scope.to = 100;
	                    var status1 = newVal
	                    $scope.rowCollection = [];
	                    var url = $stateParams.tenantid+'/hrms/master/employeeAdminMaster/list?limit=' + $scope.from + '&offset=' + $scope.to + '&status1=' + status1;
	                    $http.get(url).success(function(data) {
	                        console.log("data***************************************************");
	                        console.log(data);
	                        if (data.success == true) {
	                            $scope.rowCollection = $scope.rowCollection.concat(data.empDataList);
	                        }
	                    });
	                };
	                
	                $scope.getEmployeeList();   
	            }
	        });
	        
	                 
	
	    
	});
    