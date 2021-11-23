'use strict';

app.controller('containerOnHireListCtrl', function($scope, $rootScope, $http, $location, logger, utilsService, ngDialog, toaster,
		$state,sharedProperties,$window,$stateParams,$injector,$filter,$controller) {

    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    
    
    $scope.getList=function(){
        $http.get($stateParams.tenantid+'/api/containerOnHire/list').success(function(datas) {
            console.log(datas);
            $scope.rowCollection = datas;
        	
            }).error(function(datas) {
        });
        };
        $scope.getList();
        
    $scope.add = function() {
        $state.go('app.eqc.containerOnHire.add',{tenantid:$stateParams.tenantid});
    };
    
    $scope.editCro = function(rNo  ){
    	$location.url($stateParams.tenantid+'/eqc/containerOnHire/add?rNo='+rNo);
    	}
    
 // Redirecting Page For Edit Functionality
    $scope.editRow = function(onHireRefNo) {
    	debugger
        $location.url($stateParams.tenantid+'/eqc/containerOnHire/edit?onHireRefNo='+onHireRefNo);
    };
   
//    $scope.editRow = function(rowid) {   
//    	
//    	$location.url($stateParams.tenantid+'/master/containersize/edit?rowid='+rowid);    
//     }
//    
    $scope.deleteRow = function(onHireRefNo) {
        ngDialog.openConfirm().then(function() {
        
            var url = $stateParams.tenantid+'/api/containerOnHire/delete?onHireRefNo=' + onHireRefNo;
            $http.get(url).success(function(result){
                if (result.isSuccess ==  true) {
                    logger.logSuccess("Deleted Successfully");
                    $state.reload();
               } else {
                    logger.logError("You Can't Delete this Record, Related Data Exist! ");
                }
            }).error(function(result) {
                logger.logError("Error Please Try Again");
            });
        }, function(reason) {
            console.log('Modal promise rejected. Reason: ', reason);
        });
    };

  /*  $scope.view =function(onHireRefNo){
    	$rootScope.onHireRefNo=onHireRefNo;
	    ngDialog.open({
	        scope : $scope,
	        template : 'id1',
	        controller : $controller('deliveryOrderpopCtrl', {
	            $scope : $scope
	        }),
	        className : 'ngdialog-theme-plain',
	        showClose : true,
	        closeByDocument : false,
	        closeByEscape : false
	        preCloseCallback : $scope.getList,
	        
         closeByEscape : false

	    });
	    
	    
	};*/
	
	$scope.closeUpload = function() {
		ngDialog.close();
	}
	
	$scope.view = function(onHireRefNo){
    	$rootScope.onHireRefNo = onHireRefNo;
    	$scope.callQCDialog($scope,$http, ngDialog, logger,$injector, sharedProperties,$stateParams, toaster,$rootScope);
    	};
    	
    	
    	$scope.callQCDialog = function($scope,$http, ngDialog, logger,$injector, sharedProperties,$stateParams, toaster,$rootScope){
    		ngDialog.open({
    		scope: $scope,
    		template: '/views/eqc/containerOnHire/containerOnHirePopup',
    		controller: $controller('onhireContCtrl', {
    		$scope: $scope,
    		$http:$http,
    		ngDialog:ngDialog,
    		logger:logger,
    		$injector:$injector,
    		sharedProperties:sharedProperties,
    		toaster:toaster,
    		$rootScope:$rootScope
    		}),
    		className: 'ngdialog-theme-plain',
    		showClose: false,
    		closeByDocument: false,
    		closeByEscape: false,
    		preCloseCallback : $scope.getList
    		});

    		}

    
});

app.controller('onhireContCtrl', function($scope, $timeout, $stateParams,sharedProperties,toaster,
		$filter, $rootScope, $http, $location, logger, $state, ngDialog,$controller,$injector,validationService) {
	

	$scope.containerOnHire = {
 			onHireRefNo : '',
	}
    $scope.rowCollection1 = [];

	 $scope.containerOnHire.onHireRefNo = $rootScope.onHireRefNo;
	
	 $http.post($stateParams.tenantid+'/api/containerOnHire/view?onHireRefNo=' +$scope.containerOnHire.onHireRefNo).success(function(result) {
		 $scope.rowCollection1 = result.containerDtl;
		 
 });
	
	 $scope.closePopup = function(){
	        ngDialog.close();
	         
	  }
	 
	
});