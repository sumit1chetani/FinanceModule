'use strict';

app.controller('descriptionListCtrl', function($scope, $stateParams, $state, $http,
		$location, ngDialog, logger, utilsService) {

	$scope.offsetCount = 0;
	$scope.limitCount = 1000;
	$scope.rowCollection = [];
	$scope.displayedCollection = [];
	$scope.itemsByPage = 10;

	$scope.isDelete = true;
	
	$scope.numPages = 0
	$scope.isEdit=false;
	$scope.getDescriptionList = function() {
		$http.get($stateParams.tenantid + '/api/description/list').success(
				function(response) {
					console.log(response);
					$scope.rowCollection = response;
				});
	};
	$scope.getDescriptionList();

	$scope.editRow = function(descriptionId) {
		$location.url($stateParams.tenantid + '/description/descriptionedit?descriptionId='
				+ descriptionId);
	}

	$scope.deleteRow = function(descriptionId) {
		ngDialog.openConfirm().then(function() {
			var url = $stateParams.tenantid+'/api/description/delete?descriptionCode='+descriptionId
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
		$state.go("app.eqs.description.descriptionadd", {
			tenantid : $stateParams.tenantid
		});
	};
	
	 /*$scope.view = function(descriptionId) {	    	
	    	
	    	$location.url($stateParams.tenantid + '/description/descriptionView?descriptionId='+ descriptionId);
	     }*/
});

app.controller('descriptionAddCtrl',
				function($scope, $state, $stateParams, $http, $location,
						ngDialog, logger, utilsService, sharedProperties,
						toaster, $rootScope, validationService) {
	
	
    $scope.descriptionBank=[];
		$scope.descriptionMaster = {
			descriptionId : '',
			descriptionCode : '',
			descriptionName : '',
			company :'',
			state : '',
			address : '',
			descriptionShortName : '',			
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
			        $scope.descriptionMaster=[];   
			        $scope.getDropdownvalue();

			    };
				
			
			
				
				
		
						
	  $http.post($stateParams.tenantid+'/api/description/countrylist').success(function(data) {
          		      	      	
      		$scope.countryList=data;
      		        		
      });
	  
	  $http.post($stateParams.tenantid+'/api/description/statelist').success(function(data) {
  	      	
    		$scope.statelist=data;
    		        		
    });
	  
	  $http.post($stateParams.tenantid+'/api/description/companylist').success(function(data) {
  	      	
    		$scope.companylist=data;
    		        		
    });
	  					  
						  
	

					
					
					
					//save
					$scope.save = function(descriptionMasterForm, descriptionMaster) {
						sharedProperties.clearObject();
						if (new validationService()
								.checkFormValidity(descriptionMasterForm)) {							
							
							
												 $http.post($stateParams.tenantid+'/api/description/save', $scope.descriptionMaster).success(function(data) {
												if (data.isSuccess == true) {
													logger.logSuccess("Saved Succesfully!");
													$state.go("app.eqs.description.descriptionlist",{tenantid : $stateParams.tenantid});

												} else {
													logger.logError(data.message);
												}
											});
						} else {
							toaster
									.pop('error',"Please fill the required fields",logger.getErrorHtmlNew(descriptionMasterForm.$validationSummary),5000, 'trustedHtml');
						}
					};
					
					
					
					//update
					$scope.update = function(descriptionMasterForm, descriptionMaster) {
						debugger;
						$scope.descriptionMaster.descriptionId = $location.search().descriptionId;
						sharedProperties.clearObject();
						if (new validationService()
								.checkFormValidity(descriptionMasterForm)) {
							
							
								
								 $http.post($stateParams.tenantid+'/api/description/update', $scope.descriptionMaster).success(function(response) {
												if (response.isSuccess == true ) {
													logger.logSuccess("Updated Succesfully!");
													$state.go("app.eqs.description.descriptionlist",{tenantid : $stateParams.tenantid});
												} else {
													logger.logError("Error in Update");
												}
											});
						} else {
							toaster.pop('error',"Please fill the required fields",logger.getErrorHtmlNew(descriptionMasterForm.$validationSummary),5000, 'trustedHtml');
						}
					};

					
					
					$scope.cancel = function() {
						$state.go("app.eqs.description.descriptionlist", {
							tenantid : $stateParams.tenantid
						});
					}
					
					
					// Edit functionality
				    
				    $scope.isEdit=false;
				    
				    
				  var descriptionId = $location.search().descriptionId;
				  if(descriptionId != null){
					  $scope.isEdit=true;
				      
					  $http.post($stateParams.tenantid+'/api/description/edit?descriptionCode=' +descriptionId).success(function(result) {
				          
				          if (result.isEdit == false) {
				              logger.logError("Please Try Again");
				          } else {
				              console.log("result***************for viewwwwwwwwwwwwwwwwww*******");
				              console.log(result);
				              $scope.descriptionMaster = result;
				                
				             
				          }
				            
				         }).error(function(data) {

				         });
				  }
				});


app.controller('descriptionViewCtrl',
		function($scope, $state, $stateParams, $http, $location,
				ngDialog, logger, utilsService, sharedProperties,
				toaster, $rootScope, validationService) {


$scope.descriptionBank=[];
$scope.descriptionMaster = {
	descriptionId : '',
	descriptionCode : '',
	descriptionName : '',
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
$scope.tempDescriptionBank={
         descriptionId:'',
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
		   
		  var tmp=angular.copy($scope.tempDescriptionBank);
			$scope.descriptionBank.push(tmp);

	  }
	  $scope.addCredRow();

		$scope.removeCredRow =function(){
			ngDialog.openConfirm().then(function() {
			if($scope.isEdit==false){
				var tmpDelList = [];
				for(var i=$scope.descriptionBank.length-1;i>=0;i--){
					if($scope.descriptionBank[i].select==true){
						tmpDelList.push($scope.descriptionBank[i]);
						$scope.descriptionBank.splice(i, 1);
					}
				}
				logger.logSuccess('Deleted Successfully');
			}else if($scope.isEdit==true){
				var tmpDelList = [];
				for(var i=$scope.descriptionBank.length-1;i>=0;i--){
					if($scope.descriptionBank[i].select==true){
						tmpDelList.push($scope.descriptionBank[i]);
					}
				}
				$http.post($stateParams.tenantid+'/app/master/consigneepartner/deleteKeyDetail',$scope.servicePartnerTable).success(function(data) {
		        	if(data.success){
		        		for(var i=$scope.descriptionBank.length-1;i>=0;i--){
		    				if($scope.descriptionBank[i].select==true){
		    					$scope.descriptionBank.splice(i, 1);
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
	
		$scope.$watch('descriptionMaster.cityId', function(newValue,oldValue) {
			if (newValue != '' && newValue != undefined) {
				$http.post($stateParams.tenantid + '/app/master/description/dropDownList',newValue).success(function(datas) {
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
					  
				  
$scope.$watch('descriptionMaster.tenantId', function(newValue,
	oldValue) {
if (newValue != '' && newValue != undefined) {
	$http.post(
			$stateParams.tenantid
					+ '/app/master/description/tenantList',
			newValue).success(function(datas) {
		console.log(datas);
		$scope.templateList = datas.templateList;
	});
}
});

			if ($location.search().descriptionId != 0
					&& $location.search().descriptionId != undefined) {
				$scope.descriptionMaster.isEdit = true;
				$scope.isEdit=true;
				$scope.descriptionMaster.descriptionId = $location.search().descriptionId;
				$scope.isEdit = true;
				$http.post(
						$stateParams.tenantid
								+ "/app/master/description/view",
						$scope.descriptionMaster.descriptionId).success(
						function(response) {
							console.log(response);
							if (response.success == true) {
								$scope.descriptionMaster = response.description;
								$scope.descriptionBank = response.descriptionBank;
								$scope.descriptionMaster.currencyName=response.description.currencyName.toString();
								$scope.descriptionMaster.companyId=response.description.companyId.toString();
								$scope.descriptionMaster.logoPath=response.description.logoPath.toString();
								$scope.descriptionMaster.uom=response.description.uom.toString();
								$scope.descriptionMaster.cityId=response.description.cityId.toString();
								if(response.description.countryId!=null){
									$scope.descriptionMaster.countryId=response.description.countryId.toString();
								}
								if(response.description.gstnCode!=null){
								$scope.descriptionMaster.gstnCode=response.description.gstnCode.toString();
								}
								


							}
						});
			}

			$scope.reset = function() {

				if ($scope.descriptionMaster.isEdit == false) {
					
					
					$http.post($stateParams.tenantid+ "/app/master/description/view",$location.search().descriptionId).success(
							function(response) {
								console.log(response);
								if (response.success == true) {
									$scope.descriptionMaster = response.description;
									$scope.descriptionBank = response.descriptionBank;
									$scope.descriptionMaster.currencyId=response.description.currencyId.toString();
									$scope.descriptionMaster.logoPath=response.description.logoPath.toString();
									$scope.descriptionMaster.uom=response.description.uom.toString();
									$scope.descriptionMaster.gstnCode=response.description.gstnCode.toString();
								}
								
							});
					
					
				} else {
					$scope.descriptionBank = [];
					$scope.tempDescriptionBank={
					         descriptionId:'',
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
						   
						  var tmp=angular.copy($scope.tempDescriptionBank);
							$scope.descriptionBank.push(tmp);

					  }
					
					$scope.addCredRow();
					$scope.descriptionMaster = {									
						descriptionId : '',
						descriptionCode : '',
						descriptionName : '',
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
				$state.go("app.eqs.description.descriptionlist", {
					tenantid : $stateParams.tenantid
				});
			}
		});