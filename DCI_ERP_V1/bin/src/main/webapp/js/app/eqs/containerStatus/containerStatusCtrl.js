'use strict';

app.controller('containerStatusListCtrl', function($scope, $stateParams, $state, $http,
		$location, ngDialog, logger, utilsService) {

	$scope.offsetCount = 0;
	$scope.limitCount = 1000;
	$scope.rowCollection = [];
	$scope.displayedCollection = [];
	$scope.itemsByPage = 10;

	$scope.isDelete = true;
	
	$scope.numPages = 0
	$scope.isEdit=false;
	$scope.getContainerStatusList = function() {
		$http.get($stateParams.tenantid + '/api/containerStatus/list').success(
				function(response) {
					console.log(response);
					$scope.rowCollection = response;
				});
	};
	$scope.getContainerStatusList();

	$scope.editRow = function(containerStatusId) {
		$location.url($stateParams.tenantid + '/containerStatus/containerStatusedit?containerStatusId='
				+ containerStatusId);
	}

	$scope.deleteRow = function(containerStatusId) {
		ngDialog.openConfirm().then(function() {
			var url = $stateParams.tenantid+'/api/containerStatus/delete?containerStatusCode='+containerStatusId;
				$http.get(url).success(function(result){
	                if (result.isSuccess ==  true) {
	                    logger.logSuccess("Deleted successfully");
	                    $state.reload();
	               } else {
	                    logger.logError("Error in Delete ");
	                }
	            }).error(function(result) {
	                logger.logError("Error Please Try Again");
	            });
	        }, function(reason) {
	            console.log('Modal promise rejected. Reason: ', reason);
	        });
	    };

	$scope.add = function() {
		$state.go("app.eqs.containerStatus.containerStatusadd", {
			tenantid : $stateParams.tenantid
		});
	};
	
	 $scope.view = function(containerStatusId) {	    	
	    	
	    	$location.url($stateParams.tenantid + '/containerStatus/containerStatusView?containerStatusId='+ containerStatusId);
	     }
});

app.controller('containerStatusAddCtrl',
				function($scope, $state, $stateParams, $http, $location,
						ngDialog, logger, utilsService, sharedProperties,
						toaster, $rootScope, validationService) {
	
	
    $scope.containerStatusBank=[];
		$scope.containerStatusMaster = {
			containerStatusId : '',
			containerStatusCode : '',
			containerStatusName : '',
			company :'',
			state : '',
			address : '',
			containerStatusShortName : '',			
			country : '',			
			eMail : '',	
			faxNo : '',
			companyId:'',
			countryId:'',
			personIncharge : '',
				containerStatusDescription: '',
					containerStatusCode :'',	
					depot:'',
					shipper:'',
					customer:'',
					consignee:'',
					vessel:'',
					voyage:'',
					pol:'',
					pod:'',
			
		}
		
		
		
		
		$scope.countryList = [];
		$scope.stateList = [];
		$scope.companylist= [];
			
		


		//Reset on add mode
			    $scope.reset = function() {
			        $scope.containerStatusMaster=[];   
			        $scope.getDropdownvalue();
			     };		
			
			
				
				
		
						
	  $http.post($stateParams.tenantid+'/api/containerStatus/countrylist').success(function(data) {
          		      	      	
      		$scope.countryList=data;
      		        		
      });
	  
	  $http.post($stateParams.tenantid+'/api/containerStatus/statelist').success(function(data) {
  	      	
    		$scope.statelist=data;
    		        		
    });
	  
	  $http.post($stateParams.tenantid+'/api/containerStatus/companylist').success(function(data) {
  	      	
    		$scope.companylist=data;
    		        		
    });
	  					  
						  
	

					
					
					
					//save
					$scope.save = function(containerStatusMasterForm, containerStatusMaster) {
						sharedProperties.clearObject();
						if (new validationService()
								.checkFormValidity(containerStatusMasterForm)) {							
							
							
												 $http.post($stateParams.tenantid+'/api/containerStatus/save', $scope.containerStatusMaster).success(function(data) {
												if (data.isSuccess == true) {
													logger.logSuccess("Saved Succesfully!");
													$state.go("app.eqs.containerStatus.containerStatuslist",{tenantid : $stateParams.tenantid});

												} else {
													logger.logError(data.message);
												}
											});
						} else {
							toaster
									.pop('error',"Please fill the required fields",logger.getErrorHtmlNew(containerStatusMasterForm.$validationSummary),5000, 'trustedHtml');
						}
					};
					
					
					
					//update
					$scope.update = function(containerStatusMasterForm, containerStatusMaster) {
						debugger;
						$scope.containerStatusMaster.containerStatusId = $location.search().containerStatusId;
						sharedProperties.clearObject();
						if (new validationService()
								.checkFormValidity(containerStatusMasterForm)) {
							
							
								
								 $http.post($stateParams.tenantid+'/api/containerStatus/update', $scope.containerStatusMaster).success(function(response) {
												if (response.isSuccess == true ) {
													logger.logSuccess("Updated Succesfully!");
													$state.go("app.eqs.containerStatus.containerStatuslist",{tenantid : $stateParams.tenantid});
												} else {
													logger.logError("Error in Update");
												}
											});
						} else {
							toaster.pop('error',"Please fill the required fields",logger.getErrorHtmlNew(containerStatusMasterForm.$validationSummary),5000, 'trustedHtml');
						}
					};

					
					
					$scope.cancel = function() {
						$state.go("app.eqs.containerStatus.containerStatuslist", {
							tenantid : $stateParams.tenantid
						});
					}
					
					
					// Edit functionality
				    
				    $scope.isEdit=false;
				    
				    
				  var containerStatusId = $location.search().containerStatusId;
				  if(containerStatusId != null){
					  $scope.isEdit=true;
				      
					  $http.post($stateParams.tenantid+'/api/containerStatus/edit?containerStatusCode=' +containerStatusId).success(function(result) {
				          
				          if (result.isEdit == false) {
				              logger.logError("Please Try Again");
				          } else {
				              console.log("result***************for viewwwwwwwwwwwwwwwwww*******");
				              console.log(result);
				              $scope.containerStatusMaster = result;
				                
				             
				          }
				            
				         }).error(function(data) {

				         });
				  }
				});


