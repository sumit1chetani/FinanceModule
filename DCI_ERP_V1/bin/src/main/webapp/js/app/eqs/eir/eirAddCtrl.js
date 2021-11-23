
app.controller('eirAddCtrl', function($scope, $rootScope, $http, $location, logger, ngDialog,
        utilsService,$state,sharedProperties,$window,$stateParams,toaster,validationService) {

	$scope.eirDtl=[];
    $scope.isEdit = false;

$scope.eir={
		eirRefNo:'',
		depot:'',
		containerNo:'',
		containerId:'',
		containerType:'',
		agent:'',
		returnDate:'',
		inspectionDate:null,
		equipmentStatus:'',
		
		
			eirDtl : []
	
}



$scope.tempeirDtl={
		 damageCode:'',
		 damageLocation : '',
		 select:false
}

$scope.addCredRow = function() {
	   
	  var tmp=angular.copy($scope.tempeirDtl);
		$scope.eir.eirDtl.push(tmp);

}
$scope.addCredRow();



$scope.removeCredRow =function(){
	var count =0;
	ngDialog.openConfirm().then(function() {
		var tmpDelList = [];
		for(var i=$scope.eir.eirDtl.length-1;i>=0;i--){
			if($scope.eir.eirDtl[i].select==true){
				count++;
				tmpDelList.push($scope.eir.eirDtl[i]);
				$scope.eir.eirDtl.splice(i, 1);
			}
		}
		if(count>0){
			logger.logSuccess('Deleted Successfully');	
		}else{
			logger.logError('Please select the row to delete!');
		}

	})
}

$scope.equipmentStatus=[{
	id:'Damage',
	text :'Damage'
},{
	id:'NON-Damage',
	text :'NON-Damage'
}];



$http.get($stateParams.tenantid+'/api/eir/getEirRefNo').success(function(data) {

	console.log(data);
	$scope.eir.eirRefNo = data.eirRefNo;
	});

$scope.tab = false;
$scope.$watch('eir.equipmentStatus', function(newValue,
		oldValue) {

	if (newValue != '' && newValue != undefined) {
		if(newValue == 'Damage'){
			$scope.tab = true;
		}
		else{
			$scope.tab = false;
		}


	}
});


//save
$scope.save = function(EirForm,eir) {
	if (new validationService().checkFormValidity($scope.EirForm)) {
        $http.post($stateParams.tenantid+'/api/eir/save',eir).success(function(data) {
            console.log("data" + data);
            if (data.isSuccess) {
                logger.logSuccess("Saved Successfully!");
             //   $state.go('app.eqs.eir.list');
            } else {
                logger.logError(data.message);
            }
        }).error(function(result) {
            console.log("data" + data);
        });
	}else {
        toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.EirForm.$validationSummary), 555000, 'trustedHtml');
    }
    
 };
 
//Fetch Values
 $scope.isEdit = false;
 var eirRefNo = $location.search().eirRefNo;
 if (eirRefNo == undefined) {

 } else {
     $http.get($stateParams.tenantid+'/api/eir/edit?eirRefNo=' +eirRefNo).success(function(result) {

         if (result.isEdit == false) {
             logger.logError("Please Try Again");
         } else {

        	 $scope.eir=result;
         	$scope.isEdit=true;
         }
     }).error(function(data) {
         console.log("data" + data);
     });
 }

 $scope.update = function(EirForm,eir) {
     if (new validationService().checkFormValidity($scope.EirForm)) {
          $scope.eir.eirRefNo = $location.search().eirRefNo;
          
         $http.post($stateParams.tenantid+'/api/eir/update', $scope.eir).success(function(result) {
             if (result) {
                 logger.logSuccess("Updated Successfully!");
                // $state.go('app.eqs.eir.list',{tenantid:$stateParams.tenantid});
             } else {
                 logger.logError("Error in Update");
             }
         }).error(function(data) {
             console.log("data" + data);
         });

     } else {
         toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.EirForm.$validationSummary), 555000, 'trustedHtml');
     }
 };
//     //Dropdown for Selectivity
     $http.post($stateParams.tenantid+'/api/eir/dropDownList').success(function(data) {
      
       	//	$scope.depot=data.listDepotList;
       		$scope.agent=data.listAgentList;
       		//$scope.damageCode=data.listDamageCodeList;
       	//	$scope.damageLocation=data.listDamageLocationList;
       		$scope.containerNo=data.listContainerNoList;
       		$scope.containerType=data.listContainerTypeList;

       		
       });
     
     //Dropdown for Selectivity
     $http.post($stateParams.tenantid+'/api/damageRecordType/dropDownList').success(function(data) {
      
       		$scope.damageCode=data.listDamageCodeList;
       		
       });
     
     //Dropdown For DamageLocation
     $http.post($stateParams.tenantid+'/api/mnrTarrifType/dropDownList').success(function(data){
    	 $scope.damageLocation = data.listDamageLocationList;
     
     });
     $http.post($stateParams.tenantid+'/api/eir/getPortListByAgent').success(function(data) {
         
    		$scope.depot=data;
    		
    });
     
 	$scope.CreateRepairEstimate = function(eirRefNo ) {
		$location.url($stateParams.tenantid+'/repairEstimate/Add?eirRefNo=' + eirRefNo);
	}
     
     
     $scope.$watch('eir.depot', function(newValue, oldValue) {
	      if(newValue!=null && newValue!=undefined && newValue != ''){
	    	  $http.post($stateParams.tenantid+ '/api/eir/getContainerNoByDepot',newValue).success(function(data) {
					$scope.containerNo = data;
	    	  });
	      }
	    });
     
     $scope.isEdit = false;
     $scope.$watch('eir.containerNo', function(newValue,oldValue) {

    		if (newValue != '' && newValue != undefined) {

    			$http.get($stateParams.tenantid	+ '/api/eir/containerType?containerNo='+ $scope.eir.containerNo).success(
    					function(datas) {
    						$scope.eir.containerType = datas.containerType;
    						$scope.eir.returnDate = datas.returnDate;
    						$scope.eir.agent = datas.agent;

    						
    						
    						

    					}).error(function(data) {
    				logger.logError("Unable to fetch");
    			});

    		}
    	});

     
     $('#inspectionDate').datetimepicker({
		 format : 'DD/MM/YYYY HH:mm'
		 })
     
$scope.cancel = function() {
    $state.go('app.eqs.eir.list',{tenantid:$stateParams.tenantid});
};



$scope.reset = function(eir) {
	
	
if (eirRefNo == undefined) {
	$http.get($stateParams.tenantid+'/api/eir/eirRefNo').success(function(data){
		console.log(data);
		$scope.eir.eirRefNo = data.eirRefNo;
	});
$scope.eir={
		depot:'',
		containerNo:'',
		containerType:'',
		agent:'',
		returnDate:'',
		inspectionDate:'',
		equipmentStatus:'',
		
		
			eirDtl : []

}
} else {
$http.get($stateParams.tenantid+'/api/eir/edit?eirRefNo=' +eirRefNo).success(function(result) {

if (result.isEdit == false) {
logger.logError("Please Try Again");
} else {

$scope.eir=result;
$scope.isEdit=true;
}
}).error(function(data) {
console.log("data" + data);
});
}

}




	
});

