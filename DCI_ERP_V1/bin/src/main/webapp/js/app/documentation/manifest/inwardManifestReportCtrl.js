'use strict';
app.controller('inwardmanifestCtrl', function($templateCache,$timeout, $scope, $rootScope, $http, logger, $log, ngDialog, $modal, $location, $sce, $filter,utilsService,$stateParams) {
    $scope.inwardmanifestReport = {
    		vessel:'',
    		voyage:'',
    		pod:'',
    		fpod:''
       
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
   

    $scope.getDropdownvalue = function() {
        
        $http.get($stateParams.tenantid+'/api/vesselsailing/vessellist').success(function(datas) {
            $scope.vesselList = datas;
        }).error(function(datas) {
        });
        
        
       /* $http.get($stateParams.tenantid+'/api/vesselsailing/getPort').success(function(datas) {
            $scope.portList = datas;
        }).error(function(datas) {
        });
*/
    }
    $scope.getDropdownvalue();
  
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
    
    $scope.$watch('inwardmanifestReport.vessel', function(newValue,
			oldValue) {

		if (newValue != '' && newValue != undefined) {

			$http.get(
					$stateParams.tenantid
							+ '/api/vesselsailing/voyagelist?vessel='
							+ $scope.inwardmanifestReport.vessel).success(
					function(datas) {
						$scope.voyageList = datas;

					}).error(function(data) {
				logger.logError("Unable to fetch");
			});

		}
	});
    
    $scope.$watch('inwardmanifestReport.voyage', function(newValue, oldValue) {
		if (newValue != '' && newValue != undefined) {
		$http.get( $stateParams.tenantid + '/api/vesselsailing/portList?voyage=' + $scope.inwardmanifestReport.voyage).success( function(datas) {
					$scope.podList = datas;
				})
				.error(function(data) {
			logger.logError("Unable to fetch");
		});
		}
	});
    
    
    

	 $scope.$watch('inwardmanifestReport.voyage', function(newValue, oldValue) {
	      if(newValue!=null && newValue!=undefined && newValue != ''){
	    	  $http.post($stateParams.tenantid+ '/api/vesselArrival/getPortListByVoyage',newValue).success(function(data) {
					$scope.portList = data;
	    	  });
	      }
	    });
    
    
    
    
    
    
    
    
    
    
    $scope.viewManifest = function(){
        debugger;
         if($scope.inwardmanifestReport.vessel !=''){
        if($scope.inwardmanifestReport.voyage !=''){
            $http.post($stateParams.tenantid+'/api/inwardmanifest/viewManifest',$scope.inwardmanifestReport).success(function(data) {
                if(data.success){
                	$scope.rowCollection = [];
                    $scope.rowCollection = data.lInwardManifestList;
                    console.log($scope.rowCollection);
                }else{
                	$scope.rowCollection = [];
                }
                
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
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
    
    $scope.Export = function(giRowData,voyage) {
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
   	                } else{
   	                	blNo = "'"+blNo+"','"+rowData.blno+"'";
   	                }
   	            }
   	        }  
   	        
   	        if(blNo!="" && blNo != undefined){ 
   	        	$http.post($stateParams.tenantid+'/api/inwardmanifest/generateExcelReport?blNo=' + blNo+'&voyage='+voyage).success(function(data) {
   	            console.log(data);
   	            if (data.success == true) {
   	                logger.logSuccess("Report Exported successfully!");
   	                $scope.filePath="filePath/"+data.fileName;
   	                $scope.fileName=data.fileName;
   	                $timeout(function(){ $('#tbExcelExport').simulateClick('click')},100);
   	                 
   	            }
   	       }).error(function(data) {
   	            logger.logError("Error Please Try Again");
   	        }); 
   	        }else{
   	        
   	           	logger.logError("Please select atleast one row");
   	        
   	        }
   	}else {
   		logger.logError("Manifest Report does not exists");
   	}
    	
         
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

