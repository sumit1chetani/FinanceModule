'use strict';
app.controller('transasiaVolTrendCtrl', function($scope, $rootScope, $http, $location, logger, $log, ngDialog, $modal, utilsService, sharedProperties, $state) {

    $scope.companyList=[];
    $scope.transasia={
            companyId:''
    };
 $scope.getCompanyList=function(){
     $http.post("app/csrreports/getCompanyList").success(function(response) {
         $scope.companyList=response;
     }).error(function(result) {
         logger.logError("Error Please Try Again");
     });
 }
    
    
$scope.getTransasiaVolTrend = function() {
    if($scope.transasia.companyId != null && $scope.transasia.companyId != ''){
    var url = 'app/csrreports/transasiaVolTrend?companyId='+$scope.transasia.companyId;
    $http.get(url).success(function(data) {
        $scope.dataCollection=data[0];
        $scope.oelGrowthRate=data[1];
        $scope.ssfGrowthRate=data[2];
        var sharingPattern=data[3][0];
        $scope.lastYear=sharingPattern.lastYear;
        $scope.prevYear=sharingPattern.prevYear;
        $scope.oelLastShare=sharingPattern.oelLastShare;
        $scope.oelPrevShare=sharingPattern.oelPrevShare;
        $scope.ssfLastShare=sharingPattern.ssfLastShare;
        $scope.ssfPrevShare=sharingPattern.ssfPrevShare;
    }).error(function(data) {
        logger.logError("Error Please Try Again");
    });
    }
};
$scope.getCompanyList();
$scope.getTransasiaVolTrend();
});