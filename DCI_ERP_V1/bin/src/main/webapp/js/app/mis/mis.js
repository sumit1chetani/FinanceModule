function config($stateProvider, $urlRouterProvider, $locationProvider) {
	// define
 	
 	
	/*$stateProvider.state('app.mis.opeartions', {

		abstract : true,
		templateUrl : "views/common",
		data : {
			title : 'OPerations'
		}
	})
			
			.state('app.mis.opeartions.slotUtilization', {
		abstract : true,
		templateUrl : "views/common",
 		data : {
			title : 'slotUtilization Report'
		}
	})
		.state(
					'app.mis.opeartions.slotUtilization.list',
					{
						url : '/mis/operations/slotUtilizationlist',
						templateUrl : 'views/mis/operations/slotUtilizationList',
						data : {
							title : 'List'
						},
						controller : 'slotUtilizationListctrl',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/mis/operations/slotUtilization/slotUtilizationListctrl.js' ]);
									} ]
						}
					})

					*/
							
}
angular.module('neuboard').config(config).run(function($rootScope, $state) {
	$rootScope.$state = $state;
});
