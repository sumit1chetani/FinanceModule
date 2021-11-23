'use strict';
app.controller('trailerAddCtrl', function($scope, $stateParams,
		validationService, $rootScope, logger, $http, $location, $log, $modal,
		sharedProperties, $window, $state, utilsService,toaster) {

	$scope.dataLoopCount = 0;
	$scope.offsetCount = 0;
	$scope.limitCount = 1000;
	$scope.updatedData = [];
	$scope.rowCollection = [];
	$scope.displayedCollection = [];
	$scope.itemsByPage = 10;
	$scope.showEmptyLabel = false;
	$scope.edit = false;

	$scope.trailer = {
		trailerNo : '',
		trailerType:'',
		numberofAxles:'',
		trailerId : '',
		capacity : '',
		remarks : '',
		cost : '',
		serviceDate : '',
		natureOfReport : '',
		edit : false 

	};

	
	$scope.controllist = [  
	                        {
		'id' : 'Dropside Flatbed',
		'text' : 'Dropside Flatbed'
	},{
		'id' : 'Flat bed',
		'text' : 'Flat bed'
	},{
		'id' : 'Skeletal',
		'text' : 'Skeletal'
	},{
		'id' : 'Tipper',
		'text' : 'Tipper'
	} ]



	$scope.controllist1 = [ {
		'id' : '1',
		'text' : '1'
	}, {
		'id' : '2',
		'text' : '2'
	},{
		'id' : '3',
		'text' : '3'
	},{
		'id' : '4',
		'text' : '4'
	} ]
	
	
	
	
	
	
	
	
	
	// $scope.tmpData = angular.copy($scope.trailer);

	$scope.thumbsAlert = false;
	$scope.error = false;

	$scope.timeOut = function() {
		$timeout(function() {
			$scope.thumbsAlert = false;
			$scope.error = false;
		}, 3000);
	}

	$scope.tabs = [ {
		title : "Trailer Details",
		active : true
	}, {
		title : "Service History",
		active : false
	}, {
		title : "Trip History",
		active : false
	},

	];

	$scope.cancel = function() {
		$state.go('master.trailer.list');
	}
	$scope.validate = function(trailer,trailerForm) {
		if (new validationService().checkFormValidity(trailerForm)) {
			if (!$scope.edit) {
				$scope.save(trailerForm);
			} else {
				$scope.update(trailerForm);
			}
		} else {
			toaster.pop('error', "Please fill the required fields", logger
					.getErrorHtmlNew(trailerForm.$validationSummary), 5000,
					'trustedHtml');
		}

	};

	$scope.save = function(trailerForm) {
		sharedProperties.clearObject();

		console.log();

		$http.post($stateParams.tenantid + '/trailer/save', $scope.trailer)

		.success(function(response) {
			if (response == 1) {
				logger.logSuccess("Saved Succesfully!");

				$state.go("master.trailer.list", {
					tenantid : $stateParams.tenantid
				});
			} else {
				logger.logError("Error in save trailer")
			}
		});

	};

	$scope.update = function(trailerForm) {
		sharedProperties.clearObject();
		$http.post($stateParams.tenantid + '/trailer/update', $scope.trailer)
				.success(function(response) {
					console.log(response);

					if (response == 1) {
						logger.logSuccess("Updated Succesfully!");
						$state.go("master.trailer.list", {
							tenantid : $stateParams.tenantid
						});
					} else {
						logger.logError("Error in update trailer!");
					}
				});

	};

	var editid = $location.search().rowid;

	$scope.getEdit = function(trailerForm) {

		if (editid != 0 && editid != undefined) {
			$scope.edit = true;

			$http.post($stateParams.tenantid + '/trailer/edit', editid)
					.success(function(result) {
						console.log(result);
						$scope.trailer = result;
				    	$scope.trailer.numberofAxles = result.numberofAxles.toString();
					});
		}

	}
	$scope.getEdit();
	
	
	
	
	

	/*  var viewId = $location.search().viewId;


		if (viewId) {
			$scope.isEdit = true;
			$http.post($stateParams.tenantid + '/trailer/edit',
					viewId).success(function(result) {
						console.log(result);
						
						
						$scope.truckData=result;
						$scope.truckData.truckid = editId;
				    	
				 
						
						
			});
		}
	
	
	*/
	
	
	
	
	
	
	
	
	
	
	

	$scope.reset = function(trailerForm) {

		if ($scope.edit == true) {

			$scope.getEdit();
		} else {

			$scope.trailerType='',
			$scope.numberofAxles='',
			$scope.trailer.trailerNo = '';
			$scope.trailer.capacity = '';
			$scope.trailer.remarks = '';
			$scope.trailer.trailerId = '';
		}

	};
	
	
	/*  
    $scope.reset=function(trailerForm){
        
        if( $scope.trailer.edit == false){ 
            $scope.trailer = {
            		trailerNo : '',
            		trailerId : '',
            		capacity : '',
            		remarks : '',
            		cost : '',
            		serviceDate : '',
            		natureOfReport : '',
            		edit : false 
            }
        }else {
            $http.post($stateParams.tenantid+"/trailer/edit", $location.search().editid).success(function(response) {
                console.log(response);
                if (response.success == true) {
                    $scope.trailer = response.trailer;
                }
            });
        }
    }
    */

    $scope.reset = function(trailerForm) {
    	 $scope.trailerType ='';
		   $scope.numberofAxles='';
			$scope.truckData.trailerNo ='';
			$scope.truckData.trailerId  ='';
			$scope.truckData.capacity ='';
			$scope.truckData.remarks  ='';
		

}



$scope.reset1 = function(trailerForm) {
		$scope.getEdit();
}
	
	
	
	
	
	
	
	
	
	
	
	

	// Trip History Tab

	if ($scope.edit == true) {

		$http.post($stateParams.tenantid + '/trailer/triphistory', editid)
				.success(function(result) {

					$scope.rowCollection = result.tripHistory;

				});
	}

});
