




function config($stateProvider, $urlRouterProvider, $locationProvider) { 
//alert(87);

$stateProvider.state('app.payroll', {
    abstract : true,
    templateUrl : "views/common",
    data : {
        title : 'Payroll'
    }
})








    .state('app.payroll.earning', {
		abstract : true,
		templateUrl : "views/common.jsp",
		data : {
			title : 'Earning'
		}
	})
	
			 //Earning Deduction Edit
	        .state('app.payroll.earning.list', {
				url : '/payroll/payroll/earning/list',
				data : {
					title : 'List'
				},

				controller : 'earningCtrl',
				templateUrl : 'views/payroll/earning/earningList',
				
				
				resolve : {
					deps : [
							'$ocLazyLoad',
							function($ocLazyLoad) {
								return $ocLazyLoad
										.load([ 'js/app/payroll/earning/earningCtrl.js' ]);
							} ]

				}

			})
								
			 //Earning Deduction Add
	        .state('app.payroll.earning.add', {
	            url : '/payroll/earning/add',
	            data : {
	                title : 'Add'
	            },
	                    controller : 'earningaddCtrl',
	                    templateUrl : 'views/payroll/earning/earningadd',

	                    resolve : {
	                        deps : [
	                    		'$ocLazyLoad',
	                			function($ocLazyLoad) {
	                			return $ocLazyLoad
	                					.load([ 'js/app/payroll/earning/earningaddCtrl.js' ]);
	                			} ]
	            }
	        })
	        
	        //Earning Deduction Edit
	        .state('app.payroll.earning.edit', {
	            url : '/payroll/earning/edit',
	            data : {
	                title : 'Edit'
	            },
	                    controller : 'earningEditCtrl',
	                    templateUrl : 'views/payroll/earning/earningadd',

	                    resolve : {
	                        deps : [
	                    		'$ocLazyLoad',
	                			function($ocLazyLoad) {
	                			return $ocLazyLoad
	                					.load([ 'js/app/payroll/earning/earningaddCtrl.js' ]);
	                			} ]
	            }
	        })
			
	       
	        
	                // Grade Salary fixation
	         .state('app.payroll.gradesalaryfixation', {
		abstract : true,
		templateUrl : "views/common.jsp",
		data : {
			title : 'Grade Salary Fixation'
		}
	})
	
			 //Earning Deduction Edit
	        .state('app.payroll.gradesalaryfixation.list', {
				url : '/payroll/payroll/gradesalaryfixation/list',
				data : {
					title : 'List'
				},

				controller : 'gradesalaryfixationCtrl',
				templateUrl : 'views/payroll/gradesalaryfixation/gradesalaryfixationList',
				
				
				resolve : {
					deps : [
							'$ocLazyLoad',
							function($ocLazyLoad) {
								return $ocLazyLoad
										.load([ 'js/app/payroll/gradesalaryfixation/gradesalaryfixationCtrl.js' ]);
							} ]

				}

			})
								
	        
	        
	        
	        
        //add
        
        
           .state('app.payroll.gradesalaryfixation.add', {
            url : '/payroll/gradesalaryfixation/add',
            data : {
                title : 'List'
            },
                    controller : 'gradesalaryfixationaddCtrl',
                    templateUrl : 'views/payroll/gradesalaryfixation/gradesalaryfixationAdd',
	                    resolve : {
	                        deps : [
	                    		'$ocLazyLoad',
	                			function($ocLazyLoad) {
	                			return $ocLazyLoad
	                					.load([ 'js/app/payroll/gradesalaryfixation/gradesalaryfixationaddCtrl.js' ]);
	                			} ]
	            }
                    	
                    	
                    
            
        })
        
        
        
        //edit
        
            
           .state('app.payroll.gradesalaryfixation.edit', {
            url : '/payroll/gradesalaryfixation/edit',
            data : {
                title : 'List'
            },
                    controller : 'gradesalaryfixationaddCtrl',
                    templateUrl : 'views/payroll/gradesalaryfixation/gradesalaryfixationAdd',
	                    resolve : {
	                        deps : [
	                    		'$ocLazyLoad',
	                			function($ocLazyLoad) {
	                			return $ocLazyLoad
	                					.load([ 'js/app/payroll/gradesalaryfixation/gradesalaryfixationaddCtrl.js' ]);
	                			} ]
	            }
                    	
                    	
                    
            
        })
        
       //list
        .state('app.payroll.gradesalaryfixation.getList', {
            url : 'payroll/gradesalaryfixation/getList',
            data : {
                title : 'List'
            },
                    controller : 'gradesalaryfixationCtrl',
                    templateUrl : 'views/payroll/gradesalaryfixation/gradesalaryfixationList',
                    resolve : {
                    	deps: [
                    		'$ocLazyLoad',
                			function($ocLazyLoad) {
                			return $ocLazyLoad
                					.load([ 'js/app/payroll/gradesalaryfixation/gradesalaryfixationCtrl.js' ]);
                			} ]
                    }
                                 
        })
        
        
   
        
          .state('app.payroll.salaryfixation', {
		abstract : true,
		templateUrl : "views/common.jsp",
		data : {
			title : 'Salary Fixation'
		}
	})
	
			 //Earning Deduction Edit
	        .state('app.payroll.salaryfixation.list1', {
				url : '/payroll/salaryfixation/list1',
				data : {
					title : 'List'
				},

				controller : 'salaryfixationCtrl1',
				templateUrl : 'views/payroll/salaryfixation/salaryfixationList1',
				
				
				resolve : {
					deps : [
							'$ocLazyLoad',
							function($ocLazyLoad) {
								return $ocLazyLoad
										.load([ 'js/app/payroll/salaryfixation/salaryfixationCtrl1.js' ]);
							} ]

				}

			})
								
        
        
        
        
        
       .state('app.payroll.salaryfixation.add', {
            url : '/payroll/salaryfixation/add',
            data : {
                title : 'Add'
            },
                    controller : 'salaryfixationAddCtrl',
                    templateUrl : 'views/payroll/salaryfixation/salaryfixationAdd',

                    resolve : {
                    	
                    	deps: [
                    		'$ocLazyLoad',
                			function($ocLazyLoad) {
                			return $ocLazyLoad
                					.load([ 'js/app/payroll/salaryfixation/salaryfixationAddCtrl.js' ]);
                			} ] 
                
            }
        })

        .state('app.payroll.salaryfixation.edit', {
            url : '/payroll/salaryfixation/edit',
            data : {
                title : 'Edit'
            },
                    controller : 'salaryfixationAddCtrl',
                    templateUrl : 'views/payroll/salaryfixation/salaryfixationAdd',

                    resolve : {
                    	
                    	deps: [
                    		'$ocLazyLoad',
                			function($ocLazyLoad) {
                			return $ocLazyLoad
                					.load([ 'js/app/payroll/salaryfixation/salaryfixationAddCtrl.js' ]);
                			} ] 
                
                    }
                
            
        })

        
          .state('app.payroll.salaryfixation.view', {
            url : '/payroll/salaryfixation/view',
            data : {
                title : 'View'
            },
                    controller : 'salaryfixationAddCtrl',
                    templateUrl : 'views/payroll/salaryfixation/salaryfixationView',

                    resolve : {
                    	deps: [
                    		'$ocLazyLoad',
                			function($ocLazyLoad) {
                			return $ocLazyLoad
                					.load([ 'js/app/payroll/salaryfixation/salaryfixationAddCtrl.js' ]);
                			} ] 
                
                    	
                    }
        })
        
          .state('app.payroll.salaryfixation.getValue', {
            url : '/payroll/salaryfixation/getValue',
            data : {
                title : 'Add'
            },
                    controller : 'salaryfixationAddCtrl',
                    templateUrl : 'views/payroll/salaryfixation/salaryfixationAdd',

                    resolve : {
                    	
                    	deps: [
                    		'$ocLazyLoad',
                			function($ocLazyLoad) {
                			return $ocLazyLoad
                					.load([ 'js/app/payroll/salaryfixation/salaryfixationAddCtrl.js' ]);
                			} ] 
                
                    }
                
            
        })
        
        
        
        
        
        
          .state('app.payroll.salaryfixation.getList', {
            url : '/payroll/salaryfixation/getList',
            data : {
                title : 'Edit'
            },
                    controller : 'salaryfixationCtrl',
                    templateUrl : 'views/payroll/salaryfixation/salaryfixationList',

                    resolve : {
                    	
                    	deps: [
                    		'$ocLazyLoad',
                			function($ocLazyLoad) {
                			return $ocLazyLoad
                					.load([ 'js/app/payroll/salaryfixation/salaryfixationCtrl.js' ]);
                			} ] 
                
                    }
                
            
        })
        
        
        
        
        
        
        
        
        //proffTax
         
              .state('app.payroll.ProffTaxSlabRate', {
		abstract : true,
		templateUrl : "views/common.jsp",
		data : {
			title : 'Professional Tax Slab Rate'
		}
	})
        
        
        .state('app.payroll.ProffTaxSlabRate.list', {
            url : '/payroll/ProffessionalTaxSlabRate/List',
            data : {
                title : 'List'
            },
                    controller : 'PffTaxSlabCtrl',
                    templateUrl : 'views/payroll/ProffessionalTaxSlabRate/ProffTaxSlabRateList',

                    resolve : {
                    	deps: [
                    		'$ocLazyLoad',
                			function($ocLazyLoad) {
                			return $ocLazyLoad
                					.load([ 'js/app/payroll/ProffessionalTaxSlabRate/PffTaxSlabCtrl.js' ]);
                			} ] 
                
                    
                            }
        })
        
        
           .state('app.payroll.ProffTaxSlabRate.add', {
            url : '/payroll/ProffessionalTaxSlabRate/add',
            data : {
                title : 'Add'
            },
                    controller : 'PffTaxSlabCtrlAddCtrl',
                    templateUrl : 'views/payroll/ProffessionalTaxSlabRate/ProffTaxSlabRateAdd',

                    resolve : {
                    	deps: [
                    		'$ocLazyLoad',
                			function($ocLazyLoad) {
                			return $ocLazyLoad
                					.load([ 'js/app/payroll/ProffessionalTaxSlabRate/PffTaxSlabCtrlAddCtrl.js' ]);
                			} ] 
                
                    
                
            }
        })
        
             .state('app.payroll.ProffTaxSlabRate.edit', {
            url : '/payroll/ProffessionalTaxSlabRate/edit',
            data : {
                title : 'Edit'
            },
                    controller : 'PffTaxSlabCtrlAddCtrl',
                    templateUrl : 'views/payroll/ProffessionalTaxSlabRate/ProffTaxSlabRateAdd',

                    resolve : {
                    	deps: [
                    		'$ocLazyLoad',
                			function($ocLazyLoad) {
                			return $ocLazyLoad
                					.load([ 'js/app/payroll/ProffessionalTaxSlabRate/PffTaxSlabCtrlAddCtrl.js' ]);
                			} ] 
                
                    }
        })
        
        
        
        
        
             .state('app.payroll.ProffTaxSlabRate.copyedit', {
            url : '/payroll/ProffessionalTaxSlabRate/copyedit',
            data : {
                title : 'Edit'
            },
                    controller : 'PffTaxSlabCtrlAddCtrl',
                    templateUrl : 'views/payroll/payroll/ProffessionalTaxSlabRate/ProffTaxSlabRateCopy',

                    resolve : {
                    	deps: [
                    		'$ocLazyLoad',
                			function($ocLazyLoad) {
                			return $ocLazyLoad
                					.load([ 'js/app/payroll/ProffessionalTaxSlabRate/PffTaxSlabCtrlAddCtrl.js' ]);
                			} ] 
                
                    
                
            }
        })
        
        
        
        
        
        
        
           // EMPLOYEE LOP

        .state('app.payroll.employeelop', {
            abstract : true,
    		templateUrl : "views/common.jsp",
            data : {
                title : 'Employee LOP'
            }
        })

        .state('app.payroll.employeelop.list', {
            url : '/payroll/payroll/employeelop/list',
            data : {
                title : 'List'
            },
                    controller : 'employeeLOPCtrl',
                    templateUrl : 'views/payroll/employeelop/lopList',

                    resolve : {
                    	
                    	deps: [
                    		'$ocLazyLoad',
                			function($ocLazyLoad) {
                			return $ocLazyLoad
                					.load([ 'js/app/payroll/employeelop/employeeLOPCtrl.js' ]);
                			} ] 
                  
                }
        })
        
        
        
         // loan Entry
        .state('app.payroll.ptslabgeneration', {
            abstract : true,
    		templateUrl : "views/common.jsp",
            data : {
                title : 'Professional Tax Generation'
            }
        })

        .state('app.payroll.ptslabgeneration.list', {
            url : '/payroll/ptslabgenerationList',
            data : {
                title : 'List'
            },
                    controller : 'ptslabgenerationCtrl',
                    templateUrl : 'views/payroll/ptslabgeneration/ptslabgenerationList',
                    resolve : {
                    	deps: [
                    		'$ocLazyLoad',
                			function($ocLazyLoad) {
                			return $ocLazyLoad
                					.load([ 'js/app/payroll/ptslabgeneration/ptslabgenerationCtrl.js' ]);
                			} ]    
            }
        })
        
              
        // payroll Generation
        .state('app.payroll.generation', {
            abstract : true,
    		templateUrl : "views/common.jsp",
            data : {
                title : 'Payroll Generation'
            }
        })

        .state('app.payroll.generation.list', {
            url : '/payroll/generation/list',
            data : {
                title : 'List'
            },
                    controller : 'generationCtrl',
                    templateUrl : 'views/payroll/generation/generationList',

                    resolve : {
                    	deps: [
                    		'$ocLazyLoad',
                			function($ocLazyLoad) {
                			return $ocLazyLoad
                					.load([ 'js/app/payroll/generation/generationCtrl.js' ]);
                			} ]   
                    	
                    }
                            
        })
        
        
        // Advance Entry
        .state('app.payroll.advance', {
            abstract : true,
    		templateUrl : "views/common.jsp",
            data : {
                title : 'Advance'
            }
        })
        
         .state('app.payroll.advance.list', {
            url : '/payroll/advance',
            data : {
                title : 'List'
            },
                    controller : 'advanceCtrl',
                    templateUrl : 'views/payroll/advance/advanceList',
                    resolve : {
                    	
                    	deps: [
                    		'$ocLazyLoad',
                			function($ocLazyLoad) {
                			return $ocLazyLoad
                					.load([ 'js/app/payroll/advance/advanceCtrl.js' ]);
                			} ]   
                    	

                    
                
            }
        })
        
        // Advance Add
        .state('app.payroll.advance.add', {
            url : '/payroll/payroll/advanceadd',
            data : {
                title : 'Add'
            },
                    controller : 'advanceAddCtrl',
                    templateUrl : 'views/payroll/advance/advanceAdd',
                    resolve : {
                    	deps: [
                    		'$ocLazyLoad',
                			function($ocLazyLoad) {
                			return $ocLazyLoad
                					.load([ 'js/app/payroll/advance/advanceAddCtrl.js' ]);
                			} ]   
                    	
                        //deps : $couchPotatoProvider.resolveDependencies([ 'payroll/payroll/advance/advanceAddCtrl' ])

                    
                
            }
        })
        // Advance Edit
        .state('app.payroll.advance.edit', {
            url : '/payroll/advance/advanceedit',
            data : {
                title : 'Advance Edit'
            },
                    controller : 'advanceAddCtrl',
                    templateUrl : 'views/payroll/advance/advanceAdd',
                    resolve : {
                    	deps: [
                    		'$ocLazyLoad',
                			function($ocLazyLoad) {
                			return $ocLazyLoad
                					.load([ 'js/app/payroll/advance/advanceAddCtrl.js' ]);
                			} ]   
                    	
                        //deps : $couchPotatoProvider.resolveDependencies([ 'payroll/payroll/advance/advanceAddCtrl' ])
                    }

                
            
        })
        
        
        
        
        
 
        
        .state('app.payroll.withhold', {
            abstract : true,
    		templateUrl : "views/common.jsp",
            data : {
                title : 'Payroll Withhold'
            }
        })
        
         .state('app.payroll.withhold.list', {
            url : '/payroll/withhold',
            data : {
                title : 'List'
            },
                    controller : 'withHoldListCtrl',
                    templateUrl : 'views/payroll/withhold/withHoldList',
                    resolve : {
                    	deps: [
                    		'$ocLazyLoad',
                			function($ocLazyLoad) {
                			return $ocLazyLoad
                					.load([ 'js/app/payroll/withhold/withHoldListCtrl.js' ]);
                			} ] 
                    	
                        //deps : $couchPotatoProvider.resolveDependencies([ 'payroll/payroll/withhold/withHoldListCtrl' ])

                    
                
            }
        })
        
        
          .state('app.payroll.withhold.add', {
            url : '/payroll/payroll/withhold',
            data : {
                title : 'Add'
            },
                    controller : 'withHoldAddCtrl',
                    templateUrl : 'views/payroll/withhold/withHoldAdd',
                    resolve : {
                    	deps: [
                    		'$ocLazyLoad',
                			function($ocLazyLoad) {
                			return $ocLazyLoad
                					.load([ 'js/app/payroll/withhold/withHoldAddCtrl.js' ]);
                			} ] 
                    	
                       // deps : $couchPotatoProvider.resolveDependencies([ 'payroll/payroll/withhold/withHoldAddCtrl' ])

                    
                
            }
        })
        
        
        .state('app.payroll.withhold.edit', {
            url : '/payroll/withhold/withholdedit',
            data : {
                title : ' Edit'
            },
                    controller : 'withHoldAddCtrl',
                    templateUrl : 'views/payroll/withhold/withHoldAdd',
                    resolve : {
                    	
                    	deps: [
                    		'$ocLazyLoad',
                			function($ocLazyLoad) {
                			return $ocLazyLoad
                					.load([ 'js/app/payroll/withhold/withHoldAddCtrl.js' ]);
                			} ] 
                        //deps : $couchPotatoProvider.resolveDependencies([ 'payroll/payroll/withhold/withHoldAddCtrl' ])
                    }

                
            
        })
        
        //view 
        
                .state('app.payroll.payroll.withhold.view', {
            url : '/payroll/withhold/withholdview',
            data : {
                title : ' view'
            },
                    controller : 'withHoldViewCtrl',
                    templateUrl : 'views/payroll/withhold/withHoldview',
                    resolve : {
                    	
                    	deps: [
                    		'$ocLazyLoad',
                			function($ocLazyLoad) {
                			return $ocLazyLoad
                					.load([ 'js/app/payroll/withhold/withHoldViewCtrl.js' ]);
                			} ] 
                       // deps : $couchPotatoProvider.resolveDependencies([ 'payroll/payroll/withhold/withHoldViewCtrl' ])
                    }

                
            
        })
        
        //withHold report
        
        .state('app.payroll.withhold.report', {
            url : '/payroll/withholdreport/list',
            data : {
                title : 'Withhold Report'
            },
                    controller : 'WithholdReportCtrl',
                    templateUrl : 'views/payroll/withhold/withholdReport',
                    resolve : {
                    	deps: [
                    		'$ocLazyLoad',
                			function($ocLazyLoad) {
                			return $ocLazyLoad
                					.load([ 'js/app/payroll/withhold/withholdReport.js' ]);
                			} ] 
                    	
                       // deps : $couchPotatoProvider.resolveDependencies([ 'payroll/payroll/withhold/withholdReport' ])
                    }
                
            
        })
   

        // EMPLOYEE TDS

        .state('app.payroll.employeeTds', {
            abstract : true,
    		templateUrl : "views/common.jsp",
            data : {
                title : 'Employee TDS'
            }
        })

        .state('app.payroll.employeeTds.list', {
            url : '/payroll/employeeTds/list',
            data : {
                title : 'List'
            },
                    controller : 'employeeTdsCtrl',
                    templateUrl : 'views/payroll/employeeTds/employeeTdsList',

                    resolve : {
                    	deps: [
                    		'$ocLazyLoad',
                			function($ocLazyLoad) {
                			return $ocLazyLoad
                					.load([ 'js/app/payroll/employeeTds/employeeTdsCtrl.js' ]);
                			} ] 
                    	
                       // deps : $couchPotatoProvider.resolveDependencies([ 'payroll/payroll/employeeTds/employeeTdsCtrl' ])
                    }
                
            
        })
    
        
        // Degenratlation

        .state('app.payroll.degeneration', {
            abstract : true,
    		templateUrl : "views/common.jsp",
            data : {
                title : 'Payroll DeGenration'
            }
        }).state('app.payroll.degeneration.list', {
            url : '/payroll/payroll/DeGeneration/list',
            data : {
                title : 'List'
            },
                    controller : 'payrolldegenerationCtrl',
                    templateUrl : 'views/payroll/generation/DeGenerationList',

                    resolve : {
                    	
                    	deps: [
                    		'$ocLazyLoad',
                			function($ocLazyLoad) {
                			return $ocLazyLoad
                					.load([ 'js/app/payroll/generation/payrolldegenerationCtrl.js' ]);
                			} ] 
                       // deps : $couchPotatoProvider.resolveDependencies([ 'payroll/payroll/generation/payrolldegenerationCtrl' ])
                    
                
            }
        })

        .state('app.payroll.payrollreport', {
            url : '/payroll/payrollreport/list',
            data : {
                title : 'Payroll Report'
            },
                    controller : 'payRollReportCtrl',
                    templateUrl : 'views/payroll/payrollreport/payRollReports',
                    resolve : {
                    	deps: [
                    		'$ocLazyLoad',
                			function($ocLazyLoad) {
                			return $ocLazyLoad
                					.load([ 'js/app/payroll/payrollreport/payRollReport.js' ]);
                			} ] 
                        //deps : $couchPotatoProvider.resolveDependencies([ 'payroll/payroll/payrollreport/payRollReport' ])
                    
                
            }
        })

        .state('app.payroll.monthlypayrollreport', {
            url : '/payroll/payrollreport/monthlyreport',
            data : {
                title : 'Monthly Payroll Report'
            },
                    controller : 'monthlyPayrollReportCtrl',
                    templateUrl : 'views/payroll/monthlypayrollreport/monthlyPayrollReport',
                    resolve : {
                    	deps: [
                    		'$ocLazyLoad',
                			function($ocLazyLoad) {
                			return $ocLazyLoad
                					.load([ 'js/app/payroll/monthlypayrollreport/monthlyPayrollReport.js' ]);
                			} ] 
                        //deps :
                    	
                       // deps : $couchPotatoProvider.resolveDependencies([ 'payroll/payroll/monthlypayrollreport/monthlyPayrollReport' ])
                    }
                
            
        })

        .state('app.payroll.payslipreport', {
            url : '/payroll/payslipreport/list',
            data : {
                title : 'PaySlip Report'
            },
                    controller : 'paySlipReportCtrl',
                    templateUrl : 'views/payroll/payslipreport/paySlipReports',
                    resolve : {
                    	deps: [
                    		'$ocLazyLoad',
                			function($ocLazyLoad) {
                			return $ocLazyLoad
                					.load([ 'js/app/payroll/payslipreport/paySlipReport.js' ]);
                			} ] 
                    	
                        //deps : $couchPotatoProvider.resolveDependencies([ 'payroll/payroll/payslipreport/paySlipReport' ])
                    }
                
            
        })
        
        //employee bonus
         .state('app.payroll.employeebonus', {
            abstract : true,
    		templateUrl : "views/common.jsp",
            data : {
                title : 'Employee Bonus'
            }
        })

        .state('app.payroll.employeebonus.list', {
            url : '/payroll/employeebonus/list',
            data : {
                title : 'List'
            },
          
                    controller : 'employeeBonusCtrl',
                    templateUrl : 'views/payroll/employeebonus/employeeBonus',
                    resolve : {
                    	deps: [
                    		'$ocLazyLoad',
                			function($ocLazyLoad) {
                			return $ocLazyLoad
                					.load([ 'js/app/payroll/employeebonus/employeeBonus.js' ]);
                			} ] 
                    	
                        //deps : $couchPotatoProvider.resolveDependencies([ 'payroll/payroll/employeebonus/employeeBonus' ])
                
                
            }
        })

        .state('app.payroll.employeebonus.pay', {
            url : '/payroll/employeebonus/pay',
            data : {
                title : 'Payment'
            },
          
                    controller : 'employeeBonusPayCtrl',
                    templateUrl : 'views/payroll/employeebonus/employeeBonusPay',
                    resolve : {
                    	deps: [
                    		'$ocLazyLoad',
                			function($ocLazyLoad) {
                			return $ocLazyLoad
                					.load([ 'js/app/payroll/employeebonus/employeeBonusPay.js' ]);
                			} ] 
                       // deps : $couchPotatoProvider.resolveDependencies([ 'payroll/payroll/employeebonus/employeeBonusPay' ])
                    }
                
            
        })

        .state('app.payroll.employeebonus.summary', {
            url : '/payroll/employeebonus/summary',
            data : {
                title : 'Summary'
            },
                    controller : 'employeeBonusCtrl',
                    templateUrl : 'views/payroll/employeebonus/employeeBonusSummary',
                    resolve : {
                    	deps: [
                    		'$ocLazyLoad',
                			function($ocLazyLoad) {
                			return $ocLazyLoad
                					.load([ 'js/app/payroll/employeebonus/employeeBonus.js' ]);
                			} ] 
                       // deps : $couchPotatoProvider.resolveDependencies([ 'payroll/payroll/employeebonus/employeeBonus' ])
                    }
                
            
        })
        
        // EMPLOYEE ESI

        .state('app.payroll.employeeesi', {
            abstract : true,
    		templateUrl : "views/common.jsp",
            data : {
                title : 'Employee ESI Generation'
            }
        })

        .state('app.payroll.employeeesi.list', {
            url : '/payroll/employeeesi/list',
            data : {
                title : 'List'
            },
         
                    controller : 'employeeesiCtrl',
                    templateUrl : 'views/payroll/employeeesi/employeeesiList',

                    resolve : {
                    	
                    	deps: [
                    		'$ocLazyLoad',
                			function($ocLazyLoad) {
                			return $ocLazyLoad
                					.load([ 'js/app/payroll/employeeesi/employeeesiCtrl.js' ]);
                			} ] 
                      //  deps : $couchPotatoProvider.resolveDependencies([ 'payroll/payroll/employeeesi/employeeesiCtrl' ])
                    }
                
            
        })

    //employee final
        
        
        .state('app.payroll.employeeFinalSettlement', {
            abstract : true,
    		templateUrl : "views/common.jsp",
            data : {
                title : 'Employee Final Settlement'
            }
        })

        .state('app.payroll.employeeFinalSettlement.list', {
            url : '/payroll/payroll/employeeFinalSettlement/List',
            data : {
                title : 'List'
            },
                    controller : 'employeeFinalSettlementCtrl',
                    templateUrl : 'views/payroll/employeeFinalSettlement/employeeFinalSettlementList',
                    resolve : {
                    	
                      	deps: [
                    		'$ocLazyLoad',
                			function($ocLazyLoad) {
                			return $ocLazyLoad
                					.load([ 'js/app/payroll/employeeFinalSettlement/employeeFinalSettlement.js' ]);
                			} ] 
                       // deps : $couchPotatoProvider.resolveDependencies([ 'payroll/payroll/employeeFinalSettlement/employeeFinalSettlement' ])
                    }
                
            
        })

        
        //approve
        
         .state('app.payroll.employeeFinalSettlementApproval', {
            abstract : true,
    		templateUrl : "views/common.jsp",

            data : {
                title : 'Employee Final Settlement Approval'
            }
        })

        .state('app.payroll.employeeFinalSettlementApproval.list', {
            url : '/payroll/payroll/employeeFinalSettlementApproval/List',
            data : {
                title : 'List'
            },
                    controller : 'employeeFinalSettlementApprovalCtrl',
                    templateUrl : 'views/payroll/employeeFinalSettlementApproval/employeeFinalSettlementApprovalList',
                    resolve : {
                    	
                    	deps: [
                    		'$ocLazyLoad',
                			function($ocLazyLoad) {
                			return $ocLazyLoad
                					.load([ 'js/app/payroll/employeeFinalSettlementApproval/employeeFinalSettlementApproval.js' ]);
                			} ] 
                       // deps : $couchPotatoProvider.resolveDependencies([ 'payroll/payroll/employeeFinalSettlementApproval/employeeFinalSettlementApproval' ])
                    }
                
            
        })
        
          // Deduction List
        .state('app.payroll.deductionlist', {
            abstract : true,
    		templateUrl : "views/common.jsp",
            data : {
                title : 'Deduction Entry'
            }
        })

        .state('app.payroll.deductionlist.list', {
            url : '/payroll/payroll/deductionList',
            data : {
                title : 'List'
            },
                    controller : 'deductionCtrl',
                    templateUrl : 'views/payroll/ptslabgeneration/deductionList',
                    resolve : {
                    	
                    	deps: [
                    		'$ocLazyLoad',
                			function($ocLazyLoad) {
                			return $ocLazyLoad
                					.load([ 'js/app/payroll/ptslabgeneration/deductionCtrl.js' ]);
                			} ] 
                        //deps : $couchPotatoProvider.resolveDependencies([ 'js/app/payroll/payroll/ptslabgeneration/deductionCtrl.js' ])

                    
                            }
        })
        
        
        
        
        // / Loan Report ///

        .state('app.payroll.loanreport', {
            url : '/payroll/loanreport/list',
            data : {
                title : 'Loan Report'
            },
                    controller : 'loanReportCtrl',
                    templateUrl : 'views/payroll/loanreport/loanReport',
                    resolve : {
                        //deps : $couchPotatoProvider.resolveDependencies([ 'payroll/payroll/loanreport/loanReport' ])
                    
                    	deps: [
                    		'$ocLazyLoad',
                			function($ocLazyLoad) {
                			return $ocLazyLoad
                					.load([ 'js/app/payroll/loanreport/loanReport.js' ]);
                			} ] 
                
            }
        })

         // / Advance Report ///

        .state('app.payroll.advancereport', {
            url : '/payroll/advancereport/list',
            data : {
                title : 'Advance Report'
            },
                    controller : 'advanceReportCtrl',
                    templateUrl : 'views/payroll/advance/advanceReport',
                    resolve : {
                    	deps: [
                    		'$ocLazyLoad',
                			function($ocLazyLoad) {
                			return $ocLazyLoad
                					.load([ 'js/app/payroll/advance/advanceReport.js' ]);
                			} ] 
                
                       // deps : $couchPotatoProvider.resolveDependencies([ 'payroll/payroll/advance/advanceReport' ])
                    
                
            }
        }) 
        
        
        
        
        
        
        
          // EMPLOYEE EPF

        .state('app.payroll.employeeepfgeneration', {
            abstract : true,
    		templateUrl : "views/common.jsp",
            data : {
                title : 'Employee EPF Generation'
            }
        })

        .state('app.payroll.employeeepfgeneration.list', {
            url : '/payroll/employeeepfgeneration/list',
            data : {
                title : 'List'
            },
                    controller : 'employeeEpfGenerationCtrl',
                    templateUrl : 'views/payroll/employeeepfgeneration/employeeEpfGenerationList',

                    resolve : {
                    	deps: [
                    		'$ocLazyLoad',
                			function($ocLazyLoad) {
                			return $ocLazyLoad
                					.load([ 'js/app/payroll/employeeepfgeneration/employeeEpfGenerationCtrl.js' ]);
                			} ] 
                       // deps : $couchPotatoProvider.resolveDependencies([ 'payroll/payroll/employeeepfgeneration/employeeEpfGenerationCtrl' ])
                    }
                
            
        })
        
           .state('app.payroll.loantype', {
            abstract : true,
    		templateUrl : "views/common.jsp",
            data : {
                title : 'Loan Type'
            }
        })
        // loan Typeeee
        .state('app.payroll.loantype.list', {
            url : '/payroll/payroll/loantype/list',
            data : {
                title : 'List'
            },
       
             
                    controller : 'loantypeCtrl',
                    templateUrl : 'views/payroll/loantype/loanTypeList',

                    resolve : {
                    	deps: [
                    		'$ocLazyLoad',
                			function($ocLazyLoad) {
                			return $ocLazyLoad
                					.load([ 'js/app/payroll/loantype/loanTypeCtrl.js' ]);
                			} ] 
                        //deps : $couchPotatoProvider.resolveDependencies([ 'payroll/payroll/loantype/loanTypeCtrl' ])
                    
                
            }
        })
        
        
        
        // loan Entry
        .state('app.payroll.loanEntry', {
            abstract : true,
    		templateUrl : "views/common.jsp",

            data : {
                title : 'Loan Entry'
            }
        })

        .state('app.payroll.loanEntry.list', {
            url : '/payroll/payroll/loanEntryList',
            data : {
                title : 'List'
            },
                    controller : 'loanEntryCtrl',
                    templateUrl : 'views/payroll/loanentry/loanEntryList',
                    resolve : {
                    	deps: [
                    		'$ocLazyLoad',
                			function($ocLazyLoad) {
                			return $ocLazyLoad
                					.load([ 'js/app/payroll/loanentry/loanEntryCtrl.js' ]);
                			} ] 
                    	
                        //deps : $couchPotatoProvider.resolveDependencies([ 'payroll/payroll/loanentry/loanEntryCtrl' ])

                    }
                
            
        })
        
        // loan Entry Add
        .state('app.payroll.loanEntry.add', {
            url : '/payroll/payroll/loanentryadd',
            data : {
                title : 'Add'
            },
                    controller : 'loanAddEntryCtrl',
                    templateUrl : 'views/payroll/loanentry/loanEntryAdd',
                    resolve : {
                    	deps: [
                    		'$ocLazyLoad',
                			function($ocLazyLoad) {
                			return $ocLazyLoad
                					.load([ 'js/app/payroll/loanentry/loanAddEntryCtrl.js' ]);
                			} ] 
                    	
                    	
                        //deps : $couchPotatoProvider.resolveDependencies([ 'payroll/payroll/loanentry/loanAddEntryCtrl' ])

                    }
                
            
        })

        .state('app.payroll.loanEntry.edit', {
            url : '/payroll/loanentry/edit',
            data : {
                title : 'Loan Entry Edit'
            },
                    controller : 'loanAddEntryCtrl',
                    templateUrl : 'views/payroll/loanentry/loanEntryAdd',
                    resolve : {
                    	deps: [
                    		'$ocLazyLoad',
                			function($ocLazyLoad) {
                			return $ocLazyLoad
                					.load([ 'js/app/payroll/loanentry/loanAddEntryCtrl.js' ]);
                			} ] 
                    	
                        //deps : $couchPotatoProvider.resolveDependencies([ 'payroll/payroll/loanentry/loanAddEntryCtrl' ])
                    }

                
            
        })
        
        
        
        
        
        
        
        
                // laon Approval FOrm

        .state('app.payroll.loanapproval', {
            abstract : true,
    		templateUrl : "views/common.jsp",
            data : {
                title : 'Loan Approval'
            }
        })

        .state('app.payroll.loanapproval.list', {
            url : '/payroll/payroll/loanapproval/list',
            data : {
                title : 'List'
            },
                    controller : 'loanappCtrl',
                    templateUrl : 'views/payroll/loanapp/loanappList',

                    resolve : {
                    	deps: [
                    		'$ocLazyLoad',
                			function($ocLazyLoad) {
                			return $ocLazyLoad
                					.load([ 'js/app/payroll/loanapp/loanappCtrl.js' ]);
                			} ] 
                       // deps : $couchPotatoProvider.resolveDependencies([ 'payroll/payroll/loanapp/loanappCtrl' ])
                    }
        })

        .state('app.payroll.loanapproval.edit', {
            url : '/payroll/payroll/loanapproval/edit',
            data : {
                title : 'List'
            },
                    controller : 'loanapprovaleditCtrl',
                    templateUrl : 'views/payroll/loanapp/loanapprovalEdit',

                    resolve : {
                    	deps: [
                    		'$ocLazyLoad',
                			function($ocLazyLoad) {
                			return $ocLazyLoad
                					.load([ 'js/app/payroll/loanapp/loanapprovaleditCtrl.js' ]);
                			} ] 
                        //deps : $couchPotatoProvider.resolveDependencies([ 'payroll/payroll/loanapp/loanapprovaleditCtrl' ])
                    }
                
            
        })
        
        
        
        

        .state('app.payroll.myloan', {
            abstract : true,
    		templateUrl : "views/common.jsp",
            data : {
                title : 'My Loan'
            }
        })

        .state('app.payroll.myloan.list', {
            url : '/payroll/payroll/myloan/List',
            data : {
                title : 'List'
            },
                    controller : 'myLoanCtrl',
                    templateUrl : 'views/payroll/myloan/myLoanList',
                    resolve : {
                    	deps: [
                    		'$ocLazyLoad',
                			function($ocLazyLoad) {
                			return $ocLazyLoad
                					.load([ 'js/app/payroll/myloan/myLoanCtrl.js' ]);
                			} ] 
                        //deps : $couchPotatoProvider.resolveDependencies([ 'payroll/payroll/myloan/myLoanCtrl' ])
                    }
                
            
        })

        .state('app.payroll.myloan.view', {
            url : '/payroll/payroll/myloan/view',
            data : {
                title : 'View'
            },
                    controller : 'myLoanAddCtrl',
                    templateUrl : 'views/payroll/myloan/myLoanView',
                    resolve : {
                    	deps: [
                    		'$ocLazyLoad',
                			function($ocLazyLoad) {
                			return $ocLazyLoad
                					.load([ 'js/app/payroll/myloan/myLoanAddCtrl.js' ]);
                			} ] 
                        //deps : $couchPotatoProvider.resolveDependencies([ 'payroll/payroll/myloan/myLoanAddCtrl' ])
                    }
                
            
        })
   
        
        // Loan Deduction

        .state('app.payroll.loandeduction', {
            abstract : true,
    		templateUrl : "views/common.jsp",
            data : {
                title : 'Loan Deduction'
            }
        })

        .state('app.payroll.loandeduction.list', {
            url : '/payroll/payroll/loandeduction/list',
            data : {
                title : 'List'
            },
                    controller : 'loanDeductionCtrl',
                    templateUrl : 'views/payroll/loandeduction/loanDeductionList',

                    resolve : {
                    	deps: [
                    		'$ocLazyLoad',
                			function($ocLazyLoad) {
                			return $ocLazyLoad
                					.load([ 'js/app/payroll/loandeduction/loanDeductionCtrl.js' ]);
                			} ] 
                       // deps : $couchPotatoProvider.resolveDependencies([ 'payroll/payroll/loandeduction/loanDeductionCtrl' ])
                    }
                
            
        })

        
        
        
        
        
        
}
angular.module('neuboard').config(config).run(function($rootScope, $state) {
	$rootScope.$state = $state;
});








