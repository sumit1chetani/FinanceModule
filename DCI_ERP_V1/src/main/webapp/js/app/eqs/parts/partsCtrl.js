'use strict';

app.controller('partsListCtrl', function($scope, $stateParams, $state, $http,
		$location, ngDialog, logger, utilsService) {

	$scope.offsetCount = 0;
	$scope.limitCount = 1000;
	$scope.rowCollection = [];
	$scope.displayedCollection = [];
	$scope.itemsByPage = 10;

	$scope.isDelete = true;
	
	$scope.numPages = 0
	$scope.isEdit=false;
	$scope.getPartsList = function() {
		$http.get($stateParams.tenantid + '/api/parts/list').success(
				function(response) {
					console.log(response);
					$scope.rowCollection = response;
				});
	};
	$scope.getPartsList();

	$scope.editRow = function(partsId) {
		$location.url($stateParams.tenantid + '/parts/partsedit?partsId='
				+ partsId);
	}

	$scope.deleteRow = function(partsId) {
		ngDialog.openConfirm().then(function() {
			var url = $stateParams.tenantid+'/api/parts/delete?partsCode='+partsId;
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
		$state.go("app.eqs.parts.partsadd", {
			tenantid : $stateParams.tenantid
		});
	};
	
	 /*$scope.view = function(partsId) {	    	
	    	
	    	$location.url($stateParams.tenantid + '/parts/partsView?partsId='+ partsId);
	     }*/
});

app.controller('partsAddCtrl',
				function($scope, $state, $stateParams, $http, $location,
						ngDialog, logger, utilsService, sharedProperties,
						toaster, $rootScope, validationService) {
	
	
    $scope.partsBank=[];
		$scope.partsMaster = {
			partsId : '',
			partsCode : '',
			partsName : '',
			company :'',
			state : '',
			address : '',
			partsShortName : '',			
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
	        $scope.partsMaster=[];   
	        $scope.getDropdownvalue();

	    };	
			
			
				
				
		
						
	  $http.post($stateParams.tenantid+'/api/parts/countrylist').success(function(data) {
          		      	      	
      		$scope.countryList=data;
      		        		
      });
	  
	  $http.post($stateParams.tenantid+'/api/parts/statelist').success(function(data) {
  	      	
    		$scope.statelist=data;
    		        		
    });
	  
	  $http.post($stateParams.tenantid+'/api/parts/companylist').success(function(data) {
  	      	
    		$scope.companylist=data;
    		        		
    });
	  					  
						  
	

					
					
					
					//save
					$scope.save = function(partsMasterForm, partsMaster) {
						sharedProperties.clearObject();
						if (new validationService()
								.checkFormValidity(partsMasterForm)) {							
							
							
												 $http.post($stateParams.tenantid+'/api/parts/save', $scope.partsMaster).success(function(data) {
												if (data.isSuccess == true) {
													logger.logSuccess("Saved Succesfully!");
													$state.go("app.eqs.parts.partslist",{tenantid : $stateParams.tenantid});

												} else {
													logger.logError(data.message);
												}
											});
						} else {
							toaster
									.pop('error',"Please fill the required fields",logger.getErrorHtmlNew(partsMasterForm.$validationSummary),5000, 'trustedHtml');
						}
					};
					
					
					
					//update
					$scope.update = function(partsMasterForm, partsMaster) {
						debugger;
						$scope.partsMaster.partsId = $location.search().partsId;
						sharedProperties.clearObject();
						if (new validationService()
								.checkFormValidity(partsMasterForm)) {
							
							
								
								 $http.post($stateParams.tenantid+'/api/parts/update', $scope.partsMaster).success(function(response) {
												if (response.isSuccess == true ) {
													logger.logSuccess("Updated Succesfully!");
													$state.go("app.eqs.parts.partslist",{tenantid : $stateParams.tenantid});
												} else {
													logger.logError("Error in Update");
												}
											});
						} else {
							toaster.pop('error',"Please fill the required fields",logger.getErrorHtmlNew(partsMasterForm.$validationSummary),5000, 'trustedHtml');
						}
					};

					
					
					$scope.cancel = function() {
						$state.go("app.eqs.parts.partslist", {
							tenantid : $stateParams.tenantid
						});
					}
					
					
					// Edit functionality
				    
				    $scope.isEdit=false;
				    
				    
				  var partsId = $location.search().partsId;
				  if(partsId != null){
					  $scope.isEdit=true;
				      
					  $http.post($stateParams.tenantid+'/api/parts/edit?partsCode=' +partsId).success(function(result) {
				          
				          if (result.isEdit == false) {
				              logger.logError("Please Try Again");
				          } else {
				              console.log("result***************for viewwwwwwwwwwwwwwwwww*******");
				              console.log(result);
				              $scope.partsMaster = result;
				                
				             
				          }
				            
				         }).error(function(data) {

				         });
				  }
				});


app.controller('partsViewCtrl',
		function($scope, $state, $stateParams, $http, $location,
				ngDialog, logger, utilsService, sharedProperties,
				toaster, $rootScope, validationService) {


$scope.partsBank=[];
$scope.partsMaster = {
	partsId : '',
	partsCode : '',
	partsName : '',
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
$scope.tempPartsBank={
         partsId:'',
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
		   
		  var tmp=angular.copy($scope.tempPartsBank);
			$scope.partsBank.push(tmp);

	  }
	  $scope.addCredRow();

		$scope.removeCredRow =function(){
			ngDialog.openConfirm().then(function() {
			if($scope.isEdit==false){
				var tmpDelList = [];
				for(var i=$scope.partsBank.length-1;i>=0;i--){
					if($scope.partsBank[i].select==true){
						tmpDelList.push($scope.partsBank[i]);
						$scope.partsBank.splice(i, 1);
					}
				}
				logger.logSuccess('Deleted Successfully');
			}else if($scope.isEdit==true){
				var tmpDelList = [];
				for(var i=$scope.partsBank.length-1;i>=0;i--){
					if($scope.partsBank[i].select==true){
						tmpDelList.push($scope.partsBank[i]);
					}
				}
				$http.post($stateParams.tenantid+'/app/master/consigneepartner/deleteKeyDetail',$scope.servicePartnerTable).success(function(data) {
		        	if(data.success){
		        		for(var i=$scope.partsBank.length-1;i>=0;i--){
		    				if($scope.partsBank[i].select==true){
		    					$scope.partsBank.splice(i, 1);
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
	
		$scope.$watch('partsMaster.cityId', function(newValue,oldValue) {
			if (newValue != '' && newValue != undefined) {
				$http.post($stateParams.tenantid + '/app/master/parts/dropDownList',newValue).success(function(datas) {
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
					  
				  
$scope.$watch('partsMaster.tenantId', function(newValue,
	oldValue) {
if (newValue != '' && newValue != undefined) {
	$http.post(
			$stateParams.tenantid
					+ '/app/master/parts/tenantList',
			newValue).success(function(datas) {
		console.log(datas);
		$scope.templateList = datas.templateList;
	});
}
});

			if ($location.search().partsId != 0
					&& $location.search().partsId != undefined) {
				$scope.partsMaster.isEdit = true;
				$scope.isEdit=true;
				$scope.partsMaster.partsId = $location.search().partsId;
				$scope.isEdit = true;
				$http.post(
						$stateParams.tenantid
								+ "/app/master/parts/view",
						$scope.partsMaster.partsId).success(
						function(response) {
							console.log(response);
							if (response.success == true) {
								$scope.partsMaster = response.parts;
								$scope.partsBank = response.partsBank;
								$scope.partsMaster.currencyName=response.parts.currencyName.toString();
								$scope.partsMaster.companyId=response.parts.companyId.toString();
								$scope.partsMaster.logoPath=response.parts.logoPath.toString();
								$scope.partsMaster.uom=response.parts.uom.toString();
								$scope.partsMaster.cityId=response.parts.cityId.toString();
								if(response.parts.countryId!=null){
									$scope.partsMaster.countryId=response.parts.countryId.toString();
								}
								if(response.parts.gstnCode!=null){
								$scope.partsMaster.gstnCode=response.parts.gstnCode.toString();
								}
								


							}
						});
			}

			$scope.reset = function() {

				if ($scope.partsMaster.isEdit == false) {
					
					
					$http.post($stateParams.tenantid+ "/app/master/parts/view",$location.search().partsId).success(
							function(response) {
								console.log(response);
								if (response.success == true) {
									$scope.partsMaster = response.parts;
									$scope.partsBank = response.partsBank;
									$scope.partsMaster.currencyId=response.parts.currencyId.toString();
									$scope.partsMaster.logoPath=response.parts.logoPath.toString();
									$scope.partsMaster.uom=response.parts.uom.toString();
									$scope.partsMaster.gstnCode=response.parts.gstnCode.toString();
								}
								
							});
					
					
				} else {
					$scope.partsBank = [];
					$scope.tempPartsBank={
					         partsId:'',
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
						   
						  var tmp=angular.copy($scope.tempPartsBank);
							$scope.partsBank.push(tmp);

					  }
					
					$scope.addCredRow();
					$scope.partsMaster = {									
						partsId : '',
						partsCode : '',
						partsName : '',
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
				$state.go("app.eqs.parts.partslist", {
					tenantid : $stateParams.tenantid
				});
			}
		});