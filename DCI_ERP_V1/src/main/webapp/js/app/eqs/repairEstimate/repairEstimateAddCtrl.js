
app.controller('repairEstimateAddCtrl', function($scope, $rootScope, $http, $location, logger, ngDialog,
        utilsService,$state,sharedProperties,$window,$stateParams,toaster,validationService) {

	$scope.eirDtl=[];
    $scope.isEdit = false;

$scope.repairEstimate={
		repairEstimateNo:'',
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
		mnrTarrifId:'',
		damageCode:'',
		damageLocation:'',
		manHour:'',
		labourRate:'',
		materialCost:'',
		totalCost:'',
		tarrifFromDate:'',
		tarrifToDate:'',
		manHrAmount:'',
		partList:'',
		tarrifFromDate:'',
		tarrifToDate:'',
}

$scope.addCredRow = function() {
	   
	  var tmp=angular.copy($scope.tempeirDtl);
		$scope.repairEstimate.eirDtl.push(tmp);

}
$scope.addCredRow();



$scope.removeCredRow =function(){
	var count =0;
		var tmpDelList = [];
		for(var i=$scope.repairEstimate.eirDtl.length-1;i>=0;i--){
			if($scope.repairEstimate.eirDtl[i].select==true){
				count++;
				tmpDelList.push($scope.repairEstimate.eirDtl[i]);
				$scope.repairEstimate.eirDtl.splice(i, 1);
			}
		}
		if(count>0){
			
		}else{
			logger.logError('Please select the row to delete!');
		}

	
}

$scope.equipmentStatus=[{
	id:'Damage',
	text :'Damage'
},{
	id:'NON-Damage',
	text :'NON-Damage'
}];


$scope.eirRefNo=$location.search().eirRefNo;

if($scope.eirRefNo != '' && $scope.eirRefNo!=undefined){
	 $scope.isEdit = false;
	$http.post($stateParams.tenantid+'/api/eir/edit?eirRefNo='+$scope.eirRefNo).success(function(datas) {
		
		 $scope.repairEstimate.eirRefNo=datas.eirRefNo;
		 $scope.repairEstimate.eirDtl =datas.eirDtl;
		 $scope.repairEstimate=datas;
	
	}).error(function(datas) {

	});
	
	
}


/*var repairEstimateID = $location.search().repairEstimateID;
var eirRefNo = $location.search().eirRefNo;
if (repairEstimateID == null || repairEstimateID == undefined) {
	$scope.isEdit = false;
} else {
	$scope.isEdit = true;
	$scope.editBooking(repairEstimateID);
}

if(eirRefNo!=null && eirRefNo!=undefined && eirRefNo!=''){
	$scope.repairEstimate = angular.copy(eirRefNo);
}*/

//Dropdown for Selectivity
$http.post($stateParams.tenantid+'/api/eir/dropDownList').success(function(data) {
  		$scope.eirRefNo=data.listEirList;
   		$scope.agent=data.listAgentList;
   		//$scope.damageCode=data.listDamageCodeList;
   		//$scope.damageLocation=data.listDamageLocationList;
   		$scope.containerNo=data.listContainerNoList;
   	
  });

//Dropdown for Parts
$http.post($stateParams.tenantid+'/api/mnrTarrifType/dropDownListParts').success(function(data){
	 $scope.partList = data.listPartsList;
 
 });

//Dropdown for Selectivity
$http.post($stateParams.tenantid+'/api/damageRecordType/dropDownList').success(function(data) {
 
  		$scope.damageCode=data.listDamageCodeList;
  		
  });

//Dropdown For DamageLocation
$http.post($stateParams.tenantid+'/api/mnrTarrifType/dropDownList').success(function(data){
	 $scope.damageLocation = data.listDamageLocationList;

});

$scope.$watch('repairEstimate.depot', function(newValue, oldValue) {
    if(newValue!=null && newValue!=undefined && newValue != ''){
  	  $http.post($stateParams.tenantid+ '/api/eir/getContainerNoByDepot',newValue).success(function(data) {
				$scope.containerNo = data;
  	  });
    }
  });



$scope.$watch('repairEstimate.containerNo', function(newValue,oldValue) {

		if (newValue != '' && newValue != undefined) {

			$http.get($stateParams.tenantid	+ '/api/eir/containerType?containerNo='+ $scope.repairEstimate.containerNo).success(
					function(datas) {
						$scope.repairEstimate.containerType = datas.containerType;
						$scope.repairEstimate.returnDate = datas.returnDate;
						$scope.repairEstimate.agent = datas.agent;

						
						
						

					}).error(function(data) {
				logger.logError("Unable to fetch");
			});

		}
	});



//save
$scope.save = function(RepariEstimateForm,repairEstimate) {
	if (new validationService().checkFormValidity($scope.RepariEstimateForm)) {
        $http.post($stateParams.tenantid+'/app/repairEstimates/save',repairEstimate).success(function(data) {
            console.log("data" + data);
            if (data.success) {
                logger.logSuccess("Saved Successfully!");
                $state.go('app.eqs.repairEstimate.repairEstimateList');
            } else {
                logger.logError(data.message);
            }
        }).error(function(result) {
            console.log("data" + data);
        });
	}else {
        toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.RepariEstimateForm.$validationSummary), 555000, 'trustedHtml');
    }
    
 };
 
