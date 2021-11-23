'use strict';

app.controller('shipmentOrderAddCtrl', function($scope, $rootScope, $http, $location, logger, ngDialog,
        utilsService,$state,sharedProperties,$window,$stateParams,toaster,validationService,$timeout) {

 $scope.displayedCollection = [];
 $scope.tableData = [];
 $scope.blcntrDtlList = [];
  
 $scope.select = false;
 $scope.submitted = false;
 $scope.listAdd= false;

 var date  = new Date();
 var dateString =  date.getDate() + "/" + date.getMonth() + "/" + date.getFullYear() + " " + date.getHours() + ":" + date.getMinutes();

 $scope.rowCollectionFollowup=[];
    $scope.referralList=[];
    $scope.isEdit = false;
    $scope.tairDetailList =[];
    $scope.consigneeList = [];
    $scope.vesselList = [];
	$scope.voyageList = [];
	$scope.commodityList=[];
    $scope.blTypeList = [
	     {id: 'Normal BL', text: 'Normal BL'},
	     {id: 'Two-sector BL', text: 'Two-sector BL'},
	     {id: 'Sea WayBill', text: 'Sea WayBill'},
	     {id: 'Switch BL', text: 'Switch BL'},
	 
	  ];
    
    
    $scope.GWList = [
	     {id: 'KG', text: 'KG'},
	     {id: 'MT', text: 'MT'}
	 
	  ];
    
    $scope.celfahList = [
	     {id: 'C', text: 'C'},
	     {id: 'F', text: 'F'}
	   
	  ];
	
     
    $http.get($stateParams.tenantid+'/api/outWard/getIssuePlace').success(function(datas) {
         $scope.issuePlaceList = datas;
     });
    
    $http.get($stateParams.tenantid+'/api/outWard/vslvoyagedropdown').success(function(datas) {
         $scope.vesselVoyageList = datas;
     });
    
    $http.get($stateParams.tenantid+'/api/outWard/getAgentList').success(function(datas) {
    	debugger
        $scope.agentList = datas;
     });
    
   /* $http.get($stateParams.tenantid+'/api/outWard/getBookingList').success(function(datas) {
         $scope.bookingList = datas;
     });*/
    
    $http.get($stateParams.tenantid+'/api/outWard/shipmentList').success(function(datas) {
        $scope.shipmentList = datas;
    });
    $http.post($stateParams.tenantid+'/app/seaquotation/getcommodity').success(function(data) { 
        $scope.commodityList = data.commonUtilityBean;
    });
   /* $http.get($stateParams.tenantid+'/api/outWard/getConatinerTypeList').success(function(datas) {
        $scope.containerTypeList = datas;
    });*/
    $http.get($stateParams.tenantid+'/app/commonUtility/getcarrierList').success(function(datas) {
		debugger
	    $scope.carrierList = datas.commonUtilityBean;	    
        //$scope.transList = datas.lCommonUtilityBean;	    

	}).error(function(data) {

	});
    $http.get($stateParams.tenantid+ '/app/commonUtility/getContainerTypeList').success(function(data1) {
		$scope.containerTypeList = data1.containerTypeList;
	});
    
   /* $http.post($stateParams.tenantid+'/api/containerLeaseAgreementType/dropDownList').success(function(data) {
         
   		$scope.containerTypeList=data.listContainerTypeList;

   		
   });*/
    
    $http.get($stateParams.tenantid+'/api/outWard/getPackageTypeList').success(function(datas) {
        $scope.packageList = datas;
    });
    
  /*   $http.get($stateParams.tenantid+'/api/outWard/getSurChargeList').success(function(datas) {
        $scope.surchargeList = datas;
        console.log($scope.surchargeList);
    }); */
    
   $http.get($stateParams.tenantid+'/app/commonUtility/getSurChargeList?relateType=1').success(function(datas) {
    	debugger;
        $scope.surchargeList = datas;
         console.log($scope.surchargeList);
    });  
    
    
    $http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(datas) {
  		  $scope.customerList=datas.getcustomerlist;
		  $scope.currencyList=datas.getcurrencylist	;
		  $scope.portlist =datas.getportlist;
		  $scope.polList =datas.polList;
		  $scope.conNoList=datas.getcontainer;
	}).error(function(datas) {

	});
    
    
   /* //vessel
    
    $http.get($stateParams.tenantid+ '/app/commonUtility/getVesselList').success(function(data) {
		$scope.vesselList = data;
//		$scope.voyageList = data.voyageList;
		//$scope.polList = data.polList;
			//$scope.podList = data.polList;
	});
    
  //voyage
    $scope.$watch('blNoData.disvessel', function(newValue, oldValue) {
   					      if(newValue!=null && newValue!=undefined && newValue != '' && $scope.bookViaQt==false){
   					    	  $http.post($stateParams.tenantid+ '/app/commonUtility/getVoyageListByVessel',newValue).success(function(data) {
   									$scope.voyageList = data;
   					    	  });
   					      }
   					      if(newValue!=null && newValue!=undefined && newValue != '' && $scope.bookViaQt==true){
   					    	  $http.post($stateParams.tenantid+ '/app/salesBooking/getVoyListByVsl?pol='+$scope.bookingData.pol+'&pod='+$scope.bookingData.pod+'&ves='+newValue).success(function(data) {
   									$scope.voyageList = data.voyList;
   						    	  })
   					      }
   					    });*/
    
	
    //add container disable
    $scope.isEdit = true;
    var shipmentOrderId = $location.search().shipmentOrderId;
    $http.get($stateParams.tenantid+ '/api/shipmentorder/addContainer?jobNo=' +shipmentOrderId).success(function(data) {
		console.log(data);
		$scope.blCreatedorNot = data;
    }).error(function(data) {
  
	});//end add container disable
 
    $scope.$watch('blNoData.consigName', function(newValue,
			oldValue) {

		if (newValue != '' && newValue != undefined  ) {


			 $http.get($stateParams.tenantid+'/api/outWard/getCustomerAddress?customerId='+newValue).success(function(datas) {
			        $scope.blNoData.consigAddress = datas.address;
			     });

		}else{
			//$scope.bookingNoList=[];
		}
	});
 $scope.$watch('blNoData.shipperName', function(newValue,
			oldValue) {

		if (newValue != '' && newValue != undefined  ) {


			 $http.get($stateParams.tenantid+'/api/outWard/getCustomerAddress?customerId='+newValue).success(function(datas) {
			        $scope.blNoData.shipperAddress = datas.address;
			     });

		}else{
			//$scope.bookingNoList=[];
		}
	});
    
    //Fetch Values
    $scope.isEdit = false;
    var shipmentOrderId = $location.search().shipmentOrderId;
    if (shipmentOrderId == undefined) {
    } else {
    	 $scope.bookingList={}

   	  $http.get($stateParams.tenantid+ '/api/shipmentorder/getCustomereditDropdown?jobNo=' +shipmentOrderId).success(function(data1) {
			console.log(data1);
			$scope.customerList1 = data1;
	  
		});
  	
        $http.get($stateParams.tenantid+'/api/shipOrder/editShipMentOrder?shipmentOrderId=' +shipmentOrderId).success(function(result) {
        	
        	 var data = [{id : result.bookingNo, text : result.bookingNo}];
        	 $scope.bookingList=data;
             	$scope.blNoData=result;
             	$scope.blNoData.bookingNo=result.bookingNo;
             	$scope.blNoData.contQuantInBooking=result.contQuant;
            	$scope.isEdit=true;
            	  if($scope.isEdit){
            			 $http.post($stateParams.tenantid+'/api/shipmentorder/getContainerListdrop',$scope.blNoData).success(function(datas) {
         	 		        $scope.containerList = datas;
         	 		      
         	 		    });
            	  }
            	  else{
            			 $http.post($stateParams.tenantid+'/api/shipmentorder/getContainerListdrop',$scope.blNoData).success(function(datas) {
         	 		        $scope.containerList = datas;
         	 		    });
            	  }
            
         }).error(function(data) {
            console.log("data" + data);
        });
    }

    $scope.Reset = function(){
    	$http.get($stateParams.tenantid+'/api/shipOrder/edit?shipmentOrderId=' +shipmentOrderId).success(function(result) {

         	$scope.blNoData=result;
        	$scope.isEdit=true;
     }).error(function(data) {
        console.log("data" + data);
    });
    }
    
    $scope.cancel = function() {
    	
   	/* if($scope.from=='dashboard'){
		 $state.go('dashboard.list');
	 }else{*/
	   	 $state.go('app.documentation.shipmentorder.list',{tenantid:$stateParams.tenantid});
	 //}
   };
    
   
	  
	 
   $scope.fleList = [
         		       {id: '1', text: 'F'},
         		    {id: '2', text: 'L'}, 
         		 {id: '3', text: 'E'} 
        		     ];
  
  $scope.socList = [
         		       {id: '1', text: 'Yes'},
         		    {id: '2', text: 'No'}, 
        		     ];

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
			
			
			 $scope.shippopup={
					 
					 test:'',
					 popUpDtl:[{id:0,conType:'',quantity:'',depot:'',allocDate:''}],
			 }
		    
		 //////////////////////////////////////////////////
		  
		  $scope.blNoData = {
				  blNo : '',
				  bookingNo : '',
				  issuePlace : '',
				  issueDate : '',
				  onBoard : '',
				  vslVoyage : '',
				  receiptAt : '',
				  pol : '',
				  pod : '',
				  pot : '',
				  fpod : '',
				  pod1:'',
				  pod2:'',
				  disPol:'',
				  disPod:'',
				  disFpod:'',
				  disvessel:'',
				  disvoyage:'',
				  disPor:'',
				  terms : '',
				  noBls : 3,
				  ref : '',
				  mVoyage : '',
				  loadType : '',
				  service : '',
				  client : '',
				  jobNo : '',
				  agent : '',
				  remarks : '',
				  shipment : '',
				  status : '',
				  released : '',
				  messers : '',
				  shippers : '',
				  cnee : '',
				  notify1 : '',
				  notify2 : '',
				  forwarder : '' ,
				  shipperId : '',
				  cneeId : '',
				  notify1Id : '',
				  notify2Id : '',
				  forwarderId : '' ,
				  mainCom : '',
				  twgt: '',
				  gwgt : '',
				  nwgt : '',
				  cbm : '',
				  pkgs : '',
				  goods : '',
				  marks : '',
				  imcoCharge:'',
				  unCode :'',
				  deliveryAgent:'',
				  polSeq:'',
				  podSeq:'',
				  created_by: '',
		          created_date : '',
		          modified_by: '',
		          modified_date: '',
				  soc: false,
				  detentionTariffType:'',
				  addContainerStatus : true,
				  blcntrDtlList:[
					 { 
				 chargeList : []
					 }
				 ],
				 blpckDtlList : [{
					 packageList : [] 
				 }],
				 blCharges : [],
				 removeCntr : [],
				 removeCntrCharge : [],
				 removeCntrPckg : [],
				 removeCharge : [],
				 freightAt:'',
				 freightBy:'',
				 sobType:'',
				 billtype:'',
				 gw_unit:'',
				 consigTel:'',
				 consigEmail:'',
				 consigName:'',
				 consigAddress:'',
				 consigCountry:'',
				 consigTaxNumber:'',
				consigCustName:'',
			     consigneeCode:'',
				hsCode:'',
					 shipperTel:'',
					 shipperEmail:'',
					 shipperName:'',
					 shipperAddress:'',
					 shipperCountry:'',
					 shipperTaxNumber:'',
					 shipperCustName:'',
					 shipperCode:'',
					 
					 temperature:'',
					 vent:'',
					 humidity:'',
					 celfah:''
				 
		    };
		  $scope.blNoData.removeCntr=[];
		  $scope.blNoData.removeCntrCharge=[];
		  $scope.blNoData.removeCntrPckg=[];

		  
		   var shipOrdNo = $location.search().shipOrdNo;
		    if (shipOrdNo == undefined) {
		    } else {
		    	$scope.blNoData.bookingNo=	shipOrdNo;
		    }
		    
		    
		    
//		  $scope.containersData = {
//				  cntrNo : '',
//				  size : '',
//				  type : '',
//				  sealNo : '',
//				  tw : '',
//				  gw : '',
//				  cb : '',
//				  net : '',
//				  fle : '',
//				  so : '',
//				  package_ : '',
//				  no : '',
//				  g : '',
//				  iso : '',
//				  vgm : '',
//				  mar : '',
//				  polTer : '',
//				  podTer : ''
//		    };
		    
		  $http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(datas) {
		
		   $scope.containerList=datas.getcontainer;
		
			}).error(function(datas) {

			});
		  
		  

    
		    $scope.serviceList = [
 		       {id: '1', text: 'Collect'},
		       {id: '2', text: 'Prepaid'},
		       {id: '3', text: 'Third Pary Collect'},
		     ];

		    $scope.load = [
		       {id: 'FCL', text: 'FCL'},
		       {id: 'LCL', text: 'LCL'},
		     ];
		    
		    $scope.termsOfPayment = [
		    		       {id: '1', text: 'Prepaid'},
		    		       {id: '2', text: 'Collect'},
		    		     ];

		    $scope.jobno = [
		        {id:'',text:'---select---'},
		       {id: 'J001', text: 'J001'},
		       {id: 'J002', text: 'J002'},
		       {id: 'J003', text: 'J003'},
		     ];

		    $scope.statusList = [
 		       {id: 'Hold', text: 'Hold'},
		     ];
		    
		 
		    
	        $http.get($stateParams.tenantid+'/app/commonUtility/agentList').success(function(datas) {
	        	console.log(datas);
	            $scope.agentList = datas;
	        }).error(function(data) {

	        });
	   	 $http.post($stateParams.tenantid+'/app/detection/getTariffList').success(function(data) {
		      	
		  		$scope.tariffList=data; 
		  		        		
		     });

   $scope.swapContainer = function(blForm) { 
		  $scope.shippopup.popUpDtl=[];
	   
	   $http.post($stateParams.tenantid+'/api/shipOrder/swapContainerList', $scope.blNoData).success(function(result) {
		debugger
		  if(result.isSuccess){	
			 $scope.temp=[];
			 
			 if(result.popUpDtl.length>0){
				  
			angular.forEach(result.popUpDtl, function(chargesDetailpop, index) {
				
				var chk=false;
				
				angular.forEach(blForm.blcntrDtlList, function(chargesDetail, index) {
				
					  
					  if(chargesDetail.cntrNo == chargesDetailpop.containerNo){
						  
						  chk=true;	 
					  }
			    	
			    });
				             if(!chk){
				  
				                var tmp3 = {};
					            tmp3 = angular.copy(chargesDetailpop);
					            $scope.temp.push(tmp3);
					             
			                } 
				  
				  }); 
				  $scope.shippopup.popUpDtl= $scope.temp;
				  ngDialog.close();
		          ngDialog.open({
		              template : 'views/operation/shipmentorder/swapContainerPopUp',
		              scope : $scope,
		              closeByEscape: true
		    });
				  
				  
			  }else{
				  
				  logger.logError("Containers not available");
				  
			  }
		
		        

		}else{
			  logger.logError("Error in Fetch");
		  }
		}).error(function(data) {
			logger.logError("Please try again");
		});}
   
   
   $scope.swapContainerGateOut = function(blForm) { 
		  $scope.shippopup.popUpDtl=[];
	   
	   $http.post($stateParams.tenantid+'/api/shipOrder/swapContainerGateOutList', $scope.blNoData).success(function(result) {
		debugger
		  if(result.isSuccess){	
			 $scope.temp=[];
			 
			 if(result.popUpDtl.length>0){
			
			  
				  
				  
			angular.forEach(result.popUpDtl, function(chargesDetailpop, index) {
				
				var chk=false;
				
				angular.forEach(blForm.blcntrDtlList, function(chargesDetail, index) {
				
					  
					  if(chargesDetail.cntrNo == chargesDetailpop.containerNo){
						  
						  chk=true;	 
					  }
			    	
			    });
				             if(!chk){
				  
				                var tmp3 = {};
					            tmp3 = angular.copy(chargesDetailpop);
					            $scope.temp.push(tmp3);
					             
			                } 
				  
				  }); 
				  $scope.shippopup.popUpDtl= $scope.temp;
				  ngDialog.close();
		          ngDialog.open({
		              template : 'views/operation/shipmentorder/swapContainerPopUp',
		              scope : $scope,
		              closeByEscape: true
		    });
				  
				  
			  }else{
				  
				  logger.logError("Containers not available");
				  
			  }
		
		        

		}else{
			  logger.logError("Error in Fetch");
		  }
		}).error(function(data) {
			logger.logError("Please try again");
		});}
   
   
   
   $scope.selectall= function(selection){
     	angular.forEach($scope.shippopup.popUpDtl,function(value,key) {
     		debugger;
     		if( selection)
     		value.select=true;
     		else{
     			value.select=false;
     		}
 });
     }
   
   
   
   $scope.popupsubmit = function(blForm) {
	   
		 var retVal = confirm("Do you want to Reallocate Container?");
         if( retVal == true ) {
	    angular.forEach($scope.shippopup.popUpDtl, function(chargesDetail, index) {
			  if (chargesDetail.select==true) {
				      
				            	   var tmp3 = {};
									 tmp3.cntrNo = angular.copy(chargesDetail.containerNo);
									 tmp3.type= angular.copy(chargesDetail.conType);
									 tmp3.goods= angular.copy(chargesDetail.goods);
									 tmp3.gateOutDetailID= angular.copy(chargesDetail.gateOutDetailID);
									 tmp3.soc= angular.copy(chargesDetail.soc); 
									 tmp3.prevBookingNo = angular.copy(chargesDetail.bookNo); 
									 tmp3.sealNo = angular.copy(chargesDetail.sealNo);
									 $scope.blNoData.blcntrDtlList.push(tmp3);
									
				         
			 }
	    	
	    }); 
	    ngDialog.close();
	    return true;
	    
         } else {
       	  
      	   ngDialog.close();
           
            return false;
         }  
	   
   }
   
   
   
   $scope.consigneeList=[];
   //Get Consignee Details

   $scope.getConsigneeNameList = function(){

	   $http.get($stateParams.tenantid+ '/api/outWard/getConsignee').success(function(data) {
	   console.log("getConsignee",data);
	   $scope.consigneeList = data;

	   });
	   }
	   
	   $scope.getConsigneeNameList();
	   

   $scope.fetchSelectedConsigneeName = function($model,blNoData){
   	console.log("inside auto fun");
   	console.log("consigneeList",$scope.consigneeList);
       if($scope.consigneeList.length>0){
           angular.forEach($scope.consigneeList, function(key,index){
               if ($model === key.text){
               	blNoData.consigName = key.text;
               	blNoData.consigAddress = key.consigneeAddress;    
               	blNoData.consigCountry = key.consigneeCountry;    
               	blNoData.consigTaxNumber = key.consigneeTaxnumber;    
               	blNoData.consigTel = key.consigneeTel;    
               	blNoData.consigEmail = key.consigEmail;    
               	blNoData.consigneeCode = key.consigneeCode;  
               }else{
               	blNoData.consigName=$model;
               }  
           })
             
           
       }else{
       	blNoData.consigName=$model;
       }
       return blNoData.consigName;
     }
   

   
   $scope.shipperList=[]; 
   
   $http.get($stateParams.tenantid+ '/api/outWard/getShipper').success(function(data) {
	   console.log("getShipper",data);
	   $scope.shipperList = data;

	   });
		    
   
   $scope.fetchSelectedShipperName = function($model,blNoData){
	   	console.log("inside auto fun");
	   	console.log("shipperList",$scope.shipperList);
	       if($scope.shipperList.length>0){
	           angular.forEach($scope.shipperList, function(key,index){
	        	   console.log("shippername1111111",$model);
	               if ($model === key.text){
	               	blNoData.shipperName = key.text;
	               	blNoData.shipperAddress = key.shipperAddress;    
	               	blNoData.shipperCountry = key.shipperCountry;    
	               	//blNoData.consigTaxNumber = key.consigneeTaxnumber;    
	               	blNoData.shipperTel = key.shipperTel;    
	               	blNoData.shipperEmail = key.shipperEmail;    
	               	blNoData.shipperCode = key.shipperCode;  
	               }else{
	               	blNoData.shipperName=$model;
	               }  
	           })
	             
	           
	       }else{
	       	blNoData.shipperName=$model;
	       }
	       return blNoData.shipperName;
	     }
	   
   
   
		  
   
   $scope.saveData = function(blForm) {
		    	if (new validationService().checkFormValidity(blForm)) {
		    		
		    		if($scope.blNoData.blcntrDtlList.length >0 ){
		    			
		    			//if($scope.blNoData.contQuantInBooking >= $scope.blNoData.blcntrDtlList.length){
		    				
		    			
		    		//$scope.blNoData.client='CU0043';
		    		var chargee ;
		    		var chargee1
		    		
		    		var test;
		    		if($scope.blNoData.blcntrDtlList.length >0 ){
						
					
		    		for(var i=0;i<$scope.blNoData.blcntrDtlList.length;i++){
						
						if($scope.blNoData.blcntrDtlList[i].gateOutDetailID != null && $scope.blNoData.blcntrDtlList[i].gateOutDetailID != '' ){
							if(test == null && test == undefined){
								test = "true";
							}else{
								test = test + "," + "true";
							}
								
						}else{
							logger.logError("Gate Out Detail ID is NULL for Container ID ("+$scope.blNoData.blcntrDtlList[i].cntrNo+") !!!!");
							if(test == null && test == undefined){
								test = "false";
							}else{
								test = test + "," + "false";
							}
						}
						
						//$scope.blNoData.blcntrDtlList[i].gw = $scope.blNoData.blcntrDtlList[i].gw.replace(",","");
						
					}
		    		
		    		var check =  test.split(",").includes("false") ? false : true ;
		    	}
					console.log(check);
					if(check == false){
					}else{
					
					$scope.check1 = true;
					
					/*var count = 0;
					
					 var fpod =$scope.blNoData.fpod.substring(0, 5);
					 console.log("fpod1222222222",fpod);
					 
					 if(fpod == 'AEJEA' || fpod == 'DJJIB'){
						 count = 1;
					 }*/
					

					
				/* if(count>0 && !$scope.blNoData.hsCode)
				{	 
					 logger.logError(" No shipments will be accepted without HS Code for this port.");
		     	  
				}else{*/
					
				
				var referror="";
					console.log("$scope.blNoData.blcntrDtlList1112222",$scope.blNoData.blcntrDtlList);
					
					for(var i=0;i<$scope.blNoData.blcntrDtlList.length;i++){
						
						if(($scope.blNoData.blcntrDtlList[i].type == 'R40H' &&  $scope.blNoData.blcntrDtlList[i].commodity != '11' ) && (!$scope.blNoData.blcntrDtlList[i].humidity 
							|| !$scope.blNoData.blcntrDtlList[i].temperature  || !$scope.blNoData.blcntrDtlList[i].vent)){
							
							referror = referror + "Please fill the Reefer Details for row no. "+(i+1) +"<br>";
						}
						
					}
					
					if(referror){
						logger.logError(referror);
					}else{
					
					
					  $http.post($stateParams.tenantid+'/api/shipOrder/create', $scope.blNoData).success(function(result) {
			              console.log("result" + result);
			           
			              if (result.isSuccess) {
			            	  logger.logSuccess("Saved Successfully!");
				                 $state.go('app.documentation.shipmentorder.list',{tenantid:$stateParams.tenantid});
			            	  if(result.jobNo != "" && result.jobNo != null){
			            		  $rootScope.uploadFileSave(result.jobNo);  
			            	  }
			            	  
			                  
			              } else {
			                  logger.logError(result.message);
								$scope.check1 = false;

			              }
							
			          }).error(function(result) {
			              console.log("data" + result);
			          });
					}
					
				//} 
		     	  
		    	}
		    	/*}else{
		    				logger.logError("Container's list is not Matching with Booking Container Quantity...Booking Container Quantity: "+$scope.blNoData.contQuantInBooking+" ..!!!");
		    				
		    			}*/
		    		}
		    } else {
		    	toaster.pop( 'error',"Please fill the required fields",logger.getErrorHtmlNew($scope.blForm.$validationSummary),5000, 'trustedHtml');
				$scope.check1 = false;
		    }}




