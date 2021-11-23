//define([ 'hrms/hr/hr' ], function(module) {

    'use strict';

    app.Controller('employeeTransferListCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, $timeout, validationService) {

        $scope.employeeTransferobj = {
            employeeId : '',
            departmentId : '',
            designationId : '',
            divisionId : '',
            gradeId : '',
            companyName : '',
            departmentName : '',
            branchName : '',
            branchId : '',
            chargeemployeeId : '',
            reportMangrId : '',
            reportDesigId : '',
            employmentDate : '',
            transferEmployeeName : ''
        };

        $scope.date = '';

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
        $scope.employeeTransferobj.employmentDate = $scope.date;

        $scope.employeeList = [];
        $scope.departmentLists = [];
        $scope.designationList = [];
        $scope.divisionList = [];
        $scope.gradeList = [];
        $scope.branchList = [];
        $scope.employeeChargesList = [];
        $scope.reportToManagerLists = [];
        $scope.reportToDesigList = [];

        $scope.getEmployeeList = function() {
            $http.get("app/commonUtility/getEmployeeList").success(function(response) {
                $scope.employeeList = response;
            })
        }
        $scope.getEmployeeList();

        $scope.$watch('employeeTransferobj.employeeId', function(newValue, oldValue) {
            if (newValue != undefined && newValue != null && newValue != '') {
                $scope.getHospDeptBranchNames(newValue);
            }

        });

        $scope.getHospDeptBranchNames = function(employeeId) {
            $http.post('hrms/hr/employeeTransfer/getHospDeptBranchList', employeeId).success(function(datas) {
                $scope.employeeTransferobj.companyName = datas.hosdeptbranchnamelist[0].companyName;
                $scope.employeeTransferobj.departmentName = datas.hosdeptbranchnamelist[0].departmentName;
                $scope.employeeTransferobj.branchName = datas.hosdeptbranchnamelist[0].branchName;
                $scope.getBranchList(datas.hosdeptbranchnamelist[0].companyId);
            })
        }

        $scope.getBranchList = function(companyCode) {
          
            if (companyCode != "") {
                var myURL = 'hrms/master/employeeMaster/getBranchList?companyCode';
                $http({
                    method : 'post',
                    url : myURL,
                    data : companyCode,
                }).success(function(datas) {
            
                    $scope.branchList = datas.branchList;
                    debugger;
                    $scope.getDepartmentList(companyCode);

                });
            }
        }

        $scope.$watchCollection('[employeeTransferobj.employeeId,employeeTransferobj.chargeemployeeId]', function(newValues) {
            $scope.locationChange($scope.employeeTransferobj.employeeId, $scope.employeeTransferobj.chargeemployeeId);
        });

        $scope.locationChange = function(empId, transferId) {
            if (empId != "" && transferId != "" && empId != undefined && transferId != undefined && empId != null && transferId != null) {
                if (empId == transferId) {
                    $scope.employeeTransferobj.employeeId = '';
                    $scope.employeeTransferobj.chargeemployeeId = '';
                    logger.logError("Employee Name and Transfer Current Charges Should not be Same!");
                }
            }
        };
     
        $scope.getDepartmentList = function(companyCode) {
            debugger;
            $http.get('hrms/master/employeeMaster/getDepartmentList?companyCode=' +companyCode).success(function(response) {
                
    
                $scope.departmentList = response.departmentList;

            }).error(function(data) {

            });
            $http.get("appraisal/report/appraisalstatus/getDepartmentList").success(function(response) {
                $scope.departmentLists = response.departmentList;
            })
        };
 $scope.getDesignationList = function() {
            $http.get('hrms/master/employeeMaster/getDesignationList').success(function(datas) {
                $scope.designationList = datas.designationList;
            });
        }
        $scope.getDesignationList();

        $scope.getDivisionList = function() {
            $http.get('hrms/master/employeeMaster/getDivisionList').success(function(datas) {
                $scope.divisionList = datas.divisionList;
            });
        }
        $scope.getDivisionList();

        $scope.getGradeList = function() {
            $http.get('hrms/master/employeeMaster/getGradeList').success(function(datas) {
                $scope.gradeList = datas.gradeList;

            })
        }
        $scope.getGradeList();

        $scope.getEmployeeChargeList = function() {
            $http.get("app/commonUtility/getEmployeeList").success(function(response) {
                $scope.employeeChargesList = response;
            })
        }
        $scope.getEmployeeChargeList();
/*
        $scope.$watch('employeeTransferobj.departmentId', function(newValue, oldValue) {
            var brn = $scope.employeeTransferobj.branchId;
            if (newValue != null && newValue != "") {
                $scope.getReportManagers(newValue);
            }
        });*/
        $scope.$watch('employeeTransferobj.departmentId', function(newValue, oldValue) {
            if (newValue != undefined && newValue != '' && newValue != "") {
            debugger
            var depId= $scope.employeeTransferobj.departmentId;
            var branchId = $scope.employeeTransferobj.branchId;
           
            var url = "hrms/master/employeeAdminMaster/getReportManager?depId=" + depId + "&branchId=" + branchId;
            $http.get(url).success(function(datas) {
            $scope.reportToManagerLists = datas;
            }).error(function(data) {
            });
            }
         
        });
     /*
           
          //  $scope.getReportManager();
        $scope.getReportManagers = function(brn) {
            debugger
            var brnId = $scope.employeeTransferobj.branchId;
            $http.get("hrms/master/employeeMaster/getReportManager?&branchId=" + brnId).success(function(datas) {
                $scope.reportToManagerLists = datas;
            })
        }*/

        $scope.$watch('employeeTransferobj.reportMangrId', function(newValue, oldValue) {
            if (newValue != null && newValue != "") {
                $scope.getReportToDesigList(newValue);
            }
        });

        $scope.getReportToDesigList = function(desig) {
            $http.post('hrms/master/employeeMaster/getReportToDesigList', desig).success(function(datas) {
                $scope.reportToDesigList = datas.reportToDesigList;
            }).error(function(data) {
            });
        }

        $scope.branch = {};
        $scope.department = {};
        $scope.designation = {};
        $scope.division = {};
        $scope.grade = {};
        $scope.reportingAuthority = {};
        $scope.reportDesignation = {};
        $scope.transferEmployee = {};

        $scope.saveTransfer = function(employeeTransferAddForm, employeeTransferobj) {
            if (new validationService().checkFormValidity(employeeTransferAddForm)) {

                /**
                 * ******************* Added for Employee History
                 * ***********************************
                 */

                var branchName = $scope.branch.text;
                var departmentName = $scope.department.text;
                var designation = $scope.designation.text;
                var division = $scope.division.text;
                var grade = $scope.grade.text;
                var reportingAuthority = $scope.reportingAuthority.text;
                var reportDesigName = $scope.reportDesignation.text;

                $scope.employeeDuplicate = [ {
                    columnName : 'Hospital Name',
                    oldValue : '',
                    newValue : $scope.employeeTransferobj.companyName,
                    active : false,
                    index : 0
                }, {
                    columnName : 'Branch',
                    oldValue : $scope.employeeTransferobj.branchName,
                    newValue : branchName,
                    active : false,
                    index : 1
                }, {
                    columnName : 'Department',
                    oldValue : $scope.employeeTransferobj.departmentName,
                    newValue : departmentName,
                    active : false,
                    index : 2
                }, {
                    columnName : 'Designation',
                    oldValue : '',
                    newValue : designation,
                    active : false,
                    index : 3
                }, {
                    columnName : 'Division',
                    oldValue : '',
                    newValue : division,
                    active : false,
                    index : 4
                }, {
                    columnName : 'Grade',
                    oldValue : '',
                    newValue : grade,
                    active : false,
                    index : 5
                }, {
                    columnName : 'Reporting Authority',
                    oldValue : '',
                    newValue : reportingAuthority,
                    active : false,
                    index : 6
                }, {
                    columnName : 'Report To Designation',
                    oldValue : '',
                    newValue : reportDesigName,
                    active : false,
                    index : 7
                } ];

                $scope.employeeTransferobj.employeeDuplicateList = $scope.employeeDuplicate;

                $scope.employeeTransferobj.transferEmployeeName = $scope.transferEmployee.text;

                /**
                 * ******************* Added for Employee History
                 * ***********************************
                 */

                $http.post('hrms/hr/employeeTransfer/saveTransfer', $scope.employeeTransferobj).success(function(result) {
                    if (result.success == true) {
                        logger.logSuccess("Saved Successfully!");
                    } else {
                        logger.logError("Not Saved!");
                    }
                });
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(employeeTransferAddForm.$validationSummary), 5000, 'trustedHtml');
            }
        };

        $scope.reset = function() {
            $scope.employeeTransferobj = {
                employeeId : '',
                departmentId : '',
                designationId : '',
                divisionId : '',
                gradeId : '',
                companyName : '',
                departmentName : '',
                branchName : '',
                branchId : '',
                chargeemployeeId : '',
                reportMangrId : '',
                reportDesigId : '',
                employmentDate : '',
                transferEmployeeName : ''
            };
        };

      $scope.cancel = function() {
          $state.go("app.hrms.welcome");
        };

    });

//});