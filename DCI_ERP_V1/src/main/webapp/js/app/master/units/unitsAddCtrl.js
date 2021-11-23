'use strict';

app.controller('unitsaddCtrl', function($scope, $rootScope, $http, $location, logger,
        utilsService,$state,sharedProperties,$window,validationService,toaster,$stateParams) {	
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.edit = true;
   
    $scope.unit ={
    		unitid :'',
    		code : '',
    		name : '',
    		mode:'',
    		modeid:'',
    		description : '',
    		isActive : true
    };
    
    $scope.cancel = function(){
        $state.go("app.master.units.list",{tenantid:$stateParams.tenantid});
    };  
   
    
    $scope.modeList=[];
    $scope.test=function(){
        $http.get($stateParams.tenantid+'/units/modeList').success(function(datas) {
        	console.log(datas);
            $scope.modeList = datas.selectivitybean;
            
           

        }).error(function(data) {

        });
        
     
    }
    $scope.test();
    
    //edit
    var editid = $location.search().rowid;    
    var test = parseInt(editid);
    if(test){
    	$scope.edit = false;
    	 $http.post($stateParams.tenantid+'/units/edit',test).success(function(result) {
    	    	console.log(result);
    	    	$scope.unit = result;
    	    	$scope.unit.mode = result.mode.toString();
    		   if(result.isStstus == "t"){
    	    		$scope.unit.isActive = true;
    	    	}else{
    	    		$scope.unit.isActive = false;
    	    	}    	    	
    	    });    	
    }
    
    $scope.validate = function(unitForm) {
      if (new validationService().checkFormValidity(unitForm)) {
            if($scope.edit){
                $scope.save($scope.unit,unitForm);
            }else{
                $scope.update($scope.unit,unitForm);
            }
        } else {
            toaster.pop('error', "Please fill the required fields",
                    logger.getErrorHtmlNew(unitForm.$validationSummary),5000, 'trustedHtml');
        }
    };
    
    //save
    $scope.save = function(unit,unitForm) {
    	 $http.post($stateParams.tenantid+'/units/save', $scope.unit).success(function(result) {    	
    		 console.log(result);
             if (result == 1) {
                 logger.logSuccess("Saved Successfully!");
                 $state.go("app.master.units.list",{tenantid:$stateParams.tenantid});
             } else {
                 logger.logError("Name Already Exists");
             }             
         });        
    };
    
    //update
    $scope.update = function(unit,unitForm) {
   	 $http.post($stateParams.tenantid+'/units/update', $scope.unit).success(function(result) {    	
   		 console.log(result);
            if (result == 1) {
                logger.logSuccess("Update Successfully!");
                $state.go("app.master.units.list",{tenantid:$stateParams.tenantid});
            } else {
                logger.logError(result.message);
            }             
        });        
   }; 
   $scope.reset = function(unitForm) {
       
       if($scope.isEdit = true){
          
    	   
           $scope.unit.unitid ='';
           $scope.unit.code ='';
           $scope.unit.name ='';
           $scope.unit.modeid ='';
           $scope.unit.mode ='';
           $scope.unit.description ='';
           $scope.unit.isActive ='';
    


      	 $http.post($stateParams.tenantid+'/units/edit',test).success(function(result) {
 	    	console.log(result);
 	    	$scope.unit = result;
 	    	$scope.unit.city = result.city.toString();
 	    	if(result.isStstus == "t"){
 	    		$scope.unit.isActive = true;
 	    	}else{
 	    		$scope.unit.isActive = false;
 	    	}    	    	
 	    });    	
       }
       else{
    	   $scope.unit.unitid ='';
           $scope.unit.code ='';
           $scope.unit.name ='';
           $scope.unit.modeid ='';
           $scope.unit.mode='';
           $scope.unit.description ='';
           $scope.unit.isActive ='';
      
         
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