app.controller('containerStatusViewCtrl',
		function($scope, $state, $stateParams, $http, $location,
				ngDialog, logger, utilsService, sharedProperties,
				toaster, $rootScope, validationService) {


$scope.containerStatusBank=[];
$scope.containerStatusMaster = {
	containerStatusId : '',
	containerStatusCode : '',
	containerStatusName : '',
	address : '',
	address1 : '',
	address2 : '',
	pinCode : '',
	phoneNumber : '',
	shortName : '',
	state : '',
	country : '',
	city : '',
	email : '',
	tenantId : '',
	templateId : '',
	isActive : true,
	isHead : false,		
	isEdit :true,
	faxNo : '',
	serviceTaxNo : '',
	licenceNo : '',
	gstnNo:'',
	logoPath:'',
	uom:'',
	panNo:'',
	currencyId:'',
	companyId:'',
	gstnCode:'',
	countryId:'',
	cityId:''
}
$scope.tempContainerStatusBank={
         containerStatusId:'',
		 bankName:'',
		 bankAddress:'',
		 accountNo:'',
		 ifscCode:'',
		 ibanNo:'',
		 shiftCard:'',
		 bankActive:false,
		 select:false
}

$scope.countryList = [];
$scope.stateList = [];
$scope.cityList= [];
	  $scope.addCredRow = function() {
		   
		  var tmp=angular.copy($scope.tempContainerStatusBank);
			$scope.containerStatusBank.push(tmp);

	  }
	  $scope.addCredRow();

		$scope.removeCredRow =function(){
			ngDialog.openConfirm().then(function() {
			if($scope.isEdit==false){
				var tmpDelList = [];
				for(var i=$scope.containerStatusBank.length-1;i>=0;i--){
					if($scope.containerStatusBank[i].select==true){
						tmpDelList.push($scope.containerStatusBank[i]);
						$scope.containerStatusBank.splice(i, 1);
					}
				}
				logger.logSuccess('Deleted Successfully');
			}else if($scope.isEdit==true){
				var tmpDelList = [];
				for(var i=$scope.containerStatusBank.length-1;i>=0;i--){
					if($scope.containerStatusBank[i].select==true){
						tmpDelList.push($scope.containerStatusBank[i]);
					}
				}
				$http.post($stateParams.tenantid+'/app/master/consigneepartner/deleteKeyDetail',$scope.servicePartnerTable).success(function(data) {
		        	if(data.success){
		        		for(var i=$scope.containerStatusBank.length-1;i>=0;i--){
		    				if($scope.containerStatusBank[i].select==true){
		    					$scope.containerStatusBank.splice(i, 1);
		    				}
		    			}
		        		logger.logSuccess('Deleted Successfully');
		        	}else{
		        		logger.logError('Unable to Delete');
		        	}
				})
			}
			})
		}
	
		$scope.$watch('containerStatusMaster.cityId', function(newValue,oldValue) {
			if (newValue != '' && newValue != undefined) {
				$http.post($stateParams.tenantid + '/app/master/containerStatus/dropDownList',newValue).success(function(datas) {
					console.log(datas);
					$scope.countryList = datas.countryList;
				});
			}
		});
		
		
$http.post($stateParams.tenantid+'/app/master/servicepartner/dropDownList').success(function(data) {
  	if(data.success){
  		$scope.gstnStateList=data.gstnStateList;
  		//$scope.countryList=data.countryList;
  		$scope.cityList=data.cityList;
  	}
  });
				
$http.post($stateParams.tenantid+'/app/master/hbl/dropDownList').success(function(data) {
  		      	      	
		$scope.currencyList=data.currency;
		$scope.companyList=data.company;
		$scope.uomList=data.uom;
		$scope.logoPathList=data.logoPath;           		
});
					  
				  
$scope.$watch('containerStatusMaster.tenantId', function(newValue,
	oldValue) {
if (newValue != '' && newValue != undefined) {
	$http.post(
			$stateParams.tenantid
					+ '/app/master/containerStatus/tenantList',
			newValue).success(function(datas) {
		console.log(datas);
		$scope.templateList = datas.templateList;
	});
}
});

			if ($location.search().containerStatusId != 0
					&& $location.search().containerStatusId != undefined) {
				$scope.containerStatusMaster.isEdit = true;
				$scope.isEdit=true;
				$scope.containerStatusMaster.containerStatusId = $location.search().containerStatusId;
				$scope.isEdit = true;
				$http.post(
						$stateParams.tenantid
								+ "/app/master/containerStatus/view",
						$scope.containerStatusMaster.containerStatusId).success(
						function(response) {
							console.log(response);
							if (response.success == true) {
								$scope.containerStatusMaster = response.containerStatus;
								$scope.containerStatusBank = response.containerStatusBank;
								$scope.containerStatusMaster.currencyName=response.containerStatus.currencyName.toString();
								$scope.containerStatusMaster.companyId=response.containerStatus.companyId.toString();
								$scope.containerStatusMaster.logoPath=response.containerStatus.logoPath.toString();
								$scope.containerStatusMaster.uom=response.containerStatus.uom.toString();
								$scope.containerStatusMaster.cityId=response.containerStatus.cityId.toString();
								if(response.containerStatus.countryId!=null){
									$scope.containerStatusMaster.countryId=response.containerStatus.countryId.toString();
								}
								if(response.containerStatus.gstnCode!=null){
								$scope.containerStatusMaster.gstnCode=response.containerStatus.gstnCode.toString();
								}
								


							}
						});
			}

			$scope.reset = function(containerStatusMasterForm) {
				debugger
				alert(reset);

				if ($scope.containerStatusMaster.isEdit == false) {
					
					
					$http.post($stateParams.tenantid+ "/app/master/containerStatus/view",$location.search().containerStatusId).success(
							function(response) {
								console.log(response);
								if (response.success == true) {
//									$scope.containerStatusMaster = response.containerStatus;
//									$scope.containerStatusMaster =record.containerNo;
//										$scope.containerStatusMaster =record.containerType;
//											$scope.containerStatusMaster =record.entryDate;
//												$scope.containerStatusMaster =record.containerSize;
//													$scope.containerStatusMaster =record.location;
//														$scope.containerStatusMaster =row.damageCode;
//															$scope.containerStatusMaster =row.damageStatus;
//																$scope.containerStatusMaster =row.repairProcess;
//																$scope.containerStatusMaster =row.remarks;
									$scope.containerStatusMaster =containerStatusMaster.containerStatusCode;
									$scope.containerStatusMaster =containerStatusMaster.containerStatusDescription;
																	
									$scope.containerStatusBank = response.containerStatusBank;
									$scope.containerStatusMaster.currencyId=response.containerStatus.currencyId.toString();
									$scope.containerStatusMaster.logoPath=response.containerStatus.logoPath.toString();
									$scope.containerStatusMaster.uom=response.containerStatus.uom.toString();
									$scope.containerStatusMaster.gstnCode=response.containerStatus.gstnCode.toString();
								}
								
							});
					
					
				} else {
					$scope.containerStatusBank = [];
					$scope.tempContainerStatusBank={
					         containerStatusId:'',
							 bankName:'',
							 bankAddress:'',
							 accountNo:'',
							 ifscCode:'',
							 ibanNo:'',
							 shiftCard:'',
							 bankActive:false,
							 select:false
					}
					
					$scope.addCredRow = function() {
						   
						  var tmp=angular.copy($scope.tempContainerStatusBank);
							$scope.containerStatusBank.push(tmp);

					  }
					
					$scope.addCredRow();
					$scope.containerStatusMaster = {									
						containerStatusId : '',
						containerStatusCode : '',
						containerStatusName : '',
						companyId : '',
						currencyId : '',
						gstnCode: '',
						uom:'',
						logoPath:'',
						address : '',
						pinCode : '',
						phoneNumber : '',
						shortName : '',
						state : '0',
						country : '0',
						city : '',
						email : '',
						tenantId : '',
						templateId : '',
						isActive : false,
						isHead : false,
						isEdit : ''
					}
					
				}
			}


			$scope.cancel = function() {
				$state.go("app.eqs.containerStatus.containerStatuslist", {
					tenantid : $stateParams.tenantid
				});
			}
		});