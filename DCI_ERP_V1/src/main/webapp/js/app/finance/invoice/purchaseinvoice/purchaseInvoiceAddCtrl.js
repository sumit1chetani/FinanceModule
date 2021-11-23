'use strict';
app.controller(
				'purchaseInvoiceAddCtrl',
				function($scope, $timeout, $stateParams, $filter, $rootScope,
						$http, $location, logger, utilsService, $state,
						sharedProperties, $window, ngDialog, $interval,
						validationService, toaster, $controller, $injector) {
					$scope.purchaseInvoiceData = {
						jobNo : '',
						puchaseInvoiceDate : '',
						customer : '',
						aol : '',
						aod : '',
						origin : '',
						destination : '',
						flightNo : '',
						arrivalDate : '',
						vendorInvoiceDate:'',
						remarks : '',
						party : '',
						reference : '',
						hawb : '',
						mawb : '',
						flightDate : '',
						departureDate : '',
						narration : '',
						purchaseInvoice : '',
						shipper : false,
						consignee : false,
						draftSave:false,
						bank : '',
						totalAmount : '',
						exchangeRate : '',
						partyNo : '',
						purchaseInvoiceDetail : [],
						// jobdetails
						aolName : '',
						aodName : '',
						bankDtl:'',
						selectBox:false,
						invoiceNo:'',
						status:''
					};

					$scope.tenant = $stateParams.tenantid

					$scope.jobNoList = [];
					$scope.customerList = [];
					$scope.originList = [];
					$scope.partyList = [];
					$scope.hawbList = [];
					$scope.aolList = [];
					$scope.aodList = [];
					$scope.destinationList = [];
					$scope.mawbList = [];
					$scope.bankList = [];
					$scope.accountList = [];
					
					$scope.statusList=[];
					$scope.getjobStatus = function() {
					    var  data = {};
					    data["id"] = "1";
					    data["text"] = "OPEN";
					    $scope.statusList.push(data);
					    data = {};
					    data["id"] = "2";
					    data["text"] = "CLOSED";
					    $scope.statusList.push(data);  
					    
					}
					$scope.getjobStatus();
					$scope.currentURL = $location.protocol() + '://'
							+ $location.host() + ':' + $location.port() + "/#"
							+ $location.path();

					if (window.localStorage.getItem('purchaseIv') == $scope.currentURL) {
						alert('window ' + $scope.currentURL
								+ ' is already opened');
						// window.focus();
						// window.open($rootScope.currentURL,'_self').close();

						// window.close();
						// localStorage.removeItem('purchaseIv');
					} else {
						window.localStorage.setItem('purchaseIv',
								$scope.currentURL);
						// window.localStorage.removeItem('purchaseIv');
					}
					$(window).unload(function() {
						// debugger;
						// alert("INSIDE UNLOAD")
						localStorage.removeItem('purchaseIv');
					});

					$('#purchase_invoice_date').datetimepicker({
						minDate : "01/01/2016",
						format : 'DD/MM/YYYY',
						pickTime : false
					});
					$('#party_invoice_date').datetimepicker({
						format : 'DD/MM/YYYY',
						pickTime : false
					});
					$timeout(function() {
						$("#txtDueDate").datetimepicker({
							minDate : "01/01/2016",
							format : 'DD/MM/YYYY',
							pickTime : false
						});
					}, 1000);

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
					$scope.$watchCollection('[purchaseInvoiceData.puchaseInvoiceDate]',function(newValue, oldValue) {
						if ($scope.purchaseInvoiceData.puchaseInvoiceDate != '') {
							var frmDate = today;
							var toDate = $scope.purchaseInvoiceData.puchaseInvoiceDate;
							var splitarray = new Array();
							splitarray = frmDate.split(" ");
							var date = splitarray[0];
							var time = splitarray[1];
							frmDate = date.split("/");
							frmDate = new Date(frmDate[2],
									frmDate[1] - 1, frmDate[0]);
							toDate = toDate.split("/");
							toDate = new Date(toDate[2],
									toDate[1] - 1, toDate[0]);
							if (toDate >frmDate) {
								logger.logError("Invoice Date should be less or equal to current date");
								$scope.purchaseInvoiceData.puchaseInvoiceDate = today;
							}
						}
					});  
					
					$scope.getCurrentDate = function() {
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
						$scope.purchaseInvoiceData.puchaseInvoiceDate = today;
						$scope.purchaseInvoiceData.partyInvoiceDate = today;
						$scope.purchaseInvoiceData.dueDate = today;
						$scope.checkDatesCL = function(puchaseInvoiceDate) {
							var res = $scope.purchaseInvoiceData.puchaseInvoiceDate
									.split("/");
							$http
									.get(
											$stateParams.tenantid
													+ '/app/cashbankreceipt/getloggedcompany?closingDate='
													+ $scope.purchaseInvoiceData.puchaseInvoiceDate)
									.success(
											function(datas) {
												if (datas) {
													logger
															.logError("Account closed for year "
																	+ res[2]);
													$scope.purchaseInvoiceData.puchaseInvoiceDate = today;
												}
											})
											 debugger
											    $scope.modeType=2;
										        $http.get($stateParams.tenantid+'/jobOrderMonthClose/getInvoiceDateChk?mode=' + $scope.modeType +'&invoiceDate='+ $scope.purchaseInvoiceData.puchaseInvoiceDate + '&jobId=' + $scope.purchaseInvoiceData.jobNo).success(function(datas) {
										            if(datas){
										                logger.logError("Job Order Closed Pls Contact IT Support");
										                $scope.purchaseInvoiceData.puchaseInvoiceDate = today;
										                
									                 }
										        }) 			
											
						}

					}

					$scope.getCurrentDate();

					/**
					 * load Detail Table
					 */
					$scope.loadTable = function() {
						var table = {};
						table = {
							siNo : 1,
							accountHeadCode : '',
							unit : '',
							qty : '',
							rate : '',
							currency : '',
							exchangeRate : '',
							amount : '',
							taxAmount : '',
							unitName:'',
							taxPrct:'',
							chargeHead : '',
							chargeHeadId:''	
						};

						$scope.purchaseInvoiceData.purchaseInvoiceDetail
								.push(table);

					}

					$scope.loadTable();

					$scope.addRow = function(purchaseInvoiceDetail) {
						var len = purchaseInvoiceDetail.length;
						var table = {
							siNo : 1,
							accountHeadCode : '',
							unit : '',
							qty : '',
							rate : '',
							currency : '',
							exchangeRate : '',
							amount : '',
							taxAmount : '',
							unitName:'',
							taxPrct:'',
							chargeHead :''
						};
						table.siNo = len + 1;
						purchaseInvoiceDetail.push(table);

					};

					$scope.removeRow = function(purchaseInvoiceDetail) {
						$scope.tablerow = [];
						angular.forEach(purchaseInvoiceDetail, function(row,
								index) {
							var check = row.select;
							console.log(index);
							if (check == undefined || check == "") {
								$scope.tablerow.push(row);
							}
						});
						$scope.purchaseInvoiceData.purchaseInvoiceDetail = $scope.tablerow;

					};

					$scope.cancel = function() {
						$location
								.path($stateParams.tenantid
										+ "/invoice/purchaseinvoice/PurchaseInvoiceList");
					};

					$("#purchase_invoice_date").on("dp.change", function(e) {
						var from = $("#purchase_invoice_date").val();
						$("#party_invoice_date").val(from);
					});

					$("#txtDueDate").on(
							"dp.change",
							function(e) {
								$scope.purchaseInvoiceData.dueDate = $(
										'#txtDueDate').val();
							});

					/**
					 * Drop Down Functionality
					 */

					$scope.getDropdownvalue = function() {

						// new
						$http.get(
								$stateParams.tenantid
										+ '/app/purchaseinvoice/getJobList')
								.success(function(datas) {
									$scope.jobNoList = datas;
								}).error(function(datas) {
								});
						
						$http.get($stateParams.tenantid+'/app/jobOrderSea/dropDownList').success(function(datas) {
							debugger
						  //  $scope.quotationList = datas.quotationList;	
							$scope.customerList = datas.customerSelectivityList;
							$scope.consigneeDropList = datas.consigneeSelectivityList;
							$scope.shipperDropList = datas.shipperSelectivityList;
							$scope.nominatedDropList = datas.nominatedSelectivityList;
							$scope.vendorDropList = datas.vendorSelectivityList;
							$scope.serviceParnrDropList=datas.serviceParnrSelectivityList;
							$scope.customerBuyList = datas.buyServiceList;
							$scope.customerSellList = datas.sellServiceList;
							$scope.salesTypeList = datas.salesSelectivityList;
							$scope.employeeList = datas.employeeSelectivityList;
							$scope.servicePartnerTypelist = datas.serviceSelectivityList;
							$scope.PaymentMethodList = datas.paymentSelectivityList;
							$scope.transactionTypeList = datas.transactionSelectivityList;
							$scope.chargeHeadList = datas.airChargeHeadSelectivityList;
							$scope.TermList = datas.termsSelectivityList;
							$scope.UnitList = datas.unitSelectivityList;
							$scope.uomList = datas.uomList;	 
							$scope.sizeTypeList = datas.sizeTypeSelectivityList;
							$scope.commodityList = datas.commoditySelectivityList;	
							$scope.currencylist= datas.currecnySelectivityList;
							$scope.branchList = datas.branchSelectivityList;
						    $scope.portList = datas.airPortSelectivityList;
						}).error(function(data) {

						});
						
						/*$http
								.get(
										$stateParams.tenantid
												+ '/app/purchaseinvoice/getCustomerList')
								.success(function(datas) {
									$scope.customerList = datas;
								}).error(function(datas) {
								});
						$http.get(
								$stateParams.tenantid
										+ '/app/purchaseinvoice/getAolList')
								.success(function(datas) {
									$scope.aolList = datas;
								}).error(function(datas) {
								});
						$http.get(
								$stateParams.tenantid
										+ '/app/purchaseinvoice/getAodList')
								.success(function(datas) {
									$scope.aodList = datas;
								}).error(function(datas) {
								});*/
						

					};

					$scope.getDropdownvalue();

					
					 $scope.$watch('purchaseInvoiceData.jobNo', function(newValue,oldValue) {
						 
						 $scope.modeType=2;
					        $http.get($stateParams.tenantid+'/jobOrderMonthClose/getJobDate?mode=' + $scope.modeType +'&jobId='+ newValue).success(function(datas) {
					            if(datas){
					                logger.logError("Job Order Closed Pls Contact IT Support");
					                $scope.partyList=[];
				                 }else{
				                	 if (newValue != '' && newValue != undefined) {
											$http.post($stateParams.tenantid + '/app/purchaseinvoice/dropDownList?jobNo='+newValue).success(function(datas) {
												console.log(datas);
												$scope.partyList = datas.partyList;
											});
										}
				                 }
					        })

						});
					
					$scope
							.$watch(
									'purchaseInvoiceData.partyNo',
									function(newValue, oldValue) {
										if (newValue != ""
												&& newValue != undefined
												&& newValue != null) {
											$scope.tempDrfatStatus;
											$http.get($scope.tenant+ '/app/purchaseinvoice/getJobDetails?partyNo='+newValue +'&jobNo=' + $scope.purchaseInvoiceData.jobNo +'&status=' + $scope.tempDrfatStatus).success(function(data) {
																//$scope.purchaseInvoiceData.party = data.party;
												            $scope.purchaseInvoiceData.customerId=data.customerId.toString();
							                                $scope.purchaseInvoiceData.aolId=data.aolId.toString();    
							                                $scope.purchaseInvoiceData.aodId=data.aodId.toString(); 
							                                $scope.purchaseInvoiceData.originId=data.originId.toString(); 
							                                $scope.purchaseInvoiceData.destinationId=data.destinationId.toString(); 
							                                $scope.purchaseInvoiceData.bankId=data.bankId;
														    $scope.purchaseInvoiceData.flightNo = data.flightNo;
															$scope.purchaseInvoiceData.flightDate = data.flightDate;
																$scope.purchaseInvoiceData.bank = data.bank;
																$scope.bankList=data.bankList;
																$scope.mawbList=data.mawbList;
											                       $scope.hawbList=data.hawbList;
											                       if($scope.tempDrfatStatus==false)
											                	   {
																if(data.jobDetail.length!=0){
										                         	$scope.purchaseInvoiceData.purchaseInvoiceDetail=data.jobDetail;
										                           for(var i=0;i<data.jobDetail.length;i++) 
										                         	{
										                        	   $scope.purchaseInvoiceData.purchaseInvoiceDetail[i].chargeHeadId=data.jobDetail[i].chargeHeadId.toString();
										                  				$scope.purchaseInvoiceData.purchaseInvoiceDetail[i].unitId=data.jobDetail[i].unitId.toString();
										                  				$scope.purchaseInvoiceData.purchaseInvoiceDetail[i].currencyId=data.jobDetail[i].currencyId.toString();
										                  				$scope.purchaseInvoiceData.purchaseInvoiceDetail[i].isCgst=data.jobDetail[i].isCgst;
										                  				$scope.purchaseInvoiceData.purchaseInvoiceDetail[i].isIgst=data.jobDetail[i].isIgst;
										                         	}
										                           
										                         }else{
										                         	logger.logError("Already in Draft");
										                         	$scope.purchaseInvoiceData.purchaseInvoiceDetail='';
										                         }
																$scope.calAmt($scope.purchaseInvoiceData.purchaseInvoiceDetail);
											}	else{
						                    	   if(data.jobDetail.length!=0){
						                    		   for(var i=0;i<data.jobDetail.length;i++) 
						                            	{
						                    			   data.jobDetail[i].chargeHeadId=data.jobDetail[i].chargeHeadId.toString();
						                    			   data.jobDetail[i].unitId=data.jobDetail[i].unitId.toString();
						                    			   data.jobDetail[i].currencyId=data.jobDetail[i].currencyId.toString();
						                  				}
						                    		   for(var i=0;i<data.jobDetail.length;i++) 
						                            	{
						                  				$scope.purchaseInvoiceData.purchaseInvoiceDetail.push(data.jobDetail[i]);
						                    			}
						                    		   
						                    	   }
						                    	   $scope.calAmt($scope.purchaseInvoiceData.purchaseInvoiceDetail);
						                       }

															}).error(
															function(data) {
															});
										}
										
									});

				
				     $scope.calculateTaxAmt = function(taxper,row,table){
				    	   
				    	   var tax = (row.amount*taxper)/100;
				    	   row.taxAmount=tax.toFixed(2);
				    	   $scope.calAmt(table);
				    	   
				       }
					 
					$scope.calAmt = function(tables) {
				           
				           var Total = 0.0;
				           var TotalTax=0.0;
				           var TotalAmt=0.0;
				           
				               angular.forEach(tables, function (value, key) {
				            	   var check =value.select;
				                   if (check ==true) {
				        	   Total = parseFloat(value.amount)+Total;
				        	   TotalTax= parseFloat(value.taxAmount)+TotalTax;
				                   }               
				           });
				           $scope.purchaseInvoiceData.invoiceAmount = Total.toFixed(2);
				           $scope.purchaseInvoiceData.totaltaxAmount = TotalTax.toFixed(2);
				           TotalAmt=Total+TotalTax;
				           $scope.purchaseInvoiceData.totalAmount = TotalAmt.toFixed(2);
				           
				           
				       };
				       
				       $scope.selectAll = function(tables) {
				           debugger;
				           
				               angular.forEach(tables, function (value, key) {
				            	   var check =value.select;
				                   if ($scope.purchaseInvoiceData.selectBox ==true) {
				        	              value.select=true;
				        	             
				                   }else if($scope.purchaseInvoiceData.selectBox ==false) {
				                	   value.select=false;
				                   }
				                   $scope.calAmt(tables);
				           });
				          
				          
				       };
				       
					$scope.calculateTotAmount = function(tables) {
						debugger;
						var Total = 0.0;
						angular.forEach(tables, function(value, key) {
							Total = parseFloat(value.amount)
									+ parseFloat(value.taxAmount) + Total;

						});
						$scope.purchaseInvoiceData.totalAmount = Total
								.toFixed(2);

					};
					/*$scope.calTaxAmount = function() {
						var amt=0.0;
						
						for (var i = 0; i <= $scope.purchaseInvoiceData.purchaseInvoiceDetail.length; i++) {
							
							amt=$scope.purchaseInvoiceData.purchaseInvoiceDetail[i].amount*$scope.purchaseInvoiceData.purchaseInvoiceDetail[i].taxPrct/100;	
							$scope.purchaseInvoiceData.purchaseInvoiceDetail[i].taxAmount=amt.toFixed(2);
						}
						$scope.calAmt($scope.purchaseInvoiceData.purchaseInvoiceDetail);
					}*/
					
					$scope.tempDrfatStatus=false;
					 var tempPurchaseInvoiceDtl=[];
					var purchaseInvoiceNo=$stateParams.purchaseInvoiceNo;
				       if(purchaseInvoiceNo == undefined || purchaseInvoiceNo == null || purchaseInvoiceNo ==""){
				           $scope.edit=false;
				       }
				       else{
				           $scope.purchaseTable = true;
				           $scope.edit=true;
				           $scope.showSalesGrid=false;
				           $http.post($stateParams.tenantid + '/app/dashboard/checkWhichUser').success(function(data) {
				       		if (data[1].userId=='E0003'||data[1].userId=='E0008'||data[1].userId=='E0042'||data[1].userId=='E0043' ||data[1].userId=='E0016') {
				       			$scope.showSalesGrid=true;
				       			
				       			
				       		}

				       	}).error(function(data) {
				       		logger.logError("Error Please Try Again");
				       	});
				           $http.get($stateParams.tenantid+'/app/purchaseinvoice/getEditData?purInvNo='+purchaseInvoiceNo).success(function(result) {
				               $scope.purchaseInvoiceData = result;
				               $scope.purchaseInvoiceData.draftSave=true;
				               
				               $scope.tempDrfatStatus=true;
				               $scope.purchaseInvoiceData.jobNo= result.job.toString(); 
				               $scope.purchaseInvoiceData.partyNo= result.partyNo.toString();  
				               $scope.purchaseInvoiceData.customerId=result.customerId.toString();
				               $scope.purchaseInvoiceData.aolId=result.aolId.toString();    
				               $scope.purchaseInvoiceData.aodId=result.aodId.toString(); 
				               $scope.purchaseInvoiceData.originId=result.originId.toString(); 
				               $scope.purchaseInvoiceData.destinationId=result.destinationId.toString(); 
				               
				               $scope.purchaseInvoiceData.bankDtl=result.bankDtl.toString();
				               $scope.purchaseInvoiceData.bank=result.bank;
				               $scope.purchaseInvoiceData.puchaseInvoiceDate= result.purchaseInvoiceDate;
				               $scope.purchaseInvoiceData.departureDate=result.depatureDate;
				               $scope.purchaseInvoiceData.status=result.status.toString();
				               $scope.purchaseInvoiceData.hawb=result.hwbNo.toString();
				               $scope.purchaseInvoiceData.mawb=result.mwbNo.toString();
				               tempPurchaseInvoiceDtl=result.purchaseInvoiceDetail;
				               $scope.bankList=result.bankList;
				               $scope.hblList=result.hblList;
				               $scope.mblList=result.mblList;
				               
				               for(var j=0;j<= tempPurchaseInvoiceDtl.length;j++)  {
				          	    	
				                   $scope.purchaseInvoiceData.purchaseInvoiceDetail[j]['select']= true;  
				                   $scope.purchaseInvoiceData.purchaseInvoiceDetail[j].taxPrct=tempPurchaseInvoiceDtl[j].taxPrct;
				    			   $scope.purchaseInvoiceData.purchaseInvoiceDetail[j].taxAmount=tempPurchaseInvoiceDtl[j].taxAmount;
				    			   $scope.purchaseInvoiceData.purchaseInvoiceDetail[j].chargeHeadId=tempPurchaseInvoiceDtl[j].chargeHeadId.toString();
				      			   $scope.purchaseInvoiceData.purchaseInvoiceDetail[j].unitId=tempPurchaseInvoiceDtl[j].unitId.toString();
				      				$scope.purchaseInvoiceData.purchaseInvoiceDetail[j].currencyId=tempPurchaseInvoiceDtl[j].currencyId.toString();
				      				$scope.purchaseInvoiceData.purchaseInvoiceDetail[j].isCgst=tempPurchaseInvoiceDtl[j].isCgst;
				      				$scope.purchaseInvoiceData.purchaseInvoiceDetail[j].isIgst=tempPurchaseInvoiceDtl[j].isIgst;
				                 }
				                   $scope.calAmt($scope.purchaseInvoiceData.purchaseInvoiceDetail);
				               
				           }).error(function(data) {
				           });
				       }
				       
					
					
					/**
					 * Edit functionality
					 *//*
					$scope.isEdit1 = false;
					var purchaseInvoiceNo = $stateParams.purchaseInvoiceNo;
					if (purchaseInvoiceNo == undefined
							|| purchaseInvoiceNo == null
							|| purchaseInvoiceNo == "") {
						$scope.edit = false;
					} else {
						// fetching edit details
						$scope.edit = true;
						$http
								.get(
										$stateParams.tenantid
												+ '/app/purchaseinvoice/getPurchaseInvoiceDetail?purchaseInvoiceNo='
												+ purchaseInvoiceNo)
								.success(
										function(data) {
											$scope.isEdit1 = true;
											$scope.subAccountList = data.subAccountCodeList;
											$scope.purchaseOrderList = data.pOList;

											$scope.purchaseInvoiceData = data;
											console
													.log("$scope.purchaseInvoiceDatacopy");
											console
													.log($scope.purchaseInvoiceData);
											$scope
													.calculateTotalAmount($scope.purchaseInvoiceData.purchaseInvoiceDetail);
										}).error(function(data) {
								});
					}

					 edit and draft functionality 

					var purchaseInvoiceNo = $stateParams.purchaseInvoiceNo1;
					if (purchaseInvoiceNo == undefined
							|| purchaseInvoiceNo == null
							|| purchaseInvoiceNo == "") {
						$scope.edit = false;
					} else {
						// fetching edit details
						$scope.edit = true;
						$http
								.get(
										$stateParams.tenantid
												+ '/app/purchaseinvoice/getPurchaseInvoiceDetailDraft?purchaseInvoiceNo='
												+ purchaseInvoiceNo)
								.success(
										function(data) {
											$scope.isEdit1 = true;
											$scope.subAccountList = data.subAccountCodeList;
											$scope.purchaseOrderList = data.pOList;

											$scope.purchaseInvoiceData = data;
											console
													.log("$scope.purchaseInvoiceDatadraft");
											console
													.log($scope.purchaseInvoiceData);
											$scope
													.calculateTotalAmount($scope.purchaseInvoiceData.purchaseInvoiceDetail);
										}).error(function(data) {
								});
					}*/
					/**
					 * save and update functionality
					 * 
					 * validation submit -
					 * $scope.onSubmit(purchaseInvoiceForm,purchaseInvoiceData);
					 */

					$scope.onSubmit = function(purchaseInvoiceForm,
							purchaseInvoiceData) {
						console.log($scope.purchaseInvoiceData);
						// $scope.purchaseInvoiceData.puchaseInvoiceDate =
						// $('#purchase_invoice_date').val();
						$scope.purchaseInvoiceData.partyInvoiceDate = $(
								'#party_invoice_date').val();
						$scope.purchaseInvoiceData.dueDate = $('#txtDueDate')
								.val();

						if (new validationService()
								.checkFormValidity($scope.purchaseInvoiceForm)) {
							$scope.save();
						} else {
							toaster
									.pop(
											'error',
											"Please fill the required fields",
											logger
													.getErrorHtmlNew($scope.purchaseInvoiceForm.$validationSummary),
											5000, 'trustedHtml');
						}
					};
					
					$scope.onSubmitDraft = function(purchaseInvoiceForm,purchaseInvoiceData) {
				           console.log($scope.purchaseInvoiceData);
				           // $scope.purchaseInvoiceData.puchaseInvoiceDate =
							// $('#purchase_invoice_date').val();
				           $scope.purchaseInvoiceData.partyInvoiceDate = $('#party_invoice_date').val();
				           $scope.purchaseInvoiceData.dueDate = $('#txtDueDate').val();
				           
				           if (new validationService().checkFormValidity($scope.purchaseInvoiceForm)) {
				               $scope.saveDraft();
				           } else {
				               toaster.pop('error', "Please fill the required fields", 
				                       logger.getErrorHtmlNew($scope.purchaseInvoiceForm.$validationSummary), 5000, 'trustedHtml');
				           }
				       };
				       
				       $scope.onSubmitDraft1 = function(purchaseInvoiceForm,purchaseInvoiceData) {
				           console.log($scope.purchaseInvoiceData);
				           // $scope.purchaseInvoiceData.puchaseInvoiceDate =
							// $('#purchase_invoice_date').val();
				           $scope.purchaseInvoiceData.partyInvoiceDate = $('#party_invoice_date').val();
				           $scope.purchaseInvoiceData.dueDate = $('#txtDueDate').val();
				           
				           if (new validationService().checkFormValidity($scope.purchaseInvoiceForm)) {
				               $scope.saveDraft1();
				           } else {
				               toaster.pop('error', "Please fill the required fields", 
				                       logger.getErrorHtmlNew($scope.purchaseInvoiceForm.$validationSummary), 5000, 'trustedHtml');
				           }
				       };

					/**
					 * save and update functionality
					 * 
					 * after validation submit -
					 * $scope.onSubmit(purchaseInvoiceForm,purchaseInvoiceData);
					 */

					// save
					$scope.save = function(purchaseInvoiceForm,
							purchaseInvoiceData) {

						console
								.log("$scope.purchaseInvoiceData:::::::::SAVE:::::::::::::::::");
						console.log($scope.purchaseInvoiceData);
						$scope.approvedData=[];
						$scope.rejectData=[];
					    $scope.purchaseInvoiceData.purchaseInvoiceDetailRejectList= [];
					    $scope.tempData=[];
					    $scope.tempData=$scope.purchaseInvoiceData.purchaseInvoiceDetail;
					       angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceDetail, function(row, index) {
					           var check =row.select;
					           if (check ==true) {
					               $scope.approvedData.push(row);  
					               $scope.purchaseInvoiceData.purchaseInvoiceDetail=$scope.approvedData;
					           }else{
					        	   $scope.rejectData.push(row);  
					               $scope.purchaseInvoiceData.purchaseInvoiceDetailRejectList=$scope.rejectData;
					           }
					           
					           
					       });
					       $scope.purchaseInvoiceData.draftSave=false;

				           $scope.purchaseInvoiceData.isSaveDraft=false;
						debugger;
						if($scope.approvedData.length >0){
						$http
								.post(
										$stateParams.tenantid
												+ '/app/purchaseinvoice/savePurInv',
										$scope.purchaseInvoiceData)
								.success(
										function(result) {
											if (result.success) {
												console.log(result)
												$location
														.path($stateParams.tenantid
																+ "/invoice/purchaseinvoice/PurchaseInvoiceList");
												logger
														.logSuccess("Purchase Invoice added successfully");

											} else {
												if (result.message != null
														&& result.message != '') {
													logger
															.logError(result.message);
													 $scope.purchaseInvoiceData.purchaseInvoiceDetail=$scope.tempData;
												} else {
													logger
															.logError("Error try again");
													 $scope.purchaseInvoiceData.purchaseInvoiceDetail=$scope.tempData;
												}
											}

										}).error(function(data) {
									console.log(data);
								});
						}else{
					           logger.logError("Please select atleast one row to save !..");
					       } 

					}
					
					// save Draft //
		              
		            $scope.saveDraft = function(){
		                   console.log("$scope.purchaseInvoiceData:::::::::SAVEDraft:::::::::::::::::");
		                   console.log($scope.purchaseInvoiceData); 
		                   $scope.approvedData=[];
		                   $scope.tempData=[];
		                   $scope.tempData=$scope.purchaseInvoiceData.purchaseInvoiceDetail;
		                   angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceDetail, function(row, index) {
		                       var check =row.select;
		                       if (check ==true) {
		                           $scope.approvedData.push(row);  
		                           $scope.purchaseInvoiceData.purchaseInvoiceDetail=$scope.approvedData;
		                       }
		                       
		                   });
		                   $scope.purchaseInvoiceData.draftSave=false;

		                   $scope.purchaseInvoiceData.isSaveDraft = true;
		                   if($scope.approvedData.length >0){
		                   $http.post($stateParams.tenantid+'/app/purchaseinvoice/savePurInv', $scope.purchaseInvoiceData).success(function(result) {
		                       if (result.success) {
		                           console.log(result)
		                           $location.path($stateParams.tenantid+"/invoice/purchaseinvoice/PurchaseInvoiceList");
		                           logger.logSuccess("Purchase Invoice Draft Added successfully");
		               
		                       } else {
		                           if(result.message != null && result.message != ''){
		                               logger.logError(result.message);
		                               $scope.purchaseInvoiceData.purchaseInvoiceDetail=$scope.tempData;
		                           }else{
		                           logger.logError("Error try again");
		                           $scope.purchaseInvoiceData.purchaseInvoiceDetail=$scope.tempData;
		                           }
		                       }

		                   }).error(function(data) {
		                       console.log(data);
		                   });
		                   }else{
		                       logger.logError("Please select atleast one row to save !..");
		                   }
		       }
		            
		            
		            $scope.saveDraft1 = function(){
		                   console.log("$scope.purchaseInvoiceData:::::::::SAVEDraft:::::::::::::::::");
		                   console.log($scope.purchaseInvoiceData); 
		                   $scope.approvedData=[];
		                   $scope.rejectData=[];
		                   $scope.purchaseInvoiceData.purchaseInvoiceDetailRejectList= [];
		                   $scope.tempData=[];
		                   $scope.tempData=$scope.purchaseInvoiceData.purchaseInvoiceDetail;
		                   angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceDetail, function(row, index) {
		                       var check =row.select;
		                       if (check ==true) {
		                           $scope.approvedData.push(row);  
		                           $scope.purchaseInvoiceData.purchaseInvoiceDetail=$scope.approvedData;
		                       }
		                       else{
		                    	   $scope.rejectData.push(row);  
		                           $scope.purchaseInvoiceData.purchaseInvoiceDetailRejectList=$scope.rejectData;
		                       }
		                       
		                   });
		                   $scope.purchaseInvoiceData.draftSave=true;
		                   $scope.purchaseInvoiceData.isSaveDraft = true;
		                   if($scope.approvedData.length >0){
		                   $http.post($stateParams.tenantid+'/app/purchaseinvoice/savePurInv', $scope.purchaseInvoiceData).success(function(result) {
		                       if (result.success) {
		                           console.log(result)
		                           $location.path($stateParams.tenantid+"/invoice/purchaseinvoice/PurchaseInvoiceList");
		                           logger.logSuccess("Purchase Invoice Draft Added successfully");
		               
		                       } else {
		                           if(result.message != null && result.message != ''){
		                               logger.logError(result.message);
		                               $scope.purchaseInvoiceData.purchaseInvoiceDetail=$scope.tempData;
		                           }else{
		                           logger.logError("Error try again");
		                           $scope.purchaseInvoiceData.purchaseInvoiceDetail=$scope.tempData;
		                           }
		                       }

		                   }).error(function(data) {
		                       console.log(data);
		                   });
		                   }else{
		                       logger.logError("Please select atleast one row to save !..");
		                   }
		       }
		       // save Draft//

					$scope.showTax = function(accountHeadCode, jobNo,partyNo) {

						if (accountHeadCode != "") {
							ngDialog
									.open({
										scope : $scope,
										template : 'views/finance/invoice/purchaseinvoice/PurchaseInvoiceTaxView',
										controller : $controller(
												'purchaseInvoiceTaxCtrl',
												{
													$scope : $scope,
													purchaseObject : $scope.purchaseInvoiceData,
													accountHeadCode : accountHeadCode,
													jobNo : jobNo,
													partyNo:partyNo
												}),
										className : 'ngdialog-theme-plain',
										showClose : false,
										closeByDocument : false,
										closeByEscape : false,
										preCloseCallback : $scope.getList
									});
						} else {
							logger.logError("Please Select Job No..");
						}

					}
					
				    
				     //print usd
				       $scope.printUsdForm = function(purchaseInvoiceForm,purchaseInvoiceData) {
				          
				           
				           $scope.purchaseInvoiceData.partyInvoiceDate = $('#party_invoice_date').val();
				           $scope.purchaseInvoiceData.dueDate = $('#txtDueDate').val();
				           
				           if (new validationService().checkFormValidity($scope.purchaseInvoiceForm)) {
				               $scope.printUsd();
				           } else {
				               toaster.pop('error', "Please fill the required fields", 
				                       logger.getErrorHtmlNew($scope.purchaseInvoiceForm.$validationSummary), 5000, 'trustedHtml');
				           }
				       };
                      $scope.printUsdFormDraft = function(purchaseInvoiceForm,purchaseInvoiceData) {
				          
				           
				           $scope.purchaseInvoiceData.partyInvoiceDate = $('#party_invoice_date').val();
				           $scope.purchaseInvoiceData.dueDate = $('#txtDueDate').val();
				           
				           if (new validationService().checkFormValidity($scope.purchaseInvoiceForm)) {
				               $scope.printUsdDraft();
				           } else {
				               toaster.pop('error', "Please fill the required fields", 
				                       logger.getErrorHtmlNew($scope.purchaseInvoiceForm.$validationSummary), 5000, 'trustedHtml');
				           }
				       };
				       
				       $scope.printUsd = function(){
				           $scope.approvedData=[];
				           $scope.tempData=[];
				           $scope.tempData=$scope.purchaseInvoiceData.purchaseInvoiceDetail;
				           angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceDetail, function(row, index) {
				               var check =row.select;
				               if (check ==true) {
				                   $scope.approvedData.push(row);  
				                   $scope.purchaseInvoiceData.purchaseInvoiceDetail=$scope.approvedData;
				               }
				           });
				          
				           if($scope.approvedData.length >0){
				        	      $scope.purchaseInvoiceData.isSaveDraft=false;
				        	      $scope.purchaseInvoiceData.printNumber=1,
				        	      $scope.purchaseInvoiceData.currSymbol='Usd',
				                  
				        	      $http.post($stateParams.tenantid+'/app/purchaseinvoice/savePurInvPreview', $scope.purchaseInvoiceData).success(function(result) {
				                      if (result.success) {
				                          console.log(result)
				                          var url = $stateParams.tenantid+'/app/purchaseinvoice/printusdairInr?purInvNo=' + result.purchaseInvoiceNo1 +'&printNumber='+$scope.purchaseInvoiceData.printNumber+ '&currSymbol=' +$scope.purchaseInvoiceData.currSymbol;
				                          var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
				                          wnd.print();   
				                          $scope.purchaseInvoiceData.purchaseInvoiceDetail=$scope.tempData;
				                      } else {
				                          if(result.message != null && result.message != ''){
				                              logger.logError(result.message);
				                          }else{
				                          logger.logError("Error try again");
				                          }
				                      }

				                  }).error(function(data) {
				                      console.log(data);
				                  });
				           }else{
				               logger.logError("Please select atleast one row to Preview Invoice!..");
				           }     
				           }
				       
				       $scope.printUsdDraft = function(){
				           $scope.approvedData=[];
				           $scope.tempData=[];
				           $scope.tempData=$scope.purchaseInvoiceData.purchaseInvoiceDetail;
				           angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceDetail, function(row, index) {
				               var check =row.select;
				               if (check ==true) {
				                   $scope.approvedData.push(row);  
				                   $scope.purchaseInvoiceData.purchaseInvoiceDetail=$scope.approvedData;
				               }
				           });
				          
				           if($scope.approvedData.length >0){
				        	      $scope.purchaseInvoiceData.isSaveDraft=true;
				        	      $scope.purchaseInvoiceData.printNumber=1,
				        	      $scope.purchaseInvoiceData.currSymbol='Usd',
				                  
				        	      $http.post($stateParams.tenantid+'/app/purchaseinvoice/savePurInvPreview', $scope.purchaseInvoiceData).success(function(result) {
				                      if (result.success) {
				                          console.log(result)
				                          var url = $stateParams.tenantid+'/app/purchaseinvoice/printusdairInr?purInvNo=' + result.purchaseInvoiceNo1 +'&printNumber='+$scope.purchaseInvoiceData.printNumber+ '&currSymbol=' +$scope.purchaseInvoiceData.currSymbol;
				                          var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
				                          wnd.print();   
				                          $scope.purchaseInvoiceData.purchaseInvoiceDetail=$scope.tempData;
				                      } else {
				                          if(result.message != null && result.message != ''){
				                              logger.logError(result.message);
				                          }else{
				                          logger.logError("Error try again");
				                          }
				                      }

				                  }).error(function(data) {
				                      console.log(data);
				                  });
				           }else{
				               logger.logError("Please select atleast one row to Preview Invoice!..");
				           }     
				           }
				       //print usd Ends
				       
				       
				     //print SGD
				       $scope.printSgdForm = function(purchaseInvoiceForm,purchaseInvoiceData) {
				          
				           
				           $scope.purchaseInvoiceData.partyInvoiceDate = $('#party_invoice_date').val();
				           $scope.purchaseInvoiceData.dueDate = $('#txtDueDate').val();
				           
				           if (new validationService().checkFormValidity($scope.purchaseInvoiceForm)) {
				               $scope.printSgd();
				           } else {
				               toaster.pop('error', "Please fill the required fields", 
				                       logger.getErrorHtmlNew($scope.purchaseInvoiceForm.$validationSummary), 5000, 'trustedHtml');
				           }
				       };
                      $scope.printSgdFormDraft = function(purchaseInvoiceForm,purchaseInvoiceData) {
				          
				           
				           $scope.purchaseInvoiceData.partyInvoiceDate = $('#party_invoice_date').val();
				           $scope.purchaseInvoiceData.dueDate = $('#txtDueDate').val();
				           
				           if (new validationService().checkFormValidity($scope.purchaseInvoiceForm)) {
				               $scope.printSgdDraft();
				           } else {
				               toaster.pop('error', "Please fill the required fields", 
				                       logger.getErrorHtmlNew($scope.purchaseInvoiceForm.$validationSummary), 5000, 'trustedHtml');
				           }
				       };
				       
				       $scope.printSgd = function(){
				           $scope.approvedData=[];
				           $scope.tempData=[];
				           $scope.tempData=$scope.purchaseInvoiceData.purchaseInvoiceDetail;
				           angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceDetail, function(row, index) {
				               var check =row.select;
				               if (check ==true) {
				                   $scope.approvedData.push(row);  
				                   $scope.purchaseInvoiceData.purchaseInvoiceDetail=$scope.approvedData;
				               }
				           });
				          
				           if($scope.approvedData.length >0){
				        	      $scope.purchaseInvoiceData.isSaveDraft=false;
				        	      $scope.purchaseInvoiceData.printNumber=4,
				        	      $scope.purchaseInvoiceData.currSymbol='Sgd',
				                  
				        	      $http.post($stateParams.tenantid+'/app/purchaseinvoice/savePurInvPreview', $scope.purchaseInvoiceData).success(function(result) {
				                      if (result.success) {
				                          console.log(result)
				                          var url = $stateParams.tenantid+'/app/purchaseinvoice/printusdairInr?purInvNo=' + result.purchaseInvoiceNo1 +'&printNumber='+$scope.purchaseInvoiceData.printNumber+ '&currSymbol=' +$scope.purchaseInvoiceData.currSymbol;
				                          var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
				                          wnd.print();   
				                          $scope.purchaseInvoiceData.purchaseInvoiceDetail=$scope.tempData;
				                      } else {
				                          if(result.message != null && result.message != ''){
				                              logger.logError(result.message);
				                          }else{
				                          logger.logError("Error try again");
				                          }
				                      }

				                  }).error(function(data) {
				                      console.log(data);
				                  });
				           }else{
				               logger.logError("Please select atleast one row to Preview Invoice!..");
				           }     
				           }
				       
				       $scope.printSgdDraft = function(){
				           $scope.approvedData=[];
				           $scope.tempData=[];
				           $scope.tempData=$scope.purchaseInvoiceData.purchaseInvoiceDetail;
				           angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceDetail, function(row, index) {
				               var check =row.select;
				               if (check ==true) {
				                   $scope.approvedData.push(row);  
				                   $scope.purchaseInvoiceData.purchaseInvoiceDetail=$scope.approvedData;
				               }
				           });
				          
				           if($scope.approvedData.length >0){
				        	      $scope.purchaseInvoiceData.isSaveDraft=true;
				        	      $scope.purchaseInvoiceData.printNumber=4,
				        	      $scope.purchaseInvoiceData.currSymbol='Sgd',
				                  
				        	      $http.post($stateParams.tenantid+'/app/purchaseinvoice/savePurInvPreview', $scope.purchaseInvoiceData).success(function(result) {
				                      if (result.success) {
				                          console.log(result)
				                          var url = $stateParams.tenantid+'/app/purchaseinvoice/printusdairInr?purInvNo=' + result.purchaseInvoiceNo1 +'&printNumber='+$scope.purchaseInvoiceData.printNumber+ '&currSymbol=' +$scope.purchaseInvoiceData.currSymbol;
				                          var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
				                          wnd.print();   
				                          $scope.purchaseInvoiceData.purchaseInvoiceDetail=$scope.tempData;
				                      } else {
				                          if(result.message != null && result.message != ''){
				                              logger.logError(result.message);
				                          }else{
				                          logger.logError("Error try again");
				                          }
				                      }

				                  }).error(function(data) {
				                      console.log(data);
				                  });
				           }else{
				               logger.logError("Please select atleast one row to Preview Invoice!..");
				           }     
				           }
				       //print SGD Ends
				       
				       
				       
				       //print inr
				       $scope.printInrForm = function(purchaseInvoiceForm,purchaseInvoiceData) {
				           
				           
				           $scope.purchaseInvoiceData.partyInvoiceDate = $('#party_invoice_date').val();
				           $scope.purchaseInvoiceData.dueDate = $('#txtDueDate').val();
				           
				           if (new validationService().checkFormValidity($scope.purchaseInvoiceForm)) {
				               $scope.printInr();
				           } else {
				               toaster.pop('error', "Please fill the required fields", 
				                       logger.getErrorHtmlNew($scope.purchaseInvoiceForm.$validationSummary), 5000, 'trustedHtml');
				           }
				       };
				       
                       $scope.printInrFormDraft = function(purchaseInvoiceForm,purchaseInvoiceData) {
				           
				           
				           $scope.purchaseInvoiceData.partyInvoiceDate = $('#party_invoice_date').val();
				           $scope.purchaseInvoiceData.dueDate = $('#txtDueDate').val();
				           
				           if (new validationService().checkFormValidity($scope.purchaseInvoiceForm)) {
				               $scope.printInrDraft();
				           } else {
				               toaster.pop('error', "Please fill the required fields", 
				                       logger.getErrorHtmlNew($scope.purchaseInvoiceForm.$validationSummary), 5000, 'trustedHtml');
				           }
				       };
				       
				       $scope.printInr = function(){
				           $scope.approvedData=[];
				           $scope.tempData=[];
				           $scope.tempData=$scope.purchaseInvoiceData.purchaseInvoiceDetail;
				           angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceDetail, function(row, index) {
				               var check =row.select;
				               if (check ==true) {
				                   $scope.approvedData.push(row);  
				                   $scope.purchaseInvoiceData.purchaseInvoiceDetail=$scope.approvedData;
				               }
				           });
				          
				           if($scope.approvedData.length >0){
				        	      $scope.purchaseInvoiceData.isSaveDraft=false;
				        	      $scope.purchaseInvoiceData.printNumber=2,
				        	      $scope.purchaseInvoiceData.currSymbol='Inr',
				        	      
				        	      $http.post($stateParams.tenantid+'/app/purchaseinvoice/savePurInvPreview', $scope.purchaseInvoiceData).success(function(result) {
				                      if (result.success) {
				                          console.log(result)
				                          var url = $stateParams.tenantid+'/app/purchaseinvoice/printusdairInr?purInvNo=' + result.purchaseInvoiceNo1 +'&printNumber='+$scope.purchaseInvoiceData.printNumber+ '&currSymbol=' +$scope.purchaseInvoiceData.currSymbol;
				                          var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
				                          wnd.print();   
				                          $scope.purchaseInvoiceData.purchaseInvoiceDetail=$scope.tempData;
				                      } else {
				                          if(result.message != null && result.message != ''){
				                              logger.logError(result.message);
				                          }else{
				                          logger.logError("Error try again");
				                          }
				                      }

				                  }).error(function(data) {
				                      console.log(data);
				                  });
				        	      
				        	     
				           }else{
				               logger.logError("Please select atleast one row to Preview Invoice!..");
				           }     
				           }
				       
				       $scope.printInrDraft = function(){
				           $scope.approvedData=[];
				           $scope.tempData=[];
				           $scope.tempData=$scope.purchaseInvoiceData.purchaseInvoiceDetail;
				           angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceDetail, function(row, index) {
				               var check =row.select;
				               if (check ==true) {
				                   $scope.approvedData.push(row);  
				                   $scope.purchaseInvoiceData.purchaseInvoiceDetail=$scope.approvedData;
				               }
				           });
				          
				           if($scope.approvedData.length >0){
				        	      $scope.purchaseInvoiceData.isSaveDraft=true;
				        	      $scope.purchaseInvoiceData.printNumber=2,
				        	      $scope.purchaseInvoiceData.currSymbol='Inr',
				        	      
				        	      $http.post($stateParams.tenantid+'/app/purchaseinvoice/savePurInvPreview', $scope.purchaseInvoiceData).success(function(result) {
				                      if (result.success) {
				                          console.log(result)
				                          var url = $stateParams.tenantid+'/app/purchaseinvoice/printusdairInr?purInvNo=' + result.purchaseInvoiceNo1 +'&printNumber='+$scope.purchaseInvoiceData.printNumber+ '&currSymbol=' +$scope.purchaseInvoiceData.currSymbol;
				                          var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
				                          wnd.print();   
				                          $scope.purchaseInvoiceData.purchaseInvoiceDetail=$scope.tempData;
				                      } else {
				                          if(result.message != null && result.message != ''){
				                              logger.logError(result.message);
				                          }else{
				                          logger.logError("Error try again");
				                          }
				                      }

				                  }).error(function(data) {
				                      console.log(data);
				                  });
				        	      
				        	     
				           }else{
				               logger.logError("Please select atleast one row to Preview Invoice!..");
				           }     
				           }
				       //print inr Ends    

				});
