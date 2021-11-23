//define([ 'payroll/tds/tds' ], function(module) {
    'use strict';
   // module.registerController('deductionCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, $filter, sharedProperties, toaster, $rootScope, validationService) {
   	app.controller('deductionCtrl', function($stateParams,$scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService,utilsService, $window,$timeout) {

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

        $scope.ptslabList = {
            departmentId : '',
            companyName : '',
            branchName : '',
            departmentName : '',
            branchId : '',
            employeeId : '',
            companyId : '',
            financialYear : '',
            Show : false,
            isOnLoad : false,
            monthYear : '',
            amount : '',
            otherIncomeHeadId : '',
            isEdit : false
        };

        $scope.getList = function() {
            $http.get("payroll/tds/otherheadentry/list").success(function(response) {
                $scope.rowCollection = response.otherHeadEntryList;

            });
        }

        $scope.getCompanyList = function() {
        	$http.get($stateParams.tenantid	+ '/app/usermaster/getCompanyList?formCode='
    				+ 'F0381').success(
    		function(datas) {   
           // $http.get("payroll/payroll/payrollgeneration/getCompanyList").success(function(datas) {
                $scope.companyList = datas;
                if ($scope.companyList.length >= 1) {
                    $scope.ptslabList.companyId = $scope.companyList[0].id;
                    $scope.ptslabList.companyName = $scope.companyList[0].companyName;
                }
                
                
                
            })
        }

        $scope.$watch('ptslabList.companyId', function(newValue, oldValue) {
            var companyId = newValue;
            if ($scope.ptslabList.companyId != '' && $scope.ptslabList.isOnLoad == false) {
                $scope.ptslabList.branchId = '';
                $scope.ptslabList.branchName = '';
                $scope.ptslabList.financialYear = '';
                $scope.getFinancialYear($scope.ptslabList.companyId);
            }

            $http.post("payroll/payroll/payrollgeneration/getBranchList", companyId).success(function(datas) {
                $scope.branchList = datas.branchList;
                if ($scope.branchList.length == 1) {
                    $scope.ptslabList.branchId = $scope.branchList[0].id;
                    $scope.ptslabList.branchName = $scope.branchList[0].text;
                }
                $scope.ptslabList.isOnLoad = false;
                $scope.ptslabList.departmentId = '';
                $scope.departmentList = [];
                $scope.employeeList = [];
            })

        });

        $scope.getBranchList = function(companyId, branchID) {
            $http.post("payroll/payroll/payrollgeneration/getBranchList", companyId).success(function(datas) {
                $scope.branchList = datas.branchList;
                $scope.ptslabList.branchId = branchID;
                $scope.ptslabList.Show = false;
                $scope.departmentList = [];
                $scope.employeeList = [];
            })
        }

        $scope.getDepartment = function(branchId) {
            $http.post("payroll/payroll/payrollgeneration/getDepartmentList", branchId).success(function(datas) {
                $scope.departmentList = datas.departmentList;
                $scope.ptslabList.departmentId = '';
                $scope.ptslabList.Show = false;
                $scope.employeeList = [];
            })
        }

        $scope.getType = function() {
            $http.get("payroll/payroll/payrollgeneration/getTypeList").success(function(datas) {
                $scope.typeList = datas.typeList;
                // $scope.ptslabList.departmentId = '';
                // $scope.ptslabList.Show = false;
                // $scope.employeeList = [];
            })
        }

        $scope.getType();

        $scope.$watch('ptslabList.branchId', function(newValue, oldValue) {
            var branchId = newValue;
            $http.post("payroll/payroll/payrollgeneration/getDepartmentList", branchId).success(function(datas) {
                $scope.departmentList = datas.departmentList;
                $scope.ptslabList.departmentId = '';
                $scope.employeeList = [];
            })

        });

        $scope.getEmployeeDetails = function() {
            $http.get("payroll/payroll/payrollgeneration/getUserDetail").success(function(datas) {
                $scope.getCompanyList();
                $scope.ptslabList.companyId = datas.companyId;
                $scope.ptslabList.companyName = datas.companyName;
                $scope.ptslabList.isOnLoad = true;
               $scope.getFinancialYear($scope.ptslabList.companyId);
                $scope.getBranchList($scope.ptslabList.companyId, datas.branchId);
                $scope.ptslabList.branchName = datas.branchName;
                $scope.getDepartment(datas.branchId);

            })
        }

   /*     $scope.getFinancialYear = function(companyId) {
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
        

        $scope.monthList = [ {
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

        $scope.getEmployeeDetails();

        $scope.update = function() {
            if ($scope.rowCollection != undefined && $scope.rowCollection != null && $scope.rowCollection != '') {

                if ($scope.rowCollection.length > 0) {
                    $scope.ptList = [];
                    angular.forEach($scope.rowCollection, function(value, key) {
                        var i = 1;
                        var monthvalue;
                        var monthamount;
                        $scope.datelist = value.dateList;
                        angular.forEach($scope.datelist, function(value, key) {
                            monthamount = value.amount;
                            monthvalue = value.monthYear;
                           /* if (i == $scope.datelist.length) {
                                monthamount = value.amount;
                                monthvalue = value.monthYear;
                            }*/
                            $scope.ptList.push({
                                "employeeId" : value.employeeId,
                                "employeeName" : value.employeeName,
                                "amount" : monthamount,
                                "monthYear" : monthvalue,
                                "typeId" : $scope.ptslabList.typeList
                            })
                            i = i + 1;
                        });
                    });
                    $http.post("payroll/tds/ptslab/insertEmployeeDeductionList", $scope.ptList).success(function(response) {
                        if (response) {
                            logger.logSuccess("Employee Deduction Slab List Updated Successfully");
                            if ($scope.ptslabList.companyId != undefined && $scope.ptslabList.companyId != null && $scope.ptslabList.companyId != '' && $scope.ptslabList.departmentId != undefined && $scope.ptslabList.departmentId != null && $scope.ptslabList.departmentId != '' && $scope.ptslabList.branchId != undefined && $scope.ptslabList.branchId != null && $scope.ptslabList.branchId != '' && $scope.ptslabList.typeList != undefined && $scope.ptslabList.typeList != null && $scope.ptslabList.typeList != '' && $scope.ptslabList.financialYear != undefined && $scope.ptslabList.financialYear != null && $scope.ptslabList.financialYear != '') {

                                var resultBean = {
                                    companyId : $scope.ptslabList.companyId,
                                    dept : $scope.ptslabList.departmentId,
                                    branchId : $scope.ptslabList.branchId,
                                    typeId : $scope.ptslabList.typeList,
                                    financialYear : $scope.ptslabList.financialYear,

                                }
                                $http.post("payroll/tds/ptslab/generatetypelist", resultBean).success(function(response) {
                                    if (response.professionaltxList != null && response.professionaltxList != "" && response.professionaltxList != undefined) {
                                        $scope.rowCollection = response.professionaltxList.emplList;
                                        $scope.headlablist = response.professionaltxList.emplList[0].dateList;
                                    } else {
                                        $scope.rowCollection = [];
                                        $scope.headlablist = [];
                                    }
                                })

                            }
                        } else {
                            logger.logError("Some Error Occured");
                        }
                    }).error(function(data) {
                    });
                } else {
                    logger.logError("Please Add Atleast one row");
                }
            } else {
                logger.logError("Please Add Atleast one row");
            }

        }

        $scope.headlablist = [];

        $scope.validate = function(ptslabgenerationForm) {
            debugger;
            if (new validationService().checkFormValidity(ptslabgenerationForm)) {
                var companyId = $scope.ptslabList.companyId;
                var dept = $scope.ptslabList.departmentId;
                var branchId = $scope.ptslabList.branchId;
                var typeId = $scope.ptslabList.typeList;
                var financialYear = $scope.ptslabList.financialYear;
                var resultBean = {
                    companyId : $scope.ptslabList.companyId,
                    dept : $scope.ptslabList.departmentId,
                    branchId : $scope.ptslabList.branchId,
                    typeId : $scope.ptslabList.typeList,
                    financialYear : $scope.ptslabList.financialYear,

                }
                var headList = [];

                $http.post("payroll/tds/ptslab/generatetypelist", resultBean).success(function(response) {
                    $scope.rowCollection = response.professionaltxList.emplList;
                    $scope.headlablist = response.professionaltxList.emplList[0].dateList;
                }).error(function(data) {
                });

            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.ptslabgenerationForm.$validationSummary), 555000, 'trustedHtml');
            }

        }

        // File upload Functionality

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
        }

        $rootScope.uploadPTSlab = function() {
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
                        url : "payroll/tds/ptslab/uploadfile",
                        data : frmData,
                        contentType : false,
                        processData : false,
                        success : function(result) {
                            if (result.success) {
                                if (result.professionalTaxSlabBean.isValid) {
                                    logger.logSuccess("File Uploaded Successfully");
                                    if ($scope.ptslabList.companyId != undefined && $scope.ptslabList.companyId != null && $scope.ptslabList.companyId != '' && $scope.ptslabList.departmentId != undefined && $scope.ptslabList.departmentId != null && $scope.ptslabList.departmentId != '' && $scope.ptslabList.branchId != undefined && $scope.ptslabList.branchId != null && $scope.ptslabList.branchId != '' && $scope.ptslabList.financialYear != undefined && $scope.ptslabList.financialYear != null && $scope.ptslabList.financialYear != '') {

                                        var resultBean = {
                                            companyId : $scope.ptslabList.companyId,
                                            dept : $scope.ptslabList.departmentId,
                                            branchId : $scope.ptslabList.branchId,
                                            financialYear : $scope.ptslabList.financialYear,

                                        }
                                        $http.post("payroll/tds/ptslab/generationlist", resultBean).success(function(response) {
                                            if (response.professionaltxList != null && response.professionaltxList != "" && response.professionaltxList != undefined) {
                                                $scope.rowCollection = response.professionaltxList.emplList;
                                                $scope.headlablist = response.professionaltxList.emplList[0].dateList;
                                            } else {
                                                $scope.rowCollection = [];
                                                $scope.headlablist = [];
                                            }
                                        })

                                    }

                                } else {
                                    logger.logError(result.professionalTaxSlabBean.errorMessage);
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

        $scope.exportExcel = function() {

            var companyId = $scope.ptslabList.companyId;
            var dept = $scope.ptslabList.departmentId;
            var branchId = $scope.ptslabList.branchId;
            var financialYear = $scope.ptslabList.financialYear;
            var typeId = $scope.ptslabList.typeList;
            var isValid = true;
            if (dept == "" || dept == null || dept == undefined) {
            	dept = null;
            }
            if (companyId == "" || companyId == null || companyId == undefined) {
                logger.logError("Company is Mandatory");
                isValid = false;
            }
            if (financialYear == "" || financialYear == null || financialYear == undefined) {
                logger.logError("Financial Year is mandatory!");
                isValid = false
            }
            if (typeId == "" || typeId == null || typeId == undefined) {
                logger.logError("Deduction Type is mandatory!");
                isValid = false
            }

            var resultBean = {
                companyId : $scope.ptslabList.companyId,
                dept : $scope.ptslabList.departmentId,
                branchId : $scope.ptslabList.branchId,
                financialYear : $scope.ptslabList.financialYear,
                typeId : $scope.ptslabList.typeList,

            }
            $http.post('payroll/tds/ptslab/exportExcel1', resultBean).success(function(data) {
                if (isValid) {
                    if (data.success == true) {
                        $scope.ptslabList.Show = true;
                        $("#Export").bind('click', function() {
                        });
                        $('#Export').simulateClick('click');
                        logger.logSuccess("File Exported Successfully");
                   
                       /* $('#btnRowDivId').append('<a id="captainMsglink" href="tempdoc/Employee_Deduction.xls" class="control-label" download="Employee_Deduction.xls"></a>');
                        $("#captainMsglink").bind('click', function() {
                        });
                        $('#captainMsglink').simulateClick('click');*/
                    } else {
                        $scope.ptslabList.Show = false;
                        logger.logError("Error Please Try Again")

                    }
                }
            }).error(function(data) {
            });
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

    
});