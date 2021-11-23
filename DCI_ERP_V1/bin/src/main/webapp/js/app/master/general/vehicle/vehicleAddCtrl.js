'use strict';

app.controller('vehicleaddCtrl', function($scope, $rootScope, $http, $location, logger,
        utilsService,$state,sharedProperties,$window,validationService,toaster,$stateParams,$filter) {

    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.isEdit = false;

    $scope.vehiclemodel = {
    		regNo:'',
    		serialNo:'',
    		alias:'',
    		vin:'',
    		vehicleType:'',
    		yrofmanu:'',
    		manuId:'',
    		model:'',
    		remarks	:'',
    		manuId :'',
    		choosePermit : '',
    		permitExpiryDate :'',
    		length :'',
    		width :'',
    		height :'',
    		status :'',
    		insuranceStatus :'',
    		weightBear :'',
    		insuranceExpiryDate :'',
    		lengthToUse :'',
    		widthToUse :'',
    		heightToUse :'',
    		controllist :'',
    		controllist1 :'',
    		controllist2 :'',
    		
      vehicleId : ''
        
    };
    
    $scope.isMultiDueDate=false;
    
    
    
    $scope.controllist = [ {
        'id' : 'Truck',
        'text' : 'Truck'
    }, {
        'id' : 'Trailer',
        'text' : 'Trailer'
    }]
    $scope.controllist1 = [ {
        'id' : 'Active',
        'text' : 'Active'
    }, {
        'id' : 'In-Active',
        'text' : 'In-Active'
    }]
    $scope.controllist2 = [ {
        'id' : 'Active',
        'text' : 'Active'
    }, {
        'id' : 'In-Active',
        'text' : 'In-Active'
    }]
    
    
    
    
    $scope.manuList=[];
    $scope.getmanuList=function(){
    	 $http.get($stateParams.tenantid+'/vehicle/manulist').success(function(datas) {
            $scope.manuList = datas.manuList;
/*            $scope.controllist = datas.controllist;
*/            console.log("manu");
            console.log( $scope.manuList);
           

        }).error(function(data) {

        });
        
     
    }
    $scope.getmanuList();
    
    
    $scope.validate = function(vehicleForm) {
        if (new validationService().checkFormValidity(vehicleForm)) {
            if(!$scope.isEdit){
                $scope.save(vehicleForm);
            }else{
                $scope.update(vehicleForm);
            }
        } else {
            toaster.pop('error', "Please fill the required fields",
                    logger.getErrorHtmlNew(vehicleForm.$validationSummary),5000, 'trustedHtml');
        }
    };
    
    
    
    
  
    
    
    
    $scope.save = function(vehicleForm) {
    	
    	$scope.vehiclemodel.permitExpiryDate=   $filter('date')($scope.vehiclemodel.permitExpiryDate, "yyyy-MM-dd");
    	$scope.vehiclemodel.insuranceExpiryDate =   $filter('date')($scope.vehiclemodel.insuranceExpiryDate, "yyyy-MM-dd");

    	  
        sharedProperties.clearObject();
            
            console.log( vehicleForm);
         	
       	 $http.post($stateParams.tenantid+'/vehicle/save',$scope.vehiclemodel)
            .success(function(response) {
               if(response == 1){
                   logger.logSuccess("Saved Succesfully!");
                
                   $state.go("app.master.general.vehiclemenu.vehiclesubmenu",{tenantid:$stateParams.tenantid});               
                   }else{
            	   logger.logError("Error in save vehicle")
               }
            });
       
    };
    $scope.update = function(manuForm) {
        sharedProperties.clearObject();
      	 $http.post($stateParams.tenantid+'/vehicle/update',$scope.vehiclemodel)
            .success(function(response) {
               if(response == 1){
                   logger.logSuccess("Updated Succesfully!");
                   $state.go("app.master.general.vehiclemenu.vehiclesubmenu",{tenantid:$stateParams.tenantid});               

               }else{
                   logger.logError("Error in update vehicle!");
               }
            });
        
    };
var editid = $location.search().rowid;
    
    var test = parseInt(editid);
    if(test != 0){
    	$scope.isEdit=true;
    $http.post($stateParams.tenantid+'/vehicle/edit',test).success(function(result) {
    	console.log(result);
    	$scope.vehiclemodel = result;
    	
    	$scope.vehiclemodel.permitExpiryDate = result.permitExpiryDate;
    	
    	
    	

    	
    	 
    });
}
    $scope.reset = function(manuForm) {
        
        if($scope.isEdit == true){
            var vehicleId =  $scope.vehiclemodel.vehicleId;
            $scope.vehiclemodel.regNo='';
            $scope.vehiclemodel.serialNo='';
            $scope.vehiclemodel.alias='';
            $scope.vehiclemodel.vin='';
            $scope.vehiclemodel.yrofmanu='';
            $scope.vehiclemodel.manuId='';
            $scope.vehiclemodel.vehicleType='';
            $scope.vehiclemodel.model='';
            $scope.vehiclemodel.remarks='';
         $http.post($stateParams.tenantid+'/vehicle/edit',manuId)
            .success(function(response) {
               if(response.success == true){
                   $scope.vehiclemodel = response.vehicle;
               }
            });
        }
        else{
        	
            $scope.vehiclemodel.regNo='';
            $scope.vehiclemodel.serialNo='';
            $scope.vehiclemodel.alias='';
            $scope.vehiclemodel.vin='';
            $scope.vehiclemodel.yrofmanu='';
            $scope.vehiclemodel.vehicleType='';
            $scope.vehiclemodel.manuId='';
            $scope.vehiclemodel.model='';
            $scope.vehiclemodel.remarks='';
            $scope.vehiclemodel. vehicleId = '';
            		
        	    	
        	    		
        	
        }
        
        
        
    };
    $scope.cancel = function(){
        $state.go("app.master.general.vehiclemenu.vehiclesubmenu",{tenantid:$stateParams.tenantid});
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