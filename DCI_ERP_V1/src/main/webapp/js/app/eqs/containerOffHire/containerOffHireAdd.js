
app.controller('containerOffHireAddCtrl', function($scope, $rootScope, $http, $location, logger, ngDialog,
        utilsService,$state,sharedProperties,$window,$stateParams,toaster,validationService) {

	$scope.containerDtl=[];
	$scope.cntrTypeList = [];
	$scope.cntrNoList = [];


    $scope.isEdit = false;

$scope.containerOffHire={
		offhireRefno:'',
		agent:'',
		fileupload:'',
		agreementParty:'',
		port:'',
		createdDate:'',
		containerDtl : []
	
}

//now date 
var today = new Date();
var dd = today.getDate();
var mm = today.getMonth() + 1; // January is 0!
var yyyy = today.getFullYear();
if (dd < 10) {
	dd = '0' + dd
}
if (mm < 10) {
	mm = '0' + mm
}

$scope.containerOffHire.createdDate = dd + '/' + mm + '/'
		+ yyyy;


var today = new Date();
var dd = today.getDate();
var mm = today.getMonth() + 1;

var yyyy = today.getFullYear();
if (dd < 10) {
	dd = '0' + dd;
}
if (mm < 10) {
	mm = '0' + mm;
}
var today = dd + '/' + mm + '/' + yyyy;
$scope.containerOffHire.createdDate = today;




$scope.tempContainerDtl={
		containerType : '',
		containerNo : '',
		 onhireRefno : '',
		 hirePort : '',
		 offhireDate : null,
		 select:false
		
}
$scope.addCredRow = function() {
	   
	  var tmp=angular.copy($scope.tempContainerDtl);
		$scope.containerOffHire.containerDtl.push(tmp);

}
$scope.addCredRow1= function(){
	
}





$scope.removeCredRow =function(){
	ngDialog.openConfirm().then(function() {
		var tmpDelList = [];
		for(var i=$scope.containerOffHire.containerDtl.length-1;i>=0;i--){
			if($scope.containerOffHire.containerDtl[i].select==true){
				tmpDelList.push($scope.containerOffHire.containerDtl[i]);
				$scope.containerOffHire.containerDtl.splice(i, 1);
			}
		}
	})
}

$http.get($stateParams.tenantid+ '/api/offhirereleaseorder/getOffHireRefNo').success(function(data) {
	console.log(data);
$scope.containerOffHire.offhireRefno = data.offhireRefno;
});

//save
$scope.save = function(containerOffHireForm,containerOffHire) {
    if (new validationService().checkFormValidity($scope.containerOffHireForm)) {
    	
    	
        $http.post($stateParams.tenantid+'/api/offhirereleaseorder/save',containerOffHire).success(function(data) {
            console.log("data" + data);
            if (data.isSuccess) {
                logger.logSuccess("Saved successfully!");
                $state.go('app.eqs.containerOffHire.list');
            } else {
                logger.logError("Error!!");
            }
        }).error(function(result) {
            console.log("data" + data);
        
    });
    	} else {
        toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.containerOffHireForm.$validationSummary), 555000, 'trustedHtml');
    }
    
 };
 
