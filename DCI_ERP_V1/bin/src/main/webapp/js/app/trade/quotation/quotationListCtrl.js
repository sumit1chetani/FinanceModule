'use strict';

app.controller('requestquotationListCtrl', function($scope, $rootScope, $http, $location, logger, utilsService, ngDialog, $state,sharedProperties,$window,$stateParams) {

		$scope.itemsByPage = 10;
		$scope.numPages = 0;
		$scope.offsetCount = 0;
		$scope.limitCount = 1000;
		$scope.rowCollection = [];
		$scope.displayedCollection = [];
		$scope.itemsByPage = 10;
		$scope.isUpload=true;
		$scope.isDelete=true;
		$scope.userId = '';
		
		
		$scope.quotation = {
			customer : '',
		    //status : 'Approved',
		    status : 'Pending',
		    pol : '',
		    pod : '',
		    custcategory : '',
		    validFrom : '',
		    validTo : '',
		    bookingStatus : '',
		    currentDate:''
		};
		
		$scope.quotation1 = {
			
			    status : 'Pending'
			   
			};
		
		
		$scope.reset = function() {
			
			$scope.quotation = {
					customer : '',
				  //  status : 'Approved',
				    status : 'Pending',
				    pol : '',
				    pod : '',
				    custcategory : '',
				    validFrom : '',
				    validTo : '',
				    bookingStatus : ''
				};
		}
		
		
		$scope.getList
		
		$scope.$watch('quotation.status',function(newValue, oldValue) {
			if(newValue!=null && newValue!=undefined && newValue!=""){
				$scope.getList($scope.quotation);
			}
		});
		$scope.allowOtherPort = true;
		$scope.getList = function(quotation) {
			debugger
			$http.post($stateParams.tenantid+'/app/quotation/listFilter',quotation).success(function(datas) {
				$scope.rowCollection = datas.lQuotationBean;
				$scope.userId = datas.userId;
				$rootScope.vendor=datas.vendor;
				$rootScope.user=$scope.userId;
				/*$scope.rowCollection1=datas.notDraftList;*/
				
				
			}).error(function(datas) {

			});
		};
		
		
		/*$scope.getList1 = function(quotation) {
			debugger
			$http.post($stateParams.tenantid+'/app/quotation/listFilterApproval',quotation).success(function(datas) {
				$scope.rowCollection1 = datas.notDraftList;
				$scope.rowCollection1=datas.notDraftList;
				
			}).error(function(datas) {

			});
		};*/
		
		
		$scope.add = function() {
		    $state.go("app.trade.quotation.add",{tenantid:$stateParams.tenantid});
		};
		
		$scope.edit = function() {
		    $state.go("app.trade.quotation.edit",{tenantid:$stateParams.tenantid});
		};
		
		$scope.addBooking = function(quotationNo) {
			$location.url($stateParams.tenantid+'/booking/add?quotationNoCR='+quotationNo);
		};
		
		$http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(datas) {
			  /*$scope.shipmentList=datas.getshipmentlist;*/
			  $scope.portList=datas.getportlist;
			  $scope.custmerList=datas.getcustomerlist;
			 /* $scope.currencyList=datas.getcurrencylist	;
			  $scope.conTypeList=datas.getcontypelist;*/
			 /*  $scope.chargeTypeList=datas.getchargetypelist*/
			//logger.logSuccess('Mail Sent Successfully!')
		}).error(function(datas) {

		});
		
		 $http.post($stateParams.tenantid+'/app/commonUtility/getCustomerCateory').success(function(data) {
			  	
				$scope.custCatList=data.customercategory;
				        		
		});
		 
		 $scope.editBooking = function(bookingNo ) {
			 ngDialog.close();
				$location.url($stateParams.tenantid+'/booking/add?bookingNo='+bookingNo);
			}
		 
		 $scope.viewAllBookingByQuotation = function(quotNo,status){
			 if(status == 'ALLOTTED'){
				 
			 
			 ngDialog.open({
	                template : 'fileGenModal',
	                scope :$scope
	            });
			 $http.get($stateParams.tenantid+'/app/quotation/getAllBookingByQuotation?quotNo='+quotNo).success(function(datas) {
					$scope.bookingDtls = datas;
					/*$scope.rowCollection1=datas.notDraftList;*/
					
				}).error(function(datas) {

				});
			 }
			 else{
				 logger.logError("Booking Not Allotted for this Quotation!");
			 }
			 
		 }
		 

			
			
			
			 $scope.genCancel=function(){
		            ngDialog.close();
		        }
		 
/*		 var statusList = [ {
	            id : 'Pending',
	            text : 'Pending'
	        }, 
	        {
	            id : 'Draft',
	            text : 'Draft'
	        },
	        {
	            id : 'Approved',
	            text : 'Approved'
	        },
	        {
	            id : 'Rejected',
	            text : 'Rejected'
	        }
	        
	        ]
		*/
			$scope.statusList=[
				 
				/*{
					id : 'Draft',
		            text : 'Draft'
		           
		        }, */
				
				{
		        	 id : 'All',
			         text : 'All'
		            
		        },
		        {
		        	 id : 'Pending',
			         text : 'Pending'
		            
		        },
		        {
		            id : 'Approved',
		            text : 'Approved'
		        },
		        {
		            id : 'Rejected',
		            text : 'Rejected'
		        },{
		            id : 'Expired',
		            text : 'Expired'
		        }
				
			]
	/*	$scope.getRfqList = function() {
			$http.post($stateParams.tenantid+'/app/quotation/list').success(function(datas) {
				$scope.rowCollection = datas.lQuotationBean;
				$scope.rowCollection1=datas.notDraftList;
				
			}).error(function(datas) {

			});
		};
		$scope.getRfqList();*/
		
		//Edit functionality
			$scope.editRow = function(quotationNo,status,count,approvedBy) {
				if(status=='Pending'){
					$location.url($stateParams.tenantid+'/trade/quotation/edit?quotationNo=' + quotationNo);
				} else if (status=='Approved') {
					
						if (count==0) {
							if (approvedBy==$scope.userId) {
							$location.url($stateParams.tenantid+'/trade/quotation/edit?quotationNo=' + quotationNo);
							} else {
								logger.logError("Quotation Can't edited, Please check with approved person.");
							}
						} else {
							logger.logError("Can't edit Quotation, Invoice Generated.");
						}
				} else {
					logger.logError("Can't edit "+status+" Quotation");
				}
			};
			
			var today = new Date();
			var dd = today.getDate();
			var mm = today.getMonth() + 1; // January is 0!
			var yyyy = today.getFullYear();
			if (dd < 10) {
				dd = '0' + dd
			}
			if (mm < 10) {
				mm = '0' + mm
			}

			$scope.quotation.currentDate = dd + '/' + mm + '/'
					+ yyyy;
		
			$scope.extendquotation = function(quotationNo,validTo) {
							$location.url($stateParams.tenantid+'/trade/quotation/editforQuotationDate?quotationNo=' + quotationNo);
				
				};
		
		$scope.editRowApprove = function(quotationNo,status) {
			
		    $location.url($stateParams.tenantid+'/trade/quotationApproval/edit?quotationNo=' + quotationNo);
			
		};
		
		
		//approve Request
		$scope.approveRow = function(quotationNo) {
		    $location.url($stateParams.tenantid+'/trade/quotationApproval/view?quotationNo=' + quotationNo);
		};
		
		//approve Request
		$scope.approveRow1 = function(quotationNo,allowOtherPorts,quotationcreated) {
			if($rootScope.vendor == true ){
				if(quotationcreated !=$rootScope.user){
					if(allowOtherPorts == true){
						logger.logError("Can't view Quotation");

					}else{
					    $location.url($stateParams.tenantid+'/trade/quotation/view?quotationNo=' + quotationNo);

					}
				}
				else{
				    $location.url($stateParams.tenantid+'/trade/quotation/view?quotationNo=' + quotationNo);

				}
			}
			else{
			    $location.url($stateParams.tenantid+'/trade/quotation/view?quotationNo=' + quotationNo);

			}
		};
		
		 
		//Delete functionality
		$scope.deleteRow = function(quotationNo,status) {	
			if(status=='Pending'){
			
			 ngDialog.openConfirm().then(function() {
			
			$http.post($stateParams.tenantid+'/app/quotation/delete',quotationNo).success(function(datas) {
				
				if(datas.success){
					
			
				logger.logError("Deleted Successfully");
				$state.reload();
				
				
				}else{
					logger.logError(datas.message);
				}
				 
			
		
		}).error(function(datas) {

		});
			 }, function(reason) {
		        	
		            console.log('Modal promise rejected. Reason: ', reason);
		        });
            }else{
				
				logger.logError("Can't delete "+status+" Quotation");
				
			}
		
		
		};
		
	    //Excel Export	
		 $scope.exportExcel = function(){

		            $http.post($stateParams.tenantid+'/app/quotation/ExportExcel', $scope.quotation).success(function(response) {
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

			$scope.quotationPrint = function(quotationNo){
		        debugger
		        console.log("Both print invoice")
		        var url = $stateParams.tenantid+'/app/quotation/print?quotationNo=' + quotationNo;
		        var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
		        wnd.print();   
		     }
			
    
});