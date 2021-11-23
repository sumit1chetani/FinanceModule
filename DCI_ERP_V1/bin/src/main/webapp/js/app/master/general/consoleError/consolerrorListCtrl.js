'use strict';

app.controller('consolerrorListCtrl', function($scope, $stateParams, $state, $http,
		$location, ngDialog, logger, utilsService) {

	$scope.offsetCount = 0;
	$scope.limitCount = 1000;
	$scope.rowCollection = [];
	$scope.displayedCollection = [];
	$scope.itemsByPage = 10;

	$scope.isDelete = true;
	
	$scope.numPages = 0
	$scope.isEdit=false;
	/*$scope.getBranchList = function() {
		$http.get($stateParams.tenantid + '/api/branch/list').success(
				function(response) {
					console.log(response);
					$scope.rowCollection = response;
				});
	};
	$scope.getBranchList();*/
	
	
	$scope.getError = function() {
		$http.get($stateParams.tenantid + '/api/branch/getError').success(
				function(response) {
					console.log(response);
					var j=0;
					/*$scope.rowCollection = response.getTextList;*/
					for(var i=response.getTextList.length;i>=0;i--){
						$scope.rowCollection[j] = response.getTextList[i];
						j++;
					}
				});
	};
	$scope.getError();
	





});

