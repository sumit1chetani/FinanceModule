
app.controller('estimateRepairAddCtrl', function($scope, $timeout, $stateParams,sharedProperties,toaster,
		$filter,validationService, $rootScope, $http, $location, logger, $state, ngDialog,$controller,$injector,utilsService,$window) {



    $scope.isDisable = false;
    $scope.isApprove = false;
	$scope.isEdit = false;
    $scope.value =false;
    $scope.repairEstimateDtl=[];
    $scope.currencyList=[];
    $scope.consigneeList=[];
    $scope.containerNoListEdit=[];

$scope.repairEstimate={
		estimateRepairNo:'',
		excelfile:'',
		excelfiletoApprove:'',
		depot:'',
		agent:'',
		currency:'USD',
		files : [],
		inspectionDate:null,
		approveRemarks:'',
		select:false,
		status,
		
		
		repairEstimateDtl : []
		
	
}


$scope.tmprepairEstimateDtl ={
	id:0,
	containerNo:'',
	containerId:'',
	pol:'',
	containerType:'',
	returnDate:'',
	estimate:'',
	consignee:'',
	blNo:'',
	line:'',
	total:'',
	remarks:'',
}

var today = new Date();
var dd = today.getDate();
var mm = today.getMonth() + 1; // January is 0!
var yyyy = today.getFullYear();
var HH = today.getHours();
var MM = today.getMinutes();
if (dd < 10) {
	dd = '0' + dd
}
if (mm < 10) {
	mm = '0' + mm
}
if (HH < 10) {
	HH = '0' + HH
}
if (MM < 10) {
	MM = '0' + MM
}

$scope.repairEstimate.inspectionDate = dd + '/' + mm + '/'
		+ yyyy+ ' ' + HH+':'+ MM;

/*$scope.addCredRow = function() {
	   
	  var tmp=angular.copy($scope.tmpRepairEstimateDtl);
		$scope.repairEstimate.repairEstimateDtl.push(tmp);

}*/
/*
$scope.addCredRow = function() {

	$scope.max = Math.max.apply(Math,
			$scope.repairEstimate.repairEstimateDtl
					.map(function(item) {
						return item.id;
					}));
	$scope.max = $scope.max + 1;
	var chargedata = {
		id : $scope.max,
		
	};

	$scope.repairEstimate.repairEstimateDtl.push(chargedata);
	var len = $scope.repairEstimate.repairEstimateDtl.length - 1;
	$timeout(function() {
		hideActivePapers($scope.max + "0", []);
	}, 1000);

	 $scope.hide=true; 

}*/

$scope.addCredRow = function() {
	   
	  var tmp=angular.copy($scope.tmprepairEstimateDtl);
		$scope.repairEstimate.repairEstimateDtl.push(tmp);

}

$scope.removeCredRow =function(){
	var count =0;
		var tmpDelList = [];
		for(var i=$scope.repairEstimate.repairEstimateDtl.length-1;i>=0;i--){
			if($scope.repairEstimate.repairEstimateDtl[i].select==true){
				count++;
				tmpDelList.push($scope.repairEstimate.repairEstimateDtl[i]);
				$scope.repairEstimate.repairEstimateDtl.splice(i, 1);
			}
		}
		if(count>0){
			logger.logSuccess('Deleted Successfully');	
		}else{
			logger.logError('Please select the row to delete!');
		}

	
}



$scope.addCredRow1 = function() {
}

//Dropdown for Selectivity
$http.post($stateParams.tenantid+'/api/eir/dropDownList').success(function(data) {
   		$scope.agent=data.listAgentList;
   	
  });

$http.get($stateParams.tenantid+ '/app/commonUtility/getCustomerList').success(function(data) {
	if(data!=null && data.length>0){
		$scope.consigneeList= data;

	}
});

$http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(datas) {
	  $scope.currencyList=datas.getcurrencylist	;
}).error(function(datas) {

});
/*$scope.$watch('repairEstimate.depot', function(newValue, oldValue) {
    if(newValue!=null && newValue!=undefined && newValue != ''){
  	  $http.post($stateParams.tenantid+ '/api/eir/getContainerNoByDepot',newValue).success(function(data) {
				$scope.containerNo = data;
  	  });
    }
  });*/



//upload

$rootScope.uploadFile = function(element) {
    $scope.repairEstimate.files = element.files[0];
}

/// Upload to Approve

$rootScope.uploadFileForApprove = function(element) {
    $scope.repairEstimate.files = element.files[0];
}

//save
$scope.save = function(RepariEstimateForm,repairEstimate) {
	if (new validationService().checkFormValidity($scope.RepariEstimateForm)) {
		
        $http.post($stateParams.tenantid+'/app/repairEstimates/estimateRepairSave',repairEstimate).success(function(data) {
            console.log("data" + data);
            if (data.success ==true) {
            	   if ($scope.repairEstimate.files != undefined) {

            		   var excelfile = $scope.repairEstimate.files;
						var fileExtension = excelfile.name;
						var fName = [];
								var frmData = new FormData();
								frmData.append("file", excelfile);
								frmData.append("estimateRepairNo", data.repairEstimateNo);
								$
										.ajax({
											type : "POST",
											url : $stateParams.tenantid+'/app/repairEstimates/saveuploadfile',
											data : frmData,
											contentType : false,
											processData : false,
                                          });
                       

                   }
                logger.logSuccess("Saved Successfully!");
                $state.go('app.eqs.estimateRepair.estimateRepairList');
            } else {
                logger.logError(data.message);
            }
        }).error(function(result) {
            console.log("data" + data);
        });
	}else {
        toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.RepariEstimateForm.$validationSummary), 555000, 'trustedHtml');
    }
    
 };
 
 
