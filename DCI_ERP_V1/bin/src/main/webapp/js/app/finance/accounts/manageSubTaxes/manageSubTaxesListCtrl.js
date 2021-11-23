define([ 'hospital/accounts/accounts' ], function(module) {

    'use strict';
    module.registerController('manageSubTaxesListCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.isUpload = true;
        $scope.isDelete = true;

        $scope.manageSubTax = {
            subTaxId : '',
            subTaxCode : '',
            subTaxName : '',
            subTaxTypeId : '',
            subTaxType : '',
            subTaxMethodId : '',
            subTaxMethod : '',
            subTaxMethodAmount : '',
            subTaxAccount : '',
            isactive : false,
            edit : false

        };

        // Add functionality
        $scope.add = function() {
            $state.go("app.hospital.accounts.manageSubTaxes.add");
        };

        // Get Subtax list
        $scope.getList = function() {
            // alert(hi);
            $http.get("hospital/accounts/manageSubTax/list").success(function(response) {
                $scope.rowCollection = response.subTaxList;
            });
        };
        $scope.getList();

        // Delete functionality
        $scope.deleteRow = function(collection) {
            ngDialog.openConfirm().then(function() {
                $http.post("hospital/accounts/manageSubTax/delete", collection.subTaxId).success(function(response) {
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
        $scope.editRow = function(subTaxId) {
            $location.url('hospital/accounts/manageSubTaxes/edit?subTaxId=' + subTaxId);
        }

    });

});