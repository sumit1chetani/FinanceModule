
    'use strict';

    app.controller('shiftreallocateAddCtrl', function($scope, $state, $http, ngDialog, $stateParams , logger, $location,
    		$controller, $injector, sharedProperties, toaster, $rootScope, validationService) {

        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages = 0

        
        
        $('#fromDate').datetimepicker({
            format : 'DD/MM/YYYY'
        })
        
         $('#toDate').datetimepicker({
         format : 'DD/MM/YYYY'
     })
    
        $scope.cancel = function() {
            $state.go("app.hr.shiftreallocate.list",{tenantid:$stateParams.tenantid});

        };

        $scope.date = '';
        var today = new Date();
        var dd = today.getDate();
        var mm = today.getMonth() + 1; // January is 0!
        var yyyy = today.getFullYear();
        if (dd < 10) {
            dd = '0' + dd;
        }
        if (mm < 10) {
            mm = '0' + mm;
        }

        var today = dd + '/' + mm + '/' + yyyy;
        $scope.date = today;

        $('#departmentNameValue').show();
        $('#departmentNameReadOnly').hide();
        $('#branchName').show();
        $('#branchNameReadOnly').hide();
        $('#employeeName').show();
        $('#employeeNameReadOnly').hide();
        $('#shiftName').show();
        $('#shiftNameReadOnly').hide();
        $('#fromDateValue').show();
        $('#fromDateReadOnly').hide();
        $('#designationName').show();
        $('#designationNameReadOnly').hide();

        $scope.shiftReAllocationobj = {
            companyName : '',
            shiftName : '',
            employeeName : '',
            branchName : '',
            departmentName : '',
            companyId : '',
            branchId : '',
            employeeId : '',
            designationName : '',
            fromDate : $scope.date,
            toDate : '',
            departmentId : '',
            designationId : '',
            shiftCode : ''
        };
        $scope.branch = false;

        $scope.shiftReAllocationobjClear = {};

        $scope.shiftReAllocationValidateData = {
            isEdit : false,
            sREdit : false
        };
        $scope.companyList=[];
        $scope.branchList = [];
        $scope.shiftNameList = [];
        $scope.designationList = [];
        $scope.departmentList = [];
        $scope.employeeList = [];
        $scope.companyList=[{
         	id:'C0001',
         	text:'MBK'
         }]
         $http.post($stateParams.tenantid+'/app/hr/holiday/branchlist').success(function(data) {
    	      	
       		$scope.branchList=data;
       		        		
     	});
       /* $scope.getCompanyList = function() {
            $http.get("hrms/hr/leaverequest/getEmployeeDetails").success(function(response) {
                $scope.shiftReAllocationobj.companyName = response.employeeDetailsList.company;
                $scope.shiftReAllocationobj.companyId = response.employeeDetailsList.companyId;
                $scope.getBranchList($scope.shiftReAllocationobj.companyId);
            })
        }
        $scope.getCompanyList();
*/
       /* $scope.getBranchList = function(companyId) {
            $http.post('hrms/hr/shiftallocation/getBranchList', companyId).success(function(datas) {
                      $scope.branchList = datas.branchList;
                if (datas.branchList.length == 0) {
                    logger.logError("No Branches For this Hospital");
                } else if (datas.branchList.length == 1) {
                    $scope.dropdown = true;
                    $scope.branch = true;
                    $scope.shiftReAllocationobj.branchId = datas.branchList[0].branchId;
                    $scope.getDepartment($scope.shiftReAllocationobj.branchId);
                } else {
                    $scope.dropdown = false;
                    $scope.branchList = datas.branchList;
                }
            });
        }
*/
        
        
        
        
        $http.get($stateParams.tenantid+'/app/commonUtility/getEmployeeList').success(function(datas) {
            $scope.employeeList = datas;
            }).error(function(datas) {
        });
        
        $http.get($stateParams.tenantid+'/app/hr/shiftreallocation/branchList').success(function(datas) {
            $scope.branchList = datas;
            }).error(function(datas) {
        });
        
        $http.get($stateParams.tenantid+'/app/hr/shiftreallocation/shiftNameList').success(function(datas) {
            $scope.shiftNameList = datas;
            }).error(function(datas) {
        });
        
        
        
        $http.get($stateParams.tenantid+'/app/commonUtility/getDepartmentList').success(function(datas) {
            $scope.departmentList = datas;
            }).error(function(datas) {
        });
        
        
        $http.get('hrms/hr/shiftreallocationnew/getShiftNameList').success(function(datas) {
            $scope.shiftNameList = datas.shiftNameList;
        });

        $scope.$watch('shiftReAllocationobj.employeeId', function(newValue, oldValue) {
            if (newValue != "") {
                $http.post('hrms/hr/shiftreallocationnew/getDesignationList', newValue).success(function(datas) {
                    $scope.designationList = datas.designationList;
                    if ($scope.designationList.length == 1) {
                        $scope.shiftReAllocationobj.designationId = datas.designationList[0].id;
                    }
                });
            }
        });

        $scope.getDepartment = function(branchId) {
            var myURL = 'hrms/hr/shiftallocation/getDepartmentList?branchId';
                $http({
                method : 'post',
                url : myURL,
                data : branchId,
            }).success(function(data) {
                $scope.departmentList = data.departmentList;
            });

        }

        $scope.$watch('shiftReAllocationobj.branchId', function(newValue, oldValue) {
            var branchId = newValue;
            var myURL = 'hrms/hr/shiftallocation/getDepartmentList?branchId';
               $http({
                method : 'post',
                url : myURL,
                data : branchId,
            }).success(function(data) {
                $scope.departmentList = data.departmentList;
            });

        });
   
        // Watch method
        $scope.$watch('shiftReAllocationobj.validityFrom', function(newValue) {
            if (newValue != "") {
                var fromDate = newValue;
                var toDate = $scope.date;
                fromDate = fromDate.split("/");
                fromDate = new Date(fromDate[2], fromDate[1], fromDate[0]);
                toDate = toDate.split("/");
                toDate = new Date(toDate[2], toDate[1], toDate[0]);
            }
        });

        $scope.$watch('[shiftReAllocationobj.fromDate,shiftReAllocationobj.toDate]', function(newValue) {
            if (newValue != "") {
                if ($scope.shiftReAllocationobj.fromDate != '' && $scope.shiftReAllocationobj.toDate != '') {
                    var fromDate = $scope.shiftReAllocationobj.fromDate;
                    var toDate = $scope.shiftReAllocationobj.toDate;
                    fromDate = fromDate.split("/");
                    fromDate = new Date(fromDate[2], fromDate[1], fromDate[0]);
                    toDate = toDate.split("/");
                    toDate = new Date(toDate[2], toDate[1], toDate[0]);
                    if (fromDate > toDate) {
                        $scope.shiftReAllocationobj.toDate = '';
                        logger.logError("From Date Should be greater than To Date");
                    }
                }
            }
        });

        $scope.getEmployee = function(departmentId) {
            var myURL = 'hrms/hr/shiftallocation/getEmployeeList?departmentId';
                  $http({
                method : 'post',
                url : myURL,
                data : departmentId,
            }).success(function(data) {
                $scope.employeeList = data.employeeList;
                $scope.employeeList = data.employeeList;
                var i= 0;
                $scope.shiftReAllocationobj.employeeId = '';
                for(i ;i < data.employeeList.length; i++)
                    {
                                              
                $scope.shiftReAllocationobj.employeeId   += ','+data.employeeList[i].employeeId;  
                                                             
                     
                    }
            });
        }

        $scope.$watch('shiftReAllocationobj.departmentId', function(newValue, oldValue) {
            var departmentId = newValue;
            var resultbean = {
                branchId : $scope.shiftReAllocationobj.branchId,
                deptId : newValue
            };
            if (newValue != "") {
                var myURL = 'hrms/hr/shiftallocation/getEmployeeList';
                    $http({
                    method : 'post',
                    url : myURL,
                    data : resultbean,
                }).success(function(data) {
                    $scope.employeeList = data.employeeList;
                    var i= 0;
                    $scope.shiftReAllocationobj.employeeId = '';
                    for(i ;i < data.employeeList.length; i++)
                        {
                                                  
                    $scope.shiftReAllocationobj.employeeId   += ','+data.employeeList[i].employeeId;  
                                                                 
                         
                        }
                });
            }
        });

        $scope.save = function(shiftReAllocationAddForm, shiftReAllocationobj, shiftReAllocationValidateData) {
            if (new validationService().checkFormValidity(shiftReAllocationAddForm)) {
                    $http.post($stateParams.tenantid+"/app/hr/shiftreallocation/add", shiftReAllocationobj).success(function(result) {

                    if (result.success == true) {
                        logger.logSuccess("Saved Successfully!");
                        $state.go('app.hrms.hr.shiftreallocationnew.list');
                    } else {
                        logger.logError(result.message);
                    }
                }).error(function(result) {
                });
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(shiftReAllocationAddForm.$validationSummary), 555000, 'trustedHtml');
            }
        };

        $scope.reset = function() {
            $scope.shiftReAllocationobj.shiftName = '';
            $scope.shiftReAllocationobj.employeeName = '';
            $scope.shiftReAllocationobj.departmentName = '';
            $scope.shiftReAllocationobj.employeeId = '';
            $scope.shiftReAllocationobj.designationName = '';
            $scope.shiftReAllocationobj.fromDate = $scope.date;
            $scope.shiftReAllocationobj.toDate = '';
            $scope.shiftReAllocationobj.departmentId = '';
            $scope.shiftReAllocationobj.designationId = '';
            $scope.shiftReAllocationobj.shiftCode = '';
            $scope.shiftReAllocationobj.branchId = '';
        }

    });

    app.controller('shiftReAllocationEditNewCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, $stateParams, validationService) {

        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages = 0

        $scope.cancel = function() {
            $state.go("app.hrms.hr.shiftreallocationnew.list");
        };

        $('#departmentNameValue').hide();
        $('#departmentNameReadOnly').show();
        $('#branchName').hide();
        $('#branchNameReadOnly').show();
        $('#employeeName').hide();
        $('#employeeNameReadOnly').show();
        $('#shiftName').hide();
        $('#shiftNameReadOnly').show();
        $('#fromDateValue').hide();
        $('#fromDateReadOnly').show();
        $('#designationName').hide();
        $('#designationNameReadOnly').show();

        $scope.shiftReAllocationobj = {
            companyName : '',
            shiftName : '',
            employeeName : '',
            branchName : '',
            departmentName : '',
            companyId : '',
            branchId : '',
            employeeId : '',
            designationName : '',
            fromDate : '',
            toDate : '',
            departmentId : '',
            designationId : '',
            shiftCode : ''
        };

        $scope.shiftReAllocationobjClear = {};

        $scope.shiftReAllocationValidateData = {
            isEdit : true,
            sREdit : true
        };

        $scope.branchList = [];
        $scope.shiftNameList = [];
        $scope.designationList = [];
        $scope.departmentList = [];
        $scope.employeeList = [];

       /* $scope.getCompanyList = function() {
            $http.get("hrms/hr/leaverequest/getEmployeeDetails").success(function(response) {
                $scope.shiftReAllocationobj.companyName = response.employeeDetailsList.company;
            })
        }
        $scope.getCompanyList();
*/
        /*$http.get('hrms/hr/shiftallocation/getBranchList').success(function(datas) {
            $scope.branchList = datas.branchList;
        });*/

        $http.get('hrms/hr/shiftreallocation/getDesignationList').success(function(datas) {
            $scope.designationList = datas.designationList;
        });

        $scope.getDepartment = function(branchId) {
            var myURL = 'hrms/hr/shiftallocation/getDepartmentList?branchId';
            $http({
                method : 'post',
                url : myURL,
                data : branchId,
            }).success(function(data) {
                $scope.departmentList = data.departmentList;
            });

        }

        $scope.getDepartmentEdit = function(branchId) {

            var myURL = 'hrms/hr/shiftallocation/getDepartmentList?branchId';
            $http({
                method : 'post',
                url : myURL,
                data : branchId,
            }).success(function(data) {
                $scope.departmentList = data.departmentList;

                $scope.getEmployeeEdit($scope.shiftReAllocationobj.departmentId);
            });

        }

        $scope.getEmployeeEdit = function(departmentId) {
            var myURL = 'hrms/hr/shiftallocation/getEmployeeList?departmentId';
            $http({
                method : 'post',
                url : myURL,
                data : departmentId,
            }).success(function(data) {
                $scope.employeeList = data.employeeList;
            });
        }

        $scope.$watch('[shiftReAllocationobj.fromDate,shiftReAllocationobj.toDate]', function(newValue) {
            if (newValue != "") {
                if ($scope.shiftReAllocationobj.fromDate != '' && $scope.shiftReAllocationobj.toDate != '') {
                    var fromDate = $scope.shiftReAllocationobj.fromDate;
                    var toDate = $scope.shiftReAllocationobj.toDate;
                    fromDate = fromDate.split("/");
                    fromDate = new Date(fromDate[2], fromDate[1], fromDate[0]);
                    toDate = toDate.split("/");
                    toDate = new Date(toDate[2], toDate[1], toDate[0]);
                    if (fromDate > toDate) {
                        $scope.shiftReAllocationobj.toDate = '';
                        logger.logError("From Date Should be greater than To Date");
                    }
                }
            }
        });

        $http.get('hrms/hr/shiftreallocationnew/getShiftNameList').success(function(datas) {
            $scope.shiftNameList = datas.shiftNameList;
        });

        var schemeName = $location.search().schemeName;
        var employeeId = $location.search().employeeId;
        var fromDate = $location.search().fromDate;
        var toDate = $location.search().toDate;

        var url = 'hrms/hr/shiftreallocationnew/getShiftReAllocationEditList?employeeId=' + employeeId + '&fromDate=' + fromDate + '&toDate=' + toDate;

        $http.get(url).success(function(result) {
            $scope.shiftReAllocationobj.branchId = result.branchId;
            $scope.shiftReAllocationobj.branchName = result.branchName;
            $scope.shiftReAllocationobj.shiftCode = result.shiftCode;
            $scope.shiftReAllocationobj.shiftName = result.shiftName;
            $scope.shiftReAllocationobj.fromDate = result.fromDate;
            $scope.shiftReAllocationobj.toDate = result.toDate;
            $scope.shiftReAllocationobj.employeeId = result.employeeId;
            $scope.shiftReAllocationobj.employeeName = result.employeeName;
            $scope.shiftReAllocationobj.departmentId = result.departmentId;
            $scope.shiftReAllocationobj.departmentName = result.departmentName;
//            $scope.shiftReAllocationobj.designationId = result.designationId;
//            $scope.shiftReAllocationobj.designationName = result.designationName;

        }).error(function(result) {
            logger.logError("Error Please Try Again");
        });

        $scope.save = function(shiftReAllocationAddForm, shiftReAllocationobj, shiftReAllocationValidateData) {
            if (new validationService().checkFormValidity(shiftReAllocationAddForm)) {
                $http.post('hrms/hr/shiftreallocationnew/update', shiftReAllocationobj).success(function(result) {
                    if (result.success == true) {
                        logger.logSuccess("Updated Successfully!");
                        $state.go('app.hrms.hr.shiftreallocationnew.list');
                    } else {
                        logger.logError("Not Updated!");
                    }
                }).error(function(result) {
                });
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(shiftReAllocationAddForm.$validationSummary), 555000, 'trustedHtml');
            }
        }

        $scope.reset = function() {
            var url = 'hrms/hr/shiftreallocationnew/getShiftReAllocationEditList?employeeId=' + employeeId + '&fromDate=' + fromDate + '&toDate=' + toDate;

            $http.get(url).success(function(result) {
                $scope.shiftReAllocationobj.branchId = result.branchId;
                $scope.shiftReAllocationobj.branchName = result.branchName;
                $scope.shiftReAllocationobj.shiftCode = result.shiftCode;
                $scope.shiftReAllocationobj.shiftName = result.shiftName;
                $scope.shiftReAllocationobj.fromDate = result.fromDate;
                $scope.shiftReAllocationobj.toDate = result.toDate;
                $scope.shiftReAllocationobj.employeeId = result.employeeId;
                $scope.shiftReAllocationobj.employeeName = result.employeeName;
                $scope.shiftReAllocationobj.departmentId = result.departmentId;
                $scope.shiftReAllocationobj.departmentName = result.departmentName;
                $scope.shiftReAllocationobj.designationId = result.designationId;
                $scope.shiftReAllocationobj.designationName = result.designationName;

            }).error(function(result) {
                logger.logError("Error Please Try Again");
            });
        }

    });

