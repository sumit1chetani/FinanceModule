define([ 'hrms/hr/hr' ], function(module) {
    'use strict';

    module.registerController('exitinterviewApprovalListCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService, $stateParams) {
        $scope.rowCollection = [];
        $scope.rowCollectionApproval = [];
        $scope.isDelete = true;
        $scope.isUpload = true;
        $scope.isAdd = true;

        $scope.add = function() {
            $state.go("app.hrms.hr.others.exitinterview.add");
        }

        $scope.view = function(exitid) {
            $location.path('/hrms/hr/others/exitinterview/view/' + exitid);
        }
        $scope.viewToApprove = function(exitid) {
            $location.path('/hrms/hr/others/exitinterviewapproval/view/' + exitid);
        }

        $scope.getExitInterviewList = function() {
            $http.get('hrms/hr/others/exitinterview/list').success(function(response) {
                $scope.rowCollection = response.exitInterviewList;
            });
        }
        $scope.getExitInterviewList();

        $scope.getExitInterviewApprovalList = function() {
            $http.get('hrms/hr/others/exitinterview/approvelist').success(function(response) {
                $scope.rowCollectionApproval = response.exitInterviewList;
            });
        }
        $scope.getExitInterviewApprovalList();

        $scope.deleteRow = function(id, index) {
            var myURL = 'hrms/hr/others/exitinterview/delete';
            $http({
                method : 'post',
                url : myURL,
                data : id,
            }).success(function(data) {
                if (data == true) {
                    var tableData = $scope.rowCollection;
                    $scope.rowCollection.splice(index, 1);
                    logger.logSuccess("Deleted successfully");
                    $state.reload();
                } else {
                    logger.logError("Error in delete!");
                }
            }).error(function(data) {
                logger.logSuccess("Error in Delete!");
            });
        }
    });

    module.registerController('exitinterviewViewCtrl', function($scope, $state, $stateParams, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService) {
        $scope.rowCollection = [];
        $scope.rowCollectionApproval = [];
        var exitid = $stateParams.exitid;
        $scope.isAdd = true;

        $scope.exitinterviewapprovalcancel = function() {
            $state.go('app.hrms.hr.others.exitinterviewapproval.list');
        };
        $scope.exitinterviewcancel = function() {
            $state.go('app.hrms.hr.others.exitinterview.list');
        };

        $http.get('hrms/hr/others/exitinterview/getExitInterviewDataView?exitid=' + exitid).success(function(response) {
            //alert(JSON.stringify(response));
            $scope.exitinterview = response;
            $scope.rowCollection = response.exitinterviewdtlData;
        });
        $scope.approveExitInterview = function(exitid) {
            $http.get('hrms/hr/others/exitinterview/approveExitInterview?exitid=' + exitid).success(function(response) {
                logger.logSuccess("Approved successfully");
                $state.go('app.hrms.hr.others.exitinterviewapproval.list');
            });
        }

    });

});