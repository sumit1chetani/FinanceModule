//define([ 'hrms/hr/hr' ], function(module) {
    'use strict';
    app.Controller('movementMasterAddCtrl', function($scope, $state, $http, logger, ngDialog, $location, validationService, sharedProperties, toaster) {

        $scope.isEdit = false;
        $scope.cancel = function() {
            $state.go("app.hrms.hr.employeeInfo.employeeMovementMaster.list");
        };

        var d = new Date();
        var year = d.getFullYear();
        var month = d.getMonth() + 1;
        if (month < 10) {
            month = "0" + month;
        }
        ;
        var day = d.getDate();
        var todayDate = day + "/" + month + "/" + year;

        $scope.employeeMovementData = {
            empName : '',
            empDate : todayDate,
            empOutTime : '',
            empPurposeofVisit : '',
            hospital : '',
            branch : '',
            departmentId : '',
            departmentName : '',
            employee : '',
            empSk : ''
        };

        $scope.companyList = [];
        $scope.branchList = [];
        $scope.departmentList = [];
        $scope.employeeList = [];

        $scope.getCompanyList1 = function() {
            var formCode = document.getElementById('formCode').value;
            $http.post("app/commonUtility/getUserCompanyList", formCode).success(function(response) {
                $scope.companyList = response.companyList;
                if (response.companyList.length == 1) {
                    $scope.employeeMovementData.hospital = response.companyList[0].id;
                    $scope.disable = true;
                    $scope.getBranchList($scope.employeeMovementData.hospital);
                }
            })
        }
        $scope.getCompanyList1();

        $scope.$watch('employeeMovementData.hospital', function(newValue, oldValue) {
            if (newValue != null && newValue != "") {
                $scope.getBranchList(newValue);
            }
        });

        $scope.getBranchList = function(companyId) {
            $http.post('hrms/hr/shiftallocation/getBranchList', companyId).success(function(datas) {
                $scope.branchList = datas.branchList;
            });
        }

        $scope.$watch('employeeMovementData.branch', function(newValue, oldValue) {
            if (newValue != null && newValue != "") {
                $scope.getDepartment(newValue);
            }
        });

        $scope.getDepartment = function(branchId) {
            var myURL = 'hrms/hr/shiftallocation/getDepartmentList?branchId';
            $http({
                method : 'post',
                url : myURL,
                data : branchId,
            }).success(function(data) {
                $scope.departmentList = data.departmentList;
            });
        }

        $scope.$watch('employeeMovementData.departmentId', function(newValue, oldValue) {
            var departmentId = newValue;
            if (newValue != undefined && newValue != "") {
                $scope.getEmployeeList(departmentId);
            }
        });

        $scope.getEmployeeList = function(departmentId) {
            var resultbean = {
                branchId : $scope.employeeMovementData.branch,
                deptId : departmentId
            }
            if (departmentId != undefined && departmentId != "") {
                var myURL = 'hrms/hr/shiftallocation/getEmployeeList';
                $http({
                    method : 'post',
                    url : myURL,
                    data : resultbean,
                }).success(function(data) {
                    $scope.employeeList = data.employeeList;
                });
            }
        }

        $scope.$watch('employeeMovementData.empDate', function(newValue) {
            if (newValue != "") {
                var fromDate = newValue;
                var toDate = todayDate;
                fromDate = fromDate.split("/");
                fromDate = new Date(fromDate[2], fromDate[1], fromDate[0]);
                toDate = toDate.split("/");
                toDate = new Date(toDate[2], toDate[1], toDate[0]);
                if (fromDate < toDate) {
                    logger.logError("Validity Date should be Today Date or Future Date");
                    $scope.employeeMovementData.empDate = todayDate;
                }
            }
        });

        // Saving Employee Data
        $scope.save = function(employeeMovementForm) {
            sharedProperties.clearObject();
            if (new validationService().checkFormValidity(employeeMovementForm)) {
                $http.post("hrms/hr/employeeinfo/employeeMovementMaster/save", $scope.employeeMovementData).success(function(response) {
                    if (response.success == true) {
                        logger.logSuccess("Saved Successfully");
                        $scope.cancel();
                    } else {
                        logger.logError(response.message);
                    }
                });
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(employeeMovementForm.$validationSummary), 10000, 'trustedHtml');
            }
        };

        // Editing the Employee
        var empMovementRequestId = $location.search().empMoveId;
        if (empMovementRequestId != 0 && empMovementRequestId != null) {
            $scope.selectSch = true;
            $scope.isEdit = true;
            $http.post("hrms/hr/employeeinfo/employeeMovementMaster/edit", empMovementRequestId).success(function(response) {
                if (response.success == true) {
                    $scope.employeeMovementData = response.employeeMovementMasterObj;
                } else {
                    if (response.message != '') {
                        logger.logError(response.message);
                    }
                }
            });
        }

        // Updating the Table
        $scope.update = function(employeeMovementForm) {
            var employeeMovementData = {
                'rdoselect' : $scope.employeeMovementData.rdoselect,
                'empSk' : $scope.employeeMovementData.empSk,
                'empName' : $scope.employeeMovementData.empName,
                'empDate' : $scope.employeeMovementData.empDate,
                'empOutTime' : $scope.employeeMovementData.empOutTime,
                'empPurposeofVisit' : $scope.employeeMovementData.empPurposeofVisit,
                'hospital' : $scope.employeeMovementData.hospital,
                'branches' : $scope.employeeMovementData.branches,
                'employee' : $scope.employeeMovementData.employee
            }
            sharedProperties.clearObject();
            if (new validationService().checkFormValidity(employeeMovementForm)) {
                $http.post("hrms/hr/employeeinfo/employeeMovementMaster/update", employeeMovementData).success(function(response) {
                    if (response.success == true) {
                        logger.logSuccess("Updated Successfully!");
                        $scope.cancel();
                    } else {
                        logger.logError(response.message);
                    }
                });
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(employeeMovementForm.$validationSummary), 10000, 'trustedHtml');
            }
        };

        $scope.reset = function() {
            $scope.employeeMovementData.empName = '';
            $scope.employeeMovementData.empDate = '';
            $scope.employeeMovementData.empOutTime = '';
            $scope.employeeMovementData.empPurposeofVisit = '';
            $scope.employeeMovementData.hospital = '';
            $scope.employeeMovementData.branch = '';
            $scope.employeeMovementData.departmentId = '';
            $scope.employeeMovementData.departmentName = '';
            $scope.employeeMovementData.employee = '';
            $scope.branchList = [];
            $scope.departmentList = [];
            $scope.employeeList = [];
            if ($scope.isEdit == true) {
                $http.post("hrms/hr/employeeinfo/employeeMovementMaster/edit", empMovementRequestId).success(function(response) {
                    if (response.success == true) {
                        $scope.employeeMovementData = response.employeeMovementMasterObj;
                    } else {
                        if (response.message != '') {
                            logger.logError(response.message);
                        }
                    }
                });
            }
        }

    });

//});