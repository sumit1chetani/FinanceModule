'use strict';

app.controller('countryaddCtrl', function($scope, $rootScope, $http, $location, logger,
        utilsService,$state,sharedProperties,$window,validationService,toaster,$stateParams) {	
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.edit = true;
    $scope.country ={
    		countryid :'',
    		code : '',
    		name : '',
    		region:'',
    		regionid:'',
    		description : '',
    		isActive : true
    };
    
    $scope.cancel = function(){
        $state.go("app.master.country.list",{tenantid:$stateParams.tenantid});
    };  
   
    
    $scope.regionList=[];
    $scope.test=function(){
        $http.get($stateParams.tenantid+'/country/regionlist').success(function(datas) {
        	console.log(datas);
            $scope.regionList = datas.selectivitybean;
            
           

        }).error(function(data) {

        });
        
     
    }
    $scope.test();
  
    
    //edit
    var editid = $location.search().rowid;    
    var test = parseInt(editid);
    if(test){
    	$scope.edit = false;
    	
    	 $http.post($stateParams.tenantid+'/country/edit',test).success(function(result) {
    	    	console.log(result);
    	    	$scope.country = result;
    	    	$scope.country.region = result.region.toString();
    	    	if(result.isStstus == "t"){
    	    		$scope.country.isActive = true;
    	    	}else{
    	    		$scope.country.isActive = false;
    	    	}    	    	
    	    });    	
    }
    
    $scope.validate = function(countryForm) {
       // if (new validationService().checkFormValidity(portForm)) {
            if($scope.edit){
                $scope.save($scope.country,countryForm);
            }else{
                $scope.update($scope.country,countryForm);
            }
        } /*else {
            toaster.pop('error', "Please fill the required fields",
                    logger.getErrorHtmlNew(portForm.$validationSummary),5000, 'trustedHtml');
        }*/
   // };
    
    //save
    $scope.save = function(port,countryForm) {
    	console.log($scope.country);
    	var msg = $scope.checkValidation();
    	if (!$scope.checkundefined(msg)) {
			logger.logError(msg);
    	}else{
    	 $http.post($stateParams.tenantid+'/country/save', $scope.country).success(function(result) {    	
    		 console.log(result);
             if (result == 1) {
                 logger.logSuccess("Saved Successfully!");
                 $state.go("app.master.country.list",{tenantid:$stateParams.tenantid});
             } else {
                 logger.logError("Name Already Exists");
             }             
         }); 
    	}
    };
    $scope.checkValidation = function() {

		var alertmsg = "<ui><h4>Please fill the required fields</h4>";
		var msg = "";
		if ($scope.checkundefined($scope.country.code)) {
			msg = msg + "<li>Country Code :Field is required.</li>";
			$scope.changecolor('Code');
		} else {
			$scope.clearcolor('Code');
		}
		if ($scope.checkundefined($scope.country.name)) {
			msg = msg + "<li>Country Name :Field is required.</li>";
			$scope.changecolor('Name');
		} else {
			$scope.clearcolor('Name');
		}
		if ($scope.checkundefined($scope.country.region)) {
			msg = msg + "<li>Region Code :Field is required.</li>";
			$scope.changecolor('Rcode');
		} else {
			$scope.clearcolor('Rcode');
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
    $scope.update = function(country,countryForm) {
   	 $http.post($stateParams.tenantid+'/country/update', $scope.country).success(function(result) {    	
   		 console.log(result);
   		console.log($scope.country);
   		var msg = $scope.checkValidation();
    	if (!$scope.checkundefined(msg)) {
			logger.logError(msg);
    	}else{
    	 $http.post($stateParams.tenantid+'/country/save', $scope.country).success(function(result) {    	
    		 console.log(result);
             if (result == 1) {
                 logger.logSuccess("Saved Successfully!");
                 $state.go("app.master.country.list",{tenantid:$stateParams.tenantid});
             } else {
                 logger.logError("Name Already Exists");
             }         
         }); 
    	}
           /* if (result == 1) {
                logger.logSuccess("Update Successfully!");
                $state.go("app.master.country.list",{tenantid:$stateParams.tenantid});
            } else {
                logger.logError(result.message);
            } */            
        });        
   }; 
   $scope.reset = function(countryForm) {
       
       if($scope.isEdit = true){
          
           $scope.country.countryid ='';
           $scope.country.code ='';
           $scope.country.name ='';
           $scope.country.region ='';
           $scope.country.regionid ='';
          $scope.country.description ='';
           $scope.country.isActive ='';
    


      	 $http.post($stateParams.tenantid+'/country/edit',test).success(function(result) {
 	    	console.log(result);
 	    	$scope.country = result;
 	    	$scope.country.region = result.region.toString();
 	    	if(result.isStstus == "t"){
 	    		$scope.country.isActive = true;
 	    	}else{
 	    		$scope.country.isActive = false;
 	    	}    	    	
 	    });    	
       }
       else{
    	   $scope.country.countryid ='';
           $scope.country.code ='';
           $scope.country.name ='';
           $scope.country.region ='';
           $scope.country.regionid ='';
          $scope.country.description ='';
           $scope.country.isActive ='';
      
         
       } $scope.monthSchedule='';
	
       
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