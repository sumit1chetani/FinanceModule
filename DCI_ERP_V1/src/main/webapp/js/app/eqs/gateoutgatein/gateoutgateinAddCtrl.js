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

					/*var croNo = $location.search().croNo;

					if (croNo != null && croNo != "") {
						$scope.gateoutin.croNo = croNo;
					}*/

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

					$scope.fetch = function() {/*

						var msg = $scope.checkValidation1();
						if (!$scope.checkundefined(msg)) {
							logger.logError(msg);
						} else {

							$http
									.post(
											$stateParams.tenantid
													+ '/app/gateOut/getEmptyContainerList',
											$scope.gateoutin)
									.success(
											function(datas) {
												debugger
												if (datas.success == true) {

													if (datas.sealdtl.length > 0) {

														$scope.gateoutin.popUpDtl = datas.sealdtl;
														ngDialog.close();
														ngDialog
																.open({
																	template : 'views/operation/gateOut/gateOutPopUp',
																	scope : $scope,
																	closeByEscape : true
																});

													} else {

														logger
																.logError("Containers not available in selected Depot");

													}

												} else {
													logger
															.logError("Error in Fetch");
												}
											}).error(function(data) {
										logger.logError("Please try again");
									});

						}
					*/}

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

					$scope.removeRow = function() {
						$scope.tablerow = [];
						for (var index = 0; index < 1; index++) {
							angular
									.forEach(
											$scope.gateoutin.gateoutinDtl,
											function(row, index) {
												var check = row.select;

												if (check == undefined
														|| check == "") {
													$scope.tablerow.push(row);
												} else if (index > 0) {
													$scope.gateoutin.gateoutinDtl = $scope.tablerow;

												}
											});
						}
					};
					
					$scope.addCredRow1 = function() {
					}
					$scope.removeRowedit = function() {
						$scope.tablerow = [];
						for (var index = 0; index < 1; index++) {
							angular
									.forEach(
											$scope.gateoutin.gateoutinDtledit,
											function(row, index) {
												var check = row.select;

												if (check == undefined
														|| check == "") {
													$scope.tablerow.push(row);
												} else if (index > 0) {
													$scope.gateoutin.gateoutinDtledit = $scope.tablerow;

												}
											});
						}
					};

					// Seal Table
					$scope.addRow1 = function() {

						$scope.max = Math.max.apply(Math,
								$scope.gateoutin.sealDtl.map(function(item) {
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

						$scope.gateoutin.sealDtl.push(chargedata);
						var len = $scope.gateoutin.sealDtl.length - 1;
						$timeout(function() {
							hideActivePapers($scope.max + "0", []);
						}, 1000);

						/* $scope.hide=true; */

					}

					$scope.removeRow1 = function() {
						$scope.tablerow = [];
						for (var index = 0; index < 1; index++) {
							angular.forEach($scope.gateoutin.sealDtl, function(
									row, index) {
								var check = row.select;

								if (check == undefined || check == "") {
									$scope.tablerow.push(row);
								} else if (index > 0) {
									$scope.gateoutin.sealDtl = $scope.tablerow;

								}
							});
						}
					};

					/*
					 * $scope.dropoffList=[
					 *  { id: 'ROAD', text: 'ROAD' }, { id: 'RAIL', text: 'RAIL' }
					 *  ]
					 */
					$scope.typeList = [

					{
						id : 'Export',
						text : 'Export'
					}, {
						id : 'Import',
						text : 'Import'
					}

					]

					$scope.activityList = [

					{
						id : 'out',
						text : 'Gate Out'
					}, {
						id : 'in',
						text : 'Gate In'
					}

					]

					$scope.loadList = [

					{
						id : 'empty',
						text : 'Empty'
					}, {
						id : 'full',
						text : 'full'
					}

					]

					// $scope.getSalesType = function() {
					// var data = {};
					// data["id"] = "1";
					// data["text"] = "CROSS TRADE";
					// $scope.salesTypeList.push(data);
					// data = {};
					// data["id"] = "2";
					// data["text"] = "LOCAL";
					// $scope.salesTypeList.push(data);
					// data = {};
					// data["id"] = "3";
					// data["text"] = "NOMINATED";
					// $scope.salesTypeList.push(data);
					//	    
					//	  
					// }
					// $scope.getSalesType();

					// excel upload

					$scope.openFileModal = function(trindex) {
						$scope.trId = trindex;
						var isOpenModal = false;
						isOpenModal = true;
						if (isOpenModal) {
							ngDialog.close();
							ngDialog.open({
								template : 'fileModal',
								scope : $scope
							});
						}

					}

					$scope.url1 = $stateParams.tenantid
							+ "/app/container/uploadEmployeeExcel";

					$scope.uploadInvoice = function() {/*
						$scope.error = false;
						loader.start();
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
											url : $scope.url1,
											data : frmData,
											contentType : false,
											processData : false,
											success : function(response) {
												loader.complete();
												if (response.success == true) {
													$scope.closeUpload();
													logger
															.logSuccess(response.message);
													$scope.gateoutin.gateoutinDtl[$scope.trId].gateoutininnerDtl = response.gateoutininnerDtl;

												} else if (response.success == false) {
													$scope.error = true;
													logger
															.logError("Error in Upload");
													$scope.rowCollection1 = response.errorExcelList;
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
					*/}

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
					
					
					
					
					
					
					$scope.fileUpload12 =function(){
						
						/* ngDialog.open({
				                template : 'fileGenModal1',
				                scope :$scope
				            });*/
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
													$('#buttontemp').simulateClick('click');
													$scope.gateoutin.gateoutinDtl=response.containerDtl;
						
													$('#buttontemp').simulateClick('click');
													logger.logSuccess("Data fetched!");
													
 												//$scope.gateoutin.gateoutinDtl=angular.copy(response.containerDtl);
 												
												} else if (response.success == false) {

													for (var i = 0; i < response.errorList.length; i++) {
														logger
																.logError(response.errorList[i]);
														$scope.closeUpload();
														
													}
												} else if (response.errorList.length > 0) {

												} else {
													logger .logError("Sorry Error Occured");
													$scope.closeUpload();
												}
											}
										});
							}
						}
					}
					
					//ravi code end
					

					$scope.checkValidation1 = function() {

						var alertmsg = "<ui><h4 backgroundcolor=green>Please fill the required fields</h4>";
						var msg = "";

						if ($scope.gateoutin.type == "Export") {

							if ($scope.checkundefined($scope.gateoutin.croNo)) {
								msg = msg
										+ "<li>please select CRO number.</li>";
								$scope.changecolor('customer_id');
							} else {
								$scope.clearcolor('customer_id');
							}
						} else {
							if ($scope.checkundefined($scope.gateoutin.doNo)) {
								msg = msg
										+ "<li>please select D.O. number.</li>";
								$scope.changecolor('customer_id');
							} else {
								$scope.clearcolor('customer_id');
							}
						}

						alertmsg = alertmsg + msg + "</ui>";
						if ($scope.checkundefined(msg)) {
							return '';
						} else {
							return alertmsg;
						}

					}

					// Export Excel

					$scope.excelexport = function(gateOutNo) {/*

						debugger
						// $http.post($stateParams.tenantid+'/app/gateOut/excelexport',$scope.gateoutin).success(function(datas){
						$http.post(
								$stateParams.tenantid
										+ '/app/gateOut/excelexport?gateOutNo='
										+ gateOutNo).success(function(datas) {
							debugger;
							$("#gateOutExport").bind('click', function() {
							});
							$('#gateOutExport').simulateClick('click');
							logger.logSuccess("Exported Successfully!");
							
							 * }else{ logger.logError("Failed to export"); }
							 
						}).error(function(result) {
							console.log("data" + result);
						});

						$.fn.simulateClick = function() {
							return this.each(function() {
								if ('createEvent' in document) {
									var doc = this.ownerDocument, evt = doc
											.createEvent('MouseEvents');
									evt
											.initMouseEvent('click', true,
													true, doc.defaultView, 1,
													0, 0, 0, 0, false, false,
													false, false, 0, null);
									this.dispatchEvent(evt);
								} else {
									this.click(); // IE
								}
							});
						}
					*/}

					// add valid
					$scope.checkValidation = function() {
						
						var alertmsg = "<ui><h4 backgroundcolor=green>Please fill the required fields</h4>";
						var msg = "";	
						
					
						
						
						
						
						
						
						
						
															  
						angular.forEach($scope.gateoutin.gateoutinDtl,function(chargesDetail,index) { 
										 
					        if($scope.checkundefined(chargesDetail.containerNo)) {
							 msg = msg + "<li>Row :" +(index + 1) + "#Container No :Field is required.</li>";
							 // $scope.changecolor('chargeHeads'+index);
							}else{
					             	$scope.clearcolor('chargeHeads'+index); }
					        if($scope.checkundefined(chargesDetail.conType)) {
								 msg = msg + "<li>Row :" +(index + 1) + "#Container Type :Field is required.</li>";
								 // $scope.changecolor('chargeHeads'+index);
								}else{
						             	$scope.clearcolor('chargeHeads'+index); }
					        if($scope.checkundefined(chargesDetail.conStatus)) {
								 msg = msg + "<li>Row :" +(index + 1) + "#Container Status :Field is required.</li>";
								 // $scope.changecolor('chargeHeads'+index);
								}else{
						             	$scope.clearcolor('chargeHeads'+index); }
					        if($scope.checkundefined(chargesDetail.containerDate)) {
								 msg = msg + "<li>Row :" +(index + 1) + "#Status Date :Field is required.</li>";
								 // $scope.changecolor('chargeHeads'+index);
								}else{
						             	$scope.clearcolor('chargeHeads'+index); }
					        if($scope.checkundefined(chargesDetail.newConStatus)) {
								 msg = msg + "<li>Row :" +(index + 1) + "#New Status :Field is required.</li>";
								 // $scope.changecolor('chargeHeads'+index);
								}else{
						             	$scope.clearcolor('chargeHeads'+index); }
					        if($scope.checkundefined(chargesDetail.newConStatus)) {
								 msg = msg + "<li>Row :" +(index + 1) + "#New Date :Field is required.</li>";
								 // $scope.changecolor('chargeHeads'+index);
								}else{
						             	$scope.clearcolor('chargeHeads'+index); }
					        if($scope.checkundefined(chargesDetail.depot)) {
								 msg = msg + "<li>Row :" +(index + 1) + "#Location :Field is required.</li>";
								 // $scope.changecolor('chargeHeads'+index);
								}else{
						             	$scope.clearcolor('chargeHeads'+index); }
					        
					       if(chargesDetail.newConStatus=='MTS' || chargesDetail.newConStatus=='EFS' || chargesDetail.newConStatus=='RFS'){ 
					        if($scope.checkundefined(chargesDetail.croNo)) {
								 msg = msg + "<li>Row :" +(index + 1) + "#CRO No :Field is required.</li>";
								 // $scope.changecolor('chargeHeads'+index);
								}else{
						             	$scope.clearcolor('chargeHeads'+index); }
					       
					       }
					       /*if(chargesDetail.NewConStatus=='RFS' || chargesDetail.NewConStatus=='EFS' || chargesDetail.NewConStatus=='MTR'){
					        if($scope.checkundefined(chargesDetail.sealNo)) {
								 msg = msg + "<li>Row :" +(index + 1) + "#Seal No :Field is required.</li>";
								 // $scope.changecolor('chargeHeads'+index);
								}else{
						             	$scope.clearcolor('chargeHeads'+index); }
						}*/
					        
					        
					        
															 
					});
						
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

					/*
					 * $scope.showPopup=function(){ ngDialog.open({ scope :
					 * $scope, template :
					 * 'views/master/inventory/gateoutin/popDetail', controller :
					 * $controller('popUpDtlAddCtrl', { $scope : $scope,
					 * rowData:'', selectedRowId : '' }), className :
					 * 'ngdialog-theme-plain', showClose : false,
					 * closeByDocument : false, closeByEscape : true
					 * preCloseCallback : $scope.getList });
					 * 
					 *  }
					 */

					$scope.submitupdate = function() {

						//var msg = $scope.checkValidation();
						if (false) {//!$scope.checkundefined(msg)
							logger.logError(msg);
						} else {
							if ($scope.gateoutin.gateoutinDtl.length > 0) {
								/* if($scope.gateoutin.gateoutinDtl.length<=$scope.gateoutin.countTotal){ */
								$http
										.post(
												$stateParams.tenantid
														+ '/app/gateOutin/update',
												$scope.gateoutin)
										.success(
												function(datas) {
													if (datas.success == true) {

														logger.logSuccess("Updated Successfully!");
														$state.go("app.eqs.gateoutgatein.gateoutgateinlist",{tenantid:$stateParams.tenantid});

													} else {
														logger
																.logError(datas.message);
													}
												})
										.error(
												function(data) {
													logger
															.logError("Please try again");
												});

								/*
								 * } else{
								 * 
								 * logger.logError("Detail count exceeds CRO
								 * Count"); }
								 */

							} else {
								logger.logError("Atleast One Row Required");
							}
						}

					}
					$scope.cancel = function() {
						$state.go('app.eqs.gateoutgatein.gateoutgateinlist', {
							tenantid : $stateParams.tenantid
						});
					}


					$scope
							.$watch(
									'gateoutin.doNo',
									function(newValue, oldValue) {
										if ($scope.edit == false) {
											if (newValue != ''
													&& newValue != undefined) {
												$scope.croId = newValue;
												$http
														.post(
																$stateParams.tenantid
																		+ '/app/gateOut/DOdetail',
																$scope.croId)
														.success(
																function(datas) {

																	if (datas.success) {

																		/* $scope.gateoutin.bookingNo=datas.seagateoutinBean.bookingNo; */

																		$scope.gateoutin.customer = datas.seagateoutinBean.customer;

																		$scope.gateoutin.depot = datas.seagateoutinBean.depot;

																		/* $scope.gateoutin.countTotal=datas.seagateoutinBean.countTotal; */
																	} else {

																		/* $scope.gateoutin.croNo=oldValue; */
																		logger
																				.logError(newValue
																						+ " "
																						+ datas.message);

																	}

																})
														.error(function(datas) {

														});
											}
										}
									});

					$scope
							.$watch(
									'gateoutin.type',
									function(newValue, oldValue) {
										if ($scope.edit == false) {
											if (newValue != ''
													&& newValue != undefined) {

												$scope.gateoutin.bookingNo = '';

												$scope.gateoutin.customer = '';

												$scope.gateoutin.depot = '';

												$scope.gateoutin.countTotal = '';

											}
										}
									});

					

				});
