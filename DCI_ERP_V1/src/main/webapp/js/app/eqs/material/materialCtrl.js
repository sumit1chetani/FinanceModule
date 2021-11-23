'use strict';

app.controller('materialListCtrl', function($scope, $stateParams, $state, $http,
		$location, ngDialog, logger, utilsService) {

	$scope.offsetCount = 0;
	$scope.limitCount = 1000;
	$scope.rowCollection = [];
	$scope.displayedCollection = [];
	$scope.itemsByPage = 10;

	$scope.isDelete = true;
	
	$scope.numPages = 0
	$scope.isEdit=false;
	$scope.getMaterialList = function() {
		$http.get($stateParams.tenantid + '/api/material/list').success(
				function(response) {
					console.log(response);
					$scope.rowCollection = response;
				});
	};
	$scope.getMaterialList();

	$scope.editRow = function(materialId) {
		$location.url($stateParams.tenantid + '/material/materialedit?materialId='
				+ materialId);
	}

	$scope.deleteRow = function(materialId) {
		ngDialog.openConfirm().then(function() {
			var url = $stateParams.tenantid+'/api/material/delete?materialCode='+materialId;
			$http.get(url).success(function(result){
                if (result.isSuccess ==  true) {
                    logger.logSuccess("Deleted Successfully");
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
		$state.go("app.eqs.material.materialadd", {
			tenantid : $stateParams.tenantid
		});
	};
	
	/* $scope.view = function(materialId) {	    	
	    	
	    	$location.url($stateParams.tenantid + '/material/materialView?materialId='+ materialId);
	     }*/
});

app.controller('materialAddCtrl',
				function($scope, $state, $stateParams, $http, $location,
						ngDialog, logger, utilsService, sharedProperties,
						toaster, $rootScope, validationService) {
	
	
    $scope.materialBank=[];
		$scope.materialMaster = {
			materialId : '',
			materialCode : '',
			materialName : '',
			company :'',
			state : '',
			address : '',
			materialShortName : '',			
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
	        $scope.materialMaster=[];   
	        $scope.getDropdownvalue();

	    };
				
				
		
						
	  $http.post($stateParams.tenantid+'/api/material/countrylist').success(function(data) {
          		      	      	
      		$scope.countryList=data;
      		        		
      });
	  
	  $http.post($stateParams.tenantid+'/api/material/statelist').success(function(data) {
  	      	
    		$scope.statelist=data;
    		        		
    });
	  
	  $http.post($stateParams.tenantid+'/api/material/companylist').success(function(data) {
  	      	
    		$scope.companylist=data;
    		        		
    });
	  					  
						  
	

					
					
					
					//save
					$scope.save = function(materialMasterForm, materialMaster) {
						sharedProperties.clearObject();
						if (new validationService()
								.checkFormValidity(materialMasterForm)) {							
							
							
												 $http.post($stateParams.tenantid+'/api/material/save', $scope.materialMaster).success(function(data) {
												if (data.isSuccess == true) {
													logger.logSuccess("Saved Succesfully!");
													$state.go("app.eqs.material.materiallist",{tenantid : $stateParams.tenantid});

												} else {
													logger.logError(data.message);
												}
											});
						} else {
							toaster
									.pop('error',"Please fill the required fields",logger.getErrorHtmlNew(materialMasterForm.$validationSummary),5000, 'trustedHtml');
						}
					};
					
					
					
					//update
					$scope.update = function(materialMasterForm, materialMaster) {
						debugger;
						$scope.materialMaster.materialId = $location.search().materialId;
						sharedProperties.clearObject();
						if (new validationService()
								.checkFormValidity(materialMasterForm)) {
							
							
								
								 $http.post($stateParams.tenantid+'/api/material/update', $scope.materialMaster).success(function(response) {
												if (response.isSuccess == true ) {
													logger.logSuccess("Updated Succesfully!");
													$state.go("app.eqs.material.materiallist",{tenantid : $stateParams.tenantid});
												} else {
													logger.logError("Error in Update");
												}
											});
						} else {
							toaster.pop('error',"Please fill the required fields",logger.getErrorHtmlNew(materialMasterForm.$validationSummary),5000, 'trustedHtml');
						}
					};

					
					
					$scope.cancel = function() {
						$state.go("app.eqs.material.materiallist", {
							tenantid : $stateParams.tenantid
						});
					}
					
					
					// Edit functionality
				    
				    $scope.isEdit=false;
				    
				    
				  var materialId = $location.search().materialId;
				  if(materialId != null){
					  $scope.isEdit=true;
				      
					  $http.post($stateParams.tenantid+'/api/material/edit?materialCode=' +materialId).success(function(result) {
				          
				          if (result.isEdit == false) {
				              logger.logError("Please Try Again");
				          } else {
				              console.log("result***************for viewwwwwwwwwwwwwwwwww*******");
				              console.log(result);
				              $scope.materialMaster = result;
				                
				             
				          }
				            
				         }).error(function(data) {

				         });
				  }
				});


app.controller('materialViewCtrl',
		function($scope, $state, $stateParams, $http, $location,
				ngDialog, logger, utilsService, sharedProperties,
				toaster, $rootScope, validationService) {


$scope.materialBank=[];
$scope.materialMaster = {
	materialId : '',
	materialCode : '',
	materialName : '',
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
$scope.tempMaterialBank={
         materialId:'',
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
		   
		  var tmp=angular.copy($scope.tempMaterialBank);
			$scope.materialBank.push(tmp);

	  }
	  $scope.addCredRow();

		$scope.removeCredRow =function(){
			ngDialog.openConfirm().then(function() {
			if($scope.isEdit==false){
				var tmpDelList = [];
				for(var i=$scope.materialBank.length-1;i>=0;i--){
					if($scope.materialBank[i].select==true){
						tmpDelList.push($scope.materialBank[i]);
						$scope.materialBank.splice(i, 1);
					}
				}
				logger.logSuccess('Deleted Successfully');
			}else if($scope.isEdit==true){
				var tmpDelList = [];
				for(var i=$scope.materialBank.length-1;i>=0;i--){
					if($scope.materialBank[i].select==true){
						tmpDelList.push($scope.materialBank[i]);
					}
				}
				$http.post($stateParams.tenantid+'/app/master/consigneepartner/deleteKeyDetail',$scope.servicePartnerTable).success(function(data) {
		        	if(data.success){
		        		for(var i=$scope.materialBank.length-1;i>=0;i--){
		    				if($scope.materialBank[i].select==true){
		    					$scope.materialBank.splice(i, 1);
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
	
		$scope.$watch('materialMaster.cityId', function(newValue,oldValue) {
			if (newValue != '' && newValue != undefined) {
				$http.post($stateParams.tenantid + '/app/master/material/dropDownList',newValue).success(function(datas) {
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
					  
				  
$scope.$watch('materialMaster.tenantId', function(newValue,
	oldValue) {
if (newValue != '' && newValue != undefined) {
	$http.post(
			$stateParams.tenantid
					+ '/app/master/material/tenantList',
			newValue).success(function(datas) {
		console.log(datas);
		$scope.templateList = datas.templateList;
	});
}
});

			if ($location.search().materialId != 0
					&& $location.search().materialId != undefined) {
				$scope.materialMaster.isEdit = true;
				$scope.isEdit=true;
				$scope.materialMaster.materialId = $location.search().materialId;
				$scope.isEdit = true;
				$http.post(
						$stateParams.tenantid
								+ "/app/master/material/view",
						$scope.materialMaster.materialId).success(
						function(response) {
							console.log(response);
							if (response.success == true) {
								$scope.materialMaster = response.material;
								$scope.materialBank = response.materialBank;
								$scope.materialMaster.currencyName=response.material.currencyName.toString();
								$scope.materialMaster.companyId=response.material.companyId.toString();
								$scope.materialMaster.logoPath=response.material.logoPath.toString();
								$scope.materialMaster.uom=response.material.uom.toString();
								$scope.materialMaster.cityId=response.material.cityId.toString();
								if(response.material.countryId!=null){
									$scope.materialMaster.countryId=response.material.countryId.toString();
								}
								if(response.material.gstnCode!=null){
								$scope.materialMaster.gstnCode=response.material.gstnCode.toString();
								}
								


							}
						});
			}

			$scope.reset = function() {

				if ($scope.materialMaster.isEdit == false) {
					
					
					$http.post($stateParams.tenantid+ "/app/master/material/view",$location.search().materialId).success(
							function(response) {
								console.log(response);
								if (response.success == true) {
									$scope.materialMaster = response.material;
									$scope.materialBank = response.materialBank;
									$scope.materialMaster.currencyId=response.material.currencyId.toString();
									$scope.materialMaster.logoPath=response.material.logoPath.toString();
									$scope.materialMaster.uom=response.material.uom.toString();
									$scope.materialMaster.gstnCode=response.material.gstnCode.toString();
								}
								
							});
					
					
				} else {
					$scope.materialBank = [];
					$scope.tempMaterialBank={
					         materialId:'',
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
						   
						  var tmp=angular.copy($scope.tempMaterialBank);
							$scope.materialBank.push(tmp);

					  }
					
					$scope.addCredRow();
					$scope.materialMaster = {									
						materialId : '',
						materialCode : '',
						materialName : '',
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
				$state.go("app.eqs.material.materiallist", {
					tenantid : $stateParams.tenantid
				});
			}
		});