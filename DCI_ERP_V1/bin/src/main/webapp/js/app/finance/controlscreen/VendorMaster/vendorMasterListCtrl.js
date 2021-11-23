'use strict';

app.controller('vendorMasterController', function($scope, $rootScope,ngDialog, $http, $location, logger,
        utilsService,$state,sharedProperties,$window,validationService,toaster,$stateParams) {
	    $scope.dataLoopCount = 0;
	    $scope.offsetCount = 0;
	    $scope.limitCount = 1000;
	    $scope.updatedData = [];
	    $scope.rowCollection = [];
	    $scope.displayedCollection = [];
	    $scope.itemsByPage = 10;
	   
    $scope.add = function() {
    	 $state.go('app.finance.controlscreen.vendormasteradd',{tenantid:$stateParams.tenantid});
    };
    $scope.getList=function(){
    	var name = 'mascustomer';
    $http.get($stateParams.tenantid+'/app/master/servicepartnerNew/list?name='+name).success(function(datas) {
        console.log(datas);
        $scope.rowCollection = datas.lServicePartnerBean;
    	
        }).error(function(datas) {
    });
    };
    $scope.getList();
    $scope.servicePartner = {
            
    		servicePartnerCode:'',
    		servicePartnerName:'',
    		branch:'',
    		servicePartnerLedgerName:'',
    		creditDaysOffered:'',
    		active:'',
    		city:'',
    		region:'',
            address:'',
            country:'',
    		zipCode:'',
    		personToContact:'',
	    	designation:'',	 
	    	emailId:'',
	    	landLineNo:'',	
	    	mobileNo:'',
	    	skypeId:'',	 
	    	webSite:'',
	    	servicePartnerDescription:'',
    		 pANNo:'',
    	    partnerClassification:'',
        	 gSTNStateCode:'',
        	 gSTNStateNo:'',
        	 exemptionUnder:''

         };
      $scope.deleteRow = function(rowid) {
        	
            ngDialog.openConfirm().then(function() {
                var myURL = $stateParams.tenantid+'/app/master/servicepartnerNew/delete?servicePartnerId='+rowid;
                $http({
                    method : 'post',
                    url : myURL,
                    data : rowid,
                }).success(function(data) {
                    if (data.success == true) {                    
                        logger.logSuccess("Deleted Successfully");
                        $state.reload();
                    } else {
                        logger.logError("Error in deleting Record!");
                    }
                }).error(function(data) {
                    logger.logSuccess("Error in Delete!");
                });
            });

        };
     
        $scope.getList();
    $scope.editRow = function(rowid) {    	
    	$location.url($stateParams.tenantid+'/controlscreen/vendorMaster/edit?rowid='+rowid);       
     }
    
    $scope.view = function(rowid) {
    	$location.url($stateParams.tenantid+'/controlscreen/vendorMasterView?rowid='+rowid); 
     }

  /*  // excel export
    $scope.excel = function() {
console.log($scope.rowCollection);


        $http.get($stateParams.tenantid+"/app/master/servicepartnerNew/generateExcel").success(function(response) {
        	console.log(response);
            $('#exportXl').append('<a id="tbExcelExport" stype="display:none" href="filePath/SevicePartner.xls" download="SevicePartner.xls"></a>');
            $("#tbExcelExport").bind('click', function() {
            });
            $('#tbExcelExport').simulateClick('click');

        }).error(function(result) {
            logger.logError("Error Please Try Again");
        });
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

    }
*/    
    
    
    //Excel Export	
 	 $scope.exportExcel = function(){
 		 
 		/*if($scope.bookingReport.salesPersonId!='' && $scope.bookingReport.salesPersonId!=null){*/
 	   	 $http.post($stateParams.tenantid+'/app/master/servicepartnerNew/ExportExcel', $scope.bookingReport).success(function(response) {

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
 							url : $stateParams.tenantid+'/app/master/servicepartnerNew/uploadfile',
 							data : frmData,
 							contentType : false,
 							processData : false,
 							success : function(response) {
 								// loader.complete();
 								$scope.closeUpload();
 								if (response.success1 == true) {
 								/*	for(var i=0; i < response.containerDtl.length;i++){
 										$scope.gateoutin.gateoutinDtl.push(response.containerDtl[i]);
 									}*/
 									
 								//	$scope.gateoutin.gateoutinDtl=response.containerDtl;
 								//	 $scope.isUploadDiv = true;
 									$('#loadclick').simulateClick('click');
 									logger.logSuccess("Uploaded Successfully!");
 									$state.reload();
 									
 									//$scope.gateoutin.gateoutinDtl=angular.copy(response.containerDtl);
 									
 								} else if (response.success1 == false) {

 									//for (var i = 0; i < response.errorList.length; i++) {
 										logger
 												.logError(response.message);
 										//$scope.closeUpload();
 										 $scope.isUploadDiv = false;
 										
 									//}
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


 	  
 
    $scope.createLogin=function(rowid){
    $http.post($stateParams.tenantid+'/app/master/servicepartnerNew/createLogin?rowid='+rowid).success(function(data) {
    	if(data.success){
    		logger.logSuccess('Login Created Successfully');
    		$state.reload();
    	}else{
    		logger.logError(data.message);
    	}
    	
    });
    
    }
    
    
});


