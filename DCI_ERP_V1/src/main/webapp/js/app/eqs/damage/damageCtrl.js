'use strict';

app.controller('damageListCtrl', function($scope, $stateParams, $state, $http,
		$location, ngDialog, logger, utilsService) {

	$scope.offsetCount = 0;
	$scope.limitCount = 1000;
	$scope.rowCollection = [];
	$scope.displayedCollection = [];
	$scope.itemsByPage = 10;

	$scope.isDelete = true;
	
	$scope.numPages = 0
	$scope.isEdit=false;
	$scope.getDamageList = function() {
		$http.get($stateParams.tenantid + '/api/damage/list').success(
				function(response) {
					console.log(response);
					$scope.rowCollection = response;
				});
	};
	$scope.getDamageList();

	$scope.editRow = function(damageId) {
		$location.url($stateParams.tenantid + '/damage/damageedit?damageId='
				+ damageId);
	}

	$scope.deleteRow = function(damageId) {
		ngDialog.openConfirm().then(function() {
			var url = $stateParams.tenantid+'/api/damage/delete?damageCode=' + damageId;
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
		$state.go("app.eqs.damage.damageadd", {
			tenantid : $stateParams.tenantid
		});
	};
	
	/* $scope.view = function(damageId) {	    	
	    	
	    	$location.url($stateParams.tenantid + '/damage/damageView?damageId='+ damageId);
	     }*/
});

app.controller('damageAddCtrl',
				function($scope, $state, $stateParams, $http, $location,
						ngDialog, logger, utilsService, sharedProperties,
						toaster, $rootScope, validationService) {
	
	
    $scope.damageBank=[];
		$scope.damageMaster = {
			damageId : '',
			damageCode : '',
			damageName : '',
			company :'',
			state : '',
			address : '',
			damageShortName : '',			
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
	        $scope.damageMaster=[];   
	        $scope.getDropdownvalue();
	      
	    };
			
				
				
		
						
	  $http.post($stateParams.tenantid+'/api/damage/countrylist').success(function(data) {
          		      	      	
      		$scope.countryList=data;
      		        		
      });
	  
	  $http.post($stateParams.tenantid+'/api/damage/statelist').success(function(data) {
  	      	
    		$scope.statelist=data;
    		        		
    });
	  
	  $http.post($stateParams.tenantid+'/api/damage/companylist').success(function(data) {
  	      	
    		$scope.companylist=data;
    		        		
    });
	  					  
						  
	

					
					
					
					//save
					$scope.save = function(damageMasterForm, damageMaster) {
						sharedProperties.clearObject();
						if (new validationService()
								.checkFormValidity(damageMasterForm)) {							
							
							
												 $http.post($stateParams.tenantid+'/api/damage/save', $scope.damageMaster).success(function(data) {
												if (data.isSuccess == true) {
													logger.logSuccess("Saved Succesfully!");
													$state.go("app.eqs.damage.damagelist",{tenantid : $stateParams.tenantid});

												} else {
													logger.logError(data.message);
												}
											});
						} else {
							toaster
									.pop('error',"Please fill the required fields",logger.getErrorHtmlNew(damageMasterForm.$validationSummary),5000, 'trustedHtml');
						}
					};
					
					
					
					//update
					$scope.update = function(damageMasterForm, damageMaster) {
						debugger;
						$scope.damageMaster.damageId = $location.search().damageId;
						sharedProperties.clearObject();
						if (new validationService()
								.checkFormValidity(damageMasterForm)) {
							
							
								
								 $http.post($stateParams.tenantid+'/api/damage/update', $scope.damageMaster).success(function(response) {
												if (response.isSuccess == true ) {
													logger.logSuccess("Updated Succesfully!");
													$state.go("app.eqs.damage.damagelist",{tenantid : $stateParams.tenantid});
												} else {
													logger.logError("Error in Update");
												}
											});
						} else {
							toaster.pop('error',"Please fill the required fields",logger.getErrorHtmlNew(damageMasterForm.$validationSummary),5000, 'trustedHtml');
						}
					};

					
					
					$scope.cancel = function() {
						$state.go("app.eqs.damage.damagelist", {
							tenantid : $stateParams.tenantid
						});
					}
					
					
					// Edit functionality
				    
				    $scope.isEdit=false;
				    
				    
				  var damageId = $location.search().damageId;
				  if(damageId != null){
					  $scope.isEdit=true;
				      
					  $http.post($stateParams.tenantid+'/api/damage/edit?damageCode=' +damageId).success(function(result) {
				          
				          if (result.isEdit == false) {
				              logger.logError("Please Try Again");
				          } else {
				              console.log("result***************for viewwwwwwwwwwwwwwwwww*******");
				              console.log(result);
				              $scope.damageMaster = result;
				                
				             
				          }
				            
				         }).error(function(data) {

				         });
				  }
				});


app.controller('damageViewCtrl',
		function($scope, $state, $stateParams, $http, $location,
				ngDialog, logger, utilsService, sharedProperties,
				toaster, $rootScope, validationService) {


$scope.damageBank=[];
$scope.damageMaster = {
	damageId : '',
	damageCode : '',
	damageName : '',
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
$scope.tempDamageBank={
         damageId:'',
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
		   
		  var tmp=angular.copy($scope.tempDamageBank);
			$scope.damageBank.push(tmp);

	  }
	  $scope.addCredRow();

		$scope.removeCredRow =function(){
			ngDialog.openConfirm().then(function() {
			if($scope.isEdit==false){
				var tmpDelList = [];
				for(var i=$scope.damageBank.length-1;i>=0;i--){
					if($scope.damageBank[i].select==true){
						tmpDelList.push($scope.damageBank[i]);
						$scope.damageBank.splice(i, 1);
					}
				}
				logger.logSuccess('Deleted Successfully');
			}else if($scope.isEdit==true){
				var tmpDelList = [];
				for(var i=$scope.damageBank.length-1;i>=0;i--){
					if($scope.damageBank[i].select==true){
						tmpDelList.push($scope.damageBank[i]);
					}
				}
				$http.post($stateParams.tenantid+'/app/master/consigneepartner/deleteKeyDetail',$scope.servicePartnerTable).success(function(data) {
		        	if(data.success){
		        		for(var i=$scope.damageBank.length-1;i>=0;i--){
		    				if($scope.damageBank[i].select==true){
		    					$scope.damageBank.splice(i, 1);
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
	
		$scope.$watch('damageMaster.cityId', function(newValue,oldValue) {
			if (newValue != '' && newValue != undefined) {
				$http.post($stateParams.tenantid + '/app/master/damage/dropDownList',newValue).success(function(datas) {
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
					  
				  
$scope.$watch('damageMaster.tenantId', function(newValue,
	oldValue) {
if (newValue != '' && newValue != undefined) {
	$http.post(
			$stateParams.tenantid
					+ '/app/master/damage/tenantList',
			newValue).success(function(datas) {
		console.log(datas);
		$scope.templateList = datas.templateList;
	});
}
});

			if ($location.search().damageId != 0
					&& $location.search().damageId != undefined) {
				$scope.damageMaster.isEdit = true;
				$scope.isEdit=true;
				$scope.damageMaster.damageId = $location.search().damageId;
				$scope.isEdit = true;
				$http.post(
						$stateParams.tenantid
								+ "/app/master/damage/view",
						$scope.damageMaster.damageId).success(
						function(response) {
							console.log(response);
							if (response.success == true) {
								$scope.damageMaster = response.damage;
								$scope.damageBank = response.damageBank;
								$scope.damageMaster.currencyName=response.damage.currencyName.toString();
								$scope.damageMaster.companyId=response.damage.companyId.toString();
								$scope.damageMaster.logoPath=response.damage.logoPath.toString();
								$scope.damageMaster.uom=response.damage.uom.toString();
								$scope.damageMaster.cityId=response.damage.cityId.toString();
								if(response.damage.countryId!=null){
									$scope.damageMaster.countryId=response.damage.countryId.toString();
								}
								if(response.damage.gstnCode!=null){
								$scope.damageMaster.gstnCode=response.damage.gstnCode.toString();
								}
								


							}
						});
			}

			$scope.reset = function() {

				if ($scope.damageMaster.isEdit == false) {
					
					
					$http.post($stateParams.tenantid+ "/app/master/damage/view",$location.search().damageId).success(
							function(response) {
								console.log(response);
								if (response.success == true) {
									$scope.damageMaster = response.damage;
									$scope.damageBank = response.damageBank;
									$scope.damageMaster.currencyId=response.damage.currencyId.toString();
									$scope.damageMaster.logoPath=response.damage.logoPath.toString();
									$scope.damageMaster.uom=response.damage.uom.toString();
									$scope.damageMaster.gstnCode=response.damage.gstnCode.toString();
								}
								
							});
					
					
				} else {
					$scope.damageBank = [];
					$scope.tempDamageBank={
					         damageId:'',
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
						   
						  var tmp=angular.copy($scope.tempDamageBank);
							$scope.damageBank.push(tmp);

					  }
					
					$scope.addCredRow();
					$scope.damageMaster = {									
						damageId : '',
						damageCode : '',
						damageName : '',
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
				$state.go("app.eqs.damage.damagelist", {
					tenantid : $stateParams.tenantid
				});
			}
		});