	
    'use strict';

    app.controller('hrattendanceAddCtrl', function($scope, $stateParams , $state, $http, ngDialog,
    		logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService) {

        $scope.isEdit = false;

        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages = 0;

        $scope.hrmanageAttendance = {
            attendanceId : '',
            courseId : '',
            courseName : '',
            batchId : '',
            batchName : '',
            empId :'',
            subjectId : '',
            subjectName : '',
            departmentId : '',
            departmentName : '',
            disciplineId : '',
            disciplineName : '',
            semesterId : '',
            semesterName : '',
            academicYearId : '',
            employeeId : '',
            firstName : '',
            remarks :'',
            attendanceDate : '',
            lHrManageAttendanceEmployee : []
        }
        var resetTemp = angular.copy($scope.hrmanageAttendance);
        $scope.reset = function(){
          $scope.hrmanageAttendance = 
          { 
                  attendanceId : '',
                  courseId : '',
                  empId :'',
                  courseName : '',
                  batchId : '',
                  batchName : '',
                  subjectId : '',
                  subjectName : '',
                  departmentId : '',
                  departmentName : '',
                  disciplineId : '',
                  disciplineName : '',
                  semesterId : '',
                  semesterName : '',
                  academicYearId : '',
                  acadamicYear:'',
                  
                  employeeId : '',
                  firstName : '',
                  remarks :'',
                  attendanceDate : '',
                  lHrManageAttendanceEmployee : []
           }
        }
        $scope.checkFull = false;

        var editacademicyearId = $location.search().academicyearId;
        var attendanceDate = $location.search().attendanceDate;

        /*$http.get('hrms/hr/attendance/hrmanageattendance/getAcademicYear').success(function(data) {
           
            $scope.academicYearList=data.academicList;
            
            
           });*/
        
        
        $scope.academicYearList = [ {
            id : '2015-16',
            text : '2015-16'
        }, {
            id : '2016-17',
            text : '2016-17'
        } ,
        
        {
            id : '2017-18',
            text : '2017-18'
        } ,
        {
            id : '2018-19',
            text : '2018-19'
        },
        
        {
            id : '2019-20',
            text : '2019-20'
        }];

        
        

        $scope.makeTrue = function() {
            if ($scope.checkFull) {
                for (var i = 0; i < $scope.hrmanageAttendance.lHrManageAttendanceEmployee.length; i++) {
                    $scope.hrmanageAttendance.lHrManageAttendanceEmployee[i].attendance = true;
                }
            } else if (!$scope.checkFull) {
                for (var i = 0; i < $scope.hrmanageAttendance.lHrManageAttendanceEmployee.length; i++) {
                    $scope.hrmanageAttendance.lHrManageAttendanceEmployee[i].attendance = false;
                }
            }
        }
        
        $scope.makeTrue1 = function() {
            if ($scope.checkFull1) {
                for (var i = 0; i < $scope.hrmanageAttendance.lHrManageAttendanceEmployee.length; i++) {
                    $scope.hrmanageAttendance.lHrManageAttendanceEmployee[i].onDuty = true;
                }
            } else if (!$scope.checkFull1) {
                for (var i = 0; i < $scope.hrmanageAttendance.lHrManageAttendanceEmployee.length; i++) {
                    $scope.hrmanageAttendance.lHrManageAttendanceEmployee[i].onDuty = false;
                }
            }
        }
        
        
        $http.get($stateParams.tenantid+'/app/commonUtility/getDepartmentList').success(function(datas) {
            $scope.departmentList = datas;
            }).error(function(datas) {
        });
        
        
      /*  $http.get('hrms/hr/attendance/hrmanageattendance/getDepartmentName').success(function(data) {
            $scope.departmentList = data.departmentName;
        });*/

        $http.get('hrms/hr/attendance/hrmanageattendance/getFirstName').success(function(data) {
            $scope.firstList = data.firstnameList;
        });

        $scope.viewList = function() {
            $scope.hrmanageAttendance.lHrManageAttendanceEmployee=[];
         //  $http.post('hrms/hr/attendance/hrmanageattendance/getEmployeeList', $scope.hrmanageAttendance).success(function(data) {
                $http.post($stateParams.tenantid+"/app/hr/hrmanageattendance/getEmployeeList", $scope.hrmanageAttendance).success(function(data) {

                console.log(data)
                $scope.hrmanageAttendance.lHrManageAttendanceEmployee = data.employeeList;

            });
        }

        $scope.validate = function(hrmanageAttendance, hrmanageAttendanceForm) {
            if (new validationService().checkFormValidity(hrmanageAttendanceForm)) {
                if (!$scope.isEdit) {
                    $scope.saveManageAtten(hrmanageAttendance, hrmanageAttendanceForm);
                } else {
                    $scope.updateManageAtten(hrmanageAttendance, hrmanageAttendanceForm);
                }
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(hrmanageAttendanceForm.$validationSummary), 5000, 'trustedHtml');
            }
        }

        // employeeList
        $scope.saveManageAtten = function(hrmanageAttendance, hrmanageAttendanceForm) {
            var save = true;

            console.log("add")
            console.log(hrmanageAttendance);

            if (save) {
               // $http.post('hrms/hr/attendance/hrmanageattendance/saveHrManageAttendance', $scope.hrmanageAttendance).success(function(data) {
                 $http.post($stateParams.tenantid+"/app/hr/hrmanageattendance/saveHrManageAttendance", $scope.hrmanageAttendance).success(function(data) {

                	
                	logger.logSuccess("Saved SuccessFully")
                    $state.go('app.hr.hrmanageattendance.list');
                });
            } else {
                logger.logError("Unable to save for Completed Course");
            }

        }
        
        $scope.cancel = function() {
            $state.go("app.hr.hrmanageattendance.list");
        }
        
        

        $scope.reset = function() {
            if ($scope.isEdit == true) {
                $scope.editList();
            } else {
               
                $scope.hrmanageAttendance = angular.copy(resetTemp);
            }
        };

        
        
        
        

    });

    app.controller('hrmanageattendanceEditCtrl', function($scope, $state, $http, $stateParams , $location, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, validationService) {

        $scope.isUpdate = true;
        $scope.isEdit = true;
        
        $scope.isShow = true;
        
        
        
   /*     $http.get('hrms/hr/attendance/hrmanageattendance/getAcademicYear').success(function(data) {
            
            $scope.hrmanageAttendance.acadamicYear=data.academicList[0].text;
            
            
           });*/
        $scope.academicYearList = [ {
            id : '2015-16',
            text : '2015-16'
        }, {
            id : '2016-17',
            text : '2016-17'
        } ,
        
        {
            id : '2017-18',
            text : '2017-18'
        } ,
        {
            id : '2018-19',
            text : '2018-19'
        },
        {
            id : '2019-20',
            text : '2019-20'
        }];

      
       // $http.get('hrms/hr/attendance/hrmanageattendance/editHrManageAttendance').success(function(data) {
        $http.get($stateParams.tenantid+"/app/hr/hrmanageattendance/edit").success(function(data) {

            $scope.employeelist = data.employeeList;

        });

        $scope.hrmanageAttendance = {
            departmentId : '',
            
            departmentName : '',
            attendanceDate : '',
            onDuty : '',
            attendance : '',
            admissionNo : '',
         //   attendanceDetailId : '',
            attendanceId : '',
            empId :'',
            firstName :'',
            employeeName : '',
          //  mngStatus : '',
            remarks : '',
            academicYearCode : '',
            academicYearId : '',
            lHrManageAttendanceEmployee : []

        }

        
        $http.get($stateParams.tenantid+'/app/commonUtility/getDepartmentList').success(function(datas) {
            $scope.departmentList = datas;
            }).error(function(datas) {
        });
        
       /* $http.get('hrms/hr/attendance/hrmanageattendance/getDepartmentName').success(function(data) {
            $scope.departmentList = data.departmentName;
        });*/
        
       // var attendanceId = $stateParams.attendanceId;
        var departmentId = $location.search().departmentId;
        var attendanceDate = $location.search().attendanceDate;
       
        
        $scope.editList = function() {

            if (departmentId != 0) {
             
              //  $http.get('hrms/hr/attendance/hrmanageattendance/edit?departmentId=' + departmentId+'&attendanceDate='+ attendanceDate).success(function(result) {
                    $http.get($stateParams.tenantid+"/app/hr/hrmanageattendance/edit?departmentId=" + departmentId+"&attendanceDate="+ attendanceDate).success(function(result) {

                	console.log(result);
                  
                    
                    $scope.hrmanageAttendance.attendanceDate = result.attendanceDate;
                    
                    $scope.hrmanageAttendance.academicYearCode = result.academicYearCode;
                    $scope.hrmanageAttendance.departmentId = result.departmentId;
                    
                    $scope.hrmanageAttendance.attendanceId = result.attendanceId;
                    $scope.hrmanageAttendance.lHrManageAttendanceEmployee = result.lHrManageAttendanceEmployee;
                    $scope.hrmanageAttendance.empId = result.empId;
                    $scope.hrmanageAttendance.firstName = result.firstName;
                    $scope.hrmanageAttendance.academicYearId = result.academicYearId;
                    $scope.hrmanageAttendance.remarks = result.remarks;
                    
                   
                    
                });
               
            }
        }
        $scope.editList();

        $scope.reset = function() {
            if ($scope.isEdit == true) {
                $scope.editList();
            } else {
               
                $scope.hrmanageAttendance = angular.copy(resetTemp);
            }
        };

        $scope.updateManageAtten = function(hrmanageAttendance, hrmanageAttendanceForm) {
            var update = true;

            console.log("add")
            console.log(hrmanageAttendance);

            if (update) {
                
                
                var departmentId = $location.search().departmentId;
                $scope.hrmanageAttendance.departmentId =departmentId
                
                $http.post('hrms/hr/attendance/hrmanageattendance/updateHrManageAttendance', $scope.hrmanageAttendance).success(function(data) {
                    logger.logSuccess("updated SuccessFully")
                    $state.go('app.hrms.hr.attendance.hrmanageattendance.list');
                });
            } else {
                logger.logError("Unable to update for Completed Course");
            }

        }

        $scope.cancel = function() {
            $state.go("app.hr.hrmanageattendance.list");
        };

    });