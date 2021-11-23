function config($stateProvider, $urlRouterProvider, $locationProvider) {
	// define

	$stateProvider
			.state('app.documentation', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Documentation'
				}
			})
			
			$stateProvider.state('app.doc', {
		abstract : true,
		templateUrl : "views/common",
		data : {
			title : 'Documentation'
		}
	})
			
			//B/L Charges - Kishore //
			.state('app.documentation.blcharges', {
				abstract : true,
				templateUrl : "views/common.jsp",
				data : {
					title : 'Bill Of Ladding Charges'
				}
			})

			 .state( 'app.documentation.manifest',
					{
						url : '/documentation/manifestReport',
						data : {
							title : 'Cargo Manifest'
						},

						controller : 'inwardmanifestCtrl',
						templateUrl : 'views/documentation/manifest/inwardManifestReport',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
										.load([ 'js/app/documentation/manifest/inwardManifestReportCtrl.js' ]);
									} ]
						}

					})
				.state(
					'app.documentation.invoice',
					{
						url : '/documentation/invoice',
						data : {
							title : 'Invoice'
						},

						controller : 'invoiceListController',
						templateUrl : 'views/documentation/invoice/invoiceFrg',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
										.load([ 'js/app/documentation/invoice/invoiceListCtrl.js' ]);
									} ]
						}

					})
			.state(
					'app.documentation.invoiceadd',
					{
						url : '/documentation/invoice/add',
						data : {
							title : 'Invoice Generate'
						},

						controller : 'invoiceAddController',
						templateUrl : 'views/documentation/invoice/invoiceFrgAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
										.load([ 'js/app/documentation/invoice/invoiceAddCtrl.js' ]);
									} ]
						}

					})
					.state(
					'app.documentation.invoiceView',
					{
						url : '/documentation/invoice/view',
						data : {
							title : 'Invoice View'
						},

						controller : 'invoiceViewController',
						templateUrl : 'views/documentation/invoice/invoiceView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
										.load([ 'js/app/documentation/invoice/invoiceAddCtrl.js' ]);
									} ]
						}

					})
			//B/L charges
				.state(
					'app.documentation.blcharges.list',
					{
						url : '/documentation/blcharges/list',
						data : {
							title : 'Bill Of Ladding Charges'
						},
						controller : 'blChargesListAddCtrl',
						templateUrl : 'views/documents/blCharges/blChargesListAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/documentation/blCharges/blChargesListAdd.js' ])
									} ]
						}

					})
					
					

			.state('app.operation.deliverOrder', {
				abstract : true,
				templateUrl : "views/common.jsp",
				data : {
					title : 'Delivery Order'
				}
			})
					.state(
					'app.operation.deliverOrder.list',
					{
						url : '/operation/deliverOrder',
						data : {
							title : 'List'
						},

						controller : 'deliverOrderListCtrl',
						templateUrl : 'views/documentation/deliverOrder/deliverOrderList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
										.load([ 'js/app/documentation/deliverOrder/deliverOrderList.js' ]);
									} ]
						}

					})
					
					
					.state(
					'app.operation.deliverOrder.add',
					{
						url : '/operation/deliverOrder/add',
						data : {
							title : 'Add'
						},

						controller : 'deliverOrderAddCtrl',
						templateUrl : 'views/documentation/deliverOrder/deliverOrderAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
										.load([ 'js/app/documentation/deliverOrder/deliverOrderAdd.js' ]);
									} ]
						}

					})
					
					.state(
					'app.operation.deliverOrder.edit',
					{
						url : '/operation/deliverOrder/edit',
						data : {
							title : 'Edit'
						},

						controller : 'deliverOrderAddCtrl',
						templateUrl : 'views/documentation/deliverOrder/deliverOrderAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
										.load([ 'js/app/documentation/deliverOrder/deliverOrderAdd.js' ]);
									} ]
						}

					})
					.state(
					'app.operation.deliverOrder.view',
					{
						url : '/operation/deliverOrder/view',
						data : {
							title : 'View'
						},

						controller : 'deliverOrderAddCtrl',
						templateUrl : 'views/documentation/deliverOrder/deliverOrderView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
										.load([ 'js/app/documentation/deliverOrder/deliverOrderAdd.js' ]);
									} ]
						}

					})
							
					// bl ladding
			.state('app.documentation.bladding', {
				abstract : true,
				templateUrl : "views/common.jsp",
				data : {
					title : 'Inward BL'
				}
			})
			
			
				// bl ladding list
			// bl ladding list
				/*.state(
					'app.documentation.bladding.list',
					{
						url : '/documentation/inwardBl/list',
						data : {
							title : 'List'
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
					'app.documentation.bladding.add',
					{
						url : '/documentation/inwardBl/add',
						data : {
							title : 'Add'
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

					})*/
					// bl ladding edit
						/*	.state(
					'app.documentation.bladding.edit',
					{
						url : '/documentation/inwardBl/edit',
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
					})*/
						.state('app.documentation.blswitch', {
				abstract : true,
				templateUrl : "views/common.jsp",
				data : {
					title : 'BL Tool'
				}
			})
					
			.state(
					'app.documentation.blswitch.blswitchcntrl',
					{
						url : '/documentation/blTool/switch_merge_split',
						data : {
							title : 'List'
						},
						controller : 'switchBLCtrl',
						templateUrl : 'views/operation/blSwitch/switchBLView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/operation/switchBL/switchBLCntrl.js' ])
									} ]
						}

					})
					
						.state('app.documentation.outwardbladding', {
				abstract : true,
				templateUrl : "views/common.jsp",
				data : {
					title : 'Export BL'
				}
			})
			
					
					.state(
					'app.documentation.outwardbladding.outwardlist',
					{
						url : '/documentation/outwardBl/list',
						data : {
							title : 'List'
						},
						controller : 'bladdingCtrl',
						templateUrl : 'views/operation/outward/outwardList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/operation/outward/outward.js' ])
									} ]
						}

					})
					// bl ladding add
				.state(
					'app.documentation.outwardbladding.outwardadd',
					{
						url : '/documentation/outwardBl/add',
						data : {
							title : 'Add'
						},
						controller : 'bladdingAddCtrl',
						templateUrl : 'views/operation/outward/outwardAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/operation/outward/outwardAdd.js' ])
									} ]
						}

					})
					// bl ladding edit
							.state(
					'app.documentation.outwardbladding.outwardedit',
					{
						url : '/documentation/outwardBl/edit',
						data : {
							title : 'Edit'
						},

						controller : 'bladdingAddCtrl',
						templateUrl : 'views/operation/outward/outwardAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/operation/outward/outwardAdd.js' ]);
									} ]

						}
					})
					//inward 
					.state('app.documentation.inwardbladding', {
				abstract : true,
				templateUrl : "views/common.jsp",
				data : {
					title : 'Import BL'
				}
			})
			
					
					.state(
					'app.documentation.inwardbladding.inwardlist',
					{
						url : '/documentation/inwardBl/list',
						data : {
							title : 'List'
						},
						controller : 'bladdingCtrl1',
						templateUrl : 'views/operation/inward/inwardList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/operation/inward/inward.js' ])
									} ]
						}

					})
					// bl ladding add
				.state(
					'app.documentation.inwardbladding.inwardadd',
					{
						url : '/documentation/inwardBl/add',
						data : {
							title : 'Add'
						},
						controller : 'bladdingAddCtrl1',
						templateUrl : 'views/operation/inward/inwardAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/operation/inward/inwardAdd.js' ])
									} ]
						}

					})
					// bl ladding edit
							.state(
					'app.documentation.inwardbladding.inwardedit',
					{
						url : '/documentation/inwardBl/edit',
						data : {
							title : 'Edit'
						},

						controller : 'bladdingAddCtrl1',
						templateUrl : 'views/operation/inward/inwardAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/operation/inward/inwardAdd.js' ]);
									} ]

						}
					})
						//inward 
					.state('app.documentation.inwardbladdingApproval', {
				abstract : true,
				templateUrl : "views/common.jsp",
				data : {
					title : 'Import BL Approval'
				}
			})
			
					
					.state(
					'app.documentation.inwardbladdingApproval.inwardlistApproval',
					{
						url : '/documentation/inwardBlApproval/list',
						data : {
							title : 'List'
						},
						controller : 'bladdingCtrl1Approval',
						templateUrl : 'views/operation/inwardApproval/inwardApprovalList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/operation/inwardApproval/inwardApproval.js' ])
									} ]
						}

					})
					// bl ladding add
				.state(
					'app.documentation.inwardbladdingApproval.inwardApprovaladd',
					{
						url : '/documentation/inwardBlApproval/add',
						data : {
							title : 'Add'
						},
						controller : 'bladdingAddCtrl1Approval',
						templateUrl : 'views/operation/inwardApproval/inwardApprovalAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/operation/inwardApproval/inwardApprovalAdd.js' ])
									} ]
						}

					})
					// bl ladding edit
							.state(
					'app.documentation.inwardbladdingApproval.inwardApprovaledit',
					{
						url : '/documentation/inwardBlApproval/Approval',
						data : {
							title : 'Edit'
						},

						controller : 'bladdingAddCtrl1Approval',
						templateUrl : 'views/operation/inwardApproval/inwardApprovalAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/operation/inwardApproval/inwardApprovalAdd.js' ]);
									} ]

						}
					})

