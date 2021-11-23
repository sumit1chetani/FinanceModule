
'use strict';
app.controller('serviceMasterListCtrl', function(sharedProperties, $window, $scope, $rootScope, $http, $location, logger, $log, ngDialog, $modal, utilsService, $state,$stateParams) {

	$scope.dataLoopCount = 0;
	$scope.offsetCount = 0;
	$scope.limitCount = 1000;
	$scope.updatedData = [];
	$scope.rowCollection = [];
	$scope.displayedCollection = [];
	$scope.itemsByPage = 75;
	$scope.sectorList = [];
	$scope.vesselList = [];
	
	 $scope.hideUploadIcon=true;

	$scope.serviceMasterData = {
		sectorCode : '',
		sectorName : '',

		operationSince : '',
		eqmtCntrlEnable : '',
		isActive : '',
		commenceDate : '',
		completionDate : '',
		companyCode : '',
		companyLocation : '',
		tables : []

	};

	$scope.getTranslationListUtil = function(limit, offset) {
		var url = $stateParams.tenantid+'/app/serviceMaster/list?limit=' + limit + '&offset=' + offset;
		$http.get(url).success(function(data) {
			if (data.success == true) {
				$scope.pushTranslationListUtil(data);
				console.log(data);
				$scope.dataLoopCount++;
			} else {
				if ($scope.dataLoopCount == 0) {
					$scope.showEmptyLabel = true;
				}
				logger.logError("Error Please Try Again");
			}
		}).error(function(data) {
			logger.logError("Error Please Try Again");
		});
	};

	$scope.pushTranslationListUtil = function(data) {
		if (utilsService.isUndefinedOrNull(data.lServiceMasterBean)) {
			console.log(lServiceMasterBean);
			if ($scope.dataLoopCount == 0) {
				$scope.showEmptyLabel = true;
			}
		} else {
			$scope.rowCollection = $scope.rowCollection.concat(data.lServiceMasterBean);

		}
	};

	$scope.getTranslationList = function() {
		$scope.dataLoopCount = 0;
		$scope.showEmptyLabel = false;
		$scope.offsetCount = 0;
		$scope.limitCount = 1000;
		$scope.rowCollection = [];
		$scope.getTranslationListUtil($scope.limitCount, $scope.offsetCount);
	};

	$scope.getTranslationList();

	 $scope.add = function(){
		 $state.go('app.master.service.servicemasterAdd');
	 };
	 
	/** ********Add,Edit and Delete******** */

	 // remove to the real data holder
    $scope.deleteRow = function(sectorCode, index) {
        ngDialog.openConfirm().then(function() {
			var myURL = $stateParams.tenantid+'/app/serviceMaster/delete';
			$http({
				url : myURL,
				data : sectorCode,
				method : 'post',
				dataType : 'json',
				headers : {
					'Accept' : 'application/json',
					'Content-Type' : 'application/json'
				}
			}).success(function(data) {
				if (data == true) {
					$scope.displayedCollection.splice(index, 1);
					logger.logSuccess("Service Master Deleted Successfully");
				} else
					logger.logError("You Can't Delete this Record, Related Data Exist!");
			}).error(function(data) {
				logger.logSuccess("Error in Delete Service Master!");
			});
		}, function(reason) {
            console.log('Modal promise rejected. Reason: ', reason);
        });

    };
    

	// Redirecting Page For Edit  Functionality

	$scope.editRow = function(sectorCode) {
	    $location.url($stateParams.tenantid+'/service/servicemaster/edit?sectorCode='+sectorCode);

	}
	
	 $scope.view = function(sectorCode ) {
	       
	       
	     $location.url($stateParams.tenantid+'/service/servicemaster/view?sectorCode='+sectorCode);
	       

	   }
	
	

});
