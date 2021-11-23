'use strict';

app.controller('chargeHeadAddCtrl', function($scope, $rootScope, $http, $location, logger,
        utilsService,$state,sharedProperties,$window,validationService,toaster,$stateParams,ngDialog) {	
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.edit = true;
    $scope.AOLList=[];
    $scope.AODList=[];
    $scope.commodity=[];
	$scope.displaycollection =[]
	$scope.rate =true;
    $scope.cargotariff ={
    		id : '',
    		aol : '',
    		weight : '',
    		commodity : '',
    		aod : '',
    		dimension:'',
    		date:'',
    		slab:'',
    		weight:'',
    		airlinecode:'',
    		airlinename:'',
    		tweight:'',
    		
    };
    
    var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth() + 1; // January is 0!
	var yyyy = today.getFullYear();
	if (dd < 10) {
		dd = '0' + dd
	}
	if (mm < 10) {
		mm = '0' + mm
	}
	
	$scope.cargotariff.date = dd + '/' + mm + '/'
	+ yyyy;
   /* $scope.cancel = function(){
        $state.go("app.master.chargeHead.list",{tenantid:$stateParams.tenantid});
    };  */
    $scope.validate = function(cargoTariffForm) {
        // if (new validationService().checkFormValidity(chargeHeadForm)) {
            
                 $scope.search($scope.cargotariff,cargoTariffForm);
             
         }
    
    /*$scope.validateFetchData = function(cargoTariffForm) {
        // if (new validationService().checkFormValidity(chargeHeadForm)) {
            
                 $scope.fetchData($scope.cargotariff,cargoTariffForm);
             
         }*/
    
    
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

    $scope.checkValidation = function() {

	    var alertmsg = "<ui><h4>Please fill the required fields</h4>";
	    var msg = "";
	    if ($scope.checkundefined($scope.cargotariff.aol)) {
	        msg = msg + "<li>AOL:Field is required.</li>";         
	        $scope.changecolor('aol');
	    }else{
	    	$scope.clearcolor('aol');
	    }
	    if ($scope.checkundefined($scope.cargotariff.aod)) {
	        msg = msg + "<li>AOD:Field is required.</li>";         
	        $scope.changecolor('aod');
	    }else{
	    	$scope.clearcolor('aod');
	    }
	    if ($scope.checkundefined($scope.cargotariff.weight)) {
	        msg = msg + "<li>Weight:Field is required.</li>";         
	        $scope.changecolor('weight');
	    }else{
	    	$scope.clearcolor('aol');
	    }
	    if ($scope.checkundefined($scope.cargotariff.date)) {
	        msg = msg + "<li>Date:Field is required.</li>";         
	        $scope.changecolor('date');
	    }else{
	    	$scope.clearcolor('date');
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
		if (value == undefined || value == 'undefined' || value == null
				|| value == 'null' || value == '') {
			invalid = true;
		}
		return invalid;

	}

   
    $scope.test1=function(){
        $http.get($stateParams.tenantid+'/app/cargotariff/list').success(function(datas) {
        	console.log(datas);
            $scope.AOLList = datas.aollist;
            $scope.AODList = datas.aodlist;
            
        }).error(function(data) {

        });
     
    }
    $scope.test1();
    
    $scope.openAlert= function(){
    	  ngDialog.open({
              template : 'fileGenModal',
              scope :$scope
          });
    }
    
    $scope.generateRowYes = function(){ 
    	$scope.fetchData($scope.cargotariff,$scope.cargoTariffForm);
    }

    $scope.genCancel=function(){
        ngDialog.close();
    }
    
    
    $scope.fetchData = function(cargotariff,cargoTariffForm){
		console.log($scope.cargotariff);
		$scope.rate =false;
		var msg = $scope.checkValidation();
		if (!$scope.checkundefined(msg)) {
			logger.logError(msg);
		} 
		//if(cargotariff.weight<=cargotariff.dimension)
		else
	    {
        $http.post($stateParams.tenantid+'/app/cargotariff/fetchData', $scope.cargotariff).success(function(data) {
        	  if (data.success == true && data.aollist.length>0){
        		  ngDialog.close();
        		  logger
					.logSuccess('Data Fetched Successfully!')
                $scope.rowCollection = data.aollist;
                
            }else
            	{
            	//logger.logError("NO Result Found");
            	$scope.rowCollection=[];
            	}
      }).error(function(data) {
          logger.logError("Error Please Try Again");
      });
	 }
     
    }
    
    
	$scope.search = function(cargotariff,cargoTariffForm){
		console.log($scope.cargotariff);
		$scope.rate =false;
		var msg = $scope.checkValidation();
		if (!$scope.checkundefined(msg)) {
			logger.logError(msg);
		} 
		//if(cargotariff.weight<=cargotariff.dimension)
		else
	    {
        $http.post($stateParams.tenantid+'/app/cargotariff/getTariffList', $scope.cargotariff).success(function(data) {
        	 if (data.success == true && data.aollist.length>0){
                $scope.rowCollection = data.aollist;
                
            }else
            	{
            	logger.logError("NO Result Found");
            	$scope.rowCollection=[];
            	}
      }).error(function(data) {
          logger.logError("Error Please Try Again");
      });
	 }
     
    }
	
    
	/*$scope.search = function(cargotariff,cargoTariffForm){
		console.log($scope.cargotariff);
		var msg = $scope.checkValidation();
		if (!$scope.checkundefined(msg)) {
			logger.logError(msg);
		} 
		else
	    {
        $http.post($stateParams.tenantid+'/app/cargotariff/search', $scope.cargotariff).success(function(data) {
            if (data.success == true) {
                $scope.displaycollection = data.aollist;
                //$scope.rowCollection = $scope.rowCollection.concat(data.lPaymentInformationList);
            }
      }).error(function(data) {
          logger.logError("Error Please Try Again");
      });
	 }
     
    }*/
    
    //update
   /* $scope.update = function(chargeHead,chargeHeadForm) {
   	 $http.post($stateParams.tenantid+'/chargeHead/update', $scope.chargeHead).success(function(result) {    	
   		 console.log(result);
            if (result == 1) {
                logger.logSuccess("Update Successfully!");
                $state.go("app.master.chargeHead.list",{tenantid:$stateParams.tenantid});
            } else {
                logger.logError(result.message);
            }             
        });        
   }; */
    
	  $scope.reset = function() {
	     
	            $scope.cargotariff.aol ='';
		       	 $scope.cargotariff.aod ='';
	         	 $scope.cargotariff.weight ='';
		       	 $scope.cargotariff.commodity ='';
		       	 $scope.cargotariff.dimension ='';
		       	$scope.cargotariff.date = dd + '/' + mm + '/'
		    	+ yyyy;
		       	$scope.displayedCollection =[];

     	
	        
	  }

});


