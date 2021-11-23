function config($stateProvider, $urlRouterProvider, $locationProvider) {

	$stateProvider.state('app.air', {
		abstract : true,
		templateUrl : "views/common",
		data : {
			title : 'Air'
		}
	})

	$stateProvider.state('app.sea', {
		abstract : true,
		templateUrl : "views/common",
		data : {
			title : 'Sales'
		}
	})
	$stateProvider.state('app.tools', {
		abstract : true,
		templateUrl : "views/common",
		data : {
			title : 'Tools'
		}
	})
	$stateProvider.state('app.air.joborder', {
		abstract : true,
		templateUrl : "views/common",
		data : {
			title : 'Job Order '
		}
	})
	$stateProvider.state('app.sea.joborder', {
		abstract : true,
		templateUrl : "views/common",
		data : {
			title : 'Billing Instructions'
		}
	})

	$stateProvider.state('app.sea.joborderApp', {
		abstract : true,
		templateUrl : "views/common",
		data : {
			title : 'Billing Instructions Approval'
		}
	})


	$stateProvider.state('app.air.booking', {
		abstract : true,
		templateUrl : "views/common",
		data : {
			title : 'Booking '
		}
	})
	$stateProvider.state('app.sea.booking', {
		abstract : true,
		templateUrl : "views/common",
		data : {
			title : 'Booking '
		}
	})

	$stateProvider.state('app.air.bulkRateReq', {
		abstract : true,
		templateUrl : "views/common",
		data : {
			title : 'Bulk Rate Request'
		}
	})

	$stateProvider.state('app.air.quotation', {
		abstract : true,
		templateUrl : "views/common",
		data : {
			title : 'Quotation'
		}
	})

	$stateProvider.state('app.sea.quotation', {
		abstract : true,
		templateUrl : "views/common",
		data : {
			title : 'Quotation'
		}
	})

	$stateProvider.state('app.sea.hbl', {
		abstract : true,
		templateUrl : "views/common",
		data : {
			title : 'Bill of Coastal Goods'
		}
	})

	$stateProvider.state('app.sea.deliveryorder', {
		abstract : true,
		templateUrl : "views/common",
		data : {
			title : 'Delivery Order'
		}
	})

	$stateProvider.state('app.air.deliveryorder', {
		abstract : true,
		templateUrl : "views/common",
		data : {
			title : 'Delivery Order'
		}
	})

	$stateProvider.state('app.sea.salesreceipt', {
		abstract : true,
		templateUrl : "views/common",
		data : {
			title : 'Sales Receipt'
		}
	})

	$stateProvider.state('app.sea.mabl', {
		abstract : true,
		templateUrl : "views/common",
		data : {
			title : 'MBL'
		}
	})

	$stateProvider.state('app.air.hbw', {
		abstract : true,
		templateUrl : "views/common",
		data : {
			title : 'HAWB'
		}
	})
	
	$stateProvider.state('app.air.tariff', {
		abstract : true,
		templateUrl : "views/common",
		data : {
			title : 'Tariff'
		}
	})
	
	$stateProvider.state('app.sea.tariff', {
		abstract : true,
		templateUrl : "views/common",
		data : {
			title : 'Tariff'
		}
	})

	
	
		
	$stateProvider.state('app.inventory', {
		abstract : true,
		templateUrl : "views/common",
		data : {
			title : 'Stock'
		}
	})
	$stateProvider
			.state('app.air.mabw', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'MAWB'
				}
			})

			.state(
					'app.sea.salesreceipt.list',
					{
						url : '/salesreceipt/list',
						data : {
							title : 'List'
						},
						controller : 'salesreceiptListCtrl',
						templateUrl : 'views/sea/salesreceipt/salesreceiptList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/salesreceipt/salesReceiptListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.sea.salesreceipt.add',
					{
						url : '/salesreceipt/add',
						data : {
							title : 'Add'
						},
						controller : 'salesreceiptAddCtrl',
						templateUrl : 'views/sea/salesreceipt/salesreceiptAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/salesreceipt/salesReceiptAddCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.sea.salesreceipt.edit',
					{
						url : '/salesreceipt/edit',
						data : {
							title : 'Edit'
						},
						controller : 'salesreceiptAddCtrl',
						templateUrl : 'views/sea/salesreceipt/salesreceiptAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/salesreceipt/salesReceiptAddCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.air.bulkRateReq.list',
					{
						url : '/bulkRateReqAirQuotation/list',
						data : {
							title : 'List'
						},
						controller : 'bulkRateReqAirquotationListCtrl',
						templateUrl : 'views/air/bulkRateReq/bulkRateReqAirQuotationList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/air/bulkRateReq/bulkRateReqAirquotationListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.air.bulkRateReq.add',
					{
						url : '/bulkRateReqAirQuotation/add',
						data : {
							title : 'Add'
						},
						controller : 'bulkRateReqAirquotationAddCtrl',
						templateUrl : 'views/air/bulkRateReq/bulkRateReqAirQuotationAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/air/bulkRateReq/bulkRateReqAirquotationAddCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.sea.hbl.list',
					{
						url : '/hbl/list',
						data : {
							title : 'List'
						},
						controller : 'hblListCtrl',
						templateUrl : 'views/sea/hbl/hblList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/hbl/hblListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.sea.hbl.add',
					{
						url : '/hbl/add',
						data : {
							title : 'Add'
						},
						controller : 'hblAddCtrl',
						templateUrl : 'views/sea/hbl/hblAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/hbl/hblAddCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.sea.hbl.edit',
					{
						url : '/hbl/edit',
						data : {
							title : 'Edit'
						},
						controller : 'hblAddCtrl',
						templateUrl : 'views/sea/hbl/hblAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/hbl/hblAddCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.sea.hbl.view',
					{
						url : '/hbl/view',
						data : {
							title : 'View'
						},
						controller : 'hblAddCtrl',
						templateUrl : 'views/sea/hbl/hblView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/hbl/hblAddCtrl.js' ]);
									} ]
						}
					})
					
					//aarthi st
					$stateProvider
			.state('app.sea.store', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Sea'
				}
			})
					.state(
					'app.sea.store.list',
					{
						url : '/store/list',
						data : {
							title : 'Store'
						},
						controller : 'storeListCtrl',
						templateUrl : 'views/sea/store/storeList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/store/storeListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.sea.store.add',
					{
						url : '/store/add',
						data : {
							title : 'Store'
						},
						controller : 'storeAddCtrl',
						templateUrl : 'views/sea/store/storeAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/store/storeAddCtrl.js' ]);
									} ]
						}
					})
					
					.state(
					'app.sea.store.edit',
					{
						url : '/hospital/purchase/storetostore/edit',
						data : {
							title : 'Edit'
						},
						controller : 'storeAddCtrl',
						templateUrl : 'views/sea/store/storeAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/store/storeAddCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.sea.store.view',
					{
						url : '/store/view',
						data : {
							title : 'View'
						},
						controller : 'storeAddCtrl',
						templateUrl : 'views/sea/store/storeView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/store/storeAddCtrl.js' ]);
									} ]
						}
					})
				
					//end
					//material st
					$stateProvider
			.state('app.sea.material', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Sea'
				}
			})
					.state(
					'app.sea.material.list',
					{
						url : '/material/list',
						data : {
							title : 'Material'
						},
						controller : 'materialListCtrl',
						templateUrl : 'views/sea/material/materialList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/material/materialListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.sea.material.add',
					{
						url : '/material/add',
						data : {
							title : 'Material'
						},
						controller : 'materialAddCtrl',
						templateUrl : 'views/sea/material/materialAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/material/materialAddCtrl.js' ]);
									} ]
						}
					})

					  .state('app.sea.material.edit', {
           url : '/hospital/purchase/consignmentRequest/edit',
           data : {
               title : 'Edit'
           },
/*           views : {
               "content@app" : {
                   controller : 'materialUpdateCtrl',
                   templateUrl : 'views/hospital/purchase/consignmentRequest/consignmentRequestUpdate',

                   resolve : {
                       deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/purchase/consignmentRequest/consignmentRequestUpdateCtrl.js' ])
                   }
               }
           }*/
           
           controller : 'materialUpdateCtrl',
			templateUrl : 'views/sea/material/materialUpdate',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/sea/material/materialUpdateCtrl.js' ]);
						} ]
			}
       })

        .state('app.sea.material.edit1', {
           url : '/hospital/purchase/consignmentRequest/edit1',
           data : {
               title : 'Edit'
           },
          /* views : {
               "content@app" : {
                   controller : 'consignmentRequestAddCtrl',
                   templateUrl : 'views/hospital/purchase/consignmentRequest/consignmentRequestAdd',

                   resolve : {
                       deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/purchase/consignmentRequest/consignmentRequestAddCtrl.js' ])
                   }
               }
           }*/
           
           controller : 'materialAddCtrl',
			templateUrl : 'views/sea/material/materialAdd',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/sea/material/materialAddCtrl.js' ]);
						} ]
			}
       })

			
       
       
       
       
       
       
       
       
       
       
          /** ********** Stock Movement ************* */
       
        
        .state('app.inventory.stockmovement', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Stock Transfer'
				}
			})
        
        
        .state('app.inventory.stockmovement.list', {
            url : '/hospital/inventory/stockMovement/list',
            data : {

                title : 'List'

            },
           /* views : {
                "content@app" : {
                    controller : 'stockMovementCtrl',
                    templateUrl : 'views/inventory/stockMovement/stockMovementList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/inventory/stockMovement/stockMovementCtrl.js' ])
                    }
                }
            }*/
            
            controller : 'stockMovementCtrl',
			templateUrl : 'views/inventory/stockMovement/stockMovementList',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/inventory/stockMovement/stockMovementCtrl.js' ]);
						} ]
			}
        })

        .state('app.inventory.stockmovement.add', {
            url : '/hospital/inventory/stockMovement/add',
            data : {
                title : 'Add'
            },
            /*views : {
                "content@app" : {
                    controller : 'stockMovementAddCtrl',
                    templateUrl : 'views/hospital/inventory/stockMovement/stockMovementAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/inventory/stockMovement/stockMovementAddCtrl.js' ])
                    }
                }
            }*/
            
            controller : 'stockMovementAddCtrl',
			templateUrl : 'views/inventory/stockMovement/stockMovementAdd',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/inventory/stockMovement/stockMovementAddCtrl.js' ]);
						} ]
			}
        })

        .state('app.inventory.stockmovement.addpopup', {
            url : '/hospital/inventory/stockMovement/addpopup',
            data : {
                title : 'Add'
            },
           /* views : {
                "content@app" : {
                    controller : 'stockMovementAddCtrl',
                    templateUrl : 'views/hospital/inventory/stockMovement/stockMovementPopUpAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/inventory/stockMovement/stockMovementAddCtrl.js' ])
                    }
                }
            }*/
            
            controller : 'stockMovementAddCtrl',
			templateUrl : 'views/inventory/stockMovement/stockMovementPopUpAdd',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/inventory/stockMovement/stockMovementAddCtrl.js' ]);
						} ]
			}
        })

        .state('app.inventory.stockmovement.edit', {
            url : '/hospital/inventory/stockMovement/edit',
            data : {
                title : 'Add'
            },
           /* views : {
                "content@app" : {
                    controller : 'stockMovementEditCtrl',
                    templateUrl : 'views/hospital/inventory/stockMovement/stockMovementAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/inventory/stockMovement/stockMovementEditCtrl.js' ])
                    }
                }
            }*/
            
            controller : 'stockMovementEditCtrl',
			templateUrl : 'views/inventory/stockMovement/stockMovementAdd',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/inventory/stockMovement/stockMovementEditCtrl.js' ]);
						} ]
			}
        })

        .state('app.inventory.stockmovement.view', {
            url : '/hospital/inventory/stockMovement/view',
            data : {
                title : 'View'
            },
          /*  views : {
                "content@app" : {
                    controller : 'stockMovementEditCtrl',
                    templateUrl : 'views/hospital/inventory/stockMovement/stockMovementView',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/inventory/stockMovement/stockMovementEditCtrl.js' ])
                    }
                }
            }*/
            
            controller : 'stockMovementEditCtrl',
			templateUrl : 'views/inventory/stockMovement/stockMovementView',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/inventory/stockMovement/stockMovementEditCtrl.js' ]);
						} ]
			}
        })

       
       
       
       
       
					//end
					
					//dep st
					
					$stateProvider
			.state('app.sea.dep', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Sea'
				}
			})
					.state(
					'app.sea.dep.list',
					{
						url : '/dep/list',
						data : {
							title : 'Dep'
						},
						controller : 'depListCtrl',
						templateUrl : 'views/sea/dep/depList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/dep/depListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.sea.dep.add',
					{
						url : '/dep/add',
						data : {
							title : 'Dep'
						},
						controller : 'depAddCtrl',
						templateUrl : 'views/sea/dep/depAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/dep/depAddCtrl.js' ]);
									} ]
						}
					})
					
					//end
					
					//approve st
					
					
					$stateProvider
			.state('app.sea.approve', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Sea'
				}
			})
					.state(
					'app.sea.approve.list',
					{
						url : '/approve/list',
						data : {
							title : 'Approve'
						},
						controller : 'approveListCtrl',
						templateUrl : 'views/sea/approve/approveList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/approve/approveListCtrl.js' ]);
									} ]
						}
					})

		
					
					 .state('app.sea.approve.edit', {
          url : '/hospital/purchase/storeapproval/edit',
          data : {
              title : 'Edit'
          },
         /* views : {
              "content@app" : {
                  controller : 'storeApprovalAddCtrl',
                  templateUrl : 'views/hospital/purchase/storeapproval/storeApprovalAdd',

                  resolve : {
                      deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/purchase/storeapproval/storeApprovalAddCtrl.js' ])
                  }
              }
          }
      })*/
          
          controller : 'approveAddCtrl',
			templateUrl : 'views/sea/approve/approveAdd',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/sea/approve/approveAddCtrl.js' ]);
						} ]
			}
		})

        .state('app.sea.approve.View', {
          url : '/purchase/storeapproval/view',
          data : {
              title : 'View'
          },

        /*  views : {
              "content@app" : {
                  controller : 'storeApprovalAddCtrl',
                  templateUrl : 'views/hospital/purchase/storeapproval/storeApprovalView',

                  resolve : {
                      deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/purchase/storeapproval/storeApprovalAddCtrl.js' ])
                  }
              }
          }
      })*/
          controller : 'approveAddCtrl',
			templateUrl : 'views/sea/approve/approveView',
			resolve : {
				deps : [
						'$ocLazyLoad',
						function($ocLazyLoad) {
							return $ocLazyLoad
									.load([ 'js/app/sea/approve/approveAddCtrl.js' ]);
						} ]
			}
		})
					//end
					
					//quotation st
					
					
					$stateProvider
			.state('app.sea.quot', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Sea'
				}
			})
					.state(
					'app.sea.quot.list',
					{
						url : '/quot/list',
						data : {
							title : 'Quot'
						},
						controller : 'quotListCtrl',
						templateUrl : 'views/sea/quot/quotList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/quot/quotListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.sea.quot.add',
					{
						url : '/quot/add',
						data : {
							title : 'Quot'
						},
						controller : 'quotAddCtrl',
						templateUrl : 'views/sea/quot/quotAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/quot/quotAddCtrl.js' ]);
									} ]
						}
					})
					
					
					//end
					
					//purchquotation
					
					
					$stateProvider
			.state('app.sea.purch', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Sea'
				}
			})
					.state(
					'app.sea.purch.list',
					{
						url : '/purch/list',
						data : {
							title : 'Purch'
						},
						controller : 'purchListCtrl',
						templateUrl : 'views/sea/purch/purchList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/purch/purchListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.sea.purch.add',
					{
						url : '/purch/add',
						data : {
							title : 'Purch'
						},
						controller : 'purchAddCtrl',
						templateUrl : 'views/sea/purch/purchAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/purch/purchAddCtrl.js' ]);
									} ]
						}
					})
					
					
					
					//end
					
					//orderdci
					
					
					$stateProvider
			.state('app.sea.orderdci', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Sea'
				}
			})
					.state(
					'app.sea.orderdci.list',
					{
						url : '/orderdci/list',
						data : {
							title : 'Orderdci'
						},
						controller : 'orderdciListCtrl',
						templateUrl : 'views/sea/orderdci/orderdciList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/orderdci/orderdciListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.sea.orderdci.add',
					{
						url : '/orderdci/add',
						data : {
							title : 'Orderdci'
						},
						controller : 'orderdciAddCtrl',
						templateUrl : 'views/sea/orderdci/orderdciAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/orderdci/orderdciAddCtrl.js' ]);
									} ]
						}
					})
					
					.state(
					'app.sea.orderdci.view',
					{
						url : '/orderdci/view',
						data : {
							title : 'View'
						},
						controller : 'orderdciAddCtrl',
						templateUrl : 'views/sea/orderdci/orderdciView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/orderdci/orderdciAddCtrl.js' ]);
									} ]
						}
					})
					
					
					/*.state(
					'app.sea.orderdci.add',
					{
						url : '/orderdci/add',
						data : {
							title : 'Orderdci'
						},
						controller : 'purchaseOrderRequestAddCtrl',
						templateUrl : 'views/sea/orderdci/orderdciRequestAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/orderdci/purchaseOrderRequestAddCtrl.js' ]);
									} ]
						}
					})*/
					
					
					//end
					
					//cons st
					
					
					$stateProvider
			.state('app.sea.cons', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Sea'
				}
			})
					.state(
					'app.sea.cons.list',
					{
						url : '/cons/list',
						data : {
							title : 'cons'
						},
						controller : 'consListCtrl',
						templateUrl : 'views/sea/cons/consList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/cons/consListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.sea.cons.add',
					{
						url : '/cons/add',
						data : {
							title : 'cons'
						},
						controller : 'consAddCtrl',
						templateUrl : 'views/sea/cons/consAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/cons/consAddCtrl.js' ]);
									} ]
						}
					})
					
					
					
					//end
					
					//orderapp
					
					$stateProvider
			.state('app.sea.orderapp', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Sea'
				}
			})
					.state(
					'app.sea.orderapp.list',
					{
						url : '/orderapp/list',
						data : {
							title : 'orderapp'
						},
						controller : 'orderappListCtrl',
						templateUrl : 'views/sea/orderapp/orderappList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/orderapp/orderappListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.sea.orderapp.add',
					{
						url : '/orderapp/add',
						data : {
							title : 'Add'
						},
						controller : 'orderappAddCtrl',
						templateUrl : 'views/sea/orderapp/orderappAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/orderapp/orderappAddCtrl.js' ]);
									} ]
						}
					})
					
					
					.state(
					'app.sea.orderapp.view',
					{
						url : '/orderapp/view',
						data : {
							title : 'View'
						},
						controller : 'orderappAddCtrl',
						templateUrl : 'views/sea/orderapp/orderappView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/orderapp/orderappAddCtrl.js' ]);
									} ]
						}
					})
					
					//end
					
					//cancel purchase
					
					$stateProvider
			.state('app.sea.cancelpurch', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Sea'
				}
			})
					.state(
					'app.sea.cancelpurch.list',
					{
						url : '/cancelpurch/list',
						data : {
							title : 'cancelpurch'
						},
						controller : 'cancelpurchListCtrl',
						templateUrl : 'views/sea/cancelpurch/cancelpurchList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/cancelpurch/cancelpurchListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.sea.cancelpurch.add',
					{
						url : '/cancelpurch/add',
						data : {
							title : 'cancelpurch'
						},
						controller : 'cancelpurchAddCtrl',
						templateUrl : 'views/sea/cancelpurch/cancelpurchAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/cancelpurch/cancelpurchAddCtrl.js' ]);
									} ]
						}
					})
					
					
					
					//end
					
					//amendment
					
					$stateProvider
			.state('app.sea.amendment', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Sea'
				}
			})
					.state(
					'app.sea.amendment.list',
					{
						url : '/amendment/list',
						data : {
							title : 'amendment'
						},
						controller : 'amendmentListCtrl',
						templateUrl : 'views/sea/amendment/amendmentList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/amendment/amendmentListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.sea.amendment.add',
					{
						url : '/amendment/add',
						data : {
							title : 'amendment'
						},
						controller : 'amendmentAddCtrl',
						templateUrl : 'views/sea/amendment/amendmentAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/amendment/amendmentAddCtrl.js' ]);
									} ]
						}
					})
					
					
					
					//end
					
					//vendor st
					
					
					$stateProvider
			.state('app.sea.vendor', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Sea'
				}
			})
					.state(
					'app.sea.vendor.list',
					{
						url : '/vendor/list',
						data : {
							title : 'vendor'
						},
						controller : 'vendorListCtrl',
						templateUrl : 'views/sea/vendor/vendorList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/vendor/vendorListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.sea.vendor.add',
					{
						url : '/vendor/add',
						data : {
							title : 'vendor'
						},
						controller : 'vendorAddCtrl',
						templateUrl : 'views/sea/vendor/vendorAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/vendor/vendorAddCtrl.js' ]);
									} ]
						}
					})
					
						.state(
					'app.sea.vendor.edit',
					{
						url : '/vendor/edit/:entityId',
						data : {
							title : 'vendor'
						},
						controller : 'vendorAddCtrl',
						templateUrl : 'views/sea/vendor/vendorAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/vendor/vendorAddCtrl.js' ]);
									} ]
						}
					})
					
					//end
					
					//kitchen gate st
					
					$stateProvider
			.state('app.sea.kitchen', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Sea'
				}
			})
					.state(
					'app.sea.kitchen.list',
					{
						url : '/kitchen/list',
						data : {
							title : 'kitchen'
						},
						controller : 'kitchenListCtrl',
						templateUrl : 'views/sea/kitchen/kitchenList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/kitchen/kitchenListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.sea.kitchen.add',
					{
						url : '/kitchen/add',
						data : {
							title : 'kitchen'
						},
						controller : 'kitchenAddCtrl',
						templateUrl : 'views/sea/kitchen/kitchenAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/kitchen/kitchenAddCtrl.js' ]);
									} ]
						}
					})
					
					
					
					//end
					
					//work order approve
					
					$stateProvider
			.state('app.sea.order', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Sea'
				}
			})
					.state(
					'app.sea.order.list',
					{
						url : '/order/list',
						data : {
							title : 'order'
						},
						controller : 'orderListCtrl',
						templateUrl : 'views/sea/order/orderList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/order/orderListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.sea.order.add',
					{
						url : '/order/add',
						data : {
							title : 'order'
						},
						controller : 'orderAddCtrl',
						templateUrl : 'views/sea/order/orderAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/order/orderAddCtrl.js' ]);
									} ]
						}
					})
					
					
					//end
					
					//vendor rating
					
					$stateProvider
			.state('app.sea.rating', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Sea'
				}
			})
					.state(
					'app.sea.rating.list',
					{
						url : '/rating/list',
						data : {
							title : 'rating'
						},
						controller : 'ratingListCtrl',
						templateUrl : 'views/sea/rating/ratingList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/rating/ratingListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.sea.rating.add',
					{
						url : '/rating/add',
						data : {
							title : 'rating'
						},
						controller : 'ratingAddCtrl',
						templateUrl : 'views/sea/rating/ratingAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/rating/ratingAddCtrl.js' ]);
									} ]
						}
					})
					
					
					
					//end
					
					//manage pending
					
					$stateProvider
			.state('app.sea.pending', {
				abstract : true,
				templateUrl : "views/common",
				data : {
					title : 'Sea'
				}
			})
					.state(
					'app.sea.pending.list',
					{
						url : '/pending/list',
						data : {
							title : 'pending'
						},
						controller : 'pendingListCtrl',
						templateUrl : 'views/sea/pending/pendingList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/pending/pendingListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.sea.pending.add',
					{
						url : '/pending/add',
						data : {
							title : 'pending'
						},
						controller : 'pendingAddCtrl',
						templateUrl : 'views/sea/pending/pendingAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/pending/pendingAddCtrl.js' ]);
									} ]
						}
					})
					
					
					
					
					//end
					
					
	$stateProvider.state('app.sea.fwdhbl', {
		abstract : true,
		templateUrl : "views/common",
		data : {
			title : 'HBL'
		}
	})
					.state(
					'app.sea.fwdhbl.list',
					{
						url : '/fwdhbl/list',
						data : {
							title : 'List'
						},
						controller : 'fwdhblListCtrl',
						templateUrl : 'views/sea/fwdhbl/fwdhblList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/fwdhbl/fwdhblListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.sea.fwdhbl.add',
					{
						url : '/fwdhbl/add',
						data : {
							title : 'Add'
						},
						controller : 'fwdhblAddCtrl',
						templateUrl : 'views/sea/fwdhbl/fwdhblAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/fwdhbl/fwdhblAddCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.sea.fwdhbl.edit',
					{
						url : '/fwdhbl/edit',
						data : {
							title : 'Edit'
						},
						controller : 'fwdhblAddCtrl',
						templateUrl : 'views/sea/fwdhbl/fwdhblAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/fwdhbl/fwdhblAddCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.sea.fwdhbl.view',
					{
						url : '/fwdhbl/view',
						data : {
							title : 'View'
						},
						controller : 'fwdhblAddCtrl',
						templateUrl : 'views/sea/fwdhbl/fwdhblView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/fwdhbl/fwdhblAddCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.sea.mabl.list',
					{
						url : '/mabl/list',
						data : {
							title : 'List'
						},
						controller : 'mablListCtrl',

						templateUrl : 'views/sea/mabl/mablList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/mabl/mablListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.sea.mabl.add',
					{
						url : '/mabl/add',
						data : {
							title : 'Add'
						},
						controller : 'mablAddCtrl',
						templateUrl : 'views/sea/mabl/mablAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/mabl/mablAddCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.sea.mabl.edit',
					{
						url : '/mabl/edit',
						data : {
							title : 'Edit'
						},
						controller : 'mablAddCtrl',
						templateUrl : 'views/sea/mabl/mablAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/mabl/mablAddCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.sea.mabl.view',
					{
						url : '/mabl/view',
						data : {
							title : 'View'
						},
						controller : 'mablViewCtrl',
						templateUrl : 'views/sea/mabl/mablView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/mabl/mablAddCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.air.hbw.list',
					{
						url : '/hbw/list',
						data : {
							title : 'List'
						},
						controller : 'hbwListCtrl',
						templateUrl : 'views/air/hbw/hbwList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/air/hbw/hbwListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.air.hbw.add',
					{
						url : '/hbw/add',
						data : {
							title : 'Add'
						},
						controller : 'hbwAddCtrl',
						templateUrl : 'views/air/hbw/hbwAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/air/hbw/hbwAddCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.air.hbw.edit',
					{
						url : '/hbw/edit',
						data : {
							title : 'Edit'
						},
						controller : 'hbwAddCtrl',
						templateUrl : 'views/air/hbw/hbwAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/air/hbw/hbwAddCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.air.hbw.view',
					{
						url : '/hbw/view',
						data : {
							title : 'View'
						},
						controller : 'hbwViewCtrl',
						templateUrl : 'views/air/hbw/hbwView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/air/hbw/hbwAddCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.air.mabw.list',
					{
						url : '/mabw/list',
						data : {
							title : 'List'
						},
						controller : 'mabwListCtrl',

						templateUrl : 'views/air/mabw/mabwList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/air/mabw/mabwListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.air.mabw.add',
					{
						url : '/mabw/add',
						data : {
							title : 'Add'
						},
						controller : 'mabwAddCtrl',
						templateUrl : 'views/air/mabw/mabwAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/air/mabw/mabwAddCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.air.mabw.edit',
					{
						url : '/mabw/edit',
						data : {
							title : 'Edit'
						},
						controller : 'mabwAddCtrl',
						templateUrl : 'views/air/mabw/mabwAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/air/mabw/mabwAddCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.air.mabw.view',
					{
						url : '/mabw/view',
						data : {
							title : 'View'
						},
						controller : 'mabwViewCtrl',
						templateUrl : 'views/air/mabw/mabwView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/air/mabw/mabwAddCtrl.js' ]);
									} ]
						}
					})
			//air job		
			.state(
					'app.air.joborder.list',
					{
						url : '/joborder/list',
						data : {
							title : 'List'
						},
						controller : 'joborderlistctrl',
						templateUrl : 'views/air/JobOrderList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/air/joborder/jobOrderListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.air.joborder.add',
					{
						url : '/joborderAir/add',
						data : {
							title : 'Add'
						},
						controller : 'joborderAddctrl',
						templateUrl : 'views/air/JobOrderAirAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/air/joborder/jobOrderListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.air.joborder.edit',
					{
						url : '/jobOrderAir/edit',
						data : {
							title : 'Edit'
						},
						controller : 'joborderEditctrl',

						templateUrl : 'views/air/JobOrderAirAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/air/joborder/jobOrderListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.air.joborder.view',
					{
						url : '/jobOrderAir/view',
						data : {
							title : 'View'
						},
						controller : 'joborderViewCtrlNew1',

						templateUrl : 'views/air/JobOrderView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/air/joborder/jobOrderListCtrl.js' ]);
									} ]
						}
					})
			// sea job order

			.state(
					'app.sea.joborder.list',
					{
						url : '/seajoborder/list',
						data : {
							title : 'List'
						},
						controller : 'joborderlistctrl1',
						templateUrl : 'views/sea/JobOrderList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/joborder/jobOrderListCtrl.js' ]);
									} ]
						}
					})
			.state(
					'app.sea.joborder.add',
					{
						url : '/joborderSea/add',
						data : {
							title : 'Add'
						},
						controller : 'joborderAddctrl1',
						templateUrl : 'views/sea/JobOrderSeaAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/joborder/jobOrderListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.sea.joborder.edit',
					{
						url : '/jobOrderSea/edit',
						data : {
							title : 'Edit'
						},
						controller : 'joborderViewCtrl1',

						templateUrl : 'views/sea/JobOrderSeaAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/joborder/jobOrderListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.sea.joborder.view',
					{
						url : '/jobOrderSea/view',
						data : {
							title : 'View'
						},
						controller : 'joborderViewCtrlNew',

						templateUrl : 'views/sea/JobOrderView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/joborder/jobOrderListCtrl.js' ]);
									} ]
						}
					})
					// sea job order App

			.state(
					'app.sea.joborderApp.list',
					{
						url : '/seajoborderApp/list',
						data : {
							title : 'List'
						},
						controller : 'joborderlistctrlApp',
						templateUrl : 'views/sea/JobOrderListApp',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/joborder/jobOrderListCtrlApp.js' ]);
									} ]
						}
					})
			.state(
					'app.sea.joborderApp.add',
					{
						url : '/joborderSeaApp/add',
						data : {
							title : 'Add'
						},
						controller : 'joborderAddctrl1',
						templateUrl : 'views/sea/JobOrderSeaAddApp',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/joborder/jobOrderListCtrlApp.js' ]);
									} ]
						}
					})

			.state(
					'app.sea.joborderApp.edit',
					{
						url : '/jobOrderSeaApp/edit',
						data : {
							title : 'Edit'
						},
						controller : 'joborderViewCtrl1',

						templateUrl : 'views/sea/JobOrderSeaAddApp',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/joborder/jobOrderListCtrlApp.js' ]);
									} ]
						}
					})
					.state(
					'app.sea.joborderApp.Approval',
					{
						url : '/jobOrderSeaApp/Approval',
						data : {
							title : 'Approval'
						},
						controller : 'joborderViewCtrl1',

						templateUrl : 'views/sea/jobOrderApproval',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/joborder/jobOrderListCtrlApp.js' ]);
									} ]
						}
					})
