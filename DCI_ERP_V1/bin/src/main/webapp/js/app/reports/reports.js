function config($stateProvider, $urlRouterProvider, $locationProvider) { 


    
    $stateProvider.state('app.reports.grldinvoice', {
        abstract : true,
        templateUrl : "views/common",
        data : {
            title : 'GR and LD Invoice'
        }
    })
    
     $stateProvider.state('app.reports.grldrates', {
        abstract : true,
        templateUrl : "views/common",
        data : {
            title : 'GR and LD Rates'
        }
    })
    // GR & LD Invoice
    
    .state('app.reports.grldinvoice.list',{
						url : '/reports/grldinvoice/list',
						data : {
							title : 'List'
						},

						controller : 'grldInvoiceListCtrl',
						templateUrl : 'views/reports/grldInvoice/grldInvoiceList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/reports/reports/grldInvoice/grldInvoiceListCtrl.js' ]);
									} ]

						}

					})
					
					.state(
							'app.reports.grldinvoice-add',
							{
								url : '/reports/grldinvoice/add',
								data : {
									title : 'Add'
								},

								controller : 'grldInvoiceAddCtrl',
								templateUrl : 'views/reports/grldInvoice/grldInvoiceAdd',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/reports/reports/grldInvoice/grldInvoiceAddCtrl.js' ]);
											} ]

								}
							})
							
							.state(
													'app.reports.grldinvoice-edit',
													{
														url : '/reports/grldinvoice/edit',
														data : {
															title : 'Edit'
														},

														controller : 'grldInvoiceEditCtrl',
														templateUrl : 'views/reports/grldInvoice/grldInvoiceAdd',
														resolve : {
															deps : [
																	'$ocLazyLoad',
																	function($ocLazyLoad) {
																		return $ocLazyLoad
																				.load([ 'js/app/reports/reports/grldInvoice/grldInvoiceEditCtrl.js' ]);
																	} ]

														}
													})
													
														
													
											.state(	
													'app.reports.grldinvoice-view',
				                                        {
					                                      url : '/reports/grldinvoice/view',
				                                 	      data : {
						                                  title : 'View'
					                                       },
					                                   templateUrl : "views/reports/grldInvoice/grldInvoiceView",
					                                   controller : 'grldInvoiceEditCtrl',
					                                    resolve : {
						                                    deps : [
								                           '$ocLazyLoad',
								                            function($ocLazyLoad) {
									                         return $ocLazyLoad
										             	    .load([ 'js/app/reports/reports/grldInvoice/grldInvoiceEditCtrl.js' ]);
							                            	} ]
				                                        	}
				                                         })

					
							 // GR & LD Rates
						    
						    .state('app.reports.grldrates.list',{
												url : '/reports/grldrates/list',
												data : {
													title : 'List'
												},

												controller : 'grldRatesListCtrl',
												templateUrl : 'views/reports/grldRates/grldRatesList',
												resolve : {
													deps : [
															'$ocLazyLoad',
															function($ocLazyLoad) {
																return $ocLazyLoad
																		.load([ 'js/app/reports/reports/grldRates/grldRatesListCtrl.js' ]);
															} ]

												}

											})
											
											.state(
													'app.reports.grldrates-add',
													{
														url : '/reports/grldrates/add',
														data : {
															title : 'Add'
														},

														controller : 'grldRatesAddCtrl',
														templateUrl : 'views/reports/grldRates/grldRatesAdd.jsp',
														resolve : {
															deps : [
																	'$ocLazyLoad',
																	function($ocLazyLoad) {
																		return $ocLazyLoad
																				.load([ 'js/app/reports/reports/grldRates/grldRatesAddCtrl.js' ]);
																	} ]

														}
													})
													
													.state(
													'app.reports.grldrates-edit',
													{
														url : '/reports/grldrates/edit',
														data : {
															title : 'Edit'
														},

														controller : 'grldRatesEditCtrl',
														templateUrl : 'views/reports/grldRates/grldRatesAdd.jsp',
														resolve : {
															deps : [
																	'$ocLazyLoad',
																	function($ocLazyLoad) {
																		return $ocLazyLoad
																				.load([ 'js/app/reports/reports/grldRates/grldRatesEditCtrl.js' ]);
																	} ]

														}
													})
													
													
													//rajapriya
													  $stateProvider.state('app.reports.reportBulider', {
        abstract : true,
        templateUrl : "views/common",
        data : {
            title : 'General Report'
        }
    })
    

													  .state('app.reports.reportBulider.list', {
												            url : '/hospital/report/reportBulider',
												            data : {
												                title : 'General Ledger'
												            },
												           /* views : {
												                "content@app" : {
												                    controller : 'generalLedgerCtrl',
												                    templateUrl : 'views/hospital/report/generalLedger',

												                    resolve : {
												                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/report/generalLedger.js' ])
												                    }
												                }
												            }*/
												            
												            controller : 'generalLedgerCtrl',
															templateUrl : 'views/reports/finance/generalLedger',
															resolve : {
																deps : [
																		'$ocLazyLoad',
																		function($ocLazyLoad) {
																			return $ocLazyLoad
																					.load([ 'js/app/reports/finance/generalLedgerCtrl.js' ]);
																		} ]

															}
												        })  
				
		 //hema
		 $stateProvider.state('app.reports.receiptPayment', {
        abstract : true,
        templateUrl : "views/common",
        data : {
            title : 'Receipt & Payment'
        }
    })
    

													  .state('app.reports.receiptPayment.list', {
												            url : '/hospital/report/receiptPayment',
												            data : {
												                title : 'List'
												            },
												          
												            
												            controller : 'receiptPaymentCtrl',
															templateUrl : 'views/reports/finance/receiptPayment',
															resolve : {
																deps : [
																		'$ocLazyLoad',
																		function($ocLazyLoad) {
																			return $ocLazyLoad
																					.load([ 'js/app/reports/finance/receiptPaymentCtrl.js' ]);
																		} ]

															}
												        })  
    
.state('app.reports.dayBook', {
                url : '/hospital/report/dayBook',
                data : {
                    title : 'Day Book'
                },
              /*  views : {
                    "content@app" : {
                        controller : 'dayBookCtrl',
                        templateUrl : 'views/hospital/report/dayBook',

                        resolve : {
                            deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/report/dayBook.js' ])
                        }
                    }
                }*/
                
                controller : 'dayBookCtrl',
				templateUrl : 'views/reports/finance/dayBook',
				resolve : {
					deps : [
							'$ocLazyLoad',
							function($ocLazyLoad) {
								return $ocLazyLoad
										.load([ 'js/app/reports/finance/dayBook.js' ]);
							} ]

				}
        })
}
angular.module('neuboard').config(config).run(function($rootScope, $state) {
	$rootScope.$state = $state;
});
