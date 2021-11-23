//list
app.controller('tripStatusUpdateCtrl',function($scope, $timeout, $stateParams, $filter, $rootScope,$http, $location, logger, utilsService, $state,sharedProperties, $window, ngDialog, $interval,
						validationService, toaster, $controller, $injector) {
	
					$scope.rowCollection = [];

					$scope.tripnew = function() {
						var modalInstance = $modal.open({
							templateUrl : 'views/trip/tripadd.html',
							controller : 'tripAddCtrl',
							preCloseCallback : $scope.getList
						});
					};

					$http.get(
							$stateParams.tenantid
									+ '/app/commonUtility/getTripList')
							.success(function(datas) {
								$scope.tripList = datas;
							}).error(function(datas) {
							});

					$scope.trip = {
						tripId : '',
						technicalStatusId : '',
						tripStatusId : '',
						statusDate : '',
						defId : '',
						latitude : '',
						longitude :  ''
							
					}
					
					
					 $('#statusDate').datetimepicker({
						 defaultDate: new Date(),
						    format: 'DD/MM/YYYY hh:mm:ss',
						   
						});
					
					
					var today = new Date();var dd = today.getDate();var mm = today.getMonth() + 1; // January is 0!
					var yyyy = today.getFullYear();
					var hr = today.getHours();
					var mi = today.getMinutes();
					var ss = today.getSeconds();
					if (dd < 10) {dd = '0' + dd}
					if (mm < 10) {mm = '0' + mm}
					
					var dt = new Date();var 
					time = dt.getHours() + ":" + dt.getMinutes() + ":" + dt.getSeconds();

					var currentDate = dd + '/'+ mm + '/' + yyyy +" "+time;
					
	                $scope.trip.statusDate=currentDate;

					
					
					$scope.technicalStatusList = [];
					$scope.tripStatusList = [];
					$scope.tripStatusDiv = false;
					
					
					$scope.isDrive=false;


					$scope.techStatus = function(newValue) {
						
					    if ($scope.trip.statusDate != '') {
						
						ngDialog.open({
							template : 'UpdateStatusAlert',
							scope : $scope,
							controller : $controller('tripStatusCtrl', {
								$scope : $scope,
								$http : $http,
								data : $scope.trip,
								ngDialog : ngDialog,
								logger : logger,
								$injector : $injector,
								sharedProperties : sharedProperties,
								toaster : toaster,
								$rootScope : $rootScope
							}),
							closeByEscape : false,
						})
						
						if (newValue == 12 || newValue == 13 || newValue == 14) {
							$scope.tripStatusDiv = false;
							$scope.trip.tripStatusId = '';
							$scope.trip.defId = $scope.trip.technicalStatusId;

						} 
						else{
							
							$scope.tripStatusDiv = true;

						}
						
					      } else {
					    	  
				              logger.logError("Enter Status Date and Time");
				              $rootScope.getTripDetails();

					      }

					}
					

					$scope.technicalDiv=true;
					
					$scope.$watch('trip.tripId',function(newValue, oldValue) {

						if($scope.trip.tripId != null && $scope.trip.tripId != ''){
							
						$http.get($stateParams.tenantid+ '/mobile/webService/getCurrentStatusId?tripId='+ parseInt(newValue)).success(function(datas) {
							
						$scope.technicalStatusId = datas.technicalStatusId;
						$scope.trip.technicalStatusId= datas.technicalStatusId;
						$scope.tripStatusId = datas.mWebService.id;
						$scope.trip.defId = datas.mWebService.id;
						$scope.technicalDiv=false;
						
						if($scope.technicalStatusId == 0 || $scope.technicalStatusId == 13 || $scope.technicalStatusId == 14){

							$scope.tripStatusDiv = false;
							$scope.isRest=true;
							$scope.technicaDisable=true;

						}
						else{
							
							$scope.tripStatusDiv = true;
						}
						
						if($scope.technicalStatusId == 12){
							
							$scope.isDrive=true;
							$scope.isRest=false;
							$scope.technicaDisable=false;

						}
						if($scope.technicalStatusId == 13){
							
							$scope.isRest=true;
							$scope.isDrive=false;
							$scope.technicaDisable=false;

						}
						if($scope.technicalStatusId == 14){
							
							$scope.technicaDisable=true;
							$scope.isRest=false;
							$scope.isDrive=false;

						}
														
						if ($scope.technicalStatusId != null) {
						$scope.statusName = 'Technical';
							
						$http.get($stateParams.tenantid+ '/mobile/webService/getStatusListByStatusId?statusId='+ parseInt($scope.technicalStatusId)+ '&category='+ $scope.statusName).success(function(datas) {

								$scope.technicalStatusList = datas;
						})

						}
						else if ($scope.technicalStatusId == 0) {

								$http.get($stateParams.tenantid+ '/mobile/webService/getStatusListByStatusId?statusId=0&category='+ $scope.statusName).success(function(datas) {

									$scope.technicalStatusList = datas;

								})

					}

					if ($scope.tripStatusId != null) 
					{
						debugger
						$scope.statusName = 'Trip';
					
						$http.get($stateParams.tenantid+ '/mobile/webService/getStatusListByStatusId?statusId='+ parseInt($scope.tripStatusId)+ '&category='+ $scope.statusName).success(function(datas) {
																				
							$scope.tripStatusList = datas;

						})
																		

					} else if ($scope.technicalStatusId == 0) {

						$http.get($stateParams.tenantid+ '/mobile/webService/getStatusListByStatusId?statusId=0&category='+ $scope.statusName).success(function(datas) {
							
							$scope.tripStatusList = datas;

							})
																	

					}
															
															
					})
					}
				})
				
				
				$rootScope.getTripDetails = function(){
						
						$http.get($stateParams.tenantid+ '/mobile/webService/getCurrentStatusId?tripId='+ $scope.trip.tripId).success(function(datas) {
							
						$scope.technicalStatusId = datas.technicalStatusId;
						$scope.trip.technicalStatusId= datas.technicalStatusId;
						$scope.tripStatusId = datas.mWebService.id;
						$scope.trip.defId = datas.mWebService.id;
						$scope.technicalDiv=false;
						
						if($scope.technicalStatusId == 0 || $scope.technicalStatusId == 13 || $scope.technicalStatusId == 14){

							$scope.tripStatusDiv = false;
							$scope.isRest=true;
							$scope.technicaDisable=true;

						}
						else{
							
							$scope.tripStatusDiv = true;
						}
						
						if($scope.technicalStatusId == 12){
							
							$scope.isDrive=true;

						}
						if($scope.technicalStatusId == 12){
							
							$scope.isDrive=true;
							$scope.isRest=false;
							$scope.technicaDisable=false;

						}
						if($scope.technicalStatusId == 13){
							
							$scope.isRest=true;
							$scope.isDrive=false;
							$scope.technicaDisable=false;

						}
						if($scope.technicalStatusId == 14){
							
							$scope.technicaDisable=true;
							$scope.isRest=false;
							$scope.isDrive=false;

						}
														
						if ($scope.technicalStatusId != null) {
						$scope.statusName = 'Technical';
							
						$http.get($stateParams.tenantid+ '/mobile/webService/getStatusListByStatusId?statusId='+ parseInt($scope.technicalStatusId)+ '&category='+ $scope.statusName).success(function(datas) {

								$scope.technicalStatusList = datas;
						})

						}
						else if ($scope.technicalStatusId == 0) {

								$http.get($stateParams.tenantid+ '/mobile/webService/getStatusListByStatusId?statusId=0&category='+ $scope.statusName).success(function(datas) {

									$scope.technicalStatusList = datas;

								})

					}

					if ($scope.tripStatusId != null) 
					{
						debugger
						$scope.statusName = 'Trip';
					
						$http.get($stateParams.tenantid+ '/mobile/webService/getStatusListByStatusId?statusId='+ parseInt($scope.tripStatusId)+ '&category='+ $scope.statusName).success(function(datas) {
																				
							$scope.tripStatusList = datas;

						})
																		

					} else if ($scope.technicalStatusId == 0) {

						$http.get($stateParams.tenantid+ '/mobile/webService/getStatusListByStatusId?statusId=0&category='+ $scope.statusName).success(function(datas) {
							
							$scope.tripStatusList = datas;

							})
																	

					}
															
															
					})
				}

					


});


