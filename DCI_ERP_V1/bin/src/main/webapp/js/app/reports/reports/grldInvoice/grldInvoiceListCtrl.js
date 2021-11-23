'use strict';
app.controller('grldInvoiceListCtrl', function($scope,$stateParams, $rootScope, $http, $location, logger, $log, ngDialog, 
        $modal, utilsService,$state,sharedProperties,$timeout,$window) {

    $scope.pageCounters = [14, 16, 17, 18, 150, 500, 1000 ];
   

    $scope.offsetCount = 0;
    $scope.limitCount = 1000;

    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    
    $scope.emptyObject={};
    

    $scope.grldinvoiceData={
    		fromDate : '',
            toDate  : ''
            
            }
   
    
    $scope.add = function(){
        $state.go('app.reports.grldinvoice-add',{tenantid:$stateParams.tenantid});
    };
    
    $scope.editedRow = function(invoiceNo) { 
          $location.url($stateParams.tenantid+'/reports/grldinvoice/edit?invoiceNo='+invoiceNo);
    }  
    $scope.view = function(invoiceNo) { 
        $location.url($stateParams.tenantid+'/reports/grldinvoice/view?invoiceNo='+invoiceNo + '&viewFlag='+true);
  } 
    $scope.getList = function() {
    	
   	 $http.post($stateParams.tenantid+'/app/grldinvoice/getGRLDList').success(function(data){
   		 console.log(data);
            $scope.rowCollection = $scope.rowCollection.concat(data);  	 
   		 
   	    }).error(function(datas){
   	        logger.logError("Error");
   	    });
   	 };

   $scope.getList();
   
  /* $scope.search = function() {
	   
	   
	   
	   $scope.obj={
			   fromDate = $scope.grldinvoiceData.fromDate,
	           toDate = $scope.grldinvoiceData.toDate
	   }
	   


	  
	   $http.post($stateParams.tenantid+ "/app/grldinvoice//searchList",obj).success(function(response) {
   	
	   	// $http.post($stateParams.tenantid+'/app/grldinvoice/searchList').success(function(data){
	   		 console.log(data);
	            $scope.rowCollection = $scope.rowCollection.concat(data);  	 
	   		 
	   	    }).error(function(datas){
	   	        logger.logError("Error");
	   	    });
	   	 };
    */
   
  /* $scope.search = function() {
	   
	   $http.post($stateParams.tenantid+ '/app/grldinvoice/searchListl?fromDate='+$scope.grldinvoiceData.fromDate+'&toDate='+$scope.grldinvoiceData.toDate).success(function(data) {
		   console.log(data);
           $scope.rowCollection = $scope.rowCollection.concat(data);  
   	  }).error(function(datas){
	   	        logger.logError("Error");
	   	    });
	   	 };
	*/
   $scope.print = function(invoiceNo){
       debugger
       console.log("Both print invoice")
       var url = $stateParams.tenantid+'/app/grldinvoice/print?invoiceNo=' + invoiceNo;
       var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
       wnd.print();   
    }
   
	     //Search
	      $scope.search = function(){
	        	
	        	 $http.post($stateParams.tenantid+'/app/grldinvoice/searchList', $scope.grldinvoiceData).success(function(response) {
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
    

    
	$scope.deleteRow = function(invoiceNo) {
		ngDialog.openConfirm().then(
				function() {
					$http.post($stateParams.tenantid+ "/app/grldinvoice/delete",invoiceNo).success(function(response) {
								if (response.success==true) {
									logger.logSuccess("Deleted Succesfully!");
									$scope.getList();								}
							}).error(function(response) {
								logger.logError("Error Please Try Again");
							});
				});
	};  
    
    

    
           
   
                
  
 
       


  

    
});