function config($stateProvider, $urlRouterProvider, $locationProvider) {
	// define

	$stateProvider.state('app.master', {
		abstract : true,
		templateUrl : "views/common",
		data : {
			title : 'Master'
		}
	})
	
	// employee
			.state('app.master.user', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'User Master'
				}
			})
	
	$stateProvider.state('app.eqc', {
		abstract : true,
		templateUrl : "views/common",
		data : {
			title : 'EQC'
		}
	})
	/*$stateProvider
			.state('app.documentation', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Documentation'
				}
			})*/
	
	
		$stateProvider.state('app.eqc.containerBank', {
		abstract : true,
		templateUrl : "views/common",
		data : {
			title : 'Container Bank'
		}
	})
	
	
	.state('app.master.general', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'General'
				}
			})
			
			//MRG
				.state('app.master.mrg', {
				abstract : true,
				templateUrl : "views/common.jsp",
				data : {
					title : 'MRG'
				}
			})
			
	// EIR
	.state('app.eqs.eir', {
		abstract : true,
		templateUrl : "views/common",
		data : {
			title : 'EIR'
		}
	})
	// stuffing Type //
	.state('app.master.stuffing', {
		abstract : true,
		templateUrl : "views/common.jsp",
		data : {
			title : 'Stuffing Type'
		}
	})
		/*$stateProvider
			.state('app.hr', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'HR'
				}
			})*/
	// area
	.state('app.master.area', {
		abstract : true,
		templateUrl : "views/common.jsp",
		data : {
			title : 'Area'
		}
	})
	// local Charges
	.state('app.master.localcharges', {
		abstract : true,
		templateUrl : "views/common.jsp",
		data : {
			title : 'Local Charges'
		}
	})

	// local Charges Cost
	.state('app.master.localchargescost', {
		abstract : true,
		templateUrl : "views/common.jsp",
		data : {
			title : 'Local Charges Cost'
		}
	})
	// ICD Charges
	.state('app.master.icdcharge', {
		abstract : true,
		templateUrl : "views/common.jsp",
		data : {
			title : 'ICD Charges'
		}
	})
	/*// leaseagreementtype
	.state('app.eqs.leaseagreementtype', {
		abstract : true,
		templateUrl : "views/common",
		data : {
			title : 'Lease Agreement Type'
		}
	})
*/


	// port
	.state('app.master.port', {
		abstract : true,
		templateUrl : "views/common.jsp",
		data : {
			title : 'Port'
		}
	})
	// Terminal
	.state('app.master.terminal', {
		abstract : true,
		templateUrl : "views/common.jsp",
		data : {
			title : 'Terminal'
		}
	})
	// city
	.state('app.master.city', {
		abstract : true,
		templateUrl : "views/common.jsp",
		data : {
			title : 'City'
		}
	})

	// city
	.state('app.master.inventory', {
		abstract : true,
		templateUrl : "views/common.jsp",
		data : {
			title : ''
		}
	})

	// container size type

	.state('app.master.containersize', {
		abstract : true,
		templateUrl : "views/common.jsp",
		data : {
			title : 'Container Type'
		}
	})

	// bl ladding
	.state('app.master.bladding', {
		abstract : true,
		templateUrl : "views/common.jsp",
		data : {
			title : 'Bill of Ladding'
		}
	})
	// Vessel Master - Kishore //
	.state('app.master.vesselmaster', {
		abstract : true,
		templateUrl : "views/common.jsp",
		data : {
			title : 'Vessel Master'
		}
	})

	// Commodity Description
	.state('app.master.commodity', {
		abstract : true,
		templateUrl : "views/common.jsp",
		data : {
			title : 'Commodity'
		}
	})

	// Commodity Classification
	.state('app.master.commodityclassification', {
		abstract : true,
		templateUrl : "views/common.jsp",
		data : {
			title : 'Commodity Classification'
		}
	})

	// Pack Type
	.state('app.master.packtype', {
		abstract : true,
		templateUrl : "views/common.jsp",
		data : {
			title : 'Pack Type'
		}
	})

	
	
	
			//Voyage -  //
				.state('app.master.voyage', {
				abstract : true,
				templateUrl : "views/common.jsp",
				data : {
					title : 'Voyage'
				}
            })
	.state('app.eqs', {
		abstract : true,
		templateUrl : "views/common",
		data : {
			title : 'EQC'
		}
	})

	.state('app.eqs.damage', {
		abstract : true,
		templateUrl : "views/common.jsp",
		data : {
			title : 'Damage'
		}
	}).state('app.eqs.mnrTarrif', {
		abstract : true,
		templateUrl : "views/common.jsp",
		data : {
			title : 'MNR Tarrif'
		}
	})

	.state('app.eqs.repair', {
		abstract : true,
		templateUrl : "views/common.jsp",
		data : {
			title : 'Repair'
		}
	})

	// Storage Charges
	.state('app.master.storagecharges', {
		abstract : true,
		templateUrl : "views/common.jsp",
		data : {
			title : 'Storage Charges'
		}
	})

	.state('app.eqs.parts', {
		abstract : true,
		templateUrl : "views/common.jsp",
		data : {
			title : 'Parts'
		}
	})

	.state('app.eqs.description', {
		abstract : true,
		templateUrl : "views/common.jsp",
		data : {
			title : 'Description'
		}
	})

	.state('app.eqs.material', {
		abstract : true,
		templateUrl : "views/common.jsp",
		data : {
			title : 'Material'
		}
	})

	.state('app.eqs.containerstatussequence', {
		abstract : true,
		templateUrl : "views/common",
		data : {
			title : 'Container Sequence'
		}
	})

	.state('app.eqs.containerStatus', {
		abstract : true,
		templateUrl : "views/common.jsp",
		data : {
			title : 'Container Status'
		}
	})

	.state('app.eqs.containerMovement', {
		abstract : true,
		templateUrl : "views/common.jsp",
		data : {
			title : 'Container Movement'
		}
	})

	// / Repair estimate

	.state('app.eqs.repairEstimate', {
		abstract : true,
		templateUrl : "views/common.jsp",
		data : {
			title : 'Repair Estimate'
		}
	})

	// container movement upload

	.state('app.eqs.containerMovementupload', {
		abstract : true,
		templateUrl : "views/common.jsp",
		data : {
			title : 'Container Movement'
		}
	})
	

	.state('app.eqs.containerOffHire', {
		abstract : true,
		templateUrl : "views/common",
		data : {
			title : 'Container Off Hire'
		}
	})

	/*
	 * .state('app.eqs.onHireRelease', {
		abstract : true,
		templateUrl : "views/common",
		data : {
			title : 'Container OnHire Release'
		}
	})
	.state('app.eqs.containerLeaseAgreement', {
		abstract : true,
		templateUrl : "views/common",
		data : {
			title : 'Container Lease Agreement'
		}
	})*/

	// Documentation Charges
	.state('app.master.documentationCharges', {
		abstract : true,
		templateUrl : "views/common.jsp",
		data : {
			title : 'Documentation Charges'
		}
	})

	// Carogo Category
	.state('app.master.cargo', {
		abstract : true,
		templateUrl : "views/common.jsp",
		data : {
			title : 'Cargo Category'
		}
	})

	$stateProvider
			.state('app.reportcontainerstatus', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Reports'
				}
			})

			// Customer
			.state('app.master.customer', {
				abstract : true,
				templateUrl : "views/common.jsp",
				data : {
					title : 'Customer'
				}
			})

			// customer
			.state(
					'app.master.customer.list',
					{
						url : '/customer/List',
						data : {
							title : 'List'
						},
						controller : 'customerListCtrl',
						templateUrl : 'views/master/customer/customerList',
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
					'app.master.customer.add',
					{
						url : '/customer/Add',
						data : {
							title : 'Add'
						},
						controller : 'customerAddCtrl',
						templateUrl : 'views/master/customer/customerAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/customer/customerAddCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.master.customer.edit',
					{
						url : '/customer/Edit',
						data : {
							title : 'Edit'
						},
						controller : 'customerAddCtrl',
						templateUrl : 'views/master/customer/customerAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/customer/customerAddCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.master.customer.view',
					{
						url : '/customer/View',
						data : {
							title : 'View'
						},
						controller : 'customerAddCtrl',
						templateUrl : 'views/master/customer/customerView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/customer/customerAddCtrl.js' ])
									} ]
						}

					})
					
					
					
					// Agent Customer Mapping
			.state('app.master.agentMapping', {
				abstract : true,
				templateUrl : "views/common.jsp",
				data : {
					title : 'Agent Mapping'
				}
			})

			// Agent Customer Mapping
			.state(
					'app.master.agentMapping.list',
					{
						url : '/agentMapping/List',
						data : {
							title : 'List'
						},
						controller : 'agentMappingListCtrl',
						templateUrl : 'views/master/agentMapping/agentMappingList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/agentMapping/agentMappingListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.agentMapping.add',
					{
						url : '/agentMapping/Add',
						data : {
							title : 'Add'
						},
						controller : 'agentMappingAddCtrl',
						templateUrl : 'views/master/agentMapping/agentMappingAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/agentMapping/agentMappingAddCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.master.agentMapping.edit',
					{
						url : '/agentMapping/Edit',
						data : {
							title : 'Edit'
						},
						controller : 'agentMappingAddCtrl',
						templateUrl : 'views/master/agentMapping/agentMappingAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/agentMapping/agentMappingAddCtrl.js' ])
									} ]
						}

					})

			// container flow report
			.state('app.master.containerFlowReport', {
				abstract : true,
				templateUrl : "views/common.jsp",
				data : {
					title : 'Container Flow Report'
				}
			})

			// container flow report
			.state(
					'app.master.containerFlowReport.list',
					{
						url : '/containerFlowReport/List',
						data : {
							title : 'Report'
						},
						controller : 'containerFlowReportListCtrl',
						templateUrl : 'views/master/containerFlowReport/containerFlowReportList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/containerFlowReport/containerFlowReportListCtrl.js' ]);
									} ]
						}
					})
			// Dock/Berth
			.state('app.master.dock', {
				abstract : true,
				templateUrl : "views/common.jsp",
				data : {
					title : 'Dock/Berth'
				}
			})

			// EIR(Equipment Inspection Report)
			.state(
					'app.eqs.eir.list',
					{
						url : '/eqs/eir/list',
						data : {
							title : 'List'
						},
						controller : 'eirListCtrl',
						templateUrl : '/views/eqs/eir/eirList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/eir/eirListCtrl.js' ]);
									} ]
						}
					})
			.state(
					'app.eqs.eir.add',
					{
						url : '/eqs/eir/add',
						data : {
							title : 'Add'
						},
						controller : 'eirAddCtrl',
						templateUrl : '/views/eqs/eir/eirAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/eir/eirAddCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.eqs.eir.edit',
					{
						url : '/eqs/eir/edit',
						data : {
							title : 'Edit'
						},

						controller : 'eirAddCtrl',
						templateUrl : '/views/eqs/eir/eirAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/eir/eirAddCtrl.js' ]);
									} ]

						}
					})
			// stuffing type List
			.state(
					'app.master.stuffing.list',
					{
						url : '/stuffingtype/list',
						data : {
							title : 'List'
						},
						controller : 'stuffingListCtrl',
						templateUrl : 'views/master/stuffing/stuffingList',

						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/stuffing/stuffingListCtrl.js' ]);
									} ]
						}
					})

			// documenattion charges
			.state(
					'app.master.documentationCharges.list',
					{
						url : '/master/documentationCharges/list',
						data : {
							title : ' List'
						},
						controller : 'documentationChargesListCtrl',
						templateUrl : 'views/master/documentationCharges/documentationChargesList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/documentationCharges/documentationChargesListCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.master.documentationCharges.add',
					{
						url : '/master/documentationCharges/add',
						data : {
							title : ' Add'
						},
						controller : 'documentationChargesAddCtrl',
						templateUrl : 'views/master/documentationCharges/documentationChargesAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/documentationCharges/documentationChargesAddCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.master.documentationCharges.edit',
					{
						url : '/master/documentationCharges/edit',
						data : {
							title : ' Edit'
						},
						controller : 'documentationChargesAddCtrl',
						templateUrl : 'views/master/documentationCharges/documentationChargesAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/documentationCharges/documentationChargesAddCtrl.js' ])
									} ]
						}

					})

			// stuffing type Add
			.state(
					'app.master.stuffing.add',
					{
						url : '/stuffingtype/add',
						data : {
							title : 'Add'
						},
						controller : 'stuffingAddCtrl',
						templateUrl : 'views/master/stuffing/stuffingAdd',

						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/stuffing/stuffingAddCtrl.js' ]);
									} ]
						}
					})
			// stuffing type Edit
			.state(
					'app.master.stuffing.edit',
					{
						url : '/stuffingtype/edit',
						data : {
							title : 'Edit'
						},
						controller : 'stuffingAddCtrl',
						templateUrl : 'views/master/stuffing/stuffingAdd',

						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/stuffing/stuffingAddCtrl.js' ]);
									} ]
						}
					})
			// Report
			.state(
					'app.reportcontainerstatus.list',
					{
						url : '/containerstatus/list',
						data : {
							title : 'Container Status'
						},
						controller : 'containerstatusList',
						templateUrl : 'views/reports/containerstatus/reportcontainerstatusList',

						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/reports/containerstatus/reportcontainerstatusList.js' ]);
									} ]
						}
					})

			// Damage
			.state(
					'app.eqs.damage.damagelist',
					{
						url : '/damagelist',
						data : {
							title : 'List'
						},
						controller : 'damageListCtrl',
						templateUrl : 'views/eqs/damage/damageList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/damage/damageCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.eqs.damage.damageadd',
					{
						url : '/damageadd',
						data : {
							title : 'Add'
						},
						controller : 'damageAddCtrl',
						templateUrl : 'views/eqs/damage/damageAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/damage/damageCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.eqs.damage.damageedit',
					{
						url : '/damage/damageedit',
						data : {
							title : 'Edit'
						},

						controller : 'damageAddCtrl',
						templateUrl : 'views/eqs/damage/damageAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/damage/damageCtrl.js' ]);
									} ]

						}
					})

			.state(
					'app.eqs.damage.damageview',
					{
						url : '/damage/damageView',
						data : {
							title : 'View'
						},
						controller : 'damageViewCtrl',
						templateUrl : 'views/eqs/damageView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/damage/damageCtrl.js' ])
									} ]
						}

					})

			// Repair
			.state(
					'app.eqs.repair.repairlist',
					{
						url : '/repairlist',
						data : {
							title : 'List'
						},
						controller : 'repairListCtrl',
						templateUrl : 'views/eqs/repair/repairList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/repair/repairCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.eqs.repair.repairadd',
					{
						url : '/repairadd',
						data : {
							title : 'Add'
						},
						controller : 'repairAddCtrl',
						templateUrl : 'views/eqs/repair/repairAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/repair/repairCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.eqs.repair.repairedit',
					{
						url : '/repair/repairedit',
						data : {
							title : 'Edit'
						},

						controller : 'repairAddCtrl',
						templateUrl : 'views/eqs/repair/repairAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/repair/repairCtrl.js' ]);
									} ]

						}
					})

			.state('app.eqs.repair.repairview', {
				url : '/repair/repairView',
				data : {
					title : 'View'
				},
				controller : 'repairViewCtrl',
				templateUrl : 'views/eqs/repairView',
				resolve : {
					deps : [ '$ocLazyLoad', function($ocLazyLoad) {
						return $ocLazyLoad.load([ 'js/app/eqs/repairCtrl.js' ])
					} ]
				}

			})

			// containerSequence
			.state(
					'app.eqs.containerstatussequence.containerstatussequencelist',
					{
						url : '/containerstatussequencelist',
						data : {
							title : 'List'
						},
						controller : 'containerstatussequenceListCtrl',
						templateUrl : 'views/eqs/containerstatussequence/containerstatussequenceList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/containerstatussequence/containerstatussequenceListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.eqs.containerstatussequence.containerstatussequenceadd',
					{
						url : '/containerstatussequenceadd',
						data : {
							title : 'Add'
						},
						controller : 'containerstatussequenceAddCtrl',
						templateUrl : 'views/eqs/containerstatussequence/containerstatussequenceAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/containerstatussequence/containerstatussequenceAddCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.eqs.containerstatussequence.containerstatussequenceedit',
					{
						url : '/containerstatussequence/containerstatussequenceedit',
						data : {
							title : 'Edit'
						},

						controller : 'containerstatussequenceAddCtrl',
						templateUrl : 'views/eqs/containerstatussequence/containerstatussequenceAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/containerstatussequence/containerstatussequenceAddCtrl.js' ]);
									} ]

						}
					})

			.state(
					'app.eqs.containerstatussequence.containerstatussequenceview',
					{
						url : '/containerstatussequence/containerstatussequenceView',
						data : {
							title : 'View'
						},
						controller : 'containerstatussequenceViewCtrl',
						templateUrl : 'views/eqs/containerstatussequenceView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/containerstatussequenceCtrl.js' ])
									} ]
						}

					})

			// Material
			.state(
					'app.eqs.material.materiallist',
					{
						url : '/materiallist',
						data : {
							title : 'List'
						},
						controller : 'materialListCtrl',
						templateUrl : 'views/eqs/material/materialList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/material/materialCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.eqs.material.materialadd',
					{
						url : '/materialadd',
						data : {
							title : 'Add'
						},
						controller : 'materialAddCtrl',
						templateUrl : 'views/eqs/material/materialAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/material/materialCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.eqs.material.materialedit',
					{
						url : '/material/materialedit',
						data : {
							title : 'Edit'
						},

						controller : 'materialAddCtrl',
						templateUrl : 'views/eqs/material/materialAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/material/materialCtrl.js' ]);
									} ]

						}
					})

			.state(
					'app.eqs.material.materialview',
					{
						url : '/material/materialView',
						data : {
							title : 'View'
						},
						controller : 'materialViewCtrl',
						templateUrl : 'views/eqs/materialView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/materialCtrl.js' ])
									} ]
						}

					})

			// Parts
			.state(
					'app.eqs.parts.partslist',
					{
						url : '/partslist',
						data : {
							title : 'List'
						},
						controller : 'partsListCtrl',
						templateUrl : 'views/eqs/parts/partsList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/parts/partsCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.eqs.parts.partsadd',
					{
						url : '/partsadd',
						data : {
							title : 'Add'
						},
						controller : 'partsAddCtrl',
						templateUrl : 'views/eqs/parts/partsAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/parts/partsCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.eqs.parts.partsedit',
					{
						url : '/parts/partsedit',
						data : {
							title : 'Edit'
						},

						controller : 'partsAddCtrl',
						templateUrl : 'views/eqs/parts/partsAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/parts/partsCtrl.js' ]);
									} ]

						}
					})

			.state('app.eqs.parts.partsview', {
				url : '/parts/partsView',
				data : {
					title : 'View'
				},
				controller : 'partsViewCtrl',
				templateUrl : 'views/eqs/partsView',
				resolve : {
					deps : [ '$ocLazyLoad', function($ocLazyLoad) {
						return $ocLazyLoad.load([ 'js/app/eqs/partsCtrl.js' ])
					} ]
				}

			})

			// Description
			.state(
					'app.eqs.description.descriptionlist',
					{
						url : '/descriptionlist',
						data : {
							title : 'List'
						},
						controller : 'descriptionListCtrl',
						templateUrl : 'views/eqs/description/descriptionList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/description/descriptionCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.eqs.description.descriptionadd',
					{
						url : '/descriptionadd',
						data : {
							title : 'Add'
						},
						controller : 'descriptionAddCtrl',
						templateUrl : 'views/eqs/description/descriptionAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/description/descriptionCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.eqs.description.descriptionedit',
					{
						url : '/description/descriptionedit',
						data : {
							title : 'Edit'
						},

						controller : 'descriptionAddCtrl',
						templateUrl : 'views/eqs/description/descriptionAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/description/descriptionCtrl.js' ]);
									} ]

						}
					})

			.state(
					'app.eqs.description.descriptionview',
					{
						url : '/description/descriptionView',
						data : {
							title : 'View'
						},
						controller : 'descriptionViewCtrl',
						templateUrl : 'views/eqs/descriptionView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/description/descriptionCtrl.js' ])
									} ]
						}

					})

			// container status

			.state(
					'app.eqs.containerStatus.containerStatuslist',
					{
						url : '/containerStatuslist',
						data : {
							title : 'List'
						},
						controller : 'containerStatusListCtrl',
						templateUrl : 'views/eqs/containerStatus/containerStatusList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/containerStatus/containerStatusCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.eqs.containerStatus.containerStatusadd',
					{
						url : '/containerStatusadd',
						data : {
							title : 'Add'
						},
						controller : 'containerStatusAddCtrl',
						templateUrl : 'views/eqs/containerStatus/containerStatusAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/containerStatus/containerStatusCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.eqs.containerStatus.containerStatusedit',
					{
						url : '/containerStatus/containerStatusedit',
						data : {
							title : 'Edit'
						},

						controller : 'containerStatusAddCtrl',
						templateUrl : 'views/eqs/containerStatus/containerStatusAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/containerStatus/containerStatusCtrl.js' ]);
									} ]

						}
					})

			.state(
					'app.eqs.containerStatus.containerStatusview',
					{
						url : '/containerStatus/containerStatusView',
						data : {
							title : 'View'
						},
						controller : 'containerStatusAddCtrl',
						templateUrl : 'views/eqs/containerStatus/containerStatusView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/containerStatus/containerStatusCtrl.js' ])
									} ]
						}

					})

			// container Movement

			.state(
					'app.eqs.containerMovement.containerMovementList',
					{
						url : '/containerMovementlist',
						data : {
							title : 'List'
						},
						controller : 'containerMovementListCtrl',
						templateUrl : 'views/eqs/containerMovement/containerMovementList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/containerMovement/containerMovement.js' ]);
									} ]
						}
					})

			.state(
					'app.eqs.containerMovement.containerMovementadd',
					{
						url : '/containerMovementadd',
						data : {
							title : 'Add'
						},
						controller : 'containerMovementAddCtrl',
						templateUrl : 'views/eqs/containerMovement/containerMovementAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/containerMovement/containerMovement.js' ])
									} ]
						}

					})

			.state(
					'app.eqs.containerMovement.containerMovementedit',
					{
						url : '/containerMovement/containerMovementedit',
						data : {
							title : 'Edit'
						},

						controller : 'containerMovementAddCtrl',
						templateUrl : 'views/eqs/containerStatus/containerStatusAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/containerMovement/containerMovement.js' ]);
									} ]

						}
					})

			// container Movement upload

			.state(
					'app.eqs.containerMovementupload.containerMovementuploadList',
					{
						url : '/containerMovementuploadList',
						data : {
							title : 'List'
						},
						controller : 'containerMovementuploadListCtrl',
						templateUrl : 'views/eqs/containerMovementupload/containerMovementuploadList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/containerMovementupload/containerMovementuploadList.js' ]);
									} ]
						}
					})
			// component

			.state(
					'app.eqs.component.componentlist',
					{
						url : '/componentlist',
						data : {
							title : 'List'
						},
						controller : 'componentListCtrl',
						templateUrl : 'views/eqs/componentList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/component/componentListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.eqs.component.componentadd',
					{
						url : '/componentadd',
						data : {
							title : 'Add'
						},
						controller : 'componentAddCtrl',
						templateUrl : 'views/eqs/componentAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/component/componentAddCtrl.js' ])
									} ]
						}

					})

			/*
			 * .state( 'app.eqs.component.componentedit', { url :
			 * '/component/componentedit', data : { title : 'Edit' },
			 * 
			 * controller : 'componentAddCtrl', templateUrl :
			 * 'views/eqs/componentAdd', resolve : { deps : [ '$ocLazyLoad',
			 * function($ocLazyLoad) { return $ocLazyLoad .load([
			 * 'js/app/eqs/component/componentCtrl.js' ]); } ] } })
			 * 
			 * .state( 'app.eqs.component.view', { url :
			 * '/component/componentView', data : { title : 'View' }, controller :
			 * 'componentViewCtrl', templateUrl : 'views/eqs/componentView',
			 * resolve : { deps : [ '$ocLazyLoad', function($ocLazyLoad) {
			 * return $ocLazyLoad .load([ 'js/app/eqs/componentCtrl.js' ]) } ] } })
			 */

			// Country
			.state('app.master.country', {
				abstract : true,
				templateUrl : "views/common.jsp",
				data : {
					title : 'Country'
				}
			})

			// customercredit

			.state('app.master.customercredit', {
				abstract : true,
				templateUrl : "views/common.jsp",
				data : {
					title : 'Customer Credit'
				}
			})

			// standardcharge

			.state('app.master.standardcharge', {
				abstract : true,
				templateUrl : "views/common.jsp",
				data : {
					title : 'Standard Charges'
				}
			}).state('app.master.taxtype', {
				abstract : true,
				templateUrl : "views/common.jsp",
				data : {
					title : 'Tax Type'
				}
			}).state('app.master.taxgroup', {
				abstract : true,
				templateUrl : "views/common.jsp",
				data : {
					title : 'Tax Group'
				}
			})
			// state

			.state('app.master.state', {
				abstract : true,
				templateUrl : "views/common.jsp",
				data : {
					title : 'State'
				}
			})

			// terms

			.state('app.master.terms', {
				abstract : true,
				templateUrl : "views/common.jsp",
				data : {
					title : 'Terms'
				}
			})

			// units
			.state('app.master.units', {
				abstract : true,
				templateUrl : "views/common.jsp",
				data : {
					title : 'Units'
				}
			})
			
	.state('app.truck.general', {
		abstract : true,
		templateUrl : "views/common",
		data : {
			title : ''
		}
	})
			// branch
			
			.state('app.truck.general.branch', {
				abstract : true,
				templateUrl : "views/common.jsp",
				data : {
					title : 'Branch'
				}
			})
		
			.state('app.truck.general.commodity', {
				abstract : true,
				templateUrl : "views/common.jsp",
				data : {
					title : 'Commodity'
				}
			})
			
			

			.state('app.truck.trailer', {
				
				abstract : true,
				templateUrl : "views/common.jsp",
				data : {
					title : 'Trailer'
				}
			})
			
			// grade
			.state('app.truck.general.grade', {
				abstract : true,
				templateUrl : "views/common.jsp",
				data : {
					title : 'Grade'
				}
			})
			
			//Location
			
			.state('app.truck.general.stopping', {
				abstract : true,
				templateUrl : "views/common.jsp",
				data : {
					title : 'Location'
				}
			})
			.state('app.truck.staffmaster', {
				abstract : true,
				templateUrl : "views/common.jsp",
				data : {
					title : 'Staff Master'
				}
			})
			
			
			//truckdriver
			.state('app.truck.truckdriver', {
				abstract : true,
				templateUrl : "views/common.jsp",
				data : {
					title : 'Truck Driver Mapping'
				}
			})
			
			// Truck Trailer Mapping
				.state('app.truck.trucktrailer', {
				abstract : true,
				templateUrl : "views/common.jsp",
				data : {
					title : 'Truck Trailer Mapping'
				}
			})
			
				.state('app.truck.trucktrailer.list',
			{
				url : '/trucktrailer/list',
				cache : false,
				data : {
					title : 'List'
				},
				controller : 'trucktrailerListCtrl',
				templateUrl : 'views/master/trucktrailer/trucktrailerList',
				resolve : {
					deps : [
							'$ocLazyLoad',
							function($ocLazyLoad) {
								return $ocLazyLoad
										.load([ 'js/app/master/trucktrailer/trucktrailerListCtrl.js' ], {cache:false});
							} ]
				}
			})
			
				.state('app.truck.trucktrailer.add',
			{
				url : '/trucktrailer/add',
				cache : false,
				data : {
					title : 'Add'
				},
				controller : 'trucktrailerAddCtrl',
				templateUrl : 'views/master/trucktrailer/trucktrailerAdd',
				resolve : {
					deps : [
							'$ocLazyLoad',
							function($ocLazyLoad) {
								return $ocLazyLoad
										.load([ 'js/app/master/trucktrailer/trucktrailerAddCtrl.js' ], {cache:false});
							} ]
				}
			})
			

			.state('app.truck.trucktrailer.edit',
			{
				url : '/trucktrailer/edit',
				cache : false,
				data : {
					title : 'Edit'
				},
				controller : 'trucktrailerAddCtrl',
				templateUrl : 'views/master/trucktrailer/trucktrailerAdd',
				resolve : {
					deps : [
							'$ocLazyLoad',
							function($ocLazyLoad) {
								return $ocLazyLoad
										.load([ 'js/app/master/trucktrailer/trucktrailerAddCtrl.js' ], {cache:false});
							} ]
				}
			})
			
			
				.state('app.truck.trucktrailer.view',
			{
				url : '/trucktrailer/view',
				cache : false,
				data : {
					title : 'View'
				},
				controller : 'trucktrailerAddCtrl',
				templateUrl : 'views/master/trucktrailer/trucktrailerView',
				resolve : {
					deps : [
							'$ocLazyLoad',
							function($ocLazyLoad) {
								return $ocLazyLoad
										.load([ 'js/app/master/trucktrailer/trucktrailerAddCtrl.js' ], {cache:false});
							} ]
				}
			})
			// console Error
			.state('app.master.general.consoleerror', {
				abstract : true,
				templateUrl : "views/common.jsp",
				data : {
					title : 'Console Error'
				}
			})

			// line
			.state('app.master.general.line', {
				abstract : true,
				templateUrl : "views/common.jsp",
				data : {
					title : 'Line'
				}
			})

			

	$stateProvider.state('app.master.servicepartner', {
		abstract : true,
		templateUrl : "views/common",
		data : {
			title : 'Customer'
		}
	})

	$stateProvider
			.state('app.master.consigneepartner', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Consignee'
				}
			})
			// Package Type
			.state('app.master.packageType', {
				abstract : true,
				templateUrl : "views/common.jsp",
				data : {
					title : 'Package Type'
				}
			})
			// Region
			.state('app.master.region', {
				abstract : true,
				templateUrl : "views/common.jsp",
				data : {
					title : 'Region'
				}
			})
			// IATA
			.state('app.master.iata', {
				abstract : true,
				templateUrl : "views/common.jsp",
				data : {
					title : 'IATA'
				}
			})
			// Charge Head
			.state('app.master.chargeHead', {
				abstract : true,
				templateUrl : "views/common.jsp",
				data : {
					title : 'Charge Head'
				}
			})
			// Charge Head Group
			.state('app.master.chargeHeadGroup', {
				abstract : true,
				templateUrl : "views/common.jsp",
				data : {
					title : 'Charge Head Group'
				}
			})
			// employee
		
				.state('app.truck.employee', {
				abstract : true,
				templateUrl : "views/common.jsp",
				data : {
					title : 'Employee Master'
				}
			})
			// employee
			.state('app.master.attendance', {
				abstract : true,
				
				templateUrl : "views/common",
				data : {
					title : 'Attendance Report'
				}
			})
			.state('app.master.customerpartner', {
				abstract : true,
				templateUrl : "views/common.jsp",
				data : {
					title : 'Customer'
				}
			})
			.state('app.master.vendor', {
				abstract : true,
				templateUrl : "views/common.jsp",
				data : {
					title : 'Vendor'
				}
			})

			// scheduler

			.state('app.master.scheduler', {
				abstract : true,
				templateUrl : "views/common.jsp",
				data : {
					title : 'Scheduler'
				}
			})

			// implement

			// bl ladding list
			.state(
					'app.master.bladding.list',
					{
						url : '/documentation/bladding/list',
						data : {
							title : 'Bill Of Ladding List'
						},
						controller : 'bladdingCtrl',
						templateUrl : 'views/documents/blLadding/blLaddingList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/documentation/bladding/bLadding.js' ])
									} ]
						}

					})
			// bl ladding add
			.state(
					'app.master.bladding.add',
					{
						url : '/documentation/bladding/add',
						data : {
							title : 'Bill Of Ladding Add'
						},
						controller : 'bladdingAddCtrl',
						templateUrl : 'views/documents/blLadding/blLaddingAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/documentation/bladding/bLaddingAdd.js' ])
									} ]
						}

					})
			// bl ladding edit
			.state(
					'app.master.bladding.edit',
					{
						url : '/documentation/bladding/edit',
						data : {
							title : 'Edit'
						},

						controller : 'bladdingAddCtrl',
						templateUrl : 'views/documents/blLadding/blLaddingAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/documentation/bladding/bLaddingAdd.js' ]);
									} ]

						}
					})

			.state(
					'app.master.bladding.outwardlist',
					{
						url : '/documentation/outwardbladding/list',
						data : {
							title : 'Bill Of Ladding List'
						},
						controller : 'bladdingCtrl',
						templateUrl : 'views/documents/outward/outwardList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/documentation/outward/outward.js' ])
									} ]
						}

					})
			// bl ladding add
			.state(
					'app.master.bladding.outwardadd',
					{
						url : '/documentation/outwardbladding/add',
						data : {
							title : 'Bill Of Ladding Add'
						},
						controller : 'bladdingAddCtrl',
						templateUrl : 'views/documents/outward/outwardAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/documentation/outward/outwardAdd.js' ])
									} ]
						}

					})
			// bl ladding edit
			.state(
					'app.master.bladding.outwardedit',
					{
						url : '/documentation/outwardbladding/edit',
						data : {
							title : 'Edit'
						},

						controller : 'bladdingAddCtrl',
						templateUrl : 'views/documents/outward/outwardAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/documentation/outward/outwardAdd.js' ]);
									} ]

						}
					})

			// vessel master list
			.state(
					'app.master.vesselmaster.list',
					{
						url : '/master/vesselmaster/list',
						data : {
							title : 'List'
						},
						controller : 'vesselListCtrl',
						templateUrl : 'views/master/vesselMaster/vesselMasterList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/vesselMaster/vesselMasterListCntrl.js' ])
									} ]
						}

					})
			// vessel master add
			.state(
					'app.master.vesselmaster.add',
					{
						url : '/master/vesselmaster/add',
						data : {
							title : 'Add'
						},
						controller : 'vesselmasterAddCtrl',
						templateUrl : 'views/master/vesselMaster/vesselMasterAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/vesselMaster/vesselMasterAddCntrl.js' ])
									} ]
						}

					})
			// vesselmaster edit
			.state(
					'app.master.vesselmaster.edit',
					{
						url : '/master/vesselmaster/edit',
						data : {
							title : 'Edit'
						},
						controller : 'vesselmasterAddCtrl',
						templateUrl : 'views/master/vesselMaster/vesselMasterAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/vesselMaster/vesselMasterAddCntrl.js' ])
									} ]
						}

					})
					
					
					
					.state(
					'app.master.vesselmaster.view',
					{
						url : '/master/vesselmaster/view',
						data : {
							title : 'View'
						},
						controller : 'vesselmasterAddCtrl',
						templateUrl : 'views/master/vesselMaster/vesselMasterView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/vesselMaster/vesselMasterAddCntrl.js' ])
									} ]
						}

					})
					
			// vessel master view
			/*
			 * .state('app.master.vesselmaster.view', { url :
			 * '/master/vesselmaster/view', data : { title : 'Vessel Master
			 * View' }, controller : 'servicepartnerViewCtrl', templateUrl : '',
			 * resolve : { deps : [ '$ocLazyLoad', function($ocLazyLoad) {
			 * return $ocLazyLoad .load([ '' ]) } ] } })
			 */

			.state(
					'app.master.user.usermaster',
					{
						url : '/user/master',
						data : {
							title : 'User Management'
						},

						controller : 'userMasterListCtrl',
						templateUrl : 'views/master/user/userMasterPage',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/user/userMasterCtrl.js' ]);
									} ]
						}

					})
