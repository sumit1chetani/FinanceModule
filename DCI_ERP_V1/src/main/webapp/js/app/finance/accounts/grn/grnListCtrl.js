define([ 'hospital/accounts/accounts' ], function(module) {

    'use strict';
    module.registerController('grnListCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages = 0

        $scope.add = function() {
            $state.go("app.hospital.accounts.grn.add");
        };
    });

});