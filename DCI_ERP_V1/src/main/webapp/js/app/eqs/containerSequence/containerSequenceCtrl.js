'use strict';

app.controller('containerSequenceListCtrl', function($scope, $stateParams, $state, $http,
		$location, ngDialog, logger, utilsService) {

	$scope.offsetCount = 0;
	$scope.limitCount = 1000;
	$scope.rowCollection = [];
	$scope.displayedCollection = [];
	$scope.itemsByPage = 10;

	$scope.isDelete = true;
	
	$scope.numPages = 0
	$scope.isEdit=false;
	$scope.getContainerSequenceList = function() {
		$http.get($stateParams.tenantid + '/api/containerSequence/list').success(
				function(response) {
					console.log(response);
					$scope.rowCollection = response;
				});
	};
	$scope.getContainerSequenceList();

	$scope.editRow = function(containerSequenceId) {
		$location.url($stateParams.tenantid + '/containerSequence/containerSequenceedit?containerSequenceId='
				+ containerSequenceId);
	}

	$scope.deleteRow = function(containerSequenceId) {
		alert(1);
		ngDialog.openConfirm().then(
				function() {
					$http
							.get(
									$stateParams.tenantid
											+ "/api/containerSequence/delete?containerSequenceCode="+containerSequenceId).success(function(response) {
								if (response == true) {
									logger.logSuccess("Deleted Succesfully!");
									$scope.getContainerSequenceList();
								}
							}).error(function(response) {
								logger.logError("Error Please Try Again");
							});
				});
	};

	$scope.add = function() {
		$state.go("app.eqs.containerSequence.containerSequenceadd", {
			tenantid : $stateParams.tenantid
		});
	};
	
	 $scope.view = function(containerSequenceId) {	    	
	    	
	    	$location.url($stateParams.tenantid + '/containerSequence/containerSequenceView?containerSequenceId='+ containerSequenceId);
	     }
});

