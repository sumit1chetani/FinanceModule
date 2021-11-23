'use strict';

app.controller('multiModalListCtrl', function($scope, $rootScope,ngDialog, $http, $location, logger,
        utilsService,$state,sharedProperties,$window,validationService,toaster,$stateParams) {
	 
	
	$scope.getList=function(){
		    $http.post($stateParams.tenantid+'/app/multiModal/getSeaJobNo').success(function(datas) {
		        console.log(datas);
		        $scope.seaJobNoList = datas.seaJobNoList;
		    	
		        }).error(function(datas) {
		    });
		    };
		    $scope.getList();
 
		 var validate=false;
		 var msg="";
     $scope.printRow = function(seaJobNo1) {
    	 if(seaJobNo1==undefined || seaJobNo1==""  ){
    		validate=false;
    		msg="Please select Job Order No";
    	 }
    	 else
    		 {
    		   validate=true;
    		 }
    	 if(validate){
    	 var SeaJobNo=seaJobNo1;
			 	   debugger
				        var url = $stateParams.tenantid+'/app/multiModal/print?SeaJobNo='+SeaJobNo;
				        var wnd = $window.open(url, 'Athena', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
				        wnd.print();   
				     
     }else
    	 {
    		logger.logError(msg);
    	 }
     }
	
});


