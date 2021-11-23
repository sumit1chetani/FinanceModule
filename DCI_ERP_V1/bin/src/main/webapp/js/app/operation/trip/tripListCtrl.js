//list
app.controller('tripListCtrl',
		function($scope, $rootScope, $controller,$injector, $http,ngDialog, $location, logger, utilsService, $state, sharedProperties, 
				$window,toaster,validationService,$stateParams,$timeout) {
	 $scope.rowCollection= [];
			$scope.tripnew = function() {
				var modalInstance = $modal.open({
					templateUrl : 'views/trip/tripadd.html',
					controller : 'tripAddCtrl',
					preCloseCallback : $scope.getList
				});
			};
			
			
			
			

			$scope.userId=$('#userId').val();
			  $http.get($stateParams.tenantid+'/app/plantrip/getPlanTripList').success(function(datas) {
		             $scope.rowCollection =datas;
		          
		        });
			    $scope.add = function() {
				    $state.go('app.operation.trip.add',{tenantid:$stateParams.tenantid});
				};

			
			$scope.getList = function() {
// $http.get('/stopping/list')
// .success(function(data) {
// $scope.stoppingList = data;
// })
			};
			$scope.getList();
			$scope.deleteRow = function(planTripId){
		        ngDialog.openConfirm().then(function() {
					 $http.get($stateParams.tenantid+'/app/plantrip/deleteTrip?planTripId='+planTripId).success(function(data) {
		                if (data == true) {
		                    logger.logSuccess("deleted successfully");
		                    $state.reload();
		                } else {
		                    logger.logError("Booking created for this trip not allowed to delete!");
		                }
		            }).error(function(data) {
		               // logger.logSuccess("Error in Delete!");
		            });
		        });
			}
			
			
			$scope.reallocateTrip = function(planTrip){
				debugger
				$state.go('app.operation.trip.reallocate', {
		    		tripNo : planTrip.planTripId,
		    		lolId: planTrip.lolId,
		    		lodId: planTrip.lodId
		    		
				});
			}
			
			$scope.deallocateTrip = function(planTripId){
				$http.get($stateParams.tenantid+'/app/plantrip/updateReallocateRefId?planTripId='+planTripId).success(function(data) {
	                if (data == true) {
	                    logger.logSuccess("DeAllocated successfully");
	                    $state.reload();
	                } else {
	                    logger.logError("Error in DeAllocate!");
	                }
	            });
			}
			

			
			
			
		    $scope.editRow = function(planTripId,refId){
		    	debugger
		    	$state.go('app.operation.trip.edit', {
		    		planTripId : planTripId
				});
		  /*  	 $http.get($stateParams.tenantid+'/app/plantrip/checkEditTrip?planTripId='+planTripId).success(function(data) {
		             if (data == true) { 
		    	$state.go('app.operation.trip.edit', {
		    		planTripId : planTripId
				});
		               
						 } else { 
							 logger.logError("Not Allowed to Edit ,Trip Allotted in Booking Screen!");" +"
						 }
						 
		            }).error(function(data) {
		               // logger.logSuccess("Error in Edit!");
		            });*/ 
		    } 
		    
		    $scope.approveTrip = function(tripNo){
				$http.get($stateParams.tenantid+'/app/plantrip/approveToCreateTrip?planTripNo='+tripNo).success(function(data) {
	                if (data == true) {
	                    logger.logSuccess("Approved successfully");
	                    $state.reload();
	                } else {
	                    logger.logError("Error in Approve!");
	                }
	            });
			}
		  
		    $scope.viewTrip = function(planTripId){
		    	$state.go('app.operation.trip.view', {
		    		planTripId : planTripId
				});
		    }
		    
		    
		    $scope.viewBookings = function(tripNo){
		    	$scope.tempNo=tripNo;
				ngDialog.open({
		            template : 'BookingSummaryAlert',
		            scope : $scope,
		            controller : $controller('tripSummaryCtrl', {
		                $scope : $scope,
		                data : $scope.tripList,
		                $http : $http,
		                ngDialog : ngDialog,
		                logger : logger,
		                $injector : $injector,
		                sharedProperties : sharedProperties,
		                toaster : toaster,
		                $rootScope : $rootScope
		            }),
		            closeByEscape : false,
		});	
		
				
			}
		    
		    
		    $http.get($stateParams.tenantid+'/app/plantrip/getBookingListByTripNo?tripNo='+$scope.tempNo).success(function(returnData) {
		        
		    	$scope.bookingList=returnData.bookingList;
		    	
		    });
		    
			

		});



app.controller('tripSummaryCtrl',
		function($scope, $rootScope, $controller,$injector, $http,ngDialog, $location, logger, utilsService, $state, sharedProperties, $window,toaster,validationService,$stateParams) {
	
		    
		    $http.get($stateParams.tenantid+'/app/plantrip/getBookingListByTripNo?tripNo='+$scope.tempNo).success(function(returnData) {
		        
		    	$scope.bookingList=returnData.bookingList;
		    	
		    });
		    
			

		});

