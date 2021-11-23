app.controller('assetSaleListCtrl', function($scope,$stateParams,$state,$http,$location,ngDialog,logger) {
    
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.isUpload = true;

    $scope.numPages=0;
    
    
    $scope.getAssetSaleList = function() {
        
        $http.get($stateParams.tenantid+'/app/finance/assetsale/getAssetSaleList').success(function(data) {
            console.log(data);  
                $scope.rowCollection = $scope.rowCollection.concat(data.lAssetSaleList);
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
    };

    $scope.getAssetSaleList();
    
    $scope.printJournalVoucherDiv = function(journalNo){
        var url = $stateParams.tenantid+'/app/journalVoucher/print?journalNo=' + journalNo;
        var wnd = window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
        wnd.print();   
     }
    
    $scope.add = function(){
        $state.go("app.finance.asset.assetaccounting.assetsale.add");
    };
    
});