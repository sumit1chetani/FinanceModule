'use strict';
app.controller('topTenNvoMloCtrl', function($scope, $rootScope, $http, $location, logger, $log, ngDialog, $modal, utilsService, sharedProperties, $state) {
    var date = new Date();
    var year = date.getFullYear();
    /*$scope.nvoCollection = [{name:'PERMA',value:'289037'},
                            {name:'BALTIC',value:'54450'},
                            {name:'TRANSASIA',value:'50602'},
                            {name:'VASCO',value:'59'},
                            {name:'CARAVEL',value:'289037'},
                            {name:'IAL',value:'289037'},
                            {name:'EMKAY',value:'289037'},
                            {name:'ASIATS',value:'289037'},
                            {name:'BALA',value:'289037'},
                            {name:'LMT',value:'289037'}];
    
    $scope.mloCollection = [{name:'APL',value:'289037'},
                            {name:'MAERSK',value:'54450'},
                            {name:'NORSIA',value:'50602'},
                            {name:'EMC',value:'59'},
                            {name:'MSC',value:'289037'},
                            {name:'HMM',value:'289037'},
                            {name:'HAPAG',value:'289037'},
                            {name:'HANJIN',value:'289037'},
                            {name:'CSCL',value:'289037'},
                            {name:'WHL',value:'289037'}];*/
    $scope.year = parseInt(year);
    $scope.yearList = [];
    for(var index=0; index<10; index++){
        var nYear = parseInt($scope.year)-index;
        if(nYear >= 2008){
            var obj = new Object();
            obj.id = nYear;
            obj.text=nYear;
            $scope.yearList.push(obj);
        }
    }
    
 $scope.getList = function() {
        $http({
            url: "app/csrreports/toptennvomlo", 
            method: "GET",
            params: {
                'year':$scope.year
            }
         }).success(function(data) {
             $scope.nvoCollection =data[0];
             $scope.mloCollection=data[1];
             console.log(data)
         });
    };
  $scope.getList();
});
