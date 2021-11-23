
app.controller('onHireReleaseAddCtrl', function($scope, $rootScope, $http, $location, logger, ngDialog,
        utilsService,$state,sharedProperties,$window,$stateParams,toaster,validationService) {

	$scope.onHireReleaseDtl=[];
    $scope.isEdit = false;

$scope.onhireReleaseAdd={
		agreementRefno:'',
		agent:'',
		port:'',
		freeDays:'',
		releaseRefno:'',
		agreementParty:'',
		referenceNo :'',
		leaseType:'',
		created_by: '',
        created_date : '',
      modified_by: '',
   modified_date: '',
		onHireReleaseDtl : []
	
}



$scope.tempOnHireReleaseDtl={
		 containerType : "",
		 releaseQty:'',
		 port:'',
		 select:false
}
$scope.addCredRow = function() {
	   
	  var tmp=angular.copy($scope.tempOnHireReleaseDtl);
		$scope.onhireReleaseAdd.onHireReleaseDtl.push(tmp);

}
$scope.addCredRow();



$scope.removeCredRow =function(){
	var count =0;
	ngDialog.openConfirm().then(function() {
		var tmpDelList = [];
		for(var i=$scope.onhireReleaseAdd.onHireReleaseDtl.length-1;i>=0;i--){
			if($scope.onhireReleaseAdd.onHireReleaseDtl[i].select==true){
				count++;
				tmpDelList.push($scope.onhireReleaseAdd.onHireReleaseDtl[i]);
				$scope.onhireReleaseAdd.onHireReleaseDtl.splice(i, 1);
			}
		}
		if(count>0){
			logger.logSuccess('Deleted Successfully');	
		}else{
			logger.logError('Please select the row to delete!');
		}
	
	})
}

$http.get($stateParams.tenantid+'/api/outWard/getAgentList').success(function(datas) {
	debugger
    $scope.agreementPartyList = datas;
 });


$scope.$watch('onhireReleaseAdd.agreementRefno', function(newValue,
		oldValue) {

	if (newValue != '' && newValue != undefined) {

$http.get($stateParams.tenantid + '/api/onhireReleaseOrder/agreementRefNolist?agreementRefno='+ $scope.onhireReleaseAdd.agreementRefno).success(
		function(datas) {
			$scope.agreementRefNolist = datas; 
			$scope.onhireReleaseAdd.agreementParty = datas.OnhireRelease.agreementParty.toString();
			$scope.onhireReleaseAdd.leaseType = datas.OnhireRelease.leaseType;
			$scope.port = datas.onhireRelease.portList;
			$scope.containerType = datas.listContainerTypeList;
		}).error(function(data) {
	logger.logError("Unable to fetch");
});

	}
});


//Dropdown for Selectivity
$http.post($stateParams.tenantid+'/api/onhireReleaseOrder/dropDownList').success(function(data) {
 
  		$scope.agreementRefno=data.listagreementRefNoList;
  		$scope.agent=data.listAgentList;
  		//$scope.port=data.listPortList;
   		$scope.containerType=data.listContainerTypeList;

  
  	
  });

$http.get($stateParams.tenantid+'/api/onhireReleaseOrder/getReleaseRefno').success(function(data) {

	console.log(data);
	$scope.onhireReleaseAdd.releaseRefno = data.releaseRefno;
	});

//save
$scope.save = function(onhireReleaseForm,onhireReleaseAdd) {
	if (new validationService().checkFormValidity($scope.onhireReleaseForm)) {
        $http.post($stateParams.tenantid+'/api/onhireReleaseOrder/save',onhireReleaseAdd).success(function(data) {
            console.log("data" + data);
            if (data.isSuccess) {
                logger.logSuccess("Saved Successfully!");
                $state.go('app.eqc.onHireRelease.list',{tenantid:$stateParams.tenantid});
            } else {
                logger.logError(data.message);
            }
        }).error(function(result) {
            console.log("data" + data);
        });
	}else {
        toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.onhireReleaseForm.$validationSummary), 555000, 'trustedHtml');
    }

    
 };
 

//update
 $scope.update = function(onhireReleaseForm,onhireReleaseAdd) {
     if (new validationService().checkFormValidity($scope.onhireReleaseForm)) {
          $scope.onhireReleaseAdd.releaseRefno = $location.search().releaseRefno;
          
         $http.post($stateParams.tenantid+'/api/onhireReleaseOrder/update', $scope.onhireReleaseAdd).success(function(result) {
             if (result) {
                 logger.logSuccess("Updated Successfully!");
                 $state.go('app.eqc.onHireRelease.list',{tenantid:$stateParams.tenantid});
                 
             } else {
                 logger.logError("Error in Update");
             }
         }).error(function(data) {
             console.log("data" + data);
         });

     } else {
         toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.onhireReleaseForm.$validationSummary), 555000, 'trustedHtml');
     }
 };
  

//Fetch Values
 $scope.isEdit = false;
 var releaseRefno = $location.search().releaseRefno;
 if (releaseRefno == undefined) {

 } else {
     $http.get($stateParams.tenantid+'/api/onhireReleaseOrder/edit?releaseRefno=' +releaseRefno).success(function(result) {

         if (result.isEdit == false) {
             logger.logError("Please Try Again");
         } else {

        	 $scope.onhireReleaseAdd=result;
        	 $scope.onhireReleaseAdd.releaseRefno=releaseRefno;
         	$scope.isEdit=true;
         }
     }).error(function(data) {
         console.log("data" + data);
     });
 }
     
  
 var aNo = $location.search().aNo;
 if (aNo == undefined) {

 } else {
	 $scope.onhireReleaseAdd.agreementRefno = aNo;
 }
$scope.cancel = function() {
    $state.go('app.eqc.onHireRelease.list',{tenantid:$stateParams.tenantid});
};





//reset
$scope.reset = function(onhireReleaseAdd) {
if (releaseRefno == undefined) {
	
	$http.get($stateParams.tenantid+'/api/onhireReleaseOrder/getReleaseRefno').success(function(data) {

		console.log(data);
		$scope.onhireReleaseAdd.releaseRefno = data.releaseRefno;
		});
	
$scope.onhireReleaseAdd={
		agreementRefno:'',
		agent:'',
		port:'',
		freeDays:'',
		agreementParty:'',
		leaseType:'',
		onHireReleaseDtl : []
}
} else {
$http.get($stateParams.tenantid+'/api/onhireReleaseOrder/edit?releaseRefno=' +releaseRefno).success(function(result) {

if (result.isEdit == false) {
logger.logError("Please Try Again");
} else {
R
$scope.onhireReleaseAdd=result;
$scope.isEdit=true;
}
}).error(function(data) {
console.log("data" + data);
});
}
}

	
});

