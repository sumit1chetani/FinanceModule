'use strict';


app.controller('containerMovementuploadListCtrl',
				function($scope, $state, $stateParams, $http, $location,
						ngDialog, logger, utilsService, sharedProperties,
						toaster, $rootScope, validationService) {
	
	$scope.rowCollection = [];
	$scope.rowCollection1 = [];
	$scope.displayedCollection = [];
    $scope.containerStatusBank=[];
    
		$scope.containerMovementMaster = {
				emccodecurrName : '',
				portcurrName : '',
				emccodenextName : '',
				portnextName : '',
				statusDate : '',
				vesselcurr:'',
				voyagecurr:'',
				shippercurr:'',
				consigneecurr:'',
				polcurr:'',
				podcurr:'',	
				customer:'',
				vesselNext:'',
				voyageNext:'',
				shipperNext:'',
				consigneeNext:'',
				polNext:'',
				podNext:'',	
				customerNext:'',
				movement:'',
				location:'',
				cronumber:'',
				currentmoveDtlBean : [],
				nextmoveDtlBean : []
				
		}
		
		$scope.dep=false;
		$scope.cust=false;
		$scope.ship=false;
		$scope.consig=false;
		$scope.ves=false;
		$scope.voy=false;
		$scope.pL=false;
		$scope.pD=false;
		$scope.depN=false;
		$scope.custN=false;
		$scope.shipN=false;
		$scope.consigN=false;
		$scope.vesN=false;
		$scope.voyN=false;
		$scope.pLN=false;
		$scope.pDN=false;
		
		
		
		
		$scope.cmscodeList = [];
		$scope.cmscodeNextList = [];

		$scope.depotList = [];
		$scope.agentList= [];
		$scope.customerList= [];		
		$scope.vesselList= [];
		$scope.voyageList= [];

		// UPLOAD
		debugger
	
		$scope.closeUpload = function() {
			ngDialog.close();
		}
		

		
		$scope.uploadContainerExcel = function(element) {
			debugger
			console.log("excel file");
			$scope.excelfile = element.files[0];
			console.log($scope.excelfile);

		}
		$scope.uploadContainer = function() {
			// loader.start();
			var excelfile = $scope.excelfile;
			var fileExtension = excelfile.name;
			var fName = [];
			fName = fileExtension.split(".");
			for (var i = 0; i < fName.length; i++) {
				if (fName[i] == "xls" || fName[i] == "xlsx") {
					var frmData = new FormData();
					frmData.append("file", excelfile);
					$
							.ajax({
								type : "POST",
								url : $stateParams.tenantid+'/api/containerMovement/uploadEmployeeExcel',
								data : frmData,
								contentType : false,
								processData : false,
								success : function(response) {
									// loader.complete();
			                            if (response.success==true) {
			                            	// $scope.containerMovementMaster.nextmoveDtlBean.push(response.membersList);
			                            	 
			                            	// $scope.containerMovementMaster.nextmoveDtlBean.length();
				                            	/*var length1 =response.membersList.length;
				                            	var finall=length1+$scope.containerMovementMaster.nextmoveDtlBean.length;

			                            	        var length =($scope.containerMovementMaster.nextmoveDtlBean.length)-1;
			                            	        for( var i=length;i<= finall;i++);
			                            	        {
						                            	 $scope.containerMovementMaster.nextmoveDtlBean.push(response.membersList);

			                            	        }*/
			                            	for(var j=0;j<response.membersList.length;j++){
			                            		$scope.containerMovementMaster.nextmoveDtlBean.push(response.membersList[j])
			                            	}
			                            	        
			                            	$scope.rowCollection1=$scope.containerMovementMaster.nextmoveDtlBean;
			                            	            
			                            	        

			                                logger.logSuccess("Container data's Uploaded Successfully");
			                                $scope.closeUpload();
			                              
			                            }else if(response.success==false)
			                            	{
			                            	
			                            	// $scope.containerMovementMaster.nextmoveDtlBean.push(response.membersList);

			                            	logger.logError("Container already used");
			                            	
			                            	for (var i = 0; i < response.errorList.length; i++) {
			                                    logger.logError(response.errorList[i]);
			                                    $scope.closeUpload();
			                                }
			                            	}
			                            else if (response.errorList.length > 0) {
			                                

			                            } else {
			                                logger.logError("Sorry Error Occured");
			                                $scope.closeUpload();
			                                $scope.getMemberList();
			                            }
			                        }
							});
				}
			}
		}
		$scope.fileUpload =function(){
			 ngDialog.open({
	                template : 'fileGenModal',
	                scope :$scope
	            });
			}

		$scope.downloadFile = function() {
			$("#sampleDownload").bind('click', function() {
			});
			$('#sampleDownload').simulateClick('click');
		}

		$.fn.simulateClick = function() {
			return this.each(function() {
				if ('createEvent' in document) {
					var doc = this.ownerDocument, evt = doc
							.createEvent('MouseEvents');
					evt.initMouseEvent('click', true, true,
							doc.defaultView, 1, 0, 0, 0, 0, false,
							false, false, false, 0, null);
					this.dispatchEvent(evt);
				} else {
					this.click();
				}
			});
			
			
		}
		
		

	  
	  $http.get($stateParams.tenantid+'/api/containerMovement/cmscodelist').success(function(datas) {
	        $scope.cmscodeList = datas;
	     });
	  
	  $http.get($stateParams.tenantid+'/api/containerMovement/depotlist').success(function(data) {
    		$scope.depotList=data;
    });
	  
	  $http.get($stateParams.tenantid+'/api/containerMovement/customerList').success(function(data) {
  		$scope.customerList=data;
  });
	  
	  $http.get($stateParams.tenantid+'/api/containerMovement/vesselList').success(function(data) {
	  		$scope.vesselList=data;
	  });
	  
	  $http.get($stateParams.tenantid+'/api/containerMovement/agentlist').success(function(data) {
    		$scope.agentList=data;
    		        		
    });
	  					  
		
	  $scope.showcurrentMove = function(){
	        debugger;
	        $scope.rowCollection = [];
	        $scope.rowCollection1 = [];
	         if($scope.containerMovementMaster.emccodecurrName !=''){
	            $http.post($stateParams.tenantid+'/api/containerMovement/viewcurrentMove',$scope.containerMovementMaster).success(function(data) {
	                if(data.success){
	                    debugger;
	                    $scope.rowCollection = $scope.rowCollection.concat(data.currentmoveDtlBean);
	                    console.log($scope.rowCollection);
	                }else{
	                    
	                }
	                
	            }).error(function(data) {
	                logger.logError("Error Please Try Again");
	            });
	        
	        }else{
	            logger.logError("Please select CmsCode");
	        }
	    };
	

	    $scope.selectall= function(selection){
	      	angular.forEach($scope.rowCollection,function(value,key) {
	      		debugger;
	      		if( selection)
	      		value.select=true;
	      		else{
	      			value.select=false;
	      		}
	      		});
	      }
	    
	    $scope.selectall1= function(selection){
	      	angular.forEach($scope.rowCollection1,function(value,key) {
	      		debugger;
	      		if( selection)
	      		value.select=true;
	      		else{
	      			value.select=false;
	      		}
	      		});
	      }
	    
	    $scope.viewcurrMove = function(){
	        debugger;
	        
	        if ($scope.rowCollection.length > 0) {
	        	
	        	$scope.selectedrow=[];
	        	$scope.unselectedrow=[];
	            angular.forEach($scope.rowCollection, function(row, index) {
	                var check =row.select;
	                if (check ==true) {
	                    delete row['select'];
	                    $scope.selectedrow.push(row);
	                    $scope.containerMovementMaster.nextmoveDtlBean = $scope.selectedrow;
	                    console.log($scope.selectedrow);
	                } else {
	                	$scope.unselectedrow.push(row);
	                    $scope.containerMovementMaster.currentmoveDtlBean = $scope.unselectedrow;
	                }
	            });
	            
	        } else {
	        	logger.logError("Please select atleast one row");
	        }
	                    
	        $scope.rowCollection1 = $scope.selectedrow;
	        $scope.rowCollection =  $scope.containerMovementMaster.currentmoveDtlBean;
	         //$scope.rowCollection = [];
	         console.log($scope.rowCollection1);
	                
	    };
					
					
					
					//save
					$scope.saveData = function(containerMovementForm, containerMovementMaster) {
						
					/*	if($scope.containerMovementMaster.emccodenextName !=''){
							if($scope.containerMovementMaster.statusDate !=''){
							*/
									sharedProperties.clearObject();
						
								$http.post($stateParams.tenantid+'/api/containerMovement/save', $scope.containerMovementMaster).success(function(data) {
									if (data.success == true) {
									logger.logSuccess("Saved Succesfully!");
									$state.go("app.eqs.containerMovement.containerMovementList",{tenantid : $stateParams.tenantid});

						} else {
							logger.logError(data.message);
						}
					  });
						/*	} else {
								logger.logError("Please select Status Date");
							}	
						} else {
							logger.logError("Please select CmsCode");
						}*/
						
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
													$state.go("app.eqs.containerMovement.containerMovementList",{tenantid : $stateParams.tenantid});
												} else {
													logger.logError("Error in Update");
												}
											});
						} else {
							toaster.pop('error',"Please fill the required fields",logger.getErrorHtmlNew(containerStatusMasterForm.$validationSummary),5000, 'trustedHtml');
						}
					};

					
					
				/*	$scope.cancel = function() {
						$state.go("app.eqs.containerMovement.containerMovementList", {
							tenantid : $stateParams.tenantid
						});
					}*/
					
					
