define([ 'hrms/hr/hr' ], function(module) {
    'use strict';
    module.registerController('disciplinaryActionAddCtrl', function($scope, $state, $http, ngDialog, logger, $stateParams, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService) {
        $scope.rowCollection = [];
        $scope.cancel = function() {
            $state.go('app.hrms.hr.others.disciplinaryaction.list');
        };

        $scope.disciplinaryData = {
            hospitalId : '',
            designationId : '',
            branchId : '',
            departmentId : '',
            gradeId : '',
            employeeId : '',
            proceedings : '',
            suspendFrom : '',
            suspendTo : '',
            suspendedDays : '',
            issueWarning : '',
            reason : ''
        }
///

        $scope.disable=false;
        $scope.getCompanyList = function() {
            var formCode = document.getElementById('formCode').value;
            

            $http.post("hrms/report/employeeReports/companyList" , formCode).success(function(response) {
                $scope.hospitalList = response.companyList;
                if (response.companyList.length == 1) {
                    $scope.disciplinaryData.hospitalId = response.companyList[0].id;
                    $scope.disable = true;
                    
                }

            })
        }
        $scope.getCompanyList();

        $scope.$watch('disciplinaryData.hospitalId', function(newValue, oldValue) {
            if (newValue != undefined && newValue != '') {
                $scope.disciplinaryData.departmentId = '';
                $scope.disciplinaryData.branchId = '';
                $scope.disciplinaryData.employeeId = '';
                $scope.getbranch(newValue);
            }
        });

        $scope.getbranch = function(hospitalId) {
            if (hospitalId != "" && hospitalId != null) {
                $http.post("hrms/report/employeeshift/getBranchList", hospitalId).success(function(datas) {
                    $scope.branchList = datas.branchList;
                });
            }
        }
        $scope.$watch('disciplinaryData.branchId', function(newValue, oldValue) {
            if (newValue != undefined && newValue != '') {
                $scope.disciplinaryData.departmentId = '';

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

        $scope.$watch('disciplinaryData.departmentId', function(newValue, oldValue) {
            if (newValue != undefined && newValue != '') {
                $scope.disciplinaryData.employeeId = '';
                $scope.getEmployee(newValue);
            }
        });

        $scope.getEmployee = function(branchId) {
            var resultBean = {
                deptId : $scope.disciplinaryData.departmentId,
                branchId : $scope.disciplinaryData.branchId
            }
            if ($scope.disciplinaryData.departmentId != "" && $scope.disciplinaryData.departmentId != null) {
                $http.post("hrms/hr/shiftallocation/getEmployeeList", resultBean).success(function(datas) {
                    $scope.employeeList = datas.employeeList;
                });
            }
        }

        $scope.getDesignationList = function() {
            $http.get('hrms/master/employeeMaster/getDesignationList').success(function(datas) {
                $scope.designationList = datas.designationList;

            }).error(function(data) {

            });
        }
        $scope.getDesignationList();

        $scope.getGradeList = function() {
            $http.get('hrms/master/employeeMaster/getGradeList').success(function(datas) {
                $scope.gradeList = datas.gradeList;

            }).error(function(data) {

            });
        }
        $scope.getGradeList();

        $scope.$watch('disciplinaryData.suspendTo', function(newValue, oldValue) {
            if (newValue != '' && newValue != undefined) {
                if ($scope.disciplinaryData.suspendFrom == '') {
                    logger.logError("Please Select Suspended From");
                    $scope.disciplinaryData.suspendTo = '';
                }
                var toDate = $scope.disciplinaryData.suspendFrom;
                var fromDate = newValue;
                $scope.getCountDays(toDate, fromDate);
                fromDate = fromDate.split("/");
                fromDate = new Date(fromDate[2], fromDate[1] - 1, fromDate[0]);
                toDate = toDate.split("/");
                toDate = new Date(toDate[2], toDate[1] - 1, toDate[0]);
                if (fromDate < toDate) {
                    logger.logError("Selected Date is less than the from Date");
                    $scope.disciplinaryData.suspendTo = '';
                    $scope.disciplinaryData.suspendedDays = '';
                }
            }
        });

        $scope.getCountDays = function(firstDate, secondDate) {
            var date2 = new Date($scope.formatString(secondDate));
            var date1 = new Date($scope.formatString(firstDate));
            var timeDiff = Math.abs(date2.getTime() - date1.getTime());
            $scope.disciplinaryData.suspendedDays = Math.ceil(timeDiff / (1000 * 3600 * 24));
        }
        $scope.formatString = function(format) {
            var day = parseInt(format.substring(0, 2));
            var month = parseInt(format.substring(3, 5));
            var year = parseInt(format.substring(6, 10));
            var date = new Date(year, month - 1, day);
            return date;
        }

        $scope.submit = function(disciplinaryActionForm, disciplinaryData) {
            if (new validationService().checkFormValidity(disciplinaryActionForm)) {
                $scope.save(disciplinaryData);
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.disciplinaryActionForm.$validationSummary), 5000, 'trustedHtml');
            }
        };

        $scope.save = function(disciplinaryData) {
            var jsonData = {
                'disciplinaryData' : disciplinaryData,
            }
            $http.post('hrms/hr/others/disciplinaryaction/save', jsonData).success(function(data) {
                if (data) {
                    logger.logSuccess("Disciplinary Action Successfully Saved!");
                    $state.go('app.hrms.hr.others.disciplinaryaction.list');

                } else {
                    logger.logError("Error Not Saved!");
                }
            }).error(function(data) {
                logger.logSuccess("Error Not Savedd!");
            });

        }

    });
    module.registerController('disciplinaryActionEditCtrl', function($scope, $state, $http, ngDialog, logger, $stateParams, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService) {
        $scope.rowCollection = [];
        $scope.cancel = function() {
            $state.go('app.hrms.hr.others.disciplinaryaction.list');
        };
        $scope.disciplinaryObj = {
            edit : true
        };
        $scope.disciplinaryData = {
            hospitalId : '',
            designationId : '',
            branchId : '',
            departmentId : '',
            gradeId : '',
            employeeId : '',
            proceedings : '',
            suspendFrom : '',
            suspendTo : '',
            suspendedDays : '',
            issueWarning : '',
            reason : ''
        }

        var branchID;
        var deptID;
        var empID;
        $scope.disable=false;
        var disciplinary_proceedings_sk = $stateParams.disciplinary_proceedings_sk;
        if (disciplinary_proceedings_sk == undefined) {
            $scope.disciplinaryData.edit = false;
        } else {

            $http.get('hrms/hr/others/disciplinaryaction/getDisciplinaryDataEdit?disciplinaryId=' + disciplinary_proceedings_sk).success(function(result) {

                $scope.disciplinaryData.hospitalId = result.hospitalId;

                debugger;
                /*
                 * $scope.getbranchEdit($scope.disciplinaryData.hospitalId,
                 * result.branchId);
                 * $scope.getDepartmentEdit($scope.disciplinaryData.branchId,result.departmentId);
                 * $scope.getEmployeeEdit(result.branchId, result.employeeId);
                 */

                // $scope.disciplinaryData.branchId = result.branchId;
                branchID = result.branchId;
                deptID = result.departmentId;
                empID = result.employeeId;
                // $scope.disciplinaryData.departmentId =
                // result.departmentId.toString();;
                // $scope.disciplinaryData.employeeId = result.employeeId;

                $scope.disciplinaryData.designationId = result.designationId.toString();
                $scope.disciplinaryData.gradeId = result.gradeId.toString();
                $scope.disciplinaryData.reason = result.reason;
                $scope.disciplinaryData.disciplinary_proceedings_sk = result.disciplinary_proceedings_sk.toString();

                if (result.proceedings == "suspend") {
                    $scope.disciplinaryData.proceedings = "suspend";
                    $scope.disciplinaryData.suspendFrom = result.suspendFrom;
                    $scope.disciplinaryData.suspendTo = result.suspendTo;
                    $scope.disciplinaryData.suspendedDays = result.suspendedDays;
                }
                if (result.proceedings == "warn") {
                    $scope.disciplinaryData.proceedings = "warn";
                    $scope.disciplinaryData.issueWarning = result.issueWarning;
                }
            }).error(function(data) {

            });
        }

        $scope.getCompanyList = function() {
            var formCode = document.getElementById('formCode').value;
            

            $http.post("hrms/report/employeeReports/companyList" , formCode).success(function(response) {
                $scope.hospitalList = response.companyList;
                if (response.companyList.length == 1) {
                    $scope.disciplinaryData.hospitalId = response.companyList[0].id;
                    $scope.disable = true;
                    
                }

            })
        }
        $scope.getCompanyList();

        $scope.$watch('disciplinaryData.hospitalId', function(newValue, oldValue) {
            if (newValue != undefined && newValue != '') {
                $scope.disciplinaryData.departmentId = '';
                $scope.disciplinaryData.branchId = '';
                $scope.disciplinaryData.employeeId = '';
                $scope.getbranch(newValue);
            }
        });

        $scope.getbranch = function(hospitalId) {
            if (hospitalId != "" && hospitalId != null) {
                $http.post("hrms/report/employeeshift/getBranchList", hospitalId).success(function(datas) {
                    $scope.branchList = datas.branchList;
                    // alert(branchID);
                    $scope.disciplinaryData.branchId = branchID;
                });
            }
        }

        /*
         * $scope.getbranchEdit = function(hospitalId, branchId) {
         * 
         * if (hospitalId != "" && hospitalId != null) { alert("branch");
         * $http.post("hrms/report/employeeshift/getBranchList",
         * hospitalId).success(function(datas) { $scope.branchList =
         * datas.branchList; $scope.disciplinaryData.branchId = branchId; }); } }
         */
        $scope.$watch('disciplinaryData.branchId', function(newValue, oldValue) {
            if (newValue != undefined && newValue != '') {
                $scope.disciplinaryData.departmentId = '';
                $scope.disciplinaryData.employeeId = '';
                $scope.getDepartment(newValue);
                // $scope.getEmployee(newValue);
            }
        });

        $scope.$watch('disciplinaryData.departmentId', function(newValue, oldValue) {
            if (newValue != undefined && newValue != '') {
                $scope.disciplinaryData.employeeId = '';
                $scope.getEmployee(newValue);
                // $scope.getEmployee(newValue);
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
                $scope.disciplinaryData.departmentId = deptID.toString();
            });
        }

        $scope.getEmployee = function(branchId) {
            if ($scope.disciplinaryData.departmentId != "" && $scope.disciplinaryData.departmentId != null) {
                var resultBean = {
                    deptId : $scope.disciplinaryData.departmentId,
                    branchId : $scope.disciplinaryData.branchId
                }
                $http.post("hrms/hr/shiftallocation/getEmployeeList", $scope.disciplinaryData.branchId).success(function(datas) {
                    $scope.employeeList = datas.employeeList;
                    $scope.disciplinaryData.employeeId = empID;

                });
            }
        }

        $scope.getDesignationList = function() {
            $http.get('hrms/master/employeeMaster/getDesignationList').success(function(datas) {
                $scope.designationList = datas.designationList;

            }).error(function(data) {

            });
        }
        $scope.getDesignationList();

        $scope.getDesignationListEdit = function(designationId) {
            $http.get('hrms/master/employeeMaster/getDesignationList').success(function(datas) {
                $scope.designationList = datas.designationList;
                $scope.disciplinaryData.designationId = designationId;

            }).error(function(data) {

            });
        }

        $scope.getGradeList = function() {
            $http.get('hrms/master/employeeMaster/getGradeList').success(function(datas) {
                $scope.gradeList = datas.gradeList;

            }).error(function(data) {

            });
        }
        $scope.getGradeList();

        $scope.submit = function(disciplinaryActionForm, disciplinaryData) {
            if (new validationService().checkFormValidity(disciplinaryActionForm)) {
                $scope.update(disciplinaryData);
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.disciplinaryActionForm.$validationSummary), 5000, 'trustedHtml');
            }

        };
        $scope.update = function(disciplinaryData) {
            debugger;
            var jsonData = {
                'disciplinaryData' : disciplinaryData,
            }
            $http.post('hrms/hr/others/disciplinaryaction/update', jsonData).success(function(data) {
                if (data) {
                    logger.logSuccess("Disciplinary Action Successfully Updated!");
                    $state.go('app.hrms.hr.others.disciplinaryaction.list');

                } else {
                    logger.logError("Error Not Saved!");
                }
            }).error(function(data) {
                logger.logSuccess("Error Not Saved!");
            });
        }

    });

});
