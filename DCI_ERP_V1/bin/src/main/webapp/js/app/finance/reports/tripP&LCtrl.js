'use strict';
app
		.controller(
				'tripP&LCtrl',
				function($templateCache, $scope, $rootScope, $http, logger,
						$log, ngDialog, $modal, $location, $sce, $filter,
						$stateParams, validationService, toaster, $timeout,
						$state) {

					$('#tb_fromDate').datetimepicker({
						format : 'DD/MM/YYYY'
					});

					$('#tb_toDate').datetimepicker({
						format : 'DD/MM/YYYY'
					});

					var d = new Date();
					var year = d.getFullYear();
					var month = d.getMonth() + 1;
					if (month < 10) {
						month = "0" + month;
					}
					;
					var day = d.getDate();
					var todayDate = day + "/" + month + "/" + year;

					$scope.tripPandL = {

						companyName : '',

						fromDate : todayDate,
						toDate : todayDate,

					}

					$http
							.get(
									$stateParams.tenantid
											+ '/app/usermaster/getCompanyList?formCode='
											+ $('#form_code_id').val())
							.success(function(datas) {
								debugger;
								$scope.tempCompanyList = datas;
								$scope.companyList = datas;
								$scope.tripPandL.companyName = datas[0].id;

							}).error(function(datas) {
							});

					$scope.view = function(tripPandLForm, tripPandL) {

						/* $state.go('app.mis.tripp&l-list',{companyName:$scope.tripPandL.companyName}); */

						$location.url($stateParams.tenantid
								+ '/reports/tripp&llist?companyName='
								+ $scope.tripPandL.companyName + '&fromDt='
								+ $scope.tripPandL.fromDate + '&toDt='
								+ $scope.tripPandL.toDate);
					}

					$scope
							.$watch(
									'[tripPandL.fromDate,tripPandL.toDate]',
									function(newValue) {

										if (newValue != "") {
											if ($scope.tripPandL.fromDate != ''
													&& $scope.tripPandL.toDate != '') {
												var fromDate = $scope.tripPandL.fromDate;
												var toDate = $scope.tripPandL.toDate;
												fromDate = fromDate.split("/");
												fromDate = new Date(
														fromDate[2],
														fromDate[1],
														fromDate[0]);
												toDate = toDate.split("/");
												toDate = new Date(toDate[2],
														toDate[1], toDate[0]);
												if (fromDate <= toDate) {

												} else {
													$scope.tripPandL.toDate = '';
													logger
															.logError("To Date Should be greater than From Date");
												}
											}
										}
									});

					$scope.reset = function() {

						// $scope.tripPandL.companyName = '';
						$scope.tripPandL.fromDate = '';
						$scope.tripPandL.toDate = '';

					}

				});

app.controller('tripP&LViewCtrl', function($templateCache, $scope, $rootScope,
		$http, logger, $log, ngDialog, $modal, $location, $sce, $filter,
		$stateParams, validationService, toaster, $timeout, $state) {

	var companyName = $location.search().companyName;
	var fromDate = $location.search().fromDt;
	var toDate = $location.search().toDt;

	$scope.rowCollection = [];
	$scope.rowCollection1 = [];
	$scope.displayedCollection = [];
	$scope.displayedCollection1 = [];

	$scope.tripPandL = {

		companyName : companyName,
		fromDate : fromDate,
		toDate : toDate,

	}

	$scope.getList = function() {
		$http.post($stateParams.tenantid + '/app/tripPandL/list',
				$scope.tripPandL).success(function(datas) {
			$scope.rowCollection = datas.list;
			$scope.rowCollection1 = datas.list1;

			angular.forEach($scope.rowCollection, function(value, key) {

				if (value.revenue == null) {

					value.revenue = "-";

				}
				if (value.cost == null) {

					value.cost = "-";

				}
			

			});
			
			angular.forEach($scope.rowCollection1, function(value, key) {

				if (value.revenue == null) {

					value.revenue = "-";

				}
				if (value.cost == null) {

					value.cost = "-";

				}
			

			});

		}).error(function(datas) {
		});
	}
	$scope.getList();

	$scope.cancel = function() {
		$state.go('app.mis.tripp&l');
	}

});
