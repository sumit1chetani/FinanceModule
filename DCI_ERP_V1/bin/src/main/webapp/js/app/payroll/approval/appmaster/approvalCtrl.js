define([ 'payroll/approval/approval' ], function(module) {

    'use strict';

    module.registerController('approvalCtrl', function($scope, $state) {

        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;

        $scope.add = function() {

            $state.go('app.payroll.approval.approvalmaster.add');
        };
        $scope.cancel = function() {

            $state.go('app.payroll.approval.approvalmaster.list');
        };
    });

})