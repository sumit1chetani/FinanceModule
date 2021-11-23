'use strict';
app.controller('dischargeListCtrl', function($scope, $timeout, $stateParams,sharedProperties,toaster,
		$filter, $rootScope, $http, $location, logger, $state, ngDialog,$controller,$injector) {
	$scope.itemsByPage = 10;
	
	$scope.vesselList = [];
	$scope.voyageList = [];
	
	 $scope.discharge = {
				vessel : '',
				voyage : '',
				port : ''			
		};
	 
	  

	$scope.add = function() {
         $state.go('app.operation.discharge.add',{tenantid:$stateParams.tenantid});
    };
    
	/*$scope.editBooking = function(bookingNo ) {
		$location.url($stateParams.tenantid+'/vesselarrival/add?vesselName='+vesselName);
	}*/
	


	//vessel
	
	$http.get($stateParams.tenantid+ '/app/commonUtility/getVesselList').success(function(data) {
		$scope.vesselList = data;
	});
    
    $scope.$watch('discharge.vessel', function(newValue, oldValue) {
	      if(newValue!=null && newValue!=undefined && newValue != ''){
	    	  $http.post($stateParams.tenantid+ '/app/commonUtility/getVoyageListByVessel',newValue).success(function(data) {
					$scope.voyageList = data;
	    	  });
	      }
	    });
	 
	 $scope.portList=[];
	 debugger
	 $scope.$watch('discharge.voyage', function(newValue, oldValue) {
		 if(!$scope.isEdit){
		 $scope.discharge.port="";
		 $scope.discharge.arrivalDate="";
		 }
	      if(newValue!=null && newValue!=undefined && newValue != ''){
	    	  
	    	  $http.post($stateParams.tenantid+ '/api/vesselArrival/getPortListByVoyage',newValue).success(function(data) {
					$scope.portList = data;
	    	  });
	      }
	    });
	 
	 
	$scope.editRow = function(vesselArrivalId,isTransit) {
		 localStorage.setItem('vesselArrivalObj',JSON.stringify($scope.vesselArrival));
		$location.url($stateParams.tenantid + '/operation/discharge/edit?vesselArrivalId='+ vesselArrivalId+'&isTransit='+isTransit);
	}
	
	$scope.viewRow = function(vesselArrivalId,isTransit) {
		 localStorage.setItem('vesselArrivalObj',JSON.stringify($scope.vesselArrival));
		$location.url($stateParams.tenantid + '/operation/discharge/view?vesselArrivalId='+ vesselArrivalId+'&isTransit='+isTransit);
	}
	
	
	//Discharge List
	$http.get($stateParams.tenantid+'/api/discharge/dischargeList').success(function(datas) {
        console.log(datas);
        $scope.rowCollection1 = datas;
    	
        }).error(function(datas) {
    });

	$scope.search = function() {
		$http.get($stateParams.tenantid+'/api/discharge/search?vessel='+$scope.discharge.vessel+'&voyage='+$scope.discharge.voyage+'&pod='+$scope.discharge.port).success(function(datas) {
        console.log(datas);
        if(datas.length>0){
        $scope.rowCollection1 = datas;
        } else {
        	logger.logError("No Data Available");
        	 $scope.rowCollection1 = datas;
        }
        }).error(function(datas) {
    });
    };
  
    $scope.reset = function() {
    	$scope.discharge = {
				vessel : '',
				voyage : '',
				port : ''			
		};
    	$http.get($stateParams.tenantid+'/api/discharge/dischargeList').success(function(datas) {
            console.log(datas);
            $scope.rowCollection1 = datas;
        	
            }).error(function(datas) {
        });
    };
	
	//delete
	
	$scope.deleteRow = function(dischargeId) {
        ngDialog.openConfirm().then(function() {
        
            var url = $stateParams.tenantid+'/api/discharge/delete?dischargeId=' + dischargeId;
            $http.get(url).success(function(result){
                if (result.isSuccess ==  true) {
                    logger.logSuccess("Deleted Successfully");
                    $state.reload();
               } else {
                    logger.logError("You Can't Delete this Record, Related Data Exist! ");
                }
            }).error(function(result) {
                logger.logError("Error Please Try Again");
            });
        }, function(reason) {
            console.log('Modal promise rejected. Reason: ', reason);
        });
    };
    
    
    //Excel Export	
	 $scope.exportExcel = function(){

	            $http.post($stateParams.tenantid+'/api/discharge/ExportExcel', $scope.discharge).success(function(response) {
	                if(response){
	                    debugger;
	                    $("#Export").bind('click', function() {
	                    });
	                    $('#Export').simulateClick('click');
	                    logger.logSuccess("Exported successfully!");
	                }else{
	                    logger.logError("Failed to export");
	                }
	                
	            }).error(function(response) {
	                logger.logError("Error Please Try Again");
	            });
	    
	    }
	 
	 
	 $scope.exportExcelNew = function(vesselArrivalId,isTransit){
		 $http.get($stateParams.tenantid+'/api/discharge/excelExportNew?vesselArrivalId='+ vesselArrivalId+'&isTransit='+isTransit).success(function(datas) {
			  if(datas.isSuccess){
                  debugger;
                  $("#Export").bind('click', function() {
                  });
                  $('#Export').simulateClick('click');
                  logger.logSuccess("Exported successfully!");
              }else{
                  logger.logError("Failed to export");
              }
	           
	        	
	            }).error(function(datas) {
	        });
	 }
	
});



