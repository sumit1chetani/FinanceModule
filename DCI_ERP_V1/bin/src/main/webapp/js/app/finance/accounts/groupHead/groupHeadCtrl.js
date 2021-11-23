//define([ 'hospital/accounts/accounts' ], function(module) {

   /// 'use strict';
    app.controller('groupHeadListCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {

        $scope.pageCounters = [ 14, 16, 17, 18, 150, 500, 1000 ];

        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.initial = {};
        $scope.isAdd = true;
        $scope.getTranslationList = function() {
            var url = 'app/groupHeadMaster/getList?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount;
            $http.get(url).success(function(data) {
                if (data.success == true) {
                    $scope.rowCollection = $scope.rowCollection.concat(data.objGrpHeadMasterBean);
                    console.log($scope.rowCollection);
                }
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
            $scope.offsetCount = $scope.offsetCount + $scope.limitCount;
        };

        $scope.getTranslationList();

    });

//});