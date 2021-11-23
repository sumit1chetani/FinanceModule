'use strict';
app.controller('companyReconciliationCtrl', function($scope, $rootScope, $controller,$http, $location, logger, $log, ngDialog, $modal, utilsService, sharedProperties, $state,$stateParams) {
    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.companyList=[];
    $scope.mReconObj={companyCode:''};
    
    $scope.getListDetail=function(){
        $http.get($stateParams.tenantid+'/app/companyReconciliation/getListOfGL?companyCode='+$scope.mReconObj.companyCode).success(function(datas){
            $scope.rowCollection = datas.companyReconciliationList;
            $scope.companyList=datas.companyList;
         });
    }
    
    $scope.getListDetail();
    $scope.currentURL=$location.protocol() + '://'+ $location.host() +':'+  $location.port()+"/#" +$location.path();
    if(window.localStorage.getItem('CmpRecon')==$scope.currentURL){
         alert('window ' + $scope.currentURL + ' is already opened');
         //window.focus();
         //window.open($rootScope.currentURL,'_self').close();
         setTimeout(window.close(),5000);
     }else{
         window.localStorage.setItem('CmpRecon', $scope.currentURL);
     }
    
    $(window).unload(function(){
        localStorage.removeItem('CmpRecon');
        });


    
    $scope.jvPost=function(obj){
        $location.url($stateParams.tenantid+'transaction/journalvoucher/add?ledgerNo='+obj.ledgerNo)
    }
   
});
