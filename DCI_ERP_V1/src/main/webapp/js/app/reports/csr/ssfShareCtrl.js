'use strict';
app.controller('ssfShareCtrl', function($scope, $rootScope, $http, $location, logger, $log, ngDialog, $modal, utilsService, sharedProperties, $state) {
$scope.getssfShares = function() {
   
    var url = 'app/csrreports/ssfShare';
    $http.get(url).success(function(data) {
        $scope.dataCollection=data[0];
        $scope.ssfYear=data[1];
    }).error(function(data) {
        logger.logError("Error Please Try Again");
    });
};

$scope.getssfShares();
/*
var date = new Date();
var year = date.getFullYear();

$scope.year = year;
$scope.yearList = [];
for(var index=0; index<10; index++){
    var nYear = parseInt($scope.year)-index
    if(nYear >= 2009){
        $scope.yearList.push(nYear);
    }
}*/
});