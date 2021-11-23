   

    'use strict';

    app.controller('hrattendanceListCtrl', function($scope, $state, $http, $stateParams , ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {
       
        
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages = 0;
        
        
        $scope.isDelete = true ;
        $scope.isUpload = true ;
        
        
        
        $scope.getHrManageAttendance = function() {
          //  $http.get('hrms/hr/attendance/hrmanageattendance/getHrManageAttendance').success(function(data) {
              $http.get($stateParams.tenantid+'/app/hr/hrmanageattendance/getHrManageAttendance').success(function(data) {

                $scope.rowCollection = data.hrManageAttendanceBeanList;
            });
        }
        $scope.getHrManageAttendance();
        
        $scope.add = function() {
            
            $state.go("app.hr.hrmanageattendance.add",{tenantid:$stateParams.tenantid});
        };
        $scope.editRowDoc = function(collection) {
            var departmentId = collection.departmentId;
            var attendanceDate = collection.attendanceDate;

            $location.url($stateParams.tenantid+'/hr/hrmanageattendance/edit?departmentId=' + departmentId+ '&attendanceDate=' +attendanceDate);

             //$location.url('/hr/attendance/hrmanageattendance/edit?departmentId='+departmentId + '&attendanceDate=' +attendanceDate )
        };
        $scope.deleteRowDoc = function(collection) {
            var attendanceId = collection.attendanceId;
            ngDialog.openConfirm().then(function() {
                $http.get('hrms/hr/attendance/hrmanageattendance/deleteHrManageattendance?attendanceId=' + attendanceId ).success(function(response) {
                    if (response.success == true) {
                        logger.logSuccess("Deleted Succesfully!");
                        $scope.getHrManageAttendance();
                    }
                }).error(function(response) {
                    logger.logError("Error Please Try Again");
                });
            });
        };


    });
