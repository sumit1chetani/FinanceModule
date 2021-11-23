'use strict';

app.controller('airtariffAddCtrl', function($scope, $rootScope, $http, $location, logger,
        utilsService,$state,sharedProperties,$window,validationService,toaster,$stateParams) {	
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.edit = false;
    $scope.chargeHeadList=[];
    $scope.TermList=[];
    $scope.customerList=[];
    $scope.UnitList =[];
    $scope.currencylist=[];
    $scope.servicePartnerTypelist=[];
    $scope.modeList=[];
    $scope.charge ={
    		chargeid :'',
    		mode:'1',
    		modeid:'',
    		service:'',
    		serviceid:'',
    		vendor:'',
    		vendorid:'',
    		pol:'',
    		polid:'',
    		pod:'',
    		podid:'',
    		salestype:'',
    		salestypeid:'',
    		date:'',
    		currency:'',
    		carrier:'',
    		isActive : true,
    		chargeDtl:[{id:0,chargeHeads:'',unit:'',currency:'',qty:'',rate:'',paymentMethod : '',transactionType : '',buySell : '',note : ''}]
    	
    		  };
    
	$scope.getQuotationType = function() {
		var data = {};
		data["id"] = "1";
		data["text"] = "AIR";
		$scope.modeList.push(data);
		$scope.charge.mode='1';
	}
	
	$scope.getQuotationType();
    
    $scope.cancel = function(){
        $state.go("app.air.tariff.list",{tenantid:$stateParams.tenantid});
    };  
    
    var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth() + 1; // January is 0!
	var yyyy = today.getFullYear();
	if (dd < 10) {
		dd = '0' + dd
	}
	if (mm < 10) {
		mm = '0' + mm
	}

	$scope.charge.date = dd + '/' + mm + '/'
			+ yyyy;
   $scope.dropdown= function()
   {
	 
		$http.get($stateParams.tenantid+'/app/seaquotation/getServicePartnerType').success(function(datas) {	  
			$scope.servicePartnerTypelist= angular.copy(datas.commonUtilityBean);
		}).error(function(data) {

		});
		
	  
		$http.post($stateParams.tenantid+'/app/seaquotation/getServicePartner').success(function(datas) {
			debugger
		    $scope.customerList = datas.commonUtilityBean;
		  
		  
		}).error(function(data) {

		});
		
	       
	 
	    
	    $http.get($stateParams.tenantid+'/app/seaquotation/getChargeHeads').success(function(datas) {
			 $scope.chargeHeadList = datas.commonUtilityBean;
		    
		}).error(function(data) {

		});
		
		
		$http.get($stateParams.tenantid+'/app/seaquotation/getTerms').success(function(datas) {
			 $scope.TermList = datas.commonUtilityBean;
		    
		}).error(function(data) {

		});
		
		$http.get($stateParams.tenantid+'/app/seaquotation/getUnitList').success(function(datas) {
			 $scope.UnitList = datas.commonUtilityBean;
		    
		}).error(function(data) {

		});
		
	    
	   
	    $http.get($stateParams.tenantid+'/app/seaquotation/getCurrencyList').success(function(datas) {	  
			$scope.currencylist= angular.copy(datas.commonUtilityBean);
		}).error(function(data) {

		});
	    
	   
   }
   $scope.dropdown();
   
	$scope.polList = [];
	$scope.podList = [];
	$scope.$watch('charge.mode',function(newValue, oldValue) {
				debugger;
				if (newValue == "1") {
					$http.get($stateParams.tenantid
							+ '/standardcharge/aolList')
							.success(
									function(datas) {
										$scope.polList = datas.commonUtilityBean;
										$scope.podList = datas.commonUtilityBean;
									}).error(
									function(datas) {
									});
					
				}
				else
					{
					$http
					.get(
							$stateParams.tenantid
									+ '/standardcharge/aodList')
					.success(
							function(datas) {
								$scope.polList = datas.commonUtilityBean;
								$scope.podList = datas.commonUtilityBean;
							}).error(
							function(datas) {
							});
		}
					

			});
	$scope.checkundefined = function(value) {
	    var invalid = false;
	    if (value == undefined || value == 'undefined' || value == null || value == 'null' || value == '') {
	        invalid = true;
	    }
	    return invalid;

	}
	$scope.changecolor = function(id) {
		$('#' + id + ' .selectivityId').find('input').css(
				"border-color", "red");
		;

	}
	$scope.clearcolor = function(id) {
		$('#' + id + ' .selectivityId').find('input').css(
				"border-color", "#e8dddd");
		;

	}
	
	$scope.checkValidation = function() {

		var alertmsg = "<ui><h4>Please fill the required fields</h4>";
		var msg = "";
		/*if ($scope.checkundefined($scope.charge.vendor)) {
			msg = msg + "<li>VENDOR :Field is required.</li>";
			$scope.changecolor('customer_id');
		} else {
			$scope.clearcolor('customer_id');
		}*/
		
		if ($scope.checkundefined($scope.charge.mode)) {
			msg = msg + "<li>Mode :Field is required.</li>";
			$scope.changecolor('customer_id');
		} else {
			$scope.clearcolor('customer_id');
		}
		
		if ($scope.checkundefined($scope.charge.service)) {
			msg = msg + "<li>Service :Field is required.</li>";
			$scope.changecolor('customer_id');
		} else {
			$scope.clearcolor('customer_id');
		}
		if ($scope.checkundefined($scope.charge.salestype)) {
			msg = msg + "<li>Sales Type :Field is required.</li>";
			$scope.changecolor('customer_id');
		} else {
			$scope.clearcolor('customer_id');
		}

		if ($scope.checkundefined($scope.charge.pol)) {
			msg = msg + "<li>POL/AOL :Field is required.</li>";
			$scope.changecolor('customer_id');
		} else {
			$scope.clearcolor('customer_id');
		}

		if ($scope.checkundefined($scope.charge.pod)) {
			msg = msg + "<li>POD/AOD :Field is required.</li>";
			$scope.changecolor('customer_id');
		} else {
			$scope.clearcolor('customer_id');
		}
		
		if ($scope.checkundefined($scope.charge.currency)) {
			msg = msg + "<li>Currency :Field is required.</li>";
			$scope.changecolor('customer_id');
		} else {
			$scope.clearcolor('customer_id');
		}
		
		if ($scope.checkundefined($scope.charge.date)) {
			msg = msg + "<li>Effective Date :Field is required.</li>";
			$scope.changecolor('customer_id');
		} else {
			$scope.clearcolor('customer_id');
		}
		
		if ($scope.checkundefined($scope.charge.carrier)) {
			msg = msg + "<li>Carrier :Field is required.</li>";
			$scope.changecolor('customer_id');
		} else {
			$scope.clearcolor('customer_id');
		}
		angular
				.forEach(
						$scope.charge.chargeDtl,
						function(chargesDetail, index) {
							if ($scope
									.checkundefined(chargesDetail.chargeHeads)) {
								msg = msg
										+ "<li>Row :"
										+ (index + 1)
										+ "# Charge Heads :Field is required.</li>";
								$scope
										.changecolor('chargeHeads'
												+ index);
							} else {
								$scope.clearcolor('chargeHeads'
										+ index);
							}
							if ($scope
									.checkundefined(chargesDetail.unit)) {
								msg = msg
										+ "<li>Row :"
										+ (index + 1)
										+ "# Unit :Field is required.</li>";
								$scope.changecolor('unit'
										+ index);
							} else {
								$scope.clearcolor('unit'
										+ index);
							}
							if ($scope
									.checkundefined(chargesDetail.currency)) {
								msg = msg
										+ "<li>Row :"
										+ (index + 1)
										+ "# CURRENCY :Field is required.</li>";
								$scope.changecolor('currency'
										+ index);
							} else {
								$scope.clearcolor('currency'
										+ index);
							}
							if ($scope
									.checkundefined(chargesDetail.qty)) {
								msg = msg
										+ "<li>Row :"
										+ (index + 1)
										+ "# Qty :Field is required.</li>";
								$scope.changecolor('qty'
										+ index);
								$('#qty' + index).find('input')
										.css("border-color",
												"red");

							} else {
								$('#qty' + index).find('input')
										.css("border-color",
												"#e8dddd");
							}
							if ($scope
									.checkundefined(chargesDetail.rate)) {
								msg = msg
										+ "<li>Row :"
										+ (index + 1)
										+ "# Rate :Field is required.</li>";
							}
							if ($scope
									.checkundefined(chargesDetail.paymentMethod)) {
								msg = msg
										+ "<li>Row :"
										+ (index + 1)
										+ "# Payment Method :Field is required.</li>";
							}
							/*if ($scope
									.checkundefined(chargesDetail.currency)) {
								msg = msg
										+ "<li>Row :"
										+ (index + 1)
										+ "# Currency :Field is required.</li>";
							}*/
							if ($scope
									.checkundefined(chargesDetail.transactionType)) {
								msg = msg
										+ "<li>Row :"
										+ (index + 1)
										+ "# Transaction Type :Field is required.</li>";
							}
							/*if ($scope
									.checkundefined(chargesDetail.buySell)) {
								msg = msg
										+ "<li>Row :"
										+ (index + 1)
										+ "# Buy Sell:Field is required.</li>";
							}*/

						});
		alertmsg = alertmsg + msg + "</ui>";
		if ($scope.checkundefined(msg)) {
			return '';
		} else {
			return alertmsg;
		}

	}

	$scope.addslab = function(row, index) {
		$scope.max = Math.max.apply(Math, row.weightslab
				.map(function(item) {
					return item.wid;
				}));
		var len = row.weightslab.length - 1;
		$scope.max = $scope.max + 1;
		var json = {
			wid : $scope.max,
			fromweight : row.weightslab[len].toweight + 1,
			toweight : row.weightslab[len].toweight + 2,
			charges : []
		}
		row.weightslab.push(json);
		len = row.weightslab.length - 1;
		$timeout(function() {
			hideActivePapers(row.id + "" + $scope.max, []);
		}, 1000);
	}
	$scope.addRow = function() {

		$scope.max = Math.max.apply(Math,
				$scope.charge.chargeDtl
						.map(function(item) {
							return item.id;
						}));
		$scope.max = $scope.max + 1;
		var chargedata = {
			id : $scope.max,
			chargeHeads : '',
			unit : '',
			currency : '',
			qty : '',
			rate : '',
			currencyList : angular.copy($scope.currencylist),
			paymentMethod : '',
			transactionType : '',
			buySell : '',
			note : ''
		};

		$scope.charge.chargeDtl.push(chargedata);
		var len = $scope.charge.chargeDtl.length - 1;
		$timeout(function() {
			hideActivePapers($scope.max + "0", []);
		}, 1000);
	}
	$scope.removeRow = function() {
		$scope.tablerow = [];
		angular.forEach($scope.charge.chargeDtl,
				function(row, index) {
					var check = row.select;
					console.log(index);
					if (check == undefined || check == "") {
						$scope.tablerow.push(row);
					} else {

					}
				});
		$scope.charge.chargeDtl = $scope.tablerow;
	};

	$scope.doubleshowTable = function(wtIndex, trIndex) {

		var n = $("#handsondiv" + trIndex + wtIndex).css(
				"display");

		if (n == 'none') {
			$("#handsondiv" + trIndex + wtIndex).css("display",
					"block");
			$scope.addindex = trIndex + "" + wtIndex;
		} else if (n == 'block') {
			$("#handsondiv" + trIndex + wtIndex).css("display",
					"none");

		}

	}
    $scope.salesTypeList=[];
	$scope.getSalesType = function() {
	    var  data = {};
	    data["id"] = "1";
	    data["text"] = "CROSS TRADE";
	    $scope.salesTypeList.push(data);
	    data = {};
	    data["id"] = "2";
	    data["text"] = "LOCAL";
	    $scope.salesTypeList.push(data);  
	    data = {};
	    data["id"] = "3";
	    data["text"] = "NOMINATED";
	    $scope.salesTypeList.push(data);  
	    
	  
	}
	$scope.getSalesType();
	
	$scope.PaymentMethodList=[];
	$scope.getpaymentMethod = function() {
	    var  data = {};
	    data["id"] = "1";
	    data["text"] = "PREAPID TO COLLECT";
	    $scope.PaymentMethodList.push(data);

	}
	$scope.getpaymentMethod();
	$scope.transactionTypeList = [];

	$scope.getTransactionType = function() {
		var data = {};
		data["id"] = "1";
		data["text"] = "BUY";
		$scope.transactionTypeList.push(data);
		data = {};
		data["id"] = "2";
		data["text"] = "SELL";
		$scope.transactionTypeList.push(data);

	}
	$scope.getTransactionType();

    
	$scope.submit=function(){
		console.log($scope.charge);
		var msg=$scope.checkValidation();
		if(!$scope.checkundefined(msg)){
			logger.logError(msg);
		}else{

			$http.post($stateParams.tenantid+'/app/airtariff/save',$scope.charge).success(function(datas) {
				debugger
				  if(datas.success==true){
					  logger.logSuccess(datas.message);
					  $state.go('app.air.tariff.list',{tenantid:$stateParams.tenantid});
					 
				  }else{
					  logger.logError(datas.message);
				  }
				}).error(function(data) {
					logger.logError("Please try again");
				});

		}
		
		
	}
	
	
});

