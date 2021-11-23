'use strict';
app.controller('airquotationAddCtrl', function($scope, $timeout, $stateParams,
		sharedProperties, toaster, $filter, $rootScope, $http, $location,
		logger, $state, ngDialog, $controller, $injector) {
	$scope.quotationTypeList = [];
	$scope.customerDropList = [];
	$scope.consigneeDropList  = [];
	$scope.shipperDropList  = [];
	$scope.nominatedDropList  = [];
	$scope.vendorDropList = [];
	$scope.serviceParnrDropList = [];
	$scope.portList = [];
	$scope.currencyList = [];
	$scope.createQuote = false;

	var bookingDate = $stateParams.bookingDate;
	var mloCode = $stateParams.mloCode;
	var lolId = $stateParams.lolId;
	var lodId = $stateParams.lodId;
	var bookingId = parseInt($stateParams.bookingId);

	$scope.quotation = {
		service : '',
		aol : '',
		origin : '',
		customer : '',
		salesPerson : '',
		vendor : '',
		flightNo : '',
		attention : '',
		quotationDate : '',
		branch : '',
		aod : '',
		destination : '',
		shipper : '',
		salesType : '',
		carrier : '',
		flightDate : '',
		termConditions : '',
		mode : '2',
		currency : '',
		term : '',
		commodity : '',
		consignee : '',
		nominatedBy : '',
		validityDate : '',
		remarks : '',
		dimensionName:'',
		quotationDtl : [ {
			id : 0,
			chargeHeads : '',
			unit : '',
			currency : '',
			qty : '',
			rate : '',
			paymentMethod : '',
			transactionType : '',
			buySell : '',
			note : ''
		} ]
	}

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
	
	$scope.quotation.quotationDate = dd + '/' + mm + '/'
	+ yyyy;
	

	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth() + 1;

	var yyyy = today.getFullYear();
	if (dd < 10) {
		dd = '0' + dd;
	}
	if (mm < 10) {
		mm = '0' + mm;
	}
	var today = dd + '/' + mm + '/' + yyyy;
	$scope.quotation.quotationDate = today;
	
	$scope.$watchCollection('[quotation.quotationDate]',function(newValue, oldValue) {
		if ($scope.quotation.quotationDate != '') {
			var frmDate = today;
			var toDate = $scope.quotation.quotationDate;
			var splitarray = new Array();
			splitarray = frmDate.split(" ");
			var date = splitarray[0];
			var time = splitarray[1];
			frmDate = date.split("/");
			frmDate = new Date(frmDate[2],
					frmDate[1] - 1, frmDate[0]);
			toDate = toDate.split("/");
			toDate = new Date(toDate[2],
					toDate[1] - 1, toDate[0]);
			if (toDate >frmDate) {
				logger.logError("Quotation Date should be less or equal to current date");
				$scope.quotation.quotationDate = today;
			}
		}
	});  

	
	$scope.checkDatesCL = function(quotationDate) {
		var res = $scope.quotation.quotationDate
				.split("/");
		$http
				.get(
						$stateParams.tenantid
								+ '/app/cashbankreceipt/getloggedcompany?closingDate='
								+ $scope.quotation.quotationDate)
				.success(
						function(datas) {
							if (datas) {
								logger
										.logError("Account closed for year "
												+ res[2]);
								$scope.quotation.quotationDate = today;
							}
						})
	}

	
	$scope.checkundefined = function(value) {
		var invalid = false;
		if (value == undefined || value == 'undefined' || value == null
				|| value == 'null' || value == '') {
			invalid = true;
		}
		return invalid;

	}

	$scope.addslab = function(row, index) {
		$scope.max = Math.max.apply(Math, row.weightslab.map(function(item) {
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

		$scope.max = Math.max.apply(Math, $scope.quotation.quotationDtl
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

		$scope.quotation.quotationDtl.push(chargedata);
		var len = $scope.quotation.quotationDtl.length - 1;
		$timeout(function() {
			hideActivePapers($scope.max + "0", []);
		}, 1000);
	}
	
	$scope.removeRow = function() {
		$scope.tablerow = [];
		for (var index = 0 ; index < 1; index++) {
		angular.forEach($scope.quotation.quotationDtl,function(row, index) {
					var check = row.select;
					console.log(index);
					if (check == undefined || check == "" ) {
						$scope.tablerow.push(row);
					} else if(index > 0){
						$scope.quotation.quotationDtl = $scope.tablerow;

					}
				});
		}
	};
	/*$scope.removeRow = function() {
		if($scope.quotation.quotationDtl.length>1){
		$scope.tablerow = [];
		angular.forEach($scope.quotation.quotationDtl, function(row, index) {
			var check = row.select;
			console.log(index);
			if (check == undefined || check == "") {
				$scope.tablerow.push(row);
			} else {
				logger.logError("Atleast One Row Required");

			}
		});
		}
		else{
			
		}
		$scope.quotation.quotationDtl = $scope.tablerow;
	};*/

	$scope.doubleshowTable = function(wtIndex, trIndex) {

		var n = $("#handsondiv" + trIndex + wtIndex).css("display");

		if (n == 'none') {
			$("#handsondiv" + trIndex + wtIndex).css("display", "block");
			$scope.addindex = trIndex + "" + wtIndex;
		} else if (n == 'block') {
			$("#handsondiv" + trIndex + wtIndex).css("display", "none");

		}

	}

	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth() + 1;

	var yyyy = today.getFullYear();
	if (dd < 10) {
		dd = '0' + dd
	}
	if (mm < 10) {
		mm = '0' + mm
	}
	var today = dd + '/' + mm + '/' + yyyy;
	$scope.quotation.dataOfIssues = today;
	$scope.modeList = [];
	$scope.getQuotationType = function() {
		var data = {};
		data["id"] = "2";
		data["text"] = "AIR";
		$scope.modeList.push(data);
		$scope.quotation.mode='2';
		// data = {};
		// data["id"] = "2";
		// data["text"] = "SEA";
		// $scope.modeList.push(data);
	}

	$scope.salesTypeList = [];
//	$scope.getSalesType = function() {
//		var data = {};
//		data["id"] = "1";
//		data["text"] = "CROSS TRADE";
//		$scope.salesTypeList.push(data);
//		data = {};
//		data["id"] = "2";
//		data["text"] = "LOCAL";
//		$scope.salesTypeList.push(data);
//		data = {};
//		data["id"] = "3";
//		data["text"] = "NOMINATED";
//		$scope.salesTypeList.push(data);
//
//	}
//	$scope.getSalesType();
	$scope.transactionTypeList = [];

//	$scope.getTransactionType = function() {
//		var data = {};
//		data["id"] = "14";
//		data["text"] = "BUY";
//		$scope.transactionTypeList.push(data);
//		data = {};
//		data["id"] = "15";
//		data["text"] = "SELL";
//		$scope.transactionTypeList.push(data);
//
//	}
//	$scope.getTransactionType();

	$scope.PaymentMethodList = [];
//	$scope.getpaymentMethod = function() {
////		var data = {};
////		data["id"] = "12";
////		data["text"] = "PREAPID";
////		$scope.PaymentMethodList.push(data);
////		data["id"] = "13";
////		data["text"] = "TO COLLECT";
////		$scope.PaymentMethodList.push(data);
//		// data = {};
//		// data["id"] = "2";
//		// data["text"] = "SELL";
//		// $scope.PaymentMethodList.push(data);
//
//	}
//	$scope.getpaymentMethod();

	$scope.chargeList = [];
	$scope.dropdown = function() {
		$scope.getQuotationType();
		$http.post($stateParams.tenantid+'/app/seaquotation/getServicePartnerList').success(function(datas) {
			$scope.customerDropList = datas.customerList;
			 $scope.consigneeDropList = datas.consigneeList;
			 $scope.shipperDropList = datas.shipperList;
			 $scope.nominatedDropList = datas.nominatedList;
			 $scope.vendorDropList = datas.vendorList;
			 $scope.serviceParnrDropList=datas.serviceParnrList;

				}).error(function(data) {

				});
		$http.get($stateParams.tenantid + '/app/airquotation/getiataList')
				.success(function(datas) {
					debugger
					$scope.portList = datas.commonUtilityBean;

				}).error(function(data) {

				});
		$http.get($stateParams.tenantid + '/app/airquotation/getBranch')
				.success(function(datas) {
					$scope.branchList = datas.commonUtilityBean;

				}).error(function(data) {

				});
		$http.get($stateParams.tenantid + '/app/airquotation/getCurrencyList')
				.success(
						function(datas) {
							$scope.currencylist = angular
									.copy(datas.commonUtilityBean);
						}).error(function(data) {

				});

		$http.get($stateParams.tenantid+'/app/seaquotation/getcommodity').success(function(datas) {
			
		    $scope.commodityList = datas.commonUtilityBean;	    

		}).error(function(data) {

		});
		
//		$http.get(
//				$stateParams.tenantid
//						+ '/app/airquotation/getServicePartnerType').success(
//				function(datas) {
//					$scope.servicePartnerTypelist = angular
//							.copy(datas.commonUtilityBean);
//				}).error(function(data) {
//
//		});

		$http.get($stateParams.tenantid + '/app/airquotation/getEmployeeList')
				.success(function(datas) {
					$scope.employeeList = datas.commonUtilityBean;

				}).error(function(data) {

				});
		
		$http.get($stateParams.tenantid + '/app/airquotation/getSalesList')
		.success(function(datas) {
			$scope.salesTypeList = datas.commonUtilityBean;

		}).error(function(data) {

		});
		
		$http.get($stateParams.tenantid + '/app/airquotation/getServiceList')
		.success(function(datas) {
			$scope.servicePartnerTypelist = datas.commonUtilityBean;

		}).error(function(data) {

		});
		
		$http.get($stateParams.tenantid + '/app/airquotation/getPaymentList')
		.success(function(datas) {
			$scope.PaymentMethodList = datas.commonUtilityBean;

		}).error(function(data) {

		});
		
		
		$http.get($stateParams.tenantid + '/app/airquotation/getTransactionList')
		.success(function(datas) {
			$scope.transactionTypeList = datas.commonUtilityBean;

		}).error(function(data) {

		});		

		$http.get($stateParams.tenantid + '/app/airquotation/getChargeHeads')
				.success(function(datas) {
					$scope.chargeHeadList = datas.commonUtilityBean;

				}).error(function(data) {

				});

		$http.get($stateParams.tenantid + '/app/airquotation/getTerms')
				.success(function(datas) {
					$scope.TermList = datas.commonUtilityBean;

				}).error(function(data) {

				});

		$http.get($stateParams.tenantid + '/app/seaquotation/getUnitList')
				.success(function(datas) {
					$scope.UnitList = datas.commonUtilityBean;

				}).error(function(data) {

				});

	}
	
	
	$scope.editdata = function(quotation) {

		$scope.getQuotationType();
		$http.post($stateParams.tenantid+'/app/seaquotation/getServicePartnerList').success(function(datas) {
			$scope.customerDropList = datas.customerList;
			 $scope.consigneeDropList = datas.consigneeList;
			 $scope.shipperDropList = datas.shipperList;
			 $scope.nominatedDropList = datas.nominatedList;
			 $scope.vendorDropList = datas.vendorList;
			 $scope.serviceParnrDropList=datas.serviceParnrList;

				}).error(function(data) {

				});
	}

	$scope.edit = false;
	
	if (!$scope.checkundefined($location.search().quotation)) {
		$scope.editdata($location.search().quotation);
		$scope.edit = true;

	} else {
		$scope.edit = false;
		$scope.dropdown();
	}

	$scope.changecolor = function(id) {
		$('#' + id + ' .selectivityId').find('input')
				.css("border-color", "red");
		;

	}
	$scope.clearcolor = function(id) {
		$('#' + id + ' .selectivityId').find('input').css("border-color",
				"#e8dddd");
		;

	}

	
	  $rootScope.uploadFile = function(element) {
		  $scope.excelfile = element.files;
	        $scope.adduploadfiles();
	    }
	    $scope.files = [];
	    $scope.quotation.files= [];
	    $scope.adduploadfiles = function() {
	    	debugger
	        var obj = []

	        if ($scope.checkundefined1($scope.excelfile)) {
	            logger.logError("Please select the file");
	        } else {
	            obj = $filter('filter')($scope.quotation.files, {
	                filename : $scope.excelfile.name
	            }, true);
	        }

	        if (obj != undefined && obj.length > 0) {
	            logger.logError($scope.excelfile.name + " same file already added");
	        } else {$timeout(function() {
	        	for( var i=0;i<$scope.excelfile.length;i++){
		            $scope.files.push($scope.excelfile[i]);
		            $scope.quotation.files.push({
		                filename : $scope.excelfile[i].name,
		                filepath : '',
		                quotation : ''
		            });
		        	}
		        	 },200);
	        }

	    }
	   
	    $scope.deleteuploadfiles = function(filename) {
	        $scope.tempfiles = [];
	        $scope.tempfilename = [];
	        angular.forEach($scope.files, function(row, index) {
	            if (filename != row.name) {
	                $scope.tempfiles.push(row);
	            }

	        });

	        angular.forEach($scope.quotation.files, function(value, index) {
	            if (filename != value.filename) {
	                $scope.tempfilename.push(value);
	            }

	        });
	        $scope.files = $scope.tempfiles;
	        $scope.quotation.files = $scope.tempfilename;
	        
	        
	       /* $http.post($stateParams.tenantid+'/app/airquotation/deleteFiles', filepath).success(function(result) {
	               
            })
*/
	    }
	    
	    
	    
	    $scope.checkundefined1 = function(value) {
	        var invalid = false;
	        if (value == undefined || value == 'undefined' || value == null || value == 'null' || value == '') {
	            invalid = true;
	        }
	        return invalid;

	    }
	$scope.checkValidation = function() {

	    var alertmsg = "<ui><h4>Please fill the required fields</h4>";
	    var msg = "";
	  /*  if ($scope.checkundefined($scope.quotation.commodity)) {
	        msg = msg + "<li>Commodity:Field is required.</li>";         
	        $scope.changecolor('commodity');
	    }else{
	    	$scope.clearcolor('commodity');
	    }*/
	    if ($scope.checkundefined($scope.quotation.customer)) {
	        msg = msg + "<li>Customer:Field is required.</li>";         
	        $scope.changecolor('customer_id');
	    }else{
	    	$scope.clearcolor('customer_id');
	    }
	    if ($scope.checkundefined($scope.quotation.service)) {
	        msg = msg + "<li>Service:Field is required.</li>";         
	        $scope.changecolor('service');
	    }else{
	    	$scope.clearcolor('service');
	    }
	    if ($scope.checkundefined($scope.quotation.aol)) {
	        msg = msg + "<li>AOL:Field is required.</li>";         
	        $scope.changecolor('aol');
	    }else{
	    	$scope.clearcolor('aol');
	    }
	    if ($scope.checkundefined($scope.quotation.quotationDate)) {
	        msg = msg + "<li>QuotationDate:Field is required.</li>";         
	        $scope.changecolor('quotationDate');
	    }else{
	    	$scope.clearcolor('quotationDate');
	    }
	    if ($scope.checkundefined($scope.quotation.branch)) {
	        msg = msg + "<li>Branch:Field is required.</li>";         
	        $scope.changecolor('branch');
	    }else{
	    	$scope.clearcolor('branch');
	    }
	    if ($scope.checkundefined($scope.quotation.aod)) {
	        msg = msg + "<li>AOD:Field is required.</li>";         
	        $scope.changecolor('aod');
	    }else{
	    	$scope.clearcolor('aod');
	    }
	    if ($scope.checkundefined($scope.quotation.salesType)) {
	        msg = msg + "<li>SalesType:Field is required.</li>";         
	        $scope.changecolor('salesType');
	    }else{
	    	$scope.clearcolor('salesType');
	    }
	    if ($scope.checkundefined($scope.quotation.mode)) {
	        msg = msg + "<li>Mode:Field is required.</li>";         
	        $scope.changecolor('mode');
	    }else{
	    	$scope.clearcolor('mode');
	    }
	    if ($scope.checkundefined($scope.quotation.currency)) {
	        msg = msg + "<li>Currency:Field is required.</li>";         
	        $scope.changecolor('currency');
	    }else{
	    	$scope.clearcolor('currency');
	    }
	    if ($scope.checkundefined($scope.quotation.term)) {
	        msg = msg + "<li>Term:Field is required.</li>";         
	        $scope.changecolor('term');
	    }else{
	    	$scope.clearcolor('term');
	    }
	    if ($scope.checkundefined($scope.quotation.validityDate)) {
	        msg = msg + "<li>ValidityDate:Field is required.</li>";         
	        $scope.changecolor('validityDate');
	    }else{
	    	$scope.clearcolor('validityDate');
	    }
	    
	    
	  	    angular.forEach($scope.quotation.quotationDtl, function(chargesDetail, index) {     
	        if ($scope.checkundefined(chargesDetail.chargeHeads)) {
	            msg = msg + "<li>Row :" + (index + 1) + "# Charge Heads :Field is required.</li>";
	            $scope.changecolor('chargeHeads'+index);
	        }else{
	        	$scope.clearcolor('chargeHeads'+index);
	        }
	        if ($scope.checkundefined(chargesDetail.unit)) {
	            msg = msg + "<li>Row :" + (index + 1) + "# Unit :Field is required.</li>";
	            $scope.changecolor('unit'+index);
	        }else{
	        	$scope.clearcolor('unit'+index);
	        }
	        if ($scope.checkundefined(chargesDetail.qty)) {
	            msg = msg + "<li>Row :" + (index + 1) + "# Quantity :Field is required.</li>";
	            $scope.changecolor('qty'+index);
	            $('#qty'+index).find('input').css("border-color", "red");

	        }  else{
	        	$('#qty'+index).find('input').css("border-color", "#e8dddd");
	        }
	        if ($scope.checkundefined(chargesDetail.rate)) {
	            msg = msg + "<li>Row :" + (index + 1) + "# Rate :Field is required.</li>";
	        }  
	        if ($scope.checkundefined(chargesDetail.paymentMethod)) {
	            msg = msg + "<li>Row :" + (index + 1) + "# Payment Method :Field is required.</li>";
	        }  
	        if ($scope.checkundefined(chargesDetail.currency)) {
	            msg = msg + "<li>Row :" + (index + 1) + "# Currency :Field is required.</li>";
	        }  
	        if ($scope.checkundefined(chargesDetail.transactionType)) {
	            msg = msg + "<li>Row :" + (index + 1) + "# Transaction Type :Field is required.</li>";
	        }  
	        if ($scope.checkundefined(chargesDetail.buySell)) {
	            msg = msg + "<li>Row :" + (index + 1) + "# Buy Sell:Field is required.</li>";
	        }  
	        
	        
	        
	    });
	    alertmsg = alertmsg + msg + "</ui>";
	    if ($scope.checkundefined(msg)) {
	        return '';
	    } else {
	        return alertmsg;
	    }

	}
	$scope.submit = function() {
		console.log($scope.quotation);
		var msg = $scope.checkValidation();
		if (!$scope.checkundefined(msg)) {
			logger.logError(msg);
		} else {
			
			if($scope.quotation.quotationDtl.length>0){
			
			$http.post($stateParams.tenantid + '/app/airquotation/save',
					$scope.quotation).success(function(datas) {
				debugger
				if (datas.success == true) {
					if ($scope.files.length > 0) {

                        angular.forEach($scope.files, function(files, index) {
                        	
                        	
                            var quotationNo = datas.code;
                            
                            var frmData = new FormData();
                            frmData.append("file", files);
                            frmData.append("quotationNo", quotationNo);
                           
                            $.ajax({
                                type : "POST",
                                url : $stateParams.tenantid+"/app/airquotation/saveuploadfile",
                                data : frmData,
                                contentType : false,
                                processData : false,
                                success : function(result) {
                                }
                            });
                        });

                    }
					logger.logSuccess(datas.message);
					$location.url($stateParams.tenantid+'/airQuotation/edit?QuotHdId='+datas.quotationId);
					/*$state.go('app.air.quotation.list', {
						tenantid : $stateParams.tenantid
					});*/
					

				} else {
					logger.logError(datas.message);
				}
			}).error(function(data) {
				logger.logError("Please try again");
			});
			
		}else{
        	logger.logError("Atleast One Row Required");
        }

	}
		
	}
	$scope.cancel = function() {
		$state.go('app.air.quotation.list', {
			tenantid : $stateParams.tenantid
		});
	}
});
app.controller('airquotationtableCtrl', function($scope, $http, $filter, logger,
		$stateParams) {
	 $scope.$watch('quotation.quotationDtl[trIndex].transactionType', function(newValue, oldValue) {
		 var id = newValue;
			$http.get($stateParams.tenantid+'/app/seaquotation/getServicePartnerListid?id='+ id).success(function(datas) {
				console.log(datas);				
				 $scope.serviceParnrDropList=datas.serviceParnrList;
			  
			}).error(function(data) {

			});
	  });
});

app
		.controller(
				'airquotationEditCtrl',
				function($scope, $timeout, $stateParams, sharedProperties,
						toaster, $filter, $rootScope, $http, $location, logger,
						$state, ngDialog, $controller, $injector,$window) {
					$scope.quotationTypeList = [];
					$scope.customerDropList = [];
					$scope.consigneeDropList  = [];
					$scope.shipperDropList  = [];
					$scope.nominatedDropList  = [];
					$scope.vendorDropList = [];
					$scope.serviceParnrDropList = [];
					$scope.portList = [];
					$scope.currencyList = [];
					$scope.createQuote = false;

					var QuotHdId = parseInt($location.search().QuotHdId);

					$scope.quotation = {
						service : '',
						aol : '',
						origin : '',
						customer : '',
						salesPerson : '',
						vendor : '',
						flightNo : '',
						attention : '',
						quotationDate : '',
						branch : '',
						aod : '',
						destination : '',
						shipper : '',
						salesType : '',
						carrier : '',
						flightDate : '',
						termConditions : '',
						mode : '2',
						currency : '',
						term : '',
						commodity : '',
						consignee : '',
						nominatedBy : '',
						validityDate : '',
						remarks : '',
						quotationId : '',
						dimensionName:'',
						quotationDtl : [ {
							id : 0,
							chargeHeads : '',
							quotationId : '',
							quotationDtlId : '',
							unit : '',
							currency : '',
							qty : '',
							rate : '',
							paymentMethod : '',
							transactionType : '',
							buySell : '',
							note : ''
						} ]
					}
					
					$scope.checkundefined = function(value) {
						var invalid = false;
						if (value == undefined || value == 'undefined'
								|| value == null || value == 'null'
								|| value == '') {
							invalid = true;
						}
						return invalid;

					}
					
					$scope.checkundefined1 = function(value) {
				        var invalid = false;
				        if (value == undefined || value == 'undefined' || value == null || value == 'null' || value == '') {
				            invalid = true;
				        }
				        return invalid;

				    }

					$rootScope.uploadFile = function(element) {
				        $scope.excelfile = element.files;
				        $scope.adduploadfiles();
				    }
				    $scope.files = [];
				    $scope.quotation.files= [];
				    $scope.adduploadfiles = function() {
				    	debugger
				        var obj = []

				        if ($scope.checkundefined1($scope.excelfile)) {
				            logger.logError("Please select the file");
				        } else {
				            obj = $filter('filter')($scope.quotation.files, {
				                filename : $scope.excelfile.name
				            }, true);
				        }

				        if (obj != undefined && obj.length > 0) {
				            logger.logError($scope.excelfile.name + " same file already added");
				        } else {$timeout(function() {
				        	for( var i=0;i<$scope.excelfile.length;i++){
				            $scope.files.push($scope.excelfile[i]);
				            $scope.quotation.files.push({
				                filename : $scope.excelfile[i].name,
				                filepath : '',
				                quotation : ''
				            });
				        }
				        },200);
				    }  

				    }
				    
				    $scope.deleteuploadfiles = function(filename) {
				       /* $scope.tempfiles = [];
				        $scope.tempfilename = [];
				        angular.forEach($scope.files, function(row, index) {
				            if (filename != row.name) {
				                $scope.tempfiles.push(row);
				            }

				        });

				        angular.forEach($scope.quotation.files, function(value, index) {
				            if (filename != value.filename) {
				                $scope.tempfilename.push(value);
				            }

				        });
				        $scope.files = $scope.tempfiles;
				        $scope.quotation.files = $scope.tempfilename;*/
				        
				        
				        $http.post($stateParams.tenantid+'/app/airquotation/deleteFiles', filename).success(function(result) {
				        	
				        	$scope.getEdit();
				               
			            })

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
								$scope.quotation.quotationDtl
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

						$scope.quotation.quotationDtl.push(chargedata);
						var len = $scope.quotation.quotationDtl.length - 1;
						$timeout(function() {
							hideActivePapers($scope.max + "0", []);
						}, 1000);
					}
					$scope.removeRow = function() {
						if($scope.quotation.quotationDtl.length>1){
						$scope.tablerow = [];
						angular.forEach($scope.quotation.quotationDtl,
								function(row, index) {
									var check = row.select;
									console.log(index);
									if (check == undefined || check == "") {
										$scope.tablerow.push(row);
									} else {

									}
								});
						}
						else{
							logger.logError("Atleast One Row Required");
						}
						$scope.quotation.quotationDtl = $scope.tablerow;
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

					var today = new Date();
					var dd = today.getDate();
					var mm = today.getMonth() + 1;

					var yyyy = today.getFullYear();
					if (dd < 10) {
						dd = '0' + dd
					}
					if (mm < 10) {
						mm = '0' + mm
					}
					var today = dd + '/' + mm + '/' + yyyy;
					$scope.quotation.dataOfIssues = today;
					$scope.modeList = [];
					$scope.getQuotationType = function() {
						var data = {};
						data["id"] = "2";
						data["text"] = "AIR";
						$scope.modeList.push(data);
						$scope.quotation.mode='2';
						// data = {};
						// data["id"] = "2";
						// data["text"] = "SEA";
						// $scope.modeList.push(data);
					}

					$scope.salesTypeList = [];
//					$scope.getSalesType = function() {
//						var data = {};
//						data["id"] = "1";
//						data["text"] = "CROSS TRADE";
//						$scope.salesTypeList.push(data);
//						data = {};
//						data["id"] = "2";
//						data["text"] = "LOCAL";
//						$scope.salesTypeList.push(data);
//						data = {};
//						data["id"] = "3";
//						data["text"] = "NOMINATED";
//						$scope.salesTypeList.push(data);
//
//					}
//					$scope.getSalesType();
					$scope.transactionTypeList = [];
//					$scope.getTransactionType = function() {
//						var data = {};
//						data["id"] = "1";
//						data["text"] = "BUY";
//						$scope.transactionTypeList.push(data);
//						data = {};
//						data["id"] = "2";
//						data["text"] = "SELL";
//						$scope.transactionTypeList.push(data);
//
//					}
//					$scope.getTransactionType();

					$scope.PaymentMethodList = [];
//					$scope.getpaymentMethod = function() {
//						var data = {};
//						data["id"] = "12";
//						data["text"] = "PREAPID";
//						$scope.PaymentMethodList.push(data);
//						data["id"] = "13";
//						data["text"] = "TO COLLECT";
//						$scope.PaymentMethodList.push(data);
//						// data = {};
//						// data["id"] = "2";
//						// data["text"] = "SELL";
//						// $scope.PaymentMethodList.push(data);
//
//					}
//					$scope.getpaymentMethod();

					$scope.chargeList = [];
					$scope.dropdown = function() {
						$scope.getQuotationType();
						$http.post($stateParams.tenantid+'/app/seaquotation/getServicePartnerList').success(function(datas) {
							$scope.customerDropList = datas.customerList;
							 $scope.consigneeDropList = datas.consigneeList;
							 $scope.shipperDropList = datas.shipperList;
							 $scope.nominatedDropList = datas.nominatedList;
							 $scope.vendorDropList = datas.vendorList;
							 $scope.serviceParnrDropList=datas.serviceParnrList;

										}).error(function(data) {

								});
						$http.get(
								$stateParams.tenantid
										+ '/app/airquotation/getiataList')
								.success(function(datas) {
									debugger
									$scope.portList = datas.commonUtilityBean;

								}).error(function(data) {

								});
						$http
								.get(
										$stateParams.tenantid
												+ '/app/airquotation/getBranch')
								.success(
										function(datas) {
											$scope.branchList = datas.commonUtilityBean;

										}).error(function(data) {

								});
						$http
								.get(
										$stateParams.tenantid
												+ '/app/airquotation/getCurrencyList')
								.success(
										function(datas) {
											$scope.currencylist = angular
													.copy(datas.commonUtilityBean);
										}).error(function(data) {

								});

						$http.get($stateParams.tenantid + '/app/airquotation/getSalesList')
						.success(function(datas) {
							$scope.salesTypeList = datas.commonUtilityBean;

						}).error(function(data) {

						});
						
						$http.get($stateParams.tenantid + '/app/airquotation/getServiceList')
						.success(function(datas) {
							$scope.servicePartnerTypelist = datas.commonUtilityBean;

						}).error(function(data) {

						});
						
						$http.get($stateParams.tenantid+'/app/seaquotation/getcommodity').success(function(datas) {
							
						    $scope.commodityList = datas.commonUtilityBean;	    

						}).error(function(data) {

						});
						
						$http.get($stateParams.tenantid + '/app/airquotation/getPaymentList')
						.success(function(datas) {
							$scope.PaymentMethodList = datas.commonUtilityBean;

						}).error(function(data) {

						});
						
						
						$http.get($stateParams.tenantid + '/app/airquotation/getTransactionList')
						.success(function(datas) {
							$scope.transactionTypeList = datas.commonUtilityBean;

						}).error(function(data) {

						});
						

						$http
								.get(
										$stateParams.tenantid
												+ '/app/airquotation/getEmployeeList')
								.success(
										function(datas) {
											$scope.employeeList = datas.commonUtilityBean;

										}).error(function(data) {

								});

						$http
								.get(
										$stateParams.tenantid
												+ '/app/airquotation/getChargeHeads')
								.success(
										function(datas) {
											$scope.chargeHeadList = datas.commonUtilityBean;

										}).error(function(data) {

								});

						$http.get(
								$stateParams.tenantid
										+ '/app/airquotation/getTerms')
								.success(function(datas) {
									$scope.TermList = datas.commonUtilityBean;

								}).error(function(data) {

								});

						$http.get(
								$stateParams.tenantid
										+ '/app/seaquotation/getUnitList')
								.success(function(datas) {
									$scope.UnitList = datas.commonUtilityBean;

								}).error(function(data) {

								});

					}
					$scope.editdata = function(quotation) {

						$scope.getQuotationType();
						$http.post($stateParams.tenantid+'/app/seaquotation/getServicePartnerList').success(function(datas) {
							debugger
							 $scope.customerDropList = datas.customerList;
							 $scope.consigneeDropList = datas.consigneeList;
							 $scope.shipperDropList = datas.shipperList;
							 $scope.nominatedDropList = datas.nominatedList;
							 $scope.vendorDropList = datas.vendorList;
							 $scope.serviceParnrDropList=datas.serviceParnrList;

										}).error(function(data) {

								});
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
						if ($scope.checkundefined($scope.quotation.customer)) {
							msg = msg + "<li>CUSTOMER :Field is required.</li>";
							$scope.changecolor('customer_id');
						} else {
							$scope.clearcolor('customer_id');
						}

						angular
								.forEach(
										$scope.quotation.quotationDtl,
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
														+ "# VALID FROM :Field is required.</li>";
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
											if ($scope
													.checkundefined(chargesDetail.currency)) {
												msg = msg
														+ "<li>Row :"
														+ (index + 1)
														+ "# Currency :Field is required.</li>";
											}
											if ($scope
													.checkundefined(chargesDetail.transactionType)) {
												msg = msg
														+ "<li>Row :"
														+ (index + 1)
														+ "# Transaction Type :Field is required.</li>";
											}
											if ($scope
													.checkundefined(chargesDetail.buySell)) {
												msg = msg
														+ "<li>Row :"
														+ (index + 1)
														+ "# Buy Sell:Field is required.</li>";
											}

										});
						alertmsg = alertmsg + msg + "</ui>";
						if ($scope.checkundefined(msg)) {
							return '';
						} else {
							return alertmsg;
						}

					}
					$scope.edit = false;
					
					
					$scope.view = function() {

					if (QuotHdId != '' && QuotHdId != undefined) {
						$scope.edit = true;
						$scope.dropdown();
						$http
								.post(
										$stateParams.tenantid
												+ '/app/airquotation/view',
										QuotHdId)
								.success(
										function(data) {
											debugger
											$scope.quotation = data.lQuotationBean[0];
											$scope.files=[];
											
											if(data.lQuotationBean[0].service != null && data.lQuotationBean[0].service != ''){
												$scope.quotation.service = data.lQuotationBean[0].service
												.toString();
											}
											if(data.lQuotationBean[0].commodity != null && data.lQuotationBean[0].commodity != ''){
												$scope.quotation.commodity = data.lQuotationBean[0].commodity.toString();
											}
											
											
											if(data.lQuotationBean[0].branch != null && data.lQuotationBean[0].branch != ''){

											$scope.quotation.branch = data.lQuotationBean[0].branch
													.toString();
											}
											if(data.lQuotationBean[0].mode != null && data.lQuotationBean[0].mode != '' ){

											$scope.quotation.mode = data.lQuotationBean[0].mode
													.toString();
											}
											if(data.lQuotationBean[0].aol != null && data.lQuotationBean[0].aol != ''){

											$scope.quotation.aol = data.lQuotationBean[0].aol
													.toString();
											}
											if(data.lQuotationBean[0].aod != null && data.lQuotationBean[0].aod != ''){

											$scope.quotation.aod = data.lQuotationBean[0].aod
													.toString();
											}
											if(data.lQuotationBean[0].term != null && data.lQuotationBean[0].term != ''){

											$scope.quotation.term = data.lQuotationBean[0].term
													.toString();
											}
											if(data.lQuotationBean[0].origin != null && data.lQuotationBean[0].origin != ''){

											$scope.quotation.origin = data.lQuotationBean[0].origin
													.toString();
											}
											if(data.lQuotationBean[0].destination != null && data.lQuotationBean[0].destination != ''){

											$scope.quotation.destination = data.lQuotationBean[0].destination
													.toString();
											}
											if(data.lQuotationBean[0].customer != null && data.lQuotationBean[0].customer != ''){

											$scope.quotation.customer = data.lQuotationBean[0].customer
													.toString();
											}
											if(data.lQuotationBean[0].shipper != null && data.lQuotationBean[0].shipper != ''){

											$scope.quotation.shipper = data.lQuotationBean[0].shipper
													.toString();
											}
											if(data.lQuotationBean[0].consignee != null && data.lQuotationBean[0].consignee != ''){

											$scope.quotation.consignee = data.lQuotationBean[0].consignee
													.toString();
											}
											if(data.lQuotationBean[0].nominatedBy != null && data.lQuotationBean[0].nominatedBy != ''){

											$scope.quotation.nominatedBy = data.lQuotationBean[0].nominatedBy
													.toString();
											}
											if(data.lQuotationBean[0].vendor != null && data.lQuotationBean[0].vendor != ''){

											$scope.quotation.vendor = data.lQuotationBean[0].vendor
													.toString();
											}
											if(data.lQuotationBean[0].currency != null && data.lQuotationBean[0].currency != ''){

											$scope.quotation.currency = data.lQuotationBean[0].currency
													.toString();
											}
											if(data.lQuotationBean[0].salesType != null && data.lQuotationBean[0].salesType != ''){

											$scope.quotation.salesType = data.lQuotationBean[0].salesType
													.toString();
											}

											for (var i = 0; i < $scope.quotation.quotationDtl.length; i++) {
												$scope.quotation.quotationDtl[i].chargeHeads = $scope.quotation.quotationDtl[i].chargeHeads
														.toString();
												$scope.quotation.quotationDtl[i].unit = $scope.quotation.quotationDtl[i].unit
														.toString();
												$scope.quotation.quotationDtl[i].currency = $scope.quotation.quotationDtl[i].currency
														.toString();
												$scope.quotation.quotationDtl[i].paymentMethod = $scope.quotation.quotationDtl[i].paymentMethod
														.toString();
												$scope.quotation.quotationDtl[i].transactionType = $scope.quotation.quotationDtl[i].transactionType
														.toString();
												$scope.quotation.quotationDtl[i].buySell = $scope.quotation.quotationDtl[i].buySell
														.toString();
											}
											 angular.forEach(data.filel, function(value, index) {
						                          	
												  var dummy = value.fileName;
												  
												  
												  $scope.files.push(dummy);

												  
											  });
											  var dum = []; 
												for (var i = 0; i < $scope.files.length; i++) { 
													var subString = "/"; 
													 if($scope.files[i].indexOf(subString) !== -1){
														                        
															if ($scope.files[i].indexOf(subString) !== -1) {                            
																var val = $scope.files[i].split("/");                            
																var	value = {
																		filename : val[val.length - 1],
																		filepath :'',
																		quotation:''
																
																}                            
																dum.push(value);                        
																} else {                            
																	var val = $scope.files[i].split("\\");                           
																	var value ={ 
																			
																			filename : val[val.length - 1],
															                filepath : '',
															                quotation : ''
																		   }                           
																	dum.push(value);                        
																	}   
													 }else{
														                        
															if ($scope.files[i].indexOf(subString) !== -1) {                            
																var val = $scope.files[i].split("/");                            
																value = val[0];                            
																dum.push(value);                        
																} else {                            
																	var val = $scope.files[i].split("\\");                           
																	value = val[0];                            
																	dum.push(value);                        
																	}   
													 }
													 
													 
													                 
													}
											 $scope.quotation.files=dum;
											// zl.push($scope.quotation.files);
										});

					}
				}
				$scope.view();
					/*var frmData = new FormData();*/
					$scope.submitupdate = function() {
						/*console.log($scope.quotation);*/
						var msg = $scope.checkValidation();
						if (!$scope.checkundefined(msg)) {
							logger.logError(msg);
						} else {
							if($scope.quotation.quotationDtl.length>0){
							$http.post($stateParams.tenantid + '/app/airquotation/update',
									$scope.quotation).success(function(datas) {
								debugger
								if (datas.success == true) {
									/*logger.logSuccess(datas.message);*/
									/*if ($scope.files.length > 0) {*/
//										
										
									if($scope.files == null || $scope.files != '' || $scope.files != undefined){
											var quotationNo = $scope.quotation.quotationNo;
											/*$http.post($stateParams.tenantid + '/app/airquotation/uploaddelete',quotationNo).success(*/
													/*function(data) {*/
//														if(data==true){
															for(var i=0;i<$scope.files.length;i++){
																 var quotationNo = $scope.quotation.quotationNo;
										                            var frmData = new FormData();

																	 var file = $scope.files[i];
																	 frmData.append("file", file);									 
																	 frmData.append("quotationNo", quotationNo);
																	 
																	 $.ajax({
											                             type : "POST",
											                             url : $stateParams.tenantid+"/app/airquotation/saveuploadfile",
											                             data : frmData,
											                             contentType : false,
											                             processData : false,
											                             success : function(result) {
											                             }
											                         });
															}	
														/*}*/
														
														
													/*}).error(function(data) {
											});*/
										}
										
										
										
										
										/*for(var i=0;i<$scope.files.length;i++){
											 var quotationNo = $scope.quotation.quotationNo;
											 var frmData = new FormData();
											 if($scope.files[i].name != null && $scope.files[i].name != undefined){
												 var file = $scope.files[i];
												 frmData.append("file", file);									 
												 frmData.append("quotationNo", quotationNo);
											 }else{
												var  filepaths = $scope.files[i];
												 frmData.append("filepaths", filepaths);
					                             frmData.append("quotationNo", quotationNo);
											 }
										
										
										
										 $.ajax({
			                               type : "POST",
			                               url : $stateParams.tenantid+"/app/airquotation/saveuploadfile",
			                               data : frmData,
			                               contentType : false,
			                               processData : false,
			                               success : function(result) {
			                               }
										
			                           });
										}*/
			                       /* }*/
									logger.logSuccess("Quotation Updated Successfully");
									/*$state.go('app.air.quotation.list', {
										tenantid : $stateParams.tenantid
									});*/
									$location.url($stateParams.tenantid+'/airQuotation/edit?QuotHdId='+datas.quotationId);
									if ($scope.createQuote) {
										// $state.go('app.salesmarketing.booking.list',{tenantid:$stateParams.tenantid});
									} else {
										// $state.go('app.sales.quotation.list',{tenantid:$stateParams.tenantid});
									}

								} else {
									logger.logError(datas.message);
								}
							}).error(function(data) {
								logger.logError("Please try again");
							});
							}else{
					        	logger.logError("Atleast One Row Required");
					        }
						}

					}
					$scope.cancel = function() {
						$state.go('app.air.quotation.list', {
							tenantid : $stateParams.tenantid
						});
					}
					
					$scope.printQuot = function(quotationHdId){
				        debugger
				        console.log("Both print invoice")
				        var url = $stateParams.tenantid+'/app/airquotation/print?quotationHdId=' + quotationHdId;
				        var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
				        wnd.print();   
				     }
					
					$scope.sendmail = function(quotationHdId){
						$http.get($stateParams.tenantid + '/app/airquotation/sendMail?quotationHdId='+quotationHdId)
						.success(function(datas) {
							logger.logSuccess('Mail Sent Successfully!')
						}).error(function(data) {

						});
					}

				});


app
.controller(
		'airquotationViewCtrl',
		function($scope, $timeout, $stateParams, sharedProperties,
				toaster, $filter, $rootScope, $http, $location, logger,
				$state, ngDialog, $controller, $injector,$window) {
			$scope.quotationTypeList = [];
			$scope.customerDropList = [];
			$scope.consigneeDropList  = [];
			$scope.shipperDropList  = [];
			$scope.nominatedDropList  = [];
			$scope.vendorDropList = [];
			$scope.serviceParnrDropList = [];
			$scope.portList = [];
			$scope.currencyList = [];
			$scope.createQuote = false;

			var QuotHdId = parseInt($location.search().QuotHdId);

			$scope.quotation = {
				service : '',
				aol : '',
				origin : '',
				customer : '',
				salesPerson : '',
				vendor : '',
				flightNo : '',
				attention : '',
				quotationDate : '',
				branch : '',
				aod : '',
				destination : '',
				shipper : '',
				salesType : '',
				carrier : '',
				flightDate : '',
				termConditions : '',
				mode : '2',
				currency : '',
				term : '',
				commodity : '',
				consignee : '',
				nominatedBy : '',
				validityDate : '',
				remarks : '',
				quotationId : '',
				dimensionName:'',
				quotationDtl : [ {
					id : 0,
					chargeHeads : '',
					quotationId : '',
					quotationDtlId : '',
					unit : '',
					currency : '',
					qty : '',
					rate : '',
					paymentMethod : '',
					transactionType : '',
					buySell : '',
					note : ''
				} ]
			}
			
			$scope.checkundefined = function(value) {
				var invalid = false;
				if (value == undefined || value == 'undefined'
						|| value == null || value == 'null'
						|| value == '') {
					invalid = true;
				}
				return invalid;

			}
			
			$scope.checkundefined1 = function(value) {
		        var invalid = false;
		        if (value == undefined || value == 'undefined' || value == null || value == 'null' || value == '') {
		            invalid = true;
		        }
		        return invalid;

		    }

			$rootScope.uploadFile = function(element) {
		        $scope.excelfile = element.files;
		        $scope.adduploadfiles();
		    }
		    $scope.files = [];
		    $scope.quotation.files= [];
		    $scope.adduploadfiles = function() {
		    	debugger
		        var obj = []

		        if ($scope.checkundefined1($scope.excelfile)) {
		            logger.logError("Please select the file");
		        } else {
		            obj = $filter('filter')($scope.quotation.files, {
		                filename : $scope.excelfile.name
		            }, true);
		        }

		        if (obj != undefined && obj.length > 0) {
		            logger.logError($scope.excelfile.name + " same file already added");
		        } else {$timeout(function() {
		        	for( var i=0;i<$scope.excelfile.length;i++){
		            $scope.files.push($scope.excelfile[i]);
		            $scope.quotation.files.push({
		                filename : $scope.excelfile[i].name,
		                filepath : '',
		                quotation : ''
		            });
		        }
		        },200);
		    }  

		    }
		    
		    $scope.deleteuploadfiles = function(filename) {
		       /* $scope.tempfiles = [];
		        $scope.tempfilename = [];
		        angular.forEach($scope.files, function(row, index) {
		            if (filename != row.name) {
		                $scope.tempfiles.push(row);
		            }

		        });

		        angular.forEach($scope.quotation.files, function(value, index) {
		            if (filename != value.filename) {
		                $scope.tempfilename.push(value);
		            }

		        });
		        $scope.files = $scope.tempfiles;
		        $scope.quotation.files = $scope.tempfilename;*/
		        
		        
		        $http.post($stateParams.tenantid+'/app/airquotation/deleteFiles', filename).success(function(result) {
		        	
		        	$scope.getEdit();
		               
	            })

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
						$scope.quotation.quotationDtl
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

				$scope.quotation.quotationDtl.push(chargedata);
				var len = $scope.quotation.quotationDtl.length - 1;
				$timeout(function() {
					hideActivePapers($scope.max + "0", []);
				}, 1000);
			}
			$scope.removeRow = function() {
				if($scope.quotation.quotationDtl.length>1){
				$scope.tablerow = [];
				angular.forEach($scope.quotation.quotationDtl,
						function(row, index) {
							var check = row.select;
							console.log(index);
							if (check == undefined || check == "") {
								$scope.tablerow.push(row);
							} else {

							}
						});
				}
				else{
					logger.logError("Atleast One Row Required");
				}
				$scope.quotation.quotationDtl = $scope.tablerow;
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

			var today = new Date();
			var dd = today.getDate();
			var mm = today.getMonth() + 1;

			var yyyy = today.getFullYear();
			if (dd < 10) {
				dd = '0' + dd
			}
			if (mm < 10) {
				mm = '0' + mm
			}
			var today = dd + '/' + mm + '/' + yyyy;
			$scope.quotation.dataOfIssues = today;
			$scope.modeList = [];
			$scope.getQuotationType = function() {
				var data = {};
				data["id"] = "2";
				data["text"] = "AIR";
				$scope.modeList.push(data);
				$scope.quotation.mode='2';
				// data = {};
				// data["id"] = "2";
				// data["text"] = "SEA";
				// $scope.modeList.push(data);
			}

			$scope.salesTypeList = [];
//			$scope.getSalesType = function() {
//				var data = {};
//				data["id"] = "1";
//				data["text"] = "CROSS TRADE";
//				$scope.salesTypeList.push(data);
//				data = {};
//				data["id"] = "2";
//				data["text"] = "LOCAL";
//				$scope.salesTypeList.push(data);
//				data = {};
//				data["id"] = "3";
//				data["text"] = "NOMINATED";
//				$scope.salesTypeList.push(data);
//
//			}
//			$scope.getSalesType();
			$scope.transactionTypeList = [];
//			$scope.getTransactionType = function() {
//				var data = {};
//				data["id"] = "1";
//				data["text"] = "BUY";
//				$scope.transactionTypeList.push(data);
//				data = {};
//				data["id"] = "2";
//				data["text"] = "SELL";
//				$scope.transactionTypeList.push(data);
//
//			}
//			$scope.getTransactionType();

			$scope.PaymentMethodList = [];
//			$scope.getpaymentMethod = function() {
//				var data = {};
//				data["id"] = "12";
//				data["text"] = "PREAPID";
//				$scope.PaymentMethodList.push(data);
//				data["id"] = "13";
//				data["text"] = "TO COLLECT";
//				$scope.PaymentMethodList.push(data);
//				// data = {};
//				// data["id"] = "2";
//				// data["text"] = "SELL";
//				// $scope.PaymentMethodList.push(data);
//
//			}
//			$scope.getpaymentMethod();

			$scope.chargeList = [];
			$scope.dropdown = function() {
				$scope.getQuotationType();
				$http.post($stateParams.tenantid+'/app/seaquotation/getServicePartnerList').success(function(datas) {
					$scope.customerDropList = datas.customerList;
					 $scope.consigneeDropList = datas.consigneeList;
					 $scope.shipperDropList = datas.shipperList;
					 $scope.nominatedDropList = datas.nominatedList;
					 $scope.vendorDropList = datas.vendorList;
					 $scope.serviceParnrDropList=datas.serviceParnrList;

								}).error(function(data) {

						});
				$http.get(
						$stateParams.tenantid
								+ '/app/airquotation/getiataList')
						.success(function(datas) {
							debugger
							$scope.portList = datas.commonUtilityBean;

						}).error(function(data) {

						});
				$http
						.get(
								$stateParams.tenantid
										+ '/app/airquotation/getBranch')
						.success(
								function(datas) {
									$scope.branchList = datas.commonUtilityBean;

								}).error(function(data) {

						});
				$http
						.get(
								$stateParams.tenantid
										+ '/app/airquotation/getCurrencyList')
						.success(
								function(datas) {
									$scope.currencylist = angular
											.copy(datas.commonUtilityBean);
								}).error(function(data) {

						});

				$http.get($stateParams.tenantid + '/app/airquotation/getSalesList')
				.success(function(datas) {
					$scope.salesTypeList = datas.commonUtilityBean;

				}).error(function(data) {

				});
				
				$http.get($stateParams.tenantid + '/app/airquotation/getServiceList')
				.success(function(datas) {
					$scope.servicePartnerTypelist = datas.commonUtilityBean;

				}).error(function(data) {

				});
				
				$http.get($stateParams.tenantid+'/app/seaquotation/getcommodity').success(function(datas) {
					
				    $scope.commodityList = datas.commonUtilityBean;	    

				}).error(function(data) {

				});
				
				$http.get($stateParams.tenantid + '/app/airquotation/getPaymentList')
				.success(function(datas) {
					$scope.PaymentMethodList = datas.commonUtilityBean;

				}).error(function(data) {

				});
				
				
				$http.get($stateParams.tenantid + '/app/airquotation/getTransactionList')
				.success(function(datas) {
					$scope.transactionTypeList = datas.commonUtilityBean;

				}).error(function(data) {

				});
				

				$http
						.get(
								$stateParams.tenantid
										+ '/app/airquotation/getEmployeeList')
						.success(
								function(datas) {
									$scope.employeeList = datas.commonUtilityBean;

								}).error(function(data) {

						});

				$http
						.get(
								$stateParams.tenantid
										+ '/app/airquotation/getChargeHeads')
						.success(
								function(datas) {
									$scope.chargeHeadList = datas.commonUtilityBean;

								}).error(function(data) {

						});

				$http.get(
						$stateParams.tenantid
								+ '/app/airquotation/getTerms')
						.success(function(datas) {
							$scope.TermList = datas.commonUtilityBean;

						}).error(function(data) {

						});

				$http.get(
						$stateParams.tenantid
								+ '/app/seaquotation/getUnitList')
						.success(function(datas) {
							$scope.UnitList = datas.commonUtilityBean;

						}).error(function(data) {

						});

			}
			$scope.editdata = function(quotation) {

				$scope.getQuotationType();
				$http.post($stateParams.tenantid+'/app/seaquotation/getServicePartnerList').success(function(datas) {
					debugger
					 $scope.customerDropList = datas.customerList;
					 $scope.consigneeDropList = datas.consigneeList;
					 $scope.shipperDropList = datas.shipperList;
					 $scope.nominatedDropList = datas.nominatedList;
					 $scope.vendorDropList = datas.vendorList;
					 $scope.serviceParnrDropList=datas.serviceParnrList;

								}).error(function(data) {

						});
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
				if ($scope.checkundefined($scope.quotation.customer)) {
					msg = msg + "<li>CUSTOMER :Field is required.</li>";
					$scope.changecolor('customer_id');
				} else {
					$scope.clearcolor('customer_id');
				}

				angular
						.forEach(
								$scope.quotation.quotationDtl,
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
												+ "# VALID FROM :Field is required.</li>";
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
									if ($scope
											.checkundefined(chargesDetail.currency)) {
										msg = msg
												+ "<li>Row :"
												+ (index + 1)
												+ "# Currency :Field is required.</li>";
									}
									if ($scope
											.checkundefined(chargesDetail.transactionType)) {
										msg = msg
												+ "<li>Row :"
												+ (index + 1)
												+ "# Transaction Type :Field is required.</li>";
									}
									if ($scope
											.checkundefined(chargesDetail.buySell)) {
										msg = msg
												+ "<li>Row :"
												+ (index + 1)
												+ "# Buy Sell:Field is required.</li>";
									}

								});
				alertmsg = alertmsg + msg + "</ui>";
				if ($scope.checkundefined(msg)) {
					return '';
				} else {
					return alertmsg;
				}

			}
			$scope.edit = false;
			
			
			$scope.view = function() {

			if (QuotHdId != '' && QuotHdId != undefined) {
				$scope.edit = true;
				$scope.dropdown();
				$http
						.post(
								$stateParams.tenantid
										+ '/app/airquotation/view',
								QuotHdId)
						.success(
								function(data) {
									debugger
									$scope.quotation = data.lQuotationBean[0];
									$scope.files=[];
									
									if(data.lQuotationBean[0].service != null && data.lQuotationBean[0].service != '' && data.lQuotationBean[0].service == 2){
										
									
									$scope.quotation.service = "IMPORT";
								}
								else
								
									{
									$scope.quotation.service = "EXPORT";

									}
									
									if(data.lQuotationBean[0].commodity != null && data.lQuotationBean[0].commodity != ''){
										$scope.quotation.commodity = data.lQuotationBean[0].commodity.toString();
									}
									
									
									if(data.lQuotationBean[0].branch != null && data.lQuotationBean[0].branch != ''){

									$scope.quotation.branch = data.lQuotationBean[0].branch
											.toString();
									}
									if(data.lQuotationBean[0].mode != null && data.lQuotationBean[0].mode != '' && data.lQuotationBean[0].mode == '2'){

									$scope.quotation.mode = "AIR";
									}
									if(data.lQuotationBean[0].aol != null && data.lQuotationBean[0].aol != ''){

									$scope.quotation.aol = data.lQuotationBean[0].aol
											.toString();
									}
									if(data.lQuotationBean[0].aod != null && data.lQuotationBean[0].aod != ''){

									$scope.quotation.aod = data.lQuotationBean[0].aod
											.toString();
									}
									if(data.lQuotationBean[0].term != null && data.lQuotationBean[0].term != ''){

									$scope.quotation.term = data.lQuotationBean[0].term
											.toString();
									}
									if(data.lQuotationBean[0].origin != null && data.lQuotationBean[0].origin != ''){

									$scope.quotation.origin = data.lQuotationBean[0].origin
											.toString();
									}
									if(data.lQuotationBean[0].destination != null && data.lQuotationBean[0].destination != ''){

									$scope.quotation.destination = data.lQuotationBean[0].destination
											.toString();
									}
									if(data.lQuotationBean[0].customer != null && data.lQuotationBean[0].customer != ''){

									$scope.quotation.customer = data.lQuotationBean[0].customer
											.toString();
									}
									if(data.lQuotationBean[0].shipper != null && data.lQuotationBean[0].shipper != ''){

									$scope.quotation.shipper = data.lQuotationBean[0].shipper
											.toString();
									}
									if(data.lQuotationBean[0].consignee != null && data.lQuotationBean[0].consignee != ''){

									$scope.quotation.consignee = data.lQuotationBean[0].consignee
											.toString();
									}
									if(data.lQuotationBean[0].nominatedBy != null && data.lQuotationBean[0].nominatedBy != ''){

									$scope.quotation.nominatedBy = data.lQuotationBean[0].nominatedBy
											.toString();
									}
									if(data.lQuotationBean[0].vendor != null && data.lQuotationBean[0].vendor != ''){

									$scope.quotation.vendor = data.lQuotationBean[0].vendor
											.toString();
									}
									if(data.lQuotationBean[0].currency != null && data.lQuotationBean[0].currency != ''){

									$scope.quotation.currency = data.lQuotationBean[0].currency
											.toString();
									}
									if(data.lQuotationBean[0].salesType != null && data.lQuotationBean[0].salesType != ''){

									$scope.quotation.salesType = data.lQuotationBean[0].salesType
											.toString();
									}

									for (var i = 0; i < $scope.quotation.quotationDtl.length; i++) {
										$scope.quotation.quotationDtl[i].chargeHeads = $scope.quotation.quotationDtl[i].chargeHeads
												.toString();
										$scope.quotation.quotationDtl[i].unit = $scope.quotation.quotationDtl[i].unit
												.toString();
										$scope.quotation.quotationDtl[i].currency = $scope.quotation.quotationDtl[i].currency
												.toString();
										$scope.quotation.quotationDtl[i].paymentMethod = $scope.quotation.quotationDtl[i].paymentMethod
												.toString();
										$scope.quotation.quotationDtl[i].transactionType = $scope.quotation.quotationDtl[i].transactionType
												.toString();
										$scope.quotation.quotationDtl[i].buySell = $scope.quotation.quotationDtl[i].buySell
												.toString();
									}
									 angular.forEach(data.filel, function(value, index) {
				                          	
										  var dummy = value.fileName;
										  
										  
										  $scope.files.push(dummy);

										  
									  });
									  var dum = []; 
										for (var i = 0; i < $scope.files.length; i++) { 
											var subString = "/"; 
											 if($scope.files[i].indexOf(subString) !== -1){
												                        
													if ($scope.files[i].indexOf(subString) !== -1) {                            
														var val = $scope.files[i].split("/");                            
														var	value = {
																filename : val[val.length - 1],
																filepath :'',
																quotation:''
														
														}                            
														dum.push(value);                        
														} else {                            
															var val = $scope.files[i].split("\\");                           
															var value ={ 
																	
																	filename : val[val.length - 1],
													                filepath : '',
													                quotation : ''
																   }                           
															dum.push(value);                        
															}   
											 }else{
												                        
													if ($scope.files[i].indexOf(subString) !== -1) {                            
														var val = $scope.files[i].split("/");                            
														value = val[0];                            
														dum.push(value);                        
														} else {                            
															var val = $scope.files[i].split("\\");                           
															value = val[0];                            
															dum.push(value);                        
															}   
											 }
											 
											 
											                 
											}
									 $scope.quotation.files=dum;
									// zl.push($scope.quotation.files);
								});

			}
		}
		$scope.view();
			/*var frmData = new FormData();*/
			$scope.submitupdate = function() {
				/*console.log($scope.quotation);*/
				var msg = $scope.checkValidation();
				if (!$scope.checkundefined(msg)) {
					logger.logError(msg);
				} else {
					if($scope.quotation.quotationDtl.length>0){
					$http.post($stateParams.tenantid + '/app/airquotation/update',
							$scope.quotation).success(function(datas) {
						debugger
						if (datas.success == true) {
							/*logger.logSuccess(datas.message);*/
							/*if ($scope.files.length > 0) {*/
//								
								
							if($scope.files == null || $scope.files != '' || $scope.files != undefined){
									var quotationNo = $scope.quotation.quotationNo;
									/*$http.post($stateParams.tenantid + '/app/airquotation/uploaddelete',quotationNo).success(*/
											/*function(data) {*/
//												if(data==true){
													for(var i=0;i<$scope.files.length;i++){
														 var quotationNo = $scope.quotation.quotationNo;
								                            var frmData = new FormData();

															 var file = $scope.files[i];
															 frmData.append("file", file);									 
															 frmData.append("quotationNo", quotationNo);
															 
															 $.ajax({
									                             type : "POST",
									                             url : $stateParams.tenantid+"/app/airquotation/saveuploadfile",
									                             data : frmData,
									                             contentType : false,
									                             processData : false,
									                             success : function(result) {
									                             }
									                         });
													}	
												/*}*/
												
												
											/*}).error(function(data) {
									});*/
								}
								
								
								
								
								/*for(var i=0;i<$scope.files.length;i++){
									 var quotationNo = $scope.quotation.quotationNo;
									 var frmData = new FormData();
									 if($scope.files[i].name != null && $scope.files[i].name != undefined){
										 var file = $scope.files[i];
										 frmData.append("file", file);									 
										 frmData.append("quotationNo", quotationNo);
									 }else{
										var  filepaths = $scope.files[i];
										 frmData.append("filepaths", filepaths);
			                             frmData.append("quotationNo", quotationNo);
									 }
								
								
								
								 $.ajax({
	                               type : "POST",
	                               url : $stateParams.tenantid+"/app/airquotation/saveuploadfile",
	                               data : frmData,
	                               contentType : false,
	                               processData : false,
	                               success : function(result) {
	                               }
								
	                           });
								}*/
	                       /* }*/
							logger.logSuccess("Quotation Updated Successfully");
							/*$state.go('app.air.quotation.list', {
								tenantid : $stateParams.tenantid
							});*/
							$location.url($stateParams.tenantid+'/airQuotation/edit?QuotHdId='+datas.quotationId);
							if ($scope.createQuote) {
								// $state.go('app.salesmarketing.booking.list',{tenantid:$stateParams.tenantid});
							} else {
								// $state.go('app.sales.quotation.list',{tenantid:$stateParams.tenantid});
							}

						} else {
							logger.logError(datas.message);
						}
					}).error(function(data) {
						logger.logError("Please try again");
					});
					}else{
			        	logger.logError("Atleast One Row Required");
			        }
				}

			}
			$scope.cancel = function() {
				$state.go('app.air.quotation.list', {
					tenantid : $stateParams.tenantid
				});
			}
			
			$scope.printQuot = function(quotationHdId){
		        debugger
		        console.log("Both print invoice")
		        var url = $stateParams.tenantid+'/app/airquotation/print?quotationHdId=' + quotationHdId;
		        var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
		        wnd.print();   
		     }
			
			$scope.sendmail = function(quotationHdId){
				$http.get($stateParams.tenantid + '/app/airquotation/sendMail?quotationHdId='+quotationHdId)
				.success(function(datas) {
					logger.logSuccess('Mail Sent Successfully!')
				}).error(function(data) {

				});
			}

		});