//USER MASTER
    
    
	.state(
			'app.master.user.userMaster',
			{
				url : '/user/userMaster/userMasterList',
				data : {
					title : 'List'
				},
				controller : 'usermasterCtrl',
				templateUrl : 'views/master/usermaster/usermasterList',
				resolve : {
					deps : [
							'$ocLazyLoad',
							function($ocLazyLoad) {
								return $ocLazyLoad
										.load([ 'js/app/master/usermaster/usermasternewCtrl.js' ]);
							} ]
				}
			})

	.state(
			'app.master.user.userMasteradd-add',
			{
				url : '/user/userMaster/add',
				data : {
					title : 'Add'
				},
				controller : 'usermasterAddCtrl',
				templateUrl : 'views/master/usermaster/usermasterAdd',
				resolve : {
					deps : [
							'$ocLazyLoad',
							function($ocLazyLoad) {
								return $ocLazyLoad
										.load([ 'js/app/master/usermaster/usermasterAddCtrl.js' ])
							} ]
				}

			})
	.state(
			'app.master.user.userMasteredit-Edit',
			{
				url : '/user/userMaster/Edit/:empId',
				data : {
					title : 'Edit'
				},
				controller : 'usermasterAddCtrl',
				templateUrl : 'views/master/usermaster/usermasterAdd',
				resolve : {
					deps : [
							'$ocLazyLoad',
							function($ocLazyLoad) {
								return $ocLazyLoad
										.load([ 'js/app/master/usermaster/usermasterAddCtrl.js' ])
							} ]
				}

			})
				.state('app.master.user.userloyeeMasterview-View',
			{
				url : '/user/userloyeeMaster/View/:empId',
				data : {
					title : 'View'
				},
				controller : 'usermasterAddCtrl',
				templateUrl : 'views/master/usermaster/usermasterAddView',
				resolve : {
					deps : [
							'$ocLazyLoad',
							function($ocLazyLoad) {
								return $ocLazyLoad
										.load([ 'js/app/master/usermaster/usermasterAddCtrl.js' ])
							} ]
				}

			})
			.state(
					'app.master.thcatuqr',
					{
						url : '/master/thcatuqr',
						data : {
							title : 'THC AT UQR'
						},
						views : {
							"content@app" : {
								controller : 'thcatqtyCtrl',
								templateUrl : 'views/master/thcatuqr',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/master/thcatuqr.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.truck.general.changetypemenu',
					{
						url : '/truck/general/chargetype',
						data : {
							title : 'Charge Type'
						},
						controller : 'changeTypeCtrl',
						templateUrl : 'views/master/changetype/changetypeList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/general/changetype/changetypeListCtrl.js' ])
									} ]
						}

					})
					
					
			.state(
					'app.truck.general.changetypemenu-add',
					{
						url : '/truck/general/chargetype/add',
						cache : false,
						data : {
							title : 'Add'
						},
						controller : 'changeTypeaddCtrl',
						templateUrl : 'views/master/changetype/changetypeAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/general/changetype/changetypeAddCtrl.js' ])
									} ]
						}

					})
					.state(
					'app.truck.general.changetypemenu-edit',
					{
						url : '/truck/general/chargetype/edit',
						cache : false,
						data : {
							title : 'Edit'
						},
						controller : 'changeTypeaddCtrl',
						templateUrl : 'views/master/changetype/changetypeAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/general/changetype/changetypeAddCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.truck.general.changetypemenu-view',
					{
						url : '/truck/general/chargetype/view',
						cache : false,
						data : {
							title : 'View'
						},
						controller : 'changeTypeaddCtrl',
						templateUrl : 'views/master/changetype/changetypeView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/general/changetype/changetypeAddCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.master.servicepartner.list',
					{
						url : '/master/servicepartner',
						data : {
							title : 'Customer'
						},
						controller : 'servicepartnerCtrl',
						templateUrl : 'views/master/servicepartner/servicepartnerList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/servicepartner/servicepartnerListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.servicepartner.add',
					{
						url : '/master/servicepartner/add',
						data : {
							title : 'Add'
						},
						controller : 'servicepartnerAddCtrl',
						templateUrl : 'views/master/servicepartner/servicepartnerAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/servicepartner/servicepartnerAddCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.master.servicepartner.edit',
					{
						url : '/master/servicepartner/edit',
						data : {
							title : 'Add'
						},
						controller : 'servicepartnerAddCtrl',
						templateUrl : 'views/master/servicepartner/servicepartnerAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/servicepartner/servicepartnerAddCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.master.servicepartner.view',
					{
						url : '/master/servicepartner/view',
						data : {
							title : 'View'
						},
						controller : 'servicepartnerViewCtrl',
						templateUrl : 'views/master/servicepartner/servicepartnerView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/servicepartner/servicepartnerAddCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.master.consigneepartner.list',
					{
						url : '/master/consignee',
						data : {
							title : 'Consignee'
						},
						controller : 'consigneepartnerCtrl',
						templateUrl : 'views/master/consigneepartner/consigneepartnerList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/consigneepartner/consigneepartnerListCtrl.js' ]);
									} ]
						}
					})
			.state(
					'app.master.consigneepartner.add',
					{
						url : '/master/consignee/add',
						data : {
							title : 'Add'
						},
						controller : 'consigneepartnerAddCtrl',
						templateUrl : 'views/master/consigneepartner/consigneepartnerAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/consigneepartner/consigneepartnerAddCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.master.consigneepartner.edit',
					{
						url : '/master/consignee/edit',
						data : {
							title : 'Add'
						},
						controller : 'consigneepartnerAddCtrl',
						templateUrl : 'views/master/consigneepartner/consigneepartnerAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/consigneepartner/consigneepartnerAddCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.master.consigneepartner.view',
					{
						url : '/master/consigneeepartner/view',
						data : {
							title : 'View'
						},
						controller : 'consigneepartnerAddCtrl',
						templateUrl : 'views/master/consigneepartner/consigneepartnerView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/consigneepartner/consigneepartnerAddCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.master.customerpartner.list',
					{
						url : '/master/customer',
						data : {
							title : 'List'
						},
						controller : 'customerpartnerCtrl',
						templateUrl : 'views/master/customerpartner/customerpartnerList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/customerpartner/customerpartnerListCtrl.js' ]);
									} ]
						}
					})
			.state(
					'app.master.customerpartner.add',
					{
						url : '/master/customer/add',
						data : {
							title : 'Add'
						},
						controller : 'customerpartnerAddCtrl',
						templateUrl : 'views/master/customerpartner/customerpartnerAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/customerpartner/customerpartnerAddCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.master.customerpartner.edit',
					{
						url : '/master/customer/edit',
						data : {
							title : 'Add'
						},
						controller : 'customerpartnerAddCtrl',
						templateUrl : 'views/master/customerpartner/customerpartnerAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/customerpartner/customerpartnerAddCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.master.customerpartner.view',
					{
						url : '/master/customerpartner/view',
						data : {
							title : 'View'
						},
						controller : 'customerpartnerAddCtrl',
						templateUrl : 'views/master/customerpartner/customerpartnerView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/customerpartner/customerpartnerAddCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.master.vendor.list',
					{
						url : '/master/vendor',
						data : {
							title : 'List'
						},
						controller : 'vendorCtrl',
						templateUrl : 'views/master/vendor/vendorList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/vendor/vendorListCtrl.js' ]);
									} ]
						}
					})
			.state(
					'app.master.vendor.add',
					{
						url : '/master/vendor/add',
						data : {
							title : 'Add'
						},
						controller : 'vendorAddCtrl',
						templateUrl : 'views/master/vendor/vendorAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/vendor/vendorAddCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.master.vendor.edit',
					{
						url : '/master/vendor/edit',
						data : {
							title : 'Edit'
						},
						controller : 'vendorAddCtrl',
						templateUrl : 'views/master/vendor/vendorAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/vendor/vendorAddCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.master.vendor.view',
					{
						url : '/master/vendor/view',
						data : {
							title : 'View'
						},
						controller : 'vendorAddCtrl',
						templateUrl : 'views/master/vendor/vendorView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/vendor/vendorAddCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.truck.general.changecomponentmenu',
					{
						url : '/master/general/chargecomponent',
						data : {
							title : 'Charge Component'
						},
						controller : 'changecomponentCtrl',
						templateUrl : 'views/master/changecomponent/changecomponentList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/general/changecomponent/changecomponentListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.truck.general.changecomponentmenu-add',
					{
						url : '/master/general/chargecomponentsubmenu/add',
						data : {
							title : 'Add'
						},
						controller : 'changecomponentaddCtrl',
						templateUrl : 'views/master/changecomponent/changecomponentAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/general/changecomponent/changecomponentAddCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.truck.general.changecomponentmenu-view',
					{
						url : '/master/general/chargecomponentmenu/view',
						data : {
							title : 'View'
						},
						controller : 'changecomponentaddCtrl',
						templateUrl : 'views/master/changecomponent/changecomponentView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/general/changecomponent/changecomponentAddCtrl.js' ])
									} ]
						}

					})
			// Port

			.state(
					'app.master.port.list',
					{
						url : '/master/port/list',
						data : {
							title : 'List'
						},
						controller : 'portCtrl',
						templateUrl : 'views/master/port/portList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/port/portListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.port.add',
					{
						url : '/master/port/add',
						data : {
							title : 'Add'
						},
						controller : 'portaddCtrl',
						templateUrl : 'views/master/port/portAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/port/portAddCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.master.port.edit',
					{
						url : '/master/port/edit',
						data : {
							title : 'Edit'
						},
						controller : 'portaddCtrl',
						templateUrl : 'views/master/port/portAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/port/portAddCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.master.port.view',
					{
						url : '/master/port/view',
						data : {
							title : 'View'
						},
						controller : 'portaddCtrl',
						templateUrl : 'views/master/port/portView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/port/portAddCtrl.js' ])
									} ]
						}

					})

			// Terminal
			.state(
					'app.master.terminal.list',
					{
						url : '/master/terminal/list',
						data : {
							title : 'List'
						},
						controller : 'terminalCtrl',
						templateUrl : 'views/master/terminal/terminalList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/terminal/terminalListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.terminal.add',
					{
						url : '/master/terminal/add',
						data : {
							title : 'Add'
						},
						controller : 'terminaladdCtrl',
						templateUrl : 'views/master/terminal/terminalAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/terminal/terminalAddCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.master.terminal.edit',
					{
						url : '/master/terminal/edit',
						data : {
							title : 'Edit'
						},
						controller : 'terminaladdCtrl',
						templateUrl : 'views/master/terminal/terminalAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/terminal/terminalAddCtrl.js' ])
									} ]
						}

					})

			// Area
			.state(
					'app.master.area.list',
					{
						url : '/master/area/list',
						data : {
							title : 'List'
						},
						controller : 'areaListCtrl',
						templateUrl : '/views/master/area/areaList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/area/areaListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.area.add',
					{
						url : '/master/area/add',
						data : {
							title : 'Add'
						},
						controller : 'areaAddCtrl',
						templateUrl : '/views/master/area/areaAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/area/areaAddCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.master.area.edit',
					{
						url : '/master/area/edit',
						data : {
							title : 'Edit'
						},
						controller : 'areaAddCtrl',
						templateUrl : 'views/master/area/areaAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/area/areaAddCtrl.js' ])
									} ]
						}

					})
			// CITY
			.state(
					'app.master.city.list',
					{
						url : '/master/city/list',
						data : {
							title : 'List'
						},
						controller : 'citylistCtrl',
						templateUrl : 'views/master/city/cityList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/city/cityListCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.master.city.add',
					{
						url : '/master/city/add',
						data : {
							title : 'Add'
						},
						controller : 'cityaddCtrl',
						templateUrl : 'views/master/city/cityAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/city/cityAddCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.master.city.edit',
					{
						url : '/master/city/edit',
						data : {
							title : 'Edit'
						},
						controller : 'cityaddCtrl',
						templateUrl : 'views/master/city/cityAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/city/cityAddCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.master.city.view',
					{
						url : '/master/city/view',
						data : {
							title : 'View'
						},
						controller : 'cityaddCtrl',
						templateUrl : 'views/master/city/cityView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/city/cityAddCtrl.js' ])
									} ]
						}

					})

			// ContainerSize Type

			.state(
					'app.master.containersize.list',
					{
						url : '/master/containersize/list',
						data : {
							title : 'List'
						},
						controller : 'containersizelistCtrl',
						templateUrl : 'views/master/containersize/containersizeList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/containersize/containersizeListCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.master.containersize.add',
					{
						url : '/master/containersize/add',
						data : {
							title : 'Add'
						},
						controller : 'containersizeaddCtrl',
						templateUrl : 'views/master/containersize/containersizeAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/containersize/containersizeAddCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.master.containersize.edit',
					{
						url : '/master/containersize/edit',
						data : {
							title : 'Edit'
						},
						controller : 'containersizeaddCtrl',
						templateUrl : 'views/master/containersize/containersizeAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/containersize/containersizeAddCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.master.containersize.view',
					{
						url : '/master/containersize/view',
						data : {
							title : 'View'
						},
						controller : 'containersizeaddCtrl',
						templateUrl : 'views/master/containersize/containersizeView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/containersize/containersizeAddCtrl.js' ])
									} ]
						}

					})

			// Country
			.state(
					'app.master.country.list',
					{
						url : '/master/country/list',
						data : {
							title : 'List'
						},
						controller : 'countrylistCtrl',
						templateUrl : 'views/master/country/countryList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/country/countryListCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.master.country.add',
					{
						url : '/master/country/add',
						data : {
							title : 'Add'
						},
						controller : 'countryaddCtrl',
						templateUrl : 'views/master/country/countryAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/country/countryAddCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.master.country.edit',
					{
						url : '/master/country/edit',
						data : {
							title : 'Edit'
						},
						controller : 'countryaddCtrl',
						templateUrl : 'views/master/country/countryAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/country/countryAddCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.master.country.view',
					{
						url : '/master/country/view',
						data : {
							title : 'View'
						},
						controller : 'countryaddCtrl',
						templateUrl : 'views/master/country/countryView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/country/countryAddCtrl.js' ])
									} ]
						}

					})
			// customercredit

			.state(
					'app.master.customercredit.list',
					{
						url : '/master/customercredit/list',
						data : {
							title : 'List'
						},
						controller : 'customercreditlistCtrl',
						templateUrl : 'views/master/customercredit/customercreditList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/customercredit/customercreditListCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.master.customercredit.add',
					{
						url : '/master/customercredit/add',
						data : {
							title : 'Add'
						},
						controller : 'customercreditaddCtrl',
						templateUrl : 'views/master/customercredit/customercreditAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/customercredit/customercreditAddCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.master.customercredit.edit',
					{
						url : '/master/customercredit/edit',
						data : {
							title : 'Add'
						},
						controller : 'customercreditaddCtrl',
						templateUrl : 'views/master/customercredit/customercreditAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/customercredit/customercreditAddCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.master.customercredit.view',
					{
						url : '/master/customercredit/view',
						data : {
							title : 'View'
						},
						controller : 'customercreditaddCtrl',
						templateUrl : 'views/master/customercredit/customercreditView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/customercredit/customercreditAddCtrl.js' ])
									} ]
						}

					})

			// standardcharge
			.state(
					'app.master.standardcharge.list',
					{
						url : '/master/standardcharge/list',
						data : {
							title : 'List'
						},
						controller : 'standardchargelistCtrl',
						templateUrl : 'views/master/standardcharge/standardchargeList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/standardcharge/standardchargeListCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.master.standardcharge.add',
					{
						url : '/master/standardcharge/add',
						data : {
							title : 'Add'
						},
						controller : 'standardchargeaddCtrl',
						templateUrl : 'views/master/standardcharge/standardchargeAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/standardcharge/standardchargeAddCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.master.standardcharge.edit',
					{
						url : '/master/standardcharge/edit',
						data : {
							title : 'Add'
						},
						controller : 'standardchargeeditCtrl',
						templateUrl : 'views/master/standardcharge/standardchargeAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/standardcharge/standardchargeAddCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.master.standardcharge.view',
					{
						url : '/master/standardcharge/view',
						data : {
							title : 'View'
						},
						controller : 'standardchargeviewCtrl',
						templateUrl : 'views/master/standardcharge/standardchargeView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/standardcharge/standardchargeAddCtrl.js' ])
									} ]
						}

					})
			// /tax type
			.state(
					'app.master.taxtype.list',
					{
						url : '/master/taxtype/list',
						data : {
							title : 'List'
						},
						controller : 'taxtypelistCtrl',
						templateUrl : 'views/master/taxtype/taxtypeList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/taxtype/taxtypeListCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.master.taxtype.add',
					{
						url : '/master/taxtype/add',
						data : {
							title : 'Add'
						},
						controller : 'taxtypeaddCtrl',
						templateUrl : 'views/master/taxtype/taxtypeAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/taxtype/taxtypeAddCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.master.taxtype.edit',
					{
						url : '/master/taxtype/edit',
						data : {
							title : 'edit'
						},
						controller : 'taxtypeeditCtrl',
						templateUrl : 'views/master/taxtype/taxtypeAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/taxtype/taxtypeAddCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.master.taxtype.view',
					{
						url : '/master/taxtype/view',
						data : {
							title : 'View'
						},
						controller : 'taxtypeeditCtrl',
						templateUrl : 'views/master/taxtype/taxtypeView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/taxtype/taxtypeAddCtrl.js' ])
									} ]
						}

					})
			// taxgroup

			.state(
					'app.master.taxgroup.list',
					{
						url : '/master/taxgroup/list',
						data : {
							title : 'List'
						},
						controller : 'taxgrouplistCtrl',
						templateUrl : 'views/master/taxgroup/taxgroupList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/taxgroup/taxgroupListCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.master.taxgroup.add',
					{
						url : '/master/taxgroup/add',
						data : {
							title : 'Add'
						},
						controller : 'taxgroupaddCtrl',
						templateUrl : 'views/master/taxgroup/taxgroupAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/taxgroup/taxgroupAddCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.master.taxgroup.edit',
					{
						url : '/master/taxgroup/edit',
						data : {
							title : 'edit'
						},
						controller : 'taxgroupeditCtrl',
						templateUrl : 'views/master/taxgroup/taxgroupAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/taxgroup/taxgroupAddCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.master.taxgroup.view',
					{
						url : '/master/taxgroup/view',
						data : {
							title : 'View'
						},
						controller : 'taxgroupeditCtrl',
						templateUrl : 'views/master/taxgroup/taxgroupView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/taxgroup/taxgroupAddCtrl.js' ])
									} ]
						}

					})
			// state
			.state(
					'app.master.state.list',
					{
						url : '/master/state/list',
						data : {
							title : 'List'
						},
						controller : 'statelistCtrl',
						templateUrl : 'views/master/state/stateList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/state/stateListCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.master.state.add',
					{
						url : '/master/state/add',
						data : {
							title : 'Add'
						},
						controller : 'stateaddCtrl',
						templateUrl : 'views/master/state/stateAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/state/stateAddCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.master.state.edit',
					{
						url : '/master/state/edit',
						data : {
							title : 'Edit'
						},
						controller : 'stateaddCtrl',
						templateUrl : 'views/master/state/stateAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/state/stateAddCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.master.state.view',
					{
						url : '/master/state/view',
						data : {
							title : 'View'
						},
						controller : 'stateaddCtrl',
						templateUrl : 'views/master/state/stateView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/state/stateAddCtrl.js' ])
									} ]
						}

					})

			// terms

			.state(
					'app.master.terms.list',
					{
						url : '/master/terms/list',
						data : {
							title : 'List'
						},
						controller : 'termslistCtrl',
						templateUrl : 'views/master/terms/termsList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/terms/termsListCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.master.terms.add',
					{
						url : '/master/terms/add',
						data : {
							title : 'Add'
						},
						controller : 'termsaddCtrl',
						templateUrl : 'views/master/terms/termsAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/terms/termsAddCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.master.terms.edit',
					{
						url : '/master/terms/edit',
						data : {
							title : 'Edit'
						},
						controller : 'termsaddCtrl',
						templateUrl : 'views/master/terms/termsAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/terms/termsAddCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.master.terms.view',
					{
						url : '/master/terms/view',
						data : {
							title : 'View'
						},
						controller : 'termsaddCtrl',
						templateUrl : 'views/master/terms/termsView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/terms/termsAddCtrl.js' ])
									} ]
						}

					})

			// units

			.state(
					'app.master.units.list',
					{
						url : '/master/units/list',
						data : {
							title : 'List'
						},
						controller : 'unitslistCtrl',
						templateUrl : 'views/master/units/unitsList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/units/unitsListCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.master.units.add',
					{
						url : '/master/units/add',
						data : {
							title : 'Add'
						},
						controller : 'unitsaddCtrl',
						templateUrl : 'views/master/units/unitsAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/units/unitsAddCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.master.units.edit',
					{
						url : '/master/units/edit',
						data : {
							title : 'Add'
						},
						controller : 'unitsaddCtrl',
						templateUrl : 'views/master/units/unitsAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/units/unitsAddCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.master.units.view',
					{
						url : '/master/units/view',
						data : {
							title : 'Add'
						},
						controller : 'unitsaddCtrl',
						templateUrl : 'views/master/units/unitsView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/units/unitsAddCtrl.js' ])
									} ]
						}

					})

			// Package Type

			.state(
					'app.master.packageType.list',
					{
						url : '/master/packageType/list',
						data : {
							title : 'List'
						},
						controller : 'packageTypeCtrl',
						templateUrl : 'views/master/packageType/packageTypeList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/packageType/packageTypeListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.packageType.add',
					{
						url : '/master/packageType/add',
						data : {
							title : 'Add'
						},
						controller : 'packageTypeaddCtrl',
						templateUrl : 'views/master/packageType/packageTypeAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/packageType/packageTypeAddCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.master.packageType.edit',
					{
						url : '/master/packageType/edit',
						data : {
							title : 'Edit'
						},
						controller : 'packageTypeaddCtrl',
						templateUrl : 'views/master/packageType/packageTypeAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/packageType/packageTypeAddCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.master.packageType.view',
					{
						url : '/master/packageType/view',
						data : {
							title : 'View'
						},
						controller : 'packageTypeaddCtrl',
						templateUrl : 'views/master/packageType/packageTypeView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/packageType/packageTypeAddCtrl.js' ])
									} ]
						}

					})

			// Region

			.state(
					'app.master.region.list',
					{
						url : '/master/region/list',
						data : {
							title : 'List'
						},
						controller : 'regionCtrl',
						templateUrl : 'views/master/region/regionList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/region/regionListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.region.add',
					{
						url : '/master/region/add',
						data : {
							title : 'Add'
						},
						controller : 'regionaddCtrl',
						templateUrl : 'views/master/region/regionAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/region/regionAddCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.master.region.edit',
					{
						url : '/master/region/edit',
						data : {
							title : 'Edit'
						},
						controller : 'regionaddCtrl',
						templateUrl : 'views/master/region/regionAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/region/regionAddCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.master.region.view',
					{
						url : '/master/region/view',
						data : {
							title : 'View'
						},
						controller : 'regionaddCtrl',
						templateUrl : 'views/master/region/regionView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/region/regionAddCtrl.js' ])
									} ]
						}

					})

			/*// Charge Head

			.state(
					'app.master.chargeHead.list',
					{
						url : '/master/chargeHead/list',
						data : {
							title : 'List'
						},
						controller : 'chargeHeadCtrl',
						templateUrl : 'views/master/chargeHead/chargeHeadList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/chargeHead/chargeHeadListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.chargeHead.add',
					{
						url : '/master/chargeHead/add',
						data : {
							title : 'Add'
						},
						controller : 'chargeHeadAddCtrl',
						templateUrl : 'views/master/chargeHead/chargeHeadAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/chargeHead/chargeHeadAddCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.master.chargeHead.edit',
					{
						url : '/master/chargeHead/edit',
						data : {
							title : 'Edit'
						},
						controller : 'chargeHeadAddCtrl',
						templateUrl : 'views/master/chargeHead/chargeHeadAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/chargeHead/chargeHeadAddCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.master.chargeHead.view',
					{
						url : '/master/chargeHead/view',
						data : {
							title : 'View'
						},
						controller : 'chargeHeadViewCtrl',
						templateUrl : 'views/master/chargeHead/chargeHeadView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/chargeHead/chargeHeadAddCtrl.js' ])
									} ]
						}

					})*/
						//Charge Head
								
				
					
					.state(
					'app.master.chargeHead.list',
					{
						url : '/master/chargeHead/list',
						data : {
							title : 'List'
						},
						controller : 'chargeHeadCtrl',
						templateUrl : 'views/master/chargeHead/chargeHeadList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/chargeHead/chargeHeadListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.chargeHead.add',
					{
						url : '/master/chargeHead/add',
						data : {
							title : 'Add'
						},
						controller : 'chargeHeadAddCtrl',
						templateUrl : 'views/master/chargeHead/chargeHeadAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/chargeHead/chargeHeadAddCtrl.js' ])
									} ]
						}

					})
							.state(
					'app.master.chargeHead.edit',
					{
						url : '/master/chargeHead/edit',
						data : {
							title : 'Edit'
						},
						controller : 'chargeHeadAddCtrl',
						templateUrl : 'views/master/chargeHead/chargeHeadAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/chargeHead/chargeHeadAddCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.master.chargeHead.view',
					{
						url : '/master/chargeHead/view',
						data : {
							title : 'View'
						},
						controller : 'chargeHeadViewCtrl',
						templateUrl : 'views/master/chargeHead/chargeHeadView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/chargeHead/chargeHeadAddCtrl.js' ])
									} ]
						}

					})
			// Charge Head Group

			.state(
					'app.master.chargeHeadGroup.list',
					{
						url : '/master/chargeHeadGroup/list',
						data : {
							title : 'List'
						},
						controller : 'chargeHeadGroupCtrl',
						templateUrl : 'views/master/chargeHeadGroup/chargeHeadGroupList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/chargeHeadGroup/chargeHeadGroupListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.chargeHeadGroup.add',
					{
						url : '/master/chargeHeadGroup/add',
						data : {
							title : 'Add'
						},
						controller : 'chargeHeadGroupAddCtrl',
						templateUrl : 'views/master/chargeHeadGroup/chargeHeadGroupAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/chargeHeadGroup/chargeHeadGroupAddCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.master.chargeHeadGroup.edit',
					{
						url : '/master/chargeHeadGroup/edit',
						data : {
							title : 'Edit'
						},
						controller : 'chargeHeadGroupAddCtrl',
						templateUrl : 'views/master/chargeHeadGroup/chargeHeadGroupAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/chargeHeadGroup/chargeHeadGroupAddCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.master.chargeHeadGroup.view',
					{
						url : '/master/chargeHeadGroup/view',
						data : {
							title : 'View'
						},
						controller : 'chargeHeadGroupAddCtrl',
						templateUrl : 'views/master/chargeHeadGroup/chargeHeadGroupView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/chargeHeadGroup/chargeHeadGroupAddCtrl.js' ])
									} ]
						}

					})

			// IATA

			.state(
					'app.master.iata.list',
					{
						url : '/master/iata/list',
						data : {
							title : 'List'
						},
						controller : 'iataCtrl',
						templateUrl : 'views/master/iata/iataList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/iata/iataListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.iata.add',
					{
						url : '/master/iata/add',
						data : {
							title : 'Add'
						},
						controller : 'iataaddCtrl',
						templateUrl : 'views/master/iata/iataAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/iata/iataAddCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.master.iata.edit',
					{
						url : '/master/iata/edit',
						data : {
							title : 'Edit'
						},
						controller : 'iataaddCtrl',
						templateUrl : 'views/master/iata/iataAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/iata/iataAddCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.master.iata.view',
					{
						url : '/master/iata/view',
						data : {
							title : 'View'
						},
						controller : 'iataaddCtrl',
						templateUrl : 'views/master/iata/iataView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/iata/iataAddCtrl.js' ])
									} ]
						}

					})
			// Manage Store
			.state(
					'app.master.inventory.managestore',
					{
						url : '/master/inventory/managestoreList',
						data : {
							title : 'Manage Store'
						},
						controller : 'managestoreListCtrl',
						templateUrl : 'views/master/inventory/managestore/managestoreList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/managestore/managestoreListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.managestore-add',
					{
						url : '/master/inventory/managestoreAdd',
						data : {
							title : 'Add'
						},
						controller : 'managestoreAddCtrl',
						templateUrl : 'views/master/inventory/managestore/managestoreAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/managestore/managestoreAddCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.managestore-edit',
					{
						url : '/master/inventory/managestoreEdit',
						data : {
							title : 'Edit'
						},
						controller : 'managestoreEditCtrl',
						templateUrl : 'views/master/inventory/managestore/managestoreAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/managestore/managestoreAddCtrl.js' ]);
									} ]
						}
					})

			// Manage Store Ends

			// Store to purchase

			.state(
					'app.master.inventory.storetopurchase',
					{
						url : '/master/inventory/storetopurchaseList',
						data : {
							title : 'Store To Purchase Department'
						},
						controller : 'storetopurchaseListCtrl',
						templateUrl : 'views/master/inventory/storetopurchase/storetopurchaseList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/storetopurchase/storetopurchaseListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.storetopurchase-add',
					{
						url : '/master/inventory/storetopurchaseAdd',
						data : {
							title : 'Add'
						},
						controller : 'storetopurchaseAddCtrl',
						templateUrl : 'views/master/inventory/storetopurchase/storetopurchaseAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/storetopurchase/storetopurchaseAddCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.storetopurchase-edit',
					{
						url : '/master/inventory/storetopurchaseEdit',
						data : {
							title : 'Edit'
						},
						controller : 'storetopurchaseAddCtrl',
						templateUrl : 'views/master/inventory/storetopurchase/storetopurchaseAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/storetopurchase/storetopurchaseAddCtrl.js' ]);
									} ]
						}
					})

			// Store to purchase Ends

			// Store to Store

			.state(
					'app.master.inventory.storetostore',
					{
						url : '/master/inventory/storetostoreList',
						data : {
							title : 'Store To Store Requisition'
						},
						controller : 'storetostoreListCtrl',
						templateUrl : 'views/master/inventory/storetostore/storetostoreList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/storetostore/storetostoreListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.storetostore-add',
					{
						url : '/master/inventory/storetostoreAdd',
						data : {
							title : 'Add'
						},
						controller : 'storetostoreAddCtrl',
						templateUrl : 'views/master/inventory/storetostore/storetostoreAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/storetostore/storetostoreAddCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.storetostore-edit',
					{
						url : '/master/inventory/storetostoreEdit',
						data : {
							title : 'Edit'
						},
						controller : 'storetostoreAddCtrl',
						templateUrl : 'views/master/inventory/storetostore/storetostoreAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/storetostore/storetostoreAddCtrl.js' ]);
									} ]
						}
					})

			// Store to Store Ends

			// Approval
			.state(
					'app.master.inventory.approval',
					{
						url : '/master/inventory/approvalList',
						data : {
							title : 'Approval'
						},
						controller : 'approvalListCtrl',
						templateUrl : 'views/master/inventory/approval/approvalList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/approval/approvalListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.approval-edit',
					{
						url : '/master/inventory/approvaledit',
						data : {
							title : 'Edit'
						},
						controller : 'approvalEditCtrl',
						templateUrl : 'views/master/inventory/approval/approvalEdit',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/approval/approvalEditCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.approval-view',
					{
						url : '/master/inventory/approvalview',
						data : {
							title : 'View'
						},
						controller : 'approvalEditCtrl',
						templateUrl : 'views/master/inventory/approval/approvalView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/approval/approvalEditCtrl.js' ]);
									} ]
						}
					})

			// Approval Ends

			// Purchase Order

			.state(
					'app.master.inventory.purchaseorder',
					{
						url : '/master/inventory/purchaseorderList',
						data : {
							title : 'Purchase Order'
						},
						controller : 'purchaseorderListCtrl',
						templateUrl : 'views/master/inventory/purchaseorder/purchaseorderList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/purchaseorder/purchaseorderListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.purchaseorder-Add',
					{
						url : '/master/inventory/purchaseorderAdd',
						data : {
							title : 'Add'
						},
						controller : 'purchaseorderAddCtrl',
						templateUrl : 'views/master/inventory/purchaseorder/purchaseorderAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/purchaseorder/purchaseorderAddCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.purchaseorder-View',
					{
						url : '/master/inventory/purchaseorderView',
						data : {
							title : 'View'
						},
						controller : 'purchaseorderAddCtrl',
						templateUrl : 'views/master/inventory/purchaseorder/PurchaseOrderView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/purchaseorder/purchaseorderAddCtrl.js' ]);
									} ]
						}
					})
			// Purchase Order Ends

			// Purchase Order Approval
			.state(
					'app.master.inventory.purchaseorderapproval',
					{
						url : '/master/inventory/purchaseorderapprovalList',
						data : {
							title : 'Purchase Order Approval'
						},
						controller : 'purchaseorderapprovalListCtrl',
						templateUrl : 'views/master/inventory/purchaseorderapproval/purchaseorderapprovalList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/purchaseorderapproval/purchaseorderapprovalListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.purchaseorderapproval-Add',
					{
						url : '/master/inventory/purchaseorderapprovalAdd',
						data : {
							title : 'Add'
						},
						controller : 'purchaseorderapprovalAddCtrl',
						templateUrl : 'views/master/inventory/purchaseorderapproval/purchaseorderapprovalAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/purchaseorderapproval/purchaseorderapprovalAddCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.purchaseorderapproval-View',
					{
						url : '/master/inventory/purchaseorderapprovalView',
						data : {
							title : 'View'
						},
						controller : 'purchaseorderapprovalAddCtrl',
						templateUrl : 'views/master/inventory/purchaseorderapproval/purchaseorderapprovalView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/purchaseorderapproval/purchaseorderapprovalAddCtrl.js' ]);
									} ]
						}
					})
			// Purchase Order Ends

			// Cancel Purchase Order
			.state(
					'app.master.inventory.cancelpurchaseorder',
					{
						url : '/master/inventory/cancelpurchaseorderList',
						data : {
							title : 'Cancel Purchase Order'
						},
						controller : 'cancelpurchaseorderListCtrl',
						templateUrl : 'views/master/inventory/cancelpurchaseorder/cancelpurchaseorderList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/cancelpurchaseorder/cancelpurchaseorderListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.cancelpurchaseorder-Add',
					{
						url : '/master/inventory/cancelpurchaseorderAdd',
						data : {
							title : 'Add'
						},
						controller : 'cancelpurchaseorderAddCtrl',
						templateUrl : 'views/master/inventory/cancelpurchaseorder/cancelpurchaseorderAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/cancelpurchaseorder/cancelpurchaseorderAddCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.cancelpurchaseorder-View',
					{
						url : '/master/inventory/cancelpurchaseorderView',
						data : {
							title : 'View'
						},
						controller : 'cancelpurchaseorderAddCtrl',
						templateUrl : 'views/master/inventory/cancelpurchaseorder/cancelpurchaseorderView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/cancelpurchaseorder/cancelpurchaseorderAddCtrl.js' ]);
									} ]
						}
					})
			// Cancel Purchase Order Ends

			// Purchase Order Amendment
			.state(
					'app.master.inventory.purchaseorderamendment',
					{
						url : '/master/inventory/purchaseorderamendmentList',
						data : {
							title : 'Purchase Order Amendment'
						},
						controller : 'purchaseorderamendmentListCtrl',
						templateUrl : 'views/master/inventory/purchaseorderamendment/purchaseorderamendmentList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/purchaseorderamendment/purchaseorderamendmentListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.purchaseorderamendment-Add',
					{
						url : '/master/inventory/purchaseorderamendmentAdd',
						data : {
							title : 'Add'
						},
						controller : 'purchaseorderamendmentAddCtrl',
						templateUrl : 'views/master/inventory/purchaseorderamendment/purchaseorderamendmentAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/purchaseorderamendment/purchaseorderamendmentAddCtrl.js' ]);
									} ]
						}
					})
			// Purchase Order Amendment Ends

			// Manage Pending Purchase Order
			.state(
					'app.master.inventory.managependingorder',
					{
						url : '/master/inventory/managependingorderList',
						data : {
							title : 'Manage Pending Purchase Order'
						},
						controller : 'managependingorderListCtrl',
						templateUrl : 'views/master/inventory/managependingorder/managependingorderList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/managependingorder/managependingorderListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.managependingorder-Add',
					{
						url : '/master/inventory/managependingorderAdd',
						data : {
							title : 'Add'
						},
						controller : 'managependingorderAddCtrl',
						templateUrl : 'views/master/inventory/managependingorder/managependingorderAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/managependingorder/managependingorderAddCtrl.js' ]);
									} ]
						}
					})
			// Manage Pending Purchase Order Ends

			// Consignment Request
			.state(
					'app.master.inventory.consignmentrequest',
					{
						url : '/master/inventory/consignmentrequestList',
						data : {
							title : 'Consignment Request'
						},
						controller : 'consignmentrequestListCtrl',
						templateUrl : 'views/master/inventory/consignmentrequest/consignmentrequestList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/consignmentrequest/consignmentrequestListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.consignmentrequest-add',
					{
						url : '/master/inventory/consignmentrequestAdd',
						data : {
							title : 'Add'
						},
						controller : 'consignmentrequestAddCtrl',
						templateUrl : 'views/master/inventory/consignmentrequest/consignmentrequestAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/consignmentrequest/consignmentrequestAddCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.consignmentrequest-edit',
					{
						url : '/master/inventory/consignmentrequestEdit',
						data : {
							title : 'Edit'
						},
						controller : 'consignmentrequestAddCtrl',
						templateUrl : 'views/master/inventory/consignmentrequest/consignmentrequestAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/consignmentrequest/consignmentrequestAddCtrl.js' ]);
									} ]
						}
					})
			// Consignment Request
			// Consignment PO
			.state(
					'app.master.inventory.consignmentpo',
					{
						url : '/master/inventory/consignmentpoList',
						data : {
							title : 'Consignment PO'
						},
						controller : 'consignmentpoListCtrl',
						templateUrl : 'views/master/inventory/consignmentpo/consignmentpoList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/consignmentpo/consignmentpoListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.consignmentpo-add',
					{
						url : '/master/inventory/consignmentpoAdd',
						data : {
							title : 'Add'
						},
						controller : 'consignmentpoAddCtrl',
						templateUrl : 'views/master/inventory/consignmentpo/consignmentpoAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/consignmentpo/consignmentpoAddCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.consignmentpo-View',
					{
						url : '/master/inventory/consignmentpoView',
						data : {
							title : 'View'
						},
						controller : 'consignmentpoAddCtrl',
						templateUrl : 'views/master/inventory/consignmentpo/consignmentpoView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/consignmentpo/consignmentpoAddCtrl.js' ]);
									} ]
						}
					})
			// Consignment PO Ends
			// Stock In
			.state(
					'app.master.inventory.stockin',
					{
						url : '/master/inventory/stockin',
						data : {
							title : 'Stock In'
						},
						controller : 'stockinListCtrl',
						templateUrl : 'views/master/inventory/stockin/stockinList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/stockin/stockinListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.stockin-add',
					{
						url : '/master/inventory/stockin/add',
						data : {
							title : 'Add'
						},
						controller : 'stockinAddCtrl',
						templateUrl : 'views/master/inventory/stockin/stockinAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/stockin/stockinAddCtrl.js' ]);
									} ]
						}
					})
			.state(
					'app.master.inventory.stockin-edit',
					{
						url : '/master/inventory/stockin/edit/stockInId=:stockInId',
						data : {
							title : 'Edit'
						},
						controller : 'stockinAddCtrl',
						templateUrl : 'views/master/inventory/stockin/stockinAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/stockin/stockinAddCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.stockin-view',
					{
						url : '/master/inventory/stockin/view/stockInId=:stockInId',
						data : {
							title : 'View'
						},
						controller : 'stockinAddCtrl',
						templateUrl : 'views/master/inventory/stockin/stockInView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/stockin/stockinAddCtrl.js' ]);
									} ]
						}
					})

			// Stock In Ends

			// Stock Out
			.state(
					'app.master.inventory.stockout',
					{
						url : '/master/inventory/stockout',
						data : {
							title : 'Stock out'
						},
						controller : 'stockoutListCtrl',
						templateUrl : 'views/master/inventory/stockout/stockoutList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/stockout/stockoutListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.stockout-add',
					{
						url : '/master/inventory/stockoutAdd',
						data : {
							title : 'Add'
						},
						controller : 'stockoutAddCtrl',
						templateUrl : 'views/master/inventory/stockout/stockoutAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/stockout/stockoutAddCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.stockout-edit',
					{
						url : '/master/inventory/stockoutedit/stockOutId=:stockOutId',
						data : {
							title : 'Edit'
						},
						controller : 'stockoutAddCtrl',
						templateUrl : 'views/master/inventory/stockout/stockoutAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/stockout/stockoutAddCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.stockout-view',
					{
						url : '/master/inventory/stockoutview/stockOutId=:stockOutId',
						data : {
							title : 'View'
						},
						controller : 'stockoutAddCtrl',
						templateUrl : 'views/master/inventory/stockout/stockOutView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/stockout/stockoutAddCtrl.js' ]);
									} ]
						}
					})

			// Stock Out Ends
			// Request For Quotation

			.state(
					'app.master.inventory.requestquotation',
					{
						url : '/master/inventory/requestquotation',
						data : {
							title : 'Request For Quotation'
						},
						controller : 'requestquotationListCtrl',
						templateUrl : 'views/master/inventory/requestquotation/requestquotationList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/requestquotation/requestquotationListCtrl.js' ]);
									} ]
						}
					})
			.state(
					'app.master.inventory.requestquotation-add',
					{
						url : '/master/inventory/requestquotationAdd',
						data : {
							title : 'Add'
						},
						controller : 'requestquotationAddCtrl',
						templateUrl : 'views/master/inventory/requestquotation/requestquotationAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/requestquotation/requestquotationAddCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.requestquotation-view',
					{
						url : '/master/inventory/requestquotationView',
						data : {
							title : 'View'
						},
						controller : 'requestquotationViewCtrl',
						templateUrl : 'views/master/inventory/requestquotation/requestquotationView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/requestquotation/requestquotationViewCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.requestquotation-edit',
					{
						url : '/master/inventory/requestquotationEdit',
						data : {
							title : 'Edit'
						},
						controller : 'requestquotationViewCtrl',
						templateUrl : 'views/master/inventory/requestquotation/requestquotationEdit',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/requestquotation/requestquotationViewCtrl.js' ]);
									} ]
						}
					})

			// Request For Quotation Ends

			// Purchase Quoatation

			.state(
					'app.master.inventory.purchasequotation',
					{
						url : '/master/inventory/purchasequotation',
						data : {
							title : 'Purchase Quotation'
						},
						controller : 'purchasequotationListCtrl',
						templateUrl : 'views/master/inventory/purchasequotation/purchasequotationList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/purchasequotation/purchasequotationListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.purchasequotation-add',
					{
						url : '/master/inventory/purchasequotationAdd',
						data : {
							title : 'Add'
						},
						controller : 'purchasequotationAddCtrl',
						templateUrl : 'views/master/inventory/purchasequotation/purchasequotationAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/purchasequotation/purchasequotationAddCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.purchasequotation-edit',
					{
						url : '/master/inventory/purchasequotationEdit/quotationId=:quotationId',
						data : {
							title : 'Edit'
						},
						controller : 'purchasequotationAddCtrl',
						templateUrl : 'views/master/inventory/purchasequotation/purchasequotationAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/purchasequotation/purchasequotationAddCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.purchasequotation-view',
					{
						url : '/master/inventory/purchasequotationView/quotationId=:quotationId',
						data : {
							title : 'View'
						},
						controller : 'purchasequotationAddCtrl',
						templateUrl : 'views/master/inventory/purchasequotation/purchasequotationView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/purchasequotation/purchasequotationAddCtrl.js' ]);
									} ]
						}
					})
			// Purchase Quoatation Ends

			// Inventory
			.state(
					'app.master.inventory.inventoryValuation',
					{
						url : '/master/inventory/inventoryValuationList',
						data : {
							title : 'Inventory Valuation'
						},
						controller : 'inventoryvaluationListCtrl',
						templateUrl : 'views/master/inventory/inventoryvaluation/inventoryvaluationList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/inventoryvaluation/inventoryValuationListCtrl.js' ]);
									} ]
						}
					})

			// Stock Verification
			.state(
					'app.master.inventory.stockverification',
					{
						url : '/master/inventory/stockverificationList',
						data : {
							title : 'Stock Verification'
						},
						controller : 'stockverificationListCtrl',
						templateUrl : 'views/master/inventory/stockverification/stockverificationList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/stockVerification/stockVerificationListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.stockverification-add',
					{
						url : '/master/inventory/stockverificationAdd',
						data : {
							title : 'Add'
						},
						controller : 'stockverificationAddCtrl',
						templateUrl : 'views/master/inventory/stockverification/stockverificationAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/stockVerification/stockVerificationAddCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.stockverification-edit',
					{
						url : '/master/inventory/stockverificationedit/:stockVerificationNo/:ID',
						data : {
							title : 'Edit'
						},
						params : {
							stockVerificationNo : null,
							ID : null
						},
						controller : 'stockverificationEditCtrl',
						templateUrl : 'views/master/inventory/stockverification/stockverificationAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/stockVerification/stockVerificationAddCtrl.js' ]);
									} ]
						}
					})
			.state(
					'app.master.inventory.stockverification-view',
					{
						url : '/master/inventory/stockverificationview/:stockVerificationNo/:ID',
						data : {
							title : 'View'
						},
						params : {
							stockVerificationNo : null,
							ID : null

						},
						controller : 'stockverificationEditCtrl',
						templateUrl : 'views/master/inventory/stockverification/stockverificationView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/stockVerification/stockVerificationAddCtrl.js' ]);
									} ]
						}
					})
			// Stock Verification Approval
			.state(
					'app.master.inventory.verificationapproval',
					{
						url : '/master/inventory/stockverificationApproval',
						data : {
							title : 'Stock Verification Approval'
						},
						controller : 'verificationapprovalCtrl',
						templateUrl : 'views/master/inventory/verificationapproval/verificationapprovalList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/verificationapproval/verificationapprovalList.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.verificationapproval-add',
					{
						url : '/master/inventory/stockverificationApproval/Add/:stockVerificationNo',
						data : {
							title : 'Add'
						},
						controller : 'verificationapprovalAddCtrl',
						templateUrl : 'views/master/inventory/verificationapproval/stockverificationApproval',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/verificationapproval/verificationapprovalList.js' ]);
									} ]
						}
					})

			// Inventory Report
			.state(
					'app.master.inventory.inventoryreport',
					{
						url : '/master/inventory/inventoryreportList',
						data : {
							title : 'Inventory Report'
						},
						controller : 'inventoryreportListCtrl',
						templateUrl : 'views/master/inventory/inventoryreport/inventoryreportList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/inventoryreport/inventoryreportListCtrl.js' ]);
									} ]
						}
					})

			// Consumption Pattern
			.state(
					'app.master.inventory.consumptionpattern',
					{
						url : '/master/inventory/consumptionpatternList',
						data : {
							title : 'Consumption Pattern'
						},
						controller : 'consumptionpatternListCtrl',
						templateUrl : 'views/master/inventory/consumptionpattern/consumptionpatternList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/consumptionpattern/consumptionpatternListCtrl.js' ]);
									} ]
						}
					})

			// Stock Transfer
			.state(
					'app.master.inventory.stocktransfer',
					{
						url : '/master/inventory/stocktransfer',
						data : {
							title : 'Stock Transfer'
						},
						controller : 'stocktransferListCtrl',
						templateUrl : 'views/master/inventory/stocktransfer/stocktransferList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/stocktransfer/stocktransferListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.stocktransfer-add',
					{
						url : '/master/inventory/stocktransferAdd',
						data : {
							title : 'Add'
						},
						controller : 'stocktransferAddCtrl',
						templateUrl : 'views/master/inventory/stocktransfer/stocktransferAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/stocktransfer/stocktransferAddCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.stocktransfer-edit',
					{
						url : '/master/inventory/stocktransferEdit',
						data : {
							title : 'Edit'
						},
						controller : 'stocktransferEditCtrl',
						templateUrl : 'views/master/inventory/stocktransfer/stocktransferAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/stocktransfer/stocktransferEditCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.stocktransfer-view',
					{
						url : '/master/inventory/stocktransferview',
						data : {
							title : 'view'
						},
						controller : 'stocktransferEditCtrl',
						templateUrl : 'views/master/inventory/stocktransfer/stockMovementView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/stocktransfer/stocktransferEditCtrl.js' ]);
									} ]
						}
					})
			// Stock Transfer Ends

			// Stock Transfer Receive
			.state(
					'app.master.inventory.stocktransferreceive',
					{
						url : '/master/inventory/stocktransferreceive',
						data : {
							title : 'Stock Transfer Receive'
						},
						controller : 'stocktransferreceiveListCtrl',
						templateUrl : 'views/master/inventory/stocktransferreceive/stocktransferreceiveList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/stocktransferreceive/stocktransferreceiveListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.stocktransferreceive-add',
					{
						url : '/master/inventory/stocktransferreceiveAdd',
						data : {
							title : 'Add'
						},
						controller : 'stocktransferreceiveAddCtrl',
						templateUrl : 'views/master/inventory/stocktransferreceive/stocktransferreceiveAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/stocktransferreceive/stocktransferreceiveAddCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.stocktransferreceive-view',
					{
						url : '/master/inventory/stocktransferreceiveView',
						data : {
							title : 'View'
						},
						controller : 'stocktransferreceiveAddCtrl',
						templateUrl : 'views/master/inventory/stocktransferreceive/stocktransferreceiveView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/stocktransferreceive/stocktransferreceiveAddCtrl.js' ]);
									} ]
						}
					})
			// Stock Transfer Recevie Ends

					
					// Company

			.state('app.master.generalcompany', {
				abstract : true,
				templateUrl : "views/common.jsp",
				data : {
					title : 'Company Details'
				}
			})

			.state(
					'app.master.generalcompany.companydetails',
					{
						url : '/general/companydetails',
						data : {
							title : 'List'
						},

						controller : 'CompanyDetailsCtrl',
						templateUrl : 'views/master/general/CompanyDetails/CompanyDetailsListPage',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/general/CompanyDetails/CompanyDetailsCtrl.js' ]);
									} ]

						}
					})

			.state(
					'app.master.generalcompany.companydetails-add',
					{
						url : '/general/companydetails/add',
						data : {
							title : 'Add'
						},

						controller : 'CompanyDetailsAddCtrl',
						templateUrl : 'views/master/general/CompanyDetails/CompanyDetailsAddPage',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/general/CompanyDetails/CompanyDetailsAddCtrl.js' ]);
									} ]

						}
					})

			.state(
					'app.master.generalcompany.companydetails-edit',
					{
						url : '/general/companydetails/edit',
						data : {
							title : 'Edit'
						},

						controller : 'CompanyDetailsEditCtrl',
						templateUrl : 'views/master/general/CompanyDetails/CompanyDetailsAddPage',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/general/CompanyDetails/CompanyDetailsEditCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.generalcompany.companydetails-view',
					{
						url : '/general/companydetails/view',
						data : {
							title : 'View'
						},
						controller : 'CompanyDetailsEditCtrl',
						templateUrl : 'views/master/general/CompanyDetails/CompanyDetailsView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/general/CompanyDetails/CompanyDetailsEditCtrl.js' ])
									} ]
						}
					})

					
					
					
			// Consignment In
			.state(
					'app.master.inventory.consignmentin',
					{
						url : '/master/inventory/consignmentin',
						data : {
							title : 'Consignment In'
						},
						controller : 'consignmentinListCtrl',
						templateUrl : 'views/master/inventory/consignmentin/consignmentinList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/consignmentin/consignmentinListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.consignmentin-add',
					{
						url : '/master/inventory/consignmentinAdd',
						data : {
							title : 'Add'
						},
						controller : 'consignmentinAddCtrl',
						templateUrl : 'views/master/inventory/consignmentin/consignmentinAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/consignmentin/consignmentinAddCtrlCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.consignmentin-edit',
					{
						url : '/master/inventory/consignmentinEdit',
						data : {
							title : 'Edit'
						},
						controller : 'consignmentinAddCtrl',
						templateUrl : 'views/master/inventory/consignmentin/consignmentinAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/consignmentin/consignmentinAddCtrlCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.consignmentin-view',
					{
						url : '/master/inventory/consignmentinView',
						data : {
							title : 'View'
						},
						controller : 'consignmentinAddCtrl',
						templateUrl : 'views/master/inventory/consignmentin/consignmentinView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/consignmentin/consignmentinAddCtrlCtrl.js' ]);
									} ]
						}
					})
			// Consignment In Ends

			// Consignment Outgoing
			.state(
					'app.master.inventory.consignmentoutgoing',
					{
						url : '/master/inventory/consignmentoutgoingList',
						data : {
							title : 'Consignment Outgoing'
						},
						controller : 'consignmentoutgoingListCtrl',
						templateUrl : 'views/master/inventory/consignmentoutgoing/consignmentoutgoingList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/consignmentoutgoing/consignmentoutgoingListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.consignmentoutgoing-Add',
					{
						url : '/master/inventory/consignmentoutgoingAdd',
						data : {
							title : 'Add'
						},
						controller : 'consignmentoutgoingAddCtrl',
						templateUrl : 'views/master/inventory/consignmentoutgoing/consignmentoutgoingAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/consignmentoutgoing/consignmentoutgoingAddCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.consignmentoutgoing-Edit',
					{
						url : '/master/inventory/consignmentoutgoingEdit',
						data : {
							title : 'Edit'
						},
						controller : 'consignmentoutgoingAddCtrl',
						templateUrl : 'views/master/inventory/consignmentoutgoing/consignmentoutgoingAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/consignmentoutgoing/consignmentoutgoingAddCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.consignmentoutgoing-View',
					{
						url : '/master/inventory/consignmentoutgoingView',
						data : {
							title : 'View'
						},
						controller : 'consignmentoutgoingAddCtrl',
						templateUrl : 'views/master/inventory/consignmentoutgoing/consignmentOutView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/consignmentoutgoing/consignmentoutgoingAddCtrl.js' ]);
									} ]
						}
					})
			// Consignment Outgoing Ends

			// Consignment Transfer
			.state(
					'app.master.inventory.consignmenttransfer',
					{
						url : '/master/inventory/consignmenttransferList',
						data : {
							title : 'Consignment Transfer'
						},
						controller : 'consignmenttransferListCtrl',
						templateUrl : 'views/master/inventory/consignmenttransfer/consignmenttransferList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/consignmenttransfer/consignmenttransferListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.consignmenttransfer-add',
					{
						url : '/master/inventory/consignmenttransferAdd',
						data : {
							title : 'Add'
						},
						controller : 'consignmenttransferAddCtrl',
						templateUrl : 'views/master/inventory/consignmenttransfer/consignmenttransferAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/consignmenttransfer/consignmenttransferAddCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.consignmenttransfer-edit',
					{
						url : '/master/inventory/consignmenttransfereEdit',
						data : {
							title : 'Edit'
						},
						controller : 'consignmenttransferAddCtrl',
						templateUrl : 'views/master/inventory/consignmenttransfer/consignmenttransferAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/consignmenttransfer/consignmenttransferAddCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.consignmenttransfer-view',
					{
						url : '/master/inventory/consignmenttransferView',
						data : {
							title : 'View'
						},
						controller : 'consignmenttransferAddCtrl',
						templateUrl : 'views/master/inventory/consignmenttransfer/consignmenttransferView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/consignmenttransfer/consignmenttransferAddCtrl.js' ]);
									} ]
						}
					})
			// Consignment Transfer Ends

			// Consignment Transfer Receive
			.state(
					'app.master.inventory.consignmenttransferreceive',
					{
						url : '/master/inventory/consignmenttransferreceiveList',
						data : {
							title : 'Consignment Transfer Receive'
						},
						controller : 'consignmenttransferreceiveListCtrl',
						templateUrl : 'views/master/inventory/consignmenttransferreceive/consignmenttransferreceiveList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/consignmenttransferreceive/consignmenttransferreceiveListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.consignmenttransferreceive-add',
					{
						url : '/master/inventory/consignmenttransferreceiveAdd',
						data : {
							title : 'Add'
						},
						controller : 'consignmenttransferreceiveAddCtrl',
						templateUrl : 'views/master/inventory/consignmenttransferreceive/consignmenttransferreceiveAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/consignmenttransferreceive/consignmenttransferreceiveAddCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.consignmenttransferreceive-view',
					{
						url : '/master/inventory/consignmenttransferreceiview',
						data : {
							title : 'View'
						},
						controller : 'consignmenttransferreceiveAddCtrl',
						templateUrl : 'views/master/inventory/consignmenttransferreceive/consignmenttransferreceiveView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/consignmenttransferreceive/consignmenttransferreceiveAddCtrl.js' ]);
									} ]
						}
					})
			// Consignment Transfer Receive Ends

			// GRN
			.state(
					'app.master.inventory.grn',
					{
						url : '/master/inventory/grn',
						data : {
							title : 'GRN'
						},
						controller : 'grnListCtrl',
						templateUrl : 'views/master/inventory/grn/grnList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/grn/grnListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.grn-add',
					{
						url : '/master/inventory/grnAdd',
						data : {
							title : 'Add'
						},
						controller : 'grnAddCtrl',
						templateUrl : 'views/master/inventory/grn/grnAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/grn/grnAddCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.grn-view',
					{
						url : '/master/inventory/grnview',
						data : {
							title : 'View'
						},
						controller : 'grnAddCtrl',
						templateUrl : 'views/master/inventory/grn/grnview',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/grn/grnAddCtrl.js' ]);
									} ]
						}
					})

			// GRN Ends

			// Rate Contract
			.state(
					'app.master.inventory.ratecontract',
					{
						url : '/master/inventory/ratecontract',
						data : {
							title : 'Rate Contract'
						},
						controller : 'ratecontractListCtrl',
						templateUrl : 'views/master/inventory/ratecontract/ratecontractList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/ratecontract/ratecontractListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.ratecontract-Add',
					{
						url : '/master/inventory/ratecontractAdd',
						data : {
							title : 'Add'
						},
						controller : 'ratecontractAddCtrl',
						templateUrl : 'views/master/inventory/ratecontract/ratecontractAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/ratecontract/ratecontractAddCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.ratecontract-edit',
					{
						url : '/master/inventory/ratecontractEdit',
						data : {
							title : 'Edit'
						},
						controller : 'ratecontractAddCtrl',
						templateUrl : 'views/master/inventory/ratecontract/ratecontractEdit',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/ratecontract/ratecontractAddCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.ratecontract-view',
					{
						url : '/master/inventory/ratecontractview',
						data : {
							title : 'View'
						},
						controller : 'ratecontractAddCtrl',
						templateUrl : 'views/master/inventory/ratecontract/ratecontractView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/ratecontract/ratecontractAddCtrl.js' ]);
									} ]
						}
					})

			// Rate Contract Ends

			// Manage Vendor

			.state(
					'app.master.inventory.managevendor',
					{
						url : '/master/inventory/managevendor',
						data : {
							title : 'Manage Vendor'
						},
						controller : 'managevendorListCtrl',
						templateUrl : 'views/master/inventory/managevendor/managevendorList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/managevendor/managevendorListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.managevendor-add',
					{
						url : '/master/inventory/managevendorAdd',
						data : {
							title : 'Add'
						},
						controller : 'managevendorAddCtrl',
						templateUrl : 'views/master/inventory/managevendor/managevendorAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/managevendor/managevendorAddCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.managevendor-edit',
					{
						url : '/master/inventory/managevendoredit/:entityId',
						data : {
							title : 'Edit'
						},
						controller : 'managevendorAddCtrl',
						templateUrl : 'views/master/inventory/managevendor/managevendorAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/managevendor/managevendorAddCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.managevendor-addbank',
					{
						url : '/master/inventory/managevendoredit/addbank',
						data : {
							title : 'Add'
						},
						controller : 'managevendorAddCtrl',
						templateUrl : 'views/master/inventory/managevendor/managevendorbankAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/managevendor/managevendorAddCtrl.js' ]);
									} ]
						}
					})
			// Manage Vendor Ends

			// Quality check

			.state(
					'app.master.inventory.qualitycontrol',
					{
						url : '/master/inventory/qualitycontrol',
						data : {
							title : 'Quality Check'
						},
						controller : 'qualitycontrolListCtrl',
						templateUrl : 'views/master/inventory/qualitycontrol/qualitycontrolList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/qualitycontrol/qualitycontrolListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.inventory.qualitycontrol-Add',
					{
						url : '/master/inventory/qualitycontrolAdd',
						data : {
							title : 'Add'
						},
						controller : 'qualitycontrolAddCtrl',
						templateUrl : 'views/master/inventory/qualitycontrol/qualitycontrolAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/inventor/qualitycontrol/qualitycontrolAddCtrl.js' ]);
									} ]
						}
					})
			// Quality check Ends

			.state(
					'app.master.general.vehiclemenu.vehiclesubmenu',
					{
						url : '/master/general/vehicle',
						data : {
							title : 'Vehicle'
						},
						controller : 'vehicleCtrl',
						templateUrl : 'views/master/vehicle/vehicleList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/general/vehicle/vehicleListCtrl.js' ]);
									} ]
						}
					})
			.state(
					'app.master.general.vehiclemenu.vehiclesubmenuadd',
					{
						url : '/master/general/vehicle/add',
						data : {
							title : 'Vehicle'
						},
						controller : 'vehicleaddCtrl',
						templateUrl : 'views/master/vehicle/vehicleAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/general/vehicle/vehicleAddCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.general.manufacturermenu.manufacturersubmenu',
					{
						url : '/master/general/manufacturer',
						data : {
							title : 'Manufacturer'
						},
						controller : 'manufacturerCtrl',
						templateUrl : 'views/master/manufacturer/manufacturerList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/general/manufacturer/manufacturerListCtrl.js' ]);
									} ]
						}
					})
			.state(
					'app.master.general.manufacturermenu.manufacturersubmenuadd',
					{
						url : '/master/general/manufacturer/add',
						data : {
							title : 'Manufacturer'
						},
						controller : 'manufactureraddCtrl',
						templateUrl : 'views/master/manufacturer/manufacturerAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/general/manufacturer/manufacturerAddCtrl.js' ]);
									} ]
						}
					})
	$stateProvider
			.state('app.truck', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Truck'
				}
			})

			.state(
					'app.truck.tracking',
					{
						url : '/tracking',
						data : {
							title : 'Tracking'
						},
						controller : 'scaniaCtrl',
						templateUrl : 'views/master/tracking/tracking',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/tracking/custom.js' ]);
									} ]
						}
					})

			.state(
					'app.truck.trackingMove',
					{
						url : '/trackingHistory',
						data : {
							title : 'Tracking History'
						},
						controller : 'scaniaTracking',
						templateUrl : 'views/master/tracking/trackingMove',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/tracking/customplay.js' ]);
									} ]
						}
					})

			// .state('app.truck.Singletracking', {
			// url : '/singletrack',
			// data : {
			// pageTitle : 'Single Tracking'
			// },
			// controller : 'trackSingleTruckCtrl',
			// templateUrl : 'views/master/tracking/singleTruckTrack',
			// })

			.state('app.truck.fuel', {
				url : '/fuel',
				data : {
					title : 'Fuel'
				},
				controller : 'scaniaCtrl',
				templateUrl : 'views/master/tracking/tracking',
			})
			/*
			 * .state('app.truck.ignition', { url : '/ignition', data : { title :
			 * 'Ignition' }, controller : 'scaniaCtrl', templateUrl :
			 * 'views/master/tracking/tracking', })
			 */
			// /ignitionreport
			.state(
					'app.truck.ignition',
					{
						url : '/ignition',
						data : {
							title : 'Ignition & Odometer Report'
						},
						templateUrl : 'views/master/tracking/Ignition',
						controller : 'scaniaCtrl',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/tracking/scaniaCtrl.js' ]);
									} ]
						}

					})
			.state('app.truck.speed', {
				url : '/speed',
				data : {
					title : 'Speed'
				},
				controller : 'scaniaCtrl',
				templateUrl : 'views/master/tracking/tracking',
			})
			.state(
					'app.truck.constatusreport',
					{
						url : '/constatusreport',
						data : {
							title : 'Consolidated Status Report'
						},
						templateUrl : 'views/master/tracking/consolidatedStatusReport',
						controller : 'trakingReportCtrl',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/tracking/trackingReport.js' ]);
									} ]
						}

					})
			.state(
					'app.truck.vehicleexception',
					{
						url : '/vehicleException',
						data : {
							title : 'Vehicle Exception'
						},
						templateUrl : 'views/master/tracking/vehicleException',
						controller : 'vehicleExceptionCtrl',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/tracking/vehicleExceptionCtrl.js' ]);
									} ]
						}

					})
			

			.state('app.master.generaldesignation', {
				abstract : true,
				templateUrl : "views/common.jsp",
				data : {
					title : 'Designation'
				}
			})
			.state(
					'app.master.generaldesignation.designation',
					{
						url : '/designation',
						data : {
							title : 'List'
						},

						controller : 'designationCtrl',
						templateUrl : 'views/master/designation/designationList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/general/designation/designationCtrl.js' ]);
									} ]
						}

					})
			.state(
					'app.master.generaldesignation.designationadd-Add',
					{
						url : '/designation/add',
						data : {
							title : ' Add'
						},

						controller : 'designationAddCtrl',
						templateUrl : 'views/master/designation/designationAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/general/designation/designationAddCtrl.js' ]);
									} ]

						}
					})

			.state(
					'app.master.generaldesignation.designationedit-Edit',
					{
						url : '/designation/edit',
						data : {
							title : ' Edit'
						},

						controller : 'designationAddCtrl',
						templateUrl : 'views/master/designation/designationAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/general/designation/designationAddCtrl.js' ]);
									} ]

						}
					})

			.state(
					'app.master.generaldesignation.designationview-view',
					{
						url : '/designation/view',
						data : {
							title : ' View'
						},

						controller : 'designationAddCtrl',
						templateUrl : 'views/master/designation/designationView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/general/designation/designationAddCtrl.js' ]);
									} ]

						}
					})

				



			// SpareParts
			.state(
					'app.master.spareParts',

					{
						url : '/master/general/spareparts',
						data : {
							title : 'Spare Parts'
						},
						controller : 'sparepartslistctrl',
						templateUrl : 'views/finance/controlscreen/taxchargees/sparepartslist',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/taxcharges/sparepartssListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.spareParts-add',

					{
						url : '/master/general/spareparts/add',
						data : {
							title : 'Add'
						},
						controller : 'sparepartsaddctrl',
						templateUrl : 'views/finance/controlscreen/taxchargees/sparepartsadd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/taxcharges/sparepartsaddCtrl.js' ])
									} ]
						}
					})

			.state(
					'app.master.spareParts-edit',

					{
						url : '/master/general/spareparts/edit/:itemId',
						data : {
							title : 'Edit'
						},
						controller : 'manageItemEditCtrl',
						templateUrl : 'views/finance/controlscreen/taxchargees/sparepartsadd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/taxcharges/sparepartsaddCtrl.js' ])
									} ]
						}
					})

			// /UOM Catagory
			.state(
					'app.master.uomcategory',
					{
						url : '/master/general/uomcategory',
						data : {
							title : 'UOM Catagory'
						},
						controller : 'UOMCategoryCtrl',
						templateUrl : 'views/master/uomCategory/uomCategoryList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/uomcategory/UOMCategoryCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.uomcategory-add',
					{
						url : '/master/general/uomcategory/add',
						data : {
							title : 'Add'
						},
						controller : 'UOMCategoryCtrl',
						templateUrl : 'views/master/uomCategory/UOMCategoryAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/uomcategory/UOMCategoryCtrl.js' ])
									} ]
						}
					})

			.state(
					'app.master.uomcategory-edit',
					{
						url : '/master/general/uomcategory/edit/:uomId',
						data : {
							title : 'Edit'
						},
						controller : 'UOMCategoryEditCtrl',
						templateUrl : 'views/master/uomCategory/UOMCategoryAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/uomcategory/UOMCategoryCtrl.js' ])
									} ]
						}
					})
			// UOM Catagory end

			// /ManageUOM
			.state(
					'app.master.manageuom',
					{
						url : '/master/general/manageuom',
						data : {
							title : 'Manage UOM'
						},
						controller : 'manageUOMCtrl',
						templateUrl : 'views/master/manageUom/uomList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/inventory/manageUOM/manageUOMCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.manageuom-add',
					{
						url : '/master/general/manageuom/add',
						data : {
							title : 'Add'
						},
						controller : 'manageUOMCtrl',
						templateUrl : 'views/master/manageUom/manageUOMAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/inventory/manageUOM/manageUOMCtrl.js' ])
									} ]
						}
					})

			.state(
					'app.master.manageuom-edit',
					{
						url : '/master/general/manageuom/edit/:uomId',
						data : {
							title : 'Edit'
						},
						controller : 'manageUOMEditCtrl',
						templateUrl : 'views/master/manageUom/manageUOMAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/inventory/manageUOM/manageUOMCtrl.js' ])
									} ]
						}
					})
			// Manage UOM END

			// ///ManageItemCatagory

			.state(
					'app.master.itemcategory',
					{
						url : '/master/general/manageitemcategory/list',
						data : {
							title : 'Item Category'
						},
						controller : 'itemCategoryListCtrl',
						templateUrl : 'views/master/itemcategory/itemCategoryList',

						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/inventory/itemcategory/itemCategoryCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.master.itemcategory-add',
					{
						url : '/master/general/manageitemcategory/add',
						data : {
							title : 'Add'
						},
						controller : 'itemCategoryAddCtrl',
						templateUrl : 'views/master/itemcategory/itemCategoryItemAdd',

						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/inventory/itemcategory/itemCategoryAddCtrl.js' ])
									} ]
						}
					})

			.state(
					'app.master.itemcategory-edit',
					{
						url : '/hospital/inventory/manageitemcategory/edit/:itemCategoryId',
						data : {
							title : 'Edit'
						},
						controller : 'itemCategoryEditCtrl',
						templateUrl : 'views/master/itemcategory/itemCategoryItemAdd',

						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/inventory/itemcategory/itemCategoryAddCtrl.js' ])
									} ]
						}
					})

			.state(
					'app.master.itemcategory-addItem',
					{
						url : '/hospital/inventory/manageitemcategory/addItem',
						data : {
							title : 'Add'
						},
						views : {
							"content@app" : {
								controller : 'itemCategoryAddItemCtrl',
								templateUrl : 'views/master/itemcategory/itemCategoryAddItem',

								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/finance/inventory/itemcategory/itemCategoryAddCtrl.js' ])
											} ]
								}
							}
						}
					})

			.state(
					'app.master.itemcategory-parentTree',
					{
						url : '/hospital/inventory/manageitemcategory/parentTree',
						data : {
							title : 'Add'
						},
						views : {
							"content@app" : {
								controller : 'itemCategoryAddParentCtrl',
								templateUrl : 'views/master/itemcategory/parentCategoryAdd',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/finance/inventory/itemcategory/itemCategoryAddCtrl.js' ])
											} ]
								}
							}
						}
					})

			// // end of manage item catagory

			// .state('app.master.general.distance', {
			// url : '/general/distance',
			// data : {
			// title : 'Distance'
			// },
			// controller : 'distanceCtrl',
			// templateUrl : 'views/master/general/Distance/distanceList',
			// resolve : {
			// deps : [ '$ocLazyLoad', function($ocLazyLoad) {
			// return $ocLazyLoad.load([
			// 'js/app/master/general/Distance/distanceCtrl.js' ]);
			// } ]
			// }
			// })
			//
			// .state('app.master.general.distance-Add', {
			// url : '/general/distance/add',
			// data : {
			// title : 'Add'
			// },
			// controller : 'distanceAddCtrl',
			// templateUrl : 'views/master/general/Distance/distanceAdd',
			// resolve : {
			// deps : [ '$ocLazyLoad', function($ocLazyLoad) {
			// return $ocLazyLoad.load([
			// 'js/app/master/general/Distance/distanceAddCtrl.js' ]);
			// } ]
			// }
			// }).state('app.master.general.distance-Edit', {
			// url : '/general/distance/edit',
			// data : {
			// title : 'Distance Edit'
			// },
			// controller : 'distanceAddCtrl',
			// templateUrl : 'views/master/general/Distance/distanceAdd',
			// resolve : {
			// deps : [ '$ocLazyLoad', function($ocLazyLoad) {
			// return $ocLazyLoad.load([
			// 'js/app/master/general/Distance/distanceAddCtrl.js' ]);
			// } ]
			// }
			//
			// }).state('app.master.general.distance-View', {
			// url : '/general/distance/view',
			// data : {
			// title : 'Distance View'
			// },
			// controller : 'distanceAddCtrl',
			// templateUrl : 'views/master/general/Distance/distanceView',
			// resolve : {
			// deps : [ '$ocLazyLoad', function($ocLazyLoad) {
			// return $ocLazyLoad.load([
			// 'js/app/master/general/Distance/distanceAddCtrl.js' ]);
			// } ]
			// }
			// })
			.state(
					'app.master.general.distance',
					{
						url : '/general/distance',
						data : {
							title : 'Distance'
						},
						controller : 'distanceCtrl',
						templateUrl : 'views/master/general/Distance/distanceList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/general/Distance/distanceCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.general.distance-Add',
					{
						url : '/general/distance/add',
						data : {
							title : 'Add'
						},
						controller : 'distanceAddCtrl',
						templateUrl : 'views/master/general/Distance/distanceAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/general/Distance/distanceAddCtrl.js' ]);
									} ]
						}
					})
			.state(
					'app.master.general.distance-Edit',
					{
						url : '/general/distance/edit',
						data : {
							title : 'Distance Edit'
						},
						controller : 'distanceAddCtrl',
						templateUrl : 'views/master/general/Distance/distanceAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/general/Distance/distanceAddCtrl.js' ]);
									} ]
						}

					})
			.state(
					'app.master.general.distance-View',
					{
						url : '/general/distance/view',
						data : {
							title : 'Distance View'
						},
						controller : 'distanceAddCtrl',
						templateUrl : 'views/master/general/Distance/distanceView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/general/Distance/distanceAddCtrl.js' ]);
									} ]
						}

					})

			// branch
			.state(
					'app.truck.general.branch.branchlist',
					{
						url : '/brach/branchlist',
						data : {
							title : 'List'
						},
						controller : 'branchListCtrl',
						templateUrl : 'views/master/branch/branchList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/general/branch/branchCtrl.js' ]);
									} ]
						}
					})

			// console error

			.state(
					'app.master.general.consoleerror.list',
					{
						url : '/consolerror/consolerrorlist',
						data : {
							title : 'List'
						},
						controller : 'consolerrorListCtrl',
						templateUrl : 'views/master/consoleError/consolErrorList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/general/consoleError/consolerrorListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.truck.general.branch.branchadd',
					{
						url : '/brach/branchadd',
						data : {
							title : 'Add'
						},
						controller : 'branchAddCtrl',
						templateUrl : 'views/master/branch/branchAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/general/branch/branchCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.truck.general.branch.branchedit',
					{
						url : '/brach/branchedit',
						data : {
							title : 'Edit'
						},

						controller : 'branchAddCtrl',
						templateUrl : 'views/master/branch/branchAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/general/branch/branchCtrl.js' ]);
									} ]

						}
					})

			.state(
					'app.truck.general.branch.view',
					{
						url : '/brach/branchView',
						data : {
							title : 'View'
						},
						controller : 'branchAddCtrl',
						templateUrl : 'views/master/branch/branchView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/general/branch/branchCtrl.js' ])
									} ]
						}

					})

			// Line
			.state(
					'app.master.general.line.linelist',
					{
						url : '/line/linelist',
						data : {
							title : 'List'
						},
						controller : 'lineListCtrl',
						templateUrl : 'views/master/line/lineList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/general/line/lineCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.general.line.lineadd',
					{
						url : '/line/lineadd',
						data : {
							title : 'Add'
						},
						controller : 'lineAddCtrl',
						templateUrl : 'views/master/line/lineAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/general/line/lineCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.master.general.line.lineedit',
					{
						url : '/line/lineedit',
						data : {
							title : 'Edit'
						},

						controller : 'lineAddCtrl',
						templateUrl : 'views/master/line/lineAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/general/line/lineCtrl.js' ]);
									} ]

						}
					})

			.state(
					'app.master.general.line.view',
					{
						url : '/line/lineView',
						data : {
							title : 'View'
						},
						controller : 'lineAddCtrl',
						templateUrl : 'views/master/line/lineView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/general/line/lineCtrl.js' ])
									} ]
						}

					})

			
			.state(
					'app.master.replacementplanner',
					{

						url : '/replacementplanner',
						data : {
							title : 'Replacement Planner'
						},

						controller : 'replacementplannerCtrl',
						templateUrl : '/views/master/replacementplanner/replacementplannerList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/replacementplanner/replacementplannerCtrl.js' ]);
									} ]
						}

					})
			.state(
					'app.master.replacementplanner-Add',
					{
						url : '/replacementplanner/add',
						data : {
							title : 'Add'
						},

						controller : 'replacementplannerAddCtrl',
						templateUrl : 'views/master/replacementplanner/replacementplannerAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/replacementplanner/replacementplannerAddCtrl.js' ]);
									} ]

						}
					})

			.state(
					'app.master.replacementplanner-Edit',
					{
						url : '/replacementplanner/edit',
						data : {
							title : 'Edit'
						},

						controller : 'replacementplannerAddCtrl',
						templateUrl : 'views/master/replacementplanner/replacementplannerAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/replacementplanner/replacementplannerAddCtrl.js' ]);
									} ]

						}
					})

			.state(
					'app.master.replacementplanner-View',
					{
						url : '/replacementplanner/view',
						data : {
							title : 'View'
						},

						controller : 'replacementplannerAddCtrl',
						templateUrl : 'views/master/replacementplanner/replacementplannerView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/replacementplanner/replacementplannerAddCtrl.js' ]);
									} ]

						}
					})

	$stateProvider
			.state('app.master.offtiming', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Off-Timing Configuration'
				}
			})

			.state(
					'app.master.offtiming.periodScheduleList',
					{
						url : '/schedule/list',
						data : {
							title : 'List'
						},
						controller : 'scheduleListCtrl',
						templateUrl : 'views/master/schedule/periodScheduleList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/schedule/periodScheduleList.js' ])
									} ]
						}

					})

			.state(
					'app.master.offtiming.periodScheduleAdd',
					{
						url : '/schedule/add',
						data : {
							title : 'Add'
						},
						controller : 'scheduleAddCtrl',
						templateUrl : 'views/master/schedule/periodScheduleAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/schedule/periodScheduleAddCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.master.offtiming.periodScheduleEdit',
					{
						url : '/schedule/edit',
						data : {
							title : 'Edit'
						},
						controller : 'scheduleAddCtrl',
						templateUrl : 'views/master/schedule/periodScheduleAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/schedule/periodScheduleAddCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.master.attendance.attendanceReport',
					{
						url : '/attendance/attendanceReport',
						data : {
							title : ''
						},
						controller : 'attendanceReportCtrl',
						templateUrl : 'views/master/attendance/attendanceReport',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/attendance/attendanceReportCtrl.js' ]);
									} ]
						}
					})

			// driverperformance

			.state(
					'app.truck.driverperformancereport',
					{
						url : '/driverPerformancereport',
						data : {
							title : 'Driver Performance Report'
						},
						templateUrl : 'views/master/tracking/driverPerformancereport',
						controller : 'driverPerformancereportCtrl',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/tracking/driverPerformancereportCtrl.js' ]);
									} ]
						}

					})

			// update password

			.state(
					'app.master.update',
					{
						url : '/userupdate',
						data : {
							title : 'Update Profile Details'
						},
						controller : 'empmasterUpdateCtrl',
						templateUrl : 'views/master/empmaster/empmasterUpdate',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/empmaster/empmasterAddCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.updatepwd',
					{
						url : '/userupdatepwd',
						data : {
							title : 'Change Password'
						},
						controller : 'empmasterUpdateCtrl',
						templateUrl : '/views/master/empmaster/empmasterPwdUpdate',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/empmaster/empmasterAddCtrl.js' ]);
									} ]
						}
					})

			// resetpassword --ADMIN
			.state(
					'app.master.resetpassword',
					{
						url : '/reset/password',
						data : {
							title : 'Reset Password'
						},
						controller : 'resetPassWordCtrl',
						templateUrl : '/views/resetPassword/resetPassword',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/resetPassword/resetPasswordCtrl.js' ]);
									} ]
						}

					})
			.state(
					'app.master.general.changepassword',
					{
						url : '/changePassword',
						data : {
							title : 'Change Password'
						},
						controller : 'changePasswordCtrl',
						templateUrl : 'views/master/changepassword/changepassword',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/changepassword/changePasswordCtrl.js' ]);
									} ]
						}
					})


	$stateProvider
			.state('app.crm', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'CRM'
				}
			})
			.state('app.crm.calldetails', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Call Details'
				}
			})

			// call details
			.state(
					'app.crm.calldetails.list',
					{
						url : '/master/calldetails/list',
						data : {
							title : 'List'
						},
						controller : 'calldetailslistCtrl',
						templateUrl : 'views/master/calldetails/calldetailsList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/calldetails/calldetailsListCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.crm.calldetails.add',
					{
						url : '/master/calldetails/add',
						data : {
							title : 'Add'
						},
						controller : 'calldetailsaddCtrl',
						templateUrl : 'views/master/calldetails/calldetailsAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/calldetails/calldetailsAddCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.crm.calldetails.edit',
					{
						url : '/master/calldetails/edit',
						data : {
							title : 'Edit'
						},
						controller : 'calldetailseditCtrl',
						templateUrl : 'views/master/calldetails/calldetailsAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/calldetails/calldetailsAddCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.crm.calldetails.view',
					{
						url : '/master/calldetails/view',
						data : {
							title : 'View'
						},
						controller : 'callDetailsViewCtrl',
						templateUrl : 'views/master/calldetails/callDetailsView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/calldetails/calldetailsAddCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.crm.calldetails.report',
					{
						url : '/master/calldetails/Report',
						data : {
							title : 'Sales Report'
						},
						controller : 'crmSalesReport',
						templateUrl : 'views/master/calldetails/crmSalesReport',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/calldetails/crmSalesReport.js' ])
									} ]
						}

					})

			.state(
					'app.truck.general.grade.gradeview',
					{
						url : '/grade/gradeview',
						data : {
							title : 'View'
						},
						controller : 'gradeAdminAddCtrl',
						templateUrl : 'views/master/grade/gradeView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/general/grade/gradeAdminCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.crm.calldetails.reportPlan',
					{
						url : '/master/calldetails/Sales Plan',
						data : {
							title : 'Sales Plan'
						},
						controller : 'crmSalesReportPlan',
						templateUrl : 'views/master/calldetails/crmSalesPlan',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/calldetails/crmSalesPlan.js' ])
									} ]
						}

					})
			.state('app.crm.salesMeeting', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Call Details'
				}
			})
			.state(
					'app.crm.salesMeeting.salesMeetingReport',
					{
						url : '/master/salesMeeting/salesMeetingReport',
						data : {
							title : 'Sales Meeting Report'
						},
						controller : 'crmSalesMeetingCtrl',
						templateUrl : 'views/master/salesMeeting/salesMeetingReport',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/salesMeeting/salesMeetingReport.js' ])
									} ]
						}

					})

			// password
			.state(
					'app.master.general.userpassword',
					{
						url : '/general/userpasswordlist',
						data : {
							title : 'List'
						},
						controller : 'userpasswordlistCtrl',
						templateUrl : 'views/master/passwordList/passwordList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/passwordList/passwordListCtrl.js' ]);
									} ]
						}
					})

			// scheduler

			.state(
					'app.master.scheduler.scheduler',
					{
						url : '/scheduler/scheduler',
						data : {
							title : 'Scheduler List'
						},
						controller : 'schedulerCtrl',
						templateUrl : 'views/master/scheduler/scheduler',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/scheduler/scheduler.js' ]);
									} ]
						}
					})

			/*// ContainerLeaseAgreement
			.state(
					'app.eqs.containerLeaseAgreement.containerLeaseAgreementList',
					{
						url : '/containerLeaseAgreement/containerLeaseAgreementList',
						data : {
							title : 'List'
						},
						controller : 'containerLeaseAgreementListCtrl',
						templateUrl : 'views/eqs/containerLeaseAgreement/containerLeaseAgreementList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/containerLeaseAgreement/containerLeaseAgreementListCtrl.js' ]);
									} ]
						}
					})
			.state(
					'app.eqs.containerLeaseAgreement.containerLeaseAgreementAdd',
					{
						url : '/eqs/containerLeaseAgreement/Add',
						data : {
							title : 'Add'
						},
						controller : 'containerLeaseAgreementAddCtrl',
						templateUrl : 'views/eqs/containerLeaseAgreement/containerLeaseAgreementAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/containerLeaseAgreement/containerLeaseAgreementAddCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.eqs.containerLeaseAgreement.containerLeaseAgreementEdit',
					{
						url : '/eqs/containerLeaseAgreement/Edit',
						data : {
							title : 'Edit'
						},

						controller : 'containerLeaseAgreementAddCtrl',
						templateUrl : 'views/eqs/containerLeaseAgreement/containerLeaseAgreementAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/containerLeaseAgreement/containerLeaseAgreementAddCtrl.js' ]);
									} ]

						}
					})

			// ContainerOnHireRelease
			.state(
					'app.eqs.onHireRelease.list',
					{
						url : '/eqs/onHireRelease/list',
						data : {
							title : 'List'
						},
						controller : 'onHireReleaseListCtrl',
						templateUrl : 'views/eqs/onHireRelease/onHireReleaseList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/onHireRelease/onHireReleaseListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.eqs.onHireRelease.add',
					{
						url : '/eqs/onHireRelease/add',
						data : {
							title : 'Add'
						},
						controller : 'onHireReleaseAddCtrl',
						templateUrl : 'views/eqs/onHireRelease/onHireReleaseAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/onHireRelease/onHireReleaseAddCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.eqs.onHireRelease.edit',
					{
						url : '/eqs/onHireRelease/edit',
						data : {
							title : 'Edit'
						},

						controller : 'onHireReleaseAddCtrl',
						templateUrl : 'views/eqs/onHireRelease/onHireReleaseAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/onHireRelease/onHireReleaseAddCtrl.js' ]);
									} ]

						}
					})*/

			// containerOffHire
			.state(
					'app.eqs.containerOffHire.list',
					{
						url : '/eqs/containerOffHire/list',
						data : {
							title : 'List'
						},
						controller : 'containerOffHireListCtrl',
						templateUrl : 'views/eqs/containerOffHire/containerOffHireList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/containerOffHire/containerOffHireList.js' ]);
									} ]
						}
					})

			.state(
					'app.eqs.containerOffHire.add',
					{
						url : '/eqs/containerOffHire/add',
						data : {
							title : 'Add'
						},
						controller : 'containerOffHireAddCtrl',
						templateUrl : 'views/eqs/containerOffHire/containerOffHireAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/containerOffHire/containerOffHireAdd.js' ])
									} ]
						}

					})

			.state(
					'app.eqs.containerOffHire.edit',
					{
						url : '/eqs/containerOffHire/edit',
						data : {
							title : 'Edit'
						},

						controller : 'containerOffHireAddCtrl',
						templateUrl : 'views/eqs/containerOffHire/containerOffHireAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/containerOffHire/containerOffHireAdd.js' ]);
									} ]

						}
					})
					
					
					//MRG					
					.state(
						'app.master.mrg.list',
						{
							url : '/marketing/mrg',
							data : {
								title : 'List'
							},
							controller : 'mrgListCtrl',
							templateUrl : 'views/salesmarketing/mrg/mrgList',
							resolve : {
								deps : [
										'$ocLazyLoad',
										function($ocLazyLoad) {
											return $ocLazyLoad
													.load([ 'js/app/salesmarketing/mrg/mrgListCtrl.js' ]);
										} ]
							}
						})
						
						.state(
						'app.master.mrg.add',
						{
							url : '/marketing/mrg/add',
							data : {
								title : 'Add'
							},
							controller : 'mrgAddCtrl',
							templateUrl : 'views/salesmarketing/mrg/mrgAdd',
							resolve : {
								deps : [
										'$ocLazyLoad',
										function($ocLazyLoad) {
											return $ocLazyLoad
													.load([ 'js/app/salesmarketing/mrg/mrgAddCtrl.js' ]);
										} ]
							}
						})
						
						.state(
						'app.master.mrg.edit',
						{
							url : '/marketing/mrg/edit?mrgId',
							data : {
								title : 'Edit'
							},
							controller : 'mrgAddCtrl',
							templateUrl : 'views/salesmarketing/mrg/mrgAdd',
							resolve : {
								deps : [
										'$ocLazyLoad',
										function($ocLazyLoad) {
											return $ocLazyLoad
													.load([ 'js/app/salesmarketing/mrg/mrgAddCtrl.js' ]);
										} ]
							}
						})
						
						.state(
						'app.master.mrg.view',
						{
							url : '/marketing/mrg/view?mrgId',
							data : {
								title : 'View'
							},
							controller : 'mrgViewCtrl',
							templateUrl : 'views/salesmarketing/mrg/mrgView',
							resolve : {
								deps : [
										'$ocLazyLoad',
										function($ocLazyLoad) {
											return $ocLazyLoad
													.load([ 'js/app/salesmarketing/mrg/mrgAddCtrl.js' ]);
										} ]
							}
						})
						
						.state(
						'app.master.mrg.copy',
						{
							url : '/marketing/mrg/copy',
							data : {
								title : 'Add'
							},
							controller : 'mrgAddCtrl',
							templateUrl : 'views/salesmarketing/mrg/mrgAdd',
							resolve : {
								deps : [
										'$ocLazyLoad',
										function($ocLazyLoad) {
											return $ocLazyLoad
													.load([ 'js/app/salesmarketing/mrg/mrgAddCtrl.js' ]);
										} ]
							}
						})

			// Damage Report
			.state('app.eqs.damageRecord', {
				abstract : true,
				templateUrl : "views/common.jsp",
				data : {
					title : 'Damage Record'
				}
			})

			// Commodity Description list
			.state(
					'app.master.commodity.list',
					{
						url : '/master/commodity/list',
						data : {
							title : 'List'
						},
						controller : 'commodityListCtrl',
						templateUrl : 'views/master/commodity/commodityList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/commodity/commodityListCntrl.js' ])
									} ]
						}

					})
					
					
			// commodity add
			.state(
					'app.master.commodity.add',
					{
						url : '/master/commodity/add',
						data : {
							title : 'Add'
						},
						controller : 'commodityAddCtrl',
						templateUrl : 'views/master/commodity/commodityAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/commodity/commodityAddCntrl.js' ])
									} ]
						}

					})
			// commodity edit
			.state(
					'app.master.commodity.edit',
					{
						url : '/master/commodity/edit',
						data : {
							title : 'Edit'
						},
						controller : 'commodityAddCtrl',
						templateUrl : 'views/master/commodity/commodityAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/commodity/commodityAddCntrl.js' ])
									} ]
						}

					})

			.state(
					'app.master.commodity.view',
					{
						url : '/master/commodity/view',
						data : {
							title : 'View'
						},
						controller : 'commodityAddCtrl',
						templateUrl : 'views/master/commodity/commodityView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/commodity/commodityAddCntrl.js' ])
									} ]
						}

					})

			// commodity classification list
			.state(
					'app.master.commodityclassification.list',
					{
						url : '/master/commodityclassification/list',
						data : {
							title : 'List'
						},
						controller : 'commodityclassificationListCtrl',
						templateUrl : 'views/master/commodityclassification/commodityclassificationList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/commodityclassification/commodityclassificationListCntrl.js' ])
									} ]
						}

					})
			// commodity classification add
			.state(
					'app.master.commodityclassification.add',
					{
						url : '/master/commodityclassification/add',
						data : {
							title : 'Add'
						},
						controller : 'commodityclassificationAddCtrl',
						templateUrl : 'views/master/commodityclassification/commodityclassificationAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/commodityclassification/commodityclassificationAddCntrl.js' ])
									} ]
						}

					})
			// commodity classification edit
			.state(
					'app.master.commodityclassification.edit',
					{
						url : '/master/commodityclassification/edit',
						data : {
							title : 'Edit'
						},
						controller : 'commodityclassificationAddCtrl',
						templateUrl : 'views/master/commodityclassification/commodityclassificationAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/commodityclassification/commodityclassificationAddCntrl.js' ])
									} ]
						}

					})

			// Pack Type list
			.state(
					'app.master.packtype.list',
					{
						url : '/master/packtype/list',
						data : {
							title : 'List'
						},
						controller : 'packtypeListCtrl',
						templateUrl : 'views/master/packtype/packtypeList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/packtype/packtypeListCntrl.js' ])
									} ]
						}

					})
			// Pack Type add
			.state(
					'app.master.packtype.add',
					{
						url : '/master/packtype/add',
						data : {
							title : 'Add'
						},
						controller : 'packtypeAddCtrl',
						templateUrl : 'views/master/packtype/packtypeAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/packtype/packtypeAddCntrl.js' ])
									} ]
						}

					})
			// Pack Type edit
			.state(
					'app.master.packtype.edit',
					{
						url : '/master/packtype/edit',
						data : {
							title : 'Edit'
						},
						controller : 'packtypeAddCtrl',
						templateUrl : 'views/master/packtype/packtypeAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/packtype/packtypeAddCntrl.js' ])
									} ]
						}

					})

			// Damage Record
			.state(
					'app.eqs.damageRecord.damageRecordList',
					{
						url : '/damageRecordlist',
						data : {
							title : 'List'
						},
						controller : 'damageRecordListCtrl',
						templateUrl : 'views/eqs/damageRecord/damageRecordList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/damageRecord/damageRecordListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.eqs.damageRecord.damageRecordAdd',
					{
						url : '/damageRecordadd',
						data : {
							title : 'Add'
						},
						controller : 'damageRecordAddCtrl',
						templateUrl : 'views/eqs/damageRecord/damageRecordAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/damageRecord/damageRecordAddCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.eqs.damageRecord.damageRecordedit',
					{
						url : '/damageRecord/damageRecordedit',
						data : {
							title : 'Edit'
						},

						controller : 'damageRecordAddCtrl',
						templateUrl : 'views/eqs/damageRecord/damageRecordAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/damageRecord/damageRecordAddCtrl.js' ]);
									} ]

						}
					})

			.state(
					'app.eqs.damageRecord.damageRecordview',
					{
						url : '/damageRecord/damageRecordView',
						data : {
							title : 'View'
						},
						controller : 'damageRecordViewCtrl',
						templateUrl : 'views/eqs/damageRecordView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/damageRecord/damageRecordCtrl.js' ])
									} ]
						}

					})

			// Dock/Berth list
			.state(
					'app.master.dock.list',
					{
						url : '/master/dock/list',
						data : {
							title : 'List'
						},
						controller : 'dockListCntrl',
						templateUrl : 'views/master/dock/dockList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/dock/dockListCntrl.js' ])
									} ]
						}

					})
			// Dock/Berth add
			.state(
					'app.master.dock.add',
					{
						url : '/master/dock/add',
						data : {
							title : 'Add'
						},
						controller : 'dockAddCntrl',
						templateUrl : 'views/master/dock/dockAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/dock/dockAddCntrl.js' ])
									} ]
						}

					})
			// Dock/Berth edit
			.state(
					'app.master.dock.edit',
					{
						url : '/master/dock/edit',
						data : {
							title : 'Edit'
						},
						controller : 'dockAddCntrl',
						templateUrl : 'views/master/dock/dockAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/dock/dockAddCntrl.js' ])
									} ]
						}

					})

			// Cargo Category list
			.state(
					'app.master.cargo.list',
					{
						url : '/master/cargocategory/list',
						data : {
							title : 'List'
						},
						controller : 'cargoListCtrl',
						templateUrl : 'views/master/cargo/cargoList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/cargo/cargoListCntrl.js' ])
									} ]
						}

					})
			// Cargo Category add
			.state(

					'app.master.cargo.add',
					{
						url : '/master/cargocategory/add',
						data : {
							title : 'Add'
						},
						controller : 'cargoAddCtrl',
						templateUrl : 'views/master/cargo/cargoAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/cargo/cargoAddCntrl.js' ])
									} ]
						}

					})
			// Cargo Category edit
			.state(
					'app.master.cargo.edit',
					{
						url : '/master/cargocategory/edit',
						data : {
							title : 'Edit'
						},
						controller : 'cargoAddCtrl',
						templateUrl : 'views/master/cargo/cargoAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/cargo/cargoAddCntrl.js' ])
									} ]
						}

					})

	$stateProvider
			.state('app.master.freightCharges', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Ocean Charges'
				}
			})
			.state(
					'app.master.freightCharges.oceanChargesList',
					{
						url : '/master/oceanCharges/list',
						data : {
							title : 'List'
						},
						controller : 'oceanChargesListCtrl',
						templateUrl : 'views/master/freightCharges/oceanCharges/oceanChargesList',

						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/freightCharges/oceanCharges/oceanChargesList.js' ]);
									} ]
						}
					})
			.state(
					'app.master.freightCharges.oceanChargesAdd',
					{
						url : '/master/oceanCharges/add',
						data : {
							title : 'Add'
						},
						controller : 'oceanChargesAddCtrl',
						templateUrl : 'views/master/freightCharges/oceanCharges/oceanChargesAdd',

						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/freightCharges/oceanCharges/oceanChargesAdd.js' ]);
									} ]
						}
					})
			// LocalCharges
			.state(
					'app.master.localcharges.list',
					{
						url : '/master/localcharges/list',
						data : {
							title : 'List'
						},
						controller : 'LocalChargesListCtrl',
						templateUrl : '/views/master/localcharge/LocalChargesList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/localcharge/LocalChargesListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.localcharges.add',
					{
						url : '/master/localcharges/add',
						data : {
							title : 'Add'
						},
						controller : 'LocalChargesAddCtrl',
						templateUrl : '/views/master/localcharge/LocalChargesAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/localcharge/LocalChargesAddCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.master.localcharges.edit',
					{
						url : '/master/localcharges/edit',
						data : {
							title : 'Edit'
						},

						controller : 'LocalChargesAddCtrl',
						templateUrl : '/views/master/localcharge/LocalChargesAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/localcharge/LocalChargesAddCtrl.js' ]);
									} ]

						}
					})
			// // Repair Estimate

			.state(
					'app.eqs.repairEstimate.repairEstimateList',
					{
						url : '/repairEstimate/List',
						data : {
							title : 'List'
						},
						controller : 'repairEstimateListCtrl',
						templateUrl : 'views/eqs/repairEstimate/repairEstimateList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/repairEstimate/repairEstimateListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.eqs.repairEstimate.repairEstimateAdd',
					{
						url : '/repairEstimate/Add',
						data : {
							title : 'Add'
						},
						controller : 'repairEstimateAddCtrl',
						templateUrl : 'views/eqs/repairEstimate/repairEstimateAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/repairEstimate/repairEstimateAddCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.eqs.repairEstimate.repairEstimateEdit',
					{
						url : '/repairEstimate/Edit',
						data : {
							title : 'Edit'
						},
						controller : 'repairEstimateAddCtrl',
						templateUrl : 'views/eqs/repairEstimate/repairEstimateAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/repairEstimate/repairEstimateAddCtrl.js' ])
									} ]
						}

					})

			// MNR TARRIF

			.state(
					'app.eqs.mnrTarrif.mnrTarrifList',
					{
						url : '/mnrTarrifList',
						data : {
							title : 'List'
						},
						controller : 'mnrTarrifListCtrl',
						templateUrl : 'views/eqs/mnrTarrif/mnrTarrifList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/mnrTarrif/mnrTarrifListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.eqs.mnrTarrif.mnrTarrifAdd',
					{
						url : '/mnrTarrifadd',
						data : {
							title : 'Add'
						},
						controller : 'mnrTarrifAddCtrl',
						templateUrl : 'views/eqs/mnrTarrif/mnrTarrifAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/mnrTarrif/mnrTarrifAddCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.eqs.mnrTarrif.mnrTarrifedit',
					{
						url : '/mnrTarrif/mnrTarrifedit',
						data : {
							title : 'Edit'
						},

						controller : 'mnrTarrifAddCtrl',
						templateUrl : 'views/eqs/mnrTarrif/mnrTarrifAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/mnrTarrif/mnrTarrifAddCtrl.js' ]);
									} ]

						}
					})

			.state(
					'app.eqs.mnrTarrif.mnrTarrifview',
					{
						url : '/mnrTarrif/mnrTarrifView',
						data : {
							title : 'View'
						},
						controller : 'mnrTarrifViewCtrl',
						templateUrl : 'views/eqs/mnrTarrifView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/mnrTarrif/mnrTarrifCtrl.js' ])
									} ]
						}

					})

			// ICD charges
			.state(
					'app.master.icdcharge.list',
					{
						url : '/master/icdcharge/list',
						data : {
							title : 'List'
						},
						controller : 'IcdChargesListCtrl',
						templateUrl : '/views/master/icdcharge/IcdChargesList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/icdcharge/IcdChargesListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.icdcharge.add',
					{
						url : '/master/icdcharge/add',
						data : {
							title : 'Add'
						},
						controller : 'IcdChargesAddCtrl',
						templateUrl : '/views/master/icdcharge/IcdChargesAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/icdcharge/IcdChargesAddCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.master.icdcharge.edit',
					{
						url : '/master/icdcharge/edit',
						data : {
							title : 'Edit'
						},

						controller : 'IcdChargesAddCtrl',
						templateUrl : '/views/master/icdcharge/IcdChargesAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/icdcharge/IcdChargesAddCtrl.js' ]);
									} ]

						}
					})
			/*// leaseAgreementType
			.state(
					'app.eqs.leaseagreementtype.list',
					{
						url : '/list',
						data : {
							title : 'List'
						},
						controller : 'leaseAgreementListCtrl',
						templateUrl : '/views/eqs/leaseAgreement/leaseAgreementList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/leaseAgreement/leaseAgreementListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.eqs.leaseagreementtype.add',
					{
						url : '/add',
						data : {
							title : 'Add'
						},
						controller : 'leaseAgreementAddCtrl',
						templateUrl : '/views/eqs/leaseAgreement/leaseAgreementAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/leaseAgreement/leaseAgreementAddCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.eqs.leaseagreementtype.edit',
					{
						url : '/edit',
						data : {
							title : 'Edit'
						},

						controller : 'leaseAgreementAddCtrl',
						templateUrl : '/views/eqs/leaseAgreement/leaseAgreementAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/leaseAgreement/leaseAgreementAddCtrl.js' ]);
									} ]

						}
					})*/

			// /container Type

			.state('app.master.generalcontainertype', {
				abstract : true,
				templateUrl : "views/common.jsp",
				data : {
					title : 'Container Type'
				}
			})
			.state(
					'app.master.generalcontainertype.containertype',
					{
						url : "/containerType/list",
						templateUrl : "views/containerType/containerTypeList",
						data : {
							title : 'List'
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
					'app.master.generalcontainertype.add',
					{
						controller : "containerTypeAddCtrl",
						url : "/containerType/add",
						templateUrl : "views/containerType/containerTypeAddEdit",
						data : {
							title : 'Add'
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
			.state(
					'app.master.generalcontainertype.edit',
					{
						controller : "containerTypeAddCtrl",
						url : "/containerType/edit",
						templateUrl : "views/containerType/containerTypeAddEdit",
						data : {
							title : 'Edit'
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

			.state(
					'app.master.generalcontainertype.view',
					{
						controller : "containerTypeAddCtrl",
						url : "/containerType/view",
						templateUrl : "views/containerType/ContainerTypeView",
						data : {
							title : 'View'
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

			// Exchange Rate
			.state('app.master.generalexchangerate', {
				abstract : true,
				templateUrl : "views/common.jsp",
				data : {
					title : 'Exchange Rate'
				}
			})

			.state(
					'app.master.generalexchangerate.exchangerate',
					{
						url : '/controlscreen/exchangeRateList',
						data : {
							title : ' List'
						},

						controller : 'exchangeRateCtrl',
						templateUrl : 'views/finance/exchangerate/exchangeRateList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/exchangerate/exchangeRateCtrl.js' ]);
									} ]
						}

					})

			.state(
					'app.master.generalexchangerate.exchangerateadd',
					{
						url : '/controlscreen/exchangeRateAdd',
						data : {
							title : 'Add'
						},

						controller : 'exchangeRateAddCtrl',
						templateUrl : 'views/finance/exchangerate/exchangeRateAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/exchangerate/exchangeRateAddCtrl.js' ]);
									} ]

						}

					})

			.state(
					'app.master.generalexchangerate.exchangeRateEdit',
					{
						url : '/controlscreen/exchangeRateEdit',
						data : {
							title : 'Edit'
						},
						controller : 'exchangeRateAddCtrl',
						templateUrl : 'views/finance/exchangerate/exchangeRateAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/exchangerate/exchangeRateAddCtrl.js' ]);
									} ]
						}

					})

			.state(
					'app.master.generalexchangerate.exchangeRateView',
					{
						url : '/controlscreen/exchangeRateView',
						data : {
							title : 'View'
						},
						controller : 'exchangeRateAddCtrl',
						templateUrl : 'views/finance/exchangerate/exchangeRateView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/exchangerate/exchangeRateAddCtrl.js' ]);
									} ]
						}

					})

			// merge Gate Out / Gate In

			.state('app.eqs.gateoutgatein', {
				abstract : true,
				templateUrl : "views/common.jsp",
				data : {
					title : 'Container Movement New'
				}
			})

			.state(
					'app.eqs.gateoutgatein.gateoutgateinlist',
					{
						url : '/gateoutgateinlist',
						data : {
							title : 'List'
						},
						controller : 'gateoutgateinListCtrl',
						templateUrl : 'views/eqs/gateoutgatein/gateoutgateinList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/gateoutgatein/gateoutgateinListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.eqs.gateoutgatein.gateoutgateinadd',
					{
						url : '/gateoutgateinadd',
						data : {
							title : 'Add'
						},
						controller : 'gateoutgateinAddCtrl',
						templateUrl : 'views/eqs/gateoutgatein/gateoutgateinAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqs/gateoutgatein/gateoutgateinAddCtrl.js' ])
									} ]
						}

					})
