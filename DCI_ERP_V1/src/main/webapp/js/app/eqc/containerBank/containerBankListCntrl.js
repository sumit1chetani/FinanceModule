'use strict';

app.controller('containerBankListCtrl', function($scope, $rootScope, $http, $location, logger, utilsService, ngDialog, $state,sharedProperties,$window,$stateParams) {
	 $scope.dataLoopCount = 0;
	    $scope.offsetCount = 0;
	    $scope.limitCount = 1000;
	    $scope.updatedData = [];
	    $scope.rowCollection = [];
	    $scope.displayedCollection = [];
	    $scope.itemsByPage = 10;
  
    $scope.add = function() {
    	 $state.go('app.eqc.containerBank.add',{tenantid:$stateParams.tenantid});
    };
    
	$scope.bookingReport = {			
			cntrType:'',
			containerNo:'',
			tareweight:'',
			grossweight:'',
			payLoad:'',
			service:'',
			port:'',
			soc:false
    };
	
	
	
	
	   $scope.depotMove = function() {
   	 $state.go('app.eqc.containerBank.depotBulk',{tenantid:$stateParams.tenantid});
   };
	

    
    $scope.getList=function(){
    $http.get($stateParams.tenantid+'/api/containerBank/list').success(function(datas) {
        console.log(datas);
        $scope.rowCollection = datas;
    	
        }).error(function(datas) {
    });
    };
    $scope.getList();
    
    $scope.deleteRow = function(rowid) {
        	
            ngDialog.openConfirm().then(function() {
                var url = $stateParams.tenantid+'/api/containerBank/delete?commodityCode=' + rowid;
                 $http.get(url).success(function(data) {
                    if (data == true) {                    
                        logger.logSuccess("Deleted Successfully");
                        $state.reload();
                    } else {
                        logger.logError("Error in Delete");
                    }
                }).error(function(data) {
                    logger.logError("Error in deleting Record!");
                });
            });

        };
        $scope.view = function(commodityCode) {
        	$location.url($stateParams.tenantid+'/eqc/containerBank/view?commodityCode='+commodityCode); 
         }
        
  //Redirecting Page For Edit Functionality
$scope.editRow = function(rowid) {   
    	
    	$location.url($stateParams.tenantid+'/eqc/containerBank/edit?commodityCode='+rowid);    
     }
$scope.fileUpload =function(){
	
	 ngDialog.open({
           template : 'fileGenModal',
           scope :$scope
       });
	}
$scope.downloadFile=function(){
    $("#tbPdfExport").bind('click', function() {
    });
    $('#tbPdfExport').simulateClick('click');
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
$scope.uploadContainerExcel = function(element) {
	debugger
	console.log("excel file");
	$scope.excelfile = element.files[0];
	console.log($scope.excelfile);

}
$rootScope.closeUpload = function() {
	ngDialog.close();
};
$scope.uploadContainer = function() {
	// loader.start();
	var excelfile = $scope.excelfile;
	var fileExtension = excelfile.name;
	var fName = [];
	fName = fileExtension.split(".");
	for (var i = 0; i < fName.length; i++) {
		if (fName[i] == "xls" || fName[i] == "xlsx") {
			var frmData = new FormData();
			frmData.append("file", excelfile);
			$
					.ajax({
						type : "POST",
						url : $stateParams.tenantid+'/api/containerBank/uploadfile',
						data : frmData,
						contentType : false,
						processData : false,
						success : function(response) {
							// loader.complete();
							$scope.closeUpload();
							if (response.success == true) {
							/*	for(var i=0; i < response.containerDtl.length;i++){
									$scope.gateoutin.gateoutinDtl.push(response.containerDtl[i]);
								}*/
								
							//	$scope.gateoutin.gateoutinDtl=response.containerDtl;
							//	 $scope.isUploadDiv = true;
								$('#loadclick').simulateClick('click');
								logger.logSuccess("Uploaded Successfully!");
								$state.reload();
								
								//$scope.gateoutin.gateoutinDtl=angular.copy(response.containerDtl);
								
							} else if (response.success == false) {

								for (var i = 0; i < response.errorList.length; i++) {
									logger
											.logError(response.errorList[i]);
									$scope.closeUpload();
									 $scope.isUploadDiv = false;
									
								}
							} else if (response.errorList.length > 0) {

							} else {
								logger
										.logError("Sorry Error Occured");
								$scope.closeUpload();
								 $scope.isUploadDiv = false;
							}
						}
					});
		}
	}
}

//Excel Export	
	 $scope.exportExcel = function(){
		 
		/*if($scope.bookingReport.salesPersonId!='' && $scope.bookingReport.salesPersonId!=null){*/
	   	 $http.post($stateParams.tenantid+'/api/containerBank/ExportExcel', $scope.bookingReport).success(function(response) {

	                if(response){
	                    debugger;
	                    $("#bookingreport").bind('click', function() {
	                    });
	                    $('#bookingreport').simulateClick('click');
	                    logger.logSuccess("Exported successfully!");
	                }else{
	                    logger.logError("Failed to export");
	                }
	                
	            }).error(function(response) {
	                logger.logError("Error Please Try Again");
	            });
		/*}else{
		  logger.logError("Pls select Sales Person");
	  }*/
	    
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
	  
	  
	//print

  
});