$scope.$watch('blNoData.shipperId', function(newValue,
		oldValue) {

	if (newValue != '' && newValue != undefined  ) {


		$http.get($stateParams.tenantid+ '/api/outWard/getCustomerAddress?customerId='+newValue).success(function(data) {
			debugger
			console.log(data);
			$scope.blNoData.shipper=data.address;
		});

	}
});

$scope.$watch('blNoData.carrier', function(newValue,
		oldValue) {

	if (newValue != '' && newValue != undefined  ) {


		$http.get($stateParams.tenantid+ '/api/outWard/getbookingCarrier?carrier='+newValue).success(function(data) {
			debugger
			console.log(data);
			$scope.bookingList=data;
		});

	}else if($scope.isEdit ==false){
	         $scope.bookingList = [];
	}
});


$scope.$watch('blNoData.cneeId', function(newValue,
		oldValue) {

	if (newValue != '' && newValue != undefined  ) {


		$http.get($stateParams.tenantid+ '/api/outWard/getCustomerAddress?customerId='+newValue).success(function(data) {
			debugger
			console.log(data);
			$scope.blNoData.cnee=data.address;
		});


	}
});



$scope.$watch('blNoData.notify1Id', function(newValue,
		oldValue) {

	if (newValue != '' && newValue != undefined  ) {


		$http.get($stateParams.tenantid+ '/api/outWard/getCustomerAddress?customerId='+newValue).success(function(data) {
 			console.log(data);
			$scope.blNoData.notify1=data.address;
		});


	}
});


