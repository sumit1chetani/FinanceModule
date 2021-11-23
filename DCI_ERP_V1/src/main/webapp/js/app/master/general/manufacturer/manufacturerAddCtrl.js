'use strict';

app.controller('manufactureraddCtrl', function($scope, $rootScope, $http, $location, logger,
        utilsService,$state,sharedProperties,$window,validationService,toaster,$stateParams) {
	
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.isEdit = false;
    $scope.manumodel = {
    		manuName : '',
    		shortName : '',
    		location : '',
    		faxNo :'',
    		address :'',
    		isActive :'',
    		email : '',
    		teleNo :'',
    		currencyCode :'',
    		personIncharge :'',
    		relationship :'',
      manuId : ''
        
    };
    $scope.currencyList=[];
    $scope.getcurrencyList=function(){
    	 $http.get($stateParams.tenantid+'/manufacturer/currencylist').success(function(datas) {
            $scope.currencyList = datas.currencyList;
            console.log("currencyList");
            console.log( $scope.currencyList);
           

        }).error(function(data) {

        });
        
     
    }
    $scope.getcurrencyList();
    
    
    $scope.validate = function(manuForm) {
        if (new validationService().checkFormValidity(manuForm)) {
            if(!$scope.isEdit){
                $scope.save(manuForm);
            }else{
                $scope.update(manuForm);
            }
        } else {
            toaster.pop('error', "Please fill the required fields",
                    logger.getErrorHtmlNew(manuForm.$validationSummary),5000, 'trustedHtml');
        }
    };
    
    $scope.save = function(manuForm) {
        sharedProperties.clearObject();
            
            console.log( manuForm);
            
       	 $http.post($stateParams.tenantid+'/manufacturer/save',$scope.manumodel)
            .success(function(response) {
               if(response == 1){
                   logger.logSuccess("Saved Succesfully!");
                
                   $state.go("app.master.general.manufacturermenu.manufacturersubmenu",{tenantid:$stateParams.tenantid});               
                   }else{
            	   logger.logError("Error in save manufacturer")
               }
            });
       
    };
    $scope.update = function(manuForm) {
        sharedProperties.clearObject();
      	 $http.post($stateParams.tenantid+'/manufacturer/update',$scope.manumodel)
            .success(function(response) {
          		 console.log(response);

               if(response == 1){
                   logger.logSuccess("Updated Succesfully!");
                   $state.go("app.master.general.manufacturermenu.manufacturersubmenu",{tenantid:$stateParams.tenantid});               

               }else{
                   logger.logError("Error in update manufacturer!");
               }
            });
        
    };
var editid = $location.search().rowid;
    
    var test = parseInt(editid);
    if(test){
    $scope.isEdit=true;
    $http.post($stateParams.tenantid+'/manufacturer/edit',test).success(function(result) {
    	
    		
    	console.log(result);
    	$scope.manumodel = result;
    	
    	if(result.isActive == "Y"){
    		$scope.manumodel.isActive = true;
    	}else{
    		$scope.manumodel.isActive = false;
    	}  
    	
    });
}
    $scope.reset = function(manuForm) {
        
        if($scope.isEdit == true){
            var manuId =  $scope.manumodel.manuId;
            $scope.manumodel.manuName ='';
       	 $scope.manumodel.shortName ='';
       	 $scope.manumodel.location ='';
       	 $scope.manumodel.faxNo ='';
       	 $scope.manumodel.address ='';
       	 $scope.manumodel.isActive ='';
       	 $scope.manumodel.email ='';
       	 $scope.manumodel.teleNo ='';
       	 $scope.manumodel.currencyCode ='';
       	 $scope.manumodel.personIncharge ='';
       	 $scope.manumodel.relationship ='';

         $http.post($stateParams.tenantid+'/manufacturer/edit',manuId)
            .success(function(response) {
               if(response.success == true){
                   $scope.manumodel = response.manufacturer;
               }
            });
        }
        else{
        	 $scope.manumodel.manuName ='';
        	 $scope.manumodel.shortName ='';
        	 $scope.manumodel.location ='';
        	 $scope.manumodel.faxNo ='';
        	 $scope.manumodel.address ='';
        	 $scope.manumodel.isActive ='';
        	 $scope.manumodel.email ='';
        	 $scope.manumodel.teleNo ='';
        	 $scope.manumodel.currencyCode ='';
        	 $scope.manumodel.personIncharge ='';
        	 $scope.manumodel.relationship ='';

        	    	
        	    		
        	
        }
        
        
        
    };
    $scope.cancel = function(){
        $state.go("app.master.general.manufacturermenu.manufacturersubmenu",{tenantid:$stateParams.tenantid});
    }
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