//save - Submit
 $scope.submit = function(RepariEstimateForm,repairEstimate) {
 	if (new validationService().checkFormValidity($scope.RepariEstimateForm)) {
 		
         $http.post($stateParams.tenantid+'/app/repairEstimates/estimateRepairSubmit',repairEstimate).success(function(data) {
             console.log("data" + data);
             if (data.success ==true) {
             	   if ($scope.repairEstimate.files != undefined) {

             		   var excelfile = $scope.repairEstimate.files;
 						var fileExtension = excelfile.name;
 						var fName = [];
 								var frmData = new FormData();
 								frmData.append("file", excelfile);
 								frmData.append("estimateRepairNo", data.repairEstimateNo);
 								$
 										.ajax({
 											type : "POST",
 											url : $stateParams.tenantid+'/app/repairEstimates/saveuploadfile',
 											data : frmData,
 											contentType : false,
 											processData : false,
                                           });
                        

                    }
                 logger.logSuccess("Submitted Successfully!");
                 $state.go('app.eqs.estimateRepair.estimateRepairList');
             } else {
                 logger.logError(data.message);
             }
         }).error(function(result) {
             console.log("data" + data);
         });
 	}else {
         toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.RepariEstimateForm.$validationSummary), 555000, 'trustedHtml');
     }
     
  };
  
	//Approval
	$scope.approveEstimate = function(approveEstimate) {	
		$scope.repairEstimateNew ={
				estimateRepairNo :'',
				approveRemarks :'',
		}
		$rootScope.repairEstimate= approveEstimate;
		$rootScope.repairEstimate.estimateRepairNo= approveEstimate.estimateRepairNo;
		$rootScope.repairEstimate.approveRemarks ='';
	        		
       ngDialog.open({
           scope : $scope,
           template : 'views/eqs/estimateRepair/estimateApprovePopup',
           controller : $controller('estimateApprovePopupCtrl', {
               $stateParams :$stateParams,
               $scope : $scope, 
               $rootScope :$rootScope, 
               $http:$http, 
               $location:$location,
               logger:logger, 
               utilsService:utilsService, 
               $state:$state, 
               $window:$window,
               preCloseCallback : $scope.getList
           }),
           showClose : false,
           closeByDocument : false,
           closeByEscape : false 
       });
		
	};
 

 	
 	
 	
 
 
//Reject
 $scope.approveReject = function(repairEstimate){

 		$http.post($stateParams.tenantid+'/app/repairEstimates/estimateRepairReject',repairEstimate).success(function(datas) {
 			if(datas.success){
 		    logger.logSuccess(datas.message);
 		    $state.go('app.eqs.estimateRepair.estimateRepairList',{tenantid:$stateParams.tenantid});
 			}else{
 				logger.logError(datas.message);
 			}
 			 
 		
 	
 	}).error(function(datas) {

 	});
 	
 	
 }
 
//Fetch Values
 $scope.isEdit = false;
 
 var estimateRepairNo = $location.search().estimateRepairNo;

 if (estimateRepairNo == undefined) {

 } else {
	 $scope.isDisable = true;
     $http.get($stateParams.tenantid+'/app/repairEstimates/estimateRepairEdit?estimateRepairNo=' +estimateRepairNo).success(function(result) {

         if (result.isEdit == false) {
             logger.logError("Please Try Again");
         } else {

        	 $scope.repairEstimate=result;
         	$scope.isEdit=true;
         	$scope.value =result.value;
         }
     }).error(function(data) {
         console.log("data" + data);
     });
 }
 
 
