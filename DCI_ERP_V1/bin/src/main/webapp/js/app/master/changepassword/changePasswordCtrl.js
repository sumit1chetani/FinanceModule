'use strict';
app.controller('changePasswordCtrl', function($scope, $timeout, $stateParams,
		$filter, $rootScope, $http, $location, logger, $state, ngDialog,validationService,toaster) {

	$scope.userList = [];
	$scope.changePwd = {
			 pwd  : '',
			cnfrmPwd : ''
	};



	$scope.save = function(changePasswordForm,changePwd) {

		 if (new validationService().checkFormValidity($scope.changePasswordForm)) {
			 if($scope.changePwd.pwd == $scope.changePwd.cnfrmPwd ){
			 $http.post($stateParams.tenantid + '/resetPassword/update',
						$scope.changePwd).success(function(data) {
					if (data== true) {
						logger.logSuccess("Password Changed Sucessfully");
						$scope.userSelected.userId ='';
						$scope.userSelected.pwdname ='';
					}else{
						logger.logError("Error on Password Change");
						$scope.userSelected.userId ='';
						$scope.userSelected.pwdname ='';
					}
				});
		 }else{
				logger.logError("Password and Confirm Password Should be Same");
		 }
		 }else{
			 toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.changePasswordForm.$validationSummary), 555000, 'trustedHtml');
		 }
			

	}

});