//Fetch Values
 $scope.nofilupload = true;

 
 $scope.isEdit = false;
 var offhireRefno = $location.search().offhireRefno;
 if (offhireRefno == undefined) {

 } else {
     $http.get($stateParams.tenantid+'/api/offhirereleaseorder/edit?offhireRefno=' +offhireRefno).success(function(result) {

         if (result.isEdit == false) {
             logger.logError("Please Try Again");

         } else {

        	 $scope.containerOffHire=result;
         	$scope.isEdit=true;
         	 $scope.nofilupload = false;


         	for(var i=0; i < $scope.containerOffHire.containerDtl.length;i++){
         		$scope.containerOffHire.containerDtl[i].containerNo=result.containerDtl[i].containerNo.toString();
         	}
        	
         }
     }).error(function(data) {
         console.log("data" + data);
     });
 }
 
 
 
 $('#createdDate').datetimepicker({
	 format : 'DD/MM/YYYY HH:mm'
	 })

 $scope.update = function(containerOffHireForm, containerOffHire) {
     if (new validationService().checkFormValidity($scope.containerOffHireForm)) {
          $scope.containerOffHire.offhireRefno = $location.search().offhireRefno;
          
          
          
          
         $http.post($stateParams.tenantid+'/api/offhirereleaseorder/update', $scope.containerOffHire).success(function(result) {
             if (result) {
                 logger.logSuccess("Updated successfully!");
                 $state.go('app.eqs.containerOffHire.list',{tenantid:$stateParams.tenantid});
             } else {
                 logger.logError("Error in update!");
             }
         }).error(function(data) {
             console.log("data" + data);
        
          	
            });

     } else {
         toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.containerOffHireForm.$validationSummary), 555000, 'trustedHtml');
     }
 };
     //Dropdown for Selectivity
     $http.post($stateParams.tenantid+'/api/offhirereleaseorder/dropDownList').success(function(data) {
      
       		$scope.agreementParty=data.listagreementPartyList;
       		$scope.agent=data.listAgentList;
       		$scope.port=data.listPortList;
//       		$scope.containerNolist=data.listcontainerNoList;

//       		$scope.containerType=data.listContainerTypeList;
       		$scope.onhireRefno=data.listOnhireRefNoList;
       	
       });
     //watch collection for container type drp down.
     $scope.isfile = false;

     $scope.$watchCollection('[containerOffHire.port]', function(newValue, oldValue) {
		 
//    	 $scope.containerOffHire.containerDtl.onhireRefno = '';
//    	 $scope.containerOffHire.containerDtl.hirePort = '';
//    	 $scope.containerOffHire.containerDtl.onhireRefno = '';
    	 
    	 if($scope.containerOffHire.port != null && $scope.containerOffHire.port != '' && $scope.containerOffHire.port != undefined	){
    	     $scope.isfile = true;

			 $http.post($stateParams.tenantid+ '/api/offhirereleaseorder/cntrType?port='+$scope.containerOffHire.port).success(function(data) {
					$scope.cntrTypeList = data.containerTypeList;
	    	  });
		 }else{
		     $scope.isfile = false;

			 
		 }
	 });
     
     
     //container No drop down
     app.controller('offhiretableCtrl', function($scope, $http, $filter, logger,$stateParams) {
    	 
    	 
    	 
    	 
    //check watch 
    	    

         $scope.$watchCollection('[containerOffHire.containerDtl[trIndex].containerType,containerOffHire.agreementParty]',function(newValue, oldValue) {

    					if (newValue != ''&& newValue != undefined) {
    						$scope.containerOffHire.containerDtl[$scope.trIndex].onhireRefno='';
    						$scope.containerOffHire.containerDtl[$scope.trIndex].offhireDate='';
    						
    				
    						$scope.trIndex;
    						$http.get($stateParams.tenantid+ '/api/offhirereleaseorder/containerNolist?containerType='
    												+ $scope.containerOffHire.containerDtl[$scope.trIndex].containerType +'&agreementParty='+$scope.containerOffHire.agreementParty)
    								.success(
    										function(data) {
    											$scope.cntrNoList = data.containerNolist;
    											

    										})
    								.error(
    										function(data) {
    											logger.logError("Unable to fetch");
    										});

    					}
    				});
         
         
         

     /*$scope.$watch('containerOffHire.containerDtl[trIndex].containerType',function(newValue, oldValue) {

					if (newValue != ''&& newValue != undefined) {

						$http.get($stateParams.tenantid+ '/api/offhirereleaseorder/containerNolist?containerType='
												+ newValue)
								.success(
										function(data) {
											$scope.cntrNoList = data.containerNolist;
//											$scope.containerOnHire.agreementParty = datas.agreementParty;
//											$scope.containerOnHire.leaseType = datas.leaseType;

										})
								.error(
										function(data) {
											logger.logError("Unable to fetch");
										});

					}
				});*/
     
 
     

     
     $scope.$watch('containerOffHire.containerDtl[trIndex].containerNo',
				function(newValue, oldValue) {
					if (newValue != ''&& newValue != undefined) {
						
						console.log($scope.trIndex);
var index = $scope.trIndex;
						$http.get($stateParams.tenantid+ '/api/offhirereleaseorder/onhireNolist?containerNo='
												+ newValue)
								.success(
										function(datas) {
											$scope.onhireNolist = datas;
//											for(var i=0; i < datas.containerDtl.length;i++){
//												$scope.containerOffHire.containerDtl[i].hirePort=datas.containerDtl[i].hirePort;
//												$scope.containerOffHire.containerDtl[i].onhireDate=datas.containerDtl[i].onhireDate;
//												$scope.containerOffHire.containerDtl[i].onhireRefno=datas.containerDtl[i].onhireRefno;
//
//											}
											
										$scope.containerOffHire.containerDtl[index].onhireRefno = datas.onhireRefno;
										$scope.containerOffHire.containerDtl[index].hirePort = datas.hirePort;
										$scope.containerOffHire.containerDtl[index].offhireDate = datas.offhireDate;
			

											console.log($scope.containerOffHire.containerDtl.onhireRefno);
										})
								.error(
										function(data) {
											logger.logError("Unable to fetch");
										});

					}
					else{
						$scope.containerOffHire.containerDtl[$scope.trIndex].onhireRefno='';
						$scope.containerOffHire.containerDtl[$scope.trIndex].hirePort='';
						$scope.containerOffHire.containerDtl[$scope.trIndex].offhireDate='';
						
					}
				});
     
     
     
     });

     
     
     
     