//Fetch Values for View
 $scope.isEdit = false;
 var estimateRepairNo = $location.search().estimateRepairNo;
 if (estimateRepairNo == undefined) {

 } else {
	 $scope.isDisable = true;
	 $scope.isEdit=true;
     $http.get($stateParams.tenantid+'/app/repairEstimates/estimateRepairEdit?estimateRepairNo=' +estimateRepairNo).success(function(result) {

         if (result.isEdit == false) {
             logger.logError("Please Try Again");
         } else {
        	
        	 $scope.repairEstimate=result;         	
         	$scope.value =result.value;
         }
     }).error(function(data) {
         console.log("data" + data);
     });
 }
 
 // Update
 var status = $location.search().status;
$scope.repairEstimate.status =status;
 $scope.update = function(RepariEstimateForm,repairEstimate) {
     if (new validationService().checkFormValidity($scope.RepariEstimateForm)) {
          
         $http.post($stateParams.tenantid+'/app/repairEstimates/estimateRepairUpdate',repairEstimate).success(function(result) {
             if (result.success ==true) {
            	 if ($scope.repairEstimate.files != undefined) {

          		   var excelfile = $scope.repairEstimate.files;
						var fileExtension = excelfile.name;
						var fName = [];
								var frmData = new FormData();
								frmData.append("file", excelfile);
								frmData.append("estimateRepairNo", result.repairEstimateNo);
								$
										.ajax({
											type : "POST",
											url : $stateParams.tenantid+'/app/repairEstimates/saveuploadfile',
											data : frmData,
											contentType : false,
											processData : false,
                                        });
                     

                 }
                 logger.logSuccess("Updated Successfully!");
                 $state.go('app.eqs.estimateRepair.estimateRepairList',{tenantid:$stateParams.tenantid});
             } else {
                 logger.logError(result.message);
             }
         }).error(function(data) {
             console.log("data" + data);
         });

     } else {
         toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.RepariEstimateForm.$validationSummary), 555000, 'trustedHtml');
     }
 };
 
 //Update - Submit
 $scope.submit1 = function(RepariEstimateForm,repairEstimate) {
     if (new validationService().checkFormValidity($scope.RepariEstimateForm)) {
          
         $http.post($stateParams.tenantid+'/app/repairEstimates/estimateRepairSubmit1',repairEstimate).success(function(result) {
             if (result.success ==true) {
            	 if ($scope.repairEstimate.files != undefined) {

          		   var excelfile = $scope.repairEstimate.files;
						var fileExtension = excelfile.name;
						var fName = [];
								var frmData = new FormData();
								frmData.append("file", excelfile);
								frmData.append("estimateRepairNo", result.repairEstimateNo);
								$
										.ajax({
											type : "POST",
											url : $stateParams.tenantid+'/app/repairEstimates/saveuploadfile',
											data : frmData,
											contentType : false,
											processData : false,
                                        });
                     

                 }
                 logger.logSuccess("Submitted Successfully!");
                 $state.go('app.eqs.estimateRepair.estimateRepairList',{tenantid:$stateParams.tenantid});
             } else {
                 logger.logError(result.message);
             }
         }).error(function(data) {
             console.log("data" + data);
         });

     } else {
         toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.RepariEstimateForm.$validationSummary), 555000, 'trustedHtml');
     }
 };
//   
     
     $http.post($stateParams.tenantid+'/api/eir/getPortListByAgent').success(function(data) {
         
    		$scope.depot=data;
    		
    });
     
     
