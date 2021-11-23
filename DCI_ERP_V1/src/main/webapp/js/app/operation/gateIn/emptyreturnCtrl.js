'use strict';

app.controller('emptyreturnListCtrl', function($scope, $rootScope, $http, $location, logger, utilsService, ngDialog, $state,sharedProperties,$window,$stateParams) {
	
    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    
    $scope.gateIn = {
			gateInNo : '',
			gateOutNo : '',
			depot : '',
			bookingNo : '',
			customer : '',
			returnDate : '',
			type: 'Empty Return',
			service : 'COC',
			doNo :'',
	
			containerDtl : [],
		   containerDtlsoc: []

		}
    
    $scope.gateOut = {
    		doType : 'Empty Return'
		}
    $rootScope.doType='';
	$scope.type = function (value){
		$rootScope.doType = value;
	}
    
    $scope.getList=function(){
        $http.get($stateParams.tenantid+'/api/gateIn/list').success(function(datas) {
            console.log(datas);
            $scope.rowCollection = datas.emptyReturnList;
           
        	
            }).error(function(datas) {
        });
        };
        $scope.getList();
        
 
    
  
 // Redirecting Page For Edit Functionality
    
    $scope.Approval = function(details,gateInNo,shipmentStatus) {
    	debugger
    	//if(!shipmentStatus){
        $location.url($stateParams.tenantid+'/operation/emptyreturn/edit?gateInNo='+gateInNo);
    	/*}else{
    		logger.logError("You can't edit the Record in Shipping Instruction");	
    	}*/
    };
    
    /*
    $scope.viewRow = function(gateInNo) {
    	debugger
    
        $location.url($stateParams.tenantid+'/operation/gateIn/view?gateInNo='+gateInNo);
    	
    };*/
    
   

	//Delete functionality
    $scope.deleteRow = function(gateInNo,shipmentStatus) {
       	if(!shipmentStatus){
        ngDialog.openConfirm().then(function() {
        
            var url = $stateParams.tenantid+'/api/gateIn/delete?gateInNo=' + gateInNo;
            $http.get(url).success(function(result){
            	
                if (result) {
                	
                    logger.logSuccess("Deleted Successfully");
                    $state.reload();
              
                } else {
                	
                    logger.logError("You can't Delete this Record, Related Data Exist! ");
                }
            }).error(function(result) {
            	
                logger.logError("Error Please Try Again");
          
            });
        }, function(reason) {
        	
            console.log('Modal promise rejected. Reason: ', reason);
        });
       	}
       	else{
    		logger.logError("You can't delete the Record in Shipping Instruction");	
    	}
    };

  
    
});