/*.state(
					'app.sea.joborderApp.Approval',
					{
						url : '/joborderApp/Approval',
						data : {
							title : 'Approval'
						},
						templateUrl : "/views/sea/jobOrderApproval",
						controller : 'joborderViewCtrlNew',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/joborder/jobOrderListCtrlApp.js' ]);
									} ]
						}
					})*/
			.state(
					'app.sea.joborderApp.view',
					{
						url : '/jobOrderSeaApp/view',
						data : {
							title : 'View'
						},
						controller : 'joborderViewCtrlNew',

						templateUrl : '/views/sea/JobOrderSeaViewApp',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/joborder/jobOrderListCtrlApp.js' ]);
									} ]
						}
					})

			// air booking
			.state(
					'app.air.booking.list',
					{
						url : '/airbooking/list',
						data : {
							title : 'List'
						},
						controller : 'airbookinglistctrl',
						templateUrl : 'views/air/BookingList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/air/booking/bookingListCtrl.js' ]);
									} ]
						}
					})
					

			.state(
					'app.air.booking.add',
					{
						url : '/bookingAir/add',
						data : {
							title : 'Add'
						},
						controller : 'bookingAddctrl',
						templateUrl : 'views/air/BookingAirAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/air/booking/bookingListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.air.booking.edit',
					{
						url : '/bookingAir/edit',
						data : {
							title : 'Edit'
						},
						controller : 'bookingEditctrl',

						templateUrl : 'views/air/BookingAirAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/air/booking/bookingListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.air.booking.view',
					{
						url : '/bookingAir/view',
						data : {
							title : 'View'
						},
						controller : 'bookingEditctrl',

						templateUrl : 'views/air/BookingView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/air/booking/bookingListCtrl.js' ]);
									} ]
						}
					})
			// sea

			.state(
					'app.sea.booking.list',
					{
						url : '/seabooking/list',
						data : {
							title : 'List'
						},
						controller : 'seaBookinglistctrl',
						templateUrl : 'views/sea/BookingList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/booking/bookingListCtrl.js' ]);
									} ]
						}
					})
			.state(
					'app.sea.booking.add',
					{
						url : '/bookingSea/add',
						data : {
							title : 'Add'
						},
						controller : 'seaBookingAddctrl',
						templateUrl : 'views/sea/BookingSeaAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/booking/bookingListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.sea.booking.edit',
					{
						url : '/bookingSea/edit',
						data : {
							title : 'Edit'
						},
						controller : 'seaBookingViewCtrl',

						templateUrl : 'views/sea/BookingSeaAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/booking/bookingListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.sea.booking.view',
					{
						url : '/bookingSea/view',
						data : {
							title : 'View'
						},
						controller : 'seaBookingViewCtrl',

						templateUrl : 'views/sea/BookingSeaView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/booking/bookingListCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.air.quotation.list',
					{
						url : '/airQuotation/list',
						data : {
							title : 'List'
						},
						controller : 'airquotationListCtrl',
						templateUrl : 'views/air/quotation/airQuotationList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/air/airquotationListCtrl.js' ]);
									} ]
						}
					})

			

			.state(
					'app.air.quotation.add',
					{
						url : '/airQuotation/add',
						data : {
							title : 'Add'
						},
						controller : 'airquotationAddCtrl',
						templateUrl : 'views/air/quotation/airQuotationAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/air/airquotationAddCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.air.quotation.edit',
					{
						url : '/airQuotation/edit',
						data : {
							title : 'Edit'
						},
						templateUrl : "views/air/quotation/airQuotationAdd",
						controller : 'airquotationEditCtrl',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/air/airquotationAddCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.air.quotation.view',
					{
						url : '/airQuotation/view',
						data : {
							title : 'View'
						},
						templateUrl : "views/air/quotation/airQuotationView",
						controller : 'airquotationViewCtrl',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/air/airquotationAddCtrl.js' ]);
									} ]
						}
					})

					
		.state(
					'app.sea.quotation.list',
					{
						url : '/seaQuotation/list',
						data : {
							title : 'List'
						},
						controller : 'seaquotationListCtrl',
						templateUrl : 'views/air/seaQuotation/seaQuotationList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/air/seaquotationListCtrl.js' ]);
									} ]
						}
					})
					
					
			.state(
					'app.sea.quotation.add',
					{
						url : '/seaQuotation/add',
						data : {
							title : 'Add'
						},
						controller : 'seaquotationAddCtrl',
						templateUrl : 'views/air/seaQuotation/seaQuotationAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/air/seaquotationAddCtrl.js' ]);
									} ]
						}
					})
