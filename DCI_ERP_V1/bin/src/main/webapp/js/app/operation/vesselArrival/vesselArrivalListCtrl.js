'use strict';
app.controller('vesselArrivalListCtrl', function($scope, $timeout, $stateParams,sharedProperties,toaster,
		$filter, $rootScope, $http, $location, logger, $state, ngDialog,$controller,$injector) {
	$scope.itemsByPage = 10;
	
	$scope.vesselList = [];
	$scope.voyageList = [];

	
	  $scope.vesselArrival = {
				vessel : '',
				voyage : '',
				port : ''
				
			
		};
 
	 
	  
	  $http.get($stateParams.tenantid+'/api/vesselArrival/list').success(function(datas) {
	        console.log(datas);
	        $scope.rowCollection = datas;
	    	
	        }).error(function(datas) {
	    });
	  
		$scope.search = function() {
			$http.get($stateParams.tenantid+'/api/vesselArrival/search?vessel='+$scope.vesselArrival.vessel+'&voyage='+$scope.vesselArrival.voyage+'&pod='+$scope.vesselArrival.port).success(function(datas) {
	        console.log(datas);
	        if(datas.length>0){
	        $scope.rowCollection = datas;
	        } else {
	        	logger.logError("No Data Available");
	        	 $scope.rowCollection = datas;
	        }
	        }).error(function(datas) {
	    });
	    };
	  
	    $scope.reset = function() {
	    	$scope.vesselArrival = {
					vessel : '',
					voyage : '',
					port : ''
					
				
			};
	    	 $http.get($stateParams.tenantid+'/api/vesselArrival/list').success(function(datas) {
	 	        console.log(datas);
	 	        $scope.rowCollection = datas;
	 	    	
	 	        }).error(function(datas) {
	 	    });
	    };
	    
	  //vessel
		
		$http.get($stateParams.tenantid+ '/api/vesselArrival/getVesselList').success(function(data) {
			$scope.vesselList = data;
		});

		
//		//terminal
//		
//		$http.get($stateParams.tenantid+ '/api/vesselArrival/getTerminalList').success(function(data) {
//			$scope.terminalList = data;
//		});
//

		
		
		 $scope.$watch('vesselArrival.vessel', function(newValue, oldValue) {
		      if(newValue!=null && newValue!=undefined && newValue != ''){
		    	  $http.post($stateParams.tenantid+ '/app/commonUtility/getVoyageListByVessel',newValue).success(function(data) {
						if(data.length > 0)
		    		  {
		    		  $scope.voyageList = data;
		    		  }
						else{
							
							logger.logError("Voyage is not available for the given vessel");
							
						}
		    	  });
		      }
		    });
		 
		 
		 $scope.$watch('vesselArrival.voyage', function(newValue, oldValue) {
		      if(newValue!=null && newValue!=undefined && newValue != ''){
		    	  $http.post($stateParams.tenantid+ '/api/vesselArrival/getPortListByVoyage',newValue).success(function(data) {
						$scope.portList = data;
		    	  });
		      }
		    });
		 

		 
		//port-arrival date
		   $scope.$watchCollection('[vesselArrival.voyage,vesselArrival.port]', function(newValue, oldValue) {
			   debugger
		        if (newValue != '' && newValue != undefined) {
		        	if ($scope.isEdit == false) {
		           if($scope.vesselArrival.port != '' && $scope.vesselArrival.port != undefined
		        && $scope.vesselArrival.voyage != '' && $scope.vesselArrival.voyage != undefined){
		        	   
		        	   var ob = {
								voyage : $scope.vesselArrival.voyage,
								port	:$scope.vesselArrival.port
						}

		                $http.post($stateParams.tenantid+'/api/vesselArrival/getarrivaldate',ob).success(function(datas) {
		                    $scope.vesselArrival.arrivalDate=datas.vesselArrivalBean.arrivalDate;
		                    $scope.terminalList = datas.listTerminalList;
		                    console.log(datas);
		                    }).error(function(datas) {
		                });   
		        }
		        	}  
		        }
		    });
	
	

	$scope.add = function() {
         $state.go('app.operation.vesselarrival.add',{tenantid:$stateParams.tenantid});
    };

	$scope.edit = function(rowId) {
 		$location.url($stateParams.tenantid + '/operation/vesselarrival/view?rowId='+ rowId);
	}
	
	$scope.editRow = function(rowId) {
		 
		var url = $stateParams.tenantid+'/api/vesselArrival/edit?rowId=' +rowId;
          $http.get(url).success(function(result){
              if (result.isSuccess ==  true) {
            	  $location.url($stateParams.tenantid + '/operation/vesselarrival/edit?rowId1='+ rowId);
             } else {
                  logger.logError(result.message);
              }
          })
	}
	
	$scope.deleteRow = function(rowId) {
        ngDialog.openConfirm().then(function() {
        
            var url = $stateParams.tenantid+'/api/vesselArrival/delete?rowId=' +rowId;
            $http.get(url).success(function(result){
                if (result.isSuccess ==  true) {
                    logger.logSuccess("Deleted successfully");
                    $state.reload();
               } else {
                    logger.logError(result.message);
                }
            }).error(function(result) {
                logger.logError("Error Please Try Again");
            });
        }, function(reason) {
            console.log('Modal promise rejected. Reason: ', reason);
        });
    };
	
	
	
});



