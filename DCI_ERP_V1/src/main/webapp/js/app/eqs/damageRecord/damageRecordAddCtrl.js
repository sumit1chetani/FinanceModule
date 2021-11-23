
app.controller('damageRecordAddCtrl', function($scope, $rootScope, $http, $location, logger, ngDialog,
        utilsService,$state,sharedProperties,$window,$stateParams,toaster,validationService) {

	$scope.damageRecordDtl=[];
	$scope.containerSizelist = [];
	$scope.locationList = [];
	$scope.containerTypeList = [];
	$scope.containerNoList = [];
	$scope.damageStatusList = [];
	$scope.damageCodeList = [];
	$scope.repairProcessList = [];
	$scope.containerNoList = [];
    $scope.isEdit = false;

$scope.damageRecord={
		recordParty:'',
		recordType:'',
		containerNo:'',
		location:'',
		fromDate:'',
		toDate:'',
		containerSize:'',
		containerType:'',
		containerNo:'',
		location:'',
		damageDate:'',
		  manHr:'',
		  laborRate:'',
		  laborCost:'',
		  materialCost:'',
		  totalCost:'',
		  portList:'',
		  damageHdrId:'',
		  damageDtlId:'',
		damageRecordDtl : []
	
}
$scope.tempdamageRecordDtl={
		 port:'',
		 damageType : "",
		 noOfDamage:'',
		 rental:'',
		 pickupCharge:'',
		 dropupCharge:'',
		 handleCharge:'',
		 tax:'',
		 containerNo:'',
		 damageCode:'',
		 repairProcess:'',
		 damageStatus:'',
		 remarks:'',
		 cost:'',
		 damageHdrId:'',
		 damageDtlId:'',
		 select:false
}

//Reset on add mode
$scope.reset = function() {
    $scope.damageRecord=[];   
    $scope.getDropdownvalue();
    $scope.tempdamageRecordDtl=[];
    $scope.damageRecordDtl=[];
};

$scope.addCredRow = function() {
	   debugger
	  var tmp=angular.copy($scope.tempdamageRecordDtl);
		$scope.damageRecord.damageRecordDtl.push(tmp);

}
$scope.addCredRow();


//Get damageHdrId
$http.get($stateParams.tenantid+'/api/damageRecordType/getDamageRecordHdr').success(function(data) {

		console.log(data);
		$scope.damageRecord.damageHdrId = data.damageHdrId;
		});



/*//Get damageDtlId
$http.get($stateParams.tenantid+'/api/damageRecordType/getDamageRecordDtl').success(function(data) {

		console.log(data);
		$scope.damageRecord.damageDtlId = data.damageDtlId;
		});
*/


//Dropdown for Parts
$http.post($stateParams.tenantid+'/api/mnrTarrifType/dropDownListParts').success(function(data){
	 
	 $scope.partList = data.listPartsList;
 
 });

//DropDown for Ports
$http.post($stateParams.tenantid+'/api/mnrTarrifType/dropDownListPorts').success(function(data){
	 
	 $scope.portList = data.listPortsList;
 
 });

$scope.removeCredRow =function(){
	ngDialog.openConfirm().then(function() {
		var tmpDelList = [];
		for(var i=$scope.damageRecord.damageRecordDtl.length-1;i>=0;i--){
			if($scope.damageRecord.damageRecordDtl[i].select==true){
				tmpDelList.push($scope.damageRecord.damageRecordDtl[i]);
				$scope.damageRecord.damageRecordDtl.splice(i, 1);
			}
		}
		logger.logSuccess('Deleted Successfully');

	})
}

$scope.containerSizelist=[ {
    id : '1',
    text : 'Full'
}, {
    id : '2',
    text : 'Empty'
}];

$scope.damageStatusList=[ {
    id : 'PENDING',
    text : 'PENDING'
}, {
    id : 'APPROVED',
    text : 'APPROVED'
}, {
    id : 'REJECTED',
    text : 'REJECTED'
}];


//No need container number as AlphaNumerical
/*$http.get($stateParams.tenantid+'/api/damageRecordType/getContainerNo').success(function(data) {

	console.log(data);
	$scope.damageRecord.containerNo = data.containerNo;
	});*/


//save
$scope.save = function(DamageRecordForm,damageRecord) {
	if (new validationService().checkFormValidity($scope.DamageRecordForm)) {
        $http.post($stateParams.tenantid+'/api/damageRecordType/save',damageRecord).success(function(data) {
            console.log("data" + data);
            if (data.isSuccess) {
                logger.logSuccess("Saved Successfully!");
                $state.go('app.eqs.damageRecord.damageRecordList');
            } else {
                logger.logError(data.message);
            }
        }).error(function(result) {
            console.log("data" + data);
        });
	}else {
        toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.DamageRecordForm.$validationSummary), 555000, 'trustedHtml');
    }
    
 };
 
 
 
 app.controller('damageRecordTable', function($scope, $http, $filter, logger,$stateParams) {
		 
	 $scope.$watchCollection('[row.laborCost,row.materialCost]', function(newValue, oldValue) {
	debugger
		 var num1 = $scope.row.laborCost;
    	 var num2 = $scope.row.materialCost;
    	 var result = parseFloat(num1) + parseFloat(num2);
    	 
    	 $scope.row.totalCost = result;
		 
});
	 
	 $scope.$watchCollection('[row.manHour,row.laborRate]', function(newValue, oldValue) {
    		
		 var num1 = $scope.row.manHr;
    	 var num2 = $scope.row.laborRate;
    	 var result = parseFloat(num1) * parseFloat(num2);
    	 
    	 $scope.row.laborCost = result;
		 
});
	 
	 
	/* $scope.$watch('[row.manHour]', function(newValue, oldValue) {
 		debugger
		 if($scope.row.damageCode ='' && newValue == undefined  ){
			 
			 log.logger("Please");
		 }
	  });
	 */
});
 
 
 
