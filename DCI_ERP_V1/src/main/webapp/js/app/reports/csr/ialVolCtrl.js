'use strict';
app.controller('ialVolCtrl', function($scope, $rootScope, $http, $location, logger, $log, ngDialog, $modal, utilsService, sharedProperties, $state) {


    $scope.ialCollection = [];
     
$scope.getIalVol = function() {
   
    var url = 'app/csrreports/ialVol';
    $http.get(url).success(function(data) {
        $scope.ialCollection=[];
    	 $scope.ialCollection =data;
    }).error(function(data) {
        logger.logError("Error Please Try Again");
    });
};

$scope.getIalVol();
});
