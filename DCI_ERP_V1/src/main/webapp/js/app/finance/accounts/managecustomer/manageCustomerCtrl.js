//define([ 'hospital/asset/asset' ], function(module) {

    'use strict';

    app.controller('manageCustomerListCtrl', function($scope, $state, $http, $stateParams,$location, ngDialog, logger, utilsService) {

        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;

        $scope.isDelete = true;
        $scope.isUpload = true;

        $scope.numPages = 0

        $scope.getCustomerListUtil = function() {
            var start = new Date().getTime();
            var entityType = "manageCustomer";
            var url = 'app/customerMaster/list?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount + '&entityType=' + entityType;
            $http.get(url).success(function(data) {
                if (data.success == true) {
                    $scope.pushCustomerListUtil(data);
                    $scope.dataLoopCount++;
                } else {
                    if ($scope.dataLoopCount == 0) {
                        $scope.showEmptyLabel = true;
                    }
                    logger.logError("Error Please Try Again");
                }
                var end = new Date().getTime();
                var time = end - start;
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });

        };
        $scope.pushCustomerListUtil = function(data) {
            if (utilsService.isUndefinedOrNull(data.lManageCustomerBean)) {

                $scope.showEmptyLabel = true;

            } else {
                $scope.rowCollection = data.lManageCustomerBean;
            }
        };

        $scope.getCustomerListUtil();

        $scope.add = function() {
            $state.go("app.finance.accounts.managecustomer.add");
        };
        $scope.editRowBtn = function(entityId) {
            $location.path($stateParams.tenantid +'/accounts/managecustomer/edit/' + entityId);
        }
        // delete
        $scope.deleteRow = function(entityId, index) {
            ngDialog.openConfirm().then(function() {
                var myURL = 'app/customerMaster/delete';
                $http({
                    method : 'post',
                    url : myURL,
                    data : entityId,
                }).success(function(data) {
                    if (data == true) {
                        $scope.rowCollection.splice(index, 1);
                        logger.logSuccess("Manage Customer deleted successfully!");
                    } else {
                        logger.logError("Error in deleting Manage Customer!");
                    }
                }).error(function(data) {
                    logger.logSuccess("Error in deleting Manage Customer!");
                });
            }, function(reason) {
            });

        };

  //  });

});