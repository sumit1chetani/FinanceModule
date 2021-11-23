'use strict';

app.controller('lineListCtrl', function($scope, $stateParams, $state, $http,
		$location, ngDialog, logger, utilsService) {

	$scope.offsetCount = 0;
	$scope.limitCount = 1000;
	$scope.rowCollection = [];
	$scope.displayedCollection = [];
	$scope.itemsByPage = 10;

	$scope.isDelete = true;
	
	$scope.numPages = 0
	$scope.isEdit=false;
	$scope.getLineList = function() {
		$http.get($stateParams.tenantid + '/api/line/list').success(
				function(response) {
					console.log(response);
					$scope.rowCollection = response;
				});
	};
	$scope.getLineList();

	$scope.editRow = function(lineId) {
		$location.url($stateParams.tenantid + '/line/lineedit?lineId='
				+ lineId);
	}

	$scope.deleteRow = function(lineId) {
		ngDialog.openConfirm().then(
				function() {
					$http
							.post(
									$stateParams.tenantid
											+ "/api/line/delete",
									lineId).success(function(response) {
								if (response == true) {
									logger.logSuccess("Deleted Succesfully!");
									$scope.getLineList();
								}
							}).error(function(response) {
								logger.logError("Error Please Try Again");
							});
				});
	};

	$scope.add = function() {
		$state.go("app.master.general.line.lineadd", {
			tenantid : $stateParams.tenantid
		});
	};
	
	 $scope.view = function(lineId) {	    	
	    	
	    	$location.url($stateParams.tenantid + '/line/lineView?lineId='+ lineId);
	     }
});

app.controller('lineAddCtrl',
				function($scope, $state, $stateParams, $http, $location,
						ngDialog, logger, utilsService, sharedProperties,
						toaster, $rootScope, validationService) {
	
	
    $scope.lineBank=[];
		$scope.lineMaster = {
			lineId : '',
			lineCode : '',
			lineName : '',
			company :'',
			state : '',
			address : '',
			lineShortName : '',			
			country : '',			
			eMail : '',	
			phone : '',
			companyId:'',
			countryId:'',
			personIncharge : '',
				blCode : '',
				payableac : '',
				receivableac : '',
				profile :'',
				blclause : ''
			
		}
		
		
		
		
		$scope.countryList = [];
		$scope.stateList = [];
		$scope.companylist= [];
			
		

				
			
		//Reset on add mode
	    $scope.reset = function() {
	        $scope.lineMaster=[];   
	        $scope.getDropdownvalue();
	      if($scope.lineMaster.eMail==undefined)
	            {
	            $scope.lineMaster.eMail=null;            
	            }
	    };
				
				
		
						
	  $http.post($stateParams.tenantid+'/api/line/countrylist').success(function(data) {
          		      	      	
      		$scope.countryList=data;
      		        		
      });
	  
	  $http.post($stateParams.tenantid+'/api/line/statelist').success(function(data) {
  	      	
    		$scope.statelist=data;
    		        		
    });
	  
	  $http.post($stateParams.tenantid+'/api/line/companylist').success(function(data) {
  	      	
    		$scope.companylist=data;
    		        		
    });
	  					  
						  
	

					
					
					
					//save
					$scope.save = function(lineMasterForm, lineMaster) {
						sharedProperties.clearObject();
						if (new validationService()
								.checkFormValidity(lineMasterForm)) {	
							
							 var flag = true;
							  
							  if ($scope.lineMaster.eMail != undefined && $scope.lineMaster.eMail != null && $scope.lineMaster.eMail != '') {
					              
					              flag = $scope.validateEmail($scope.lineMaster.eMail);
					          }
							

							
							  if (flag == true){

												 $http.post($stateParams.tenantid+'/api/line/create', $scope.lineMaster).success(function(data) {
												if (data.isSuccess == true) {
													logger.logSuccess("Saved Succesfully!");
													$state.go("app.master.general.line.linelist",{tenantid : $stateParams.tenantid});

												} else {
													logger.logError(data.message);
												}
											});
						}
							  else{
								  logger.logError("Please Enter Valid  Email Address");
							  }
						}
								else {
							toaster
									.pop('error',"Please fill the required fields",logger.getErrorHtmlNew(lineMasterForm.$validationSummary),5000, 'trustedHtml');
						}
					};
					
					//email validation
					$scope.validateEmail = function(email) {
				        var reg = /^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9\-]+\.)+([a-zA-Z0-9\-\.]+)+([,]([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9\-]+\.)+([a-zA-Z0-9\-\.]+))*$/
				        if (reg.test(email)) {
				            return true;
				        } else {
				            // logger.logError("Please Enter Valida Email Address");
				            return false;
				        }
				    }
				  

					
					
					
					//update
					$scope.update = function(lineMasterForm, lineMaster) {
						debugger;
						$scope.lineMaster.lineId = $location.search().lineId;
						sharedProperties.clearObject();
						if (new validationService()
								.checkFormValidity(lineMasterForm)) {
							 var flag = true;

							
							  if (flag == true){

								
								 $http.post($stateParams.tenantid+'/api/line/update', $scope.lineMaster).success(function(response) {
												if (response.isSuccess == true ) {
													logger.logSuccess("Updated Succesfully!");
													$state.go("app.master.general.line.linelist",{tenantid : $stateParams.tenantid});
												} else {
													logger.logError("Error in Update");
												}
											});
						} 
							  else{
								  logger.logError("Please Enter Valid  Email Address");
							  }
						}
							  
							  else {
							toaster.pop('error',"Please fill the required fields",logger.getErrorHtmlNew(lineMasterForm.$validationSummary),5000, 'trustedHtml');
						}
					};

					
					
					$scope.cancel = function() {
						$state.go("app.master.general.line.linelist", {
							tenantid : $stateParams.tenantid
						});
					}
					
					
					// Edit functionality
				    
				    $scope.isEdit=false;
				    
				    
				  var lineId = $location.search().lineId;
				  if(lineId != null){
					  $scope.isEdit=true;
				      
					  $http.post($stateParams.tenantid+'/api/line/edit?lineCode=' +lineId).success(function(result) {
				          
				          if (result.isEdit == false) {
				              logger.logError("Please Try Again");
				          } else {
				              console.log("result***************for viewwwwwwwwwwwwwwwwww*******");
				              console.log(result);
				              $scope.lineMaster = result;
				                
				             
				          }
				            
				         }).error(function(data) {

				         });
				  }
				});


