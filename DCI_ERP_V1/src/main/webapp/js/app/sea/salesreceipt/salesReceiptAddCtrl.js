'use strict';

app.controller('salesreceiptAddCtrl', function($scope, $rootScope, $http, $location, logger, ngDialog,
        utilsService,$state,sharedProperties,$window,$stateParams,toaster,validationService) {

 $scope.displayedCollection = [];
var date  = new Date();
var dateString =  date.getDate() + "/" + date.getMonth() + "/" + date.getFullYear() + " " + date.getHours() + ":" + date.getMinutes();
	$scope.rowCollectionFollowup=[];
    $scope.referralList=[];
    $scope.isEdit = false;
    $scope.tairDetailList =[];
	
	

    $scope.cancel = function() {
	  	  $state.go('app.sea.salesreceipt.list',{tenantid:$stateParams.tenantid});
	  	  
	          
	    };
    
	    $scope.lHablContainerBean =[];

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
	         };
	    $scope.tempHablContainerBean = {
	    		select 		:false,
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
	    		measurement:'',
	    		hblContainerNo:''
	    	};
	    $scope.lHablContainerBean =[];
  $scope.addCredRow = function() {
   
	  var tmp=angular.copy($scope.tempHablContainerBean);
		$scope.lHablContainerBean.push(tmp);

  }
  
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
			$http.post($stateParams.tenantid+'/app/master/vendor/deleteKeyDetail',lHablContainerBean).success(function(data) {
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

	var hblNo = $location.search().rowid;
	if(hblNo!=null && hblNo!=undefined && hblNo>0){
		$scope.isEdit=true;
        $http.post($stateParams.tenantid+'/app/master/hbl/edit?hblId='+hblNo).success(function(data) {
        	if(data.success){
        		$scope.hbl = data.hblBean;
        		$scope.lHablContainerBean=data.lhblContainerBean;
        		$scope.hbl.jobNo = data.hblBean.jobNo.toString();
        		$scope.hbl.mblNo = data.hblBean.mblNo.toString();
        		$scope.hbl.pol = data.hblBean.pol.toString();
        		$scope.hbl.pod = data.hblBean.pod.toString();
        		$scope.hbl.term = data.hblBean.term.toString();
        		$scope.hbl.customer = data.hblBean.customer.toString();
        		$scope.hbl.branch = data.hblBean.branch.toString();

        	
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
    		  
    		   if(data.hblBean.consignee!=null && data.hblBean.consignee!='')
			   {
        		$scope.hbl.consignee = data.hblBean.consignee.toString();;

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
    		   if(data.hblBean.destinationAgent!=null && data.hblBean.destinationAgent!='')
			   {
        		$scope.hbl.destinationAgent = data.hblBean.destinationAgent.toString();;

			    }
    		   if(data.hblBean.currency!=null && data.hblBean.currency!='')
			   {
        		$scope.hbl.currency = data.hblBean.currency.toString();;

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
          		$scope.currencyList=data.currency;
          		$scope.jobList=data.seaJob;
          		$scope.salesPersonList=data.salesPerson;
          		$scope.mblList=data.mbl;
          		$scope.hblList=data.hbl;
  	          	
  	          });	
        	
        	}else{
        		logger.logError("Unable to fetch data");
        	}
        });
	}
	
	  /*$http.post($stateParams.tenantid+'/app/master/vendor/getMapDetail').success(function(data) {
      	if(data.success){
      		$scope.servicePartnerType=data.servicePartnerType;
      	}
      });*/
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
          		$scope.mblList=data.mbl;
          		$scope.hblList=data.hbl;
          });
	$scope.save = function(servicePartnerAddForm){
		if (new validationService().checkFormValidity(servicePartnerAddForm)) {
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
			var obj = {
					hblBean : $scope.hbl,
					lhblContainerBean	: $scope.lHablContainerBean,

			}
            $http.post($stateParams.tenantid+'/app/master/hbl/save',obj).success(function(data) {
            	if(data.success){
            		logger.logSuccess('Saved Successfully');
            		$scope.cancel();
            	}else{
            		logger.logError('Unable to save!');
            	}
            	
            });
		}else {
            toaster.pop('error', "Please fill the required fields", 
                    logger.getErrorHtmlNew(servicePartnerAddForm.$validationSummary), 5000, 'trustedHtml');
        }
	}
	$scope.update = function(servicePartnerAddForm){
		if (new validationService().checkFormValidity(servicePartnerAddForm)) {
			
			var obj = {
					hblBean : $scope.hbl,
					lhblContainerBean	: $scope.lHablContainerBean,

			}
            $http.post($stateParams.tenantid+'/app/master/hbl/update',obj).success(function(data) {
            	if(data.success){
            		logger.logSuccess('Updated Successfully');
            		$scope.cancel();
            	}else{
            		logger.logError('Unable to save!');
            	}
            	
            });
		}else {
            toaster.pop('error', "Please fill the required fields", 
                    logger.getErrorHtmlNew(servicePartnerAddForm.$validationSummary), 5000, 'trustedHtml');
        }
	}

		

});