app.controller('tripReallocateCtrl',
		function($scope, $rootScope, $controller,$injector, $http,ngDialog, $location, logger, utilsService, $state, sharedProperties, 
				$window,toaster,validationService,$stateParams) {
	
	$scope.reallocate = {
		tripNo : '',
		assignTripNo : '',
		fromLocation : '',
		toLocation : '',
		reason : '',
		remarks : '',
		eta : '',
		etd : '',
		reallocateDate : ''

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

	$scope.reallocate.reallocateDate = dd + '/' + mm + '/'
			+ yyyy;

	$scope.isDestChange = true;

	$scope.cancel = function() {
		$state.go("app.operation.trip.list");
	}

	$scope.reset = function() {
		$state.reload();
	}

	$scope.reasonList = [ {
		id : 1,
		text : 'BreakDown'
	}, {
		id : 2,
		text : 'Repair'
	}, {
		id : 3,
		text : 'Technical Problem'
	}, {
		id : 4,
		text : 'Destination Change'
	} ]

	$scope.isBooking = false;
	// $scope.reason = function(){

	$scope.$watch('reallocate.reason', function(newValue,
			oldValue) {
		if ($scope.reallocate.reason != ''
				&& $scope.reallocate.reason != null
				&& $scope.reallocate.reason != undefined) {
			if ($scope.reallocate.reason == 4) {
				$scope.isDestChange = false;
				if ($scope.reallocate.toLocation != lodId) {
					$scope.isBooking = true;
					$scope.booking.lolId = $scope.reallocate.fromLocation;
					$scope.booking.lodId = $scope.reallocate.toLocation;
				} else {
					$scope.isBooking = false;
				}
				
				$http
				.get(
						$stateParams.tenantid
								+ '/app/plantrip/getTripsNotAllocated?lolId='
								+ parseInt(lolId) + '&lodId=' + parseInt($scope.reallocate.toLocation))
				.success(function(data) {

					$scope.availableTrip = data;


				});
				
			} else {
				$scope.isDestChange = true;
			}
		}
	})

	$scope
			.$watch(
					'reallocate.toLocation',
					function(newValue, oldValue) {
						if ($scope.reallocate.toLocation != ''
								&& $scope.reallocate.toLocation != null
								&& $scope.reallocate.toLocation != undefined) {
							if ($scope.reallocate.toLocation != lodId) {
								
								
								$scope.isBooking = true;
								$scope.booking.lolId = $scope.reallocate.fromLocation;
								$scope.booking.lodId = $scope.reallocate.toLocation;
							
								
								
							
							} else {
								$scope.isBooking = false;
							}
							$http
							.get(
									$stateParams.tenantid
											+ '/app/plantrip/getTripsNotAllocated?lolId='
											+ parseInt(lolId) + '&lodId=' + parseInt($scope.reallocate.toLocation))
							.success(function(data) {
								$scope.availableTrip = data;
								
							});
						}
					})

	$scope
			.$watch(
					'reallocate.assignTripNo',
					function(newValue, oldValue) {
						if ($scope.reallocate.assignTripNo != ''
								&& $scope.reallocate.assignTripNo != null
								&& $scope.reallocate.assignTripNo != undefined) {
							$http
									.get(
											$stateParams.tenantid
													+ '/app/plantrip/getPlanTripListReallocate?tripNo='
													+ $scope.reallocate.assignTripNo)
									.success(
											function(datas) {
												debugger
												$scope.tripDetails = datas;

											});
						}
					})

	var tripNo = $stateParams.tripNo;
	var lolId = $stateParams.lolId;
	var lodId = $stateParams.lodId;

	debugger
	$http
			.get(
					$stateParams.tenantid
							+ '/app/plantrip/getPlanTripListReallocate?tripNo='
							+ tripNo).success(function(datas) {
				debugger
				$scope.displayedCollection = datas;

			});

	$http
			.get(
					$stateParams.tenantid
							+ '/app/plantrip/getTripsNotAllocated?lolId='
							+ lolId + '&lodId=' + lodId)
			.success(function(data) {

				$scope.availableTrip = data;

			});

	$http.get(
			$stateParams.tenantid + '/app/plantrip/getAllTrip')
			.success(function(data) {

				$scope.allTrip = data;
				$scope.reallocate.tripNo = tripNo;

			});

	$http.get($stateParams.tenantid + '/app/distance/getPort')
			.success(function(datas) {
				$scope.portList = datas.portList;
				$scope.reallocate.fromLocation = lolId;
				$scope.reallocate.toLocation = lodId;

			});

	$scope.createNewTrip = function(lolId, lodId) {
		$state.go('app.operation.trip.addNewTripByReallocate',
				{
					lolId : lolId,
					lodId : lodId
				});
	}

	$scope.save = function(reallocate, bookingForm) {
		if (new validationService()
				.checkFormValidity($scope.bookingForm)) {
			if ($scope.reallocate.reason != 4) {
				$http
						.post(
								$stateParams.tenantid
										+ '/app/plantrip/reAllocateTrip',
								$scope.reallocate)
						.success(
								function(datas) {
									if (datas) {
										logger
												.logSuccess("ReAllocated Successfully!");
										$state
												.go(
														'app.operation.trip.list',
														{
															tenantid : $stateParams.tenantid
														});
									} else {
										logger
												.logError("Error in ReAllocate!");
									}

								})

			} else {

			}

		} else {
			toaster
					.pop(
							'error',
							"Please fill the required fields",
							logger
									.getErrorHtmlNew($scope.bookingForm.$validationSummary),
							555000, 'trustedHtml');
		}

	}

	$scope.tempTripList = [];
	$scope.booking = {};
	$scope.mloList = [];
	$scope.lolList = [];
	$scope.lodList = [];
	$scope.containerTypeList = [];
	$scope.containerSizeList = [];
	$scope.commodityList = [];
	$scope.packageTypeList = [];
	$scope.isEdit = false;
	$scope.bookingDtlList = [];
	$scope.tempType = '';

	$scope.tripList = {
		bookingDtlId : '',
		capacity : '',
		createdBy : '',
		createdOn : '',
		driverId : '',
		driverMappingId : '',
		tempTotalCapacity : '',
		driversName : '',
		eta : '',
		eta1 : '',
		etd : '',
		etd1 : '',
		fromLocation : '',
		modifiedBy : '',
		modifiedOn : '',
		planTripId : '',
		toLocation : '',
		totalCapacity : '',
		trailerId : '',
		trailerNo : '',
		tripNo : '',
		tripStartDate : '',
		tripAllocationId : '',
		truckId : '',
		truckRegNo : '',
		truckTrailerMappingId : '',
		bookingConCargoDtlList : []

	};

	$scope.bookingConCargoList = {
		bookingConCargoDtlId : '',
		bookingDtlId : '',
		containerNo : '',
		sealNo : '',
		grossWt : '',
		netWt : '',
		commodityId : '',
		packageType : '',
		noOfPackages : '',
		isHaz : '',
		unName : '',
		unClass : '',
		unAllocateStatus : true
	}

	$scope.validateNetWeight = function(tIndex, rIndex,
			newValue, grossWeight, bookingConDtl) {
		if (newValue != "" && newValue != null
				&& grossWeight != '' && grossWeight != null) {
			if (parseInt(newValue) > parseInt(grossWeight)) {
				logger
						.logError("Net Weight Should not be Greater than Gross Weight");
				bookingConDtl.netWt = '';

			}

		}

	}

	$scope.validateGorssWeight = function(tIndex, rIndex,
			newValue, netWeight, bookingConDtl) {
		if (newValue != "" && newValue != null
				&& netWeight != '' && netWeight != null) {
			if (parseInt(newValue) < parseInt(netWeight)) {
				logger
						.logError("Gross Weight Should not be lesser than Net Weight");
				bookingConDtl.grossWt = '';

			}

		}
	}

	$scope.contType = function(bookingDtl, index) {
		debugger
		if (bookingDtl.containerTypeId == 2) {
			for (var bookingCount = 0; bookingDtl.bookingConCargoDtlList.length > bookingCount; bookingCount++) {
				if (bookingDtl.conSizeId == 1) {
					bookingDtl.bookingConCargoDtlList[bookingCount].netWt = 2.2;
					bookingDtl.bookingConCargoDtlList[bookingCount].grossWt = 2.2;
					bookingDtl.emptyCont = true;
				} else {
					bookingDtl.bookingConCargoDtlList[bookingCount].netWt = 4.4;
					bookingDtl.bookingConCargoDtlList[bookingCount].grossWt = 4.4;
					bookingDtl.emptyCont = true;

				}

			}

		} else {
			for (var bookingCount = 0; bookingDtl.bookingConCargoDtlList.length > bookingCount; bookingCount++) {
				bookingDtl.bookingConCargoDtlList[bookingCount].netWt = '';
				bookingDtl.bookingConCargoDtlList[bookingCount].grossWt = '';
				bookingDtl.emptyCont = false;

			}

		}

	}

	/*
	 * $scope.$watchCollection('[ booking.lolId,booking.lodId]',
	 * function(newValue, oldValue) { if($scope.booking.lolId != "" &&
	 * $scope.booking.lolId != undefined && $scope.booking.lodId != "" &&
	 * $scope.booking.lodId != undefined){ $scope.booking.transportType='';
	 * $http.get($stateParams.tenantid+'/app/booking/getLocalOrTransit?fromLocation='+$scope.booking.lolId+'&toLocation='+$scope.booking.lodId).success(function(datas) {
	 * $scope.booking.transportType =datas.transportType;
	 * if($scope.booking.transportType == ''){
	 * $scope.booking.transportType=$scope.tempType; } if(datas.transportType ==
	 * 'L'){ $scope.transit=false; $scope.local=true; } else{
	 * $scope.local=false; $scope.transit=true; }
	 * 
	 * }); }
	 * 
	 * });
	 */
	$(".quoView")
			.find(".fa-minus")
			.click(
					function() {
						$scope.showQuotation = $scope.showQuotation ? false
								: true;
						$http
								.post(
										$stateParams.tenantid
												+ '/truckSchedule/updateValue')
								.success(function(data) {
									if (data.success = true) {
									}
								});
					});

	$(".quoView").find(".fa-expand").click(
			function() {

				if ($(".quoView").find('.fa-minus').is(
						':visible')) {
					$(".quoView").find(".fa-minus").css(
							"display", "none");
				} else {
					$(".quoView").find(".fa-minus").css(
							"display", "unset");
				}
				$http.post(
						$stateParams.tenantid
								+ '/truckSchedule/updateValue')
						.success(function(data) {
							if (data.success = true) {
							}
						});
			});

	$scope.quotationView = {
		quoNo : '',
		customer : '',
		quoType : '',
		lol : '',
		lod : '',
		valFrom : '',
		valTo : '',
		currency : '',
		quoDate : ''
	}
	$scope.showQuotation = false;
	$("#quoIconId").attr("disabled", true);
	$scope.showHideQuotation = function() {
		$scope.showQuotation = $scope.showQuotation ? false
				: true;

	}
	$scope
			.$watchCollection(
					'[ booking.lolId,booking.lodId,booking.bookingDate,booking.mloCode]',
					function(newValue, oldValue) {
						if ($scope.booking.lolId != ""
								&& $scope.booking.lolId != undefined
								&& $scope.booking.lodId != ""
								&& $scope.booking.lodId != undefined
								&& $scope.booking.bookingDate != ""
								&& $scope.booking.bookingDate != undefined) {
							$scope.booking.transportType = '';

							$http
									.get(
											$stateParams.tenantid
													+ '/app/booking/getQuotationAndTransport?fromLocation='
													+ $scope.booking.lolId
													+ '&toLocation='
													+ $scope.booking.lodId
													+ '&bookingDate='
													+ $scope.booking.bookingDate
													+ '&customerNo='
													+ $scope.booking.mloCode)
									.success(
											function(datas) {
												$scope.booking.transportType = datas.transportType;
												if (datas.bookingList.length > 0) {
													$scope.booking.quotationNo = datas.bookingList[0].quotationNo;

													$scope.quotationBean = datas.quotationBean[0];
													$scope.quotationportPair = datas.quotationportpair[0];
													$scope.quotationportPairWeight = datas.quotationportpairWeight;
													$scope.quotationportPairCharge = datas.quotationPortPairCharge;
													$scope.quotationList = datas.quotationList;
													if ($scope.quotationBean.quotation != ''
															&& $scope.quotationBean.quotation != undefined) {
														$scope.quotationView.customer = $scope.quotationBean.customer;
														$scope.quotationView.quoType = $scope.quotationBean.quotationType;
														$scope.quotationView.quoDate = $scope.quotationBean.dataOfIssues;
														$scope.showQuotation = true;
														$(
																"#quoIconId")
																.attr(
																		"disabled",
																		false);
													}

													$scope.quotationView.quoNo = $scope.quotationportPair.quotation;
													$scope.quotationView.lol = $scope.quotationportPair.pol;
													$scope.quotationView.lod = $scope.quotationportPair.pod;
													$scope.quotationView.valFrom = $scope.quotationportPair.validFrom;
													$scope.quotationView.valTo = $scope.quotationportPair.validTill;
													$scope.quotationView.currency = $scope.quotationportPair.currency;
												} else {
													$scope.booking.quotationNo = '';
												}

												if ($scope.booking.transportType == ''
														|| $scope.booking.transportType == null) {
													$scope.booking.transportType = angular
															.copy($scope.tempType);
												}
												if (datas.transportType == 'L') {
													$scope.transit = false;
													$scope.local = true;
												} else {
													$scope.local = false;
													$scope.transit = true;
												}

											});

						}
					});

	$scope.getOnloadList = function() {
		$http
				.post(
						$stateParams.tenantid
								+ '/app/booking/add')
				.success(
						function(data) {
							$scope.mloList = data.mloList;
							$scope.lolList = data.locationList;
							$scope.lodList = data.locationList;
							$scope.containerTypeList = data.containerTypeList;
							$scope.containerSizeList = data.containerSizeList;
							$scope.commodityList = data.commodityList;
							$scope.packageTypeList = data.packageTypeList;
							$scope.booking = data.booking;
							$scope.booking['transportType'] = 'L';
							$scope.booking['bookingDate'] = $scope.currentDate;
							$scope.bookingDtlList = [];
							$scope.addBookingDtl();
							$scope.quotationList = data.quotationList;
						});
	};

	$scope.SummaryList = [];
	$scope.editBooking = function(bookingId) {
		$http
				.post(
						$stateParams.tenantid
								+ '/app/booking/edit',
						bookingId)
				.success(
						function(data) {
							$scope.mloList = data.mloList;
							$scope.lolList = data.locationList;
							$scope.lodList = data.locationList;
							$scope.containerTypeList = data.containerTypeList;
							$scope.containerSizeList = data.containerSizeList;
							$scope.commodityList = data.commodityList;
							$scope.packageTypeList = data.packageTypeList;
							debugger
							$scope.booking = data.booking;
							$scope.tempType = data.booking.transportType;
							$scope.booking.lolId = $scope.booking.lolId
									+ '';
							$scope.booking.lodId = $scope.booking.lodId
									+ '';
							$scope.bookingDtlList = data.booking.bookingDtlList;
							$scope.tempbookingDtlList = angular
									.copy(data.booking.bookingDtlList);
							$scope.quotationList = data.quotationList;
							if ($scope.quotationList.length > 0) {
								$scope.showQuotation = true;
								$scope.booking.quotationNo = $scope.quotationList[0].text;
							}
						});

		$http
				.get(
						$stateParams.tenantid
								+ '/app/booking/getBookingListBybookingId?bookingId='
								+ parseInt(bookingId))
				.success(
						function(returnData) {
							debugger;
							$scope.SummaryList = returnData.bookingList;

						})
	};
	$scope.addBookingDtl = function(index) {
		var bookingDtl = {
			bookingDtlId : '',
			bookingId : '',
			containerTypeId : '1',
			conSizeId : '1',
			quantity : '',
			show : false,
			emptyCont : false
		}
		$scope.bookingTableList[index].bookingDtlList.push(bookingDtl);
	};
	
	var countt=0;
	$scope.bookingTableList=[];
	$scope.addBooking = function() {
		var booking = {
			bookingDate : '',
			mloCode : '',
			lolId : '',
			quotationNo : '',
			transportType : '',
			quotationNo : '',
			select : '',
			bookingDtlList : []
			
		}
		
		$scope.bookingTableList.push(booking);
		var bookingDtl = {
				bookingDtlId : '',
				bookingId : '',
				containerTypeId : '1',
				conSizeId : '1',
				quantity : '',
				show : false,
				emptyCont : false
			}
		$scope.bookingTableList[countt].bookingDtlList.push(bookingDtl);
		countt++;
		
	};
	
	
	var bookingId = $location.search().bookingId;
	if (bookingId == null || bookingId == undefined) {
		$scope.isEdit = false;
		$scope.getOnloadList();
	} else {
		$scope.isEdit = true;
		$scope.editBooking(bookingId);
	}
	$scope.reset = function() {
		$scope.deleteIds = [];
		if ($scope.isEdit == true) {
			$scope.editBooking(bookingId);
		} else {
			$scope.getOnloadList();
		}
	}

	$scope.CarEdit = false;

	$scope.unAllocatetruck = function(bookingConDtl) {
		console.log(bookingConDtl);
		$http
				.get(
						$stateParams.tenantid
								+ '/app/tripallocation/unAllocateTrip?bookingConCargoDtlId='
								+ bookingConDtl.bookingConCargoDtlId
								+ '&bookingDtlId='
								+ bookingConDtl.bookingDtlId)
				.success(
						function(data) {
							if (data == true) {
								logger
										.logSuccess("UnAllocatted SuccessFully!");
								$scope.editBooking(bookingId);
							} else {
								logger
										.logError("Error in UnAllocate!");
							}

						});

	}

	$scope.createTrip = function(bookingDate, lolId, lodId) {
		$scope.tempBookingDate = bookingDate;
		$scope.templolId = lolId;
		$scope.templodId = lodId;
		ngDialog.open({
			template : 'CreateTrip',
			scope : $scope,
			controller : $controller('NewTripCtrl', {
				$scope : $scope,
				data : $scope.tripList,
				$http : $http,
				ngDialog : ngDialog,
				logger : logger,
				$injector : $injector,
				sharedProperties : sharedProperties,
				toaster : toaster,
				$rootScope : $rootScope
			}),
			closeByEscape : false,
		})

	}

	$scope.allocatetruck = function(bookingDtl, booking,
			trIndex) {
		$scope.CarEdit = false;
		if (new validationService()
				.checkFormValidity($scope.bookingForm)) {
			$scope.allocateAllow = true;
			if ($scope.booking.lolId != $scope.booking.lodId) {
				if ($scope.bookingDtlList != null
						&& $scope.bookingDtlList.length > 0) {

					if ($scope.tempbookingDtlList[trIndex] != undefined) {
						if ($scope.tempbookingDtlList[trIndex].containerTypeId == bookingDtl.containerTypeId
								&& $scope.tempbookingDtlList[trIndex].conSizeId == bookingDtl.conSizeId
								&& $scope.tempbookingDtlList[trIndex].quantity == bookingDtl.quantity) {
							if ($scope.tempbookingDtlList[trIndex].bookingConCargoDtlList.length == bookingDtl.bookingConCargoDtlList.length) {
								for (var j = 0; j < $scope.tempbookingDtlList[trIndex].bookingConCargoDtlList.length; j++) {
									if ($scope.tempbookingDtlList[trIndex].bookingConCargoDtlList[j].packageType == null) {
										$scope.tempbookingDtlList[trIndex].bookingConCargoDtlList[j].packageType = 'null';
									}
									if ($scope.tempbookingDtlList[trIndex].bookingConCargoDtlList[j].commodityId == null) {
										$scope.tempbookingDtlList[trIndex].bookingConCargoDtlList[j].commodityId = 'null';
									}
									if ($scope.tempbookingDtlList[trIndex].bookingConCargoDtlList[j] != undefined) {
										if ($scope.tempbookingDtlList[trIndex].bookingConCargoDtlList[j].bookingConCargoDtlId == bookingDtl.bookingConCargoDtlList[j].bookingConCargoDtlId
												&& $scope.tempbookingDtlList[trIndex].bookingConCargoDtlList[j].bookingDtlId == bookingDtl.bookingConCargoDtlList[j].bookingDtlId
												&& $scope.tempbookingDtlList[trIndex].bookingConCargoDtlList[j].commodityId == bookingDtl.bookingConCargoDtlList[j].commodityId
												&& $scope.tempbookingDtlList[trIndex].bookingConCargoDtlList[j].containerNo == bookingDtl.bookingConCargoDtlList[j].containerNo
												&& $scope.tempbookingDtlList[trIndex].bookingConCargoDtlList[j].grossWt == bookingDtl.bookingConCargoDtlList[j].grossWt
												&& $scope.tempbookingDtlList[trIndex].bookingConCargoDtlList[j].isHaz == bookingDtl.bookingConCargoDtlList[j].isHaz
												&& $scope.tempbookingDtlList[trIndex].bookingConCargoDtlList[j].netWt == bookingDtl.bookingConCargoDtlList[j].netWt
												&& $scope.tempbookingDtlList[trIndex].bookingConCargoDtlList[j].noOfPackages == bookingDtl.bookingConCargoDtlList[j].noOfPackages
												&& $scope.tempbookingDtlList[trIndex].bookingConCargoDtlList[j].packageType == bookingDtl.bookingConCargoDtlList[j].packageType
												&& $scope.tempbookingDtlList[trIndex].bookingConCargoDtlList[j].sealNo == bookingDtl.bookingConCargoDtlList[j].sealNo
												&& $scope.tempbookingDtlList[trIndex].bookingConCargoDtlList[j].unClass == bookingDtl.bookingConCargoDtlList[j].unClass
												&& $scope.tempbookingDtlList[trIndex].bookingConCargoDtlList[j].unName == bookingDtl.bookingConCargoDtlList[j].unName) {

										} else {
											ngDialog
													.open({
														template : 'TripAllocationAlert',
														scope : $scope,
														controller : $controller(
																'TripAllocationAlertCtrl',
																{
																	$scope : $scope,
																	data : $scope.tripList,
																	$http : $http,
																	ngDialog : ngDialog,
																	logger : logger,
																	$injector : $injector,
																	sharedProperties : sharedProperties,
																	toaster : toaster,
																	$rootScope : $rootScope
																}),
														closeByEscape : false,
													})

											$scope.allocateAllow = false;
										}

									} else {
										ngDialog
												.open({
													template : 'TripAllocationAlert',
													scope : $scope,
													controller : $controller(
															'TripAllocationAlertCtrl',
															{
																$scope : $scope,
																data : $scope.tripList,
																$http : $http,
																ngDialog : ngDialog,
																logger : logger,
																$injector : $injector,
																sharedProperties : sharedProperties,
																toaster : toaster,
																$rootScope : $rootScope
															}),
													closeByEscape : false,
												})
										$scope.allocateAllow = false;
									}
								}

							}
						} else {
							ngDialog
									.open({
										template : 'TripAllocationAlert',
										scope : $scope,
										controller : $controller(
												'TripAllocationAlertCtrl',
												{
													$scope : $scope,
													data : $scope.tripList,
													$http : $http,
													ngDialog : ngDialog,
													logger : logger,
													$injector : $injector,
													sharedProperties : sharedProperties,
													toaster : toaster,
													$rootScope : $rootScope
												}),
										closeByEscape : false,
									})
							$scope.allocateAllow = false;
						}
					} else {
						ngDialog
								.open({
									template : 'TripAllocationAlert',
									scope : $scope,
									controller : $controller(
											'TripAllocationAlertCtrl',
											{
												$scope : $scope,
												data : $scope.tripList,
												$http : $http,
												ngDialog : ngDialog,
												logger : logger,
												$injector : $injector,
												sharedProperties : sharedProperties,
												toaster : toaster,
												$rootScope : $rootScope
											}),
									closeByEscape : false,

								})
						$scope.allocateAllow = false;
					}

				} else {
					logger
							.logError('Please provide Container detail')
					$scope.allocateAllow = false;
				}
			} else {
				logger
						.logError('LOL and LOD should not be same');
				$scope.allocateAllow = false;
			}
		} else {
			toaster
					.pop(
							'error',
							"Please fill the required fields",
							logger
									.getErrorHtmlNew($scope.bookingForm.$validationSummary),
							5500, 'trustedHtml');
			$scope.allocateAllow = false;
		}

		if ($scope.allocateAllow) {
			var counts = 0;
			debugger
			$http
					.get(
							$stateParams.tenantid
									+ '/app/booking/getTrips?fromLocation='
									+ booking.lolId
									+ '&toLocation='
									+ booking.lodId
									+ '&bookingDate='
									+ booking.bookingDate
									+ '&bookingDtlId='
									+ bookingDtl.bookingDtlId)
					.success(
							function(data) {
								$scope.success = data.success;
								$scope.tripList = data.planTripBeanList;
								$scope.tempTripList = data;
								for (var b = 0; b < $scope.tripList.length; b++) {
									$scope.tripList[b]['bookingDtlId'] = bookingDtl.bookingDtlId;
									if ($scope.tripList[b].bookingConCargoDtlList == null
											|| $scope.tripList[b].bookingConCargoDtlList == undefined) {
										$scope.tripList[b].bookingConCargoDtlList = [];
									}
									$scope.tripList[b].bookingConCargoDtlList = angular
											.copy(bookingDtl.bookingConCargoDtlList);
								}
								console.log($scope.tripList);
								$scope.count = trIndex;
								if ($scope.success) {
									counts++;
								} else {
									debugger
									logger
											.logError('Trip Started,Not Allowed to Edit!');
								}

								if (counts > 0) {

									$http
											.get(
													$stateParams.tenantid
															+ '/app/tripallocation/edit?bookingDtlId='
															+ bookingDtl.bookingDtlId)
											.success(
													function(
															data) {
														for (var i = 0; i < $scope.tripList.length; i++) {
															for (var j = 0; j < data.tripAlloBeanList.length; j++) {
																$scope.CarEdit = true;
																if (data.tripAlloBeanList[j].planTripId == $scope.tripList[i].planTripId) {
																	$scope.tripList[i].select = true;
																	$scope.tripList[i].tripAllocationId = data.tripAlloBeanList[j].tripAllocationId;
																	for (var k = 0; k < $scope.tripList[i].bookingConCargoDtlList.length; k++) {
																		for (var l = 0; l < data.tripAlloBeanList[j].bookingConCargoDtlList.length; l++) {
																			debugger
																			if ($scope.tripList[i].bookingConCargoDtlList[k].bookingConCargoDtlId == data.tripAlloBeanList[j].bookingConCargoDtlList[l].bookingConCargoDtlId) {
																				$scope.tripList[i].bookingConCargoDtlList[k].select = true;

																			}
																		}
																	}

																}
															}

														}

														console
																.log($scope.tripList);
														ngDialog
																.open({
																	template : 'exportexcelalert',
																	scope : $scope,
																	controller : $controller(
																			'bookingAddPopupCtrl',
																			{
																				$scope : $scope,
																				data : $scope.tripList,
																				$http : $http,
																				ngDialog : ngDialog,
																				logger : logger,
																				$injector : $injector,
																				sharedProperties : sharedProperties,
																				toaster : toaster,
																				$rootScope : $rootScope
																			}),
																	closeByEscape : false,
																})

													});

								}

							});

		}
	};

	$scope.no = function() {
		ngDialog.close();
		$scope.cancel();
	}

	$scope.saveBookingasDraft = function(bookingForm,
			bookingStatus) {

		if (new validationService()
				.checkFormValidity(bookingForm)) {
			if ($scope.booking.lolId != $scope.booking.lodId) {
				if ($scope.bookingDtlList != null
						&& $scope.bookingDtlList.length > 0) {
					$scope.booking['bookingDtlList'] = $scope.bookingDtlList;

					var rb = {
						booking : $scope.booking
					}
					console.log(rb);
					$scope.booking['bookingStatus'] = 'D';
					$http
							.post(
									$stateParams.tenantid
											+ '/app/booking/save',
									rb)
							.success(
									function(data) {
										if (data.success == true) {
											// ngDialog.openConfirm().then(function()
											// {

											logger
													.logSuccess('Booking Saved Successfully as Draft.')
											// })
											$scope.cancel();
										} else {
											if (data.message != null
													&& data.message != '') {
												logger
														.logError(data.message)
											} else {
												logger
														.logError("Can't save. Please try again");
											}
										}
									});

				} else {
					logger
							.logError('Please provide Container detail');
				}
			} else {
				logger
						.logError('LOL and LOD should not be same');
			}
		} else {
			toaster
					.pop(
							'error',
							"Please fill the required fields",
							logger
									.getErrorHtmlNew($scope.bookingForm.$validationSummary),
							5500, 'trustedHtml');
		}

	}

	$scope.saveBooking = function(bookingForm, bookingStatus) {

		if (new validationService()
				.checkFormValidity(bookingForm)) {
			if ($scope.booking.transportType != ''
					&& $scope.booking.transportType != null) {
				if ($scope.booking.lolId != $scope.booking.lodId) {
					if ($scope.bookingDtlList != null
							&& $scope.bookingDtlList.length > 0) {
						$scope.booking['bookingDtlList'] = $scope.bookingDtlList;
						var rb = {
							booking : $scope.booking
						}
						console.log(rb);
						if ($scope.booking.quotationNo == ''
								|| $scope.booking.quotationNo == null) {
							$scope.booking['bookingStatus'] = 'D';
						} else {
							$scope.booking['bookingStatus'] = 'A';
						}

						$http
								.post(
										$stateParams.tenantid
												+ '/app/booking/save',
										rb)
								.success(
										function(data) {
											if (data.success == true) {
												if ($scope.booking.quotationNo == ''
														|| $scope.booking.quotationNo == null) {
													// logger
													// .logSuccess('Booking
													// Saved
													// Successfully.')
													// $scope.cancel();
													ngDialog
															.openConfirm(
																	{
																		template : 'quotationAlert',
																		scope : $scope,
																		closeByEscape : false,
																	})
															.then(
																	function() {
																		//														
																		// alert(123);
																		$state
																				.go(
																						'app.sales.quotation.addByBooking',
																						{
																							bookingDate : $scope.booking.bookingDate,
																							mloCode : $scope.booking.mloCode,
																							lolId : data.pol,
																							lodId : data.pod,
																							bookingId : data.bookingId,
																						});

																	});
												} else {
													logger
															.logSuccess('Booking Saved Successfully.')
													$scope
															.cancel();
												}
											} else {
												if (data.message != null
														&& data.message != '') {
													logger
															.logError(data.message)
												} else {
													logger
															.logError("Can't save. Please try again");
												}
											}
										});
					} else {
						logger
								.logError('Please provide Container detail');
					}
				} else {
					logger
							.logError('LOL and LOD should not be same');
				}
			} else {
				logger
						.logError('Transport type Should Not be Empty!');
			}
		} else {
			toaster
					.pop(
							'error',
							"Please fill the required fields",
							logger
									.getErrorHtmlNew($scope.bookingForm.$validationSummary),
							5500, 'trustedHtml');
		}

	}
	$scope.cancel = function() {
		$state.go('app.salesmarketing.booking.list', {
			tenantid : $stateParams.tenantid
		});
	}

	$scope.updateBookingasDraft = function(bookingForm) {
		if (new validationService()
				.checkFormValidity(bookingForm)) {
			if ($scope.booking.transportType != ''
					&& $scope.booking.transportType != null) {
				if ($scope.booking.lolId != $scope.booking.lodId) {
					if ($scope.bookingDtlList != null
							&& $scope.bookingDtlList.length > 0) {
						$scope.booking['bookingDtlList'] = $scope.bookingDtlList;
						var rb = {
							booking : $scope.booking,
							deleteIds : $scope.deleteIds + ''
						}
						$scope.booking['bookingStatus'] = 'A';
						$http
								.post(
										$stateParams.tenantid
												+ '/app/booking/update',
										rb)
								.success(
										function(data) {
											if (data.success == true) {
												logger
														.logSuccess('Booking Updated Successfully as Draft.')
												$scope.cancel();
											} else {
												if (data.message != null
														&& data.message != '') {
													logger
															.logError(data.message)
												} else {
													logger
															.logError("Can't update. Please try again");
												}
											}
										});
					} else {
						logger
								.logError('Please provide Container detail')
					}
				} else {
					logger
							.logError('LOL and LOD should not be same');
				}
			} else {
				logger
						.logError('Transport Type Should Not Be Empty!');
			}

		} else {
			toaster
					.pop(
							'error',
							"Please fill the required fields",
							logger
									.getErrorHtmlNew($scope.bookingForm.$validationSummary),
							5500, 'trustedHtml');
		}
	}

	$scope.updateBooking = function(bookingForm) {

		if (new validationService()
				.checkFormValidity(bookingForm)) {
			if ($scope.booking.transportType != ''
					&& $scope.booking.transportType != null) {
				if ($scope.booking.lolId != $scope.booking.lodId) {
					if ($scope.bookingDtlList != null
							&& $scope.bookingDtlList.length > 0) {
						$scope.booking['bookingDtlList'] = $scope.bookingDtlList;
						var rb = {
							booking : $scope.booking,
							deleteIds : $scope.deleteIds + ''
						}
						if ($scope.booking.quotationNo == ''
								|| $scope.booking.quotationNo == null) {
							$scope.booking['bookingStatus'] = 'D';
						} else {
							$scope.booking['bookingStatus'] = 'A';
						}
						$http
								.post(
										$stateParams.tenantid
												+ '/app/booking/update',
										rb)
								.success(
										function(data) {
											if (data.success == true) {
												if ($scope.booking.quotationNo == ''
														|| $scope.booking.quotationNo == null) {
													// logger
													// .logSuccess('Booking
													// Saved
													// Successfully.')
													// $scope.cancel();
													ngDialog
															.openConfirm(
																	{
																		template : 'quotationAlert',
																		scope : $scope,
																		closeByEscape : false,
																	})
															.then(
																	function() {
																		//															
																		// alert(123);
																		$state
																				.go(
																						'app.sales.quotation.addByBooking',
																						{
																							bookingDate : $scope.booking.bookingDate,
																							mloCode : $scope.booking.mloCode,
																							lolId : data.pol,
																							lodId : data.pod,
																							bookingId : data.bookingId,
																						});

																	});
												} else {
													logger
															.logSuccess('Booking Saved Successfully.')
													$scope
															.cancel();
												}
											} else {
												if (data.message != null
														&& data.message != '') {
													logger
															.logError(data.message)
												} else {
													logger
															.logError("Can't update. Please try again");
												}
											}
										});
					} else {
						logger
								.logError('Please provide Container detail')
					}
				} else {
					logger
							.logError('LOL and LOD should not be same');
				}
			} else {
				logger
						.logError('Transport Type Should Not be Empty!');
			}
		} else {
			toaster
					.pop(
							'error',
							"Please fill the required fields",
							logger
									.getErrorHtmlNew($scope.bookingForm.$validationSummary),
							5500, 'trustedHtml');
		}
	}
	$scope.deleteIds = [];
	
	$scope.deleteBookingDtl = function(index1) {
		// $scope.bookingTableList[index].bookingDtlList.bookingDtlList.push(bookingDtl);
		var len = $scope.bookingTableList[index1].bookingDtlList.length;
		for (var index = len - 1; index < len; index--) {
			if ($scope.bookingTableList[index1].bookingDtlList[index].select == true) {
				if ($scope.bookingTableList[index1].bookingDtlList[index].bookingDtlId != null
						&& $scope.bookingTableList[index1].bookingDtlList[index].bookingDtlId > 0) {
					$scope.deleteIds
							.push($scope.bookingTableList[index1].bookingDtlList[index].bookingDtlId);
				}
				$scope.bookingTableList[index1].bookingDtlList.splice(index, 1);
			}
		}
	}
	
	$scope.deleteBooking = function(trIndex) {
		var len = $scope.bookingTableList.length;
		for (var index = len - 1; index < len; index--) {
			if ($scope.bookingTableList[index].select == true) {
				if ($scope.bookingTableList[index].bookingId != null
						&& $scope.bookingTableList[index].bookingId > 0) {
				
				}
				$scope.bookingTableList.splice(index, 1);
			}
		}
	}
	$scope.hideShow = function(bookingDtl) {
		if (bookingDtl.quantity == null
				|| bookingDtl.quantity == ''
				|| bookingDtl.quantity == 0) {
			logger
					.logError("Quantity Field is required. Must be a positive number.");
		} else {
			if (bookingDtl.show == true) {
				bookingDtl.show = false;
			} else {
				bookingDtl.show = true;
			}
		}
	}

	$scope.addContCargoDtl = function(bookingDtl) {
		if (bookingDtl.quantity == null
				|| bookingDtl.quantity == ''
				|| bookingDtl.quantity == 0) {
			logger
					.logError("Quantity Field is required. Must be a positive number.");
		} else {
			if (bookingDtl.bookingConCargoDtlList == null) {
				bookingDtl.bookingConCargoDtlList = [];
			}
			if (bookingDtl.quantity > bookingDtl.bookingConCargoDtlList.length) {
				var diff = bookingDtl.quantity
						- bookingDtl.bookingConCargoDtlList.length;
				for (index = 0; index < diff; index++) {
					$scope.addBookingConDtl(bookingDtl);
				}
			} else {
				var diff = bookingDtl.bookingConCargoDtlList.length
						- bookingDtl.quantity;
				for (index = 0; index < diff; index++) {
					bookingDtl.bookingConCargoDtlList
							.splice(
									bookingDtl.bookingConCargoDtlList.length - 1,
									1);
				}
			}
		}
	};
	$scope.tCount = 0;

	$scope.checked = function() {

	}
	$scope.addBookingConDtl = function(bookingDtl) {
		var bookingConDtl = {
			bookingConCargoDtlId : '',
			bookingDtlId : '',
			containerNo : '',
			sealNo : '',
			grossWt : '',
			netWt : '',
			commodityId : '',
			packageType : '',
			noOfPackages : '',
			isHaz : '',
			unName : '',
			unClass : '',
			unAllocateStatus : true
		}
		bookingDtl.bookingConCargoDtlList.push(bookingConDtl);
	};
	
});

//add
app.controller('tripAddLoadingCtrl', function($scope, $rootScope,$timeout, $injector, $http, $location, logger, utilsService, $state, sharedProperties, $window,toaster,validationService,$stateParams) 
		{
	$scope.organisation = {};
	$scope.rowCollection = [];
	$scope.displayedCollection = [];
	$scope.tripReallocate=false;
	
	var lolId = $stateParams.lolId;
	var lodId = $stateParams.lodId;
	
	 var currentDate = new Date();
     currentDate = ('0' + currentDate.getDate()).slice(-2)+"/"+('0' + (Number(currentDate.getMonth())+1)).slice(-2)+"/"+currentDate.getFullYear();
   
  
    $scope.fuelmodel ={
    		orderNo : '',
    		orginalvoucherNo:'',
    		rateUnit :'',
    		totalValue:'',
    		entryNo : '',
    		date : '',
    		toName : '',
    		fuelType : '',
    		liters : '',
    		truckNo : '',
    		consignmentNo : '',
    		destination : '',
    		driversSignature : '',
    		driversName : '',
    		signature : '',
    		authorisedBy : '',
    		tripType : '',
    		locationName : '',
    		statusId : '',
    		fillingLocation : '',
    		truckId : '',
    		fromLocation : '',
    		toLocation : '',
    		vendorCode : '',
    		vendorName : '', 
    };
    
    $scope.getFuelAmount= function(){
    	if($scope.fuelmodel.liters!= null && $scope.fuelmodel.rateUnit != null &&
    			$scope.fuelmodel.liters!= '' && $scope.fuelmodel.rateUnit != '' 	){
    		$scope.fuelmodel.totalValue=$scope.fuelmodel.liters*$scope.fuelmodel.rateUnit;
    	}
    	else{
    		$scope.fuelmodel.totalValue=0;
    	}
    }
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth() + 1; // January is 0!
    var yyyy = today.getFullYear();

    if (dd < 10) {
        dd = '0' + dd;
    }
    if (mm < 10) {
        mm = '0' + mm;
    }
    $('#dependentDob').datetimepicker({
        format : 'DD/MM/YYYY'
    })
    var today = dd + '/' + mm + '/' + yyyy;
    $scope.date = today;
    
  // fueltypeList
	
 
    
    $http.get($stateParams.tenantid + '/truck/fuelTypeList').success(
			function(data) {
				if (data.success == true) {
					$scope.fuelList = data.fuelTypeList;
				}
			});
    
    
    // autogenerate
    $http.get($stateParams.tenantid+'/fuelvoucher/voucher').success(function(datas) {    	
        $scope.fuelmodel.entryNo = datas.voucher.entryNo;      
    }).error(function(data) {
    	logger.logError("Unable to fetch");
    });

    
    $scope.test1=function(){
        $http.get($stateParams.tenantid+'/fuelvoucher/supplier').success(function(datas) {
        	
            $scope.localtionList = datas.selectivitybean1;  
        }).error(function(data) {
        	logger.logError("Unable to fetch");
        });
        
     
    }
    $scope.test1();  
   
    $scope.changetoUsd = function(){
		 if( $scope.trip.roadchargesksh != null &&  $scope.trip.roadchargesksh != '' && $scope.trip.roadchargesksh != '0'){
				$scope.trip.roadchargesusd = parseFloat($scope.trip.roadchargesksh)/100;
			}
	 }

	 $scope.changetoKsh = function(){
		if( $scope.trip.roadchargesusd != null &&  $scope.trip.roadchargesusd != '' && $scope.trip.roadchargesusd != '0'){
			$scope.trip.roadchargesksh = parseFloat($scope.trip.roadchargesusd)*100;
		}
	 }
   
    // cancel
    $scope.cancel = function(){
        $state.go("app.operation.fuelvoucherentry",{tenantid:$stateParams.tenantid});
    };
    
    // save and update
    $scope.validate = function(fuelvoucherentryForm) {
                $scope.save($scope.fuelmodel,fuelvoucherentryForm);
             
    };
    
      
    
    
    // save
   // $scope.save = function(fuelmodel,fuelvoucherentryForm) {};
    
    // update
     
    // edit
    
    
    // hot-code area
    $scope.TruckList=[];
    $scope.$watch('fuelmodel.tripType', function(newValue, oldValue) {
        
     });

    
    
	$scope.changeTrailerMapping = function(editid){    
		if($scope.trip.truckTrailerMappingId != '' && $scope.trip.truckTrailerMappingId != null){
			$location.url($stateParams.tenantid+'/trucktrailer/edit?rowid='+editid);   
		}
		else{
			  logger.logError("Please Select Trailer!");
		}
        
		
	}
	
	var value = $stateParams.value;
	 
	
	$scope.createTrailerMapLink=false;
	$scope.createTrailShow=false;
	
	$scope.createTrailerMapping=function(){
		$rootScope.createTrailShow=true;
		$('#blkCnt').block({ message: null });
		$('#tripHisId').block({ message: null });
		$rootScope.trkID=$scope.trip.truckId;
		$rootScope.trkTrailID=$scope.trip.trailerId;
		$rootScope.tripStDt=$scope.trip.tripStartDate;
		if($rootScope.trkTrailID !='' && $rootScope.trkTrailID != undefined){
			$rootScope.truckTrailEdit=true;
		}else{
			$rootScope.truckTrailEdit=false;
		}
		
		$rootScope.$emit("openNewTrailerDiv", {});
		
	}
	 $rootScope.$on("changeTrailerVal", function() {
		 var sid = $rootScope.newTrailID
		 var stxt=$rootScope.newTrailTxt;
		 $scope.trailerList = [{id:sid,text:stxt}];
		 $http.get($stateParams.tenantid+'/app/plantrip/getTruckTrailMapId?truckCode='+$scope.trip.truckId+'&tripStartDate='+$scope.trip.tripStartDate+'&trailerId='+sid).success(function(datas) {
             $scope.trip.truckTrailerMappingId=datas.mappingId;
             if($scope.trip.truckTrailerMappingId !='' && $scope.trip.truckTrailerMappingId ){
            	 $scope.trip.trailerId=sid;	 
             }
             
             console.log(datas);
             }).error(function(datas) {
         });   
		 
		
	})


	 
	$scope.trip={
			truckId: '',
			tripNo : '',
			trailerId: '',
			fromLocation : '',
			toLocation : '',
			eta : '',
			etd : '',
			truckRegNo : '',
			trailerNo : '',
			truckTrailerMappingId : '',
            tripStartDate	: '',
            driverId : [],
            driverMappingId : '',
            refId : '',
            tripCompletedDate	: '' ,
            weight :'',
            	rate :'',
            	eirNo:'',
            	sealNo:'',
            	bundles:'',
            	fuel:'',
            	dn:'',
            	renNo:'',
            	mileage:'',
            	portcharges:'',
            	roadchargesusd:'',
            	roadchargesksh:'',
            	mileage:'',
            	cleaningfee:'',
            	incomeksh:'',
            	incomeusd:'',
            	others: 0, 

            	
            		rateusd:''
	}
	
	$scope.trip1={		
			tripNo : '',			
			fromLocation : '',
			toLocation : '',
			eta : '',
			etd : '',
			truckRegNo : '',
			trailerNo : '',
			driversName :''


			
	}
	$scope.transportType='';
	
	
	if(lolId != '' && lolId != null && lodId != '' && lodId != null){
		$scope.trip.fromLocation=lolId;
		$scope.trip.toLocation=lodId;
		$scope.tripReallocate=true;
	}
	
	$scope.$watchCollection('[ trip.fromLocation,trip.toLocation]', function(newValue, oldValue) {
		if($scope.trip.fromLocation != "" && $scope.trip.fromLocation != undefined &&
				$scope.trip.toLocation != "" && $scope.trip.toLocation != undefined){
	        $http.get($stateParams.tenantid+'/app/booking/getLocalOrTransit?fromLocation='+$scope.trip.fromLocation+'&toLocation='+$scope.trip.toLocation).success(function(datas) {
	             $scope.transportType =datas.transportType;
	          
	        });
			
		}
		
	});
	
  
	 // Truck Details
    $scope.trip1=[];
    $scope.$watch('trip.truckId', function(newValue, oldValue) {
        
        if (newValue != '' && newValue != undefined) {      
        	
            $http.get($stateParams.tenantid+'/app/plantrip/truckid?truck_id='+newValue).success(function(datas) {
            	console.log(datas);
            	
            		$scope.trip1 = datas;
            	
            	
            	

            }).error(function(data) {
            	logger.logError("Unable to fetch");
            });    

        }
    });
	
	$scope.save= function(trip,TripForm){
		if (new validationService().checkFormValidity($scope.TripForm)) {
			if($scope.trip.driverId.length > 0 ){
				if($scope.trip.others == '' || $scope.trip.others == 'NaN'){
					$scope.trip.others = 0;
				}
		$http.post($stateParams.tenantid+'/app/plantrip/add',
				$scope.trip).success(function(datas) {
				 	if(datas.success){
		                logger.logSuccess("Saved Successfully!");
		                 $scope.fuelmodel.truckId=$scope.trip.truckId;
		                 $scope.fuelmodel.fromLocation=$scope.trip.fromLocation;
		                 $scope.fuelmodel.toLocation=$scope.trip.toLocation;
		              	$scope.fuelmodel.statusId = "false";
		                 $scope.fuelmodel.tripType=datas.planTripId;
		           	 $http.post($stateParams.tenantid+'/fuelvoucher/save', $scope.fuelmodel).success(function(result) {   	
		           	
		                             
		                });     
		           
		                if(value == 'DailyLoadingEntry'){
		                	 $state.go('app.operation.loadingentry.list');
		                }else{
		                	 $state.go('app.operation.trip.list',{tenantid:$stateParams.tenantid});
		                }
		               
// }
// else if(!datas.success && datas.message != ''){
// logger.logError(datas.message);
// }
// else if(!datas.success && datas.message == ''){
// logger.logError("Error in save!");
 		}
				 	else{
				 		logger
						.logError(datas.message);
				 	}
		})
			}
			else{
				logger
				.logError("Please Select Driver!");
			}
		}
	    else{
            toaster.pop('error', "Please fill the required fields", 
                    logger.getErrorHtmlNew($scope.TripForm.$validationSummary), 555000, 'trustedHtml');
        	if($scope.trip.driverId.length == 0 ){
				logger
				.logError("Please Select Driver!");
			}
                       }
		
	}
	

    $scope.getDropdownvalue = function() { 
        $http.get($stateParams.tenantid+'/app/distance/getPort').success(function(datas) {
             $scope.portList =datas.portList;
             console.log("HI");
             console.log(datas.portList);
           
          
        });
        
        $http.get($stateParams.tenantid+'/truckdrivermapping/trucklist').success(function(datas) {
            $scope.truckList =datas.truckList;
            console.log(datas.truckList);
         
       });
        
        
    }
	   $scope.trailerList = [];
	  
		
	    $("#driverListSelect").multiselect({
	        maxHeight: 200,   
	        includeSelectAllOption: true,
	        disableIfEmpty: true,
	        enableCaseInsensitiveFiltering: true,
	        onDropdownHide: function (event) {
	            
	        }
	      });
	    $(".multiselect").addClass("width_100 input-sm line-height-5");
	    
	   $scope.getMappingId = function(){
		   if($scope.trip.driverId != '' && $scope.trip.driverId != undefined
			        && $scope.trip.truckId != '' && $scope.trip.truckId != undefined
			        && $scope.trip.tripStartDate != '' && $scope.trip.tripStartDate != undefined){

			                $http.get($stateParams.tenantid+'/app/plantrip/getMappingIdbyTruckDriver?truckId='+parseInt($scope.trip.truckId)+'&driverId='+$scope.trip.driverId+'&tripDate='+$scope.trip.tripStartDate).success(function(datas) {
			                    $scope.trip.driverMappingId=datas.driverMappingId;
			                   
			                    
			                    console.log(datas);
			                    }).error(function(datas) {
			                });   
			        }
	   }
	    
	  
		          
	   var swapToDateTmp=moment(currentDate, "DD/MM/YYYY").add(7, 'days').format("DD/MM/YYYY");
		  console.log('Date is'+swapToDateTmp);
		  
	   
	   $scope.$watchCollection('[trip.truckId,trip.tripStartDate]', function(newValue, oldValue) {
		   debugger
	        if (newValue != '' && newValue != undefined) {
	        	var frmDate = $scope.trip.tripStartDate;
	             var toDate = swapToDateTmp;
	             frmDate = frmDate.split("/");
	             frmDate = new Date(frmDate[2], frmDate[1]-1, frmDate[0]);
	             toDate = toDate.split("/");
	             toDate = new Date(toDate[2], toDate[1]-1, toDate[0]);
	             
	             if(frmDate>toDate){
	            	 logger.logError("Booking date should not be greater than 7 days from today!");
		        	 $scope.trip.tripStartDate='';
		        	 $scope.trip.tripStartDate=currentDate;
	             }
	        else{
		           if($scope.trip.tripStartDate != '' && $scope.trip.tripStartDate != undefined
		        && $scope.trip.truckId != '' && $scope.trip.truckId != undefined){
		        	   $scope.createTrailerMapLink=true;
		                $http.get($stateParams.tenantid+'/app/plantrip/getTrailerByTruck?truckCode='+$scope.trip.truckId+'&tripStartDate='+$scope.trip.tripStartDate).success(function(datas) {
		                    $scope.trailerList = datas.list;
		                    $scope.trip.truckTrailerMappingId=datas.mappingId;
		                    if(datas.trailerId != null){
			                    $scope.trip.trailerId=datas.trailerId.toString();
			                    }
			                    else{
			                    	 $scope.trip.trailerId='';
			                    }
		                   
		                    
		                    console.log(datas);
		                    }).error(function(datas) {
		                });   
		                

		                $http.get($stateParams.tenantid+'/app/plantrip/getDriverByTruck?truckId='+$scope.trip.truckId+'&tripDate='+$scope.trip.tripStartDate).success(function(datas) {
		                	  $scope.trip.driverId=[];
		                	 $scope.driverList = datas.list;
		                 // $scope.trip.driverId=datas.list[0].id;
		                    console.log(datas);
		                    for(var i=0;i < $scope.driverList.length;i++){
		                    	$scope.trip.driverId.push($scope.driverList[i].id);
		                    }
		                    $scope.getMappingId();
		                    
		                    $timeout(function() {
		                    	$("#driverListSelect").multiselect('rebuild');
		                    	 $('#driverListSelect').multiselect({
		                    	        includeSelectAllOption: true
		                    	    });

		                    	    $("#driverListSelect").multiselect('selectAll', false);
		                    	    $("#driverListSelect").multiselect('updateButtonText');
		                    	    
				             /*
								 * $('#driverListSelect').multiselect('deselectAll',
								 * false);
								 * $('#driverListSelect').multiselect('updateButtonText');
								 * $("#driverListSelect").multiselect('rebuild');
								 */
				            
				            }, 2, false);
				            $("#multiselect-button").addClass("width_100 input-sm line-height-5");
						
		                    
		                    }).error(function(datas) {
		                }); 
		                
		        }
		          
		        
	        }
	        }
	    });
	    
	   
	   
	   $scope.$watchCollection('[trip.truckId,trip.driverId]', function(newValue, oldValue) {
		   debugger
	        if (newValue != '' && newValue != undefined) {
	           if($scope.trip.driverId != '' && $scope.trip.driverId != undefined
	        && $scope.trip.truckId != '' && $scope.trip.truckId != undefined){

	                $http.get($stateParams.tenantid+'/app/plantrip/getMappingIdbyTruckDriver?truckId='+parseInt($scope.trip.truckId)+'&driverId='+$scope.trip.driverId+'&tripDate='+$scope.trip.tripStartDate).success(function(datas) {
	                    $scope.trip.driverMappingId=datas.driverMappingId;
	                    console.log(datas);
	                    }).error(function(datas) {
	                });   
	        }
	          
	        }
	    });
	    
	   
	    
    
    
    
    $scope.$watch('trip.trailerId', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
           if($scope.trip.truckId != '' && $scope.trip.truckId != undefined &&
        	 $scope.trip.truckTrailerMappingId != '' && $scope.trip.truckTrailerMappingId != undefined){

                $http.get($stateParams.tenantid+'/app/plantrip/autoGenTripNo?truckId='+$scope.trip.truckId+'&mappingId='+$scope.trip.truckTrailerMappingId+ '&tripStartDate='
						+ $scope.trip.tripStartDate).success(function(datas) {
                    $scope.trip.tripNo = datas.autoGenTripNo;
                    
                    
                    console.log(datas);
                    }).error(function(datas) {
                });               
        }
           else
        	   {
        	   logger.logError("Please Select Start Trip Date!");
        	   }
        }
        else{
       	 $scope.trip.tripNo = '';
       }
    });
    
    
    
    
    
    $scope.cancel=function(){
    	$state.go("app.operation.trip.list");
    }
    
    $scope.reset=function(){
    	$state.reload();
    }
  
    $scope.getDropdownvalue();
	
	 $('#fromDate').datetimepicker({
	        format : 'DD/MM/YYYY HH:MM'
	    })
	    
	     $('#toDate').datetimepicker({
	        format : 'DD/MM/YYYY  HH:MM'
	    })
	    
	    	     $('#tripStartDate').datetimepicker({
	        format : 'DD/MM/YYYY '
	    })
	    
	    
// $scope.$watch('trip.eta', function(newValue, oldValue) {
// start_date, period, number
// var start_date=$scope.trip.eta;
// var period='Hours';
// var number=$scope.timeDiff;
// var dailyDrivingPeriod=9;
// if (newValue != '' && newValue != undefined) {
// // For Change MM-DD-YYYY Format
// var startDate = '';
// if (typeof start_date == 'string') {
// var dateTime = start_date.split(' ');
// var sDate = dateTime[0].split('/');
// startDate = sDate[1] + '/' + sDate[0] + '/' + sDate[2] + ' ' + dateTime[1];
// } else {
// startDate = start_date;
// }
// var d1=moment(startDate).add(period, number)
// $scope.trip.etd= d1.format("dd/mm/yyyy HH24:MM");
// };
//
// });
	    
	    
});