app.controller('tripStatusCtrl',function($scope, $timeout, $stateParams, $filter, $rootScope,$http, $location, logger, utilsService, $state,sharedProperties, $window, ngDialog, $interval,
		validationService, toaster, $controller, $injector) {
	
	
	$scope.updateStatus = function(statusId,TripForm) {
		

		
		var today = new Date();var dd = today.getDate();var mm = today.getMonth() + 1; // January is 0!
		var yyyy = today.getFullYear();
		var hr = today.getHours();
		var mi = today.getMinutes();
		var ss = today.getSeconds();
		if (dd < 10) {dd = '0' + dd}
		if (mm < 10) {mm = '0' + mm}
		
		var dt = new Date();var 
		time = dt.getHours() + ":" + dt.getMinutes() + ":" + dt.getSeconds();

		var currentDate = dd + '/'+ mm + '/' + yyyy +" "+time;
		
		
		

		$http.post($stateParams.tenantid+ '/mobile/webService/insertWebTripStatus',$scope.trip).success(function(datas) {
			
			if(datas.success= true){
				
                logger.logSuccess(datas.message);
                
                if($scope.trip.tripStatusId == 11){
                	
                	$state.reload();
                }
                
                $scope.trip.statusDate=currentDate;
                $scope.closeAlert();
			}
					
		}).error(function(datas) {
		});
	     
		
	}

	
	
	$scope.closeAlert = function(statusId,TripForm) {
		
		ngDialog.close();
		$rootScope.getTripDetails();
	
		
	}
	
	
	
	
});
