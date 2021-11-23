'use strict';

app.controller('repairListCtrl', function($scope, $stateParams, $state, $http,
		$location, ngDialog, logger, utilsService) {

	$scope.offsetCount = 0;
	$scope.limitCount = 1000;
	$scope.rowCollection = [];
	$scope.displayedCollection = [];
	$scope.itemsByPage = 10;

	$scope.isDelete = true;
	
	$scope.numPages = 0
	$scope.isEdit=false;
	$scope.getRepairList = function() {
		$http.get($stateParams.tenantid + '/api/repair/list').success(
				function(response) {
					console.log(response);
					$scope.rowCollection = response;
				});
	};
	$scope.getRepairList();

	$scope.editRow = function(repairId) {
		$location.url($stateParams.tenantid + '/repair/repairedit?repairId='
				+ repairId);
	}
	
	$scope.deleteRow = function(repairId) {
		ngDialog.openConfirm().then(function() {
			var url = $stateParams.tenantid+'/api/repair/delete?repairCode='+repairId;
			 $http.get(url).success(function(result){
	                if (result.isSuccess ==  true) {
	                    logger.logSuccess("Deleted Successfully");
	                    $state.reload();
	               } else {
	                    logger.logError("Error in Delete");
	                }
	            }).error(function(result) {
	                logger.logError("Error Please Try Again");
	            });
	        }, function(reason) {
	            console.log('Modal promise rejected. Reason: ', reason);
	        });
	    };

	$scope.add = function() {
		$state.go("app.eqs.repair.repairadd", {
			tenantid : $stateParams.tenantid
		});
	};
	
	 /*$scope.view = function(repairId) {	    	
	    	
	    	$location.url($stateParams.tenantid + '/repair/repairView?repairId='+ repairId);
	     }*/
});

app.controller('repairAddCtrl',
				function($scope, $state, $stateParams, $http, $location,
						ngDialog, logger, utilsService, sharedProperties,
						toaster, $rootScope, validationService) {
	
	
    $scope.repairBank=[];
		$scope.repairMaster = {
			repairId : '',
			repairCode : '',
			repairName : '',
			company :'',
			state : '',
			address : '',
			repairShortName : '',			
			country : '',			
			eMail : '',	
			faxNo : '',
			companyId:'',
			countryId:'',
			personIncharge : ''
			
		}
		
		
		
		
		$scope.countryList = [];
		$scope.stateList = [];
		$scope.companylist= [];
			
		

		//Reset on add mode
	    $scope.reset = function() {
	        $scope.repairMaster=[];   
	        $scope.getDropdownvalue();

	    };		
			
			
				
				
		
						
	  $http.post($stateParams.tenantid+'/api/repair/countrylist').success(function(data) {
          		      	      	
      		$scope.countryList=data;
      		        		
      });
	  
	  $http.post($stateParams.tenantid+'/api/repair/statelist').success(function(data) {
  	      	
    		$scope.statelist=data;
    		        		
    });
	  
	  $http.post($stateParams.tenantid+'/api/repair/companylist').success(function(data) {
  	      	
    		$scope.companylist=data;
    		        		
    });
	  					  
						  
	

					
					
					
					//save
					$scope.save = function(repairMasterForm, repairMaster) {
						sharedProperties.clearObject();
						if (new validationService()
								.checkFormValidity(repairMasterForm)) {							
							
							
												 $http.post($stateParams.tenantid+'/api/repair/save', $scope.repairMaster).success(function(data) {
												if (data.isSuccess == true) {
													logger.logSuccess("Saved Succesfully!");
													$state.go("app.eqs.repair.repairlist",{tenantid : $stateParams.tenantid});

												} else {
													logger.logError(data.message);
												}
											});
						} else {
							toaster
									.pop('error',"Please fill the required fields",logger.getErrorHtmlNew(repairMasterForm.$validationSummary),5000, 'trustedHtml');
						}
					};
					
					
					
					//update
					$scope.update = function(repairMasterForm, repairMaster) {
						debugger;
						$scope.repairMaster.repairId = $location.search().repairId;
						sharedProperties.clearObject();
						if (new validationService()
								.checkFormValidity(repairMasterForm)) {
							
							
								
								 $http.post($stateParams.tenantid+'/api/repair/update', $scope.repairMaster).success(function(response) {
												if (response.isSuccess == true ) {
													logger.logSuccess("Updated Succesfully!");
													$state.go("app.eqs.repair.repairlist",{tenantid : $stateParams.tenantid});
												} else {
													logger.logError("Error in Update");
												}
											});
						} else {
							toaster.pop('error',"Please fill the required fields",logger.getErrorHtmlNew(repairMasterForm.$validationSummary),5000, 'trustedHtml');
						}
					};

					
					
					$scope.cancel = function() {
						$state.go("app.eqs.repair.repairlist", {
							tenantid : $stateParams.tenantid
						});
					}
					
					
					// Edit functionality
				    
				    $scope.isEdit=false;
				    
				    
				  var repairId = $location.search().repairId;
				  if(repairId != null){
					  $scope.isEdit=true;
				      
					  $http.post($stateParams.tenantid+'/api/repair/edit?repairCode=' +repairId).success(function(result) {
				          
				          if (result.isEdit == false) {
				              logger.logError("Please Try Again");
				          } else {
				              console.log("result***************for viewwwwwwwwwwwwwwwwww*******");
				              console.log(result);
				              $scope.repairMaster = result;
				                
				             
				          }
				            
				         }).error(function(data) {

				         });
				  }
				});