app.controller('tripAddCtrl', function($scope, $rootScope,$timeout, $injector, $http, $location, logger, utilsService, $state, sharedProperties, $window,toaster,validationService,$stateParams) 
		{
	$scope.organisation = {};
	$scope.rowCollection = [];
	$scope.displayedCollection = [];
	$scope.tripReallocate=false;
	
	var lolId = $stateParams.lolId;
	var lodId = $stateParams.lodId;
	
	$scope.changeTrailerMapping = function(editid){    
		if($scope.trip.truckTrailerMappingId != '' && $scope.trip.truckTrailerMappingId != null){
			$location.url($stateParams.tenantid+'/trucktrailer/edit?rowid='+editid);   
		}
		else{
			  logger.logError("Please Select Trailer!");
		}
        
		
	}
	
	var value = $stateParams.value;
	 
	
	$scope.createTrailerMapLink=false;
	$scope.createTrailShow=false;
	
	$scope.createTrailerMapping=function(){
		$rootScope.createTrailShow=true;
		$('#blkCnt').block({ message: null });
		$('#tripHisId').block({ message: null });
		$rootScope.trkID=$scope.trip.truckId;
		$rootScope.trkTrailID=$scope.trip.trailerId;
		$rootScope.tripStDt=$scope.trip.tripStartDate;
		if($rootScope.trkTrailID !='' && $rootScope.trkTrailID != undefined){
			$rootScope.truckTrailEdit=true;
		}else{
			$rootScope.truckTrailEdit=false;
		}
		
		$rootScope.$emit("openNewTrailerDiv", {});
		
	}
	 $rootScope.$on("changeTrailerVal", function() {
		 var sid = $rootScope.newTrailID
		 var stxt=$rootScope.newTrailTxt;
		 $scope.trailerList = [{id:sid,text:stxt}];
		 $http.get($stateParams.tenantid+'/app/plantrip/getTruckTrailMapId?truckCode='+$scope.trip.truckId+'&tripStartDate='+$scope.trip.tripStartDate+'&trailerId='+sid).success(function(datas) {
             $scope.trip.truckTrailerMappingId=datas.mappingId;
             if($scope.trip.truckTrailerMappingId !='' && $scope.trip.truckTrailerMappingId ){
            	 $scope.trip.trailerId=sid;	 
             }
             
             console.log(datas);
             }).error(function(datas) {
         });   
		 
		
	})

	$scope.trip={
			truckId: '',
			tripNo : '',
			trailerId: '',
			fromLocation : '',
			toLocation : '',
			eta : '',
			etd : '',
			truckRegNo : '',
			trailerNo : '',
			truckTrailerMappingId : '',
            tripStartDate	: '',
            driverId : [],
            driverMappingId : '',
            refId : '',
            driverName : ''
            


			
	}
	
	$scope.trip1={		
			tripNo : '',			
			fromLocation : '',
			toLocation : '',
			eta : '',
			etd : '',
			truckRegNo : '',
			trailerNo : '',
			driversName :''


			
	}
	$scope.transportType='';
	
	 $scope.changetoUsd = function(){
		 if( $scope.trip.roadchargesksh != null &&  $scope.trip.roadchargesksh != '' && $scope.trip.roadchargesksh != '0'){
				$scope.trip.roadchargesusd = parseFloat($scope.trip.roadchargesksh)/100;
			}
	 }

	 $scope.changetoKsh = function(){
		if( $scope.trip.roadchargesusd != null &&  $scope.trip.roadchargesusd != '' && $scope.trip.roadchargesusd != '0'){
			$scope.trip.roadchargesksh = parseFloat($scope.trip.roadchargesusd)*100;
		}
	 }
	if(lolId != '' && lolId != null && lodId != '' && lodId != null){
		$scope.trip.fromLocation=lolId;
		$scope.trip.toLocation=lodId;
		$scope.tripReallocate=true;
	}
	
	$scope.$watchCollection('[ trip.fromLocation,trip.toLocation]', function(newValue, oldValue) {
		if($scope.trip.fromLocation != "" && $scope.trip.fromLocation != undefined &&
				$scope.trip.toLocation != "" && $scope.trip.toLocation != undefined){
	        $http.get($stateParams.tenantid+'/app/booking/getLocalOrTransit?fromLocation='+$scope.trip.fromLocation+'&toLocation='+$scope.trip.toLocation).success(function(datas) {
	             $scope.transportType =datas.transportType;
	          
	        });
			
		}
		
	});
	
  
	 // Truck Details
    $scope.trip1=[];
    $scope.$watch('trip.truckId', function(newValue, oldValue) {
        
        if (newValue != '' && newValue != undefined) {      
        	
            $http.get($stateParams.tenantid+'/app/plantrip/truckid?truck_id='+newValue).success(function(datas) {
            	console.log(datas);
            	
            		$scope.trip1 = datas;
            	
            	
            	

            }).error(function(data) {
            	logger.logError("Unable to fetch");
            });    

        }
    });
	
	$scope.save= function(trip,TripForm){
		if (new validationService().checkFormValidity($scope.TripForm)) {
			if($scope.trip.driverId.length > 0 ){
		$http.post($stateParams.tenantid+'/app/plantrip/add',
				$scope.trip).success(function(datas) {
					if(datas.success){
		                logger.logSuccess("Saved Successfully!");
		                if(value == 'DailyLoadingEntry'){
		                	 $state.go('app.operation.loadingentry.list');
		                }else{
		                	 $state.go('app.operation.trip.list',{tenantid:$stateParams.tenantid});
		                }
		               
					}
					else if(!datas.success && datas.message != ''){
						logger.logError(datas.message);
					}
					else if(!datas.success && datas.message == ''){
						  logger.logError("Error in save!");
					}
			
		})
			}
			else{
				logger
				.logError("Please Select Driver!");
			}
		}
	    else{
            toaster.pop('error', "Please fill the required fields", 
                    logger.getErrorHtmlNew($scope.TripForm.$validationSummary), 555000, 'trustedHtml');
        	if($scope.trip.driverId.length == 0 ){
				logger
				.logError("Please Select Driver!");
			}
                       }
		
	}
	

    $scope.getDropdownvalue = function() { 
        $http.get($stateParams.tenantid+'/locationmaster/getPort').success(function(datas) {
             $scope.portList =datas.portList;
             console.log("HI");
             console.log(datas.portList);
           
          
        });
        
        $http.get($stateParams.tenantid+'/truckdrivermapping/trucklist').success(function(datas) {
            $scope.truckList =datas.truckList;
            console.log(datas.truckList);
         
       });
        
        
    }
	   $scope.trailerList = [];
	  
		
	    $("#driverListSelect").multiselect({
	        maxHeight: 200,   
	        includeSelectAllOption: true,
	        disableIfEmpty: true,
	        enableCaseInsensitiveFiltering: true,
	        onDropdownHide: function (event) {
	            
	        }
	      });
	    $(".multiselect").addClass("width_100 input-sm line-height-5");
	    
	   $scope.getMappingId = function(){
		   if($scope.trip.driverId != '' && $scope.trip.driverId != undefined
			        && $scope.trip.truckId != '' && $scope.trip.truckId != undefined
			        && $scope.trip.tripStartDate != '' && $scope.trip.tripStartDate != undefined){

			                $http.get($stateParams.tenantid+'/app/plantrip/getMappingIdbyTruckDriver?truckId='+parseInt($scope.trip.truckId)+'&driverId='+$scope.trip.driverId+'&tripDate='+$scope.trip.tripStartDate).success(function(datas) {
			                    $scope.trip.driverMappingId=datas.driverMappingId;
			                   
			                    
			                    console.log(datas);
			                    }).error(function(datas) {
			                });   
			        }
	   }
	    
	  
		          
	    
	   
	   $scope.$watchCollection('[trip.truckId,trip.tripStartDate]', function(newValue, oldValue) {
		   debugger
	        if (newValue != '' && newValue != undefined) {
	           if($scope.trip.tripStartDate != '' && $scope.trip.tripStartDate != undefined
	        && $scope.trip.truckId != '' && $scope.trip.truckId != undefined){
	        	   $scope.createTrailerMapLink=true;
	                $http.get($stateParams.tenantid+'/app/plantrip/getTrailerByTruck?truckCode='+$scope.trip.truckId+'&tripStartDate='+$scope.trip.tripStartDate).success(function(datas) {
	                    $scope.trailerList = datas.list;
	                    $scope.trip.truckTrailerMappingId=datas.mappingId;
	                    if(datas.trailerId != null){
		                    $scope.trip.trailerId=datas.trailerId.toString();
		                    }
		                    else{
		                    	 $scope.trip.trailerId='';
		                    }
	                   
	                    
	                    console.log(datas);
	                    }).error(function(datas) {
	                });   
	                

	                $http.get($stateParams.tenantid+'/app/plantrip/getDriverByTruck?truckId='+$scope.trip.truckId+'&tripDate='+$scope.trip.tripStartDate).success(function(datas) {
	                	  $scope.trip.driverId=[];
	                	 $scope.driverList = datas.list;
	                 // $scope.trip.driverId=datas.list[0].id;
	                    console.log(datas);
	                    for(var i=0;i < $scope.driverList.length;i++){
	                    	$scope.trip.driverId.push($scope.driverList[i].id);
	                    }
	                    $scope.getMappingId();
	                    
	                    $timeout(function() {
	                    	$("#driverListSelect").multiselect('rebuild');
	                    	 $('#driverListSelect').multiselect({
	                    	        includeSelectAllOption: true
	                    	    });

	                    	    $("#driverListSelect").multiselect('selectAll', false);
	                    	    $("#driverListSelect").multiselect('updateButtonText');
	                    	    
			             /*
							 * $('#driverListSelect').multiselect('deselectAll',
							 * false);
							 * $('#driverListSelect').multiselect('updateButtonText');
							 * $("#driverListSelect").multiselect('rebuild');
							 */
			            
			            }, 2, false);
			            $("#multiselect-button").addClass("width_100 input-sm line-height-5");
					
	                    
	                    }).error(function(datas) {
	                }); 
	                
	        }
	          
	        }
	    });
	    
	   
	   
	   $scope.$watchCollection('[trip.truckId,trip.driverId]', function(newValue, oldValue) {
		   debugger
	        if (newValue != '' && newValue != undefined) {
	           if($scope.trip.driverId != '' && $scope.trip.driverId != undefined
	        && $scope.trip.truckId != '' && $scope.trip.truckId != undefined){

	                $http.get($stateParams.tenantid+'/app/plantrip/getMappingIdbyTruckDriver?truckId='+parseInt($scope.trip.truckId)+'&driverId='+$scope.trip.driverId+'&tripDate='+$scope.trip.tripStartDate).success(function(datas) {
	                    $scope.trip.driverMappingId=datas.driverMappingId;
	                    console.log(datas);
	                    }).error(function(datas) {
	                });   
	        }
	          
	        }
	    });
	    
	   
	    
    
    
    
    $scope.$watch('trip.trailerId', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
           if($scope.trip.truckId != '' && $scope.trip.truckId != undefined &&
        	 $scope.trip.truckTrailerMappingId != '' && $scope.trip.truckTrailerMappingId != undefined){

                $http.get($stateParams.tenantid+'/app/plantrip/autoGenTripNo?truckId='+$scope.trip.truckId+'&mappingId='+$scope.trip.truckTrailerMappingId+ '&tripStartDate='
						+ $scope.trip.tripStartDate).success(function(datas) {
                    $scope.trip.tripNo = datas.autoGenTripNo;
                    
                    
                    console.log(datas);
                    }).error(function(datas) {
                });               
        }
           else
        	   {
        	   logger.logError("Please Select Start Trip Date!");
        	   }
        }
        else{
       	 $scope.trip.tripNo = '';
       }
    });
    
    
    
    
    
    $scope.cancel=function(){
    	$state.go("app.operation.trip.list");
    }
    
    $scope.reset=function(){
    	$state.reload();
    }
  
    $scope.getDropdownvalue();
	
	 $('#fromDate').datetimepicker({
	        format : 'DD/MM/YYYY HH:MM'
	    })
	    
	     $('#toDate').datetimepicker({
	        format : 'DD/MM/YYYY  HH:MM'
	    })
	    
	    	     $('#tripStartDate').datetimepicker({
	        format : 'DD/MM/YYYY '
	    })
	    
	    
