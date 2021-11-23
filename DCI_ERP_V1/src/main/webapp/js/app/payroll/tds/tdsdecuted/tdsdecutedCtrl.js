define([ 'payroll/payroll/payroll' ], function(module) {
    'use strict';
    module.registerController('tdsdecutedCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService) {
        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.isEdit = false;
        $scope.isAuthorized = false;
        $scope.isDisplay = true;

        $scope.employeeTds = {
            departmentId : '',
            branchId : '',
            tds : '',
            branchName : '',
            companyName : '',
            companyId : '',
            month : '',
            year : '',
            monthYear : '',
            isEdit : false,
            isOnLoad : false,
            id : ''
        };

        var temp = [ {
            id : '01',
            text : 'January'
        }, {
            id : '02',
            text : 'February'
        }, {
            id : '03',
            text : 'March'
        }, {
            id : '04',
            text : 'April'
        }, {
            id : '05',
            text : 'May'
        }, {
            id : '06',
            text : 'June'
        }, {
            id : '07',
            text : 'July'
        }, {
            id : '08',
            text : 'August'
        }, {
            id : '09',
            text : 'September'
        }, {
            id : '10',
            text : 'October'
        }, {
            id : '11',
            text : 'November'
        }, {
            id : '12',
            text : 'December'
        }, ]

        $scope.monthList = temp;

        var temp1 = [ {
            id : '2015',
            text : '2015'
        }, {
            id : '2016',
            text : '2016'
        }, {
            id : '2017',
            text : '2017'
        }, {
            id : '2018',
            text : '2018'
        }, {
            id : '2019',
            text : '2019'
        }, {
            id : '2020',
            text : '2020'
        }, ]

        $scope.yearList = temp1;

        $scope.employeeTds.isEdit = false;

        $scope.getCompanyList = function() {

            $http.get("payroll/payroll/payrollgeneration/getCompanyList").success(function(datas) {
                $scope.companyList = datas.companyList;
            })
        }

        $scope.getBranchList = function(companyId, branchID) {
            $http.post("payroll/payroll/payrollgeneration/getBranchList", companyId).success(function(datas) {
                $scope.branchList = datas.branchList;
                $scope.employeeTds.branchId = branchID;
                $scope.departmentList = [];
                $scope.employeeList = [];
            })
        }

        $scope.$watch('employeeTds.companyId', function(newValue, oldValue) {
            var companyId = newValue;

            if ($scope.employeeTds.companyId != '' && $scope.employeeTds.isOnLoad == false) {
                $scope.employeeTds.branchId = '';
                $scope.employeeTds.branchName = '';
            }

            $http.post("payroll/payroll/payrollgeneration/getBranchList", companyId).success(function(datas) {
                $scope.employeeTds.isOnLoad = false;
                $scope.branchList = datas.branchList;
                if (datas.branchList.length == 1) {
                    $scope.employeeTds.branchId = datas.branchList[0].branchId;
                    $scope.employeeTds.branchName = datas.branchList[0].branchName;
                }
                $scope.employeeTds.departmentId = '';
                $scope.departmentList = [];
                $scope.employeeList = [];
            })

        });

        $scope.getDepartment = function(branchId) {
            $http.post("payroll/payroll/payrollgeneration/getDepartmentList", branchId).success(function(datas) {
                $scope.departmentList = datas.departmentList;
                $scope.employeeTds.departmentId = '';
                $scope.employeeList = [];
            })
        }

        $scope.$watch('employeeTds.branchId', function(newValue, oldValue) {
            var branchId = newValue;
            $http.post("payroll/payroll/payrollgeneration/getDepartmentList", branchId).success(function(datas) {
                $scope.departmentList = datas.departmentList;
                $scope.employeeTds.departmentId = '';
                $scope.employeeList = [];
            })

        });

        $scope.getEmployeeDetails = function() {

            $http.get("payroll/payroll/payrollgeneration/getUserDetail").success(function(datas) {
                $scope.getCompanyList();
                $scope.employeeTds.isOnLoad = true;
                $scope.employeeTds.companyId = datas.companyId;
                $scope.employeeTds.companyName = datas.companyName;
                $scope.employeeTds.branchId = datas.branchId;
                $scope.employeeTds.branchName = datas.branchName;
                $scope.getBranchList($scope.employeeTds.companyId, datas.branchId);
                $scope.getDepartment(datas.branchId);

            });
        }

        $scope.getMonthYearList = function() {

            $http.get("payroll/payroll/payrollgeneration/getMonthYearList").success(function(datas) {
                $scope.monthYearList = datas.monthYearList;
            })
        }

        $scope.getMonthYearList();

        $scope.getEmployeeDetails();

        $scope.getemployeeTds = function(employeeTdsForm) {
            if (new validationService().checkFormValidity(employeeTdsForm)) {
                var companyId = $scope.employeeTds.companyId;
                var branchId = $scope.employeeTds.branchId;
                var departmentId = $scope.employeeTds.departmentId;
                var monthYear = $scope.employeeTds.month + $scope.employeeTds.year;
                var isValid = true;
                if (companyId == '' || companyId == undefined) {
                    companyId = null;
                }
                if (branchId == '' || branchId == undefined) {
                    branchId = null;
                }
                if (departmentId == '' || departmentId == undefined) {
                    departmentId = null;
                }
                var resultBean = {
                    companyId : companyId,
                    branchId : branchId,
                    departmentId : departmentId,
                    monthYear : monthYear
                }
                $http.post("payroll/tds/tdsDeclaration/generationlist", resultBean).success(function(response) {
                    if (response.tdsDeclarationList != null && response.tdsDeclarationList != "" && response.tdsDeclarationList != undefined) {
                        $scope.rowCollection = response.tdsDeclarationList;
                    }
                }).error(function(data) {
                });

            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(employeeTdsForm.$validationSummary), 5000, 'trustedHtml');
            }

        };

        $scope.fileUpload = function() {
            ngDialog.close();
            ngDialog.open({
                template : 'fileModal',
                scope : $scope
            });
        };

        $rootScope.uploadFile = function(element) {

            $scope.excelfile = element.files[0];
        }

        $rootScope.closeFileDialog = function() {
            ngDialog.close();
        };

        $rootScope.uploadLop = function() {
            ngDialog.close();
            var excelfile = $scope.excelfile;
            var fileExtension = excelfile.name;
            var fName = [];
            fName = fileExtension.split(".");
            for (var i = 0; i < fName.length; i++) {
                if (fName[i] == "xls" || fName[i] == "xlsx") {
                    var frmData = new FormData();
                    frmData.append("file", excelfile);
                    $.ajax({

                    });
                }

            }
        }

        $scope.updateLOPList = function() {
            
        };
    });

});
