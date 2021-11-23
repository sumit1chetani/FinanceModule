function config($stateProvider, $urlRouterProvider, $locationProvider) {

	$stateProvider.state('app', {
		url : "/{tenantid}",
		abstract : true,
		templateUrl : "views/common",
		data : {
			title : ''
		}
	})
	

	$stateProvider.state('app.salesmarketing', {
		templateUrl : "views/common",
		abstract : true,
		data : {
			title : 'Sea'
		}
	});

	$stateProvider.state('app.salesmarketing.pricing', {
		abstract : true,
		data : {
			title : 'Pricing'
		}
	})

	$stateProvider.state('app.salesmarketing.operation', {
		abstract : true,
		data : {
			title : 'Operation'
		}
	})

	$stateProvider.state('app.edi', {
		abstract : true,
		data : {
			title : 'Sea'
		}
	})
	
	$stateProvider.state('app.edi.invoice', {
		abstract : true,
		data : {
			title : 'Sea Purchse Invoice'
		}
	})
	
	

	$stateProvider
			.state('app.salesmarketing.report', {
				abstract : true,
				data : {
					title : 'Report'
				}
			})
			.state('app.finance', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : ''
				}
			})

			.state('app.admin', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Admin'
				}
			})

			.state('app.master.financeControl', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Finance Control'
				}
			})

			.state('app.finance.invoice', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Invoice'
				}
			})

			.state('app.finance.invoice.PHCInvoicenew', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'PHC Invoice'
				}
			})

			.state('app.finance.transaction', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : ''
				}
			})

			.state('app.finance.transaction.pettycashtransferApproval', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Inter Company PettyCash Transfer'
				}
			})
			.state('app.finance.transaction.pettycashApproval', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'PettyCash Approval'
				}
			})
			.state('app.finance.tax', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Tax'
				}
			})

			.state('app.finance.transaction.journalvoucher', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Journal Voucher'
				}
			})

			.state('app.finance.transaction.jvmodula', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Joint Venture Accounts'
				}
			})

			.state('app.finance.reports', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Reports'
				}
			})
			.state('app.finance.reports.financial', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Financial'
				}
			})

			.state('app.finance.accounts', {
				abstract : true,
				templateUrl : "views/common.jsp",
				data : {
					title : 'Accounts'
				}
			})
			.state('app.finance.asset', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Asset'
				}
			})

			.state('app.finance.asset.manage', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Manage'
				}
			})

			.state('app.finance.inventory', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Inventory'
				}
			})
			.state('app.finance.purchase', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Purchase'
				}
			})

			.state('app.finance.reports.income', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Income'
				}
			})

			.state('app.finance.reports.receivable', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Receivable'
				}
			})
			.state('app.finance.reports.payable', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Payable'
				}
			})
			.state('app.finance.transaction.freightmanifest', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Job Daily Status'
				}
			})
				.state('app.finance.transaction.deliveryorder', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Delivery report'
				}
			})
			
			.state('app.finance.transaction.salespersonwise', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Sales Personwise Report'
				}
			})
			
				.state('app.finance.transaction.customeranalysis', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Customer Analysis report'
				}
			})
			
				.state('app.finance.transaction.joborder', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Job Order report'
				}
			})
 			.state('app.finance.configuration', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Configuration'
				}
			})
			.state('app.finance.controlscreen', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Control Screen'
				}
			})
			.state('app.finance.configuration.accounthead', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Account Head'
				}
			})
			.state('app.finance.controlscreen.pettycash', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Petty Cash'
				}
			})
			.state('app.finance.controlscreen.pettycash.intercompanytransfer', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'InterCompany Transfer'
				}
			})
			.state('app.finance.controlscreen.pettycash.intercompanytransferapproval', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'InterCompany Transfer Approval'
				}
			})
			.state('app.finance.configuration.subgroupaccount', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'SubGroup Account'
				}
			})
			.state('app.finance.configuration.grouphead', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Group Head'
				}
			})
			.state('app.finance.configuration.currency', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Currency'
				}
			})

			.state('app.finance.configuration.chartofaccounts', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Chart Of Accounts'
				}
			})

			.state('app.finance.controlscreen.tariff', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Tariff'
				}
			})

			.state('app.finance.controlscreen.accounting', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Accounting year close'
				}
			})
			.state('app.finance.reports.jointvoucher', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Joint Venture'
				}
			})

			.state('app.mis', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'MIS'
				}
			})

			
			.state('app.mis.schedules', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Schedules'
				}
			})
	
			
			
	$stateProvider.state('app.salesmarketing.bookingtool', {
		abstract : true,
		templateUrl : "views/common",
		url : '/bookingTool',
		data : {
			title : 'Booking'
		}
	})
	
	
		$stateProvider.state('app.salesmarketing.booking', {
		abstract : true,
		templateUrl : "views/common",
		url : '/booking',
		data : {
			title : 'Booking'
		}
	})
	
				
	$stateProvider.state('app.salesmarketing.salebooking', {
		abstract : true,
		templateUrl : "views/common",
		url : '/salesbooking',
		data : {
			title : 'Booking'
		}
	})
	
	
	
// delivery
			.state(
					'app.finance.transaction.deliveryorder.search',
					{
						url : '/reports/deliveryorder/search',
						data : {
							title : 'Search'
						},
						controller : 'deliveryOrderCtrl',
						templateUrl : 'views/finance/transaction/DeliveryOrderSearch',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/DeliveryOrderCtrl.js' ])
									} ]
						}
					})
			.state(
					'app.finance.transaction.deliveryorder.view',
					{
						url : '/transaction/deliveryorder/view',
						data : {
							title : 'List'
						},
						controller : 'deliveryOrderCtrl',
						templateUrl : 'views/finance/transaction/DeliveryOrderView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/DeliveryOrderCtrl.js' ])
									} ]
						}
					})
					
// sales personwise
					
					
					.state(
					'app.finance.transaction.salespersonwise.search',
					{
						url : '/reports/salespersonwise/search',
						data : {
							title : 'Search'
						},
						controller : 'salesPersonwiseCtrl',
						templateUrl : 'views/finance/transaction/SalesPersonWiseSearch',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/SalesPersonWiseCtrl.js' ])
									} ]
						}
					})
			.state(
					'app.finance.transaction.salespersonwise.view',
					{
						url : '/transaction/salespersonwise/view',
						data : {
							title : 'List'
						},
						controller : 'salesPersonwiseCtrl',
						templateUrl : 'views/finance/transaction/SalesPersonWiseView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/SalesPersonWiseCtrl.js' ])
									} ]
						}
					})
					
				// customer analysis
					.state(
					'app.finance.transaction.customeranalysis.report',
					{
						url : '/reports/customeranalysis/report',
						data : {
							title : ''
						},
						controller : 'customerAnalysisCtrl',
						templateUrl : 'views/finance/transaction/customerAnalysisReport',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/customerAnalysisCtrl.js' ])
									} ]
						}
					})
					
				// job order
					
			.state(
					'app.finance.transaction.joborder.search',
					{
						url : '/reports/joborder/search',
						data : {
							title : 'Search'
						},
						controller : 'jobOrderCtrl',
						templateUrl : 'views/finance/transaction/JobOrderSearch',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/JobOrderCtrl.js' ])
									} ]
						}
					})
			.state(
					'app.finance.transaction.joborder.view',
					{
						url : '/transaction/joborder/view',
						data : {
							title : 'List'
						},
						controller : 'jobOrderCtrl',
						templateUrl : 'views/finance/transaction/JobOrderView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/JobOrderCtrl.js' ])
									} ]
						}
					})
			// Budget

			.state('app.finance.budget', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Budget'
				}
			})

			.state('app.finance.budget.budgetType', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Budget Type'
				}
			})

			.state('app.finance.budget.budgetAllocation', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Budget Allocation'
				}
			})

			.state('app.finance.budget.budgetApproval', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Budget Approval'
				}
			})

			.state('app.finance.budget.budgetOverview', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Budget Overview'
				}
			})
			.state('app.finance.gST', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'GST report'
				}
			})

			// currency

			.state(
'app.finance.configuration.currency.list',					
{
						url : '/configuration/currency',
						data : {
							title : 'List'
						},
						controller : 'currencyController',
						templateUrl : 'views/finance/currency/currencyList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/currency/currencyListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.finance.configuration.currencyadd',
					{
						url : '/configuration/currency/add',
						data : {
							title : 'Add'
						},
						controller : 'currencyAddCtrl',
						templateUrl : 'views/finance/currency/currencyAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/currency/currencyAddCtrl.js' ])
									} ]
						}
					})

			.state(
					'app.finance.configuration.currency.view',
					{
						url : '/configuration/currency/view',
						data : {
							title : 'View'
						},
						controller : 'currencyAddCtrl',
						templateUrl : 'views/finance/currency/currencyView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/currency/currencyAddCtrl.js' ])
									} ]
						}
					})
			// Account Head
			.state(
					'app.finance.configuration.accounthead.list',
					{
						url : '/configuration/accounthead/AccountHeadList',
						data : {
							title : 'List'
						},
						controller : 'AccountHeadListCtrl',
						templateUrl : 'views/finance/controlscreen/accounthead/AccountHeadList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/accounthead/AccountHeadListCtrl.js' ]);
									} ]
						}
					})
			// Fuel Voucher Entry

			.state(
					'app.operation.fuelvoucherentry',
					{
						url : '/operation/fuelvoucherentry/fuelvoucherentryList',
						data : {
							title : 'Fuel Voucher Entry'
						},
						controller : 'fuelvoucherentryList',
						templateUrl : 'views/finance/controlscreen/fuelvoucherentry/fuelvoucherentryList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/fuelvoucherentry/fuelvoucherentryListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.operation.fuelvoucherentry-add',
					{
						url : '/operation/fuelvoucherentry/add',
						data : {
							title : 'Add'
						},
						controller : 'fuelvoucherentryAddCtrl',
						templateUrl : 'views/finance/controlscreen/fuelvoucherentry/fuelvoucherentryAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/fuelvoucherentry/fuelvoucherentryAddCtrl.js' ])
									} ]
						}
					})

			.state(
					'app.operation.fuelvoucherentry-View',
					{
						url : '/operation/fuelvoucherentry/view',
						data : {
							title : 'View'
						},
						controller : 'fuelvoucherentryAddCtrl',
						templateUrl : 'views/finance/controlscreen/fuelvoucherentry/fuelvoucherentryView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/fuelvoucherentry/fuelvoucherentryAddCtrl.js' ])
									} ]
						}
					})

			// Fuel Voucher Entry ends

			//					
			//					
			// //VAT Configration
			//					
			.state(
					'app.finance.controlscreen.taxcharge',
					{
						url : '/controlscreen/taxcharge/taxchargeList',
						data : {
							title : 'Tax Charges'
						},
						controller : 'taxchargelistctrl',
						templateUrl : 'views/finance/controlscreen/taxchargees/taxchargeesList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/taxcharges/taxchargesListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.finance.controlscreen.taxcharge-add',
					{
						url : '/controlscreen/taxcharges/add',
						data : {
							title : 'Add'
						},
						controller : 'taxchargesaddctrl',
						templateUrl : 'views/finance/controlscreen/taxchargees/taxchargeesadd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/taxcharges/taxchargesaddCtrl.js' ])
									} ]
						}
					})

			.state(
					'app.finance.controlscreen.taxcharge-view',
					{
						url : '/controlscreen/taxcharges/view',
						data : {
							title : 'View'
						},
						controller : 'taxchargesaddctrl',
						templateUrl : 'views/finance/controlscreen/taxchargees/taxchargesview',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/taxcharges/taxchargesaddCtrl.js' ])
									} ]
						}
					})
			// VAT Configiration Entry ends

			// / User LOG
			.state(
					'app.admin.userlog',
					{
						url : '/admin/userlog/list',
						data : {
							title : 'User Log'
						},
						controller : 'userloglistctrl',
						templateUrl : 'views/finance/controlscreen/taxchargees/UserlogList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/taxcharges/Userlogslistctrl.js' ]);
									} ]
						}
					})

			// / User Rights
			.state(
					'app.admin.usermaster',
					{
						url : '/admin/userrights/list',
						data : {
							title : 'User Rights'
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
					
					.state(
					'app.admin.draftmove',
					{
						url : '/admin/draftmove/list',
						data : {
							title : 'Invoice Move Final To Draft'
						},

						controller : 'invoiceDraftMoveCtrl',
						templateUrl : 'views/master/user/invoiceDraftMove',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/user/invoiceDraftMoveCtrl.js' ]);
									} ]
						}

					})
					
						.state(
					'app.admin.invoice',
					{
						url : '/admin/Invoice/list',
						data : {
							title : 'Invoice Allocated List'
						},

						controller : 'invoiceListCtrl',
						templateUrl : 'views/master/user/Invoice',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/user/invoiceListCtrl.js' ]);
									} ]
						}

					})
					
					
			// Account attributes
			.state(
					'app.finance.controlscreen.attributes',
					{
						url : '/controlscreen/attributes/attributesList',
						data : {
							title : 'Account attributes'
						},
						controller : 'attributesListCtrl',
						templateUrl : 'views/finance/controlscreen/attributes/attributesList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/attributes/attributesCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.finance.controlscreen.attributesadd',
					{
						url : '/controlscreen/attributes/attributesAdd',
						data : {
							title : 'Add Account attributes'
						},
						controller : 'attributesAddCtrl',
						templateUrl : 'views/finance/controlscreen/attributes/attributesAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/attributes/attributesCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.finance.controlscreen.attributesedit',
					{
						url : '/controlscreen/attributes/attributesEdit/:attributeId',
						data : {
							title : 'Account attributes'
						},
						controller : 'attributesEditCtrl',
						templateUrl : 'views/finance/controlscreen/attributes/attributesAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/attributes/attributesCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.finance.configuration.accounthead-add',
					{
						url : '/configuration/accounthead/AccountHeadAdd',
						data : {
							title : 'Add'
						},
						controller : 'AccountHeadAddCtrl',
						templateUrl : 'views/finance/controlscreen/accounthead/AccountHeadAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/accounthead/AccountHeadAddCtrl.js' ])
									} ]
						}
					})

			.state(
					'app.finance.configuration.accounthead-add1',
					{
						url : '/configuration/accounthead/AccountHeadView',
						data : {
							title : 'Add'
						},
						controller : 'AccountHeadAddCtrl',
						templateUrl : 'views/finance/controlscreen/accounthead/AccountHeadView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/accounthead/AccountHeadAddCtrl.js' ])
									} ]
						}
					})

			.state('app.finance.invoice.SendMailInvoice', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Send Mail'
				}
			})

			.state(
					'app.finance.invoice.SendMailInvoice.list',
					{
						url : '/invoice/SendMailInvoice',
						data : {
							title : 'Send Mail'
						},
						controller : 'invoiceViewController',
						templateUrl : 'views/finance/invoice/invoiceSendMail',
						resolve : {

							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/invoiceView.js' ])
									} ]
						}
					})

			// list
			.state(
					'app.finance.invoice.view',
					{
						url : '/invoice/invoiceview',
						data : {
							title : 'Invoice View'
						},
						controller : 'invoiceController',
						templateUrl : 'views/finance/invoice/invoiceView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/invoiceCtrl.js' ]);
									} ]
						}
					})
			// add
			.state(
					'app.finance.invoice.invoiceadd',
					{
						url : '/invoice/invoiceAdd',
						data : {
							title : 'Invoice View'
						},
						controller : 'invoiceAddController',
						templateUrl : 'views/finance/invoice/invoiceAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/invoiceAddCtrl.js' ]);
									} ]
						}
					})

			// view
			.state(
					'app.finance.invoice.viewsingleinvoice',
					{
						url : '/invoice/singleInvoiceView/:invoiceNo',
						data : {
							title : 'View Single Invoice '
						},
						controller : 'singleInvoiceViewController',
						templateUrl : 'views/finance/invoice/singleinvoiceview',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/invoiceCtrl.js' ]);
									} ]
						}
					})
			.state(
					'app.finance.invoice.viewsingleinvoice1',
					{
						url : '/invoice/singleInvoiceView1/:invoiceNo1',
						data : {
							title : 'View Single Invoice '
						},
						controller : 'singleInvoiceViewController',
						templateUrl : 'views/finance/invoice/singleinvoiceview',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/invoiceCtrl.js' ]);
									} ]
						}
					})

			// ReverseView

			.state(
					'app.finance.invoice.invoiceReverseView',
					{
						url : '/invoice/invoiceReverseView/:invoiceNo',
						data : {
							title : 'Invoice Reverse View'
						},
						controller : 'invoiceReverseViewController',
						templateUrl : 'views/finance/invoice/invoiceReverseView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/invoiceCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.finance.transaction.journalvoucher.list',
					{
						url : '/transaction/journalvoucher/list',
						data : {
							title : 'List'
						},
						controller : 'journalVoucherCtrl',
						templateUrl : 'views/finance/transaction/journalVoucherpage',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/journalVoucherCtrl.js' ])
									} ]
						}
					})
			.state(
					'app.finance.transaction.journalvoucher-draft',
					{
						url : '/transaction/journalvoucher/draft',
						data : {
							title : 'Journal Voucher Drafts'
						},
						controller : 'journalVoucherDraftCtrl',
						templateUrl : 'views/finance/transaction/journalVoucherpageDraft',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/journalVoucherCtrl.js' ]);
									} ]
						}
					})
			.state(
					'app.finance.transaction.journalvoucher.add',
					{
						url : '/transaction/journalvoucher/add',
						data : {
							title : 'Add'
						},
						controller : 'journalVoucherCtrlAdd',
						templateUrl : 'views/finance/transaction/journalVoucheradd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/journalVoucherCtrlAdd.js' ])
									} ]
						}
					})
			.state(
					'app.finance.transaction.journalvoucher.edit',
					{
						url : '/transaction/journalvoucher/edit/:jvNumber',
						data : {
							title : 'Edit'
						},
						controller : 'journalVoucherCtrlAdd',
						templateUrl : 'views/finance/transaction/journalVoucheredit',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/journalVoucherCtrlAdd.js' ])
									} ]
						}
					})
			.state(
					'app.finance.transaction.journalvoucher.edit1',
					{
						url : '/transaction/journalvoucher/editTemp/:jvNumber1',
						data : {
							title : 'Edit'
						},
						controller : 'journalVoucherCtrlAdd',
						templateUrl : 'views/finance/transaction/journalVoucheradd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/journalVoucherCtrlAdd.js' ])
									} ]
						}
					})
			.state(
					'app.finance.transaction.journalvoucher.copyJournalVoucher',
					{
						url : '/transaction/journalvoucher/copyJournalVoucher/:jvNumber',
						data : {
							title : 'Copy'
						},
						controller : 'journalVoucherCtrlAdd',
						templateUrl : 'views/finance/transaction/journalVoucheradd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/journalVoucherCtrlAdd.js' ])
									} ]
						}
					})
			.state(
					'app.finance.transaction.journalvoucher.view',
					{
						url : '/transaction/journalvoucher/view/:jvNumber',
						data : {
							title : 'View'
						},
						controller : 'journalVoucherViewCtrl',
						templateUrl : 'views/finance/transaction/journalVoucherView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/journalVoucherCtrlAdd.js' ])
									} ]
						}
					})
			.state(
					'app.finance.transaction.journalvoucher.view1',
					{
						url : '/transaction/journalvoucher/view1/:jvNumber1',
						data : {
							title : 'View'
						},
						controller : 'journalVoucherViewCtrl',
						templateUrl : 'views/finance/transaction/journalVoucherView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/journalVoucherCtrlAdd.js' ])
									} ]
						}
					})

			// Debit Note

			.state(
					'app.finance.transaction.debitnote',
					{
						url : '/transaction/debitnote',
						data : {
							title : 'Debit Note'
						},
						controller : 'debitNoteController',
						templateUrl : 'views/finance/transaction/debitNoteList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/debitNoteListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.finance.transaction.debitnoteAdd',
					{
						url : '/transaction/debitnote/add',
						data : {
							title : 'Add'
						},
						controller : 'debitNoteAddCtrl',
						templateUrl : 'views/finance/transaction/debitNoteAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/debitNoteAddCtrl.js' ])
									} ]
						}
					})

			.state(
					'app.finance.transaction.debitnoteEdit',
					{
						url : '/transaction/debitnote/edit',
						data : {
							title : 'Edit'
						},
						controller : 'debitNoteAddCtrl',
						templateUrl : 'views/finance/transaction/debitNoteAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/debitNoteAddCtrl.js' ])
									} ]
						}
					})
			.state(
					'app.finance.transaction.debitnoteView',
					{
						url : '/transaction/debitnote/view',
						data : {
							title : 'View'
						},
						controller : 'debitNoteViewCtrl',
						templateUrl : 'views/finance/transaction/debitNoteView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/debitNoteAddCtrl.js' ])
									} ]
						}
					})

			// Petty Cash Approval

			.state(
					'app.finance.transaction.pettycashApproval.list',
					{
						url : '/transaction/pettycashApproval',
						data : {
							title : ''
						},
						controller : 'pettCashApprovalCtrl',
						templateUrl : 'views/finance/transaction/pettyCashApprovalList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/pettycashApprovalCtrl.js' ]);
									} ]
						}
					})
			.state(
					'app.finance.transaction.pettycashApproval.edit',
					{
						url : '/transaction/pettycashApproval/edit/:voucherNo',
						data : {
							title : 'Edit'
						},
						controller : 'pettCashApprovalAddCtrl',
						templateUrl : 'views/finance/transaction/pettyCashApprovalEdit',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/pettycashApprovalCtrl.js' ])
									} ]
						}

					})
			.state('app.finance.controlscreen.pettycash.intercompanytransfer.list',					{
						url : '/transaction/interCompanyPettyCashTransfer/List',
						data : {
							title : 'List'
						},
						controller : 'pettCashtransferApprovalCtrl',
						templateUrl : 'views/finance/transaction/pettycashtransferApprovalList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/pettycashtransferApprovalCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.finance.controlscreen.pettycash.intercompanytransfer.add',
					{
						url : '/transaction/interCompanyPettyCashTransfer/Add',
						data : {
							title : 'Add'
						},
						controller : 'pettCashtransferApprovalAddCtrl',
						templateUrl : 'views/finance/transaction/pettycashtransferApprovalAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/pettycashtransferApprovalCtrl.js' ]);
									} ]
						}
					})
			.state(
					'app.finance.controlscreen.pettycash.intercompanytransfer.edit',
					{
						url : '/transaction/interCompanyPettyCashTransfer/Edit',
						data : {
							title : 'Edit'
						},
						controller : 'pettCashtransferApprovalAddCtrl',
						templateUrl : 'views/finance/transaction/pettycashtransferApprovalAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/pettycashtransferApprovalCtrl.js' ]);
									} ]
						}

					})

			.state(
					'app.finance.transaction.pettycashtransferApproval.approvalList',
					{
						url : '/transaction/interCompanyPettyCashTransfer/Approve',
						data : {
							title : 'Approve'
						},
						controller : 'pettCashtransferApprovalCtrl',
						templateUrl : 'views/finance/transaction/pettycashtransferApprove',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/pettycashtransferApprovalCtrl.js' ]);
									} ]
						}
					})
			// Payment Order
			.state(
					'app.finance.transaction.paymentorder',
					{
						url : '/transaction/paymentorder',
						data : {
							title : 'Payment Order'
						},
						controller : 'paymentOrderController',
						templateUrl : 'views/finance/transaction/paymentOrderList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/paymentOrderListCtrl.js' ]);
									} ]
						}
					})

			// payment information List

			.state(
					'app.finance.transaction.paymentInformationList',
					{
						url : '/transaction/paymentInformationList',
						data : {
							title : 'Payment Information'
						},
						controller : 'paymentInformationController',
						templateUrl : 'views/finance/transaction/paymentInformationList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/paymentInformationCtrl.js' ]);
									} ]
						}
					})

			// payment information Add

			.state(
					'app.finance.transaction.paymentInformationAdd',
					{
						url : '/transaction/paymentInformationAdd',
						data : {
							title : 'Payment Information Add'
						},
						controller : 'paymentInformationControllerAdd',
						templateUrl : 'views/finance/transaction/paymentInformationAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/paymentInformationCtrl.js' ]);
									} ]
						}
					})

			// payment Order edit

			.state(
					'app.finance.transaction.paymentOrderEdit',
					{
						url : '/transaction/paymentOrderEdit/:paymentOrderNo',
						data : {
							title : 'Edit Payment Order'
						},
						controller : 'paymentOrderControllerEdit',
						templateUrl : 'views/finance/transaction/paymentOrderEdit',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/paymentInformationCtrl.js' ]);
									} ]
						}
					})

			// payment Order view

			.state(
					'app.finance.transaction.paymentOrderView',
					{
						url : '/transaction/paymentOrderView/:paymentOrderNo',
						data : {
							title : 'View Payment Order'
						},
						controller : 'paymentOrderControllerView',
						templateUrl : 'views/finance/transaction/paymentOrderView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/paymentInformationCtrl.js' ]);
									} ]
						}
					})

			/*
			 * Freight Manifest
			 */

			.state(
					'app.finance.transaction.freightmanifest.search',
					{
						url : '/reports/jobdailystatus/search',
						data : {
							title : 'Search'
						},
						controller : 'freightManifestCtrl',
						templateUrl : 'views/finance/transaction/FreightManifestSearch',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/FreightManifestCtrl.js' ])
									} ]
						}
					})
			.state(
					'app.finance.transaction.freightmanifest.view',
					{
						url : '/transaction/freightmanifest/view',
						data : {
							title : 'List'
						},
						controller : 'freightManifestReportCtrl',
						templateUrl : 'views/finance/transaction/FreightManifestView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/FreightManifestCtrl.js' ])
									} ]
						}
					})

			/**
			 * Charter Hire Master
			 */

			.state(
					'app.operations.voyage.charterhiremasterlist',
					{
						url : '/operations/voyage/charterHireMasterList',
						data : {
							title : ' JV CharterHire'
						},
						controller : 'charterHireMasterController',
						templateUrl : 'views/finance/controlscreen/CharterHireMaster/charterHireMasterList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/CharterHireMaster/charterHireMasterListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.operations.voyage.charterhiremasteradd',
					{
						url : '/operations/voyage/charterHireMasterAdd',
						data : {
							title : 'Add'
						},
						controller : 'charterHireMasterAddCtrl',
						templateUrl : 'views/finance/controlscreen/CharterHireMaster/charterHireMasterAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/CharterHireMaster/charterHireMasterAddCtrl.js' ])
									} ]
						}
					})

			.state(
					'app.finance.controlscreen.charterhiremasteredit',
					{
						url : '/operations/voyage/charterHireMasterEdit/:charterHireCode',
						data : {
							title : 'Edit'
						},
						controller : 'charterHireMasterEditCtrl',
						templateUrl : 'views/finance/controlscreen/CharterHireMaster/charterHireMasterAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/CharterHireMaster/charterHireMasterAddCtrl.js' ])
									} ]
						}
					})

			.state(
					'app.finance.controlscreen.charterhiremasterView',
					{
						url : '/operations/voyage/charterHireMasterView/:charterHireCode',
						data : {
							title : 'View'
						},
						controller : 'charterHireMasterEditCtrl',
						templateUrl : 'views/finance/controlscreen/CharterHireMaster/charterHireMasterView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/CharterHireMaster/charterHireMasterAddCtrl.js' ])
									} ]
						}
					})
			/*
			 * Tax View
			 */
			.state(
					'app.finance.tax.taxAdd',
					{
						url : '/tax/taxAdd',
						data : {
							title : 'Add'
						},
						controller : 'taxController',
						templateUrl : 'views/finance/taxAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/tax/taxformCtrl.js' ])
									} ]

						}
					})

			.state(
					'app.finance.configuration.subgroupaccount.list',
					{
						url : '/configuration/subgroupaccount/SubGroupList',
						data : {
							title : 'List'
						},
						controller : 'SubGroupListCtrl',
						templateUrl : 'views/finance/controlscreen/subgroupaccount/SubGroupList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/subgroupaccount/SubGroupListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.finance.configuration.subgroupaccount-add',
					{
						url : '/configuration/subgroupaccount/SubGroupAdd',
						data : {
							title : 'Add'
						},
						controller : 'SubGroupAddCtrl',
						templateUrl : 'views/finance/controlscreen/subgroupaccount/SubGroupAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/subgroupaccount/SubGroupAddCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.finance.configuration.subgroupaccount-add1',
					{
						url : '/configuration/subgroupaccount/SubGroupView',
						data : {
							title : 'Add'
						},
						controller : 'SubGroupAddCtrl',
						templateUrl : 'views/finance/controlscreen/subgroupaccount/SubGroupView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/subgroupaccount/SubGroupAddCtrl.js' ])
									} ]
						}
					})

	$stateProvider
			.state('app.mis.receivable', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Receivable'
				}
			})

			.state(
					'app.mis.receivable.corg',
					{
						url : '/reports/finance/corg',
						data : {
							title : 'CORG'
						},
						
								controller : 'corgCtrl',
								templateUrl : 'views/reports/finance/corg',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/reports/finance/corgCtrl.js' ]);
											} ]

								}
						
					})

			.state(
					'app.mis.receivable.soaCustomer',
					{
						url : '/reports/receivable/soaCustomer',
						data : {
							title : 'SOA Customer'
						},
						controller : 'soaCustomerController',
						templateUrl : 'views/finance/reports/SOACustomernew',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/reports/soaCustomerCtrl.js' ])
									} ]

						}
					})

			.state(
					'app.finance.reports.bankreconciliation',
					{
						url : '/reports/bankreconciliation',
						data : {
							title : 'Bank Reconciliation'
						},
						controller : 'bankreconciliationCtrl',
						templateUrl : 'views/reports/bankReconciliation',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/reports/bankreconciliationCtrl.js' ])
									} ]

						}
					})

			.state(
					'app.finance.reports.bankreconciliationDraft',
					{
						url : '/reports/bankreconciliation/draft',
						data : {
							title : 'Bank Reconciliation Draft'
						},
						controller : 'bankreconciliationDraftCtrl',
						templateUrl : 'views/reports/bankReconciliationDraft',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/reports/bankreconciliationCtrl.js' ])
									} ]

						}
					})

			//
			.state(
					'app.mis.manualreconcillation',
					{
						url : '/reports/manualreconcillation',
						data : {
							title : 'Manual Reconciliation'
						},
						controller : 'manualReconcillationCtrl',
						templateUrl : 'views/reports/manualReconcillation',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/reports/manualReconcillationCtrl.js' ])
									} ]

						}
					})

			

		
          .state('app.finance.reports.analytical', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Analytical'
				}
			})

			.state(
					'app.finance.reports.analytical.operationbudget',
					{
						url : '/reports/analytical/operationbudget',
						data : {
							title : 'Operation Budget and Projection'
						},
						controller : 'operationBudgetAndProjectionCtrl',
						templateUrl : 'views/reports/analytical/operationBudgetAndProjectionList',

						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/reports/operationBudgetAndProjectionCtrl.js' ])
									} ]

						}
					})
			.state(
					'app.finance.reports.analytical.operationbudgetAdd',
					{
						url : '/reports/analytical/operationbudgetAdd',
						data : {
							title : 'Add'
						},
						controller : 'operationBudgetAndProjectionAddCtrl',
						templateUrl : 'views/reports/analytical/operationBudgetAndProjection',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/reports/operationBudgetAndProjectionCtrl.js' ])
									} ]

						}
					})
			.state(
					'app.finance.reports.analytical.revenurregister',
					{
						url : '/reports/analytical/revenueregister',
						data : {
							title : 'Revenue Register'
						},
						controller : 'revenueregisterCtrl',
						templateUrl : 'views/reports/analytical/registerrevenuelist',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/reports/revenueregister.js' ])
									} ]

						}
					})

			.state(
					'app.finance.reports.analytical.arregister',
					{
						url : '/views/reports/arregister/arregister',
						data : {
							title : 'AR Register'
						},
						controller : 'ARregisterCtrl',
						templateUrl : 'views/reports/analytical/ARregisterlist',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/reports/ARregisterCtrl.js' ])
									} ]

						}
					})
			.state(
					'app.finance.reports.analytical.adminbudget',
					{
						url : '/reports/analytical/adminbudget',
						data : {
							title : 'Admin Budget And Projection'
						},
						controller : 'adminBudgetAndProjectionCtrl',
						templateUrl : 'views/reports/analytical/adminBudgetAndProjectionList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/reports/adminBudgetAndProjectionCtrl.js' ])
									} ]
						}
					})

			.state(
					'app.finance.reports.analytical.adminbudgetAdd',
					{
						url : '/reports/analytical/adminbudgetAdd',
						data : {
							title : 'Add'
						},
						controller : 'adminBudgetAndProjectionAddCtrl',
						
						templateUrl : 'views/reports/analytical/adminBudgetAndProjection',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad.load([ 'js/app/finance/reports/adminBudgetAndProjectionCtrl.js' ])
									} ]
						}
					})
							/*
							 * .state(
							 * 'app.finance.controlscreen.assetmaster-add', {
							 * url : '/controlscreen/asset/add', data : { title :
							 * 'Add' }, controller : 'AssetMasterAddCtrl',
							 * templateUrl :
							 * 'views/finance/controlscreen/Asset/AssetMasterAddPage',
							 * resolve : { deps : [ '$ocLazyLoad',
							 * function($ocLazyLoad) { return $ocLazyLoad
							 * .load([
							 * 'js/app/finance/controlscreen/Asset/AssetMasterAddCtrl.js'
							 * ]); } ] } })
							 */

			.state(
					'app.finance.reports.analytical.operatingExpenses',
					{
						url : '/reports/analytical/operatingExpenses',
						data : {
							title : 'Operating Income/Expenses'
						},
						controller : 'operatingExpensesCtrl',
						templateUrl : 'views/reports/analytical/operatingExpensesList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/reports/operatingExpensesCtrl.js' ])
									} ]
						}
					})

			.state(
					'app.finance.controlscreen.assetmaster',
					{
						url : '/controlscreen/asset',
						data : {
							title : 'Asset Master'
						},
						controller : 'AssetMasterCtrl',
						templateUrl : 'views/finance/controlscreen/Asset/AssetMasterListPage',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/Asset/AssetMasterCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.finance.controlscreen.assetmaster-add',
					{
						url : '/controlscreen/asset/add',
						data : {
							title : 'Add'
						},
						controller : 'AssetMasterAddCtrl',
						templateUrl : 'views/finance/controlscreen/Asset/AssetMasterAddPage',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/Asset/AssetMasterAddCtrl.js' ]);
									} ]
						}
					})

			// code for general invoice navigation
			.state(
					'app.finance.invoice.generalinvoice',
					{
						url : '/invoice/generalinvoice/list',
						data : {
							title : 'General Sales Invoice List'
						},
						controller : 'generalInvoiceCtrl',
						templateUrl : 'views/finance/invoice/generalInvoice/generalInvoice',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/generalInvoiceCtrl.js' ])
									} ]
						}
					})

			.state(
					'app.finance.invoice.generalinvoiceadd',
					{
						url : '/invoice/generalinvoice/add',
						data : {
							title : 'General Sales Invoice Add'
						},
						controller : 'generalInvoiceCtrladd',
						templateUrl : 'views/finance/invoice/generalInvoice/generalInvoiceAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/generalInvoiceCtrl.js' ])
									} ]
						}
					})
			.state(
					'app.finance.invoice.generalinvoiceedit',
					{
						url : '/invoice/generalinvoice/edit/:InvoiceNo',
						data : {
							title : 'General Sales Invoice Edit'
						},
						controller : 'generalInvoiceCtrladd',
						templateUrl : 'views/finance/invoice/generalInvoice/generalInvoiceAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/generalInvoiceCtrl.js' ])
									} ]
						}
					})
			.state(
					'app.finance.invoice.generalinvoiceView',
					{
						url : '/invoice/generalinvoice/view/:invoiceNo',
						data : {
							title : 'General Sales Invoice View'
						},
						controller : 'generalInvoiceViewCtrl',
						templateUrl : 'views/finance/invoice/generalInvoice/generalInvoiceView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/generalInvoiceCtrl.js' ])
									} ]
						}
					})
			.state(
					'app.finance.invoice.generalinvoiceView1',
					{
						url : '/invoice/generalinvoice/view1/:invoiceNo1',
						data : {
							title : 'General Sales Invoice View'
						},
						controller : 'generalInvoiceViewCtrl',
						templateUrl : 'views/finance/invoice/generalInvoice/generalInvoiceView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/generalInvoiceCtrl.js' ])
									} ]
						}
					})

			// General Invoice For Woner
			.state(
					'app.finance.invoice.invoiceForOwner',
					{
						url : '/invoice/invoiceForOwner/list',
						data : {
							title : 'General Invoice For Owner'
						},
						controller : 'invoiceForOwnerCtrl',
						templateUrl : 'views/finance/invoice/invoiceForOwner/invoiceForOwnerList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/invoiceForOwner/invoiceForOwnerCtrl.js' ])
									} ]
						}
					})
			.state(
					'app.finance.invoice.invoiceForOwnerAdd',
					{
						url : '/invoice/invoiceForOwner/add',
						data : {
							title : 'General Invoice For Owner'
						},
						controller : 'invoiceForOwnerAddCtrl',
						templateUrl : 'views/finance/invoice/invoiceForOwner/invoiceForOwnerAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/invoiceForOwner/invoiceForOwnerCtrl.js' ])
									} ]
						}
					})
			.state(
					'app.finance.invoice.invoiceForOwnerView',
					{
						url : '/invoice/invoiceForOwner/view/:invoiceNo',
						data : {
							title : 'General Invoice For Woner View'
						},
						controller : 'invoiceForOwnerViewCtrl',
						templateUrl : 'views/finance/invoice/invoiceForOwner/invoiceForOwnerView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/invoiceForOwner/invoiceForOwnerCtrl.js' ])
									} ]
						}
					})

			.state(
					'app.finance.controlscreen.assetmaster-edit',
					{
						url : '/controlscreen/asset/edit',
						data : {
							title : 'Edit'
						},
						controller : 'AssetMasterEditCtrl',
						templateUrl : 'views/finance/controlscreen/Asset/AssetMasterAddPage',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/Asset/AssetMasterEditCtrl.js' ]);
									} ]
						}

					})

			/*
			 * Exchange Rate
			 */

			.state(
					'app.finance.controlscreen.exchangerate',
					{
						url : '/controlscreen/exchangeRateList',
						data : {
							title : 'Exchange Rate List'
						},

						controller : 'exchangeRateCtrl',
						templateUrl : 'views/finance/controlscreen/exchangerate/exchangeRateList',
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
					'app.finance.controlscreen.exchangerateadd',
					{
						url : '/controlscreen/exchangeRateAdd',
						data : {
							title : 'Exchange Rate Add'
						},

						controller : 'exchangeRateAddCtrl',
						templateUrl : 'views/finance/controlscreen/exchangerate/exchangeRateAdd',
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
					'app.finance.controlscreen.exchangeRateEdit',
					{
						url : '/controlscreen/exchangeRateEdit/:exchangeRateCode',
						data : {
							title : 'Edit'
						},
						controller : 'exchangeRateAddCtrl',
						templateUrl : 'views/finance/controlscreen/exchangerate/exchangeRateAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/exchangerate/exchangeRateAddCtrl.js' ]);
									} ]
						}

					})

			/*
			 * Document Info
			 */

			.state(
					'app.finance.controlscreen.documentinfo',
					{
						url : '/controlscreen/documentInfoSearch',
						data : {
							title : 'Document Information'
						},

						controller : 'documentInfoCtrl',
						templateUrl : 'views/finance/controlscreen/documentinfo/documentInfoSearch',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/documentinfo/documentInfoCtrl.js' ]);
									} ]

						}

					})

			.state(
					'app.finance.controlscreen.documentinfo.view',
					{
						url : '/controlscreen/documentInfoSearch/view/:documentTypeCode/:year/:locationName',
						data : {
							title : 'Document Information View'
						},

						controller : 'documentInfoViewCtrl',
						templateUrl : 'views/finance/controlscreen/documentinfo/documentInfoSearchView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/documentinfo/documentInfoCtrl.js' ]);
									} ]

						}

					})

			/*
			 * Vendor Master
			 */

			.state(
					'app.finance.controlscreen.vendormaster',
					{
						url : '/controlscreen/vendorMaster',
						data : {
							title : 'Vendor Master List'
						},

						controller : 'vendorMasterController',
						templateUrl : 'views/finance/controlscreen/VendorMaster/VendorMasterList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/VendorMaster/vendorMasterListCtrl.js' ]);
									} ]

						}

					})

			.state(
					'app.finance.controlscreen.vendormasteradd',
					{
						url : '/controlscreen/vendorMasterAdd',
						data : {
							title : 'Vendor Master Add'
						},

						controller : 'vendorMasterAddCtrl',
						templateUrl : 'views/finance/controlscreen/VendorMaster/VendorMasterAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/VendorMaster/vendormasterAddCtrl.js' ])
									} ]

						}

					})

					
					.state(
					'app.finance.controlscreen.vendormasteredit',
					{
						url : '/controlscreen/vendorMaster/edit',
						data : {
							title : 'Vendor Master Edit'
						},

						controller : 'vendorMasterAddCtrl',
						templateUrl : 'views/finance/controlscreen/VendorMaster/VendorMasterAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/VendorMaster/vendormasterAddCtrl.js' ])
									} ]

						}

					})
		
					

			.state(
					'app.finance.controlscreen.vendormasterview',
					{
						url : '/controlscreen/vendorMasterView',
						data : {
							title : 'View'
						},

						controller : 'servicepartnerViewCtrl',
						templateUrl : 'views/finance/controlscreen/VendorMaster/VendorMasterView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/VendorMaster/vendormasterAddCtrl.js' ]);

									} ]

						}

					})

			// Purchase Invoice

			.state(
					'app.finance.purchaseinvoice',
					{
						url : '/invoice/purchaseinvoice/PurchaseInvoiceList',
						data : {
							title : 'Purchase Invoice'
						},
						controller : 'purchaseInvoiceListCtrl',
						templateUrl : 'views/finance/invoice/purchaseinvoice/PurchaseInvoiceList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/purchaseinvoice/purchaseInvoiceListCtrl.js' ]);
									} ]
						}
					})
					
					
			.state(
					'app.finance.airpurchaseinvoiceDraft',
					{
						url : '/invoice/purchaseinvoice/PurchaseInvoiceDraftList',
						data : {
							title : 'Purchase Invoice Drafts'
						},

						controller : 'purchaseInvoiceListDraftCtrl',
						templateUrl : 'views/finance/invoice/purchaseinvoice/PurchaseInvoiceDraft',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/purchaseinvoice/purchaseInvoiceListCtrl.js' ]);
									} ]

						}

					})

			.state(
					'app.finance.purchaseinvoice-add',
					{
						url : '/invoice/purchaseinvoice/PurchaseInvoiceAdd',
						data : {
							title : 'Purchase Invoice Add'
						},

						controller : 'purchaseInvoiceAddCtrl',
						templateUrl : 'views/finance/invoice/purchaseinvoice/PurchaseInvoiceAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/purchaseinvoice/purchaseInvoiceAddCtrl.js' ]);
									} ]
						}

					})
					
					
						.state(
					'app.finance.purchaseinvoiceDraftEdit',
					{
						url : '/invoice/purchaseinvoice/purchaseInvoiceDraftEdit/:purchaseInvoiceNo',
						data : {
							title : 'Purchase Invoice Draft Edit'
						},
						controller : 'purchaseInvoiceAddCtrl',
						templateUrl : 'views/finance/invoice/purchaseinvoice/PurchaseInvoiceDraftView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/purchaseinvoice/purchaseInvoiceAddCtrl.js' ]);
									} ]

						}

					})
					
			.state(
					'app.finance.invoice.purchaseinvoice-edit',
					{
						url : '/invoice/purchaseinvoice/PurchaseInvoiceEdit/:purchaseInvoiceNo',
						data : {
							title : 'Add'
						},

						controller : 'purchaseInvoiceAddCtrl',
						templateUrl : 'views/finance/invoice/purchaseinvoice/PurchaseInvoiceAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/purchaseinvoice/purchaseInvoiceAddCtrl.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.invoice.purchaseinvoice-edit1',
					{
						url : '/invoice/purchaseinvoice/PurchaseInvoiceEditTemp/:purchaseInvoiceNo1',
						data : {
							title : 'Add'
						},

						controller : 'purchaseInvoiceAddCtrl',
						templateUrl : 'views/finance/invoice/purchaseinvoice/PurchaseInvoiceAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/purchaseinvoice/purchaseInvoiceAddCtrl.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.invoice.purchaseinvoiceView',
					{
						url : '/invoice/purchaseinvoice/PurchaseInvoiceView/:purchaseInvoiceSNo',
						data : {
							title : 'View'
						},
						controller : 'purchaseInvoiceViewCtrl',
						templateUrl : 'views/finance/invoice/purchaseinvoice/PurchaseInvoiceView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/purchaseinvoice/purchaseInvoiceAddCtrl.js' ]);
									} ]

						}

					})
			.state(
					'app.finance.invoice.purchaseinvoiceView1',
					{
						url : '/invoice/purchaseinvoice/PurchaseInvoiceView1/:purchaseInvoiceNo1',
						data : {
							title : 'View'
						},
						controller : 'purchaseInvoiceViewCtrl',
						templateUrl : 'views/finance/invoice/purchaseinvoice/PurchaseInvoiceView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/purchaseinvoice/purchaseInvoiceAddCtrl.js' ]);
									} ]

						}

					})
			.state(
					'app.finance.invoice.purchaseinvoice-copy',
					{
						url : '/invoice/purchaseinvoice/PurchaseInvoiceCopy/:purchaseInvoiceNo',
						data : {
							title : 'Copy'
						},

						controller : 'purchaseInvoiceAddCtrl',
						templateUrl : 'views/finance/invoice/purchaseinvoice/PurchaseInvoiceAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/purchaseinvoice/purchaseInvoiceAddCtrl.js' ]);
									} ]

						}

					})

					// Sea purchase invoice
					
					.state(
					'app.salesmarketing.seapurchaseinvoice',
					{
						url : '/invoice/sea/seapurchaseinvoice/PurchaseInvoiceList',
						data : {
							title : 'Purchase Invoice'
						},
						controller : 'SeapurchaseInvoiceListCtrl',
						templateUrl : 'views/finance/invoice/seapurchaseinvoice/SeaPurchaseInvoiceList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/seapurchaseinvoice/seapurchaseInvoiceListCtrl.js' ]);
									} ]
						}
					})
					
						.state(
					'app.salesmarketing.seapurchaseDraftEdit',
					{
						url : '/invoice/purchaseinvoice/purchaseInvoiceEd/:purchaseInvoiceNo',
						data : {
							title : 'Sea Purchase Invoice Draft Edit'
						},
						controller : 'SeapurchaseInvoiceAddCtrl',
						templateUrl : 'views/finance/invoice/seapurchaseinvoice/SeaPurchaseInvoiceDraftView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/seapurchaseinvoice/seapurchaseInvoiceAddCtrl.js' ]);
									} ]

						}

					})
					
					.state(
					'app.salesmarketing.purchaseinvoice-add',
					{
						url : '/invoice/sea/purchaseinvoice/PurchaseInvoiceAdd',
						data : {
							title : 'Purchase Invoice Add'
						},

						controller : 'SeapurchaseInvoiceAddCtrl',
						templateUrl : 'views/finance/invoice/seapurchaseinvoice/SeaPurchaseInvoiceAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/seapurchaseinvoice/seapurchaseInvoiceAddCtrl.js' ]);
									} ]
						}

					})
					
					
					
					.state(
					'app.salesmarketing.purchaseinvoiceView',
					{
						url : '/invoice/seapurchaseinvoice/PurchaseInvoiceView/:purchaseInvoiceNo',
						data : {
							title : 'View'
						},
						controller : 'seaPurchaseInvoiceViewCtrl',
						templateUrl : 'views/finance/invoice/seapurchaseinvoice/SeaPurchaseInvoiceView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/seapurchaseinvoice/seapurchaseInvoiceAddCtrl.js' ]);
									} ]

						}

					})
					
					/*
					 * .state( 'app.salesmarketing.seapurchaseinvoiceDraft', {
					 * url :
					 * '/invoice/sea/seapurchaseinvoice/PurchaseInvoiceDraftList',
					 * data : { title : 'Purchase Invoice Drafts' },
					 * 
					 * controller : 'purchaseInvoiceListDraftCtrl', templateUrl :
					 * 'views/finance/invoice/seapurchaseinvoice/SeaPurchaseInvoiceDraft',
					 * resolve : { deps : [ '$ocLazyLoad', function($ocLazyLoad) {
					 * return $ocLazyLoad .load([
					 * 'js/app/finance/invoice/seasalesinvoice/seapurchaseInvoiceListCtrl.js'
					 * ]); } ]
					 *  }
					 *  })
					 * 
					 * .state( 'app.salesmarketing.seapurchaseinvoiceDraftEdit', {
					 * url :
					 * '/invoice/seasalesinvoice/salesInvoiceDraftEdit/:purchaseInvoiceNo',
					 * data : { title : 'Sales Invoice Draft View' }, controller :
					 * 'SeasalesInvoiceAddCtrl', templateUrl :
					 * 'views/finance/invoice/seasalesinvoice/SeaSalesDraftInvoiceView',
					 * resolve : { deps : [ '$ocLazyLoad', function($ocLazyLoad) {
					 * return $ocLazyLoad .load([
					 * 'js/app/finance/invoice/seasalesinvoice/seasalesInvoiceAddCtrl.js'
					 * ]); } ]
					 *  }
					 *  })
					 */
					
					
					
					// sales invoice
					.state(
					'app.finance.salesinvoice',
					{
						url : '/invoice/salesinvoice/SalesInvoiceList',
						data : {
							title : 'Sales Invoice'
						},
						controller : 'salesInvoiceListCtrl',
						templateUrl : 'views/finance/invoice/salesinvoice/SalesInvoiceList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/salesinvoice/salesInvoiceListCtrl.js' ]);
									} ]
						}
					})
					
					.state(
					'app.finance.salesinvoice-add',
					{
						url : '/invoice/salesinvoice/salesInvoiceAdd',
						data : {
							title : 'Sales Invoice Add'
						},

						controller : 'salesInvoiceAddCtrl',
						templateUrl : 'views/finance/invoice/salesinvoice/SalesInvoiceAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/salesinvoice/salesInvoiceAddCtrl.js' ]);
									} ]
						}

					})
					
					.state(
					'app.finance.salesinvoiceView',
					{
						url : '/invoice/salesinvoice/salesInvoiceView/:purchaseInvoiceNo',
						data : {
							title : 'Sales Invoice View'
						},
						controller : 'salesViewCtrl',
						templateUrl : 'views/finance/invoice/salesinvoice/SalesInvoiceView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/salesinvoice/salesInvoiceAddCtrl.js' ]);
									} ]

						}

					})
					
					.state(
					'app.finance.seasalesinvoiceDraft',
					{
						url : '/invoice/salesinvoice/SalesInvoiceDraftList',
						data : {
							title : 'Sales Invoice Drafts'
						},

						controller : 'airsalesInvoiceListDraftCtrl',
						templateUrl : 'views/finance/invoice/salesinvoice/SalesInvoiceDraft',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/salesinvoice/salesInvoiceListCtrl.js' ]);
									} ]

						}

					})
					
						.state(
					'app.finance.salesinvoiceDraftEdit',
					{
						url : '/invoice/salesinvoice/salesInvoiceDraftEdit/:purchaseInvoiceNo',
						data : {
							title : 'Sales Invoice Draft Edit'
						},
						controller : 'salesInvoiceAddCtrl',
						templateUrl : 'views/finance/invoice/salesinvoice/SalesInvoiceDraftView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/salesinvoice/salesInvoiceAddCtrl.js' ]);
									} ]

						}

					})
					
					
					// sea sales invoice
					
					.state(
					'app.salesmarketing.seasalesinvoice',
					{
						url : '/invoice/sea/seasalesinvoice/SalesInvoiceList',
						data : {
							title : 'Sales Invoice'
						},
						controller : 'SeasalesInvoiceListCtrl',
						templateUrl : 'views/finance/invoice/seasalesinvoice/SeaSalesInvoiceList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/seasalesinvoice/seasalesInvoiceListCtrl.js' ]);
									} ]
						}
					})
					
					.state(
					'app.salesmarketing.salesinvoice-add',
					{
						url : '/invoice/sea/salesinvoice/SalesInvoiceAdd',
						data : {
							title : 'Sales Invoice Add'
						},

						controller : 'SeasalesInvoiceAddCtrl',
						templateUrl : 'views/finance/invoice/seasalesinvoice/SeaSalesInvoiceAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/seasalesinvoice/seasalesInvoiceAddCtrl.js' ]);
									} ]
						}

					})
					
					.state(
					'app.salesmarketing.seasalesinvoiceView',
					{
						url : '/invoice/seasalesinvoice/salesInvoiceView/:purchaseInvoiceNo',
						data : {
							title : 'Sales Invoice View'
						},
						controller : 'seasalesViewCtrl',
						templateUrl : 'views/finance/invoice/seasalesinvoice/SeaSalesInvoiceView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/seasalesinvoice/seasalesInvoiceAddCtrl.js' ]);
									} ]

						}

					})
					
					.state(
					'app.salesmarketing.seasalesinvoiceDraft',
					{
						url : '/invoice/sea/seasalesinvoice/SalesInvoiceDraftList',
						data : {
							title : 'Sales Invoice Drafts'
						},

						controller : 'salesInvoiceListDraftCtrl',
						templateUrl : 'views/finance/invoice/seasalesinvoice/SeaSalesInvoiceDraft',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/seasalesinvoice/seasalesInvoiceListCtrl.js' ]);
									} ]

						}

					})
					
					.state(
					'app.salesmarketing.seasalesinvoiceDraftEdit',
					{
						url : '/invoice/seasalesinvoice/salesInvoiceDraftEdit/:purchaseInvoiceNo',
						data : {
							title : 'Sales Invoice Draft View'
						},
						controller : 'SeasalesInvoiceAddCtrl',
						templateUrl : 'views/finance/invoice/seasalesinvoice/SeaSalesDraftInvoiceView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/seasalesinvoice/seasalesInvoiceAddCtrl.js' ]);
									} ]

						}

					})
					
					
			// LPO
			.state(
					'app.finance.invoice.lpo',
					{
						url : '/invoice/lpo/LPOList',
						data : {
							title : 'LPO'
						},

						controller : 'lpoListCtrl',
						templateUrl : 'views/finance/invoice/lpo/LPOList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/lpo/LPOListCtrl.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.invoice.lpo-add',
					{
						url : '/invoice/lpo/lpoAdd',
						data : {
							title : 'Add'
						},

						controller : 'lpoAddCtrl',
						templateUrl : 'views/finance/invoice/lpo/LPOAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/lpo/LPOAddCtrl.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.invoice.lpo-edit',
					{
						url : '/invoice/lpo/lpoEdit/:lpoNo',
						data : {
							title : 'Edit'
						},

						controller : 'lpoAddCtrl',
						templateUrl : 'views/finance/invoice/lpo/LPOAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/lpo/LPOAddCtrl.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.invoice.lpoView',
					{
						url : '/invoice/lpo/lpoView/:lpoNo',
						data : {
							title : 'View'
						},

						controller : 'lpoAddCtrl',
						templateUrl : 'views/finance/invoice/lpo/LPOView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/lpo/LPOAddCtrl.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.invoice.copyLPO',
					{
						url : '/invoice/lpo/copyLPO/:reverseLpoNo',
						data : {
							title : 'Copy'
						},

						controller : 'lpoAddCtrl',
						templateUrl : 'views/finance/invoice/lpo/LPOAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/lpo/LPOAddCtrl.js' ])
									} ]
						}

					})

			/**
			 * Credit Note
			 * ************************************************************************
			 * Start *********
			 */
			.state('app.finance.transaction.creditnotehdr', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Credit Note'
				}
			})
			.state(
					'app.finance.transaction.creditnotehdr.list',
					{
						url : '/transaction/creditnotehdr/list',
						data : {
							title : 'List'
						},

						controller : 'creditNoteCtrl',
						templateUrl : 'views/finance/transaction/creditNotepage',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/creditNoteCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.finance.transaction.creditnotehdr.add',
					{
						url : '/transaction/creditnotehdr/add',
						data : {
							title : 'Add'
						},

						controller : 'creditNoteCtrlAdd',
						templateUrl : 'views/finance/transaction/creditNoteForm',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/creditNoteCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.finance.transaction.creditnotehdr.edit',
					{
						url : '/transaction/creditnotehdr/edit',
						data : {
							title : 'Edit'
						},

						controller : 'creditNoteCtrlAdd',
						templateUrl : 'views/finance/transaction/creditNoteForm',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/creditNoteCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.finance.transaction.creditnotehdr.view',
					{
						url : '/transaction/creditnotehdr/view',
						data : {
							title : 'Credit Node Account View'
						},
						controller : 'creditNoteCtrlView',
						templateUrl : 'views/finance/transaction/creditNoteView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/creditNoteCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.finance.transaction.creditnotehdr.view1',
					{
						url : '/transaction/creditnotehdr/view1',
						data : {
							title : 'Credit Node Account View'
						},

						controller : 'creditNoteCtrlView',
						templateUrl : 'views/finance/transaction/creditNoteView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/creditNoteCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.finance.transaction.creditnotehdr.pending',
					{
						url : '/transaction/creditnotehdr/pending',
						data : {
							title : 'Credit Node Account Pending'
						},

						controller : 'creditNoteCtrlView',
						templateUrl : 'views/finance/transaction/creditNoteView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/creditNoteCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.finance.transaction.creditnotehdr.pendingApproval',
					{
						url : '/transaction/creditnotehdr/pendingPartial',
						data : {
							title : 'Credit Node Account Pending'
						},

						controller : 'creditNoteCtrlView',
						templateUrl : 'views/finance/transaction/creditNoteView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/creditNoteCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.finance.transaction.creditnotehdr.pendingApprovalList',
					{
						url : '/transaction/creditnotehdr/pendingApprovalList',
						data : {
							title : 'Pending Approval List'
						},

						controller : 'creditNotePendingApprovalCtrl',
						templateUrl : 'views/finance/transaction/creditNotePendingList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/creditNoteCtrl.js' ])
									} ]
						}

					})

			/**
			 * Credit Note
			 * *********************************************************************************
			 * End
			 */
			// Customer Master
			.state(
					'app.finance.controlscreen.customer',
					{
						url : '/controlscreen/customer',
						data : {
							title : 'Customer View'
						},

						controller : 'customerMasterCtrl',
						templateUrl : 'views/finance/controlscreen/customer/customerList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/customer/customerMasterCtrl.js' ]);
									} ]
						}

					})

			.state(
					'app.finance.controlscreen.customer-add',
					{
						url : '/controlscreen/customer/add',
						data : {
							title : 'Add'
						},

						controller : 'CustomerMasterAddCtrl',
						templateUrl : 'views/finance/controlscreen/customer/customerMasterAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/customer/customerMasterAddCtrl.js' ]);
									} ]
						}

					})
					
					
						.state(
					'app.finance.controlscreen.customer-edit',
					{
						url : '/controlscreen/customer/edit',
						data : {
							title : 'Edit'
						},

						controller : 'CustomerMasterAddCtrl',
						templateUrl : 'views/finance/controlscreen/customer/customerMasterAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/customer/customerMasterAddCtrl.js' ]);
									} ]
						}

					})
					
					.state(
					'app.finance.controlscreen.customerView',
					{
						url : '/controlscreen/customer/view',
						data : {
							title : 'View'
						},

						controller : 'CustomerMasterAddCtrl',
						templateUrl : 'views/finance/controlscreen/customer/customerMasterView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/customer/customerMasterAddCtrl.js' ]);
									} ]
						}

					})
					
					
					
					
			.state(
					'app.finance.controlscreen.tariff.agencytariff.edit',
					{
						url : '/controlscreen/tariff/agencytariff/edit/:agentCode/:agentName/:editAgent',
						data : {
							title : 'Edit'
						},

						controller : 'agencyTariffAddCtrl',
						templateUrl : 'views/finance/controlscreen/tariff/agencyTariffAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/tariff/agencyTariffAddCtrl.js' ]);
									} ]
						}

					})

			.state(
					'app.finance.controlscreen.customer-view',
					{
						url : '/controlscreen/customer/view',
						data : {
							title : 'Add'
						},

						controller : 'CustomerMasterViewCtrl',
						templateUrl : 'views/finance/controlscreen/customer/customerMasterViewPage',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/customer/customerMasterViewCtrl.js' ]);
									} ]
						}

					})
           // consinee
		
				.state(
					'app.finance.controlscreen.consignee',
					{
						url : '/controlscreen/consignee',
						data : {
							title : 'Consignee View'
						},

						controller : 'consigneeMasterCtrl',
						templateUrl : 'views/finance/controlscreen/consignee/consigneeList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/consignee/consigneeMasterCtrl.js' ]);
									} ]
						}

					})

			.state(
					'app.finance.controlscreen.consignee-add',
					{
						url : '/controlscreen/consignee/add',
						data : {
							title : 'Add'
						},

						controller : 'ConsigneeMasterAddCtrl',
						templateUrl : 'views/finance/controlscreen/consignee/consigneeMasterAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/consignee/consigneeMasterAddCtrl.js' ]);
									} ]
						}

					})
		

			.state(
					'app.finance.controlscreen.consignee-view',
					{
						url : '/controlscreen/consignee/view',
						data : {
							title : 'Add'
						},

						controller : 'ConsigneeMasterViewCtrl',
						templateUrl : 'views/finance/controlscreen/consignee/consigneeMasterViewPage',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/consignee/consigneeMasterViewCtrl.js' ]);
									} ]
						}

					})	
			.state(
					'app.finance.controlscreen.tariff.agencytariff',
					{
						url : '/controlscreen/tariff/agencytariff',
						data : {
							title : 'Agency Tariff List'
						},

						controller : 'agencyTariffCtrl',
						templateUrl : 'views/finance/controlscreen/tariff/agencyTariffList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/tariff/agencyTariffCtrl.js' ]);
									} ]
						}

					})

			.state(
					'app.finance.controlscreen.tariff.agencytariffadd',
					{
						url : '/controlscreen/tariff/agencytariff/add',
						data : {
							title : 'Add'
						},

						controller : 'agencyTariffAddCtrl',
						templateUrl : 'views/finance/controlscreen/tariff/agencyTariffAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/tariff/agencyTariffAddCtrl.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.controlscreen.tariff.agencytariff.generate',
					{
						url : '/controlscreen/tariff/agencytariff/generate',
						data : {
							title : 'Generate'
						},
						params : {
							agencyView : null
						},

						controller : 'agencyTariffGenerate',
						templateUrl : 'views/finance/controlscreen/tariff/agencyGenerateTariff',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/tariff/agencyTariffAddCtrl.js' ]);
									} ]
						}

					})

			.state(
					'app.finance.controlscreen.tariff.agencytariff.view',
					{
						url : '/controlscreen/tariff/agencytariff/view/:agentCode/:agentName',
						data : {
							title : 'Agency Tariff View'
						},

						controller : 'agencyTariffViewCtrl',
						templateUrl : 'views/finance/controlscreen/tariff/agencyTariffView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/tariff/agencyTariffCtrl.js' ]);
									} ]
						}

					})
			/*
			 * Account Payable Di
			 */
			.state('app.finance.transaction.accountpayables', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Account Payables'
				}
			})
			.state(
					'app.finance.transaction.accountpayables.disbursementaccounting',
					{
						abstract : true,
						templateUrl : "views/common",
						data : {
							title : 'Disbursement Accounting'
						}
					})
			.state(
					'app.finance.transaction.accountpayables.disbursementaccounting.list',
					{
						url : '/transaction/accountpayables/disbursementaccountingt/list',
						data : {
							title : 'List'
						},

						controller : 'disbursementAccountingListCtrl',
						templateUrl : 'views/finance/transaction/accountpayables/disbursementAccountingList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/accountpayables/disbursementAccountingCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.finance.transaction.accountpayables.disbursementaccounting.add',
					{
						url : '/transaction/accountpayables/disbursementaccountingt/add/:isedit',
						data : {
							title : 'Add'
						},

						controller : 'disbursementAccountingAddCtrl',
						templateUrl : 'views/finance/transaction/accountpayables/disbursementAccountingAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/accountpayables/disbursementAccountingCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.finance.transaction.accountpayables.disbursementaccounting.edit',
					{
						url : '/transaction/accountpayables/disbursementaccountingt/edit/:disbursementAcctCode/:isedit',
						data : {
							title : 'Edit'
						},

						controller : 'disbursementAccountingAddCtrl',
						templateUrl : 'views/finance/transaction/accountpayables/disbursementAccountingAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/accountpayables/disbursementAccountingCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.finance.transaction.accountpayables.disbursementaccounting.view',
					{
						url : '/transaction/accountpayables/disbursementaccountingt/view/:disbursementAcctCode/:isedit/:operation',
						data : {
							title : 'View'
						},

						controller : 'disbursementAccountingAddCtrl',
						templateUrl : 'views/finance/transaction/accountpayables/disbursementAccountingView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/accountpayables/disbursementAccountingCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.finance.transaction.accountpayables.disbursementaccounting.addExpences',
					{
						url : '/transaction/accountpayables/disbursementaccountingt/addExpences',
						data : {
							title : 'Expenses'
						},

						controller : 'addexpensesctrl',
						templateUrl : 'views/finance/transaction/accountpayables/addExpenses',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/accountpayables/expenses.js' ])
									} ]
						}

					})

			.state(
					'app.finance.transaction.accountpayables.disbursementaccounting.editExpences',
					{
						url : '/transaction/accountpayables/disbursementaccountingt/editExpences/:exDescCode/:exDesc/:exTypeName',
						data : {
							title : 'Expenses'
						},

						controller : 'editexpensesctrl',
						templateUrl : 'views/finance/transaction/accountpayables/addExpenses',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/accountpayables/expenses.js' ])
									} ]
						}

					})

			.state(
					'app.finance.transaction.accountpayables.disbursementaccounting.ExpensesList',
					{
						url : '/transaction/accountpayables/disbursementaccountingt/ExpensesList',
						data : {
							title : 'Expenses List'
						},

						controller : 'expenseviewctrl',
						templateUrl : 'views/finance/transaction/accountpayables/expensesList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/accountpayables/expenses.js' ])
									} ]
						}

					})

			/*// Cash Bank Receipt

			.state(
					'app.finance.transaction.cashbankreceipt',
					{
						url : '/transaction/cashbankreceipt/list',
						data : {
							title : 'Bank Receipts'
						},

						controller : 'cashBankReceiptListCtrl',
						templateUrl : 'views/finance/transaction/cashbankreceipt/cashBankReceiptList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/cashbankreceipt/cashBankReceiptListCtrl.js' ]);
									} ]
						}

					})
					
					.state(
					'app.finance.transaction.cashreceipt',
					{
						url : '/transaction/cashreceipt/list',
						data : {
							title : 'Cash Receipts'
						},

						controller : 'cashReceiptListCtrl',
						templateUrl : 'views/finance/transaction/cashbankreceipt/cashReceiptList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/cashbankreceipt/cashReceiptListCtrl.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.transaction.cashbankreceipt-draft',
					{
						url : '/transaction/cashbankreceipt/draft',
						data : {
							title : 'Cash Bank Drafts'
						},
						controller : 'cashBankReceiptListDraftCtrl',
						templateUrl : 'views/finance/transaction/cashbankreceipt/cashBankReceiptDraftList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/cashbankreceipt/cashBankReceiptListCtrl.js' ]);
									} ]
						}

					})
					
						.state(
					'app.finance.transaction.cashreceipt-draft',
					{
						url : '/transaction/cashreceipt/draft',
						data : {
							title : 'Cash Drafts'
						},
						controller : 'cashReceiptListDraftCtrl',
						templateUrl : 'views/finance/transaction/cashbankreceipt/cashReceiptDraftList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/cashbankreceipt/cashReceiptListCtrl.js' ]);
									} ]
						}

					})*/
			.state(
					'app.finance.transaction.agencyreceipt',
					{
						url : '/transaction/agencyreceipt/list',
						data : {
							title : 'Agency Receipts'
						},
						controller : 'agencyReceiptListCtrl',
						templateUrl : 'views/finance/transaction/cashbankreceipt/AgencyReceiptList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/cashbankreceipt/cashBankReceiptListCtrl.js' ]);
									} ]
						}

					})
		/*	.state(
					'app.finance.transaction.agencyreceipt-add',
					{
						url : '/transaction/agencyreceipt/add',
						data : {
							title : 'Add'
						},

						controller : 'cashBankReceiptAddCtrl',
						templateUrl : 'views/finance/transaction/cashbankreceipt/AgencyReceipt',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/cashbankreceipt/cashBankReceiptAddCtrl.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.transaction.cashbankreceipt-add',
					{
						url : '/transaction/cashbankreceipt/add',
						data : {
							title : 'Add'
						},

						controller : 'cashBankReceiptAddCtrl',
						templateUrl : 'views/finance/transaction/cashbankreceipt/cashBankReceiptAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/cashbankreceipt/cashBankReceiptAddCtrl.js' ]);
									} ]
						}

					})
*/					// edit for bank receipt
					/*.state(
					'app.finance.transaction.cashbankreceipt-edit',
					{
						url : '/transaction/cashbankreceipt/edit/:voucherNo',
						data : {
							title : 'Edit'
						},

						controller : 'cashBankReceiptAddCtrl',
						templateUrl : 'views/finance/transaction/cashbankreceipt/cashBankReceiptAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/cashbankreceipt/cashBankReceiptAddCtrl.js' ]);
									} ]
						}

					})
					*/
					.state(
					'app.finance.transaction.cashreceipt-add',
					{
						url : '/transaction/cashreceipt/add',
						data : {
							title : 'Add'
						},

						controller : 'cashReceiptAddCtrl',
						templateUrl : 'views/finance/transaction/cashbankreceipt/cashReceiptAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/cashbankreceipt/cashReceiptAddCtrl.js' ]);
									} ]
						}

					})
					// cash Receipt edit
					.state(
					'app.finance.transaction.cashreceipt-edit',
					{
						url : '/transaction/cashreceipt/edit/:voucherNo',
						data : {
							title : 'Add'
						},
						controller : 'cashReceiptAddCtrl',
						templateUrl : 'views/finance/transaction/cashbankreceipt/cashReceiptAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/cashbankreceipt/cashReceiptAddCtrl.js' ]);
									} ]
						}

					})
			     /*  .state(
					'app.finance.transaction.cashbankreceipt-edit1',
					{
						url : '/transaction/cashbankreceipt/editTemp/:voucherNo1',
						data : {
							title : 'Add'
						},
						controller : 'cashBankReceiptAddCtrl',
						templateUrl : 'views/finance/transaction/cashbankreceipt/cashBankReceiptAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/cashbankreceipt/cashBankReceiptAddCtrl.js' ]);
									} ]
						}

					})*/
					
					.state(
					'app.finance.transaction.cashreceipt-edit1',
					{
						url : '/transaction/cashreceipt/editTemp/:voucherNo1',
						data : {
							title : 'Add'
						},
						controller : 'cashReceiptAddCtrl',
						templateUrl : 'views/finance/transaction/cashbankreceipt/cashReceiptAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/cashbankreceipt/cashReceiptAddCtrl.js' ]);
									} ]
						}

					})
			/*.state(
					'app.finance.transaction.cashbankreceipt-view',
					{
						url : '/transaction/cashbankreceipt/view/:voucherNo',
						data : {
							title : 'View'
						},
						controller : 'cashBankReceiptViewCtrl',
						templateUrl : 'views/finance/transaction/cashbankreceipt/cashBankReceiptView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/cashbankreceipt/cashBankReceiptAddCtrl.js' ]);
									} ]
						}

					})*/
					
					.state(
					'app.finance.transaction.cashreceipt-view',
					{
						url : '/transaction/cashreceipt/view/:voucherNo',
						data : {
							title : 'View'
						},
						controller : 'cashReceiptViewCtrl',
						templateUrl : 'views/finance/transaction/cashbankreceipt/cashReceiptView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/cashbankreceipt/cashReceiptAddCtrl.js' ]);
									} ]
						}

					})
		/*	.state(
					'app.finance.transaction.agencyreceipt-view',
					{
						url : '/transaction/agencyreceipt/view/:voucherNo',
						data : {
							title : 'View'
						},
						controller : 'agencyReceiptViewCtrl',
						templateUrl : 'views/finance/transaction/cashbankreceipt/AgencyReceiptView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/cashbankreceipt/cashBankReceiptAddCtrl.js' ]);
									} ]
						}

					})*/
			/*.state(
					'app.finance.transaction.cashbankreceipt-view1',
					{
						url : '/transaction/cashbankreceipt/view1/:voucherNo1',
						data : {
							title : 'View'
						},
						controller : 'cashBankReceiptViewCtrl',
						templateUrl : 'views/finance/transaction/cashbankreceipt/cashBankReceiptView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/cashbankreceipt/cashBankReceiptAddCtrl.js' ]);
									} ]
						}

					})
					*/
					
		/*	.state(
					'app.finance.transaction.cashbankreceipt-invoiceAllocation',
					{
						url : '/transaction/cashbankreceipt/invoiceAllocation',
						data : {
							title : 'Invoice Allocation'
						},
						controller : 'cashBankReceiptInvoiceAllocationCtrl',
						templateUrl : 'views/finance/transaction/cashbankreceipt/cbInvoiceAllocation',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/cashbankreceipt/cashBankReceiptAddCtrl.js' ]);
									} ]
						}

					})*/
					
					.state(
					'app.finance.transaction.cashreceipt-invoiceAllocation',
					{
						url : '/transaction/cashreceipt/invoiceAllocation',
						data : {
							title : 'Invoice Allocation'
						},
						controller : 'cashReceiptInvoiceAllocationCtrl',
						templateUrl : 'views/finance/transaction/cashbankreceipt/cInvoiceAllocation',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/cashbankreceipt/cashReceiptAddCtrl.js' ]);
									} ]
						}

					})
		/*	.state(
					'app.finance.transaction.agentreceipt-invoiceAllocation',
					{
						url : '/transaction/agentreceipt/invoiceAllocation',
						data : {
							title : 'Invoice Allocation'
						},
						controller : 'agentReceiptInvoiceAllocationCtrl',
						templateUrl : 'views/finance/transaction/cashbankreceipt/cbInvoiceAllocation',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/cashbankreceipt/cashBankReceiptAddCtrl.js' ]);
									} ]
						}

					})*/
		/*	.state(
					'app.finance.transaction.cashbankreceipt-copy',
					{
						url : '/transaction/cashbankreceipt/copy/:voucherNo',
						data : {
							title : 'Add'
						},
						controller : 'cashBankReceiptCopyCtrl',
						templateUrl : 'views/finance/transaction/cashbankreceipt/cashBankReceiptCopy',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/cashbankreceipt/cashBankReceiptAddCtrl.js' ]);
									} ]
						}

					})
					*/
					.state(
					'app.finance.transaction.cashreceipt-copy',
					{
						url : '/transaction/cashreceipt/copy/:voucherNo',
						data : {
							title : 'Add'
						},
						controller : 'cashReceiptAddCtrl',
						templateUrl : 'views/finance/transaction/cashbankreceipt/cashReceiptAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/cashbankreceipt/cashReceiptAddCtrl.js' ]);
									} ]
						}

					})

			// code added for contra entry

			.state(
					'app.finance.transaction.contraEntry',
					{
						url : '/transaction/contraEntry/contraEntryList',
						data : {
							title : 'Contra'
						},
						controller : 'ContraEntryCtrl',
						templateUrl : 'views/finance/transaction/contraEntry/contraEntryList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/ContraEntryCtrl.js' ]);
									} ]
						}

					})

			.state(
					'app.finance.transaction.contraEntryAdd',
					{
						url : '/transaction/contraEntry/contraEntryAdd',
						data : {
							title : 'Add'
						},
						controller : 'ContraEntryAddCtrl',
						templateUrl : 'views/finance/transaction/contraEntry/contraEntryAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/ContraEntryCtrl.js' ]);
									} ]
						}

					})

			.state(
					'app.finance.transaction.contraEntryView',
					{
						url : '/transaction/contraEntry/contraEntryView/:voucherNo',
						data : {
							title : 'View'
						},

						controller : 'ContraEntryViewCtrl',
						templateUrl : 'views/finance/transaction/contraEntry/contraEntryView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/ContraEntryCtrl.js' ]);
									} ]
						}

					})
	.state(
					'app.finance.transaction.contraEntryEdit',
					{
						url : '/transaction/contraEntry/contraEntryEdit/:voucherNo',
						data : {
							title : 'Edit'
						},
						controller : 'ContraEntryViewCtrl',
						templateUrl : 'views/finance/transaction/contraEntry/contraEntryEdit',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load(['js/app/finance/transaction/ContraEntryCtrl.js']);
									} ]
						}

					})
			// Code added for setoff

			.state(
					'app.finance.transaction.setoffEntry',
					{
						url : '/transaction/setOff/setOffList',
						data : {
							title : 'Setoff'
						},

						controller : 'setOffCtrl',
						templateUrl : 'views/finance/transaction/setOff/setOffList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/setOffCtrl.js' ]);
									} ]
						}

					})

			.state(
					'app.finance.transaction.setoffEntryAdd',
					{
						url : '/transaction/setOff/setOffAdd',
						data : {
							title : 'Add'
						},

						controller : 'setOffAddCtrl',
						templateUrl : 'views/finance/transaction/setOff/setOffAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/setOffCtrl.js' ]);
									} ]
						}

					})
		.state(
					'app.finance.transaction.setoffEntryEdit',
					{
						url : '/transaction/setOff/setOffEdit/:voucherNo',
						data : {
							title : 'Edit'
						},

						controller : 'setOffViewCtrl',
						templateUrl : 'views/finance/transaction/setOff/setOffEdit',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/setOffCtrl.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.transaction.setoffEntryView',
					{
						url : '/transaction/setOff/setOffView/:voucherNo',
						data : {
							title : 'View'
						},

						controller : 'setOffViewCtrl',
						templateUrl : 'views/finance/transaction/setOff/setOffView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/setOffCtrl.js' ]);
									} ]
						}

					})

			// GroupHead
			.state(
						'app.finance.configuration.grouphead.list',
					{
						url : '/configuration/grouphead/groupheadList',
						data : {
							title : 'List'
						},

						controller : 'groupHeadMasterListCtrl',
						templateUrl : 'views/finance/controlscreen/grouphead/groupheadList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/grouphead/groupHeadMasterListCtrl.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.invoice.invoiceGenerate',
					{
						url : '/invoice/invoiceGenerate',
						data : {
							title : 'Invoice Generate'
						},

						controller : 'invoiceGenerateController',
						templateUrl : 'views/finance/invoice/InvoiceGenerate',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/invoiceGenerate.js' ]);
									} ]
						}

					})

			.state(
					'app.finance.invoice.invoiceView',
					{
						url : '/invoice/invoiceView',
						data : {
							title : 'Invoice View'
						},
						controller : 'invoiceViewController',
						templateUrl : 'views/finance/invoice/invoiceGenerateView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/invoiceGenerate.js' ]);
									} ]
						}

					})

			.state(
					'app.finance.invoice.invoiceBulkView',
					{
						url : '/invoice/invoiceBulkView',
						data : {
							title : 'Invoice View'
						},
						controller : 'invoiceBulkViewController',
						templateUrl : 'views/finance/invoice/invoiceBulkViewList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/invoiceGenerate.js' ]);
									} ]
						}

					})

			.state(
					'app.finance.invoice.invoiceList',
					{
						url : '/invoice/invoiceList',
						data : {
							title : 'Invoice List'
						},

						controller : 'invoiceListController',
						templateUrl : 'views/finance/invoice/invoiceList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/invoiceGenerate.js' ]);
									} ]
						}

					})

			.state(
					'app.finance.invoice.invoiceSummary',
					{
						url : '/invoice/invoiceSummary',
						data : {
							title : 'Invoice Summary'
						},
						controller : 'invoiceSummaryController',
						templateUrl : 'views/finance/invoice/invoiceSummary',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/invoiceGenerate.js' ]);
									} ]
						}

					})
			.state('app.finance.transaction.cashbankpaymenthdr', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Bank Payment'
				}
			})
			.state('app.finance.transaction.cashpaymenthdr', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Cash Payment'
				}
			})
			.state(
					'app.finance.transaction.cashbankpaymenthdr.list',
					{
						url : '/transaction/cashbankpaymenthdr/list',
						data : {
							title : 'List'
						},
						controller : 'cashbankPaymentCtrl',
						templateUrl : 'views/finance/transaction/cashbankPaymentList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/cashbankPaymentCtrl.js' ])
									} ]
						}

					})
					
					.state(
					'app.finance.transaction.cashpaymenthdr.list',
					{
						url : '/transaction/cashpaymenthdr/list',
						data : {
							title : 'List'
						},
						controller : 'cashPaymentCtrl',
						templateUrl : 'views/finance/transaction/cashPaymentList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/cashPaymentCtrl.js' ])
									} ]
						}

					})
					
					
			.state(
					'app.finance.transaction.cashbankpaymenthdr.add',
					{
						url : '/transaction/cashbankpaymenthdr/add',
						data : {
							title : 'Add'
						},
						controller : 'cashbankPaymentAddCtrl',
						templateUrl : 'views/finance/transaction/cashbankPaymentForm',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/cashbankPaymentCtrl.js' ])
									} ]
						}

					})
					
					.state(
					'app.finance.transaction.cashpaymenthdr.add',
					{
						url : '/transaction/cashpaymenthdr/add',
						data : {
							title : 'Add'
						},
						controller : 'cashPaymentAddCtrl',
						templateUrl : 'views/finance/transaction/cashPaymentForm',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/cashPaymentCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.finance.transaction.cashbankpaymenthdr.edit',
					{
						url : '/transaction/cashbankpayment/edit/:voucherNo',
						data : {
							title : 'Cash/Bank Payment'
						},
						controller : 'cashbankPaymentAddCtrl',
						templateUrl : 'views/finance/transaction/cashbankPaymentForm',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/cashbankPaymentCtrl.js' ])
									} ]
						}

					})
					
					// edit for cash payment
					.state(
					'app.finance.transaction.cashpaymenthdr.edit',
					{
						url : '/transaction/cashpayment/edit/:voucherNo',
						data : {
							title : 'Cash Payment'
						},
						controller : 'cashPaymentAddCtrl',
						templateUrl : 'views/finance/transaction/cashPaymentForm',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/cashPaymentCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.finance.transaction.cashbankpaymenthdr.edit1',
					{
						url : '/transaction/cashbankpayment/editTemp/:voucherNo1',
						data : {
							title : 'Cash/Bank Payment'
						},
						controller : 'cashbankPaymentAddCtrl',
						templateUrl : 'views/finance/transaction/cashbankPaymentForm',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/cashbankPaymentCtrl.js' ])
									} ]
						}

					})
					
					.state(
					'app.finance.transaction.cashpaymenthdr.edit1',
					{
						url : '/transaction/cashpayment/editTemp/:voucherNo1',
						data : {
							title : 'Cash Payment'
						},
						controller : 'cashPaymentAddCtrl',
						templateUrl : 'views/finance/transaction/cashPaymentForm',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/cashPaymentCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.finance.transaction.cashbankpaymenthdr-copy',
					{
						url : '/transaction/cashbankpayment/copy/:voucherNo',
						data : {
							title : 'Copy'
						},
						controller : 'cashbankPaymentCopyCtrl',
						templateUrl : 'views/finance/transaction/cashbankPaymentCopyForm',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/cashbankPaymentCtrl.js' ]);
									} ]
						}

					})
					
					.state(
					'app.finance.transaction.cashpaymenthdr-copy',
					{
						url : '/transaction/cashpayment/copy/:voucherNo',
						data : {
							title : 'Copy'
						},
						controller : 'cashPaymentAddCtrl',
						templateUrl : 'views/finance/transaction/cashPaymentForm',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/cashPaymentCtrl.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.transaction.cashbankpaymenthdr.view',
					{
						url : '/transaction/cashbankpayment/view/:voucherNo',
						data : {
							title : 'View'
						},
						controller : 'cashbankPaymentViewCtrl',
						templateUrl : 'views/finance/transaction/cashbankPaymentView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/cashbankPaymentCtrl.js' ])
									} ]
						}

					})
					
					.state(
					'app.finance.transaction.cashpaymenthdr.view',
					{
						url : '/transaction/cashpayment/view/:voucherNo',
						data : {
							title : 'View'
						},
						controller : 'cashPaymentViewCtrl',
						templateUrl : 'views/finance/transaction/cashPaymentView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/cashPaymentCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.finance.transaction.cashbankpaymenthdr.view1',
					{
						url : '/transaction/cashbankpayment/view1/:voucherNo1',
						data : {
							title : 'View'
						},
						controller : 'cashbankPaymentViewCtrl',
						templateUrl : 'views/finance/transaction/cashbankPaymentView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/cashbankPaymentCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.finance.transaction.cashbankpayment-draft',
					{
						url : '/transaction/cashbankpayment/draft',
						data : {
							title : 'Bank Drafts'
						},
						controller : 'cashBankPaymentListDraftCtrl',
						templateUrl : 'views/finance/transaction/cashBankPaymentDraftList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/cashbankPaymentCtrl.js' ]);
									} ]
						}

					})
					
					
					.state(
					'app.finance.transaction.cashpayment-draft',
					{
						url : '/transaction/cashpayment/draft',
						data : {
							title : 'Cash Drafts'
						},
						controller : 'cashPaymentListDraftCtrl',
						templateUrl : 'views/finance/transaction/cashPaymentDraftList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/cashPaymentCtrl.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.transaction.cashbankpaymenthdr.manualAllocation',
					{
						url : '/transaction/cashbankpaymenthdr/manualAllocation',
						data : {
							title : 'Manual Allocation'
						},
						controller : 'cashBankpaymentManualAllocationCtrl',
						templateUrl : 'views/finance/transaction/cbpManualAllocation',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/cashbankPaymentCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.finance.transaction.cashbankpaymenthdr.unallocated',
					{
						url : '/transaction/cashbankpaymenthdr/unallocated',
						data : {
							title : 'UnAllocation'
						},
						controller : 'cbpUnAllocatedCtrl',
						templateUrl : 'views/finance/transaction/cbpUnAllocated',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/cashbankPaymentCtrl.js' ])
									} ]
						}

					})
					
					.state(
					'app.finance.transaction.cashpaymenthdr.unallocated',
					{
						url : '/transaction/cashpaymenthdr/unallocated',
						data : {
							title : 'UnAllocation'
						},
						controller : 'cpUnAllocatedCtrl',
						templateUrl : 'views/finance/transaction/cbpUnAllocated',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/cashPaymentCtrl.js' ])
									} ]
						}

					})
					
					

			.state('app.finance.transaction.jvaccounts', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Joint Venture Accounts'
				}
			})
			.state('app.finance.transaction.jvaccounts.jvagreement', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'JV Agreement'
				}
			})
			.state(
					'app.finance.transaction.jvaccounts.jvagreement.list',
					{
						url : '/transaction/jvaccounts/jvagreement/list',
						data : {
							title : 'List'
						},

						controller : 'jvAgreementListCtrl',
						templateUrl : 'views/finance/transaction/jvaccounts/jvAgreementList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/jvaccounts/jvAgreementCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.finance.transaction.jvaccounts.jvagreement.add',
					{
						url : '/transaction/jvaccounts/jvagreement/add',
						data : {
							title : 'Add'
						},
						controller : 'jvAgreementAddCtrl',
						templateUrl : 'views/finance/transaction/jvaccounts/jvAgreementForm',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/jvaccounts/jvAgreementCtrl.js' ])
									} ]
						}

					})

			// Swap Accounting..........

			.state('app.finance.transaction.jvaccounts.jvswapping', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'JV SwapAccounting'
				}
			})
			.state(
					'app.finance.transaction.jvaccounts.jvswapping.list',
					{
						url : '/transaction/jvaccounts/jvswapping/list',
						data : {
							title : 'Swap List'
						},
						controller : 'jvSwapListCtrl',
						templateUrl : 'views/finance/transaction/jvaccounts/jvSwapAccountList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/jvaccounts/jvSwapAccountCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.finance.transaction.jvaccounts.jvswapping.add',
					{
						url : '/transaction/jvaccounts/jvswapping/add',
						data : {
							title : 'Swap Add'
						},
						controller : 'jvSwapAddCtrl',
						templateUrl : 'views/finance/transaction/jvaccounts/jvSwapAccountForm',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/jvaccounts/jvSwapAccountingAdd.js' ])
									} ]
						}

					})
			.state(
					'app.finance.transaction.jvaccounts.jvswapping.edit',
					{
						url : '/transaction/jvaccounts/jvswapping/edit',
						data : {
							title : 'Swap Edit'
						},
						controller : 'jvSwapAddCtrl',
						templateUrl : 'views/finance/transaction/jvaccounts/jvSwapAccountForm',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/jvaccounts/jvSwapAccountCtrl.js' ])
									} ]
						}

					})

			// code for navigate the JV Accounting

			.state('app.finance.transaction.jvaccounts.jvaccounting', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'JV Accounts'
				}
			})

			.state(
					'app.finance.transaction.jvaccounts.jvaccounting.list',
					{
						url : '/transaction/jvaccounts/jvaccounting/list',
						data : {
							title : 'JV Accounting List'
						},
						controller : 'jvaccountingListctrl',
						templateUrl : 'views/finance/transaction/jvaccounts/jvAccountList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/jvaccounts/jvAccountCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.finance.transaction.jvaccounts.jvaccounting.view',
					{
						url : '/transaction/jvaccounts/jvaccounting/view/:JvAccountNo',
						data : {
							title : 'JV Accounting View'
						},
						controller : 'jvaccountingViewctrl',
						templateUrl : 'views/finance/transaction/jvaccounts/jvAccountView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/jvaccounts/jvAccountCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.finance.transaction.jvaccounts.jvaccounting.edit',
					{
						url : '/transaction/jvaccounts/jvaccounting/edit/:JvAccountNo',
						data : {
							title : 'JV Accounting'
						},
						controller : 'jvaccountingctrlAdd',
						templateUrl : 'views/finance/transaction/jvaccounts/jvAccountAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/jvaccounts/jvAccountCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.finance.transaction.jvaccounts.jvaccounting.add',
					{
						url : '/transaction/jvaccounts/jvaccounting/add',
						data : {
							title : 'Add JV Accounting'
						},
						controller : 'jvaccountingctrlAdd',
						templateUrl : 'views/finance/transaction/jvaccounts/jvAccountAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/jvaccounts/jvAccountCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.finance.controlscreen.estimates',
					{
						url : '/controlscreen/estimateList',
						data : {
							title : 'Estimates'
						},
						controller : 'estimateListCtrl',
						templateUrl : 'views/finance/controlscreen/estimates/EstimatesList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/estimates/EstimatesListCtrl.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.controlscreen.estimatesthirdparty',
					{
						url : '/controlscreen/estimateThirdPartyList',
						data : {
							title : 'Estimates Third Party'
						},
						controller : 'estimateThirdPartyListCtrl',
						templateUrl : 'views/finance/controlscreen/estimates/EstimatesThirdPartyList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/estimates/EstimatesThirdPartyListCtrl.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.controlscreen.estimates-add',
					{
						url : '/controlscreen/estimateAdd/:vesselName/:vesselCode/:voyageId/:vesselOwner/:voyageCostingStatus',
						data : {
							title : 'Add'
						},
						controller : 'estimatesAddCtrl',
						templateUrl : 'views/finance/controlscreen/estimates/EstimatesAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/estimates/EstimatesAddCtrl.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.controlscreen.estimates-thirdparty-add',
					{
						url : '/controlscreen/estimateThirdPartyAdd/:vesselName/:vesselCode/:voyageId/:vesselOwner/:voyageCostingStatus',
						data : {
							title : 'Third Party Add'
						},
						controller : 'estimatesThirdPartyAddCtrl',
						templateUrl : 'views/finance/controlscreen/estimates/EstimatesThirdPartyAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/estimates/EstimatesThirdPartyAddCtrl.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.controlscreen.estimates-edit',
					{
						url : '/controlscreen/estimateEdit/:estimateCode/:vesselOwner/:voyageCostingStatus',
						data : {
							title : 'Edit'
						},
						controller : 'estimatesAddCtrl',
						templateUrl : 'views/finance/controlscreen/estimates/EstimatesAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/estimates/EstimatesAddCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.finance.controlscreen.estimates-thirdparty-edit',
					{
						url : '/controlscreen/estimateThirdpartyEdit/:estimateCode/:vesselOwner/:voyageCostingStatus',
						data : {
							title : 'Third Party Edit'
						},
						controller : 'estimatesThirdPartyAddCtrl',
						templateUrl : 'views/finance/controlscreen/estimates/EstimatesThirdPartyAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/estimates/EstimatesThirdPartyAddCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.finance.controlscreen.estimates-view',
					{
						url : '/controlscreen/estimateView/:estimateCode/:operation/:vesselOwner/:voyageCostingStatus',
						data : {
							title : 'View'
						},
						controller : 'estimatesAddCtrl',
						templateUrl : 'views/finance/controlscreen/estimates/EstimatesView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/estimates/EstimatesAddCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.finance.controlscreen.estimates-thirdparty-view',
					{
						url : '/controlscreen/estimateThirdPartyView/:estimateCode/:operation/:vesselOwner/:voyageCostingStatus',
						data : {
							title : 'Third Party View'
						},
						controller : 'estimatesThirdPartyAddCtrl',
						templateUrl : 'views/finance/controlscreen/estimates/EstimatesThirdPartyView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/estimates/EstimatesThirdPartyAddCtrl.js' ])
									} ]
						}

					})
			// code added for mda
			.state(
					'app.finance.controlscreen.mdalist',
					{
						url : '/controlscreen/mdalist',
						data : {
							title : 'MDA Agent List'
						},
						controller : 'mdaListCtrl',
						templateUrl : 'views/finance/controlscreen/mdaaccounting/mdaaccountinglist',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/mdaaccounting/mdaaccounting.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.controlscreen.mda',
					{
						url : '/controlscreen/mda/:agentCode',
						data : {
							title : 'MDA'
						},
						controller : 'mdaCtrl',
						templateUrl : 'views/finance/controlscreen/mdaaccounting/mdaaccounting',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/mdaaccounting/mdaaccounting.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.controlscreen.mdaAdd',
					{
						url : '/controlscreen/mdaadd/:agentCode/:month/:year/:agentName/:monYear/:companyCode/:companyName',
						data : {
							title : 'MDA Add'
						},
						controller : 'mdaCtrlAdd',
						templateUrl : 'views/finance/controlscreen/mdaaccounting/mdaaccountingadd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/mdaaccounting/mdaaccounting.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.controlscreen.mdaView',
					{
						url : '/controlscreen/mdaView/:agentCode/:month/:year/:companyCode/:companyName',
						data : {
							title : 'MDA Report'
						},
						controller : 'mdaCtrlView',
						templateUrl : 'views/finance/controlscreen/mdaaccounting/mdaaccountingview',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/mdaaccounting/mdaaccounting.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.controlscreen.mdaEdit',
					{
						url : '/controlscreen/mdaEdit/:agentCode/:month/:year/:companyCode/:companyName',
						data : {
							title : 'MDA Edit'
						},
						controller : 'mdaCtrlEdit',
						templateUrl : 'views/finance/controlscreen/mdaaccounting/mdaaccountingedit',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/mdaaccounting/mdaaccounting.js' ]);
									} ]
						}

					})

			// Reconciliation
			.state(
					'app.finance.controlscreen.reconciliationList',
					{
						url : '/controlscreen/reconciliationList',
						params : {
							accountCode : null,
							voyage : null,
							port : null,
							daExchangeRate : null,
							daTCAmt : null,
							daBCAmt : null,
							vpaExchangeRate : null,
							vpaTCAmt : null,
							vpaBCAmt : null,
							remarks : null
						},
						data : {
							title : 'Reconciliation List'
						},
						controller : 'reconciliationListCtrl',
						templateUrl : 'views/finance/controlscreen/reconciliation/reconciliationList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/reconciliation/reconciliationCtrl.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.controlscreen.reconciliationEdit',
					{
						url : '/controlscreen/reconciliationEdit',
						data : {
							title : 'Reconciliation Edit'
						},
						controller : 'reconciliationEditCtrl',
						templateUrl : 'views/finance/controlscreen/reconciliation/reconciliationAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/reconciliation/reconciliationCtrl.js' ]);
									} ]
						}

					})
			// added for proviosnal accounting

			/*
			 * .state('app.finance.controlscreen.provisionalAllocation', { url :
			 * '/controlscreen/provisionalAccounts', data : { title :
			 * 'Provisional Allocation List' }, views : { "content@app" : {
			 * controller : 'provisionalAccountCtrl', templateUrl :
			 * 'views/finance/controlscreen/provisionalAllocation/provisionalAccList',
			 * resolve : { deps : [ '$ocLazyLoad', function($ocLazyLoad) {
			 * return $ocLazyLoad.load([
			 * 'js/app/finance/controlscreen/provisionalAccounts/provisionalAccountCtrl.js'
			 * ]); } ] } } } })
			 */
			.state(
					'app.finance.controlscreen.provisionalAllocation',
					{
						url : '/controlscreen/provisionalAccounts',
						data : {
							title : 'Disbursement Agent List'
						},
						controller : 'provisionalAccountCtrl',
						templateUrl : 'views/finance/controlscreen/provisionalAllocation/disbursementAgentList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/provisionalAccounts/provisionalAccountCtrl.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.controlscreen.provisionalAllocationMontly',
					{
						url : '/controlscreen/provisionalAccounts/monthly/:agent',
						data : {
							title : 'Disbursement Monthly List'
						},
						controller : 'provisionalAccountMonthlyCtrl',
						templateUrl : 'views/finance/controlscreen/provisionalAllocation/disbursementMonthlyProvisionalList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/provisionalAccounts/provisionalAccountCtrl.js' ]);
									} ]
						}

					})

			.state(
					'app.finance.controlscreen.provisionalAllocationVoyage',
					{
						url : '/controlscreen/provisionalAccounts/voyagewise/:agent/:month',
						data : {
							title : 'Disbursement Monthly Voyge List'
						},
						controller : 'provisionalAccountMonthlyVoyageCtrl',
						templateUrl : 'views/finance/controlscreen/provisionalAllocation/disbursementMonthlyProvisionalVoyageList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/provisionalAccounts/provisionalAccountCtrl.js' ]);
									} ]
						}

					})

			/*
			 * .state('app.finance.controlscreen.provisionalAllocationAdd', {
			 * url : '/controlscreen/provisionalAccountsAdd', data : { title :
			 * 'Provisional Allocation Add' }, views : { "content@app" : {
			 * controller : 'provisionalAccountAddCtrl', templateUrl :
			 * 'views/finance/controlscreen/provisionalAllocation/provisionalAccAdd',
			 * resolve : { deps : [ '$ocLazyLoad', function($ocLazyLoad) {
			 * return $ocLazyLoad.load([
			 * 'js/app/finance/controlscreen/provisionalAccounts/provisionalAccountCtrl.js'
			 * ]); } ] } } } })
			 */

			.state(
					'app.finance.controlscreen.provisionalAllocationAdd',
					{
						url : '/controlscreen/provisionalAccountsAdd',
						data : {
							title : 'Disbursement Allocation Add'
						},
						controller : 'provisionalAccountAddCtrl',
						templateUrl : 'views/finance/controlscreen/provisionalAllocation/provisionalAccAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/provisionalAccounts/provisionalAccountCtrl.js' ]);
									} ]
						}

					})

			.state(
					'app.finance.controlscreen.provisionalAllocationView',
					{
						url : '/controlscreen/provisionalAccountsView/:disbursementNo',
						data : {
							title : 'Provisional Allocation View'
						},
						controller : 'provisionalAccountViewCtrl',
						templateUrl : 'views/finance/controlscreen/provisionalAllocation/provisionalAccView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/provisionalAccounts/provisionalAccountCtrl.js' ]);
									} ]
						}

					})
			// code added for Disbursement invoice allocation
			.state(
					'app.finance.controlscreen.disbursementInvoice',
					{
						url : '/controlscreen/voyageProvisonalAllocation',
						data : {
							title : 'Voyage Provisional Allocation'
						},
						controller : 'disbursementInvoiceCtrl',
						templateUrl : 'views/finance/controlscreen/estimates/disbursementInvoiceList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/estimates/disbursementInvoiceCtrl.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.controlscreen.disbursementInvoiceAdd',
					{
						url : '/controlscreen/voyageProvisonalAllocationAdd',
						data : {
							title : 'Voyage Provisional Allocation'
						},
						controller : 'disbursementInvoiceAddCtrl',
						templateUrl : 'views/finance/controlscreen/estimates/disbursementInvoiceAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/estimates/disbursementInvoiceCtrl.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.controlscreen.disbursementInvoiceView',
					{
						url : '/controlscreen/voyageProvisonalAllocationView/:disbursementNo',
						data : {
							title : 'Voyage Provisional Allocation'
						},
						controller : 'disbursementInvoiceViewCtrl',
						templateUrl : 'views/finance/controlscreen/estimates/disbursementInvoiceView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/estimates/disbursementInvoiceCtrl.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.controlscreen.disbursementInvoiceEdit',
					{
						url : '/controlscreen/voyageProvisonalAllocationEdit/:disbursementNo',
						data : {
							title : 'Voyage Provisional Allocation'
						},
						controller : 'disbursementInvoiceEditCtrl',
						templateUrl : 'views/finance/controlscreen/estimates/disbursementInvoiceEdit',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/estimates/disbursementInvoiceCtrl.js' ]);
									} ]
						}

					})

			/*
			 * TDS Nature
			 */
			.state('app.finance.tax.tds', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'TDS'
				}
			})

			.state('app.finance.tax.tds.tdsnature', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'TDS Nature'
				}
			})
			.state('app.finance.tax.tds.vendornature', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Vendor Nature'
				}
			})
			.state('app.finance.tax.tds.tdstax', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'TDS Tax'
				}
			})
			.state(
					'app.finance.tax.tds.tdsnature.list',
					{
						url : '/tds/tdsnature/list',
						data : {
							title : 'List'
						},
						controller : 'tdsNatureListCtrl',
						templateUrl : 'views/finance/tax/tds/TdsNatureList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/tax/tds/tdsNatureCtrl.js' ]);
									} ]
						}

					})

			.state(
					'app.finance.tax.tds.tdsnature.add',
					{
						url : '/tds/tdsnature/add',
						data : {
							title : 'Add'
						},
						controller : 'tdsNatureAddCtrl',
						templateUrl : 'views/finance/tax/tds/TdsNatureAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/tax/tds/tdsNatureCtrl.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.tax.tds.tdsnature.edit',
					{
						url : '/tds/tdsnature/edit/:natureCode',
						data : {
							title : 'Edit'
						},
						controller : 'tdsNatureEditCtrl',
						templateUrl : 'views/finance/tax/tds/TdsNatureAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/tax/tds/tdsNatureCtrl.js' ]);
									} ]
						}

					})
			/*
			 * venodr nature
			 */
			.state(
					'app.finance.tax.tds.vendornature.list',
					{
						url : '/tds/vendornature/list',
						data : {
							title : 'List'
						},
						controller : 'vendorNatureListCtrl',
						templateUrl : 'views/finance/tax/tds/VendorNatureList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/tax/tds/vendorNatureCtrl.js' ]);
									} ]
						}

					})

			.state(
					'app.finance.tax.tds.vendornature.add',
					{
						url : '/tds/vendornature/add',
						data : {
							title : 'Add'
						},
						controller : 'vendorNatureAddCtrl',
						templateUrl : 'views/finance/tax/tds/VendorNatureAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/tax/tds/vendorNatureCtrl.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.tax.tds.vendornature.edit',
					{
						url : '/tds/vendornature/edit/:natureCode',
						data : {
							title : 'Edit'
						},
						controller : 'vendorNatureEditCtrl',
						templateUrl : 'views/finance/tax/tds/VendorNatureAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/tax/tds/vendorNatureCtrl.js' ]);
									} ]
						}

					})
			/*
			 * Tds Tax
			 */
			.state(
					'app.finance.tax.tds.tdstax.list',
					{
						url : '/tds/tdstax/list',
						data : {
							title : 'List'
						},
						controller : 'tdsTaxListCtrl',
						templateUrl : 'views/finance/tax/tds/TdsTaxList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/tax/tds/tdsTaxCtrl.js' ]);
									} ]
						}

					})

			.state(
					'app.finance.tax.tds.tdstax.add',
					{
						url : '/tds/tdstax/add',
						data : {
							title : 'Add'
						},
						controller : 'tdsTaxAddCtrl',
						templateUrl : 'views/finance/tax/tds/TdsTaxAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/tax/tds/tdsTaxCtrl.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.tax.tds.tdstax.edit',
					{
						url : '/tds/tdstax/edit/:natureCode',
						data : {
							title : 'Edit'
						},
						controller : 'tdsTaxEditCtrl',
						templateUrl : 'views/finance/tax/tds/TdsTaxAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/tax/tds/tdsTaxCtrl.js' ]);
									} ]
						}

					})
			.state('app.finance.tax.vesselreturn', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Vessel Return'
				}
			})
			.state('app.finance.tax.vesselreturn.freighttax', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Freight Tax'
				}
			})
			/*
			 * Freight Tax
			 */
			.state(
					'app.finance.tax.vesselreturn.freighttax.list',
					{
						url : '/tax/freighttax/list',
						data : {
							title : 'List'
						},
						controller : 'freightTaxListCtrl',
						templateUrl : 'views/finance/tax/vesselreturn/FreightTaxList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/tax/vesselreturn/freightTaxCtrl.js' ]);
									} ]
						}

					})

			.state(
					'app.finance.tax.vesselreturn.freighttax.add',
					{
						url : '/tax/freighttax/add',
						data : {
							title : 'Add'
						},
						controller : 'freightTaxAddCtrl',
						templateUrl : 'views/finance/tax/vesselreturn/FreightTaxAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/tax/vesselreturn/freightTaxCtrl.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.tax.vesselreturn.freighttax.edit',
					{
						url : '/tax/freighttax/edit/:freightTaxCode',
						data : {
							title : 'Edit'
						},
						controller : 'freightTaxEditCtrl',
						templateUrl : 'views/finance/tax/vesselreturn/FreightTaxAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/tax/vesselreturn/freightTaxCtrl.js' ]);
									} ]
						}

					})

			/*
			 * Tax Payment
			 */
			.state('app.finance.tax.taxpayment', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Tax Payment'
				}
			})
			.state(
					'app.finance.tax.taxpayment.list',
					{
						url : '/tax/taxpayment/list',
						data : {
							title : 'List'
						},
						controller : 'taxPaymentListCtrl',
						templateUrl : 'views/finance/tax/TaxPaymentList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/tax/taxPaymentCtrl.js' ]);
									} ]
						}

					})

			.state(
					'app.finance.tax.taxpayment.add',
					{
						url : '/tax/taxpayment/add',
						data : {
							title : 'Add'
						},
						controller : 'taxPaymentAddCtrl',
						templateUrl : 'views/finance/tax/TaxPaymentList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/tax/taxPaymentCtrl.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.tax.taxpayment.edit',
					{
						url : '/tax/taxpayment/edit/:taxPaymentCode',
						data : {
							title : 'Edit'
						},
						controller : 'taxPaymentEditCtrl',
						templateUrl : 'views/finance/tax/TaxPaymentList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/tax/taxPaymentCtrl.js' ]);
									} ]
						}

					})

			/*
			 * chartofaccounts
			 */
			.state(
					'app.finance.configuration.chartofaccounts.list',
					{
						url : '/configuration/chartofaccounts/chartOfAccounts',
						data : {
							title : 'List'
						},
						controller : 'ChartOfAccountsTreeCtrl',
						templateUrl : 'views/finance/controlscreen/chartofaccounts/chartOfAccounts',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/chartofaccounts/chartOfAccountsCtrl.js' ]);
									} ]
						}

					})
			.state('app.finance.transaction.presentation', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Presentation'
				}
			})
			.state(
					'app.finance.transaction.presentation.list',
					{
						url : '/transaction/presentation/list',
						data : {
							title : 'List'
						},
						controller : 'presentationCtrl',
						templateUrl : 'views/finance/transaction/chqPresentation',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/chqPresentationCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.finance.transaction.presentation.add',
					{
						url : '/transaction/presentation/add',
						data : {
							title : 'Add'
						},
						controller : 'presentationAddCtrl',
						templateUrl : 'views/finance/transaction/chqPresentationForm',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/chqPresentationCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.finance.transaction.presentation.view',
					{
						url : '/transaction/presentation/view/:prCode',
						data : {
							title : 'View'
						},
						controller : 'presentationCtrlview',
						templateUrl : 'views/finance/transaction/print/chqPresentationView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/chqPresentationCtrl.js' ])
									} ]
						}

					})
			.state('app.finance.transaction.realisation', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Realisation'
				}
			})
			.state(
					'app.finance.transaction.realisation.list',
					{
						url : '/transaction/realisation/list',
						data : {
							title : 'List'
						},
						controller : 'realisationCtrl',
						templateUrl : 'views/finance/transaction/chqRealisation',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/chqRealisationCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.finance.transaction.realisation.add',
					{
						url : '/transaction/realisation/add',
						data : {
							title : 'Add'
						},
						controller : 'realisationAddCtrl',
						templateUrl : 'views/finance/transaction/chqRealisationForm',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/chqRealisationCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.finance.invoice.invoiceConsolidation',
					{
						url : '/invoice/invoiceConsolidation',
						data : {
							title : 'Invoice Consolidation'
						},
						controller : 'invoiceConsolidationCtrl',
						templateUrl : 'views/finance/invoice/invoiceConsolidation',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/invoiceConsolidationCtrl.js' ]);
									} ]
						}

					})

			.state(
					'app.finance.invoice.invoiceConsolidation-list',
					{
						url : '/invoice/invoiceConsolidation/list',
						data : {
							title : 'Invoice Consolidation List'
						},
						controller : 'invoiceConsolidationListCtrl',
						templateUrl : 'views/finance/invoice/invoiceConsolidationList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/invoiceConsolidationCtrl.js' ]);
									} ]
						}

					})

			.state(
					'app.finance.invoice.invoiceConsolidation-view',
					{
						url : '/invoice/invoiceConsolidation/view',
						data : {
							title : 'Invoice Consolidation View'
						},
						controller : 'invoiceConsolidationViewCtrl',
						templateUrl : 'views/finance/invoice/invoiceConsolidationView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/invoiceConsolidationCtrl.js' ]);
									} ]
						}

					})

			.state(
					'app.finance.invoice.splitInvoice',
					{
						url : '/invoice/splitInvoice',
						data : {
							title : 'Split Invoice'
						},
						controller : 'splitInvoiceCtrl',
						templateUrl : 'views/finance/invoice/splitInvoice',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/splitInvoiceCtrl.js' ]);
									} ]
						}

					})

			.state(
					'app.finance.controlscreen.closingaccounts',
					{
						url : '/controlscreen/closingAccount/List',
						data : {
							title : 'Closing Accounts'
						},
						controller : 'closingAccountCtrl',
						templateUrl : 'views/finance/controlscreen/closingaccounts/closingaccountslist',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/closingaccounts/closingAccountsList.js' ]);
									} ]
						}

					})

			.state(
					'app.finance.controlscreen.closingaccountsadd',
					{
						url : '/controlscreen/closingAccount/add',
						data : {
							title : ' Closing Accounts'
						},
						controller : 'closingAccountCntrlAdd',
						templateUrl : 'views/finance/controlscreen/closingaccounts/closingaccountsadd',
						resolve : {

							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/closingaccounts/closingAccountsList.js' ])
									} ]
						}

					})

			.state(
					'app.finance.controlscreen.accountingyearcloseadd',
					{
						url : '/controlscreen/accountingyearclose/add',
						data : {
							title : 'Accounting Year Close'
						},
						controller : 'accountingyearcloseCtrl',
						templateUrl : 'views/finance/controlscreen/accountingyearclose/accountingyearcloseadd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/accountingyearclose/accountingyearclose.js' ])
									} ]
						}

					})

			.state(
					'app.finance.invoice.deadfreight',
					{
						url : '/invoice/deadfreight/add',
						data : {
							title : 'Dead Freight Add'
						},
						controller : 'deadFreightAddCtrl',
						templateUrl : 'views/finance/invoice/deadfreight/deadfreightadd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/deadfreight/deadFreightAddCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.finance.invoice.PHCInvoice',
					{
						url : '/invoice/phcinvoice/list',
						data : {
							title : 'phc invoice'
						},
						controller : 'phcinvoiceCtrl',
						templateUrl : 'views/finance/invoice/phcinvoice/phcinvoicelist',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/phcinvoice/phcinvoicectrl.js' ])
									} ]
						}

					})

			.state(
					'app.finance.invoice.PHCInvoice.add',
					{
						url : '/invoice/phcinvoice/add',
						data : {
							title : 'phc invoice Add'
						},
						controller : 'phcinvoiceCtrlAdd',
						templateUrl : 'views/finance/invoice/phcinvoice/phcinvoiceadd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/phcinvoice/phcinvoicectrl.js' ])
									} ]
						}

					})
			.state(
					'app.finance.invoice.PHCInvoicenew.search',
					{
						url : '/invoice/phcinvoicenew/search',
						data : {
							title : 'phc invoice'
						},
						controller : 'phcInvoiceSearchCtrl',
						templateUrl : 'views/finance/invoice/phcinvoice/phcInvoiceNewSearch',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/phcinvoice/phcinvoicenewctrl.js' ])
									} ]
						}

					})
			.state(
					'app.finance.invoice.PHCInvoicenew.pendingList',
					{
						url : '/invoice/phcinvoicenew/pendingList',
						params : {
							voyage : null,
							pol : null,
							pod : null,
							blNo : null,
							customerCode : null,
							payer : null

						},
						data : {
							title : 'phc invoice'
						},
						controller : 'pendingPhcCtrl',
						templateUrl : 'views/finance/invoice/phcinvoice/phcInvoicePendingList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/phcinvoice/phcinvoicenewctrl.js' ])
									} ]
						}

					})
			// PHC Invoice abbas
			.state(
					'app.finance.invoice.PHCInvoicenew.list',
					{
						url : '/invoice/phcinvoicenew/list',
						data : {
							title : 'phc invoice'
						},

						controller : 'phcinvoiceCtrl',
						templateUrl : 'views/finance/invoice/phcinvoice/phcinvoicenewlist',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/phcinvoice/phcinvoicenewctrl.js' ])
									} ]
						}

					})

			.state(
					'app.finance.invoice.PHCInvoicenew.add',
					{
						url : '/invoice/phcinvoicenew/add',
						data : {
							title : 'phc invoice Add'
						},
						controller : 'phcinvoiceCtrlAdd',
						templateUrl : 'views/finance/invoice/phcinvoice/phcinvoicenewadd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/phcinvoice/phcinvoicenewctrl.js' ])
									} ]
						}

					})
			.state(
					'app.finance.invoice.PHCInvoicenew-add',
					{
						url : '/invoice/phcinvoicenew/confirm/:blNo/:flag/:bookdtl/:slNo',
						data : {
							title : 'phc invoice Add'
						},
						controller : 'phcinvoiceCtrlAddNew',
						templateUrl : 'views/finance/invoice/phcinvoice/phcinvoicenewadd1',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/phcinvoice/phcinvoicenewctrl.js' ])
									} ]
						}

					})
			.state(
					'app.finance.invoice.PHCInvoicenew.view',
					{
						url : '/invoice/PHCInvoicenew/view/:phcinvoiceNo',
						data : {
							title : 'View'
						},
						controller : 'phcInvoiceViewCtrl',
						templateUrl : 'views/finance/invoice/phcinvoice/phcInvoiceNewView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/phcinvoice/phcinvoicenewctrl.js' ])
									} ]
						}

					})
			.state(
					'app.finance.invoice.PHCInvoicenew.tempview',
					{
						url : '/invoice/PHCInvoicenewtemp/tempview/:phcinvoiceNo',
						data : {
							title : 'View'
						},
						controller : 'phcInvoicetempViewCtrl',
						templateUrl : 'views/finance/invoice/phcinvoice/phcInvoiceNewView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/phcinvoice/phcinvoicenewctrl.js' ])
									} ]
						}

					})
			.state(
					'app.finance.invoice.PHCInvoicenew.view1',
					{
						url : '/invoice/PHCInvoicenew/view1/:phcinvoiceNo1',
						data : {
							title : 'View'
						},
						controller : 'phcInvoiceViewCtrl',
						templateUrl : 'views/finance/invoice/phcinvoice/phcInvoiceNewView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/phcinvoice/phcinvoicenewctrl.js' ])
									} ]
						}

					})

			// Customer Invoice
			.state(
					'app.finance.invoice.CustomerInvoice',
					{
						url : '/invoice/customerinvoice/list',
						data : {
							title : 'Customer Invoice List'
						},
						controller : 'customerInvoiceCtrl',
						templateUrl : 'views/finance/invoice/customerinvoice/customerInvoice',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/customerinvoice/customerInvoice.js' ])
									} ]
						}

					})

			.state(
					'app.finance.invoice.CustomerInvoiceAdd',
					{
						url : '/invoice/customerinvoice/add',
						data : {
							title : 'Customer Invoice Add'
						},
						controller : 'customerInvoiceAddCtrl',
						templateUrl : 'views/finance/invoice/customerinvoice/customerInvoiceAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/customerinvoice/customerInvoiceAdd.js' ])
									} ]
						}

					})

			.state(
					'app.finance.invoice.CustomerInvoiceView',
					{
						url : '/invoice/customerinvoice/view/:invoiceNo',
						data : {
							title : 'View'
						},
						controller : 'customerInvoiceViewCtrl',
						templateUrl : 'views/finance/invoice/customerinvoice/customerInvoiceView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/customerinvoice/customerInvoice.js' ])
									} ]
						}

					})

			// Groupgroup
			.state('app.finance.controlscreen.creditgroup', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Credit Group'
				}
			})
			.state(
					'app.finance.controlscreen.creditgroup.list',
					{
						url : '/creditgroup/list',
						data : {
							title : 'List'
						},
						controller : 'creditgroupListCtrl',
						templateUrl : 'views/finance/controlscreen/creditgroup/creditgroupList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/creditgroup/creditgroupListCtrl.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.controlscreen.creditgroup.add',
					{
						url : '/creditgroup/add',
						data : {
							title : 'Add'
						},
						controller : 'creditgroupAddCtrl',
						templateUrl : 'views/finance/controlscreen/creditgroup/creditGroupAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/creditgroup/creditgroupAddCtrl.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.controlscreen.creditgroup.edit',
					{
						url : '/creditgroup/edit/:groupId',
						data : {
							title : 'Edit'
						},
						controller : 'creditgroupEditCtrl',
						templateUrl : 'views/finance/controlscreen/creditgroup/creditGroupAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/creditgroup/creditgroupAddCtrl.js' ]);
									} ]
						}

					})

			// payer master
			.state(
					'app.finance.controlscreen.payer',
					{
						url : '/controlscreen/payer',
						data : {
							title : 'Payer View'
						},
						controller : 'payerMasterCtrl',
						templateUrl : 'views/finance/controlscreen/payer/payerList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/payer/payerMasterCtrl.js' ]);
									} ]
						}

					})

			.state(
					'app.finance.controlscreen.payer-add',
					{
						url : '/controlscreen/payer/add',
						data : {
							title : 'Add'
						},
						controller : 'PayerMasterAddCtrl',
						templateUrl : 'views/finance/controlscreen/payer/payerMasterAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/payer/payerMasterAddCtrl.js' ]);
									} ]
						}

					})

			.state(
					'app.finance.controlscreen.payer-view',
					{
						url : '/controlscreen/payer/view',
						data : {
							title : 'Add'
						},
						controller : 'PayerMasterViewCtrl',
						templateUrl : 'views/finance/controlscreen/payer/payerMasterViewPage',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/payer/payerMasterViewCtrl.js' ]);
									} ]
						}

					})

			.state(
					'app.mis.receivable.accountSettledInvoices',
					{
						url : '/reports/receivable/accountSettledInvoices',
						data : {
							title : 'Account Settled Invoices '
						},
						controller : 'accountSettledInvoicesCtrl',
						templateUrl : 'views/finance/reports/accountSettledInvoices',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/reports/accountSettledInvoices.js' ])
									} ]

						}

					})

	/*
	 * .state( 'app.finance.reports.payable.accountSettledInvoicePayable', { url :
	 * '/reports/payable/accountSettledInvoices', data : { title : 'Account
	 * Payable - Settled Invoice List' }, controller :
	 * 'accountPayableSettledInvoicesCtrl', templateUrl :
	 * 'views/finance/reports/accountPayableSettledInvoices', resolve : { deps : [
	 * '$ocLazyLoad', function($ocLazyLoad) { return $ocLazyLoad .load([
	 * 'js/app/finance/reports/accountPayableSettledInvoices.js' ]) } ] } })
	 */

	$stateProvider
			.state('app.mis.payable', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Payable'
				}
			})

			.state(
					'app.mis.payable.accountSettledInvoicePayable',
					{
						url : '/reports/payable/accountSettledInvoices',
						data : {
							title : 'Account Settled Invoices'
						},
						controller : 'accountPayableSettledInvoicesCtrl',
						templateUrl : 'views/finance/reports/accountPayableSettledInvoices',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/reports/accountPayableSettledInvoices.js' ])
									} ]

						}

					})

			.state(
					'app.finance.reports.income.revecompletClosuresearch',
					{
						url : '/reports/income/revecompletClosuresearch',
						data : {
							title : 'Revenue Completion & Closure'
						},
						controller : 'revecompletClosureSearchCtrl',
						templateUrl : 'views/finance/reports/Income/revenueCompletionClosureSearch',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/income/revecompletClosureCtrl.js' ])
									} ]

						}

					})

			.state(
					'app.finance.reports.income.revecompletClosureadd',
					{
						url : '/reports/income/revecompletClosure/add',
						data : {
							title : 'Revenue Completion & Closure'
						},
						controller : 'revecompletClosureAddCtrl',
						templateUrl : 'views/finance/reports/Income/revenueCompletionClosureAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/income/revecompletClosureCtrl.js' ])
									} ]

						}

					})

			.state(
					'app.finance.reports.income.revecompletClosureview',
					{
						url : '/reports/income/revecompletClosure/view',
						data : {
							title : 'Revenue Completion & Closure'
						},
						controller : 'revecompletClosureAddCtrl',
						templateUrl : 'views/finance/reports/Income/revenueCompletionClosureView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/income/revecompletClosureCtrl.js' ])
									} ]

						}

					})

			// Inventory
			/*
			 * .state('app.finance.reports.inventory', { abstract : true,
			 * templateUrl : "views/common", data : { title : 'Inventory' } })
			 */
			.state(
					'app.mis.schedule.inventorylist',
					{
						url : '/inventry/list',
						data : {
							title : 'InventoryList'
						},

						controller : 'inventoryCtrl',
						templateUrl : 'views/finance/reports/schedule/inventory/inventorySearch',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/reports/schedule/inventry/inventoryCtrl.js' ]);
									} ]
						}

					})

			.state('app.finance.transaction.purchasecreditNotelist', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Purchase Credit Note'
				}
			})

			.state(
					'app.finance.transaction.purchasecreditNotelist.list',
					{
						url : '/transaction/purchasecreditNotelist/list',
						data : {
							title : 'List'
						},
						controller : 'purchaseCreditNoteCtrl',
						templateUrl : 'views/finance/transaction/purchasecreditNoteListPage',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {

										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/purchaseCreditNoteCtrl.js' ])
									} ]

						}

					})

			.state(
					'app.finance.transaction.purchasecreditNotelist.add',
					{
						url : '/transaction/purchasecreditNotelist/add/:companyCode',
						data : {
							title : 'Add'
						},
						controller : 'purchaseCreditNoteCtrlAdd',
						templateUrl : 'views/finance/transaction/purchaseCreditNoteForm',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {

										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/purchaseCreditNoteCtrl.js' ])
									} ]

						}

					})

			.state(
					'app.finance.transaction.purchasecreditNotelist.view',
					{
						url : '/transaction/purchasecreditNotelist/view',
						data : {
							title : 'Purchase Credit Note View'
						},
						controller : 'purchasecreditNoteCtrlView',
						templateUrl : 'views/finance/transaction/purchasecreditNoteView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {

										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/purchaseCreditNoteCtrl.js' ])
									} ]

						}

					})

			.state(
					'app.finance.transaction.purchasecreditNotelist.edit',
					{
						url : '/transaction/purchasecreditNotelist/edit',
						data : {
							title : 'Edit'
						},
						controller : 'purchaseCreditNoteCtrlAdd',
						templateUrl : 'views/finance/transaction/purchaseCreditNoteForm',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {

										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/purchaseCreditNoteCtrl.js' ])
									} ]

						}

					})

			.state(
					'app.finance.controlscreen.tariff.agencytariffdetail',
					{
						url : '/controlscreen/tariff/agencytariffdetail',
						data : {
							title : 'Agency Tariff Detail'
						},
						controller : 'agencyTariffDetailCtrl',
						templateUrl : 'views/finance/controlscreen/tariff/agencyTariffDetail',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/tariff/agencyTariffDetail.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.controlscreen.tariff.agencytariffdetail.view',
					{
						url : '/controlscreen/tariff/agencytariffdetailview/:agencyTariffCode',
						data : {
							title : 'Agency Tariff Detail'
						},
						controller : 'agencyTariffDetailViewCtrl',
						templateUrl : 'views/finance/controlscreen/tariff/agencyTariffAmountView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/tariff/agencyTariffDetail.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.controlscreen.tariff.agencyCommission',
					{
						url : '/controlscreen/tariff/agencyCommission',
						data : {
							title : 'Agency Tariff Commission'
						},
						controller : 'agencyTariffCommissionCtrl',
						templateUrl : 'views/finance/controlscreen/tariff/agencyTariffCommission',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/tariff/agencyTariffDetail.js' ]);
									} ]
						}

					})

			// //

			.state(
					'app.finance.controlscreen.tariff.thcatuqr',
					{
						url : '/controlscreen/tariff/thcatuqr',
						data : {
							title : 'THC AT UQR'
						},

						controller : 'thcatqtyCtrl',
						templateUrl : 'views/finance/controlscreen/tariff/thcatuqr',
						resolve : {

							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/tariff/thcatuqr.js' ]);
									} ]
						}

					})

			.state(
					'app.finance.transaction.pendingBL',
					{
						url : '/transaction/pendingBL/list',
						data : {
							title : 'Pending TO Be Invoiced'
						},
						controller : 'pendingBLCtrl',
						templateUrl : 'views/finance/transaction/pendingBLListPage',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {

										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/pendingBLCtrl.js' ])
									} ]

						}

					})

			.state(
					'app.finance.transaction.pendingBLView',
					{
						url : '/finance/transaction/pendingBL/View',
						data : {
							title : 'Pending BL'
						},
						params : {
							vessel : null,
							voyage : null,
							pol : null,
							pod : null,
							slot : null,
							company : null,
							fromDate : null,
							toDate : null
						},
						controller : 'pendingBlViewctrl',
						templateUrl : 'views/finance/transaction/pendingBLView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/pendingBlViewctrl.js' ]);
									} ]
						}

					})

			.state(
					'app.finance.transaction.pendingPHCView',
					{
						url : '/finance/transaction/pendingBL/pendingPHC/View',
						data : {
							title : 'Pending BL'
						},
						params : {
							vessel : null,
							voyage : null,
							pol : null,
							pod : null,
							slot : null,
							company : null,
							fromDate : null,
							toDate : null
						},
						controller : 'pendingPHCViewctrl',
						templateUrl : 'views/finance/transaction/pendingPHCView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/pendingBlViewctrl.js' ]);
									} ]
						}

					})
					.state(
					'app.finance.transaction.pendingBLGeneral',
					{
						url : '/transaction/pendingBLGeneral/list',
						data : {
							title : 'Pending TO Be Invoiced'
						},
						controller : 'pendingBLGeneralCtrl',
						templateUrl : 'views/finance/transaction/pendingBLGeneralListPage',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {

										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/pendingBLGeneralCtrl.js' ])
									} ]

						}

					})

			.state(
					'app.finance.transaction.pendingBLGeneralView',
					{
						url : '/finance/transaction/pendingBLGeneral/View',
						data : {
							title : 'Pending BL'
						},
						params : {
							vessel : null,
							voyage : null,
							pol : null,
							pod : null,
							slot : null,
							company : null,
							fromDate : null,
							toDate : null
						},
						controller : 'pendingBlGeneralViewctrl',
						templateUrl : 'views/finance/transaction/pendingBLGeneralView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/pendingBlGeneralViewctrl.js' ]);
									} ]
						}

					})

			.state(
					'app.finance.transaction.pendingPHCGeneralView',
					{
						url : '/finance/transaction/pendingBLGeneral/pendingPHCGeneral/View',
						data : {
							title : 'Pending BL'
						},
						params : {
							vessel : null,
							voyage : null,
							pol : null,
							pod : null,
							slot : null,
							company : null,
							fromDate : null,
							toDate : null
						},
						controller : 'pendingPHCGeneralViewctrl',
						templateUrl : 'views/finance/transaction/pendingPHCGeneralView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/pendingBlGeneralViewctrl.js' ]);
									} ]
						}

					})
			/**
			 * Charter Hire Statement
			 */
			.state('app.finance.reports.charterhirestatement', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Charter Hire Statement'
				}
			})
			.state(
					'app.finance.reports.charterhirestatement.list',
					{
						url : '/reports/charterHireStatement',
						data : {
							title : ''
						},
						controller : 'CharterHireStatementCtrl',
						templateUrl : 'views/finance/reports/charterHireStatement',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/reports/charterHireStatementCtrl.js' ]);
									} ]

						}

					})
			.state(
					'app.finance.reports.charterhirestatement.view',
					{
						url : '/reports/charterHireStatement/view',
						params : {
							vesselCode : null,
							chFromDate : null,
							chToDate : null
						},
						data : {
							title : 'View'
						},
						controller : 'CharterHireStatementViewCtrl',
						templateUrl : 'views/finance/reports/charterHireStmtReport',
						// templateUrl :
						// 'views/finance/reports/charterHireStatementView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/reports/charterHireStatementCtrl.js' ]);
									} ]
						}

					})

			.state(
					'app.finance.reports.charterhirestatement.viewsoa',
					{
						url : '/reports/charterHireStatement/viewsoa',
						params : {
							vesselCode : null,
							chFromDate : null,
							chToDate : null
						},
						data : {
							title : 'View'
						},
						controller : 'CharterHireStatementViewCtrl',
						templateUrl : 'views/finance/reports/charterHireSOA',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/reports/charterHireStatementCtrl.js' ]);
									} ]
						}

					})

			/*
			 * .state('app.finance.transaction.accountpayables.monthlydisbursement', {
			 * abstract : true, data : { title : 'Monthly Disbursement' } })
			 * .state('app.finance.transaction.accountpayables.monthlydisbursement.list', {
			 * url : '/reports/receivable/accountSettledInvoices', data : {
			 * title : 'List' }, views : { "content@app" : { controller :
			 * 'monthlyDisbursementCtrl', templateUrl :
			 * 'views/finance/transaction/accountpayables/monthlyDisbursementSearch',
			 * resolve : { deps : [ '$ocLazyLoad', function($ocLazyLoad) {
			 * return $ocLazyLoad.load([
			 * 'js/app/finance/transaction/accountpayables/monthlyDisbursementCtrl.js' ]) } ] } } } })
			 */

			.state(
					'app.finance.transaction.jvmodula.jvtariff',
					{
						url : '/jvtariff/list',
						data : {
							title : 'JV Tariff'
						},
						controller : 'jvtariffList',
						templateUrl : 'views/finance/controlscreen/jvtariff/jvtarifflist',
						resolve : {

							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/jvtariff/jvtariffCtrl.js' ]);
									} ]
						}

					})

			.state(
					'app.finance.transaction.jvmodula.jvtariffAdd',
					{
						url : '/jvtariff/add',
						data : {
							title : 'JV Tariff'
						},
						controller : 'jvtariffAdd',
						templateUrl : 'views/finance/controlscreen/jvtariff/jvtariffadd',
						resolve : {

							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/jvtariff/jvtariffCtrl.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.transaction.jvmodula.jvtariffView',
					{
						url : '/jvtariff/view/:jvTariffNo',
						data : {
							title : 'JV Tariff'
						},
						controller : 'jvtariffView',
						templateUrl : 'views/finance/controlscreen/jvtariff/jvtariffview',
						resolve : {

							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/jvtariff/jvtariffCtrl.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.transaction.jvmodula.jvtariffEdit',
					{
						url : '/jvtariff/edit/:jvTariffNo',
						data : {
							title : 'JV Tariff'
						},
						controller : 'jvtariffAdd',
						templateUrl : 'views/finance/controlscreen/jvtariff/jvtariffadd',
						resolve : {

							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/jvtariff/jvtariffCtrl.js' ]);
									} ]
						}

					})

			.state(
					'app.finance.transaction.jvmodula.jvtariffcate',
					{
						url : '/jvtariffcategory/list',
						data : {
							title : 'JV Tariff Category'
						},
						controller : 'jvtariffcategoryList',
						templateUrl : 'views/finance/controlscreen/jvtariff/jvtariffcategorylist',
						resolve : {

							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/jvtariff/jvtariffcategoryCtrl.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.transaction.jvmodula.jvtariffcateAdd',
					{
						url : '/jvtariffcategory/add',
						data : {
							title : 'JV Tariff Category'
						},
						controller : 'jvtariffcategoryAdd',
						templateUrl : 'views/finance/controlscreen/jvtariff/jvtariffcategoryadd',
						resolve : {

							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/jvtariff/jvtariffcategoryCtrl.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.transaction.jvmodula.jvtariffcateView',
					{
						url : '/jvtariffcategory/view/:jvTariffNo',
						data : {
							title : 'JV Tariff Category'
						},
						controller : 'jvtariffcategoryView',
						templateUrl : 'views/finance/controlscreen/jvtariff/jvtariffcategoryview',
						resolve : {

							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/jvtariff/jvtariffcategoryCtrl.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.transaction.jvmodula.jvtariffcateEdit',
					{
						url : '/jvtariffcategory/edit/:jvTariffNo',
						data : {
							title : 'JV Tariff Category'
						},
						controller : 'jvtariffcategoryAdd',
						templateUrl : 'views/finance/controlscreen/jvtariff/jvtariffcategoryadd',
						resolve : {

							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/jvtariff/jvtariffcategoryCtrl.js' ]);
									} ]
						}

					})

			/**
			 * Asset
			 */
			.state('app.finance.asset.manage.managelocation', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Manage Asset Location'
				}
			})

			.state(
					'app.finance.asset.manage.managelocation.list',
					{
						url : '/finance/asset/managelocation/list',
						data : {
							title : 'List'
						},
						controller : 'manageLocationListCtrl',
						templateUrl : 'views/finance/asset/managelocation/manageLocationList',
						resolve : {

							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/inventory/manageLocation/manageLocationCtrl.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.asset.manage.managelocation.add',
					{
						url : '/finance/asset/managelocation/add',
						data : {
							title : 'List'
						},
						controller : 'manageLocationAddCtrl',
						templateUrl : 'views/finance/asset/managelocation/manageLocationAdd',
						resolve : {

							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/inventory/manageLocation/manageLocationAddCtrl.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.asset.manage.managelocation.edit',
					{
						url : '/finance/asset/managelocation/edit',
						data : {
							title : 'List'
						},
						controller : 'manageLocationEditCtrl',
						templateUrl : 'views/finance/asset/managelocation/manageLocationAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/inventory/manageLocation/manageLocationAddCtrl.js' ]);
									} ]
						}

					})
					
					
					.state(
					'app.salesmarketing.booking.list',
					{
						url : '/list',
						data : {
							title : 'List'
						},
						templateUrl : "views/salesmarketing/booking/bookingList",
						controller : 'bookingListCtrl',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/salesmarketing/booking/bookingListCtrl.js' ]);
									} ]
						}
					})
			.state(
					'app.salesmarketing.booking.add',
					{
						url : '/add',
						data : {
							title : 'Add'
						},
						templateUrl : "views/salesmarketing/booking/bookingAdd",
						controller : 'bookingAddCtrl',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/salesmarketing/booking/bookingAddCtrl.js' ]);
									} ]
						}
					})
			.state(
					'app.salesmarketing.booking.edit',
					{
						url : '/edit',
						data : {
							title : 'Edit'
						},
						templateUrl : "views/salesmarketing/booking/bookingAdd",
						controller : 'bookingAddCtrl',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/salesmarketing/booking/bookingAddCtrl.js' ]);
									} ]
						}
					})
					
							.state(
					'app.salesmarketing.booking.view',
					{
						url : '/view',
						data : {
							title : 'View'
						},
						templateUrl : "views/salesmarketing/booking/bookingview",
						controller : 'bookingAddCtrl',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/salesmarketing/booking/bookingAddCtrl.js' ]);
									} ]
						}
					})
					
					
					// Booking tool 
					
					.state('app.salesmarketing.bookingtool.list', {
								url : '/docs/bookingtool',
								data : {
									title : 'Booking Tool'
								},
								controller : 'bookingToolCtrl',
								templateUrl : "views/salesmarketing/bookingtool/bookingtool",
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/bookingtool/bookingtoolCtrl.js' ]);
											} ]
								}
							})

			// asset category

			.state('app.finance.asset.manage.assetCategory', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Asset Category'
				}
			})

			.state(
					'app.finance.asset.manage.assetCategory.list',
					{
						url : '/finance/asset/assetCategory/list',
						data : {
							title : 'List'
						},
						controller : 'assetCategoryListCtrl',
						templateUrl : 'views/finance/asset/assetCategory/assetCategoryList',
						resolve : {

							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/asset/assetCategory/assetCategoryListCtrl.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.asset.manage.assetCategory.add',
					{
						url : '/finance/asset/assetCategory/add',
						data : {
							title : 'Add'
						},
						controller : 'assetCategoryAddCtrl',
						templateUrl : 'views/finance/asset/assetCategory/assetCategoryAdd',
						resolve : {

							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/asset/assetCategory/assetCategoryAddCtrl.js' ]);
									} ]
						}

					})

			.state(
					'app.finance.asset.manage.assetCategory.edit',
					{
						url : '/finance/asset/assetCategory/edit',
						data : {
							title : 'Edit'
						},
						controller : 'assetCategoryAddCtrl',
						templateUrl : 'views/finance/asset/assetCategory/assetCategoryAdd',
						resolve : {

							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/asset/assetCategory/assetCategoryAddCtrl.js' ]);
									} ]
						}

					})

			.state('app.finance.asset.assetaccounting', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Asset Accounting'
				}
			})

			// asset purchase

			.state('app.finance.asset.assetaccounting.assetPurchase', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Purchase of Asset'
				}
			})

			.state(
					'app.finance.asset.assetaccounting.assetPurchase.list',
					{
						url : '/finance/asset/assetPurchase/list',
						data : {
							title : 'List'
						},
						controller : 'assetPurchaseListCtrl',
						templateUrl : 'views/finance/asset/assetPurchase/assetPurchaseList',
						resolve : {

							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/asset/assetPurchase/assetPurchaseCtrl.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.asset.assetaccounting.assetPurchase.add',
					{
						url : '/finance/asset/assetPurchase/add',
						data : {
							title : 'Add'
						},
						controller : 'assetPurchaseAddCtrl',
						templateUrl : 'views/finance/asset/assetPurchase/assetPurchaseAdd',
						resolve : {

							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/asset/assetPurchase/assetPurchaseCtrl.js' ]);
									} ]
						}

					})

			.state('app.finance.asset.assetaccounting.assetsale', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Sales of Asset'
				}
			})

			.state(
					'app.finance.asset.assetaccounting.assetsale.list',
					{
						url : '/finance/asset/assetsale/list',
						data : {
							title : 'List'
						},
						controller : 'assetSaleListCtrl',
						templateUrl : 'views/finance/asset/assetsale/assetSaleList',
						resolve : {

							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/asset/assetsale/assetSaleListCtrl.js' ]);
									} ]
						}

					})

			.state(
					'app.finance.asset.assetaccounting.assetsale.add',
					{
						url : '/finance/asset/assetsale/add',
						data : {
							title : 'Add'
						},
						controller : 'assetSaleAddCtrl',
						templateUrl : 'views/finance/asset/assetsale/assetSaleAdd',
						resolve : {

							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/asset/assetsale/assetSaleAddCtrl.js' ]);
									} ]
						}

					})

			.state('app.finance.asset.manage.asset', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Manage Asset'
				}
			})
			.state(
					'app.finance.asset.manage.asset.list',
					{
						url : '/finance/asset/asset/list',
						data : {
							title : 'List'
						},
						controller : 'assetListCtrl',
						templateUrl : 'views/finance/asset/asset/assetList',
						resolve : {

							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/asset/asset/assetListCtrl.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.asset.manage.asset.add',
					{
						url : '/finance/asset/asset/add',
						data : {
							title : 'Add'
						},
						controller : 'assetAddCtrl',
						templateUrl : 'views/finance/asset/asset/assetAdd',
						resolve : {

							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/asset/asset/assetAddCtrl.js' ]);
									} ]
						}

					})

			.state(
					'app.finance.asset.manage.asset.edit',
					{
						url : '/finance/asset/asset/edit',
						data : {
							title : 'Edit'
						},
						controller : 'assetEditCtrl',
						templateUrl : 'views/finance/asset/asset/assetAdd',
						resolve : {

							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/asset/asset/assetAddCtrl.js' ]);
									} ]
						}

					})
			/**
			 * Inventory
			 */

			.state('app.finance.inventory.ggrn', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'General GRN'
				}
			})
			// General GRN

			.state(
					'app.finance.inventory.ggrn.list',
					{
						url : '/finance/inventory/grn/list',
						data : {
							title : 'List'
						},
						controller : 'ggrnListCtrl',
						templateUrl : 'views/finance/inventory/ggrn/ggrnList',
						resolve : {

							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/inventory/ggrn/ggrnListCtrl.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.inventory.ggrn.add',
					{
						url : '/finance/inventory/ggrn/add',
						data : {
							title : 'List'
						},
						controller : 'ggrnAddCtrl',
						templateUrl : 'views/finance/inventory/ggrn/ggrnAdd',
						resolve : {

							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/inventory/ggrn/ggrnAddCtrl.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.inventory.ggrn.view',
					{
						url : '/finance/inventory/ggrn/view',
						data : {
							title : 'List'
						},
						controller : 'ggrnAddCtrl',
						templateUrl : 'views/finance/inventory/ggrn/ggrnView',
						resolve : {

							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/inventory/ggrn/ggrnAddCtrl.js' ]);
									} ]
						}

					})

			/** ********** Inventory Report ************* */
			.state('app.finance.inventory.inventoryRpt', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Inventory Report'
				}
			})
			.state(
					'app.finance.inventory.inventoryRpt.list',
					{
						url : '/finance/inventory/inventoryRpt/list',
						data : {
							title : 'List'
						},
						controller : 'inventoryRptCtrl',
						templateUrl : 'views/finance/inventory/inventoryRpt/inventoryRptList',
						resolve : {

							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/inventory/inventoryRpt/inventoryRptCtrl.js' ]);
									} ]
						}

					})

			/**
			 * Purchase
			 */

			.state('app.finance.purchase.purchaseOrder', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Purchase Order'
				}
			})
			.state(
					'app.finance.purchase.purchaseOrder.list',
					{
						url : '/finance/purchase/purchaseOrder/list',
						data : {
							title : 'List'
						},
						controller : 'purchaseOrderListCtrl',
						templateUrl : 'views/finance/purchase/purchaseOrder/AssetPurchaseOrderList',
						resolve : {

							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/purchase/purchaseOrder/assetPurchaseOrderListCtrl.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.purchase.purchaseOrder.add',
					{
						url : '/finance/purchase/purchaseOrder/add',
						data : {
							title : 'Add'
						},
						controller : 'purchaseOrderAddCtrl',
						templateUrl : 'views/finance/purchase/purchaseOrder/AssetPurchaseOrderAdd',
						resolve : {

							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/purchase/purchaseOrder/assetPurchaseOrderAddCtrl.js' ]);
									} ]
						}

					})

					
					.state('app.finance.transaction.openBalanceUpload', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Opening Balance'
				}
			})

			.state(
					'app.finance.transaction.openBalanceUpload.list',
					{
						url : '/transaction/openingbalance/list',
						data : {
							title : 'List'
						},
						controller : 'openingBalanceListCtrl',
						templateUrl : '/views/finance/transaction/openingBalanceUpload',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/openingBalance/openingBalanceListCtrl.js' ])
									} ]
						}

					})
					
					
					
			.state(
					'app.finance.transaction.openBalanceUpload.add',
					{
						url : '/transaction/openingbalance/add',
						data : {
							title : 'Add'
						},
						controller : 'openingBalanceAddCtrl',
						templateUrl : '/views/finance/transaction/openingBalanceAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/openingBalance/openingBalanceAddCtrl.js' ])
									} ]
						}

					}).state(
							'app.finance.transaction.openBalanceUpload.edit',
							{
								url : '/transaction/openingbalance/edit',
								data : {
									title : 'Edit'
								},
								controller : 'openingBalanceAddCtrl',
								templateUrl : '/views/finance/transaction/openingBalanceAdd',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/finance/transaction/openingBalance/openingBalanceAddCtrl.js' ])
											} ]
								}

							})

			// code for navigating JV Master

			.state('app.finance.transaction.jvaccounts.jvtype', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'JV Type'
				}
			})

			.state(
					'app.finance.transaction.jvaccounts.jvtype.list',
					{
						url : '/transaction/jvaccounts/jvtype/list',
						data : {
							title : 'JV Type List'
						},
						controller : 'jvtypeListctrl',
						templateUrl : 'views/finance/transaction/jvaccounts/jvTypeList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/jvaccounts/jvTypeCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.finance.transaction.jvaccounts.jvtype.view',
					{
						url : '/transaction/jvaccounts/jvtype/view/:JvAccountNo',
						data : {
							title : 'JV Type View'
						},
						controller : 'jvtypeViewctrl',
						templateUrl : 'views/finance/transaction/jvaccounts/jvTypeView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/jvaccounts/jvTypeCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.finance.transaction.jvaccounts.jvtype.edit',
					{
						url : '/transaction/jvaccounts/jvtype/edit/:jvTypeCode',
						data : {
							title : 'JV Type'
						},
						controller : 'jvtypectrlAdd',
						templateUrl : 'views/finance/transaction/jvaccounts/jvTypeAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/jvaccounts/jvTypeCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.finance.transaction.jvaccounts.jvtype.add',
					{
						url : '/transaction/jvaccounts/jvtype/add',
						data : {
							title : 'Add JV Type'
						},
						controller : 'jvtypectrlAdd',
						templateUrl : 'views/finance/transaction/jvaccounts/jvTypeAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/jvaccounts/jvTypeCtrl.js' ])
									} ]
						}

					})

			.state('app.finance.transaction.jvaccounts.jvtypedefn', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'JV Type Definition'
				}
			})
			.state(
					'app.finance.transaction.jvaccounts.jvtypedefn.list',
					{
						url : '/transaction/jvaccounts/jvtypedefn/list',
						data : {
							title : 'List'
						},
						controller : 'jvtypeDefnListctrl',
						templateUrl : 'views/finance/transaction/jvaccounts/jvTypeDefinition/jvTypeDefinitionList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/jvaccounts/jvTypeDefinition/jvTypeDefinitionCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.finance.transaction.jvaccounts.jvtypedefn.add',
					{
						url : '/transaction/jvaccounts/jvtypedefn/add',
						data : {
							title : 'Add'
						},
						controller : 'jvtypeDefnAddctrl',
						templateUrl : 'views/finance/transaction/jvaccounts/jvTypeDefinition/jvTypeDefinitionForm',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/jvaccounts/jvTypeDefinition/jvTypeDefinitionCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.finance.transaction.jvaccounts.jvtypedefn.edit',
					{
						url : '/transaction/jvaccounts/jvtypedefn/edit',
						data : {
							title : 'Edit'
						},
						controller : 'jvtypeDefnEditctrl',
						templateUrl : 'views/finance/transaction/jvaccounts/jvTypeDefinition/jvTypeDefinitionForm',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/jvaccounts/jvTypeDefinition/jvTypeDefinitionCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.master.financeControl.cashandBank',
					{
						url : '/financeControl/cashandBank',
						data : {
							title : 'Cash and Bank'
						},
						controller : 'cashandBankMasterCtrl',
						templateUrl : 'views/master/financeControl/cashAndBank',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/financeControl/cashandBankCtrl.js' ]);
									} ]
						}

					})
			.state(
					'app.master.financeControl.cashandBankAdd',
					{
						url : '/financeControl/cashandBank/Add',
						data : {
							title : 'Cash and Bank'
						},
						controller : 'cashandBankAddCtrl',
						templateUrl : 'views/master/financeControl/cashAndBankAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/financeControl/cashandBankAddCtrl.js' ]);
									} ]
						}

					})
			.state(
					'app.master.financeControl.costCentre',
					{
						url : '/financeControl/costCentre',
						data : {
							title : 'Cost Center'
						},
						controller : 'costCentreCtrl',
						templateUrl : 'views/master/financeControl/costCentre',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/financeControl/costCentreCtrl.js' ]);
									} ]
						}

					})

			.state(
					'app.master.financeControl.costCentre-Add',
					{
						url : '/financeControl/costCentre/add',
						data : {
							title : 'Add'
						},
						controller : 'costCentreAddCtrl',
						templateUrl : 'views/master/financeControl/costCentreAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/master/financeControl/costCentreAddCtrl.js' ]);
									} ]
						}

					})

			.state(
					'app.finance.transaction.jvmodula.jvreport',
					{
						url : '/jvreport/list',
						data : {
							title : 'JV Report'
						},
						controller : 'jvReportCtri',
						templateUrl : 'views/finance/controlscreen/jvtariff/jvreport',
						resolve : {

							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/jvtariff/jvreport.js' ]);
									} ]
						}

					})

			.state('app.finance.asset.assetaccount', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Asset Accounting'
				}
			})
			.state(
					'app.finance.asset.assetaccount.assetScrappinglist',
					{
						url : '/assetScrapping/list',
						data : {
							title : 'Scrapping of Asset'
						},
						controller : 'assetScrappingListCtrl',
						templateUrl : 'views/finance/asset/assetScrapping/assetScrappingList',
						resolve : {

							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/asset/assetScrapping/assetScrappingCtrl.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.asset.assetaccount.assetScrappingadd',
					{
						url : '/assetScrapping/add',
						data : {
							title : 'Scrapping of Asset'
						},
						controller : 'assetScrappingAddCtrl',
						templateUrl : 'views/finance/asset/assetScrapping/assetScrappingAdd',
						resolve : {

							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/asset/assetScrapping/assetScrappingCtrl.js' ]);
									} ]
						}

					})
			// Off Invoice list
			.state(
					'app.finance.invoice.offinvoice',
					{
						url : '/invoice/offinvoice',
						data : {
							title : 'Off Invoice'
						},
						controller : 'invoiceController',
						templateUrl : 'views/finance/invoice/offInvoice/offInvoiceList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/offInvoice/offInvoiceCtrl.js' ]);
									} ]
						}

					})

			// view
			.state(
					'app.finance.invoice.offinvoiceview',
					{
						url : '/invoice/offInvoiceView/:invoiceNo',
						data : {
							title : 'View Off Invoice '
						},
						controller : 'singleInvoiceViewController',
						templateUrl : 'views/finance/invoice/offInvoice/offinvoiceview',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/offInvoice/offInvoiceCtrl.js' ]);
									} ]
						}

					})

			.state('app.finance.reports.auditTrial', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Audit Trial'
				}
			})

			.state(
					'app.finance.reports.auditTrial.quotation',
					{
						url : '/reports/auditTrial/quotation',
						data : {
							title : 'Quotation Audit Trial'
						},
						controller : 'quotationAuditTrialCtrl',
						templateUrl : 'views/reports/auditTrial/quotationAuditTrial',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/reports/auditTrial/quotationAuditTrialCtrl.js' ]);
									} ]
						}

					})

			.state(
					'app.finance.reports.auditTrial.singleInvoice',
					{
						url : '/reports/auditTrial/singleInvoice',
						data : {
							title : 'Invoice Audit Trial'
						},
						controller : 'siAuditTrialCtrl',
						templateUrl : 'views/reports/auditTrial/siAuditTrial',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/reports/auditTrial/siAuditTrialCtrl.js' ]);
									} ]
						}

					})

			// freight manifest invoice view
			// view
			.state(
					'app.finance.invoice.viewFmsingleinvoice',
					{
						url : '/invoice/singleInvoiceFmView/:invoiceNo',
						data : {
							title : 'View Single Invoice '
						},
						controller : 'singleInvoiceViewController',
						templateUrl : 'views/finance/invoice/freightManifestInvoiceView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/invoiceCtrl.js' ]);
									} ]
						}

					})

			.state(
					'app.finance.transaction.jvmodula.jvtariffCopy',
					{
						url : '/jvtariff/copy/:jvTariffNo',
						data : {
							title : 'JV Tariff'
						},
						controller : 'jvtariffCopy',
						templateUrl : 'views/finance/controlscreen/jvtariff/jvtariffcopy',
						resolve : {

							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/jvtariff/jvtariffCtrl.js' ]);
									} ]
						}

					})
			.state('app.finance.controlscreen.payersuppliermapping', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Payer Supplier Mapping'
				}
			})
			.state(
					'app.finance.controlscreen.payersuppliermapping.list',
					{
						url : '/controlscreen/payersuppliermapping/list',
						data : {
							title : 'List'
						},
						controller : 'payerSupplierMappingListCtrl',
						templateUrl : 'views/finance/controlscreen/payersuppliermapping/PayerSupplierMappingList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/payersuppliermapping/payerSupplierMappingCtrl.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.controlscreen.payersuppliermapping.add',
					{
						url : '/controlscreen/payersuppliermapping/add',
						data : {
							title : 'Add'
						},
						controller : 'payerSupplierMappingAddCtrl',
						templateUrl : 'views/finance/controlscreen/payersuppliermapping/PayerSupplierMappingForm',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/payersuppliermapping/payerSupplierMappingCtrl.js' ]);
									} ]
						}

					})
			.state('app.finance.transaction.approvals', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Approvals'
				}
			})
			.state(
					'app.finance.transaction.approvals.ownerexpensesList',
					{
						url : '/transaction/approvals/ownerexpensesList',
						data : {
							title : 'DA List'
						},
						controller : 'ownerExpensesListCtrl',
						templateUrl : 'views/finance/approvals/ownerExpensesList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/approvals/ownerExpenses.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.transaction.approvals.ownerexpenses',
					{
						url : '/transaction/approvals/ownerexpenses',
						data : {
							title : 'Owner Expenses'
						},
						controller : 'ownerExpensesCtrl',
						templateUrl : 'views/finance/approvals/ownerExpenses',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/approvals/ownerExpenses.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.transaction.approvals.ownerexpensesAdd',
					{
						url : '/transaction/approvals/ownerexpensesAdd',
						data : {
							title : 'Owner Expenses Allocation'
						},
						controller : 'ownerExpensesAddCtrl',
						templateUrl : 'views/finance/approvals/ownerExpensesAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/approvals/ownerExpenses.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.transaction.approvals.interestcalculation',
					{
						url : '/transaction/approvals/interestcalculation',
						data : {
							title : 'Interest Calculation'
						},
						controller : 'interestCalculationCtrl',
						templateUrl : 'views/finance/approvals/interestCalculation',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/approvals/interestCalculation.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.transaction.approvals.prepaidexpenses',
					{
						url : '/transaction/approvals/prepaidexpenses',
						data : {
							title : 'Prepaid Expenses'
						},
						controller : 'prepaidExpensesCtrl',
						templateUrl : 'views/finance/approvals/prepaidExpenses',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/approvals/prepaidExpenses.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.controlscreen.prepaidExpenseAccounting',
					{
						url : '/controlscreen/prepaidexpensesmapping/prepaidexpensesmapping',
						data : {
							title : 'Prepaid Expenses Mapping'
						},
						controller : 'prepaidExpensesMappingListCtrl',
						templateUrl : 'views/finance/controlscreen/prepaidExpensesMapping/prepaidExpensesMappingList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/prepaidExpensesMapping/prepaidExpensesMapping.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.transaction.approvals.assetDepreciation',
					{
						url : '/transaction/approvals/assetDepreciation',
						data : {
							title : 'Asset Depreciation'
						},
						controller : 'assetDepreciationCtrl',
						templateUrl : 'views/finance/approvals/assetDepreciation',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/approvals/assetDepreciation.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.controlscreen.prepaidExpenseAccountingadd',
					{
						url : '/controlscreen/prepaidexpensesmapping/prepaidexpensesmapping/add',
						data : {
							title : 'Prepaid Expense Accounting Add'
						},
						controller : 'prepaidExpensesMappingCtrl',
						templateUrl : 'views/finance/controlscreen/prepaidExpensesMapping/prepaidExpensesMapping',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/prepaidExpensesMapping/prepaidExpensesMapping.js' ]);
									} ]
						}

					})

			.state(
					'app.finance.invoice.stackinvoice',
					{
						url : '/invoice/stackinvoice/list',
						data : {
							title : 'Stack Invoice'
						},
						controller : 'stackInvoiceCtrl',
						templateUrl : 'views/finance/invoice/stackinvoice/stackinvoice',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/stackInvoice.js' ])
									} ]
						}

					})
			.state(
					'app.finance.reports.customeranalysis',
					{
						url : '/reports/customeranalysis/search',
						data : {
							title : 'Customer Analysis'
						},
						controller : 'customeranalysisCtrl',
						templateUrl : 'views/finance/reports/customerAnalysisReport',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/reports/customerAnalysisCtrl.js' ]);
									} ]
						}

					})

			.state(
					'app.finance.transaction.jvmodula.bulkmodify',
					{
						url : '/jvtariff/bulkmodify',
						data : {
							title : 'JV Tariff'
						},
						controller : 'jvtariffBulkModificationList',
						templateUrl : 'views/finance/controlscreen/jvtariff/jvtariffmodify',
						resolve : {

							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/jvtariff/jvtariffCtrl.js' ]);
									} ]
						}

					})
			.state(
					'app.mis.receivable.chequeDepositCollection',
					{
						url : '/reports/receivable/chequeDepoCollection',
						data : {
							title : 'Cheque Deposit Collection'
						},
						controller : 'ChequeDepoCollectionCtrl',
						templateUrl : 'views/finance/reports/receivables/chequeDepositCollectionPage',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/reports/receivables/chequeDepoCollectionCtrl.js' ])
									} ]

						}

					})

			.state(
					'app.finance.reports.jointvoucher.jvcost',
					{
						url : '/reports/jvcost',
						data : {
							title : 'JV Cost'
						},
						controller : 'jvcostCtri',
						templateUrl : 'views/finance/reports/jvcost',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/reports/jvcost.js' ])
									} ]

						}

					})

			.state(
					'app.finance.reports.jointvoucher.costflow',
					{
						url : '/reports/costflow',
						data : {
							title : 'Cost Flow'
						},
						controller : 'costflowCtri',
						templateUrl : 'views/finance/reports/costflow',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/reports/costflow.js' ])
									} ]

						}

					})

			.state(
					'app.finance.reports.stackutilization',
					{
						url : '/reports/stackutilization',
						data : {
							title : 'Stack Utilization'
						},
						controller : 'stackutilizationCtrl',
						templateUrl : 'views/finance/reports/stackutilization',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/stackInvoice.js' ])
									} ]

						}

					})

			.state(
					'app.finance.reports.stackvsinvoice',
					{
						url : '/reports/stackvsinvoice',
						data : {
							title : 'Stack Usage Vs Invoice Report'
						},
						controller : 'stackvsinvoiceCtrl',
						templateUrl : 'views/finance/reports/stackusagevsinvoice',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/stackInvoice.js' ])
									} ]

						}

					})
			.state(
					'app.finance.transaction.approvals.companyReconciliation',
					{
						url : '/transaction/approvals/companyReconciliation',
						data : {
							title : 'Manage Company Reconciliation'
						},
						controller : 'companyReconciliationCtrl',
						templateUrl : 'views/finance/approvals/companyReconciliation',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/approvals/companyReconciliation.js' ]);
									} ]
						}

					})

			.state(
					'app.finance.controlscreen.loanMaster',
					{
						url : '/controlscreen/loanMaster',
						data : {
							title : 'Loan Master'
						},
						controller : 'loanMasterCtrl',
						templateUrl : 'views/finance/controlscreen/loan/loanMaster',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/loan/loanMasterCtrl.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.controlscreen.loanMaster-add',
					{
						url : '/controlscreen/loanMaster/add',
						data : {
							title : 'Loan Master Add'
						},
						controller : 'loanMasterAddCtrl',
						templateUrl : 'views/finance/controlscreen/loan/loanMasterAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/loan/loanMasterCtrl.js' ]);
									} ]
						}

					})

			.state(
					'app.finance.transaction.approvals.charteroutaproval',
					{
						url : '/transaction/approvals/charteroutaproval',
						data : {
							title : 'Charter Out Approval'
						},
						controller : 'charterOutApprovalCtrl',
						templateUrl : 'views/finance/approvals/charterOutApproval',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/approvals/charterOutApproval.js' ]);
									} ]
						}

					})

			.state(
					'app.finance.transaction.approvals.charteroutaprovalView',
					{
						url : '/transaction/approvals/charteroutaproval/view/:invoiceNo',
						data : {
							title : 'Charter Out Approval View'
						},
						controller : 'charteroutaprovalViewCtrl',
						templateUrl : 'views/finance/approvals/charterOutAprovalView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/approvals/charterOutApproval.js' ])
									} ]
						}

					})

			// CORG BY SECTOR WISE
			.state(
					'app.mis.receivable.corgBySector',
					{
						url : '/reports/corgBySector',
						data : {
							title : 'CORG By Sector'
						},
						controller : 'corgBySectorCtrl',
						templateUrl : 'views/finance/reports/corgBySectorList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/reports/corgBySectorCtrl.js' ])
									} ]

						}

					})
			.state(
					'app.finance.controlscreen.mdaapprove',
					{
						url : '/controlscreen/mdaApprove/:agentCode/:month/:year/:companyCode/:companyName',
						data : {
							title : 'MDA Approve'
						},
						controller : 'mdaApproveCtrl',
						templateUrl : 'views/finance/controlscreen/mdaaccounting/mdaapprove',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/mdaaccounting/mdaaccounting.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.reports.auditTrial.jvtariff',
					{
						url : '/reports/auditTrial/jvtariff',
						data : {
							title : 'JvTariff Audit Trial'
						},
						controller : 'JvtariffAuditTrialCtrl',
						templateUrl : 'views/reports/auditTrial/jvTariffAuditTrial',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/reports/auditTrial/jvtariffAuditTrialCtrl.js' ]);
									} ]
						}

					})

			.state(
					'app.finance.reports.auditTrial.purseQuot',
					{
						url : '/reports/auditTrial/purseQuot',
						data : {
							title : 'Purchase Quot Audit Trial'
						},
						controller : 'PurQuotAuditTrialCtrl',
						templateUrl : 'views/reports/auditTrial/purchasequotAuditTrial',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/reports/auditTrial/purchaseQuotAuditTrialCtrl.js' ]);
									} ]
						}

					})

			.state(
					'app.finance.controlscreen.accountingyearclose',
					{
						url : '/controlscreen/accountingyearclose/list',
						data : {
							title : 'Accounting Year Close'
						},
						templateUrl : 'views/finance/controlscreen/accountingyearclose/accountingyearcloselist',
						controller : 'accountingyearcloselistCtrl',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/accountingyearclose/accountingyearclose.js' ])
									} ]
						}
					})
					
					.state(
					'app.finance.controlscreen.jobordermonthclose',
					{
						url : '/controlscreen/jobordermonthclose/list',
						data : {
							title : 'Job Order Month Close'
						},
						templateUrl : 'views/finance/controlscreen/jobordermonthclose/jobordermonthcloselist',
						controller : 'jobordermonthcloselistCtrl',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/jobordermonthclose/jobordermonthclose.js' ])
									} ]
						}
					})
					
					.state(
					'app.finance.controlscreen.jobordermonthcloseadd',
					{
						url : '/controlscreen/jobordermonthclose/add',
						data : {
							title : 'Job Order Month Close Add'
						},
						controller : 'jobordermonthcloseCtrl',
						templateUrl : 'views/finance/controlscreen/jobordermonthclose/jobordermonthcloseadd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/jobordermonthclose/jobordermonthclose.js' ])
									} ]
						}

					})
					
					.state(
					'app.finance.controlscreen.jobordermonthcloseedit',
					{
						url : '/controlscreen/jobordermonthclose/edit?slNo=',
						data : {
							title : 'Job Order Month Close Edit'
						},
						controller : 'jobordermonthcloseCtrl',
						templateUrl : 'views/finance/controlscreen/jobordermonthclose/jobordermonthcloseadd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/controlscreen/jobordermonthclose/jobordermonthclose.js' ])
									} ]
						}

					})

	$stateProvider.state('app.reports', {
		abstract : true,
		templateUrl : "views/common",
		data : {
			title : 'Reports'
		}
	})

	$stateProvider.state('app.reports.finance', {
		abstract : true,
		templateUrl : "views/common",
		data : {
			title : 'Finance'
		}
	})
	$stateProvider.state('app.reports.schedule', {
		abstract : true,
		templateUrl : "views/common",
		data : {
			title : 'Schedule'
		}
	})
	$stateProvider.state('app.reports.quantity', {
		abstract : true,
	/*
	 * data : { title : 'Quantity' }
	 */
	})

	$stateProvider.state('app.reports.csr', {
		abstract : true,
		data : {
			title : 'Finance'
		}
	})

	$stateProvider.state('app.reports.digital', {
		abstract : true,
		data : {
			title : 'Digital Library'
		}
	})

	$stateProvider
			.state('app.reports.util', {
				abstract : true,
				data : {
					title : 'Utilization'
				}
			})

			// for trial balance

			.state(
					'app.finance.reports.financial.trailbalance',
					{
						url : '/reports/finance/trailbalance',
						data : {
							title : 'Trial Balance'
						},

						controller : 'trialBalanceCtrl',
						templateUrl : 'views/reports/finance/trialbalance',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/reports/finance/trialbalance.js' ]);
									} ]
						}

					})
			// for general ledger

			.state(
					'app.finance.reports.financial.generalLedger',
					{
						url : '/reports/finance/generalLedger',
						data : {
							title : 'General Ledger'
						},

						controller : 'generalLedgerController',
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
					
					// for day book
					.state(
					'app.finance.reports.financial.dayBook',
					{
						url : '/reports/finance/dayBook',
						data : {
							title : 'Day Book'
						},

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
					
					
			// for Income and Expenditure

			.state(
					'app.finance.reports.financial.profitandloss',
					{
						url : '/reports/financial/profitandloss',
						data : {
							title : 'Income and Expenditure'
						},

						controller : 'profitAndLossController',
						templateUrl : 'views/reports/finance/profitandloss',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/reports/finance/profitandlossCtrl.js' ]);
									} ]

						}

					})
	.state('app.finance.transaction.salesinvoice', {
						abstract : true,
						templateUrl : "views/common",
						data : {
							title : 'Sales Invoice Report'
						}
					})
							// Sales Invoice
					.state(
							'app.finance.transaction.salesinvoice.search',
							{
								url : '/reports/salesinvoice/search',
								data : {
									title : 'Search'
								},
								controller : 'salesinvoiceCtrl',
								templateUrl : '/views/finance/transaction/SalesInvoiceSearch',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/finance/transaction/SalesInvoiceCtrl.js' ])
											} ]
								}
							})
							
						.state('app.finance.transaction.purchaseinvoice', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Purchase Report'
				}
			})
					// purchase report
			.state(
					'app.finance.transaction.purchaseinvoice.search',
					{
						url : '/reports/purchaseinvoice/search',
						data : {
							title : 'Search'
						},
						controller : 'purchaseCtrl',
						templateUrl : '/views/finance/transaction/PurchaseInvoiceSearch',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/PurchaseInvoiceCtrl.js' ])
									} ]
						}
					})
					.state('app.finance.transaction.gST', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'GST report'
				}
			})
			.state(
					'app.finance.transaction.gST.search',
					{
						url : '/reports/gst/search',
						data : {
							title : 'Search'
						},
						controller : 'gstReportCtrl',
						templateUrl : 'views/finance/transaction/gstReport',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/gstReportCtrl.js' ])
									} ]
						}
					})
					.state('app.finance.transaction.TDS', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'TDS report'
				}
			})
			.state(
					'app.finance.transaction.TDS.list',
					{
						url : '/reports/tds/tdsReportList',
						data : {
							title : 'Search'
						},
						controller : 'tdsReportController',
						templateUrl : 'views/finance/transaction/TDSReportList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/TDSReportList.js' ])
									} ]
						}
					})
			// for cash book

			.state(
					'app.finance.reports.financial.cashBook',
					{
						url : '/finance/reports/financial/cashBook',
						data : {
							title : 'Cash Book'
						},

						controller : 'cashBookCtrl',
						templateUrl : 'views/reports/finance/cashBook',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/reports/finance/cashBook.js' ]);
									} ]

						}
					})

			// for journal book

			.state(
					'app.finance.reports.financial.journalBook',
					{
						url : '/finance/reports/financial/journalBook',
						data : {
							title : 'Journal Book'
						},

						controller : 'journalBookCtrl',
						templateUrl : 'views/reports/finance/journalBook',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/reports/finance/journalBook.js' ]);
									} ]

						}
					})

			// for bank book

			.state(
					'app.finance.reports.financial.bankBook',
					{
						url : '/finance/reports/financial/bankBook',
						data : {
							title : 'Bank Book'
						},
						controller : 'BankBookCtrl',
						templateUrl : 'views/reports/finance/BankBook',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/reports/finance/BankBook.js' ]);
									} ]

						}
					})

	$stateProvider
			.state('app.mis.schedule', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Schedule'
				}
			})

			// loans and advances
			.state(
					'app.mis.schedule.loansandadvances',
					{
						url : '/reports/schedule/loansandadvances',
						data : {
							title : 'Loans and Advances'
						},
						controller : 'loansAndAdvancesController',
						templateUrl : 'views/reports/schedule/loansandadvances',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/reports/schedule/loansandadvancesCtrl.js' ]);
									} ]

						}

					})

			// for general ledger

			.state(
					'app.finance.reports.financial.balancesheet',
					{
						url : '/reports/finance/balancesheet',
						data : {
							title : 'Balance Sheet'
						},

						controller : 'balanceSheetController',
						templateUrl : 'views/reports/finance/balanceSheet',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/reports/finance/balanceSheetCtrl.js' ]);
									} ]

						}

					})

			// for general ledger

			.state(
					'app.reports.finance.generalLedger',
					{
						url : '/reports/finance/generalLedger',
						data : {
							title : 'General Ledger'
						},

						controller : 'generalLedgerController',
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

			.state(
					'app.finance.transaction.CNRequest',
					{
						url : '/reports/finance/CNRequest',
						data : {
							title : 'CN Request'
						},

						controller : 'CNRequestCtrl',
						templateUrl : 'views/reports/finance/CNRequest',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/reports/finance/corgCustomerWiseCtrl.js' ]);
									} ]

						}

					})

			.state(
					'app.finance.transaction.CNRequestAdd',
					{
						url : '/reports/finance/CNRequestAdd',
						data : {
							title : 'CN Request Add'
						},

						controller : 'CNRequestAddCtrl',
						templateUrl : 'views/reports/finance/CNRequestAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/reports/finance/corgCustomerWiseCtrl.js' ]);
									} ]

						}
					})
			.state(
					'app.finance.transaction.CNRequestView',
					{
						url : '/reports/finance/CNRequestView/:cnReq',
						data : {
							title : 'CN Request View'
						},

						controller : 'CNRequestViewCtrl',
						templateUrl : 'views/reports/finance/CNRequestView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/reports/finance/corgCustomerWiseCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.finance.transaction.CNRequestEdit',
					{
						url : '/reports/finance/CNRequestEdit/:cnReq',
						data : {
							title : 'CN Request Edit'
						},

						controller : 'CNRequestViewCtrl',
						templateUrl : 'views/reports/finance/CNRequestAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/reports/finance/corgCustomerWiseCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.finance.transaction/CNRequestApprove',
					{
						url : '/reports/finance/CNRequestApprove/:cnReq',
						data : {
							title : 'CN Request Approve'
						},

						controller : 'CNRequestApproveCtrl',
						templateUrl : 'views/reports/finance/CNRequestApprove',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/reports/finance/corgCustomerWiseCtrl.js' ])
									} ]
						}

					})
			// code added for sub ledger report

			.state(
					'app.finance.reports.financial.subLedger',
					{
						url : '/finance/reports/financial/subLedger',
						data : {
							title : 'Sub Ledger'
						},

						controller : 'subLedgerController',
						templateUrl : 'views/reports/finance/subLedger',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/reports/finance/subLedger.js' ]);
									} ]

						}
					})
					
					

			// code added for Staff ledger report

			.state(
					'app.finance.reports.financial.staffLedger',
					{
						url : '/finance/reports/financial/staffLedger',
						data : {
							title : 'Staff Ledger'
						},

						controller : 'staffLedgerController',
						templateUrl : 'views/reports/finance/staffLedger',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/reports/finance/staffLedger.js' ]);
									} ]

						}
					})

			.state(
					'app.reports.finance.staffLedgerEmpStatus',
					{
						url : '/finance/reports/financial/staffLedgerEmpStatus/:company/:employee/:status',
						data : {
							title : 'Staff Ledger Employee Status'
						},
						
					
								controller : 'staffLedgerEmpStatusController',
								templateUrl : 'views/reports/finance/staffLedgerEmpStatus',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/reports/finance/staffLedger.js' ]);
											} ]

								}
						
						
					})

			// code added for CORG report

			.state(
					'app.reports.finance.corg',
					{
						url : '/reports/finance/corg',
						data : {
							title : 'CORG'
						},
						views : {
							"content@app" : {
								controller : 'corgCtrl',
								templateUrl : 'views/reports/finance/corg',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/reports/finance/corgCtrl.js' ]);
											} ]

								}
							}
						}
					})

			// code added for customer card report

			.state(
					'app.reports.finance.corgCustomerWise',
					{
						url : '/reports/finance/corgCustomerWise',
						data : {
							title : 'Customer Card'
						},

						controller : 'corgCustomerWiseCtrl',
						templateUrl : 'views/reports/finance/corgCustomerWise',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/reports/finance/corgCustomerWiseCtrl.js' ]);
									} ]

						}
					})

			// supplier card
			.state(
					'app.finance.reports.financial.supplierCard',
					{
						url : '/finance/reports/financial/supplierCard',
						data : {
							title : 'Supplier Card'
						},

						controller : 'supplierCardCtrl',
						templateUrl : 'views/reports/finance/supplierCard',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/reports/finance/corgCustomerWiseCtrl.js' ]);
									} ]

						}
					})

			// supplier card
			.state(
					'app.reports.finance.rebillSummary',
					{
						url : '/reports/finance/rebillSummary',
						data : {
							title : 'Rebill Card'
						},
						controller : 'rebillSummaryCtrl',
						templateUrl : 'views/reports/finance/rebillSummary',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/reports/finance/corgCustomerWiseCtrl.js' ]);
									} ]

						}

					})

			// cash flow statement

			.state(
					'app.finance.reports.financial.cashFlowStatement',
					{
						url : '.finance/reports/financial/cashFlowStatement',
						data : {
							title : 'Cash Flow Statement'
						},

						controller : 'cashflowStatementController',
						templateUrl : 'views/reports/finance/cashFlowStatement',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/reports/finance/cashFlowStatementCtrl.js' ]);
									} ]

						}
					})

			// Payable Agewise

			.state(
					'app.finance.reports.financial.payableAgewise',
					{
						url : '/finance/reports/financial/payableAgewise',
						data : {
							title : 'Payable Agewise'
						},

						controller : 'payableAgewiseCtrl',
						templateUrl : 'views/reports/finance/payableAgeWise',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/reports/finance/payableAgewiseCtrl.js' ]);
									} ]

						}
					})

			// Receivable Agewise

			.state(
					'app.finance.reports.financial.receivableAgewise',
					{
						url : '/finance/reports/financial/receivableAgewise',
						data : {
							title : 'Receivable Agewise'
						},
						controller : 'receivableAgewiseCtrl',
						templateUrl : 'views/reports/finance/receivableAgewise',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/reports/finance/receivableAgewiseCtrl.js' ]);
									} ]

						}
					})
			.state(
					'app.reports.finance.receivableAgewise-entry',
					{
						url : '/reports/finance/receivableAgewise/entry',
						data : {
							title : 'Receivable Agewise Entry'
						},
						controller : 'receivableAgewiseEntryCtrl',
						templateUrl : 'views/reports/finance/receivableAgewiseEntry',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/reports/finance/receivableAgewiseCtrl.js' ]);
									} ]

						}
					})

			.state(
					'app.reports.quantity.rate',
					{
						url : '/reports/qtyRateReport',
						data : {
							title : 'Qty Vs Rate'
						},
						views : {
							"content@app" : {
								controller : 'qtyRateReportCtrl',
								templateUrl : 'views/reports/sales/qtyRateReport',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/reports/sales/qtyRateReportCtrl.js' ]);
											} ]

								}
							}
						}
					})

			.state(
					'app.reports.quantity.ContainerInvoice',
					{
						url : '/reports/containerInvoiceReport',
						data : {
							title : 'Invoice Vs Container'
						},
						views : {
							"content@app" : {
								controller : 'containerInvoiceCtrl',
								templateUrl : 'views/reports/sales/containerInvoiceReport',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/reports/sales/containerInvoiceCtrl.js' ]);
											} ]

								}
							}
						}
					})

			.state(
					'app.reports.csr.ssfvol',
					{
						url : '/csr/ssfvol',
						data : {
							title : 'SSF VOL'
						},
						views : {
							"content@app" : {
								controller : 'ssfVolCtrl',
								templateUrl : 'views/reports/csr/ssfVol',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/reports/csr/ssfVolCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.reports.csr.ssftsmoves',
					{
						url : '/csr/ssftsmoves',
						data : {
							title : 'SSF T/S Moves'
						},
						views : {
							"content@app" : {
								controller : 'ssfTsMovesCtrl',
								templateUrl : 'views/reports/csr/ssfTsMoves',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/reports/csr/ssfTsMovesCtrl.js' ]);
											} ]
								}
							}
						}
					})
			.state(
					'app.reports.csr.catabcshare',
					{
						url : '/csr/catABCShare',
						data : {
							title : 'CAT ABC SHARE'
						},
						views : {
							"content@app" : {
								controller : 'catABCShareCtrl',
								templateUrl : 'views/reports/csr/catABCShare',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/reports/csr/catABCShare.js' ]);
											} ]
								}
							}
						}
					})
			.state(
					'app.reports.csr.volume',
					{
						url : '/csr/volume',
						data : {
							title : 'BALAJI/PAY/PERMA VOLUMES (JV AREAS)'
						},
						views : {
							"content@app" : {
								controller : 'volumesCtrl',
								templateUrl : 'views/reports/csr/volumes',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/reports/csr/volumes.js' ]);
											} ]
								}
							}
						}
					})
			.state(
					'app.reports.csr.toptennvomlo',
					{
						url : '/csr/toptennvomlo',
						data : {
							title : 'TOP 10 NVO AND MLO'
						},
						views : {
							"content@app" : {
								controller : 'topTenNvoMloCtrl',
								templateUrl : 'views/reports/csr/topTenNvoMlo',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/reports/csr/topTenNvoMloCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.reports.csr.avgWeigthPerTeu',
					{
						url : '/csr/avgweightperteu',
						data : {
							title : 'AVERAGE WEIGHT PER TEU'
						},
						views : {
							"content@app" : {
								controller : 'avgWeightPerTeuCtrl',
								templateUrl : 'views/reports/csr/avgWeightPerTeu',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/reports/csr/avgWeightPerTeuCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.reports.csr.thirdPartyLoadings',
					{
						url : '/csr/thirdpartyloadings',
						data : {
							title : 'THIRD PARTY LOADINGS'
						},
						views : {
							"content@app" : {
								controller : 'thirdPartyLoadingCtrl',
								templateUrl : 'views/reports/csr/thirdPartyLoading',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/reports/csr/thirdPartyLoadingCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.reports.finance.ssf',
					{
						url : '/reports/ssf',
						data : {
							title : 'Ssf Report pie Chart'
						},
						views : {
							"content@app" : {
								controller : 'ssfreportCtrl',
								templateUrl : 'views/reports/finance/ssfreport',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/reports/finance/ssfReportCtrl.js' ]);
											} ]

								}
							}
						}
					})

			.state(
					'app.reports.csr.ialvol',
					{
						url : '/csr/ialvol',
						data : {
							title : 'IAL VOL'
						},
						views : {
							"content@app" : {
								controller : 'ialVolCtrl',
								templateUrl : 'views/reports/csr/ialVol',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/reports/csr/ialVolCtrl.js' ]);
											} ]
								}
							}
						}
					})
			.state(
					'app.reports.csr.topFifteenCust',
					{
						url : '/csr/topFifteenCust',
						data : {
							title : 'TOP 15 CUSTOMER'
						},
						views : {
							"content@app" : {
								controller : 'topFifteenCustCtrl',
								templateUrl : 'views/reports/csr/topFifteenCust',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/reports/csr/topFifteenCustCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.reports.csr.transasiaVolTrend',
					{
						url : '/csr/transasiaVolTrend',
						data : {
							title : 'TRANSASIA VOL TREND'
						},
						views : {
							"content@app" : {
								controller : 'transasiaVolTrendCtrl',
								templateUrl : 'views/reports/csr/transasiaVolTrend',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/reports/csr/transasiaVolTrendCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.reports.csr.ssfShares',
					{
						url : '/csr/ssfShares',
						data : {
							title : 'SSF SHARES IN JV'
						},
						views : {
							"content@app" : {
								controller : 'ssfShareCtrl',
								templateUrl : 'views/reports/csr/ssfShares',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/reports/csr/ssfShareCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.reports.digital.view',
					{
						url : '/digitalLibrary/View',
						data : {
							title : 'Digital Library'
						},
						views : {
							"content@app" : {
								controller : 'digitalLibCtrl',
								templateUrl : 'views/Digital/digitalLibView',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/digitalLib/digitalLibCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.reports.voyagepl',
					{
						url : '/reports/voyagepl',
						data : {
							title : 'Voyage P & L'
						},
						views : {
							"content@app" : {
								controller : 'voyagePLCtrl',
								templateUrl : 'views/reports/sales/VoyagePl',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/reports/sales/voyagePl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.reports.reportBuilder',
					{
						url : '/reports/reportBuilder',
						data : {
							title : 'Report Builder'
						},
						views : {
							"content@app" : {
								controller : 'reportBuilderCtrl',
								templateUrl : 'views/reports/sales/reportBuilder',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/reports/sales/reportBuilder.js' ]);
											} ]

								}
							}
						}
					})

			.state(
					'app.reports.salesRpt',
					{
						url : '/reports/salesRpt',
						data : {
							title : 'Sales Report'
						},
						views : {
							"content@app" : {
								controller : 'salesRptCtrl',
								templateUrl : 'views/reports/sales/salesRpt',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/reports/sales/salesRpt.js' ]);
											} ]

								}
							}
						}
					})

			.state(
					'app.reports.sailings',
					{
						url : '/reports/sailings',
						data : {
							title : 'Sailings Report'
						},
						views : {
							"content@app" : {
								controller : 'sailingsReportCtrl',
								templateUrl : 'views/reports/sailingsReport',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/reports/sailingReportCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.activities',
					{
						url : '/salesReport/activities',
						data : {
							title : 'Activities'
						},
						views : {
							"content@app" : {
								controller : 'activitiesCtrl',
								templateUrl : 'views/reports/sales/activities',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/salesReport/salesReportCtrl.js' ]);
											} ]
								}
							}
						}
					})
			.state(
					'app.salesmarketing.paPerformance',
					{
						url : '/salesReport/PAPerformance',
						data : {
							title : 'P/A Performance'
						},
						views : {
							"content@app" : {
								controller : 'PAPerformanceCtrl',
								templateUrl : 'views/reports/sales/PAPerformance',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/salesReport/salesReportCtrl.js' ]);
											} ]
								}
							}
						}
					})
			.state(
					'app.salesmarketing.costOfVoyage',
					{
						url : '/salesReport/costOfVoyage',
						data : {
							title : 'Cost Of Voyage'
						},
						views : {
							"content@app" : {
								controller : 'costOfVoyageCtrl',
								templateUrl : 'views/reports/sales/costOfVoyage',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/salesReport/salesReportCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.punctuality',
					{
						url : '/salesReport/punctuality',
						data : {
							title : 'Punctuality'
						},
						views : {
							"content@app" : {
								controller : 'punctualityCtrl',
								templateUrl : 'views/reports/sales/punctuality',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/salesReport/salesReportCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.cost',
					{
						url : '/salesReport/cost',
						data : {
							title : 'Cost'
						},
						views : {
							"content@app" : {
								controller : 'costCtrl',
								templateUrl : 'views/reports/sales/cost',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/salesReport/salesReportCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.performance',
					{
						url : '/salesReport/performance',
						data : {
							title : 'Performance'
						},
						views : {
							"content@app" : {
								controller : 'performanceCtrl',
								templateUrl : 'views/reports/sales/performance',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/salesReport/salesReportCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.sales',
					{
						url : '/salesReport/sales',
						data : {
							title : 'Sales'
						},
						views : {
							"content@app" : {
								controller : 'salesCtrl',
								templateUrl : 'views/reports/sales/sales',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/salesReport/salesReport2ctrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.systemupdates',
					{
						url : '/salesReport/systemupdates',
						data : {
							title : 'System Updates'
						},
						views : {
							"content@app" : {
								controller : 'systemUpdateCtrl',
								templateUrl : 'views/reports/sales/systemUpdates',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/salesReport/salesReport2ctrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.scoring',
					{
						url : '/salesReport/scoring',
						data : {
							title : 'Scoring'
						},
						views : {
							"content@app" : {
								controller : 'scoringCtrl',
								templateUrl : 'views/reports/sales/scoring',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/salesReport/salesReport2ctrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.teus',
					{
						url : '/salesReport/teus',
						data : {
							title : 'TEUS'
						},
						views : {
							"content@app" : {
								controller : 'teusCtrl',
								templateUrl : 'views/reports/sales/teus',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/salesReport/salesReport2ctrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.milaha',
					{
						url : '/salesReport/utilizationreport',
						data : {
							title : 'Utilization Reports'
						},
						views : {
							"content@app" : {
								controller : 'milahaCtrl',
								templateUrl : 'views/reports/sales/milaha',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/salesReport/salesReport2ctrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.summaryReport',
					{
						url : '/salesReport/summaryReport',
						data : {
							title : 'Summary Report'
						},
						views : {
							"content@app" : {
								controller : 'summaryReportCtrl',
								templateUrl : 'views/reports/sales/summaryReport',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/salesReport/summaryReportCtrl.js' ]);
											} ]
								}
							}
						}
					})
			.state(
					'app.salesmarketing.wwwReport',
					{
						url : '/salesReport/wwwReport',
						data : {
							title : 'WWW Report'
						},
						views : {
							"content@app" : {
								controller : 'WWWReportCtrl',
								templateUrl : 'views/reports/sales/WWWReport',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/salesReport/WWWReportCtrl.js' ]);
											} ]
								}
							}
						}
					})
			.state(
					'app.salesmarketing.wwwReport.list',
					{
						url : '/salesReport/wwwReport/definetimeline',
						data : {
							title : 'WWW Report'
						},
						views : {
							"content@app" : {
								controller : 'WWWReportTimelineCtrl',
								templateUrl : 'views/reports/sales/WWWReportTimeline',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/salesReport/WWWReportCtrl.js' ]);
											} ]
								}
							}
						}
					})
			.state(
					'app.reports.freightReport',
					{
						url : '/reports/freightReport',
						data : {
							title : 'Freight Report'
						},
						views : {
							"content@app" : {
								controller : 'freightreportCtrl',
								templateUrl : 'views/reports/sales/freightReport',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/reports/sales/freightReport.js' ]);
											} ]

								}
							}
						}
					})

			.state(
					'app.reports.transReport',
					{
						url : '/reports/transReport',
						data : {
							title : 'T/S Report'
						},
						views : {
							"content@app" : {
								controller : 'transReportCtrl',
								templateUrl : 'views/reports/mis/transreport',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/reports/mis/transreport.js' ]);
											} ]

								}
							}
						}
					})

			.state(
					'app.reports.csr.customerrateavailability',
					{
						url : '/mis/customerrateavailability',
						data : {
							title : 'Customer Rate Availability'
						},
						views : {
							"content@app" : {
								controller : 'customerRateAvailableCtrl',
								templateUrl : 'views/reports/csr/customerRateAvailable/customerRateAvailability',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/reports/customerRateAvailablility/customerRateAvailabilityCtrl.js' ]);
											} ]

								}
							}
						}
					})

			// for Invoice Information

			.state(
					'app.finance.reports.financial.invoiceInformation',
					{
						url : '/finance/reports/financial/invoiceInformation',
						data : {
							title : 'Invoice Information'
						},

						controller : 'invoiceInformationController',
						templateUrl : 'views/reports/finance/invoiceInformation',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/reports/finance/invoiceInformationCtrl.js' ]);
									} ]

						}
					})

			// for Income and Expenditure

			.state(
					'app.reports.finance.cashflowfinance',
					{
						url : '/reports/finance/cashflowfinance',
						data : {
							title : 'Cash Flow'
						},

						controller : 'cashflowController',
						templateUrl : 'views/reports/finance/cashflowfinance',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/reports/finance/cashflowfinanceCtrl.js' ]);
									} ]

						}
					})

			.state(
					'app.finance.reports.financial.budgetactuals',
					{
						url : '/finance/reports/financial/budgetactuals',
						data : {
							title : 'Budget Vs Actuals(FI)'
						},

						controller : 'vbBudgetActualsCtrl',
						templateUrl : 'views/finance/reports/vesselBudgetActualsList',
						resolve : {

							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/reports/finance/vesselBudgetActualsCtrl.js' ]);
									} ]

						}
					})

			.state(
					'app.finance.reports.financial.budgetactuals.view',
					{
						url : '/reports/finance/budgetactuals/view/:vesselName/:fromDate/:toDate',
						data : {
							title : 'View'
						},

						controller : 'vbBudgetActualsViewCtrl',
						templateUrl : 'views/finance/reports/vesselBudgetActualsView',
						resolve : {

							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/reports/finance/vesselBudgetActualsCtrl.js' ]);
									} ]

						}
					})
			.state(
					'app.finance.reports.financial.budgetactuals.export',
					{
						url : '/reports/finance/budgetactuals/export',
						data : {
							title : 'Export'
						},

						controller : 'vbBudgetActualsExportCtrl',
						templateUrl : 'views/finance/reports/vesselBudgetActualsFileDownload',
						resolve : {

							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/reports/finance/vesselBudgetActualsCtrl.js' ]);
									} ]

						}
					})

			.state(
					'app.reports.util.vesselperf',
					{
						url : '/reports/vesselperf',
						data : {
							title : 'Vessel Performance'
						},
						views : {
							"content@app" : {
								controller : 'vesselPerformanceCtrl',
								templateUrl : 'views/reports/mis/VesselPerformance',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/reports/mis/utilization.js' ]);
											} ]

								}
							}
						}
					})

			.state(
					'app.reports.util.voyageperf',
					{
						url : '/reports/voyageperf',
						data : {
							title : 'Voyage Performance'
						},
						views : {
							"content@app" : {
								controller : 'voyagePerformanceCtrl',
								templateUrl : 'views/reports/mis/VoyagePerformance',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/reports/mis/utilization.js' ]);
											} ]

								}
							}
						}
					})

			.state(
					'app.reports.util.vesselutil',
					{
						url : '/reports/vesselutil',
						data : {
							title : 'Vessel Utilization'
						},
						views : {
							"content@app" : {
								controller : 'vesselUtilizationCtrl',
								templateUrl : 'views/reports/mis/VesselUtilization',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/reports/mis/utilization.js' ]);
											} ]

								}
							}
						}
					})

			.state(
					'app.reports.finance.financereport',
					{
						url : '/reports/finance/financereport',
						data : {
							title : 'Finance Report'
						},

						controller : 'financereportCtrl',
						templateUrl : 'views/reports/finance/financereport',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/reports/finance/financereportCtrl.js' ]);
									} ]

						}
					})
			.state(
					'app.salesmarketing.kycdetails',
					{
						url : '/salesReport/kycdetail',
						data : {
							title : 'KYC DETAIL'
						},
						views : {
							"content@app" : {
								controller : 'kycdetailCtrl',
								templateUrl : 'views/reports/mis/kycdetail',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/reports/mis/kycdetail.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.pricing.quotation',
					{
						url : '/quotation/list',
						data : {
							title : 'Quotation'
						},
						views : {
							"content@app" : {
								controller : 'QuotationListCtrl',
								templateUrl : 'views/salesmarketing/pricing/quotation/quotationList',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/quotationCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.pricing.quotationAdd',
					{
						url : '/quotation/add',
						data : {
							title : 'Quotation'
						},
						views : {
							"content@app" : {
								controller : 'QuotationAddSeleCtrl',
								templateUrl : 'views/salesmarketing/pricing/quotation/quotationAdd',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/quotationCtrl.js' ]);
											} ]
								}
							}
						}
					})
			.state(
					'app.salesmarketing.pricing.quotationview',
					{
						url : '/quotation/view/:quotationNo',
						data : {
							title : 'Quotation'
						},
						views : {
							"content@app" : {
								controller : 'QuotationViewCtrl',
								templateUrl : 'views/salesmarketing/pricing/quotation/quotationView',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/quotationCtrl.js' ]);
											} ]
								}
							}
						}
					})
			.state(
					'app.salesmarketing.pricing.quotationedit',
					{
						url : '/quotation/edit/:quotationNo',
						data : {
							title : 'Quotation'
						},
						views : {
							"content@app" : {
								controller : 'QuotationAddSeleCtrl',
								templateUrl : 'views/salesmarketing/pricing/quotation/quotationAdd',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/quotationCtrl.js' ]);
											} ]
								}
							}
						}
					})
			.state(
					'app.salesmarketing.pricing.griSearch',
					{
						url : '/gri/search',
						data : {
							title : 'GRI'
						},
						views : {
							"content@app" : {
								controller : 'GRISearchCtrl',
								templateUrl : 'views/salesmarketing/pricing/generalRateIncrease/griSearch',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/griCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.pricing.griSubmit',
					{
						url : '/gri/submit',
						data : {
							title : 'GRI'
						},
						views : {
							"content@app" : {
								controller : 'GRISubmitCtrl',
								templateUrl : 'views/salesmarketing/pricing/generalRateIncrease/griSubmit',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/griCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.pricing.modifyQuotSurchargeSearch',
					{
						url : '/modifyQuotSurcharge/search',
						data : {
							title : 'Modify Quot Surcharge'
						},
						views : {
							"content@app" : {
								controller : 'ModifyQuotSurchargeSearchCtrl',
								templateUrl : 'views/salesmarketing/pricing/modifyQuotSurcharge/modifyQuotSurchargeSearch',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/modifyQuotSurchargeCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.pricing.modifyQuotSurchargeInsert',
					{
						url : '/modifyQuotSurcharge/insert',
						data : {
							title : 'Modify Quot Surcharge'
						},
						views : {
							"content@app" : {
								controller : 'ModifyQuotSurchargeInsertCtrl',
								templateUrl : 'views/salesmarketing/pricing/modifyQuotSurcharge/modifyQuotSurchargeSubmit',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/modifyQuotSurchargeCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.pricing.modifyQuotSurchargeModify',
					{
						url : '/modifyQuotSurcharge/modify',
						data : {
							title : 'Modify Quot Surcharge'
						},
						views : {
							"content@app" : {
								controller : 'ModifyQuotSurchargeModifyCtrl',
								templateUrl : 'views/salesmarketing/pricing/modifyQuotSurcharge/modifyQuotSurchargeSubmit',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/modifyQuotSurchargeCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.edi.ediTemplate',
					{
						url : '/EDI/List',
						data : {
							title : 'EDI Template'
						},
						views : {
							"content@app" : {
								controller : 'EDITemplateListCtrl',
								templateUrl : 'views/edi/ediList',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/ediTemplate.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.edi.ediTemplateAdd',
					{
						url : '/EDI/Add',
						data : {
							title : 'EDI Template'
						},
						views : {
							"content@app" : {
								controller : 'EDITemplateAddCtrl',
								templateUrl : 'views/edi/ediAdd',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/ediTemplate.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.edi.ediTemplateEdit',
					{
						url : '/EDI/Edit/:id',
						data : {
							title : 'EDI Template'
						},
						views : {
							"content@app" : {
								controller : 'EDITemplateEditCtrl',
								templateUrl : 'views/edi/ediAdd',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/ediTemplate.js' ]);
											} ]
								}
							}
						}
					})
			.state(
					'app.edi.ediTemplateGeneration',
					{
						url : '/EDI/input/:id',
						data : {
							title : 'EDI Template'
						},
						views : {
							"content@app" : {
								controller : 'GenerateEdiTemplateController',
								templateUrl : 'views/edi/ediGeneration',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/ediTemplate.js' ]);
											} ]
								}
							}
						}
					})
			.state(
					'app.salesmarketing.pricing.flsQuotesReport',
					{
						url : '/flsQuotesReport/search',
						data : {
							title : 'FLS Quotes Report'
						},
						views : {
							"content@app" : {
								controller : 'FlsQuotesReportCtrl',
								templateUrl : 'views/salesmarketing/pricing/flsQuotesReport',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/flsQuotesReportCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.pricing.quotationForMLOs',
					{
						url : '/quotationForMLOs/search',
						data : {
							title : 'Quotation For MLOs'
						},
						views : {
							"content@app" : {
								controller : 'QuotationForMLOsSearchCtrl',
								templateUrl : 'views/salesmarketing/pricing/quotationForMLOs',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/quotationForMLOsCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.pricing.purchaseQuote',
					{
						url : '/purchaseQuote/list',
						data : {
							title : 'Purchase Quote'
						},
						views : {
							"content@app" : {
								controller : 'PurchaseQuoteListCtrl',
								templateUrl : 'views/salesmarketing/pricing/purchaseQuote/purchaseQuoteList',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/purchaseQuoteCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.pricing.purchaseQuoteAdd',
					{
						url : '/purchaseQuote/add',
						data : {
							title : 'Purchase Quote'
						},
						views : {
							"content@app" : {
								controller : 'PurchaseQuoteSelAddCtrl',
								templateUrl : 'views/salesmarketing/pricing/purchaseQuote/purchaseQuoteAdd',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/purchaseQuoteCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.pricing.purchaseQuoteview',
					{
						url : '/purchaseQuote/view/:quotationNo',
						data : {
							title : 'Purchase Quote'
						},
						views : {
							"content@app" : {
								controller : 'PurchaseQuoteViewCtrl',
								templateUrl : 'views/salesmarketing/pricing/purchaseQuote/purchaseQuoteView',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/purchaseQuoteCtrl.js' ]);
											} ]
								}
							}
						}
					})
			.state(
					'app.salesmarketing.pricing.purchaseQuoteedit',
					{
						url : '/purchaseQuote/edit/:quotationNo',
						data : {
							title : 'Purchase Quote'
						},
						views : {
							"content@app" : {
								controller : 'PurchaseQuoteSelAddCtrl',
								templateUrl : 'views/salesmarketing/pricing/purchaseQuote/purchaseQuoteAdd',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/purchaseQuoteCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.pricing.swapdeclaration',
					{
						url : '/swapdeclaration/list',
						data : {
							title : 'Swap declaration'
						},
						views : {
							"content@app" : {
								controller : 'SwapdeclarationListCtrl',
								templateUrl : 'views/salesmarketing/pricing/swapdeclaration/swapdeclarationList',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/swapdeclarationCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.pricing.swapdeclarationAdd',
					{
						url : '/swapdeclaration/add',
						data : {
							title : 'Swap declaration'
						},
						views : {
							"content@app" : {
								controller : 'SwapdeclarationAddCtrl',
								templateUrl : 'views/salesmarketing/pricing/swapdeclaration/swapdeclarationAdd',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/swapdeclarationCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.pricing.swapdeclarationview',
					{
						url : '/swapdeclaration/view/:swapNo',
						data : {
							title : 'Swap declaration'
						},
						views : {
							"content@app" : {
								controller : 'SwapdeclarationViewCtrl',
								templateUrl : 'views/salesmarketing/pricing/swapdeclaration/swapdeclarationView',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/swapdeclarationCtrl.js' ]);
											} ]
								}
							}
						}
					})
			.state(
					'app.salesmarketing.pricing.swapdeclarationedit',
					{
						url : '/swapdeclaration/edit/:swapNo',
						data : {
							title : 'Swap declaration'
						},
						views : {
							"content@app" : {
								controller : 'SwapdeclarationEditCtrl',
								templateUrl : 'views/salesmarketing/pricing/swapdeclaration/swapdeclarationAdd',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/swapdeclarationCtrl.js' ]);
											} ]
								}
							}
						}
					})

			// stack casting and usage
			.state(
					'app.salesmarketing.pricing.stackcost',
					{
						url : '/stackcost/list',
						data : {
							title : 'STACK COST'
						},
						views : {
							"content@app" : {
								controller : 'stackcostCtrl',
								templateUrl : 'views/salesmarketing/pricing/stackcost/stackcostList',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/stackcostCtrl.js' ]);
											} ]
								}
							}
						}
					})

			// stack casting and usage
			.state(
					'app.salesmarketing.pricing.stackusage',
					{
						url : '/stackusage/list',
						data : {
							title : 'STACK USAGE / FICY'
						},
						views : {
							"content@app" : {
								controller : 'stackusageCtrl',
								templateUrl : 'views/salesmarketing/pricing/stackusage/stackusageList',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/stackusageCtrl.js' ]);
											} ]
								}
							}
						}
					})

			// stack casting and usage
			.state(
					'app.salesmarketing.pricing.deadFreightQuotation',
					{
						url : '/deadFreightQuotation/list',
						data : {
							title : 'Dead Freight Quotation'
						},
						views : {
							"content@app" : {
								controller : 'DeadFreightQuotationListCtrl',
								templateUrl : 'views/salesmarketing/pricing/deadFreightQuotation/deadFreightQuotationList',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/deadFreightQuotationCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.pricing.deadFreightQuotationAdd',
					{
						url : '/deadFreightQuotation/add',
						data : {
							title : 'Dead Freight Quotation'
						},
						views : {
							"content@app" : {
								controller : 'DeadFreightQuotationAddCtrl',
								templateUrl : 'views/salesmarketing/pricing/deadFreightQuotation/deadFreightQuotationAdd',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/deadFreightQuotationCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.pricing.deadFreightQuotationview',
					{
						url : '/deadFreightQuotation/view/:quotationNo',
						data : {
							title : 'Dead Freight Quotation'
						},
						views : {
							"content@app" : {
								controller : 'DeadFreightQuotationViewCtrl',
								templateUrl : 'views/salesmarketing/pricing/deadFreightQuotation/deadFreightQuotationView',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/deadFreightQuotationCtrl.js' ]);
											} ]
								}
							}
						}
					})
			.state(
					'app.salesmarketing.pricing.deadFreightQuotationedit',
					{
						url : '/deadFreightQuotation/edit/:quotationNo',
						data : {
							title : 'Dead Freight Quotation'
						},
						views : {
							"content@app" : {
								controller : 'DeadFreightQuotationAddCtrl',
								templateUrl : 'views/salesmarketing/pricing/deadFreightQuotation/deadFreightQuotationAdd',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/deadFreightQuotationCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.pricing.transquotation',
					{
						url : '/transhQuotList/list',
						data : {
							title : 'Transhipment Quotation'
						},
						views : {
							"content@app" : {
								controller : 'TransQuotListCtrl',
								templateUrl : 'views/salesmarketing/pricing/transhipmentQuotationList',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/TransQuotListCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.pricing.addtransquotation',
					{
						url : '/transhQuotList/add',
						data : {
							title : 'Transhipment Quotation'
						},
						views : {
							"content@app" : {
								controller : 'TransQuotAddCtrl',
								templateUrl : 'views/salesmarketing/pricing/transhipmentQuotationadd',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/TransQuotAddNewCtrl.js' ]);
											} ]

								}
							}
						}
					})

			.state(
					'app.salesmarketing.pricing.viewtransquotation',
					{
						url : '/transhQuotList/view/:quotation',
						data : {
							title : 'Transhipment Quotation'
						},
						views : {
							"content@app" : {
								controller : 'TransQuotViewCtrl',
								templateUrl : 'views/salesmarketing/pricing/transhipmentQuotationView',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/TransQuotViewCtrl.js' ]);
											} ]

								}
							}
						}
					})

			.state(
					'app.salesmarketing.pricing.edittransquotation',
					{
						url : '/transhQuotList/edit/:quotationId',
						data : {
							title : 'Transhipment Quotation'
						},
						views : {
							"content@app" : {
								controller : 'TransQuotAddCtrl',
								templateUrl : 'views/salesmarketing/pricing/transhipmentQuotationadd',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/TransQuotAddNewCtrl.js' ]);
											} ]
								}
							}
						}
					})

			/** ***** Rate Control Starts ******** */
			.state('app.salesmarketing.pricing.ratecontrol', {
				abstract : true,
				data : {
					title : 'Rate Control'
				}
			})

			.state(
					'app.salesmarketing.pricing.ratecontrol.ratecontrolList',
					{
						url : '/rateControlList/list',
						data : {
							title : 'Rate Control List'
						},
						views : {
							"content@app" : {
								controller : 'rateControlListCtrl',
								templateUrl : 'views/salesmarketing/pricing/rateControlList',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/rateControlListCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.pricing.ratecontrol.rateControlAdd',
					{
						url : '/rateControlList/rateControlAdd',
						data : {
							title : 'Rate Control Add'
						},
						views : {
							"content@app" : {
								controller : 'rateControlAddCtrl',
								templateUrl : 'views/salesmarketing/pricing/rateControlAdd',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/rateControlAddCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.pricing.ratecontrol.ratecontrolEdit',
					{

						url : '/rateControlList/rateControladd/edit/:rateControlCode',
						data : {
							title : 'Rate Control Edit'
						},
						views : {
							"content@app" : {
								controller : 'rateControlEditCtrl',
								templateUrl : 'views/salesmarketing/pricing/rateControlAdd',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/rateControlAddCtrl.js' ])
											} ]
								}
							}
						}
					})

			/** ***** Rate Control Ends ******** */

			.state(
					'app.salesmarketing.pricing.portTariff',
					{
						url : '/portTariffList/list',
						data : {
							title : 'Port Tariff'
						},
						views : {
							"content@app" : {
								controller : 'PortTariffListCtrl',
								templateUrl : 'views/salesmarketing/pricing/portTariffList',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/PortTariffCtrl.js' ]);
											} ]
								}
							}
						}
					})
			.state(
					'app.salesmarketing.pricing.addportTariff',
					{
						url : '/portTariffList/add',
						data : {
							title : 'Port Tariff'
						},
						views : {
							"content@app" : {
								controller : 'PortTariffAddCtrl',
								templateUrl : 'views/salesmarketing/pricing/portTariffAdd',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/PortTariffCtrl.js' ]);
											} ]
								}
							}
						}
					})
			.state(
					'app.salesmarketing.pricing.editportTariff',
					{
						url : '/portTariffList/edit/:porttariffId',
						data : {
							title : 'Port Tariff'
						},
						views : {
							"content@app" : {
								controller : 'PortTariffEditCtrl',
								templateUrl : 'views/salesmarketing/pricing/portTariffAdd',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/PortTariffCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.pricing.portTariffdetailstest',
					{
						url : '/portTariffDetails/test',
						data : {
							title : 'Port Tariff Details'
						},
						views : {
							"content@app" : {
								controller : 'PortTariffDetailTestCtrl',
								templateUrl : 'views/salesmarketing/pricing/portTariffDetailTest',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/portTariffDetailCtrl.js' ]);
											} ]
								}
							}
						}
					})
			.state(
					'app.salesmarketing.pricing.portTariffdetailstestold',
					{
						url : '/portTariffDetails/testold',
						data : {
							title : 'Port Tariff Details'
						},
						views : {
							"content@app" : {
								controller : 'PortTariffDetailTestOldCtrl',
								templateUrl : 'views/salesmarketing/pricing/portTariffDetailTest',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/portTariffDetailCtrl.js' ]);
											} ]
								}
							}
						}
					})
			.state(
					'app.salesmarketing.pricing.portTariffdetails',
					{
						url : '/portTariffDetails/add',
						data : {
							title : 'Port Tariff Details'
						},
						views : {
							"content@app" : {
								controller : 'PortTariffDetailAddCtrl',
								templateUrl : 'views/salesmarketing/pricing/portTariffDetailAdd',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/portTariffDetailCtrl.js' ]);
											} ]
								}
							}
						}
					})
			.state(
					'app.salesmarketing.pricing.portTariffdetailsList',
					{
						url : '/portTariffDetails/List',
						data : {
							title : 'Port Tariff Details'
						},
						views : {
							"content@app" : {
								controller : 'PortTariffDetailListCtrl',
								templateUrl : 'views/salesmarketing/pricing/portTariffDetailList',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/portTariffDetailCtrl.js' ]);
											} ]
								}
							}
						}
					})
			.state(
					'app.salesmarketing.pricing.portTariffdetailsedit',
					{
						url : '/portTariffDetails/edit/:tariffcode',
						data : {
							title : 'Port Tariff Details'
						},
						views : {
							"content@app" : {
								controller : 'PortTariffDetailEditCtrl',
								templateUrl : 'views/salesmarketing/pricing/portTariffDetailAdd',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/portTariffDetailCtrl.js' ]);
											} ]
								}
							}
						}
					})
			.state(
					'app.salesmarketing.pricing.mlowisequotationsearch',
					{
						url : '/mlowisequotation/search',
						data : {
							title : 'Mlo Wise Quotation'

						},
						views : {
							"content@app" : {
								controller : 'MloWiseQuotationSearchCtrl',
								templateUrl : 'views/salesmarketing/pricing/mloWiseQuotationSearch',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/mloWiseQuotationCtrl.js' ]);
											} ]
								}
							}
						}
					})
			.state(
					'app.salesmarketing.pricing.mlowisequotationview',
					{
						url : '/mlowisequotation/view',
						data : {
							title : 'Mlo Wise Quotation'

						},
						views : {
							"content@app" : {
								controller : 'MloWiseQuotationViewCtrl',
								templateUrl : 'views/salesmarketing/pricing/mloWiseQuotationView',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/mloWiseQuotationCtrl.js' ]);
											} ]
								}
							}
						}
					})

			/*
			 * Vessel Allocation Starts
			 * 
			 */

			.state(
					'app.salesmarketing.vesselallocation',
					{
						url : '/customerservicedepartment/vesselallocation',
						data : {
							title : 'Vessel Allocation List'
						},
						views : {
							"content@app" : {
								controller : 'vesselAllocationCtrl',
								templateUrl : 'views/salesmarketing/vesselallocation/vesselAllocationList',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/vesselallocation/vesselAllocationCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.vesselallocationAdd',
					{
						url : '/customerservicedepartment/vesselAllocationAdd',
						data : {
							title : 'Vessel Allocation Add'
						},
						views : {
							"content@app" : {
								controller : 'vesselAllocationAddCtrl',
								templateUrl : 'views/salesmarketing/vesselallocation/vesselAllocationAdd',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/vesselallocation/vesselAllocationAddCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.vesselallocationEdit',
					{

						url : '/customerservicedepartment/vesselAllocationadd/edit/:vesselUtilCode',
						data : {
							title : 'Edit'
						},
						views : {
							"content@app" : {
								controller : 'vesselAllocationEditCtrl',
								templateUrl : 'views/salesmarketing/vesselallocation/vesselAllocationAdd',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/vesselallocation/vesselAllocationAddCtrl.js' ])
											} ]
								}
							}
						}
					})

			/* Vessel Allocation Ends */

			.state('app.salesmarketing.bookingrequest', {
				abstract : true,
				data : {
					title : 'Booking Request'
				}
			})

			.state(
					'app.salesmarketing.bookingrequest.list',
					{
						url : '/booking/bookingrequest',
						data : {
							title : 'List'
						},
						views : {
							"content@app" : {
								controller : 'bookinglistCtrl',
								templateUrl : 'views/salesmarketing/booking/bookingRequestList',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/booking/bookingRequest.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.bookingrequest.add',
					{
						url : '/booking/bookingrequest/add',
						data : {
							title : 'Add'
						},
						views : {
							"content@app" : {
								controller : 'bookingAddCtrl',
								templateUrl : 'views/salesmarketing/booking/bookingRequestAdd',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/booking/bookingRequestAdd.js' ]);
											} ]

								}
							}
						}

					})

			.state(
					'app.salesmarketing.bookingrequest.edit',
					{
						url : '/booking/bookingrequest/edit/:bookingReqId',
						data : {
							title : 'Edit'
						},
						views : {
							"content@app" : {
								controller : 'bookingEditCtrl',
								templateUrl : 'views/salesmarketing/booking/bookingRequestAdd',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/booking/bookingRequestAdd.js' ]);
											} ]

								}
							}
						}

					})
			.state(
					'app.salesmarketing.bookingrequest.view',
					{
						url : '/booking/bookingrequest/view/:bookingReqId',
						data : {
							title : 'View'
						},
						views : {
							"content@app" : {
								controller : 'bookingViewCtrl',
								templateUrl : 'views/salesmarketing/booking/BookingRequestView',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/booking/bookingRequestAdd.js' ]);
											} ]

								}
							}
						}

					})

			.state(
					'app.salesmarketing.bookingrequest.editAdd',
					{
						url : '/booking/bookingrequest/editAdd',
						data : {
							title : 'Edit'
						},
						views : {
							"content@app" : {
								controller : 'bookingEditAddCtrl',
								templateUrl : 'views/salesmarketing/booking/bookingRequestEdit',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/booking/bookingRequestAdd.js' ]);
											} ]

								}
							}
						}

					})
			.state(
					'app.salesmarketing.bookingrequest.delete',
					{
						url : '/booking/bookingrequest/delete',
						data : {
							title : 'Delete'
						},
						views : {
							"content@app" : {
								controller : 'bookingDeleteCtrl',
								templateUrl : 'views/salesmarketing/booking/bookingRequestDelete',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/booking/bookingRequestDelete.js' ]);
											} ]

								}
							}
						}

					})

			// transhipment
			.state('app.salesmarketing.transhipmentbooking', {
				abstract : true,
				data : {
					title : 'Transhipment Booking Request'
				}
			})

			.state(
					'app.salesmarketing.transhipmentbooking.list',
					{
						url : '/booking/transhipmentrequest',
						data : {
							title : ' Transhipment Booking Request List'
						},
						views : {
							"content@app" : {
								controller : 'translistCtrl',
								templateUrl : 'views/salesmarketing/booking/transhipmentRequestList',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/booking/transhipmentRequest.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.transhipmentbooking.add',
					{
						url : '/booking/transhipmentrequest/add',
						data : {
							title : 'Add'
						},
						views : {
							"content@app" : {
								controller : 'transbookingAddCtrl',
								templateUrl : 'views/salesmarketing/booking/transhipmentRequestAdd',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/booking/transhipmentRequestAdd.js' ]);
											} ]

								}
							}
						}

					})

			.state(
					'app.salesmarketing.transhipmentbooking.edit',
					{
						url : '/booking/transhipmentrequest/edit/:bookingReqId',
						data : {
							title : 'Edit'
						},
						views : {
							"content@app" : {
								controller : 'transBookingEditCtrl',
								templateUrl : 'views/salesmarketing/booking/transhipmentRequestAdd',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/booking/transhipmentBookingrequestCtrl.js' ]);
											} ]

								}
							}
						}

					})

			.state(
					'app.salesmarketing.transhipmentbooking.view',
					{
						url : '/booking/transhipmentrequest/view/:bookingReqId',
						data : {
							title : 'View'
						},
						views : {
							"content@app" : {
								controller : 'TransbookingViewCtrl',
								templateUrl : 'views/salesmarketing/booking/TranshipmentRequestView',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/booking/transhipmentRequestAdd.js' ]);
											} ]

								}
							}
						}

					})

			.state(
					'app.salesmarketing.transhipmentbooking.editAdd',
					{
						url : '/booking/transhipmentrequest/editAdd',
						data : {
							title : 'Edit'
						},
						views : {
							"content@app" : {
								controller : 'transBookingEditAddCtrl',
								templateUrl : 'views/salesmarketing/booking/transhipmentRequestAdd',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/booking/transhipmentRequestAdd.js' ]);
											} ]

								}
							}
						}

					})

			// transhipment
			// booking summary

			.state('app.salesmarketing.bookingsummary', {
				abstract : true,
				data : {
					title : 'Booking Summary'
				}
			})

			.state(
					'app.salesmarketing.bookingsummary.search',
					{
						url : '/booking/bookingsummary/search',
						data : {
							title : 'Booking Summary'
						},
						views : {
							"content@app" : {
								controller : 'bookingsummarySearchCtrl',
								templateUrl : 'views/salesmarketing/booking/bookingSummarySearch',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/booking/bookingSummary.js' ]);
											} ]
								}
							}
						}
					})
			.state(
					'app.salesmarketing.bookingsummary.view',
					{
						url : '/booking/bookingsummary/view',
						data : {
							title : 'Booking Summary View'
						},
						views : {
							"content@app" : {
								controller : 'bookingsummaryViewCtrl',
								templateUrl : 'views/salesmarketing/booking/bookingSummaryView',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/booking/bookingSummary.js' ]);
											} ]
								}
							}
						}
					})
			// End booking summary

			// Start transhipment summary

			.state('app.salesmarketing.transhipmentbookingsummary', {
				abstract : true,
				data : {
					title : 'Transhipment Booking Summary'
				}
			})

			.state(
					'app.salesmarketing.transhipmentbookingsummary.search',
					{
						url : '/booking/transhipmentsummary/search',
						data : {
							title : ' Transhipment Booking Summary'
						},
						views : {
							"content@app" : {
								controller : 'transhipmentsummarySearchCtrl',
								templateUrl : 'views/salesmarketing/booking/transhipmentSummarySearch',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/booking/transhipmentSummary.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.transhipmentbookingsummary.view',
					{
						url : '/booking/transhipmentsummary/view',
						data : {
							title : ' Transhipment Booking Summary View'
						},
						views : {
							"content@app" : {
								controller : 'transhipmentsummaryViewCtrl',
								templateUrl : 'views/salesmarketing/booking/transhipmentSummaryView',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/booking/transhipmentSummary.js' ]);
											} ]
								}
							}
						}
					})

			// End Transhipment summary

			.state(
					'app.salesmarketing.serviceallocation',
					{
						url : '/customerservice/serviceallocation',
						data : {
							title : 'Service Allocation'
						},
						views : {
							"content@app" : {
								controller : 'serviceAllocationCtrl',
								templateUrl : 'views/salesmarketing/serviceallocation/serviceallocationList',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/serviceallocation/serviceallocationCtrl.js' ]);
											} ]
								}
							}
						}
					})
			.state(
					'app.salesmarketing.serviceallocation-Add',
					{
						url : '/customerservice/serviceallocation/add',
						data : {
							title : 'Add'
						},
						views : {
							"content@app" : {
								controller : 'serviceAllocationAddCtrl',
								templateUrl : 'views/salesmarketing/serviceallocation/serviceallocationAdd',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/serviceallocation/serviceallocationAddCtrl.js' ]);
											} ]
								}
							}
						}
					})
			.state(
					'app.salesmarketing.serviceallocation-Edit',
					{
						url : '/customerservice/serviceallocation/edit',
						data : {
							title : 'Edit'
						},
						views : {
							"content@app" : {
								controller : 'serviceAllocationAddCtrl',
								templateUrl : 'views/salesmarketing/serviceallocation/serviceallocationAdd',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/serviceallocation/serviceallocationAddCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state('app.customerservice', {
				abstract : true,
				data : {
					title : 'Customer Service'
				}
			})

			.state(
					'app.customerservice.tdrmlo',
					{
						url : '/csd/tdrmlo',
						data : {
							title : 'TDR-MLO'
						},
						views : {
							"content@app" : {
								controller : 'tdrMloCtrl',
								templateUrl : 'views/salesmarketing/csd/tdrMlo',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/csd/tdr-mlo/tdrMloCtrl.js' ]);
											} ]

								}
							}
						}

					})

			.state('app.salesmarketing.containerType', {
				abstract : true,
				data : {
					title : 'containerType'
				}
			})

			.state(
					'app.salesmarketing.containerType.cntType',
					{
						url : '/containertype/request',
						data : {
							title : 'containerTypeCtrl'
						},
						views : {
							"content@app" : {
								controller : 'containerTypeCtrl',
								templateUrl : 'views/salesmarketing/ContainerType/containerList',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/containerType/containerTypeCtrl.js' ]);
											} ]
								}

							}

						}
					})

			.state(
					'app.salesmarketing.containerType.add',
					{
						url : '/containertype/requestadd',
						data : {
							title : 'containerTypeCtrladd'
						},
						views : {
							"content@app" : {
								controller : 'containerTypeCtrlAdEd',
								templateUrl : 'views/salesmarketing/ContainerType/containerAddEdit',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/containerType/containerTypeAddEdit.js' ]);
											} ]
								}

							}

						}
					})

			.state(
					'app.salesmarketing.pricing.averagerate',
					{
						url : '/averagerate/list',
						data : {
							title : 'Average Rate Master'
						},
						views : {
							"content@app" : {
								controller : 'averagerateCtrl',
								templateUrl : 'views/salesmarketing/pricing/averagerate/averageRateList',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/averagerate/averagerateCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.pricing.averagerate-add',
					{
						url : '/pricing/averagerate/add',
						data : {
							title : 'Add'
						},
						views : {
							"content@app" : {
								controller : 'averagerateAddCtrl',
								templateUrl : 'views/salesmarketing/pricing/averagerate/averageRateAddPage',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/averagerate/averagerateAddCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.pricing.averagerate-edit',
					{
						url : '/pricing/averagerate/edit',
						data : {
							title : 'Add'
						},
						views : {
							"content@app" : {
								controller : 'averagerateEditCtrl',
								templateUrl : 'views/salesmarketing/pricing/averagerate/averageRateAddPage',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/averagerate/averagerateEditCtrl.js' ]);
											} ]
								}
							}
						}
					})

			/* Code added for Cutomer rate request form */

			.state(
					'app.salesmarketing.pricing.custRateRequest',
					{
						url : '/customerRateRequest/list',
						data : {
							title : 'Customer Rate Request'
						},
						views : {
							"content@app" : {
								controller : 'customerRateReqListCtrl',
								templateUrl : 'views/salesmarketing/pricing/customerRateRequest/customerRateRequestList',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/customerRateRequest/customerRateRequestCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.pricing.custRateRequest-add',
					{
						url : '/customerRateRequest/add',
						data : {
							title : 'Add'
						},
						views : {
							"content@app" : {
								controller : 'customerRateReqAddCtrl',
								templateUrl : 'views/salesmarketing/pricing/customerRateRequest/customerRateRequestAdd',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/customerRateRequest/customerRateRequestCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.pricing.custRateRequest-custAdd',
					{
						url : '/customerRateRequest/custAdd',
						data : {
							title : 'Add'
						},
						views : {
							"content@app" : {
								controller : 'customerRateReqCustAddCtrl',
								templateUrl : 'views/salesmarketing/pricing/customerRateRequest/customerRateRequestCustAdd',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/customerRateRequest/customerRateRequestCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.pricing.custRateRequest-edit',
					{
						url : '/customerRateRequest/edit/:quotationNo',
						data : {
							title : 'Customer Rate Request'
						},
						views : {
							"content@app" : {
								controller : 'customerRateReqCustAddCtrl',
								templateUrl : 'views/salesmarketing/pricing/customerRateRequest/customerRateRequestCustAdd',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/customerRateRequest/customerRateRequestCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.pricing.custRateRequest-view',
					{
						url : '/customerRateRequest/view/:quotationNo',
						data : {
							title : 'Customer Rate Request'
						},
						views : {
							"content@app" : {
								controller : 'customerRateReqViewCtrl',
								templateUrl : 'views/salesmarketing/pricing/customerRateRequest/customerRateRequestView',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/customerRateRequest/customerRateRequestCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.pricing.custRateRequest-resView',
					{
						url : '/customerRateRequest/resView/:quotationNo',
						data : {
							title : 'Customer Rate Request'
						},
						views : {
							"content@app" : {
								controller : 'customerResposeViewCtrl',
								templateUrl : 'views/salesmarketing/pricing/customerRateRequest/customerRateRequestView',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/customerRateRequest/customerRateRequestCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.pricing.custRateRequest-addQuotation',
					{
						url : '/customerRateRequest/addQuotation/:quotationNo',
						data : {
							title : 'Customer Rate Request'
						},
						views : {
							"content@app" : {
								controller : 'customerQuotationAddCtrl',
								templateUrl : 'views/salesmarketing/pricing/customerRateRequest/customerRateRequestAdd',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/customerRateRequest/customerRateRequestCtrl.js' ]);
											} ]
								}
							}
						}
					})
			.state(
					'app.salesmarketing.emailBankService',
					{
						url : '/customerservicedepartment/emailBankService',
						data : {
							title : 'Email Bank Service'
						},
						views : {
							"content@app" : {
								controller : 'emailBankServiceCtrl',
								templateUrl : 'views/salesmarketing/emailBank/emailBankService',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/emailBank/emailBankServiceCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.emailBankService-add',
					{
						url : '/customerservicedepartment/emailBankService/add',
						data : {
							title : 'Email Bank Service'
						},
						views : {
							"content@app" : {
								controller : 'emailBankServiceAddCtrl',
								templateUrl : 'views/salesmarketing/emailBank/emailBankServiceAdd',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/emailBank/emailBankServiceAddCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state('app.salesmarketing.customerEmails', {
				abstract : true,
				data : {
					title : 'Customer Service Department'
				}
			})

			.state(
					'app.salesmarketing.customerEmails.list',
					{
						url : '/customerservicedepartment/customerEmails',
						data : {
							title : 'Customer Emails'
						},
						views : {
							"content@app" : {
								controller : 'customerEmailsCtrl',
								templateUrl : 'views/salesmarketing/customerEmails/customerEmailsList',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/customerEmails/customerEmailsCtrl.js' ]);
											} ]
								}
							}
						}
					})
			.state(
					'app.salesmarketing.customerEmails-edit',
					{
						url : '/customerservicedepartment/customerEmails/edit',
						data : {
							title : 'Edit Customer Emails'
						},
						views : {
							"content@app" : {
								controller : 'customerEmailsEditCtrl',
								templateUrl : 'views/salesmarketing/customerEmails/customerEmailEdit',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/customerEmails/customerEmailsCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.edi.invoiceEdi',
					{
						url : '/EDI/invoiceEdi',
						data : {
							title : 'EDI'
						},
						views : {
							"content@app" : {
								controller : 'InvoiceEDICtrl',
								templateUrl : 'views/edi/InvoiceEdi',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/ediTemplate.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.edi.bapliefile',
					{
						url : '/EDI/bapliefile',
						data : {
							title : 'BAPLIE'
						},
						views : {
							"content@app" : {
								controller : 'baplieCtrl',
								templateUrl : 'views/edi/bapliefileupload',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/ediTemplate.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.shiftBooking',
					{
						url : '/booking/shiftBooking',
						data : {
							title : 'Customer Service Department Shift Booking List'
						},
						views : {
							"content@app" : {
								controller : 'shiftBookingCtrl',
								templateUrl : 'views/salesmarketing/shiftBooking/shiftBooking',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/shiftBooking/shiftBooking.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.report.vesselwiseAudreport',
					{
						url : '/reports/vesselWiseAuditorsReportSearch',
						data : {
							title : 'Vessel Wise Auditors Report'
						},
						views : {
							"content@app" : {
								controller : 'vesselWiseAuditorsReportSearchCtrl',
								templateUrl : 'views/reports/sales/vesselWiseAuditorsReportSearch',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/reports/sales/vesselWiseAuditorsReportCtrl.js' ]);
											} ]

								}
							}
						}
					})

			.state(
					'app.salesmarketing.report.vesselwiseAudreportresult',
					{
						url : '/reports/vesselWiseAuditorsReport',
						data : {
							title : 'Vessel Wise Auditors Report'
						},
						views : {
							"content@app" : {
								controller : 'vesselWiseAuditorsReportSubmitCtrl',
								templateUrl : 'views/reports/sales/vesselWiseAuditorsReport',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/reports/sales/vesselWiseAuditorsReportCtrl.js' ]);
											} ]

								}
							}
						}
					})
			.state(
					'app.salesmarketing.report.vesselwiseAudreportInvoiceresult',
					{
						url : '/reports/vesselWiseAuditorsInvoiceReport',
						data : {
							title : 'Vessel Wise Auditors Report'
						},
						views : {
							"content@app" : {
								controller : 'vesselWiseAuditorsReportInvoiceCtrl',
								templateUrl : 'views/reports/sales/vesselWiseAuditorsReportInvoice',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/reports/sales/vesselWiseAuditorsReportCtrl.js' ]);
											} ]

								}
							}
						}
					})
			.state(
					'app.edi.bapliefilecompare',
					{
						url : '/EDI/fileCompare',
						data : {
							title : 'BAPLIE & DPA COMPARE'
						},
						views : {
							"content@app" : {
								controller : 'bapliecompCtrl',
								templateUrl : 'views/edi/bapliefileCompare',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/ediTemplate.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.pricing.chargeType',
					{
						url : '/chargeType/list',
						data : {
							title : 'Charge Type Master'
						},
						views : {
							"content@app" : {
								controller : 'chargeTypeListCtrl',
								templateUrl : 'views/salesmarketing/pricing/chargetype/chargeTypeMasterList',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/chargeTypeMaster.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.pricing.chargeTypeadd',
					{
						url : '/chargeType/add',
						data : {
							title : 'Charge Type Master'
						},
						views : {
							"content@app" : {
								controller : 'chargeTypeAddCtrl',
								templateUrl : 'views/salesmarketing/pricing/chargetype/chargeTypeMasterAdd',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/chargeTypeMaster.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.pricing.chargeTypeedit',
					{
						url : '/chargeType/add/:chargeTypeId',
						data : {
							title : 'Charge Type Master'
						},
						views : {
							"content@app" : {
								controller : 'chargeTypeAddCtrl',
								templateUrl : 'views/salesmarketing/pricing/chargetype/chargeTypeMasterAdd',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/chargeTypeMaster.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.pricing.chargeTypeview',
					{
						url : '/chargeType/view/:chargeTypeId',
						data : {
							title : 'Charge Type Master'
						},
						views : {
							"content@app" : {
								controller : 'chargeTypeViewCtrl',
								templateUrl : 'views/salesmarketing/pricing/chargetype/chargeTypeMasterview',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/chargeTypeMaster.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.pricing.copytransquotation',
					{
						url : '/transhQuotList/copy/:quotationId',
						data : {
							title : 'Transhipment Quotation'
						},
						views : {
							"content@app" : {
								controller : 'TransQuotCopyCtrl',
								templateUrl : 'views/salesmarketing/pricing/transhipmentQuotationCopy',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/TransQuotAddNewCtrl.js' ]);
											} ]

								}
							}
						}
					})

			.state(
					'app.salesmarketing.pricing.quotationcopy',
					{
						url : '/quotation/copy/:quotationNo',
						data : {
							title : 'Quotation'
						},
						views : {
							"content@app" : {
								controller : 'QuotationCopyCtrl',
								templateUrl : 'views/salesmarketing/pricing/quotation/quotationCopy',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/quotationCtrl.js' ]);
											} ]
								}
							}
						}
					})
			.state(
					'app.salesmarketing.pricing.bulkmodify',
					{
						url : '/quotation/bulkmodify',
						data : {
							title : 'Quotation'
						},
						views : {
							"content@app" : {
								controller : 'QuotationBulkModifyCtrl',
								templateUrl : 'views/salesmarketing/pricing/quotation/quotationModify',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/quotationCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state('app.salesmarketing.provbookingrequest', {
				abstract : true,
				data : {
					title : 'Provisional Booking Request'
				}
			})
			.state(
					'app.salesmarketing.provbookingrequest.list',
					{
						url : '/provbooking/provbookingrequest',
						data : {
							title : 'List'
						},
						views : {
							"content@app" : {
								controller : 'provbookinglistCtrl',
								templateUrl : 'views/salesmarketing/provbooking/provbookingRequestList',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/provbooking/provbookingRequest.js' ]);
											} ]
								}
							}
						}
					})
			.state(
					'app.salesmarketing.provbookingrequest.add',
					{
						url : '/provbooking/provbookingrequest/add',
						data : {
							title : 'Add'
						},
						views : {
							"content@app" : {
								controller : 'provbookingAddCtrl',
								templateUrl : 'views/salesmarketing/provbooking/provBookingAdd',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/provbooking/provbookingRequestAdd.js' ]);
											} ]
								}
							}
						}
					})
			.state(
					'app.salesmarketing.pricing.purchaseQuotecopy',
					{
						url : '/purchaseQuote/copy/:quotationNo',
						data : {
							title : 'Purchase Quote'
						},
						views : {
							"content@app" : {
								controller : 'PurchaseQuoteCopyCtrl',
								templateUrl : 'views/salesmarketing/pricing/purchaseQuote/purchaseQuoteCopy',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/purchaseQuoteCtrl.js' ]);
											} ]
								}
							}
						}
					})

			/*
			 * .state('app.salesmarketing.provbookingrequest.edit', { url :
			 * '/provbooking/provbookingrequest/edit', data : { title : 'Edit' },
			 * views : { "content@app" : { controller : 'provbookingAddCtrl',
			 * templateUrl : 'views/salesmarketing/provbooking/provbookingAdd',
			 * resolve : { deps : [ '$ocLazyLoad', function($ocLazyLoad) {
			 * return $ocLazyLoad.load([
			 * 'js/app/salesmarketing/provbooking/provbookingRequestAdd.js' ]); } ] } } } })
			 */

			.state(
					'app.salesmarketing.pricing.bulktransquotation',
					{
						url : '/transhQuotList/bulkmodify',
						data : {
							title : 'Transhipment Quotation'
						},
						views : {
							"content@app" : {
								controller : 'TransQuotbulkmodifyCtrl',
								templateUrl : 'views/salesmarketing/pricing/transhipmentQuotationBulkmod',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/TransQuotAddNewCtrl.js' ]);
											} ]

								}
							}
						}
					})

			.state(
					'app.salesmarketing.transhipmentbooking.delete',
					{
						url : '/booking/transhipmentrequest/delete',
						data : {
							title : 'Delete T/S Assigned Voyage'
						},
						params : {

							voyage : null,
							vessel : null
						},
						views : {
							"content@app" : {
								controller : 'transassignvoyageCtrl',
								templateUrl : 'views/salesmarketing/booking/transhipmentRequestDelete',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/booking/transhipmentRequest.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.report.ratematrixreport',
					{
						url : '/reports/ratematrixreport',
						data : {
							title : 'Rate Matrix Report'
						},
						views : {
							"content@app" : {
								controller : 'ratematrixctrl',
								templateUrl : 'views/reports/sales/rateMatrixReport',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/reports/sales/rateMatrixReport.js' ]);
											} ]

								}
							}
						}
					})
			.state(
					'app.salesmarketing.pricing.quotationFmview',
					{
						url : '/quotation/FmQuoteview/:quotationNo',
						data : {
							title : 'Quotation'
						},
						views : {
							"content@app" : {
								controller : 'QuotationViewCtrl',
								templateUrl : 'views/salesmarketing/pricing/quotation/FreightManifestquotationView',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/quotationCtrl.js' ]);
											} ]
								}
							}
						}
					})
			.state(
					'app.edi.tsdatafromagent',
					{
						url : '/EDI/tsdataagencies',
						data : {
							title : 'T/S Data from Agencies'
						},
						views : {
							"content@app" : {
								controller : 'tsslotMessageCtrl',
								templateUrl : 'views/operations/report/uploadfile',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/operations/loading/tsslotMessageCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.report.pricingreport',
					{
						url : '/reports/pricingreport',
						data : {
							title : 'Pricing Report'
						},
						views : {
							"content@app" : {
								controller : 'pricingreportCtrl',
								templateUrl : 'views/reports/sales/pricingreport',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/reports/sales/pricingreport.js' ]);
											} ]

								}
							}
						}
					})

			.state(
					'app.salesmarketing.report.rateComparison',
					{
						url : '/reports/rateComparison',
						data : {
							title : 'RATE COMPARISON'
						},
						views : {
							"content@app" : {
								controller : 'rateComparisonCtrl',
								templateUrl : 'views/reports/sales/rateComparison',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/reports/sales/pricingreport.js' ]);
											} ]

								}
							}
						}
					})

			.state(
					'app.salesmarketing.report.loadingAvgReport',
					{
						url : '/reports/loadingAvgReport',
						data : {
							title : 'Loading AVG Report'
						},
						views : {
							"content@app" : {
								controller : 'loadingAvgReportCtrl',
								templateUrl : 'views/reports/sales/loadingAvgReport',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/reports/sales/loadingAvgReport.js' ]);
											} ]

								}
							}
						}
					})

			.state(
					'app.salesmarketing.report.averageRate',
					{
						url : '/reports/averageRate',
						data : {
							title : 'Average Rate'
						},
						views : {
							"content@app" : {
								controller : 'averageRateCtrl',
								templateUrl : 'views/reports/sales/averageRate',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/reports/sales/averageRate.js' ]);
											} ]

								}
							}
						}
					})

			.state(
					'app.salesmarketing.report.averageRevenue',
					{
						url : '/reports/averageRevenue',
						data : {
							title : 'Average Revenue'
						},
						views : {
							"content@app" : {
								controller : 'averageRevenueCtrl',
								templateUrl : 'views/reports/sales/averageRevenue',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/reports/sales/averageRate.js' ]);
											} ]

								}
							}
						}
					})

			.state(
					'app.salesmarketing.pricing.stackusageedit',
					{
						url : '/stackusage/add',
						data : {
							title : 'STACK USAGE'
						},
						views : {
							"content@app" : {
								controller : 'stackusageaddCtrl',
								templateUrl : 'views/salesmarketing/pricing/stackusage/stackusageAdd',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/stackusageCtrl.js' ]);
											} ]
								}
							}
						}
					})
			.state(
					'app.salesmarketing.pricing.stackusageadd',
					{
						url : '/stackusage/edit/:stackusageId',
						data : {
							title : 'STACK USAGE'
						},
						views : {
							"content@app" : {
								controller : 'stackusageaddCtrl',
								templateUrl : 'views/salesmarketing/pricing/stackusage/stackusageAdd',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/stackusageCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.pricing.stackcostedit',
					{
						url : '/stackcost/add',
						data : {
							title : 'STACK COST'
						},
						views : {
							"content@app" : {
								controller : 'stackcostaddCtrl',
								templateUrl : 'views/salesmarketing/pricing/stackcost/stackcostAdd',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/stackcostCtrl.js' ]);
											} ]
								}
							}
						}
					})
			.state(
					'app.salesmarketing.pricing.stackcostadd',
					{
						url : '/stackcost/edit/:stackcostId',
						data : {
							title : 'STACK COST'
						},
						views : {
							"content@app" : {
								controller : 'stackcostaddCtrl',
								templateUrl : 'views/salesmarketing/pricing/stackcost/stackcostAdd',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/stackcostCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.customerEmails.bookingreport',
					{
						url : '/customerservicedepartment/slotBalanceReport',
						data : {
							title : 'Slot Balance Report'
						},
						views : {
							"content@app" : {
								controller : 'bookingReportCtrl',
								templateUrl : 'views/salesmarketing/booking/BookingReport',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/booking/bookingReport.js' ]);
											} ]
								}
							}
						}
					})

			// stack casting and usage
			.state(
					'app.salesmarketing.pricing.stackclose',
					{
						url : '/stackclose/list',
						data : {
							title : 'STACK CLOSE'
						},
						views : {
							"content@app" : {
								controller : 'stackcloseCtrl',
								templateUrl : 'views/salesmarketing/pricing/stackusage/StackClose',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/stackusageCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.pricing.tscustRateRequest',
					{
						url : '/tscustRateRequest/list',
						data : {
							title : 'T/S Customer Rate Req'
						},
						views : {
							"content@app" : {
								controller : 'TransCRRListCtrl',
								templateUrl : 'views/salesmarketing/pricing/transcustomerRateRequest/transcustomerRateRequestList',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/customerRateRequest/transcustomerRateRequestCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.pricing.tscustRateRequestAdd',
					{
						url : '/tscustRateRequest/add',
						data : {
							title : 'T/S Customer Rate Req'
						},
						views : {
							"content@app" : {
								controller : 'TransCRRAddCtrl',
								templateUrl : 'views/salesmarketing/pricing/transcustomerRateRequest/transcustomerRateRequestAdd',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/customerRateRequest/transcustomerRateRequestCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.pricing.tscustRateRequestEdit',
					{
						url : '/tscustRateRequest/edit/:quotationId',
						data : {
							title : 'T/S Customer Rate Req'
						},
						views : {
							"content@app" : {
								controller : 'TransCRRAddCtrl',
								templateUrl : 'views/salesmarketing/pricing/transcustomerRateRequest/transcustomerRateRequestAdd',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/customerRateRequest/transcustomerRateRequestCtrl.js' ]);
											} ]
								}
							}
						}
					})
			.state(
					'app.salesmarketing.pricing.tscustRateRequestView',
					{
						url : '/tscustRateRequest/view/:quotation',
						data : {
							title : 'T/S Customer Rate Req'
						},
						views : {
							"content@app" : {
								controller : 'TransCRRViewCtrl',
								templateUrl : 'views/salesmarketing/pricing/transcustomerRateRequest/transcustomerRateRequestView',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/customerRateRequest/transcustomerRateRequestCtrl.js' ]);
											} ]
								}
							}
						}
					})
			.state(
					'app.salesmarketing.pricing.tscustRateRequestRes',
					{
						url : '/tscustRateRequest/viewres/:quotation',
						data : {
							title : 'T/S Customer Rate Req'
						},
						views : {
							"content@app" : {
								controller : 'transCRRResposeViewCtrl',
								templateUrl : 'views/salesmarketing/pricing/transcustomerRateRequest/transcustomerRateRequestView',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/customerRateRequest/transcustomerRateRequestCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.pricing.tscustRateRequestResQuotation',
					{
						url : '/transCustrateReq/addQuotation/:quotationId',
						data : {
							title : 'T/S Customer Rate Req'
						},
						views : {
							"content@app" : {
								controller : 'TransCRRQuotationCtrl',
								templateUrl : 'views/salesmarketing/pricing/transcustomerRateRequest/transcustomerRateRequestQuotation',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/customerRateRequest/transcustomerRateRequestCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.pricing.custRateReqBulkModi',
					{
						url : '/customerRateRequest/bulkmodified',
						data : {
							title : 'Customer Rate Req'
						},
						views : {
							"content@app" : {
								controller : 'customerRateReqBulkModifyCtrl',
								templateUrl : 'views/salesmarketing/pricing/customerRateRequest/crrBulkmod',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/customerRateRequest/customerRateRequestCtrl.js' ]);
											} ]
								}
							}
						}
					})
			.state(
					'app.salesmarketing.pricing.quotToPur',
					{
						url : '/purchaseQuote/quottopur/:quotationNo',
						data : {
							title : 'Purchase Quote'
						},
						views : {
							"content@app" : {
								controller : 'PurchaseQuoteconvertCtrl',
								templateUrl : 'views/salesmarketing/pricing/purchaseQuote/purchaseQuoteAdd',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/purchaseQuoteCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.pricing.stackcostcopy',
					{
						url : '/stackcost/copy/:stackcostId',
						data : {
							title : 'STACK COST'
						},
						views : {
							"content@app" : {
								controller : 'stackcostcopyCtrl',
								templateUrl : 'views/salesmarketing/pricing/stackcost/stackcostCopy',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/stackcostCtrl.js' ]);
											} ]
								}
							}
						}
					})

			.state(
					'app.salesmarketing.pricing.mlowiseTransquotview',
					{
						url : '/mlowiseTransquot/view',
						data : {
							title : 'Mlo Wise T/S Quotation'

						},
						views : {
							"content@app" : {
								controller : 'MloWiseTransQuotViewCtrl',
								templateUrl : 'views/salesmarketing/pricing/mloWiseTransQuotationView',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/mloWiseQuotationCtrl.js' ]);
											} ]
								}
							}
						}
					})
			.state(
					'app.salesmarketing.pricing.checkrate',
					{
						url : '/checkrate/list',
						data : {
							title : 'Check Rate'
						},
						views : {
							"content@app" : {
								controller : 'RateCheckListCtrl',
								templateUrl : 'views/salesmarketing/pricing/quotation/rateCheck',
								resolve : {

									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/pricing/rateCheckCtrl.js' ]);
											} ]
								}
							}
						}
					})
			.state(
					'app.salesmarketing.report.jvtariffreport',
					{
						url : '/reports/jvtariffreport',
						data : {
							title : 'JV Tariff Report'
						},
						views : {
							"content@app" : {
								controller : 'jvTariffreportCtrl',
								templateUrl : 'views/reports/sales/jvTariffReport',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/reports/sales/jvTariffReport.js' ]);
											} ]

								}
							}
						}
					})

			// Daily Loading Report
			.state(
					'app.mis.dailyloadingreport',
					{
						url : '/reports/dailyloadingreport',
						data : {
							title : 'Daily Loading Report'
						},
						controller : 'dailyLoadingReportCtrl',
						templateUrl : 'views/finance/reports/dailyLoadingReport',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/reports/dailyLoadingReportCtrl.js' ]);
									} ]
						}

					})

			.state(
					'app.mis.dailyVehicleReport',
					{
						url : '/reports/dailyVehicleReport',
						data : {
							title : 'BMO Report'
						},
						// views : {
						// "content@app" : {
						controller : 'dailyVehicleReportCtrl',
						templateUrl : 'views/finance/reports/dailyVehicleReport/dailyVehicleReportView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/reports/dailyVehicleReport/dailyVehicleReportView.js' ]);
									} ]

						}
					// }
					// }
					})

			.state(
					'app.finance.budget.budgetAllocation.list',
					{
						url : '/finance/budget/budgetAllocation/list',
						data : {
							title : 'List'
						},

						controller : 'budgetAllocationListCtrl',
						templateUrl : 'views/finance/budget/budgetAllocation/budgetAllocationList',

						resolve : {

							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/budget/budgetAllocation/budgetAllocationListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.finance.budget.budgetAllocation.add',
					{
						url : '/finance/budget/budgetAllocation/budgetAllocationAdd',
						data : {
							title : 'Add'
						},

						controller : 'budgetAllocationAddCtrl',
						templateUrl : 'views/finance/budget/budgetAllocation/budgetAllocationAdd',

						resolve : {

							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/budget/budgetAllocation/budgetAllocationAddCtrl.js' ]);
									} ]

						}
					})

			.state(
					'app.finance.budget.budgetApproval.list',
					{
						url : '/finance/budget/approval/list',
						data : {
							title : 'List'
						},

						controller : 'budgetApprovalListCtrl',
						templateUrl : 'views/finance/budget/budgetApproval/budgetApprovalList',

						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/budget/budgetAllocation/budgetAllocationListCtrl.js' ]);
									} ]

						}
					})

			.state(
					'app.finance.budget.budgetApproval.add',
					{
						url : '/finance/budget/budgetApproval/budgetApprovalAdd',
						data : {
							title : 'Approval'
						},

						controller : 'budgetApprovalAddCtrl',
						templateUrl : 'views/finance/budget/budgetApproval/budgetApprovalAdd',

						resolve : {

							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/budget/budgetAllocation/budgetAllocationAddCtrl.js' ]);
									} ]

						}
					})

			.state(
					'app.finance.budget.budgetApproval.view',
					{
						url : '/finance/budget/budgetAllocation/budgetAllocationView',
						data : {
							title : 'View'
						},

						controller : 'budgetApprovalAddCtrl',
						templateUrl : 'views/finance/budget/budgetAllocation/budgetAllocationView',

						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/budget/budgetAllocation/budgetAllocationAddCtrl.js' ]);
									} ]

						}
					})

			.state(
					'app.finance.budget.budgetType.list',
					{
						url : '/finance/budget/budgetType/budgetTypeList',
						data : {
							title : 'List'
						},

						controller : 'budgetTypeListCtrl',
						templateUrl : 'views/finance/budget/budgetType/budgetTypeList',

						resolve : {

							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/budget/budgetType/budgetTypeCtrl.js' ]);
									} ]

						}
					})

			.state(
					'app.finance.budget.budgetType.add',
					{
						url : '/finance/budget/budgetType/budgetTypeForm',
						data : {
							title : 'List'
						},

						controller : 'budgetTypeAddCtrl',
						templateUrl : 'views/finance/budget/budgetType/budgetTypeForm',

						resolve : {

							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/budget/budgetType/budgetTypeCtrl.js' ]);
									} ]

						}
					})

			.state(
					'app.finance.budget.budgetOverview.list',
					{
						url : '/finance/budget/budgetOverview/budgetOverviewList',
						data : {
							title : 'List'
						},

						controller : 'budgetOverviewListCtrl',
						templateUrl : 'views/finance/budget/budgetOverview/budgetOverviewList',

						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/budget/budgetOverview/budgetOverviewListCtrl.js' ]);
									} ]

						}
					})

			// Provision For Writeoff
			.state(
					'app.finance.accounts.provisionforwriteoff',
					{
						url : '/accounts/provisionforwriteoff',
						data : {
							title : 'Provision For Writeoff'
						},
						controller : 'provisionForWriteoffListCtrl',
						templateUrl : 'views/finance/accounts/provisionforwriteoff/provisionForWriteoffList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/accounts/provisionforwriteoff/provisionForWriteoffListCtrl.js' ]);
									} ]
						}

					})
			.state(
					'app.finance.accounts.provisionforwriteoff-add',
					{
						url : '/accounts/provisionforwriteoff/Add',
						data : {
							title : 'Add'
						},
						controller : 'provisionForWriteoffAddCtrl',
						templateUrl : 'views/finance/accounts/provisionforwriteoff/provisionForWriteoffAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/accounts/provisionforwriteoff/provisionForWriteoffAddCtrl.js' ]);
									} ]
						}

					})
					
					
					// Truck schedule
					
					.state(
					'app.mis.schedules.truckschedule',
					{
						url : '/reports/truckSchedule',
						data : {
							title : 'Truck Schedule'
						},
						
						controller : 'truckScheduleCtrl',
						templateUrl : 'views/finance/reports/truckSchedule/truckSchedule',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/reports/truckSchedule/truckScheduleCtrl.js' ]);
									} ]

						}
					
					})
					
					
			.state(
						'app.mis.schedules.driverschedule',
						{
							url : '/reports/driverShedule',
							data : {
								title : 'Driver Schedule'
							},
							
							controller : 'driverScheduleCtrl',
							templateUrl : 'views/finance/reports/driverSchedule/driverSchedule',
							resolve : {
								deps : [
										'$ocLazyLoad',
										function($ocLazyLoad) {
											return $ocLazyLoad
													.load([ 'js/app/finance/reports/driverSchedule/driverScheduleCtrl.js' ]);
										} ]

							}
						
						})		
						
						
						// Trip P&L
			     .state(
					'app.mis.tripp&l',
					{
						url : '/reports/tripp&l',
						data : {
							title : 'Trip P&L'
						},
						controller : 'tripP&LCtrl',
						templateUrl : 'views/finance/reports/tripP&L',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/reports/tripP&LCtrl.js' ]);
									} ]
						}

					})
					
					  .state(
					'app.mis.tripp&l-list',
					{
						url : '/reports/tripp&llist',
						data : {
							title : 'List'
						},
						controller : 'tripP&LViewCtrl',
						templateUrl : 'views/finance/reports/tripP&LView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/reports/tripP&LCtrl.js' ]);
									} ]
						}

					})
					
					.state(
					'app.finance.gST.search',
					{
						url : '/reports/gst/search',
						data : {
							title : 'Search'
						},
						controller : 'gstReportCtrl',
						templateUrl : 'views/finance/transaction/gstReport',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/gstReportCtrl.js' ])
									} ]
						}
					})
					
				
							
			.state(
					'app.finance.transaction.taxtype',
					{
						url : '/reports/taxtype',
						data : {
							title : 'Tax Type'
						},
						controller : 'taxtypeCtrl',
						templateUrl : 'views/finance/transaction/taxtype/taxtypeList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/taxtype/taxtypeCtrlList.js' ])
									} ]
						}
					})		
					
					.state(
							'app.finance.reports.financial.profitandlossjobwise',
							{
								url : '/finance/reports/financial/profitandlossjobwise',
								data : {
									title : 'Jobwise Income and Expenditure'
								},

								controller : 'profitAndLossJobwiseController',
								templateUrl : 'views/reports/finance/profitandlossjobwise',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/reports/finance/profitandlossjobwiseCtrl.js' ]);
											} ]

								}

							})
							
							// job Order sales person wise
							
							.state(
							'app.finance.reports.financial.profitandlossjobsalespersonwise',
							{
								url : '/finance/reports/financial/profitandlossjobsalespersonwise',
								data : {
									title : 'Job Sales Person Wise Income and Expenditure'
								},

								controller : 'profitAndLossJobSalesPersonwiseController',
								templateUrl : 'views/reports/finance/profitandlossjobsalespersonwise',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/reports/finance/profitandlossjobsalespersonwiseCtrl.js' ]);
											} ]

								}

							})
							
							
					/*.state('app.finance.transaction.purchaseinvoice', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Purchase Report'
				}
			})
					// purchase report
			.state(
					'app.finance.transaction.purchaseinvoice.search',
					{
						url : '/reports/purchaseinvoice/search',
						data : {
							title : 'Search'
						},
						controller : 'purchaseCtrl',
						templateUrl : '/views/finance/transaction/PurchaseInvoiceSearch',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/PurchaseInvoiceCtrl.js' ])
									} ]
						}
					})
					*/
					.state('app.finance.transaction.purchasesummary', {
						abstract : true,
						templateUrl : "views/common",
						data : {
							title : 'Purchase Summary'
						}
					})
							// purchase summary
					.state(
							'app.finance.transaction.purchasesummary.search',
							{
								url : '/reports/purchasesummary/search',
								data : {
									title : 'Search'
								},
								controller : 'purchaseSummaryCtrl',
								templateUrl : '/views/finance/transaction/PurchaseSummarySearch',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/finance/transaction/PurchaseSummaryCtrl.js' ])
											} ]
								}
							})
							
							
							/*.state('app.finance.transaction.salesinvoice', {
						abstract : true,
						templateUrl : "views/common",
						data : {
							title : 'Sales Invoice Report'
						}
					})
							// Sales Invoice
					.state(
							'app.finance.transaction.salesinvoice.search',
							{
								url : '/reports/salesinvoice/search',
								data : {
									title : 'Search'
								},
								controller : 'salesinvoiceCtrl',
								templateUrl : '/views/finance/transaction/SalesInvoiceSearch',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/finance/transaction/SalesInvoiceCtrl.js' ])
											} ]
								}
							})*/
							
							.state('app.finance.transaction.salessummary', {
						abstract : true,
						templateUrl : "views/common",
						data : {
							title : 'Sales Summary'
						}
					})
							// Sales Summary
					.state(
							'app.finance.transaction.salessummary.search',
							{
								url : '/reports/salessummary/search',
								data : {
									title : 'Search'
								},
								controller : 'salessummaryCtrl',
								templateUrl : '/views/finance/transaction/SalesSummarySearch',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/finance/transaction/SalesSummaryCtrl.js' ])
											} ]
								}
							})
							
							

							.state('app.finance.transaction.hawbreport', {
						abstract : true,
						templateUrl : "views/common",
						data : {
							title : 'HAWB Report'
						}
					})
							// HAWB Report
					.state(
							'app.finance.transaction.hawbreport.search',
							{
								url : '/reports/hawbreport/search',
								data : {
									title : 'Search'
								},
								controller : 'hawbreportCtrl',
								templateUrl : '/views/finance/transaction/HawbReportSearch',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/finance/transaction/HawbReportCtrl.js' ])
											} ]
								}
							})
							
							
							.state('app.finance.transaction.hblreport', {
								abstract : true,
								templateUrl : "views/common",
								data : {
									title : 'HBL Report'
								}
							})
									// HBL Report
							.state(
									'app.finance.transaction.hblreport.search',
									{
										url : '/reports/hblreport/search',
										data : {
											title : 'Search'
										},
										controller : 'hblreportCtrl',
										templateUrl : '/views/finance/transaction/HblReportSearch',
										resolve : {
											deps : [
													'$ocLazyLoad',
													function($ocLazyLoad) {
														return $ocLazyLoad
																.load([ 'js/app/finance/transaction/HblReportCtrl.js' ])
													} ]
										}
									})
									
							
					.state('app.finance.transaction.mblreport', {
						abstract : true,
						templateUrl : "views/common",
						data : {
							title : 'MBL Report'
						}
					})
							// MBL Report
					.state(
							'app.finance.transaction.mblreport.search',
							{
								url : '/reports/mblreport/search',
								data : {
									title : 'Search'
								},
								controller : 'mblreportCtrl',
								templateUrl : '/views/finance/transaction/MblReportSearch',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/finance/transaction/mblreportCtrl.js' ])
											} ]
								}
							})
							
							.state('app.finance.transaction.mawbreport', {
						abstract : true,
						templateUrl : "views/common",
						data : {
							title : 'MAWB Report'
						}
					})
							// MAWB Report
					.state(
							'app.finance.transaction.mawbreport.search',
							{
								url : '/reports/mawbreport/search',
								data : {
									title : 'Search'
								},
								controller : 'mawbreportCtrl',
								templateUrl : '/views/finance/transaction/MawbReportSearch',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/finance/transaction/mawbreportCtrl.js' ])
											} ]
								}
							})
							
							.state(
									'app.finance.reports.financial.generalLedgersubgroup',
									{
										url : '/reports/finance/generalLedgersubgroup',
										data : {
											title : 'General Ledger'
										},

										controller : 'generalLedgerController',
										templateUrl : 'views/reports/finance/generalLedgersubgroup',
										resolve : {
											deps : [
													'$ocLazyLoad',
													function($ocLazyLoad) {
														return $ocLazyLoad
																.load([ 'js/app/reports/finance/generalLedgerCtrl.js' ]);
													} ]

										}

									})
									
				// New window based on Accountcode
									.state(
									'app.finance.reports.financial.generalLedgeraccountgroup',
									{
										url : '/reports/finance/generalLedgeraccountgroup',
										data : {
											title : 'General Ledger'
										},

										controller : 'generalLedgerController1',
										templateUrl : 'views/reports/finance/generalLedgeraccountgroup',
										resolve : {
											deps : [
													'$ocLazyLoad',
													function($ocLazyLoad) {
														return $ocLazyLoad
																.load([ 'js/app/reports/finance/generalLedgerCtrlaccountgroup.js' ]);
													} ]

										}

									})

									
									
									
									.state(
											'app.finance.reports.intraCompanyAccountsRecords',
											{
												url : '/reports/finance/intraCompanyAccountsRecords',
												data : {
													title : 'Intra Company Accounts-Reconciliation'
												},
												controller : 'intraCompanyAccountsRecordsController',
												templateUrl : 'views/finance/reports/intraCompanyAccountsRecords',
												resolve : {
													deps : [
															'$ocLazyLoad',
															function($ocLazyLoad) {
																return $ocLazyLoad
																		.load([ 'js/app/finance/reports/intraCompanyAccountsRecordsCtrl.js' ])
															} ]

												}
											})
											
											
			// Contra- InterBanks
											
											.state('app.finance.transaction.contraInterBank', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Contra InterBank'
				}
			})
											
											
												.state(
					'app.finance.transaction.contraInterBank.list',
					{
						url : '/transaction/contraInterBank/list',
						data : {
							title : 'List'
						},
						controller : 'contraInterBankCtrl',
						templateUrl : 'views/finance/transaction/contraInterBank/contraInterBankList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/contraInterBank/contraInterBankCtrl.js' ])
									} ]
						}
					})


.state(
					'app.finance.transaction.contraInterBank.add',
					{
						url : '/transaction/contraInterBank/add',
						data : {
							title : 'Add'
						},
						controller : 'contraInterBankCtrlAdd',
						templateUrl : 'views/finance/transaction/contraInterBank/contraInterBankAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/contraInterBank/contraInterBankCtrlAdd.js' ])
									} ]
						}
					})
			.state(
					'app.finance.transaction.contraInterBank.edit',
					{
						url : '/transaction/contraInterBank/edit/:jvNumber',
						data : {
							title : 'Edit'
						},
						controller : 'contraInterBankCtrlAdd',
						templateUrl : 'views/finance/transaction/contraInterBank/contraInterBankEdit',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/contraInterBank/contraInterBankCtrlAdd.js' ])
									} ]
						}
					})

.state(
					'app.finance.transaction.contraInterBank.copyJournalVoucher',
					{
						url : '/transaction/contraInterBank/copyJournalVoucher/:jvNumber',
						data : {
							title : 'Copy'
						},
						controller : 'contraInterBankCtrlAdd',
						templateUrl : 'views/finance/transaction/contraInterBank/contraInterBankAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/contraInterBank/contraInterBankCtrlAdd.js' ])
									} ]
						}
					})
			.state(
					'app.finance.transaction.contraInterBank.view',
					{
						url : '/transaction/contraInterBank/view/:jvNumber',
						data : {
							title : 'View'
						},
						controller : 'contraInterBankViewCtrl',
						templateUrl : 'views/finance/transaction/contraInterBank/contraInterBankView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/contraInterBank/contraInterBankCtrlAdd.js' ])
									} ]
						}
					})
					// GL new screen
							.state('app.finance.transaction.generalledgerentry', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'GL Entries'
				}
			})
			.state(
					'app.finance.transaction.generalledgerentry.list',
					{
						url : '/transaction/generalledgerentry/list',
						data : {
							title : 'List'
						},

						controller : 'generalledgerentrylistCtrl',
						templateUrl : 'views/finance/transaction/generalledgerentrylist',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/generalledgerentrylistCtrl.js' ])
									} ]
						}

					})

			.state(
					'app.finance.transaction.generalledgerentry.add',
					{
						url : '/transaction/generalledgerentry/add',
						data : {
							title : 'Add'
						},

						controller : 'generalledgerentryaddCtrl',
						templateUrl : 'views/finance/transaction/generalledgerentryadd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/generalledgerentryaddCtrl.js' ])
									} ]
						}

					})
			.state(
					'app.finance.transaction.generalledgerentry.edit',
					{
						url : '/transaction/generalledgerentry/edit',
						data : {
							title : 'Edit'
						},

						controller : 'creditNoteCtrlAdd',
						templateUrl : 'views/finance/transaction/generalledgerentryedit',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/generalledgerentryaddCtrl.js'  ])
									} ]
						}

					})
					
				
							
				.state('app.finance.transaction.purchaseCredit', {
						abstract : true,
						templateUrl : "views/common",
						data : {
							title : 'purchaseCredit'
						}
					})
					
					
					.state('app.finance.transaction.purchaseCredit.list',
					{
						url : '/transaction/purchaseCredit/list',
						data : {
							title : 'List'
						},
						controller : 'ListCtrl',
						templateUrl : 'views/finance/transaction/purchaseCreditNoteList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/transaction/purchaseCreditListCtrl.js' ])
									} ]
						}

					})
							
								.state(
							'app.finance.transaction.purchaseCredit.add',
							{
								url : '/transaction/purchaseCredit/add',
								data : {
									title : 'add'
								},
								controller : 'AddCtrl',
								templateUrl : 'views/finance/transaction/purchaseCreditNoteAdd1',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/finance/transaction/purchaseCreditListCtrl.js' ])
											} ]
								}
							})
							.state(
									'app.finance.transaction.purchaseCredit.view',
									{
										url : '/transaction/purchasecredit/view',
										data : {
											title : 'Purchase Credit Note View'
										},
										controller : 'ViewCtrl',
										templateUrl : 'views/finance/transaction/purchaseCreditnewView',
										resolve : {
											deps : [
													'$ocLazyLoad',
													function($ocLazyLoad) {

														return $ocLazyLoad
																.load([ 'js/app/finance/transaction/taxtype/purchaseCreditNoteListCtrl.js' ])
													} ]

										}

									})

							.state(
									'app.finance.transaction.purchaseCredit.edit',
									{
										url : '/transaction/purchasecredit/edit',
										data : {
											title : 'Edit'
										},
										controller : 'purchaseCreditNoteAddCtrl',
										templateUrl : 'views/finance/transaction/purchaseCreditNoteAdd',
										resolve : {
											deps : [
													'$ocLazyLoad',
													function($ocLazyLoad) {

														return $ocLazyLoad
																.load([ 'js/app/finance/transaction/taxtype/purchaseCreditNoteListCtrl.js' ])
													} ]

										}

									})
									
									// sales booking 
									
									.state(
							'app.salesmarketing.salebooking.list',
							{
								url : '/list',
								data : {
									title : 'List'
								},
								templateUrl : "views/salesmarketing/booking/salesBookingList",
								controller : 'salebookingListCtrl',  
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/booking/salesBookingListCtrl.js' ]);
											} ]
								}
							})
					.state(
							'app.salesmarketing.salebooking.add',
							{
								url : '/add',
								data : {
									title : 'Add'
								},
								templateUrl : "views/salesmarketing/booking/salesBookingADD1",
								controller : 'salebookingAddCtrl',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/booking/salesBookingAddCtrl.js' ]);
											} ]
								}
							})
							.state(
							'app.salesmarketing.salebooking.Add',
							{
								url : '/Add',
								data : {
									title : 'Add'
								},
								templateUrl : "views/salesmarketing/booking/salesBookingAdd",
								controller : 'salebookingAddCtrl',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/booking/salesBookingAddCtrl.js' ]);
											} ]
								}
							})
							
					.state(
							'app.salesmarketing.salebooking.edit',
							{
								url : '/edit',
								data : {
									title : 'Edit'
								},
								templateUrl : "views/salesmarketing/booking/salesBookingAdd",
								controller : 'salebookingAddCtrl',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/booking/salesBookingAddCtrl.js' ]);
											} ]
								}
							})
							
									.state(
							'app.salesmarketing.salebooking.view',
							{
								url : '/view',
								data : {
									title : 'View'
								},
								templateUrl : "views/salesmarketing/booking/salesBookingView",
								controller : 'salebookingAddCtrl',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/salesmarketing/booking/salesBookingAddCtrl.js' ]);
											} ]
								}
							})
									//sales booking end

							//Freight
							
							.state('app.finance.invoice.freightinvoice',
									{
						url : '/invoice/freightinvoice/list',
						data : {
							title : 'Freight Invoice List'
						},
						controller : 'freightListCtrl',
						templateUrl : 'views/finance/invoice/freightInvoice/freightInvoiceList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/freightInvoice/freightInvoiceCtrl.js' ])
									} ]
						}
					})
					
					.state('app.finance.invoice.freightinvoiceadd',
									{
						url : '/invoice/freightinvoice/add',
						data : {
							title : 'Freight Invoice Add'
						},
						controller : 'freightAddCtrl',
						templateUrl : 'views/finance/invoice/freightInvoice/freightInvoiceAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/invoice/freightInvoice/freightAddCtrl.js' ])
									} ]
						}
					})
					
					
					.state(
					'app.finance.invoice.freightinvoiceView',
					{
						url : '/finance/freightinvoice/view',
						data : {
							title : 'Freight Invoice View'
						},

						controller : 'invoiceViewController',
						templateUrl : 'views/finance/invoice/freightInvoice/invoiceView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
										.load([ 'js/app/finance/invoice/freightInvoice/freightAddCtrl.js' ]);
									} ]
						}

					})
					
					
				
						// Accounts module Purchase Invoice

					.state(
							'app.finance.invoice.pinvoice',
							{
								url : '/invoice/pinvoice/PInvoiceList',
								data : {
									title : 'Purchase Invoice'
								},
								controller : 'purchaseInvoiceCtrl',
								templateUrl : '/views/finance/invoice/pinvoice/PInvoiceList',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/finance/invoice/pinvoice/purchaseInvoiceCtrl.js' ]);
											} ]
								}
							})
					

					.state(
							'app.finance.invoice.pinvoice-add',
							{
								url : '/invoice/pinvoice/PInvoiceAdd',
								data : {
									title : 'Add'
								},

								controller : 'purchaseInvoiceCtrladd',
								templateUrl : 'views/finance/invoice/pinvoice/PInvoiceAdd',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/finance/invoice/pinvoice/purchaseInvoiceCtrl.js' ]);
											} ]
								}

							})
					.state(
							'app.finance.invoice.pinvoice-edit',
							{
								url : '/invoice/pinvoice/PInvoiceEdit/:purchaseInvoiceNo',
								data : {
									title : 'Add'
								},

								controller : 'purchaseInvoiceCtrladd',
								templateUrl : 'views/finance/invoice/pinvoice/PInvoiceAdd',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/finance/invoice/pinvoice/purchaseInvoiceCtrl.js' ]);
											} ]
								}

							})
					
					.state(
							'app.finance.invoice.pinvoiceView',
							{
								url : '/invoice/pinvoice/PInvoiceView/:purchaseInvoiceNo',
								data : {
									title : 'View'
								},
								controller : 'purchaseInvoiceViewCtrl',
								templateUrl : 'views/finance/invoice/pinvoice/PInvoiceView',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/finance/invoice/pinvoice/purchaseInvoiceCtrl.js' ]);
											} ]

								}

							})
					.state(
							'app.finance.invoice.pinvoiceView1',
							{
								url : '/invoice/pinvoice/PInvoiceView1/:purchaseInvoiceNo1',
								data : {
									title : 'View'
								},
								controller : 'purchaseInvoiceViewCtrl',
								templateUrl : 'views/finance/invoice/pinvoice/PInvoiceView',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/finance/invoice/pinvoice/purchaseInvoiceCtrl.js' ]);
											} ]

								}

							})
					.state(
							'app.finance.invoice.pinvoice-copy',
							{
								url : '/invoice/pinvoice/PInvoiceCopy/:purchaseInvoiceNo',
								data : {
									title : 'Copy'
								},

								controller : 'purchaseInvoiceAddCtrl',
								templateUrl : 'views/finance/invoice/pinvoice/PInvoiceAdd',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/finance/invoice/pinvoice/pInvoiceAddCtrl.js' ]);
											} ]

								}

							})
							.state(
									'app.finance.invoice.generalinvoiceNew',
									{
										url : '/invoice/generalinvoiceNew/list',
										data : {
											title : 'General Invoice List'
										},
										controller : 'generalInvoiceCtrl1',
										templateUrl : 'views/finance/invoice/generalInvoiceNew/generalInvoice',
										resolve : {
											deps : [
													'$ocLazyLoad',
													function($ocLazyLoad) {
														return $ocLazyLoad
																.load([ 'js/app/finance/invoice/generalInvoiceCtrlNew.js' ])
													} ]
										}
									})
						

							.state(
									'app.finance.invoice.generalinvoiceaddNew',
									{
										url : '/invoice/generalinvoiceNew/add',
										data : {
											title : 'General Invoice'
										},
										controller : 'generalInvoiceCtrladd1',
										templateUrl : 'views/finance/invoice/generalInvoiceNew/generalInvoiceAdd',
										resolve : {
											deps : [
													'$ocLazyLoad',
													function($ocLazyLoad) {
														return $ocLazyLoad
																.load([ 'js/app/finance/invoice/generalInvoiceCtrlNew.js' ])
													} ]
										}
									})
							.state(
									'app.finance.invoice.generalinvoiceeditNew',
									{
										url : '/invoice/generalinvoiceNew/edit/:InvoiceNo',
										data : {
											title : 'General Invoice Edit'
										},
										controller : 'generalInvoiceCtrladd1',
										templateUrl : 'views/finance/invoice/generalInvoiceNew/generalInvoiceAdd',
										resolve : {
											deps : [
													'$ocLazyLoad',
													function($ocLazyLoad) {
														return $ocLazyLoad
																.load([ 'js/app/finance/invoice/generalInvoiceCtrlNew.js' ])
													} ]
										}
									})
							.state(
									'app.finance.invoice.generalinvoiceViewNew',
									{
										url : '/invoice/generalinvoiceNew/view/:invoiceNo',
										data : {
											title : 'General Invoice View'
										},
										controller : 'generalInvoiceViewCtrl1',
										templateUrl : 'views/finance/invoice/generalInvoiceNew/generalInvoiceView',
										resolve : {
											deps : [
													'$ocLazyLoad',
													function($ocLazyLoad) {
														return $ocLazyLoad
																.load([ 'js/app/finance/invoice/generalInvoiceCtrlNew.js' ])
													} ]
										}
									})
							.state(
									'app.finance.invoice.generalinvoiceView1New',
									{
										url : '/invoice/generalinvoiceNew/view1/:invoiceNo1',
										data : {
											title : 'General Invoice View'
										},
										controller : 'generalInvoiceViewCtrl1',
										templateUrl : 'views/finance/invoice/generalInvoiceNew/generalInvoiceView',
										resolve : {
											deps : [
													'$ocLazyLoad',
													function($ocLazyLoad) {
														return $ocLazyLoad
																.load([ 'js/app/finance/invoice/generalInvoiceCtrlNew.js' ])
													} ]
										}
									})
									
								//rajapriya
									
									.state('app.finance.accounts.manageFinancialYear', {
				abstract : true,
				templateUrl : "views/common.jsp",
				data : {
					title : 'Manage Financial Year'
				}
			})
									
									.state(
											'app.finance.accounts.manageFinancialYear.list',
											{
												url : '/accounts/manageFinancialYear/list',
												data : {
													title : 'List'
												},
												controller : 'manageFinancialYearCtrl',
												templateUrl : 'views/finance/accounts/manageFinancialYear/manageFinancialYear',
												resolve : {
													deps : [
															'$ocLazyLoad',
															function($ocLazyLoad) {
																return $ocLazyLoad
																		.load([ 'js/app/finance/accounts/manageFinancialYear/manageFinancialYearCtrl.js' ]);
															} ]
												}

											})
									.state(
											'app.finance.accounts.manageFinancialYear.add',
											{
												url : '/accounts/manageFinancialYear/add',
												data : {
													title : 'Add'
												},
												controller : 'manageFinancialYearAddCtrl',
												templateUrl : 'views/finance/accounts/manageFinancialYear/manageFinancialYearAdd',
												resolve : {
													deps : [
															'$ocLazyLoad',
															function($ocLazyLoad) {
																return $ocLazyLoad
																		.load([ 'js/app/finance/accounts/manageFinancialYear/manageFinancialYearAddCtrl.js' ]);
															} ]
												}

											})
											
									
											
											.state(
											'app.finance.accounts.manageFinancialYear.edit',
											{
												url : '/accounts/manageFinancialYear/edit',
												data : {
													title : 'Add'
												},
												controller : 'manageFinancialYearAddCtrl',
												templateUrl : 'views/finance/accounts/manageFinancialYear/manageFinancialYearAdd',
												resolve : {
													deps : [
															'$ocLazyLoad',
															function($ocLazyLoad) {
																return $ocLazyLoad
																		.load([ 'js/app/finance/accounts/manageFinancialYear/manageFinancialYearAddCtrl.js' ]);
															} ]
												}

											})
											
												
				  .state('app.finance.accounts.managecustomer', {
            abstract : true,
			templateUrl : "views/common.jsp",
            data : {
                title : 'Manage Customer'
            }
        })

        .state('app.finance.accounts.managecustomer.list', {
            url : '/accounts/managecustomer/list',
            data : {
                title : 'List'
            },
           
            
            controller : 'manageCustomerListCtrl',
			templateUrl : 'views/finance/accounts/managecustomer/manageCustomerList',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/managecustomer/manageCustomerCtrl.js' ]);
						} ]
			}
        })

        .state('app.finance.accounts.managecustomer.add', {
            url : '/accounts/managecustomer/add',
            data : {
                title : 'Add'
            },
         
            
            controller : 'manageCustomerAddCtrl',
			templateUrl : 'views/finance/accounts/managecustomer/manageCustomerAdd',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/managecustomer/manageCustomerAddCtrl.js' ]);
						} ]
			}
        }).state('app.finance.accounts.managecustomer.edit', {
            url : '/accounts/managecustomer/edit/:entityId',
            data : {
                title : 'Edit'
            },
       
            
            controller : 'manageCustomerAddCtrl',
			templateUrl : 'views/finance/accounts/managecustomer/manageCustomerAdd',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/managecustomer/manageCustomerAddCtrl.js' ]);
						} ]
			}
        }).state('app.finance.accounts.managecustomer.addBank', {
            url : '/accounts/managecustomer/addBank',
            data : {
                title : 'Add'
            },
      
            
            controller : 'manageCustomerAddBankCtrl',
			templateUrl : 'views/finance/accounts/managecustomer/manageCustomerBankAdd',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/managecustomer/manageCustomerAddCtrl.js' ]);
						} ]
			}
        })
									
		
        
          // Currency
        .state('app.finance.accounts.currency', {
            abstract : true,
			templateUrl : "views/common.jsp",
            data : {
                title : 'Currency'
            }
        }).state('app.finance.accounts.currency.list', {
            url : '/hospital/accounts/currency/list',
            data : {
                title : 'List'
            },
         
            controller : 'currencyListCtrl',
			templateUrl : 'views/finance/accounts/currency/currencyList',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/currency/currencyListCtrl.js' ]);
						} ]
			}
            
        }).state('app.finance.accounts.currency.add', {
            url : '/hospital/accounts/currency/add',
            data : {
                title : 'Add'
            },
          
            
            
            controller : 'currencyAddCtrl',
			templateUrl : 'views/finance/accounts/currency/currencyAdd',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/currency/currencyAddCtrl.js' ]);
						} ]
			}
        }).state('app.finance.accounts.currency.edit', {
            url : '/hospital/accounts/currency/edit/:currencyCode',
            data : {
                title : 'Edit'
            },
          
            
            controller : 'currencyAddCtrl',
			templateUrl : 'views/finance/accounts/currency/currencyAdd',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/currency/currencyAddCtrl.js' ]);
						} ]
			}
        })
      
        
        .state('app.finance.accounts.exchangeRate', {
            abstract : true,
			templateUrl : "views/common.jsp",
            data : {
                title : 'Exchange Rate'
            }
        })

        .state('app.finance.accounts.exchangeRate.list', {
            url : '/hospital/accounts/exchangeRate/list',
            data : {
                title : 'List'
            },
/*            views : {
                "content@app" : {
                    controller : 'exchangeRateListCtrl',
                    templateUrl : 'views/hospital/accounts/exchangeRate/exchangeRateList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/exchangeRate/exchangeRateListCtrl.js' ])
                    }
                }
            }*/
            
            controller : 'exchangeRateListCtrl',
			templateUrl : 'views/finance/accounts/exchangeRate/exchangeRateList',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/exchangeRate/exchangeRateListCtrl.js' ]);
						} ]
			}
        })

        .state('app.finance.accounts.exchangeRate.add', {
            url : '/hospital/accounts/exchangeRate/add',
            data : {
                title : 'Add'
            },
            /*views : {
                "content@app" : {
                    controller : 'exchangeRateAddCtrl',
                    templateUrl : 'views/hospital/accounts/exchangeRate/exchangeRateAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/exchangeRate/exchangeRateAddCtrl.js' ])
                    }
                }
            }*/
            
            
            controller : 'exchangeRateAddCtrl',
			templateUrl : 'views/finance/accounts/exchangeRate/exchangeRateAdd',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/exchangeRate/exchangeRateAddCtrl.js' ]);
						} ]
			}
        })

        .state('app.finance.accounts.exchangeRate.edit', {
            url : '/hospital/accounts/exchangeRate/edit/:exchangeRateCode',
            data : {
                title : 'Edit'
            },
           /* views : {
                "content@app" : {
                    controller : 'exchangeRateAddCtrl',
                    templateUrl : 'views/hospital/accounts/exchangeRate/exchangeRateAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/exchangeRate/exchangeRateAddCtrl.js' ])
                    }
                }
            }*/
            
            
            controller : 'exchangeRateAddCtrl',
			templateUrl : 'views/finance/accounts/exchangeRate/exchangeRateAdd',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/exchangeRate/exchangeRateAddCtrl.js' ]);
						} ]
			}
        })

          .state('app.finance.accounts.groupHead', {
            abstract : true,
			templateUrl : "views/common.jsp",
            data : {
                title : 'Group Head'
            }
        })

        .state('app.finance.accounts.groupHead.list', {
            url : '/hospital/accounts/groupHead/list',
            data : {
                title : 'List'
            },
       
            
            controller : 'groupHeadListCtrl',
			templateUrl : 'views/finance/accounts/groupHead/groupHeadList',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/groupHead/groupHeadCtrl.js' ]);
						} ]
			}
        })

        
        
        
        
        .state('app.finance.accounts.subHeadGroupAccount', {
            abstract : true,
			templateUrl : "views/common.jsp",
            data : {
                title : 'Sub Group Headings'
            }
        })

        .state('app.finance.accounts.subHeadGroupAccount.list', {
            url : '/hospital/accounts/subHeadGroupAccount/list',
            data : {
                title : 'List'
            },
         
            
            controller : 'subHeadGroupAccountListCtrl',
			templateUrl : 'views/finance/accounts/subHeadGroupAccount/subHeadGroupAccountList',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/subHeadGroupAccount/subHeadGroupAccountCtrl.js' ]);
						} ]
			}
        })

        .state('app.finance.accounts.subHeadGroupAccount.add', {
            url : '/hospital/accounts/subHeadGroupAccount/add',
            data : {
                title : 'Add'
            },
         
            controller : 'subHeadGroupAccountAddCtrl',
			templateUrl : 'views/finance/accounts/subHeadGroupAccount/subHeadGroupAccountAdd',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/subHeadGroupAccount/subHeadGroupAccountCtrl.js' ]);
						} ]
			}
        })

        
        
        
        
          .state('app.finance.accounts.subGroupAccount', {
            abstract : true,
			templateUrl : "views/common.jsp",
            data : {
                title : 'Sub Group Account'
            }
        })

        .state('app.finance.accounts.subGroupAccount.list', {
            url : '/accounts/subGroupAccount/list',
            data : {
                title : 'List'
            },
        
            
            
            controller : 'subGroupAccountListCtrl',
			templateUrl : 'views/finance/accounts/subGroupAccount/subGroupAccountList',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/subGroupAccount/subGroupAccountCtrl.js' ]);
						} ]
			}
        })

        .state('app.finance.accounts.subGroupAccount.add', {
            url :'/accounts/subGroupAccount/add',
            data : {
                title : 'Add'
            },
           
            controller : 'subGroupAccountAddCtrl',
			templateUrl : 'views/finance/accounts/subGroupAccount/subGroupAccountAdd',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/subGroupAccount/subGroupAccountCtrl.js' ]);
						} ]
			}
        })
        
        
        
        
        
      
        
           .state('app.finance.accounts.accountHead', {
            abstract : true,
			templateUrl : "views/common.jsp",

            data : {
                title : 'Account Head'
            }
        })

        .state('app.finance.accounts.accountHead.list', {
            url : '/hospital/accounts/accountHead/list',
            data : {
                title : 'List'
            },
        
            
            controller : 'accountHeadListCtrl',
			templateUrl : 'views/finance/accounts/accountHead/AccountHeadList',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/accountHead/accountHeadListCtrl.js' ]);
						} ]
			}
        })

        .state('app.finance.accounts.accountHead.add', {
            url : '/hospital/accounts/accountHead/add',
            data : {
                title : 'Add'
            },
        
            
            controller : 'accountHeadAddCtrl',
			templateUrl : 'views/finance/accounts/accountHead/AccountHeadAdd',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/accountHead/accountHeadAddCtrl.js' ]);
						} ]
			}
        })
        
        
        //chart
        
         .state('app.finance.accounts.chartOfAccounts', {
            abstract : true,
			templateUrl : "views/common.jsp",
            data : {
                title : 'Chart Of Accounts'
            }
        })

        .state('app.finance.accounts.chartOfAccounts.viewlist', {
            url : '/hospital/accounts/chartOfAccounts/view',
            data : {
                title : 'View'
            },
          controller : 'chartOfAccountCtrl',
			templateUrl : 'views/finance/accounts/chartOfAccount/chartOfAccount',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/chartOfAccount/chartOfAccountCtrl.js' ]);
						} ]
			}
        })
        
        
        
          .state('app.finance.accounts.attributes', {
            abstract : true,
			templateUrl : "views/common.jsp",
            data : {
                title : 'Attributes'
            }
        })

        .state('app.finance.accounts.attributes.list', {
            url : '/hospital/accounts/attributes/list',
            data : {
                title : 'List'
            },
          
            
            controller : 'attributesListCtrl',
			templateUrl : 'views/finance/accounts/attributes/attributesList',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/attributes/attributesCtrl.js' ]);
						} ]
			}
        })

        .state('app.finance.accounts.attributes.add', {
            url : '/hospital/accounts/attributes/add',
            data : {
                title : 'Add'
            },
         
            
            controller : 'attributesAddCtrl',
			templateUrl : 'views/finance/accounts/attributes/attributesAdd',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/attributes/attributesCtrl.js' ]);
						} ]
			}
 
        })
        
        
     
        
        
         .state('app.finance.accounts.manageCostCenter', {
            abstract : true,
			templateUrl : "views/common.jsp",

            data : {
                title : 'Manage Cost Center'
            }
        })

        .state('app.finance.accounts.manageCostCenter.list', {
            url : '/hospital/accounts/manageCostCenter/manageCostCenterList',
            data : {
                title : 'List'
            },
          
            
            controller : 'manageCostCenterListCtrl',
			templateUrl : 'views/finance/accounts/manageCostCenter/manageCostCenterList',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/manageCostCenter/manageCostCenterListCtrl.js' ]);
						} ]
			}
        })

        .state('app.finance.accounts.manageCostCenter.add', {
            url : '/hospital/accounts/manageCostCenter/add',
            data : {
                title : 'Add'
            },
           
            
            controller : 'manageCostCenterAddCtrl',
			templateUrl : 'views/finance/accounts/manageCostCenter/manageCostCenterAdd',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/manageCostCenter/manageCostCenterAddCtrl.js' ]);
						} ]
			}
        })

        .state('app.finance.accounts.manageCostCenter.edit', {
            url : '/hospital/accounts/manageCostCenter/edit',
            data : {
                title : 'Edit'
            },
         
            
            controller : 'manageCostCenterAddCtrl',
			templateUrl : 'views/finance/accounts/manageCostCenter/manageCostCenterAdd',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/manageCostCenter/manageCostCenterAddCtrl.js' ]);
						} ]
			}
        })
        
        
        
        
        
        
          // Purchase Invoice
        .state('app.finance.accounts.purchaseinvoice', {
            abstract : true,
			templateUrl : "views/common.jsp",
            data : {
                title : 'Purchase Invoice'
            }
        }).state('app.finance.accounts.purchaseinvoice.add', {
            url : '/accounts/purchaseInvoice/add',
            data : {
                title : 'Add'
            },
       
            controller : 'purchaseInvoiceAddCtrl',
			templateUrl : 'views/finance/accounts/purchaseInvoice/purchaseInvoiceAdd',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/purchaseInvoice/purchaseInvoiceAddCtrl.js' ]);
						} ]
			}
        }).state('app.finance.accounts.purchaseinvoice.list', {
            url : '/accounts/purchaseInvoice/list',
            data : {
                title : 'List'
            },
            
            controller : 'purchaseInvoiceListCtrl',
			templateUrl : 'views/finance/accounts/purchaseInvoice/purchaseInvoiceList',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/purchaseInvoice/purchaseInvoiceListCtrl.js' ]);
						} ]
			}
       
        }).state('app.finance.accounts.purchaseinvoice.edit', {
            url : '/accounts/purchaseInvoiceEdit/:purchaseInvoiceNo',
            data : {
                title : 'Edit'
            },

            controller : 'purchaseInvoiceAddCtrl',
			templateUrl : 'views/finance/accounts/purchaseInvoice/purchaseInvoiceEdit',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/purchaseInvoice/purchaseInvoiceAddCtrl.js' ]);
						} ]
			}
        })
        
        
          // Invoice//
        .state('app.finance.accounts.invoice', {
            abstract : true,
			templateUrl : "views/common.jsp",
            data : {
                title : 'General Invoice'
            }
        })

        .state('app.finance.accounts.invoice.list', {
            url : '/hospital/accounts/invoice/list',
            data : {
                title : 'List'
            },
       
            
            controller : 'generalInvoiceCtrl',
			templateUrl : 'views/finance/accounts/invoice/invoiceList',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/invoice/generalInvoiceCtrl.js' ]);
						} ]
			}
        })

        .state('app.finance.accounts.invoice.add', {
            url : '/hospital/accounts/invoice/add',
            data : {
                title : 'Add'
            },
         
            
            controller : 'generalInvoiceCtrladd',
			templateUrl : 'views/finance/accounts/invoice/invoiceAdd',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/invoice/generalInvoiceCtrl.js' ]);
						} ]
			}
        })

        .state('app.finance.accounts.invoice.edit', {
            url : '/hospital/accounts/invoiceedit/:invoiceNo',
            data : {
                title : 'Edit'
            },
            
            controller : 'generalInvoiceCtrladd',
			templateUrl : 'views/finance/accounts/invoice/invoiceAdd',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/invoice/generalInvoiceCtrl.js' ]);
						} ]
			}
        })
        
        
        
        
 //general purchase invoice
        
        .state('app.finance.accounts.generalpurchaseinvoice', {
            abstract : true,
			templateUrl : "views/common.jsp",
            data : {
                title : 'Service Order'
            }
        }).state('app.finance.accounts.generalpurchaseinvoice.add', {
            url : '/hospital/accounts/generalPurchaseInvoice/add',
            data : {
                title : 'Add'
            },
      
            
            controller : 'generalPurchaseInvoiceAddCtrl',
			templateUrl : 'views/finance/accounts/generalPurchaseInvoice/generalPurchaseInvoiceAdd',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/generalPurchaseInvoice/generalPurchaseInvoiceAddCtrl.js' ]);
						} ]
			}
        }).state('app.finance.accounts.generalpurchaseinvoice.list', {
            url : '/hospital/accounts/generalPurchaseInvoice/list',
            data : {
                title : 'List'
            },
       
            
            controller : 'generalPurchaseInvoiceListCtrl',
			templateUrl : 'views/finance/accounts/generalPurchaseInvoice/generalPurchaseInvoiceList',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/generalPurchaseInvoice/generalPurchaseInvoiceListCtrl.js' ]);
						} ]
			}
        })
        
        .state('app.finance.accounts.generalpurchaseinvoice.edit', {
            url : '/hospital/accounts/generalPurchaseInvoiceEdit/:purchaseInvoiceNo',
            data : {
                title : 'Edit'
            },
         
            
            controller : 'generalPurchaseInvoiceAddCtrl',
			templateUrl : 'views/finance/accounts/generalPurchaseInvoice/generalPurchaseInvoiceAdd',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/generalPurchaseInvoice/generalPurchaseInvoiceAddCtrl.js' ]);
						} ]
			}
        })
        
        
        .state('app.finance.accounts.budgetType', {
            abstract : true,
			templateUrl : "views/common.jsp",
            data : {
                title : 'Budget Type'
            }
        })

        .state('app.finance.accounts.budgetType.list', {
            url : '/hospital/accounts/budgetType/list',
            data : {
                title : 'List'
            },
       
            
            controller : 'budgetTypeListCtrl',
			templateUrl : 'views/finance/accounts/budget/budgetTypeList',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/budget/budgetTypeCtrl.js' ]);
						} ]
			}

        })

        .state('app.finance.accounts.budgetType.add', {
            url : '/hospital/accounts/budgetType/add',
            data : {
                title : 'Add'
            },
         
            
            controller : 'budgetTypeAddCtrl',
			templateUrl : 'views/finance/accounts/budget/budgetTypeForm',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/budget/budgetTypeForm.js' ]);
						} ]
			}
        })
        
        
        .state('app.finance.accounts.budgetDefinitions', {
            abstract : true,
			templateUrl : "views/common.jsp",
            data : {
                title : 'Budget Allocation'
            }
        })

        .state('app.finance.accounts.budgetDefinitions.list', {
            url : '/hospital/accounts/budgetDefinitions/list',
            data : {
                title : 'List'
            },
           /* views : {
                "content@app" : {
                    controller : 'budgetDefinitionListCtrl',
                    templateUrl : 'views/hospital/accounts/budgetDefinition/budgetDefinitionList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/budgetDefinition/budgetDefinitionListCtrl.js' ])
                    }
                }
            }*/
            
            controller : 'budgetDefinitionListCtrl',
			templateUrl : 'views/finance/accounts/budgetDefinition/budgetDefinitionList',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/budgetDefinition/budgetDefinitionListCtrl.js' ]);
						} ]
			}

        })
        
        .state('app.finance.accounts.budgetDefinitions.add', {
            url : '/hospital/accounts/budgetDefinitions/add',
            data : {
                title : 'Add'
            },
           /* views : {
                "content@app" : {
                    controller : 'budgetDefinitionAddCtrl',
                    templateUrl : 'views/hospital/accounts/budgetDefinition/budgetDefinitionAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/budgetDefinition/budgetDefinitionAddCtrl.js' ])
                    }
                }
            }*/
            
            controller : 'budgetDefinitionAddCtrl',
			templateUrl : 'views/finance/accounts/budgetDefinition/budgetDefinitionAdd',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/budgetDefinition/budgetDefinitionAddCtrl.js' ]);
						} ]
			}

        })

        .state('app.finance.accounts.budgetDefinitions.edit', {
            url : '/hospital/accounts/budgetDefinitions/edit/:budgetDefinitionId',
            data : {
                title : 'Edit'
            },
          /*  views : {
                "content@app" : {
                    controller : 'budgetDefinitionEditCtrl',
                    templateUrl : 'views/hospital/accounts/budgetDefinition/budgetDefinitionAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/budgetDefinition/budgetDefinitionAddCtrl.js' ])
                    }
                }
            }*/
            
            controller : 'budgetDefinitionEditCtrl',
			templateUrl : 'views/finance/accounts/budgetDefinition/budgetDefinitionAdd',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/budgetDefinition/budgetDefinitionAddCtrl.js' ]);
						} ]
			}
        })
        
        .state('app.finance.accounts.budgetDefinitions.approve', {
            url : '/hospital/accounts/budgetDefinitions/approve/:budgetDefinitionId',
            data : {
                title : 'approve'
            },
          /*  views : {
                "content@app" : {
                    controller : 'budgetDefinitionEditCtrl',
                    templateUrl : 'views/hospital/accounts/budgetDefinition/budgetDefinitionApprove',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/budgetDefinition/budgetDefinitionAddCtrl.js' ])
                    }
                }
            }*/
            
            controller : 'budgetDefinitionEditCtrl',
			templateUrl : 'views/finance/accounts/budgetDefinition/budgetDefinitionApprove',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/budgetDefinition/budgetDefinitionAddCtrl.js' ]);
						} ]
			}
        })
        .state('app.finance.accounts.budgetDefinitions.view', {
            url : '/hospital/accounts/budgetDefinitions/view/:budgetDefinitionId',
            data : {
                title : 'approve'
            },
            /*views : {
                "content@app" : {
                    controller : 'budgetDefinitionEditCtrl',
                    templateUrl : 'views/hospital/accounts/budgetDefinition/budgetDefinitionView',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/budgetDefinition/budgetDefinitionAddCtrl.js' ])
                    }
                }
            }*/
            controller : 'budgetDefinitionEditCtrl',

        	templateUrl : 'views/finance/accounts/budgetDefinition/budgetDefinitionView',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/budgetDefinition/budgetDefinitionAddCtrl.js' ]);
						} ]
			}
        })
        
        
        
        .state('app.finance.accounts.budgetDefinitionsApprove', {
            abstract : true,
			templateUrl : "views/common.jsp",
            data : {
                title : 'Budget Allocation Approve'
            }
        })

        .state('app.finance.accounts.budgetDefinitionsApprove.list', {
            url : '/hospital/accounts/budgetDefinitionsApprove/list',
            data : {
                title : 'List'
            },
           /* views : {
                "content@app" : {
                    controller : 'budgetDefinitionApproveListCtrl',
                    templateUrl : 'views/hospital/accounts/budgetDefinition/budgetDefinitionApproveList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/budgetDefinition/budgetDefinitionApproveListCtrl.js' ])
                    }
                }
            }
*/       
            controller : 'budgetDefinitionApproveListCtrl',
			templateUrl : 'views/finance/accounts/budgetDefinition/budgetDefinitionApproveList',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/budgetDefinition/budgetDefinitionApproveListCtrl.js' ]);
						} ]
			}   
        
        })
        
        
          .state('app.finance.accounts.budgetOverview', {
            abstract : true,
			templateUrl : "views/common.jsp",
            data : {
                title : 'Budget Overview'
            }
        })

        .state('app.finance.accounts.budgetOverview.list', {
            url : '/hospital/accounts/budgetOverview/budgetOverviewList',
            data : {
                title : 'List'
            },
          /*  views : {
                "content@app" : {
                    controller : 'budgetOverviewListCtrl',
                    templateUrl : 'views/hospital/accounts/budgetOverview/budgetOverviewList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/budgetOverview/budgetOverviewListCtrl.js' ])
                    }
                }
            }*/
            
            controller : 'budgetOverviewListCtrl',
			templateUrl : 'views/finance/accounts/budgetOverview/budgetOverviewList',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/budgetOverview/budgetOverviewListCtrl.js' ]);
						} ]
			}   
        })
        
        
        
        
        
         // PAYMENT
        .state('app.finance.accounts.payment', {
            abstract : true,
			templateUrl : "views/common.jsp",
            data : {
                title : 'Cash Bank Payment'
            }
        })

        .state('app.finance.accounts.payment.list', {
            url : '/hospital/accounts/payment/list',
            data : {
                title : 'List'
            },
       /*     views : {
                "content@app" : {
                    controller : 'CashBankPaymentListCtrl',
                    templateUrl : 'views/hospital/accounts/payment/CashBankPaymentList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/payment/cashbankpaymentListCtrl.js' ])
                    }
                }
            }*/
            
            
            controller : 'CashBankPaymentListCtrl',
			templateUrl : 'views/finance/accounts/payment/CashBankPaymentList',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/payment/cashbankpaymentListCtrl.js' ]);
						} ]
			}   
        }).state('app.finance.accounts.payment.add', {
            url : '/hospital/accounts/payment/add',
            data : {
                title : 'Add'
            },
           /* views : {
                "content@app" : {
                    controller : 'CashBankPaymentAddCtrl',
                    templateUrl : 'views/hospital/accounts/payment/CashBankPaymentForm',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/payment/cashbankpaymentAddCtrl.js' ])
                    }
                }
            }
*/       
            controller : 'CashBankPaymentAddCtrl',
			templateUrl : 'views/finance/accounts/payment/CashBankPaymentForm',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/payment/cashbankpaymentAddCtrl.js' ]);
						} ]
			}       
        
        }).state('app.finance.accounts.payment.edit', {
            url : '/hospital/accounts/payment/edit/:voucherNo',
            data : {
                title : 'Edit'
            },
          /*  views : {
                "content@app" : {
                    controller : 'CashBankPaymentAddCtrl',
                    templateUrl : 'views/hospital/accounts/payment/CashBankPaymentForm',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/payment/cashbankpaymentAddCtrl.js' ])
                    }
                }
            }*/
            
            controller : 'CashBankPaymentAddCtrl',
			templateUrl : 'views/finance/accounts/payment/CashBankPaymentForm',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/payment/cashbankpaymentAddCtrl.js' ]);
						} ]
			}       
    
        })

        
        
         .state('app.finance.accounts.payment.view', {
            url : '/hospital/accounts/payment/view/:voucherNo',
            data : {
                title : 'View'
            },
           /* views : {
                "content@app" : {
                    controller : 'CashBankPaymentAddCtrl',
                    templateUrl : 'views/hospital/accounts/payment/CashBankPaymentView',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/payment/cashbankpaymentAddCtrl.js' ])
                    }
                }
            }*/
            
            
            controller : 'CashBankPaymentAddCtrl',
			templateUrl : 'views/finance/accounts/payment/CashBankPaymentView',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/payment/cashbankpaymentAddCtrl.js' ]);
						} ]
			}       
    
        })
        
        
          .state('app.finance.accounts.bankReconcillation', {
            abstract : true,
			templateUrl : "views/common.jsp",
            data : {
                title : 'Bank Reconciliation'
            }
        })

        .state('app.finance.accounts.bankReconcillation.list', {
            url : '/hospital/accounts/bankReconciliation/list',
            data : {

            },
           /* views : {
                "content@app" : {
                    controller : 'bankReconcillationCtrl',
                    templateUrl : 'views/hospital/accounts/bankReconcillation/bankReconcillationList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/bankReconcillation/bankReconcillationListCtrl.js' ])
                    }
                }
            }*/
            
            controller : 'bankReconcillationCtrl',
			templateUrl : 'views/finance/accounts/bankReconcillation/bankReconcillationList',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/bankReconcillation/bankReconcillationListCtrl.js' ]);
						} ]
			}       
    
        })
        
        
        
        .state('app.finance.accounts.bankCompanymapping', {
            abstract : true,
			templateUrl : "views/common.jsp",
            data : {
                title : 'Cash/Bank Company Mapping'
            }
        })

        .state('app.finance.accounts.bankCompanymapping.list', {
            url : '/hospital/accounts/bankCompanymapping/bankCompanymappingList',
            data : {
                title : 'List'
            },
           /* views : {
                "content@app" : {
                    controller : 'bankCompanymappingListCtrl',
                    templateUrl : 'views/hospital/accounts/bankCompanymapping/bankCompanymappingList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/bankCompanymapping/bankCompanymappingList.js' ])
                    }
                }
            }*/
            
            
            controller : 'bankCompanymappingListCtrl',
			templateUrl : 'views/finance/accounts/bankCompanymapping/bankCompanymappingList',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/bankCompanymapping/bankCompanymappingList.js' ]);
						} ]
			}       
    
        })

        .state('app.finance.accounts.bankCompanymapping.Add', {
            url : '/hospital/accounts/bankCompanymapping/bankCompanymappingAdd',
            data : {
                title : 'Add'
            },
           /* views : {
                "content@app" : {
                    controller : 'bankCompanymappingAddCtrl',
                    templateUrl : 'views/hospital/accounts/bankCompanymapping/bankCompanymappingAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/bankCompanymapping/bankCompanymappingAdd.js' ])
                    }
                }
            }*/
            
            
            controller : 'bankCompanymappingAddCtrl',
			templateUrl : 'views/finance/accounts/bankCompanymapping/bankCompanymappingAdd',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/bankCompanymapping/bankCompanymappingAdd.js' ]);
						} ]
			}  
        })
        .state('app.finance.accounts.bankCompanymapping.edit', {
            url : '/hospital/accounts/bankCompanymapping/bankCompanymappingEdit',
            data : {
                title : 'Edit'
            },
          /*  views : {
                "content@app" : {
                    controller : 'bankCompanymappingAddCtrl',
                    templateUrl : 'views/hospital/accounts/bankCompanymapping/bankCompanymappingAdd',
                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/bankCompanymapping/bankCompanymappingAdd.js' ])
                    }
                }
            }*/
            
            
            controller : 'bankCompanymappingAddCtrl',
			templateUrl : 'views/finance/accounts/bankCompanymapping/bankCompanymappingAdd',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/bankCompanymapping/bankCompanymappingAdd.js' ]);
						} ]
			}  
        })
        
       // CASH BANK RECEIPT
        .state('app.finance.accounts.paymentreceipt', {
            abstract : true,
			templateUrl : "views/common.jsp",
            data : {
                title : 'Cash Bank Receipt'
            }
        })

        .state('app.finance.accounts.paymentreceipt.list', {
            url : '/hospital/accounts/paymentreceipt/list',
            data : {
                title : 'List'
            },
         /*   views : {
                "content@app" : {
                    controller : 'cashBankReceiptListCtrl',
                    templateUrl : 'views/hospital/accounts/paymentreceipt/CashBankReceiptList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/paymentreceipt/CashBankReceiptListCtrl.js' ])
                    }
                }
            }*/
            
            controller : 'cashBankReceiptListCtrl',
			templateUrl : 'views/finance/accounts/paymentreceipt/CashBankReceiptList',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/paymentreceipt/CashBankReceiptListCtrl.js' ]);
						} ]
			}  
        })

        .state('app.finance.accounts.paymentreceipt.add', {
            url : '/hospital/accounts/paymentreceipt/add',
            data : {
                title : 'Add'
            },
           /* views : {
                "content@app" : {
                    controller : 'cashBankReceiptAddCtrl',
                    templateUrl : 'views/hospital/accounts/paymentreceipt/cashBankReceiptAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/paymentreceipt/cashBankReceiptAddCtrl.js' ])
                    }
                }
            }*/
            
            
            controller : 'cashBankReceiptAddCtrl',
			templateUrl : 'views/finance/accounts/paymentreceipt/cashBankReceiptAdd',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/paymentreceipt/cashBankReceiptAddCtrl.js' ]);
						} ]
			}  
       
        }).state('app.finance.accounts.paymentreceipt.edit', {
            url : '/hospital/accounts/paymentreceipt/edit/:voucherNo',
            data : {
                title : 'Edit'
            },
          /*  views : {
                "content@app" : {
                    controller : 'cashBankReceiptAddCtrl',
                    templateUrl : 'views/hospital/accounts/paymentreceipt/cashBankReceiptAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/paymentreceipt/cashBankReceiptAddCtrl.js' ])
                    }
                }
            }*/
            

            controller : 'cashBankReceiptAddCtrl',
			templateUrl : 'views/finance/accounts/paymentreceipt/cashBankReceiptAdd',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/paymentreceipt/cashBankReceiptAddCtrl.js' ]);
						} ]
			} 
        })

        .state('app.finance.accounts.paymentreceipt.view', {
            url : '/hospital/accounts/paymentreceipt/view/:voucherNo',
            data : {
                title : 'View'
            },
          /*  views : {
                "content@app" : {
                    controller : 'cashBankReceiptAddCtrl',
                    templateUrl : 'views/hospital/accounts/paymentreceipt/cashBankReceiptView',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/paymentreceipt/cashBankReceiptAddCtrl.js' ])
                    }
                }
            }*/
            
            controller : 'cashBankReceiptAddCtrl',
			templateUrl : 'views/finance/accounts/paymentreceipt/cashBankReceiptView',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/paymentreceipt/cashBankReceiptAddCtrl.js' ]);
						} ]
			} 
        })
        
        
        
        
          .state('app.finance.accounts.journalVoucherType', {
            abstract : true,
			templateUrl : "views/common.jsp",

            data : {
                title : 'Journal Voucher Type'
            }
        })

        .state('app.finance.accounts.journalVoucherType.list', {
            url : '/hospital/accounts/journalVoucherType/journalVoucherTypeList',
            data : {
                title : 'List'
            },
         /*   views : {
                "content@app" : {
                    controller : 'journalVoucherTypeCtrl',
                    templateUrl : 'views/hospital/accounts/journalVoucherType/journalVoucherTypeList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/journalVoucherType/journalVoucherTypeCtrl.js' ])
                    }
                }
            }*/
            
            controller : 'journalVoucherTypeCtrl',
			templateUrl : 'views/finance/accounts/journalVoucherType/journalVoucherTypeList',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/journalVoucherType/journalVoucherTypeCtrl.js' ]);
						} ]
			} 
       
        })
        
        
    
        
        // Cheque Presentation
        .state('app.finance.accounts.chqPresentation', {
            abstract : true,
			templateUrl : "views/common.jsp",

            data : {
                title : 'Cheque Deposited'
            }
        })

        .state('app.finance.accounts.chqPresentation.list', {
            url : '/hospital/accounts/chqPresentation/list',
            data : {
                title : 'List'
            },
         /*   views : {
                "content@app" : {
                    controller : 'presentationCtrl',
                    templateUrl : 'views/hospital/accounts/chqPresentation/chqPresentation',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/chqPresentation/chqPresentationCtrl.js' ])
                    }
                }
            }*/
            
            controller : 'presentationCtrl',
			templateUrl : 'views/finance/accounts/chqPresentation/chqPresentation',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/chqPresentation/chqPresentationCtrl.js' ]);
						} ]
			} 
        })

        .state('app.finance.accounts.chqPresentation.add', {
            url : '/hospital/accounts/chqPresentation/add',
            data : {
                title : 'Add'
            },
          /*  views : {
                "content@app" : {
                    controller : 'presentationAddCtrl',
                    templateUrl : 'views/hospital/accounts/chqPresentation/chqPresentationForm',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/chqPresentation/chqPresentationCtrl.js' ])
                    }
                }
            }
*/        
            controller : 'presentationAddCtrl',
			templateUrl : 'views/finance/accounts/chqPresentation/chqPresentationForm',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/chqPresentation/chqPresentationCtrl.js' ]);
						} ]
			}     
        
        })
        
        // Cheque Realisation
        .state('app.finance.accounts.chqRealisation', {
            abstract : true,
			templateUrl : "views/common.jsp",
            data : {
                title : 'Cheque Realization'
            }
        })

        .state('app.finance.accounts.chqRealisation.list', {
            url : '/hospital/accounts/chqRealisation/list',
            data : {
                title : 'List'
            },
           /* views : {
                "content@app" : {
                    controller : 'realisationCtrl',
                    templateUrl : 'views/hospital/accounts/chqRealisation/chqRealisation',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/chqRealisation/chqRealisationCtrl.js' ])
                    }
                }
            }*/
            
            controller : 'realisationCtrl',
			templateUrl : 'views/finance/accounts/chqRealisation/chqRealisation',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/chqRealisation/chqRealisationCtrl.js' ]);
						} ]
			}   
        })

        .state('app.finance.accounts.chqRealisation.add', {
            url : '/hospital/accounts/chqRealisation/add',
            data : {
                title : 'Add'
            },
            /*views : {
                "content@app" : {
                    controller : 'realisationAddCtrl',
                    templateUrl : 'views/hospital/accounts/chqRealisation/chqRealisationForm',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/chqRealisation/chqRealisationCtrl.js' ])
                    }
                }
            }*/
            
            
            controller : 'realisationAddCtrl',
			templateUrl : 'views/finance/accounts/chqRealisation/chqRealisationForm',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/chqRealisation/chqRealisationCtrl.js' ]);
						} ]
			}
        })
        //Purchase Credit Note
        
        
        

        $stateProvider.state('app.finance.accounts.purchaseCreditNote', {
abstract : true,
templateUrl : "views/common.jsp",
data : {
title : 'Purchase Credit Note'
}
     })


          .state('app.finance.accounts.purchaseCreditNote.list', {
      url : '/hospital/accounts/purchaseCreditNote/purchaseCreditNoteList',
       data : {
          title : 'List'
         },
         /*   views : {
        "content@app" : {
    controller : 'purchaseCreditNoteCTRL',
  templateUrl : '/views/hrms/purchasecreditNote/purchasecreditNoteListPage',

resolve : {
       deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/purchaseCreditNote/PurchaseCreditNoteCtrl.js' ])
}
}
}*/
         controller : 'purchaseCreditNoteCTRL',

         templateUrl : 'views/finance/accounts/purchasecreditNote/purchasecreditNoteListPage',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/purchaseCreditNote/PurchaseCreditNoteCtrl.js' ]);
						} ]
			}
})



.state('app.finance.accounts.purchaseCreditNote.Add', {
url : '/hospital/accounts/purchaseCreditNote/purchaseCreditNoteAdd',

       data : {
      title : 'Add'
    },
 /*views : {
"content@app" : {
controller : 'purchaseCreditnoteAddCTRL',
   templateUrl : '/views/hrms/purchasecreditNote/purchaseCreditNoteForm',

   resolve : {
deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/purchaseCreditNote/PurchaseCreditNoteCtrl.js' ])
}
}
}*/
    
    controller : 'purchaseCreditnoteAddCTRL',

    templateUrl : 'views/finance/accounts/purchasecreditNote/purchaseCreditNoteForm',
		resolve : {
			deps : [
					'$ocLazyLoad',
					function($ocLazyLoad) {
						return $ocLazyLoad
								.load([ 'js/app/finance/accounts/purchaseCreditNote/PurchaseCreditNoteCtrl.js' ]);
					} ]
		}
})



.state('app.finance.accounts.debitNote', {
    abstract : true,
    templateUrl : "views/common.jsp",
    data : {
        title : 'Debit Note'
    }
})

.state('app.finance.accounts.debitNote.list', {
    url : '/hospital/accounts/debitNote/list',
    data : {
        title : 'List'
    },
   /* views : {
        "content@app" : {
            controller : 'debitNoteListCtrl',
            templateUrl : 'views/hospital/accounts/debitNote/debitNoteList',

            resolve : {
                deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/debitNote/debitNoteCtrl.js' ])
            }
        }
    }*/
    
    controller : 'debitNoteListCtrl',

    templateUrl : 'views/finance/accounts/debitNote/debitNoteList',
		resolve : {
			deps : [
					'$ocLazyLoad',
					function($ocLazyLoad) {
						return $ocLazyLoad
								.load([ 'js/app/finance/accounts/debitNote/debitNoteCtrl.js' ]);
					} ]
		}
})

.state('app.finance.accounts.debitNote.add', {
    url : '/hospital/accounts/debitNote/add',
    data : {
        title : 'Add'
    },
  /*  views : {
        "content@app" : {
            controller : 'debitNoteAddCtrl',
            templateUrl : 'views/hospital/accounts/debitNote/debitNoteAdd',

            resolve : {
                deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/debitNote/debitNoteCtrl.js' ])
            }
        }
    }*/
    
    controller : 'debitNoteAddCtrl',

    templateUrl : 'views/finance/accounts/debitNote/debitNoteAdd',
		resolve : {
			deps : [
					'$ocLazyLoad',
					function($ocLazyLoad) {
						return $ocLazyLoad
								.load([ 'js/app/finance/accounts/debitNote/debitNoteCtrl.js' ]);
					} ]
		}
})

.state('app.finance.accounts.debitNote.edit', {
    url : '/hospital/accounts/debitNote/edit/:debitNoteCode',
    data : {
        title : 'Edit'
    },
   /* views : {
        "content@app" : {
            controller : 'debitNoteAddCtrl',
            templateUrl : 'views/hospital/accounts/debitNote/debitNoteAdd',

            resolve : {
                deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/debitNote/debitNoteCtrl.js' ])
            }
        }
    }*/
    
    
    controller : 'debitNoteAddCtrl',

    templateUrl : 'views/finance/accounts/debitNote/debitNoteAdd',
		resolve : {
			deps : [
					'$ocLazyLoad',
					function($ocLazyLoad) {
						return $ocLazyLoad
								.load([ 'js/app/finance/accounts/debitNote/debitNoteCtrl.js' ]);
					} ]
		}
})
 .state('app.finance.accounts.debitNote.view', {
    url : '/hospital/accounts/debitNote/view/:debitNoteCode',
    data : {
        title : 'View'
    },
  /*  views : {
        "content@app" : {
            controller : 'debitNoteAddCtrl',
            templateUrl : 'views/hospital/accounts/debitNote/debitNoteView',

            resolve : {
                deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/debitNote/debitNoteCtrl.js' ])
            }
        }
    }*/
    
    
    controller : 'debitNoteAddCtrl',

    templateUrl : 'views/finance/accounts/debitNote/debitNoteView',
		resolve : {
			deps : [
					'$ocLazyLoad',
					function($ocLazyLoad) {
						return $ocLazyLoad
								.load([ 'js/app/finance/accounts/debitNote/debitNoteCtrl.js' ]);
					} ]
		}
})

   // Manage Cheque Book
        .state('app.finance.accounts.chqBook', {
            abstract : true,
            templateUrl : "views/common.jsp",
            data : {
                title : 'Manage Cheque Book'
            }
        })

        .state('app.finance.accounts.chqBook.list', {
            url : '/hospital/accounts/chqBook/list',
            data : {
                title : 'List'
            },
           /* views : {
                "content@app" : {
                    controller : 'chqBookListCtrl',
                    templateUrl : 'views/hospital/accounts/chqBook/chqBookList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/chqBook/chqBookListCtrl.js' ])
                    }
                }
            }*/
            
            controller : 'chqBookListCtrl',

            templateUrl : 'views/finance/accounts/chqBook/chqBookList',
        		resolve : {
        			deps : [
        					'$ocLazyLoad',
        					function($ocLazyLoad) {
        						return $ocLazyLoad
        								.load([ 'js/app/finance/accounts/chqBook/chqBookListCtrl.js' ]);
        					} ]
        		}
        })

        .state('app.finance.accounts.chqBook.add', {
            url : '/hospital/accounts/chqBook/add',
            data : {
                title : 'List'
            },
           /* views : {
                "content@app" : {
                    controller : 'chqBookAddCtrl',
                    templateUrl : 'views/hospital/accounts/chqBook/chqBookAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/chqBook/chqBookAddCtrl.js' ])
                    }
                }
            }*/
            
            controller : 'chqBookAddCtrl',

            templateUrl : 'views/finance/accounts/chqBook/chqBookAdd',
        		resolve : {
        			deps : [
        					'$ocLazyLoad',
        					function($ocLazyLoad) {
        						return $ocLazyLoad
        								.load([ 'js/app/finance/accounts/chqBook/chqBookAddCtrl.js' ]);
        					} ]
        		}
        })

        .state('app.finance.accounts.chqBook.edit', {
            url : '/hospital/accounts/chqBook/edit/:chqBookId',
            data : {
                title : 'List'
            },
           /* views : {
                "content@app" : {
                    controller : 'chqBookEditCtrl',
                    templateUrl : 'views/hospital/accounts/chqBook/chqBookAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/chqBook/chqBookAddCtrl.js' ])
                    }
                }
            }*/
            
            
            controller : 'chqBookEditCtrl',

            templateUrl : 'views/finance/accounts/chqBook/chqBookAdd',
        		resolve : {
        			deps : [
        					'$ocLazyLoad',
        					function($ocLazyLoad) {
        						return $ocLazyLoad
        								.load([ 'js/app/finance/accounts/chqBook/chqBookAddCtrl.js' ]);
        					} ]
        		}
        })
        
        
        .state('app.finance.accounts.openBalanceUpload', {
            abstract : true,
            templateUrl : "views/common.jsp",
            data : {
                title : 'Opening Balance'
            }
        })
.state('app.finance.accounts.openBalanceUpload.list', {
            url : '/hospital/accounts/openBalanceUpload/list',
            data : {
                title : 'List'
            },
            /*views : {
                "content@app" : {
                    controller : 'openingBalanceListCtrl',
                    templateUrl : 'views/hospital/accounts/openingBalance/openingBalanceUpload',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/openingBalance/openingBalanceUploadCtrl.js' ])
                    }
                }
            }*/
            
            controller : 'openingBalanceListCtrl',

            templateUrl : 'views/finance/accounts/openingBalance/openingBalanceUpload',
        		resolve : {
        			deps : [
        					'$ocLazyLoad',
        					function($ocLazyLoad) {
        						return $ocLazyLoad
        								.load([ 'js/app/finance/accounts/openingBalance/openingBalanceUploadCtrl.js' ]);
        					} ]
        		}
        })
       .state('app.finance.accounts.openBalanceUpload.add', {
            url : '/hospital/accounts/openBalanceUpload/add',
            data : {
                title : 'Add'
            },
           /* views : {
                "content@app" : {
                    controller : 'openBalanceUploadAddCtrl',
                    templateUrl : 'views/hospital/accounts/openingBalance/openingBalanceUploadAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/openingBalance/openingBalanceUploadAddCtrl.js' ])
                    }
                }
            }*/
            
            controller : 'openBalanceUploadAddCtrl',

            templateUrl : 'views/finance/accounts/openingBalance/openingBalanceUploadAdd',
        		resolve : {
        			deps : [
        					'$ocLazyLoad',
        					function($ocLazyLoad) {
        						return $ocLazyLoad
        								.load([ 'js/app/finance/accounts/openingBalance/openingBalanceUploadAddCtrl.js' ]);
        					} ]
        		}
        })   
             .state('app.finance.accounts.openBalanceUpload.edit', {
            url : '/hospital/accounts/openBalanceUpload/edit',
            data : {
                title : 'Edit'
            },
            /*views : {
                "content@app" : {
                    controller : 'openBalanceUploadAddCtrl',
                    templateUrl : 'views/hospital/accounts/openingBalance/openingBalanceUploadAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/openingBalance/openingBalanceUploadAddCtrl.js' ])
                    }
                }
            }*/
            
            controller : 'openBalanceUploadAddCtrl',

            templateUrl : 'views/finance/accounts/openingBalance/openingBalanceUploadAdd',
        		resolve : {
        			deps : [
        					'$ocLazyLoad',
        					function($ocLazyLoad) {
        						return $ocLazyLoad
        								.load([ 'js/app/finance/accounts/openingBalance/openingBalanceUploadAddCtrl.js' ]);
        					} ]
        		}
        })   
        
        
          .state('app.finance.accounts.openBalanceUpload.jvList', {
            url : '/hospital/accounts/openBalanceUpload/jvlist',
            data : {
                title : 'Genarate JV'
            },
          /*  views : {
                "content@app" : {
                    controller : 'openingBalanceListCtrl',
                    templateUrl : 'views/hospital/accounts/openingBalance/openingBalanceUploadJv',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/openingBalance/openingBalanceUploadCtrl.js' ])
                    }
                }
            }
*/        
            controller : 'openingBalanceListCtrl',

            templateUrl : 'views/finance/accounts/openingBalance/openingBalanceUploadJv',
        		resolve : {
        			deps : [
        					'$ocLazyLoad',
        					function($ocLazyLoad) {
        						return $ocLazyLoad
        								.load([ 'js/app/finance/accounts/openingBalance/openingBalanceUploadCtrl.js' ]);
        					} ]
        		}  
          
          })
          // Journal Voucher
          .state('app.finance.accounts.journalvoucher', {
              abstract : true,
              templateUrl : "views/common.jsp",
              data : {
                  title : 'Journal Voucher'
              }
          })

          .state('app.finance.accounts.journalvoucher.list', {
              url : '/hospital/accounts/journalvoucher/list',
              data : {
                  title : 'List'
              },
             /* views : {
                  "content@app" : {
                      controller : 'journalVoucherListCtrl',
                      templateUrl : 'views/hospital/accounts/journalVoucher/journalVoucherList',

                      resolve : {
                          deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/journalVoucher/journalVoucherListCtrl.js' ])
                      }
                  }
              }*/
              
              
              controller : 'journalVoucherListCtrl',

              templateUrl : 'views/finance/accounts/journalVoucher/journalVoucherList',
          		resolve : {
          			deps : [
          					'$ocLazyLoad',
          					function($ocLazyLoad) {
          						return $ocLazyLoad
          								.load([ 'js/app/finance/accounts/journalVoucher/journalVoucherListCtrl.js' ]);
          					} ]
          		} 
          })

          .state('app.finance.accounts.journalvoucher.add', {
              url : '/hospital/accounts/journalvoucher/add',
              data : {
                  title : 'Add'
              },
            /*  views : {
                  "content@app" : {
                      controller : 'journalVoucherAddCtrl',
                      templateUrl : 'views/hospital/accounts/journalVoucher/journalVoucherAdd',

                      resolve : {
                          deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/journalVoucher/journalVoucherListCtrl.js' ])
                      }
                  }
              }*/
              
              controller : 'journalVoucherAddCtrl',

              templateUrl : 'views/finance/accounts/journalVoucher/journalVoucherAdd',
          		resolve : {
          			deps : [
          					'$ocLazyLoad',
          					function($ocLazyLoad) {
          						return $ocLazyLoad
          								.load([ 'js/app/finance/accounts/journalVoucher/journalVoucherListCtrl.js' ]);
          					} ]
          		} 
          })

          .state('app.finance.accounts.journalvoucher.edit', {
              url : '/hospital/accounts/journalvoucher/edit/:jvNumber',
              data : {
                  title : 'Edit'
              },
            /*  views : {
                  "content@app" : {
                      controller : 'journalVoucherAddCtrl',
                      templateUrl : 'views/hospital/accounts/journalVoucher/journalVoucherAdd',

                      resolve : {
                          deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/journalVoucher/journalVoucherListCtrl.js' ])
                      }
                  }
              }*/
              
              controller : 'journalVoucherAddCtrl',

              templateUrl : 'views/finance/accounts/journalVoucher/journalVoucherAdd',
          		resolve : {
          			deps : [
          					'$ocLazyLoad',
          					function($ocLazyLoad) {
          						return $ocLazyLoad
          								.load([ 'js/app/finance/accounts/journalVoucher/journalVoucherListCtrl.js' ]);
          					} ]
          		} 
          })
          .state('app.finance.accounts.journalvoucher.view', {
              url : '/hospital/accounts/journalvoucher/view/:jvNumber',
              data : {
                  title : 'View'
              },
             /* views : {
                  "content@app" : {
                      controller : 'journalVoucherAddCtrl',
                      templateUrl : 'views/hospital/accounts/journalVoucher/journalVoucherView',

                      resolve : {
                          deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/journalVoucher/journalVoucherListCtrl.js' ])
                      }
                  }
              }*/
              
              controller : 'journalVoucherAddCtrl',

              templateUrl : 'views/finance/accounts/journalVoucher/journalVoucherView',
          		resolve : {
          			deps : [
          					'$ocLazyLoad',
          					function($ocLazyLoad) {
          						return $ocLazyLoad
          								.load([ 'js/app/finance/accounts/journalVoucher/journalVoucherListCtrl.js' ]);
          					} ]
          		} 
          })
           
          .state('app.finance.accounts.journalvoucher.copyJournalVoucher', {
              url : '/hospital/accounts/journalvoucher/copyJournalVoucher/:jvNumber',
              data : {
                  title : 'Add'
              },
             /* views : {
                  "content@app" : {
                      controller : 'journalVoucherAddCtrl',
                      templateUrl : 'views/hospital/accounts/journalVoucher/journalVoucherAdd',

                      resolve : {
                          deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/journalVoucher/journalVoucherListCtrl.js' ])
                      }
                  }
              }*/
              
              controller : 'journalVoucherAddCtrl',

              templateUrl : 'views/finance/accounts/journalVoucher/journalVoucherAdd',
          		resolve : {
          			deps : [
          					'$ocLazyLoad',
          					function($ocLazyLoad) {
          						return $ocLazyLoad
          								.load([ 'js/app/finance/accounts/journalVoucher/journalVoucherListCtrl.js' ]);
          					} ]
          		} 
          })
          
          .state('app.finance.accounts.creditNote', {
              abstract : true,
              templateUrl : "views/common.jsp",
              data : {
                  title : 'Credit Note'
              }
          })

          .state('app.finance.accounts.creditNote.list', {
              url : '/hospital/accounts/creditNote/list',
              data : {
                  title : 'List'
              },
             /* views : {
                  "content@app" : {
                      controller : 'creditNoteListCtrl',
                      templateUrl : 'views/hospital/accounts/creditNote/creditNoteList',

                      resolve : {
                          deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/creditNote/creditNoteListCtrl.js' ])
                      }
                  }
              }*/
              
              controller : 'creditNoteListCtrl',

              templateUrl : 'views/finance/accounts/creditNote/creditNoteList',
          		resolve : {
          			deps : [
          					'$ocLazyLoad',
          					function($ocLazyLoad) {
          						return $ocLazyLoad
          								.load([ 'js/app/finance/accounts/creditNote/creditNoteListCtrl.js' ]);
          					} ]
          		} 
          })

          .state('app.finance.accounts.creditNote.add', {
              url : '/hospital/accounts/creditNote/add',
              data : {
                  title : 'Add'
              },
           /*   views : {
                  "content@app" : {
                      controller : 'creditNoteAddCtrl',
                      templateUrl : 'views/hospital/accounts/creditNote/creditNoteAdd',

                      resolve : {
                          deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/creditNote/creditNoteAddCtrl.js' ])
                      }
                  }
              }*/
              
              
              
              controller : 'creditNoteAddCtrl',

              templateUrl : 'views/finance/accounts/creditNote/creditNoteAdd',
          		resolve : {
          			deps : [
          					'$ocLazyLoad',
          					function($ocLazyLoad) {
          						return $ocLazyLoad
          								.load([ 'js/app/finance/accounts/creditNote/creditNoteAddCtrl.js' ]);
          					} ]
          		} 
          }).state('app.finance.accounts.creditNote.edit', {
              url : '/hospital/accounts/creditNote/edit/:creditNoteCode',
              data : {
                  title : 'Edit'
              },
             /* views : {
                  "content@app" : {
                      controller : 'creditNoteAddCtrl',
                      templateUrl : 'views/hospital/accounts/creditNote/creditNoteAdd',

                      resolve : {
                          deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/creditNote/creditNoteAddCtrl.js' ])
                      }
                  }
              }*/
              
              controller : 'creditNoteAddCtrl',

              templateUrl : 'views/finance/accounts/creditNote/creditNoteAdd',
          		resolve : {
          			deps : [
          					'$ocLazyLoad',
          					function($ocLazyLoad) {
          						return $ocLazyLoad
          								.load([ 'js/app/finance/accounts/creditNote/creditNoteAddCtrl.js' ]);
          					} ]
          		} 
          })
           .state('app.finance.accounts.creditNote.view', {
              url : '/hospital/accounts/creditNote/view/:creditNoteCode',
              data : {
                  title : 'View'
              },
             /* views : {
                  "content@app" : {
                      controller : 'creditNoteAddCtrl',
                      templateUrl : 'views/hospital/accounts/creditNote/creditNoteView',
                      resolve : {
                          deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/creditNote/creditNoteAddCtrl.js' ])
                      }
                  }
              }*/
              
              controller : 'creditNoteAddCtrl',

              templateUrl : 'views/finance/accounts/creditNote/creditNoteView',
          		resolve : {
          			deps : [
          					'$ocLazyLoad',
          					function($ocLazyLoad) {
          						return $ocLazyLoad
          								.load([ 'js/app/finance/accounts/creditNote/creditNoteAddCtrl.js' ]);
          					} ]
          		} 
          })

        // CREDIT NOTE APPROVAL
        .state('app.finance.accounts.creditNoteApproval', {
            abstract : true,
            templateUrl : "views/common.jsp",
            data : {
                title : 'Credit Note Approval'
            }
        })

        .state('app.finance.accounts.creditNoteApproval.list', {
            url : '/hospital/accounts/creditNoteApproval/list',
            data : {
                title : 'List'
            },
           /* views : {
                "content@app" : {
                    controller : 'creditNoteApprovalListCtrl',
                    templateUrl : 'views/hospital/accounts/creditNoteApproval/creditNoteApprovalList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/creditNoteApproval/creditNoteApprovalCtrl.js' ])
                    }
                }
            }*/
            
            controller : 'creditNoteApprovalListCtrl',

            templateUrl : 'views/finance/accounts/creditNoteApproval/creditNoteApprovalList',
        		resolve : {
        			deps : [
        					'$ocLazyLoad',
        					function($ocLazyLoad) {
        						return $ocLazyLoad
        								.load([ 'js/app/finance/accounts/creditNoteApproval/creditNoteApprovalCtrl.js' ]);
        					} ]
        		} 
        })

        .state('app.finance.accounts.creditNoteApproval.approval', {
            url : '/hospital/accounts/creditNoteApproval/approval/:creditNoteCode',
            data : {
                title : 'Approval'
            },
           /* views : {
                "content@app" : {
                    controller : 'creditNoteApprovalCtrl',
                    templateUrl : 'views/hospital/accounts/creditNoteApproval/creditNoteApprovalForm',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/creditNoteApproval/creditNoteApprovalCtrl.js' ])
                    }
                }
            }*/
            
            controller : 'creditNoteApprovalCtrl',

            templateUrl : 'views/finance/accounts/creditNoteApproval/creditNoteApprovalForm',
        		resolve : {
        			deps : [
        					'$ocLazyLoad',
        					function($ocLazyLoad) {
        						return $ocLazyLoad
        								.load([ 'js/app/finance/accounts/creditNoteApproval/creditNoteApprovalCtrl.js' ]);
        					} ]
        		} 
        })   
        
        
           // Payment History
        .state('app.finance.accounts.paymentHistory', {
            abstract : true,
            templateUrl : "views/common.jsp",
            data : {
                title : 'Payment History'
            }
        }).state('app.finance.accounts.paymentHistory.list', {
            url : '/hospital/accounts/paymentHistory/list',
            data : {
                title : 'List'
            },
           /* views : {
                "content@app" : {
                    controller : 'paymentHistoryCtrl',
                    templateUrl : 'views/hospital/accounts/pendingPaymentRpt/paymentHistoryList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/pendingPaymentRpt/paymentHistoryCtrl.js' ])
                    }
                }
            }*/
            
            controller : 'paymentHistoryCtrl',

            templateUrl : 'views/finance/accounts/pendingPaymentRpt/paymentHistoryList',
        		resolve : {
        			deps : [
        					'$ocLazyLoad',
        					function($ocLazyLoad) {
        						return $ocLazyLoad
        								.load([ 'js/app/finance/accounts/pendingPaymentRpt/paymentHistoryCtrl.js' ]);
        					} ]
        		} 
        })
        
        .state('app.finance.accounts.paymentInformation', {
            abstract : true,
            templateUrl : "views/common.jsp",

            data : {
                title : 'Payment Information'
            }
        })

        .state('app.finance.accounts.paymentInformation.list', {
            url : '/hospital/accounts/paymentInformation/paymentInformationList',
            data : {
                title : 'List'
            },
           /* views : {
                "content@app" : {
                    controller : 'paymentInformationList',
                    templateUrl : 'views/hospital/accounts/paymentInformation/paymentInformationList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/paymentInformation/paymentInformationList.js' ])
                    }
                }
            }*/
            
            controller : 'paymentInformationList',

            templateUrl : 'views/finance/accounts/paymentInformation/paymentInformationList',
        		resolve : {
        			deps : [
        					'$ocLazyLoad',
        					function($ocLazyLoad) {
        						return $ocLazyLoad
        								.load([ 'js/app/finance/accounts/paymentInformation/paymentInformationList.js' ]);
        					} ]
        		} 
        
        })

        .state('app.finance.accounts.paymentInformation.add', {
            url : '/hospital/accounts/paymentInformation/paymentInformationAdd',
            data : {
                title : 'Add'
            },
          /*  views : {
                "content@app" : {
                    controller : 'paymentInformationAdd',
                    templateUrl : 'views/hospital/accounts/paymentInformation/paymentInformationAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/paymentInformation/paymentInformationAdd.js' ])
                    }
                }
            }*/
            
            controller : 'paymentInformationAdd',

            templateUrl : 'views/finance/accounts/paymentInformation/paymentInformationAdd',
        		resolve : {
        			deps : [
        					'$ocLazyLoad',
        					function($ocLazyLoad) {
        						return $ocLazyLoad
        								.load([ 'js/app/finance/accounts/paymentInformation/paymentInformationAdd.js' ]);
        					} ]
        		} 
        })

        .state('app.finance.accounts.paymentInformation.edit', {
            url : '/hospital/accounts/paymentInformation/paymentInformationEdit',
            data : {
                title : 'Edit'
            },
           /* views : {
                "content@app" : {
                    controller : 'paymentInformationAdd',
                    templateUrl : 'views/hospital/accounts/paymentInformation/paymentInformationAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/paymentInformation/paymentInformationAdd.js' ])
                    }
                }
            }
*/      
            controller : 'paymentInformationAdd',

            templateUrl : 'views/finance/accounts/paymentInformation/paymentInformationAdd',
        		resolve : {
        			deps : [
        					'$ocLazyLoad',
        					function($ocLazyLoad) {
        						return $ocLazyLoad
        								.load([ 'js/app/finance/accounts/paymentInformation/paymentInformationAdd.js' ]);
        					} ]
        		}     
        })
        
         .state('app.finance.accounts.paymentInformation.draft', {
            url : '/hospital/accounts/paymentInformation/paymentInformationDraftList',
            data : {
                title : 'Draft List'
            },
           /* views : {
                "content@app" : {
                    controller : 'paymentInformationDraftList',
                    templateUrl : 'views/hospital/accounts/paymentInformation/paymentInformationDraftList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/paymentInformation/paymentInformationDraftList.js' ])
                    }
                }
            }*/
            
            controller : 'paymentInformationDraftList',

            templateUrl : 'views/finance/accounts/paymentInformation/paymentInformationDraftList',
        		resolve : {
        			deps : [
        					'$ocLazyLoad',
        					function($ocLazyLoad) {
        						return $ocLazyLoad
        								.load([ 'js/app/finance/accounts/paymentInformation/paymentInformationDraftList.js' ]);
        					} ]
        		} 
        })


        .state('app.finance.accounts.paymentOrder', {
            abstract : true,
            templateUrl : "views/common.jsp",
            data : {
                title : 'Payment Order'
            }
        })

        .state('app.finance.accounts.paymentOrder.list', {
            url : '/hospital/accounts/paymentOrder/paymentOrderList',
            data : {
                title : 'List'
            },
           /* views : {
                "content@app" : {
                    controller : 'paymentOrderList',
                    templateUrl : 'views/hospital/accounts/paymentOrder/paymentOrderList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/paymentOrder/paymentOrderList.js' ])
                    }
                }
            }*/
            
            controller : 'paymentOrderList',

            templateUrl : 'views/finance/accounts/paymentOrder/paymentOrderList',
        		resolve : {
        			deps : [
        					'$ocLazyLoad',
        					function($ocLazyLoad) {
        						return $ocLazyLoad
        								.load([ 'js/app/finance/accounts/paymentOrder/paymentOrderList.js' ]);
        					} ]
        		} 
        })
        .state('app.finance.accounts.TDSReport', {
            abstract : true,
            templateUrl : "views/common.jsp",
            data : {
                title : 'Tds Reports'
            }
        })

        .state('app.finance.accounts.TDSReport.list', {
            url : '/hospital/accounts/tdsReport/tdsReportList',
            data : {
                title : 'List'
            },
          /*  views : {
                "content@app" : {
                    controller : 'TDSReportListCtrl',
                    templateUrl : 'views/hospital/accounts/TDSReport/TDSReportList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/TDSReport/TDSReportList.js' ])
                    }
                }
            }*/
            
            controller : 'TDSReportListCtrl',

            templateUrl : 'views/finance/accounts/TDSReport/TDSReportList',
        		resolve : {
        			deps : [
        					'$ocLazyLoad',
        					function($ocLazyLoad) {
        						return $ocLazyLoad
        								.load([ 'js/app/finance/accounts/TDSReport/TDSReportList.js' ]);
        					} ]
        		} 
        })

        .state('app.finance.accounts.bankbook', {
            abstract : true,
            templateUrl : "views/common.jsp",
            data : {
                title : 'Bank Book'
            }
        })

        .state('app.finance.accounts.bankbook.list', {
            url : '/hospital/accounts/bankbook/list',
            data : {
                title : 'Bank Book List'
            },
          /*  views : {
                "content@app" : {
                    controller : 'bankbookCtrl',
                    templateUrl : 'views/hospital/accounts/cashandbankbook/bankbook',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/cashandbankbook/bankbook.js' ])
                    }
                }
            }*/
            
            controller : 'bankbookCtrl',

            templateUrl : 'views/finance/accounts/cashandbankbook/bankbook',
        		resolve : {
        			deps : [
        					'$ocLazyLoad',
        					function($ocLazyLoad) {
        						return $ocLazyLoad
        								.load([ 'js/app/finance/accounts/cashandbankbook/bankbook.js' ]);
        					} ]
        		} 
        })
 
        .state('app.finance.accounts.cashbook', {
            abstract : true,
            templateUrl : "views/common.jsp",
            data : {
                title : 'Cash Book'
            }
        })

        .state('app.finance.accounts.cashbook.list', {
            url : '/hospital/accounts/cashbook/list',
            data : {
                title : 'Cash Book List'
            },
           /* views : {
                "content@app" : {
                    controller : 'cashbookCtrl',
                    templateUrl : 'views/hospital/accounts/cashandbankbook/cashbook',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/cashandbankbook/cashbook.js' ])
                    }
                }
            }*/
            
            controller : 'cashbookCtrl',

            templateUrl : 'views/finance/accounts/cashandbankbook/cashbook',
        		resolve : {
        			deps : [
        					'$ocLazyLoad',
        					function($ocLazyLoad) {
        						return $ocLazyLoad
        								.load([ 'js/app/finance/accounts/cashandbankbook/cashbook.js' ]);
        					} ]
        		} 
        })
        
         .state('app.finance.accounts.trialBalance', {
            abstract : true,
            templateUrl : "views/common.jsp",
            data : {
                title : 'Trial Balance'
            }
        })

        .state('app.finance.accounts.trialBalance.list', {
            url : '/hospital/accounts/trialBalance/view',
            data : {
                title : 'Trial Balance'
            },
          //  views : {
           /*     "content@app" : {
                    controller : 'trialBalanceCtrl',
                    templateUrl : 'views/hospital/accounts/trialBalance/trialBalance',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/trialBalance/trialBalanceCtrl.js' ])
                    }
                }
            }*/
            
            controller : 'trialBalanceCtrl',

            templateUrl : 'views/finance/accounts/trialBalance/trialBalance',
        		resolve : {
        			deps : [
        					'$ocLazyLoad',
        					function($ocLazyLoad) {
        						return $ocLazyLoad
        								.load([ 'js/app/finance/accounts/trialBalance/trialBalanceCtrl.js' ]);
        					} ]
        		} 
        })
        
          // BALANCE SHEET
        .state('app.finance.accounts.balancesheet', {
            abstract : true,
            templateUrl : "views/common.jsp",
            data : {
                title : 'Balance Sheet'
            }
        })

        .state('app.finance.accounts.balancesheet.list', {
            url : '/hospital/accounts/balancesheet/list',
            data : {
                title : 'List'
            },
           /* views : {
                "content@app" : {
                    controller : 'balanceSheetListCtrl',
                    templateUrl : 'views/hospital/accounts/balanceSheet/balanceSheetList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/balanceSheet/balanceSheetListCtrl.js' ])
                    }
                }
            }*/
            
            controller : 'balanceSheetListCtrl',

            templateUrl : 'views/finance/accounts/balanceSheet/balanceSheetList',
        		resolve : {
        			deps : [
        					'$ocLazyLoad',
        					function($ocLazyLoad) {
        						return $ocLazyLoad
        								.load([ 'js/app/finance/accounts/balanceSheet/balanceSheetListCtrl.js' ]);
        					} ]
        		} 
        })

        
        

        .state('app.finance.accounts.accountclosingopening', {
            abstract : true,
            templateUrl : "views/common.jsp",
            data : {
                title : 'Closing Accounting Period'
            }
        }).state('app.finance.accounts.accountclosingopening.list', {
            url : '/hospital/accounts/accountclosingopening/list',
            data : {

            },
           /* views : {
                "content@app" : {
                    controller : 'accountClosingOpeningListCtrl',
                    templateUrl : 'views/hospital/accounts/accountClosingOpening/accountClosingOpeningList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/accountClosingOpening/accountClosingOpeningAddCtrl.js' ])
                    }
                }
            }*/
            controller : 'accountClosingOpeningListCtrl',

            templateUrl : 'views/finance/accounts/accountClosingOpening/accountClosingOpeningList',
        		resolve : {
        			deps : [
        					'$ocLazyLoad',
        					function($ocLazyLoad) {
        						return $ocLazyLoad
        								.load([ 'js/app/finance/accounts/accountClosingOpening/accountClosingOpeningAddCtrl.js' ]);
        					} ]
        		}  
            
            
        }).state('app.finance.accounts.accountclosingopening.add', {
            url : '/hospital/accounts/accountclosingopening/add',
            data : {

            },
         /*   views : {
                "content@app" : {
                    controller : 'accountClosingOpeningAddCtrl',
                    templateUrl : 'views/hospital/accounts/accountClosingOpening/accountClosingOpeningAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/accountClosingOpening/accountClosingOpeningAddCtrl.js' ])
                    }
                }
            }*/
            
            controller : 'accountClosingOpeningAddCtrl',

            templateUrl : 'views/finance/accounts/accountClosingOpening/accountClosingOpeningAdd',
        		resolve : {
        			deps : [
        					'$ocLazyLoad',
        					function($ocLazyLoad) {
        						return $ocLazyLoad
        								.load([ 'js/app/finance/accounts/accountClosingOpening/accountClosingOpeningAddCtrl.js' ]);
        					} ]
        		} 
        })
        //edit
        .state('app.finance.accounts.accountclosingopening.edit', {
            url : '/hospital/accounts/accountclosingopening/edit',
            data : {

            },
         /*   views : {
                "content@app" : {
                    controller : 'accountClosingOpeningAddCtrl',
                    templateUrl : 'views/hospital/accounts/accountClosingOpening/accountClosingOpeningAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/accountClosingOpening/accountClosingOpeningAddCtrl.js' ])
                    }
                }
            }*/
            controller : 'accountClosingOpeningAddCtrl',

            templateUrl : 'views/finance/accounts/accountClosingOpening/accountClosingOpeningAdd',
        		resolve : {
        			deps : [
        					'$ocLazyLoad',
        					function($ocLazyLoad) {
        						return $ocLazyLoad
        								.load([ 'js/app/finance/accounts/accountClosingOpening/accountClosingOpeningAddCtrl.js' ]);
        					} ]
        		} 
        
        })
        
        
         .state('app.finance.accounts.profitandloss', {
            abstract : true,
            templateUrl : "views/common.jsp",
            data : {
                title : 'Income and Expenditure'
            }
        })

          .state('app.finance.accounts.profitandloss.searchlist', {
            url : '/hospital/accounts/profitandloss/searchlist',
            data : {
                title : ''
            },
            /*views : {
                "content@app" : {
                    controller : 'profitAndLossController',
                    templateUrl : 'views/hospital/accounts/profitandloss/profitandloss',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/profitandloss/profitandlossCtrl.js' ])
                    }
                }
            }*/
            
            controller : 'profitAndLossController',

            templateUrl : 'views/finance/accounts/profitandloss/profitandloss',
        		resolve : {
        			deps : [
        					'$ocLazyLoad',
        					function($ocLazyLoad) {
        						return $ocLazyLoad
        								.load([ 'js/app/finance/accounts/profitandloss/profitandlossCtrl.js' ]);
        					} ]
        		} 
        })

        .state('app.finance.accounts.profit&Loss.list', {
            url : '/hospital/accounts/profit&Loss/list',
            data : {
                title : 'List'
            },
          /*  views : {
                "content@app" : {
                    controller : 'profitLossListCtrl',
                    templateUrl : 'views/hospital/accounts/profit&Loss/profitLossList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/profit&Loss/profitLossListCtrl.js' ])
                    }
                }
            }*/
            
            controller : 'profitLossListCtrl',

            templateUrl : 'views/finance/accounts/profit&Loss/profitLossList',
        		resolve : {
        			deps : [
        					'$ocLazyLoad',
        					function($ocLazyLoad) {
        						return $ocLazyLoad
        								.load([ 'js/app/finance/accounts/profit&Loss/profitLossListCtrl.js' ]);
        					} ]
        		} 
        })
        
        
          .state('app.finance.accounts.chequeStatusReport', {
            abstract : true,
            templateUrl : "views/common.jsp",
            data : {
                title : 'chequeStatusReport'
            }
        })

        .state('app.finance.accounts.chequeStatusReport.list', {
            url : '/hospital/accounts/chequeStatusReport/list',
            data : {
                title : 'List'
            },
          /*  views : {
                "content@app" : {
                    controller : 'chequeStatusReportCtrl',
                    templateUrl : 'views/hospital/accounts/chequeStatusReport/chequeStatusReport',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/chequeStatusReport/chequeStatusReportCtrl.js' ])
                    }
                }
            }
       */ 
            controller : 'chequeStatusReportCtrl',

            templateUrl : 'views/finance/accounts/chequeStatusReport/chequeStatusReport',
        		resolve : {
        			deps : [
        					'$ocLazyLoad',
        					function($ocLazyLoad) {
        						return $ocLazyLoad
        								.load([ 'js/app/finance/accounts/chequeStatusReport/chequeStatusReportCtrl.js' ]);
        					} ]
        		}     
        
        })

        // Pending Payment Report
        .state('app.finance.accounts.pendingPaymentRpt', {
            abstract : true,
            templateUrl : "views/common.jsp",
            data : {
                title : 'Pending Payment Report'
            }
        }).state('app.finance.accounts.pendingPaymentRpt.list', {
            url : '/hospital/accounts/pendingPaymentRpt/list',
            data : {
                title : 'List'
            },
          /*  views : {
                "content@app" : {
                    controller : 'pendingPaymentReportListCtrl',
                    templateUrl : 'views/hospital/accounts/pendingPaymentRpt/pendingPaymentReportList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/pendingPaymentRpt/pendingPaymentRptCtrl.js' ])
                    }
                }
            }*/
            controller : 'pendingPaymentReportListCtrl',

            templateUrl : 'views/finance/accounts/pendingPaymentRpt/pendingPaymentReportList',
        		resolve : {
        			deps : [
        					'$ocLazyLoad',
        					function($ocLazyLoad) {
        						return $ocLazyLoad
        								.load([ 'js/app/finance/accounts/pendingPaymentRpt/pendingPaymentRptCtrl.js' ]);
        					} ]
        		}    
            
            
            
        })
        
        
        
        .state('app.finance.accounts.closingAccountPeriod', {
            abstract : true,
            templateUrl : "views/common.jsp",
            data : {
                title : 'Account Year Closing & Opening'
            }
        }).state('app.finance.accounts.closingAccountPeriod.list', {
            url : '/hospital/accounts/closingAccountPeriod/list',
            data : {

            },
           /* views : {
                "content@app" : {
                    controller : 'closingAccountPeriodListCtrl',
                    templateUrl : 'views/hospital/accounts/closingAccountPeriod/closingAccountPeriodList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/closingAccountPeriod/closingAccountPeriodListCtrl.js' ])
                    }
                }
            }*/
            controller : 'closingAccountPeriodListCtrl',

            templateUrl : 'views/finance/accounts/closingAccountPeriod/closingAccountPeriodList',
        		resolve : {
        			deps : [
        					'$ocLazyLoad',
        					function($ocLazyLoad) {
        						return $ocLazyLoad
        								.load([ 'js/app/finance/accounts/closingAccountPeriod/closingAccountPeriodListCtrl.js' ]);
        					} ]
        		}    
            
            
            
        }).state('app.finance.accounts.closingAccountPeriod.add', {
            url : '/hospital/accounts/closingAccountPeriod/add',
            data : {

            },
         /*   views : {
                "content@app" : {
                    controller : 'closingAccountPeriodAddCtrl',
                    templateUrl : 'views/hospital/accounts/closingAccountPeriod/closingAccountPeriodAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/closingAccountPeriod/closingAccountPeriodAddCtrl.js' ])
                    }
                }
            }*/
            
            controller : 'closingAccountPeriodAddCtrl',

            templateUrl : 'views/finance/accounts/closingAccountPeriod/closingAccountPeriodAdd',
        		resolve : {
        			deps : [
        					'$ocLazyLoad',
        					function($ocLazyLoad) {
        						return $ocLazyLoad
        								.load([ 'js/app/finance/accounts/closingAccountPeriod/closingAccountPeriodAddCtrl.js' ]);
        					} ]
        		}    
            
        })
        //edit
        .state('app.finance.accounts.closingAccountPeriod.edit', {
            url : '/hospital/accounts/closingAccountPeriod/edit',
            data : {

            },
          /*  views : {
                "content@app" : {
                    controller : 'closingAccountPeriodAddCtrl',
                    templateUrl : 'views/hospital/accounts/closingAccountPeriod/closingAccountPeriodAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/closingAccountPeriod/closingAccountPeriodAddCtrl.js' ])
                    }
                }
            }*/
            
            
            controller : 'closingAccountPeriodAddCtrl',

            templateUrl : 'views/finance/accounts/closingAccountPeriod/closingAccountPeriodAdd',
        		resolve : {
        			deps : [
        					'$ocLazyLoad',
        					function($ocLazyLoad) {
        						return $ocLazyLoad
        								.load([ 'js/app/finance/accounts/closingAccountPeriod/closingAccountPeriodAddCtrl.js' ]);
        					} ]
        		}    
        })

         .state('app.finance.accounts.statementAccounts', {
            abstract : true,
            templateUrl : "views/common.jsp",
            data : {
                title : 'Statement Of Accounts'
            }
        })

        .state('app.finance.accounts.statementAccounts.list', {
            url : '/hospital/accounts/statementAccounts/list',
            data : {
                title : 'List'
            },
           /* views : {
                "content@app" : {
                    controller : 'soaCustomerCtrl',
                    templateUrl : 'views/hospital/accounts/soaCustomer/soaCustomer',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/soaCustomer/soaCustomerCtrl.js' ])
                    }
                }
            }*/
            controller : 'soaCustomerCtrl',

            templateUrl : 'views/finance/accounts/soaCustomer/soaCustomer',
        		resolve : {
        			deps : [
        					'$ocLazyLoad',
        					function($ocLazyLoad) {
        						return $ocLazyLoad
        								.load([ 'js/app/finance/accounts/soaCustomer/soaCustomerCtrl.js' ]);
        					} ]
        		}  
            
        })  
        
        
        .state('app.finance.accounts.accountPayableAgewise', {
            abstract : true,
            templateUrl : "views/common.jsp",
            data : {
                title : 'Accounts Payable'
            }
        })

        .state('app.finance.accounts.accountPayableAgewise.view', {
            url : '/hospital/accounts/accountspayable/view',
            data : {
                title : 'Accounts Payable'
            },
           /* views : {
                "content@app" : {
                    controller : 'accountspayableCtrl',
                    templateUrl : 'views/hospital/accounts/accountspayable/accountspayable',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/accountspayable/accountspayable.js' ])
                    }
                }
            }*/
            
            
            controller : 'accountspayableCtrl',

            templateUrl : 'views/finance/accounts/accountspayable/accountspayable',
        		resolve : {
        			deps : [
        					'$ocLazyLoad',
        					function($ocLazyLoad) {
        						return $ocLazyLoad
        								.load([ 'js/app/finance/accounts/accountspayable/accountspayable.js' ]);
        					} ]
        		}  
            
        })
        
        
          // Accounts receivable

        .state('app.finance.accounts.accountReceivable', {
            abstract : true,
            templateUrl : "views/common.jsp",
            data : {
                title : 'Accounts Receivable'
            }
        })

        .state('app.finance.accounts.accountReceivable.view', {
            url : '/hospital/accounts/accountReceivable/view',
            data : {
                title : 'Accounts Receivable'
            },
          /*  views : {
                "content@app" : {
                    controller : 'accountsRecivableCtrl',
                    templateUrl : 'views/hospital/accounts/accountReceivable/accountReceivable',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/accountReceivable/accountReceivable.js' ])
                    }
                }
            }*/
            
            
            controller : 'accountsRecivableCtrl',

            templateUrl : 'views/finance/accounts/accountReceivable/accountReceivable',
        		resolve : {
        			deps : [
        					'$ocLazyLoad',
        					function($ocLazyLoad) {
        						return $ocLazyLoad
        								.load([ 'js/app/finance/accounts/accountReceivable/accountReceivable.js' ]);
        					} ]
        		}  
        })

        .state('app.finance.accounts.manageitem', {
            abstract : true,
            templateUrl : "views/common.jsp",
            data : {
                title : 'Manage Item'
            }
        })

        .state('app.finance.accounts.manageitem.list', {
            url : '/hospital/purchase/manageitem/list',
            data : {
                title : 'List'
            },
            
            controller : 'manageItemListCtrl',

            templateUrl : 'views/finance/accounts/manageItem/manageItemList',
        		resolve : {
        			deps : [
        					'$ocLazyLoad',
        					function($ocLazyLoad) {
        						return $ocLazyLoad
        								.load([ 'js/app/finance/accounts/manageItem/manageItemCtrl.js' ]);
        					} ]
        		} 
            
            /*views : {
                "content@app" : {
                    controller : 'manageItemListCtrl',
                    templateUrl : 'views/hospital/purchase/manageItem/manageItemList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/purchase/manageItem/manageItemCtrl.js' ])
                    }
                }
            }*/
        })

        .state('app.finance.accounts.manageitem.add', {
            url : '/hospital/purchase/manageitem/add',
            data : {
                title : 'Add'
            },
            
            
            controller : 'manageItemAddCtrl',

            templateUrl : 'views/finance/accounts/manageItem/manageItemAdd',
        		resolve : {
        			deps : [
        					'$ocLazyLoad',
        					function($ocLazyLoad) {
        						return $ocLazyLoad
        								.load([ 'js/app/finance/accounts/manageItem/manageItemAddCtrl.js' ]);
        					} ]
        		} 
           /* views : {
                "content@app" : {
                    controller : 'manageItemAddCtrl',
                    templateUrl : 'views/hospital/purchase/manageItem/manageItemAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/purchase/manageItem/manageItemAddCtrl.js' ])
                    }
                }
            }*/
        })

        .state('app.finance.accounts.manageitem.edit', {
            url : '/hospital/purchase/manageitem/edit/:itemId',
            data : {
                title : 'Edit'
            },params: {
                itemId: null,
            },
           /* views : {
                "content@app" : {
                    controller : 'manageItemEditCtrl',
                    templateUrl : 'views/hospital/purchase/manageItem/manageItemAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/purchase/manageItem/manageItemAddCtrl.js' ])
                    }
                }
            }*/
            
            controller : 'manageItemEditCtrl',

            templateUrl : 'views/finance/accounts/manageItem/manageItemAdd',
        		resolve : {
        			deps : [
        					'$ocLazyLoad',
        					function($ocLazyLoad) {
        						return $ocLazyLoad
        								.load([ 'js/app/finance/accounts/manageItem/manageItemAddCtrl.js' ]);
        					} ]
        		} 
        })

        .state('app.finance.accounts.manageitem.addVendor', {
            url : '/hospital/purchase/manageitem/addVendor',
            data : {
                title : 'Add'
            },
           /* views : {
                "content@app" : {
                    controller : 'manageItemAddVendorCtrl',
                    templateUrl : 'views/hospital/purchase/manageItem/manageItemAddVendor',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/purchase/manageItem/manageItemAddCtrl.js' ])
                    }
                }
            }*/
            
            
            controller : 'manageItemAddVendorCtrl',

            templateUrl : 'views/finance/accounts/manageItem/manageItemAddVendor',
        		resolve : {
        			deps : [
        					'$ocLazyLoad',
        					function($ocLazyLoad) {
        						return $ocLazyLoad
        								.load([ 'js/app/finance/accounts/manageItem/manageItemAddCtrl.js' ]);
        					} ]
        		} 
        })

 
        
        
        
         .state('app.finance.inventory.uomcategory', {
             abstract : true,
             templateUrl : "views/common.jsp",
             data : {
                 title : 'UOM Category'
             }
	 
         })

        .state('app.finance.inventory.uomcategory.list', {
            url : '/hospital/inventory/uomcategory/list',
            data : {
                title : 'List'
            },
            
            controller : 'UOMCategoryCtrl',
            templateUrl : 'views/inventory/uomCategory/uomCategoryList',
        		resolve : {
        			deps : [
        					'$ocLazyLoad',
        					function($ocLazyLoad) {
        						return $ocLazyLoad
        								.load([ 'js/app/finance/inventory/manageUOM/manageUOMCtrl.js' ]);
        					} ]
        		} 
            /*views : {
                "content@app" : {
                    controller : 'UOMCategoryCtrl',
                    templateUrl : 'views/hospital/inventory/uomCategory/uomCategoryList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/inventory/uomcategory/UOMCategoryCtrl.js' ])
                    }
                }
            }*/
        })
        
        .state('app.finance.inventory.uomcategory.add', {
            url : '/hospital/inventory/uomcategory/add',
            data : {
                title : 'List'
            },
            /*views : {
                "content@app" : {
                    controller : 'UOMCategoryCtrl',
                    templateUrl : 'views/hospital/inventory/uomCategory/UOMCategoryAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/inventory/uomcategory/UOMCategoryCtrl.js' ])
                    }
                }
            }*/
            
            controller : 'UOMCategoryCtrl',

            templateUrl : 'views/inventory/uomCategory/UOMCategoryAdd',
        		resolve : {
        			deps : [
        					'$ocLazyLoad',
        					function($ocLazyLoad) {
        						return $ocLazyLoad
        								.load([ 'js/app/finance/inventory/manageUOM/manageUOMCtrl.js' ]);
        					} ]
        		} 
        })

        .state('app.finance.inventory.uomcategory.edit', {
            url : '/hospital/inventory/uomcategory/edit/:uomId',
            data : {
                title : 'Edit'
            },
            /*views : {
                "content@app" : {
                    controller : 'UOMCategoryEditCtrl',
                    templateUrl : 'views/hospital/inventory/uomCategory/UOMCategoryAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/inventory/uomcategory/UOMCategoryCtrl.js' ])
                    }
                }
            }*/
            
            controller : 'UOMCategoryEditCtrl',

            templateUrl : 'views/inventory/uomCategory/UOMCategoryAdd',
        		resolve : {
        			deps : [
        					'$ocLazyLoad',
        					function($ocLazyLoad) {
        						return $ocLazyLoad
        								.load([ 'js/app/finance/inventory/manageUOM/manageUOMCtrl.js' ]);
        					} ]
        		}
        })


         .state('app.finance.inventory.manageUOM', {
           
        	 
        	  abstract : true,
              templateUrl : "views/common.jsp",
              data : {
                  title : 'Manage UOM'
              }
        })

        .state('app.finance.inventory.manageUOM.list', {
            url : '/hospital/inventory/manageUOM/list',
            data : {
                title : 'List'
            },
            /*views : {
                "content@app" : {
                    controller : 'manageUmCtrl',
                    templateUrl : 'views/finance/inventory/manageUOM/manageUOMList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/inventory/manageUOM/UOMCategoryCtrl.js' ])
                    }
                }
            }*/
            
            controller : 'manageUmCtrl',

            templateUrl : 'views/finance/inventory/manageUOM/manageUOMList',
        		resolve : {
        			deps : [
        					'$ocLazyLoad',
        					function($ocLazyLoad) {
        						return $ocLazyLoad
        								.load([ 'js/app/finance/inventory/manageUOM/UOMCategoryCtrl.js' ]);
        					} ]
        		}
            
            
        })
        
        /** ********** Item Properties Starts ************* */

        .state('app.finance.inventory.itemproperties', {
           
        	  abstract : true,
              templateUrl : "views/common.jsp",
              data : {
                  title : 'Manage Item Properties'
              }
        })

        .state('app.finance.inventory.itemproperties.list', {
            url : '/hospital/inventory/itemproperties/list',
            data : {
                title : 'List'
            }, 
            controller : 'itemPropertiesListCtrl',

            templateUrl : 'views/finance/inventory/itemproperties/itemPropertiesList',
        		resolve : {
        			deps : [
        					'$ocLazyLoad',
        					function($ocLazyLoad) {
        						return $ocLazyLoad
        								.load([ 'js/app/finance/inventory/itemproperties/itemPropertiesCtrl.js' ]);
        					} ]
        		}
            
        })

        .state('app.finance.inventory.itemproperties.add', {
            url : '/hospital/inventory/itemproperties/add',
            data : {
                title : 'Add'
            },
            controller : 'itemPropertiesAddCtrl',

            templateUrl : 'views/finance/inventory/itemproperties/itemPropertiesAdd',
        		resolve : {
        			deps : [
        					'$ocLazyLoad',
        					function($ocLazyLoad) {
        						return $ocLazyLoad
        								.load([ 'js/app/finance/inventory/itemproperties/itemPropertiesCtrl.js' ]);
        					} ]
        		}
                
        
        })

    
        /** ********** Manage Stores Ends ************* */

        /** ********** Manage Item Category Starts ************* */

        .state('app.finance.inventory.manageitemcategory', { 
        	 abstract : true,
             templateUrl : "views/common.jsp",
             data : {
                 title : 'Manage Item Category'
             }
        })

        .state('app.finance.inventory.manageitemcategory.list', {
            url : '/hospital/inventory/manageitemcategory/list',
            data : {
                title : 'List'
            },
           
            controller : 'itemCategoryListCtrl',

            templateUrl : 'views/finance/inventory/itemcategory/itemCategoryList',
        		resolve : {
        			deps : [
        					'$ocLazyLoad',
        					function($ocLazyLoad) {
        						return $ocLazyLoad
        								.load([ 'js/app/finance/inventory/itemcategory/itemCategoryCtrl.js' ]);
        					} ]
        		}
        })

        .state('app.finance.inventory.manageitemcategory.add', {
            url : '/hospital/inventory/manageitemcategory/add',
            data : {
                title : 'Add'
            },
         
            
            controller : 'itemCategoryAddCtrl',

            templateUrl : 'views/finance/inventory/itemcategory/itemCategoryItemAdd',
        		resolve : {
        			deps : [
        					'$ocLazyLoad',
        					function($ocLazyLoad) {
        						return $ocLazyLoad
        								.load([ 'js/app/finance/inventory/itemcategory/itemCategoryAddCtrl.js' ]);
        					} ]
        		}
        })

        .state('app.finance.inventory.manageitemcategory.edit', {
            url : '/hospital/inventory/manageitemcategory/edit/:itemCategoryId',
            data : {
                title : 'Edit'
            },
           
            
            controller : 'itemCategoryEditCtrl',

            templateUrl : 'views/finance/inventory/itemcategory/itemCategoryItemAdd',
        		resolve : {
        			deps : [
        					'$ocLazyLoad',
        					function($ocLazyLoad) {
        						return $ocLazyLoad
        								.load([ 'js/app/finance/inventory/itemcategory/itemCategoryAddCtrl.js' ]);
        					} ]
        		}
        })

        .state('app.finance.inventory.manageitemcategory.addItem', {
            url : '/hospital/inventory/manageitemcategory/addItem',
            data : {
                title : 'Add'
            },
           
            
            controller : 'itemCategoryAddItemCtrl',

            templateUrl : 'views/finance/inventory/itemcategory/itemCategoryAddItem',
        		resolve : {
        			deps : [
        					'$ocLazyLoad',
        					function($ocLazyLoad) {
        						return $ocLazyLoad
        								.load([ 'js/app/finance/inventory/itemcategory/itemCategoryAddCtrl.js' ]);
        					} ]
        		}
        })

        .state('app.finance.inventory.manageitemcategory.parentTree', {
            url : '/hospital/inventory/manageitemcategory/parentTree',
            data : {
                title : 'Add'
            },
          
            
            controller : 'itemCategoryAddItemCtrl',

            templateUrl : 'views/finance/inventory/itemcategory/itemCategoryAddItem',
        		resolve : {
        			deps : [
        					'$ocLazyLoad',
        					function($ocLazyLoad) {
        						return $ocLazyLoad
        								.load([ 'js/app/finance/inventory/itemcategory/itemCategoryAddCtrl.js' ]);
        					} ]
        		}
        })

        /** ********** Manage Item Category Ends ************* */

        
        /** ********** Manage Stores Starts ************* */

        .state('app.finance.inventory.manageStores', {
            
        	 abstract : true,
             templateUrl : "views/common.jsp",
             data : {
                 title : 'Manage Stores'
             }
        })

        .state('app.finance.inventory.manageStores.list', {
            url : '/hospital/inventory/managestores/list',
            data : {
                title : 'List'
            },
           
            
            controller : 'manageStoresListCtrl',

            templateUrl : 'views/finance/inventory/manageStores/manageStoresList',
        		resolve : {
        			deps : [
        					'$ocLazyLoad',
        					function($ocLazyLoad) {
        						return $ocLazyLoad
        								.load([ 'js/app/finance/inventory/manageStores/manageStoresListCtrl.js' ]);
        					} ]
        		}
        })

        .state('app.finance.inventory.manageStores.add', {
            url : '/hospital/inventory/managestores/add',
            data : {
                title : 'Add'
            },
          
            
            controller : 'manageStoresAddCtrl',

            templateUrl : 'views/finance/inventory/manageStores/manageStoresAdd',
        		resolve : {
        			deps : [
        					'$ocLazyLoad',
        					function($ocLazyLoad) {
        						return $ocLazyLoad
        								.load([ 'js/app/finance/inventory/manageStores/manageStoresAddCtrl.js' ]);
        					} ]
        		}
        })

        .state('app.finance.inventory.manageStores.edit', {
            url : '/hospital/inventory/managestores/edit',
            data : {
                title : 'Add'
            },
            
            controller : 'manageStoresEditCtrl',

            templateUrl : 'views/finance/inventory/manageStores/manageStoresAdd',
        		resolve : {
        			deps : [
        					'$ocLazyLoad',
        					function($ocLazyLoad) {
        						return $ocLazyLoad
        								.load([ 'js/app/finance/inventory/manageStores/manageStoresAddCtrl.js' ]);
        					} ]
        		}
          
        })

        /** ********** Manage Stores Ends ************* */

        
        /** ********** QC Starts ************* */

        .state('app.finance.inventory.quality', {
         
        	
        	 abstract : true,
             templateUrl : "views/common.jsp",
             data : {
                 title : 'Quality Control'
             }
        })

        .state('app.finance.inventory.quality.list', {
            url : '/hospital/inventory/qualityCtrl/list',
            data : {

                title : 'List'

            },
          
            controller : 'qualityListCtrl',

            templateUrl : 'views/finance/inventory/inventoryQC/inventoryQCList',
        		resolve : {
        			deps : [
        					'$ocLazyLoad',
        					function($ocLazyLoad) {
        						return $ocLazyLoad
        								.load([ 'js/app/finance/inventory/inventoryQC/inventoryQCListCtrl.js' ]);
        					} ]
        		}
        })

        .state('app.finance.inventory.quality.add', {
            url : '/hospital/inventory/qualityCtrl/add',
            data : {

                title : 'Add'

            },
           
            controller : 'qualityAddCtrl',

            templateUrl : 'views/finance/inventory/inventoryQC/inventoryQCForm',
        		resolve : {
        			deps : [
        					'$ocLazyLoad',
        					function($ocLazyLoad) {
        						return $ocLazyLoad
        								.load([ 'js/app/finance/inventory/inventoryQC/inventoryQCAddCtrl.js' ]);
        					} ]
        		}
        })


        
        //
        
        
    /*    .state('app.finance.accounts.managepaymentreceipt', {
          abstract : true,
             templateUrl : "views/common.jsp",
             data : {
                 title : 'Manage Nature of  Payment And Receipt'
             }
        })


      .state('app.finance.accounts.managepaymentreceipt.list', {
          url : '/hospital/accounts/paymentreceipt/list',
          data : {
              title : 'List'
          },
          views : {
              "content@app" : {
                  controller : 'cashpaymentListCtrl',
                  templateUrl : 'views/hospital/accounts/managecahpayment/cashpaymentreceiptList',

                  resolve : {
                      deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/Managecashpayment/cashpaymentListCtrl.js' ])
                  }
              }
          }
      })*/

     /* .state('app.finance.accounts.managepaymentreceipt.add', {
          url : '/hospital/accounts/paymentreceipt/add',
          data : {
              title : 'Add'
          },
          views : {
              "content@app" : {
                  controller : 'cashpaymentAddCtrl',
                  templateUrl : 'views/hospital/accounts/managecahpayment/cashpaymentreceiptAdd',

                  resolve : {
                      deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/Managecashpayment/cashpaymentAddCtrl.js' ])
                  }
              }
          }
      })
      */
        
        
      .state('app.finance.accounts.managepaymentreceipt', {
          abstract : true,
			templateUrl : "views/common.jsp",

          data : {
              title : 'Manage Nature of  Payment And Receipt'
          }
      })

      .state('app.finance.accounts.managepaymentreceipt.list', {
          url : '/hospital/accounts/Paymentreceipt/list',
          data : {
              title : 'List'
          },
      
          
          controller : 'cashpaymentListCtrl',
			templateUrl : 'views/finance/accounts/managecashpayment/cashpaymentreceiptList',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/Managecashpayment/cashpaymentListCtrl.js' ]);
						} ]
			}
      })


      
        
      .state('app.finance.accounts.managepaymentreceipt.add', {
          url : '/hospital/accounts/Paymentreceipt/add',
          data : {
              title : 'Add'
          },
      
          
          controller : 'cashpaymentAddCtrl',
			templateUrl : 'views/finance/accounts/managecashpayment/CashpaymentreceiptAdd',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/finance/accounts/Managecashpayment/cashpaymentAddCtrl.js' ]);
						} ]
			}
      })

        
        
}


angular.module('neuboard').config(config).run(function($rootScope, $state) {
	$rootScope.$state = $state;
});
