
function config($stateProvider, $urlRouterProvider, $locationProvider) { 


    
    $stateProvider.state('app.operation', {
        abstract : true,
        templateUrl : "views/common",
        data : {
            title : 'Operation'
        }
    })
    .state('app.operation.voyage', {
		abstract : true,
		templateUrl : "views/common.jsp",
		data : {
			title : 'Third Party Voyage'
		}
	})
	   .state('app.operation.gateIn', {
		abstract : true,
		templateUrl : "views/common.jsp",
		data : {
			title : 'Gate In'
		}
	})
	 .state('app.operation.gateOut', {
		abstract : true,
		templateUrl : "views/common.jsp",
		data : {
			title : 'Gate Out'
		}
	})
	
	 .state('app.operation.transassign', {
		abstract : true,
		templateUrl : "views/common.jsp",
		data : {
			title : 'Transhipment Assign'
		}
	})
	
		 .state('app.operation.containerReleaseOrder', {
		abstract : true,
		templateUrl : "views/common.jsp",
		data : {
			title : 'Container Release Order'
		}
	})
	
	.state('app.operation.trip', {
		abstract : true,
		templateUrl : "views/common.jsp",
		data : {
			title : 'Manage Trip'
		}
	})
	
	//exceload
	
	.state('app.operation.tdrloadingsummary', {
									abstract : true,
									templateUrl : "views/common",
									data : {
										title : 'Loading Summary'
									}
								}) 
														
	
    
	//vessel
		.state('app.operation.vesselsailing', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'TDR'
				}
			})
    
   
  //excel
			
