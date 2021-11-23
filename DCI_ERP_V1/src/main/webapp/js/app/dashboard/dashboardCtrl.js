app.controller('dashboardCtrl', function($scope,$filter, $modal, 
		$http, $stateParams,$rootScope,$timeout,$location,ngDialog,logger,$window, $interval,
		$injector,sharedProperties,toaster,$controller,validationService, toaster,$state) {

	$scope.rowCollection3 = [];
    $scope.donutList=[];
    localStorage.setItem('logout-event-pdfs', 1);
    $scope.blNoList = [];
    $scope.searchInvoiceDtl =[];
    $scope.searchList =[];
    $scope.rowCollection4 = [];
    $scope.displayedCollection = [];
    $scope.displayedCollection1 = [];
	
    
    $scope.routing ={
    		xVoyage:'',
			xPol:'',
			xPod:'',
			xFpod:'',
    		pol:'',
    		pod:'',
    		vesselRouting:'',
    		voyageRouting:'',
    		eta:''
    
    		
    };
   $scope.poplist = {
			vessel : '',
			voyage : '',
			containerNo : '',
			dishcargePort : '',
			blNo : '',
			bookingNum:'',
			customer:'',
			select1 : false,
			
	
		
	};
   
   // Lease Agreement
   
   $scope.leaseAgreement = {
		   leasingParty : '',
		   leaseCnt20 : '',
		   leaseCnt40 : '',
		   teus : '',
		   total20 :'',
		   total40 : '',
		   teustotal : '',
		   total : '',
		
	};
   
   //BL Tracking
   
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
   
   $scope.popUpDtl={    		
   		containerNo:'',
   		conType:'',
   		noOfPack:'',
   		commodity:'',
   		netWeight:'',
   		sealNo:''   		
   };	
   
   $scope.getDropdownvalue = function() {
       
       $http.get($stateParams.tenantid+'/app/bltracking/bllist').success(function(datas) {
       	$scope.blNoList = datas;
       }).error(function(datas) {
       });

   }
   $scope.getDropdownvalue();
   
   
 //BL Tracking Search
   $scope.searchInvoiceDtl = function(){
   	
	   	 $http.post($stateParams.tenantid+'/app/bltracking/searchquotationDtl', $scope.quotationSummary).success(function(response) {
	      	console.log(response.searchList.length);

	            if(response.searchList.length==0){
	                logger.logError("No Records Found")
	                $scope.rowCollection4=[];
	            
	            }
	            else
	                {
	                $scope.rowCollection4=response.searchList;
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
   $scope.viewBLDetails = function() {
 	  ngDialog.close();
     ngDialog.open({
         template : 'views/reports/BLtracking/blViewDetails',
         scope : $scope,
         closeByEscape: true
});


}
   
   $scope.vieweventlog1 = function(value){
   	$rootScope.blno = value;
   	$scope.callQCDialogBLTRACK($scope,$http, ngDialog, logger,$injector, sharedProperties,$stateParams, toaster,$rootScope);
   	};
 
   	$scope.callQCDialogBLTRACK = function($scope,$http, ngDialog, logger,$injector, sharedProperties,$stateParams, toaster,$rootScope){
 	   ngDialog.open({
    		scope: $scope,
    		template: 'views/reports/BLtracking/blViewEventLog',
    		controller: $controller('BLDBeventLogPopCtrl', {
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
//	       }

	   };
	   
	   
	   
	   $scope.showContainerPopup1 = function() {
	      	  ngDialog.close();
	          ngDialog.open({
	              template : 'views/reports/BLtracking/blContainerPopUp',
	              scope : $scope,
	              closeByEscape: true
	    });
	  

	    }
	   
	 
	   
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
   

// Container Tracking
		    
	$scope.polList = [];
	$scope.blList = [];
	$scope.containerNoList= [];
	
	$scope.containerBank = {
			vessel : '',
			voyage : '',
			pol : '',
			pod : '',
			blNo : '',
			onhireRefNo:'',
			depot:'',
			containerNo: ''
    }
	
	 $http.post($stateParams.tenantid+'/api/report/containerNo').success(function(data) {
	      	
	  		$scope.containerNoList=data;
	  		        		
	  });
	
	/*$scope.getList = function() {
        $http.post($stateParams.tenantid+'/api/containerBank/list',$scope.containerBank).success(function(datas) {
            $scope.rowCollection = datas;
            })
    };
        $scope.getList();*/
        
     $scope.getSearch = function() {
          	 
      	  $http.post($stateParams.tenantid+'/api/containerBank/SearchContainerList',$scope.containerBank).success(function(datas) {
                console.log(datas);
                $scope.rowCollection = datas;
            	
                }).error(function(datas) {
            });
      }  
     
   //BlNo Dropdown
		
		$http.get($stateParams.tenantid+ '/api/containerBank/BldropDown').success(function(data) {
			$scope.blList = data;
		});
		
  //pol

  	  $http.post($stateParams.tenantid+ '/api/containerBank/GetPortByVoyage').success(function(data) {
				$scope.polList = data;
  	  });
  	  
  	$scope.view = function(containerNo,onhireDate,containerType,containerId){
      	$rootScope.containerNo = containerNo;
      	$rootScope.onhireDate =onhireDate;
      	$rootScope.containerType = containerType;
      	$rootScope.containerId =containerId;
      	$scope.dummy = containerNo;
		   $scope.dummy1 = onhireDate;
		   $scope.dummy2 = containerType;
      	$scope.callQCDialog1($scope,$http, ngDialog, logger,$injector, sharedProperties,$stateParams, toaster,$rootScope);
      	};
      	
      	$scope.callQCDialog1 = function($scope,$http, ngDialog, logger,$injector, sharedProperties,$stateParams, toaster,$rootScope){
      		ngDialog.open({
      		scope: $scope,
      		template: '/views/reports/containerBank/containerbankPopup',
      		controller: $controller('ContainerBankpoPopupCtrl', {
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
					depot:''
		    }
	    	
	        $scope.getList();

	    }
   	

   
 //Boxes
   $scope.tncre = function(values){
	   $rootScope.title = values;
	   ngDialog.close();
	   ngDialog.open({
   		scope: $scope,
   		template: '/views/DashboardTNCREPopUp',
   		controller: $controller('tncrePopupCtrl', {
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
   		closeByEscape: true,
   		preCloseCallback : $scope.getList
   		});
   };
   
   
   
   
   
   //Donut Popup
   $scope.containerStatus = function(value){
	   $rootScope.title = value;
	   ngDialog.open({
   		scope: $scope,
   		template: '/views/DashboardDonutPopup',
   		controller: $controller('donutPopCtrl', {
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
	
	//login validation
	   $http.post($stateParams.tenantid+'/app/dashboard/getLoginCount').success(function(datas){
	        debugger;
	     if(datas.count==1){
	       
	    	 
	         $location.path('{tenantid}/userupdatepwd');
	         localStorage.setItem('getLoginDateDiff',0);
	     } else {
	         $http.post($stateParams.tenantid+'/app/dashboard/getLoginDateDiff').success(function(datas){
	             if(datas.logCount>30)
	                 {
	                 $location.path('{tenantid}/userupdatepwd');
	                 localStorage.setItem('getLoginDateDiff',datas.logCount);
	                 }
	             
	         });
	     }
	     
	    }).error(function(datas){
	    });
	   
	   
		  $http.get($stateParams.tenantid+'/api/dashboard/list').success(function(datas) {
          console.log(datas);
          $scope.row4 = datas;
          
          }).error(function(datas) {
      });
      
		  
		  $http.get($stateParams.tenantid+'/api/containers/emptylist').success(function(datas) {
	            console.log(datas);
	            $scope.row = datas;
	        	
	            }).error(function(datas) {
	        });
		  
		
		  $http.get($stateParams.tenantid+'/app/dashboard/getRoutingrights').success(function(datas) {
	            console.log(datas);
	            $scope.showRouting = datas.userRights;
	        	
	            }).error(function(datas) {
	        });
		  
		  $http.get($stateParams.tenantid+'/app/dashboard/bookinglist').success(function(datas) {
	            console.log(datas);
	            $scope.booking = datas.bookingList;
	            $scope.userId =datas.userId;
	 
	            
	            }).error(function(datas) {
	        });
		  
		  $http.get($stateParams.tenantid+'/app/dashboard/BLpendingListforT/s').success(function(datas) {
	            console.log(datas);
	            $scope.pendingBL = datas.pendingblList;
	            $scope.userId =datas.userId;
	            
	          /*  if($scope.userId =="E0019" || $scope.userId =="E0001" ){
	            $scope.showRouting = true;
	            }*/
	            
	            }).error(function(datas) {
	        });
	        
	        $http.get($stateParams.tenantid+'/api/containers/containerlist').success(function(datas) {
	            console.log(datas);
	            $scope.contrRel = datas;
	        	
	            }).error(function(datas) {
	        });
	        
	        
	        $http.get($stateParams.tenantid+'/api/containers/vessellist').success(function(datas) {
	            console.log(datas);
	            $scope.vesselArrival = datas;
	        	
	            }).error(function(datas) {
	        });
	        
	        $http.get($stateParams.tenantid+'/api/containers/leaseAgreement').success(function(datas) {
	        	console.log(datas);
	            $scope.leaseAgreement = datas;
	            $scope.agent2 = datas[0].agent;
	            
	            }).error(function(datas) {
	        });
	        
	             	
	        $scope.assign = function(value){
	        	$rootScope.value = value;
	        //	$rootScope.blno = blno;
	        	$rootScope.routing =value;
	        	$scope.callQCDialog($scope,$http, ngDialog, logger,$injector, sharedProperties,$stateParams, toaster,$rootScope);
	        	};
	        	
	        	
	        	$scope.callQCDialog = function($scope,$http, ngDialog, logger,$injector, sharedProperties,$stateParams, toaster,$rootScope){
	        		ngDialog.open({
	        		scope: $scope,
	        		template: '/views/DashboardPop',
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

	        $scope.noCnfrm = function() {
	    		ngDialog.close();
	    	}
	        
	        
	        // Assign to Nasir's tab
	        $http.get($stateParams.tenantid+'/app/dashboard/blList').success(function(datas) {
	            console.log(datas);
	            $scope.assignBltab = datas.blList;
	            
	        }).error(function(datas) {
	        });
	        // Save Direct Bl to Nasir
	        $scope.directBlSave =function(value){
	        	
	        	$scope.blDetails ={
	            		vessel:'',
	        			voyage:'',
	        			blNo:'',
	        			bookingNo:'',
	            		pol:'',
	            		pod:'',
	            		fpod:'',
	            		customer:''
	            };
	        	
	        	$http.post($stateParams.tenantid+'/app/dashboard/saveBltoNasir',value).success(function(data) {
	        		console.log(data);
	               if(data.isSuccess==true){
	               	 logger.logSuccess("Save Successfully!"); 
	                 $state.reload();
	               }else{
	               	 logger.logError(data.message);
	               }
	           })
	        	
	        }
	        
	        	// Popup for Direct Assign Container List
	        $scope.containerCountforNasir = function(value){
		     	   $rootScope.containerList = value;
		     	   ngDialog.open({
		        		scope: $scope,
		        		template: '/views/DashboardContainerforNasirDirect Assign',
		        		controller: $controller('containerforDirectAssignCtrl', {
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
	        
	        
	      //Vessel Arrival At POD For Container Popup
	        $scope.showContainerPopup = function(value){
	     	   $rootScope.vesselArrivalContainers = value;
	     	   ngDialog.open({
	        		scope: $scope,
	        		template: '/views/DashboardVesselArrivalPopup',
	        		controller: $controller('vesselArrivalContainerPopCtrl', {
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
	        
	      //Vessel Sail At POD For Container Popup
	        $scope.showVesselSail = function(value){
	     	   $rootScope.vesselSailContainers = value;
	     	   ngDialog.open({
	        		scope: $scope,
	        		template: '/views/DashboardVesselSailPopup',
	        		controller: $controller('vesselSailContainerPopCtrl', {
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
	      
	        
	      
	       
/*	Highcharts.chart('container1', {
	    chart: {
	        plotBackgroundColor: null,
	        plotBorderWidth: 0,
	        plotShadow: false
	    },
	    title: {
	        text: 'Application<br>Usage<br>2018',
	        align: 'center',
	        verticalAlign: 'middle',
	        y: 40
	    },
	    tooltip: {
	        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
	    },
	    plotOptions: {
	        pie: {
	            dataLabels: {
	                enabled: true,
	                distance: -50,
	                style: {
	                    fontWeight: 'bold',
	                    color: 'white'
	                }
	            },
	            startAngle: -90,
	            endAngle: 90,
	            center: ['50%', '75%'],
	            size: '110%'
	        }
	    },
	    series: [{
	        type: 'pie',
	        name: 'Application Usage - 2018',
	        innerSize: '50%',
	        data: [
	            ['December', 80],
	            ['November', 5],
	            ['October', 5],
	            ['September', 5],
	            ['August', 5],
	            {
	                name: 'July',
	                y: 0,
	                dataLabels: {
	                    enabled: true
	                }
	            }
	        ]
	    }]
	});*/

	 
        /*$http.get($stateParams.tenantid+'/api/containers/emptylist').success(function(datas) {
            console.log(datas);
            $scope.row = datas;
        	
            }).error(function(datas) {
        });
        
        $http.get($stateParams.tenantid+'/api/containers/containerlist').success(function(datas) {
            console.log(datas);
            $scope.contrRel = datas;
        	
            }).error(function(datas) {
        });
     
		$http.get($stateParams.tenantid+'/api/containers/vessellist').success(function(datas) {
            console.log(datas);
            $scope.vesselArrival = datas;
        	
            }).error(function(datas) {
        });*/
		//Donut Chart Master
        $scope.donutList=[];
        var donut = [];
        $http.get($stateParams.tenantid+'/api/containers/donutList').success(function(datas) {
        	
            console.log(datas);
            for(var i=0;i<datas.length;i++){
            	brightness = 0.2 - (i / datas.length) / 5;
            	$scope.donutList.push({
                     name: datas[i].type,
                     y: Number(datas[i].count)
                   });
            }
           
            $scope.graphEdit();
            console.log($scope.donutList);
        	 }).error(function(datas) {
            	//logger.logError("Error Please Try Again");
        });
       
      //Donut start
        var colors = Highcharts.getOptions().colors,
          categories = [
            "Return from Shipper",
            "On Hire",
            "Release to Shipper",
            "Empty Container"
          ],
          data = [
            {
              "y": 10,
              "color": colors[2],
              "drilldown": {
                "name": "Return from Shipper",
                "categories": [
                  "Container Boarded Count"
                ],
                "data": [
                  10
                ]
              }
            }, {
                "y": 1,
                "color": colors[5],
                "drilldown": {
                  "name": "On Hire",
                  "categories": [
                    "Container Boarded Count"
                  ],
                  "data": [
                    1
                  ]
                }
              },
            {
              "y": 2,
              "color": colors[11],
              "drilldown": {
                "name": "Release to Shipper",
                "categories": [
                  "Release to Ship"
                ],
                "data": [
                  2
                ]
              }
            },
            {
              "y": 7,
              "color": colors[3],
              "drilldown": {
                "name": "Empty Container",
                "categories": [
                  "Damaged Containers"
                ],
                "data": [
                  7
                ]
              }
            }
          ],
          browserData = [],
          versionsData = [],
          i,
          j,
          dataLen = data.length,
          drillDataLen,
          brightness;


        // Build the data arrays
        for (i = 0; i < dataLen; i += 1) {
          // add browser data
          browserData.push({
            name: categories[i],
            y: data[i].y,
            color: data[i].color
          });

          // add version data
          drillDataLen = data[i].drilldown.data.length;
          for (j = 0; j < drillDataLen; j += 1) {
            brightness = 0.2 - (j / drillDataLen) / 5;
            versionsData.push({
              name: data[i].drilldown.categories[j],
              y: data[i].drilldown.data[j],
              color: Highcharts.Color(data[i].color).brighten(brightness).get()
            });
          }
        }
        // Create the chart
        $scope.graphEdit = function() {
        Highcharts.chart('donut', {
          chart: {
            type: 'pie'
          },
          title: {
            text: ''
          },
          yAxis: {
            title: {
              text: 'Total percent market share'
            }
          },
          plotOptions: {
            pie: {
              shadow: false,
              center: ['45%', '50%']
            }
          },
          tooltip: {
            valueSuffix: ''
          },
          series: [{
            name: 'Values',
            data:  $scope.donutList,
            size: '70%',
            innerSize: '50%',
            dataLabels: {
              formatter: function () {
                // display only if larger than 1
                return this.y >= 0 ? '<b>' + this.point.name + ':</b> ' +
                  this.y + '' : null;
              }
            },
            id: 'values'
          }],
          responsive: {
            rules: [{
              condition: {
                maxWidth: 600
              },
              chartOptions: {
                series: [{
                  id: 'values',
                  dataLabels: {
                    enabled: false
                  }
                }]
              }
            }]
          }
        });
        }
        //Donut end

        
 

//	Highcharts.chart('container', {
//	    chart: {
//	        type: 'area'
//	    },
//	    title: {
//	        text: 'Port and Container'
//	    },
//	    subtitle: {
//	        text: ''
//	    },
//	    xAxis: {
//	        allowDecimals: false,
//	        labels: {
//	            formatter: function () {
//	                return this.value; // clean, unformatted number for year
//	            }
//	        }
//	    },
//	    yAxis: {
//	        title: {
//	            text: 'Count'
//	        },
//	        labels: {
//	            formatter: function () {
//	                return this.value   ;
//	            }
//	        }
//	    },
//	    tooltip: {
//	        pointFormat: '{series.name} in  {point.x}'
//	    },
//	    plotOptions: {
//	        area: {
//	            pointStart: 2010,
//	            marker: {
//	                enabled: false,
//	                symbol: 'circle',
//	                radius: 2,
//	                states: {
//	                    hover: {
//	                        enabled: true
//	                    }
//	                }
//	            }
//	        }
//	    },
//	    series: [{
//	        name: 'COCHIN',
//	        data: [
//	            null, null, null, null, null,18,20,25,100
//	        ]
//	    }, {
//	        name: 'MUMBAI',
//	        data: [null, null, null, null, null,17,19,10,76
//	        ]
//	    }]
//	});
	
	
//	Highcharts.chart('container2', {
//
//	    chart: {
//	        type: 'column'
//	    },
//
//	    title: {
//	        text: ' Port/Depot Based - Empty Available'
//	    },
//
//	    xAxis: {
//	        categories: ['21/12/2018', '22/12/2018', '23/12/2018', '24/12/2018', '25/12/2018']
//	    },
//
//	    yAxis: {
//	        allowDecimals: false,
//	        min: 0,
//	        title: {
//	            text: 'Number of Empty Container'
//	        }
//	    },
//
//	    tooltip: {
//	        formatter: function () {
//	            return '<b>' + this.x + '</b><br/>' +
//	                this.series.name + ': ' + this.y + '<br/>' +
//	                'Total: ' + this.point.stackTotal;
//	        }
//	    },
//
//	    plotOptions: {
//	        column: {
//	            stacking: 'normal'
//	        }
//	    },
//
//	    series: [{
//	        name: 'No Of Empty Available',
//	        data: [5, 3, 4, 7, 2],
//	        stack: 'male'
//	    }, {
//	        name: 'Released count',
//	        data: [3, 4, 4, 2, 5],
//	        stack: 'male'
//	    },{
//	        name: 'Total OnBoarded',
//	        data: [4, 2, 3, 3, 6],
//	        stack: 'male'
//	    }
//	    ]
//	});
	                 
	
	$scope.dashBoard = {
		 totalUser : '',
		 totalOnlineUser : '',
		 totalEmptyCont : '',
		 totalContReleased : '',
		 totalOnBoardReleased : '',
		 totalContReleasedtoConsig:''
	}
	$http.get($stateParams.tenantid + '/app/dashboard/getBoxesDtls').success(function(data) {
 			$scope.dashBoard=data;
 			 
		 

	}).error(function(data) {
		//logger.logError("Error Please Try Again");
	});
	
	
$scope.pageCounters = [14, 16, 17, 18, 150, 500, 1000 ];

    
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.initial = {}; 
    $scope.isAdd = true; 
    $scope.hideDownloadIcon= true;
	
	$scope.offsetCount = 0;
	$scope.limitCount = 1000;
	$scope.DriverList = [];
	$scope.DriverPerformanceList = [];
	 $scope.rowCollection = [];
	 $scope.displayedCollection = [];
	
	$scope.pendingInvList=[];
	$scope.pendingPurInvList=[];
	$scope.dashBoardBean={
			isSuccess:false,
			timePeriod : '0'
	};

	$scope.getPendingInvoiceDtl = function() {
		$http.post($stateParams.tenantid + '/app/dashboard/getPendingInvoiceDtl',$scope.dashBoardBean).success(function(data) {
			if (data.success == true) {
				$scope.pendingInvList=data.pendingInvList;
				$scope.pendingPurInvList=data.pendingPurInvList;
				// $scope.pendingInvList  = $filter('orderBy')($scope.pendingInvList, 'jobDt',true);
			} else {
				logger.logError("No Record Found");
			}

		}).error(function(data) {
			//logger.logError("Error Please Try Again");
		});
	}
	
	//watch for count
	$scope.$watch('dashBoardBean.timePeriod', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
            $http.get($stateParams.tenantid +'/api/dashboard/getDescriptionCount?period='+newValue).success(function(data) {
                $scope.descriptionCountList=data.descriptionCountList; 
        }).error(function(data) {
            
        });
        }else{          
        	$scope.descriptionCountList=[];
        }
     });
	
	 $scope.timePeriodList = [{id:'0',text:'Today'},
         {id:'7',text:'Last Seven Days'},
         {id:'90',text:'Last 3 Months'},
         {id:'180',text:'Last 6 Months'},
         {id:'365',text:'Current Year'}
         ];
	
	var dteNow = new Date();
	var intYear = dteNow.getFullYear();
	$scope.yL = [];
	var yrList = [];
	for (var i = 0; i < 7; i++) {
		yrList[i] = intYear;
		intYear = intYear - 1;
	}
	$scope.yL = [];

	angular.forEach(yrList, function(value, key) {
		var i = "" + value + "";
		var t = "" + value + "";
		$scope.yL1 = {
			id : i,
			text : t
		}
		$scope.yL.push($scope.yL1);
	})
	
	
	$scope.noOfWeeks=[];
	var wkLst=[];
	for(var i=1;i<=53;i++){
		wkLst[i]=i;
	}
	angular.forEach(wkLst, function(value, key) {
		var i = "" + value + "";
		var t = "" + value + "";
		$scope.wklTemp = {
			id : i,
			text : t
		}
		$scope.noOfWeeks.push($scope.wklTemp);
	})
	$scope.showAccountsGrid=false;
	$scope.showAdminGrid=false;
	$scope.showSalesGrid=false;
	$scope.showMangmt=false;
	$scope.showLogMaster=false;
	$scope.showRouting=false;
	
	$scope.loginUsrDetails=[];
	var tenantString='mbk'
		/*if($stateParams.tenantid.toUpperCase().includes(tenantString.toUpperCase())){*/
			$http.post($stateParams.tenantid + '/api/dashboard/checkWhichUser').success(function(data) {
				if (data) {
					$scope.loginUsrDept=data[0];
					$scope.loginUsrDetails=data[1];
					$scope.userId=data[1].userId;
					$scope.companyCode=$scope.loginUsrDetails.companyCode;
					
					if($scope.userId=='E0001'){
						$scope.showLogMaster=true;
						$scope.logMaster();	
						$scope.loadSlsLgnCustInvDtl();
					}
					if($scope.loginUsrDept=='Admin'){
						$scope.showAccountsGrid=true;
						$scope.showAdminGrid=true;
						$scope.showSalesGrid=true;
						$scope.showMangmt=true;
						
						$scope.getOnloadWeekList();
						$scope.getPendingInvoiceDtl();
						$scope.loadSlsLgnToDoList();
						$scope.loadCustAnalysisRpt();
						$scope.loadBankBalence();
						$scope.loadCustrOutStandingAmtList();
						$scope.getReceivableAmt();
						$scope.getChatList();
						
						
					}
					if($scope.loginUsrDept=='Accounts'){
						$scope.showAdminGrid=true;
						$scope.getPendingInvoiceDtl();
						$scope.getOnloadWeekList();
						$scope.getChatList();
					}
					if($scope.loginUsrDept=='Sales'){
						$scope.showSalesGrid=true;
						
						$scope.loadSlsLgnToDoList();
						$scope.getChatList();
					}
					if($scope.loginUsrDept=='Sales Department'){
						$scope.showSalesGrid=true;
						$scope.loadSlsLgnToDoList();
						$scope.getChatList();
					}
					
					if($scope.loginUsrDept=='Management'){
						$scope.showMangmt=true;
						$scope.loadCustAnalysisRpt();
						$scope.loadBankBalence();
						$scope.loadCustrOutStandingAmtList();
						$scope.getReceivableAmt();
						$scope.getChatList();
					}
					
				} else {
					logger.logError("No Record Found");
				}

			}).error(function(data) {
				//logger.logError("Error Please Try Again");
			});
		/*}*/
		
		
		$scope.agingAlrt1=[];
		$scope.agingAlrt2=[];
		$scope.noPyamntAlrt=[];
		$scope.exporAlt1=[];
		$scope.exporAlt2=[];
		$scope.businsConAlrt=[];
		$scope.loadCustAnalysisRpt =function(){
			$scope.companyCode;
			$http.post($stateParams.tenantid+'/app/dashboard/getCustAnlsForDashBd')
			.success(function(data) {
				$scope.agingAlrt1=data.agingAlrt1;
				$scope.agingAlrt2=data.agingAlrt2;
				$scope.noPyamntAlrt=data.noPyamntAlrt;
				$scope.exporAlt1=data.exporAlt1;
				$scope.exporAlt2=data.exporAlt2;
				$scope.businsConAlrt=data.businsConAlrt;
				
			})
			
		}



	
	//log master
	
	$scope.logMasterList=[];
	$scope.logMaster =function(){
		
		$http.post($stateParams.tenantid+'/app/dashboard/getlogmaster')
		.success(function(data) {
			$scope.logMasterList=data.logMasterList;
		}).error(function(data) {
			//logger.logError("Error Please Try Again");
		});
		
	}
	
	$scope.bankBal=[];
	$scope.loadBankBalence =function(){
		$scope.companyCode;
		$http.post($stateParams.tenantid+'/app/dashboard/getTodyBankBal?companyCode='+$scope.companyCode)
		.success(function(data) {
			$scope.bankBal=data.bankBalList;
		}).error(function(data) {
			//logger.logError("Error Please Try Again");
		});
		
	}
	
	
	$scope.getchatEmployee=[];
	$scope.getChatList =function(){
		
		$http.post($stateParams.tenantid+'/app/dashboard/getchatEmployee?companyCode='+$scope.companyCode)
		.success(function(data) {
			console.log(data);
			$scope.getchatEmployee=data.listBean;
			$scope.employeeId=data.userId;
			
		}).error(function(data) {
			//logger.logError("Error Please Try Again");
		});
		
	}
	
	$scope.custOutStngList=[];
	$scope.loadCustrOutStandingAmtList =function(){
		$http.post($stateParams.tenantid+'/app/dashboard/getOutstandingAmt')
		.success(function(data) {
			$scope.custOutStngList=data.custOtstandgList;
		}).error(function(data) {
			//logger.logError("Error Please Try Again");
		});
		
	}
	
	$scope.receivableList=[];
	$scope.getReceivableAmt =function(){
		$http.post($stateParams.tenantid+'/app/dashboard/getReceivableAmt')
		.success(function(data) {
			$scope.receivableList=data.custReceivableList;
		}).error(function(data) {
			//logger.logError("Error Please Try Again");
		});
		
	}
	
	$scope.loadSlsLgnCustInvDtl=function(){
		$scope.dashBrdBean1={
				salesPersonId:$scope.loginUsrDetails.userId,
		};
		$http.post($stateParams.tenantid + '/app/dashboard/getCustmrInvcDtl',$scope.dashBrdBean1).success(function(data) {
			if (data.success == true) {
				$scope.custPenInv=data.salsDsbdPendigInvc;
			} else {
				logger.logError("Error in Record Fetcing");
			}
		}).error(function(data) {
			//logger.logError("Error Please Try Again");
		});
	}
	$scope.toDoList=[];
	$scope.loadSlsLgnToDoList=function(){
		$http.post($stateParams.tenantid + '/app/dashboard/getToDoList').success(function(data) {
			if (data.success == true) {
				$scope.toDoList=data.toDoList;
			} else {
				logger.logError("Error in Record Fetcing");
			}
		}).error(function(data) {
			//logger.logError("Error Please Try Again");
		});
	}
	
	$scope.select={
			year:'',
			week:''			
	}
	$scope.dashBrdBean={
			startDate:'',
			endDate:'',
	};
	$scope.getWeeklyBillingRpt=function(){
		if($scope.select.year != '' && $scope.select.year != undefined){
			if($scope.select.week != '' && $scope.select.week != undefined){	
			var simple = new Date($scope.select.year, 0, 1 + ($scope.select.week - 1) * 7);
		    var dow = simple.getDay();
		    var ISOweekStart = simple;
		    if (dow <= 4)
		        ISOweekStart.setDate(simple.getDate() - simple.getDay() + 1);
		    else
		        ISOweekStart.setDate(simple.getDate() + 8 - simple.getDay());
		    var st=new Date(ISOweekStart);
		    var ed=new Date(ISOweekStart);
		      ed.setDate(ed.getDate() + 6);
		      $scope.dashBrdBean.startDate=st;
		      $scope.dashBrdBean.endDate=ed;
		      $http.post($stateParams.tenantid + '/app/dashboard/getWeeklyInvoiceDtl',$scope.dashBrdBean).success(function(data) {
					if (data.success == true) {
						$scope.weeklyInvList=data.weeklyInvList;
						if($scope.weeklyInvList.length !=0 && $scope.weeklyInvList!= undefined){
							$scope.weeklyInvList  = $filter('orderBy')($scope.weeklyInvList, 'invDate',true);	
						}else{
							logger.logError("No Record Found");
						}
						
					} else {
						logger.logError("Error in Record Fetcing");
					}

				}).error(function(data) {
					//logger.logError("Error Please Try Again");
				});
		      
		      
		}else{
			logger.logError("Please Select Week");
		}
		}else{
			logger.logError("Please Select Year");
		}
	}
	//$scope.getWeeklyBillingRpt();
	
	$scope.getOnloadWeekList=function(){
		var d=new Date();
	    d = new Date(Date.UTC(d.getFullYear(), d.getMonth(), d.getDate()));
	    d.setUTCDate(d.getUTCDate() + 4 - (d.getUTCDay()||7));
	    var yearStart = new Date(Date.UTC(d.getUTCFullYear(),0,1));
	    var weekNo = Math.ceil(( ( (d - yearStart) / 86400000) + 1)/7);
	    
	    $scope.select.year=''+d.getUTCFullYear()+'';
	    $scope.select.week=''+weekNo+'';
	    
	    var simple = new Date(d.getUTCFullYear(), 0, 1 + (weekNo - 1) * 7);
	    var dow = simple.getDay();
	    var ISOweekStart = simple;
	    if (dow <= 4)
	        ISOweekStart.setDate(simple.getDate() - simple.getDay() + 1);
	    else
	        ISOweekStart.setDate(simple.getDate() + 8 - simple.getDay());
	    var st=new Date(ISOweekStart);
	    var ed=new Date(ISOweekStart);
	      ed.setDate(ed.getDate() + 6);
	      var twlWeekSt=new Date(ISOweekStart);
		    var twlWeekStEd=new Date(ISOweekStart);
		    twlWeekStEd.setDate(twlWeekStEd.getDate() - 83);
	      $scope.dashBrdBean.startDate=st;
	      $scope.dashBrdBean.endDate=ed;
	      $scope.dashBrdBean.twlWeekStDate=twlWeekSt;
	      $scope.dashBrdBean.twlWeekEdDate=twlWeekStEd;
	      $http.post($stateParams.tenantid + '/app/dashboard/getWeeklyInvoiceDtl',$scope.dashBrdBean).success(function(data) {
				if (data.success == true) {
					$scope.weeklyInvList=data.weeklyInvList;
					$scope.weeklyInvList  = $filter('orderBy')($scope.weeklyInvList, 'invDate',true);	
					$scope.twlWeekInvAvrg=data.twlWeekInvAvrg;
					$scope.twlWkTotlCltInv=data.twlWkTotlCltInv;
					if($scope.twlWeekInvAvrg !='' && $scope.twlWeekInvAvrg !=undefined){
						
					}else{
						$scope.twlWeekInvAvrg =0.00;
						$scope.twlWkTotlCltInv=0.00;
					}
				} else {
					logger.logError("No Record Found");
				}

			}).error(function(data) {
				//logger.logError("Error Please Try Again");
			});
		
	}
	

	
	 $scope.chartData = [];
     $scope.chartHeaderData = [];
//     $scope.dataList= [{
//    		color: "#f91818", 
//    		data:[{
//    		color: "red",
//    		x: 0,
//    		y: 10092002297
//    		},{
//    			color: "green",
//    				x: 1,
//    				y: 46126471084
//    		}],
//           name : 'week5',
//           type: "column"
//    	} ]

     $scope.categ=[];
   
//     $scope.chartHeaderData= [{
//     categories:['AP','AR'], 
//     fill: null,
//     name: 'ARYA',
//     }];
     
$scope.highchart = function(){
	
	//	$window.location.reload();
	
 Highcharts.chart('container5', {
    
     chart: {
         renderTo: "container5",
         type: "column",
         borderWidth: 5,
         borderColor: '#e8eaeb',
         borderRadius: 0,
         backgroundColor: 'white'
     },
     title: {
         style: {
             'fontSize': '1em'
         },
         useHTML: true,
         x: -27,
         y: 8,
         text: 'Port and Container'
     },
     yAxis: [{ // Primary yAxis
         labels: {
             format: '{value}',
             style: {
                 color: '	darkslateblue'
             }
         },
         title: {
             text: 'Total NO. of TEUs',
             style: {
                 color: 'darkslateblue'
             }
         }
     }],
     series: $scope.chartData,
     xAxis: {
     	   labels: {
     	 formatter: function () {
//     	        if ('AP' == this.value) {
//     	            return '<span style="fill: red;">' + this.value + '</span>';
     	   //     } else if('AR' == this.value){
     	        	 return '<span style="fill: green;">' + this.value + '</span>';
//     	        }
//     	        else{
//     	        	return '<span style="fill: black;">' + this.value + '</span>';
//     	        }
     	    }
     	   },
         categories: $scope.chartHeaderData,
         
     }	
 });
 
}

//Country based container count

$scope.highchart3 = function(){
	
	//	$window.location.reload();
	
 Highcharts.chart('container7', {
    
     chart: {
         renderTo: "container7",
         type: "column",
         borderWidth: 5,
         borderColor: '#e8eaeb',
         borderRadius: 0,
         backgroundColor: 'white'
     },
     title: {
         style: {
             'fontSize': '1em'
         },
         useHTML: true,
         x: -27,
         y: 8,
         text: 'Country and Container'
     },
     yAxis: [{ // Primary yAxis
         labels: {
             format: '{value}',
             style: {
                 color: '	darkslateblue'
             }
         },
         title: {
             text: 'Total NO. of TEUs',
             style: {
                 color: 'darkslateblue'
             }
         }
     }],
     series: $scope.chartData,
     xAxis: {
     	   labels: {
     	 formatter: function () {
//     	        if ('AP' == this.value) {
//     	            return '<span style="fill: red;">' + this.value + '</span>';
     	   //     } else if('AR' == this.value){
     	        	 return '<span style="fill: green;">' + this.value + '</span>';
//     	        }
//     	        else{
//     	        	return '<span style="fill: black;">' + this.value + '</span>';
//     	        }
     	    }
     	   },
         categories: $scope.chartHeaderData,
         
     }	
 });
 
}

$scope.chartData2 = [];
$scope.chartHeaderData2 = [];
//$scope.dataList= [{
//		color: "#f91818", 
//		data:[{
//		color: "red",
//		x: 0,
//		y: 10092002297
//		},{
//			color: "green",
//				x: 1,
//				y: 46126471084
//		}],
//      name : 'week5',
//      type: "column"
//	} ]

$scope.categ2=[];

//$scope.chartHeaderData= [{
//categories:['AP','AR'], 
//fill: null,
//name: 'ARYA',
//}];

$scope.highchart2 = function(){

//	$window.location.reload();

Highcharts.chart('container6', {

chart: {
    renderTo: "container6",
    type: "column",
    borderWidth: 5,
    borderColor: '#e8eaeb',
    borderRadius: 0,
    backgroundColor: 'white'
},
title: {
    style: {
        'fontSize': '1em'
    },
    useHTML: true,
    x: -27,
    y: 8,
    text: ''
},
yAxis: [{ // Primary yAxis
    labels: {
        format: '{value}',
        style: {
            color: 'darkslateblue'
        }
    },
    title: {
        text: 'Container Count',
        style: {
            color: 'darkslateblue'
        }
    }
}],
series: $scope.chartData2,
xAxis: {
	   labels: {
	 formatter: function () {
//	        if ('AP' == this.value) {
//	            return '<span style="fill: red;">' + this.value + '</span>';
	   //     } else if('AR' == this.value){
	        	 return '<span style="fill: green;">' + this.value + '</span>';
//	        }
//	        else{
//	        	return '<span style="fill: black;">' + this.value + '</span>';
//	        }
	    }
	   },
    categories: $scope.chartHeaderData2,
    
}	
});

}

$http.get($stateParams.tenantid+'/app/dashboard/getGroupedListCountryDtls').success(function(datas) {
    console.log(datas);
    $scope.chartHeaderData = datas.headerList;
    $scope.chartData = datas.highChartColumnBeanList;
    $scope.highchart3();
    $scope.checkagent =datas.agent;
    
    }).error(function(datas) {
});

$http.get($stateParams.tenantid+'/app/dashboard/getGroupedListDtls').success(function(datas) {
    console.log(datas);
    $scope.chartHeaderData = datas.headerList;
    $scope.chartData = datas.highChartColumnBeanList;
    $scope.highchart();
    
    }).error(function(datas) {
});

$http.get($stateParams.tenantid+'/app/dashboard/getGroupedListDailyDtls').success(function(datas) {
    console.log(datas);
    $scope.chartHeaderData2 = datas.headerList;
    $scope.chartData2 = datas.highChartColumnBeanList;
    $scope.highchart2();
    
    }).error(function(datas) {
});

});

app.controller('poPopupCtrl', function($scope, $state, $http, $location, sharedProperties,toaster,
$injector,logger,ngDialog,$rootScope,$controller,$stateParams) {
	$scope.rowCollection3 = [];
	$scope.poplist=[];
	$scope.routing ={
    		xVoyage:'',
			xPol:'',
			xPod:'',
			xFpod:'',
    		pol:'',
    		pod:'',
    		vesselRouting:'',
    		voyageRouting:'',
    		vesselID:'',
    		eta:'',
    		blNo:'',
    		vessel : '',
			voyage : '',
    
    		
    };
   $scope.poplist = [{
			vessel : '',
			voyage : '',
			containerNo : '',
			dishcargePort : '',
			blNo : '',
			bookingNum:'',
			customer:'',
			blNo:'',
			select1 : false,
			
	
		
	}];
   $http.get($stateParams.tenantid+ '/app/commonUtility/getVesselList').success(function(data) {
		$scope.vesselList = data;
	});
   
   $scope.voyageList=[];
	 $scope.$watch('routing.vessel', function(newValue, oldValue) {
	      if(newValue!=null && newValue!=undefined && newValue != ''){
	    	  $http.post($stateParams.tenantid+ '/app/commonUtility/getVoyageListByVessel',newValue).success(function(data) {
					$scope.voyageList = data;
	    	  });
	      }
	    });
   
   var BookingData= $rootScope.routing;
	   debugger;
	   $http.post($stateParams.tenantid+'/app/dashboard/routingContainer', BookingData ).success(function(datas) {
	          console.log(datas);
	          if(datas.length > 0){
		            $scope.poplist = datas;
		           $scope.routing.vessel= datas[0].vessel;
		           $scope.routing.voyage=datas[0].voyage;
		           $scope.routing.vesselRouting = $rootScope.routing.vesselRouting;
		           $scope.routing.voyageRouting=$rootScope.routing.voyageRouting;
		    			            	
	          } else {
	          	
	          }
	      	
	          }).error(function(datas) {
	      });
		
   
   $scope.saveData = function() {
		var tmpDelList = [];
		for(var i=$scope.poplist.length-1;i>=0;i--){
			if($scope.poplist[i].select1==true){
				$scope.poplist[i].vessel=$scope.routing.vessel;
				$scope.poplist[i].voyage=$scope.routing.voyage;
				tmpDelList.push($scope.poplist[i]);
			}
		}
		
		
	$scope.selectedList = tmpDelList;
	$rootScope.routing
	$rootScope.routing.vessel= $scope.routing.vessel;
	$rootScope.routing.voyage= $scope.routing.voyage;

	var obj ={
		bean:	$rootScope.routing,
		popList:$scope.selectedList
	}
	if ($scope.routing.vessel != null && $scope.routing.vessel !='' ){
		if ($scope.routing.voyage != null && $scope.routing.voyage !=''){
			$http.post($stateParams.tenantid+'/app/dashboard/saveDetail',obj).success(function(data) {
				console.log(data);
		       if(data.isSuccess==true){
		       	 logger.logSuccess("Save Successfully!"); 

		       	 /*$window.location.reload();
		       	 $window.history.back();*/
		         $scope.noCnfrm();
		         $state.reload();
		       }else{
		       	 logger.logError(data.message);
		       }
		   });
		}
		else{
			 if($scope.routing.voyage ==null || $scope.routing.voyage  =='')
	                logger.logError("Please select Voyage");
    	}
		
	}
	else{
		 if($scope.routing.vessel ==null || $scope.routing.vessel  =='')
               logger.logError("Please select Vessel");
	}
	
	
};

$scope.selectall= function(selection){
 	angular.forEach($scope.poplist,function(value,key) {
 		debugger;
 		if( selection)
 		value.select1=true;
 		else{
 			value.select1=false;
 		}
});
}

	

});


app.controller('tncrePopupCtrl', function($scope, $state, $http, $location, sharedProperties,toaster,
		$injector,logger,ngDialog,$rootScope,$controller,$stateParams) {
	$scope.header = '';
	$scope.title = $rootScope.title;
	

    if($scope.title==="Total No of Empty Available"){
    	$scope.header = 1;
    } else if ($scope.title==="Total No. of Containers Ready to Export"){
    	$scope.header = 2;
    } else if ($scope.title==="Total OnBoard"){
    	$scope.header = 3;
    } else if ($scope.title==="Import full Discharged"){
    	$scope.header = 4;
    }
			$scope.rowCollection3 = [];
			$scope.rowCollectionSummaryList = [];
			$scope.headerList = [];
			$scope.headerListSummary = [];
			$scope.poplist=[];
			$scope.poplist ={
		    		xVoyage:'',
					xPol:'',
					xPod:'',
					xFpod:'',
		    		pol:'',
		    		pod:'',
		    		vesselRouting:'',
		    		voyageRouting:'',
		    		eta:'',
		    		blNo:''
		    
		    		
		    };
			$scope.dashBoard = {
					 totalUser : '',
					 totalOnlineUser : '',
					 totalEmptyCont : '',
					 totalContReleased : '',
					 totalOnBoardReleased : '',
					 totalContReleasedtoConsig:''
				}
				$http.get($stateParams.tenantid + '/app/dashboard/getBoxesDtls').success(function(data) {
			 			$scope.dashBoard=data;
			 			 
					 

				}).error(function(data) {
					//logger.logError("Error Please Try Again");
				});
			   $http.get($stateParams.tenantid+'/app/dashboard/getBoxesDtlsList').success(function(datas) {
				 
				   $http.get($stateParams.tenantid + '/app/dashboard/getBoxesDtls').success(function(data) {
			          console.log(datas);
			          if($scope.header==1){
			        	  $scope.total = data.totalEmptyCont;
				          $scope.rowCollection3 = datas.boxTNEA;
				          $scope.headerList = datas.boxHeadeTNEA;
				          $scope.rowCollectionSummaryList = datas.emptySummaryList;
				          $scope.headerListSummary = datas.headerEmptySummaryList;
				       } else if ($scope.header==2){
				    	   $scope.total = data.totalContReleased;
			        	  $scope.rowCollection3 = datas.boxTNCRE;
				          $scope.headerList = datas.boxHeadeTNCRE;
				          $scope.rowCollectionSummaryList = datas.rfsSummaryList;
				          $scope.headerListSummary = datas.headerRfsSummaryList;
			          } else if ($scope.header==3){
			        	  $scope.total=data.totalOnBoardReleased;
			        	  $scope.rowCollection3 = datas.boxOnBoard;
				          $scope.headerList = datas.boxHeadeOnBoard;
				          $scope.rowCollectionSummaryList = datas.onboardSummaryList;
				          $scope.headerListSummary = datas.headerOnboardSummaryList;
			          } else if ($scope.header==4){
			        	  $scope.total=data.totalContReleasedtoConsig;
			        	  $scope.rowCollection3 = datas.boxIFD;
				          $scope.headerList = datas.boxHeadeIFD;
				          $scope.rowCollectionSummaryList = datas.dischargeSummaryList;
				          $scope.headerListSummary = datas.headerDischargeSummaryList;
			          }
			          
			          
				   }).error(function(data) {
						//logger.logError("Error Please Try Again");
					});
			          
			          }).error(function(datas) {
			      });
			   

			

		});


app.controller('donutPopCtrl', function($scope, $state, $http, $location, sharedProperties,toaster,
		$injector,logger,ngDialog,$rootScope,$controller,$stateParams,$window,utilsService) {
	$scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.itemsByPage = 10;
    
	   $rootScope.title;
	   $scope.dropdownList=[];

	   $scope.donut ={
			   status:'',
	   };
	   $http.get($stateParams.tenantid+'/api/containers/donutList').success(function(datas) {
		  
		   $scope.dropdownList=datas;
          /* for(var i=0;i<datas.length;i++){
           	$scope.dropdownList.push({
           		id : datas[i].type ,
           		text :datas[i].type 
                  });
           }*/
           	 }).error(function(datas) {
       });
	   
	
	   
	   
	  
	   $scope.check=true;
		$scope.$watch('donut.status',function(newValue, oldValue) {
			if(newValue!=null && newValue!=undefined && newValue!=""){
				var obj = $scope.donut;
				 $http.post($stateParams.tenantid+'/api/containers/donutPopupList',obj).success(function(datas) {
					   debugger
				          console.log(datas);
					          $scope.rowCollection6 = datas;
					          if($scope.donut.status==="EMPTY AVAILABLE"){
					        	  $scope.check1=true;
					          }else{
					        	  $scope.check1=false;
					          }
				          
				          }).error(function(datas) {
				      });
			}
		});
		
		 $http.post($stateParams.tenantid+'/api/containers/donutPopupList',$scope.donut).success(function(datas) {
			   debugger
		          console.log(datas);
			          $scope.rowCollection6 = datas;
		          
		          }).error(function(datas) {
		      });
			$scope.rowCollection6 = [];
			


		});


app.controller('vesselArrivalContainerPopCtrl', function($scope, $state, $http, $location, sharedProperties,toaster,
		$injector,logger,ngDialog,$rootScope,$controller,$stateParams) {
	
			$scope.rowCollection = [];
			
		/*	$scope.vesselArrivalContainers = {
					vessel : '',
					voyage : '',
					containerNo : '',
					dishcargePort : '',
					blNo : '',
					bookingNum:'',
					customer:'',
			};*/
			
			var obj;
			obj = $rootScope.vesselArrivalContainers;
			   $http.post($stateParams.tenantid+'/api/containers/vesselArrivalPopup',obj).success(function(datas) {
				   debugger
			          console.log(datas);
				          $scope.rowCollection = datas;
			          
			          }).error(function(datas) {
			      });
			   

			

		});
		
		app.controller('vesselSailContainerPopCtrl', function($scope, $state, $http, $location, sharedProperties,toaster,
				$injector,logger,ngDialog,$rootScope,$controller,$stateParams) {
			
					$scope.rowCollection = [];
					
				/*	$scope.vesselArrivalContainers = {
							vessel : '',
							voyage : '',
							containerNo : '',
							dishcargePort : '',
							blNo : '',
							bookingNum:'',
							customer:'',
					};*/
					
					var obj;
					obj = $rootScope.vesselSailContainers;
					   $http.post($stateParams.tenantid+'/api/containers/vesselSailPopup',obj).success(function(datas) {
						   debugger
					          console.log(datas);
						          $scope.rowCollection = datas;
					          
					          }).error(function(datas) {
					      });
					   

					

				});
		
		app.controller('containerforDirectAssignCtrl', function($scope, $state, $http, $location, sharedProperties,toaster,
				$injector,logger,ngDialog,$rootScope,$controller,$stateParams) {
			
					$scope.rowCollection = [];
					
				/*	$scope.vesselArrivalContainers = {
							vessel : '',
							voyage : '',
							containerNo : '',
							dishcargePort : '',
							blNo : '',
							bookingNum:'',
							customer:'',
					};*/
					
					var obj;
					obj = $rootScope.containerList;
					   $http.post($stateParams.tenantid+'/app/dashboard/ContainerList',obj).success(function(datas) {
						   debugger
					          console.log(datas);
						          $scope.rowCollection = datas;
					          
					          }).error(function(datas) {
					      });
					   

					

				});
		
		app.controller('vesselSailContainerPopCtrl', function($scope, $state, $http, $location, sharedProperties,toaster,
				$injector,logger,ngDialog,$rootScope,$controller,$stateParams) {
			
					$scope.rowCollection = [];
					
				/*	$scope.vesselArrivalContainers = {
							vessel : '',
							voyage : '',
							containerNo : '',
							dishcargePort : '',
							blNo : '',
							bookingNum:'',
							customer:'',
					};*/
					
					var obj;
					obj = $rootScope.vesselSailContainers;
					   $http.post($stateParams.tenantid+'/api/containers/vesselSailPopup',obj).success(function(datas) {
						   debugger
					          console.log(datas);
						          $scope.rowCollection = datas;
					          
					          }).error(function(datas) {
					      });
					   

					

				});
		

//Container Tracking Popup

		app.controller('ContainerBankpoPopupCtrl', function($scope, $timeout, $stateParams,sharedProperties,toaster,
				$filter, $rootScope, $http, $location, logger, $state, ngDialog,$controller,$injector,validationService) {
			

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

			$scope.test = $rootScope.containerNo;
			 $scope.container.containerNo = $rootScope.containerNo;
			 
			 $scope.test1 = $rootScope.containerId;
			 $scope.container.containerId = $rootScope.containerId;
			 
			debugger;
			 $http.post($stateParams.tenantid+'/api/containerBank/popuplist?containerId=' +$scope.container.containerId).success(function(result) {
				 $scope.rowCollection1 = result.detailList;
				 
		 });
			
			 $scope.closePopup = function(){
			        ngDialog.close();
			        $state.reload();
			  }
			 
			
		});		

 
		app.controller('BLDBeventLogPopCtrl', function($scope, $state, $http, $location, sharedProperties,toaster,
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


