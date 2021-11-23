
app.controller('onBoardAddCtrl', function($scope, $rootScope, $http, $location, logger, ngDialog,
        utilsService,$state,sharedProperties,$window,$stateParams,toaster,validationService) {

	$scope.containerDtl=[];
    $scope.isEdit = false;
    $scope.slotList =[];
//    
//    var today = new Date();
//    var dd = today.getDate();
//    var mm = today.getMonth()+1;  
//    var yyyy = today.getFullYear();
//    if(dd<10) {
//        dd = '0'+dd
//    } 
//    if(mm<10) {
//        mm = '0'+mm
//    } 
//    today = dd + '/' + mm + '/' + yyyy;
    
    $('#onBoardDate').datetimepicker({
		 format : 'DD/MM/YYYY HH:mm'
		 })
    
$scope.onBoard={
		vessel:'',
		voyage:'',
		port:'',
		service:'', 
		onBoardDate:'',mode:'',carrier:'',
		detailDate:'',
		containerDtl : [{
			booktype:'',
			leg:'',
			gateInDate:'',
			onboardStatusDate:'',
			slotOperator:'',
			soc : false
		}]
	
}
 
    $scope.modeList=[];
	$scope.getQuotationType = function() {
	    var  data = {};
	    data["id"] = "1";
	    data["text"] = "SEA COASTAL";
	    $scope.modeList.push(data);
	    //$scope.quotation.mode='1';
	    data = {};
	    data["id"] = "2";
	    data["text"] = "SEA FOREIGN";
	    $scope.modeList.push(data);
	    data = {};
	    data["id"] = "3";
	    data["text"] = "TRUCK";
	    $scope.modeList.push(data);
	    data = {};
	    data["id"] = "4";
	    data["text"] = "LINER";
		$scope.modeList.push(data);
		 data = {};
		    data["id"] = "5";
		    data["text"] = "Forwarding";
		     $scope.modeList.push(data);
	}
	$scope.getQuotationType();
	$http.get($stateParams.tenantid+'/app/commonUtility/getcarrierList').success(function(datas) {
		debugger
	    $scope.carrierList = datas.commonUtilityBean;	    
        //$scope.transList = datas.lCommonUtilityBean;	    

	}).error(function(data) {

	});
    
//Dropdown for Selectivity
$http.post($stateParams.tenantid+'/app/onBoard/dropDownList').success(function(data) {
  		$scope.vesselList=data.vesselList;
  		$scope.slotList=data.slotList;
  });


$scope.$watch('onBoard.vessel',function(newValue, oldValue) {
	if(newValue!=null && newValue!=undefined && newValue!=""){
		console.log("inside the ls",newValue);
        $http.post($stateParams.tenantid+'/app/onBoard/getVoyage?vesselCode='+newValue).success(function(data) {
        	if(data.success){
        		console.log("data",data);
        		$scope.voyageList=data.voyageList;
        	}else{
        		logger.logError("Unable to fetch data");
        	}
        });
	}
});
 
$scope.$watch('[onBoard.onBoardDate]', function(newValue,oldValue) {
	if (newValue != '' && newValue != undefined) {
	var today = new Date();
		var dd = today.getDate();
		var mm = today.getMonth() + 1; //January is 0!

		var yyyy = today.getFullYear();
		if (dd < 10) {
		  dd = '0' + dd;
		} 
		if (mm < 10) {
		  mm = '0' + mm;
		} 
		var today = dd + '/' + mm + '/' + yyyy;
		
		var dayDiff = moment(today, "DD/MM/YYYY").diff(moment($scope.onBoard.onBoardDate, "DD/MM/YYYY"),'day')
        if ( dayDiff < 0 ) { 
        	$scope.onBoard.onBoardDate="";
        	logger.logError("OnBoard Date Cannot Be Greater Than the Current Date..!!");
        }

	}
});


$scope.$watch('[onBoard.detailDate]', function(newValue,oldValue) {
	if (newValue != '' && newValue != undefined) {
	var today = new Date();
		var dd = today.getDate();
		var mm = today.getMonth() + 1; //January is 0!

		var yyyy = today.getFullYear();
		if (dd < 10) {
		  dd = '0' + dd;
		} 
		if (mm < 10) {
		  mm = '0' + mm;
		} 
		var today = dd + '/' + mm + '/' + yyyy;
		
		var dayDiff = moment(today, "DD/MM/YYYY").diff(moment($scope.onBoard.detailDate, "DD/MM/YYYY"),'day')
        if ( dayDiff < 0 ) { 
        	$scope.onBoard.detailDate="";
        	logger.logError("OnBoard Date Cannot Be Greater Than the Current Date..!!");
        }

	}
});
$scope.selectallRec = function(selection) {
	angular.forEach($scope.onBoard.containerDtl, function(
			value, key) {
		debugger;
		if (selection)
			value.select = true;
		else {
			value.select = false;
		}
	});
}
$scope.$watch('onBoard.voyage',function(newValue, oldValue) {
	if(newValue!=null && newValue!=undefined && newValue!=""){
       /* $http.post($stateParams.tenantid+'/app/onBoard/getPortList?voyage='+newValue).success(function(data) {
        	if(data.success){
        		$scope.portList=data.portList;
        	}else{
        		logger.logError("Unable to fetch data");
        	}
        });*/
		var voyage=newValue;
	    	  $http.post($stateParams.tenantid+ '/app/onBoard/getPortList',voyage).success(function(data) {
					$scope.portList = data.portList;
	    	  });
	    	  
	    	  $scope.onBoard.containerDtl =[];
	}
});

$('#onboardStatusDate').datetimepicker({
	 format : 'DD/MM/YYYY HH:mm'
	 })


$scope.getData = function(onBoardForm,onBoard) {
	
	if($scope.onBoard.vessel !=''){
        if($scope.onBoard.voyage !=''){
        	if($scope.onBoard.port !=''){
        		
        		$http.post($stateParams.tenantid+'/app/onBoard/getContainerData',onBoard).success(function(data) {
        	
            console.log("data" + data);
            if (data.success) {
                $scope.onBoard.containerDtl= data.onBoardBeanList;
                $scope.onBoard.count= data.contList;
                $scope.check1 = false;

            } else {
                logger.logError(data.message);
                $scope.check1 = true;
            }
        }).error(function(result) {
            console.log("data" + data);
        });
	
	}else{
	  if($scope.onBoard.port=='')
            logger.logError("Please select Port");
	}
}
else{
    if($scope.onBoard.voyage=='')
        logger.logError("Please select Voyage");
}
}
 else{
    logger.logError("Please select  Vessel");
}
    
 };
  
 $scope.apply = function(detailDate){
		for(var i=0;i<$scope.onBoard.containerDtl.length;i++){
			$scope.onBoard.containerDtl[i].onboardStatusDate = detailDate;

		}
	
	}
//save
$scope.save = function(onBoardForm,onBoard) {
	var check=true;
	if (new validationService().checkFormValidity($scope.onBoardForm)) {
		var test;
		$scope.gateInvalid=false;
		for(var i=0;i<$scope.onBoard.containerDtl.length;i++){
			if(onBoard.containerDtl[i].select ==true){
			if(onBoard.containerDtl[i].onboardStatusDate != null && onBoard.containerDtl[i].onboardStatusDate != '' ){
				if(test == null && test == undefined){
					test = "true";
				}else{
					test = test + "," + "true";
				}
				
				
			//Gate IN date validation
				
				noOfDays = moment(onBoard.containerDtl[i].gateInDate, 'DD/MM/YYYY').diff(moment(onBoard.containerDtl[i].onboardStatusDate, 'DD/MM/YYYY'), 'days');
				 if(noOfDays>0){
					 logger.logError("OnBoard Date of "+onBoard.containerDtl[i].containerNo+" Cannot Be Lesser than the Gate IN date " +onBoard.containerDtl[i].gateInDate);
					 $scope.onBoard.containerDtl[$scope.$index].onboardStatusDate = "";
						$scope.gateInvalid=true;
				 }	
					
			}else{
				logger.logError("Row ("+(i+1)+") Please Fill the Onboard Status Date");
				$scope.check1 = false;
				check=false;
				if(test == null && test == undefined){
					test = "false";
				}else{
					test = test + "," + "false";
				}
			}
		}
		}
			
		
		var check =  test.split(",").includes("false") ? false : true ;
			console.log(check);
			if(check == false && $scope.gateInvalid){
			}else{
				$scope.check1 = true;
				$scope.conList=[];
		  	    angular.forEach(onBoard.containerDtl, function(value, index) { 
		  	    	if(value.select==true){
		  	    		$scope.conList.push(value);
		  	    	}
		  	    })
				onBoard.containerDtl=$scope.conList;
		  	   // var check=true;
		  	  /*angular.forEach(onBoard.containerDtl, function(value1, index1) { 
		  		  if(value1.select==true){
		  		  if(value1.onboardStatusDate==null || value1.onboardStatusDate==''){
		  			  check=false;
		  		  }
		  		  }
		  		  
		  	  })*/
		  	  if(check==true){
				$http.post($stateParams.tenantid+'/app/onBoard/save',onBoard).success(function(data) {
		            console.log("data" + data);
		            if (data.success) {
		                logger.logSuccess("Saved successfully!");
		                $state.go('app.operation.OnBoard.list');
		            } else {
		                logger.logError(data.message);
		                $scope.check1 = false;
		            }
		        }).error(function(result) {
		            console.log("data" + data.message);
		            
		        });
			}
			}
			
				
				
        
			/*}else{
				logger.logError("Please Fill the Onboard Status Date!!");
			}*/
	} else {
		$scope.check1 = true;
        toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.onBoardForm.$validationSummary), 555000, 'trustedHtml');
    }

    
 };
  
     
