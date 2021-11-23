'use strict';
app.controller('exportManifestCtrl', function($templateCache,$timeout, $scope, $rootScope, $http, logger, $log, ngDialog, $modal, $location, $sce, $filter,utilsService,$stateParams) {
    $scope.inwardmanifestReport = {
    		vessel:'',
    		voyage:'',
    		pod:'',
    		fpod:'',
    		pol:''
       
    };

    
    $scope.formreset = function() {
        $scope.inwardmanifestReport = {};
    };

    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.vesselList = [];
    $scope.voyageList = [];
    $scope.portList = [];
    $scope.podList = [];
    $scope.polList = [];
    $scope.vList=[];
    

    $scope.selectall= function(selection){
      	angular.forEach($scope.rowCollection,function(value,key) {
      		debugger;
      		if( selection)
      		value.check=true;
      		else{
      			value.check=false;
      		}
  });
      }
    $scope.dropdown = function() {

        var formCode = $('#form_code_id').val();
        $http.get($stateParams.tenantid+'/app/onBoard/dropDownList').success(function(data) {
      		$scope.vesselList=data.vesselList;
      		//$scope.portList = data.portList; 
      });
       
    }
    $scope.dropdown();
    
    

	 $scope.$watch('inwardmanifestReport.voyage', function(newValue, oldValue) {
	      if(newValue!=null && newValue!=undefined && newValue != ''){
	    	  $http.post($stateParams.tenantid+ '/api/vesselArrival/getPortListByVoyage',newValue).success(function(data) {
					$scope.portList = data;
	    	  });
	      }
	    });
    
    $scope.$watch('inwardmanifestReport.vessel', function(newValue, oldValue) {
	      if(newValue!=null && newValue!=undefined && newValue != ''){
				 $http.post($stateParams.tenantid+'/app/onBoard/getVoyage?vesselCode='+newValue).success(function(data) {
		        		$scope.vList=data.voyageList;
	    	  });
	      }
	      
	    });
    
    
    
    /*
    
    $scope.$watch('inwardmanifestReport.voyage', function(newValue, oldValue) {
		if (newValue != '' && newValue != undefined) {
		$http.get( $stateParams.tenantid + '/api/vesselsailing/portList?voyage=' + $scope.inwardmanifestReport.voyage).success( function(datas) {
					$scope.podList = datas;
				})
			 $http.post($stateParams.tenantid+ '/api/vesselsailing/getPortList',newValue).success(function(data) {
					$scope.portList = data.portList;
					
	    	  })
			
				.error(function(data) {
			logger.logError("Unable to fetch");
		});
		}
	});
    */
    $scope.viewManifest = function(){
        debugger;
         if($scope.inwardmanifestReport.vessel !=''){
        if($scope.inwardmanifestReport.voyage !=''){
        	 if($scope.inwardmanifestReport.pol !=''){
            $http.post($stateParams.tenantid+'/api/inwardmanifest/viewExportManifest',$scope.inwardmanifestReport).success(function(data) {
                if(data.success){
                	$scope.rowCollection = [];
                    $scope.rowCollection = data.exportManifestList;
                    console.log("exportmanifestview",$scope.rowCollection);
                }else{
                	$scope.rowCollection = [];
                }
                
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        	 }else{
        		 logger.logError("Please select POL");
        	 }
        }else{
            if($scope.inwardmanifestReport.voyage=='')
                logger.logError("Please select Voyage");
        }
        }else{
            logger.logError("Please select  Vessel");
        }
    };
    
   
    
    $scope.printManifest = function(giRowData) {
    	
    	if(giRowData.length > 0){
    		 var blNo = '';
    	        var len = giRowData.length;
    	        for (var i = 0; i < len; i++) {
    	            var rowData = giRowData[i];
    	            if (typeof rowData.check == "undefined") {
    	                rowData["check"] = false;
    	            }
    	            if (rowData.check == true) {
    	                if(blNo==""){
    	                	blNo= rowData.blno; 
    	                }
    	                else{
    	                	blNo +=","+rowData.blno;
    	                }
    	            }
    	        }   
    	        
                 if(blNo!="" && blNo != undefined){
                	 
                	var url = $stateParams.tenantid+'/api/outWard/multiplePrint?blNo=' + blNo;
           	        var wnd = window.open(url, 'Shipping', 'height=400,width=750,top=100,left=100,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
           	        wnd.print();
    	        	
    	        }else{

    	        	logger.logError("Please select atleast one row");
    	        
    	        }
    	}else {
    		logger.logError("Manifest Report does not exists");
    	}
       
    }   
    
});

