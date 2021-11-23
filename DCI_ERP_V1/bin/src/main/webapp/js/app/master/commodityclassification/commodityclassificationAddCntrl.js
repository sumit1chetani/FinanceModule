'use strict';

app.controller('commodityclassificationAddCtrl', function($scope,$stateParams,toaster,validationService, $rootScope, $http, $location, $log, logger, $modal, sharedProperties, $window,$state) {

	//cancel
	$scope.cancel = function() {
    	$state.go("app.master.commodityclassification.list",{tenantid:$stateParams.tenantid});  
    }
	
	//ng-model Name's
	$scope.commodityclassification = {			
		  classificationCode:'',
		   description:'',
		   isSuccess:''
    };
	
	
  
  $http.post($stateParams.tenantid+'/app/commonUtility/getcommodityclassificationCateory').success(function(data) {
  	
		$scope.CustList=data.commodityclassificationcategory;
		        		
});
 
  
  
  //save
  $scope.save = function(commodityclassificationForm,commodityclassification) {	
	  sharedProperties.clearObject();
	  if (new validationService().checkFormValidity($scope.commodityclassificationForm)) {
		  
		  
		  $http.post($stateParams.tenantid+'/api/commodityclassification/create',$scope.commodityclassification).success(function(data) {
	         if(data.isSuccess == true){
	             logger.logSuccess("Saved Succesfully!");     
	             $state.go("app.master.commodityclassification.list",{tenantid:$stateParams.tenantid});                   
	             }else{
	      	   logger.logError(data.message)
	         }
		  }).error(function(result) {
				console.log("data" + data);
	      });
	  } else {
			toaster.pop('error',"Please fill the required fields",logger.getErrorHtmlNew(commodityclassificationForm.$validationSummary),5000, 'trustedHtml');
			
		}
}
  
  
  //update
  $scope.update = function(commodityclassificationForm,commodityclassification) {
	  sharedProperties.clearObject();
	  if (new validationService().checkFormValidity($scope.commodityclassificationForm)) {
		 
		  $http.post($stateParams.tenantid+'/api/commodityclassification/update',$scope.commodityclassification).success(function(response) {
	           if(response.isSuccess == true){
	               logger.logSuccess("Updated Succesfully!");
	               $state.go("app.master.commodityclassification.list",{tenantid:$stateParams.tenantid}); 
	           }else{
	               logger.logError("Error in Update");
	           }
	        });
	  } else {
			toaster.pop('error',"Please fill the required fields",logger.getErrorHtmlNew(commodityclassificationForm.$validationSummary),5000, 'trustedHtml');
			
		  }
	    
	};
	
	$scope.isEdit=false;
	  var classificationCode = $location.search().classificationCode;
	  if(classificationCode != null){
		  
		  $scope.isEdit=true;
		  $http.post($stateParams.tenantid+'/api/commodityclassification/edit?classificationCode=' +classificationCode).success(function(result) {
	          
	          if (result.isEdit == false) {
	              logger.logError("Please Try Again");
	          } else {
	              console.log("result***************for viewwwwwwwwwwwwwwwwww*******");
	              console.log(result);
	              $scope.commodityclassification = result;
	              $scope.commodityclassification.description = result.description.toString();
	    	    	$scope.commodityclassification.hazardous = result.hazardous.toString();
	              
	             
	          }
	            
	         }).error(function(data) {

	         });
	  }
	
	   
	  
	  $scope.reset = function() {

		  if(!$scope.isEdit){
			  
			  $scope.commodityclassification = {			
					  classificationCode: '',
					description:'',
					   isSuccess:''
			    };
			  
			  
		}else{
			
			var classificationCode = $location.search().classificationCode;
			  if(classificationCode != null){
				  
				  $scope.isEdit=true;
				  $http.post($stateParams.tenantid+'/api/commodityclassification/edit?classificationCode=' +classificationCode).success(function(result) {
			          
			          if (result.isEdit == false) {
			              logger.logError("Please Try Again");
			          } else {
			              console.log("result***************for viewwwwwwwwwwwwwwwwww*******");
			              console.log(result);
			              $scope.commodityclassification = result;
			                
			             
			          }
			            
			         }).error(function(data) {

			         });
			  }
			
		}

		}
	 
 
});

