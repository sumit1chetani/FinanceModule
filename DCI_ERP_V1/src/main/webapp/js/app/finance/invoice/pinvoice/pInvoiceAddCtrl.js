'use strict';
app.controller('generalInvoiceCtrl', function($scope, $stateParams, $controller ,$window, $rootScope, $location, $http, logger, $log, 
        ngDialog, $modal, utilsService, $state) {

    $scope.dataLoopCount = 0;
    $scope.from = 0;
    $scope.to = 100;
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
$scope.currentURL=$location.protocol() + '://'+ $location.host() +':'+  $location.port()+"/#" +$location.path();
    
    if(window.localStorage.getItem('giv_list')==$scope.currentURL){
        alert('window ' + $scope.currentURL + ' is already opened');
       // window.focus();
        //window.open($rootScope.currentURL,'_self').close();
      
       // window.close();
       // localStorage.removeItem('purchaseIv');
    }else{
        window.localStorage.setItem('giv', $scope.currentURL);
        window.localStorage.removeItem('giv');
    }
//    $(window).unload(function(){
//      //  debugger;
//       //alert("INSIDE UNLOAD")
//         localStorage.removeItem('giv');
//       });

    $scope.getTranslationList = function() {
        $scope.dataLoopCount = 0;
        $scope.showEmptyLabel = false;
        $scope.from = 0;
        $scope.to = 100;
        $scope.rowCollection = [];
        $scope.GeneralInvoiceList = [];
        var url = $stateParams.tenantid+'/app/generalinvoice/list?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount + '&formCode='+$('#form_code_id').val();
        $http.get(url).success(function(data) {
            console.log("data");
            console.log(data);
            if (data.success == true) {
                $scope.rowCollection = $scope.rowCollection.concat(data.lGeneralInvoiceList);
            }
        });
    };

    $scope.getTranslationList();

    $scope.add = function() {
        $state.go('app.finance.invoice.generalinvoiceadd',{tenantid:$stateParams.tenantid});
    };

    $scope.editRowBtn = function(InvoiceNo) {
        $location.path($stateParams.tenantid+'/invoice/generalinvoice/edit/' + InvoiceNo);
    }

    $scope.deleteRow = function(InvoiceNo) {
        ngDialog.close();
        ngDialog.open({
            template : 'generalInvoiceDeleteModal',
            scope :$scope,
            controller: $controller('GIctrlDelete', {
                $scope: $scope,
                InvoiceNo: InvoiceNo
            })
        });       
   };
   
   /**
    * print
    */
   $scope.printGeneralInvoiceDiv = function(invoiceNo){       
       var url = $stateParams.tenantid+'/app/generalinvoice/print?invoiceNo=' + invoiceNo;
       var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
       wnd.print();   
    }
   
   
     $scope.view = function(invoiceNo) {       
          $location.path($stateParams.tenantid+'/invoice/generalinvoice/view/' + invoiceNo);
   }
   /**
    * send mail
    */
   $scope.sendMail = function(invoiceNo) {       
       $http.get($stateParams.tenantid+'/app/generalinvoice/sendMail?invoiceNo='+invoiceNo).success(function(data) {
           if (data == true) {
               logger.logSuccess("Mail sent successfully!");
           }else{
               logger.logError("Unable to send Email");
           }
       }).error(function(data) {
           console.log("data" + data);
       });

   }
   
   $scope.bulkPrint = function(giRowData) {
       var invoiceNos = '';
       var len = giRowData.length;
       for (var i = 0; i < len; i++) {
           var rowData = giRowData[i];
           if (typeof rowData.check == "undefined") {
               rowData["check"] = false;
           }
           if (rowData.check == true) {
               if(invoiceNos==""){
                   invoiceNos= rowData.invoiceNo; 
               }
               else{
                   invoiceNos +=","+rowData.invoiceNo;
               }
           }
       }           
       var url = $stateParams.tenantid+'/app/generalinvoice/bulkPrint?invoiceNos='+invoiceNos;
       var wnd = window.open(url, 'Shipping', 'height=400,width=750,top=100,left=100,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
       wnd.print();
   }   
   
   $scope.verified = function(objTranslationItem) {
       $http.post($stateParams.tenantid+'/app/generalinvoice/toVerify', objTranslationItem).success(function(result) {
           if (result) {
               objTranslationItem.verified = true;
               logger.logSuccess("General Invoice verified successfully");
          //     $scope.getTranslationList();
           }
       });
   }
   
});

app.controller('GIctrlDelete', function($scope, $http,ngDialog,logger,$location,InvoiceNo,$stateParams) {
    $scope.DeleteConfirm = function(){
        $http.get($stateParams.tenantid+'/app/generalinvoice/delete?invoiceNo='+InvoiceNo).success(function(data) {
            if (data == true) {
                logger.logSuccess("Deleted successfully!");
                $scope.rowCollection = $scope.rowCollection.filter(function(obj) {
                    return obj.InvoiceNo !== InvoiceNo;
                });
                ngDialog.close();
            }else{
                logger.logError("Unable to Delete");
                ngDialog.close();
            }
        }).error(function(data) {
            console.log("data" + data);
        });
       
    }
    
    $scope.closeJVAccountDialog = function() {
        ngDialog.close();
     };
});

app.controller('generalInvoiceCtrladd', function($scope, $window, $rootScope, $location, $filter, $http, logger, 
        $log, ngDialog, $modal, utilsService, ListService, $stateParams,$timeout,validationService,toaster,$controller) {

    $scope.mloList=[];
    $scope.PorthdrList=[];
    $scope.voyagehdrList=[];
    $scope.chargeHeadList=[];
    $scope.unitList=[];
    $scope.bankList=[];
    $scope.currencyList=[];
    $scope.customerList=[];
    $scope.seaJobOrderList=[];
    $scope.modeList=[{
        id : '1',
        text : 'Sea'
    }, {
        id : '2',
        text : 'Air'
    }];
    $scope.generalinvoice = {
    	companyCode:'',
    	customer : '',
    	invoiceDt :'',
    	vendorInvoiceDate:'',
        tripRelated : false,
        jobOrderNo :'',
        pod :'',
        pol :'',
        bank :'',
        remarks:'',
        narration : '',
        currencyHdr:'',
        totalAmount:'',
        aol:'',
        aod:'',
        airJobOrderNo:'',
        GIDtl : []
        
    }
    
   
    $scope.currentURL=$location.protocol() + '://'+ $location.host() +':'+  $location.port()+"/#" +$location.path();
    
    if(window.localStorage.getItem('giv')==$scope.currentURL){
        alert('window ' + $scope.currentURL + ' is already opened');
       // window.focus();
        //window.open($rootScope.currentURL,'_self').close();
      
       // window.close();
       // localStorage.removeItem('purchaseIv');
    }else{
        window.localStorage.setItem('giv', $scope.currentURL);
        //window.localStorage.removeItem('purchaseIv');
    }
    $(window).unload(function(){
      //  debugger;
       //alert("INSIDE UNLOAD")
         localStorage.removeItem('giv');
       });

    $scope.cancel = function() {
        $location.path($stateParams.tenantid+"/invoice/generalinvoice/list");
    };
    $scope.onLoadDropdowns = function() {
    	$http.get($stateParams.tenantid+ '/app/usermaster/getCompanyList?formCode='+ $('#form_code_id').val()).success(function(datas) {
					debugger;
					$scope.tempCompanyList = datas;
					$scope.companyList = datas;
					var foundItemDest = $filter('filter')(
							$scope.companyList, {
								baseCompany : 1
							})[0];
					$scope.generalinvoice.companyCode = foundItemDest.id;
				}).error(function(datas) {
		});
        
        
        $http.get($stateParams.tenantid+'/app/generalinvoice/dropDownList').success(function(datas) {
            $scope.jobOrderList = datas.jobOrderList;
            $scope.seaJobOrderList = datas.seajobOrderList;
            $scope.bankList = datas.bankList;
            $scope.chargeHeadList = datas.chargeHeadList;
            $scope.unitList = datas.unitList;
            $scope.currencyList = datas.currencyList;
            $scope.customerList = datas.customerList;
            $scope.hblList = datas.hblList;
            $scope.mblList = datas.mblList;
            $scope.hawbList = datas.hawbList;
            $scope.mawbList = datas.mawbList;
            
            }).error(function(datas) {
        });
        
        
        $scope.$watch('generalinvoice.jobOrderNo', function(newValue, oldValue) {
            if (newValue != '' && newValue != undefined) {
            	var cusCode = $scope.generalinvoice.CustomerName;
                $http.get($stateParams.tenantid+'/app/generalinvoice/getjobOrderDetails?jobOrderNo='+newValue).success(function(datas) {
                    console.log("Trip Details ::::::::::::::");
                    console.log(datas);
                    
                    $scope.generalinvoice.pol = datas.pol;
                    $scope.generalinvoice.pod = datas.pod;
                    
                //    $scope.customerinvoice.GIDtl = datas.lGeneralInvoiceDtlList;
                    
                    }).error(function(datas) {
                });
            }
       });
    	/*$scope
		.$watch(
				'generalinvoice.GIDtl[trIndex].chargeHead',
				function(newValue, oldValue) {
					console.log(newValue);
					
					if (newValue != ''
							&& newValue != undefined) {
						alert(123);

						
						 * var isFlag=true; var
						 * foundItemDest =
						 * $filter('filter')($scope.cashbankpaymentModelData.cbptables, {
						 * cbpdtlAccountHead: newValue });
						 * if(foundItemDest.length>=2){
						 * isFlag = false; } if(isFlag){
						 
						var subAcct = $scope.cashbankpaymentModelData.cbptables[$scope.$index].cbdtlsubAccountCode;
						$scope.cashbankpaymentModelData.cbptables[$scope.$index].isCurrencyBlocked = false;
						$scope.cashbankpaymentModelData.cbptables[$scope.$index].cbdtlsubAccountCode = '';
						if (newValue == '10080001' || newValue=='20020002') {
							$scope.cashbankpaymentModelData.cbptables[$scope.$index].isSubAccountCode = true;
							$scope.cashbankpaymentModelData.cbptables[$scope.$index].cbdtlsubAccountCode = subAcct;
							$http
									.get(
											$stateParams.tenantid
													+ '/app/commonUtility/getonlySupplier?accountCode=' + newValue)
									.success(
											function(datas) {
												
												$scope.cashbankpaymentModelData.cbptables[$scope.$index].isTradeCreditors = false;
												$scope.cashbankpaymentModelData.cbptables[$scope.$index].subAccountCodeList = datas;
											})
									.error(function(datas) {
									});
							$scope.cashbankpaymentModelData.cbptables[$scope.$index].cbdtlsubAccountCode = subAcct;
						} else if (newValue == '20010001' || newValue == '10080001' || newValue == '20040001' || newValue == '20000003'
								|| newValue == '10090017' || newValue == '20010003' || newValue == '20010002' 
								|| newValue == '10080003' || newValue == '10080002' ||newValue == '10090018' 
								||newValue == '20020007' ||newValue == '20160002' ||newValue == '20160003' 
								||newValue == '20160001' || newValue == '10060016'  ) {
							$scope.cashbankpaymentModelData.cbptables[$scope.$index].isTradeCreditors = true;
							$scope.cashbankpaymentModelData.cbptables[$scope.$index].isSubAccountCode = true;
							$scope.cashbankpaymentModelData.cbptables[$scope.$index].isTDS = false;
							
							$http
									.get(
											$stateParams.tenantid
													+ '/app/commonUtility/getonlySupplier?accountCode=' + newValue)
									.success(
											function(datas) {
												$scope.cashbankpaymentModelData.cbptables[$scope.$index].subAccountCodeList = datas;
												
											})
									.error(function(datas) {
									});
							$scope.cashbankpaymentModelData.cbptables[$scope.$index].cbdtlsubAccountCode = subAcct;
						} else if (newValue == '10070002'
								|| newValue == '10120001'
								|| newValue == '10070004'
								|| newValue == '20020002'
									 || newValue == '20120009'  ) {
							$scope.cashbankpaymentModelData.cbptables[$scope.$index].isSubAccountCode = true;
							$scope.cashbankpaymentModelData.cbptables[$scope.$index].isTDS = false;
							$scope.cashbankpaymentModelData.cbptables[$scope.$index].cbdtlsubAccountCode = subAcct;
							$http
									.get(
											$stateParams.tenantid
													+ '/app/commonUtility/getSubAccountCodeListTradeCreditors')
									.success(
											function(datas) {
												if (newValue == '10070002')
													$scope.cashbankpaymentModelData.cbptables[$scope.$index].isTradeCreditors = true;
												else if (newValue == '20010001' || newValue == '10080001' || newValue == '20120009' ||  newValue == '20010002' || newValue == '20000003')
													$scope.cashbankpaymentModelData.cbptables[$scope.$index].isTradeCreditors = false;

												$scope.cashbankpaymentModelData.cbptables[$scope.$index].subAccountCodeList = datas;
											})
									.error(function(datas) {
									});
							$scope.cashbankpaymentModelData.cbptables[$scope.$index].cbdtlsubAccountCode = subAcct;
						} else if (newValue == '10070001'||newValue == '10070007') {
							
							if ($scope.cashbankpaymentModelData.cbptables[$scope.$index].companyCode == 'C0001')
								$scope.currencyList = [ {
									id : 'KSH',
									text : 'KSH'
								} ];
							$scope.cashbankpaymentModelData.cbptables[$scope.$index].isSubAccountCode = true;
							$scope.cashbankpaymentModelData.cbptables[$scope.$index].cbdtlsubAccountCode = subAcct;
							$http
									.get(
											$stateParams.tenantid
													+ '/app/commonUtility/getStaffListForAdvances')
									.success(
											function(datas) {
												$scope.cashbankpaymentModelData.cbptables[$scope.$index].isTradeCreditors = false;
												$scope.cashbankpaymentModelData.cbptables[$scope.$index].subAccountCodeList = datas;
											})
									.error(function(datas) {
									});
							$scope.cashbankpaymentModelData.cbptables[$scope.$index].cbdtlsubAccountCode = subAcct;
						} else if (newValue == '20010004') {
							$scope.cashbankpaymentModelData.cbptables[$scope.$index].isSubAccountCode = true;
							$scope.cashbankpaymentModelData.cbptables[$scope.$index].cbdtlsubAccountCode = subAcct;
							$http
									.get(
											$stateParams.tenantid
													+ '/app/commonUtility/getJvPartnerAccount')
									.success(
											function(datas) {
												$scope.cashbankpaymentModelData.cbptables[$scope.$index].isTradeCreditors = false;
												$scope.cashbankpaymentModelData.cbptables[$scope.$index].subAccountCodeList = datas;
											})
									.error(function(datas) {
									});
							$scope.cashbankpaymentModelData.cbptables[$scope.$index].cbdtlsubAccountCode = subAcct;
						} else if (newValue == '20010002') {
							$scope.cashbankpaymentModelData.cbptables[$scope.$index].isSubAccountCode = true;
							$scope.cashbankpaymentModelData.cbptables[$scope.$index].cbdtlsubAccountCode = subAcct;
							$http
									.get(
											$stateParams.tenantid
													+ '/app/commonUtility/getAgentList')
									.success(
											function(datas) {
												$scope.cashbankpaymentModelData.cbptables[$scope.$index].isTradeCreditors = false;
												$scope.cashbankpaymentModelData.cbptables[$scope.$index].subAccountCodeList = datas;
											})
									.error(function(datas) {
									});
							$scope.cashbankpaymentModelData.cbptables[$scope.$index].cbdtlsubAccountCode = subAcct;
						} else {
							$scope.cashbankpaymentModelData.cbptables[$scope.$index].isTradeCreditors = false;
							$scope.cashbankpaymentModelData.cbptables[$scope.$index].subAccountCodeList = [];
							$scope.cashbankpaymentModelData.cbptables[$scope.$index].isSubAccountCode = false;
						}

						if (newValue.substring(0, 4) == '1000') {
							$scope.cashbankpaymentModelData.cbptables[$scope.$index].isAsset = true;
							$http
									.get(
											$stateParams.tenantid
													+ '/app/commonUtility/getassetList')
									.success(
											function(datas) {
												
												$scope.cashbankpaymentModelData.cbptables[$scope.$index].assetList = datas;
											})
									.error(function(datas) {
									});
						}

						if(newValue=="20120004" || newValue=="20120005" || newValue=="20120006" || newValue=="20120007" || newValue=="20120008" || newValue=="20120009" ){
							$http.get(
									$stateParams.tenantid
											+ '/app/commonUtility/getonlypayer')
							.success(
									function(datas) {
										$scope.cashbankpaymentModelData.cbptables[$scope.$index].subAccountCodeList = datas;
										//$scope.cashbankpaymentModelData.cbptables[$scope.$index].cbdtlsubAccountCode = "CTDS0001";
										$scope.cashbankpaymentModelData.cbptables[$scope.$index].isSubAccountCodeTDS = true;
										$scope.cashbankpaymentModelData.cbptables[$scope.$index].cbdtlsubAccountCode = subAcct;
									})
							.error(function(datas) {
							});
							
							}
						
						$http
								.get(
										$stateParams.tenantid
												+ '/app/commonUtility/getAttributesList?accountCode='
												+ newValue)
								.success(
										function(datas) {
											
											$scope.cashbankpaymentModelData.cbptables[$scope.$index].attributeList = datas;
											if (newValue == oldValue) {
												$scope.isOnChange = false;
											} else {
												$scope.isOnChange = true;
											}
											if (!$scope.edit
													|| $scope.isOnChange) {
												$scope.cashbankpaymentModelData.cbptables[$scope.$index].voyageCode = '';
												$scope.cashbankpaymentModelData.cbptables[$scope.$index].vesselCode = '';
												$scope.cashbankpaymentModelData.cbptables[$scope.$index].sectorCode = '';
												$scope.cashbankpaymentModelData.cbptables[$scope.$index].employeeCode = '';
												$scope.cashbankpaymentModelData.cbptables[$scope.$index].portCode = '';
												$scope.cashbankpaymentModelData.cbptables[$scope.$index].portSequence = '';
												$scope.cashbankpaymentModelData.cbptables[$scope.$index].departmentCode = '';
												$scope.cashbankpaymentModelData.cbptables[$scope.$index].agentCode = '';
												$scope.cashbankpaymentModelData.cbptables[$scope.$index].countryCode = '';
												$scope.cashbankpaymentModelData.cbptables[$scope.$index].customerCode = '';
												$scope.cashbankpaymentModelData.cbptables[$scope.$index].supplierCode = '';
												$scope.cashbankpaymentModelData.cbptables[$scope.$index].designationCode = '';
												$scope.cashbankpaymentModelData.cbptables[$scope.$index].costCenter = '';
												// commented
												// for
												// inter-company
												// transaction
												 $scope.cashbankpaymentModelData.cbptables[$scope.$index].companyCode=''; 
												$scope.cashbankpaymentModelData.cbptables[$scope.$index].quantityGO = '';
												$scope.cashbankpaymentModelData.cbptables[$scope.$index].quantityFO = '';
											}

											$scope.cashbankpaymentModelData.cbptables[$scope.$index].isVoyage = false;
											$scope.cashbankpaymentModelData.cbptables[$scope.$index].isVessel = false;
											$scope.cashbankpaymentModelData.cbptables[$scope.$index].isService = false;
											$scope.cashbankpaymentModelData.cbptables[$scope.$index].isEmployee = false;
											$scope.cashbankpaymentModelData.cbptables[$scope.$index].isPort = false;
											$scope.cashbankpaymentModelData.cbptables[$scope.$index].isDepartment = false;
											$scope.cashbankpaymentModelData.cbptables[$scope.$index].isAgent = false;
											$scope.cashbankpaymentModelData.cbptables[$scope.$index].isLocation = false;
											$scope.cashbankpaymentModelData.cbptables[$scope.$index].isCustomer = false;
											$scope.cashbankpaymentModelData.cbptables[$scope.$index].isSupplier = false;
											$scope.cashbankpaymentModelData.cbptables[$scope.$index].isDesignation = false;
											$scope.cashbankpaymentModelData.cbptables[$scope.$index].isCostCenter = false;
											// commented for
											// inter-company
											// transaction
											 $scope.cashbankpaymentModelData.cbptables[$scope.$index].isCompany=false; 
											$scope.cashbankpaymentModelData.cbptables[$scope.$index].isQuantityGO = false;
											$scope.cashbankpaymentModelData.cbptables[$scope.$index].isQuantityFO = false;
											$scope.cashbankpaymentModelData.cbptables[$scope.$index].isPortSequence = false;

											// code added
											// for mandatory
											$scope.cashbankpaymentModelData.cbptables[$scope.$index].isVoyageMan = false;
											$scope.cashbankpaymentModelData.cbptables[$scope.$index].isVesselMan = false;
											$scope.cashbankpaymentModelData.cbptables[$scope.$index].isServiceMan = false;
											$scope.cashbankpaymentModelData.cbptables[$scope.$index].isEmployeeMan = false;
											$scope.cashbankpaymentModelData.cbptables[$scope.$index].isPortMan = false;
											$scope.cashbankpaymentModelData.cbptables[$scope.$index].isDepartmentMan = false;
											$scope.cashbankpaymentModelData.cbptables[$scope.$index].isAgentMan = false;
											$scope.cashbankpaymentModelData.cbptables[$scope.$index].isLocationMan = false;
											$scope.cashbankpaymentModelData.cbptables[$scope.$index].isCustomerMan = false;
											$scope.cashbankpaymentModelData.cbptables[$scope.$index].isSupplierMan = false;
											$scope.cashbankpaymentModelData.cbptables[$scope.$index].isDesignationMan = false;
											$scope.cashbankpaymentModelData.cbptables[$scope.$index].isCostCenterMan = false;
											$scope.cashbankpaymentModelData.cbptables[$scope.$index].isQuantityGOMan = false;
											$scope.cashbankpaymentModelData.cbptables[$scope.$index].isQuantityFOMan = false;
											$scope.cashbankpaymentModelData.cbptables[$scope.$index].isPortSequenceMan = false;

											angular
													.forEach(
															$scope.cashbankpaymentModelData.cbptables[$scope.$index].attributeList,
															function(
																	row,
																	rowindex) {
																
																if (row.attributeName == "Voyage") {
																	$scope.cashbankpaymentModelData.cbptables[$scope.$index].isVoyage = true;
																	if (row.isMandatory == 'Y'
																			&& $scope.cashbankpaymentModelData.cbptables[$scope.$index].companyCode != 'C0002') {
																		if ($scope.isOwner)
																			$scope.cashbankpaymentModelData.cbptables[$scope.$index].isVoyageMan = false;
																		else
																			$scope.cashbankpaymentModelData.cbptables[$scope.$index].isVoyageMan = true;
																	}
																} else if (row.attributeName == "Vessel") {
																	$scope.cashbankpaymentModelData.cbptables[$scope.$index].isVessel = true;
																	if (row.isMandatory == 'Y'
																			&& $scope.cashbankpaymentModelData.cbptables[$scope.$index].companyCode != 'C0002') {
																		if ($scope.isOwner)
																			$scope.cashbankpaymentModelData.cbptables[$scope.$index].isVesselMan = false;
																		else
																			$scope.cashbankpaymentModelData.cbptables[$scope.$index].isVesselMan = true;
																	}
																} else if (row.attributeName == "Service") {
																	$scope.cashbankpaymentModelData.cbptables[$scope.$index].isService = true;
																	if (row.isMandatory == 'Y'
																			&& $scope.cashbankpaymentModelData.cbptables[$scope.$index].companyCode != 'C0002') {
																		if ($scope.isOwner)
																			$scope.cashbankpaymentModelData.cbptables[$scope.$index].isServiceMan = false;
																		else
																			$scope.cashbankpaymentModelData.cbptables[$scope.$index].isServiceMan = true;
																	}
																} else if (row.attributeName == "Employee") {
																	$scope.cashbankpaymentModelData.cbptables[$scope.$index].isEmployee = true;
																	if (row.isMandatory == 'Y'
																			&& $scope.cashbankpaymentModelData.cbptables[$scope.$index].companyCode == 'C0001') {
																		if ($scope.isOwner)
																			$scope.cashbankpaymentModelData.cbptables[$scope.$index].isEmployeeMan = false;
																		else
																			$scope.cashbankpaymentModelData.cbptables[$scope.$index].isEmployeeMan = true;
																	}
																} else if (row.attributeName == "Port") {
																	$scope.cashbankpaymentModelData.cbptables[$scope.$index].isPort = true;
																	if (row.isMandatory == 'Y'
																			&& $scope.cashbankpaymentModelData.cbptables[$scope.$index].companyCode == 'C0001') {
																		if ($scope.isOwner)
																			$scope.cashbankpaymentModelData.cbptables[$scope.$index].isPortMan = false;
																		else
																			$scope.cashbankpaymentModelData.cbptables[$scope.$index].isPortMan = true;
																	}
																} else if (row.attributeName == "Department") {
																	$scope.cashbankpaymentModelData.cbptables[$scope.$index].isDepartment = true;
																	if (row.isMandatory == 'Y'
																			&& $scope.cashbankpaymentModelData.cbptables[$scope.$index].companyCode == 'C0001') {
																		if ($scope.isOwner)
																			$scope.cashbankpaymentModelData.cbptables[$scope.$index].isDepartmentMan = false;
																		else
																			$scope.cashbankpaymentModelData.cbptables[$scope.$index].isDepartmentMan = true;
																	}
																} else if (row.attributeName == "Agent") {
																	$scope.cashbankpaymentModelData.cbptables[$scope.$index].isAgent = true;
																	if (row.isMandatory == 'Y'
																			&& $scope.cashbankpaymentModelData.cbptables[$scope.$index].companyCode == 'C0001') {
																		if ($scope.isOwner)
																			$scope.cashbankpaymentModelData.cbptables[$scope.$index].isAgentMan = false;
																		else
																			$scope.cashbankpaymentModelData.cbptables[$scope.$index].isAgentMan = true;
																	}
																} else if (row.attributeName == "Location") {
																	$scope.cashbankpaymentModelData.cbptables[$scope.$index].isLocation = true;
																	if (row.isMandatory == 'Y'
																			&& $scope.cashbankpaymentModelData.cbptables[$scope.$index].companyCode == 'C0001') {
																		if ($scope.isOwner)
																			$scope.cashbankpaymentModelData.cbptables[$scope.$index].isLocationMan = false;
																		else
																			$scope.cashbankpaymentModelData.cbptables[$scope.$index].isLocationMan = true;
																	}
																} else if (row.attributeName == "Customer") {
																	$scope.cashbankpaymentModelData.cbptables[$scope.$index].isCustomer = true;
																	if (row.isMandatory == 'Y'
																			&& $scope.cashbankpaymentModelData.cbptables[$scope.$index].companyCode == 'C0001') {
																		if ($scope.isOwner)
																			$scope.cashbankpaymentModelData.cbptables[$scope.$index].isCustomerMan = false;
																		else
																			$scope.cashbankpaymentModelData.cbptables[$scope.$index].isCustomerMan = true;
																	}
																} else if (row.attributeName == "Supplier") {
																	$scope.cashbankpaymentModelData.cbptables[$scope.$index].isSupplier = true;
																	if (row.isMandatory == 'Y'
																			&& $scope.cashbankpaymentModelData.cbptables[$scope.$index].companyCode == 'C0001') {
																		if ($scope.isOwner)
																			$scope.cashbankpaymentModelData.cbptables[$scope.$index].isSupplierMan = false;
																		else
																			$scope.cashbankpaymentModelData.cbptables[$scope.$index].isSupplierMan = true;
																	}
																} else if (row.attributeName == "Designation") {
																	$scope.cashbankpaymentModelData.cbptables[$scope.$index].isDesignation = true;
																	if (row.isMandatory == 'Y'
																			&& $scope.cashbankpaymentModelData.cbptables[$scope.$index].companyCode == 'C0001') {
																		if ($scope.isOwner)
																			$scope.cashbankpaymentModelData.cbptables[$scope.$index].isDesignationMan = false;
																		else
																			$scope.cashbankpaymentModelData.cbptables[$scope.$index].isDesignationMan = true;
																	}
																} else if (row.attributeName == "Cost Center") {
																	$scope.cashbankpaymentModelData.cbptables[$scope.$index].isCostCenter = true;
																	if (row.isMandatory == 'Y'
																			&& $scope.cashbankpaymentModelData.cbptables[$scope.$index].companyCode == 'C0001') {
																		if ($scope.isOwner)
																			$scope.cashbankpaymentModelData.cbptables[$scope.$index].isCostCenterMan = false;
																		else
																			$scope.cashbankpaymentModelData.cbptables[$scope.$index].isCostCenterMan = true;
																	}
																} else if (row.attributeName == "Company") {
																	$scope.cashbankpaymentModelData.cbptables[$scope.$index].isCompany = true;
																	if (row.isMandatory == 'Y'
																			&& $scope.cashbankpaymentModelData.cbptables[$scope.$index].companyCode == 'C0001') {
																		if ($scope.isOwner)
																			$scope.cashbankpaymentModelData.cbptables[$scope.$index].isCompanyMan = false;
																		else
																			$scope.cashbankpaymentModelData.cbptables[$scope.$index].isCompanyMan = true;
																	}
																} else if (row.attributeName == "Quantity (MT) GO") {
																	$scope.cashbankpaymentModelData.cbptables[$scope.$index].isQuantityGO = true;
																	if (row.isMandatory == 'Y'
																			&& $scope.cashbankpaymentModelData.cbptables[$scope.$index].companyCode == 'C0001') {
																		if ($scope.isOwner)
																			$scope.cashbankpaymentModelData.cbptables[$scope.$index].isQuantityGOMan = false;
																		else
																			$scope.cashbankpaymentModelData.cbptables[$scope.$index].isQuantityGOMan = true;
																	}
																} else if (row.attributeName == "Quantity (MT) FO") {
																	$scope.cashbankpaymentModelData.cbptables[$scope.$index].isQuantityFO = true;
																	if (row.isMandatory == 'Y'
																			&& $scope.cashbankpaymentModelData.cbptables[$scope.$index].companyCode == 'C0001') {
																		if ($scope.isOwner)
																			$scope.cashbankpaymentModelData.cbptables[$scope.$index].isQuantityFOMan = false;
																		else
																			$scope.cashbankpaymentModelData.cbptables[$scope.$index].isQuantityFOMan = true;
																	}
																} else if (row.attributeName == "Port with Sequence") {
																	$scope.cashbankpaymentModelData.cbptables[$scope.$index].isPortSequence = true;
																	if (row.isMandatory == 'Y'
																			&& $scope.cashbankpaymentModelData.cbptables[$scope.$index].companyCode == 'C0001') {
																		if ($scope.isOwner)
																			$scope.cashbankpaymentModelData.cbptables[$scope.$index].isPortSequenceMan = false;
																		else
																			$scope.cashbankpaymentModelData.cbptables[$scope.$index].isPortSequenceMan = true;
																	}
																} else if (row.attributeName == "From Date") {
																	$scope.cashbankpaymentModelData.cbptables[$scope.$index].isFromDate = true;
																} else if (row.attributeName == "To Date") {
																	$scope.cashbankpaymentModelData.cbptables[$scope.$index].isToDate = true;
																}
															});
										}).error(
										function(datas) {
										});

						angular
								.forEach(
										$scope.cbpdtlAcctHeadList,
										function(value,
												indexs) {
											if (newValue == value.accountHeadCode) {
												$scope.cashbankpaymentModelData.cbptables[$scope.$index].cbpdtlCurrencyCode = value.currency;
												// get
												// exchange
												// rate for
												// currency
												$http
														.get(
																$stateParams.tenantid
																		+ '/app/commonUtility/getExchangeRateWithCurrency?currencyCode='
																		+ value.currency)
														.success(
																function(
																		data) {
																	 $http.get('app/commonUtility/getDefaultExchangeRate?currencyCode='+$scope.objCBReceipt.cshBankDetail[$scope.$index].currency).success(function(data) { 
																	// $scope.objCBReceipt.cshBankDetail[$scope.$index].exgRate=data;
																	if (data.success) {
																		$scope.cashbankpaymentModelData.cbptables[$scope.$index].fromCurrency = data.fromCurrency;
																		$scope.cashbankpaymentModelData.cbptables[$scope.$index].toCurrency = data.toCurrency;
																		$scope.cashbankpaymentModelData.cbptables[$scope.$index].cbpdtlExgRate = data.exchangeRate;

																	} else {
																		$scope.cashbankpaymentModelData.cbptables[$scope.$index].fromCurrency = '';
																		$scope.cashbankpaymentModelData.cbptables[$scope.$index].toCurrency = '';
																		$scope.cashbankpaymentModelData.cbptables[$scope.$index].cbpdtlExgRate = '';
																	}
																})
														.error(
																function(
																		data) {
																});

											}
										});

						$timeout(
								function() {
									var len = $scope.$index;
									if ($scope.cashbankpaymentModelData.cbptables[$scope.$index].isFromDate == true) {
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
																$scope.cashbankpaymentModelData.cbptables[$scope.$index].toDate = $(
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
																$scope.cashbankpaymentModelData.cbptables[$scope.$index].fromDate = $(
																		"#txtfromDate"
																				+ len)
																		.val();
															}

														});
									}
								}, 500);
						
						 * }else{
						 * $scope.cashbankpaymentModelData.cbptables[$scope.$index].cbpdtlAccountHead='';
						 * logger.logError("Account already
						 * selected.Please select
						 * others!.."); }
						 
					} else {
						$scope.cashbankpaymentModelData.cbptables[$scope.$index].subAccountCodeList = [];
					}
				});*/
        $scope.$watch('generalinvoice.airJobOrderNo', function(newValue, oldValue) {
            if (newValue != '' && newValue != undefined) {
            	
                $http.get($stateParams.tenantid+'/app/generalinvoice/getseajobOrderDetails?seajobOrderNo='+newValue).success(function(datas) {
                    
                    console.log(datas);
                    
                    $scope.generalinvoice.aol = datas.aol;
                    $scope.generalinvoice.aod = datas.aod;
                    
                //    $scope.customerinvoice.GIDtl = datas.lGeneralInvoiceDtlList;
                    
                    }).error(function(datas) {
                });
            }
       });
             
    };
    
    $scope.onLoadDropdowns();

    $('#invoice_date').datetimepicker({
        minDate: "01/01/2016",
        pickTime: false,
        format : 'DD/MM/YYYY'
    });

    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth() + 1;

    var yyyy = today.getFullYear();
    if (dd < 10) {
        dd = '0' + dd
    }
    if (mm < 10) {
        mm = '0' + mm
    }
    var today = dd + '/' + mm + '/' + yyyy;
    $scope.generalinvoice.invoiceDt = today;
    $scope.checkDatesCL = function(invoiceDt){
        var res = $scope.generalinvoice.invoiceDt.split("/");
        $http.get($stateParams.tenantid+'/app/cashbankreceipt/getloggedcompany?closingDate='+$scope.generalinvoice.invoiceDt).success(function(datas) {
            if(datas){
                logger.logError("Account closed for year "+ res[2]);
                $scope.generalinvoice.invoiceDt = today;
            }
        })
    }

    debugger;
    var generalObj = angular.copy($scope.generalinvoice, generalObj);
    var listVariable = Object.keys(generalObj);

    /*$scope.$watchCollection('generalinvoice', function(newVal, oldVal) {
        if (newVal != undefined) {
            var userSelected = $scope.getValueForSelect(listVariable, newVal, oldVal);
            if (angular.isDefined(userSelected)) {
                $scope.selectedDropDown(userSelected);
            }
        }
    }, true);

  
    $scope.getValueForSelect = function(listVariable, newValObj, oldValObj) {
        var singleDeclaredvariable = null;
        angular.forEach(listVariable, function(value) {
            if (newValObj[value] != oldValObj[value])
                singleDeclaredvariable = value;
        });
        return singleDeclaredvariable;
    }*/

        
    $scope.onSubmit = function(generalInvoiceForm,generalinvoice) {
        if (new validationService().checkFormValidity($scope.generalInvoiceForm)) {
            $scope.save();
        } else {
            toaster.pop('error', "Please fill the required fields", 
                    logger.getErrorHtmlNew($scope.generalInvoiceForm.$validationSummary), 5000, 'trustedHtml');
        }
    };
    
    $scope.display_limit = 50;
    
    $scope.increaseLimit = function () {
        if ($scope.display_limit < $scope.yearListVal.length) {
            $scope.display_limit += 50;
        }
      };
    
    $scope.save = function() {
        debugger;
                   $http.post($stateParams.tenantid+'/app/generalinvoice/save', $scope.generalinvoice).success(function(data) {
                        if (data.success == true) {
                            logger.logSuccess("Created successfully!");
                            $location.path($stateParams.tenantid+"/invoice/generalinvoice/list");
                        } else {
                            if(data.message != null && data.message !=''){
                                logger.logError(data.message);
                            }else{
                            logger.logError("Unable to Save");
                            }
                        }
                    }).error(function(data) {
                    });
     };
    
    
    $scope.validateExchangeRate = function(generalinvoice){
        debugger;
        var HdrLogErrMessage="",DtlLogErrMessage = "",loggerMsg="", isFlag=true;
        if(parseFloat(generalinvoice.ExchangeRate) < parseFloat(generalinvoice.fromCurrency) 
                || parseFloat(generalinvoice.ExchangeRate) > parseFloat(generalinvoice.toCurrency)){
            HdrLogErrMessage="Please Enter Exchange Rate Between "+generalinvoice.fromCurrency+" and "+
            generalinvoice.toCurrency+"<br><br>";      
            //generalinvoice.ExchangeRate=0;
            $scope.generalinvoice.ExchangeRate ='';
            isFlag = false;
          
        }
        var pinLength= generalinvoice.GIDtl.length;
        if(pinLength>0){
            
            loggerMsg = HdrLogErrMessage;
            if(loggerMsg !=""){
                isFlag = false;
                $scope.logValidExgRateErrorMessage = loggerMsg;                   
            }                   
        }         
        
        return isFlag;
    }
    
   

    $scope.getIndex = function(list, name) {
        var foundItem = $filter('filter')(list, {
            id : name
        }, true)[0];
        var index = list.indexOf(foundItem);
        return index;
    }

    $scope.generalInvoiceDtlList = function() {
        var giRow = {
                select : '',
                chargeHead :'',
                unit :'',
                qty :'',
                rate :'',
                currencyDtl:'',
                amount:'',
                taxAmount:'',
                isHBL:false,
                isMBL:false,
                isHAWB:false,
                isMAWB:false,
                isFlightNo:false,
                isVoyage : false,
				isVessel : false,
				isService : false,
				isEmployee : false,
				isPort : false,
				isDepartment : false,
				isAgent : false,
				isLocation : false,
				isCustomer : false,
				isSupplier : false,
				isDesignation : false,
				isCostCenter : false,
				isCompany : false,
				isQuantityGO : false,
				isQuantityFO : false,
				isPortSequence : false,
				isFromDate : false,
				isToDate : false,
                isContainerNo:false
        };
        $scope.generalinvoice.GIDtl.push(giRow);
    }

    $scope.generalInvoiceDtlList();
    
    $scope.addRow = function(gitable) {
        var table = {
        		select : '',
                chargeHead :'',
                unit :'',
                qty :'',
                rate :'',
                currencyDtl:'',
                amount:'',
                taxAmount:'',
                isHBL:false,
                isMBL:false,
                isHAWB:false,
                isMAWB:false,
                isFlightNo:false,
                isVoyage : false,
				isVessel : false,
				isService : false,
				isEmployee : false,
				isPort : false,
				isDepartment : false,
				isAgent : false,
				isLocation : false,
				isCustomer : false,
				isSupplier : false,
				isDesignation : false,
				isCostCenter : false,
				isCompany : false,
				isQuantityGO : false,
				isQuantityFO : false,
				isPortSequence : false,
				isFromDate : false,
				isToDate : false,
                isContainerNo:false
        };
        
        gitable.push(table);
    };
    // removeRow
    $scope.removeRow = function(GItable) {
        debugger;
        $scope.tablerow = [];
        angular.forEach(GItable, function(row, index) {
            var check = row.select;
            if (check == undefined || check == "") {
                $scope.tablerow.push(row);
            } else {

            }
        });
        $scope.generalinvoice.GIDtl = $scope.tablerow;
    };
   
    /*$scope.getcurrencyValues = function(currencyValue){
        if(currencyValue!=null && currencyValue!=undefined && currencyValue!=""){
            $http.get($stateParams.tenantid+'/app/commonUtility/getExchangeRateWithCurrency?currencyCode='+currencyValue).success(function(data) {
                debugger;
                //$scope.generalinvoice.ExchangeRate=data;                            
                $scope.generalinvoice.ExchangeRate=data.exchangeRate;
                $scope.generalinvoice.fromCurrency=data.fromCurrency;
                $scope.generalinvoice.toCurrency=data.toCurrency;     
            }).error(function(data) {
            });
        }else{
            $scope.generalinvoice.ExchangeRate='';
            $scope.generalinvoice.fromCurrency='';
            $scope.generalinvoice.toCurrency='';
        }
    }*/  
    
   /* $scope.exchagerateGIhdr = function(exchangeRate){
        debugger; 
        if(exchangeRate>0){
            if(parseFloat(exchangeRate) < $scope.generalinvoice.fromCurrency || parseFloat(exchangeRate) > $scope.generalinvoice.toCurrency){
                logger.logError("Please Enter Exchange Rate Between "+$scope.generalinvoice.fromCurrency+" and "+
                        $scope.generalinvoice.toCurrency);       
                $scope.generalinvoice.ExchangeRate=0;
            }else{
                var bcAmount=0.0, tcAmount=0.0;
                angular.forEach($scope.generalinvoice.GIDtl, function(giRow,giIndex){
                    debugger;
                    if(isNaN(parseFloat(giRow.tcAmount, 10))){
                        if(isNaN(parseFloat(giRow.bcAmount, 10))){
                          //  var bcAmt = (parseFloat(giRow.tcAmount) / exchangeRate);
                          //  var tcAmt = (parseFloat(giRow.bcAmount) * exchangeRate);
                            var bcAmt = Math.floor(((isNaN(parseFloat(giRow.tcAmount, 10))?0:giRow.tcAmount) / parseFloat(exchangeRate))*100)/100;
                            var tcAmt = Math.floor(((isNaN(parseFloat(giRow.bcAmount, 10))?0:giRow.bcAmount) * parseFloat(exchangeRate))*100)/100;
                            giRow.tcAmount = isNaN(tcAmt)?0:tcAmt.toFixed(2); 
                            giRow.bcAmount = isNaN(bcAmt)?0:bcAmt.toFixed(2); 
                        }else{
                           // var tcAmt = (parseFloat(giRow.bcAmount) * exchangeRate);
                            var tcAmt = Math.floor(((isNaN(parseFloat(giRow.bcAmount, 10))?0:giRow.bcAmount) * parseFloat(exchangeRate))*100)/100;
                            giRow.tcAmount = isNaN(tcAmt)?0:tcAmt.toFixed(2);  
                        }
                    }else {
                        //var bcAmt = (parseFloat(giRow.tcAmount) / exchangeRate);
                        //giRow.bcAmount = isNaN(bcAmt)?0:bcAmt.toFixed(2); 
                        var bcAmt = Math.floor(((isNaN(parseFloat( giRow.tcAmount, 10))?0: giRow.tcAmount) / parseFloat(exchangeRate))*100)/100;                    
                        giRow.bcAmount = parseFloat(bcAmt).toFixed(2);
                    } 
                });        
            }
              
            
        }
        $scope.calculateTotalAmount($scope.generalinvoice.GIDtl);
     }*/
    
    /*$scope.calculateTCtoBCAmount = function(tcAmount, trIndex, row) {
        debugger;
        if (tcAmount != null) {
            if ($scope.generalinvoice.ExchangeRate != 0 && $scope.generalinvoice.ExchangeRate != ""){
             // var bcAmount = (parseFloat(tcAmount) / $scope.generalinvoice.ExchangeRate).toFixed(2);
              var bcAmount = Math.floor(((isNaN(parseFloat( tcAmount, 10))?0: tcAmount) / parseFloat($scope.generalinvoice.ExchangeRate))*100)/100;
               row.bcAmount= isNaN(bcAmount)?0:bcAmount;
            }
            else{
                tcAmount = Math.floor(((isNaN(parseFloat( tcAmount, 10))?0: tcAmount))*100)/100;
                row.bcAmount = (parseFloat(tcAmount)).toFixed(2);
            }                
        } else {
            row.bcAmount = 0.0;
            row.tcAmount = 0.0;
        }
        $scope.calculateTotalAmount($scope.generalinvoice.GIDtl);
    };*/

    /*$scope.calculateBCtoTCAmount = function(bcAmount, trIndex, row) {
        debugger;
        if (bcAmount != null) {
            if ($scope.generalinvoice.ExchangeRate != 0 && $scope.generalinvoice.ExchangeRate != ""){
                //var tcAmt = (parseFloat(bcAmount) * $scope.generalinvoice.ExchangeRate).toFixed(2);
                var tcAmt = Math.floor(((isNaN(parseFloat( bcAmount, 10))?0: bcAmount) * parseFloat($scope.generalinvoice.ExchangeRate))*100)/100;
                row.tcAmount =isNaN(tcAmt)?0:tcAmt;
            }                
            else{
                bcAmount = Math.floor(((isNaN(parseFloat( bcAmount, 10))?0: bcAmount))*100)/100;
                var tcAmt = (parseFloat(bcAmount)).toFixed(2);
                row.tcAmount = isNaN(tcAmt)?0:tcAmt;
            }
                
        } else {
            row.bcAmount = 0.0;
            row.tcAmount = 0.0;
        }
        $scope.calculateTotalAmount($scope.generalinvoice.GIDtl);
    };*/
    
    
    //excrate watch 
    
    /*$scope.$watch('generalinvoice.GIDtl[trIndex].currencyDtl', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
        	debugger;
            $http.get($stateParams.tenantid+ '/app/generalinvoice/getexchangeRate?currency='+ currencyName).success(function(datas) {
    			$scope.generalinvoice.GIDtl[$scope.$index].exchangeRate = datas.exchangeRt;
                
                }).error(function(datas) {
            });
        }
   });*/
    
    //calamt
    $scope.$watch('generalinvoice.GIDtl[trIndex].chargeHead', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
                debugger;
                alert("tes");

              $http.get($stateParams.tenantid+'/app/generalinvoice/getSacNo?chargeHead='+newValue).success(function(datas) {
                    console.log(datas);
                    $scope.generalinvoice.GIDtl[$scope.$index].sacNo = datas.sacNo;
                    
                    }).error(function(datas) {
                });
                
                $http.get($stateParams.tenantid+'/app/generalinvoice/getAttributesList?chargeHead='+newValue).success(function(datas) {
                $scope.generalinvoice.GIDtl[$scope.$index].attributeList=datas;
                
                $scope.generalinvoice.GIDtl[$scope.$index].isHBL=false;
                $scope.generalinvoice.GIDtl[$scope.$index].isMBL=false;
                $scope.generalinvoice.GIDtl[$scope.$index].isHAWB=false;
                $scope.generalinvoice.GIDtl[$scope.$index].isMAWB=false;
                $scope.generalinvoice.GIDtl[$scope.$index].isFlightNo=false;
                $scope.generalinvoice.GIDtl[$scope.$index].isVessel=false;
                $scope.generalinvoice.GIDtl[$scope.$index].isContainerNo=false;
                $scope.generalinvoice.GIDtl[$scope.$index].isVoyage = false;
				//$scope.generalinvoice.GIDtl[$scope.$index].isVessel = false;
				$scope.generalinvoice.GIDtl[$scope.$index].isService = false;
				$scope.generalinvoice.GIDtl[$scope.$index].isEmployee = false;
				$scope.generalinvoice.GIDtl[$scope.$index].isPort = false;
				$scope.generalinvoice.GIDtl[$scope.$index].isDepartment = false;
				$scope.generalinvoice.GIDtl[$scope.$index].isAgent = false;
				$scope.generalinvoice.GIDtl[$scope.$index].isLocation = false;
				$scope.generalinvoice.GIDtl[$scope.$index].isCustomer = false;
				$scope.generalinvoice.GIDtl[$scope.$index].isSupplier = false;
				$scope.generalinvoice.GIDtl[$scope.$index].isDesignation = false;
				$scope.generalinvoice.GIDtl[$scope.$index].isCostCenter = false;
             
                angular.forEach($scope.generalinvoice.GIDtl[$scope.$index].attributeList, function(row, rowindex) {
                    if(row.attributeName == "HBL"){
                        $scope.generalinvoice.GIDtl[$scope.$index].isHBL=true;
                    }else if(row.attributeName == "MBL"){
                        $scope.generalinvoice.GIDtl[$scope.$index].isMBL=true;
                    }else if(row.attributeName == "HAWB"){
                        $scope.generalinvoice.GIDtl[$scope.$index].isHAWB=true;
                    }else if(row.attributeName == "MAWB"){
                        $scope.generalinvoice.GIDtl[$scope.$index].isMAWB=true;
                    }else if(row.attributeName == "Flight No"){
                        $scope.generalinvoice.GIDtl[$scope.$index].isFlightNo=true;
                    }else if(row.attributeName == "Vessel & Voyage"){
                        $scope.generalinvoice.GIDtl[$scope.$index].isVessel=true;
                    }else if(row.attributeName == "Container No"){
                        $scope.generalinvoice.GIDtl[$scope.$index].isContainerNo=true;
                    }else if(row.attributeName == "Vessel"){
                        $scope.generalinvoice.GIDtl[$scope.$index].isVessel=true;
                    }else if(row.attributeName == "Voyage"){
                        $scope.generalinvoice.GIDtl[$scope.$index].isVoyage=true;
                    }else if(row.attributeName == "Service"){
                        $scope.generalinvoice.GIDtl[$scope.$index].isService=true;
                    }else if(row.attributeName == "Port"){
                        $scope.generalinvoice.GIDtl[$scope.$index].isPort=true;
                    }else if(row.attributeName == "Department"){
                        $scope.generalinvoice.GIDtl[$scope.$index].isDepartment=true;
                    }else if(row.attributeName == "Employee"){
                        $scope.generalinvoice.GIDtl[$scope.$index].isEmployee=true;
                    }else if(row.attributeName == "Agent"){
                        $scope.generalinvoice.GIDtl[$scope.$index].isAgent=true;
                    }else if(row.attributeName == "Customer"){
                        $scope.generalinvoice.GIDtl[$scope.$index].isCustomer=true;
                    }else if(row.attributeName == "Location"){
                        $scope.generalinvoice.GIDtl[$scope.$index].isLocation=true;
                    }else if(row.attributeName == "Company"){
                        $scope.generalinvoice.GIDtl[$scope.$index].isCompany=true;
                    }else if(row.attributeName == "Designation"){
                        $scope.generalinvoice.GIDtl[$scope.$index].isDesignation=true;
                    }else if(row.attributeName == "Cost Center"){
                        $scope.generalinvoice.GIDtl[$scope.$index].isCostCenter=true;
                    }else if(row.attributeName == "Supplier"){
                        $scope.generalinvoice.GIDtl[$scope.$index].isSupplier=true;
                    }
                    });
                }).error(function(datas) {
            });
        }
    });
   
    
    $scope.calculateAmount = function(customer,bank,chargeHead,qty,exchangeRate,rate, index, row) {
        debugger;
        if (customer !=null && bank !=null && chargeHead != null && qty !=null && exchangeRate!=0 && rate!=0 ) {
        	$http.get($stateParams.tenantid+ '/app/generalinvoice/getTax?chargeHead='+ chargeHead + '&customer=' + customer + '&bank=' + bank).success(function(datas) {
    			var taxPrct = datas.taxPrct;
    			var amt=parseFloat(qty)*parseFloat(exchangeRate)*parseFloat(rate);
    			var taxAmt = parseFloat(amt) *((taxPrct)/100);
        		
    			$scope.generalinvoice.GIDtl[index].amount = parseFloat(amt).toFixed(2);
        		$scope.generalinvoice.GIDtl[index].taxAmount = parseFloat(taxAmt).toFixed(2);
        		$scope.calculateTotalAmount($scope.generalinvoice.GIDtl);
                }).error(function(datas) {
            });
        } else {
        	 logger.logError("Please fill required fields..");
        }
        
    };
  
    $scope.calculateTotalAmount = function(tables) {
        debugger;
        var Total = 0.0;
        angular.forEach(tables, function(value, key) {
        	Total = parseFloat(value.amount) + parseFloat(value.taxAmount) + Total;
        });
        $scope.generalinvoice.totalAmount = Total.toFixed(2);
    };
    
    $scope.showTax = function(customer,bank,chargeHead) {

		if (chargeHead != "" && customer != "" && bank !="" ) {
			ngDialog
					.open({
						scope : $scope,
						template : 'views/finance/invoice/generalInvoice/generalInvoiceTaxView',
						controller : $controller(
								'InvoiceTaxCtrl',
								{
									$scope : $scope,
									purchaseObject : $scope.generalinvoice,
									customer : customer,
									bank : bank,
									chargeHead : chargeHead,
									
								}),
						className : 'ngdialog-theme-plain',
						showClose : false,
						closeByDocument : false,
						closeByEscape : false,
						preCloseCallback : $scope.getList
					});
		} else {
			logger.logError("Please select ChargeHead,Customer & Branch..");
		}

	}

   });

