'use strict';
app.controller('bulkRateReqAirquotationListCtrl', function($scope, $timeout, $stateParams,sharedProperties,toaster,
		$filter, $rootScope, $http, $location, logger, $state, ngDialog,$controller,$injector,$window) {
	$scope.itemsByPage = 10;
	$scope.getBookingList = function() {
		$http.post($stateParams.tenantid+'/app/bulkRateReqAirquotation/list').success(function(data) {
			debugger
			$scope.rowCollection = data.lQuotationBean;
		});
	};
	$scope.getBookingList();

	$scope.add = function() {
        $state.go('app.air.bulkRateReq.add',{tenantid:$stateParams.tenantid});
    };
    
	$scope.editQuot = function(QuotHdId) {
		debugger
			$location.url($stateParams.tenantid+'/bulkRateReqAirQuotation/edit?QuotHdId='+QuotHdId);
		
	}
	
//	$scope.= function(){
//		alert("Hai");
//	}
//	
	  $scope.bulkMail=function(){
	       var obj = $filter('filter')($scope.rowCollection, {
	            select :  true
	        },true);
	       
	       if(obj==undefined || obj==null || obj.length==0 ){
	           logger.logError("Please select atleast one Rate Req to send mail")
	       }else{
	           var isOpenModal = true;
	        $scope.sendmaildata=obj;
	           if (isOpenModal) {
	               ngDialog.close();
	               ngDialog.open({
	                   template : 'custratereqbulkMail',
	                   scope : $scope
	               });
	           }
	            
	       }
	       
	    }
	
	$scope.viewQuot = function(QuotHdId) {
		debugger
			$location.url($stateParams.tenantid+'/bulkRateReqAirQuotation/view?QuotHdId='+QuotHdId);
		
	}
	
	
	$scope.printQuot = function(quotationHdId){
        debugger
        var url = $stateParams.tenantid+'/app/bulkRateReqAirquotation/print?quotationHdId=' + quotationHdId;
        var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
        wnd.print();   
     }
	
	$scope.deleteQuotation = function(QuotHdId) {
		 ngDialog.openConfirm().then(function() {
			 $http.post($stateParams.tenantid+'/app/bulkRateReqAirquotation/delete', QuotHdId).success(function(data) {
					if(data.success = true){
						logger.logSuccess('Quotation Deleted Successfully.')
						$scope.getBookingList();
					}else{
						if(data.message != null && data.message != ''){
							logger.logError(data.message)
						}else{
							logger.logError("Can't delete. Please try again.");
						}
					}
				});
		 });
	};
	
	
	 $rootScope.bulkMail = function(emailid) {
	        var msg="";
	        if($scope.checkundefined(emailid)){
	            msg=msg+"<li>EMAIL :Field is required.</li>";
	        }else{           
	            var emarr=emailid.split(",");
	            var re = /^[_a-z0-9]+(\.[_a-z0-9]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,4})$/;
	            angular.forEach(emarr, function(e, index) {    
	                if (e.trim()  == '' || $scope.checkundefined(e.trim().match(re)) || e.trim().match(re).length==0)
	                {
	                    msg=msg+"<li>"+e+ " - Email format wrong.Please enter a valid email address..</li>";
	                    
	                }
	            });          
	         
	        }
	        
	        if(!$scope.checkundefined(msg)){
	          logger.logError(msg);
	        }else{
	            $scope.input={
	                    lQuotationBean: $scope.sendmaildata,
	                    emailids:emailid
	            }
	            $http.post($stateParams.tenantid+'/app/bulkRateReqAirquotation/sendBulkMail', $scope.input).success(function(datas) {
	               
	                if(datas.success==true){
	                    logger.logSuccess("Mail Sent Successfully");
	                }else{
	                    logger.logError(datas.message);
	                }
	                ngDialog.close();
	            }).error(function(data) {
	                logger.logError("Error Please Try Again");
	            });
	          
	        }
	    }
	
	
});