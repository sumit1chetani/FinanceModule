define([ 'payroll/tds/tds' ], function(module) {

    'use strict';

    module.registerController('nscintrestaddCtrl', function($scope, $state, $http) {

        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;

        $scope.getList = function() {

            $http.get("payroll/tds/nscInterest/list").success(function(response) {
                console.log("nscInterest");
                console.log(response);
                $scope.rowCollection = response.nscInterestList;

            });
        }
        $scope.getList();

        $scope.add = function() {

        };
        $scope.cancel = function() {

        };
    });

})