// $scope.$watch('trip.eta', function(newValue, oldValue) {
// start_date, period, number
// var start_date=$scope.trip.eta;
// var period='Hours';
// var number=$scope.timeDiff;
// var dailyDrivingPeriod=9;
// if (newValue != '' && newValue != undefined) {
// // For Change MM-DD-YYYY Format
// var startDate = '';
// if (typeof start_date == 'string') {
// var dateTime = start_date.split(' ');
// var sDate = dateTime[0].split('/');
// startDate = sDate[1] + '/' + sDate[0] + '/' + sDate[2] + ' ' + dateTime[1];
// } else {
// startDate = start_date;
// }
// var d1=moment(startDate).add(period, number)
// $scope.trip.etd= d1.format("dd/mm/yyyy HH24:MM");
// };
//
// });
	    
	    
});

app.controller('tripEditUserCtrl', function($scope,$timeout,$rootScope, $injector, $http, $location, logger, utilsService, 
		$state, sharedProperties, $window,toaster,validationService,$stateParams) {
// $scope.saveOrganization = function() {
//	
// }

	$scope.trip={
			truckId: '',
			tripNo : '',
			trailerId: '',
			fromLocation : '',
			toLocation : '',
			eta : '',
			etd : '',
			truckRegNo : '',
			trailerNo : '',
			truckTrailerMappingId : '',
            tripStartDate	: '',
            driverId : [],
            driverMappingId : '',
            refId : ''
            	

			
	}
	
	$scope.$watchCollection('[ trip.fromLocation,trip.toLocation]', function(newValue, oldValue) {
		if($scope.trip.fromLocation != "" && $scope.trip.fromLocation != undefined &&
				$scope.trip.toLocation != "" && $scope.trip.toLocation != undefined){
	        $http.get($stateParams.tenantid+'/app/booking/getLocalOrTransit?fromLocation='+$scope.trip.fromLocation+'&toLocation='+$scope.trip.toLocation).success(function(datas) {
	             $scope.transportType =datas.transportType;
	          
	        });
			
		}
		
	});
	
	$scope.getMappingId = function(){
		   if($scope.trip.driverId != '' && $scope.trip.driverId != undefined
			        && $scope.trip.truckId != '' && $scope.trip.truckId != undefined
			        && $scope.trip.tripStartDate != '' && $scope.trip.tripStartDate != undefined){

			                $http.get($stateParams.tenantid+'/app/plantrip/getMappingIdbyTruckDriver?truckId='+parseInt($scope.trip.truckId)+'&driverId='+$scope.trip.driverId+'&tripDate='+$scope.trip.tripStartDate).success(function(datas) {
			                    $scope.trip.driverMappingId=datas.driverMappingId;
			                   
			                    
			                    console.log(datas);
			                    }).error(function(datas) {
			                });   
			        }
	   }
	    
	
	$scope.changeTrailerMapping = function(editid){    
		if($scope.trip.truckTrailerMappingId != '' && $scope.trip.truckTrailerMappingId != null){
			$location.url($stateParams.tenantid+'/trucktrailer/edit?rowid='+editid);   
		}
		else{
			  logger.logError("Please Select Trailer!");
		}
        
        
		
	}
	
	
// $scope.$watch('trip.eta', function(newValue, oldValue) {
// start_date, period, number
// var start_date=$scope.trip.eta;
// var period='Hours';
// var number=$scope.timeDiff;
// var dailyDrivingPeriod=9;
// if (newValue != '' && newValue != undefined) {
// // For Change MM-DD-YYYY Format
// var startDate = '';
// if (typeof start_date == 'string') {
// var dateTime = start_date.split(' ');
// var sDate = dateTime[0].split('/');
// startDate = sDate[1] + '/' + sDate[0] + '/' + sDate[2] + ' ' + dateTime[1];
// } else {
// startDate = start_date;
// }
// var d1=moment(startDate).add(period, number)
// $scope.trip.etd= d1.format("dd/mm/yyyy HH24:MM");
// };
//
// });
	
	$scope.update= function(trip,TripForm){
		if (new validationService().checkFormValidity($scope.TripForm)) {
		$http.post($stateParams.tenantid+'/app/plantrip/update',
				$scope.trip).success(function(datas) {
					if(datas.success){
		                logger.logSuccess("Updated Successfully!");
		                $state.go('app.operation.trip.list',{tenantid:$stateParams.tenantid});
					}
					else if(!datas.success && datas.message != ''){
						  logger.logError(datas.message);
					}
					else if(!datas.success && datas.message == ''){
						  logger.logError("Error in Update!");
					}
			
		})
		}
		  else{
	            toaster.pop('error', "Please fill the required fields", 
	                    logger.getErrorHtmlNew($scope.TripForm.$validationSummary), 555000, 'trustedHtml');
	                       }
	}
	

    $scope.getDropdownvalue = function() { 
        $http.get($stateParams.tenantid+'/app/distance/getPort').success(function(datas) {
             $scope.portList =datas.portList;
             console.log("HI");
             console.log(datas.portList);
          
        });
        
        $http.get($stateParams.tenantid+'/truckdrivermapping/trucklist').success(function(datas) {
            $scope.truckList =datas.truckList;
            console.log(datas.truckList);
         
       });
        
        
        
    }
	   $scope.trailerList = [];
	   $scope.driverList=[];
	   
	
	   
	    
	   $scope.createTrailerMapLink=false;
	   $scope.$watchCollection('[trip.truckId,trip.tripStartDate]', function(newValue, oldValue) {
		   debugger
	        if (newValue != '' && newValue != undefined) {
	           if($scope.trip.tripStartDate != '' && $scope.trip.tripStartDate != undefined
	        && $scope.trip.truckId != '' && $scope.trip.truckId != undefined){
	        	   $scope.createTrailerMapLink=true;
	                $http.get($stateParams.tenantid+'/app/plantrip/getTrailerByTruck?truckCode='+$scope.trip.truckId+'&tripStartDate='+$scope.trip.tripStartDate).success(function(datas) {
	                    $scope.trailerList = datas.list;
	                    $scope.trip.truckTrailerMappingId=datas.mappingId;
	                    if(datas.trailerId != null){
		                    $scope.trip.trailerId=datas.trailerId.toString();
		                    }
		                    else{
		                    	 $scope.trip.trailerId='';
		                    }
	                   
	                    
	                    console.log(datas);
	                    }).error(function(datas) {
	                });   

	        }
	          
	        }
	    });
	    
	   $scope.createTrailerMapping=function(){
			$rootScope.createTrailShow=true;
			$('#blkCnt').block({ message: null });
			$('#tripHisId').block({ message: null });
			$('#allotBokBlock').block({ message: null });
			$rootScope.trkID=$scope.trip.truckId;
			$rootScope.trkTrailID=$scope.trip.trailerId;
			$rootScope.trkETD=$scope.trip.etd;
			$rootScope.trkTETA=$scope.trip.eta;
			$rootScope.tripStDt=$scope.trip.tripStartDate;
			$rootScope.truckTrailEdit=true;
			$rootScope.$emit("openNewTrailerDiv", {});
			
		}
	   
	   $scope.$watchCollection('[trip.truckId,trip.driverId]', function(newValue, oldValue) {
		   debugger
	        if (newValue != '' && newValue != undefined) {
	           if($scope.trip.driverId != '' && $scope.trip.driverId != undefined
	        && $scope.trip.truckId != '' && $scope.trip.truckId != undefined){

	                $http.get($stateParams.tenantid+'/app/plantrip/getMappingIdbyTruckDriver?truckId='+parseInt($scope.trip.truckId)+'&driverId='+$scope.trip.driverId+'&tripDate='+$scope.trip.tripStartDate).success(function(datas) {
	                    $scope.trip.driverMappingId=datas.driverMappingId;
	                    
	                    console.log(datas);
	                    }).error(function(datas) {
	                });   
	        }
	          
	        }
	    });
	    
	    
    
    $scope.$watch('trip.trailerId', function(newValue, oldValue) {
    	 if($scope.trip.truckId == $scope.tempTruckId){
			   $scope.trip.tripNo=$scope.tempTripNo;
		   }
    	 else{
    		  if (newValue != '' && newValue != undefined) {
    	           if($scope.trip.truckId != '' && $scope.trip.truckId != undefined &&
    	        	 $scope.trip.truckTrailerMappingId != '' && $scope.trip.truckTrailerMappingId != undefined){

    	                $http.get($stateParams.tenantid+'/app/plantrip/autoGenTripNo?truckId='+$scope.trip.truckId+'&mappingId='+$scope.trip.truckTrailerMappingId+ '&tripStartDate='
    							+ $scope.trip.tripStartDate).success(function(datas) {
    	                    $scope.trip.tripNo = datas.autoGenTripNo;
    	                    
    	                    
    	                    console.log(datas);
    	                    }).error(function(datas) {
    	                });               
    	        }
    	           else
    	        	   {
    	        	   logger.logError("Please Select Start Trip Date!");
    	        	   }
    	        }
    		  else{
    		       	 $scope.trip.tripNo = '';
    		       }
    	 }
      
    });
    
    var planTripId = $stateParams.planTripId;
    $scope.isEdit=false;
    var count=0;
    if(planTripId != '' && planTripId != undefined){
    	 $scope.isEdit=true;
        $http.get($stateParams.tenantid+'/app/plantrip/edit?planTripId='+planTripId).success(function(datas) {
        	debugger
            $scope.trip = datas[0];
            $scope.trip.truckId=datas[0].truckId.toString();
            $scope.tempDriverId=datas[0].driverId;
            $scope.trip.fromLocation=datas[0].fromLocation.toString().trim();
            $scope.tempTrailerId=datas[0].trailerId.toString();
            $scope.tempTruckId=datas[0].truckId.toString();
            $scope.tempTripStartDate=datas[0].tripStartDate;
            $scope.tempTripNo=datas[0].tripNo;
            console.log(datas);
            
            $http.get($stateParams.tenantid+'/app/plantrip/getDriverByTruck?truckId='+$scope.trip.truckId+'&tripDate='+$scope.trip.tripStartDate).success(function(datas) {
            	  $scope.trip.driverId=[];
            	$scope.driverList = datas.list;
                
                console.log(datas);
                $timeout(function() {
                	 $scope.trip.driverId= $scope.tempDriverId;
                	   $("#driverListSelect").multiselect({
               	        maxHeight: 200,   
               	        includeSelectAllOption: true,
               	        disableIfEmpty: true,
               	        enableCaseInsensitiveFiltering: true,
               	        onDropdownHide: function (event) {
               	            
               	        }
               	      });
               	    $(".multiselect").addClass("width_100 input-sm line-height-5");
	               // $('#driverListSelect').multiselect('deselectAll', false);
	               // $('#driverListSelect').multiselect('updateButtonText');
	               // $("#driverListSelect").multiselect('rebuild');
	                // $("#driverListSelect").multiselect(['0']);
	                // $("#multiselect-button").addClass("width_100 input-sm
					// line-height-5");
		           
		            console.log($scope.trip.driverId)
		           /*
					 * if ($scope.trip.driverId.length >0) { for (var i = 0; i <
					 * $scope.trip.driverId.length; i++) {
					 * $("#driverListSelect").find("option[label=" +
					 * $scope.trip.driverId[i] + "]").prop("selected",
					 * "selected"); }
					 * 
					 * $("#driverListSelect").prop("disabled", false);
					 *  } else { $scope.trip.driverId = null;
					 * $("#driverListSelect").prop("disabled", true); }
					 */
	            }, 2, false);
	          
                }).error(function(datas) {
            });
            
           $scope.getBookingList();
            }).error(function(datas) {
        });  
        
    }
    $scope.getBookingList= function(){
    $http.get($stateParams.tenantid+'/app/plantrip/getBookingListByTripNo?tripNo='+$scope.tempTripNo).success(function(returnData) {
        debugger
    	$scope.bookingList=returnData.bookingList;
    	
    });
    }
    
    $scope.cancel=function(){
    	$state.go("dashboard.list", {
			tenantid : $stateParams.tenantid
		}); 
    }
    
    $scope.reset=function(){
    	$state.reload();
    }
  
    
    $scope.getDropdownvalue();
	
	 $('#fromDate').datetimepicker({
	        format : 'DD/MM/YYYY HH:MM'
	    })
	    
	     $('#toDate').datetimepicker({
	        format : 'DD/MM/YYYY  HH:MM'
	    })
	    
	    	     $('#tripStartDate').datetimepicker({
	        format : 'DD/MM/YYYY '
	    })
	    
	   
	    
});

