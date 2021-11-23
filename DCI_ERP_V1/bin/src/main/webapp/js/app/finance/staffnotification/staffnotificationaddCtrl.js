    'use strict';
    app.controller('staffnotificationAddCtrl', function($scope, $timeout, $state, $http, ngDialog, logger, $stateParams, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService) {
        $scope.rowCollection = [];
        $scope.cancel = function() {
            $state.go("app.hr.staffnotification.list",{tenantid:$stateParams.tenantid});
        }
        var d = new Date();
        var year = d.getFullYear();
        var month = d.getMonth() + 1;
        if (month < 10) {
            month = "0" + month;
        }
        ;
        var day = d.getDate();
        var todayDate = day + "/" + month + "/" + year;
        $scope.staffNotification = {

            department : [],
            designation : [],
            division : [],
            grade : [],
            reporting : [],
            notificationContent : '',
            status : '',

        }

        $scope.reset = function() {

            $scope.staffNotification.departmentId = [];
            $scope.staffNotification.designationId = [];
            $scope.staffNotification.divisionId = [];
            $scope.staffNotification.gradeId = [];
            $scope.staffNotification.reportingTo = [];
            $scope.staffNotification.notificationContent = '';
            $scope.staffNotification.status = '';
        }

        $scope.getOptionId = function(option) {
            return option.id;
        }
       // $http.get("hr/employeeinfo/staffnotification/departmentlist").success(function(data) {
            $http.get($stateParams.tenantid+'/app/hr/staffnotification/departmentlist').success(function(data) {

            if (data.success) {

                $scope.departmentList = data.ldepartmentlist;

                $timeout(function() {
                    $("#department").multiselect({
                        maxHeight : 400,
                        includeSelectAllOption : true,
                        selectAllText : 'Select All',
                        enableFiltering : true,
                        enableCaseInsensitiveFiltering : true,
                        filterPlaceholder : 'Search',
                        numberDisplayed : 1,
                    });
                }, 3, false);

                $("#multiselect-button").addClass("width_100 input-sm line-height-5");
            } else {
                $scope.departmentList = [];
                $scope.staffNotification.department = '';
            }
        }).error(function(data) {
        });

     //   $http.get("hr/employeeinfo/staffnotification/designationlist").success(function(data) {
            $http.get($stateParams.tenantid+'/app/hr/staffnotification/designationlist').success(function(data) {
            if (data.success) {

                $scope.designationList = data.ldesignationlist;

                $timeout(function() {
                    $("#designation").multiselect({
                        maxHeight : 400,
                        includeSelectAllOption : true,
                        selectAllText : 'Select All',
                        enableFiltering : true,
                        enableCaseInsensitiveFiltering : true,
                        filterPlaceholder : 'Search',
                        numberDisplayed : 1,
                    });
                }, 3, false);

                $("#multiselect-button").addClass("width_100 input-sm line-height-5");
            } else {
                $scope.designationList = [];
                $scope.staffNotification.designation = '';
            }
        }).error(function(data) {
        });

     //   $http.get("hr/employeeinfo/staffnotification/divisionlist").success(function(data) {
            $http.get($stateParams.tenantid+'/app/hr/staffnotification/divisionlist').success(function(data) {
            if (data.success) {

                $scope.divisionList = data.ldivisionlist;

                $timeout(function() {
                    $("#division").multiselect({
                        maxHeight : 400,
                        includeSelectAllOption : true,
                        selectAllText : 'Select All',
                        enableFiltering : true,
                        enableCaseInsensitiveFiltering : true,
                        filterPlaceholder : 'Search',
                        numberDisplayed : 1,
                    });
                }, 3, false);

                $("#multiselect-button").addClass("width_100 input-sm line-height-5");
            } else {
                $scope.divisionList = [];
                $scope.staffNotification.division = '';
            }
        }).error(function(data) {
        });
        //$http.get("hr/employeeinfo/staffnotification/gradelist").success(function(data) {
            $http.get($stateParams.tenantid+'/app/hr/staffnotification/gradelist').success(function(data) {

            if (data.success) {

                $scope.gradeList = data.lgradelist;

                $timeout(function() {
                    $("#grade").multiselect({
                        maxHeight : 400,
                        includeSelectAllOption : true,
                        selectAllText : 'Select All',
                        enableFiltering : true,
                        enableCaseInsensitiveFiltering : true,
                        filterPlaceholder : 'Search',
                        numberDisplayed : 1,
                    });
                }, 3, false);

                $("#multiselect-button").addClass("width_100 input-sm line-height-5");
            } else {
                $scope.gradeList = [];
                $scope.staffNotification.grade = '';
            }
        }).error(function(data) {
        });
     //   $http.get("hr/employeeinfo/staffnotification/reportingTolist").success(function(data) {
            $http.get($stateParams.tenantid+'/app/hr/staffnotification/reportingTolist').success(function(data) {

            if (data.success) {

                $scope.reportingToList = data.lreportingTolist;

                $timeout(function() {
                    $("#reporting").multiselect({
                        maxHeight : 400,
                        includeSelectAllOption : true,
                        selectAllText : 'Select All',
                        enableFiltering : true,
                        enableCaseInsensitiveFiltering : true,
                        filterPlaceholder : 'Search',
                        numberDisplayed : 1,
                    });
                }, 3, false);

                $("#multiselect-button").addClass("width_100 input-sm line-height-5");
            } else {
                $scope.reportingToList = [];
                $scope.staffNotification.reporting = '';
            }
        }).error(function(data) {
        });

        $scope.submit = function(staffNotificationForm) {

            debugger;
            if (new validationService().checkFormValidity(staffNotificationForm)) {
                $scope.save();
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.staffNotificationForm.$validationSummary), 5000, 'trustedHtml');
            }
        };

        $scope.save = function() {
            debugger;

            var departmentId = [];
            angular.forEach($scope.staffNotification.department, function(value, key) {
                departmentId.push(value.id);
            });
        /*    var designationId = [];
            angular.forEach($scope.staffNotification.designation, function(value, key) {
                designationId.push(value.id);
            });*/
            var divisionId = [];
            angular.forEach($scope.staffNotification.division, function(value, key) {
                divisionId.push(value.id);
            });
           /* var gradeId = [];
            angular.forEach($scope.staffNotification.grade, function(value, key) {
                gradeId.push(value.id);
            });
            var reportingTo = [];
            angular.forEach($scope.staffNotification.reporting, function(value, key) {
                reportingTo.push(value.id);

            });*/

            $scope.staffNotification.department = departmentId;
            //$scope.staffNotification.designation = designationId;
            $scope.staffNotification.division = divisionId;
          //  $scope.staffNotification.grade = gradeId;
           // $scope.staffNotification.reporting = reportingTo;
         //   $http.post("hr/employeeinfo/staffnotification/savestaffnotification", $scope.staffNotification).success(function(data) {
            $http.post($stateParams.tenantid+'/app/hr/staffnotification/savestaffnotification', $scope.staffNotification).success(function(data) {

                if (data) {
                    logger.logSuccess("Notification Succesfully Added!");
                    $state.go("app.hr.staffnotification.list",{tenantid:$stateParams.tenantid});

                } else {
                    logger.logError("Error Not Saved!");
                }
            }).error(function(data) {
                logger.logSuccess("Error Not Saved!");
            });

        }

        $scope.submitPublish = function(staffNotificationForm) {

            debugger;
            if (new validationService().checkFormValidity(staffNotificationForm)) {
                $scope.savePublish();
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.staffNotificationForm.$validationSummary), 5000, 'trustedHtml');
            }
        };
        $scope.savePublish = function() {
            debugger;

            var departmentId = [];
            angular.forEach($scope.staffNotification.department, function(value, key) {
                departmentId.push(value.id);
            });
            var designationId = [];
            angular.forEach($scope.staffNotification.designation, function(value, key) {
                designationId.push(value.id);
            });
            var divisionId = [];
            angular.forEach($scope.staffNotification.division, function(value, key) {
                divisionId.push(value.id);
            });
            var gradeId = [];
            angular.forEach($scope.staffNotification.grade, function(value, key) {
                gradeId.push(value.id);
            });
            var reportingTo = [];
            angular.forEach($scope.staffNotification.reporting, function(value, key) {
                reportingTo.push(value.id);

            });

            $scope.staffNotification.department = departmentId;
            $scope.staffNotification.designation = designationId;
            $scope.staffNotification.division = divisionId;
            $scope.staffNotification.grade = gradeId;
            $scope.staffNotification.reporting = reportingTo;
          //  $http.post("hr/employeeinfo/staffnotification/publishandsavestaffnotification", $scope.staffNotification).success(function(data) {
                $http.get($stateParams.tenantid+'/app/hr/staffnotification/publishandsavestaffnotification', $scope.staffNotification).success(function(data) {

                if (data) {
                    logger.logSuccess("Notification Succesfully Added And Sent !");
                    $state.go("app.hr.staffnotification.list",{tenantid:$stateParams.tenantid});

                } else {
                    logger.logError("No Employees For Selelcted Data!");
                }
            }).error(function(data) {
                logger.logSuccess("Error Not Saved!");
            });

        }
    });

    
