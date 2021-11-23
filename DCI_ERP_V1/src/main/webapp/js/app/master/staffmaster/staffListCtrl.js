'use strict';

app.controller('staffListCtrl', function($scope, $rootScope, $http, $location, logger, utilsService, ngDialog, $state,sharedProperties,$window,$stateParams) {
	 $scope.dataLoopCount = 0;
	    $scope.offsetCount = 0;
	    $scope.limitCount = 1000;
	    $scope.updatedData = [];
	    $scope.rowCollection = [];
	    $scope.displayedCollection = [];
	    $scope.itemsByPage = 10;
	    $scope.employeelist1 = [];
  
	    
	    
    $scope.add = function() {
        $state.go('app.truck.staffmaster.add',{tenantid:$stateParams.tenantid});

    };
    
    $scope.cancel = function() {
        $state.go('app.truck.staffmaster.list',{tenantid:$stateParams.tenantid});

    };
    
    // save
    
	$scope.save = function() {
		sharedProperties.clearObject();

		console.log();

		$http.post($stateParams.tenantid +'/staff/save', $scope.expenseType)

		.success(function(response) {
			if (response == 1) {
				logger.logSuccess("Saved Succesfully!");

				$state.go("app.master.expenseType.list", {
					tenantid : $stateParams.tenantid
				});
			} else {
				logger.logError("Error in save staff")
			}
		});

	};
    
    
    
    $scope.getList=function(){
    $http.get($stateParams.tenantid+'/staff/list').success(function(datas) {
        console.log(datas);
        $scope.rowCollection = datas.list;
    	
        }).error(function(datas) {
    });
    };
     //  loading employee
    
        $http.get($stateParams.tenantid+'/staff/employeelist').success(function(datas) {
            $scope.employeelist1 = datas.resultList;
        	
            }).error(function(datas) {
        });
        
        
  $scope.deleteRow = function(staffId) {
    	
        ngDialog.openConfirm().then(function() {
            var myURL = $stateParams.tenantid+'/staff/delete';
            $http({
                method : 'post',
                url : myURL,
                data : staffId,
            }).success(function(data) {
                if (data == true) {                    
                    logger.logSuccess("Deleted Successfully");
                    $state.reload();
                } else {
                    logger.logError("Unable to delete Record!");
                }
            }).error(function(data) {
                logger.logSuccess("Error in Delete!");
            });
        });

    };
    
    
    

    
    $scope.getList();
    $scope.editRow = function(rowid) {   
	$location.url($stateParams.tenantid+'/staff/edit?rowid='+rowid);       

     }
    $scope.view = function(rowid) {   
    	$location.url($stateParams.tenantid+'/staff/view?rowid='+rowid);       

         }
   
    $scope.staff = {
    		Iahsempcode : '',
    		trmsempcode:''
    }
    
	$scope.save = function() {
		sharedProperties.clearObject();
 if($scope.staff.iahsempcode != "" && $scope.staff.iahsempcode != null && $scope.staff.iahsempcode != undefined ){
   if($scope.staff.trmsempcode != "" && $scope.staff.trmsempcode != null && $scope.staff.trmsempcode != undefined ){

		$http.post($stateParams.tenantid +'/staff/save', $scope.staff).success(function(response) {
			if (response.success == true) {
				logger.logSuccess("Saved Succesfully!");

				$state.go("app.truck.staffmaster.list", {
					tenantid : $stateParams.tenantid
				});
			} else {
				logger.logError("Already IAHS Emp Code is saved")
			}
		});
 }else{
	 logger.logError("TRMS EMPLOYEES Should not be Empty") 
 }
 }else{
	 logger.logError("IAHS EMP CODE Should not be Empty") 
 }


	};
    
});