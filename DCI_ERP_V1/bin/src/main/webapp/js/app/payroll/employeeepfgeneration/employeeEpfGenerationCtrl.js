//define([ 'payroll/payroll/payroll' ], function(module) {
    'use strict';
    
   	app.controller('employeeEpfGenerationCtrl', function($stateParams,$scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService,utilsService, $window,$timeout) {
    //module.registerController('employeeEpfGenerationCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService) {

        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.isEdit = false;
        $scope.isDisplay = true;
        $scope.isAuthorized = false;

        $scope.isAdd = true;
        $scope.isDelete = true;
        $scope.isUpload = true;

        $scope.epfGeneration = {
            departmentId : '',
            companyId : '',
            companyName : '',
            branchName : '',
            departmentName : '',
            branchId : '',
            amount : '',
            employeeName : '',
            employeeId : '',
            monthYear : '',
            isEdit : false,
            isOnLoad : false,
            
            outList:[]
        };
        
        
        
        
        
        var table = {
                
                epf : '',
                b : '',
               
            };
            $scope.epfGeneration.outList.push(table);
            
            
            
        
        
        
        
        
        
        
        
        
        
        

        $scope.submit = function(employeeepfgeneration) {
            if (new validationService().checkFormValidity(employeeepfgeneration)) {
                var dept = $scope.epfGeneration.departmentId;
                if (dept == '') {
                	dept = null;
                }
                var resultbean = {
                    companyId : $scope.epfGeneration.companyId,
                    branchId : $scope.epfGeneration.branchId,
                    dept : $scope.epfGeneration.departmentId,
                    monthYear : $scope.epfGeneration.monthYear

                }

                $http.post("payroll/payroll/epf/list", resultbean).success(function(datas) {
                    
                    $scope.rowCollection = datas.employeeProvidentFundList;
                    
//                    angular.forEach(datas.employeeProvidentFundList,function(value,key)
//                    {
//                        
//                       
//                        $scope.epfGeneration.outList.b = value.employeeId;
//
//                        
//                        $scope.epfGeneration.outList.epf = value.salary;
//                         if($scope.epfGeneration.outList.epf >=15000){
//                             $scope.epfGeneration.outList.epf = 1250;                        
//                             }else {
//                                 if ($scope.epfGeneration.outList.epf  < 15000) {
//                                     var percentageValue = 8.33 / 100;
//                                     var totaldeductValue = $scope.epfGeneration.outList.epf * percentageValue;
//                                     $scope.epfGeneration.outList.epf = Math.round(totaldeductValue);
//                                 }
//                             }
//
//                        
//                    });
                    
                    
                 

                })

            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(employeeepfgeneration.$validationSummary), 5000, 'trustedHtml');
            }

        }

        $scope.exportXl = function(employeeepfgeneration) {
            if (new validationService().checkFormValidity(employeeepfgeneration)) {
                if ($scope.epfGeneration.departmentId == null || $scope.epfGeneration.departmentId == undefined || $scope.epfGeneration.departmentId == '') {
                    $scope.epfGeneration.departmentId = null;
                }

                var resultbean = {
                    companyId : $scope.epfGeneration.companyId,
                    branchId : $scope.epfGeneration.branchId,
                    dept : $scope.epfGeneration.departmentId,
                    monthYear : $scope.epfGeneration.monthYear

                }

               /* $http.post("payroll/payroll/epf/exportExcel", resultbean).success(function(datas) {
                    if (datas.success == true) {
                    	
                        $("#Export").bind('click', function() {
                        });
                        $('#Export').simulateClick('click');
                        $('#btnRowDivId').append('<a id="captainMsglink" href="tempdoc/Employee_Epf_File.xls" class="control-label" download="Employee_Epf_File.xls"></a>');
                        $("#captainMsglink").bind('click', function() {
                        });
                        $('#captainMsglink').simulateClick('click');

                        logger.logSuccess("File Exported Successfully");
                    } else {
                        $scope.epfGeneration.Show = false;
                    }

                })*/
                
                $http.post('payroll/payroll/epf/exportExcel', resultbean).success(function(data) {
                    if(datas.success == true){
                        debugger;
                        $("#Export").bind('click', function() {
                        });
                        $('#Export').simulateClick('click');
                        logger.logSuccess("Exported successfully!");
                    }else{
                        logger.logError("Failed to export");
                        $scope.esiGeneration.Show = false;

                    }
                    
                }).error(function(data) {
                    logger.logError("Error Please Try Again");
                });

                
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(employeeepfgeneration.$validationSummary), 5000, 'trustedHtml');
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

        $scope.getCompanyList = function() {
        	$http.get($stateParams.tenantid	+ '/app/usermaster/getCompanyList?formCode='
    				+ 'F0388').success(
    		function(datas) {  
            //$http.get("payroll/payroll/payrollgeneration/getCompanyList").success(function(datas) {
                $scope.companyList = datas;
                if ($scope.companyList.length >= 1) {
                    $scope.epfGeneration.companyId = $scope.companyList[0].id;
                    $scope.epfGeneration.companyName = $scope.companyList[0].companyName;
                }
                
            })
        }

        $scope.$watch('epfGeneration.companyId', function(newValue, oldValue) {
            var companyId = newValue;
            if ($scope.epfGeneration.companyId != '' && $scope.epfGeneration.isOnLoad == false) {
                $scope.epfGeneration.branchId = '';
                $scope.epfGeneration.branchName = '';
            }

            $http.post("payroll/payroll/payrollgeneration/getBranchList", companyId).success(function(datas) {
                $scope.branchList = datas.branchList;
                if ($scope.branchList.length == 1) {
                    $scope.epfGeneration.branchId = $scope.branchList[0].id;
                    $scope.epfGeneration.branchName = $scope.branchList[0].text;
                }
                $scope.epfGeneration.isOnLoad = false;
                $scope.epfGeneration.departmentId = '';
                $scope.departmentList = [];
                $scope.employeeList = [];
            })

        });

        $scope.getBranchList = function(companyId, branchID) {
            $http.post("payroll/payroll/payrollgeneration/getBranchList", companyId).success(function(datas) {
                $scope.branchList = datas.branchList;
                $scope.epfGeneration.branchId = branchID;
                $scope.departmentList = [];
                $scope.employeeList = [];
                $scope.epfGeneration.departmentId = '';
                $scope.epfGeneration.employeeId = '';

            })
        }

        $scope.$watch('epfGeneration.branchId', function(newValue, oldValue) {
            var branchId = newValue;
            $http.post("payroll/payroll/payrollgeneration/getDepartmentList", branchId).success(function(datas) {
                $scope.departmentList = datas.departmentList;
                $scope.epfGeneration.departmentId = '';
                $scope.employeeList = [];
            })

        });

        $scope.getDepartment = function(branchId) {

            $http.post("payroll/payroll/payrollgeneration/getDepartmentList", branchId).success(function(datas) {
                $scope.departmentList = datas.departmentList;
                $scope.epfGeneration.departmentId = '';
                $scope.epfGeneration.employeeId = '';
                $scope.employeeList = [];
            })
        }

        $scope.getEmployeeDetails = function() {

            $http.get("payroll/payroll/payrollgeneration/getUserDetail").success(function(datas) {
                $scope.getCompanyList();
                $scope.epfGeneration.isOnLoad = true;
                $scope.epfGeneration.companyId = datas.companyId;
                $scope.epfGeneration.companyName = datas.companyName;
                $scope.getBranchList($scope.epfGeneration.companyId, datas.branchId);
                $scope.epfGeneration.branchName = datas.branchName;
                $scope.getDepartment(datas.branchId);

            })
        }

        /*
         * $scope.getEmployeeList = function(departmentId){ var resultBean={
         * branchId:$scope.epfGeneration.branchId, departmentId:departmentId };
         * $http.post("payroll/payroll/payrollgeneration/getEmployeeList",resultBean).success(function(datas) {
         * $scope.employeeList = datas.employeeList;
         * $scope.epfGeneration.employeeId=''; }) }
         */
        $scope.getEmployeeDetails();

        $scope.getMonthYearList = function() {
            $http.get("payroll/payroll/payrollgeneration/getMonthYearList").success(function(datas) {
                $scope.monthYearList = datas.monthYearList;
            })
        }

        $scope.getMonthYearList();

    

});