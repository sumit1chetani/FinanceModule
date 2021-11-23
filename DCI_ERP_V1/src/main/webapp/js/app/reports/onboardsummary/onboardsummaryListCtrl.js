/**
 * 
 */'use strict';
app.controller('onboardSummaryCtrl', function($templateCache,$timeout, $scope, $rootScope, $http, logger, $log, ngDialog, $modal, $location, $sce, $filter,utilsService,$stateParams) {
    $scope.onboardSummaryReport = {
    		
    		vessel:'',
    		pol:'',
    		pod:'',
    		fromDate:'',
    		toDate:''
    			
  
       
    };

   

    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.vessellist = [];
    $scope.voyageList = [];
    $scope.customerList = [];
    $scope.searchList =[];
    $scope.customerformList =[];

    $scope.searchInvoiceDtl =[];
    $scope.getDropdownvalue = function() {
        
        $http.get($stateParams.tenantid+'/api/onBoardSummary/vessellist').success(function(datas) {
            $scope.vessellist = datas;
        }).error(function(datas) {
        });
        
        $http.get($stateParams.tenantid+'/api/onBoardSummary/voyagelist').success(function(datas) {
            $scope.voyagelist = datas;
        }).error(function(datas) {
        });
        
   	 //pol

  	  $http.post($stateParams.tenantid+ '/api/containerBank/GetPortByVoyage').success(function(data) {
				$scope.polList = data;
  	  });
//pod
  	  $http.post($stateParams.tenantid+ '/api/containerBank/GetPortByVoyage').success(function(data) {
				$scope.podList = data;
  	  });

    }
    $scope.getDropdownvalue();
    

    
    $scope.getList = function() {
        $http.post($stateParams.tenantid+'/api/onBoardSummary/list',$scope.bookingReport).success(function(datas) {
        	/*var l=1;
        	for(var i=0;i<datas.length;i++){
        		
        		datas[i].slno=l;
        		l++;
        		
        	}*/
            $scope.rowCollection = datas;
            })
    };
        $scope.getList();
    
    
    //SERACH
    

    $scope.getSearch = function(){
    	
   	 $http.post($stateParams.tenantid+'/api/onBoardSummary/searchonboardSummaryDtl', $scope.onboardSummaryReport).success(function(response) {
      	console.log(response.searchList.length);

            if(response.searchList.length==0){
                logger.logError("No Records Found")
                $scope.rowCollection=[];
            
            }
            else
                {
                $scope.rowCollection=response.searchList;
                
                }
        }); 
     
    }
    
    
   
    
    
    //Excel Export	
  	 $scope.exportExcel = function(){
  	   	 $http.post($stateParams.tenantid+'/api/onBoardSummary/ExportExcel', $scope.onboardSummaryReport).success(function(response) {

  	                if(response){
  	                    debugger;
  	                    $("#onBoardReport").bind('click', function() {
  	                    });
  	                    $('#onBoardReport').simulateClick('click');
  	                    logger.logSuccess("Exported successfully!");
  	                }else{
  	                    logger.logError("Failed to export");
  	                }
  	                
  	            }).error(function(response) {
  	                logger.logError("Error Please Try Again");
  	            });
  	    
  	    }
  	    
  	
  	  $.fn.simulateClick = function() {
  	        return this.each(function() {
  	            if ('createEvent' in document) {
  	                var doc = this.ownerDocument, evt = doc.createEvent('MouseEvents');
  	                evt.initMouseEvent('click', true, true, doc.defaultView, 1, 0, 0, 0, 0, false, false, false, false, 0, null);
  	                this.dispatchEvent(evt);
  	            } else {
  	                this.click(); // IE
  	            }
  	        });
  	    }

  	$scope.reset = function(onboardSummaryReportForm) {
  		$scope.onboardSummaryReport = {
  	    		
  	    		vessel:'',
  	    		pol:'',
  	    		pod:'',
  	    		fromDate:'',
  	    		toDate:''
  	    			
  	  
  	       
  	    };
	    	
	        $scope.getList();

	    }
    
});

