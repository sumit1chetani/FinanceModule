'use strict';
app.controller('currencyController', function($scope, ngDialog, $rootScope, $http, $location, logger, utilsService, $state, sharedProperties, $window,$stateParams) {

    $scope.emptyobject = {};

    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.emptyObject = {};
    $scope.pageCounters = [ 14, 16, 17, 18, 150, 500, 1000 ];
    $scope.itemsByPage = 14;

    $scope.add = function() {
        $state.go('app.finance.configuration.currencyadd',{tenantid:$stateParams.tenantid});
    };

    $scope.getTranslationList = function() {
        var url = $stateParams.tenantid+'/app/currency/list?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount;
        $http.get(url).success(function(data) {
            if (data.success == true && !utilsService.isUndefinedOrNull(data.lCurrencyBean)) {
                $scope.rowCollection = $scope.rowCollection.concat(data.lCurrencyBean);
                sharedProperties.setObject($scope.emptyobject);
            }
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
        $scope.offsetCount = $scope.offsetCount + $scope.limitCount;
        sharedProperties.setObject($scope.emptyObject);
    };

    $scope.getTranslationList();

    // remove to the real data holder
    $scope.deleteRow = function(currencyId, index) {
        ngDialog.openConfirm().then(function() {
            var myURL = $stateParams.tenantid+'/app/currency/delete';
            $http({
                method : 'post',
                url : myURL,
                data : currencyId,
            }).success(function(data) {
                if (data == true) {
                    var tableData = $scope.rowCollection;
                    $scope.rowCollection.splice(index, 1);
                    logger.logSuccess("Currency Master Deleted Successfully");
                    $state.reload();
                } else {
                    logger.logError("Error in Deleting Currency Master!");
                }
            }).error(function(data) {
                logger.logSuccess("Error in Currency Master!");
            });
            console.log('Modal promise resolved. Value: ');
        }, function(reason) {
            console.log('Modal promise rejected. Reason: ', reason);
        });

    };

    /* *//**
             * Delete Row
             */
    /*
     * $scope.deleteRow = function(currencyCode) {
     * 
     * var deleteCurrency = $window.confirm('Are you sure you want to delete?');
     * 
     * if (deleteCurrency == true) { var url =
     * 'app/currency/delete?currencyCode=' + currencyCode;
     * $http.get(url).success(function(result) { if (result == true) {
     * logger.logSuccess("Deleted successfully"); $state.reload(); } else {
     * logger.logError("Not Deleted "); } }).error(function(result) {
     * logger.logError("Error Please Try Again"); }); } else { $state.reload(); } };
     */
    // Redirecting Page For Edit Functionality
    $scope.editRow = function(currencyData) {
        sharedProperties.setObject(currencyData);
        $scope.add();
    };
    
    $scope.view = function(currencyData) {
        sharedProperties.setObject(currencyData);
        //$state.go($stateParams.tenantid+'app.finance.configuration.currency.view');
        $state.go('app.finance.configuration.currency.view',{tenantid:$stateParams.tenantid});

    };

});