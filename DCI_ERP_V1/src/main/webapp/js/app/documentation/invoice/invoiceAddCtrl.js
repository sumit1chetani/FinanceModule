'use strict';
app.controller('invoiceAddController', function($scope, $timeout, $stateParams, $filter, $rootScope, $http, $location, logger, utilsService, $state,
		sharedProperties, $window, ngDialog, $interval, validationService, toaster, $controller, $injector) {

	$scope.pendingBlList = [];
    $scope.invoiceData = {
   		 invoiceNo :'',
   		 agent : '',
   		 agentName : '',
   		 blNo : '',
   		 billDate: '',
   		 pol: '',

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
	//$scope.invoiceData.billDate = today;
	
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
	    
	
    $http.get($stateParams.tenantid+'/app/invoice/pendingBlList').success(function(response) {
        $scope.pendingBlList = response.list;
    });
    
     $scope.$watch('invoiceData.blNo', function(newValue, oldValue) {
	      if(newValue!=null && newValue!=undefined && newValue != ''){
	    	  $http.post($stateParams.tenantid+ '/app/invoice/getInvoiceDetails',newValue).success(function(data) {
	    		  if(data.success==true){
	    			  	$scope.invoiceData = data.invoiceBean;
						$scope.invoiceData.detailList =  data.detailList;
						//$scope.invoiceData.billDate = today;
	    		  }else{
	    			  logger.logError(data.message);
	    			  $scope.reset();
	    		  }
	    	  });
	      }else{
	    	  $scope.reset();
	      }
	 });
     
    $scope.save = function(invoiceForm){
    	if (new validationService() .checkFormValidity(invoiceForm)) {
    		if($scope.invoiceData.billDate !=null && $scope.invoiceData.billDate !='' ){
    		if( ($scope.invoiceData.total!=null &&  $scope.invoiceData.grandTotal!=null) && ($scope.invoiceData.total>0 || $scope.invoiceData.grandTotal>0) ){
            var saveInvcData = {
                    'invoiceBean' : $scope.invoiceData ,
            };
            console.log(saveInvcData);
            $http.post($stateParams.tenantid+'/app/invoice/save',saveInvcData).success(function(savResult) {
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
        }else {
			toaster.pop( 'error',
					"Please fill the required fields",
					logger
							.getErrorHtmlNew(invoiceForm.$validationSummary),
					5000, 'trustedHtml');
}
    }
    
    $scope.cancel = function() {
    	$state.go('app.documentation.invoice');
//        $location.path("/documentation/invoice");
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
//    $scope.$watch('invoiceData.blNo', function(newValue, oldValue) {
//        $scope.vesselData.service = '';
//        $scope.vesselData.activity = '';
//        $scope.vesselData.portid = '';
//        $scope.vesselData.slot = '';
//        $scope.vesselData.mlo = '';
//        $scope.vesselData.blno = '';
//        $scope.polList = [];
//        $scope.slotList = [];
//        $scope.mloList = [];
//        $scope.blnoList = [];
//      if(newValue != ''){
//          $scope.onChangeVoyage($scope.vesselData.voyageNo);
//          if(document.getElementById('exchangerate').value!=null && document.getElementById('exchangerate').value!=""){
//              $scope.IsVisible = $scope.IsVisible ? false : true;
//              document.getElementById('invoiceDate').disabled = false;
//              $scope.vesselData.exchangerate = '';
//              $scope.vesselData.mlotxt = '';
//              $scope.vesselData.payer = '';
//              $scope.vesselData.currency = '';
//              $scope.vesselData.validtill = '';
//              $scope.vesselData.remarks = '';
//              document.getElementById('reason').value = '';
//              window.scrollTo(0,0);
//          }
//      }
//    });
        
});


app.controller('algorithmModalCtrl', function($scope, $http, ngDialog, logger, $location) {

    $scope.closeHelpDialog = function() {
        ngDialog.close();
    };
});

app.controller('invoiceViewController', function($scope, $timeout, $stateParams, $filter, $rootScope, $http, $location, logger, utilsService, $state,
		sharedProperties, $window, ngDialog, $interval, validationService, toaster, $controller, $injector) {
alert(4524);
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
//	$scope.invoiceData.billDate = today;
	
//    $http.get($stateParams.tenantid+'/app/invoice/pendingBlList').success(function(response) {
//        $scope.pendingBlList = response.list;
//    });
    
	var invoiceNo = $location.search().invoiceNo;
	
	if(invoiceNo!=null && invoiceNo!=undefined && invoiceNo!=''){
		  $http.post($stateParams.tenantid+ '/app/invoice/viewDetails',invoiceNo).success(function(data) {
    		  if(data.success==true){
    			  	$scope.invoiceData = data.invoiceBean;
					$scope.invoiceData.chargesDetails =  data.invoiceBean.detailList;
//					$scope.invoiceData.billDate = today;
    		  }else{
    			  logger.logError(data.message);
    		  }
    	  });
	}
    
    $scope.cancel = function() {
    	$state.go('app.documentation.invoice');
    };
    
    $scope.printInvoice = function() {
        var url = $stateParams.tenantid+'/app/invoice/print?invoiceno=' + invoiceNo;
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


    
