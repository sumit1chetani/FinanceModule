function config($stateProvider, $urlRouterProvider, $locationProvider) {

	$stateProvider
			.state('company', {
				abstract : true,
				url : "/{tenantid}/company",
				templateUrl : "views/common",
				data : {
					pageTitle : 'Asset'
				}
			})
			.state(
					'company.show',
					{
						url : "/list",
						templateUrl : "views/company/companylist",
						data : {
							pageTitle : 'Company List'
						},
						controller : 'companyCtrl',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/company/company.js' ]);
									} ]
						}
					})
			.state('organization', {
				abstract : true,
				url : "/organization",
				templateUrl : "views/common",
				data : {
					pageTitle : ''
				}
			})
			.state(
					'organization.show',
					{
						url : "/list",
						templateUrl : "views/organizationlist",
						data : {
							pageTitle : 'Organization'
						},
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/organization/organization.js' ]);
									} ]
						}
					})
			.state('dashboard', {
				abstract : true,
				url : "/{tenantid}/dashboard",
				templateUrl : "views/common",
				data : {
					pageTitle : ''
				}
			})

			.state(
					'dashboard.list',
					{
						controller : 'dashboardCtrl',
						url : "/dashboard",
						templateUrl : "views/Dashboard",
						data : {
							pageTitle : 'DashBoard'
						},
						controller : 'dashboardCtrl',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/dashboard/dashboardCtrl.js' ]);
									} ]
						}
					})

			/*.state('containerType', {
				abstract : true,
				url : "/{tenantid}/containerType",
				templateUrl : "views/common",
				data : {
					pageTitle : ''
				}
			})
			.state(
					'containerType.list',
					{
						url : "/list",
						templateUrl : "views/containerType/containerTypeList",
						data : {
							pageTitle : ''
						},
						controller : 'containerTypeListCtrl',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/containerType/containerTypeCtrl.js' ]);
									} ]
						}
					})
			.state(
					'containerType.add',
					{
						controller : "containerTypeAddCtrl",
						url : "/containerType/add",
						templateUrl : "views/containerType/containerTypeAddEdit",
						data : {
							pageTitle : 'Add'
						},
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/containerType/containerTypeAddEdit.js' ]);
									} ]
						}
					})
					.state('containerType.edit',
					{
						controller : "containerTypeAddCtrl",
						url : "/edit",
						templateUrl : "views/containerType/containerTypeAddEdit",
						data : {
							pageTitle : 'Edit'
						},
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/containerType/containerTypeAddEdit.js' ]);
									} ]
						}
					})
					
					.state('containerType.view',
					{
						controller : "containerTypeAddCtrl",
						url : "/view",
						templateUrl : "views/containerType/ContainerTypeView",
						data : {
							pageTitle : 'Edit'
						},
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/containerType/containerTypeAddEdit.js' ]);
									} ]
						}
					})
					*/
					
					
						.state('master', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Master'
				}
			})
			
			.state('master.general', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'General'
				}
			})
					
					
			

			.state('route', {
				abstract : true,
				url : "/{tenantid}/route",
				templateUrl : "views/common",
				data : {
					pageTitle : ''
				}
			})
			.state(
					'route.list',
					{
						url : "/list",
						templateUrl : "views/route/manageroutelist",
						data : {
							pageTitle : ''
						},
						controller : 'manageRouteListCtrl',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/route/manageRouteListCtrl.js' ]);
									} ]
						}
					})
			.state(
					'route.add',
					{
						url : "/add",
						templateUrl : "views/route/managerouteadd",
						data : {
							pageTitle : ''
						},
						controller : 'manageRouteAddCtrl',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/route/manageRouteListCtrl.js' ]);
									} ]
						}
					})

			
			/*.state('app.operation', {

				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Operation'
				}
			})*/
			/*.state('app.operation.trip', {
				abstract : true,
				url : "/{tenantid}/trip",
				templateUrl : "views/common",
				data : {
					title : 'Plan Trip'
				}
			})
			.state(
					'app.operation.trip.list',
					{
						url : "/list",
						templateUrl : "views/trip/triplist",
						data : {
							title : 'List'
						},
						controller : 'tripListCtrl',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/trip/tripListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.operation.trip.add',
					{
						url : "/add",
						templateUrl : "views/trip/tripadd",
						data : {
							title : 'Add'
						},
						controller : 'tripAddCtrl',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/trip/tripListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.operation.trip.edit',
					{
						url : "/edit/:planTripId",
						data : {
							title : 'Edit'
						},
						controller : 'tripEditCtrl',
						templateUrl : 'views/trip/tripadd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/trip/tripListCtrl.js' ]);
									} ]
						}
					})*/

			.state('driver', {
				abstract : true,
				url : "/{tenantid}/driver",
				templateUrl : "views/common",
				data : {
					pageTitle : ''
				}
			})
			.state(
					'driver.list',
					{
						url : "/list",
						templateUrl : "views/master/driver/driverList",
						data : {
							pageTitle : ''
						},
						controller : 'driverListCtrl',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/driver/driverListCtrl.js' ]);
									} ]
						}
					})
			.state(
					'driver.add',
					{
						url : "/add",
						templateUrl : "views/master/driver/driverAdd",
						data : {
							pageTitle : ''
						},
						controller : 'driverAddCtrl',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/driver/driverAddCtrl.js' ]);
									} ]
						}
					})
			/*		.state('master.trucktrailer', {
		abstract : true,
		url : "/{tenantid}/trucktrailer",
		templateUrl : "views/common",
		data : {
			title : 'Truck Trailer Mapping'
		}
					
	}).state('master.trucktrailer.list', {
		url : "/list",
		templateUrl : "views/master/trucktrailer/trucktrailerList",
		data : {
			title : 'List'
		},
		controller : 'trucktrailerListCtrl',
        resolve : {
        		deps : [ '$ocLazyLoad', function($ocLazyLoad) {
                    return $ocLazyLoad.load([ 'js/app/master/trucktrailer/trucktrailerListCtrl.js' ]);
                }]
         }
	}).state('master.trucktrailer.add', {
		url : "/add",
		templateUrl : "views/master/trucktrailer/trucktrailerAdd",
		data : {
			title : 'Add'
		},
		controller : 'trucktrailerAddCtrl',
        resolve : {
        		deps : [ '$ocLazyLoad', function($ocLazyLoad) {
                    return $ocLazyLoad.load([ 'js/app/master/trucktrailer/trucktrailerAddCtrl.js' ]);
                }]
         }
	}).state('master.trucktrailer.edit', {
		url : "/edit",
		templateUrl : "views/master/trucktrailer/trucktrailerAdd",
		data : {
			title : 'Edit'
		},
		controller : 'trucktrailerAddCtrl',
        resolve : {
        		deps : [ '$ocLazyLoad', function($ocLazyLoad) {
                    return $ocLazyLoad.load([ 'js/app/master/trucktrailer/trucktrailerAddCtrl.js' ]);
                }]
         }
	}).state('master.trucktrailer.view', {
		url : "/view",
		templateUrl : "views/master/trucktrailer/trucktrailerView",
		data : {
			title : 'View'
		},
		controller : 'trucktrailerAddCtrl',
        resolve : {
        		deps : [ '$ocLazyLoad', function($ocLazyLoad) {
                    return $ocLazyLoad.load([ 'js/app/master/trucktrailer/trucktrailerAddCtrl.js' ]);
                }]
         }
	})*/
	.state('master.truckdriver', {
		abstract : true,
		url : "/{tenantid}/truckdriver",
		templateUrl : "views/common",
		data : {
			title : 'Truck Driver Mapping'
		}
	}).state('master.truckdriver.list', {
		url : "/list",
		templateUrl : "views/master/truckdriver/truckdriverList",
		data : {
			title : 'List'
		},
		controller : 'truckdriverListCtrl',
        resolve : {
        		deps : [ '$ocLazyLoad', function($ocLazyLoad) {
                    return $ocLazyLoad.load([ 'js/app/master/truckdriver/truckdriverListCtrl.js' ]);
                }]
         }
	}).state('master.truckdriver.add', {
		url : "/add",
		templateUrl : "views/master/truckdriver/truckdriverAdd",
		data : {
		title : 'Add'
		},
		controller : 'truckdriverAddCtrl',
        resolve : {
        		deps : [ '$ocLazyLoad', function($ocLazyLoad) {
                    return $ocLazyLoad.load([ 'js/app/master/truckdriver/truckdriverAddCtrl.js' ]);
                }]
         }
	}).state('master.truckdriver.edit', {
		url : "/edit",
		templateUrl : "views/master/truckdriver/truckdriverAdd",
		data : {
		title : 'Edit'
		},
		controller : 'truckdriverAddCtrl',
        resolve : {
        		deps : [ '$ocLazyLoad', function($ocLazyLoad) {
                    return $ocLazyLoad.load([ 'js/app/master/truckdriver/truckdriverAddCtrl.js' ]);
                }]
         }
	}).state('master.truckdriver.view', {
		url : "/view",
		templateUrl : "views/master/truckdriver/truckdriverView",
		data : {
		title : 'View'
		},
		controller : 'truckdriverAddCtrl',
        resolve : {
        		deps : [ '$ocLazyLoad', function($ocLazyLoad) {
                    return $ocLazyLoad.load([ 'js/app/master/truckdriver/truckdriverAddCtrl.js' ]);
                }]
         }
	})
	
