define([ 'hospital/accounts/accounts' ], function(module) {

    'use strict';
    module.registerController('debitNoteApprovalListCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {

        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages = 0;
        $scope.isDisplay = true;

        $scope.editRow = function() {
            $location.url('/hospital/accounts/debitNoteApproval/edit');
        }

    });

});