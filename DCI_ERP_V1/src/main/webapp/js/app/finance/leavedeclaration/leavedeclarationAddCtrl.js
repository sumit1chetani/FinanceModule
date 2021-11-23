    'use strict';
    app.controller('leavedeclarationAddCtrl', function( $filter , $scope, $state, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, validationService ,$stateParams) {

        $scope.leaveDeclareObj = {
            companyName : '',
            companyId : '',
            gradeId : '',
            year : '',
            isEdit : false,
            branch :'',

        }
        /* s */
        $scope.gradeTypeList = [];
        $scope.gradeList = [];
        $scope.yearList = [];

        $scope.reset = function() {
            $("#grade").prop("disabled", false);
            $('#proption').attr('checked', false);
            $scope.leaveDeclareObj.gradeId = ''
            $scope.leaveDeclareObj.year = ''
            $scope.gradeTypeList = []

        }

       /* $scope.getCompanyList = function() {
        	$http.get($stateParams.tenantid+'/app/usermaster/getCompanyList?formCode=F4050').success(function(datas) {
                $scope.companyList = datas;
                var foundItemDest = $filter('filter')($scope.companyList, { id:  1 })[0];
                $scope.leaveDeclareObj.companyCode=foundItemDest.id;
                }).error(function(datas) {
            });
        }
        $scope.getCompanyList();*/
        $scope.companyList=[{
        	id:'C0001',
        	text:'MBK'
        }]
        
        $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/getGradeList').success(function(data) {
          	
      		$scope.gradeList=data.gradeList;
      		        		
    	});
       /* $scope.branchList=[];
        
        $http.post($stateParams.tenantid+'/app/hr/holiday/branchlist').success(function(data) {
	      	
      		$scope.branchList=data;
      		        		
    	});
        */
        $scope.getYearList = function() {
        	debugger
        	        $http.get($stateParams.tenantid+'/finance/leave/year').success(function(datas) {
        	            $scope.yearList = datas.yearList;
        	        }).error(function(data) {
        	        });

        	    }

        $scope.change = function() {
           // var gradeid = $scope.leaveDeclareObj.gradeId;
        	var branchId = $scope.leaveDeclareObj.branch;
            var yearId = $scope.leaveDeclareObj.year;

            var url =  $stateParams.tenantid+'/finance/leave/getType?branchId=' + $scope.leaveDeclareObj.branch + '&yearId=' + $scope.leaveDeclareObj.year;
    
                  $http.get(url).success(function(datas) {

                $scope.gradeTypeList = datas.gradeTypeList;

            });
        }
        // $scope.leaveDeclareObj.gradeTypeList.push();
        var $validationProvider = $injector.get('$validation');

        $scope.save = function(leaveDeclareObj, leaveDeclarationAddForm) {
            sharedProperties.clearObject();
            if (new validationService().checkFormValidity(leaveDeclarationAddForm)) {
                var data = {
                    'gradeTypeList' : $scope.gradeTypeList,
                    'leaveDeclareObj' : $scope.leaveDeclareObj

                }
                //$http.post('hrms/hr/leave/add', data).success(function(result) {
                	  $http.post($stateParams.tenantid+'/finance/leave/add', data).success(function(result) {
                    if (result == true) {
                        logger.logSuccess("Saved Succesfully!");
                        $state.go("app.hr.leavedeclaration.list",{tenantid:$stateParams.tenantid});

                    } else {
                        logger.logError(" Already Exists!");
                    }
                })

            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(leaveDeclarationAddForm.$validationSummary), 55000, 'trustedHtml');
            }
        }

        $scope.cancel = function() {
            $state.go("app.hr.leavedeclaration.list",{tenantid:$stateParams.tenantid});
        }

    });

    app.controller('leaveDeclareEditCtrl', function($filter ,$location, $scope, $state, $http, $stateParams, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, validationService) {

     //   var gradeId = $stateParams.gradeId;
      //  var year = $stateParams.year;
        var gradeId = $location.search().gradeId;
        var year = $location.search().yearValue;
        var branch = $location.search().branchCode;
        console.log("$stateParams");
        console.log($stateParams);
        $scope.leaveDeclareObj = {
            companyName : '',
            companyId : '',
            gradeId : '',
            year : '',
            gradeName : '',
            isEdit : false ,
            branch :'',
        }
        $scope.gradeTypeList = [];
        $scope.gradeList = [];

        
   $scope.branchList=[];
        
       /* $http.post($stateParams.tenantid+'/app/invoice/branchlist').success(function(data) {
	      	
      		$scope.branchList=data;
      		        		
    	});*/
   $http.post($stateParams.tenantid+'/app/hr/holiday/branchlist').success(function(data) {
     	
 		$scope.branchList=data;
 		        		
	});
        $scope.getCompanyList = function() {
             //   $http.get("hrms/hr/leaverequest/getEmployeeDetails").success(function(response) {
                $http.get($stateParams.tenantid+'/finance/leaverequest/getEmployeeDetails').success(function(response) {

                $scope.leaveDeclareObj.companyName = response.employeeDetailsList.company;
                $scope.leaveDeclareObj.companyId = response.employeeDetailsList.companyId;
                $scope.leaveDeclareObj.gradeName = response.employeeDetailsList.grade;
                $scope.leaveDeclareObj.gradeId = response.employeeDetailsList.gradeId;
                $scope.getGradeList($scope.leaveDeclareObj.companyId);
            })
        }

        $scope.getYearList = function() {

            $http.get('hrms/hr/leave/year').success(function(datas) {
                $scope.yearList = datas.yearList;

            }).error(function(data) {

            });

        }
        $scope.companyList=[{
        	id:'C0001',
        	text:'MBK'
        }]
        
      
        $scope.branchList=[];
        
        $http.post($stateParams.tenantid+'/app/hr/holiday/branchlist').success(function(data) {
	      	
      		$scope.branchList=data;
      		        		
    	});
/*
        $scope.getCompanyList = function() {
        	$http.get($stateParams.tenantid+'/app/usermaster/getCompanyList?formCode=F4050').success(function(datas) {
                $scope.companyList = datas;
                var foundItemDest = $filter('filter')($scope.companyList, { id:  1 })[0];
                $scope.leaveDeclareObj.companyCode=foundItemDest.id;
                }).error(function(datas) {
            });
        }
        $scope.getCompanyList();

        */
        $scope.getGradeList = function() {
        $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/getGradeList').success(function(data) {
          	
      		$scope.gradeList=data.gradeList;
      		        		
    	});
        }
        
        $scope.getGradeList();
        
        
        $scope.getYearList = function() {
        	debugger
        	        $http.get($stateParams.tenantid+'/finance/leave/year').success(function(datas) {
        	            $scope.yearList = datas.yearList;
        	        }).error(function(data) {
        	        });

        	    }

        $scope.change = function() {
            var gradeid = $scope.leaveDeclareObj.gradeId;

            var yearId = $scope.leaveDeclareObj.year;

            var url =  $stateParams.tenantid+'/finance/leave/getType?gradeid=' + $scope.leaveDeclareObj.gradeId + '&yearId=' + $scope.leaveDeclareObj.year;
    
                  $http.get(url).success(function(datas) {

                $scope.gradeTypeList = datas.gradeTypeList;

            });
        }
        // End

        $scope.reset = function() {
        	
            $scope.leaveDeclareObj.gradeId = ''
            $scope.leaveDeclareObj.year = ''
            $scope.leaveDeclareObj.branch = ''	
            $scope.gradeTypeList = []
            var url = $stateParams.tenantid+'/finance/leave/getEditList?branch=' + branch + '&year=' + year;

            $http.get(url).success(function(result) {
                $scope.getCompanyList();
                $scope.gradeTypeList = result.gradeTypeList;
                $scope.leaveDeclareObj.gradeId = parseInt(result.leaveDeclareObj.gradeId);
                $scope.leaveDeclareObj.branchCode = parseInt(result.leaveDeclareObj.branchCode);
                $scope.leaveDeclareObj.year = parseInt(result.leaveDeclareObj.year);
                $scope.leaveDeclareObj.isEdit = result.leaveDeclareObj.isEdit;
                $scope.leaveDeclareObj.isEdit = true;

            });
            
        }

        //var url = 'hrms/hr/leave/getEditList?gradeId=' + gradeId + '&year=' + year;
        var url = $stateParams.tenantid+'/finance/leave/getEditList?branch=' + branch + '&year=' + year;
