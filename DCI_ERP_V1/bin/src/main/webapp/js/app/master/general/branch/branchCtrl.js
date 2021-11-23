'use strict';

app.controller('branchListCtrl', function($scope, $stateParams, $state, $http,
		$location, ngDialog, logger, utilsService) {

	
	$scope.offsetCount = 0;
	$scope.limitCount = 1000;
	$scope.rowCollection = [];
	$scope.displayedCollection = [];
	$scope.itemsByPage = 10;

	$scope.isDelete = true;
	
	$scope.numPages = 0
	$scope.isEdit=false;
	$scope.getBranchList = function() {
		$http.get($stateParams.tenantid + '/app/master/branch/list').success(
				function(response) {
					$scope.rowCollection = response.branchList;
				});
	};
	$scope.getBranchList();

	$scope.editRow = function(branchId) {
		$location.url($stateParams.tenantid + '/brach/branchedit?branchId='
				+ branchId);
	}

	$scope.deleteRow = function(branchId) {
		ngDialog.openConfirm().then(
				function() {
					$http
							.post(
									$stateParams.tenantid
											+ "/app/master/branch/delete",
									branchId).success(function(response) {
								if (response == true) {
									logger.logSuccess("Deleted Succesfully!");
									$scope.getBranchList();
								}
							}).error(function(response) {
								logger.logError("Error Please Try Again");
							});
				});
	};

	$scope.add = function() {
		$state.go("app.master.general.branch.branchadd", {
			tenantid : $stateParams.tenantid
		});
	};
	
	 $scope.view = function(branchId) {
	    	$location.url($stateParams.tenantid+'/brach/branchView?branchId='+branchId); 
	     }
});