.state(
					'app.sea.quotation.Add',
					{
						url : '/seaQuotation/Add',
						data : {
							title : 'Add'
						},
						templateUrl : "views/air/seaQuotation/seaQuotationAdd",
						controller : 'seaquotationEditCtrl',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/air/seaquotationAddCtrl.js' ]);
									} ]
						}
					})
			.state(
					'app.sea.quotation.edit',
					{
						url : '/seaQuotation/edit',
						data : {
							title : 'Edit'
						},
						templateUrl : "views/air/seaQuotation/seaQuotationAdd",
						controller : 'seaquotationEditCtrl',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/air/seaquotationAddCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.sea.quotation.view',
					{
						url : '/seaQuotation/view',
						data : {
							title : 'View'
						},
						templateUrl : "views/air/seaQuotation/seaQuotationView",
						controller : 'seaquotationViewCtrl',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/air/seaquotationAddCtrl.js' ]);
									} ]
						}
					})
					.state(
					'app.sea.quotation.Approval',
					{
						url : '/seaQuotation/Approval',
						data : {
							title : 'Approval'
						},
						templateUrl : "views/air/seaQuotation/seaQuotationApproval",
						controller : 'seaquotationViewCtrl',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/air/seaquotationAddCtrl.js' ]);
									} ]
						}
					})
					//multi modal
							$stateProvider.state('app.sea.seaQuotationApproval', {
							abstract : true,
								templateUrl : "views/common",
									data : {
											title : 'Sea Quotation Approval'
										}
							})
					.state(
					'app.sea.seaQuotationApproval.list',
					{
						url : '/seaQuotationApproval/list',
						data : {
							title : 'List'
						},
						controller : 'seaquotationListCtrl',
						templateUrl : 'views/air/seaQuotationApproval/seaQuotationList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/air/seaquotationAppListCtrl.js' ]);
									} ]
						}
					})
					
					
			.state(
					'app.sea.seaQuotationApproval.add',
					{
						url : '/seaQuotationApproval/add',
						data : {
							title : 'Add'
						},
						controller : 'seaquotationAddCtrl',
						templateUrl : 'views/air/seaQuotationApproval/seaQuotationAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/air/seaquotationAppAddCtrl.js' ]);
									} ]
						}
					})
