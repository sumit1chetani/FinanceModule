'use strict';

app.controller('repairEstimateListCtrl', function($scope, $rootScope, $http, $location, logger, utilsService, ngDialog, $state,sharedProperties,$window,$stateParams) {

    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    
    
    $scope.repairEstimate={
    		repairEstimateID:'',
    		status:'Approved',
    		eirRefNo:'',
    		depot:'',
    		containerNo:'',
    		containerId:'',
    		containerType:'',
    		agent:'',
    		returnDate:'',
    		inspectionDate:null,
    		equipmentStatus:'',
    	
    	
    }
    
    $scope.getList
	
	$scope.$watch('repairEstimate.status',function(newValue, oldValue) {
		if(newValue!=null && newValue!=undefined && newValue!=""){
			$scope.getList($scope.repairEstimate);
		}
	});

    $scope.getList =function(repairEstimate) {
    	$scope.getList=function(){
            $http.post($stateParams.tenantid+'/app/repairEstimates/list',repairEstimate).success(function(datas) {
                console.log(datas);
                $scope.rowCollection = datas.list1;
            	
                }).error(function(datas) {
            });
            };
    };

    $scope.getList=function(repairEstimate){
        $http.post($stateParams.tenantid+'/app/repairEstimates/list',repairEstimate).success(function(datas) {
            console.log(datas);
            $scope.rowCollection = datas.list1;
        	
            }).error(function(datas) {
        });
        };    
    
    $scope.add = function() {
        $state.go('app.eqs.repairEstimate.repairEstimateAdd',{tenantid:$stateParams.tenantid});
    };
    
    
    $scope.statusList = [{
    	id : 'Pending',
    	text : 'Pending'
    },
    {
    	id : 'Approved',
    	text : 'Approved'
    }]
    
    
 // Redirecting Page For Edit Functionality
    $scope.editRow = function(repairEstimateNo,status) {
    	debugger
    	if(status == 'Approved'){
    		logger.logError("NOTE: CAN’T EDIT AFTER APPROVAL..!!");
        $location.url($stateParams.tenantid+'/repairEstimate/Edit?repairEstimateNo='+repairEstimateNo);
    	}else{
            $location.url($stateParams.tenantid+'/repairEstimate/Edit?repairEstimateNo='+repairEstimateNo);

    	}
    	
    };

    $scope.deleteRow = function(repairEstimateNo) {
        ngDialog.openConfirm().then(function() {
        
            var url = $stateParams.tenantid+'/app/repairEstimates/delete?repairEstimateNo=' + repairEstimateNo;
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

   
});