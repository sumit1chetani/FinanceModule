
app.controller('containerstatussequenceAddCtrl', function($scope, $rootScope, $http, $location, logger, ngDialog,
        utilsService,$state,sharedProperties,$window,$stateParams,toaster,validationService,$timeout) {

	$scope.containerstatussequenceDtl=[];
	$scope.statusList = [];
	directionList = [];
	$scope.isEdit = false;

	
	//ng-model
$scope.containerstatussequence={
		sequenceS:'',
		sequenceM:[],
		containerstatussequenceDtl : []
	
}


//getvessel

			
			$scope.sequenceList = [];
			$http.post($stateParams.tenantid+'/api/containerstatussequence/getcontainerStatus').success(function(data) {
			     	
					$scope.sequenceList=data;
					        		
			});






		//multiseletivity
		
			 $scope.portList=[];
		$scope.test=function(){
				$http.post($stateParams.tenantid+'/api/containerstatussequence/getcontainerStatus').success(function(data) { 
		
			$scope.portList=data;
		
		$timeout(function() {
		
		$("#port").multiselect({
		maxHeight: 200, 
		includeSelectAllOption: true,
		selectAllText : 'Select All',
		enableFiltering : true,	
		disableIfEmpty: true,
		enableCaseInsensitiveFiltering: true,
		numberDisplayed: 1,
		onDropdownHide: function (event) {
		
		}
		});
		$("#multiselect-button").addClass("width_100 input-sm line-height-5");
				
				}, 2, false);
				
				});
		
		};
		
		$scope.test();
		
		
		$scope.save = function(containerstatussequenceForm,containerstatussequence) {
			console.log($scope.containerstatussequence);
			
			 $http.post($stateParams.tenantid+'/api/containerstatussequence/saveContainer',$scope.containerstatussequence).success(function(data) {
		            console.log("data" + data);
		            if (data.isSuccess) {
		                logger.logSuccess("Saved Successfully!");
		                $state.go('app.eqs.containerstatussequence.containerstatussequencelist');
		            } else {
		                logger.logError(data.message);
		            }
		        }).error(function(result) {
		            console.log("data" + data);
		        });
		}

		$scope.isEdit = false;
		 var sequence = $location.search().sequence;
		 if (sequence == undefined) {

		 } else {
			 debugger
		     $http.get($stateParams.tenantid+'/api/containerstatussequence/edit?sequence=' +sequence).success(function(result) {
		    	     $scope.isEdit=true;
		    	 	 console.log(result);
		        	 $scope.containerstatussequence.sequence = result.sequence;
		        	 $scope.containerstatussequence.sequenceS = result.sequence;
		        	 $scope.containerstatussequence.sequenceM = result.containerstatussequenceDtl;
		        	 //$scope.containerstatussequence=result;
		        	 //$scope.recordType=result.recordType.toString();
		         	
		         	
		     }).error(function(data) {
		         console.log("data" + data);
		     });
		 }




















/*



$scope.tempcontainerstatussequenceDtl={
		sequence:'',
		status:'',
		 select:false
}


//Reset on add mode
	    $scope.reset = function() {
	        $scope.containerstatussequenceDtl=[];   
	        $scope.getDropdownvalue();
	        $scope.containerstatussequence=[];  
	        $scope.tempcontainerstatussequenceDtl=[]; 

	    };

$scope.addCredRow = function() {
	  
	  var tmp=angular.copy($scope.tempcontainerstatussequenceDtl);
	  $scope.containerstatussequence.containerstatussequenceDtl.push(tmp);

}
$scope.addCredRow();




$scope.removeCredRow =function(){
	ngDialog.openConfirm().then(function() {
		var tmpDelList = [];
		for(var i=$scope.containerstatussequence.containerstatussequenceDtl.length-1;i>=0;i--){
			if($scope.containerstatussequence.containerstatussequenceDtl[i].select==true){
				tmpDelList.push($scope.containerstatussequence.containerstatussequenceDtl[i]);
				$scope.containerstatussequence.containerstatussequenceDtl.splice(i, 1);
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

$scope.directionList=[ {
    id : '1',
    text : 'IMPORT'
}, {
    id : '2',
    text : 'EXPORT'
}];



$http.get($stateParams.tenantid+'/api/containerstatussequence/getSequence').success(function(data) {
debugger
	console.log(data);
	$scope.containerstatussequence.sequence = data.sequence;
	});
//save
$scope.save = function(containerstatussequenceForm,containerstatussequence) {
	//if (new validationService().checkFormValidity($scope.containerstatussequenceForm)) {
		//alert(1);
	debugger
        $http.post($stateParams.tenantid+'/api/containerstatussequence/save',containerstatussequence).success(function(data) {
            console.log("data" + data);
            if (data.isSuccess) {
                logger.logSuccess("Saved successfully!");
                $state.go('app.eqs.containerstatussequence.containerstatussequencelist');
            } else {
                logger.logError("Error!!");
            }
        }).error(function(result) {
            console.log("data" + data);
        });
	}else {
        toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.containerstatussequenceForm.$validationSummary), 555000, 'trustedHtml');
    }
    
 };
 
//Fetch Values
 $scope.isEdit = false;
 var sequence = $location.search().sequence;
 if (sequence == undefined) {

 } else {
	 debugger
     $http.get($stateParams.tenantid+'/api/containerstatussequence/edit?sequence=' +sequence).success(function(result) {

         if (result.isEdit == false) {
             logger.logError("Please Try Again");
         } else {

        	 $scope.containerstatussequence=result;
        	 //$scope.recordType=result.recordType.toString();
         	$scope.isEdit=true;
         	
         }
     }).error(function(data) {
         console.log("data" + data);
     });
 }

 $scope.update = function(containerstatussequenceForm,containerstatussequence) {
    // if (new validationService().checkFormValidity($scope.containerstatussequenceForm)) {
          $scope.containerstatussequence.sequence = $location.search().sequence;
          
         $http.post($stateParams.tenantid+'/api/containerstatussequence/update', $scope.containerstatussequence).success(function(result) {
             if (result) {
                 logger.logSuccess("Updated successfully!");
                 $state.go('app.eqs.containerstatussequence.containerstatussequencelist');
             } else {
                 logger.logError("Error in update!");
             }
         }).error(function(data) {
             console.log("data" + data);
         });

//     } else {
//         toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.containerstatussequenceForm.$validationSummary), 555000, 'trustedHtml');
//     }
 };
     //Dropdown for Selectivity
     $http.post($stateParams.tenantid+'/api/containerstatussequence/dropDownList').success(function(data) {
      
       		//$scope.location=data.listLocationList;
    	 $scope.location=data.listLocationList;
       		$scope.recordType=data.listRecordTypeList;
       		$scope.recordParty=data.listRecordPartyList;
       		$scope.containerstatussequenceCode=data.listDamageCodeList;
       		$scope.containerType=data.listContainerTypeList;
       		$scope.sequence=data.listsequenceList;
       		$scope.containerstatussequenceStatus=data.listDamageStatusList;
       		$scope.repairProcess=data.listRepairProcessList;
       		$scope.statusList=data.listStatusList;
       		
       		
       });
     
$scope.cancel = function() {
    $state.go('app.eqs.containerstatussequence.containerstatussequenceList',{tenantid:$stateParams.tenantid});
};


//$http.get($stateParams.tenantid+'/app/commonUtility/getDamageAggTypeList').success(function(datas) {
//    console.log(datas);
//    $scope.recordType = datas.DamageAggTypeList;
//
//    });
//reset
$scope.reset = function(containerstatussequence) {
if (sequence == undefined) {
	$http.get($stateParams.tenantid+'/api/containerstatussequence/getSequence').success(function(data){
		console.log(data);
		$scope.containerstatussequence.sequence = data.sequence;
	});
$scope.containerstatussequence={
		recordParty:'',
		containerType:'',
		containerSize:'',
		location:'',
		fromDate:'',
		toDate:'',
		containerstatussequenceDtl : []

}
} else {
$http.get($stateParams.tenantid+'/api/containerstatussequence/edit?sequence=' +sequence).success(function(result) {

if (result.isEdit == false) {
logger.logError("Please Try Again");
} else {

$scope.containerstatussequence=result;
$scope.isEdit=true;
}
}).error(function(data) {
console.log("data" + data);
});
}

}*/


		$scope.cancel = function() {
		    $state.go('app.eqs.containerstatussequence.containerstatussequencelist');
		};



	
});

