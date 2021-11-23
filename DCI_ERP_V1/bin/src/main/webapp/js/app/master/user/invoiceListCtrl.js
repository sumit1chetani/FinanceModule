'use strict';
app.controller('invoiceListCtrl', function($scope,$filter, $timeout, $rootScope, $http, $location, logger, $log, ngDialog, utilsService, $injector, sharedProperties, toaster,$stateParams) {

            $scope.invoiceDraft ={
            
            	invoiceType : '',
           	    voucherNo:'',
                accthead:'',
                invoiceNo:'',
      	        localAmount:'',
                usdAmount:'',
                invoiceAmount:'',
                allotedDate:'',
                allotedBy:'',
                partyName:''
                	
            }
            
//list
	
	$scope.salesTypeList = [];
	 $scope.salesType = function() {
		  var data = {};
			data["id"] = "1";
			data["text"] = "Sales Invoice";
			$scope.salesTypeList.push(data);
		  
		var data = {};
		data["id"] = "2";
		data["text"] = "Purchase Invoice";
		$scope.salesTypeList.push(data);
		
		var data = {};
		data["id"] = "3";
		data["text"] = "TDS";
		$scope.salesTypeList.push(data);
		
	};
	$scope.salesType();
	
	debugger
	$scope.getSearchList=function(invoiceType){
		 $http.post($stateParams.tenantid+'/app/userList/searchlist',invoiceType).success(function(data) {
			  if (data.success == true) {
                	 $scope.rowCollection  = data.listBean;
                  	console.log(data);
             } else {
                     logger.logError("No data found!");
               }
           }).error(function(data) {
               console.log("result" + data);
           });
//			$scope.getSearchList();
   
    	   
		
	};

	
    
    
    
    
});
