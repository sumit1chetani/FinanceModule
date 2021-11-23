'use strict';
app.controller('freightAddCtrl', function($scope, $stateParams, $controller ,$window, $rootScope, $location, $http, logger, $log, 
        ngDialog, $modal, utilsService, $state) {

	$scope.pendingBlList = [];
	$scope.checktypeList = [];
	 $scope.carrierList =[];
	 $scope.checktypeList=[
		 
		  { id: 'BILL OF LADING FEE', text: 'BILL OF LADING FEE' },
		  { id: 'SEA WAYBILL FEE', text: 'SEA WAYBILL FEE' }
		
	]
//	   / var dd = today. getDate();

    $scope.invoiceData = {
   		 invoiceNo :'',
   		 agent : '',
   		 agentName : '',
   		 blNo : '',
   		 billDate: '',
   		 pol: '',carrier:'',
   		 mode :'',
   		 agentNameview : '',
   		 customer: '',
   		 customerName: '',
   		 vessel: '',
   		 vesselName: '',
   		 voyage: '',
   		 voyageName: '',
   		 bookingNo: '',
   		 total : 0,
   		 grandTotal: 0,
   		 quotation : '',
   		 exchangeRate : 1.0,
   		 currency : '',
   	     showaddcharge : false,
   		 chargesDetails : [],
   		 detailList	: [],
   		checktype : ''
//   		 checktype : 'BILL OF LADING FEE'
    }
	 

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
	$scope.invoiceData.billDate = today;
	
 	 $scope.$watch('invoiceData.billDate', function(value, oldValue) {
	    	debugger
	        if (value != '' && value != undefined) {
	            var res = value.split("/");
	            var formCode ='F0099';
	            $http.get($stateParams.tenantid+'/app/cashbankreceipt/getloggedcompany?closingDate='+value+'&formCode='+formCode).success(function(datas) {
	                if(datas){
	                    logger.logError("Account closed for year "+ res[2]);
	                    $scope.invoiceData.billDate  = '';
 

	                }
	            })
	        }
	    }); 
	    
 	$http.get($stateParams.tenantid+'/app/commonUtility/getcarrierList').success(function(datas) {
		debugger
	    $scope.carrierList = datas.commonUtilityBean;	    
        //$scope.transList = datas.lCommonUtilityBean;	    

	}).error(function(data) {

	});
    $http.get($stateParams.tenantid+'/app/freightinvoice/pendingBlList').success(function(response) {
        $scope.pendingBlList = response.list;
    });

    $http.get($stateParams.tenantid+ '/app/commonUtility/getPortinnsa').success(function(data) {

    $scope.terminalList = data.commonUtilityBean;


    });
   /* $scope.terminalList=[
		 
		  { id: 'BILL OF LADING FEE', text: 'BILL OF LADING FEE' },
		  { id: 'SEA WAYBILL FEE', text: 'SEA WAYBILL FEE' }
		
	]*/
    //$scope.details=false;
  	$scope.$watch('invoiceData.blNo', function(newValue, oldValue) {
  		console.log("testing the watch-BL No");
  		$scope.invoiceData.terminalvar='';
  	//	$scope.invoiceData=[];
  		 var str=$scope.invoiceData.blNo;
  		$scope.invoiceData.temp = str.substring(5, 8);
  		// var res=	$scope.invoiceData.temp;
  	/*	$scope.invoiceData.temp="NSA";
  		if(res=="NSA"){
  			$scope.details=true;
  		}*/
  	  	$scope.details=false;
  	  	if($scope.invoiceData.temp=="NSA"){
  	  		$scope.details=true;
  	  	}  
  	  	
  	  //	else
  		if($scope.invoiceData.blNo !=null && $scope.invoiceData.blNo !='' && $scope.invoiceData.blNo != undefined){
  			
  	        $http.get($stateParams.tenantid+'/app/freightinvoice/getInvoiceDetails?blNo=' + $scope.invoiceData.blNo +'&checktype=' +$scope.invoiceData.checktype).success(function(data) {

    		  if(data.success==true){
    			  
    			  if($scope.invoiceData.temp=="NSA"){
    				 	//$scope.invoiceData = data.invoiceBean.quoteport;
    				 	if(data.invoiceBean.pol!= data.invoiceBean.quoteport){
    				 		$scope.invoiceData.terminalvar= data.invoiceBean.pol;
    				}
    				 	
    				 	else{
    				 		$scope.invoiceData.vesselName = data.invoiceBean.vesselName;
    	    			  	$scope.invoiceData.voyageName = data.invoiceBean.voyageName;
    	    			  	$scope.invoiceData.pol=data.invoiceBean.pol;
    						$scope.invoiceData.bookingNo =  data.invoiceBean.bookingNo;
    						$scope.invoiceData.quotation =  data.invoiceBean.quotation;
    						$scope.invoiceData.freightTypeName =  data.invoiceBean.freightTypeName;
    						$scope.invoiceData.currency =  data.invoiceBean.currency;
    						$scope.invoiceData.customerName =  data.invoiceBean.customerName;
    						$scope.invoiceData.quanrate =  data.invoiceBean.quanrate;
    						$scope.invoiceData.grandTotal =  data.invoiceBean.grandTotal;
    	    		  	  	$scope.invoiceData.sailDate = data.invoiceBean.sailDate;
    	    		  	  $scope.invoiceData.accountcode = data.invoiceBean.accountcode;
    	    		  	  	$scope.invoiceData.checktype=$scope.invoiceData.checktype;
    						$scope.invoiceData.detailList =  data.detailList;
    	    		  	  	}	
    		  	  	}else{
    		  	  	$scope.invoiceData.vesselName = data.invoiceBean.vesselName;
    			  	$scope.invoiceData.voyageName = data.invoiceBean.voyageName;
    			  	$scope.invoiceData.pol=data.invoiceBean.pol;
					$scope.invoiceData.bookingNo =  data.invoiceBean.bookingNo;
					$scope.invoiceData.quotation =  data.invoiceBean.quotation;
					$scope.invoiceData.freightTypeName =  data.invoiceBean.freightTypeName;
					$scope.invoiceData.currency =  data.invoiceBean.currency;
					$scope.invoiceData.customerName =  data.invoiceBean.customerName;
					$scope.invoiceData.quanrate =  data.invoiceBean.quanrate;
					$scope.invoiceData.grandTotal =  data.invoiceBean.grandTotal;
    		  	  	$scope.invoiceData.sailDate = data.invoiceBean.sailDate;
	    		  	  $scope.invoiceData.accountcode = data.invoiceBean.accountcode;
    			  	$scope.invoiceData.checktype=$scope.invoiceData.checktype;
					$scope.invoiceData.detailList =  data.detailList;
    		  	  	}
					
    		  }else{
    			  logger.logError(data.message);
    			  $scope.reset();
    		  }
    	  });
  		}
  });
  	$scope.$watch('invoiceData.carrier', function(newValue, oldValue) {
      if(newValue!=null && newValue!=undefined && newValue != ''){
          $http.post($stateParams.tenantid+'/app/freightinvoice/pendingBlListCarr',$scope.invoiceData).success(function(savResult) {
         $scope.pendingBlList = savResult.list;
     })
     }
  	});

  	$scope.$watch('invoiceData.terminalvar', function(newValue, oldValue) {
  		console.log("testing the watch collection - checktype and blno");
 // 		$scope.invoiceData=[];
  		/*if($scope.invoiceBean.pol=$scope.invoiceData.terminalvar)
  			{
  			 logger.logError("Same Terminal already Exists");
  			$scope.invoiceData.terminalvar='';
  			}*/
  	//	else{
  		if(
  			$scope.invoiceData.blNo !=null && $scope.invoiceData.blNo !='' && $scope.invoiceData.blNo != undefined&&
  			$scope.invoiceData.terminalvar !=null && $scope.invoiceData.terminalvar !='' && $scope.invoiceData.terminalvar != undefined )
  		{	//if($scope.invoiceData.pol!= $scope.invoiceData.quoteport){
  			
  	        $http.get($stateParams.tenantid+'/app/freightinvoice/getInvoiceDetailsonTerminalchange?blNo=' 
  	        		+ $scope.invoiceData.blNo +'&checktype=' +$scope.invoiceData.checktype+'&terminal=' +$scope.invoiceData.terminalvar).success(function(data) {

    		  if(data.success==true){
    			  	$scope.invoiceData = data.invoiceBean;
    			  	$scope.invoiceData.checktype=$scope.invoiceData.checktype;
					$scope.invoiceData.detailList =  data.detailList;
					
    		  }else{
    			  logger.logError(data.message);
    			  $scope.reset();
    		  }
    	  });
  	//	}
  		}
  		//}
  });
	$scope.$watch('invoiceData.checktype', function(newValue, oldValue) {
  		console.log("testing the watch collection - checktype and blno");
  		
  		if($scope.invoiceData.checktype !=null && $scope.invoiceData.checktype !='' && $scope.invoiceData.checktype != undefined &&
  			$scope.invoiceData.blNo !=null && $scope.invoiceData.blNo !='' && $scope.invoiceData.blNo != undefined )
  		{
  	        $http.get($stateParams.tenantid+'/app/freightinvoice/getInvoiceDetails?blNo=' + $scope.invoiceData.blNo +'&checktype=' +$scope.invoiceData.checktype).success(function(data) {

    		  if(data.success==true){
    			  	$scope.invoiceData = data.invoiceBean;
    			  	$scope.invoiceData.checktype=$scope.invoiceData.checktype;
					$scope.invoiceData.detailList =  data.detailList;
					
    		  }else{
    			  logger.logError(data.message);
    			  $scope.reset();
    		  }
    	  });
  		}
  });
    
//     $scope.$watch('invoiceData.blNo', function(newValue, oldValue) {
//	      if(newValue!=null && newValue!=undefined && newValue != ''){
//	    	
//	      }else{
//	    	  $scope.reset();
//	      }
//	 });
     
    
    $scope.save = function(invoiceForm){
    	//if (new validationService() .checkFormValidity(invoiceForm)) {
    		if($scope.invoiceData.billDate !=null && $scope.invoiceData.billDate !='' ){
    		if( ($scope.invoiceData.total!=null &&  $scope.invoiceData.grandTotal!=null) && ($scope.invoiceData.total>0 || $scope.invoiceData.grandTotal>0) ){
    			$scope.invoiceData.mode="S";
    		var saveInvcData = {
                    'invoiceBean' : $scope.invoiceData ,
            };
            console.log(saveInvcData);
            $http.post($stateParams.tenantid+'/app/freightinvoice/savefreightinvoice',saveInvcData).success(function(savResult) {
                console.log(savResult);
                
                if(savResult.success == true || savResult.success == "true") {
                    logger.logSuccess('Invoice Generated Successfully');
                    $scope.cancel();
                } else {
                    logger.logError(savResult.message);
                }
                
            }).error(function(data) {
                logger.logError("Error Not Saved!");
            });
    	}else{
    		logger.logError("Invalid Amount!");
    	}
    		}else{
    			logger.logError("Invoice Date in Empty !");

    		}
        /*}else {
			toaster.pop( 'error',
					"Please fill the required fields",
					logger
							.getErrorHtmlNew(invoiceForm.$validationSummary),
					5000, 'trustedHtml');
}*/
    }
    
    
// Print Preview functionality
    $scope.printpreviewInvoice = function(invoiceForm){
    	//if (new validationService() .checkFormValidity(invoiceForm)) {
    		if($scope.invoiceData.billDate !=null && $scope.invoiceData.billDate !='' ){
    		if( ($scope.invoiceData.total!=null &&  $scope.invoiceData.grandTotal!=null) && ($scope.invoiceData.total>0 || $scope.invoiceData.grandTotal>0) ){
    			$scope.invoiceData.mode="P";
        		var saveInvcData = {
                        'invoiceBean' : $scope.invoiceData ,
                };
          $http.post($stateParams.tenantid+'/app/freightinvoice/save',saveInvcData).success(function(savResult) {
        	  if(savResult.message !=null && savResult.message !=''){
        		  logger.logError(savResult.message);
        	  }
        	  else{
        	  var invdraftNo = savResult.draftinvoiceNo;
              $timeout(function() {
                  var url = $stateParams.tenantid+'/app/freightinvoice/printinvoicepreview1?invoiceno=' + invdraftNo;
                  var wnd = window.open(url, 'Simatech', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
                  wnd.print();
              }, 1000);
        	  }
           
                
            }).error(function(data) {
                logger.logError("Error Not Saved!");
            });
    	}else{
    		logger.logError("Invalid Amount!");
    	}
    		}else{
    			logger.logError("Invoice Date in Empty !");

    		}
       /* }else {
			toaster.pop( 'error',
					"Please fill the required fields",
					logger
							.getErrorHtmlNew(invoiceForm.$validationSummary),
					5000, 'trustedHtml');
}*/
    }
    
    
   


    $scope.cancel = function() {
    	$state.go('app.finance.invoice.freightinvoice');
    };
    
    $scope.reset = function(){
    	$scope.invoiceData = {
    	   		 invoiceNo :'',
    	   		 agent : '',
    	   		 agentName : '',
    	   		 blNo : '',
    	   		 billDate: '',
    	   		 customer: '',
    	   		 customerName: '',
    	   		 vessel: '',
    	   		 vesselName: '',
    	   		 voyage: '',
    	   		 voyageName: '',
    	   		 bookingNo: '',
    	   		 total : 0,
    	   		 grandTotal: 0,
    	   		 quotation : '',
    	   		 exchangeRate : 1.0,
    	   		 currency : '',
    	   		 chargesDetails : [],
    	   		 detailList	: []
    	    }
    }
    

    $scope.showaddchargespopup = function(tables) {
   	 ngDialog.open({
            scope : $scope,
            template : 'views/documentation/invoice/additionalchargespopup',
            controller : $controller('additionalChargesCtrl', {
                $scope : $scope,
                rowData : tables
            }),
            className : 'ngdialog-theme-plain',
            showClose : false,
            closeByDocument : false,
            closeByEscape : false,
            preCloseCallback : $scope.getList
        });
        
    };
    
 
    
});


app.controller('algorithmModalCtrl', function($scope, $http, ngDialog, logger, $location) {

    $scope.closeHelpDialog = function() {
        ngDialog.close();
    };
});
app.controller('additionalChargesCtrl', function($scope, $stateParams,$rootScope, $http, $filter, logger, ngDialog,$timeout,rowData) {
	console.log(rowData);

	$scope.getdropdown = function() {
		  
		$http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(datas) {
				  $scope.shipmentList=datas.getshipmentlist;
				  $scope.portList=datas.getportlist;
				  $scope.customerDropList=datas.getcustomerlist;
				  $scope.currencyList=datas.getcurrencylist	;
				  $scope.conTypeList=datas.getcontypelist;
				   $scope.chargeTypeList=datas.getchargetypelist
			}).error(function(datas) {

			});
		
         }
		  $scope.getdropdown(); 
		  
		  $scope.shipmentList  = [];
			$scope.SpecialList  = [];
			$scope.cargoType  = [];
			$scope.nominatedDropList  = [];
			$scope.vendorDropList = [];
			$scope.serviceParnrDropList = [];
			$scope.portList=[];
			$scope.currencyList=[];
			$scope.shipmentTermlist=[]; 
				  
				  $scope.uomList=[
						 
					  { id: 'PER CTR', text: 'PER CTR' },
					  { id: 'PER DAY PER CNTR', text: 'PER DAY PER CNTR' },
					  { id: 'PER DAY PER MOVE', text: 'PER DAY PER MOVE' },
					  { id: 'PER CHASSIS', text: 'PER CHASSIS' },
					  { id: 'PER BL', text: 'PER BL' },
					  { id: 'PER DO', text: 'PER DO' }
					
				]
				  
				  $scope.contTypeList=[
						 
					  { id: 'Freight', text: 'Freight' },
					  { id: 'Local', text: 'Local' },
					  { id: 'LocalDest', text: 'LocalDest' }
					
				]
				  
				
				  
				  

			$scope.addRow = function() {

				$scope.max = Math.max.apply(Math, $scope.invoiceaddcharge.Dtl
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
					note : '',
					tariff : 0
				};

				$scope.invoiceaddcharge.Dtl.push(chargedata);
				var len = $scope.invoiceaddcharge.Dtl.length - 1;
				$timeout(function() {
					hideActivePapers($scope.max + "0", []);
				}, 1000);
				$scope.quotation.checkAll=false;
			}
			 
			 $scope.removeRow = function() {
					$scope.tablerow = [];
					for (var index = 0 ; index < 1; index++) {
					angular.forEach($scope.invoiceaddcharge.Dtl,function(row, index) {
								var check = row.select;
								
								if (check == undefined || check == "" ) {
									$scope.tablerow.push(row);
								} else if(index > 0){
									$scope.invoiceaddcharge.Dtl = $scope.tablerow;

								}
							});
					}
					
				};
				
				$scope.invoiceaddcharge={
						
						currencyName : 'USD',
						Dtl:[{id:0,quotationNoNew:rowData.quotation,termName:rowData.blNo,conType:'',surcharge:'',currency:'',qty:'',ratequotation:'',localCurrency:'',paymentMethod : '',transactionType : '',buySell : '',note : '',freeDays:0}]
		
				}
        


			    $scope.cancelng = function() {
			        ngDialog.close();
			    }
				

			    $scope.addAdditionalCharges = function(displayedCollection) {
			        debugger;
			        var isFlag = true;
			        var saveInvcData = {
		                    'invoiceBean' : rowData ,
		            };
		            console.log(saveInvcData);
			        angular.forEach(displayedCollection, function(row, index) {

			        	 $http.post($stateParams.tenantid+'/app/ratequotation/addquotefrominv', row).success(function(result) {
		                        console.log("result")
		                        if (result.success) {
		                        	//alert(result.code);
		                        	$scope.invoiceData.blNo=result.code;
		                        	

		                        	 $http.post($stateParams.tenantid+ '/app/freightinvoice/getInvoiceDetails?blNo=' + $scope.invoiceData.blNo +'&checktype=' +$scope.invoiceData.checktype).success(function(data) {
		               	    		  if(data.success==true){
		               	    			  	$scope.invoiceData = data.invoiceBean;
		               						$scope.invoiceData.detailList =  data.detailList;
		               						ngDialog.close();
		               						logger.logSuccess('Charges Added Successfully');
		               	    		  }else{
		               	    			  logger.logError(data.message);
		               	    			  $scope.reset();
		               	    		  }
		               	    	  });
		                        } else {
		                            if (result.message != '') {
		                                logger.logError(result.message);
		                            } 
		                            $('#addBtn,#updateBtn').attr('disabled', false);

		                        }

		                    }).error(function(data) {
		                        $('#addBtn,#updateBtn').attr('disabled', false);
		                        console.log(data);
		                    });

			        });

			        
			    }
			  
});
app.controller('invoiceViewController', function($scope, $timeout, $stateParams, $filter, $rootScope, $http, $location, logger, utilsService, $state,
		sharedProperties, $window, ngDialog, $interval, validationService, toaster, $controller, $injector) {
	$scope.pendingBlList = [];
    $scope.invoiceData = {
   		 invoiceNo :'',
   		 blNo : '',
   		 billDate: '',
   		 customer: '',
   		 customerName: '',
   		 agent : '',
   		 agentName : '',
   		 vessel: '',
   		 vesselName: '',
   		 voyage: '',
   		 voyageName: '',
   		 bookingNo: '',
   		 total : 0,
   		 grandTotal: 0,
   		 quotation : '',
  		 exchangeRate : 1.0,
  		 currency : '',
   		 chargesDetails : [],
   		 detailList	: []
    }
    
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
	
	var invoiceNo = $location.search().invoiceNo;
	
	if(invoiceNo!=null && invoiceNo!=undefined && invoiceNo!=''){
		  $http.post($stateParams.tenantid+ '/app/freightinvoice/viewDetails',invoiceNo).success(function(data) {
    		  if(data.success==true){
    			  	$scope.invoiceData = data.invoiceBean;
					$scope.invoiceData.chargesDetails =  data.invoiceBean.detailList;
					$scope.subtotal=0;
					for(var i = 0; i<$scope.invoiceData.chargesDetails.length;i++ ){
						var exchangeAmt = 0;
						if($scope.invoiceData.chargesDetails[i].exchangeRate > 0 && $scope.invoiceData.chargesDetails[i].exchangeRate !=null){
							$scope.invoiceData.chargesDetails[i].exchangeAmt =$scope.invoiceData.chargesDetails[i].quantity*$scope.invoiceData.chargesDetails[i].rate* $scope.invoiceData.chargesDetails[i].exchangeRate;
						}
						else{
							$scope.invoiceData.chargesDetails[i].exchangeAmt =$scope.invoiceData.chargesDetails[i].quantity*$scope.invoiceData.chargesDetails[i].rate;
						}
						$scope.invoiceData.chargesDetails[i].exchangeAmt = $scope.invoiceData.chargesDetails[i].exchangeAmt.toString();
						$scope.invoiceData.chargesDetails[i].exchangeAmt =$scope.invoiceData.chargesDetails[i].exchangeAmt.split('.')[0];
						$scope.invoiceData.chargesDetails[i].exchangeAmt = parseInt($scope.invoiceData.chargesDetails[i].exchangeAmt);
						$scope.subtotal =$scope.subtotal+ parseInt($scope.invoiceData.chargesDetails[i].exchangeAmt);
					}
//					$scope.invoiceData.billDate = today;
    		  }else{
    			  logger.logError(data.message);
    		  }
    	  });
	}
    
    $scope.cancel = function() {
    	$state.go('app.finance.invoice.freightinvoice');
    };
    
    $scope.printInvoice = function() {
        var url = $stateParams.tenantid+'/app/freightinvoice/print?invoiceno=' + invoiceNo;
        var wnd = window.open(url, 'Shipping', 'height=400,width=750,top=100,left=100,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
        wnd.print();
   
};
        
});

app.service("DateService",function($http,$q){
    
    this.getDateInDDMMYYYY=function convert(str) {
        var date = str.split('/');
        var datForChg = date[1]+"-"+date[0]+"-"+date[2];
        return datForChg;
    }
    this.getyear=function convert(str) {
        var date = str.split('/');
        var year = date[2];
        return year;
    }
});


app.controller('cashbankReceiptInvoiceDtlAddCtrl', function($scope, $stateParams,$rootScope, $http, $filter, logger, ngDialog, rowData, selectedRowId) {
    $scope.totalBCAmount = 0.0;
    $scope.totalTCAmount = 0.0;
    debugger;
    if (rowData.subAccountCode == "" || rowData.subAccountCode == undefined) {
        logger.logError("please select Sub account code");
    } else {
        $scope.rowCollection = [];
        $http.get($stateParams.tenantid+'/app/cashbankreceipt/getIAReceiptListWithCompany?customerCode=' + rowData.subAccountCode + '&companyCode=' + rowData.companyCode).success(function(datas) {
            debugger;
            console.log("kutti list")
            console.log(datas)
            $scope.receiptList = datas.lReceiptList;
            $scope.pendingInvoices = datas.lPendingInvoice;
            $scope.rowCollection = datas.lPendingInvoice;
            debugger;
            if (rowData.cbInvoiceDtl.length > 0) {
                angular.forEach(rowData.cbInvoiceDtl, function(row, index) {
                    var foundItemVen = $filter('filter')($scope.rowCollection, {
                        invoiceNo : row.invoiceNo
                    })[0];
                    var indexVen = $scope.rowCollection.indexOf(foundItemVen);
                    if (indexVen > -1) {
                        $scope.rowCollection[indexVen].select = true;
                        $scope.rowCollection[indexVen].paidTCAmount = rowData.cbInvoiceDtl[index].paidTCAmount;
                        $scope.rowCollection[indexVen].paidBCAmount = rowData.cbInvoiceDtl[index].paidBCAmount;
                    }
                });
                $scope.calculateTotalAmountForIA();
            }
            if ($scope.rowCollection.length < 0) {
                logger.logError("No pending invoice for this customer");
            }
        }).error(function(datas) {
        });
    }
   
 


});


app.controller('additionalChargesBookCtrl', function($scope, $stateParams,$rootScope, $http, $filter, logger, ngDialog,$timeout,rowData) {
	console.log(rowData);

	/*$scope.getdropdown = function() {*/
		  
		$http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(datas) {
				 
				  $scope.currencyList=datas.getcurrencylist	;
				  $scope.conTypeList=datas.getcontypelist;
				// $scope.chargeTypeList=datas.getchargetypelist
			}).error(function(datas) {

			});
		
		
		$http.post($stateParams.tenantid + '/app/ratequotation/getShipment').success(function(datas) {
			$scope.chargeTypeList = datas.getchargetypelistRRR;
			}).error(function(datas) {

			});
		
		
        /* }
		  $scope.getdropdown(); */
		$http.post($stateParams.tenantid+ '/api/localcharges/dropDown').success(function(data) {

			$scope.uomList = data.getuomList;
		    

		});
		  
//		  $scope.uomList=[
//				 
//			  { id: 'PER CTR', text: 'PER CTR' },
//			  { id: 'PER DAY PER CTR', text: 'PER DAY PER CTR' },
//			  { id: 'PER DAY PER MOVE', text: 'PER DAY PER MOVE' },
//			  { id: 'PER CHASSIS', text: 'PER CHASSIS' },
//			  { id: 'PER BL', text: 'PER BL' },
//			  { id: 'PER DO', text: 'PER DO' }
//			
//		]
		  
		  
		  $scope.contTypeList=[
				 
			  { id: 'Freight', text: 'Freight' },
			  { id: 'Local', text: 'Origin' },
			  { id: 'LocalDest', text: 'Destination' }
			
		]
		  
		  $scope.shipmentList  = [];
			$scope.SpecialList  = [];
			$scope.cargoType  = [];
			$scope.nominatedDropList  = [];
			$scope.vendorDropList = [];
			$scope.serviceParnrDropList = [];
			$scope.portList=[];
			$scope.currencyList=[];
			$scope.shipmentTermlist=[]; 
			$http.post($stateParams.tenantid+ '/api/localcharges/dropDown').success(function(data) {

				$scope.uomList = data.getuomList;
			    

			});
//				  $scope.uomList=[
//						 
//					  { id: 'PER CTR', text: 'PER CTR' },
//					  { id: 'PER DAY PER CNTR', text: 'PER DAY PER CNTR' },
//					  { id: 'PER DAY PER MOVE', text: 'PER DAY PER MOVE' },
//					  { id: 'PER CHASSIS', text: 'PER CHASSIS' },
//					  { id: 'PER BL', text: 'PER BL' },
//					  { id: 'PER DO', text: 'PER DO' }
//					
//				]
				  
				  $scope.contTypeList=[
						 
					  { id: 'Freight', text: 'Freight' },
					  { id: 'Local', text: 'Local' },
					  { id: 'LocalDest', text: 'LocalDest' }
					
				]
				  
				  
					$http.get($stateParams.tenantid + '/app/booking/getCountBookAddChargeDtlfri?bkno='+rowData.bookingNo).success(
							function(data) {
								if(data> 0)
									{
								
									$http.get($stateParams.tenantid + '/app/booking/getAddChargeDtlFri?bkno='+rowData.bookingNo).success(
											function(response1) {
												$scope.bookingData.addchargeData = response1;
											 
											});
									}
							 
							});
				  
				  
			
									
									

			$scope.addAdditionalRow = function() {

				$scope.max = Math.max.apply(Math, $scope.bookingData.addchargeData
						.map(function(item) {
							return item.id;
						}));
				$scope.max = $scope.max + 1;
				var chargedata = {
					bookingDtlId : $scope.max,
					bookingNo:rowData.bookingNo,
					surcharge : '',
					chargeType : '',
					uom : '',
					conType: '',
					addchrgcurrency: '',
					addchrgtax: '',
					bookingrate: '',
					bookingqty: '',
					bookremarks: '',
					hazardous : false,
					isOog : false
				};

				$scope.bookingData.addchargeData.push(chargedata);
				var len = $scope.bookingData.addchargeData.length - 1;
				$timeout(function() {
					//hideActivePapers($scope.max + "0", []);
				}, 1000);
				//$scope.quotation.checkAll=false;
			}
			 
			 $scope.removeAddRow = function() {
					$scope.tablerow = [];
					for (var index = 0 ; index < 1; index++) {
					angular.forEach($scope.bookingData.addchargeData,function(row, index) {
								var check = row.select;
								
								if (check == undefined || check == "" ) {
									$scope.tablerow.push(row);
								} else if(index > 0){
									$scope.bookingData.addchargeData = $scope.tablerow;

								}
							});
					}
					
				};
				
				$scope.bookingData={
						
						currencyName : 'USD',
						addchargeData:[
							
							{
							
								bookingDtlId :0,
								bookingNo:rowData.bookingNo,
								surcharge : '',
								chargeType : '',
								uom : '',
								conType: '',
								addchrgcurrency: '',
								addchrgtax: '',
								bookingrate: '',
								bookingqty: '',
								bookremarks: '',
								hazardous : false,
								isOog : false
								
							}
							]
		
				}
        


			    $scope.cancelngBook = function() {
			        ngDialog.close();
			    }
				

			    $scope.addAdditionalChargesBook = function(displayedCollection) {
			        debugger;
			        var isFlag = true;
			        var saveInvcData = {
		                    bookingBean : $scope.bookingData ,
		            };
		            console.log(saveInvcData);
		            
		            
		            $http .post( $stateParams.tenantid + '/app/booking/FriinvoiceAdd', saveInvcData) .success(	function(data) {
						if (data.success == true) {    
							
							
							$scope.invoiceData.blNo=rowData.blNo;
							$scope.invoiceData.typech=rowData.typech;
                    	
                    	if($scope.invoiceData.blNo !=null && $scope.invoiceData.blNo !='' && $scope.invoiceData.blNo != undefined){
                  			
                  	        $http.get($stateParams.tenantid+'/app/invoice/getInvoiceDetails?blNo=' + $scope.invoiceData.blNo +'&checktype=' +$scope.invoiceData.checktype+'&chargetype=' +$scope.invoiceData.typech).success(function(data) {

                    		  if(data.success==true){
                    			  
                    			  if($scope.invoiceData.temp=="NSA"){
                    				 	//$scope.invoiceData = data.invoiceBean.quoteport;
                    				 	if(data.invoiceBean.pol!= data.invoiceBean.quoteport){
                    				 		$scope.invoiceData.terminalvar= data.invoiceBean.pol;
                    				}
                    				 	
                    				 	else{
                    	    			  	$scope.invoiceData = data.invoiceBean;
                    	    			  	$scope.invoiceData.checktype=$scope.invoiceData.checktype;
                    						$scope.invoiceData.detailList =  data.detailList;
                    	    		  	  	}	
                    		  	  	}else{
                    			  	$scope.invoiceData = data.invoiceBean;
                    			  	$scope.invoiceData.checktype=$scope.invoiceData.checktype;
                					$scope.invoiceData.detailList =  data.detailList;
                    		  	  	}
                					
                    		  }else{
                    			  logger.logError(data.message);
                    			 // $scope.reset();
                    		  }
                    	  });
                  		}
                    	ngDialog.close();
   						logger.logSuccess('Charges Added Successfully');
						} else {
							if (data.message != null && data.message != '') {
								logger.logError(data.message)
							} else {
								logger.logError("Cannot be saved. Please try again");
							}
						}
					});	
		            
		          
		       }
			  
});
app.service("DateService",function($http,$q){
    
    this.getDateInDDMMYYYY=function convert(str) {
        var date = str.split('/');
        var datForChg = date[1]+"-"+date[0]+"-"+date[2];
        return datForChg;
    }
    this.getyear=function convert(str) {
        var date = str.split('/');
        var year = date[2];
        return year;
    }
});