/*     $http.post($stateParams.tenantid+'/api/eir/getContainerNumber').success(function(data) {
         
 		$scope.containerNo=data;
 		
 });*/
     
    
    	 $scope.$watch('repairEstimate.depot', function(newValue, oldValue) {
        	 
   	      if(newValue!=null && newValue!=undefined && newValue != ''){
   	    	 if( $scope.isEdit ==false ){
   	    	  $http.post($stateParams.tenantid+ '/api/eir/getContainerNoByDepot',newValue).success(function(data) {
   					$scope.containerNo = data;
   	    	  });
   	    	 }
   	      }
   	    });
     
    
     
    
    	   $scope.$watch('repairEstimate.depot', function(newValue, oldValue) {
    	    	 
    		      if(newValue!=null && newValue!=undefined && newValue != ''){
    		    	  if($scope.isEdit ==true ){
    		    	  $http.post($stateParams.tenantid+ '/api/eir/getContainerNoByDepotFOREdit',newValue).success(function(data) {
    						$scope.containerNoListEdit = data;
    		    	  });
    		      }
    		      }
    		    });
    	   
    
    	   
     
  
    	   /*var tt = $location.path().split("/")[3]||"View";
    			if(tt == 'View'){
    				 $http.post($stateParams.tenantid+'/api/report/containerNo').success(function(data) {
    				      	
    				  		$scope.containerNo=data;
    				  		        		
    				  });
    			}
    	
    			 var tt = $location.path().split("/")[3]||"Approval";
     			if(tt == 'Approval'){
     				 $http.post($stateParams.tenantid+'/api/report/containerNo').success(function(data) {
     				      	
     				  		$scope.containerNoListEdit=data;
     				  		        		
     				  });
     			}*/
     
     /*$scope.$watch('eir.containerNo', function(newValue,
    			oldValue) {

    		if (newValue != '' && newValue != undefined) {

    			$http.get(
    					$stateParams.tenantid
    							+ '/api/eir/containerType?containerNo='
    							+ $scope.eir.containerNo).success(
    					function(datas) {
    						$scope.eir.containerType = datas.containerType;
    						$scope.eir.returnDate = datas.returnDate;

    						
    						
    						

    					}).error(function(data) {
    				logger.logError("Unable to fetch");
    			});

    		}
    	});*/

     $scope.downloadFile = function() {
			$("#tbFileExport").bind('click', function() {
			});
			$('#tbFileExport').simulateClick('click');
		}

		$.fn.simulateClick = function() {
			return this.each(function() {
				if ('createEvent' in document) {
					var doc = this.ownerDocument, evt = doc
							.createEvent('MouseEvents');
					evt.initMouseEvent('click', true, true,
							doc.defaultView, 1, 0, 0, 0, 0, false,
							false, false, false, 0, null);
					this.dispatchEvent(evt);
				} else {
					this.click();
				}
			});
			
			
		}
		
		
		$scope.downloadFileApprove = function() {
			$("#FileExportApprove").bind('click', function() {
			});
			$('#FileExportApprove').simulateClick('click');
		}

		$.fn.simulateClick = function() {
			return this.each(function() {
				if ('createEvent' in document) {
					var doc = this.ownerDocument, evt = doc
							.createEvent('MouseEvents');
					evt.initMouseEvent('click', true, true,
							doc.defaultView, 1, 0, 0, 0, 0, false,
							false, false, false, 0, null);
					this.dispatchEvent(evt);
				} else {
					this.click();
				}
			});
			
			
		}
     $('#inspectionDate').datetimepicker({
		 format : 'DD/MM/YYYY HH:mm'
		 })
     
$scope.cancel = function() {
    $state.go('app.eqs.estimateRepair.estimateRepairList',{tenantid:$stateParams.tenantid});
};


$scope.uploadContainerExcel = function(element) {
	debugger
	console.log("excel file");
	$scope.excelfile = element.files[0];
	console.log($scope.excelfile);

}
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
						url : $stateParams.tenantid+'/app/repairEstimates/uploadfileforContainerDetail',
						data : frmData,
						contentType : false,
						processData : false,
						success : function(response) {
							// loader.complete();
							if (response.success == true) {
								for(var i=0; i < response.containerUploadList.length;i++){
									$scope.repairEstimate.repairEstimateDtl.push(response.containerUploadList[i]);
								}
								$('#buttontemp').simulateClick('click');
								//	$scope.containerOnHire.containerDtl=angular.copy(response.containerDtl);
								if(response.containerUploadList.length > 0 ){
										logger.logSuccess("Container Details Uploaded Successfully!");
								}else{
									logger.logError("Sorry Error Occured in Upload");
								}
								$scope.closeUpload();
							} else if (response.success == false) {

								for (var i = 0; i < response.errorList.length; i++) {
									logger
											.logError(response.errorList[i]);
									$scope.closeUpload();
									
								}
							} else if (response.errorList.length > 0) {

							} else {
								logger
										.logError("Sorry Error Occured");
								$scope.closeUpload();
								$scope.getMemberList();
							}
						}
					});
		}
	}
}
$scope.downloadFileSampleforUpload = function() {
	$("#REContainerDetail").bind('click', function() {
	});
	$('#REContainerDetail').simulateClick('click');
}

$.fn.simulateClick = function() {
	return this.each(function() {
		if ('createEvent' in document) {
			var doc = this.ownerDocument, evt = doc
					.createEvent('MouseEvents');
			evt.initMouseEvent('click', true, true,
					doc.defaultView, 1, 0, 0, 0, 0, false,
					false, false, false, 0, null);
			this.dispatchEvent(evt);
		} else {
			this.click();
		}
	});
	
	
}
 
 $scope.closeUpload=function(){
        ngDialog.close();
    }
 