.state(
'app.eqs.gateoutgatein.gateoutgateinedit',
{
url : '/gateoutgateinadd/Edit',
data : {
title : 'Edit'
},
controller : 'gateoutgateinAddCtrl',
templateUrl : 'views/eqs/gateoutgatein/gateoutgateinAdd',
resolve : {
deps : [
'$ocLazyLoad',
function($ocLazyLoad) {
return $ocLazyLoad
.load([ 'js/app/eqs/gateoutgatein/gateoutgateinAddCtrl.js' ])
} ]
}

})
			// Local Charges Cost

			.state(
					'app.master.localchargescost.list',

					{
						url : '/master/localchargescost/list',
						data : {
							title : 'List'
						},
						controller : 'LocalChargesCostListCtrl',
						templateUrl : '/views/master/localchargecost/LocalChargesCostList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/localchargecost/LocalChargesCostListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.localchargescost.add',
					{
						url : '/master/localchargescost/add',
						data : {
							title : 'Add'
						},
						controller : 'LocalChargesCostAddCtrl',
						templateUrl : '/views/master/localchargecost/LocalChargesCostAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/localchargecost/LocalChargesCostAddCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.master.localchargescost.edit',
					{
						url : '/master/localchargescost/edit',
						data : {
							title : 'Edit'
						},

						controller : 'LocalChargesCostAddCtrl',
						templateUrl : '/views/master/localchargecost/LocalChargesCostAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/localchargecost/LocalChargesCostAddCtrl.js' ]);
									} ]

						}
					})

			// Storage Charges
			.state(
					'app.master.storagecharges.list',
					{
						url : '/master/storagecharges/list',
						data : {
							title : 'List'
						},
						controller : 'StorageChargesListCtrl',
						templateUrl : '/views/master/storagecharges/StorageChargesList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/storagecharges/StorageChargesListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.storagecharges.add',
					{
						url : '/master/storagecharges/add',
						data : {
							title : 'Add'
						},
						controller : 'StorageChargesAddCtrl',
						templateUrl : '/views/master/storagecharges/StorageChargesAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/storagecharges/StorageChargesAddCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.master.storagecharges.edit',
					{
						url : '/master/storagecharges/edit',
						data : {
							title : 'Edit'
						},

						controller : 'StorageChargesAddCtrl',
						templateUrl : '/views/master/storagecharges/StorageChargesAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/storagecharges/StorageChargesAddCtrl.js' ]);
									} ]

						}
					})
					
					
					
					.state(
					'app.truck.general.department',
					{
						url : '/department',
						cache : false,
						data : {
							title : 'Department'
						},

						controller : 'departmentCtrl',
						templateUrl : 'views/master/department/departmentList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/general/department/departmentCtrl.js' ]);
									} ]

						}
					})
			.state(
					'app.truck.general.department-Add',
					{
						url : '/department/add',
						cache : false,
						data : {
							title : 'Add'
						},
						controller : 'departmentAddCtrl',

						templateUrl : 'views/master/department/departmentAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/general/department/departmentAddCtrl.js' ]);
									} ]

						}
					})

			.state(
					'app.truck.general.department-Edit',
					{
						url : '/department/edit',
						cache : false,
						data : {
							title : 'Edit'
						},

						controller : 'departmentAddCtrl',
						templateUrl : 'views/master/department/departmentAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/general/department/departmentAddCtrl.js' ]);
									} ]

						}
					})
					
					.state(
					'app.truck.general.companydetails',
					{
						url : '/general/companydetails',
						cache : false,
						data : {
							title : 'Company Details'
						},

						controller : 'CompanyDetailsCtrl',
						templateUrl : 'views/master/general/CompanyDetails/CompanyDetailsListPage',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/general/CompanyDetails/CompanyDetailsCtrl.js' ]);
									} ]

						}
					})

			.state(
					'app.truck.general.companydetails-add',
					{
						url : '/general/companydetails/add',
						cache : false,
						data : {
							title : 'Add'
						},

						controller : 'CompanyDetailsAddCtrl',
						templateUrl : 'views/master/general/CompanyDetails/CompanyDetailsAddPage',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/general/CompanyDetails/CompanyDetailsAddCtrl.js' ]);
									} ]

						}
					})

			.state(
					'app.truck.general.companydetails-edit',
					{
						url : '/general/companydetails/edit',
						cache : false,
						data : {
							title : 'Edit'
						},

						controller : 'CompanyDetailsEditCtrl',
						templateUrl : 'views/general/CompanyDetails/CompanyDetailsAddPage',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/general/CompanyDetails/CompanyDetailsEditCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.truck.general.companydetails-view',
					{
						url : '/general/companydetails/view',
						cache : false,
						data : {
							title : 'View'
						},
						controller : 'CompanyDetailsEditCtrl',
						templateUrl : 'views/master/general/CompanyDetails/CompanyDetailsView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/general/CompanyDetails/CompanyDetailsEditCtrl.js' ])
									} ]
						}
					})
					
			.state(
					'app.truck.general.designation',
					{
						url : '/designation',
						cache : false,
						data : {
							title : 'Designation'
						},

						controller : 'designationCtrl',
						templateUrl : 'views/master/designation/designationList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/general/designation/designationCtrl.js' ], {cache:false});
									} ]
						}

					})
			.state(
					'app.truck.general.designation-Add',
					{
						url : '/designation/add',
						cache : false,
						data : {
							title : 'Designation Add'
						},

						controller : 'designationAddCtrl',
						templateUrl : 'views/master/designation/designationAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/general/designation/designationAddCtrl.js' ], {cache:false});
									} ]

						}
					})

			.state(
					'app.truck.general.designation-Edit',
					{
						url : '/designation/edit',
						cache : false,
						data : {
							title : 'Designation Edit'
						},

						controller : 'designationAddCtrl',
						templateUrl : 'views/master/designation/designationAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/general/designation/designationAddCtrl.js' ], {cache:false});
									} ]

						}
					})

			.state(
					'app.truck.general.designation-view',
					{
						url : '/designation/view',
						cache : false,
						data : {
							title : 'Designation View'
						},

						controller : 'designationAddCtrl',
						templateUrl : 'views/master/designation/designationView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/general/designation/designationAddCtrl.js' ], {cache:false});
									} ]

						}
					})
							
			.state(
					'app.truck.general.grade.gradelist',
					{
						url : '/grade/gradelist',
						cache : false,
						data : {
							title : 'List'
						},
						controller : 'gradeAdminCtrl',
						templateUrl : 'views/master/grade/gradeList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/general/grade/gradeAdminCtrl.js' ], {cache:false});
									} ]
						}
					})

			.state(
					'app.truck.general.grade.gradeadd',
					{
						url : '/grade/gradeadd',
						cache : false,
						data : {
							title : 'Add'
						},
						controller : 'gradeAdminAddCtrl',
						templateUrl : 'views/master/grade/gradeAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/general/grade/gradeAdminCtrl.js' ], {cache:false})
									} ]
						}

					})

			.state(
					'app.truck.general.grade.gradeedit',
					{
						url : '/grade/gradeedit',
						cache : false,
						data : {
							title : 'Edit'
						},
						controller : 'gradeAdminAddCtrl',
						templateUrl : 'views/master/grade/gradeAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/general/grade/gradeAdminCtrl.js' ], {cache:false})
									} ]
						}

					})	
					
					
					
				// Location

			
			.state(
					'app.truck.general.stopping.list',
					{
						url : '/location/list',
						cache : false,
						data : {
							title : 'List'
						},
						controller : 'manageLocationListCtrl',
						templateUrl : 'views/stopping/stoppinglist',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/stopping/stoppingCtrl.js' ], {cache:false});
									} ]
						}
					})

			.state(
					'app.truck.general.stopping.add',
					{
						url : '/location/add',
						cache : false,
						data : {
							title : 'Add'
						},
						controller : 'manageLocationAddCtrl',
						templateUrl : 'views/stopping/stoppingadd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/stopping/stoppingAddCtrl.js' ], {cache:false})
									} ]
						}

					})

			.state(
					'app.truck.general.stopping.edit',
					{
						url : '/location/edit',
						cache : false,
						data : {
							title : 'Edit'
						},
						controller : 'manageLocationAddCtrl',
						templateUrl : 'views/stopping/stoppingadd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/stopping/stoppingAddCtrl.js' ], {cache:false})
									} ]
						}

					})	
	
					
					.state(
					'app.truck.general.commodity.list',
					{
						url : '/commodity/list',
						cache : false,
						data : {
							title : 'List'
						},
						controller : 'commodityListCtrl',
						templateUrl : 'views/master/commodity/commodityList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/general/commodity/commodityCtrl.js' ], {cache:false});
									} ]
						}
					})
					
					
					
					
					.state(
					'app.truck.general.commodity.add',
					{
						url : '/commodity/add',
						cache : false,
						data : {
							title : 'Add'
						},
						controller : 'commodityAddCtrl',
						templateUrl : 'views/master/commodity/commodityAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/general/commodity/commodityCtrl.js' ], {cache:false});
									} ]
						}
					})
					
					
					
					.state(
					'app.truck.general.commodity.edit',
					{
						url : '/commodity/edit',
						cache : false,
						data : {
							title : 'Edit'
						},
						controller : 'commodityAddCtrl',
						templateUrl : 'views/master/commodity/commodityAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/general/commodity/commodityCtrl.js' ], {cache:false});
									} ]
						}
					})
				.state(
					'app.truck.employee.employeeMaster',
					{
						url : '/employee/employeeMaster/employeeMasterList',
						cache : false,
						data : {
							title : 'List'
						},
						controller : 'empmasterCtrl',
						templateUrl : 'views/master/empmaster/empmasterList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/empmaster/empmasterCtrl.js' ], {cache:false});
									} ]
						}
					})

			.state(
					'app.truck.employee.employeeMaster-add',
					{
						url : '/employee/employeeMaster/add',
						cache : false,
						data : {
							title : 'Add'
						},
						controller : 'empmasterAddCtrl',
						templateUrl : 'views/master/empmaster/empmasterAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/empmaster/empmasterAddCtrl.js' ], {cache:false})
									} ]
						}

					})
			.state(
					'app.truck.employee.employeeMaster-Edit',
					{
						url : '/employee/employeeMaster/Edit/:empId',
						cache : false,
						data : {
							title : 'Add'
						},
						controller : 'empmasterAddCtrl',
						templateUrl : 'views/master/empmaster/empmasterAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/empmaster/empmasterAddCtrl.js' ], {cache:false})
									} ]
						}

					})
						.state('app.truck.employee.employeeMaster-View',
					{
						url : '/employee/employeeMaster/View/:empId',
						cache : false,
						data : {
							title : 'Add'
						},
						controller : 'empmasterViewCtrl',
						templateUrl : 'views/master/empmaster/empmasterAddView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/empmaster/empmasterViewCtrl.js' ], {cache:false})
									} ]
						}

					})	
					
					
					.state(
					'app.truck.trailer.list',
					{
						url : 'trailer/list',
						cache : false,
						data : {
							title : 'List'
						},
						controller : 'trailerListCtrl',
						templateUrl : 'views/master/trailer/trailerList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/trailer/trailerListCtrl.js' ], {cache:false});
									} ]
						}
					})
					
					.state(
					'app.truck.trailer.add',
					{
						url : 'trailer/add',
						cache : false,
						data : {
							title : 'Add'
						},
						controller : 'trailerAddCtrl',
						templateUrl : 'views/master/trailer/trailerAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/trailer/trailerAddCtrl.js' ], {cache:false});
									} ]
						}
					})
					
					.state(
					'app.truck.trailer.edit',
					{
						url : 'trailer/edit',
						cache : false,
						data : {
							title : 'Edit'
						},
						controller : 'trailerAddCtrl',
						templateUrl : 'views/master/trailer/trailerAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/trailer/trailerAddCtrl.js' ], {cache:false});
									} ]
						}
					})
					
						.state(
					'app.truck.trailer.view',
					{
						url : 'trailer/view',
						cache : false,
						data : {
							title : 'Edit'
						},
						controller : 'trailerAddCtrl',
						templateUrl : 'views/master/trailer/trailerView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/trailer/trailerAddCtrl.js' ], {cache:false});
									} ]
						}
					})
			
					//truck
					
					.state(
					'app.truck.list',
					{
						url : '/truck/list',
						cache : false,
						data : {
							title : 'List'
						},
						controller : 'truckListCtrl',
						templateUrl : 'views/master/truck/truckList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/truck/truckListCtrl.js' ], {cache:false});
									} ]
						}
					})
					
					.state(
					'app.truck.add',
					{
						url : '/truck/add',
						cache : false,
						data : {
							title : 'Add'
						},
						controller : 'truckAddCtrl',
						templateUrl : 'views/master/truck/truckAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/truck/truckAddCtrl.js' ], {cache:false});
									} ]
						}
					})
					
					.state(
					'app.truck.edit',
					{
						url : '/truck/edit',
						cache : false,
						data : {
							title : 'Edit'
						},
						controller : 'truckAddCtrl',
						templateUrl : 'views/master/truck/truckAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/truck/truckAddCtrl.js' ], {cache:false});
									} ]
						}
					})
					
						.state(
					'app.truck.view',
					{
						url : '/truck/view',
						cache : false,
						data : {
							title : 'Edit'
						},
						controller : 'truckAddCtrl',
						templateUrl : 'views/master/truck/truckView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/truck/truckAddCtrl.js' ], {cache:false});
									} ]
						}
					})

					
					//Staff Master
			
			
			.state('app.truck.staffmaster.list',
			{
				url : '/master/staffmaster',
				cache : false,
				data : {
					title : ''
				},
				controller : 'staffListCtrl',
				templateUrl : '/views/master/staffmaster/staffmasterlist',
				resolve : {
					deps : [
							'$ocLazyLoad',
							function($ocLazyLoad) {
								return $ocLazyLoad
										.load([ 'js/app/master/staffmaster/staffListCtrl.js' ], {cache:false});
							} ]
				}
			})
			
					.state('app.truck.staffmaster.add',
			{
				url : '/master/staffmaster',
				cache : false,
				data : {
					title : ''
				},
				controller : 'staffListCtrl',
				templateUrl : '/views/master/staffmaster/staffmasterAdd',
				resolve : {
					deps : [
							'$ocLazyLoad',
							function($ocLazyLoad) {
								return $ocLazyLoad
										.load([ 'js/app/master/staffmaster/staffListCtrl.js' ], {cache:false});
							} ]
				}
			})
			
			.state('app.truck.truckdriver.list',
			{
				url : '/truckdriver/list',
				cache : false,
				data : {
					title : ''
				},
				controller : 'truckdriverListCtrl',
				templateUrl : 'views/master/truckdriver/truckdriverList',
				resolve : {
					deps : [
							'$ocLazyLoad',
							function($ocLazyLoad) {
								return $ocLazyLoad
										.load([ 'js/app/master/truckdriver/truckdriverListCtrl.js' ], {cache:false});
							} ]
				}
			})
			
				.state('app.truck.truckdriver.add',
			{
				url : '/truckdriver/add',
				cache : false,
				data : {
					title : ''
				},
				controller : 'truckdriverAddCtrl',
				templateUrl : 'views/master/truckdriver/truckdriverAdd',
				resolve : {
					deps : [
							'$ocLazyLoad',
							function($ocLazyLoad) {
								return $ocLazyLoad
										.load([ 'js/app/master/truckdriver/truckdriverAddCtrl.js' ], {cache:false});
							} ]
				}
			})
			
			
		/*	.state('app.truck.trucktrailer.list', {
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
	}).state('app.truck.trucktrailer.add', {
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
	}).state('app.truck.trucktrailer.edit', {
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
	}).state('app.truck.trucktrailer.view', {
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
	// employee
			.state('app.master.employee', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Employee Master'
				}
			})
			
.state(
					'app.master.employee.employeeMaster',
					{
						url : '/employee/employeeMaster/employeeMasterList',
						data : {
							title : 'List'
						},
						controller : 'empmasterCtrl',
						templateUrl : 'views/master/empmaster/empmasterList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/empmaster/empmasterCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.master.employee.employeeMasteradd-add',
					{
						url : '/employee/employeeMaster/add',
						data : {
							title : 'Add'
						},
						controller : 'empmasterAddCtrl',
						templateUrl : 'views/master/empmaster/empmasterAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/empmaster/empmasterAddCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.master.employee.employeeMasteredit-Edit',
					{
						url : '/employee/employeeMaster/Edit/:empId',
						data : {
							title : 'Edit'
						},
						controller : 'empmasterAddCtrl',
						templateUrl : 'views/master/empmaster/empmasterAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/empmaster/empmasterAddCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.master.employee.employeeMasterview-View',
					{
						url : '/employee/employeeMaster/View/:empId',
						data : {
							title : 'View'
						},
						controller : 'empmasterViewCtrl',
						templateUrl : 'views/master/empmaster/empmasterAddView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/empmaster/empmasterViewCtrl.js' ])
									} ]
						}

					})
					// branch
					.state('app.master.general.branch', {
						abstract : true,
						templateUrl : "views/common.jsp",
						data : {
							title : 'Branch'
						}
					})
					//branch
					.state(
							'app.master.general.branch.branchlist', 
							{
								url : '/brach/branchlist',
								data : {
									title : 'List'
								},
								controller : 'branchListCtrl',
								templateUrl : 'views/master/branch/branchList',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/master/general/branch/branchCtrl.js' ]);
											} ]
								}
							})

					.state(
							'app.master.general.branch.branchadd',
							{
								url : '/brach/branchadd',
								data : {
									title : 'Add'
								},
								controller : 'branchAddCtrl',
								templateUrl : 'views/master/branch/branchAdd',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/master/general/branch/branchCtrl.js' ])
											} ]
								}

							})
							
								.state(
							'app.master.general.branch.branchedit',
							{
								url : '/brach/branchedit',
								data : {
									title : 'Edit'
								},

								controller : 'branchAddCtrl',
								templateUrl : 'views/master/branch/branchAdd',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/master/general/branch/branchCtrl.js' ]);
											} ]

								}
							})
							
							.state(
							'app.master.general.branch.view',
							{
								url : '/brach/branchView',
								data : {
									title : 'View'
								},
								controller : 'branchViewCtrl',
								templateUrl : 'views/master/branch/branchView',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/master/general/branch/branchCtrl.js' ])
											} ]
								}

							})
							
							
					
					
					// voyage list
					.state(
					'app.master.voyage.list',
					{
						url : '/master/voyage/list',
						data : {
							title : 'List'
						},
						controller : 'voyageListCtrl',
						templateUrl : 'views/master/voyage/voyageList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/voyage/voyageListCntrl.js' ])
									} ]
						}

					})
					// voyage add
				.state(
					'app.master.voyage.add',
					{
						url : '/master/voyage/add',
						data : {
							title : 'Add'
						},
						controller : 'voyageAddCtrl',
						templateUrl : 'views/master/voyage/voyageAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/voyage/voyageAddCntrl.js' ])
									} ]
						}

					})
					// voyage edit
					.state('app.master.voyage.edit',
					{
						url : '/master/voyage/edit',
						data : {
							title : 'Edit'
						},
						controller : 'voyageAddCtrl',
						templateUrl : 'views/master/voyage/voyageAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/voyage/voyageAddCntrl.js' ])
									} ]
						}

					})
					.state('app.master.voyage.view',
					{
						url : '/master/voyage/view',
						data : {
							title : 'Edit'
						},
						controller : 'voyageAddCtrl',
						templateUrl : 'views/master/voyage/voyageView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/voyage/voyageAddCntrl.js' ])
									} ]
						}

					})
							
			/// Vessel Sector		
	.state('app.master.vessel', {
		abstract : true,
		templateUrl : "views/common.jsp",
		data : {
			title : 'Vessel Master'
		}
	})
					
		.state( 'app.master.vessel.service',
					{
						url : '/vessel/service',
						data : {
							title : 'Service'
						},
						controller : 'vesselSectorCtrl',
						templateUrl : 'views/master/vessel/vesselSectorList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/vessel/vesselSectorCtrl.js' ])
									} ]
						}
						})

    .state('app.master.vessel.vesselSectorAdd', {
        url : '/vessel/service/add',
        data : {
            title : 'Service Add'
        },
               controller : 'vesselSectorAddCtrl',
                templateUrl : 'views/master/vessel/vesselSectorAdd',
                resolve : {
                    deps : [ '$ocLazyLoad', function($ocLazyLoad) {
                        return $ocLazyLoad.load([ 'js/app/master/vessel/vesselSectorAddCtrl.js' ]);
                    } ]
                }
            
        
    })

    .state('app.master.vessel.service-edit', {
        url : '/vessel/service/vesselSectorEdit',
        data : {
            title : 'Edit'
        },
       
                controller : 'vesselSectorAddCtrl',
                templateUrl : 'views/master/vessel/vesselSectorAdd',
                resolve : {
                    deps : [ '$ocLazyLoad', function($ocLazyLoad) {
                        return $ocLazyLoad.load([ 'js/app/master/vessel/vesselSectorAddCtrl.js' ]);
                    } ]
                
            
        }
    })
    /// Vessel Sector		
	.state('app.master.service', {
		abstract : true,
		templateUrl : "views/common.jsp",
		data : {
			title : 'Service'
		}
	})
    .state('app.master.service.servicemaster', {
        url : '/service/servicemaster',
        data : {
            title : 'Service Master'
        },
                controller : 'serviceMasterListCtrl',
                templateUrl : 'views/master/service/serviceMasterListPage',
                resolve : {
                    deps : [ '$ocLazyLoad', function($ocLazyLoad) {
                        return $ocLazyLoad.load([ 'js/app/master/service/serviceMasterListCtrl.js' ]);
                    } ]
                }
            
        
    })
    .state('app.master.service.servicemasterAdd', {
        url : '/service/servicemaster/add',
        data : {
            title : 'Add'
        },
                controller : 'serviceMasterAddCtrl',
                templateUrl : 'views/master/service/serviceMasterAddPage',
                resolve : {
                    deps : [ '$ocLazyLoad', function($ocLazyLoad) {
                        return $ocLazyLoad.load([ 'js/app/master/service/serviceMasterAddCtrl.js' ]);
                    } ]
                }
          
    })
          
    .state('app.master.service.servicemaster-view', {
        url : '/service/servicemaster/view',
        data : {
            title : 'View'
        },
                controller : 'serviceMasterAddCtrl',
                templateUrl : 'views/master/service/serviceMasterViewPage',
                resolve : {
                    deps : [ '$ocLazyLoad', function($ocLazyLoad) {
                        return $ocLazyLoad.load([ 'js/app/master/service/serviceMasterAddCtrl.js']);
                                                
                    } ]
                }
         
    })
    
    .state('app.master.service.servicemaster-edit', {
        url : '/service/servicemaster/edit',
        data : {
            title : 'Service Master'
        },
                controller : 'serviceMasterAddCtrl',
                templateUrl : 'views/master/service/serviceMasterAddPage',
                resolve : {
                    deps : [ '$ocLazyLoad', function($ocLazyLoad) {
                        return $ocLazyLoad.load([ 'js/app/master/service/serviceMasterAddCtrl.js' ]);
                    } ]
                }
        
    })
    
  //containermovement
	.state('app.eqc.containerMove', {
		abstract : true,
		templateUrl : "views/common.jsp",
		data : {
			title : 'Container Movement'
		}
	})
	.state(
			'app.eqc.containerMove.containerMovementList',
			{
				url : '/cim/containerMovementlist',
				data : {
					title : 'List'
				},
				controller : 'containerMovementListCtrl',
				templateUrl : 'views/eqs/containerMovement/containerMovementList',
				resolve : {
					deps : [
							'$ocLazyLoad',
							function($ocLazyLoad) {
								return $ocLazyLoad
										.load([ 'js/app/eqs/containerMovement/containerMovement.js' ]);
							} ]
				}
			})


    // containerBank  list
.state(
	'app.eqc.containerBank.list',
	{
		url : '/eqc/containerBank/list',
		data : {
			title : 'List'
		},
		controller : 'containerBankListCtrl',
		templateUrl : 'views/eqc/containerBank/containerBankList',
		resolve : {
			deps : [
					'$ocLazyLoad',
					function($ocLazyLoad) {
						return $ocLazyLoad
								.load([ 'js/app/eqc/containerBank/containerBankListCntrl.js' ])
					} ]
		}

	})
	
// containerBank add
.state(
	'app.eqc.containerBank.add',
	{
		url : '/eqc/containerBank/add',
		data : {
			title : 'Add'
		},
		controller : 'containerBankAddCtrl',
		templateUrl : 'views/eqc/containerBank/containerBankAdd',
		resolve : {
			deps : [
					'$ocLazyLoad',
					function($ocLazyLoad) {
						return $ocLazyLoad
								.load([ 'js/app/eqc/containerBank/containerBankAddCntrl.js' ])
					} ]
		}

	})
	
	
	// depot move
.state(
	'app.eqc.containerBank.depotBulk',
	{
		url : '/eqc/containerBank/depotBulk',
		data : {
			title : 'Depot Move'
		},
		controller : 'containerBankDepotCtrl',
		templateUrl : 'views/eqc/containerBank/containerBankDepotMove',
		resolve : {
			deps : [
					'$ocLazyLoad',
					function($ocLazyLoad) {
						return $ocLazyLoad
								.load([ 'js/app/eqc/containerBank/containerBankAddCntrl.js' ])
					} ]
		}

	})

	
	
	// Commodity Description
	.state('app.master.commoditynewdesc', {
		abstract : true,
		templateUrl : "views/common.jsp",
		data : {
			title : 'Commodity Description '
		}
	})

	
	// Commodity Description list
	.state(
			'app.master.commoditynewdesc.list',
			{
				url : '/master/commoditynew/list',
				data : {
					title : 'List'
				},
				controller : 'commodityListnewCtrl',
				templateUrl : 'views/master/commoditynew/commoditynewList',
				resolve : {
					deps : [
							'$ocLazyLoad',
							function($ocLazyLoad) {
								return $ocLazyLoad
										.load([ 'js/app/master/commoditynew/commodityListnewCntrl.js' ])
							} ]
				}

			})
	// commodity add
	.state(
			'app.master.commoditynewdesc.add',
			{
				url : '/master/commoditynew/add',
				data : {
					title : 'Add'
				},
				controller : 'commodityAddnewCtrl',
				templateUrl : 'views/master/commoditynew/commoditynewAdd',
				resolve : {
					deps : [
							'$ocLazyLoad',
							function($ocLazyLoad) {
								return $ocLazyLoad
										.load([ 'js/app/master/commoditynew/commodityAddnewCntrl.js' ])
							} ]
				}

			})
	// commodity edit
	.state(
			'app.master.commoditynewdesc.edit',
			{
				url : '/master/commoditynew/edit',
				data : {
					title : 'Edit'
				},
				controller : 'commodityAddnewCtrl',
				templateUrl : 'views/master/commoditynew/commoditynewAdd',
				resolve : {
					deps : [
							'$ocLazyLoad',
							function($ocLazyLoad) {
								return $ocLazyLoad
										.load([ 'js/app/master/commoditynew/commodityAddnewCntrl.js' ])
							} ]
				}

			})

	.state(
			'app.master.commoditynewdesc.view',
			{
				url : '/master/commoditynew/view',
				data : {
					title : 'View'
				},
				controller : 'commodityAddnewCtrl',
				templateUrl : 'views/master/commoditynew/commoditynewView',
				resolve : {
					deps : [
							'$ocLazyLoad',
							function($ocLazyLoad) {
								return $ocLazyLoad
										.load([ 'js/app/master/commoditynew/commodityAddnewCntrl.js' ])
							} ]
				}

			})
// containerBank edit
.state(
	'app.eqc.containerBank.edit',
	{
		url : '/eqc/containerBank/edit',
		data : {
			title : 'Edit'
		},
		controller : 'containerBankAddCtrl',
		templateUrl : 'views/eqc/containerBank/containerBankAdd',
		resolve : {
			deps : [
					'$ocLazyLoad',
					function($ocLazyLoad) {
						return $ocLazyLoad
								.load([ 'js/app/eqc/containerBank/containerBankAddCntrl.js' ])
					} ]
		}

	})

.state(
	'app.eqc.containerBank.view',
	{
		url : '/eqc/containerBank/view',
		data : {
			title : 'View'
		},
		controller : 'containerBankAddCtrl',
		templateUrl : 'views/eqc/containerBank/containerBankView',
		resolve : {
			deps : [
					'$ocLazyLoad',
					function($ocLazyLoad) {
						return $ocLazyLoad
								.load([ 'js/app/eqc/containerBank/containerBankAddCntrl.js' ])
					} ]
		}

	})
    
 
	// Agent Customer Mapping
			.state('app.eqc.containerOnHire', {
				abstract : true,
				templateUrl : "views/common.jsp",
				data : {
					title : 'container On-Hire'
				}
			})

			// ContainerOnHire
							.state(
							'app.eqc.containerOnHire.list',
							{
								url : '/eqc/containerOnHire/list',
								data : {
									title : 'List'
								},
								controller : 'containerOnHireListCtrl',
								templateUrl : 'views/eqc/containerOnHire/containerOnHireList',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/eqc/containerOnHire/containerOnHireListCtrl.js' ]);
											} ]
								}
							})
							.state(
							'app.eqc.containerOnHire.add',
							{
								url : '/eqc/containerOnHire/add',
								data : {
									title : 'Add'
								},
								controller : 'containerOnHireAddCtrl',
								templateUrl : 'views/eqc/containerOnHire/containerOnHireAdd',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/eqc/containerOnHire/containerOnHireAddCtrl.js' ])
											} ]
								}

							})
			.state(
							'app.eqc.containerOnHire.edit',
							{
							url : '/eqc/containerOnHire/edit',
								data : {
									title : 'Edit'
								},
								controller : 'containerOnHireAddCtrl',
								templateUrl : 'views/eqc/containerOnHire/containerOnHireAdd',
								resolve : {
									deps : [
										'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/eqc/containerOnHire/containerOnHireAddCtrl.js' ])
											} ]
								}

							})
	//Lease Agreement Type
			.state('app.eqc.leaseagreementtype', {
				abstract : true,
				templateUrl : "views/common.jsp",
				data : {
					title : 'Lease Agreement Type'
				}
			})

			// Lease Agreement Type
							.state(
							'app.eqc.leaseagreementtype.list',
							{
								url : '/eqc/leaseagreementtype/list',
								data : {
									title : 'List'
								},
								controller : 'leaseAgreementListCtrl',
								templateUrl : 'views/eqc/leaseAgreement/leaseAgreementList',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/eqc/leaseAgreement/leaseAgreementListCtrl.js' ]);
											} ]
								}
							})
			.state(
					'app.eqc.leaseagreementtype.add',
					{
						url : '/eqc/leaseagreementtype/add',
						data : {
							title : 'Add'
						},
						controller : 'leaseAgreementAddCtrl',
						templateUrl : '/views/eqc/leaseAgreement/leaseAgreementAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqc/leaseAgreement/leaseAgreementAddCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.eqc.leaseagreementtype.edit',
					{
						url : '/eqc/leaseagreementtype/edit',
						data : {
							title : 'Edit'
						},

						controller : 'leaseAgreementAddCtrl',
						templateUrl : '/views/eqc/leaseAgreement/leaseAgreementAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqc/leaseAgreement/leaseAgreementAddCtrl.js' ]);
									} ]

						}
					})

					.state(
					'app.eqc.leaseagreementtype.view',
					{
						url : '/trade/leaseagreementtype/view',
						data : {
							title : 'View'
						},

						controller : 'leaseAgreementAddCtrl',
						templateUrl : '/views/eqc/leaseAgreement/leaseAgreementView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqc/leaseAgreement/leaseAgreementAddCtrl.js' ]);
									} ]

						}
					})
					// ContainerLeaseAgreement
			.state('app.eqc.containerLeaseAgreement', {
				abstract : true,
				templateUrl : "views/common.jsp",
				data : {
					title : 'Container Lease Agreement'
				}
			})

			//  ContainerLeaseAgreement
							.state(
							'app.eqc.containerLeaseAgreement.list',
							{
								url : '/eqc/containerLeaseAgreement/list',
								data : {
									title : 'List'
								},
								controller : 'containerLeaseAgreementListCtrl',
								templateUrl : 'views/eqc/containerLeaseAgreement/containerLeaseAgreementList',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/eqc/containerLeaseAgreement/containerLeaseAgreementListCtrl.js' ]);
											} ]
								}
							})
					.state(
					'app.eqc.containerLeaseAgreement.containerLeaseAgreementAdd',
					{
						url : '/trade/containerLeaseAgreement/Add',
						data : {
							title : 'Add'
						},
						controller : 'containerLeaseAgreementAddCtrl',
						templateUrl : 'views/eqc/containerLeaseAgreement/containerLeaseAgreementAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqc/containerLeaseAgreement/containerLeaseAgreementAddCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.eqc.containerLeaseAgreement.containerLeaseAgreementEdit',
					{
						url : '/trade/containerLeaseAgreement/Edit',
						data : {
							title : 'Edit'
						},

						controller : 'containerLeaseAgreementAddCtrl',
						templateUrl : 'views/eqc/containerLeaseAgreement/containerLeaseAgreementAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqc/containerLeaseAgreement/containerLeaseAgreementAddCtrl.js' ]);
									} ]

						}
					})
					
                 .state(
					'app.eqc.containerLeaseAgreement.containerLeaseAgreementView',
					{
						url : '/trade/containerLeaseAgreement/View',
						data : {
							title : 'View'
						},

						controller : 'containerLeaseAgreementAddCtrl',
						templateUrl : 'views/eqc/containerLeaseAgreement/containerLeaseAgreementView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqc/containerLeaseAgreement/containerLeaseAgreementAddCtrl.js' ]);
									} ]

						}
					})
					// ContainerOnHireRelease
						.state('app.eqc.onHireRelease', {
				abstract : true,
				templateUrl : "views/common.jsp",
				data : {
					title : 'Container On-Hire Release'
				}
			})
			.state(
					'app.eqc.onHireRelease.list',
					{
						url : '/trade/onHireRelease/list',
						data : {
							title : 'List'
						},
						controller : 'onHireReleaseListCtrl',
						templateUrl : 'views/eqc/onHireRelease/onHireReleaseList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqc/onHireRelease/onHireReleaseListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.eqc.onHireRelease.add',
					{
						url : '/trade/onHireRelease/add',
						data : {
							title : 'Add'
						},
						controller : 'onHireReleaseAddCtrl',
						templateUrl : 'views/eqc/onHireRelease/onHireReleaseAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqc/onHireRelease/onHireReleaseAddCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.eqc.onHireRelease.edit',
					{
						url : '/trade/onHireRelease/edit',
						data : {
							title : 'Edit'
						},

						controller : 'onHireReleaseAddCtrl',
						templateUrl : 'views/eqc/onHireRelease/onHireReleaseAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqc/onHireRelease/onHireReleaseAddCtrl.js' ]);
									} ]

						}
					})
					
					.state(
					'app.eqc.onHireRelease.view',
					{
						url : '/trade/onHireRelease/view',
						data : {
							title : 'View'
						},

						controller : 'onHireReleaseAddCtrl',
						templateUrl : 'views/eqc/onHireRelease/onHireReleaseView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/eqc/onHireRelease/onHireReleaseAddCtrl.js' ]);
									} ]

						}
					})/*
// /container Type

			.state('app.master.generalcontainertype', {
				abstract : true,
				templateUrl : "views/common.jsp",
				data : {
					title : 'Container Type'
				}
			})
			.state(
					'app.master.generalcontainertype.containertype',
					{
						url : "/containerType/list",
						templateUrl : "views/containerType/containerTypeList",
						data : {
							title : 'List'
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
					'app.master.generalcontainertype.add',
					{
						controller : "containerTypeAddCtrl",
						url : "/containerType/add",
						templateUrl : "views/containerType/containerTypeAddEdit",
						data : {
							title : 'Add'
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
			.state(
					'app.master.generalcontainertype.edit',
					{
						controller : "containerTypeAddCtrl",
						url : "/containerType/edit",
						templateUrl : "views/containerType/containerTypeAddEdit",
						data : {
							title : 'Edit'
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

			.state(
					'app.master.generalcontainertype.view',
					{
						controller : "containerTypeAddCtrl",
						url : "/containerType/view",
						templateUrl : "views/containerType/ContainerTypeView",
						data : {
							title : 'View'
						},
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/containerType/containerTypeAddEdit.js' ]);
									} ]
						}
					})*/
					
					
}
angular.module('neuboard').config(config).run(function($rootScope, $state) {
	$rootScope.$state = $state;
});