app.controller('tripEditCustomerCtrl', function($scope,$timeout,$rootScope, $injector, $http, $location, logger, utilsService, $state, 
		sharedProperties, $window,toaster,validationService,$stateParams) {
// $scope.saveOrganization = function() {
//	
// }
	
	$scope.trip={
			truckId: '',
			tripNo : '',
			trailerId: '',
			fromLocation : '',
			toLocation : '',
			eta : '',
			etd : '',
			truckRegNo : '',
			trailerNo : '',
			truckTrailerMappingId : '',
            tripStartDate	: '',
            driverId : [],
            driverMappingId : '',
            refId : ''
            	

			
	}
	
	$scope.$watchCollection('[ trip.fromLocation,trip.toLocation]', function(newValue, oldValue) {
		if($scope.trip.fromLocation != "" && $scope.trip.fromLocation != undefined &&
				$scope.trip.toLocation != "" && $scope.trip.toLocation != undefined){
	        $http.get($stateParams.tenantid+'/app/booking/getLocalOrTransit?fromLocation='+$scope.trip.fromLocation+'&toLocation='+$scope.trip.toLocation).success(function(datas) {
	             $scope.transportType =datas.transportType;
	          
	        });
			
		}
		
	});
	
	$scope.getMappingId = function(){
		   if($scope.trip.driverId != '' && $scope.trip.driverId != undefined
			        && $scope.trip.truckId != '' && $scope.trip.truckId != undefined
			        && $scope.trip.tripStartDate != '' && $scope.trip.tripStartDate != undefined){

			                $http.get($stateParams.tenantid+'/app/plantrip/getMappingIdbyTruckDriver?truckId='+parseInt($scope.trip.truckId)+'&driverId='+$scope.trip.driverId+'&tripDate='+$scope.trip.tripStartDate).success(function(datas) {
			                    $scope.trip.driverMappingId=datas.driverMappingId;
			                   
			                    
			                    console.log(datas);
			                    }).error(function(datas) {
			                });   
			        }
	   }
	    
	
	$scope.changeTrailerMapping = function(editid){    
		if($scope.trip.truckTrailerMappingId != '' && $scope.trip.truckTrailerMappingId != null){
			$location.url($stateParams.tenantid+'/trucktrailer/edit?rowid='+editid);   
		}
		else{
			  logger.logError("Please Select Trailer!");
		}
        
        
		
	}
	
	
// $scope.$watch('trip.eta', function(newValue, oldValue) {
// start_date, period, number
// var start_date=$scope.trip.eta;
// var period='Hours';
// var number=$scope.timeDiff;
// var dailyDrivingPeriod=9;
// if (newValue != '' && newValue != undefined) {
// // For Change MM-DD-YYYY Format
// var startDate = '';
// if (typeof start_date == 'string') {
// var dateTime = start_date.split(' ');
// var sDate = dateTime[0].split('/');
// startDate = sDate[1] + '/' + sDate[0] + '/' + sDate[2] + ' ' + dateTime[1];
// } else {
// startDate = start_date;
// }
// var d1=moment(startDate).add(period, number)
// $scope.trip.etd= d1.format("dd/mm/yyyy HH24:MM");
// };
//
// });
	
	$scope.update= function(trip,TripForm){
		if (new validationService().checkFormValidity($scope.TripForm)) {
		$http.post($stateParams.tenantid+'/app/plantrip/update',
				$scope.trip).success(function(datas) {
					if(datas.success){
		                logger.logSuccess("Updated Successfully!");
		                $state.go('app.operation.trip.list',{tenantid:$stateParams.tenantid});
					}
					else if(!datas.success && datas.message != ''){
						  logger.logError(datas.message);
					}
					else if(!datas.success && datas.message == ''){
						  logger.logError("Error in Update!");
					}
			
		})
		}
		  else{
	            toaster.pop('error', "Please fill the required fields", 
	                    logger.getErrorHtmlNew($scope.TripForm.$validationSummary), 555000, 'trustedHtml');
	                       }
	}
	

    $scope.getDropdownvalue = function() { 
        $http.get($stateParams.tenantid+'/app/distance/getPort').success(function(datas) {
             $scope.portList =datas.portList;
             console.log("HI");
             console.log(datas.portList);
          
        });
        
        $http.get($stateParams.tenantid+'/truckdrivermapping/trucklist').success(function(datas) {
            $scope.truckList =datas.truckList;
            console.log(datas.truckList);
         
       });
        
        
        
    }
	   $scope.trailerList = [];
	   $scope.driverList=[];
	   
	
	   
	    
	   $scope.createTrailerMapLink=false;
	   $scope.$watchCollection('[trip.truckId,trip.tripStartDate]', function(newValue, oldValue) {
		   debugger
	        if (newValue != '' && newValue != undefined) {
	           if($scope.trip.tripStartDate != '' && $scope.trip.tripStartDate != undefined
	        && $scope.trip.truckId != '' && $scope.trip.truckId != undefined){
	        	   $scope.createTrailerMapLink=true;
	                $http.get($stateParams.tenantid+'/app/plantrip/getTrailerByTruck?truckCode='+$scope.trip.truckId+'&tripStartDate='+$scope.trip.tripStartDate).success(function(datas) {
	                    $scope.trailerList = datas.list;
	                    $scope.trip.truckTrailerMappingId=datas.mappingId;
	                    if(datas.trailerId != null){
		                    $scope.trip.trailerId=datas.trailerId.toString();
		                    }
		                    else{
		                    	 $scope.trip.trailerId='';
		                    }
	                   
	                    
	                    console.log(datas);
	                    }).error(function(datas) {
	                });   

	        }
	          
	        }
	    });
	    
	   $scope.createTrailerMapping=function(){
			$rootScope.createTrailShow=true;
			$('#blkCnt').block({ message: null });
			$('#tripHisId').block({ message: null });
			$('#allotBokBlock').block({ message: null });
			$rootScope.trkID=$scope.trip.truckId;
			$rootScope.trkTrailID=$scope.trip.trailerId;
			$rootScope.trkETD=$scope.trip.etd;
			$rootScope.trkTETA=$scope.trip.eta;
			$rootScope.tripStDt=$scope.trip.tripStartDate;
			$rootScope.truckTrailEdit=true;
			$rootScope.$emit("openNewTrailerDiv", {});
			
		}
	   
	   $scope.$watchCollection('[trip.truckId,trip.driverId]', function(newValue, oldValue) {
		   debugger
	        if (newValue != '' && newValue != undefined) {
	           if($scope.trip.driverId != '' && $scope.trip.driverId != undefined
	        && $scope.trip.truckId != '' && $scope.trip.truckId != undefined){

	                $http.get($stateParams.tenantid+'/app/plantrip/getMappingIdbyTruckDriver?truckId='+parseInt($scope.trip.truckId)+'&driverId='+$scope.trip.driverId+'&tripDate='+$scope.trip.tripStartDate).success(function(datas) {
	                    $scope.trip.driverMappingId=datas.driverMappingId;
	                    
	                    console.log(datas);
	                    }).error(function(datas) {
	                });   
	        }
	          
	        }
	    });
	    
	    
    
    $scope.$watch('trip.trailerId', function(newValue, oldValue) {
    	 if($scope.trip.truckId == $scope.tempTruckId){
			   $scope.trip.tripNo=$scope.tempTripNo;
		   }
    	 else{
    		  if (newValue != '' && newValue != undefined) {
    	           if($scope.trip.truckId != '' && $scope.trip.truckId != undefined &&
    	        	 $scope.trip.truckTrailerMappingId != '' && $scope.trip.truckTrailerMappingId != undefined){

    	                $http.get($stateParams.tenantid+'/app/plantrip/autoGenTripNo?truckId='+$scope.trip.truckId+'&mappingId='+$scope.trip.truckTrailerMappingId+ '&tripStartDate='
    							+ $scope.trip.tripStartDate).success(function(datas) {
    	                    $scope.trip.tripNo = datas.autoGenTripNo;
    	                    
    	                    
    	                    console.log(datas);
    	                    }).error(function(datas) {
    	                });               
    	        }
    	           else
    	        	   {
    	        	   logger.logError("Please Select Start Trip Date!");
    	        	   }
    	        }
    		  else{
    		       	 $scope.trip.tripNo = '';
    		       }
    	 }
      
    });
    
    var planTripId = $stateParams.planTripId;
    $scope.isEdit=false;
    var count=0;
    if(planTripId != '' && planTripId != undefined){
    	 $scope.isEdit=true;
        $http.get($stateParams.tenantid+'/app/plantrip/edit?planTripId='+planTripId).success(function(datas) {
        	debugger
            $scope.trip = datas[0];
            $scope.trip.truckId=datas[0].truckId.toString();
            $scope.tempDriverId=datas[0].driverId;
            $scope.trip.fromLocation=datas[0].fromLocation.toString().trim();
            $scope.tempTrailerId=datas[0].trailerId.toString();
            $scope.tempTruckId=datas[0].truckId.toString();
            $scope.tempTripStartDate=datas[0].tripStartDate;
            $scope.tempTripNo=datas[0].tripNo;
            console.log(datas);
            
            $http.get($stateParams.tenantid+'/app/plantrip/getDriverByTruck?truckId='+$scope.trip.truckId+'&tripDate='+$scope.trip.tripStartDate).success(function(datas) {
            	  $scope.trip.driverId=[];
            	$scope.driverList = datas.list;
                
                console.log(datas);
                $timeout(function() {
                	 $scope.trip.driverId= $scope.tempDriverId;
                	   $("#driverListSelect").multiselect({
               	        maxHeight: 200,   
               	        includeSelectAllOption: true,
               	        disableIfEmpty: true,
               	        enableCaseInsensitiveFiltering: true,
               	        onDropdownHide: function (event) {
               	            
               	        }
               	      });
               	    $(".multiselect").addClass("width_100 input-sm line-height-5");
	               // $('#driverListSelect').multiselect('deselectAll', false);
	               // $('#driverListSelect').multiselect('updateButtonText');
	               // $("#driverListSelect").multiselect('rebuild');
	                // $("#driverListSelect").multiselect(['0']);
	                // $("#multiselect-button").addClass("width_100 input-sm
					// line-height-5");
		           
		            console.log($scope.trip.driverId)
		           /*
					 * if ($scope.trip.driverId.length >0) { for (var i = 0; i <
					 * $scope.trip.driverId.length; i++) {
					 * $("#driverListSelect").find("option[label=" +
					 * $scope.trip.driverId[i] + "]").prop("selected",
					 * "selected"); }
					 * 
					 * $("#driverListSelect").prop("disabled", false);
					 *  } else { $scope.trip.driverId = null;
					 * $("#driverListSelect").prop("disabled", true); }
					 */
	            }, 2, false);
	          
                }).error(function(datas) {
            });
            
           $scope.getBookingList();
            }).error(function(datas) {
        });  
        
    }
    $scope.getBookingList= function(){
    $http.get($stateParams.tenantid+'/app/plantrip/getBookingListByTripNo?tripNo='+$scope.tempTripNo).success(function(returnData) {
        debugger
    	$scope.bookingList=returnData.bookingList;
    	
    });
    }
    
    $scope.cancel=function(){
    	$state.go("app.master.customer.dashboard");
    }
    
    $scope.reset=function(){
    	$state.reload();
    }
  
    
    $scope.getDropdownvalue();
	
	 $('#fromDate').datetimepicker({
	        format : 'DD/MM/YYYY HH:MM'
	    })
	    
	     $('#toDate').datetimepicker({
	        format : 'DD/MM/YYYY  HH:MM'
	    })
	    
	    	     $('#tripStartDate').datetimepicker({
	        format : 'DD/MM/YYYY '
	    })
	    
	   
	    
});
app.controller('tripEditCtrl', function($scope,$timeout,$rootScope, $injector, $http, $location, logger, utilsService, $state, sharedProperties, $window,toaster,validationService,$stateParams) {
// $scope.saveOrganization = function() {
//	
// }
	
	$scope.trip={
			truckId: '',
			tripNo : '',
			trailerId: '',
			fromLocation : '',
			toLocation : '',
			eta : '',
			etd : '',
			truckRegNo : '',
			trailerNo : '',
			truckTrailerMappingId : '',
            tripStartDate	: '',
            driverId : [],
            driverMappingId : '',
            refId : ''
            	

			
	}
	
	$scope.$watchCollection('[ trip.fromLocation,trip.toLocation]', function(newValue, oldValue) {
		if($scope.trip.fromLocation != "" && $scope.trip.fromLocation != undefined &&
				$scope.trip.toLocation != "" && $scope.trip.toLocation != undefined){
	        $http.get($stateParams.tenantid+'/app/booking/getLocalOrTransit?fromLocation='+$scope.trip.fromLocation+'&toLocation='+$scope.trip.toLocation).success(function(datas) {
	             $scope.transportType =datas.transportType;
	          
	        });
			
		}
		
	});
	
	$scope.changetoUsd = function(){
		 if( $scope.trip.roadchargesksh != null &&  $scope.trip.roadchargesksh != '' && $scope.trip.roadchargesksh != '0'){
				$scope.trip.roadchargesusd = parseFloat($scope.trip.roadchargesksh)/100;
			}
	 }

	 $scope.changetoKsh = function(){
		if( $scope.trip.roadchargesusd != null &&  $scope.trip.roadchargesusd != '' && $scope.trip.roadchargesusd != '0'){
			$scope.trip.roadchargesksh = parseFloat($scope.trip.roadchargesusd)*100;
		}
	 }
	
	$scope.getMappingId = function(){
		   if($scope.trip.driverId != '' && $scope.trip.driverId != undefined
			        && $scope.trip.truckId != '' && $scope.trip.truckId != undefined
			        && $scope.trip.tripStartDate != '' && $scope.trip.tripStartDate != undefined){

			                $http.get($stateParams.tenantid+'/app/plantrip/getMappingIdbyTruckDriver?truckId='+parseInt($scope.trip.truckId)+'&driverId='+$scope.trip.driverId+'&tripDate='+$scope.trip.tripStartDate).success(function(datas) {
			                    $scope.trip.driverMappingId=datas.driverMappingId;
			                   
			                    
			                    console.log(datas);
			                    }).error(function(datas) {
			                });   
			        }
	   }
	    
	
	$scope.changeTrailerMapping = function(editid){    
		if($scope.trip.truckTrailerMappingId != '' && $scope.trip.truckTrailerMappingId != null){
			$location.url($stateParams.tenantid+'/trucktrailer/edit?rowid='+editid);   
		}
		else{
			  logger.logError("Please Select Trailer!");
		}
        
        
		
	}
	
	
// $scope.$watch('trip.eta', function(newValue, oldValue) {
// start_date, period, number
// var start_date=$scope.trip.eta;
// var period='Hours';
// var number=$scope.timeDiff;
// var dailyDrivingPeriod=9;
// if (newValue != '' && newValue != undefined) {
// // For Change MM-DD-YYYY Format
// var startDate = '';
// if (typeof start_date == 'string') {
// var dateTime = start_date.split(' ');
// var sDate = dateTime[0].split('/');
// startDate = sDate[1] + '/' + sDate[0] + '/' + sDate[2] + ' ' + dateTime[1];
// } else {
// startDate = start_date;
// }
// var d1=moment(startDate).add(period, number)
// $scope.trip.etd= d1.format("dd/mm/yyyy HH24:MM");
// };
//
// });
	
	$scope.update= function(trip,TripForm){
		if (new validationService().checkFormValidity($scope.TripForm)) {
		$http.post($stateParams.tenantid+'/app/plantrip/update',
				$scope.trip).success(function(datas) {
					if(datas.success){
		                logger.logSuccess("Updated Successfully!");
		                $state.go('app.operation.trip.list',{tenantid:$stateParams.tenantid});
					}
					else if(!datas.success && datas.message != ''){
						  logger.logError(datas.message);
					}
					else if(!datas.success && datas.message == ''){
						  logger.logError("Error in Update!");
					}
			
		})
		}
		  else{
	            toaster.pop('error', "Please fill the required fields", 
	                    logger.getErrorHtmlNew($scope.TripForm.$validationSummary), 555000, 'trustedHtml');
	                       }
	}
	

    $scope.getDropdownvalue = function() { 
        $http.get($stateParams.tenantid+'/locationmaster/getPort').success(function(datas) {
             $scope.portList =datas.portList;
             console.log("HI");
             console.log(datas.portList);
          
        });
        
        $http.get($stateParams.tenantid+'/truckdrivermapping/trucklist').success(function(datas) {
            $scope.truckList =datas.truckList;
            console.log(datas.truckList);
         
       });
        
        
        
    }
	   $scope.trailerList = [];
	   $scope.driverList=[];
	   
	
	   
	    
	   $scope.createTrailerMapLink=false;
	   $scope.$watchCollection('[trip.truckId,trip.tripStartDate]', function(newValue, oldValue) {
		   debugger
	        if (newValue != '' && newValue != undefined) {
	           if($scope.trip.tripStartDate != '' && $scope.trip.tripStartDate != undefined
	        && $scope.trip.truckId != '' && $scope.trip.truckId != undefined){
	        	   $scope.createTrailerMapLink=true;
	                $http.get($stateParams.tenantid+'/app/plantrip/getTrailerByTruck?truckCode='+$scope.trip.truckId+'&tripStartDate='+$scope.trip.tripStartDate).success(function(datas) {
	                    $scope.trailerList = datas.list;
	                    $scope.trip.truckTrailerMappingId=datas.mappingId;
	                    if(datas.trailerId != null){
		                    $scope.trip.trailerId=datas.trailerId.toString();
		                    }
		                    else{
		                    	 $scope.trip.trailerId='';
		                    }
	                   
	                    
	                    console.log(datas);
	                    }).error(function(datas) {
	                });   

	        }
	          
	        }
	    });
	    
	   $scope.createTrailerMapping=function(){
			$rootScope.createTrailShow=true;
			$('#blkCnt').block({ message: null });
			$('#tripHisId').block({ message: null });
			$('#allotBokBlock').block({ message: null });
			$rootScope.trkID=$scope.trip.truckId;
			$rootScope.trkTrailID=$scope.trip.trailerId;
			$rootScope.trkETD=$scope.trip.etd;
			$rootScope.trkTETA=$scope.trip.eta;
			$rootScope.tripStDt=$scope.trip.tripStartDate;
			$rootScope.truckTrailEdit=true;
			$rootScope.$emit("openNewTrailerDiv", {});
			
		}
	   
	   $scope.$watchCollection('[trip.truckId,trip.driverId]', function(newValue, oldValue) {
		   debugger
	        if (newValue != '' && newValue != undefined) {
	           if($scope.trip.driverId != '' && $scope.trip.driverId != undefined
	        && $scope.trip.truckId != '' && $scope.trip.truckId != undefined){

	                $http.get($stateParams.tenantid+'/app/plantrip/getMappingIdbyTruckDriver?truckId='+parseInt($scope.trip.truckId)+'&driverId='+$scope.trip.driverId+'&tripDate='+$scope.trip.tripStartDate).success(function(datas) {
	                    $scope.trip.driverMappingId=datas.driverMappingId;
	                    
	                    console.log(datas);
	                    }).error(function(datas) {
	                });   
	        }
	          
	        }
	    });
	    
	    
    
    $scope.$watch('trip.trailerId', function(newValue, oldValue) {
    	 if($scope.trip.truckId == $scope.tempTruckId){
			   $scope.trip.tripNo=$scope.tempTripNo;
		   }
    	 else{
    		  if (newValue != '' && newValue != undefined) {
    	           if($scope.trip.truckId != '' && $scope.trip.truckId != undefined &&
    	        	 $scope.trip.truckTrailerMappingId != '' && $scope.trip.truckTrailerMappingId != undefined){

    	                $http.get($stateParams.tenantid+'/app/plantrip/autoGenTripNo?truckId='+$scope.trip.truckId+'&mappingId='+$scope.trip.truckTrailerMappingId+ '&tripStartDate='
    							+ $scope.trip.tripStartDate).success(function(datas) {
    	                    $scope.trip.tripNo = datas.autoGenTripNo;
    	                    
    	                    
    	                    console.log(datas);
    	                    }).error(function(datas) {
    	                });               
    	        }
    	           else
    	        	   {
    	        	   logger.logError("Please Select Start Trip Date!");
    	        	   }
    	        }
    		  else{
    		       	 $scope.trip.tripNo = '';
    		       }
    	 }
      
    });
    
    var planTripId = $stateParams.planTripId;
    $scope.isEdit=false;
    var count=0;
    if(planTripId != '' && planTripId != undefined){
    	 $scope.isEdit=true;
    	 debugger
        $http.get($stateParams.tenantid+'/app/plantrip/edit?planTripId='+planTripId).success(function(datas) {
        	
            $scope.trip = datas[0];
            $scope.trip.truckId=datas[0].truckId.toString();
            $scope.tempDriverId=datas[0].driverId;
            $scope.trip.fromLocation=datas[0].fromLocation.toString().trim();
            $scope.tempTrailerId=datas[0].trailerId.toString();
            $scope.tempTruckId=datas[0].truckId.toString();
            $scope.tempTripStartDate=datas[0].tripStartDate;
            $scope.tempTripNo=datas[0].tripNo;
            console.log(datas);
            
            $http.get($stateParams.tenantid+'/app/plantrip/getDriverByTruck?truckId='+$scope.trip.truckId+'&tripDate='+$scope.trip.tripStartDate).success(function(datas) {
            	  $scope.trip.driverId=[];
            	$scope.driverList = datas.list;
            	$scope.trip.driverId= $scope.tempDriverId;
                console.log(datas);
                $timeout(function() {
                	 $scope.trip.driverId= $scope.tempDriverId;
                	   $("#driverListSelect").multiselect({
               	        maxHeight: 200,   
               	        includeSelectAllOption: true,
               	        disableIfEmpty: true,
               	        enableCaseInsensitiveFiltering: true,
               	        onDropdownHide: function (event) {
               	            
               	        }
               	      });
               	    $(".multiselect").addClass("width_100 input-sm line-height-5");
	               // $('#driverListSelect').multiselect('deselectAll', false);
	               // $('#driverListSelect').multiselect('updateButtonText');
	               // $("#driverListSelect").multiselect('rebuild');
	                // $("#driverListSelect").multiselect(['0']);
	                // $("#multiselect-button").addClass("width_100 input-sm
					// line-height-5");
		           
		            console.log($scope.trip.driverId)
		           /*
					 * if ($scope.trip.driverId.length >0) { for (var i = 0; i <
					 * $scope.trip.driverId.length; i++) {
					 * $("#driverListSelect").find("option[label=" +
					 * $scope.trip.driverId[i] + "]").prop("selected",
					 * "selected"); }
					 * 
					 * $("#driverListSelect").prop("disabled", false);
					 *  } else { $scope.trip.driverId = null;
					 * $("#driverListSelect").prop("disabled", true); }
					 */
	            }, 2, false);
	          
                }).error(function(datas) {
            });
            
           $scope.getBookingList();
            }).error(function(datas) {
        });  
        
    }
    $scope.getBookingList= function(){
    $http.get($stateParams.tenantid+'/app/plantrip/getBookingListByTripNo?tripNo='+$scope.tempTripNo).success(function(returnData) {
        debugger
    	$scope.bookingList=returnData.bookingList;
    	
    });
    }
    
    $scope.cancel=function(){
    	$state.go("app.operation.trip.list");
    }
    
    $scope.reset=function(){
    	$state.reload();
    }
  
    
    $scope.getDropdownvalue();
	
	 $('#fromDate').datetimepicker({
	        format : 'DD/MM/YYYY HH:MM'
	    })
	    
	     $('#toDate').datetimepicker({
	        format : 'DD/MM/YYYY  HH:MM'
	    })
	    
	    	     $('#tripStartDate').datetimepicker({
	        format : 'DD/MM/YYYY '
	    })
	    
	   
	    
});
	    
	// XXXXX
	    
