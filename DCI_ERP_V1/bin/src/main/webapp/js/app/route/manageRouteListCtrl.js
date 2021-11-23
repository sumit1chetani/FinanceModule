app.controller('manageRouteListCtrl', function($scope, $modal, $http,
		$stateParams, $state) {

	$scope.getList = function() {
		// $http.get('/route/list')
		// .success(function(data) {
		// $scope.routeList = data;
		// })
	};
	$scope.getList();

	$scope.routeList = [ {
		routeName : 'R1',
		routeDescription : 'KAMPALA',
		commencementDate : '12/10/2011',
		operationSince : '12/10/2011',
		completionDate : '12/10/2018',
		active : true

	}, {
		routeName : 'R2',
		routeDescription : 'ATHI RIVER',
		commencementDate : '21/08/2014',
		operationSince : '21/08/2014',
		completionDate : '21/08/2020',
		active : true

	}, {
		routeName : 'R3',
		routeDescription : 'JUBA',
		commencementDate : '19/03/2012',
		operationSince : '19/03/2012',
		completionDate : '19/03/2020',
		active : true

	}, {
		routeName : 'R4',
		routeDescription : 'TARU',
		commencementDate : '02/07/2016',
		operationSince : '02/07/2016',
		completionDate : '02/07/2022',
		active : true

	}]
	$scope.routenew = function() {
		$state.go('route.add');
	}

});
app.controller('manageRouteAddCtrl', function($scope, $http, $stateParams,
		$state) {

	$scope.routeList = [ {
		check : false,
		stoppingName : '',
		description : ''
	}, {
		check : false,
		stoppingName : '',
		description : ''
	} ]
	$scope.saveOrganization = function() {
		$http.post('/route/save', $scope.route).success(function() {
			$scope.cancel();
			$state.reload();
		})
	}

	$scope.route = {
		routeName : '',
		routeDescription : '',
		commencementDate : '',
		operationSince : '',
		completionDate : '',
		active : true

	}
	$scope.tmpRoute = angular.copy($scope.route);
	$scope.routePush = {
		check : false,
		stoppingName : '',
		description : ''
	}

	$scope.addRow = function(index) {
		$scope.routeList.splice(index + 1, 0, angular.copy($scope.routePush));
	}

	$scope.removeRow = function() {
		$scope.tablerow = [];
		angular.forEach($scope.routeList, function(row, index) {
			var check = row.check;
			console.log(index);
			if (check == undefined || check == "" || row.check == false) {
				$scope.tablerow.push(row);
			} else {

			}
		});
		$scope.routeList = $scope.tablerow;
	}

	$scope.reset = function() {
		$scope.route = angular.copy($scope.tmpRoute);
	}

	$scope.cancel = function() {
		$state.go('route.list');
	}
});