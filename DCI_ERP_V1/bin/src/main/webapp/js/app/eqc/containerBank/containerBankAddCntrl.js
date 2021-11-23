'use strict';

app.controller('containerBankAddCtrl', function($scope,$stateParams,toaster,validationService, $rootScope, $http, $location, $log, logger, $modal, sharedProperties, $window,$state) {

	//cancel

	
	//ng-model Name's
	$scope.containerBankobj = {			
			cntrType:'',
			containerNo:'',
			tareweight:'',
			grossweight:'',
			payLoad:'',
			service:'',
			port:'',
			soc:false
    };
	
	
	$http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(datas) {	  
		  $scope.conTypeList=datas.getcontypelist;
		 // $scope.contractTypeList=datas.contractType;

	}).error(function(data) {

	});
	
	
	$http.get($stateParams.tenantid+'/app/seaquotation/getiataList').success(function(datas) {
		debugger
	    $scope.portList1 = datas.commonUtilityBean;	    

	}).error(function(data) {

	});
  
  
  //save
  $scope.save = function(commodityForm,commodity) {	 
	  sharedProperties.clearObject();
	  if (new validationService().checkFormValidity(commodityForm)) {
		  
		  
		  $http.post($stateParams.tenantid+'/api/containerBank/create',$scope.containerBankobj).success(function(data) {
	         if(data.isSuccess == true){
	             logger.logSuccess("Saved Succesfully!");     
	             $state.go("app.eqc.containerBank.list",{tenantid:$stateParams.tenantid}); 
	            // $state.reload();
	             }else{
	            	 if(data.commodity=='false'){
	      	      	   logger.logError("Container Number is already exist");
               }else{
	      	   logger.logError(data.message);
               }
	         }
		  }).error(function(result) {
				console.log("data" + data);
	      });
		} else {
			toaster.pop('error',"Please fill the required fields",logger.getErrorHtmlNew(commodityForm.$validationSummary),5000, 'trustedHtml');
		}
	};

  //update
  $scope.update = function(commodityForm,commodity) {
	  sharedProperties.clearObject();
	  if (new validationService().checkFormValidity(commodityForm)) {
		 
		  $http.post($stateParams.tenantid+'/api/containerBank/update',$scope.containerBankobj).success(function(response) {
	           if(response.isSuccess == true){
	               logger.logSuccess("Updated Succesfully!");
	               $state.go("app.eqc.containerBank.list",{tenantid:$stateParams.tenantid});
	              // $state.reload();
	           }else{
	               logger.logError(response.message);
	           }
	        });
	  } else {
		  
		  toaster.pop('error',"Please fill the required fields",logger.getErrorHtmlNew(commodityForm.$validationSummary),5000, 'trustedHtml');
		}
	  	
	    
	};
	
	
	$scope.cancel = function() {
    	$state.go("app.eqc.containerBank.list",{tenantid:$stateParams.tenantid});
    	// $state.reload();
    }
	
	$scope.isEdit=false;
	  var commodityCode = $location.search().commodityCode;
	  if(commodityCode != null){
		  
		  $scope.isEdit=true;
		  $http.post($stateParams.tenantid+'/api/containerBank/edit?commodityCode=' +commodityCode).success(function(result) {
	          
	          if (result.isEdit == false) {
	              logger.logError("Please Try Again");
	          } else {
	              console.log("result***************for viewwwwwwwwwwwwwwwwww*******");
	              console.log(result);
	              $scope.containerBankobj = result;
	              $scope.containerBankobj.port = result.port .toString();
	              /*$scope.commodity.hazardous = result.hazardous.toString();*/
	              
	             
	          }
	            
	         }).error(function(data) {

	         });
	  }
	  
	  $scope.validateContainer = function(val) {
			var isnum;
			//var index1 = parseInt(index)+1;
			if(val.trim() !="" && val!=undefined){

			if (val.length == 11) {

			//var letters = /^[0-9a-zA-Z]+$/;
			if (/^[a-zA-Z0-9]*$/.test(val)) {
			var res = val.substring(0, 4).toUpperCase();
			var res1 = val.substring(4, 11);

			if (/^[a-zA-Z0-9]*$/.test(val)) {
			if(isNaN(res1)){
			logger.logError("Container Number Should Contain 4 Letters and 7 ");
			 $scope.containerBankobj.containerNo = "";
			} else {

			}
			} else {
			logger.logError("Container Number Should Contain 4 Letters and 7 ");
			 $scope.containerBankobj.containerNo = "";

			}
			} else {
			logger.logError("Container Number Should Contain 4 Letters and 7 ");
			 $scope.containerBankobj.containerNo = "";

			}

			} else {
			logger.logError("Invalid Container Number");
			
			 $scope.containerBankobj.containerNo = "";

			} 

			}
			}
	
	   
	  
	  $scope.reset = function() {

		  if(!$scope.isEdit){
			  
			  $scope.containerBankobj = {			
						cntrType:'',
						containerNo:'',
						tareweight:'',
						grossweight:'',
						payLoad:'',
						service:'',
						port:'',
						soc:false
			    };
			  
			  
		}else{
			
			var commodityCode = $location.search().commodityCode;
			  if(commodityCode != null){
				  
				  $scope.isEdit=true;
				  $http.post($stateParams.tenantid+'/api/containerBank/edit?commodityCode=' +commodityCode).success(function(result) {
			          
			          if (result.isEdit == false) {
			              logger.logError("Please Try Again");
			          } else {
			              console.log("result***************for viewwwwwwwwwwwwwwwwww*******");
			              console.log(result);
			              $scope.containerBankobj = result;
			              $scope.containerBankobj.port = result.port .toString();
			              /*$scope.commodity.hazardous = result.hazardous.toString();*/
			              
 			          }
			            
			         }).error(function(data) {

			         });
			  }
			
		}

		}
	 
 
});