$scope.cancel = function() {
    $state.go('app.operation.OnBoard.list',{tenantid:$stateParams.tenantid});
};

$scope.removeRow =function(){
	ngDialog.openConfirm().then(function() {
		var tmpDelList = [];
		for(var i=$scope.onBoard.containerDtl.length-1;i>=0;i--){
			if($scope.onBoard.containerDtl[i].select==true){
				tmpDelList.push($scope.onBoard.containerDtl[i]);
				$scope.onBoard.containerDtl.splice(i, 1);
			}
		}
		logger.logSuccess('Deleted Successfully');

	})
}

//reset
	$scope.reset = function() {
		$scope.onBoard={
				vessel:'',
				voyage:'',
				port:'',
				service:'', 
				onBoardDate:'',
				detailDate:'',
				containerDtl : [{
					booktype:'',
					leg:'',
					onboardStatusDate:'',
					slotOperator:'',
					soc:false
				}]
			
		}
	}
 
});

app.controller('onBoardtableCtrl', function($scope, $http, $filter, logger,	$stateParams) {
	$scope.$watchCollection('[onBoard.containerDtl[trIndex].onboardStatusDate]', function(newValue, oldValue) {
	 
		//alert($scope.isEdit);
		if($scope.onBoard.containerDtl[$scope.$index].onboardStatusDate != null && $scope.onBoard.containerDtl[$scope.$index].onboardStatusDate != '' ){
			var today = new Date();
			var dd = today.getDate();
			var mm = today.getMonth() + 1; //January is 0!

			var yyyy = today.getFullYear();
			if (dd < 10) {
			  dd = '0' + dd;
			} 
			if (mm < 10) {
			  mm = '0' + mm;
			} 
			var today = dd + '/' + mm + '/' + yyyy; 
			noOfDays = moment(today, 'DD/MM/YYYY').diff(moment($scope.onBoard.containerDtl[$scope.$index].onboardStatusDate, 'DD/MM/YYYY'), 'days');
			 if(noOfDays<0){
				 logger.logError("OnBoard Date Cannot Be Greater Than the Current Date..!!");
				 $scope.onBoard.containerDtl[$scope.$index].onboardStatusDate = "";
			 }	 
		  
		}
	});
});

