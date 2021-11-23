
app.controller('mnrTarrifAddCtrl', function($scope, $rootScope, $http, $location, logger, ngDialog,
        utilsService,$state,sharedProperties,$window,$stateParams,toaster,validationService) {

	$scope.damageRecordDtl=[];
	$scope.containerSizelist = [];
	$scope.locationList = [];
	$scope.containerTypeList = [];
	$scope.containerNoList = [];
	$scope.damageStatusList = [];
	$scope.damageCodeList = [];
	$scope.repairProcessList = [];
	$scope.containerNoList = [];
	$scope.mnrTarrifDtl=[];
    $scope.isEdit = false;

$scope.mnrTarrif={
		damageCode:'',
		damageLocation:'',
		manHour:'',
		labourRate:'',
		materialCost:'',
		totalCost:'',
		tarrifFromDate:'',
		tarrifToDate:'',
		manHrAmount:'',
		partList:'',
		portList:'',
		color:'',
		mnrTarrifId:'',
		mnrTarrifBeanDtl : [],
        mnrTarrifDtl : []
	
}

//Reset on add mode
$scope.reset = function() {
    $scope.mnrTarrif=[];   
    $scope.getDropdownvalue();
    $scope.tempdamageRecordDtl=[];
    $scope.damageRecordDtl=[];
    $scope.mnrTarrifDtl=[];
};

$scope.mnrTarrifDtl={
		mnrTarrifId:'',
		damageCode:'',
		damageLocation:'',
		manHour:'',
		labourRate:'',
		materialCost:'',
		totalCost:'',
		tarrifFromDate:'',
		tarrifToDate:'',
		manHrAmount:'',
		partList:'',
		tarrifFromDate:'',
		tarrifToDate:'',
		mnrTarrifBeanDtl : []
        
	
}

$scope.tempMNR={
	
	 select:false,
	    damageCode:'',
		damageLocation:"",
		manHour:"",
		labourRate:"",
		materialCost:"",
		totalCost:"",
		manHrAmount:"",
		partList:"",
}


//Multiple Add
$scope.addCredRow = function() {
	   debugger
	   var tmp=angular.copy($scope.tempMNR);
		$scope.mnrTarrif.mnrTarrifDtl.push(tmp);

}

//Remove Cred

$scope.removeCredRow =function(){
	ngDialog.openConfirm().then(function() {
		var tmpDelList = [];
		for(var i=$scope.mnrTarrif.mnrTarrifDtl.length-1;i>=0;i--){
			if($scope.mnrTarrif.mnrTarrifDtl[i].select==true){
				tmpDelList.push($scope.mnrTarrif.mnrTarrifDtl[i]);
				$scope.mnrTarrif.mnrTarrifDtl.splice(i, 1);
			}
		}
		logger.logSuccess('Deleted Successfully');

	})
}

//save
$scope.save = function(MNRTarrifFormAdd,mnrTarrif) {
	if (new validationService().checkFormValidity(MNRTarrifFormAdd)) {
        $http.post($stateParams.tenantid+'/api/mnrTarrifType/save',mnrTarrif).success(function(data) {
            console.log("data" + data);
            if (data.isSuccess) {
                logger.logSuccess("Saved Successfully!");
                $state.go('app.eqs.mnrTarrif.mnrTarrifList');
            } else {
                logger.logError(data.message);
            }
        }).error(function(result) {
            console.log("data" + data);
        });
	}else {
        toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(MNRTarrifFormAdd.$validationSummary), 555000, 'trustedHtml');
    }
    
 };
 /*$scope.calculateTotalAmount=function(totalCost){
	 
 
 } */
//Fetch Values
 $scope.isEdit = false;
 var mnrTarrifId = $location.search().mnrTarrifId;
 if (mnrTarrifId == undefined) {

 } else {
	 
     $http.get($stateParams.tenantid+'/api/mnrTarrifType/edit?mnrTarrifId=' +mnrTarrifId).success(function(result) {

         if (result.isEdit == false) {
             logger.logError("Please Try Again");
         } else {

        	 $scope.mnrTarrif=result;
        	 $scope.mnrTarrif.mnrTarrifId=result.mnrTarrifId;
         	$scope.isEdit=true;
         	
         }
     }).error(function(data) {
         console.log("data" + data);
     });
 }

 
 $scope.$watch('mnrTarrif.tarrifToDate', function(newValue, oldValue){
     
 	
 	if ($scope.mnrTarrif.tarrifFromDate == '' && newValue != undefined && newValue != '') {
 		
 		 logger.logError("Please Select From Date!");
 		 $scope.mnrTarrif.tarrifToDate = "";
 		
 	}
 
 });
 
 

 
 /*$http.post($stateParams.tenantid+ '/api/mnrTarrifType/dropDownList').success(function(data) {

		$scope.damageLocation = data.listDamageLocation;
		//listReleaseReNoList;
		//listDamageLocation
		

	});*/
 
 /*$scope.$watchCollection('[ mnrTarrif.tarrifFromDate]',function(newValue, oldValue) {
		if ($scope.mnrTarrif.tarrifToDate!= '') {
		var frmDate = $scope.mnrTarrif.tarrifFromDate;
		var toDate = $scope.mnrTarrif.tarrifToDate;
		var splitarray = new Array();
		splitarray = tarrifFromDate.split(" ");
		var date = splitarray[0];
		var time = splitarray[1];
		frmDate = date.split("/");
		frmDate = new Date(frmDate[2],
		frmDate[1] - 1, frmDate[0]);
		toDate = toDate.split("/");
		toDate = new Date(toDate[2],
		toDate[1] - 1, toDate[0]);
		if ( frmDate>toDate ) {
		logger
		.logError(" From Date should be lesser than To Date");
		$scope.mnrTarrif.tarrifFromDate = "";
		}
		}
		});*/
		$scope.$watchCollection('[ mnrTarrif.tarrifToDate]',function(newValue, oldValue) {
		if ($scope.mnrTarrif.tarrifFromDate != '') {
		var frmDate = $scope.mnrTarrif.tarrifFromDate;
		var toDate = $scope.mnrTarrif.tarrifToDate;
		var splitarray = new Array();
		splitarray = frmDate.split(" ");
		var date = splitarray[0];
		var time = splitarray[1];
		frmDate = date.split("/");
		frmDate = new Date(frmDate[2],
		frmDate[1] - 1, frmDate[0]);
		toDate = toDate.split("/");
		toDate = new Date(toDate[2],
		toDate[1] - 1, toDate[0]);
		if (toDate <frmDate) {
		logger.logError(" To Date should be greater than From Date");
		$scope.mnrTarrif.tarrifToDate = "";
		}
		}
		});
		
	      
		  $scope.update = function(MNRTarrifForm,mnrTarrif) {  
			  debugger
		             $http.post($stateParams.tenantid+'/api/mnrTarrifType/update', mnrTarrif).success(function(result) {
		                 if (result.isSuccess) {
		                     logger.logSuccess("Updated Successfully!");
		                     $state.go('app.eqs.mnrTarrif.mnrTarrifList',{tenantid:$stateParams.tenantid});
		                 } else {
		                     logger.logError("Error in Update");
		                 }
		             }).error(function(result) {
		                 console.log("data" + result);
		             });
		         
		     }
		  
     //Dropdown for Selectivity
     $http.post($stateParams.tenantid+'/api/damageRecordType/dropDownList').success(function(data) {
      
       		$scope.damageCode=data.listDamageCodeList;
       		
       });
     
     //Dropdown For DamageLocation
     $http.post($stateParams.tenantid+'/api/mnrTarrifType/dropDownList').success(function(data){
    	 $scope.damageLocation = data.listDamageLocationList;
     
     });
     
  /*   //Dropdown for manualHours
     $http.post($stateParams.tenantid+'/api/mnrTarrifType/dropDownList2').success(function(data){
    	 $scope.manHour = data.listmanHourList;
     
     });*/
     
   //Dropdown for Parts
     $http.post($stateParams.tenantid+'/api/mnrTarrifType/dropDownListParts').success(function(data){
    	 
     	 $scope.partList = data.listPartsList;
      
      });
     
     //DropDown for Ports
     $http.post($stateParams.tenantid+'/api/mnrTarrifType/dropDownListPorts').success(function(data){
    	 debugger
     	 $scope.portList = data.listPortsList;
      
      });
     
     //Get MnrTarrifID
     /*$http.get($stateParams.tenantid+'/api/mnrTarrifType/getMnrTarrifId').success(function(data) {

    		console.log(data);
    		$scope.mnrTarrif.mnrTarrifId = data.mnrTarrifId;
    		});*/
     
     app.controller('tarriftableCtrl', function($scope, $http, $filter, logger,$stateParams) {
    		 $scope.$watch('mnrTarrif.mnrTarrifDtl[trIndex].manHour', function(newValue, oldValue) {
    			 debugger
    			
    				 if ($scope.row.damageCode == '' && newValue != undefined && newValue != '' && $scope.row.damageLocation == '' && newValue != undefined && newValue != '' ){
    				 logger.logError("Please Select Damage Code or Damage Location!");
    				 $scope.row.manHour='';p
    			 }
    		 });
    		 
    		 $scope.$watchCollection('[row.labourRate,row.materialCost]', function(newValue, oldValue) {
    		
    			 var num1 = $scope.row.labourRate;
            	 var num2 = $scope.row.materialCost;
            	 var result = parseFloat(num1) + parseFloat(num2);
            	 
            	 $scope.row.totalCost = result;
    			 
     });
    		 
    		 $scope.$watchCollection('[row.manHour,row.manHrAmount]', function(newValue, oldValue) {
    	    		
    			 var num1 = $scope.row.manHour;
            	 var num2 = $scope.row.manHrAmount;
            	 var result = parseFloat(num1) * parseFloat(num2);
            	 
            	 $scope.row.labourRate = result;
    			 
     });
    		 
    		/* $scope.$watch('[row.manHour]', function(newValue, oldValue) {
 	    		debugger
    			 if($scope.row.damageCode ='' && newValue == undefined  ){
    				 
    				 log.logger("Please");
    			 }
    		  });
    		 */
     });
     //Commented For ManHour_List not required
    /* $scope.$watch('mnrTarrif.manHour', function(newValue, oldValue) {
       //  $scope.mnrTarrif.manHour = '';
         if ($scope.mnrTarrif.manHour != '') {
            // $scope.invoiceViewHeader.vessel = $scope.vesselObj.text;
        	 $http.post($stateParams.tenantid+'/api/mnrTarrifType/manAmount?manHour='+newValue).success(function(data){
                 $scope.mnrTarrif.manHrAmount = data.manHrAmount;
             });
         } else {
             $scope.mnrTarrif.manHour = '';
         }
     });*/
     
     
     $scope.$watchCollection('[mnrTarrif.manHour,mnrTarrif.manHrAmount]', function(newValue, oldValue) {
    	debugger
         //  $scope.mnrTarrif.manHour = '';
    	 
    	 var num1 = $scope.mnrTarrif.manHour;
    	 var num2 = $scope.mnrTarrif.manHrAmount;
    	 var result = parseFloat(num1) * parseFloat(num2);
    	 
    	 $scope.mnrTarrif.labourRate = result;
       });   
            
     
            $scope.$watchCollection('[mnrTarrif.labourRate,mnrTarrif.materialCost]', function(newValue, oldValue){
            	 
            	 var num1 = $scope.mnrTarrif.labourRate;
            	 var num2 = $scope.mnrTarrif.materialCost;
            	 var result = parseFloat(num1) + parseFloat(num2);
            	 
            	 $scope.mnrTarrif.totalCost = result;
            	 
            	 });
           /* 
            $scope.$watch('mnrTarrif.manHour', function(newValue, oldValue) {
   			 debugger
   			
   				 if ($scope.mnrTarrif.damageCode == '' && newValue != undefined && newValue != '' && $scope.mnrTarrif.damageLocation == '' && newValue != undefined && newValue != '' ){
   				 logger.logError("Please Select Damage Code or Damage Location!");
   				 $scope.row.manHour='';
   			 }
   		 });*/
            
     
$scope.cancel = function() {
    $state.go('app.eqs.mnrTarrif.mnrTarrifList',{tenantid:$stateParams.tenantid});
};


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
			$
					.ajax({
						type : "POST",
						url : $stateParams.tenantid+'/api/mnrTarrifType/uploadfile',
						data : frmData,
						contentType : false,
						processData : false,
						success : function(response) {
							// loader.complete();
							if (response.success == true) {
								for(var i=0; i < response.containerDtl.length;i++){
									$scope.mnrTarrif.mnrTarrifDtl.push(response.containerDtl[i]);
								}
								$('#buttontemp').simulateClick('click');
								//	$scope.containerOnHire.containerDtl=angular.copy(response.containerDtl);
								if(response.containerDtl.length > 0 ){
										logger.logSuccess(" Details Uploaded Successfully!");
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







//reset
$scope.reset = function(mnrTarrif) {
	debugger
if (mnrTarrifId == undefined) {
	/*//$http.get($stateParams.tenantid+'/api/damageRecordType/getContainerNo').success(function(data){
		console.log(data);
		$scope.mnrTarrif.uniqueId = data.uniqueId;
	});*/
	$scope.mnrTarrif={
			mnrTarrifId:'',
			damageCode:'',
			damageLocation:'',
			manHour:'',
			labourRate:'',
			materialCost:'',
			totalCost:'',
			tarrifFromDate:'',
			tarrifToDate:'',
			manHrAmount:'',
			mnrTarrifBeanDtl : []
		
	}
} else {
	debugger
$http.get($stateParams.tenantid+'/api/mnrTarrifType/edit?mnrTarrifId=' +mnrTarrifId).success(function(result) {

if (result.isEdit == false) {
logger.logError("Please Try Again");
} else {
	debugger
$scope.mnrTarrif.mnrTarrifId=result.mnrTarrifId;

$scope.isEdit=true;
}
}).error(function(data) {
console.log("data" + data);
});
}

}


	
});