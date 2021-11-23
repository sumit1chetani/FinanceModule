'use strict';
app.controller('departmentAddCtrl', function($scope, $rootScope, $http, $location, logger, utilsService, $state, sharedProperties, $window,validationService,toaster) {

    $scope.departmentData = {
        deptCode : '',
        deptName : '',
        deptDesc : '',
        deptHead : '',
        isActive : 'N'
    };

    $scope.cancel = function() {
        $location.path("/department");
    };

    $scope.departmentValidateData = {
        isEdit : false,
        deptCodeEdit : false
    }
    $scope.employeeList = [];
    $scope.deptList = [];
    // Drop Down Functionality

    $scope.getDropdownvalue = function() {
        $http.get('app/department/getEmployee').success(function(datas) {
            $scope.employeeList = datas.employeeList;
            console.log(datas.employeeList);
        });
        $http.get('app/department/getDepartment').success(function(datas) {
            $scope.deptList = datas;
        }).error(function(datas) {
        });

    }
    $scope.getDropdownvalue();

    $scope.save = function(departmentAddForm, departmentData, departmentValidateData) {

        $scope.submitted = true;

        if (new validationService().checkFormValidity($scope.departmentAddForm)) {
            $http.post('app/department/add', departmentData).success(function(result) {
                console.log("result" + result);
                if (result) {
                    logger.logSuccess("Saved successfully!");
                    $state.go('app.master.employee.department');
                } else {
                    logger.logError("Department Name Already Exists!!");
                }
            }).error(function(result) {
                console.log("data" + result);
            });

        } else {
            toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.departmentAddForm.$validationSummary), 555000, 'trustedHtml');
        }
    };

    $scope.update = function(departmentAddForm, departmentData, departmentValidateData) {
        if (new validationService().checkFormValidity($scope.departmentAddForm)) {
            var deptCode = $location.search().deptCode;
            $scope.departmentData.deptCode = $location.search().deptCode;
            var updateRowData = departmentData;
            $http.post('app/department/update', updateRowData).success(function(result) {
                if (result) {
                    logger.logSuccess("Updated successfully!");
                    $state.go('app.master.employee.department');
                } else {
                    logger.logError("Department Name Already Exists!!");
                }
            }).error(function(data) {
                console.log("data" + data);
            });

        } else {
            toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.departmentAddForm.$validationSummary), 555000, 'trustedHtml');
        }
    };

    //Fetch Values
    $scope.isEdit = false;
    var deptCode = $location.search().deptCode;
    if (deptCode == undefined) {
        var deptName = $scope.departmentData.deptName;
        var deptDesc = $scope.departmentData.deptDesc;
        var deptHead = $scope.departmentData.deptHead;
        var isActive = $scope.departmentData.isActive;
        $scope.departmentData.isEdit = false;
    } else {
        $http.post('app/department/edit', deptCode).success(function(result) {

            if (result.isEdit == false) {
                logger.logError("Please Try Again");
            } else {
                $scope.departmentData.deptName = result.deptName;
                $scope.departmentData.deptHead = result.deptHead;
                $scope.departmentData.isActive = result.isActive;
                $scope.departmentValidateData.isEdit = true;
                $scope.departmentData.isEdit = true;
            }
        }).error(function(data) {
            console.log("data" + data);
        });
    }

});