app.controller('gateoutintableCtrl', function($scope, $http, $filter, logger,$rootScope,
		$stateParams) {
	
	
	  $scope.$watchCollection('gateoutin.gateoutinDtl[trIndex].containerNo',
	     		function(newValue, oldValue) {
	   	var k=0;
	   	if($scope.gateoutin.gateoutinDtl[$scope.trIndex].containerNo != null ){
	   		
	   		for(var i=0; i < $scope.gateoutin.gateoutinDtl.length; i++){
	   			if(i != $scope.trIndex){
	   				if($scope.gateoutin.gateoutinDtl[i].containerNo != null && 
	   						$scope.gateoutin.gateoutinDtl[i].containerNo != "" &&
	   						$scope.gateoutin.gateoutinDtl[i].containerNo != undefined ){
	   					
	   					if($scope.gateoutin.gateoutinDtl[i].containerNo ==  $scope.gateoutin.gateoutinDtl[$scope.trIndex].containerNo  ){
	   					 $scope.gateoutin.gateoutinDtl[$scope.trIndex].containerNo ='';
	   						k++;
	   				}
	   	}
	   }
	   }
	   	}
	   	
	   	if(k > 0){
	   		 logger.logError("Same Container Number not allowed to select!");
	   	}
	   });
	
	$scope.$watch('gateoutin.gateoutinDtl[trIndex].containerNo', function(newValue,
			oldValue) {
		var index = $scope.trIndex;
		if (newValue != '' && newValue != undefined) {

			$http.post($stateParams.tenantid +'/app/gateOutin/getContainerDetail',newValue).success(function(datas) {
				$scope.gateoutin.gateoutinDtl[index].conStatus = datas.seaQuotationBean.conStatus;
				$scope.gateoutin.gateoutinDtl[index].conType = datas.seaQuotationBean.conType;
				$scope.gateoutin.gateoutinDtl[index].soc = datas.seaQuotationBean.soc;
				$scope.gateoutin.gateoutinDtl[index].containerDate = datas.seaQuotationBean.containerDate;
				$scope.gateoutin.gateoutinDtl[index].preDepot = datas.seaQuotationBean.depot;
				if(datas.seaQuotationBean.croNo!=null && datas.seaQuotationBean.croNo!=undefined){
				$scope.gateoutin.gateoutinDtl[index].croNo = datas.seaQuotationBean.croNo;
				}
				$scope.gateoutin.gateoutinDtl[index].depot = datas.seaQuotationBean.depot;
				$scope.newdepot=true;
			}).error(function(data) {
				logger.logError("Unable to fetch");
			});

		}
	});
	
	
	$scope.$watch('[gateoutin.gateoutinDtl[trIndex].conStatus,gateoutin.gateoutinDtl[trIndex].soc]',
			function(newValue, oldValue) {
		
		var index = $scope.trIndex;
		var row=$scope.trIndex+1;

		console.log(newValue[0]);
		   console.log(newValue[1]);
		   
		  // newValue[1]=true;
		   
				if (newValue[0] != ''&& newValue[0] != undefined) {

					if (newValue[0] == 'RTC' && newValue[1] == true){
						
						logger.logError("Row : "+row+" Soc container already in RTC, No move allowed");	
						$scope.gateoutin.gateoutinDtl[index].newConStatus='';
						
					}else{
					$http.get($stateParams.tenantid+ '/api/containerMovement/cmsCode?emccodecurrName='
											+ newValue[0])
							.success(
									function(datas) {
										console.log(datas);
									
										$scope.conStatusNextList=datas.list1;
										
										
										
										
									})
							.error(
									function(data) {
										logger.logError("Unable to fetch");
									});
					}
					
			if ($scope.gateoutin.gateoutinDtl[index].newConStatus != ''&& $scope.gateoutin.gateoutinDtl[index].newConStatus != undefined) {
						if($scope.gateoutin.gateoutinDtl[index].newConStatus=='MTR'){
							if($scope.gateoutin.gateoutinDtl[index].conStatus!='RTC'){
								$scope.gateoutin.gateoutinDtl[index].newConStatus='';
								logger.logError("Row : "+row+" Container must be in RTC Status for MTR move");	
							}
						}
						
	                     if($scope.gateoutin.gateoutinDtl[index].newConStatus=='EFS' || $scope.gateoutin.gateoutinDtl[index].newConStatus=='RFS'){
							if($scope.gateoutin.gateoutinDtl[index].conStatus!='MTS'){
								$scope.gateoutin.gateoutinDtl[index].newConStatus='';
								logger.logError("Row : "+row+" Container must be in MTS Status for EFS or RFS move");	
							}
						}
	                     
	                     if($scope.gateoutin.gateoutinDtl[index].newConStatus=='RTC'){
	 						if($scope.gateoutin.gateoutinDtl[index].conStatus!='FCD'){
	 							$scope.gateoutin.gateoutinDtl[index].newConStatus='';
	 							logger.logError("Row : "+row+" Container must be in FCD Status for RTC move");	
	 						}
	 					}
	                     
	                     
	                     if($scope.gateoutin.gateoutinDtl[index].newConStatus=='MTS'){
	  						
	  						if($scope.gateoutin.gateoutinDtl[index].conStatus!='ECD' && $scope.gateoutin.gateoutinDtl[index].conStatus!='EDS' && $scope.gateoutin.gateoutinDtl[index].conStatus!='MTD'
	  							&& $scope.gateoutin.gateoutinDtl[index].conStatus!='MTR'){
	  							$scope.gateoutin.gateoutinDtl[index].newConStatus='';
	  							logger.logError("Row : "+row+" Container must be in ECD or EDS or MTD Status for MTS move");	
	  						}
	  					}
						
					}
					
					
		
		

				}
			});
	
	//Next move validation
	
	$scope.$watch('gateoutin.gateoutinDtl[trIndex].newConStatus',
			function(newValue, oldValue) {/*
		
		var index = $scope.trIndex;
		var row=$scope.trIndex+1;

				if (newValue != ''&& newValue != undefined) {
					
					if ($scope.gateoutin.gateoutinDtl[index].conStatus != ''&& $scope.gateoutin.gateoutinDtl[index].conStatus != undefined) {
					if(newValue=='MTR'){
						if($scope.gateoutin.gateoutinDtl[index].conStatus!='RTC'){
							$scope.gateoutin.gateoutinDtl[index].newConStatus='';
							logger.logError("Row : "+row+" Container must be in RTC Status for MTR move");	
						}
					}
					
                     if(newValue=='EFS' || newValue=='RFS'){
						if($scope.gateoutin.gateoutinDtl[index].conStatus!='MTS'){
							$scope.gateoutin.gateoutinDtl[index].NewConStatus='';
							logger.logError("Row : "+row+" Container must be in MTS Status for EFS or RFS move");	
						}
					}
                     
                     if(newValue=='RTC'){
 						if($scope.gateoutin.gateoutinDtl[index].conStatus!='FCD'){
 							$scope.gateoutin.gateoutinDtl[index].NewConStatus='';
 							logger.logError("Row : "+row+" Container must be in FCD Status for RTC move");	
 						}
 					}
                     
                     
                     if(newValue=='MTS'){
  						
  						if($scope.gateoutin.gateoutinDtl[index].conStatus!='ECD' && $scope.gateoutin.gateoutinDtl[index].conStatus!='EDS' && $scope.gateoutin.gateoutinDtl[index].conStatus!='MTD'
  							&& $scope.gateoutin.gateoutinDtl[index].conStatus!='MTR'){
  							$scope.gateoutin.gateoutinDtl[index].NewConStatus='';
  							logger.logError("Row : "+row+" Container must be in ECD or EDS or MTD Status for MTS move");	
  						}
  					}
                     
                     if(newValue=='MCT'){
                    	 
                    	 $scope.gateoutin.gateoutinDtl[index].depot ='';
   						
   						if($scope.gateoutin.gateoutinDtl[index].conStatus !='MTD'){
   							$scope.gateoutin.gateoutinDtl[index].NewConStatus='';
   							logger.logError("Row : "+row+" Container must be in MTD Status for MCT move");	
   						}else{
   							
   							$http.post($stateParams.tenantid +'/app/gateOutin/checkMCT',$scope.gateoutin.gateoutinDtl[index].containerNo).success(function(datas) {
   								
   								
   								if(datas.croStatus){
   									
   									
   									$scope.gateoutin.gateoutinDtl[index].NewConStatus='';
   		  							logger.logError("Row : "+row+" MCT after MCT not allowed ");
   									
   									
   									
   								}
   								

   							}).error(function(data) {
   								logger.logError("Unable to fetch");
   							});
   							
   						}
   					}
					
				}
				}
				else{
					
					logger.logError("Row No: "+ row +" Please select container ID");
					
				}
			*/});
	
	
	$scope.$watch('gateoutin.gateoutinDtl[trIndex].newContainerDate',
			function(newValue, oldValue) {
		
		var index = $scope.trIndex;

				if (newValue != ''&& newValue != undefined) {
					if($scope.gateoutin.gateoutinDtl[index].containerDate!= '' && $scope.gateoutin.gateoutinDtl[index].containerDate!= undefined){
						

						var frmDate = newValue;
						var toDate = $scope.gateoutin.gateoutinDtl[index].containerDate;
						var splitarray = new Array();
						var splitarray1 = new Array();
						splitarray = frmDate.split(" ");
						var date = splitarray[0];
						var time = splitarray[1];
						
						frmDate = date.split("/");
						frmDate = new Date(frmDate[2],
								frmDate[1] - 1, frmDate[0]);
						
						
						splitarray1 = toDate.split(" ");
						var date1 = splitarray1[0];
						var time1 = splitarray1[1];
						
						
						toDate = date1.split("/");
						toDate = new Date(toDate[2],
								toDate[1] - 1, toDate[0]);
						
						//var today = new Date();
						//var dd = String(today.getDate()).padStart(2, '0');
						//var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
						//var yyyy = today.getFullYear();
						var today=new Date(new Date().getFullYear(),new Date().getMonth() , new Date().getDate());

						//today = mm + '/' + dd + '/' + yyyy;
						/*document.write(today);*/
						
					
						
						
						if (toDate > frmDate) {
							logger.logError("New Date should not be lesser than Status Date");	
							$scope.gateoutin.gateoutinDtl[index].newContainerDate='';
						}else{/*
							
							const diffTime = today.getTime() - frmDate.getTime();
							const diffDays = diffTime / (1000 * 60 * 60 * 24);
								
							if(diffDays < 0){
								
								logger.logError("New date should be less than or equal to current date ");	
								$scope.gateoutin.gateoutinDtl[index].newContainerDate='';
								
							}else if(diffDays > 3){
								
								logger.logError("New date should not be lesser than three days from current date ");	
								$scope.gateoutin.gateoutinDtl[index].newContainerDate='';
								
							}
							
							
							
						*/}
						
					}else{
						
						//logger.logError("Please enter Container No");	
						
					}
					
					
					
				}
			});
	
	
	$scope.$watch('gateoutin.gateoutinDtl[trIndex].containerNo',
			function(newValue, oldValue) {
		
		var index = $scope.trIndex;

				if (newValue != ''&& newValue != undefined) {
					
					angular.forEach($scope.gateoutin.gateoutinDtl, function(
							value, key) {
						
						if(index!=value.id){
						
						if(newValue==value.containerNo){
							
							
							//$scope.gateoutin.gateoutinDtl[index].containerNo='';
							//logger.logError("Container No should not be same");	
							
							
						}
						}
					});

				}
			});
	
	   $scope.$watch('gateoutin.gateoutinDtl[trIndex].newConStatus',
			function(newValue, oldValue) {
		   
			var index = $scope.trIndex;

				if (newValue != ''&& newValue != undefined) {
					
					if(newValue=='RFS'|| newValue=='EFS' || newValue=='MTR' ){
						
						//$scope.gateoutin.gateoutinDtl[index].sealNo='';
						
						
					}
					else if(newValue=='RTC'|| newValue=='MTR'){
						
						
						
						//$scope.gateoutin.gateoutinDtl[index].croNo='';
						
						
						
					}
					else if (newValue == 'ECS'){
						$scope.newdepot=false;
					}
					else if (newValue == 'MCT'){
						$scope.newdepot=false;
					}
					
					else{
						
						//$scope.gateoutin.gateoutinDtl[index].croNo='';
						$scope.gateoutin.gateoutinDtl[index].sealNo='';
						
					}

			
					
		
		

				}
			});
	   
	   
	   $rootScope.check1 =false;
	   $scope.$watch('[gateoutin.gateoutinDtl[trIndex].croNo,gateoutin.gateoutinDtl[trIndex].conType]', function(newValue,
	   oldValue) {


	   if (newValue[0] != '' && newValue[0] != undefined && newValue[1] != '') {

	   console.log(newValue[0]);
	   console.log(newValue[1]);

	   $http.post($stateParams.tenantid+'/app/gateOutin/validateCROtffr?croNo=' +newValue[0]+ '&conType=' +newValue[1]).success(function(datas) {
	  // var Ctype = datas.checkcontainertype;
	   if(datas.checkcontainertype == false){
		   logger.logError('Container Type does not matches with CRO Container Type..!');
		   $rootScope.check1 =true;
	   }
	   else{
		   $rootScope.check1 =false;
	   }
	   }) 
	   }
	   });
	
	
	
	
	
	/*

	$scope.$watch('gateoutin.gateoutinDtl[trIndex].vessel', function(newValue,
			oldValue) {

		if (newValue != '' && newValue != undefined) {

			$http.get(
					$stateParams.tenantid
							+ '/api/vesselsailing/voyagelist?vessel='
							+ newValue).success(function(datas) {
				$scope.voyageList = datas;

			}).error(function(data) {
				logger.logError("Unable to fetch");
			});

		}
	});

	$scope.$watch('gateoutin.gateoutinDtl[trIndex].activity', function(
			newValue, oldValue) {
		var index = $scope.trIndex;
		if (newValue != '' && newValue != undefined) {
			if (newValue == 'out') {
				$scope.gateoutin.gateoutinDtl[index].gateOutNo = '';
				$scope.gateoutin.gateoutinDtl[index].sealNo = '';

			} else {

				$scope.gateoutin.gateoutinDtl[index].croNo = '';

			}
		}
	});

	$scope.$watch('gateoutin.gateoutinDtl[trIndex].type', function(newValue,
			oldValue) {
		var index = $scope.trIndex;
		if (newValue != '' && newValue != undefined) {
			if (newValue == 'Import') {

				$scope.gateoutin.gateoutinDtl[index].gateOutNo = '';
				$scope.gateoutin.gateoutinDtl[index].croNo = '';

			} else {
				if ($scope.gateoutin.gateoutinDtl[index].activity == 'out') {
					$scope.gateoutin.gateoutinDtl[index].gateOutNo = '';
					$scope.gateoutin.gateoutinDtl[index].doNo = '';
				} else {
					$scope.gateoutin.gateoutinDtl[index].croNo = '';
					$scope.gateoutin.gateoutinDtl[index].doNo = '';
				}

			}
		}
	});

	$scope.$watch('gateoutin.gateoutinDtl[trIndex].croNo', function(newValue,
			oldValue) {
		var index = $scope.trIndex;

		if (newValue != '' && newValue != undefined) {
			
			$http.post($stateParams.tenantid+'/app/gateOutin/getcrodetail',newValue).success(function(datas) {
				$scope.gateoutin.gateoutinDtl[index].bookingNo = datas.seaQuotationBean.bookingNo;
				$scope.gateoutin.gateoutinDtl[index].customer = datas.seaQuotationBean.customer;
				$scope.gateoutin.gateoutinDtl[index].depot = datas.seaQuotationBean.depot;
				$scope.gateoutin.gateoutinDtl[index].vessel = datas.seaQuotationBean.vessel;
				$scope.gateoutin.gateoutinDtl[index].voyage = datas.seaQuotationBean.voyage;

			}).error(function(data) {
				logger.logError("Unable to fetch");
			});

		}
	});
	
	$scope.$watch('gateoutin.gateoutinDtl[trIndex].gateOutNo', function(newValue,
			oldValue) {
		var index = $scope.trIndex;

		if (newValue != '' && newValue != undefined) {
			
			$http.post($stateParams.tenantid+'/app/gateOutin/getGodetail',newValue).success(function(datas) {
				$scope.gateoutin.gateoutinDtl[index].bookingNo = datas.seaQuotationBean.bookingNo;
				$scope.gateoutin.gateoutinDtl[index].customer = datas.seaQuotationBean.customer;
				$scope.gateoutin.gateoutinDtl[index].depot = datas.seaQuotationBean.depot;
				$scope.gateoutin.gateoutinDtl[index].vessel = datas.seaQuotationBean.vessel;
				$scope.gateoutin.gateoutinDtl[index].voyage = datas.seaQuotationBean.voyage;

			}).error(function(data) {
				logger.logError("Unable to fetch");
			});

		}
	});
	
	$scope.$watch('gateoutin.gateoutinDtl[trIndex].doNo', function(newValue,
			oldValue) {
		var index = $scope.trIndex;

		if (newValue != '' && newValue != undefined) {
			
			$http.post($stateParams.tenantid+'/app/gateOutin/getDodetail',newValue).success(function(datas) {
				$scope.gateoutin.gateoutinDtl[index].customer = datas.seaQuotationBean.customer;
				$scope.gateoutin.gateoutinDtl[index].vessel = datas.seaQuotationBean.vessel;
				$scope.gateoutin.gateoutinDtl[index].voyage = datas.seaQuotationBean.voyage;

			}).error(function(data) {
				logger.logError("Unable to fetch");
			});

		}
	});

*/});

