'use strict';

app.controller('deliveryorderAddCtrl', function($scope, $rootScope, $http, $location, logger,
        utilsService,$state,sharedProperties,$window,validationService,toaster,$stateParams) {	
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.edit = true;
    $scope.lSeaDeliveryOrderDetailBean =[];
    $scope.isEdit=false;
    $scope.mblList=[];
	$scope.hblList=[];
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
    	
    };
    
	  $scope.templSeaDeliveryOrderDetailBean = {
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
				measurement:'',
				hblContainerNo:'',
			    status:''	
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

		$scope.airDeliveryOrder.doDate = dd + '/' + mm + '/'
				+ yyyy;
		
	  $scope.addCredRow = function() {
	   
		  var tmp=angular.copy($scope.templSeaDeliveryOrderDetailBean);
			$scope.lSeaDeliveryOrderDetailBean.push(tmp);

	  }
	  $scope.addCredRow();

		$scope.removeCredRow =function(){
			if($scope.isEdit==false){
				var tmpDelList = [];
				for(var i=$scope.lSeaDeliveryOrderDetailBean.length-1;i>=0;i--){
					if($scope.lSeaDeliveryOrderDetailBean[i].select==true){
						tmpDelList.push($scope.lSeaDeliveryOrderDetailBean[i]);
						$scope.lSeaDeliveryOrderDetailBean.splice(i, 1);
					}
				}
				logger.logSuccess('Deleted Successfully');
			}else if($scope.isEdit==true){
				var tmpDelList = [];
				for(var i=$scope.lSeaDeliveryOrderDetailBean.length-1;i>=0;i--){
					if($scope.lSeaDeliveryOrderDetailBean[i].select==true){
						tmpDelList.push($scope.lSeaDeliveryOrderDetailBean[i]);
					}
				}
				$http.post($stateParams.tenantid+'/app/master/vendor/deleteKeyDetail',tmpDelList).success(function(data) {
		        	if(data.success){
		        		for(var i=$scope.lSeaDeliveryOrderDetailBean.length-1;i>=0;i--){
		    				if($scope.lSeaDeliveryOrderDetailBean[i].select==true){
		    					$scope.lSeaDeliveryOrderDetailBean.splice(i, 1);
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
        $state.go("app.sea.deliveryorder.list",{tenantid:$stateParams.tenantid});
    };  
   
    $scope.oldJob='';
    
    $scope.$watch('airDeliveryOrder.jobNo',function(newValue, oldValue) {
		if(newValue!=null && newValue!=undefined && newValue!="")
			{
			
			
        $http.post($stateParams.tenantid+'/app/master/hbl/getJobDetail?jobId='+newValue).success(function(data) {
        	if(data.success){
        		if($scope.oldJob != newValue){
        		$scope.airDeliveryOrder.pol = data.hblBean.pol.toString();
        		$scope.airDeliveryOrder.pod = data.hblBean.pod.toString();
        		//$scope.airDeliveryOrder.term = data.hblBean.term.toString();
        		$scope.airDeliveryOrder.origin = data.hblBean.origin.toString();
        		$scope.airDeliveryOrder.destination = data.hblBean.origin.toString();
        		$scope.airDeliveryOrder.branch = data.hblBean.branch.toString();
        		$scope.airDeliveryOrder.customer = data.hblBean.customer.toString();
        		
        		//$scope.airDeliveryOrder.shipper = data.hblBean.shipper.toString();
        		$scope.airDeliveryOrder.vendor = data.hblBean.vendor.toString();
        		$scope.airDeliveryOrder.vessel = data.hblBean.vesselVoyeage.toString();
        		$scope.lSeaDeliveryOrderDetailBean=data.lhblContainerBean;
        	 	for(var j=$scope.lSeaDeliveryOrderDetailBean.length-1 ;j>=0;j-- )
     			{
     		$scope.lSeaDeliveryOrderDetailBean[j]=data.lhblContainerBean[j];
     		$scope.lSeaDeliveryOrderDetailBean[j].size = data.lhblContainerBean[j].size.toString();
     		$scope.lSeaDeliveryOrderDetailBean[j].uOm = data.lhblContainerBean[j].uOm.toString();
     			}
        	 	$scope.mblList=data.mblList;
          		$scope.hblList=data.hblList;
          		$scope.airDeliveryOrder.consignee = data.hblBean.consignee.toString();
        		//$scope.hbl.salesperson = data.hblBean.salesperson.toString();

        	/*
        		
    		   if(data.hblBean.currency!=null && data.hblBean.currency!='')
			   {
        		$scope.hbl.currency = data.hblBean.currency.toString();;

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
          		$scope.destinationAgentList=data.destination;	
          		$scope.currencyList=data.currency;
          		$scope.jobList=data.seaJob;
          		$scope.salesPersonList=data.salesPerson;
          		/*$scope.mblList=data.mbl;
          		$scope.hblList=data.hbl;*/
          		$scope.sizeList=data.sizeList;
          		$scope.paymentList=data.paymentList;
          		$scope.uomList=data.uom;
          		$scope.statusList=data.deliveryStatus;

  	          });
        	
        	}
        	}
        	else{
        		logger.logError("Unable to fetch data");
        	}
        });
			}
	})
    $http.post($stateParams.tenantid+'/app/master/hbl/dropDownList').success(function(data) {
    
      		$scope.vendorList=data.vendor;
      		$scope.customerList=data.customer;
      		$scope.termList=data.term;
      		$scope.designationList=data.destination;
      		$scope.originList=data.origin;
      		$scope.branchList=data.branch;
      		$scope.podList=data.pod;
      		$scope.polList=data.pol;
      		$scope.typeList=data.typeList;
      		$scope.movementList=data.movement;
      		$scope.preCarriageList=data.preCarriaged;
      		$scope.destinationAgentList=data.destination;	
      		//$scope.hblList=data.hbl;
      		$scope.consigneeList=data.customer;
      		/*$scope.mblList=data.hbl;
      		$scope.hblList=data.mbl;*/
      		$scope.jobList=data.seaJob;
      		$scope.sizeList=data.sizeList;
      		$scope.statusList=data.deliveryStatus;
      		$scope.uomList=data.uom;
      	
      });
    
    //edit
    var editid = $location.search().rowid;    
    var test = parseInt(editid);
    if(test){
    	$scope.isEdit = true;
    	 $http.post($stateParams.tenantid+'/app/sea/deliveryOrder/edit?hblId='+editid).success(function(result) {
    	    	console.log(result);
    	     $scope.airDeliveryOrder = result.hblBean;
    	     $scope.oldJob=result.hblBean.jobNo;
			 $scope.lSeaDeliveryOrderDetailBean=result.lSeaDeliveryOrderDetailBean;
			 $scope.airDeliveryOrder.pol = result.hblBean.pol.toString();
 	    	$scope.airDeliveryOrder.pod = result.hblBean.pod.toString();
 	    	$scope.airDeliveryOrder.branch = result.hblBean.branch.toString();
 	    	$scope.airDeliveryOrder.jobNo = result.hblBean.jobNo.toString();
 	    	$scope.mblList=result.mblList;
      		$scope.hblList=result.hblList;
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
    	    	  
 	    	  for(var i=0;i<result.lSeaDeliveryOrderDetailBean.length;i++) 
          	{
				$scope.lSeaDeliveryOrderDetailBean[i].status=result.lSeaDeliveryOrderDetailBean[i].status.toString();
				$scope.lSeaDeliveryOrderDetailBean[i].size=result.lSeaDeliveryOrderDetailBean[i].size.toString();
				$scope.lSeaDeliveryOrderDetailBean[i].uOm=result.lSeaDeliveryOrderDetailBean[i].uOm.toString();
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
		
		if($scope.airDeliveryOrder.arrivalDate=="" || $scope.airDeliveryOrder.arrivalDate==undefined)
		{
		$scope.airDeliveryOrder.arrivalDate=null
		}
		if($scope.airDeliveryOrder.igmDate=="" || $scope.airDeliveryOrder.igmDate==undefined)
		{
		$scope.airDeliveryOrder.igmDate=null
		}
		 for(var i=0;i<$scope.lSeaDeliveryOrderDetailBean.length;i++){
   			 if ($scope.lSeaDeliveryOrderDetailBean[i].noofPackage != undefined && $scope.lSeaDeliveryOrderDetailBean[i].noofPackage != null && $scope.lSeaDeliveryOrderDetailBean[i].noofPackage != '') {
   				if (flag1 == true)
   					{
      				 flag1 = validateNos($scope.lSeaDeliveryOrderDetailBean[i].noofPackage);

   					}
   	         }	
   			 if ($scope.lSeaDeliveryOrderDetailBean[i].uOm != undefined && $scope.lSeaDeliveryOrderDetailBean[i].uOm != null && $scope.lSeaDeliveryOrderDetailBean[i].uOm != '') {
   				if (flag2 == true)
					{
   				 flag2 = validateNos($scope.lSeaDeliveryOrderDetailBean[i].uOm);
					}
   	         }
   			 if ($scope.lSeaDeliveryOrderDetailBean[i].netWeight != undefined && $scope.lSeaDeliveryOrderDetailBean[i].netWeight != null && $scope.lSeaDeliveryOrderDetailBean[i].netWeight != '') {
   				if (flag3== true)
				{
   				 flag3 = validateDouble($scope.lSeaDeliveryOrderDetailBean[i].netWeight);
				}
   	         }
   			 if ($scope.lSeaDeliveryOrderDetailBean[i].grossWeight != undefined && $scope.lSeaDeliveryOrderDetailBean[i].grossWeight != null && $scope.lSeaDeliveryOrderDetailBean[i].grossWeight != '') {
   				if (flag4 == true)
				{
   				 flag4 = validateDouble($scope.lSeaDeliveryOrderDetailBean[i].grossWeight);
				}
   	         }
   		}
    	var obj = {
    			hblBean : $scope.airDeliveryOrder,
				lSeaDeliveryOrderDetailBean	: $scope.lSeaDeliveryOrderDetailBean,

		}
		if (flag1 == true && flag2 == true && flag2 == true && flag3 == true && flag4 == true && flag5 == true) {

    	 $http.post($stateParams.tenantid+'/app/sea/deliveryOrder/save',obj).success(function(result) {    	
    		 console.log(result);
    		 
             if (result.success==true) {
                 logger.logSuccess("Saved Successfully!");
                 $state.go("app.sea.deliveryorder.list",{tenantid:$stateParams.tenantid});
             } else {
                 logger.logError("Name Already Exists");
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
                    logger.getErrorHtmlNew(airDeliveryOrderForm.$validationSummary), 5000, 'trustedHtml');
        }
    };
    
    //update
    $scope.update = function(airDeliveryOrderForm) {
    	if (new validationService().checkFormValidity(airDeliveryOrderForm)) {
            var flag1 = true, flag2 = true, flag3 = true, flag4 = true, flag5 = true;
            for(var i=0;i<$scope.lSeaDeliveryOrderDetailBean.length;i++){
   			 if ($scope.lSeaDeliveryOrderDetailBean[i].noofPackage != undefined && $scope.lSeaDeliveryOrderDetailBean[i].noofPackage != null && $scope.lSeaDeliveryOrderDetailBean[i].noofPackage != '') {
   				if (flag1 == true)
   					{
      				 flag1 = validateNos($scope.lSeaDeliveryOrderDetailBean[i].noofPackage);

   					}
   	         }	
   			 if ($scope.lSeaDeliveryOrderDetailBean[i].uOm != undefined && $scope.lSeaDeliveryOrderDetailBean[i].uOm != null && $scope.lSeaDeliveryOrderDetailBean[i].uOm != '') {
   				if (flag2 == true)
					{
   				 flag2 = validateNos($scope.lSeaDeliveryOrderDetailBean[i].uOm);
					}
   	         }
   			 if ($scope.lSeaDeliveryOrderDetailBean[i].netWeight != undefined && $scope.lSeaDeliveryOrderDetailBean[i].netWeight != null && $scope.lSeaDeliveryOrderDetailBean[i].netWeight != '') {
   				if (flag3== true)
				{
   				 flag3 = validateDouble($scope.lSeaDeliveryOrderDetailBean[i].netWeight);
				}
   	         }
   			 if ($scope.lSeaDeliveryOrderDetailBean[i].grossWeight != undefined && $scope.lSeaDeliveryOrderDetailBean[i].grossWeight != null && $scope.lSeaDeliveryOrderDetailBean[i].grossWeight != '') {
   				if (flag4 == true)
				{
   				 flag4 = validateDouble($scope.lSeaDeliveryOrderDetailBean[i].grossWeight);
				}
   	         }
   		}
        	var obj = {
        			hblBean : $scope.airDeliveryOrder,
    				lSeaDeliveryOrderDetailBean	: $scope.lSeaDeliveryOrderDetailBean,

    		}
    		if (flag1 == true && flag2 == true && flag3 == true && flag4 == true && flag5 == true) {

   	 $http.post($stateParams.tenantid+'/app/sea/deliveryOrder/update', obj).success(function(result) {    	
   		 console.log(result);
            if (result.success==true) {
                logger.logSuccess("Update Successfully!");
                $state.go("app.sea.deliveryorder.list",{tenantid:$stateParams.tenantid});
            } else {
                logger.logError(result.message);
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

   function validateDouble(pincode) {
	     var reg = /^[0-9]+(\.[0-9]+)?$/


	        if (reg.test(pincode)) {
	            return true;
	        } else {
	            
	            return false;
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
   var editid = $location.search().rowid;  
   if(editid!=null&&editid!=""&&editid!=undefined)
	   {
	   $scope.print=function(){
		    var url = $stateParams.tenantid+'/app/sea/deliveryOrder/print?hblId='+editid;
	        var wnd = window.open(url, 'DeliveryOrder', 'height=700,width=850,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
	        wnd.print();
	   }
	   $scope.printCan = function(rowid){
	       debugger
	       console.log("Both print invoice")
	       var url = $stateParams.tenantid+'/app/sea/deliveryOrder/printcan?hblId=' + rowid;
	       var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
	       wnd.print();   
	    }
	  

	}
 
$scope.reset=function(){
       
       if( $scope.isEdit == false){ 
    	   $scope.lSeaDeliveryOrderDetailBean =[];
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
    	    	
    	    };
       }else {
    	   $http.post($stateParams.tenantid+'/app/sea/deliveryOrder/edit?hblId='+editid).success(function(result) {
   	    	console.log(result);
   	     $scope.airDeliveryOrder = result.hblBean;
			 $scope.lSeaDeliveryOrderDetailBean=result.lSeaDeliveryOrderDetailBean;
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
   	    	  
	    	  for(var i=0;i<result.lSeaDeliveryOrderDetailBean.length;i++) 
         	{
         	if(result.lSeaDeliveryOrderDetailBean[i].size!=null && result.lSeaDeliveryOrderDetailBean[i].origin!='')
         		{
					$scope.lSeaDeliveryOrderDetailBean[i].size=result.lSeaDeliveryOrderDetailBean[i].size.toString();

         		}
       	if(result.lSeaDeliveryOrderDetailBean[i].status!=null && result.lSeaDeliveryOrderDetailBean[i].status!='')
     		{
				$scope.lSeaDeliveryOrderDetailBean[i].status=result.lSeaDeliveryOrderDetailBean[i].status.toString();

     		}
         	}
   	    });      
       }
   }


			$scope.quickLinkMethd=function(qulkVal){
				if(qulkVal!='Select'){
					if($scope.airDeliveryOrder.doId!='' && $scope.airDeliveryOrder.doId!=undefined && qulkVal!='' && qulkVal!=undefined){
					$http.post($stateParams.tenantid + '/app/sea/deliveryOrder/getQuickLinkId?category='+qulkVal+'&delivery='+$scope.airDeliveryOrder.doId).success(function(datas) {
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
									}else if(qulkVal=="MBL" && rowid !=0){
										if(rowid !=0){
											$location.url($stateParams.tenantid+'/mabl/edit?rowid='+rowid);
											//$window.open('#'+$stateParams.tenantid+'/mabl/view?rowid='+rowid,'_blank');
										}else{
											logger.logError("There is no "+qulkVal);
										}
									}else if(qulkVal=="Sales Invoice" && rowid !=0){
										if(rowid !=0){
											$location.url($stateParams.tenantid+'/invoice/seasalesinvoice/salesInvoiceView'+rowid);
											//$window.open('#'+$stateParams.tenantid+'/invoice/seasalesinvoice/salesInvoiceView/'+rowid,'_blank');
										}else{
											logger.logError("There is no "+qulkVal);
										}
									}else if(qulkVal=="Purchase Invoice" && rowid !=0){
										if(rowid !=0){
											$location.url($stateParams.tenantid+'/invoice/seapurchaseinvoice/PurchaseInvoiceView'+rowid);
											//$window.open('#'+$stateParams.tenantid+'/invoice/seapurchaseinvoice/PurchaseInvoiceView/'+rowid,'_blank');
										}else{
											logger.logError("There is no "+qulkVal);
										}
									}
								} else if(datas.quickLinkIdList!=null){
									var quickLinkIdList=datas.quickLinkIdList
									if(qulkVal=="Job Order"){
										$window.open('#'+$stateParams.tenantid+'/seajoborder/list?quickLinkIdList='+quickLinkIdList, '_blank');
									}else if(qulkVal=="HBL"){
										$window.open('#'+$stateParams.tenantid+'/mabl/list?rowid='+quickLinkIdList, '_blank');
									}else if(qulkVal=="MBL"){
										$window.open('#'+$stateParams.tenantid+'/hbl/list?rowid='+quickLinkIdList, '_blank');
									}else if(qulkVal=="Sales Invoice"){
										$window.open('#'+$stateParams.tenantid+'/invoice/sea/seasalesinvoice/SalesInvoiceList?quickLinkIdList='+quickLinkIdList, '_blank');
									}else if(qulkVal=="Purchase Invoice"){
										$window.open('#'+$stateParams.tenantid+'/invoice/sea/seapurchaseinvoice/PurchaseInvoiceList?quickLinkIdList='+quickLinkIdList, '_blank');
									}
								}else{
									logger.logError("There is no "+qulkVal);
								}
								
					})
				}
			}
			}


});



app.controller('deliveryorderViewCtrl', function($scope, $rootScope, $http, $location, logger,
        utilsService,$state,sharedProperties,$window,validationService,toaster,$stateParams) {	
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.edit = true;
    $scope.lSeaDeliveryOrderDetailBean =[];
    $scope.isEdit=false;
    $scope.mblList=[];
	$scope.hblList=[];
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
    	
    };
    
	  $scope.templSeaDeliveryOrderDetailBean = {
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
				measurement:'',
				hblContainerNo:'',
			    status:''	
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

		$scope.airDeliveryOrder.doDate = dd + '/' + mm + '/'
				+ yyyy;
		
	  $scope.addCredRow = function() {
	   
		  var tmp=angular.copy($scope.templSeaDeliveryOrderDetailBean);
			$scope.lSeaDeliveryOrderDetailBean.push(tmp);

	  }
	  $scope.addCredRow();

		$scope.removeCredRow =function(){
			if($scope.isEdit==false){
				var tmpDelList = [];
				for(var i=$scope.lSeaDeliveryOrderDetailBean.length-1;i>=0;i--){
					if($scope.lSeaDeliveryOrderDetailBean[i].select==true){
						tmpDelList.push($scope.lSeaDeliveryOrderDetailBean[i]);
						$scope.lSeaDeliveryOrderDetailBean.splice(i, 1);
					}
				}
				logger.logSuccess('Deleted Successfully');
			}else if($scope.isEdit==true){
				var tmpDelList = [];
				for(var i=$scope.lSeaDeliveryOrderDetailBean.length-1;i>=0;i--){
					if($scope.lSeaDeliveryOrderDetailBean[i].select==true){
						tmpDelList.push($scope.lSeaDeliveryOrderDetailBean[i]);
					}
				}
				$http.post($stateParams.tenantid+'/app/master/vendor/deleteKeyDetail',tmpDelList).success(function(data) {
		        	if(data.success){
		        		for(var i=$scope.lSeaDeliveryOrderDetailBean.length-1;i>=0;i--){
		    				if($scope.lSeaDeliveryOrderDetailBean[i].select==true){
		    					$scope.lSeaDeliveryOrderDetailBean.splice(i, 1);
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
        $state.go("app.sea.deliveryorder.list",{tenantid:$stateParams.tenantid});
    };  
   
    $scope.oldJob='';
    
    $scope.$watch('airDeliveryOrder.jobNo',function(newValue, oldValue) {
		if(newValue!=null && newValue!=undefined && newValue!="")
			{
			
			
        $http.post($stateParams.tenantid+'/app/master/hbl/getJobDetail?jobId='+newValue).success(function(data) {
        	if(data.success){
        		if($scope.oldJob != newValue){
        		$scope.airDeliveryOrder.pol = data.hblBean.pol.toString();
        		$scope.airDeliveryOrder.pod = data.hblBean.pod.toString();
        		//$scope.airDeliveryOrder.term = data.hblBean.term.toString();
        		$scope.airDeliveryOrder.origin = data.hblBean.origin.toString();
        		$scope.airDeliveryOrder.destination = data.hblBean.origin.toString();
        		$scope.airDeliveryOrder.branch = data.hblBean.branch.toString();
        		$scope.airDeliveryOrder.customer = data.hblBean.customer.toString();
        		
        		//$scope.airDeliveryOrder.shipper = data.hblBean.shipper.toString();
        		$scope.airDeliveryOrder.vendor = data.hblBean.vendor.toString();
        		$scope.airDeliveryOrder.vessel = data.hblBean.vesselVoyeage.toString();
        		$scope.lSeaDeliveryOrderDetailBean=data.lhblContainerBean;
        	 	for(var j=$scope.lSeaDeliveryOrderDetailBean.length-1 ;j>=0;j-- )
     			{
     		$scope.lSeaDeliveryOrderDetailBean[j]=data.lhblContainerBean[j];
     		$scope.lSeaDeliveryOrderDetailBean[j].size = data.lhblContainerBean[j].size.toString();
     		$scope.lSeaDeliveryOrderDetailBean[j].uOm = data.lhblContainerBean[j].uOm.toString();
     			}
        	 	$scope.mblList=data.mblList;
          		$scope.hblList=data.hblList;
          		$scope.airDeliveryOrder.consignee = data.hblBean.consignee.toString();
        		//$scope.hbl.salesperson = data.hblBean.salesperson.toString();

        	/*
        		
    		   if(data.hblBean.currency!=null && data.hblBean.currency!='')
			   {
        		$scope.hbl.currency = data.hblBean.currency.toString();;

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
          		$scope.destinationAgentList=data.destination;	
          		$scope.currencyList=data.currency;
          		$scope.jobList=data.seaJob;
          		$scope.salesPersonList=data.salesPerson;
          		/*$scope.mblList=data.mbl;
          		$scope.hblList=data.hbl;*/
          		$scope.sizeList=data.sizeList;
          		$scope.paymentList=data.paymentList;
          		$scope.uomList=data.uom;
          		$scope.statusList=data.deliveryStatus;

  	          });
        	
        	}
        	}
        	else{
        		logger.logError("Unable to fetch data");
        	}
        });
			}
	})
    $http.post($stateParams.tenantid+'/app/master/hbl/dropDownList').success(function(data) {
    
      		$scope.vendorList=data.vendor;
      		$scope.customerList=data.customer;
      		$scope.termList=data.term;
      		$scope.designationList=data.destination;
      		$scope.originList=data.origin;
      		$scope.branchList=data.branch;
      		$scope.podList=data.pod;
      		$scope.polList=data.pol;
      		$scope.typeList=data.typeList;
      		$scope.movementList=data.movement;
      		$scope.preCarriageList=data.preCarriaged;
      		$scope.destinationAgentList=data.destination;	
      		//$scope.hblList=data.hbl;
      		$scope.consigneeList=data.customer;
      		/*$scope.mblList=data.hbl;
      		$scope.hblList=data.mbl;*/
      		$scope.jobList=data.seaJob;
      		$scope.sizeList=data.sizeList;
      		$scope.statusList=data.deliveryStatus;
      		$scope.uomList=data.uom;
      	
      });
    
    //edit
    var editid = $location.search().rowid;    
    var test = parseInt(editid);
    if(test){
    	$scope.isEdit = true;
    	 $http.post($stateParams.tenantid+'/app/sea/deliveryOrder/view?hblId='+editid).success(function(result) {
    	    	console.log(result);
    	     $scope.airDeliveryOrder = result.hblBean;
    	     $scope.oldJob=result.hblBean.jobNo;
			 $scope.lSeaDeliveryOrderDetailBean=result.lSeaDeliveryOrderDetailBean;
			 $scope.airDeliveryOrder.pol = result.hblBean.pol.toString();
 	    	$scope.airDeliveryOrder.pod = result.hblBean.pod.toString();
 	    	$scope.airDeliveryOrder.branch = result.hblBean.branch.toString();
 	    	$scope.airDeliveryOrder.jobNo = result.hblBean.jobNo.toString();
 	    	$scope.mblList=result.mblList;
      		$scope.hblList=result.hblList;
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
    	    	  
 	    	  for(var i=0;i<result.lSeaDeliveryOrderDetailBean.length;i++) 
          	{
				$scope.lSeaDeliveryOrderDetailBean[i].status=result.lSeaDeliveryOrderDetailBean[i].status.toString();
				$scope.lSeaDeliveryOrderDetailBean[i].size=result.lSeaDeliveryOrderDetailBean[i].size.toString();
				$scope.lSeaDeliveryOrderDetailBean[i].uOm=result.lSeaDeliveryOrderDetailBean[i].uOm.toString();
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
		
		if($scope.airDeliveryOrder.arrivalDate=="" || $scope.airDeliveryOrder.arrivalDate==undefined)
		{
		$scope.airDeliveryOrder.arrivalDate=null
		}
		if($scope.airDeliveryOrder.igmDate=="" || $scope.airDeliveryOrder.igmDate==undefined)
		{
		$scope.airDeliveryOrder.igmDate=null
		}
		 for(var i=0;i<$scope.lSeaDeliveryOrderDetailBean.length;i++){
   			 if ($scope.lSeaDeliveryOrderDetailBean[i].noofPackage != undefined && $scope.lSeaDeliveryOrderDetailBean[i].noofPackage != null && $scope.lSeaDeliveryOrderDetailBean[i].noofPackage != '') {
   				if (flag1 == true)
   					{
      				 flag1 = validateNos($scope.lSeaDeliveryOrderDetailBean[i].noofPackage);

   					}
   	         }	
   			 if ($scope.lSeaDeliveryOrderDetailBean[i].uOm != undefined && $scope.lSeaDeliveryOrderDetailBean[i].uOm != null && $scope.lSeaDeliveryOrderDetailBean[i].uOm != '') {
   				if (flag2 == true)
					{
   				 flag2 = validateNos($scope.lSeaDeliveryOrderDetailBean[i].uOm);
					}
   	         }
   			 if ($scope.lSeaDeliveryOrderDetailBean[i].netWeight != undefined && $scope.lSeaDeliveryOrderDetailBean[i].netWeight != null && $scope.lSeaDeliveryOrderDetailBean[i].netWeight != '') {
   				if (flag3== true)
				{
   				 flag3 = validateDouble($scope.lSeaDeliveryOrderDetailBean[i].netWeight);
				}
   	         }
   			 if ($scope.lSeaDeliveryOrderDetailBean[i].grossWeight != undefined && $scope.lSeaDeliveryOrderDetailBean[i].grossWeight != null && $scope.lSeaDeliveryOrderDetailBean[i].grossWeight != '') {
   				if (flag4 == true)
				{
   				 flag4 = validateDouble($scope.lSeaDeliveryOrderDetailBean[i].grossWeight);
				}
   	         }
   		}
    	var obj = {
    			hblBean : $scope.airDeliveryOrder,
				lSeaDeliveryOrderDetailBean	: $scope.lSeaDeliveryOrderDetailBean,

		}
		if (flag1 == true && flag2 == true && flag2 == true && flag3 == true && flag4 == true && flag5 == true) {

    	 $http.post($stateParams.tenantid+'/app/sea/deliveryOrder/save',obj).success(function(result) {    	
    		 console.log(result);
    		 
             if (result.success==true) {
                 logger.logSuccess("Saved Successfully!");
                 $state.go("app.sea.deliveryorder.list",{tenantid:$stateParams.tenantid});
             } else {
                 logger.logError("Name Already Exists");
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
                    logger.getErrorHtmlNew(airDeliveryOrderForm.$validationSummary), 5000, 'trustedHtml');
        }
    };
    
    //update
    $scope.update = function(airDeliveryOrderForm) {
    	if (new validationService().checkFormValidity(airDeliveryOrderForm)) {
            var flag1 = true, flag2 = true, flag3 = true, flag4 = true, flag5 = true;
            for(var i=0;i<$scope.lSeaDeliveryOrderDetailBean.length;i++){
   			 if ($scope.lSeaDeliveryOrderDetailBean[i].noofPackage != undefined && $scope.lSeaDeliveryOrderDetailBean[i].noofPackage != null && $scope.lSeaDeliveryOrderDetailBean[i].noofPackage != '') {
   				if (flag1 == true)
   					{
      				 flag1 = validateNos($scope.lSeaDeliveryOrderDetailBean[i].noofPackage);

   					}
   	         }	
   			 if ($scope.lSeaDeliveryOrderDetailBean[i].uOm != undefined && $scope.lSeaDeliveryOrderDetailBean[i].uOm != null && $scope.lSeaDeliveryOrderDetailBean[i].uOm != '') {
   				if (flag2 == true)
					{
   				 flag2 = validateNos($scope.lSeaDeliveryOrderDetailBean[i].uOm);
					}
   	         }
   			 if ($scope.lSeaDeliveryOrderDetailBean[i].netWeight != undefined && $scope.lSeaDeliveryOrderDetailBean[i].netWeight != null && $scope.lSeaDeliveryOrderDetailBean[i].netWeight != '') {
   				if (flag3== true)
				{
   				 flag3 = validateDouble($scope.lSeaDeliveryOrderDetailBean[i].netWeight);
				}
   	         }
   			 if ($scope.lSeaDeliveryOrderDetailBean[i].grossWeight != undefined && $scope.lSeaDeliveryOrderDetailBean[i].grossWeight != null && $scope.lSeaDeliveryOrderDetailBean[i].grossWeight != '') {
   				if (flag4 == true)
				{
   				 flag4 = validateDouble($scope.lSeaDeliveryOrderDetailBean[i].grossWeight);
				}
   	         }
   		}
        	var obj = {
        			hblBean : $scope.airDeliveryOrder,
    				lSeaDeliveryOrderDetailBean	: $scope.lSeaDeliveryOrderDetailBean,

    		}
    		if (flag1 == true && flag2 == true && flag3 == true && flag4 == true && flag5 == true) {

   	 $http.post($stateParams.tenantid+'/app/sea/deliveryOrder/update', obj).success(function(result) {    	
   		 console.log(result);
            if (result.success==true) {
                logger.logSuccess("Update Successfully!");
                $state.go("app.sea.deliveryorder.list",{tenantid:$stateParams.tenantid});
            } else {
                logger.logError(result.message);
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
    


      	 $http.post($stateParams.tenantid+'/port/view',test).success(function(result) {
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

   function validateDouble(pincode) {
	     var reg = /^[0-9]+(\.[0-9]+)?$/


	        if (reg.test(pincode)) {
	            return true;
	        } else {
	            
	            return false;
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
   var editid = $location.search().rowid;  
   if(editid!=null&&editid!=""&&editid!=undefined)
	   {
	   $scope.print=function(){
		    var url = $stateParams.tenantid+'/app/sea/deliveryOrder/print?hblId='+editid;
	        var wnd = window.open(url, 'DeliveryOrder', 'height=700,width=850,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
	        wnd.print();
	   }
	   $scope.printCan = function(rowid){
	       debugger
	       console.log("Both print invoice")
	       var url = $stateParams.tenantid+'/app/sea/deliveryOrder/printcan?hblId=' + rowid;
	       var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
	       wnd.print();   
	    }
	  

	}
 
$scope.reset=function(){
       
       if( $scope.isEdit == false){ 
    	   $scope.lSeaDeliveryOrderDetailBean =[];
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
    	    	
    	    };
       }else {
    	   $http.post($stateParams.tenantid+'/app/sea/deliveryOrder/view?hblId='+editid).success(function(result) {
   	    	console.log(result);
   	     $scope.airDeliveryOrder = result.hblBean;
			 $scope.lSeaDeliveryOrderDetailBean=result.lSeaDeliveryOrderDetailBean;
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
   	    	  
	    	  for(var i=0;i<result.lSeaDeliveryOrderDetailBean.length;i++) 
         	{
         	if(result.lSeaDeliveryOrderDetailBean[i].size!=null && result.lSeaDeliveryOrderDetailBean[i].origin!='')
         		{
					$scope.lSeaDeliveryOrderDetailBean[i].size=result.lSeaDeliveryOrderDetailBean[i].size.toString();

         		}
       	if(result.lSeaDeliveryOrderDetailBean[i].status!=null && result.lSeaDeliveryOrderDetailBean[i].status!='')
     		{
				$scope.lSeaDeliveryOrderDetailBean[i].status=result.lSeaDeliveryOrderDetailBean[i].status.toString();

     		}
         	}
   	    });      
       }
   }


			$scope.quickLinkMethd=function(qulkVal){
				if(qulkVal!='Select'){
					if($scope.airDeliveryOrder.doId!='' && $scope.airDeliveryOrder.doId!=undefined && qulkVal!='' && qulkVal!=undefined){
					$http.post($stateParams.tenantid + '/app/sea/deliveryOrder/getQuickLinkId?category='+qulkVal+'&delivery='+$scope.airDeliveryOrder.doId).success(function(datas) {
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
									}else if(qulkVal=="MBL" && rowid !=0){
										if(rowid !=0){
											$location.url($stateParams.tenantid+'/mabl/edit?rowid='+rowid);
											//$window.open('#'+$stateParams.tenantid+'/mabl/view?rowid='+rowid,'_blank');
										}else{
											logger.logError("There is no "+qulkVal);
										}
									}else if(qulkVal=="Sales Invoice" && rowid !=0){
										if(rowid !=0){
											$location.url($stateParams.tenantid+'/invoice/seasalesinvoice/salesInvoiceView'+rowid);
											//$window.open('#'+$stateParams.tenantid+'/invoice/seasalesinvoice/salesInvoiceView/'+rowid,'_blank');
										}else{
											logger.logError("There is no "+qulkVal);
										}
									}else if(qulkVal=="Purchase Invoice" && rowid !=0){
										if(rowid !=0){
											$location.url($stateParams.tenantid+'/invoice/seapurchaseinvoice/PurchaseInvoiceView'+rowid);
											//$window.open('#'+$stateParams.tenantid+'/invoice/seapurchaseinvoice/PurchaseInvoiceView/'+rowid,'_blank');
										}else{
											logger.logError("There is no "+qulkVal);
										}
									}
								} else if(datas.quickLinkIdList!=null){
									var quickLinkIdList=datas.quickLinkIdList
									if(qulkVal=="Job Order"){
										$window.open('#'+$stateParams.tenantid+'/seajoborder/list?quickLinkIdList='+quickLinkIdList, '_blank');
									}else if(qulkVal=="HBL"){
										$window.open('#'+$stateParams.tenantid+'/mabl/list?rowid='+quickLinkIdList, '_blank');
									}else if(qulkVal=="MBL"){
										$window.open('#'+$stateParams.tenantid+'/hbl/list?rowid='+quickLinkIdList, '_blank');
									}else if(qulkVal=="Sales Invoice"){
										$window.open('#'+$stateParams.tenantid+'/invoice/sea/seasalesinvoice/SalesInvoiceList?quickLinkIdList='+quickLinkIdList, '_blank');
									}else if(qulkVal=="Purchase Invoice"){
										$window.open('#'+$stateParams.tenantid+'/invoice/sea/seapurchaseinvoice/PurchaseInvoiceList?quickLinkIdList='+quickLinkIdList, '_blank');
									}
								}else{
									logger.logError("There is no "+qulkVal);
								}
								
					})
				}
			}
			}


});




