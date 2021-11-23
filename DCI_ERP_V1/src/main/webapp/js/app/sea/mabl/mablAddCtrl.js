'use strict';

app.controller('mablAddCtrl', function($scope, $rootScope, $controller,$http, $location, logger, ngDialog,
        utilsService,$state,sharedProperties,$window,$stateParams,toaster,validationService) {

$scope.displayedCollection = [];
var date  = new Date();
var dateString =  date.getDate() + "/" + date.getMonth() + "/" + date.getFullYear() + " " + date.getHours() + ":" + date.getMinutes();
	$scope.rowCollectionFollowup=[];
    $scope.referralList=[];
    $scope.isEdit = false;
    $scope.s1 = true;
    $scope.s2=false;
    $scope.job=false;
    $rootScope.condition =true;
    $scope.tairDetailList =[];
	
	

    $scope.cancel = function() {
	  	  $state.go('app.sea.mabl.list',{tenantid:$stateParams.tenantid});
	  	  
	          
	    };
    
	   
		    $scope.lMablContainerBean =[];
		    $scope.lMablFreightBean =[];
		    $scope.lMabljobDetailBean =[];

		    $scope.mabl = {
		    		 jobNo:'',
		    		 type:'',
		    		 hblNo:'',
		    		 mblNo:'',
		    		 marksAndNos:'',
		    		 mbwDate:'',
		    		 hblDocNo:'',
		    		 hblDocDate:'',
		    		 mblDocNo:'',
		    		 mblDate:'',
		    		 mblDocDate:'',
		    		 vesselVoyeage:'',
		    		 feederVesselVoyeage:'',
		    		 vendor:'',
		    		 etd:'',
		    		 etaAtPod:'',
		    		 igmNo:'',
		    		 igmDate:'',
		    		 itemNo:'',
		    		 to:'',
		    		 doRemarks:'',
		    		 canRemarks:'',
		    		 branch:'',
		    		 pol:'',
		    		 pod:'',
		    		 term:'',
		    		 salesPerson:'',
		    		 vessel:'',
		    		 origin:'',
		    		 destination:'',
		    		 arrivalDate:'',
		    		 containerNo:'',
		    		 sealNo:'',
		    		 status:'',
		    		 measureMent:'',
		    		 remarks:'',
		    		 mablCargoDetailBin:'',
		    	     cargoDescription:'',
		    	     customerCode:'',
		    	     customer:'',
		    	     shipper:'',
		    		 size:'',
		    		 noofPackage:'',
		    		 uOm:'',
		    		 grossWeight:'',
		    		 netWeight:'',
		    		 consignee:'',
		    		 shipperAddress:'',
		    		 consigneeAddress:'',
		    		 notifyAddress:'',
		    		 placeofReceipt:'',
		    		 portofLoad:'',
		    		 portofDischarge:'',
		    		 portofDelivery:'',
		    		 placeofDelivery:'',
		    		 signedAt:'',
		    		 signedBy:'',
		    		 finalDestination:'',
		    		 forwardingAgentReferences:'',
		    		 containerNumber:'',
		    		 freightPayableAt:'',
		    		 noOfOriginalBl:'',
		    		 preCarriagedBy:'',
		    		 consolidationNumber:'',
		    		 exportReferences:'',
		    		 shipperReferences:'',
		    		 ftzNumber:'',
		    		 loadingPierTerminal:'',
		    		 coLoadedWith:'',
		    		 containarized:false,
		    	     destinationAgentCode:'',
		    	     currency:'',
		    	     cargoInsurance:'',
		    	     movement:'',
		    		 notify:'',
		    		 mblCode:'',
		    		 modifedBy:'',
		    		 modifedDate:'',
		    		 polCode:'',
		    		 podCode:'',
		    		 originCode:'',
		    		 agentName:'',
		         };
		    
		  $scope.tempMablContainerBean = {
			select 		:false,
			containerNo:'',
			sealNo:'',
			size:'',
			marksAndNos:'',	
			cargoDescription:'',
			noofPackage:'',	 
			uOm:'',	 
			netWeight:'',
			grossWeight:'',
			remarks:'',
			mblContainerNo:'',
		 mablContainerDetailBin:''

		};
   //  $scope.lMablContainerBean=[];
		  $scope.tempMablFreightBean = {
					select 		:false,
					chargeName:'',
					paymentMode:'',
					amount:'',
					print:'',	
					mblFreightNo:'',
				 mablfrieghtDetailBin:''	

				};
		  
	 // add Row
		  
		  $scope.cargoList =[{
			  id:'1',
			  text:'Covered',
		  },
		  {
		  id:'2',
		  text:'Not Covered',  
		  
}];
		  
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

			$scope.mabl.mblDate = dd + '/' + mm + '/'
					+ yyyy;
		 
	  $scope.addCredRow = function() {
	   
		  var tmp=angular.copy($scope.tempMablContainerBean);
			$scope.lMablContainerBean.push(tmp);

	  }
	  $scope.addCredRow();
	  $scope.packageCalculation = function(noofPackage,
				trIndex, row) {
			// row.cbpDtlTcAmount =parseFloat(tcAmount);
			if (row.noofPackage != 0 && row.noofPackage != "") {
				
					var noofPackages = noofPackage;
					/*row.noofPackages = parseFloat(noofPackages).toFixed(
							2);*/
					$scope.totalPackageCalculation();
				} 
		}
		$scope.totalPackageCalculation = function() {
			debugger;
			var mablContainerBean = $scope.lMablContainerBean;
			var noofPackage = 0;
			angular.forEach(mablContainerBean, function(item, key) {
				var mablContainerBeanData = mablContainerBean[key];
				noofPackage = noofPackage + parseFloat(item.noofPackage);
				$scope.totalPackage = noofPackage;
			});

			/*$scope.cbpmtDtlTotalAmt.totalBCAmount = $scope.cbpmtDtlTotalAmt.totalBCAmount
					.toFixed(2);
			$scope.cbpmtDtlTotalAmt.totalTCAmount = $scope.cbpmtDtlTotalAmt.totalTCAmount
					.toFixed(2);*/
		}
		$scope.pod="";
		$scope.pol="";
		$scope.branch="";
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
	  
		$scope.deleteCredRow =function(){
			ngDialog.openConfirm().then(function() {
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
				$http.post($stateParams.tenantid+'/app/master/mabl/deleteContainerDetail',tmpDelList).success(function(data) {
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
			})
		}
		  $scope.addFreightRow = function() {
			   
			  var tmp=angular.copy($scope.tempMablFreightBean);
				$scope.lMablFreightBean.push(tmp);

		  }
		  $scope.addFreightRow();

			$scope.removeFreightRow =function(){
				ngDialog.openConfirm().then(function() {
				if($scope.isEdit==false){
					var tmpDelList = [];
					for(var i=$scope.lMablFreightBean.length-1;i>=0;i--){
						if($scope.lMablFreightBean[i].select==true){
							tmpDelList.push($scope.lMablFreightBean[i]);
							$scope.lMablFreightBean.splice(i, 1);
						}
					}
					logger.logSuccess('Deleted Successfully');
				}else if($scope.isEdit==true){
					var tmpDelList = [];
					for(var i=$scope.lMablFreightBean.length-1;i>=0;i--){
						if($scope.lMablFreightBean[i].select==true){
							tmpDelList.push($scope.lMablFreightBean[i]);
						}
					}
					$http.post($stateParams.tenantid+'/app/master/mabl/deleteFreightDetail',tmpDelList).success(function(data) {
			        	if(data.success){
			        		for(var i=$scope.lMablFreightBean.length-1;i>=0;i--){
			    				if($scope.lMablFreightBean[i].select==true){
			    					$scope.lMablFreightBean.splice(i, 1);
			    				}
			    			}
			        		logger.logSuccess('Deleted Successfully');
			        	}else{
			        		logger.logError('Unable to delete');
			        	}
					})
				}
				})
			}
		var mblNo = $location.search().rowid;
		if(mblNo!=null && mblNo!=undefined && mblNo>0){
			$scope.isEdit=true;
			$rootScope.condition = false;
	        $http.post($stateParams.tenantid+'/app/master/mabl/edit?mablId='+mblNo).success(function(data) {
	        	if(data.success){
					
	        		$scope.jobDetail=true;
	 	        		$scope.mabl = data.hblBean;
	 	        		$scope.lMablFreightBean=data.lMablFreightBean;
	 					$scope.lMablContainerBean=data.lMablContainerBean;
	 					$scope.lMabljobDetailBean=data.lMabljobDetailBean;
	 					$scope.mabl.vendor = data.hblBean.vendor;
	 	        		$scope.mabl.type = data.hblBean.type.toString();
	 	        		$scope.mabl.pol = data.hblBean.pol.toString();
	 	        		$scope.mabl.pod = data.hblBean.pod.toString();
	 	        		$scope.mabl.term = data.hblBean.term.toString();
	 	        		$scope.mabl.customer = data.hblBean.customer.toString();
	 	        		
	 	        		$scope.mabl.branch = data.hblBean.branch.toString();
	 	        		if($scope.mabl.shipperAddress==null){

						}
						else if($scope.mabl.shipperAddress != null && $scope.mabl.shipperAddress != ''){
	        			 var text5 =$scope.mabl.shipperAddress;
	                     text5 = text5.replace(/\r?<br>/g, '\n');
	                     $scope.mabl.shipperAddress=text5;
					}
					if($scope.mabl.consigneeAddress==null){

						}
						else
	        		if($scope.mabl.consigneeAddress != null  && $scope.mabl.consigneeAddress != '' ){
	        			 var text6 =$scope.mabl.consigneeAddress;
	                     text6 = text6.replace(/\r?<br>/g, '\n');
	                     $scope.mabl.consigneeAddress=text6;
	        		}
	        		/*if(data.lMablFreightBean.length<=0){
	        				 $scope.s2= true;
	        			// $scope.job= true;
	        		}
	        		else{*/
                    for(var i=0;i<data.lMablFreightBean.length;i++) 
                    	{
                    	if(data.lMablFreightBean[i].paymentMode!=null&&data.lMablFreightBean[i].paymentMode!='')
                    		{ 
                    		if(data.lMablFreightBean[i].length !=0){
                           	 
                           	  
        					$scope.lMablFreightBean[i].paymentMode=data.lMablFreightBean[i].paymentMode.toString();
        					
        					/*if(data.lMabljobDetailBean.length<=0){
        						$scope.s2= true;
       						 $scope.s1 = false;
        					
        					}*/
        					 /*$scope.$watchCollection('[ mabl.branch,mabl.pol,mabl.pod]', function(newValue, oldValue) {
              			       {
              			    	   $scope.branchData= $scope.mabl.branch;
              			    	   $scope.polData= $scope.mabl.pol;
              			    	   $scope.podData= $scope.mabl.pod;
              			    	   if($scope.isEdit==true || $scope.podData!=$scope.pod || $scope.polData!=$scope.pol || $scope.branchData!=$scope.branch)
              			    		   {
              			        	   $scope.lMabljobDetailBean=[];

              			    	   if($scope.mabl.branch!=undefined && $scope.mabl.branch!=null && $scope.mabl.branch!="" && $scope.mabl.pol!=undefined && $scope.mabl.pol!=null && $scope.mabl.pol!="" && $scope.mabl.pod!=undefined && $scope.mabl.pod!=null && $scope.mabl.pod!="")
              			    		   {
              			   	        $http.post($stateParams.tenantid+'/app/master/mabl/getJobDetail?branchId='+$scope.branchData+'&pol='+$scope.polData+'&pod='+$scope.podData).success(function(data) {
              			             if(data.success==true)
              			            	 {
              			            	 if(data.lMabljobDetailBean.length !=0){
              			            	 
              			          	   $scope.jobDetail= true;
              			          	 $scope.s1 = false;

              			            	 $scope.lMabljobDetailBean=data.lMabljobDetailBean;
              			            	 }else{
              			            		 
              			            		 $scope.jobDetail= false;
              			            		 $scope.s1 = false;
              			            		 
              			            		 for(var i=0;i<$scope.podList.length;i++)
              			            			 {
              			            			 
              			            			 if($scope.podList[i].id=$scope.mabl.pod)
              			            				 {
              			            				 $scope.set=$scope.podList[i].text;
              			            			 }
              			            			 }
              			            		 $scope.t1=data.bean.pol;
              			            		 $scope.t2=data.bean1.pod;
              			            		 $scope.t3=data.bean2.branch;
              			            	 }
              			            	 }
              			             
              			   	        })
              			    		   
              			    	}
              			    		   }
              			       }
              			       })*/
                    		}
                    		
                    		/*else{
                    			 $scope.jobDetail= false;
                    			 $scope.$watchCollection('[ mabl.branch,mabl.pol,mabl.pod]', function(newValue, oldValue) {
                    			       {
                    			    	   $scope.branchData= $scope.mabl.branch;
                    			    	   $scope.polData= $scope.mabl.pol;
                    			    	   $scope.podData= $scope.mabl.pod;
                    			    	   if($scope.isEdit==false || $scope.podData!=$scope.pod || $scope.polData!=$scope.pol || $scope.branchData!=$scope.branch)
                    			    		   {
                    			        	   $scope.lMabljobDetailBean=[];

                    			    	   if($scope.mabl.branch!=undefined && $scope.mabl.branch!=null && $scope.mabl.branch!="" && $scope.mabl.pol!=undefined && $scope.mabl.pol!=null && $scope.mabl.pol!="" && $scope.mabl.pod!=undefined && $scope.mabl.pod!=null && $scope.mabl.pod!="")
                    			    		   {
                    			   	        $http.post($stateParams.tenantid+'/app/master/mabl/getJobDetail?branchId='+$scope.branchData+'&pol='+$scope.polData+'&pod='+$scope.podData).success(function(data) {
                    			             if(data.success==true)
                    			            	 {
                    			            	 if(data.lMabljobDetailBean.length !=0){
                    			            	 
                    			          	   $scope.jobDetail= true;
                    			          	 $scope.s1 = false;

                    			            	 $scope.lMabljobDetailBean=data.lMabljobDetailBean;
                    			            	 }else{
                    			            		 
                    			            		 $scope.jobDetail= false;
                    			            		 $scope.s1 = false;
                    			            		 
                    			            		 for(var i=0;i<$scope.podList.length;i++)
                    			            			 {
                    			            			 
                    			            			 if($scope.podList[i].id=$scope.mabl.pod)
                    			            				 {
                    			            				 $scope.set=$scope.podList[i].text;
                    			            			 }
                    			            			 }
                    			            		 $scope.t1=data.bean.pol;
                    			            		 $scope.t2=data.bean1.pod;
                    			            		 $scope.t3=data.bean2.branch;
                    			            	 }
                    			            	 }
                    			             
                    			   	        })
                    			    		   
                    			    	}
                    			    		   }
                    			       }
                    			       })
                    			
                    		}*/
                    		}
                    	
                    	/*if(data.lMablFreightBean[i].print!=false)
                		{
    					$scope.lMablFreightBean[i].print="False";

                		}else{
        					$scope.lMablFreightBean[i].print="True";

                		}*/

                    	}
                    if(data.lMabljobDetailBean!=0)
        			{
        			 $scope.jobDetail= true;
                   	 $scope.s1 = false;
        			$scope.lMabljobDetailBean=data.lMabljobDetailBean;
        			}
        		else{
					 $scope.jobDetail= true;
		          	 $scope.s1 = false;
					 
				}
	        		//}
                    for(var i=0;i<data.lMablContainerBean.length;i++) 
                	{
                	if(data.lMablContainerBean[i].size!=null&&data.lMablContainerBean[i].size!='')
                		{
    					$scope.lMablContainerBean[i].size=data.lMablContainerBean[i].size.toString();

                		}
                	if(data.lMablContainerBean[i].uOm!=null&&data.lMablContainerBean[i].uOm!='')
            		{
					$scope.lMablContainerBean[i].uOm=data.lMablContainerBean[i].uOm.toString();

            		}

                	}
	        		if(data.hblBean.origin!=null&&data.hblBean.origin!='')
	    			{
	        		$scope.mabl.origin = data.hblBean.origin.toString();

	    			}

	        		if(data.hblBean.destination!=null&&data.hblBean.destination!='')
	    			{
	        		$scope.mabl.destination = data.hblBean.destination.toString();

	    			}
	        		if(data.hblBean.salesPerson!=null&&data.hblBean.salesPerson!='')
	    			{
	        		$scope.mabl.salesPerson = data.hblBean.salesPerson.toString();

	    			}
	    		   if(data.hblBean.shipper!=null && data.hblBean.shipper!='')
				   {
	        		$scope.mabl.shipper = data.hblBean.shipper.toString();

				    }
	    		   if(data.hblBean.consignee!=null && data.hblBean.consignee!='')
				   {
	        		$scope.mabl.consignee = data.hblBean.consignee.toString();

				    }
	    		  
	    		
	    		   if(data.hblBean.movement!=null && data.hblBean.movement!='')
				   {
	        		$scope.mabl.movement = data.hblBean.movement.toString();

				    }
	    		   if(data.hblBean.cargoInsurance!=null && data.hblBean.cargoInsurance!='')
				   {
	        		$scope.mabl.cargoInsurance = data.hblBean.cargoInsurance.toString();

				    }
	    		   if(data.hblBean.preCarriagedBy!=null && data.hblBean.preCarriagedBy!='')
				   {
	        		$scope.mabl.preCarriagedBy = data.hblBean.preCarriagedBy.toString();

				    }
	    		   if(data.hblBean.destinationAgentCode!=null && data.hblBean.destinationAgentCode!='')
				   {
	        		$scope.mabl.destinationAgentCode = data.hblBean.destinationAgentCode.toString();

				    }
	    		   if(data.hblBean.currency!=null && data.hblBean.currency!='')
				   {
	        		$scope.mabl.currency = data.hblBean.currency.toString();

				    }
	    		   if(data.hblBean.containarized==false)
				   {
	        		$scope.mabl.containarized = "False";

				    }else{
		        		$scope.mabl.containarized = "True";

				    }
	    		   $scope.viewQuotation = function(jobNo) {
						debugger
							$location.url($stateParams.tenantid+'/jobOrderSea/view?rowid='+jobNo);
						
					}
	    		   
	    		   $scope.totalPackageCalculation();
	    		   $scope.totalnetWeightCalculation();
	    		   $scope.totalgrossWeightCalculation();
        		  $http.post($stateParams.tenantid+'/app/master/hbl/dropDownList').success(function(data) {
        	          	
                		$scope.vendorList=data.vendor;
                		$scope.customerList=data.customer;
                		$scope.termList=data.term;
                		$scope.destinationList=data.destination;
                		$scope.originList=data.origin;
                		$scope.branchList=data.branch;
                		$scope.podList=data.pod;
                		$scope.polList=data.pol;
                		$scope.movementList=data.movement;
                		$scope.preCarriageList=data.preCarriaged;
                		$scope.destinationAgentList=data.destinationAgent;	
                		$scope.currencyList=data.currency;
                		$scope.jobList=data.seaJob;
                		$scope.salesPersonList=data.salesPerson;
                		$scope.mblList=data.mbl;
                  		//$scope.sizeList=data.sizeList;
                  		$scope.iataList=data.iataList;
                  		//$scope.paymentList=data.paymentList;
                  		$scope.uomList=data.uom;
                  		$scope.agentList=data.agentName;

                });	
	        	
	        	}else{
	        		logger.logError("Unable to fetch data");
	        	}
	        });
		}
		$http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(datas) {
									//$scope.containerNoList=datas.getcontainer;
									  $scope.sizeList=datas.getcontypelist;
								}).error(function(datas) {
								});
		 $http.get($stateParams.tenantid+'/app/seaquotation/getTerms').success(function(datas) {
			 $scope.paymentList = datas.commonUtilityBean;
		    
		}).error(function(data) {

		});
		 $scope.viewQuotation = function(jobNo) {
				debugger
					$location.url($stateParams.tenantid+'/jobOrderSea/view?rowid='+jobNo);
				
			}
		
	    $scope.$watchCollection('[ mabl.branch,mabl.pol,mabl.pod]', function(newValue, oldValue) {
       {
		   if($scope.isEdit==false){
    	   $scope.branchData= $scope.mabl.branch;
    	   $scope.polData= $scope.mabl.pol;
    	   $scope.podData= $scope.mabl.pod;
    	   if($scope.isEdit==false || $scope.podData!=$scope.pod || $scope.polData!=$scope.pol || $scope.branchData!=$scope.branch)
    		   {
        	   $scope.lMabljobDetailBean=[];

    	   if($scope.mabl.branch!=undefined && $scope.mabl.branch!=null && $scope.mabl.branch!="" && $scope.mabl.pol!=undefined && $scope.mabl.pol!=null && $scope.mabl.pol!="" && $scope.mabl.pod!=undefined && $scope.mabl.pod!=null && $scope.mabl.pod!="")
    		   {
   	        $http.post($stateParams.tenantid+'/app/master/mabl/getJobDetail?branchId='+$scope.branchData+'&pol='+$scope.polData+'&pod='+$scope.podData).success(function(data) {
             if(data.success==true)
            	 {
            	 if(data.lMabljobDetailBean.length !=0){
            	 
          	   $scope.jobDetail= true;
          	 $scope.s1 = false;

            	 $scope.lMabljobDetailBean=data.lMabljobDetailBean;
            	 }else{
            		 
            		 $scope.jobDetail= false;
            		 $scope.s1 = false;
            		 
            		 /*for(var i=0;i<$scope.podList.length;i++)
            			 {
            			 
            			 if($scope.podList[i].id=$scope.mabl.pod)
            				 {
            				 $scope.set=$scope.podList[i].text;
            			 }
            			 }*/
            		// $scope.lMablContainerBean=[];
            		 $scope.t1=data.bean.pol;
            		 $scope.t2=data.bean1.pod;
            		 $scope.t3=data.bean2.branch;
            	 }
            	 }
             
   	        })
    		   
    	}
			   }
			}
       }
       })
       
       
       $scope.container = function(select,index)
       {
	    	//alert($scope.lMabljobDetailBean[index].jobNo);
	    	
	    	for (var i= $scope.lMabljobDetailBean.length-1;i>=0;i--)
	    		{
	    		var jobNo = $scope.lMabljobDetailBean[i].jobNo;
	    		if($scope.lMabljobDetailBean[i].select==true){
	    			 $http.post($stateParams.tenantid+'/app/master/mabl/getcontlist',$scope.lMabljobDetailBean).success(function(data) {
	 	            	if(data.success){
	 	            		console.log(data.lMablContainerBean);

	 	            		//$scope.mabl=data.lMablBean[0];
	 	            		$scope.lMablContainerBean=data.lMablContainerBean;
	 	            		if(data.lMablBean[0].consigneeAddress!=null){
	 	            			$scope.mabl.consigneeAddress=data.lMablBean[0].consigneeAddress;
	 	            		}

	 	            		if(data.lMablContainerBean[0].sealNo!=null){
	 	            			$scope.mabl.sealNo=data.lMablContainerBean[0].sealNo;
	 	            		}$scope.mabl.mblDocDate=data.lMablBean[0].mblDocDate;
	 	            		$scope.mabl.hblDocDate=data.lMablBean[0].hblDocDate;
	 	            		$scope.mabl.vesselVoyeage=data.lMablBean[0].vesselVoyeage;
	 	            		$scope.mabl.hblDocNo=data.lMablBean[0].hblDocNo;
	 	            		$scope.mabl.mblDocNo=data.lMablBean[0].mblDocNo;
	 	            		$scope.mabl.vendor=data.lMablBean[0].vendor;
	 	            		$scope.mabl.agent=data.lMablBean[0].agent;
	 	            		
	 	            		$scope.mabl.placeofDelivery=data.lMablBean[0].placeofDelivery;
	 	            		$scope.mabl.placeofReceipt=data.lMablBean[0].placeofReceipt;
	 	            		$scope.mabl.portofDelivery=data.lMablBean[0].portofDelivery;
	 	            		$scope.mabl.portofDischarge=data.lMablBean[0].portofDischarge;
	 	            		$scope.mabl.portofLoad=data.lMablBean[0].portofLoad;
	 	            		$scope.mabl.shipperAddress =data.lMablBean[0].shipperAddress;
	 	            	}
	 	           	for(var j=$scope.lMablContainerBean.length-1 ;j>=0;j-- )
         			{
         		$scope.lMablContainerBean[j]=data.lMablContainerBean[j];
         		if(data.lMablContainerBean[j].size!=''&&data.lMablContainerBean[j].size!=null){
         			$scope.lMablContainerBean[j].size = data.lMablContainerBean[j].size.toString();
         		}
         		if(data.lMablContainerBean[j].uOm!=''&&data.lMablContainerBean[j].uOm!=null){
         			$scope.lMablContainerBean[j].uOm = data.lMablContainerBean[j].uOm.toString();
         		}
         		
         			}
	    		});
	    	
	    	
	    	
      }
	    		else
	    		{
	    			$scope.lMablContainerBean = [];
	    			$scope.mabl.consigneeAddress= '';
	    			$scope.mabl.placeofDelivery = '';
	    			$scope.mabl.placeofReceipt = '';
	    			$scope.mabl.portofDelivery= '';
	    			$scope.mabl.portofDischarge= '';
	    			$scope.mabl.portofLoad= '';
	    			$scope.mabl.shipperAddress= '';
	    			
	    		}
       }
       }
		
		/*
			 * $http.post($stateParams.tenantid+'/app/master/vendor/getMapDetail').success(function(data) {
			 * if(data.success){
			 * $scope.servicePartnerType=data.servicePartnerType; } });
			 */
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
        		$scope.destinationAgentList=data.destinationAgent;	
        		$scope.currencyList=data.currency;
        		$scope.jobList=data.seaJob;
        		$scope.salesPersonList=data.salesPerson;
        		$scope.mblList=data.mbl;
          	//$scope.sizeList=data.sizeList;
          		$scope.iataList=data.iataList;
          		//$scope.paymentList=data.paymentList;
          		$scope.uomList=data.uom;
          		$scope.agentList=data.agentName;

		});
		$http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(datas) {
									//$scope.containerNoList=datas.getcontainer;
									  $scope.sizeList=datas.getcontypelist;
								}).error(function(datas) {
								});
		 $http.get($stateParams.tenantid+'/app/seaquotation/getTerms').success(function(datas) {
			 $scope.paymentList = datas.commonUtilityBean;
		    
		}).error(function(data) {

		});
		$scope.save = function(mablForm){
			if (new validationService().checkFormValidity(mablForm)) {
	            var flag1 = true, flag2 = true, flag3 = true, flag4 = true, flag5 = true;

				if($scope.mabl.mblDocDate=="" || $scope.mabl.mblDocDate==undefined)
				{
				$scope.mabl.mblDocDate=null
				}
			
			if($scope.mabl.hblDocDate=="" || $scope.mabl.hblDocDate==undefined)
			{
			$scope.mabl.hblDocDate=null
			}
			if($scope.mabl.etaAtPod=="" || $scope.mabl.etaAtPod==undefined)
			{
			$scope.mabl.etaAtPod=null
			}
			if($scope.mabl.etd=="" || $scope.mabl.etd==undefined)
			{
			$scope.mabl.etd=null
			}
			if($scope.mabl.shipperAddress != null && $scope.mabl.shipperAddress != ''){
				 var text = $scope.mabl.shipperAddress;
		         text = text.replace(/\r?\n/g, '<br>');
	             $scope.mabl.shipperAddress=text;
			}
			if($scope.mabl.consigneeAddress != null  && $scope.mabl.consigneeAddress != '' ){
				 var text1 = $scope.mabl.consigneeAddress;
		         text1 = text1.replace(/\r?\n/g, '<br>');
	             $scope.mabl.consigneeAddress=text1;
			}
			for(var i=0;i<$scope.lMablContainerBean.length;i++){
				 if ($scope.lMablContainerBean[i].noofPackage != undefined && $scope.lMablContainerBean[i].noofPackage != null && $scope.lMablContainerBean[i].noofPackage != '') {
					 if (flag1 == true)
					 {
					 flag1 = validateNos($scope.lMablContainerBean[i].noofPackage);
					 }
		         }	
				 if ($scope.lMablContainerBean[i].uOm != undefined && $scope.lMablContainerBean[i].uOm != null && $scope.lMablContainerBean[i].uOm != '') {
					 if (flag2 == true)
					 {
					 flag2 = validateNos($scope.lMablContainerBean[i].uOm);
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
			}
			
			for(var i=0;i<$scope.lMablFreightBean.length;i++){
				 if ($scope.lMablFreightBean[i].amount != undefined && $scope.lMablFreightBean[i].amount != null && $scope.lMablFreightBean[i].amount != '') {
					 if (flag5 == true)
					 {
					 flag5 = validateDouble($scope.lMablFreightBean[i].amount);
					 }
		         }	
				
			}
			$scope.lMabljobDetailBean1=[];
			for(var i=0;i<$scope.lMabljobDetailBean.length;i++)
			{
			if($scope.lMabljobDetailBean[i].select==true)
			$scope.lMabljobDetailBean1.push($scope.lMabljobDetailBean[i]);
			}
				var obj = {
						hblBean : $scope.mabl,
						lMablFreightBean	: $scope.lMablFreightBean,
						lMablContainerBean	: $scope.lMablContainerBean,
						lMabljobDetailBean:$scope.lMabljobDetailBean1,

				}
				if($scope.lMabljobDetailBean1.length>0)
					{
				if (flag1 == true && flag2 == true && flag2 == true && flag3 == true && flag4 == true && flag5 == true) {

	            $http.post($stateParams.tenantid+'/app/master/mabl/save',obj).success(function(data) {
	            	if(data.success){
	            		logger.logSuccess('Saved Successfully');
	            		$scope.cancel();
	            	}else{
	            		logger.logError('Unable to save!');
	            	}
	            	
	            });
			}
			else {
                if (flag1 == false) {
                    logger.logError("Please Enter Number Value for No Of Package in Container Details");
                }
                if (flag2 == false) {
                    logger.logError("Please Enter Number Value for UOM in Container Details");
                }
                if (flag3 == false) {
                    logger.logError("Please Enter Number Value for NetWeight in Container Details");
                }
                if (flag4 == false) {
                    logger.logError("Please Enter Number Value for GrossWeight in Container Details");
                }
                if (flag5 == false) {
                    logger.logError("Please Enter Number Value for Amount in Freight Details");
                }
              
			}
					}
				else
				{
                    logger.logError("Job Details: Field is Required");

			
				}
			}else {
	            toaster.pop('error', "Please fill the required fields", 
	                    logger.getErrorHtmlNew(mablForm.$validationSummary), 5000, 'trustedHtml');
	        }
		}
		$scope.update = function(mablForm){
			if (new validationService().checkFormValidity(mablForm)) {
	            var flag1 = true, flag2 = true, flag3 = true, flag4 = true, flag5 = true;
	            if($scope.mabl.shipperAddress != null && $scope.mabl.shipperAddress != ''){
	      			 var text = $scope.mabl.shipperAddress;
	      	         text = text.replace(/\r?\n/g, '<br>');
	                   $scope.mabl.shipperAddress=text;
	      		}
	      		if($scope.mabl.consigneeAddress != null  && $scope.mabl.consigneeAddress != '' ){
	      			 var text1 = $scope.mabl.consigneeAddress;
	      	         text1 = text1.replace(/\r?\n/g, '<br>');
	                   $scope.mabl.consigneeAddress=text1;
	      		}

				if($scope.mabl.mblDocDate=="" || $scope.mabl.mblDocDate==undefined)
				{
				$scope.mabl.mblDocDate=null
				}
			
			if($scope.mabl.hblDocDate=="" || $scope.mabl.hblDocDate==undefined)
			{
			$scope.mabl.hblDocDate=null
			}
			if($scope.mabl.etaAtPod=="" || $scope.mabl.etaAtPod==undefined)
			{
			$scope.mabl.etaAtPod=null
			}
			if($scope.mabl.etd=="" || $scope.mabl.etd==undefined)
			{
			$scope.mabl.etd=null
			}
			for(var i=0;i<$scope.lMablContainerBean.length;i++){
				 if ($scope.lMablContainerBean[i].noofPackage != undefined && $scope.lMablContainerBean[i].noofPackage != null && $scope.lMablContainerBean[i].noofPackage != '') {
					 if (flag1 == true)
					 {
					 flag1 = validateNos($scope.lMablContainerBean[i].noofPackage);
					 }
		         }	
				 if ($scope.lMablContainerBean[i].uOm != undefined && $scope.lMablContainerBean[i].uOm != null && $scope.lMablContainerBean[i].uOm != '') {
					 if (flag2 == true)
					 {
					 flag2 = validateNos($scope.lMablContainerBean[i].uOm);
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
			}
			
			for(var i=0;i<$scope.lMablFreightBean.length;i++){
				 if ($scope.lMablFreightBean[i].amount != undefined && $scope.lMablFreightBean[i].amount != null && $scope.lMablFreightBean[i].amount != '') {
					 if (flag5 == true)
						 {
						 flag5 = validateDouble($scope.lMablFreightBean[i].amount);

						 }
		         }	
				
			}
			$scope.lMabljobDetailBean1=[];
			for(var i=0;i<$scope.lMabljobDetailBean.length;i++)
			{
			if($scope.lMabljobDetailBean[i].select==true)
			$scope.lMabljobDetailBean1.push($scope.lMabljobDetailBean[i]);
			}
				var obj = {
						hblBean : $scope.mabl,
						lMablFreightBean	: $scope.lMablFreightBean,
						lMablContainerBean	: $scope.lMablContainerBean,
						lMabljobDetailBean:$scope.lMabljobDetailBean1,


				}
				if($scope.lMabljobDetailBean1.length>0){
					
					
				
				if (flag1 == true && flag2 == true && flag2 == true && flag3 == true && flag4 == true && flag5 == true) {

	            $http.post($stateParams.tenantid+'/app/master/mabl/update',obj).success(function(data) {
	            	if(data.success){
	            		logger.logSuccess('Updated Successfully');
	            		if($scope.mabl.shipperAddress != null && $scope.mabl.shipperAddress != ''){
	             			 var text5 =$scope.mabl.shipperAddress;
	                          text5 = text5.replace(/\r?<br>/g, '\n');
	                          $scope.mabl.shipperAddress=text5;
	             		}
	             		if($scope.mabl.consigneeAddress != null  && $scope.mabl.consigneeAddress != '' ){
	             			 var text6 =$scope.mabl.consigneeAddress;
	                          text6 = text6.replace(/\r?<br>/g, '\n');
	                          $scope.mabl.consigneeAddress=text6;
	             		}
	            		$scope.cancel();
	            	}else{
	            		logger.logError('Unable to save!');
	            	}
	            	
	            });
			}
			else {
                if (flag1 == false) {
                    logger.logError("Please Enter Number Value for No Of Package in Container Details");
                }
                if (flag2 == false) {
                    logger.logError("Please Enter Number Value for UOM in Container Details");
                }
                if (flag3 == false) {
                    logger.logError("Please Enter Number Value for NetWeight in Container Details");
                }
                if (flag4 == false) {
                    logger.logError("Please Enter Number Value for GrossWeight in Container Details");
                }
                if (flag5 == false) {
                    logger.logError("Please Enter Number Value for Amount in Freight Details");
                }
              
            }
			}
				else
				{
				toaster.pop('error', "Please fill the required fields", 
	                    logger.getErrorHtmlNew("Job Details: Field is Required"), 5000, 'trustedHtml');
				}
			}
			
			else {
	            toaster.pop('error', "Please fill the required fields", 
	                    logger.getErrorHtmlNew(mablForm.$validationSummary), 5000, 'trustedHtml');
	        }
		}
		var mblNo = $location.search().rowid;

		 $scope.printRow = function() {
		 	   debugger
			        var url = $stateParams.tenantid+'/app/master/mabl/print?mablId=' + mblNo;
			        var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
			        wnd.print();   
			     }     
		 $scope.printManifest = function() {
		 	   debugger
			        console.log("Both print invoice")
			        var url = $stateParams.tenantid+'/app/master/mabl/printManifest?mablId=' + mblNo;
			        var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
			        wnd.print();   
			          }
		 $scope.printLoad = function(rowid) {
			   debugger
			        console.log("Both print invoice")
			        var url = $stateParams.tenantid+'/app/master/mabl/printLoad?mablId=' + mblNo;
			        var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
			        wnd.print();   
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
		 
		 $scope.showTax = function(mblNo){
	           
             if(mblNo !=""){
                 ngDialog.open({
                     scope : $scope,
                     template : 'views/sea/mabl/mablJobdetail',
                     controller : $controller('mablJobdetailCtrl', {
                         $scope : $scope,
                         mblNo :mblNo,
                         mablObject : $scope.mabl
                       //  accountHeadCode:accountHeadCode,
                        // jobNo:jobNo
                     }),
                     className : 'ngdialog-theme-plain',
                     showClose : false,
                     closeByDocument : false,
                     closeByEscape : false,
                     preCloseCallback : $scope.getList
                 });
             }else{
                 logger.logError("Please Enter Exchange Rate..");
             }
            
         
             
     }
		 app.controller('mablJobdetailCtrl', function($scope, $rootScope,sharedProperties, 
			        logger,$http,$filter, $location,$stateParams, validationService, toaster, $window,ngDialog, $timeout,mblNo) {
			    
				
				$http.get($stateParams.tenantid + '/app/master/mabl/edit?mablId='+mblNo ).success(
						function(response) {
							$scope.rowCollection=response.lMabljobDetailBean;
							//$scope.rowCollection = response.taxList;
						});
			    
				 $scope.cancelng = function(){
				        // $scope.purchaseInvoiceData.purInvDueDateDtls = [];
				        ngDialog.close();
				        if(mablObject.length>0){
				            
				        }else{
				            $scope.mablObject = [];
				        }
				    }
			});

		 $scope.reset=function(){
	         
	         if( $scope.isEdit == false){ 
	        	 $scope.lMablContainerBean =[];
	 		    $scope.lMablFreightBean =[];

	 		    $scope.mabl = {
	 		    		 jobNo:'',
	 		    		 type:'',
	 		    		 hblNo:'',
	 		    		 mblNo:'',
	 		    		 marksAndNos:'',
	 		    		 mbwDate:'',
	 		    		 hblDocNo:'',
	 		    		 hblDocDate:'',
	 		    		 mblDocNo:'',
	 		    		 mblDate:'',
	 		    		 mblDocDate:'',
	 		    		 vesselVoyeage:'',
	 		    		 feederVesselVoyeage:'',
	 		    		 vendor:'',
	 		    		 etd:'',
	 		    		 etaAtPod:'',
	 		    		 igmNo:'',
	 		    		 igmDate:'',
	 		    		 itemNo:'',
	 		    		 to:'',
	 		    		 doRemarks:'',
	 		    		 canRemarks:'',
	 		    		 branch:'',
	 		    		 pol:'',
	 		    		 pod:'',
	 		    		 term:'',
	 		    		 salesPerson:'',
	 		    		 vessel:'',
	 		    		 origin:'',
	 		    		 destination:'',
	 		    		 arrivalDate:'',
	 		    		 containerNo:'',
	 		    		 sealNo:'',
	 		    		 status:'',
	 		    		 measureMent:'',
	 		    		 remarks:'',
	 		    		 mablCargoDetailBin:'',
	 		    	     cargoDescription:'',
	 		    	     customerCode:'',
	 		    	     customer:'',
	 		    	     shipper:'',
	 		    		 size:'',
	 		    		 noofPackage:'',
	 		    		 uOm:'',
	 		    		 grossWeight:'',
	 		    		 netWeight:'',
	 		    		 consignee:'',
	 		    		 shipperAddress:'',
	 		    		 consigneeAddress:'',
	 		    		 notifyAddress:'',
	 		    		 placeofReceipt:'',
	 		    		 portofLoad:'',
	 		    		 portofDischarge:'',
	 		    		 portofDelivery:'',
	 		    		 placeofDelivery:'',
	 		    		 signedAt:'',
	 		    		 signedBy:'',
	 		    		 finalDestination:'',
	 		    		 forwardingAgentReferences:'',
	 		    		 containerNumber:'',
	 		    		 freightPayableAt:'',
	 		    		 noOfOriginalBl:'',
	 		    		 preCarriagedBy:'',
	 		    		 consolidationNumber:'',
	 		    		 exportReferences:'',
	 		    		 shipperReferences:'',
	 		    		 ftzNumber:'',
	 		    		 loadingPierTerminal:'',
	 		    		 coLoadedWith:'',
	 		    		 containarized:false,
	 		    	     destinationAgentCode:'',
	 		    	     currency:'',
	 		    	     cargoInsurance:'',
	 		    	     movement:'',
	 		    		 notify:'',
	 		    		 mblCode:'',
	 		    		 modifedBy:'',
	 		    		 modifedDate:'',
	 		    		 polCode:'',
	 		    		 podCode:'',
	 		    		 originCode:'',
	 		         };
	         }else {
	        	 $http.post($stateParams.tenantid+'/app/master/mabl/edit?mablId='+mblNo).success(function(data) {
	 	        	if(data.success){
	 	        		$scope.jobDetail=true;
	 	        		$scope.mabl = data.hblBean;
	 	        		$scope.lMablFreightBean=data.lMablFreightBean;
	 					$scope.lMablContainerBean=data.lMablContainerBean;
	 					$scope.lMabljobDetailBean=data.lMabljobDetailBean;
	 					$scope.mabl.vendor = data.hblBean.vendor;
	 	        		$scope.mabl.type = data.hblBean.type;
	 	        		$scope.mabl.pol = data.hblBean.pol;
	 	        		$scope.mabl.pod = data.hblBean.pod
	 	        		$scope.mabl.term = data.hblBean.term;
	 	        		$scope.mabl.customer = data.hblBean.customer;
	 	        		
	 	        		$scope.mabl.branch = data.hblBean.branch.toString();
	 	        		if($scope.mabl.shipperAddress==null){

						}
						else if($scope.mabl.shipperAddress != null && $scope.mabl.shipperAddress != ''){
	        			 var text5 =$scope.mabl.shipperAddress;
	                     text5 = text5.replace(/\r?<br>/g, '\n');
	                     $scope.mabl.shipperAddress=text5;
					}
					if($scope.mabl.consigneeAddress==null){

						}
						else
	        		if($scope.mabl.consigneeAddress != null  && $scope.mabl.consigneeAddress != '' ){
	        			 var text6 =$scope.mabl.consigneeAddress;
	                     text6 = text6.replace(/\r?<br>/g, '\n');
	                     $scope.mabl.consigneeAddress=text6;
	        		}
	                     for(var i=0;i<data.lMablFreightBean.length;i++) 
	                     	{
	                     	if(data.lMablFreightBean[i].paymentMode!=null&&data.lMablFreightBean[i].paymentMode!='')
	                     		{
	         					$scope.lMablFreightBean[i].paymentMode=data.lMablFreightBean[i].paymentMode.toString();

	                     		}

	                     	}
	                     for(var i=0;i<data.lMablContainerBean.length;i++) 
	                 	{
	                 	if(data.lMablContainerBean[i].size!=null&&data.lMablContainerBean[i].size!='')
	                 		{
	     					$scope.lMablContainerBean[i].size=data.lMablContainerBean[i].size.toString();

	                 		}
	                 	if(data.lMablContainerBean[i].uom!=null&&data.lMablContainerBean[i].uom!='')
                 		{
     					$scope.lMablContainerBean[i].uom=data.lMablContainerBean[i].uom.toString();

                 		}

	                 	}
	 	        		if(data.hblBean.origin!=null&&data.hblBean.origin!='')
	 	    			{
	 	        		$scope.mabl.origin = data.hblBean.origin.toString();

	 	    			}

	 	        		if(data.hblBean.destination!=null&&data.hblBean.destination!='')
	 	    			{
	 	        		$scope.mabl.destination = data.hblBean.destination.toString();

	 	    			}
	 	        		if(data.hblBean.salesPerson!=null&&data.hblBean.salesPerson!='')
	 	    			{
	 	        		$scope.mabl.salesPerson = data.hblBean.salesPerson.toString();

	 	    			}
	 	    		   if(data.hblBean.shipper!=null && data.hblBean.shipper!='')
	 				   {
	 	        		$scope.mabl.shipper = data.hblBean.shipper.toString();

	 				    }
	 	    		   if(data.hblBean.consignee!=null && data.hblBean.consignee!='')
	 				   {
	 	        		$scope.mabl.consignee = data.hblBean.consignee.toString();

	 				    }
	 	    		  
	 	    		
	 	    		   if(data.hblBean.movement!=null && data.hblBean.movement!='')
	 				   {
	 	        		$scope.mabl.movement = data.hblBean.movement.toString();

	 				    }
	 	    		   if(data.hblBean.cargoInsurance!=null && data.hblBean.cargoInsurance!='')
	 				   {
	 	        		$scope.mabl.cargoInsurance = data.hblBean.cargoInsurance.toString();

	 				    }
	 	    		   if(data.hblBean.preCarriagedBy!=null && data.hblBean.preCarriagedBy!='')
	 				   {
	 	        		$scope.mabl.preCarriagedBy = data.hblBean.preCarriagedBy.toString();

	 				    }
	 	    		   if(data.hblBean.destinationAgentCode!=null && data.hblBean.destinationAgentCode!='')
	 				   {
	 	        		$scope.mabl.destinationAgentCode = data.hblBean.destinationAgentCode.toString();

	 				    }
	 	    		   if(data.hblBean.currency!=null && data.hblBean.currency!='')
	 				   {
	 	        		$scope.mabl.currency = data.hblBean.currency.toString();

	 				    }
	 	    		   $scope.totalPackageCalculation();
	 	    		   $scope.totalnetWeightCalculation();
	 	    		   $scope.totalgrossWeightCalculation();
	         		  $http.post($stateParams.tenantid+'/app/master/hbl/dropDownList').success(function(data) {
	         	          	
	                 		$scope.vendorList=data.vendor;
	                 		$scope.customerList=data.customer;
	                 		$scope.termList=data.term;
	                 		$scope.destinationList=data.destination;
	                 		$scope.originList=data.origin;
	                 		$scope.branchList=data.branch;
	                 		$scope.podList=data.pod;
	                 		$scope.polList=data.pol;
	                 		$scope.movementList=data.movement;
	                 		$scope.preCarriageList=data.preCarriaged;
	                 		$scope.destinationAgentList=data.destinationAgent;	
	                 		$scope.currencyList=data.currency;
	                 		$scope.jobList=data.seaJob;
	                 		$scope.salesPersonList=data.salesPerson;
	                 		$scope.mblList=data.mbl;
	                   		//$scope.sizeList=data.sizeList;
	                   		$scope.iataList=data.iataList;
	                   		//$scope.paymentList=data.paymentList;
	                   		$scope.agentList=data.agentName;


	                 });	
	 	        	
	 	        	}else{
	 	        		logger.logError("Unable to fetch data");
	 	        	}
	 	        });
	         }
		 }
		 $http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(datas) {
									//$scope.containerNoList=datas.getcontainer;
									  $scope.sizeList=datas.getcontypelist;
								}).error(function(datas) {
								});
		 $http.get($stateParams.tenantid+'/app/seaquotation/getTerms').success(function(datas) {
			 $scope.paymentList = datas.commonUtilityBean;
		    
		}).error(function(data) {

		});
		 $scope.quickLinkMethd=function(qulkVal){
				if(qulkVal!='Select'){
					if($scope.mabl.mblNo!='' && $scope.mabl.mblNo!=undefined){
					$http.post($stateParams.tenantid + '/app/master/mabl/getQuickLinkId?category='+qulkVal+'&mablNo='+$scope.mabl.mblNo).success(function(datas) {
								if(datas.quickLinkId!=null){
									var rowid=datas.quickLinkId;
									if(qulkVal=="Job Order"){
										if(rowid !=0){
											$location.url($stateParams.tenantid+'/jobOrderSea/edit?rowid='+rowid);
											//$window.open('#'+$stateParams.tenantid+'/jobOrderSea/view?rowid='+rowid, '_blank');
										}else{
											logger.logError("There is no "+qulkVal);
										}
									}else if(qulkVal=="HBL"){
										if(rowid !=0){
											$location.url($stateParams.tenantid+'/hbl/edit?rowid='+rowid);
											//$window.open('#'+$stateParams.tenantid+'/hbl/view?rowid='+rowid, '_blank');	
										}else{
											logger.logError("There is no "+qulkVal);
										}
									}else if(qulkVal=="Delivery Order"){
										if(rowid !=0){
											$location.url($stateParams.tenantid+'/deliveryorder/edit?rowid='+rowid);
											//$window.open('#'+$stateParams.tenantid+'/deliveryorder/view?rowid='+rowid,'_blank');
										}else{
											logger.logError("There is no "+qulkVal);
										}
									}else if(qulkVal=="Sales Invoice"){
										if(rowid !=0){
											$location.url($stateParams.tenantid+'/invoice/seasalesinvoice/salesInvoiceView'+rowid);
											//$window.open('#'+$stateParams.tenantid+"/invoice/seasalesinvoice/salesInvoiceView/"+rowid,'_blank');
										}else{
											logger.logError("There is no "+qulkVal);
										}
									}else if(qulkVal=="Purchase Invoice"){
										if(rowid !=0){
											$location.url($stateParams.tenantid+'/invoice/seapurchaseinvoice/PurchaseInvoiceView'+rowid);
											//$window.open('#'+$stateParams.tenantid+"/invoice/seapurchaseinvoice/PurchaseInvoiceView/"+rowid,'_blank');	
										}else{
											logger.logError("There is no "+qulkVal);
										}
										
									}
								} else if(datas.quickLinkIdList!=null){
									var quickLinkIdList=datas.quickLinkIdList
									if(qulkVal=="Job Order"){
										 $window.open('#'+$stateParams.tenantid+'/seajoborder/list?rowid='+quickLinkIdList, '_blank');
									}else if(qulkVal=="HBL"){
										$window.open('#'+$stateParams.tenantid+'/hbl/list?rowid='+quickLinkIdList, '_blank');
									}else if(qulkVal=="Delivery Order"){
										$window.open('#'+$stateParams.tenantid+'/deliveryorder/list?quickLinkIdList='+quickLinkIdList, '_blank');
									}else if(qulkVal=="Sales Invoice"){
										$window.open('#'+$stateParams.tenantid+'/invoice/sea/seasalesinvoice/SalesInvoiceList?quickLinkIdList='+quickLinkIdList,'_blank');
									}else if(qulkVal=="Purchase Invoice"){
										$window.open('#'+$stateParams.tenantid+'/invoice/sea/seapurchaseinvoice/PurchaseInvoiceList?quickLinkIdList='+quickLinkIdList,'_blank');
									}
								}else{
									logger.logError("There is no "+qulkVal);
								}
								
					})
				}
			}
			}
		 $scope.remarks = function(id){
	         
		       
             ngDialog.open({
                 scope : $scope,
                 template : 'views/air/marksmabl',
                 controller : $controller('marksCtrl', {
                     $scope : $scope,
                   index:id,
                     //jobNo:jobNo
                 }),
                 className : 'ngdialog-theme-plain',
                 showClose : false,
                 closeByDocument : false,
                 closeByEscape : false,
                 preCloseCallback : $scope.getList
             });
         }
	 $scope.cargo = function(id){
         
	       
         ngDialog.open({
             scope : $scope,
             template : 'views/air/cargomabl',
             controller : $controller('cargoCtrl', {
                 $scope : $scope,
               index:id,
                 //jobNo:jobNo
             }),
             className : 'ngdialog-theme-plain',
             showClose : false,
             closeByDocument : false,
             closeByEscape : false,
             preCloseCallback : $scope.getList
         });
     }
		 
		 
});


app.controller('mablViewCtrl', function($scope, $rootScope, $controller,$http, $location, logger, ngDialog,
        utilsService,$state,sharedProperties,$window,$stateParams,toaster,validationService) {

$scope.displayedCollection = [];
var date  = new Date();
var dateString =  date.getDate() + "/" + date.getMonth() + "/" + date.getFullYear() + " " + date.getHours() + ":" + date.getMinutes();
	$scope.rowCollectionFollowup=[];
    $scope.referralList=[];
    $scope.isEdit = false;
    $scope.s1 = true;
    $scope.s2=false;
    $scope.job=false;
    $rootScope.condition =true;
    $scope.tairDetailList =[];
	
	

    $scope.cancel = function() {
	  	  $state.go('app.sea.mabl.list',{tenantid:$stateParams.tenantid});
	  	  
	          
	    };
    $scope.agentList=[];
	   
		    $scope.lMablContainerBean =[];
		    $scope.lMablFreightBean =[];
		    $scope.lMabljobDetailBean =[];

		    $scope.mabl = {
		    		 jobNo:'',
		    		 type:'',
		    		 hblNo:'',
		    		 mblNo:'',
		    		 marksAndNos:'',
		    		 mbwDate:'',
		    		 hblDocNo:'',
		    		 hblDocDate:'',
		    		 mblDocNo:'',
		    		 mblDate:'',
		    		 mblDocDate:'',
		    		 vesselVoyeage:'',
		    		 feederVesselVoyeage:'',
		    		 vendor:'',
		    		 etd:'',
		    		 etaAtPod:'',
		    		 igmNo:'',
		    		 igmDate:'',
		    		 itemNo:'',
		    		 to:'',
		    		 doRemarks:'',
		    		 canRemarks:'',
		    		 branch:'',
		    		 pol:'',
		    		 pod:'',
		    		 term:'',
		    		 salesPerson:'',
		    		 vessel:'',
		    		 origin:'',
		    		 destination:'',
		    		 arrivalDate:'',
		    		 containerNo:'',
		    		 sealNo:'',
		    		 status:'',
		    		 measureMent:'',
		    		 remarks:'',
		    		 mablCargoDetailBin:'',
		    	     cargoDescription:'',
		    	     customerCode:'',
		    	     customer:'',
		    	     shipper:'',
		    		 size:'',
		    		 noofPackage:'',
		    		 uOm:'',
		    		 grossWeight:'',
		    		 netWeight:'',
		    		 consignee:'',
		    		 shipperAddress:'',
		    		 consigneeAddress:'',
		    		 notifyAddress:'',
		    		 placeofReceipt:'',
		    		 portofLoad:'',
		    		 portofDischarge:'',
		    		 portofDelivery:'',
		    		 placeofDelivery:'',
		    		 signedAt:'',
		    		 signedBy:'',
		    		 finalDestination:'',
		    		 forwardingAgentReferences:'',
		    		 containerNumber:'',
		    		 freightPayableAt:'',
		    		 noOfOriginalBl:'',
		    		 preCarriagedBy:'',
		    		 consolidationNumber:'',
		    		 exportReferences:'',
		    		 shipperReferences:'',
		    		 ftzNumber:'',
		    		 loadingPierTerminal:'',
		    		 coLoadedWith:'',
		    		 containarized:false,
		    	     destinationAgentCode:'',
		    	     currency:'',
		    	     cargoInsurance:'',
		    	     movement:'',
		    		 notify:'',
		    		 mblCode:'',
		    		 modifedBy:'',
		    		 modifedDate:'',
		    		 polCode:'',
		    		 podCode:'',
		    		 originCode:'',
		    		 agentName:'',
		         };
		    
		  $scope.tempMablContainerBean = {
			select 		:false,
			containerNo:'',
			sealNo:'',
			size:'',
			marksAndNos:'',	
			cargoDescription:'',
			noofPackage:'',	 
			uOm:'',	 
			netWeight:'',
			grossWeight:'',
			remarks:'',
			mblContainerNo:'',
		 mablContainerDetailBin:''

		};
    
		  $scope.tempMablFreightBean = {
					select 		:false,
					chargeName:'',
					paymentMode:'',
					amount:'',
					print:'',	
					mblFreightNo:'',
				 mablfrieghtDetailBin:''	

				};
		  
	 // add Row
		  
		  $scope.cargoList =[{
			  id:'1',
			  text:'Covered',
		  },
		  {
		  id:'2',
		  text:'Not Covered',  
		  
}];
		  
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

			$scope.mabl.mblDate = dd + '/' + mm + '/'
					+ yyyy;
		  
	  $scope.addCredRow = function() {
	   
		  var tmp=angular.copy($scope.tempMablContainerBean);
			$scope.lMablContainerBean.push(tmp);

	  }
	  $scope.addCredRow();
	  $scope.packageCalculation = function(noofPackage,
				trIndex, row) {
			// row.cbpDtlTcAmount =parseFloat(tcAmount);
			if (row.noofPackage != 0 && row.noofPackage != "") {
				
					var noofPackages = noofPackage;
					/*row.noofPackages = parseFloat(noofPackages).toFixed(
							2);*/
					$scope.totalPackageCalculation();
				} 
		}
		$scope.totalPackageCalculation = function() {
			debugger;
			var mablContainerBean = $scope.lMablContainerBean;
			var noofPackage = 0;
			angular.forEach(mablContainerBean, function(item, key) {
				var mablContainerBeanData = mablContainerBean[key];
				noofPackage = noofPackage + parseFloat(item.noofPackage);
				$scope.totalPackage = noofPackage;
			});

			/*$scope.cbpmtDtlTotalAmt.totalBCAmount = $scope.cbpmtDtlTotalAmt.totalBCAmount
					.toFixed(2);
			$scope.cbpmtDtlTotalAmt.totalTCAmount = $scope.cbpmtDtlTotalAmt.totalTCAmount
					.toFixed(2);*/
		}
		$scope.pod="";
		$scope.pol="";
		$scope.branch="";
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
	  
		$scope.deleteCredRow =function(){
			ngDialog.openConfirm().then(function() {
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
				$http.post($stateParams.tenantid+'/app/master/mabl/deleteContainerDetail',tmpDelList).success(function(data) {
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
			})
		}
		  $scope.addFreightRow = function() {
			   
			  var tmp=angular.copy($scope.tempMablFreightBean);
				$scope.lMablFreightBean.push(tmp);

		  }
		  $scope.addFreightRow();

			$scope.removeFreightRow =function(){
				ngDialog.openConfirm().then(function() {
				if($scope.isEdit==false){
					var tmpDelList = [];
					for(var i=$scope.lMablFreightBean.length-1;i>=0;i--){
						if($scope.lMablFreightBean[i].select==true){
							tmpDelList.push($scope.lMablFreightBean[i]);
							$scope.lMablFreightBean.splice(i, 1);
						}
					}
					logger.logSuccess('Deleted Successfully');
				}else if($scope.isEdit==true){
					var tmpDelList = [];
					for(var i=$scope.lMablFreightBean.length-1;i>=0;i--){
						if($scope.lMablFreightBean[i].select==true){
							tmpDelList.push($scope.lMablFreightBean[i]);
						}
					}
					$http.post($stateParams.tenantid+'/app/master/mabl/deleteFreightDetail',tmpDelList).success(function(data) {
			        	if(data.success){
			        		for(var i=$scope.lMablFreightBean.length-1;i>=0;i--){
			    				if($scope.lMablFreightBean[i].select==true){
			    					$scope.lMablFreightBean.splice(i, 1);
			    				}
			    			}
			        		logger.logSuccess('Deleted Successfully');
			        	}else{
			        		logger.logError('Unable to delete');
			        	}
					})
				}
				})
			}
		var mblNo = $location.search().rowid;
		if(mblNo!=null && mblNo!=undefined && mblNo>0){
			$scope.isEdit=true;
			$rootScope.condition = false;
	        $http.post($stateParams.tenantid+'/app/master/mabl/view?mablId='+mblNo).success(function(data) {
	        	if(data.success){
	        		$scope.jobDetail=true;
	        		$scope.mabl = data.hblBean;
	        		
	        		$scope.lMablFreightBean=data.lMablFreightBean;
 					$scope.lMabljobDetailBean=data.lMabljobDetailBean;
					$scope.lMablContainerBean=data.lMablContainerBean;
					$rootScope.test=data.lMablContainerBean;
					$scope.mabl.vendor = data.hblBean.vendor;
	        		$scope.mabl.type = data.hblBean.type;
	        		$scope.mabl.pol = data.hblBean.pol;
	        		$scope.mabl.pod = data.hblBean.pod
	        		$scope.mabl.term = data.hblBean.term;
	        		$scope.mabl.customer = data.hblBean.customer;
	        		$scope.mabl.branch = data.hblBean.branch;
	        		$scope.pod=data.hblBean.pod;
	        		$scope.pol=data.hblBean.pol;
	        		$scope.branch=data.hblBean.branch;
	        		$scope.agentName=data.hblBean.agentName;

	        		agentNam
	        		/*if(data.lMablFreightBean.length<=0){
	        				 $scope.s2= true;
	        			// $scope.job= true;
	        		}
					else{*/
						if(scope.mabl.shipperAddress==null){

						}
						else if($scope.mabl.shipperAddress != null && $scope.mabl.shipperAddress != ''){
	        			 var text5 =$scope.mabl.shipperAddress;
	                     text5 = text5.replace(/\r?<br>/g, '\n');
	                     $scope.mabl.shipperAddress=text5;
					}
					if(scope.mabl.consigneeAddress==null){

						}
						else
	        		if($scope.mabl.consigneeAddress != null  && $scope.mabl.consigneeAddress != '' ){
	        			 var text6 =$scope.mabl.consigneeAddress;
	                     text6 = text6.replace(/\r?<br>/g, '\n');
	                     $scope.mabl.consigneeAddress=text6;
	        		}
                    for(var i=0;i<data.lMablFreightBean.length;i++) 
                    	{
                    	if(data.lMablFreightBean[i].paymentMode!=null&&data.lMablFreightBean[i].paymentMode!='')
                    		{ 
                    		if(data.lMablFreightBean[i].length !=0){
                           	 
                           	  
        					$scope.lMablFreightBean[i].paymentMode=data.lMablFreightBean[i].paymentMode.toString();
        					
        					/*if(data.lMabljobDetailBean.length<=0){
        						$scope.s2= true;
       						 $scope.s1 = false;
        					
        					}*/
        					 /*$scope.$watchCollection('[ mabl.branch,mabl.pol,mabl.pod]', function(newValue, oldValue) {
              			       {
              			    	   $scope.branchData= $scope.mabl.branch;
              			    	   $scope.polData= $scope.mabl.pol;
              			    	   $scope.podData= $scope.mabl.pod;
              			    	   if($scope.isEdit==true || $scope.podData!=$scope.pod || $scope.polData!=$scope.pol || $scope.branchData!=$scope.branch)
              			    		   {
              			        	   $scope.lMabljobDetailBean=[];

              			    	   if($scope.mabl.branch!=undefined && $scope.mabl.branch!=null && $scope.mabl.branch!="" && $scope.mabl.pol!=undefined && $scope.mabl.pol!=null && $scope.mabl.pol!="" && $scope.mabl.pod!=undefined && $scope.mabl.pod!=null && $scope.mabl.pod!="")
              			    		   {
              			   	        $http.post($stateParams.tenantid+'/app/master/mabl/getJobDetail?branchId='+$scope.branchData+'&pol='+$scope.polData+'&pod='+$scope.podData).success(function(data) {
              			             if(data.success==true)
              			            	 {
              			            	 if(data.lMabljobDetailBean.length !=0){
              			            	 
              			          	   $scope.jobDetail= true;
              			          	 $scope.s1 = false;

              			            	 $scope.lMabljobDetailBean=data.lMabljobDetailBean;
              			            	 }else{
              			            		 
              			            		 $scope.jobDetail= false;
              			            		 $scope.s1 = false;
              			            		 
              			            		 for(var i=0;i<$scope.podList.length;i++)
              			            			 {
              			            			 
              			            			 if($scope.podList[i].id=$scope.mabl.pod)
              			            				 {
              			            				 $scope.set=$scope.podList[i].text;
              			            			 }
              			            			 }
              			            		 $scope.t1=data.bean.pol;
              			            		 $scope.t2=data.bean1.pod;
              			            		 $scope.t3=data.bean2.branch;
              			            	 }
              			            	 }
              			             
              			   	        })
              			    		   
              			    	}
              			    		   }
              			       }
              			       })*/
                    		}
                    		
                    		/*else{
                    			 $scope.jobDetail= false;
                    			 $scope.$watchCollection('[ mabl.branch,mabl.pol,mabl.pod]', function(newValue, oldValue) {
                    			       {
                    			    	   $scope.branchData= $scope.mabl.branch;
                    			    	   $scope.polData= $scope.mabl.pol;
                    			    	   $scope.podData= $scope.mabl.pod;
                    			    	   if($scope.isEdit==false || $scope.podData!=$scope.pod || $scope.polData!=$scope.pol || $scope.branchData!=$scope.branch)
                    			    		   {
                    			        	   $scope.lMabljobDetailBean=[];

                    			    	   if($scope.mabl.branch!=undefined && $scope.mabl.branch!=null && $scope.mabl.branch!="" && $scope.mabl.pol!=undefined && $scope.mabl.pol!=null && $scope.mabl.pol!="" && $scope.mabl.pod!=undefined && $scope.mabl.pod!=null && $scope.mabl.pod!="")
                    			    		   {
                    			   	        $http.post($stateParams.tenantid+'/app/master/mabl/getJobDetail?branchId='+$scope.branchData+'&pol='+$scope.polData+'&pod='+$scope.podData).success(function(data) {
                    			             if(data.success==true)
                    			            	 {
                    			            	 if(data.lMabljobDetailBean.length !=0){
                    			            	 
                    			          	   $scope.jobDetail= true;
                    			          	 $scope.s1 = false;

                    			            	 $scope.lMabljobDetailBean=data.lMabljobDetailBean;
                    			            	 }else{
                    			            		 
                    			            		 $scope.jobDetail= false;
                    			            		 $scope.s1 = false;
                    			            		 
                    			            		 for(var i=0;i<$scope.podList.length;i++)
                    			            			 {
                    			            			 
                    			            			 if($scope.podList[i].id=$scope.mabl.pod)
                    			            				 {
                    			            				 $scope.set=$scope.podList[i].text;
                    			            			 }
                    			            			 }
                    			            		 $scope.t1=data.bean.pol;
                    			            		 $scope.t2=data.bean1.pod;
                    			            		 $scope.t3=data.bean2.branch;
                    			            	 }
                    			            	 }
                    			             
                    			   	        })
                    			    		   
                    			    	}
                    			    		   }
                    			       }
                    			       })
                    			
                    		}*/
                    		}
                    	
                    	/*if(data.lMablFreightBean[i].print!=false)
                		{
    					$scope.lMablFreightBean[i].print="False";

                		}else{
        					$scope.lMablFreightBean[i].print="True";

                		}*/

                    	}
                    if(data.lMabljobDetailBean!=0)
        			{
        			 $scope.jobDetail= true;
                   	 $scope.s1 = false;
        			$scope.lMabljobDetailBean=data.lMabljobDetailBean;
        			}
        		else{
					 $scope.jobDetail= true;
		          	 $scope.s1 = false;
					 
				}
	        		//}
                    for(var i=0;i<data.lMablContainerBean.length;i++) 
                	{
                	if(data.lMablContainerBean[i].size!=null&&data.lMablContainerBean[i].size!='')
                		{
    					$scope.lMablContainerBean[i].size=data.lMablContainerBean[i].size.toString();

                		}
                	if(data.lMablContainerBean[i].uOm!=null&&data.lMablContainerBean[i].uOm!='')
            		{
					$scope.lMablContainerBean[i].uOm=data.lMablContainerBean[i].uOm.toString();

            		}

                	}
	        		if(data.hblBean.origin!=null&&data.hblBean.origin!='')
	    			{
	        		$scope.mabl.origin = data.hblBean.origin.toString();

	    			}

	        		if(data.hblBean.destination!=null&&data.hblBean.destination!='')
	    			{
	        		$scope.mabl.destination = data.hblBean.destination.toString();

	    			}
	        		if(data.hblBean.salesPerson!=null&&data.hblBean.salesPerson!='')
	    			{
	        		$scope.mabl.salesPerson = data.hblBean.salesPerson.toString();

	    			}
	    		   if(data.hblBean.shipper!=null && data.hblBean.shipper!='')
				   {
	        		$scope.mabl.shipper = data.hblBean.shipper.toString();

				    }
	    		   if(data.hblBean.consignee!=null && data.hblBean.consignee!='')
				   {
	        		$scope.mabl.consignee = data.hblBean.consignee.toString();

				    }
	    		  
	    		
	    		   if(data.hblBean.movement!=null && data.hblBean.movement!='')
				   {
	        		$scope.mabl.movement = data.hblBean.movement.toString();

				    }
	    		   if(data.hblBean.cargoInsurance!=null && data.hblBean.cargoInsurance!='')
				   {
	        		$scope.mabl.cargoInsurance = data.hblBean.cargoInsurance.toString();

				    }
	    		   if(data.hblBean.preCarriagedBy!=null && data.hblBean.preCarriagedBy!='')
				   {
	        		$scope.mabl.preCarriagedBy = data.hblBean.preCarriagedBy.toString();

				    }
	    		   if(data.hblBean.destinationAgentCode!=null && data.hblBean.destinationAgentCode!='')
				   {
	        		$scope.mabl.destinationAgentCode = data.hblBean.destinationAgentCode.toString();

				    }
	    		   if(data.hblBean.currency!=null && data.hblBean.currency!='')
				   {
	        		$scope.mabl.currency = data.hblBean.currency.toString();

				    }
	    		   if(data.hblBean.containarized==false)
				   {
	        		$scope.mabl.containarized = "False";

				    }else{
		        		$scope.mabl.containarized = "True";

				    }
	    		   $scope.viewQuotation = function(jobNo) {
						debugger
							$location.url($stateParams.tenantid+'/jobOrderSea/view?rowid='+jobNo);
						
					}
	    		   
	    		   $scope.totalPackageCalculation();
	    		   $scope.totalnetWeightCalculation();
	    		   $scope.totalgrossWeightCalculation();
        		  $http.post($stateParams.tenantid+'/app/master/hbl/dropDownList').success(function(data) {
        	          	
                		$scope.vendorList=data.vendor;
                		$scope.customerList=data.customer;
                		$scope.termList=data.term;
                		$scope.destinationList=data.destination;
                		$scope.originList=data.origin;
                		$scope.branchList=data.branch;
                		$scope.podList=data.pod;
                		$scope.polList=data.pol;
                		$scope.movementList=data.movement;
                		$scope.preCarriageList=data.preCarriaged;
                		$scope.destinationAgentList=data.destinationAgent;	
                		$scope.currencyList=data.currency;
                		$scope.jobList=data.seaJob;
                		$scope.salesPersonList=data.salesPerson;
                		$scope.mblList=data.mbl;
                  		//$scope.sizeList=data.sizeList;
                  		$scope.iataList=data.iataList;
                  		//$scope.paymentList=data.paymentList;
                  		$scope.uomList=data.uom;                  	
                  		$scope.agentList=data.agentName;


                });	
	        	
	        	}else{
	        		logger.logError("Unable to fetch data");
	        	}
	        });
		}
		$http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(datas) {
									//$scope.containerNoList=datas.getcontainer;
									  $scope.sizeList=datas.getcontypelist;
								}).error(function(datas) {
								});
		 $http.get($stateParams.tenantid+'/app/seaquotation/getTerms').success(function(datas) {
			 $scope.paymentList = datas.commonUtilityBean;
		    
		}).error(function(data) {

		});
		
		//AGENT LIST
		
	/*	
		
	    $scope.getDropdownvalue = function() {
	        
	        $http.get($stateParams.tenantid+'/app/master/mabl/agentList').success(function(datas) {
	            $scope.agentList = datas;
	        }).error(function(datas) {
	        });

	    }
	    $scope.getDropdownvalue();
	  */
		
		
		
		
		
		
		
		
		
		
		
		
		 $scope.viewQuotation = function(jobNo) {
				debugger
					$location.url($stateParams.tenantid+'/jobOrderSea/view?rowid='+jobNo);
				
			}
		
	    $scope.$watchCollection('[ mabl.branch,mabl.pol,mabl.pod]', function(newValue, oldValue) {
       {
		   if($scope.isEdit==false){
    	   $scope.branchData= $scope.mabl.branch;
    	   $scope.polData= $scope.mabl.pol;
    	   $scope.podData= $scope.mabl.pod;
    	   if($scope.isEdit==false || $scope.podData!=$scope.pod || $scope.polData!=$scope.pol || $scope.branchData!=$scope.branch)
    		   {
        	   $scope.lMabljobDetailBean=[];

    	   if($scope.mabl.branch!=undefined && $scope.mabl.branch!=null && $scope.mabl.branch!="" && $scope.mabl.pol!=undefined && $scope.mabl.pol!=null && $scope.mabl.pol!="" && $scope.mabl.pod!=undefined && $scope.mabl.pod!=null && $scope.mabl.pod!="")
    		   {
   	        $http.post($stateParams.tenantid+'/app/master/mabl/getJobDetail?branchId='+$scope.branchData+'&pol='+$scope.polData+'&pod='+$scope.podData).success(function(data) {
             if(data.success==true)
            	 {
            	 if(data.lMabljobDetailBean.length !=0){
            	 
          	   $scope.jobDetail= true;
          	 $scope.s1 = false;

            	 $scope.lMabljobDetailBean=data.lMabljobDetailBean;
            	 }else{
            		 
            		 $scope.jobDetail= false;
            		 $scope.s1 = false;
            		 
            		 /*for(var i=0;i<$scope.podList.length;i++)
            			 {
            			 
            			 if($scope.podList[i].id=$scope.mabl.pod)
            				 {
            				 $scope.set=$scope.podList[i].text;
            			 }
            			 }*/
            		 $scope.lMablContainerBean='';
            		 $scope.t1=data.bean.pol;
            		 $scope.t2=data.bean1.pod;
            		 $scope.t3=data.bean2.branch;
            	 }
            	 }
             
   	        })
    		   
    	}
			   }
			}
       }
       })
       
       
       $scope.container = function(select,index)
       {
	    	//alert($scope.lMabljobDetailBean[index].jobNo);
	    	
	    	for (var i= $scope.lMabljobDetailBean.length-1;i>=0;i--)
	    		{
	    		var jobNo = $scope.lMabljobDetailBean[i].jobNo;
	    		if($scope.lMabljobDetailBean[i].select==true){
	    			 $http.post($stateParams.tenantid+'/app/master/mabl/getcontlist',$scope.lMabljobDetailBean).success(function(data) {
	 	            	if(data.success){
	 	            		console.log(data.lMablContainerBean);

	 	            		//$scope.lMablContainerBean.push(data.lMablContainerBean);
	 	            		$scope.lMablContainerBean=data.lMablContainerBean;
	 	            		if(data.lMablBean[0].consigneeAddress!=null){
	 	            			$scope.mabl.consigneeAddress=data.lMablBean[0].consigneeAddress;
	 	            		}
	 	            		
	 	            		$scope.mabl.placeofDelivery=data.lMablBean[0].placeofDelivery;
	 	            		$scope.mabl.placeofReceipt=data.lMablBean[0].placeofReceipt;
	 	            		$scope.mabl.portofDelivery=data.lMablBean[0].portofDelivery;
	 	            		$scope.mabl.portofDischarge=data.lMablBean[0].portofDischarge;
	 	            		$scope.mabl.portofLoad=data.lMablBean[0].portofLoad;
	 	            		$scope.mabl.shipperAddress =data.lMablBean[0].shipperAddress;
	 	            	}
	 	           	for(var j=$scope.lMablContainerBean.length-1 ;j>=0;j-- )
         			{
         		$scope.lMablContainerBean[j]=data.lMablContainerBean[j];
         		if(data.lMablContainerBean[j].size!=''&&data.lMablContainerBean[j].size!=null){
         			$scope.lMablContainerBean[j].size = data.lMablContainerBean[j].size.toString();
         		}
         		if(data.lMablContainerBean[j].uOm!=''&&data.lMablContainerBean[j].uOm!=null){
         			$scope.lMablContainerBean[j].uOm = data.lMablContainerBean[j].uOm.toString();
         		}
         		
         			}
	    		});
	    	
	    	
	    	
      }
	    		else
	    		{
	    			$scope.lMablContainerBean =[];
	    			$scope.mabl.consigneeAddress= '';
	    			$scope.mabl.placeofDelivery = '';
	    			$scope.mabl.placeofReceipt = '';
	    			$scope.mabl.portofDelivery= '';
	    			$scope.mabl.portofDischarge= '';
	    			$scope.mabl.portofLoad= '';
	    			$scope.mabl.shipperAddress= '';
	    			
	    		}
       }
       }
		
		/*
			 * $http.post($stateParams.tenantid+'/app/master/vendor/getMapDetail').success(function(data) {
			 * if(data.success){
			 * $scope.servicePartnerType=data.servicePartnerType; } });
			 */
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
        		$scope.destinationAgentList=data.destinationAgent;	
        		$scope.currencyList=data.currency;
        		$scope.jobList=data.seaJob;
        		$scope.salesPersonList=data.salesPerson;
        		$scope.mblList=data.mbl;
          //		$scope.sizeList=data.sizeList;
          		$scope.iataList=data.iataList;
          		$scope.paymentList=data.paymentList;
          		$scope.uomList=data.uom;
          		$scope.agentList=data.agentName;


        });
		$scope.save = function(mablForm){
			if (new validationService().checkFormValidity(mablForm)) {
	            var flag1 = true, flag2 = true, flag3 = true, flag4 = true, flag5 = true;

				if($scope.mabl.mblDocDate=="" || $scope.mabl.mblDocDate==undefined)
				{
				$scope.mabl.mblDocDate=null
				}
			
			if($scope.mabl.hblDocDate=="" || $scope.mabl.hblDocDate==undefined)
			{
			$scope.mabl.hblDocDate=null
			}
			if($scope.mabl.etaAtPod=="" || $scope.mabl.etaAtPod==undefined)
			{
			$scope.mabl.etaAtPod=null
			}
			if($scope.mabl.etd=="" || $scope.mabl.etd==undefined)
			{
			$scope.mabl.etd=null
			}
			if($scope.mabl.shipperAddress != null && $scope.mabl.shipperAddress != ''){
				 var text = $scope.mabl.shipperAddress;
		         text = text.replace(/\r?\n/g, '<br>');
	             $scope.mabl.shipperAddress=text;
			}
			if($scope.mabl.consigneeAddress != null  && $scope.mabl.consigneeAddress != '' ){
				 var text1 = $scope.mabl.consigneeAddress;
		         text1 = text1.replace(/\r?\n/g, '<br>');
	             $scope.mabl.consigneeAddress=text1;
			}
			for(var i=0;i<$scope.lMablContainerBean.length;i++){
				 if ($scope.lMablContainerBean[i].noofPackage != undefined && $scope.lMablContainerBean[i].noofPackage != null && $scope.lMablContainerBean[i].noofPackage != '') {
					 if (flag1 == true)
					 {
					 flag1 = validateNos($scope.lMablContainerBean[i].noofPackage);
					 }
		         }	
				 if ($scope.lMablContainerBean[i].uOm != undefined && $scope.lMablContainerBean[i].uOm != null && $scope.lMablContainerBean[i].uOm != '') {
					 if (flag2 == true)
					 {
					 flag2 = validateNos($scope.lMablContainerBean[i].uOm);
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
			}
			
			for(var i=0;i<$scope.lMablFreightBean.length;i++){
				 if ($scope.lMablFreightBean[i].amount != undefined && $scope.lMablFreightBean[i].amount != null && $scope.lMablFreightBean[i].amount != '') {
					 if (flag5 == true)
					 {
					 flag5 = validateDouble($scope.lMablFreightBean[i].amount);
					 }
		         }	
				
			}
			$scope.lMabljobDetailBean1=[];
			for(var i=0;i<$scope.lMabljobDetailBean.length;i++)
			{
			if($scope.lMabljobDetailBean[i].select==true)
			$scope.lMabljobDetailBean1.push($scope.lMabljobDetailBean[i]);
			}
				var obj = {
						hblBean : $scope.mabl,
						lMablFreightBean	: $scope.lMablFreightBean,
						lMablContainerBean	: $scope.lMablContainerBean,
						lMabljobDetailBean:$scope.lMabljobDetailBean1,

				}
				if($scope.lMabljobDetailBean1.length>0)
					{
				if (flag1 == true && flag2 == true && flag2 == true && flag3 == true && flag4 == true && flag5 == true) {

	            $http.post($stateParams.tenantid+'/app/master/mabl/save',obj).success(function(data) {
	            	if(data.success){
	            		logger.logSuccess('Saved Successfully');
	            		$scope.cancel();
	            	}else{
	            		logger.logError('Unable to save!');
	            	}
	            	
	            });
			}
			else {
                if (flag1 == false) {
                    logger.logError("Please Enter Number Value for No Of Package in Container Details");
                }
                if (flag2 == false) {
                    logger.logError("Please Enter Number Value for UOM in Container Details");
                }
                if (flag3 == false) {
                    logger.logError("Please Enter Number Value for NetWeight in Container Details");
                }
                if (flag4 == false) {
                    logger.logError("Please Enter Number Value for GrossWeight in Container Details");
                }
                if (flag5 == false) {
                    logger.logError("Please Enter Number Value for Amount in Freight Details");
                }
              
			}
					}
				else
				{
                    logger.logError("Job Details: Field is Required");

			
				}
			}else {
	            toaster.pop('error', "Please fill the required fields", 
	                    logger.getErrorHtmlNew(mablForm.$validationSummary), 5000, 'trustedHtml');
	        }
		}
		$scope.update = function(mablForm){
			if (new validationService().checkFormValidity(mablForm)) {
	            var flag1 = true, flag2 = true, flag3 = true, flag4 = true, flag5 = true;
	            if($scope.mabl.shipperAddress != null && $scope.mabl.shipperAddress != ''){
	      			 var text = $scope.mabl.shipperAddress;
	      	         text = text.replace(/\r?\n/g, '<br>');
	                   $scope.mabl.shipperAddress=text;
	      		}
	      		if($scope.mabl.consigneeAddress != null  && $scope.mabl.consigneeAddress != '' ){
	      			 var text1 = $scope.mabl.consigneeAddress;
	      	         text1 = text1.replace(/\r?\n/g, '<br>');
	                   $scope.mabl.consigneeAddress=text1;
	      		}

				if($scope.mabl.mblDocDate=="" || $scope.mabl.mblDocDate==undefined)
				{
				$scope.mabl.mblDocDate=null
				}
			
			if($scope.mabl.hblDocDate=="" || $scope.mabl.hblDocDate==undefined)
			{
			$scope.mabl.hblDocDate=null
			}
			if($scope.mabl.etaAtPod=="" || $scope.mabl.etaAtPod==undefined)
			{
			$scope.mabl.etaAtPod=null
			}
			if($scope.mabl.etd=="" || $scope.mabl.etd==undefined)
			{
			$scope.mabl.etd=null
			}
			for(var i=0;i<$scope.lMablContainerBean.length;i++){
				 if ($scope.lMablContainerBean[i].noofPackage != undefined && $scope.lMablContainerBean[i].noofPackage != null && $scope.lMablContainerBean[i].noofPackage != '') {
					 if (flag1 == true)
					 {
					 flag1 = validateNos($scope.lMablContainerBean[i].noofPackage);
					 }
		         }	
				 if ($scope.lMablContainerBean[i].uOm != undefined && $scope.lMablContainerBean[i].uOm != null && $scope.lMablContainerBean[i].uOm != '') {
					 if (flag2 == true)
					 {
					 flag2 = validateNos($scope.lMablContainerBean[i].uOm);
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
			}
			
			for(var i=0;i<$scope.lMablFreightBean.length;i++){
				 if ($scope.lMablFreightBean[i].amount != undefined && $scope.lMablFreightBean[i].amount != null && $scope.lMablFreightBean[i].amount != '') {
					 if (flag5 == true)
						 {
						 flag5 = validateDouble($scope.lMablFreightBean[i].amount);

						 }
		         }	
				
			}
			$scope.lMabljobDetailBean1=[];
			for(var i=0;i<$scope.lMabljobDetailBean.length;i++)
			{
			if($scope.lMabljobDetailBean[i].select==true)
			$scope.lMabljobDetailBean1.push($scope.lMabljobDetailBean[i]);
			}
				var obj = {
						hblBean : $scope.mabl,
						lMablFreightBean	: $scope.lMablFreightBean,
						lMablContainerBean	: $scope.lMablContainerBean,
						lMabljobDetailBean:$scope.lMabljobDetailBean1,


				}
				if($scope.lMabljobDetailBean1.length>0){
					
					
				
				if (flag1 == true && flag2 == true && flag2 == true && flag3 == true && flag4 == true && flag5 == true) {

	            $http.post($stateParams.tenantid+'/app/master/mabl/update',obj).success(function(data) {
	            	if(data.success){
	            		logger.logSuccess('Updated Successfully');
	            		if($scope.mabl.shipperAddress != null && $scope.mabl.shipperAddress != ''){
	             			 var text5 =$scope.mabl.shipperAddress;
	                          text5 = text5.replace(/\r?<br>/g, '\n');
	                          $scope.mabl.shipperAddress=text5;
	             		}
	             		if($scope.mabl.consigneeAddress != null  && $scope.mabl.consigneeAddress != '' ){
	             			 var text6 =$scope.mabl.consigneeAddress;
	                          text6 = text6.replace(/\r?<br>/g, '\n');
	                          $scope.mabl.consigneeAddress=text6;
	             		}
	            		$scope.cancel();
	            	}else{
	            		logger.logError('Unable to save!');
	            	}
	            	
	            });
			}
			else {
                if (flag1 == false) {
                    logger.logError("Please Enter Number Value for No Of Package in Container Details");
                }
                if (flag2 == false) {
                    logger.logError("Please Enter Number Value for UOM in Container Details");
                }
                if (flag3 == false) {
                    logger.logError("Please Enter Number Value for NetWeight in Container Details");
                }
                if (flag4 == false) {
                    logger.logError("Please Enter Number Value for GrossWeight in Container Details");
                }
                if (flag5 == false) {
                    logger.logError("Please Enter Number Value for Amount in Freight Details");
                }
              
            }
			}
				else
				{
				toaster.pop('error', "Please fill the required fields", 
	                    logger.getErrorHtmlNew("Job Details: Field is Required"), 5000, 'trustedHtml');
				}
			}
			
			else {
	            toaster.pop('error', "Please fill the required fields", 
	                    logger.getErrorHtmlNew(mablForm.$validationSummary), 5000, 'trustedHtml');
	        }
		}
		var mblNo = $location.search().rowid;

		 $scope.printRow = function() {
		 	   debugger
			        var url = $stateParams.tenantid+'/app/master/mabl/print?mablId=' + mblNo;
			        var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
			        wnd.print();   
			     }     
		 $scope.printManifest = function() {
		 	   debugger
			        console.log("Both print invoice")
			        var url = $stateParams.tenantid+'/app/master/mabl/printManifest?mablId=' + mblNo;
			        var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
			        wnd.print();   
			          }
		 $scope.printLoad = function(rowid) {
			   debugger
			        console.log("Both print invoice")
			        var url = $stateParams.tenantid+'/app/master/mabl/printLoad?mablId=' + mblNo;
			        var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
			        wnd.print();   
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
		 
		 $scope.showTax = function(mblNo){
	           
             if(mblNo !=""){
                 ngDialog.open({
                     scope : $scope,
                     template : 'views/sea/mabl/mablJobdetail',
                     controller : $controller('mablJobdetailCtrl', {
                         $scope : $scope,
                         mblNo :mblNo,
                         mablObject : $scope.mabl
                       //  accountHeadCode:accountHeadCode,
                        // jobNo:jobNo
                     }),
                     className : 'ngdialog-theme-plain',
                     showClose : false,
                     closeByDocument : false,
                     closeByEscape : false,
                     preCloseCallback : $scope.getList
                 });
             }else{
                 logger.logError("Please Enter Exchange Rate..");
             }
            
         
             
     }
		 app.controller('mablJobdetailCtrl', function($scope, $rootScope,sharedProperties, 
			        logger,$http,$filter, $location,$stateParams, validationService, toaster, $window,ngDialog, $timeout,mblNo) {
			    
				
				$http.get($stateParams.tenantid + '/app/master/mabl/edit?mablId='+mblNo ).success(
						function(response) {
							$scope.rowCollection=response.lMabljobDetailBean;
							//$scope.rowCollection = response.taxList;
						});
			    
				 $scope.cancelng = function(){
				        // $scope.purchaseInvoiceData.purInvDueDateDtls = [];
				        ngDialog.close();
				        if(mablObject.length>0){
				            
				        }else{
				            $scope.mablObject = [];
				        }
				    }
			});

		 $scope.reset=function(){
	         
	         if( $scope.isEdit == false){ 
	        	 $scope.lMablContainerBean =[];
	 		    $scope.lMablFreightBean =[];

	 		    $scope.mabl = {
	 		    		 jobNo:'',
	 		    		 type:'',
	 		    		 hblNo:'',
	 		    		 mblNo:'',
	 		    		 marksAndNos:'',
	 		    		 mbwDate:'',
	 		    		 hblDocNo:'',
	 		    		 hblDocDate:'',
	 		    		 mblDocNo:'',
	 		    		 mblDate:'',
	 		    		 mblDocDate:'',
	 		    		 vesselVoyeage:'',
	 		    		 feederVesselVoyeage:'',
	 		    		 vendor:'',
	 		    		 etd:'',
	 		    		 etaAtPod:'',
	 		    		 igmNo:'',
	 		    		 igmDate:'',
	 		    		 itemNo:'',
	 		    		 to:'',
	 		    		 doRemarks:'',
	 		    		 canRemarks:'',
	 		    		 branch:'',
	 		    		 pol:'',
	 		    		 pod:'',
	 		    		 term:'',
	 		    		 salesPerson:'',
	 		    		 vessel:'',
	 		    		 origin:'',
	 		    		 destination:'',
	 		    		 arrivalDate:'',
	 		    		 containerNo:'',
	 		    		 sealNo:'',
	 		    		 status:'',
	 		    		 measureMent:'',
	 		    		 remarks:'',
	 		    		 mablCargoDetailBin:'',
	 		    	     cargoDescription:'',
	 		    	     customerCode:'',
	 		    	     customer:'',
	 		    	     shipper:'',
	 		    		 size:'',
	 		    		 noofPackage:'',
	 		    		 uOm:'',
	 		    		 grossWeight:'',
	 		    		 netWeight:'',
	 		    		 consignee:'',
	 		    		 shipperAddress:'',
	 		    		 consigneeAddress:'',
	 		    		 notifyAddress:'',
	 		    		 placeofReceipt:'',
	 		    		 portofLoad:'',
	 		    		 portofDischarge:'',
	 		    		 portofDelivery:'',
	 		    		 placeofDelivery:'',
	 		    		 signedAt:'',
	 		    		 signedBy:'',
	 		    		 finalDestination:'',
	 		    		 forwardingAgentReferences:'',
	 		    		 containerNumber:'',
	 		    		 freightPayableAt:'',
	 		    		 noOfOriginalBl:'',
	 		    		 preCarriagedBy:'',
	 		    		 consolidationNumber:'',
	 		    		 exportReferences:'',
	 		    		 shipperReferences:'',
	 		    		 ftzNumber:'',
	 		    		 loadingPierTerminal:'',
	 		    		 coLoadedWith:'',
	 		    		 containarized:false,
	 		    	     destinationAgentCode:'',
	 		    	     currency:'',
	 		    	     cargoInsurance:'',
	 		    	     movement:'',
	 		    		 notify:'',
	 		    		 mblCode:'',
	 		    		 modifedBy:'',
	 		    		 modifedDate:'',
	 		    		 polCode:'',
	 		    		 podCode:'',
	 		    		 originCode:'',
	 		         };
	         }else {
	        	 $http.post($stateParams.tenantid+'/app/master/mabl/edit?mablId='+mblNo).success(function(data) {
	 	        	if(data.success){
	 	        		$scope.jobDetail=true;
	 	        		$scope.mabl = data.hblBean;
	 	        		$scope.lMablFreightBean=data.lMablFreightBean;
	 					$scope.lMablContainerBean=data.lMablContainerBean;
	 					$scope.lMabljobDetailBean=data.lMabljobDetailBean;
	 					$scope.mabl.vendor = data.hblBean.vendor;
	 	        		$scope.mabl.type = data.hblBean.type;
	 	        		$scope.mabl.pol = data.hblBean.pol;
	 	        		$scope.mabl.pod = data.hblBean.pod
	 	        		$scope.mabl.term = data.hblBean.term;
	 	        		$scope.mabl.customer = data.hblBean.customer;
	 	        		
	 	        		$scope.mabl.branch = data.hblBean.branch.toString();
	 	        		if($scope.mabl.shipperAddress==null){

						}
						else if($scope.mabl.shipperAddress != null && $scope.mabl.shipperAddress != ''){
	        			 var text5 =$scope.mabl.shipperAddress;
	                     text5 = text5.replace(/\r?<br>/g, '\n');
	                     $scope.mabl.shipperAddress=text5;
					}
					if(scope.mabl.consigneeAddress==null){

						}
						else
	        		if($scope.mabl.consigneeAddress != null  && $scope.mabl.consigneeAddress != '' ){
	        			 var text6 =$scope.mabl.consigneeAddress;
	                     text6 = text6.replace(/\r?<br>/g, '\n');
	                     $scope.mabl.consigneeAddress=text6;
	        		}
	                     for(var i=0;i<data.lMablFreightBean.length;i++) 
	                     	{
	                     	if(data.lMablFreightBean[i].paymentMode!=null&&data.lMablFreightBean[i].paymentMode!='')
	                     		{
	         					$scope.lMablFreightBean[i].paymentMode=data.lMablFreightBean[i].paymentMode.toString();

	                     		}

	                     	}
	                     for(var i=0;i<data.lMablContainerBean.length;i++) 
	                 	{
	                 	if(data.lMablContainerBean[i].size!=null&&data.lMablContainerBean[i].size!='')
	                 		{
	     					$scope.lMablContainerBean[i].size=data.lMablContainerBean[i].size.toString();

	                 		}
	                 	if(data.lMablContainerBean[i].uom!=null&&data.lMablContainerBean[i].uom!='')
                 		{
     					$scope.lMablContainerBean[i].uom=data.lMablContainerBean[i].uom.toString();

                 		}

	                 	}
	 	        		if(data.hblBean.origin!=null&&data.hblBean.origin!='')
	 	    			{
	 	        		$scope.mabl.origin = data.hblBean.origin.toString();

	 	    			}

	 	        		if(data.hblBean.destination!=null&&data.hblBean.destination!='')
	 	    			{
	 	        		$scope.mabl.destination = data.hblBean.destination.toString();

	 	    			}
	 	        		if(data.hblBean.salesPerson!=null&&data.hblBean.salesPerson!='')
	 	    			{
	 	        		$scope.mabl.salesPerson = data.hblBean.salesPerson.toString();

	 	    			}
	 	    		   if(data.hblBean.shipper!=null && data.hblBean.shipper!='')
	 				   {
	 	        		$scope.mabl.shipper = data.hblBean.shipper.toString();

	 				    }
	 	    		   if(data.hblBean.consignee!=null && data.hblBean.consignee!='')
	 				   {
	 	        		$scope.mabl.consignee = data.hblBean.consignee.toString();

	 				    }
	 	    		  
	 	    		
	 	    		   if(data.hblBean.movement!=null && data.hblBean.movement!='')
	 				   {
	 	        		$scope.mabl.movement = data.hblBean.movement.toString();

	 				    }
	 	    		   if(data.hblBean.cargoInsurance!=null && data.hblBean.cargoInsurance!='')
	 				   {
	 	        		$scope.mabl.cargoInsurance = data.hblBean.cargoInsurance.toString();

	 				    }
	 	    		   if(data.hblBean.preCarriagedBy!=null && data.hblBean.preCarriagedBy!='')
	 				   {
	 	        		$scope.mabl.preCarriagedBy = data.hblBean.preCarriagedBy.toString();

	 				    }
	 	    		   if(data.hblBean.destinationAgentCode!=null && data.hblBean.destinationAgentCode!='')
	 				   {
	 	        		$scope.mabl.destinationAgentCode = data.hblBean.destinationAgentCode.toString();

	 				    }
	 	    		   if(data.hblBean.currency!=null && data.hblBean.currency!='')
	 				   {
	 	        		$scope.mabl.currency = data.hblBean.currency.toString();

	 				    }
	 	    		   $scope.totalPackageCalculation();
	 	    		   $scope.totalnetWeightCalculation();
	 	    		   $scope.totalgrossWeightCalculation();
	         		  $http.post($stateParams.tenantid+'/app/master/hbl/dropDownList').success(function(data) {
	         	          	
	                 		$scope.vendorList=data.vendor;
	                 		$scope.customerList=data.customer;
	                 		$scope.termList=data.term;
	                 		$scope.destinationList=data.destination;
	                 		$scope.originList=data.origin;
	                 		$scope.branchList=data.branch;
	                 		$scope.podList=data.pod;
	                 		$scope.polList=data.pol;
	                 		$scope.movementList=data.movement;
	                 		$scope.preCarriageList=data.preCarriaged;
	                 		$scope.destinationAgentList=data.destinationAgent;	
	                 		$scope.currencyList=data.currency;
	                 		$scope.jobList=data.seaJob;
	                 		$scope.salesPersonList=data.salesPerson;
	                 		$scope.mblList=data.mbl;
	                   		//$scope.sizeList=data.sizeList;
	                   		$scope.iataList=data.iataList;
	                   		$scope.paymentList=data.paymentList;

	                 });	
	 	        	
	 	        	}else{
	 	        		logger.logError("Unable to fetch data");
	 	        	}
	 	        });
	         }
	     }
		
		 $scope.quickLinkMethd=function(qulkVal){
				if(qulkVal!='Select'){
					if($scope.mabl.mblNo!='' && $scope.mabl.mblNo!=undefined){
					$http.post($stateParams.tenantid + '/app/master/mabl/getQuickLinkId?category='+qulkVal+'&mablNo='+$scope.mabl.mblNo).success(function(datas) {
								if(datas.quickLinkId!=null){
									var rowid=datas.quickLinkId;
									if(qulkVal=="Job Order"){
										if(rowid !=0){
											$location.url($stateParams.tenantid+'/jobOrderSea/edit?rowid='+rowid);
											//$window.open('#'+$stateParams.tenantid+'/jobOrderSea/view?rowid='+rowid, '_blank');
										}else{
											logger.logError("There is no "+qulkVal);
										}
									}else if(qulkVal=="HBL"){
										if(rowid !=0){
											$location.url($stateParams.tenantid+'/hbl/edit?rowid='+rowid);
											//$window.open('#'+$stateParams.tenantid+'/hbl/view?rowid='+rowid, '_blank');	
										}else{
											logger.logError("There is no "+qulkVal);
										}
									}else if(qulkVal=="Delivery Order"){
										if(rowid !=0){
											$location.url($stateParams.tenantid+'/deliveryorder/edit?rowid='+rowid);
											//$window.open('#'+$stateParams.tenantid+'/deliveryorder/view?rowid='+rowid,'_blank');
										}else{
											logger.logError("There is no "+qulkVal);
										}
									}else if(qulkVal=="Sales Invoice"){
										if(rowid !=0){
											$location.url($stateParams.tenantid+'/invoice/seasalesinvoice/salesInvoiceView'+rowid);
											//$window.open('#'+$stateParams.tenantid+"/invoice/seasalesinvoice/salesInvoiceView/"+rowid,'_blank');
										}else{
											logger.logError("There is no "+qulkVal);
										}
									}else if(qulkVal=="Purchase Invoice"){
										if(rowid !=0){
											$location.url($stateParams.tenantid+'/invoice/seapurchaseinvoice/PurchaseInvoiceView'+rowid);
											//$window.open('#'+$stateParams.tenantid+"/invoice/seapurchaseinvoice/PurchaseInvoiceView/"+rowid,'_blank');	
										}else{
											logger.logError("There is no "+qulkVal);
										}
										
									}
								} else if(datas.quickLinkIdList!=null){
									var quickLinkIdList=datas.quickLinkIdList
									if(qulkVal=="Job Order"){
										 $window.open('#'+$stateParams.tenantid+'/seajoborder/list?rowid='+quickLinkIdList, '_blank');
									}else if(qulkVal=="HBL"){
										$window.open('#'+$stateParams.tenantid+'/hbl/list?rowid='+quickLinkIdList, '_blank');
									}else if(qulkVal=="Delivery Order"){
										$window.open('#'+$stateParams.tenantid+'/deliveryorder/list?quickLinkIdList='+quickLinkIdList, '_blank');
									}else if(qulkVal=="Sales Invoice"){
										$window.open('#'+$stateParams.tenantid+'/invoice/sea/seasalesinvoice/SalesInvoiceList?quickLinkIdList='+quickLinkIdList,'_blank');
									}else if(qulkVal=="Purchase Invoice"){
										$window.open('#'+$stateParams.tenantid+'/invoice/sea/seapurchaseinvoice/PurchaseInvoiceList?quickLinkIdList='+quickLinkIdList,'_blank');
									}
								}else{
									logger.logError("There is no "+qulkVal);
								}
								
					})
				}
			}
			}
		 $scope.remarks = function(id){
	         
		       
             ngDialog.open({
                 scope : $scope,
                 template : 'views/air/marksmabl',
                 controller : $controller('marksCtrl', {
                     $scope : $scope,
                   index:id,
                     //jobNo:jobNo
                 }),
                 className : 'ngdialog-theme-plain',
                 showClose : false,
                 closeByDocument : false,
                 closeByEscape : false,
                 preCloseCallback : $scope.getList
             });
         }
	 $scope.cargo = function(id){
         
	       
         ngDialog.open({
             scope : $scope,
             template : 'views/air/cargomabl',
             controller : $controller('cargoCtrl', {
                 $scope : $scope,
               index:id,
                 //jobNo:jobNo
             }),
             className : 'ngdialog-theme-plain',
             showClose : false,
             closeByDocument : false,
             closeByEscape : false,
             preCloseCallback : $scope.getList
         });
     }
		 
		 
});

app.controller('marksCtrl', function($scope, index,$rootScope,ngDialog) {
	$scope.dumCollection;
	$scope.mabl1 = {
			marksAndNos:'',	
			marksAndNosid:''
	};
	
          
	           $scope.cancelng = function(){
     	        
     	        ngDialog.close();
     	       
     	    }
            
             if($rootScope.condition == false){
             var test=$rootScope.test;
        	 angular.forEach(test,function(value,key){
        		 if(index == key){
        			 $scope.test  = value.marksAndNos;
            		 console.log($scope.test);
            		 var text5 =$scope.test;
            		 if(text5 != null && text5 != ''){
           			  text5 = text5.replace(/\r?<br>/g, '\n');
           		 }
            		 $scope.mabl1.marksAndNos = text5;	 
        		 }else{
        			 console.log(index);
        		 }
        		 
        	 })
             }
             else{
            	 //console.log($scope.lHablContainerBean);
            	 if(index ==$scope.lMablContainerBean[index].marksAndNosid){
            		 $scope.mabl1.marksAndNos=$scope.lMablContainerBean[index].marksAndNos;
            		 
            	 }
             }
             $scope.ok=function()
             {
            	 var text = $scope.mabl1.marksAndNos;
                 text = text.replace(/\r?\n/g, '<br>');
            	 $scope.lMablContainerBean[index].marksAndNos=text;
            	 $scope.lMablContainerBean[index].marksAndNosid=index;
            	 
            	
            	 ngDialog.close();
             }
	
});
app.controller('cargoCtrl', function($scope, index,$rootScope,ngDialog) {
	$scope.dumCollection;
	$scope.mabl2 = {
			cargoDescription:'',
			cargoDescriptionid:''
	};
		    $scope.cancelng = function(){
			ngDialog.close();
     	       
     	    }
            
             if($rootScope.condition == false){
            	 var test=$rootScope.test;
            	 angular.forEach(test,function(value,key){
            		 if(index == key){
            			 $scope.test  = value.cargoDescription;
                		 console.log($scope.test);
                		 var text5 =$scope.test;
                		 if(text5 != null && text5 != ''){
               			  text5 = text5.replace(/\r?<br>/g, '\n');
               		 }
                		 $scope.mabl2.cargoDescription = text5;	 
            		 }else{
            			 console.log(index);
            		 }
            		 
            	 })
             }else{
            	// console.log($scope.lMablContainerBean);
            	 if(index ==$scope.lMablContainerBean[index].cargoDescriptionid){
            		 $scope.mabl2.cargoDescription=$scope.lMablContainerBean[index].cargoDescription;
            		 
            	 }
            	 
             }
             $scope.ok=function()
             {
            	 var text = $scope.mabl2.cargoDescription;
                 text = text.replace(/\r?\n/g, '<br>');
              //   $scope.dischargeSum.admittedFor=text;
            	 $scope.lMablContainerBean[index].cargoDescription=text;
            	 $scope.lMablContainerBean[index].cargoDescriptionid=index;
            	 ngDialog.close();
             }
             
	
});