app.controller('purchaseInvoiceTaxCtrl', function($scope, $rootScope,
		sharedProperties, logger, $http, $filter, $location, $stateParams,
		validationService, toaster, $window, purchaseObject, ngDialog,
		$timeout, accountHeadCode, jobNo,partyNo) {
	$scope.rowCollection=[];
	$http.get(
			$stateParams.tenantid + '/app/salesinvoice/getTaxList?chargeHead='
					+ accountHeadCode + '&jobNo=' + jobNo + '&partyNo=' + partyNo).success(
			function(response) {
				if(response.taxList.length>0){
 					$scope.rowCollection = response.taxList;
 				}
 				else{
 					logger.logError("There are no Tax Types defined for the seleted Charge Head..");
 				}
			});

	$scope.cancelng = function() {
		// $scope.purchaseInvoiceData.purInvDueDateDtls = [];
		ngDialog.close();
		if (purchaseObject.purInvDueDateDtls.length > 0) {

		} else {
			$scope.purchaseInvoiceData.purInvDueDateDtls = [];
		}
	}
});

app
		.controller(
				'purchaseInvoiceViewCtrl',
				function($scope, $rootScope, sharedProperties, logger, $http,
						$filter, $location, $stateParams, validationService,
						toaster, $window, $state,ngDialog) {

					$scope.purchaseTable = false;

					var purchaseInvoiceNo = $stateParams.purchaseInvoiceSNo;
					if (purchaseInvoiceNo == undefined
							|| purchaseInvoiceNo == null
							|| purchaseInvoiceNo == "") {
						$scope.edit = false;
					}
					// fetching edit details
					else {
						$scope.edit = true;
						$http
								.get(
										$stateParams.tenantid
												+ '/app/purchaseinvoice/getViewData?purInvNo='
												+ purchaseInvoiceNo).success(
										function(data) {
											debugger;
											 var totalTaxAmt=0; 
									            $scope.purchaseInvoiceData = data; 
									            for(var i=0;i< $scope.purchaseInvoiceData.purchaseInvoiceDetail.length;i++)
									            { totalTaxAmt=totalTaxAmt+$scope.purchaseInvoiceData.purchaseInvoiceDetail[i].taxAmount; } 
									            $scope.purchaseInvoiceData['totaltaxAmount']=totalTaxAmt.toFixed(2);
										}).error(function(data) {
								});
					}

					$scope.cancel = function() {
						$location.path($stateParams.tenantid+ "/invoice/purchaseinvoice/PurchaseInvoiceList");
					};

					$scope.cancel1 = function() {
						$state.go('app.reports.finance.invoiceInformation', {
							tenantid : $stateParams.tenantid
						});
					};

					// invoiceCancel
					$scope.deleteInvoice = function(sNo) {
						ngDialog
								.openConfirm()
								.then(
										function() {
											$http.post($stateParams.tenantid + '/app/purchaseinvoice/cancel?sNo=',+ sNo).success(function(data) {
										    logger.logSuccess('Invoice Canceled Successfully.')
										    $location.path($stateParams.tenantid+ "/invoice/purchaseinvoice/PurchaseInvoiceList");
											}).error(function(data) {
									    });
								});
					};

					/**
					 * print PIN...
					 */
					$scope.printPurchaseInvoice = function(purchaseInvoiceSno) {
						$scope.purchaseInvoiceData.printNumber=1,
		        	      $scope.purchaseInvoiceData.currSymbol='Usd'
		        	    var url = $stateParams.tenantid+'/app/purchaseinvoice/printfinalusdairInr?purInvNo=' + purchaseInvoiceSno +'&printNumber='+$scope.purchaseInvoiceData.printNumber+ '&currSymbol=' +$scope.purchaseInvoiceData.currSymbol;
                        var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
                        wnd.print(); 
					}
					
					$scope.printPurchaseInvoiceSgd = function(purchaseInvoiceSno) {
						$scope.purchaseInvoiceData.printNumber=4,
		        	      $scope.purchaseInvoiceData.currSymbol='Sgd'
		        	    var url = $stateParams.tenantid+'/app/purchaseinvoice/printfinalusdairInr?purInvNo=' + purchaseInvoiceSno +'&printNumber='+$scope.purchaseInvoiceData.printNumber+ '&currSymbol=' +$scope.purchaseInvoiceData.currSymbol;
                        var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
                        wnd.print(); 
					}
					
					$scope.printPurchaseInvoicelocal= function(purchaseInvoiceSno){
						$scope.purchaseInvoiceData.printNumber=2,
		        	      $scope.purchaseInvoiceData.currSymbol='Inr' 
		        	    	  var url = $stateParams.tenantid+'/app/purchaseinvoice/printfinalusdairInr?purInvNo=' + purchaseInvoiceSno +'&printNumber='+$scope.purchaseInvoiceData.printNumber+ '&currSymbol=' +$scope.purchaseInvoiceData.currSymbol;
                        var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
                        wnd.print(); 
				     }
					
					 $scope.quickLinkMethd=function(qulkVal){
							if(qulkVal!='Select'){
								if($scope.purchaseInvoiceData.purchaseInvoiceSno!='' && $scope.purchaseInvoiceData.purchaseInvoiceSno!=undefined){
								$http.post($stateParams.tenantid + '/app/purchaseinvoice/getQuickLinkId?category='+qulkVal+'&prchsInvNo='+$scope.purchaseInvoiceData.purchaseInvoiceSno).success(function(datas) {
											if(datas.quickLinkId!=null){
												var rowid=datas.quickLinkId;
												if(qulkVal=="Job Order"){
													if(rowid !=0){
														$location.url($stateParams.tenantid+'/jobOrderAir/edit?rowid='+rowid);
													//	$window.open('#'+$stateParams.tenantid+'/jobOrderSea/view?rowid='+rowid, '_blank');	
													}else{
														logger.logError("There is no "+qulkVal);
													}
												}else if(qulkVal=="HAWB"){
													if(rowid !=0){
														$location.url($stateParams.tenantid+'/hbw/edit?rowid='+rowid);
														//$window.open('#'+$stateParams.tenantid+'/hbl/view?rowid='+rowid, '_blank');
													}else{
														logger.logError("There is no "+qulkVal);
													}
												}else if(qulkVal=="MAWB"){
													if(rowid !=0){
														$location.url($stateParams.tenantid+'/mabw/edit?rowid='+rowid);
														//$window.open('#'+$stateParams.tenantid+'/mabl/view?rowid='+rowid,'_blank');
													}else{
														logger.logError("There is no "+qulkVal);
													}
												}else if(qulkVal=="Delivery Order"){
													if(rowid !=0){
														$location.url($stateParams.tenantid+'/airdeliveryorder/edit?rowid='+rowid);
														//$window.open('#'+$stateParams.tenantid+'/deliveryorder/view?rowid='+rowid,'_blank');	
													}else{
														logger.logError("There is no "+qulkVal);
													}
												}else if(qulkVal=="Sales Invoice"){
													if(rowid !=0){
														$location.url($stateParams.tenantid+'/invoice/purchaseinvoice/PurchaseInvoiceView'+rowid);
														//$window.open('#'+$stateParams.tenantid+"/invoice/seasalesinvoice/salesInvoiceView/"+rowid,'_blank');	
													}else{
														logger.logError("There is no "+qulkVal);
													}
												}
											} else if(datas.quickLinkIdList!=null){var quickLinkIdList=datas.quickLinkIdList;
											if(qulkVal=="HAWB"){
												$location.url($stateParams.tenantid+'/hbw/list?quickLinkIdList='+quickLinkIdList);
												//$window.open('#'+$stateParams.tenantid+'/hbw/list?quickLinkIdList='+quickLinkIdList, '_blank');
											}else if(qulkVal=="MAWB"){
												$location.url($stateParams.tenantid+'/mabw/list?quickLinkIdList='+quickLinkIdList);
												//$window.open('#'+$stateParams.tenantid+'/mabw/list?quickLinkIdList='+quickLinkIdList, '_blank');
											}else if(qulkVal=="Delivery Order"){
												$location.url($stateParams.tenantid+'/airdeliveryorder/list?quickLinkIdList='+quickLinkIdList);
												//$window.open('#'+$stateParams.tenantid+'/airdeliveryorder/list?quickLinkIdList='+quickLinkIdList, '_blank');
											}else if(qulkVal=="Sales Invoice"){ 
												$location.url($stateParams.tenantid+'/invoice/salesinvoice/SalesInvoiceList?quickLinkIdList='+quickLinkIdList);
												//$window.open('#'+$stateParams.tenantid+'/invoice/salesinvoice/SalesInvoiceList?quickLinkIdList='+quickLinkIdList,'_blank');
											}else if(qulkVal=="Job Order"){
												$location.url($stateParams.tenantid+'/joborder/list?quickLinkIdList='+quickLinkIdList);
												//$window.open('#'+$stateParams.tenantid+'/invoice/purchaseinvoice/PurchaseInvoiceList?quickLinkIdList='+quickLinkIdList,'_blank');
											}
								}else{var quickLinkIdList=datas.quickLinkIdList;
								if(qulkVal=="HAWB"){
									$location.url($stateParams.tenantid+'/hbw/list?quickLinkIdList='+quickLinkIdList);
									//$window.open('#'+$stateParams.tenantid+'/hbw/list?quickLinkIdList='+quickLinkIdList, '_blank');
								}else if(qulkVal=="MAWB"){
									$location.url($stateParams.tenantid+'/mabw/list?quickLinkIdList='+quickLinkIdList);
									//$window.open('#'+$stateParams.tenantid+'/mabw/list?quickLinkIdList='+quickLinkIdList, '_blank');
								}else if(qulkVal=="Delivery Order"){
									$location.url($stateParams.tenantid+'/airdeliveryorder/list?quickLinkIdList='+quickLinkIdList);
									//$window.open('#'+$stateParams.tenantid+'/airdeliveryorder/list?quickLinkIdList='+quickLinkIdList, '_blank');
								}else if(qulkVal=="Sales Invoice"){ 
									$location.url($stateParams.tenantid+'/invoice/salesinvoice/SalesInvoiceList?quickLinkIdList='+quickLinkIdList);
									//$window.open('#'+$stateParams.tenantid+'/invoice/salesinvoice/SalesInvoiceList?quickLinkIdList='+quickLinkIdList,'_blank');
								}else if(qulkVal=="Job Order"){
									$location.url($stateParams.tenantid+'/joborder/list?quickLinkIdList='+quickLinkIdList);
									//$window.open('#'+$stateParams.tenantid+'/invoice/purchaseinvoice/PurchaseInvoiceList?quickLinkIdList='+quickLinkIdList,'_blank');
								}
					}
											
								})
							}
						}
						}

					
				});