'use strict';
app.controller('trucktrailerAddCtrl', function($scope, $rootScope,ngDialog, $http, $location, logger,
        utilsService,$state,sharedProperties,$window,validationService,toaster,$stateParams,$filter){

    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.isEdit = false;
    $scope.trucktrailermodel = {
           
       truckName:'',
       truckId:'',
       trailerName:'',
       trailerId:'',
	  
       
          fromDate:'',
          toDate:'',
      
        trucktrailerId:''
        
        	
     };
    $rootScope.createTrailShow=false;
    $scope.showTrailMap=false;
    $scope.val=[];
    $scope.trucktrailerNewmodel=[];
    $rootScope.$on("openNewTrailerDiv", function() {
		if($rootScope.createTrailShow){
			$scope.trucktrailermodel.trucktrailerId='';
			$scope.trucktrailermodel.trailerId='';
			$scope.trucktrailermodel.fromDate='';
			$scope.trucktrailermodel.toDate='';
			$scope.trucktrailermodel.truckId=$rootScope.trkID;
			$scope.trucktrailermodel.trailerId=$rootScope.trkTrailID;
			$scope.start=$rootScope.tripStDt;
			/*
			 * if($rootScope.trkETD !='' && $rootScope.trkTETA !='' &&
			 * $rootScope.trkETD != undefined && $rootScope.trkTETA
			 * !=undefined){
			 * $scope.trucktrailermodel.fromDate=$rootScope.trkETD.substring(0,10);
			 * $scope.trucktrailermodel.toDate=$rootScope.trkTETA.substring(0,10); }
			 */
			$("#trkSelList").block({ message: null });
			$scope.isEdit=$rootScope.truckTrailEdit;
			$scope.showTrailMap=true;
			
			if($scope.start != '' && $scope.start != undefined &&$scope.trucktrailermodel.truckId !='' && $scope.trucktrailermodel.truckId != undefined
					&&	$scope.trucktrailermodel.trailerId != '' && $scope.trucktrailermodel.trailerId !=undefined){
				var x =parseInt($scope.trucktrailermodel.truckId);
				var y =parseInt($scope.trucktrailermodel.trailerId);
			    	$http.get($stateParams.tenantid+'/trucktrailermapping/getTruckTrailMappingId?truckId='+x+"&trilId="+y+'&stDt='+$scope.start).success(function(datas) {
						 $scope.trucktrailerNewmodel=datas;
						 $scope.trucktrailermodel.trucktrailerId=datas.trucktrailerId;
						 $scope.trucktrailermodel.fromDate=datas.fromDate;
						 $scope.trucktrailermodel.toDate=datas.toDate;
						 

						  $http.post($stateParams.tenantid+'/trucktrailermapping/getTruckDltById',$scope.trukDtl).success(function(datas) {
							  $scope.loadScheCalValues(datas,'1');
						  }).error(function(datas) {

					        });  
						  

						  $http.post($stateParams.tenantid+'/trucktrailermapping/getTrailerDltById',$scope.trukDtl).success(function(datas) {
							  
							  $scope.loadScheCalValues(datas,'2')
						  }).error(function(datas) {

					        });  
					  
					  
						
					 })
			}
			
			  
		}
	})
	
	
	
    $scope.cancel = function() {
    	$('#blkCnt').unblock();
		$('#tripHisId').unblock();
		$('#allotBokBlock').unblock();
    	$scope.showTrailMap=false;
	  	  
	          
	    };
	    $scope.truckList=[];
	    $scope.gettruckList=function(){
	    	 $http.get($stateParams.tenantid+'/trucktrailermapping/trucklist').success(function(datas) {
	            $scope.truckList = datas.truckList;
	            console.log("truckList");
	            console.log( $scope.truckList);
	           

	        }).error(function(data) {

	        });
	        
	     
	    }
	    $scope.gettruckList();
	    $scope.trailerList=[];
	    $scope.gettrailerList=function(){
	    	 $http.get($stateParams.tenantid+'/trucktrailermapping/trailerlist').success(function(datas) {
	            $scope.trailerList = datas.trailerList;
	            console.log("trailerList");
	            console.log( $scope.trailerList);
	           

	        }).error(function(data) {

	        });
	        
	     
	    }
	    $scope.gettrailerList();
	    

	    $scope.validate = function(trucktrailerForm) {
	    	$scope.isEdit=$rootScope.truckTrailEdit;
	        if (new validationService().checkFormValidity(trucktrailerForm)) {
	            if(!$scope.isEdit){
	                $scope.save(trucktrailerForm);
	                
	            }else{
	                $scope.update(trucktrailerForm);
	                
	            }
	        } else {
	            toaster.pop('error', "Please fill the required fields",
	                    logger.getErrorHtmlNew(trucktrailerForm.$validationSummary),5000, 'trustedHtml');
	        }
	    };
		   
	var editid = $location.search().rowid;
	// var editid = $scope.trucktrailermodel.trucktrailerId
		    
		    var test = parseInt(editid);
		    $scope.trucktrailermodel.trucktrailerId=test;
		    $scope.count1=[];
	   $scope.$watch('trucktrailermodel.trucktrailerId', function(newValue, oldValue) {
	            
	            if (newValue != '' && newValue != undefined) {      
	            	
	                $http.get($stateParams.tenantid+'/trucktrailermapping/trucktrailerId?truck_trailer_mapping_id='+newValue).success(function(datas) {
	                	console.log(datas);
	                	
	                		$scope.count = datas;
	                	

	                	

	                })
	            }
	        });
	  
	
	    
	    $scope.save = function(trucktrailerForm) {
	        sharedProperties.clearObject();
            console.log( trucktrailerForm);

 
            
  
            var frmDate = $scope.trucktrailermodel.fromDate;
	             var toDate = $scope.trucktrailermodel.toDate;
	             frmDate = frmDate.split("/");
	             frmDate = new Date(frmDate[2], frmDate[1]-1, frmDate[0]);
	             toDate = toDate.split("/");
	             toDate = new Date(toDate[2], toDate[1]-1, toDate[0]);
	             
	             if(frmDate>toDate){
	                 logger.logError(" Valid To Date should be greater than or Equal to Valid From Date");
	                 $scope.trucktrailermodel.toDate='';
	             }
	         
	             else{
	       	 $http.post($stateParams.tenantid+'/trucktrailermapping/saveFromTrip',$scope.trucktrailermodel)
	            .success(function(response) {
	        	  
	            	if(response=='ERR_DATE'){
	            		logger.logError("Truck and Trailer Reallocation date having conflict")
	            	}else if(response == 1){
	                   logger.logSuccess("Saved Succesfully!");
	                    $('#blkCnt').unblock();
		        		$('#tripHisId').unblock();
		        		$('#allotBokBlock').unblock();
		            	$scope.showTrailMap=false;
		            	
		            	 var l = $scope.trailerList;
		            	 angular.forEach(l, function(value, key) {
		                	 if(value.id==$scope.trucktrailermodel.trailerId){
		                		 $rootScope.newTrailID=$scope.trucktrailermodel.trailerId
		                		 $rootScope.newTrailTxt=value.text;
		                	 }
		                	   
		 					});
		            	
		            	$rootScope.$emit("changeTrailerVal", {});
		         	  	  // $state.go('master.trucktrailer.list',{tenantid:$stateParams.tenantid});
	      	             
	                   }else if(response.length > 0){
	                   var msList=response;
	                   var msg;
	                   angular.forEach(msList, function(value, key) {
	                	   msg=msg+value;
	                	   
	 					});
	                   logger.logError("Truck and Trailer Already Allocated on "+msg)
	                   }else{
	                   
		            	   logger.logError("Truck and Trailer Already Allocated on Same Date")
	               
	                   }
	            
	      
	    });}
	             
	    
	    }
	    $scope.update = function(trucktrailerForm) {
	        sharedProperties.clearObject();
	        var frmDate = $scope.trucktrailermodel.fromDate;
	             var toDate = $scope.trucktrailermodel.toDate;
	             frmDate = frmDate.split("/");
	             frmDate = new Date(frmDate[2], frmDate[1]-1, frmDate[0]);
	             toDate = toDate.split("/");
	              toDate = new Date(toDate[2], toDate[1]-1, toDate[0]);
	             if(frmDate>toDate){
	                 logger.logError(" Valid To Date should be greater than or Equal to Valid From Date");
	                 $scope.trucktrailermodel.toDate='';
	             }else{
      	     	 	 $http.post($stateParams.tenantid+'/trucktrailermapping/updateFromPlanTrip',$scope.trucktrailermodel)
	     	            .success(function(response) {
	     	          		 console.log(response);
	     	          		if(response=='MORE THAN ONE TRUCK'){
	    	            		logger.logError("MORE THAN ONE TRUCK")
	    	            	}else if(response == true){
	    	                   logger.logSuccess("Saved Succesfully!");
	    	                    $('#blkCnt').unblock();
	    		        		$('#tripHisId').unblock();
	    		        		$('#allotBokBlock').unblock();
	    		            	$scope.showTrailMap=false;
	    		            	
	    		            	 var l = $scope.trailerList;
	    		            	 angular.forEach(l, function(value, key) {
	    		                	 if(value.id==$scope.trucktrailermodel.trailerId){
	    		                		 $rootScope.newTrailID=$scope.trucktrailermodel.trailerId
	    		                		 $rootScope.newTrailTxt=value.text;
	    		                	 }
	    		                	   
	    		 					});
	    		            	
	    		            	$rootScope.$emit("changeTrailerVal", {});
	    		         	  	  // $state.go('master.trucktrailer.list',{tenantid:$stateParams.tenantid});
	    	      	             
	    	                   }else if(response.length > 0){
	    	                   var msList=response;
	    	                   var msg;
	    	                   angular.forEach(msList, function(value, key) {
	    	                	   msg=msg+value;
	    	                	   
	    	 					});
	    	                   logger.logError("Truck and Trailer Already Allocated on "+msg)
	    	                   }else{
	    	                   
	    		            	   logger.logError("Truck and Trailer Already Allocated on Same Date")
	    	               
	    	                   }
	     	              
	     	            });
	             }
	             }
	        
	   
	   var currentDate = new Date();
	     currentDate = ('0' + currentDate.getDate()).slice(-2)+"/"+('0' + (Number(currentDate.getMonth())+1)).slice(-2)+"/"+currentDate.getFullYear();
	   
	     

	     var editid = $location.search().rowid;
	     // var editid = $scope.trucktrailermodel.trucktrailerId;
	    
	    var test = parseInt(editid);
	    if(test){
	    $scope.isEdit=true;
	    $http.post($stateParams.tenantid+'/trucktrailermapping/edit',test).success(function(result) {
	    	
	    		
	    	console.log(result);
	    	$scope.trucktrailermodel = result;

	    	$scope.trucktrailermodel.truckId = result.truckId.toString();
	    	$scope.trucktrailermodel.trailerId = result.trailerId.toString();

	    	
	    	
	    });
	}
	
		
	  $scope.reset = function(trucktrailerForm) {
	        
	        if($scope.isEdit = true){
	            var trucktrailerId =  $scope.trucktrailermodel.trucktrailerId;
	            $scope.trucktrailermodel.truckName ='';
	       	 $scope.trucktrailermodel.fromDate ='';
	       	 $scope.trucktrailermodel.trailerId ='';
	       	 $scope.trucktrailermodel.trailerName ='';
	       	 $scope.trucktrailermodel.toDate ='';

	       	 $scope.trucktrailermodel.trucktrailerId ='';
	       	

	         $http.post($stateParams.tenantid+'/trucktrailermapping/edit',test).success(function(result) {
	 	    	
		    		
	 	    	console.log(result);
	 	    	$scope.trucktrailermodel = result;

	 	    	$scope.trucktrailermodel.trailerId = result.trailerId.toString();

	               
	            });
	        }
	        else{
	        	 $scope.trucktrailermodel.truckName ='';
	        	 $scope.trucktrailermodel.fromDate ='';
	        	 $scope.trucktrailermodel.toDate ='';
	        	 $scope.trucktrailermodel.trailerId ='';
	        	 $scope.trucktrailermodel.trailerName ='';
	        	 $scope.trucktrailermodel.trucktrailerId ='';
	      	  
	          
	        }
	       $rootScope.evtList=[];
       	 $scope.showShdBtn=false;
   	  /* $rootScope.$emit("hideScheduler", {}); */
   	/*
	 * $http.post($stateParams.tenantid+'/truckSchedule/updateValue').success(function(data) {
	 * if(data.success = true){
	 * $scope.trucktrailermodel.truckId=$rootScope.trkID; } });
	 */
   	
	        
	  }
	  
	  

			  $scope.trukDtl={
				 truckId:$scope.trucktrailermodel.truckId,
				 truckName:$scope.trucktrailermodel.truckName,
				 trailerId:$scope.trucktrailermodel.trailerId,
				 trailerName:$scope.trucktrailermodel.trailerName,
				 fromDate:$scope.trucktrailermodel.fromDate,
				 toDate:$scope.trucktrailermodel.toDate,
				 trucktrailerId:$scope.trucktrailermodel.trucktrailerId,
				 }
			  
			 
			  $scope.getTruckNameById=function(){
				  var value1 = $scope.truckList;
				  angular.forEach(value1, function(value, key) {
					  if(value.id == $scope.trukDtl.truckId){
						  $scope.trukDtl.truckName=value.text;
					  }
					});
			  }
			  $scope.getTrailerNameById=function(){
				  var value2 = $scope.trailerList
				  angular.forEach(value2, function(value, key) {
					  if(value.id == $scope.trukDtl.trailerId){
						  $scope.trukDtl.trailerName=value.text;
					  }
					});
			  }
			  
		  $scope.monthSchedule=[];
		  $scope.monthScheduleTemp=[];
		  $scope.monthSchedule1=[];
		  $rootScope.evtList=[];
		  $scope.evtListTemp=[];
	      $scope.trEvt=[];
	      $scope.trRes=[];
	      $scope.showShdBtn=false;
		  
		 /*
			 * $scope.$watch('trucktrailermodel.fromDate', function(newValue,
			 * oldValue) {
			 * 
			 * var d = $filter('date')($scope.trucktrailermodel.fromDate,
			 * "yyyy-mm-dd") var a = $scope.trucktrailermodel.fromDate; var x =
			 * a.split('/') var d=x[1]+'/'+x[0]+'/'+x[2]; $rootScope.goToDate=d;
			 * if( $rootScope.evtList.length > 0){
			 * $rootScope.$emit("goToSelectedDate",{}); } });
			 * 
			 * $scope.$watch('trucktrailermodel.truckId', function(newValue,
			 * oldValue) {
			 * $scope.trukDtl.truckId=$scope.trucktrailermodel.truckId;
			 * if($scope.trucktrailermodel.truckId !='' &&
			 * $scope.trucktrailermodel.truckId != undefined){
			 * $http.post($stateParams.tenantid+'/trucktrailermapping/getTruckDltById',$scope.trukDtl).success(function(datas) {
			 * $scope.loadScheCalValues(datas,'1'); }).error(function(datas) {
			 * 
			 * }); }else{ if($scope.trucktrailermodel.truckId !='' ||
			 * $scope.trucktrailermodel.truckId != undefined){
			 * $scope.loadEmptyValues('1');
			 *  } }
			 * 
			 * });
			 * 
			 * $scope.$watch('trucktrailermodel.trailerId', function(newValue,
			 * oldValue) {
			 * $scope.trukDtl.trailerId=$scope.trucktrailermodel.trailerId;
			 * if($scope.trucktrailermodel.trailerId !='' &&
			 * $scope.trucktrailermodel.trailerId != undefined){
			 * $http.post($stateParams.tenantid+'/trucktrailermapping/getTrailerDltById',$scope.trukDtl).success(function(datas) {
			 * 
			 * $scope.loadScheCalValues(datas,'2') }).error(function(datas) {
			 * 
			 * }); }else{ if($scope.trucktrailermodel.trailerId !='' ||
			 * $scope.trucktrailermodel.trailerId != undefined){
			 * 
			 * $scope.loadEmptyValues('2');
			 *  } }
			 * 
			 * });
			 */
	     
	     
	     /*
			 * $scope.loadScheCalValues=function(datas,num){
			 * $scope.monthScheduleTemp =[]; $scope.monthScheduleTemp =datas;
			 * 
			 * $scope.trRes=[] if($scope.monthScheduleTemp.length > 0){
			 * $scope.evtListTemp=[]; if($rootScope.evtList.length > 0){ var
			 * monSch1 =$rootScope.evtList; $scope.evtListTemp=[];
			 * angular.forEach(monSch1, function(value, key) { $scope.trRes=[];
			 * if(value.id !=num && value.start != ''){
			 * $scope.trRes.id=value.id, $scope.trRes.text=value.text,
			 * $scope.trRes.resource=value.resource,
			 * $scope.trRes.start=value.start, $scope.trRes.end=value.end,
			 * $scope.trRes.bubbleHtml=value.bubbleHtml
			 * $scope.trRes.moveDisabled=true; $scope.trRes.resizeDisabled=true;
			 * $scope.evtListTemp.push($scope.trRes); }
			 * 
			 * }); }
			 * 
			 * var monSch2 =$scope.monthScheduleTemp; if(monSch2.length >= 1){
			 * angular.forEach(monSch2, function(value, key) { $scope.trRes=[];
			 * if(value.id ==num && value.start != ''){
			 * $scope.trRes.id=value.id, $scope.trRes.text=value.title;
			 * $scope.trRes.resource=value.id;
			 * $scope.trRes.start=value.start.length > 0 ?
			 * value.start+"T00:00:00" : ""; $scope.trRes.end=value.end.length >
			 * 0 ? value.end+"T12:50:00" : ""; var fD =
			 * $filter('date')(value.start, "dd-MM-y"); var tD =
			 * $filter('date')(value.end, "dd-MM-y");
			 * $scope.trRes.moveDisabled=true; $scope.trRes.resizeDisabled=true;
			 * $scope.trRes.bubbleHtml='<div style="background-color:
			 * #46bde2;border:2px solid #181818;padding:3px;">'+'<span
			 * style="color:#011954">'+'Truck '+'&nbsp;&nbsp;&nbsp;'+': '+'</span>'+'<span
			 * style="color:#fff">'+value.mtitle+'</span>'+'<br/>'+'<span
			 * style="color:#0d308f">'+'<span style="color:#011954">'+'Trailer
			 * '+'&nbsp;&nbsp;'+': '+'</span>'+'<span
			 * style="color:#fff">'+value.trailerName+'</span>'+'<br/>'+'<span
			 * style="color:#011954">'+'Start '+'&nbsp;&nbsp;&nbsp;&nbsp;'+':
			 * '+'</span>'+'<span style="color:#fff">'+fD+'</span>'+'<br/>'+'<span
			 * style="color:#011954">'+'End
			 * '+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+': '+'</span>'+'<span
			 * style="color:#fff">'+tD+'</span>'+'</div>';
			 * $scope.evtListTemp.push($scope.trRes); }
			 * 
			 * }); }
			 *  }
			 * 
			 * if($scope.evtListTemp.length ==0){ $rootScope.evtList=[]; }else{
			 * $rootScope.evtList=$scope.evtListTemp; } $scope.showShdBtn=true;
			 * $rootScope.$emit("CallSchLoadMethod", {}); }
			 * 
			 * $scope.loadEmptyValues=function(num){
			 * 
			 * var monSch2 = $rootScope.evtList; if(monSch2.length > 0){
			 * $scope.evtListTemp=[]; angular.forEach(monSch2, function(value,
			 * key) { $scope.trRes=[]; if(value.id !=num){
			 * $scope.trRes.id=value.id, $scope.trRes.text=value.text,
			 * $scope.trRes.resource=value.resource,
			 * $scope.trRes.start=value.start, $scope.trRes.end=value.end,
			 * $scope.trRes.bubbleHtml=value.bubbleHtml
			 * $scope.trRes.moveDisabled=true; $scope.trRes.resizeDisabled=true;
			 * $scope.evtListTemp.push($scope.trRes); }
			 * 
			 * }); $rootScope.evtList=[]; $rootScope.evtList=$scope.evtListTemp;
			 * if($rootScope.evtList.length==0){ $scope.showShdBtn=false;
			 * $rootScope.$emit("hideScheduler", {}); }else{
			 * $scope.showShdBtn=true; $rootScope.$emit("CallSchLoadMethod",
			 * {}); } }
			 *  }
			 */
	       

	    
});