app.controller('cashbankReceiptInvoiceDtlAddCtrl', function($scope, $stateParams,$rootScope, $http, $filter, logger, ngDialog, rowData, selectedRowId) {
    $scope.totalBCAmount = 0.0;
    $scope.totalTCAmount = 0.0;
    debugger;
    if (rowData.subAccountCode == "" || rowData.subAccountCode == undefined) {
        logger.logError("please select Sub account code");
    } else {
        $scope.rowCollection = [];
        $http.get($stateParams.tenantid+'/app/cashbankreceipt/getIAReceiptListWithCompany?customerCode=' + rowData.subAccountCode + '&companyCode=' + rowData.companyCode).success(function(datas) {
            debugger;
            console.log("kutti list")
            console.log(datas)
            $scope.receiptList = datas.lReceiptList;
            $scope.pendingInvoices = datas.lPendingInvoice;
            $scope.rowCollection = datas.lPendingInvoice;
            debugger;
            if (rowData.cbInvoiceDtl.length > 0) {
                angular.forEach(rowData.cbInvoiceDtl, function(row, index) {
                    var foundItemVen = $filter('filter')($scope.rowCollection, {
                        invoiceNo : row.invoiceNo
                    })[0];
                    var indexVen = $scope.rowCollection.indexOf(foundItemVen);
                    if (indexVen > -1) {
                        $scope.rowCollection[indexVen].select = true;
                        $scope.rowCollection[indexVen].paidTCAmount = rowData.cbInvoiceDtl[index].paidTCAmount;
                        $scope.rowCollection[indexVen].paidBCAmount = rowData.cbInvoiceDtl[index].paidBCAmount;
                    }
                });
                $scope.calculateTotalAmountForIA();
            }
            if ($scope.rowCollection.length < 0) {
                logger.logError("No pending invoice for this customer");
            }
        }).error(function(datas) {
        });
    }
   
 


});


