'use strict';
app.controller('resetPassWordCtrl', function($scope, $timeout, $stateParams,
		$filter, $rootScope, $http, $location, logger, $state, ngDialog,validationService,toaster) {

	$scope.userList = [];
	$scope.resetPasswordData = {
		userId : '',
		pwdname : ''
	};

	$http.post($stateParams.tenantid + '/app/usermaster/usercompanymodulelist').success(
			function(data) {
				if (data.success = true) {
					$scope.userList = data.lUserMasterBean;
				}
			});

	 
    $scope.cancel = function() {
        $location.path("{tenantid}/dashboard/dashboard");
    };
	$scope.save = function() {

		 
			 $http.post($stateParams.tenantid + '/app/password/add',$scope.resetPasswordData).success(function(data) {
					if (data) {
						logger.logSuccess("Password Updated Successfully");
						$scope.userSelected.userId ='';
						$scope.userSelected.pwdname ='';
					}else{
						logger.logError("Error on Password Update");
						$scope.userSelected.userId ='';
						$scope.userSelected.pwdname ='';
					}
				});
		
			

	}

});