app.controller('containerSequenceAddCtrl',
				function($scope, $state, $stateParams, $http, $location,
						ngDialog, logger, utilsService, sharedProperties,
						toaster, $rootScope, validationService) {
	
	
    $scope.containerSequenceBank=[];
		$scope.containerSequenceMaster = {
			containerSequenceId : '',
			containerSequenceCode : '',
			containerSequenceName : '',
			company :'',
			state : '',
			address : '',
			containerSequenceShortName : '',			
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
			
		

				
			
			
				
				
		
						
	  $http.post($stateParams.tenantid+'/api/containerSequence/countrylist').success(function(data) {
          		      	      	
      		$scope.countryList=data;
      		        		
      });
	  
	  $http.post($stateParams.tenantid+'/api/containerSequence/statelist').success(function(data) {
  	      	
    		$scope.statelist=data;
    		        		
    });
	  
	  $http.post($stateParams.tenantid+'/api/containerSequence/companylist').success(function(data) {
  	      	
    		$scope.companylist=data;
    		        		
    });
	  					  
						  
	

					
					
					
					//save
					$scope.save = function(containerSequenceMasterForm, containerSequenceMaster) {
						sharedProperties.clearObject();
						if (new validationService()
								.checkFormValidity(containerSequenceMasterForm)) {							
							
							
												 $http.post($stateParams.tenantid+'/api/containerSequence/save', $scope.containerSequenceMaster).success(function(data) {
												if (data.isSuccess == true) {
													logger.logSuccess("Saved Succesfully!");
													$state.go("app.eqs.containerSequence.containerSequencelist",{tenantid : $stateParams.tenantid});

												} else {
													logger.logError(data.message);
												}
											});
						} else {
							toaster
									.pop('error',"Please fill the required fields",logger.getErrorHtmlNew(containerSequenceMasterForm.$validationSummary),5000, 'trustedHtml');
						}
					};
					
					
					
					//update
					$scope.update = function(containerSequenceMasterForm, containerSequenceMaster) {
						debugger;
						$scope.containerSequenceMaster.containerSequenceId = $location.search().containerSequenceId;
						sharedProperties.clearObject();
						if (new validationService()
								.checkFormValidity(containerSequenceMasterForm)) {
							
							
								
								 $http.post($stateParams.tenantid+'/api/containerSequence/update', $scope.containerSequenceMaster).success(function(response) {
												if (response.isSuccess == true ) {
													logger.logSuccess("Updated Succesfully!");
													$state.go("app.eqs.containerSequence.containerSequencelist",{tenantid : $stateParams.tenantid});
												} else {
													logger.logError("Error in Update");
												}
											});
						} else {
							toaster.pop('error',"Please fill the required fields",logger.getErrorHtmlNew(containerSequenceMasterForm.$validationSummary),5000, 'trustedHtml');
						}
					};

					
					
					$scope.cancel = function() {
						$state.go("app.eqs.containerSequence.containerSequencelist", {
							tenantid : $stateParams.tenantid
						});
					}
					
					
					// Edit functionality
				    
				    $scope.isEdit=false;
				    
				    
				  var containerSequenceId = $location.search().containerSequenceId;
				  if(containerSequenceId != null){
					  $scope.isEdit=true;
				      
					  $http.post($stateParams.tenantid+'/api/containerSequence/edit?containerSequenceCode=' +containerSequenceId).success(function(result) {
				          
				          if (result.isEdit == false) {
				              logger.logError("Please Try Again");
				          } else {
				              console.log("result***************for viewwwwwwwwwwwwwwwwww*******");
				              console.log(result);
				              $scope.containerSequenceMaster = result;
				                
				             
				          }
				            
				         }).error(function(data) {

				         });
				  }
				});


app.controller('containerSequenceViewCtrl',
		function($scope, $state, $stateParams, $http, $location,
				ngDialog, logger, utilsService, sharedProperties,
				toaster, $rootScope, validationService) {


$scope.containerSequenceBank=[];
$scope.containerSequenceMaster = {
	containerSequenceId : '',
	containerSequenceCode : '',
	containerSequenceName : '',
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
$scope.tempContainerSequenceBank={
         containerSequenceId:'',
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
		   
		  var tmp=angular.copy($scope.tempContainerSequenceBank);
			$scope.containerSequenceBank.push(tmp);

	  }
	  $scope.addCredRow();

		$scope.removeCredRow =function(){
			ngDialog.openConfirm().then(function() {
			if($scope.isEdit==false){
				var tmpDelList = [];
				for(var i=$scope.containerSequenceBank.length-1;i>=0;i--){
					if($scope.containerSequenceBank[i].select==true){
						tmpDelList.push($scope.containerSequenceBank[i]);
						$scope.containerSequenceBank.splice(i, 1);
					}
				}
				logger.logSuccess('Deleted Successfully');
			}else if($scope.isEdit==true){
				var tmpDelList = [];
				for(var i=$scope.containerSequenceBank.length-1;i>=0;i--){
					if($scope.containerSequenceBank[i].select==true){
						tmpDelList.push($scope.containerSequenceBank[i]);
					}
				}
				$http.post($stateParams.tenantid+'/app/master/consigneepartner/deleteKeyDetail',$scope.servicePartnerTable).success(function(data) {
		        	if(data.success){
		        		for(var i=$scope.containerSequenceBank.length-1;i>=0;i--){
		    				if($scope.containerSequenceBank[i].select==true){
		    					$scope.containerSequenceBank.splice(i, 1);
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
	
		$scope.$watch('containerSequenceMaster.cityId', function(newValue,oldValue) {
			if (newValue != '' && newValue != undefined) {
				$http.post($stateParams.tenantid + '/app/master/containerSequence/dropDownList',newValue).success(function(datas) {
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
					  
				  
$scope.$watch('containerSequenceMaster.tenantId', function(newValue,
	oldValue) {
if (newValue != '' && newValue != undefined) {
	$http.post(
			$stateParams.tenantid
					+ '/app/master/containerSequence/tenantList',
			newValue).success(function(datas) {
		console.log(datas);
		$scope.templateList = datas.templateList;
	});
}
});

			if ($location.search().containerSequenceId != 0
					&& $location.search().containerSequenceId != undefined) {
				$scope.containerSequenceMaster.isEdit = true;
				$scope.isEdit=true;
				$scope.containerSequenceMaster.containerSequenceId = $location.search().containerSequenceId;
				$scope.isEdit = true;
				$http.post(
						$stateParams.tenantid
								+ "/app/master/containerSequence/view",
						$scope.containerSequenceMaster.containerSequenceId).success(
						function(response) {
							console.log(response);
							if (response.success == true) {
								$scope.containerSequenceMaster = response.containerSequence;
								$scope.containerSequenceBank = response.containerSequenceBank;
								$scope.containerSequenceMaster.currencyName=response.containerSequence.currencyName.toString();
								$scope.containerSequenceMaster.companyId=response.containerSequence.companyId.toString();
								$scope.containerSequenceMaster.logoPath=response.containerSequence.logoPath.toString();
								$scope.containerSequenceMaster.uom=response.containerSequence.uom.toString();
								$scope.containerSequenceMaster.cityId=response.containerSequence.cityId.toString();
								if(response.containerSequence.countryId!=null){
									$scope.containerSequenceMaster.countryId=response.containerSequence.countryId.toString();
								}
								if(response.containerSequence.gstnCode!=null){
								$scope.containerSequenceMaster.gstnCode=response.containerSequence.gstnCode.toString();
								}
								


							}
						});
			}

			$scope.reset = function() {

				if ($scope.containerSequenceMaster.isEdit == false) {
					
					
					$http.post($stateParams.tenantid+ "/app/master/containerSequence/view",$location.search().containerSequenceId).success(
							function(response) {
								console.log(response);
								if (response.success == true) {
									$scope.containerSequenceMaster = response.containerSequence;
									$scope.containerSequenceBank = response.containerSequenceBank;
									$scope.containerSequenceMaster.currencyId=response.containerSequence.currencyId.toString();
									$scope.containerSequenceMaster.logoPath=response.containerSequence.logoPath.toString();
									$scope.containerSequenceMaster.uom=response.containerSequence.uom.toString();
									$scope.containerSequenceMaster.gstnCode=response.containerSequence.gstnCode.toString();
								}
								
							});
					
					
				} else {
					$scope.containerSequenceBank = [];
					$scope.tempContainerSequenceBank={
					         containerSequenceId:'',
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
						   
						  var tmp=angular.copy($scope.tempContainerSequenceBank);
							$scope.containerSequenceBank.push(tmp);

					  }
					
					$scope.addCredRow();
					$scope.containerSequenceMaster = {									
						containerSequenceId : '',
						containerSequenceCode : '',
						containerSequenceName : '',
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
				$state.go("app.eqs.containerSequence.containerSequencelist", {
					tenantid : $stateParams.tenantid
				});
			}
		});