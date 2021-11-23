'use strict';

app.controller('userpasswordlistCtrl', function($scope, $stateParams, $state, $http,$location, ngDialog, logger, utilsService) {

	$scope.offsetCount = 0;
	$scope.limitCount = 1000;
	$scope.rowCollection = [];
	$scope.displayedCollection = [];
	$scope.itemsByPage = 10;
	
	//$('.form-control input-sm p-tb-14 bg-white rounded padder').prop('disabled', false);
	
	//for Search box
	var inputs = document.getElementsByClassName('form-control input-sm p-tb-14 bg-white rounded padder');
	for(var i = 0; i < inputs.length; i++) {
	    inputs[i].disabled = false;
	}

	
	
	$scope.getBranchList = function() {
		$http.get($stateParams.tenantid + '/app/usermaster/listpassword').success(function(response) {
					console.log(response);

					$scope.rowCollection = response.getPassword;
				});
	};
	$scope.getBranchList();
	
	
});

