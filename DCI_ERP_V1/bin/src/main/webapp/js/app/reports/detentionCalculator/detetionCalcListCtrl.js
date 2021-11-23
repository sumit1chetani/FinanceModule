/*'use strict';*/
app.controller(
				'detetionCalcCtrl',
				function($scope, $timeout, $stateParams, $filter, $rootScope,
						$http, $location, logger, utilsService, $state,
						sharedProperties, $window, ngDialog, $interval,
						validationService, toaster, $controller, $injector,$stateParams) {
					$scope.dataLoopCount = 0;
				    $scope.offsetCount = 0;
				    $scope.limitCount = 1000;
				    $scope.updatedData = [];
				    $scope.itemsByPage = 10;
				    
				    
				    $scope.vesselList = [];
					$scope.voyageList = [];
					$scope.terminalList = [];
					$scope.generateList = [];
					$scope.view=true;
					
					$scope.detentionCalc = {
							customer : '',
							port : '',
							blNo:'',
							detentionType:'',
							fromDate:'',
							toDate:'',
							type:'',
							tariff:''
							
					};
					
					
					$scope.detailList={
							containerNumber:'',
							containerType:'',
							dischargeDate:'',
							onboardDate:'',
							gateinDate:'',
							returnDate:'',
							blNo:'',
							pol:'',
							pod:'',
							totalDays:'',
							detetnionDays:'',
							freedays:'',
							amount:'',
							 select:false
					}

					$scope.typeList = [{
				    	id : 'Export',
				    	text : 'Export'
				    },
				    {
				    	id : 'Import',
				    	text : 'Import'
				    }]

					$http.post($stateParams.tenantid+'/app/commonUtility/getPortByEmpAgn').success(function(data) {
				      	
				  		$scope.port=data; 
				  		        		
				     });
					
					$http.post($stateParams.tenantid+'/app/detection/getCustomerList').success(function(data) {
				      	
				  		$scope.customerList=data; 
				  		        		
				     });
					
					$http.post($stateParams.tenantid+'/app/detection/getTariffList').success(function(data) {
				      	
				  		$scope.tariffList=data; 
				  		        		
				     });
					
				     $http.get($stateParams.tenantid+'/app/bltracking/bllist').success(function(datas) {
				        	$scope.blNoList = datas;
				        }).error(function(datas) {
				        });
					$scope.selectall= function(selection){
					 	angular.forEach($scope.detailList,function(value,key) {
					 		debugger;
					 		if( selection)
					 		value.select=true;
					 		else{
					 			value.select=false;
					 		}
					});
					}
					// import
					/* $scope.viewDetailOnScreen = function(){
					        debugger;
					         $http.post($stateParams.tenantid+'/app/detetntionCalculator/searchDetail',$scope.detentionCalc).success(function(data) {
						         if( data.detailAmount!=null){
							           	 $scope.rowCollection = data.detailAmount;
								         $scope.detailList = data.detailAmount;
								  }else{
									  logger.logError("Details Not Available");
					                	 $scope.rowCollection= [];
								  }
						     }).error(function(data) {
						                logger.logError("Error Please Try Again");
						            });
					 }
					$scope.viewDetailOnScreen();*/
					 
					//view Detail for import
					 $scope.show =false;
					 $scope.show1 =false;

					  $scope.viewDetail = function(){
					        debugger;
					        if($scope.detentionCalc.blNo == null || $scope.detentionCalc.blNo == ""){
						    	   logger.logError("Please Select BL No..!");
						       }
					       else{
					       if($scope.detentionCalc.type == null || $scope.detentionCalc.type == ""){
					    	   logger.logError("Please Select Type..!");
					       }else{
					    	  if($scope.detentionCalc.tariff == null || $scope.detentionCalc.tariff == ""){
					    	   logger.logError("Please Select Tariff..!");
					       }
					       else{
					    	   
					       
					        		$http.post($stateParams.tenantid+'/app/detetntionCalculator/searchDetail',$scope.detentionCalc).success(function(data) {
						                if(data){
						                    debugger;
						                   
						                    if( data.detailAmount.length>0){
							                	 $scope.rowCollection = data.detailAmount;
								                 $scope.detailList = data.detailAmount;
								                 if($scope.detentionCalc.type == 'Import'){
								                	 $scope.show = true;
								                	 $scope.show1= false;

								                 }else if ($scope.detentionCalc.type == 'Export'){
								                	 $scope.show1= true;
								                	 $scope.show= false;

								                 }


							                }else{
							                	 logger.logError("No data found!");
							                	 $scope.rowCollection= [];
							                	 
							                }
						                }
						                
						            }).error(function(data) {
						                logger.logError("Error Please Try Again");
						            });
					        		/*}else{
					        			logger.logError("select Invoice Date");
					        		}*/
					  }
						       }
						       }
					        };

					  
					        $scope.reset = function(containerReport) {
					        	$scope.detentionCalc = {
										customer : '',
										port : '',
										blNo:'',
										detentionType:'',
										fromDate:'',
										toDate:''
										
								};
				        	    	
					        	$scope.viewDetailOnScreen();

				        	    }
					   	 $('#returnDate').datetimepicker({
							 format : 'DD-MM-YYYY'
							 })
					    
					        $scope.chngDate = function (items){
					    		var slno=items.slno;
					    		 $scope.returnDetails =items;
					    		 $scope.detentionCalc;
					    		 var obj={
											bean:$scope.returnDetails,
											header:$scope.detentionCalc
									};
					    		 $http.post($stateParams.tenantid+ '/app/detetntionCalculator/generate',obj).success(function(datas) {
					   
					    			 if(datas.suceess){
					    				 items.days = datas.detailAmount[0].days.toString();
						    			 items.freeDays = datas.detailAmount[0].freeDays;
						    			 items.detentionDays = datas.detailAmount[0].detentionDays	;
						    			 items.totalAmount = datas.detailAmount[0].totalAmount;
					    			 }else{
					    				 logger.logError(datas.message);
					    			 }
					    			

					    			})
					    	.error(
					    			function(data) {
					    				logger.logError("Unable to fetch");
					    			});
					    		//alert('tt');
					    	}
					        
					
	
					//cancel
					
					$scope.cancel = function() {
						$state.go('app.finance.invoice.detectioninvoice.list', {
							tenantid : $stateParams.tenantid
						});
					}

					
					
					
					
					 
					
				});


app.controller('returnDateCtrl', function($scope, $timeout, $stateParams, $filter, $rootScope,
		$http, $location, logger, utilsService, $state,
		sharedProperties, $window, ngDialog, $interval,
		validationService, toaster, $controller, $injector,$stateParams) {
	



		 
	
	
	
});