app
.controller(
		'purinvtableCtrl',
		function($scope, $http, $filter, logger, $timeout, $stateParams) {

			$scope.tenant = $stateParams.tenantid;

			/*$scope
					.$watch(
							'purchaseInvoiceData.purchaseInvoiceDetail[trIndex].companyCode',
							function(newValue, oldValue) {
								if (newValue != ''
										&& newValue != undefined) {
									if (!$scope.isEdit1)
										$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].accountHeadCode = '';
									// $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].subAccountCode
									// = '';
								}
							});

			debugger;
			$scope
					.$watch(
							'purchaseInvoiceData.purchaseInvoiceDetail[trIndex].voyageCode',
							function(newValue, oldValue) {
								debugger;
								if (newValue != ''
										&& newValue != undefined) {
									$http
											.get(
													$stateParams.tenantid
															+ '/app/commonUtility/getVesselService?voyageCode='
															+ newValue)
											.success(
													function(datas) {
														$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].vesselCode = datas.vesselCode;
														$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].sectorCode = datas.sectorCode;
													}).error(
													function(datas) {
													});

								}
							});

			
			 * $scope.$watch('purchaseInvoiceData.purchaseInvoiceDetail[trIndex].companyCode',
			 * function(newValue, oldValue) { if(newValue =='C0001'){
			 * $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isAttrMandatory=true;
			 * }else{
			 * $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isAttrMandatory=true; }
			 * });
			 

			$scope
					.$watch(
							'purchaseInvoiceData.purchaseInvoiceDetail[trIndex].accountHeadCode',
							function(newValue, oldValue, $stateParams) {

								$scope.tenant
								if (newValue != ''
										&& newValue != undefined) {
									
									 * if($scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode
									 * !='' &&
									 * $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode!=undefined &&
									 * $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode
									 * !=null){
									 
									$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCurrencyBlocked = false;
									// Trade Debitors
									if (newValue == '10080001') {
										$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isSubAccountCode = true;
										$http
												.get(
														$scope.tenant
																+ '/app/commonUtility/getonlypayer')
												.success(
														function(datas) {
															$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].subAccountCodeList = datas;
														})
												.error(function(datas) {
												});

									} else if (newValue == '20010001'
											|| newValue == '10090017') {
										$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isSubAccountCode = true;
										$http
												.get(
														$scope.tenant
																+ '/app/commonUtility/getonlySupplier')
												.success(
														function(datas) {
															$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].subAccountCodeList = datas;
														})
												.error(function(datas) {
												});
									} else if (newValue == '10120001'
											|| newValue == '10070004'
											|| newValue == '10070002') {
										$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isSubAccountCode = true;
										$http
												.get(
														$scope.tenant
																+ '/app/commonUtility/getSubAccountCodeListTradeCreditors')
												.success(
														function(datas) {
															$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].subAccountCodeList = datas;
														})
												.error(function(datas) {
												});
									} else if (newValue == '10070001') {
										if ($scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode == 'C0003')
											$scope.currencyList = [ {
												id : 'SGD',
												text : 'SGD'
											} ];
										$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isSubAccountCode = true;
										$http
												.get(
														$scope.tenant
																+ '/app/commonUtility/getStaffListForAdvances')
												.success(
														function(datas) {
															$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].subAccountCodeList = datas;
														})
												.error(function(datas) {
												});
									} else if (newValue == '20010004') {
										$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isSubAccountCode = true;
										$http
												.get(
														$scope.tenant
																+ '/app/commonUtility/getJvPartnerAccount')
												.success(
														function(datas) {
															$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].subAccountCodeList = datas;
														})
												.error(function(datas) {
												});
									} else if (newValue == '20010002') {
										$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isSubAccountCode = true;
										$http
												.get(
														$scope.tenant
																+ '/app/commonUtility/getAgentList')
												.success(
														function(datas) {
															$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].subAccountCodeList = datas;
														})
												.error(function(datas) {
												});
									} else {
										$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].subAccountCodeList = [];
										$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isSubAccountCode = false;
									}

									
									 * if(newValue.substring(0,
									 * 4)=='1000'){
									 * $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isAsset=true;
									 * $http.get($stateParams.tenantid+'/app/commonUtility/getassetList').success(function(datas) {
									 * debugger;
									 * $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].assetList =
									 * datas; }).error(function(datas) {
									 * }); }
									 

									if (newValue.substring(0, 4) == '1000') {
										$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isAsset = true;
										$http
												.get(
														$scope.tenant
																+ '/app/commonUtility/getassetList')
												.success(
														function(datas) {
															;
															$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].assetList = datas;
														})
												.error(function(datas) {
												});
									}

									$http
											.get(
													$scope.tenant
															+ '/app/commonUtility/getAttributesList?accountCode='
															+ newValue)
											.success(
													function(datas) {
														$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].attributeList = datas;
														if (newValue == oldValue) {
															$scope.isOnChange = false;
														} else {
															$scope.isOnChange = true;
														}
														if ((!$scope.edit || $scope.isOnChange)
																&& !$scope.isEdit1) {

															$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].voyageCode = '';
															$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].vesselCode = '';
															$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].sectorCode = '';
															$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].employeeCode = '';
															$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].portCode = '';
															$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].portSequence = '';
															$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].departmentCode = '';
															$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].agentCode = '';
															$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].countryCode = '';
															$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].customerCode = '';
															$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].supplierCode = '';
															$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].designationCode = '';
															$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].costCenter = '';
															// commented
															// for
															// inter-company
															// transaction
															 $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode=''; 
															$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].quantityGO = '';
															$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].quantityFO = '';
														}

														$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isVoyage = false;
														$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isVessel = false;
														$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isService = false;
														$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isEmployee = false;
														$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isPort = false;
														$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isDepartment = false;
														$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isAgent = false;
														$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isLocation = false;
														$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCustomer = false;
														$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isSupplier = false;
														$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isDesignation = false;
														$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCostCenter = false;
														// commented for
														// inter-company
														// transaction
														 $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCompany=false; 
														$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isQuantityGO = false;
														$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isQuantityFO = false;
														$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isPortSequence = false;

														// code added
														// for mandatory
														$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isVoyageMan = false;
														$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isVesselMan = false;
														$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isServiceMan = false;
														$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isEmployeeMan = false;
														$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isPortMan = false;
														$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isDepartmentMan = false;
														$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isAgentMan = false;
														$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isLocationMan = false;
														$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCustomerMan = false;
														$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isSupplierMan = false;
														$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isDesignationMan = false;
														$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCostCenterMan = false;
														$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isQuantityGOMan = false;
														$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isQuantityFOMan = false;
														$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isPortSequenceMan = false;

														angular
																.forEach(
																		$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].attributeList,
																		function(
																				row,
																				rowindex) {
																			debugger;
																			if (row.attributeName == "Voyage") {
																				$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isVoyage = true;
																				if (row.isMandatory == 'Y'
																						&& $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode != 'C0002') {
																					if ($scope.isOwner)
																						$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isVoyageMan = false;
																					else
																						$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isVoyageMan = true;
																				}
																			} else if (row.attributeName == "Vessel") {
																				$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isVessel = true;
																				if (row.isMandatory == 'Y'
																						&& $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode != 'C0002') {
																					if ($scope.isOwner)
																						$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isVesselMan = false;
																					else
																						$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isVesselMan = true;
																				}
																			} else if (row.attributeName == "Service") {
																				$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isService = true;
																				if (row.isMandatory == 'Y'
																						&& $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode != 'C0002') {
																					if ($scope.isOwner)
																						$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isServiceMan = false;
																					else
																						$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isServiceMan = true;
																				}
																			} else if (row.attributeName == "Employee") {
																				$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isEmployee = true;
																				if (row.isMandatory == 'Y'
																						&& $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode == 'C0001') {
																					if ($scope.isOwner)
																						$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isEmployeeMan = false;
																					else
																						$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isEmployeeMan = true;
																				}
																			} else if (row.attributeName == "Port") {
																				$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isPort = true;
																				if (row.isMandatory == 'Y'
																						&& $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode == 'C0001') {
																					if ($scope.isOwner)
																						$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isPortMan = false;
																					else
																						$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isPortMan = true;
																				}
																			} else if (row.attributeName == "Department") {
																				$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isDepartment = true;
																				if (row.isMandatory == 'Y'
																						&& $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode == 'C0001') {
																					if ($scope.isOwner)
																						$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isDepartmentMan = false;
																					else
																						$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isDepartmentMan = true;
																				}
																			} else if (row.attributeName == "Agent") {
																				$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isAgent = true;
																				if (row.isMandatory == 'Y'
																						&& $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode == 'C0001') {
																					if ($scope.isOwner)
																						$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isAgentMan = false;
																					else
																						$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isAgentMan = true;
																				}
																			} else if (row.attributeName == "Location") {
																				$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isLocation = true;
																				if (row.isMandatory == 'Y'
																						&& $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode == 'C0001') {
																					if ($scope.isOwner)
																						$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isLocationMan = false;
																					else
																						$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isLocationMan = true;
																				}
																			} else if (row.attributeName == "Customer") {
																				$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCustomer = true;
																				if (row.isMandatory == 'Y'
																						&& $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode == 'C0001') {
																					if ($scope.isOwner)
																						$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCustomerMan = false;
																					else
																						$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCustomerMan = true;
																				}
																			} else if (row.attributeName == "Supplier") {
																				$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isSupplier = true;
																				if (row.isMandatory == 'Y'
																						&& $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode == 'C0001') {
																					if ($scope.isOwner)
																						$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isSupplierMan = false;
																					else
																						$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isSupplierMan = true;
																				}
																			} else if (row.attributeName == "Designation") {
																				$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isDesignation = true;
																				if (row.isMandatory == 'Y'
																						&& $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode == 'C0001') {
																					if ($scope.isOwner)
																						$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isDesignationMan = false;
																					else
																						$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isDesignationMan = true;
																				}
																			} else if (row.attributeName == "Cost Center") {
																				$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCostCenter = true;
																				if (row.isMandatory == 'Y'
																						&& $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode == 'C0001') {
																					if ($scope.isOwner)
																						$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCostCenterMan = false;
																					else
																						$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCostCenterMan = true;
																				}
																			} else if (row.attributeName == "Company") {
																				$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCompany = true;
																				if (row.isMandatory == 'Y'
																						&& $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode == 'C0001') {
																					if ($scope.isOwner)
																						$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCompanyMan = false;
																					else
																						$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCompanyMan = true;
																				}
																			} else if (row.attributeName == "Quantity (MT) GO") {
																				$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isQuantityGO = true;
																				if (row.isMandatory == 'Y'
																						&& $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode == 'C0001') {
																					if ($scope.isOwner)
																						$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isQuantityGOMan = false;
																					else
																						$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isQuantityGOMan = true;
																				}
																			} else if (row.attributeName == "Quantity (MT) FO") {
																				$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isQuantityFO = true;
																				if (row.isMandatory == 'Y'
																						&& $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode == 'C0001') {
																					if ($scope.isOwner)
																						$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isQuantityFOMan = false;
																					else
																						$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isQuantityFOMan = true;
																				}
																			} else if (row.attributeName == "Port with Sequence") {
																				$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isPortSequence = true;
																				if (row.isMandatory == 'Y'
																						&& $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode == 'C0001') {
																					if ($scope.isOwner)
																						$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isPortSequenceMan = false;
																					else
																						$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isPortSequenceMan = true;
																				}
																			} else if (row.attributeName == "From Date") {
																				$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isFromDate = true;
																			} else if (row.attributeName == "To Date") {
																				$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isToDate = true;
																			}
																		});
													}).error(
													function(datas) {
													});

									$timeout(
											function() {
												var len = $scope.$index;
												if ($scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isFromDate == true) {
													$('#toDate' + len)
															.datetimepicker(
																	{
																		format : 'DD/MM/YYYY',
																		pickTime : false
																	})
													$('#fromDate' + len)
															.datetimepicker(
																	{
																		format : 'DD/MM/YYYY',
																		pickTime : false
																	})

													$("#toDate" + len)
															.on(
																	"dp.change",
																	function(
																			e) {
																		var from = $(
																				"#txtfromDate"
																						+ len)
																				.val();
																		var date = from
																				.split("/");
																		from = new Date(
																				date[2],
																				date[1] - 1,
																				date[0]);
																		var to = e.date._d;
																		if (to < from) {
																			logger
																					.logError("Please Select Valid To greater then  Valid From");
																			$(
																					"#txttoDate"
																							+ len)
																					.val(
																							'')
																		} else {
																			$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].toDate = $(
																					"#txttoDate"
																							+ len)
																					.val();
																		}

																	});

													$("#fromDate" + len)
															.on(
																	"dp.change",
																	function(
																			e) {
																		var to = $(
																				"#txttoDate"
																						+ len)
																				.val();
																		var date = to
																				.split("/");
																		to = new Date(
																				date[2],
																				date[1] - 1,
																				date[0]);

																		var from = e.date._d;
																		if (to < from) {
																			logger
																					.logError("Please Select Valid From less then  Valid To");
																			$(
																					"#txtfromDate"
																							+ len)
																					.val(
																							'')
																		} else {
																			$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].fromDate = $(
																					"#txtfromDate"
																							+ len)
																					.val();
																		}

																	});
												}
											}, 500);

									if ($scope.$index != 0) {
										angular
												.forEach(
														$scope.accountList,
														function(value,
																indexs) {
															if (newValue == value.accountHeadCode) {
																$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].currency = value.currency;
																// get
																// exchange
																// rate
																// for
																// currency
																$http
																		.get(
																				$scope.tenant
																						+ '/app/commonUtility/getExchangeRateWithCurrency?currencyCode='
																						+ value.currency)
																		.success(
																				function(
																						data) {
																					// $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].exchangeRate=data;
																					if (data.success) {
																						$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].fromCurrency = data.fromCurrency;
																						$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].toCurrency = data.toCurrency;
																						$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].exchangeRate = data.exchangeRate;
																					} else {
																						$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].exchangeRate = '';
																						$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].fromCurrency = '';
																						$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].toCurrency = '';
																					}
																				})
																		.error(
																				function(
																						data) {
																				});
															}
														});
									}
									
									 * }else{ debugger; if(
									 * $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].accountHeadCode
									 * !='') logger.logError("Please
									 * select Company First");
									 * 
									 * $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].accountHeadCode=''; }
									 

								} else {
									$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].currency = '';
									$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].exchangeRate = '';
									$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].subAccountCodeList = [];
								}
							});*/

			/* Voyage On Change............... */
			/*$scope
					.$watch(
							'purchaseInvoiceData.purchaseInvoiceDetail[trIndex].voyageCode',
							function(newValue, oldValue) {
								if (newValue != ''
										&& newValue != undefined) {
									angular
											.forEach(
													$scope.voyageList,
													function(value,
															indexs) {
														if (newValue == value.voyageCode) {
															$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].vesselCode = value.vesselCode;
															$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].sectorCode = value.sectorCode;
														}
													});
								} else {
									$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].vesselCode = '';
									$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].sectorCode = '';
								}
							});

			$scope
					.$watch(
							'purchaseInvoiceData.purchaseInvoiceDetail[trIndex].subAccountCode',
							function(newValue, oldValue, $stateParams) {
								if (newValue != ''
										&& newValue != undefined) {
									if ($scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].accountHeadCode == '20010001'
											|| $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].accountHeadCode == '10120001'
											|| $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].accountHeadCode == '20010002') {
										$http
												.get(
														$stateParams.tenantid
																+ '/app/commonUtility/getSupplierCurrency?supplierCode='
																+ newValue)
												.success(
														function(data) {
															if (data.success) {
																$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].currency = data.currencyCode;
																if (data.isAgent == 'Y'
																		&& $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode == 'C0001')
																	$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCurrencyBlocked = true;
																else
																	$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCurrencyBlocked = false;
															} else {
																$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCurrencyBlocked = false;
															}
														}).error(
														function(data) {
														});
									} else {
										$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCurrencyBlocked = false;
									}
								} else {

								}
							});*/

			/*
			 * $scope.$watch('purchaseInvoiceData.purchaseInvoiceDetail[trIndex].currency',
			 * function(newValue, oldValue,$stateParams) { if (newValue != '' &&
			 * newValue != undefined) { // get exchange rate for
			 * currency
			 * $http.get('app/commonUtility/getDefaultExchangeRate?currencyCode='+newValue).success(function(data)
			 * $http.get($scope.tenant+'/app/commonUtility/getExchangeRateWithCurrency?currencyCode='+newValue).success(function(data){
			 * if(data.success){
			 * $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].fromCurrency=data.fromCurrency;
			 * $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].toCurrency=data.toCurrency;
			 * $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].exchangeRate=data.exchangeRate;
			 * 
			 * $scope.amountCalculationexchange(data.exchangeRate,[$scope.$index],$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index]);
			 * }else{
			 * $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].exchangeRate=''; }
			 * }).error(function(data) { }); } });
			 */
		});

