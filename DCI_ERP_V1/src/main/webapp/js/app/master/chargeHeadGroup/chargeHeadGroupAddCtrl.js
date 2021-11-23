'use strict';

app.controller('chargeHeadGroupAddCtrl', function($scope, $rootScope, $http, $location, logger,
        utilsService,$state,sharedProperties,$window,validationService,toaster,$stateParams) {	
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.edit = true;
    $scope.chargeHeadGroup ={
    		chargeHeadGroupid : '',
    		
    	code : '',
    		name : '',
    
    	description : '',
    		isActive : true,
    		isStstus : ''
    };
    
    $scope.cancel = function(){
        $state.go("app.master.chargeHeadGroup.list",{tenantid:$stateParams.tenantid});
    };  
   
    
    $scope.cityList=[];
/*    $scope.test=function(){
        $http.get($stateParams.tenantid+'/chargeHeadGroup/list').success(function(datas) {
        	console.log(datas);
            $scope.cityList = datas.selectivitybean;
            
           

        }).error(function(data) {

        });
        
     
    }
    $scope.test();*/
    
    //edit
    var editid = $location.search().rowid;    
    var test = parseInt(editid);
    if(test){
    	$scope.edit = false;
    	 $http.post($stateParams.tenantid+'/chargeHeadGroup/edit',test).success(function(result) {
    	    	console.log(result);
    	    	$scope.chargeHeadGroup = result;
    	    	if(result.isStstus == "t"){
    	    		$scope.chargeHeadGroup.isActive = true;
    	    	}else{
    	    		$scope.chargeHeadGroup.isActive = false;
    	    	}    	    	
    	    });    	
    }
    
    $scope.validate = function(chargeHeadGroupForm) {
       // if (new validationService().checkFormValidity(chargeHeadGroupForm)) {
            if($scope.edit){
                $scope.save($scope.chargeHeadGroup,chargeHeadGroupForm);
            }else{
                $scope.update($scope.chargeHeadGroupchargeHeadGroupForm);
            }
        } /*else {
            toaster.pop('error', "Please fill the required fields",
                    logger.getErrorHtmlNew(chargeHeadGroupForm.$validationSummary),5000, 'trustedHtml');
        }*/
    //};
   
    //save
    $scope.save = function(chargeHeadGroup,chargeHeadGroupForm) {
    	console.log($scope.chargeHeadGroup);
    	var msg = $scope.checkValidation();
    	if (!$scope.checkundefined(msg)) {
			logger.logError(msg);
    	}else{
    	 $http.post($stateParams.tenantid+'/chargeHeadGroup/save', $scope.chargeHeadGroup).success(function(result) {    	
    		 console.log(result);
             if (result == 1) {
                 logger.logSuccess("Saved Successfully!");
                 $state.go("app.master.chargeHeadGroup.list",{tenantid:$stateParams.tenantid});
             } else {
            	 logger.logError("Name Already Exists");
             }           
         }); 
    }
    };
    
    $scope.checkValidation = function() {

		var alertmsg = "<ui><h4>Please fill the required fields</h4>";
		var msg = "";
		if ($scope.checkundefined($scope.chargeHeadGroup.code)) {
			msg = msg + "<li>Code :Field is required.</li>";
			$scope.changecolor('Code');
		} else {
			$scope.clearcolor('Code');
		}
		if ($scope.checkundefined($scope.chargeHeadGroup.name)) {
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
    //update
    $scope.update = function(chargeHeadGroup,chargeHeadGroupForm) {
    	console.log($scope.chargeHeadGroup);
    	var msg = $scope.checkValidation();
    	if (!$scope.checkundefined(msg)) {
			logger.logError(msg);
    	}
    	else{
   	 $http.post($stateParams.tenantid+'/chargeHeadGroup/update', $scope.chargeHeadGroup).success(function(result) {    	
   		 console.log(result);
            if (result == 1) {
                logger.logSuccess("Update Successfully!");
                $state.go("app.master.chargeHeadGroup.list",{tenantid:$stateParams.tenantid});
            } else {
                logger.logError(result.message);
            }             
        });    
    	}
   }; 
    
	  $scope.reset = function(chargeHeadGroupForm) {
	        
	        if($scope.isEdit = true){
	           
	            $scope.chargeHeadGroup.	chargeHeadGroupid ='';
	       	 $scope.chargeHeadGroup.code ='';
	       	 $scope.chargeHeadGroup.name ='';
	       	 $scope.chargeHeadGroup.description ='';
	       	 $scope.chargeHeadGroup.isActive ='';



	    	 $http.post($stateParams.tenantid+'/chargeHeadGroup/edit',test).success(function(result) {
	    	    	console.log(result);
	    	    	$scope.chargeHeadGroup = result;
	    	    	if(result.isStstus == "t"){
	    	    		$scope.chargeHeadGroup.isActive = true;
	    	    	}else{
	    	    		$scope.chargeHeadGroup.isActive = false;
	    	    	}    	   	    	
	    	    });    	
	        }
	        else{
	       	 $scope.chargeHeadGroup.code ='';
	       	 $scope.chargeHeadGroup.name ='';
	       	 $scope.chargeHeadGroup.description ='';
	       	 $scope.chargeHeadGroup.isActive ='';

	      	  
	          
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