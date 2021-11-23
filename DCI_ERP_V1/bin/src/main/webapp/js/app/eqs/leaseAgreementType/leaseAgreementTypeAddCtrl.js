
app.controller('leaseAgreementTypeAddCtrl', function($scope, $rootScope, $http, $location, logger, ngDialog,
        utilsService,$state,sharedProperties,$window,$stateParams,toaster,validationService) {

    $scope.isEdit = false;

$scope.leaseAgreement={
		type:'',
		description:''
	
}



//save
$scope.save = function(LeaseAgreementTypeForm,leaseAgreement) {
	if (new validationService().checkFormValidity($scope.LeaseAgreementTypeForm)) {
        $http.post($stateParams.tenantid+'/api/leaseAgreement/save',leaseAgreement).success(function(data) {
            console.log("data" + data);
            if (data.isSuccess) {
                logger.logSuccess("Saved successfully!");
                $state.go('app.eqs.leaseAgreementType.leaseAgreementTypeList');
            } else {
                logger.logError("Error!!");
            }
        }).error(function(result) {
            console.log("data" + data);
        });
	}else {
        toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.LeaseAgreementTypeForm.$validationSummary), 555000, 'trustedHtml');
    }
    
 };
 
//Fetch Values
 $scope.isEdit = false;
 var type = $location.search().type;
 if (type == undefined) {

 } else {
     $http.get($stateParams.tenantid+'/api/leaseAgreement/edit?type=' +type).success(function(result) {
         if (result.isEdit == false) {
             logger.logError("Please Try Again");
         } else {
        	 $scope.leaseAgreement=result;
         	$scope.isEdit=true;
         }
     }).error(function(data) {
         console.log("data" + data);
     });
 }
//update
 $scope.update = function(LeaseAgreementTypeForm,leaseAgreement) {
     if (new validationService().checkFormValidity($scope.LeaseAgreementTypeForm)) {
          $scope.leaseAgreement.type = $location.search().type;
          
         $http.post($stateParams.tenantid+'/api/leaseAgreement/update', $scope.leaseAgreement).success(function(result) {
             if (result) {
                 logger.logSuccess("Updated successfully!");
                 $state.go('app.eqs.leaseAgreementType.leaseAgreementTypeList',{tenantid:$stateParams.tenantid});
             } else {
                 logger.logError("Error in update!");
             }
         }).error(function(data) {
             console.log("data" + data);
         });

     } else {
         toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.LeaseAgreementTypeForm.$validationSummary), 555000, 'trustedHtml');
     }
 };
    
     
$scope.cancel = function() {
    $state.go('app.eqs.leaseAgreementType.leaseAgreementTypeList',{tenantid:$stateParams.tenantid});
};

$http.get($stateParams.tenantid+'/app/leaseAgreement/getLeaseAggTypeList').success(function(datas) {
    console.log(datas);
    debugger
    $scope.type = datas;

    });





	
});

