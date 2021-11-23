'use strict';

app.controller('hblAddCtrl', function($scope, $rootScope, $http, $location, logger, ngDialog,
        utilsService,$state,sharedProperties,$window,$stateParams,toaster,validationService,$controller) {
//alert("test");
 $scope.displayedCollection = [];
 $rootScope.condition =true;
 $scope.dumCollection;
var date  = new Date();
var dateString =  date.getDate() + "/" + date.getMonth() + "/" + date.getFullYear() + " " + date.getHours() + ":" + date.getMinutes();
	$scope.rowCollectionFollowup=[];
    $scope.referralList=[];
    $scope.isEdit = false;
    $scope.tairDetailList =[];
	
	

    $scope.cancel = function() {
	  	  $state.go('app.sea.hbl.list',{tenantid:$stateParams.tenantid});
	  	  
	          
	    };
	    $scope.number="[0-9]+";
    
	    $scope.lHablContainerBean =[];
	    $scope.lHablFreightBean =[];

	    $scope.hbl = {
	    		 jobNo:'',
	    		 type:'',
	    		 hblNo:'',
	    		 mblNo:'',
	    		 marksAndNos:'',
	    		 hblDocNo:'',
	    		 hblDocDate:'',
	    		 mblDocNo:'',
	    		 mblDate:'',
	    		 mblDocDate:'',
	    		 vesselVoyeage:'',
	    		 agent:'',
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
	    	     cargoDescription:'',
	    	     customerCode:'',
	    	     customer:'',
	    	     shipper:'',
	    		 size:'',
	    		 noofPackage:'',
	    		 uOm:'',
	    		 containerBean:[],
	    		 temphablContainer:[],
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
	    		 containarized:'',
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
	    		 destionationCode:'',
	    		 hblCargoDetailBin:''
	         };
	    $scope.tempHablContainerBean = {
	    		selectBox 		:false,
	    		containerNo:'',
	    		sealNo:'',
	    		size:'',
	    		marksAndNos:'',	
	    		cargoDescription:'',
	    		nofPackage:'',	 
	    		uOm:'',	 
	    		netWeight:'',
	    		grossWeight:'',
	    		remarks:'',
	    		measureMent:'',
	    		hblContainerNo:'',
	    		
	    	};
		$scope.hbl.containerBean.push($scope.tempHablContainerBean);
		  $scope.tempMablFreightBean = {
				  	
					select 		:false,selection:'',
					chargeName:'',
					unit : '',
					transactionType : '1',
					quantity : '',
					rate : '',
					currency : '',
					exRate : '',
					buySellParty : '',
					jobStatus1 : '1',
					paymentMode:'',
					amount:'',
					print:'',	
					mblFreightNo:''
				};
		  
		 
	   /* $scope.lHablContainerBean =[];
	    $scope.lHablFreightBean =[];*/

		  

			 $scope.specialEmployeeFlag = false;
			 $scope.userId=$('#empId').val();

			 if( $scope.userId == 'E0002'|| $scope.userId =='E0003'|| $scope.userId == 'E0006'||$scope.userId == 'E0001' || $scope.userId=='E0016' || $scope.userId=='E0110'){
				 $scope.specialEmployeeFlag = true;
			 }
			 
		$scope.selectAllRec = function(table,selection) {
      debugger;
                   
          angular.forEach(table, function (value, key) {
              if (selection ==true) {
   	              value.select=true;
   	          }else{
   	           value.select=false;
   	          }
      });
     
     
  }  
  $scope.addCredRow = function() {
   
	  var tmp=angular.copy($scope.tempHablContainerBean);
		$scope.lHablContainerBean.push(tmp);

  }
 /* $scope.loadTable = function() {
      var table = {};
      table = {
    		  siNo: 1,
    		  containerNo:'',
	    		sealNo:'',
	    		size:'',
	    		marksAndNos:'',	
	    		cargoDescription:'',
	    		nofPackage:'',	 
	    		uOm:'',	 
	    		netWeight:'',
	    		grossWeight:'',
	    		remarks:'',
	    		measureMent:'',
	    		hblContainerNo:'',
       };

      $scope.hbl.temphablContainer.push(table);
      
  }
  $scope.loadTable();
  $scope.selectAll = function(table) {
      debugger;
      
          angular.forEach(table, function (value, key) {
       	   var check =value.select;
              if ($scope.tempHablContainerBean.selectBox ==true) {
   	              value.select=true;
   	             
              }else if($scope.tempHablContainerBean.selectBox ==false) {
           	   value.select=false;
              }
             // $scope.calAmt(tables);
      });
     
     
  };*/
  
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

	$scope.hbl.hblDate = dd + '/' + mm + '/'
			+ yyyy;
  
  
  $scope.cargoList =[{
	  id:'1',
	  text:'Covered',
  },
  {
  id:'2',
  text:'Not Covered',  
  
}];
  $scope.addCredRow();

	$scope.deleteCredRow =function(){
		ngDialog.openConfirm().then(function() {
		if($scope.isEdit==false){
			var tmpDelList = [];
			for(var i=$scope.lHablContainerBean.length-1;i>=0;i--){
				if($scope.lHablContainerBean[i].select==true){
					tmpDelList.push($scope.lHablContainerBean[i]);
					$scope.lHablContainerBean.splice(i, 1);
				}
			}
			logger.logSuccess('Deleted Successfully');
		}else if($scope.isEdit==true){
			var tmpDelList = [];
			for(var i=$scope.lHablContainerBean.length-1;i>=0;i--){
				if($scope.lHablContainerBean[i].select==true){
					tmpDelList.push($scope.lHablContainerBean[i]);
				}
			}
			$http.post($stateParams.tenantid+'/app/master/hbl/deleteContainerDetail',tmpDelList).success(function(data) {
	        	if(data.success){
	        		for(var i=$scope.lHablContainerBean.length-1;i>=0;i--){
	    				if($scope.lHablContainerBean[i].select==true){
	    					$scope.lHablContainerBean.splice(i, 1);
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
			$scope.lHablFreightBean.push(tmp);

	  }
	  $scope.addFreightRow();

		$scope.removeFreightRow =function(){
			ngDialog.openConfirm().then(function() {
			if($scope.isEdit==false){
				var tmpDelList = [];
				for(var i=$scope.lHablFreightBean.length-1;i>=0;i--){
					if($scope.lHablFreightBean[i].select==true){
						tmpDelList.push($scope.lHablFreightBean[i]);
						$scope.lHablFreightBean.splice(i, 1);
					}
				}
				logger.logSuccess('Deleted Successfully');
			}else if($scope.isEdit==true){
				var tmpDelList = [];
				for(var i=$scope.lHablFreightBean.length-1;i>=0;i--){
					if($scope.lHablFreightBean[i].select==true){
						tmpDelList.push($scope.lHablFreightBean[i]);
					}
				}
				$http.post($stateParams.tenantid+'/app/master/hbl/deleteFreightDetail',tmpDelList).success(function(data) {
		        	if(data.success){
		        		for(var i=$scope.lHablFreightBean.length-1;i>=0;i--){
		    				if($scope.lHablFreightBean[i].select==true){
		    					$scope.lHablFreightBean.splice(i, 1);
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
		 $scope.packageCalculation1 = function(noofPackage,
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
				var hablContainerBean = $scope.lHablContainerBean;
				var noofPackage = 0;
				$scope.checkIsNaN = function(value){
			        if(isNaN(value))
			            value = 0
			            
			        return value;
			    }
				angular.forEach(hablContainerBean, function(item, key) {
					var mablContainerBeanData = hablContainerBean[key];
					noofPackage = noofPackage + parseFloat(item.noofPackage);
					$scope.totalPackage = noofPackage;
					$scope.totalPackage=$scope.checkIsNaN($scope.totalPackage);
					
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
					var mablContainerBean = $scope.lHablContainerBean;
					var grossWeight = 0;
					$scope.checkIsNaN = function(value){
				        if(isNaN(value))
				            value = 0
				            
				        return value;
				    }
					
					angular.forEach(mablContainerBean, function(item, key) {
						var mablContainerBeanData = mablContainerBean[key];

						grossWeight = grossWeight + parseFloat(item.grossWeight);
						$scope.totalgrossWeight = grossWeight;
						$scope.totalgrossWeight=$scope.checkIsNaN($scope.totalgrossWeight);

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
						var mablContainerBean = $scope.lHablContainerBean;
						var netWeight=0;
						$scope.checkIsNaN = function(value){
					        if(isNaN(value))
					            value = 0
					            
					        return value;
					    }
						
						angular.forEach(mablContainerBean, function(item, key) {
							var mablContainerBeanData = mablContainerBean[key];

							netWeight = netWeight + parseFloat(item.netWeight);
							$scope.totalnetWeight = netWeight;
							$scope.totalnetWeight=$scope.checkIsNaN($scope.totalnetWeight);

						});

					}
		  
	var hblNo = $location.search().rowid;
	
	if(hblNo!=null && hblNo!=undefined && hblNo>0){
		$scope.isEdit=true;
		$rootScope.condition = false;
        $http.post($stateParams.tenantid+'/app/master/hbl/edit?hblId='+hblNo).success(function(data) {
        	if(data.success){
        		$scope.hbl = data.hblBean;
        		if($scope.hbl.shipperAddress != null && $scope.hbl.shipperAddress != ''){
        			 var text5 =$scope.hbl.shipperAddress;
                     text5 = text5.replace(/\r?<br>/g, '\n');
                     $scope.hbl.shipperAddress=text5;
        		}
        		if($scope.hbl.consigneeAddress != null  && $scope.hbl.consigneeAddress != '' ){
        			 var text6 =$scope.hbl.consigneeAddress;
                     text6 = text6.replace(/\r?<br>/g, '\n');
                     $scope.hbl.consigneeAddress=text6;
        		}
        		if($scope.hbl.notifyAddress != null  && $scope.hbl.notifyAddress != '' ){
         			 var text7 =$scope.hbl.notifyAddress;
         			text7 = text7.replace(/\r?<br>/g, '\n');
                      $scope.hbl.notifyAddress=text7;
         		}
        		$scope.oldJob=data.hblBean.jobNo;
        		$scope.lHablFreightBean=data.lhblFreightBean;
        		$scope.lHablContainerBean=data.lhblContainerBean;
        		$rootScope.test=data.lhblContainerBean;
        		if(data.hblBean.jobNo!=''&&data.hblBean.jobNo!=null){
        		$scope.hbl.jobNo = data.hblBean.jobNo.toString();
        		}
        		if(data.hblBean.mblNo!=''&&data.hblBean.mblNo!=null){
        		$scope.hbl.mblNo = data.hblBean.mblNo.toString();
        		}
        		if(data.hblBean.pol!=''&&data.hblBean.pol!=null){
        		$scope.hbl.pol = data.hblBean.pol.toString();
        		}
        		if(data.hblBean.pod!=''&&data.hblBean.pod!=null)
        			{
        		$scope.hbl.pod = data.hblBean.pod.toString();
        			}
        		if(data.hblBean.term!=''&&data.hblBean.term!=null){
        		$scope.hbl.term = data.hblBean.term.toString();
        		}
        		if(data.hblBean.customer!=''&&data.hblBean.customer!=null)
        			{
        		$scope.hbl.customer = data.hblBean.customer.toString();
        			}
        		if(data.hblBean.branch!=''&&data.hblBean.branch!=null){
        		$scope.hbl.branch = data.hblBean.branch.toString();
        		}
        		for(var i=0;i<data.lhblFreightBean.length;i++) 
        		{
             		$scope.lHablFreightBean[i].unit = $scope.lHablFreightBean[i].unit.toString();
             		$scope.lHablFreightBean[i].buySellParty = $scope.lHablFreightBean[i].buySellParty.toString();
             		$scope.lHablFreightBean[i].transactionType = $scope.lHablFreightBean[i].transactionType.toString();
             		$scope.lHablFreightBean[i].currency = $scope.lHablFreightBean[i].currency.toString();
             		$scope.lHablFreightBean[i].jobStatus1 = $scope.lHablFreightBean[i].jobStatus1.toString();
                	if(data.lhblFreightBean[i].paymentMode!=null && data.lhblFreightBean[i].paymentMode!='')
                		{
    					$scope.lHablFreightBean[i].paymentMode=data.lhblFreightBean[i].paymentMode.toString();

                		}
                	/*if(data.lhblFreightBean[i].print!=false)
            		{
					$scope.lHablFreightBean[i].print="False";

            		}else{
    					$scope.lHablFreightBean[i].print="True";

            		}*/

                	}
        		 for(var i=0;i<data.lhblContainerBean.length;i++) 
             	{
             	if(data.lhblContainerBean[i].size!=null && data.lhblContainerBean[i].size!='')
             		{
 					$scope.lHablContainerBean[i].size=data.lhblContainerBean[i].size.toString();

             		}
             	if(data.lhblContainerBean[i].uOm!=null && data.lhblContainerBean[i].uOm!='')
         		{
					$scope.lHablContainerBean[i].uOm=data.lhblContainerBean[i].uOm.toString();

         		}

             	}
        		if(data.hblBean.origin!=null&&data.hblBean.origin!='')
    			{
        		$scope.hbl.origin = data.hblBean.origin.toString();;

    			}

        		if(data.hblBean.destination!=null&&data.hblBean.destination!='')
    			{
        		$scope.hbl.destination = data.hblBean.destination.toString();;

    			}
        		if(data.hblBean.salesPerson!=null&&data.hblBean.salesPerson!='')
    			{
        		$scope.hbl.salesPerson = data.hblBean.salesPerson.toString();;

    			}
    		   if(data.hblBean.shipper!=null && data.hblBean.shipper!='')
			   {
        		$scope.hbl.shipper = data.hblBean.shipper.toString();;

			    }
    		   if(data.hblBean.consignee!=null && data.hblBean.consignee!='')
			   {
        		$scope.hbl.consignee = data.hblBean.consignee.toString();;

			    }
    		  
    		   if(data.hblBean.vendor!=null && data.hblBean.vendor!='')
			   {
        		$scope.hbl.vendor = data.hblBean.vendor.toString();;

			    }
    		   if(data.hblBean.movement!=null && data.hblBean.movement!='')
			   {
        		$scope.hbl.movement = data.hblBean.movement.toString();;

			    }
    		   if(data.hblBean.cargoInsurance!=null && data.hblBean.cargoInsurance!='')
			   {
        		$scope.hbl.cargoInsurance = data.hblBean.cargoInsurance.toString();;

			    }
    		   if(data.hblBean.preCarriagedBy!=null && data.hblBean.preCarriagedBy!='')
			   {
        		$scope.hbl.preCarriagedBy = data.hblBean.preCarriagedBy.toString();;

			    }
    		   if(data.hblBean.destinationAgentCode!=null && data.hblBean.destinationAgentCode!='')
			   {
        		$scope.hbl.destinationAgentCode= data.hblBean.destinationAgentCode.toString();;

			    }
    		   if(data.hblBean.currency!=null && data.hblBean.currency!='')
			   {
        		$scope.hbl.currency = data.hblBean.currency.toString();;

			    }
    		   
    		   if(data.hblBean.containarized==false)
			   {
        		$scope.hbl.containarized = "False";

			    }else{
	        		$scope.hbl.containarized = "True";

			    }
    		   
    		   $scope.totalPackageCalculation();
    		   $scope.totalnetWeightCalculation();
    		   $scope.totalgrossWeightCalculation();
    		   $http.post($stateParams.tenantid+'/app/seaquotation/getServicePartnerList').success(function(datas) {
    			   $scope.customerBuyList=datas.vendorMasterList;
    			   $scope.customerSellList=datas.serviceParnrList;
				}).error(function(data) {

				});
 			  $http.get($stateParams.tenantid+'/app/jobOrderSea/dropDownList').success(function(datas) {
					$scope.UnitList = datas.unitSelectivityList;
					$scope.transactionTypeList = datas.transactionSelectivityList;
					/*$scope.customerBuyList = datas.buyServiceList;
					$scope.customerSellList = datas.sellServiceList;*/
					$scope.currencylist= datas.currecnySelectivityList;
					$scope.chargeHeadList = datas.chargeHeadSelectivityList;
				}).error(function(data) {

				});
				$http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(datas) {
					$scope.containerNoList=datas.getcontainer;	  
					  $scope.sizeList=datas.getcontypelist;
				}).error(function(datas) {
				});
    		  $http.post($stateParams.tenantid+'/app/master/hbl/dropDownList').success(function(data) {
					 $scope.jobStatusListDtl=[];
						$scope.getStatus = function() {
						    var  data = {};
						    data["id"] = "1";
						    data["text"] = "PENDING";
						    $scope.jobStatusListDtl.push(data);
						    data = {};
						    data["id"] = "2";
						    data["text"] = "INVOICED";
						    $scope.jobStatusListDtl.push(data);  
						    data = {};
						    data["id"] = "3";
						    data["text"] = "DRAFT";
						    $scope.jobStatusListDtl.push(data);
						}
						$scope.getStatus();
  	          
  	          	$scope.vendorList=data.vendor;
          		$scope.customerList=data.customer;
          		$scope.agentList=data.agentName;
          		$scope.termList=data.term;
          		$scope.destinationList=data.destination;
          		$scope.originList=data.origin;
          		$scope.branchList=data.branch;
          		$scope.podList=data.pod;
          		$scope.polList=data.pol;
          		$scope.typeList=data.typeList;
          		$scope.movementList=data.movement;
          		$scope.preCarriageList=data.preCarriaged;
          		$scope.destinationAgentList=data.servicePartnerList;	
          		$scope.currencyList=data.currency;
          		$scope.jobList=data.seaJob;
          		$scope.salesPersonList=data.salesPerson;
          		$scope.mblList=data.mbl;
          	//	$scope.hblList=data.hbl;
          	//	$scope.sizeList=data.sizeList;
          		$scope.paymentList=data.paymentList;
          		//$scope.uomList=data.uom;

  	          });	
        	
        	}else{
        		logger.logError("Unable to fetch data");
        	}
        });
	}
	$http.post($stateParams.tenantid+'/app/jobOrderSea/dropDownList').success(function(data) {
		$scope.uomList=data.uomList;
	})
	
	$scope.oldJob='';
	$scope.$watch('hbl.addShipper', function(newValue,
			oldValue) {
		if (newValue == true) {
			ngDialog.open({
				scope : $scope,
				template : 'views/sea/hbl/addShipperPopup.jsp',
				controller : $controller('addShipperCtrl', {
					$stateParams : $stateParams,
					$scope : $scope,
					$http : $http,
					$location : $location,
					logger : logger,
					$state : $state,
					$window : $window,
					preCloseCallback : $scope.getList
				}),
				showClose : false,
				closeByDocument : false,
				closeByEscape : false
			});

		}

	});

	$scope.$watch('hbl.addConsignee', function(newValue,
			oldValue) {
		if (newValue == true) {
			ngDialog.open({
				scope : $scope,
				template : 'views/sea/hbl/addConsigPopup.jsp',
				controller : $controller('addShipperCtrl', {
					$stateParams : $stateParams,
					$scope : $scope,
					$http : $http,
					$location : $location,
					logger : logger,
					$state : $state,
					$window : $window,
					preCloseCallback : $scope.getList
				}),
				showClose : false,
				closeByDocument : false,
				closeByEscape : false
			});

		}

	});

	$scope.$watch('hbl.jobNo',function(newValue, oldValue) {
		if(newValue!=null && newValue!=undefined && newValue!="")
			{
			
			
				
				 $http.post($stateParams.tenantid+'/app/master/hbl/getJobDetail?jobId='+newValue).success(function(data) {
			        	if(data.success){
			        		$scope.hblList=data.hbl;
			        		if($scope.oldJob != newValue){
			        		$scope.lHablFreightBean=data.lhblFreightBean;
			        		$scope.lHablContainerBean=data.lhblContainerBean;
			        		$scope.hbl.vesselVoyeage = data.hblBean.vesselVoyeage.toString();
			        		$scope.hbl.jobNo = data.hblBean.jobNo.toString();
			        		$scope.hbl.pol = data.hblBean.pol.toString();
			        		$scope.hbl.pod = data.hblBean.pod.toString();
			        		$scope.hbl.term = data.hblBean.term.toString();
			        		$scope.hbl.origin = data.hblBean.origin.toString();
			        		$scope.hbl.destination = data.hblBean.destination.toString();
			        		$scope.hbl.branch = data.hblBean.branch.toString();
			        		$scope.hbl.customer = data.hblBean.customer.toString();
			        		if(data.hblBean.consignee==null){
			        		}else{
			        			$scope.hbl.consignee = data.hblBean.consignee.toString();
			        		}
			        		if(data.hblBean.shipper==null){
			        		}else{
			        			$scope.hbl.shipper = data.hblBean.shipper.toString();
			        		}
			        		$scope.hbl.consigneeAddress=data.lhblContainer[0].consigneeAddress;
			        		$scope.hbl.shipperAddress=data.lhblContainer[0].shipperAddress;
			        		$scope.hbl.placeofReceipt=data.lhblContainer[0].placeofReceipt;
			        		$scope.hbl.portofLoad=data.lhblContainer[0].portofLoad;
			        		$scope.hbl.portofDischarge=data.lhblContainer[0].portofDischarge;
			        		$scope.hbl.portofDelivery=data.lhblContainer[0].portofDelivery;
			        		$scope.hbl.placeofDelivery=data.lhblContainer[0].placeofDelivery;
			        		$scope.hbl.finalDestination=data.lhblContainer[0].finalDestination;
			        		for(var i=0;i<data.lhblFreightBean.length;i++) 
			        		{
		                 		$scope.lHablFreightBean[i].unit = $scope.lHablFreightBean[i].unit.toString();
		                 		$scope.lHablFreightBean[i].buySellParty = $scope.lHablFreightBean[i].buySellParty.toString();
		                 		$scope.lHablFreightBean[i].transactionType = $scope.lHablFreightBean[i].transactionType.toString();
		                 		$scope.lHablFreightBean[i].currency = $scope.lHablFreightBean[i].currency.toString();
		                 		$scope.lHablFreightBean[i].jobStatus1 = $scope.lHablFreightBean[i].jobStatus1.toString();
			                	if(data.lhblFreightBean[i].paymentMode!=null && data.lhblFreightBean[i].paymentMode!='')
			                		{
			    					$scope.lHablFreightBean[i].paymentMode=data.lhblFreightBean[i].paymentMode.toString();
			                		}

			                	}
			        		for(var j=$scope.lHablContainerBean.length-1 ;j>=0;j-- )
			     			{
			     		$scope.lHablContainerBean[j]=data.lhblContainerBean[j];
			     		$scope.lHablContainerBean[j].size = data.lhblContainerBean[j].size.toString();
			     		$scope.lHablContainerBean[j].uOm = data.lhblContainerBean[j].uOm.toString();
			     			}
			        		
			     		   $scope.totalPackageCalculation();
			     		   $scope.totalnetWeightCalculation();
			     		   $scope.totalgrossWeightCalculation();
			        		if(data.hblBean.vendor!=null)
			        			{
			            		$scope.hbl.vendor = data.hblBean.vendor.toString();

			        			}

			        		//$scope.hbl.salesperson = data.hblBean.salesperson.toString();

			        	
			        		
			    		   if(data.hblBean.currency!=null && data.hblBean.currency!='')
						   {
			        		$scope.hbl.currency = data.hblBean.currency.toString();;

						    }
			    		   $http.post($stateParams.tenantid+'/app/seaquotation/getServicePartnerList').success(function(datas) {
			    			   $scope.customerBuyList=datas.vendorMasterList;
			    			   $scope.customerSellList=datas.serviceParnrList;
							}).error(function(data) {

							});
			    			  $http.get($stateParams.tenantid+'/app/jobOrderSea/dropDownList').success(function(datas) {
									$scope.UnitList = datas.unitSelectivityList;
									$scope.transactionTypeList = datas.transactionSelectivityList;
									/*$scope.customerBuyList = datas.buyServiceList;
									$scope.customerSellList = datas.sellServiceList;*/
									$scope.currencylist= datas.currecnySelectivityList;
									$scope.chargeHeadList = datas.chargeHeadSelectivityList;
								}).error(function(data) {

								});
								$http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(datas) {
									$scope.containerNoList=datas.getcontainer;
									  $scope.sizeList=datas.getcontypelist;
								}).error(function(datas) {
								});
							
			    		  $http.post($stateParams.tenantid+'/app/master/hbl/dropDownList').success(function(data) {
								 $scope.jobStatusListDtl=[];
									$scope.getStatus = function() {
									    var  data = {};
									    data["id"] = "1";
									    data["text"] = "PENDING";
									    $scope.jobStatusListDtl.push(data);
									    data = {};
									    data["id"] = "2";
									    data["text"] = "INVOICED";
									    $scope.jobStatusListDtl.push(data);  
									    data = {};
									    data["id"] = "3";
									    data["text"] = "DRAFT";
									    $scope.jobStatusListDtl.push(data);
									}
									$scope.getStatus();
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
			          		$scope.destinationAgentList=data.servicePartnerList;	
			          		$scope.currencyList=data.currency;
			          		$scope.jobList=data.seaJob;
			          		$scope.salesPersonList=data.salesPerson;
			          		$scope.mblList=data.mbl;
			          	//	$scope.hblList=data.hbl;
			          	//	$scope.sizeList=data.sizeList;
			          		//$scope.uomList=data.uom;

			  	          });
			        	
			        	}
			        		if(($scope.hbl.consignee!=null && $scope.hbl.consignee!='') || ($scope.hbl.shipper!=null && $scope.hbl.shipper!='')){
			        		  $http.get($stateParams.tenantid+'/app/jobOrderSea/consigShipper?consignee='+$scope.hbl.consignee+'&shipper='+$scope.hbl.shipper).success(function(datas) {
			        			  $scope.hbl.shipperAddress=datas.code;
			        			  $scope.hbl.consigneeAddress=datas.customer;

			        		  })
			        		}
				 }else{
			        		logger.logError("Unable to fetch data");
			        	}
			        });
			//}
			
       
			}
	})
	  /*$http.post($stateParams.tenantid+'/app/master/vendor/getMapDetail').success(function(data) {
      	if(data.success){
      		$scope.servicePartnerType=data.servicePartnerType;
      	}
      });*/
	$http.post($stateParams.tenantid+'/app/jobOrderSea/dropDownList').success(function(data) {
		$scope.uomList=data.uomList;
	})
	   $http.post($stateParams.tenantid+'/app/seaquotation/getServicePartnerList').success(function(datas) {
		   $scope.customerBuyList=datas.vendorMasterList;
		   $scope.customerSellList=datas.serviceParnrList;
		}).error(function(data) {

		});
	  $http.get($stateParams.tenantid+'/app/jobOrderSea/dropDownList').success(function(datas) {
			$scope.UnitList = datas.unitSelectivityList;
			$scope.transactionTypeList = datas.transactionSelectivityList;
			/*$scope.customerBuyList = datas.buyServiceList;
			$scope.customerSellList = datas.sellServiceList;*/
			$scope.currencylist= datas.currecnySelectivityList;
			$scope.chargeHeadList = datas.chargeHeadSelectivityList;
		}).error(function(data) {

		});
		$http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(datas) {
			$scope.containerNoList=datas.getcontainer;
			  $scope.sizeList=datas.getcontypelist;
		}).error(function(datas) {
		});
	  $http.post($stateParams.tenantid+'/app/master/hbl/dropDownList').success(function(data) {
			 $scope.jobStatusListDtl=[];
				$scope.getStatus = function() {
				    var  data = {};
				    data["id"] = "1";
				    data["text"] = "PENDING";
				    $scope.jobStatusListDtl.push(data);
				    data = {};
				    data["id"] = "2";
				    data["text"] = "INVOICED";
				    $scope.jobStatusListDtl.push(data);  
				    data = {};
				    data["id"] = "3";
				    data["text"] = "DRAFT";
				    $scope.jobStatusListDtl.push(data);
				}
				$scope.getStatus();
          	
          		$scope.vendorList=data.vendor;
          		$scope.customerList=data.customer;
          		$scope.agentList=data.agentName;
          		$scope.termList=data.term;
          		$scope.destinationList=data.destination;
          		$scope.originList=data.origin;
          		$scope.branchList=data.branch;
          		$scope.podList=data.pod;
          		$scope.polList=data.pol;
          		$scope.typeList=data.typeList;
          		$scope.movementList=data.movement;
          		$scope.preCarriageList=data.preCarriaged;
          		$scope.destinationAgentList=data.servicePartnerList;	
          		$scope.currencyList=data.currency;
          		$scope.jobList=data.seaJob;
          		$scope.salesPersonList=data.salesPerson;
          		$scope.mblList=data.mbl;
          		//$scope.hblList=data.hbl;
          		//$scope.sizeList=data.sizeList;
          		$scope.paymentList=data.paymentList;
          		//$scope.uomList=data.uom;

          });
	  $http.post($stateParams.tenantid+'/app/jobOrderSea/dropDownList').success(function(data) {
			$scope.uomList=data.uomList;
		})
	$scope.save = function(servicePartnerAddForm){
		$scope.test = $scope.dumCollection;
	
		
		if (new validationService().checkFormValidity(servicePartnerAddForm)) {
            var flag1 = true, flag2 = true, flag3 = true, flag4 = true, flag5 = true,
            lengthFlag = false;

			if($scope.hbl.mblDocDate=="" || $scope.hbl.mblDocDate==undefined)
			{
			$scope.hbl.mblDocDate=null
			}
	
		if($scope.hbl.hblDocDate=="" || $scope.hbl.hblDocDate==undefined)
		{
		$scope.hbl.hblDocDate=null
		}
		if($scope.hbl.etaAtPod=="" || $scope.hbl.etaAtPod==undefined)
		{
		$scope.hbl.etaAtPod=null
		}
		if($scope.hbl.etd=="" || $scope.hbl.etd==undefined)
		{
		$scope.hbl.etd=null
		}

		if($scope.hbl.shipperAddress != null && $scope.hbl.shipperAddress != ''){
			 var text = $scope.hbl.shipperAddress;
	         text = text.replace(/\r?\n/g, '<br>');
	         var res = text.replace("–", "-");
             $scope.hbl.shipperAddress=res;
		}
		if($scope.hbl.consigneeAddress != null  && $scope.hbl.consigneeAddress != '' ){
			 var text1 = $scope.hbl.consigneeAddress;
	         text1 = text1.replace(/\r?\n/g, '<br>');
	         var res1 = text1.replace("–", "-");
             $scope.hbl.consigneeAddress=res1;
		}
		if($scope.hbl.notifyAddress != null  && $scope.hbl.notifyAddress != '' ){
			 var text2 = $scope.hbl.notifyAddress;
	         text2 = text2.replace(/\r?\n/g, '<br>');
	         var res2 = text2.replace("–", "-");
            $scope.hbl.notifyAddress=res2;
		}
		
		if($scope.lHablContainerBean.length>0){
			
			for(var i=0;i<$scope.lHablContainerBean.length;i++){
				
			if ($scope.lHablContainerBean[i].select== true )
			 {
				   lengthFlag=true;
					 
			 }
			 }
			
			
		}else{
			
			lengthFlag=false;
		}
				
	
		for(var i=0;i<$scope.lHablContainerBean.length;i++){
			 if ($scope.lHablContainerBean[i].nofPackage != undefined && $scope.lHablContainerBean[i].nofPackage != null && $scope.lHablContainerBean[i].nofPackage != '') {
	             if(flag1==true)
	            	 {
					 flag1 = validateNos($scope.lHablContainerBean[i].nofPackage);

	            	 }
	         }	
			 if ($scope.lHablContainerBean[i].uOm != undefined && $scope.lHablContainerBean[i].uOm != null && $scope.lHablContainerBean[i].uOm != '') {
	            if(flag2==true)
	            	{
					 flag2 = validateNos($scope.lHablContainerBean[i].uOm);

	            	}
	         }
			 if ($scope.lHablContainerBean[i].netWeight != undefined && $scope.lHablContainerBean[i].netWeight != null && $scope.lHablContainerBean[i].netWeight != '') {
				 if(flag3==true)
	            	{
				 flag3 =validateDouble($scope.lHablContainerBean[i].netWeight);
	            	}
	         }
			 if ($scope.lHablContainerBean[i].grossWeight != undefined && $scope.lHablContainerBean[i].grossWeight != null && $scope.lHablContainerBean[i].grossWeight != '') {
				 if(flag4==true)
	            	{
				 flag4 = validateDouble($scope.lHablContainerBean[i].grossWeight);
	            	}
	         }
		}
		
		for(var i=0;i<$scope.lHablFreightBean.length;i++){
			 if ($scope.lHablFreightBean[i].chargeName != undefined && $scope.lHablFreightBean[i].chargeName != null && $scope.lHablFreightBean[i].chargeName != '') {
				 if(flag5==true)
	            	{
				 flag5 = validateDouble($scope.lHablFreightBean[i].chargeName);
	            	}
	         }	
			 if ($scope.lHablFreightBean[i].unit != undefined && $scope.lHablFreightBean[i].unit != null && $scope.lHablFreightBean[i].unit != '') {
				 if(flag5==true)
	            	{
				 flag5 = validateDouble($scope.lHablFreightBean[i].unit);
	            	}
	         }	
			 if ($scope.lHablFreightBean[i].transactionType != undefined && $scope.lHablFreightBean[i].transactionType != null && $scope.lHablFreightBean[i].transactionType != '') {
				 if(flag5==true)
	            	{
				 flag5 = validateDouble($scope.lHablFreightBean[i].transactionType);
	            	}
	         }	
			 if ($scope.lHablFreightBean[i].quantity != undefined && $scope.lHablFreightBean[i].quantity != null && $scope.lHablFreightBean[i].quantity != '') {
				 if(flag5==true)
	            	{
				 flag5 = validateDouble($scope.lHablFreightBean[i].quantity);
	            	}
	         }	
			 if ($scope.lHablFreightBean[i].rate != undefined && $scope.lHablFreightBean[i].rate != null && $scope.lHablFreightBean[i].rate != '') {
				 if(flag5==true)
	            	{
				 flag5 = validateDouble($scope.lHablFreightBean[i].rate);
	            	}
	         }	
			 if ($scope.lHablFreightBean[i].currency != undefined && $scope.lHablFreightBean[i].currency != null && $scope.lHablFreightBean[i].currency != '') {
				 if(flag5==true)
	            	{
				 flag5 = validateDouble($scope.lHablFreightBean[i].currency);
	            	}
	         }	
			 if ($scope.lHablFreightBean[i].exRate != undefined && $scope.lHablFreightBean[i].exRate != null && $scope.lHablFreightBean[i].exRate != '') {
				 if(flag5==true)
	            	{
				 flag5 = validateDouble($scope.lHablFreightBean[i].exRate);
	            	}
	         }	
			 if ($scope.lHablFreightBean[i].amount != undefined && $scope.lHablFreightBean[i].amount != null && $scope.lHablFreightBean[i].amount != '') {
				 if(flag5==true)
	            	{
				 flag5 = validateDouble($scope.lHablFreightBean[i].amount);
	            	}
	         }	
			 if ($scope.lHablFreightBean[i].buySellParty != undefined && $scope.lHablFreightBean[i].buySellParty != null && $scope.lHablFreightBean[i].buySellParty != '') {
				 if(flag5==true)
	            	{
				 flag5 = validateDouble($scope.lHablFreightBean[i].buySellParty);
	            	}
	         }	
			 if ($scope.lHablFreightBean[i].jobStatus1 != undefined && $scope.lHablFreightBean[i].jobStatus1 != null && $scope.lHablFreightBean[i].jobStatus1 != '') {
				 if(flag5==true)
	            	{
				 flag5 = validateDouble($scope.lHablFreightBean[i].jobStatus1);
	            	}
	         }	
			
		}
			var obj = {
					hblBean : $scope.hbl,
					lhblContainerBean	: $scope.lHablContainerBean,
					lhblFreightBean :$scope.lHablFreightBean,
			}
			if (flag1 == true && flag2 == true && flag2 == true && flag3 == true && flag4 == true && flag5 == true&&lengthFlag== true) {
            $http.post($stateParams.tenantid+'/app/master/hbl/save',obj).success(function(data) {
            	if(data.success){
            		logger.logSuccess('Saved Successfully');
                	$location.url($stateParams.tenantid+'/hbl/edit?rowid='+data.id);       

            	//	$scope.cancel();
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
                if (lengthFlag == false) {
                    logger.logError("Please select atleast one Container");
                }
              
            }
		}
		
		else {
            toaster.pop('error', "Please fill the required fields", 
                    logger.getErrorHtmlNew(servicePartnerAddForm.$validationSummary), 5000, 'trustedHtml');
        }
		

	}
	   $scope.checkValidation = function() {

	  	    var alertmsg = "<ui><h4>Please fill the required fields</h4>";
	  	    var msg = "";
	  	  /*  if ($scope.checkundefined($scope.quotation.commodity)) {
	  	        msg = msg + "<li>Commodity:Field is required.</li>";         
	  	        $scope.changecolor('commodity');
	  	    }else{
	  	    	$scope.clearcolor('commodity');
	  	    }*/
	  	    if ($scope.checkundefined($scope.hbl.jobNo)) {
	  	        msg = msg + "<li>jobNo:Field is required.</li>";         
	  	        $scope.changecolor('jobNo');
	  	    }else{
	  	    	$scope.clearcolor('jobNo');
	  	    }
	  	    if ($scope.checkundefined($scope.hbl.pol)) {
	  	        msg = msg + "<li>pol:Field is required.</li>";         
	  	        $scope.changecolor('pol');
	  	    }else{
	  	    	$scope.clearcolor('pol');
	  	    }
	  	    if ($scope.checkundefined($scope.hbl.pod)) {
	  	        msg = msg + "<li>pod:Field is required.</li>";         
	  	        $scope.changecolor('pod');
	  	    }else{
	  	    	$scope.clearcolor('pod');
	  	    }
	  	    if ($scope.checkundefined($scope.hbl.mblNo)) {
	  	        msg = msg + "<li>mblNo:Field is required.</li>";         
	  	        $scope.changecolor('mblNo');
	  	    }else{
	  	    	$scope.clearcolor('mblNo');
	  	    }
	  	    if ($scope.checkundefined($scope.hbl.branch)) {
	  	        msg = msg + "<li>branch:Field is required.</li>";         
	  	        $scope.changecolor('branch');
	  	    }else{
	  	    	$scope.clearcolor('branch');
	  	    }
	  	    if ($scope.checkundefined($scope.hbl.customer)) {
	  	        msg = msg + "<li>customer:Field is required.</li>";         
	  	        $scope.changecolor('customer');
	  	    }else{
	  	    	$scope.clearcolor('customer');
	  	    }
	  	  if ($scope.checkundefined($scope.hbl.term)) {
	  	        msg = msg + "<li>term:Field is required.</li>";         
	  	        $scope.changecolor('term');
	  	    }else{
	  	    	$scope.clearcolor('term');
	  	    }
	  	/* if ($scope.checkundefined($scope.hbl.customer)) {
	  	        msg = msg + "<li>customer:Field is required.</li>";         
	  	        $scope.changecolor('customer');
	  	    }else{
	  	    	$scope.clearcolor('customer');
	  	    }
	  	 if ($scope.checkundefined($scope.hbl.customer)) {
	  	        msg = msg + "<li>customer:Field is required.</li>";         
	  	        $scope.changecolor('customer');
	  	    }else{
	  	    	$scope.clearcolor('customer');
	  	    }*/
	  	   
	  	    
	  	    
	  	  	    angular.forEach($scope.quotation.quotationDtl, function(chargesDetail, index) {/*     
	  	        if ($scope.checkundefined(chargesDetail.chargeHeads)) {
	  	            msg = msg + "<li>Row :" + (index + 1) + "# Charge Heads :Field is required.</li>";
	  	            $scope.changecolor('chargeHeads'+index);
	  	        }else{
	  	        	$scope.clearcolor('chargeHeads'+index);
	  	        }
	  	        if ($scope.checkundefined(chargesDetail.unit)) {
	  	            msg = msg + "<li>Row :" + (index + 1) + "# Unit :Field is required.</li>";
	  	            $scope.changecolor('unit'+index);
	  	        }else{
	  	        	$scope.clearcolor('unit'+index);
	  	        }
	  	        if ($scope.checkundefined(chargesDetail.qty)) {
	  	            msg = msg + "<li>Row :" + (index + 1) + "# Quantity :Field is required.</li>";
	  	            $scope.changecolor('qty'+index);
	  	            $('#qty'+index).find('input').css("border-color", "red");

	  	        }  else{
	  	        	$('#qty'+index).find('input').css("border-color", "#e8dddd");
	  	        }
	  	        if ($scope.checkundefined(chargesDetail.rate)) {
	  	            msg = msg + "<li>Row :" + (index + 1) + "# Rate :Field is required.</li>";
	  	        }  
	  	        if ($scope.checkundefined(chargesDetail.paymentMethod)) {
	  	            msg = msg + "<li>Row :" + (index + 1) + "# Payment Method :Field is required.</li>";
	  	        }  
	  	        if ($scope.checkundefined(chargesDetail.currency)) {
	  	            msg = msg + "<li>Row :" + (index + 1) + "# Currency :Field is required.</li>";
	  	        }  
	  	        if ($scope.checkundefined(chargesDetail.transactionType)) {
	  	            msg = msg + "<li>Row :" + (index + 1) + "# Transaction Type :Field is required.</li>";
	  	        }  
	  	        if ($scope.checkundefined(chargesDetail.buySell)) {
	  	            msg = msg + "<li>Row :" + (index + 1) + "# Buy Sell:Field is required.</li>";
	  	        }  
	  	        
	  	        
	  	        
	  	    */});
	  	    alertmsg = alertmsg + msg + "</ui>";
	  	    if ($scope.checkundefined(msg)) {
	  	        return '';
	  	    } else {
	  	        return alertmsg;
	  	    }

	  	}
	$scope.update = function(servicePartnerAddForm){
		if (new validationService().checkFormValidity(servicePartnerAddForm)) {
            var flag1 = true, flag2 = true, flag3 = true, flag4 = true, flag5 = true;

            if($scope.hbl.shipperAddress != null && $scope.hbl.shipperAddress != ''){
   			 var text = $scope.hbl.shipperAddress;
   	         text = text.replace(/\r?\n/g, '<br>');
   	      var res = text.replace("–", "-");
                $scope.hbl.shipperAddress=res;
   		}
   		if($scope.hbl.consigneeAddress != null  && $scope.hbl.consigneeAddress != '' ){
   			 var text1 = $scope.hbl.consigneeAddress;
   	         text1 = text1.replace(/\r?\n/g, '<br>');
   	      var res1 = text1.replace("–", "-");
                $scope.hbl.consigneeAddress=res1;
   		}
   		if($scope.hbl.notifyAddress != null  && $scope.hbl.notifyAddress != '' ){
  			 var text2 = $scope.hbl.notifyAddress;
  	         text2 = text2.replace(/\r?\n/g, '<br>');
  	       var res2 = text2.replace("–", "-");
               $scope.hbl.notifyAddress=res2;
  		}
   		
   		
			for(var i=0;i<$scope.lHablContainerBean.length;i++){
				if (flag1 == true)
					{
					 if ($scope.lHablContainerBean[i].nofPackage != undefined && $scope.lHablContainerBean[i].nofPackage != null && $scope.lHablContainerBean[i].nofPackage != '') {
			             flag1 = validateNos($scope.lHablContainerBean[i].nofPackage);
			         }
					}
				if (flag2 == true)
				{
				 if ($scope.lHablContainerBean[i].uOm != undefined && $scope.lHablContainerBean[i].uOm != null && $scope.lHablContainerBean[i].uOm != '') {
		             flag2 = validateNos($scope.lHablContainerBean[i].uOm);
		         }
				}
				if (flag3 == true)
				{
				 if ($scope.lHablContainerBean[i].netWeight != undefined && $scope.lHablContainerBean[i].netWeight != null && $scope.lHablContainerBean[i].netWeight != '') {
		             flag3 = validateDouble($scope.lHablContainerBean[i].netWeight);
		         }
				}
				if (flag4 == true)
				{
				 if ($scope.lHablContainerBean[i].grossWeight != undefined && $scope.lHablContainerBean[i].grossWeight != null && $scope.lHablContainerBean[i].grossWeight != '') {
		             flag4 = validateDouble($scope.lHablContainerBean[i].grossWeight);
		         }
				}
			}
			
			for(var i=0;i<$scope.lHablFreightBean.length;i++){
				 if ($scope.lHablFreightBean[i].chargeName != undefined && $scope.lHablFreightBean[i].chargeName != null && $scope.lHablFreightBean[i].chargeName != '') {
					 if(flag5==true)
		            	{
					 flag5 = validateDouble($scope.lHablFreightBean[i].chargeName);
		            	}
		         }	
				 if ($scope.lHablFreightBean[i].unit != undefined && $scope.lHablFreightBean[i].unit != null && $scope.lHablFreightBean[i].unit != '') {
					 if(flag5==true)
		            	{
					 flag5 = validateDouble($scope.lHablFreightBean[i].unit);
		            	}
		         }	
				 if ($scope.lHablFreightBean[i].transactionType != undefined && $scope.lHablFreightBean[i].transactionType != null && $scope.lHablFreightBean[i].transactionType != '') {
					 if(flag5==true)
		            	{
					 flag5 = validateDouble($scope.lHablFreightBean[i].transactionType);
		            	}
		         }	
				 if ($scope.lHablFreightBean[i].quantity != undefined && $scope.lHablFreightBean[i].quantity != null && $scope.lHablFreightBean[i].quantity != '') {
					 if(flag5==true)
		            	{
					 flag5 = validateDouble($scope.lHablFreightBean[i].quantity);
		            	}
		         }	
				 if ($scope.lHablFreightBean[i].rate != undefined && $scope.lHablFreightBean[i].rate != null && $scope.lHablFreightBean[i].rate != '') {
					 if(flag5==true)
		            	{
					 flag5 = validateDouble($scope.lHablFreightBean[i].rate);
		            	}
		         }	
				 if ($scope.lHablFreightBean[i].currency != undefined && $scope.lHablFreightBean[i].currency != null && $scope.lHablFreightBean[i].currency != '') {
					 if(flag5==true)
		            	{
					 flag5 = validateDouble($scope.lHablFreightBean[i].currency);
		            	}
		         }	
				 if ($scope.lHablFreightBean[i].exRate != undefined && $scope.lHablFreightBean[i].exRate != null && $scope.lHablFreightBean[i].exRate != '') {
					 if(flag5==true)
		            	{
					 flag5 = validateDouble($scope.lHablFreightBean[i].exRate);
		            	}
		         }	
				 if ($scope.lHablFreightBean[i].amount != undefined && $scope.lHablFreightBean[i].amount != null && $scope.lHablFreightBean[i].amount != '') {
					 if(flag5==true)
		            	{
					 flag5 = validateDouble($scope.lHablFreightBean[i].amount);
		            	}
		         }	
				 if ($scope.lHablFreightBean[i].buySellParty != undefined && $scope.lHablFreightBean[i].buySellParty != null && $scope.lHablFreightBean[i].buySellParty != '') {
					 if(flag5==true)
		            	{
					 flag5 = validateDouble($scope.lHablFreightBean[i].buySellParty);
		            	}
		         }	
				 if ($scope.lHablFreightBean[i].jobStatus1 != undefined && $scope.lHablFreightBean[i].jobStatus1 != null && $scope.lHablFreightBean[i].jobStatus1 != '') {
					 if(flag5==true)
		            	{
					 flag5 = validateDouble($scope.lHablFreightBean[i].jobStatus1);
		            	}
		         }	
				
			}
			var obj = {
					hblBean : $scope.hbl,
					lhblContainerBean	: $scope.lHablContainerBean,
					lhblFreightBean :$scope.lHablFreightBean,

			}
			if (flag1 == true && flag2 == true && flag2 == true && flag3 == true && flag4 == true && flag5 == true) {

            $http.post($stateParams.tenantid+'/app/master/hbl/update',obj).success(function(data) {
            	if(data.success){
            		logger.logSuccess('Updated Successfully');
            		if($scope.hbl.shipperAddress != null && $scope.hbl.shipperAddress != ''){
             			 var text5 =$scope.hbl.shipperAddress;
                          text5 = text5.replace(/\r?<br>/g, '\n');
                          $scope.hbl.shipperAddress=text5;
             		}
             		if($scope.hbl.consigneeAddress != null  && $scope.hbl.consigneeAddress != '' ){
             			 var text6 =$scope.hbl.consigneeAddress;
                          text6 = text6.replace(/\r?<br>/g, '\n');
                          $scope.hbl.consigneeAddress=text6;
             		}
             		  if($scope.hbl.notifyAddress != null  && $scope.hbl.notifyAddress != '' ){
                          var text7 =$scope.hbl.notifyAddress;
                                   text7 = text7.replace(/\r?<br>/g, '\n');
                                   $scope.hbl.notifyAddress=text7;
                        }
                	$location.url($stateParams.tenantid+'/hbl/edit?rowid='+data.id);
                	

            		//$scope.cancel();
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
		
		}else {
            toaster.pop('error', "Please fill the required fields", 
                    logger.getErrorHtmlNew(servicePartnerAddForm.$validationSummary), 5000, 'trustedHtml');
        }
	}
	/*$scope.printRow = function() {
 	   debugger
	        var url = $stateParams.tenantid+'/app/master/hbl/print?hblId=' + hblNo;
	        var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
	        wnd.print();   
	     } */   
	
	$scope.printRow = function() {
	 	   debugger
		        var url = $stateParams.tenantid+'/app/master/hbl/print?hblId=' + hblNo;
		        var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
		        wnd.print();   
		     }   
	
 $scope.printManifest = function() {
 	   debugger
	        console.log("Both print invoice")
	        var url = $stateParams.tenantid+'/app/master/hbl/printManifest?hblId=' + hblNo;
	        var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
	        wnd.print();   
	          }
 $scope.printMultimodal = function() {
	   debugger
	        console.log("Both print invoice")
	        var url = $stateParams.tenantid+'/app/master/hbl/printMultimodal?hblId=' + hblNo;
	        var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
	        wnd.print();   
	          }
 $scope.printLoad = function() {
	   debugger
	        console.log("Both print invoice")
	        var url = $stateParams.tenantid+'/app/master/hbl/printLoad?hblId=' + hblNo;
	        var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
	        wnd.print();   
	          }
 
 $scope.printRowOverFlow = function() {
	   debugger
	        console.log("Both print invoice")
	        var url = $stateParams.tenantid+'/app/master/hbl/printOverFlow?hblId=' + hblNo;
	        var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
	        wnd.print();   
	          }
 

 $scope.printBookingConfirmation = function() {
	   debugger
	        console.log("Both print invoice")
	        var url = $stateParams.tenantid+'/app/master/hbl/printBookingConfirmation?hblId=' + hblNo;
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
	 $scope.reset=function(){
         
         if( $scope.isEdit == false){ 
        	 $scope.lHablContainerBean =[];
     	    $scope.lHablFreightBean =[];

     	    $scope.hbl = {
     	    		 jobNo:'',
     	    		 type:'',
     	    		 hblNo:'',
     	    		 mblNo:'',
     	    		 marksAndNos:'',
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
     	    		 containarized:'',
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
     	    		 destionationCode:'',
     	    		 hblCargoDetailBin:''
     	         };
         }else {
        	 $http.post($stateParams.tenantid+'/app/master/hbl/edit?hblId='+hblNo).success(function(data) {
             	if(data.success){
             		$scope.hbl = data.hblBean;
             		$scope.oldJob=data.hblBean.jobNo;
             		$scope.lHablFreightBean=data.lhblFreightBean;
             		$scope.lHablContainerBean=data.lhblContainerBean;
             		$scope.hbl.jobNo = data.hblBean.jobNo.toString();
             		$scope.hbl.mblNo = data.hblBean.mblNo.toString();
             		$scope.hbl.pol = data.hblBean.pol.toString();
             		$scope.hbl.pod = data.hblBean.pod.toString();
             		$scope.hbl.term = data.hblBean.term.toString();
             		$scope.hbl.customer = data.hblBean.customer.toString();
             		$scope.hbl.branch = data.hblBean.branch.toString();
             		if($scope.hbl.shipperAddress != null && $scope.hbl.shipperAddress != ''){
           			 var text5 =$scope.hbl.shipperAddress;
                        text5 = text5.replace(/\r?<br>/g, '\n');
                        $scope.hbl.shipperAddress=text5;
           		}
           		if($scope.hbl.consigneeAddress != null  && $scope.hbl.consigneeAddress != '' ){
           			 var text6 =$scope.hbl.consigneeAddress;
                        text6 = text6.replace(/\r?<br>/g, '\n');
                        $scope.hbl.consigneeAddress=text6;
           		}
           		if($scope.hbl.notifyAddress != null  && $scope.hbl.notifyAddress != '' ){
          			 var text7 =$scope.hbl.notifyAddress;
          			text7 = text7.replace(/\r?<br>/g, '\n');
                       $scope.hbl.notifyAddress=text7;
          		}
           		
             		for(var i=0;i<data.lhblFreightBean.length;i++) 
             		{
                 		$scope.lHablFreightBean[i].unit = $scope.lHablFreightBean[i].unit.toString();
                 		$scope.lHablFreightBean[i].buySellParty = $scope.lHablFreightBean[i].buySellParty.toString();
                 		$scope.lHablFreightBean[i].transactionType = $scope.lHablFreightBean[i].transactionType.toString();
                 		$scope.lHablFreightBean[i].currency = $scope.lHablFreightBean[i].currency.toString();
                 		$scope.lHablFreightBean[i].jobStatus1 = $scope.lHablFreightBean[i].jobStatus1.toString();
                     	if(data.lhblFreightBean[i].paymentMode!=null && data.lhblFreightBean[i].paymentMode!='')
                     		{
         					$scope.lHablFreightBean[i].paymentMode=data.lhblFreightBean[i].paymentMode.toString();

                     		}

                     	}
             		 for(var i=0;i<data.lhblContainerBean.length;i++) 
                  	{
                  	if(data.lhblContainerBean[i].size!=null && data.lhblContainerBean[i].size!='')
                  		{
      					$scope.lHablContainerBean[i].size=data.lhblContainerBean[i].size.toString();

                  		}

                  	}
             		if(data.hblBean.origin!=null&&data.hblBean.origin!='')
         			{
             		$scope.hbl.origin = data.hblBean.origin.toString();;

         			}

             		if(data.hblBean.destination!=null&&data.hblBean.destination!='')
         			{
             		$scope.hbl.destination = data.hblBean.destination.toString();;

         			}
             		if(data.hblBean.salesPerson!=null&&data.hblBean.salesPerson!='')
         			{
             		$scope.hbl.salesPerson = data.hblBean.salesPerson.toString();;

         			}
         		   if(data.hblBean.shipper!=null && data.hblBean.shipper!='')
     			   {
             		$scope.hbl.shipper = data.hblBean.shipper.toString();;

     			    }
         		   if(data.hblBean.consignee!=null && data.hblBean.consignee!='')
     			   {
             		$scope.hbl.consignee = data.hblBean.consignee.toString();;

     			    }
         		  
         		   if(data.hblBean.vendor!=null && data.hblBean.vendor!='')
     			   {
             		$scope.hbl.vendor = data.hblBean.vendor.toString();;

     			    }
         		   if(data.hblBean.movement!=null && data.hblBean.movement!='')
     			   {
             		$scope.hbl.movement = data.hblBean.movement.toString();;

     			    }
         		   if(data.hblBean.cargoInsurance!=null && data.hblBean.cargoInsurance!='')
     			   {
             		$scope.hbl.cargoInsurance = data.hblBean.cargoInsurance.toString();;

     			    }
         		   if(data.hblBean.preCarriagedBy!=null && data.hblBean.preCarriagedBy!='')
     			   {
             		$scope.hbl.preCarriagedBy = data.hblBean.preCarriagedBy.toString();;

     			    }
         		   if(data.hblBean.destinationAgentCode!=null && data.hblBean.destinationAgentCode!='')
     			   {
             		$scope.hbl.destinationAgentCode= data.hblBean.destinationAgentCode.toString();;

     			    }
         		   if(data.hblBean.currency!=null && data.hblBean.currency!='')
     			   {
             		$scope.hbl.currency = data.hblBean.currency.toString();;

     			    }
         		   $scope.totalPackageCalculation();
         		   $scope.totalnetWeightCalculation();
         		   $scope.totalgrossWeightCalculation();
        		   $http.post($stateParams.tenantid+'/app/seaquotation/getServicePartnerList').success(function(datas) {
        			   $scope.customerBuyList=datas.vendorMasterList;
        			   $scope.customerSellList=datas.serviceParnrList;
    				}).error(function(data) {

    				});
	    			  $http.get($stateParams.tenantid+'/app/jobOrderSea/dropDownList').success(function(datas) {
							$scope.UnitList = datas.unitSelectivityList;
							$scope.transactionTypeList = datas.transactionSelectivityList;
							/*$scope.customerBuyList = datas.buyServiceList;
							$scope.customerSellList = datas.sellServiceList;*/
							$scope.currencylist= datas.currecnySelectivityList;
							$scope.chargeHeadList = datas.chargeHeadSelectivityList;
						}).error(function(data) {

						});
						$http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(datas) {
							$scope.containerNoList=datas.getcontainer;
							  $scope.sizeList=datas.getcontypelist;
						}).error(function(datas) {
						});
         		  $http.post($stateParams.tenantid+'/app/master/hbl/dropDownList').success(function(data) {
						 $scope.jobStatusListDtl=[];
							$scope.getStatus = function() {
							    var  data = {};
							    data["id"] = "1";
							    data["text"] = "PENDING";
							    $scope.jobStatusListDtl.push(data);
							    data = {};
							    data["id"] = "2";
							    data["text"] = "INVOICED";
							    $scope.jobStatusListDtl.push(data);  
							    data = {};
							    data["id"] = "3";
							    data["text"] = "DRAFT";
							    $scope.jobStatusListDtl.push(data);
							}
							$scope.getStatus();
       	          
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
               		$scope.destinationAgentList=data.servicePartnerList;	
               		$scope.currencyList=data.currency;
               		$scope.jobList=data.seaJob;
               		$scope.salesPersonList=data.salesPerson;
               		$scope.mblList=data.mbl;
               		//$scope.hblList=data.hbl;
               		//$scope.sizeList=data.sizeList;
               		$scope.paymentList=data.paymentList;
               		//$scope.uomList=data.uom;
       	          });	
             	
             	}else{
             		logger.logError("Unable to fetch data");
             	}
             });
         }
     }
	 $http.post($stateParams.tenantid+'/app/jobOrderSea/dropDownList').success(function(data) {
			$scope.uomList=data.uomList;
		})
	 $scope.quickLinkMethd=function(qulkVal){
			if(qulkVal!='Select'){
				if($scope.hbl.hblNo!='' && $scope.hbl.hblNo!=undefined){
				$http.post($stateParams.tenantid + '/app/master/hbl/getQuickLinkId?category='+qulkVal+'&hblNo='+$scope.hbl.hblNo).success(function(datas) {
							if(datas.quickLinkId!=null){
								var rowid=datas.quickLinkId;
								
								if(qulkVal=="Job Order"){
									if(rowid !=0){
										$location.url($stateParams.tenantid+'/jobOrderSea/edit?rowid='+rowid);
										//$window.open('#'+$stateParams.tenantid+'/jobOrderSea/view?rowid='+rowid, '_blank');
									}else{
										logger.logError("There is no "+qulkVal);
									}
								}else if(qulkVal=="MBL"){
									if(rowid !=0){
										$location.url($stateParams.tenantid+'/mabl/edit?rowid='+rowid);
										//$window.open('#'+$stateParams.tenantid+'/mabl/view?rowid='+rowid, '_blank');
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
								}else if(qulkVal=="MBL"){
									$window.open('#'+$stateParams.tenantid+'/mabl/list?rowid='+quickLinkIdList, '_blank');
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
                 template : 'views/sea/hbl/marks',
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
             template : 'views/sea/hbl/cargo',
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
	$scope.hbl1 = {
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
            		 $scope.hbl1.marksAndNos = text5;	 
        		 }else{
        			 console.log(index);
        		 }
        		 
        	 })
             }
             else{
            	 //console.log($scope.lHablContainerBean);
            	 if(index ==$scope.lHablContainerBean[index].marksAndNosid){
            		 $scope.hbl1.marksAndNos=$scope.lHablContainerBean[index].marksAndNos;
            		 
            	 }
             }
             $scope.ok=function()
             {
            	 var text = $scope.hbl1.marksAndNos;
                 text = text.replace(/\r?\n/g, '<br>');
            	 $scope.lHablContainerBean[index].marksAndNos=text;
            	 $scope.lHablContainerBean[index].marksAndNosid=index;
            	 
            	
            	 ngDialog.close();
             }
	
});
app.controller('cargoCtrl', function($scope, index,$rootScope,ngDialog) {
	$scope.dumCollection;
	$scope.hbl2 = {
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
                       
                		 $scope.hbl2.cargoDescription = text5;	 
            		 }else{
            			 console.log(index);
            		 }
            		 
            	 })
             }else{
            	 console.log($scope.lHablContainerBean);
            	 if(index ==$scope.lHablContainerBean[index].cargoDescriptionid){
            		 $scope.hbl2.cargoDescription=$scope.lHablContainerBean[index].cargoDescription;
            		 
            	 }
            	 
             }
             $scope.ok=function()
             {
            	 var text = $scope.hbl2.cargoDescription;
                 text = text.replace(/\r?\n/g, '<br>');
              //   $scope.dischargeSum.admittedFor=text;
            	 $scope.lHablContainerBean[index].cargoDescription=text;
            	 $scope.lHablContainerBean[index].cargoDescriptionid=index;
            	 ngDialog.close();
             }
             
	
});

app
.controller(
		'addShipperCtrl',
		function($stateParams, $scope, $http, $location, logger,
				$state, $window, ngDialog) {
			debugger;

			$scope.cityList = [];

			$scope.close = function() {
				ngDialog.close();
			};
			$http
					.post(
							$stateParams.tenantid
									+ '/app/master/servicepartner/dropDownList')
					.success(function(data) {
						if (data.success) {
							$scope.cityList = data.cityList;
						}
					});

			$scope.downloadNewFile = function(id) {
				debugger;
				$("#" + id).bind('click', function() {
					// alert('clicked');

				});
				$("#" + id).simulateClick('click');
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
						this.click(); // IE
					}
				});
			}

			$scope.allowSaveShip = function(hbl) {

				$http
						.post(
								$stateParams.tenantid
										+ '/app/jobOrderSea/addShipper',
										hbl)
						.success(
								function(datas) {

									if (datas.success == true) {
										logger
												.logSuccess("Added Shipper Successfully!..");
										ngDialog.close();
										$http
												.get(
														$stateParams.tenantid
																+ '/app/jobOrderSea/dropDownList')
												.success(
														function(datas) {
															$scope.customerList = datas.shipperSelectivityList;
														})
										$scope.hbl.shipper = datas.code;

									} else {
										logger.logError(datas.message);
									}
								}).error(function(data) {
							logger.logError("Please try again");
						});

			}
			$scope.allowSaveConsig = function(joborder) {

				$http
						.post(
								$stateParams.tenantid
										+ '/app/jobOrderSea/addConsignee',
								joborder)
						.success(
								function(datas) {

									if (datas.success == true) {
										logger
												.logSuccess("Added Shipper Successfully!..");
										ngDialog.close();
										$http
												.get(
														$stateParams.tenantid
																+ '/app/jobOrderSea/dropDownList')
												.success(
														function(datas) {
															$scope.customerList = datas.consigneeSelectivityList;
														})
										$scope.hbl.consignee = datas.code;
									} else {
										logger.logError(datas.message);
									}
								}).error(function(data) {
							logger.logError("Please try again");
						});

			}

		});
