'use strict';
app.controller('driverScheduleCtrl',function($templateCache, $scope, $state, $http, ngDialog,
						logger, $location, $controller, $injector,
						sharedProperties, toaster, $rootScope, $stateParams,
						$filter, validationService) {

					$scope.evtList = {
						start : '',
						end : '',
						title : '',
						url : '',
						id : ''

					}
					$scope.driverSelectivity = [];
					$scope.driverSelected = '';

					$scope.select = {
						category : ''
					}

					$http.post($stateParams.tenantid+ '/driverSchedule/driverSelectiviry').success(function(data) {
										if (data.success = true) {
											$scope.driverSelectivity = data.selectivityBean;
											$scope.loadCalValues();
										}
									});

					$scope.searchDriver = function() {
						
						if ($scope.select.category == 'trip') {
							if($scope.driverSelected !=''){
								$http.post($stateParams.tenantid+ '/driverSchedule/searchByTrip',$scope.driverSelected).success(
										function(data) {
											if (data.success = true) {
												$scope.evtList = data.driverSchedule;
												$scope.displayTime = true;
												$scope.loadCalValues();

											}
										});
							}else{
								logger.logError("Please Select Driver");
							}
							
						} else if ($scope.select.category == 'truck') {
							if($scope.driverSelected !=''){
								$http.post($stateParams.tenantid+ '/driverSchedule/searchByTruck',$scope.driverSelected).success(
										function(data) {
											if (data.success = true) {
												$scope.evtList = data.driverSchedule;
												$scope.displayTime = false;
												$scope.loadCalValues();

											}
										});
							}else{
								logger.logError("Please Select Driver");
							}
							
						}

					}

					$scope.planTripId = '';
					$scope.truckId = '';
					$scope.loadCalValues = function() {
						$('#calendar').fullCalendar('destroy');
						$('#calendar').fullCalendar(
										{
											schedulerLicenseKey: 'GPL-My-Project-Is-Open-Source',
											header : {
												left : 'prev,next today',
												center : 'title',
												right : 'month,agendaWeek,agendaDay,listWeek'
											},
											defaultDate : new Date(),
											navLinks : true, // can click
																// day/week
																// names to
																// navigate
																// views
											editable : false,
											eventLimit : true, // allow "more"
																// link when too
																// many events
											events : $scope.evtList,
											displayEventTime : $scope.displayTime,
											eventClick : function(calEvent,
													jsEvent, view) {
												// For click Event display
												/*
												 * alert('Event: ' +
												 * calEvent.title);
												 * alert('Coordinates: ' +
												 * jsEvent.pageX + ',' +
												 * jsEvent.pageY); alert('View: ' +
												 * view.name);
												 *  // change the border color
												 * just for fun
												 * $(this).css('border-color',
												 * 'red');
												 */

												$scope.planTripId = calEvent.tripId;
												$scope.truckId = calEvent.truckId;
												$scope.viewDriverEvents($scope,
														$http, ngDialog,
														logger, $injector,
														sharedProperties,
														toaster, $rootScope);
											}
										});
					}

					$scope.viewDriverEvents = function($scope, $http, ngDialog,
							logger, $injector, sharedProperties, toaster,
							$rootScope) {
						ngDialog.open({
							template : 'driverScheduleAlert',
							scope : $scope,
							controller : $controller('driverScheduleCtrl', {
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
					$scope.driverTripView = [];
					$scope.driverTruckView = [];
					$scope.drView = {
						isTruck : false,
						id : '',
						truck : '',
						start : '',
						end : '',
						fromLoc : '',
						toLoc : '',
						driverName : ''
					}

					app.controller('driverScheduleCtrl',function($scope, $timeout, $stateParams,$filter, $rootScope, $http,
						$location, logger, $state, ngDialog) {
					if ($scope.truckViewId != '') {

						if ($scope.select.category == 'trip') {
							$http.post($stateParams.tenantid+ '/driverSchedule/viewByTrip',$scope.planTripId).success(
							function(data) {
								if (data.success = true) {
									$scope.driverTripView = data.driverSchedule;
									$scope.drView.driverName = $scope.driverTripView[0].driverName;
									$scope.drView.start = $scope.driverTripView[0].etd;
									$scope.drView.end = $scope.driverTripView[0].eta;
									$scope.drView.fromLoc = $scope.driverTripView[0].fromLocation;
									$scope.drView.toLoc = $scope.driverTripView[0].toLocation;
									$scope.drView.isTruck = true;

								}
							});
						} else if ($scope.select.category == 'truck') {
							$http.post($stateParams.tenantid+ '/driverSchedule/viewByTruck',$scope.truckId).success(
							function(data) {
								if (data.success = true) {
									$scope.driverTruckView = data.driverSchedule;
									$scope.drView.driverName = $scope.driverTruckView[0].driverName;
									$scope.drView.start = $scope.driverTruckView[0].etd;
									$scope.drView.end = $scope.driverTruckView[0].eta;
									$scope.drView.truck = $scope.driverTruckView[0].truckName;
									$scope.drView.isTruck = false;
	
								}
							});
						}

					}
				});

				});
