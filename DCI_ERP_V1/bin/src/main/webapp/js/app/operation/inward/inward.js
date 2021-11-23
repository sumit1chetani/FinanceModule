'use strict';

app.controller('bladdingCtrl1', function($scope, $rootScope,ngDialog, $http, $location, logger,
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
	   

		 
    $scope.add = function() {
    	 localStorage.setItem('blSearchObj',JSON.stringify($scope.blSearch));
    	 $state.go('app.documentation.inwardbladding.inwardadd',{tenantid:$stateParams.tenantid});
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
    		checked:false,
    		cancelBl:'',
    		dateFrom:'',
    		dateTo:''
    };
    
    
    
    $scope.checked1=false;
    
    if(localStorage.getItem('blSearchObj')!=null && localStorage.getItem('blSearchObj')!=undefined){
		$scope.blSearch = JSON.parse(localStorage.getItem('blSearchObj'));
	}
   
    

 	//BL View 
  	
  	
  	 $scope.viewBlDetail = function(item,blNo){
  		ngDialog.close();
   	    $rootScope.values=item;
  		$location.url($stateParams.tenantid+'/reports/inWardBLDetail?blNo='+blNo+'&from=bl');
  	 };
    
    
    
    
    $scope.getBlList = function() {
			if($scope.blSearch.checked==true){
				$scope.checked1=true;
				 $http.post($stateParams.tenantid+'/api/inWard/list1',$scope.blSearch).success(function(datas) {
				        $scope.rowCollection = datas;
				        console.log("$scope.rowCollection1",$scope.rowCollection);
				        }).error(function(datas) {
				    });
			}else{
				 $http.post($stateParams.tenantid+'/api/inWard/list',$scope.blSearch).success(function(datas) {
				        $scope.rowCollection = datas;
				        console.log("$scope.rowCollection2",$scope.rowCollection);
				        }).error(function(datas) {
				    });
				$scope.checked1=false;
			}
			
			
		};

$scope.getBlList();
    
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
    $scope.editRow = function(item,rowid) { 
    	 localStorage.setItem('blSearchObj',JSON.stringify($scope.blSearch));
	 		/*angular.forEach($scope.rowCollection, function(value, index) { 	
	 			if(value.blNo==rowid){
	 				$rootScope.values=value;
	 			}
	 			
	 		})*/
    	 $rootScope.values=item;
    	$location.url($stateParams.tenantid+'/documentation/inwardBl/edit?blNo='+rowid);       
     }
    
    $scope.editCro = function(jobNo  ){
    	 localStorage.setItem('blSearchObj',JSON.stringify($scope.blSearch));
    	$location.url($stateParams.tenantid+'/documentation/inwardBl/add?jobno='+jobNo);
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
	//Consolidated BLClose
		$rootScope.closeConsolFileDialog = function() {
			ngDialog.close();
		};
		
		
	//POP UP printBLOriginal
	//printBLOriginalStationary(item.blNo)
		  $scope.openBLPrint= function(blNo) { 
    	  $http.get($stateParams.tenantid+'/app/commonUtility/getPortList').success(function(datas) {
              console.log("getBranchList",datas);
              $scope.portList = datas;
              ngDialog.close();
       		ngDialog.open({
       			template : 'BLPrint',
       			scope : $scope
       		});
         	$scope.PrintBLNO = blNo;
              }).error(function(datas) {
          });
  	
    	  }
		  
	//openConsolidatedPrint
		  $scope.openConsolidatedPrint= function(blNo) { 
	    	  $http.get($stateParams.tenantid+'/app/commonUtility/getPortList').success(function(datas) {
	              console.log("getBranchList",datas);
	              $scope.portList = datas;
	              ngDialog.close();
	       		ngDialog.open({
	       			template : 'ConsolidatedBLPrint',
	       			scope : $scope
	       		});
	         	$scope.PrintBLNO = blNo;
	              }).error(function(datas) {
	          });
	  	
	    	  }
    
    
    
  //BL PRINT
	
	   $rootScope.CheckBLNumber=function(location,blSerialNo){
		   console.log("location serial no",location,blSerialNo);

	  $http.get('/api/BLInventory/getBLNumberCheck?serial_seqNo='+blSerialNo).success(function(datas) {
       console.log("getBLNumberCheck",datas);
       if(datas.success){
    	   ngDialog.close();
    	   $scope.printBLOriginalStationary($scope.PrintBLNO,location,blSerialNo)
       }
       else{
    	   console.log("INSIDE THE FALSE",datas.message);
    	   logger.logError(datas.message);
       }
       }).error(function(datas) {
    	   console.log("inside error",datas);
   });
}
	   
	   
// Consolidated BL Print
	   $rootScope.CheckConsolidatedBLNumber=function(location,blSerialNo){
		   console.log("location serial no",location,blSerialNo);

	  $http.get('/api/BLInventory/getConsolidatedBLNumberCheck?serial_seqNo='+blSerialNo).success(function(datas) {
       console.log("getBLNumberCheck",datas);
       if(datas.success){
    	   ngDialog.close();
    	  $scope.printConsolidatedBLOriginalStationary($scope.PrintBLNO,location,blSerialNo)
       }
       else{
    	   console.log("INSIDE THE FALSE",datas.message);
    	   logger.logError(datas.message);
       }
       }).error(function(datas) {
    	   console.log("inside error",datas);
   });
}
	   
	   
	   
	   $scope.printBLOriginalStationary = function(blNo,location,blSerialNo) {
	    	   
	    	
	        $http.get($stateParams.tenantid+'/api/inWard/checkBLSurrenderOrNot?blNo=' +blNo).success(function(result) {

	        	if(result.blrelease == false){
	        		
	        	
	  
	        $http.get($stateParams.tenantid+'/api/billofLading/printcountOrgnlSta?blNo=' +blNo).success(function(result) {
	           if(result.message != null && result.message != ''){
	        	   logger.logError(result.message);
	           }
	           else{
	        	   var url = $stateParams.tenantid+'/api/inWard/printbloutwardoriginalSta?blNo=' + blNo;
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
//	        }
	        });
	    };
	    
	    
	//print Consolidated
 $scope.printConsolidatedBLOriginalStationary = function(blNo,location,blSerialNo) {
	    	   
	    	
	        $http.get($stateParams.tenantid+'/api/inWard/checkBLSurrenderOrNot?blNo=' +blNo).success(function(result) {

	        	if(result.blrelease == false){
	        		
	        	
	  
	        $http.get($stateParams.tenantid+'/api/billofLading/consoildatedPrintcountOrgnlSta?blNo=' +blNo).success(function(result) {
	           if(result.message != null && result.message != ''){
	        	   logger.logError(result.message);
	           }
	           else{
	        	   var url = $stateParams.tenantid+'/api/inWard/consolidatedOriginalPrint?blNo=' + blNo;
	               if(result.count <3){
	            	   
	            	   $http.get('/api/BLInventory/consolidatedBLNoSave?blNo='+blNo+'&location='+location+'&serial_seqNo='+blSerialNo).success(function(datas) {
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

	        });
	    };
	    


    
    
    
    
    // 
    $scope.printBLOriginal = function(blNo) {
    	
        $http.get($stateParams.tenantid+'/api/inWard/checkBLSurrenderOrNot?blNo=' +blNo).success(function(result) {

        	if(result.blrelease == false){
        		
        	
  
        $http.get($stateParams.tenantid+'/api/billofLading/printcountOrgnl?blNo=' +blNo).success(function(result) {
           if(result.message != null && result.message != ''){
        	   logger.logError(result.message);
           }
           else{
        	   var url = $stateParams.tenantid+'/api/inWard/printbloutwardoriginal?blNo=' + blNo;
               if(result.count <7){
            	/*   $http.get('/api/BLInventory/blNoSave?blNo='+blNo+'&location='+location+'&serial_seqNo='+blSerialNo).success(function(datas) {
             	       console.log("blNoSave",datas);
             	     
             	       }).error(function(datas) {
             	    	   console.log("error in blNoSave",datas);
             	   })*/
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
    
    
    
    //Convert Sea Waybill
    
    $scope.convertSWB = function(blNo) {
        debugger
          $http.get($stateParams.tenantid+'/api/inWard/convertSeawaybill?blNo=' +blNo).success(function(result) {
             if(result.isSuccess){
          	   logger.logSuccess("Normal BL Converted into Sea Waybill!");
          	   $scope.getBlList();
             }
             else{
          	   logger.logError("Error in Converted into Sea Waybill!");
             }
          	
             });
   
      };
    
    
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
      $scope.unlockConsolidatedOgs = function(blNo) {
          debugger
            $http.get($stateParams.tenantid+'/api/inWard/unLockConsolidatedOrginalSta?blNo=' +blNo).success(function(result) {
               if(result.isSuccess){
            	   logger.logSuccess("Print limit unlocked successfully - Consolidated Original Stationary!");
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
        $http.get($stateParams.tenantid+'/api/inWard/unLockCopy?blNo=' +blNo).success(function(result) {
           if(result.isSuccess){
        	   logger.logSuccess("Print limit unlocked successfully - copy!");
           }
           else{
        	   logger.logError("Error in Unlock!");
           }
        	
           });
 
    };
    
    $scope.unlockCopyWithStationary = function(blNo) {
    	debugger
        $http.get($stateParams.tenantid+'/api/inWard/unLockCopyWithSta?blNo=' +blNo).success(function(result) {
           if(result.isSuccess){
        	   logger.logSuccess("Print limit unlocked successfully - copy!");
           }
           else{
        	   logger.logError("Error in Unlock!");
           }
        	
           });
 
    };
    
  
    
    //Print Copy Funtion
    $scope.printBLCopy = function(item,blNo) {
    	 $scope.userId=$('#empId').val();
       /* if (utilsService.isUndefinedOrNull(selection)) {
            logger.logError("Please select Drop down");
        } else if (utilsService.isUndefinedOrNull(printinvoicevalue)) {
            logger.logError("Please Enter Invoice Number");
        } else {*/
       /* $http.get($stateParams.tenantid+'/api/billofLading/printcountCopy?blNo=' +blNo).success(function(result) {
            if(result.message != null && result.message != ''){
         	   logger.logError(result.message);
            }
            else{*/
    	 
    	
    	 var url = $stateParams.tenantid+'/api/inWard/printbloutwardcop1y?blNo=' + blNo +'&vessel='+item.vessel+'&vslVoyage='+item.vslVoyage;
         //if((result.count < 7) ){
          var wnd = window.open(url, 'Shipping', 'height=400,width=750,top=100,left=100,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
          wnd.print();
        	/*var url = $stateParams.tenantid+'/api/inWard/printbloutwardcopy?blNo=' + blNo;
           //if((result.count < 7) ){
            var wnd = window.open(url, 'Shipping', 'height=400,width=750,top=100,left=100,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
            wnd.print();*/
            /* } else {
                   logger.logError("Print limit exceeded");

        	   }*/
           // }
//          / });
//        }

    };
    
    
    
    //Print Copy WithOut Stationary  Funtion
    $scope.printBLCopyWithStationary = function(blNo) {
    	 $scope.userId=$('#empId').val();
       /* if (utilsService.isUndefinedOrNull(selection)) {
            logger.logError("Please select Drop down");
        } else if (utilsService.isUndefinedOrNull(printinvoicevalue)) {
            logger.logError("Please Enter Invoice Number");
        } else {*/
       $http.get($stateParams.tenantid+'/api/billofLading/printcountCopyWithSta?blNo=' +blNo).success(function(result) {
            if(result.message != null && result.message != ''){
         	   logger.logError(result.message);
            }
            else{
        	var url = $stateParams.tenantid+'/api/inWard/printbloutwardcopyWithStationary?blNo=' + blNo;
            if((result.count < 3)){
            var wnd = window.open(url, 'Shipping', 'height=400,width=750,top=100,left=100,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
            wnd.print();
              } else {
                   logger.logError("Print limit exceeded");

        	   }
             }
           });
//        }

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

app.controller('deliveryOrderpopCtrl', function($scope, $timeout, $stateParams,sharedProperties,toaster,
		$filter, $rootScope, $http, $location, logger, $state, ngDialog,$controller,$injector,validationService) {
	

	$scope.blNoData = {
			blNo:'',
			blrelease:'',
			blreleaseremeraks:'',
			pol:'',
			pod:'',
			fpod:'',
			fpodcode:'',
			vslVoyage:'',
			polcode:''
	}

	 $scope.blNoData.blNo = $rootScope.blNo;
	 $scope.blNoData.fpodcode = $rootScope.fpodcode;
	 $scope.blNoData.pol = $rootScope.pol;
	 $scope.blNoData.pod = $rootScope.pod;
	 $scope.blNoData.fpod = $rootScope.fpod;
	 $scope.blNoData.vslVoyage = $rootScope.vslVoyage;
	 $scope.blNoData.polcode = $rootScope.polcode;

	 
	 $scope.saveData = function(blForm1) {
	 $http.post($stateParams.tenantid+'/api/inWard/popuplist' ,$scope.blNoData).success(function(result) {
		 if (result.isSuccess == true) {
			  ngDialog.close();
	            logger.logSuccess("Updated Successfully!");
	            $state.reload();
	          

	        } else {
	        	logger.logError(result.message);
	        }
	    }).error(function(result) {
	        console.log("data" + result);
		 
 });
	 }
	 $scope.closeUpload = function(){
	        ngDialog.close();
	        $state.reload();
	  }
	 
	
});


app.controller('blCancelpopctrl', function($scope, $timeout, $stateParams,sharedProperties,toaster,
		$filter, $rootScope, $http, $location, logger, $state, ngDialog,$controller,$injector,validationService) {
	

	$scope.bl = {
			blCancelreason:''
	}

	 $scope.bl.blNo = $rootScope.blNotoCancel;
	  

	 
	 $scope.saveData = function(blForm1) {
		 if($scope.bl.blCancelreason){
			 	$http.post($stateParams.tenantid+'/api/inWard/cancelBL' ,$scope.bl).success(function(result) {
			 		if (result.isSuccess == true) {
			 			  ngDialog.close();
	            logger.logSuccess(result.message);
	            $state.reload();  

	        } else {
	        	logger.logError(result.message);
	        }
	    }).error(function(result) {
	        console.log("data" + result);
		 
 });
		 }else{
			 logger.logError("Please enter cancel remarks..!!");
		 }
	 }
	 $scope.closeUpload = function(){
	        ngDialog.close();
	        $state.reload();
	  }
	 
	
});

