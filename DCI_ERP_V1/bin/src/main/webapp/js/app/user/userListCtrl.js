app.controller('userListCtrl',
		function($scope, $modal, $http, $stateParams) {

	   $scope.getList = function() {
	        var url = '/' + $stateParams.tenantid+ '/user/list';
	        $http.get(url).success(function(data) {
	                $scope.userlist = data;
	        })
			};
			$scope.getList();

		});
