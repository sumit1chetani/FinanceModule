app .controller(
				'containerBankCtrl',
				function($scope, $timeout, $stateParams, $filter, $rootScope,
						$http, $location, logger, utilsService, $state,
						sharedProperties, $window, ngDialog, $interval,
						validationService, toaster, $controller, $injector) {
	 $scope.dummy = '';
	 $scope.dummy1 = '';
	 $scope.dummy2 = '';
	 $scope.dummy3 = '';


    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    
    $scope.vesselList = [];
	$scope.voyageList = [];
	$scope.polList = [];
	$scope.podList = [];
	$scope.blList = [];

    
    $scope.containerBank = {
			vessel : '',
			voyage : '',
			pol : '',
			pod : '',
			blNo : '',
			onhireRefNo:'',
			depot:'',
			type:'onHire'
    }
    
    $scope.getList = function() {
        $http.post($stateParams.tenantid+'/api/containerBank/list',$scope.containerBank).success(function(datas) {
            $scope.rowCollection = datas;
            })
    };
        $scope.getList();
        
        $scope.getSearch = function() {
       	 
        	  $http.post($stateParams.tenantid+'/api/containerBank/SearchList',$scope.containerBank).success(function(datas) {
                  console.log(datas);
                  $scope.rowCollection = datas;
              	
                  }).error(function(datas) {
              });
        }
           
        //excel export
	    
	    $scope.excel = function() {
	        if($scope.joborder.branch !=''){
	        	
			$http.post($stateParams.tenantid + '/api/containerBank/generateExcel',$scope.joborder).success(function(data) {
				if (data.success == true) {
					
				$scope.debitNoteFileUrl = data.filePath.split("/");
				$scope.actualLength=$scope.debitNoteFileUrl.length;
				$scope.fileLength=$scope.actualLength - 1;
	            $scope.downloadFile = $scope.debitNoteFileUrl[$scope.fileLength];
	            console.log($scope.downloadFile)
				logger.logSuccess("Exported successfully!");
				 $('#exportXl').attr('href','filePath/' +$scope.downloadFile);
			    $("#exportXl").bind('click', function() {
			   });
			   $('#exportXl').simulateClick('click');
			  
			   } else {
					logger.logError("Failed to Export!..");
				}

			}).error(function(data) {
				logger.logError("Error Please Try Again");
			});
	  
    }	else{
	      logger.logError("Please select  Branch");
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
	
        
      //vessel
		
		$http.get($stateParams.tenantid+ '/app/commonUtility/getVesselList').success(function(data) {
			$scope.vesselList = data;
		});
		
    //BlNo Dropdown
		
		$http.get($stateParams.tenantid+ '/api/containerBank/BldropDown').success(function(data) {
			$scope.blList = data;
		});

		 $scope.$watch('containerBank.vessel', function(newValue, oldValue) {
		      if(newValue!=null && newValue!=undefined && newValue != ''){
		    	  $http.post($stateParams.tenantid+ '/app/commonUtility/getVoyageListByVessel',newValue).success(function(data) {
						$scope.voyageList = data;
		    	  });
		      }
		    });
		 //pol

		    	  $http.post($stateParams.tenantid+ '/api/containerBank/GetPortByVoyage').success(function(data) {
						$scope.polList = data;
		    	  });
		 //pod
		    	  $http.post($stateParams.tenantid+ '/api/containerBank/GetPortByVoyage').success(function(data) {
						$scope.podList = data;
		    	  });
		 
        	
        	/*$scope.view =function(containerNo,onhireDate,containerType,containerId){
        		   $rootScope.containerNo = containerNo;
        		   $scope.dummy = containerNo;
        		   $scope.dummy1 = onhireDate;
        		   $scope.dummy2 = containerType;
        		   $rootScope.containerId = containerId;

        	    ngDialog.open({
        	        scope : $scope,
        	        template : 'deliveryOrderpop',
        	        controller : $controller('deliveryOrderpopCtrl', {
        	            $scope : $scope
        	        }),
        	        className : 'ngdialog-theme-plain',
        	        showClose : true,
        	        closeByDocument : false,
        	        closeByEscape : false
        	        preCloseCallback : $scope.getList,
        	        
                    closeByEscape : false

        	    });
        	    
        	    
        	};*/
		    	  
		    	  
		    	  
        	
        	  $scope.view = function(containerNo,actualPickupDate,containerType,containerId){
  	        	$rootScope.containerNo = containerNo;
  	        	$rootScope.onhireDate =actualPickupDate;
  	        	$rootScope.containerType = containerType;
  	        	$rootScope.containerId =containerId;
  	        	$scope.dummy = containerNo;
     		   $scope.dummy1 = actualPickupDate;
     		   $scope.dummy2 = containerType;
  	        	$scope.callQCDialog($scope,$http, ngDialog, logger,$injector, sharedProperties,$stateParams, toaster,$rootScope);
  	        	};
  	        	
  	        	
  	        	$scope.callQCDialog = function($scope,$http, ngDialog, logger,$injector, sharedProperties,$stateParams, toaster,$rootScope){
  	        		ngDialog.open({
  	        		scope: $scope,
  	        		template: '/views/reports/containerBank/containerbankPopup',
  	        		controller: $controller('poPopupCtrl', {
  	        		$scope: $scope,
  	        		$http:$http,
  	        		ngDialog:ngDialog,
  	        		logger:logger,
  	        		$injector:$injector,
  	        		sharedProperties:sharedProperties,
  	        		toaster:toaster,
  	        		$rootScope:$rootScope
  	        		}),
  	        		className: 'ngdialog-theme-plain',
  	        		showClose: false,
  	        		closeByDocument: false,
  	        		closeByEscape: false,
  	        		preCloseCallback : $scope.getList
  	        		});

  	        		}

        	
        	$scope.closeUpload = function() {
				ngDialog.close();
			}
       
        	 $scope.reset = function(containerReport) {
        		 $scope.containerBank = {
        					vessel : '',
        					voyage : '',
        					pol : '',
        					pod : '',
        					blNo : '',
        					onhireRefNo:'',
        					depot:'',
        					type:'onHire'
        		    }
        	    	
        	        $scope.getList();

        	    }
    



   
				});

app.controller('poPopupCtrl', function($scope, $timeout, $stateParams,sharedProperties,toaster,
		$filter, $rootScope, $http, $location, logger, $state, ngDialog,$controller,$injector,validationService) {
	
	console.log("entry view");

	$scope.container = {
			containerId:'',
			containerNo:'',
			containerType : '',
			cmsCode : '',
			statusDate : '',
			depot:'',
			formCode:'',
			blNo:''
			
	}
    $scope.rowCollection1 = [];
	
	
	$scope.blNo = $location.search().blNo;   
	$scope.bookingNo = $location.search().bookingNo;  
	$scope.from = $location.search().from;  
	console.log("blNo123", $scope.blNo);
	
	  $scope.socList = [
	       {id: '1', text: 'Yes'},
	    {id: '2', text: 'No'}, 
	     ];
	  
	   $scope.fleList = [
		       {id: '1', text: 'F'},
		    {id: '2', text: 'L'}, 
		 {id: '3', text: 'E'} 
	     ];
	
	$http.get($stateParams.tenantid+'/api/outWard/getContainerList').success(function(datas) {
        $scope.containerList = datas;
        console.log("getContainerList",$scope.containerList);
    });
	
	   $http.get($stateParams.tenantid+'/api/outWard/getPackageTypeList').success(function(datas) {
	        $scope.packageList = datas;
	    });
	    
	
	
    $http.get($stateParams.tenantid+ '/app/commonUtility/getContainerTypeList').success(function(data1) {
		$scope.containerTypeList = data1.containerTypeList;
	});

	$scope.test = $rootScope.containerNo;
	 $scope.container.containerNo = $rootScope.containerNo;
	 
	 $scope.test1 = $rootScope.containerId;
	 $scope.container.containerId = $rootScope.containerId;
	 
	
	 $http.post($stateParams.tenantid+'/api/containerBank/popuplist?containerId=' +$scope.container.containerId).success(function(result) {
		 $scope.rowCollection1 = result.detailList;
		 
 });
	 
	//----------------------------------------------------------------------------------------------------------------------------
	  //for shipping bills files 
     $http.get($stateParams.tenantid+ '/api/outWard/getShippBillFiles?blNo=' +$scope.blNo).success(function(dataList) {
			console.log(dataList);
			$scope.exportShippingBillFiles = [];
			$scope.exportShippingBillFiles = dataList;

		});
     

     $scope.downloadNewBillFile = function(id) {
         debugger;  
//         alert("inside 123");
         document.getElementById('tbnewShippBill'+id).click();
     }
     
     $scope.deleteShippBillfiles = function(filename) {
    	    $scope.tempfiles = []; 
    	    $scope.DBdelete= [];
    	    $scope.tempfilename = [];
    	    
    	    angular.forEach($scope.exportShippingBillFiles, function(row, index) {
    	        if (filename != row.filename) {
    	            $scope.tempfilename.push(row);
    	           // $scope.exportShippingBillFilesFileName.push('filePath/'+ row.filename);
    	        }else{
    	        	 $scope.DBdelete.push(row);
    	        }
    	    });
    	   
    	    $scope.files = $scope.tempfiles;
    	    $scope.exportShippingBillFiles = $scope.tempfilename;
    	    
    	   	 if ($scope.DBdelete.length > 0) {  		 
    	        angular.forEach($scope.DBdelete, function(ddaa, index) { 
    	        	$http.get($stateParams.tenantid+'/api/outWard/deleteShippBill?uID='+ddaa.uid+'&blNo='+ddaa.blNo).success(function(datas) {
    	       	 
    	        });
    	        	});

    	   }
    	  	      
    	}
     
     
     $scope.checkundefined = function(value) {
	 		var invalid = false;
	 		if (value == undefined || value == 'undefined'
	 				|| value == null || value == 'null'
	 				|| value == '') {
	 			invalid = true;
	 		}
	 		return invalid;
	 		

	 	}
     
   //Rate Deviation Approval Files
     $scope.data = {
    	        files : [] 

    	};

    	$scope.files = [];
    	$scope.files1 = [];
    	$scope.files2 = [];

     $rootScope.uploadFile = function(element) {
     	 for(var i=0;i<element.files.length;i++){
        $scope.excelfile = element.files[i];
        
     	 }
     }
     
     $scope.rateDeviationFiles=[];
     $scope.rateDeviationFilesFileName=[];

     $scope.addRateDeviationFile = function(){
         var obj = []

         if ($scope.checkundefined($scope.excelfile)) {
             logger.logError("Please select the file");
         } else {
             obj = $filter('filter')($scope.rateDeviationFiles, {
                 filename : $scope.excelfile.name
             }, true);
         }

         if (obj != undefined && obj.length > 0) {
             logger.logError($scope.excelfile.name + " same file already added");
         } else {
             $scope.files2.push($scope.excelfile);
             $scope.rateDeviationFiles.push({
                 filename : $scope.excelfile.name,
                 filepath : '',
                 employeeId : ''
             });

         }
         
       	 //Rate Deviation Approval
       	 
	       	if ($scope.files2.length > 0) {
              angular.forEach($scope.files2, function(files2, index) {
                  var frmData = new FormData();
                  frmData.append("file2", files2);
                  frmData.append("blNo",$scope.blNo);
                  $.ajax({
                      type : "POST",
                      url : $stateParams.tenantid+"/api/outWard/updateUploadRateDeviationfile",
                      data : frmData,
                      contentType : false,
                      processData : false,
                      success : function(result) {}
                  });
              });

         }
	       	
     }
     
     
     
     $http.get($stateParams.tenantid+ '/api/outWard/getRateDeviationFiles?blNo=' +$scope.blNo).success(function(dataList) {
			console.log("getRateDeviationFiles",dataList);
			  $scope.rateDeviationFiles = [];
			$scope.rateDeviationFiles = dataList;
			

		});
     
     $scope.downloadRateDeviationFile = function(id) {
    	    debugger;    
    	    document.getElementById('rateDeviationBill'+id).click();
    	}
     
     

     $scope.deleteRateDeviationfiles = function(filename) {
         $scope.tempfiles = [];
         $scope.tempfiles1 = [];
         $scope.DBdelete= [];
         $scope.tempfilename = [];
         //$scope.exportShippingBillFiles=[];
         angular.forEach($scope.files2, function(row, index) {
             if (filename != row.name) {
                 $scope.tempfiles.push(row);
                 $scope.tempfiles1.push(row);
             }
         });
         angular.forEach($scope.rateDeviationFiles, function(row, index) {
             if (filename != row.filename) {
                 $scope.tempfilename.push(row);
                 $scope.rateDeviationFilesFileName.push('filePath/'+ row.filename);
             }else{
             	 $scope.DBdelete.push(row);
             }
         });
        
         $scope.files = $scope.tempfiles;
         $scope.rateDeviationFiles = $scope.tempfilename;
         $scope.files2 =$scope.tempfiles1;

         
       	 if ($scope.DBdelete.length > 0) {  		 
             angular.forEach($scope.DBdelete, function(ddaa, index) { 
             	$http.get($stateParams.tenantid+'/api/outWard/deleteRateDeviation?uID='+ddaa.uid+'&blNo='+ddaa.blNo).success(function(datas) {
            	 
             });
             	});

        }
       	      
     }

     
     
     //----------------------------------------------------------------------------------------------------------------------------
     
	
	 $scope.closePopup = function(){
	        ngDialog.close();
	        $state.reload();
	  }
	 
	 
	 
	 $scope.cancel = function() {
		 if($scope.from=='bl'){
			 $state.go('app.documentation.outwardbladding.outwardlist');
		 }
		 else if($scope.from=='bldraft'){
			 $state.go('app.documentation.bldraft.bldraftlist');
		 }
		 else if($scope.from=='conTrack'){
			 $state.go('app.cim.containerBank.containerBankList');
		 }
		 else if($scope.from=='BLTrack'){
			 $state.go('app.trackAndtrace.BLtracking.list');
		 }
		 /*else if($scope.from=='dashboard'){
			 $state.go('dashboard.list');
		 }*/
		 else{
			 $state.go('app.cim.containerBank.containerBankList');

		 }
	 }
	 
	  
	 
	 $scope.downloadNewFile = function(id) {
		    debugger;
		    
		    document.getElementById('tbnewExport'+id).click();

		}
	 
	
	 $scope.getBLdDetailList = function() {
	      $http.get($stateParams.tenantid+"/api/outWard/view?blNo="+ $scope.blNo).success(function(response) {
	       	 console.log("BL Detail Datas",response);
	         $scope.blDetailList = response;
	         $scope.blDetailList.quotationDtl=response.quotList;
	         $scope.blDetailList.addchargeData=response.addchargeData;
	         $scope.bookingNo=response.bookingno;
	         if(response.terms!=null){
	        	 if(response.terms=='1'){
	        		 response.terms= 'Collect';
	        	 }else if(response.terms=='2'){
	        			 response.terms='Prepaid';
	        	 }else if(response.terms=='3'){
	        		 response.terms= 'Third Pary Collect'
	        			 } 
	         }
	         
	       	$scope.exportDeclarationDocFiles=[];
        	if($scope.blDetailList.exportDeclarationDoc !=null  && $scope.blDetailList.exportDeclarationDoc !=""){
        		
        	var filesList = $scope.blDetailList.exportDeclarationDoc.split(","); 
        	for(i=0;i<filesList.length;i++){
        		 var str = filesList[i].split("/"); 
         		  console.log("str",str);
         		  $scope.exportDeclarationDocFiles.push({
         	             filename : str[str.length - 1],
         	             filepath : filesList[i],
         	            
         	         });
        	}
      		 
        }
	         for(var i=0; i < $scope.blDetailList.blcntrDtlList.length;i++){
          		$scope.blDetailList.blcntrDtlList[i].cntrNo=response.blcntrDtlList[i].cntrNo.toString();
          		$scope.blDetailList.blcntrDtlList[i].type=response.blcntrDtlList[i].conType.toString();
          	 
          	}
	   
	         $scope.bookingEdit(response.bookingno);
	        });
	    }
	    $scope.getBLdDetailList();
	    
	    
        $scope.userLogHistory = function(){
        	$http.get($stateParams.tenantid+'/api/outWard/getUserlogHistory?blNo='+$scope.blNo).success(function(result) {
             	$scope.rowCollection=result.userLogHistoryList;
             	console.log("getUserlogHistory",$scope.rowCollection);
             
         }).error(function(data) {
            console.log("data" + data);
        });
        }
        $scope.userLogHistory();
        
        
        
        
      //Destination Charges


        $scope.bldesCurrency="";
        $scope.paymentTerms="";
        $scope.destinationCharges = function(){
        	$http.get($stateParams.tenantid+'/api/outWard/getdestinationCharges?blNo='+$scope.blNo).success(function(result) {
        		$scope.paymentTerms = result.terms;
        		console.log("$scope.paymentTerms",$scope.paymentTerms);
        		$scope.destinationCharge = result.destinationCharge;
        		console.log("$scope.destinationCharge",$scope.destinationCharge);
             	$scope.bldesChargesList=result.destinationChargesList;
             	$scope.bldesCurrency = $scope.bldesChargesList[0].currency;
             	console.log("$scope.bldesCurrency",$scope.bldesCurrency);
             	console.log("destinationCharges",$scope.bldesChargesList);
             
         }).error(function(data) {
            console.log("data" + data);
        });
        	
        }
        $scope.destinationCharges();
        
        
        //BL Invoice
        
       $scope.getInvoiceList=function(){
    	   console.log("blInvoiceData");
        	$http.get($stateParams.tenantid+'/api/outWard/getblInvoiceList?blNo='+$scope.blNo).success(function(response) {
                $scope.blInvoiceDataList = response.blInvoiceList;
                console.log("blInvoiceData",response);
                console.log("blInvoiceData123", $scope.blInvoiceData);
            });


        }
        $scope.getInvoiceList();
        
        //CashBank Receipt
        
        $scope.getCollectionList=function(){
     	   console.log("getCollectionListData");
         	$http.get($stateParams.tenantid+'/api/outWard/getCollectionList?blNo='+$scope.blNo).success(function(response) {
               $scope.blCollectionsDataList = response.blCollectionsList;
                 console.log("getCollectionList",response);
             });


         }
         $scope.getCollectionList();
        
        
        
        //BL Attachments

        $scope.blAttachments = function(){
        	$http.get($stateParams.tenantid+'/api/outWard/getblAttachments?blNo='+$scope.blNo).success(function(result) {
        		$scope.blAttach = result.blAttachmentList;
        		console.log("blAttachments",$scope.blAttach);
             
         }).error(function(data) {
            console.log("data" + data);
        });
        	
        }
        $scope.blAttachments();


        $scope.downloadblAttachFile = function(id) {
            debugger;    
            document.getElementById('bldownloadFiles'+id).click();
        }
        var fileName = "Sample Frame"; 

        $scope.openFileSample = function(fileName1){
        	console.log('inside the dialog function1',fileName1);
        	
        	$("#dialog").dialog({
        	modal: true,
        	title: fileName,
        	width: 900,
        	height: 520,
        	buttons: {
        	Close: function () {
        	$(this).dialog('close');

        	}
        	},
        	open: function () {
        	var path = "http://213.42.28.72:8082/"+fileName1;
        	//var path = "http://localhost:8085/"+fileName1;
        	
        	console.log(path);
        	var object = "<object data=\"{FileName}\" type=\"application/pdf\" width=\"880px\" height=\"280px\">";
        	object += "If you are unable to view file, you can download from <a href = \"{FileName}\">here</a>";
        	object += " or download <a target = \"_blank\" href = \"http://get.adobe.com/reader/\">Adobe PDF Reader</a> to view the file.";
        	object += "</object>";
//        	object +="<textarea id='w3review' name='w3review' rows='4' cols='70'>"
        	object = object.replace(/{FileName}/g, path );
        	// https://www.w3.org/TR/PNG/iso_8859-1.txt
        	// http://www.orimi.com/pdf-test.pdf
        	$("#dialog").html(object);
        	}
        	});
        	}
        
        
        
	 
        $scope.bookingEdit=function(bookingNo){
        $http.post($stateParams.tenantid+ '/app/salesBooking/edit',bookingNo).success(function(data) {
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

			 if($scope.isEdit == true){
				var val = $scope.bookingData.emptyRepo;
				var List = [ {
		            id : val,
		            text : val
		        }]
				$scope.repoList.push(List[0]);

			 }
		 
});
        }
        
        
	
});

app.controller('poPopupCtrl1', function($scope, $timeout, $stateParams,sharedProperties,toaster,
		$filter, $rootScope, $http, $location, logger, $state, ngDialog,$controller,$injector,validationService) {
	
	console.log("entry view");

	$scope.container = {
			containerId:'',
			containerNo:'',
			containerType : '',
			cmsCode : '',
			statusDate : '',
			depot:'',
			formCode:'',
			blNo:''
			
	}
    $scope.rowCollection1 = [];
	
	
	$scope.blNo = $location.search().blNo;   
	$scope.bookingNo = $location.search().bookingNo;  
	$scope.from = $location.search().from;  
	console.log("blNo123", $scope.blNo);
	
	  $scope.socList = [
	       {id: '1', text: 'Yes'},
	    {id: '2', text: 'No'}, 
	     ];
	  
	   $scope.fleList = [
		       {id: '1', text: 'F'},
		    {id: '2', text: 'L'}, 
		 {id: '3', text: 'E'} 
	     ];
	
	$http.get($stateParams.tenantid+'/api/inWard/getContainerList').success(function(datas) {
        $scope.containerList = datas;
        console.log("getContainerList",$scope.containerList);
    });
	
	   $http.get($stateParams.tenantid+'/api/inWard/getPackageTypeList').success(function(datas) {
	        $scope.packageList = datas;
	    });
	    
	
	
    $http.get($stateParams.tenantid+ '/app/commonUtility/getContainerTypeList').success(function(data1) {
		$scope.containerTypeList = data1.containerTypeList;
	});

	$scope.test = $rootScope.containerNo;
	 $scope.container.containerNo = $rootScope.containerNo;
	 
	 $scope.test1 = $rootScope.containerId;
	 $scope.container.containerId = $rootScope.containerId;
	 
	
	 $http.post($stateParams.tenantid+'/api/containerBank/popuplist?containerId=' +$scope.container.containerId).success(function(result) {
		 $scope.rowCollection1 = result.detailList;
		 
 });
	 
	//----------------------------------------------------------------------------------------------------------------------------
	  //for shipping bills files 
     $http.get($stateParams.tenantid+ '/api/inWard/getShippBillFiles?blNo=' +$scope.blNo).success(function(dataList) {
			console.log(dataList);
			$scope.exportShippingBillFiles = [];
			$scope.exportShippingBillFiles = dataList;

		});
     

     $scope.downloadNewBillFile = function(id) {
         debugger;  
//         alert("inside 123");
         document.getElementById('tbnewShippBill'+id).click();
     }
     
     $scope.deleteShippBillfiles = function(filename) {
    	    $scope.tempfiles = []; 
    	    $scope.DBdelete= [];
    	    $scope.tempfilename = [];
    	    
    	    angular.forEach($scope.exportShippingBillFiles, function(row, index) {
    	        if (filename != row.filename) {
    	            $scope.tempfilename.push(row);
    	           // $scope.exportShippingBillFilesFileName.push('filePath/'+ row.filename);
    	        }else{
    	        	 $scope.DBdelete.push(row);
    	        }
    	    });
    	   
    	    $scope.files = $scope.tempfiles;
    	    $scope.exportShippingBillFiles = $scope.tempfilename;
    	    
    	   	 if ($scope.DBdelete.length > 0) {  		 
    	        angular.forEach($scope.DBdelete, function(ddaa, index) { 
    	        	$http.get($stateParams.tenantid+'/api/inWard/deleteShippBill?uID='+ddaa.uid+'&blNo='+ddaa.blNo).success(function(datas) {
    	       	 
    	        });
    	        	});

    	   }
    	  	      
    	}
     
     
     $scope.checkundefined = function(value) {
	 		var invalid = false;
	 		if (value == undefined || value == 'undefined'
	 				|| value == null || value == 'null'
	 				|| value == '') {
	 			invalid = true;
	 		}
	 		return invalid;
	 		

	 	}
     
   //Rate Deviation Approval Files
     $scope.data = {
    	        files : [] 

    	};

    	$scope.files = [];
    	$scope.files1 = [];
    	$scope.files2 = [];

     $rootScope.uploadFile = function(element) {
     	 for(var i=0;i<element.files.length;i++){
        $scope.excelfile = element.files[i];
        
     	 }
     }
     
     $scope.rateDeviationFiles=[];
     $scope.rateDeviationFilesFileName=[];

     $scope.addRateDeviationFile = function(){
         var obj = []

         if ($scope.checkundefined($scope.excelfile)) {
             logger.logError("Please select the file");
         } else {
             obj = $filter('filter')($scope.rateDeviationFiles, {
                 filename : $scope.excelfile.name
             }, true);
         }

         if (obj != undefined && obj.length > 0) {
             logger.logError($scope.excelfile.name + " same file already added");
         } else {
             $scope.files2.push($scope.excelfile);
             $scope.rateDeviationFiles.push({
                 filename : $scope.excelfile.name,
                 filepath : '',
                 employeeId : ''
             });

         }
         
       	 //Rate Deviation Approval
       	 
	       	if ($scope.files2.length > 0) {
              angular.forEach($scope.files2, function(files2, index) {
                  var frmData = new FormData();
                  frmData.append("file2", files2);
                  frmData.append("blNo",$scope.blNo);
                  $.ajax({
                      type : "POST",
                      url : $stateParams.tenantid+"/api/inWard/updateUploadRateDeviationfile",
                      data : frmData,
                      contentType : false,
                      processData : false,
                      success : function(result) {}
                  });
              });

         }
	       	
     }
     
     
     
     $http.get($stateParams.tenantid+ '/api/inWard/getRateDeviationFiles?blNo=' +$scope.blNo).success(function(dataList) {
			console.log("getRateDeviationFiles",dataList);
			  $scope.rateDeviationFiles = [];
			$scope.rateDeviationFiles = dataList;
			

		});
     
     $scope.downloadRateDeviationFile = function(id) {
    	    debugger;    
    	    document.getElementById('rateDeviationBill'+id).click();
    	}
     
     

     $scope.deleteRateDeviationfiles = function(filename) {
         $scope.tempfiles = [];
         $scope.tempfiles1 = [];
         $scope.DBdelete= [];
         $scope.tempfilename = [];
         //$scope.exportShippingBillFiles=[];
         angular.forEach($scope.files2, function(row, index) {
             if (filename != row.name) {
                 $scope.tempfiles.push(row);
                 $scope.tempfiles1.push(row);
             }
         });
         angular.forEach($scope.rateDeviationFiles, function(row, index) {
             if (filename != row.filename) {
                 $scope.tempfilename.push(row);
                 $scope.rateDeviationFilesFileName.push('filePath/'+ row.filename);
             }else{
             	 $scope.DBdelete.push(row);
             }
         });
        
         $scope.files = $scope.tempfiles;
         $scope.rateDeviationFiles = $scope.tempfilename;
         $scope.files2 =$scope.tempfiles1;

         
       	 if ($scope.DBdelete.length > 0) {  		 
             angular.forEach($scope.DBdelete, function(ddaa, index) { 
             	$http.get($stateParams.tenantid+'/api/inWard/deleteRateDeviation?uID='+ddaa.uid+'&blNo='+ddaa.blNo).success(function(datas) {
            	 
             });
             	});

        }
       	      
     }

     
     
     //----------------------------------------------------------------------------------------------------------------------------
     
	
	 $scope.closePopup = function(){
	        ngDialog.close();
	        $state.reload();
	  }
	 
	 
	 
	 $scope.cancel = function() {
		 if($scope.from=='bl'){
			 $state.go('app.documentation.inwardbladding.inwardlist');
		 }
		 else if($scope.from=='bldraft'){
			 $state.go('app.documentation.inWardbldraft.inWardbldraftlist');
		 }
		 else if($scope.from=='conTrack'){
			 $state.go('app.cim.containerBank.containerBankList');
		 }
		 else if($scope.from=='BLTrack'){
			 $state.go('app.trackAndtrace.BLtracking.list');
		 }
		 /*else if($scope.from=='dashboard'){
			 $state.go('dashboard.list');
		 }*/
		 else{
			 $state.go('app.cim.containerBank.containerBankList');

		 }
	 }
	 
	  
	 
	 $scope.downloadNewFile = function(id) {
		    debugger;
		    
		    document.getElementById('tbnewExport'+id).click();

		}
	 
	
	 $scope.getBLdDetailList = function() {
			var vessel= $rootScope.values.vessel;
	     	var voyage= $rootScope.values.vslVoyage;
	      $http.get($stateParams.tenantid+"/api/inWard/view?blNo="+ $scope.blNo+'&vessel='+vessel+'&voyage='+voyage).success(function(response) {
	       	 console.log("BL Detail Datas",response);
	         $scope.blDetailList = response;
	         $scope.bookingNo=response.bookingno;
	         if(response.terms!=null){
	        	 if(response.terms=='1'){
	        		 response.terms= 'Collect';
	        	 }else if(response.terms=='2'){
	        			 response.terms='Prepaid';
	        	 }else if(response.terms=='3'){
	        		 response.terms= 'Third Pary Collect'
	        			 } 
	         }
	       	$scope.exportDeclarationDocFiles=[];
        	if($scope.blDetailList.exportDeclarationDoc !=null  && $scope.blDetailList.exportDeclarationDoc !=""){
        		
        	var filesList = $scope.blDetailList.exportDeclarationDoc.split(","); 
        	for(i=0;i<filesList.length;i++){
        		 var str = filesList[i].split("/"); 
         		  console.log("str",str);
         		  $scope.exportDeclarationDocFiles.push({
         	             filename : str[str.length - 1],
         	             filepath : filesList[i],
         	            
         	         });
        	}
      		 
        }
	         for(var i=0; i < $scope.blDetailList.blcntrDtlList.length;i++){
          		$scope.blDetailList.blcntrDtlList[i].cntrNo=response.blcntrDtlList[i].cntrNo.toString();
          		$scope.blDetailList.blcntrDtlList[i].type=response.blcntrDtlList[i].conType.toString();
          	 
          	}
	   
	         $scope.bookingEdit(response.bookingno);
	        });
	    }
	    $scope.getBLdDetailList();
	    
	    
        $scope.userLogHistory = function(){
        	$http.get($stateParams.tenantid+'/api/inWard/getUserlogHistory?blNo='+$scope.blNo).success(function(result) {
             	$scope.rowCollection=result.userLogHistoryList;
             	console.log("getUserlogHistory",$scope.rowCollection);
             
         }).error(function(data) {
            console.log("data" + data);
        });
        }
        $scope.userLogHistory();
        
        
        
        
      //Destination Charges


        $scope.bldesCurrency="";
        $scope.paymentTerms="";
        $scope.destinationCharges = function(){
        	$http.get($stateParams.tenantid+'/api/inWard/getdestinationCharges?blNo='+$scope.blNo).success(function(result) {
        		$scope.paymentTerms = result.terms;
        		console.log("$scope.paymentTerms",$scope.paymentTerms);
        		$scope.destinationCharge = result.destinationCharge;
        		console.log("$scope.destinationCharge",$scope.destinationCharge);
             	$scope.bldesChargesList=result.destinationChargesList;
             	$scope.bldesCurrency = $scope.bldesChargesList[0].currency;
             	console.log("$scope.bldesCurrency",$scope.bldesCurrency);
             	console.log("destinationCharges",$scope.bldesChargesList);
             
         }).error(function(data) {
            console.log("data" + data);
        });
        	
        }
        $scope.destinationCharges();
        
        
        //BL Invoice
        
       $scope.getInvoiceList=function(){
    	   console.log("blInvoiceData");
        	$http.get($stateParams.tenantid+'/api/inWard/getblInvoiceList?blNo='+$scope.blNo).success(function(response) {
                $scope.blInvoiceDataList = response.blInvoiceList;
                console.log("blInvoiceData",response);
                console.log("blInvoiceData123", $scope.blInvoiceData);
            });


        }
        $scope.getInvoiceList();
        
        //CashBank Receipt
        
        $scope.getCollectionList=function(){
     	   console.log("getCollectionListData");
         	$http.get($stateParams.tenantid+'/api/inWard/getCollectionList?blNo='+$scope.blNo).success(function(response) {
               $scope.blCollectionsDataList = response.blCollectionsList;
                 console.log("getCollectionList",response);
             });


         }
         $scope.getCollectionList();
        
        
        
        //BL Attachments

        $scope.blAttachments = function(){
        	$http.get($stateParams.tenantid+'/api/inWard/getblAttachments?blNo='+$scope.blNo).success(function(result) {
        		$scope.blAttach = result.blAttachmentList;
        		console.log("blAttachments",$scope.blAttach);
             
         }).error(function(data) {
            console.log("data" + data);
        });
        	
        }
        $scope.blAttachments();


        $scope.downloadblAttachFile = function(id) {
            debugger;    
            document.getElementById('bldownloadFiles'+id).click();
        }
        var fileName = "Sample Frame"; 

        $scope.openFileSample = function(fileName1){
        	console.log('inside the dialog function1',fileName1);
        	
        	$("#dialog").dialog({
        	modal: true,
        	title: fileName,
        	width: 900,
        	height: 520,
        	buttons: {
        	Close: function () {
        	$(this).dialog('close');

        	}
        	},
        	open: function () {
        	var path = "http://213.42.28.72:8082/"+fileName1;
        	//var path = "http://localhost:8085/"+fileName1;
        	
        	console.log(path);
        	var object = "<object data=\"{FileName}\" type=\"application/pdf\" width=\"880px\" height=\"280px\">";
        	object += "If you are unable to view file, you can download from <a href = \"{FileName}\">here</a>";
        	object += " or download <a target = \"_blank\" href = \"http://get.adobe.com/reader/\">Adobe PDF Reader</a> to view the file.";
        	object += "</object>";
//        	object +="<textarea id='w3review' name='w3review' rows='4' cols='70'>"
        	object = object.replace(/{FileName}/g, path );
        	// https://www.w3.org/TR/PNG/iso_8859-1.txt
        	// http://www.orimi.com/pdf-test.pdf
        	$("#dialog").html(object);
        	}
        	});
        	}
        
        
        
        
        
        
        
        
        
        
        
        
        
        
	 
        $scope.bookingEdit=function(bookingNo){
        $http.post($stateParams.tenantid+ '/app/salesBooking/edit',bookingNo).success(function(data) {
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

			 if($scope.isEdit == true){
				var val = $scope.bookingData.emptyRepo;
				var List = [ {
		            id : val,
		            text : val
		        }]
				$scope.repoList.push(List[0]);

			 }
		 
});
        }
        
        
	
});