app.controller('gateoutinEdittableCtrl', function($scope, $http, $filter, logger,
		$stateParams) {
	
	$scope.$watch('gateoutin.gateoutinDtledit[trIndex].conStatus',
			function(newValue, oldValue) {
		
		var index = $scope.trIndex;
		var row=$scope.trIndex+1;

				if (newValue != ''&& newValue != undefined) {

					$http.get($stateParams.tenantid+ '/api/containerMovement/cmsCode?emccodecurrName='
											+ newValue)
							.success(
									function(datas) {
										console.log(datas);
									
										$scope.conStatusNextList=datas.list1;
										
										
										
									})
							.error(
									function(data) {
										logger.logError("Unable to fetch");
									});
					
					
			if ($scope.gateoutin.gateoutinDtledit[index].newConStatus != ''&& $scope.gateoutin.gateoutinDtledit[index].newConStatus != undefined) {
						if($scope.gateoutin.gateoutinDtledit[index].newConStatus=='MTR'){
							if($scope.gateoutin.gateoutinDtledit[index].conStatus!='RTC'){
								$scope.gateoutin.gateoutinDtledit[index].newConStatus='';
								logger.logError("Row : "+row+" Container must be in RTC Status for MTR move");	
							}
						}
						
	                     if($scope.gateoutin.gateoutinDtledit[index].newConStatus=='EFS' || $scope.gateoutin.gateoutinDtledit[index].newConStatus=='RFS'){
							if($scope.gateoutin.gateoutinDtledit[index].conStatus!='MTS'){
								$scope.gateoutin.gateoutinDtledit[index].newConStatus='';
								logger.logError("Row : "+row+" Container must be in MTS Status for EFS or RFS move");	
							}
						}
	                     
	                     if($scope.gateoutin.gateoutinDtledit[index].newConStatus=='RTC'){
	 						if($scope.gateoutin.gateoutinDtledit[index].conStatus!='FCD'){
	 							$scope.gateoutin.gateoutinDtledit[index].newConStatus='';
	 							logger.logError("Row : "+row+" Container must be in FCD Status for RTC move");	
	 						}
	 					}
	                     
	                     
	                     if($scope.gateoutin.gateoutinDtledit[index].newConStatus=='MTS'){
	  						
	  						if($scope.gateoutin.gateoutinDtledit[index].conStatus!='ECD' && $scope.gateoutin.gateoutinDtledit[index].conStatus!='EDS' && $scope.gateoutin.gateoutinDtledit[index].conStatus!='MTD'
	  							&& $scope.gateoutin.gateoutinDtledit[index].conStatus!='MTR'){
	  							$scope.gateoutin.gateoutinDtledit[index].newConStatus='';
	  							logger.logError("Row : "+row+" Container must be in ECD or EDS or MTD Status for MTS move");	
	  						}
	  					}
						
					}
					
					
		
		

				}
			});
	
	
	
});