//approve
 $scope.approveEstimate = function(repairEstimate){

 		$http.post($stateParams.tenantid+'/app/repairEstimates/approve',repairEstimate).success(function(datas) {
 			if(datas.success){
 		    logger.logSuccess(datas.message);
 		    $state.go('app.eqs.repairEstimate.repairEstimateList',{tenantid:$stateParams.tenantid});
 			}else{
 				logger.logError(datas.message);
 			}
 			 
 		
 	
 	}).error(function(datas) {

 	});
 	
 	
 }
 
//Fetch Values
 $scope.isEdit = false;
 var repairEstimateNo = $location.search().repairEstimateNo;
 if (repairEstimateNo == undefined) {

 } else {
     $http.get($stateParams.tenantid+'/app/repairEstimates/edit?repairEstimateNo=' +repairEstimateNo).success(function(result) {

         if (result.isEdit == false) {
             logger.logError("Please Try Again");
         } else {

        	 $scope.repairEstimate=result;
         	$scope.isEdit=true;
         }
     }).error(function(data) {
         console.log("data" + data);
     });
 }

 $scope.update = function(RepariEstimateForm,repairEstimate) {
     if (new validationService().checkFormValidity($scope.RepariEstimateForm)) {
          
         $http.post($stateParams.tenantid+'/app/repairEstimates/update',repairEstimate).success(function(result) {
             if (result.success) {
                 logger.logSuccess("Updated Successfully!");
                 $state.go('app.eqs.repairEstimate.repairEstimateList',{tenantid:$stateParams.tenantid});
             } else {
                 logger.logError(result.message);
             }
         }).error(function(data) {
             console.log("data" + data);
         });

     } else {
         toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.RepariEstimateForm.$validationSummary), 555000, 'trustedHtml');
     }
 };
//   
     
     $http.post($stateParams.tenantid+'/api/eir/getPortListByAgent').success(function(data) {
         
    		$scope.depot=data;
    		
    });
     
     
     $scope.$watch('eir.depot', function(newValue, oldValue) {
	      if(newValue!=null && newValue!=undefined && newValue != ''){
	    	  $http.post($stateParams.tenantid+ '/api/eir/getContainerNoByDepot',newValue).success(function(data) {
					$scope.containerNo = data;
	    	  });
	      }
	    });
     
     
     $scope.$watch('eir.containerNo', function(newValue,
    			oldValue) {

    		if (newValue != '' && newValue != undefined) {

    			$http.get(
    					$stateParams.tenantid
    							+ '/api/eir/containerType?containerNo='
    							+ $scope.eir.containerNo).success(
    					function(datas) {
    						$scope.eir.containerType = datas.containerType;
    						$scope.eir.returnDate = datas.returnDate;

    						
    						
    						

    					}).error(function(data) {
    				logger.logError("Unable to fetch");
    			});

    		}
    	});

     
     $('#inspectionDate').datetimepicker({
		 format : 'DD/MM/YYYY HH:mm'
		 })
     
$scope.cancel = function() {
    $state.go('app.eqs.repairEstimate.repairEstimateList',{tenantid:$stateParams.tenantid});
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



app.controller('repairEstimateDetailCtrl', function($scope, $http, $filter, logger,$stateParams) {

	
	$scope.$watchCollection('[repairEstimate.depot,repairEstimate.eirDtl[trIndex].damageCode,repairEstimate.eirDtl[trIndex].damageLocation]',function(newValue, oldValue) {
	if (newValue[0] != '' && newValue[0] != undefined && newValue[1] != '' && newValue[2] != '' && newValue[2] != undefined ) {
		  
		console.log(newValue[0]);
		console.log(newValue[1]);
		console.log(newValue[2]);
		
		$http.post($stateParams.tenantid+'/app/repairEstimates/getAmountList?port=' +newValue[0]+ '&damageCode=' +newValue[1] +'&damageLocation=' +newValue[2]).success(function(data) {
			
			if(data.length > 0){
				$scope.bean=data[0];			
				$scope.repairEstimate.eirDtl[$scope.$parent.$index].manHour = $scope.bean.manHour;
				$scope.repairEstimate.eirDtl[$scope.$parent.$index].labourRate = $scope.bean.labourRate;
				$scope.repairEstimate.eirDtl[$scope.$parent.$index].materialCost = $scope.bean.materialCost;
				$scope.repairEstimate.eirDtl[$scope.$parent.$index].totalCost = $scope.bean.totalCost;
				$scope.repairEstimate.eirDtl[$scope.$parent.$index].manHrAmount = $scope.bean.manHrAmount;
				$scope.repairEstimate.eirDtl[$scope.$parent.$index].partList = $scope.bean.partList;

			}
			
			
		});
		
	}
	
});
	
	

});