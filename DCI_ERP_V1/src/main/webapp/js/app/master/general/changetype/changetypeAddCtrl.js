'use strict';

app.controller('changeTypeaddCtrl', function($scope, $rootScope, $http, $location, logger,
        utilsService,$state,sharedProperties,$window,validationService,toaster,$stateParams) {	
	
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.edit = true;
    
    $scope.chargemodel ={
    		chargeTypecode : '',
    		chargeTypename : '',
    		chargeTypedescription : '',
    		isActive : true
    };
    
    
    $scope.cancel = function(){
        $state.go("app.truck.general.changetypemenu",{tenantid:$stateParams.tenantid});
    };
   
    
    $scope.validate = function(chargetypeForm) {
        if (new validationService().checkFormValidity(chargetypeForm)) {
            if($scope.edit){
                $scope.save($scope.chargemodel,chargetypeForm);
            }else{
                $scope.update($scope.chargemodel,chargetypeForm);
            }
        } else {
            toaster.pop('error', "Please fill the required fields",
                    logger.getErrorHtmlNew(stateMasterForm.$validationSummary),5000, 'trustedHtml');
        }
    };

    
    
    //save
    $scope.save = function(chargemodel,chargetypeForm) {
    	 $http.post($stateParams.tenantid+'/changetype/save', $scope.chargemodel).success(function(result) {    	
    		 console.log(result);
             if (result == 1) {
                 logger.logSuccess("Saved Successfully!");
                 $state.go("app.truck.general.changetypemenu",{tenantid:$stateParams.tenantid});
             } else {
            	 logger.logError("Name Already Exists");
             }             
         });        
    };
    
    //update
    $scope.update = function(chargemodel,chargetypeForm) {
   	 $http.post($stateParams.tenantid+'/changetype/update', $scope.chargemodel).success(function(result) {    	
   		 console.log(result);
            if (result == 1) {
                logger.logSuccess("Update Successfully!");
                $state.go("app.truck.general.changetypemenu",{tenantid:$stateParams.tenantid});
            } else {
                logger.logError(result.message);
            }             
        });        
   }; 
    
    
    
    //edit
    var editid = $location.search().rowid;    
    var test = parseInt(editid);
    if(test){
    	$scope.edit = false;
    	 $http.post($stateParams.tenantid+'/changetype/edit',test).success(function(result) {
    	    	console.log(result);
    	    	$scope.chargemodel = result;
    	    	if(result.isActive == 't'){
    	    		$scope.chargemodel.isActive = true;
    	    	}else{
    	    		$scope.chargemodel.isActive = false;
    	    	}    	    	
    	    });    	
    }
   
    
    
    
    

});



'use strict';
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
});