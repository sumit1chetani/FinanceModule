'use strict';

app.controller('emptyRepositioningCtrl', function($scope, $rootScope, $http, $location, logger, utilsService, ngDialog, $state,sharedProperties,$window,$stateParams) {

		$scope.itemsByPage = 10;
		$scope.numPages = 0;
		$scope.offsetCount = 0;
		$scope.limitCount = 1000;
		$scope.rowCollection = [];
		$scope.displayedCollection = [];
		$scope.itemsByPage = 10;
		$scope.isUpload=true;
		$scope.isDelete=true;
		
		
		$scope.add = function() {
		    $state.go("app.operation.emptyRepositioning.add",{tenantid:$stateParams.tenantid});
		};
		 $scope.viewRow = function(erCode) {
		    	debugger
		        $location.url($stateParams.tenantid+'/operation/emptyRepositioning/view?erCode='+erCode);
		    };
		$scope.getRfqList = function() {
			$http.post($stateParams.tenantid+'/app/emptyRepositioning/list').success(function(datas) {
				$scope.rowCollection = datas.lQuotationBean
			}).error(function(datas) {

			});
		};
		$scope.getRfqList();
		
		//Edit functionality
		$scope.editRow = function(erCode) {
		    $location.url($stateParams.tenantid+'/operation/emptyRepositioning/edit?erCode=' + erCode);
		};
		
		//Delete functionality
		$scope.deleteRow = function(quotationNo) {	
			ngDialog.openConfirm().then(function() {
			$http.post($stateParams.tenantid+'/app/emptyRepositioning/delete',quotationNo).success(function(datas) {
				
				if(datas.success){
				$state.reload();
				logger.logSuccess("Deleted Successfully");

				}else{
					logger.logError(datas.message);
				}
				 
			
		
		}).error(function(datas) {

		});
			
			 }, function(reason) {
		            console.log('Modal promise rejected. Reason: ', reason);
		        });
		
		};


    
});