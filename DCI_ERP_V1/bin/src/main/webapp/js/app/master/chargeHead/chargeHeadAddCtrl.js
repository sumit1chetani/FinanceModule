'use strict';

app.controller('chargeHeadAddCtrl', function($scope, $rootScope, $http, $location, logger,
        utilsService,$state,sharedProperties,$window,validationService,toaster,$stateParams) {	
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.edit = true;
    $scope.chargeHead ={
    	id : '',
    		
    		code : '',
    		name : '',
    		group : '',
    	groupName : '',
    		isActive : true,
    		isStstus : '',
    		pName:'',
    		sName:'',
    		description:'',
    		sacNo:'',
    		accountHead:'',
    		cgst:'',
    		sgst:'',
    		igst:'',
    		gst:''
    };
    
    $scope.cancel = function(){
        $state.go("app.master.chargeHead.list",{tenantid:$stateParams.tenantid});
    };  
   
    
    $scope.groupList=[];
    $scope.test=function(){
        $http.get($stateParams.tenantid+'/chargeHead/grouplist').success(function(datas) {
        	console.log(datas);
            $scope.groupList = datas.selectivitybean;
            $scope.accountHeadList = datas.accountHeadList;
            $scope.accountHeadListRevenue = datas.accountHeadListRevenue;
        }).error(function(data) {

        });
        
     
    }
    $scope.test();
    
    //edit
    var editid = $location.search().rowid;    
    var test = parseInt(editid);
    if(test){
    	$scope.edit = false;
    	 $http.post($stateParams.tenantid+'/chargeHead/edit',test).success(function(result) {
    	    	console.log(result);
    	    	$scope.chargeHead = result;
    	    $scope.chargeHead.group=result.group.toString();
    	    	if(result.isStstus == "t"){
    	    		$scope.chargeHead.isActive = true;
    	    	}else{
    	    		$scope.chargeHead.isActive = false;
    	    	}    	    	
    	    });    	
    }
    
    $scope.validate = function(chargeHeadForm) {
        //if (new validationService().checkFormValidity(chargeHeadForm)) {
            if($scope.edit){
                $scope.save($scope.chargeHead,chargeHeadForm);
            }else{
                $scope.update($scope.chargeHead,chargeHeadForm);
            }
        }/* else {
        	 logger.logError("Name Already Exists");
        }*/
    //};
    
    //save
    $scope.save = function(chargeHead,chargeHeadForm) {
    	console.log($scope.chargeHeadGroup);
    	var msg = $scope.checkValidation();
    	if (!$scope.checkundefined(msg)) {
			logger.logError(msg);
    	}else{
    	// $http.post($stateParams.tenantid+'/chargeHead/save', $scope.chargeHead).success(function(result) {    	
        	 $http.post($stateParams.tenantid+'/chargeHead/save', $scope.chargeHead).success(function(result) {    	

    		 console.log(result);
             if (result == 1) {
                 logger.logSuccess("Saved Successfully!");
                 $state.go("app.master.chargeHead.list",{tenantid:$stateParams.tenantid});
             } else {
            	 logger.logError("Name Already Exists");
             }             
         });    
    	}
    };
    $scope.checkValidation = function() {

		var alertmsg = "<ui><h4>Please fill the required fields</h4>";
		var msg = "";
		if ($scope.checkundefined($scope.chargeHead.code)) {
			msg = msg + "<li>Charge Head Code :Field is required.</li>";
			$scope.changecolor('Code');
		} else {
			$scope.clearcolor('Code');
		}
		if ($scope.checkundefined($scope.chargeHead.name)) {
			msg = msg + "<li>Charge Head Name :Field is required.</li>";
			$scope.changecolor('Name');
		} else {
			$scope.clearcolor('Name');
		}
		if ($scope.checkundefined($scope.chargeHead.sName)) {
			msg = msg + "<li>Sales Ledger Name :Field is required.</li>";
			$scope.changecolor('Sales Name');
		} else {
			$scope.clearcolor('Sales Name');
		}
		if ($scope.checkundefined($scope.chargeHead.pName)) {
			msg = msg + "<li>Purchase Ledger Name :Field is required.</li>";
			$scope.changecolor('Purchase Name');
		} else {
			$scope.clearcolor('Purchase Name');
		}
		if ($scope.checkundefined($scope.chargeHead.sacNo)) {
			msg = msg + "<li>Sac No:Field is required.</li>";
			$scope.changecolor('Sac No');
		} else {
			$scope.clearcolor('Sac No');
		}
		if ($scope.checkundefined($scope.chargeHead.group)) {
			msg = msg + "<li>Charge Head Group :Field is required.</li>";
			$scope.changecolor('Group');
		} else {
			$scope.clearcolor('Group');
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
    $scope.update = function(chargeHead,chargeHeadForm) {
    	console.log($scope.chargeHeadGroup);
    	var msg = $scope.checkValidation();
    	if (!$scope.checkundefined(msg)) {
			logger.logError(msg);
    	}
    	else{
   	 $http.post($stateParams.tenantid+'/chargeHead/update', $scope.chargeHead).success(function(result) {    	
   		 console.log(result);
            if (result == 1) {
                logger.logSuccess("Update Successfully!");
                $state.go("app.master.chargeHead.list",{tenantid:$stateParams.tenantid});
            } else {
                logger.logError(result.message);
            }             
        });    
    	}
   }; 
    
	  $scope.reset = function(chargeHeadForm) {
	        
	        if($scope.isEdit = true){
	           
	            $scope.chargeHead.id ='';
	       	 $scope.chargeHead.code ='';
	       	 $scope.chargeHead.name ='';
	       	 $scope.chargeHead.group ='';
	       	 $scope.chargeHead.pname ='';

	       	 $scope.chargeHead.sname ='';

	       	 $scope.chargeHead.description ='';
	       	 $scope.chargeHead.isActive ='';

	       	 $scope.chargeHead.sacNo ='';
	       	 $scope.chargeHead.accountHead='';

	    	 $http.post($stateParams.tenantid+'/chargeHead/edit',test).success(function(result) {
	    	    	console.log(result);
	    	    	$scope.chargeHead = result;
	    	    $scope.chargeHead.group=result.group.toString();
	    		if(result.isStstus == "t"){
    	    		$scope.chargeHead.isActive = true;
    	    	}else{
    	    		$scope.chargeHead.isActive = false;
    	    	}   	    	
	    	    });    	
	        }
	        else{
	            $scope.chargeHead.id ='';
		       	 $scope.chargeHead.code ='';
	         	 $scope.chargeHead.name ='';
		       	 $scope.chargeHead.group ='';
		       	 $scope.chargeHead.pname ='';

		       	 $scope.chargeHead.sname ='';

		       	 $scope.chargeHead.description ='';
		       	 $scope.chargeHead.isActive ='';

		       	 $scope.chargeHead.sacNo ='';
		       	 $scope.chargeHead.accountHead='';
	      	  
	          
	        } $scope.monthSchedule='';
     	 $('#truckTrailMapScheduler').fullCalendar('destroy');
	        
	  }

});

app.controller('chargeHeadViewCtrl', function($scope, $rootScope, $http, $location, logger,
        utilsService,$state,sharedProperties,$window,validationService,toaster,$stateParams) {	
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.edit = true;
    $scope.chargeHead ={
    	id : '',
    		
    		code : '',
    		name : '',
    		group : '',
    	groupName : '',
    		isActive : true,
    		isStstus : '',
    		pName:'',
    		sName:'',
    		description:'',
    		sacNo:'',
    		accountHead:'',
    		cgst:'',
    		sgst:'',
    		igst:'',
    		gst:''
    };
    
    $scope.cancel = function(){
        $state.go("app.master.chargeHead.list",{tenantid:$stateParams.tenantid});
    };  
   
    
    $scope.groupList=[];
    $scope.test=function(){
        $http.get($stateParams.tenantid+'/chargeHead/grouplist').success(function(datas) {
        	console.log(datas);
            $scope.groupList = datas.selectivitybean;
            $scope.accountHeadList = datas.accountHeadList;
            $scope.accountHeadListRevenue = datas.accountHeadListRevenue;
        }).error(function(data) {

        });
        
     
    }
    $scope.test();
    
    //edit
    var editid = $location.search().rowid;    
    var test = parseInt(editid);
    if(test){
    	$scope.edit = false;
    	 $http.post($stateParams.tenantid+'/chargeHead/view',test).success(function(result) {
    	    	console.log(result);
    	    	$scope.chargeHead = result;
    	    $scope.chargeHead.group=result.group.toString();
    	    	if(result.isStstus == "t"){
    	    		$scope.chargeHead.isActive = true;
    	    	}else{
    	    		$scope.chargeHead.isActive = false;
    	    	}    	    	
    	    });    	
    }
    
    $scope.validate = function(chargeHeadForm) {
        //if (new validationService().checkFormValidity(chargeHeadForm)) {
            if($scope.edit){
                $scope.save($scope.chargeHead,chargeHeadForm);
            }else{
                $scope.update($scope.chargeHead,chargeHeadForm);
            }
        }/* else {
        	 logger.logError("Name Already Exists");
        }*/
    //};
    
    //save
    
    $scope.checkundefined = function(value) {
		var invalid = false;
		if (value == undefined || value == 'undefined'
				|| value == null || value == 'null'
				|| value == '') {
			invalid = true;
		}
		return invalid;
		

	}
    //update
    
	  $scope.reset = function(chargeHeadForm) {
	        
	        if($scope.isEdit = true){
	           
	            $scope.chargeHead.id ='';
	       	 $scope.chargeHead.code ='';
	       	 $scope.chargeHead.name ='';
	       	 $scope.chargeHead.group ='';
	       	 $scope.chargeHead.pname ='';

	       	 $scope.chargeHead.sname ='';

	       	 $scope.chargeHead.description ='';
	       	 $scope.chargeHead.isActive ='';

	       	 $scope.chargeHead.sacNo ='';
	       	 $scope.chargeHead.accountHead='';

	    	 $http.post($stateParams.tenantid+'/chargeHead/view',test).success(function(result) {
	    	    	console.log(result);
	    	    	$scope.chargeHead = result;
	    	    $scope.chargeHead.group=result.group.toString();
	    		if(result.isStstus == "t"){
    	    		$scope.chargeHead.isActive = true;
    	    	}else{
    	    		$scope.chargeHead.isActive = false;
    	    	}   	    	
	    	    });    	
	        }
	        else{
	            $scope.chargeHead.id ='';
		       	 $scope.chargeHead.code ='';
	         	 $scope.chargeHead.name ='';
		       	 $scope.chargeHead.group ='';
		       	 $scope.chargeHead.pname ='';

		       	 $scope.chargeHead.sname ='';

		       	 $scope.chargeHead.description ='';
		       	 $scope.chargeHead.isActive ='';

		       	 $scope.chargeHead.sacNo ='';
		       	 $scope.chargeHead.accountHead='';
	      	  
	          
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