//discharge
			.state('app.operation.discharge', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Discharge'
				}
			})	
			
				// Arrival Notice
					.state('app.operation.arrivalNotice', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Arrival Notice'
				}
			})
				
					
					  .state('app.operation.voyage.list',{
							url : '/Operation/thirdPartyVoyage/list',
						data : {
							title : 'List'
						},

						controller : 'thirdPartyVoyageCtrl',
						templateUrl : 'views/operation/voyage/thirdPartyVoyage/thirdPartyVoyageList',
						
						
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/operation/voyage/thirdPartyVoyage/thirdPartyVoyageListCtrl.js' ]);
									} ]

						}

					})
					
					.state(
					'app.operation.voyage.thirdPartyVoyage-add',
					{
						url : '/operation/thirdPartyVoyage/add',
						data : {
							title : 'Add'
						},
						controller : 'thirdPartyVoyageAddCtrl',
						templateUrl : 'views/operation/voyage/thirdPartyVoyage/thirdPartyVoyageAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/operation/voyage/thirdPartyVoyage/thirdPartyVoyageAddCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.operation.voyage.thirdPartyVoyage-view',
					{
						url : '/operation/voyage/thirdPartyVoyage/view',
						data : {
							title : 'view'
						},
						controller : 'thirdPartyVoyageAddCtrl',
						templateUrl : 'views/operation/voyage/thirdPartyVoyage/thirdPartyVoyageView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/operation/voyage/thirdPartyVoyage/thirdPartyVoyageAddCtrl.js' ])
									} ]
						}

					})

					//Gate Out
					
					   	.state('app.operation.gateOut.list',
					{
						url : '/operation/gateOut/list',
						data : {
							title : 'List'
						},
						controller : 'gateOutCtrl',
						templateUrl : 'views/operation/gateOut/gateOutList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/operation/gateOut/gateOutListCtrl.js' ]);
									} ]
						}
					})
					
				   	.state(
							'app.operation.gateOut.add',
							{
								url : '/operation/gateOut/add',
								data : {
									title : 'Add'
								},
								controller : 'gateOutAddCtrl',
								templateUrl : 'views/operation/gateOut/gateOutAdd.jsp',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/operation/gateOut/gateOutAddCtrl.js' ]);
											} ]
								}
							})
							
							  	.state(
							'app.operation.gateOut.edit',
							{
								url : '/operation/gateOut/edit',
								data : {
									title : 'Edit'
								},
								controller : 'gateOutAddCtrl',
								templateUrl : 'views/operation/gateOut/gateOutAdd.jsp',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/operation/gateOut/gateOutAddCtrl.js' ]);
											} ]
								}
							})
							.state(
							'app.operation.gateOut.view',
							{
								url : '/operation/gateOut/view',
								data : {
									title : 'View'
								},
								controller : 'gateOutAddCtrl',
								templateUrl : 'views/operation/gateOut/gateOutView.jsp',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/operation/gateOut/gateOutAddCtrl.js' ]);
											} ]
								}
							})
							
							
	
	  	.state(
							'app.operation.gateOut.addByCro',
							{
								url : '/operation/gateOut/addByCro',
								data : {
									title : 'Add'
								},
								controller : 'gateOutAddCtrl',
								templateUrl : 'views/operation/gateOut/gateOutAdd.jsp',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/operation/gateOut/gateOutAddCtrl.js' ]);
											} ]
								}
							})
							
							
							
					// Transhipment assign
					
					   	.state('app.operation.transassign.list',
					{
						url : '/operation/transassign/list',
						data : {
							title : 'List'
						},
						controller : 'transassignListCtrl',
						templateUrl : 'views/operation/transassign/transassignList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/operation/transassign/transassignList.js' ]);
									} ]
						}
					})
					
					
					.state(
					'app.operation.transassign.tsAssignedList',
					{
						url : '/operation/transAssign/TSAssignedList',
						data : {
							title : 'List'
						},
						controller : 'tsAssignListCtrl',
						templateUrl : 'views/operation/transassign/tsAssignList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/operation/transassign/transassignList.js' ]);
									} ]
						}
					})
					
					
					.state(
					'app.operation.transassign.assignedList',
					{
						url : '/operation/transAssign/assignedListToRollOver',
						data : {
							title : 'Assign'
						},
						controller : 'transAssignedCtrl',
						templateUrl : 'views/operation/transassign/transAssignedList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/operation/transassign/transAssignCtrl.js' ]);
									} ]
						}
					})
					
							//dailyloadingentry
				/*	.state('app.operation.loadingentry', {
				abstract : true,
				url : "/{tenantid}/loadingentryscreen",
				templateUrl : "views/common",
				data : {
					title : 'Loading Entry Screen'
				}
			})*/ .state('app.operation.loadingentry', {
				abstract : true,
				templateUrl : "views/common.jsp",
				data : {
					title : 'Loading Entry Screen'
				}
			})
			.state(
					'app.operation.loadingentry.list',
					{
						url : "/operation/loadingentry/list",
						cache : false,
						templateUrl : "views/loadingentryscreen/loadingentryscreen",
						data : {
							title : 'List'
						},
						controller : 'loadingEntryCtrl',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/loadingEntry/loadingEntryCtrl.js' ], {cache:false});
									} ]
						}
					})
							
							
								// Gate In
					
            
                	.state(
					'app.operation.gateIn.list',
					{
						url : '/operation/gateIn/list',
						data : {
							title : 'List'
						},
						controller : 'gateInListCtrl',
						templateUrl : 'views/operation/gateIn/gateInList',  //jsp
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/operation/gateIn/gateInListCtrl.js' ]); //js
									} ]
						}
					})
					
					.state(
					'app.operation.gateIn.add',
					{
						url : '/operation/gateIn/add',
						data : {
							title : 'Add'
						},
						controller : 'gateInAddCtrl',
						templateUrl : 'views/operation/gateIn/gateInAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/operation/gateIn/gateInAddCtrl.js' ]);
									} ]
						}
					})
					
					.state(
					'app.operation.gateIn.edit',
					{
						url : '/operation/gateIn/edit',
						data : {
							title : 'Edit'
						},
						controller : 'gateInAddCtrl',
						templateUrl : 'views/operation/gateIn/gateInAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/operation/gateIn/gateInAddCtrl.js' ]);
									} ]
						}
					})
					.state(
					'app.operation.gateIn.view',
					{
						url : '/operation/gateIn/view',
						data : {
							title : 'View'
						},
						controller : 'gateInAddCtrl',
						templateUrl : 'views/operation/gateIn/gateInView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/operation/gateIn/gateInAddCtrl.js' ]);
									} ]
						}
					})
					
			
					
					//discharge
					.state(
					'app.operation.discharge.list',
					{
						url : '/operation/discharge/list',
						data : {
							title : 'List'
						},
						controller : 'dischargeListCtrl',
						templateUrl : 'views/operation/discharge/dischargeList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/operation/discharge/dischargeListCtrl.js' ]);
									} ]
						}
					})

					
			.state(
					'app.operation.discharge.add',
					{
						url : '/operation/discharge/add',
						data : {
							title : 'Add'
						},
						controller : 'dischargeAddCtrl',
						templateUrl : 'views/operation/discharge/dischargeAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/operation/discharge/dischargeAddCtrl.js' ]);
									} ]
						}
					})
					
					
					.state(
					'app.operation.discharge.edit',
					{
						url : '/operation/discharge/edit',
						data : {
							title : 'Edit'
						},
						controller : 'dischargeAddCtrl',
						templateUrl : 'views/operation/discharge/dischargeAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/operation/discharge/dischargeAddCtrl.js' ]);
									} ]
						}
					})
					
					.state(
					'app.operation.discharge.view',
					{
						url : '/operation/discharge/view',
						data : {
							title : 'View'
						},
						controller : 'dischargeAddCtrl',
						templateUrl : 'views/operation/discharge/dischargeView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/operation/discharge/dischargeAddCtrl.js' ]);
									} ]
						}
					})

					
					
					
            	//Container Release Order
			
			.state(
				'app.operation.containerReleaseOrder.list',
				{
					url : '/master/inventory/containerReleaseOrder',
					data : {
						title : 'List'
					},
					controller : 'containerListCtrl',
					templateUrl : 'views/operation/containerReleaseOrder/containerReleaseOrderList',
					resolve : {
						deps : [
								'$ocLazyLoad',
								function($ocLazyLoad) {
									return $ocLazyLoad
											.load([ 'js/app/operation/containerReleaseOrder/containerReleaseOrderListCtrl.js' ]);
								} ]
					}
				})
				
				
				.state(
				'app.operation.containerReleaseOrder.add',
				{
					url : '/master/inventory/containerReleaseOrder/Add',
					data : {
						title : 'Add'
					},
					controller : 'containerAddCtrl',
					templateUrl : 'views/operation/containerReleaseOrder/containerReleaseOrderAdd',
					resolve : {
						deps : [
								'$ocLazyLoad',
								function($ocLazyLoad) {
									return $ocLazyLoad
											.load([ 'js/app/operation/containerReleaseOrder/containerReleaseOrderAddCtrl.js' ]);
								} ]
					}
				})
				
				 .state(
				'app.operation.containerReleaseOrder.edit',
				{
					url : '/master/inventory/containerReleaseOrder/edit',
					data : {
						title : 'Edit'
					},
					controller : 'containerAddCtrl',
					templateUrl : 'views/operation/containerReleaseOrder/containerReleaseOrderAdd',
					resolve : {
						deps : [
								'$ocLazyLoad',
								function($ocLazyLoad) {
									return $ocLazyLoad
											.load([ 'js/app/operation/containerReleaseOrder/containerReleaseOrderAddCtrl.js' ]);
								} ]
					}
				})
				
				
				//Manage Trip  
			
			.state(
				'app.operation.trip.list',
				{
					url : '/operation/trip/list',
					data : {
						title : 'List'
					},
					controller : 'tripListCtrl',
					templateUrl : 'views/operation/trip/triplist',
					resolve : {
						deps : [
								'$ocLazyLoad',
								function($ocLazyLoad) {
									return $ocLazyLoad
											.load([ 'js/app/operation/trip/tripListCtrl.js' ]);
								} ]
					}
				})
				
					.state(
				'app.operation.trip.add',
				{
					url : '/operation/trip/Add',
					data : {
						title : 'Add'
					},
					controller : 'tripAddCtrl',
					templateUrl : 'views/operation/trip/tripadd',
					resolve : {
						deps : [
								'$ocLazyLoad',
								function($ocLazyLoad) {
									return $ocLazyLoad
											.load([ 'js/app/operation/trip/tripListCtrl.js' ]);
								} ]
					}
				})
				
					.state(
					'app.operation.trip.edit',
					{
						url : "/edit/:planTripId",
						cache : false,
						data : {
							title : 'Edit'
						},
						controller : 'tripEditCtrl',
						templateUrl : 'views/operation/trip/tripadd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/operation/trip/tripListCtrl.js' ] ,{cache:false});
									} ]
						}
					})
					
					.state(
					'app.operation.trip.view',
					{
						url : "/view/:planTripId",
						cache : false,
						data : {
							title : 'View'
						},
						controller : 'tripEditCtrl',
						templateUrl : 'views/trip/tripView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load(['js/app/operation/trip/tripListCtrl.js' ], {cache:false});
									} ]
						}
					})
				//vessel OnBoard
				//ContainerOnHire 
			.state('app.operation.OnBoard', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'OnBoard'
				}
			})
			
			
			.state('app.operation.OnBoard.list',
			{
				url : '/operation/OnBoard/list',
				data : {
					title : 'List'
				},
				controller : 'onBoardListCtrl',
				templateUrl : 'views/operation/onBoard/onBoardList',
				resolve : {
					deps : [
							'$ocLazyLoad',
							function($ocLazyLoad) {
								return $ocLazyLoad
										.load([ 'js/app/operation/onBoard/onBoardListCtrl.js' ]);
							} ]
				}
			})

			
			.state(
			'app.operation.OnBoard.add',
			{
				url : '/operation/OnBoard/add',
				data : {
					title : 'Add'
				},
				controller : 'onBoardAddCtrl',
				templateUrl : 'views/operation/onBoard/onBoardAdd',
				resolve : {
					deps : [
							'$ocLazyLoad',
							function($ocLazyLoad) {
								return $ocLazyLoad
										.load([ 'js/app/operation/onBoard/onBoardAddCtrl.js' ])
							} ]
				}

			})
			
			.state('app.operation.OnBoard.view', {
				url : '/onBoard/view/:onBoardNo',
				data : {
				title : 'View'
				},
                controller : 'onBoardViewCtrl',
                templateUrl : 'views/operation/onBoard/onBoardView',
                resolve : {
                	deps : [ '$ocLazyLoad', function($ocLazyLoad) {
                return $ocLazyLoad.load([ 'js/app/operation/onBoard/onBoardAddCtrl.js' ]) 
            } ]
        }
    })
    
		 //vessel arrival
			.state('app.operation.vesselarrival', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Vessel Arrival'
				}
			})
			//vessel arrival
			
			
			.state(
						'app.operation.vesselarrival.list',
						{
							url : '/operation/vesselarrival/list',
							data : {
								title : 'List'
							},
							controller : 'vesselArrivalListCtrl',
							templateUrl : 'views/operation/vesselarrival/vesselArrivalList',
							resolve : {
								deps : [
										'$ocLazyLoad',
										function($ocLazyLoad) {
											return $ocLazyLoad
													.load([ 'js/app/operation/vesselArrival/vesselArrivalListCtrl.js' ]);
										} ]
							}
						})

						
						
				.state(
						'app.operation.vesselarrival.add',
						{
							url : '/operation/vesselarrival/add',
							data : {
								title : 'Add'
							},
							controller : 'vesselArrivalAddCtrl',
							templateUrl : 'views/operation/vesselarrival/vesselArrivalAdd',
							resolve : {
								deps : [
										'$ocLazyLoad',
										function($ocLazyLoad) {
											return $ocLazyLoad
													.load([ 'js/app/operation/vesselArrival/vesselArrivalAddCtrl.js' ]);
										} ]
							}
						})
						
						
						.state(
						'app.operation.vesselarrival.view',
						{
							url : '/operation/vesselarrival/view',
							data : {
								title : 'View'
							},
							controller : 'vesselArrivalviewCtrl',
							templateUrl : 'views/operation/vesselarrival/vesselArrivalView',
							resolve : {
								deps : [
										'$ocLazyLoad',
										function($ocLazyLoad) {
											return $ocLazyLoad
													.load([ 'js/app/operation/vesselArrival/vesselArrivalAddCtrl.js' ]);
										} ]
							}
						})
						
						
						
					.state(
						'app.operation.vesselarrival.edit',
						{
							url : '/operation/vesselarrival/edit',
							data : {
								title : 'Edit'
							},
							controller : 'vesselArrivalAddCtrl',
							templateUrl : 'views/operation/vesselarrival/vesselArrivalAdd',
							resolve : {
								deps : [
										'$ocLazyLoad',
										function($ocLazyLoad) {
											return $ocLazyLoad
													.load([ 'js/app/operation/vesselArrival/vesselArrivalAddCtrl.js' ]);
										} ]
							}
						})
						
						 //Tdr
						.state(
								'app.operation.vesselsailing.list',
								{
									url : '/operation/vesselsailing/list',
									data : {
										title : 'List'
									},
									controller : 'vesselSailingCtrl',
									templateUrl : 'views/operation/vesselsailing/vesselsailingList',
									resolve : {
										deps : [
												'$ocLazyLoad',
												function($ocLazyLoad) {
													return $ocLazyLoad
															.load([ 'js/app/operation/vesselsailing/vesselsailingCtrl.js' ]);
												} ]
									}
								})

								
								
						.state(
								'app.operation.vesselsailing.add',
								{
									url : '/operation/vesselsailing/add',
									data : {
										title : 'Add'
									},
									controller : 'vesselSailingAddCtrl',
									templateUrl : 'views/operation/vesselsailing/vesselsailingAdd',
									resolve : {
										deps : [
												'$ocLazyLoad',
												function($ocLazyLoad) {
													return $ocLazyLoad
															.load([ 'js/app/operation/vesselsailing/vesselsailingAddCtrl.js' ]);
												} ]
									}
								})
								
								
								.state(
								'app.operation.vesselsailing.edit',
								{
									url : "/operation/vesselsailing/edit",
									data : {
										title : 'Edit'
									},
									controller : 'vesselSailingAddCtrl',
									templateUrl : 'views/operation/vesselsailing/vesselsailingAdd',
									resolve : {
										deps : [
												'$ocLazyLoad',
												function($ocLazyLoad) {
													return $ocLazyLoad
															.load([ 'js/app/operation/vesselsailing/vesselsailingAddCtrl.js' ]);
												} ]
									}
								})
								
								.state(
								'app.operation.vesselsailing.view',
								{
									url : "/operation/vesselsailing/view",
									data : {
										title : 'Edit'
									},
									controller : 'vesselSailingAddCtrl',
									templateUrl : 'views/operation/vesselsailing/vesselsailingView',
									resolve : {
										deps : [
												'$ocLazyLoad',
												function($ocLazyLoad) {
													return $ocLazyLoad
															.load([ 'js/app/operation/vesselsailing/vesselsailingAddCtrl.js' ]);
												} ]
									}
								})
								