'use strict';
app
		.controller(
				'emptyreturnEditCtrl',
				function($scope, $timeout, $stateParams, sharedProperties,
						toaster, $filter, $rootScope, $http, $location, logger,
						$state, ngDialog, $controller, $injector) {
	
					$scope.containerDtl = [];
					$scope.containerDtlsoc = [];
					$scope.isEdit = false;

					$scope.gateIn = {
						gateInNo : '',
						gateOutNo : '',
						depot : '',
						bookingNo : '',
						customer : '',
						returnDate : '',
						createdBy: '',
						createdOn : '',
						modifiedBy: '',
			          modifiedOn: '',
						returnDate:'',

						type: 'Export',
						service : 'COC',
						doNo :'',
				
						containerDtl : [],
					   containerDtlsoc: []

					}
					
					
					
					$scope.saveButtonDisble = false;
					var today = new Date();
					var dd = today.getDate();
					var mm = today.getMonth() + 1; // January is 0!
					var yyyy = today.getFullYear();
					var HH = today.getHours();
					var MM = today.getMinutes();
					if (dd < 10) {
						dd = '0' + dd
					}
					if (mm < 10) {
						mm = '0' + mm
					}
					if (HH < 10) {
						HH = '0' + HH
					}
					if (MM < 10) {
						MM = '0' + MM
					}

					$scope.gateIn.returnDate = dd + '/' + mm + '/'+ yyyy+ ' ' + HH+':'+ MM;

					 $('#returnDate').datetimepicker({
						 format : 'DD/MM/YYYY HH:mm'
						 })
					
					$scope.ContainerDtl = {
						containerType : "",
						containerNo : "",
						sealNo : "",
						returnDate:'',
						emptyOrLoad : true,
						line: "",
						select : false
					}
					
					$scope.containerDtlsoc = {
							containerType : "",
							containerNo : "",
							sealNo : "",
							returnDate:'',
							emptyOrLoad : "",
							line: "",
							select : false
						}
					
					$scope.typeList=[

						{ id: 'Export', text: 'Export' },
						{ id: 'Import', text: 'Import' },
						{ id: 'Empty Return', text: 'Empty Return' }

						]
					 

					
					
					$scope.getdropdown = function() {
					$http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(datas) {
					
						 // $scope.customerList=datas.getcustomerlist;
						 $scope.depotList=datas.polList;
						  $scope.gateOutList=datas.gateOutList;
						  $scope.containerTypeList=datas.getcontypelist;
						  $scope.containerNoList=datas.getcontainer;
						  $scope.gateIn.gateInNoMaxCnt=datas.maxGateInNo;
						
					}).error(function(datas) {

					});
				  }
					
					
					

					$http.get($stateParams.tenantid+ '/app/commonUtility/getshipConsigneeList').success(function(data1) {
						$scope.customerList = data1;
					});
				   
				  $scope.getdropdown();
			 
		
				  
					
					$scope.save = function(gateInForm,gateIn) {
						if (new validationService().checkFormValidity($scope.gateInForm)) {
							
						var selectCheck=false;	
						$scope.saveButtonDisble = true;
						var tmpDelList = [];
					   angular.forEach($scope.gateIn.containerDtl, function(chargesDetail, index) {  
						   if(chargesDetail.select){
							   selectCheck=true;	
							   
						   }
					        
					    });
						if(selectCheck){
							for(var i=$scope.gateIn.containerDtl.length-1;i>=0;i--){
								if($scope.gateIn.containerDtl[i].select==true){
									tmpDelList.push($scope.gateIn.containerDtl[i]);
								}
							}
							
							$scope.gateIn.containerDtl = tmpDelList;
 								          var chk=true;
 								          var checkNull = true;
								          if($scope.gateIn.containerDtl.length>0){
								     	 for(var i=0;i< $scope.gateIn.containerDtl.length;i++){
								     		 
								     		if($scope.gateIn.containerDtl[i].returnDate == null || $scope.gateIn.containerDtl[i].returnDate == '' ){
								     			 logger.logError("Row ("+(i+1)+") Gate In Date Should be Empty");
								     			 $scope.saveButtonDisble = false;
								     			 var checkNull = false;
								     		}else{
								     			 var checkNull = true;
								     		}
								     		 
								     		if(checkNull){
								         	 var t = moment($scope.gateIn.containerDtl[i].previousStatusDate,"DD/MM/YYYY HH:mm").isSameOrBefore(moment($scope.gateIn.containerDtl[i].returnDate, 'DD/MM/YYYY HH:mm'));
								             if(t == false){
								             logger.logError("Row ("+(i+1)+") Gate In Date Should be Greater than Previous Status Date !!!  The Previous Status Date is: "+$scope.gateIn.containerDtl[i].previousStatusDate+"");
								             $scope.saveButtonDisble = false;
								             chk=false;
								             }
								     	 }
								     	 }
								          }
								          
										
								             if(chk){
								            	 $scope.saveButtonDisble = true;
								            	 debugger;
						$http.post($stateParams.tenantid+'/api/gateIn/save',gateIn).success(function(data) {
						console.log("data" + data);
						if (data.isSuccess) {
						logger.logSuccess("Saved Successfully!");
						$scope.saveButtonDisble = true;
						$state.go('app.operation.gateIn.list');
						} else {
						logger.logError(data.message);
						$scope.saveButtonDisble = false;
						}
						}).error(function(result) {
							 $scope.saveButtonDisble = false;
						//console.log("data" + data);
						});
								             }
										     	
					          
						}else{
							logger.logError("Please select Container to proceed Gate IN");
							$scope.saveButtonDisble = false;
						}
						} else {
						toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.gateInForm.$validationSummary), 555000, 'trustedHtml');
						$scope.saveButtonDisble = false;
						}};
					
					
						var gNo = $location.search().gNo;
						if (gNo == undefined) {

						} else {
							$scope.gateIn.gateOutNo=gNo;
						}
						// Fetch Values
						$scope.isEdit = false;
						var gateInNo = $location.search().gateInNo;
						if (gateInNo == undefined) {

						} else {
							  $http.get($stateParams.tenantid+ '/api/gateIn/getCustomereditDropdown?gateInNo=' +gateInNo).success(function(data1) {
									console.log(data1);
									$scope.customerList1 = data1;
							  
								});
							$http.get($stateParams.tenantid+ '/api/gateIn/edit?gateInNo='+ gateInNo).success(function(result) {

												$scope.isEdit = true;
												$scope.gateIn = result;
												// $scope.gateIn = result.customer;
												if($scope.gateIn){
													 
												}
												if (result.isEdit == false) {
													logger
															.logError("Please Try Again");
												} else {

												}
											}).error(function(data) {
										console.log("data" + data);
									});
						}
						if (gNo == undefined) {

						} else {
							 $scope.selectall(true);
						}
						
						
						$scope.$watch('gateIn.doNo', function(newValue, oldValue) {
							if($scope.isEdit==false){
					        if (newValue != '' && newValue != undefined) {
					        	$scope.gateInNo=newValue;
					        	$http.post($stateParams.tenantid+'/api/gateIn/getDoNo?gateInNo='+$scope.gateInNo).success(function(datas) {
					        		
					        		if(datas.isSuccess){
					        		
					        			/*  $scope.gateIn.doNoList=datas.doNoList;*/
					        		      $scope.gateIn.customer=datas.customer.toString();
					        		      $scope.gateIn.depot=datas.depot;
					        		      $scope.gateIn.containerDtl=datas.containerDtl;
					        		
					        	}
					        	else{
				            			logger.logError(newValue+" "+datas.message);	
				        			
				        		}
					    		}).error(function(datas) {

					    		});
					        } 
							}
					    });
						
					
					// cancel
					
					$scope.cancel = function() {
						$state.go('app.operation.emptyreturn.list', {
							tenantid : $stateParams.tenantid
						});
					};
					
				

					// reset
					$scope.reset = function(gateIn) {
						if (gateInNo == undefined) {
							
							$scope.gateIn = {
									gateInNo : '',
									gateOutNo : '',
									depot : '',
									bookingNo : '',
									customer : '',
									returnDate : '',
							
									containerDtl : [],
								   containerDtlsoc: []

								}
							
						} else {
							$http.get($stateParams.tenantid+  '/api/gateIn/edit?gateInNo='+ gateInNo).success(function(result) {

												if (result.isEdit == false) {
													logger.logError("Please Try Again");
												} else {
													$scope.isEdit = true;
													$scope.gateIn = result;
													
											
												}
											}).error(function(data) {
										console.log("data" + data);
									});
						}
					}
					
					
			
				}); 
	
 

