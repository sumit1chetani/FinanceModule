'use strict';
app.controller('bookingListCtrl', function($scope, $timeout, $stateParams,sharedProperties,toaster,
		$filter, $rootScope, $http, $location, logger, $state, ngDialog,$controller,$injector) {
	$scope.itemsByPage = 10;
	
	
	
	$scope.polList = [];
	$scope.podList = [];
	$scope.vesselList = [];
	$scope.voyageList = [];
	$scope.booking = {
    		
            customer : '',
            voyage  : '',
            vessel  : '',
            pol : '',
            pod:'',
            bookingNo:'',
            status : '',
            blStatus : '',
            invoiceStatus : '',
            checked:'',
            cancelValue:'',
            
            	fromDate:''	,
            	toDate:''
        };
	//$scope.checked1= false;
	//$scope.check = function(value){
		
		
	//}
	
	
			$scope.checked1 =false;
		
			
		
	
	//vessel list
			$http.get($stateParams.tenantid+ '/app/commonUtility/getVesselList').success(function(data) {
				$scope.vesselList = data;
//				$scope.voyageList = data.voyageList;
//				$scope.polList = data.polList;
//				$scope.podList = data.polList;
			});
			
			 $scope.$watch('booking.vessel', function(newValue, oldValue) {
			      if(newValue!=null && newValue!=undefined && newValue != ''){
			    	  $http.post($stateParams.tenantid+ '/app/commonUtility/getVoyageListByVessel',newValue).success(function(data) {
							$scope.voyageList = data;
			    	  });
			      }
			      if(newValue!=null && newValue!=undefined && newValue != '' && $scope.bookViaQt==true){
			    	  $http.post($stateParams.tenantid+ '/app/booking/getVoyListByVsl?pol='+$scope.booking.pol+'&pod='+$scope.booking.pod+'&ves='+newValue).success(function(data) {
							$scope.voyageList = data.voyList;
				    	  })
			      }
			    });
			 
			 if($scope.bookViaQt==true){
					$scope.booking.pol = angular.copy(dat.quoteBean.pol);
					$scope.booking.pod = angular.copy(dat.quoteBean.pod);
					$scope.booking.destination = angular.copy(dat.quoteBean.pod);
//					$scope.booking.customer = angular.copy(dat.quoteBean.customer);
//					$scope.booking.customerName = angular.copy(dat.quoteBean.customer1);
					
					$http.post($stateParams.tenantid+ '/app/booking/getVesselList?pol='+$scope.booking.pol+'&pod='+$scope.booking.pod).success(function(data) {
						$scope.vesselList = data.vesselList;
//						$scope.voyageList = data.voyList;
			    	  })
				}
	
/*	$scope.getBookingListsearch = function(booking) {
 			 $http.post($stateParams.tenantid+'/app/booking/search', bookingId).success(function(data) {
					if(data.success = true){
						$scope.rowCollection = data.list;
						logger.logSuccess('Booking  Successfully.')
						$scope.getBookingList();
					}else{
						if(data.message != null && data.message != ''){
							logger.logError(data.message)
						}else{
							logger.logError(" Please try again.");
						}
					}
				});
		 
	};
	*/
			$scope.getBookingList = function() {
				if($scope.booking.checked==true){
					$scope.checked1=true;
					$http.post($stateParams.tenantid+'/app/booking/list1',$scope.booking ).success(function(data) {
						$scope.rowCollection = data.list;
					});
				}else{
					$http.post($stateParams.tenantid+'/app/booking/list',$scope.booking ).success(function(data) {
						$scope.rowCollection = data.list;
					});
					$scope.checked1=false;
				}
				
				
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
	
	$scope.cancelBooking = function(bookingId) {
		 $rootScope.bookingNo = bookingId;
		$http.post($stateParams.tenantid+'/app/booking/checkCroCreatedForBooking', bookingId).success(function(data) {
			if(data.success == true){
				
				 ngDialog.open({
				        scope : $scope,
				        template : 'deliveryOrderpop',
				        controller : $controller('bookingcancelpopctrl', {
				            $scope : $scope
				        }),
				        className : 'ngdialog-theme-plain',
				        showClose : true,
				        closeByDocument : false,
				        closeByEscape : false

				    });
			}else{
				if(data.message != null && data.message != ''){
					logger.logError(data.message)
				}else{
					logger.logError("CRO Exist. Booking Cannot be cancelled..!!");
				}
			}
	})
	};
	
	
	$scope.add = function() {
        $state.go('app.trade.booking.add',{tenantid:$stateParams.tenantid});
    };
    
	$scope.editBooking = function(bookingNo,croStatus,cancelValue ) {
		if(cancelValue == true){
			 logger.logError("NOTE: BOOKING CANCELED CAN’T EDIT..!!");
		}else{
		$location.url($stateParams.tenantid+'/booking/add?bookingNo='+bookingNo+'&croStatus='+croStatus);
		}
	}
	
	$scope.viewBooking = function(bookingNo,croStatus ) {
		$location.url($stateParams.tenantid+'/booking/view?bookingNo='+bookingNo+'&croStatus='+croStatus);
	}
	
	$scope.createCRO = function(bookingNo ) {
		$location.url($stateParams.tenantid+'/master/inventory/containerReleaseOrder/edit?bookingCode=' + bookingNo);
	}
	
	  $http.get($stateParams.tenantid+ '/app/commonUtility/getCustomerList').success(function(data) {
			$scope.customerList = data;
		});
	  $http.get($stateParams.tenantid+ '/app/commonUtility/getPort').success(function(data) {
			$scope.polList = data.commonUtilityBean;
		});
	  $http.get($stateParams.tenantid+ '/app/commonUtility/getPort').success(function(data) {
			$scope.podList = data.commonUtilityBean;
		});
	  
	    $scope.reset = function(booking) {
	    
	    	$scope.booking = {
	    			customer : '',
	   	            pol : '',
	   	            pod:'',
	   	            voyage : '',
	   	            vessel : '',
	   	            bookingNo:'',
	   	            status : '',
	   	         fromDate:''	,
	            	toDate:''
	            };
	    	$scope.checked1 =false;
	    	$scope.getBookingList(); 
	    }
	    
	    $scope.statusList = [{
	    	id : 'Pending',
	    	text : 'Pending'
	    },
	    {
	    	id : 'Completed',
	    	text : 'Completed'
	    }]
	    
	    
	    
	    //Excel Export	
		 $scope.exportExcel = function(){

		            $http.post($stateParams.tenantid+'/app/booking/ExportExcel', $scope.booking).success(function(response) {
		                if(response){
		                    debugger;
		                    $("#Export").bind('click', function() {
		                    });
		                    $('#Export').simulateClick('click');
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
		  
		    //Excel Export	
			 $scope.exportExcel1 = function(){

			            $http.post($stateParams.tenantid+'/app/booking/ExportExcel1', $scope.booking).success(function(response) {
			                if(response){
			                    debugger;
			                    $("#newExport").bind('click', function() {
			                    });
			                    $('#newExport').simulateClick('click');
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
	
			  
				// Popup for Allocated Containers
			     $scope.viewContainers = function(value){
				     	   $rootScope.booking = value;
				     	   ngDialog.open({
				        		scope: $scope,
				        		template: '/views/trade/booking/AllocatedContainersForBooking.',
				        		controller: $controller('ContainersAllocatedCtrl', {
				        		$scope: $scope,
				        		$http:$http,
				        		ngDialog:ngDialog,
				        		logger:logger,
				        		$injector:$injector,
				        		sharedProperties:sharedProperties,
				        		toaster:toaster,
				        		$rootScope:$rootScope
				        		}),
				        		className: 'ngdialog-theme-plain',
				        		showClose: false,
				        		closeByDocument: false,
				        		closeByEscape: false,
				        		preCloseCallback : $scope.getList
				        		});
				        };
				        
				        $scope.noCnfrm = function() {
				    		ngDialog.close();
				    	}
				        
});

app.controller('bookingcancelpopctrl', function($scope, $timeout, $stateParams,sharedProperties,toaster,
		$filter, $rootScope, $http, $location, logger, $state, ngDialog,$controller,$injector,validationService) {
	

	$scope.booking = {
			bookingcancelreason:''
	}

	 $scope.booking.bookingNo = $rootScope.bookingNo;
	  
	function isEmpty(val){
	    return (val === undefined || val == null || val.length <= 0) ? true : false;
	}
	 
	 $scope.saveData = function(blForm1) {
		 if($scope.booking.bookingcancelreason){
			 	$http.post($stateParams.tenantid+'/app/booking/cancelBooking' ,$scope.booking).success(function(result) {
			 		if (result.success == true) {
			 			  ngDialog.close();
	            logger.logSuccess("Booking Cancelled Successfully!");
	            $window.location.reload();
	           $state.go('app.trade.booking.list',{tenantid:$stateParams.tenantid});
	          

	        } else {
	        	logger.logError(result.message);
	        }
	    }).error(function(result) {
	        console.log("data" + result);
		 
 });
		 }else{
			 logger.logError("Please enter cancel remarks..!!");
		 }
	 }
	 $scope.closeUpload = function(){
	        ngDialog.close();
	        $state.reload();
	  }
	 
		
	
	
});


app.controller('ContainersAllocatedCtrl', function($scope, $state, $http, $location, sharedProperties,toaster,
		$injector,logger,ngDialog,$rootScope,$controller,$stateParams) {
	
	 
	$scope.gateoutList =[];
	 $scope.shipmentContainerList =[];
			
			var obj;
			obj = $rootScope.booking;
			   $http.post($stateParams.tenantid+'/app/booking/AllocatedContainerList',obj).success(function(datas) {
				   debugger
			          console.log(datas);
				          $scope.gateoutList = datas.gateoutContainersList;
				          $scope.shipmentContainerList = datas.shipmentAssignedList;
				       //   $scope.unAllocateList = datas.unAssignedList;

			          }).error(function(datas) {
			      });
			   

			   $scope.noCnfrm = function() {
		    		ngDialog.close();
		    	}
		        

		});
