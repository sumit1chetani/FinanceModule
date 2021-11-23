define([ 'hospital/accounts/accounts' ], function(module) {

    'use strict';

    module.registerController('debitNoteApprovalEditCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;

        $scope.numPages = 0

        $scope.cancel = function() {
            $state.go('app.hospital.accounts.debitNoteApproval.list');
        };

        // Injector
        var $validationProvider = $injector.get('$validation');

        // Save
        $scope.update = function(debitNoteApprovalForm) {
            sharedProperties.clearObject();

        };

        $scope.reset = function() {
            $scope.OnDutyRequestApprovalData.remarks = '', $scope.OnDutyRequestApprovalData.status = ''
            if (id != 0) {
                $scope.isEdit = true;
                $http.post("").success(function(result) {
                    if (result.success == true) {
                        $scope.OnDutyRequestApprovalData.remarks = result.remarks;
                        $scope.OnDutyRequestApprovalData.status = result.status;
                    }
                });
            }
        };
    });

});
