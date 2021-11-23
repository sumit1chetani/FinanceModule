define([ 'hrms/hr/hr' ], function(module) {
    'use strict';
    module.registerController('staffnnotificationAddCtrl', function($scope, $timeout, $state, $http, ngDialog, logger, $stateParams, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService) {
        $scope.rowCollection = [];
        $scope.cancel = function() {
            $state.go('app.hrms.hr.employeeinfo.staffnotification.list');
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
        $http.get("hr/employeeinfo/staffnotification/departmentlist").success(function(data) {

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

        $http.get("hr/employeeinfo/staffnotification/designationlist").success(function(data) {

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

        $http.get("hr/employeeinfo/staffnotification/divisionlist").success(function(data) {

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
        $http.get("hr/employeeinfo/staffnotification/gradelist").success(function(data) {

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
        $http.get("hr/employeeinfo/staffnotification/reportingTolist").success(function(data) {

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
            $http.post("hr/employeeinfo/staffnotification/savestaffnotification", $scope.staffNotification).success(function(data) {

                if (data) {
                    logger.logSuccess("Notification Succesfully Added!");
                    $state.go('app.hrms.hr.employeeinfo.staffnotification.list');

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
            $http.post("hr/employeeinfo/staffnotification/publishandsavestaffnotification", $scope.staffNotification).success(function(data) {

                if (data) {
                    logger.logSuccess("Notification Succesfully Added And Sent !");
                    $state.go('app.hrms.hr.employeeinfo.staffnotification.list');

                } else {
                    logger.logError("No Employees For Selelcted Data!");
                }
            }).error(function(data) {
                logger.logSuccess("Error Not Saved!");
            });

        }
    });

    module.registerController('staffnotificationEditCtrl', function($scope, $timeout, $state, $http, ngDialog, logger, $stateParams, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService) {

        $scope.rowCollection = [];

        $scope.cancel = function() {
            $state.go('app.hrms.hr.employeeinfo.staffnotification.list');
        }

        $scope.staffNotification = {

            department : [],
            designation : [],
            division : [],
            grade : [],
            reporting : [],
            notificationContent : '',
            status : '',

        }

        var staffNotificationId = $stateParams.staffNotificationId;
        if (staffNotificationId == undefined) {
            $scope.edit = false;
        }
        {
            $scope.edit = true;
            $http.get('hr/employeeinfo/staffnotification/editstaffnotification?staffNotificationId=' + staffNotificationId).success(function(result) {
                $scope.staffNotification = result.staffNotificationBeanDetail;

                $http.get("hr/employeeinfo/staffnotification/departmentlist").success(function(data) {

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
                    } 
                        $scope.departmentListData = [];
                        // $scope.staffNotification.department =
                        // result.staffNotificationBeanDetail.department;

                        var department = result.staffNotificationBeanDetail.department;
                        if (department != null) {
                            for (var i = 0; i < department.length; i++) {
                                $("#department").find("option[label=" + department[i] + "]").prop("selected", "selected");
                                angular.forEach($scope.departmentList, function(value, key) {
                                    if (department[i] == value.id) {
                                        $scope.departmentListData.push(value);
                                    }
                                });

                                $scope.staffNotification.department = $scope.departmentListData;

                                var departmentStr = '';
                                var j = 0;
                                for (var k = 0; k < $scope.departmentListData.length; k++) {
                                    departmentStr = departmentStr + $scope.departmentListData[k].text;
                                    j++;
                                    if (j < $scope.departmentListData.length) {
                                        departmentStr = departmentStr + ",";
                                    }
                                }
                                $scope.departmentStr = departmentStr;

                            }
                        }
                    
                }).error(function(data) {
                });

                $http.get("hr/employeeinfo/staffnotification/designationlist").success(function(data) {

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
                    } 
                        $scope.designationListData = [];
                        var designation = result.staffNotificationBeanDetail.designation;
                        if (designation != null) {
                            for (var i = 0; i < designation.length; i++) {
                                $("#designation").find("option[label=" + designation[i] + "]").prop("selected", "selected");
                                angular.forEach($scope.designationList, function(value, key) {
                                    if (designation[i] == value.id) {
                                        $scope.designationListData.push(value);
                                    }
                                });

                                $scope.staffNotification.designation = $scope.designationListData;

                                var designationStr = '';
                                var j = 0;
                                for (var k = 0; k < $scope.designationListData.length; k++) {
                                    designationStr = designationStr + $scope.designationListData[k].text;
                                    j++;
                                    if (j < $scope.designationListData.length) {
                                        designationStr = designationStr + ",";
                                    }
                                }
                                $scope.designationStr = designationStr;

                            }
                        
                    }
                }).error(function(data) {
                });

                $http.get("hr/employeeinfo/staffnotification/divisionlist").success(function(data) {

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
                    } 
                        $scope.divisionListData = [];
                        var division = result.staffNotificationBeanDetail.division;
                        if (designation != null) {
                            for (var i = 0; i < division.length; i++) {
                                $("#division").find("option[label=" + division[i] + "]").prop("selected", "selected");
                                angular.forEach($scope.divisionList, function(value, key) {
                                    if (division[i] == value.id) {
                                        $scope.divisionListData.push(value);
                                    }
                                });

                                $scope.staffNotification.division = $scope.divisionListData;

                                var divisionStr = '';
                                var j = 0;
                                for (var k = 0; k < $scope.divisionListData.length; k++) {
                                    divisionStr = divisionStr + $scope.divisionListData[k].text;
                                    j++;
                                    if (j < $scope.divisionListData.length) {
                                        divisionStr = divisionStr + ",";
                                    }
                                }
                                $scope.divisionStr = divisionStr;

                            }
                        
                    }
                }).error(function(data) {
                });
                $http.get("hr/employeeinfo/staffnotification/gradelist").success(function(data) {

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
                    } 
                        $scope.gradeListData = [];
                        var grade = result.staffNotificationBeanDetail.grade;
                        if (grade != null) {
                            for (var i = 0; i < grade.length; i++) {
                                $("#grade").find("option[label=" + grade[i] + "]").prop("selected", "selected");
                                angular.forEach($scope.gradeList, function(value, key) {
                                    if (grade[i] == value.id) {
                                        $scope.gradeListData.push(value);
                                    }
                                });

                                $scope.staffNotification.grade = $scope.gradeListData;

                                var gradeStr = '';
                                var j = 0;
                                for (var k = 0; k < $scope.gradeListData.length; k++) {
                                    gradeStr = gradeStr + $scope.gradeListData[k].text;
                                    j++;
                                    if (j < $scope.gradeListData.length) {
                                        gradeStr = gradeStr + ",";
                                    }
                                }
                                $scope.gradeStr = gradeStr;

                            }
                        
                    }
                }).error(function(data) {
                });
                $http.get("hr/employeeinfo/staffnotification/reportingTolist").success(function(data) {

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
                    }
                        $scope.reportingToListData = [];
                        var reporting = result.staffNotificationBeanDetail.reporting;
                        if (reporting != null) {
                             for (var i = 0; i < reporting.length; i++) {
                                 $("#reporting").find("option[label=" + reporting[i] + "]").prop("selected", "selected");
                                 angular.forEach($scope.reportingToList, function(value, key) {
                                     if (reporting[i] == value.id) {
                                         $scope.reportingToListData.push(value);
                                     }
                                 });

                                 $scope.staffNotification.reporting = $scope.reportingToListData;

                                 var reportingStr = '';
                                 var j = 0;
                                 for (var k = 0; k < $scope.reportingToListData.length; k++) {
                                     reportingStr = reportingStr + $scope.reportingToListData[k].text;
                                     j++;
                                     if (j < $scope.reportingToListData.length) {
                                         reportingStr = reportingStr + ",";
                                     }
                                 }
                                 $scope.reportingStr = reportingStr;
                          
                             }
                                          
                        }
                }).error(function(data) {
                });

            }).error(function(data) {
            });
        }

        $scope.submit = function(staffNotificationForm) {

            debugger;
            if (new validationService().checkFormValidity(staffNotificationForm)) {
                $scope.update(staffNotification);
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.staffNotificationForm.$validationSummary), 5000, 'trustedHtml');
            }
        };

        $scope.update = function(staffNotification) {
            debugger;
            var departmentId = [];
            if ($scope.staffNotification.department.length != 0) {
                angular.forEach($scope.staffNotification.department, function(value, key) {
                    departmentId.push(value.id);
                });
            }

            var designationId = [];
            if ($scope.staffNotification.designation.length != 0) {
                angular.forEach($scope.staffNotification.designation, function(value, key) {
                    designationId.push(value.id);
                });
            }
            var divisionId = [];
            if ($scope.staffNotification.division.length != 0) {
                angular.forEach($scope.staffNotification.division, function(value, key) {
                    divisionId.push(value.id);
                });
            }

            var gradeId = [];
            if ($scope.staffNotification.grade.length != 0) {
                angular.forEach($scope.staffNotification.grade, function(value, key) {
                    gradeId.push(value.id);
                });
            }

            var reportingTo = [];
            if ($scope.staffNotification.reporting.length != 0) {
                angular.forEach($scope.staffNotification.reporting, function(value, key) {
                    reportingTo.push(value.id);

                });
            }
            $scope.staffNotification.department = departmentId;
            $scope.staffNotification.designation = designationId;
            $scope.staffNotification.division = divisionId;
            $scope.staffNotification.grade = gradeId;
            $scope.staffNotification.reporting = reportingTo;
            $http.post("hr/employeeinfo/staffnotification/updatestaffnotification", $scope.staffNotification).success(function(data) {

                if (data) {
                    logger.logSuccess("Notification Succesfully Updated!");
                    $state.go('app.hrms.hr.employeeinfo.staffnotification.list');

                } else {
                    logger.logError("No Employees For Selelcted Data!");
                }
            }).error(function(data) {
                logger.logSuccess("Error Not Saved!");
            });
        }
        $scope.submitPublish = function(staffNotificationForm) {

            debugger;
            if (new validationService().checkFormValidity(staffNotificationForm)) {
                $scope.updatePublish(staffNotification);
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.staffNotificationForm.$validationSummary), 5000, 'trustedHtml');
            }
        };

        $scope.updatePublish = function(staffNotification) {
            debugger;
            var departmentId = [];
            if ($scope.staffNotification.department.length != 0) {
                angular.forEach($scope.staffNotification.department, function(value, key) {
                    departmentId.push(value.id);
                });
            }

            var designationId = [];
            if ($scope.staffNotification.designation.length != 0) {
                angular.forEach($scope.staffNotification.designation, function(value, key) {
                    designationId.push(value.id);
                });
            }
            var divisionId = [];
            if ($scope.staffNotification.division.length != 0) {
                angular.forEach($scope.staffNotification.division, function(value, key) {
                    divisionId.push(value.id);
                });
            }

            var gradeId = [];
            if ($scope.staffNotification.grade.length != 0) {
                angular.forEach($scope.staffNotification.grade, function(value, key) {
                    gradeId.push(value.id);
                });
            }

            var reportingTo = [];
            if ($scope.staffNotification.reporting.length != 0) {
                angular.forEach($scope.staffNotification.reporting, function(value, key) {
                    reportingTo.push(value.id);

                });
            }
            $scope.staffNotification.department = departmentId;
            $scope.staffNotification.designation = designationId;
            $scope.staffNotification.division = divisionId;
            $scope.staffNotification.grade = gradeId;
            $scope.staffNotification.reporting = reportingTo;
            $http.post("hr/employeeinfo/staffnotification/updateandpublishstaffnotification", $scope.staffNotification).success(function(data) {

                if (data) {
                    logger.logSuccess("Notification Succesfully Updated!");
                    $state.go('app.hrms.hr.employeeinfo.staffnotification.list');

                } else {
                    logger.logError("No Employees For Selelcted Data!");
                }
            }).error(function(data) {
                logger.logSuccess("Error Not Saved!");
            });
        }

        $scope.reset = function() {
            $state.reload();
        }

    });

});
