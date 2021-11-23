define([ 'payroll/payroll/payroll' ], function(module) {
'use strict';
module.registerController('finalsettleCtrl', function($scope,$state,$http) {
    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    
    $scope.add=function(){
        $state.go('app.payroll.payroll.finalsettle.add');
    };
    $scope.editRow=function(){
        $state.go('app.payroll.payroll.finalsettle.add');
    };
    $scope.cancel=function(){
        $state.go('app.payroll.payroll.finalsettle');
    };
});
});