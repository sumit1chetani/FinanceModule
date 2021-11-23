'use strict';
app.controller('guidelinevaluesAddCtrl', function($scope, $rootScope,ngDialog, $http, $location, logger,
        utilsService,$state,$timeout,sharedProperties,$window,validationService,toaster,$stateParams){



	   $scope.offsetCount = 0;
	    $scope.limitCount = 1000;
	    $scope.isEdit = false;



	    $scope.guidelinevalues = {
	   guidelinevaluesid: '',
	   locationId : '',
	   locationName : '',
	   fromLocationName : '',
	   toLocationName : '',
	   fromLocation : '',
	   toLocation : '',
	   breakevenRate : '',
	   breakevenMielage : '',
	   breakevenNoOfDays : '',
	   	                	
	   	             };
	    $scope.guidelinevalues = {
	    		   getguidelinevaluesById: '',
	    		   locationId : '',
	    		   locationName : '',
	    		   fromLocationName : '',
	    		   toLocationName : '',
	    		   fromLocation : '',
	    		   toLocation : '',
	    		   breakevenRate : '',
	    		   breakevenMielage : '',
	    		   breakevenNoOfDays : '',
	    		   edit:''	                	
	    		   	             };
	    
	    $scope.guidelinevaluesfuel = {
	    		  getguidelinevaluesById: '',
	    		  guidelinevaluesId:'',
	    		  getsavedguidelinevaluesById: '',
	    		   fromLocationName : '',
	    		   toLocationName : '',
	    		   fromLocation : '',
	    		   toLocation : '',
	    		   unit : '',
	    		  
	    		   	  };
	    $scope.guidelinevaluesmiledge = {
	    		   getguidelinevaluesById: '',
	    		   guidelinevaluesId:'',
	    		   getsavedguidelinevaluesById: '',
	    		   fromLocationName : '',
	    		   toLocationName : '',
	    		   fromLocation : '',
	    		   toLocation : '',
	    		   cost : '',
	    		   driverId:'',
	    		   driverList:[]
	    		   	  };
	    
	    $scope.guidelinevaluesminimumRate= {
	    		   getguidelinevaluesById: '',
	    		   guidelinevaluesId:'',
	    		   getsavedguidelinevaluesById: '',
	    		   fromLocationName : '',
	    		   toLocationName : '',
	    		   fromLocation : '',
	    		   toLocation : '',
	    		   minimumRateCost : '',
	    		   driverList:[]
	    		   	  };
	    
	    $scope.guidelinevaluesRoadUser = {
	    		   getguidelinevaluesById: '',
	    		   guidelinevaluesId:'',
	    		   getsavedguidelinevaluesById: '',
	    		   fromLocationName : '',
	    		   toLocationName : '',
	    		   fromLocation : '',
	    		   toLocation : '',
	    		   cost : '',
	    		   roadUserCost : '',
	    		   
	    		   	  };

	    $scope.tabs = [ {
			title : "Guideline Values",
			active : true
		}, {
			title : "Fuel Consumption",
			active : false
		}, {
			title : "Mileage",
			active : false
		},
		{
			title : "MRG - Minimum Rate Guidelines",
			active : false
		},
		{
			title : "Road User",
			active : false
		}
		

		];
	    $scope.setInActive = function(index) {
	        var activeVal = $scope.guidelinevalues.edit
	        if (activeVal == false) {
	            $scope.showLabel = $scope.tabs[index].name;
	            $scope.tabs[index].active = false;
	            $scope.tabs[oldVal].active = true;
	            activeVal = index;
	        } else if (activeVal == true) {
	            $scope.tabs[index].active = true;
	        }
	    }
	    $scope.cancel1 = function() {
	    	 $state.go("app.master.guidelinevalues",{tenantid:$stateParams.tenantid});               		  	  
		          
		    };
		   
		   
		    $(".multiselect").addClass("width_100 input-sm line-height-10");
		    $("#driverMultiSelect").multiselect({
		        maxHeight: 400,   
		        includeSelectAllOption: true,
		        disableIfEmpty: true,
		        enableCaseInsensitiveFiltering: true,
		        onDropdownHide: function (event) {
		            
		        }
		      });
		    $(".multiselect").addClass("width_100 input-sm line-height-5");
		    
			$http.get($stateParams.tenantid + '/truckdrivermapping/driverlist')
			.success(function(datas) {
				$scope.driverList = datas.driverList;
				console.log(datas);
				$timeout(function() { 

                    $("#driverMultiSelect").multiselect({
                        maxHeight : 200,
                        includeSelectAllOption : true,
                        selectAllText : 'Select All',
                        enableFiltering : true,
                        enableCaseInsensitiveFiltering : true,
                        filterPlaceholder : 'Search',
                        onChange : function(element, checked) {

                       
                   }
                    });
                    $(".multiselect").addClass("width_100 input-sm line-height-5");
                }, 3, false);

                if ($location.search().rowid != undefined && $location.search().rowid != '') {
                	$scope.getEdit();
                }
				
			}).error(function(datas) {
			});

	 	
	    	$http.get($stateParams.tenantid + '/guidelinevalues/getLocationList').success(
	    			function(data) {
	    				if (data.success == true) {
	    					$scope.locationList = data.locationList;
	    				}
	    			});
     
	    	$http.get($stateParams.tenantid + '/guidelinevalues/getLocationList1').success(
	    			function(data) {
	    				if (data.success == true) {
	    					$scope.locationList1 = data.locationList1;
	    				}
	    			});


	    	
		
	    	
	    	
	    	
	    	
	    	
	    	
	    	

	    		$scope.validate = function(guidelinevaluesForm) {
	    			  if (new validationService().checkFormValidity(guidelinevaluesForm)) {	    				
	    				  if (!$scope.isEdit) {
	    					$scope.save(guidelinevaluesForm);
	    				} else {
	    					$scope.update(guidelinevaluesForm);
	    				}
	    			} else {
	    				logger.logError("Please fill all mandatory fields");

	    			}
	    		};

	    		$scope.validate1 = function(guidelinevaluesForm1) {
	    			  if (new validationService().checkFormValidity(guidelinevaluesForm1)) {	    				
	    				  if (!$scope.isEdit) {
	    					$scope.save1(guidelinevaluesForm1);
	    				} else {
	    					$scope.update1(guidelinevaluesForm1);
	    				}
	    			} else {
	    				logger.logError("Please fill all mandatory fields");

	    			}
	    		};
			
	    		$scope.validate2 = function(guidelinevaluesForm2) {
	    			  if (new validationService().checkFormValidity(guidelinevaluesForm2)) {	    				
	    				  if (!$scope.isEdit) {
	    					$scope.save2(guidelinevaluesForm2);
	    				} else {
	    					$scope.update2(guidelinevaluesForm2);
	    				}
	    			} else {
	    				logger.logError("Please fill all mandatory fields");

	    			}
	    		};
	    		
	    		$scope.validate3 = function(guidelinevaluesForm3) {
	    			  if (new validationService().checkFormValidity(guidelinevaluesForm3)) {	    				
	    				  if (!$scope.isEdit) {
	    					$scope.save3(guidelinevaluesForm3);
	    				} else {
	    					$scope.update3(guidelinevaluesForm3);
	    				}
	    			} else {
	    				logger.logError("Please fill all mandatory fields");

	    			}
	    		};
	    		
	    		$scope.validate4 = function(guidelinevaluesForm4) {
	    			  if (new validationService().checkFormValidity(guidelinevaluesForm4)) {	    				
	    				  if (!$scope.isEdit) {
	    					$scope.save4(guidelinevaluesForm4);
	    				} else {
	    					$scope.update4(guidelinevaluesForm4);
	    				}
	    			} else {
	    				logger.logError("Please fill all mandatory fields");

	    			}
	    		};
	    	    var editId = $location.search().rowid;

	    		$scope.getEdit = function() {

	    			if (editId) {
	    				$scope.isEdit = true;
	    				$http.post($stateParams.tenantid + '/guidelinevalues/edit',
	    						editId).success(function(result) {
	    							console.log(result);
	    							
	    							
	    							//$scope.guidelinevalues=result.schedulebean;
	    							$scope.guidelinevalues = result;
	    							$scope.guidelinevaluesfuel = result;
	    							$scope.guidelinevaluesmiledge = result;
	    							$scope.guidelinevaluesminimumRate = result;
	    							$scope.guidelinevaluesRoadUser = result;

	    							$scope.guidelinevaluesmiledge.driverList = result.driverList;
	    		                    var i = 0, size = $scope.guidelinevaluesmiledge.driverList.length;

	    							for (i; i < size; i++) {
	    			                        $("#driverMultiSelect").multiselect('select', $scope.guidelinevaluesmiledge.driverList[i]);
	    			                    }
	    							$scope.guidelinevalues.toLocation = result.toLocation.toString();
	    					    	$scope.guidelinevalues.fromLocation = result.fromLocation.toString();
	    							//$scope.guidelinevalues.guidelinevaluesid = editId;
	    							//$scope.guidelinevalues.toLocation=result
	    								 // $scope.guidelinevalues.fromLocation = result;
	    							
	    							//$scope.scheduleList.id = result.scheduleName;

	    							//$scope.schedule.from_time = result.from_time;
	    							//$scope.schedule.to_time = result.to_time;
	    							
	    							
	    				});
	    			}
	    		}
	    		$scope.getEdit();
	    		
	    		  var viewId = $location.search().viewId;
		    			if (viewId) {
		    				$scope.isEdit = true;
		    				$http.post($stateParams.tenantid + '/guidelinevalues/edit',
		    						viewId).success(function(result) {
		    							console.log(result);
		    							$scope.guidelinevalues=result;
		    							$scope.guidelinevaluesfuel=result;
		    							$scope.guidelinevaluesmiledge=result;
		    							$scope.guidelinevaluesRoadUser=result;
		    							$scope.guidelinevaluesminimumRate=result
		    							$scope.guidelinevalues.toLocation = result.toLocation.toString();
		    							$scope.guidelinevalues.fromLocation = result.fromLocation.toString();
		    							$scope.guidelinevaluesfuel.toLocation = result.toLocation.toString();
		    							$scope.guidelinevaluesfuel.fromLocation = result.fromLocation.toString();
		    							
		    							$scope.guidelinevaluesmiledge.toLocation = result.toLocation.toString();
		    							$scope.guidelinevaluesmiledge.fromLocation = result.fromLocation.toString();
		    							$scope.guidelinevaluesmiledge.driverId=result.driverId.toString();
		    							
		    							
		    							
		    							
		    							
		    				});
		    			}
	    		

		    	 $scope.$watch('guidelinevalues.fromLocation', function(newValue, oldValue) {
			 	        console.log(newValue);
			 	       
			 	            $scope.guidelinevalues.fromLocation = newValue;
			 	            
			 	         /*  $scope.guidelinevalues.breakevenRate ="4"
			 	          $scope.guidelinevalues.breakevenMielage="13"
			 	         $scope.guidelinevalues.breakevenNoOfDays="10"*/
			 	        
			 	    });
		      	 $scope.$watch('guidelinevalues.toLocation', function(newValue, oldValue) {
			 	        console.log(newValue);
			 	       
			 	            $scope.guidelinevalues.toLocation = newValue;
			 	            
			 	         /*  $scope.guidelinevalues.breakevenRate ="4"
			 	          $scope.guidelinevalues.breakevenMielage="13"
			 	         $scope.guidelinevalues.breakevenNoOfDays="10"*/
			 	        
			 	    });

		    		
		    		$scope.save = function(guidelinevaluesForm) {
		    			$http.post($stateParams.tenantid + '/guidelinevalues/save',
		    					$scope.guidelinevalues).success(function(result) {
		    				if (result.success == true) {
		    					$scope.guidelinevaluesmiledge.getsavedguidelinevaluesById=result.getsavedguidelinevaluesById;
		    					$scope.guidelinevaluesfuel.getsavedguidelinevaluesById=result.getsavedguidelinevaluesById;
		    					$scope.guidelinevaluesminimumRate.getsavedguidelinevaluesById=result.getsavedguidelinevaluesById;
		    					$scope.guidelinevaluesRoadUser.getsavedguidelinevaluesById=result.getsavedguidelinevaluesById;

		    					logger.logSuccess("Saved Successfully!");
		    					$scope.tabs[1].active = true;
		    				
		    				} else {
		    					logger.logError("Error in Save");
		    				}
		    			});
		    		}

		    		$scope.save1 = function(guidelinevaluesForm1) {
		    			$http.post($stateParams.tenantid + '/guidelinevalues/saveFuel',
		    					$scope.guidelinevaluesfuel).success(function(result) {
		    				if (result == true) {
		    					logger.logSuccess("Saved Successfully!");
		    					$scope.tabs[2].active = true;
		    					
		    				} else {
		    					logger.logError("Error in Save");
		    				}
		    			});
		    		}

		    		
		    		$scope.save2 = function(guidelinevaluesForm2) {
		    			$http.post($stateParams.tenantid + '/guidelinevalues/saveMiledge',
		    					$scope.guidelinevaluesmiledge).success(function(result) {
		    				if (result == true) {
		    					logger.logSuccess("Saved Successfully!");
		    					$scope.tabs[3].active = true;
		    					
		    					
		    				} else {
		    					logger.logError("Error in Save");
		    				}
		    			});
		    		}
		    		$scope.save3 = function(guidelinevaluesForm3) {
		    			$http.post($stateParams.tenantid + '/guidelinevalues/saveMinimumRate',
		    					$scope.guidelinevaluesminimumRate).success(function(result) {
		    				if (result == true) {
		    					logger.logSuccess("Saved Successfully!");
		    					$scope.tabs[4].active = true;
		    					
		    					
		    				} else {
		    					logger.logError("Error in Save");
		    				}
		    			});
		    		}
		    		$scope.save4 = function(guidelinevaluesForm4) {
		    			$http.post($stateParams.tenantid + '/guidelinevalues/saveRoadUser',
		    					$scope.guidelinevaluesRoadUser).success(function(result) {
		    				if (result == true) {
		    					logger.logSuccess("Saved Successfully!");
		    					$state.go("app.master.guidelinevalues",{tenantid:$stateParams.tenantid});    
		    					
		    					
		    				} else {
		    					logger.logError("Error in Save");
		    				}
		    			});
		    		}

		    		   $scope.update = function(guidelinevaluesForm) {
		    		       // sharedProperties.clearObject();
		    		      	 $http.post($stateParams.tenantid+'/guidelinevalues/update',$scope.guidelinevalues)
		    		            .success(function(response) {
		    		               if(response){
		    		                   logger.logSuccess("Updated Succesfully!");
		    		                   $scope.tabs[1].active = true;

		    		               }else{
		    		                   logger.logError("Error in update!");
		    		               }
		    		            });
		    		        
		    		    }
		    		    
		    		   $scope.update1 = function(guidelinevaluesForm1) {
		    		       // sharedProperties.clearObject();
		    		      	 $http.post($stateParams.tenantid+'/guidelinevalues/updateFuel',$scope.guidelinevaluesfuel)
		    		            .success(function(response) {
		    		               if(response){
		    		                   logger.logSuccess("Updated Succesfully!");
		    		                   $scope.tabs[2].active = true;

		    		               }else{
		    		                   logger.logError("Error in update!");
		    		               }
		    		            });
		    		        
		    		    }
		    		    
		    		   $scope.update2 = function(guidelinevaluesForm2) {
		    		       // sharedProperties.clearObject();
		    		      	 $http.post($stateParams.tenantid+'/guidelinevalues/updateMiledge',$scope.guidelinevaluesmiledge)
		    		            .success(function(response) {
		    		               if(response){
		    		                   logger.logSuccess("Updated Succesfully!");
		    		                   $scope.tabs[3].active = true;


		    		               }else{
		    		                   logger.logError("Error in update!");
		    		               }
		    		            });
		    		        
		    		    }
		    		   
		    		   $scope.update3 = function(guidelinevaluesForm3) {
		    		       // sharedProperties.clearObject();
		    		      	 $http.post($stateParams.tenantid+'/guidelinevalues/updateMinimumRate',$scope.guidelinevaluesmiledge)
		    		            .success(function(response) {
		    		               if(response){
		    		                   logger.logSuccess("Updated Succesfully!");
		    		                   $scope.tabs[4].active = true;


		    		               }else{
		    		                   logger.logError("Error in update!");
		    		               }
		    		            });
		    		        
		    		    }
		    		   
		    		   $scope.update4 = function(guidelinevaluesForm4) {
		    		       // sharedProperties.clearObject();
		    		      	 $http.post($stateParams.tenantid+'/guidelinevalues/updateRoadUser',$scope.guidelinevaluesmiledge)
		    		            .success(function(response) {
		    		               if(response){
		    		                   logger.logSuccess("Updated Succesfully!");
				    					$state.go("app.master.guidelinevalues",{tenantid:$stateParams.tenantid});    


		    		               }else{
		    		                   logger.logError("Error in update!");
		    		               }
		    		            });
		    		        
		    		    }
		    		    
		    	
		    			$scope.cancel = function() {
		    				$state.go("app.master.guidelinevalues", {
		    					tenantid : $stateParams.tenantid
		    				});
		    			}

		    		    $scope.reset = function() {
		    		    	 $scope.guidelinevalues = {

		    		    				guidelinevaluesid: '',
		    		    		   		 locationId : '',
		    		    		   		locationName : '',
		    		    		   		fromLocationName : '',
		    		    		   		toLocationName : '',
		    		    		   		fromLocation : '',
		    		    		   		toLocation : '',
		    		    		   		breakevenRate : '',
		    		    		   		breakevenMielage : '',
		    		    		   		breakevenNoOfDays : '',

		    		    	    	};
//		    		        if ($scope.isEdit == false){
//		    		            $scope.containerAddEditData = angular.copy($scope.tmpData );
//		    		        }else{
//		    		            $scope.containerAddEditData = angular.copy($scope.tmpEditData );
//		    		        }
		    		    }


});
