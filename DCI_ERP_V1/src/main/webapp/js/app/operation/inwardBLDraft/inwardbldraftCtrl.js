'use strict';

app.controller('inwardbldraftCtrl', function($scope, $rootScope,ngDialog, $http, $location, logger,
        utilsService,$state,sharedProperties,$window,validationService,toaster,$stateParams,$controller) {
	    $scope.dataLoopCount = 0;
	    $scope.offsetCount = 0;
	    $scope.limitCount = 1000;
	    $scope.updatedData = [];
	    $scope.rowCollection = [];
	    $scope.displayedCollection = [];
	    $scope.itemsByPage = 10;
	    $scope.detailList=[];
	    $scope.isRemarks = false;
		$scope.vesselList = [];
		$scope.voyageList = [];
		 $scope.blInventroy = "";
		 $scope.blLocation = "";
		 $scope.hideAddIcon=true;
	   
   $scope.add = function() {
	   localStorage.setItem('blSearchObj',JSON.stringify($scope.blSearch));
    	 $state.go('app.documentation.inwardbldraft.inwardbldraftAdd',{tenantid:$stateParams.tenantid});
    };
    
   
		 
		 $scope.viewBlDetail = function(blNo){
		  		ngDialog.close();
		  		$location.url($stateParams.tenantid+'/reports/BLDetail?blNo='+blNo+'&from=bldraft');
		  	 };
   
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
    
    $scope.blSearch = {
    		vessel:'',
    		voyage:'',
    		pol:'',
    		fpod:'',
    		blNo:'',
    		checked:'',
    		cancelBl:'',
    		dateFrom:'',
    		dateTo:''
    };
    
    
    
    $scope.checked1=false;
    
    
    
    if(localStorage.getItem('blSearchObj')!=null && localStorage.getItem('blSearchObj')!=undefined){
		$scope.blSearch = JSON.parse(localStorage.getItem('blSearchObj'));
	}
    
   
    
    $scope.getBlList = function() {
			if($scope.blSearch.checked==true){
				$scope.checked1=true;
				 $http.post($stateParams.tenantid+'/api/inWard/list1',$scope.blSearch).success(function(datas) {
				        $scope.rowCollection = datas;
				        console.log("$scope.rowCollection1111",$scope.rowCollection);
				        }).error(function(datas) {
				    });
			}else{
				 $http.post($stateParams.tenantid+'/api/inWard/BLDraftlist',$scope.blSearch).success(function(datas) {
				        $scope.rowCollection = datas;
				       
				        console.log("$scope.rowCollection2222",$scope.rowCollection);
				       

				        }).error(function(datas) {
				    });
				$scope.checked1=false;
			}
			
			
		};

$scope.getBlList();





		$scope.approveBLDraft = function(blNo,sobDate,hsCode,fpodcode,blFreedays) {
			$scope.hsCode =hsCode;
			$scope.fpodCode=fpodcode;
			$scope.sobDate = sobDate;
			$scope.blFreedays = blFreedays;
			console.log("blFreedays",$scope.blFreedays);
			$scope.showInvoice = false;
			if($scope.sobDate){
	 		var dateParts = $scope.sobDate.split("/");
	 		var dateObject = new Date(+dateParts[2], dateParts[1] - 1, +dateParts[0]);
	 		console.log("dateObject",dateObject);
	 		dateObject.setDate(dateObject.getDate() + $scope.blFreedays);
	 		console.log("dateObject",dateObject);
	 		var formattedDate = moment(dateObject).format('DD/MM/YYYY');
	 		console.log("formattedDate",formattedDate);

	 		var currdate = new Date();
	 		var currentDate = moment(currdate).format('DD/MM/YYYY');
	 		console.log("currentDate",currentDate);
	 		
	 		
	 		if(currdate > dateObject){
	 			$scope.showInvoice = true;
	 		}else
	 			{
	 			$scope.showInvoice = false;
	 			
	 			}
			}
	 		
			console.log("approveBLDraft",blNo,sobDate);
			 ngDialog.close();
		 		ngDialog.open({
		 			template : 'BLFeeDetail',
		 			scope : $scope
		 		});
		 		$scope.DraftBLNO = blNo;
		 	
		 		
		 		//var checkSameDate = currdate > dateObject;
		 		//console.log("checkSameDate",checkSameDate);
		 		
		 			
		 		
		 		

		 		
		}
		
		$scope.ba={
				blDraftDescription:'',
				blInvoiceNo:''
		};
		
		
		//$scope.blInvoiceNo = "";
		$rootScope.CheckBLDraft=function(blDraftDescription,blInvoiceNo){
			console.log("blDraftDescription,blInvoiceNo",blDraftDescription,blInvoiceNo);
			$scope.validation =true;
			if($scope.showInvoice){
			if(!blInvoiceNo ){
					$scope.validation =false;
				}
			}
			
			
			 var count = 0;
			 var fpod =$scope.fpodCode.substring(0, 5);
			 console.log("fpod1222222222",fpod);
			 
			 if(fpod == 'AEJEA' || fpod == 'DJJIB'){
				 count = 1;
			 }
			 
			 if(count>0 && !$scope.hsCode)
				{	 
					 logger.logError(" No shipments will be accepted without HS Code for this port.");
		     	  
				}else{
			 
			if($scope.validation){
				
					$http.get($stateParams.tenantid+'/api/inWard/approveBFDraft?blDraftDescription='+blDraftDescription+'&blInvoiceNo='+blInvoiceNo+'&blNo='+$scope.DraftBLNO).success(function(datas) {
						if(datas.isSuccess){
							   ngDialog.close();
							   $scope.getBlList();
							   logger.logSuccess(datas.message);
						}
						else{
							   console.log("INSIDE THE FALSE",datas.message);
							   logger.logError(datas.message);
						}
			        }).error(function(datas) {
			        	 console.log("inside error",datas);
			    });
			
			}
			
			
			
			else{
				
				logger.logError("Please enter Invoice number to approve the bl");
			}
				}
		}
		

		//Send BL Draft Mail
		
	/* 
	  $scope.sendBLDraftMailprint = function(blNo) {
			   $http.get($stateParams.tenantid+'/api/inWard/sendMailPrint?blNo='+blNo).success(function(datas) {
				   if(datas.success==true){
					   logger.logSuccess(datas.message);
				   }else{
					   logger.logError(datas.message);
				   }
			   });   
		      
		};   
		*/
   
    //Delete Row Funtion
      $scope.deleteRow = function(rowid) {
            ngDialog.openConfirm().then(function() {
                var myURL = $stateParams.tenantid+'/app/master/customerpartner/delete?servicePartnerId='+rowid;
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
                    logger.logSuccess("Error in Delete");
                });
            });

        };
     
    //Edit Row Funtion
    $scope.editRow = function(rowid) {
    	 localStorage.setItem('blSearchObj',JSON.stringify($scope.blSearch));
    	$location.url($stateParams.tenantid+'/documentation/outwardBl/edit?blNo='+rowid+'&from=draft');       
     }
    
    $scope.editCro = function(jobNo  ){
    	 localStorage.setItem('blSearchObj',JSON.stringify($scope.blSearch));
    	$location.url($stateParams.tenantid+'/documentation/outwardBl/add?jobno='+jobNo);
    	}
    
    //View Funtion
    $scope.view = function(rowid) {
    	 localStorage.setItem('blSearchObj',JSON.stringify($scope.blSearch));
    	$location.url($stateParams.tenantid+'/master/customer/view?rowid='+rowid); 
     }
    
    
    $http.get($stateParams.tenantid+ '/app/commonUtility/getVesselList').success(function(data) {
		$scope.vesselList = data;
	});
    
    
    $scope.$watch('blSearch.vessel', function(newValue, oldValue) {
	      if(newValue!=null && newValue!=undefined && newValue != ''){
	    	  $http.post($stateParams.tenantid+ '/app/commonUtility/getVoyageListByVessel',newValue).success(function(data) {
					$scope.voyageList = data;
	    	  });
	      }
	      
	    });
    
    $http.get($stateParams.tenantid+ '/app/commonUtility/getPort').success(function(data) {
		$scope.podList = data.commonUtilityBean;
	});
    
    
    $scope.$watch('blSearch.voyage', function(newValue, oldValue) {
	      if(newValue!=null && newValue!=undefined && newValue != ''){
	    	  $http.post($stateParams.tenantid+ '/app/commonUtility/getPortListByVoyage',newValue).success(function(data) {
	    		  $scope.polList = data;
	    	  })
	    	  
	     
	      }
	})
	
	$rootScope.closeFileDialog = function() {
			ngDialog.close();
		};
	
	//POP UP printBLOriginal
	
		  $scope.openBLPrint= function(blNo) { 
    	  $http.get('/api/BLInventory/getBranchList').success(function(datas) {
              console.log("getBranchList",datas);
              $scope.branchList = datas.branchList;
              ngDialog.close();
       		ngDialog.open({
       			template : 'BLPrint',
       			scope : $scope
       		});
         	$scope.PrintBLNO = blNo;
              }).error(function(datas) {
          });
  	
    	  }
    
    
    
  //BL PRINT
	
	   $rootScope.CheckBLNumber=function(location,blSerialNo){
		   console.log("location serial no",location,blSerialNo);

	  $http.get('/api/BLInventory/getBLNumberCheck?location='+location+'&serial_seqNo='+blSerialNo).success(function(datas) {
       console.log("getBLNumberCheck",datas);
       if(datas.success){
    	   ngDialog.close();
    	   $scope.printBLOriginal($scope.PrintBLNO,location,blSerialNo)
       }
       else{
    	   console.log("INSIDE THE FALSE",datas.message);
    	   logger.logError(datas.message);
       }
       }).error(function(datas) {
    	   console.log("inside error",datas);
   });
}

	   
	   $scope.printBLOriginalStationary = function(blNo) {
	    	   
	    	
	        $http.get($stateParams.tenantid+'/api/inWard/checkBLSurrenderOrNot?blNo=' +blNo).success(function(result) {

	        	if(result.blrelease == false){
	        		
	        	
	  
	        $http.get($stateParams.tenantid+'/api/billofLading/printcountOrgnlSta?blNo=' +blNo).success(function(result) {
	           if(result.message != null && result.message != ''){
	        	   logger.logError(result.message);
	           }
	           else{
	        	   var url = $stateParams.tenantid+'/api/inWard/printbloutwardoriginalSta?blNo=' + blNo;
	               if(result.count <3){
	               var wnd = window.open(url, 'Shipping', 'height=400,width=750,top=100,left=100,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
	               wnd.print();
	           	   } else {
	                      logger.logError("Print limit exceeded");

	           	   }
	           }
	        	
	           });
	        	}else{
	        		logger.logError("BL is Surrendered...Hence cannot able to Print the OBL..");
	        	}
//	        }
	        });
	    };
	    


    
    
    
    
    // 
    $scope.printBLOriginal = function(blNo,location,blSerialNo) {
   console.log("blNo12345",blNo);
    	
        $http.get($stateParams.tenantid+'/api/inWard/checkBLSurrenderOrNot?blNo=' +blNo).success(function(result) {

        	if(result.blrelease == false){
        		
        	
  
        $http.get($stateParams.tenantid+'/api/billofLading/printcountOrgnl?blNo=' +blNo).success(function(result) {
           if(result.message != null && result.message != ''){
        	   logger.logError(result.message);
           }
           else{
        	   var url = $stateParams.tenantid+'/api/inWard/printbloutwardoriginal?blNo=' + blNo;
               if(result.count <3){
            	   $http.get('/api/BLInventory/blNoSave?blNo='+blNo+'&location='+location+'&serial_seqNo='+blSerialNo).success(function(datas) {
             	       console.log("blNoSave",datas);
             	     
             	       }).error(function(datas) {
             	    	   console.log("error in blNoSave",datas);
             	   })
               var wnd = window.open(url, 'Shipping', 'height=400,width=750,top=100,left=100,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
               wnd.print();
               
         	
               
               
           	   } else {
                      logger.logError("Print limit exceeded");

           	   }
           }
        	
           });
        	}else{
        		logger.logError("BL is Surrendered...Hence cannot able to Print the OBL..");
        	}
//        }
        });
    };
    
    
    $scope.view = function(rowid) {
    	$location.url($stateParams.tenantid+'/master/customer/view?rowid='+rowid); 
     }
    
    
    
    $scope.unlockOgs = function(blNo) {
        debugger
          $http.get($stateParams.tenantid+'/api/inWard/unLockOrginalSta?blNo=' +blNo).success(function(result) {
             if(result.isSuccess){
          	   logger.logSuccess("Print limit unlocked successfully - original stationary!");
             }
             else{
          	   logger.logError("Error in Unlock!");
             }
          	
             });
   
      };
    
    // 
    $scope.unlockOg = function(blNo) {
      debugger
        $http.get($stateParams.tenantid+'/api/inWard/unLockOrginal?blNo=' +blNo).success(function(result) {
           if(result.isSuccess){
        	   logger.logSuccess("Print limit unlocked successfully - original normal!");
           }
           else{
        	   logger.logError("Error in Unlock!");
           }
        	
           });
 
    };
    
    $scope.unlockCopy = function(blNo) {
    	debugger
        $http.get($stateParams.tenantid+'/api/inWard/unLockOrginal?blNo=' +blNo).success(function(result) {
           if(result.isSuccess){
        	   logger.logSuccess("Print limit unlocked successfully - copy!");
           }
           else{
        	   logger.logError("Error in Unlock!");
           }
        	
           });
 
    };
    
    
    
  
    
    //Print Copy Funtion
    $scope.printBLCopy = function(blNo) {
    	 $scope.userId=$('#empId').val();
       /* if (utilsService.isUndefinedOrNull(selection)) {
            logger.logError("Please select Drop down");
        } else if (utilsService.isUndefinedOrNull(printinvoicevalue)) {
            logger.logError("Please Enter Invoice Number");
        } else {*/
      /*  $http.get($stateParams.tenantid+'/api/billofLading/printcountCopy?blNo=' +blNo).success(function(result) {
            if(result.message != null && result.message != ''){
         	   logger.logError(result.message);
            }
            else{*/
    	 
    	 $http.get($stateParams.tenantid+'/api/inWard/checkSailingDate?blNo=' +blNo).success(function(result) {
    		 debugger;
             if(!result.isSuccess ){
          	   logger.logError(result.message);
             }else{
            	 var url = $stateParams.tenantid+'/api/inWard/printbldraftcopy?blNo=' + blNo;
                 // if((result.count < 3) || ($scope.userId=='E0001')){
                  var wnd = window.open(url, 'Shipping', 'height=400,width=750,top=100,left=100,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
                  wnd.print();
             }
    	 
    	 });
        	
            /*   } else {
                   logger.logError("Print limit exceeded");

        	   }
           }
           });*/
//        }

    };
    
        $scope.printBLCopy = function(blNo) {
    	 $scope.userId=$('#empId').val();
    	 
    	 $http.get($stateParams.tenantid+'/api/inWard/checkSailingDate?blNo=' +blNo).success(function(result) {
    		 debugger;
             if(!result.isSuccess ){
          	   logger.logError(result.message);
             }else{
    	 
    	 
      
        	var url = $stateParams.tenantid+'/api/inWard/printbldraftcopy?blNo=' + blNo;
            var wnd = window.open(url, 'Shipping', 'height=400,width=750,top=100,left=100,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
            wnd.print();
             }
    	 });
        
    };
    
    //arrival Notice
    
    $scope.printArrival = function(data){

     	  var blNo = data;
     	 
       	  var url = $stateParams.tenantid+'/api/vesselArrival/CargoPrint?blNo='+blNo;
     			var wnd = window.open(url, 'Shipping', 'height=400,width=750,top=100,left=100,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
     	      wnd.print();
        
        // var blNo='BL876155';

     }
    
    
    /// Cancel Bl 
    
    $scope.cancelBl = function(blNo) {
		 $rootScope.blNotoCancel = blNo;
				 ngDialog.open({
				        scope : $scope,
				        template : 'BlCancelPopup',
				        controller : $controller('blCancelpopctrl', {
				            $scope : $scope
				        }),
				        className : 'ngdialog-theme-plain',
				        showClose : true,
				        closeByDocument : false,
				        closeByEscape : false

				    });
			
	
	};
	
	/// Reset 
	
	$scope.reset = function(){
		  $scope.blSearch = {
		    		vessel:'',
		    		voyage:'',
		    		pol:'',
		    		fpod:'',
		    		blNo:'',
		    		checked:'',
		    		cancelBl:'',
		    };
		  $scope.getBlList();
	}
	
	
	
	//Delete BL Draft
	

	$scope.deleteBLDraft = function(blNo) {
    	console.log("blNo",blNo);
        ngDialog.openConfirm().then(function() {
            var url =$stateParams.tenantid+'/api/inWard/deleteBLDraft?blNo=' + blNo;
             $http.get(url).success(function(data) {
            	 console.log("dlete bl draft",data);
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
    
	
	
	 //Excel Export	
	 $scope.exportExcel = function(){

	            $http.post($stateParams.tenantid+'/api/inWard/excelExport', $scope.blSearch).success(function(response) {
	                if(response){
	                    debugger;
	                    $("#Export").bind('click', function() {
	                    });
	                    $('#Export').simulateClick('click');
	                    logger.logSuccess("Exported successfully!");
	                }else{
	                    logger.logError("Failed to export");
	                }
	                
	            }).error(function(response) {
	                logger.logError("Error Please Try Again");
	            });
	    
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
	  
	  $scope.invoiceData = {
		   		 invoiceNo :'',
		   		 agent : '',
		   		 agentName : '',
		   		 blNo : '',
		   		 billDate: '',
		   		 pol: '',
		   		 mode :'',
		   		agentNameview : '',
		   		 customer: '',
		   		 customerName: '',
		   		 vessel: '',
		   		 vesselName: '',
		   		 voyage: '',
		   		 voyageName: '',
		   		 bookingNo: '',
		   		 total : 0,
		   		 grandTotal: 0,
		   		 quotation : '',
		   		 exchangeRate : 1.0,
		   		 currency : '',
		   		 chargesDetails : [],
		   		 detailList	: []
		    }
	  
	  $scope.sendMailprint = function(blNo) { 
		  debugger;
		  //$http.post($stateParams.tenantid+ '/app/invoice/getInvoiceDetails',blNo).success(function(data) {
		  $http.get($stateParams.tenantid+'/app/invoice/getInvoiceDetails?blNo=' + blNo +'&checktype=' +blNo).success(function(data) {

	   		  if(data.success==true){
	   			  	$scope.invoiceData = data.invoiceBean;
						$scope.invoiceData.detailList =  data.detailList;
						debugger;
						$scope.invoiceData.mode="PP";
		        		var saveInvcData = {
		                        'invoiceBean' : $scope.invoiceData ,
		                };
		          $http.post($stateParams.tenantid+'/app/invoice/save',saveInvcData).success(function(savResult) {
		        	  debugger;
		        	  var invdraftNo = savResult.draftinvoiceNo;
		              
		            	  debugger;
		            	  
		            	  $http.get($stateParams.tenantid+'/app/invoice/sendMailprint?invoiceno='+  invdraftNo+'&blNo='+blNo).success(function(data) {
		            	         if (data == true) {
		            	             logger.logSuccess("Mail sent successfully!");
		            	             ngDialog.close();
		            	         }else{
		            	             logger.logError("Unable to send Email");
		            	         }
		            	     }).error(function(data) {
		            	         console.log("data" + data);
		            	     });
		            	  
		              
		            
		           
		           
		                
		            }).error(function(data) {
		                logger.logError("Error Not Saved!");
		            });
					
	   		  }else{
	   			  logger.logError(data.message);
	   			  $scope.reset();
	   		  }
		 }).error(function(response) {
                logger.logError("Error Please Try Again");
            });

			 
	   }
	  
	  
	  //Send Draft BL 
	  
	  $scope.exportDraftBL = function(blNo) {
		
		  
		  
		 $http.post($stateParams.tenantid+'/app/invoice/sendDraftBL?blNo='+blNo).success(function(data) {
			  console.log("data12233",data);
			  if(data.success){
			  $scope.filename = data.path;
                   debugger;
                   $('.LoadingIndicator').hide();
                   $('#exportDraftBL').remove();
                   $('.test').append('<div id="exportDraftBL"></div>');
                 var file='<a id="downloadcoprarEDI" stype="display:none" href="filePath/'+$scope.filename+'" download="'+$scope.filename+'"></a>'
                       
                          $('#exportDraftBL').append(file);
                          $("#downloadcoprarEDI").bind('click', function() {
                          });
                          $('#downloadcoprarEDI').simulateClick('click');
                          
                     
                      	}else{
                      		logger.logError(data.message);
                      		$('.LoadingIndicator').hide();
                      	}
               
 	       
 	     }).error(function(data) {
 	         console.log("data" + data);
 	     });
	  }
			  

	    //Print Proforma Invoice Funtion
	    
	  $scope.printBLInvoice = function(blNo) {
		  $http.get($stateParams.tenantid+'/app/invoice/getInvoiceDetails?blNo=' + blNo +'&checktype=' +blNo).success(function(data) {
         //	 $http.post($stateParams.tenantid+ '/app/invoice/getInvoiceDetails',blNo).success(function(data) {
		   		  if(data.success==true){
		   			  	$scope.invoiceData = data.invoiceBean;
							$scope.invoiceData.detailList =  data.detailList;
							debugger;
							$scope.invoiceData.mode="PP";
			        		var saveInvcData = {
			                        'invoiceBean' : $scope.invoiceData ,
			                };
			          $http.post($stateParams.tenantid+'/app/invoice/save',saveInvcData).success(function(savResult) {
			        	  debugger;
			        	  var invdraftNo = savResult.draftinvoiceNo;
			              
			            	  debugger;
			                  var url = $stateParams.tenantid+'/app/invoice/printproformainvoice?invoiceno=' + invdraftNo;
			                  var wnd = window.open(url, 'Simatech', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
			                  wnd.print();
			            
			           
			           
			                
			            }).error(function(data) {
			                logger.logError("Error Not Saved!");
			            });
						
		   		  }else{
		   			  logger.logError(data.message);
		   			  $scope.reset();
		   		  }
			 }).error(function(response) {
	                logger.logError("Error Please Try Again");
	            });
        
	    };
	    
	  
	  
      
    $scope.mailview = function(data) {
	var blNo = data;
	
    if(blNo =="" || blNo ==undefined){
       // logger.logError("");
    }else{
    
    	$.ajax({
            type : "GET",
            url : $stateParams.tenantid + '/api/vesselArrival/getCountryMail?blNo='+blNo,
            data : "",
            async: false,
            contentType: false,
            processData: false,
            success : function(response) {
            	if(response == "IN"){
            		
          	      ngDialog.open({
                        scope : $scope,
                        template : 'views/mis/marketing/viewMailIndia',
                        controller : $controller('cargoarrivalmailViewCtrl', {
                            $scope : $scope,
                            blNo: blNo,
                           // screenName: 'SeaQuotationmailView'
                        }),
                        className : 'ngdialog-theme-plain',
                        showClose : false,
                        closeByDocument : false,
                        closeByEscape : false,
                        preCloseCallback : $scope.getList
                    });
          		
          		
          	}else if(response == "SG"){
          		
        	      ngDialog.open({
                    scope : $scope,
                    template : 'views/mis/marketing/viewMailSingapore',
                    controller : $controller('cargoarrivalmailViewCtrl', {
                        $scope : $scope,
                        blNo: blNo,
                       // screenName: 'SeaQuotationmailView'
                    }),
                    className : 'ngdialog-theme-plain',
                    showClose : false,
                    closeByDocument : false,
                    closeByEscape : false,
                    preCloseCallback : $scope.getList
                });

          	}
          	else{
          		
          		ngDialog.open({
                      scope : $scope,
                      template : 'views/mis/marketing/viewMailGeneral',
                      controller : $controller('cargoarrivalmailViewCtrl', {
                          $scope : $scope,
                          blNo: blNo,
                         // screenName: 'SeaQuotationmailView'
                      }),
                      className : 'ngdialog-theme-plain',
                      showClose : false,
                      closeByDocument : false,
                      closeByEscape : false,
                      preCloseCallback : $scope.getList
                  });
          		
          		
          		
          	}
            }
        });
    	
    	
  
    }
};
    
    
    
    app.controller('cargoarrivalmailViewCtrl',
			function($scope, $timeout, $stateParams, sharedProperties,
					toaster, $filter, $rootScope, $http, $location, logger,
					$state, ngDialog, $controller, $injector,blNo) {
  
  //alert("dialog"+quotationid);
 
  var tenantId = $stateParams.tenantid;
  
  var blNo = blNo;
  
  $scope.viewmaildata = function(){
		$http.get($stateParams.tenantid + '/api/vesselArrival/viewMail?blNo='+blNo)
		.success(function(datas) {
			console.log(datas);
			$scope.hdr=datas.bean;
			$scope.detailList=datas.detailList;
			//logger.logSuccess('Mail Sent Successfully!')
		}).error(function(data) {

		});
	}
  $scope.viewmaildata();
  
 
  $scope.closedialog = function(){
	  ngDialog.close();
	  
  }
  var usermailId='';
  
  $scope.sendmail = function(data){
	  $scope.getuserdetail();
		$http.get($stateParams.tenantid + '/api/vesselArrival/sendMail?blNo='+blNo)
		.success(function(datas) {
			//console.log(datas);
			/*logger.logSuccess('Mail Sent Successfully to '+' '+usermailId)*/
			logger.logSuccess('Mail Sent Successfully ')
		}).error(function(data) {

		});
	}
  
  
  $scope.getuserdetail = function(){
	  
	  $http.get($stateParams.tenantid + '/app/commonUtility/getUserdetail')
		.success(function(datas) {
			console.log(datas);
			usermailId =datas.airQuotationBean.employeeEmail

			//logger.logSuccess('Mail Sent Successfully!')
		}).error(function(data) {

		});
  }
  
			});
    $scope.viewRemarks =function(blNo,pol,pod,fpod,fpodcode,vslVoyage,polcode){
		   $rootScope.blNo = blNo;
		   $rootScope.polcode = polcode;
		   $rootScope.fpodcode = fpodcode;
		   $rootScope.pol = pol;;
		   $rootScope.pod = pod;
		   $rootScope.fpod = fpod;
		   $rootScope.vslVoyage = vslVoyage;


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
	       /* preCloseCallback : $scope.getList,
	        
         closeByEscape : false*/

	    });
	    
	    
	};
	
	$scope.closeUpload = function() {
		ngDialog.close();
	}
	


    
});