//excel
								
									.state( 'app.operation.tdrloadingsummary.list',

								{
									url : '/operation/loadingsummary',
									data : {
										title : 'List'
									},
									controller : 'loadingsummaryCtrl',
									templateUrl : '/views/operation/loadingsummary/loadingsummaryList',
									resolve : {
										deps : [
												'$ocLazyLoad',
												function($ocLazyLoad) {
													return $ocLazyLoad
															.load([ 'js/app/operation/loadingsummary/loadingsummaryCtrl.js' ]);
												} ]
									}
								})
								
								
				
			.state(
					'app.operation.arrivalNotice.list',
					{
						url : '/operation/arrivalNotice/list',
						data : {
							title : 'Report'
						},
						controller : 'arrivalNoticeListCtrl',
						templateUrl : 'views/operation/arrivalNotice/arrivalNoticeList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/operation/arrivalNotice/arrivalNoticeListCtrl.js' ]);
									} ]
						}
					})

						
			//ROLL OVER
			.state('app.operation.rollOver', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'ROLL OVER'
				}
			})		
								
					//ROLL OVER 
					.state(
					'app.operation.rollOver.list',
					{
						url : '/operation/rollOver/list',
						data : {
							title : 'List'
						},
						controller : 'rollOverListCtrl',
						templateUrl : 'views/operation/rollOver/rollOverList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/operation/rollOver/rollOverListCtrl.js' ]);
									} ]              
						}
					})
					
					
		//Empty Repositioning
			
			
			.state('app.operation.emptyRepositioning', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Empty Repositioning'
				}
			})
			
				   //empty repositioning 
            
            	.state(
					'app.operation.emptyRepositioning.list',
					{
						url : '/operation/emptyRepositioning/list',
						data : {
							title : 'List'
						},
						controller : 'emptyRepositioningCtrl',
						templateUrl : 'views/operation/emptyRepositioning/emptyRepostioningList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/operation/emptyRepositioning/emptyRepostioningListCtrl.js' ]);
									} ]
						}
					})
					
					.state(
					'app.operation.emptyRepositioning.add',
					{
						url : '/operation/emptyRepositioning/add',
						data : {
							title : 'Add'
						},
						controller : 'emptyRepositioningAddCtrl',
						templateUrl : 'views/operation/emptyRepositioning/emptyRepostioningAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/operation/emptyRepositioning/emptyRepostioningAddCtrl.js' ]);
									} ]
						}
					})
					
					.state(
					'app.operation.emptyRepositioning.edit',
					{
						url : '/operation/emptyRepositioning/edit',
						data : {
							title : 'Edit'
						},
						controller : 'emptyRepositioningAddCtrl',
						templateUrl : 'views/operation/emptyRepositioning/emptyRepostioningAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/operation/emptyRepositioning/emptyRepostioningAddCtrl.js' ]);
									} ]
						}
					})
					
					.state(
			'app.operation.emptyRepositioning.view',
			{
				url : '/operation/emptyRepositioning/view',
				data : {
					title : 'View'
				},
				controller : 'emptyRepositioningAddCtrl',
				templateUrl : '/views/operation/emptyRepositioning/emptyRepostioningView',
				resolve : {
					deps : [
							'$ocLazyLoad',
							function($ocLazyLoad) {
								return $ocLazyLoad
										.load([ 'js/app/operation/emptyRepositioning/emptyRepostioningAddCtrl.js' ]);
							} ]
				}
			})								
			
								
								
								
								 

}
angular.module('neuboard').config(config).run(function($rootScope, $state) {
	$rootScope.$state = $state;
});


