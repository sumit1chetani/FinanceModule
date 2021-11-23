define([ 'payroll/tds/tds' ], function(module) {
    'use strict';
    module.registerController('ptSlabAddCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {

        $scope.ptSlab = {
            serialNumber : '',
            branchId : '',
            rangeFrom : '',
            rangeTo : '',
            charge : '',
            branchName : '',
            companyName : '',
            companyId : '',
            financialYear : '',
            isAuthorize : false,
            isEdit : false
        };

        $scope.isEdit = false;
        var financialYear = $location.search().financialYear;
        var branchId = $location.search().branchId;
        var rangeFrom = $location.search().rangeFrom;

        $scope.getCompanyList = function() {

            $http.get("payroll/payroll/payrollgeneration/getCompanyList").success(function(datas) {
                $scope.companyList = datas.companyList;
            })
        }

        $scope.getBranchList = function(companyId, branchID) {
            $http.post("payroll/payroll/payrollgeneration/getBranchList", companyId).success(function(datas) {
                $scope.branchList = datas.branchList;
                $scope.ptSlab.branchId = branchID;
                $scope.departmentList = [];
                $scope.employeeList = [];
            })
        }

        $scope.getEmployeeDetails = function() {

            $http.get("payroll/payroll/payrollgeneration/getUserDetail").success(function(datas) {
                $scope.getCompanyList();
                $scope.ptSlab.companyId = datas.companyId;
                $scope.ptSlab.companyName = datas.companyName;
                $scope.getBranchList($scope.ptSlab.companyId, datas.branchId);

            })
        }

        $scope.getEmployeeDetails();

        $scope.getFinancialYear = function() {

            $http.get("payroll/tds/ptslab/financialYearList").success(function(datas) {
                $scope.financialYearList = datas.financialYearList;
            })
        }

        $scope.getFinancialYear();

        if (financialYear == undefined && branchId == undefined && rangeFrom == undefined) {
            $scope.ptSlab.isEdit = false;
        } else {
            $scope.ptSlab.isEdit = true;
            var resultBean = {
                financialYear : financialYear,
                branchId : branchId,
                rangeFrom : rangeFrom
            };
            $http.post('payroll/tds/ptslab/edit', resultBean).success(function(result) {
                if (result.isEdit == false) {
                    logger.logError("Please Try Again");
                } else {
                    $scope.ptSlab.rangeFrom = result.rangeFrom;
                    $scope.ptSlab.rangeTo = result.rangeTo;
                    $scope.ptSlab.charge = result.charge;
                    $scope.ptSlab.financialYear = result.financialYear;
                    $scope.ptSlab.branchName = result.branchName;

                }

            }).error(function(data) {

            });

        }

        $scope.submit = function(taxSectionForm) {
            if ($scope.ptSlab.isEdit != true) {
                var saveData = $scope.ptSlab;
                var ptslabList = [];
                $http.get("payroll/tds/ptslab/list").success(function(datas) {
                    $scope.financialYearList = datas.financialYearList;
                })

                $http.post("payroll/tds/ptslab/save", saveData).success(function(result) {
                    if (result == false) {
                        logger.logError("Tax Section Code already exist");
                    } else {
                        $state.go('app.payroll.tds.ptslab.list');
                    }

                });

            }
        }

        $scope.update = function(taxSectionForm) {
            var updateData = $scope.ptSlab;
            $http.post('payroll/tds/ptslab/update', updateData).success(function(result) {
                if (result == false) {

                } else {
                    logger.logSuccess("Ptslab updated successfully");
                    $state.go('app.payroll.tds.ptslab.list');
                }
            });

        }

        $scope.cancel = function() {

            $state.go('app.payroll.tds.ptslab.list');
        };

    })

});
