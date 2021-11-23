'use strict';

app.controller('hbwAddCtrl', function($scope, $rootScope, $http, $location, logger, ngDialog,
        utilsService,$state,sharedProperties,$window,$stateParams,toaster,validationService) {

 $scope.displayedCollection = [];
var date  = new Date();
var dateString =  date.getDate() + "/" + date.getMonth() + "/" + date.getFullYear() + " " + date.getHours() + ":" + date.getMinutes();
	$scope.rowCollectionFollowup=[];
    $scope.referralList=[];
    $scope.isEdit = false;
    $scope.tairDetailList =[];
	
	

    $scope.cancel = function() {
	  	  $state.go('app.air.hbw.list',{tenantid:$stateParams.tenantid});
	  	  
	          
	    };
    
	   
		    $scope.lHbwlContainerBean =[];
		    $scope.hbw = {
		            
		    	    jobNo:'',
		    		 hbwNo:'',
		    		 mbwNo:'',
		    		 agreed:'',
		    		 hbwDocNo:'',
		    		 hbwDocDate:'',
		    		 mbwDocNo:'',
		    		 mbwDocDate:'',
		    		 vesselVoyeage:'',
		    		 feederVesselVoyeage:'',
		    		 vendor:'',
		    		 issuePlace:'',
		    		 customer:'',
		    		 etd:'',
		    		 etaAtPod:'',
		    		 igmNo:'',
		    		 igmDate:'',
		    		 itemNo:'',
		    		 to:'',
		    		 doRemarks:'',
		    		 canRemarks:'',
		    		 branch:'',
		    		 aol:'',
		    		 aod:'',
		    		 term:'',
		    		 salesPerson:'',
		    		 vessel:'',
		    		 origin:'',
		    		 destination:'',
		    		 arrivalDate:'',
		    		 commodity:'',
		    		 sealNo:'',
		    		 status:'',
		    		 measureMent:'',
		    		 remarks:'',
		    	     descriptionofGoods:'',
		    	     lWHUOM:'',
		    	     noOfPieces:'',
		    	     shipper:'',
		    		 size:'',
		    		 noofPackage:'',
		    		 uOm:'',
		    		 grossWeight:'',
		    		 netWeight:'',
		    		  chargeableWeight:'',
		    		 rateCharge:'',
		    		 height:'',
		    		 weight:'',
		    		 lenght:'',
		    		 amount:'',
		    		 consignee:'',
		    		 shipperAddress:'',
		    		 consigneeAddress:'',
		    		 notifyAddress:'',
		    		 accountingInformation:'',
		    		 handlingInformation:'',
		    		 airportOfDepature:'',
		    		 toDepature:'',
		    		 issuingCarringAgent:'',
		    		 byFirstCarrier:'',
		    		 bySecondCarrier:'',
		    		 requestedFlightDate:'',
		    		 airportOfDestination:'',
		    		 airportOfDischarge2:'',
		    		 requestedFlightDate2:'',
		    		 iATACode:'',
		    		 airportOfDischarge3:'',
		    		 byThirdCarrier:'',
		    		 containerNumber:'',
		    		 freightPayableAt:'',
		    		 noOfOriginalBl:'',
		    		 preCarriagedBy:'',
		    		 valuationCharge:'',
		    		 tax:'',
		    		 totalChargeCarrier:'',
		    		 amountOfInsurance:'',
		    		 totalChargeAgent:'',
		    		 chargesCode:'',
		    		 weightValuationCharge:'',
		    		 otherCharge:'',
		    		 otherChargeDesc:'',
		    		 dvForCarriage:'',
		    		 dvForCustoms:'',
		    		 consolidationNumber:'',
		    		 exportReferences:'',
		    		 shipperReferences:'',
		    		 ftzNumber:'',
		    		 loadingPierTerminal:'',
		    		 coLoadedWith:'',
		    		 containarized:'',
		    	     destinationAgentCode:'',
		    	     currency:'',
		    	     cargoInsurance:'',
		    	     movement:'',
		    		 notify:'',
		    	     mbwCode:'',
		    		 hbwCode:'',
		    		 modifedBy:'',
		    		 modifedDate:'',
		    		 polCode:'',
		    		 podCode:'',
		    		 originCode:'',
		    		 destionationCode:'',
		         };
		    
			  $scope.lTempHbwlContainerBean = {
						select 		:false,
						commodity:'',
						descriptionOfGoods:'',
						lWHUOM:'',
						length:'',	
						width:'',
						height:'',	 
						noOfPieces:'',	 
						netWeight:'',
						grossWeight:'',
						remarks:'',
						chargeableWeight:'',
						amount:'',
						rateCharge:'',

					};
    
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

				$scope.hbw.hbwDate = dd + '/' + mm + '/'
						+ yyyy;
		  
	 //add Row
	  $scope.addCredRow = function() {
	   
		  var tmp=angular.copy($scope.lTempHbwlContainerBean);
			$scope.lHbwlContainerBean.push(tmp);

	  }
	  $scope.addCredRow();

		$scope.removeCredRow =function(){
			if($scope.isEdit==false){
				var tmpDelList = [];
				for(var i=$scope.lHbwlContainerBean.length-1;i>=0;i--){
					if($scope.lHbwlContainerBean[i].select==true){
						tmpDelList.push($scope.lHbwlContainerBean[i]);
						$scope.lHbwlContainerBean.splice(i, 1);
					}
				}
				logger.logSuccess('Deleted Successfully');
			}else if($scope.isEdit==true){
				var tmpDelList = [];
				for(var i=$scope.lHbwlContainerBean.length-1;i>=0;i--){
					if($scope.lHbwlContainerBean[i].select==true){
						tmpDelList.push($scope.lHbwlContainerBean[i]);
					}
				}
				$http.post($stateParams.tenantid+'/app/air/hbw/deleteContainerDetail',tmpDelList).success(function(data) {
		        	if(data.success){
		        		for(var i=$scope.lHbwlContainerBean.length-1;i>=0;i--){
		    				if($scope.lHbwlContainerBean[i].select==true){
		    					$scope.lHbwlContainerBean.splice(i, 1);
		    				}
		    			}
		        		logger.logSuccess('Deleted Successfully');
		        	}else{
		        		logger.logError('Unable to delete');
		        	}
				})
			}
			
		}
		 $scope.packageCalculation = function(noOfPieces,
					trIndex, row) {
				// row.cbpDtlTcAmount =parseFloat(tcAmount);
				if (row.noOfPieces != 0 && row.noOfPieces != "") {
					
						var noOfPieces = noOfPieces;
						/*row.noOfPieces = parseFloat(noOfPieces).toFixed(
								2);*/
						$scope.totalPackageCalculation();
					} 
			}
			$scope.totalPackageCalculation = function() {
				debugger;
				var mablContainerBean = $scope.lHbwlContainerBean;
				var noOfPieces = 0;
				angular.forEach(mablContainerBean, function(item, key) {
					var mablContainerBeanData = mablContainerBean[key];
					noOfPieces = noOfPieces + parseFloat(item.noOfPieces);
					$scope.totalPackage = noOfPieces;
				});

				/*$scope.cbpmtDtlTotalAmt.totalBCAmount = $scope.cbpmtDtlTotalAmt.totalBCAmount
						.toFixed(2);
				$scope.cbpmtDtlTotalAmt.totalTCAmount = $scope.cbpmtDtlTotalAmt.totalTCAmount
						.toFixed(2);*/
			}
		  
			 $scope.grossWeightCalculation = function(grossWeight,
						trIndex, row) {
					if (row.grossWeight != 0 && row.grossWeight != "") {
						
							var grossWeights = grossWeight;
							/*row.grossWeight = parseFloat(grossWeight).toFixed(
									2);*/
							$scope.totalgrossWeightCalculation();
						} 
				}
				$scope.totalgrossWeightCalculation = function() {
					debugger;
					var mablContainerBean = $scope.lHbwlContainerBean;
					var grossWeight = 0;
					
					angular.forEach(mablContainerBean, function(item, key) {
						var mablContainerBeanData = mablContainerBean[key];

						grossWeight = grossWeight + parseFloat(item.grossWeight);
						$scope.totalgrossWeight = grossWeight;

					});

				}
				 $scope.netWeightCalculation = function(netWeight,
							trIndex, row) {
						if (row.netWeight != 0 && row.netWeight != "") {
							
								var netWeights = netWeight;
								/*row.netWeight = parseFloat(netWeight).toFixed(
										2);*/
								$scope.totalnetWeightCalculation();
							} 
					}
					$scope.totalnetWeightCalculation = function() {
						debugger;
						var mablContainerBean = $scope.lHbwlContainerBean;
						var netWeight=0;
						
						angular.forEach(mablContainerBean, function(item, key) {
							var mablContainerBeanData = mablContainerBean[key];

							netWeight = netWeight + parseFloat(item.netWeight);
							$scope.totalnetWeight = netWeight;

						});

					}
					 $scope.amountCalculation = function(amount,
								trIndex, row) {
							if (row.amount != 0 && row.amount != "") {
								
									var amounts = amount;
									/*row.netWeight = parseFloat(netWeight).toFixed(
											2);*/
									$scope.totalamountCalculation();
								} 
						}
						$scope.totalamountCalculation = function() {
							debugger;
							var mablContainerBean = $scope.lHbwlContainerBean;
							var amount=0;
							
							angular.forEach(mablContainerBean, function(item, key) {
								var mablContainerBeanData = mablContainerBean[key];

								amount = amount + parseFloat(item.amount);
								$scope.totalamount = amount;

							});

						}
		  
		var servicePartnerId = $location.search().rowid;
		if(servicePartnerId!=null && servicePartnerId!=undefined && servicePartnerId>0){
			$scope.isEdit=true;
	        $http.post($stateParams.tenantid+'/app/air/hbw/edit?hblId='+servicePartnerId).success(function(data) {
	        	if(data.success){
	        		$scope.hbw = data.hblBean;
	        		$scope.lHbwlContainerBean=data.lHbwContainerBean;
	        		$scope.mblList1=data.mbwdoc;
	        		if($scope.hbw.shipperAddress != null && $scope.hbw.shipperAddress != ''){
	           			 var text5 =$scope.hbw.shipperAddress;
	                        text5 = text5.replace(/\r?<br>/g, '\n');
	                        $scope.hbw.shipperAddress=text5;
	           		}
	           		if($scope.hbw.consigneeAddress != null  && $scope.hbw.consigneeAddress != '' ){
	           			 var text6 =$scope.hbw.consigneeAddress;
	                        text6 = text6.replace(/\r?<br>/g, '\n');
	                        $scope.hbw.consigneeAddress=text6;
	           		}
	           		if($scope.hbw.notifyAddress != null  && $scope.hbw.notifyAddress != '' ){
	          			 var text7 =$scope.hbw.notifyAddress;
	          			text7 = text7.replace(/\r?<br>/g, '\n');
	                       $scope.hbw.notifyAddress=text7;
	          		}
	        		for(var i=0;i<$scope.lHbwlContainerBean.length;i++) 
                	{
                	if($scope.lHbwlContainerBean[i].lWHUOM!=null&&$scope.lHbwlContainerBean[i].lWHUOM!='')
                		{
                		$scope.lHbwlContainerBean[i].lWHUOM=$scope.lHbwlContainerBean[i].lWHUOM.toString();

                		}
                	if($scope.lHbwlContainerBean[i].descriptionofGoods != null  && $scope.lHbwlContainerBean[i].descriptionofGoods != '' ){
   					 var text9 = $scope.lHbwlContainerBean[i].descriptionofGoods;
   					  text9 = text9.replace(/\r?<br>/g, '\n');
   			         $scope.lHbwlContainerBean[i].descriptionofGoods=text9;
   				}

                	}
	        		
	        		$scope.hbw.jobNo = data.hblBean.jobNo.toString();
	        		if(data.hblBean.mbwNo != null && data.hblBean.mbwNo != ''){
	        			$scope.hbw.mbwNo = data.hblBean.mbwNo.toString();
	        		}
	        		
	        		$scope.hbw.aol = data.hblBean.aol.toString();
	        		$scope.hbw.aod = data.hblBean.aod.toString();
	        		$scope.hbw.term = data.hblBean.term.toString();
	        		$scope.hbw.customer = data.hblBean.customer.toString();
	        		$scope.hbw.branch = data.hblBean.branch.toString();

	        	
	        		if(data.hblBean.origin!=null&&data.hblBean.origin!='')
	    			{
	        		$scope.hbw.origin = data.hblBean.origin.toString();

	    			}

	        		if(data.hblBean.destination!=null&&data.hblBean.destination!='')
	    			{
	        		$scope.hbw.destination = data.hblBean.destination.toString();

	    			}
	        		if(data.hblBean.salesPerson!=null&&data.hblBean.salesPerson!='')
	    			{
	        		$scope.hbw.salesPerson = data.hblBean.salesPerson.toString();

	    			}
	    		   if(data.hblBean.shipper!=null && data.hblBean.shipper!='')
				   {
	        		$scope.hbw.shipper = data.hblBean.shipper.toString();

				    }
	    		   if(data.hblBean.consignee!=null && data.hblBean.consignee!='')
				   {
	        		$scope.hbw.consignee = data.hblBean.consignee.toString();

				    }
	    		  
	    		   if(data.hblBean.airportOfDischarge2!=null && data.hblBean.airportOfDischarge2!='')
				   {
	        		$scope.hbw.airportOfDischarge2 = data.hblBean.airportOfDischarge2.toString();

				    }
	    		   if(data.hblBean.airportOfDischarge3!=null && data.hblBean.airportOfDischarge3!='')
				   {
	        		$scope.hbw.airportOfDischarge3 = data.hblBean.airportOfDischarge3.toString();

				    }
	    		   if(data.hblBean.to!=null && data.hblBean.to!='')
				   {
	        		$scope.hbw.to = data.hblBean.to.toString();

				    }
	    		  
	    		   if(data.hblBean.weightValuationCharge!=null && data.hblBean.weightValuationCharge!='')
				   {
	        		$scope.hbw.weightValuationCharge = data.hblBean.weightValuationCharge.toString();

				    }
	    		   if(data.hblBean.chargesCode!=null && data.hblBean.chargesCode!='')
				   {
	        		$scope.hbw.chargesCode = data.hblBean.chargesCode.toString();

				    }
	    		   if(data.hblBean.currency!=null && data.hblBean.currency!='')
				   {
	        		$scope.hbw.currency = data.hblBean.currency.toString();

				    }
	    		   if(data.hblBean.otherCharge!=null && data.hblBean.otherCharge!='')
				   {
	        		$scope.hbw.otherCharge = data.hblBean.otherCharge.toString();

				    }
	    		   $scope.totalPackageCalculation();
	    		   $scope.totalnetWeightCalculation();
	    		   $scope.totalgrossWeightCalculation();
	    		   $scope.totalamountCalculation();
	    		   
	        		
        		  $http.post($stateParams.tenantid+'/app/master/hbl/dropDownList').success(function(data) {
      	          	
      	          	$scope.vendorList=data.vendor;
      	      		$scope.customerList=data.customer;
      	      		$scope.termList=data.term;
      	      		$scope.destinationList=data.destination;
      	      		$scope.originList=data.origin;
      	      		$scope.branchList=data.branch;
      	      		$scope.podList=data.pod;
      	      		$scope.polList=data.pol;
      	      		$scope.typeList=data.typeList;
      	      		$scope.movementList=data.movement;
      	      		$scope.preCarriageList=data.preCarriaged;
      	      		$scope.destinationAgentList=data.destination;	
      	      		$scope.hblList=data.hbl;
      	      		$scope.consigneeList=data.customer;
      	      	//	$scope.mblList=data.mbw;
      	      		$scope.hblList=data.hbw;
      	      		$scope.jobList=data.airJob;
              		$scope.salesPersonList=data.salesPerson;
              		$scope.otherChargesList=data.paymentList;
              		$scope.iataList=data.iataList;
              		$scope.currencyList=data.currency;


              		
      	          });	
	        	
	        	}else{
	        		logger.logError("Unable to fetch data");
	        	}
	        });
		}
		$scope.mblList1=[];
		$scope.$watch('hbw.jobNo',function(newValue, oldValue) {
		if(newValue!=null && newValue!=undefined && newValue!=""){
		
				
			
	        $http.post($stateParams.tenantid+'/app/air/hbw/getJobDetail?jobNo='+newValue).success(function(data) {
	        	if(data.success){
	        		$scope.mblList=data.mbw;
	        		if($scope.isEdit==false)
	    			{
	        		$scope.lHbwlContainerBean=data.lHbwContainerBean;
	        		
	        		$scope.hbw.aol = data.hblBean.aol.toString();
	        		$scope.hbw.aod = data.hblBean.aod.toString();
	        		$scope.hbw.term = data.hblBean.term.toString();
	        		$scope.hbw.customer = data.hblBean.customer.toString();
	        		$scope.hbw.branch = data.hblBean.branch.toString();
	        		$scope.hbw.origin = data.hblBean.origin.toString();
	        		$scope.hbw.destination = data.hblBean.destination.toString();
	        		$scope.hbw.airportOfDepature=data.lHbwContainer[0].airportOfDepature;
	        		$scope.hbw.airportOfDestination=data.lHbwContainer[0].airportOfDestination;
	        		$scope.hbw.issuePlace=data.lHbwContainer[0].issuePlace;
	        		$scope.hbw.issuingCarringAgent=data.lHbwContainer[0].issuingCarringAgent;
	        		$scope.hbw.byFirstCarrier=data.lHbwContainer[0].byFirstCarrier;
	        		$scope.hbw.shipperAddress=data.hbwDocBean.shipperAddress;
	        		$scope.hbw.consigneeAddress=data.hbwDocBean.consigneeAddress;
	        		$scope.hbw.notifyAddress=data.hbwDocBean.notifyAddress;
	        		$scope.mblList1=data.mbwdoc;
	        		$scope.hbw.mbwNo=data.mbwdoc[0].id;
	        		$scope.hbw.mbwDocNo=data.hbwDocBean.mbwDocNo;
	        		$scope.hbw.mbwDocDate=data.hbwDocBean.mbwDocDate;
	        		
	        		if(data.hblBean.salesPerson!=null&&data.hblBean.salesPerson!='')
	    			{
	        		$scope.hbw.salesPerson = data.hblBean.salesPerson.toString();

	    			}
	    		   if(data.hblBean.shipper!=null && data.hblBean.shipper!='')
				   {
	        		$scope.hbw.shipper = data.hblBean.shipper.toString();

				    }
	    		   if(data.hblBean.consignee!=null && data.hblBean.consignee!='')
				   {
	        		$scope.hbw.consignee = data.hblBean.consignee.toString();

				    }
	    		   
	    		   for(var j=$scope.lHbwlContainerBean.length-1 ;j>=0;j-- )
	     			{
	     		$scope.lHbwlContainerBean[j]=data.lHbwContainerBean[j];
	     		if(data.lHbwContainerBean[j].lWHUOM != null){
	     		$scope.lHbwlContainerBean[j].lWHUOM = data.lHbwContainerBean[j].lWHUOM.toString();
	     		}
	     			}
	    		   
	    		   $scope.totalPackageCalculation();
	    		   $scope.totalnetWeightCalculation();
	    		   $scope.totalgrossWeightCalculation();
	    		   $scope.totalamountCalculation();
	        	
	  
	    		   $http.post($stateParams.tenantid+'/app/master/hbl/dropDownList').success(function(data) {
	      	          	
	      	          	$scope.vendorList=data.vendor;
	      	      		$scope.customerList=data.customer;
	      	      		$scope.termList=data.term;
	      	      		$scope.destinationList=data.destination;
	      	      		$scope.originList=data.origin;
	      	      		$scope.branchList=data.branch;
	      	      		$scope.podList=data.pod;
	      	      		$scope.polList=data.pol;
	      	      		$scope.typeList=data.typeList;
	      	      		$scope.movementList=data.movement;
	      	      		$scope.preCarriageList=data.preCarriaged;
	      	      		$scope.destinationAgentList=data.destination;	
	      	      		$scope.hblList=data.hbl;
	      	      		$scope.consigneeList=data.customer;
	      	      		//$scope.mblList=data.mbw;
	      	      		$scope.hblList=data.hbw;
	      	      		$scope.jobList=data.airJob;
	              		$scope.salesPersonList=data.salesPerson;
	              		$scope.otherChargesList=data.paymentList;
	              		$scope.iataList=data.iataList;
	              		$scope.currencyList=data.currency;
	              		$scope.iataListDetail=data.iataListDetail;

	              		
	      	          });	
	        		
        		
	        	
	        	}}else{
	        		logger.logError("Unable to fetch data");
	        	}
	        });
			}
		//}
		});
		  $http.post($stateParams.tenantid+'/app/master/hbl/dropDownList').success(function(data) {
	          
	          		$scope.vendorList=data.vendor;
      	      		$scope.customerList=data.customer;
      	      		$scope.termList=data.term;
      	      		$scope.destinationList=data.destination;
      	      		$scope.originList=data.origin;
      	      		$scope.branchList=data.branch;
      	      		$scope.podList=data.pod;
      	      		$scope.polList=data.pol;
      	      		$scope.typeList=data.typeList;
      	      		$scope.movementList=data.movement;
      	      		$scope.preCarriageList=data.preCarriaged;
      	      		$scope.destinationAgentList=data.destination;	
      	      		$scope.hblList=data.hbl;
      	      		$scope.consigneeList=data.customer;
      	      		//$scope.mblList=data.mbw;
      	      		$scope.hblList=data.hbw;
      	      		$scope.jobList=data.airJob;
              		$scope.salesPersonList=data.salesPerson;
              		$scope.iataList=data.iataList;
              		$scope.otherChargesList=data.paymentList;
              		$scope.currencyList=data.currency;
              		$scope.iataListDetail=data.iataListDetail;


	          	
	          });
		  $http.get(
					$stateParams.tenantid
							+ '/app/airquotation/getuomList')
					.success(function(datas) {
						$scope.uomList = datas.commonUtilityBean;

					}).error(function(data) {

					});
		$scope.save = function(hbwForm){
			if (new validationService().checkFormValidity(hbwForm)) {
	            var flag1 = true, flag2 = true, flag3 = true, flag4 = true, flag5 = true,flag6 = true, flag7 = true, flag8 = true, flag9 = true, flag10 = true, flag11 = true, flag12 = true, flag13 = true, flag14 = true, flag15 = true;

				if($scope.hbw.hbwDocDate=="" || $scope.hbw.hbwDocDate==undefined)
				{
				$scope.hbw.hbwDocDate=null
				}
			
			if($scope.hbw.mbwDocDate=="" || $scope.hbw.mbwDocDate==undefined)
			{
			$scope.hbw.mbwDocDate=null
			}
			if($scope.hbw.etaAtPod=="" || $scope.hbw.etaAtPod==undefined)
			{
			$scope.hbw.etaAtPod=null
			}
			if($scope.hbw.etd=="" || $scope.hbw.etd==undefined)
			{
			$scope.hbw.etd=null
			}
			if($scope.hbw.requestedFlightDate=="" || $scope.hbw.requestedFlightDate==undefined)
			{
			$scope.hbw.requestedFlightDate=null
			}
			if($scope.hbw.requestedFlightDate2=="" || $scope.hbw.requestedFlightDate2==undefined)
			{
			$scope.hbw.requestedFlightDate2=null
			}
			if($scope.hbw.shipperAddress != null && $scope.hbw.shipperAddress != ''){
				 var text = $scope.hbw.shipperAddress;
		         text = text.replace(/\r?\n/g, '<br>');
		         var res = text.replace("–", "-");
	             $scope.hbw.shipperAddress=res;
			}
			if($scope.hbw.consigneeAddress != null  && $scope.hbw.consigneeAddress != '' ){
				 var text1 = $scope.hbw.consigneeAddress;
		         text1 = text1.replace(/\r?\n/g, '<br>');
		         var res1 = text1.replace("–", "-");
	             $scope.hbw.consigneeAddress=res1;
			}
			if($scope.hbw.notifyAddress != null  && $scope.hbw.notifyAddress != '' ){
				 var text2 = $scope.hbw.notifyAddress;
		         text2 = text2.replace(/\r?\n/g, '<br>');
		         var res2 = text2.replace("–", "-");
	            $scope.hbw.notifyAddress=res2;
			}
			
			if($scope.hbw.accountingInformation != null  && $scope.hbw.accountingInformation != '' ){
				 var acf = $scope.hbw.accountingInformation;
				 acf = acf.replace(/\r?\n/g, '<br>');
		         var acf1 = acf.replace("–", "-");
	            $scope.hbw.accountingInformation=acf1;
			}
			
			if($scope.hbw.handlingInformation != null  && $scope.hbw.handlingInformation != '' ){
				 var handlingInf = $scope.hbw.handlingInformation;
				 handlingInf = handlingInf.replace(/\r?\n/g, '<br>');
		         var handlingInf1 = handlingInf.replace("–", "-");
	            $scope.hbw.handlingInformation=handlingInf1;
			}
			
			 if ($scope.hbw.tax != undefined && $scope.hbw.tax != null && $scope.hbw.tax != '') {
	           if(flag11==true)
	        	   {
					 flag11 = validateDouble($scope.hbw.tax);

	        	   }
	         }
			 if ($scope.hbw.totalChargeAgent != undefined && $scope.hbw.totalChargeAgent != null && $scope.hbw.totalChargeAgent != '') {
				 if(flag12==true)
	        	   {
				 flag12 = validateDouble($scope.hbw.totalChargeAgent);
	        	   }
	         }
			 if ($scope.hbw.totalChargeCarrier != undefined && $scope.hbw.totalChargeCarrier != null && $scope.hbw.totalChargeCarrier != '') {
				 if(flag13==true)
	        	   {
				 flag13 = validateDouble($scope.hbw.totalChargeCarrier);
	        	   }
	         }
			 if ($scope.hbw.valuationCharge != undefined && $scope.hbw.valuationCharge != null && $scope.hbw.valuationCharge != '') {
				 if(flag14==true)
	        	   {
				 flag14 = validateDouble($scope.hbw.valuationCharge);
	        	   }
	         }
			 if ($scope.hbw.amountOfInsurance != undefined && $scope.hbw.amountOfInsurance != null && $scope.hbw.amountOfInsurance != '') {
				 if(flag15==true)
	        	   {
				 flag15 = validateDouble($scope.hbw.amountOfInsurance);
	        	   }
	         }
			for(var i=0;i<$scope.lHbwlContainerBean.length;i++){
				 if ($scope.lHbwlContainerBean[i].nofPieces != undefined && $scope.lHbwlContainerBean[i].nofPieces != null && $scope.lHbwlContainerBean[i].nofPieces != '') {
					 if(flag1==true)
		        	   {
					 flag1 = validateNos($scope.lHbwlContainerBean[i].nofPieces);
		        	   }
		         }	
				 
				 if($scope.lHbwlContainerBean[i].descriptionofGoods != null  && $scope.lHbwlContainerBean[i].descriptionofGoods != '' ){
					 var text9 = $scope.lHbwlContainerBean[i].descriptionofGoods;
					 text9 = text9.replace(/\r?\n/g, '<br>');
			         var res9 = text9.replace("–", "-");
			         $scope.lHbwlContainerBean[i].descriptionofGoods=res9;
				}
				 if ($scope.lHbwlContainerBean[i].lWH != undefined && $scope.lHbwlContainerBean[i].lWH != null && $scope.lHbwlContainerBean[i].lWH != '') {
					 if(flag2==true)
		        	   {
					 flag2 = validateNos($scope.lHbwlContainerBean[i].lWH);
		        	   }
		         }
				 if ($scope.lHbwlContainerBean[i].netWeight != undefined && $scope.lHbwlContainerBean[i].netWeight != null && $scope.lHbwlContainerBean[i].netWeight != '') {
					 if(flag3==true)
		        	   {
					 flag3 = validateDouble($scope.lHbwlContainerBean[i].netWeight);
		        	   }
		         }
				 if ($scope.lHbwlContainerBean[i].grossWeight != undefined && $scope.lHbwlContainerBean[i].grossWeight != null && $scope.lHbwlContainerBean[i].grossWeight != '') {
					 if(flag4==true)
		        	   {
					 flag4 = validateDouble($scope.lHbwlContainerBean[i].grossWeight);
		        	   }
		         }
				 if ($scope.lHbwlContainerBean[i].length != undefined && $scope.lHbwlContainerBean[i].length != null && $scope.lHbwlContainerBean[i].length != '') {
					 if(flag5==true)
		        	   {
					 flag5 = validateDouble($scope.lHbwlContainerBean[i].length);
		        	   }
		         }	
				 if ($scope.lHbwlContainerBean[i].width != undefined && $scope.lHbwlContainerBean[i].width != null && $scope.lHbwlContainerBean[i].width != '') {
					 if(flag6==true)
		        	   {
					 flag6 = validateDouble($scope.lHbwlContainerBean[i].width);
		        	   }
		        	   }
				 if ($scope.lHbwlContainerBean[i].height != undefined && $scope.lHbwlContainerBean[i].height != null && $scope.lHbwlContainerBean[i].height != '') {
					 if(flag7==true)
		        	   {
					 flag7 = validateDouble($scope.lHbwlContainerBean[i].height);
		        	   }
		         }
				 if ($scope.lHbwlContainerBean[i].charcheableWeight != undefined && $scope.lHbwlContainerBean[i].charcheableWeight != null && $scope.lHbwlContainerBean[i].charcheableWeight != '') {
					 if(flag8==true)
		        	   {
					 flag8 = validateDouble($scope.lHbwlContainerBean[i].charcheableWeight);
		        	   }
		         }
				 if ($scope.lHbwlContainerBean[i].rate != undefined && $scope.lHbwlContainerBean[i].rate != null && $scope.lHbwlContainerBean[i].rate != '') {
					 if(flag9==true)
		        	   {
					 flag9 = validateDouble($scope.lHbwlContainerBean[i].rate);
		        	   }
		         }	
				 if ($scope.lHbwlContainerBean[i].amount != undefined && $scope.lHbwlContainerBean[i].amount != null && $scope.lHbwlContainerBean[i].amount != '') {
					 if(flag10==true)
		        	   {
					 flag10 = validateDouble($scope.lHbwlContainerBean[i].amount);
		        	   }
		         }
				
			}
				var obj = {
						hblBean : $scope.hbw,
						lHbwContainerBean	: $scope.lHbwlContainerBean,
				}
				if (flag1 == true && flag2 == true && flag2 == true && flag3 == true && flag4 == true && flag5 == true && flag6 == true && flag7== true && flag8 == true && flag9 == true && flag4 == true && flag10 == true && flag11 == true && flag12 == true && flag13 == true && flag14 == true && flag15 == true) {

	            $http.post($stateParams.tenantid+'/app/air/hbw/save',obj).success(function(data) {
	            	if(data.success){
	            		logger.logSuccess('Saved Successfully');
	            		$location.url($stateParams.tenantid+'/hbw/edit?rowid='+data.hbwId);       
	            		//$scope.cancel();
	            	}else{
	            		logger.logError('Unable to save!');
	            	}
	            	
	            });
			}
			else {
	            if (flag1 == false) {
	                logger.logError("Please Enter Number Value for No Of Pieces in Container Details");
	            }
	            if (flag2 == false) {
	                logger.logError("Please Enter Number Value for LWH in Container Details");
	            }
	            if (flag3 == false) {
	                logger.logError("Please Enter Number Value for NetWeight in Container Details");
	            }
	            if (flag4 == false) {
	                logger.logError("Please Enter Number Value for GrossWeight in Container Details");
	            }
	            if (flag5 == false) {
	                logger.logError("Please Enter Number Value for Length in Container Details");
	            }
	            if (flag6 == false) {
	                logger.logError("Please Enter Number Value for Width in Container Details");
	            }
	            if (flag7 == false) {
	                logger.logError("Please Enter Number Value for Height in Container Details");
	            }
	            if (flag8 == false) {
	                logger.logError("Please Enter Number Value for Chargable Weight in Container Details");
	            }
	            if (flag10 == false) {
	                logger.logError("Please Enter Number Value for Rate in Container Details");
	            }
	            if (flag9 == false) {
	                logger.logError("Please Enter Number Value for Amount in Container Details");
	            }
	            if (flag11 == false) {
	                logger.logError("Please Enter Number Value for Tax");
	            }
	            if (flag12 == false) {
	                logger.logError("Please Enter Number Value for Total Other Charges Due To Agent");
	            }
	            if (flag13 == false) {
	                logger.logError("Please Enter Number Value for Total Other Charges Due To Carrier");
	            }
	            if (flag14 == false) {
	                logger.logError("Please Enter Number Value for Valuation Charges");
	            }
	            if (flag15 == false) {
	                logger.logError("Please Enter Number Value for Amount");
	            }
	        
	        }
			}else {
	            toaster.pop('error', "Please fill the required fields", 
	                    logger.getErrorHtmlNew(hbwForm.$validationSummary), 5000, 'trustedHtml');
	        }
		}
		$scope.update = function(servicePartnerAddForm){
			if (new validationService().checkFormValidity(servicePartnerAddForm)) {
	            var flag1 = true, flag2 = true, flag3 = true, flag4 = true, flag5 = true,flag6 = true, flag7 = true, flag8 = true, flag9 = true, flag10 = true, flag11 = true, flag12 = true, flag13 = true, flag14 = true, flag15 = true;

	            if($scope.hbw.shipperAddress != null && $scope.hbw.shipperAddress != ''){
	      			 var text = $scope.hbw.shipperAddress;
	      	         text = text.replace(/\r?\n/g, '<br>');
	      	      var res = text.replace("–", "-");
	                   $scope.hbw.shipperAddress=res;
	      		}
	      		if($scope.hbw.consigneeAddress != null  && $scope.hbw.consigneeAddress != '' ){
	      			 var text1 = $scope.hbw.consigneeAddress;
	      	         text1 = text1.replace(/\r?\n/g, '<br>');
	      	      var res1 = text1.replace("–", "-");
	                   $scope.hbw.consigneeAddress=res1;
	      		}
	      		if($scope.hbw.notifyAddress != null  && $scope.hbw.notifyAddress != '' ){
	     			 var text2 = $scope.hbw.notifyAddress;
	     	         text2 = text2.replace(/\r?\n/g, '<br>');
	     	       var res2 = text2.replace("–", "-");
	                  $scope.hbw.notifyAddress=res2;
	     		}
	      		
	      		if($scope.hbw.accountingInformation != null  && $scope.hbw.accountingInformation != '' ){
					 var acf = $scope.hbw.accountingInformation;
					 acf = acf.replace(/\r?\n/g, '<br>');
			         var acf1 = acf.replace("–", "-");
		            $scope.hbw.accountingInformation=acf1;
				}
				
				if($scope.hbw.handlingInformation != null  && $scope.hbw.handlingInformation != '' ){
					 var handlingInf = $scope.hbw.handlingInformation;
					 handlingInf = handlingInf.replace(/\r?\n/g, '<br>');
			         var handlingInf1 = handlingInf.replace("–", "-");
		            $scope.hbw.handlingInformation=handlingInf1;
				}
	      		
				if($scope.hbw.hbwDocDate=="" || $scope.hbw.hbwDocDate==undefined)
				{
				$scope.hbw.hbwDocDate=null
				}
			
			if($scope.hbw.mbwDocDate=="" || $scope.hbw.mbwDocDate==undefined)
			{
			$scope.hbw.mbwDocDate=null
			}
			if($scope.hbw.etaAtPod=="" || $scope.hbw.etaAtPod==undefined)
			{
			$scope.hbw.etaAtPod=null
			}
			if($scope.hbw.etd=="" || $scope.hbw.etd==undefined)
			{
			$scope.hbw.etd=null
			}
			if($scope.hbw.requestedFlightDate=="" || $scope.hbw.requestedFlightDate==undefined)
			{
			$scope.hbw.requestedFlightDate=null
			}
			if($scope.hbw.requestedFlightDate2=="" || $scope.hbw.requestedFlightDate2==undefined)
			{
			$scope.hbw.requestedFlightDate2=null
			}

			 if ($scope.hbw.tax != undefined && $scope.hbw.tax != null && $scope.hbw.tax != '') {
	           if(flag11==true)
	        	   {
					 flag11 = validateDouble($scope.hbw.tax);

	        	   }
	         }
			 if ($scope.hbw.totalChargeAgent != undefined && $scope.hbw.totalChargeAgent != null && $scope.hbw.totalChargeAgent != '') {
				 if(flag12==true)
	        	   {
				 flag12 = validateDouble($scope.hbw.totalChargeAgent);
	        	   }
	         }
			 if ($scope.hbw.totalChargeCarrier != undefined && $scope.hbw.totalChargeCarrier != null && $scope.hbw.totalChargeCarrier != '') {
				 if(flag13==true)
	        	   {
				 flag13 = validateDouble($scope.hbw.totalChargeCarrier);
	        	   }
	         }
			 if ($scope.hbw.valuationCharge != undefined && $scope.hbw.valuationCharge != null && $scope.hbw.valuationCharge != '') {
				 if(flag14==true)
	        	   {
				 flag14 = validateDouble($scope.hbw.valuationCharge);
	        	   }
	         }
			 if ($scope.hbw.amountOfInsurance != undefined && $scope.hbw.amountOfInsurance != null && $scope.hbw.amountOfInsurance != '') {
				 if(flag15==true)
	        	   {
				 flag15 = validateDouble($scope.hbw.amountOfInsurance);
	        	   }
	         }
			 for(var i=0;i<$scope.lHbwlContainerBean.length;i++){
				 if ($scope.lHbwlContainerBean[i].nofPieces != undefined && $scope.lHbwlContainerBean[i].nofPieces != null && $scope.lHbwlContainerBean[i].nofPieces != '') {
					 if(flag1==true)
		        	   {
					 flag1 = validateNos($scope.lHbwlContainerBean[i].nofPieces);
		        	   }
		         }	
				 
				 if($scope.lHbwlContainerBean[i].descriptionofGoods != null  && $scope.lHbwlContainerBean[i].descriptionofGoods != '' ){
					 var text9 = $scope.lHbwlContainerBean[i].descriptionofGoods;
					 text9 = text9.replace(/\r?\n/g, '<br>');
			         var res9 = text9.replace("–", "-");
			         $scope.lHbwlContainerBean[i].descriptionofGoods=res9;
				}
				 
				 if ($scope.lHbwlContainerBean[i].lWH != undefined && $scope.lHbwlContainerBean[i].lWH != null && $scope.lHbwlContainerBean[i].lWH != '') {
					 if(flag2==true)
		        	   {
					 flag2 = validateNos($scope.lHbwlContainerBean[i].lWH);
		        	   }
		         }
				 if ($scope.lHbwlContainerBean[i].netWeight != undefined && $scope.lHbwlContainerBean[i].netWeight != null && $scope.lHbwlContainerBean[i].netWeight != '') {
					 if(flag3==true)
		        	   {
					 flag3 = validateDouble($scope.lHbwlContainerBean[i].netWeight);
		        	   }
		         }
				 if ($scope.lHbwlContainerBean[i].grossWeight != undefined && $scope.lHbwlContainerBean[i].grossWeight != null && $scope.lHbwlContainerBean[i].grossWeight != '') {
					 if(flag4==true)
		        	   {
					 flag4 = validateDouble($scope.lHbwlContainerBean[i].grossWeight);
		        	   }
		         }
				 if ($scope.lHbwlContainerBean[i].length != undefined && $scope.lHbwlContainerBean[i].length != null && $scope.lHbwlContainerBean[i].length != '') {
					 if(flag5==true)
		        	   {
					 flag5 = validateDouble($scope.lHbwlContainerBean[i].length);
		        	   }
		         }	
				 if ($scope.lHbwlContainerBean[i].width != undefined && $scope.lHbwlContainerBean[i].width != null && $scope.lHbwlContainerBean[i].width != '') {
					 if(flag6==true)
		        	   {
					 flag6 = validateDouble($scope.lHbwlContainerBean[i].width);
		        	   }
		        	   }
				 if ($scope.lHbwlContainerBean[i].height != undefined && $scope.lHbwlContainerBean[i].height != null && $scope.lHbwlContainerBean[i].height != '') {
					 if(flag7==true)
		        	   {
					 flag7 = validateDouble($scope.lHbwlContainerBean[i].height);
		        	   }
		         }
				 if ($scope.lHbwlContainerBean[i].charcheableWeight != undefined && $scope.lHbwlContainerBean[i].charcheableWeight != null && $scope.lHbwlContainerBean[i].charcheableWeight != '') {
					 if(flag8==true)
		        	   {
					 flag8 = validateDouble($scope.lHbwlContainerBean[i].charcheableWeight);
		        	   }
		         }
				 if ($scope.lHbwlContainerBean[i].rate != undefined && $scope.lHbwlContainerBean[i].rate != null && $scope.lHbwlContainerBean[i].rate != '') {
					 if(flag9==true)
		        	   {
					 flag9 = validateDouble($scope.lHbwlContainerBean[i].rate);
		        	   }
		         }	
				 if ($scope.lHbwlContainerBean[i].amount != undefined && $scope.lHbwlContainerBean[i].amount != null && $scope.lHbwlContainerBean[i].amount != '') {
					 if(flag10==true)
		        	   {
					 flag10 = validateDouble($scope.lHbwlContainerBean[i].amount);
		        	   }
		         }
				
			}
			 var obj = {
						hblBean : $scope.hbw,
						lHbwContainerBean	: $scope.lHbwlContainerBean,
				}
				if (flag1 == true && flag2 == true && flag2 == true && flag3 == true && flag4 == true && flag5 == true && flag6 == true && flag7== true && flag8 == true && flag9 == true && flag4 == true && flag10 == true && flag11 == true && flag12 == true && flag13 == true && flag14 == true && flag15 == true) {

	            $http.post($stateParams.tenantid+'/app/air/hbw/update',obj).success(function(data) {
	            	if(data.success){
	            		logger.logSuccess('Updated Successfully');
	            		if($scope.hbw.shipperAddress != null && $scope.hbw.shipperAddress != ''){
		           			 var text5 =$scope.hbw.shipperAddress;
		                        text5 = text5.replace(/\r?<br>/g, '\n');
		                        $scope.hbw.shipperAddress=text5;
		           		}
		           		if($scope.hbw.consigneeAddress != null  && $scope.hbw.consigneeAddress != '' ){
		           			 var text6 =$scope.hbw.consigneeAddress;
		                        text6 = text6.replace(/\r?<br>/g, '\n');
		                        $scope.hbw.consigneeAddress=text6;
		           		}
		           		if($scope.hbw.notifyAddress != null  && $scope.hbw.notifyAddress != '' ){
		          			 var text7 =$scope.hbw.notifyAddress;
		          			text7 = text7.replace(/\r?<br>/g, '\n');
		                       $scope.hbw.notifyAddress=text7;
		          		}
	            		$location.url($stateParams.tenantid+'/hbw/edit?rowid='+data.hbwId);  
	            		//$scope.cancel();
	            	}else{
	            		logger.logError('Unable to save!');
	            	}
	            	
	            });
			}
			else {
				if (flag1 == false) {
	                logger.logError("Please Enter Number Value for No Of Pieces in Container Details");
	            }
	            if (flag2 == false) {
	                logger.logError("Please Enter Number Value for LWH in Container Details");
	            }
	            if (flag3 == false) {
	                logger.logError("Please Enter Number Value for NetWeight in Container Details");
	            }
	            if (flag4 == false) {
	                logger.logError("Please Enter Number Value for GrossWeight in Container Details");
	            }
	            if (flag5 == false) {
	                logger.logError("Please Enter Number Value for Length in Container Details");
	            }
	            if (flag6 == false) {
	                logger.logError("Please Enter Number Value for Width in Container Details");
	            }
	            if (flag7 == false) {
	                logger.logError("Please Enter Number Value for Height in Container Details");
	            }
	            if (flag8 == false) {
	                logger.logError("Please Enter Number Value for Chargable Weight in Container Details");
	            }
	            if (flag10 == false) {
	                logger.logError("Please Enter Number Value for Rate in Container Details");
	            }
	            if (flag9 == false) {
	                logger.logError("Please Enter Number Value for Amount in Container Details");
	            }
	            if (flag11 == false) {
	                logger.logError("Please Enter Number Value for Tax");
	            }
	            if (flag12 == false) {
	                logger.logError("Please Enter Number Value for Total Other Charges Due To Agent");
	            }
	            if (flag13 == false) {
	                logger.logError("Please Enter Number Value for Total Other Charges Due To Carrier");
	            }
	            if (flag14 == false) {
	                logger.logError("Please Enter Number Value for Valuation Charges");
	            }
	            if (flag15 == false) {
	                logger.logError("Please Enter Number Value for Amount");
	            } 
	        }
			}else {
	            toaster.pop('error', "Please fill the required fields", 
	                    logger.getErrorHtmlNew(servicePartnerAddForm.$validationSummary), 5000, 'trustedHtml');
	        }
		}

		 function validateNos(pincode) {
		     var reg =  /^[0-9]+$/
		        if (reg.test(pincode)) {
		            return true;
		        } else {
		            
		            return false;
		        }
		    }
		 
		 function validateDouble(pincode) {
		     var reg = /^[0-9]+(\.[0-9]+)?$/


		        if (reg.test(pincode)) {
		            return true;
		        } else {
		            
		            return false;
		        }
		    }
		 //487
		 $scope.mawbId=servicePartnerId;
		 $scope.printManifest=function(){
			    var url = $stateParams.tenantid+'/airCargoManifest/printHawbManifest?beanId='+$scope.mawbId;
		        var wnd = window.open(url, 'MANIFEST', 'height=700,width=850,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
		        wnd.print();
		}
		$scope.printHawb=function(){
		    var url = $stateParams.tenantid+'/airCargoManifest/printHAWB?beanId='+$scope.mawbId;
	        var wnd = window.open(url, 'HAWB', 'height=700,width=850,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
	        wnd.print();
		}
		$scope.printbooking=function(){
		    var url = $stateParams.tenantid+'/airCargoManifest/printbooking?beanId='+$scope.mawbId;
	        var wnd = window.open(url, 'HAWB', 'height=700,width=850,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
	        wnd.print();
		}
		
 $scope.reset=function(){
	         
	         if( $scope.isEdit == false){ 
	        	 $scope.lHbwlContainerBean =[];
	 		    $scope.hbw = {
	 		            
	 		    	    jobNo:'',
	 		    		 hbwNo:'',
	 		    		 mbwNo:'',
	 		    		 agreed:'',
	 		    		 hbwDocNo:'',
	 		    		 hbwDocDate:'',
	 		    		 mbwDocNo:'',
	 		    		 mbwDocDate:'',
	 		    		 vesselVoyeage:'',
	 		    		 feederVesselVoyeage:'',
	 		    		 vendor:'',
	 		    		 issuePlace:'',
	 		    		 customer:'',
	 		    		 etd:'',
	 		    		 etaAtPod:'',
	 		    		 igmNo:'',
	 		    		 igmDate:'',
	 		    		 itemNo:'',
	 		    		 to:'',
	 		    		 doRemarks:'',
	 		    		 canRemarks:'',
	 		    		 branch:'',
	 		    		 aol:'',
	 		    		 aod:'',
	 		    		 term:'',
	 		    		 salesPerson:'',
	 		    		 vessel:'',
	 		    		 origin:'',
	 		    		 destination:'',
	 		    		 arrivalDate:'',
	 		    		 commodity:'',
	 		    		 sealNo:'',
	 		    		 status:'',
	 		    		 measureMent:'',
	 		    		 remarks:'',
	 		    	     descriptionofGoods:'',
	 		    	     lWHUOM:'',
	 		    	     noOfPieces:'',
	 		    	     shipper:'',
	 		    		 size:'',
	 		    		 noofPackage:'',
	 		    		 uOm:'',
	 		    		 grossWeight:'',
	 		    		 netWeight:'',
	 		    		  chargeableWeight:'',
	 		    		 rateCharge:'',
	 		    		 height:'',
	 		    		 weight:'',
	 		    		 lenght:'',
	 		    		 amount:'',
	 		    		 consignee:'',
	 		    		 shipperAddress:'',
	 		    		 consigneeAddress:'',
	 		    		 notifyAddress:'',
	 		    		 accountingInformation:'',
	 		    		 handlingInformation:'',
	 		    		 airportOfDepature:'',
	 		    		 toDepature:'',
	 		    		 issuingCarringAgent:'',
	 		    		 byFirstCarrier:'',
	 		    		 bySecondCarrier:'',
	 		    		 requestedFlightDate:'',
	 		    		 airportOfDestination:'',
	 		    		 airportOfDischarge2:'',
	 		    		 requestedFlightDate2:'',
	 		    		 iATACode:'',
	 		    		 airportOfDischarge3:'',
	 		    		 byThirdCarrier:'',
	 		    		 containerNumber:'',
	 		    		 freightPayableAt:'',
	 		    		 noOfOriginalBl:'',
	 		    		 preCarriagedBy:'',
	 		    		 valuationCharge:'',
	 		    		 tax:'',
	 		    		 totalChargeCarrier:'',
	 		    		 amountOfInsurance:'',
	 		    		 totalChargeAgent:'',
	 		    		 chargesCode:'',
	 		    		 weightValuationCharge:'',
	 		    		 otherCharge:'',
	 		    		 otherChargeDesc:'',
	 		    		 dvForCarriage:'',
	 		    		 dvForCustoms:'',
	 		    		 consolidationNumber:'',
	 		    		 exportReferences:'',
	 		    		 shipperReferences:'',
	 		    		 ftzNumber:'',
	 		    		 loadingPierTerminal:'',
	 		    		 coLoadedWith:'',
	 		    		 containarized:'',
	 		    	     destinationAgentCode:'',
	 		    	     currency:'',
	 		    	     cargoInsurance:'',
	 		    	     movement:'',
	 		    		 notify:'',
	 		    	     mbwCode:'',
	 		    		 hbwCode:'',
	 		    		 modifedBy:'',
	 		    		 modifedDate:'',
	 		    		 polCode:'',
	 		    		 podCode:'',
	 		    		 originCode:'',
	 		    		 destionationCode:'',
	 		         };
	         }else {
	        	 $http.post($stateParams.tenantid+'/app/air/hbw/edit?hblId='+servicePartnerId).success(function(data) {
	 	        	if(data.success){
	 	        		$scope.jobDetail=true;

	 	        		$scope.hbw = data.hblBean;
	 	        		$scope.lHbwlContainerBean=data.lHbwContainerBean;
	 	        		$scope.hbw.jobNo = data.hblBean.jobNo.toString();
	 	        		$scope.hbw.mbwNo = data.hblBean.mbwNo.toString();
	 	        		$scope.hbw.aol = data.hblBean.aol.toString();
	 	        		$scope.hbw.aod = data.hblBean.aod.toString();
	 	        		$scope.hbw.term = data.hblBean.term.toString();
	 	        		$scope.hbw.customer = data.hblBean.customer.toString();
	 	        		$scope.hbw.branch = data.hblBean.branch.toString();

	 	        	
	 	        		if(data.hblBean.origin!=null&&data.hblBean.origin!='')
	 	    			{
	 	        		$scope.hbw.origin = data.hblBean.origin.toString();

	 	    			}

	 	        		if(data.hblBean.destination!=null&&data.hblBean.destination!='')
	 	    			{
	 	        		$scope.hbw.destination = data.hblBean.destination.toString();

	 	    			}
	 	        		if(data.hblBean.salesPerson!=null&&data.hblBean.salesPerson!='')
	 	    			{
	 	        		$scope.hbw.salesPerson = data.hblBean.salesPerson.toString();

	 	    			}
	 	    		   if(data.hblBean.shipper!=null && data.hblBean.shipper!='')
	 				   {
	 	        		$scope.hbw.shipper = data.hblBean.shipper.toString();

	 				    }
	 	    		   if(data.hblBean.consignee!=null && data.hblBean.consignee!='')
	 				   {
	 	        		$scope.hbw.consignee = data.hblBean.consignee.toString();

	 				    }
	 	    		  
	 	    		   if(data.hblBean.airportOfDischarge2!=null && data.hblBean.airportOfDischarge2!='')
	 				   {
	 	        		$scope.hbw.airportOfDischarge2 = data.hblBean.airportOfDischarge2.toString();

	 				    }
	 	    		   if(data.hblBean.airportOfDischarge3!=null && data.hblBean.airportOfDischarge3!='')
	 				   {
	 	        		$scope.hbw.airportOfDischarge3 = data.hblBean.airportOfDischarge3.toString();

	 				    }
	 	    		   if(data.hblBean.to!=null && data.hblBean.to!='')
	 				   {
	 	        		$scope.hbw.to = data.hblBean.to.toString();

	 				    }
	 	    		  
	 	    		   if(data.hblBean.weightValuationCharge!=null && data.hblBean.weightValuationCharge!='')
	 				   {
	 	        		$scope.hbw.weightValuationCharge = data.hblBean.weightValuationCharge.toString();

	 				    }
	 	    		   if(data.hblBean.chargesCode!=null && data.hblBean.chargesCode!='')
	 				   {
	 	        		$scope.hbw.chargesCode = data.hblBean.chargesCode.toString();

	 				    }
	 	    		   if(data.hblBean.currency!=null && data.hblBean.currency!='')
	 				   {
	 	        		$scope.hbw.currency = data.hblBean.currency.toString();

	 				    }
	 	    		   if(data.hblBean.otherCharge!=null && data.hblBean.otherCharge!='')
	 				   {
	 	        		$scope.hbw.otherCharge = data.hblBean.otherCharge.toString();

	 				    }
	 	    		   $scope.totalPackageCalculation();
	 	    		   $scope.totalnetWeightCalculation();
	 	    		   $scope.totalgrossWeightCalculation();
	 	    		   $scope.totalamountCalculation();

	 	        		
	         		  $http.post($stateParams.tenantid+'/app/master/hbl/dropDownList').success(function(data) {
	       	          	
	       	          	$scope.vendorList=data.vendor;
	       	      		$scope.customerList=data.customer;
	       	      		$scope.termList=data.term;
	       	      		$scope.destinationList=data.destination;
	       	      		$scope.originList=data.origin;
	       	      		$scope.branchList=data.branch;
	       	      		$scope.podList=data.pod;
	       	      		$scope.polList=data.pol;
	       	      		$scope.typeList=data.typeList;
	       	      		$scope.movementList=data.movement;
	       	      		$scope.preCarriageList=data.preCarriaged;
	       	      		$scope.destinationAgentList=data.destination;	
	       	      		$scope.hblList=data.hbl;
	       	      		$scope.consigneeList=data.customer;
	       	      		//$scope.mblList=data.mbw;
	       	      		$scope.hblList=data.hbw;
	       	      		$scope.jobList=data.airJob;
	               		$scope.salesPersonList=data.salesPerson;
	               		$scope.otherChargesList=data.paymentList;
	               		$scope.iataList=data.iataList;
	               		$scope.currencyList=data.currency;
	              		$scope.iataListDetail=data.iataListDetail;


	               		
	       	          });	
	 	        	
	 	        	}else{
	 	        		logger.logError("Unable to fetch data");
	 	        	}
	 	        });
	         }
	     }
 

       $scope.quickLinkMethd=function(qulkVal){
			if(qulkVal!='Select'){
				if($scope.hbw.hbwNo!='' && $scope.hbw.hbwNo!=undefined){
			$http.post($stateParams.tenantid + '/app/air/hbw/getQuickLinkId?category='+qulkVal+'&hawbId='+$scope.hbw.hbwNo).success(function(datas) {
						if(datas.quickLinkId!=null){
							var rowid=datas.quickLinkId;
							if(qulkVal=="Job Order"){
								if(rowid!=0){
									$location.url($stateParams.tenantid+'/jobOrderAir/edit?rowid='+rowid); 
									//$window.open('#'+$stateParams.tenantid+'/jobOrderAir/view?rowid='+rowid, '_blank');
								}else{
									logger.logError("There is no "+qulkVal);
								}
								
							}else if(qulkVal=="MAWB"){
								if(rowid!=0){
									$location.url($stateParams.tenantid+'/mabw/edit?rowid='+rowid); 
									//$window.open('#'+$stateParams.tenantid+'/mabw/view?rowid='+rowid,'_blank');
								}else{
									logger.logError("There is no "+qulkVal);
								}
								
							}else if(qulkVal=="Delivery Order"){
								if(rowid!=0){
									$location.url($stateParams.tenantid+'/airdeliveryorder/edit?rowid='+rowid);
									//$window.open('#'+$stateParams.tenantid+'/airdeliveryorder/view?rowid='+rowid,'_blank');
								}else{
									logger.logError("There is no "+qulkVal);
								}
								
							}else if(qulkVal=="Sales Invoice"){
								if(rowid!=0){
									$location.url($stateParams.tenantid+'/invoice/salesinvoice/salesInvoiceView/'+rowid);
									//$window.open('#'+$stateParams.tenantid+"/invoice/salesinvoice/salesInvoiceView/"+rowid,'_blank');
								}else{
									logger.logError("There is no "+qulkVal);
								}
								
							}else if(qulkVal=="Purchase Invoice"){
								if(rowid!=0){
									$location.url($stateParams.tenantid+'/invoice/purchaseinvoice/PurchaseInvoiceView/'+rowid);
									//$window.open('#'+$stateParams.tenantid+"/invoice/purchaseinvoice/PurchaseInvoiceView/"+rowid,'_blank');
								}else{
									logger.logError("There is no "+qulkVal);
								}
								
							}
						} else if(datas.quickLinkIdList!=null){
							var quickLinkIdList=datas.quickLinkIdList;

							if(qulkVal=="Job Order"){
								$location.url($stateParams.tenantid+'/joborder/list?quickLinkIdList='+quickLinkIdList);
								//$window.open('#'+$stateParams.tenantid+'/hbw/list?quickLinkIdList='+quickLinkIdList, '_blank');
							}else if(qulkVal=="MAWB"){
								$location.url($stateParams.tenantid+'/mabw/list?quickLinkIdList='+quickLinkIdList);
								//$window.open('#'+$stateParams.tenantid+'/mabw/list?quickLinkIdList='+quickLinkIdList, '_blank');
							}else if(qulkVal=="Delivery Order"){
								$location.url($stateParams.tenantid+'/airdeliveryorder/list?quickLinkIdList='+quickLinkIdList);
								//$window.open('#'+$stateParams.tenantid+'/airdeliveryorder/list?quickLinkIdList='+quickLinkIdList, '_blank');
							}else if(qulkVal=="Sales Invoice"){ 
								$location.url($stateParams.tenantid+'/invoice/salesinvoice/SalesInvoiceList?quickLinkIdList='+quickLinkIdList);
								//$window.open('#'+$stateParams.tenantid+'/invoice/salesinvoice/SalesInvoiceList?quickLinkIdList='+quickLinkIdList,'_blank');
							}else if(qulkVal=="Purchase Invoice"){
								$location.url($stateParams.tenantid+'/invoice/purchaseinvoice/PurchaseInvoiceList?quickLinkIdList='+quickLinkIdList);
								//$window.open('#'+$stateParams.tenantid+'/invoice/purchaseinvoice/PurchaseInvoiceList?quickLinkIdList='+quickLinkIdList,'_blank');
							}
							
						
						}else{
							var quickLinkIdList=datas.quickLinkIdList;
							if(qulkVal=="Job Order"){
								$location.url($stateParams.tenantid+'/hbw/list?quickLinkIdList='+quickLinkIdList);
								//$window.open('#'+$stateParams.tenantid+'/hbw/list?quickLinkIdList='+quickLinkIdList, '_blank');
							}else if(qulkVal=="MAWB"){
								$location.url($stateParams.tenantid+'/mabw/list?quickLinkIdList='+quickLinkIdList);
								//$window.open('#'+$stateParams.tenantid+'/mabw/list?quickLinkIdList='+quickLinkIdList, '_blank');
							}else if(qulkVal=="Delivery Order"){
								$location.url($stateParams.tenantid+'/airdeliveryorder/list?quickLinkIdList='+quickLinkIdList);
								//$window.open('#'+$stateParams.tenantid+'/airdeliveryorder/list?quickLinkIdList='+quickLinkIdList, '_blank');
							}else if(qulkVal=="Sales Invoice"){ 
								$location.url($stateParams.tenantid+'/invoice/salesinvoice/SalesInvoiceList?quickLinkIdList='+quickLinkIdList);
								//$window.open('#'+$stateParams.tenantid+'/invoice/salesinvoice/SalesInvoiceList?quickLinkIdList='+quickLinkIdList,'_blank');
							}else if(qulkVal=="Purchase Invoice"){
								$location.url($stateParams.tenantid+'/invoice/purchaseinvoice/PurchaseInvoiceList?quickLinkIdList='+quickLinkIdList);
								//$window.open('#'+$stateParams.tenantid+'/invoice/purchaseinvoice/PurchaseInvoiceList?quickLinkIdList='+quickLinkIdList,'_blank');
							}
							
						
						}
						
			})
			}else{
				logger.logError("There is no Job No.");
			}
		}
		}

});

app.controller('hbwViewCtrl', function($scope, $rootScope, $http, $location, logger, ngDialog,
        utilsService,$state,sharedProperties,$window,$stateParams,toaster,validationService) {

 $scope.displayedCollection = [];
var date  = new Date();
var dateString =  date.getDate() + "/" + date.getMonth() + "/" + date.getFullYear() + " " + date.getHours() + ":" + date.getMinutes();
	$scope.rowCollectionFollowup=[];
    $scope.referralList=[];
    $scope.isEdit = false;
    $scope.tairDetailList =[];
	
	

    $scope.cancel = function() {
	  	  $state.go('app.air.hbw.list',{tenantid:$stateParams.tenantid});
	  	  
	          
	    };
    
	   
		    $scope.lHbwlContainerBean =[];
		    $scope.hbw = {
		            
		    	    jobNo:'',
		    		 hbwNo:'',
		    		 mbwNo:'',
		    		 agreed:'',
		    		 hbwDocNo:'',
		    		 hbwDocDate:'',
		    		 mbwDocNo:'',
		    		 mbwDocDate:'',
		    		 vesselVoyeage:'',
		    		 feederVesselVoyeage:'',
		    		 vendor:'',
		    		 issuePlace:'',
		    		 customer:'',
		    		 etd:'',
		    		 etaAtPod:'',
		    		 igmNo:'',
		    		 igmDate:'',
		    		 itemNo:'',
		    		 to:'',
		    		 doRemarks:'',
		    		 canRemarks:'',
		    		 branch:'',
		    		 aol:'',
		    		 aod:'',
		    		 term:'',
		    		 salesPerson:'',
		    		 vessel:'',
		    		 origin:'',
		    		 destination:'',
		    		 arrivalDate:'',
		    		 commodity:'',
		    		 sealNo:'',
		    		 status:'',
		    		 measureMent:'',
		    		 remarks:'',
		    	     descriptionofGoods:'',
		    	     lWHUOM:'',
		    	     noOfPieces:'',
		    	     shipper:'',
		    		 size:'',
		    		 noofPackage:'',
		    		 uOm:'',
		    		 grossWeight:'',
		    		 netWeight:'',
		    		  chargeableWeight:'',
		    		 rateCharge:'',
		    		 height:'',
		    		 weight:'',
		    		 lenght:'',
		    		 amount:'',
		    		 consignee:'',
		    		 shipperAddress:'',
		    		 consigneeAddress:'',
		    		 notifyAddress:'',
		    		 accountingInformation:'',
		    		 handlingInformation:'',
		    		 airportOfDepature:'',
		    		 toDepature:'',
		    		 issuingCarringAgent:'',
		    		 byFirstCarrier:'',
		    		 bySecondCarrier:'',
		    		 requestedFlightDate:'',
		    		 airportOfDestination:'',
		    		 airportOfDischarge2:'',
		    		 requestedFlightDate2:'',
		    		 iATACode:'',
		    		 airportOfDischarge3:'',
		    		 byThirdCarrier:'',
		    		 containerNumber:'',
		    		 freightPayableAt:'',
		    		 noOfOriginalBl:'',
		    		 preCarriagedBy:'',
		    		 valuationCharge:'',
		    		 tax:'',
		    		 totalChargeCarrier:'',
		    		 amountOfInsurance:'',
		    		 totalChargeAgent:'',
		    		 chargesCode:'',
		    		 weightValuationCharge:'',
		    		 otherCharge:'',
		    		 otherChargeDesc:'',
		    		 dvForCarriage:'',
		    		 dvForCustoms:'',
		    		 consolidationNumber:'',
		    		 exportReferences:'',
		    		 shipperReferences:'',
		    		 ftzNumber:'',
		    		 loadingPierTerminal:'',
		    		 coLoadedWith:'',
		    		 containarized:'',
		    	     destinationAgentCode:'',
		    	     currency:'',
		    	     cargoInsurance:'',
		    	     movement:'',
		    		 notify:'',
		    	     mbwCode:'',
		    		 hbwCode:'',
		    		 modifedBy:'',
		    		 modifedDate:'',
		    		 polCode:'',
		    		 podCode:'',
		    		 originCode:'',
		    		 destionationCode:'',
		         };
		    
			  $scope.lTempHbwlContainerBean = {
						select 		:false,
						commodity:'',
						descriptionOfGoods:'',
						lWHUOM:'',
						length:'',	
						width:'',
						height:'',	 
						noOfPieces:'',	 
						netWeight:'',
						grossWeight:'',
						remarks:'',
						chargeableWeight:'',
						amount:'',
						rateCharge:'',

					};
    
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

				$scope.hbw.hbwDate = dd + '/' + mm + '/'
						+ yyyy;
		  
	 //add Row
	  $scope.addCredRow = function() {
	   
		  var tmp=angular.copy($scope.lTempHbwlContainerBean);
			$scope.lHbwlContainerBean.push(tmp);

	  }
	  $scope.addCredRow();

		$scope.removeCredRow =function(){
			if($scope.isEdit==false){
				var tmpDelList = [];
				for(var i=$scope.lHbwlContainerBean.length-1;i>=0;i--){
					if($scope.lHbwlContainerBean[i].select==true){
						tmpDelList.push($scope.lHbwlContainerBean[i]);
						$scope.lHbwlContainerBean.splice(i, 1);
					}
				}
				logger.logSuccess('Deleted Successfully');
			}else if($scope.isEdit==true){
				var tmpDelList = [];
				for(var i=$scope.lHbwlContainerBean.length-1;i>=0;i--){
					if($scope.lHbwlContainerBean[i].select==true){
						tmpDelList.push($scope.lHbwlContainerBean[i]);
					}
				}
				$http.post($stateParams.tenantid+'/app/air/hbw/deleteContainerDetail',tmpDelList).success(function(data) {
		        	if(data.success){
		        		for(var i=$scope.lHbwlContainerBean.length-1;i>=0;i--){
		    				if($scope.lHbwlContainerBean[i].select==true){
		    					$scope.lHbwlContainerBean.splice(i, 1);
		    				}
		    			}
		        		logger.logSuccess('Deleted Successfully');
		        	}else{
		        		logger.logError('Unable to delete');
		        	}
				})
			}
			
		}
		 $scope.packageCalculation = function(noOfPieces,
					trIndex, row) {
				// row.cbpDtlTcAmount =parseFloat(tcAmount);
				if (row.noOfPieces != 0 && row.noOfPieces != "") {
					
						var noOfPieces = noOfPieces;
						/*row.noOfPieces = parseFloat(noOfPieces).toFixed(
								2);*/
						$scope.totalPackageCalculation();
					} 
			}
		 
		 
		 
			$scope.totalPackageCalculation = function() {
				debugger;
				var mablContainerBean = $scope.lHbwlContainerBean;
				var noOfPieces = 0;
				angular.forEach(mablContainerBean, function(item, key) {
					var mablContainerBeanData = mablContainerBean[key];
					noOfPieces = noOfPieces + parseFloat(item.noOfPieces);
					$scope.totalPackage = noOfPieces;
				});

				/*$scope.cbpmtDtlTotalAmt.totalBCAmount = $scope.cbpmtDtlTotalAmt.totalBCAmount
						.toFixed(2);
				$scope.cbpmtDtlTotalAmt.totalTCAmount = $scope.cbpmtDtlTotalAmt.totalTCAmount
						.toFixed(2);*/
			}
		  
			 $scope.grossWeightCalculation = function(grossWeight,
						trIndex, row) {
					if (row.grossWeight != 0 && row.grossWeight != "") {
						
							var grossWeights = grossWeight;
							/*row.grossWeight = parseFloat(grossWeight).toFixed(
									2);*/
							$scope.totalgrossWeightCalculation();
						} 
				}
				$scope.totalgrossWeightCalculation = function() {
					debugger;
					var mablContainerBean = $scope.lHbwlContainerBean;
					var grossWeight = 0;
					
					angular.forEach(mablContainerBean, function(item, key) {
						var mablContainerBeanData = mablContainerBean[key];

						grossWeight = grossWeight + parseFloat(item.grossWeight);
						$scope.totalgrossWeight = grossWeight;

					});

				}
				 $scope.netWeightCalculation = function(netWeight,
							trIndex, row) {
						if (row.netWeight != 0 && row.netWeight != "") {
							
								var netWeights = netWeight;
								/*row.netWeight = parseFloat(netWeight).toFixed(
										2);*/
								$scope.totalnetWeightCalculation();
							} 
					}
					$scope.totalnetWeightCalculation = function() {
						debugger;
						var mablContainerBean = $scope.lHbwlContainerBean;
						var netWeight=0;
						
						angular.forEach(mablContainerBean, function(item, key) {
							var mablContainerBeanData = mablContainerBean[key];

							netWeight = netWeight + parseFloat(item.netWeight);
							$scope.totalnetWeight = netWeight;

						});

					}
					 $scope.amountCalculation = function(amount,
								trIndex, row) {
							if (row.amount != 0 && row.amount != "") {
								
									var amounts = amount;
									/*row.netWeight = parseFloat(netWeight).toFixed(
											2);*/
									$scope.totalamountCalculation();
								} 
						}
						$scope.totalamountCalculation = function() {
							debugger;
							var mablContainerBean = $scope.lHbwlContainerBean;
							var amount=0;
							
							angular.forEach(mablContainerBean, function(item, key) {
								var mablContainerBeanData = mablContainerBean[key];

								amount = amount + parseFloat(item.amount);
								$scope.totalamount = amount;

							});

						}
		  
		var servicePartnerId = $location.search().rowid;
		if(servicePartnerId!=null && servicePartnerId!=undefined && servicePartnerId>0){
			$scope.isEdit=true;
	        $http.post($stateParams.tenantid+'/app/air/hbw/view?hblId='+servicePartnerId).success(function(data) {
	        	if(data.success){
	        		$scope.hbw = data.hblBean;
	        		$scope.lHbwlContainerBean=data.lHbwContainerBean;
	        		$scope.mblList1=data.mbwdoc;
	        		if($scope.hbw.shipperAddress != null && $scope.hbw.shipperAddress != ''){
	           			 var text5 =$scope.hbw.shipperAddress;
	                        text5 = text5.replace(/\r?<br>/g, '\n');
	                        $scope.hbw.shipperAddress=text5;
	           		}
	           		if($scope.hbw.consigneeAddress != null  && $scope.hbw.consigneeAddress != '' ){
	           			 var text6 =$scope.hbw.consigneeAddress;
	                        text6 = text6.replace(/\r?<br>/g, '\n');
	                        $scope.hbw.consigneeAddress=text6;
	           		}
	           		if($scope.hbw.notifyAddress != null  && $scope.hbw.notifyAddress != '' ){
	          			 var text7 =$scope.hbw.notifyAddress;
	          			text7 = text7.replace(/\r?<br>/g, '\n');
	                       $scope.hbw.notifyAddress=text7;
	          		}
	           		if($scope.hbw.handlingInformation != null  && $scope.hbw.handlingInformation != '' ){
	          			 var handInf =$scope.hbw.handlingInformation;
	          			handInf = handInf.replace(/\r?<br>/g, '\n');
	                       $scope.hbw.handlingInformation=handInf;
	          		}
	          		if($scope.hbw.accountingInformation != null  && $scope.hbw.accountingInformation != '' ){
	          			 var accInf =$scope.hbw.handlingInformation;
	          			accInf = accInf.replace(/\r?<br>/g, '\n');
	                       $scope.hbw.handlingInformation=accInf;
	          		}
	           		
	           		
	        		for(var i=0;i<$scope.lHbwlContainerBean.length;i++) 
                	{
                	if($scope.lHbwlContainerBean[i].lWHUOM!=null&&$scope.lHbwlContainerBean[i].lWHUOM!='')
                		{
                		$scope.lHbwlContainerBean[i].lWHUOM=$scope.lHbwlContainerBean[i].lWHUOM.toString();

                		}
                	if($scope.lHbwlContainerBean[i].descriptionofGoods != null  && $scope.lHbwlContainerBean[i].descriptionofGoods != '' ){
   					 var text9 = $scope.lHbwlContainerBean[i].descriptionofGoods;
   					  text9 = text9.replace(/\r?<br>/g, '\n');
   			         $scope.lHbwlContainerBean[i].descriptionofGoods=text9;
   				}

                	}
	        		
	        		//$scope.hbw.jobNo = data.hblBean.jobNo.toString();
	        		if(data.hblBean.mbwNo != null && data.hblBean.mbwNo != ''){
	        			$scope.hbw.mbwNo = data.hblBean.mbwNo.toString();
	        		}
	        		
	        		$scope.hbw.aol = data.hblBean.aol.toString();
	        		$scope.hbw.aod = data.hblBean.aod.toString();
	        		$scope.hbw.term = data.hblBean.term.toString();
	        		$scope.hbw.customer = data.hblBean.customer.toString();
	        		$scope.hbw.branch = data.hblBean.branch.toString();

	        	
	        		if(data.hblBean.origin!=null&&data.hblBean.origin!='')
	    			{
	        		$scope.hbw.origin = data.hblBean.origin.toString();

	    			}

	        		if(data.hblBean.destination!=null&&data.hblBean.destination!='')
	    			{
	        		$scope.hbw.destination = data.hblBean.destination.toString();

	    			}
	        		if(data.hblBean.salesPerson!=null&&data.hblBean.salesPerson!='')
	    			{
	        		$scope.hbw.salesPerson = data.hblBean.salesPerson.toString();

	    			}
	    		   if(data.hblBean.shipper!=null && data.hblBean.shipper!='')
				   {
	        		$scope.hbw.shipper = data.hblBean.shipper.toString();

				    }
	    		   if(data.hblBean.consignee!=null && data.hblBean.consignee!='')
				   {
	        		$scope.hbw.consignee = data.hblBean.consignee.toString();

				    }
	    		  
	    		   if(data.hblBean.airportOfDischarge2!=null && data.hblBean.airportOfDischarge2!='')
				   {
	        		$scope.hbw.airportOfDischarge2 = data.hblBean.airportOfDischarge2.toString();

				    }
	    		   if(data.hblBean.airportOfDischarge3!=null && data.hblBean.airportOfDischarge3!='')
				   {
	        		$scope.hbw.airportOfDischarge3 = data.hblBean.airportOfDischarge3.toString();

				    }
	    		   if(data.hblBean.to!=null && data.hblBean.to!='')
				   {
	        		$scope.hbw.to = data.hblBean.to.toString();

				    }
	    		  
	    		   if(data.hblBean.weightValuationCharge!=null && data.hblBean.weightValuationCharge!='')
				   {
	        		$scope.hbw.weightValuationCharge = data.hblBean.weightValuationCharge.toString();

				    }
	    		   if(data.hblBean.chargesCode!=null && data.hblBean.chargesCode!='')
				   {
	        		$scope.hbw.chargesCode = data.hblBean.chargesCode.toString();

				    }
	    		   if(data.hblBean.currency!=null && data.hblBean.currency!='')
				   {
	        		$scope.hbw.currency = data.hblBean.currency.toString();

				    }
	    		   if(data.hblBean.otherCharge!=null && data.hblBean.otherCharge!='')
				   {
	        		$scope.hbw.otherCharge = data.hblBean.otherCharge.toString();

				    }
	    		   $scope.totalPackageCalculation();
	    		   $scope.totalnetWeightCalculation();
	    		   $scope.totalgrossWeightCalculation();
	    		   $scope.totalamountCalculation();
	    		   
	        		
        		  $http.post($stateParams.tenantid+'/app/master/hbl/dropDownList').success(function(data) {
      	          	
      	          	$scope.vendorList=data.vendor;
      	      		$scope.customerList=data.customer;
      	      		$scope.termList=data.term;
      	      		$scope.destinationList=data.destination;
      	      		$scope.originList=data.origin;
      	      		$scope.branchList=data.branch;
      	      		$scope.podList=data.pod;
      	      		$scope.polList=data.pol;
      	      		$scope.typeList=data.typeList;
      	      		$scope.movementList=data.movement;
      	      		$scope.preCarriageList=data.preCarriaged;
      	      		$scope.destinationAgentList=data.destination;	
      	      		$scope.hblList=data.hbl;
      	      		$scope.consigneeList=data.customer;
      	      	//	$scope.mblList=data.mbw;
      	      		$scope.hblList=data.hbw;
      	      		$scope.jobList=data.airJob;
              		$scope.salesPersonList=data.salesPerson;
              		$scope.otherChargesList=data.paymentList;
              		$scope.iataList=data.iataList;
              		$scope.currencyList=data.currency;


              		
      	          });	
	        	
	        	}else{
	        		logger.logError("Unable to fetch data");
	        	}
	        });
		}
		$scope.mblList1=[];
		$scope.$watch('hbw.jobNo',function(newValue, oldValue) {
		if(newValue!=null && newValue!=undefined && newValue!=""){
		
				
			
	        $http.post($stateParams.tenantid+'/app/air/hbw/getJobDetail?jobNo='+newValue).success(function(data) {
	        	if(data.success){
	        		$scope.mblList=data.mbw;
	        		if($scope.isEdit==false)
	    			{
	        		$scope.lHbwlContainerBean=data.lHbwContainerBean;
	        		
	        		$scope.hbw.aol = data.hblBean.aol.toString();
	        		$scope.hbw.aod = data.hblBean.aod.toString();
	        		$scope.hbw.term = data.hblBean.term.toString();
	        		$scope.hbw.customer = data.hblBean.customer.toString();
	        		$scope.hbw.branch = data.hblBean.branch.toString();
	        		$scope.hbw.origin = data.hblBean.origin.toString();
	        		$scope.hbw.destination = data.hblBean.destination.toString();
	        		$scope.hbw.airportOfDepature=data.lHbwContainer[0].airportOfDepature;
	        		$scope.hbw.airportOfDestination=data.lHbwContainer[0].airportOfDestination;
	        		$scope.hbw.issuePlace=data.lHbwContainer[0].issuePlace;
	        		$scope.hbw.issuingCarringAgent=data.lHbwContainer[0].issuingCarringAgent;
	        		$scope.hbw.byFirstCarrier=data.lHbwContainer[0].byFirstCarrier;
	        		$scope.hbw.shipperAddress=data.hbwDocBean.shipperAddress;
	        		$scope.hbw.consigneeAddress=data.hbwDocBean.consigneeAddress;
	        		$scope.hbw.notifyAddress=data.hbwDocBean.notifyAddress;
	        		$scope.mblList1=data.mbwdoc;
	        		$scope.hbw.mbwNo=data.mbwdoc[0].id;
	        		$scope.hbw.mbwDocNo=data.hbwDocBean.mbwDocNo;
	        		$scope.hbw.mbwDocDate=data.hbwDocBean.mbwDocDate;
	        		
	        		if(data.hblBean.salesPerson!=null&&data.hblBean.salesPerson!='')
	    			{
	        		$scope.hbw.salesPerson = data.hblBean.salesPerson.toString();

	    			}
	    		   if(data.hblBean.shipper!=null && data.hblBean.shipper!='')
				   {
	        		$scope.hbw.shipper = data.hblBean.shipper.toString();

				    }
	    		   if(data.hblBean.consignee!=null && data.hblBean.consignee!='')
				   {
	        		$scope.hbw.consignee = data.hblBean.consignee.toString();

				    }
	    		   
	    		   for(var j=$scope.lHbwlContainerBean.length-1 ;j>=0;j-- )
	     			{
	     		$scope.lHbwlContainerBean[j]=data.lHbwContainerBean[j];
	     		if(data.lHbwContainerBean[j].lWHUOM != null){
	     		$scope.lHbwlContainerBean[j].lWHUOM = data.lHbwContainerBean[j].lWHUOM.toString();
	     		}
	     			}
	    		   
	    		   $scope.totalPackageCalculation();
	    		   $scope.totalnetWeightCalculation();
	    		   $scope.totalgrossWeightCalculation();
	    		   $scope.totalamountCalculation();
	        	
	  
	    		   $http.post($stateParams.tenantid+'/app/master/hbl/dropDownList').success(function(data) {
	      	          	
	      	          	$scope.vendorList=data.vendor;
	      	      		$scope.customerList=data.customer;
	      	      		$scope.termList=data.term;
	      	      		$scope.destinationList=data.destination;
	      	      		$scope.originList=data.origin;
	      	      		$scope.branchList=data.branch;
	      	      		$scope.podList=data.pod;
	      	      		$scope.polList=data.pol;
	      	      		$scope.typeList=data.typeList;
	      	      		$scope.movementList=data.movement;
	      	      		$scope.preCarriageList=data.preCarriaged;
	      	      		$scope.destinationAgentList=data.destination;	
	      	      		$scope.hblList=data.hbl;
	      	      		$scope.consigneeList=data.customer;
	      	      		//$scope.mblList=data.mbw;
	      	      		$scope.hblList=data.hbw;
	      	      		$scope.jobList=data.airJob;
	              		$scope.salesPersonList=data.salesPerson;
	              		$scope.otherChargesList=data.paymentList;
	              		$scope.iataList=data.iataList;
	              		$scope.currencyList=data.currency;
	              		$scope.iataListDetail=data.iataListDetail;

	              		
	      	          });	
	        		
        		
	        	
	        	}}else{
	        		logger.logError("Unable to fetch data");
	        	}
	        });
			}
		//}
		});
		  $http.post($stateParams.tenantid+'/app/master/hbl/dropDownList').success(function(data) {
	          
	          		$scope.vendorList=data.vendor;
      	      		$scope.customerList=data.customer;
      	      		$scope.termList=data.term;
      	      		$scope.destinationList=data.destination;
      	      		$scope.originList=data.origin;
      	      		$scope.branchList=data.branch;
      	      		$scope.podList=data.pod;
      	      		$scope.polList=data.pol;
      	      		$scope.typeList=data.typeList;
      	      		$scope.movementList=data.movement;
      	      		$scope.preCarriageList=data.preCarriaged;
      	      		$scope.destinationAgentList=data.destination;	
      	      		$scope.hblList=data.hbl;
      	      		$scope.consigneeList=data.customer;
      	      		//$scope.mblList=data.mbw;
      	      		$scope.hblList=data.hbw;
      	      		$scope.jobList=data.airJob;
              		$scope.salesPersonList=data.salesPerson;
              		$scope.iataList=data.iataList;
              		$scope.otherChargesList=data.paymentList;
              		$scope.currencyList=data.currency;
              		$scope.iataListDetail=data.iataListDetail;


	          	
	          });
		  $http.get(
					$stateParams.tenantid
							+ '/app/airquotation/getuomList')
					.success(function(datas) {
						$scope.uomList = datas.commonUtilityBean;

					}).error(function(data) {

					});
		$scope.save = function(hbwForm){
			if (new validationService().checkFormValidity(hbwForm)) {
	            var flag1 = true, flag2 = true, flag3 = true, flag4 = true, flag5 = true,flag6 = true, flag7 = true, flag8 = true, flag9 = true, flag10 = true, flag11 = true, flag12 = true, flag13 = true, flag14 = true, flag15 = true;

				if($scope.hbw.hbwDocDate=="" || $scope.hbw.hbwDocDate==undefined)
				{
				$scope.hbw.hbwDocDate=null
				}
			
			if($scope.hbw.mbwDocDate=="" || $scope.hbw.mbwDocDate==undefined)
			{
			$scope.hbw.mbwDocDate=null
			}
			if($scope.hbw.etaAtPod=="" || $scope.hbw.etaAtPod==undefined)
			{
			$scope.hbw.etaAtPod=null
			}
			if($scope.hbw.etd=="" || $scope.hbw.etd==undefined)
			{
			$scope.hbw.etd=null
			}
			if($scope.hbw.requestedFlightDate=="" || $scope.hbw.requestedFlightDate==undefined)
			{
			$scope.hbw.requestedFlightDate=null
			}
			if($scope.hbw.requestedFlightDate2=="" || $scope.hbw.requestedFlightDate2==undefined)
			{
			$scope.hbw.requestedFlightDate2=null
			}
			if($scope.hbw.shipperAddress != null && $scope.hbw.shipperAddress != ''){
				 var text = $scope.hbw.shipperAddress;
		         text = text.replace(/\r?\n/g, '<br>');
		         var res = text.replace("–", "-");
	             $scope.hbw.shipperAddress=res;
			}
			if($scope.hbw.consigneeAddress != null  && $scope.hbw.consigneeAddress != '' ){
				 var text1 = $scope.hbw.consigneeAddress;
		         text1 = text1.replace(/\r?\n/g, '<br>');
		         var res1 = text1.replace("–", "-");
	             $scope.hbw.consigneeAddress=res1;
			}
			if($scope.hbw.notifyAddress != null  && $scope.hbw.notifyAddress != '' ){
				 var text2 = $scope.hbw.notifyAddress;
		         text2 = text2.replace(/\r?\n/g, '<br>');
		         var res2 = text2.replace("–", "-");
	            $scope.hbw.notifyAddress=res2;
			}
			
			 if ($scope.hbw.tax != undefined && $scope.hbw.tax != null && $scope.hbw.tax != '') {
	           if(flag11==true)
	        	   {
					 flag11 = validateDouble($scope.hbw.tax);

	        	   }
	         }
			 if ($scope.hbw.totalChargeAgent != undefined && $scope.hbw.totalChargeAgent != null && $scope.hbw.totalChargeAgent != '') {
				 if(flag12==true)
	        	   {
				 flag12 = validateDouble($scope.hbw.totalChargeAgent);
	        	   }
	         }
			 if ($scope.hbw.totalChargeCarrier != undefined && $scope.hbw.totalChargeCarrier != null && $scope.hbw.totalChargeCarrier != '') {
				 if(flag13==true)
	        	   {
				 flag13 = validateDouble($scope.hbw.totalChargeCarrier);
	        	   }
	         }
			 if ($scope.hbw.valuationCharge != undefined && $scope.hbw.valuationCharge != null && $scope.hbw.valuationCharge != '') {
				 if(flag14==true)
	        	   {
				 flag14 = validateDouble($scope.hbw.valuationCharge);
	        	   }
	         }
			 if ($scope.hbw.amountOfInsurance != undefined && $scope.hbw.amountOfInsurance != null && $scope.hbw.amountOfInsurance != '') {
				 if(flag15==true)
	        	   {
				 flag15 = validateDouble($scope.hbw.amountOfInsurance);
	        	   }
	         }
			for(var i=0;i<$scope.lHbwlContainerBean.length;i++){
				 if ($scope.lHbwlContainerBean[i].nofPieces != undefined && $scope.lHbwlContainerBean[i].nofPieces != null && $scope.lHbwlContainerBean[i].nofPieces != '') {
					 if(flag1==true)
		        	   {
					 flag1 = validateNos($scope.lHbwlContainerBean[i].nofPieces);
		        	   }
		         }	
				 
				 if($scope.lHbwlContainerBean[i].descriptionofGoods != null  && $scope.lHbwlContainerBean[i].descriptionofGoods != '' ){
					 var text9 = $scope.lHbwlContainerBean[i].descriptionofGoods;
					 text9 = text9.replace(/\r?\n/g, '<br>');
			         var res9 = text9.replace("–", "-");
			         $scope.lHbwlContainerBean[i].descriptionofGoods=res9;
				}
				 if ($scope.lHbwlContainerBean[i].lWH != undefined && $scope.lHbwlContainerBean[i].lWH != null && $scope.lHbwlContainerBean[i].lWH != '') {
					 if(flag2==true)
		        	   {
					 flag2 = validateNos($scope.lHbwlContainerBean[i].lWH);
		        	   }
		         }
				 if ($scope.lHbwlContainerBean[i].netWeight != undefined && $scope.lHbwlContainerBean[i].netWeight != null && $scope.lHbwlContainerBean[i].netWeight != '') {
					 if(flag3==true)
		        	   {
					 flag3 = validateDouble($scope.lHbwlContainerBean[i].netWeight);
		        	   }
		         }
				 if ($scope.lHbwlContainerBean[i].grossWeight != undefined && $scope.lHbwlContainerBean[i].grossWeight != null && $scope.lHbwlContainerBean[i].grossWeight != '') {
					 if(flag4==true)
		        	   {
					 flag4 = validateDouble($scope.lHbwlContainerBean[i].grossWeight);
		        	   }
		         }
				 if ($scope.lHbwlContainerBean[i].length != undefined && $scope.lHbwlContainerBean[i].length != null && $scope.lHbwlContainerBean[i].length != '') {
					 if(flag5==true)
		        	   {
					 flag5 = validateDouble($scope.lHbwlContainerBean[i].length);
		        	   }
		         }	
				 if ($scope.lHbwlContainerBean[i].width != undefined && $scope.lHbwlContainerBean[i].width != null && $scope.lHbwlContainerBean[i].width != '') {
					 if(flag6==true)
		        	   {
					 flag6 = validateDouble($scope.lHbwlContainerBean[i].width);
		        	   }
		        	   }
				 if ($scope.lHbwlContainerBean[i].height != undefined && $scope.lHbwlContainerBean[i].height != null && $scope.lHbwlContainerBean[i].height != '') {
					 if(flag7==true)
		        	   {
					 flag7 = validateDouble($scope.lHbwlContainerBean[i].height);
		        	   }
		         }
				 if ($scope.lHbwlContainerBean[i].charcheableWeight != undefined && $scope.lHbwlContainerBean[i].charcheableWeight != null && $scope.lHbwlContainerBean[i].charcheableWeight != '') {
					 if(flag8==true)
		        	   {
					 flag8 = validateDouble($scope.lHbwlContainerBean[i].charcheableWeight);
		        	   }
		         }
				 if ($scope.lHbwlContainerBean[i].rate != undefined && $scope.lHbwlContainerBean[i].rate != null && $scope.lHbwlContainerBean[i].rate != '') {
					 if(flag9==true)
		        	   {
					 flag9 = validateDouble($scope.lHbwlContainerBean[i].rate);
		        	   }
		         }	
				 if ($scope.lHbwlContainerBean[i].amount != undefined && $scope.lHbwlContainerBean[i].amount != null && $scope.lHbwlContainerBean[i].amount != '') {
					 if(flag10==true)
		        	   {
					 flag10 = validateDouble($scope.lHbwlContainerBean[i].amount);
		        	   }
		         }
				
			}
				var obj = {
						hblBean : $scope.hbw,
						lHbwContainerBean	: $scope.lHbwlContainerBean,
				}
				if (flag1 == true && flag2 == true && flag2 == true && flag3 == true && flag4 == true && flag5 == true && flag6 == true && flag7== true && flag8 == true && flag9 == true && flag4 == true && flag10 == true && flag11 == true && flag12 == true && flag13 == true && flag14 == true && flag15 == true) {

	            $http.post($stateParams.tenantid+'/app/air/hbw/save',obj).success(function(data) {
	            	if(data.success){
	            		logger.logSuccess('Saved Successfully');
	            		$location.url($stateParams.tenantid+'/hbw/edit?rowid='+data.hbwId);       
	            		//$scope.cancel();
	            	}else{
	            		logger.logError('Unable to save!');
	            	}
	            	
	            });
			}
			else {
	            if (flag1 == false) {
	                logger.logError("Please Enter Number Value for No Of Pieces in Container Details");
	            }
	            if (flag2 == false) {
	                logger.logError("Please Enter Number Value for LWH in Container Details");
	            }
	            if (flag3 == false) {
	                logger.logError("Please Enter Number Value for NetWeight in Container Details");
	            }
	            if (flag4 == false) {
	                logger.logError("Please Enter Number Value for GrossWeight in Container Details");
	            }
	            if (flag5 == false) {
	                logger.logError("Please Enter Number Value for Length in Container Details");
	            }
	            if (flag6 == false) {
	                logger.logError("Please Enter Number Value for Width in Container Details");
	            }
	            if (flag7 == false) {
	                logger.logError("Please Enter Number Value for Height in Container Details");
	            }
	            if (flag8 == false) {
	                logger.logError("Please Enter Number Value for Chargable Weight in Container Details");
	            }
	            if (flag10 == false) {
	                logger.logError("Please Enter Number Value for Rate in Container Details");
	            }
	            if (flag9 == false) {
	                logger.logError("Please Enter Number Value for Amount in Container Details");
	            }
	            if (flag11 == false) {
	                logger.logError("Please Enter Number Value for Tax");
	            }
	            if (flag12 == false) {
	                logger.logError("Please Enter Number Value for Total Other Charges Due To Agent");
	            }
	            if (flag13 == false) {
	                logger.logError("Please Enter Number Value for Total Other Charges Due To Carrier");
	            }
	            if (flag14 == false) {
	                logger.logError("Please Enter Number Value for Valuation Charges");
	            }
	            if (flag15 == false) {
	                logger.logError("Please Enter Number Value for Amount");
	            }
	        
	        }
			}else {
	            toaster.pop('error', "Please fill the required fields", 
	                    logger.getErrorHtmlNew(hbwForm.$validationSummary), 5000, 'trustedHtml');
	        }
		}
		$scope.update = function(servicePartnerAddForm){
			if (new validationService().checkFormValidity(servicePartnerAddForm)) {
	            var flag1 = true, flag2 = true, flag3 = true, flag4 = true, flag5 = true,flag6 = true, flag7 = true, flag8 = true, flag9 = true, flag10 = true, flag11 = true, flag12 = true, flag13 = true, flag14 = true, flag15 = true;

	            if($scope.hbw.shipperAddress != null && $scope.hbw.shipperAddress != ''){
	      			 var text = $scope.hbw.shipperAddress;
	      	         text = text.replace(/\r?\n/g, '<br>');
	      	      var res = text.replace("–", "-");
	                   $scope.hbw.shipperAddress=res;
	      		}
	      		if($scope.hbw.consigneeAddress != null  && $scope.hbw.consigneeAddress != '' ){
	      			 var text1 = $scope.hbw.consigneeAddress;
	      	         text1 = text1.replace(/\r?\n/g, '<br>');
	      	      var res1 = text1.replace("–", "-");
	                   $scope.hbw.consigneeAddress=res1;
	      		}
	      		if($scope.hbw.notifyAddress != null  && $scope.hbw.notifyAddress != '' ){
	     			 var text2 = $scope.hbw.notifyAddress;
	     	         text2 = text2.replace(/\r?\n/g, '<br>');
	     	       var res2 = text2.replace("–", "-");
	                  $scope.hbw.notifyAddress=res2;
	     		}
	      		
				if($scope.hbw.hbwDocDate=="" || $scope.hbw.hbwDocDate==undefined)
				{
				$scope.hbw.hbwDocDate=null
				}
			
			if($scope.hbw.mbwDocDate=="" || $scope.hbw.mbwDocDate==undefined)
			{
			$scope.hbw.mbwDocDate=null
			}
			if($scope.hbw.etaAtPod=="" || $scope.hbw.etaAtPod==undefined)
			{
			$scope.hbw.etaAtPod=null
			}
			if($scope.hbw.etd=="" || $scope.hbw.etd==undefined)
			{
			$scope.hbw.etd=null
			}
			if($scope.hbw.requestedFlightDate=="" || $scope.hbw.requestedFlightDate==undefined)
			{
			$scope.hbw.requestedFlightDate=null
			}
			if($scope.hbw.requestedFlightDate2=="" || $scope.hbw.requestedFlightDate2==undefined)
			{
			$scope.hbw.requestedFlightDate2=null
			}

			 if ($scope.hbw.tax != undefined && $scope.hbw.tax != null && $scope.hbw.tax != '') {
	           if(flag11==true)
	        	   {
					 flag11 = validateDouble($scope.hbw.tax);

	        	   }
	         }
			 if ($scope.hbw.totalChargeAgent != undefined && $scope.hbw.totalChargeAgent != null && $scope.hbw.totalChargeAgent != '') {
				 if(flag12==true)
	        	   {
				 flag12 = validateDouble($scope.hbw.totalChargeAgent);
	        	   }
	         }
			 if ($scope.hbw.totalChargeCarrier != undefined && $scope.hbw.totalChargeCarrier != null && $scope.hbw.totalChargeCarrier != '') {
				 if(flag13==true)
	        	   {
				 flag13 = validateDouble($scope.hbw.totalChargeCarrier);
	        	   }
	         }
			 if ($scope.hbw.valuationCharge != undefined && $scope.hbw.valuationCharge != null && $scope.hbw.valuationCharge != '') {
				 if(flag14==true)
	        	   {
				 flag14 = validateDouble($scope.hbw.valuationCharge);
	        	   }
	         }
			 if ($scope.hbw.amountOfInsurance != undefined && $scope.hbw.amountOfInsurance != null && $scope.hbw.amountOfInsurance != '') {
				 if(flag15==true)
	        	   {
				 flag15 = validateDouble($scope.hbw.amountOfInsurance);
	        	   }
	         }
			 for(var i=0;i<$scope.lHbwlContainerBean.length;i++){
				 if ($scope.lHbwlContainerBean[i].nofPieces != undefined && $scope.lHbwlContainerBean[i].nofPieces != null && $scope.lHbwlContainerBean[i].nofPieces != '') {
					 if(flag1==true)
		        	   {
					 flag1 = validateNos($scope.lHbwlContainerBean[i].nofPieces);
		        	   }
		         }	
				 
				 if($scope.lHbwlContainerBean[i].descriptionofGoods != null  && $scope.lHbwlContainerBean[i].descriptionofGoods != '' ){
					 var text9 = $scope.lHbwlContainerBean[i].descriptionofGoods;
					 text9 = text9.replace(/\r?\n/g, '<br>');
			         var res9 = text9.replace("–", "-");
			         $scope.lHbwlContainerBean[i].descriptionofGoods=res9;
				}
				 
				 if ($scope.lHbwlContainerBean[i].lWH != undefined && $scope.lHbwlContainerBean[i].lWH != null && $scope.lHbwlContainerBean[i].lWH != '') {
					 if(flag2==true)
		        	   {
					 flag2 = validateNos($scope.lHbwlContainerBean[i].lWH);
		        	   }
		         }
				 if ($scope.lHbwlContainerBean[i].netWeight != undefined && $scope.lHbwlContainerBean[i].netWeight != null && $scope.lHbwlContainerBean[i].netWeight != '') {
					 if(flag3==true)
		        	   {
					 flag3 = validateDouble($scope.lHbwlContainerBean[i].netWeight);
		        	   }
		         }
				 if ($scope.lHbwlContainerBean[i].grossWeight != undefined && $scope.lHbwlContainerBean[i].grossWeight != null && $scope.lHbwlContainerBean[i].grossWeight != '') {
					 if(flag4==true)
		        	   {
					 flag4 = validateDouble($scope.lHbwlContainerBean[i].grossWeight);
		        	   }
		         }
				 if ($scope.lHbwlContainerBean[i].length != undefined && $scope.lHbwlContainerBean[i].length != null && $scope.lHbwlContainerBean[i].length != '') {
					 if(flag5==true)
		        	   {
					 flag5 = validateDouble($scope.lHbwlContainerBean[i].length);
		        	   }
		         }	
				 if ($scope.lHbwlContainerBean[i].width != undefined && $scope.lHbwlContainerBean[i].width != null && $scope.lHbwlContainerBean[i].width != '') {
					 if(flag6==true)
		        	   {
					 flag6 = validateDouble($scope.lHbwlContainerBean[i].width);
		        	   }
		        	   }
				 if ($scope.lHbwlContainerBean[i].height != undefined && $scope.lHbwlContainerBean[i].height != null && $scope.lHbwlContainerBean[i].height != '') {
					 if(flag7==true)
		        	   {
					 flag7 = validateDouble($scope.lHbwlContainerBean[i].height);
		        	   }
		         }
				 if ($scope.lHbwlContainerBean[i].charcheableWeight != undefined && $scope.lHbwlContainerBean[i].charcheableWeight != null && $scope.lHbwlContainerBean[i].charcheableWeight != '') {
					 if(flag8==true)
		        	   {
					 flag8 = validateDouble($scope.lHbwlContainerBean[i].charcheableWeight);
		        	   }
		         }
				 if ($scope.lHbwlContainerBean[i].rate != undefined && $scope.lHbwlContainerBean[i].rate != null && $scope.lHbwlContainerBean[i].rate != '') {
					 if(flag9==true)
		        	   {
					 flag9 = validateDouble($scope.lHbwlContainerBean[i].rate);
		        	   }
		         }	
				 if ($scope.lHbwlContainerBean[i].amount != undefined && $scope.lHbwlContainerBean[i].amount != null && $scope.lHbwlContainerBean[i].amount != '') {
					 if(flag10==true)
		        	   {
					 flag10 = validateDouble($scope.lHbwlContainerBean[i].amount);
		        	   }
		         }
				
			}
			 var obj = {
						hblBean : $scope.hbw,
						lHbwContainerBean	: $scope.lHbwlContainerBean,
				}
				if (flag1 == true && flag2 == true && flag2 == true && flag3 == true && flag4 == true && flag5 == true && flag6 == true && flag7== true && flag8 == true && flag9 == true && flag4 == true && flag10 == true && flag11 == true && flag12 == true && flag13 == true && flag14 == true && flag15 == true) {

	            $http.post($stateParams.tenantid+'/app/air/hbw/update',obj).success(function(data) {
	            	if(data.success){
	            		logger.logSuccess('Updated Successfully');
	            		if($scope.hbw.shipperAddress != null && $scope.hbw.shipperAddress != ''){
		           			 var text5 =$scope.hbw.shipperAddress;
		                        text5 = text5.replace(/\r?<br>/g, '\n');
		                        $scope.hbw.shipperAddress=text5;
		           		}
		           		if($scope.hbw.consigneeAddress != null  && $scope.hbw.consigneeAddress != '' ){
		           			 var text6 =$scope.hbw.consigneeAddress;
		                        text6 = text6.replace(/\r?<br>/g, '\n');
		                        $scope.hbw.consigneeAddress=text6;
		           		}
		           		if($scope.hbw.notifyAddress != null  && $scope.hbw.notifyAddress != '' ){
		          			 var text7 =$scope.hbw.notifyAddress;
		          			text7 = text7.replace(/\r?<br>/g, '\n');
		                       $scope.hbw.notifyAddress=text7;
		          		}
	            		$location.url($stateParams.tenantid+'/hbw/edit?rowid='+data.hbwId);  
	            		//$scope.cancel();
	            	}else{
	            		logger.logError('Unable to save!');
	            	}
	            	
	            });
			}
			else {
				if (flag1 == false) {
	                logger.logError("Please Enter Number Value for No Of Pieces in Container Details");
	            }
	            if (flag2 == false) {
	                logger.logError("Please Enter Number Value for LWH in Container Details");
	            }
	            if (flag3 == false) {
	                logger.logError("Please Enter Number Value for NetWeight in Container Details");
	            }
	            if (flag4 == false) {
	                logger.logError("Please Enter Number Value for GrossWeight in Container Details");
	            }
	            if (flag5 == false) {
	                logger.logError("Please Enter Number Value for Length in Container Details");
	            }
	            if (flag6 == false) {
	                logger.logError("Please Enter Number Value for Width in Container Details");
	            }
	            if (flag7 == false) {
	                logger.logError("Please Enter Number Value for Height in Container Details");
	            }
	            if (flag8 == false) {
	                logger.logError("Please Enter Number Value for Chargable Weight in Container Details");
	            }
	            if (flag10 == false) {
	                logger.logError("Please Enter Number Value for Rate in Container Details");
	            }
	            if (flag9 == false) {
	                logger.logError("Please Enter Number Value for Amount in Container Details");
	            }
	            if (flag11 == false) {
	                logger.logError("Please Enter Number Value for Tax");
	            }
	            if (flag12 == false) {
	                logger.logError("Please Enter Number Value for Total Other Charges Due To Agent");
	            }
	            if (flag13 == false) {
	                logger.logError("Please Enter Number Value for Total Other Charges Due To Carrier");
	            }
	            if (flag14 == false) {
	                logger.logError("Please Enter Number Value for Valuation Charges");
	            }
	            if (flag15 == false) {
	                logger.logError("Please Enter Number Value for Amount");
	            } 
	        }
			}else {
	            toaster.pop('error', "Please fill the required fields", 
	                    logger.getErrorHtmlNew(servicePartnerAddForm.$validationSummary), 5000, 'trustedHtml');
	        }
		}

		 function validateNos(pincode) {
		     var reg =  /^[0-9]+$/
		        if (reg.test(pincode)) {
		            return true;
		        } else {
		            
		            return false;
		        }
		    }
		 
		 function validateDouble(pincode) {
		     var reg = /^[0-9]+(\.[0-9]+)?$/


		        if (reg.test(pincode)) {
		            return true;
		        } else {
		            
		            return false;
		        }
		    }
		 //487
		 $scope.mawbId=servicePartnerId;
		 $scope.printManifest=function(){
			    var url = $stateParams.tenantid+'/airCargoManifest/printHawbManifest?beanId='+$scope.mawbId;
		        var wnd = window.open(url, 'MANIFEST', 'height=700,width=850,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
		        wnd.print();
		}
		$scope.printHawb=function(){
		    var url = $stateParams.tenantid+'/airCargoManifest/printHAWB?beanId='+$scope.mawbId;
	        var wnd = window.open(url, 'HAWB', 'height=700,width=850,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
	        wnd.print();
		}
		$scope.printbooking=function(){
		    var url = $stateParams.tenantid+'/airCargoManifest/printbooking?beanId='+$scope.mawbId;
	        var wnd = window.open(url, 'HAWB', 'height=700,width=850,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
	        wnd.print();
		}
		
 $scope.reset=function(){
	         
	         if( $scope.isEdit == false){ 
	        	 $scope.lHbwlContainerBean =[];
	 		    $scope.hbw = {
	 		            
	 		    	    jobNo:'',
	 		    		 hbwNo:'',
	 		    		 mbwNo:'',
	 		    		 agreed:'',
	 		    		 hbwDocNo:'',
	 		    		 hbwDocDate:'',
	 		    		 mbwDocNo:'',
	 		    		 mbwDocDate:'',
	 		    		 vesselVoyeage:'',
	 		    		 feederVesselVoyeage:'',
	 		    		 vendor:'',
	 		    		 issuePlace:'',
	 		    		 customer:'',
	 		    		 etd:'',
	 		    		 etaAtPod:'',
	 		    		 igmNo:'',
	 		    		 igmDate:'',
	 		    		 itemNo:'',
	 		    		 to:'',
	 		    		 doRemarks:'',
	 		    		 canRemarks:'',
	 		    		 branch:'',
	 		    		 aol:'',
	 		    		 aod:'',
	 		    		 term:'',
	 		    		 salesPerson:'',
	 		    		 vessel:'',
	 		    		 origin:'',
	 		    		 destination:'',
	 		    		 arrivalDate:'',
	 		    		 commodity:'',
	 		    		 sealNo:'',
	 		    		 status:'',
	 		    		 measureMent:'',
	 		    		 remarks:'',
	 		    	     descriptionofGoods:'',
	 		    	     lWHUOM:'',
	 		    	     noOfPieces:'',
	 		    	     shipper:'',
	 		    		 size:'',
	 		    		 noofPackage:'',
	 		    		 uOm:'',
	 		    		 grossWeight:'',
	 		    		 netWeight:'',
	 		    		  chargeableWeight:'',
	 		    		 rateCharge:'',
	 		    		 height:'',
	 		    		 weight:'',
	 		    		 lenght:'',
	 		    		 amount:'',
	 		    		 consignee:'',
	 		    		 shipperAddress:'',
	 		    		 consigneeAddress:'',
	 		    		 notifyAddress:'',
	 		    		 accountingInformation:'',
	 		    		 handlingInformation:'',
	 		    		 airportOfDepature:'',
	 		    		 toDepature:'',
	 		    		 issuingCarringAgent:'',
	 		    		 byFirstCarrier:'',
	 		    		 bySecondCarrier:'',
	 		    		 requestedFlightDate:'',
	 		    		 airportOfDestination:'',
	 		    		 airportOfDischarge2:'',
	 		    		 requestedFlightDate2:'',
	 		    		 iATACode:'',
	 		    		 airportOfDischarge3:'',
	 		    		 byThirdCarrier:'',
	 		    		 containerNumber:'',
	 		    		 freightPayableAt:'',
	 		    		 noOfOriginalBl:'',
	 		    		 preCarriagedBy:'',
	 		    		 valuationCharge:'',
	 		    		 tax:'',
	 		    		 totalChargeCarrier:'',
	 		    		 amountOfInsurance:'',
	 		    		 totalChargeAgent:'',
	 		    		 chargesCode:'',
	 		    		 weightValuationCharge:'',
	 		    		 otherCharge:'',
	 		    		 otherChargeDesc:'',
	 		    		 dvForCarriage:'',
	 		    		 dvForCustoms:'',
	 		    		 consolidationNumber:'',
	 		    		 exportReferences:'',
	 		    		 shipperReferences:'',
	 		    		 ftzNumber:'',
	 		    		 loadingPierTerminal:'',
	 		    		 coLoadedWith:'',
	 		    		 containarized:'',
	 		    	     destinationAgentCode:'',
	 		    	     currency:'',
	 		    	     cargoInsurance:'',
	 		    	     movement:'',
	 		    		 notify:'',
	 		    	     mbwCode:'',
	 		    		 hbwCode:'',
	 		    		 modifedBy:'',
	 		    		 modifedDate:'',
	 		    		 polCode:'',
	 		    		 podCode:'',
	 		    		 originCode:'',
	 		    		 destionationCode:'',
	 		         };
	         }else {
	        	 $http.post($stateParams.tenantid+'/app/air/hbw/view?hblId='+servicePartnerId).success(function(data) {
	 	        	if(data.success){
	 	        		$scope.jobDetail=true;

	 	        		$scope.hbw = data.hblBean;
	 	        		$scope.lHbwlContainerBean=data.lHbwContainerBean;
	 	        		$scope.hbw.jobNo = data.hblBean.jobNo.toString();
	 	        		$scope.hbw.mbwNo = data.hblBean.mbwNo.toString();
	 	        		$scope.hbw.aol = data.hblBean.aol.toString();
	 	        		$scope.hbw.aod = data.hblBean.aod.toString();
	 	        		$scope.hbw.term = data.hblBean.term.toString();
	 	        		$scope.hbw.customer = data.hblBean.customer.toString();
	 	        		$scope.hbw.branch = data.hblBean.branch.toString();

	 	        	
	 	        		if(data.hblBean.origin!=null&&data.hblBean.origin!='')
	 	    			{
	 	        		$scope.hbw.origin = data.hblBean.origin.toString();

	 	    			}

	 	        		if(data.hblBean.destination!=null&&data.hblBean.destination!='')
	 	    			{
	 	        		$scope.hbw.destination = data.hblBean.destination.toString();

	 	    			}
	 	        		if(data.hblBean.salesPerson!=null&&data.hblBean.salesPerson!='')
	 	    			{
	 	        		$scope.hbw.salesPerson = data.hblBean.salesPerson.toString();

	 	    			}
	 	    		   if(data.hblBean.shipper!=null && data.hblBean.shipper!='')
	 				   {
	 	        		$scope.hbw.shipper = data.hblBean.shipper.toString();

	 				    }
	 	    		   if(data.hblBean.consignee!=null && data.hblBean.consignee!='')
	 				   {
	 	        		$scope.hbw.consignee = data.hblBean.consignee.toString();

	 				    }
	 	    		  
	 	    		   if(data.hblBean.airportOfDischarge2!=null && data.hblBean.airportOfDischarge2!='')
	 				   {
	 	        		$scope.hbw.airportOfDischarge2 = data.hblBean.airportOfDischarge2.toString();

	 				    }
	 	    		   if(data.hblBean.airportOfDischarge3!=null && data.hblBean.airportOfDischarge3!='')
	 				   {
	 	        		$scope.hbw.airportOfDischarge3 = data.hblBean.airportOfDischarge3.toString();

	 				    }
	 	    		   if(data.hblBean.to!=null && data.hblBean.to!='')
	 				   {
	 	        		$scope.hbw.to = data.hblBean.to.toString();

	 				    }
	 	    		  
	 	    		   if(data.hblBean.weightValuationCharge!=null && data.hblBean.weightValuationCharge!='')
	 				   {
	 	        		$scope.hbw.weightValuationCharge = data.hblBean.weightValuationCharge.toString();

	 				    }
	 	    		   if(data.hblBean.chargesCode!=null && data.hblBean.chargesCode!='')
	 				   {
	 	        		$scope.hbw.chargesCode = data.hblBean.chargesCode.toString();

	 				    }
	 	    		   if(data.hblBean.currency!=null && data.hblBean.currency!='')
	 				   {
	 	        		$scope.hbw.currency = data.hblBean.currency.toString();

	 				    }
	 	    		   if(data.hblBean.otherCharge!=null && data.hblBean.otherCharge!='')
	 				   {
	 	        		$scope.hbw.otherCharge = data.hblBean.otherCharge.toString();

	 				    }
	 	    		   $scope.totalPackageCalculation();
	 	    		   $scope.totalnetWeightCalculation();
	 	    		   $scope.totalgrossWeightCalculation();
	 	    		   $scope.totalamountCalculation();

	 	        		
	         		  $http.post($stateParams.tenantid+'/app/master/hbl/dropDownList').success(function(data) {
	       	          	
	       	          	$scope.vendorList=data.vendor;
	       	      		$scope.customerList=data.customer;
	       	      		$scope.termList=data.term;
	       	      		$scope.destinationList=data.destination;
	       	      		$scope.originList=data.origin;
	       	      		$scope.branchList=data.branch;
	       	      		$scope.podList=data.pod;
	       	      		$scope.polList=data.pol;
	       	      		$scope.typeList=data.typeList;
	       	      		$scope.movementList=data.movement;
	       	      		$scope.preCarriageList=data.preCarriaged;
	       	      		$scope.destinationAgentList=data.destination;	
	       	      		$scope.hblList=data.hbl;
	       	      		$scope.consigneeList=data.customer;
	       	      		//$scope.mblList=data.mbw;
	       	      		$scope.hblList=data.hbw;
	       	      		$scope.jobList=data.airJob;
	               		$scope.salesPersonList=data.salesPerson;
	               		$scope.otherChargesList=data.paymentList;
	               		$scope.iataList=data.iataList;
	               		$scope.currencyList=data.currency;
	              		$scope.iataListDetail=data.iataListDetail;


	               		
	       	          });	
	 	        	
	 	        	}else{
	 	        		logger.logError("Unable to fetch data");
	 	        	}
	 	        });
	         }
	     }
 

       $scope.quickLinkMethd=function(qulkVal){
			if(qulkVal!='Select'){
				if($scope.hbw.hbwNo!='' && $scope.hbw.hbwNo!=undefined){
			$http.post($stateParams.tenantid + '/app/air/hbw/getQuickLinkId?category='+qulkVal+'&hawbId='+$scope.hbw.hbwNo).success(function(datas) {
						if(datas.quickLinkId!=null){
							var rowid=datas.quickLinkId;
							if(qulkVal=="Job Order"){
								if(rowid!=0){
									$location.url($stateParams.tenantid+'/jobOrderAir/edit?rowid='+rowid); 
									//$window.open('#'+$stateParams.tenantid+'/jobOrderAir/view?rowid='+rowid, '_blank');
								}else{
									logger.logError("There is no "+qulkVal);
								}
								
							}else if(qulkVal=="MAWB"){
								if(rowid!=0){
									$location.url($stateParams.tenantid+'/mabw/edit?rowid='+rowid); 
									//$window.open('#'+$stateParams.tenantid+'/mabw/view?rowid='+rowid,'_blank');
								}else{
									logger.logError("There is no "+qulkVal);
								}
								
							}else if(qulkVal=="Delivery Order"){
								if(rowid!=0){
									$location.url($stateParams.tenantid+'/airdeliveryorder/edit?rowid='+rowid);
									//$window.open('#'+$stateParams.tenantid+'/airdeliveryorder/view?rowid='+rowid,'_blank');
								}else{
									logger.logError("There is no "+qulkVal);
								}
								
							}else if(qulkVal=="Sales Invoice"){
								if(rowid!=0){
									$location.url($stateParams.tenantid+'/invoice/salesinvoice/salesInvoiceView/'+rowid);
									//$window.open('#'+$stateParams.tenantid+"/invoice/salesinvoice/salesInvoiceView/"+rowid,'_blank');
								}else{
									logger.logError("There is no "+qulkVal);
								}
								
							}else if(qulkVal=="Purchase Invoice"){
								if(rowid!=0){
									$location.url($stateParams.tenantid+'/invoice/purchaseinvoice/PurchaseInvoiceView/'+rowid);
									//$window.open('#'+$stateParams.tenantid+"/invoice/purchaseinvoice/PurchaseInvoiceView/"+rowid,'_blank');
								}else{
									logger.logError("There is no "+qulkVal);
								}
								
							}
						} else if(datas.quickLinkIdList!=null){
							var quickLinkIdList=datas.quickLinkIdList;

							if(qulkVal=="Job Order"){
								$location.url($stateParams.tenantid+'/joborder/list?quickLinkIdList='+quickLinkIdList);
								//$window.open('#'+$stateParams.tenantid+'/hbw/list?quickLinkIdList='+quickLinkIdList, '_blank');
							}else if(qulkVal=="MAWB"){
								$location.url($stateParams.tenantid+'/mabw/list?quickLinkIdList='+quickLinkIdList);
								//$window.open('#'+$stateParams.tenantid+'/mabw/list?quickLinkIdList='+quickLinkIdList, '_blank');
							}else if(qulkVal=="Delivery Order"){
								$location.url($stateParams.tenantid+'/airdeliveryorder/list?quickLinkIdList='+quickLinkIdList);
								//$window.open('#'+$stateParams.tenantid+'/airdeliveryorder/list?quickLinkIdList='+quickLinkIdList, '_blank');
							}else if(qulkVal=="Sales Invoice"){ 
								$location.url($stateParams.tenantid+'/invoice/salesinvoice/SalesInvoiceList?quickLinkIdList='+quickLinkIdList);
								//$window.open('#'+$stateParams.tenantid+'/invoice/salesinvoice/SalesInvoiceList?quickLinkIdList='+quickLinkIdList,'_blank');
							}else if(qulkVal=="Purchase Invoice"){
								$location.url($stateParams.tenantid+'/invoice/purchaseinvoice/PurchaseInvoiceList?quickLinkIdList='+quickLinkIdList);
								//$window.open('#'+$stateParams.tenantid+'/invoice/purchaseinvoice/PurchaseInvoiceList?quickLinkIdList='+quickLinkIdList,'_blank');
							}
							
						
						}else{
							var quickLinkIdList=datas.quickLinkIdList;
							if(qulkVal=="Job Order"){
								$location.url($stateParams.tenantid+'/hbw/list?quickLinkIdList='+quickLinkIdList);
								//$window.open('#'+$stateParams.tenantid+'/hbw/list?quickLinkIdList='+quickLinkIdList, '_blank');
							}else if(qulkVal=="MAWB"){
								$location.url($stateParams.tenantid+'/mabw/list?quickLinkIdList='+quickLinkIdList);
								//$window.open('#'+$stateParams.tenantid+'/mabw/list?quickLinkIdList='+quickLinkIdList, '_blank');
							}else if(qulkVal=="Delivery Order"){
								$location.url($stateParams.tenantid+'/airdeliveryorder/list?quickLinkIdList='+quickLinkIdList);
								//$window.open('#'+$stateParams.tenantid+'/airdeliveryorder/list?quickLinkIdList='+quickLinkIdList, '_blank');
							}else if(qulkVal=="Sales Invoice"){ 
								$location.url($stateParams.tenantid+'/invoice/salesinvoice/SalesInvoiceList?quickLinkIdList='+quickLinkIdList);
								//$window.open('#'+$stateParams.tenantid+'/invoice/salesinvoice/SalesInvoiceList?quickLinkIdList='+quickLinkIdList,'_blank');
							}else if(qulkVal=="Purchase Invoice"){
								$location.url($stateParams.tenantid+'/invoice/purchaseinvoice/PurchaseInvoiceList?quickLinkIdList='+quickLinkIdList);
								//$window.open('#'+$stateParams.tenantid+'/invoice/purchaseinvoice/PurchaseInvoiceList?quickLinkIdList='+quickLinkIdList,'_blank');
							}
							
						
						}
						
			})
			}else{
				logger.logError("There is no Job No.");
			}
		}
		}

});