$scope.cancel = function() {
    $state.go('app.eqs.containerOffHire.list',{tenantid:$stateParams.tenantid});
};


//reset
$scope.reset = function(containerOffHire) {
	 if (offhireRefno == undefined) {
		 
		 $http.get($stateParams.tenantid+ '/api/offhirereleaseorder/getOffHireRefNo').success(function(data) {
				console.log(data);
			$scope.containerOffHire.offhireRefno = data.offhireRefno;
			});
		 $scope.containerOffHire={
					offhireRefno:'',
					agent:'',
					agreementParty:'',
					port:'',
					createdDate:'',
					containerDtl : []
				
			}

	 } else {
	     $http.get($stateParams.tenantid+'/api/offhirereleaseorder/edit?offhireRefno=' +offhireRefno).success(function(result) {

	         if (result.isEdit == false) {
	             logger.logError("Please Try Again");
	         } else {

	        	 $scope.containerOffHire=result;
	         	$scope.isEdit=true;
	         	for(var i=0; i < $scope.containerOffHire.containerDtl.length;i++){
	         		$scope.containerOffHire.containerDtl[i].containerNo=result.containerDtl[i].containerNo.toString();
	         	}
	         }
	     }).error(function(data) {
	         console.log("data" + data);
	     });
	 }
}

//upload
debugger

$scope.closeUpload = function() {
	ngDialog.close();
}


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
			
			 frmData.append("agreementParty", $scope.containerOffHire.agreementParty);
			 frmData.append("port", $scope.containerOffHire.port);
		$
					.ajax({
						type : "POST",
						url : $stateParams.tenantid+'/api/offhirereleaseorder/uploadfile',
						data : frmData,
						contentType : false,
						processData : false,
						success : function(response)
					{
							// loader.complete();
							if (response.success == true) {
								var flag=false;
								var j=0;
								for(var i=0; i < response.containerDtl.length;i++){
									$scope.containerOffHire.containerDtl.push(response.containerDtl[i]);
									$scope.containerOffHire.containerDtl[i].containerNo=response.containerDtl[i].containerNo.toString();	



								}
								$('#buttontemp').simulateClick('click');
								//	$scope.containerOnHire.containerDtl=angular.copy(response.containerDtl);
									logger.logSuccess("Container Details Uploaded Successfully");
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
$scope.downloadFile = function() {
	$("#sampleDownload").bind('click', function() {
	});
	$('#sampleDownload').simulateClick('click');
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

 $scope.genCancel=function(){
        ngDialog.close();
    }
 
$scope.fileUpload =function(){
	 ngDialog.open({
            template : 'fileGenModal',
            scope :$scope
        });
	} 


	
});

