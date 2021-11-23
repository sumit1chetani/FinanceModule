'use strict';
app.controller('shipmentOrderCtrl', function($scope,$stateParams, $rootScope, $http, $location, logger, utilsService,$state,sharedProperties,$window,ngDialog) {

        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.hideUploadIcon = true;
       
        $scope.emptyObject={};
        $scope.add = function() {
            $state.go('app.documentation.shipmentorder.add',{tenantid:$stateParams.tenantid});    
        };
        
        
        $scope.shipmentOrder = {
        		pol:'',
        		pod:'',carrier:'',
        		bookingStatus:'',
        		gateoutStatus:''
        		
        };
        
        $scope.modeList=[];
        $scope.carrierList=[];
    	$scope.getQuotationType = function() {
    	    var  data = {};
    	    data["id"] = "1";
    	    data["text"] = "SEA COASTAL";
    	    $scope.modeList.push(data);
    	    //$scope.quotation.mode='1';
    	    data = {};
    	    data["id"] = "2";
    	    data["text"] = "SEA FOREIGN";
    	    $scope.modeList.push(data);
    	    data = {};
    	    data["id"] = "3";
    	    data["text"] = "TRUCK";
    	    $scope.modeList.push(data);
    	    data = {};
    	    data["id"] = "4";
    	    data["text"] = "LINER";
    	    $scope.modeList.push(data);
    	}
    	$scope.getQuotationType();
        $scope.editshipOrd = function(shipOrdNo) {
        	debugger
            $location.url($stateParams.tenantid+'/documentation/shipmentorder/add?shipOrdNo='+shipOrdNo);
        };
        
        // Redirecting Page For Edit Functionality
        $scope.editRow = function(vessel) {
        	debugger
            $location.url($stateParams.tenantid+'/documentation/shipmentorder/edit?shipmentOrderId='+vessel);
        };
        
        $scope.viewRow = function(vessel) {
        	debugger
            $location.url($stateParams.tenantid+'/documentation/shipmentorder/view?shipmentOrderId='+vessel);
        };
        
        
        $scope.getList = function() {
         
            var url = $stateParams.tenantid+'/api/shipOrder/list';
            $http.get(url).success(function(data) {
            	
            	console.log("shipOrder List",data);
                if (data.length > 0) {
                	
                    $scope.rowCollection = $scope.rowCollection.concat(data);
                    sharedProperties.setObject($scope.emptyObject);
                }
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
            $scope.offsetCount = $scope.offsetCount + $scope.limitCount;
        };

        $scope.getList();
        
        
        $scope.getSearchList = function() {
        	
        	/*var url = $stateParams.tenantid+'/api/shipOrder/SearchList';
            $http.get(url,$scope.shipmentOrder).success(function(data) {
                if (data.length > 0) {
                	
                    $scope.rowCollection = $scope.rowCollection.concat(data);
                    sharedProperties.setObject($scope.emptyObject);
                }
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
            $scope.offsetCount = $scope.offsetCount + $scope.limitCount;*/
       	 
         	  $http.post($stateParams.tenantid+'/api/shipOrder/SearchList',$scope.shipmentOrder).success(function(data) {
                   console.log(data);
                   if (data.length > 0) {
                   	
                       $scope.rowCollection = data;
                      // sharedProperties.setObject($scope.emptyObject);
                   }else{
                	   logger.logError("No Details Found"); 
                   }
               	
                   }).error(function(data) {
                	   logger.logError("Error Please Try Again");
               });
         	 $scope.offsetCount = $scope.offsetCount + $scope.limitCount;
         	  
         }

        //   $scope.getSearchList();
   
                 
                 $scope.reset = function() {
                	 $scope.shipmentOrder = {
                     		pol:'',
                     		pod:'',
                     		bookingStatus:'',
                     		gateoutStatus:''
                     		
                     };
            	    	
            	   //     $scope.getSearchList();

            	    }
        
      

/**
 * Delete Row
 */
             	$http.get($stateParams.tenantid+'/app/commonUtility/getcarrierList').success(function(datas) {
            		debugger
            	    $scope.carrierList = datas.commonUtilityBean;	    
                    //$scope.transList = datas.lCommonUtilityBean;	    

            	}).error(function(data) {

            	});

$scope.deleteRow = function(shipmentOrderId) {
    ngDialog.openConfirm().then(function() {
    
        var url = $stateParams.tenantid+'/api/shipOrder/delete?shipmentOrderId=' + shipmentOrderId;
        $http.get(url).success(function(result){
            if (result.isSuccess ==  true) {
                logger.logSuccess("Deleted successfully");
                $state.reload();
           } else {
        	   logger.logError(result.message);
            }
        }).error(function(result) {
            logger.logError("Error Please Try Again");
        });
    }, function(reason) {
        console.log('Modal promise rejected. Reason: ', reason);
    });
};

$scope.view = function(deptCode) {
	$location.url($stateParams.tenantid+'/vesselsailing/view?deptCode='+deptCode); 
 }



//port
$http.get(
		$stateParams.tenantid
				+ '/app/seaquotation/getiataList')
		.success(function(datas) {
			debugger
			$scope.polList = datas.commonUtilityBean;
			$scope.podList = datas.commonUtilityBean;

		}).error(function(data) {

		});
/*$http.get(
		$stateParams.tenantid
				+ '/app/commonUtility/getPort').success(function(data) {
			$scope.polList = data.commonUtilityBean;

		});

$http.get(
		$stateParams.tenantid
				+ '/app/commonUtility/getPort').success(function(data) {
			$scope.podList = data.commonUtilityBean;

		});*/

// Gate out Status

$scope.gateOutStatusList=[
	 
	  { id: 'pending', text: 'Pending' },
	  { id: 'completed', text: 'Completed' }
	
]


//T/S Status

$scope.tsStatusList=[
	 
	  { id: 'ts', text: 'Yes' },
	  { id: 'regular', text: 'No' }
	
]


    });

