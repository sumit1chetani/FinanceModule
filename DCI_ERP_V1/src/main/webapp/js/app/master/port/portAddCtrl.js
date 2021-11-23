'use strict';

app.controller('portaddCtrl', function($scope, $rootScope, $http, $location, logger,
        utilsService,$state,sharedProperties,$window,validationService,toaster,$stateParams) {	
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.edit = true;
    $scope.port ={
    		portid :'',
    		code : '',
    		name : '',
    		cityid : '',
    		city : '',
    		description : '',
    		isActive : true,isIcd:true,isPort:true,isDepot:true,isLocation:true
    };
    
    $scope.cancel = function(){
        $state.go("app.master.port.list",{tenantid:$stateParams.tenantid});
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
    	 $http.post($stateParams.tenantid+'/port/edit',test).success(function(result) {
    	    	console.log(result);
    	    	$scope.port = result;
    	    	$scope.port.city = result.city.toString();
    	    	if(result.isStstus == "t"){
    	    		$scope.port.isActive = true;
    	    	}else{
    	    		$scope.port.isActive = false;
    	    	}    	    	
    	    });    	
    }
    
    $scope.validate = function(portForm) {
       // if (new validationService().checkFormValidity(portForm)) {
            if($scope.edit){
                $scope.save($scope.port,portForm);
            }else{
                $scope.update($scope.port,portForm);
            }
        } /*else {
            toaster.pop('error', "Please fill the required fields",
                    logger.getErrorHtmlNew(portForm.$validationSummary),5000, 'trustedHtml');
        }*/
   // };
    
    //save
    $scope.save = function(port,portForm) {
    	console.log($scope.port);
    	var msg = $scope.checkValidation();
    	if (!$scope.checkundefined(msg)) {
			logger.logError(msg);
    	}else{
    	 $http.post($stateParams.tenantid+'/port/save', $scope.port).success(function(result) {    	
    		 console.log(result);
             if (result == 1) {
                 logger.logSuccess("Saved Successfully!");
                 $state.go("app.master.port.list",{tenantid:$stateParams.tenantid});
             } else {
                 logger.logError("Name Already Exists");
             }             
         });
    	}
    };
    $scope.checkValidation = function() {

		var alertmsg = "<ui><h4>Please fill the required fields</h4>";
		var msg = "";
		if ($scope.checkundefined($scope.port.code)) {
			msg = msg + "<li>Sea Port Code :Field is required.</li>";
			$scope.changecolor('Code');
		} else {
			$scope.clearcolor('Code');
		}
		if ($scope.checkundefined($scope.port.name)) {
			msg = msg + "<li>Sea Port Name :Field is required.</li>";
			$scope.changecolor('Name');
		} else {
			$scope.clearcolor('Name');
		}
		if ($scope.checkundefined($scope.port.city)) {
			msg = msg + "<li>Country :Field is required.</li>";
			$scope.changecolor('City Code');
		} else {
			$scope.clearcolor('City Code');
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
    $scope.update = function(port,portForm) {
    	console.log($scope.port);
    	var msg = $scope.checkValidation();
    	if (!$scope.checkundefined(msg)) {
			logger.logError(msg);
    	}else{
   	 $http.post($stateParams.tenantid+'/port/update', $scope.port).success(function(result) {    	
   		 console.log(result);
            if (result == 1) {
                logger.logSuccess("Update Successfully!");
                $state.go("app.master.port.list",{tenantid:$stateParams.tenantid});
            } else {
                logger.logError(result.message);
            }             
        });   
   	 
    	}
   }; 
   $scope.reset = function(portForm) {
       
       if($scope.isEdit = true){
          
           $scope.port.portid ='';
           $scope.port.code ='';
           $scope.port.name ='';
           $scope.port.cityid ='';
           $scope.port.city ='';
           $scope.port.description ='';
           $scope.port.isActive ='';
    


      	 $http.post($stateParams.tenantid+'/port/edit',test).success(function(result) {
 	    	console.log(result);
 	    	$scope.port = result;
 	    	$scope.port.city = result.city.toString();
 	    	if(result.isStstus == "t"){
 	    		$scope.port.isActive = true;
 	    	}else{
 	    		$scope.port.isActive = false;
 	    	}    	    	
 	    });    	
       }
       else{
    	   $scope.port.portid ='';
           $scope.port.code ='';
           $scope.port.name ='';
           $scope.port.cityid ='';
           $scope.port.city ='';
           $scope.port.description ='';
           $scope.port.isActive ='';
      
         
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