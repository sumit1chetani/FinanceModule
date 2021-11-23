'use strict';

app.controller('estimateRepairListCtrl', function($scope, $rootScope, $http, $location, logger, utilsService, ngDialog, $state,sharedProperties,$window,$stateParams) {

    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    
    
    $scope.repairEstimate={
    		estimateRepairNo:'',
    		status:'Approved',
    		depot:'',
    		containerNo:'',
    		containerId:'',
    		containerType:'',
    		agent:'',
    		returnDate:'',
    		inspectionDate:null,
    		
    	    	
    }
    
    $scope.repairEstimateBean={
    		estimateRepairNo:'',
    		excelfile:'',
    		depot:'',
    		agent:'',
    		currency:'USD',
    		files : [],
    		inspectionDate:null,
    		approveRemarks:'',
    		select:false,
    		
    		
    		repairEstimateDtl : [{
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
    			select :false
    	}]
    		
    	
    }
    
    $scope.getList
	
	$scope.$watch('repairEstimate.status',function(newValue, oldValue) {
		if(newValue!=null && newValue!=undefined && newValue!=""){
			$scope.getList($scope.repairEstimate);
		}
	});

    $scope.getList =function(repairEstimate) {
    	$scope.getList=function(){
            $http.post($stateParams.tenantid+'/app/repairEstimates/estimateRepairlist',repairEstimate).success(function(datas) {
                console.log(datas);
                $scope.rowCollection = datas.list1;
            	
                }).error(function(datas) {
            });
            };
    };

    $scope.getList=function(repairEstimate){
        $http.post($stateParams.tenantid+'/app/repairEstimates/estimateRepairlist',repairEstimate).success(function(datas) {
            console.log(datas);
            $scope.rowCollection = datas.list1;
        	
            }).error(function(datas) {
        });
        };    
    
    $scope.add = function() {
        $state.go('app.eqs.estimateRepair.estimateRepairAdd',{tenantid:$stateParams.tenantid});
    };
    
    
    $scope.statusList = [
	{
    	id : 'All',
    	text : 'All'
    },
    {
    	id : 'Pending',
    	text : 'Pending'
    },
    {
    	id : 'Submitted',
    	text : 'Submitted'
    },
    {
    	id : 'Approved',
    	text : 'Approved'
    },
    {
    	id : 'Rejected',
    	text : 'Rejected'
    }]
    
    
 // Redirecting Page For Edit Functionality
    $scope.editRow = function(estimateRepairNo,status) {
    	
    	if(status == 'Approved'){
    		logger.logError("NOTE: CAN’T EDIT AFTER SUBMIT OR APPROVAL..!!");
  //      $location.url($stateParams.tenantid+'/estimateRepair/Edit?estimateRepairNo='+estimateRepairNo);
    	}else{
            $location.url($stateParams.tenantid+'/estimateRepair/Edit?estimateRepairNo='+estimateRepairNo);

    	}
    	
    };

    
 // Redirecting Page For Edit Functionality
    $scope.editRowAfterAprroval = function(estimateRepairNo,status) {
    	
    $location.url($stateParams.tenantid+'/estimateRepair/EditAfterApproval?estimateRepairNo='+estimateRepairNo);

    };
    
 // Approve Page 
    $scope.approveRow = function(estimateRepairNo,status) {
    	
    	if(status == 'Approved'){
    		logger.logError("NOTE: CAN’T EDIT AFTER SUBMIT OR APPROVAL..!!");
 //       $location.url($stateParams.tenantid+'/estimateRepair/Approval?estimateRepairNo='+estimateRepairNo);
    	}else{
            $location.url($stateParams.tenantid+'/estimateRepair/Approval?estimateRepairNo='+estimateRepairNo);
            
    	}
    	
    };
    
    // View Page 
    $scope.viewRow = function(estimateRepairNo,status) {
    	
    	
            $location.url($stateParams.tenantid+'/estimateRepair/View?estimateRepairNo='+estimateRepairNo);

    	
    	
    };    
    
    $scope.deleteRow = function(estimateRepairNo) {
        ngDialog.openConfirm().then(function() {
        
            var url = $stateParams.tenantid+'/app/repairEstimates/estimateRepairDelete?estimateRepairNo=' + estimateRepairNo;
            $http.get(url).success(function(result){
                if (result.isSuccess ==  true) {
                    logger.logSuccess("Deleted Successfully");
                    $state.reload();
               } else {
                    logger.logError("You Can't Delete this Record, Related Data Exist! ");
                }
            }).error(function(result) {
                logger.logError("Error Please Try Again");
            });
        }, function(reason) {
            console.log('Modal promise rejected. Reason: ', reason);
        });
    };

    //Excel Export	for Approval
 	 $scope.exportExcel = function(){
 		 var test;
 		var tmpDelList = [];
		for(var i=$scope.rowCollection.length-1;i>=0;i--){
			if($scope.rowCollection[i].select==true){

				if($scope.rowCollection[i].status !='Submitted' || $scope.rowCollection[i].status == undefined || $scope.rowCollection == undefined){
					test = test + "," +"false";
					logger.logError("Please  Select the Submitted List..!!!");
				}
				if($scope.rowCollection[i].status=='Submitted'){
					test = test + "," + "true";
				tmpDelList.push($scope.rowCollection[i]);
				}
			}
		}
		var check =  test.split(",").includes("false") ? false : true ;
		if (check ==false){
			console.log(check);
		}
		else{
		
			
		$scope.selectList = tmpDelList;
		var obj={
				repairEstimateDtl:$scope.selectList
		};
 	   	 $http.post($stateParams.tenantid+'/app/repairEstimates/ExportExcel', obj).success(function(response) {

 	                if(response){
 	                    debugger;
 	                    $("#DOReport").bind('click', function() {
 	                    });
 	                    $('#DOReport').simulateClick('click');
 	                    logger.logSuccess("Exported successfully!");
 	                }else{
 	                    logger.logError("Failed to export");
 	                }
 	                
 	            }).error(function(response) {
 	                logger.logError("Error Please Try Again");
 	            });
 	 
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
   
 	  
 	// upload
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
 								url : $stateParams.tenantid+'/app/repairEstimates/uploadfile',
 								data : frmData,
 								contentType : false,
 								processData : false,
 								success : function(response) {
 									if (response.success == true) {
 												logger.logSuccess(response.message);
 		 										$scope.closeUpload();
 		 										 $scope.getList;
 									} else if (response.success == false) {
 										if(response.errorList != null){
 											for (var i = 0; i < response.errorList.length; i++) {
 	 											logger.logError(response.errorList[i]);
 	 											$scope.closeUpload();
 	 											
 	 										}
 										}else{
 											logger.logError(response.message);
 											$scope.closeUpload();
 										}
 										
 									} else if (response.errorList.length > 0) {

 									} else {
 										logger.logError("Sorry Error Occured");
 										$scope.closeUpload();
 										$scope.getMemberList();
 									}
 								}
 							});
 				}
 			}
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