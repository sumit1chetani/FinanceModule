'use strict';
app
		.controller(
				'reportaddCtrl',
				function($scope, $rootScope, $http, $location, logger,
						ngDialog, utilsService, $state, sharedProperties,
						$window, $stateParams, validationService, toaster) {

					$scope.isEdit = false;
					$scope.reportEirDetailList = [];
					$('#eirDate').datetimepicker({
						format : 'DD/MM/YYYY'
					})

					// date picker
					$('#todate').datetimepicker({
						format : 'DD/MM/YYYY'
					})

					$scope.reportEir = {
						eirNo : '',
						truck : '',
						shippingLine : '',
						offloadSno : '',
						containerNo : '',
						iso : '',
						size : '',
						type : '',
						eirDate : '',
						dmf : '',
						mgwt : '',
						mtwt : '',
						netwt : '',
						vesselName : '',
						voyageNo : '',
						guaranteeNo : '',
						surveyedBy : '',
						eirComplied : '',
						eirDocUrl : '',
						truckId : '',
						driverName : '',
						driverId : '',
						empName : '',
						trip : '',
						tripId : ''
					}
					$scope.tempreportEirDetail = {
						select : false,
						eirDtlId : '',
						code : '',
						description : '',
						qty : '',
						hrs : '',
						lcost : '',
						mcost : '',
						total : ''

					}

					$scope.addRow = function() {
						var tmp = angular.copy($scope.tempreportEirDetail);
						$scope.reportEirDetailList.push(tmp);
					}

					$scope.addRow();

					$scope.getDropdownValues = function() {
						debugger;

						$http.get(
								$stateParams.tenantid
										+ '/app/reportEIR/getTruckList')
								.success(function(datas) {
									console.log(datas);
									$scope.lTripList = datas.lTruckList;
									$scope.lTypeList = datas.lTypeList;
									$scope.lsizeList = datas.lsizeList;
								}).error(function(datas) {
								});

					}

					$scope.getDropdownValues();

					var eirHdrId = $location.search().eirHdrId;
					if (eirHdrId != null && eirHdrId != undefined
							&& eirHdrId > 0) {
						$scope.isEdit = true;
						$http
								.post(
										$stateParams.tenantid
												+ '/app/reportEIR/edit?id='
												+ eirHdrId)
								.success(
										function(data) {
											if (data.success) {
												console.log("edit");
												console.log(data.reportEirNote);
												/* $scope.getDropdownValues(); */

												// $scope.valrr =
												// data.reportEirNote.tripId;
//												$('#ieval')
//														.val(
//																data.reportEirNote.tripId);
												$scope.reportEir = data.reportEirNote;
												$scope.reportEir.tripId = data.reportEirNote.tripId.toString();
												$scope.reportEirDetailList = data.reportEirNoteDetail;
											} else {
												logger
														.logError("Unable to fetch data");
											}
										});
					}

					$scope.deleteRow = function() {
						if ($scope.isEdit == false) {
							for (var i = $scope.reportEirDetailList.length - 1; i >= 0; i--) {
								if ($scope.reportEirDetailList[i].select == true) {
									$scope.reportEirDetailList.splice(i, 1);
								}
							}
						} else if ($scope.isEdit == true) {

						}
					}

					// Download

					$scope.fileDownload = function() {
						$("#fileExport").bind('click', function() {
							console.log($(this).attr('href'));
						});
						$("#fileExport").simulateClick('click');

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
								this.click(); // IE
							}
						});
					}

					$scope
							.$watch(
									'reportEir.tripId',
									function(newValue, oldValue) {
										if (newValue != ''
												&& newValue != undefined) {
											
											$http
													.get(
															$stateParams.tenantid
																	+ '/app/reportEIR/getEmpList?truckId='
																	+ newValue)
													.success(
															function(datas) {
																console.log(datas);
																if(datas.reportEirNote == null ||  datas.reportEirNote == '')
																	{
																	$scope.reportEir.truck = '';
																	$scope.reportEir.driverID = '';
																	$scope.reportEir.driverName = '';
																	}else
																		{
																$scope.reportEir.truck = datas.reportEirNote.truck;
																$scope.reportEir.driverID = datas.reportEirNote.empId;
																$scope.reportEir.driverName = datas.reportEirNote.empName;
																		}
																if(datas.success == true){
																debugger;
																$scope.containerList = datas.containerList;
																

																console
																		.log(datas);
																}else
																	if ($scope.isEdit == false) {
																	logger.logError("Please map container in booking");
																	}
															}).error(
															function(datas) {
															});
										}
									});

					
					$scope
					.$watch(
							'reportEir.containerNo',
							function(newValue, oldValue) {
								if (newValue != ''
										&& newValue != undefined) {
									$http
											.get(
													$stateParams.tenantid
															+ '/app/reportEIR/getContainerList?containerNo='
															+ newValue)
											.success(
													function(datas) {
														console.log(datas);
														debugger;
														
														$scope.reportEir.type = datas.reportEirNote.type;
														$scope.reportEir.size = datas.reportEirNote.size;
														

														console
																.log(datas);
													}).error(
													function(datas) {
													});
								}
							});

					
					
					
					// Document Upload
					$rootScope.uploadDoc = function(element) {
						$scope.appfil = element.files[0];
					}
					$scope.appFileName = "";
					$scope.appFilePath = "";
					$rootScope.fileUpload = function() {
						var docfile = $scope.appfil;
						var fileExtension = docfile.name;
						var frmData = new FormData();
						frmData.append("file", docfile);
						frmData.append("fileName", "CN"
								+ $scope.reportEir.eirHdrId
								+ new Date().getTime());

						$scope.docfile = frmData;
						$
								.ajax({
									type : "POST",
									url : $stateParams.tenantid
											+ "/app/reportEIR/uploadfile",
									data : frmData,
									contentType : false,
									processData : false,
									success : function(result) {
										$scope.docFileName = result.docFileName;
										$scope.docFilePath = result.docPath;
										$scope.reportEir.eirDocUrl = result.docPath;
										if (result.success) {
											console.log("result is");
											logger
													.logSuccess("Document Uploaded Successfully");
										} else {
											logger.logError("Fail to Upload");
										}
									}
								});

					};

					$scope.cancel = function() {
						$state.go('app.operation.report.reportsubmenu', {
							tenantid : $stateParams.tenantid
						});
					}
					$scope.save = function(reportEIRForm) {
						if (new validationService()
								.checkFormValidity(reportEIRForm)) {
							var obj = {
								reportEirNote : $scope.reportEir,
								reportEirNoteDetail : $scope.reportEirDetailList
							}
							$http
									.post(
											$stateParams.tenantid
													+ '/app/reportEIR/save',
											obj)
									.success(
											function(data) {
												if (data.success) {
													logger
															.logSuccess('Saved Successfully');
													$scope.cancel();
												} else {
													logger
															.logError('EIR No. already exists!');
												}
												$scope.onLoad = false;
												$scope.bookingReport.loadBusy = false;
											});
						} else {
							toaster
									.pop(
											'error',
											"Please fill the required fields",
											logger
													.getErrorHtmlNew(reportEIRForm.$validationSummary),
											5000, 'trustedHtml');
						}
					}

					$scope.update = function(reportEIRForm) {
						if (new validationService()
								.checkFormValidity(reportEIRForm)) {
							var obj = {
								reportEirNote : $scope.reportEir,
								reportEirNoteDetail : $scope.reportEirDetailList
							}

							$http.post(
									$stateParams.tenantid
											+ '/app/reportEIR/update', obj)
									.success(function(data) {

										if (data.success) {
											logger
											.logSuccess('Updated Successfully');
											$scope.cancel();
										} else {
											logger
											.logError('Unable to Update!');
										}
									});
						} else {
							toaster
									.pop(
											'error',
											"Please fill the required fields",
											logger
													.getErrorHtmlNew(reportEIRForm.$validationSummary),
											5000, 'trustedHtml');
						}
					}
				});