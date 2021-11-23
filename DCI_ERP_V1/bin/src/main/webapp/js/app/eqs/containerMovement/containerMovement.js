'use strict';

app.controller('containerMovementListCtrl', function($scope, $stateParams, $state, $http,
		$location, ngDialog, logger, utilsService) {

	$scope.offsetCount = 0;
	$scope.limitCount = 1000;
	$scope.rowCollectionList = [];
	$scope.displayedCollection = [];
	$scope.itemsByPage = 10;
	$scope.containerNoList =[];
 
	
	
	$scope.containerMovement ={
	    containerNum:'',
		containerNo :'',
	    containerId:'',
	    containerType:'',
	    containerStatusId:'',
	    isoCode:'',
	    leaseType:'',
	    owner:'',
	    agreementNo:'',
	    
	    location:'',
	    depot:'',
	    movementCode:'',
	    subCode:'',
	    statusDate:'',
	    vessel:'',
	    voyage:'',
	    pol:'',
	    pod:'',
	    fpod:'',
	    pod1:'',
	    pod2:'',
	    blNo:'',
	    bookingNo:'',
	    sequenceS:'',
	    
	    detailList : []
	}
	
	
	
	$scope.blNo = $location.search().blNo;   
	$scope.from = $location.search().from;  
	
	
	$http.get($stateParams.tenantid+ '/api/containerMovement/containerNoList').success(function(data) {
		$scope.containerNoList = data;
	});
	
	 
/*		
    $scope.$watch('containerMovement.containerNum', function(newValue, oldValue) {
	      if(newValue!=null && newValue!=undefined && newValue != '')
 	      {
	    	  $http.post($stateParams.tenantid+ '/api/containerMovement/containerFullDetails?containerId='+newValue).success(function(data) {
	    			 $scope.containerMovement= data.containerMovementBean;
	    			 $scope.detailList= data.detailList;
	    	  });
	      }
	     
	    });
    */
	
	//container status
	
	$scope.sequenceList = [];
	$http.post($stateParams.tenantid+'/api/containerstatussequence/getcontainerStatus').success(function(data) {
	     	
			$scope.sequenceList=data;
			        		
	});
	// Booking No
	
	
	$http.get($stateParams.tenantid+ '/api/containerMovement/bookNoList').success(function(data) {
		$scope.bookingList = data;
	});
	
	
	  //booking based BL
	   $scope.$watch('containerMovement.bookingNo', function(newValue, oldValue) {
		      if(newValue!=null && newValue!=undefined && newValue != '')
	 	      {
		    	  $http.post($stateParams.tenantid+ '/api/containerMovement/getBlList?bookingNo='+newValue).success(function(data) {
		    		 $scope.blContainerNumList=[];	 
		    		  $scope.blList= data.detailList;
		    	  }); 
		      }else{
		    	  $http.post($stateParams.tenantid+ '/api/containerMovement/getBlList?bookingNo='+newValue).success(function(data) {
			    		 $scope.blContainerNumList=[];	 
			    		  $scope.blList= data.detailList;
			    	  }); 
		    		  
		      }
		     
		    });
	   
	   
		//BL based container number
	   $scope.$watch('containerMovement.blNo', function(newValue, oldValue) {
		      if(newValue!=null && newValue!=undefined && newValue != '')
	 	      {
		    	  $http.post($stateParams.tenantid+ '/api/containerMovement/getBlContainer?blNo='+newValue).success(function(data) {
		    			
		    		  $scope.blContainerNumList= data.detailList;
		    	  });
		      }
		     
		    });
	   
	   
		$scope.$watchCollection('[containerMovement.blNo,containerMovement.bookingNo,containerMovement.blContainerNum]',function(newValue, oldValue) {
			if (newValue != '' && newValue != undefined ) {
				
				$scope.containerMovement.containerNum='';
				
			}
		});
		
		
		 $scope.$watch('containerMovement.containerNum', function(newValue, oldValue) {
		      if(newValue!=null && newValue!=undefined && newValue != '')
	 	      {
		    	  $scope.containerMovement.blNo='';
		    	  $scope.containerMovement.bookingNo='';
		    	  $scope.containerMovement.blContainerNum='';
		    	  $scope.containerMovement.sequenceS='';

	 	      }
		     
		    });
    
  
	$scope.search = function(bean) {
		  $http.post($stateParams.tenantid+ '/api/containerMovement/search',bean).success(function(data) {
 			// $scope.containerMovement= data.containerMovementBean;
 			 $scope.detailList= data.detailList;
 	  });
	}
	 

	$scope.editRow = function(containerStatusId) {
		$location.url($stateParams.tenantid + '/containerStatus/containerStatusedit?containerStatusId='
				+ containerStatusId);
	}

	 
	
 	
  	//BL Detail view
  	
  	
  	 $scope.viewBlDetail = function(blNo){
   		$location.url($stateParams.tenantid+'/cim/BLView?blNo='+blNo);
  	 };
  	
  	 
  	 // Booking view
  	 
	 $scope.viewBookingDetail = function(bookingNo){
	   		$location.url($stateParams.tenantid+'/cim/BookingView?bookingNo='+bookingNo);
	  	 };
	  	 
	  	 
	  	 
});