app.controller('branchAddCtrl',
				function($scope, $state, $stateParams, $http, $location,
						ngDialog, logger, utilsService, sharedProperties,
						toaster, $rootScope, validationService) {
	
	
    $scope.branchBank=[];
		$scope.branchMaster = {
			branchId : '',
			branchCode : '',
			branchName : '',
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
		$scope.tempBranchBank={
		         branchId:'',
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
				   
				  var tmp=angular.copy($scope.tempBranchBank);
					$scope.branchBank.push(tmp);

			  }
			  $scope.addCredRow();
			  $scope.removeCredRow =function(){
				  var tmp=[];
					angular.forEach($scope.branchBank, function(row, index) { 
						if(row.select==false){
							tmp.push(row);
						}
					})
					$scope.branchBank=tmp;
			  }
				/*$scope.removeCredRow =function(){
					ngDialog.openConfirm().then(function() {
					if($scope.isEdit==false || $scope.isEdit==undefined){
						var tmpDelList = [];
						for(var i=$scope.branchBank.length-1;i>=0;i--){
							if($scope.branchBank[i].select==true){
								tmpDelList.push($scope.branchBank[i]);
								$scope.branchBank.splice(i, 1);
							}
						}
						logger.logSuccess('Deleted Successfully');
					}else if($scope.isEdit==true){
						var tmpDelList = [];
						for(var i=$scope.branchBank.length-1;i>=0;i--){
							if($scope.branchBank[i].select==true){
								tmpDelList.push($scope.branchBank[i]);
							}
						}
						$http.post($stateParams.tenantid+'/app/master/branch/deleteKeyDetail',tmpDelList).success(function(data) {
				        	if(data.success){
				        		for(var i=$scope.branchBank.length-1;i>=0;i--){
				    				if($scope.branchBank[i].select==true){
				    					$scope.branchBank.splice(i, 1);
				    				}
				    			}
				        		logger.logSuccess('Deleted Successfully');
				        	}else{
				        		logger.logError('Unable to delete');
				        	}
						})
					}
					})
				}*/
			
				$scope.$watch('branchMaster.cityId', function(newValue,oldValue) {
					if (newValue != '' && newValue != undefined) {
						$http.post($stateParams.tenantid + '/app/master/branch/dropDownList',newValue).success(function(datas) {
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
						
	 /* $http.post($stateParams.tenantid+'/app/master/hbl/dropDownList').success(function(data) {
          		      	      	
      		$scope.currencyList=data.currency;
      		//$scope.companyList=data.company;
      		$scope.uomList=data.uom;
      		$scope.logoPathList=data.logoPath;           		
      });*/
	  $http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(datas) {	  
		  $scope.companyList=datas.compList;
		  $scope.currencyList = datas.getcurrencylist;
		  //$scope.currencyList = datas.getcurrencylist;


	}).error(function(data) {

	});				  
						  
	$scope.$watch('branchMaster.tenantId', function(newValue,
			oldValue) {
		if (newValue != '' && newValue != undefined) {
			$http.post(
					$stateParams.tenantid
							+ '/app/master/branch/tenantList',
					newValue).success(function(datas) {
				console.log(datas);
				$scope.templateList = datas.templateList;
			});
		}
	});

					if ($location.search().branchId != 0
							&& $location.search().branchId != undefined) {
						$scope.branchMaster.isEdit = true;
						$scope.isEdit=true;
						$scope.branchMaster.branchId = $location.search().branchId;
						$scope.isEdit = true;
						$http.post(
								$stateParams.tenantid
										+ "/app/master/branch/edit",
								$scope.branchMaster.branchId).success(
								function(response) {
									console.log(response);
									if (response.success == true) {
										$scope.branchMaster.email=response.branch.email.toString();

										$scope.branchMaster = response.branch;
										$scope.branchBank = response.branchBank;
										$scope.branchMaster.currencyId=response.branch.currencyId.toString();
										$scope.branchMaster.companyId=response.branch.companyId.toString();
										$scope.branchMaster.logoPath=response.branch.logoPath.toString();
										$scope.branchMaster.uom=response.branch.uom.toString();
										$scope.branchMaster.cityId=response.branch.cityId.toString();
										if(response.branch.countryId!=null){
											$scope.branchMaster.countryId=response.branch.countryId.toString();
										}
										if(response.branch.gstnCode!=null){
										$scope.branchMaster.gstnCode=response.branch.gstnCode.toString();
										}
										


									}
								});
					}

					$scope.reset = function() {

						if ($scope.branchMaster.isEdit == false) {
							
							
							$http.post($stateParams.tenantid+ "/app/master/branch/edit",$location.search().branchId).success(
									function(response) {
										console.log(response);
										if (response.success == true) {
											$scope.branchMaster = response.branch;
											$scope.branchBank = response.branchBank;
											$scope.branchMaster.currencyId=response.branch.currencyId.toString();
											$scope.branchMaster.logoPath=response.branch.logoPath.toString();
											$scope.branchMaster.uom=response.branch.uom.toString();
											$scope.branchMaster.gstnCode=response.branch.gstnCode.toString();
										}
										
									});
							
							
						} else {
							$scope.branchBank = [];
							$scope.tempBranchBank={
							         branchId:'',
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
								   
								  var tmp=angular.copy($scope.tempBranchBank);
									$scope.branchBank.push(tmp);

							  }
							
							$scope.addCredRow();
							$scope.branchMaster = {									
								branchId : '',
								branchCode : '',
								branchName : '',
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

					$scope.save = function(branchMasterForm, branchMaster) {
						sharedProperties.clearObject();
						if (new validationService()
								.checkFormValidity(branchMasterForm)) {
							
							var obj=
							{
								branch:$scope.branchMaster,
								branchBank:$scope.branchBank,	
							}
							$http.post($stateParams.tenantid
													+ "/app/master/branch/save",
													obj)
									.success(
											function(response) {
												if (response.success == true) {
													logger
															.logSuccess("Saved Succesfully!");
													$state
															.go(
																	"app.master.general.branch.branchlist",
																	{
																		tenantid : $stateParams.tenantid
																	});

												} else {
													logger
															.logError("Branch Code or Branch Name Already Exist");
												}
											});
						} else {
							toaster
									.pop(
											'error',
											"Please fill the required fields",
											logger
													.getErrorHtmlNew(branchMasterForm.$validationSummary),
											5000, 'trustedHtml');
						}
					};
					$scope.update = function(branchMasterForm, branchMaster) {
						debugger;
						$scope.branchMaster.branchId = $location.search().branchId;
						sharedProperties.clearObject();
						if (new validationService()
								.checkFormValidity(branchMasterForm)) {
							
							var obj=
							{
								branch:$scope.branchMaster,
								branchBank:$scope.branchBank,
							}
							$http.post($stateParams.tenantid+ "/app/master/branch/update",obj).success(function(response)
									{
												if (response.success == true ) {
													logger
															.logSuccess("Updated Succesfully!");
													$state
															.go(
																	"app.master.general.branch.branchlist",
																	{
																		tenantid : $stateParams.tenantid
																	});
												} else {
													logger
															.logError("Branch Code Already Exist");
												}
											});
						} else {
							toaster
									.pop(
											'error',
											"Please fill the required fields",
											logger
													.getErrorHtmlNew(branchMasterForm.$validationSummary),
											5000, 'trustedHtml');
						}
					};

					$scope.cancel = function() {
						$state.go("app.master.general.branch.branchlist", {
							tenantid : $stateParams.tenantid
						});
					}
				});


app.controller('branchViewCtrl',
		function($scope, $state, $stateParams, $http, $location,
				ngDialog, logger, utilsService, sharedProperties,
				toaster, $rootScope, validationService) {


$scope.branchBank=[];
$scope.branchMaster = {
	branchId : '',
	branchCode : '',
	branchName : '',
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
$scope.tempBranchBank={
         branchId:'',
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
		   
		  var tmp=angular.copy($scope.tempBranchBank);
			$scope.branchBank.push(tmp);

	  }
	  $scope.addCredRow();
	  $scope.removeCredRow =function(){
		  var tmp=[];
			angular.forEach($scope.branchBank, function(row, index) { 
				if(row.select==false){
					tmp.push(row);
				}
			})
			$scope.branchBank=tmp;
	  }
		/*$scope.removeCredRow =function(){
			ngDialog.openConfirm().then(function() {
			if($scope.isEdit==false){
				var tmpDelList = [];
				for(var i=$scope.branchBank.length-1;i>=0;i--){
					if($scope.branchBank[i].select==true){
						tmpDelList.push($scope.branchBank[i]);
						$scope.branchBank.splice(i, 1);
					}
				}
				logger.logSuccess('Deleted Successfully');
			}else if($scope.isEdit==true){
				var tmpDelList = [];
				for(var i=$scope.branchBank.length-1;i>=0;i--){
					if($scope.branchBank[i].select==true){
						tmpDelList.push($scope.branchBank[i]);
					}
				}
				$http.post($stateParams.tenantid+'/app/master/branch/deleteKeyDetail',tmpDelList).success(function(data) {
		        	if(data.success){
		        		for(var i=$scope.branchBank.length-1;i>=0;i--){
		    				if($scope.branchBank[i].select==true){
		    					$scope.branchBank.splice(i, 1);
		    				}
		    			}
		        		logger.logSuccess('Deleted Successfully');
		        	}else{
		        		logger.logError('Unable to delete');
		        	}
				})
			}
			})
		}*/
	
		$scope.$watch('branchMaster.cityId', function(newValue,oldValue) {
			if (newValue != '' && newValue != undefined) {
				$http.post($stateParams.tenantid + '/app/master/branch/dropDownList',newValue).success(function(datas) {
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
					  
				  
$scope.$watch('branchMaster.tenantId', function(newValue,
	oldValue) {
if (newValue != '' && newValue != undefined) {
	$http.post(
			$stateParams.tenantid
					+ '/app/master/branch/tenantList',
			newValue).success(function(datas) {
		console.log(datas);
		$scope.templateList = datas.templateList;
	});
}
});

			if ($location.search().branchId != 0
					&& $location.search().branchId != undefined) {
				$scope.branchMaster.isEdit = true;
				$scope.isEdit=true;
				$scope.branchMaster.branchId = $location.search().branchId;
				$scope.isEdit = true;
				$http.post(
						$stateParams.tenantid
								+ "/app/master/branch/view",
						$scope.branchMaster.branchId).success(
						function(response) {
							console.log(response);
							if (response.success == true) {
								$scope.branchMaster = response.branch;
								$scope.branchBank = response.branchBank;
								$scope.branchMaster.currencyName=response.branch.currencyName.toString();
								$scope.branchMaster.companyId=response.branch.companyId.toString();
								$scope.branchMaster.logoPath=response.branch.logoPath.toString();
								$scope.branchMaster.uom=response.branch.uom.toString();
								$scope.branchMaster.cityId=response.branch.cityId.toString();
								if(response.branch.countryId!=null){
									$scope.branchMaster.countryId=response.branch.countryId.toString();
								}
								if(response.branch.gstnCode!=null){
								$scope.branchMaster.gstnCode=response.branch.gstnCode.toString();
								}
								


							}
						});
			}

			$scope.reset = function() {

				if ($scope.branchMaster.isEdit == false) {
					
					
					$http.post($stateParams.tenantid+ "/app/master/branch/view",$location.search().branchId).success(
							function(response) {
								console.log(response);
								if (response.success == true) {
									$scope.branchMaster = response.branch;
									$scope.branchBank = response.branchBank;
									$scope.branchMaster.currencyId=response.branch.currencyId.toString();
									$scope.branchMaster.logoPath=response.branch.logoPath.toString();
									$scope.branchMaster.uom=response.branch.uom.toString();
									$scope.branchMaster.gstnCode=response.branch.gstnCode.toString();
								}
								
							});
					
					
				} else {
					$scope.branchBank = [];
					$scope.tempBranchBank={
					         branchId:'',
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
						   
						  var tmp=angular.copy($scope.tempBranchBank);
							$scope.branchBank.push(tmp);

					  }
					
					$scope.addCredRow();
					$scope.branchMaster = {									
						branchId : '',
						branchCode : '',
						branchName : '',
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
				$state.go("app.master.general.branch.branchlist", {
					tenantid : $stateParams.tenantid
				});
			}
		});