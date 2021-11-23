/**
 * 
 */
'use strict';

app.controller('leaseAgreementAddCtrl', function($scope, $rootScope, $http, $location, logger,
        utilsService,$state,sharedProperties,$window,validationService,toaster,$stateParams) {	
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.edit = true;
    $scope.lease ={
    		code :'',
    		description : '',
    		created_by: '',
            created_date : '',
          modified_by: '',
       modified_date: '',

    	
    };
    
    $scope.cancel = function(){
        $state.go("app.eqc.leaseagreementtype.list",{tenantid:$stateParams.tenantid});
    };  
   
    
    //edit
    var editid = $location.search().code;    
     if(editid != null && editid != ""){
    	$scope.edit = false;
    	var url = $stateParams.tenantid+'/api/lease/edit?code='+ editid;
        $http.get(url).success(function(result) {
    	    	console.log(result);
    	    	$scope.lease = result;
 
     	    });    	
    }
    
    $scope.validate = function(leaseForm) {
            if($scope.edit){
                $scope.save($scope.lease,leaseForm);
            }else{
                $scope.update($scope.lease,leaseForm);
            }
        } 
    
    //save
    $scope.save = function(lease,leaseForm) {
    	var msg = $scope.checkValidation();
    	if (!$scope.checkundefined(msg)) {
			logger.logError(msg);
    	}else{
    	 $http.post($stateParams.tenantid+'/api/lease/save', $scope.lease).success(function(result) {    	
    		 console.log(result);
             if (result.isSuccess) {
                 logger.logSuccess("Saved Successfully!");
                 $state.go("app.eqc.leaseagreementtype.list",{tenantid:$stateParams.tenantid});
             } else {
                 logger.logError(result.message);
             }             
         });
    	}
    };
    $scope.checkValidation = function() {

		var alertmsg = "<ui><h4>Please fill the required fields</h4>";
		var msg = "";
		if ($scope.checkundefined($scope.lease.code)) {
			msg = msg + "<li>Code :Field is required.</li>";
			$scope.changecolor('Code');
		} else {
			$scope.clearcolor('Code');
		}
		if ($scope.checkundefined($scope.lease.description)) {
			msg = msg + "<li>Description :Field is required.</li>";
			$scope.changecolor('Description');
		} else {
			$scope.clearcolor('Description');
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
    $scope.update = function(lease,leaseForm) {
    	console.log($scope.lease);
    	var msg = $scope.checkValidation();
    	if (!$scope.checkundefined(msg)) {
			logger.logError(msg);
    	}else{
   	 $http.post($stateParams.tenantid+'/api/lease/update', $scope.lease).success(function(result) {    	
   		 console.log(result);
            if (result.isSuccess) {
                logger.logSuccess("Update Successfully!");
                $state.go("app.eqc.leaseagreementtype.list",{tenantid:$stateParams.tenantid});
            } else {
                logger.logError(result.message);
            }             
        });   
   	 
    	}
   }; 
   $scope.reset = function(leaseForm) {
       
       if(!$scope.edit){
       	var url = $stateParams.tenantid+'/api/lease/edit?code='+ editid;
        $http.get(url).success(function(result) {
    	    	console.log(result);
    	    	$scope.area = result;
    	
     	    });      	
       }
       else{
    	   $scope.lease.code ='';
           $scope.lease.description ='';
    
      
         
       }  
       
 }



 
    

});


