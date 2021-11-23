
    'use strict';

    app.controller('manageattendanceAddCtrl', function($scope, $state, $http, ngDialog, logger, $injector, $location,
    		sharedProperties, toaster, $rootScope, $timeout, validationService , $stateParams) {

        $scope.AttendanceMasterData = {
            dayOption : '',
            attendanceDate : '',
            attendanceId : '',
            hospitalName : '',
            branchName : '',
            departmentId : '',
            departmentCode : '',
            employeeId : 'E0092',
            employeeName : '',
            employeeListId : '',
            shiftId : '',
            shiftName : '',
            logInUser : '',
            shiftInTime : '',
            shiftOutTime : '',
toDate:'',
            isEdit : false

        };
        $scope.companyList=[];
        
    

        $http.post($stateParams.tenantid+'/app/hr/holiday/branchlist').success(function(data) {
	      	
      		$scope.branchList=data;
      		        		
    	});

        $scope.companyList=[{
        	id:'C0001',
        	text:'MBK'
        }]
        
        $('#inTime').datetimepicker({
       	 use24hours: true,
            format: 'HH:mm',
            pickDate: false,
       	 //use24hours: true
       })
         $('#attendanceDate').datetimepicker({
         format : 'DD/MM/YYYY'
     })
       $('#toDate').datetimepicker({
         format : 'DD/MM/YYYY'
     })
       
          $('#outTime').datetimepicker({
       	 use24hours: true,
            format: 'HH:mm',
            pickDate: false,
       	 //use24hours: true
       })
        $scope.disabled = false;
        $scope.isEdit = false;
        
        $scope.departmentList = [];
        $scope.shiftList = [];
        $scope.shiftTimeingValue = [];
        
        var d = new Date();
        var year = d.getFullYear();
        var month = d.getMonth() + 1;
        if (month < 10) {
            month = "0" + month;
        };
        var day = d.getDate();
        $scope.attendanceDate = day + "/" + month + "/" + year;
        $scope.AttendanceMasterData.attendanceDate = $scope.attendanceDate;
        
        $("#employeeListId").multiselect({
            maxHeight: 400,
            includeSelectAllOption: true,
            disableIfEmpty: true,
            numberDisplayed:4,
          });
        
       /* $scope.getCompanyList = function() {
            var formCode = document.getElementById('formCode').value;
            $http.post("app/commonUtility/getUserCompanyList", formCode).success(function(response) {
                $scope.companyList = response.companyList;
                if (response.companyList.length == 1) {
                    $scope.AttendanceMasterData.hospitalName = response.companyList[0].id;
                }
            })
        }
        $scope.getCompanyList();*/

        $http.get($stateParams.tenantid+'/app/commonUtility/getEmployeeList').success(function(datas) {
            $scope.employeeList = datas;
            }).error(function(datas) {
        });
        
       /* $http.get($stateParams.tenantid+'/app/hr/shiftreallocation/branchList').success(function(datas) {
            $scope.branchList = datas;
            }).error(function(datas) {
        });
        */

        $http.get($stateParams.tenantid+'/app/commonUtility/getDepartmentList').success(function(datas) {
            $scope.departmentList = datas;
            }).error(function(datas) {
        });
        
        
        /*
        $scope.$watch('AttendanceMasterData.hospitalName', function(newValue, oldValue) {
            if ($scope.AttendanceMasterData.hospitalName != "" && $scope.AttendanceMasterData.hospitalName != null) {
                $http.post("hrms/hr/employeeleave/branchlist", $scope.AttendanceMasterData.hospitalName).success(function(datas) {
                    $scope.branchList = datas.branchList;
                });
            }
        });

        $scope.$watch('AttendanceMasterData.branchName', function(newValue, oldValue) {
            if ($scope.AttendanceMasterData.branchName != "" && $scope.AttendanceMasterData.branchName != null) {
                $http.post("/app/hr/attendance/getDepartmentList", $scope.AttendanceMasterData.branchName).success(function(datas) {
                    $scope.departmentList = datas.departmentList;
                });
            }
        });*/
        $scope.$watch('AttendanceMasterData.departmentId', function(newValue, oldValue) {
            if (newValue != undefined && newValue != "") {
                $scope.shiftList = [];
                $scope.getShiftList();
                if (!$scope.AttendanceMasterData.isEdit) {
                    $scope.AttendanceMasterData.shiftId = "";
                }
            }
        });
        $scope.getShiftList = function() {
            if ($scope.AttendanceMasterData.isEdit != true) {
              //  $http.get('/app/hr/attendance/getShiftList').success(function(datas) {
                    $http.get($stateParams.tenantid+'/app/hr/attendance/getShiftList').success(function(datas) {

                    $scope.shiftList = datas.shiftList;
                    $scope.AttendanceMasterData.shiftInTime = datas.shiftList.shiftInTime;
                    $scope.AttendanceMasterData.shiftOutTime = datas.shiftList.shiftOutTime;
                }).error(function(data) {

                });
            }

        }
        
        $scope.getOptionId=function(option){
            return option.id;
        }
        
        $scope.$watch('AttendanceMasterData.shiftId', function(newValue, oldValue) {
            var shiftId = newValue;

            if (newValue != undefined && newValue != "") {
                $scope.AttendanceMasterData.shiftOutTime = "";
                $scope.AttendanceMasterData.shiftInTime = "";
                $scope.resultbean = {
                    branchName : $scope.AttendanceMasterData.branchName,
                    departmentId : $scope.AttendanceMasterData.departmentId,
                    shiftId : $scope.AttendanceMasterData.shiftId,
                    option : $scope.attendance,
                    attendanceDate : $scope.AttendanceMasterData.attendanceDate,
                    toDate : $scope.AttendanceMasterData.toDate
                };
                
                if($scope.isEdit==false){
                    $http.post($stateParams.tenantid+'/app/hr/attendance/getEmpList', $scope.resultbean).success(function(datas) {
                        
                        if(datas.success){
                            $scope.disabled = true;
                            $scope.employeeList = datas.employeeList;
                            $timeout(function() {
                                $('#employeeListId').multiselect('deselectAll', false);
                                $('#employeeListId').multiselect('updateButtonText');
                                $("#employeeListId").multiselect('rebuild');
                            }, 2, false);
                            $scope.AttendanceMasterData.shiftInTime = datas.manualattendance.shiftInTime;
                            $scope.AttendanceMasterData.shiftOutTime = datas.manualattendance.shiftOutTime;
                        }else{
                            $scope.employeeList = [];
                            $scope.AttendanceMasterData.employeeListId = '';
                        }
                    }).error(function(data) {
                    });
                }

            }
        });
        
        $scope.submit = function(attendanceAddForm, AttendanceMasterData) {
            debugger;
                if (AttendanceMasterData.isEdit != true) {
                    var saveData = $scope.AttendanceMasterData;
                    $scope.AttendanceMasterData.employeeId = AttendanceMasterData.employeeId;
                    
                    var employee=$scope.AttendanceMasterData.employeeListId;
                    if(employee!="" && employee!=null && employee!=undefined){
                        if($scope.AttendanceMasterData.employeeListId!=null && $scope.AttendanceMasterData.employeeListId!=undefined && $scope.AttendanceMasterData.employeeListId!=''){
                            var percentAppliedValue= $scope.AttendanceMasterData.employeeListId;
                            var employeeList=[];
                            var employeeListStr = '';
                            var j=0;
                            for(var i=0;i<$scope.AttendanceMasterData.employeeListId.length;i++){
                                    employeeList.push($scope.AttendanceMasterData.employeeListId[i].id);
                                j++;
                            }
                        }
                        $scope.AttendanceMasterData.employeeListId=employeeList;
                    }else{
                        $scope.AttendanceMasterData.employeeListId=null;
                    }
                    
                   // $http.post("/app/hr/attendance/save", saveData).success(function(result) {
                        $http.post($stateParams.tenantid+'/app/hr/attendance/save',saveData).success(function(result) {

                        if (result.success == false) {
                            if (result.errorMessage != null && result.errorMessage != '' && result.errorMessage != undefined) {
                                logger.logError(result.errorMessage);
                            } else {
                                logger.logError("Unable to Save");
                            }
                        } else {
                            logger.logSuccess("Saved Successfully!");
                            $state.go('app.hr.manageattendance.list');
                        }
                    });
                }
            
        };

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

        $scope.$watch('AttendanceMasterData.toDate', function(newValue, oldValue) {
            if (newValue !== undefined && newValue !== "") {
                if ($scope.AttendanceMasterData.attendanceDate != undefined && $scope.AttendanceMasterData.attendanceDate != '') {
                    var todayDate = $scope.date;
                    var fromDate = $scope.AttendanceMasterData.attendanceDate;
                    var toDate = newValue;
                    fromDate = fromDate.split("/");
                    fromDate = new Date(fromDate[2], fromDate[1] - 1, fromDate[0]);
                    toDate = toDate.split("/");
                    toDate = new Date(toDate[2], toDate[1] - 1, toDate[0]);
                    todayDate = todayDate.split("/");
                    todayDate = new Date(todayDate[2], todayDate[1] - 1, todayDate[0]);
                    if (toDate <= todayDate && toDate > fromDate) {

                    } else {
                        logger.logError("To date should be greater than from date and lesser than or equval to current date!");
                        $scope.AttendanceMasterData.toDate = '';
                    }
                }
            }
        });

        $scope.$watch('AttendanceMasterData.attendanceDate', function(newValue, oldValue) {

            if (newValue !== undefined && newValue !== "") {
                var todayDate = $scope.date;
                var toDate = newValue;
                toDate = toDate.split("/");
                toDate = new Date(toDate[2], toDate[1] - 1, toDate[0]);
                todayDate = todayDate.split("/");
                todayDate = new Date(todayDate[2], todayDate[1] - 1, todayDate[0]);
                if (toDate <= todayDate) {
                } else {
                    logger.logError("From date should be lesser than or equval to current date!");
                    var d = new Date();
                    var year = d.getFullYear();
                    var month = d.getMonth() + 1;
                    if (month < 10) {
                        month = "0" + month;
                    }
                    ;
                    var day = d.getDate();
                    $scope.attendanceDate = day + "/" + month + "/" + year;
                    $scope.AttendanceMasterData.attendanceDate = $scope.attendanceDate;
                }

            }
        });

        $scope.reset = function(attendanceAddForm) {
            if ($scope.AttendanceMasterData.isEdit == false) {

                $scope.AttendanceMasterData.hospitalName = '';
                $scope.AttendanceMasterData.branchName = '';
                $scope.AttendanceMasterData.attendanceDate = '';
                $scope.AttendanceMasterData.inTime = '';
                $scope.AttendanceMasterData.shiftInTime = '';
                $scope.AttendanceMasterData.outTime = '';
                $scope.AttendanceMasterData.departmentId = '';
                $scope.AttendanceMasterData.shiftId = '';
                $scope.AttendanceMasterData.employeeListId = '';
                $scope.AttendanceMasterData.shiftOutTime = '';
            } else {

                $http.post($stateParams.tenantid+'/app/hr/attendance/edit', attendanceId).success(function(result) {
                    if (result.isEdit != false) {
                        logger.logError("Please Try Again");
                    } else {
                        $("#empid").attr('disabled', true);
                        $("#deptid").prop('disabled', true);
                        $("#shifid").prop('disabled', true);
                        var departmentId = result.departmentId;
                        $scope.getemployeeList(departmentId);
                        $scope.AttendanceMasterData = result;
                        $scope.AttendanceMasterData.shiftId = result.shiftId.toString();
                        $scope.AttendanceMasterData.departmentId = result.departmentId.toString();
                        $scope.AttendanceMasterData.isEdit = true;
                        $scope.employeeChange();
                        var shiftId = result.shiftId;
                        $scope.getemployeeList(shiftId);
                    }

                }).error(function(data) {

                });
            }
        }

        $scope.getEmployeeDetails = function() {

            $http.get($stateParams.tenantid+"/app/hr/attendance/getUserDetail").success(function(datas) {
                $scope.AttendanceMasterData.logInUser = datas.logInUser;
            })
        }
        $scope.getEmployeeDetails();

        $scope.cancel = function() {
            $state.go('app.hr.manageattendance.list');
        };
    });
    
    app.controller('manualAttendanceEditCtrl', function($stateParams,$scope, $state, $http, ngDialog,
    		logger, $injector, $location, sharedProperties, toaster, $rootScope, $timeout, validationService) {
//alert(7);
        $scope.AttendanceMasterData = {
            dayOption : '',
            attendanceDate : '',
            attendanceId : '',
            inTime :'',
            outTime : '',
            hospitalName : '',
            branchName : '',
            departmentId : '',
            departmentCode : '',
            employeeId : '',
            employeeName : '',
            employeeListId : '',
            shiftId : '',
            shiftName : '',
            // selected:[],
            logInUser : '',
            shiftInTime : '',
            shiftOutTime : '',
            toDate:'',
            isEdit : true

        };
        $scope.disabled = true;
        $scope.isEdit = true;
        
        $scope.departmentList = [];
        $scope.shiftList = [];
        $scope.shiftTimeingValue = [];
        
        // Current Date for from date
        var d = new Date();
        var year = d.getFullYear();
        var month = d.getMonth() + 1;
        if (month < 10) {
            month = "0" + month;
        };
        var day = d.getDate();
        $scope.attendanceDate = day + "/" + month + "/" + year;
        $scope.AttendanceMasterData.attendanceDate = $scope.attendanceDate;
        
        $("#employeeListId").multiselect({
            maxHeight: 400,
            includeSelectAllOption: true,
            disableIfEmpty: true,
            numberDisplayed:4
          });
        
        $("#multiselect-button").addClass("width_100 input-sm line-height-5");
        
        $scope.getCompanyList = function() {
            var formCode = document.getElementById('formCode').value;
            $http.post("app/commonUtility/getUserCompanyList", formCode).success(function(response) {
                $scope.companyList = response.companyList;
                if (response.companyList.length == 1) {
                    $scope.AttendanceMasterData.hospitalName = response.companyList[0].id;
                }

                $scope.AttendanceMasterData = {
                    dayOption : '',
                    attendanceDate : '',
                    attendanceId : '',
                    // inTime :'',
                    // outTime : '',
                    hospitalName : '',
                    branchName : '',
                    departmentId : '',
                    departmentCode : '',
                    employeeId : '',
                    employeeName : '',
                    employeeListId : '',
                    shiftId : '',
                    shiftName : '',
                    // selected:[],
                    // toDate:'',
                    logInUser : '',
                    shiftInTime : '',
                    shiftOutTime : '',
                    toDate:'',
                    isEdit : true

                };
                $scope.disabled = true;
                $scope.isEdit = true;
                
                $scope.departmentList = [];
                $scope.shiftList = [];
                $scope.shiftTimeingValue = [];
                
                // Current Date for from date
                var d = new Date();
                var year = d.getFullYear();
                var month = d.getMonth() + 1;
                if (month < 10) {
                    month = "0" + month;
                };
                var day = d.getDate();
                $scope.attendanceDate = day + "/" + month + "/" + year;
                $scope.AttendanceMasterData.attendanceDate = $scope.attendanceDate;
                
                $("#employeeListId").multiselect({
                    maxHeight: 400,
                    includeSelectAllOption: true,
                    disableIfEmpty: true,
                    numberDisplayed:4
                  });
                
                $("#multiselect-button").addClass("width_100 input-sm line-height-5");
                
                $scope.getCompanyList = function() {
                    var formCode = document.getElementById('formCode').value;
                    $http.post("app/commonUtility/getUserCompanyList", formCode).success(function(response) {
                        $scope.companyList = response.companyList;
                        if (response.companyList.length == 1) {
                            $scope.AttendanceMasterData.hospitalName = response.companyList[0].id;
                        }
                    })
                }
                $scope.getCompanyList();

                $scope.$watch('AttendanceMasterData.hospitalName', function(newValue, oldValue) {
                    if ($scope.AttendanceMasterData.hospitalName != "" && $scope.AttendanceMasterData.hospitalName != null) {
                       /* $http.post("hrms/hr/employeeleave/branchlist", $scope.AttendanceMasterData.hospitalName).success(function(datas) {
                            $scope.branchList = datas.branchList;
                        });*/
                    }
                });

                $scope.$watch('AttendanceMasterData.branchName', function(newValue, oldValue) {
                    if ($scope.AttendanceMasterData.branchName != "" && $scope.AttendanceMasterData.branchName != null) {
                        $http.post("/app/hr/attendance/getDepartmentList", $scope.AttendanceMasterData.branchName).success(function(datas) {
                            $scope.departmentList = datas.departmentList;
                        });
                    }
                });

                $scope.$watch('AttendanceMasterData.departmentId', function(newValue, oldValue) {
                    if (newValue != undefined && newValue != "") {
                        $scope.shiftList = [];
                        $scope.getShiftList();
                        if (!$scope.AttendanceMasterData.isEdit) {
                            $scope.AttendanceMasterData.shiftId = "";
                        }
                    }
                });
                $scope.getShiftList = function() {
                    if ($scope.AttendanceMasterData.isEdit != true) {
                        $http.get($stateParams.tenantid+'/app/hr/attendance/getShiftList').success(function(datas) {
                            $scope.shiftList = datas.shiftList;
                            $scope.AttendanceMasterData.shiftInTime = datas.shiftList.shiftInTime;
                            $scope.AttendanceMasterData.shiftOutTime = datas.shiftList.shiftOutTime;
                        }).error(function(data) {

                        });
                    }

                }
                
                $scope.getOptionId=function(option){
                    return option.id;
                }
                
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

                $scope.$watch('AttendanceMasterData.toDate', function(newValue, oldValue) {
                    if (newValue !== undefined && newValue !== "") {
                        if ($scope.AttendanceMasterData.attendanceDate != undefined && $scope.AttendanceMasterData.attendanceDate != '') {
                            var todayDate = $scope.date;
                            var fromDate = $scope.AttendanceMasterData.attendanceDate;
                            var toDate = newValue;
                            fromDate = fromDate.split("/");
                            fromDate = new Date(fromDate[2], fromDate[1] - 1, fromDate[0]);
                            toDate = toDate.split("/");
                            toDate = new Date(toDate[2], toDate[1] - 1, toDate[0]);
                            todayDate = todayDate.split("/");
                            todayDate = new Date(todayDate[2], todayDate[1] - 1, todayDate[0]);
                            if (toDate <= todayDate && toDate > fromDate) {

                            } else {
                                logger.logError("To date should be greater than from date and lesser than or equval to current date!");
                                $scope.AttendanceMasterData.toDate = '';
                            }
                        }
                    }
                });

                $scope.$watch('AttendanceMasterData.attendanceDate', function(newValue, oldValue) {

                    if (newValue !== undefined && newValue !== "") {
                        var todayDate = $scope.date;
                        var toDate = newValue;
                        toDate = toDate.split("/");
                        toDate = new Date(toDate[2], toDate[1] - 1, toDate[0]);
                        todayDate = todayDate.split("/");
                        todayDate = new Date(todayDate[2], todayDate[1] - 1, todayDate[0]);
                        if (toDate <= todayDate) {
                        } else {
                            logger.logError("From date should be lesser than or equval to current date!");
                            var d = new Date();
                            var year = d.getFullYear();
                            var month = d.getMonth() + 1;
                            if (month < 10) {
                                month = "0" + month;
                            }
                            ;
                            var day = d.getDate();
                            $scope.attendanceDate = day + "/" + month + "/" + year;
                            $scope.AttendanceMasterData.attendanceDate = $scope.attendanceDate;
                        }

                    }
                });
             /*   var attendanceId = $location.search().attendanceId;

                $scope.isEdit = false;
                if(attendanceId != 0){
              //      console.log(holidayId);
                    $scope.isEdit = true;
                    
                    $http.post($stateParams.tenantid+'/app/hr/attendance/edit', attendanceId).success(function(result) {
                           $scope.AttendanceMasterData = result;
                          


                    });
                }*/
                
                var attendanceId = $location.search().attendanceId;
                if (attendanceId == undefined) {
                    $scope.AttendanceMasterData.isEdit = true;
                } else {
                    $http.post($stateParams.tenantid+'/app/hr/attendance/edit', attendanceId).success(function(result) {
                        if (result.isEdit != false) {
                            logger.logError("Please Try Again");
                        } else {
                            
                            $scope.empList = [];
                            $scope.AttendanceMasterData = result;
                            $scope.AttendanceMasterData.shiftName = result.shiftName;
                            $scope.AttendanceMasterData.departmentId = result.departmentId;
                            $scope.AttendanceMasterData.inTime = result.inTime;
                            $scope.AttendanceMasterData.outTime = result.outTime;
                            $scope.AttendanceMasterData.shiftInTime = result.shiftInTime;
                            $scope.AttendanceMasterData.shiftOutTime = result.shiftOutTime;
                            $scope.AttendanceMasterData.shiftId = result.shiftId;
                            $scope.AttendanceMasterData.hospitalName = "IA";

                            $scope.AttendanceMasterData.isEdit = true;
                            
                            $scope.resultbean = {
                                branchName : $scope.AttendanceMasterData.branchName,
                                departmentId : $scope.AttendanceMasterData.departmentId,
                                shiftId : $scope.AttendanceMasterData.shiftId,
                                option : $scope.attendance,
                                attendanceDate : $scope.AttendanceMasterData.attendanceDate,
                                toDate : $scope.AttendanceMasterData.toDate
                            };
                                
                            $http.post($stateParams.tenantid+'/app/hr/attendance/getEmpList', $scope.resultbean).success(function(datas) {
                                
                                if(datas.success){
                                    $scope.employeeList = datas.employeeList;
                                   
                                    $scope.empName = '';
                                    var empStr = '';
                                    var j=0;
                                    if(result.employeeListId!="" && result.employeeListId!=null && result.employeeListId!=undefined){
                                        for(var i=0;i<result.employeeListId.length;i++){
                                            angular.forEach($scope.employeeList,function(value,key){
                                                if(result.employeeListId[i]==value.id){
                                                    empStr=empStr+value.text;
                                                    j++;
                                                    
                                                    if(j < result.employeeListId.length){
                                                        empStr=empStr+",";
                                                    }
                                                }
                                            });
                                            $scope.empName = empStr;
                                            $scope.AttendanceMasterData.employeeListId = $scope.empList;
                                        }

                                    }
                                    
                                }
                            }).error(function(data) {
                            });
                            
                        }

                    }).error(function(data) {

                    });
                }

                $scope.update = function(attendanceAddForm, AttendanceMasterData) {
                        var updateData = $scope.AttendanceMasterData;
                        $scope.getEmployeeDetails();
                        var userLog = $scope.AttendanceMasterData.logInUser;
                        
                        var employee=$scope.AttendanceMasterData.employeeListId;
                        if(employee!="" && employee!=null && employee!=undefined){
                            if($scope.AttendanceMasterData.employeeListId!=null && $scope.AttendanceMasterData.employeeListId!=undefined && $scope.AttendanceMasterData.employeeListId!=''){
                                var percentAppliedValue= $scope.AttendanceMasterData.employeeListId;
                                var employeeList=[];
                                var employeeListStr = '';
                                var j=0;
                                for(var i=0;i<$scope.AttendanceMasterData.employeeListId.length;i++){
                                        employeeList.push($scope.AttendanceMasterData.employeeListId[i].id);
                                    j++;
                                }
                            }
                            $scope.AttendanceMasterData.employeeListId=employeeList;
                        }else{
                            $scope.AttendanceMasterData.employeeListId=null;
                        }
                        
                        $http.post($stateParams.tenantid+"/app/hr/attendance/update", updateData).success(function(response) {
                            if (response == true) {
                                logger.logSuccess("Updated Successfully!");
                                $state.go("app.hrms.hr.attendance.manualattendance.list");
                            } else {
                                logger.logError("Unable to update!");
                            }
                        });
                 
                };

                $scope.reset = function(attendanceAddForm) {
                    if ($scope.AttendanceMasterData.isEdit == false) {

                        $scope.AttendanceMasterData.hospitalName = '';
                        $scope.AttendanceMasterData.branchName = '';
                        $scope.AttendanceMasterData.attendanceDate = '';
                        $scope.AttendanceMasterData.inTime = '';
                        $scope.AttendanceMasterData.shiftInTime = '';
                        $scope.AttendanceMasterData.outTime = '';
                        $scope.AttendanceMasterData.departmentId = '';
                        $scope.AttendanceMasterData.shiftId = '';
                        $scope.AttendanceMasterData.employeeListId = '';
                        $scope.AttendanceMasterData.shiftOutTime = '';
                    } else {

                        $http.post($stateParams.tenantid+'/app/hr/attendance/edit', attendanceId).success(function(result) {
                            if (result.isEdit != false) {
                                logger.logError("Please Try Again");
                            } else {
                                $("#empid").attr('disabled', true);
                                $("#deptid").prop('disabled', true);
                                $("#shifid").prop('disabled', true);
                                var departmentId = result.departmentId;
                                $scope.getemployeeList(departmentId);
                                $scope.AttendanceMasterData = result;
                                $scope.AttendanceMasterData.shiftId = result.shiftId.toString();
                                $scope.AttendanceMasterData.departmentId = result.departmentId.toString();
                                $scope.AttendanceMasterData.isEdit = true;
                                $scope.employeeChange();
                                var shiftId = result.shiftId;
                                $scope.getemployeeList(shiftId);
                            }

                        }).error(function(data) {

                        });
                    }
                }

                $scope.getEmployeeDetails = function() {

                    $http.get($stateParams.tenantid+"/app/hr/attendance/getUserDetail").success(function(datas) {
                        $scope.AttendanceMasterData.logInUser = datas.logInUser;
                    })
                }
                $scope.getEmployeeDetails();

                $scope.cancel = function() {
                    $state.go('app.hr.manageattendance.list');
                };
            
            })
        }
        $scope.getCompanyList();

        $scope.$watch('AttendanceMasterData.hospitalName', function(newValue, oldValue) {
            if ($scope.AttendanceMasterData.hospitalName != "" && $scope.AttendanceMasterData.hospitalName != null) {
               /* $http.post("hrms/hr/employeeleave/branchlist", $scope.AttendanceMasterData.hospitalName).success(function(datas) {
                    $scope.branchList = datas.branchList;
                });*/
            }
        });

        $scope.$watch('AttendanceMasterData.branchName', function(newValue, oldValue) {
            if ($scope.AttendanceMasterData.branchName != "" && $scope.AttendanceMasterData.branchName != null) {
                $http.post("/app/hr/attendance/getDepartmentList", $scope.AttendanceMasterData.branchName).success(function(datas) {
                    $scope.departmentList = datas.departmentList;
                });
            }
        });

        $scope.$watch('AttendanceMasterData.departmentId', function(newValue, oldValue) {
            if (newValue != undefined && newValue != "") {
                $scope.shiftList = [];
                $scope.getShiftList();
                if (!$scope.AttendanceMasterData.isEdit) {
                    $scope.AttendanceMasterData.shiftId = "";
                }
            }
        });
        $scope.getShiftList = function() {
            if ($scope.AttendanceMasterData.isEdit != true) {
                $http.get($stateParams.tenantid+'/app/hr/attendance/getShiftList').success(function(datas) {
                    $scope.shiftList = datas.shiftList;
                    $scope.AttendanceMasterData.shiftInTime = datas.shiftList.shiftInTime;
                    $scope.AttendanceMasterData.shiftOutTime = datas.shiftList.shiftOutTime;
                }).error(function(data) {

                });
            }

        }
        
        $scope.getOptionId=function(option){
            return option.id;
        }
        
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

        $scope.$watch('AttendanceMasterData.toDate', function(newValue, oldValue) {
            if (newValue !== undefined && newValue !== "") {
                if ($scope.AttendanceMasterData.attendanceDate != undefined && $scope.AttendanceMasterData.attendanceDate != '') {
                    var todayDate = $scope.date;
                    var fromDate = $scope.AttendanceMasterData.attendanceDate;
                    var toDate = newValue;
                    fromDate = fromDate.split("/");
                    fromDate = new Date(fromDate[2], fromDate[1] - 1, fromDate[0]);
                    toDate = toDate.split("/");
                    toDate = new Date(toDate[2], toDate[1] - 1, toDate[0]);
                    todayDate = todayDate.split("/");
                    todayDate = new Date(todayDate[2], todayDate[1] - 1, todayDate[0]);
                    if (toDate <= todayDate && toDate > fromDate) {

                    } else {
                        logger.logError("To date should be greater than from date and lesser than or equval to current date!");
                        $scope.AttendanceMasterData.toDate = '';
                    }
                }
            }
        });

        $scope.$watch('AttendanceMasterData.attendanceDate', function(newValue, oldValue) {

            if (newValue !== undefined && newValue !== "") {
                var todayDate = $scope.date;
                var toDate = newValue;
                toDate = toDate.split("/");
                toDate = new Date(toDate[2], toDate[1] - 1, toDate[0]);
                todayDate = todayDate.split("/");
                todayDate = new Date(todayDate[2], todayDate[1] - 1, todayDate[0]);
                if (toDate <= todayDate) {
                } else {
                    logger.logError("From date should be lesser than or equval to current date!");
                    var d = new Date();
                    var year = d.getFullYear();
                    var month = d.getMonth() + 1;
                    if (month < 10) {
                        month = "0" + month;
                    }
                    ;
                    var day = d.getDate();
                    $scope.attendanceDate = day + "/" + month + "/" + year;
                    $scope.AttendanceMasterData.attendanceDate = $scope.attendanceDate;
                }

            }
        });
        /*var attendanceId = $location.search().attendanceId;

        $scope.isEdit = false;
        if(attendanceId != 0){
      //      console.log(holidayId);
            $scope.isEdit = true;
            
            $http.post($stateParams.tenantid+'/app/hr/attendance/edit', attendanceId).success(function(result) {
                   $scope.AttendanceMasterData = result;
                  


            });
        }
        */
        var attendanceId = $location.search().attendanceId;
        if (attendanceId == undefined) {
            $scope.AttendanceMasterData.isEdit = true;
        } else {
            $http.post($stateParams.tenantid+'/app/hr/attendance/edit', attendanceId).success(function(result) {
                if (result.isEdit != false) {
                    logger.logError("Please Try Again");
                } else {
                    
                    $scope.empList = [];
                    $scope.AttendanceMasterData = result;
                    $scope.AttendanceMasterData.shiftName = result.shiftName;
                    $scope.AttendanceMasterData.departmentId = result.departmentId;
                    $scope.AttendanceMasterData.inTime = result.inTime;
                    $scope.AttendanceMasterData.outTime = result.outTime;
                    $scope.AttendanceMasterData.shiftInTime = result.shiftInTime;
                    $scope.AttendanceMasterData.shiftOutTime = result.shiftOutTime;
                    $scope.AttendanceMasterData.shiftId = result.shiftId;
                            $scope.AttendanceMasterData.hospitalName = "IA";

                    $scope.AttendanceMasterData.isEdit = true;
                    
                    $scope.resultbean = {
                        branchName : $scope.AttendanceMasterData.branchName,
                        departmentId : $scope.AttendanceMasterData.departmentId,
                        shiftId : $scope.AttendanceMasterData.shiftId,
                        option : $scope.attendance,
                        attendanceDate : $scope.AttendanceMasterData.attendanceDate,
                        toDate : $scope.AttendanceMasterData.toDate
                    };
                        
                    $http.post($stateParams.tenantid+'/app/hr/attendance/getEmpList', $scope.resultbean).success(function(datas) {
                        
                        if(datas.success){
                            $scope.employeeList = datas.employeeList;
                           
                            $scope.empName = '';
                            var empStr = '';
                            var j=0;
                            if(result.employeeListId!="" && result.employeeListId!=null && result.employeeListId!=undefined){
                                for(var i=0;i<result.employeeListId.length;i++){
                                    angular.forEach($scope.employeeList,function(value,key){
                                        if(result.employeeListId[i]==value.id){
                                            empStr=empStr+value.text;
                                            j++;
                                            
                                            if(j < result.employeeListId.length){
                                                empStr=empStr+",";
                                            }
                                        }
                                    });
                                    $scope.empName = empStr;
                                    $scope.AttendanceMasterData.employeeListId = $scope.empList;
                                }

                            }
                            
                        }
                    }).error(function(data) {
                    });
                    
                }

            }).error(function(data) {

            });
        }

        $scope.update = function(attendanceAddForm, AttendanceMasterData) {

                var updateData = $scope.AttendanceMasterData;
                $scope.getEmployeeDetails();
                var userLog = $scope.AttendanceMasterData.logInUser;
                
                var employee=$scope.AttendanceMasterData.employeeListId;
                if(employee!="" && employee!=null && employee!=undefined){
                    if($scope.AttendanceMasterData.employeeListId!=null && $scope.AttendanceMasterData.employeeListId!=undefined && $scope.AttendanceMasterData.employeeListId!=''){
                        var percentAppliedValue= $scope.AttendanceMasterData.employeeListId;
                        var employeeList=[];
                        var employeeListStr = '';
                        var j=0;
                        for(var i=0;i<$scope.AttendanceMasterData.employeeListId.length;i++){
                                employeeList.push($scope.AttendanceMasterData.employeeListId[i].id);
                            j++;
                        }
                    }
                    $scope.AttendanceMasterData.employeeListId=employeeList;
                }else{
                    $scope.AttendanceMasterData.employeeListId=null;
                }
                
                $http.post($stateParams.tenantid+"/app/hr/attendance/update", updateData).success(function(response) {
                    if (response == true) {
                        logger.logSuccess("Updated Successfully!");
                        $state.go('app.hr.manageattendance.list');
                    } else {
                        logger.logError("Unable to update!");
                    }
                });
            
        };

        $scope.reset = function(attendanceAddForm) {
            if ($scope.AttendanceMasterData.isEdit == false) {

                $scope.AttendanceMasterData.hospitalName = '';
                $scope.AttendanceMasterData.branchName = '';
                $scope.AttendanceMasterData.attendanceDate = '';
                $scope.AttendanceMasterData.inTime = '';
                $scope.AttendanceMasterData.shiftInTime = '';
                $scope.AttendanceMasterData.outTime = '';
                $scope.AttendanceMasterData.departmentId = '';
                $scope.AttendanceMasterData.shiftId = '';
                $scope.AttendanceMasterData.employeeListId = '';
                $scope.AttendanceMasterData.shiftOutTime = '';
            } else {

                $http.post($stateParams.tenantid+'/app/hr/attendance/edit', attendanceId).success(function(result) {
                    if (result.isEdit != false) {
                        logger.logError("Please Try Again");
                    } else {
                        $("#empid").attr('disabled', true);
                        $("#deptid").prop('disabled', true);
                        $("#shifid").prop('disabled', true);
                        var departmentId = result.departmentId;
                        $scope.getemployeeList(departmentId);
                        $scope.AttendanceMasterData = result;
                        $scope.AttendanceMasterData.shiftId = result.shiftId.toString();
                        $scope.AttendanceMasterData.departmentId = result.departmentId.toString();
                        $scope.AttendanceMasterData.isEdit = true;
                        $scope.employeeChange();
                        var shiftId = result.shiftId;
                        $scope.getemployeeList(shiftId);
                    }

                }).error(function(data) {

                });
            }
        }

        $scope.getEmployeeDetails = function() {

            $http.get($stateParams.tenantid+"/app/hr/attendance/getUserDetail").success(function(datas) {
                $scope.AttendanceMasterData.logInUser = datas.logInUser;
            })
        }
        $scope.getEmployeeDetails();

        $scope.cancel = function() {
            $state.go('app.hr.manageattendance.list');
        };
    });