app.controller('onBoardViewCtrl', function($scope, $rootScope, $state ,$http, logger, $log, ngDialog, $timeout, $modal, $location, $filter, utilsService, $stateParams) {
    var onBoardNo = $stateParams.onBoardNo;
    $scope.id = $stateParams.onBoardNo;
    $scope.onBoard = {
			vessel : '',
			voyage : '',
			port : '',
			service : '',
			onBoardDate : '',
			slotOperator:'',
			created_by: '',
            created_date : '',
          modified_by: '',
       modified_date: '',
			containerDtl : [],
			count:[]
    
		}
   
    $scope.slotList=[];
    $http.post($stateParams.tenantid+'/app/onBoard/getOnBoardDetails', onBoardNo).success(function(data) {
        console.log(data);
        $scope.onBoard.containerDtl=data.detailList
        $scope.onBoard.vessel=data.detailList[0].vessel;
        $scope.onBoard.voyage=data.detailList[0].voyage;
        $scope.onBoard.port=data.detailList[0].port;
        $scope.onBoard.onBoardDate=data.detailList[0].onBoardDate; 
        $scope.onBoard.count = data.contList;

        $scope.onBoard.created_by=data.detailList[0].created_by;
        $scope.onBoard.created_date=data.detailList[0].created_date;
        $scope.onBoard.modified_by=data.detailList[0].modified_by; 
        $scope.onBoard.modified_date = data.detailList[0].modified_date;

        
        
    }).error(function(data) {
        logger.logError("Error Please Try Again");
    });

     
    $scope.cancel = function() {
        $state.go('app.operation.OnBoard.list');
    };
 

});
