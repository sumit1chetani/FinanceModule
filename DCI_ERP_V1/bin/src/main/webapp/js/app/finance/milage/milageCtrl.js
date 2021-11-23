'use strict';

app.controller('milageCtrl', function($scope, $rootScope, $http, $location,
		logger, utilsService, ngDialog, $state, sharedProperties, $window,
		$stateParams) {
	$scope.dataLoopCount = 0;
	$scope.offsetCount = 0;
	$scope.limitCount = 1000;
	$scope.updatedData = [];
	$scope.rowCollection = [];
	$scope.displayedCollection = [];

	$scope.itemsByPage = 10;

	$scope.add = function() {
		$state.go('app.operation.milage.add', {
			tenantid : $stateParams.tenantid
		});
	};

	$scope.getList = function() {
		$http.get($stateParams.tenantid + '/finance/milage/list').success(
				function(datas) {
					console.log(datas);
					$scope.rowCollection = datas.headerList;

				}).error(function(datas) {
		});
	};
	$scope.getList();

	$scope.editRow = function(milageId) {

		$location.url($stateParams.tenantid + '/operation/milage/edit?milageId='
				+ milageId);
	}

	$scope.viewRow = function(milageId) {
		$location.url($stateParams.tenantid + '/operation/milage/view?milageId='
				+ milageId);
	}

	$scope.deleteRow = function(milageId) {
		$http.post($stateParams.tenantid + '/finance/milage/delete', milageId)
				.success(function(data) {
					if (data.success) {
						logger.logSuccess("Deleted Successfully");
						$scope.getList();
						
					} else {
						logger.logError("Unable to delete!");
					}
				}).error(function(data) {
					logger.logError("Error Please Try Again");
				});
	}

});

app
		.controller(
				'milageAddCtrl',
				function($scope, toaster, $rootScope, $http, $location,
						validationService, logger, utilsService, ngDialog,
						$state, sharedProperties, $window, $stateParams) {

					$scope.isEdit = false

					$scope.millage = {
						tripId : '',
						tripNo : '',
						truckId : '',
						truckName : '',
						driverId : '',
						driverName : '',
						fromLocation : '',
						toLocation : '',
						trailer : '',
						noofdays : '',
						milageAmount : '0'

					}

					//$scope.tripTypeList = [];
					$http.get($stateParams.tenantid + '/finance/milage/trip')
							.success(function(datas) {
								console.log(datas);
								$scope.tripTypeList = datas.selectivitybean;
							}).error(function(data) {
								logger.logError("Unable to fetch");
							});

					$scope
							.$watch(
									'millage.tripId',
									function(newValue, oldValue) {
										if (newValue != ''
												&& newValue != undefined) {

											$http
													.get(
															$stateParams.tenantid
																	+ '/finance/milage/getDropdown?tripId='
																	+ newValue)
													.success(
															function(datas) {
																console
																		.log(datas);

																$scope.millage.truckName = datas.milageBean.truckName;
																$scope.millage.trailer = datas.milageBean.trailer;
																$scope.millage.toLocation = datas.milageBean.toLocation;
																$scope.millage.fromLocation = datas.milageBean.fromLocation;
																$scope.millage.driverName = datas.driverName;


															}).error(
															function(datas) {
															});
										}
									});

					$scope.save = function(millage, millageForm) {
						if (new validationService()
								.checkFormValidity(millageForm)) {

							$http.post(
									$stateParams.tenantid
											+ '/finance/milage/save',
									$scope.millage).success(function(data) {
								if (data) {
									logger.logSuccess('Saved Successfully');
									$scope.cancel();
								} else {
									logger.logError('Unable to save!');
								}

							});
						} else {
							toaster
									.pop(
											'error',
											"Please fill the required fields",
											logger
													.getErrorHtmlNew(millageForm.$validationSummary),
											5000, 'trustedHtml');
						}
					}

					var milageId = $location.search().milageId;
					
					if (milageId != null && milageId != undefined
							&& milageId > 0) {
						$scope.isEdit = true;
						$scope.isView = false;
						$http.post(
								$stateParams.tenantid
										+ '/finance/milage/edit?milageId='
										+ milageId).success(function(data) {
							if (data.success) {
								console.log("edit");
								console.log(data);
								$scope.millage = data.milageBean;
								$scope.millage.driverName = data.driverName;

							} else {
								logger.logError("Unable to fetch data");
							}
						});
					}

					$scope.update = function(millage, millageForm) {
						if (new validationService()
								.checkFormValidity(millageForm)) {

							$http.post(
									$stateParams.tenantid
											+ '/finance/milage/update',
									$scope.millage).success(function(data) {

								if (data) {
									logger.logSuccess('Updated Successfully');
									$scope.cancel();
								} else {
									logger.logError('Unable to Update!');
								}
							});
						} else {
							toaster
									.pop(
											'error',
											"Please fill the required fields",
											logger
													.getErrorHtmlNew(workShopForm.$validationSummary),
											5000, 'trustedHtml');
						}
					}
					$scope.reset = function() {

						if (isEdit == true) {
							$http.post(
									$stateParams.tenantid
											+ '/finance/milage/edit?milageId='
											+ milageId).success(function(data) {
								if (data.success) {
									console.log("edit");
									console.log(data);
									$scope.millage = data.milageBean;
								} else {
									logger.logError("Unable to fetch data");
								}
							});
						} else {
							$scope.millage.truckName = '';
							$scope.millage.trailer = '';
							$scope.millage.toLocation = '';
							$scope.millage.driver = '';
							$scope.millage.fromLocation = '';
							$scope.millage.tripId = '';
							$scope.millage.milageAmount = '';
							$scope.millage.noofdays = '';
						}

					}
					$scope.cancel = function() {
						$state.go('app.operation.milage.list', {
							tenantid : $stateParams.tenantid
						});

					}

				});