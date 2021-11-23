//define([ 'hospital/accounts/accounts' ], function(module) {

  ///  'use strict';
    app.controller('exchangeRateListCtrl', function($scope, $state, $stateParams,$http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, utilsService) {

        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages = 0;
        $scope.isUpload = true;
        $scope.isDelete = true;

        $scope.getExchangeRateListUtil = function(limit, offset) {
            var start = new Date().getTime();
            var url = 'app/exchangerate/list?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount;
            $http.get(url).success(function(data) {

                if (data.success == true) {
                    $scope.pushExchangeRateListUtil(data);
                    $scope.dataLoopCount++;
                } else {
                    if ($scope.dataLoopCount == 0) {
                        $scope.showEmptyLabel = true;
                    }
                    //logger.logError("Error Please Try Again");
                }
                var end = new Date().getTime();
                var time = end - start;
            }).error(function(data) {
               //logger.logError("Error Please Try Again");
            });
        };
        $scope.getExchangeRateListUtil();

        $scope.pushExchangeRateListUtil = function(data) {
            if (utilsService.isUndefinedOrNull(data.lExchangeRateBean)) {

                if ($scope.dataLoopCount == 0) {
                    $scope.showEmptyLabel = true;
                }
            } else {
                $scope.rowCollection = $scope.rowCollection.concat(data.lExchangeRateBean);

            }
        };

        $scope.editRow = function(exchangeRateCode) {
            $location.url($stateParams.tenantid+'/hospital/accounts/exchangeRate/edit/' + exchangeRateCode);

        };
        $scope.add = function() {
            $state.go("app.finance.accounts.exchangeRate.add");
        };

        /**
         * Delete Row
         */
        $scope.deleteRow = function(eRCode, index) {
            ngDialog.openConfirm().then(function() {
                var myURL = 'app/exchangerate/deleteRow';
                $http({
                    method : 'post',
                    url : myURL,
                    data : eRCode,
                }).success(function(data) {
                    if (data == true) {
                        $scope.rowCollection.splice(index, 1);
                        logger.logSuccess("Deleted successfully");
                        $state.reload();
                    } else {
                        logger.logError("Error in deleting Exchange Rate!");
                    }
                }).error(function(data) {
                    logger.logSuccess("Error in Delete!");
                });
            });
        };

    });

//});