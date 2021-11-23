
app.controller('vesselmasterAddCtrl', function($scope, $rootScope, $http, $location, logger, ngDialog,
        utilsService,$state,sharedProperties,$window,$stateParams,toaster,validationService) {

    $scope.isEdit = false;

$scope.vesselMasterAdd={
		vesselCode:'',
		vesselFlag:'',
		netTonnage:'',
		mainLineService:'',
		vesselName:'',
		grossTonnage:'',
		callSign:'',
		vesselOwner:''	
}


$scope.mainLineServiceList = [
     {id: 'SOC', text: 'SOC'},
    {id: 'SMI', text: 'SMI'}
  ];

//save
$scope.save = function(vesselmasterForm,vesselMasterAdd) {
	if (new validationService().checkFormValidity($scope.vesselmasterForm)) {
        $http.post($stateParams.tenantid+'/api/vesselmaster/create',vesselMasterAdd).success(function(data) {
            console.log("data" + data);
            if (data.isSuccess) {
                logger.logSuccess("Saved Successfully!");
                $state.go('app.master.vesselmaster.list');
            } else {
                logger.logError(data.message);
            }
        }).error(function(result) {
            console.log("data" + data);
        });
	} else {
        toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.departmentAddForm.$validationSummary), 555000, 'trustedHtml');
    }
    
 };
 //reset
 $scope.reset = function(vesselMasterAdd) {
	 if (vesselID == undefined) {
	 $scope.vesselMasterAdd={
			 	vesselCode:'',
				vesselFlag:'',
				netTonnage:'',
				mainLineService:'',
				vesselName:'',
				grossTonnage:'',
				callSign:'',
				vesselOwner:''
			
		}
	 } else {
		 $http.get($stateParams.tenantid+'/api/vesselmaster/edit?vesselID=' +vesselID).success(function(result) {

	         if (result.isEdit == false) {
	             logger.logError("Please Try Again");
	         } else {
//	         	$scope.vesselsailing.vessel=result.vessel;
//	         	$scope.vesselsailing.voyage=result.voyage;
//	         	$scope.vesselsailing.port =result.port;
//	         	$scope.vesselsailing.sail_Date=result.sail_Date;
	        	 $scope.vesselMasterAdd=result;
	         	$scope.isEdit=true;
	         }
	     }).error(function(data) {
	         console.log("data" + data);
	     });
	 }

 }
//Fetch Values
 $scope.isEdit = false;
 var vesselID = $location.search().vesselID;
 if (vesselID == undefined) {
//     var deptName = $scope.departmentData.deptName;
//     var deptHeadName = $scope.departmentData.deptHeadName;
//
//     var deptDesc = $scope.departmentData.deptDesc;
//     var deptHead = $scope.departmentData.deptHead;
//     var isActive = $scope.departmentData.isActive;
//     $scope.departmentData.isEdit = false;
 } else {
     $http.get($stateParams.tenantid+'/api/vesselmaster/edit?vesselID=' +vesselID).success(function(result) {

         if (result.isEdit == false) {
             logger.logError("Please Try Again");
         } else {
//         	$scope.vesselsailing.vessel=result.vessel;
//         	$scope.vesselsailing.voyage=result.voyage;
//         	$scope.vesselsailing.port =result.port;
//         	$scope.vesselsailing.sail_Date=result.sail_Date;
        	 $scope.vesselMasterAdd=result;
         	$scope.isEdit=true;
         }
     }).error(function(data) {
         console.log("data" + data);
     });
 }

 $scope.update = function(vesselmasterForm,vesselMasterAdd) {
     if (new validationService().checkFormValidity($scope.vesselmasterForm)) {
          $scope.vesselMasterAdd.vesselID = $location.search().vesselID;
          
         $http.post($stateParams.tenantid+'/api/vesselmaster/update', $scope.vesselMasterAdd).success(function(result) {
             if (result) {
                 logger.logSuccess("Updated Successfully!");
                 $state.go('app.master.vesselmaster.list',{tenantid:$stateParams.tenantid});
             } else {
                 logger.logError("Error in Update");
             }
         }).error(function(data) {
             console.log("data" + data);
         });

     } else {
         toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.departmentAddForm.$validationSummary), 555000, 'trustedHtml');
     }
 };
     //Dropdown for Selectivity
     $http.post($stateParams.tenantid+'/api/vessel/dropDownList').success(function(data) {
      
       		$scope.nationalitYList=data.nationalityList;
       		$scope.agent=data.listAgentList;
       		$scope.port=data.listPortList;
       
       	
       });
     
$scope.cancel = function() {
    $state.go('app.master.vesselmaster.list',{tenantid:$stateParams.tenantid});
};


$scope.changecolor=function(id){
    $('#'+id+' .selectivityId').find('input').css("border-color", "red");;

}
$scope.clearcolor=function(id){
    $('#'+id+' .selectivityId').find('input').css("border-color", "#e8dddd");;

}




	
});
