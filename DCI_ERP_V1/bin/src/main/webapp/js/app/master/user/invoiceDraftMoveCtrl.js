'use strict';
app.controller('invoiceDraftMoveCtrl', function($scope,$filter, $timeout, $rootScope, $http, $location, logger, $log, ngDialog, utilsService, $injector, sharedProperties, toaster,$stateParams) {

            $scope.invoiceDraft ={
            	mode : '',
            	invoiceType : '',
            	invoiceNo : ''
            }
            
	
      $scope.modeList = [];
	  $scope.modeType = function() {
		  var data = {};
			data["id"] = "1";
			data["text"] = "SEA";
			$scope.modeList.push(data);
		  
		var data = {};
		data["id"] = "2";
		data["text"] = "AIR";
		$scope.modeList.push(data);
		

	}
	$scope.modeType();
	
	$scope.salesTypeList = [];
	 $scope.salesType = function() {
		  var data = {};
			data["id"] = "1";
			data["text"] = "Sales Invoice";
			$scope.salesTypeList.push(data);
		  
		var data = {};
		data["id"] = "2";
		data["text"] = "Purchase Invoice";
		$scope.salesTypeList.push(data);
		

	}
	$scope.salesType();
	


    $scope.saveInvoice = function() {
//        if (new validationService().checkFormValidity()) 
    	/*{*/
        
        	 var dataUrl =  $stateParams.tenantid+'/app/usermaster/invoicemovetodraft';
             $http.post(dataUrl, $scope.invoiceDraft).success(function(datas) {
                 if (datas.success) {
                     $scope.formList = datas.lFormMasterBean;
                     logger.logSuccess("Successfully Moved");
               } else{
                   logger.logError("Invoice cannot move to draft!!");
               }
            });
            /* }*/
//        }else{
//            toaster.pop('error', "Please fill the required fields", 
//                    logger.getErrorHtmlNew($validationSummary), 5000, 'trustedHtml');
//        }
    };
    
  
    
  ///watch
    $scope.invoiceList=[];
    $scope.$watch('invoiceDraft.invoiceType', function(newValue, oldValue) {
                if (newValue != '' && newValue != undefined) {
                	if($scope.invoiceDraft.mode !='' && $scope.invoiceDraft.mode !=undefined){
                	  $http.get($stateParams.tenantid+'/app/usermaster/getInvoiceList?invoiceType=' + newValue + '&mode=' + $scope.invoiceDraft.mode).success(function(datas) {
                	        $scope.invoiceList = datas;
                	    }).error(function(datas) {
                	    });
                	}else{
                		logger.logError("Pls Select Mode..");
                		$scope.invoiceDraft.invoiceType='';
                	}
                }
           });

    ///
    
    
    
    
});
