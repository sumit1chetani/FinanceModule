'use strict';

app.controller('packageTypeaddCtrl', function($scope, $rootScope, $http, $location, logger,
        utilsService,$state,sharedProperties,$window,validationService,toaster,$stateParams) {	
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.edit = true;
    $scope.packageType ={
    		packageTypeid : '',
    		code : '',
    		name : '',
    		description : '',
    		isActive : true,
    		isActive1 : ''

    };
    
    $scope.cancel = function(){
        $state.go("app.master.packageType.list",{tenantid:$stateParams.tenantid});
    };  
   
    

    
    //edit
    var editid = $location.search().rowid;    
    var test = parseInt(editid);
    if(test){
    	$scope.edit = false;
    	 $http.post($stateParams.tenantid+'/packageType/edit',test).success(function(result) {
    	    	console.log(result);
    	    	$scope.packageType = result;
    	    	if(result.isStstus == "t"){
    	    		$scope.packageType.isActive = true;
    	    	}else{
    	    		$scope.packageType.isActive = false;
    	    	}    	    	
    	    });    	
    }
    
    $scope.validate = function(packageTypeForm) {
       // if (new validationService().checkFormValidity(packageTypeForm)) {
            if($scope.edit){
                $scope.save($scope.packageType,packageTypeForm);
            }else{
                $scope.update($scope.packageType,packageTypeForm);
            }
        }/*else {
            toaster.pop('error', "Please fill the required fields",
                    logger.getErrorHtmlNew(packageTypeForm.$validationSummary),5000, 'trustedHtml');
        }*/
    
   
    //save
    $scope.save = function(packageType,packageTypeForm) {
    	console.log($scope.packageType);
		var msg = $scope.checkValidation();
		if (!$scope.checkundefined(msg)) {
			logger.logError(msg);
		}else{
    	 $http.post($stateParams.tenantid+'/packageType/save', $scope.packageType).success(function(result) {    	
    		 console.log(result);
             if (result == 1) {
                 logger.logSuccess("Saved Successfully!");
                 $state.go("app.master.packageType.list",{tenantid:$stateParams.tenantid});
             } else {
                 logger.logError("Name Already Exists");
             } 
    	 
         });  
    }
    };
    
    
    $scope.checkValidation = function() {

		var alertmsg = "<ui><h4>Please fill the required fields</h4>";
		var msg = "";
		if ($scope.checkundefined($scope.packageType.code)) {
			msg = msg + "<li>Code :Field is required.</li>";
			$scope.changecolor('Code');
		} else {
			$scope.clearcolor('Code');
		}
		if ($scope.checkundefined($scope.packageType.name)) {
			msg = msg + "<li>Name :Field is required.</li>";
			$scope.changecolor('Name');
		} else {
			$scope.clearcolor('Name');
		}
		alertmsg = alertmsg + msg + "</ui>";
		if ($scope.checkundefined(msg)) {
			return '';
		} else {
			return alertmsg;
		}
    }
   
    $scope.checkundefined = function(value) {
		var invalid = false;
		if (value == undefined || value == 'undefined'
				|| value == null || value == 'null'
				|| value == '') {
			invalid = true;
		}
		return invalid;
		

	}

	$scope.changecolor = function(id) {
		$('#' + id + ' .selectivityId').find('input').css(
				"border-color", "red");
		;

	}
	$scope.clearcolor = function(id) {
		$('#' + id + ' .selectivityId').find('input').css(
				"border-color", "#e8dddd");
		;

	}
/*    //update
    $scope.update = function(packageType,packageTypeForm) {
   	 $http.post($stateParams.tenantid+'/packageType/update', $scope.packageType).success(function(result) {    	
   		 console.log(result);
   		var msg = $scope.checkValidation();
		if (!$scope.checkundefined(msg)) {
			logger.logError(msg);
		}else{
    	 $http.post($stateParams.tenantid+'/packageType/save', $scope.packageType).success(function(result) {    	
    		 console.log(result);
             if (result == 1) {
                 logger.logSuccess("updated Successfully!");
                 $state.go("app.master.packageType.list",{tenantid:$stateParams.tenantid});
             } else {
                 logger.logError("Name Already Exists");
             } 
    	 
         });  
    }
            if (result == 1) {
                logger.logSuccess("Update Successfully!");
                $state.go("app.master.packageType.list",{tenantid:$stateParams.tenantid});
            } else {
                logger.logError(result.message);
            }             
        });        
   }; */
   
   
   
   
   
   
   

   
   //update
    $scope.update = function(packageType,packageTypeForm) {
	   	 $http.post($stateParams.tenantid+'/packageType/update', $scope.packageType).success(function(result) {    	
  		 console.log(result);
           if (result == 1) {
               logger.logSuccess("Update Successfully!");
               $state.go("app.master.packageType.list",{tenantid:$stateParams.tenantid});
           } else {
               logger.logError(result.message);
           }             
       });        
  }; 
   
   
   
   
   $scope.reset = function(packageTypeForm) {
       
       if($scope.isEdit = true){
    	   $scope.packageType. code = '';
    	   $scope.packageType. name = '';
    	   $scope.packageType.description = '';
    	   $scope.packageType. isActive = '';
    	 
    	 
      	 $http.post($stateParams.tenantid+'/packageType/edit',test).success(function(result) {
 	    	console.log(result);
 	    	$scope.packageType = result;
 	    	if(result.isStstus == "t"){
 	    		$scope.packageType.isActive = true;
 	    	}else{
 	    		$scope.packageType.isActive = false;
 	    	}    	    	
 	    });    	
   	
       }
       else{
    	   $scope.packageType. code = '';
    	   $scope.packageType. name = '';
    	   $scope.packageType.description = '';
    	   $scope.packageType. isActive = '';
     	  
         
       } $scope.monthSchedule='';
	 $('#truckTrailMapScheduler').fullCalendar('destroy');
       
 }



 
    

});



