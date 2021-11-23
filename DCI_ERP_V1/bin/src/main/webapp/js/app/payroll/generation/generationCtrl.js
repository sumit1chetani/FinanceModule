
    'use strict';
   	app.controller('generationCtrl', function($stateParams,$scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService,utilsService, $window,$timeout) {

    //module.registerController('generationCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService) {

        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.rowCollection = [];
        $scope.rowCollection2 = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.departmentList = [];
        $scope.employeeList = [];
        $scope.monthYearList = [];

        $scope.isDisplay = true;
        $scope.isAuthorized = false;

        $scope.payrollgeneration = {
            employeeId : '',
            departmentId : '',
            companyName : '',
            branchName : '',
            branchId : '',
            companyId : '',
            monthYear : '',
            month : '',
            year : '',
            isGenerate : false,
            isGenerate1 : false,
            isExists : false,
            isnonExists : false,
            isOnLoad : false,
            flagDetails : false

        };

        $rootScope.employeeId = $scope.payrollgeneration.employeeId;
        $rootScope.departmentId = $scope.payrollgeneration.departmentId;
        $rootScope.monthYear = $scope.payrollgeneration.monthYear;

        $scope.branchList = [];

        $scope.getCompanyList = function() {

          //  $http.get("payroll/payroll/payrollgeneration/getCompanyList").success(function(datas) {
        	$http.get($stateParams.tenantid	+ '/app/usermaster/getCompanyList?formCode='
    				+ 'F0372').success(
    		function(datas) {  
        	console.log("getCompanyList");
                $scope.companyList = datas;
                
                if ($scope.companyList.length >= 1) {
                    $scope.payrollgeneration.companyId = $scope.companyList[0].id;
                    $scope.payrollgeneration.companyName = $scope.companyList[0].companyName;
                }
                console.log(datas);
            })
        }

        $scope.$watch('payrollgeneration.companyId', function(newValue, oldValue) {
            var companyId = newValue;
            if ($scope.payrollgeneration.companyId != '' && $scope.payrollgeneration.isOnLoad == false) {
                $scope.payrollgeneration.branchId = '';
                $scope.payrollgeneration.branchName = '';
            }
            $http.post("payroll/payroll/payrollgeneration/getBranchList", companyId).success(function(datas) {
                console.log("getBranchList");
                $scope.payrollgeneration.isOnLoad = false;
                $scope.branchList = datas.branchList;
                if ($scope.branchList.length == 1) {
                    $scope.payrollgeneration.branchId = $scope.branchList[0].id;
                    $scope.payrollgeneration.branchName = $scope.branchList[0].text;
                }
                $scope.payrollgeneration.departmentId = '';
                $scope.departmentList = [];
                $scope.employeeList = [];
                console.log($scope.branchList);
            })

        });

        $scope.getBranchList = function(companyId, branchID) {
            $http.post("payroll/payroll/payrollgeneration/getBranchList", companyId).success(function(datas) {
                console.log("getBranchList");
                $scope.branchList = datas.branchList;
                console.log(branchID);
                $scope.payrollgeneration.branchId = branchID;
                $scope.departmentList = [];
                $scope.employeeList = [];
                console.log($scope.branchList);
            })
        }

        $scope.$watch('payrollgeneration.branchId', function(newValue, oldValue) {
            var branchId = newValue;
            $http.post("payroll/payroll/payrollgeneration/getDepartmentList", branchId).success(function(datas) {
                console.log("LoginUseDepartmentList");
                console.log(datas);
                $scope.departmentList = datas.departmentList;
                $scope.payrollgeneration.departmentId = '';
                $scope.employeeList = [];
            })

        });

        // now date 
        //now date 
        var today = new Date();
        var dd = today.getDate();
        var mm = today.getMonth() + 1; // January is 0!
        var yyyy = today.getFullYear();
        var time = today.getHours() + ":" + today.getMinutes()
        if (dd < 10) {
            dd = '0' + dd
        }
        if (mm < 10) {
            mm = '0' + mm
        }

        var today = new Date();
        var dd = today.getDate();
        var mm = today.getMonth() + 1;

        var yyyy = today.getFullYear();
        var time = today.getHours() + ":" + today.getMinutes()
        if (dd < 10) {
            dd = '0' + dd;
        }
        if (mm < 10) {
            mm = '0' + mm;
        }
        var today1 = dd + '/' + mm + '/' + yyyy;
        console.log(today);
        $scope.chektoday = today1;

        $scope.getDepartment = function(branchId) {
            console.log("branchID" + branchId);
            $http.post("payroll/payroll/payrollgeneration/getDepartmentList", branchId).success(function(datas) {
                console.log("LoginUseDepartmentList");
                console.log(datas);
                $scope.departmentList = datas.departmentList;
                $scope.payrollgeneration.departmentId = '';
                $scope.employeeList = [];
            })
        }

        $scope.getEmployeeDetails = function() {

            $http.get("payroll/payroll/payrollgeneration/getUserDetail").success(function(datas) {
                console.log("LoginUser");
                console.log(datas);
                $scope.getCompanyList();
                $scope.payrollgeneration.isOnLoad = true;
                $scope.payrollgeneration.companyId = datas.id;
                $scope.payrollgeneration.companyName = datas.companyName;
                $scope.getBranchList($scope.payrollgeneration.companyId, datas.branchId);
                $scope.payrollgeneration.branchName = datas.branchName;
                $scope.getDepartment(datas.branchId);

            })
        }

        $scope.getEmployeeDetails();

        $scope.$watch('payrollgeneration.departmentId', function(newValue, oldValue) {
            debugger
            var dept = newValue;
            var branchId = $scope.payrollgeneration.branchId;
            console.log("Department ID:" + departmentId);
            console.log("Branch ID:" + branchId);
            var resultBean = {
                branchId : branchId,
                dept : dept
            };
            if ($scope.payrollgeneration.departmentId != "" && $scope.payrollgeneration.departmentId != null) {
                $http.post("payroll/payroll/payrollgeneration/getEmployeeList", resultBean).success(function(datas) {
                    console.log("LoginUseEmployeeList");
                    $scope.employeeList = datas.employeeList;
                    $scope.payrollgeneration.employeeId = '';
                    console.log(datas);
                })
            }

        });

        $scope.getEmployeeList = function(departmentId) {
            console.log("Department ID:" + departmentId);
            console.log("Branch ID:" + $scope.payrollgeneration.branchId);
            var resultBean = {
                branchId : $scope.payrollgeneration.branchId,
                dept : departmentId
            };
            $http.post("payroll/payroll/payrollgeneration/getEmployeeList", resultBean).success(function(datas) {
                console.log("LoginUseEmployeeList");
                $scope.employeeList = datas.employeeList;
                $scope.payrollgeneration.employeeId = '';
                console.log(datas);
            })
        }

        $scope.getMonthYearList = function() {

            $http.get("payroll/payroll/payrollgeneration/getMonthYearList").success(function(datas) {
                console.log("MonthYearList");
                $scope.monthYearList = datas.monthYearList;
                console.log(datas);
            })
        }

        $scope.getMonthYearList();

        $scope.addAdvance = function() {
            $scope.callDialog($scope, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope);
        };

        $scope.callDialog = function($scope, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, validationService) {

            ngDialog.open({

                scope : $scope,
                template : 'views/payroll/payroll/advance/advanceApprovalList',
                controller : $controller('advanceAddApprovalCtrl', {
                    $scope : $scope,

                    $http : $http,
                    ngDialog : ngDialog,
                    logger : logger,
                    $injector : $injector,
                    sharedProperties : sharedProperties,
                    toaster : toaster,
                    $rootScope : $rootScope
                }),
                className : 'ngdialog-theme-plain',
                showClose : false,
                closeByDocument : false,
                closeByEscape : false,
                preCloseCallback : $scope.getList
            });

        }
        /*  $scope.$watch('payrollgeneration.employeeId', function(newValue, oldValue) {
          
          debugger
          $http.get('payroll/payroll/payrollgeneration/checkFlag?employeeId=' + newValue).success(function(datas){
              console.log(datas);
            
          } );
          })*/

        $scope.$watchCollection('[payrollgeneration.departmentId,payrollgeneration.monthYear,payrollgeneration.employeeId]', function(newValue, oldValue) {

            newValue[0]; //dept
            newValue[1];//month
            newValue[2];//emp
            debugger
            if (newValue[0] == "") {
                newValue[0] = 0;
            }
            $http.get('payroll/payroll/payrollgeneration/getFlagList?departmentId=' + newValue[0] + '&monthYear=' + newValue[1] + '&employeeId=' + newValue[2]).success(function(datas) {
                console.log(datas);
                //  $scope.companyList = datas.companyList;
                //  console.log(datas);
                /* var employeeId=datas.flagList.employee_id;
                 var employeeName=datas.flagList.first_name;*/

                $scope.rowCollection2 = datas.lscManageAdmissionBean;

            }).error(function(data) {
            });
        });

        $scope.save = function(payrollgenertaionForm) {
            debugger
            if (new validationService().checkFormValidity(payrollgenertaionForm)) {
                $scope.payrollgeneration.isGenerate = false;
                var companyId = $scope.payrollgeneration.companyId;
                var branchId = $scope.payrollgeneration.branchId;
            //    var departmentId = $scope.payrollgeneration.departmentId;
                   var dept = $scope.payrollgeneration.departmentId;

                var employeeId = $scope.payrollgeneration.employeeId;
                var monthYear = $scope.payrollgeneration.monthYear;
                var dept = $scope.payrollgeneration.departmentId;
                if (dept == '') {
                	dept = null;
                }
                var employeeId = $scope.payrollgeneration.employeeId;
                if (employeeId == '') {
                    employeeId = null;
                }
                var resultBean = {
                    companyId : companyId,
                    branchId : branchId,
                    dept : dept,
                    employeeId : employeeId,
                    monthYear : monthYear
                }

                var resultBean1 = {

                		dept : dept,
                    employeeId : employeeId,
                    monthYear : monthYear
                }
                console.log("resultbean");
                console.log(resultBean);

                $http.post("payroll/payroll/payrollgeneration/generate", resultBean).success(function(response) {
                    console.log("responseList");
                    console.log(response);

                    if (response.message == 'With Hold Salary') {
                        logger.logError(response.message);

                    }

                    if (response.salaryNotCreatedOthers == true) {
                        //                        logger.logError("Payroll Not Generated");

                    }

                    if (response.salaryExists == true) {
                        //                        logger.logError("Payroll Already Generated");

                    } else {

                        if (response.flagListStopped != true && response.message != 'With Hold Salary' && response.salaryNotCreatedOthers != true) {
                            //  if (response.salaryCreated == true) {
                            debugger

                            $http.post("payroll/payroll/advance/advanceAddList", resultBean1).success(function(response) {

                                $scope.rowCollection3 = response.advanceAddList;
                                if ($scope.rowCollection3 == '' || $scope.rowCollection3 == null || $scope.rowCollection3 == undefined) {
                                    $scope.dummy = false;
                                } else {
                                    $scope.dummy = true;
                                }
                                if ($scope.dummy == true) {
                                    $scope.addAdvance();
                                }
                            });

                            logger.logSuccess("Salary Generated Successfully!");

                        }
                    }

                    if (response.flagListStopped == true) {
                        logger.logError("Payroll flag not allowed for this employee");

                    }
                    /*if(response.flagListStopped != true && response.message != 'With Hold Salary' && response.salaryExists == false  ){
                     logger.logSuccess("Salary Generated Successfully!");
                    
                     }
                     */
                    // if (response.salaryCreated != true && response.message == null  && response.salaryExists != false  && response.salaryExists != true && response.flagListStopped != true) {
                    /*if ( response.flagListStopped != true) {
                     //  if (response.salaryCreated == true) {
                     debugger
                    
                     $http.post("payroll/payroll/advance/advanceAddList", resultBean1).success(function(response) {
                    
                     $scope.rowCollection3 = response.advanceAddList;
                     if ($scope.rowCollection3 == '') {
                     $scope.dummy = false;
                     } else {
                     $scope.dummy = true;
                     }
                     if($scope.dummy == true){
                     $scope.addAdvance(); 
                     }
                     });
                    
                     logger.logSuccess("Salary Generated Successfully!");

                     }*/
                    if (response.salaryExists == true && response.salaryList != null) {
                        //  if (response.salaryExists == true ) {
                        $scope.payrollgeneration.isGenerate = true;
                        $scope.payrollgeneration.isExists = true;
                        $scope.rowCollection1 = response.salaryList;

                    }

                    if (response.payrollList != null && response.payrollList != "") {
                        $scope.payrollgeneration.isGenerate1 = true;
                        $scope.rowCollection = response.payrollList;
                        //                        $scope.payrollgeneration.isExists = false;
                        $scope.payrollgeneration.isnonExists = true;

                    }
                }).error(function(data) {
                    console.log(datas);
                });
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(payrollgenertaionForm.$validationSummary), 5000, 'trustedHtml');
            }

        }
        $scope.payrolltojv = function(payrollgenertaionForm) {
            
//            alert("JV")

            if (new validationService().checkFormValidity(payrollgenertaionForm)) {
            $scope.payrollgeneration.isGenerate = false;
            var companyId = $scope.payrollgeneration.companyId;
            var branchId = $scope.payrollgeneration.branchId;
            var dept = $scope.payrollgeneration.departmentId;
            var employeeId = $scope.payrollgeneration.employeeId;
            var monthYear = $scope.payrollgeneration.monthYear;
            var dept = $scope.payrollgeneration.departmentId;
            if (dept == '') {
            	dept = null;
            }
            var employeeId = $scope.payrollgeneration.employeeId;
            if (employeeId == '') {
                employeeId = null;
            }
            var resultBean = {
                companyId : companyId,
                branchId : branchId,
                dept : dept,
                employeeId : employeeId,
                monthYear : monthYear
            }

            var resultBean1 = {

                dept : dept,
                employeeId : employeeId,
                monthYear : monthYear
            }
            console.log("resultbean");
            console.log(resultBean);
            $http.post("payroll/payroll/payrollgeneration/payrolltojv", resultBean).success(function(response) {
                console.log("responseList");
                console.log(response);
                if(response.success ==true)
                    {
                    logger.logSuccess("JV Generated successfully");
                    }else{
                        logger.logError("JV Already generated");
                    }
            });

            
        } else {
            toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(payrollgenertaionForm.$validationSummary), 5000, 'trustedHtml');
        }
        $scope.cancel = function() {

            $state.go('app.payroll.payroll.generation.list');
        }
       
        }
    });

    module.registerController('advanceAddApprovalCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {

        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.isDisplay = true;

        $scope.isAdd = true;
        $scope.isDelete = true;
        $scope.isUpload = true;

        $scope.advance = {
            advanceCode : '',
            employee : '',
            employeeName : '',
            employeeCode : '',
            designation : '',
            joinDate : '',
            workingYear : '',
            description : '',
            amount : 0,
            disbursementDate : '',
            openingBalance : 0,
            installmentPaid : '',
            recoverytype : '',
            installmentAmount : 0,
            month : '',
            year : '',
            startDate : '',
            numberOfInstallments : '',
            deductMY : '',
            narration : '',
        };
        $scope.dum = true;
        $scope.change = false;

        /* $scope.modify = [ {
             id : '0',
             text : '0'
         }, {
             id : '1',
             text : '1'
         }, {
             id : '2',
             text : '2'
         }, {
             id : '3',
             text : '3'
         } ];*/

        $rootScope.employeeId = $scope.payrollgeneration.employeeId;
        $rootScope.departmentId = $scope.payrollgeneration.departmentId;
        $rootScope.monthYear = $scope.payrollgeneration.monthYear;

        $scope.deductMY = $rootScope.monthYear;
        var dept = $rootScope.departmentId;
        var employeeId = $rootScope.employeeId;

        $scope.getList = function() {

            var resultBean = {

                dept : dept,
                employeeId : employeeId,
                monthYear : $scope.deductMY
            }

            $http.post("payroll/payroll/advance/advanceAddList", resultBean).success(function(response) {

                $scope.rowCollection = response.advanceAddList;
                if ($scope.rowCollection == '') {
                    $scope.dum = false;
                } else {
                    $scope.dum = true;
                }
                angular.forEach($scope.rowCollection, function(value, key) {
                    if (value.recoverytype == '1') {
                        value.recoverytype = 'Monthly';
                    } else if (value.recoverytype == '2') {
                        value.recoverytype = 'Quarterly';
                    } else if (value.recoverytype == '3') {
                        value.recoverytype = 'Half Yearly';
                    } else {
                        value.recoverytype = 'Yearly';
                    }

                    $http.post("payroll/payroll/advance/getInsList", value).success(function(response) {

                        $scope.modify = response.advanceCountList;
                        value.toModify = '1';

                    });
                })

            });
        };

        $scope.getList();

        $scope.box = function(list, $index) {
            if (list[$index].toChange == true) {
                list[$index].change = true;

                $http.post("payroll/payroll/advance/getInsList", list[$index]).success(function(response) {

                    $scope.modify = response.advanceCountList;
                    list[$index].toModify = '1';

                });

            } else {
                list[$index].change = false;
                list[$index].toModify = '1';

            }
        }

        $scope.$watchCollection('myloanlist.toModify', function(newValue, oldValue) {
            if (newValue !== undefined && newValue !== "") {
                if (myloanlist.toModify == '0') {
                    myloanlist.installmentAmount == '0';
                } else if (myloanlist.toModify == '1') {
                    myloanlist.installmentAmount = myloanlist.toModify;
                } else if (myloanlist.toModify == '2') {
                    myloanlist.installmentAmount = myloanlist.installmentAmount * 2;
                } else if (myloanlist.toModify == '3') {
                    myloanlist.installmentAmount = myloanlist.installmentAmount * 3;
                }
            }
        });
        $scope.type = function(list) {
            if (list.toModify == '0') {
                list.installmentAmount == '0';
            } else if (list.toModify == '1') {
                list.installmentAmount = list.toModify;
            } else if (list.toModify == '2') {
                list.installmentAmount = list.installmentAmount * 2;
            } else if (list.toModify == '3') {
                list.installmentAmount = list.installmentAmount * 3;
            }
        }

        $scope.deduct = function(collection) {
            debugger

            angular.forEach(collection, function(value, key) {
                value.monthYear = $scope.deductMY;

            })

            $http.post("payroll/payroll/advance/advanceAddGenerate", collection).success(function(response) {
                console.log("responseList");
                console.log(response);

                if (response.success == true && response.alert == 'Deduction calculated towards advance exceeds net salary for ( ). Please recheck and proceed.') {

                    logger.logSuccess("Advance Deducted Successfully!");
                    ngDialog.close();
                } else if (response.success == true && response.alert != 'Deduction calculated towards advance exceeds net salary for ( ). Please recheck and proceed.') {
                    logger.logError(response.alert);
                } else if (response.success == false && response.alert != 'Deduction calculated towards advance exceeds net salary for ( ). Please recheck and proceed.') {
                    logger.logError(response.alert);
                }
            }).error(function(data) {
                console.log(datas);
            });

        }

        $scope.cancel = function() {
            ngDialog.close();
        };
    });

    app.controller('tableCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {

        $scope.$watchCollection('[displayedCollection[$index].toModify]', function(newValue, oldValue) {
            if (newValue !== undefined && newValue !== "") {

                $scope.displayedCollection[$scope.$index].installmentAmount = $scope.displayedCollection[$scope.$index].insAmt * newValue;

                /* if(newValue == '0'){
                     $scope.displayedCollection[$scope.$index].installmentAmount = $scope.displayedCollection[$scope.$index].insAmt * 0 ;
                 }else if(newValue == '1'){
                     $scope.displayedCollection[$scope.$index].installmentAmount = $scope.displayedCollection[$scope.$index].insAmt * 1 ;
                 }else if(newValue == '2'){
                     $scope.displayedCollection[$scope.$index].installmentAmount = $scope.displayedCollection[$scope.$index].insAmt * 2 ;
                 }else if(newValue == '3'){
                     $scope.displayedCollection[$scope.$index].installmentAmount = $scope.displayedCollection[$scope.$index].insAmt * 3 ;
                 }*/
            }
        });

    });