//watch function 
					
					$scope.$watch('containerMovementMaster.emccodecurrName',
							function(newValue, oldValue) {

								if (newValue != ''&& newValue != undefined) {

									$http.get($stateParams.tenantid+ '/api/containerMovement/cmsCode?emccodecurrName='
															+ $scope.containerMovementMaster.emccodecurrName)
											.success(
													function(datas) {
														console.log(datas);
														$scope.dep=datas.dep;
														$scope.cust=datas.cust;
														$scope.ship=datas.ship;
														$scope.consig=datas.consig;
														$scope.ves=datas.ves;
														$scope.voy=datas.voy;
														$scope.pL=datas.pL;
														$scope.pD=datas.pD;
														$scope.cmscodeNextList=datas.list1;
														
														
														
													})
											.error(
													function(data) {
														logger.logError("Unable to fetch");
													});
									
									
						
						

								}
							});


//					$scope.$watch('containerMovementMaster.emccodecurrName',
//							function(newValue, oldValue) {
//
//					if (newValue != ''&& newValue != undefined) {
//
//						
//						$http.get($stateParams.tenantid+ '/api/containerMovement/cmsCodeNxt?emccodecurrName='
//								+ $scope.containerMovementMaster.emccodecurrName)
//				.success(
//						function(datas1) {
//							console.log(datas1);
//							 $scope.cmscodeNextList = datas1;
//							
//							
//							
//						})
//				.error(
//						function(data) {
//							logger.logError("Unable to fetch");
//						});
//
//					}
//					});
					
					
	//cms next				
					$scope.$watch('containerMovementMaster.emccodenextName',
							function(newValue, oldValue) {

								if (newValue != ''&& newValue != undefined) {

									$http.get($stateParams.tenantid+ '/api/containerMovement/cmsCodeNext?emccodenextName='
															+ $scope.containerMovementMaster.emccodenextName)
											.success(
													function(datas) {
														console.log(datas);
														$scope.depN=datas.dep;
														$scope.custN=datas.cust;
														$scope.shipN=datas.ship;
														$scope.consigN=datas.consig;
														$scope.vesN=datas.ves;
														$scope.voyN=datas.voy;
														$scope.pLN=datas.pL;
														$scope.pDN=datas.pD;
														
														
													})
											.error(
													function(data) {
														logger.logError("Unable to fetch");
													});

								}
							});
			//vessel based voyage		
					 $scope.$watch('containerMovementMaster.vessel', function(newValue, oldValue) {
					      if(newValue!=null && newValue!=undefined && newValue != ''){
					    	  $http.post($stateParams.tenantid+ '/app/commonUtility/getVoyageListByVessel',newValue).success(function(data) {
									$scope.voyageList = data;
					    	  });
					      }
					    });
					
					
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

