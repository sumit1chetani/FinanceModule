define([ 'hospital/accounts/accounts' ], function(module) {
    'use strict';
    module.registerController('pendingReceiptReport', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {
        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;

        $scope.isDelete = true;
        $scope.isUpload = true;
        $scope.isAdd = true;

        $scope.getList = function() {
            $http.get("app/pendingReceiptReport/list").success(function(response) {
                $scope.rowCollection = response.reportBeanList;
            });
        }
        $scope.getList();

        $scope.sendMail = function() {
            var isCheck = false;
            angular.forEach($scope.rowCollection, function(value, key) {
                if (value.select == true) {
                    isCheck = true;
                }
            });

            if (isCheck == true) {
                $http.post('app/pendingReceiptReport/sendMail', $scope.rowCollection).success(function(data) {
                    if (data) {
                        logger.logSuccess("Email Sent Successfully");
                    } else {
                        logger.logError("Error Please Try again later");
                    }
                }).error(function(data) {
                });
            } else {
                logger.logError("Please Select invoice details");
            }

        }

        $scope.chkAll = false;
        $scope.checkAll = function(checkBox) {
            if (checkBox) {
                $scope.chkAll = true;
            } else {
                $scope.chkAll = false;
            }

            angular.forEach($scope.rowCollection, function(value, key) {
                value.select = $scope.chkAll;
            });

        };

    })

});