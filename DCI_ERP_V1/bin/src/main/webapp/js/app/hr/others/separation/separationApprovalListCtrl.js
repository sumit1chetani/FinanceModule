define([ 'hrms/hr/hr' ], function(module) {
    'use strict';

    module.registerController('separationApprovalListCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService, $stateParams) {

        $scope.rowCollection = [];
        $scope.rowCollectionApproval = [];
        $scope.isDelete = true;
        $scope.isUpload = true;
        $scope.isAdd = true;
        $scope.add = function() {
            $state.go("app.hrms.hr.others.separation.add");
        }

        $scope.viewToApprove = function(separation_id) {
            $location.path('/hrms/hr/others/separationapproval/view/' + separation_id);
        }

        $scope.getResignationList = function() {
            $http.get('hrms/hr/others/separation/getResignationList').success(function(response) {
                $scope.rowCollection = response.resignationList;
            });
        }
        $scope.getResignationList();
    });

});