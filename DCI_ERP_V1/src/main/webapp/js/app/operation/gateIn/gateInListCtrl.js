'use strict';

app.controller('gateInListCtrl', function($scope, $rootScope, $http, $location, logger, utilsService, ngDialog, $state,sharedProperties,$window,$stateParams) {

    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    
    $scope.gateIn = {
			gateInNo : '',
			gateOutNo : '',
			depot : '',
			bookingNo : '',
			customer : '',
			returnDate : '',
			type: 'Export',
			service : 'COC',
			doNo :'',
	
			containerDtl : [],
		   containerDtlsoc: []

		}
    
    $scope.gateOut = {
    		doType : 'export'
		}
    $rootScope.doType='';
	$scope.type = function (value){
		$rootScope.doType = value;
	}
    
    $scope.getList=function(){
        $http.get($stateParams.tenantid+'/api/gateIn/list').success(function(datas) {
            console.log(datas);
            $scope.rowCollection = datas.exportList;
            $scope.rowCollection1 = datas.importList;
        	
            }).error(function(datas) {
        });
        };
        $scope.getList();
        
    $scope.add = function() {
        $state.go('app.operation.gateIn.add',{tenantid:$stateParams.tenantid});
    };
    
    
    $scope.emptyReturn = function() {
        $state.go('app.operation.gateIn.emptyreturn',{tenantid:$stateParams.tenantid});
    };
    
 // Redirecting Page For Edit Functionality
    
    $scope.editRow = function(gateInNo,shipmentStatus) {
    	debugger
    	if(!shipmentStatus){
        $location.url($stateParams.tenantid+'/operation/gateIn/edit?gateInNo='+gateInNo);
    	}else{
    		logger.logError("You can't edit the Record in Shipping Instruction");	
    	}
    };
    
    
    $scope.viewRow = function(gateInNo) {
    	debugger
    
        $location.url($stateParams.tenantid+'/operation/gateIn/view?gateInNo='+gateInNo);
    	
    };
    
    $scope.editCro = function(gNo){
    	$location.url($stateParams.tenantid+'/operation/gateIn/add?gNo='+gNo);
    	}

	//Delete functionality
    $scope.deleteRow = function(gateInNo,shipmentStatus) {
       	if(!shipmentStatus){
        ngDialog.openConfirm().then(function() {
        
            var url = $stateParams.tenantid+'/api/gateIn/delete?gateInNo=' + gateInNo;
            $http.get(url).success(function(result){
            	
                if (result) {
                	
                    logger.logSuccess("Deleted Successfully");
                    $state.reload();
              
                } else {
                	
                    logger.logError("You can't Delete this Record, Related Data Exist! ");
                }
            }).error(function(result) {
            	
                logger.logError("Error Please Try Again");
          
            });
        }, function(reason) {
        	
            console.log('Modal promise rejected. Reason: ', reason);
        });
       	}
       	else{
    		logger.logError("You can't delete the Record in Shipping Instruction");	
    	}
    };

  //Export Excel
	
	
	$scope.excelexport=function(gateInNo){
		
		debugger
		$http.post($stateParams.tenantid+'/api/gateIn/excelexport?gateInNo='+gateInNo).success(function(datas){
			
			debugger;
            $("#gateInExport").bind('click', function() {
            });
            $('#gateInExport').simulateClick('click');
            logger.logSuccess("Exported Successfully!");
       /* }else{
            logger.logError("Failed to export");
        }*/
     }).error(function(result) {
         console.log("data" + result);
		});


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
	  	    }
	}

    
});




