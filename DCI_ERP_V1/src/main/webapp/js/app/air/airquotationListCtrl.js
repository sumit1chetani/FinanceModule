'use strict';
app.controller('airquotationListCtrl', function($scope, $timeout, $stateParams,sharedProperties,toaster,
		$filter, $rootScope, $http, $location, logger, $state, ngDialog,$controller,$injector,$window) {
	$scope.itemsByPage = 10;
	
	$scope.getBookingList = function() {
		$http.post($stateParams.tenantid+'/app/airquotation/list').success(function(data) {
			debugger
			$scope.rowCollection = data.lQuotationBean;
		});
	};
	$scope.getBookingList();
	$scope.deleteBooking = function(bookingId) {
		 ngDialog.openConfirm().then(function() {
			 $http.post($stateParams.tenantid+'/app/booking/delete', bookingId).success(function(data) {
					if(data.success = true){
						logger.logSuccess('Booking Deleted Successfully.')
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
	$scope.add = function() {
        $state.go('app.air.quotation.add',{tenantid:$stateParams.tenantid});
    };
    
	$scope.editQuot = function(QuotHdId) {
		debugger
			$location.url($stateParams.tenantid+'/airQuotation/edit?QuotHdId='+QuotHdId);
		
	}
	
	$scope.viewQuot = function(QuotHdId) {
		debugger
			$location.url($stateParams.tenantid+'/airQuotation/view?QuotHdId='+QuotHdId);
		
	}
	
	
	$scope.printQuot = function(quotationHdId){
        debugger
        console.log("Both print invoice")
        var url = $stateParams.tenantid+'/app/airquotation/print?quotationHdId=' + quotationHdId;
        var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
        wnd.print();   
     }
	
	$scope.sendmail = function(quotationHdId){
		$http.get($stateParams.tenantid + '/app/airquotation/sendMail?quotationHdId='+quotationHdId)
		.success(function(datas) {
			logger.logSuccess('Mail Sent Successfully!')
		}).error(function(data) {

		});
	}
	
	$scope.deleteQuotation = function(QuotHdId) {
		 ngDialog.openConfirm().then(function() {
			 $http.post($stateParams.tenantid+'/app/airquotation/delete', QuotHdId).success(function(data) {
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
	
	$scope.viewAllocatedTrips = function(bookingId){
		$scope.tempId=bookingId;
		$http.get($stateParams.tenantid+'/app/booking/getBookingListBybookingId?bookingId='+parseInt($scope.tempId)).success(function(returnData) {
			if(returnData.bookingList.length > 0){
				ngDialog.open({
		            template : 'TripSummaryAlert',
		            scope : $scope,
		            controller : $controller('TripSummaryCtrl', {
		                $scope : $scope,
		                data : $scope.tripList,
		                $http : $http,
		                ngDialog : ngDialog,
		                logger : logger,
		                $injector : $injector,
		                sharedProperties : sharedProperties,
		                toaster : toaster,
		                $rootScope : $rootScope
		            }),
		            closeByEscape : false,
		})	
			
			}
			else{
			    logger.logError("No Truck Alloted For Booking!");
			}
		})


		
	}
	
	  $scope.viewBooking = function(bookingId){
			$location.url($stateParams.tenantid+'/booking/view?bookingId='+bookingId);
	  }
	  
	  
	  $scope.mailview = function(quotationHdId) {
			 //alert(quotationHdId);
	         if(quotationHdId =="" || quotationHdId ==undefined){
	            // logger.logError("");
	         }else{         
	             ngDialog.open({
	                 scope : $scope,
	                 template : 'views/air/quotation/airQuotationmailView',
	                 controller : $controller('airquotationmailViewCtrl', {
	                     $scope : $scope,
	                     quotationid: quotationHdId,
	                    // screenName: 'SeaQuotationmailView'
	                 }),
	                 className : 'ngdialog-theme-plain',
	                 showClose : false,
	                 closeByDocument : false,
	                 closeByEscape : false,
	                 preCloseCallback : $scope.getList
	             });
	         }
	     };
	  
	     
	     
	     app.controller('airquotationmailViewCtrl',
					function($scope, $timeout, $stateParams, sharedProperties,
							toaster, $filter, $rootScope, $http, $location, logger,
							$state, ngDialog, $controller, $injector,quotationid) {
		  
		  //alert("dialog"+quotationid);
		 
		  var tenantId = $stateParams.tenantid;
		  
		  var quotationid = quotationid;
		  
		  $scope.viewmaildata = function(){
				$http.get($stateParams.tenantid + '/app/airquotation/viewairQuotationmail?quotationHdId='+quotationid)
				.success(function(datas) {
					console.log(datas);
					$scope.hdr=datas.airQuotationBean;
					$scope.detailList=datas.airQuotationBean.quotationDtl;
					//logger.logSuccess('Mail Sent Successfully!')
				}).error(function(data) {

				});
			}
		  $scope.viewmaildata();
		  
		 
		  $scope.closedialog = function(){
			  ngDialog.close();
			  
		  }
		  var usermailId='';
		  
		  $scope.sendmail = function(quotationHdId){
			  $scope.getuserdetail();
				$http.get($stateParams.tenantid + '/app/airquotation/sendMail?quotationHdId='+quotationid)
				.success(function(datas) {
					//console.log(datas);
					logger.logSuccess('Mail Sent Successfully to '+' '+usermailId)

				}).error(function(data) {

				});
			}
		  
		  $scope.getuserdetail = function(){
			  
			  $http.get($stateParams.tenantid + '/app/commonUtility/getUserdetail')
				.success(function(datas) {
					console.log(datas);
					usermailId =datas.airQuotationBean.employeeEmail
					//logger.logSuccess('Mail Sent Successfully!')
				}).error(function(data) {

				});
		  }
					});
	     
	     
	
});