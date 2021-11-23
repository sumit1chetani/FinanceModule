'use strict';

app.controller('termsaddCtrl', function($scope, $rootScope, $http, $location, logger,
        utilsService,$state,sharedProperties,$window,validationService,toaster,$stateParams) {	
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.edit = true;
    $scope.terms ={
    		termid :'',
    		code : '',
    		name : '',
    		description : '',
    		isActive : true
    };
  
    
    $scope.cancel = function(){
        $state.go("app.master.terms.list",{tenantid:$stateParams.tenantid});
    };  
   
   
    
    //edit
    var editid = $location.search().rowid;    
    var test = parseInt(editid);
    if(test){
    	$scope.edit = false;
    	 $http.post($stateParams.tenantid+'/terms/edit',test).success(function(result) {
    	    	console.log(result);
    	    	$scope.terms = result;
    	    
    	    	if(result.isStstus == "t"){
    	    		$scope.terms.isActive = true;
    	    	}else{
    	    		$scope.terms.isActive = false;
    	    	}    	    	
    	    });    	
    }
    
    $scope.validate = function(termForm) {
       if (new validationService().checkFormValidity(termForm)) {
            if($scope.edit){
                $scope.save($scope.terms,termForm);
            }else{
                $scope.update($scope.terms,termForm);
            }
        } else {
            toaster.pop('error', "Please fill the required fields",
                    logger.getErrorHtmlNew(termForm.$validationSummary),5000, 'trustedHtml');
        }
    };
    
    //save
    $scope.save = function(terms,termForm) {
    	 $http.post($stateParams.tenantid+'/terms/save', $scope.terms).success(function(result) {    	
    		 console.log(result);
             if (result == 1) {
                 logger.logSuccess("Saved Successfully!");
                 $state.go("app.master.terms.list",{tenantid:$stateParams.tenantid});
             } else {
                 logger.logError("Name Already Exists");
             }             
         });        
    };
    
    //update
    $scope.update = function(terms,termForm) {
   	 $http.post($stateParams.tenantid+'/terms/update', $scope.terms).success(function(result) {    	
   		 console.log(result);
            if (result == 1) {
                logger.logSuccess("Update Successfully!");
                $state.go("app.master.terms.list",{tenantid:$stateParams.tenantid});
            } else {
                logger.logError(result.message);
            }             
        });        
   }; 
   $scope.reset = function(termForm) {
       
       if($scope.isEdit = true){
    	   
    	   $scope.terms.termid ='';
           $scope.terms.code ='';
           $scope.terms.name ='';
           $scope.terms.description ='';
           $scope.terms.isActive ='';

      	 $http.post($stateParams.tenantid+'/terms/edit',test).success(function(result) {
 	    	console.log(result);
 	    	$scope.terms = result;
 	    	if(result.isStstus == "t"){
 	    		$scope.terms.isActive = true;
 	    	}else{
 	    		$scope.terms.isActive = false;
 	    	}    	    	
 	    });    	
       }
       else{
    	   $scope.terms.termid ='';
           $scope.terms.code ='';
           $scope.terms.name ='';
           $scope.terms.description ='';
           $scope.terms.isActive ='';
    
      
         
       } $scope.monthSchedule='';
	 $('#truckTrailMapScheduler').fullCalendar('destroy');
       
 }



 
    

});



/*'use strict';
app.filter('concatAcctHeadName', function() {
    return function(input, viewValue) {       
        if (input && input.length) {            
            var obj = {};
            obj.accountHeadName = viewValue;
            if (input.indexOf(viewValue) === -1) {
                input.unshift(obj);                
            }
            return input;
        } else {
            return [];
        }
    };
});*/