app.controller('containerBankDepotCtrl', function($scope,$stateParams,toaster,validationService, $rootScope, $http, $location, $log, logger, $modal, sharedProperties, $window,$state) {


	$scope.containerBankobj = {			
			cntrType:'',
			containerNo:'',
			tareweight:'',
			grossweight:'',
			payLoad:'',
			service:'',
			port:'',
			soc:false,
			fromPort:'',
			toPort:'',
			containerList:[]
    };
	
	
	$http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(datas) {	  
		  $scope.conTypeList=datas.getcontypelist;
		 // $scope.contractTypeList=datas.contractType;

	}).error(function(data) {

	});
	
	
	$http.get($stateParams.tenantid+'/app/seaquotation/getiataList').success(function(datas) {
		debugger
	    $scope.portList1 = datas.commonUtilityBean;	    

	}).error(function(data) {

	});
  
  

  //move update
  $scope.move = function(commodity) {
	 
	  var selected =false;
	  
	  if (($scope.containerBankobj.fromPort!=null && $scope.containerBankobj.fromPort!=undefined && $scope.containerBankobj.fromPort!="")  &&
			  ($scope.containerBankobj.toPort!=null && $scope.containerBankobj.toPort!=undefined && $scope.containerBankobj.toPort!=""))
	 {
		  
		  if($scope.containerBankobj.containerList.length>0){
			  
			  
			   angular.forEach($scope.containerBankobj.containerList, function (item, key) {
				   
                   if(item.select){
                	   selected=true;
                   }
                   
               });
		 
			  
			  if(selected){
		  $http.post($stateParams.tenantid+'/api/containerBank/moveUpdate',$scope.containerBankobj).success(function(response) {
	           if(response.isSuccess == true){
	               logger.logSuccess("Updated Succesfully!");
	               $scope.containerBankobj.containerList=[];
	               $scope.fetch();
	               
	           }else{
	               logger.logError(response.message);
	           }
	        });
		  
			  }else {
				  
				  logger.logError("Please select aleast one container to move!");
				  
				}
		  
		  }
	  } else {
		  
		  logger.logError("Please select From Depot and To Depot");
		  
		}
	  	
	    
	};
	$scope.$watch('containerBankobj.containerNo',function(newValue, oldValue) {
		if(newValue!=null && newValue!=undefined && newValue!="")
			{
				$http.post($stateParams.tenantid+ '/api/containerBank/containerNumber?containerno='+newValue).success(function(datas) {
								 if(datas.checkDigit == false){
									logger.logError(datas.message);
									$scope.containerBankobj.containerNo='';
								}
								})
						.error(
								function(data) {
									logger.logError("Unable to fetch");
								});
			}
			})
	
	$scope.$watch('containerBankobj.fromPort',function(newValue, oldValue) {
		if(newValue!=null && newValue!=undefined && newValue!="")
			{
			
			
			 if($scope.containerBankobj.toPort==$scope.containerBankobj.fromPort){
	        	  
	        	   logger.logError("From Depot and To Depot can't be same"); 
	        	   $scope.containerBankobj.toPort='';
	             
	           }
			
			  $http.post($stateParams.tenantid+'/api/containerBank/getContainerList',$scope.containerBankobj).success(function(response) {
		           if(response.isSuccess == true){
		        	   
		        	   if(response.bean.length>0){
		        		   
		        		   $scope.containerBankobj.containerList= response.bean;
		        		   
		        	   }else{
			               logger.logError("No Record Found");
			               $scope.containerBankobj.containerList=[];
			           }
		               
		             
		           }else{
		               logger.logError("No Record Found");
		           }
		        });
			
			
			}
	})
	
	
	$scope.fetch = function() {
		
		
		 if($scope.containerBankobj.toPort==$scope.containerBankobj.fromPort){
       	  
       	   logger.logError("From Depot and To Depot can't be same"); 
       	   $scope.containerBankobj.toPort='';
            
          }
		
		  $http.post($stateParams.tenantid+'/api/containerBank/getContainerList',$scope.containerBankobj).success(function(response) {
	           if(response.isSuccess == true){
	        	   
	        	   if(response.bean.length>0){
	        		   
	        		   $scope.containerBankobj.containerList= response.bean;
	        		   
	        	   }else{
		               logger.logError("No Record Found");
		               $scope.containerBankobj.containerList=[];
		           }
	               
	             
	           }else{
	               logger.logError("No Record Found");
	           }
	        });
		
		
		}
	
	
	
	
	$scope.$watch('containerBankobj.toPort',function(newValue, oldValue) {
		if((newValue!=null && newValue!=undefined && newValue!="") && 
				($scope.containerBankobj.fromPort!=null && $scope.containerBankobj.fromPort!=undefined && $scope.containerBankobj.fromPort!=""))
			{
			
		           if(newValue==$scope.containerBankobj.fromPort){
		        	  
		        	   logger.logError("From Depot and To Depot can't be same"); 
		        	   $scope.containerBankobj.toPort='';
		             
		           }
			}
	})
	
	$scope.cancel = function() {
    	$state.go("app.eqc.containerBank.list",{tenantid:$stateParams.tenantid});
    	// $state.reload();
    }
	
	$scope.isEdit=false;
	  var commodityCode = $location.search().commodityCode;
	  if(commodityCode != null){
		  
		  $scope.isEdit=true;
		  $http.post($stateParams.tenantid+'/api/containerBank/edit?commodityCode=' +commodityCode).success(function(result) {
	          
	          if (result.isEdit == false) {
	              logger.logError("Please Try Again");
	          } else {
	              console.log("result***************for viewwwwwwwwwwwwwwwwww*******");
	              console.log(result);
	              $scope.containerBankobj = result;
	              $scope.containerBankobj.port = result.port .toString();
	              /*$scope.commodity.hazardous = result.hazardous.toString();*/
	              
	             
	          }
	            
	         }).error(function(data) {

	         });
	  }
	  
	  $scope.validateContainer = function(val) {
			var isnum;
			//var index1 = parseInt(index)+1;
			if(val.trim() !="" && val!=undefined){

			if (val.length == 11) {

			//var letters = /^[0-9a-zA-Z]+$/;
			if (/^[a-zA-Z0-9]*$/.test(val)) {
			var res = val.substring(0, 4).toUpperCase();
			var res1 = val.substring(4, 11);

			if (/^[a-zA-Z0-9]*$/.test(val)) {
			if(isNaN(res1)){
			logger.logError("Container Number Should Contain 4 Letters and 7 ");
			 $scope.containerBankobj.containerNo = "";
			} else {

			}
			} else {
			logger.logError("Container Number Should Contain 4 Letters and 7 ");
			 $scope.containerBankobj.containerNo = "";

			}
			} else {
			logger.logError("Container Number Should Contain 4 Letters and 7 ");
			 $scope.containerBankobj.containerNo = "";

			}

			} else {
			logger.logError("Invalid Container Number");
			
			 $scope.containerBankobj.containerNo = "";

			} 

			}
			}
	
	   
	  
	  $scope.reset = function() {

		  if(!$scope.isEdit){
			  
			  $scope.containerBankobj = {			
						cntrType:'',
						containerNo:'',
						tareweight:'',
						grossweight:'',
						payLoad:'',
						service:'',
						port:'',
						soc:false
			    };
			  
			  
		}else{
			
			var commodityCode = $location.search().commodityCode;
			  if(commodityCode != null){
				  
				  $scope.isEdit=true;
				  $http.post($stateParams.tenantid+'/api/containerBank/edit?commodityCode=' +commodityCode).success(function(result) {
			          
			          if (result.isEdit == false) {
			              logger.logError("Please Try Again");
			          } else {
			              console.log("result***************for viewwwwwwwwwwwwwwwwww*******");
			              console.log(result);
			              $scope.containerBankobj = result;
			              $scope.containerBankobj.port = result.port .toString();
			              /*$scope.commodity.hazardous = result.hazardous.toString();*/
			              
 			          }
			            
			         }).error(function(data) {

			         });
			  }
			
		}

		}
	 
 
});

