define([ 'hospital/accounts/accounts' ], function(module) {

    'use strict';
    module.registerController('manageTaxesListCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.isUpload = true;
        $scope.isDelete = true;

        $scope.manageTax = {
            taxId : '',
            taxTypeId : '',
            taxMethodId : '',
            taxCode : '',
            taxName : '',
            taxMethod : '',
            taxMethodAmount : '',
            taxType : '',
            taxAccount : '',
            isactive : false

        };

        // Get tax list
        $scope.getList = function() {
            $http.get("hospital/accounts/manageTax/list").success(function(response) {
                $scope.rowCollection = response.taxList;
            });
        };
        $scope.getList();

        // Add functionality
        $scope.add = function() {
            $state.go("app.hospital.accounts.manageTaxes.add");
        };

        // Delete functionality
        $scope.deleteRow = function(collection) {
            ngDialog.openConfirm().then(function() {
                $http.post("hospital/accounts/manageTax/delete", collection.taxId).success(function(response) {
                    if (response.success == true) {
                        logger.logSuccess("Deleted Successfully!");
                        $scope.getList();
                    } else
                        logger.logError("You can't delete this record,Deletion Failed");
                }).error(function(result) {
                    logger.logError("Error Please Try Again");
                });
            });
        };

        // Edit functionality
        $scope.editRow = function(taxId) {
            $location.url('hospital/accounts/manageTaxes/edit?taxId=' + taxId);
        };

    });

});