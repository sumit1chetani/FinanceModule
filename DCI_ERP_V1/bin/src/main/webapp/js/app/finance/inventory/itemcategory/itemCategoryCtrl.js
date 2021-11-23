
    'use strict';

    app.controller('itemCategoryListCtrl', function($scope, $state, $http, $location, ngDialog, logger) {

        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.isUpload = true;
        $scope.isDelete = true;

        $scope.numPages = 0
        $scope.add = function() {
            $state.go('app.finance.inventory.manageitemcategory.add');
        };

        $scope.getList = function() {
            $http.get("hospital/inventory/manageitemcategory/list").success(function(response) {
                $scope.rowCollection = response.manageItemCategoryList;
            });
        };

        $scope.getList();

        $scope.editRow = function(itemCategoryId) {
            $state.go('app.finance.inventory.manageitemcategory.edit', {
                itemCategoryId : itemCategoryId
            });
        }

        $scope.deleteRow = function(itemCategoryId, index) {
            ngDialog.openConfirm().then(function() {
                var myURL = 'hospital/inventory/manageitemcategory/delete?itemCategoryId';
                $http({
                    method : 'post',
                    url : myURL,
                    data : itemCategoryId,
                }).success(function(data) {
                    if (data == true) {
                        var tableData = $scope.rowCollection;
                        $scope.rowCollection.splice(index, 1);
                        logger.logSuccess("Deleted successfully");
                        $state.reload();
                    } else {
                        logger.logError("Unable to Delete Item Category!");
                    }
                }).error(function(data) {
                    logger.logError("Error in Delete!");
                });
            });

        };

    });

//});