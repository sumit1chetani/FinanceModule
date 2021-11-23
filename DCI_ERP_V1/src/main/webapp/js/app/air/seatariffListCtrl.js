'use strict';

app.controller('seatariffListCtrl', function($scope, $rootScope, $http, $location, logger, utilsService, ngDialog, $state,sharedProperties,$window,$stateParams) {

    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $('.rounded').val($rootScope.seatariffListCtrl);
    
    $scope.add = function() {
    	$rootScope.seatariffListCtrl=$('.rounded').val();
        $state.go('app.sea.tariff.add',{tenantid:$stateParams.tenantid});
    };
    
    $scope.getBookingList = function() {
		$http.post($stateParams.tenantid+'/app/airtariff/listsea').success(function(data) {
			debugger
			$scope.rowCollection = data.lQuotationBean;
		});
	};
	$scope.getBookingList();
	
    $scope.getpolpodList = function() {
	$http.get($stateParams.tenantid+ '/standardcharge/aodList').success(
			function(datas) {
				$scope.polList = datas.commonUtilityBean;
				$scope.podList = datas.commonUtilityBean;
			}).error(
			function(datas) {
			});
    };
    $scope.getpolpodList();
    
    $scope.editRow = function(SCHdId) {   
    	$rootScope.seatariffListCtrl=$('.rounded').val();
    	$location.url($stateParams.tenantid+'/seaTariff/edit?SCHdId='+SCHdId);    
     };
 //search   
$scope.search = function(charge) {
    	
	$http.post($stateParams.tenantid+'/app/airtariff/search',charge).success(function(data) {
                if (data.success == true) {                    
                    $scope.rowCollection = data.lQuotationBean;
                } else {
                    logger.logError("Error in search Record!");
                }
            }).error(function(data) {
                logger.logSuccess("Error in search!");
            });

    };
    
    
$scope.deleteRow = function(SCHdId) {
    	
        ngDialog.openConfirm().then(function() {
            var myURL = $stateParams.tenantid+'/app/airtariff/deletesea';
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
    	$rootScope.seatariffListCtrl=$('.rounded').val();
    	$location.url($stateParams.tenantid+'/seaTariff/view?SCHdId='+SCHdId); 
     }
    
});