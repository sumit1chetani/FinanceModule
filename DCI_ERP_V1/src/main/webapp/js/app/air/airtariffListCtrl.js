'use strict';

app.controller('airtariffListCtrl', function($scope, $rootScope, $http, $location, logger, utilsService, ngDialog, $state,sharedProperties,$window,$stateParams) {

    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    
    $scope.add = function() {
        $state.go('app.air.tariff.add',{tenantid:$stateParams.tenantid});
    };
    
    $scope.getBookingList = function() {
		$http.post($stateParams.tenantid+'/app/airtariff/list').success(function(data) {
			debugger
			$scope.rowCollection = data.lQuotationBean;
		});
	};
	$scope.getBookingList();
    
    
    $scope.editRow = function(SCHdId) {   
    	
    	$location.url($stateParams.tenantid+'/airTariff/edit?SCHdId='+SCHdId);    
     }
    
$scope.deleteRow = function(SCHdId) {
    	
        ngDialog.openConfirm().then(function() {
            var myURL = $stateParams.tenantid+'/app/airtariff/delete';
            $http({
                method : 'post',
                url : myURL,
                data : SCHdId,
            }).success(function(data) {
                if (data.success == true) {                    
                    logger.logSuccess("Deleted Successfully");
                    $state.reload();
                } else {
                    logger.logError("Error in deleting Record!");
                }
            }).error(function(data) {
                logger.logSuccess("Error in Delete!");
            });
        });

    };
    
    $scope.view = function(SCHdId) {
    	$location.url($stateParams.tenantid+'/airTariff/view?SCHdId='+SCHdId); 
     }
    
});