//excel
					
					.state( 'app.documentation.exportmanifest',
							{
								url : '/documentation/exportmanifestReport',
								data : {
									title : 'Export Cargo Manifest'
								},

								controller : 'exportManifestCtrl',
								templateUrl : 'views/documentation/manifest/exportManifestReport',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
												.load([ 'js/app/documentation/manifest/exportManifestReportCtrl.js' ]);
											} ]
								}

							})
							.state('app.documentation.shipmentorder', {
							abstract : true,
							templateUrl : "views/common",
							data : {
								title : 'Shipping Instructions'
							}
						})
						
						//Delivery Order
						.state('app.documentation.deliveryorder', {

							abstract : true,
							templateUrl : "views/common",
							data : {
								title : 'Delivery Order'
							}
						})
						
								
								.state( 'app.documentation.shipmentorder.list',
								{
									url : '/documentation/shipmentorder/list',
									data : {
										title : 'List'
									},
									controller : 'shipmentOrderCtrl',
									templateUrl : 'views/operation/shipmentorder/shipmentorderList',
									resolve : {
										deps : [
												'$ocLazyLoad',
												function($ocLazyLoad) {
													return $ocLazyLoad
															.load([ 'js/app/operation/shipmentorder/shipmentorderCtrl.js' ]);
												} ]
									}
								})

								
								
						.state(
								'app.documentation.shipmentorder.add',
								{
									url : '/documentation/shipmentorder/add',
									data : {
										title : 'Add'
									},
									controller : 'shipmentOrderAddCtrl',
									templateUrl : 'views/operation/shipmentorder/shipmentorderAdd',
									resolve : {
										deps : [
												'$ocLazyLoad',
												function($ocLazyLoad) {
													return $ocLazyLoad
															.load([ 'js/app/operation/shipmentorder/shipmentorderAddCtrl.js' ]);
												} ]
									}
								})
								
								
								.state(
								'app.documentation.shipmentorder.edit',
								{
									url : "/documentation/shipmentorder/edit",
									data : {
										title : 'Edit'
									},
									controller : 'shipmentOrderAddCtrl',
									templateUrl : 'views/operation/shipmentorder/shipmentorderAdd',
									resolve : {
										deps : [
												'$ocLazyLoad',
												function($ocLazyLoad) {
													return $ocLazyLoad
															.load([ 'js/app/operation/shipmentorder/shipmentorderAddCtrl.js' ]);
												} ]
									}
								})
								
								.state( 'app.documentation.shipmentorder.view',
								{
									url : "/documentation/shipmentorder/view",
									data : {
										title : 'Edit'
									},
									controller : 'shipmentOrderAddCtrl',
									templateUrl : 'views/operation/shipmentorder/shipmentorderView',
									resolve : {
										deps : [
												'$ocLazyLoad',
												function($ocLazyLoad) {
													return $ocLazyLoad
															.load([ 'js/app/operation/shipmentorder/shipmentorderAddCtrl.js' ]);
												} ]
									}
								})
								.state('app.documentation.bldraft', {
									abstract : true,
									templateUrl : "views/common.jsp",
									data : {
										title : 'BL Draft'
									}
								})
								
								
									.state(
								'app.documentation.bldraft.bldraftlist',
								{
									url : '/documentation/outwardBlDraft/bldraftlist',
									data : {
										title : 'List'
									},
									controller : 'bldraftCtrl',
									templateUrl : '/views/operation/BLDraft/BLDraftList',
									resolve : {
										deps : [
												'$ocLazyLoad',
												function($ocLazyLoad) {
													return $ocLazyLoad
															.load([ 'js/app/operation/BLDraft/bldraftCtrl.js' ])
												} ]
									}

								})

									.state(
								'app.documentation.bldraft.bldraftAdd',
								{
									url : '/documentation/outwardBlDraft/bldraftAdd',
									data : {
										title : 'Add'
									},
									controller : 'bLDraftAddCtrl',
									templateUrl : '/views/operation/BLDraft/BLDraftAdd',
									resolve : {
										deps : [
												'$ocLazyLoad',
												function($ocLazyLoad) {
													return $ocLazyLoad
															.load([ 'js/app/operation/BLDraft/blDraftAddCtrl.js' ])
												} ]
									}

								})
								.state('app.documentation.inwardbldraft', {
									abstract : true,
									templateUrl : "views/common.jsp",
									data : {
										title : 'BL Draft'
									}
								})
								
								
									.state(
								'app.documentation.inwardbldraft.inwardbldraftlist',
								{
									url : '/documentation/inwardBlDraft/inwardbldraftlist',
									data : {
										title : 'List'
									},
									controller : 'inwardbldraftCtrl',
									templateUrl : '/views/operation/inwardBLDraft/inwardBLDraftList',
									resolve : {
										deps : [
												'$ocLazyLoad',
												function($ocLazyLoad) {
													return $ocLazyLoad
															.load([ 'js/app/operation/inwardBLDraft/inwardbldraftCtrl.js' ])
												} ]
									}

								})

									.state(
								'app.documentation.inwardbldraft.inwardbldraftAdd',
								{
									url : '/documentation/inwardBlDraft/inwardbldraftAdd',
									data : {
										title : 'Add'
									},
									controller : 'inwardbLDraftAddCtrl',
									templateUrl : '/views/operation/inwardBLDraft/inwardBLDraftAdd',
									resolve : {
										deps : [
												'$ocLazyLoad',
												function($ocLazyLoad) {
													return $ocLazyLoad
															.load([ 'js/app/operation/inwardBLDraft/inwardblDraftAddCtrl.js' ])
												} ]
									}

								})
									/*.state('app.documentation.outwardbladding', {
							abstract : true,
							templateUrl : "views/common.jsp",
							data : {
								title : 'BL Detail'
							}
						})
						
								
								.state(
								'app.documentation.outwardbladding.outwardlist',
								{
									url : '/documentation/outwardBl/list',
									data : {
										title : 'List'
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
								'app.documentation.outwardbladding.outwardadd',
								{
									url : '/documentation/outwardBl/add',
									data : {
										title : 'Add'
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
								'app.documentation.outwardbladding.outwardedit',
								{
									url : '/documentation/outwardBl/edit',
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
								})*/
								/*.state('app.documentation.blswitch', {
									abstract : true,
									templateUrl : "views/common.jsp",
									data : {
										title : 'BL Tool'
									}
								})
										
								.state(
										'app.documentation.blswitch.blswitchcntrl',
										{
											url : '/documentation/blTool/switch_merge_split',
											data : {
												title : 'List'
											},
											controller : 'switchBLCtrl',
											templateUrl : 'views/documents/blSwitch/switchBLView',
											resolve : {
												deps : [
														'$ocLazyLoad',
														function($ocLazyLoad) {
															return $ocLazyLoad
																	.load([ 'js/app/master/documentation/switchBL/switchBLCntrl.js' ])
														} ]
											}

										})*/
										
 .state(
					'app.documentation.bldraft.BLDetail1',
					{
						url : '/reports/BLDetail',
						data : {
							title : 'View'
						},

						controller : 'poPopupCtrl',
						templateUrl : '/views/eqc/containerBank/BLDetailPopup',
						resolve : {
							deps : [
								'$ocLazyLoad',
								function($ocLazyLoad) {
									return $ocLazyLoad
											.load([ 'js/app/eqc/containerBank/containerBankListCtrl.js' ])
								} ]

						}

					})
					.state(
					'app.documentation.bldraft.BLDetail2',
					{
						url : '/reports/inWardBLDetail',
						data : {
							title : 'View'
						},

						controller : 'poPopupCtrl1',
						templateUrl : '/views/eqc/containerBank/BLDetailPopup1',
						resolve : {
							deps : [
								'$ocLazyLoad',
								function($ocLazyLoad) {
									return $ocLazyLoad
											.load([ 'js/app/eqc/containerBank/containerBankListCtrl.js' ])
								} ]

						}

					})
					
					
						//PL REPORT
					
					$stateProvider.state('app.doc.plreport', {
		abstract : true,
		templateUrl : "views/common",
		data : {
			title : 'JobOrder Wise P&L Report'
		}
	})
	
	
	.state(
			'app.doc.plreport.list',
			{
				url : '/p&lreport/list',
				data : {
					title : 'List'
				},
				controller : 'joborderplctrl',
				templateUrl : 'views/documentation/joborderplreport/joborderplreportList',
				resolve : {
					deps : [
							'$ocLazyLoad',
							function($ocLazyLoad) {
								return $ocLazyLoad
										.load([ 'js/app/documentation/joborderplreport/joborderplreportCtrl.js' ]);
							} ]
				}
			})
			// docs invoice start
					
					.state(
					'app.documentation.docsinvoice',
					{
						url : '/documentation/imp/invoice',
						data : {
							title : 'Import Invoice'
						},

						controller : 'importInvoiceCtrl',
						templateUrl : 'views/finance/invoice/importInvoice/importInvoice',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
										.load([ 'js/app/finance/invoice/importInvoice.js' ]);
									} ]
						}

					})
			.state(
					'app.documentation.docsinvoiceadd',
					{
						url : '/documentation/imp/invoice/add',
						data : {
							title : 'Import Invoice Generate'
						},

						controller : 'importInvoiceAddCtrl',
						templateUrl : 'views/finance/invoice/importInvoice/importInvoiceAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
										.load([ 'js/app/finance/invoice/importInvoice.js' ]);
									} ]
						}

					})
					
					.state(
					'app.documentation.docsinvoiceEdit',
					{
						url : '/documentation/imp/invoice/edit/:InvoiceNo',
						data : {
							title : 'Import Invoice View'
						},

						controller : 'importInvoiceAddCtrl',
						templateUrl : 'views/finance/invoice/importInvoice/importInvoiceAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
										.load([ 'js/app/finance/invoice/importInvoice.js' ]);
									} ]
						}

					})
					.state(
					'app.documentation.docsinvoiceView',
					{
						url : '/documentation/imp/invoice/view/:invoiceNo',
						data : {
							title : 'Import Invoice View'
						},

						controller : 'importInvoiceViewCtrl',
						templateUrl : 'views/finance/invoice/importInvoice/importInvoiceView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
										.load([ 'js/app/finance/invoice/importInvoice.js' ]);
									} ]
						}

					})
}
angular.module('neuboard').config(config).run(function($rootScope, $state) {
	$rootScope.$state = $state;
});
