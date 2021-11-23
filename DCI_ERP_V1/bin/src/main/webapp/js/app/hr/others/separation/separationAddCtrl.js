define([ 'hrms/hr/hr' ], function(module) {
    'use strict';

    module.registerController('separationAddCtrl', function($scope, $state, $stateParams, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService) {

        $scope.separationObj = {
            empName : '',
            empId : '',
            companyId : '',
            company : '',
            branchId : '',
            branch : '',
            departmentId : '',
            department : '',
            gradeId : '',
            grade : '',
            notice : '',
            dateOfResignation : '',
            reportingId : '',
            reportingManagerName : '',
            reason : '',
            approvalstatus : '',
            status : ''
        };

        $scope.cancel = function() {
            $state.go("app.hrms.hr.others.separation.list");
        }
        $scope.reset = function(separationObj) {
            $scope.separationObj.reason = '';
            $scope.separationObj.dateOfResignation = '';
            $scope.separationObj.notice = '';

        }

        $scope.employeeChange = function() {
            $http.get("hrms/hr/others/separation/getEmployeeDetails").success(function(response) {
                $scope.separationObj.empName = response.employeeDetailsList.empName;
                $scope.separationObj.empId = response.employeeDetailsList.empId;
                $scope.separationObj.company = response.employeeDetailsList.company;
                $scope.separationObj.companyId = response.employeeDetailsList.companyId;
                $scope.separationObj.branch = response.employeeDetailsList.branch;
                $scope.separationObj.branchId = response.employeeDetailsList.branchId;
                $scope.separationObj.grade = response.employeeDetailsList.grade;
                $scope.separationObj.gradeId = response.employeeDetailsList.gradeId;
                $scope.separationObj.department = response.employeeDetailsList.department;
                $scope.separationObj.departmentId = response.employeeDetailsList.departmentId;
                $scope.separationObj.approvalstatus = "Not Submitted";
                $scope.getReportingManager($scope.separationObj.empId);
                $scope.checkEmployeeExist($scope.separationObj.empId);
            });

        }

        $scope.employeeChange();

        $scope.getReportingManager = function(employeeId) {
            $http.get("hrms/hr/others/separation/getReportingManager?employeeId=" + employeeId).success(function(response) {
                $scope.separationObj.reportingId = response.managerDetails[0].reportingId;
                $scope.separationObj.reportingManagerName = response.managerDetails[0].reportingManagerName;
            });
        }

        $scope.checkEmployeeExist = function(employeeId) {
            $http.get("hrms/hr/others/separation/checkEmpExist?employeeId=" + employeeId).success(function(response) {
                if (response.separationDetails != undefined && response.separationDetails != null) {
                    if (response.separationDetails.length > 0) {
                        $scope.separationObj.dateOfResignation = response.separationDetails[0].dateOfResignation;
                        $scope.separationObj.reason = response.separationDetails[0].reason;
                        $scope.separationObj.notice = response.separationDetails[0].notice;
                        $scope.separationObj.approvalstatus = response.separationDetails[0].approvalstatus;
                        $scope.freeze = true;
                    }
                } else {
                    $scope.separationObj.dateOfResignation = '';
                    $scope.separationObj.reason = '';
                    $scope.separationObj.notice = '';
                    $scope.freeze = false;
                }

            });
        }

        $scope.submit = function(separationAddForm, separationObj) {
            if (new validationService().checkFormValidity(separationAddForm)) {
                $scope.save(separationObj);
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.separationAddForm.$validationSummary), 5000, 'trustedHtml');
            }
        };

        $scope.save = function(separationObj) {
            var jsonData = {
                'separationDatas' : separationObj,
            }
            $http.post('hrms/hr/others/separation/save', jsonData).success(function(data) {
                if (data) {
                    logger.logSuccess("Separation Form Successfully Submitted!");
                    $state.go('app.hrms.hr.others.separation.list');
                } else {
                    logger.logError("Error Not Saved!");
                }
            }).error(function(data) {
                logger.logSuccess("Error Not Saved!");
            });

        }

    });

    module.registerController('separationApprovalViewCtrl', function($scope, $state, $stateParams, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService) {
        $scope.separationObj = {
            empName : '',
            empId : '',
            companyId : '',
            company : '',
            branchId : '',
            branch : '',
            departmentId : '',
            department : '',
            gradeId : '',
            grade : '',
            notice : '',
            dateOfResignation : '',
            reportingId : '',
            reportingManagerName : '',
            reason : '',
            approvalstatus : '',
            status : ''
        };

        $scope.cancel = function() {
            $state.go("app.hrms.hr.others.separationapproval.list");
        }

        $scope.approveSeparation = function(separation_id, status, approvercomments) {
            if (status == "Submitted" || approvercomments == "") {
                logger.logError("Please select Status/Comments");
            } else {
                $http.get('hrms/hr/others/separation/approveSeparation?separation_id=' + separation_id + '&status=' + status + '&approvercomments=' + approvercomments).success(function(response) {
                    logger.logSuccess("Approved successfully");
                    $state.go('app.hrms.hr.others.separationapproval.list');
                });
            }
        }

        var separation_id = $stateParams.separation_id;

        $http.get("hrms/hr/others/separation/viewSeparation?separation_id=" + separation_id).success(function(response) {
            $scope.separationObj.empName = response.employeeDetailsList.empName;
            $scope.separationObj.empId = response.employeeDetailsList.empId;
            $scope.separationObj.company = response.employeeDetailsList.company;
            $scope.separationObj.companyId = response.employeeDetailsList.companyId;
            $scope.separationObj.branch = response.employeeDetailsList.branch;
            $scope.separationObj.branchId = response.employeeDetailsList.branchId;
            $scope.separationObj.grade = response.employeeDetailsList.grade;
            $scope.separationObj.gradeId = response.employeeDetailsList.gradeId;
            $scope.separationObj.department = response.employeeDetailsList.department;
            $scope.separationObj.departmentId = response.employeeDetailsList.departmentId;
            $scope.separationObj.approvalstatus = response.employeeDetailsList.approvalstatus;
            $scope.separationObj.notice = response.employeeDetailsList.notice;
            $scope.separationObj.reason = response.employeeDetailsList.reason;
            $scope.separationObj.dateOfResignation = response.employeeDetailsList.dateOfResignation;
            $scope.separationObj.reportingManagerName = response.employeeDetailsList.reportingManagerName;
            $scope.separationObj.separation_id = response.employeeDetailsList.separation_id;
            $scope.separationObj.approvercomments = response.employeeDetailsList.approvercomments;
        });

    });

    module.registerController('separationListCtrl', function($scope, $state, $stateParams, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService) {
        $scope.isUpload = true;
        $scope.isDelete = true;

        $scope.add = function() {
            $state.go("app.hrms.hr.others.separation.add");
        }
        $scope.getMySeparationList = function() {
            $http.get('hrms/hr/others/separation/getMySeparationList').success(function(response) {
                $scope.rowCollection = response.resignationList;
            });
        }
        $scope.getMySeparationList();

    });

});