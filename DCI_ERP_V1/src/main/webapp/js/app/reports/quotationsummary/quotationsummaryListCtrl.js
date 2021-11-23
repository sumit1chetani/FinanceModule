/**
 * 
 */'use strict';
app.controller('quotationSummaryctrl', function($templateCache,$timeout, $scope, $rootScope, $http, logger, $log, ngDialog, $modal, $location, $sce, $filter,utilsService,$stateParams) {
    $scope.quotationSummary = {
    		bookingId:'',
    		bookingNo:'',
    		contType:'',
    		pol:'',
    		pod:'',
    	    statusDate: '',
    	    customerType:'',
    		customer:'',
    	    QuotationNo:'',
            freightelement:'',
            amount:'',
    		validFrom:'',
    		validTill:'',
    		orgin:'',
    		vessel:'',
    		voyage:'',
    		bookingId:'',
    		agreParty:'',
    		bookingDate:'',
    		currencyCode:'',
    		approvedDate:'',
    		fromDate:'',
    		toDate:''
    			
  
       
    };

    $scope.formreset = function() {
        $scope.quotationSummary = {};
    };

    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.vesselList = [];
    $scope.voyageList = [];
    $scope.customerList = [];
    $scope.searchList =[];
    $scope.customerformList =[];
    
    $scope.freight = [];

    $scope.searchInvoiceDtl =[];
    $scope.getDropdownvalue = function() {
        
        $http.get($stateParams.tenantid+'/app/quotationsummary/customerlist').success(function(datas) {
            $scope.customerList = datas;
        }).error(function(datas) {
        });

    }
    $scope.getDropdownvalue();
  
    $scope.freight = [
	     {id: '1', text: 'Collect'},
	    {id: '2', text: 'Prepaid'},
	    {id: '3', text: 'Third Party Collect'}
	  ];
    
    
    //SERACH
    

    $scope.searchInvoiceDtl = function(){
    	
   	 $http.post($stateParams.tenantid+'/app/quotationsummary/searchquotationDtl', $scope.quotationSummary).success(function(response) {
      	console.log(response.searchList.length);

            if(response.searchList.length==0){
                logger.logError("No Records Found")
                $scope.rowCollection=[];
            
            }
            else
                {
                $scope.rowCollection=response.searchList;
                
                }
        }); 
    
    }
    
    //to date   
    $scope.$watch('quotationSummary.toDate',function(newvalue, oldvalue) {
		debugger;
				if ($scope.quotationSummary.toDate != null
						&& $scope.quotationSummary.toDate != '' 
						&& $scope.quotationSummary.fromDate != null
						&& $scope.quotationSummary.fromDate != "") {
					var requestDtAry = $scope.quotationSummary.toDate.split('/');
					var oldDateAry = $scope.quotationSummary.fromDate.split('/');
					var requestDtObj = new Date(
							requestDtAry[2],
							requestDtAry[1] - 1,
							requestDtAry[0]);
					var oldDateObj = new Date(
							oldDateAry[2],
							oldDateAry[1] - 1,
							oldDateAry[0]);
					
					if (requestDtObj < oldDateObj) {
						$scope.quotationSummary.toDate ="";
						logger.logError("To Date should be greater than From Date - "+$scope.quotationSummary.fromDate+" ..!!");
					}
	
				}
	});
    
    //from date
    $scope.$watch('quotationSummary.fromDate',function(newvalue, oldvalue) {
		debugger;
				if ($scope.quotationSummary.toDate != null
						&& $scope.quotationSummary.toDate != '' 
						&& $scope.quotationSummary.fromDate != null
						&& $scope.quotationSummary.fromDate != "") {
					var requestDtAry = $scope.quotationSummary.toDate.split('/');
					var oldDateAry = $scope.quotationSummary.fromDate.split('/');
					var requestDtObj = new Date(
							requestDtAry[2],
							requestDtAry[1] - 1,
							requestDtAry[0]);
					var oldDateObj = new Date(
							oldDateAry[2],
							oldDateAry[1] - 1,
							oldDateAry[0]);
					
					if (requestDtObj < oldDateObj) {
						$scope.quotationSummary.fromDate ="";
						logger.logError("From Date should be less than To Date - "+$scope.quotationSummary.toDate+" ..!!");
					}
	
				}
	});
    
    
    //Excel Export	
  	 $scope.exportExcel = function(){
  		 
  	   	 $http.post($stateParams.tenantid+'/app/quotationsummary/ExportExcel', $scope.quotationSummary).success(function(response) {

  	                if(response){
  	                    debugger;
  	                    $("#customerExport").bind('click', function() {
  	                    });
  	                    $('#customerExport').simulateClick('click');
  	                    logger.logSuccess("Exported successfully!");
  	                }else{
  	                    logger.logError("Failed to export");
  	                }
  	                
  	            }).error(function(response) {
  	                logger.logError("Error Please Try Again");
  	            });
    	    
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
  	    }


  	   
  	$scope.quotationPrint = function() {
        var url = $stateParams.tenantid+'/app/quotation/print?quotationno=' + quotationNo;
        var wnd = window.open(url, 'Shipping', 'height=400,width=750,top=100,left=100,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
        wnd.print();
   
};
    
});

