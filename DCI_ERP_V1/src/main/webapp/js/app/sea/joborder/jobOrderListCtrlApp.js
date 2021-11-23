'use strict';
app.controller('joborderlistctrlApp', function($scope, $timeout, $stateParams,sharedProperties,toaster,
		$filter, $rootScope, $http, $location, logger, $state, ngDialog,$controller,$injector) {
	
//	$scope.defaultCurrency = 0;
//	$scope.fromCurrency=0;
//	$scope.toCurrency=0;
	$('.rounded').val($rootScope.joborderlistctrl1);
$scope.mloList = [];
	$scope.itemsByPage = 10;
    $scope.joborder = {
    		aolName:'',
    		aodName:'',
    		bookingStatus:'',
    		gateoutStatus:'',
    		status1:'',
    		jostatus:'',
    		statusbl:''
			
    	
       
    };
    $http.get($stateParams.tenantid+'/app/commonUtility/getcarrierList').success(function(datas) {
		debugger
	    $scope.carrierList = datas.commonUtilityBean;	    
        //$scope.transList = datas.lCommonUtilityBean;	    

	}).error(function(data) {

	});

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
	    data["id"] = "5";
	    data["text"] = "FORWARDING";
	     $scope.modeList.push(data);
	   /*  data = {};
		    data["id"] = "4";
		    data["text"] = "LINER";
		     $scope.modeList.push(data);*/
		// data = {};
		// data["id"] = "2";
		// data["text"] = "SEA";
		// $scope.modeList.push(data);
	}
	$scope.getQuotationType();
	
   
	/*$scope.showExcelButton=false;
    $http.post($stateParams.tenantid + '/app/dashboard/checkWhichUser').success(function(data) {
		if (data[1].userId=='E0001'|| data[1].userId=='A0001') {
			$scope.showExcelButton=true;
		}

	}).error(function(data) {
		logger.logError("Error Please Try Again");
	});*/
	
    $scope.jobStatusList=[];
	$scope.getStatus = function() {
	    var  data = {};
	    data["id"] = "1";
	    data["text"] = "OPEN";
	    $scope.jobStatusList.push(data);
	    data = {};
	    data["id"] = "2";
	    data["text"] = "CLOSED";
	    $scope.jobStatusList.push(data);  
	    
	}
	$scope.getStatus();
	
	//T/S Status Dropdown
	$scope.tsStatusList=[		 
		  { id: 'ts', text: 'Yes' },
		  { id: 'regular', text: 'No' }		
	]
	
	// Gate out Status DropDown
	$scope.gateOutStatusList=[		 
		  { id: 'pending', text: 'Pending' },
		  { id: 'completed', text: 'Completed' }		
	]
	

	$scope.joStatusList=[		 
		  { id: 'Completed', text: 'Completed' },
		  { id: 'NotCompleted', text: 'Not Completed' }		
	]
	$scope.biStatusList=[		 
		  { id: 'Pending', text: 'Pending' },
		  { id: 'Approved', text: 'Approved' },
		  { id: 'All', text: 'All' }
	]
	
	$scope.bcgStatusList=[		 
		  { id: 'Completed', text: 'Completed' },
		  { id: 'NotCompleted', text: 'Not Completed' }		
	]
	

	
	$scope.dropdown=function(){
					;
					$http.get($stateParams.tenantid+'/app/jobOrderSeaApp/dropDownList').success(function(datas) {
						
					
						$scope.branchList = datas.branchSelectivityList;
					    //$scope.portList = datas.portSelectivityList;
					}).error(function(data) {

					});

					$http.get($stateParams.tenantid+'/app/seaquotation/getiataList').success(function(datas) {
						
					    $scope.portList = datas.commonUtilityBean;	    

					}).error(function(data) {

					});
	}
				
				$scope.dropdown();
	$scope.getBookingList = function() {
		$http.post($stateParams.tenantid+'/app/jobOrderSeaApp/list').success(function(data) {
			$scope.rowCollection = data.lJobOrderBean;
			angular.forEach(data.lJobOrderBean, function(row, index) { 
				if(row.mode != null && row.mode != ''){
					 
				    if(row.mode==1){
						row.modeName = "SEA COASTAL";
			    }else  if(row.mode==2){
						row.modeName = "SEA FOREIGN";
			    }else  if(row.mode==3){
						row.modeName = "TRUCK";
			    }else  if(row.mode==4){
						row.modeName = "LINER";
				}
				else  if(row.mode==5){
						row.modeName = "FORWARDING";
			    }
			}})
		});
	};
	$scope.getBookingList();
	
	
	
	 //Excel Export	
	 $scope.exportExcelnew = function(){
		 
		/*if($scope.bookingReport.salesPersonId!='' && $scope.bookingReport.salesPersonId!=null){*/
	   	 $http.post($stateParams.tenantid+'/app/jobOrderSeaApp/ExportExcel', $scope.joborder).success(function(response) {

	                if(response){
	                    ;
	                    $("#joborder").bind('click', function() {
	                    });
	                    $('#joborder').simulateClick('click');
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
   




    $scope.getSearchList = function(joborder) {   	 
     	  $http.post($stateParams.tenantid+'/app/jobOrderSeaApp/SearchList',$scope.joborder).success(function(data) {
               console.log(data);
               if (data.length > 0) { 
            	   
                   $scope.rowCollection = data;
                   angular.forEach(data, function(row, index) { 
						if(row.mode != null && row.mode != ''){
							 
						    if(row.mode==1){
								row.modeName = "SEA COASTAL";
					    }else  if(row.mode==2){
								row.modeName = "SEA FOREIGN";
					    }else  if(row.mode==3){
								row.modeName = "TRUCK";
					    }else  if(row.mode==4){
								row.modeName = "LINER";
						}
						else  if(row.mode==5){
								row.modeName = "FORWARDING";
					    }
					}})
                  // sharedProperties.setObject($scope.emptyObject);
               }else{
            	   logger.logError("No Details Found"); 
                   $scope.rowCollection = '';

               }
           	
               }).error(function(data) {
            	   logger.logError("Error Please Try Again");
           });
     	 $scope.offsetCount = $scope.offsetCount + $scope.limitCount;
     	  
     }
    $scope.reset = function() { 
    	$scope.joborder = {
    		aolName:'',
    		aodName:'',
    		bookingStatus:'',
    		gateoutStatus:'',
    		status1:'',
    			jostatus:'',
    			Statusbl:''
    			
    			
    };
    	$scope.getBookingList();
   	  
   }
    
	$scope.deleteJob = function(rowid) {
		 ngDialog.openConfirm().then(function() {
			 $http.post($stateParams.tenantid+'/app/jobOrderSeaApp/delete', rowid).success(function(data) {
					if(data.success){
						logger.logSuccess('Job Order Deleted Successfully.')
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
	
	   $scope.print1 = function(rowid) {
		
			var test = parseInt(rowid);
			var url = $stateParams.tenantid
					+ '/app/jobOrderAir/print1?rowid=' + rowid
			var wnd = window
					.open(
							url,
							'HISERP',
							'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
			wnd.print();

		};
	$scope.add = function() {
		$rootScope.joborderlistctrl1=$('.rounded').val();
		;
        $state.go('app.sea.joborderApp.add',{tenantid:$stateParams.tenantid});
    };
   
	/*$scope.editBooking = function(rowid,status) {
		if(status == 'Fully Allocatted'){
		 $http.get($stateParams.tenantid+'/app/booking/checkEditbooking?bookingId='+bookingId).success(function(data) {
             if (data == true) {
		$location.url($stateParams.tenantid+'/booking/edit?bookingId='+bookingId);
	}
          else {
             logger.logError("Not Allowed to Edit ,Trip Started!");
         }
     }).error(function(data) {
         logger.logSuccess("Error in Edit!");
     });
	}
		else{
			$location.url($stateParams.tenantid+'/booking/edit?rowid='+rowid);
		}
	}*/
    $scope.editBooking = function(rowid) {
    	 $rootScope.joborderlistctrl1=$('.rounded').val();

		
		$scope.modeType=1;
	        $http.get($stateParams.tenantid+'/jobOrderMonthClose/getJobDate?mode=' + $scope.modeType +'&jobId='+ rowid).success(function(datas) {
	            if(datas){
	                logger.logError("Job Order Closed Pls Contact IT Support");
                 }else{
                	 $location.url($stateParams.tenantid+'/jobOrderSeaApp/edit?rowid='+rowid); 
                 }
	        })
	
	}
$scope.approveRow = function(rowid) {
		
		$rootScope.joborderlistctrl1=$('.rounded').val();
			$location.url($stateParams.tenantid+'/jobOrderSeaApp/Approval?rowid='+rowid);
		
	}
	$scope.viewJob = function(rowid) {
		
		$rootScope.joborderlistctrl1=$('.rounded').val();
			$location.url($stateParams.tenantid+'/jobOrderSeaApp/view?rowid='+rowid);
		
	}
	
	$scope.viewBooking = function(rowid) {
		
		$rootScope.joborderlistctrl1=$('.rounded').val();
		$location.url($stateParams.tenantid+'/salesbooking/add?bookingNo='+rowid);
		
	}
	
	 $scope.printQuot = function(rowid){
	        
	        console.log("Both print invoice")
	        var url = $stateParams.tenantid+'/app/seaquotation/print?rowid=' + rowid;
	        var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
	        wnd.print();   
	     }
	 
	 
	 var quickLinkIdList = $location.search().quickLinkIdList;
	    $scope.newQukLinkList=[];
	    $scope.qlt=[];
	    if(quickLinkIdList!='' && quickLinkIdList != undefined){
	    	 $scope.qlt=quickLinkIdList.split(',');
	    	 $http.post($stateParams.tenantid+'/app/jobOrderSeaApp/list').success(function(data) {
	 			$scope.rowCollection = data.lJobOrderBean;
	            if($scope.rowCollection !=null && $scope.rowCollection.length>0 ){
	            	angular.forEach($scope.rowCollection, function(value, key) {
	            		angular.forEach($scope.qlt, function(value1, key1) {
	                		if(value.jobNo==value1){
	                			$scope.newQukLinkList.push(value);
	                		}
	                	})
	            	})
	            	$scope.rowCollection=[];
	            	$scope.rowCollection=$scope.newQukLinkList;
	            }
	        	
	            }).error(function(datas) {
	        });
	        
	     }
	    
	    // excel export
	    
	    $scope.excel = function() {
	        if($scope.joborder.branch !=''){
//	        	  if($scope.joborder.status1 !=''){
			$http.post($stateParams.tenantid + '/app/jobOrderSeaApp/generateExcel', $scope.joborder).success(function(data) {
				if (data.success == true) {
					
				$scope.debitNoteFileUrl = data.filePath.split("/");
				$scope.actualLength=$scope.debitNoteFileUrl.length;
				$scope.fileLength=$scope.actualLength - 1;
	            $scope.downloadFile = $scope.debitNoteFileUrl[$scope.fileLength];
	            console.log($scope.downloadFile)
				logger.logSuccess("Exported successfully!");
				 $('#exportXl').attr('href','filePath/' +$scope.downloadFile);
			    $("#exportXl").bind('click', function() {
			   });
			   $('#exportXl').simulateClick('click');
			  
			   } else {
					logger.logError("Failed to Export!..");
				}

			}).error(function(data) {
				logger.logError("Error Please Try Again");
			});
	        	/*  }
	        	  else{
	        	      if($scope.joborder.status1=='')
	        	          logger.logError("Please select Status");
	        	  }*/
	        }	else{
			      logger.logError("Please select  Branch");
			  }
 
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
   	 $scope.jobStatusList=[];
		$scope.getStatus = function() {
		    var  data = {};
		    data["id"] = "1";
		    data["text"] = "OPEN";
		    $scope.jobStatusList.push(data);
		    data = {};
		    data["id"] = "2";
		    data["text"] = "CLOSED";
		    $scope.jobStatusList.push(data);  
		    
		}
		

		$scope.getStatus();
});



app.controller('joborderAddctrl1',
				function($scope, $timeout, $stateParams, $filter, $rootScope,
						$http, $location, logger, utilsService, $state,
						sharedProperties, $window, ngDialog, $interval,
						validationService, toaster, $controller, $injector) {
					$scope.customerDropList = [];
					$scope.consigneeDropList  = [];
					$scope.shipperDropList  = [];
					$scope.nominatedDropList  = [];
					$scope.vendorDropList = [];
					$scope.serviceParnrDropList = [];
					$scope.shipperList = [];
					$scope.consigneeList = [];
					$scope.quotationList = [];
					$scope.sizeTypeList=[];
					$scope.AolList = [];
					$scope.AodList = []; 
					$scope.commodityList = []; 
					$scope.isEdit = false;
					$scope.jobOrderDtlList = [];
//					$scope.tempType = '';
//					$scope.defaultCurrency = 0;
//					$scope.fromCurrency=0;
//					$scope.toCurrency=0;
;
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

                  var todate = dd + '/' + mm + '/' + yyyy;
                  var time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
                  
               
					$scope.joborder={
							service:'',
							jobDate:todate,
							branch:'',
							customer:'',
							shipper:'',
							consignee : '',
							term : '',
							aol:'',
							aod :'',
							origin:'',
							destination:'',
							commodity:'',
							status:'',
							currency:'',
							quotationNo:'',
							quotationnum:'',
							salesType:'',
							salesPerson:'',payerName : '',
							nominatedBy:'',
							vendor:'',
							carrier:'',
							vessel:'',multi:false,
							flightDate:'',
							exRate:'',
							customsBroker:'',
							jbId :'',
							aodName:'',
							aolName:'',
							destinationName :'',
							custName :'' ,
							orgnName :'',
							modeName:'',mode:'',
							workOrder:'',
							trackship1:'',
							trackship2:'',commodityL:'',
						mode :'1',
						buy1: '',
						sell1 :'',
						buy:'',
						sell:'',
						pickupDate:'',
						stuffingDate:'',
						createdDt:'',
						sailingDate:'',
						customsCompletionsDate:'',
						etaDestinationDate:'',
						remarks1:'',
						
						jobStatus:'1',
							joborderDtl : [{
											joborderDtlId : '',
											mode :'1',
											buy1: '',
											sell1 :'',
											buy:'',
											sell:'',
											chargeHead : '',
											unit : '',
											conType: '',
											transactionType : '1',
											quantity : '',
											rate : '',
											currency :'',
											exRate :'',
											amount : '0',
										
											buySellParty : '',
											status:'1',
											amount1 :'',
											invoiceNo:''
											
							} ],
							joborderTracking : {
								 jobTrackingId : '',
								 jobId : '',
								 totalPcs : '',
								 totalGrosssWeight : '',
							     totalAmount : '',
								 totalNetWeight : '',
							},
							joborderTrackingDtl : [{
								select : '',
								containerNo : '',
								sizeType : '',
								cargoDescription : '',
								noOfPackage : '0',
								uom : '',
								netWeight : '0',
								grossWeight : '0',
								measurement : '0',
								remarks : ''
								
							}]
						}
						
						
						$scope.addRowTracking = function() {
							var jobOrderTrackingDtl = {
									select : '',
									containerNo : '',
									sizeType : '',
									cargoDescription : '',
									noOfPackage : '0',
									uom : '',
									netWeight : '0',
									grossWeight : '0',
									measurement : '0',
									remarks : ''
							}
							$scope.joborder.joborderTrackingDtl.push(jobOrderTrackingDtl);
						};
						 $scope.specialEmployeeFlag = false;
						 $scope.userId=$('#empId').val();

						 if( $scope.userId == 'E0002'|| $scope.userId =='E0003'||$scope.userId == 'E0006'||$scope.userId == 'E0004' || $scope.userId == 'E0001' || $scope.userId=='E0016' || $scope.userId=='E0110'){
							 $scope.specialEmployeeFlag = true;
						 }
						 
						 
						 
						//Approval
							$scope.allow = function(joborder) {	
								 
								$scope.joborder=joborder;
						         ngDialog.open({
						             scope : $scope,
						             template : 'views/sea/allowPopup.jsp',
						             controller : $controller('allowCtrl', {
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
						 	
						 						 

					    $scope.$watchCollection('[joborder.jobDate]',function(newValue, oldValue) {
							if ($scope.joborder.jobDate != '') {
								var frmDate = todate;
								var toDate = $scope.joborder.jobDate;
								var splitarray = new Array();
								splitarray = frmDate.split(" ");
								var date = splitarray[0];
								var time = splitarray[1];
								frmDate = date.split("/");
								frmDate = new Date(frmDate[2],
										frmDate[1] - 1, frmDate[0]);
								toDate = toDate.split("/");
								toDate = new Date(toDate[2],
										toDate[1] - 1, toDate[0]);
								if (toDate >frmDate) {
									logger.logError("Job Date should be less or equal to current date");
									$scope.joborder.jobDate = todate;
								}
							}
						});  
					    
					    
					    $scope.$watch('joborder.addShipper', function(newValue,
								oldValue) {
							if (newValue==true) {	
						         ngDialog.open({
						             scope : $scope,
						             template : 'views/sea/addShipperPopup.jsp',
						             controller : $controller('addShipperCtrl', {
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
								
						 		}
							
						});

					    $scope.$watch('joborder.addConsignee', function(newValue,
								oldValue) {
							if (newValue==true) {	
						         ngDialog.open({
						             scope : $scope,
						             template : 'views/sea/addConsigPopup.jsp',
						             controller : $controller('addShipperCtrl', {
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
								
						 		}
							
						});

					    $scope.$watch('joborder.currency', function(newValue,
								oldValue) {
							if (newValue != '' && newValue != undefined) {
							    
							    $http.get($stateParams.tenantid+ '/app/currency/getExchangeRate?currencyId='+parseInt(newValue))
								.success(
										function(data) {
											
											$scope.joborder.exRate = data.defaultCurrency;
										/*	$scope.purchaseinvoice.fromCurrency=data.fromCurrency;
											$scope.purchaseinvoice.toCurrency=data.toCurrency;*/
											
										});
							}
							
						});

						 $scope.$watch('joborder.mode', function(newValue,
								oldValue) {
							if (newValue != '' && newValue != undefined) {
							    
							    $http.get($stateParams.tenantid+ '/app/jobOrderSeaApp/getbookingListwithMode?mode='+newValue+'&jobDate='+$scope.joborder.jobDate)
								.success(
										function(data) {
											
										$scope.quotationList = data.quotationList;
										/*	$scope.purchaseinvoice.fromCurrency=data.fromCurrency;
											$scope.purchaseinvoice.toCurrency=data.toCurrency;*/
											
										});
							}
							
						});

					    $scope.checkDatesCL = function(jobDate){
					        var res = $scope.joborder.jobDate.split("/");
					        $http.get($stateParams.tenantid+'/app/cashbankreceipt/getloggedcompany?closingDate='
					        		+$scope.joborder.jobDate).success(function(datas) {
					            if(datas){
					                logger.logError("Account closed for year "+ res[2]);
					                $scope.joborder.jobDate = todate;
					            }
					        })
					    }

					$scope.printRoutingOrder = function(jobId){
				        
				        var url = $stateParams.tenantid+'/app/jobOrderSeaApp/printRoutingOrder?jobId=' + jobId;
				        var wnd = $window.open(url, 'ATHENA', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
				        wnd.print();   
				     }
					
					$scope.CheckExRateDtl = function(currecny,index){
						if (currecny != '' && currecny != undefined) {
					    
					    $http
						.get(
								$stateParams.tenantid
										+ '/app/currency/getExchangeRate?currencyId='+parseInt(currecny))
						.success(
								function(data) {
									
									/*if(!$scope.isEdit){
										$scope.joborder.joborderDtl[$scope.trIndex].exRate = data.defaultCurrency;
									}*/
									
									defaultCurrency1 = data.defaultCurrency;
									fromCurrency1=data.fromCurrency;
									toCurrency1=data.toCurrency;
									$scope.checkExRate($scope.joborder.joborderDtl[index].exRate,index);
									$scope.ratevalues();
								});
					}
					}
					
					$scope.viewQuotation = function(quotationNo) {
						
							$location.url($stateParams.tenantid+'/seaQuotation/view?QuotHdId='+quotationNo);
						
					}
					 var defaultCurrency = '';
					 var  fromCurrency='';
					 var toCurrency='';
					 
						$scope.$watch('joborder.currency', function(newValue,
								oldValue) {
							if (newValue != '' && newValue != undefined) {
							    
							    $http
								.get(
										$stateParams.tenantid
												+ '/app/currency/getExchangeRate?currencyId='+parseInt(newValue))
								.success(
										function(data) {
											
//											if(!$scope.isEdit){
//												$scope.joborder.exRate = data.defaultCurrency;
//											}
											
											$scope.joborder.exRate = data.defaultCurrency;
											
											defaultCurrency = data.defaultCurrency;
											fromCurrency=data.fromCurrency;
											toCurrency=data.toCurrency;
											$scope.checkExRate();
										});
							}
							
						});
						
						$scope.checkExRate = function(){
							if($scope.joborder.exRate >= fromCurrency && $scope.joborder.exRate <= toCurrency){
								
							}
							else{
								//logger.logError("Exchange Rate Between "+fromCurrency+ " and " +toCurrency);
								$scope.joborder.exRate ='';
							}
						}

						$scope.$watch('joborder.jobStatus', function(newValue,
								oldValue) {
							if (newValue != '' && newValue != undefined) {
								if(newValue==2)
									{
									$scope.Add=false;
									
									}else{
										$scope.Add=true;
									}
							}
							
						});
	
					$scope.printPrealertSea= function(jobId){
				        
				        var url = $stateParams.tenantid+'/app/jobOrderSeaApp/printPreAlert?jobId=' + jobId;
				        var wnd = $window.open(url, 'ATHENA', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
				        wnd.print();   
				     }
					
					$scope
					.$watch(
							'joborder.salesType',
							function(newValue, oldValue) {

								if (newValue != ''
										&& newValue != undefined) {

									if(newValue == '3'){
										$scope.employeeList = [ {
									        id : 'E0040',
									        text : 'E0040-NOMINATED'
									    }]
									}
									else{
										$http.get($stateParams.tenantid+'/app/airquotation/getEmployeeList').success(function(datas) {
											 $scope.employeeList = datas.commonUtilityBean;
										    
										}).error(function(data) {

										});
									}
								
								}
							});
					
				$scope.ratevalues1= function(){
				 if($scope.joborder.joborderDtl.length != null ||$scope.joborder.joborderDtl.length != undefined ||$scope.joborder.joborderDtl.length != "" ||$scope.joborder.joborderDtl.length != ''){
						for( var i=0;i<=$scope.joborder.joborderDtl.length-1;i++)
							{
							if(($scope.joborder.joborderDtl[i].transactionType != null ) || ($scope.joborder.joborderDtl[i].transactionType != undefined ) ||($scope.joborder.joborderDtl[i].transactionType != "" ) ||($scope.joborder.joborderDtl[i].transactionType != '' ))
							{
							if($scope.joborder.joborderDtl[i].transactionType =="1")
								{
								buy1=parseFloat(buy1)+parseFloat($scope.joborder.joborderDtl[i].amount);
								console.log("i:"+i+" buy1:"+buy1);
								}
							else {
								if($scope.joborder.joborderDtl[i].transactionType =="2")
								{
								sell1=parseFloat(sell1)+parseFloat($scope.joborder.joborderDtl[i].amount);
								
								}
							}
							}
							}
						total =parseFloat(buy1)-parseInt(sell1);
						
						console.log("total"+total+" sell1:"+sell1);	
			    	}
									
					$scope.joborder.sell1=sell1;
					$scope.joborder.buy1=buy1;
					$scope.joborder.total=total;
					}
				/*	var amount =0;
					

					var buy=0;

				var buy1 =0;
				var sell=0;
				var sell1 =0;
				
				var total =0; 
					*/
				$scope.$watch('joborder.joborderTrackingDtl[trIndex1].noOfPackage', function(newValue, oldValue) {
			    	var noOfPcs=0;
					for (var i = 0; i <= $scope.joborder.joborderTrackingDtl.length; i++) {
						if($scope.joborder.joborderTrackingDtl[i].noOfPackage==""){
							$scope.joborder.joborderTrackingDtl[i].noOfPackage=0;
							noOfPcs=parseInt($scope.joborder.joborderTrackingDtl[i].noOfPackage)+noOfPcs;
							$scope.joborder.joborderTracking.totalPcs=noOfPcs;
						}
						else{
							noOfPcs=parseInt($scope.joborder.joborderTrackingDtl[i].noOfPackage)+noOfPcs;
							$scope.joborder.joborderTracking.totalPcs=noOfPcs;
						}
						
						
					}
					
			    })
			    $scope.$watch('joborder.joborderTrackingDtl[trIndex1].netWeight', function(newValue, oldValue) {
					var noOfNet=0.0;
					for (var i = 0; i <= $scope.joborder.joborderTrackingDtl.length; i++) {
						if($scope.joborder.joborderTrackingDtl[i].netWeight==""){
							$scope.joborder.joborderTrackingDtl[i].netWeight=0.0;
							noOfNet=parseFloat($scope.joborder.joborderTrackingDtl[i].netWeight)+noOfNet;
							$scope.joborder.joborderTracking.totalNetWeight=noOfNet;
						}
						else{
							noOfNet=parseFloat($scope.joborder.joborderTrackingDtl[i].netWeight)+noOfNet;
							$scope.joborder.joborderTracking.totalNetWeight=noOfNet;
						}
						
						
					}
					
			    })
			     $scope.$watch('joborder.joborderTrackingDtl[trIndex1].grossWeight', function(newValue, oldValue) {
			    	 var noOfGross=0.0;
						for (var i = 0; i <= $scope.joborder.joborderTrackingDtl.length-1; i++) {
							if($scope.joborder.joborderTrackingDtl[i].grossWeight==""){
								$scope.joborder.joborderTrackingDtl[i].grossWeight=0.0;
								noOfGross=parseFloat($scope.joborder.joborderTrackingDtl[i].grossWeight)+noOfGross;
								$scope.joborder.joborderTracking.totalGrosssWeight=noOfGross;
							}
							else{
								noOfGross=parseFloat($scope.joborder.joborderTrackingDtl[i].grossWeight)+noOfGross;
								$scope.joborder.joborderTracking.totalGrosssWeight=noOfGross;
							}
							
							
						}	$scope.qty();
			    })
			    $scope.qty = function() {

						for (var i = 0; i <= $scope.joborder.joborderDtl.length - 1; i++) {
							var grossqty = 0;
							if ($scope.joborder.joborderDtl[i].unit == 2
									|| $scope.joborder.joborderDtl[i].unit == 3) {

								angular
										.forEach(
												$scope.joborder.joborderTrackingDtl,
												function(value, key) {
													if (value.uom == '3') {
														if (value.sizeType == $scope.joborder.joborderDtl[i].conType) {
															if (value.grossWeight != undefined
																	&& value.grossWeight != '') {

																grossqty = grossqty
																		+ value.grossWeight;
															}
														}
													}
												})
								$scope.joborder.joborderDtl[i].quantity = grossqty;
								$scope.joborder.joborderDtl[i].amount = $scope.joborder.joborderDtl[i].quantity
										* $scope.joborder.joborderDtl[i].rate
										* $scope.joborder.joborderDtl[i].exRate;
								$scope.ratevalues();

							}

						}

					}
				$scope.noOfPcs = function() {
					var noOfPcs=0;
					for (var i = 0; i <= $scope.joborder.joborderTrackingDtl.length; i++) {
						if($scope.joborder.joborderTrackingDtl[i].noOfPackage==""){
							$scope.joborder.joborderTrackingDtl[i].noOfPackage=0;
							noOfPcs=parseInt($scope.joborder.joborderTrackingDtl[i].noOfPackage)+noOfPcs;
							$scope.joborder.joborderTracking.totalPcs=noOfPcs;
						}
						else{
							noOfPcs=parseInt($scope.joborder.joborderTrackingDtl[i].noOfPackage)+noOfPcs;
							$scope.joborder.joborderTracking.totalPcs=noOfPcs;
						}
						
						
					}
				}
				$scope.noOfNet = function() {
					var noOfNet=0.0;
					for (var i = 0; i <= $scope.joborder.joborderTrackingDtl.length; i++) {
						if($scope.joborder.joborderTrackingDtl[i].netWeight==""){
							$scope.joborder.joborderTrackingDtl[i].netWeight=0.0;
							noOfNet=parseFloat($scope.joborder.joborderTrackingDtl[i].netWeight)+noOfNet;
							$scope.joborder.joborderTracking.totalNetWeight=noOfNet;
						}
						else{
							noOfNet=parseFloat($scope.joborder.joborderTrackingDtl[i].netWeight)+noOfNet;
							$scope.joborder.joborderTracking.totalNetWeight=noOfNet;
						}
						
						
					}
				}
				
				 
				$scope.noOfGross = function() {
					var noOfGross=0.0;
					for (var i = 0; i <= $scope.joborder.joborderTrackingDtl.length-1; i++) {
						if($scope.joborder.joborderTrackingDtl[i].grossWeight==""){
							$scope.joborder.joborderTrackingDtl[i].grossWeight=0.0;
							noOfGross=parseFloat($scope.joborder.joborderTrackingDtl[i].grossWeight)+noOfGross;
							$scope.joborder.joborderTracking.totalGrosssWeight=noOfGross;
						}
						else{
							noOfGross=parseFloat($scope.joborder.joborderTrackingDtl[i].grossWeight)+noOfGross;
							$scope.joborder.joborderTracking.totalGrosssWeight=noOfGross;
						}
						
						
					}
				}
				
				
					$scope.ratevalues= function(){
						var buy1 =0;
						var sell=0;
						var sell1 =0;
						var amount =0;

						var total =0; 
				    	if($scope.joborder.joborderDtl.length != null ||$scope.joborder.joborderDtl.length != undefined ||$scope.joborder.joborderDtl.length != "" ||$scope.joborder.joborderDtl.length != ''){
{
	for( var i=0;i<=$scope.joborder.joborderDtl.length-1;i++)
{
		

		var amount1=[];
		var amount=[];
		if(($scope.joborder.joborderDtl[i].transactionType != null ) || ($scope.joborder.joborderDtl[i].transactionType != undefined ) ||($scope.joborder.joborderDtl[i].transactionType != "" ) ||($scope.joborder.joborderDtl[i].transactionType != '' ))
         {
			if($scope.joborder.joborderDtl[i].transactionType =="1")
              {
				
				if(($scope.joborder.joborderDtl[i].quantity  != null || $scope.joborder.joborderDtl[i].quantity != undefined ||$scope.joborder.joborderDtl[i].quantity !="" ||$scope.joborder.joborderDtl[i].quantity != '') &&  ($scope.joborder.joborderDtl[i].rate  != null || $scope.joborder.joborderDtl[i].rate != undefined ||$scope.joborder.joborderDtl[i].rate != " " ||$scope.joborder.joborderDtl[i].rate != '') && ($scope.joborder.joborderDtl[i].exRate  != null || $scope.joborder.joborderDtl[i].exRate == undefined ||$scope.joborder.joborderDtl[i].exRate !="" ||$scope.joborder.joborderDtl[i].exRate != '') )
				{
				amount1[i] = (parseFloat(($scope.joborder.joborderDtl[i].quantity)) * parseFloat(($scope.joborder.joborderDtl[i].rate))*parseFloat(($scope.joborder.joborderDtl[i].exRate)));
				$scope.joborder.joborderDtl[i].amount=parseFloat(amount1[i]);

				
			
				buy1=parseFloat(buy1)+parseFloat($scope.joborder.joborderDtl[i].amount);
				console.log("i:"+i+" buy1:"+buy1);
				
				}
              }	
			
			else {
				if($scope.joborder.joborderDtl[i].transactionType =="2")
				{
								
								if(($scope.joborder.joborderDtl[i].quantity  != null || $scope.joborder.joborderDtl[i].quantity != undefined ||$scope.joborder.joborderDtl[i].quantity !="" ||$scope.joborder.joborderDtl[i].quantity != '') &&  ($scope.joborder.joborderDtl[i].rate  != null || $scope.joborder.joborderDtl[i].rate != undefined ||$scope.joborder.joborderDtl[i].rate != " " ||$scope.joborder.joborderDtl[i].rate != '') && ($scope.joborder.joborderDtl[i].exRate  != null || $scope.joborder.joborderDtl[i].exRate == undefined ||$scope.joborder.joborderDtl[i].exRate !="" ||$scope.joborder.joborderDtl[i].exRate != '') )
								{
								amount1[i] = (parseFloat(($scope.joborder.joborderDtl[i].quantity)) * parseFloat(($scope.joborder.joborderDtl[i].rate))*parseFloat(($scope.joborder.joborderDtl[i].exRate)));
								$scope.joborder.joborderDtl[i].amount=parseFloat(amount1[i]);

								sell1=parseFloat(sell1)+parseFloat($scope.joborder.joborderDtl[i].amount);
								console.log("i:"+i+" sell1:"+sell1);
								}
				}	
			}
			
			
			

}

		$scope.joborder.joborderDtl[i].amount=parseFloat(amount1[i]).toFixed(2);
		
	
}
	total =parseFloat(sell1)-parseFloat(buy1);
	
	console.log("total"+total+" sell1:"+sell1);	
	
	
	}
				    	}
				    	$scope.joborder.sell1=sell1.toFixed(2);
						$scope.joborder.buy1=buy1.toFixed(2);
						$scope.joborder.total=total.toFixed(2);
						
					}
					

					$scope.edit = false;
					  
					$scope.salesTypeList=[];
			/*		$scope.getSalesType = function() {
					    var  data = {};
					    data["id"] = "1";
					    data["text"] = "CROSS TRADE";
					    $scope.salesTypeList.push(data);
					    data = {};
					    data["id"] = "2";
					    data["text"] = "LOCAL";
					    $scope.salesTypeList.push(data);  
					    data = {};
					    data["id"] = "3";
					    data["text"] = "NOMINATED";
					    $scope.salesTypeList.push(data);  
					    
					  
					}
					$scope.getSalesType();*/
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
					    data["id"] = "5";
					    data["text"] = "FORWARDING";
					     $scope.modeList.push(data);
					   /*  data = {};
						    data["id"] = "4";
						    data["text"] = "LINER";
						     $scope.modeList.push(data);*/
						// data = {};
						// data["id"] = "2";
						// data["text"] = "SEA";
						// $scope.modeList.push(data);
					}
					$scope.getQuotationType();
					
					 $scope.transactionTypeList=[];
					/*
					$scope.getTransactionType = function() {
					    var  data = {};
					    data["id"] = "1";
					    data["text"] = "BUY";
					    $scope.transactionTypeList.push(data);
					    data = {};
					    data["id"] = "2";
					    data["text"] = "SELL";
					    $scope.transactionTypeList.push(data);  
					    
					}
					$scope.getTransactionType();
					*/
					 $scope.jobStatusListDtl=[];
						$scope.getjobStatus = function() {
						    var  data = {};
						    data["id"] = "1";
						    data["text"] = "PENDING";
						    $scope.jobStatusListDtl.push(data);
						    data = {};
						    data["id"] = "2";
						    data["text"] = "INVOICED";
						    $scope.jobStatusListDtl.push(data);
						    data = {};
						    data["id"] = "3";
						    data["text"] = "DRAFT";
						    $scope.jobStatusListDtl.push(data);
						    
						}
						$scope.getjobStatus();
					
					/*$scope.PaymentMethodList=[];
					$scope.getpaymentMethod = function() {
					    var  data = {};
					    data["id"] = "1";
					    data["text"] = "PREAPID TO COLLECT";
					    $scope.PaymentMethodList.push(data);
					  
					}
					$scope.getpaymentMethod();*/
					 $scope.jobStatusList=[];
						$scope.getStatus = function() {
						    var  data = {};
						    data["id"] = "1";
						    data["text"] = "OPEN";
						    $scope.jobStatusList.push(data);
						    data = {};
						    data["id"] = "2";
						    data["text"] = "CLOSED";
						    $scope.jobStatusList.push(data);  
						    
						}
						

						$scope.getStatus();
					//$scope.getQuotationType();
					$scope.dropdown=function(){
						$http.post($stateParams.tenantid+'/app/seaquotation/getServicePartnerList').success(function(datas) {
							 $scope.customerBuyList=datas.vendorMasterList;
							 $scope.customerSellList=datas.serviceParnrList;						
						}).error(function(data) {
						});
						$http.get($stateParams.tenantid+'/app/jobOrderSeaApp/dropDownList').success(function(datas) {
							
						  //  $scope.quotationList = datas.quotationList;	
							$scope.customerDropList = datas.customerSelectivityList;
							$scope.consigneeDropList = datas.consigneeSelectivityList;
							$scope.shipperDropList = datas.shipperSelectivityList;
							$scope.nominatedDropList = datas.nominatedSelectivityList;
							$scope.vendorDropList = datas.vendorSelectivityList;
							$scope.serviceParnrDropList=datas.serviceParnrSelectivityList;
							/*$scope.customerBuyList = datas.buyServiceList;
							$scope.customerSellList = datas.sellServiceList;*/
							$scope.salesTypeList = datas.salesSelectivityList;
							$scope.employeeList = datas.employeeSelectivityList;
							$scope.servicePartnerTypelist = datas.serviceSelectivityList;
							/*$scope.PaymentMethodList = datas.paymentSelectivityList;*/
							$scope.transactionTypeList = datas.transactionSelectivityList;
							$scope.chargeHeadList = datas.chargeHeadSelectivityList;
							$scope.TermList = datas.termsSelectivityList;
							$scope.UnitList = datas.unitSelectivityList;
							$scope.uomList = datas.uomList;	 
							//$scope.sizeTypeList = datas.sizeTypeSelectivityList;
							//$scope.commodityList = datas.commoditySelectivityList;	
							$scope.currencylist= datas.currecnySelectivityList;
							$scope.branchList = datas.branchSelectivityList;
						    $scope.portList = datas.portSelectivityList;
						}).error(function(data) {

						});
						$scope.getDropDownListprt = function() {
					        $http.post($stateParams.tenantid+'/app/seaquotation/getcommodity').success(function(data){
					        	$scope.commodityList=data.commonUtilityBean;
					            
					            $timeout(function() { 
					                $("#commodityL").multiselect({
					                    maxHeight: 200,
					                    includeSelectAllOption: true,
					                    selectAllText: 'Select All',
					                    enableFiltering: true,
					                    enableCaseInsensitiveFiltering: true,
					                    filterPlaceholder: 'Search',
					                    onChange: function(element, checked) {
					                        ;
					                        var ct=""; 
					                      if($scope.commodityList.length>0){   
					                          $scope.joborder.commodity ='';
					                         angular.forEach($scope.joborder.commodityL, function (item, key) {
					                             if(ct==""){
					                                 ct = item.id;
					                             }else{
					                                 ct +=","+ item.id;
					                             }       
					                             $scope.joborder.commodity = ct;
					                         });
					                      }else{
					                    	  $scope.joborder.commodity = '';
					                      }
					                    }
					                  });
					                $("#commodityL").parent().find('.btn-group #multiselect-button').addClass('width_100 input-sm line-height-5'); 
					                
					                }, 2, false);
					            
					            $timeout(function() { 
					                $("#commodityL").multiselect({
					                    maxHeight: 200,
					                    includeSelectAllOption: true,
					                    selectAllText: 'Select All',
					                    enableFiltering: true,
					                    enableCaseInsensitiveFiltering: true,
					                    filterPlaceholder: 'Search',
					                    onChange: function(element, checked) {
					                        ;
					                        var ct=""; 
					                      if($scope.commodityList.length>0){   
					                          $scope.joborder.commodity ='';
					                         angular.forEach($scope.joborder.commodityL, function (item, key) {
					                             if(ct==""){
					                                 ct = item.id;
					                             }else{
					                                 ct +=","+ item.id;
					                             }       
					                             $scope.joborder.commodity = ct;
					                         });
					                      }else{
					                    	  $scope.joborder.commodity = '';
					                      }
					                    }
					                  });
					                $("#commodityL").parent().find('.btn-group #multiselect-button').addClass('width_100 input-sm line-height-5'); 
					                
					                }, 2, false);
					        }).error(function(data) {
					        });

					    }
					    $scope.getDropDownListprt();
						$http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(datas) {	  
							  $scope.sizeTypeList=datas.getcontypelist;

						}).error(function(data) {

						});
						
						$http.get($stateParams.tenantid+ '/app/commonUtility/getQuoteApproveList').success(function(data) {
							$scope.quotationnoList = data;						
						});
						/*$http.post($stateParams.tenantid+'/app/seaquotation/getServicePartnerList').success(function(datas) {
							console.log(datas);
							$scope.customerDropList = datas.customerList;
							 $scope.consigneeDropList = datas.consigneeList;
							 $scope.shipperDropList = datas.shipperList;
							 $scope.nominatedDropList = datas.nominatedList;
							 $scope.vendorDropList = datas.vendorList;
							 $scope.serviceParnrDropList=datas.serviceParnrList;
						  
						}).error(function(data) {

						});
						
						$http.get(
								$stateParams.tenantid
										+ '/app/jobOrderAir/dropDownList')
								.success(function(datas) {
									
									$scope.customerBuyList = datas.buyServiceList;
									$scope.customerSellList = datas.sellServiceList;
								}).error(function(data) {

								});
						
						$http.get($stateParams.tenantid+'/app/seaquotation/getiataList').success(function(datas) {
							
						    $scope.portList = datas.commonUtilityBean;	    

						}).error(function(data) {

						});
					 
						$http.get($stateParams.tenantid+'/app/airquotation/getBranch').success(function(datas) {
							 $scope.branchList = datas.commonUtilityBean;
						    
						}).error(function(data) {

						});
						$http.get($stateParams.tenantid+'/app/airquotation/getCurrencyList').success(function(datas) {	  
							$scope.currencylist= angular.copy(datas.commonUtilityBean);
						}).error(function(data) {

						});
						
						$http.get($stateParams.tenantid+'/app/seaquotation/getcommodity').success(function(datas) {
							
						    $scope.commodityList = datas.commonUtilityBean;	    

						}).error(function(data) {

						});
						
						$http.get($stateParams.tenantid+'/app/airquotation/getServiceList').success(function(datas) {	  
							$scope.servicePartnerTypelist= angular.copy(datas.commonUtilityBean);
						}).error(function(data) {

						});
						
						$http.get($stateParams.tenantid+'/app/airquotation/getEmployeeList').success(function(datas) {
							 $scope.employeeList = datas.commonUtilityBean;
						    
						}).error(function(data) {

						});
						
						$http.get($stateParams.tenantid+'/app/jobOrderSeaApp/dropDownList').success(function(datas) {
							
						  //  $scope.quotationList = datas.quotationList;	 
							$scope.uomList = datas.uomList;	 
							$scope.salesTypeList = datas.commonUtilityBean;
						}).error(function(data) {

						});
						
						$http.get($stateParams.tenantid + '/app/airquotation/getSalesList')
						.success(function(datas) {
							$scope.salesTypeList = datas.commonUtilityBean;

						}).error(function(data) {

						});
						
						$http.get($stateParams.tenantid + '/app/airquotation/getServiceList')
						.success(function(datas) {
							$scope.servicePartnerTypelist = datas.commonUtilityBean;

						}).error(function(data) {

						});
						
						$http.get($stateParams.tenantid + '/app/airquotation/getPaymentList')
						.success(function(datas) {
							$scope.PaymentMethodList = datas.commonUtilityBean;

						}).error(function(data) {

						});
						
						
						$http.get($stateParams.tenantid + '/app/airquotation/getTransactionList')
						.success(function(datas) {
							$scope.transactionTypeList = datas.commonUtilityBean;

						}).error(function(data) {

						});		
						
						$http.get($stateParams.tenantid + '/app/seaquotation/getChargeHeads')
						.success(function(datas) {
							$scope.chargeHeadList = datas.commonUtilityBean;

						}).error(function(data) {

						});
						
						$http.get($stateParams.tenantid + '/app/seaquotation/getTerms')
						.success(function(datas) {
							$scope.TermList = datas.commonUtilityBean;

						}).error(function(data) {

						});

				$http.get($stateParams.tenantid + '/app/seaquotation/getUnitList')
						.success(function(datas) {
							$scope.UnitList = datas.commonUtilityBean;

						}).error(function(data) {

						});*/
					}
					
					/*$http.get(
							$stateParams.tenantid
									+ '/app/seaquotation/getuomList')
							.success(function(datas) {
								$scope.uomList = datas.commonUtilityBean;

							}).error(function(data) {

							});
					$http.get(
							$stateParams.tenantid
									+ '/app/jobOrderSeaApp/getsizeTypeList')
							.success(function(datas) {
								$scope.sizeTypeList = datas.commonUtilityBean;

							}).error(function(data) {

							});*/
					
					$scope.dropdown();
					
					
					$http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(datas) {
						
					   $scope.conTypeList=datas.getcontypelist;
						$scope.containerNoList=datas.getcontainer;
						
					}).error(function(datas) {

					});
					
					
					$http.get($stateParams.tenantid+ '/app/commonUtility/getVoyageList').success(function(data) {
     					$scope.voyageList = data;
					});
					
					
					$scope.checkValidation = function() {

						var alertmsg = "<ui><h4>Please fill the required fields</h4>";
						var msg = "";
						if ($scope.checkundefined($scope.joborder.quotationNo)) {
							msg = msg + "<li>quotation No :Field is required.</li>";
							$scope.changecolor('quotationNo');
						}else{
							$scope.changecolor('quotationNo');
						}
						if ($scope.checkundefined($scope.joborder.jobDate)) {
							msg = msg + "<li>Job Date :Field is required.</li>";
							$scope.changecolor('jobDate');
						}else{
							$scope.changecolor('jobDate');
						}
						if($scope.checkundefined($scope.joborder.service)){
							msg = msg + "<li>Service :Field is required.</li>";
							$scope.changecolor('service');
						}else{
							$scope.changecolor('service');
						}
					  if($scope.checkundefined($scope.joborder.branch)){
							msg = msg + "<li>Branch :Field is required.</li>";
							$scope.changecolor('branch');
						}else{
							$scope.changecolor('branch');
						}
					  /*if($scope.checkundefined($scope.joborder.shipper)){
							msg = msg + "<li>Shipper :Field is required.</li>";
							$scope.changecolor('shipper');
						}else{
							$scope.changecolor('shipper');
						}*/
					  if($scope.checkundefined($scope.joborder.destination)){
							msg = msg + "<li>Destination :Field is required.</li>";
							$scope.changecolor('destination');
						}else{
							$scope.changecolor('destination');
						}
					  
						  if($scope.checkundefined($scope.joborder.origin)){
							msg = msg + "<li>Origin :Field is required.</li>";
							$scope.changecolor('origin');
						}else{
							$scope.changecolor('origin');
						}
						  /*if($scope.checkundefined($scope.joborder.commodity)){
								msg = msg + "<li>Commodity :Field is required.</li>";
								$scope.changecolor('commodity');
							}else{
								$scope.changecolor('commodity');
							}*/
						  if($scope.checkundefined($scope.joborder.currency)){
								msg = msg + "<li>Currency :Field is required.</li>";
								$scope.changecolor('currency');
							}else{
								$scope.changecolor('currency');
							}
						  if($scope.checkundefined($scope.joborder.salesPerson)){
								msg = msg + "<li>SalesPerson :Field is required.</li>";
								$scope.changecolor('salesPerson');
							}else{
								$scope.changecolor('salesPerson');
							}
						  
						  /*if($scope.checkundefined($scope.joborder.nominatedBy)){
								msg = msg + "<li>NominatedBy :Field is required.</li>";
								$scope.changecolor('nominatedBy');
							}else{
								$scope.changecolor('nominatedBy');
							}*/
						
						  /*if($scope.checkundefined($scope.joborder.vendor)){
								msg = msg + "<li>Vendor :Field is required.</li>";
								$scope.changecolor('vendor');
							}else{
								$scope.changecolor('vendor');
							}*/
						   
						    /*if($scope.checkundefined($scope.joborder.carrier)){
							msg = msg + "<li>Carrier :Field is required.</li>";
							$scope.changecolor('carrier');
						}else{
							$scope.changecolor('carrier');
						}*/
						   /* if($scope.checkundefined($scope.joborder.vessel)){
								msg = msg + "<li>Vessel/Voyage :Field is required.</li>";
								$scope.changecolor('vessel');
							}else{
								$scope.changecolor('vessel');
							}*/
						    
						   /* if($scope.checkundefined($scope.joborder.exRate)){
							msg = msg + "<li>Ex-Rate :Field is required.</li>";
							$scope.changecolor('exRate');
						}else{
							$scope.changecolor('exRate');
						}*/
						angular.forEach($scope.joborder.joborderDtl, function(chargesDetail,
								index) {
							
							if ($scope.checkundefined(chargesDetail.chargeHead)) {
								msg = msg + "<li>Row :" + (index + 1)
										+ "# Charge Heads :Field is required.</li>";
								$scope.changecolor('chargeHeads' + index);
							} else {
								$scope.clearcolor('chargeHeads' + index);
							}
							if ($scope.checkundefined(chargesDetail.unit)) {
								msg = msg + "<li>Row :" + (index + 1)
										+ "# Unit :Field is required.</li>";
								$scope.changecolor('unit' + index);
							} else {
								$scope.clearcolor('unit' + index);
							}
							if ($scope.checkundefined(chargesDetail.currency)) {
								msg = msg + "<li>Row :" + (index + 1)
										+ "# CURRENCY :Field is required.</li>";
								$scope.changecolor('currency' + index);
							} else {
								$scope.clearcolor('currency' + index);
							}
							if ($scope.checkundefined(chargesDetail.quantity)) {
								msg = msg + "<li>Row :" + (index + 1)
										+ "# Quantity :Field is required.</li>";
								$scope.changecolor('qty' + index);
								$('#qty' + index).find('input').css("border-color", "red");

							} else {
								$('#qty' + index).find('input').css("border-color", "#e8dddd");
							}
							if ($scope.checkundefined(chargesDetail.rate)) {
								msg = msg + "<li>Row :" + (index + 1)
										+ "# Rate :Field is required.</li>";
							}
						
							if ($scope.checkundefined(chargesDetail.transactionType)) {
								msg = msg + "<li>Row :" + (index + 1)
										+ "# Transaction Type :Field is required.</li>";
							}
							if ($scope.checkundefined(chargesDetail.buySellParty)) {
								msg = msg + "<li>Row :" + (index + 1)
										+ "# Buy Sell:Field is required.</li>";
							}
							if ($scope.checkundefined(chargesDetail.amount)) {
								msg = msg + "<li>Row :" + (index + 1)
										+ "# Amount:Field is required.</li>";
							}

							if ($scope.checkundefined(chargesDetail.exRate)) {
								msg = msg + "<li>Row :" + (index + 1)
										+ "# Exchange Rate:Field is required.</li>";
							}

							if ($scope.checkundefined(chargesDetail.transactionType)) {
								msg = msg + "<li>Row :" + (index + 1)
										+ "# Transaction Type :Field is required.</li>";
							}
							
							if ($scope.checkundefined(chargesDetail.status)) {
								msg = msg + "<li>Row :" + (index + 1)
										+ "# Status :Field is required.</li>";
							}

						}); 						    

						/*angular.forEach($scope.joborder.joborderTrackingDtl, function(TrackingDtl,
								index) {
							
							if ($scope.checkundefined(TrackingDtl.commodity)) {
								msg = msg + "<li>Row :" + (index + 1)
										+ "# Commodity :Field is required.</li>";
								$scope.changecolor('Commodity' + index);
							} else {
								$scope.clearcolor('Commodity' + index);
							}
							if ($scope.checkundefined(TrackingDtl.descriptionGoods)) {
								msg = msg + "<li>Row :" + (index + 1)
										+ "# DescriptionGoods :Field is required.</li>";
								$scope.changecolor('descriptionGoods' + index);
							} else {
								$scope.clearcolor('descriptionGoods' + index);
							}
							if ($scope.checkundefined(TrackingDtl.uom)) {
								msg = msg + "<li>Row :" + (index + 1)
										+ "# LWH UOM :Field is required.</li>";
								$scope.changecolor('uom' + index);
							} else {
								$scope.clearcolor('uom' + index);
							}
							if ($scope.checkundefined(TrackingDtl.noOfPieces)) {
								msg = msg + "<li>Row :" + (index + 1)
										+ "# NoOfPieces :Field is required.</li>";
								$scope.changecolor('noOfPieces' + index);
							} else {
								$scope.clearcolor('noOfPieces' + index);
							}
							if ($scope.checkundefined(TrackingDtl.netWeight)) {
								msg = msg + "<li>Row :" + (index + 1)
										+ "# NetWeight :Field is required.</li>";
								$scope.changecolor('netWeight' + index);
							} else {
								$scope.clearcolor('netWeight' + index);
							}
							if ($scope.checkundefined(TrackingDtl.grossWeight)) {
								msg = msg + "<li>Row :" + (index + 1)
										+ "# GrossWeight :Field is required.</li>";
								$scope.changecolor('GrossWeight' + index);
							} else {
								$scope.clearcolor('GrossWeight' + index);
							}
							if ($scope.checkundefined(TrackingDtl.amount)) {
								msg = msg + "<li>Row :" + (index + 1)
										+ "# Amount :Field is required.</li>";
								$scope.changecolor('Amount' + index);
							} else {
								$scope.clearcolor('Amount' + index);
							}
							

						});*/
						alertmsg = alertmsg + msg + "</ui>";
						if ($scope.checkundefined(msg)) {
							return '';
						} else {
							return alertmsg;
						}

					}
				 
					$scope.checkundefined = function(value) {
						var invalid = false;
						if (value == undefined || value == 'undefined'
								|| value == null || value == 'null'
								|| value == '') {
							invalid = true;
						}
						return invalid;

					}
					
					$scope.changecolor = function(id) {
						$('#' + id + ' .selectivityId').find('input').css(
								"border-color", "red");
						;

					}
					$scope.clearcolor = function(id) {
						$('#' + id + ' .selectivityId').find('input').css(
								"border-color", "#e8dddd");
						;

					}
					
					
					
					$scope.addRow = function() {
							var jobOrderDtl = {
								joborderDtlId : '',
								chargeHead : '',
								unit : '',
								conType: '',
								transactionType : '1',
								quantity : '',
								rate : '',
								currency :'',
								exRate :'1',
								amount : '0',
								amount1 :'' ,
							
								buySellParty : '',
								status:'1'
						} 
							$scope.joborder.joborderDtl.push(jobOrderDtl);
					};
					
					$scope.deleteIds = [];
						$scope.removeRow = function() {
							var len = $scope.joborder.joborderDtl.length;
							for (var index = len - 1; index < len; index--) {
								if ($scope.joborder.joborderDtl[index].select == true) {
									if ($scope.joborder.joborderDtl[index].jobDtlId != null
											&& $scope.joborder.joborderDtl[index].jobDtlId > 0) {
										$scope.deleteIds
												.push($scope.joborder.joborderDtl[index].jobDtlId);
									}
									$scope.joborder.joborderDtl.splice(index, 1);
									$scope.ratevalues();
								}
							}
					};
					
					$scope.removeRowTracking = function() {
						var len = $scope.joborder.joborderTrackingDtl.length;
						for (var index = len - 1; index < len; index--) {
							if ($scope.joborder.joborderTrackingDtl[index].select == true) {
								
								$scope.joborder.joborderTrackingDtl.splice(index, 1);
							}
						}
					};
					
					
					/* $scope.$watch('joborder.jobDate', function(newValue,
							oldValue) {
						if (newValue != '' && newValue != undefined) {
						    
						    $http
							.post(
									$stateParams.tenantid
											+ '/app/jobOrderSeaApp/getQuotationList',
										newValue)
							.success(
									function(data) {
										
										$scope.quotationList = data.quotationList;
										
									});
						}
						
					});*/
					
//					$scope.$watch('joborder.currency', function(newValue,
//							oldValue) {
//						if (newValue ==1) {
//							$scope.joborder.exRate='1';
//						    }
//						else{
//							$scope.joborder.exRate='';
//						}
//						
//					});
					
					
					
					
					$scope.$watch('joborder.quotationNo', function(newValue,
							oldValue) {

						if (newValue != '' && newValue != undefined) {
				    
				    $http
					.post(
							$stateParams.tenantid
									+ '/app/salesBooking/edit',
									newValue)
					.success(
							function(data) {
								
							var md=data.bookingBean.mode;
								if(data.bookingBean.salesPerson != null &&
										data.bookingBean.salesPerson != ''){
								$scope.joborder.salesPerson = data.bookingBean.salesPerson
										.toString();
								}
								if(data.bookingBean.pol != null &&
										data.bookingBean.pol != ''){
								$scope.joborder.aol = data.bookingBean.pol
										.toString();
								}
								if(data.bookingBean.pod != null &&
										data.bookingBean.pod != ''){
								$scope.joborder.aod = data.bookingBean.pod
										.toString();
								}
								
								
								if(data.bookingBean.quotationno != null &&
										data.bookingBean.quotationno != ''){
								$scope.joborder.quoteNo = data.bookingBean.quotationno.toString();
								}
							
							
								if(data.bookingBean.carrier != null &&
										data.bookingBean.carrier != ''){
								$scope.joborder.carrier = data.bookingBean.carrier
										.toString();
								}
								/*if(data.bookingBean.vessel != null &&
										data.bookingBean.vessel != ''){
								$scope.joborder.vessel = data.bookingBean.vessel;
								}*/
								
								if(data.bookingBean.voyage != null &&
										data.bookingBean.voyage != ''){
								$scope.joborder.vessel = data.bookingBean.voyage;
								}
								
								if(data.bookingBean.service != null &&
										data.bookingBean.service != ''){
								$scope.joborder.service = data.bookingBean.service
										.toString();
								}
								if(data.bookingBean.commodity != null &&
										data.bookingBean.commodity != ''){
								$scope.joborder.commodity = data.bookingBean.commodity;
								}
								
								if(data.bookingBean.branch != null &&
										data.bookingBean.branch != ''){
								$scope.joborder.branch = data.bookingBean.branch.toString();
								}
								if(data.bookingBean.mode != null &&
										data.bookingBean.mode != ''){
								$scope.joborder.mode = data.bookingBean.mode
										.toString();
								}
								if(data.bookingBean.aol != null &&
										data.bookingBean.aol != ''){
								$scope.joborder.aol = data.bookingBean.aol
										.toString();
								}
								if(data.bookingBean.aod != null &&
										data.bookingBean.aod != ''){
								$scope.joborder.aod = data.bookingBean.aod
										.toString();
								}
								if(data.bookingBean.term != null &&
										data.bookingBean.term != ''){
								$scope.joborder.term = data.bookingBean.term
										.toString();
								}
								if(data.bookingBean.origin != null &&
										data.bookingBean.origin != ''){
								$scope.joborder.origin = data.bookingBean.origin
										.toString();
								}
								if(data.bookingBean.destination != null &&
										data.bookingBean.destination != ''){
								$scope.joborder.destination = data.bookingBean.destination
										.toString();
								}
								if(data.bookingBean.customer != null &&
										data.bookingBean.customer != ''){
								$scope.joborder.customer = data.bookingBean.customer
										.toString();
								}
								if(data.bookingBean.shipper != null &&
										data.bookingBean.shipper != ''){
								$scope.joborder.shipper = data.bookingBean.shipper
										.toString();
								}
								if(data.bookingBean.consignee != null &&
										data.bookingBean.consignee != ''){
								$scope.joborder.consignee = data.bookingBean.consignee
										.toString();
								}
								if(data.bookingBean.nominatedBy != null &&
										data.bookingBean.nominatedBy != ''){
									$scope.joborder.nominatedBy = data.bookingBean.nominatedBy
									.toString();
								}
								if(data.bookingBean.vendor != null &&
										data.bookingBean.vendor != ''){
								$scope.joborder.vendor = data.bookingBean.vendor
										.toString();
								}
								if(data.bookingBean.currency != null &&
										data.bookingBean.currency != ''){
								$scope.joborder.currency = data.bookingBean.currency
										.toString();
								}
								if(data.bookingBean.salesType != null &&
										data.bookingBean.salesType != ''){
								$scope.joborder.salesType = data.bookingBean.salesType
										.toString();
								}
								if(data.bookingBean.carrier != null &&
										data.bookingBean.carrier != ''){
								$scope.joborder.carrier = data.bookingBean.carrier
										.toString();
								}
							
								$http
								.post($stateParams.tenantid+ '/app/jobOrderSeaApp/getQuotNo',newValue)
								.success(
										function(data1) {
											var Id=data1.jobId;
											var gateInNo=data1.gateInNo;

											$http
											.post($stateParams.tenantid+ '/app/seaquotation/edit',Id)
											.success(
													function(data2) {
														
								$scope.joborder.joborderDtl=data2.lQuotationBean[0].quotationDtl;
								for (var i = 0; i < $scope.joborder.joborderDtl.length; i++) {
									$scope.joborder.joborderDtl[i].chargeHead = $scope.joborder.joborderDtl[i].chargeHeads
									.toString();
							$scope.joborder.joborderDtl[i].unit = $scope.joborder.joborderDtl[i].unit
									.toString();
							$scope.joborder.joborderDtl[i].currency = $scope.joborder.joborderDtl[i].currency
									.toString();

							

							$scope.joborder.joborderDtl[i].transactionType = $scope.joborder.joborderDtl[i].transactionType
									.toString();
							$scope.joborder.joborderDtl[i].buySellParty = $scope.joborder.joborderDtl[i].buySell
									.toString();
							$scope.joborder.joborderDtl[i].rate = $scope.joborder.joborderDtl[i].rate
									.toString();
							
							if ($scope.joborder.joborderDtl[i].unit
									.toString() == '1') {

								angular
										.forEach(
												data.bookingBean.boxData,
												function(
														value,
														key) {

													if($scope.joborder.joborderDtl[i].conType==null){
														
													} else if ($scope.joborder.joborderDtl[i].conType
													
															.toString() == value.cntrType) {

														$scope.joborder.joborderDtl[i].quantity = value.noOfBox
																.toString();
													}

												})

							} else {

								$scope.joborder.joborderDtl[i].quantity = $scope.joborder.joborderDtl[i].qty
										.toString();

							}

							if ($scope.joborder.joborderDtl[i].quantity == undefined
									|| $scope.joborder.joborderDtl[i].quantity == '') {
								if ($scope.specialEmployeeFlag)
									$scope.joborder.joborderDtl[i].quantity = 0;
								else
									$scope.joborder.joborderDtl[i].quantity = 1;

							}

							$scope.joborder.joborderDtl[i].exRate = '1';
							$scope.joborder.joborderDtl[i].status = '1';
							$scope.joborder.joborderDtl[i].conType = $scope.joborder.joborderDtl[i].conType.toString();
						}
								$http.post($stateParams.tenantid+'/app/seaquotation/getcommodity').success(function(data) { 
						              $scope.commodityList = data.commonUtilityBean;
						           	 $scope.compaccList = [];
						           	 var valArr = $scope.joborder.commodity.split(',');
						           	 var i = 0, size = valArr.length;
						           	 for (i; i < size; i++) {
						           	// $("#port").find("option[label=" + valArr[i] + "]").prop("selected", "selected");
						           	 angular.forEach($scope.commodityList, function(value, key) {
						           	 if (valArr[i] == value.id) {
						           	 $scope.compaccList.push(value);
						           	 }
						           	 });
						           	  
						           	 }
						             $scope.joborder.commodityL = $scope.compaccList;

						           //	$scope.EmployeeMasterData.accessCat = $scope.compaccList;
						           	 $timeout(function() { 
						           		 $("#commodityL").multiselect('destroy');
						           	 $("#commodityL").multiselect({
						           	 maxHeight : 400,
						           	 includeSelectAllOption : true,
						           	 selectAllText : 'Select All',
						           	 enableFiltering : true,
						           	 enableCaseInsensitiveFiltering : true,
						           	 filterPlaceholder : 'Search',
						           	 numberDisplayed: 1,
						           	 });
						           	 }, 3, false);
						           	 $("#multiselect-button").addClass("width_100 input-sm line-height-5");
						           	 
						           	
						           	 
						           	 });
							});
											
								if(md!='5'){			
							$http.get($stateParams.tenantid+ '/api/gateIn/edit1?gateInNo='+ gateInNo+'&bookingNo='+newValue).success(function(result) {

							if(result!=null && result!=undefined){
											
									$scope.joborder.joborderTrackingDtl=result.containerDtl;
												
								for (var i = 0; i < $scope.joborder.joborderTrackingDtl.length; i++) {
									if($scope.joborder.mode!='5'){
					            $scope.joborder.joborderTrackingDtl[i].containerNo = $scope.joborder.joborderTrackingDtl[i].containerNo.toString();
					            $scope.joborder.joborderTrackingDtl[i].sizeType = $scope.joborder.joborderTrackingDtl[i].containerType.toString();
									}else if($scope.joborder.mode=='5'){
										$scope.joborder.joborderTrackingDtl[i].containerNo = '';
					            $scope.joborder.joborderTrackingDtl[i].sizeType = '';
								
									}			
								}
												
												
												}
											
											});	
										}
											
											
										});
									 
								 
							});
				    
						}
						
				    })
					
					

				    $scope.hdrData =  $scope.joborder;
				    $scope.dtlData =  $scope.jobOrderDtl;
				    
				    $scope.reset = function () {
				    	
				    	
				    	if($scope.edit == true){
				    		
				    	}
				    	else{
				    		
				    		$scope.joborder={
									service:'',
									jobDate:'',
									branch:'',
									customer:'',
									shipper:'',
									consignee : '',
									term : '',
									aol:'',
									aod :'',
									origin:'',
									destination:'',
									commodity:'',
									status:'',
									currency:'',
									quotationNo:'',
									quotationnum:'',
									salesType:'',
									salesPerson:'',payerName : '',
									nominatedBy:'',commodityL:'',
									vendor:'',
									carrier:'',
									flightNo:'',
									flightDate:'',
									exRate:'',
									customsBroker:'',
									jbId :'',
									aodName:'',
									aolName:'',
									destinationName :'',
									custName :'' ,
									orgnName :'',
									modeName:'',
									truckship1:'',
									truckship2:'',
								mode :'1',
								buy1: '',
								sell1 :'',
								buy:'',
								sell:'',
									joborderDtl : [{
													joborderDtlId : '',
													mode :'1',
													buy1: '',
													sell1 :'',
													buy:'',
													sell:'',
													chargeHead : '',
													unit : '',
													conType: '',
													transactionType : '1',
													quantity : '',
													rate : '',
													currency :'',
													exRate :'',
													amount : '0',
												
													buySellParty : '',
													status:'',
													amount1 :''
									} ],
									
									joborderTracking : {
										 jobTrackingId : '',
										 jobId : '',
										 totalPcs : '',
										 totalGrosssWeight : '',
									     totalAmount : '',
										 totalNetWeight : '',
									},
									joborderTrackingDtl : [{
										select : '',
										commodity : '',
										descriptionGoods : '',
										uom : '',
										length : '',
										width : '',
										height : '',
										noOfPieces : '',
										netWeight : '',
										grossWeight : '',
										chargeableWeight: '',
										rate: '',
										amount : '',
										remarks : ''
									}]
								}
				    	}
				        
				    };
				    var userid=$('#tempidww').val();
				    $scope.cancel=function(){
						$state.go('app.sea.joborderApp.list',{tenantid:$stateParams.tenantid});
					}
		
/*				    $scope.carrierList = [
					     {id: '1', text: 'SIMA MARINE (INDIA) PRIVATE LIMITED'},
					  ];

*/
				   /* $scope.carrierList = [
						{id: '1', text: 'SIMA MARINE (INDIA) PRIVATE LIMITED'},
					    {id: '2', text: 'TCI SEAWAYS'},
					    {id: '3', text: 'THE SHIPPING CORPORATION OF INDIA LIMITED'},
					    {id: '4', text: 'AVANA LOGISTEK LIMITED'},
					    {id: '5', text: 'CONTAINER CORPORATION OF INDIA LIMITED'}
					  ];*/
				    $http.get($stateParams.tenantid+'/app/commonUtility/getcarrierList').success(function(datas) {
						debugger
					    $scope.carrierList = datas.commonUtilityBean;	    
			            //$scope.transList = datas.lCommonUtilityBean;	    

					}).error(function(data) {

					});
					
					//Approval
					$scope.approve = function() {	
						
				         ngDialog.open({
				             scope : $scope,
				             template : 'views/air/seaQuotation/jobOrderApprovalRemarks',
				             controller : $controller('jobOrderApprovalCtrl', {
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
					
				    
	$scope.validateContainer=function(con,i){
	if(con.length==11){

	}else{
		logger.logError(" Invalid Container Number ");
			$scope.joborder.joborderTrackingDtl[i].containerNo='';

	}
		}				
	
				    $scope.saveBooking = function() {
				    	
						console.log($scope.joborder);
						var msg = $scope.checkValidation();
						if (!$scope.checkundefined(msg)) {
							logger.logError(msg);
						} else {
							if($scope.joborder.joborderDtl.length>0){
								if($scope.joborder.joborderTrackingDtl.length>0){
									var temp=$scope.joborder.remarks1;
									if($scope.joborder.remarks1!=null&&$scope.joborder.remarks1!=""){
									$scope.joborder.remarks1= todate+' '+time+ '     ' +  '     ' +temp  ;
									}
									var commodity='';
						        	angular.forEach($scope.joborder.commodityL, function(item, index) {
					                	if(commodity!=null && commodity!=''){
					                    	commodity=commodity+','+item.id;
				                      }else{
					                    	commodity=item.id;
					                	}
					                	
					                })
					               $scope.joborder.commodity=commodity;
						        	var checkPack=true,checkPack1=true;var i=1,j=1;var msg=''; var checkPackcon=true;
						        	angular.forEach($scope.joborder.joborderTrackingDtl, function(val, index) {
						        	if(val.containerNo==undefined || val.containerNo==null ||     val.containerNo==''){
						        		checkPackcon=false;
										msg=msg+" Row "+i+" containerNo is Required! ";
							        	}
						        	if(val.sizeType==undefined || val.sizeType==null ||     val.sizeType==''){
						        		checkPackcon=false;
										msg=msg+" Row "+i+" container size Type is Required! ";
							        	}
						        	if(val.cargoDescription==undefined || val.cargoDescription==null ||     val.cargoDescription==''){
						        		checkPackcon=false;
										msg=msg+" Row "+i+" Cargo Description is Required! ";
							        	}
						        	i++;
						        	
								})
								



angular.forEach($scope.joborder.joborderDtl, function(val, index) {
						        	if(val.quantity==undefined || val.quantity==null ||  val.quantity=='' ||  val.quantity=='0' ){
						        		checkPack1=false;
									msg=msg+" Row "+j+" Quantity is Required! ";
									j++;
						        	}
								})
						
								if(checkPack==true && checkPack1==true && checkPackcon==true){
									$http.post($stateParams.tenantid + '/app/jobOrderSeaApp/ckeckConCount', $scope.joborder).success(function(datas) {
										if(datas.succ==true){
									if($scope.joborder.mode!='5'){
									
                                     $http.post($stateParams.tenantid + '/app/jobOrderSeaApp/save', $scope.joborder).success(function(datas) {
								
								if (datas.success == true) {
									logger.logSuccess(datas.message);
									
									$location.url($stateParams.tenantid
											+ '/jobOrderSeaApp/edit?rowid=' + datas.jobHdrId);
									if ($scope.createQuote) {
									} else {
									}

								} else {
									logger.logError(datas.message);
								}
							}).error(function(data) {
								logger.logError("Please try again");
							});
									}else{
									

											
		                                     $http.post($stateParams.tenantid + '/app/jobOrderSeaApp/save', $scope.joborder).success(function(datas) {
										
										if (datas.success == true) {
											logger.logSuccess(datas.message);
											
											$location.url($stateParams.tenantid
													+ '/jobOrderSeaApp/edit?rowid=' + datas.jobHdrId);
											if ($scope.createQuote) {
											} else {
											}

										} else {
											logger.logError(datas.message);
										}
									}).error(function(data) {
										logger.logError("Please try again");
									});
											
										
									}
										}else{
											$scope.allow($scope.joborder);
										}
										})}else{
									logger.logError(msg);
								} 
								
								}else{
									logger.logError("Atleast One Row Required in Cargo Details");
								}
							}
							else{
								logger.logError("Atleast One Row Required");
							}
						}

					}
		

				});


app
.controller(
		'joborderViewCtrlNew',
		function($scope, $timeout, $stateParams, sharedProperties,
				toaster, $filter, $rootScope, $http, $location, logger,
				$state, ngDialog, $controller, $injector,$window) {
			$scope.quotationTypeList = [];
			$scope.customerDropList = [];
			$scope.consigneeDropList  = [];
			$scope.shipperDropList  = [];
			$scope.nominatedDropList  = [];
			$scope.vendorDropList = [];
			$scope.serviceParnrDropList = [];
			$scope.portList = [];
			$scope.quotationList = [];
			$scope.uomList=[];
			$scope.currencyList = [];
			$scope.createQuote = false;
//			$scope.defaultCurrency = 0;
//			$scope.fromCurrency=0;
//			$scope.toCurrency=0;
;
var userid=$('#tempidww').val();
			var jobId =   parseInt($location.search().rowid) ;
			
			/*$scope.joborder={
					jobId : '',
					mode:'',
					service:'',
					jobDate:'',
					branch:'',
					customer:'',
					shipper:'',
					consignee : '',
					term : '',
					aol:'',
					aod :'',
					origin:'',
					destination:'',
					commodity:'',
					status:'',
					currency:'',
					quotationNo:'',
					salesType:'',
					salesPerson:'',
					nominatedBy:'',
					vendor:'',
					carrier:'',
					vessel:'',
					flightDate:'',
					exRate:'',
					customsBroker:'',
						modeName:'',
							jbName:'',
							partyName:'',
							pkg:'',
							gross:'',
							net:'',
							vessel:'',
							container:'',
							pickUp:'',
							carting:'',
							remarks:'',
							agent:'',
							eta:'',
							nomination:'',
							exrate:'',
							pol:'',
							pod:'',
							pickupDate:'',
							stuffingDate:'',
							createdDt:'',
							sailingDate:'',
							customsCompletionsDate:'',
							etaDestinationDate:'',
							salesDate:'',
							purchaseInvoice:''
			
			
			$scope.jobOrderDtl = [{
					joborderDtlId : '',
					chargeHead : '',
					unit : '',
					transactionType : '',
					quantity : '',
					rate : '',
					currency :'',
					exRate :'',
					amount : '0',
					paymentMode: '',
					buySellParty : '',
					Status:'',
						amount1 :''
			}], 
			joborderTracking : {
				 jobTrackingId : '',
				 jobId : '',
				 totalPcs : '',
				 totalGrosssWeight : '',
			     totalAmount : '',
				 totalNetWeight : '',
			},
			joborderTrackingDtl : [{
				select : '',
				commodity : '',
				descriptionGoods : '',
				uom : '',
				length : '',
				width : '',
				height : '',
				noOfPieces : '',
				netWeight : '',
				grossWeight : '',
				chargeableWeight: '',
				rate: '',
				amount : '',
				remarks : ''
			}]
			}*/	
			
			
			$scope.joborder = {
					jobId : '',
					mode:'',
					service:'',
					jobDate:'',
					branch:'',
					customer:'',
					shipper:'',
					consignee : '',
					term : '',
					aol:'',
					aod :'',
					origin:'',
					destination:'',
					commodity:'',
					status:'',
					currency:'',
					quotationNo:'',
					quotationnum:'',
					salesType:'',
					salesPerson:'',payerName : '',
					nominatedBy:'',
					vendor:'',
					carrier:'',
					vessel:'',
					flightDate:'',
					exRate:'',commodityL:'',
					customsBroker:'',
						modeName:'',
							jbName:'',
							partyName:'',
							pkg:'',
							gross:'',
							net:'',
							vessel:'',
							container:'',
							pickUp:'',
							carting:'',
							remarks:'',
							agent:'',
							eta:'',
							nomination:'',
							exrate:'',
							pol:'',
							pod:'',
							pickupDate:'',
							stuffingDate:'',
							createdDt:'',
							sailingDate:'',
							customsCompletionsDate:'',
							etaDestinationDate:'',
							salesDate:'',
							remarks1:'',
							searemarks:'',
							purchaseInvoice:'',
							modeName   : '',
							serviceName :'',
							branchName  :'',
							nominatedByName  :'',
							shipperName  :'',
							consigneeName :'',
							salesPersonName :'',
							salesTypeName :'',
							vendorName :'',
							jobStatusName  :'',
							sellingCurrencyName  :'',
							buyingCurrencyName :'',
							totalCurrencyName :'',
							customsBrokerName :'',
							currencyName : '',
							aolName : '',
							aodName : '',
							destinationName : '',
							originName : '',
					joborderDtl : [ {
						joborderDtlId : '',
						chargeHead : '',
						unit : '',
						conType: '',
						transactionType : '1',
						quantity : '',
						rate : '',
						currency :'',
						exRate :'',
						amount : '0',
					
						buySellParty : '',
						Status:'',
							amount1 :'',
							color : '',
							chargeHeadName : '',
							unitName : '',
							currencyName : '',
						
							transactionTypeName : '',
							buySellPartyName : '',
							statusName : ''
					} ],
					joborderTracking : {
						jobTrackingId : '',
						 jobId : '',
						 totalPcs : '',
						 totalGrosssWeight : '',
					     totalAmount : '',
						 totalNetWeight : '',
					},
					joborderTrackingDtl : [{
						
						select : '',
						containerNo : '',
						sizeType : '',
						sizeTypeName : '',
						cargoDescription : '',
						noOfPackage : '0',
						uom : '',
						netWeight : '0',
						grossWeight : '0',
						measurement : '0',
						remarks : ''
					}]
				}
			
			

				
			
			$scope.printRoutingOrder = function(){
		        
		        var url = $stateParams.tenantid+'/app/jobOrderSeaApp/printRoutingOrder?jobId=' + jobId;
		        var wnd = $window.open(url, 'ATHENA', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
		        wnd.print();   
		     }
			$scope.viewQuotation = function(quotationNo) {
				
					$location.url($stateParams.tenantid+'/seaQuotation/view?QuotHdId='+quotationNo);
				
			}
			
			
			
			$scope.$watch('joborder.jobStatus', function(newValue,
					oldValue) {
				if (newValue != '' && newValue != undefined) {
					/*if(newValue==2)
						{
						$scope.Add=false;
						$scope.disable=true;
						}else{
							$scope.Add=true;
							$scope.disable=false;
						}*/
					if(newValue==2 && (userid == 'A0001' || userid == 'E0003'))
					{
					$scope.Add=false;
					$scope.disable=true;
					
					$scope.unique = true;
					}else if(newValue==2 && userid != 'A0001' && userid != 'E0003')
					{
						$scope.Add=false;
						$scope.disable=true;
						
						$scope.unique = false;
						}else{
						$scope.Add=true;
						$scope.disable=false;
					}
				}
				
			});
			
			
			$scope.prtShpprName=''
				$scope.prtShpprAddress='';
				$scope.prtConsignName=''
				$scope.prtPrtOfLoading=''
			    $scope.prtTotlPices='';
				$scope.prtTotlNetWt=''
				$scope.prtTotlGrsWt=''
				$scope.prtcommdty=''
				$scope.prtTems=''
				$scope.prtremarks='';
				
				
				$scope.printUpdatesRouting=function(){
					
					

					angular.forEach($scope.shipperDropList, function(value, key) {
						if($scope.joborder.shipper==value.id)
							$scope.prtShpprName=value.text;
					})
					if($scope.joborder.shpprAddrss1!=null){
						$scope.prtShpprAddress=$scope.joborder.shpprAddrss1;
					}
					if($scope.joborder.shpprAddrss2!=null){
						$scope.prtShpprAddress=$scope.prtShpprAddress+$scope.joborder.shpprAddrss2;
					}
					if($scope.joborder.shpprAddrss3!=null){
						$scope.prtShpprAddress=$scope.prtShpprAddress+$scope.joborder.shpprAddrss3;
					}
					if($scope.joborder.shpprAddrss4!=null){
						$scope.prtShpprAddress=$scope.prtShpprAddress+$scope.joborder.shpprAddrss4;
					}
					
					angular.forEach($scope.consigneeDropList, function(value, key) {
						if($scope.joborder.consignee==value.id)
							$scope.prtConsignName=value.text;
					})
					
					angular.forEach($scope.portList, function(value, key) {
						if($scope.joborder.aol==value.id)
							$scope.prtPrtOfLoading=value.text;
					})
					
					angular.forEach($scope.TermList, function(value, key) {
						if($scope.joborder.term==value.id)
							$scope.prtTems=value.text;
					})
					
					angular.forEach($scope.portList, function(value, key) {
						if($scope.joborder.aod==value.id)
							$scope.prtPrtOfDischrg=value.text;
					})
					
					$scope.prtTotlPices =$scope.joborder.joborderTracking.totalPcs
					$scope.prtTotlNetWt=$scope.joborder.joborderTracking.totalNetWeight
					$scope.prtTotlGrsWt=$scope.joborder.joborderTracking.totalGrosssWeight
					$scope.prtcommdty=$scope.joborder.commodity;
					$scope.prtremarks=$scope.joborder.remarks1
					
					//$scope.prtShpprAddress=$scope.joborder.shpprAddrss1+" "+$scope.joborder.shpprAddrss2+" "+$scope.joborder.shpprAddrss3+" "+$scope.joborder.shpprAddrss4==null?"":$scope.joborder.shpprAddrss4;

				      
				
					
				}
			
			$scope.printRoutingOrder1 = function(){
				/*var printVar=false;
				// This empty methhod to update values from js to jsp
				//SEA
				$http.post($stateParams.tenantid+ '/app/jobOrderAir/updateValues').success(
						function(data) {
							$scope.printUpdatesRouting();
				})*/
			    
				var printContents = document.getElementById('printableContent').innerHTML;
			  	  var popupWin = window.open('', '_blank', 'height=700,width=850,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
			  	  popupWin.document.open();
			  	  popupWin.document.write('<html><head><link rel="stylesheet" type="text/css" href="style.css" />'+
			  			  '<style>table{font-size:12px;}body{font-family: "Open Sans";}table, th, td {border: 1px solid black;border-collapse: collapse;}'+
			  			  'table>thead>tr>th{background-color:#34b7e8;}</style>'+
			  			  '</head><body onload="window.print()">' + printContents + '</body></html>');
			  	  popupWin.document.close();
				
			}
			 var defaultCurrency = '';
			 var  fromCurrency='';
			 var toCurrency='';
			 
				 
				

			
			$scope.JobSheet = function(){
		        
		        var url = $stateParams.tenantid+'/app/jobOrderSeaApp/jobDetailOrder?jobId=' + jobId;
		        var wnd = $window.open(url, 'ATHENA', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
		        wnd.print();   
		     }
			$scope.printPrealertSea= function(jobId){
		        
		        var url = $stateParams.tenantid+'/app/jobOrderSeaApp/printPreAlert?jobId=' + jobId;
		        var wnd = $window.open(url, 'ATHENA', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
		        wnd.print();   
		     }
			
			
			$scope.joborder.jobId=jobId;
			$scope.checkundefined = function(value) {
				var invalid = false;
				if (value == undefined || value == 'undefined'
						|| value == null || value == 'null'
						|| value == '') {
					invalid = true;
				}
				return invalid;

			}
			$scope.salesTypeList=[];
			/*$scope.getSalesType = function() {
			    var  data = {};
			    data["id"] = "1";
			    data["text"] = "CROSS TRADE";
			    $scope.salesTypeList.push(data);
			    data = {};
			    data["id"] = "2";
			    data["text"] = "LOCAL";
			    $scope.salesTypeList.push(data);  
			    data = {};
			    data["id"] = "3";
			    data["text"] = "NOMINATED";
			    $scope.salesTypeList.push(data);  
			    
			  
			}
			$scope.getSalesType();*/
			 $scope.transactionTypeList=[];
			
		/*	$scope.getTransactionType = function() {
			    var  data = {};
			    data["id"] = "1";
			    data["text"] = "BUY";
			    $scope.transactionTypeList.push(data);
			    data = {};
			    data["id"] = "2";
			    data["text"] = "SELL";
			    $scope.transactionTypeList.push(data);  
			    
			}
			$scope.getTransactionType();
*/					
			
			$scope.changecolor = function(id) {
				$('#' + id + ' .selectivityId').find('input').css(
						"border-color", "red");
				;

			}
			$scope.clearcolor = function(id) {
				$('#' + id + ' .selectivityId').find('input').css(
						"border-color", "#e8dddd");
				;

			}
			

			$scope.doubleshowTable = function(wtIndex, trIndex) {

				var n = $("#handsondiv" + trIndex + wtIndex).css(
						"display");

				if (n == 'none') {
					$("#handsondiv" + trIndex + wtIndex).css("display",
							"block");
					$scope.addindex = trIndex + "" + wtIndex;
				} else if (n == 'block') {
					$("#handsondiv" + trIndex + wtIndex).css("display",
							"none");

				}

			}
			
			$scope.addRow = function() {
					var jobOrderDtl = {
						joborderDtlId : '',
						chargeHead : '',
						unit : '',
						conType: '',
						transactionType : '1',
						quantity : '',
						rate : '',
						currency :'',
						exRate :'1',
						amount : '0',
						amount1 :'',					
						buySellParty : '',
						status:'1'
				} 
					$scope.joborder.joborderDtl.push(jobOrderDtl);
			};
			
			$scope.deleteIds = [];
				$scope.removeRow = function() {
					var len = $scope.joborder.joborderDtl.length;
					for (var index = len - 1; index < len; index--) {
						if ($scope.joborder.joborderDtl[index].select == true) {
							if ($scope.joborder.joborderDtl[index].jobDtlId != null
									&& $scope.joborder.joborderDtl[index].jobDtlId > 0) {
								$scope.deleteIds
										.push($scope.joborder.joborderDtl[index].jobDtlId);
							}
							$scope.joborder.joborderDtl.splice(index, 1);
						}
					}
			};
			$scope.addRowTracking = function() {
				var jobOrderTrackingDtl = {
						select : '',
						containerNo : '',
						sizeType : '',
						cargoDescription : '',
						noOfPackage : '0',
						uom : '',
						netWeight : '0',
						grossWeight : '0',
						measurement : '0',
						remarks : ''
				}
				$scope.joborder.joborderTrackingDtl.push(jobOrderTrackingDtl);
			};
			
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

			 var todate = dd + '/' + mm + '/' + yyyy;
			 
			 var time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
			 
			$scope.removeRowTracking = function() {
				var len = $scope.joborder.joborderTrackingDtl.length;
				for (var index = len - 1; index < len; index--) {
					if ($scope.joborder.joborderTrackingDtl[index].select == true) {
						
						$scope.joborder.joborderTrackingDtl.splice(index, 1);
					}
				}
			};
			

		    $scope.hdrData =  $scope.joborder;
		    $scope.dtlData =  $scope.jobOrderDtl;
		    $scope.reset = function () {
		    	
		    	

		    	if($scope.edit == true){
		    		
		    		$scope.getEdit();
		    	}
		    	else{
		    		
		    		$scope.joborder = $scope.hdrData;
			        $scope.jobOrderDtl = $scope.dtlData;
		    	}
		       
		    };
		    
		    $scope.$watch('joborder.joborderDtl1[trIndex].noOfPackage', function(newValue, oldValue) {
		    	var noOfPcs=0;
				for (var i = 0; i <= $scope.joborder.joborderTrackingDtl.length; i++) {
					if($scope.joborder.joborderTrackingDtl[i].noOfPackage==""){
						$scope.joborder.joborderTrackingDtl[i].noOfPackage=0;
						noOfPcs=parseInt($scope.joborder.joborderTrackingDtl[i].noOfPackage)+noOfPcs;
						$scope.joborder.joborderTracking.totalPcs=noOfPcs;
					}
					else{
						noOfPcs=parseInt($scope.joborder.joborderTrackingDtl[i].noOfPackage)+noOfPcs;
						$scope.joborder.joborderTracking.totalPcs=noOfPcs;
					}
					
					
				}
				
		    })
		   
			
 			
			
 			
			$scope.noOfPcs = function() {
				var noOfPcs=0;
				for (var i = 0; i <= $scope.joborder.joborderTrackingDtl.length; i++) {
					if($scope.joborder.joborderTrackingDtl[i].noOfPackage==""){
						$scope.joborder.joborderTrackingDtl[i].noOfPackage=0;
						noOfPcs=parseInt($scope.joborder.joborderTrackingDtl[i].noOfPackage)+noOfPcs;
						$scope.joborder.joborderTracking.totalPcs=noOfPcs;
					}
					else{
						noOfPcs=parseInt($scope.joborder.joborderTrackingDtl[i].noOfPackage)+noOfPcs;
						$scope.joborder.joborderTracking.totalPcs=noOfPcs;
					}
					
					
				}
			}
			$scope.noOfNet = function() {
				var noOfNet=0.0;
				for (var i = 0; i <= $scope.joborder.joborderTrackingDtl.length; i++) {
					if($scope.joborder.joborderTrackingDtl[i].netWeight==""){
						$scope.joborder.joborderTrackingDtl[i].netWeight=0.0;
						noOfNet=parseFloat($scope.joborder.joborderTrackingDtl[i].netWeight)+noOfNet;
						$scope.joborder.joborderTracking.totalNetWeight=noOfNet;
					}
					else{
						noOfNet=parseFloat($scope.joborder.joborderTrackingDtl[i].netWeight)+noOfNet;
						$scope.joborder.joborderTracking.totalNetWeight=noOfNet;
					}
					
					
				}
			}
			
			  
			$scope.noOfGross = function() {
				var noOfGross=0.0;
				for (var i = 0; i <= $scope.joborder.joborderTrackingDtl.length-1; i++) {
					if($scope.joborder.joborderTrackingDtl[i].grossWeight==""){
						$scope.joborder.joborderTrackingDtl[i].grossWeight=0.0;
						noOfGross=parseFloat($scope.joborder.joborderTrackingDtl[i].grossWeight)+noOfGross;
						$scope.joborder.joborderTracking.totalGrosssWeight=noOfGross;
					}
					else{
						noOfGross=parseFloat($scope.joborder.joborderTrackingDtl[i].grossWeight)+noOfGross;
						$scope.joborder.joborderTracking.totalGrosssWeight=noOfGross;
					}
					
					
				}
				
			
				
			}
			
			
			
			$scope.edit = false;
			
			
			$scope.getEdit = function () {
				
			
			if (jobId != '' && jobId != undefined) {
				$scope.edit = true;
				

			$http.post($stateParams.tenantid + '/app/jobOrderSeaApp/viewsea',
					jobId)
			.success(
					function(data) {
						
						
						
						$scope.joborder = data.lJobOrderBean[0];
						if(data.lJobOrderBean[0].commodity != null && data.lJobOrderBean[0].commodity != ''){
							$scope.joborder.commodity = data.lJobOrderBean[0].commodity.toString();
						}
						if(data.lJobOrderBean[0].mode != null && data.lJobOrderBean[0].mode != ''){
							 
						    if(data.lJobOrderBean[0].mode==1){
								$scope.joborder.modeName = "SEA COASTAL";
					    }else  if(data.lJobOrderBean[0].mode==2){
								$scope.joborder.modeName = "SEA FOREIGN";
					    }else  if(data.lJobOrderBean[0].mode==3){
								$scope.joborder.modeName = "TRUCK";
					    }else  if(data.lJobOrderBean[0].mode==4){
								$scope.joborder.modeName = "LINER";
					    }else  if(data.lJobOrderBean[0].mode==5){
								$scope.joborder.modeName = "FORWARDING";
					    }
					}
						$scope.joborderTracking = data.lJobOrderBean[0].joborderTracking;
						
						/*if(data.lJobOrderBean[0].service!='' && data.lJobOrderBean[0].service!=null){
							$scope.joborder.service = data.lJobOrderBean[0].service.toString();
							}
							if(data.lJobOrderBean[0].remarks1!='' && data.lJobOrderBean[0].remarks1!=null){
							$scope.joborder.searemarks = data.lJobOrderBean[0].remarks1.toString();
							}
							$scope.joborder.remarks1='';
							if(data.lJobOrderBean[0].branch!=''&& data.lJobOrderBean[0].branch!=null)
								{
							$scope.joborder.branch = data.lJobOrderBean[0].branch.toString();
								}
							//if(data.lJobOrderBean[0].mode!=''=data.lJobOrderBean[0].mode!=null)
							//{
								$scope.joborder.mode = data.lJobOrderBean[0].mode;
							//}
						$scope.joborder.jobDate=data.lJobOrderBean[0].jobDate;
						if(data.lJobOrderBean[0].aol!=''&&data.lJobOrderBean[0].aol!=null)
							{
						$scope.joborder.aol = data.lJobOrderBean[0].aol
								.toString();
							}
						if(data.lJobOrderBean[0].aod!=''&&data.lJobOrderBean[0].aod!=null)
							{
						$scope.joborder.aod = data.lJobOrderBean[0].aod
								.toString();
							}
						if(data.lJobOrderBean[0].term!=''&&data.lJobOrderBean[0].term!=null)
							{
						$scope.joborder.term = data.lJobOrderBean[0].term
								.toString();
							}
						if(data.lJobOrderBean[0].origin!=''&&data.lJobOrderBean[0].origin!=null)
							{
						$scope.joborder.origin = data.lJobOrderBean[0].origin
								.toString();
							}
						if(data.lJobOrderBean[0].destination!=''&&data.lJobOrderBean[0].destination!=null)
							{
						$scope.joborder.destination = data.lJobOrderBean[0].destination
								.toString();
							}
						if(data.lJobOrderBean[0].customer!=''&&data.lJobOrderBean[0].customer!=null)
							{
						$scope.joborder.customer = data.lJobOrderBean[0].customer
								.toString();
							}
						if(data.lJobOrderBean[0].shipper!=''&&data.lJobOrderBean[0].shipper!=null)
							{
						$scope.joborder.shipper = data.lJobOrderBean[0].shipper
								.toString();
							}
						if (data.lJobOrderBean[0].nominatedBy != null
								&& data.lJobOrderBean[0].nominatedBy != '') {
						$scope.joborder.nominatedBy = data.lJobOrderBean[0].nominatedBy
								.toString();
						}
						if(data.lJobOrderBean[0].currency!=''&&data.lJobOrderBean[0].currency!=null)
							{
						$scope.joborder.currency = data.lJobOrderBean[0].currency
								.toString();
							}
						if(data.lJobOrderBean[0].quotationnum!=''&&data.lJobOrderBean[0].quotationnum!=null)
							{
						$scope.joborder.quotationnum = data.lJobOrderBean[0].quotationnum
						.toString();
							}
						if(data.lJobOrderBean[0].mode.toString()!=''&&data.lJobOrderBean[0].mode.toString()!=null)
							{
						$scope.joborder.mode = data.lJobOrderBean[0].mode.toString();
							}
						if(data.lJobOrderBean[0].salesType!=''&&data.lJobOrderBean[0].salesType!=null)
							{
						$scope.joborder.salesType = data.lJobOrderBean[0].salesType
								.toString();
							}
						if(data.lJobOrderBean[0].vessel!=''&&data.lJobOrderBean[0].vessel!=null)
							{
						$scope.joborder.vessel = data.lJobOrderBean[0].vessel
						.toString();
							}
						if(data.lJobOrderBean[0].consignee!=''&&data.lJobOrderBean[0].consignee!=null)
							{
						$scope.joborder.consignee = data.lJobOrderBean[0].consignee
						.toString();
							}
						if(data.lJobOrderBean[0].vendor!=''&&data.lJobOrderBean[0].vendor!=null)
							{
						$scope.joborder.vendor = data.lJobOrderBean[0].vendor
						.toString();
							}
						if (data.lJobOrderBean[0].customsBroker != null
								&& data.lJobOrderBean[0].customsBroker != '') {
						$scope.joborder.customsBroker = data.lJobOrderBean[0].customsBroker
						.toString();
						}
*/						
                        /*$scope.joborder.pickupDate = data.lJobOrderBean[0].pickupDate
						.toString();
						$scope.joborder.stuffingDate = data.lJobOrderBean[0].stuffingDate
						.toString();
						$scope.joborder.createdDt = data.lJobOrderBean[0].createdDt
						.toString();
						$scope.joborder.sailingDate = data.lJobOrderBean[0].sailingDate
						.toString();
						$scope.joborder.customsCompletionsDate = data.lJobOrderBean[0].customsCompletionsDate
						.toString();
						$scope.joborder.etaDestinationDate = data.lJobOrderBean[0].etaDestinationDate
						.toString();
						$scope.joborder.salesInvoice = data.lJobOrderBean[0].salesInvoice
						.toString();
						$scope.joborder.salesDate = data.lJobOrderBean[0].salesDate
						.toString();
						$scope.joborder.purchaseInvoice = data.lJobOrderBean[0].purchaseInvoice
						.toString();
						$scope.joborder.purchaseDate = data.lJobOrderBean[0].purchaseDate
						.toString();*/
						
						for (var i = 0; i < $scope.joborder.joborderDtl.length; i++) {
					
							$scope.joborder.joborderDtl[i]  = $scope.joborder.joborderDtl[i];

						}

						var buy1 =0;
						var sell=0;
						var sell1 =0;
						var amount =0;

						var total =0; 
				    	if($scope.joborder.joborderDtl.length != null ||$scope.joborder.joborderDtl.length != undefined ||$scope.joborder.joborderDtl.length != "" ||$scope.joborder.joborderDtl.length != ''){
{
	for( var i=0;i<=$scope.joborder.joborderDtl.length-1;i++)
{
		

		var amount1=[];
		var amount=[];
		if(($scope.joborder.joborderDtl[i].transactionType != null ) || ($scope.joborder.joborderDtl[i].transactionType != undefined ) ||($scope.joborder.joborderDtl[i].transactionType != "" ) ||($scope.joborder.joborderDtl[i].transactionType != '' ))
         {
			if($scope.joborder.joborderDtl[i].transactionType =="1")
              {
				
				if(($scope.joborder.joborderDtl[i].quantity  != null || $scope.joborder.joborderDtl[i].quantity != undefined ||$scope.joborder.joborderDtl[i].quantity !="" ||$scope.joborder.joborderDtl[i].quantity != '') &&  ($scope.joborder.joborderDtl[i].rate  != null || $scope.joborder.joborderDtl[i].rate != undefined ||$scope.joborder.joborderDtl[i].rate != " " ||$scope.joborder.joborderDtl[i].rate != '') && ($scope.joborder.joborderDtl[i].exRate  != null || $scope.joborder.joborderDtl[i].exRate == undefined ||$scope.joborder.joborderDtl[i].exRate !="" ||$scope.joborder.joborderDtl[i].exRate != '') )
				{
				amount1[i] = (parseFloat(($scope.joborder.joborderDtl[i].quantity)) * parseFloat(($scope.joborder.joborderDtl[i].rate))*parseFloat(($scope.joborder.joborderDtl[i].exRate)));
				$scope.joborder.joborderDtl[i].amount=parseFloat(amount1[i]);

				
			
				buy1=parseFloat(buy1)+parseFloat($scope.joborder.joborderDtl[i].amount);
				console.log("i:"+i+" buy1:"+buy1);
				
				}
              }	
			
			else {
				if($scope.joborder.joborderDtl[i].transactionType =="2")
				{
								
								if(($scope.joborder.joborderDtl[i].quantity  != null || $scope.joborder.joborderDtl[i].quantity != undefined ||$scope.joborder.joborderDtl[i].quantity !="" ||$scope.joborder.joborderDtl[i].quantity != '') &&  ($scope.joborder.joborderDtl[i].rate  != null || $scope.joborder.joborderDtl[i].rate != undefined ||$scope.joborder.joborderDtl[i].rate != " " ||$scope.joborder.joborderDtl[i].rate != '') && ($scope.joborder.joborderDtl[i].exRate  != null || $scope.joborder.joborderDtl[i].exRate == undefined ||$scope.joborder.joborderDtl[i].exRate !="" ||$scope.joborder.joborderDtl[i].exRate != '') )
								{
								amount1[i] = (parseFloat(($scope.joborder.joborderDtl[i].quantity)) * parseFloat(($scope.joborder.joborderDtl[i].rate))*parseFloat(($scope.joborder.joborderDtl[i].exRate)));
								$scope.joborder.joborderDtl[i].amount=parseFloat(amount1[i]);

								sell1=parseFloat(sell1)+parseFloat($scope.joborder.joborderDtl[i].amount);
								console.log("i:"+i+" sell1:"+sell1);
								}
				}	
			}
			
			
			

}

		$scope.joborder.joborderDtl[i].amount=parseFloat(amount1[i]).toFixed(2);
		
	
}
	total =parseFloat(sell1)-parseFloat(buy1);
	
	console.log("total"+total+" sell1:"+sell1);	
	
	
	}
				    	}
				    	$scope.joborder.sell1=sell1.toFixed(2);
						$scope.joborder.buy1=buy1.toFixed(2);
						$scope.joborder.total=total.toFixed(2);
						
					
						$scope.joborder.jobId=jobId;
						$scope.joborder.joborderTracking = data.lJobOrderBean[0].joborderTracking;
						$scope.joborder.joborderTrackingDtl = data.lJobOrderBean[0].joborderTrackingDtl;
						for (var i = 0; i < $scope.joborder.joborderTrackingDtl.length; i++) {
						$scope.joborder.joborderTrackingDtl[i]  = $scope.joborder.joborderTrackingDtl[i];
						//$scope.joborder.joborderTrackingDtl[i].uom = $scope.joborder.joborderTrackingDtl[i].uom.toString();
						}
					});
			
		 
			}
			}
			$scope.getEdit();
			
			if($scope.edit == true){
			$scope.ratevalues= function(){
				var buy1 =0;
				var sell=0;
				var sell1 =0;
				var amount =0;

				var total =0; 
		    	if($scope.joborder.joborderDtl.length != null ||$scope.joborder.joborderDtl.length != undefined ||$scope.joborder.joborderDtl.length != "" ||$scope.joborder.joborderDtl.length != ''){
{
for( var i=0;i<=$scope.joborder.joborderDtl.length-1;i++)
{


var amount1=[];
var amount=[];
if(($scope.joborder.joborderDtl[i].transactionType != null ) || ($scope.joborder.joborderDtl[i].transactionType != undefined ) ||($scope.joborder.joborderDtl[i].transactionType != "" ) ||($scope.joborder.joborderDtl[i].transactionType != '' ))
{
	if($scope.joborder.joborderDtl[i].transactionType =="1")
{
		
		if(($scope.joborder.joborderDtl[i].quantity  != null || $scope.joborder.joborderDtl[i].quantity != undefined ||$scope.joborder.joborderDtl[i].quantity !="" ||$scope.joborder.joborderDtl[i].quantity != '') &&  ($scope.joborder.joborderDtl[i].rate  != null || $scope.joborder.joborderDtl[i].rate != undefined ||$scope.joborder.joborderDtl[i].rate != " " ||$scope.joborder.joborderDtl[i].rate != '') && ($scope.joborder.joborderDtl[i].exRate  != null || $scope.joborder.joborderDtl[i].exRate == undefined ||$scope.joborder.joborderDtl[i].exRate !="" ||$scope.joborder.joborderDtl[i].exRate != '') )
		{
		amount1[i] = (parseFloat(($scope.joborder.joborderDtl[i].quantity)) * parseFloat(($scope.joborder.joborderDtl[i].rate))*parseFloat(($scope.joborder.joborderDtl[i].exRate)));
		$scope.joborder.joborderDtl[i].amount=parseInt(amount1[i]);

		
	
		buy1=parseFloat(buy1)+parseFloat($scope.joborder.joborderDtl[i].amount);
		console.log("i:"+i+" buy1:"+buy1);
		
		}
}	
	
	else {
		if($scope.joborder.joborderDtl[i].transactionType =="2")
		{
						
						if(($scope.joborder.joborderDtl[i].quantity  != null || $scope.joborder.joborderDtl[i].quantity != undefined ||$scope.joborder.joborderDtl[i].quantity !="" ||$scope.joborder.joborderDtl[i].quantity != '') &&  ($scope.joborder.joborderDtl[i].rate  != null || $scope.joborder.joborderDtl[i].rate != undefined ||$scope.joborder.joborderDtl[i].rate != " " ||$scope.joborder.joborderDtl[i].rate != '') && ($scope.joborder.joborderDtl[i].exRate  != null || $scope.joborder.joborderDtl[i].exRate == undefined ||$scope.joborder.joborderDtl[i].exRate !="" ||$scope.joborder.joborderDtl[i].exRate != '') )
						{
						amount1[i] = (parseFloat(($scope.joborder.joborderDtl[i].quantity)) * parseFloat(($scope.joborder.joborderDtl[i].rate))*parseFloat(($scope.joborder.joborderDtl[i].exRate)));
						$scope.joborder.joborderDtl[i].amount=parseFloat(amount1[i]);

						sell1=parseFloat(sell1)+parseFloat($scope.joborder.joborderDtl[i].amount);
						console.log("i:"+i+" sell1:"+sell1);
						}
		}	
	}
	
	
	

}

$scope.joborder.joborderDtl[i].amount=parseFloat(amount1[i]).toFixed(2);


}
total =parseFloat(sell1)-parseFloat(buy1);

console.log("total"+total+" sell1:"+sell1);	


}
		    	}
		    	$scope.joborder.sell1=sell1.toFixed(2);
				$scope.joborder.buy1=buy1.toFixed(2);
				$scope.joborder.total=total.toFixed(2);
				
			}
		}
			if($scope.edit == true){
			$scope.submitupdate = function() {
				$scope.invoice = false;
				$scope.pending = false;
				
				for(var i=0;i<=$scope.joborder.joborderDtl.length-1;i++)
					{
					if($scope.joborder.joborderDtl[i].status == "2" )
						{
						$scope.invoice = true;
						}else{
							$scope.pending = true;
						}
					}
				console.log($scope.pending);
				console.log($scope.joborder);
				var msg = $scope.checkValidation();
				if (!$scope.checkundefined(msg)) {
					logger.logError(msg);
				} else {
					if($scope.joborder.joborderDtl.length>0){
						if($scope.Add == true){
							if($scope.joborder.joborderTrackingDtl.length>0){
								
								
								var temp=$scope.joborder.searemarks;
								
								if(temp!=null){
									 var localValue=temp+'\n '+todate+' '+time  ;
								}else{
									var localValue ="";
								}
								if($scope.joborder.remarks1!=null&&$scope.joborder.remarks1!=""){
									$scope.joborder.remarks1=localValue +  $scope.joborder.remarks1;
								}
							$scope.joborder.deleteIds	=$scope.deleteIds;
								
						 
							}else{
								logger.logError("Atleast One Row Required in Cargo Details");
							}
						}
						else if($scope.pending == false && $scope.Add==false)
							{

							if($scope.joborder.joborderTrackingDtl.length>0){
								
								
								var temp=$scope.joborder.searemarks;
								if($scope.joborder.remarks1!=null&&$scope.joborder.remarks1!=""){
								$scope.joborder.remarks1=temp+'\n '+todate+' '+time+ '     ' +  '     ' +$scope.joborder.remarks1;
								}
								
					 
							}else{
								logger.logError("Atleast One Row Required in Cargo Details");
							}
						
							}
						else if($scope.pending == true && $scope.Add==false){
							logger.logError(" Some invoices are Pending / Draft ");
						}
						
					}
					else{
						logger.logError("Atleast One Row Required");
					}
				}

			}}
			   $scope.cancel=function(){
					$state.go('app.sea.joborderApp.list',{tenantid:$stateParams.tenantid});
				}
			   $scope.close = function() {
		            ngDialog.close();    
		        };
			   $scope.print1 = function(rowid) {
					
					var test = parseInt(rowid);
					var url = $stateParams.tenantid
							+ '/app/jobOrderAir/print1?rowid=' + rowid
					var wnd = window
							.open(
									url,
									'HISERP',
									'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
					wnd.print();

				};
						
				$scope.$watch('joborder.quotationNo', function(newValue,
						oldValue) {
					if(oldValue!=""){
						var qkLinkQuon=$scope.joborder.quotationNo;
						 $window.open('/#/'+$stateParams.tenantid+'/seaQuotation/view?qkLinkQuon='+qkLinkQuon, '_blank');
					}
				});
				
				
				$scope.quickLinkMethd=function(jobId,qulkVal){
					if(qulkVal!='Select'){
					$http.post($stateParams.tenantid + '/app/jobOrderSeaApp/quickLinkView?category='+qulkVal+'&jobId='+jobId).success(function(datas) {
								if(datas.quickLinkId!=null){
									var rowid=datas.quickLinkId;
									if(qulkVal=="HBL"){
										if(rowid !=0){
											$location.url($stateParams.tenantid+'/hbl/edit?rowid='+rowid); 
										//	$window.open('#'+$stateParams.tenantid+'/hbl/view?rowid='+rowid, '_blank');	
										}else{
											logger.logError("There is no "+qulkVal);
										}
									}else if(qulkVal=="MBL"){
										if(rowid !=0){
											$location.url($stateParams.tenantid+'/mabl/edit?rowid='+rowid); 
											//$window.open('#'+$stateParams.tenantid+'/mabl/view?rowid='+rowid,'_blank');	
										}else{
											logger.logError("There is no "+qulkVal);
										}
									}else if(qulkVal=="Delivery Order"){
										if(rowid !=0){
											$location.url($stateParams.tenantid+'/deliveryorder/edit?rowid='+rowid); 
											//$window.open('#'+$stateParams.tenantid+'/deliveryorder/view?rowid='+rowid,'_blank');	
										}else{
											logger.logError("There is no "+qulkVal);
										}
									}else if(qulkVal=="Sales Invoice"){
										if(rowid !=0){
											$location.url($stateParams.tenantid+'/invoice/seasalesinvoice/salesInvoiceView'+rowid); 
											//$window.open('#'+$stateParams.tenantid+"/invoice/seasalesinvoice/salesInvoiceView/"+rowid,'_blank');	
										}else{
											logger.logError("There is no "+qulkVal);
										}
									}else if(qulkVal=="Purchase Invoice"){
										if(rowid !=0){
											$location.url($stateParams.tenantid+'/invoice/seapurchaseinvoice/PurchaseInvoiceView'+rowid);
											//$window.open('#'+$stateParams.tenantid+"/invoice/seapurchaseinvoice/PurchaseInvoiceView/"+rowid,'_blank');	
										}else{
											logger.logError("There is no "+qulkVal);
										}
									}
								}
								
								else if(datas.quickLinkIdList!=null){
									var quickLinkIdList=datas.quickLinkIdList
									if(qulkVal=="HBL"){
										//$window.open('#'+$stateParams.tenantid+'/hbl/list?quickLinkIdList='+quickLinkIdList, '_blank');
										$location.url($stateParams.tenantid+'/hbl/list?quickLinkIdList='+quickLinkIdList);
									}else if(qulkVal=="MBL"){
										$location.url($stateParams.tenantid+'/mabl/list?quickLinkIdList='+quickLinkIdList);
										//$window.open('#'+$stateParams.tenantid+'/mabl/list?quickLinkIdList='+quickLinkIdList, '_blank');
									}else if(qulkVal=="Delivery Order"){
										$location.url($stateParams.tenantid+'/deliveryorder/list?quickLinkIdList='+quickLinkIdList);
										//$window.open('#'+$stateParams.tenantid+'/deliveryorder/list?quickLinkIdList='+quickLinkIdList, '_blank');
									}else if(qulkVal=="Sales Invoice"){
										$location.url($stateParams.tenantid+'/invoice/sea/seasalesinvoice/SalesInvoiceList?quickLinkIdList='+quickLinkIdList);
										//$window.open('#'+$stateParams.tenantid+'/invoice/sea/seasalesinvoice/SalesInvoiceList?quickLinkIdList='+quickLinkIdList,'_blank');
									}else if(qulkVal=="Purchase Invoice"){
										$location.url($stateParams.tenantid+'/invoice/sea/seapurchaseinvoice/PurchaseInvoiceList?quickLinkIdList='+quickLinkIdList);
										//$window.open('#'+$stateParams.tenantid+'/invoice/sea/seapurchaseinvoice/PurchaseInvoiceList?quickLinkIdList='+quickLinkIdList,'_blank');
									}
								}
								else if (datas.quickLinkId == null)
								{
									if(qulkVal=="HBL"){
										logger.logError("There is no "+qulkVal);
									}
									if(qulkVal=="MBL")
										{
										logger.logError("There is no "+qulkVal);
										}
								if(qulkVal=="Delivery Order")
									{
									$location.url($stateParams.tenantid+'/deliveryorder/add');
									}
								if(qulkVal=="Sales Invoice"){
									$location.url($stateParams.tenantid+'/invoice/sea/salesinvoice/SalesInvoiceAdd');
								}
								if(qulkVal=="Purchase Invoice"){
									$location.url($stateParams.tenantid+'/invoice/sea/purchaseinvoice/PurchaseInvoiceAdd');
								}
								}
								
					})
				}
				}
				 var defaultCurrency = '';
				 var  fromCurrency='';
				 var toCurrency='';
				 
					$scope.$watch('joborder.currency', function(newValue,
							oldValue) {
						if (newValue != '' && newValue != undefined) {
						    
						    $http
							.get(
									$stateParams.tenantid
											+ '/app/currency/getExchangeRate?currencyId='+parseInt(newValue))
							.success(
									function(data) {
										
//										if(!$scope.isEdit){
//											$scope.joborder.exRate = data.defaultCurrency;
//										}
										$scope.joborder.exRate = data.defaultCurrency;
										defaultCurrency = data.defaultCurrency;
										fromCurrency=data.fromCurrency;
										toCurrency=data.toCurrency;
										$scope.checkExRate();
									});
						}
						
					});
					
					$scope.checkExRate = function(){
						if($scope.joborder.exRate >= fromCurrency && $scope.joborder.exRate <= toCurrency){
							
						}
						else{
						//	logger.logError("Exchange Rate Between "+fromCurrency+ " and " +toCurrency);
							$scope.joborder.exRate ='';
						}
					}
					$scope.CheckExRateDtl = function(currecny,index){
						if (currecny != '' && currecny != undefined) {
					    
					    $http
						.get(
								$stateParams.tenantid
										+ '/app/currency/getExchangeRate?currencyId='+parseInt(currecny))
						.success(
								function(data) {
									
									/*if(!$scope.isEdit){
										$scope.joborder.joborderDtl[$scope.trIndex].exRate = data.defaultCurrency;
									}*/
									
									defaultCurrency1 = data.defaultCurrency;
									fromCurrency1=data.fromCurrency;
									toCurrency1=data.toCurrency;
									$scope.checkExRate($scope.joborder.joborderDtl[index].exRate,index);
								});
					}
						$scope.ratevalues();
					}
		//remarks
				 $scope.remarks = function(accountHeadCode,jobNo){
			           
		               if(accountHeadCode !=""){
		                   ngDialog.open({
		                       scope : $scope,
		                       template : 'views/sea/seareamarks',
		                       controller : $controller('remarksCtrl', {
		                           $scope : $scope,
		                           purchaseObject : $scope.purchaseInvoiceData,
		                           accountHeadCode:accountHeadCode,
		                           jobNo:jobNo
		                       }),
		                       className : 'ngdialog-theme-plain',
		                       showClose : false,
		                       closeByDocument : false,
		                       closeByEscape : false,
		                       preCloseCallback : $scope.getList
		                   });
		               }else{
		                   logger.logError("");
		               }
		              
		           
		               
		       }

				

				
				 
				

		});


app
		.controller(
				'joborderViewCtrl1',
				function($scope, $timeout, $stateParams, sharedProperties,
						toaster, $filter, $rootScope, $http, $location, logger,
						$state, ngDialog, $controller, $injector,$window) {
					$scope.quotationTypeList = [];
					$scope.customerDropList = [];
					$scope.consigneeDropList  = [];
					$scope.shipperDropList  = [];
					$scope.nominatedDropList  = [];
					$scope.vendorDropList = [];
					$scope.serviceParnrDropList = [];
					$scope.portList = [];
					$scope.quotationList = [];
					$scope.uomList=[];
					$scope.currencyList = [];
					$scope.createQuote = false;
//					$scope.defaultCurrency = 0;
//					$scope.fromCurrency=0;
//					$scope.toCurrency=0;
;
var userid=$('#tempidww').val();
					var jobId =   parseInt($location.search().rowid) ;
					
					/*$scope.joborder={
							jobId : '',
							mode:'',
							service:'',
							jobDate:'',
							branch:'',
							customer:'',
							shipper:'',
							consignee : '',
							term : '',
							aol:'',
							aod :'',
							origin:'',
							destination:'',
							commodity:'',
							status:'',
							currency:'',
							quotationNo:'',
							salesType:'',
							salesPerson:'',
							nominatedBy:'',
							vendor:'',
							carrier:'',
							vessel:'',
							flightDate:'',
							exRate:'',
							customsBroker:'',
								modeName:'',
									jbName:'',
									partyName:'',
									pkg:'',
									gross:'',
									net:'',
									vessel:'',
									container:'',
									pickUp:'',
									carting:'',
									remarks:'',
									agent:'',
									eta:'',
									nomination:'',
									exrate:'',
									pol:'',
									pod:'',
									pickupDate:'',
									stuffingDate:'',
									createdDt:'',
									sailingDate:'',
									customsCompletionsDate:'',
									etaDestinationDate:'',
									salesDate:'',
									purchaseInvoice:''
					
					
					$scope.jobOrderDtl = [{
							joborderDtlId : '',
							chargeHead : '',
							unit : '',
							transactionType : '',
							quantity : '',
							rate : '',
							currency :'',
							exRate :'',
							amount : '0',
							paymentMode: '',
							buySellParty : '',
							Status:'',
								amount1 :''
					}], 
					joborderTracking : {
						 jobTrackingId : '',
						 jobId : '',
						 totalPcs : '',
						 totalGrosssWeight : '',
					     totalAmount : '',
						 totalNetWeight : '',
					},
					joborderTrackingDtl : [{
						select : '',
						commodity : '',
						descriptionGoods : '',
						uom : '',
						length : '',
						width : '',
						height : '',
						noOfPieces : '',
						netWeight : '',
						grossWeight : '',
						chargeableWeight: '',
						rate: '',
						amount : '',
						remarks : ''
					}]
					}*/	
					
					
					$scope.joborder = {
							jobId : '',
							mode:'',
							service:'',
							jobDate:'',
							branch:'',
							customer:'',
							shipper:'',
							consignee : '',
							term : '',
							aol:'',
							aod :'',
							origin:'',
							destination:'',
							commodity:'',
							status:'',
							currency:'',
							quotationNo:'',
							quotationnum:'',
							salesType:'',
							salesPerson:'',
							nominatedBy:'',
							vendor:'',
							carrier:'',
							vessel:'',
							flightDate:'',
							exRate:'',
							customsBroker:'',
								modeName:'',
									jbName:'',
									partyName:'',
									pkg:'',
									gross:'',
									net:'',
									vessel:'',
									container:'',
									pickUp:'',
									carting:'',
									remarks:'',
									agent:'',
									eta:'',
									nomination:'',
									exrate:'',
									pol:'',
									pod:'',
									pickupDate:'',
									stuffingDate:'',
									createdDt:'',
									sailingDate:'',
									customsCompletionsDate:'',
									etaDestinationDate:'',
									salesDate:'',
									remarks1:'',
									searemarks:'',
									purchaseInvoice:'',
							joborderDtl : [ {
								joborderDtlId : '',
								chargeHead : '',
								unit : '',
								conType: '',
								transactionType : '1',
								quantity : '',
								rate : '',
								currency :'',
								exRate :'',
								amount : '0',						
								buySellParty : '',
								Status:'',
									amount1 :'',
									color : ''
							} ],
							joborderDtl1 : [ {
								joborderDtlId : '',
								chargeHead : '',
								unit : '',
								conType: '',
								transactionTypeName : '',
								transactionType :'',
								quantity : '',
								rate : '',
								currencyName :'',
								exRate :'',
								amount : '0',						
								buySellPartyName : '',
								statusName:'',
								invoiceNo:'',	
								amount1 :'',
									color : ''
							} ],
							joborderTracking : {
								jobTrackingId : '',
								 jobId : '',
								 totalPcs : '',
								 totalGrosssWeight : '',
							     totalAmount : '',
								 totalNetWeight : '',
							},
							joborderTrackingDtl : [{
								
								select : '',
								containerNo : '',
								sizeType : '',
								cargoDescription : '',
								noOfPackage : '0',
								uom : '',
								netWeight : '0',
								grossWeight : '0',
								measurement : '0',
								remarks : ''
							}]
						}
					
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

	                  var todate = dd + '/' + mm + '/' + yyyy;
	                  var time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();

	                  
/*	                  $scope.carrierList = [
						     {id: '1', text: 'SIMA MARINE (INDIA) PRIVATE LIMITED'},
						    {id: '2', text: 'TCI SEAWAYS'}
						  ];
*/
	                  
	                  
	                 /* $scope.carrierList = [
	          			{id: '1', text: 'SIMA MARINE (INDIA) PRIVATE LIMITED'},
	          		    {id: '2', text: 'TCI SEAWAYS'},
	          		    {id: '3', text: 'THE SHIPPING CORPORATION OF INDIA LIMITED'},
	          		    {id: '4', text: 'AVANA LOGISTEK LIMITED'},
	          		    {id: '5', text: 'CONTAINER CORPORATION OF INDIA LIMITED'}
	          		  ];*/
	                  $http.get($stateParams.tenantid+'/app/commonUtility/getcarrierList').success(function(datas) {
	          			debugger
	          		    $scope.carrierList = datas.commonUtilityBean;	    
	                      //$scope.transList = datas.lCommonUtilityBean;	    

	          		}).error(function(data) {

	          		});
	                  
	                  $scope.specialEmployeeFlag = false;
						 $scope.userId=$('#empId').val();

						 if( $scope.userId == 'E0002'|| $scope.userId =='E0003'||$scope.userId == 'E0006'||$scope.userId == 'E0001' ||$scope.userId == 'E0004' || $scope.userId=='E0016' || $scope.userId=='E0110'){
							 $scope.specialEmployeeFlag = true;
						 }
						 

					$scope.printRoutingOrder = function(){
				        
				        var url = $stateParams.tenantid+'/app/jobOrderSeaApp/printRoutingOrder?jobId=' + jobId;
				        var wnd = $window.open(url, 'ATHENA', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
				        wnd.print();   
				     }
					$scope.viewQuotation = function(quotationNo) {
						
							$location.url($stateParams.tenantid+'/seaQuotation/view?QuotHdId='+quotationNo);
						
					}
					
					$scope.$watch('joborder.jobDate', function(newValue, oldValue) {

						if(newValue!='' && newValue!=undefined){
						//	/app/jobOrderSeaApp/quickLinkView?category='+qulkVal+'&jobId='+jobId
					$http.get($stateParams.tenantid+'/app/jobOrderSeaApp/getDateChange?date='+oldValue+'&jobId='+jobId+'&mode='+$scope.joborder.mode).success(function(datas) {
						console.log(datas);	
						//$scope.serviceParnrDropList=datas.serviceParnrList;
						if(datas.success){
						logger.logError("Already Invoice Raised For this Job No");
					$scope.joborder.jobDate='';
						}
						}).error(function(data) {

						});

						}
						});
					
					
					
					
					
					
					
					$scope.$watch('joborder.jobStatus', function(newValue,
							oldValue) {
						if (newValue != '' && newValue != undefined) {
							/*if(newValue==2)
								{
								$scope.Add=false;
								$scope.disable=true;
								}else{
									$scope.Add=true;
									$scope.disable=false;
								}*/
							if(newValue==2 && (userid == 'A0001' || userid == 'E0003'))
							{
							$scope.Add=false;
							$scope.disable=true;
							
							$scope.unique = true;
							}
							else if(newValue==2 && userid != 'A0001' && userid != 'E0003')
							{
								$scope.Add=false;
								$scope.disable=true;
								$scope.unique = false;
								var noOfDays=0;
								if ($scope.joborder.jobDate!='' && todate!='') {
									noOfDays = moment(todate, 'DD/MM/YYYY').diff(moment($scope.joborder.jobDate, 'DD/MM/YYYY'), 'days');
								}
								if (noOfDays < 90) {
								$scope.trackDtl=false;	
								$scope.trackDtlAdd=true;
								}
								else{
								$scope.trackDtl=true;	
								$scope.trackDtlAdd=false;
								}
								}
							else{
								$scope.Add=true;
								$scope.disable=false;
								$scope.trackDtl=false;	
								$scope.trackDtlAdd=true;
							}
						}
						
					});
					
					
					$scope.prtShpprName=''
						$scope.prtShpprAddress='';
						$scope.prtConsignName=''
						$scope.prtPrtOfLoading=''
					    $scope.prtTotlPices='';
						$scope.prtTotlNetWt=''
						$scope.prtTotlGrsWt=''
						$scope.prtcommdty=''
						$scope.prtTems=''
						$scope.prtremarks='';
						
						
						$scope.printUpdatesRouting=function(){
							
							

							angular.forEach($scope.shipperDropList, function(value, key) {
								if($scope.joborder.shipper==value.id)
									$scope.prtShpprName=value.text;
							})
							if($scope.joborder.shpprAddrss1!=null){
								$scope.prtShpprAddress=$scope.joborder.shpprAddrss1;
							}
							if($scope.joborder.shpprAddrss2!=null){
								$scope.prtShpprAddress=$scope.prtShpprAddress+$scope.joborder.shpprAddrss2;
							}
							if($scope.joborder.shpprAddrss3!=null){
								$scope.prtShpprAddress=$scope.prtShpprAddress+$scope.joborder.shpprAddrss3;
							}
							if($scope.joborder.shpprAddrss4!=null){
								$scope.prtShpprAddress=$scope.prtShpprAddress+$scope.joborder.shpprAddrss4;
							}
							
							angular.forEach($scope.consigneeDropList, function(value, key) {
								if($scope.joborder.consignee==value.id)
									$scope.prtConsignName=value.text;
							})
							
							angular.forEach($scope.portList, function(value, key) {
								if($scope.joborder.aol==value.id)
									$scope.prtPrtOfLoading=value.text;
							})
							
							angular.forEach($scope.TermList, function(value, key) {
								if($scope.joborder.term==value.id)
									$scope.prtTems=value.text;
							})
							
							angular.forEach($scope.portList, function(value, key) {
								if($scope.joborder.aod==value.id)
									$scope.prtPrtOfDischrg=value.text;
							})
							
							$scope.prtTotlPices =$scope.joborder.joborderTracking.totalPcs
							$scope.prtTotlNetWt=$scope.joborder.joborderTracking.totalNetWeight
							$scope.prtTotlGrsWt=$scope.joborder.joborderTracking.totalGrosssWeight
							$scope.prtcommdty=$scope.joborder.commodity;
							$scope.prtremarks=$scope.joborder.remarks1
							
							//$scope.prtShpprAddress=$scope.joborder.shpprAddrss1+" "+$scope.joborder.shpprAddrss2+" "+$scope.joborder.shpprAddrss3+" "+$scope.joborder.shpprAddrss4==null?"":$scope.joborder.shpprAddrss4;

						      
						
							
						}
					
					$scope.printRoutingOrder1 = function(){
						/*var printVar=false;
						// This empty methhod to update values from js to jsp
						//SEA
						$http.post($stateParams.tenantid+ '/app/jobOrderAir/updateValues').success(
								function(data) {
									$scope.printUpdatesRouting();
						})*/
					    
						var printContents = document.getElementById('printableContent').innerHTML;
					  	  var popupWin = window.open('', '_blank', 'height=700,width=850,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
					  	  popupWin.document.open();
					  	  popupWin.document.write('<html><head><link rel="stylesheet" type="text/css" href="style.css" />'+
					  			  '<style>table{font-size:12px;}body{font-family: "Open Sans";}table, th, td {border: 1px solid black;border-collapse: collapse;}'+
					  			  'table>thead>tr>th{background-color:#34b7e8;}</style>'+
					  			  '</head><body onload="window.print()">' + printContents + '</body></html>');
					  	  popupWin.document.close();
						
					}
					 var defaultCurrency = '';
					 var  fromCurrency='';
					 var toCurrency='';
					 
						$scope.$watch('joborder.currency', function(newValue,
								oldValue) {
							if (newValue != '' && newValue != undefined) {
							    
							    $http
								.get(
										$stateParams.tenantid
												+ '/app/currency/getExchangeRate?currencyId='+parseInt(newValue))
								.success(
										function(data) {
											
//											if(!$scope.isEdit){
//												$scope.joborder.exRate = data.defaultCurrency;
//											}
											$scope.joborder.exRate = data.defaultCurrency;
											defaultCurrency = data.defaultCurrency;
											fromCurrency=data.fromCurrency;
											toCurrency=data.toCurrency;
											$scope.checkExRate();
										});
							}
							
						});
						
						$scope.checkExRate = function(){
							if($scope.joborder.exRate >= fromCurrency && $scope.joborder.exRate <= toCurrency){
								
							}
							else{
								//logger.logError("Exchange Rate Between "+fromCurrency+ " and " +toCurrency);
								$scope.joborder.exRate ='';
							}
						}

					
					$scope.JobSheet = function(){
				        
				        var url = $stateParams.tenantid+'/app/jobOrderSeaApp/jobDetailOrder?jobId=' + jobId;
				        var wnd = $window.open(url, 'ATHENA', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
				        wnd.print();   
				     }
					$scope.printPrealertSea= function(jobId){
				        
				        var url = $stateParams.tenantid+'/app/jobOrderSeaApp/printPreAlert?jobId=' + jobId;
				        var wnd = $window.open(url, 'ATHENA', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
				        wnd.print();   
				     }
					
					
					$scope.joborder.jobId=jobId;
					$scope.checkundefined = function(value) {
						var invalid = false;
						if (value == undefined || value == 'undefined'
								|| value == null || value == 'null'
								|| value == '') {
							invalid = true;
						}
						return invalid;

					}
					$scope.salesTypeList=[];
					/*$scope.getSalesType = function() {
					    var  data = {};
					    data["id"] = "1";
					    data["text"] = "CROSS TRADE";
					    $scope.salesTypeList.push(data);
					    data = {};
					    data["id"] = "2";
					    data["text"] = "LOCAL";
					    $scope.salesTypeList.push(data);  
					    data = {};
					    data["id"] = "3";
					    data["text"] = "NOMINATED";
					    $scope.salesTypeList.push(data);  
					    
					  
					}
					$scope.getSalesType();*/
					 $scope.transactionTypeList=[];
					
				/*	$scope.getTransactionType = function() {
					    var  data = {};
					    data["id"] = "1";
					    data["text"] = "BUY";
					    $scope.transactionTypeList.push(data);
					    data = {};
					    data["id"] = "2";
					    data["text"] = "SELL";
					    $scope.transactionTypeList.push(data);  
					    
					}
					$scope.getTransactionType();
*/					
					 $scope.jobStatusList=[];
						$scope.getjobStatus = function() {
						    var  data = {};
						    data["id"] = "1";
						    data["text"] = "OPEN";
						    $scope.jobStatusList.push(data);
						    data = {};
						    data["id"] = "2";
						    data["text"] = "CLOSED";
						    $scope.jobStatusList.push(data);  
						    
						}
						$scope.getjobStatus();
						 $scope.jobStatusListDtl=[];
							$scope.getStatus = function() {
							    var  data = {};
							    data["id"] = "1";
							    data["text"] = "PENDING";
							    $scope.jobStatusListDtl.push(data);
							    data = {};
							    data["id"] = "2";
							    data["text"] = "INVOICED";
							    $scope.jobStatusListDtl.push(data);  
							    data = {};
							    data["id"] = "3";
							    data["text"] = "DRAFT";
							    $scope.jobStatusListDtl.push(data);
							}
							$scope.getStatus();
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
					    data["id"] = "5";
					    data["text"] = "FORWARDING";
					     $scope.modeList.push(data);
							  /*   data = {};
								    data["id"] = "4";
								    data["text"] = "LINER";
								     $scope.modeList.push(data);*/
								// data = {};
								// data["id"] = "2";
								// data["text"] = "SEA";
								// $scope.modeList.push(data);
							}
							
							
							$scope.getQuotationType();
				/*	$scope.PaymentMethodList=[];*/
					
					$scope.changecolor = function(id) {
						$('#' + id + ' .selectivityId').find('input').css(
								"border-color", "red");
						;

					}
					$scope.clearcolor = function(id) {
						$('#' + id + ' .selectivityId').find('input').css(
								"border-color", "#e8dddd");
						;

					}
					

					$scope.doubleshowTable = function(wtIndex, trIndex) {

						var n = $("#handsondiv" + trIndex + wtIndex).css(
								"display");

						if (n == 'none') {
							$("#handsondiv" + trIndex + wtIndex).css("display",
									"block");
							$scope.addindex = trIndex + "" + wtIndex;
						} else if (n == 'block') {
							$("#handsondiv" + trIndex + wtIndex).css("display",
									"none");

						}

					}
					
					$scope.addRow = function() {
							var jobOrderDtl = {
								joborderDtlId : '',
								chargeHead : '',
								unit : '',
								conType: '',
								transactionType : '1',
								quantity : '',
								rate : '',
								currency :'',
								exRate :'1',
								amount : '0',
								amount1 :'',							
								buySellParty : '',
								status:'1'
						} 
							$scope.joborder.joborderDtl.push(jobOrderDtl);
					};
					
					$scope.deleteIds = [];
						$scope.removeRow = function() {
							var len = $scope.joborder.joborderDtl.length;
							for (var index = len - 1; index < len; index--) {
								if ($scope.joborder.joborderDtl[index].select == true) {
									if ($scope.joborder.joborderDtl[index].jobDtlId != null
											&& $scope.joborder.joborderDtl[index].jobDtlId > 0) {
										$scope.deleteIds
												.push($scope.joborder.joborderDtl[index].jobDtlId);
									}
									$scope.joborder.joborderDtl.splice(index, 1);
									$scope.ratevalues();
								}
							}
					};
					$scope.addRowTracking = function() {
						var jobOrderTrackingDtl = {
								select : '',
								containerNo : '',
								sizeType : '',
								cargoDescription : '',
								noOfPackage : '0',
								uom : '',
								netWeight : '0',
								grossWeight : '0',
								measurement : '0',
								remarks : ''
						}
						$scope.joborder.joborderTrackingDtl.push(jobOrderTrackingDtl);
					};
					
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

					 var todate = dd + '/' + mm + '/' + yyyy;
					 
					 var time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
					 
					$scope.removeRowTracking = function() {
						var len = $scope.joborder.joborderTrackingDtl.length;
						for (var index = len - 1; index < len; index--) {
							if ($scope.joborder.joborderTrackingDtl[index].select == true) {
								
								$scope.joborder.joborderTrackingDtl.splice(index, 1);
							}
						}
					};
					

				    $scope.hdrData =  $scope.joborder;
				    $scope.dtlData =  $scope.jobOrderDtl;
				    $scope.reset = function () {
				    	
				    	

				    	if($scope.edit == true){
				    		
				    		$scope.getEdit();
				    	}
				    	else{
				    		
				    		$scope.joborder = $scope.hdrData;
					        $scope.jobOrderDtl = $scope.dtlData;
				    	}
				       
				    };
				    
				    
				    $scope
					.$watch(
							'joborder.salesType',
							function(newValue, oldValue) {

								if (newValue != ''
										&& newValue != undefined) {

									if(newValue == '3'){
										$scope.employeeList = [ {
									        id : 'E0040',
									        text : 'E0040-NOMINATED'
									    }]
									}
									else{
										$http.get($stateParams.tenantid+'/app/airquotation/getEmployeeList').success(function(datas) {
											 $scope.employeeList = datas.commonUtilityBean;
										    
										}).error(function(data) {

										});
									}
								
								}
							});
						$http
								.post(
										$stateParams.tenantid
												+ '/app/seaquotation/getServicePartnerList')
								.success(function(datas) {
									debugger

									$scope.mloList = datas.shipperList;

								}).error(function(data) {

								});
					$scope.dropdown=function(){
						$http.post($stateParams.tenantid+'/app/seaquotation/getServicePartnerList').success(function(datas) {
							 $scope.customerBuyList=datas.vendorMasterList;
							 $scope.customerSellList=datas.serviceParnrList;						
						}).error(function(data) {
						});
						$http.get($stateParams.tenantid+'/app/jobOrderSeaApp/dropDownList').success(function(datas) {
							
						  //  $scope.quotationList = datas.quotationList;	
							$scope.customerDropList = datas.customerSelectivityList;
							$scope.consigneeDropList = datas.consigneeSelectivityList;
							$scope.shipperDropList = datas.shipperSelectivityList;
							$scope.nominatedDropList = datas.nominatedSelectivityList;
							$scope.vendorDropList = datas.vendorSelectivityList;
							$scope.serviceParnrDropList=datas.serviceParnrSelectivityList;
							/*$scope.customerBuyList = datas.buyServiceList;
							$scope.customerSellList = datas.sellServiceList;*/
							$scope.salesTypeList = datas.salesSelectivityList;
							$scope.servicePartnerTypelist = datas.serviceSelectivityList;
							/*$scope.PaymentMethodList = datas.paymentSelectivityList;*/
							$scope.transactionTypeList = datas.transactionSelectivityList;
							$scope.chargeHeadList = datas.chargeHeadSelectivityList;
							$scope.TermList = datas.termsSelectivityList;
							$scope.UnitList = datas.unitSelectivityList;
							$scope.uomList = datas.uomList;	 
							//$scope.sizeTypeList = datas.sizeTypeSelectivityList;
							$scope.commodityList = datas.commoditySelectivityList;	
							$scope.currencylist= datas.currecnySelectivityList;
							$scope.branchList = datas.branchSelectivityList;
						    $scope.portList = datas.portSelectivityList;
						}).error(function(data) {

						});
						
						$http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(datas) {	  
							  $scope.sizeTypeList=datas.getcontypelist;

						}).error(function(data) {

						});
						
						$http.get($stateParams.tenantid+ '/app/commonUtility/getQuoteApproveList').success(function(data) {
							$scope.quotationnoList = data;						
						});
						/*$http.post($stateParams.tenantid+'/app/seaquotation/getServicePartnerList').success(function(datas) {
							console.log(datas);
							$scope.customerDropList = datas.customerList;
							 $scope.consigneeDropList = datas.consigneeList;
							 $scope.shipperDropList = datas.shipperList;
							 $scope.nominatedDropList = datas.nominatedList;
							 $scope.vendorDropList = datas.vendorList;
							 $scope.serviceParnrDropList=datas.serviceParnrList;
							 $scope.printUpdatesRouting();
						}).error(function(data) {

						});
						
						$http.get(
								$stateParams.tenantid
										+ '/app/jobOrderAir/dropDownList')
								.success(function(datas) {
									
									$scope.customerBuyList = datas.buyServiceList;
									$scope.customerSellList = datas.sellServiceList;
								}).error(function(data) {

								});
						$http.get($stateParams.tenantid+'/app/seaquotation/getiataList').success(function(datas) {
							
						    $scope.portList = datas.commonUtilityBean;	  
							$scope.printUpdatesRouting();

						}).error(function(data) {

						});
						
						$http.get($stateParams.tenantid+'/app/jobOrderSeaApp/dropDownList').success(function(datas) {
							
						  //  $scope.quotationList = datas.quotationList;	    
							$scope.uomList = datas.uomList;	
							$scope.printUpdatesRouting();
						}).error(function(data) {

						});
						
						$http.get($stateParams.tenantid + '/app/airquotation/getSalesList')
						.success(function(datas) {
							$scope.salesTypeList = datas.commonUtilityBean;

						}).error(function(data) {

						});
						
						$http.get($stateParams.tenantid + '/app/airquotation/getPaymentList')
						.success(function(datas) {
							$scope.PaymentMethodList = datas.commonUtilityBean;

						}).error(function(data) {

						});
						
						$http.get($stateParams.tenantid+'/app/seaquotation/getcommodity').success(function(datas) {
							
						    $scope.commodityList = datas.commonUtilityBean;	    
						
						}).error(function(data) {
						
						});
						
						
						$http.get($stateParams.tenantid + '/app/airquotation/getTransactionList')
						.success(function(datas) {
							$scope.transactionTypeList = datas.commonUtilityBean;

						}).error(function(data) {

						});		
						$http.get($stateParams.tenantid+'/app/airquotation/getBranch').success(function(datas) {
							 $scope.branchList = datas.commonUtilityBean;
						    
						}).error(function(data) {

						});
						$http.get($stateParams.tenantid+'/app/airquotation/getCurrencyList').success(function(datas) {	  
							$scope.currencylist= angular.copy(datas.commonUtilityBean);
						}).error(function(data) {

						});
						
						$http.get($stateParams.tenantid + '/app/airquotation/getServiceList')
						.success(function(datas) {
							$scope.servicePartnerTypelist = datas.commonUtilityBean;

						}).error(function(data) {

						});
						
						$http.get($stateParams.tenantid+'/app/airquotation/getEmployeeList').success(function(datas) {
							 $scope.employeeList = datas.commonUtilityBean;
						    
						}).error(function(data) {

						});
						
						
						$http.get($stateParams.tenantid + '/app/seaquotation/getChargeHeads')
						.success(function(datas) {
							$scope.chargeHeadList = datas.commonUtilityBean;

						}).error(function(data) {

						});
						
						$http.get($stateParams.tenantid + '/app/airquotation/getTerms')
						.success(function(datas) {
							$scope.TermList = datas.commonUtilityBean;

						}).error(function(data) {

						});
						$http.get(
								$stateParams.tenantid
										+ '/app/jobOrderSeaApp/getsizeTypeList')
								.success(function(datas) {
									$scope.sizeTypeList = datas.commonUtilityBean;

								}).error(function(data) {

								});
				$http.get($stateParams.tenantid + '/app/seaquotation/getUnitList')
						.success(function(datas) {
							$scope.UnitList = datas.commonUtilityBean;

						}).error(function(data) {

						});
				$http.get(
						$stateParams.tenantid
								+ '/app/seaquotation/getuomList')
						.success(function(datas) {
							$scope.uomList = datas.commonUtilityBean;
							$scope.printUpdatesRouting();
						}).error(function(data) {

						});*/
				
				
					}
					
					
					$scope.checkValidation = function() {

						var alertmsg = "<ui><h4>Please fill the required fields</h4>";
						var msg = "";
						if ($scope.checkundefined($scope.joborder.quotationNo)) {
							msg = msg + "<li>quotation No :Field is required.</li>";
							$scope.changecolor('quotationNo');
						} else {
							$scope.clearcolor('quotationNo');
						}
						if ($scope.checkundefined($scope.joborder.jobDate)) {
							msg = msg + "<li>jobDate :Field is required.</li>";
							$scope.changecolor('jobDate');
						} else {
							$scope.clearcolor('jobDate');
						}
						if($scope.checkundefined($scope.joborder.service)){
							msg = msg + "<li>Service :Field is required.</li>";
							$scope.changecolor('service');
						}else{
							$scope.changecolor('service');
						}
					  if($scope.checkundefined($scope.joborder.branch)){
							msg = msg + "<li>Branch :Field is required.</li>";
							$scope.changecolor('branch');
						}else{
							$scope.changecolor('branch');
						}
					 /* if($scope.checkundefined($scope.joborder.shipper)){
							msg = msg + "<li>Shipper :Field is required.</li>";
							$scope.changecolor('shipper');
						}else{
							$scope.changecolor('shipper');
						}*/
					  if($scope.checkundefined($scope.joborder.destination)){
							msg = msg + "<li>Destination :Field is required.</li>";
							$scope.changecolor('destination');
						}else{
							$scope.changecolor('destination');
						}
					  
						  if($scope.checkundefined($scope.joborder.origin)){
							msg = msg + "<li>Origin :Field is required.</li>";
							$scope.changecolor('origin');
						}else{
							$scope.changecolor('origin');
						}
						  /*if($scope.checkundefined($scope.joborder.commodity)){
								msg = msg + "<li>Commodity :Field is required.</li>";
								$scope.changecolor('commodity');
							}else{
								$scope.changecolor('commodity');
							}*/
						  if($scope.checkundefined($scope.joborder.currency)){
								msg = msg + "<li>Currency :Field is required.</li>";
								$scope.changecolor('currency');
							}else{
								$scope.changecolor('currency');
							}
						  if($scope.checkundefined($scope.joborder.salesPerson)){
								msg = msg + "<li>SalesPerson :Field is required.</li>";
								$scope.changecolor('salesPerson');
							}else{
								$scope.changecolor('salesPerson');
							}
						  
						 /* if($scope.checkundefined($scope.joborder.nominatedBy)){
								msg = msg + "<li>NominatedBy :Field is required.</li>";
								$scope.changecolor('nominatedBy');
							}else{
								$scope.changecolor('nominatedBy');
							}*/
						 /* if($scope.checkundefined($scope.joborder.consignee)){
								msg = msg + "<li>Consignee :Field is required.</li>";
								$scope.changecolor('consignee');
							}else{
								$scope.changecolor('consignee');
							}*/
						  /*if($scope.checkundefined($scope.joborder.vendor)){
								msg = msg + "<li>Vendor :Field is required.</li>";
								$scope.changecolor('vendor');
							}else{
								$scope.changecolor('vendor');
							}*/
						   
						    /*if($scope.checkundefined($scope.joborder.carrier)){
							msg = msg + "<li>Carrier :Field is required.</li>";
							$scope.changecolor('carrier');
						}else{
							$scope.changecolor('carrier');
						}*/
						    /*if($scope.checkundefined($scope.joborder.vessel)){
								msg = msg + "<li>Vessel/Voyage :Field is required.</li>";
								$scope.changecolor('vessel');
							}else{
								$scope.changecolor('vessel');
							}*/
						/*if($scope.checkundefined($scope.joborder.customsBroker)){
							msg = msg + "<li>Customer Broker :Field is required.</li>";
							$scope.changecolor('customsBroker');
						}else{
							$scope.changecolor('customsBroker');
						}*/
						 /* if($scope.checkundefined($scope.joborder.consignee)){
								msg = msg + "<li>Consignee :Field is required.</li>";
								$scope.changecolor('consignee');
							}else{
								$scope.changecolor('consignee');
							}*/
						    if($scope.checkundefined($scope.joborder.exRate)){
								msg = msg + "<li>Ex-Rate :Field is required.</li>";
								$scope.changecolor('exRate');
							}else{
								$scope.changecolor('exRate');
							}
						  if($scope.checkundefined($scope.joborder.service)){
								msg = msg + "<li>Service :Field is required.</li>";
								$scope.changecolor('service');
							}else{
								$scope.changecolor('service');
							}
						  if($scope.checkundefined($scope.joborder.branch)){
								msg = msg + "<li>Branch :Field is required.</li>";
								$scope.changecolor('branch');
							}else{
								$scope.changecolor('branch');
							}

						angular.forEach($scope.joborder.joborderDtl, function(chargesDetail,
								index) {
							
							if ($scope.checkundefined(chargesDetail.chargeHead)) {
								msg = msg + "<li>Row :" + (index + 1)
										+ "# Charge Heads :Field is required.</li>";
								$scope.changecolor('chargeHeads' + index);
							} else {
								$scope.clearcolor('chargeHeads' + index);
							}
							if ($scope.checkundefined(chargesDetail.unit)) {
								msg = msg + "<li>Row :" + (index + 1)
										+ "# Unit :Field is required.</li>";
								$scope.changecolor('unit' + index);
							} else {
								$scope.clearcolor('unit' + index);
							}
							if ($scope.checkundefined(chargesDetail.currency)) {
								msg = msg + "<li>Row :" + (index + 1)
										+ "# Currency :Field is required.</li>";
								$scope.changecolor('currency' + index);
							} else {
								$scope.clearcolor('currency' + index);
							}
							if ($scope.checkundefined(chargesDetail.quantity)) {
								msg = msg + "<li>Row :" + (index + 1)
										+ "# Quantity :Field is required.</li>";
								$scope.changecolor('qty' + index);
								$('#qty' + index).find('input').css("border-color", "red");

							} else {
								$('#qty' + index).find('input').css("border-color", "#e8dddd");
							}
							if ($scope.checkundefined(chargesDetail.rate)) {
								msg = msg + "<li>Row :" + (index + 1)
										+ "# Rate :Field is required.</li>";
							}
							/*if ($scope.checkundefined(chargesDetail.paymentMode)) {
								msg = msg + "<li>Row :" + (index + 1)
										+ "# Payment Method :Field is required.</li>";
							}*/
							if ($scope.checkundefined(chargesDetail.transactionType)) {
								msg = msg + "<li>Row :" + (index + 1)
										+ "# Transaction Type :Field is required.</li>";
							}
							if ($scope.checkundefined(chargesDetail.buySellParty)) {
								msg = msg + "<li>Row :" + (index + 1)
										+ "# Buy Sell:Field is required.</li>";
							}
							/*if ($scope.checkundefined(chargesDetail.amount)) {
								msg = msg + "<li>Row :" + (index + 1)
										+ "# Amount:Field is required.</li>";
							}*/

							if ($scope.checkundefined(chargesDetail.exRate)) {
								msg = msg + "<li>Row :" + (index + 1)
										+ "# Exchange Rate:Field is required.</li>";
							}

							if ($scope.checkundefined(chargesDetail.transactionType)) {
								msg = msg + "<li>Row :" + (index + 1)
										+ "# Transaction Type :Field is required.</li>";
							}
							
							if ($scope.checkundefined(chargesDetail.status)) {
								
								msg = msg + "<li>Row :" + (index + 1)
										+ "# Status :Field is required.</li>";
							}

						});
						/*angular.forEach($scope.joborder.joborderTrackingDtl, function(TrackingDtl,
								index) {
							
							if ($scope.checkundefined(TrackingDtl.commodity)) {
								msg = msg + "<li>Row :" + (index + 1)
										+ "# Commodity :Field is required.</li>";
								$scope.changecolor('Commodity' + index);
							} else {
								$scope.clearcolor('Commodity' + index);
							}
							if ($scope.checkundefined(TrackingDtl.descriptionGoods)) {
								msg = msg + "<li>Row :" + (index + 1)
										+ "# DescriptionGoods :Field is required.</li>";
								$scope.changecolor('descriptionGoods' + index);
							} else {
								$scope.clearcolor('descriptionGoods' + index);
							}
							if ($scope.checkundefined(TrackingDtl.uom)) {
								msg = msg + "<li>Row :" + (index + 1)
										+ "# LWH UOM :Field is required.</li>";
								$scope.changecolor('uom' + index);
							} else {
								$scope.clearcolor('uom' + index);
							}
							if ($scope.checkundefined(TrackingDtl.noOfPieces)) {
								msg = msg + "<li>Row :" + (index + 1)
										+ "# NoOfPieces :Field is required.</li>";
								$scope.changecolor('noOfPieces' + index);
							} else {
								$scope.clearcolor('noOfPieces' + index);
							}
							if ($scope.checkundefined(TrackingDtl.netWeight)) {
								msg = msg + "<li>Row :" + (index + 1)
										+ "# NetWeight :Field is required.</li>";
								$scope.changecolor('netWeight' + index);
							} else {
								$scope.clearcolor('netWeight' + index);
							}
							if ($scope.checkundefined(TrackingDtl.grossWeight)) {
								msg = msg + "<li>Row :" + (index + 1)
										+ "# GrossWeight :Field is required.</li>";
								$scope.changecolor('GrossWeight' + index);
							} else {
								$scope.clearcolor('GrossWeight' + index);
							}
							if ($scope.checkundefined(TrackingDtl.amount)) {
								msg = msg + "<li>Row :" + (index + 1)
										+ "# Amount :Field is required.</li>";
								$scope.changecolor('Amount' + index);
							} else {
								$scope.clearcolor('Amount' + index);
							}
							

						});*/
						alertmsg = alertmsg + msg + "</ui>";
						if ($scope.checkundefined(msg)) {
							return '';
						} else {
							return alertmsg;
						}

					}
					$scope.$watch('joborder.joborderTrackingDtl[trIndex1].noOfPackage', function(newValue, oldValue) {
				    	var noOfPcs=0;
						for (var i = 0; i <= $scope.joborder.joborderTrackingDtl.length; i++) {
							if($scope.joborder.joborderTrackingDtl[i].noOfPackage==""){
								$scope.joborder.joborderTrackingDtl[i].noOfPackage=0;
								noOfPcs=parseInt($scope.joborder.joborderTrackingDtl[i].noOfPackage)+noOfPcs;
								$scope.joborder.joborderTracking.totalPcs=noOfPcs;
							}
							else{
								noOfPcs=parseInt($scope.joborder.joborderTrackingDtl[i].noOfPackage)+noOfPcs;
								$scope.joborder.joborderTracking.totalPcs=noOfPcs;
							}
							
							
						}
						
				    })
				     $scope.$watch('joborder.joborderTrackingDtl[trIndex1].netWeight', function(newValue, oldValue) {
					var noOfNet=0.0;
					for (var i = 0; i <= $scope.joborder.joborderTrackingDtl.length; i++) {
						if($scope.joborder.joborderTrackingDtl[i].netWeight==""){
							$scope.joborder.joborderTrackingDtl[i].netWeight=0.0;
							noOfNet=parseFloat($scope.joborder.joborderTrackingDtl[i].netWeight)+noOfNet;
							$scope.joborder.joborderTracking.totalNetWeight=noOfNet;
						}
						else{
							noOfNet=parseFloat($scope.joborder.joborderTrackingDtl[i].netWeight)+noOfNet;
							$scope.joborder.joborderTracking.totalNetWeight=noOfNet;
						}
						
						
					}
					
			    })
			     $scope.$watch('joborder.joborderTrackingDtl[trIndex1].grossWeight', function(newValue, oldValue) {
			    	 var noOfGross=0.0;
						for (var i = 0; i <= $scope.joborder.joborderTrackingDtl.length-1; i++) {
							if($scope.joborder.joborderTrackingDtl[i].grossWeight==""){
								$scope.joborder.joborderTrackingDtl[i].grossWeight=0.0;
								noOfGross=parseFloat($scope.joborder.joborderTrackingDtl[i].grossWeight)+noOfGross;
								$scope.joborder.joborderTracking.totalGrosssWeight=noOfGross;
							}
							else{
								noOfGross=parseFloat($scope.joborder.joborderTrackingDtl[i].grossWeight)+noOfGross;
								$scope.joborder.joborderTracking.totalGrosssWeight=noOfGross;
							}
							
							
						}	$scope.qty();
			    })
			    $scope.qty = function() {

						for (var i = 0; i <= $scope.joborder.joborderDtl.length - 1; i++) {
							var grossqty = 0;
							if ($scope.joborder.joborderDtl[i].unit == 2
									|| $scope.joborder.joborderDtl[i].unit == 3) {

								angular
										.forEach(
												$scope.joborder.joborderTrackingDtl,
												function(value, key) {
													if (value.uom == '3') {
														if (value.sizeType == $scope.joborder.joborderDtl[i].conType) {
															if (value.grossWeight != undefined
																	&& value.grossWeight != '') {

																grossqty = grossqty
																		+ value.grossWeight;
															}
														}
													}
												})
								$scope.joborder.joborderDtl[i].quantity = grossqty;
								$scope.joborder.joborderDtl[i].amount = $scope.joborder.joborderDtl[i].quantity
										* $scope.joborder.joborderDtl[i].rate
										* $scope.joborder.joborderDtl[i].exRate;
								$scope.ratevalues();

							}

						}

					}
					$scope.noOfPcs = function() {
						var noOfPcs=0;
						for (var i = 0; i <= $scope.joborder.joborderTrackingDtl.length; i++) {
							if($scope.joborder.joborderTrackingDtl[i].noOfPackage==""){
								$scope.joborder.joborderTrackingDtl[i].noOfPackage=0;
								noOfPcs=parseInt($scope.joborder.joborderTrackingDtl[i].noOfPackage)+noOfPcs;
								$scope.joborder.joborderTracking.totalPcs=noOfPcs;
							}
							else{
								noOfPcs=parseInt($scope.joborder.joborderTrackingDtl[i].noOfPackage)+noOfPcs;
								$scope.joborder.joborderTracking.totalPcs=noOfPcs;
							}
							
							
						}
					}
					$scope.noOfNet = function() {
						var noOfNet=0.0;
						for (var i = 0; i <= $scope.joborder.joborderTrackingDtl.length; i++) {
							if($scope.joborder.joborderTrackingDtl[i].netWeight==""){
								$scope.joborder.joborderTrackingDtl[i].netWeight=0.0;
								noOfNet=parseFloat($scope.joborder.joborderTrackingDtl[i].netWeight)+noOfNet;
								$scope.joborder.joborderTracking.totalNetWeight=noOfNet;
							}
							else{
								noOfNet=parseFloat($scope.joborder.joborderTrackingDtl[i].netWeight)+noOfNet;
								$scope.joborder.joborderTracking.totalNetWeight=noOfNet;
							}
							
							
						}
					}
					
					 
					
					$scope.noOfGross = function() {
						var noOfGross=0.0;
						for (var i = 0; i <= $scope.joborder.joborderTrackingDtl.length-1; i++) {
							if($scope.joborder.joborderTrackingDtl[i].grossWeight==""){
								$scope.joborder.joborderTrackingDtl[i].grossWeight=0.0;
								noOfGross=parseFloat($scope.joborder.joborderTrackingDtl[i].grossWeight)+noOfGross;
								$scope.joborder.joborderTracking.totalGrosssWeight=noOfGross;
							}
							else{
								noOfGross=parseFloat($scope.joborder.joborderTrackingDtl[i].grossWeight)+noOfGross;
								$scope.joborder.joborderTracking.totalGrosssWeight=noOfGross;
							}
							
							
						}
						
						
					}
					
					$scope.getDropDownListprt = function() {
				        $http.post($stateParams.tenantid+'/app/seaquotation/getcommodity').success(function(data){
				        	$scope.commodityList=data.commonUtilityBean;
				            
				            $timeout(function() { 
				                $("#commodityL").multiselect({
				                    maxHeight: 200,
				                    includeSelectAllOption: true,
				                    selectAllText: 'Select All',
				                    enableFiltering: true,
				                    enableCaseInsensitiveFiltering: true,
				                    filterPlaceholder: 'Search',
				                    onChange: function(element, checked) {
				                        ;
				                        var ct=""; 
				                      if($scope.commodityList.length>0){   
				                          $scope.joborder.commodity ='';
				                         angular.forEach($scope.joborder.commodityL, function (item, key) {
				                             if(ct==""){
				                                 ct = item.id;
				                             }else{
				                                 ct +=","+ item.id;
				                             }       
				                             $scope.joborder.commodity = ct;
				                         });
				                      }else{
				                    	  $scope.joborder.commodity = '';
				                      }
				                    }
				                  });
				                $("#commodityL").parent().find('.btn-group #multiselect-button').addClass('width_100 input-sm line-height-5'); 
				                
				                }, 2, false);
				            
				            $timeout(function() { 
				                $("#commodityL").multiselect({
				                    maxHeight: 200,
				                    includeSelectAllOption: true,
				                    selectAllText: 'Select All',
				                    enableFiltering: true,
				                    enableCaseInsensitiveFiltering: true,
				                    filterPlaceholder: 'Search',
				                    onChange: function(element, checked) {
				                        ;
				                        var ct=""; 
				                      if($scope.commodityList.length>0){   
				                          $scope.joborder.commodity ='';
				                         angular.forEach($scope.joborder.commodityL, function (item, key) {
				                             if(ct==""){
				                                 ct = item.id;
				                             }else{
				                                 ct +=","+ item.id;
				                             }       
				                             $scope.joborder.commodity = ct;
				                         });
				                      }else{
				                    	  $scope.joborder.commodity = '';
				                      }
				                    }
				                  });
				                $("#commodityL").parent().find('.btn-group #multiselect-button').addClass('width_100 input-sm line-height-5'); 
				                
				                }, 2, false);
				        }).error(function(data) {
				        });

				    }
				    $scope.getDropDownListprt();
					
					$scope.edit = false;
					
					
					$scope.getEdit = function () {
						
					
					if (jobId != '' && jobId != undefined) {
						$scope.edit = true;
						

					$http.post($stateParams.tenantid + '/app/jobOrderSeaApp/edit',
							jobId)
					.success(
							function(data) {
								
								
								
								$scope.joborder = data.lJobOrderBean[0];
								
								if(data.lJobOrderBean[0].service!='' && data.lJobOrderBean[0].service!=null){
									$scope.joborder.service = data.lJobOrderBean[0].service.toString();
									}
									if(data.lJobOrderBean[0].remarks1!='' && data.lJobOrderBean[0].remarks1!=null){
									$scope.joborder.searemarks = data.lJobOrderBean[0].remarks1.toString();
									}
									$scope.joborder.remarks1='';
									if(data.lJobOrderBean[0].branch!=''&& data.lJobOrderBean[0].branch!=null)
										{
									$scope.joborder.branch = data.lJobOrderBean[0].branch.toString();
										}
									//if(data.lJobOrderBean[0].mode!=''=data.lJobOrderBean[0].mode!=null)
									//{
										$scope.joborder.mode = data.lJobOrderBean[0].mode;
									//}
								$scope.joborder.jobDate=data.lJobOrderBean[0].jobDate;
								if(data.lJobOrderBean[0].aol!=''&&data.lJobOrderBean[0].aol!=null)
									{
								$scope.joborder.aol = data.lJobOrderBean[0].aol
										.toString();
									}
								if(data.lJobOrderBean[0].aod!=''&&data.lJobOrderBean[0].aod!=null)
									{
								$scope.joborder.aod = data.lJobOrderBean[0].aod
										.toString();
									}
								if(data.lJobOrderBean[0].term!=''&&data.lJobOrderBean[0].term!=null)
									{
								$scope.joborder.term = data.lJobOrderBean[0].term
										.toString();
									}
								if(data.lJobOrderBean[0].origin!=''&&data.lJobOrderBean[0].origin!=null)
									{
								$scope.joborder.origin = data.lJobOrderBean[0].origin
										.toString();
									}
								if(data.lJobOrderBean[0].destination!=''&&data.lJobOrderBean[0].destination!=null)
									{
								$scope.joborder.destination = data.lJobOrderBean[0].destination
										.toString();
									}
								if(data.lJobOrderBean[0].customer!=''&&data.lJobOrderBean[0].customer!=null)
									{
								$scope.joborder.customer = data.lJobOrderBean[0].customer
										.toString();
									}
								if(data.lJobOrderBean[0].shipper!=''&&data.lJobOrderBean[0].shipper!=null)
									{
								$scope.joborder.shipper = data.lJobOrderBean[0].shipper
										.toString();
									}
								if (data.lJobOrderBean[0].nominatedBy != null
										&& data.lJobOrderBean[0].nominatedBy != '') {
								$scope.joborder.nominatedBy = data.lJobOrderBean[0].nominatedBy
										.toString();
								}
								if(data.lJobOrderBean[0].currency!=''&&data.lJobOrderBean[0].currency!=null)
									{
								$scope.joborder.currency = data.lJobOrderBean[0].currency
										.toString();
									}
								if(data.lJobOrderBean[0].quotationnum!=''&&data.lJobOrderBean[0].quotationnum!=null)
									{
								$scope.joborder.quotationnum = data.lJobOrderBean[0].quotationnum
								.toString();
									}
								if(data.lJobOrderBean[0].mode.toString()!=''&&data.lJobOrderBean[0].mode.toString()!=null)
									{
								$scope.joborder.mode = data.lJobOrderBean[0].mode.toString();
									}
								if(data.lJobOrderBean[0].salesType!=''&&data.lJobOrderBean[0].salesType!=null)
									{
								$scope.joborder.salesType = data.lJobOrderBean[0].salesType
										.toString();
									}
								if(data.lJobOrderBean[0].vessel!=''&&data.lJobOrderBean[0].vessel!=null)
									{
								$scope.joborder.vessel = data.lJobOrderBean[0].vessel
								.toString();
									}
								if(data.lJobOrderBean[0].consignee!=''&&data.lJobOrderBean[0].consignee!=null)
									{
								$scope.joborder.consignee = data.lJobOrderBean[0].consignee
								.toString();
									}
								if(data.lJobOrderBean[0].vendor!=''&&data.lJobOrderBean[0].vendor!=null)
									{
								$scope.joborder.vendor = data.lJobOrderBean[0].vendor
								.toString();
									}
								if (data.lJobOrderBean[0].customsBroker != null
										&& data.lJobOrderBean[0].customsBroker != '') {
								$scope.joborder.customsBroker = data.lJobOrderBean[0].customsBroker
								.toString();
								}
								if (data.lJobOrderBean[0].commodity != null
										&& data.lJobOrderBean[0].commodity != '') {
								$scope.joborder.commodity = data.lJobOrderBean[0].commodity
								.toString();
								}
								
                                /*$scope.joborder.pickupDate = data.lJobOrderBean[0].pickupDate
								.toString();
								$scope.joborder.stuffingDate = data.lJobOrderBean[0].stuffingDate
								.toString();
								$scope.joborder.createdDt = data.lJobOrderBean[0].createdDt
								.toString();
								$scope.joborder.sailingDate = data.lJobOrderBean[0].sailingDate
								.toString();
								$scope.joborder.customsCompletionsDate = data.lJobOrderBean[0].customsCompletionsDate
								.toString();
								$scope.joborder.etaDestinationDate = data.lJobOrderBean[0].etaDestinationDate
								.toString();
								$scope.joborder.salesInvoice = data.lJobOrderBean[0].salesInvoice
								.toString();
								$scope.joborder.salesDate = data.lJobOrderBean[0].salesDate
								.toString();
								$scope.joborder.purchaseInvoice = data.lJobOrderBean[0].purchaseInvoice
								.toString();
								$scope.joborder.purchaseDate = data.lJobOrderBean[0].purchaseDate
								.toString();*/
								
								for (var i = 0; i < $scope.joborder.joborderDtl.length; i++) {
							
									$scope.joborder.joborderDtl[i].chargeHead = $scope.joborder.joborderDtl[i].chargeHead.toString();
									$scope.joborder.joborderDtl[i].unit = $scope.joborder.joborderDtl[i].unit
											.toString();
									$scope.joborder.joborderDtl[i].currency = $scope.joborder.joborderDtl[i].currency
											.toString();								
									$scope.joborder.joborderDtl[i].transactionType = $scope.joborder.joborderDtl[i].transactionType
											.toString();
									$scope.joborder.joborderDtl[i].buySellParty = $scope.joborder.joborderDtl[i].buySellParty
										.toString();
								    $scope.joborder.joborderDtl[i].status = $scope.joborder.joborderDtl[i].status.toString();
								    $scope.joborder.joborderDtl[i].color = $scope.joborder.joborderDtl[i].color;

								}
								
								/*for (var i = 0; i < $scope.joborder.joborderDtl1.length; i++) {
									
									$scope.joborder.joborderDtl1[i].chargeHead = $scope.joborder.joborderDtl1[i].chargeHead.toString();
									$scope.joborder.joborderDtl1[i].unit = $scope.joborder.joborderDtl1[i].unit
											.toString();
									$scope.joborder.joborderDtl1[i].currency = $scope.joborder.joborderDtl1[i].currency
											.toString();
									$scope.joborder.joborderDtl1[i].paymentMode= $scope.joborder.joborderDtl1[i].paymentMode
											.toString();
									$scope.joborder.joborderDtl1[i].transactionType = $scope.joborder.joborderDtl1[i].transactionType
											.toString();
									$scope.joborder.joborderDtl1[i].buySellParty = $scope.joborder.joborderDtl1[i].buySellParty
										.toString();
								    $scope.joborder.joborderDtl1[i].status = $scope.joborder.joborderDtl1[i].status.toString();
								    $scope.joborder.joborderDtl1[i].color = $scope.joborder.joborderDtl1[i].color;

								}*/

								var buy1 =0;
								var sell=0;
								var sell1 =0;
								var amount =0;

								var total =0; 
						    	if($scope.joborder.joborderDtl.length != null ||$scope.joborder.joborderDtl.length != undefined ||$scope.joborder.joborderDtl.length != "" ||$scope.joborder.joborderDtl.length != ''){
		{
			for( var i=0;i<=$scope.joborder.joborderDtl.length-1;i++)
		{
				

				var amount1=[];
				var amount=[];
				if(($scope.joborder.joborderDtl[i].transactionType != null ) || ($scope.joborder.joborderDtl[i].transactionType != undefined ) ||($scope.joborder.joborderDtl[i].transactionType != "" ) ||($scope.joborder.joborderDtl[i].transactionType != '' ))
		         {
					if($scope.joborder.joborderDtl[i].transactionType =="1")
		              {
						
						if(($scope.joborder.joborderDtl[i].quantity  != null || $scope.joborder.joborderDtl[i].quantity != undefined ||$scope.joborder.joborderDtl[i].quantity !="" ||$scope.joborder.joborderDtl[i].quantity != '') &&  ($scope.joborder.joborderDtl[i].rate  != null || $scope.joborder.joborderDtl[i].rate != undefined ||$scope.joborder.joborderDtl[i].rate != " " ||$scope.joborder.joborderDtl[i].rate != '') && ($scope.joborder.joborderDtl[i].exRate  != null || $scope.joborder.joborderDtl[i].exRate == undefined ||$scope.joborder.joborderDtl[i].exRate !="" ||$scope.joborder.joborderDtl[i].exRate != '') )
						{
						amount1[i] = (parseFloat(($scope.joborder.joborderDtl[i].quantity)) * parseFloat(($scope.joborder.joborderDtl[i].rate))*parseFloat(($scope.joborder.joborderDtl[i].exRate)));
						$scope.joborder.joborderDtl[i].amount=parseFloat(amount1[i]);

						
					
						buy1=parseFloat(buy1)+parseFloat($scope.joborder.joborderDtl[i].amount);
						console.log("i:"+i+" buy1:"+buy1);
						
						}
		              }	
					
					else {
						if($scope.joborder.joborderDtl[i].transactionType =="2")
						{
										
										if(($scope.joborder.joborderDtl[i].quantity  != null || $scope.joborder.joborderDtl[i].quantity != undefined ||$scope.joborder.joborderDtl[i].quantity !="" ||$scope.joborder.joborderDtl[i].quantity != '') &&  ($scope.joborder.joborderDtl[i].rate  != null || $scope.joborder.joborderDtl[i].rate != undefined ||$scope.joborder.joborderDtl[i].rate != " " ||$scope.joborder.joborderDtl[i].rate != '') && ($scope.joborder.joborderDtl[i].exRate  != null || $scope.joborder.joborderDtl[i].exRate == undefined ||$scope.joborder.joborderDtl[i].exRate !="" ||$scope.joborder.joborderDtl[i].exRate != '') )
										{
										amount1[i] = (parseFloat(($scope.joborder.joborderDtl[i].quantity)) * parseFloat(($scope.joborder.joborderDtl[i].rate))*parseFloat(($scope.joborder.joborderDtl[i].exRate)));
										$scope.joborder.joborderDtl[i].amount=parseFloat(amount1[i]);

										sell1=parseFloat(sell1)+parseFloat($scope.joborder.joborderDtl[i].amount);
										console.log("i:"+i+" sell1:"+sell1);
										}
						}	
					}
					
					
					

		}

				$scope.joborder.joborderDtl[i].amount=parseFloat(amount1[i]).toFixed(2);
				
			
		}
			total =parseFloat(sell1)-parseFloat(buy1);
			
			console.log("total"+total+" sell1:"+sell1);	
			
			
			}
						    	}
						    	$scope.joborder.sell1=sell1.toFixed(2);
								$scope.joborder.buy1=buy1.toFixed(2);
								$scope.joborder.total=total.toFixed(2);
								
							
								$scope.joborder.jobId=jobId;
								$scope.joborder.joborderTracking = data.lJobOrderBean[0].joborderTracking;
								$scope.joborder.joborderTrackingDtl = data.lJobOrderBean[0].joborderTrackingDtl;
								for (var i = 0; i < $scope.joborder.joborderTrackingDtl.length; i++) {
								$scope.joborder.joborderTrackingDtl[i].uom = $scope.joborder.joborderTrackingDtl[i].uom.toString();	
								$scope.joborder.joborderTrackingDtl[i].sizeType = $scope.joborder.joborderTrackingDtl[i].sizeType.toString();
								
								}
								$http.post($stateParams.tenantid+'/app/seaquotation/getcommodity').success(function(data) { 
						              $scope.commodityList = data.commonUtilityBean;
						           	 $scope.compaccList = [];
						           	 var valArr = $scope.joborder.commodity.split(',');
						           	 var i = 0, size = valArr.length;
						           	 for (i; i < size; i++) {
						           	// $("#port").find("option[label=" + valArr[i] + "]").prop("selected", "selected");
						           	 angular.forEach($scope.commodityList, function(value, key) {
						           	 if (valArr[i] == value.id) {
						           	 $scope.compaccList.push(value);
						           	 }
						           	 });
						           	  
						           	 }
						             $scope.joborder.commodityL = $scope.compaccList;

						           //	$scope.EmployeeMasterData.accessCat = $scope.compaccList;
						           	 $timeout(function() { 
						           		 $("#commodityL").multiselect('destroy');
						           	 $("#commodityL").multiselect({
						           	 maxHeight : 400,
						           	 includeSelectAllOption : true,
						           	 selectAllText : 'Select All',
						           	 enableFiltering : true,
						           	 enableCaseInsensitiveFiltering : true,
						           	 filterPlaceholder : 'Search',
						           	 numberDisplayed: 1,
						           	 });
						           	 }, 3, false);
						           	 $("#multiselect-button").addClass("width_100 input-sm line-height-5");
						           	 
						           	
						           	 
						           	 });
							});
					$scope.dropdown();
					
				 
					}
					}
					$scope.getEdit();
					
					if($scope.edit == true){
					$scope.ratevalues= function(){
						var buy1 =0;
						var sell=0;
						var sell1 =0;
						var amount =0;

						var total =0; 
				    	if($scope.joborder.joborderDtl.length != null ||$scope.joborder.joborderDtl.length != undefined ||$scope.joborder.joborderDtl.length != "" ||$scope.joborder.joborderDtl.length != ''){
{
	for( var i=0;i<=$scope.joborder.joborderDtl.length-1;i++)
{
		

		var amount1=[];
		var amount=[];
		if(($scope.joborder.joborderDtl[i].transactionType != null ) || ($scope.joborder.joborderDtl[i].transactionType != undefined ) ||($scope.joborder.joborderDtl[i].transactionType != "" ) ||($scope.joborder.joborderDtl[i].transactionType != '' ))
{
			if($scope.joborder.joborderDtl[i].transactionType =="1")
{
				
				if(($scope.joborder.joborderDtl[i].quantity  != null || $scope.joborder.joborderDtl[i].quantity != undefined ||$scope.joborder.joborderDtl[i].quantity !="" ||$scope.joborder.joborderDtl[i].quantity != '') &&  ($scope.joborder.joborderDtl[i].rate  != null || $scope.joborder.joborderDtl[i].rate != undefined ||$scope.joborder.joborderDtl[i].rate != " " ||$scope.joborder.joborderDtl[i].rate != '') && ($scope.joborder.joborderDtl[i].exRate  != null || $scope.joborder.joborderDtl[i].exRate == undefined ||$scope.joborder.joborderDtl[i].exRate !="" ||$scope.joborder.joborderDtl[i].exRate != '') )
				{
				amount1[i] = (parseFloat(($scope.joborder.joborderDtl[i].quantity)) * parseFloat(($scope.joborder.joborderDtl[i].rate))*parseFloat(($scope.joborder.joborderDtl[i].exRate)));
				$scope.joborder.joborderDtl[i].amount=parseInt(amount1[i]);

				
			
				buy1=parseFloat(buy1)+parseFloat($scope.joborder.joborderDtl[i].amount);
				console.log("i:"+i+" buy1:"+buy1);
				
				}
}	
			
			else {
				if($scope.joborder.joborderDtl[i].transactionType =="2")
				{
								
								if(($scope.joborder.joborderDtl[i].quantity  != null || $scope.joborder.joborderDtl[i].quantity != undefined ||$scope.joborder.joborderDtl[i].quantity !="" ||$scope.joborder.joborderDtl[i].quantity != '') &&  ($scope.joborder.joborderDtl[i].rate  != null || $scope.joborder.joborderDtl[i].rate != undefined ||$scope.joborder.joborderDtl[i].rate != " " ||$scope.joborder.joborderDtl[i].rate != '') && ($scope.joborder.joborderDtl[i].exRate  != null || $scope.joborder.joborderDtl[i].exRate == undefined ||$scope.joborder.joborderDtl[i].exRate !="" ||$scope.joborder.joborderDtl[i].exRate != '') )
								{
								amount1[i] = (parseFloat(($scope.joborder.joborderDtl[i].quantity)) * parseFloat(($scope.joborder.joborderDtl[i].rate))*parseFloat(($scope.joborder.joborderDtl[i].exRate)));
								$scope.joborder.joborderDtl[i].amount=parseFloat(amount1[i]);

								sell1=parseFloat(sell1)+parseFloat($scope.joborder.joborderDtl[i].amount);
								console.log("i:"+i+" sell1:"+sell1);
								}
				}	
			}
			
			
			

}

		$scope.joborder.joborderDtl[i].amount=parseFloat(amount1[i]).toFixed(2);
		
	
}
	total =parseFloat(sell1)-parseFloat(buy1);
	
	console.log("total"+total+" sell1:"+sell1);	
	
	
	}
				    	}
				    	$scope.joborder.sell1=sell1.toFixed(2);
						$scope.joborder.buy1=buy1.toFixed(2);
						$scope.joborder.total=total.toFixed(2);
						
					}
			
				}
					
		//total calculation for debit and credit amt
					
					
		
//							if($scope.edit == true){
//							var buy2 =0;
//							var sell2 =0;
//							var amount2 =0;
//
//			                var total2 =0; 
//			                
//			                
//					    	if($scope.joborder.joborderDtl1.length != null ||$scope.joborder.joborderDtl1.length != undefined ||$scope.joborder.joborderDtl1.length != "" ||$scope.joborder.joborderDt11.length != ''){
//	{
//		for( var i=0;i<=$scope.joborder.joborderDtl1.length-1;i++)
//	{
//			
//
//			var amount2=[];
//			var amount=[];
//			
//			if(($scope.joborder.joborderDtl1[i].transactionType != null ) || ($scope.joborder.joborderDtl1[i].transactionType != undefined ) ||($scope.joborder.joborderDtl1[i].transactionType != "" ) ||($scope.joborder.joborderDtl1[i].transactionType != '' ))
//	{
//				if($scope.joborder.joborderDtl[i].transactionType =="1")
//	{
//					
//					if(($scope.joborder.joborderDtl1[i].quantity  != null || $scope.joborder.joborderDtl1[i].quantity != undefined ||$scope.joborder.joborderDtl1[i].quantity !="" ||$scope.joborder.joborderDtl1[i].quantity != '') &&  ($scope.joborder.joborderDtl1[i].rate  != null || $scope.joborder.joborderDtl1[i].rate != undefined ||$scope.joborder.joborderDtl[i].rate != " " ||$scope.joborder.joborderDtl1[i].rate != '') && ($scope.joborder.joborderDtl[i].exRate  != null || $scope.joborder.joborderDtl1[i].exRate == undefined ||$scope.joborder.joborderDtl1[i].exRate !="" ||$scope.joborder.joborderDtl1[i].exRate != '') )
//					{
//					amount2[i] = (parseFloat(($scope.joborder.joborderDtl1[i].quantity)) * parseFloat(($scope.joborder.joborderDtl1[i].rate))*parseFloat(($scope.joborder.joborderDtl1[i].exRate)));
//					$scope.joborder.joborderDtl1[i].amount=parseInt(amount2[i]);
//
//					
//				
//					buy2=parseFloat(buy2)+parseFloat($scope.joborder.joborderDtl1[i].amount);
//					console.log("i:"+i+" buy1:"+buy2);
//					
//					}
//	}	
//				
//				else {
//					if($scope.joborder.joborderDtl1[i].transactionType =="2")
//					{
//									
//									if(($scope.joborder.joborderDtl1[i].quantity  != null || $scope.joborder.joborderDtl1[i].quantity != undefined ||$scope.joborder.joborderDtl1[i].quantity !="" ||$scope.joborder.joborderDtl1[i].quantity != '') &&  ($scope.joborder.joborderDtl1[i].rate  != null || $scope.joborder.joborderDtl1[i].rate != undefined ||$scope.joborder.joborderDtl1[i].rate != " " ||$scope.joborder.joborderDtl1[i].rate != '') && ($scope.joborder.joborderDtl1[i].exRate  != null || $scope.joborder.joborderDtl1[i].exRate == undefined ||$scope.joborder.joborderDtl1[i].exRate !="" ||$scope.joborder.joborderDtl1[i].exRate != '') )
//									{
//									amount2[i] = (parseFloat(($scope.joborder.joborderDtl1[i].quantity)) * parseFloat(($scope.joborder.joborderDtl1[i].rate))*parseFloat(($scope.joborder.joborderDtl1[i].exRate)));
//									$scope.joborder.joborderDtl[i].amount=parseFloat(amount1[i]);
//
//									sell2=parseFloat(sell1)+parseFloat($scope.joborder.joborderDtl1[i].amount);
//									console.log("i:"+i+" sell1:"+sell1);
//									}
//					}	
//				}
//				
//				
//				
//
//	}
//
//			$scope.joborder.joborderDtl1[i].amount=parseFloat(amount2[i]).toFixed(2);
//			
//		
//	}
//		total2 =parseFloat(sell2)-parseFloat(buy2);
//		
//		console.log("total"+total+" sell1:"+sell2);	
//		
//		
//		}
//					    	}
//					    	$scope.joborder.sell2=sell2.toFixed(2);
//							$scope.joborder.buy2=buy2.toFixed(2);
//							$scope.joborder.total2=total2.toFixed(2);
//							
//						}
//			
					
					
		//end total calculation for debit and credit amt
					
					
					
					$scope.allowUpdate = function(joborder) {	
						 
						$scope.joborder=joborder;
				         ngDialog.open({
				             scope : $scope,
				             template : 'views/sea/allowUpdatePopup.jsp',
				             controller : $controller('allowCtrl', {
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
					
					
					if($scope.edit == true){
					$scope.submitupdate = function() {
						$scope.invoice = false;
						$scope.pending = false;
						
						for(var i=0;i<=$scope.joborder.joborderDtl.length-1;i++)
							{
							if($scope.joborder.joborderDtl[i].status == "2" )
								{
								$scope.invoice = true;
								}else{
									$scope.pending = true;
								}
							}
						console.log($scope.pending);
						console.log($scope.joborder);
						var msg = $scope.checkValidation();
						if (!$scope.checkundefined(msg)) {
							logger.logError(msg);
						} else {
							if($scope.joborder.joborderDtl.length>0){
								if($scope.Add == true){
									if($scope.joborder.joborderTrackingDtl.length>0){
										
										
										var temp=$scope.joborder.searemarks;
										if($scope.joborder.remarks1!=null&&$scope.joborder.remarks1!=""){
										$scope.joborder.remarks1=temp+'\n '+todate+' '+time+ '     ' +  '     ' +$scope.joborder.remarks1;
										}
									$scope.joborder.deleteIds	=$scope.deleteIds;
									var commodity='';
						        	angular.forEach($scope.joborder.commodityL, function(item, index) {
					                	if(commodity!=null && commodity!=''){
					                    	commodity=commodity+','+item.id;
				                      }else{
					                    	commodity=item.id;
					                	}
					                	
					                })
					               $scope.joborder.commodity=commodity;
						        	var checkPack=true,checkPack1=true;var i=1,j=1;var msg=''; var checkPackcon=true;
						        	angular.forEach($scope.joborder.joborderTrackingDtl, function(val, index) {
						        	if(val.containerNo==undefined || val.containerNo==null ||     val.containerNo==''){
						        		checkPackcon=false;
										msg=msg+" Row "+i+" containerNo is Required! ";
							        	}
						        	if(val.sizeType==undefined || val.sizeType==null ||     val.sizeType==''){
						        		checkPackcon=false;
										msg=msg+" Row "+i+" container size Type is Required! ";
							        	}
						        	if(val.cargoDescription==undefined || val.cargoDescription==null ||     val.cargoDescription==''){
						        		checkPackcon=false;
										msg=msg+" Row "+i+" Cargo Description is Required! ";
							        	}
						        	i++;
						        	
								})
								



angular.forEach($scope.joborder.joborderDtl, function(val, index) {
						        	if(val.quantity==undefined || val.quantity==null ||  val.quantity=='' ||  val.quantity=='0' ){
						        		checkPack1=false;
									msg=msg+" Row "+j+" Quantity is Required! ";
									j++;
						        	}
								})
								if(checkPack==true && checkPack1==true && checkPackcon==true){
									$http.post($stateParams.tenantid + '/app/jobOrderSeaApp/ckeckConCount', $scope.joborder).success(function(datas) {
										if(datas.succ==true){
						        	if($scope.joborder.mode!='5'){
								$http.post($stateParams.tenantid + '/app/jobOrderSeaApp/update',
										$scope.joborder).success(function(datas) {
									
									if (datas.success == true) {
										logger.logSuccess(datas.message);
										$location.url($stateParams.tenantid
												+ '/jobOrderSeaApp/edit?rowid=' + datas.jobHdrId);
										$scope.getEdit();
										
									} else {
										logger.logError(datas.message);
									}
								}).error(function(data) {
									logger.logError("Please try again");
								});
						        	}else{

										
											$http.post($stateParams.tenantid + '/app/jobOrderSeaApp/update',
													$scope.joborder).success(function(datas) {
												
												if (datas.success == true) {
													logger.logSuccess(datas.message);
													$location.url($stateParams.tenantid
															+ '/jobOrderSeaApp/edit?rowid=' + datas.jobHdrId);
													$scope.getEdit();
													
												} else {
													logger.logError(datas.message);
												}
											}).error(function(data) {
												logger.logError("Please try again");
											});
									        			
										
									
						        	}
										}else{
											$scope.allowUpdate($scope.joborder);
										}
										})}else{
										logger.logError(msg);
									} 
									}else{
										logger.logError("Atleast One Row Required in Cargo Details");
									}
								}
								else if($scope.pending == false && $scope.Add==false)
									{

									if($scope.joborder.joborderTrackingDtl.length>0){
										
										
										var temp=$scope.joborder.searemarks;
										if($scope.joborder.remarks1!=null&&$scope.joborder.remarks1!=""){
										$scope.joborder.remarks1=temp+'\n '+todate+' '+time+ '     ' +  '     ' +$scope.joborder.remarks1;
										}
										
								$http.post($stateParams.tenantid + '/app/jobOrderSeaApp/update',
										$scope.joborder).success(function(datas) {
									
									if (datas.success == true) {
										logger.logSuccess(datas.message);
										$location.url($stateParams.tenantid
												+ '/jobOrderSeaApp/edit?rowid=' + datas.jobHdrId);
										$scope.getEdit();
										
									} else {
										logger.logError(datas.message);
									}
								}).error(function(data) {
									logger.logError("Please try again");
								});
									}else{
										logger.logError("Atleast One Row Required in Cargo Details");
									}
								
									}
								else if($scope.pending == true && $scope.Add==false){
									logger.logError(" Some invoices are Pending / Draft ");
								}
								
							}
							else{
								logger.logError("Atleast One Row Required");
							}
						}

					}}
					$scope.submitApprove = function() {
						$scope.invoice = false;
						$scope.pending = false;
						
						for(var i=0;i<=$scope.joborder.joborderDtl.length-1;i++)
							{
							if($scope.joborder.joborderDtl[i].status == "2" )
								{
								$scope.invoice = true;
								}else{
									$scope.pending = true;
								}
							}
						console.log($scope.pending);
						console.log($scope.joborder);
						var msg = $scope.checkValidation();
						if (!$scope.checkundefined(msg)) {
							logger.logError(msg);
						} else {
							if($scope.joborder.joborderDtl.length>0){
								if($scope.Add == true){
									if($scope.joborder.joborderTrackingDtl.length>0){
										
										
										var temp=$scope.joborder.searemarks;
										if($scope.joborder.remarks1!=null&&$scope.joborder.remarks1!=""){
										$scope.joborder.remarks1=temp+'\n '+todate+' '+time+ '     ' +  '     ' +$scope.joborder.remarks1;
										}
									$scope.joborder.deleteIds	=$scope.deleteIds;
									var commodity='';
						        	angular.forEach($scope.joborder.commodityL, function(item, index) {
					                	if(commodity!=null && commodity!=''){
					                    	commodity=commodity+','+item.id;
				                      }else{
					                    	commodity=item.id;
					                	}
					                	
					                })
					               $scope.joborder.commodity=commodity;
						        	var checkPack=true,checkPack1=true;var i=1,j=1;var msg=''; var checkPackcon=true;
						        	angular.forEach($scope.joborder.joborderTrackingDtl, function(val, index) {
						        	if(val.containerNo==undefined || val.containerNo==null ||     val.containerNo==''){
						        		checkPackcon=false;
										msg=msg+" Row "+i+" containerNo is Required! ";
							        	}
						        	if(val.sizeType==undefined || val.sizeType==null ||     val.sizeType==''){
						        		checkPackcon=false;
										msg=msg+" Row "+i+" container size Type is Required! ";
							        	}
						        	if(val.cargoDescription==undefined || val.cargoDescription==null ||     val.cargoDescription==''){
						        		checkPackcon=false;
										msg=msg+" Row "+i+" Cargo Description is Required! ";
							        	}
						        	i++;
						        	
								})
								



angular.forEach($scope.joborder.joborderDtl, function(val, index) {
						        	if(val.quantity==undefined || val.quantity==null ||  val.quantity=='' ||  val.quantity=='0' ){
						        		checkPack1=false;
									msg=msg+" Row "+j+" Quantity is Required! ";
									j++;
						        	}
								})
								if(checkPack==true && checkPack1==true && checkPackcon==true){
						        	if($scope.joborder.mode!='5'){
								$http.post($stateParams.tenantid + '/app/jobOrderSeaApp/updateApprove',
										$scope.joborder).success(function(datas) {
									
									if (datas.success == true) {
										logger.logSuccess(datas.message);
									//	$location.url($stateParams.tenantid
										//		+ '/jobOrderSeaApp/edit?rowid=' + datas.jobHdrId);
									//	$scope.getEdit();
										$state.go('app.sea.joborderApp.list',{tenantid:$stateParams.tenantid});

									} else {
										logger.logError(datas.message);
									}
								}).error(function(data) {
									logger.logError("Please try again");
								});
						        	}else{

										$http.post($stateParams.tenantid + '/app/jobOrderSeaApp/ckeckConCount', $scope.joborder).success(function(datas) {
										if(datas.succ==true){
											$http.post($stateParams.tenantid + '/app/jobOrderSeaApp/updateApprove',
													$scope.joborder).success(function(datas) {
												
												if (datas.success == true) {
													logger.logSuccess(datas.message);
												//	$location.url($stateParams.tenantid
												//			+ '/jobOrderSeaApp/edit?rowid=' + datas.jobHdrId);
												//	$scope.getEdit();
													$state.go('app.sea.joborderApp.list',{tenantid:$stateParams.tenantid});
	
												} else {
													logger.logError(datas.message);
												}
											}).error(function(data) {
												logger.logError("Please try again");
											});
									        			
										}else{
											$scope.allowUpdate($scope.joborder);
										}
										})
									
						        	}
									}else{
										logger.logError(msg);
									} 
									}else{
										logger.logError("Atleast One Row Required in Cargo Details");
									}
								}
								else if($scope.pending == false && $scope.Add==false)
									{

									if($scope.joborder.joborderTrackingDtl.length>0){
										
										
										var temp=$scope.joborder.searemarks;
										if($scope.joborder.remarks1!=null&&$scope.joborder.remarks1!=""){
										$scope.joborder.remarks1=temp+'\n '+todate+' '+time+ '     ' +  '     ' +$scope.joborder.remarks1;
										}
										
								$http.post($stateParams.tenantid + '/app/jobOrderSeaApp/updateApprove',
										$scope.joborder).success(function(datas) {
									
									if (datas.success == true) {
										//logger.logSuccess(datas.message);
										//$location.url($stateParams.tenantid
										//		+ '/jobOrderSeaApp/edit?rowid=' + datas.jobHdrId);
										//$scope.getEdit();
										$state.go('app.sea.joborderApp.list',{tenantid:$stateParams.tenantid});

									} else {
										logger.logError(datas.message);
									}
								}).error(function(data) {
									logger.logError("Please try again");
								});
									}else{
										logger.logError("Atleast One Row Required in Cargo Details");
									}
								
									}
								else if($scope.pending == true && $scope.Add==false){
									logger.logError(" Some invoices are Pending / Draft ");
								}
								
							}
							else{
								logger.logError("Atleast One Row Required");
							}
						}

					}
					   $scope.cancel=function(){
							$state.go('app.sea.joborderApp.list',{tenantid:$stateParams.tenantid});
						}
						
					   $scope.print1 = function(rowid) {
							
							var test = parseInt(rowid);
							var url = $stateParams.tenantid
									+ '/app/jobOrderAir/print1?rowid=' + rowid
							var wnd = window
									.open(
											url,
											'HISERP',
											'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
							wnd.print();

						};
								
						$scope.$watch('joborder.quotationNo', function(newValue,
								oldValue) {
							if(oldValue!=""){
								var qkLinkQuon=$scope.joborder.quotationNo;
								 $window.open('/#/'+$stateParams.tenantid+'/seaQuotation/view?qkLinkQuon='+qkLinkQuon, '_blank');
							}
						});
						
						$http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(datas) {
							
							$scope.conTypeList=datas.getcontypelist;
							$scope.containerNoList=datas.getcontainer;
							
						}).error(function(datas) {

						});
						
						$http.get($stateParams.tenantid+ '/app/commonUtility/getVoyageList').success(function(data) {
	     					$scope.voyageList = data;
						});
						
						
						$scope.quickLinkMethd=function(jobId,qulkVal){
							if(qulkVal!='Select'){
							$http.post($stateParams.tenantid + '/app/jobOrderSeaApp/quickLinkView?category='+qulkVal+'&jobId='+jobId).success(function(datas) {
										if(datas.quickLinkId!=null){
											var rowid=datas.quickLinkId;
											if(qulkVal=="HBL"){
												if(rowid !=0){
													$location.url($stateParams.tenantid+'/hbl/edit?rowid='+rowid); 
												//	$window.open('#'+$stateParams.tenantid+'/hbl/view?rowid='+rowid, '_blank');	
												}else{
													logger.logError("There is no "+qulkVal);
												}
											}else if(qulkVal=="MBL"){
												if(rowid !=0){
													$location.url($stateParams.tenantid+'/mabl/edit?rowid='+rowid); 
													//$window.open('#'+$stateParams.tenantid+'/mabl/view?rowid='+rowid,'_blank');	
												}else{
													logger.logError("There is no "+qulkVal);
												}
											}else if(qulkVal=="Delivery Order"){
												if(rowid !=0){
													$location.url($stateParams.tenantid+'/deliveryorder/edit?rowid='+rowid); 
													//$window.open('#'+$stateParams.tenantid+'/deliveryorder/view?rowid='+rowid,'_blank');	
												}else{
													logger.logError("There is no "+qulkVal);
												}
											}else if(qulkVal=="Sales Invoice"){
												if(rowid !=0){
													$location.url($stateParams.tenantid+'/invoice/seasalesinvoice/salesInvoiceView'+rowid); 
													//$window.open('#'+$stateParams.tenantid+"/invoice/seasalesinvoice/salesInvoiceView/"+rowid,'_blank');	
												}else{
													logger.logError("There is no "+qulkVal);
												}
											}else if(qulkVal=="Purchase Invoice"){
												if(rowid !=0){
													$location.url($stateParams.tenantid+'/invoice/seapurchaseinvoice/PurchaseInvoiceView'+rowid);
													//$window.open('#'+$stateParams.tenantid+"/invoice/seapurchaseinvoice/PurchaseInvoiceView/"+rowid,'_blank');	
												}else{
													logger.logError("There is no "+qulkVal);
												}
											}
										}
										
										else if(datas.quickLinkIdList!=null){
											var quickLinkIdList=datas.quickLinkIdList
											if(qulkVal=="HBL"){
												//$window.open('#'+$stateParams.tenantid+'/hbl/list?quickLinkIdList='+quickLinkIdList, '_blank');
												$location.url($stateParams.tenantid+'/hbl/list?quickLinkIdList='+quickLinkIdList);
											}else if(qulkVal=="MBL"){
												$location.url($stateParams.tenantid+'/mabl/list?quickLinkIdList='+quickLinkIdList);
												//$window.open('#'+$stateParams.tenantid+'/mabl/list?quickLinkIdList='+quickLinkIdList, '_blank');
											}else if(qulkVal=="Delivery Order"){
												$location.url($stateParams.tenantid+'/deliveryorder/list?quickLinkIdList='+quickLinkIdList);
												//$window.open('#'+$stateParams.tenantid+'/deliveryorder/list?quickLinkIdList='+quickLinkIdList, '_blank');
											}else if(qulkVal=="Sales Invoice"){
												$location.url($stateParams.tenantid+'/invoice/sea/seasalesinvoice/SalesInvoiceList?quickLinkIdList='+quickLinkIdList);
												//$window.open('#'+$stateParams.tenantid+'/invoice/sea/seasalesinvoice/SalesInvoiceList?quickLinkIdList='+quickLinkIdList,'_blank');
											}else if(qulkVal=="Purchase Invoice"){
												$location.url($stateParams.tenantid+'/invoice/sea/seapurchaseinvoice/PurchaseInvoiceList?quickLinkIdList='+quickLinkIdList);
												//$window.open('#'+$stateParams.tenantid+'/invoice/sea/seapurchaseinvoice/PurchaseInvoiceList?quickLinkIdList='+quickLinkIdList,'_blank');
											}
										}
										else if (datas.quickLinkId == null)
										{
											if(qulkVal=="HBL"){
												logger.logError("There is no "+qulkVal);
											}
											if(qulkVal=="MBL")
												{
												logger.logError("There is no "+qulkVal);
												}
										if(qulkVal=="Delivery Order")
											{
											$location.url($stateParams.tenantid+'/deliveryorder/add');
											}
										if(qulkVal=="Sales Invoice"){
											$location.url($stateParams.tenantid+'/invoice/sea/salesinvoice/SalesInvoiceAdd');
										}
										if(qulkVal=="Purchase Invoice"){
											$location.url($stateParams.tenantid+'/invoice/sea/purchaseinvoice/PurchaseInvoiceAdd');
										}
										}
										
							})
						}
						}
						 var defaultCurrency = '';
						 var  fromCurrency='';
						 var toCurrency='';
						 
							$scope.$watch('joborder.currency', function(newValue,
									oldValue) {
								if (newValue != '' && newValue != undefined) {
								    
								    $http
									.get(
											$stateParams.tenantid
													+ '/app/currency/getExchangeRate?currencyId='+parseInt(newValue))
									.success(
											function(data) {
												
//												if(!$scope.isEdit){
//													$scope.joborder.exRate = data.defaultCurrency;
//												}
												$scope.joborder.exRate = data.defaultCurrency;
												defaultCurrency = data.defaultCurrency;
												fromCurrency=data.fromCurrency;
												toCurrency=data.toCurrency;
												$scope.checkExRate();
											});
								}
								
							});
							
							$scope.checkExRate = function(){
								if($scope.joborder.exRate >= fromCurrency && $scope.joborder.exRate <= toCurrency){
									
								}
								else{
									//logger.logError("Exchange Rate Between "+fromCurrency+ " and " +toCurrency);
									$scope.joborder.exRate ='';
								}
							}
							$scope.CheckExRateDtl = function(currecny,index){
								if (currecny != '' && currecny != undefined) {
							    
							    $http
								.get(
										$stateParams.tenantid
												+ '/app/currency/getExchangeRate?currencyId='+parseInt(currecny))
								.success(
										function(data) {
											
											/*if(!$scope.isEdit){
												$scope.joborder.joborderDtl[$scope.trIndex].exRate = data.defaultCurrency;
											}*/
											
											defaultCurrency1 = data.defaultCurrency;
											fromCurrency1=data.fromCurrency;
											toCurrency1=data.toCurrency;
											$scope.checkExRate($scope.joborder.joborderDtl[index].exRate,index);
										});
							}
								$scope.ratevalues();
							}
				//remarks
						 $scope.remarks = function(accountHeadCode,jobNo){
					           
				               if(accountHeadCode !=""){
				                   ngDialog.open({
				                       scope : $scope,
				                       template : 'views/sea/seareamarks',
				                       controller : $controller('remarksCtrl', {
				                           $scope : $scope,
				                           purchaseObject : $scope.purchaseInvoiceData,
				                           accountHeadCode:accountHeadCode,
				                           jobNo:jobNo
				                       }),
				                       className : 'ngdialog-theme-plain',
				                       showClose : false,
				                       closeByDocument : false,
				                       closeByEscape : false,
				                       preCloseCallback : $scope.getList
				                   });
				               }else{
				                   logger.logError("");
				               }
				              
				           
				               
				       }

						
		
						
						 
						

				});

app.controller('remarksCtrl', function($scope, $rootScope,sharedProperties, 
        logger,$http,$filter, $location,$stateParams, validationService, toaster, $window,purchaseObject,ngDialog, $timeout,accountHeadCode,jobNo) {
    
	
             console.log($scope.joborder.searemarks);
             $scope.cancelng = function(){
     	        // $scope.purchaseInvoiceData.purInvDueDateDtls = [];
     	        ngDialog.close();
     	        if(purchaseObject.purInvDueDateDtls.length>0){
     	            
     	        }else{
     	            $scope.purchaseInvoiceData.purInvDueDateDtls = [];
     	        }
     	    }
	
});		
app.controller('jobtableCtrl', function($scope,$http, $filter,logger,$stateParams,$location){
	$scope.tenant =  $stateParams.tenantid;
	
   ;
   var jobId =   parseInt($location.search().rowid) ;
   if(jobId != '' && jobId != null){
	   $scope.isEdit=true;
   }
   else{
	   $scope.isEdit=false;
   }
    $scope.$watch('joborder.joborderDtl[trIndex].transactionType', function(newValue, oldValue) {
   ;
        if (newValue != '' && newValue != undefined) {
        	
			var buy1 =0;
			var sell=0;
			var sell1 =0;
			var amount =0;

			var total =0; 
	    	if($scope.joborder.joborderDtl.length != null ||$scope.joborder.joborderDtl.length != undefined ||$scope.joborder.joborderDtl.length != "" ||$scope.joborder.joborderDtl.length != ''){
{
for( var i=0;i<=$scope.joborder.joborderDtl.length-1;i++)
{


var amount1=[];
var amount=[];
if(($scope.joborder.joborderDtl[i].transactionType != null ) || ($scope.joborder.joborderDtl[i].transactionType != undefined ) ||($scope.joborder.joborderDtl[i].transactionType != "" ) ||($scope.joborder.joborderDtl[i].transactionType != '' ))
{
if($scope.joborder.joborderDtl[i].transactionType =="1")
{
	
	if(($scope.joborder.joborderDtl[i].quantity  != null || $scope.joborder.joborderDtl[i].quantity != undefined ||$scope.joborder.joborderDtl[i].quantity !="" ||$scope.joborder.joborderDtl[i].quantity != '') &&  ($scope.joborder.joborderDtl[i].rate  != null || $scope.joborder.joborderDtl[i].rate != undefined ||$scope.joborder.joborderDtl[i].rate != " " ||$scope.joborder.joborderDtl[i].rate != '') && ($scope.joborder.joborderDtl[i].exRate  != null || $scope.joborder.joborderDtl[i].exRate == undefined ||$scope.joborder.joborderDtl[i].exRate !="" ||$scope.joborder.joborderDtl[i].exRate != '') )
	{
	amount1[i] = (parseFloat(($scope.joborder.joborderDtl[i].quantity)) * parseFloat(($scope.joborder.joborderDtl[i].rate))*parseFloat(($scope.joborder.joborderDtl[i].exRate)));
	$scope.joborder.joborderDtl[i].amount=parseFloat(amount1[i]);

	

	buy1=parseFloat(buy1)+parseFloat($scope.joborder.joborderDtl[i].amount);
	console.log("i:"+i+" buy1:"+buy1);
	
	}
}	

else {
	if($scope.joborder.joborderDtl[i].transactionType =="2")
	{
					
					if(($scope.joborder.joborderDtl[i].quantity  != null || $scope.joborder.joborderDtl[i].quantity != undefined ||$scope.joborder.joborderDtl[i].quantity !="" ||$scope.joborder.joborderDtl[i].quantity != '') &&  ($scope.joborder.joborderDtl[i].rate  != null || $scope.joborder.joborderDtl[i].rate != undefined ||$scope.joborder.joborderDtl[i].rate != " " ||$scope.joborder.joborderDtl[i].rate != '') && ($scope.joborder.joborderDtl[i].exRate  != null || $scope.joborder.joborderDtl[i].exRate == undefined ||$scope.joborder.joborderDtl[i].exRate !="" ||$scope.joborder.joborderDtl[i].exRate != '') )
					{
					amount1[i] = (parseFloat(($scope.joborder.joborderDtl[i].quantity)) * parseFloat(($scope.joborder.joborderDtl[i].rate))*parseFloat(($scope.joborder.joborderDtl[i].exRate)));
					$scope.joborder.joborderDtl[i].amount=parseFloat(amount1[i]);

					sell1=parseFloat(sell1)+parseFloat($scope.joborder.joborderDtl[i].amount);
					console.log("i:"+i+" sell1:"+sell1);
					}
	}	
}




}

$scope.joborder.joborderDtl[i].amount=parseFloat(amount1[i]).toFixed(2);


}
total =parseFloat(sell1)-parseFloat(buy1);

console.log("total"+total+" sell1:"+sell1);	


}
	    	}
	    	$scope.joborder.sell1=sell1.toFixed(2);
			$scope.joborder.buy1=buy1.toFixed(2);
			$scope.joborder.total=total.toFixed(2);
			
			$scope.joborder.sell2=sell1.toFixed(2);
			$scope.joborder.buy2=buy1.toFixed(2);
			$scope.joborder.total2=total.toFixed(2);
			
			
			var id = newValue;
			/*$http.get($stateParams.tenantid+'/app/seaquotation/getServicePartnerList').success(function(datas) {
				console.log(datas);				
				 $scope.serviceParnrDropList=datas.serviceParnrList;
			  
			}).error(function(data) {

			});*/
			
        
        }  
        });
    //calculate debit credit
    $scope.$watch('joborder.joborderDtl1[trIndex].transactionType', function(newValue, oldValue) {
    	   ;
    	        if (newValue != '' && newValue != undefined) {
    	        	
    				var buy1 =0;
    				var sell=0;
    				var sell1 =0;
    				var amount =0;

    				var total =0; 
    		    	if($scope.joborder.joborderDtl1.length != null ||$scope.joborder.joborderDtl1.length != undefined ||$scope.joborder.joborderDtl1.length != "" ||$scope.joborder.joborderDtl1.length != ''){
    	{
    	for( var i=0;i<=$scope.joborder.joborderDtl1.length-1;i++)
    	{


    	var amount1=[];
    	var amount=[];
    	if(($scope.joborder.joborderDtl1[i].transactionType != null ) || ($scope.joborder.joborderDtl1[i].transactionType != undefined ) ||($scope.joborder.joborderDtl1[i].transactionType != "" ) ||($scope.joborder.joborderDtl1[i].transactionType != '' ))
    	{
    	if($scope.joborder.joborderDtl1[i].transactionType =="1")
    	{
    		
    		if(($scope.joborder.joborderDtl1[i].quantity  != null || $scope.joborder.joborderDtl1[i].quantity != undefined ||$scope.joborder.joborderDtl1[i].quantity !="" ||$scope.joborder.joborderDtl1[i].quantity != '') &&  ($scope.joborder.joborderDtl1[i].rate  != null || $scope.joborder.joborderDtl1[i].rate != undefined ||$scope.joborder.joborderDtl1[i].rate != " " ||$scope.joborder.joborderDtl1[i].rate != '') && ($scope.joborder.joborderDtl1[i].exRate  != null || $scope.joborder.joborderDtl1[i].exRate == undefined ||$scope.joborder.joborderDtl1[i].exRate !="" ||$scope.joborder.joborderDtl1[i].exRate != '') )
    		{
    		amount1[i] = (parseFloat(($scope.joborder.joborderDtl1[i].quantity)) * parseFloat(($scope.joborder.joborderDtl1[i].rate))*parseFloat(($scope.joborder.joborderDtl1[i].exRate)));
    		$scope.joborder.joborderDtl1[i].amount=parseFloat(amount1[i]);

    		

    		buy1=parseFloat(buy1)+parseFloat($scope.joborder.joborderDtl1[i].amount);
    		console.log("i:"+i+" buy1:"+buy1);
    		
    		}
    	}	

    	else {
    		if($scope.joborder.joborderDtl1[i].transactionType =="2")
    		{
    						
    						if(($scope.joborder.joborderDtl1[i].quantity  != null || $scope.joborder.joborderDtl1[i].quantity != undefined ||$scope.joborder.joborderDtl1[i].quantity !="" ||$scope.joborder.joborderDtl1[i].quantity != '') &&  ($scope.joborder.joborderDtl1[i].rate  != null || $scope.joborder.joborderDtl1[i].rate != undefined ||$scope.joborder.joborderDtl1[i].rate != " " ||$scope.joborder.joborderDtl1[i].rate != '') && ($scope.joborder.joborderDtl1[i].exRate  != null || $scope.joborder.joborderDtl1[i].exRate == undefined ||$scope.joborder.joborderDtl1[i].exRate !="" ||$scope.joborder.joborderDtl1[i].exRate != '') )
    						{
    						amount1[i] = (parseFloat(($scope.joborder.joborderDtl1[i].quantity)) * parseFloat(($scope.joborder.joborderDtl1[i].rate))*parseFloat(($scope.joborder.joborderDtl1[i].exRate)));
    						$scope.joborder.joborderDtl1[i].amount=parseFloat(amount1[i]);

    						sell1=parseFloat(sell1)+parseFloat($scope.joborder.joborderDtl1[i].amount);
    						console.log("i:"+i+" sell1:"+sell1);
    						}
    		}	
    	}




    	}

    	$scope.joborder.joborderDtl1[i].amount=parseFloat(amount1[i]).toFixed(2);


    	}
    	total =parseFloat(sell1)-parseFloat(buy1);

    	console.log("total"+total+" sell1:"+sell1);	


    	}
    		    	}
    		    	$scope.joborder.sell2=parseFloat(sell1.toFixed(2)) + parseFloat($scope.joborder.sell1);
    				$scope.joborder.buy2=parseFloat(buy1.toFixed(2)) + parseFloat($scope.joborder.buy1);
    				$scope.joborder.total2=parseFloat(total.toFixed(2)) + parseFloat($scope.joborder.total);
    			
   
    				var id = newValue;
    				/*$http.get($stateParams.tenantid+'/app/seaquotation/getServicePartnerList').success(function(datas) {
    					console.log(datas);				
    					 $scope.serviceParnrDropList=datas.serviceParnrList;
    				  
    				}).error(function(data) {

    				});*/
    				
    	        
    	        }  
    	         });
    //end calculate debit credit
    
    
	 var defaultCurrency1 = '';
	 var  fromCurrency1='';
	 var toCurrency1='';
    
    $scope.$watch('joborder.joborderDtl[trIndex].currency', function(newValue, oldValue) {
		if (newValue != '' && newValue != undefined) {
		    
		    $http.get($stateParams.tenantid+ '/app/currency/getExchangeRate?currencyId='+parseInt(newValue))
			.success(
					function(data) {
						
					/*	if(!$scope.isEdit){*/
							$scope.joborder.joborderDtl[$scope.trIndex].exRate = data.defaultCurrency;
					/*	}*/
						
					/*	defaultCurrency1 = data.defaultCurrency;
						fromCurrency1=data.fromCurrency;
						toCurrency1=data.toCurrency;
						$scope.checkExRate($scope.joborder.joborderDtl[$scope.trIndex].exRate,$scope.trIndex);
						$scope.ratevalues();*/
					});
		}
		
	});
    
    
    
    
    
    
    
    
    $scope.ratevalues = function() {
		var buy1 = 0;
		var sell = 0;
		var sell1 = 0;
		var amount = 0;

		var total = 0;
		if ($scope.joborder.joborderDtl.length != null
				|| $scope.joborder.joborderDtl.length != undefined
				|| $scope.joborder.joborderDtl.length != ""
				|| $scope.joborder.joborderDtl.length != '') {
			{
				for (var i = 0; i <= $scope.joborder.joborderDtl.length - 1; i++) {

					var amount1 = [];
					var amount = [];
					if (($scope.joborder.joborderDtl[i].transactionType != null)
							|| ($scope.joborder.joborderDtl[i].transactionType != undefined)
							|| ($scope.joborder.joborderDtl[i].transactionType != "")
							|| ($scope.joborder.joborderDtl[i].transactionType != '')) {
						if ($scope.joborder.joborderDtl[i].transactionType == "1") {

							if (($scope.joborder.joborderDtl[i].quantity != null
									|| $scope.joborder.joborderDtl[i].quantity != undefined
									|| $scope.joborder.joborderDtl[i].quantity != "" || $scope.joborder.joborderDtl[i].quantity != '')
									&& ($scope.joborder.joborderDtl[i].rate != null
											|| $scope.joborder.joborderDtl[i].rate != undefined
											|| $scope.joborder.joborderDtl[i].rate != " " || $scope.joborder.joborderDtl[i].rate != '')
									&& ($scope.joborder.joborderDtl[i].exRate != null
											|| $scope.joborder.joborderDtl[i].exRate == undefined
											|| $scope.joborder.joborderDtl[i].exRate != "" || $scope.joborder.joborderDtl[i].exRate != '')) {
								amount1[i] = (parseFloat(($scope.joborder.joborderDtl[i].quantity))
										* parseFloat(($scope.joborder.joborderDtl[i].rate)) * parseFloat(($scope.joborder.joborderDtl[i].exRate)));
								$scope.joborder.joborderDtl[i].amount = parseFloat(amount1[i]);

								buy1 = parseFloat(buy1)
										+ parseFloat($scope.joborder.joborderDtl[i].amount);
								console.log("i:" + i + " buy1:"
										+ buy1);

							}
						}

						else {
							if ($scope.joborder.joborderDtl[i].transactionType == "2") {

								if (($scope.joborder.joborderDtl[i].quantity != null
										|| $scope.joborder.joborderDtl[i].quantity != undefined
										|| $scope.joborder.joborderDtl[i].quantity != "" || $scope.joborder.joborderDtl[i].quantity != '')
										&& ($scope.joborder.joborderDtl[i].rate != null
												|| $scope.joborder.joborderDtl[i].rate != undefined
												|| $scope.joborder.joborderDtl[i].rate != " " || $scope.joborder.joborderDtl[i].rate != '')
										&& ($scope.joborder.joborderDtl[i].exRate != null
												|| $scope.joborder.joborderDtl[i].exRate == undefined
												|| $scope.joborder.joborderDtl[i].exRate != "" || $scope.joborder.joborderDtl[i].exRate != '')) {
									amount1[i] = (parseFloat(($scope.joborder.joborderDtl[i].quantity))
											* parseFloat(($scope.joborder.joborderDtl[i].rate)) * parseFloat(($scope.joborder.joborderDtl[i].exRate)));
									$scope.joborder.joborderDtl[i].amount = parseFloat(amount1[i]);

									sell1 = parseFloat(sell1)
											+ parseFloat($scope.joborder.joborderDtl[i].amount);
									console
											.log("i:" + i
													+ " sell1:"
													+ sell1);
								}
							}
						}

					}

					$scope.joborder.joborderDtl[i].amount = parseFloat(amount1[i]).toFixed(2);

				}
				total = parseFloat(sell1) - parseFloat(buy1);

				console
						.log("total" + total + " sell1:"
								+ sell1);

			}
		}
		$scope.joborder.sell1 = sell1.toFixed(2);
		$scope.joborder.buy1 = buy1.toFixed(2);
		$scope.joborder.total = total.toFixed(2);
		
		$scope.joborder.sell2 = sell1.toFixed(2);
		$scope.joborder.buy2 = buy1.toFixed(2);
		$scope.joborder.total2 = total.toFixed(2);

	}
	
	$scope.checkExRate = function(exRate,trIndex){
		if(exRate >= fromCurrency1 && exRate <= toCurrency1){
			
		}
		else{
			//logger.logError("Exchange Rate Between "+fromCurrency1+ " and " +toCurrency1);
			$scope.joborder.joborderDtl[trIndex].exRate ='';
		}
	}

	$scope.CheckExRateDtl = function(currecny,index){
		if (currecny != '' && currecny != undefined) {
	    
	    $http
		.get(
				$stateParams.tenantid
						+ '/app/currency/getExchangeRate?currencyId='+parseInt(currecny))
		.success(
				function(data) {
					
					/*if(!$scope.isEdit){
						$scope.joborder.joborderDtl[$scope.trIndex].exRate = data.defaultCurrency;
					}*/
					
					defaultCurrency1 = data.defaultCurrency;
					fromCurrency1=data.fromCurrency;
					toCurrency1=data.toCurrency;
					$scope.checkExRate($scope.joborder.joborderDtl[index].exRate,index);
					$scope.ratevalues();
				});
	}
	}
	
    $scope.$watch('joborder.joborderTrackingDtl[trIndex1].noOfPackage', function(newValue, oldValue) {
    	var noOfPcs=0;
		for (var i = 0; i <= $scope.joborder.joborderTrackingDtl.length; i++) {
			if($scope.joborder.joborderTrackingDtl[i].noOfPackage==""){
				$scope.joborder.joborderTrackingDtl[i].noOfPackage=0;
				noOfPcs=parseInt($scope.joborder.joborderTrackingDtl[i].noOfPackage)+noOfPcs;
				$scope.joborder.joborderTracking.totalPcs=noOfPcs;
			}
			else{
				noOfPcs=parseInt($scope.joborder.joborderTrackingDtl[i].noOfPackage)+noOfPcs;
				$scope.joborder.joborderTracking.totalPcs=noOfPcs;
			}
			
			
		}
		
    })
     $scope.$watch('joborder.joborderTrackingDtl[trIndex1].netWeight', function(newValue, oldValue) {
					var noOfNet=0.0;
					for (var i = 0; i <= $scope.joborder.joborderTrackingDtl.length; i++) {
						if($scope.joborder.joborderTrackingDtl[i].netWeight==""){
							$scope.joborder.joborderTrackingDtl[i].netWeight=0.0;
							noOfNet=parseFloat($scope.joborder.joborderTrackingDtl[i].netWeight)+noOfNet;
							$scope.joborder.joborderTracking.totalNetWeight=noOfNet;
						}
						else{
							noOfNet=parseFloat($scope.joborder.joborderTrackingDtl[i].netWeight)+noOfNet;
							$scope.joborder.joborderTracking.totalNetWeight=noOfNet;
						}
						
						
					}
					
			    })
			     $scope.$watch('joborder.joborderTrackingDtl[trIndex1].grossWeight', function(newValue, oldValue) {
			    	 var noOfGross=0.0;
						for (var i = 0; i <= $scope.joborder.joborderTrackingDtl.length-1; i++) {
							if($scope.joborder.joborderTrackingDtl[i].grossWeight==""){
								$scope.joborder.joborderTrackingDtl[i].grossWeight=0.0;
								noOfGross=parseFloat($scope.joborder.joborderTrackingDtl[i].grossWeight)+noOfGross;
								$scope.joborder.joborderTracking.totalGrosssWeight=noOfGross;
							}
							else{
								noOfGross=parseFloat($scope.joborder.joborderTrackingDtl[i].grossWeight)+noOfGross;
								$scope.joborder.joborderTracking.totalGrosssWeight=noOfGross;
							}
							
							
						}	$scope.qty();
			    })
			    $scope.qty = function() {

						for (var i = 0; i <= $scope.joborder.joborderDtl.length - 1; i++) {
							var grossqty = 0;
							if ($scope.joborder.joborderDtl[i].unit == 2
									|| $scope.joborder.joborderDtl[i].unit == 3) {

								angular
										.forEach(
												$scope.joborder.joborderTrackingDtl,
												function(value, key) {
													if (value.uom == '3') {
														if (value.sizeType == $scope.joborder.joborderDtl[i].conType) {
															if (value.grossWeight != undefined
																	&& value.grossWeight != '') {

																grossqty = grossqty
																		+ value.grossWeight;
															}
														}
													}
												})
								$scope.joborder.joborderDtl[i].quantity = grossqty;
								$scope.joborder.joborderDtl[i].amount = $scope.joborder.joborderDtl[i].quantity
										* $scope.joborder.joborderDtl[i].rate
										* $scope.joborder.joborderDtl[i].exRate;
								$scope.ratevalues();

							}

						}

					}
	    $scope.$watchCollection('[joborder.joborderTrackingDtl[trIndex].sizeType,joborder.joborderDtl[trIndex].unit,joborder.joborderDtl[trIndex].conType]',function(newValue, oldValue) {
		   
		for( var i=0;i<=$scope.joborder.joborderDtl.length-1;i++)
		{
	 		var grossqty=0;
			if($scope.joborder.joborderDtl[i].unit==2 || $scope.joborder.joborderDtl[i].unit==3){
	   
				angular.forEach($scope.joborder.joborderTrackingDtl, function(value, key) {
	        		if(value.sizeType==$scope.joborder.joborderDtl[i].conType){
						if(value.grossWeight!=undefined && value.grossWeight!=''){

						grossqty=grossqty+value.grossWeight;
												
	        			
	        		}
					}
	        	})
	        	
	        	$scope.joborder.joborderDtl[i].quantity=grossqty;
	        	$scope.joborder.joborderDtl[i].amount=$scope.joborder.joborderDtl[i].quantity*$scope.joborder.joborderDtl[i].rate*$scope.joborder.joborderDtl[i].exRate;
	        	$scope.ratevalues();
	    		
	    		
	    	}
			
		 }


	});
			
    });

app.controller('allowCtrl', function($stateParams , $scope , $http, $location,logger, $state, $window,ngDialog) {
    debugger;
     
        
 
        $scope.close = function() {
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
        
        $scope.allowSaveJob=function(joborder){

    		
            $http.post($stateParams.tenantid + '/app/jobOrderSeaApp/save', joborder).success(function(datas) {
    	
    	if (datas.success == true) {
    		logger.logSuccess(datas.message);
    		 ngDialog.close();
    		$location.url($stateParams.tenantid
    				+ '/jobOrderSeaApp/edit?rowid=' + datas.jobHdrId);
    		if ($scope.createQuote) {
    		} else {
    		}

    	} else {
    		logger.logError(datas.message);
    	}
    }).error(function(data) {
    	logger.logError("Please try again");
    });
    	
    	
    	}
$scope.allowUpdateJob=function(joborder){
	$http.post($stateParams.tenantid + '/app/jobOrderSeaApp/update',
			$scope.joborder).success(function(datas) {
		
		if (datas.success == true) {
			logger.logSuccess(datas.message);
			ngDialog.close();
			$location.url($stateParams.tenantid
					+ '/jobOrderSeaApp/edit?rowid=' + datas.jobHdrId);
			$scope.getEdit();
			
		} else {
			logger.logError(datas.message);
		}
	}).error(function(data) {
		logger.logError("Please try again");
	});
    			
}
      

        
 
        $scope.close = function() {
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
        
        $scope.allowSaveJob=function(joborder){

    		
            $http.post($stateParams.tenantid + '/app/jobOrderSeaApp/save', joborder).success(function(datas) {
    	
    	if (datas.success == true) {
    		logger.logSuccess(datas.message);
    		 ngDialog.close();
    		$location.url($stateParams.tenantid
    				+ '/jobOrderSeaApp/edit?rowid=' + datas.jobHdrId);
    		if ($scope.createQuote) {
    		} else {
    		}

    	} else {
    		logger.logError(datas.message);
    	}
    }).error(function(data) {
    	logger.logError("Please try again");
    });
    	
    	
    	}
$scope.allowUpdateJob=function(joborder){
	$http.post($stateParams.tenantid + '/app/jobOrderSeaApp/update',
			$scope.joborder).success(function(datas) {
		
		if (datas.success == true) {
			logger.logSuccess(datas.message);
			ngDialog.close();
			$location.url($stateParams.tenantid
					+ '/jobOrderSeaApp/edit?rowid=' + datas.jobHdrId);
			$scope.getEdit();
			
		} else {
			logger.logError(datas.message);
		}
	}).error(function(data) {
		logger.logError("Please try again");
	});
    			
}
      
});
app.controller('addShipperCtrl', function($stateParams , $scope , $http, $location,logger, $state, $window,ngDialog) {
    debugger;
     
    $scope.cityList=[];
 
        $scope.close = function() {
            ngDialog.close();    
        };
        $http.post($stateParams.tenantid+'/app/master/servicepartner/dropDownList').success(function(data) {
          	if(data.success){
          		$scope.cityList=data.cityList;
          	}
          });
        
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
        
        $scope.allowSaveShip=function(joborder){

    		
            $http.post($stateParams.tenantid + '/app/jobOrderSeaApp/addShipper', joborder).success(function(datas) {
    	
    	if (datas.success == true) {
    		logger.logSuccess("Added Shipper Successfully!..");
    		 ngDialog.close();
    		 $http.get($stateParams.tenantid+'/app/jobOrderSeaApp/dropDownList').success(function(datas) {
					$scope.shipperDropList = datas.shipperSelectivityList;
    		 })
    	 		$scope.joborder.shipper=datas.code;

    	} else {
    		logger.logError(datas.message);
    	}
    }).error(function(data) {
    	logger.logError("Please try again");
    });
    	
    	
    	}
$scope.allowSaveConsig=function(joborder){

    		
            $http.post($stateParams.tenantid + '/app/jobOrderSeaApp/addConsignee', joborder).success(function(datas) {
    	
    	if (datas.success == true) {
    		logger.logSuccess("Added Shipper Successfully!..");
    		 ngDialog.close();
    		 $http.get($stateParams.tenantid+'/app/jobOrderSeaApp/dropDownList').success(function(datas) {
					$scope.consigneeDropList = datas.consigneeSelectivityList;
 		 })
 		$scope.joborder.consignee=datas.code;
    	} else {
    		logger.logError(datas.message);
    	}
    }).error(function(data) {
    	logger.logError("Please try again");
    });
    	
    	
    	}

      
});
app.controller('quotationApprovalCtrl', function($stateParams , $scope , $http, $location,logger, $state, $window,ngDialog) {
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
        
        $scope.approveQuote = function(quotationNew){

        	//approve
  	
        		$http.post($stateParams.tenantid+'/app/seaquotation/approveQuotation',quotationNew).success(function(datas) {
        			if(datas.success){
        		    logger.logSuccess("Approved Successfully!!!");
        		    ngDialog.close();  
        		    //$state.go('app.salesmarketing.quotationApproval.list',{tenantid:$stateParams.tenantid});
        			$state.go('app.sea.quotation.list',{tenantid:$stateParams.tenantid});
        			}else{
        				logger.logError(datas.message);
        			}
        			 
        		
        	
        	}).error(function(datas) {

        	});
        	
        	
        }
      
});