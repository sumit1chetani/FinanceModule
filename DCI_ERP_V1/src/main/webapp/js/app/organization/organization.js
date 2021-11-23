app.controller('organizationCtrl',
		function($scope, $modal, $http, $stateParams) {
			$scope.organizationnew = function(obj) {
				var modalInstance = $modal.open({
					templateUrl : 'views/orgnizationadd.html',
					controller : 'organizationAddCtrl',
					preCloseCallback : $scope.getList
				});
			};

			$scope.getList = function() {
				$http.get('/organization/list')
						.success(function(data) {
							$scope.organizationlist = data;
						})
			};
			$scope.getList();

		});
app.controller('organizationAddCtrl', function($scope, $http,
		$stateParams, $state, $modalInstance) {
	$scope.organisation = {};
	$scope.saveOrganization = function() {
		$http.post('/organization/save',
				$scope.organisation).success(function() {
			$scope.cancel();
			$state.reload();
		})
	}
	
	$scope.cancel = function(){
		 $modalInstance.dismiss('cancel');
	}
});