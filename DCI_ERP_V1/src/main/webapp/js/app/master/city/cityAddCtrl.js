'use strict';

app.controller('cityaddCtrl', function($scope, $rootScope, $http, $location, logger,
        utilsService,$state,sharedProperties,$window,validationService,toaster,$stateParams) {	
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.edit = true;
    $scope.city ={
    		cityid :'',
    		code : '',
    		name : '',
    		stateid : '',
    		state : '',
    		description : '',
    		pin:'',
    		isActive : true
    };
    
    $scope.cancel = function(){
        $state.go("app.master.city.list",{tenantid:$stateParams.tenantid});
    };  
   
    
    $scope.stateList=[];
    $scope.test=function(){
        $http.get($stateParams.tenantid+'/city/statelist').success(function(datas) {
        	console.log(datas);
            $scope.stateList = datas.selectivitybean;
            
           

        }).error(function(data) {

        });
        
     
    }
    $scope.test();
    
    //edit
    var editid = $location.search().rowid;    
    var test = parseInt(editid);
    if(test){
    	$scope.edit = false;
    	 $http.post($stateParams.tenantid+'/city/edit',test).success(function(result) {
    	    	console.log(result);
    	    	$scope.city = result;
    	    	$scope.city.state = result.state.toString();
    	    	if(result.isStstus == "t"){
    	    		$scope.city.isActive = true;
    	    	}else{
    	    		$scope.city.isActive = false;
    	    	}    	    	
    	    });    	
    }
    
    $scope.validate = function(cityForm) {
        if (new validationService().checkFormValidity($scope.cityForm)) {
            if($scope.edit){
                $scope.save($scope.city,cityForm);
            }else{
                $scope.update($scope.city,cityForm);
            }
        } else {
            toaster.pop('error', "Please fill the required fields",
                    logger.getErrorHtmlNew(cityForm.$validationSummary),5000, 'trustedHtml');
        }
    };
    
    //save
    $scope.save = function(city,cityForm) {
    	 $http.post($stateParams.tenantid+'/city/save', $scope.city).success(function(result) {    	
    		 console.log(result);
             if (result == 1) {
                 logger.logSuccess("Saved Successfully!");
                 $state.go("app.master.city.list",{tenantid:$stateParams.tenantid});
             } else {
                 logger.logError("Name Already Exists");
             }             
         });        
    };
    
    //update
    $scope.update = function(port,portForm) {
   	 $http.post($stateParams.tenantid+'/city/update', $scope.city).success(function(result) {    	
   		 console.log(result);
            if (result == 1) {
                logger.logSuccess("Update Successfully!");
                $state.go("app.master.city.list",{tenantid:$stateParams.tenantid});
            } else {
                logger.logError(result.message);
            }             
        });        
   }; 
   $scope.reset = function(portForm) {
       
       if($scope.isEdit = true){
          
           $scope.city.cityid ='';
           $scope.city.code ='';
           $scope.city.name ='';
           $scope.city.stateid ='';
           $scope.city.state ='';
           $scope.city.description ='';
           $scope.city.pin ='';
           $scope.city.isActive ='';
    


      	 $http.post($stateParams.tenantid+'/city/edit',test).success(function(result) {
 	    	console.log(result);
 	    	$scope.city = result;
	    	$scope.city.state = result.state.toString();
	    	if(result.isStstus == "t"){
	    		$scope.city.isActive = true;
	    	}else{
	    		$scope.city.isActive = false;
	    	}    	    	
 	    	    	    	
 	    });    	
       }
       else{
    	   $scope.city.cityid ='';
           $scope.city.code ='';
           $scope.city.name ='';
           $scope.city.stateid ='';
           $scope.city.state ='';
           $scope.city.description ='';
           $scope.city.pin ='';
           $scope.city.isActive ='';
         
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