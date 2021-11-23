define([ 'payroll/tds/tds' ], function(module) {

    'use strict';

    module.registerController('otherincomeCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {

        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.isAdd = true;
        $scope.isDelete = true;
        $scope.isUpload = true;
        $scope.getList = function() {

            $http.get("payroll/tds/otherincomemaster/list").success(function(response) {
                $scope.rowCollection = response.otherIncomeMasterList;

            });
        }
        $scope.getList();

        $scope.cancel = function() {

            $state.go('app.payroll.tds.otherincome');
        };
    });

})