'use strict';

app.controller('gateoutgateinListCtrl', function($scope, $rootScope, $http, $location, logger, utilsService, ngDialog, $state,sharedProperties,$window,$stateParams) {

		$scope.itemsByPage = 10;
		$scope.numPages = 0;
		$scope.offsetCount = 0;
		$scope.limitCount = 1000;
		$scope.rowCollection = [];
		$scope.displayedCollection = [];
		$scope.itemsByPage = 10;
		$scope.isUpload=true;
		$scope.isDelete=true;
		
		$scope.quotation={
				service:'',
				aol:'',
				origin:'',
				customer:'',
				salesPerson:'',
				vendor : '', 
				attention : '',
				quotationDate : '',
				branch : '',
				aod : '',
				destination : '',
				shipper : '',
				salesType : '',
				carrier : '',
				termConditions : '',
				mode : '1',
				currency : '',
				term : '',
				type : 'Export',
				consignee : '',
				nominatedBy : '',
				validityDate : '',
				remarks : '',
				vessel :'',
				dimensionName:'',
				quotationDtl:[{id:0,conType:'',quantity:'',depot:'',allocDate:''}],
				sealDtl:[{id:0,sealNo:'',sealFrom:'',sealTo:'',count:''}]
		
		}
		
		$scope.gateOut={
			
				doType:'export'
				
		}
		

		
		$scope.add = function() {
		    $state.go("app.eqs.gateoutgatein.gateoutgateinadd",{tenantid:$stateParams.tenantid});
		};
		
		$scope.getRfqList = function() {
			$http.post($stateParams.tenantid+'/app/gateOutin/list').success(function(datas) {
				$scope.rowCollection = datas.importList;
			}).error(function(datas) {

			});
		};
		$scope.getRfqList();
		
		//Edit functionality
		$scope.editRow = function(moveId) {
		    $location.url($stateParams.tenantid+'/gateoutgateinadd/Edit?moveId='+moveId);
		};
		
		//delete
		
		$scope.deleteRow = function(moveId,containerStatusID,containerID,conStatus) {
	        ngDialog.openConfirm().then(function() {
	        
	            var url = $stateParams.tenantid+'/app/gateOutin/delete?moveId='+moveId+'&containerStatusID='+containerStatusID+'&containerID='+containerID+'&conStatus='+conStatus;
	            $http.get(url).success(function(result){
	                if (result.success ==  true) {
	                    logger.logSuccess(result.message);
	                    $state.reload();
	               } else {
	                    logger.logError(data.message);
	                }
	            }).error(function(result) {
	                logger.logError("Error Please Try Again");
	            });
	        }, function(reason) {
	            console.log('Modal promise rejected. Reason: ', reason);
	        });
	    };
    
});