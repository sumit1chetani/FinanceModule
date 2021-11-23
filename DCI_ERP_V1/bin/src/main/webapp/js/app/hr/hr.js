function config($stateProvider, $urlRouterProvider, $locationProvider) {
	// define

	
 
	
	$stateProvider
			.state('app.hr', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'HR'
				}
			})

			.state('app.hr.leavedeclaration', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Leave Declaration'
				}
			})

			.state(
					'app.hr.leavedeclaration.list',
					{
						url : '/hr/leavedeclaration/list',
						cache : false,
						data : {
							title : 'List'
						},

						controller : 'leavedeclarationCtrl',
						templateUrl : 'views/finance/leavedeclaration/leavedeclarationList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/leavedeclaration/leavedeclarationCtrl.js' ], {cache:false});
									} ]

						}

					})
					
			.state(
					'app.hr.leavedeclaration.add',
					{
						url : '/hr/leavedeclaration/add',
						cache : false,
						data : {
							title : 'Add'
						},

						controller : 'leavedeclarationAddCtrl',
						templateUrl : 'views/finance/leavedeclaration/leavedeclarationAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/leavedeclaration/leavedeclarationAddCtrl.js' ], {cache:false});
									} ]

						}

					})
			.state(
					'app.hr.leavedeclaration.edit',
					{
						url : '/hr/leavedeclaration/edit',
						cache : false,
						data : {
							title : 'edit'
						},

						controller : 'leaveDeclareEditCtrl',
						templateUrl : 'views/finance/leavedeclaration/leavedeclarationEdit',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/leavedeclaration/leavedeclarationAddCtrl.js' ], {cache:false});
									} ]

						}

					})
										
																
						.state('app.hr.manageshiftscheme', {
						         abstract : true,
						        templateUrl : "views/common",
						           data : {
							         title : 'Manage Shift Scheme'
						       }
					           })
							
							.state('app.hr.manageshiftscheme.list',
							{
								url : '/hr/manageshiftscheme/list',
								cache : false,
								data : {
									title : 'List'
								},
								
								controller : 'manageshiftschemeListCtrl',
								templateUrl : 'views/finance/manageshiftscheme/manageshiftschemeList',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/finance/manageshiftscheme/manageshiftschemeListCtrl.js' ], {cache:false});
											} ]

								}
							
							})
							.state('app.hr.manageshiftscheme.add',
											{
												url : '/hr/manageshiftscheme/add',
												cache : false,
												data : {
													title : 'Add'
												},
												
												controller : 'manageshiftschemeAddCtrl',
												templateUrl :  'views/finance/manageshiftscheme/manageshiftschemeAdd',
												resolve : {
													deps : [
															'$ocLazyLoad',
															function($ocLazyLoad) {
																return $ocLazyLoad
																		.load([ 'js/app/finance/manageshiftscheme/manageshiftschemeaddCtrl.js'], {cache:false});
															} ]

												}
											
											})
											
											.state('app.hr.manageshiftscheme.edit',
											{
												url : '/hr/manageshiftscheme/edit',
												cache : false,
												data : {
													title : 'Edit'
												},
												
												controller : 'shiftSchemeMasterEditCtrl',
												templateUrl :  'views/finance/manageshiftscheme/manageshiftschemeAdd',
												resolve : {
													deps : [
															'$ocLazyLoad',
															function($ocLazyLoad) {
																return $ocLazyLoad
																		.load([ 'js/app/finance/manageshiftscheme/manageshiftschemeaddCtrl.js'], {cache:false});
															} ]

												}
											
											})
											
											
											
															
						.state('app.hr.manageshift', {
						         abstract : true,
						        templateUrl : "views/common",
						           data : {
							         title : 'Manage Shift'
						       }
					           })
							
							.state('app.hr.manageshift.list',
							{
								url : '/hr/manageshift/list',
								cache : false,
								data : {
									title : 'List'
								},
								
								controller : 'manageshiftListCtrl',
								templateUrl : 'views/finance/manageshift/manageshiftList',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/finance/manageshift/manageshiftListCtrl.js' ], {cache:false});
											} ]

								}
							
							})
							.state('app.hr.manageshift.add',
											{
												url : '/hr/manageshift/add',
												cache : false,
												data : {
													title : 'Add'
												},
												
												controller : 'manageshiftAddCtrl',
												templateUrl :  'views/finance/manageshift/manageshiftAdd',
												resolve : {
													deps : [
															'$ocLazyLoad',
															function($ocLazyLoad) {
																return $ocLazyLoad
																		.load([ 'js/app/finance/manageshift/manageshiftaddCtrl.js'], {cache:false});
															} ]

												}
											
											})
											
											
											.state('app.hr.manageshift.edit',
											{
												url : '/hr/manageshift/edit',
												cache : false,
												data : {
													title : 'Edit'
												},
												
												controller : 'shiftMasterEditCtrl',
												templateUrl :  'views/finance/manageshift/manageshiftAdd',
												resolve : {
													deps : [
															'$ocLazyLoad',
															function($ocLazyLoad) {
																return $ocLazyLoad
																		.load([ 'js/app/finance/manageshift/manageshiftaddCtrl.js'], {cache:false});
															} ]

												}
											
											})
											
											
											
												///LETTER REQ  TYPE 
					
						
							.state('app.hr.letterreqtype', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Letter Request Type'
				}
			})

			.state(
					'app.hr.letterreqtype.list',
					{
						url : '/hr/letterreqtype/list',
						cache : false,
						data : {
							title : 'List'
						},

						controller : 'letterreqtypeListCtrl',
						templateUrl : '/views/finance/letterreqtype/letterreqtypeList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/letterreqtype/letterreqtypeList.js' ], {cache:false});
										js/app/finance/employeeday/employeedaysLimitCtrl.js
									} ]

						}

					})		
					///LETTER REQ  TYPE 
					
					
					
					// Letter Request only
					
								.state('app.hr.letterrequest', {
		abstract : true,
		templateUrl : "views/common",
		data : {
			title : 'Letter Request'
		}
	})

	.state(
			'app.hr.letterrequest.list',
			{
				url : '/hr/letterrequest/list',
				cache : false,
				data : {
					title : 'List'
				},

				controller : 'letterrequestListCtrl',
				templateUrl : '/views/finance/letterrequest/letterrequestList',
				resolve : {
					deps : [
							'$ocLazyLoad',
							function($ocLazyLoad) {
								return $ocLazyLoad
										.load([ 'js/app/finance/letterrequest/letterrequestList.js' ], {cache:false});
								js/app/finance/employeeday/employeedaysLimitCtrl.js
							} ]

				}

			})			
			.state(
					'app.hr.letterrequest.add',
					{
						url : '/hr/letterrequest/Add',
						cache : false,
						data : {
							title : 'Add'
						},

						controller : 'letterrequestADDCtrl',
						templateUrl : '/views/finance/letterrequest/letterrequestAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/letterrequest/letterrequestList.js' ], {cache:false});
										js/app/finance/employeeday/employeedaysLimitCtrl.js
									} ]

						}

					})			
					.state(
							'app.hr.letterrequest.edit',
							{
								url : '/hr/letterrequest/Edit',
								cache : false,
								data : {
									title : 'Edit'
								},

								controller : 'letterrequestADDCtrl',
								templateUrl : '/views/finance/letterrequest/letterrequestAdd',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/finance/letterrequest/letterrequestList.js' ], {cache:false});
												js/app/finance/employeeday/employeedaysLimitCtrl.js
											} ]

								}

							})	
								
							.state(
									'app.hr.letterrequest.view',
									{
										url : '/hr/letterrequest/View',
										cache : false,
										data : {
											title : 'View'
										},

										controller : 'letterrequestADDCtrl',
										templateUrl : '/views/finance/letterrequest/letterrequestView',
										resolve : {
											deps : [
													'$ocLazyLoad',
													function($ocLazyLoad) {
														return $ocLazyLoad
																.load([ 'js/app/finance/letterrequest/letterrequestList.js' ], {cache:false});
														js/app/finance/employeeday/employeedaysLimitCtrl.js
													} ]

										}

									})	
											
					.state('app.hr.manageholiday', {
						         abstract : true,
						        templateUrl : "views/common",
						           data : {
							         title : 'Manage Holiday'
						       }
					           })
							
							.state('app.hr.manageholiday.list',
							{
								url : '/hr/manageholiday/list',
								cache : false,
								data : {
									title : 'List'
								},
								
								controller : 'manageholidayListCtrl',
								templateUrl : 'views/finance/manageholiday/manageholidayList',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/finance/manageholiday/manageholidayListCtrl.js' ], {cache:false});
											} ]

								}
							
							})
							.state('app.hr.manageholiday.add',
											{
												url : '/hr/manageholiday/add',
												cache : false,
												data : {
													title : 'Add'
												},
												
												controller : 'manageholidayAddCtrl',
												templateUrl :  'views/finance/manageholiday/manageholidayAdd',
												resolve : {
													deps : [
															'$ocLazyLoad',
															function($ocLazyLoad) {
																return $ocLazyLoad
																		.load([ 'js/app/finance/manageholiday/manageholidayaddCtrl.js']);
															} ]

												}
											
											})
											
											
											
											
											.state('app.hr.manageholiday.edit',
											{
												url : '/hr/manageholiday/edit',
												cache : false,
												data : {
													title : 'Edit'
												},
												
												controller : 'holidayMasterEditCtrl',
												templateUrl :  'views/finance/manageholiday/manageholidayAdd',
												resolve : {
													deps : [
															'$ocLazyLoad',
															function($ocLazyLoad) {
																return $ocLazyLoad
																		.load([ 'js/app/finance/manageholiday/manageholidayaddCtrl.js'], {cache:false});
															} ]

												}
											
											})
											
											
										

			.state('app.hr.employeeleave', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Employee Leave Declaration'
				}
			})

			.state(
					'app.hr.employeeleave.list',
					{
						url : '/hr/employeeleave/list',
						cache : false,
						data : {
							title : 'List'
						},

						controller : 'employeeleaveCtrl',
						templateUrl : 'views/finance/employeeleave/employeeleaveList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/employeeleave/employeeleaveCtrl.js' ], {cache:false});
									} ]

						}

					})

		.state('app.hr.leaverequest', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Leave Request'
				}
			})

			.state(
					'app.hr.leaverequest.list',
					{
						url : '/hr/leaverequest/list',
						cache : false,
						data : {
							title : 'List'
						},

						controller : 'leaverequestCtrl',
						templateUrl : 'views/finance/leaverequest/leaverequestList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/leaverequest/leaverequestCtrl.js' ], {cache:false});
									} ]

						}

					})
			.state(
					'app.hr.leaverequest.add',
					{
						url : '/hr/leaverequest/add',
						cache : false,
						data : {
							title : 'Add'
						},

						controller : 'leaverequestAddCtrl',
						templateUrl : 'views/finance/leaverequest/leaverequestAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/leaverequest/leaverequestAddCtrl.js' ], {cache:false});
									} ]

						}

					})
			.state(
					'app.hr.leaverequest.edit',
					{
						url : '/hr/leaverequest/edit',
						cache : false,
						data : {
							title : 'edit'
						},

						controller : 'leaverequestEditCtrl',
						templateUrl : 'views/finance/leaverequest/leaverequestAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/leaverequest/leaverequestAddCtrl.js' ], {cache:false});
									} ]

						}

					})
																													
				
			.state('app.hr.leavetype', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Leave Type'
				}
			})

			.state(
					'app.hr.leavetype.list',
					{
						url : '/hr/leavetype/list',
						cache : false,
						data : {
							title : 'List'
						},

						controller : 'leavetypeCtrl',
						templateUrl : 'views/finance/leavetype/leavetypeList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/leavetype/leavetypeCtrl.js' ], {cache:false});
									} ]

						}

					})
			.state(
					'app.hr.leavetype.add',
					{
						url : '/hr/leavetype/add',
						cache : false,
						data : {
							title : 'Add'
						},

						controller : 'leavetypeAddCtrl',
						templateUrl : 'views/finance/leavetype/leavetypeAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/leavetype/leavetypeAddCtrl.js' ], {cache:false});
									} ]

						}

					})
			.state('app.hr.leaveApproval', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Leave Approval'
				}
			})

			.state(
					'app.hr.leaveApproval.list',
					{
						url : '/hr/leaveApproval/list',
						cache : false,
						data : {
							title : 'List'
						},

						controller : 'leaveApprovalCtrl',
						templateUrl : 'views/finance/leaveApproval/leaveApprovalList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/leaveApproval/leaveApprovalCtrl.js' ], {cache:false});
									} ]

						}

					})
			.state(
					'app.hr.leaveApproval.edit',
					{
						url : '/hr/leaveApproval/edit',
						cache : false,
						data : {
							title : 'Add'
						},

						controller : 'leaveApprovalAddCtrl',
						templateUrl : 'views/finance/leaveApproval/leaveApprovalAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/leaveApproval/leaveApprovalAddCtrl.js' ], {cache:false});
									} ]

						}

					})
					
			.state('app.hr.permissionReq', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Permission Request'
				}
			})

			.state(
					'app.hr.permissionReq.list',
					{
						url : '/hr/permissionReq/list',
						cache : false,
						data : {
							title : 'List'
						},

						controller : 'permissionReqCtrl',
						templateUrl : 'views/finance/permissionReq/permissionReqList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/permissionReq/permissionReqCtrl.js' ], {cache:false});
									} ]

						}

					})
			.state(
					'app.hr.permissionReq.add',
					{
						url : '/hr/permissionReq/add',
						cache : false,
						data : {
							title : 'Add'
						},

						controller : 'permissionReqAddCtrl',
						templateUrl : 'views/finance/permissionReq/permissionReqAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/permissionReq/permissionReqAddCtrl.js' ], {cache:false});
									} ]

						}

					})

			.state(
					'app.hr.permissionReq.edit',
					{
						url : '/hr/permissionReq/edit',
						cache : false,
						data : {
							title : 'edit'
						},

						controller : 'permissionReqEditCtrl',
						templateUrl : 'views/finance/permissionReq/permissionReqAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/permissionReq/permissionReqEditCtrl.js' ], {cache:false});
									} ]

						}

					})

			.state('app.hr.ondutyrequest', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'OnDuty Request'
				}
			})

			.state(
					'app.hr.ondutyrequest.list',
					{
						url : '/hr/ondutyrequest/list',
						cache : false,
						data : {
							title : 'List'
						},

						controller : 'ondutyrequestCtrl',
						templateUrl : 'views/finance/ondutyrequest/ondutyrequestList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/ondutyrequest/ondutyrequestCtrl.js' ], {cache:false});
									} ]

						}

					})
			.state(
					'app.hr.ondutyrequest.add',
					{
						url : '/hr/ondutyrequest/add',
						cache : false,
						data : {
							title : 'Add'
						},

						controller : 'ondutyrequestAddCtrl',
						templateUrl : 'views/finance/ondutyrequest/ondutyrequestAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/ondutyrequest/ondutyrequestAddCtrl.js' ], {cache:false});
									} ]

						}

					})

			.state(
					'app.hr.ondutyrequest.edit',
					{
						url : '/hr/ondutyrequest/edit',
						cache : false,
						data : {
							title : 'edit'
						},

						controller : 'ondutyrequestEditCtrl',
						templateUrl : 'views/finance/ondutyrequest/ondutyrequestAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/ondutyrequest/ondutyrequestEditCtrl.js' ], {cache:false});
									} ]

						}

					})
			.state('app.hr.ondutyapprovalcancellation', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'OnDuty Approval/Cancellation'
				}
			})

			.state(
					'app.hr.ondutyapprovalcancellation.list',
					{
						url : '/hr/ondutyapprovalcancellation/list',
						cache : false,
						data : {
							title : 'List'
						},

						controller : 'ondutyapprovalcancellationCtrl',
						templateUrl : 'views/finance/ondutyapprovalcancellation/ondutyapprovalcancellationList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/ondutyapprovalcancellation/ondutyapprovalcancellationCtrl.js' ], {cache:false});
									} ]

						}

					})
			.state(
					'app.hr.ondutyapprovalcancellation.add',
					{
						url : '/hr/ondutyapprovalcancellation/add',
						cache : false,
						data : {
							title : 'Add'
						},

						controller : 'ondutyapprovalcancellationAddCtrl',
						templateUrl : 'views/finance/ondutyapprovalcancellation/ondutyapprovalcancellationAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/ondutyapprovalcancellation/ondutyapprovalcancellationAddCtrl.js' ], {cache:false});
									} ]

						}

					})
			.state(
					'app.hr.ondutyapprovalcancellation.edit',
					{
						url : '/hr/ondutyapprovalcancellation/edit/:gradeId/:year',
						cache : false,
						data : {
							title : 'edit'
						},

						controller : 'ondutyapprovalcancellationEditCtrl',
						templateUrl : 'views/finance/ondutyapprovalcancellation/ondutyapprovalcancellationAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/ondutyapprovalcancellation/ondutyapprovalcancellationEditCtrl.js' ], {cache:false});
									} ]

						}

					})
			.state('app.hr.shiftAllocation', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Shift Allocation'
				}
			})

			.state(
					'app.hr.shiftAllocation.list',
					{
						url : '/hr/shiftAllocation/list',
						cache : false,
						data : {
							title : 'List'
						},

						controller : 'shiftAllocationCtrl',
						templateUrl : 'views/hrms/shiftAllocation/shiftAllocationList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/hr/shiftAllocation/shiftAllocationCtrl.js' ], {cache:false});
									} ]

						}

					})
			.state(
					'app.hr.shiftAllocation.add',
					{
						url : '/hr/shiftAllocation/add',
						cache : false,
						data : {
							title : 'Add'
						},

						controller : 'shiftAllocationAddCtrl',
						templateUrl : 'views/hrms/shiftAllocation/shiftAllocationAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/hr/shiftAllocation/shiftAllocationAddCtrl.js' ], {cache:false});
									} ]

						}

					})
			.state(
					'app.hr.shiftAllocation.edit',
					{
						url : '/hr/shiftAllocation/edit',
						cache : false,
						data : {
							title : 'edit'
						},

						controller : 'shiftAllocationEditCtrl',
						templateUrl : 'views/hrms/shiftAllocation/shiftAllocationAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/hr/shiftAllocation/shiftAllocationAddCtrl.js' ], {cache:false});
									} ]

						}

					})
					//Shift reallocation					
																							
						.state('app.hr.shiftreallocate', {
						         abstract : true,
						        templateUrl : "views/common",
						           data : {
							         title : 'Shift ReAllocation'
						       }
					           })
							
							.state('app.hr.shiftreallocate.list',
							{
								url : '/hr/shiftreallocate/list',
								cache : false,
								data : {
									title : 'List'
								},
								
								controller : 'shiftreallocateListCtrl',
								templateUrl : 'views/hrms/shiftreallocate/shiftreallocateList',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/hr/shiftreallocate/shiftreallocateListCtrl.js' ], {cache:false});
											} ]

								}
							
							})
							.state('app.hr.shiftreallocate.add',
											{
												url : '/hr/shiftreallocate/add',
												cache : false,
												data : {
													title : 'Add'
												},
												
												controller : 'shiftreallocateAddCtrl',
												templateUrl :  'views/hrms/shiftreallocate/shiftreallocateAdd',
												resolve : {
													deps : [
															'$ocLazyLoad',
															function($ocLazyLoad) {
																return $ocLazyLoad
																		.load([ 'js/app/hr/shiftreallocate/shiftreallocateaddCtrl.js'], {cache:false});
															} ]

												}
											
											})
											
											

			.state('app.hr.leaveBatchApproval', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Leave Batch Approval'
				}
			})

			.state(
					'app.hr.leaveBatchApproval.list',
					{
						url : '/hr/leaveBatchApproval/list',
						cache : false,
						data : {
							title : 'List'
						},

						controller : 'leaveBatchApprovalCtrl',
						templateUrl : 'views/finance/leaveBatchApproval/leaveBatchApprovalList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/leaveBatchApproval/leaveBatchApprovalCtrl.js' ], {cache:false});
									} ]

						}

					})

			.state('app.hr.leaveSummary', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Leave Summary '
				}
			})

			.state(
					'app.hr.leaveSummary.list',
					{
						url : '/hr/leaveSummary/list',
						cache : false,
						data : {
							title : 'List'
						},

						controller : 'leaveSummaryCtrl',
						templateUrl : 'views/finance/leaveSummary/leaveSummaryList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/leaveSummary/leaveSummaryCtrl.js' ], {cache:false});
									} ]

						}

					})
			.state(
					'app.hr.leaveSummary.detail',
					{
						url : '/hr/leaveSummary/detail',
						cache : false,
						data : {
							title : 'detail'
						},

						controller : 'leaveSummarydetailCtrl',
						templateUrl : 'views/finance/leaveSummary/leaveSummarydetail',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/leaveSummary/leaveSummarydetailCtrl.js' ], {cache:false});
									} ]

						}

					})
			.state('app.hr.holidayWorkingApprovalCancel', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Holiday Working Approval/Cancellation'
				}
			})

			.state(
					'app.hr.holidayWorkingApprovalCancel.list',
					{
						url : '/hr/holidayWorkingApprovalCancel/list',
						cache : false,
						data : {
							title : 'List'
						},

						controller : 'holidayWorkingApprovalCancelCtrl',
						templateUrl : 'views/finance/holidayWorkingApprovalCancel/holidayWorkingApprovalCancelList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/holidayWorkingApprovalCancel/holidayWorkingApprovalCancelCtrl.js' ], {cache:false});
									} ]

						}

					})
			.state(
					'app.hr.holidayWorkingApprovalCancel.add',
					{
						url : '/hr/holidayWorkingApprovalCancel/edit',
						cache : false,
						data : {
							title : 'Add'
						},

						controller : 'holidayWorkingApprovalCancelAddCtrl',
						templateUrl : 'views/finance/holidayWorkingApprovalCancel/holidayWorkingApprovalCancelAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/holidayWorkingApprovalCancel/holidayWorkingApprovalCancelAddCtrl.js' ], {cache:false});
									} ]

						}

					})
			.state('app.hr.holidayworkencashrequest', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Holiday Work Encash Request'
				}
			})

			.state(
					'app.hr.holidayworkencashrequest.list',
					{
						url : '/hr/holidayworkencashrequest/list',
						cache : false,
						data : {
							title : 'List'
						},

						controller : 'holidayworkencashrequestCtrl',
						templateUrl : 'views/finance/holidayworkencashrequest/holidayworkencashrequestList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/holidayworkencashrequest/holidayworkencashrequestCtrl.js' ], {cache:false});
									} ]

						}

					})
			.state(
					'app.hr.holidayworkencashrequest.add',
					{
						url : '/hr/holidayworkencashrequest/add',
						cache : false,
						data : {
							title : 'add'
						},

						controller : 'holidayworkencashrequestAddCtrl',
						templateUrl : 'views/finance/holidayworkencashrequest/holidayworkencashrequestAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/holidayworkencashrequest/holidayworkencashrequestAddCtrl.js' ], {cache:false});
									} ]

						}

					})
			.state(
					'app.hr.holidayworkencashrequest.edit',
					{
						url : '/hr/holidayworkencashrequest/edit',
						cache : false,
						data : {
							title : 'edit'
						},

						controller : 'holidayworkencashrequestAddCtrl',
						templateUrl : 'views/finance/holidayworkencashrequest/holidayworkencashrequestAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/holidayworkencashrequest/holidayworkencashrequestAddCtrl.js' ], {cache:false});
									} ]

						}

					})
			.state('app.hr.permissionbatchapproval', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Permission Batch Approval'
				}
			})

			.state(
					'app.hr.permissionbatchapproval.list',
					{
						url : '/hr/permissionbatchapproval/list',
						cache : false,
						data : {
							title : 'List'
						},

						controller : 'permissionbatchapprovalCtrl',
						templateUrl : 'views/finance/permissionbatchapproval/permissionbatchapprovalList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/permissionbatchapproval/permissionbatchapprovalCtrl.js' ], {cache:false});
									} ]

						}

					})
			.state(
					'app.hr.permissionbatchapproval.add',
					{
						url : '/hr/permissionbatchapproval/add',
						cache : false,
						data : {
							title : 'add'
						},

						controller : 'permissionbatchapprovalAddCtrl',
						templateUrl : 'views/finance/permissionbatchapproval/permissionbatchapprovalAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/permissionbatchapproval/permissionbatchapprovalAddCtrl.js' ], {cache:false});
									} ]

						}

					})

				
					.state('app.hr.permissionapprovalcancellation', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Permission  Approval/Cancellation'
				}
			})

			.state(
					'app.hr.permissionapprovalcancellation.list',
					{
						url : '/hr/permissionapprovalcancellation/list',
						cache : false,
						data : {
							title : 'List'
						},

						controller : 'permissionapprovalcancellationCtrl',
						templateUrl : 'views/hrms/permissionapprovalcancellation/permissionapprovalcancellationList.jsp',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/hr/permissionapprovalcancellation/permissionapprovalcancellationCtrl.js' ], {cache:false});
									} ]

						}

					})
			.state(
					'app.hr.permissionapprovalcancellation.add',
					{
						url : '/hr/permissionapprovalcancellation/add',
						cache : false,
						data : {
							title : 'add'
						},

						controller : 'permissionapprovalcancellationAddCtrl',
						templateUrl : 'views/hrms/permissionapprovalcancellation/permissionrequestapprovalAdd.jsp',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/hr/permissionapprovalcancellation/permissionapprovalcancellationAddCtrl.js' ], {cache:false});
									} ]

						}

					})
			.state('app.hr.holidayworkapprovalencash', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Holiday Work Approval Encashment'
				}
			})

			.state(
					'app.hr.holidayworkapprovalencash.list',
					{
						url : '/hr/holidayworkapprovalencash/list',
						cache : false,
						data : {
							title : 'List'
						},

						controller : 'holidayworkapprovalencashCtrl',
						templateUrl : 'views/finance/holidayworkapprovalencash/holidayworkapprovalencashList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/holidayworkapprovalencash/holidayworkapprovalencashCtrl.js' ], {cache:false});
									} ]

						}

					})
			.state(
					'app.hr.holidayworkapprovalencash.add',
					{
						url : '/hr/holidayworkapprovalencash/add',
						cache : false,
						data : {
							title : 'add'
						},

						controller : 'holidayworkapprovalencashAddCtrl',
						templateUrl : 'views/finance/holidayworkapprovalencash/holidayworkapprovalencashAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/holidayworkapprovalencash/holidayworkapprovalencashAddCtrl.js' ], {cache:false});
									} ]

						}

					})
			.state('app.hr.holidayworkbatchapproval', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Holiday Work Batch Approval'
				}
			})

			.state(
					'app.hr.holidayworkbatchapproval.list',
					{
						url : '/hr/holidayworkbatchapproval/list',
						cache : false,
						data : {
							title : 'List'
						},

						controller : 'holidayworkbatchapprovalCtrl',
						templateUrl : 'views/finance/holidayworkbatchapproval/holidayworkbatchapprovalList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/holidayworkbatchapproval/holidayworkbatchapprovalCtrl.js' ], {cache:false});
									} ]

						}

					})
			.state('app.hr.ondutybatchapproval', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'OnDuty Batch Approval'
				}
			})

			.state(
					'app.hr.ondutybatchapproval.list',
					{
						url : '/hr/ondutybatchapproval/list',
						cache : false,
						data : {
							title : 'List'
						},

						controller : 'ondutybatchapprovalCtrl',
						templateUrl : 'views/finance/ondutybatchapproval/ondutybatchapprovalList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/ondutybatchapproval/ondutybatchapprovalCtrl.js' ], {cache:false});
									} ]

						}

					})
			.state(
					'app.hr.ondutybatchapproval.add',
					{
						url : '/hr/ondutybatchapproval/add',
						cache : false,
						data : {
							title : 'Add'
						},

						controller : 'ondutybatchapprovalCtrl',
						templateUrl : 'views/finance/ondutybatchapproval/ondutybatchapprovalAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/ondutybatchapproval/ondutybatchapprovalCtrl.js' ], {cache:false});
									} ]

						}

					})

			.state('app.hr.holidayWorkBatchApprovalEncash', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Holiday Work Batch Approval Encash'
				}
			})

			.state(
					'app.hr.holidayWorkBatchApprovalEncash.list',
					{
						url : '/hr/holidayWorkBatchApprovalEncash/list',
						cache : false,
						data : {
							title : 'List'
						},

						controller : 'holidayWorkBatchApprovalEncashCtrl',
						templateUrl : 'views/finance/holidayWorkBatchApprovalEncash/holidayWorkBatchApprovalEncashList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/holidayWorkBatchApprovalEncash/holidayWorkBatchApprovalEncashCtrl.js' ], {cache:false});
									} ]

						}

					})
		
					.state('app.hr.holidayWorkingRequest', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Holiday Working Request'
				}
			})

			.state(
					'app.hr.holidayWorkingRequest.list',
					{
						url : '/hr/holidayWorkingRequest/list',
						cache : false,
						data : {
							title : 'List'
						},

						controller : 'holidayWorkingRequestCtrl',
						templateUrl : 'views/finance/holidayWorkingRequest/holidayWorkingRequestList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/holidayWorkingRequest/holidayWorkingRequestCtrl.js' ], {cache:false});
									} ]

						}

					})
			.state(
					'app.hr.holidayWorkingRequest.add',
					{
						url : '/hr/holidayWorkingRequest/add',
						cache : false,
						data : {
							title : 'add'
						},

						controller : 'holidayWorkingRequestAddCtrl',
						templateUrl : 'views/finance/holidayWorkingRequest/holidayWorkingRequestAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/holidayWorkingRequest/holidayWorkingRequestAddCtrl.js' ], {cache:false});
									} ]

						}

					})
			.state(
					'app.hr.holidayWorkingRequest.edit',
					{
						url : '/hr/holidayWorkingRequest/edit',
						cache : false,
						data : {
							title : 'add'
						},

						controller : 'holidayWorkingRequestAddCtrl',
						templateUrl : 'views/finance/holidayWorkingRequest/holidayWorkingRequestAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/holidayWorkingRequest/holidayWorkingRequestAddCtrl.js' ], {cache:false});
									} ]

						}

					})
					

			.state('app.hr.staffnotification', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Staff Notification'
				}
			})

			.state(
					'app.hr.staffnotification.list',
					{
						url : '/hr/staffnotification/list',
						cache : false,
						data : {
							title : 'List'
						},

						controller : 'staffnotificationListCtrl',
						templateUrl : 'views/finance/staffnotification/staffnotificationList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/staffnotification/staffnotificationListCtrl.js' ], {cache:false});
									} ]

						}

					})
			.state(
					'app.hr.staffnotification.add',
					{
						url : '/hr/staffnotification/add',
						cache : false,
						data : {
							title : 'Add'
						},

						controller : 'staffnotificationAddCtrl',
						templateUrl : 'views/finance/staffnotification/staffnotificationAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/staffnotification/staffnotificationaddCtrl.js' ], {cache:false});
									} ]

						}

					})
			.state(
					'app.hr.staffnotification.edit',
					{
						url : '/hr/staffnotification/edit',
						cache : false,
						data : {
							title : 'edit'
						},

						controller : 'staffnotificationEditCtrl',
						templateUrl : 'views/finance/staffnotification/staffnotificationAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/staffnotification/staffnotificationEditCtrl.js' ], {cache:false});
									} ]

						}

					})
			//CIRCULAR

			.state('app.hr.circular', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'circular'
				}
			})
			.state(
					'app.hr.circular.list',
					{
						url : '/hr/circular/list',
						cache : false,
						data : {
							title : 'List'
						},

						controller : 'circularListCtrl',
						templateUrl : 'views/finance/circular/circularList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/circular/circularListCtrl.js' ], {cache:false});
									} ]

						}

					})

			.state(
					'app.hr.circular.add',
					{
						url : '/hr/circular/add',
						cache : false,
						data : {
							title : 'Add'
						},

						controller : 'circularAddCtrl',
						templateUrl : 'views/finance/circular/circularAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/circular/circularaddCtrl.js' ], {cache:false});
									} ]

						}

					})

			.state(
					'app.hr.circular.edit',
					{
						url : '/hr/circular/edit',
						cache : false,
						data : {
							title : 'Edit'
						},

						controller : 'staffcircularEditCtrl',
						templateUrl : 'views/finance/circular/circularAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/circular/circularaddCtrl.js' ], {cache:false});
									} ]

						}

					})
					
					
			//employee reports ends		
					
			//document report starts
					
			.state('app.hr.documentreports', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Document Report'
				}
			})

			.state(
					'app.hr.documentreports.list',
					{
						url : '/hr/documentreports/list',
						cache : false,
						data : {
							title : 'Search'
						},

						controller : 'documentreportsCtrl',
						templateUrl : 'views/finance/documentreports/documentreportsList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/documentreports/documentreportsCtrl.js' ], {cache:false});
									} ]

						}

					})	
					
					
								
			.state('app.hr.documentreportsexpiry', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Document Expiry Report'
				}
			})

			.state(
					'app.hr.documentreportsexpiry.list',
					{
						url : '/hr/documentreportsexpiry/list',
						cache : false,
						data : {
							title : 'Search'
						},

						controller : 'documentreportsexpiryCtrl',
						templateUrl : 'views/finance/documentreportsexpiry/documentreportsexpiryList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/documentreportsexpiry/documentreportsexpiryCtrl.js' ], {cache:false});
									} ]

						}

					})		
					
			//document report ends
					
								
			 //employee reports starts
			.state('app.hr.employeereports', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Employee Report'
				}
			})

			.state(
					'app.hr.employeereports.list',
					{
						url : '/hr/employeereports/list',
						cache : false,
						data : {
							title : 'Search'
						},

						controller : 'employeereportsCtrl',
						templateUrl : 'views/finance/employeereports/employeereportsList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/employeereports/employeereportsCtrl.js' ], {cache:false});
									} ]

						}

					})		
					
					.state(
'app.hr.employeereports.chart',
{
url : '/hr/employeereports/chart',
cache : false,
data : {
title : 'Chart'
},

controller : 'employeereportsCtrl',
templateUrl : 'views/finance/employeereports/chartemployeereports',
resolve : {
deps : [
'$ocLazyLoad',
function($ocLazyLoad) {
return $ocLazyLoad
.load([ 'js/app/finance/employeereports/employeereportsCtrl.js' ], {cache:false});
} ]

}

})

			//employee reports ends		
					
			//DiSCIPLINARY ACTION

			.state('app.hr.disciplinary', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Disciplinary'
				}
			})

			.state(
					'app.hr.disciplinary.list',
					{
						url : '/hr/disciplinary/list',
						cache : false,
						data : {
							title : 'List'
						},

						controller : 'disciplinaryListCtrl',
						templateUrl : 'views/finance/disciplinary/disciplinaryList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/disciplinary/disciplinaryListCtrl.js' ], {cache:false});
									} ]

						}

					})
			.state(
					'app.hr.disciplinary.add',
					{
						url : '/hr/disciplinary/add',
						cache : false,
						data : {
							title : 'Add'
						},

						controller : 'disciplinaryAddCtrl',
						templateUrl : 'views/finance/disciplinary/disciplinaryAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/disciplinary/disciplinaryaddCtrl.js' ], {cache:false});
									} ]

						}

					})

			.state(
					'app.hr.disciplinary.edit',
					{
						url : '/hr/disciplinary/edit',
						cache : false,
						data : {
							title : 'Add'
						},

						controller : 'disciplinaryActionEditCtrl',
						templateUrl : 'views/finance/disciplinary/disciplinaryAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/finance/disciplinary/disciplinaryActionEditCtrl.js' ], {cache:false});
									} ]

						}

					})
					
					
					
					.state('app.hr.employeeexperience', {
						abstract : true,
						templateUrl : "views/common",
					 data : {
						  title : 'employeeexperience'
							}
						   })
																	
						.state('app.hr.employeeexperience.list',
								{
								url : '/hr/employeeexperience/list',
								cache : false,
								data : {
							title : 'List'
							},
																		
							controller : 'employeeexperienceCtrl',
						templateUrl : 'views/finance/employeeexperience/employeeexperienceList',
						resolve : {
						deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
						return $ocLazyLoad
							.load([ 'js/app/finance/employeeexperience/employeeexperienceCtrl.js' ], {cache:false});
											} ]

				}
																	
																	})	
																	



											
											.state('app.hr.manageattendance', {
										         abstract : true,
										        templateUrl : "views/common",
										           data : {
											         title : 'Manage Attendance'
										       }
									           })
									           
									           
											
											.state('app.hr.manageattendance.list',
											{
												url : '/hr/manageattendance/list',
												cache : false,
												data : {
													title : 'List'
												},
												
												controller : 'manageattendanceListCtrl',
												templateUrl : 'views/hrms/manageattendance/manageattendanceList',
												resolve : {
													deps : [
															'$ocLazyLoad',
															function($ocLazyLoad) {
																return $ocLazyLoad
																		.load([ 'js/app/hr/manageattendance/manageattendanceListCtrl.js' ], {cache:false});
															} ]

												}
											
											})
											.state('app.hr.manageattendance.add',
															{
																url : '/hr/manageattendance/add',
																cache : false,
																data : {
																	title : 'Add'
																},
																
																controller : 'manageattendanceAddCtrl',
																templateUrl :  'views/hrms/manageattendance/manageattendanceAdd',
																resolve : {
																	deps : [
																			'$ocLazyLoad',
																			function($ocLazyLoad) {
																				return $ocLazyLoad
																						.load([ 'js/app/hr/manageattendance/manageattendanceaddCtrl.js'], {cache:false});
																			} ]

																}
															
															})
																																									.state('app.hr.hrattendance', {
																												abstract : true,
																												templateUrl : "views/common",
																												     data : {
																													         title : 'hrattendance'
																												       }
																											           })
																													
																													.state('app.hr.hrattendance.list',
																													{
																														url : '/hr/hrattendance/list',
																														cache : false,
																														data : {
																															title : 'List'
																														},
																														
																														controller : 'hrattendanceListCtrl',
																														templateUrl : 'views/finance/hrattendance/hrattendanceList',
																														resolve : {
																															deps : [
																																	'$ocLazyLoad',
																																	function($ocLazyLoad) {
																																		return $ocLazyLoad
																																				.load([ 'js/app/finance/hrattendance/hrattendanceListCtrl.js' ], {cache:false});
																																	} ]

																														}
																													
																													})
																													.state('app.hr.hrattendance.add',
																																	{
																																		url : '/hr/hrattendance/add',
																																		cache : false,
																																		data : {
																																			title : 'Add'
																																		},
																																		
																																		controller : 'hrattendanceAddCtrl',
																																		templateUrl :  'views/finance/hrattendance/hrattendanceAdd',
																																		resolve : {
																																			deps : [
																																					'$ocLazyLoad',
																																					function($ocLazyLoad) {
																																						return $ocLazyLoad
																																								.load([ 'js/app/finance/hrattendance/hrattendanceaddCtrl.js'], {cache:false});
																																					} ]

																																		}
																																	
																																	})
																																			
																																	
																																	.state('app.hr.hrattendance.edit',
																																	{
																																		url : '/hr/hrattendance/edit',
																																		cache : false,
																																		data : {
																																			title : 'Edit'
																																		},
																																		
																																		controller : 'hrmanageattendanceEditCtrl',
																																		templateUrl :  'views/finance/hrattendance/hrattendanceAdd',
																																		resolve : {
																																			deps : [
																																					'$ocLazyLoad',
																																					function($ocLazyLoad) {
																																						return $ocLazyLoad
																																								.load([ 'js/app/finance/hrattendance/hrattendanceaddCtrl.js'], {cache:false});
																																					} ]

																																		}
																																	
																																	})
										
																																	
																																	
		





																	
																	.state('app.hr.empattendancereport', {
																		abstract : true,
																		templateUrl : "views/common",
																	 data : {
																		  title : 'empattendancereport'
																			}
																		   })
																													
																		.state('app.hr.empattendancereport.list',
																				{
																				url : '/hr/empattendancereport/list',
																				cache : false,
																				data : {
																			title : 'List'
																			},
																														
																			controller : 'empattendancereportCtrl',
																		templateUrl : 'views/finance/empattendancereport/empattendancereportList',
																		resolve : {
																		deps : [
																		'$ocLazyLoad',
																		function($ocLazyLoad) {
																		return $ocLazyLoad
																			.load([ 'js/app/finance/empattendancereport/empattendancereportCtrl.js' ], {cache:false});
																							} ]

																}
																													
																													})	
																													.state('app.hr.manageHolidayNew', {
																											         abstract : true,
																											        templateUrl : "views/common",
																											           data : {
																												         title : 'Manage Holiday'
																											       }
																										           })
														
														.state(
														'app.hr.manageHolidayNew.list',
														{
															url : '/hr/manageHolidayNew/List',
															data : {
																title : 'List'
															},
															controller : 'manageholidayNewListCtrl',
															templateUrl : '/views/hrms/manageHolidayNew/manageHolidayNewList',
															resolve : {
																deps : [
																		'$ocLazyLoad',
																		function($ocLazyLoad) {
																			return $ocLazyLoad
																					.load([ 'js/app/hr/manageHolidayNew/manageHolidayNewListCtrl.js' ]);
																		} ]
															}
														})
												                                       .state(
														'app.hr.manageHolidayNewadd-add',
														{
															url : '/hr/manageHolidayNew/add',
															data : {
																title : 'Add'
															},
															controller : 'manageHolidayNewAddCtrl',
															templateUrl : 'views/hrms/manageHolidayNew/manageHolidayNewAdd',
															resolve : {
																deps : [
																		'$ocLazyLoad',
																		function($ocLazyLoad) {
																			return $ocLazyLoad
																					.load([ 'js/app/hr/manageHolidayNew/manageHolidayNewAddCtrl.js' ])
																		} ]
															}

														})
														.state(
														'app.hr.manageHolidayNew.edit-edit',
														{
															url : '/hr/manageHolidayNew/edit=:holidayId',
															data : {
																title : 'Edit'
															},
															controller : 'holidayMasterNewEditCtrl',
															templateUrl : 'views/hrms/manageHolidayNew/manageHolidayNewEdit',
															resolve : {
																deps : [
																		'$ocLazyLoad',
																		function($ocLazyLoad) {
																			return $ocLazyLoad
																					.load([ 'js/app/hr/manageHolidayNew/manageHolidayNewAddCtrl.js' ])
																		} ]
															}

														})
					
							
														
						
											.state('app.hr.myattendance', {
										         abstract : true,
										        templateUrl : "views/common",
										           data : {
											         title : 'My Attendance'
										       }
									           })
									           
									           
											
											.state('app.hr.myattendance.list',
											{
												url : '/hr/myattendance/list',
												cache : false,
												data : {
													title : 'Add'
												},
												
												controller : 'manageattendanceListCtrl',
												templateUrl : '/views/hrms/manageattendance/MyAttendanceAdd',
												resolve : {
													deps : [
															'$ocLazyLoad',
															function($ocLazyLoad) {
																return $ocLazyLoad
																		.load([ 'js/app/hr/manageattendance/myAttendanceAddCtrl.js' ], {cache:false});
															} ]

												}
											
											})		
											
											
											
											
											.state('app.hr.importattendance', {
										         abstract : true,
										        templateUrl : "views/common",
										           data : {
											         title : 'Import Manual Attendance'
										       }
									           })
									           
											
											.state('app.hr.importattendance.list',
											{
												url : '/hr/AttendanceImport/import',
												cache : false,
												data : {
													title : 'Import Manual Attendance'
												},
												
												controller : 'attendanceImportCtrl',
												templateUrl : '/views/hrms/manageattendance/attendanceImport',
												resolve : {
													deps : [
															'$ocLazyLoad',
															function($ocLazyLoad) {
																return $ocLazyLoad
																		.load(['js/app/hr/manageattendance/attendanceImport.js' ], {cache:false});
																			} ]

												}
											
											})		
											

	
											
											
											
											
											
																						
											
											.state('app.hr.hrmanageattendance', {
										         abstract : true,
										        templateUrl : "views/common",
										           data : {
										                title : 'HR Manage Attendance'
										       }
									           })
									           
									     											
																			           
							.state('app.hr.hrmanageattendance.list',
											{
									            url : '/hr/hrmanageattendance/list',
												cache : false,
												data : {
													title : 'List'
												},
												
							                    controller : 'hrmanageattendanceListCtrl',
							                    templateUrl : '/views/hrms/manageattendance/hrAttendanceList',
												resolve : {
													deps : [
															'$ocLazyLoad',
															function($ocLazyLoad) {
																return $ocLazyLoad
																		.load([ 'js/app/hr/manageattendance/hrmanageAttendanceListCtrl.js' ], {cache:false});
															} ]

												}
											
											})	
		           
									           
									           
									           
									           
									           
									           
									           
									           
									           
									           
											
											
               
											
											.state('app.hr.hrmanageattendance.add',
											{
									            url : '/hr/hrmanageattendance/add:hrmanageattendance',
												cache : false,
												data : {
													title : 'Add'
												},
												
							                    controller : 'hrmanageattendanceAddCtrl',
							                    templateUrl : 'views/hrms/manageattendance/hrmanageAttendanceAdd',
												resolve : {
													deps : [
															'$ocLazyLoad',
															function($ocLazyLoad) {
																return $ocLazyLoad
																		.load([ 'js/app/hr/manageattendance/hrmanageAttendanceAddCtrl.js' ], {cache:false});
															} ]

												}
											
											})	
											
											
											.state('app.hr.hrmanageattendance.edit',
											{
									            url : '/hr/attendance/hrmanageattendance/edit',
												cache : false,
												data : {
													title : 'Edit'
												},
												
							                    controller : 'hrmanageattendanceEditCtrl',
							                    templateUrl : 'views/hrms/manageattendance/hrmanageAttendanceAdd',
												resolve : {
													deps : [
															'$ocLazyLoad',
															function($ocLazyLoad) {
																return $ocLazyLoad
																		.load([ 'js/app/hr/manageattendance/hrmanageAttendanceAddCtrl.js' ], {cache:false});
															} ]

												}
											
											})	
											

										        


					
																		
											
											
											
}

angular.module('neuboard').config(config).run(function($rootScope, $state) {
	$rootScope.$state = $state;
});