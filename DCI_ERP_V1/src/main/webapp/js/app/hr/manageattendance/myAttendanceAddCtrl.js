
    'use strict';
    
    app.controller('manageattendanceListCtrl', function($scope, $rootScope, $http, $location, logger,
    		utilsService, ngDialog, $state,sharedProperties,$window, $controller, $injector, toaster , $stateParams) {

        $scope.MyAttendanceMasterData = {
            attendanceDate : '',
            attendanceId : '',
            inTime : '',
            outTime : '',
            hospitalName : '',
            branchName : '',
            departmentId : '',
            departmentCode : '',
            employeeId : '',
            employeeName : '',
            shiftId : '',
            shiftName : '',
            logInUser : '',
            shiftInTime : '',
            shiftOutTime : '',
            myInTime : '',
            myOutTime : '',
            checkIn : '',
            checkOut : '',
            isEdit : false

        };
        $scope.myAttendanceDetails = [];

        var date = new Date();
        var hours = date.getHours();
        var minutes = date.getMinutes();
        minutes = minutes < 10 ? '0' + minutes : minutes;
        $scope.myInTime = hours + ':' + minutes;
        $scope.MyAttendanceMasterData.myInTime = $scope.myInTime;

        var date = new Date();
        var hours = date.getHours();
        var minutes = date.getMinutes();
        minutes = minutes < 10 ? '0' + minutes : minutes;
        $scope.myOutTime = hours + ':' + minutes;
        $scope.MyAttendanceMasterData.myOutTime = $scope.myOutTime;

        var d = new Date();
        var year = d.getFullYear();
        var month = d.getMonth() + 1;
        if (month < 10) {
            month = "0" + month;
        }
        ;
        var day = d.getDate();
        $scope.attendanceDate = day + "/" + month + "/" + year;
        $scope.MyAttendanceMasterData.attendanceDate = $scope.attendanceDate;

        $scope.getMyAttendanceDetails = function() {
            $http.get("hrms/hr/attendance/getMyAttendanceDetails").success(function(datas) {
                $scope.MyAttendanceMasterData.departmentCode = datas.myAttendanceDetails[0].departmentCode;
                $scope.MyAttendanceMasterData.branchName = datas.myAttendanceDetails[0].branchName;
                $scope.MyAttendanceMasterData.employeeName = datas.myAttendanceDetails[0].employeeName;
                $scope.MyAttendanceMasterData.hospitalName = datas.myAttendanceDetails[0].hospitalName;
                $scope.MyAttendanceMasterData.shiftName = datas.myAttendanceDetails[0].shiftName;

                $scope.MyAttendanceMasterData.departmentId = datas.myAttendanceDetails[0].departmentId;
                $scope.MyAttendanceMasterData.shiftId = datas.myAttendanceDetails[0].shiftId;

                $scope.MyAttendanceMasterData.inTime = datas.myAttendanceDetails[0].inTime;
                $scope.MyAttendanceMasterData.outTime = datas.myAttendanceDetails[0].outTime;
                if (datas.shiftList.length != 0) {
                    if (datas.shiftList[0].checkIn != null) {
                        $scope.MyAttendanceMasterData.checkIn = datas.shiftList[0].checkIn;
                    } else {
                        $scope.MyAttendanceMasterData.checkIn = '';
                    }
                    if (datas.shiftList[0].checkOut != null) {
                        $scope.MyAttendanceMasterData.checkOut = datas.shiftList[0].checkOut;
                    } else {
                        $scope.MyAttendanceMasterData.checkOut = '';
                    }
                } else {
                    $scope.MyAttendanceMasterData.checkIn = '';
                    $scope.MyAttendanceMasterData.checkOut = '';
                }

                var d = new Date();
                var year = d.getFullYear();
                var month = d.getMonth() + 1;
                if (month < 10) {
                    month = "0" + month;
                }
                ;
                var day = d.getDate();
                $scope.attendanceDate = day + "/" + month + "/" + year;
                $scope.MyAttendanceMasterData.attendanceDate = $scope.attendanceDate;
                $scope.MyAttendanceMasterData.attendanceDate = $scope.attendanceDate;
            });
        }
        $scope.getMyAttendanceDetails();

        $scope.submitIn = function(myAttendanceForm, MyAttendanceMasterData) {
            if ($scope.MyAttendanceMasterData.shiftId != '' && $scope.MyAttendanceMasterData.shiftName != '' && $scope.MyAttendanceMasterData.inTime != '') {
                $http.post("hrms/hr/attendance/saveMyAttendance", MyAttendanceMasterData).success(function(result) {
                    if (result == true) {
                        logger.logSuccess("In Time Registered Successfully!");
                        $scope.cancel();
                    } else {
                        logger.logError("Unable to Register!");
                    }
                });
            } else {
                logger.logError("No Shift Allocated for this Logged In Employee");
            }
        };

        $scope.submitOut = function(myAttendanceForm, MyAttendanceMasterData) {
            if ($scope.MyAttendanceMasterData.shiftId != '' && $scope.MyAttendanceMasterData.shiftName != '' && $scope.MyAttendanceMasterData.inTime != '') {
                if ($scope.MyAttendanceMasterData.checkIn != "") {
                    $http.post("hrms/hr/attendance/saveMyAttendance", MyAttendanceMasterData).success(function(result) {
                        if (result == true) {
                            logger.logSuccess("Out Time Registered Successfully!");
                            $scope.cancel();
                        } else {
                            logger.logError("Unable to Register!");
                        }
                    });
                } else {
                    logger.logError("Please put attendance for In Time");
                }
            } else {
                logger.logError("No Shift Allocated for this Logged In Employee");
            }
        };

        $scope.cancel = function() {
            $state.go('app.truck.general.designation',{tenantid:$stateParams.tenantid});
        };

    });
