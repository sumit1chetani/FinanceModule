
    'use strict';
    
    app.controller('manageattendanceListCtrl', function($scope, $rootScope, $http, $location, logger,
    		utilsService, ngDialog, $state,sharedProperties,$window, $controller, $injector, toaster , $stateParams) {
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages = 0;
        $scope.isDelete = true;
        $scope.isUpload = true;

        $scope.AttendanceMasterData = {
            attendanceId : '',
            dayOption : '',
            attendanceDate : '',
            inTime : '',
            outTime : '',
            hospitalName : '',
            branchName : '',
            departmentId : '',
            departmentCode : '',
            employeeList : '',
            shiftId : '',
            shiftName : '',
            logInUser:''
        };
        // Populate Grid
        $scope.getAttendanceList = function() {
    debugger
            $scope.dataLoopCount = 0;
            $scope.showEmptyLabel = false;
            $scope.from = 0;
            $scope.to = 100;
            $scope.rowCollection = [];
            var url = $stateParams.tenantid+'/app/hr/attendance/list?limit=' + $scope.from + '&offset=' + $scope.to;
            $http.get(url).success(function(data) {
                if (data.success == true) {
                    $scope.rowCollection = $scope.rowCollection.concat(data.attendanceDataList);
                    $scope.AttendanceMasterData.logInUser="IA";
                }
            });
        };

        $scope.getAttendanceList();

        $scope.add = function() {
            $state.go("app.hr.manageattendance.add",{tenantid:$stateParams.tenantid});


        };

        $scope.editRow = function(attendance) {
            $location.url($stateParams.tenantid+"/hr/manageattendance/edit?attendanceId=" + attendance.attendanceId);
        };

        $scope.deleteRow = function(attendanceId, index) {

            ngDialog.openConfirm().then(function() {
                var myURL = $stateParams.tenantid+'/app/hr/attendance/delete';
                $http({
                    method : 'post',
                    url : myURL,
                    data : attendanceId,
                }).success(function(data) {
                    if (data == true) {
                        $scope.displayedCollection.splice(index, 1);
                        logger.logSuccess("Attendance deleted successfully");
                        $scope.getAttendanceList();
                    } else {
                        logger.logGeneric(data.message, data.type);
                    }
                }).error(function(data) {
                    logger.logGeneric(data.message, data.type);
                });
            }, function(reason) {
            });

        };
        $scope.attendenceListObj = {
            employeeNo : '',
            fromDate : '',
            toDate : ''
        }

    });
