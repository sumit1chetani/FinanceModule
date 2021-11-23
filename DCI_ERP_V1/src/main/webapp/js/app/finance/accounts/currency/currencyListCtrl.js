//define([ 'hospital/accounts/accounts' ], function(module) {

    ///'use strict';

    app.controller('currencyListCtrl', function($scope,$state,$http,ngDialog, logger,$location,$controller,$injector, sharedProperties, toaster,$rootScope) {
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.isUpload = true;
        $scope.numPages=0;
        $scope.isDelete = true;
               
        $scope.getList = function(){
            $http.get("app/currencyNew/list").success(function(response) {
                if(response.lCurrencyBean.length>0){
                    $scope.rowCollection = response.lCurrencyBean;    
                }else{
                    $scope.rowCollection = [];
                }
                               
            });            
        };
        $scope.getList();
       
        
        $scope.add = function(){
            $state.go("app.finance.accounts.currency.add");
        };
        
        $scope.editRow = function(collections) {
            $location.url('/hospital/accounts/currency/edit/'+collections.currencyCode);
        };
        
        $scope.deleteRow = function(currencyMaster) {
            ngDialog.openConfirm().then(function() {
                $http.post("app/currencyNew/delete",currencyMaster.currencyCode)
                .success(function(response) {
                   if(response == true){
                       logger.logSuccess("Deleted Successfully!");
                       $scope.getList();
                   }
                }).error(function(response) {
                    logger.logError("Error Please Try Again");
                });
            });
        };
    });
   
//});