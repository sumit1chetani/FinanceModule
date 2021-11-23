//define([ 'payroll/payroll/payroll' ], function(module) {
    'use strict';
   // module.registerController('employeeesiCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService) {
       	app.controller('employeeesiCtrl', function($stateParams,$scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService,utilsService, $window,$timeout) {

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

        $scope.esiGeneration = {

            companyId : '',
            companyName : '',
            branchId : '',
            branchName : '',
            departmentId : '',
            departmentName : '',
            amount : '',
            Show : false,
            isOnLoad : false,
            employeeId : '',
            employeeName : '',
            monthYear : '',
            esicCode : '',
            wages : '',
            days : ''

        };

        $scope.submit = function(employeesiform) {
            if (new validationService().checkFormValidity(employeesiform)) {
                var dept = $scope.esiGeneration.departmentId;
                if (dept == '') {
                	dept = null;
                }
                var resultbean = {
                    companyId : $scope.esiGeneration.companyId,
                    branchId : $scope.esiGeneration.branchId,
                    dept : $scope.esiGeneration.departmentId,
                    monthYear : $scope.esiGeneration.monthYear

                }

                $http.post("payroll/payroll/esi/list", resultbean).success(function(datas) {
                    $scope.rowCollection = datas.esiBeanList;
                    if ($scope.rowCollection.length > 0) {
                        $scope.esiGeneration.Show = true;
                    }
                })

            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(employeesiform.$validationSummary), 5000, 'trustedHtml');
            }

        }
        
        
        
        
        
        
      //Excel Export	
        $scope.exportXl = function(monthYear){
        	  var esiList = [];
              esiList = $scope.rowCollection;
              angular.forEach(esiList, function(value, key) {
                  value.monthYear = monthYear;

              });

       	 $http.post("payroll/payroll/esi/exportExcel",esiList).success(function(datas) {
                       if(datas){
                           debugger;
                           $("#Export").bind('click', function() {
                           });
                           $('#Export').simulateClick('click');
                           logger.logSuccess("Exported successfully!");
                       }else{
                           logger.logError("Failed to export");
                           $scope.esiGeneration.Show = false;

                       }
                       
                   }).error(function(response) {
                       logger.logError("Error Please Try Again");
                   });
           
           }
           

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
        
        
        
        

      /*  $scope.exportXl = function(monthYear) {
            var esiList = [];
            esiList = $scope.rowCollection;
            angular.forEach(esiList, function(value, key) {
                value.monthYear = monthYear;

            });
            $http.post("payroll/payroll/esi/exportExcel", esiList).success(function(datas) {
                if (datas.success == true) {
                    $('#btnRowDivId').append('<a id="captainMsglink" href="filePath/EMPLOYEE_ESI_FILE.xls" class="control-label" download="EMPLOYEE_ESI_FILE.xls"></a>');
                    $("#captainMsglink").bind('click', function() {
                    });
                    $('#captainMsglink').simulateClick('click');

                    logger.logSuccess("File Exported Successfully");
                } else {
                    $scope.esiGeneration.Show = false;
                }

            })

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
*/
        $scope.getCompanyList = function() {

          //  $http.get("payroll/payroll/payrollgeneration/getCompanyList").success(function(datas) {
        	$http.get($stateParams.tenantid	+ '/app/usermaster/getCompanyList?formCode='
    				+ 'F0378').success(
    		function(datas) {  
        	$scope.companyList = datas;
                
                if ($scope.companyList.length >=1) {
                    $scope.esiGeneration.companyId = $scope.companyList[0].id;
                    $scope.esiGeneration.companyName = $scope.companyList[0].companyName;
                }
            })
        }

        $scope.$watch('esiGeneration.companyId', function(newValue, oldValue) {
            var companyId = newValue;
            if ($scope.esiGeneration.companyId != '' && $scope.esiGeneration.isOnLoad == false) {
                $scope.esiGeneration.branchId = '';
                $scope.esiGeneration.branchName = '';
            }

            $http.post("payroll/payroll/payrollgeneration/getBranchList", companyId).success(function(datas) {
                $scope.esiGeneration.isOnLoad = false;
                $scope.branchList = datas.branchList;
                if ($scope.branchList.length == 1) {
                    $scope.esiGeneration.branchId = $scope.branchList[0].id;
                    $scope.esiGeneration.branchName = $scope.branchList[0].text;
                }
                $scope.esiGeneration.departmentId = '';
                $scope.departmentList = [];
                $scope.employeeList = [];
            })

        });

        $scope.getBranchList = function(companyId, branchID) {
            $http.post("payroll/payroll/payrollgeneration/getBranchList", companyId).success(function(datas) {
                $scope.branchList = datas.branchList;
                $scope.esiGeneration.branchId = branchID;
                $scope.departmentList = [];
                $scope.employeeList = [];
                $scope.esiGeneration.departmentId = '';
                $scope.esiGeneration.employeeId = '';

            })
        }

        $scope.getDepartment = function(branchId) {
            $http.post("payroll/payroll/payrollgeneration/getDepartmentList", branchId).success(function(datas) {
                $scope.departmentList = datas.departmentList;
                $scope.esiGeneration.departmentId = '';
                $scope.esiGeneration.employeeId = '';
                $scope.employeeList = [];
            })
        }

        $scope.$watch('esiGeneration.branchId', function(newValue, oldValue) {
            var branchId = newValue;
            $http.post("payroll/payroll/payrollgeneration/getDepartmentList", branchId).success(function(datas) {
                $scope.departmentList = datas.departmentList;
                $scope.esiGeneration.departmentId = '';
                $scope.employeeList = [];
            })

        });

        $scope.getEmployeeDetails = function() {
            $http.get("payroll/payroll/payrollgeneration/getUserDetail").success(function(datas) {
                $scope.getCompanyList();
                $scope.esiGeneration.companyId = datas.id;
                $scope.esiGeneration.companyName = datas.companyName;
                $scope.esiGeneration.isOnLoad = true;
                $scope.getBranchList($scope.esiGeneration.companyId, datas.branchId);
                $scope.esiGeneration.branchName = datas.branchName;
                $scope.getDepartment(datas.branchId);
            })
        }

        $scope.getEmployeeDetails();

        $scope.getMonthYearList = function() {

            $http.get("payroll/payroll/payrollgeneration/getMonthYearList").success(function(datas) {
                $scope.monthYearList = datas.monthYearList;
            })
        }

        $scope.getMonthYearList();

    

});