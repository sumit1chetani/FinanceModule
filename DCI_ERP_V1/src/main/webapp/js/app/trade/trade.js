
function config($stateProvider, $urlRouterProvider, $locationProvider) { 


    
    $stateProvider.state('app.trade', {
        abstract : true,
        templateUrl : "views/common",
        data : {
            title : 'Trade'
        }
    })
    .state('app.trade.quotation', {
		abstract : true,
		templateUrl : "views/common.jsp",
		data : {
			title : 'Quotation'
		}
	})
	
	  .state('app.trade.quotationApproval', {
		abstract : true,
		templateUrl : "views/common.jsp",
		data : {
			title : 'Quotation'
		}
	})
	
	   .state('app.trade.booking', {
		abstract : true,
		templateUrl : "views/common.jsp",
		data : {
			title : 'Booking'
		}
	})
	
	
	// quotation
	 .state(
		'app.trade.quotation.list',
		{
			url : '/trade/quotation/list',
			data : {
				title : 'List'
			},
			controller : 'requestquotationListCtrl',
			templateUrl : 'views/trade/quotation/quotationList',
			resolve : {   
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/trade/quotation/quotationListCtrl.js' ]);
						} ]
			}
		})
		
		 .state(
		'app.trade.quotation.add',
		{
			url : '/trade/quotation/Add',
			data : {
				title : 'Add'
			},
			controller : 'quotationAddCtrl',
			templateUrl : 'views/trade/quotation/quotationAdd',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/trade/quotation/quotationAddCtrl.js' ]);
						} ]
			}
		})
		
		 .state(
		'app.trade.quotation.copy',
		{
			url : '/trade/quotation/copy',
			data : {
				title : 'Add'
			},
			controller : 'quotationAddCtrl',
			templateUrl : 'views/trade/quotation/quotationAdd',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/trade/quotation/quotationAddCtrl.js' ]);
						} ]
			}
		})
		
			 .state(
		'app.trade.quotation.edit',
		{
			url : '/trade/quotation/edit',
			data : {
				title : 'Edit'
			},
			controller : 'quotationAddCtrl',
			templateUrl : 'views/trade/quotation/quotationAdd',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/trade/quotation/quotationAddCtrl.js' ]);
						} ]
			}
		})
		
		 .state(
		'app.trade.quotation.view',
		{
			url : '/trade/quotation/view',
			data : {
				title : 'View'
			},
			controller : 'quotationAddCtrl',
			templateUrl : 'views/trade/quotation/quotationView',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/trade/quotation/quotationAddCtrl.js' ]);
						} ]
			}
		})
		
		 .state(
		'app.trade.quotation.editforQuotationDate',
		{
			url : '/trade/quotation/editforQuotationDate',
			data : {
				title : 'Edit'
			},
			controller : 'quotationAddCtrl',
			templateUrl : 'views/trade/quotation/quotationDateExtend',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/trade/quotation/quotationAddCtrl.js' ]);
						} ]
			}
		})
		
		//quotation approval
				 .state(
				'app.trade.quotationApproval.list',
				{
					url : '/trade/quotationApproval/list',
					data : {
						title : 'List'
					},
					controller : 'requestquotationListCtrl',
					templateUrl : 'views/trade/quotationApproval/quotationApprovalList',
					resolve : {
						deps : [
								'$ocLazyLoad',
								function($ocLazyLoad) {
									return $ocLazyLoad
											.load([ 'js/app/trade/quotation/quotationListCtrl.js' ]);
								} ]
					}
				})
			
				 .state(
				'app.trade.quotationApproval.view',
				{
					url : '/trade/quotationApproval/view',
					data : {
						title : 'View'
					},
					controller : 'quotationAddCtrl',
					templateUrl : 'views/trade/quotationApproval/quotationApprovalView',
					resolve : {
						deps : [
								'$ocLazyLoad',
								function($ocLazyLoad) {
									return $ocLazyLoad
											.load([ 'js/app/trade/quotation/quotationAddCtrl.js' ]);
								} ]
					}
				})
					 .state(
				'app.trade.quotationApproval.review',
				{
					url : '/trade/quotationApproval/review',
					data : {
						title : 'Review'
					},
					controller : 'quotationAddCtrl',
					templateUrl : 'views/trade/quotationApproval/quotationreView',
					resolve : {
						deps : [
								'$ocLazyLoad',
								function($ocLazyLoad) {
									return $ocLazyLoad
											.load([ 'js/app/trade/quotation/quotationAddCtrl.js' ]);
								} ]
					}
				})
				 .state(
				'app.trade.quotationApproval.edit',
				{
					url : '/trade/quotationApproval/edit',
					data : {
						title : 'Add'
					},
					controller : 'quotationAddCtrl',
					templateUrl : 'views/trade/quotationApproval/quotationApprovalAdd',
					resolve : {
						deps : [
								'$ocLazyLoad',
								function($ocLazyLoad) {
									return $ocLazyLoad
											.load([ 'js/app/trade/quotation/quotationAddCtrl.js' ]);
								} ]
					}
				})
				
				
				
		
		//booking
		.state(
				'app.trade.booking.list',
				{
					url : '/booking/list',
					data : {
						title : 'List'
					},
					templateUrl : "views/trade/booking/bookingList",
					controller : 'bookingListCtrl',
					resolve : {
						deps : [
								'$ocLazyLoad',
								function($ocLazyLoad) {
									return $ocLazyLoad
											.load([ 'js/app/trade/booking/bookingListCtrl.js' ]);
								} ]
					}
				})
		.state(
				'app.trade.booking.add',
				{
					url : '/booking/add',
					data : {
						title : 'Add'
					},
					templateUrl : "views/trade/booking/bookingAdd",
					controller : 'bookingAddCtrl',
					resolve : {
						deps : [
								'$ocLazyLoad',
								function($ocLazyLoad) {
									return $ocLazyLoad
											.load([ 'js/app/trade/booking/bookingAddCtrl.js' ]);
								} ]
					}
				})
		.state(
				'app.trade.booking.edit',
				{
					url : '/booking/edit',
					data : {
						title : 'Edit'
					},
					templateUrl : "views/trade/booking/bookingAdd",
					controller : 'bookingAddCtrl',
					resolve : {
						deps : [
								'$ocLazyLoad',
								function($ocLazyLoad) {
									return $ocLazyLoad
											.load([ 'js/app/trade/booking/bookingAddCtrl.js' ]);
								} ]
					}
				})
				
						.state(
				'app.trade.booking.view',
				{
					url : '/booking/view',
					data : {
						title : 'View'
					},
					templateUrl : "views/trade/booking/bookingview",
					controller : 'bookingAddCtrl',
					resolve : {
						deps : [
								'$ocLazyLoad',
								function($ocLazyLoad) {
									return $ocLazyLoad
											.load([ 'js/app/trade/booking/bookingAddCtrl.js' ]);
								} ]
					}
				})
				
				
				
		
		
		
	 
		 
    

}
angular.module('neuboard').config(config).run(function($rootScope, $state) {
	$rootScope.$state = $state;
});