app.controller('InvoiceTaxCtrl', function($scope, $rootScope,
		sharedProperties, logger, $http, $filter, $location, $stateParams,
		validationService, toaster, $window, purchaseObject, ngDialog,
		$timeout,customer,bank,chargeHead ) {
	$scope.rowCollection = [];
	$http.get(
			$stateParams.tenantid + '/app/generalinvoice/getTaxList?chargeHead='+ chargeHead + '&customer=' + customer + '&bank=' + bank).success(
			function(response) {
				if(response.taxList.length!=0){
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

app.controller('generalInvoiceViewCtrl', function($scope, $window, $rootScope, $location, $filter, $http, logger, 
        $log, ngDialog, $modal, utilsService, ListService, $stateParams,$timeout,validationService,toaster,$state) {
    
    $scope.generalinvoice = {
    		companyCode:'',
        	customer : '',
        	invoiceDt :'',
            tripRelated : false,
            jobOrderNo :'',
            pod :'',
            pol :'',
            bank :'',
            remarks:'',
            narration : '',
            currencyHdr:'',
            totalAmount:'',
            aol:'',
            aod:'',
            airJobOrderNo:'',
            GIDtl : []
        }
    
    $scope.generalInvoiceDtlList = function() {
        var giRow = {
        		select : '',
                chargeHead :'',
                unit :'',
                qty :'',
                rate :'',
                currencyDtl:'',
                amount:'',
                taxAmount:'',
                isHBL:false,
                isMBL:false,
                isHAWB:false,
                isMAWB:false,
                isFlightNo:false,
                isVoyage : false,
				isVessel : false,
				isService : false,
				isEmployee : false,
				isPort : false,
				isDepartment : false,
				isAgent : false,
				isLocation : false,
				isCustomer : false,
				isSupplier : false,
				isDesignation : false,
				isCostCenter : false,
				isCompany : false,
				isQuantityGO : false,
				isQuantityFO : false,
				isPortSequence : false,
				isFromDate : false,
				isToDate : false,
                isContainerNo:false,
                sacNo:''
        };
        $scope.generalinvoice.GIDtl.push(giRow);
    }

    $scope.generalInvoiceDtlList();
    
    var invoiceNo=$stateParams.invoiceNo;
   
            var url = $stateParams.tenantid+'/app/generalinvoice/getGeneralInvoiceView?invoiceNo=' + invoiceNo;
            $http.get(url).success(function(result) {
                debugger;
                console.log(result);
                $scope.generalinvoice = result;
            }).error(function(result) {
                logger.logError("Error Please Try Again");
            });
  
    $scope.cancel1 = function() {
        $state.go('app.reports.finance.invoiceInformation',{tenantid:$stateParams.tenantid});
    };
    
    /**
     * print
     */
    $scope.printGeneralInvoiceDiv = function(invoiceNo){
        
        console.log("print invoice")
        var url = $stateParams.tenantid+'/app/generalinvoice/print?invoiceNo=' + invoiceNo;
        var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
        wnd.print();   
     }

    $scope.cancel = function() {
        $location.path($stateParams.tenantid+"/invoice/generalinvoice/list");
    };
});

app.service("ListService", function($http, $q,$stateParams) {

    this.getCustomerList = function() {
        var customerList = $q.defer();
        $http.get($stateParams.tenantid+'/app/generalinvoice/getCustomerList').success(function(data) {
            customerList.resolve(data);
        }).error(function(data) {
            customerList.reject("Failed to get Customer List");
        });
        return customerList.promise;
    }

    this.getCustomerListByVoyage = function(VoyageCode) {
        var customerList = $q.defer();
        $http.get($stateParams.tenantid+'/app/generalinvoice/getCustomerListByVoyage?VoyageCode=' + VoyageCode).success(function(data) {
            customerList.resolve(data);
        }).error(function(data) {
            customerList.reject("Failed to get Customer List");
        });
        return customerList.promise;
    }
    
    this.getMloList = function(customerCode,pol) {
        var mloList = $q.defer();
        $http.get($stateParams.tenantid+'/app/generalinvoice/getMloList?CustomerCode=' + customerCode+'&pol=' +pol).success(function(data) {
            mloList.resolve(data);
            

        }).error(function(data) {

            mloList.reject("Failed to get Customer List");

        });
        return mloList.promise;
    }

    this.getVesselList = function() {
        var voyageList = $q.defer();
        $http.get($stateParams.tenantid+'/app/generalinvoice/getVesselList').success(function(data) {
            voyageList.resolve(data);

        }).error(function(data) {

            voyageList.reject("Failed to get Voyage Vessel List");

        });
        return voyageList.promise;
    }
    this.getVoyageList = function(vesselCode) {
        var voyageList = $q.defer();
        $http.get($stateParams.tenantid+'/app/generalinvoice/getVoyageList?vesselCode=' + vesselCode).success(function(data) {
            voyageList.resolve(data);

        }).error(function(data) {

            voyageList.reject("Failed to get Voyage Vessel List");

        });
        return voyageList.promise;
    }
    
    

    this.getCompanyCurrency = function(companyCode) {
        var voyageList = $q.defer();
        $http.get('app/generalinvoice/getVoyageList?vesselCode=' + vesselCode).success(function(data) {
            voyageList.resolve(data);

        }).error(function(data) {

            voyageList.reject("Failed to get Voyage Vessel List");

        });
        return voyageList.promise;
    }
    
    this.getBlList = function(VoyageId,pol,customer) {
        var blList = $q.defer();
        $http.get($stateParams.tenantid+'/app/generalinvoice/getBlList?voyageCode=' + VoyageId+'&pol=' +pol+'&customer='+customer).success(function(data) {
            blList.resolve(data);

        }).error(function(data) {

            blList.reject("Failed to get Customer List");

        });
        return blList.promise;
    }

    this.getPortList = function(VoyageId) {

        var portList = $q.defer();
        $http.get($stateParams.tenantid+'/app/generalinvoice/getportList?voyageCode=' + VoyageId).success(function(data) {
            portList.resolve(data);

        }).error(function(data) {

            portList.reject("Failed to get portList List");

        });
        return portList.promise;
    }
    
    this.getSubAccountList = function(){
        var subAccountList = $q.defer();
        $http.get($stateParams.tenantid+'/app/commonUtility/getSubAccountCodeList').success(function(datas) {
            subAccountList.resolve(datas.commonUtilityBean);
        }).error(function(data) {
            subAccountList.reject("Failed to get Sub Account Code List");
        });
        return subAccountList.promise;
    }
    
    this.getAccountHeadList = function() {

        var accountHeadList = $q.defer();
        $http.get($stateParams.tenantid+'/app/generalinvoice/getAccountHeadList').success(function(data) {
            accountHeadList.resolve(data);

        }).error(function(data) {

            accountHeadList.reject("Failed to get Account head List");

        });
        return accountHeadList.promise;
    }

    this.getDateInDDMMYYYY = function convert(str) {
        var date = new Date(str), mnth = ("0" + (date.getMonth() + 1)).slice(-2), day = ("0" + date.getDate()).slice(-2);
        return [ day, mnth, date.getFullYear() ].join("-");
    }
});

app.controller('GItableCtrl', function($scope,$http, $filter,logger,$stateParams){
    debugger;
    alert(5456);
    $scope.$watch('generalinvoice.GIDtl[trIndex].chargeHead', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
                debugger;
                alert("tes");

              $http.get($stateParams.tenantid+'/app/generalinvoice/getSacNo?chargeHead='+newValue).success(function(datas) {
                    console.log(datas);
                    $scope.generalinvoice.GIDtl[$scope.$index].sacNo = datas.sacNo;
                    
                    }).error(function(datas) {
                });
                
                $http.get($stateParams.tenantid+'/app/generalinvoice/getAttributesList?chargeHead='+newValue).success(function(datas) {
                $scope.generalinvoice.GIDtl[$scope.$index].attributeList=datas;
                
                $scope.generalinvoice.GIDtl[$scope.$index].isHBL=false;
                $scope.generalinvoice.GIDtl[$scope.$index].isMBL=false;
                $scope.generalinvoice.GIDtl[$scope.$index].isHAWB=false;
                $scope.generalinvoice.GIDtl[$scope.$index].isMAWB=false;
                $scope.generalinvoice.GIDtl[$scope.$index].isFlightNo=false;
                $scope.generalinvoice.GIDtl[$scope.$index].isVessel=false;
                $scope.generalinvoice.GIDtl[$scope.$index].isContainerNo=false;
                $scope.generalinvoice.GIDtl[$scope.$index].isVoyage = false;
				//$scope.generalinvoice.GIDtl[$scope.$index].isVessel = false;
				$scope.generalinvoice.GIDtl[$scope.$index].isService = false;
				$scope.generalinvoice.GIDtl[$scope.$index].isEmployee = false;
				$scope.generalinvoice.GIDtl[$scope.$index].isPort = false;
				$scope.generalinvoice.GIDtl[$scope.$index].isDepartment = false;
				$scope.generalinvoice.GIDtl[$scope.$index].isAgent = false;
				$scope.generalinvoice.GIDtl[$scope.$index].isLocation = false;
				$scope.generalinvoice.GIDtl[$scope.$index].isCustomer = false;
				$scope.generalinvoice.GIDtl[$scope.$index].isSupplier = false;
				$scope.generalinvoice.GIDtl[$scope.$index].isDesignation = false;
				$scope.generalinvoice.GIDtl[$scope.$index].isCostCenter = false;
             
                angular.forEach($scope.generalinvoice.GIDtl[$scope.$index].attributeList, function(row, rowindex) {
                    if(row.attributeName == "HBL"){
                        $scope.generalinvoice.GIDtl[$scope.$index].isHBL=true;
                    }else if(row.attributeName == "MBL"){
                        $scope.generalinvoice.GIDtl[$scope.$index].isMBL=true;
                    }else if(row.attributeName == "HAWB"){
                        $scope.generalinvoice.GIDtl[$scope.$index].isHAWB=true;
                    }else if(row.attributeName == "MAWB"){
                        $scope.generalinvoice.GIDtl[$scope.$index].isMAWB=true;
                    }else if(row.attributeName == "Flight No"){
                        $scope.generalinvoice.GIDtl[$scope.$index].isFlightNo=true;
                    }else if(row.attributeName == "Vessel & Voyage"){
                        $scope.generalinvoice.GIDtl[$scope.$index].isVessel=true;
                    }else if(row.attributeName == "Container No"){
                        $scope.generalinvoice.GIDtl[$scope.$index].isContainerNo=true;
                    }else if(row.attributeName == "Vessel"){
                        $scope.generalinvoice.GIDtl[$scope.$index].isVessel=true;
                    }else if(row.attributeName == "Voyage"){
                        $scope.generalinvoice.GIDtl[$scope.$index].isVoyage=true;
                    }else if(row.attributeName == "Service"){
                        $scope.generalinvoice.GIDtl[$scope.$index].isService=true;
                    }else if(row.attributeName == "Port"){
                        $scope.generalinvoice.GIDtl[$scope.$index].isPort=true;
                    }else if(row.attributeName == "Department"){
                        $scope.generalinvoice.GIDtl[$scope.$index].isDepartment=true;
                    }else if(row.attributeName == "Employee"){
                        $scope.generalinvoice.GIDtl[$scope.$index].isEmployee=true;
                    }else if(row.attributeName == "Agent"){
                        $scope.generalinvoice.GIDtl[$scope.$index].isAgent=true;
                    }else if(row.attributeName == "Customer"){
                        $scope.generalinvoice.GIDtl[$scope.$index].isCustomer=true;
                    }else if(row.attributeName == "Location"){
                        $scope.generalinvoice.GIDtl[$scope.$index].isLocation=true;
                    }else if(row.attributeName == "Company"){
                        $scope.generalinvoice.GIDtl[$scope.$index].isCompany=true;
                    }else if(row.attributeName == "Designation"){
                        $scope.generalinvoice.GIDtl[$scope.$index].isDesignation=true;
                    }else if(row.attributeName == "Cost Center"){
                        $scope.generalinvoice.GIDtl[$scope.$index].isCostCenter=true;
                    }else if(row.attributeName == "Supplier"){
                        $scope.generalinvoice.GIDtl[$scope.$index].isSupplier=true;
                    }
                    });
                }).error(function(datas) {
            });
        }
    });
   
    
    $scope.$watch('generalinvoice.GIDtl[trIndex].currencyDtl', function(newValue, oldValue) {
    	
        if (newValue != '' && newValue != undefined) {
        	debugger;
            $http.get($stateParams.tenantid+ '/app/generalinvoice/getexchangeRate?currency='+ newValue).success(function(datas) {
    			$scope.generalinvoice.GIDtl[$scope.$index].exchangeRate = datas.exchangeRt;
                
                }).error(function(datas) {
            });
        }
   });
});
app.controller('GItableViewCtrl', function($scope,$http, $filter,logger,$stateParams){
    
   /* $scope.$watch('generalinvoice.giDtl[trIndex].chargeHead', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
                debugger;
                $http.get($stateParams.tenantid+'/app/generalinvoice/getAttributesList?chargeHead='+newValue).success(function(datas) {
                $scope.generalinvoice.giDtl[$scope.$index].attributeList=datas;
                
                
                $scope.generalinvoice.giDtl[$scope.$index].isHBL=false;
                $scope.generalinvoice.giDtl[$scope.$index].isMBL=false;
                $scope.generalinvoice.giDtl[$scope.$index].isHAWB=false;
                $scope.generalinvoice.giDtl[$scope.$index].isMAWB=false;
                $scope.generalinvoice.giDtl[$scope.$index].isFlightNo=false;
                $scope.generalinvoice.giDtl[$scope.$index].isVessel=false;
                $scope.generalinvoice.giDtl[$scope.$index].isContainerNo=false;
                
             
                angular.forEach($scope.generalinvoice.giDtl[$scope.$index].attributeList, function(row, rowindex) {
                    if(row.attributeName == "HBL"){
                        $scope.generalinvoice.giDtl[$scope.$index].isHBL=true;
                    }else if(row.attributeName == "MBL"){
                        $scope.generalinvoice.giDtl[$scope.$index].isMBL=true;
                    }else if(row.attributeName == "HAWB"){
                        $scope.generalinvoice.giDtl[$scope.$index].isHAWB=true;
                    }else if(row.attributeName == "MAWB"){
                        $scope.generalinvoice.giDtl[$scope.$index].isMAWB=true;
                    }else if(row.attributeName == "Flight No"){
                        $scope.generalinvoice.giDtl[$scope.$index].isFlightNo=true;
                    }else if(row.attributeName == "Vessel & Voyage"){
                        $scope.generalinvoice.giDtl[$scope.$index].isVessel=true;
                    }else if(row.attributeName == "Container No"){
                        $scope.generalinvoice.giDtl[$scope.$index].isContainerNo=true;
                    }
                    });
                }).error(function(datas) {
            });
        }
    });*/
    
    
});