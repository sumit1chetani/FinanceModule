'use strict';
app.controller('salebookingListCtrl', function($scope, $timeout, $stateParams,sharedProperties,toaster,
		$filter, $rootScope, $http, $location, logger, $state, ngDialog,$controller,$injector,$window) {
	$scope.itemsByPage = 10;
	
	$scope.modeList=[];
	$scope.getQuotationType = function() {
		var data = {};
		data["id"] = "1";
		data["text"] = "SEA COASTAL";
	    $scope.modeList.push(data);
	     //$scope.bookingData.mode='1';
	    data = {};
	    data["id"] = "2";
	    data["text"] = "SEA FOREIGN";
	    $scope.modeList.push(data);
	    data = {};
	    data["id"] = "3";
	    data["text"] = "TRUCK";
	     $scope.modeList.push(data);
	     data = {};
		    data["id"] = "4";
		    data["text"] = "LINER";
			 $scope.modeList.push(data);
			 data = {};
    	    data["id"] = "5";
    	    data["text"] = "FORWARDING";
    	    $scope.modeList.push(data);
		// data = {};
		// data["id"] = "2";
		// data["text"] = "SEA";
		// $scope.modeList.push(data);
	}
	$scope.getQuotationType();
	  $http.get($stateParams.tenantid+'/app/commonUtility/getcarrierList').success(function(datas) {
			debugger
		    $scope.carrierList = datas.commonUtilityBean;	    
          //$scope.transList = datas.lCommonUtilityBean;	    

		}).error(function(data) {

		});
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
            bookingNo:'',modeName:'',
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
			    	  $http.post($stateParams.tenantid+ '/app/salesBooking/getVoyListByVsl?pol='+$scope.booking.pol+'&pod='+$scope.booking.pod+'&ves='+newValue).success(function(data) {
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
					
					$http.post($stateParams.tenantid+ '/app/salesBooking/getVesselList?pol='+$scope.booking.pol+'&pod='+$scope.booking.pod).success(function(data) {
						$scope.vesselList = data.vesselList;
//						$scope.voyageList = data.voyList;
			    	  })
				}
	
/*	$scope.getBookingListsearch = function(booking) {
 			 $http.post($stateParams.tenantid+'/app/salesBooking/search', bookingId).success(function(data) {
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
/*			$scope.getBookingList = function() {
				if($scope.booking.checked==true){
					$scope.checked1=true;
					$http.post($stateParams.tenantid+'/app/salesBooking/list1',$scope.booking ).success(function(data) {
						$scope.rowCollection = data.list;
					});
				}else{
					$http.post($stateParams.tenantid+'/app/salesBooking/list',$scope.booking ).success(function(data) {
						$scope.rowCollection = data.list;
					});
					$scope.checked1=false;
				}
				
				
			};

	$scope.getBookingList();
*/	
			 

			  /*  $scope.viewGeneralLedgerReportNew = function(booking) {
			    	$http.post($stateParams.tenantid+'/app/salesBooking/filterList',booking).success(function(data) {

			    	//$http.get($stateParams.tenantid+'/app/seaquotation/filterList?mode='+quotation.mode+'&polCode='+quotation.polCode+'&podCode='+quotation.podCode+'&status='+quotation.status+'&fromDate='+quotation.fromDate+'&toDate='+quotation.toDate).success(function(data) {
					debugger
					$scope.rowCollection = data.lQuotationBean;
				});};*/
			 
			 $scope.getBookingList = function() {
					if($scope.booking.checked==true){
						$scope.checked1=true;
						$http.post($stateParams.tenantid+'/app/salesBooking/list1',$scope.booking ).success(function(data) {
							
							for(var i =0;i<data.list.length;i++){
					        	 if(data.list[i].bookingDate != null){
					             var dateSplitted = data.list[i].bookingDate.split(" ");
					             var dateSplitted1 = dateSplitted[0].split("/").reverse().join("/");
					             var  ms = Date.parse(dateSplitted1);
					             console.log(dateSplitted +" : " +ms)
					             data.list[i].bookingDate1=ms;
//					             data.thirdPartyVoyageList[i].schStartDate = new Date(dateSplitted1);
					        	 }
					         }
							
							$scope.rowCollection = data.list;
						});
					}else{
						$http.post($stateParams.tenantid+'/app/salesBooking/list',$scope.booking ).success(function(data) {
							angular.forEach(data.list, function(row, index) { 
row.modeName=row.mode;
								if(row.mode != null && row.mode != ''){
									 
								    if(row.mode==1){
										row.mode = "SEA COASTAL";
							    }else  if(row.mode==2){
										row.mode = "SEA FOREIGN";
							    }else  if(row.mode==3){
										row.mode = "TRUCK";
							    }else  if(row.mode==4){
										row.mode = "LINER";
							    }else  if(row.mode==5){
										row.mode = "FORWARDING";
								}
								
							}
								})
							
							for(var i =0;i<data.list.length;i++){
					        	 if(data.list[i].bookingDate != null){
					             var dateSplitted = data.list[i].bookingDate.split(" ");
					             var dateSplitted1 = dateSplitted[0].split("/").reverse().join("/");
					             var  ms = Date.parse(dateSplitted1);
					             console.log(dateSplitted +" : " +ms)
					             data.list[i].bookingDate1=ms;
//					             data.thirdPartyVoyageList[i].schStartDate = new Date(dateSplitted1);
					        	 }
					         }
							$scope.rowCollection = data.list;
						});
						$scope.checked1=false;
					}
					
					
				};

		$scope.getBookingList();
		

			 

	$scope.deleteBooking = function(bookingId) {
		 ngDialog.openConfirm().then(function() {
			 $http.post($stateParams.tenantid+'/app/salesBooking/delete', bookingId).success(function(data) {
					if(data.delsuccess == true){
						ngDialog.close();    

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
	$scope.deleteB = function(bookingNo) {	
		 $scope.quotationNew = {

					fromDate:'',
					toDate:'',
					status:'',deletedRemarks:'',bookingNo:'',
					polCode:'',podCode:''

			 
	        };
		    $scope.quotationNew.bookingNo =  bookingNo;
		   

            $scope.quotationNew.deleteRemarks =  '';
        ngDialog.open({
            scope : $scope,
            template : 'views/air/seaQuotation/bookkingDeleteRemarks',
            controller : $controller('bookingDeleteCtrl', {
                $stateParams :$stateParams,
                $scope : $scope, 
                $http:$http, 
                $location:$location,
                logger:logger, 
                $state:$state, 
                $window:$window,
                preCloseCallback : $scope.getList
            }),
            showClose : false,
            closeByDocument : false,
            closeByEscape : false 
        });
		
	};
	$scope.cancelBooking = function(bookingId) {
		 $rootScope.bookingNo = bookingId;
		$http.post($stateParams.tenantid+'/app/salesBooking/checkCroCreatedForBooking', bookingId).success(function(data) {
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
        $state.go('app.salesmarketing.salebooking.add',{tenantid:$stateParams.tenantid});
    };
    
	$scope.editBooking = function(bookingNo) {
		
		$location.url($stateParams.tenantid+'/salesbooking/edit?bookingNo='+bookingNo);
	
	}
$scope.editBooking1 = function(bookingNo1) {
	$rootScope.bookingNo1 = bookingNo1;
    $state.go('app.salesmarketing.salebooking.Add',{bookingNo1: $stateParams.bookingNo1});
	
	}
	
	/*$scope.viewBooking = function(bookingNo) {
		$location.url($stateParams.tenantid+'/salesbooking/view?bookingNo='+bookingNo);
	}*/
$scope.viewBooking = function(rowid) {
	
	$rootScope.joborderlistctrl1=$('.rounded').val();
	$location.url($stateParams.tenantid+'/salesbooking/view?bookingNo='+rowid);
	
}
	
	$scope.createCRO = function(bookingNo ) {
		$location.url($stateParams.tenantid+'/master/inventory/containerReleaseOrder/edit?bookingCode=' + bookingNo);
	}
	
	$http.post($stateParams.tenantid+'/app/seaquotation/getServicePartnerList').success(function(datas) {
		 $scope.customerDropList = datas.customerList;

		});
	  
		$http.get($stateParams.tenantid+'/app/seaquotation/getiataList').success(function(datas) {
			debugger
		    $scope.portList1 = datas.commonUtilityBean;	    
		});
	  
	    $scope.reset = function(booking) {
	    
	    	$scope.booking = {
	    			customer : '',carrier:'',
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
		 $scope.exportExcelnew = function(){
			 
			/*if($scope.bookingReport.salesPersonId!='' && $scope.bookingReport.salesPersonId!=null){*/
		   	 $http.post($stateParams.tenantid+'/app/salesBooking/ExportExcelnew', $scope.booking).success(function(response) {

		                if(response){
		                    debugger;
		                    $("#booking").bind('click', function() {
		                    });
		                    $('#booking').simulateClick('click');
		                    logger.logSuccess("Exported successfully!");
		                }else{
		                    logger.logError("Failed to export");
		                }
		                
		            }).error(function(response) {
		                logger.logError("Error Please Try Again");
		            });
			/*}else{
			  logger.logError("Pls select Sales Person");
		  }*/
		    
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
		 $scope.exportExcel = function(){

		            $http.post($stateParams.tenantid+'/app/salesBooking/ExportExcel', $scope.booking).success(function(response) {
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

			            $http.post($stateParams.tenantid+'/app/salesBooking/ExportExcel1', $scope.booking).success(function(response) {
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
				        		template: '/views/salesmarketing/booking/AllocatedContainersForBooking',
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
			 	$http.post($stateParams.tenantid+'/app/salesBooking/cancelBooking' ,$scope.booking).success(function(result) {
			 		if (result.success == true) {
			 			  ngDialog.close();
	            logger.logSuccess("Booking Cancelled Successfully!");
	            $window.location.reload();
	           $state.go('app.salesmarketing.salebooking.list',{tenantid:$stateParams.tenantid});
	          

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
			   $http.post($stateParams.tenantid+'/app/salesBooking/AllocatedContainerList',obj).success(function(datas) {
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
app.controller('bookingDeleteCtrl', function($stateParams , $scope , $http, $location,logger, $state, $window,ngDialog) {
    debugger;
    
    
    $scope.quotationNew.quotationNo= $scope.quotationNew.quotationNo;  
    $scope.quotationNew.approveRemarks= '';

    $scope.cancel = function() {
        ngDialog.close();    
    };
    
    
    $scope.downloadNewFile = function(id) {
        debugger;
        $("#" + id).bind('click', function() {
            // alert('clicked');

        });
        $("#" + id).simulateClick('click');
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
    
    
    $scope.deleteQuotation = function(quotationNew){
		 $http.post($stateParams.tenantid+'/app/salesBooking/delete', quotationNew).success(function(data) {
				if(data.delsuccess == true){
					ngDialog.close();    

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
	 }
  
});
