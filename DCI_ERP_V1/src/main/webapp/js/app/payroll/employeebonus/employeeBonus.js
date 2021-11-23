//define([ 'payroll/payroll/payroll' ], function(module) {
    'use strict';
   // module.registerController('employeeBonusCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService) {
   	app.controller('employeeBonusCtrl', function($stateParams,$scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService,utilsService, $window,$timeout) {

    
    $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.isDisplay = true;
        $scope.isAuthorized = false;

        $scope.isAdd = true;
        $scope.isDelete = true;
        $scope.isUpload = true;

        $scope.employeebonus = {
            declaredamount : '',
            paidamount : '',
            bonusId : '',
            financialYear : '',
            employeeId : '',
            departmentId : '',
            companyName : '',
            branchName : '',
            branchId : '',
            companyId : '',
            isOnLoad : false,
            isEdit : false
        };

        $scope.employeebonus.isEdit = false;
        $scope.bonussummaryList = {
            bonusId : '',
            employeeId : '',
            employeeName : '',
            declaredAmount : '',
            paidAmount : '',
            paidOn : ''
        };

        var bonusId = $location.search().bonusId;
        if (bonusId != undefined && bonusId != null && bonusId != '') {
            $http.post("payroll/payroll/employeebonus/bonussummary", bonusId).success(function(data) {
                $scope.bonussummaryList = data.employeeBonusSummaryList;
            });
        }

        $scope.bonusSummary = function(bonusId) {
            $location.url('/payroll/employeebonus/summary?bonusId=' + bonusId);
        };

        $scope.bonusPay = function(bonusId) {
            $location.url('/payroll/employeebonus/pay?bonusId=' + bonusId);
        };
        $scope.ok = function() {
            $state.go('app.payroll.payroll.employeebonus.list');
        };

        $scope.getList = function() {

        }
        $scope.getCompanyList = function(){
        	$http.get($stateParams.tenantid	+ '/app/usermaster/getCompanyList?formCode='
    				+ 'F0377').success(
    		function(datas) {  
          //  $http.get("payroll/payroll/payrollgeneration/getCompanyList").success(function(datas) {
                $scope.companyList = datas;
                
                
                if ($scope.companyList.length >= 1) {
                    $scope.employeebonus.companyId = $scope.companyList[0].id;
                    $scope.employeebonus.companyName = $scope.companyList[0].companyName;
                }
                
            })
        }

        $scope.$watch('employeebonus.companyId', function(newValue, oldValue) {
            var companyId = newValue;
            if ($scope.employeebonus.companyId != '' && $scope.employeebonus.isOnLoad == false) {
                $scope.employeebonus.branchId = '';
                $scope.employeebonus.branchName = '';
                $scope.employeebonus.financialYear = '';
                $scope.getFinancialYear($scope.employeebonus.companyId);
            }

            $http.post("payroll/payroll/payrollgeneration/getBranchList", companyId).success(function(datas) {
                $scope.branchList = datas.branchList;
                $scope.employeebonus.isOnLoad = false;
                if ($scope.branchList.length == 1) {
                    $scope.employeebonus.branchId = $scope.branchList[0].id;
                    $scope.employeebonus.branchName = $scope.branchList[0].text;
                }
                $scope.employeebonus.departmentId = '';
                $scope.departmentList = [];
                $scope.employeeList = [];
            });

        });

        $scope.getBranchList = function(companyId, branchID) {
            $http.post("payroll/payroll/payrollgeneration/getBranchList", companyId).success(function(datas) {
                $scope.branchList = datas.branchList;
                $scope.employeebonus.branchId = branchID;
                $scope.departmentList = [];
                $scope.employeeList = [];
            })
        }

        $scope.checkAmount = function(declaredAmount, paidAmount, employeeId) {
            if (declaredAmount < paidAmount) {
                logger.logError("Declared Amount should be greater than the paid amount");
                angular.forEach($scope.rowCollection, function(value, key) {
                    if (employeeId == value.employeeId) {
                        value.declaredAmount = value.checkPayAmount;
                    }
                });
            }
        }

        $scope.$watch('employeebonus.branchId', function(newValue, oldValue) {
            var branchId = newValue;
            $http.post("payroll/payroll/payrollgeneration/getDepartmentList", branchId).success(function(datas) {
                $scope.departmentList = datas.departmentList;
                $scope.employeebonus.departmentId = '';
                $scope.employeeList = [];
            })

        });

        $scope.getDepartment = function(branchId) {
            $http.post("payroll/payroll/payrollgeneration/getDepartmentList", branchId).success(function(datas) {
                $scope.departmentList = datas.departmentList;
                $scope.employeebonus.departmentId = '';
                $scope.employeeList = [];
            })
        }

        $scope.getEmployeeDetails = function() {

            $http.get("payroll/payroll/payrollgeneration/getUserDetail").success(function(datas) {
                $scope.getCompanyList();
                $scope.employeebonus.isOnLoad = true;
                $scope.employeebonus.companyId = datas.companyId;
                $scope.employeebonus.companyName = datas.companyName;
                $scope.getFinancialYear($scope.employeebonus.companyId);
                $scope.getBranchList($scope.employeebonus.companyId, datas.branchId);
                $scope.getDepartment(datas.branchId);
            })
        }

        $scope.getBonusList = function(employeeBonusForm) {
            if (new validationService().checkFormValidity(employeeBonusForm)) {
                var resultBean = {
                    financialYear : $scope.employeebonus.financialYear,
                    branchId : $scope.employeebonus.branchId,
                    companyId : $scope.employeebonus.companyId,
                    dept : $scope.employeebonus.departmentId

                };
                $http.post("payroll/payroll/employeebonus/list", resultBean).success(function(response) {
                    if (response.employeeBonusList != null && response.employeeBonusList != "" && response.employeeBonusList != undefined) {
                        $scope.rowCollection = response.employeeBonusList;
                        $scope.employeebonus.isEdit = true;
                    } else {
                        $scope.employeebonus.isEdit = false;
                        $scope.rowCollection = [];
                    }
                });

            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(employeeBonusForm.$validationSummary), 5000, 'trustedHtml');
            }

        }

        $scope.updateBonusList = function() {
            if ($scope.rowCollection.length > 0) {
                $http.post("payroll/payroll/employeebonus/save", $scope.rowCollection).success(function(response) {
                    if (response == false) {
                        logger.logError("Sorry some error occurred!");
                    } else {
                        logger.logSuccess("Employee Bonus List Updated successfully");

                        if ($scope.employeebonus.companyId != undefined && $scope.employeebonus.companyId != null && $scope.employeebonus.companyId != '' && $scope.employeebonus.departmentId != undefined && $scope.employeebonus.departmentId != null && $scope.employeebonus.departmentId != '' && $scope.employeebonus.branchId != undefined && $scope.employeebonus.branchId != null && $scope.employeebonus.branchId != '' && $scope.employeebonus.financialYear != undefined && $scope.employeebonus.financialYear != null && $scope.employeebonus.financialYear != '') {

                            var resultBean = {
                                companyId : $scope.employeebonus.companyId,
                                dept : $scope.employeebonus.departmentId,
                                branchId : $scope.employeebonus.branchId,
                                financialYear : $scope.employeebonus.financialYear,

                            }

                            $http.post("payroll/payroll/employeebonus/list", resultBean).success(function(response) {
                                if (response.employeeBonusList != null && response.employeeBonusList != "" && response.employeeBonusList != undefined) {
                                    $scope.rowCollection = response.employeeBonusList;
                                    $scope.employeebonus.isEdit = true;
                                } else {
                                    $scope.employeebonus.isEdit = false;
                                    $scope.rowCollection = [];
                                }
                            });
                        }

                    }

                });
            }
        }

    /*    $scope.getFinancialYear = function(companyId) {
            $http.post("payroll/tds/ptslab/financialYear", companyId).success(function(datas) {
                $scope.financialYearList = datas.financialYearList;
            })
        }*/

        
        $scope.getFinancialYear = function(companyId) {
        $scope.financialYearList = [  
            
            {
                id : '2020-21',
                text : '2020-21'
            },
            
            {
                id : '2021-22',
                text : '2021-22'
            },
            {
                id : '2022-23',
                text : '2022-23'
            },
            
            {
                id : '2023-24',
                text : '2023-24'
            },
            {
                id : '2024-25',
                text : '2024-25'
            }
            
            ];

        }
        $scope.getEmployeeDetails();

    
});