.state('master.tyre', {
		abstract : true,
		url : "/{tenantid}/tyre",
		templateUrl : "views/common",
		data : {
		title : 'Tyre'
		}
	}).state('master.tyre.list', {
		url : "/list",
		templateUrl : "views/master/tyre/tyreList",
		data : {
			title : 'List'
		},
		controller : 'tyreListCtrl',
        resolve : {
        		deps : [ '$ocLazyLoad', function($ocLazyLoad) {
                    return $ocLazyLoad.load([ 'js/app/master/tyre/tyreListCtrl.js' ]);
                }]
         }
	}).state('master.tyre.add', {
		url : "/add",
		templateUrl : "views/master/tyre/tyreAdd",
		data : {
			title : 'Add'
		},
		controller : 'tyreAddCtrl',
        resolve : {
        		deps : [ '$ocLazyLoad', function($ocLazyLoad) {
                    return $ocLazyLoad.load([ 'js/app/master/tyre/tyreAddCtrl.js' ]);
                }]
         }
	}).state('master.tyre.edit', {
		url : "/edit",
		templateUrl : "views/master/tyre/tyreAdd",
		data : {
			title : 'Edit'
		},
		controller : 'tyreAddCtrl',
        resolve : {
        		deps : [ '$ocLazyLoad', function($ocLazyLoad) {
                    return $ocLazyLoad.load([ 'js/app/master/tyre/tyreAddCtrl.js' ]);
                }]
         }
	}).state('master.tyre.view', {
		url : "/view",
		templateUrl : "views/master/tyre/tyreView",
		data : {
			title : 'View'
		},
		controller : 'tyreAddCtrl',
        resolve : {
        		deps : [ '$ocLazyLoad', function($ocLazyLoad) {
                    return $ocLazyLoad.load([ 'js/app/master/tyre/tyreAddCtrl.js' ]);
                }]
         }
	})
	.state('master.freedays', {
		abstract : true,
		url : "/{tenantid}/freedays",
		templateUrl : "views/common",
		data : {
			title : 'Free Days Configuration'
		}
	}).state('master.freedays.list', {
		url : "/list",
		templateUrl : "views/master/freedays/freedaysList",
		data : {
			title : 'List'
		},
		controller : 'freedaysListCtrl',
        resolve : {
        		deps : [ '$ocLazyLoad', function($ocLazyLoad) {
                    return $ocLazyLoad.load([ 'js/app/master/freedays/freedaysListCtrl.js' ]);
                }]
         }
	}).state('master.freedays.add', {
		url : "/add",
		templateUrl : "views/master/freedays/freedaysAdd",
		data : {
			title : 'Add'
		},
		controller : 'freedaysAddCtrl',
        resolve : {
        		deps : [ '$ocLazyLoad', function($ocLazyLoad) {
                    return $ocLazyLoad.load([ 'js/app/master/freedays/freedaysAddCtrl.js' ]);
                }]
         }
	})	.state('master.freedays.edit', {
		url : "/edit",
		templateUrl : "views/master/freedays/freedaysAdd",
		data : {
			title : 'Edit'
		},
		controller : 'freedaysAddCtrl',
        resolve : {
        		deps : [ '$ocLazyLoad', function($ocLazyLoad) {
                    return $ocLazyLoad.load([ 'js/app/master/freedays/freedaysAddCtrl.js' ]);
                }]
         }
	})
	.state('master.freedays.view', {
		url : "/view",
		templateUrl : "views/master/freedays/freedaysView",
		data : {
			title : 'View'
		},
		controller : 'freedaysAddCtrl',
        resolve : {
        		deps : [ '$ocLazyLoad', function($ocLazyLoad) {
                    return $ocLazyLoad.load([ 'js/app/master/freedays/freedaysAddCtrl.js' ]);
                }]
         }
	})
			/*
			 * .state('truck', { abstract : true, url : "/{tenantid}/truck",
			 * templateUrl : "views/common", data : { pageTitle : '' }
			 * }).state('truck.list', { url : "/list", templateUrl :
			 * "views/master/truck/truckList", data : { pageTitle : '' },
			 * controller : 'truckListCtrl', resolve : { deps : [ '$ocLazyLoad',
			 * function($ocLazyLoad) { return $ocLazyLoad.load([
			 * 'js/app/master/truck/truckListCtrl.js' ]); }] }
			 * }).state('truck.add', { url : "/add", templateUrl :
			 * "views/master/truck/truckAdd", data : { pageTitle : '' },
			 * controller : 'truckAddCtrl', resolve : { deps : [ '$ocLazyLoad',
			 * function($ocLazyLoad) { return $ocLazyLoad.load([
			 * 'js/app/master/truck/truckAddCtrl.js' ]); }] }
			 */
			.state('master.customer', {
				abstract : true,
				url : "/{tenantid}/customer",
				templateUrl : "views/common",
				data : {
					title : 'Customer'
				}
			})
			.state(
					'master.customer.list',
					{
						url : "/list",
						templateUrl : "views/master/customer/customerList",
						data : {
							title : 'List'
						},
						controller : 'customerListCtrl',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/customer/customerListCtrl.js' ]);
									} ]
						}
					})
			.state(
					'master.customer.add',
					{
						url : "/add",
						templateUrl : "views/master/customer/customerAdd",
						data : {
							title : 'Add'
						},
						controller : 'customerAddCtrl',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/customer/customerAddCtrl.js' ]);
									} ]
						}
					})
					
					.state(
					'master.customer.edit',
					{
						url : "/edit",
						templateUrl : "views/master/customer/customerAdd",
						data : {
							title : 'Edit'
						},
						controller : 'customerAddCtrl',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/customer/customerAddCtrl.js' ]);
									} ]
						}
					})
					
			.state('user', {
				abstract : true,
				url : "/{tenantid}/route",
				templateUrl : "views/common",
				data : {
					pageTitle : ''
				}
			})
			.state(
					'user.list',
					{
						url : "/list",
						templateUrl : "views/user/userlist",
						data : {
							pageTitle : ''
						},
						controller : 'userListCtrl',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/user/userListCtrl.js' ]);
									} ]
						}
					})
			.state('movement', {
				abstract : true,
				url : "/{tenantid}/movement",
				templateUrl : "views/common",
				data : {
					pageTitle : ''
				}
			})
			.state(
					'movement.list',
					{
						url : "/list",
						templateUrl : "views/master/movement/movementList",
						data : {
							pageTitle : ''
						},
						controller : 'movementListCtrl',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/movement/movementListCtrl.js' ]);
									} ]
						}
					})

			// trailer

			.state('master.trailer', {
				abstract : true,
				url : "/{tenantid}/trailer",
				templateUrl : "views/common",
				data : {
					title : 'Trailer'
				}
			})
			.state(
					'master.trailer.list',
					{
						url : "/list",
						templateUrl : "views/master/trailer/trailerList",
						data : {
							title : 'List'
						},
						controller : 'trailerListCtrl',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/trailer/trailerListCtrl.js' ]);
									} ]
						}
					})
			.state(
					'master.trailer.add',
					{
						url : "/add",
						templateUrl : "views/master/trailer/trailerAdd",
						data : {
						title : 'Add'
						},
						controller : 'trailerAddCtrl',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/trailer/trailerAddCtrl.js' ]);
									} ]
						}
					})
					
					.state(
					'master.trailer.edit',
					{
						url : "/edit",
						templateUrl : "views/master/trailer/trailerAdd",
						data : {
						title : 'Edit'
						},
						controller : 'trailerAddCtrl',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/trailer/trailerAddCtrl.js' ]);
									} ]
						}
					})

		
				.state('master.trailer.view', {
					
		url : "/view",
		templateUrl : "views/master/trailer/trailerView",
		data : {
			title : 'View'
		},
		controller : 'trailerAddCtrl',
        resolve : {
        		deps : [ '$ocLazyLoad', function($ocLazyLoad) {
                    return $ocLazyLoad.load([ 'js/app/master/trailer/trailerAddCtrl.js' ]);
                }]
         }
	})	
	/*.state('master.trucktrailer.view', {
		url : "/view",
		templateUrl : "views/master/trucktrailer/trucktrailerView",
		data : {
			title : 'View'
		},
		controller : 'trucktrailerAddCtrl',
        resolve : {
        		deps : [ '$ocLazyLoad', function($ocLazyLoad) {
                    return $ocLazyLoad.load([ 'js/app/master/trucktrailer/trucktrailerAddCtrl.js' ]);
                }]
         }
	})

*/				
	
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
			.state('master.truck', {
				abstract : true,
				url : "/{tenantid}/truck",
				templateUrl : "views/common",
				data : {
					title : 'Truck'
				}
			})
			.state(
					'master.truck.list',
					{
						url : "/list",
						templateUrl : "views/master/truck/truckList",
						data : {
							title : 'List'
						},
						controller : 'truckListCtrl',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/truck/truckListCtrl.js' ]);
									} ]
						}
					})
			.state(
					'master.truck.add',
					{
						url : "/add",
						templateUrl : "views/master/truck/truckAdd",
						data : {
							title : 'Add'
						},
						controller : 'truckAddCtrl',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/truck/truckAddCtrl.js' ]);
									} ]
						}
					})

				.state('master.truck.edit', {
		url : "/edit",
		templateUrl : "views/master/truck/truckAdd",
		data : {
			title : 'Edit'
		},
		controller : 'truckAddCtrl',
        resolve : {
        		deps : [ '$ocLazyLoad', function($ocLazyLoad) {
                    return $ocLazyLoad.load([ 'js/app/master/truck/truckAddCtrl.js' ]);
                }]
         }
	})	
				.state('master.truck.view', {
					
		url : "/view",
		templateUrl : "views/master/truck/truckView",
		data : {
			title : 'View'
		},
		controller : 'truckAddCtrl',
        resolve : {
        		deps : [ '$ocLazyLoad', function($ocLazyLoad) {
                    return $ocLazyLoad.load([ 'js/app/master/truck/truckAddCtrl.js' ]);
                }]
         }
	})	
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
			.state('guidelinevalues', {
				abstract : true,
				url : "/{tenantid}/guidelinevalues",
				templateUrl : "views/common",
				data : {
					title : 'Guideline Values'
				}

			})
			.state(
					'app.master.guidelinevalues',
					{
						url : "/list",
						data : {
							title : 'Guideline Values List'
						},
						controller : 'guidelinevaluesListCtrl',
						templateUrl : 'views/master/guidelinevalues/guidelinevaluesList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/guidelinevalues/guidelinevaluesListCtrl.js' ]);
									} ]
						}
					})
			.state(
					'app.master.guidelinevaluesAdd',
					{
						url : "/guidelinevalues/add",
						data : {
							title : 'Guideline Values Add'
						},
						controller : 'guidelinevaluesAddCtrl',
						templateUrl : 'views/master/guidelinevalues/guidelinevaluesAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/guidelinevalues/guidelinevaluesAddCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.guidelinevaluesView',
					{
						url : "/guidelinevalues/view",
						templateUrl : "views/master/guidelinevalues/guidelinevaluesView",
						data : {
							title : 'View'
						},
						controller : 'guidelinevaluesAddCtrl',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/guidelinevalues/guidelinevaluesAddCtrl.js' ]);
									} ]
						}
					})

}
angular.module('neuboard').config(config).run(function($rootScope, $state) {
	$rootScope.$state = $state;
});
