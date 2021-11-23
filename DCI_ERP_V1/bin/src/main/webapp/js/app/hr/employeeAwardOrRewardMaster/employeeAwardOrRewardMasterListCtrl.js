//define([ 'hrms/hr/hr' ], function(module) {

    'use strict';

    app.controller('AwardOrRewardMasterListCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService) {
        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.isUpload = true;
        $scope.isDelete = true;

        $scope.editRow = function(empAwardRewardList) {
            $scope.callDialog($scope, empAwardRewardList.empId, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope);
        }

        $scope.getList = function() {

            $http.get("hrms/hr/employeeinfo/employeeawardreward/list").success(function(response) {
                $scope.rowCollection = response.empAwardRewardList;
            });
        }
        $scope.getList();

        $scope.deleteRow = function(empAwardRewardList) {
            ngDialog.openConfirm().then(function() {
                $http.post("hrms/hr/employeeinfo/employeeawardreward/delete", empAwardRewardList.empId).success(function(response) {
                    if (response.success == true) {
                        logger.logSuccess("Deleted Successfully!");
                        $scope.getList();
                    }
                }).error(function(result) {
                    logger.logError("Error");
                });
            });
        }

        $scope.deleteSelected = function() {

        }

        $scope.add = function() {
            $scope.callDialog($scope, 0, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope);
        }

        $scope.callDialog = function($scope, empId, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope) {
            ngDialog.open({
                scope : $scope,
                template : 'views/hrms/hr/employeeinfo/EmployeeAwardOrRewardMaster/EmployeeAwardOrRewardMasterAdd',
                controller : $controller('AwardOrRewardMasterAddCtrl', {
                    $scope : $scope,
                    empId : empId,
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

    });

    module.registerController('AwardOrRewardMasterAddCtrl', function($scope, empId, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, validationService) {

        $scope.isEdit = false;
        $scope.cancel = function() {
            ngDialog.close();
        }
        sharedProperties.clearObject();
        $scope.empAwardReward = {

            empId : '',
            empName : '',
            hospital : '',
            hosId : '',
            branchId : '',
            branch : '',
            awardReward : '',
            awardId : '',
            date : '',
        };
        var currentDate = new Date();
        currentDate = ('0' + currentDate.getDate()).slice(-2) + "/" + ('0' + (Number(currentDate.getMonth()) + 1)).slice(-2) + "/" + currentDate.getFullYear();
        $scope.empAwardReward.date = currentDate;
        $scope.branchList = [];
        $scope.employeeList = [];
        $scope.awardList = [];
        $scope.hospitalList = [];

        $scope.hospitalList = function() {
            $http.get("hrms/hr/employeeinfo/employeeawardreward/hosplist").success(function(datas) {
                $scope.empAwardReward.hosId = datas.empAwardRewardBean.hosId;
                $scope.empAwardReward.hospital = datas.empAwardRewardBean.hospital;
                $scope.branchLists($scope.empAwardReward.hosId);
            });
        }

        $scope.employList = function(branchId) {

            $http.post("hrms/hr/employeeinfo/employeeawardreward/emplist", branchId).success(function(datas) {
                $scope.employeeList = datas.employeeList;
                console.log($scope.employeeList);
            });
        }

        $scope.branchLists = function(hId) {
            $http.post("hrms/hr/employeeinfo/employeeawardreward/branchlist", hId).success(function(datas) {

                $scope.branchList = datas.branchList;

            });
        }

        $scope.$watch("empAwardReward.branchId", function(newValue, oldValue) {
            if (newValue != "" && newValue != undefined && newValue != null) {
                $scope.employList(newValue);
            }

        });

        $scope.awardList = function() {
debugger;
            $http.get("hrms/hr/employeeinfo/employeeawardreward/awardlist").success(function(datas) {
                $scope.awardList = datas.awardList;
            });
        }

        if (empId != 0) {

            $scope.isEdit = true;
            $http.post("hrms/hr/employeeinfo/employeeawardreward/edit", empId).success(function(response) {
                if (response.success == true) {
                    $scope.empAwardReward = response.empAwardRewardBean;
                    $scope.empAwardReward.branchId = response.empAwardRewardBean.branchId.toString();
                    $scope.empAwardReward.empId = response.empAwardRewardBean.empId.toString();
                    $scope.empAwardReward.awardReward = response.empAwardRewardBean.awardReward.toString();
                    if ($scope.empAwardReward.hosId != "") {
                        $scope.branchLists($scope.empAwardReward.hosId);
                        if ($scope.empAwardReward.branchId != "") {
                            $scope.employList($scope.empAwardReward.branchId);

                        }
                    }
                }
            });
        }

        $scope.hospitalList();
        $scope.awardList();

        $scope.save = function(empAwardReward, empAwardRewardForm) {
            if (new validationService().checkFormValidity(empAwardRewardForm)) {
                sharedProperties.clearObject();
                $http.post("hrms/hr/employeeinfo/employeeawardreward/save", $scope.empAwardReward).success(function(response) {
                    if (response.success == true) {
                        logger.logSuccess("Saved Successfully!");
                        ngDialog.close();
                    } else {
                        logger.logError(response.message);
                    }
                });

            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(empAwardRewardForm.$validationSummary), 555000, 'trustedHtml');
            }
        }
        $scope.update = function(empAwardReward, empAwardRewardForm) {
            if (new validationService().checkFormValidity(empAwardRewardForm)) {
                sharedProperties.clearObject();
                $http.post("hrms/hr/employeeinfo/employeeawardreward/update", $scope.empAwardReward).success(function(response) {

                    if (response.success == true) {
                        logger.logSuccess("Updated Successfully!");
                        ngDialog.close();
                    } else {
                        logger.logError(response.message);
                    }
                });
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(empAwardRewardForm.$validationSummary), 555000, 'trustedHtml');
            }

        }
        $scope.reset = function(empAwardRewardForm) {
            if ($scope.isEdit == true) {

                $http.post("hrms/hr/employeeinfo/employeeawardreward/edit", empId).success(function(response) {
                    if (response.success == true) {
                        $scope.empAwardReward = response.empAwardRewardBean;
                        $scope.empAwardReward.branchId = response.empAwardRewardBean.branchId.toString();
                        $scope.empAwardReward.empId = response.empAwardRewardBean.empId.toString();
                        $scope.empAwardReward.awardReward = response.empAwardRewardBean.awardReward.toString();
                        if ($scope.empAwardReward.hosId != "") {
                            $scope.branchLists($scope.empAwardReward.hosId);
                            if ($scope.empAwardReward.branchId != "") {
                                $scope.employList($scope.empAwardReward.branchId);

                            }
                        }
                    }
                });

            } else {
                $scope.empAwardReward.empId = '';
                $scope.empAwardReward.awardReward = '';
                $scope.empAwardReward.branchId = '';
            }

        }

    });

//});
