define([ 'payroll/payroll/payroll' ], function(module) {
'use strict';
module.registerController('gratuityCtrl', function($scope,$state,$http) {
    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    
    $scope.getList = function(){
        
        $http.get("payroll/payroll/gratuity/list")
        .success(function(response) {
            console.log("test");
            console.log(response);
            $scope.rowCollection =response.gratuityList;

        });
    }
    $scope.getList();
    
   $scope.add=function(){
        $state.go('app.payroll.payroll.gratuity.add');
    };
    $scope.editRow=function(){
        $state.go('app.payroll.payroll.gratuity.add');
    };
    $scope.cancel=function(){
        $state.go('app.payroll.payroll.gratuity');
    };
});
});