$scope.fileUpload =function(){
	if($scope.repairEstimate.depot !=null && $scope.repairEstimate.depot !='' && $scope.repairEstimate.depot != undefined){
		
	
	 ngDialog.open({
            template : 'containerUploadModel',
            scope :$scope
        });
	}else{
		logger.logError("Please select the Header Depot before Upload File");
	}
	} 



$scope.reset = function(estimateRepairNo) {
	
	
if (estimateRepairNo == undefined) {

	$scope.repairEstimate={
			estimateRepairNo:'',
			excelfile:'',
			depot:'',
			agent:'',
			currency:'USD',
			files : [],
			inspectionDate:null,
			
			repairEstimateDtl : []
			
		
	}
} else {}

}




	
});


app.controller('containerDtlCtrl', function($scope, $timeout, $stateParams,sharedProperties,toaster,
		$filter, $rootScope, $http, $location, logger, $state, ngDialog,$controller,$injector,utilsService,$window) {

	 var tt = $location.path().split("/")[5]||"Edit";
			if(tt == 'Edit'){
	
		
	
	$scope.$watch('repairEstimate.repairEstimateDtl[trIndex].containerNo', function(newValue,
			oldValue) {
		var index = $scope.trIndex;
		if (newValue != '' && newValue != undefined) {

			$http.post($stateParams.tenantid +'/app/repairEstimates/containerType',newValue).success(function(datas) {
				$scope.repairEstimate.repairEstimateDtl[index].containerType = datas.containerType;
				$scope.repairEstimate.repairEstimateDtl[index].returnDate = datas.returnDate;
				$scope.repairEstimate.repairEstimateDtl[index].depot = datas.depot;
				$scope.repairEstimate.repairEstimateDtl[index].blNo = datas.blNo;
				$scope.repairEstimate.repairEstimateDtl[index].pol = datas.depot;
				
			}).error(function(datas) {
				logger.logError("Unable to fetch");
			});

		}
	});
}
	$scope.changedValue= function(amt,index){
		amt[index].total =parseFloat(amt[index].consignee) + parseFloat(amt[index].line);   

		}
	
	
	
	
	
/*	$scope.$watch('repairEstimate.repairEstimateDtl[trIndex].containerNo',
			function(newValue, oldValue) {
		
		var index = $scope.trIndex;

				if (newValue != ''&& newValue != undefined) {
					
					angular.forEach($scope.repairEstimate.repairEstimateDtl, function(
							value, key) {
						
						if(index!=value.id){
						
						if(newValue==value.containerNo){
							
							
							$scope.repairEstimate.repairEstimateDtl[index].containerNo='';
							logger.logError("Container No should not be same");	
							
							
						}
						}
					});

				}
			});*/

	

	
	
	
	
	
});




app.controller('estimateApprovePopupCtrl', function($scope, $timeout, $stateParams,sharedProperties,toaster,
		$filter, $rootScope, $http, $location, logger, $state, ngDialog,$controller,$injector,utilsService,$window) {
    debugger;
     
        
  //  $scope.repairEstimateNew = $rootScope.repairEstimate;  
  //  $scope.repairEstimateNew.approveRemarks= '';
	$rootScope.repairEstimate= $rootScope.approveEstimate;

        $scope.cancel = function() {
            ngDialog.close();    
        };
        
       
        $scope.approve = function(repairEstimate){
        	
        	   if ($scope.repairEstimate.files != undefined) {

         		   var excelfile = $scope.repairEstimate.files;
						var fileExtension = excelfile.name;
						var fName = [];
								var frmData = new FormData();
								frmData.append("file", excelfile);
								frmData.append("estimateRepairNo", repairEstimate.estimateRepairNo);
								$
										.ajax({
											type : "POST",
											url : $stateParams.tenantid+'/app/repairEstimates/saveuploadfileToApprove',
											data : frmData,
											contentType : false,
											processData : false,
                                       });
                    

                }
        
    	$http.post($stateParams.tenantid+'/app/repairEstimates/estimateRepairApprove',repairEstimate).success(function(datas) {
 			if(datas.success){
 		   logger.logSuccess(datas.message);
 		   ngDialog.close(); 
 		    $state.go('app.eqs.estimateRepair.estimateRepairList',{tenantid:$stateParams.tenantid});
 			}else{
 				logger.logError(datas.message);
 			}
 			 
 		
 	
 	}).error(function(datas) {

 	});
        }
      
});
