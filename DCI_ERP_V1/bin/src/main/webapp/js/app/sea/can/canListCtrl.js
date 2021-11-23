'use strict';

app.controller('canListCtrl', function($scope, $rootScope,ngDialog, $http, $location, logger,
        utilsService,$state,sharedProperties,$window,validationService,toaster,$stateParams) {
	    $scope.dataLoopCount = 0;
	    $scope.offsetCount = 0;
	    $scope.limitCount = 1000;
	    $scope.updatedData = [];
	    $scope.rowCollection = [];
	    $scope.displayedCollection = [];
	    $scope.itemsByPage = 10;
	    $scope.jobList=[];
	    $scope.lHablContainerBean =[];
	    $scope.can = {
	    		 jobNo:'',
	    		 type:'',
	    		 hblNo:'',
	    		 mblNo:'',
	    		 consigneeName:'',
	    		 igmNo :'',
	    		 fpd :'',
	    		 noOfPkgs :'',
	    		 containerNo :'',
	    		 remarks :'',
	    		 pol :'',
	    		 pod :'',
	    		 por :'',
	    		 shipperName :'',
	    		 hblDate :'',
	    		 mblDate :'',
	    		 vessel :'',
	    		 eta :'',
	    		 lineNo :'',
	    		 grossWeight :'',
	    		 destuffPt :'',
	    		 destuffDt :''
	    };
	    
	    $http.post($stateParams.tenantid+'/app/master/hbl/dropDownList').success(function(data) {
	    	$scope.jobList=data.seaJob;
	    });
	  
	    $scope.oldJob='';

		$scope.$watch('can.jobNo',function(newValue, oldValue) {
			if(newValue!=null && newValue!=undefined && newValue!="")
				{
				
				
					
					 $http.post($stateParams.tenantid+'/app/master/hbl/getJobDetail?jobId='+newValue).success(function(data) {
				        	if(data.success){
				        		$scope.hblList=data.hbl;
				        		if($scope.oldJob != newValue){
				        		//$scope.lHablFreightBean=data.lhblFreightBean;
				        		$scope.lHablContainerBean=data.lhblContainerBean;
				        		//$scope.hbl.jobNo = data.hblBean.jobNo.toString();
				        		$scope.can.pol = data.hblBean.pol.toString();
				        		$scope.can.por = data.hblBean.pol.toString();
				        		$scope.can.vessel = data.hblBean.vesselVoyeage.toString();
				        		$scope.can.consigneeName = data.hblBean.consigneename;
				        		$scope.can.shipperName=data.lhblContainer[0].shipperAddress;
				        		$scope.can.por=data.lhblContainer[0].placeofReceipt;
				        		$scope.can.pol=data.lhblContainer[0].portofLoad;
				        		$scope.can.pod=data.lhblContainer[0].portofDischarge;
				        	
				        			
				        		
				        		
				        	}
					 }else{
				        		logger.logError("Unable to fetch data");
				        	}
				        	
				        });
				//}
					$http.post($stateParams.tenantid+'/app/master/can/getJobDetail?jobId='+newValue).success(function(data)
        			 {
						if(data.success){
							if($scope.oldJob != newValue){
						$scope.lHablContainerBean=data.lhblContainer;
						$scope.can.igmNo=data.hblBean.igmNo;
						$scope.can.hblNo=data.hblBean.hblCode;
						$scope.can.mblNo=data.hblBean.mblCode;
						$scope.can.hblDate=data.hblBean.hblDate;
						$scope.can.mblDate=data.hblBean.mblDate;
						$scope.can.eta=data.hblBean.eta;
						$scope.can.remarks=$scope.lHablContainerBean[0].remarks;
						$scope.totalPackageCalculation();
    		    		$scope.totalgrossWeightCalculation();
    		    		var container ='';
    		    		for (var i =0;i<$scope.lHablContainerBean.length;i++)
    		    			{
    		    			if($scope.lHablContainerBean.length ==1)
    		    				{
    		    			container = $scope.lHablContainerBean[i].containerNo;
    		    				}
    		    			else if ($scope.lHablContainerBean.length>1)
    		    				{
    		    			container =  container + ',' + $scope.lHablContainerBean[i].containerNo;
    		    				}
    		    			$scope.can.containerNo=container;
    		    			}
    		    		if($scope.lHablContainerBean.length >1)
    		    			{
    		    			var s=$scope.can.containerNo;
    		    			$scope.can.containerNo=s.substring(1);
    		    			}
							}
						}
						});
				
	       
				}
		})
   
		$scope.totalPackageCalculation = function() {
				debugger;
				var hablContainerBean = $scope.lHablContainerBean;
				var noOfPkgs = 0;
				$scope.checkIsNaN = function(value){
			        if(isNaN(value))
			            value = 0
			            
			        return value;
			    }
				angular.forEach(hablContainerBean, function(item, key) {
					var mablContainerBeanData = hablContainerBean[key];
					noOfPkgs = noOfPkgs + parseFloat(item.noOfPkgs);
					$scope.can.noOfPkgs = noOfPkgs;
					$scope.can.noOfPkgs=$scope.checkIsNaN($scope.can.noOfPkgs);
					
				});
				
				
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
						$scope.can.grossWeight = grossWeight;
						$scope.can.grossWeight=$scope.checkIsNaN($scope.can.grossWeight);

					});

				}

				
				/*$scope.cbpmtDtlTotalAmt.totalBCAmount = $scope.cbpmtDtlTotalAmt.totalBCAmount
						.toFixed(2);
				$scope.cbpmtDtlTotalAmt.totalTCAmount = $scope.cbpmtDtlTotalAmt.totalTCAmount
						.toFixed(2);*/
			}
	    $scope.print = function (canForm,can)
	    {
			
			if (new validationService().checkFormValidity($scope.canForm)) {
	               $scope.printCan();
	           } else {
	               toaster.pop('error', "Please fill the required fields", 
	                       logger.getErrorHtmlNew($scope.canForm.$validationSummary), 5000, 'trustedHtml');
	           }
	    	/*debugger
	        var url = $stateParams.tenantid+'/app/master/can/print?jobNo=' + jobNo;
	        var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
	        wnd.print();*/
	    }
		
		$scope.printCan = function(){
			if($scope.can.hblDate=="" || $scope.can.hblDate==undefined)
			{
			$scope.can.hblDate=null
			}
			if($scope.can.mblDate=="" || $scope.can.mblDate==undefined)
			{
			$scope.can.mblDate=null
			}
			if($scope.can.eta=="" || $scope.can.eta==undefined)
			{
			$scope.can.eta=null
			}
			if($scope.can.destuffDt=="" || $scope.can.destuffDt==undefined)
			{
			$scope.can.destuffDt=null
			}
			
			  $http.post($stateParams.tenantid+'/app/master/can/save', $scope.can).success(function(result) {
                  if (result.success) {
                     console.log(result)
                      var url = $stateParams.tenantid+'/app/master/can/print?jobNo=' + result.jobId;
                      var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
                      wnd.print();   
                     // $scope.purchaseInvoiceData.purchaseInvoiceDetail=$scope.tempData;
                  } else {
                      if(result.message != null && result.message != ''){
                          logger.logError(result.message);
                      }else{
                      logger.logError("Error try again");
                      }
                  }

              }).error(function(data) {
                  console.log(data);
              });
		}
    
     $scope.reset = function()
     {
    	 $scope.can.jobNo = '';
    	 $scope.can.type = '';
    	 $scope.can.hblNo = '';
    	 $scope.can.mblNo = '';
    	 $scope.can.consigneeName = '';
    	 $scope.can.igmNo = '';
    	 $scope.can.fpd = '';
    	 $scope.can.noOfPkgs = '';
    	 $scope.can.containerNo = '';
    	 $scope.can.remarks = '';
    	 $scope.can.pol  = '';
    	 $scope.can.pod  = '';
    	 $scope.can.por  = '';
    	 $scope.can.shipperName  = '';
    	 $scope.can.hblDate  = '';
    	 $scope.can.mblDate  = '';
    	 $scope.can.vessel  = '';
    	 $scope.can.eta  = '';
    	 $scope.can.lineNo  = '';
    	 $scope.can.grossWeight  = '';
    	 $scope.can.destuffPt  = '';
    	 $scope.can.destuffDt  = '';
     }
});


