'use strict';
app.controller('volumesCtrl', function($scope, $rootScope, $http, $location, logger, $log, ngDialog, $modal, utilsService, sharedProperties, $state) {
 $scope.avgWeightPerTeu = [];
    
 $scope.getList = function() {
            var url = 'app/csrreports/volumes';
        $http.get(url).success(function(data) {
            debugger;
            console.log(data)
//            $scope.dataCollection=data[0];
//            $scope.ssfYear=data[1];
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
    };
  $scope.getList();
});
