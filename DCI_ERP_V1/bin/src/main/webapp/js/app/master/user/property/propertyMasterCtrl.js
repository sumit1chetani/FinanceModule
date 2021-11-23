
'use strict';
app.controller('propertyMasterCtrl', function($scope, $rootScope, $http, $location, logger, $log, ngDialog, $modal, utilsService, sharedProperties, $state) {
    $scope.pageCounters = [14, 16, 17, 18, 150, 500, 1000 ];

    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 14;
    $scope.initial = {}; 
    $scope.isAdd = true; 
 //alert("Hi")
 $scope.add = function() {
     $state.go('app.finance.controlscreen.creditgroup.add');
 };
 
});
