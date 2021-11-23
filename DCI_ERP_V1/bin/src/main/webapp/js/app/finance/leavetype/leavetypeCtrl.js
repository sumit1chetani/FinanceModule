'use strict';
app
		.controller(
				'leavetypeCtrl',
				function($scope, $state, $http, ngDialog, logger, $location,
						$controller, $injector, sharedProperties, toaster,
						$rootScope, $stateParams) {
					$scope.rowCollection = [];
					$scope.displayedCollection = [];
					$scope.itemsByPage = 10;
					$scope.isDelete = true;

					$scope.add = function() {
						$state.go('app.hr.leavetype.add');
					}

					$scope.getLeaveTypeList = function() {
						var url = $stateParams.tenantid
								+ '/finance/leavetype/list';
						$http.get(url).success(function(response) {
							console.log(response);
							$scope.rowCollection = response.leaveTypeList;
						})
					}

					$scope.getLeaveTypeList();

					$scope.editRow = function(leaveType) {
						$location.url($stateParams.tenantid +'/hr/leavetype/add?shortName='
								+ leaveType.shortName);
					};
					$scope.deleteRow = function(leaveType) {
						ngDialog
								.openConfirm()
								.then(
										function() {
											$http.post(	$stateParams.tenantid+ '/finance/leavetype/delete',leaveType.shortName)
													.success(function(response) {
																if (response .success) {
																	logger.logSuccess("Deleted Succesfully!");
																	$scope.getLeaveTypeList();
																} else {
																		logger.logError("Unable to Delete!");
																}
															}).error(function(response) {
																logger.logError("Error Please Try Again");
															});
										});
					};

					
					
					$scope.fileUpload = function() {
						ngDialog.close();
						ngDialog.open({
							template : 'fileModal',
							scope : $scope
						});
					};

					$rootScope.uploadFile = function(element) {

						console.log("excel file");
						$scope.excelfile = element.files[0];
						console.log($scope.excelfile);
					}

					$rootScope.closeFileDialog = function() {
						ngDialog.close();
					};

					$rootScope.uploadLeave = function() {
						ngDialog.close();
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
											url : "/finance/leavetype/uploadfile",
											data : frmData,
											contentType : false,
											processData : false,
											success : function(result) {
												console.log("result");
												console.log(result);
												if (result.success) {
													logger
															.logSuccess("File Uploaded Successfully");
													$scope.getLeaveTypeList();
												} else {
													logger
															.logError("Unable to upload the given excel due to the improper data. Please refer the sample excel for correct format.");
												}

											}

										});
							}

						}
					}

					$scope.deleteSelected = function() {
						var deletedIds = new Array();
						for ( var index in $scope.displayedCollection) {
							if ($scope.displayedCollection[index].isSelected != undefined
									&& $scope.displayedCollection[index].isSelected != false) {
								deletedIds
										.push($scope.displayedCollection[index].shortName);
							}
						}
						if (deletedIds.length == 0) {
							logger
									.logError("Please Select Checkbox to Delete.");
						} else {
							ngDialog
									.openConfirm()
									.then(
											function() {
												$http
														.post(
																$stateParams.tenantid
																		+ "/finance/leavetype/bulkdelete",
																deletedIds)
														.success(
																function(
																		response) {
																	if (response.success == true) {
																		logger
																				.logSuccess("Deleted Succesfully!");
																		$scope
																				.getLeaveTypeList();
																	} else {
																		if (response.message != '') {
																			logger
																					.logError(response.message);
																		}
																	}
																})
														.error(
																function(result) {
																	logger
																			.logError("Error Please Try Again");
																});
											});
						}
					}
				});