app.controller('repairViewCtrl',
		function($scope, $state, $stateParams, $http, $location,
				ngDialog, logger, utilsService, sharedProperties,
				toaster, $rootScope, validationService) {


$scope.repairBank=[];
$scope.repairMaster = {
	repairId : '',
	repairCode : '',
	repairName : '',
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
$scope.tempRepairBank={
         repairId:'',
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
		   
		  var tmp=angular.copy($scope.tempRepairBank);
			$scope.repairBank.push(tmp);

	  }
	  $scope.addCredRow();

		$scope.removeCredRow =function(){
			ngDialog.openConfirm().then(function() {
			if($scope.isEdit==false){
				var tmpDelList = [];
				for(var i=$scope.repairBank.length-1;i>=0;i--){
					if($scope.repairBank[i].select==true){
						tmpDelList.push($scope.repairBank[i]);
						$scope.repairBank.splice(i, 1);
					}
				}
				logger.logSuccess('Deleted Successfully');
			}else if($scope.isEdit==true){
				var tmpDelList = [];
				for(var i=$scope.repairBank.length-1;i>=0;i--){
					if($scope.repairBank[i].select==true){
						tmpDelList.push($scope.repairBank[i]);
					}
				}
				$http.post($stateParams.tenantid+'/app/master/consigneepartner/deleteKeyDetail',$scope.servicePartnerTable).success(function(data) {
		        	if(data.success){
		        		for(var i=$scope.repairBank.length-1;i>=0;i--){
		    				if($scope.repairBank[i].select==true){
		    					$scope.repairBank.splice(i, 1);
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
	
		$scope.$watch('repairMaster.cityId', function(newValue,oldValue) {
			if (newValue != '' && newValue != undefined) {
				$http.post($stateParams.tenantid + '/app/master/repair/dropDownList',newValue).success(function(datas) {
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
					  
				  
$scope.$watch('repairMaster.tenantId', function(newValue,
	oldValue) {
if (newValue != '' && newValue != undefined) {
	$http.post(
			$stateParams.tenantid
					+ '/app/master/repair/tenantList',
			newValue).success(function(datas) {
		console.log(datas);
		$scope.templateList = datas.templateList;
	});
}
});

			if ($location.search().repairId != 0
					&& $location.search().repairId != undefined) {
				$scope.repairMaster.isEdit = true;
				$scope.isEdit=true;
				$scope.repairMaster.repairId = $location.search().repairId;
				$scope.isEdit = true;
				$http.post(
						$stateParams.tenantid
								+ "/app/master/repair/view",
						$scope.repairMaster.repairId).success(
						function(response) {
							console.log(response);
							if (response.success == true) {
								$scope.repairMaster = response.repair;
								$scope.repairBank = response.repairBank;
								$scope.repairMaster.currencyName=response.repair.currencyName.toString();
								$scope.repairMaster.companyId=response.repair.companyId.toString();
								$scope.repairMaster.logoPath=response.repair.logoPath.toString();
								$scope.repairMaster.uom=response.repair.uom.toString();
								$scope.repairMaster.cityId=response.repair.cityId.toString();
								if(response.repair.countryId!=null){
									$scope.repairMaster.countryId=response.repair.countryId.toString();
								}
								if(response.repair.gstnCode!=null){
								$scope.repairMaster.gstnCode=response.repair.gstnCode.toString();
								}
								


							}
						});
			}

			$scope.reset = function() {

				if ($scope.repairMaster.isEdit == false) {
					
					
					$http.post($stateParams.tenantid+ "/app/master/repair/view",$location.search().repairId).success(
							function(response) {
								console.log(response);
								if (response.success == true) {
									$scope.repairMaster = response.repair;
									$scope.repairBank = response.repairBank;
									$scope.repairMaster.currencyId=response.repair.currencyId.toString();
									$scope.repairMaster.logoPath=response.repair.logoPath.toString();
									$scope.repairMaster.uom=response.repair.uom.toString();
									$scope.repairMaster.gstnCode=response.repair.gstnCode.toString();
								}
								
							});
					
					
				} else {
					$scope.repairBank = [];
					$scope.tempRepairBank={
					         repairId:'',
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
						   
						  var tmp=angular.copy($scope.tempRepairBank);
							$scope.repairBank.push(tmp);

					  }
					
					$scope.addCredRow();
					$scope.repairMaster = {									
						repairId : '',
						repairCode : '',
						repairName : '',
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
				$state.go("app.eqs.repair.repairlist", {
					tenantid : $stateParams.tenantid
				});
			}
		});