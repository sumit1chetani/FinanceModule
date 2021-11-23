'use strict';

app.controller('iataaddCtrl', function($scope, $rootScope, $http, $location, logger,
        utilsService,$state,sharedProperties,$window,validationService,toaster,$stateParams) {	
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.edit = true;
    $scope.IATA ={
    		iataid : '',
    		
    		iataCode : '',
    		iataName : '',
    		iataCity : '',
    	description : '',
    		isActive : true,
    		iataCityid : ''	,
    		isStstus : ''
    };
       $scope.cancel = function(){
        $state.go("app.master.iata.list",{tenantid:$stateParams.tenantid});
    };  
   
    
    $scope.cityList=[];
    $scope.test=function(){
        $http.get($stateParams.tenantid+'/iata/citylist').success(function(datas) {
        	console.log(datas);
            $scope.cityList = datas.selectivitybean;
            
           

        }).error(function(data) {

        });
        
     
    }
    $scope.test();
    
    //edit
    var editid = $location.search().rowid;    
    var test = parseInt(editid);
    if(test){
    	$scope.edit = false;
    	 $http.post($stateParams.tenantid+'/iata/edit',test).success(function(result) {
    	    	console.log(result);
    	    	$scope.IATA = result;
    	    $scope.IATA.iataCity=result.iataCity.toString();
    	    	if(result.isStstus == "t"){
    	    		$scope.IATA.isActive = true;
    	    	}else{
    	    		$scope.IATA.isActive = false;
    	    	}    	    	
    	    });    	
    }
    
    $scope.validate = function(IATAForm) {
   if (new validationService().checkFormValidity(IATAForm)) {
            if($scope.edit){
                $scope.save($scope.IATA,IATAForm);
            }else{
                $scope.update($scope.IATA,IATAForm);
            }
        } else {
            toaster.pop('error', "Please fill the required fields",
                    logger.getErrorHtmlNew(IATAForm.$validationSummary),5000, 'trustedHtml');
        }
    };
    
    //save
    $scope.save = function(IATA,IATAForm) {
    	 $http.post($stateParams.tenantid+'/iata/save', $scope.IATA).success(function(result) {    	
    		 console.log(result);
             if (result == 1) {
                 logger.logSuccess("Saved Successfully!");
                 $state.go("app.master.iata.list",{tenantid:$stateParams.tenantid});
             } else {
            	 logger.logError("NAME ALREADY EXISTS");
            	 
             }             
         });        
    };
    
    //update
    $scope.update = function(IATA,IATAForm) {
   	 $http.post($stateParams.tenantid+'/iata/update', $scope.IATA).success(function(result) {    	
   		 console.log(result);
            if (result == 1) {
                logger.logSuccess("Update Successfully!");
                $state.go("app.master.iata.list",{tenantid:$stateParams.tenantid});
            } else {
                logger.logError("NAME ALREADY EXISTS");
            }             
        });        
   }; 
    
	  $scope.reset = function(IATAForm) {
	        
	        if($scope.isEdit = true){
	           
	            $scope.IATA.iataid ='';
	       	 $scope.IATA.iataCode ='';
	       	 $scope.IATA.iataName ='';
	       	 $scope.IATA.iataCity ='';
	       	 $scope.IATA.description ='';
	       	 $scope.IATA.isActive ='';

	       	 $scope.IATA.iataCityid ='';


	    	 $http.post($stateParams.tenantid+'/iata/edit',test).success(function(result) {
	    	    	console.log(result);
	    	    	$scope.IATA = result;
	    	    $scope.IATA.iataCity=result.iataCity.toString();
	    	    if(result.isStstus == "t"){
    	    		$scope.IATA.isActive = true;
    	    	}else{
    	    		$scope.IATA.isActive = false;
    	    	}  	
	    	    });    	
	        }
	        else{
	       	 $scope.IATA.iataCode ='';
	       	 $scope.IATA.iataName ='';
	       	 $scope.IATA.iataCity ='';
	       	 $scope.IATA.description ='';
	       	 $scope.IATA.isActive ='';

	       	 $scope.IATA.iataCityid ='';
	      	  
	          
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