app.controller('BLPopupCtrl', function($scope, $timeout, $stateParams,sharedProperties,toaster,
		$filter, $rootScope, $http, $location, logger, $state, ngDialog,$controller,$injector,validationService) {
	
 
	
	
	$scope.blNo = $location.search().blNo;   
	$scope.from = $location.search().from;  
	console.log("blNo123", $scope.blNo);
	
 
	
/*	 $scope.closePopup = function(){
	        ngDialog.close();
	        $state.reload();
	  }
	 
	 */
	 
	 $scope.cancel = function() {
		 if($scope.from=='bl'){
			 $state.go('app.documentation.outwardbladding.outwardlist');
		 }
		 else if($scope.from=='bldraft'){
			 $state.go('app.documentation.bldraft.bldraftlist');
		 }
		 else{
			 $state.go('app.cim.containerMovement.containerMovementList');

		 }
	 }
	
	 $scope.getBLdDetailList = function() {
			 	      $http.get($stateParams.tenantid+"/api/outWard/edit?blNo="+ $scope.blNo).success(function(response) {
	       	 console.log("BL Detail Datas",response);
	         $scope.blDetailList = response;
	        });
	    }
	    $scope.getBLdDetailList();
	   
	 
});



app.controller('BookingPopupCtrl', function($scope, $timeout, $stateParams,sharedProperties,toaster,
		$filter, $rootScope, $http, $location, logger, $state, ngDialog,$controller,$injector,validationService) {
	
 
	
	
	$scope.bookingNo = $location.search().bookingNo;   
	$scope.from = $location.search().from;  
	
 
	 $scope.cancel = function() {
		 if($scope.from=='booking'){
			 $state.go('app.salesmarketing.booking.list');
		 }
		 else{
			 $state.go('app.cim.containerMovement.containerMovementList');

		 }
	 }
	
 
	   
	    $http.post($stateParams.tenantid+ "/app/booking/bookingViewFromMovement?bookingNo="+$scope.bookingNo).success(function(data) {
			$scope.bookingData = data.bookingBean;
		
			//  pol Split 
			var polvalid = $scope.bookingData.pol.split("-");
			$scope.polcheck = polvalid[0];
			
			//...............................................
			
				 
			if(data.bookingBean.freight=='1'){
				$scope.frightTerms="Collect";
			}else if(data.bookingBean.freight=='2')
				{
				$scope.frightTerms="Prepaid";
				}else if (data.bookingBean.freight=='3'){
					$scope.frightTerms="Third Party Collect";
				}else{
					$scope.frightTerms="";
				}
			
			if(data.bookingBean.otCharge=='1'){
				$scope.otherCharge="Collect";
			}else if(data.bookingBean.otCharge=='2')
				{
				$scope.otherCharge="Prepaid";
				}else if (data.bookingBean.otCharge=='3'){
					$scope.otherCharge="Third Party Collect";
				}else{
					$scope.otherCharge="";
				}
			if(data.bookingBean.bookingType=='1'){
				$scope.bookingType="Collect";
			}else if(data.bookingBean.bookingType=='2')
				{
				$scope.bookingType="Prepaid";
				}else if (data.bookingBean.bookingType=='3'){
					$scope.bookingType="Third Party Collect";
				}else{
					$scope.bookingType="";
				}

			if($scope.CROStatus == "Completed" ){
				$scope.value = true;
			}else if($scope.CROStatus == "Pending"){
				$scope.value = false;
			}
		 
});
	    
	
});