app
.controller(
		'airtariffEditCtrl',
		function($scope, $timeout, $stateParams, sharedProperties,
				toaster, $filter, $rootScope, $http, $location, logger,
				$state, ngDialog, $controller, $injector) {
			$scope.chargeHeadList=[];
		    $scope.TermList=[];
		    $scope.customerList=[];
		    $scope.UnitList =[];
		    $scope.currencylist=[];
		    $scope.servicePartnerTypelist=[];
		    $scope.modeList=[];
			var SCHdId = parseInt($location.search().SCHdId);

			$scope.charge ={
		    		chargeid :'',
		    		mode:'1',
		    		modeid:'',
		    		service:'',
		    		serviceid:'',
		    		vendor:'',
		    		vendorid:'',
		    		pol:'',
		    		polid:'',
		    		pod:'',
		    		podid:'',
		    		salestype:'',
		    		salestypeid:'',
		    		date:'',
		    		currency:'',
		    		carrier:'',
		    		isActive : true,
		    		chargeDtl:[{
		    			id : 0,
						chargeHeads : '',
						chargeid : '',
						chargeDtlId : '',
						unit : '',
						currency : '',
						qty : '',
						rate : '',
						paymentMethod : '',
						transactionType : '',
						buySell : '',
						note : ''
		    			}]
		    	
		    		  };
			
			$scope.getQuotationType = function() {
				var data = {};
				data["id"] = "1";
				data["text"] = "AIR";
				$scope.modeList.push(data);
				$scope.charge.mode='1';
			}
			
			$scope.getQuotationType();
			
			$scope.cancel = function(){
		        $state.go("app.air.tariff.list",{tenantid:$stateParams.tenantid});
		    };  
		   $scope.dropdown= function()
		   {
			 
				$http.get($stateParams.tenantid+'/app/seaquotation/getServicePartnerType').success(function(datas) {	  
					$scope.servicePartnerTypelist= angular.copy(datas.commonUtilityBean);
				}).error(function(data) {

				});
				
			  
				$http.post($stateParams.tenantid+'/app/seaquotation/getServicePartner').success(function(datas) {
					debugger
				    $scope.customerList = datas.commonUtilityBean;
				  
				  
				}).error(function(data) {

				});
				
			    
			    
			   
			 
			      /*  $http.get($stateParams.tenantid+'/units/modeList').success(function(datas) {
			        	console.log(datas);
			            $scope.modeList = datas.selectivitybean;
			            
			           

			        }).error(function(data) {

			        });
			        */
			     
			    
			 
			    
			    $http.get($stateParams.tenantid+'/app/seaquotation/getChargeHeads').success(function(datas) {
					 $scope.chargeHeadList = datas.commonUtilityBean;
				    
				}).error(function(data) {

				});
				
				
				$http.get($stateParams.tenantid+'/app/seaquotation/getTerms').success(function(datas) {
					 $scope.TermList = datas.commonUtilityBean;
				    
				}).error(function(data) {

				});
				
				$http.get($stateParams.tenantid+'/app/seaquotation/getUnitList').success(function(datas) {
					 $scope.UnitList = datas.commonUtilityBean;
				    
				}).error(function(data) {

				});
				
			    
			   
			    $http.get($stateParams.tenantid+'/app/seaquotation/getCurrencyList').success(function(datas) {	  
					$scope.currencylist= angular.copy(datas.commonUtilityBean);
				}).error(function(data) {

				});
			    
			   
		   }
		   $scope.dropdown();
		   
			$scope.polList = [];
			$scope.podList = [];
			$scope.$watch('charge.mode',function(newValue, oldValue) {
						debugger;
						if (newValue == "1") {
							$http.get($stateParams.tenantid
									+ '/standardcharge/aolList')
									.success(
											function(datas) {
												$scope.polList = datas.commonUtilityBean;
												$scope.podList = datas.commonUtilityBean;
											}).error(
											function(datas) {
											});
							
						}
						else
							{
							$http
							.get(
									$stateParams.tenantid
											+ '/standardcharge/aodList')
							.success(
									function(datas) {
										$scope.polList = datas.commonUtilityBean;
										$scope.podList = datas.commonUtilityBean;
									}).error(
									function(datas) {
									});
				}
							

					});
			$scope.checkundefined = function(value) {
			    var invalid = false;
			    if (value == undefined || value == 'undefined' || value == null || value == 'null' || value == '') {
			        invalid = true;
			    }
			    return invalid;

			}
			$scope.changecolor = function(id) {
				$('#' + id + ' .selectivityId').find('input').css(
						"border-color", "red");
				;

			}
			$scope.clearcolor = function(id) {
				$('#' + id + ' .selectivityId').find('input').css(
						"border-color", "#e8dddd");
				;

			}
			
			$scope.checkValidation = function() {

				var alertmsg = "<ui><h4>Please fill the required fields</h4>";
				var msg = "";
				/*if ($scope.checkundefined($scope.charge.vendor)) {
					msg = msg + "<li>VENDOR :Field is required.</li>";
					$scope.changecolor('customer_id');
				} else {
					$scope.clearcolor('customer_id');
				}*/
				if ($scope.checkundefined($scope.charge.mode)) {
					msg = msg + "<li>Mode :Field is required.</li>";
					$scope.changecolor('customer_id');
				} else {
					$scope.clearcolor('customer_id');
				}
				
				if ($scope.checkundefined($scope.charge.service)) {
					msg = msg + "<li>Service :Field is required.</li>";
					$scope.changecolor('customer_id');
				} else {
					$scope.clearcolor('customer_id');
				}
				if ($scope.checkundefined($scope.charge.salestype)) {
					msg = msg + "<li>Sales Type :Field is required.</li>";
					$scope.changecolor('customer_id');
				} else {
					$scope.clearcolor('customer_id');
				}

				if ($scope.checkundefined($scope.charge.pol)) {
					msg = msg + "<li>POL/AOL :Field is required.</li>";
					$scope.changecolor('customer_id');
				} else {
					$scope.clearcolor('customer_id');
				}

				if ($scope.checkundefined($scope.charge.pod)) {
					msg = msg + "<li>POD/AOD :Field is required.</li>";
					$scope.changecolor('customer_id');
				} else {
					$scope.clearcolor('customer_id');
				}
				
				if ($scope.checkundefined($scope.charge.currency)) {
					msg = msg + "<li>Currency :Field is required.</li>";
					$scope.changecolor('customer_id');
				} else {
					$scope.clearcolor('customer_id');
				}
				
				if ($scope.checkundefined($scope.charge.date)) {
					msg = msg + "<li>Effective Date :Field is required.</li>";
					$scope.changecolor('customer_id');
				} else {
					$scope.clearcolor('customer_id');
				}
				
				if ($scope.checkundefined($scope.charge.carrier)) {
					msg = msg + "<li>Carrier :Field is required.</li>";
					$scope.changecolor('customer_id');
				} else {
					$scope.clearcolor('customer_id');
				}

				angular
						.forEach(
								$scope.charge.chargeDtl,
								function(chargesDetail, index) {
									if ($scope
											.checkundefined(chargesDetail.chargeHeads)) {
										msg = msg
												+ "<li>Row :"
												+ (index + 1)
												+ "# Charge Heads :Field is required.</li>";
										$scope
												.changecolor('chargeHeads'
														+ index);
									} else {
										$scope.clearcolor('chargeHeads'
												+ index);
									}
									if ($scope
											.checkundefined(chargesDetail.unit)) {
										msg = msg
												+ "<li>Row :"
												+ (index + 1)
												+ "# LOD :Field is required.</li>";
										$scope.changecolor('unit'
												+ index);
									} else {
										$scope.clearcolor('unit'
												+ index);
									}
									if ($scope
											.checkundefined(chargesDetail.currency)) {
										msg = msg
												+ "<li>Row :"
												+ (index + 1)
												+ "# CURRENCY :Field is required.</li>";
										$scope.changecolor('currency'
												+ index);
									} else {
										$scope.clearcolor('currency'
												+ index);
									}
									if ($scope
											.checkundefined(chargesDetail.qty)) {
										msg = msg
												+ "<li>Row :"
												+ (index + 1)
												+ "# Qty :Field is required.</li>";
										$scope.changecolor('qty'
												+ index);
										$('#qty' + index).find('input')
												.css("border-color",
														"red");

									} else {
										$('#qty' + index).find('input')
												.css("border-color",
														"#e8dddd");
									}
									if ($scope
											.checkundefined(chargesDetail.rate)) {
										msg = msg
												+ "<li>Row :"
												+ (index + 1)
												+ "# Rate :Field is required.</li>";
									}
									if ($scope
											.checkundefined(chargesDetail.paymentMethod)) {
										msg = msg
												+ "<li>Row :"
												+ (index + 1)
												+ "# Payment Method :Field is required.</li>";
									}
									/*if ($scope
											.checkundefined(chargesDetail.currency)) {
										msg = msg
												+ "<li>Row :"
												+ (index + 1)
												+ "# Currency :Field is required.</li>";
									}*/
									if ($scope
											.checkundefined(chargesDetail.transactionType)) {
										msg = msg
												+ "<li>Row :"
												+ (index + 1)
												+ "# Transaction Type :Field is required.</li>";
									}
									/*if ($scope
											.checkundefined(chargesDetail.buySell)) {
										msg = msg
												+ "<li>Row :"
												+ (index + 1)
												+ "# Buy Sell:Field is required.</li>";
									}*/

								});
				alertmsg = alertmsg + msg + "</ui>";
				if ($scope.checkundefined(msg)) {
					return '';
				} else {
					return alertmsg;
				}

			}

			$scope.addslab = function(row, index) {
				$scope.max = Math.max.apply(Math, row.weightslab
						.map(function(item) {
							return item.wid;
						}));
				var len = row.weightslab.length - 1;
				$scope.max = $scope.max + 1;
				var json = {
					wid : $scope.max,
					fromweight : row.weightslab[len].toweight + 1,
					toweight : row.weightslab[len].toweight + 2,
					charges : []
				}
				row.weightslab.push(json);
				len = row.weightslab.length - 1;
				$timeout(function() {
					hideActivePapers(row.id + "" + $scope.max, []);
				}, 1000);
			}
			$scope.addRow = function() {

				$scope.max = Math.max.apply(Math,
						$scope.charge.chargeDtl
								.map(function(item) {
									return item.id;
								}));
				$scope.max = $scope.max + 1;
				var chargedata = {
					id : $scope.max,
					chargeHeads : '',
					unit : '',
					currency : '',
					qty : '',
					rate : '',
					currencyList : angular.copy($scope.currencylist),
					paymentMethod : '',
					transactionType : '',
					buySell : '',
					note : ''
				};

				$scope.charge.chargeDtl.push(chargedata);
				var len = $scope.charge.chargeDtl.length - 1;
				$timeout(function() {
					hideActivePapers($scope.max + "0", []);
				}, 1000);
			}
			$scope.removeRow = function() {
				$scope.tablerow = [];
				angular.forEach($scope.charge.chargeDtl,
						function(row, index) {
							var check = row.select;
							console.log(index);
							if (check == undefined || check == "") {
								$scope.tablerow.push(row);
							} else {

							}
						});
				$scope.charge.chargeDtl = $scope.tablerow;
			};

			$scope.doubleshowTable = function(wtIndex, trIndex) {

				var n = $("#handsondiv" + trIndex + wtIndex).css(
						"display");

				if (n == 'none') {
					$("#handsondiv" + trIndex + wtIndex).css("display",
							"block");
					$scope.addindex = trIndex + "" + wtIndex;
				} else if (n == 'block') {
					$("#handsondiv" + trIndex + wtIndex).css("display",
							"none");

				}

			}
		    $scope.salesTypeList=[];
			$scope.getSalesType = function() {
			    var  data = {};
			    data["id"] = "1";
			    data["text"] = "CROSS TRADE";
			    $scope.salesTypeList.push(data);
			    data = {};
			    data["id"] = "2";
			    data["text"] = "LOCAL";
			    $scope.salesTypeList.push(data);  
			    data = {};
			    data["id"] = "3";
			    data["text"] = "NOMINATED";
			    $scope.salesTypeList.push(data);  
			    
			  
			}
			$scope.getSalesType();
			
			$scope.PaymentMethodList=[];
			$scope.getpaymentMethod = function() {
			    var  data = {};
			    data["id"] = "1";
			    data["text"] = "PREAPID TO COLLECT";
			    $scope.PaymentMethodList.push(data);

			}
			$scope.getpaymentMethod();
			$scope.transactionTypeList = [];

			$scope.getTransactionType = function() {
				var data = {};
				data["id"] = "1";
				data["text"] = "BUY";
				$scope.transactionTypeList.push(data);
				data = {};
				data["id"] = "2";
				data["text"] = "SELL";
				$scope.transactionTypeList.push(data);

			}
			$scope.getTransactionType();

		    
			$scope.editdata = function(charge) {

				
				$http
						.post(
								$stateParams.tenantid
										+ '/app/seaquotation/getServicePartner')
						.success(
								function(datas) {
									debugger
									$scope.customerList = datas.commonUtilityBean;

								}).error(function(data) {

						});
			}
			
			$scope.edit=false;
			if(!$scope.checkundefined($location.search().charge)){
				$scope.editdata($location.search().charge);
				$scope.edit=true;

			}else{
				$scope.edit=false;
				$scope.dropdown();
			}

			
			

		
			$scope.edit = false;
			
			if (SCHdId != '' && SCHdId != undefined) {
				$scope.edit = true;
				$scope.dropdown();
				$http
						.post(
								$stateParams.tenantid
										+ '/app/airtariff/edit',
										SCHdId)
						.success(
								function(data) {
									debugger
									$scope.charge = data.lQuotationBean[0];
									if(data.lQuotationBean[0].service != null && data.lQuotationBean[0].service != ''){
										$scope.charge.service = data.lQuotationBean[0].service
										.toString();
									}
									
									if(data.lQuotationBean[0].mode != null && data.lQuotationBean[0].mode != ''){

									$scope.charge.mode = data.lQuotationBean[0].mode
											.toString();
									}
									if(data.lQuotationBean[0].pol != null && data.lQuotationBean[0].pol != ''){

									$scope.charge.pol = data.lQuotationBean[0].pol
											.toString();
									}
									if(data.lQuotationBean[0].pod != null && data.lQuotationBean[0].pod != ''){

									$scope.charge.pod = data.lQuotationBean[0].pod
											.toString();
									}
									
									if(data.lQuotationBean[0].currency != null && data.lQuotationBean[0].currency != ''){

									$scope.charge.currency = data.lQuotationBean[0].currency
											.toString();
									}
									if(data.lQuotationBean[0].salestype != null && data.lQuotationBean[0].salestype != ''){

									$scope.charge.salestype = data.lQuotationBean[0].salestype
											.toString();
									}
									if(data.lQuotationBean[0].isStstus != null && data.lQuotationBean[0].isStstus != ''){
									if(data.lQuotationBean[0].isStstus  == "t"){
					    	    		$scope.charge.isActive = true;
					    	    	}else{
					    	    		$scope.charge.isActive = false;
					    	    	}  
									}
									
		
									for (var i = 0; i < $scope.charge.chargeDtl.length; i++) {
										$scope.charge.chargeDtl[i].chargeHeads = $scope.charge.chargeDtl[i].chargeHeads
												.toString();
										$scope.charge.chargeDtl[i].unit = $scope.charge.chargeDtl[i].unit
												.toString();
										$scope.charge.chargeDtl[i].currency = $scope.charge.chargeDtl[i].currency
												.toString();
										$scope.charge.chargeDtl[i].paymentMethod = $scope.charge.chargeDtl[i].paymentMethod
												.toString();
										$scope.charge.chargeDtl[i].transactionType = $scope.charge.chargeDtl[i].transactionType
												.toString();
										$scope.charge.chargeDtl[i].buySell = $scope.charge.chargeDtl[i].buySell
												.toString();
									}

								});

			}

			$scope.submitupdate = function() {
				console.log($scope.charge);
				var msg = $scope.checkValidation();
				if (!$scope.checkundefined(msg)) {
					logger.logError(msg);
				} else {
					$http.post($stateParams.tenantid + '/app/airtariff/update',
							$scope.charge).success(function(datas) {
						debugger
						if (datas.success == true) {
							logger.logSuccess(datas.message);
							$state.go('app.air.tariff.list',{tenantid : $stateParams.tenantid
						});

						} else {
							logger.logError(datas.message);
						}
					}).error(function(data) {
						logger.logError("Please try again");
					});
				}

			}
			/*$scope.cancel = function() {
				$state.go('app.sea.quotation.list', {
					tenantid : $stateParams.tenantid
				});
			}*/

		});
