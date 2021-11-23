app.controller('containerOnHireAddCtrl',function($scope,  $http, $location, logger,ngDialog, utilsService, $state, sharedProperties,
						$window, $stateParams, toaster, validationService,$controller) {

					$scope.containerDtl = [];
					$scope.portList = [];
					$scope.isEdit = false;
 					
					$scope.containerOnHire = {
						releaseRefNo : '',
						onHireRefNo : '',
						noOfContainer : '',
						isdomestic : '',
						fileupload : '',
						agreementParty : '',
						leaseType : '',
						agent : '',
						port : '',
						date : '',
						dayDiff:0,
						simaDate: '',
						checkRefer:false,
						containerDtl : []

					}
					
					$scope.tempContainerDtl = {
						containerType : "",
						containerNo : "",
						yearOfManuf:"",
						payload : "",
						tareWeight:'',
						grossWeight:'',
						machine:'',
						model:'',
						actualPickupDate : "",
						mtdDate : null,
						select : false
					}
					
					
					var today = new Date();
					var dd = today.getDate();
					var mm = today.getMonth() + 1; // January is 0!
					var yyyy = today.getFullYear();
					var HH = today.getHours();
					var MM = today.getMinutes();
					if (dd < 10) {
						dd = '0' + dd
					}
					if (mm < 10) {
						mm = '0' + mm
					}
					if (HH < 10) {
						HH = '0' + HH
					}
					if (MM < 10) {
						MM = '0' + MM
					}

					/*$scope.containerOnHire.date = dd + '/' + mm + '/'+ yyyy+ ' ' + HH+':'+ MM;
					
					 $('#date').datetimepicker({
						 format : 'DD/MM/YYYY HH:mm'
						 })*/
				
					$scope.addCredRow = function() {
						debugger;
						if($scope.containerOnHire.containerDtl.length <  parseInt($scope.containerOnHire.noOfContainer)   ){
						var tmp = angular.copy($scope.tempContainerDtl);
						$scope.containerOnHire.containerDtl.push(tmp);
						
						//var dd = $scope.containerOnHire.noOfContainer - $scope.containerOnHire.containerDtl.length;
						$scope.containerOnHire.noOfContainerAdded =  $scope.containerOnHire.containerDtl.length;
						}else{
							logger.logError('Container Count Matched. Row Cannot Be Added..!! ');
						}
					}
					
					$scope.addCredRow1 = function() {
					}
				 

					$scope.removeCredRow = function() {
						var count =0;
						ngDialog.openConfirm().then(function() {
											var tmpDelList = [];
											for (var i = $scope.containerOnHire.containerDtl.length - 1; i >= 0; i--) {
												if ($scope.containerOnHire.containerDtl[i].select == true) {
													count++;
													tmpDelList.push($scope.containerOnHire.containerDtl[i]);
													$scope.containerOnHire.containerDtl.splice(i, 1);
													$scope.containerOnHire.noOfContainerAdded =$scope.containerOnHire.containerDtl.length;
												}
											}
											if(count>0){
												//logger.logSuccess('Deleted Successfully');	
											}else{
												logger.logError('Please select the row to delete!');
											}
										})
					}

					
					$scope.selectall= function(selection){
				      	angular.forEach($scope.containerOnHire.containerDtl,function(value,key) {
				      		debugger;
				      		if( selection)
				      		value.select=true;
				      		else{
				      			value.select=false;
				      		}
				  });
				      }
					
					
					$scope.$watch('containerOnHire.releaseRefNo',
									function(newValue, oldValue) {
		//				if($scope.isEdit != true){
										if (newValue != ''&& newValue != undefined) {

											$http.get($stateParams.tenantid+ '/api/containerOnHire/releaseRefNolist?releaseRefNo='
																	+ $scope.containerOnHire.releaseRefNo)
													.success(
															function(datas) {
																$scope.releaseRefNolist = datas.containerOnHireBean;
																$scope.containerOnHire.agreementParty = datas.containerOnHireBean.agreementParty;
																$scope.containerOnHire.leaseType = datas.containerOnHireBean.leaseType;
																//$scope.portList = datas.portList;
																$scope.containerOnHire.noOfContainer = datas.containerOnHireBean.noOfContainer;
																$scope.containerOnHire.dayDiff = datas.containerOnHireBean.dayDiff;
																$scope.containerOnHire.noOfContainerAdded = datas.containerOnHireBean.noOfContainerAdded;
															})
													.error(
															function(data) {
																logger.logError("Unable to fetch");
															});

										}
						//}
									});
					$http.get($stateParams.tenantid+'/app/seaquotation/getiataList').success(function(datas) {
						debugger
					    $scope.portList = datas.commonUtilityBean;	    

					}).error(function(data) {

					});
					
					
				
					$scope.$watch('containerOnHire.port', function(newValue, oldValue) {
								if (newValue != ''&& newValue != undefined) {
									if($scope.isEdit != true){
									var ob = {
											releaseRefNo : $scope.containerOnHire.releaseRefNo,
											port	:$scope.containerOnHire.port
									}
									$http.post($stateParams.tenantid+'/api/containerOnHire/getreleaseRefNolistbyPort',ob).success(function(datas) {
											$scope.containerOnHire.noOfContainer = datas.containerOnHireBean.noOfContainer;
											$scope.containerOnHire.releaseRefNo = datas.containerOnHireBean.releaseRefNo;
 										}).error(
										function(data) {
											logger.logError("Unable to fetch");
										});
									}
								}
							});
					
					
					$scope.$watch('containerOnHire.port', function(newValue, oldValue) {
						if (newValue != ''&& newValue != undefined) { 
							$http.get($stateParams.tenantid+ '/app/commonUtility/getDepotByPort?portCode='+newValue).success(function(datas) {
			    				$scope.depotList = datas;
			    				
									}).error(
								function(data) {
									logger.logError("Unable to fetch");
								});
							 
						}
					});
				

					$http.get($stateParams.tenantid+ '/api/containerOnHire/getOnHireRefNo').success(function(data) {
						console.log(data);
					$scope.containerOnHire.onHireRefNo = data.onHireRefNo;
				});

					
					$scope.checkundefined = function(value) {
					    var invalid = false;
					    if (value == undefined || value == 'undefined' || value == null || value == 'null' || value == '') {
					        invalid = true;
					    }
					    return invalid;

					}

					$scope.changecolor = function(id) {
						$('#' + id + ' .selectivityId').find('input').css(
								"border-color", "red");
					}

					$scope.changecolor = function(id) {
						$('#' + id + ' .selectivityId').find('input').css(
								"border-color", "red");

					}
					$scope.clearcolor = function(id) {
						$('#' + id + ' .selectivityId').find('input').css(
								"border-color", "#e8dddd");

					}

					
					$scope.checkValidation = function() {

					    var alertmsg = "<ui><h4 backgroundcolor=green>Please fill the required fields</h4>";
					    var msg = "";
					    if ($scope.checkundefined($scope.containerOnHire.releaseRefNo)) {
					        msg = msg + "<li>release Ref No :Field is required.</li>";         
					        $scope.changecolor('releaseRefNo');
					    }else{
					    	$scope.clearcolor('releaseRefNo');
					    }
					    
					    
					    if ($scope.checkundefined($scope.containerOnHire.onHireRefNo)) {
					        msg = msg + "<li>onHire Ref No :Field is required.</li>";         
					        $scope.changecolor('onHireRefNo');
					    }else{
					    	$scope.clearcolor('onHireRefNo');
					    }
					    if ($scope.checkundefined($scope.containerOnHire.noOfContainer)) {
					        msg = msg + "<li>no Of Container :Field is required.</li>";         
					        $scope.changecolor('noOfContainer');
					    }else{
					    	$scope.clearcolor('noOfContainer');
					    }
					    if ($scope.checkundefined($scope.containerOnHire.agreementParty)) {
					        msg = msg + "<li>agreement Party :Field is required.</li>";         
					        $scope.changecolor('agreementParty');
					    }else{
					    	$scope.clearcolor('agreementParty');
					    }
					    if ($scope.checkundefined($scope.containerOnHire.leaseType)) {
					        msg = msg + "<li>lease Type :Field is required.</li>";         
					        $scope.changecolor('leaseType');
					    }else{
					    	$scope.clearcolor('leaseType');
					    }
					    if ($scope.checkundefined($scope.containerOnHire.port)) {
					        msg = msg + "<li>port : Field is required.</li>";         
					        $scope.changecolor('port');
					    }else{
					    	$scope.clearcolor('port');
					    }
					    if ($scope.checkundefined($scope.containerOnHire.date)) {
					        msg = msg + "<li>date : Field is required.</li>";         
					        $scope.changecolor('date');
					    }else{
					    	$scope.clearcolor('date');
					    }
					    
					  	    
					  	    angular.forEach($scope.containerOnHire.containerDtl, function(chargesDetail, index) {     
 
					        if ($scope.checkundefined(chargesDetail.containerType)) {
					            msg = msg + "<li>Row :" + (index + 1) + "# container Type :Field is required.</li>";
					            $scope.changecolor('unit'+index);
					        }else{
					        	$scope.clearcolor('unit'+index);
					        }
					        
					        if ($scope.checkundefined(chargesDetail.containerNo)) {
					            msg = msg + "<li>Row :" + (index + 1) + "# container No :Field is required.</li>";
					            $scope.changecolor('unit'+index);
					        }else{
					        	$scope.clearcolor('unit'+index);
					        }
					        
					      /*  if ($scope.checkundefined(chargesDetail.yearOfManuf)) {
					            msg = msg + "<li>Row :" + (index + 1) + "# Year Of Manuf. :Field is required.</li>";
					            $scope.changecolor('unit'+index);
					        }else{
					        	$scope.clearcolor('unit'+index);
					        }*/
					        
					        if ($scope.checkundefined(chargesDetail.payload)) {
					            msg = msg + "<li>Row :" + (index + 1) + "# Payload :Field is required.</li>";
					            $scope.changecolor('unit'+index);
					        }else{
					        	$scope.clearcolor('unit'+index);
					        }
					        
					       /* if ($scope.checkundefined(chargesDetail.tareWeight)) {
					            msg = msg + "<li>Row :" + (index + 1) + "# Tare Weight :Field is required.</li>";
					            $scope.changecolor('unit'+index);
					        }else{
					        	$scope.clearcolor('unit'+index);
					        }
					        if ($scope.checkundefined(chargesDetail.grossWeight)) {
					            msg = msg + "<li>Row :" + (index + 1) + "# Gross Weight :Field is required.</li>";
					            $scope.changecolor('unit'+index);
					        }else{
					        	$scope.clearcolor('unit'+index);
					        }
					        
					        if(chargesDetail.containerType.includes("R")){
					        						        
					        if ($scope.checkundefined(chargesDetail.machine)) {
					            msg = msg + "<li>Row :" + (index + 1) + "# Machine :Field is required.</li>";
					            $scope.changecolor('unit'+index);
					        }else{
					        	$scope.clearcolor('unit'+index);
					        }
					        if ($scope.checkundefined(chargesDetail.model)) {
					            msg = msg + "<li>Row :" + (index + 1) + "# Model :Field is required.</li>";
					            $scope.changecolor('unit'+index);
					        }else{
					        	$scope.clearcolor('unit'+index);
					        }
					        
					        }*/
					        /*if ($scope.checkundefined(chargesDetail.actualPickupDate)) {
					            msg = msg + "<li>Row :" + (index + 1) + "# actual Pickup Date :Field is required.</li>";
					            $scope.changecolor('unit'+index);
					        }else{
					        	$scope.clearcolor('unit'+index);
					        }
					        
					        if ($scope.checkundefined(chargesDetail.mtdDate)) {
					            msg = msg + "<li>Row :" + (index + 1) + "# Actual Return Date :Field is required.</li>";
					            $scope.changecolor('unit'+index);
					        }else{
					        	$scope.clearcolor('unit'+index);
					        }*/
					        
					       
					        
					    });
					    alertmsg = alertmsg + msg + "</ui>";
					    if ($scope.checkundefined(msg)) {
					        return '';
					    } else {
					        return alertmsg;
					    }

					}
					
					$scope.save = function(containerOnHireForm,containerOnHire) {
						//if (new validationService().checkFormValidity($scope.containerOnHireForm)) {
						var msg=$scope.checkValidation();
						if(!$scope.checkundefined(msg)){   
							logger.logError(msg);
						}else{
						if($scope.containerOnHire.mtdDate == null ){
						$scope.containerOnHire.mtdDate=null;
						}
						$http.post($stateParams.tenantid+'/api/containerOnHire/save',containerOnHire).success(function(data) {
						console.log("data" + data);
						if (data.isSuccess) {
							logger.logSuccess("Saved Successfully!");
							$state.go('app.eqc.containerOnHire.list');
						} else {
							if(data.text=='false'){
				      	      	   logger.logError("Container Number is already exist");
			               }else{
							if(data.message!=undefined && data.message!=null){
								logger.logError(data.message);
							}else{
								logger.logError(data.message);		
							}
			               }
						
						}
						}).error(function(result) {
						console.log("data" + data);
						});
						}
						/*} else {
						toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.containerOnHireForm.$validationSummary), 555000, 'trustedHtml');
						}};*/
					}
						
						var rNo = $location.search().rNo;
						if (rNo == undefined) {

						} else {
							$scope.containerOnHire.releaseRefNo=	rNo;
						}

					// Fetch Values
					$scope.isEdit = false;
					var onHireRefNo = $location.search().onHireRefNo;
					if (onHireRefNo == undefined) {

					} else {
						$http.get($stateParams.tenantid+ '/api/containerOnHire/edit?onHireRefNo='+ onHireRefNo).success(function(result) {

											$scope.isEdit = true;
											$scope.containerOnHire.releaseRefNo=result.releaseRefNo;
											$scope.containerOnHire = result;
											$scope.containerOnHire.noOfContainerAdded= $scope.containerOnHire.containerDtl.length;
											if($scope.containerOnHire){
												
											}
											if (result.isEdit == false) {
												logger
														.logError("Please Try Again");
											} else {

											}
										}).error(function(data) {
									console.log("data" + data);
								});
					}

					$scope.update = function(containerOnHireForm,
							containerOnHire) {
						if (new validationService()
								.checkFormValidity($scope.containerOnHireForm)) {
							$scope.containerOnHire.onHireRefNo = $location
									.search().onHireRefNo;

							$http
									.post(
											$stateParams.tenantid
													+ '/api/containerOnHire/update',
											$scope.containerOnHire)
									.success(
											function(result) {
												if (result.isSuccess) {
													logger.logSuccess("Updated Successfully!");
													$state.go('app.eqc.containerOnHire.list',{tenantid : $stateParams.tenantid});
												} else {
													logger.logError(result.message);
												}
											}).error(function(data) {
										console.log("data" + data);
									});

						} else {
							toaster.pop('error',"Please fill the required fields",logger.getErrorHtmlNew($scope.containerOnHireForm.$validationSummary),555000, 'trustedHtml');
						}
					};
					// Dropdown for Selectivity
					$http.post($stateParams.tenantid+ '/api/containerOnHire/dropDownList').success(function(data) {

										$scope.releaseRefNo = data.listReleaseReNoList;
										$scope.containerType = data.listContainerTypeList;
										$scope.port = data.listPortList;

									});

					$scope.cancel = function() {
						$state.go('app.eqc.containerOnHire.list', {
							tenantid : $stateParams.tenantid
						});
					};

					// reset
					$scope.reset = function(containerOnHire) {
						if (onHireRefNo == undefined) {

							$http.get($stateParams.tenantid+ '/api/containerOnHire/getOnHireRefNo').success(function(data) {
								console.log(data);
							$scope.containerOnHire.onHireRefNo = data.onHireRefNo;
						});
							$scope.containerOnHire = {
								releaseRefNo : '',
								noOfContainer : '',
								isdomestic : '',
								fileupload : '',
								agreementParty : '',
								leaseType : '',
								agent : '',
								port : '',
								date : '',
								simaDate : '',
								containerDtl : []

							}
						} else {
							$http.get($stateParams.tenantid+ '/api/containerOnHire/edit?onHireRefNo='+ onHireRefNo).success(function(result) {

												if (result.isEdit == false) {
													logger.logError("Please Try Again");
												} else {
													$scope.isEdit = true;
													$scope.containerOnHire = result;
											
												}
											}).error(function(data) {
										console.log("data" + data);
									});
						}
					}

					// upload
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
											url : $stateParams.tenantid+'/api/containerOnHire/uploadfile',
											data : frmData,
											contentType : false,
											processData : false,
											success : function(response) {
												// loader.complete();
												if (response.success == true) {
													for(var i=0; i < response.containerDtl.length;i++){
														$scope.containerOnHire.containerDtl.push(response.containerDtl[i]);
													}
													$('#buttontemp').simulateClick('click');
 												//	$scope.containerOnHire.containerDtl=angular.copy(response.containerDtl);
													if(response.containerDtl.length > 0 ){
	 													//logger.logSuccess("Container Details Uploaded Successfully!");
													}else{
														logger.logError("Sorry Error Occured in Upload");
													}
													$scope.closeUpload();
												} else if (response.success == false) {

													for (var i = 0; i < response.errorList.length; i++) {
														logger
																.logError(response.errorList[i]);
														$scope.closeUpload();
														
													}
												} else if (response.errorList.length > 0) {

												} else {
													logger
															.logError("Sorry Error Occured");
													$scope.closeUpload();
													$scope.getMemberList();
												}
											}
										});
							}
						}
					}
					$scope.downloadFile=function(){
					    $("#sampleDownload").bind('click', function() {
					    });
					    $('#sampleDownload').simulateClick('click');
					}
					$.fn.simulateClick = function() {
					    return this.each(function() {
					        if ('createEvent' in document) {
					            var doc = this.ownerDocument, evt = doc.createEvent('MouseEvents');
					            evt.initMouseEvent('click', true, true, doc.defaultView, 1, 0, 0, 0, 0, false, false, false, false, 0, null);
					            this.dispatchEvent(evt);
					        } else {
					            this.click(); // IE
					        }
					    });
					}/*
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
						
						
					}*/
					
					 $scope.genCancel=function(){
				            ngDialog.close();
				        }
					 
					$scope.fileUpload =function(){
						 ngDialog.open({
				                template : 'fileGenModal',
				                scope :$scope
				            });
						} 

					
				});


 

