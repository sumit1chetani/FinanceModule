'use strict';

app.controller('commodityAddnewCtrl', function($scope,$stateParams,toaster,validationService, $rootScope, $http, $location, $log, logger, $modal, sharedProperties, $window,$state) {

	//cancel
	$scope.cancel = function() {
    	$state.go("app.master.commoditynewdesc.list",{tenantid:$stateParams.tenantid});  
    }
	
	//ng-model Name's
	$scope.commodity = {			
		   commodityCode:'',
		   classification:'',
			commodity:'',
			  hazardous: 'N',
			  unno: '',
			  flashPoint:'', 
			  imdgCode: '',
			  imdgPage:'',
			  hsCode:'',
			  blClause:'',
		   isSuccess:'',
		   active:''
    };
	
	
	  $http.post($stateParams.tenantid+'/api/commoditynew/classification').success(function(data) {
	      		      	      	
	  		$scope.classificationList=data;
	  		        		
	  });
  
  $http.post($stateParams.tenantid+'/app/commonUtility/getcommodityCateory').success(function(data) {
  	
		$scope.CustList=data.commoditycategory;
		        		
});
 
  
  
  //save
  $scope.save = function(commodityForm,commodity) {	 
	  sharedProperties.clearObject();
	  if (new validationService().checkFormValidity($scope.commodityForm)) {
		  
		  
		  $http.post($stateParams.tenantid+'/api/commoditynew/create',$scope.commodity).success(function(data) {
	         if(data.isSuccess == true){
	             logger.logSuccess("Saved Succesfully!");     
	             $state.go("app.master.commoditynewdesc.list",{tenantid:$stateParams.tenantid});                   
	             }else{
	      	   logger.logError(data.message)
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
	  if (new validationService().checkFormValidity($scope.commodityForm)) {
		 
		  $http.post($stateParams.tenantid+'/api/commoditynew/update',$scope.commodity).success(function(response) {
	           if(response.isSuccess == true){
	               logger.logSuccess("Updated Succesfully!");
	               $state.go("app.master.commoditynewdesc.list",{tenantid:$stateParams.tenantid}); 
	           }else{
	               logger.logError("Error in Update");
	           }
	        });
	  } else {
		  toaster.pop('error',"Please fill the required fields",logger.getErrorHtmlNew(commodityForm.$validationSummary),5000, 'trustedHtml');
		}
	  	
	    
	};
	
	$scope.isEdit=false;
	  var commodityCode = $location.search().commodityCode;
	  if(commodityCode != null){
		  
		  $scope.isEdit=true;
		  $http.post($stateParams.tenantid+'/api/commoditynew/edit?commodityCode=' +commodityCode).success(function(result) {
	          
	          if (result.isEdit == false) {
	              logger.logError("Please Try Again");
	          } else {
	              console.log("result***************for viewwwwwwwwwwwwwwwwww*******");
	              console.log(result);
	              $scope.commodity = result;
	              $scope.commodity.description = result.description.toString();
	    	    	$scope.commodity.hazardous = result.hazardous.toString();
	              
	             
	          }
	            
	         }).error(function(data) {

	         });
	  }
	
	   
	  
	  $scope.reset = function() {

		  if(!$scope.isEdit){
			  
			  $scope.commodity = {			
					  commodityCode: '',
						classification:'',
						commodity:'',
						  hazardous: '',
						  unno: '',
						  flashPoint:'', 
						  imdgCode: '',
						  imdgPage:'',
						  hsCode:'',
						  blClause:''
			    };
			  
			  
		}else{
			
			var commodityCode = $location.search().commodityCode;
			  if(commodityCode != null){
				  
				  $scope.isEdit=true;
				  $http.post($stateParams.tenantid+'/api/commoditynew/edit?commodityCode=' +commodityCode).success(function(result) {
			          
			          if (result.isEdit == false) {
			              logger.logError("Please Try Again");
			          } else {
			              console.log("result***************for viewwwwwwwwwwwwwwwwww*******");
			              console.log(result);
			              $scope.commodity = result;
			                
			             
			          }
			            
			         }).error(function(data) {

			         });
			  }
			
		}

		}
	 
 
});