/*
 * var tripAddApp = angular.module('main', [ 'daypilot' ]);
 * 
 * 'use strict'; tripAddApp.controller('DemoCtrl', function($scope, $rootScope,
 * ngDialog, $http, $location, logger, utilsService, $state, sharedProperties,
 * $window, validationService, toaster, $stateParams, $filter) {
 * 
 * $scope.showShedr = false;
 * 
 * $scope.scheEvntList = [];
 * 
 * $rootScope.$on("CallSchLoadMethod", function() { $scope.loadCurrMonDate();
 * }); $rootScope.$on("goToSelectedDate", function() { var d =
 * $rootScope.goToDate; var x = d.split('/') var da = new Date(x[2], x[0] - 1,
 * x[1]) $scope.loadGoToDate(da);
 * 
 * });
 * 
 * $rootScope.$on("hideScheduler", function() { $scope.showShedr = false; })
 * 
 * $scope.childMethod = function(date, days) { $scope.showShedr = true;
 * $scope.scheEvntList = $rootScope.sch; $scope.loadScheduleCal(date, days); var
 * date = new Date(); var d = $filter('date')( new Date(date.getFullYear(),
 * date.getMonth() + 1, 1), "yyyy-mm-dd") $scope.scrollTo(d); }
 * 
 * $scope.loadScheduleCal = function(date, days) { $scope.evtLt = []
 * $scope.evtLt = $rootScope.evtList; $scope.config = {} $scope.config = { scale :
 * "Day", days : days, bubble : new DayPilot.Bubble(), startDate : new
 * Date(date.getFullYear(), date.getMonth(), 2),
 * 
 * timeHeaders : [ { groupBy : "Month" }, { groupBy : "Cell", format : "d" } ],
 * resources : [ { name : "Truck", id : "1" }, { name : "Trailer", id : "2" } ],
 * 
 * rowMinHeight : 50, rowMinWidth : 50, headerHeight : 40, durationBarVisible :
 * false, durationBarColor : "red", barBackColor : "red", cellWidthSpec :
 * 'Auto',
 *  }; $scope.events = [];
 * 
 * //this update for update EVENTS without this method it won't update
 * 
 * $http.post($stateParams.tenantid+'/truckSchedule/updateValue').success(function(data) {
 * if(data.success = true){ $scope.events =$rootScope.evtList; } });
 * 
 *  }
 * 
 * $scope.scrollTo = function(date) { $scope.dp.scrollTo(date); };
 * 
 * $scope.loadCurrMonDate = function() { var date; var sp =
 * $rootScope.goToDate.split('/'); if (sp[1].length > 0) { var d =
 * $rootScope.goToDate; var x = d.split('/') date = new Date(x[2], x[0] - 1,
 * x[1]); } else { date = new Date(); }
 * 
 * $scope.CurrDt = date; var firstDay = new Date(date.getFullYear(),
 * date.getMonth(), 1); var lastDay = new Date(date.getFullYear(),
 * date.getMonth() + 1, 0); var diff = new Date(lastDay - firstDay); var days =
 * diff / 1000 / 60 / 60 / 24; days = days + 1; $scope.childMethod(date, days); }
 * 
 * $scope.loadGoToDate = function(date) { if (date.getFullYear() > 0) {
 * $scope.CurrDt = date; var firstDay = new Date(date.getFullYear(),
 * date.getMonth(), 1); var lastDay = new Date(date.getFullYear(),
 * date.getMonth() + 1, 0); var diff = new Date(lastDay - firstDay); var days =
 * diff / 1000 / 60 / 60 / 24; days = days + 1; $scope.childMethod(date, days); } }
 * 
 * $scope.gotoNextYear = function() { var d = $scope.CurrDt; var m; var y; var
 * dys; if (d.getMonth() == 11) { m = 0; y = d.getFullYear() + 1 } else { m =
 * d.getMonth() + 1; y = d.getFullYear() } var firstDay = new Date(y, m, 1); var
 * lastDay = new Date(y, m + 1, 0); var diff = new Date(lastDay - firstDay); dys =
 * diff / 1000 / 60 / 60 / 24; dys = dys + 1; $scope.CurrDt = new Date(y, m, 1)
 * var date = $scope.CurrDt; $scope.childMethod(date, dys);
 *  }
 * 
 * $scope.gotoPrevYear = function() { var d = $scope.CurrDt; var m; var y; var
 * dys; if (d.getMonth() == 11) { m = 10; y = d.getFullYear() } else { m =
 * d.getMonth() - 1; y = d.getFullYear() } var firstDay = new Date(y, m, 1); var
 * lastDay = new Date(y, m + 1, 0); var diff = new Date(lastDay - firstDay); dys =
 * diff / 1000 / 60 / 60 / 24; dys = dys + 1; $scope.CurrDt = new Date(y, m, 1)
 * var date = $scope.CurrDt; $scope.childMethod(date, dys); }
 * 
 * });
 */


