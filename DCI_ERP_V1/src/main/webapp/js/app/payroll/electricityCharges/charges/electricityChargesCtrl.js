define([ 'payroll/payroll/payroll' ], function(module) {
    'use strict';
    module.registerController('electricityChargesCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService) {
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
        $scope.ebList = {
            departmentId : '',
            branchId : '',
            branchName : '',
            companyName : '',
            companyId : '',
            monthYear : '',
            month : '',
            year : '',
            isEdit : false,
            isOnLoad : false
        };
        $scope.loplist = {
            monthYear : ''
        }

        $scope.ebList.isEdit = false;
        $scope.ebList = [];

        $scope.getCompanyList = function() {

            $http.get("payroll/payroll/payrollgeneration/getCompanyList").success(function(datas) {
                $scope.companyList = datas.companyList;
            })
        }

        $scope.$watch('ebList.companyId', function(newValue, oldValue) {
            var companyId = newValue;
            if ($scope.ebList.companyId != '' && $scope.ebList.isOnLoad == false) {
                $scope.ebList.branchId = '';
                $scope.ebList.branchName = '';
            }
            $http.post("payroll/payroll/payrollgeneration/getBranchList", companyId).success(function(datas) {
                $scope.ebList.isOnLoad = false;
                $scope.branchList = datas.branchList;
                if ($scope.branchList.length == 1) {
                    $scope.ebList.branchId = $scope.branchList[0].branchId;
                    $scope.ebList.branchName = $scope.branchList[0].branchName;
                }
                $scope.ebList.departmentId = '';
                $scope.departmentList = [];
            })

        });

        $scope.getBranchList = function(companyId, branchID) {
            $http.post("payroll/payroll/payrollgeneration/getBranchList", companyId).success(function(datas) {
                $scope.branchList = datas.branchList;
                $scope.ebList.branchId = branchID;
                $scope.departmentList = [];
            })
        }

        $scope.getDepartment = function(branchId) {
            $http.post("payroll/payroll/payrollgeneration/getDepartmentList", branchId).success(function(datas) {
                $scope.departmentList = datas.departmentList;
                $scope.ebList.departmentId = '';
                $scope.employeeList = [];
            })
        }

        $scope.$watch('ebList.branchId', function(newValue, oldValue) {
            var branchId = newValue;
            $http.post("payroll/payroll/payrollgeneration/getDepartmentList", branchId).success(function(datas) {
                $scope.departmentList = datas.departmentList;
                $scope.ebList.departmentId = '';
                $scope.employeeList = [];
            })

        });

        $scope.getEmployeeDetails = function() {

            $http.get("payroll/payroll/payrollgeneration/getUserDetail").success(function(datas) {
                $scope.getCompanyList();
                $scope.ebList.companyId = datas.companyId;
                $scope.ebList.companyName = datas.companyName;
                $scope.ebList.isOnLoad = true;
                $scope.getBranchList($scope.ebList.companyId, datas.branchId);
                $scope.getDepartment(datas.branchId);

            });
        }

        $scope.getEmployeeDetails();

        $scope.getMonthYearList = function() {

            $http.get("payroll/payroll/payrollgeneration/getMonthYearList").success(function(datas) {
                $scope.monthYearList = datas.monthYearList;
            })
        }

        $scope.getMonthYearList();

        $scope.getebList = function(ebListForm) {
            // sharedProperties.clearObject();
            if (new validationService().checkFormValidity(ebListForm)) {
                var companyId = $scope.ebList.companyId;
                var branchId = $scope.ebList.branchId;
                var departmentId = $scope.ebList.departmentId;
                var monthYear = $scope.loplist.monthYear;
                var resultBean = {
                    companyId : companyId,
                    branchId : branchId,
                    departmentId : departmentId,
                    monthYear : monthYear
                }
                $http.post("payroll/payroll/electricalCharges/list", resultBean).success(function(response) {
                    if (response.electricalChargesList != null && response.electricalChargesList != "" && response.electricalChargesList != undefined) {
                        $scope.rowCollection = response.electricalChargesList;
                        $scope.ebList.isEdit = true;
                    } else {
                        $scope.ebList.isEdit = false;
                        $scope.rowCollection = [];
                    }
                }).error(function(data) {

                });
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(ebListForm.$validationSummary), 5000, 'trustedHtml');
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

        $rootScope.uploadEbCharge = function() {
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
                        type : "POST",
                        url : "payroll/payroll/electricalCharges/uploadfile",
                        data : frmData,
                        contentType : false,
                        processData : false,
                        success : function(result) {
                            if (result.success) {
                                if (result.chargesBean.isValid) {
                                    logger.logSuccess("File Uploaded Successfully");

                                } else {
                                    logger.logError(result.chargesBean.errorMessage);
                                }

                            } else {
                                logger.logError("Fail to upload");
                            }

                        }

                    });
                }

            }
        }

        // Export to xl

        $scope.exportExcel = function(ebListForm) {
            if (new validationService().checkFormValidity(ebListForm)) {
                var companyId = $scope.ebList.companyId;
                var branchId = $scope.ebList.branchId;
                var departmentId = $scope.ebList.departmentId;
                var monthYear = $scope.loplist.monthYear;
                var resultBean = {
                    companyId : companyId,
                    branchId : branchId,
                    departmentId : departmentId,
                    monthYear : monthYear
                }

                $http.post('payroll/payroll/electricalCharges/exportExcel', resultBean).success(function(data) {

                    if (data.success == true) {
                        $scope.ebList.Show = true;
                        logger.logSuccess("File Exported Successfully");
                        $('#btnRowDivId').append('<a id="captainMsglink" href="tempdoc/Employee_EB_Charge_File.xls" class="control-label" download="Employee_EB_Charge_File.xls"></a>');
                        $("#captainMsglink").bind('click', function() {
                        });
                        $('#captainMsglink').simulateClick('click');
                    } else {
                        $scope.ebList.Show = false;
                        logger.logError("Error Please Try Again")

                    }
                }).error(function(data) {
                });

            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(employeeTdsForm.$validationSummary), 5000, 'trustedHtml');
            }

        };

        $.fn.simulateClick = function() {
            return this.each(function() {
                if ('createEvent' in document) {
                    var doc = this.ownerDocument, evt = doc.createEvent('MouseEvents');
                    evt.initMouseEvent('click', true, true, doc.defaultView, 1, 0, 0, 0, 0, false, false, false, false, 0, null);
                    this.dispatchEvent(evt);
                } else {
                    this.click(); // IE
                }
            });
        }

        $scope.calculateUnits = function(employeeId, monthyear, units) {
            angular.forEach($scope.rowCollection, function(value, key) {
                if (value.employeeId == employeeId) {
                    value.charges = '';
                }

            });
            if (units != undefined && units != null && units != '') {
                $http.post("payroll/payroll/electricalCharges/getChargeValue", units).success(function(result) {
                    angular.forEach($scope.rowCollection, function(value, key) {
                        if (value.employeeId == employeeId) {
                            value.charges = '';
                            value.charges = result.chargesBean.charges;
                        }

                    });
                })
            }

        }

        $scope.updateebList = function() {
            if ($scope.rowCollection.length > 0) {
                $http.post("payroll/payroll/electricalCharges/save", $scope.rowCollection).success(function(result) {
                    if (result == false) {
                    } else {
                        logger.logSuccess("Electrical Charges List Updated successfully");

                        if ($scope.ebList.companyId != undefined && $scope.ebList.companyId != null && $scope.ebList.companyId != '' && $scope.ebList.departmentId != undefined && $scope.ebList.departmentId != null && $scope.ebList.departmentId != '' && $scope.ebList.branchId != undefined && $scope.ebList.branchId != null && $scope.ebList.branchId != '' && $scope.loplist.monthYear != undefined && $scope.loplist.monthYear != null && $scope.loplist.monthYearr != '') {

                            var resultBean = {
                                companyId : $scope.ebList.companyId,
                                departmentId : $scope.ebList.departmentId,
                                branchId : $scope.ebList.branchId,
                                monthYear : $scope.loplist.monthYear,

                            }

                            $http.post("payroll/payroll/electricalCharges/list", resultBean).success(function(response) {
                                if (response.electricalChargesList != null && response.electricalChargesList != "" && response.electricalChargesList != undefined) {
                                    $scope.rowCollection = response.electricalChargesList;
                                    $scope.ebList.isEdit = true;
                                } else {
                                    $scope.ebList.isEdit = false;
                                    $scope.rowCollection = [];
                                }
                            });

                        }

                    }

                })
            }
        };

        $scope.updatePayComponent = function() {
            if ($scope.rowCollection.length > 0) {
                $http.post("payroll/payroll/electricalCharges/savePayComponent", $scope.rowCollection).success(function(result) {
                    if (result == false) {
                    } else {
                        logger.logSuccess("Electrical Charges List Updated successfully");

                    }

                })
            }
        };
    });

});