.state(
					'app.sea.seaQuotationApproval.Add',
					{
						url : '/seaQuotationApproval/Add',
						data : {
							title : 'Add'
						},
						templateUrl : "views/air/seaQuotationApproval/seaQuotationAdd",
						controller : 'seaquotationEditCtrl',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/air/seaquotationAppAddCtrl.js' ]);
									} ]
						}
					})
			.state(
					'app.sea.seaQuotationApproval.edit',
					{
						url : '/seaQuotationApproval/edit',
						data : {
							title : 'Edit'
						},
						templateUrl : "views/air/seaQuotationApproval/seaQuotationAdd",
						controller : 'seaquotationEditCtrl',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/air/seaquotationAppAddCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.sea.seaQuotationApproval.view',
					{
						url : '/seaQuotationApproval/view',
						data : {
							title : 'View'
						},
						templateUrl : "views/air/seaQuotationApproval/seaQuotationView",
						controller : 'seaquotationViewCtrl',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/air/seaquotationAppAddCtrl.js' ]);
									} ]
						}
					})
					.state(
					'app.sea.seaQuotationApproval.Approval',
					{
						url : '/seaQuotationApproval/Approval/list',
						data : {
							title : 'Approval'
						},
						templateUrl : "views/air/seaQuotationApproval/seaQuotationApprovalnew",
						controller : 'seaquotationViewCtrl',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/air/seaquotationAppAddCtrl.js' ]);
									} ]
						}
					})
					//multi modal
							$stateProvider.state('app.sea.multiModal', {
							abstract : true,
								templateUrl : "views/common",
									data : {
											title : 'Multi Modal'
										}
							})
					.state(
					'app.sea.multiModal.list',
					{
						url : '/multiModal/list',
						data : {
							title : 'List'
						},
						controller : 'multiModalListCtrl',
						templateUrl : 'views/sea/multiModal/multiModalList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/sea/multiModal/multiModalListCtrl.js' ]);
									} ]
						}
					})
					
					// Air Cargo Tariff
					$stateProvider.state('app.air.cargotariff', {
							abstract : true,
								templateUrl : "views/common",
									data : {
											title : 'Air Tariff Rates'
										}
							})
					.state(
					'app.air.cargotariff.list',
					{
						url : '/aircargotariff/list',
						data : {
							title : 'Add'
						},
						controller : 'chargeHeadAddCtrl',
						templateUrl : 'views/air/cargotariff/cargotariffList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/air/cargotariff/cargotariffListCtrl.js' ]);
									} ]
						}
					})
					
					

			// Sea Delivery Order

			.state(
					'app.sea.deliveryorder.list',
					{
						url : '/deliveryorder/list',
						data : {
							title : 'List'
						},
						controller : 'deliveryorderListCtrl',
						templateUrl : 'views/air/deliveryOrder/deliveryOrderList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/air/deliveryOrder/deliveryOrderListCtrl.js' ]);
									} ]
						}
					})
			.state(
					'app.sea.deliveryorder.add',
					{
						url : '/deliveryorder/add',
						data : {
							title : 'Add'
						},
						controller : 'deliveryorderAddCtrl',
						templateUrl : 'views/air/deliveryOrder/deliveryOrderAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/air/deliveryOrder/deliveryOrderAddCtrl.js' ]);
									} ]
						}
					})
			.state(
					'app.sea.deliveryorder.edit',
					{
						url : '/deliveryorder/edit',
						data : {
							title : 'Edit'
						},
						controller : 'deliveryorderAddCtrl',
						templateUrl : 'views/air/deliveryOrder/deliveryOrderAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/air/deliveryOrder/deliveryOrderAddCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.sea.deliveryorder.view',
					{
						url : '/deliveryorder/view',
						data : {
							title : 'View'
						},
						controller : 'deliveryorderViewCtrl',
						templateUrl : 'views/air/deliveryOrder/deliveryOrderView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/air/deliveryOrder/deliveryOrderAddCtrl.js' ]);
									} ]
						}
					})
			// Air Delivery Order

			.state(
					'app.air.deliveryorder.list',
					{
						url : '/airdeliveryorder/list',
						data : {
							title : 'List'
						},
						controller : 'airdeliveryorderListCtrl',
						templateUrl : 'views/air/airdeliveryOrderList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/air/airdeliveryOrderListCtrl.js' ]);
									} ]
						}
					})
			.state(
					'app.air.deliveryorder.add',
					{
						url : '/airdeliveryorder/add',
						data : {
							title : 'Add'
						},
						controller : 'airdeliveryorderAddCtrl',
						templateUrl : 'views/air/airdeliveryOrderAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/air/airdeliveryOrderAddCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.air.deliveryorder.edit',
					{
						url : '/airdeliveryorder/edit',
						data : {
							title : 'Edit'
						},
						controller : 'airdeliveryorderAddCtrl',
						templateUrl : 'views/air/airdeliveryOrderAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/air/airdeliveryOrderAddCtrl.js' ]);
									} ]
						}
					})

			.state(
					'app.air.deliveryorder.view',
					{
						url : '/airdeliveryorder/view',
						data : {
							title : 'View'
						},
						controller : 'airdeliveryorderAddCtrl',
						templateUrl : 'views/air/airdeliveryOrderView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/air/airdeliveryOrderAddCtrl.js' ]);
									} ]
						}
					})
					.state('app.tools.tracking',
					{
						url : '/Tools/Tracking',
						data : {
							title : 'Tracking'
						},
						controller : 'trackingListCtrl',
						templateUrl : 'views/tools/tracking/trackingList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/tools/tracking/trackingListCtrl.js' ]);
									} ]
						}
					})
					
					//Air Tariff
					
					.state(
					'app.air.tariff.list',
					{
						url : '/airTariff/list',
						data : {
							title : 'List'
						},
						controller : 'airtariffListCtrl',
						templateUrl : 'views/air/tariff/airTariffList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/air/airtariffListCtrl.js' ]);
									} ]
						}
					})
					
								.state(
					'app.air.tariff.add',
					{
						url : '/airTariff/add',
						data : {
							title : 'Add'
						},
						controller : 'airtariffAddCtrl',
						templateUrl : 'views/air/tariff/airTariffAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/air/airtariffAddCtrl.js' ]);
									} ]
						}
					})
					
					.state(
					'app.air.tariff.edit',
					{
						url : '/airTariff/edit',
						data : {
							title : 'Edit'
						},
						controller : 'airtariffEditCtrl',
						templateUrl : 'views/air/tariff/airTariffAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/air/airtariffAddCtrl.js' ])
									} ]
						}

					})
					
					.state(
					'app.air.tariff.view',
					{
						url : '/airTariff/view',
						data : {
							title : 'View'
						},
						controller : 'airtariffEditCtrl',
						templateUrl : 'views/air/tariff/airTariffView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/air/airtariffAddCtrl.js' ])
									} ]
						}

					})
					
					
					//Sea Tariff
					
					.state(
					'app.sea.tariff.list',
					{
						url : '/seaTariff/list',
						data : {
							title : 'List'
						},
						controller : 'seatariffListCtrl',
						templateUrl : 'views/sea/tariff/seaTariffList',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/air/seatariffListCtrl.js' ]);
									} ]
						}
					})
					
								.state(
					'app.sea.tariff.add',
					{
						url : '/seaTariff/add',
						data : {
							title : 'Add'
						},
						controller : 'seatariffAddCtrl',
						templateUrl : 'views/sea/tariff/seaTariffAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/air/seatariffAddCtrl.js' ]);
									} ]
						}
					})
					
					.state(
					'app.sea.tariff.edit',
					{
						url : '/seaTariff/edit',
						data : {
							title : 'Edit'
						},
						controller : 'seatariffEditCtrl',
						templateUrl : 'views/sea/tariff/seaTariffAdd',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/air/seatariffAddCtrl.js' ])
									} ]
						}

					})
					
					.state(
					'app.sea.tariff.view',
					{
						url : '/seaTariff/view',
						data : {
							title : 'View'
						},
						controller : 'seatariffViewCtrl',
						templateUrl : 'views/sea/tariff/seaTariffView',
						resolve : {
							deps : [
									'$ocLazyLoad',
									function($ocLazyLoad) {
										return $ocLazyLoad
												.load([ 'js/app/air/seatariffAddCtrl.js' ])
									} ]
						}

					})

						$stateProvider.state('app.sea.can', {
		abstract : true,
		templateUrl : "views/common",
		data : {
			title : 'CAN'
		}
	})
					.state(
							'app.sea.can.list',
							{
								url : '/can/list',
								data : {
									title : 'List'
								},
								controller : 'canListCtrl',
								templateUrl : 'views/sea/can/canList',
								resolve : {
									deps : [
											'$ocLazyLoad',
											function($ocLazyLoad) {
												return $ocLazyLoad
														.load([ 'js/app/sea/can/canListCtrl.js' ]);
											} ]
								}
							})

}
angular.module('neuboard').config(config).run(function($rootScope, $state) {
	$rootScope.$state = $state;
});
