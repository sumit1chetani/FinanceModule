'use strict';

app.controller('mnrreportList', function($scope, $rootScope, $http, $location, logger, utilsService, ngDialog, $state,sharedProperties,$window,$stateParams) {
	
    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    
    
    
    
    $scope.mnrreport={
    		containerNo:'',
    		depot:'',
    		dateFrom:'',
			dateTo:'',
			estimatedate:'',
    		
    		approveddate:'',
    		emptyavailabledate:'',
    	
    		damageduration:'',
    		emptyDate:'',
    		estiamount:'',
    	
  		  appramount:'',
    		
    }
    $scope.mnrreport={
    		containerNo:'',
    		depot:'',
    		dateFrom:'',
			dateTo:'',
			estimatedate:'',
    		
    		approveddate:'',
    		emptyavailabledate:'',
    	
    		damageduration:'',
    		emptyDate:'',
    		estiamount:'',
    	
  		  appramount:'',
    		
    }
    

    $scope.reset = function(booking) {
    
    	$scope.mnrreport={
        		containerNo:'',
        		depot:'',
        		dateFrom:'',
    			dateTo:'',
    			estimatedate:'',
        		approveddate:'',
        		emptyavailabledate:'',
        		damageduration:'',
        		emptyDate:'',
        		estiamount:'',
        	
      		  appramount:'',
        		
        };
    	$scope.checked1 =false;
    	 $scope.getList();
    }
    
  //pol

    $http.post($stateParams.tenantid+ '/api/containerBank/GetPortByVoyage').success(function(data) {
    		$scope.polList = data;
    });
    //pod
    $http.post($stateParams.tenantid+ '/api/containerBank/GetPortByVoyage').success(function(data) {
    		$scope.podList = data;
    });
    
    
    
    
    

	 $scope.getList = function() {
		// $scope.details = false;
  	 $http.post($stateParams.tenantid+'/app/estimateReport/list',$scope.mnrreport).success(function(response) {
        		 $scope.rowCollection = response;
        	    $scope.details = true;

  	 })
};
 $scope.getList();
 
 
 
 $scope.getSearch = function() {
   	 
	  $http.post($stateParams.tenantid+'/app/estimateReport/searchportDtl',$scope.mnrreport).success(function(datas) {
         	console.log(datas.searchList.length);

            if(datas.searchList.length==0){
                logger.logError("No Records Found")
                $scope.rowCollection=[];
            
            }
            else
                {
                $scope.rowCollection=datas.searchList;
                
                }
        
     });
}
 
    

	 $scope.exportExcel = function(){

      $http.post($stateParams.tenantid+'/app/estimateReport/ExportExcel', $scope.mnrreport).success(function(response) {
          if(response){
              debugger;
              $("#MNRReport").bind('click', function() {
              });
              $('#MNRReport').simulateClick('click');
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

    
});