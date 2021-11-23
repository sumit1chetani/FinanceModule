define([ 'hrms/hr/hr' ], function(module) {
    'use strict';
    module.registerController('exitinterviewAddCtrl', function($scope, $state, $http, ngDialog, logger, $stateParams, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService) {
        $scope.rowCollection = [];
        $scope.questionDetailsError = false;
        $scope.cancel = function() {
            $state.go('app.hrms.hr.others.exitinterview.list');
        };

        $scope.exitinterview = {
            hospitalId : '',
            branchId : '',
            departmentId : '',
            employeeId : '',
        }
        $scope.disable = false;
        $scope.getCompanyList = function() {
            var formCode = document.getElementById('formCode').value;
  
            $http.post("hrms/report/employeeReports/companyList" , formCode).success(function(response) {
              
                $scope.hospitalList = response.companyList;
               
                if (response.companyList.length == 1) {
                    $scope.exitinterview.hospitalId = response.companyList[0].id;
                    $scope.disable = true;
                    
                }

            })
        }
        $scope.getCompanyList();

        $scope.$watch('exitinterview.hospitalId', function(newValue, oldValue) {
            if (newValue != undefined && newValue != '') {
                $scope.exitinterview.departmentId = '';
                $scope.exitinterview.branchId = '';
                $scope.exitinterview.employeeId = '';
                $scope.getbranch(newValue);
            }
        });

        $scope.getbranch = function(hospitalId) {
            if (hospitalId != "" && hospitalId != null) {
                $http.post("hrms/report/employeeshift/getBranchList", hospitalId).success(function(datas) {
                    $scope.branchList = datas.branchList;
                });
            }
        }
        $scope.$watch('exitinterview.branchId', function(newValue, oldValue) {
            if (newValue != undefined && newValue != '') {
                $scope.exitinterview.departmentId = '';
                $scope.exitinterview.employeeId = '';
                $scope.getDepartment(newValue);

            }
        });

        $scope.$watch('exitinterview.departmentId', function(newValue, oldValue) {
            if (newValue != undefined && newValue != '') {
                $scope.exitinterview.employeeId = '';
                $scope.getEmployee(newValue);

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

        $scope.getEmployee = function(newValue) {
            if (newValue != undefined && newValue != '' && newValue != "") {
                var resultBean = {
                    branchId : $scope.exitinterview.branchId,
                    deptId : $scope.exitinterview.departmentId
                }
                $http.post("hrms/hr/shiftallocation/getEmployeeList", resultBean).success(function(datas) {
                    $scope.employeeList = datas.employeeList;
                });

            }

        }

        $scope.$watch('exitinterview.employeeId', function(newValue, oldValue) {
            if (newValue != undefined && newValue != '') {
                $('#questionDetails').show();
                var myURL = 'hrms/hr/others/exitinterview/getExitInterviewQuestionDatas?employeeId=' + newValue;
                $http.get(myURL).success(function(data) {
                    if (data.success == true) {
                        $scope.rowCollection = data.questionList;
                        $scope.questionDetailsError = false;
                    } else {
                        $scope.rowCollection = "";
                        $scope.questionDetailsError = true;
                    }

                })
            }
        });

        $scope.submit = function(exitInterviewForm, exitinterview) {
            if (new validationService().checkFormValidity(exitInterviewForm)) {
                $scope.save(exitinterview);
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.disciplinaryActionForm.$validationSummary), 5000, 'trustedHtml');
            }
        };

        $scope.save = function(exitinterview) {
            var isAnswer = true;
            var jsonData = {
                'exitinterviewData' : exitinterview,
                'questionAnswerDatas' : $scope.rowCollection
            }
            angular.forEach($scope.rowCollection, function(value, key) {
                if (value.answer == null || value.answer == undefined || value.answer == '') {
                    isAnswer = false;
                }
            });
            if (isAnswer == true) {
                $http.post('hrms/hr/others/exitinterview/save', jsonData).success(function(data) {
                    if (data) {
                        logger.logSuccess("Exit Interview Form Successfully Saved!");
                        $state.go('app.hrms.hr.others.exitinterview.list');

                    } else {
                        logger.logError("Error Not Saved!");
                    }
                }).error(function(data) {
                    logger.logSuccess("Error Not Savedd!");
                });
            } else {
                logger.logError("Please Fill Answer field!");
            }

        }

    });
    //
    // module.registerController('exitinterviewEditCtrl', function($scope,
    // $state, $stateParams, $http, ngDialog, logger, $location, $controller,
    // $injector, sharedProperties, toaster, $rootScope, validationService) {
    // $scope.rowCollection = [];
    // $scope.rowCollectionApproval = [];
    //
    // var exitid = $stateParams.exitid;
    //
    // $scope.cancel = function() {
    // $state.go('app.hrms.hr.others.exitinterviewapproval.list');
    // };
    // $http.post('hrms/hr/others/exitinterview/getExitInterviewDataView?exitid='
    // + exitid).success(function(response) {
    // // alert(JSON.stringify(response));
    // $scope.exitinterview = response;
    // $scope.rowCollection = response.exitinterviewdtlData;
    // });
    // });
});
