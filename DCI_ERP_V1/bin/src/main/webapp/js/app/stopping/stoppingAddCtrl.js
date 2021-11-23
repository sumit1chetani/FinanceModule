'use strict';

app.controller('manageLocationAddCtrl', function($scope, $rootScope, $http,
		$location, logger, utilsService, $state, sharedProperties, $window,
		validationService, toaster, $stateParams) {

	$scope.offsetCount = 0;
	$scope.limitCount = 1000;
	$scope.isEdit = false;

	$scope.location = {

		locationName : '',
		shortName : '',
		type : '',
		longitude : '',
		latitude : '',
		landMark : '',
		description : '',
		countryId :'',

	};

	$scope.typeList = [ {
		id : 'Port',
		text : 'Port'
	}, {
		id : 'Others',
		text : 'Others'
	} ];
	
	
	
	$http.get($stateParams.tenantid+'/locationmaster/countryList').success(function(datas) {
       
        $scope.countryList = datas.countryList;
    	
        })
	
	
	

	$scope.validate = function(location, locationForm) {

		if (new validationService().checkFormValidity(locationForm)) {
			if (!$scope.isEdit) {
				$scope.save(location, locationForm);
			} else {
				$scope.update(location, locationForm);
			}
		} else {
			toaster.pop('error', "Please fill the required fields", logger
					.getErrorHtmlNew(locationForm.$validationSummary), 5000,
					'trustedHtml');
		}
	};

	/*
	 * $scope.validate = function(locationForm) { if
	 * ($scope.location.locationName != '' && $scope.location.shortName != '' &&
	 * $scope.location.type != '') { if (!$scope.isEdit) {
	 * $scope.save(locationForm); } else { $scope.update(locationForm); } } else {
	 * logger.logError("Please fill all mandatory fields"); } };
	 */

	$scope.save = function(locationForm) {

		$http.post($stateParams.tenantid + '/locationmaster/save',
				$scope.location).success(function(result) {

			if (result.locationErrorMessage == false) {

				if (result.shortNameErrorMessage == false) {

					if (result.success == true) {

						logger.logSuccess("Saved Successfully!");
						$state.go("app.truck.general.stopping.list", {
							tenantid : $stateParams.tenantid
						});

					} else {
						logger.logError("Error in Save");
					}

				} else {
					logger.logError("Short Name already Exist");
				}

			} else {
				logger.logError("Location Name already Exist");
			}

		});
	}

	var editId = $location.search().locationId;

	$scope.getEdit = function() {

		if (editId) {
			$scope.isEdit = true;
			$http.post($stateParams.tenantid + '/locationmaster/edit', editId)
					.success(function(result) {

						$scope.location.locationId = result.locationId

						$scope.location.locationName = result.locationName
						$scope.location.shortName = result.shortName
						$scope.location.longitude = result.longitude
						$scope.location.type = result.type
						$scope.location.latitude = result.latitude
						$scope.location.landMark = result.landMark
						$scope.location.description = result.description
						$scope.location.countryId = result.countryId

					});
		}
	}
	$scope.getEdit();

	$scope.update = function(locationForm) {

		$http.post($stateParams.tenantid + '/locationmaster/update',
				$scope.location).success(function(response) {

			if (response.locationErrorMessage == false) {

				if (response.shortNameErrorMessage == false) {

					if (response.success == true) {

						logger.logSuccess("Updated Succesfully!");
						$state.go("app.truck.general.stopping.list", {
							tenantid : $stateParams.tenantid
						});

					} else {
						logger.logError("Error in Update");
					}

				} else {
					logger.logError("Short Name already Exist");
				}

			} else {
				logger.logError("Location Name already Exist");
			}

		});

	};

	$scope.reset = function(locationForm) {

		$scope.location.locationName = '';
		$scope.location.shortName = '';
		$scope.location.longitude = '';
		$scope.location.type = '';
		$scope.location.latitude = '';
		$scope.location.landMark = '';
		$scope.location.description = '';
		$scope.location.countryId  = '';


	}

	$scope.reset1 = function(locationForm) {
		$scope.getEdit();
	}

	$scope.cancel = function() {
		$state.go("app.truck.general.stopping.list", {
			tenantid : $stateParams.tenantid
		});
	}

});
