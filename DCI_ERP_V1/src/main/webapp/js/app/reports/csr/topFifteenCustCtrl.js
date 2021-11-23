'use strict';
app.controller('topFifteenCustCtrl', function($scope, $rootScope, $http, $location, logger, $log, ngDialog, $modal, utilsService, sharedProperties, $state) {
    var date = new Date();
    var year1 = date.getFullYear();
    $scope.yearList = [];
    $scope.year = parseInt(year1);
    $scope.years = parseInt(year1);
    for(var index=0; index<10; index++){
        var nYear = parseInt($scope.year)-index
        if(nYear >= 2008){
            var obj = new Object();
            obj.id = nYear;
            obj.text=nYear;
            $scope.yearList.push(obj);
        }
    }
    console.log($scope.yearList);
 $scope.getList = function() {
        $http({
            url: "app/csrreports/topFifteenCust", 
            method: "GET",
            params: {
                'year':$scope.years
            }
         }).success(function(data) {
             $scope.ssfList =data[0];
             $scope.xclList=data[1];
             $scope.oelList=data[2];
         });
    };
  $scope.getList();
});
