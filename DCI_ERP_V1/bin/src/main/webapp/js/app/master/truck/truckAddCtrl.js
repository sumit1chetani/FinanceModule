app.controller('truckAddCtrl', function($scope, $rootScope, $stateParams,
		$http,$filter, $location, logger,sharedProperties, $log, $modal,validationService,toaster, $window, $state, $timeout) 
		{
	$scope.offsetCount = 0;
	$scope.limitCount = 1000;
	$scope.isEdit = false;
	$scope.isContractEdit = false;
	
	 $scope.rowCollection = [];
	 $scope.displayedCollection = [];
	 $scope.rowCollection1 = [];
	 $scope.displayedCollection1 = [];
	 $scope.rowCollection2 = [];
	 $scope.displayedCollection2 = [];
	 $scope.rowCollection3 = [];
	 $scope.displayedCollection3 = [];
	 
	 $http.get($stateParams.tenantid+'/truck/userrights').success(function(result) {   
		 if(result){
			 $scope.rights=false;
		 }else{
			 $scope.rights=true;
		 }
		 
	 });     
	 
	
	//tab-1 model
	$scope.truckData = {
		truckid : '',
		truckNo : '',
		residualValue : '',
		seatsNo : '',
		averageSpeed : '',
		doors : '',
		color : '',
		transmission : '',
		power : '',
		fuelType : '',
		emissions : '',
		horsepower : '',
		modelYear : '',
		lastOdometer : '',
		modelYear : '',
		horsepowerTaxation : '',
		catalogValue : '',
		licensePlate : '',
		model : '',
		tag : '',
		truckRegNo : '',
		currentDriver : '',
/*		location : '',
*/		
		isActive:true,
		chassisNo : '',

	};
	
	//tab-2 model
	$scope.contract = {
			truckid : '',
			truckId : '',
			contractid : '',
			vehicle : '',
			activationCost : '',
			recurringCostAmt : '',
			odometerAtCreation : '',
			invoiceDate : '',
			handoverDate : '',
			vendor : '',
			contractor : '',
			contractRef : '',
			type : '',
			fileName: '',
			filePath: '',
				contractDocUrl: ''

		};
	
	$scope.truckDriverList = function() {

		$http.get($stateParams.tenantid + '/truck/getdriverList').success(
				function(data) {
					console.log(data);
					$scope.truckDriverList = data.selectivitybean;
				}).error(function(data) {
		});
	}

	$scope.truckDriverList();

	

	$scope.tmpData = angular.copy($scope.truckData);
	$scope.isEdit = false;
	$scope.thumbsAlert = false;
	$scope.error = false;

	$scope.controllist = [ {
		'id' : 'Manual',
		'text' : 'Manual'
	}, {
		'id' : 'Automatic',
		'text' : 'Automatic'
	} ]

	
	
	
	$http.get($stateParams.tenantid + '/truck/fuelTypeList').success(
			function(data) {
				if (data.success == true) {
					$scope.fuelTypeList = data.fuelTypeList;
				}
			});

	$http.get($stateParams.tenantid + '/truck/getVendorList').success(
			function(data) {
				if (data.success == true) {
					$scope.vendorList = data.vendorList;
				}
			});

	$scope.tabs = [ {
		title : "Truck Details",
		active : true
	}, {
		title : "Contracts",
		active : false
	}, {
		title : "Cost",
		active : false
	}, {
		title : "Fuel",
		active : false
	},
	

	];

    $scope.tmpData = angular.copy($scope.truckData);
    $scope.isEdit=false;
    $scope.thumbsAlert=false;
    $scope.error=false;
    
    $scope.controllist = [ {
        'id' : 'Manual',
        'text' : 'Manual'
    }, {
        'id' : 'Automatic',
        'text' : 'Automatic'
    }]
    
    
    
    $scope.controllist1 = [ {
        'id' : 'Gasoline',
        'text' : 'Gasoline'
    }, {
        'id' : 'Diesel',
        'text' : 'Diesel'
    }, {
        'id' : 'Electric',
        'text' : 'Electric'
    }, {
        'id' : 'Hybrid',
        'text' : 'Hybrid'
    }
    ] 
    
    $scope.tabs = [
                   {title:"Truck Details", active: true},
                   {title:"Contract", active:false},
                   {title:"Cost", active:false},
                   {title:"Fuel", active:false},
                   {title:"Trip History", active:false},
                   {title:"Allocation", active:false},
              
    ];
    
	
	
	$scope.timeOut = function() {
		$timeout(function() {
			$scope.thumbsAlert = false;
			$scope.error = false;
		}, 3000);
	}
	  $scope.files2 = [];
	var editId = $location.search().truckId;
	 var bean =[];
	$scope.getEdit = function() {
		if (editId) {
			$scope.isEdit = true;

			$scope.isContractEdit = true;
			$http.post($stateParams.tenantid + '/truck/edit', editId).success(
					function(result) {
						console.log(result);

						$scope.truckData = result;
						$scope.truckData.truckid = editId;
						$scope.contract.vehicle = editId;
						$scope.contract.truckId=editId;						

						if(result.truckconBeans.length == 0){
							
							$scope.isContractEdit = false;
							$scope.truckIdForContract = editId;

						}
						else{
							$scope.contract = result.truckconBeans[0];
							
							$scope.isContractEdit = true;

							
						}
						
						$scope.truckData.fuelType = result.fuelType.toString();
						  angular.forEach(result.lBean, function(value, index) {
                          	
							  var dummy = value.fileName;
							  
							  
							  $scope.files.push(dummy);

							  
						  });
						  var dum = []; 
							for (var i = 0; i < $scope.files.length; i++) { 
								var subString = "/"; 
								 if($scope.files[i].indexOf(subString) !== -1){
									                        
										if ($scope.files[i].indexOf(subString) !== -1) {                            
											var val = $scope.files[i].split("/");                            
											value = val[5];                            
											dum.push(value);                        
											} else {                            
												var val = $scope.files[i].split("\\");                           
												value = val[5];                            
												dum.push(value);                        
												}   
								 }else{
									                        
										if ($scope.files[i].indexOf(subString) !== -1) {                            
											var val = $scope.files[i].split("/");                            
											value = val[0];                            
											dum.push(value);                        
											} else {                            
												var val = $scope.files[i].split("\\");                           
												value = val[0];                            
												dum.push(value);                        
												}   
								 }
								 
								 
								                 
								}
						 $scope.contract.files=dum;
						 bean.push($scope.contract.files);
						  });
				
			                   
	
			
	           
			
			
			
		}
	}
	$scope.getEdit();	
	
	  var viewId = $location.search().viewId;


		if (viewId) {
			$scope.isEdit = true;
			$http.post($stateParams.tenantid + '/truck/edit',
					viewId).success(function(result) {
						console.log(result);

						$scope.truckData = result;
						$scope.truckData.truckid = editId;
						$scope.contract.vehicle = editId;
						$scope.contract.truckId=editId;
						//$scope.contract = result.truckconBeans[0];

						if(result.truckconBeans.length == 0){
							
							$scope.isContractEdit = false;
							$scope.truckIdForContract = editId;

						}
						else{
							$scope.contract = result.truckconBeans[0];
							$scope.isContractEdit = true;

							
						}
						
						$scope.truckData.fuelType = result.fuelType.toString();

					});
		}		
		
		$scope.update = function(truckForm) {
			
			  sharedProperties.clearObject();
			$http.post($stateParams.tenantid + '/truck/update', $scope.truckData)
					.success(function(result) {
						$scope.truckIdForContract = result.truckid;
						
						if (result.licensePlateErrorMessage == false) {

							if (result.truckRegNoErrorMessage == false) {

						
								if (result.success == true) {
	
							logger.logSuccess("Updated Successfully!");
							$state.go('app.truck.list', {
								tenantid : $stateParams.tenantid
							});
								} else {
									logger.logError("Error in Update");
								}

							} else {
								logger.logError("Truck Registration Number Already Exist");
							}
						} else {
							
							logger.logError("License Plate Number Already Exist");

						
						
						}

					});

				};
				debugger
				var frmData = new FormData();
				var filepaths;
				$scope.dummy23 = [];
		$scope.update1 = function(truckform1) {
		$http.post($stateParams.tenantid + '/truck/update1', $scope.contract)
				.success(function(result) {
					console.log(result);
					if (result == 1) {
						
						if ($scope.files.length > 0) {
//							
							$scope.files = $scope.contract.files;
							
							if($scope.files == null || $scope.files == '' || $scope.files == undefined){
								var vehicle = $scope.contract.vehicle;
								$http.post($stateParams.tenantid + '/truck/uploaddelete',vehicle).success(
										function(data) {
											console.log(data);
											
										}).error(function(data) {
								});
							}
							
							
							
							
							/*
							 angular.forEach($scope.files, function(files, index) {
								 
								 var vehicle = $scope.contract.vehicle;
								 if(index == File){
									 frmData.append("file", files);
		                             frmData.append("contract", vehicle);
								 }else{
									 frmData.append("filepaths", filepaths);
								 } 
								 
					       });*/
							
							for(var i=0;i<$scope.files.length;i++){
								 var vehicle = $scope.contract.vehicle;
								 if($scope.files[i].name != null){
									 files = $scope.files[i];
									 frmData.append("file", files);									 
									 frmData.append("contract", vehicle);
								 }else{
									 filepaths = $scope.files[i];
									 frmData.append("filepaths", filepaths);
		                             frmData.append("contract", vehicle);
								 }
							}
							
							
							 $.ajax({
                               type : "POST",
                               url : $stateParams.tenantid+"/truck/updateuploadfile",
                               data : frmData,
                               contentType : false,
                               processData : false,
                               success : function(result) {
                               }
                           });
                        }
						
						
						
						
						
						
						
						
						logger.logSuccess("Updated Successfully!");
						$state.go('app.truck.list');
					} else {
						logger.logError(result.message);
					}
				});
	};



	$scope.cancel = function() {
		$state.go('app.truck.list');
	}

	$scope.cancel1 = function() {
		$state.go('app.truck.list');
	}
	$scope.cancel2 = function() {
		$state.go('app.truck.list');
	}
 
	  
    $scope.validate = function(truckform) {
        if (new validationService().checkFormValidity(truckform)) {
            if(!$scope.isEdit){
                $scope.save(truckform);
            }else{
                $scope.update(truckform);
            }
        } else {
            toaster.pop('error', "Please fill the required fields",
                    logger.getErrorHtmlNew(truckform.$validationSummary),5000, 'trustedHtml');
        }
    };
    
   $scope.validate1 = function(truckform1) {
        if (new validationService().checkFormValidity(truckform1)) {
            if(!$scope.isContractEdit){
                $scope.save1(truckform1);
            }else{
                $scope.update1(truckform1);
            }
        } else {
            toaster.pop('error', "Please fill the required fields",
                    logger.getErrorHtmlNew(truckform1.$validationSummary),5000, 'trustedHtml');
        }
    };
    

    
    
    
    
    
    
	
/*	// save
	$scope.save = function(truckform) {
		  sharedProperties.clearObject();
		
		$http.post($stateParams.tenantid + '/truck/save',$scope.truckData)
				.success(function(result) {
					console.log(result);
					if($scope.truckData!=''&& $scope.truckData!=null&&result.success!=false){


						$scope.truckIdForContract = result.truckid
						logger.logSuccess("Truck Details Saved Successfully!");
						$scope.tabs[1].active = true;
						// $state.go('truck.list');
					}
					else {
						logger.logError("License Plate Number Already Exist");
					}
				});
			
	};*/
    
    
    
	// save
	$scope.save = function(truckform) {
		  sharedProperties.clearObject();
		
		$http.post($stateParams.tenantid + '/truck/save',$scope.truckData)
				.success(function(result) {
		
					if (result.licensePlateErrorMessage == false) {

						if (result.truckRegNoErrorMessage == false) {

					
							if (result.success == true) {
								
							
						$scope.truckIdForContract = result.truckid;
						logger.logSuccess("Truck Details Saved Successfully!");
						$scope.tabs[1].active = true;
						// $state.go('truck.list');
						

					} else {
						logger.logError("Error in Save");
					}

				} else {
					
					logger.logError("Truck Registration Number Already Exist");

				}

			} else {
				
				
				logger.logError("License Plate Number Already Exist");

			}

		});
	}

		
	

	$http.get($stateParams.tenantid + '/truck/getVehicleList').success(
			function(data) {
				if (data.success == true) {
					$scope.vehicleList = data.vehicleList;
				}
			});
	
	
	
	

	$scope.save1 = function(truckform1) {
		
			$scope.contract.vehicle = $scope.truckIdForContract;
		
		$http.post($stateParams.tenantid + '/truck/save1', $scope.contract)
				.success(function(result) {
					console.log(result);
					if (result == 1) {
				
						if ($scope.files.length > 0) {

                            angular.forEach($scope.files, function(files, index) {
                            	
                            	
                                var vehicle = $scope.truckIdForContract;
                                
                                var frmData = new FormData();
                                frmData.append("file", files);
                                frmData.append("contract", vehicle);
                               
                                $.ajax({
                                    type : "POST",
                                    url : $stateParams.tenantid+"/truck/saveuploadfile",
                                    data : frmData,
                                    contentType : false,
                                    processData : false,
                                    success : function(result) {
                                    }
                                });
                            });

                        }
						logger.logSuccess("Truck Contract Details Saved Successfully!");
						$state.go('app.truck.list');
					 
					}else {
						logger.logError("Name Already Exists");
					}
				});
	};


	$scope.cost = {
		contractid : '',
		vehicle : '',
		activationCost : '',
		recurringCostAmt : '',
		odometerAtCreation : '',
		invoiceDate : '',
		contractStartDate : '',
		contractEpirationDate : '',
		vendor : '',
		contractor : '',
		contractRef : '',

	};
	$scope.fuel = {

		vehicle : '',
		voucherNo : '',
		date : '',
		liter : '',
		destination : '',
		fuelType : '',

	};
	
	
	   
	 // Trip History Tab
	var viewId = $location.search().viewId;

	if (viewId) {
	    
	    $http.post($stateParams.tenantid+'/truck/tablist',parseInt(viewId)).success(function(result) {
	    	debugger
			$scope.displayedCollection = result.fuelHistoryList;
	    	$scope.rowCollection1= result.tripHistory;
	    	$scope.rowCollection2= result.truckAllocationList;
	    	$scope.rowCollection3= result.driverAllocationList;
	    	
	    });
	    }
	
	if(editId){
	    $http.post($stateParams.tenantid+'/truck/tablist',parseInt(editId)).success(function(result) {
	    	debugger
			$scope.displayedCollection = result.fuelHistoryList;
	    	$scope.rowCollection1= result.tripHistory;
	    	$scope.rowCollection2= result.truckAllocationList;
	    	$scope.rowCollection3= result.driverAllocationList;
	    	
	    });
		
	}
	    
	    
	    $scope.reset = function(truckform) {

  			$scope.truckData.truckNo ='';
   			$scope.truckData.residualValue  ='';
   			$scope.truckData.seatsNo ='';
   			$scope.truckData.averageSpeed  ='';
   			$scope.truckData.doors  ='';
   			$scope.truckData.color  ='';
   			$scope.truckData.transmission  ='';
   			$scope.truckData.power  ='';
   			$scope.truckData.fuelType  ='';
   			$scope.truckData.emissions  ='';
   			$scope.truckData.horsepower  ='';
   			$scope.truckData.modelYear  ='';
   			$scope.truckData.lastOdometer  ='';
   			$scope.truckData.modelYear  ='';
   			$scope.truckData.horsepowerTaxation  ='';
   			$scope.truckData.catalogValue  ='';
   			$scope.truckData.licensePlate  ='';
   			$scope.truckData.model  ='';
   			$scope.truckData.tag  ='';
   			$scope.truckData.truckRegNo  ='';
   			$scope.truckData.currentDriver  ='';
/*   			$scope.truckData.location  ='';
*/   			
   			$scope.truckData.chassisNo  ='';

	}
	
	
	
	$scope.reset1 = function(truckform) {
			$scope.getEdit();
	}
	    
	// Document Upload
   
    $rootScope.uploadFile = function(element) {
        $scope.excelfile = element.files[0];
    }
    $scope.files = [];
  
   $scope.contract.files = [];
    $scope.adduploadfiles = function() {
    	debugger
        var obj = []
    
        if ($scope.checkundefined($scope.excelfile)) {
            logger.logError("Please select the file");
        } else {
            obj = $filter('filter')($scope.contract.files, {
                filename : $scope.excelfile.name
            }, true);
        }

        if (obj != undefined && obj.length > 0) {
            logger.logError($scope.excelfile.name + "same file already added");
        } else {
            $scope.files.push($scope.excelfile);
            $scope.contract.files.push($scope.excelfile.name);

        }

    }
    
    $scope.deleteuploadfiles = function(filename) {
    	$scope.tempfiles = [];
    	$scope.tempfiles1 = [];
    	$scope.tempfiles2 = [];
    	$scope.delete1 = [];
    	$scope.add1 = [];
    	
    	$scope.tempfiles = $scope.contract.files;
    	
    	 
    	 for(i=0;i<$scope.tempfiles.length;i++){
    		 if(filename == $scope.tempfiles[i]){
    			   			
    			 $scope.delete1.push($scope.tempfiles[i]);
    			 $scope.delete1 = [];
    			
             }else{
            	       	 
            	 $scope.add1.push($scope.tempfiles[i]);         	 
   			    
            	 
             }
    		 $scope.contract.files = $scope.delete1;
    		 $scope.contract.files = $scope.add1;
    		
    		 
    	 }     

    }
    $scope.checkundefined = function(value) {
        var invalid = false;
        if (value == undefined || value == 'undefined' || value == null || value == 'null' || value == '') {
            invalid = true;
        }
        return invalid;

    }
	  
	   
});