app.controller('onHiretableCtrl', function($scope, $http, $filter, logger,
		$stateParams) {
	
	
	/*$scope.$watchCollection('[containerOnHire.containerDtl[trIndex].actualPickupDate,containerOnHire.containerDtl[trIndex].mtdDate]', function(newValue, oldValue) {
	// alert($scope.containerOnHire.dayDiff);
		if($scope.containerOnHire.dayDiff!=null && $scope.containerOnHire.dayDiff!=undefined){
		debugger;
		//alert($scope.isEdit);
		if($scope.containerOnHire.containerDtl[$scope.$index].actualPickupDate != null && $scope.containerOnHire.containerDtl[$scope.$index].actualPickupDate != '' ){
			 noOfDays = moment($scope.containerOnHire.containerDtl[$scope.$index].mtdDate, 'DD/MM/YYYY').diff(moment($scope.containerOnHire.containerDtl[$scope.$index].actualPickupDate, 'DD/MM/YYYY'), 'days');
			 if(noOfDays<0){
				 logger.logError("'MTD Date' should be greater than 'Actual Pickup Date'!");
				 $scope.containerOnHire.containerDtl[$scope.$index].mtdDate = "";
			 
		 }else{
			 $scope.containerOnHire.containerDtl[$scope.$index].mtdDate =  moment($scope.containerOnHire.containerDtl[$scope.$index].actualPickupDate , 'DD/MM/YYYY HH:mm').add('days', $scope.containerOnHire.dayDiff).format('DD/MM/YYYY HH:mm');
		 }
		}
		}
		
	});*/
	
//}
	$scope.$watchCollection('[containerOnHire.containerDtl[trIndex].containerType]', function(newValue, oldValue) {
		if(newValue != '' && newValue != null && newValue != undefined){
			if($scope.containerOnHire.containerDtl[$scope.$index].containerType.includes("R")  ){
				$scope.containerOnHire.checkRefer = true;
				
			}else{
				if( $scope.containerOnHire.checkRefer != true){
					$scope.containerOnHire.checkRefer = false;

				}
			}
		}
		
	});
	
	//Unique container No. Validation
	$scope.$watchCollection('[containerOnHire.containerDtl[trIndex].containerNo]', function(newValue, oldValue) {
		for(var i=0; i<newValue.length ;i++)	{
		if(newValue[i].length== 11){
			if($scope.isEdit != true){
			if($scope.containerOnHire.containerDtl[$scope.$index].containerNo != null ){
				var containerNo = $scope.containerOnHire.containerDtl[$scope.$index].containerNo;
				/*$http.post($stateParams.tenantid+ '/api/containerOnHire/containerNumber?containerno='+containerNo).success(function(datas) {
								if(datas.isSuccess == true){
									logger.logError("Container No. is already Exist");
									$scope.containerOnHire.containerDtl[$scope.$index].containerNo =''
								}else if(datas.checkDigit == false){
									logger.logError(datas.message);
									$scope.containerOnHire.containerDtl[$scope.$index].containerNo =''
								}else{
									
								}
								})
						.error(
								function(data) {
									logger.logError("Unable to fetch");
								});*/

			
			}}
			}
			}
		});

	
	$scope.validateContainer = function(val,index) {
		var isnum;
		var index1 = parseInt(index)+1;
		if(val.trim() !="" && val!=undefined){

		if (val.length == 11) {

		//var letters = /^[0-9a-zA-Z]+$/;
		if (/^[a-zA-Z0-9]*$/.test(val)) {
		var res = val.substring(0, 4).toUpperCase();
		var res1 = val.substring(4, 11);

		if (/^[a-zA-Z0-9]*$/.test(val)) {
		if(isNaN(res1)){
		logger.logError("Container Number Should Contain 4 Letters and 7 Number in Row " +index+1);
		 $scope.containerOnHire.containerDtl[$scope.$index].containerNo = ""
		} else {

		}
		} else {
		logger.logError("Container Number Should Contain 4 Letters and 7 Number in Row"+index+1);
		 $scope.containerOnHire.containerDtl[$scope.$index].containerNo = ""

		}
		} else {
		logger.logError("Container Number Should Contain 4 Letters and 7 Number in Row" +index+1);
		 $scope.containerOnHire.containerDtl[$scope.$index].containerNo = ""

		}

		} else {
		logger.logError("Invalid Container Number in Row"+index+1);
		 $scope.containerOnHire.containerDtl[$scope.$index].containerNo = ""

		} 

		}
		}
	
/*	$scope.$watchCollection('[containerOnHire.containerDtl[trIndex].actualPickupDate,containerOnHire.date]', function(newValue, oldValue) {
		//	alert($scope.containerOnHire.dayDiff);
			if($scope.containerOnHire.containerDtl[$scope.$index].actualPickupDate != null && $scope.containerOnHire.containerDtl[$scope.$index].actualPickupDate != '' ){
				 noOfDays = moment($scope.containerOnHire.date, 'DD/MM/YYYY HH:mm').diff(moment($scope.containerOnHire.containerDtl[$scope.$index].actualPickupDate, 'DD/MM/YYYY HH:mm'), 'minutes');
				 if(noOfDays<0){ 
					 logger.logError("'ActualPickup Date and Time should be Greater than OnHireDate'!");
					 $scope.containerOnHire.containerDtl[$scope.$index].actualPickupDate= "";
				 
			 }
			}
		});*/
});