'use strict';
app
		.controller(
				'gateoutgateinAddCtrl',
				function($scope, $timeout, $stateParams, sharedProperties,
						toaster, $filter, $rootScope, $http, $location, logger,
						$state, ngDialog, $controller, $injector) {
					$scope.gateoutinTypeList = [];
					$scope.customerDropList = [];
					$scope.consigneeDropList = [];
					$scope.shipmentList = [];
					$scope.nominatedDropList = [];
					$scope.vendorDropList = [];
					$scope.serviceParnrDropList = [];
					$scope.portList = [];
					$scope.gateOutList = [];

					$scope.loadList = [];
					$scope.currencyList = [];
					$scope.createQuote = false;
					$scope.newdepot=true;

					var bookingDate = $stateParams.bookingDate;
					var mloCode = $stateParams.mloCode;
					var lolId = $stateParams.lolId;
					var lodId = $stateParams.lodId;
					var bookingId = parseInt($stateParams.bookingId);
					$scope.edit = false;
					$rootScope.check1 =false;

					$scope.gateoutin = {
						service : '',
						aol : '',
						origin : '',
						customer : '',
						salesPerson : '',
						vendor : '',
						attention : '',
						gateoutinDate : '',
						branch : '',
						aod : '',
						destination : '',
						shipper : '',
						salesType : '',
						carrier : '',
						termConditions : '',
						mode : '1',
						currency : '',
						term : '',
						type : 'Export',
						consignee : '',
						nominatedBy : '',
						validityDate : '',
						remarks : '',
						vessel : '',
						dimensionName : '',
						gateoutinDtl : [ {
							id : 0,
							conType : '',
							conStatus : '',
							depot : '',
							preDepot: '',
							allocDate : '',
							containerNo : '',
							newConStatus : '',
							newContainerDate : '',
							soc:false,
							croNo:'',
							sealNo:'',
							containerDate:''
								
						} ],
						
					    gateoutinDtledit : [ {
							id : 0,
							conType : '',
							conStatus : '',
							depot : '',
							preDepot: '',
							allocDate : '',
							containerNo : '',
							newConStatus : '',
							newContainerDate : '',
							soc:false,
							croNo:'',
							sealNo:'',
							containerDate:''
								
						} ]
						

					}

					var today = new Date();
					var dd = today.getDate();
					var mm = today.getMonth() + 1; // January is 0!
					var yyyy = today.getFullYear();
					if (dd < 10) {
						dd = '0' + dd
					}
					if (mm < 10) {
						mm = '0' + mm
					}

					$scope.gateoutin.releaseDate = dd + '/' + mm + '/' + yyyy;

					var today = new Date();
					var dd = today.getDate();
					var mm = today.getMonth() + 1;

					var yyyy = today.getFullYear();
					if (dd < 10) {
						dd = '0' + dd;
					}
					if (mm < 10) {
						mm = '0' + mm;
					}
					var today = dd + '/' + mm + '/' + yyyy;
					$scope.gateoutin.releaseDate = today;

					$('#containerDate').datetimepicker({
						format : 'DD/MM/YYYY HH:mm'
					})
					
						$('#newContainerDate').datetimepicker({
						format : 'DD/MM/YYYY HH:mm'
					})
					
					
					
					$scope.moveId = $location.search().moveId;

					if ($scope.moveId != ''
							&& $scope.moveId != undefined) {
						$scope.edit = true;
						$http
								.post(
										$stateParams.tenantid
												+ '/app/gateOutin/edit',
										$scope.moveId)
								.success(
										function(datas) {

											// $scope.gateoutin.gateoutinDtl = datas.lQuotationBean;
											$scope.gateoutin.gateoutinDtledit = datas.lQuotationBean;
										

										}).error(function(datas) {

								});

					}

			 
					$scope.getdropdown = function() {

						$http
								.post(
										$stateParams.tenantid
												+ '/app/quotation/getShipment')
								.success(
										function(datas) {
											$scope.customerList = datas.getcustomerlist;
											$scope.conTypeList = datas.getcontypelist;
											$scope.gateOutList = datas.gateOutList;
											$scope.depotList = datas.polList;
										//	$scope.conNoList = datas.getcontainer;

										}).error(function(datas) {

								});
						
						
						$http
						.post(
								$stateParams.tenantid
										+ '/app/gateOutin/getcroNo')
						.success(function(datas) {

							$scope.croList = datas.croList;
							$scope.doList = datas.doList;
							$scope.conStatusList =datas.statusList;

						}).error(function(datas) {

						});

						

						

						$http
								.post(
										$stateParams.tenantid
												+ '/app/gateOutin/getcroNo')
								.success(function(datas) {

									$scope.croList = datas.croList;
									$scope.doList = datas.doList;
									$scope.conStatusList =datas.statusList;
									$scope.conNoList=datas.containerList;

								}).error(function(datas) {

								});

					}

					$scope.getdropdown();

					// fetch container Details

				 

					$scope.selectall = function(selection) {
						angular.forEach($scope.gateoutin.popUpDtl, function(
								value, key) {
							debugger;
							if (selection)
								value.select = true;
							else {
								value.select = false;
							}
						});
					}

					$scope.popupsubmit = function() {

						ngDialog.close();
						$scope.loadList = [];
						angular
								.forEach(
										$scope.gateoutin.popUpDtl,
										function(chargesDetail, index) {

											if (chargesDetail.select == true) {

												// $scope.gateoutin.gateoutinDtl[i].containerNo=chargesDetail.containerNo;
												// $scope.gateoutin.gateoutinDtl[i].conType=chargesDetail.conType;
												var data = {};
												data["containerNo"] = chargesDetail.containerNo;
												data["conType"] = chargesDetail.conType;
												$scope.loadList.push(data);

											}

										});

						$scope.gateoutin.gateoutinDtl = $scope.loadList;

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

					$scope.addRow = function() {

						$scope.max = Math.max.apply(Math,
								$scope.gateoutin.gateoutinDtl
										.map(function(item) {
											return item.id;
										}));
						$scope.max = $scope.max + 1;
						var chargedata = {
							id : $scope.max,
							chargeHeads : '',
							unit : '',
							currency : '',
							qty : '',
							rate : '',
							currencyList : angular.copy($scope.currencylist),
							paymentMethod : '',
							transactionType : '',
							buySell : '',
							note : ''
						};

						$scope.gateoutin.gateoutinDtl.push(chargedata);
						var len = $scope.gateoutin.gateoutinDtl.length - 1;
						$timeout(function() {
							hideActivePapers($scope.max + "0", []);
						}, 1000);

						/* $scope.hide=true; */

					}

			

				

				
					$scope.typeList = [

					{
						id : 'Export',
						text : 'Export'
					}, {
						id : 'Import',
						text : 'Import'
					}

					]


					$scope.DownloadSample = function() {
						$("#tbPdfExport").bind('click', function() {
						});
						$('#tbPdfExport').simulateClick('click');
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

					$rootScope.closeUpload = function() {
						ngDialog.close();
					};

					$rootScope.uploadFile = function(element) {
						$scope.excelfile = element.files[0];
						console.log($scope.excelfile);
					}

					var loader = $injector.get("cfpLoadingBar");

					$scope.changecolor = function(id) {
						$('#' + id + ' .selectivityId').find('input').css(
								"border-color", "red");
						;

					}
					$scope.clearcolor = function(id) {
						$('#' + id + ' .selectivityId').find('input').css(
								"border-color", "#e8dddd");
						;

					}
					
					//upload doc 
					
					$scope.fileUpload =function(){
					
						 ngDialog.open({
				                template : 'fileGenModal',
				                scope :$scope
				            });
						}
					
					
					 $scope.downloadFile=function(){
					        $("#tbPdfExport").bind('click', function() {
					        });
					        $('#tbPdfExport').simulateClick('click');
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
											url : $stateParams.tenantid+'/app/gateOutin/uploadfile',
											data : frmData,
											contentType : false,
											processData : false,
											success : function(response) {
												// loader.complete();
												$scope.closeUpload();
												if (response.success == true) {
												/*	for(var i=0; i < response.containerDtl.length;i++){
														$scope.gateoutin.gateoutinDtl.push(response.containerDtl[i]);
													}*/
													
												//	$scope.gateoutin.gateoutinDtl=response.containerDtl;
												//	 $scope.isUploadDiv = true;
													$('#loadclick').simulateClick('click');
													logger.logSuccess("Uploaded Successfully!");
													$state.reload();
													
 												//$scope.gateoutin.gateoutinDtl=angular.copy(response.containerDtl);
 												
												} else if (response.success == false) {

													for (var i = 0; i < response.errorList.length; i++) {
														logger
																.logError(response.errorList[i]);
														$scope.closeUpload();
														 $scope.isUploadDiv = false;
														
													}
												} else if (response.errorList.length > 0) {

												} else {
													logger
															.logError("Sorry Error Occured");
													$scope.closeUpload();
													 $scope.isUploadDiv = false;
												}
											}
										});
							}
						}
					}
					
		
			 

					// add valid
					$scope.checkValidation = function() {
						
						var alertmsg = "<ui><h4 backgroundcolor=green>Please fill the required fields</h4>";
						var msg = "";	
						

						
						 alertmsg = alertmsg + msg + "</ui>";
					        if ($scope.checkundefined(msg)) {
					            return '';
					        } else {
					            return alertmsg;
					        }
					}

					$scope.checkundefined = function(value) {
						var invalid = false;
						if (value == undefined || value == 'undefined'
								|| value == null || value == 'null'
								|| value == '') {
							invalid = true;
						}
						return invalid;

					}
					$scope.doubleClick = false;
					$scope.submit = function() {

						var msg = $scope.checkValidation();
						if (!$scope.checkundefined(msg)) {//
							logger.logError(msg);
							$scope.doubleClick = false;
						} else {
							$scope.doubleClick = true;
							if ($scope.gateoutin.gateoutinDtl.length > 0) {
								/* if($scope.gateoutin.gateoutinDtl.length<=$scope.gateoutin.countTotal){ */

								var test;
								var checkDate;
								for(var i=0;i<$scope.gateoutin.gateoutinDtl.length;i++){
									
									if($scope.gateoutin.gateoutinDtl[i].newContainerDate != null && $scope.gateoutin.gateoutinDtl[i].newContainerDate != '' ){
										if(test == null && test == undefined){
											test = "true";
										}else{
											test = test + "," + "true";
										}
										
											
									}else{
										logger.logError("Please Fill the Date for Container: "+ $scope.gateoutin.gateoutinDtl[i].containerNo );
										$scope.doubleClick = false;
										if(test == null && test == undefined){
											test = "false";
										}else{
											test = test + "," + "false";
										}
									}
								}
								var check =  test.split(",").includes("false") ? false : true ;

								console.log(check);
								if(check == false){
									 
								}else{
									
									for(var i=0;i<$scope.gateoutin.gateoutinDtl.length;i++){
									if(moment($scope.gateoutin.gateoutinDtl[i].newContainerDate, 'DD/MM/YYYY HH:mm').isValid()){
										if(checkDate == null && checkDate == undefined){
											checkDate = "true";
										}else{
											checkDate = checkDate + "," + "true";
										}
									}else{
										logger.logError("Please Fill the Correct Date Format ('DD/MM/YYYY HH:mm') for Container: "+ $scope.gateoutin.gateoutinDtl[i].containerNo );
										$scope.doubleClick = false;
										if(checkDate == null && checkDate == undefined){
											checkDate = "false";
										}else{
											checkDate = checkDate + "," + "false";
										}
									}
									}
									var checkDate =  checkDate.split(",").includes("false") ? false : true ;

									if(checkDate == false){
										 
									}else{
										
								$http.post($stateParams.tenantid
														+ '/app/gateOutin/save',
												$scope.gateoutin)
										.success(
												function(datas) {
													debugger
													if (datas.success == true) {
														logger.logSuccess("Saved Successfully!");
														$scope.doubleClick = true;
														$state.reload();
													/*	$state.go('app.eqs.gateoutgatein.gateoutgateinlist',{tenantid : $stateParams.tenantid});*/

													} else {
														if(datas.errorcontainer!=null && datas.errorcontainer!=undefined ){
														if(datas.errorcontainer.length > 0){
															var conlist='';
													
															for(var i=0;i<datas.errorcontainer.length;i++){
																
																conlist= conlist + datas.errorcontainer[i].containerNo+' , ';
															
															}
															
															 logger.logError("Container number "+ conlist +" have no Deliever Order");
															 $scope.doubleClick = false;
															}else{
														
														     
														            logger.logError(datas.message);
														            $scope.doubleClick = false;
														            
															}
														}else{
															
															 logger.logError(datas.message);
												        
												            $scope.doubleClick = false;
												            
													}
									
												 
													}
												})
							
										.error(
												function(data) {
													logger
															.logError("Please try again");
													$scope.doubleClick = false;
												});
							}
							}
							} else {
								logger.logError("Atleast One Row Required");
								$scope.doubleClick = false;
							}
						}

					}

					 

				
					$scope.cancel = function() {
						$state.go('app.cim.gateoutgatein.gateoutgateinlist', {
							tenantid : $stateParams.tenantid
						});
					}


	

					

				}); 
	
 

