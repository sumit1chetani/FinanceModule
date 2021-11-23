define([ 'payroll/tds/tds' ], function(module) {

    'use strict';

    module.registerController('otherincomeAddCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {

        define([ 'payroll/tds/tds' ], function(module) {

            'use strict';

            module.registerController('taxSectionAddCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {

                $scope.otherIncomeMaster = {
                    employeeOtherIncomeId : '',
                    otherIncomeHeadId : '',
                    otherIncomeHeadName : '',
                    employeeId : '',
                    employeeName : '',
                    departmentName : '',
                    companyName : '',
                    branchName : '',
                    amount : ''

                };

                $scope.isEdit = false;

                $scope.departmentList = [];
                $scope.employeeList = [];
                $scope.empDataList = [];

                var taxSectionCode = $location.search().taxSectionCode;
                if (taxSectionCode == undefined) {
                    $scope.taxSection.isEdit = false;
                } else {

                    $http.post('payroll/tds/taxsection/edit', taxSectionCode).success(function(result) {
                        if (result.isEdit == false) {
                            logger.logError("Please Try Again");
                        } else {
                            $scope.taxSection = result;
                        }

                    }).error(function(data) {

                    });
                }

                $scope.getDepartment = function(branchId) {
                    $http.post("payroll/payroll/payrollgeneration/getDepartmentList", branchId).success(function(datas) {
                        $scope.departmentList = datas.departmentList;
                    })
                }

                $scope.getEmployeeDetails = function() {

                    $http.get("payroll/payroll/payrollgeneration/getUserDetail").success(function(datas) {
                        $scope.otherIncomeMaster.companyId = datas.companyId;
                        $scope.otherIncomeMaster.branchId = datas.branchId;
                        $scope.otherIncomeMaster.companyName = datas.companyName;
                        $scope.otherIncomeMaster.branchName = datas.branchName;
                        $scope.getDepartment($scope.otherIncomeMaster.branchId);

                    })
                }

                $scope.getEmployeeDetails();

                $scope.getEmployeeList = function(departmentId) {
                    $http.post("payroll/payroll/payrollgeneration/getEmployeeList", departmentId).success(function(datas) {
                        $scope.employeeList = datas.employeeList;
                    })
                }

                $scope.cancel = function() {

                    $state.go('app.payroll.tds.taxsection.list');
                };

                var $validationProvider = $injector.get('$validation');
                $scope.submit = function(taxSectionForm) {
                    if ($scope.taxSection.isEdit != true) {
                        var saveData = $scope.taxSection;
                        sharedProperties.clearObject();
                        $validationProvider.validate(taxSectionForm).success(function() {
                            $http.post("payroll/tds/taxsection/save", saveData).success(function(result) {
                                if (result == false) {
                                    logger.logError("Tax Section Code already exist");
                                } else {
                                    $state.go('app.payroll.tds.taxsection.list');
                                }

                            })

                        }).error(function() {
                            toaster.pop('error', "Please correct the errors", logger.getErrorHtml(sharedProperties.getErrorObject()), 0, 'trustedHtml');
                        });

                    }
                }
                $scope.update = function(taxSectionForm) {
                    var updateData = $scope.taxSection;
                    sharedProperties.clearObject();
                    $validationProvider.validate(taxSectionForm).success(function() {
                        $http.post('payroll/tds/taxsection/update', updateData).success(function(result) {
                            if (result == false) {

                            } else {
                                logger.logSuccess("Tax Section Code updated successfully");
                                $state.go('app.payroll.tds.taxsection.list');
                            }
                        });
                    }).error(function() {
                        toaster.pop('error', "Please correct the errors", logger.getErrorHtml(sharedProperties.getErrorObject()), 0, 'trustedHtml');
                    });
                }

            });

        })
    });

})