'use strict';

app.controller('mabwAddCtrl', function($scope, $rootScope, $http, $location, logger, ngDialog,
        utilsService,$state,sharedProperties,$window,$stateParams,toaster,validationService) {

 $scope.displayedCollection = [];
var date  = new Date();
var dateString =  date.getDate() + "/" + date.getMonth() + "/" + date.getFullYear() + " " + date.getHours() + ":" + date.getMinutes();
	$scope.rowCollectionFollowup=[];
    $scope.referralList=[];
    $scope.isEdit = false;
    $scope.tairDetailList =[];
    $scope.isEdit=false;
     $scope.s1 = true;
     $scope.s2 = false;
	

    $scope.cancel = function() {
	  	  $state.go('app.air.mabw.list',{tenantid:$stateParams.tenantid});
	  	  
	          
	    };
    
	   
		    $scope.lMablContainerBean =[];
	     $scope.lMabwJobDetailBean=[];

		    $scope.mbw = {
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
		    		 type:'',
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
		    
		    $scope.tempMablContainerBean = {
					select 		:false,
					commodity:'',
					descriptionofGoods:'',
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
					rate:'',

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

			$scope.mbw.mbwDate = dd + '/' + mm + '/'
					+ yyyy;
	 //add Row
	  $scope.addCredRow = function() {
	   
		  var tmp=angular.copy($scope.tempMablContainerBean);
			$scope.lMablContainerBean.push(tmp);

	  }
	  $scope.addCredRow();

		$scope.removeCredRow =function(){
			if($scope.isEdit==false){
				var tmpDelList = [];
				for(var i=$scope.lMablContainerBean.length-1;i>=0;i--){
					if($scope.lMablContainerBean[i].select==true){
						tmpDelList.push($scope.lMablContainerBean[i]);
						$scope.lMablContainerBean.splice(i, 1);
					}
				}
				logger.logSuccess('Deleted Successfully');
			}else if($scope.isEdit==true){
				var tmpDelList = [];
				for(var i=$scope.lMablContainerBean.length-1;i>=0;i--){
					if($scope.lMablContainerBean[i].select==true){
						tmpDelList.push($scope.lMablContainerBean[i]);
					}
				}
				$http.post($stateParams.tenantid+'/app/air/mabw/deleteContainerDetail',tmpDelList).success(function(data) {
		        	if(data.success){
		        		for(var i=$scope.lMablContainerBean.length-1;i>=0;i--){
		    				if($scope.lMablContainerBean[i].select==true){
		    					$scope.lMablContainerBean.splice(i, 1);
		    				}
		    			}
		        		logger.logSuccess('Deleted Successfully');
		        	}else{
		        		logger.logError('Unable to delete');
		        	}
				})
			}
			
		}
		$scope.pod="";
		$scope.pol="";
		$scope.branch="";
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
				var mablContainerBean = $scope.lMablContainerBean;
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
					var mablContainerBean = $scope.lMablContainerBean;
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
						var mablContainerBean = $scope.lMablContainerBean;
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
							var mablContainerBean = $scope.lMablContainerBean;
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
			var k=0;
	        $http.post($stateParams.tenantid+'/app/air/mabw/edit?mablId='+servicePartnerId).success(function(data) {
	        	if(data.success){
	        		$scope.jobDetail= true;
	        		$scope.mbw = data.hblBean;
	        		$scope.lMablContainerBean=data.lMabwContainerBean;
	        		if($scope.mbw.shipperAddress != null && $scope.mbw.shipperAddress != ''){
	           			 var text5 =$scope.mbw.shipperAddress;
	                        text5 = text5.replace(/\r?<br>/g, '\n');
	                        $scope.mbw.shipperAddress=text5;
	           		}
	           		if($scope.mbw.consigneeAddress != null  && $scope.mbw.consigneeAddress != '' ){
	           			 var text6 =$scope.mbw.consigneeAddress;
	                        text6 = text6.replace(/\r?<br>/g, '\n');
	                        $scope.mbw.consigneeAddress=text6;
	           		}
	           		if($scope.mbw.notifyAddress != null  && $scope.mbw.notifyAddress != '' ){
	          			 var text7 =$scope.mbw.notifyAddress;
	          			text7 = text7.replace(/\r?<br>/g, '\n');
	                       $scope.mbw.notifyAddress=text7;
	          		}
	        		for(var i=0;i<$scope.lMablContainerBean.length;i++) 
                	{
                	if($scope.lMablContainerBean[i].lWHUOM!=null&&$scope.lMablContainerBean[i].lWHUOM!='')
                		{
                		$scope.lMablContainerBean[i].lWHUOM=$scope.lMablContainerBean[i].lWHUOM.toString();

                		}
                	

                	}
	            	
	        		
	        		$scope.mbw.aol = data.hblBean.aol.toString();
	        		$scope.mbw.aod = data.hblBean.aod.toString();
	        		$scope.mbw.term = data.hblBean.term.toString();
	        		$scope.mbw.customer = data.hblBean.customer.toString();
	        		$scope.mbw.branch = data.hblBean.branch.toString();
	        		$scope.mbw.type = data.hblBean.type.toString();
	        		$scope.mbw.vendor = data.hblBean.vendor.toString();

	        		$scope.pod=data.hblBean.aod.toString();
	        		$scope.pol=data.hblBean.aol.toString();
	        		$scope.branch=data.hblBean.branch.toString();
	        		
	        		if(data.hblBean.origin!=null&&data.hblBean.origin!='')
	    			{
	        		$scope.mbw.origin = data.hblBean.origin.toString();;

	    			}

	        		if(data.hblBean.destination!=null&&data.hblBean.destination!='')
	    			{
	        		$scope.mbw.destination = data.hblBean.destination.toString();;

	    			}
	        		if(data.hblBean.salesPerson!=null&&data.hblBean.salesPerson!='')
	    			{
	        		$scope.mbw.salesPerson = data.hblBean.salesPerson.toString();;

	    			}
	    		   if(data.hblBean.shipper!=null && data.hblBean.shipper!='')
				   {
	        		$scope.hbw.shipper = data.hblBean.shipper.toString();;

				    }
	    		   if(data.hblBean.consignee!=null && data.hblBean.consignee!='')
				   {
	        		$scope.mbw.consignee = data.hblBean.consignee.toString();;

				    }
	    		  
	    		   if(data.hblBean.airportOfDischarge2!=null && data.hblBean.airportOfDischarge2!='')
				   {
	        		$scope.mbw.airportOfDischarge2 = data.hblBean.airportOfDischarge2.toString();;

				    }
	    		   else
    			   {
	        		$scope.mbw.airportOfDischarge2 ='';

    			   }
	    		   if(data.hblBean.airportOfDischarge3!=null && data.hblBean.airportOfDischarge3!='')
				   {
	        		$scope.mbw.airportOfDischarge3 = data.hblBean.airportOfDischarge3.toString();;

				    }
	    		   else
    			   {
	        		$scope.mbw.airportOfDischarge3 ='';

    			   }
	    		   if(data.hblBean.to!=null && data.hblBean.to!='')
				   {
	        		$scope.mbw.to = data.hblBean.to.toString();;

				    }
	    		   else
	    			   {
 	        		$scope.mbw.to ='';

	    			   }
	    		  
	    		  
	    		   if(data.hblBean.otherCharge!=null && data.hblBean.otherCharge!='')
				   {
	        		$scope.mbw.otherCharge = data.hblBean.otherCharge.toString();;

				    }
	    		   if(data.hblBean.weightValuationCharge!=null && data.hblBean.weightValuationCharge!='')
				   {
	        		$scope.mbw.weightValuationCharge = data.hblBean.weightValuationCharge.toString();;

				    }
	    		   else
    			   {
	        		$scope.mbw.weightValuationCharge ='';

    			   }
	    		   if(data.hblBean.chargesCode!=null && data.hblBean.chargesCode!='')
				   {
	        		$scope.mbw.chargesCode = data.hblBean.chargesCode.toString();;

				    }
	    		   if(data.hblBean.currency!=null && data.hblBean.currency!='')
				   {
	        		$scope.mbw.currency = data.hblBean.currency.toString();;

				    }
	    		   else
	    			   {
 	        		$scope.mbw.currency ='';

	    			   }
	    		  
	    		   $scope.totalPackageCalculation();
	    		   $scope.totalnetWeightCalculation();
	    		   $scope.totalgrossWeightCalculation();
	    		   $scope.totalamountCalculation();
	    		   if(data.lMabwJobDetailBean.length!=0){
	        			 $scope.jobDetail= true;
			          	 $scope.s1 = false;
	        			$scope.lMabwJobDetailBean=data.lMabwJobDetailBean;
			          /* $scope.$watchCollection('[mbw.branch,mbw.aol,mbw.aod]', function(newValue, oldValue) {
					       {

					    	   $scope.branchData= $scope.mbw.branch;
					    	   $scope.polData= $scope.mbw.aol;
					    	   $scope.podData= $scope.mbw.aod;
					    	   if($scope.isEdit==true || $scope.podData!=$scope.pod || $scope.polData!=$scope.pol || $scope.branchData!=$scope.branch)
					    		   {
					    	   if($scope.mbw.branch!=undefined && $scope.mbw.branch!=null && $scope.mbw.branch!="" && $scope.mbw.aol!=undefined && $scope.mbw.aol!=null && $scope.mbw.aol!="" && $scope.mbw.aod!=undefined && $scope.mbw.aod!=null && $scope.mbw.aod!="" && ($scope.isEdit==false || k<=0))
					    		   {
					    	       $scope.lMbwJobDetailBean=[];
					    	       k++;

					   	        $http.post($stateParams.tenantid+'/app/air/mabw/getJobDetail?branchId='+$scope.branchData+'&pol='+$scope.polData+'&pod='+$scope.podData).success(function(data) {
					   	         if(data.success==true)
				            	 {
				            	 if(data.lMabwJobDetailBean.length !=0){
				            	 
				          	   $scope.jobDetail= true;
				          	 $scope.s1 = false;

				            	 $scope.lMabwJobDetailBean=data.lMabwJobDetailBean;
				            	 }else{
				            		 
				            		 $scope.jobDetail= false;
				            		 $scope.s1 = false;
				            		
				            		 $scope.t1=data.s1;
				            		 $scope.t2=data.s2;
				            		 $scope.t3=data.s3;
				            	 }
				            	 }
					   	        })
					    		   
					    	}
					    		   }
					       }
					       })*/
					       
	        			
	        		}else{
	        			$scope.s2 = true;
	        			$scope.s1 = false;
	        			//$scope.jobDetail= false;
	        			
	        		}/*else{
	        			 $scope.jobDetail= false;
	        			 $scope.$watchCollection('[mbw.branch,mbw.aol,mbw.aod]', function(newValue, oldValue) {
	  					       {

	  					    	   $scope.branchData= $scope.mbw.branch;
	  					    	   $scope.polData= $scope.mbw.aol;
	  					    	   $scope.podData= $scope.mbw.aod;
	  					    	 $scope.lMabwJobDetailBean=data.lMabwJobDetailBean;
	  					    	   if($scope.isEdit==false || $scope.podData!=$scope.pod || $scope.polData!=$scope.pol || $scope.branchData!=$scope.branch)
	  					    		   {
	  					    	   if($scope.mbw.branch!=undefined && $scope.mbw.branch!=null && $scope.mbw.branch!="" && $scope.mbw.aol!=undefined && $scope.mbw.aol!=null && $scope.mbw.aol!="" && $scope.mbw.aod!=undefined && $scope.mbw.aod!=null && $scope.mbw.aod!="")
	  					    		   {
	  					    	       $scope.lMbwJobDetailBean=[];

	  					   	        $http.post($stateParams.tenantid+'/app/air/mabw/getJobDetail?branchId='+$scope.branchData+'&pol='+$scope.polData+'&pod='+$scope.podData).success(function(data) {
	  					   	         if(data.success==true)
	  				            	 {
	  				            	 if(data.lMabwJobDetailBean.length !=0){
	  				            	 
	  				          	   $scope.jobDetail= true;
	  				          	 $scope.s1 = false;

	  				            	 $scope.lMabwJobDetailBean=data.lMabwJobDetailBean;
	  				            	 }else{
	  				            		 
	  				            		 $scope.jobDetail= false;
	  				            		 $scope.s1 = false;
	  				            		
	  				            		 $scope.t1=data.s1;
	  				            		 $scope.t2=data.s2;
	  				            		 $scope.t3=data.s3;
	  				            	 }
	  				            	 }
	  					   	        })
	  					    		   
	  					    	}
	  					    		   }
	  					       }
	  					       })
	        		}*/

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
      	      		$scope.mblList=data.mbw;
      	      		$scope.hblList=data.hbw;
      	      		$scope.jobList=data.airJob;
              		$scope.otherChargesList=data.paymentList;
              		$scope.currencyList=data.currency;
              		$scope.iataList=data.iataList;
              		$scope.iataListDetail=data.iataListDetail;

      	          	
      	          });	
	        	
	        	}else{
	        		logger.logError("Unable to fetch data");
	        	}
	        });
		}
		  $scope.viewQuotation = function(jobNo) {
				debugger
					$location.url($stateParams.tenantid+'/jobOrderAir/view?rowid='+jobNo);
				
			}
		
		   $scope.$watchCollection('[mbw.branch,mbw.aol,mbw.aod]', function(newValue, oldValue) {
		       {

		    	   $scope.branchData= $scope.mbw.branch;
		    	   $scope.polData= $scope.mbw.aol;
		    	   $scope.podData= $scope.mbw.aod;
		    	   if($scope.isEdit==false || $scope.podData!=$scope.pod || $scope.polData!=$scope.pol || $scope.branchData!=$scope.branch)
		    		   {
		    	   if($scope.mbw.branch!=undefined && $scope.mbw.branch!=null && $scope.mbw.branch!="" && $scope.mbw.aol!=undefined && $scope.mbw.aol!=null && $scope.mbw.aol!="" && $scope.mbw.aod!=undefined && $scope.mbw.aod!=null && $scope.mbw.aod!="")
		    		   {
		    	       $scope.lMbwJobDetailBean=[];

		   	        $http.post($stateParams.tenantid+'/app/air/mabw/getJobDetail?branchId='+$scope.branchData+'&pol='+$scope.polData+'&pod='+$scope.podData).success(function(data) {
		   	         if(data.success==true)
	            	 {
	            	 if(data.lMabwJobDetailBean.length !=0){
	            	 
	          	   $scope.jobDetail= true;
	          	 $scope.s1 = false;

	            	 $scope.lMabwJobDetailBean=data.lMabwJobDetailBean;
	            	 }else{
	            		 
	            		 $scope.lMablContainerBean='';
	            		 $scope.jobDetail= false;
	            		 $scope.s1 = false;
	            		
	            		 $scope.t1=data.s1;
	            		 $scope.t2=data.s2;
	            		 $scope.t3=data.s3;
	            	 }
	            	 }
		   	        })
		    		   
		    	}
		    		   }
		       }
		       })
		       
		      $scope.container = function(select,index)
		         {

		    	for (var i= $scope.lMabwJobDetailBean.length-1;i>=0;i--)
		    		{
		    		var jobNo = $scope.lMabwJobDetailBean[i].jobNo;
		    		if($scope.lMabwJobDetailBean[i].select==true)
		    			{
	    	  			$http.post($stateParams.tenantid+'/app/air/mabw/getcontlist',$scope.lMabwJobDetailBean).success(function(data) {
	 	            	if(data.success){
	 	            		console.log(data.lMabwContainerBean);
	 	            		$scope.lMablContainerBean=data.lMabwContainerBean;
	 	            		if(data.lMabwBean[0].vendor != '' && data.lMabwBean[0].vendor != null){
	 	            			$scope.mbw.vendor =data.lMabwBean[0].vendor.toString();
	 	            		}
	 	            		if(data.lMabwBean[0].destination != '' && data.lMabwBean[0].destination != null){
	 	            			$scope.mbw.destination =data.lMabwBean[0].destination.toString();
	 	            		}
	 	            		if(data.lMabwBean[0].origin != '' && data.lMabwBean[0].origin != null){
	 	            			$scope.mbw.origin =data.lMabwBean[0].origin.toString();
	 	            		}
	 	            		if(data.lMabwBean[0].term != '' && data.lMabwBean[0].term != null){
	 	            			$scope.mbw.term =data.lMabwBean[0].term.toString();
	 	            		}
	 	            		$scope.mbw.airportOfDepature =data.lMabwBean[0].airportOfDepature;
	 	            		$scope.mbw.airportOfDestination =data.lMabwBean[0].airportOfDestination;
	 	            		$scope.mbw.byFirstCarrier =data.lMabwBean[0].byFirstCarrier;
	 	            		$scope.mbw.shipperAddress =data.lMabwBean[0].shipperAddress;
	 	            		$scope.mbw.consigneeAddress =data.lMabwBean[0].consigneeAddress;
	 	            		$scope.mbw.notifyAddress =data.lMabwBean[0].notifyAddress;
	 	            		if(data.lMabwBean[0].toDepature!= null &&  data.lMabwBean[0].toDepature!= undefined)
	 	            			{
	 	            		$scope.mbw.to =data.lMabwBean[0].toDepature.toString();
	 	            			}
	 	            		for(var i=0;i<$scope.lMablContainerBean.length;i++) 
	 	                	{
	 	                	if($scope.lMablContainerBean[i].lWHUOM!=null&&$scope.lMablContainerBean[i].lWHUOM!='')
	 	                		{
	 	                		$scope.lMablContainerBean[i].lWHUOM=$scope.lMablContainerBean[i].lWHUOM.toString();

	 	                		}
	 	                	}
	 	            	
	 	            		}
	    	  			});
	    	
		         }
		    		else
		    			{
		    			$scope.lMablContainerBean='';
 	            		$scope.mbw.airportOfDepature ='';
 	            		$scope.mbw.airportOfDestination ='';
 	            		$scope.mbw.byFirstCarrier ='';
 	            		$scope.mbw.shipperAddress ='';
 	            		$scope.mbw.consigneeAddress ='';
 	            		$scope.mbw.notifyAddress ='';
 	            		$scope.mbw.to='';
		    			}
		         }
		         }

		       
		
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
      	      		$scope.mblList=data.mbw;
      	      		$scope.hblList=data.hbw;
      	      		$scope.jobList=data.airJob;
              		$scope.otherChargesList=data.paymentList;
              		$scope.currencyList=data.currency;
              		$scope.iataList=data.iataList;
              		$scope.iataListDetail=data.iataListDetail;

	          	
	          });
		  $http.get(
					$stateParams.tenantid
							+ '/app/airquotation/getuomList')
					.success(function(datas) {
						$scope.uomList = datas.commonUtilityBean;

					}).error(function(data) {

					});
		$scope.save = function(mbwForm){
			if (new validationService().checkFormValidity(mbwForm)) {
	            var flag1 = true, flag2 = true, flag3 = true, flag4 = true, flag5 = true,flag6 = true, flag7 = true, flag8 = true, flag9 = true, flag10 = true, flag11 = true, flag12 = true, flag13 = true, flag14 = true, flag15 = true;

				if($scope.mbw.hbwDocDate=="" || $scope.mbw.hbwDocDate==undefined)
				{
				$scope.mbw.hbwDocDate=null
				}
			
			if($scope.mbw.mbwDocDate=="" || $scope.mbw.mbwDocDate==undefined)
			{
			$scope.mbw.mbwDocDate=null
			}
			if($scope.mbw.etaAtPod=="" || $scope.mbw.etaAtPod==undefined)
			{
			$scope.mbw.etaAtPod=null
			}
			if($scope.mbw.etd=="" || $scope.mbw.etd==undefined)
			{
			$scope.mbw.etd=null
			}
			if($scope.mbw.requestedFlightDate=="" || $scope.mbw.requestedFlightDate==undefined)
			{
			$scope.mbw.requestedFlightDate=null
			}
			if($scope.mbw.requestedFlightDate2=="" || $scope.mbw.requestedFlightDate2==undefined)
			{
			$scope.mbw.requestedFlightDate2=null
			}
			if($scope.mbw.shipperAddress != null && $scope.mbw.shipperAddress != ''){
				 var text = $scope.mbw.shipperAddress;
		         text = text.replace(/\r?\n/g, '<br>');
		         var res = text.replace("–", "-");
	             $scope.mbw.shipperAddress=res;
			}
			if($scope.mbw.consigneeAddress != null  && $scope.mbw.consigneeAddress != '' ){
				 var text1 = $scope.mbw.consigneeAddress;
		         text1 = text1.replace(/\r?\n/g, '<br>');
		         var res1 = text1.replace("–", "-");
	             $scope.mbw.consigneeAddress=res1;
			}
			if($scope.mbw.notifyAddress != null  && $scope.mbw.notifyAddress != '' ){
				 var text2 = $scope.mbw.notifyAddress;
		         text2 = text2.replace(/\r?\n/g, '<br>');
		         var res2 = text2.replace("–", "-");
	            $scope.mbw.notifyAddress=res2;
			}
			if ($scope.mbw.tax != undefined && $scope.mbw.tax != null && $scope.mbw.tax != '') {
				 if (flag11 == true)
				 {
				 flag11 = validateDouble($scope.mbw.tax);
				 }
	         }
			 if ($scope.mbw.totalChargeAgent != undefined && $scope.mbw.totalChargeAgent != null && $scope.mbw.totalChargeAgent != '') {
				 if (flag12 == true)
				 {
				 flag12 = validateDouble($scope.mbw.totalChargeAgent);
				 }
	         }
			 if ($scope.mbw.totalChargeCarrier != undefined && $scope.mbw.totalChargeCarrier != null && $scope.mbw.totalChargeCarrier != '') {
				 if (flag13 == true)
				 {
				 flag13 = validateDouble($scope.mbw.totalChargeCarrier);
				 }
	         }
			 if ($scope.mbw.valuationCharge != undefined && $scope.mbw.valuationCharge != null && $scope.mbw.valuationCharge != '') {
				 if (flag14 == true)
				 {
				 flag14 = validateDouble($scope.mbw.valuationCharge);
				 }
	         }
			 if ($scope.mbw.amountOfInsurance != undefined && $scope.mbw.amountOfInsurance != null && $scope.mbw.amountOfInsurance != '') {
	             flag15 = validateDouble($scope.mbw.amountOfInsurance);
	         }
			for(var i=0;i<$scope.lMablContainerBean.length;i++){
				 if ($scope.lMablContainerBean[i].nofPieces != undefined && $scope.lMablContainerBean[i].nofPieces != null && $scope.lMablContainerBean[i].nofPieces != '') {
					 if (flag1 == true)
					 {
					 flag1 = validateNos($scope.lMablContainerBean[i].nofPieces);
					 }
		         }	
				 if ($scope.lMablContainerBean[i].lWH != undefined && $scope.lMablContainerBean[i].lWH != null && $scope.lMablContainerBean[i].lWH != '') {
					 if (flag2 == true)
					 {
					 flag2 = validateNos($scope.lMablContainerBean[i].lWH);
					 }
		         }
				 if ($scope.lMablContainerBean[i].netWeight != undefined && $scope.lMablContainerBean[i].netWeight != null && $scope.lMablContainerBean[i].netWeight != '') {
					 if (flag3 == true)
					 {
					 flag3 = validateDouble($scope.lMablContainerBean[i].netWeight);
					 }
					 
		         }
				 if ($scope.lMablContainerBean[i].grossWeight != undefined && $scope.lMablContainerBean[i].grossWeight != null && $scope.lMablContainerBean[i].grossWeight != '') {
					 if (flag4 == true)
					 {
					 flag4 = validateDouble($scope.lMablContainerBean[i].grossWeight);
					 }
		         }
				 if ($scope.lMablContainerBean[i].length != undefined && $scope.lMablContainerBean[i].length != null && $scope.lMablContainerBean[i].length != '') {
					 if (flag5 == true)
					 {
					 flag5 = validateDouble($scope.lMablContainerBean[i].length);
					 }
		         }	
				 if ($scope.lMablContainerBean[i].width != undefined && $scope.lMablContainerBean[i].width != null && $scope.lMablContainerBean[i].width != '') {
					 if (flag6 == true)
					 {
					 flag6 = validateDouble($scope.lMablContainerBean[i].width);
					 }
		         }
				 if ($scope.lMablContainerBean[i].height != undefined && $scope.lMablContainerBean[i].height != null && $scope.lMablContainerBean[i].height != '') {
					 if (flag7 == true)
					 {
					 flag7 = validateDouble($scope.lMablContainerBean[i].height);
					 
					 }
		         }
				 if ($scope.lMablContainerBean[i].charcheableWeight != undefined && $scope.lMablContainerBean[i].charcheableWeight != null && $scope.lMablContainerBean[i].charcheableWeight != '') {
					 if (flag8 == true)
					 {
					 flag8 = validateDouble($scope.lMablContainerBean[i].charcheableWeight);
					 }
		         }
				 if ($scope.lMablContainerBean[i].rate != undefined && $scope.lMablContainerBean[i].rate != null && $scope.lMablContainerBean[i].rate != '') {
					 if (flag9 == true)
					 {
					 flag9 = validateDouble($scope.lMablContainerBean[i].rate);
					 }
		         }	
				 if ($scope.lMablContainerBean[i].amount != undefined && $scope.lMablContainerBean[i].amount != null && $scope.lMablContainerBean[i].amount != '') {
					 if (flag10 == true)
						 {
						 flag10 = validateDouble($scope.lMablContainerBean[i].amount);

						 }
		         }
				
			}
			$scope.lMabwJobDetailBean1=[];
			for(var i=0;i<$scope.lMabwJobDetailBean.length;i++)
				{
				if($scope.lMabwJobDetailBean[i].select==true)
				$scope.lMabwJobDetailBean1.push($scope.lMabwJobDetailBean[i]);
				}
				var obj = {
						hblBean : $scope.mbw,
						lMabwContainerBean: $scope.lMablContainerBean,
						lMabwJobDetailBean:$scope.lMabwJobDetailBean1,
				}
				if($scope.lMabwJobDetailBean1.length>0)
					{
				if (flag1 == true && flag2 == true && flag2 == true && flag3 == true && flag4 == true && flag5 == true && flag6 == true && flag7== true && flag8 == true && flag9 == true && flag4 == true && flag10 == true && flag11 == true && flag12 == true && flag13 == true && flag14 == true && flag15 == true) {

	            $http.post($stateParams.tenantid+'/app/air/mabw/save',obj).success(function(data) {
	            	if(data.success){
	            		logger.logSuccess('Saved Successfully');
	            		$location.url($stateParams.tenantid+'/mabw/edit?rowid='+data.mablId);       
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
			}
				else
					{
                    logger.logError("Job Details: Field is Required");

					}
			}else {
	            toaster.pop('error', "Please fill the required fields", 
	                    logger.getErrorHtmlNew(mbwForm.$validationSummary), 5000, 'trustedHtml');
	        }
		}
		$scope.update = function(mbwForm){
			if (new validationService().checkFormValidity(mbwForm)) {
	            var flag1 = true, flag2 = true, flag3 = true, flag4 = true, flag5 = true,flag6 = true, flag7 = true, flag8 = true, flag9 = true, flag10 = true, flag11 = true, flag12 = true, flag13 = true, flag14 = true, flag15 = true;
	            if($scope.mbw.shipperAddress != null && $scope.mbw.shipperAddress != ''){
	      			 var text = $scope.mbw.shipperAddress;
	      	         text = text.replace(/\r?\n/g, '<br>');
	      	      var res = text.replace("–", "-");
	                   $scope.mbw.shipperAddress=res;
	      		}
	      		if($scope.mbw.consigneeAddress != null  && $scope.mbw.consigneeAddress != '' ){
	      			 var text1 = $scope.mbw.consigneeAddress;
	      	         text1 = text1.replace(/\r?\n/g, '<br>');
	      	      var res1 = text1.replace("–", "-");
	                   $scope.mbw.consigneeAddress=res1;
	      		}
	      		if($scope.mbw.notifyAddress != null  && $scope.mbw.notifyAddress != '' ){
	     			 var text2 = $scope.mbw.notifyAddress;
	     	         text2 = text2.replace(/\r?\n/g, '<br>');
	     	       var res2 = text2.replace("–", "-");
	                  $scope.mbw.notifyAddress=res2;
	     		}
	      		
	            
				if($scope.mbw.hbwDocDate=="" || $scope.mbw.hbwDocDate==undefined)
				{
				$scope.mbw.hbwDocDate=null
				}
			
			if($scope.mbw.mbwDocDate=="" || $scope.mbw.mbwDocDate==undefined)
			{
			$scope.mbw.mbwDocDate=null
			}
			if($scope.mbw.etaAtPod=="" || $scope.mbw.etaAtPod==undefined)
			{
			$scope.mbw.etaAtPod=null
			}
			if($scope.mbw.etd=="" || $scope.mbw.etd==undefined)
			{
			$scope.mbw.etd=null
			}
			if($scope.mbw.requestedFlightDate=="" || $scope.mbw.requestedFlightDate==undefined)
			{
			$scope.mbw.requestedFlightDate=null
			}
			if($scope.mbw.requestedFlightDate2=="" || $scope.mbw.requestedFlightDate2==undefined)
			{
			$scope.mbw.requestedFlightDate2=null
			}
			 if ($scope.mbw.tax != undefined && $scope.mbw.tax != null && $scope.mbw.tax != '') {
				 if (flag11 == true)
				 {
				 flag11 = validateDouble($scope.mbw.tax);
				 }
	         }
			 if ($scope.mbw.totalChargeAgent != undefined && $scope.mbw.totalChargeAgent != null && $scope.mbw.totalChargeAgent != '') {
				 if (flag12 == true)
				 {
				 flag12 = validateDouble($scope.mbw.totalChargeAgent);
				 }
	         }
			 if ($scope.mbw.totalChargeCarrier != undefined && $scope.mbw.totalChargeCarrier != null && $scope.mbw.totalChargeCarrier != '') {
				 if (flag13 == true)
				 {
				 flag13 = validateDouble($scope.mbw.totalChargeCarrier);
				 }
	         }
			 if ($scope.mbw.valuationCharge != undefined && $scope.mbw.valuationCharge != null && $scope.mbw.valuationCharge != '') {
				 if (flag14 == true)
				 {
				 flag14 = validateDouble($scope.mbw.valuationCharge);
				 }
	         }
			 if ($scope.mbw.amountOfInsurance != undefined && $scope.mbw.amountOfInsurance != null && $scope.mbw.amountOfInsurance != '') {
	             flag15 = validateDouble($scope.mbw.amountOfInsurance);
	         }
			for(var i=0;i<$scope.lMablContainerBean.length;i++){
				 if ($scope.lMablContainerBean[i].nofPieces != undefined && $scope.lMablContainerBean[i].nofPieces != null && $scope.lMablContainerBean[i].nofPieces != '') {
					 if (flag1 == true)
					 {
					 flag1 = validateNos($scope.lMablContainerBean[i].nofPieces);
					 }
		         }	
				 if ($scope.lMablContainerBean[i].lWH != undefined && $scope.lMablContainerBean[i].lWH != null && $scope.lMablContainerBean[i].lWH != '') {
					 if (flag2 == true)
					 {
					 flag2 = validateNos($scope.lMablContainerBean[i].lWH);
					 }
		         }
				 if ($scope.lMablContainerBean[i].netWeight != undefined && $scope.lMablContainerBean[i].netWeight != null && $scope.lMablContainerBean[i].netWeight != '') {
					 if (flag3 == true)
					 {
					 flag3 = validateDouble($scope.lMablContainerBean[i].netWeight);
					 }
					 
		         }
				 if ($scope.lMablContainerBean[i].grossWeight != undefined && $scope.lMablContainerBean[i].grossWeight != null && $scope.lMablContainerBean[i].grossWeight != '') {
					 if (flag4 == true)
					 {
					 flag4 = validateDouble($scope.lMablContainerBean[i].grossWeight);
					 }
		         }
				 if ($scope.lMablContainerBean[i].length != undefined && $scope.lMablContainerBean[i].length != null && $scope.lMablContainerBean[i].length != '') {
					 if (flag5 == true)
					 {
					 flag5 = validateDouble($scope.lMablContainerBean[i].length);
					 }
		         }	
				 if ($scope.lMablContainerBean[i].width != undefined && $scope.lMablContainerBean[i].width != null && $scope.lMablContainerBean[i].width != '') {
					 if (flag6 == true)
					 {
					 flag6 = validateDouble($scope.lMablContainerBean[i].width);
					 }
		         }
				 if ($scope.lMablContainerBean[i].height != undefined && $scope.lMablContainerBean[i].height != null && $scope.lMablContainerBean[i].height != '') {
					 if (flag7 == true)
					 {
					 flag7 = validateDouble($scope.lMablContainerBean[i].height);
					 
					 }
		         }
				 if ($scope.lMablContainerBean[i].charcheableWeight != undefined && $scope.lMablContainerBean[i].charcheableWeight != null && $scope.lMablContainerBean[i].charcheableWeight != '') {
					 if (flag8 == true)
					 {
					 flag8 = validateDouble($scope.lMablContainerBean[i].charcheableWeight);
					 }
		         }
				 if ($scope.lMablContainerBean[i].rate != undefined && $scope.lMablContainerBean[i].rate != null && $scope.lMablContainerBean[i].rate != '') {
					 if (flag9 == true)
					 {
					 flag9 = validateDouble($scope.lMablContainerBean[i].rate);
					 }
		         }	
				 if ($scope.lMablContainerBean[i].amount != undefined && $scope.lMablContainerBean[i].amount != null && $scope.lMablContainerBean[i].amount != '') {
					 if (flag10 == true)
						 {
						 flag10 = validateDouble($scope.lMablContainerBean[i].amount);

						 }
		         }
				
			}
			$scope.lMabwJobDetailBean1=[];
			for(var i=0;i<$scope.lMabwJobDetailBean.length;i++)
				{
				if($scope.lMabwJobDetailBean[i].select==true)
				$scope.lMabwJobDetailBean1.push($scope.lMabwJobDetailBean[i]);
				}
				var obj = {
						hblBean : $scope.mbw,
						lMabwContainerBean: $scope.lMablContainerBean,
						lMabwJobDetailBean:$scope.lMabwJobDetailBean1,
				}
				if($scope.lMabwJobDetailBean1.length>0)
					{
				if (flag1 == true && flag2 == true && flag2 == true && flag3 == true && flag4 == true && flag5 == true && flag6 == true && flag7== true && flag8 == true && flag9 == true && flag4 == true && flag10 == true && flag11 == true && flag12 == true && flag13 == true && flag14 == true && flag15 == true) {

	            $http.post($stateParams.tenantid+'/app/air/mabw/update',obj).success(function(data) {
	            	if(data.success){
	            		logger.logSuccess('Updated Successfully');
	            		if($scope.mbw.shipperAddress != null && $scope.mbw.shipperAddress != ''){
		           			 var text5 =$scope.mbw.shipperAddress;
		                        text5 = text5.replace(/\r?<br>/g, '\n');
		                        $scope.mbw.shipperAddress=text5;
		           		}
		           		if($scope.mbw.consigneeAddress != null  && $scope.mbw.consigneeAddress != '' ){
		           			 var text6 =$scope.mbw.consigneeAddress;
		                        text6 = text6.replace(/\r?<br>/g, '\n');
		                        $scope.mbw.consigneeAddress=text6;
		           		}
		           		if($scope.mbw.notifyAddress != null  && $scope.mbw.notifyAddress != '' ){
		          			 var text7 =$scope.mbw.notifyAddress;
		          			text7 = text7.replace(/\r?<br>/g, '\n');
		                       $scope.mbw.notifyAddress=text7;
		          		}
	            		$location.url($stateParams.tenantid+'/mabw/edit?rowid='+data.mablId);       
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
			}	
				else {
                    logger.logError("Job Details: Field is Required");

		        }
			}else {
	            toaster.pop('error', "Please fill the required fields", 
	                    logger.getErrorHtmlNew(mbwForm.$validationSummary), 5000, 'trustedHtml');
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
		 //1050
		 $scope.mawbId=servicePartnerId;
			$scope.printManifest=function(){
				    var url = $stateParams.tenantid+'/airCargoManifest/printMawbManifest?beanId='+$scope.mawbId;
			        var wnd = window.open(url, 'MANIFEST', 'height=700,width=850,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
			        wnd.print();
			}
			$scope.printHawb=function(){
			    var url = $stateParams.tenantid+'/airCargoManifest/printMAWB?beanId='+$scope.mawbId;
		        var wnd = window.open(url, 'MAWB', 'height=700,width=850,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
		        wnd.print();
			}

			 $scope.reset=function(){
		         
		         if( $scope.isEdit == false){ 
		        	 $scope.lMablContainerBean =[];
		 		    $scope.mbw = {
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
		 		    		 type:'',
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
		        	 $http.post($stateParams.tenantid+'/app/air/mabw/view?mablId='+servicePartnerId).success(function(data) {
		 	        	if(data.success){
		 	        		$scope.mbw = data.hblBean;
		 	        		$scope.lMablContainerBean=data.lMabwContainerBean;
		 	        		$scope.mbw.aol = data.hblBean.aol.toString();
		 	        		$scope.mbw.aod = data.hblBean.aod.toString();
		 	        		$scope.mbw.term = data.hblBean.term.toString();
		 	        		$scope.mbw.customer = data.hblBean.customer.toString();
		 	        		$scope.mbw.branch = data.hblBean.branch.toString();
		 	        		$scope.mbw.type = data.hblBean.type.toString();
		 	        		$scope.mbw.vendor = data.hblBean.vendor.toString();

		 	        	
		 	        		if(data.hblBean.origin!=null&&data.hblBean.origin!='')
		 	    			{
		 	        		$scope.mbw.origin = data.hblBean.origin.toString();;

		 	    			}

		 	        		if(data.hblBean.destination!=null&&data.hblBean.destination!='')
		 	    			{
		 	        		$scope.mbw.destination = data.hblBean.destination.toString();;

		 	    			}
		 	        		if(data.hblBean.salesPerson!=null&&data.hblBean.salesPerson!='')
		 	    			{
		 	        		$scope.mbw.salesPerson = data.hblBean.salesPerson.toString();;

		 	    			}
		 	    		   if(data.hblBean.shipper!=null && data.hblBean.shipper!='')
		 				   {
		 	        		$scope.hbw.shipper = data.hblBean.shipper.toString();;

		 				    }
		 	    		   if(data.hblBean.consignee!=null && data.hblBean.consignee!='')
		 				   {
		 	        		$scope.mbw.consignee = data.hblBean.consignee.toString();;

		 				    }
		 	    		  
		 	    		   if(data.hblBean.airportOfDischarge2!=null && data.hblBean.airportOfDischarge2!='')
		 				   {
		 	        		$scope.mbw.airportOfDischarge2 = data.hblBean.airportOfDischarge2.toString();;

		 				    }
		 	    		   if(data.hblBean.airportOfDischarge3!=null && data.hblBean.airportOfDischarge3!='')
		 				   {
		 	        		$scope.mbw.airportOfDischarge3 = data.hblBean.airportOfDischarge3.toString();;

		 				    }
		 	    		   if(data.hblBean.to!=null && data.hblBean.to!='')
		 				   {
		 	        		$scope.mbw.to = data.hblBean.to.toString();

		 				    }
		 	    		   
		 	    		   if(data.hblBean.otherCharge!=null && data.hblBean.otherCharge!='')
		 				   {
		 	        		$scope.mbw.otherCharge = data.hblBean.otherCharge.toString();;

		 				    }
		 	    		   if(data.hblBean.weightValuationCharge!=null && data.hblBean.weightValuationCharge!='')
		 				   {
		 	        		$scope.mbw.weightValuationCharge = data.hblBean.weightValuationCharge.toString();;

		 				    }
		 	    		   if(data.hblBean.chargesCode!=null && data.hblBean.chargesCode!='')
		 				   {
		 	        		$scope.mbw.chargesCode = data.hblBean.chargesCode.toString();;

		 				    }
		 	    		   if(data.hblBean.currency!=null && data.hblBean.currency!='')
		 				   {
		 	        		$scope.mbw.currency = data.hblBean.currency.toString();;

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
		       	      		$scope.mblList=data.mbw;
		       	      		$scope.hblList=data.hbw;
		       	      		$scope.jobList=data.airJob;
		               		$scope.otherChargesList=data.paymentList;
		               		$scope.currencyList=data.currency;
		               		$scope.iataList=data.iataList;
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
						if($scope.mbw.mbwNo!='' && $scope.mbw.mbwNo!=undefined){
					$http.post($stateParams.tenantid + '/app/air/mabw/getQuickLinkId?category='+qulkVal+'&mawbId='+$scope.mbw.mbwNo).success(function(datas) {
								if(datas.quickLinkId!=null){
									var rowid=datas.quickLinkId;
									if(qulkVal=="Job Order"){
										if(rowid!=0){
											$location.url($stateParams.tenantid+'/jobOrderAir/edit?rowid='+rowid); 
											//$window.open('#'+$stateParams.tenantid+'/jobOrderAir/view?rowid='+rowid, '_blank');
										}else{
											logger.logError("There is no "+qulkVal);
										}
									}else if(qulkVal=="HAWB"){
										if(rowid!=0){
											$location.url($stateParams.tenantid+'/hbw/edit?rowid='+rowid); 
											//$window.open('#'+$stateParams.tenantid+'/hbw/view?rowid='+rowid,'_blank');
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
											$location.url($stateParams.tenantid+'/invoice/salesinvoice/salesInvoiceView?rowid='+rowid); 
											//$window.open('#'+$stateParams.tenantid+"/invoice/salesinvoice/salesInvoiceView/"+rowid,'_blank');
										}else{
											logger.logError("There is no "+qulkVal);
										}
										
									}else if(qulkVal=="Purchase Invoice"){
										if(rowid!=0){
											$location.url($stateParams.tenantid+'/invoice/purchaseinvoice/PurchaseInvoiceView?rowid='+rowid);
											//$window.open('#'+$stateParams.tenantid+"/invoice/purchaseinvoice/PurchaseInvoiceView/"+rowid,'_blank');
										}else{
											logger.logError("There is no "+qulkVal);
										}
										
									}
								} else if(datas.quickLinkIdList!=null){var quickLinkIdList=datas.quickLinkIdList;
								if(qulkVal=="HAWB"){
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
					}else{var quickLinkIdList=datas.quickLinkIdList;
					if(qulkVal=="HAWB"){
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

app.controller('mabwViewCtrl', function($scope, $rootScope, $http, $location, logger, ngDialog,
        utilsService,$state,sharedProperties,$window,$stateParams,toaster,validationService) {

 $scope.displayedCollection = [];
var date  = new Date();
var dateString =  date.getDate() + "/" + date.getMonth() + "/" + date.getFullYear() + " " + date.getHours() + ":" + date.getMinutes();
	$scope.rowCollectionFollowup=[];
    $scope.referralList=[];
    $scope.isEdit = false;
    $scope.tairDetailList =[];
    $scope.isEdit=false;
     $scope.s1 = true;
     $scope.s2 = false;
	

    $scope.cancel = function() {
	  	  $state.go('app.air.mabw.list',{tenantid:$stateParams.tenantid});
	  	  
	          
	    };
    
	   
		    $scope.lMablContainerBean =[];
	     $scope.lMabwJobDetailBean=[];

		    $scope.mbw = {
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
		    		 type:'',
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
		    
		    $scope.tempMablContainerBean = {
					select 		:false,
					commodity:'',
					descriptionofGoods:'',
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
					rate:'',

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

			$scope.mbw.mbwDate = dd + '/' + mm + '/'
					+ yyyy;
	 //add Row
	  $scope.addCredRow = function() {
	   
		  var tmp=angular.copy($scope.tempMablContainerBean);
			$scope.lMablContainerBean.push(tmp);

	  }
	  $scope.addCredRow();

		$scope.removeCredRow =function(){
			if($scope.isEdit==false){
				var tmpDelList = [];
				for(var i=$scope.lMablContainerBean.length-1;i>=0;i--){
					if($scope.lMablContainerBean[i].select==true){
						tmpDelList.push($scope.lMablContainerBean[i]);
						$scope.lMablContainerBean.splice(i, 1);
					}
				}
				logger.logSuccess('Deleted Successfully');
			}else if($scope.isEdit==true){
				var tmpDelList = [];
				for(var i=$scope.lMablContainerBean.length-1;i>=0;i--){
					if($scope.lMablContainerBean[i].select==true){
						tmpDelList.push($scope.lMablContainerBean[i]);
					}
				}
				$http.post($stateParams.tenantid+'/app/air/mabw/deleteContainerDetail',tmpDelList).success(function(data) {
		        	if(data.success){
		        		for(var i=$scope.lMablContainerBean.length-1;i>=0;i--){
		    				if($scope.lMablContainerBean[i].select==true){
		    					$scope.lMablContainerBean.splice(i, 1);
		    				}
		    			}
		        		logger.logSuccess('Deleted Successfully');
		        	}else{
		        		logger.logError('Unable to delete');
		        	}
				})
			}
			
		}
		$scope.pod="";
		$scope.pol="";
		$scope.branch="";
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
				var mablContainerBean = $scope.lMablContainerBean;
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
					var mablContainerBean = $scope.lMablContainerBean;
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
						var mablContainerBean = $scope.lMablContainerBean;
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
							var mablContainerBean = $scope.lMablContainerBean;
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
			var k=0;
	        $http.post($stateParams.tenantid+'/app/air/mabw/view?mablId='+servicePartnerId).success(function(data) {
	        	if(data.success){
	        		$scope.jobDetail= true;
	        		$scope.mbw = data.hblBean;
	        		$scope.lMablContainerBean=data.lMabwContainerBean;
	        		if($scope.mbw.shipperAddress != null && $scope.mbw.shipperAddress != ''){
	           			 var text5 =$scope.mbw.shipperAddress;
	                        text5 = text5.replace(/\r?<br>/g, '\n');
	                        $scope.mbw.shipperAddress=text5;
	           		}
	           		if($scope.mbw.consigneeAddress != null  && $scope.mbw.consigneeAddress != '' ){
	           			 var text6 =$scope.mbw.consigneeAddress;
	                        text6 = text6.replace(/\r?<br>/g, '\n');
	                        $scope.mbw.consigneeAddress=text6;
	           		}
	           		if($scope.mbw.notifyAddress != null  && $scope.mbw.notifyAddress != '' ){
	          			 var text7 =$scope.mbw.notifyAddress;
	          			text7 = text7.replace(/\r?<br>/g, '\n');
	                       $scope.mbw.notifyAddress=text7;
	          		}
	        		for(var i=0;i<$scope.lMablContainerBean.length;i++) 
                	{
                	if($scope.lMablContainerBean[i].lWHUOM!=null&&$scope.lMablContainerBean[i].lWHUOM!='')
                		{
                		$scope.lMablContainerBean[i].lWHUOM=$scope.lMablContainerBean[i].lWHUOM.toString();

                		}
                	

                	}
	            	
	        		
	        		$scope.mbw.aol = data.hblBean.aol.toString();
	        		$scope.mbw.aod = data.hblBean.aod.toString();
	        		$scope.mbw.term = data.hblBean.term.toString();
	        		$scope.mbw.customer = data.hblBean.customer.toString();
	        		$scope.mbw.branch = data.hblBean.branch.toString();
	        		$scope.mbw.type = data.hblBean.type.toString();
	        		$scope.mbw.vendor = data.hblBean.vendor.toString();

	        		$scope.pod=data.hblBean.aod.toString();
	        		$scope.pol=data.hblBean.aol.toString();
	        		$scope.branch=data.hblBean.branch.toString();
	        		
	        		if(data.hblBean.origin!=null&&data.hblBean.origin!='')
	    			{
	        		$scope.mbw.origin = data.hblBean.origin.toString();;

	    			}

	        		if(data.hblBean.destination!=null&&data.hblBean.destination!='')
	    			{
	        		$scope.mbw.destination = data.hblBean.destination.toString();;

	    			}
	        		if(data.hblBean.salesPerson!=null&&data.hblBean.salesPerson!='')
	    			{
	        		$scope.mbw.salesPerson = data.hblBean.salesPerson.toString();;

	    			}
	    		   if(data.hblBean.shipper!=null && data.hblBean.shipper!='')
				   {
	        		$scope.hbw.shipper = data.hblBean.shipper.toString();;

				    }
	    		   if(data.hblBean.consignee!=null && data.hblBean.consignee!='')
				   {
	        		$scope.mbw.consignee = data.hblBean.consignee.toString();;

				    }
	    		  
	    		   if(data.hblBean.airportOfDischarge2!=null && data.hblBean.airportOfDischarge2!='')
				   {
	        		$scope.mbw.airportOfDischarge2 = data.hblBean.airportOfDischarge2.toString();;

				    }
	    		   else
    			   {
	        		$scope.mbw.airportOfDischarge2 ='';

    			   }
	    		   if(data.hblBean.airportOfDischarge3!=null && data.hblBean.airportOfDischarge3!='')
				   {
	        		$scope.mbw.airportOfDischarge3 = data.hblBean.airportOfDischarge3.toString();;

				    }
	    		   else
    			   {
	        		$scope.mbw.airportOfDischarge3 ='';

    			   }
	    		   if(data.hblBean.to!=null && data.hblBean.to!='')
				   {
	        		$scope.mbw.to = data.hblBean.to.toString();;

				    }
	    		   else
	    			   {
 	        		$scope.mbw.to ='';

	    			   }
	    		  
	    		  
	    		   if(data.hblBean.otherCharge!=null && data.hblBean.otherCharge!='')
				   {
	        		$scope.mbw.otherCharge = data.hblBean.otherCharge.toString();;

				    }
	    		   if(data.hblBean.weightValuationCharge!=null && data.hblBean.weightValuationCharge!='')
				   {
	        		$scope.mbw.weightValuationCharge = data.hblBean.weightValuationCharge.toString();;

				    }
	    		   else
    			   {
	        		$scope.mbw.weightValuationCharge ='';

    			   }
	    		   if(data.hblBean.chargesCode!=null && data.hblBean.chargesCode!='')
				   {
	        		$scope.mbw.chargesCode = data.hblBean.chargesCode.toString();;

				    }
	    		   if(data.hblBean.currency!=null && data.hblBean.currency!='')
				   {
	        		$scope.mbw.currency = data.hblBean.currency.toString();;

				    }
	    		   else
	    			   {
 	        		$scope.mbw.currency ='';

	    			   }
	    		  
	    		   $scope.totalPackageCalculation();
	    		   $scope.totalnetWeightCalculation();
	    		   $scope.totalgrossWeightCalculation();
	    		   $scope.totalamountCalculation();
	    		   if(data.lMabwJobDetailBean.length!=0){
	        			 $scope.jobDetail= true;
			          	 $scope.s1 = false;
	        			$scope.lMabwJobDetailBean=data.lMabwJobDetailBean;
			          /* $scope.$watchCollection('[mbw.branch,mbw.aol,mbw.aod]', function(newValue, oldValue) {
					       {

					    	   $scope.branchData= $scope.mbw.branch;
					    	   $scope.polData= $scope.mbw.aol;
					    	   $scope.podData= $scope.mbw.aod;
					    	   if($scope.isEdit==true || $scope.podData!=$scope.pod || $scope.polData!=$scope.pol || $scope.branchData!=$scope.branch)
					    		   {
					    	   if($scope.mbw.branch!=undefined && $scope.mbw.branch!=null && $scope.mbw.branch!="" && $scope.mbw.aol!=undefined && $scope.mbw.aol!=null && $scope.mbw.aol!="" && $scope.mbw.aod!=undefined && $scope.mbw.aod!=null && $scope.mbw.aod!="" && ($scope.isEdit==false || k<=0))
					    		   {
					    	       $scope.lMbwJobDetailBean=[];
					    	       k++;

					   	        $http.post($stateParams.tenantid+'/app/air/mabw/getJobDetail?branchId='+$scope.branchData+'&pol='+$scope.polData+'&pod='+$scope.podData).success(function(data) {
					   	         if(data.success==true)
				            	 {
				            	 if(data.lMabwJobDetailBean.length !=0){
				            	 
				          	   $scope.jobDetail= true;
				          	 $scope.s1 = false;

				            	 $scope.lMabwJobDetailBean=data.lMabwJobDetailBean;
				            	 }else{
				            		 
				            		 $scope.jobDetail= false;
				            		 $scope.s1 = false;
				            		
				            		 $scope.t1=data.s1;
				            		 $scope.t2=data.s2;
				            		 $scope.t3=data.s3;
				            	 }
				            	 }
					   	        })
					    		   
					    	}
					    		   }
					       }
					       })*/
					       
	        			
	        		}else{
	        			$scope.s2 = true;
	        			$scope.s1 = false;
	        			//$scope.jobDetail= false;
	        			
	        		}/*else{
	        			 $scope.jobDetail= false;
	        			 $scope.$watchCollection('[mbw.branch,mbw.aol,mbw.aod]', function(newValue, oldValue) {
	  					       {

	  					    	   $scope.branchData= $scope.mbw.branch;
	  					    	   $scope.polData= $scope.mbw.aol;
	  					    	   $scope.podData= $scope.mbw.aod;
	  					    	 $scope.lMabwJobDetailBean=data.lMabwJobDetailBean;
	  					    	   if($scope.isEdit==false || $scope.podData!=$scope.pod || $scope.polData!=$scope.pol || $scope.branchData!=$scope.branch)
	  					    		   {
	  					    	   if($scope.mbw.branch!=undefined && $scope.mbw.branch!=null && $scope.mbw.branch!="" && $scope.mbw.aol!=undefined && $scope.mbw.aol!=null && $scope.mbw.aol!="" && $scope.mbw.aod!=undefined && $scope.mbw.aod!=null && $scope.mbw.aod!="")
	  					    		   {
	  					    	       $scope.lMbwJobDetailBean=[];

	  					   	        $http.post($stateParams.tenantid+'/app/air/mabw/getJobDetail?branchId='+$scope.branchData+'&pol='+$scope.polData+'&pod='+$scope.podData).success(function(data) {
	  					   	         if(data.success==true)
	  				            	 {
	  				            	 if(data.lMabwJobDetailBean.length !=0){
	  				            	 
	  				          	   $scope.jobDetail= true;
	  				          	 $scope.s1 = false;

	  				            	 $scope.lMabwJobDetailBean=data.lMabwJobDetailBean;
	  				            	 }else{
	  				            		 
	  				            		 $scope.jobDetail= false;
	  				            		 $scope.s1 = false;
	  				            		
	  				            		 $scope.t1=data.s1;
	  				            		 $scope.t2=data.s2;
	  				            		 $scope.t3=data.s3;
	  				            	 }
	  				            	 }
	  					   	        })
	  					    		   
	  					    	}
	  					    		   }
	  					       }
	  					       })
	        		}*/

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
      	      		$scope.mblList=data.mbw;
      	      		$scope.hblList=data.hbw;
      	      		$scope.jobList=data.airJob;
              		$scope.otherChargesList=data.paymentList;
              		$scope.currencyList=data.currency;
              		$scope.iataList=data.iataList;
              		$scope.iataListDetail=data.iataListDetail;

      	          	
      	          });	
	        	
	        	}else{
	        		logger.logError("Unable to fetch data");
	        	}
	        });
		}
		  $scope.viewQuotation = function(jobNo) {
				debugger
					$location.url($stateParams.tenantid+'/jobOrderAir/view?rowid='+jobNo);
				
			}
		
		   $scope.$watchCollection('[mbw.branch,mbw.aol,mbw.aod]', function(newValue, oldValue) {
		       {

		    	   $scope.branchData= $scope.mbw.branch;
		    	   $scope.polData= $scope.mbw.aol;
		    	   $scope.podData= $scope.mbw.aod;
		    	   if($scope.isEdit==false || $scope.podData!=$scope.pod || $scope.polData!=$scope.pol || $scope.branchData!=$scope.branch)
		    		   {
		    	   if($scope.mbw.branch!=undefined && $scope.mbw.branch!=null && $scope.mbw.branch!="" && $scope.mbw.aol!=undefined && $scope.mbw.aol!=null && $scope.mbw.aol!="" && $scope.mbw.aod!=undefined && $scope.mbw.aod!=null && $scope.mbw.aod!="")
		    		   {
		    	       $scope.lMbwJobDetailBean=[];

		   	        $http.post($stateParams.tenantid+'/app/air/mabw/getJobDetail?branchId='+$scope.branchData+'&pol='+$scope.polData+'&pod='+$scope.podData).success(function(data) {
		   	         if(data.success==true)
	            	 {
	            	 if(data.lMabwJobDetailBean.length !=0){
	            	 
	          	   $scope.jobDetail= true;
	          	 $scope.s1 = false;

	            	 $scope.lMabwJobDetailBean=data.lMabwJobDetailBean;
	            	 }else{
	            		 
	            		 $scope.lMablContainerBean='';
	            		 $scope.jobDetail= false;
	            		 $scope.s1 = false;
	            		
	            		 $scope.t1=data.s1;
	            		 $scope.t2=data.s2;
	            		 $scope.t3=data.s3;
	            	 }
	            	 }
		   	        })
		    		   
		    	}
		    		   }
		       }
		       })
		       
		      $scope.container = function(select,index)
		         {

		    	for (var i= $scope.lMabwJobDetailBean.length-1;i>=0;i--)
		    		{
		    		var jobNo = $scope.lMabwJobDetailBean[i].jobNo;
		    		if($scope.lMabwJobDetailBean[i].select==true)
		    			{
	    	  			$http.post($stateParams.tenantid+'/app/air/mabw/getcontlist',$scope.lMabwJobDetailBean).success(function(data) {
	 	            	if(data.success){
	 	            		console.log(data.lMabwContainerBean);
	 	            		$scope.lMablContainerBean=data.lMabwContainerBean;
	 	            		if(data.lMabwBean[0].vendor != '' && data.lMabwBean[0].vendor != null){
	 	            			$scope.mbw.vendor =data.lMabwBean[0].vendor.toString();
	 	            		}
	 	            		if(data.lMabwBean[0].destination != '' && data.lMabwBean[0].destination != null){
	 	            			$scope.mbw.destination =data.lMabwBean[0].destination.toString();
	 	            		}
	 	            		if(data.lMabwBean[0].origin != '' && data.lMabwBean[0].origin != null){
	 	            			$scope.mbw.origin =data.lMabwBean[0].origin.toString();
	 	            		}
	 	            		if(data.lMabwBean[0].term != '' && data.lMabwBean[0].term != null){
	 	            			$scope.mbw.term =data.lMabwBean[0].term.toString();
	 	            		}
	 	            		$scope.mbw.airportOfDepature =data.lMabwBean[0].airportOfDepature;
	 	            		$scope.mbw.airportOfDestination =data.lMabwBean[0].airportOfDestination;
	 	            		$scope.mbw.byFirstCarrier =data.lMabwBean[0].byFirstCarrier;
	 	            		$scope.mbw.shipperAddress =data.lMabwBean[0].shipperAddress;
	 	            		$scope.mbw.consigneeAddress =data.lMabwBean[0].consigneeAddress;
	 	            		$scope.mbw.notifyAddress =data.lMabwBean[0].notifyAddress;
	 	            		if(data.lMabwBean[0].toDepature!= null &&  data.lMabwBean[0].toDepature!= undefined)
	 	            			{
	 	            		$scope.mbw.to =data.lMabwBean[0].toDepature.toString();
	 	            			}
	 	            		for(var i=0;i<$scope.lMablContainerBean.length;i++) 
	 	                	{
	 	                	if($scope.lMablContainerBean[i].lWHUOM!=null&&$scope.lMablContainerBean[i].lWHUOM!='')
	 	                		{
	 	                		$scope.lMablContainerBean[i].lWHUOM=$scope.lMablContainerBean[i].lWHUOM.toString();

	 	                		}
	 	                	}
	 	            	
	 	            		}
	    	  			});
	    	
		         }
		    		else
		    			{
		    			$scope.lMablContainerBean='';
 	            		$scope.mbw.airportOfDepature ='';
 	            		$scope.mbw.airportOfDestination ='';
 	            		$scope.mbw.byFirstCarrier ='';
 	            		$scope.mbw.shipperAddress ='';
 	            		$scope.mbw.consigneeAddress ='';
 	            		$scope.mbw.notifyAddress ='';
 	            		$scope.mbw.to='';
		    			}
		         }
		         }

		       
		
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
      	      		$scope.mblList=data.mbw;
      	      		$scope.hblList=data.hbw;
      	      		$scope.jobList=data.airJob;
              		$scope.otherChargesList=data.paymentList;
              		$scope.currencyList=data.currency;
              		$scope.iataList=data.iataList;
              		$scope.iataListDetail=data.iataListDetail;

	          	
	          });
		  $http.get(
					$stateParams.tenantid
							+ '/app/airquotation/getuomList')
					.success(function(datas) {
						$scope.uomList = datas.commonUtilityBean;

					}).error(function(data) {

					});
		$scope.save = function(mbwForm){
			if (new validationService().checkFormValidity(mbwForm)) {
	            var flag1 = true, flag2 = true, flag3 = true, flag4 = true, flag5 = true,flag6 = true, flag7 = true, flag8 = true, flag9 = true, flag10 = true, flag11 = true, flag12 = true, flag13 = true, flag14 = true, flag15 = true;

				if($scope.mbw.hbwDocDate=="" || $scope.mbw.hbwDocDate==undefined)
				{
				$scope.mbw.hbwDocDate=null
				}
			
			if($scope.mbw.mbwDocDate=="" || $scope.mbw.mbwDocDate==undefined)
			{
			$scope.mbw.mbwDocDate=null
			}
			if($scope.mbw.etaAtPod=="" || $scope.mbw.etaAtPod==undefined)
			{
			$scope.mbw.etaAtPod=null
			}
			if($scope.mbw.etd=="" || $scope.mbw.etd==undefined)
			{
			$scope.mbw.etd=null
			}
			if($scope.mbw.requestedFlightDate=="" || $scope.mbw.requestedFlightDate==undefined)
			{
			$scope.mbw.requestedFlightDate=null
			}
			if($scope.mbw.requestedFlightDate2=="" || $scope.mbw.requestedFlightDate2==undefined)
			{
			$scope.mbw.requestedFlightDate2=null
			}
			if($scope.mbw.shipperAddress != null && $scope.mbw.shipperAddress != ''){
				 var text = $scope.mbw.shipperAddress;
		         text = text.replace(/\r?\n/g, '<br>');
		         var res = text.replace("–", "-");
	             $scope.mbw.shipperAddress=res;
			}
			if($scope.mbw.consigneeAddress != null  && $scope.mbw.consigneeAddress != '' ){
				 var text1 = $scope.mbw.consigneeAddress;
		         text1 = text1.replace(/\r?\n/g, '<br>');
		         var res1 = text1.replace("–", "-");
	             $scope.mbw.consigneeAddress=res1;
			}
			if($scope.mbw.notifyAddress != null  && $scope.mbw.notifyAddress != '' ){
				 var text2 = $scope.mbw.notifyAddress;
		         text2 = text2.replace(/\r?\n/g, '<br>');
		         var res2 = text2.replace("–", "-");
	            $scope.mbw.notifyAddress=res2;
			}
			if ($scope.mbw.tax != undefined && $scope.mbw.tax != null && $scope.mbw.tax != '') {
				 if (flag11 == true)
				 {
				 flag11 = validateDouble($scope.mbw.tax);
				 }
	         }
			 if ($scope.mbw.totalChargeAgent != undefined && $scope.mbw.totalChargeAgent != null && $scope.mbw.totalChargeAgent != '') {
				 if (flag12 == true)
				 {
				 flag12 = validateDouble($scope.mbw.totalChargeAgent);
				 }
	         }
			 if ($scope.mbw.totalChargeCarrier != undefined && $scope.mbw.totalChargeCarrier != null && $scope.mbw.totalChargeCarrier != '') {
				 if (flag13 == true)
				 {
				 flag13 = validateDouble($scope.mbw.totalChargeCarrier);
				 }
	         }
			 if ($scope.mbw.valuationCharge != undefined && $scope.mbw.valuationCharge != null && $scope.mbw.valuationCharge != '') {
				 if (flag14 == true)
				 {
				 flag14 = validateDouble($scope.mbw.valuationCharge);
				 }
	         }
			 if ($scope.mbw.amountOfInsurance != undefined && $scope.mbw.amountOfInsurance != null && $scope.mbw.amountOfInsurance != '') {
	             flag15 = validateDouble($scope.mbw.amountOfInsurance);
	         }
			for(var i=0;i<$scope.lMablContainerBean.length;i++){
				 if ($scope.lMablContainerBean[i].nofPieces != undefined && $scope.lMablContainerBean[i].nofPieces != null && $scope.lMablContainerBean[i].nofPieces != '') {
					 if (flag1 == true)
					 {
					 flag1 = validateNos($scope.lMablContainerBean[i].nofPieces);
					 }
		         }	
				 if ($scope.lMablContainerBean[i].lWH != undefined && $scope.lMablContainerBean[i].lWH != null && $scope.lMablContainerBean[i].lWH != '') {
					 if (flag2 == true)
					 {
					 flag2 = validateNos($scope.lMablContainerBean[i].lWH);
					 }
		         }
				 if ($scope.lMablContainerBean[i].netWeight != undefined && $scope.lMablContainerBean[i].netWeight != null && $scope.lMablContainerBean[i].netWeight != '') {
					 if (flag3 == true)
					 {
					 flag3 = validateDouble($scope.lMablContainerBean[i].netWeight);
					 }
					 
		         }
				 if ($scope.lMablContainerBean[i].grossWeight != undefined && $scope.lMablContainerBean[i].grossWeight != null && $scope.lMablContainerBean[i].grossWeight != '') {
					 if (flag4 == true)
					 {
					 flag4 = validateDouble($scope.lMablContainerBean[i].grossWeight);
					 }
		         }
				 if ($scope.lMablContainerBean[i].length != undefined && $scope.lMablContainerBean[i].length != null && $scope.lMablContainerBean[i].length != '') {
					 if (flag5 == true)
					 {
					 flag5 = validateDouble($scope.lMablContainerBean[i].length);
					 }
		         }	
				 if ($scope.lMablContainerBean[i].width != undefined && $scope.lMablContainerBean[i].width != null && $scope.lMablContainerBean[i].width != '') {
					 if (flag6 == true)
					 {
					 flag6 = validateDouble($scope.lMablContainerBean[i].width);
					 }
		         }
				 if ($scope.lMablContainerBean[i].height != undefined && $scope.lMablContainerBean[i].height != null && $scope.lMablContainerBean[i].height != '') {
					 if (flag7 == true)
					 {
					 flag7 = validateDouble($scope.lMablContainerBean[i].height);
					 
					 }
		         }
				 if ($scope.lMablContainerBean[i].charcheableWeight != undefined && $scope.lMablContainerBean[i].charcheableWeight != null && $scope.lMablContainerBean[i].charcheableWeight != '') {
					 if (flag8 == true)
					 {
					 flag8 = validateDouble($scope.lMablContainerBean[i].charcheableWeight);
					 }
		         }
				 if ($scope.lMablContainerBean[i].rate != undefined && $scope.lMablContainerBean[i].rate != null && $scope.lMablContainerBean[i].rate != '') {
					 if (flag9 == true)
					 {
					 flag9 = validateDouble($scope.lMablContainerBean[i].rate);
					 }
		         }	
				 if ($scope.lMablContainerBean[i].amount != undefined && $scope.lMablContainerBean[i].amount != null && $scope.lMablContainerBean[i].amount != '') {
					 if (flag10 == true)
						 {
						 flag10 = validateDouble($scope.lMablContainerBean[i].amount);

						 }
		         }
				
			}
			$scope.lMabwJobDetailBean1=[];
			for(var i=0;i<$scope.lMabwJobDetailBean.length;i++)
				{
				if($scope.lMabwJobDetailBean[i].select==true)
				$scope.lMabwJobDetailBean1.push($scope.lMabwJobDetailBean[i]);
				}
				var obj = {
						hblBean : $scope.mbw,
						lMabwContainerBean: $scope.lMablContainerBean,
						lMabwJobDetailBean:$scope.lMabwJobDetailBean1,
				}
				if($scope.lMabwJobDetailBean1.length>0)
					{
				if (flag1 == true && flag2 == true && flag2 == true && flag3 == true && flag4 == true && flag5 == true && flag6 == true && flag7== true && flag8 == true && flag9 == true && flag4 == true && flag10 == true && flag11 == true && flag12 == true && flag13 == true && flag14 == true && flag15 == true) {

	            $http.post($stateParams.tenantid+'/app/air/mabw/save',obj).success(function(data) {
	            	if(data.success){
	            		logger.logSuccess('Saved Successfully');
	            		$location.url($stateParams.tenantid+'/mabw/edit?rowid='+data.mablId);       
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
			}
				else
					{
                    logger.logError("Job Details: Field is Required");

					}
			}else {
	            toaster.pop('error', "Please fill the required fields", 
	                    logger.getErrorHtmlNew(mbwForm.$validationSummary), 5000, 'trustedHtml');
	        }
		}
		$scope.update = function(mbwForm){
			if (new validationService().checkFormValidity(mbwForm)) {
	            var flag1 = true, flag2 = true, flag3 = true, flag4 = true, flag5 = true,flag6 = true, flag7 = true, flag8 = true, flag9 = true, flag10 = true, flag11 = true, flag12 = true, flag13 = true, flag14 = true, flag15 = true;
	            if($scope.mbw.shipperAddress != null && $scope.mbw.shipperAddress != ''){
	      			 var text = $scope.mbw.shipperAddress;
	      	         text = text.replace(/\r?\n/g, '<br>');
	      	      var res = text.replace("–", "-");
	                   $scope.mbw.shipperAddress=res;
	      		}
	      		if($scope.mbw.consigneeAddress != null  && $scope.mbw.consigneeAddress != '' ){
	      			 var text1 = $scope.mbw.consigneeAddress;
	      	         text1 = text1.replace(/\r?\n/g, '<br>');
	      	      var res1 = text1.replace("–", "-");
	                   $scope.mbw.consigneeAddress=res1;
	      		}
	      		if($scope.mbw.notifyAddress != null  && $scope.mbw.notifyAddress != '' ){
	     			 var text2 = $scope.mbw.notifyAddress;
	     	         text2 = text2.replace(/\r?\n/g, '<br>');
	     	       var res2 = text2.replace("–", "-");
	                  $scope.mbw.notifyAddress=res2;
	     		}
	      		
	            
				if($scope.mbw.hbwDocDate=="" || $scope.mbw.hbwDocDate==undefined)
				{
				$scope.mbw.hbwDocDate=null
				}
			
			if($scope.mbw.mbwDocDate=="" || $scope.mbw.mbwDocDate==undefined)
			{
			$scope.mbw.mbwDocDate=null
			}
			if($scope.mbw.etaAtPod=="" || $scope.mbw.etaAtPod==undefined)
			{
			$scope.mbw.etaAtPod=null
			}
			if($scope.mbw.etd=="" || $scope.mbw.etd==undefined)
			{
			$scope.mbw.etd=null
			}
			if($scope.mbw.requestedFlightDate=="" || $scope.mbw.requestedFlightDate==undefined)
			{
			$scope.mbw.requestedFlightDate=null
			}
			if($scope.mbw.requestedFlightDate2=="" || $scope.mbw.requestedFlightDate2==undefined)
			{
			$scope.mbw.requestedFlightDate2=null
			}
			 if ($scope.mbw.tax != undefined && $scope.mbw.tax != null && $scope.mbw.tax != '') {
				 if (flag11 == true)
				 {
				 flag11 = validateDouble($scope.mbw.tax);
				 }
	         }
			 if ($scope.mbw.totalChargeAgent != undefined && $scope.mbw.totalChargeAgent != null && $scope.mbw.totalChargeAgent != '') {
				 if (flag12 == true)
				 {
				 flag12 = validateDouble($scope.mbw.totalChargeAgent);
				 }
	         }
			 if ($scope.mbw.totalChargeCarrier != undefined && $scope.mbw.totalChargeCarrier != null && $scope.mbw.totalChargeCarrier != '') {
				 if (flag13 == true)
				 {
				 flag13 = validateDouble($scope.mbw.totalChargeCarrier);
				 }
	         }
			 if ($scope.mbw.valuationCharge != undefined && $scope.mbw.valuationCharge != null && $scope.mbw.valuationCharge != '') {
				 if (flag14 == true)
				 {
				 flag14 = validateDouble($scope.mbw.valuationCharge);
				 }
	         }
			 if ($scope.mbw.amountOfInsurance != undefined && $scope.mbw.amountOfInsurance != null && $scope.mbw.amountOfInsurance != '') {
	             flag15 = validateDouble($scope.mbw.amountOfInsurance);
	         }
			for(var i=0;i<$scope.lMablContainerBean.length;i++){
				 if ($scope.lMablContainerBean[i].nofPieces != undefined && $scope.lMablContainerBean[i].nofPieces != null && $scope.lMablContainerBean[i].nofPieces != '') {
					 if (flag1 == true)
					 {
					 flag1 = validateNos($scope.lMablContainerBean[i].nofPieces);
					 }
		         }	
				 if ($scope.lMablContainerBean[i].lWH != undefined && $scope.lMablContainerBean[i].lWH != null && $scope.lMablContainerBean[i].lWH != '') {
					 if (flag2 == true)
					 {
					 flag2 = validateNos($scope.lMablContainerBean[i].lWH);
					 }
		         }
				 if ($scope.lMablContainerBean[i].netWeight != undefined && $scope.lMablContainerBean[i].netWeight != null && $scope.lMablContainerBean[i].netWeight != '') {
					 if (flag3 == true)
					 {
					 flag3 = validateDouble($scope.lMablContainerBean[i].netWeight);
					 }
					 
		         }
				 if ($scope.lMablContainerBean[i].grossWeight != undefined && $scope.lMablContainerBean[i].grossWeight != null && $scope.lMablContainerBean[i].grossWeight != '') {
					 if (flag4 == true)
					 {
					 flag4 = validateDouble($scope.lMablContainerBean[i].grossWeight);
					 }
		         }
				 if ($scope.lMablContainerBean[i].length != undefined && $scope.lMablContainerBean[i].length != null && $scope.lMablContainerBean[i].length != '') {
					 if (flag5 == true)
					 {
					 flag5 = validateDouble($scope.lMablContainerBean[i].length);
					 }
		         }	
				 if ($scope.lMablContainerBean[i].width != undefined && $scope.lMablContainerBean[i].width != null && $scope.lMablContainerBean[i].width != '') {
					 if (flag6 == true)
					 {
					 flag6 = validateDouble($scope.lMablContainerBean[i].width);
					 }
		         }
				 if ($scope.lMablContainerBean[i].height != undefined && $scope.lMablContainerBean[i].height != null && $scope.lMablContainerBean[i].height != '') {
					 if (flag7 == true)
					 {
					 flag7 = validateDouble($scope.lMablContainerBean[i].height);
					 
					 }
		         }
				 if ($scope.lMablContainerBean[i].charcheableWeight != undefined && $scope.lMablContainerBean[i].charcheableWeight != null && $scope.lMablContainerBean[i].charcheableWeight != '') {
					 if (flag8 == true)
					 {
					 flag8 = validateDouble($scope.lMablContainerBean[i].charcheableWeight);
					 }
		         }
				 if ($scope.lMablContainerBean[i].rate != undefined && $scope.lMablContainerBean[i].rate != null && $scope.lMablContainerBean[i].rate != '') {
					 if (flag9 == true)
					 {
					 flag9 = validateDouble($scope.lMablContainerBean[i].rate);
					 }
		         }	
				 if ($scope.lMablContainerBean[i].amount != undefined && $scope.lMablContainerBean[i].amount != null && $scope.lMablContainerBean[i].amount != '') {
					 if (flag10 == true)
						 {
						 flag10 = validateDouble($scope.lMablContainerBean[i].amount);

						 }
		         }
				
			}
			$scope.lMabwJobDetailBean1=[];
			for(var i=0;i<$scope.lMabwJobDetailBean.length;i++)
				{
				if($scope.lMabwJobDetailBean[i].select==true)
				$scope.lMabwJobDetailBean1.push($scope.lMabwJobDetailBean[i]);
				}
				var obj = {
						hblBean : $scope.mbw,
						lMabwContainerBean: $scope.lMablContainerBean,
						lMabwJobDetailBean:$scope.lMabwJobDetailBean1,
				}
				if($scope.lMabwJobDetailBean1.length>0)
					{
				if (flag1 == true && flag2 == true && flag2 == true && flag3 == true && flag4 == true && flag5 == true && flag6 == true && flag7== true && flag8 == true && flag9 == true && flag4 == true && flag10 == true && flag11 == true && flag12 == true && flag13 == true && flag14 == true && flag15 == true) {

	            $http.post($stateParams.tenantid+'/app/air/mabw/update',obj).success(function(data) {
	            	if(data.success){
	            		logger.logSuccess('Updated Successfully');
	            		if($scope.mbw.shipperAddress != null && $scope.mbw.shipperAddress != ''){
		           			 var text5 =$scope.mbw.shipperAddress;
		                        text5 = text5.replace(/\r?<br>/g, '\n');
		                        $scope.mbw.shipperAddress=text5;
		           		}
		           		if($scope.mbw.consigneeAddress != null  && $scope.mbw.consigneeAddress != '' ){
		           			 var text6 =$scope.mbw.consigneeAddress;
		                        text6 = text6.replace(/\r?<br>/g, '\n');
		                        $scope.mbw.consigneeAddress=text6;
		           		}
		           		if($scope.mbw.notifyAddress != null  && $scope.mbw.notifyAddress != '' ){
		          			 var text7 =$scope.mbw.notifyAddress;
		          			text7 = text7.replace(/\r?<br>/g, '\n');
		                       $scope.mbw.notifyAddress=text7;
		          		}
	            		$location.url($stateParams.tenantid+'/mabw/edit?rowid='+data.mablId);       
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
			}	
				else {
                    logger.logError("Job Details: Field is Required");

		        }
			}else {
	            toaster.pop('error', "Please fill the required fields", 
	                    logger.getErrorHtmlNew(mbwForm.$validationSummary), 5000, 'trustedHtml');
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
		 //1050
		 $scope.mawbId=servicePartnerId;
			$scope.printManifest=function(){
				    var url = $stateParams.tenantid+'/airCargoManifest/printMawbManifest?beanId='+$scope.mawbId;
			        var wnd = window.open(url, 'MANIFEST', 'height=700,width=850,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
			        wnd.print();
			}
			$scope.printHawb=function(){
			    var url = $stateParams.tenantid+'/airCargoManifest/printMAWB?beanId='+$scope.mawbId;
		        var wnd = window.open(url, 'MAWB', 'height=700,width=850,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
		        wnd.print();
			}

			 $scope.reset=function(){
		         
		         if( $scope.isEdit == false){ 
		        	 $scope.lMablContainerBean =[];
		 		    $scope.mbw = {
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
		 		    		 type:'',
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
		        	 $http.post($stateParams.tenantid+'/app/air/mabw/edit?mablId='+servicePartnerId).success(function(data) {
		 	        	if(data.success){
		 	        		$scope.mbw = data.hblBean;
		 	        		$scope.lMablContainerBean=data.lMabwContainerBean;
		 	        		$scope.mbw.aol = data.hblBean.aol.toString();
		 	        		$scope.mbw.aod = data.hblBean.aod.toString();
		 	        		$scope.mbw.term = data.hblBean.term.toString();
		 	        		$scope.mbw.customer = data.hblBean.customer.toString();
		 	        		$scope.mbw.branch = data.hblBean.branch.toString();
		 	        		$scope.mbw.type = data.hblBean.type.toString();
		 	        		$scope.mbw.vendor = data.hblBean.vendor.toString();

		 	        	
		 	        		if(data.hblBean.origin!=null&&data.hblBean.origin!='')
		 	    			{
		 	        		$scope.mbw.origin = data.hblBean.origin.toString();;

		 	    			}

		 	        		if(data.hblBean.destination!=null&&data.hblBean.destination!='')
		 	    			{
		 	        		$scope.mbw.destination = data.hblBean.destination.toString();;

		 	    			}
		 	        		if(data.hblBean.salesPerson!=null&&data.hblBean.salesPerson!='')
		 	    			{
		 	        		$scope.mbw.salesPerson = data.hblBean.salesPerson.toString();;

		 	    			}
		 	    		   if(data.hblBean.shipper!=null && data.hblBean.shipper!='')
		 				   {
		 	        		$scope.hbw.shipper = data.hblBean.shipper.toString();;

		 				    }
		 	    		   if(data.hblBean.consignee!=null && data.hblBean.consignee!='')
		 				   {
		 	        		$scope.mbw.consignee = data.hblBean.consignee.toString();;

		 				    }
		 	    		  
		 	    		   if(data.hblBean.airportOfDischarge2!=null && data.hblBean.airportOfDischarge2!='')
		 				   {
		 	        		$scope.mbw.airportOfDischarge2 = data.hblBean.airportOfDischarge2.toString();;

		 				    }
		 	    		   if(data.hblBean.airportOfDischarge3!=null && data.hblBean.airportOfDischarge3!='')
		 				   {
		 	        		$scope.mbw.airportOfDischarge3 = data.hblBean.airportOfDischarge3.toString();;

		 				    }
		 	    		   if(data.hblBean.to!=null && data.hblBean.to!='')
		 				   {
		 	        		$scope.mbw.to = data.hblBean.to.toString();

		 				    }
		 	    		   
		 	    		   if(data.hblBean.otherCharge!=null && data.hblBean.otherCharge!='')
		 				   {
		 	        		$scope.mbw.otherCharge = data.hblBean.otherCharge.toString();;

		 				    }
		 	    		   if(data.hblBean.weightValuationCharge!=null && data.hblBean.weightValuationCharge!='')
		 				   {
		 	        		$scope.mbw.weightValuationCharge = data.hblBean.weightValuationCharge.toString();;

		 				    }
		 	    		   if(data.hblBean.chargesCode!=null && data.hblBean.chargesCode!='')
		 				   {
		 	        		$scope.mbw.chargesCode = data.hblBean.chargesCode.toString();;

		 				    }
		 	    		   if(data.hblBean.currency!=null && data.hblBean.currency!='')
		 				   {
		 	        		$scope.mbw.currency = data.hblBean.currency.toString();;

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
		       	      		$scope.mblList=data.mbw;
		       	      		$scope.hblList=data.hbw;
		       	      		$scope.jobList=data.airJob;
		               		$scope.otherChargesList=data.paymentList;
		               		$scope.currencyList=data.currency;
		               		$scope.iataList=data.iataList;
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
						if($scope.mbw.mbwNo!='' && $scope.mbw.mbwNo!=undefined){
					$http.post($stateParams.tenantid + '/app/air/mabw/getQuickLinkId?category='+qulkVal+'&mawbId='+$scope.mbw.mbwNo).success(function(datas) {
								if(datas.quickLinkId!=null){
									var rowid=datas.quickLinkId;
									if(qulkVal=="Job Order"){
										if(rowid!=0){
											$location.url($stateParams.tenantid+'/jobOrderAir/edit?rowid='+rowid); 
											//$window.open('#'+$stateParams.tenantid+'/jobOrderAir/view?rowid='+rowid, '_blank');
										}else{
											logger.logError("There is no "+qulkVal);
										}
									}else if(qulkVal=="HAWB"){
										if(rowid!=0){
											$location.url($stateParams.tenantid+'/hbw/edit?rowid='+rowid); 
											//$window.open('#'+$stateParams.tenantid+'/hbw/view?rowid='+rowid,'_blank');
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
											$location.url($stateParams.tenantid+'/invoice/salesinvoice/salesInvoiceView?rowid='+rowid); 
											//$window.open('#'+$stateParams.tenantid+"/invoice/salesinvoice/salesInvoiceView/"+rowid,'_blank');
										}else{
											logger.logError("There is no "+qulkVal);
										}
										
									}else if(qulkVal=="Purchase Invoice"){
										if(rowid!=0){
											$location.url($stateParams.tenantid+'/invoice/purchaseinvoice/PurchaseInvoiceView?rowid='+rowid);
											//$window.open('#'+$stateParams.tenantid+"/invoice/purchaseinvoice/PurchaseInvoiceView/"+rowid,'_blank');
										}else{
											logger.logError("There is no "+qulkVal);
										}
										
									}
								} else if(datas.quickLinkIdList!=null){var quickLinkIdList=datas.quickLinkIdList;
								if(qulkVal=="HAWB"){
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
					}else{var quickLinkIdList=datas.quickLinkIdList;
					if(qulkVal=="HAWB"){
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
