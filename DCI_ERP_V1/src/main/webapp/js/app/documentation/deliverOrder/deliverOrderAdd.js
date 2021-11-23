
'use strict';
app.controller('deliverOrderAddCtrl', function($scope, $timeout, $stateParams,sharedProperties,toaster,
		$filter, $rootScope, $http, $location, logger, $state, ngDialog,$controller,$injector,validationService) {

	 $scope.isEdit=false;
	 
	 var todayDate = new Date();
		
	  var today = new Date(), dd = today.getDate(), mm = today.getMonth()+1, h=today.getHours(), mi=today.getMinutes(), yyyy = today.getFullYear(); 
		if(dd<10)
		{ dd='0'+dd; } 
		if(mm<10)
		{ mm='0'+mm; } 
		if(h<10)
		{ h='0'+h; } 
		if(mi<10)
		{ mi='0'+mi; } 
		
		var sterdayDtObj = new Date();
		var sterdayDt = sterdayDtObj.getDate() - 1;
		var myDate = new Date();
		 $scope.consigneeList=[];
		

		var todayDate = dd+'/'+mm+'/'+yyyy;
		
		$scope.checkSaveButtonDisable =false;
		
		//console.log(previousDate);
		//console.log(todayDate);
		
		//var someDate = new Date();
		//var numberOfDaysToAdd = 6;
		//today.setDate(today.getDate() + numberOfDaysToAdd);
		
		//console.log(today);
		
		$scope.portList=[];
	//ng-models
		$scope.deliveryorder = {
				rowId:'',
				blNo:'',
				mrn:'',
				container:'',mode:'',carrier:'',pod:'',podName:'',
				arrivalDate:'',
				vessel:'',
				shippingAgent:'',
				doNumber:'',
				rotationNumber:'',
				consignee:'',consignee1:'',
				voyage:'',
				clearencePort:'',
				remarks:'',
				currenctDate:'',
				dischargePort:'',
				agentdo:'',modeName:'',
				totQty:'',
				totWt:'',
				doimport:'',
				reexport:'',
				transit:'',
				tempadmission:'',
				dfsa:'',
				fz:'',
				cdrcash:'',
				cdr:'',
				deposit:'',
				credit:'',
				stang:'',
				bankg:'',
				other:'',				
				doNumber:'',
				
				packageType : '',
				quantity  : '',
				weigth : '',
				volume : '',
				goods : '',
				doAddress :'',
				doto : '',
				deliverDtl : [] ,
				doVaildDate:'',status:'',
				doRecipient:'',
				trnNo:'',
				doCheck:'',
				noc:'',
				nocCheck:'',
				mrnNumber:'',
				validDate:'',
				rotationNo:''
				
				
		}
		$scope.check=false;
		$scope.tempDtl={		
				net : '',
				gw : '',
				tw : '',
				sealNo : '',
				type : '',
				container : '',
				soc : false
					
				
		}
		
		$scope.donamesList = [{
			id : '1',
			text : 'Cnee'
			
		},{
			id : '2',
			text : 'Notify1'
			
		},{
			id : '3',
			text : 'Notify2'
			
		},{
			id : '4',
			text : 'Forwarder'
			
		},{
			id : '5',
			text : 'NOC receiver'
			
		},
		{
			id : '6',
			text : 'Third Party'
			
		}]
		
	    $scope.$watchCollection('[ deliveryorder.mode,deliveryorder.carrier,deliveryorder.vessel,deliveryorder.voyage,deliveryorder.pod]', function(newValue, oldValue) {
	    			   
	    	if($scope.deliveryorder.mode != null && $scope.deliveryorder.mode != ''){
					 $http.post($stateParams.tenantid+'/app/deiveryorder/getBLlist?voyage=' +$scope.deliveryorder.voyage+'&vessel=' +$scope.deliveryorder.vessel+'&carrier=' +$scope.deliveryorder.carrier+'&mode=' +$scope.deliveryorder.mode+'&pod=' +$scope.deliveryorder.pod).success(function(datas) {
							
						   $scope.blList=datas.blList;
						  
						}).error(function(datas) {

						}); }
		})
		

	/*	$scope.$watch('deliveryorder.mode', function(newValue,oldValue) {
		 
		 if(newValue != null && newValue != '' && $scope.deliveryorder.mode != null && $scope.deliveryorder.mode != ''){
			 if($scope.deliveryorder.mode=='4'){
				 $http.post($stateParams.tenantid+'/app/deiveryorder/blListLiner?carrier=' +$scope.deliveryorder.carrier+'&mode=' +$scope.deliveryorder.mode).success(function(datas) {
						
					   $scope.blList=datas.blList;
					  
					}).error(function(datas) {

					}); 
			 }else{
				 $http.post($stateParams.tenantid+'/app/deiveryorder/blList?carrier=' +$scope.deliveryorder.carrier+'&mode=' +$scope.deliveryorder.mode).success(function(datas) {
						
					   $scope.blList=datas.blList;
					  
					}).error(function(datas) {

					});  
			 }
			 
		 }
		 
		 
	 });
		
		$scope.$watch('deliveryorder.carrier', function(newValue,oldValue) {
		 
		 if(newValue != null && newValue != '' && $scope.deliveryorder.mode != null && $scope.deliveryorder.mode != ''){
			 if($scope.deliveryorder.mode=='4'){
				 $http.post($stateParams.tenantid+'/app/deiveryorder/blListLiner?carrier=' +$scope.deliveryorder.carrier+'&mode=' +$scope.deliveryorder.mode).success(function(datas) {
						
					   $scope.blList=datas.blList;
					  
					}).error(function(datas) {

					}); 
			 }else{
				 $http.post($stateParams.tenantid+'/app/deiveryorder/blList?carrier=' +$scope.deliveryorder.carrier+'&mode=' +$scope.deliveryorder.mode).success(function(datas) {
						
					   $scope.blList=datas.blList;
					  
					}).error(function(datas) {

					});  
			 }
			 
		 }
		 
		 
	 });*/
		
		/*$scope.$watch('deliveryorder.doto', function(newValue,oldValue) {
			 
			 if(newValue != null && newValue != '' && $scope.deliveryorder.blNo != null && $scope.deliveryorder.blNo != ''){
				 
				 $http.post($stateParams.tenantid+'/app/deiveryorder/getdoAddress?getdoAddress=' +newValue + '&getblNo=' +$scope.deliveryorder.blNo).success(function(data) {
				      	
				  		$scope.deliveryorder.doAddress=data.doAddress;
				  		        		
				  });
				 
				 
			 }
			 
			 
		 });*/
		 $scope.modeList=[];
		 $scope.carrierList=[];
		    
			$scope.getQuotationType = function() {
			    var  data = {};
			    data["id"] = "1";
			    data["text"] = "SEA COASTAL";
			    $scope.modeList.push(data);
			    //$scope.quotation.mode='1';
			    data = {};
			    data["id"] = "2";
			    data["text"] = "SEA FOREIGN";
			    $scope.modeList.push(data);
			    data = {};
			    data["id"] = "3";
			    data["text"] = "TRUCK";
			    $scope.modeList.push(data);
			    data = {};
			    data["id"] = "4";
			    data["text"] = "LINER";
				$scope.modeList.push(data);
				data = {};
			    data["id"] = "5";
			    data["text"] = "Forwarding"
			    $scope.modeList.push(data);
			}
			$scope.getQuotationType();
			
			
			$http.get($stateParams.tenantid+'/app/commonUtility/getcarrierList').success(function(datas) {
				debugger
			    $scope.carrierList = datas.commonUtilityBean;	    
		        //$scope.transList = datas.lCommonUtilityBean;	    

			}).error(function(data) {

			});
		 $scope.addressDO = false;
		$scope.$watch('deliveryorder.doto', function(newValue,oldValue) {
			
			 if($scope.deliveryorder.doto != null && $scope.deliveryorder.doto != '' && $scope.deliveryorder.doto != undefined){
				 
				 if($scope.deliveryorder.doto  == '4'){
					 $scope.addressDO = false;
				 }else  if($scope.deliveryorder.doto  == '5'){
					 $scope.addressDO = false;
				 }
				 else  if($scope.deliveryorder.doto  == '6'){
					 $scope.addressDO = false;
				 }else {
					 $scope.addressDO = true;
				 }
				 
			 }
		 });
	
	//cancel
	$scope.cancel = function() {
    	$state.go("app.operation.deliverOrder.list",{tenantid:$stateParams.tenantid});
    }
	
	
	/*//getblNo
	 $http.post($stateParams.tenantid+'/app/deiveryorder/getblNo').success(function(data) {
	      	
  		$scope.blnoList=data;
  		        		
  });*/
	 
	//getfpod
	 /*$http.post($stateParams.tenantid+'/app/deiveryorder/getFpod').success(function(data) {
	      	
  		$scope.fpodList=data; 
  		        		
     });*/

	  $http.post($stateParams.tenantid+'/app/master/hbl/dropDownList').success(function(data) {
    		$scope.fpodList=data.pod;
      		//$scope.termList=data.term;
        });	
	  $scope.termList = [
		       {id: '1', text: 'Collect'},
	       {id: '2', text: 'Prepaid'},
	       {id: '3', text: 'Third Pary Collect'},
	     ];
	    /*$http.get($stateParams.tenantid+'/app/commonUtility/agentList').success(function(datas) {
	    	console.log(datas);
	        $scope.agentList = datas;
	    }).error(function(data) {

	    });*/
		$http.post($stateParams.tenantid+'/app/seaquotation/getServicePartnerList').success(function(datas) {
			 $scope.agentList=datas.serviceParnrList;					
		}).error(function(data) {
		});
	 
	 
	//getvessel
	 $http.post($stateParams.tenantid+'/app/deiveryorder/getvessel').success(function(data) {
	      	
  		$scope.vesselList=data;
  		        		
  });
	 
	 $scope.check = true;
	 $scope.noccheck = false;
	 
	 $scope.checkDoRecipient= function (value){
		 if(value==true){
			 $scope.check = false;
		 }else{
			 $scope.check = true;
				$scope.deliveryorder.doRecipient = '';
		 }
	 }
	 
	 $scope.nocCheck = function (noc){
		 if(noc==true){
			 $scope.noccheck = true;
		 }else{
			 $scope.noccheck = false;
			 $scope.deliveryorder.noc = '';
		 } 
	 }
	 
	 
	
	 
	/* $http.get($stateParams.tenantid+'/api/outWard/getContainerListd').success(function(datas) {
	        $scope.containerList = datas;
	    });*/
	 
	 $http.post($stateParams.tenantid+'/app/seaquotation/getServicePartnerList').success(function(datas) {
			debugger
			 $scope.consigneeList = datas.customerList;
			 /*$scope.consigneeDropList = datas.consigneeList;
			 $scope.shipperDropList = datas.shipperList;
			 $scope.nominatedDropList = datas.nominatedList;
			 $scope.vendorDropList = datas.vendorList;
			 $scope.serviceParnrDropList=datas.serviceParnrList;*/
		}).error(function(data) {

		});
	 $http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(datas) {
		
		   $scope.containerList=datas.getcontainer;
		  
		}).error(function(datas) {

		});
	 
	 
	 $scope.voyageList =[];
	 $scope.$watch('deliveryorder.vessel', function(newValue,oldValue) {
		 
		 if(newValue != null && newValue != ''){
			 
			  //getvoyage
			 $http.post($stateParams.tenantid+'/app/deiveryorder/getvoyage?vesselId=' +newValue).success(function(data) {
				  
				  $scope.voyageList=data;
				  
			  });
			 
		 }
		 
		 
	 });
$scope.$watch('deliveryorder.voyage', function(newValue,oldValue) {

    if(newValue!=null && newValue!=undefined && newValue != ''){
  	  $http.post($stateParams.tenantid+ '/api/vesselArrival/getPortListByVoyage',newValue).success(function(data) {
				$scope.portList = data;
  	  });
    } 
	 });
	 /*$http.post($stateParams.tenantid+'/app/deiveryorder/blList').success(function(datas) {
			
		   $scope.blList=datas.blList;
		  
		}).error(function(datas) {

		});*/
	 
	/* $scope.blnoList =[];
	 $scope.$watch('deliveryorder.voyage', function(newValue,oldValue) {
		 
		 if(newValue != null && newValue != ''){		 
					  

				//getblNo
				 $http.post($stateParams.tenantid+'/app/deiveryorder/getblNo?getblNo=' +newValue + '&addoredit=' + $scope.isEdit.toString()).success(function(data) {
				      	
			  		$scope.blnoList=data;
			  		        		
			  });
			 
		 }
		 
		 
	 });*/
	 
	 var previousDay = new Date(myDate);

		
	 
	 $scope.$watch('deliveryorder.blNo', function(newValue,oldValue) {
		 
		 if(newValue != null && newValue != '' &&  $scope.isEdit == false){
			 
			 $http.post($stateParams.tenantid+'/app/deiveryorder/getcontainer',$scope.deliveryorder).success(function(response) {
				 
				if($scope.deliveryorder.mode=='5'){
				  console.log(response);
				  var weight =0;
				  if((response.isSuccess)){
					  
			  //	 if(response.blrelease!=false){
				  $scope.deliveryorder.deliverDtl = response.deliverDtl; 
				  $scope.deliveryorder.totQty = response.deliverDtl.length;

				  $scope.deliveryorder.carrier = response.carrier;
				  $scope.deliveryorder.vessel = response.vessel;
				  $scope.deliveryorder.voyage = response.voyage;
				  $scope.deliveryorder.clearencePort = response.clearencePort;
				  $scope.deliveryorder.dischargePort = response.dischargePort;
				  $scope.deliveryorder.consignee = response.consignee;
				  $scope.deliveryorder.goods = response.goods;
				  $scope.deliveryorder.weigth = response.weight;
				  $scope.deliveryorder.totWt = response.totalWeight;
				  $scope.deliveryorder.remarks = response.remarks;
				  $scope.deliveryorder.arrivalDate = response.arrivalDate;
				  $scope.deliveryorder.blType = response.blType;
				  $scope.deliveryorder.viewfreight = response.viewfreight;
				  $scope.doList = response.doList;
				  $scope.deliveryorder.shippingAgent = response.shippingAgent;
				  $scope.deliveryorder.status = response.status;
				  $scope.deliveryorder.mrnNumber = response.mrnNumber;
				  $scope.freeDays = response.deliverDtl[0].freedays;
				  $scope.deliveryorder.rotationNo =  response.rotationNo;
				  $scope.deliveryorder.consignee1 = response.consignee;
				  $scope.deliveryorder.pod = response.pod;
				  $scope.deliveryorder.podName = response.podName;
				  previousDay.setDate(myDate.getDate()+  $scope.freeDays);
					
				     var dd1 = previousDay.getDate(), mm1 = previousDay.getMonth()+1, h1=previousDay.getHours(), mi1=previousDay.getMinutes(), yyyy1 = previousDay.getFullYear(); 
				     if(dd1<10)
						{ dd1='0'+dd1; } 
				     if(mm1<10){ mm1='0'+mm1; } 

				
					var freeDate = dd1+'/'+mm1+'/'+yyyy1;
				  
				  $scope.deliveryorder.doVaildDate = freeDate;
				  $scope.checkSaveButtonDisable =false;
				  
				
		  
			 } else{
				 logger.logError(response.message);
				 $scope.checkSaveButtonDisable =true;
				 $scope.deliveryorder.deliverDtl =[];
				 $scope.deliveryorder.clearencePort = '';
				  $scope.deliveryorder.dischargePort = '';
				  $scope.deliveryorder.consignee = '';
				  $scope.deliveryorder.goods = '';
				  $scope.deliveryorder.weigth = '';
				  $scope.deliveryorder.remarks = '';
				  $scope.deliveryorder.arrivalDate = '';
				  $scope.doList ='';
				  $scope.deliveryorder.shippingAgent = '';
				  $scope.deliveryorder.vessel = '';
				  $scope.deliveryorder.voyage ='';
				  $scope.deliveryorder.blType = '';
				  $scope.deliveryorder.viewfreight = '';
				  $scope.deliveryorder.pod = '';

			 }
				  
			  }else{
				 
				
				  console.log(response);
				  var weight =0;
				  if((response.isSuccess)){
					  
		  if(response.arrivalDate!=null && response.arrivalDate!=undefined && response.arrivalDate!=''){
			  //	 if(response.blrelease!=false){
				  $scope.deliveryorder.deliverDtl = response.deliverDtl; 
				  $scope.deliveryorder.totQty = response.deliverDtl.length;
				  //consignee,goods,quantity,remarks,arrivalDate,shippingAgent
				 /* for(var i=0;i<response.deliverDtl.length;i++){
					
					  
				 weight = weight + response.deliverDtl[i].net;
					  
					  $scope.deliveryorder.totWt = weight;
					  
				  }*/
				  $scope.deliveryorder.carrier = response.carrier;
				  $scope.deliveryorder.vessel = response.vessel;
				  $scope.deliveryorder.voyage = response.voyage;
				  $scope.deliveryorder.clearencePort = response.clearencePort;
				  $scope.deliveryorder.dischargePort = response.dischargePort;
				  $scope.deliveryorder.consignee = response.consignee;
				  $scope.deliveryorder.goods = response.goods;
				  $scope.deliveryorder.weigth = response.weight;
				  $scope.deliveryorder.totWt = response.totalWeight;
				  $scope.deliveryorder.remarks = response.remarks;
				  $scope.deliveryorder.arrivalDate = response.arrivalDate;
				  $scope.deliveryorder.blType = response.blType;
				  $scope.deliveryorder.viewfreight = response.viewfreight;
				  $scope.doList = response.doList;
				  $scope.deliveryorder.shippingAgent = response.shippingAgent;
				  $scope.deliveryorder.status = response.status;
				  $scope.deliveryorder.mrnNumber = response.mrnNumber;
				  $scope.freeDays = response.deliverDtl[0].freedays;
				  $scope.deliveryorder.rotationNo =  response.rotationNo;
				  $scope.deliveryorder.consignee1 = response.consignee;
				  $scope.deliveryorder.pod = response.pod;
				  $scope.deliveryorder.podName = response.podName;
				  previousDay.setDate(myDate.getDate()+  $scope.freeDays);
					
				     var dd1 = previousDay.getDate(), mm1 = previousDay.getMonth()+1, h1=previousDay.getHours(), mi1=previousDay.getMinutes(), yyyy1 = previousDay.getFullYear(); 
				     if(dd1<10)
						{ dd1='0'+dd1; } 
				     if(mm1<10){ mm1='0'+mm1; } 

				
					var freeDate = dd1+'/'+mm1+'/'+yyyy1;
				  
				  $scope.deliveryorder.doVaildDate = freeDate;
				  $scope.checkSaveButtonDisable =false;
				  
				 /* $scope.deliveryorder.vessel = response.vessel;
				  $scope.deliveryorder.voyage = response.voyage;*/
			  	/* }else{
			  		logger.logError("BL Not Surrendered, Cannot Generate DO..!!") 
			  	 }*/
		  }else {
				 logger.logError("Vessel has not arrived the port!");
				 $scope.checkSaveButtonDisable =true;
				 $scope.deliveryorder.deliverDtl =[];
				 $scope.deliveryorder.deliverDtl =[];
				 $scope.deliveryorder.clearencePort = '';
				  $scope.deliveryorder.dischargePort = '';
				  $scope.deliveryorder.consignee = '';
				  $scope.deliveryorder.goods = '';
				  $scope.deliveryorder.weigth = '';
				  $scope.deliveryorder.remarks = '';
				  $scope.deliveryorder.arrivalDate = '';
				  $scope.doList ='';
				  $scope.deliveryorder.shippingAgent = '';
				  $scope.deliveryorder.vessel = '';
				  $scope.deliveryorder.voyage ='';
				  $scope.deliveryorder.blType = '';
				  $scope.deliveryorder.viewfreight = '';
			 }
		  
			 } else{
				 logger.logError(response.message);
				 $scope.checkSaveButtonDisable =true;
				 $scope.deliveryorder.deliverDtl =[];
				 $scope.deliveryorder.clearencePort = '';
				  $scope.deliveryorder.dischargePort = '';
				  $scope.deliveryorder.consignee = '';
				  $scope.deliveryorder.goods = '';
				  $scope.deliveryorder.weigth = '';
				  $scope.deliveryorder.remarks = '';
				  $scope.deliveryorder.arrivalDate = '';
				  $scope.doList ='';
				  $scope.deliveryorder.shippingAgent = '';
				  $scope.deliveryorder.vessel = '';
				  $scope.deliveryorder.voyage ='';
				  $scope.deliveryorder.blType = '';
				  $scope.deliveryorder.viewfreight = '';

			 }
				  
			 } });
		 }
			 
		 });
 

	
	
	
	
	
 	
 		
 		//getblNo
 		 $http.get($stateParams.tenantid+'/app/deiveryorder/getblNumbers').success(function(data) {
 			 
 			if($scope.isEdit == false){
 	 	      	
 	   		$scope.deliveryorder.doNumber=data.doNumber;
 	   		$scope.deliveryorder.currenctDate=data.currenctDate;
 	   		
 			}
 	   		        		
 	   });
 		
 	
	
	
	
	//save
	  $scope.save = function(deliveryorderForm,deliveryorder) {	  
		  if (new validationService().checkFormValidity($scope.deliveryorderForm)) {
			  
			  
			  $http.post($stateParams.tenantid+'/app/deiveryorder/add',$scope.deliveryorder).success(function(response) {
		         if(response.success == 'true'){
		             logger.logSuccess("Saved Succesfully!");     
		             $state.go("app.operation.deliverOrder.list",{tenantid:$stateParams.tenantid});                  
		             }else{
		      	   logger.logError(response.message);
		         }
		      });
			  
		  } else{
	            toaster.pop('error', "Please fill the required fields", 
	                    logger.getErrorHtmlNew($scope.deliveryorderForm.$validationSummary), 555000, 'trustedHtml');
	                       }
	}
	  
	  //update
		$scope.update = function(deliveryorderForm, deliveryorder) {
			
			
			$scope.deliveryorder.rowId = $location.search().rowId;
			
			if (new validationService().checkFormValidity(deliveryorderForm)) {
				
				
					
					 $http.post($stateParams.tenantid+'/app/deiveryorder/update', $scope.deliveryorder).success(function(response) {
									if (response.success == 'true' ) {
										logger.logSuccess("Updated Succesfully!");
										$state.go("app.operation.deliverOrder.list",{tenantid:$stateParams.tenantid});
									} else {
										logger.logError("Error in Update");
									}
								});
			} else {
				toaster.pop('error',"Please fill the required fields",logger.getErrorHtmlNew(deliveryorderForm.$validationSummary),5000, 'trustedHtml');
			}
		};
	  
	  
		//DO Revalidation
		
		
				$scope.revalidation = function(deliveryorderForm, deliveryorder) {
					
					 $http.post($stateParams.tenantid+'/app/deiveryorder/doRevalidation', $scope.deliveryorder).success(function(response) {
							if (response.success == 'true' ) {
								logger.logSuccess("Do Revalidation Updated Succesfully!");
								$state.go("app.operation.deliverOrder.list",{tenantid:$stateParams.tenantid});
							} else {
								logger.logError("Error in Update");
							}
						});
				
				}
	  
				
				$scope.apply = function(validDate){
					if( validDate != null && validDate != "" ){
						for(var i=0;i<$scope.deliveryorder.deliverDtl.length;i++){
		                	 $scope.deliveryorder.deliverDtl[i].doValiddate = validDate;

						}
					}
					
				}
		
	//edit
	  var rowId = $location.search().rowId;
	  if(rowId != null){
		  $scope.isEdit=true;
	
		 


	      
		  $http.post($stateParams.tenantid+'/app/deiveryorder/edit?rowId=' +rowId).success(function(result) {
	          
	          if (result.success == false) {
	              logger.logError("Please Try Again");
	          } else {
	              console.log(result);
	              $scope.deliveryorder = result;
				  $scope.deliveryorder.blNo = result.blNo;
				  $scope.deliveryorder.mode = result.mode;
	             $scope.deliveryorder.blNoNew= result.blNoNew;

	              if(result.doimport == "true"){
	            	  $scope.deliveryorder.doimport = true;
	              }else {
	            	  $scope.deliveryorder.doimport = false;
	              }
	              if($scope.deliveryorder.nocCheck==true){
	            	  $scope.noccheck = true;
	              }else{
	            	  $scope.noccheck = false;
	              }
	              if(result.reexport == "true"){
	            	  $scope.deliveryorder.reexport = true;
	              }else {
	            	  $scope.deliveryorder.reexport = false;
	              }
	              
	              if(result.transit == "true"){
	            	  $scope.deliveryorder.transit = true;
	              }else {
	            	  $scope.deliveryorder.transit = false;
	              }
	              
	              if(result.tempadmission == "true"){
	            	  $scope.deliveryorder.tempadmission = true;
	              }else {
	            	  $scope.deliveryorder.tempadmission = false;
	              }
	              
	              if(result.dfsa == "true"){
	            	  $scope.deliveryorder.dfsa = true;
	              }else {
	            	  $scope.deliveryorder.dfsa = false;
	              }
	              
	              if(result.fz == "true"){
	            	  $scope.deliveryorder.fz = true;
	              }else {
	            	  $scope.deliveryorder.fz = false;
	              }
	              
	              
	              if(result.cdrcash == "true"){
	            	  $scope.deliveryorder.cdrcash = true;
	              }else {
	            	  $scope.deliveryorder.cdrcash = false;
	              }
	              
	              if(result.cdr == "true"){
	            	  $scope.deliveryorder.cdr = true;
	              }else {
	            	  $scope.deliveryorder.cdr = false;
	              }
	              
	              
	              if(result.deposit == "true"){
	            	  $scope.deliveryorder.deposit = true;
	              }else {
	            	  $scope.deliveryorder.deposit = false;
	              }
	              
	              if(result.credit == "true"){
	            	  $scope.deliveryorder.credit = true;
	              }else {
	            	  $scope.deliveryorder.credit = false;
	              }
	              
	              if(result.stang == "true"){
	            	  $scope.deliveryorder.stang = true;
	              }else {
	            	  $scope.deliveryorder.stang = false;
	              }
	              
	              if(result.bankg == "true"){
	            	  $scope.deliveryorder.bankg = true;
	              }else {
	            	  $scope.deliveryorder.bankg = false;
	              }
	              

	              if(result.other == "true"){
	            	  $scope.deliveryorder.other = true;
	              }else {
	            	  $scope.deliveryorder.other = false;
	              }
	              
	              if(result.fit == "true"){
	            	  $scope.deliveryorder.fit = true;
	              }else {
	            	  $scope.deliveryorder.fit = false;
	              }
	              if(result.mode != null && result.mode != ''){
	 				 
	  			    if(result.mode==1){
	  					result.modeName = "SEA COASTAL";
	  		    }else  if(result.mode==2){
	  					result.modeName = "SEA FOREIGN";
	  		    }else  if(result.mode==3){
	  					result.modeName = "TRUCK";
	  		    }else  if(result.mode==4){
	  					result.modeName = "LINER";
				  }
				  else  if(result.mode==5){
	  					result.modeName = "Forwarding";
	  		    }
	  		}   
	             
	          }
	            
	         }).error(function(data) {

	         });
	  }
	  
	  
	  //update
		$scope.print = function(deliveryorderForm, deliveryorder) {
		
			if($scope.deliveryorder.receiptDate!=null && $scope.deliveryorder.receiptDate!='' && $scope.deliveryorder.amount!=null && $scope.deliveryorder.amount!=''){
				$scope.deliveryorder.rowId = $location.search().rowId;
				
				var rowId = $scope.deliveryorder.rowId;
				
				 var url = $stateParams.tenantid+'/app/deiveryorder/deliveryorderPrint?doNumber=' + rowId;
		         var wnd = window.open(url, 'Simatech', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
		         wnd.print();
			}else{
				  ngDialog.open({
		              template : '/views/documentation/deliverOrder/do_popup',
		              scope : $scope,
//		              closeByEscape: true
		            });
				  
				  $timeout(function() {
						$("#receiptDateId").datetimepicker({
							minDate : "01/01/2016",
							format : 'DD/MM/YYYY',
							pickTime : false
						});
					}, 1000);

					$("#receiptDateId").on(
							"dp.change",
							function(e) {
								$scope.deliveryorder.receiptDate = $(
										'#receiptDateId').val();
							});
			}
			 
		};
		
		/*$scope.doPrint = function (deliveryorderForm, deliveryorder){
		
			 var url = $stateParams.tenantid+'/app/deiveryorder/deliveryorderPrint?doNumber=' + deliveryorder.rowId;
	         var wnd = window.open(url, 'Simatech', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
	         wnd.print();
		}*/
	
		$scope.updateDoPop = function(doPopUpForm){
			if (new validationService().checkFormValidity(doPopUpForm)) {
				$http.post($stateParams.tenantid+'/app/deiveryorder/updatePop', $scope.deliveryorder).success(function(response) {
					if (response.success == true ) {
						logger.logSuccess("Updated Succesfully!");
						var url = $stateParams.tenantid+'/app/deiveryorder/deliveryorderPrint?doNumber=' + rowId;
				         var wnd = window.open(url, 'Simatech', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
				         wnd.print();
						ngDialog.close();
					} else {
						logger.logError("Unable to save!");
					}
				});
			}else{
				toaster.pop('error',"Please fill the required fields",logger.getErrorHtmlNew(doPopUpForm.$validationSummary),5000, 'trustedHtml');
			}
		}
	
		$scope.cancelDoPop = function(){
			$scope.deliveryorder.amount=0;
			$scope.deliveryorder.receiptDate='';
			$scope.deliveryorder.chequeNo='';
			$scope.deliveryorder.paymentRemarks='';
			ngDialog.close();
		}
});