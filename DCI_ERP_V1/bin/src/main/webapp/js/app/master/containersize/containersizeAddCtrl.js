'use strict';

app.controller('containersizeaddCtrl', function($scope, $rootScope, $http,
		$location, logger, utilsService, $state, sharedProperties, $window,
		validationService, toaster, $stateParams) {
	$scope.offsetCount = 0;
	$scope.limitCount = 1000;
	$scope.edit = true;
	$scope.containersize = {
		containerid : '',
		code : '',
		name : '',
		description : '',
		isActive : true
	};

	$scope.cancel = function() {
		$state.go("app.master.containersize.list", {
			tenantid : $stateParams.tenantid
		});
	};

	/*
	 * $scope.cityList=[]; $scope.test=function(){
	 * $http.get($stateParams.tenantid+'/iata/citylist').success(function(datas) {
	 * console.log(datas); $scope.cityList = datas.selectivitybean;
	 * 
	 * 
	 * 
	 * }).error(function(data) {
	 * 
	 * });
	 * 
	 *  } $scope.test();
	 */

	// edit
	var editid = $location.search().rowid;
	var test = parseInt(editid);
	if (test) {
		$scope.edit = false;
		$http.post($stateParams.tenantid + '/containersize/edit', test)
				.success(function(result) {
					console.log(result);
					$scope.containersize = result;
					// $scope.port.city = result.city.toString();
					if (result.isStstus == "t") {
						$scope.containersize.isActive = true;
					} else {
						$scope.containersize.isActive = false;
					}
				});
	}

	$scope.validate = function(containersizeForm) {
		// if (new validationService().checkFormValidity(portForm)) {
		if ($scope.edit) {
			$scope.save($scope.containersize, containersizeForm);
		} else {
			$scope.update($scope.containersize, containersizeForm);
		}
	} /*
		 * else { toaster.pop('error', "Please fill the required fields",
		 * logger.getErrorHtmlNew(portForm.$validationSummary),5000,
		 * 'trustedHtml'); }
		 */
	// };

	// save
	$scope.save = function(containersize, containersizeForm) {
		console.log($scope.containersize);
    	var msg = $scope.checkValidation();
    	if (!$scope.checkundefined(msg)) {
			logger.logError(msg);
    	}else{
		$http.post($stateParams.tenantid + '/containersize/save',
				$scope.containersize).success(function(result) {
			console.log(result);
			if (result == 1) {
				logger.logSuccess("Saved Successfully!");
				$state.go("app.master.containersize.list", {
					tenantid : $stateParams.tenantid
				});
			} else {
				logger.logError("Name Already Exists");
			}
		});
    	}
	};
	  $scope.checkValidation = function() {

			var alertmsg = "<ui><h4>Please fill the required fields</h4>";
			var msg = "";
			if ($scope.checkundefined($scope.containersize.code)) {
				msg = msg + "<li>Container Code :Field is required.</li>";
				$scope.changecolor('Code');
			} else {
				$scope.clearcolor('Code');
			}
			if ($scope.checkundefined($scope.containersize.name)) {
				msg = msg + "<li>Container Name :Field is required.</li>";
				$scope.changecolor('Name');
			} else {
				$scope.clearcolor('Name');
			}
			alertmsg = alertmsg + msg + "</ui>";
			if ($scope.checkundefined(msg)) {
				return '';
			} else {
				return alertmsg;
			}
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

	// update
	$scope.update = function(containersize, containersizeForm) {
		console.log($scope.containersize);
    	var msg = $scope.checkValidation();
    	if (!$scope.checkundefined(msg)) {
			logger.logError(msg);
    	}
    	else
    		{
		$http.post($stateParams.tenantid + '/containersize/update',
				$scope.containersize).success(function(result) {
			console.log(result);
			if (result == 1) {
				logger.logSuccess("Update Successfully!");
				$state.go("app.master.containersize.list", {
					tenantid : $stateParams.tenantid
				});
			} else {
				logger.logError(result.message);
			}
		});
    		}
	};
	$scope.reset = function(containersizeForm) {

		if ($scope.isEdit = true) {

			$scope.containersize.containerid = '';
			$scope.containersize.code = '';
			$scope.containersize.name = '';
			$scope.containersize.description = '';
			$scope.containersize.isActive = '';

			$http.post($stateParams.tenantid + '/containersize/edit', test)
					.success(function(result) {
						console.log(result);
						$scope.containersize = result;
						$scope.containersize.city = result.city.toString();
						if (result.isStstus == "t") {
							$scope.containersize.isActive = true;
						} else {
							$scope.containersize.isActive = false;
						}
					});
		} else {
			$scope.containersize.containerid = '';
			$scope.containersize.code = '';
			$scope.containersize.name = '';
			$scope.containersize.description = '';
			$scope.containersize.isActive = '';

		}
		$scope.monthSchedule = '';
		$('#truckTrailMapScheduler').fullCalendar('destroy');

	}

});

/*
 * 'use strict'; app.filter('concatAcctHeadName', function() { return
 * function(input, viewValue) { if (input && input.length) { var obj = {};
 * obj.accountHeadName = viewValue; if (input.indexOf(viewValue) === -1) {
 * input.unshift(obj); } return input; } else { return []; } }; });
 */