$scope.$watch('blNoData.notify2Id', function(newValue,
		oldValue) {

	if (newValue != '' && newValue != undefined  ) {


		$http.get($stateParams.tenantid+ '/api/outWard/getCustomerAddress?customerId='+newValue).success(function(data) {
			debugger
			console.log(data);
			$scope.blNoData.notify2=data.address;
 
		});


	}
});


$scope.$watch('blNoData.forwarderId', function(newValue,
		oldValue) {

	if (newValue != '' && newValue != undefined ) {


		$http.get($stateParams.tenantid+ '/api/outWard/getCustomerAddress?customerId='+newValue).success(function(data) {
			debugger
			console.log(data);
			$scope.blNoData.forwarder=data.address;
		});


	}
});

 

 
$http.get($stateParams.tenantid+ '/app/commonUtility/getVesselList').success(function(data) {
	$scope.vesselList = data;

});
$scope.$watch('blNoData.disvessel', function(newValue, oldValue) {
    if(newValue!=null && newValue!=undefined && newValue != ''){
		var disvessel=newValue;

  	  $http.post($stateParams.tenantid+ '/app/commonUtility/getVoyageListByVessel',disvessel).success(function(data) {
				$scope.voyageList = data;
  	  });
    }
  
  });
$scope.$watch('blNoData.bookingNo', function(newValue,oldValue) {

	if (newValue != '' && newValue != undefined && !$scope.isEdit) {
		var bookingNo=newValue;
		console.log("bookingNo",bookingNo);
		$http.get($stateParams.tenantid+'/api/shipOrder/fetchBooking?bookingNo='+bookingNo).success(function(data) {
			debugger;
			console.log("fetchBooking",data);
			var tmpList=[];
			
			$scope.blNoData.consigName=data.shipmentBean.cneeId;
			$scope.blNoData.agent =data.shipmentBean.agent;
			$scope.blNoData.client =data.shipmentBean.customer;
			$scope.blNoData.pod =data.shipmentBean.pod;
			$scope.blNoData.pol =data.shipmentBean.pol;
			$scope.blNoData.pod1 =data.shipmentBean.pod1;
			$scope.blNoData.pod2 =data.shipmentBean.pod2;
			$scope.blNoData.polSeq =data.shipmentBean.polSeq;
			$scope.blNoData.podSeq =data.shipmentBean.podSeq;
			$scope.blNoData.soc =data.shipmentBean.soc;
			$scope.blNoData.payer =data.shipmentBean.payer;
			$scope.blNoData.service =data.shipmentBean.freight;
			$scope.blNoData.fpod=data.shipmentBean.fpod;
			$scope.blNoData.freightAt=data.shipmentBean.freightAt;
			$scope.blNoData.freightBy=data.shipmentBean.freightBy;
			$scope.blNoData.contQuantInBooking=data.shipmentBean.contQuant;
			$scope.blNoData.disvessel =data.shipmentBean.disvessel;
			$scope.blNoData.disvoyage =data.shipmentBean.disvoyage;

			$scope.blNoData.vslVoyage =data.shipmentBean.vslVoyage;
			$scope.blNoData.deliveryAgent=data.shipmentBean.deliveryAgent;
			$scope.blNoData.detentionTariffType=data.shipmentBean.detentionTariffType;


		/*	$scope.blNoData.service =data.bookingBean.service;
			$scope.blNoData.vslVoyage =data.bookingBean.voyage;*/
			$scope.blNoData.blcntrDtlList=[];
			$scope.blNoData.blpckDtlList=[];
			
			/* $http.post($stateParams.tenantid+'/api/shipmentorder/getContainerListdrop',$scope.blNoData).success(function(datas) {
	 		        $scope.containerList = datas;
	 		    });*/
			
			
			  if($scope.isEdit){
				  debugger;
		  		  $http.get($stateParams.tenantid+'/api/shipmentorder/getContainerListEdit?bookingNo='+$scope.blNoData.bookingNo+'&jobNo='+$location.search().shipmentOrderId).success(function(datas) {
		   		        $scope.containerList1 = datas;
		   		    });
		  	  }
		  	  else{
		  		  debugger;
		  		  $http.get($stateParams.tenantid+'/api/shipmentorder/getContainerList?bookingNo='+$scope.blNoData.bookingNo).success(function(datas) {
		 		        $scope.containerList1 = datas;
		 		        console.log("getContainerList", $scope.containerList1);
		 		    });
		  	  }
			$timeout(function(){
			var containerListLength = $scope.containerList1.length;
		// for(var k=0; k < data.shipmentBean.boxData.length;k++){
			 for(var ctt=0;ctt<containerListLength;ctt++){
			 var temp={
						cntrNo : '',
						type: '',
						soc:false,
						sealNo: '',
						tw : '',
						  gw : '',
						  cb : '',
						  net : '',
						  fle : '',
						  packageType : '',
						  noOfPckgs : '',
						  goods : '',
						  iso : '',
						  hazardous : '',
						  ows : false,
						  marks : '',
						  polTer : '',
						  podTer : '',
						  action : '',
						  unCode:'',
						  imcoCharge:'',
						  gateOutDetailID:'',
						  prevBookingNo:'',
						chargeList : [],
						temperature:'',
						vent:'',
						humidity:'',
						celfah:'',
						frmGI:false,
						commodity:'',
				}
			    temp.type= $scope.containerList1[ctt].type;
			 temp.soc= $scope.containerList1[ctt].soc;
			    temp.cntrNo= $scope.containerList1[ctt].id;
			    temp.commodity= $scope.containerList1[ctt].commodity;
			    
			    temp.sealNo= $scope.containerList1[ctt].sealNo;
			    debugger;
			    if(temp.sealNo){
				    temp.sealNo= $scope.containerList1[ctt].sealNo;
				    temp.frmGI=true;
			    }else{
			    	temp.frmGI=false;
			    }
			
		  	    //temp.sealNo= data.shipmentBean.boxData[k].sealNo;
			    temp.goods= $scope.containerList1[ctt].goods;
			    temp.gateOutDetailID = $scope.containerList1[ctt].gateOutDetailID;
				 $scope.blNoData.blcntrDtlList.push(temp);
			 }
//				$scope.blNoData.blcntrDtlList.push(temp);
		
//				var temp1={
//						chargeCode : '',
//						  currency : '',
//						  unitRate : '',
//						  meaRate : '',
//						  wgRate : '',
//						  fromPlace : '',
//						  toPlace : '',
//						  minRate : '',
//						  terms : '',
//						  realAmount : ''
//				}
//			    temp1.unitRate= data.shipmentBean.boxData[k].chargeDtl.amount;
//				temp1.currency= data.shipmentBean.boxData[k].chargeDtl.currency;
//				temp1.chargeCode= data.shipmentBean.boxData[k].chargeDtl.surcharge;
			//	$scope.blNoData.blcntrDtlList[k].chargeList.push(temp1);
 		// }
			 
			 },5000);
												 
								});

			
  	
	}

$scope.updateData = function(blForm) {
	 if (new validationService() .checkFormValidity(blForm)) {
		 var chargee ;
 		var chargee1
 	

 		if($scope.blNoData.blcntrDtlList.length >0 ){
 			    			

 			//if($scope.blNoData.contQuantInBooking >= $scope.blNoData.blcntrDtlList.length){	    				
 
 		
		 var test;
 		if($scope.blNoData.blcntrDtlList.length >0 ){

 		for(var i=0;i<$scope.blNoData.blcntrDtlList.length;i++){
				
				if($scope.blNoData.blcntrDtlList[i].gateOutDetailID != null && $scope.blNoData.blcntrDtlList[i].gateOutDetailID != '' ){
					if(test == null && test == undefined){
						test = "true";
					}else{
						test = test + "," + "true";
					}
						
				}else{
					logger.logError("Gate Out Detail ID is NULL for Container ID ("+$scope.blNoData.blcntrDtlList[i].cntrNo+") !!!!");
					if(test == null && test == undefined){
						test = "false";
					}else{
						test = test + "," + "false";
					}
				}
				//$scope.blNoData.blcntrDtlList[i].gw = $scope.blNoData.blcntrDtlList[i].gw.replace(",","");
			}
 		var check =  test.split(",").includes("false") ? false : true ;
 		}
			console.log(check);
			if(check == false){
			}else{
			$scope.check1 = true;
			
		
			/*var count = 0;
			 var fpod =$scope.blNoData.fpod.substring(0, 5);
			 console.log("fpod1222222222",fpod);
			 
			 if(fpod == 'AEJEA' || fpod == 'DJJIB'){
				 count = 1;
			 }	*/
			
			/* if(count>0 && !$scope.blNoData.hsCode)
				{	 
					 logger.logError(" No shipments will be accepted without HS Code for this port.");
		     	  
				}else{	
						*/  $http.post($stateParams.tenantid+'/api/shipOrder/update', $scope.blNoData).success(function(result) {
					        console.log("result" + result);
					        if (result.isSuccess) {
					        	logger.logSuccess("Updated Successfully");
					            $state.go('app.documentation.shipmentorder.list',{tenantid:$stateParams.tenantid});
					        	 if(result.bookingNo != "" && result.bookingNo != null){
					       		  $rootScope.uploadFileSave(result.bookingNo);  
					       	  }
					       	  
					            
					        } else {
					            logger.logError(result.message);
								$scope.check1 = false;
					
					        }
					    }).error(function(result) {
					        console.log("data" + result);
					    });
					//}
			}
	 
	 /*}else{
			logger.logError("Container's list is not Matching with Booking Container Quantity...Booking Container Quantity: "+$scope.blNoData.contQuantInBooking+" ..!!!");

	 }*/
	 
}
	 }
	  else {
			toaster.pop( 'error',
							"Please fill the required fields",
							logger
									.getErrorHtmlNew($scope.blForm.$validationSummary),
							5000, 'trustedHtml');
			$scope.check1 = false;

		}
	}

$http.get($stateParams.tenantid+'/app/commonUtility/getPayerList').success(function(datas) {
    $scope.payerList = datas;
});


//add Container Row
$scope.addcntrDtl = function() {
	var blcntrDtl = {
			select : true,
			cntrNo : '',
			size : '',
			  type : '',
			  soc:false,
			  sealNo : '',
			  tw : '',
			  gw : '',
			  cb : '',
			  net : '',
			  fle : '',
			  packageType : '',
			  noOfPckgs : '',
			  goods : '',
			  iso : '',
			  hazardous : '',
			  ows : false,
			  marks : '',
			  polTer : '',
			  podTer : '',
			  action : '',
			  imcoCharge:'',
			  unCode :'',
			  gateOutDetailID:'',
			  chargeList : [],
			  temperature:'',
			  vent:'',
			  humidity:'',
			  celfah:''
	}
	$scope.blNoData.blcntrDtlList.push(blcntrDtl);
};

//add Container inner Row
$scope.addinnercntrDtl = function(blcntrDtl) {
	debugger
	var blcntrinnerDtl = {
			chargeCode : '',
			  currency : '',
			  unitRate : '',
			  meaRate : '',
			  wgRate : '',
			  fromPlace : '',
			  toPlace : '',
			  minRate : '',
			  terms : '',
			  realAmount : ''
	}
	blcntrDtl.chargeList.push(blcntrinnerDtl);
}
//add Package Row
$scope.addpckDtl = function() {
	var blpckDtl = {
			select : false,
			cntrNo : '',
			size : '',
			  type : '',
			  soc:false,
			  sealNo : '',
			  tw : '',
			  gw : '',
			  cb : '',
			  net : '',
			  fle : '',
			  packageType : '',
			  noOfPckgs : '',
			  goods : '',
			  iso : '',
			  hazardous : '',
			  ows : false,
			  marks : '',
			  polTer : '',
			  podTer : '',
			  action : '',
			  imcoCharge:'',
			  unCode:'',
			  gateOutDetailID:'',
			  packageList : [],
			  temperature:'',
			  vent:'',
			  humidity:'',
			  celfah:''
	}
	$scope.blNoData.blpckDtlList.push(blpckDtl);
};

$scope.addcharges = function() {
	var chrgDtl = { 
			  seq : '',
			  chargeCode : '',
			  currency : '',
			  qty : '',
			  rate : '',
			  amount : '',
			  payAt : '',
			  terms : '',
			  fromPlace : '',
			  toPlace : '',
			  invAmount : '',
			  realAmount : '' 
	}
	if($scope.blNoData.blCharges == undefined){
		$scope.blNoData.blCharges=[];
	}
	$scope.blNoData.blCharges.push(chrgDtl);
};

//validate
$scope.checkValidation = function() {

    var alertmsg = "<ui><h4 backgroundcolor=green>Please fill the required fields</h4>";
    var msg = "";

    if($scope.quotation.type=="Export"){
    if ($scope.checkundefined($scope.quotation.croNo)) {
        msg = msg + "<li>croNo :Field is required.</li>";         
        $scope.changecolor('customer_id');
    }else{
    	$scope.clearcolor('customer_id');
    }
    }
    
    if ($scope.checkundefined($scope.quotation.releaseDate)) {
        msg = msg + "<li>Release Date :Field is required.</li>";         
        $scope.changecolor('service');
    }else{
    	$scope.clearcolor('service');
    }
    
    
    angular.forEach($scope.quotation.quotationDtl, function(chargesDetail, index) {     
        if ($scope.checkundefined(chargesDetail.conType)) {
            msg = msg + "<li>Row :" + (index + 1) + "# container Type :Field is required.</li>";
            //$scope.changecolor('chargeHeads'+index);
        }else{
        	$scope.clearcolor('chargeHeads'+index);
        }
        if ($scope.checkundefined(chargesDetail.containerNo)) {
            msg = msg + "<li>Row :" + (index + 1) + "# Container No :Field is required.</li>";
            $scope.changecolor('unit'+index);
        }else{
        	$scope.clearcolor('unit'+index);
        }
       
        
        
    });
  	    
 	    
    alertmsg = alertmsg + msg + "</ui>";
    if ($scope.checkundefined(msg)) {
        return '';
    } else {
        return alertmsg;
    }

}

//validate end

//add Package inner Row
$scope.addinnerpckDtl = function(blpckDtl) {
	debugger
	var blpckinnerDtl = {
				hsCode : '',
				packageType : '',
				noofPcks : '',
				gw_ : '',
				goods : ''
	}
	blpckDtl.packageList.push(blpckinnerDtl);
}



$scope.deletecntrDtl = function(blcntrDtlList,trIndex) {
	 var table=[];
	 if($scope.blNoData.removeCntrCharge== null){
		 	$scope.blNoData.removeCntrCharge=[];
		 }
	 
	 for(var i=0;i< blcntrDtlList.length;i++){
		 if(trIndex == i){
			 if(blcntrDtlList[i].inwardContChargesId != null &&
					 blcntrDtlList[i].inwardContChargesId !=0){
				 $scope.blNoData.removeCntrCharge.push(blcntrDtlList[i].inwardContChargesId);
			 }
		 }
		 else{
			 table.push(blcntrDtlList[i]);
		 }
	 }
	 blcntrDtlList=[];
	 blcntrDtlList=table;
}


$scope.removepckCharge = function(blchargeList) {
	 var table=[];
	 if($scope.blNoData.removeCharge== null){
		 	$scope.blNoData.removeCharge=[];
		 }
	 
	 for(var i=0;i< blchargeList.length;i++){
		 if(blchargeList[i].select){
			 if(blchargeList[i].packageChargeId != null &&
					 blchargeList[i].inwardContChargesId !=0){
				 $scope.blNoData.removeCharge.push(blcntrDtlList[i].packageChargeId);
			 }
		 }
		 else{
			 table.push(blchargeList[i]);
		 }
	 }
	 blchargeList=[];
	 $scope.blNoData.blCharges=table;
}



$scope.deleteinnercntrDtl = function(blcntrDtl,bTrIndex) {
	 var table=[];
	 for(var i=0;i< blcntrDtl.chargeList.length;i++){
		 if(bTrIndex == i){
			 
		 }
		 else{
			 table.push(blcntrDtl.chargeList[i]);
		 }
	 }
	 blcntrDtl.chargeList=[];
	 blcntrDtl.chargeList=table;
}

 
$scope.deletepckDtl = function(blpckDtlList,trIndex) {
	 var table=[];
	 for(var i=0;i< blpckDtlList.length;i++){
		 if(trIndex == i){
			 
		 }
		 else{
			 table.push(blpckDtlList[i]);
		 }
	 }
	 blpckDtlList=[];
	 blpckDtlList=table;
}
$scope.deleteinnerpckDtl = function(blpckDtl,bTrIndex) {
	 var table=[];
	 if($scope.blNoData.removeCntrPckg== null){
		 	$scope.blNoData.removeCntrPckg=[];
		 }
	 for(var i=0;i< blpckDtl.packageList.length;i++){
		 if(bTrIndex == i){
			 if(blpckDtl.packageList[i].inwardPackageChargeId != null &&
					 blpckDtl.packageList[i].inwardPackageChargeId !=0){
				 $scope.blNoData.removeCntrPckg.push(blpckDtl.packageList[i].inwardPackageChargeId);
			 }
		 }
		 else{
			 table.push(blpckDtl.packageList[i]);
		 }
	 }
	 blpckDtl.packageList=[];
	 blpckDtl.packageList=table;
}

$scope.removepckDtl = function(pckgList) {
	 var table=[];
	 for(var i=0;i< pckgList.length;i++){
		 if(pckgList[i].select){
			 
		 }
		 else{
			 table.push(pckgList[i]);
		 }
	 }
	 $scope.blNoData.blpckDtlList=[];
	 $scope.blNoData.blpckDtlList=table;
}



$scope.removecntrDtl = function(blcntrDtlList) {
	 var table=[];
	 if($scope.blNoData.removeCntr== null){
		 	$scope.blNoData.removeCntr=[];
		 }
	 for(var i=0;i< blcntrDtlList.length;i++){
		 if(blcntrDtlList[i].select){
			 if(blcntrDtlList[i].inwardCntrId != null &&
					 blcntrDtlList[i].inwardCntrId != 0 ) {
				 $scope.blNoData.removeCntr.push(blcntrDtlList[i].inwardCntrId);
			 }
		 }
		 else{
			 table.push(blcntrDtlList[i]);
		 }
	 }
	 $scope.blNoData.blcntrDtlList=[];
	 $scope.blNoData.blcntrDtlList=table;
}

//=========================================================================================================
//File upload

$scope.fileUpload = function() {
	if($scope.blNoData.bookingNo != null && $scope.blNoData.bookingNo!= "" && $scope.blNoData.bookingNo != undefined){
		ngDialog.close();
		ngDialog.open({
			template : 'fileModal',
			scope : $scope
		});
	}else{
		logger.logError("Pleaes select the Booking No");
	}
	
};


$scope.exportSampleExcel = function() {
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

$rootScope.uploadFile1 = function(element) {

	console.log("excel file");
	$scope.excelfile = element.files[0];
	console.log($scope.excelfile);
}

$rootScope.closeFileDialog = function() {
	ngDialog.close();
};

$scope.isconsignee = true;
$rootScope.uploadFile= function() {
	
	// loader.start();
	var excelfile = $scope.excelfile;
	var fileExtension = excelfile.name;
	var fName = [];
	fName = fileExtension.split(".");
	for (var i = 0; i < fName.length; i++) {
		if (fName[i] == "xls" || fName[i] == "xlsx" || fName[i] == "XLS" || fName[i] == "XLSX") {
			var frmData = new FormData();
			frmData.append("file", excelfile);
			frmData.append("BlNo", $scope.blNoData.bookingNo);
			$.ajax({ type : "POST",
						url : $stateParams.tenantid+'/api/shipOrder/uploadfile',
						data : frmData,
						contentType : false,
						processData : false,
						success : function(response) {
							// loader.complete();
							if (response.isSuccess == true) {
								if(response.containersData.length > 0 && $scope.containerList.length >0){
									 for(var i=0; i < response.containersData.length;i++){
										 for(var j=0; j <$scope.containerList.length;j++){
											 if($scope.containerList[j].text ==response.containersData[i].containernumber){
												 response.containersData[i].cntrNo = $scope.containerList[j].id;
												}
											 }									
									}
								}
								
								 $scope.isconsignee  = response.shipmentBean.isConsignee;								 
								 $scope.blNoData.consigName=response.shipmentBean.consigName1;
								 $scope.blNoData.shipper=response.shipmentBean.shipper;
								 $scope.blNoData.cnee=response.shipmentBean.cnee;
								 $scope.blNoData.notify1=response.shipmentBean.notify1;
								 $scope.blNoData.notify2=response.shipmentBean.notify2;
								 
								 $scope.blNoData.shipperName=response.shipmentBean.shipperName;
								 $scope.blNoData.shipperCountry=response.shipmentBean.shipperCountry;								 
								 $scope.blNoData.shipperAddress=response.shipmentBean.shipperAddress;
								 $scope.blNoData.shipperTel=response.shipmentBean.shipperTel;
								 $scope.blNoData.shipperEmail=response.shipmentBean.shipperEmail;
								 
								 
								 $scope.blNoData.consigCountry=response.shipmentBean.consigCountry;
								 $scope.blNoData.consigAddress=response.shipmentBean.consigAddress;
								 $scope.blNoData.consigTel=response.shipmentBean.consigTel;
								 $scope.blNoData.consigEmail=response.shipmentBean.consigEmail;
								 
								 
								 $scope.blNoData.goods=response.shipmentBean.goods;
								 $scope.blNoData.g_wgt=response.shipmentBean.g_wgt;
								 $scope.blNoData.n_wgt=response.shipmentBean.n_wgt;
								 $scope.blNoData.ref=response.shipmentBean.ref;
								 $scope.blNoData.forwarder=response.shipmentBean.forwarder;	
								 $scope.blNoData.pkgs=response.shipmentBean.pkgs;									 
								 
								 $scope.blNoData.disPod=response.shipmentBean.disPod;
								 $scope.blNoData.disPol=response.shipmentBean.disPol;
								 $scope.blNoData.disPor=response.shipmentBean.disPor;
								 $scope.blNoData.disFpod=response.shipmentBean.disFpod;							 
								 $scope.blNoData.disvessel=response.shipmentBean.disvessel;
								 $scope.blNoData.disvoyage=response.shipmentBean.disvoyage;
								
								 $scope.blNoData.gw_unit = response.shipmentBean.unitOfMeasurement;
								 $scope.blNoData.billtype = response.shipmentBean.billtype;
								 if( response.shipmentBean.billtype == 'Sea Waybill')
									 {
									 $scope.blNoData.billtype = "Sea WayBill";
									 }
								 else if(response.shipmentBean.billtype == 'Ocean BL'){
									 
									 $scope.blNoData.billtype = "Normal BL";
								 }
								 

								 
								 var packageCode="";
								 var packageType="";
								  $scope.excelContainerList=response.shipmentBean.contList;
								  $scope.excelContainerDetailList=response.shipmentBean.conDescDataList;
								
								 for(var j=0;j<$scope.packageList.length;j++){
									 if($scope.packageList[j].text == response.shipmentBean.packagetype)
										 {
										 packageCode = $scope.packageList[j].id;
										 }
								 }
								 console.log("packageCode...",packageCode);
								 
								 for(var i=0;i<$scope.blNoData.blcntrDtlList.length;i++){
									
									 
									  $scope.blNoData.blcntrDtlList[i].packageType = packageCode;
									  

									  var currentContNo = $scope.containerList .filter(item => item.id == $scope.blNoData.blcntrDtlList[i].cntrNo )
									  
									  
									  for(var h=0;h<$scope.excelContainerList.length;h++){
										  
										  if($scope.excelContainerList[h].containerNo ==currentContNo[0].text ){
											  
											  if($scope.excelContainerList[h].temp.includes("+")){
												  var res = $scope.excelContainerList[h].temp.replace("+", "");
												  $scope.blNoData.blcntrDtlList[i].temperature = res;
											  }else{
												  $scope.blNoData.blcntrDtlList[i].temperature = $scope.excelContainerList[h].temp; 
											  }		
											  $scope.blNoData.blcntrDtlList[i].celfah = $scope.excelContainerList[h].celsiues;
											  $scope.blNoData.blcntrDtlList[i].vent = $scope.excelContainerList[h].vent;
											  $scope.blNoData.blcntrDtlList[i].humidity = $scope.excelContainerList[h].humidity;
											  $scope.blNoData.blcntrDtlList[i].unCode = $scope.excelContainerList[h].unCode;
											  $scope.blNoData.blcntrDtlList[i].imcoCharge = $scope.excelContainerList[h].imcoCharge;
											  break;
										  }
										
									  }
									  
									  for(var k=0;k<$scope.excelContainerDetailList.length;k++){
										  if($scope.excelContainerDetailList[k].containerNo ==currentContNo[0].text ){
											  $scope.blNoData.blcntrDtlList[i].sealNo = $scope.excelContainerDetailList[k].sealNo;
											  $scope.blNoData.blcntrDtlList[i].gw = $scope.excelContainerDetailList[k].grossWT;
											  $scope.blNoData.blcntrDtlList[i].cb = $scope.excelContainerDetailList[k].cbm;
											  $scope.blNoData.blcntrDtlList[i].noOfPckgs = parseInt($scope.excelContainerDetailList[k].noOfPkg);
											  
											  $scope.blNoData.blcntrDtlList[i].unCode = $scope.excelContainerList[k].unCode;
											  $scope.blNoData.blcntrDtlList[i].imcoCharge = $scope.excelContainerList[k].imcoCharge;
											 
											  
//											  for(var m=0;m<$scope.packageList.length;m++){
//													 if($scope.packageList[m].text == $scope.excelContainerDetailList[k].marksNos)
//														 {
//														 $scope.blNoData.blcntrDtlList[i].packageType = $scope.packageList[m].id;
//														 }
//												 }
											  
											 // $scope.blNoData.blcntrDtlList[i].packageType = $scope.excelContainerDetailList[k].marksNos;
											 
											  break;
										  }
										  
										 }
										 
									  
									  

								 }
								 
								 $scope.calcWeight();
								 if($scope.blNoData.pkgs ==0 || $scope.blNoData.pkgs == null){
 									 $scope.blNoData.pkgs=response.shipmentBean.pkgs;
								 }
								 if($scope.blNoData.n_wgt ==0 || $scope.blNoData.n_wgt == null){
 									 $scope.blNoData.n_wgt=response.shipmentBean.n_wgt;
								 }
								 							 

								 
								 console.log("$scope.blNoData1222",$scope.blNoData);
								 console.log("SIUploadResponse",response);
								 
								 $scope.isExcelUpload = true;
								
								 
								 
								 
								 
								 $scope.$apply();
								  
								 
/*								 var count =0;
								 for(var i=0; i < $scope.blNoData.blcntrDtlList.length;i++){									 
										 if($scope.blNoData.blcntrDtlList[i].cntrNo == ""){
											 count =count +1;
											}
										 									
								} 
								 if(count == $scope.blNoData.blcntrDtlList.length){
									 $scope.blNoData.blcntrDtlList = response.containersData;
								 }else{
									 $scope.blNoData.blcntrDtlList.concat(response.containersData);
								 }*/
								// $scope.blNoData.blcntrDtlList = response.containersData;
								$scope.closeFileDialog();
							} else {  
								logger.logError(response.message);
								$scope.closeFileDialog();
 							}
						}
					});
		}
	}
}
//Save file 

$rootScope.uploadFileSave= function(jobNo) {
	// loader.start();
	var excelfile = $scope.excelfile;
	var fileExtension = excelfile.name;
	var fName = [];
	fName = fileExtension.split(".");
	for (var i = 0; i < fName.length; i++) {
		if (fName[i] == "xls" || fName[i] == "xlsx") {
			var frmData = new FormData();
			frmData.append("file", excelfile);
			frmData.append("jobNo", jobNo);
			$.ajax({ type : "POST",
						url : $stateParams.tenantid+'/api/shipOrder/uploadfileSave',
						data : frmData,
						contentType : false,
						processData : false,
						success : function(response) { 
							if (response.isSuccess == true) {  
								$scope.closeFileDialog();
							} else {  
								logger.logError(response.message);
								 
 							}
						}
					});
		}
	}
}

//=========================================================================================================

//=========================================================================================================
//pop  for consigne upload


$scope.countryList=[];
	$scope.getcountryList=function(){
	$http.get($stateParams.tenantid+'/api/portform/countrylist').success(function(data) { 
	debugger
	$scope.countryList = data;
	console.log("countrylist");
	console.log( $scope.countryList);
	$timeout(function() {

$("#country").multiselect({
maxHeight: 200, 
includeSelectAllOption: true,
selectAllText : 'Select All',
enableFiltering : true,	
disableIfEmpty: true,
enableCaseInsensitiveFiltering: true,
numberDisplayed: 1,
onDropdownHide: function (event) {

}
});

	}, 3, false);
	
$("#multiselect-button").addClass("width_100 input-sm line-height-5");
	
if(editid != null && editid != ""){
	
	 $scope.compList = [];
 	 var valArr = $scope.consignee.countrycode.split(',');
 	 console.log("valarr",valArr);
 	 var i = 0, size = valArr.length;
 	 for (i; i < size; i++) {
 	 $("#country").find("option[value=" + valArr[i] + "]").prop("selected",  "selected");
 	                   	 angular.forEach($scope.countryList, function(value, key) {
 	 if (valArr[i] == value.id) {
 	 $scope.compList.push(value);
 	 }
 	
 	 });
 	 
 	 $scope.countryList = $scope.compList;
 	 }

}
	
	});

	};
	
	
	
	$scope.getcountryList();

	
	
$scope.consignee ={
		consigneecode : '',
		blNo : '',
		consigname : '',
		consigaddress : '',
		consigcountry : '',
		consigtel : '',
		consigemail : '',
		consigtaxnumber : '',
		consigcustname : '',
		created_by: '',
        created_date : '',
      modified_by: '',
   modified_date: '',
		
 };

$scope.consigneeAdd = function() { 

		ngDialog.open({
        template : '/views/ConsigneeAddPage.jsp',
        scope : $scope,
        showClose: false 
      });
};
 
$rootScope.cancelPopup = function() {
	ngDialog.close();
};


//save
$scope.saveConsignee = function(consignee,consigneeForm) {
	console.log($scope.consignee); 
		
	 $http.post($stateParams.tenantid+'/api/consignee/create', $scope.consignee).success(function(result) {    	
		 console.log(result);
         if (result.success) {
             logger.logSuccess("Consignee Added!");
             ngDialog.close();
             $scope.getConsigneeNameList();
             $scope.blNoData.consigName=result.consigneecode;
             $scope.isconsignee = true;
         } else {
         }             
     });
	
};

$scope.resetConsignee = function(){ 
	$scope.consignee ={
			consigneecode : '',
			blNo : '',
			consigname : '',
			consigaddress : '',
			consigcountry : '',
			consigtel : '',
			consigemail : '',
			consigtaxnumber : '',
			consigcustname : '',
			created_by: '',
	        created_date : '',
	      modified_by: '',
	   modified_date: '',
			
	 };
	
}

//=======================================================================================================================


$scope.calcWeight= function(){
	$scope.blNoData.n_wgt=0;
	$scope.blNoData.g_wgt=0;
	$scope.blNoData.cbm=0;
	$scope.blNoData.pkgs= 0;
	debugger;
angular.forEach($scope.blNoData.blcntrDtlList, function(value,key){
	debugger;
	 if(value.tw  != null  && value.tw  != ""  ){
		 $scope.blNoData.n_wgt =getNum(parseFloat($scope.blNoData.n_wgt))+parseFloat(value.tw) ;
		 console.log("Net Weight", $scope.blNoData.n_wgt);
	 }
 if(value.gw  != null  && value.gw  != ""  ){
	 $scope.blNoData.g_wgt =getNum(parseFloat($scope.blNoData.g_wgt))+parseFloat(value.gw) ;
	 console.log("Gross Weight", $scope.blNoData.g_wgt);
 }
 
 if(value.cb  != null  && value.cb  != ""  ){
	 $scope.blNoData.cbm =getNum(parseFloat($scope.blNoData.cbm))+parseFloat(value.cb) ;
	 console.log("CBM", $scope.blNoData.cbm);
 }
 
 if(value.noOfPckgs  != null  && value.noOfPckgs  != ""  ){
	 $scope.blNoData.pkgs =getNum(parseFloat($scope.blNoData.pkgs))+parseFloat(value.noOfPckgs) ;
	 console.log("No of Packages", $scope.blNoData.pkgs);
 }
 });

$scope.blNoData.n_wgt = parseFloat($scope.blNoData.n_wgt.toFixed(3));
$scope.blNoData.g_wgt = parseFloat($scope.blNoData.g_wgt.toFixed(3));
$scope.blNoData.cbm =parseFloat($scope.blNoData.cbm.toFixed(3));
$scope.blNoData.pkgs =parseFloat($scope.blNoData.pkgs.toFixed(3));
} 
	 

function getNum(val) {
	   if (isNaN(val)) {
	     return 0;
	   }
	   return val;
	}
});

app.controller('shippopuptableCtrl', function($scope, $http, $filter, logger,$stateParams) {/*
	 $scope.$watch('quotation.quotationDtl[trIndex].transactionType', function(newValue, oldValue) {
		 var id = newValue;
			$http.get($stateParams.tenantid+'/app/seaquotation/getServicePartnerListid?id='+ id).success(function(datas) {
				console.log(datas);				
				 $scope.serviceParnrDropList=datas.serviceParnrList;
			  
			}).error(function(data) {

			});
	  });
*/});

app.controller('shipmenttableCtrl', function($scope, $http, $filter, logger,
		$stateParams,$rootScope) {
	 /*$scope.$watchCollection('[blNoData.blcntrDtlList[trIndex].cntrNo]', function(newValue, oldValue) {
			$http.get($stateParams.tenantid+'/api/shipOrder/getCntrDtls?contrId='+newValue+'&bookingNo='+$scope.blNoData.bookingNo).success(function(data) {
				console.log("shipemntedittt123344",data);
$scope.blNoData.blcntrDtlList[$scope.trIndex].type=data.type;
debugger;
if(data.sealNo != null && data.sealNo.trim() != ''){
	$scope.fromGi = true;
	$scope.blNoData.blcntrDtlList[$scope.trIndex].sealNo=data.sealNo;
}
else{
	$scope.fromGi = false;
	$scope.blNoData.blcntrDtlList[$scope.trIndex].sealNo=data.scSealNo;
}

$scope.blNoData.blcntrDtlList[$scope.trIndex].soc=data.soc;

if(data.checkTypeWithBooking == false){
	logger.logError("Allocated Container Type does not match with Booking..!!! "+data.type);
	$rootScope.check1 =true;
	
} 
 	
			});
		 
	});*/
	 
		if($scope.isEdit  ==false){
			 $scope.$watch('blNoData.blcntrDtlList[$index].packageType', function(newValue, oldValue) {
				 debugger;
				 if($scope.isEdit != true  &&  !$scope.isExcelUpload){
				 console.log( $scope.blNoData.blcntrDtlList[$scope.$index]);
				 
				 if($scope.$index==0){
					 angular.forEach($scope.blNoData.blcntrDtlList,function(value,key){
						 value.packageType=newValue;
					 });
				 }
				 }
		     })
			}
 });
});
