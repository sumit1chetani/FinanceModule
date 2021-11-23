'use strict';

app.controller('changecomponentaddCtrl', function($scope, $rootScope, $http, $location, logger,
        utilsService,$state,sharedProperties,$window,validationService,toaster,$stateParams) {	
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.edit = true;
    $scope.chargeComponent ={
    		chargeCode : '',
    		chargeName : '',
    		chargeType : '',
    		chargeComponentdescription : '',
    		isActive : true,
    		chargeTypeid : ''	
    };
    
    $scope.cancel = function(){
        $state.go("app.truck.general.changecomponentmenu",{tenantid:$stateParams.tenantid});
    };  
   
    
    $scope.changetypeList=[];
    $scope.test=function(){
        $http.get($stateParams.tenantid+'/changecomponent/currencylist').success(function(datas) {
        	console.log(datas);
            $scope.changetypeList = datas.selectivitybean;
            
           

        }).error(function(data) {

        });
        
     
    }
    $scope.test();
    
    //edit
    var editid = $location.search().rowid;    
    var test = parseInt(editid);
    if(test){
    	$scope.edit = false;
    	 $http.post($stateParams.tenantid+'/changecomponent/edit',test).success(function(result) {
    	    	console.log(result);
    	    	$scope.chargeComponent = result;
    	    	if(result.isActive == 't'){
    	    		$scope.chargeComponent.isActive = true;
    	    	}else{
    	    		$scope.chargeComponent.isActive = false;
    	    	}    	    	
    	    });    	
    }
    
    $scope.validate = function(chargeComponentForm) {
        if (new validationService().checkFormValidity(chargeComponentForm)) {
            if($scope.edit){
                $scope.save($scope.chargeComponent,chargeComponentForm);
            }else{
                $scope.update($scope.chargeComponent,chargeComponentForm);
            }
        } else {
            toaster.pop('error', "Please fill the required fields",
                    logger.getErrorHtmlNew(stateMasterForm.$validationSummary),5000, 'trustedHtml');
        }
    };
    
    //save
    $scope.save = function(chargeComponent,chargeComponentForm) {
    	 $http.post($stateParams.tenantid+'/changecomponent/save', $scope.chargeComponent).success(function(result) {    	
    		 console.log(result);
             if (result == 1) {
                 logger.logSuccess("Saved Successfully!");
                 $state.go("app.truck.general.changecomponentmenu",{tenantid:$stateParams.tenantid});
             } else {
                 logger.logError("Name Already Exists");
             }             
         });        
    };
    
    //update
    $scope.update = function(chargeComponent,chargeComponentForm) {
   	 $http.post($stateParams.tenantid+'/changecomponent/update', $scope.chargeComponent).success(function(result) {    	
   		 console.log(result);
            if (result == 1) {
                logger.logSuccess("Update Successfully!");
                $state.go("app.truck.general.changecomponentmenu",{tenantid:$stateParams.tenantid});
            } else {
                logger.logError(result.message);
            }             
        });        
   }; 
    
    

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