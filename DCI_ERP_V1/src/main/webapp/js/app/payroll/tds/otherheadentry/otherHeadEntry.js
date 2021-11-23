define([ 'payroll/tds/tds' ], function(module) {
    'use strict';
    module.registerController('otherHeadEntryCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService) {
        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.isDisplay = true;
        $scope.isAuthorized = false;

        $scope.otherincomeList = {
            departmentId : '',
            companyId : '',
            companyName : '',
            branchName : '',
            departmentName : '',
            branchId : '',
            employeeId : '',
            financialYearId : '',
            amount : '',
            otherIncomeHeadId : '',
            isEdit : false,
            isOnLoad : false
        };

        $scope.getList = function() {

            $http.get("payroll/tds/otherheadentry/list").success(function(response) {
                $scope.rowCollection = response.otherHeadEntryList;

            });
        }

        $scope.getCompanyList = function() {

            $http.get("payroll/payroll/payrollgeneration/getCompanyList").success(function(datas) {
                $scope.companyList = datas.companyList;
            })
        }

        $scope.getBranchList = function(companyId, branchID) {
            $http.post("payroll/payroll/payrollgeneration/getBranchList", companyId).success(function(datas) {
                $scope.branchList = datas.branchList;
                $scope.otherincomeList.branchId = branchID;
                $scope.departmentList = [];
                $scope.employeeList = [];
            })
        }

        $scope.$watch('otherincomeList.companyId', function(newValue, oldValue) {
            var companyId = newValue;

            if ($scope.otherincomeList.companyId != '' && $scope.otherincomeList.isOnLoad == false) {
                $scope.otherincomeList.branchId = '';
                $scope.otherincomeList.branchName = '';
            }
            $http.post("payroll/payroll/payrollgeneration/getBranchList", companyId).success(function(datas) {
                $scope.branchList = datas.branchList;
                if ($scope.branchList.length == 1) {
                    $scope.otherincomeList.branchId = $scope.branchList[0].branchId;
                    $scope.otherincomeList.branchName = $scope.branchList[0].branchName;
                }
                $scope.otherincomeList.isOnLoad = false;
                $scope.otherincomeList.departmentId = '';
                $scope.departmentList = [];
                $scope.employeeList = [];
            })

        });

        $scope.getDepartment = function(branchId) {
            $http.post("payroll/payroll/payrollgeneration/getDepartmentList", branchId).success(function(datas) {
                $scope.departmentList = datas.departmentList;
                $scope.otherincomeList.departmentId = '';
                $scope.employeeList = [];
            })
        }

        $scope.$watch('otherincomeList.branchId', function(newValue, oldValue) {
            var branchId = newValue;
            $http.post("payroll/payroll/payrollgeneration/getDepartmentList", branchId).success(function(datas) {
                $scope.departmentList = datas.departmentList;
                $scope.otherincomeList.departmentId = '';
                $scope.employeeList = [];
            })

        });

        $scope.getEmployeeDetails = function() {

            $http.get("payroll/payroll/payrollgeneration/getUserDetail").success(function(datas) {
                $scope.getCompanyList();
                $scope.otherincomeList.isOnLoad = true;
                $scope.otherincomeList.companyId = datas.companyId;
                $scope.otherincomeList.companyName = datas.companyName;
                $scope.otherincomeList.branchId = datas.branchId;
                $scope.otherincomeList.branchName = datas.branchName;
                $scope.getDepartment(datas.branchId);

            })
        }
        $scope.getEmployeeDetails();

        $scope.getEmployeeList = function(departmentId) {
            var resultBean = {
                branchId : $scope.otherincomeList.branchId,
                departmentId : departmentId
            };
            $http.post("payroll/payroll/payrollgeneration/getEmployeeList", resultBean).success(function(datas) {
                $scope.employeeList = datas.employeeList;
                $scope.otherincomeList.employeeId = '';
            })
        }

        $scope.$watch('otherincomeList.departmentId', function(newValue, oldValue) {
            var departmentId = newValue;
            var branchId = $scope.otherincomeList.branchId;
            var resultBean = {
                branchId : branchId,
                departmentId : departmentId
            };
            $http.post("payroll/payroll/payrollgeneration/getEmployeeList", resultBean).success(function(datas) {
                $scope.employeeList = datas.employeeList;
                $scope.otherincomeList.employeeId = '';
            })

        });

        $scope.getFinancialYear = function() {
debugger;
            $http.get("payroll/tds/ptslab/getLoginfinancialYear").success(function(datas) {
                $scope.financialYearList = datas.financialYearList;

            })
        }

        $scope.getFinancialYear();

        $scope.submit = function(reimbursememtReqAddForm) {
            if (new validationService().checkFormValidity(reimbursememtReqAddForm)) {
                var employeeId = $scope.otherincomeList.employeeId;
                var financialYearId = $scope.otherincomeList.financialYearId;
                var isValid = true;
                var resultBean = {
                    employeeId : $scope.otherincomeList.employeeId,
                    financialYearId : $scope.otherincomeList.financialYearId
                }
                $http.post("payroll/tds/otherheadentry/list", resultBean).success(function(response) {

                    if (response.otherHeadEntryList != null && response.otherHeadEntryList != "" && response.otherHeadEntryList != undefined) {

                        $scope.rowCollection = response.otherHeadEntryList;
                        $scope.otherincomeList.isEdit = true;

                    } else {
                        $scope.otherincomeList.isEdit = false;
                        $scope.rowCollection = [];
                    }
                });
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(reimbursememtReqAddForm.$validationSummary), 5000, 'trustedHtml');
            }
        }

        $scope.update = function() {

            if ($scope.rowCollection.length > 0) {
                $http.post("payroll/tds/otherheadentry/save", $scope.rowCollection).success(function(result) {
                    if (result == false) {
                    } else {
                        logger.logSuccess("Employee TDS Declaration List Updated successfully");
                        if ($scope.otherincomeList.employeeId != undefined && $scope.otherincomeList.employeeId != null && $scope.otherincomeList.employeeId != '' && $scope.otherincomeList.financialYearId != undefined && $scope.otherincomeList.financialYearId != null && $scope.otherincomeList.financialYearId != '') {
                            var resultBean = {
                                employeeId : $scope.otherincomeList.employeeId,
                                financialYearId : $scope.otherincomeList.financialYearId
                            }
                            $http.post("payroll/tds/otherheadentry/list", resultBean).success(function(response) {

                                if (response.otherHeadEntryList != null && response.otherHeadEntryList != "" && response.otherHeadEntryList != undefined) {

                                    $scope.rowCollection = response.otherHeadEntryList;
                                    $scope.otherincomeList.isEdit = true;

                                } else {
                                    $scope.otherincomeList.isEdit = false;
                                    $scope.rowCollection = [];
                                }
                            });

                        }
                    }

                })
            }

        }

    });
});