debugger;
        $http.get(url).success(function(result) {
            console.log(result);
            $scope.getCompanyList();
           // $scope.getGradeList();
            $scope.gradeTypeList = result.gradeTypeList;
            $scope.leaveDeclareObj.gradeId = result.leaveDeclareObj.gradeId;
            $scope.leaveDeclareObj.branch= result.leaveDeclareObj.branch;
            //$scope.leaveDeclareObj.branch = parseInt(result.leaveDeclareObj.branchCode);

            $scope.leaveDeclareObj.year = parseInt(result.leaveDeclareObj.year);
            $scope.leaveDeclareObj.isEdit = result.leaveDeclareObj.isEdit;
            $scope.leaveDeclareObj.companyName = result.leaveDeclareObj.companyId;
            $scope.leaveDeclareObj.companyName ='MBK'; 
            	$scope.leaveDeclareObj.isEdit = true;
            $scope.checked = true;
            console.log($scope.leaveDeclareObj);
        });

      

        $scope.update = function(leaveDeclareObj, leaveDeclarationAddForm) {
            sharedProperties.clearObject();
            if (new validationService().checkFormValidity(leaveDeclarationAddForm)) {
                var data = {
                    'gradeTypeList' : $scope.gradeTypeList,
                    'leaveDeclareObj' : $scope.leaveDeclareObj

                }

             //   $http.post('hrms/hr/leave/add', data).success(function(result) {
              	  $http.post($stateParams.tenantid+'/finance/leave/add', data).success(function(result) {

                    if (result == true) {
                        logger.logSuccess("Update Succesfully!");
                        $state.go("app.hr.leavedeclaration.list",{tenantid:$stateParams.tenantid});
                    } else {
                        logger.logError(" Already Exists!");
                    }
                })

            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(leaveDeclarationAddForm.$validationSummary), 55000, 'trustedHtml');
            }

            //
        }

        $scope.cancel = function() {
            $state.go("app.hr.leavedeclaration.list",{tenantid:$stateParams.tenantid});
        }

    });