//Fetch Values
 $scope.isEdit = false;
 var damageHdrId = $location.search().damageHdrId;
 if (damageHdrId == undefined) {
	 debugger

 } else {
	 debugger
     $http.get($stateParams.tenantid+'/api/damageRecordType/edit?damageHdrId=' +damageHdrId).success(function(result) {

         if (result.isEdit == false) {
             logger.logError("Please Try Again");
         } else {

        	 $scope.damageRecord=result;
        	 //$scope.recordType=result.recordType.toString();
         	$scope.isEdit=true;
         	
         }
     }).error(function(data) {
         console.log("data" + data);
     });
 }

 $scope.update = function(DamageRecordForm,damageRecord) {
     if (new validationService().checkFormValidity($scope.DamageRecordForm)) {
          $scope.damageRecord.damageHdrId = $location.search().damageHdrId;
          
         $http.post($stateParams.tenantid+'/api/damageRecordType/update', $scope.damageRecord).success(function(result) {
             if (result) {
                 logger.logSuccess("Updated Successfully!");
                 $state.go('app.eqs.damageRecord.damageRecordList',{tenantid:$stateParams.tenantid});
             } else {
                 logger.logError("Error in Update");
             }
         }).error(function(data) {
             console.log("data" + data);
         });

     } else {
         toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.DamageRecordForm.$validationSummary), 555000, 'trustedHtml');
     }
 };
     //Dropdown for Selectivity
     $http.post($stateParams.tenantid+'/api/damageRecordType/dropDownList').success(function(data) {
      
       		//$scope.location=data.listLocationList;
    	 $scope.location=data.listLocationList;
       		$scope.recordType=data.listRecordTypeList;
       		$scope.recordParty=data.listRecordPartyList;
       		$scope.damageCode=data.listDamageCodeList;
       		$scope.containerType=data.listContainerTypeList;
       		$scope.containerNo=data.listContainerNoList;
       		$scope.damageStatus=data.listDamageStatusList;
       		$scope.repairProcess=data.listRepairProcessList;
       		
       		
       });
     
     //Dropdown For DamageLocation
     $http.post($stateParams.tenantid+'/api/mnrTarrifType/dropDownList').success(function(data){
    	 $scope.damageLocation = data.listDamageLocationList;
     
     });
     
     //Container Type and Container Name
    /* $scope.$watch('damageRecord.containerType', function(newValue, oldValue) {
    	 debugger
         //  $scope.mnrTarrif.manHour = '';
           if ($scope.damageRecord.containerType != '') {
              // $scope.invoiceViewHeader.vessel = $scope.vesselObj.text;
        	 //  $http.post($stateParams.tenantid+'/api/damageRecordType/getContainerNumber?containerType='+newValue').success(function(data){
        			   
        			   $http.post($stateParams.tenantid+'/api/damageRecordType/getContainerNumber?containerType='+newValue).success(function(data){
        		 //  $http.post($stateParams.tenantid+'/api/damageRecordType/getContainerNumber?manHour='+newValue).success(function(data)
                   $scope.damageRecord.containerNo = data.containerNo;
               });
           } else {
               $scope.damageRecord.containerNo = '';
           }
       })*/
       
     
     $scope.$watch('damageRecord.containerNo', function(newValue, oldValue) {
    	 debugger
         //  $scope.mnrTarrif.manHour = '';
           if ($scope.damageRecord.containerNo != '') {
              // $scope.invoiceViewHeader.vessel = $scope.vesselObj.text;
        			   
        			   $http.post($stateParams.tenantid+'/api/damageRecordType/getContainerType?containerNo='+newValue).success(function(data){
                   $scope.damageRecord.containerType = data.containerType;
               });
           } else {
               $scope.damageRecord.containerType = '';
           }
       })
       
     
$scope.cancel = function() {
    $state.go('app.eqs.damageRecord.damageRecordList',{tenantid:$stateParams.tenantid});
};


//$http.get($stateParams.tenantid+'/app/commonUtility/getDamageAggTypeList').success(function(datas) {
//    console.log(datas);
//    $scope.recordType = datas.DamageAggTypeList;
//
//    });
//reset
$scope.reset = function(damageRecord) {
if (containerNo == undefined) {
	$http.get($stateParams.tenantid+'/api/damageRecordType/getContainerNo').success(function(data){
		console.log(data);
		$scope.damageRecord.containerNo = data.containerNo;
	});
$scope.damageRecord={
		recordParty:'',
		containerType:'',
		containerSize:'',
		location:'',
		fromDate:'',
		toDate:'',
		damageRecordDtl : []

}
} else {
$http.get($stateParams.tenantid+'/api/damageRecordType/edit?damageHdrId=' +damageHdrId).success(function(result) {

if (result.isEdit == false) {
logger.logError("Please Try Again");
} else {

$scope.damageRecord=result;
$scope.isEdit=true;
}
}).error(function(data) {
console.log("data" + data);
});
}

}




	
});

