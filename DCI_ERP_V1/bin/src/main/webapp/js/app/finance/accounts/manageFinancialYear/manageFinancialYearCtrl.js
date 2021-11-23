//define([ 'hospital/accounts/accounts' ], function(module) {

    'use strict';

   app.controller('manageFinancialYearCtrl', function($scope, $state, $stateParams,$http, $controller, logger, ngDialog, $location, $injector, sharedProperties, toaster, $rootScope) {

        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages = 0;
        $scope.isUpload = true;
        $scope.isDelete = true;

        // Populate Grid
        $scope.getTranslationList = function() {
            $scope.dataLoopCount = 0;
            $scope.showEmptyLabel = false;
            $scope.from = 0;
            $scope.to = 100;
            $scope.rowCollection = [];
            var url = 'app/financialyear/list?limit=' + $scope.from + '&offset=' + $scope.to;
            $http.get(url).success(function(data) {
                if (data.success == true) {
                    $scope.rowCollection = $scope.rowCollection.concat(data.lfinancialyearBean);
                }
            });
        };

        $scope.getTranslationList();

        $scope.add = function() {
            $state.go('app.finance.accounts.manageFinancialYear.add');
        };

        $scope.editRow = function(finId) {
            $location.url($stateParams.tenantid +'/accounts/manageFinancialYear/add?finId=' + finId);
            //$state.go('app.finance.accounts.manageFinancialYear.edit',{finId:finId});

        };

        $scope.deleteRow = function(finId, index) {

            ngDialog.openConfirm().then(function() {
                var myURL = 'app/financialyear/delete?finId=' + finId;
                $http({
                    method : 'get',
                    url : myURL,
                    data : finId,
                }).success(function(data) {
                    if (data == true) {
                        var tableData = $scope.rowCollection;
                        $scope.rowCollection.splice(index, 1);
                        logger.logSuccess("deleted successfully");
                        $state.reload();
                    } else {
                        logger.logError("Error in deleting Record!");
                    }
                }).error(function(data) {
                    logger.logSuccess("Error in Delete!");
                });
            });

        };

    });
//});