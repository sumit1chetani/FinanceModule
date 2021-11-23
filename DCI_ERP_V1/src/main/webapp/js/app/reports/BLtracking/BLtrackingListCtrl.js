/**
 * 
 */'use strict';
app.controller('BLtrackingctrl', function($state,$controller,$templateCache,$timeout, $scope, sharedProperties,$injector,$rootScope, $http, logger, $log, ngDialog, $modal, $location, toaster, $sce, $filter,utilsService,$stateParams) {
    $scope.quotationSummary = {
    		bookingId:'',
    		bookingNo:'',
    		contType:'',
    		pol:'',
    		pod:'',
    	    statusDate: '',
    	    customerType:'',
    		customer:'',
    	    QuotationNo:'',
            freightelement:'',
            amount:'',
    		validFrom:'',
    		validTill:'',
    		orgin:'',
    		vessel:'',
    		voyage:'',
    		bookingId:'',
    		agreParty:'',
    		bookingDate:'',
    		podFreedays:'',
    		currencyCode:''
    			
  
       
    };

    $scope.formreset = function() {
        $scope.quotationSummary = {};
    };
    
    $scope.popUpDtl={    		
    		containerNo:'',
    		conType:'',
    		noOfPack:'',
    		commodity:'',
    		netWeight:'',
    		sealNo:''   		
    };
    
    $scope.blViewDetails = {    		
    		vesselName : '',
    		voyageNo : '',
    		blId : '',
    		blDate : '',
    		bookingParty : '',
    		bookingPartyAddr : '', 
    		rebateParty : '',
    		blReleaseDate : '',
    		shipper : '',
    		shipperN_A : '',
    		consignee : '',
    		consigneeAddr : '',
    		notifyParty : '',
    		notifyPartyAddr : '',
    		notifyParty1 : '',
    		notifyPartyAddr1 : '',
    		notifyParty2 : '',
    		notifyPartyAddr2 : '', 
    		notifyParty3 : '',
    		notifyPartyAddr3 : '',
    		polBL : '',
    		podBL : '',
    		preCarriageBy : '',
    		placeofReceipt : '',
    		finalDestination : '',
    		placeofDelivery : '',
    		serviceMode : '',
    		shipmentTerms : '',
    		prepaid_collect : '',
    		exRate : '', 
    		agentAtDestination : '',
    		payableAt : '',
    		prePaidAt : '',
    		noofOriginalBL : '',
    		placeofBLIssue : '',
    		blType : '',
    		shortShip : '',
    		unitofMeasurement : '',
    		commonDescription : '',
    		podFreedays:'',
    		mainfestRemarks : ''
    };

    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.vesselList = [];
    $scope.voyageList = [];
    $scope.customerList = [];
    $scope.blNoList = [];
    $scope.searchList =[];
    $scope.customerformList =[];

    $scope.searchInvoiceDtl =[];
    $scope.getDropdownvalue = function() {
        
        $http.get($stateParams.tenantid+'/app/bltracking/bllist').success(function(datas) {
        	$scope.blNoList = datas;
        }).error(function(datas) {
        });

    }
    $scope.getDropdownvalue();
  

    
    
    //SERACH
    

    $scope.searchInvoiceDtl = function(){
    	
   	 $http.post($stateParams.tenantid+'/app/bltracking/searchquotationDtl', $scope.quotationSummary).success(function(response) {
      	console.log(response.searchList.length);

            if(response.searchList.length==0){
                logger.logError("No Records Found")
                $scope.rowCollection=[];
            
            }
            else
                {
                $scope.rowCollection=response.searchList;
                $scope.popUpDtl=response.conListList;
                $scope.blViewDetails = response.blPopUpDetails;
                $scope.eventList = response.eventlogList;

                if($scope.blViewDetails.shipperN_A != null && $scope.blViewDetails.shipperN_A != ''){
        			 var text5 =$scope.blViewDetails.shipperN_A;
                     text5 = text5.replace(/\r?<br>/g, '\n');
                     $scope.blViewDetails.shipperN_A=text5;
        		}
                if($scope.blViewDetails.consigneeAddr != null && $scope.blViewDetails.consigneeAddr != ''){
        			 var text5 =$scope.blViewDetails.consigneeAddr;
                     text5 = text5.replace(/\r?<br>/g, '\n');
                    $scope.blViewDetails.consigneeAddr=text5;
        		}
                if($scope.blViewDetails.notifyPartyAddr != null && $scope.blViewDetails.notifyPartyAddr != ''){
        			 var text5 =$scope.blViewDetails.notifyPartyAddr;
                     text5 = text5.replace(/\r?<br>/g, '\n');
                    $scope.blViewDetails.notifyPartyAddr=text5;
        		}
                if($scope.blViewDetails.notifyPartyAddr1 != null && $scope.blViewDetails.notifyPartyAddr1 != ''){
       			 var text5 =$scope.blViewDetails.notifyPartyAddr1;
                    text5 = text5.replace(/\r?<br>/g, '\n');
                    $scope.blViewDetails.notifyPartyAddr1=text5;
       		}
               if($scope.blViewDetails.notifyPartyAddr2 != null && $scope.blViewDetails.notifyPartyAddr2 != ''){
       			 var text5 =$scope.blViewDetails.notifyPartyAddr2;
                    text5 = text5.replace(/\r?<br>/g, '\n');
                    $scope.blViewDetails.notifyPartyAddr2=text5;
       		}
               if($scope.blViewDetails.notifyPartyAddr3 != null && $scope.blViewDetails.notifyPartyAddr3 != ''){
       			 var text5 =$scope.blViewDetails.notifyPartyAddr3;
                    text5 = text5.replace(/\r?<br>/g, '\n');
                    $scope.blViewDetails.notifyPartyAddr3=text5;
       		} if($scope.blViewDetails.commonDescription != null && $scope.blViewDetails.commonDescription != ''){
      			 var text5 =$scope.blViewDetails.commonDescription;
                 text5 = text5.replace(/\r?<br>/g, '\n');
                 $scope.blViewDetails.commonDescription=text5;
    		}

                }
        }); 
     
    }
    
    $scope.printBLCopy = function() {
   	 $scope.userId=$('#empId').val();
   	 var blNo=$scope.blViewDetails.blId;
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
       	var url = $stateParams.tenantid+'/api/outWard/printbloutwardcopy?blNo=' + blNo;
          // if((result.count < 3) || ($scope.userId=='E0001')){
           var wnd = window.open(url, 'Shipping', 'height=400,width=750,top=100,left=100,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
           wnd.print();
           /*   } else {
                  logger.logError("Print limit exceeded");

       	   }
          }
          });*/
//       }

   };
   
    
    
/*    //Excel Export	
  	 $scope.exportExcel = function(){
  	   	 $http.post($stateParams.tenantid+'/app/quotationsummary/ExportExcel', $scope.quotationSummary).success(function(response) {

  	                if(response){
  	                    debugger;
  	                    $("#customerExport").bind('click', function() {
  	                    });
  	                    $('#customerExport').simulateClick('click');
  	                    logger.logSuccess("Exported successfully!");
  	                }else{
  	                    logger.logError("Failed to export");
  	                }
  	                
  	            }).error(function(response) {
  	                logger.logError("Error Please Try Again");
  	            });
  	    
  	    }*/
  	    
    $scope.showContainerPopup = function() {
      	  ngDialog.close();
          ngDialog.open({
              template : 'views/reports/BLtracking/blContainerPopUp',
              scope : $scope,
              closeByEscape: true
    });
  

    }

    $scope.viewBLDetails = function() {
    	  ngDialog.close();
        ngDialog.open({
            template : 'views/reports/BLtracking/blViewDetails',
            scope : $scope,
            closeByEscape: true
  });


  }
   /* $scope.vieweventlog = function() {
  	  ngDialog.close();
      ngDialog.open({
          template : 'views/reports/BLtracking/blViewEventLog',
          scope : $scope,
          closeByEscape: true
});


}*/
    $scope.vieweventlog = function(value){
    	$rootScope.blno = value;
    	$scope.callQCDialog($scope,$http, ngDialog, logger,$injector, sharedProperties,$stateParams, toaster,$rootScope);
    	};
  
    	$scope.callQCDialog = function($scope,$http, ngDialog, logger,$injector, sharedProperties,$stateParams, toaster,$rootScope){
  	   ngDialog.open({
     		scope: $scope,
     		template: 'views/reports/BLtracking/blViewEventLog',
     		controller: $controller('eventLogPopCtrl', {
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
     };
    
    $scope.cancel = function() {
	
   	  ngDialog.close(); 

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


app.controller('eventLogPopCtrl', function($scope, $state, $http, $location, sharedProperties,toaster,
		$injector,logger,ngDialog,$rootScope,$controller,$stateParams) {
				
			
			var obj;
			obj = $rootScope.blno;
			$http.post($stateParams.tenantid+'/app/bltracking/searchquotationDtl', obj).success(function(response) {

		      	console.log(response.searchList.length);

		            if(response.searchList.length==0){
		                logger.logError("No Records Found")
		                $scope.rowCollection=[];
		            
		            }
		            else
		                {
		                $scope.rowCollection=response.searchList;
		                $scope.popUpDtl=response.conListList;
		                $scope.blViewDetails = response.blPopUpDetails;
		                $scope.eventList = response.eventlogList;

		                if($scope.blViewDetails.shipperN_A != null && $scope.blViewDetails.shipperN_A != ''){
		        			 var text5 =$scope.blViewDetails.shipperN_A;
		                     text5 = text5.replace(/\r?<br>/g, '\n');
		                     $scope.blViewDetails.shipperN_A=text5;
		        		}
		                if($scope.blViewDetails.consigneeAddr != null && $scope.blViewDetails.consigneeAddr != ''){
		        			 var text5 =$scope.blViewDetails.consigneeAddr;
		                     text5 = text5.replace(/\r?<br>/g, '\n');
		                    $scope.blViewDetails.consigneeAddr=text5;
		        		}
		                if($scope.blViewDetails.notifyPartyAddr != null && $scope.blViewDetails.notifyPartyAddr != ''){
		        			 var text5 =$scope.blViewDetails.notifyPartyAddr;
		                     text5 = text5.replace(/\r?<br>/g, '\n');
		                    $scope.blViewDetails.notifyPartyAddr=text5;
		        		}
		                if($scope.blViewDetails.notifyPartyAddr1 != null && $scope.blViewDetails.notifyPartyAddr1 != ''){
		       			 var text5 =$scope.blViewDetails.notifyPartyAddr1;
		                    text5 = text5.replace(/\r?<br>/g, '\n');
		                    $scope.blViewDetails.notifyPartyAddr1=text5;
		       		}
		               if($scope.blViewDetails.notifyPartyAddr2 != null && $scope.blViewDetails.notifyPartyAddr2 != ''){
		       			 var text5 =$scope.blViewDetails.notifyPartyAddr2;
		                    text5 = text5.replace(/\r?<br>/g, '\n');
		                    $scope.blViewDetails.notifyPartyAddr2=text5;
		       		}
		               if($scope.blViewDetails.notifyPartyAddr3 != null && $scope.blViewDetails.notifyPartyAddr3 != ''){
		       			 var text5 =$scope.blViewDetails.notifyPartyAddr3;
		                    text5 = text5.replace(/\r?<br>/g, '\n');
		                    $scope.blViewDetails.notifyPartyAddr3=text5;
		       		} if($scope.blViewDetails.commonDescription != null && $scope.blViewDetails.commonDescription != ''){
		      			 var text5 =$scope.blViewDetails.commonDescription;
		                 text5 = text5.replace(/\r?<br>/g, '\n');
		                 $scope.blViewDetails.commonDescription=text5;
		    		}

		                }
		        
			}).error(function(datas) {
			      });
			   

			

		});

