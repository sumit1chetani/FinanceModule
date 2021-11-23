define([ 'hospital/inventory/inventory' ], function(module) {

    'use strict';
    module.registerController('qualityListCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages = 0;
        
        $scope.isAdd = true;

        $scope.getList = function() {
            var url = 'app/grn/qcList?formName=assetQC&limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount;
            $http.get(url).success(function(data) {
                if (data.success == true) {
                    $scope.rowCollection = $scope.rowCollection.concat(data.lGRNBean);
                    sharedProperties.setObject($scope.emptyObject);
                }
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
            $scope.offsetCount = $scope.offsetCount + $scope.limitCount;
        };

        $scope.getList();

        $scope.editRowBtn=function(grnCode){
            $location.url('/hospital/inventory/qualityCtrl/add?grnCode='+grnCode);
        }

    });

});