'use strict';

app.controller('vendorListCtrl', function($scope, $rootScope,ngDialog, $http, $location, logger,
        utilsService,$state,sharedProperties,$window,validationService,toaster,$stateParams) {
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.isUpload = true;
        $scope.isDelete = true;
        $scope.numPages = 0

        $scope.getVendorListUtil = function(limit, offset) {
            var start = new Date().getTime();
            var entityType = "manageSupplier";
            var url = 'app/customerMaster/list?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount + '&entityType=' + entityType;
            $http.get(url).success(function(data) {
                if (data.success == true) {
                    $scope.pushVendorListUtil(data);
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
        $scope.pushVendorListUtil = function(data) {
            if (utilsService.isUndefinedOrNull(data.lManageCustomerBean)) {

                $scope.showEmptyLabel = true;

            } else {
                $scope.rowCollection = $scope.rowCollection.concat(data.lManageCustomerBean);
            }
        };

        $scope.getVendorListUtil();

        $scope.add = function() {
            $state.go("app.sea.vendor.add");
        };

        $scope.editRowBtn = function(entityId) {
            $location.path($stateParams.tenantid +'/vendor/edit/' + entityId);
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
                        $scope.rowCollection = [];
                        $scope.getVendorListUtil();
                        logger.logSuccess("Manage Vendor deleted successfully!");

                    } else {
                        logger.logError("Unable To Delete this Record!");
                    }
                }).error(function(data) {
                    logger.logSuccess("Error in deleting Manage Vendor!");
                });
            });

        };
    });

