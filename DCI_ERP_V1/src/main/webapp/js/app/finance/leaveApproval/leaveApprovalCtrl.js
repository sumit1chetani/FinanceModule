'use strict';
app.controller('leaveApprovalCtrl', function($scope, $state, $http,$stateParams ,$location){
	

    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.isDisplay = true;
    $scope.leaveAppList = [];

    $scope.editRow = function(leaveRequestId ,stepOrder) {
/*
        $state.go('app.hr.leaveapprove.edit', {
            leaveRequestId : leaveRequestId*/
     	$location.url($stateParams.tenantid+'/hr/leaveApproval/edit?leaveRequestId='+ leaveRequestId + '&stepOrder='+ stepOrder); 

    }

    $scope.getList = function() {

        $http.get($stateParams.tenantid+"/finance/leaveapp/list").success(function(response) {
            $scope.rowCollection = response.leaveAppList;
        });

    }

    $scope.getList();

});