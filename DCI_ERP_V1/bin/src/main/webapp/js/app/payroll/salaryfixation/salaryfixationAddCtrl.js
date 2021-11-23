    'use strict';
       
    	app.controller('salaryfixationAddCtrl', function($stateParams,$scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService,utilsService, $window,$timeout) {

    	$scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;

        $scope.employeePaycomponenet = {
            payComponentName : '',
            amount : '',
            fromdate : '',
            todate : '',
            employeeId : '',
            departmentId : '',
            companyName : '',
            branchName : '',
            branchId : '',
            companyId : '',
            totalEarnings : '',
            totalDeductions : '',
            arrears:'',
            arrearsStartDate:'',
            isEdit : false,
            isOnLoad : false
        };

        // date picker
    	$('#startDate').datetimepicker({
    		format : 'DD/MM/YYYY'
    	})
    	
        
        var basic = 40 / 100;
        var da = 20 / 100;
        var hra = 20 / 100;
        var conv = 10 / 100;
        var medic = 10 / 100;

        $scope.isEdit = false;
        $scope.earningList = [];
        $scope.deductionList = [];
        $scope.earningDeductionMasterList = [];
        $scope.paycomponentList = [];

        var departmentId = $location.search().departmentId;
        var employeeId = $location.search().employeeId;
        var fromdate = $location.search().fromdate;
        var companyId = $location.search().companyId;
        var branchId = $location.search().branchId;

        $scope.getCompanyList = function() {
        	$http.get(		$stateParams.tenantid	+ '/app/usermaster/getCompanyList?formCode='
							+ 'F0367')	.success(function(datas) {
        //    $http.get("payroll/payroll/payrollgeneration/getCompanyList").success(function(datas) {
                $scope.companyList = datas;
                if ($scope.companyList.length == 1) {
                    $scope.employeePaycomponenet.companyId = $scope.companyList[0].id;
                    $scope.employeePaycomponenet.companyName = $scope.companyList[0].companyName;
                }

            })
            $scope.getPFAvailability();
        }
        
        $scope.getPFAvailability = function() {
            $http.get($stateParams.tenantid+'/hrms/master/employeeAdminMaster/editRule?empId=' + employeeId).success(function(result) {
                if (result.success) {
                if (result.objEmployeeMasterRulesBean != undefined && result.objEmployeeMasterRulesBean != null && result.objEmployeeMasterRulesBean != '') {
                        $scope.PFDeductionCheck = true;
                        $scope.PFDeduction = result.objEmployeeMasterRulesBean.pfApp;
                        console.log('PF DEDUCTION : ' +$scope.PFDeduction);                        
                    }
                } else {
                    $scope.PFDeductionCheck = false;                    
                }

            })
        }
        $scope.$watch('employeePaycomponenet.arrears', function(newValue,oldValue){
            debugger
                 var x = document.getElementById("myDIV");
            if(newValue == false){
                 if (x.style.display === "none") {
                   x.style.display = "block";
                 } else {
                   x.style.display = "none";
                   $scope.employeePaycomponenet.arrearsStartDate= '';
                 }
            } else{
                
                x.style.display = "block";
                
            }
             
         })
         
         
       
         
         
         
          $scope.$watch('employeePaycomponenet.arrearsStartDate', function(newValue,oldValue){
            debugger
            var resultBean = {
                    employeeId : employeeId,
                    arrearsStartDate: newValue
                };
     //       $http.get("payroll/payroll/employeepaycom/getEmployeeMaxDate?employeeId=" + $scope.employeePaycomponenet.employeeId).success(function(result) {
     
                $http.get("payroll/payroll/employeepaycom/checkArrearDate?arrearsStartDate=" +newValue+ '&employeeId=' +employeeId ).success(function(datas) {
                    
                    if(datas.arrearExist == true){
                        logger.logError("Arrears Amount Added");
                        
                     // $scope.employeePaycomponenet.arrearsStartDate='';
                    }
            })
            

         })
         
         

        $scope.$watch('employeePaycomponenet.companyId', function(newValue, oldValue) {
            if (newValue != '' && newValue != null && newValue != undefined) {
                var companyId = newValue;
                if ($scope.employeePaycomponenet.companyId != '' && $scope.employeePaycomponenet.isOnLoad == false) {
                    $scope.employeePaycomponenet.branchId = '';
                    $scope.employeePaycomponenet.departmentId = '';
                    $scope.employeePaycomponenet.employeeId = '';
                    $scope.employeePaycomponenet.branchName = '';
                }
                $http.post("payroll/payroll/payrollgeneration/getBranchList", companyId).success(function(datas) {

                    $scope.employeePaycomponenet.isOnLoad = false;
                    $scope.branchList = datas.branchList;
                    if ($scope.branchList.length == 1) {
                        $scope.employeePaycomponenet.branchId = $scope.branchList[0].id;
                        $scope.employeePaycomponenet.branchName = $scope.branchList[0].text;
                    }
                    $scope.employeePaycomponenet.departmentId = '';
                    $scope.departmentList = [];
                    $scope.employeeList = [];

                })
            }
        });

        $scope.$watch('employeePaycomponenet.branchId', function(newValue, oldValue) {
            if ($scope.employeePaycomponenet.branchId != '' && $scope.employeePaycomponenet.isOnLoad == false) {
                $scope.employeePaycomponenet.departmentId = '';
                $scope.employeePaycomponenet.employeeId = '';
            }
            if (newValue != '' && newValue != null && newValue != undefined) {
                var branchId = newValue;
                $http.post("payroll/payroll/payrollgeneration/getDepartmentList", branchId).success(function(datas) {
                    $scope.employeePaycomponenet.isOnLoad = false;
                    $scope.departmentList = datas.departmentList;
                    $scope.employeePaycomponenet.departmentId = '';
                    if (departmentId != undefined && departmentId != null && departmentId != '') {
                        $scope.employeePaycomponenet.departmentId = departmentId;
                        $scope.employeeList = [];
                    }

                })
            }
        });

        $scope.getEmployeeDetails = function() {

            $http.get("payroll/payroll/payrollgeneration/getUserDetail").success(function(datas) {
                $scope.getCompanyList();
                $scope.employeePaycomponenet.isOnLoad = true;
                if (companyId != '' && companyId != null && companyId != undefined) {
                    $scope.employeePaycomponenet.companyId = companyId;
                } else {
                    $scope.employeePaycomponenet.companyId = datas.companyId;
                }
                if (branchId != '' && branchId != null && branchId != undefined) {
                    $scope.employeePaycomponenet.branchId = branchId;
                } else {
                    if (companyId == '' && companyId == null && companyId == undefined) {
                        $scope.employeePaycomponenet.branchId = datas.branchId;
                    }
                }
            })
        }

        $scope.getEmployeeDetails();

        $scope.$watch('employeePaycomponenet.departmentId', function(newValue, oldValue) {
            if ($scope.employeePaycomponenet.departmentId != '' && $scope.employeePaycomponenet.isOnLoad == false) {
                $scope.employeePaycomponenet.employeeId = '';
            }
            if (newValue != '' && newValue != null && newValue != undefined) {
                var departmentId = newValue;
                var branchId = $scope.employeePaycomponenet.branchId;

                var resultBean = {
                    branchId : branchId,
                    dept : departmentId
                };
                $http.post("payroll/payroll/payrollgeneration/getEmployeeList", resultBean).success(function(datas) {
                    $scope.employeePaycomponenet.isOnLoad = false;
                    $scope.employeeList = datas.employeeList;
                    if (employeeId != undefined && employeeId != null && employeeId != '') {
                        $scope.employeePaycomponenet.employeeId = employeeId;
                    }

                })

            }

        });

        $scope.getEmployeeList = function(dept) {

            var resultBean = {
                branchId : $scope.employeePaycomponenet.branchId,
                dept : departmentId
            };
            $http.post("payroll/payroll/payrollgeneration/getEmployeeList", resultBean).success(function(datas) {
                $scope.employeeList = datas.employeeList;
                $scope.employeePaycomponenet.employeeId = '';
            })
        }

        $scope.paycomponenetList = function() {
            $http.get("payroll/payroll/earningdeductionmaster/list").success(function(response) {

                $scope.getEmployeeList(departmentId);
                $scope.employeePaycomponenet.employeeId = employeeId;
                $scope.employeePaycomponenet.departmentId = departmentId;
                var i = 1;
                angular.forEach(response.earningDeductionMasterList, function(value, key) {
                    $scope.earningDeductionMasterList = response.earningDeductionMasterList;
                    if (value.payComponentType == "1" && value.status == true) {
                        debugger
                        $scope.earningList.push({
                            "id" : i,
                            "payComponentId" : value.payComponentId,
                            "payComponentName" : value.payComponentName,
                            "select" : "YES",
                            "value" : value.value,
                            "earningValue" : '',
                            "percentageAppliedOn" : value.percentageAppliedOn
                        });
                    } else if (value.payComponentType == "2" && value.status == true ) {
                        if (value.nonStandardDeduction == false) {
                        $scope.deductionList.push({
                            "id" : i,
                            "payComponentId" : value.payComponentId,
                            "payComponentName" : value.payComponentName,
                            "select" : "YES",
                            "value" : value.value,
                            "deductionValue" : '',
                            "percentageAppliedOn" : value.percentageAppliedOn
                        });
                        }
                    }
                    i = i + 1;
                });
            });
        };

        // Function to get Earning Values
        $scope.getEarningValue = function(earningPayComponentId) {
            var earningValue = 0;
            angular.forEach($scope.earningList, function(value, key) {
                if (earningPayComponentId == value.payComponentId) {
                    if (value.earningValue != undefined && value.earningValue != null && value.earningValue != '') {
                        earningValue = value.earningValue;
                    }

                }
            });
            return earningValue;
        }

        $scope.fixEarningPercentCalculation = function(paycomponenetId, earningValue) {
            var percentageArray = [];
            angular.forEach($scope.earningList, function(value, key) {
                if (value.percentageAppliedOn != null && value.percentageAppliedOn != undefined && value.percentageAppliedOn != '') {
                    percentageArray = value.percentageAppliedOn.split(",");
                }
                var totalEarningValue = 0;
                for (var i = 0; i < percentageArray.length; i++) {
                    var currentEarningValue = 0;
                    currentEarningValue = $scope.getEarningValue(percentageArray[i]);
                    if (currentEarningValue != undefined && currentEarningValue != null && currentEarningValue != '' || currentEarningValue == 0) {
                        var earval = value.value / 100;
                        earval = currentEarningValue * earval;
                        totalEarningValue = totalEarningValue + earval;
                        totalEarningValue = Math.round(totalEarningValue);

                    }
                }
                if (totalEarningValue != undefined && totalEarningValue != null && totalEarningValue != '' || totalEarningValue == 0) {
                    if (value.percentageAppliedOn != null && value.percentageAppliedOn != undefined && value.percentageAppliedOn != '') {
                        if (value.select == "YES") {
                            value.earningValue = totalEarningValue;
                        }

                    }
                }

            });
        }

        $scope.percentageDeductionCalculation = function(paycomponenetId, earningValue) {
            angular.forEach($scope.deductionList, function(value, key) {
                var percentageArray = [];
                if (value.percentageAppliedOn != null && value.percentageAppliedOn != undefined && value.percentageAppliedOn != '') {
                    var percentageArray = value.percentageAppliedOn.split(",");
                }
                var totaldeductValue = 0;
                var totalEarningValue = 0;

                for (var i = 0; i < percentageArray.length; i++) {
                    var currentEarningValue = 0;
                    currentEarningValue = $scope.getEarningValue(percentageArray[i]);
                    if (currentEarningValue != undefined && currentEarningValue != null && currentEarningValue != '') {
                        var deductionValue = value.value / 100;
                        deductionValue = currentEarningValue * deductionValue;
                        deductionValue = Math.round(deductionValue);
                        totaldeductValue = Number(totaldeductValue) + Number(deductionValue);
                        totalEarningValue = Number(totalEarningValue) + Number(currentEarningValue);
                    }
                }

                if (value.payComponentId == "EPS") {

                    if (totalEarningValue >= 15000) {
                        totaldeductValue = 1250;
                    } else {
                        if (totalEarningValue < 15000) {
                            var percentageValue = 8.33 / 100;
                            totaldeductValue = totalEarningValue * percentageValue;
                            totaldeductValue = Math.round(totaldeductValue);
                        }
                    }

                }

                if (value.payComponentId == "EPF") {

                    if (totalEarningValue >= 15000) {
                        totaldeductValue = 550;
                    } else {
                        if (totalEarningValue < 15000) {
                            var percentageValue = 3.67 / 100;
                            totaldeductValue = totalEarningValue * percentageValue;
                            totaldeductValue = Math.round(totaldeductValue);
                        }
                    }

                }

                if (value.payComponentId == "EDLI") {

                    if (totalEarningValue >= 15000) {
                        totaldeductValue = 75;
                    } else {
                        if (totalEarningValue < 15000) {
                            var percentageValue = 0.50 / 100;
                            totaldeductValue = totalEarningValue * percentageValue;
                            totaldeductValue = Math.round(totaldeductValue);
                        }
                    }

                }

                if (value.payComponentId == "ADMC") {

                    if (totalEarningValue >= 15000) {
                        totaldeductValue = 97.5;
                    } else {
                        if (totalEarningValue < 15000) {
                            var percentageValue = 0.65 / 100;
                            totaldeductValue = totalEarningValue * percentageValue;
                            totaldeductValue = Math.round(totaldeductValue);
                        }
                    }

                }

                if (value.payComponentId == "PFCOM" || value.payComponentId == "PFSEL") {
                    if (!$scope.PFDeductionCheck) {
                    if (totalEarningValue >= 15000) {
                        totaldeductValue = 1800;
                    } else {
                        if (totalEarningValue < 15000) {
                            var percentageValue = value.value / 100;
                            totaldeductValue = totalEarningValue * percentageValue;
                            totaldeductValue = Math.round(totaldeductValue);
                        }
                    }
                    } else {
                        totaldeductValue = 0;
                    }
                } else if (value.payComponentId == "ESI") {
                    if (totalEarningValue > 15000) {
                        totaldeductValue = 0;
                    } else {
                        if (totalEarningValue <= 15000) {
                            var percentageValue = 1.75 / 100;
                            totaldeductValue = totalEarningValue * percentageValue;
                            totaldeductValue = Math.round(totaldeductValue);
                        }
                    }

                } else {
                    totaldeductValue = totaldeductValue;
                    totaldeductValue = Math.round(totaldeductValue);
                }

                if (totaldeductValue != undefined && totaldeductValue != null && totaldeductValue != '' || totaldeductValue == 0) {
                    if (value.percentageAppliedOn != null && value.percentageAppliedOn != undefined && value.percentageAppliedOn != '') {
                        if (value.select == "YES") {
                            value.deductionValue = totaldeductValue;
                        }

                    }

                }

            });

        }

        $scope.getValue = function(paycomponenetId, earningValue) {
            debugger;
            $scope.fixEarningPercentCalculation(paycomponenetId, earningValue);
            $scope.percentageDeductionCalculation(paycomponenetId, earningValue);
            $scope.calulateEarningsValue();
            $scope.calulateDeductionValue();

        };

        $scope.checkSingleIDBoxEarnsCalculation = function(earningID, percentagOn) {
            var percentageArray = [];
            angular.forEach($scope.earningList, function(value, key) {
                if (value.percentageAppliedOn != null && value.percentageAppliedOn != undefined && value.percentageAppliedOn != '') {
                    percentageArray = value.percentageAppliedOn.split(",");
                }
                var totalEarningValue = 0;
                for (var i = 0; i < percentageArray.length; i++) {
                    var currentEarningValue = 0;
                    currentEarningValue = $scope.getEarningValue(percentageArray[i]);
                    if (currentEarningValue != undefined && currentEarningValue != null && currentEarningValue != '' || currentEarningValue == 0) {
                        var earval = value.value / 100;
                        earval = currentEarningValue * earval;
                        totalEarningValue = totalEarningValue + earval;

                    }
                }

                if (totalEarningValue != undefined && totalEarningValue != null && totalEarningValue != '' || totalEarningValue == 0) {
                    if (value.percentageAppliedOn != null && value.percentageAppliedOn != undefined && value.percentageAppliedOn != '') {
                        if (earningID != value.payComponentId) {
                            if (value.select == "YES") {
                                value.earningValue = totalEarningValue;
                            }

                        }
                    }
                }

            });
            $scope.percentageDeductionCalculation(earningID, percentagOn);
            $scope.calulateEarningsValue();
            $scope.calulateDeductionValue();
        }

        $scope.checkfixDeductionCalculation = function(deductionID, percentagOn) {
            angular.forEach($scope.deductionList, function(value, key) {
                var percentageArray = [];
                if (value.percentageAppliedOn != null && value.percentageAppliedOn != undefined && value.percentageAppliedOn != '') {
                    var percentageArray = value.percentageAppliedOn.split(",");
                }
                var totaldeductValue = 0;
                var totalEarningValue = 0;
                for (var i = 0; i < percentageArray.length; i++) {
                    var currentEarningValue = 0;
                    currentEarningValue = $scope.getEarningValue(percentageArray[i]);
                    if (currentEarningValue != undefined && currentEarningValue != null && currentEarningValue != '') {
                        var deductionValue = value.value / 100;
                        deductionValue = currentEarningValue * deductionValue;
                        deductionValue = Math.round(deductionValue);
                        totaldeductValue = totaldeductValue + deductionValue;
                        totalEarningValue = totalEarningValue + currentEarningValue;
                    }
                }
                if (value.payComponentId == "PFCOM" || value.payComponentId == "PFSEL") {
                    if (totalEarningValue >= 15000) {
                        totaldeductValue = 1800;
                    } else {
                        if (totalEarningValue < 15000) {
                            var percentageValue = value.value / 100;
                            totaldeductValue = totalEarningValue * percentageValue;
                            totaldeductValue = Math.round(totaldeductValue);
                        }
                    }
                } else if (value.payComponentId == "ESI") {
                    if (totalEarningValue > 15000) {
                        totaldeductValue = 0;
                    } else {
                        if (totalEarningValue <= 15000) {
                            var percentageValue = 1.75 / 100;
                            totaldeductValue = totalEarningValue * percentageValue;
                            totaldeductValue = Math.round(totaldeductValue);
                        }
                    }

                } else {
                    totaldeductValue = Math.round(totaldeductValue);

                }
                if (totaldeductValue != undefined && totaldeductValue != null && totaldeductValue != '') {
                    if (deductionID == value.payComponentId) {
                        if (value.select == "YES") {
                            value.deductionValue = totaldeductValue;
                        }

                    }
                }
            });

        }

        $scope.checkingDeductionValue = function(deductionValue, totalEarnings) {
            angular.forEach($scope.deductionList, function(value, key) {
                if (value.payComponentId == deductionValue) {
                    if (value.select == "YES") {
                        if (value.percentageAppliedOn != null && value.percentageAppliedOn != undefined && value.percentageAppliedOn != '') {
                            $scope.checkfixDeductionCalculation(deductionValue, value.percentageAppliedOn);
                        } else {
                            var id = "performanceId" + value.id;
                            document.getElementById(id).disabled = false;
                        }
                    }
                    if (value.select == "NO") {
                        if (value.percentageAppliedOn != null && value.percentageAppliedOn != undefined && value.percentageAppliedOn != '') {
                        } else {
                            var id = "performanceId" + value.id;
                            document.getElementById(id).disabled = true;
                        }
                        value.deductionValue = 0;
                    }
                    $scope.calulateEarningsValue();
                    $scope.calulateDeductionValue();
                }
            });
        }

        $scope.checkingEarningValue = function(earningValue, totalEarnings) {
        debugger;
            angular.forEach($scope.earningList, function(value, key) {
                if (value.payComponentId == earningValue) {
                    if (value.select == "YES") {
                        if (value.percentageAppliedOn != null && value.percentageAppliedOn != undefined && value.percentageAppliedOn != '') {
                        } else {
                            var id = "performanceId" + value.id;
                            document.getElementById(id).disabled = false;
                        }

                        $scope.getValue(value.payComponentId, value.earningValue);
                    }
                    if (value.select == "NO") {

                        value.earningValue = 0;
                        if (value.percentageAppliedOn != null && value.percentageAppliedOn != undefined && value.percentageAppliedOn != '') {
                            value.earningValue = 0;
                            $scope.checkSingleIDBoxEarnsCalculation(value.payComponentId, value.percentageAppliedOn);

                        } else {
                            var id = "performanceId" + value.id;
                            document.getElementById(id).disabled = true;
                            value.earningValue = 0;
                            $scope.getValue(value.payComponentId, 0);
                        }

                    }

                }
            });
        }

        if ($scope.employeePaycomponenet.isEdit != true && fromdate == undefined) {
            $scope.paycomponenetList();

        }

        if (fromdate == undefined && employeeId == undefined) {
            $scope.employeePaycomponenet.isEdit = false;
            $scope.isEdit = false;
        } else {
            if (fromdate != undefined) {
                var resultBean = {
                    employeeId : employeeId,
                    fromdate : fromdate
                };
                $scope.employeePaycomponenet.isEdit = true;
                $scope.isEdit = true;
                $http.post('payroll/payroll/employeepaycom/edit', resultBean).success(function(result) {

                    if (result.isEdit == false) {
                        logger.logError("Please Try Again");
                    } else {
                        debugger
                        if (result.empPayComList != null) {
                            $scope.employeePaycomponenet.departmentId = result.empPayComList[0].departmentId;
                            $scope.employeePaycomponenet.employeeId = result.empPayComList[0].employeeId;
                            $scope.employeePaycomponenet.companyId = result.empPayComList[0].companyId;
                            $scope.employeePaycomponenet.branchId = result.empPayComList[0].branchId;
                            $scope.employeePaycomponenet.companyName = result.empPayComList[0].companyName;
                            $scope.employeePaycomponenet.branchName = result.empPayComList[0].branchName;
                            $scope.employeePaycomponenet.departmentName = result.empPayComList[0].departmentName;
                            $scope.employeePaycomponenet.employeeName = result.empPayComList[0].employeeName;
                            $scope.employeePaycomponenet.fromdate = fromdate;
                          //  $scope.employeePaycomponenet.arrears = Boolean(result.empPayComList[0].arrears);
                          //  $scope.employeePaycomponenet.arrears = false;
                            if (result.empPayComList[0].arrears == 'true') {
                                debugger;
                                $scope.employeePaycomponenet.arrears = true;
                            } else {
                                $scope.employeePaycomponenet.arrears = false;
                            }
                            $scope.employeePaycomponenet.arrearsStartDate = result.empPayComList[0].arrearsStartDate;
                            var i = 1;

                            angular.forEach(result.empPayComList, function(value, key) {

                                if (value.payComponentType == "1") {
                                    $scope.earningList.push({
                                        "id" : i,
                                        "payComponentId" : value.payComponentId,
                                        "payComponentName" : value.payComponentName,
                                        "select" : "YES",
                                        "value" : value.value,
                                        "earningValue" : value.amount,
                                        "percentageAppliedOn" : value.percentageAppliedOn
                                    });
                              //  } else if (value.payComponentType == "2" && value.percentageAppliedOn!= null) {
                                } else if (value.payComponentType == "2") {
                                    $scope.deductionList.push({
                                        "id" : i,
                                        "payComponentId" : value.payComponentId,
                                        "payComponentName" : value.payComponentName,
                                        "select" : "YES",
                                        "value" : value.value,
                                        "deductionValue" : value.amount,
                                        "percentageAppliedOn" : value.percentageAppliedOn
                                    });
                                }
                                i = i + 1;
                            });

                            $scope.calulateEarningsValue();
                            $scope.calulateDeductionValue();

                        }
                    }

                   console.log($scope.employeePaycomponenet);
                }).error(function(data) {

                });
            }
        }

        $scope.getdeductionValue = function(paycomponenetId, earningValue) {
            $scope.calulateEarningsValue();
            $scope.calulateDeductionValue();

        };

        $scope.calulateDeductionValue = function() {
            var totaldeduct = 0;
            angular.forEach($scope.deductionList, function(value, key) {
                if (value.payComponentId != "EPS" && value.payComponentId != "EPF" && value.payComponentId != "EDLI" && value.payComponentId != "ADMC") {
                    if (value.deductionValue != undefined && value.deductionValue != null && value.deductionValue != '') {
                        totaldeduct = Math.round(Number(totaldeduct) + Number(value.deductionValue));
                    }
                }
            });
            $scope.employeePaycomponenet.totalDeductions = Math.round(Number($scope.employeePaycomponenet.totalEarnings) - Number(totaldeduct));
        }

        $scope.calulateEarningsValue = function() {
            var totalGrossPay = 0;
            angular.forEach($scope.earningList, function(value, key) {
                if (value.earningValue != undefined && value.earningValue != null && value.earningValue != '') {
                    totalGrossPay = Math.round(Number(totalGrossPay) + Number(value.earningValue));
                }
            });
            $scope.employeePaycomponenet.totalEarnings = totalGrossPay;

        }

        $scope.submit = function(employeePaycomponenet, salaryFixation) {
            if (new validationService().checkFormValidity(salaryFixation)) {
                var isvalid = true;
                $scope.paycomponentList = [];
                $scope.iterateEarningObject();
                $scope.iterateDeductionObject();
                
               $scope.paycomponentList[0].arrearsStartDate=$scope.employeePaycomponenet.arrearsStartDate;
                $scope.paycomponentList[0].arrears=$scope.employeePaycomponenet.arrears;
                var saveData = $scope.paycomponentList;
                if ($scope.employeePaycomponenet.isEdit != true) {

                    if (isvalid) {
                        var isValue = true;
                        var dateObj = new Date();
                        var cur_month = dateObj.getUTCMonth() + 1; // months
                        // from 1-12
                        var cur_year = dateObj.getUTCFullYear();
                        var companyId = $scope.employeePaycomponenet.companyId;
                        var branchId = $scope.employeePaycomponenet.branchId;
                        $http.get("payroll/payroll/employeepaycom/getEmployeeMaxDate?employeeId=" + $scope.employeePaycomponenet.employeeId).success(function(result) {
                            
                            debugger
                            var startsDate = $('#startDate').val();
                            startsDate = startsDate.split("/");
                            var month = startsDate[1];
                            var year = startsDate[2];
                            if (result.fromdate != null) {
                                var startDate = $('#startDate').val();
                                startDate = startDate.split("/");
                                startDate = new Date(startDate[2], startDate[1] - 1, startDate[0]);
                                var month = startDate[1] - 1;
                                var showErrorDate = result.fromdate;
                                var endDate = result.fromdate.split("/");

                                endDate = new Date(endDate[2], endDate[1] - 1, endDate[0]);
                                if (startDate > endDate) {
                                    $http.post("payroll/payroll/employeepaycom/save", saveData).success(function(result) {
                                        if (result == false) {
                                        } else {
                                            $location.url( $stateParams.tenantid+'/payroll/payroll/salaryfixation/getList?employeeId=' + $scope.employeePaycomponenet.employeeId + '&departmentId=' + $scope.employeePaycomponenet.departmentId + '&branchId=' + branchId + '&companyId=' + companyId + '&isValue=' + isValue);
                                        }

                                    })
                                } else {
                                    logger.logError("From Date Should be greater than the " + showErrorDate);
                                }

                            } else {
                                if (month < cur_month && year < cur_year) {
                                    logger.logError("Please Select Month and  greater than the Previous Month ");

                                } else {
                                    $http.post("payroll/payroll/employeepaycom/save", saveData).success(function(result) {
                                        if (result == false) {
                                        } else {

                                            $location.url ($stateParams.tenantid+'/payroll/salaryfixation/getList?employeeId=' + $scope.employeePaycomponenet.employeeId + '&departmentId=' + $scope.employeePaycomponenet.departmentId + '&branchId=' + branchId + '&companyId=' + companyId + '&isValue=' + isValue);

                                        }

                                    })
                                }

                            }

                        })

                    }

                }
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(salaryFixation.$validationSummary), 5000, 'trustedHtml');
            }
        };

        $scope.update = function(employeePaycomponenet, salaryFixation) {
            var isvalid = true;
            $scope.paycomponentList = [];
            $scope.iterateEarningObject();
            $scope.iterateDeductionObject();
            var isValue = true;
            $scope.paycomponentList[0].arrearsStartDate=$scope.employeePaycomponenet.arrearsStartDate;
            $scope.paycomponentList[0].arrears=$scope.employeePaycomponenet.arrears;
            var saveData = $scope.paycomponentList;
            if (new validationService().checkFormValidity(salaryFixation)) {
                if (isvalid) {
                    $http.get("payroll/payroll/employeepaycom/getEmployeeMaxDate?employeeId=" + $scope.employeePaycomponenet.employeeId).success(function(result) {
                        var companyId = $scope.employeePaycomponenet.companyId;
                        var branchId = $scope.employeePaycomponenet.branchId;
                        if (result.fromdate != null) {
                            var startDate = $('#startDate').val();
                            startDate = startDate.split("/");
                            startDate = new Date(startDate[2], startDate[1], startDate[0]);
                            var showErrorDate = result.fromdate;
                            var endDate = result.fromdate.split("/");
                            endDate = new Date(endDate[2], endDate[1], endDate[0]);
                           // if (startDate >= endDate) {
                                $http.post("payroll/payroll/employeepaycom/update", saveData).success(function(result) {
                                    if (result == false) {
                                    } else {
                                        $location.url( $stateParams.tenantid+'/payroll/salaryfixation/getList?employeeId=' + $scope.employeePaycomponenet.employeeId + '&departmentId=' + $scope.employeePaycomponenet.departmentId + '&branchId=' + branchId + '&companyId=' + companyId + '&isValue=' + isValue);
                                    }

                                });
                            /*} else {
                                logger.logError("From Date Should be greater than or equal to  the " + showErrorDate);
                            }*/

                        } else {
                            $http.post("payroll/payroll/employeepaycom/update", saveData).success(function(result) {
                                if (result == false) {
                                } else {
                                    $location.url($stateParams.tenantid+'/payroll/payroll/salaryfixation/getList?employeeId=' + $scope.employeePaycomponenet.employeeId + '&departmentId=' + $scope.employeePaycomponenet.departmentId + '&branchId=' + branchId + '&companyId=' + companyId + '&isValue=' + isValue);
                                }

                            })
                        }

                    });
                }
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(salaryFixation.$validationSummary), 5000, 'trustedHtml');
            }

        }

        var currentdate = new Date();
        var date = "1";
        var month = currentdate.getMonth() + 1;
        var year = currentdate.getFullYear();
        var currentDate = date + "/" + month + "/" + year;
        $scope.employeePaycomponenet.fromdate = date + "/" + month + "/" + year;

        $scope.onFrmDateChg = function(firstDay) {
            var month = firstDay.getMonth() + 1;
            var year = firstDay.getFullYear();
            var date = "1";
            var currentDate = date + "/" + month + "/" + year;
            $scope.employeePaycomponenet.fromdate = currentDate;

        }

        $scope.iterateDeductionObject = function() {
            var i = 1;
            angular.forEach($scope.deductionList, function(value, key) {
                if (value.deductionValue == undefined || value.deductionValue == '' || value.deductionValue == 0 || value.deductionValue == null) {
                    value.deductionValue = 0;
                }
                $scope.paycomponentList.push({
                    "id" : i,
                    "payComponentId" : value.payComponentId,
                    "amount" : value.deductionValue,
                    "select" : "YES",
                    "fromdate" : $scope.employeePaycomponenet.fromdate,
                    "employeeId" : $scope.employeePaycomponenet.employeeId
                });
                i = i + 1;
            });

        }

        $scope.iterateEarningObject = function() {
            debugger
            var i = 1;
            angular.forEach($scope.earningList, function(value, key) {
                if (value.earningValue == undefined || value.earningValue == '' || value.earningValue == 0 || value.earningValue == null) {
                    value.earningValue = 0;
                }
                $scope.paycomponentList.push({
                    "id" : i,
                    "payComponentId" : value.payComponentId,
                    "arrearsStartDate" : value.arrearsStartDate,
                    "arrears" : value.arrears,
                    "amount" : value.earningValue,
                    "select" : "YES",
                    "fromdate" : $scope.employeePaycomponenet.fromdate,
                    "employeeId" : $scope.employeePaycomponenet.employeeId
                });
                i = i + 1;
            });

        }

        // Function to reset valkue

        $scope.resetDeductionList = function() {
            angular.forEach($scope.deductionList, function(value, key) {
                value.deductionValue = '';
            });

        }

        $scope.resetEarningList = function() {
            angular.forEach($scope.earningList, function(value, key) {
                value.earningValue = '';
            });

        }

        $scope.cancel = function() {
            $state.go('app.payroll.salaryfixation.list1');
        };

        // Function to change deduction value

        $scope.fixDeductionCalculation = function(paycomponenetId, earningValue) {

            angular.forEach($scope.deductionList, function(value, key) {
                if (paycomponenetId == value.percentageAppliedOn) {
                    var deductionValue = value.value / 100;
                    deductionValue = earningValue * deductionValue;
                    deductionValue = Math.round(deductionValue);
                    if (value.payComponentId == "PFCOM" || value.payComponentId == "PFSEL") {
                        if (deductionValue > 1800) {
                            value.deductionValue = 1800;
                        } else {
                            value.deductionValue = deductionValue;
                        }
                    } else {
                        value.deductionValue = deductionValue;
                    }
                }

            });

        }

        // Function to fix all the earning value

        $scope.fixEarningCalculation = function(totalEarningsValue) {
            angular.forEach($scope.earningList, function(value, key) {
                if (value.payComponentId == "BASIC") {
                    value.earningValue = Math.round(totalEarningsValue * basic);
                    $scope.fixDeductionCalculation(value.payComponentId, value.earningValue);
                    $scope.fixEarningPercentCalculation(value.payComponentId, value.earningValue);
                }
                if (value.payComponentId == "DA") {
                    value.earningValue = Math.round(totalEarningsValue * da);
                    $scope.fixDeductionCalculation(value.payComponentId, value.earningValue);
                    $scope.fixEarningPercentCalculation(value.payComponentId, value.earningValue);
                }
                if (value.payComponentId == "HRA") {
                    value.earningValue = Math.round(totalEarningsValue * hra);
                    $scope.fixDeductionCalculation(value.payComponentId, value.earningValue);
                    $scope.fixEarningPercentCalculation(value.payComponentId, value.earningValue);
                }
                if (value.payComponentId == "CONVE") {
                    value.earningValue = Math.round(totalEarningsValue * conv);
                    $scope.fixDeductionCalculation(value.payComponentId, value.earningValue);
                    $scope.fixEarningPercentCalculation(value.payComponentId, value.earningValue);
                }
                if (value.payComponentId == "MEDIC") {
                    value.earningValue = Math.round(totalEarningsValue * medic);
                    $scope.fixDeductionCalculation(value.payComponentId, value.earningValue);
                    $scope.fixEarningPercentCalculation(value.payComponentId, value.earningValue);
                }
            });

            $scope.calulateDeductionValue();

        };

        // Function to fix net pay value

        $scope.fixNetSalaryCalculation = function(totalSalary) {

            var totalEarningsValue = totalSalary / 0.904;
            angular.forEach($scope.earningList, function(value, key) {
                if (value.payComponentId == "BASIC") {
                    value.earningValue = Math.round(totalEarningsValue * basic);
                    $scope.fixDeductionCalculation(value.payComponentId, value.earningValue);
                }
                if (value.payComponentId == "DA") {
                    value.earningValue = Math.round(totalEarningsValue * da);
                    $scope.fixDeductionCalculation(value.payComponentId, value.earningValue);
                }
                if (value.payComponentId == "HRA") {
                    $scope.fixDeductionCalculation(value.payComponentId, value.earningValue);
                    value.earningValue = Math.round(totalEarningsValue * hra);
                }
                if (value.payComponentId == "CONVE") {
                    value.earningValue = Math.round(totalEarningsValue * conv);
                    $scope.fixDeductionCalculation(value.payComponentId, value.earningValue);
                }
                if (value.payComponentId == "MEDIC") {
                    value.earningValue = Math.round(totalEarningsValue * medic);
                    $scope.fixDeductionCalculation(value.payComponentId, value.earningValue);
                }
            });

            $scope.calulateEarningsValue();
        };

        $scope.reset = function(earningDeductionForm) {
            if ($scope.employeePaycomponenet.isEdit != true) {
                $scope.employeePaycomponenet.totalDeductions = '';
                $scope.employeePaycomponenet.totalEarnings = '';
                $scope.employeePaycomponenet.employeeId = '';
                $scope.employeePaycomponenet.departmentId = '';
                $scope.resetDeductionList();
                $scope.resetEarningList();

            } else {
                /*
                 * $scope.employeePaycomponenet.totalDeductions='';
                 * $scope.employeePaycomponenet.totalEarnings='';
                 * $scope.resetDeductionList(); $scope.resetEarningList();
                 */

            }
        }

    

});