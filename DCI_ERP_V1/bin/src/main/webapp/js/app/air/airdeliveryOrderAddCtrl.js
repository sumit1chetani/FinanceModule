'use strict';

app.controller('airdeliveryorderAddCtrl', function($scope, $rootScope, $http, $location, logger,
        utilsService,$state,sharedProperties,$window,validationService,toaster,$stateParams) {	
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.isEdit = false;
    $scope.lAirDeliveryOrderDetailBean=[];
    $scope.airDeliveryOrder ={
    		jobNo :'',
    		doNo : '',
    		pol : '',
    		pod : '',
    		origin : '',
    		customer : '',
    		igmNo : '',
    		igmDate : '',
    		to : '',
    		hblNo : '',
    		mblNo : '',
    		doDate : '',
    		destination : '',
    		consignee : '',
    		doRemarks : '',
    		branch : '',
    		vessel : '',
    		arrivalDate : '',
    		notify : '',
    		itemNo : '',
    		canRemarks:'',
    		canNo:'',
    		airLineNo:'',
    		flightNo:'',
    		flightDate	:''
   };
    
	  $scope.templAirDeliveryOrderDetailBean = {
				select 		:false,
				descriptionOfGoods:'',
				noofPackage:'',	 
				netWeight:'',
				grossWeight:'',
				remarks:'',
				chargeableWeight:'',
			};

	  $scope.addCredRow = function() {
	   
		  var tmp=angular.copy($scope.templAirDeliveryOrderDetailBean);
			$scope.lAirDeliveryOrderDetailBean.push(tmp);

	  }
	  
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

		$scope.airDeliveryOrder.doDate = dd + '/' + mm + '/' + yyyy;
		
	  $scope.addCredRow();

		$scope.removeCredRow =function(){
			if($scope.isEdit==false){
				var tmpDelList = [];
				for(var i=$scope.lAirDeliveryOrderDetailBean.length-1;i>=0;i--){
					if($scope.lAirDeliveryOrderDetailBean[i].select==true){
						tmpDelList.push($scope.lAirDeliveryOrderDetailBean[i]);
						$scope.lAirDeliveryOrderDetailBean.splice(i, 1);
					}
				}
				logger.logSuccess('Deleted Successfully');
			}else if($scope.isEdit==true){
				var tmpDelList = [];
				for(var i=$scope.lAirDeliveryOrderDetailBean.length-1;i>=0;i--){
					if($scope.lAirDeliveryOrderDetailBean[i].select==true){
						tmpDelList.push($scope.lAirDeliveryOrderDetailBean[i]);
					}
				}
				$http.post($stateParams.tenantid+'/app/master/vendor/deleteKeyDetail',tmpDelList).success(function(data) {
		        	if(data.success){
		        		for(var i=$scope.lAirDeliveryOrderDetailBean.length-1;i>=0;i--){
		    				if($scope.lAirDeliveryOrderDetailBean[i].select==true){
		    					$scope.lAirDeliveryOrderDetailBean.splice(i, 1);
		    				}
		    			}
		        		logger.logSuccess('Deleted Successfully');
		        	}else{
		        		logger.logError('Unable to delete');
		        	}
				})
			}
			
		}
    $scope.cancel = function(){
        $state.go("app.air.deliveryorder.list",{tenantid:$stateParams.tenantid});
    };  
    
    $scope.$watch('airDeliveryOrder.jobNo',function(newValue, oldValue) {
		if(newValue!=null && newValue!=undefined && newValue!=""){
			if($scope.isEdit==false)
			{
				
			
	        $http.post($stateParams.tenantid+'/app/air/hbw/getJobDetail?jobNo='+newValue).success(function(data) {
	        	if(data.success){
	        		$scope.lAirDeliveryOrderDetailBean=data.lHbwContainerBean;
	        		$scope.airDeliveryOrder.pol = data.hblBean.aol.toString();
	        		$scope.airDeliveryOrder.pod = data.hblBean.aod.toString();
	        		$scope.airDeliveryOrder.term = data.hblBean.term.toString();
	        		$scope.airDeliveryOrder.customer = data.hblBean.customer.toString();
	        		$scope.airDeliveryOrder.branch = data.hblBean.branch.toString();
	        		$scope.airDeliveryOrder.origin = data.hblBean.origin.toString();
	        		$scope.airDeliveryOrder.destination = data.hblBean.destination.toString();

	    			
	        		if(data.hblBean.salesPerson!=null&&data.hblBean.salesPerson!='')
	    			{
	        		$scope.airDeliveryOrder.salesPerson = data.hblBean.salesPerson.toString();

	    			}
	    		   if(data.hblBean.shipper!=null && data.hblBean.shipper!='')
				   {
	        		$scope.airDeliveryOrder.shipper = data.hblBean.shipper.toString();

				    }
	    		   if(data.hblBean.consignee!=null && data.hblBean.consignee!='')
				   {
	        		$scope.airDeliveryOrder.consignee = data.hblBean.consignee.toString();

				    }
	    		   for(var i=0;i<data.lHbwContainerBean.length;i++) 
	             	{
	    			   $scope.lAirDeliveryOrderDetailBean[i].descriptionOfGoods=data.lHbwContainerBean[i].descriptionofGoods;
	    			   $scope.lAirDeliveryOrderDetailBean[i].noofPackage=data.lHbwContainerBean[i].noOfPieces;
	    		       $scope.lAirDeliveryOrderDetailBean[i].netWeight=data.lHbwContainerBean[i].netWeight;
	    		       $scope.lAirDeliveryOrderDetailBean[i].grossWeight=data.lHbwContainerBean[i].grossWeight;
	    		       $scope.lAirDeliveryOrderDetailBean[i].chargeableWeight=data.lHbwContainerBean[i].chargeableWeight;
	    		       $scope.lAirDeliveryOrderDetailBean[i].remarks=data.lHbwContainerBean[i].remarks;
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
      		$scope.mblList=data.mbw;
      		$scope.hblList=data.hbw;
      		$scope.jobList=data.airJob;
      		$scope.sizeList=data.sizeList;
      		$scope.iataListDetail=data.iataListDetail;

      	
      });
    
    //edit
    var editid = $location.search().rowid;    
    var test = parseInt(editid);
    if(test){
        $scope.isEdit = true;
    	 $http.post($stateParams.tenantid+'/app/air/deliveryOrder/edit?hblId='+editid).success(function(result) {
    	    	console.log(result);
    	    	$scope.airDeliveryOrder = result.hblBean;
    	    	$scope.lAirDeliveryOrderDetailBean=result.lAirDeliveryOrderDetailBean;
    	    	$scope.airDeliveryOrder.pol = result.hblBean.pol.toString();
    	    	$scope.airDeliveryOrder.pod = result.hblBean.pod.toString();
    	    	$scope.airDeliveryOrder.branch = result.hblBean.branch.toString();
    	    	$scope.airDeliveryOrder.jobNo = result.hblBean.jobNo.toString();
    	    	if($scope.airDeliveryOrder.origin!=null && $scope.airDeliveryOrder.origin !=0 && $scope.airDeliveryOrder.origin !="")
    	    		{
    	    		$scope.airDeliveryOrder.origin=result.hblBean.origin.toString();
    	    		}
    	    	if($scope.airDeliveryOrder.destination!=null && $scope.airDeliveryOrder.destination!=0 && $scope.airDeliveryOrder.destination!="")
	    		{
    	    		$scope.airDeliveryOrder.destination=result.hblBean.destination.toString();

	    		}
    	    	if($scope.airDeliveryOrder.customer!=null && $scope.airDeliveryOrder.customer!=0 && $scope.airDeliveryOrder.customer!="")
	    		{
    	    		$scope.airDeliveryOrder.customer=result.hblBean.customer.toString();

	    		}
    	    	if($scope.airDeliveryOrder.consignee!=null && $scope.airDeliveryOrder.consignee!=0 && $scope.airDeliveryOrder.consignee!="")
	    		{
    	    		$scope.airDeliveryOrder.consignee=result.hblBean.consignee.toString();

	    		}
    	    	if($scope.airDeliveryOrder.notify!=null && $scope.airDeliveryOrder.notify!=0 && $scope.airDeliveryOrder.notify!="")
	    		{
    	    		$scope.airDeliveryOrder.notify=result.hblBean.notify.toString();

	    		}
    	    	if($scope.airDeliveryOrder.hblNo!=null && $scope.airDeliveryOrder.hblNo!=0 && $scope.airDeliveryOrder.hblNo!="")
	    		{
    	    		$scope.airDeliveryOrder.hblNo=result.hblBean.hblNo.toString();

	    		}
    	    	if($scope.airDeliveryOrder.mblNo!=null && $scope.airDeliveryOrder.mblNo!=0 && $scope.airDeliveryOrder.mblNo!="")
	    		{
    	    		$scope.airDeliveryOrder.mblNo=result.hblBean.mblNo.toString();

	    		}
    	    	  for(var i=0;i<data.lSeaDeliveryOrderDetailBean.length;i++) 
    	          	{
    	          	if(data.lSeaDeliveryOrderDetailBean[i].size!=null && data.lSeaDeliveryOrderDetailBean[i].origin!='')
    	          		{
    						$scope.lSeaDeliveryOrderDetailBean[i].size=data.lSeaDeliveryOrderDetailBean[i].size.toString();

    	          		}

    	          	}
    	    });    	
    }
 
    $scope.save = function(airDeliveryOrderForm) {
    	if (new validationService().checkFormValidity(airDeliveryOrderForm)) {
            var flag1 = true, flag2 = true, flag3 = true, flag4 = true, flag5 = true;

    		if($scope.airDeliveryOrder.canDate=="" || $scope.airDeliveryOrder.canDate==undefined)
    			{
    			$scope.airDeliveryOrder.canDate=null
    			}
    		if($scope.airDeliveryOrder.flightDate=="" || $scope.airDeliveryOrder.flightDate==undefined)
			{
			$scope.airDeliveryOrder.flightDate=null
			}
    		if($scope.airDeliveryOrder.arrivalDate=="" || $scope.airDeliveryOrder.arrivalDate==undefined)
			{
			$scope.airDeliveryOrder.arrivalDate=null
			}
    		if($scope.airDeliveryOrder.igmDate=="" || $scope.airDeliveryOrder.igmDate==undefined)
    		{
    		$scope.airDeliveryOrder.igmDate=null
    		}
   
    		for(var i=0;i<$scope.lAirDeliveryOrderDetailBean.length;i++){
     			 if ($scope.lAirDeliveryOrderDetailBean[i].noofPackage != undefined && $scope.lAirDeliveryOrderDetailBean[i].noofPackage != null && $scope.lAirDeliveryOrderDetailBean[i].noofPackage != '') {
     	            if(flag1==true)
     	            	{
     	  				 flag1 = validateNos($scope.lAirDeliveryOrderDetailBean[i].noofPackage);

     	            	}
     	         }	
     			 if ($scope.lAirDeliveryOrderDetailBean[i].chargeableWeight != undefined && $scope.lAirDeliveryOrderDetailBean[i].chargeableWeight != null && $scope.lAirDeliveryOrderDetailBean[i].chargeableWeight != '') {
     				if(flag2==true)
   	            	{
     				 flag2 = validateDouble($scope.lAirDeliveryOrderDetailBean[i].chargeableWeight);
   	            	}
     	         }
     			 if ($scope.lAirDeliveryOrderDetailBean[i].netWeight != undefined && $scope.lAirDeliveryOrderDetailBean[i].netWeight != null && $scope.lAirDeliveryOrderDetailBean[i].netWeight != '') {
     				if(flag3==true)
   	            	{
     				 flag3 = validateDouble($scope.lAirDeliveryOrderDetailBean[i].netWeight);
   	            	}
     	         }
     			 if ($scope.lAirDeliveryOrderDetailBean[i].grossWeight != undefined && $scope.lAirDeliveryOrderDetailBean[i].grossWeight != null && $scope.lAirDeliveryOrderDetailBean[i].grossWeight != '') {
     				if(flag4==true)
   	            	{
     				 flag4 = validateDouble($scope.lAirDeliveryOrderDetailBean[i].grossWeight);
   	            	}
     	         }
     		}
    	var obj = {
    			hblBean : $scope.airDeliveryOrder,
    			lAirDeliveryOrderDetailBean	: $scope.lAirDeliveryOrderDetailBean,

		}
		if (flag1 == true && flag2 == true && flag2 == true && flag3 == true && flag4 == true && flag5 == true) {

    	 $http.post($stateParams.tenantid+'/app/air/deliveryOrder/save',obj).success(function(result) {    	
    		 console.log(result);
             if (result.success==true) {
                 logger.logSuccess("Saved Successfully!");
                 $state.go("app.air.deliveryorder.list",{tenantid:$stateParams.tenantid});
             } else {
                 logger.logError("Name Already Exists");
             }             
         }); 
    	}
		else {
            if (flag1 == false) {
                logger.logError("Please Enter Number Value for No Of Pieces in Container Details");
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
                    logger.getErrorHtmlNew(airDeliveryOrderForm.$validationSummary), 5000, 'trustedHtml');
        }
    };
    
    //update
    $scope.update = function(airDeliveryOrderForm) {
    	if (new validationService().checkFormValidity(airDeliveryOrderForm)) {
            var flag1 = true, flag2 = true, flag3 = true, flag4 = true, flag5 = true;

    		if($scope.airDeliveryOrder.canDate=="" || $scope.airDeliveryOrder.canDate==undefined)
			{
			$scope.airDeliveryOrder.canDate=null
			}
		if($scope.airDeliveryOrder.flightDate=="" || $scope.airDeliveryOrder.flightDate==undefined)
		{
		$scope.airDeliveryOrder.flightDate=null
		}
		if($scope.airDeliveryOrder.arrivalDate=="" || $scope.airDeliveryOrder.arrivalDate==undefined)
		{
		$scope.airDeliveryOrder.arrivalDate=null
		}
		if($scope.airDeliveryOrder.igmDate=="" || $scope.airDeliveryOrder.igmDate==undefined)
		{
		$scope.airDeliveryOrder.igmDate=null
		}
		for(var i=0;i<$scope.lAirDeliveryOrderDetailBean.length;i++){
  			 if ($scope.lAirDeliveryOrderDetailBean[i].noofPackage != undefined && $scope.lAirDeliveryOrderDetailBean[i].noofPackage != null && $scope.lAirDeliveryOrderDetailBean[i].noofPackage != '') {
  	            if(flag1==true)
  	            	{
  	  				 flag1 = validateNos($scope.lAirDeliveryOrderDetailBean[i].noofPackage);

  	            	}
  	         }	
  			 if ($scope.lAirDeliveryOrderDetailBean[i].chargeableWeight != undefined && $scope.lAirDeliveryOrderDetailBean[i].chargeableWeight != null && $scope.lAirDeliveryOrderDetailBean[i].chargeableWeight != '') {
  				if(flag2==true)
	            	{
  				 flag2 = validateDouble($scope.lAirDeliveryOrderDetailBean[i].chargeableWeight);
	            	}
  	         }
  			 if ($scope.lAirDeliveryOrderDetailBean[i].netWeight != undefined && $scope.lAirDeliveryOrderDetailBean[i].netWeight != null && $scope.lAirDeliveryOrderDetailBean[i].netWeight != '') {
  				if(flag3==true)
	            	{
  				 flag3 = validateDouble($scope.lAirDeliveryOrderDetailBean[i].netWeight);
	            	}
  	         }
  			 if ($scope.lAirDeliveryOrderDetailBean[i].grossWeight != undefined && $scope.lAirDeliveryOrderDetailBean[i].grossWeight != null && $scope.lAirDeliveryOrderDetailBean[i].grossWeight != '') {
  				if(flag4==true)
	            	{
  				 flag4 = validateDouble($scope.lAirDeliveryOrderDetailBean[i].grossWeight);
	            	}
  	         }
  		}
        	var obj = {
        			hblBean : $scope.airDeliveryOrder,
        			lAirDeliveryOrderDetailBean	: $scope.lAirDeliveryOrderDetailBean,

    		}
    		if (flag1 == true && flag2 == true && flag2 == true && flag3 == true && flag4 == true && flag5 == true) {

   	 $http.post($stateParams.tenantid+'/app/air/deliveryOrder/update', obj).success(function(result) {    	
   		 console.log(result);
            if (result.success==true) {
                logger.logSuccess("Update Successfully!");
                $state.go("app.air.deliveryorder.list",{tenantid:$stateParams.tenantid});
            } else {
                logger.logError(result.message);
            }             
        });
    		}
    		else {
                if (flag1 == false) {
                    logger.logError("Please Enter Number Value for No Of Pieces in Container Details");
                }
                if (flag2 == false) {
                    logger.logError("Please Enter Number Value for Chargeable Weight in Container Details");
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
                    logger.getErrorHtmlNew(airDeliveryOrderForm.$validationSummary), 5000, 'trustedHtml');
        }
   }; 
   $scope.reset = function(portForm) {
       
       if($scope.isEdit = true){
          
           $scope.port.portid ='';
           $scope.port.code ='';
           $scope.port.name ='';
           $scope.port.cityid ='';
           $scope.port.city ='';
           $scope.port.description ='';
           $scope.port.isActive ='';
    


      	 $http.post($stateParams.tenantid+'/port/edit',test).success(function(result) {
 	    	console.log(result);
 	    	$scope.port = result;
 	    	$scope.port.city = result.city.toString();
 	    	if(result.isStstus == "t"){
 	    		$scope.port.isActive = true;
 	    	}else{
 	    		$scope.port.isActive = false;
 	    	}    	    	
 	    });    	
       }
       else{
    	   $scope.port.portid ='';
           $scope.port.code ='';
           $scope.port.name ='';
           $scope.port.cityid ='';
           $scope.port.city ='';
           $scope.port.description ='';
           $scope.port.isActive ='';
      
         
       } $scope.monthSchedule='';
	 $('#truckTrailMapScheduler').fullCalendar('destroy');
       
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
   
   var editid = $location.search().rowid;  
   if(editid!=null&&editid!=""&&editid!=undefined)
	   {
	   $scope.print=function(){
		    var url = $stateParams.tenantid+'/app/air/deliveryOrder/print?hblId='+editid;
	        var wnd = window.open(url, 'DeliveryOrder', 'height=700,width=850,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
	        wnd.print();
	   }
	
	}
   
   $scope.reset=function(){
       
       if( $scope.isEdit == false){ 
    	   $scope.lAirDeliveryOrderDetailBean=[];
    	    $scope.airDeliveryOrder ={
    	    		jobNo :'',
    	    		doNo : '',
    	    		pol : '',
    	    		pod : '',
    	    		origin : '',
    	    		customer : '',
    	    		igmNo : '',
    	    		igmDate : '',
    	    		to : '',
    	    		hblNo : '',
    	    		mblNo : '',
    	    		doDate : '',
    	    		destination : '',
    	    		consignee : '',
    	    		doRemarks : '',
    	    		branch : '',
    	    		vessel : '',
    	    		arrivalDate : '',
    	    		notify : '',
    	    		itemNo : '',
    	    		canRemarks:'',
    	    		canNo:'',
    	    		airLineNo:'',
    	    		flightNo:'',
    	    		flightDate	:''
    	   };
       }else {
    	   $http.post($stateParams.tenantid+'/app/air/deliveryOrder/edit?hblId='+editid).success(function(result) {
   	    	console.log(result);
   	    	$scope.airDeliveryOrder = result.hblBean;
   	    	$scope.lAirDeliveryOrderDetailBean=result.lAirDeliveryOrderDetailBean;
   	    	$scope.airDeliveryOrder.pol = result.hblBean.pol.toString();
   	    	$scope.airDeliveryOrder.pod = result.hblBean.pod.toString();
   	    	$scope.airDeliveryOrder.branch = result.hblBean.branch.toString();
   	    	$scope.airDeliveryOrder.jobNo = result.hblBean.jobNo.toString();
   	    	if($scope.airDeliveryOrder.origin!=null && $scope.airDeliveryOrder.origin !=0 && $scope.airDeliveryOrder.origin !="")
   	    		{
   	    		$scope.airDeliveryOrder.origin=result.hblBean.origin.toString();
   	    		}
   	    	if($scope.airDeliveryOrder.destination!=null && $scope.airDeliveryOrder.destination!=0 && $scope.airDeliveryOrder.destination!="")
	    		{
   	    		$scope.airDeliveryOrder.destination=result.hblBean.destination.toString();

	    		}
   	    	if($scope.airDeliveryOrder.customer!=null && $scope.airDeliveryOrder.customer!=0 && $scope.airDeliveryOrder.customer!="")
	    		{
   	    		$scope.airDeliveryOrder.customer=result.hblBean.customer.toString();

	    		}
   	    	if($scope.airDeliveryOrder.consignee!=null && $scope.airDeliveryOrder.consignee!=0 && $scope.airDeliveryOrder.consignee!="")
	    		{
   	    		$scope.airDeliveryOrder.consignee=result.hblBean.consignee.toString();

	    		}
   	    	if($scope.airDeliveryOrder.notify!=null && $scope.airDeliveryOrder.notify!=0 && $scope.airDeliveryOrder.notify!="")
	    		{
   	    		$scope.airDeliveryOrder.notify=result.hblBean.notify.toString();

	    		}
   	    	if($scope.airDeliveryOrder.hblNo!=null && $scope.airDeliveryOrder.hblNo!=0 && $scope.airDeliveryOrder.hblNo!="")
	    		{
   	    		$scope.airDeliveryOrder.hblNo=result.hblBean.hblNo.toString();

	    		}
   	    	if($scope.airDeliveryOrder.mblNo!=null && $scope.airDeliveryOrder.mblNo!=0 && $scope.airDeliveryOrder.mblNo!="")
	    		{
   	    		$scope.airDeliveryOrder.mblNo=result.hblBean.mblNo.toString();

	    		}
   	    	  for(var i=0;i<data.lSeaDeliveryOrderDetailBean.length;i++) 
   	          	{
   	          	if(data.lSeaDeliveryOrderDetailBean[i].size!=null && data.lSeaDeliveryOrderDetailBean[i].origin!='')
   	          		{
   						$scope.lSeaDeliveryOrderDetailBean[i].size=data.lSeaDeliveryOrderDetailBean[i].size.toString();

   	          		}

   	          	}
   	    });   
       }
   }
   
   
   $scope.quickLinkMethd=function(qulkVal){
		if(qulkVal!='Select'){
			if($scope.airDeliveryOrder.doId!='' && $scope.airDeliveryOrder.doId!=undefined){
			$http.post($stateParams.tenantid + '/app/air/deliveryOrder/getQuickLinkId?category='+qulkVal+'&deliveryId='+$scope.airDeliveryOrder.doId).success(function(datas) {
						if(datas.quickLinkId!=null){
							var rowid=datas.quickLinkId;
							if(qulkVal=="Job Order"){
								if(rowid !=0){
									$location.url($stateParams.tenantid+'/jobOrderAir/edit?rowid='+rowid); 
									//$window.open('#'+$stateParams.tenantid+'/jobOrderSea/view?rowid='+rowid, '_blank');	
								}else{
									logger.logError("There is no "+qulkVal);
								}
							}else if(qulkVal=="HAWB"){
								if(rowid !=0){
									$location.url($stateParams.tenantid+'/hbw/edit?rowid='+rowid); 
									//$window.open('#'+$stateParams.tenantid+'/hbl/view?rowid='+rowid, '_blank');
								}else{
									logger.logError("There is no "+qulkVal);
								}
							}else if(qulkVal=="MAWB"){
								if(rowid !=0){
									$location.url($stateParams.tenantid+'/mabw/edit?rowid='+rowid); 
									//$window.open('#'+$stateParams.tenantid+'/mabl/view?rowid='+rowid,'_blank');
								}else{
									logger.logError("There is no "+qulkVal);
								}
							}else if(qulkVal=="Sales Invoice"){
								if(rowid !=0){
									$location.url($stateParams.tenantid+'/invoice/salesinvoice/salesInvoiceView/'+rowid); 
									//$window.open('#'+$stateParams.tenantid+"/invoice/seasalesinvoice/salesInvoiceView/"+rowid,'_blank');	
								}else{
									logger.logError("There is no "+qulkVal);
								}
							}else if(qulkVal=="Purchase Invoice"){
								if(rowid !=0){
									$location.url($stateParams.tenantid+'/invoice/purchaseinvoice/PurchaseInvoiceView/'+rowid); 
									//$window.open('#'+$stateParams.tenantid+"/invoice/seapurchaseinvoice/PurchaseInvoiceView/"+rowid,'_blank');	
								}else{
									logger.logError("There is no "+qulkVal);
								}
							}
						} else if(datas.quickLinkIdList!=null){
							var quickLinkIdList=datas.quickLinkIdList
							if(qulkVal=="Job Order"){
								$location.url($stateParams.tenantid+'/jobOrderAir/add?quickLinkIdList='+quickLinkIdList, '_blank');
							}else if(qulkVal=="HAWB"){
								$location.url($stateParams.tenantid+'/mabw/add?rowid='+quickLinkIdList, '_blank');
							}else if(qulkVal=="MAWB"){
								$location.url($stateParams.tenantid+'/hbw/add?rowid='+quickLinkIdList, '_blank');
							}else if(qulkVal=="Sales Invoice"){
								$location.url(+$stateParams.tenantid+'/invoice/salesinvoice/salesInvoiceView?quickLinkIdList='+quickLinkIdList,'_blank');
							}else if(qulkVal=="Purchase Invoice"){
								$location.url($stateParams.tenantid+'/invoice/purchaseinvoice/PurchaseInvoiceView?quickLinkIdList='+quickLinkIdList,'_blank');
							}
						}else{
							logger.logError("There is no "+qulkVal);
						}
						
			})
		}
	}
	}

});