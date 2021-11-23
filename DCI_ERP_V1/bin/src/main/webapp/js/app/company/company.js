app.controller('companyCtrl', function($scope, $http, $stateParams) {
	/*$http.get('/' + $stateParams.tenantid + '/company/list').success(function(data) {
		$scope.companylist = data;
	})*/
	$scope.companylist1 = [{"companycode":"IA0001","companyname":"Inter Africa","shortName":null,"location":"MALAYSIA","address":"Ist floor, Biashara building, Neyerere Avenue","phoneno":"+254 (0)41 733 3044","faxno":"03-33252591","email":"info@interafrica-haulage.com","personincharge":"DIRECTOR"}]
	console.log($scope.companylist1)
});