app.controller('lineViewCtrl',
		function($scope, $state, $stateParams, $http, $location,
				ngDialog, logger, utilsService, sharedProperties,
				toaster, $rootScope, validationService) {


$scope.lineBank=[];
$scope.lineMaster = {
	lineId : '',
	lineCode : '',
	lineName : '',
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
	phone : '',
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
	cityId:'',
	blCode : '',
	payableac : '',
	receivableac : '',
	profile :'',
	blclause : ''
}
$scope.tempLineBank={
         lineId:'',
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
		   
		  var tmp=angular.copy($scope.tempLineBank);
			$scope.lineBank.push(tmp);

	  }
	  $scope.addCredRow();

		$scope.removeCredRow =function(){
			ngDialog.openConfirm().then(function() {
			if($scope.isEdit==false){
				var tmpDelList = [];
				for(var i=$scope.lineBank.length-1;i>=0;i--){
					if($scope.lineBank[i].select==true){
						tmpDelList.push($scope.lineBank[i]);
						$scope.lineBank.splice(i, 1);
					}
				}
				logger.logSuccess('Deleted Successfully');
			}else if($scope.isEdit==true){
				var tmpDelList = [];
				for(var i=$scope.lineBank.length-1;i>=0;i--){
					if($scope.lineBank[i].select==true){
						tmpDelList.push($scope.lineBank[i]);
					}
				}
				$http.post($stateParams.tenantid+'/app/master/consigneepartner/deleteKeyDetail',$scope.servicePartnerTable).success(function(data) {
		        	if(data.success){
		        		for(var i=$scope.lineBank.length-1;i>=0;i--){
		    				if($scope.lineBank[i].select==true){
		    					$scope.lineBank.splice(i, 1);
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
	
		$scope.$watch('lineMaster.cityId', function(newValue,oldValue) {
			if (newValue != '' && newValue != undefined) {
				$http.post($stateParams.tenantid + '/app/master/line/dropDownList',newValue).success(function(datas) {
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
					  
				  
$scope.$watch('lineMaster.tenantId', function(newValue,
	oldValue) {
if (newValue != '' && newValue != undefined) {
	$http.post(
			$stateParams.tenantid
					+ '/app/master/line/tenantList',
			newValue).success(function(datas) {
		console.log(datas);
		$scope.templateList = datas.templateList;
	});
}
});

			if ($location.search().lineId != 0
					&& $location.search().lineId != undefined) {
				$scope.lineMaster.isEdit = true;
				$scope.isEdit=true;
				$scope.lineMaster.lineId = $location.search().lineId;
				$scope.isEdit = true;
				$http.post(
						$stateParams.tenantid
								+ "/app/master/line/view",
						$scope.lineMaster.lineId).success(
						function(response) {
							console.log(response);
							if (response.success == true) {
								$scope.lineMaster = response.line;
								$scope.lineBank = response.lineBank;
								$scope.lineMaster.currencyName=response.line.currencyName.toString();
								$scope.lineMaster.companyId=response.line.companyId.toString();
								$scope.lineMaster.logoPath=response.line.logoPath.toString();
								$scope.lineMaster.uom=response.line.uom.toString();
								$scope.lineMaster.cityId=response.line.cityId.toString();
								if(response.line.countryId!=null){
									$scope.lineMaster.countryId=response.line.countryId.toString();
								}
								if(response.line.gstnCode!=null){
								$scope.lineMaster.gstnCode=response.line.gstnCode.toString();
								}
								


							}
						});
			}

			$scope.reset = function() {

				if ($scope.lineMaster.isEdit == false) {
					
					
					$http.post($stateParams.tenantid+ "/app/master/line/view",$location.search().lineId).success(
							function(response) {
								console.log(response);
								if (response.success == true) {
									$scope.lineMaster = response.line;
									$scope.lineBank = response.lineBank;
									$scope.lineMaster.currencyId=response.line.currencyId.toString();
									$scope.lineMaster.logoPath=response.line.logoPath.toString();
									$scope.lineMaster.uom=response.line.uom.toString();
									$scope.lineMaster.gstnCode=response.line.gstnCode.toString();
								}
								
							});
					
					
				} else {
					$scope.lineBank = [];
					$scope.tempLineBank={
					         lineId:'',
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
						   
						  var tmp=angular.copy($scope.tempLineBank);
							$scope.lineBank.push(tmp);

					  }
					
					$scope.addCredRow();
					$scope.lineMaster = {									
						lineId : '',
						lineCode : '',
						lineName : '',
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
						isEdit : '',
							blCode : '',
							payableac : '',
							receivableac : '',
							profile :'',
							blclause : ''
					}
					
				}
			}


			$scope.cancel = function() {
				$state.go("app.master.general.line.linelist", {
					tenantid : $stateParams.tenantid
				});
			}
		});