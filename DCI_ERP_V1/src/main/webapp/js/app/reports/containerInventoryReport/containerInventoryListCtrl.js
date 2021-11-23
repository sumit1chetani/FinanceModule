'use strict';
app.controller('containerInventoryListCtrl', function($templateCache,$timeout, $scope, $rootScope, $http, logger, $log, ngDialog, $modal, $location, $sce, $filter,utilsService,$stateParams) {


    $scope.containerReport = {
    		
            containerNo : '',
            containerStatus : '',
            containerId:'',
            containerType:'',
            statusDate:'',
            status:'',
            statusDef:'',
            depot:'',
            type:''
        };



    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.depotList=[];
    $scope.typeList=[];
    
    $scope.typeList=[{
    	id:'All',
    	text :'All'
    },{
    	id:'Empty',
    	text :'Empty'
    },
    ,{
    	id:'Full',
    	text :'Full'
    },
    ,{
    	id:'Damage',
    	text :'Damage'
    }];
    $http.post($stateParams.tenantid+'/api/report/containerNo').success(function(data) {
	      	
  		$scope.containerNoList=data;
  		        		
  });
    
    $http.post($stateParams.tenantid+'/api/report/containerStatusDropDown').success(function(data) {
      	
		 $scope.containerstatusList = data;
  		        		
  });
    
    $http.post($stateParams.tenantid+'/api/report/containerTypeDropDown').success(function(data) {
      	
		 $scope.containerTypeList = data;
 		        		
 });
    
    
    $http.post($stateParams.tenantid+'/api/report/PortListByAgent').success(function(data) {
		 $scope.depotList = data;
});
    
    $scope.getList = function() {
    $http.post($stateParams.tenantid+'/api/report/Inventorylist').success(function(data) {
      	
		 $scope.rowCollection = data;
 		        		
 });
    };
    $scope.getList();
	        

		
    $scope.getSearch = function() {
    	 
    	   $http.post($stateParams.tenantid+'/api/report/containerInventoryReport',$scope.containerReport).success(function(data) {
               console.log("data" + data);
           		 $scope.rowCollection = data.lst;
           		 $scope.full = data.full;
        		 $scope.empty = data.empty;
        		 $scope.damage = data.damage;
           }).error(function(result) {
               console.log("data" + data);
           });
    	  
        
        
    };
    
    
	$scope.getReport = function(voyagecost) {

/*		var chk=false;
	if(voyagecost.voyage!=undefined && voyagecost.voyage!=''){
		if(voyagecost.vessel!=undefined && voyagecost.vessel!=''){
			chk=true;
		
		}
		}*/
		if(true){
		$http.post($stateParams.tenantid + '/api/report/containerInventoryReportXL',
				voyagecost).success(function(datas) {

				if (datas.success) {
					$("#GLExport").bind('click', function() {
					});
					$('#GLExport').simulateClick('click');

				} else {
					logger.logError("No Record Found");

				}

			}).error(function(datas) {

			});
		
		}
		/*else 
			{
			
			logger.logError("Please select Vessel and Voyage");
			}*/

		}
	
	$.fn.simulateClick = function() {
		return this.each(function() {
			if ('createEvent' in document) {
				var doc = this.ownerDocument, evt = doc
						.createEvent('MouseEvents');
				evt.initMouseEvent('click', true, true, doc.defaultView, 1, 0,
						0, 0, 0, false, false, false, false, 0, null);
				this.dispatchEvent(evt);
			} else {
				this.click(); // IE
			}
		});
	}
    
    $http.post($stateParams.tenantid+'/api/report/count').success(function(data) {
      	
		 $scope.full = data.full;
		 $scope.empty = data.empty;
		 $scope.damage = data.damage;
		        		
});
    $scope.reset = function(containerReport) {
    
    	$scope.containerReport = {
        		
                containerNo : '',
                containerStatus : '',
                containerId:'',
                containerType:'',
                statusDate:'',
                status:'',
                depot:'',
                type:''
                
            };
    	// $scope.type=[];
        $scope.getList();
        $http.post($stateParams.tenantid+'/api/report/count').success(function(data) {
          	
   		 $scope.full = data.full;
   		 $scope.empty = data.empty;
   		 $scope.damage = data.damage;
   		        		
   });

    }

        });




