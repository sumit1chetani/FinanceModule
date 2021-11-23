
    'use strict';

    app.controller('loadingEntryCtrl', function($scope,$state,$http,ngDialog, $stateParams,logger,$location,$controller,
    		$injector, sharedProperties, toaster,$rootScope,validationService) {
    	
    	$scope.createTripflag = false;
    	$scope.createBookingflag = false;
    	$scope.createInoviceflag = false;
    	$scope.closeTripflag=false;
    	$scope.userId=$('#userId').val();
    	
    	//ng-model Name 
    	$scope.loadingEntry  = {
    			actionId : '',
    		    customer : '',
    			tripId : '',
    			truckId : '',
    			trailerId : '',
    			fromLocation : '',
    			toLocation : '',
    			tables : [],
    			tripId : [],					
    	}	
    	
    	
    	//if($scope.userId == 'E0001' || $scope.userId == 'E0002' || $scope.userId == 'E0093' || $scope.userId == 'E0007' || $scope.userId == 'E0004' 
    	//	|| $scope.userId == 'E0095' || $scope.userId == 'E0132' ){
    		$scope.actionList=[{
    			id : 1,
    			text : 'Create Trip',
    			
    		},{
    			id : 2,
    			text : 'Create Booking & Allocation',
    			
    		},{
    			id : 3,
    			text : 'Create Invoice',
    			
    		},{
    			id :4 ,
    			text : 'Close Trip',
    			
    		}]
    	//}
    	
    	/*else if($scope.userId == 'E0003'){
    		$scope.actionList=[{
    			id : 1,
    			text : 'Create Trip',
    			
    		},{
    			id : 2,
    			text : 'Create Booking & Allocation',
    			
    		}]
    	}*/
    	/*else if($scope.userId == 'E0050'){
    		$scope.actionList=[{
    			id : 1,
    			text : 'Create Trip',
    			
    		},{
    			id : 2,
    			text : 'Create Booking & Allocation',
    			
    		},{
    			id :4 ,
    			text : 'Close Trip',
    			
    		}]
    	}
    	
    	else if($scope.userId == 'E0012' ){
    		$scope.actionList=[{
    			id : 3,
    			text : 'Create Invoice',
    			
    		} ]
    	}
    	
    	else if(  $scope.userId == 'E0094'){
    		$scope.actionList=[{
    			id : 1,
    			text : 'Create Trip',
    			
    		},{
    			id : 2,
    			text : 'Create Booking & Allocation',
    			
    		},{
    			id :4 ,
    			text : 'Close Trip',
    			
    		},{
    			id : 3,
    			text : 'Create Invoice',
    			
    		} ]
    	}
    	
    	 */
    	$scope.tripCompleted ={
    			tripCompletedDate : '',
                tripId : []
    	}
    	
    	$scope.closeTrip = function(pending){	
    		$http.post($stateParams.tenantid + '/app/dailyLoadingEntry/closeTrip',pending).success(function(result) {
    		console.log("result"+ result);
    			$state.reload();
    			logger
    					.logSuccess("Updated successfully!");
    			ngDialog.close();
    	 
    	}).error(function(result) {
    console.log("data" + result);
    }); }
    	 $scope.$watch('loadingEntry.actionId', function(newValue, oldValue) {
    		 if(newValue !=null && newValue != ''){
    			 if(newValue == 1){
    				    $scope.createTripflag = true;
    					$scope.createBookingflag = false;
    					$scope.createInoviceflag = false;
    					$scope.closeTripflag = false;
    				 
    			 }else if(newValue == 2){
    				 	$scope.createTripflag = false;
    					$scope.createBookingflag = true;
    					$scope.createInoviceflag = false;
    					$scope.closeTripflag = false;
    					
    				 
    			 }else if(newValue == 3){
    				 
    				 	$scope.createTripflag = false;
    					$scope.createBookingflag = false;
    					$scope.createInoviceflag = true;
    					$scope.closeTripflag = false;
    					  $http.get(
    								$stateParams.tenantid
    										+ '/app/dailyLoadingEntry/getPendingTripList')
    								.success(function(datas) {
    									$scope.pendingTripList = datas;
    									 
    								}).error(function(datas) {
    									logger
    									.logError('Error!');
    								});
    			 }
    			 else if(newValue == 4){
    				 
    				 	$scope.createTripflag = false;
    					$scope.createBookingflag = false;
    					$scope.createInoviceflag = false;
    					$scope.closeTripflag = true;
    					
    					  $http.get(
    								$stateParams.tenantid
    										+ '/app/dailyLoadingEntry/getCloseTripList')
    								.success(function(datas) {
    									$scope.pendingTripList = datas;
    									 
    								}).error(function(datas) {
    									logger
    									.logError('Error!');
    								});
    					
    						 
    					/*  $http.get(
    								$stateParams.tenantid
    										+ '/app/dailyLoadingEntry/tripListByCloseDate')
    								.success(function(datas) {
    									$scope.tripCloseDateList = datas;
    									
    									 $timeout(function() { 
    							                
    							                $("#closeTrip").multiselect({
    							                    maxHeight: 400,
    							                    includeSelectAllOption: true,
    							                    selectAllText: 'Select All',
    							                    enableFiltering: true,
    							                    enableCaseInsensitiveFiltering: true,
    							                    filterPlaceholder: 'Search',
    							                    onChange: function(element, checked) {
    							                        debugger;
    							                      var tripCodes = "";
    							                      if($scope.tripCompleted.tripId.length>0){
    							                          angular.forEach($scope.tripCompleted.tripId, function (item, key) {
    							                              debugger;
    							                              if($scope.tripCompleted.tripId.length>0){
    							                                  debugger;
    							                                  if($scope.tripCompleted.tripId[key]!=undefined){
    							                                      
    							                                      var companyCode = item.id;
    							                                      
    							                                      if(tripCodes==""){
    							                                          tripCodes = item.id;
    							                                      }else{
    							                                          tripCodes +=","+ item.id;
    							                                      }       
    							                                      $scope.tripCompleted.tripCode = tripCodes;
    							                                  }                             
    							                              }                              
    							                          });
    							                      }else{
    							                          $scope.tripCompleted.tripCode = '';
    							                      }
    							                      console.log($scope.tripCompleted.tripCode);
    							                    }
    							                  });
    							                $("#closeTrip").parent().find('.btn-group #multiselect-button').addClass('width_100 input-sm line-height-5'); 
    							                
    							                }, 2, false);
    								}).error(function(datas) {
    								});*/
    			 }
    		 }
    		 
    		 
    	 })
    	 
     $scope.createInvoice={
    		 customerCode : ''
    	 }
    	
    	 $scope.$watch('loadingEntry.customer', function(newValue, oldValue) {

    		 if(newValue != "" && newValue != null){
    			 $scope.customerinvoicepopup.tripIdList=[];
      $http.get(
    			$stateParams.tenantid
    					+ '/app/dailyLoadingEntry/tripList?customer='+newValue)
    			.success(function(datas) {
    				
    				
    				$scope.tripList = datas;
    				
    				
    				
    				 $timeout(function() { 
    		                
    		                $("#txtGroupCode").multiselect({
    		                    maxHeight: 400,
    		                    includeSelectAllOption: true,
    		                    selectAllText: 'Select All',
    		                    enableFiltering: true,
    		                    enableCaseInsensitiveFiltering: true,
    		                    filterPlaceholder: 'Search',
    		                    onChange: function(element, checked) {
    		                        debugger;
    		                      var tripCodes = "";
    		                      if($scope.loadingEntry.tripId.length>0){
    		                          angular.forEach($scope.loadingEntry.tripId, function (item, key) {
    		                              debugger;
    		                              if($scope.loadingEntry.tripId.length>0){
    		                                  debugger;
    		                                  if($scope.loadingEntry.tripId[key]!=undefined){
    		                                      
    		                                      var companyCode = item.id;
    		                                      
    		                                      if(tripCodes==""){
    		                                          tripCodes = item.id;
    		                                      }else{
    		                                          tripCodes +=","+ item.id;
    		                                      }       
    		                                      $scope.loadingEntry.tripCode = tripCodes;
    		                                  }                             
    		                              }                              
    		                          });
    		                      }else{
    		                          $scope.loadingEntry.tripCode = '';
    		                      }
    		                      console.log($scope.loadingEntry.tripCode);
    		                    }
    		                  });
    		                $("#txtGroupCode").parent().find('.btn-group #multiselect-button').addClass('width_100 input-sm line-height-5'); 
    		                
    		                }, 2, false);
    			}).error(function(datas) {
    			});	
    		 }
    	 });
    	 
    	$scope.$watch('createInvoice.customerCode', function(newValue, oldValue) {
    		 $http.get(
    					$stateParams.tenantid
    							+ '/app/dailyLoadingEntry/getPendingTripListByCustomer?customerCode='+$scope.createInvoice.customerCode)
    					.success(function(datas) {
    						$scope.pendingTripList = datas;
    						
    						$scope.Customercode1 = $scope.createInvoice.customerCode ;
    						 
    					}).error(function(datas) {
    						logger
    						.logError('Error!');
    					});
    	 });
    	  
    	 
    	
    	 
    	//add Row And Selectivity       
        
        $scope.$watch('loadingEntry.tripId', function(newValue, oldValue) {
            if (newValue != "" && newValue != null) {
            	
            	$scope.loadingEntry.tables = [];
                var table = {
                        slNo : '',
                        truckId : '',
                    	trailerId : '',
                    	fromLocation : '',
                    	toLocation : '',
                    	truckRegNo : '',
                    	plateNo : '',
                    	mloCode : '',
                    	tripStartDate : '',
                    	trailerNo : '',
                    	mobileNo : '',
                    	planTripId: '',
                    	bookingId : '',
                    	mode : '',
                    	fromLocationCode: '', 
                    	toLocationCode : '',
                    	invoiceNo : '',
                        isselect:false,
                        disableDate:false,
                        bookingDtlList : [],
                        bookingConCargoDtlList : []
                        
                    };
                $scope.loadingEntry.tables.push(table);
                
                
                $http.post($stateParams.tenantid + '/app/dailyLoadingEntry/tripLoadingDtls ', $scope.loadingEntry.tripId).success(function(datas) {
                    console.log(datas);
                    $scope.loadingEntry.tables = datas.listBean;
                    for (var l = 0; l < datas.listBean.length; l++) {
                        $scope.loadingEntry.tables[l].truckId = datas.listBean[l].truckId.toString();
                        $scope.loadingEntry.tables[l].trailerId = datas.listBean[l].trailerId.toString();
                        $scope.loadingEntry.tables[l].fromLocation = datas.listBean[l].lolId.toString();
                        $scope.loadingEntry.tables[l].toLocation = datas.listBean[l].lodId.toString();
                        $scope.loadingEntry.tables[l].truckRegNo = datas.listBean[l].truckRegNo;
                        $scope.loadingEntry.tables[l].plateNo = datas.listBean[l].plateNo;
                        $scope.loadingEntry.tables[l].tripStartDate = datas.listBean[l].tripStartDate;
                        $scope.loadingEntry.tables[l].trailerNo = datas.listBean[l].trailerNo;
                        $scope.loadingEntry.tables[l].mobileNo = datas.listBean[l].mobileNo;
                        $scope.loadingEntry.tables[l].planTripId = datas.listBean[l].planTripId.toString();
                        $scope.loadingEntry.tables[l].bookingId = datas.listBean[l].bookingId;
                        $scope.loadingEntry.tables[l].fromLocationCode = datas.listBean[l].fromLocationCode;
                        $scope.loadingEntry.tables[l].toLocationCode = datas.listBean[l].toLocationCode;
                        $scope.loadingEntry.tables[l].mloCode=$scope.loadingEntry.customer;
                        $scope.loadingEntry.tables[l].invoiceNo = datas.listBean[l].invoiceNo;
                        $scope.loadingEntry.tables[l].bookingDtlList = [];
                    }
                    console.log($scope.loadingEntry)
                });
            }
        })
    	
    	
    	
    	
     
    	$http.get($stateParams.tenantid+'/app/commonUtility/mlomaster').success(function(datas) {
            	console.log(" ::::::::::::datas ::::::::::::::::");
            	console.log(datas.commonUtilityBean);
                $scope.customerList = datas.commonUtilityBean;
                }).error(function(datas) {
            });
            
    	   $scope.customerinvoicepopup = {
    			   customerCode : '',
    			   tripIdList : []
    	   }
    	$scope.customerinvoicepopup.tripIdList =[]
        $scope.$watch('customerinvoicepopup.customerCode', function(newValue, oldValue) {
            if (newValue != '' && newValue != undefined) {
            	var customerCode = $scope.customerinvoicepopup.customerCode;
                $http.get($stateParams.tenantid+'/app/customerinvoice/getTripList?customerCode='+customerCode).success(function(datas) {
                   
                	$scope.tripsList = datas.tripList;
                	
                	 $timeout(function() {
    		                $('#tripMultiSelect').multiselect('deselectAll', false);
    		                $('#tripMultiSelect').multiselect('updateButtonText');
    		                $("#tripMultiSelect").multiselect('rebuild');
    		            
    		            }, 2, false);
    		            $("#multiselect-button").addClass("width_100 input-sm line-height-5");

                    }).error(function(datas) {
                });
            }
            
            
       });
    	
    			
    	   $scope.isSaveButton=true;
    	 	
    	   
    	$scope.bookingNewList=[];	
        $scope.bookingList=[];
    			  var trip="";
    					$scope.saveBooking = function(loadingEntry) {	
    						$scope.isSaveButton=false;
    						console.log($scope.loadingEntry);
    						$scope.bookingNewList=[];
    						$scope.bookingList=[];
    						$scope.removeList=[];
    						$scope.bookingNewList1=[];
    					   angular.copy($scope.loadingEntry, $scope.bookingNewList);
//    					      
    					   var coun=0;
    						for(var i=0; i < $scope.bookingNewList.tables.length;i++){ 
    							for(var j=i+1;j< $scope.bookingNewList.tables.length;j++){
     									if($scope.bookingNewList.tables[i].mode == 1){
     									    if(i==0 && j ==1){
     		 								   	 $scope.conList= {
     														conSizeId : '',
     														containerTypeId : '',
     														quantity : '',
     														bookingConCargoDtlList : []
     													}
     											 
     											 $scope.conList.conSizeId= $scope.bookingNewList.tables[i].conSizeId;
     		 									 $scope.conList.containerTypeId= $scope.bookingNewList.tables[i].containerTypeId;
     		 									 $scope.conList.quantity= $scope.bookingNewList.tables[i].quantity;
     		 									  $scope.bookingNewList.tables[i].bookingDtlList.push($scope.conList);
     		 									for(var carLen=0;carLen < $scope.bookingNewList.tables[i].bookingConCargoDtlList.length;carLen++){
    												 $scope.bookingNewList.tables[i].bookingConCargoDtlList[carLen]['planTripId']=$scope.bookingNewList.tables[i].planTripId;
    												 $scope.bookingNewList.tables[i].bookingDtlList[0].bookingConCargoDtlList.push($scope.bookingNewList.tables[i].bookingConCargoDtlList[carLen]);
    											 } 
     		 								     }
    									$scope.conList= {
     											conSizeId : '',
     										containerTypeId : '',
     										quantity : '',
     											bookingConCargoDtlList : []
     										}
    									if($scope.bookingNewList.tables[i].conSizeId == $scope.bookingNewList.tables[j].conSizeId &&
    											$scope.bookingNewList.tables[i].containerTypeId == $scope.bookingNewList.tables[j].containerTypeId){
     								     
    										if($scope.bookingNewList.tables[i].bookingDtlList.length == 0){
    										
    										 $scope.conList.conSizeId= $scope.bookingNewList.tables[j].conSizeId;
    	 									 $scope.conList.containerTypeId= $scope.bookingNewList.tables[j].containerTypeId;
    	 									 $scope.conList.quantity= $scope.bookingNewList.tables[j].quantity;
    	 									 for(var a=0;a < $scope.bookingNewList.tables[j].bookingConCargoDtlList.length;a++ ){
    	 										 $scope.bookingNewList.tables[j].bookingConCargoDtlList[a]['planTripId']=$scope.bookingNewList.tables[j].planTripId;
    											 $scope.conList.bookingConCargoDtlList.push($scope.bookingNewList.tables[j].bookingConCargoDtlList[a]);
    	 									 }
    	 									 
    	 									
    	 									 $scope.bookingNewList.tables[i].bookingDtlList.push($scope.conList);
    	 								 
    	 									var len=$scope.bookingNewList.tables[i].bookingConCargoDtlList.length;
    										 for(var k=0; k < len;k++){
    											 $scope.bookingNewList.tables[i].bookingConCargoDtlList[k]['planTripId']=$scope.bookingNewList.tables[i].planTripId;
    											 $scope.bookingNewList.tables[i].bookingDtlList[0].bookingConCargoDtlList.push($scope.bookingNewList.tables[i].bookingConCargoDtlList[k]);
    		 
    	                   				 }		
    										 $scope.bookingNewList.tables[i].bookingConCargoDtlList=[]; 
    										}
    										else{
    											 
    											var len=$scope.bookingNewList.tables[j].bookingConCargoDtlList.length;
    											 for(var k=0; k < len;k++){
    												 $scope.bookingNewList.tables[j].bookingConCargoDtlList[k]['planTripId']=$scope.bookingNewList.tables[j].planTripId;
    												 $scope.bookingNewList.tables[i].bookingDtlList[0].bookingConCargoDtlList.push($scope.bookingNewList.tables[j].bookingConCargoDtlList[k]);
    			 
    		                   				 }		
    										}
    								
    									 $scope.removeList.push(j);
    								}
    									else{
    										var count=0;
    										var c=0;
    									for(var v=0;v<$scope.bookingNewList.tables[i].bookingDtlList.length;v++){
    										if($scope.bookingNewList.tables[j].conSizeId == $scope.bookingNewList.tables[i].bookingDtlList[v].conSizeId
    											&& $scope.bookingNewList.tables[j].containerTypeId == $scope.bookingNewList.tables[i].bookingDtlList[v].containerTypeId){
    											count++;
    											c=v;
    										}
    										
    									}
    									if(count == 0 && c==0){
    										
    										 $scope.conList= {
    													conSizeId : '',
    													containerTypeId : '',
    													quantity : '',
    													bookingConCargoDtlList : []
    												}
    										 
    										 $scope.conList.conSizeId= $scope.bookingNewList.tables[j].conSizeId;
    	 									 $scope.conList.containerTypeId= $scope.bookingNewList.tables[j].containerTypeId;
    	 									 $scope.conList.quantity= $scope.bookingNewList.tables[j].quantity;
    	 								//	 var len= $scope.bookingNewList.tables[i].bookingDtlList.length;
    	 									for(var carLen=0;carLen < $scope.bookingNewList.tables[j].bookingConCargoDtlList.length;carLen++){
    											 $scope.bookingNewList.tables[j].bookingConCargoDtlList[carLen]['planTripId']=$scope.bookingNewList.tables[j].planTripId;
    											 $scope.conList.bookingConCargoDtlList.push($scope.bookingNewList.tables[j].bookingConCargoDtlList[carLen]);
    										 }
    	 								     $scope.bookingNewList.tables[i].bookingDtlList.push($scope.conList);
    	 								    
    	 								 
    										 $scope.removeList.push(j);
    										 
    									
//    										 for(var carLen1=0;carLen1 < $scope.bookingNewList.tables[i].bookingConCargoDtlList.length;carLen1++){
//    											 $scope.bookingNewList.tables[i].bookingConCargoDtlList[carLen1]['planTripId']=$scope.bookingNewList.tables[i].planTripId;
//    											 $scope.conList.bookingConCargoDtlList.push($scope.bookingNewList.tables[i].bookingConCargoDtlList[carLen1]);
//    										 }
//    										 $scope.conList.conSizeId= $scope.bookingNewList.tables[i].conSizeId;
//    	 									 $scope.conList.containerTypeId= $scope.bookingNewList.tables[i].containerTypeId;
//    	 									 $scope.conList.quantity= $scope.bookingNewList.tables[i].quantity;
//    	 									$scope.bookingNewList.tables[i].bookingDtlList.push($scope.conList);
//    	 									$scope.bookingNewList.tables[i].bookingConCargoDtlList=[];
    									}
    									else{
    										var conlen=$scope.bookingNewList.tables[j].bookingConCargoDtlList.length;
    										 for(var k=0; k < conlen;k++){
    											 $scope.bookingNewList.tables[j].bookingConCargoDtlList[k]['planTripId']=$scope.bookingNewList.tables[j].planTripId;
    											 if($scope.bookingNewList.tables[i].bookingDtlList[c] == undefined){
    												 $scope.conList= {
    															conSizeId : '',
    															containerTypeId : '',
    															quantity : '',
    															bookingConCargoDtlList : []
    														}
    												 $scope.conList.conSizeId= $scope.bookingNewList.tables[j].conSizeId;
    			 									 $scope.conList.containerTypeId= $scope.bookingNewList.tables[j].containerTypeId;
    			 									 $scope.conList.quantity= $scope.bookingNewList.tables[j].quantity;
    			 									 for(var carLen=0;carLen < $scope.bookingNewList.tables[j].bookingConCargoDtlList.length;carLen++){
    													 $scope.bookingNewList.tables[j].bookingConCargoDtlList[carLen]['planTripId']=$scope.bookingNewList.tables[j].planTripId;
    													 $scope.conList.bookingConCargoDtlList.push($scope.bookingNewList.tables[j].bookingConCargoDtlList[carLen]);
    												 }
    			 								     $scope.bookingNewList.tables[i].bookingDtlList.push($scope.conList);
    												 $scope.removeList.push(j);
    											 }else{
    												 $scope.bookingNewList.tables[i].bookingDtlList[c].bookingConCargoDtlList.push($scope.bookingNewList.tables[j].bookingConCargoDtlList[k]);
    												 $scope.removeList.push(j);
    											 }
    		 
    	                   				 }		
     									}
    										
    									}
    							}
    							else{
    								if(coun==0){
    									var len1=$scope.bookingNewList.tables[i].bookingConCargoDtlList.length;
    									for(var l=0; l < len1;l++){
    										$scope.bookingNewList.tables[i].bookingConCargoDtlList[l]['planTripId']=$scope.bookingNewList.tables[i].planTripId;
    									}
    									coun++;
    							    }
    									var len=$scope.bookingNewList.tables[j].bookingConCargoDtlList.length;
    									for(var k=0; k < len;k++){
    										$scope.bookingNewList.tables[j].bookingConCargoDtlList[k]['planTripId']=$scope.bookingNewList.tables[j].planTripId;
    										$scope.bookingNewList.tables[i].bookingConCargoDtlList.push($scope.bookingNewList.tables[j].bookingConCargoDtlList[k]);
    	                   				}	
    									$scope.removeList.push(j);		
    								}
    								 
    						   }
    							var tempLen=$scope.removeList.length;
    							for(var m=0; m < $scope.removeList.length;m++){
    								tempLen=tempLen-1;
    								$scope.bookingNewList.tables.splice(Math.max($scope.removeList[0],$scope.removeList[tempLen]),1);
    								}
    							 
    						}		 
    						
    						angular.forEach($scope.bookingNewList.tables, function (item, key) {
    							
    							if($scope.bookingNewList.tables[key].planTripId != "" && $scope.bookingNewList.tables[key].planTripId != null){
    								$scope.conList= {
    										conSizeId : '',
    										containerTypeId : '',
    										quantity : '',
    										bookingConCargoDtlList : []
    									}
    								
    								$scope.booking={
    										bookingDtlList : [{
    											bookingConCargoDtlList : []
    										}],
    										
    								};
    								$scope.booking.bookingDtlList =[];
    								
    								trip=$scope.bookingNewList.tables[key].planTripId ;
    							 if($scope.bookingNewList.tables[key].mode == 2){ 
    								
    							$scope.booking['lolId'] =  $scope.bookingNewList.tables[key].fromLocation;
    							$scope.booking['lodId'] =   $scope.bookingNewList.tables[key].toLocation;
    							$scope.booking['transportType'] =   $scope.bookingNewList.tables[key].transportType;
    							$scope.booking['bookingDate'] =  $scope.bookingNewList.tables[key].tripStartDate;
    							$scope.booking['mode'] =  $scope.bookingNewList.tables[key].mode;
    							$scope.booking['bookingStatus'] = "A";
    							$scope.booking['mloCode'] =  $scope.bookingNewList.tables[key].mloCode;
    							$scope.booking['quotationNo'] =  $scope.bookingNewList.tables[key].quotationNo;
    							 $scope.conList.conSizeId=  $scope.bookingNewList.tables[key].conSizeId;
    							 $scope.conList.containerTypeId=  $scope.bookingNewList.tables[key].containerTypeId;
    							 if( $scope.bookingNewList.tables[key].bookingConCargoDtlList != null){
    								 $scope.conList.quantity=  $scope.bookingNewList.tables[key].bookingConCargoDtlList.length;
    							
    								/* for(var containerLen=0;containerLen < $scope.bookingNewList.tables[key].bookingConCargoDtlList.length;containerLen++){
    									 $scope.bookingNewList.tables[key].bookingConCargoDtlList[containerLen]['planTripId']=$scope.bookingNewList.tables[key].planTripId;
    								 }*/
    							 $scope.conList.bookingConCargoDtlList = angular.copy($scope.bookingNewList.tables[key].bookingConCargoDtlList);
    							 }
    							 else{
    								 logger
    									.logError('Atleast one container need to select!');
    							$scope.isSaveButton=true;
    							 }
    							 $scope.booking.bookingDtlList.push($scope.conList);
    							 console.log($scope.booking.bookingDtlList)
    							if ( $scope.booking.lolId !=  $scope.booking.lodId) {
    								if ($scope.booking.bookingDtlList != null
    										&& $scope.booking.bookingDtlList.length > 0) {
    									 loadingEntry['bookingDtlList'] = $scope.booking.bookingDtlList;
    									var rb = {
    										booking :  $scope.booking
    									}
    									$scope.bookingList.push(rb);
    								} else {
    									logger
    											.logError('Please provide Container detail');
    									$scope.isSaveButton=true;
    								}
    							} else {
    								logger
    										.logError('LOL and LOD should not be same');
    								$scope.isSaveButton=true;
    							}
    							
    							}
    							 else{ 
    								 $scope.booking['transportType'] =   $scope.bookingNewList.tables[key].transportType;
    									$scope.booking['lolId'] =  $scope.bookingNewList.tables[key].fromLocation;
    									$scope.booking['lodId'] =   $scope.bookingNewList.tables[key].toLocation;
    									$scope.booking['bookingDate'] =  $scope.bookingNewList.tables[key].tripStartDate;
    									$scope.booking['mode'] =  $scope.bookingNewList.tables[key].mode;
    									$scope.booking['bookingStatus'] = "A";
    									$scope.booking['mloCode'] =  $scope.bookingNewList.tables[key].mloCode;
    									$scope.booking['quotationNo'] =  $scope.bookingNewList.tables[key].quotationNo;
    									if($scope.bookingNewList.tables[key].bookingDtlList.length == 0){
    										 $scope.conList.conSizeId=  $scope.bookingNewList.tables[key].conSizeId;
    							 $scope.conList.containerTypeId=  $scope.bookingNewList.tables[key].containerTypeId;
                             if($scope.bookingNewList.tables[key].bookingConCargoDtlList != null){
    							 $scope.conList.quantity=  $scope.bookingNewList.tables[key].bookingConCargoDtlList.length;

                             }
                             else{
    							 logger
    								.logError('Atleast one container need to select!');
    						$scope.isSaveButton=true;
    						 }
    							 for(var containerLen=0;containerLen < $scope.bookingNewList.tables[key].bookingConCargoDtlList.length;containerLen++){
    								 $scope.bookingNewList.tables[key].bookingConCargoDtlList[containerLen]['planTripId']=$scope.bookingNewList.tables[key].planTripId;
    								 $scope.conList.bookingConCargoDtlList.push($scope.bookingNewList.tables[key].bookingConCargoDtlList[containerLen]);
     
    							 }
    							 $scope.booking.bookingDtlList.push($scope.conList);	
    									}
    									else{
    										$scope.booking.bookingDtlList=$scope.bookingNewList.tables[key].bookingDtlList;
    										 for(var quantityLen=0;quantityLen < $scope.bookingNewList.tables[key].bookingDtlList.length;quantityLen++){
    											 if($scope.bookingNewList.tables[key].bookingDtlList[quantityLen].quantity == $scope.bookingNewList.tables[key].bookingDtlList[quantityLen].bookingConCargoDtlList.length){
    												 
    											 }
    											 else{
    												 $scope.bookingNewList.tables[key].bookingDtlList[quantityLen].quantity = $scope.bookingNewList.tables[key].bookingDtlList[quantityLen].bookingConCargoDtlList.length;
    											 }
    										 }
    									}
    																	
    									if ( $scope.booking.lolId !=  $scope.booking.lodId) {
    										if ($scope.booking.bookingDtlList != null
    												&& $scope.booking.bookingDtlList.length > 0) {
    											 loadingEntry['bookingDtlList'] = $scope.booking.bookingDtlList;
    											var rb = {
    												booking :  $scope.booking
    											}
    											$scope.bookingList.push(rb);
    										} else {
    											logger
    													.logError('Please provide Container detail');
    											$scope.isSaveButton=true;
    										}
    									} else {
    										logger
    												.logError('LOL and LOD should not be same');
    										$scope.isSaveButton=true;
    									}
    									
    									}
    						}
    						});
    						console.log($scope.bookingList);
    						$scope.allocationList=[];
    						if(!$scope.isSaveButton){
    									$http.post($stateParams.tenantid+ '/app/booking/saveBookingByLoadingEntry', $scope.bookingList).success(function(data) {
    									if (data) {
    										$scope.isSaveButton=true;
    															logger.logSuccess('Booking Saved Successfully.')
    													
    													for(var i=0;i < data.length;i++){
    														for(var j=0;j < data[0].bookingDtlList[i].bookingConCargoDtlList.length;j++){
    															$scope.bookingDtlNew={
    																	alloted : '',
    																	bookingDtlId : '',
    																	planTripId : '',
    																	bookingConCargoDtlList : [],
    																	tripStartDate : ''
    																	
    															}
    															$scope.bookingDtlNew.alloted=1;	
    															$scope.bookingDtlNew.tripStartDate=$scope.booking.bookingDate;
    															$scope.bookingDtlNew.bookingDtlId=data[0].bookingDtlList[i].bookingConCargoDtlList[j].bookingDtlId;
    															$scope.bookingDtlNew.planTripId =data[0].bookingDtlList[i].bookingConCargoDtlList[j].planTripId;
    															$scope.bookingDtlNew.bookingConCargoDtlList.push(data[0].bookingDtlList[i].bookingConCargoDtlList[j]);
    															$scope.allocationList.push($scope.bookingDtlNew);
    														}
    														
    													
    													 
    													}
    														 console.log($scope.allocationList)
    																
    											 	$http.post($stateParams.tenantid + '/app/tripallocation/add',$scope.allocationList).success(function(result) {
    																console.log("result"+ result);
    																if (result.success == true) {
    																	$state.reload();
    																	logger
    																			.logSuccess("Saved successfully!");
    																	ngDialog.close();
    																} else if(result.success == false && result.message != ""){
    																	logger
    																			.logError(result.message);
    																}
    																else{
    																	logger
    																	.logError("Error in Allocation!");
    																}
    															}).error(function(result) {
    														console.log("data" + result);
    													}); 
    															$state.reload();
    									} else {
    										if (data.message != null
    												&& data.message != '') {
    											logger
    													.logError(data.message)
    													$scope.isSaveButton=true;
    										} else {
    											logger
    													.logError("Can't save. Please try again");
    											$scope.isSaveButton=true;
    										}
    									}
    									})
    									
    					}
    					else{
    						logger
    						.logError("Please fill all mandatory fields	/Refer the error shown before!");
    				$scope.isSaveButton=true;
    					}
    									};
    												
    	$scope.modeList=[];
    	$scope.getMode = function() {
    	    var  data = {};
    	    data["id"] = "1";
    	    data["text"] = "Booking";
    	    $scope.modeList.push(data);
    	    data = {};
    	    data["id"] = "2";
    	    data["text"] = "Bulk Booking";
    	    $scope.modeList.push(data);  
    	    
    	}
    	$scope.getMode();
    					
    					
    	
    	$scope.createTrip = function(){
    		$state.go('app.operation.trip.addByLoadingEntry', {
        		value : "DailyLoadingEntry" 
        		
    		});
    	}	

    	/*List*/		
    					
    	$scope.getOnloadList = function() {
    		$http
    				.post(
    						$stateParams.tenantid
    								+ '/app/booking/add')
    				.success(
    						function(data) {
    							$scope.mloList = data.mloList;
    							$scope.lolList = data.locationList;
    							$scope.lodList = data.locationList;
    							$scope.containerTypeList = data.containerTypeList;
    							$scope.containerSizeList = data.containerSizeList;
    							$scope.commodityList = data.commodList;
    							$scope.packageTypeList = data.packageTypeList;
    							$scope.booking = data.booking;
    							//$scope.booking['transportType'] = 'L';
    							$scope.booking['bookingDate'] = $scope.currentDate;
    							$scope.quotationList = data.quotationList;
    							
    						 
    						});
    	};
    	$scope.getOnloadList();
    	
    	$scope.booking = {};
    		
    	
    	
//    	$http.get(
//    			$stateParams.tenantid
//    					+ '/app/dailyLoadingEntry/tripList')
//    			.success(function(datas) {
//    				$scope.tripList = datas;
//    				
//    				 $timeout(function() { 
//    		                
//    		                $("#txtGroupCode").multiselect({
//    		                    maxHeight: 400,
//    		                    includeSelectAllOption: true,
//    		                    selectAllText: 'Select All',
//    		                    enableFiltering: true,
//    		                    enableCaseInsensitiveFiltering: true,
//    		                    filterPlaceholder: 'Search',
//    		                    onChange: function(element, checked) {
//    		                        debugger;
//    		                      var tripCodes = "";
//    		                      if($scope.loadingEntry.tripId.length>0){
//    		                          angular.forEach($scope.loadingEntry.tripId, function (item, key) {
//    		                              debugger;
//    		                              if($scope.loadingEntry.tripId.length>0){
//    		                                  debugger;
//    		                                  if($scope.loadingEntry.tripId[key]!=undefined){
//    		                                      
//    		                                      var companyCode = item.id;
//    		                                      
//    		                                      if(tripCodes==""){
//    		                                          tripCodes = item.id;
//    		                                      }else{
//    		                                          tripCodes +=","+ item.id;
//    		                                      }       
//    		                                      $scope.loadingEntry.tripCode = tripCodes;
//    		                                  }                             
//    		                              }                              
//    		                          });
//    		                      }else{
//    		                          $scope.loadingEntry.tripCode = '';
//    		                      }
//    		                      console.log($scope.loadingEntry.tripCode);
//    		                    }
//    		                  });
//    		                $("#txtGroupCode").parent().find('.btn-group #multiselect-button').addClass('width_100 input-sm line-height-5'); 
//    		                
//    		                }, 2, false);
//    			}).error(function(datas) {
//    			});	
    	
    	$http.get(
    			$stateParams.tenantid
    					+ '/app/dailyLoadingEntry/truckTrailerList')
    			.success(function(datas) {
    				$scope.truckList = datas.truckList;
    				$scope.trailerList=datas.trailerList;
    				$scope.portList=datas.locationList;
    			}).error(function(datas) {
    			});	
    	
    	 
    	$scope.createInvoice = function(loadingEntry){		
    		if(loadingEntry.mode == 1){
    		ngDialog.open({
    			template : 'invoiceDialogId',
    			scope : $scope,
    			controller : $controller('invoiceDialogIdCtrl', {
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
    			ngDialog.open({
    				template : 'bulkinvoiceDialogId',
    				scope : $scope,
    				controller : $controller('bulkinvoiceDialogIdCtrl', {
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


    };

    $scope.BulkInvoice = function(table){
    	if($scope.createInvoice.customerCode != '' && $scope.createInvoice.customerCode != undefined &&
    			$scope.createInvoice.customerCode != null){
    		$scope.customerinvoicepopup.tripIdList=[];
    		for(var i=0;i<table.length;i++){
    			if(table[i].select){
    				$scope.customerinvoicepopup.tripIdList.push(table[i].tripId);
    				$scope.customerinvoicepopup.customerCode=table[i].mloCode;
    			}
    			
    		}
//    		$http.post(
//    				$stateParams.tenantid
//    						+ '/app/dailyLoadingEntry/validateTrip',$scope.customerinvoicepopup.tripIdList)
//    				.success(function(datas) {
//    				
//    		if(datas.success){
    		
    		ngDialog.open({
    			template : 'invoiceDialogId',
    			scope : $scope,
    			controller : $controller('invoiceDialogIdCtrl', {
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
    			logger
    			.logError(datas.message);
    		}
//    				}) 
//    	}else{
//    		logger
//    		.logError("Please select the customer for Bulk Invoice Creation!");
//    	}
    	
    	
    }

    $scope.BulkInvoiceNew = function(table){
    	if($scope.createInvoice.customerCode != '' && $scope.createInvoice.customerCode != undefined &&
    			$scope.createInvoice.customerCode != null){
    		$scope.customerinvoicepopup.tripIdList=[];
    		for(var i=0;i<table.length;i++){
    			if(table[i].select){
    				$scope.customerinvoicepopup.tripIdList.push(table[i].tripId);
    				$scope.customerinvoicepopup.customerCode=table[i].mloCode;
    			}
    			
    		}
    		ngDialog.open({
    			template : 'bulkinvoiceDialogId',
    			scope : $scope,
    			controller : $controller('bulkinvoiceDialogIdCtrl', {
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
    	}else{
    		logger
    		.logError("Please select the customer for Bulk Invoice Creation!");
    	}
    }
    $scope.createInvoiceNew = function(loadingEntry){
    	$scope.customerinvoicepopup.tripIdList=[];
    	$scope.customerinvoicepopup.customerCode=loadingEntry.mloCode;
    	$scope.customerinvoicepopup.tripIdList.push(loadingEntry.tripId);
    	
//    	$http.post(
//    			$stateParams.tenantid
//    					+ '/app/dailyLoadingEntry/validateTrip',$scope.customerinvoicepopup.tripIdList)
//    			.success(function(datas) {
//    			
//    	if(datas.success){
    		if(loadingEntry.mode == 1){
    	ngDialog.open({
    		template : 'invoiceDialogId',
    		scope : $scope,
    		controller : $controller('invoiceDialogIdCtrl', {
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


     }else{

    		ngDialog.open({
    			template : 'bulkinvoiceDialogId',
    			scope : $scope,
    			controller : $controller('bulkinvoiceDialogIdCtrl', {
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
    	
//    			}
//    	else{
//    		logger
//    		.logError(datas.message);
//    	}
//    			}) 
    }
    	

    	
});
    

    app.controller('loadingEntryListCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope,$stateParams) {
    	
    	
    	
     	$scope.addBookingConDtl = function(bookingDtl,trindex) {
     		var bookingConDtl = {
     			bookingConCargoDtlId : '',
     			bookingDtlId : '',
     			containerNo : '',
     			sealNo : '',
     			grossWt : '',
     			netWt : '',
     			commodityId : '',
     			packageType : '',
     			noOfPackages : '',
     			isHaz : '',
     			unName : '',
     			unClass : '',
     			unAllocateStatus : true
     		}
     		$scope.loadingEntry.tables[trindex].bookingConCargoDtlList.push(bookingConDtl);
     	};
     	
     	/*$scope.loadingEntry.tables.bookingDtlList = [];*/
     	$scope.addBookingDtl = function(trindex) {
     		var bookingDtl = {
     			bookingDtlId : '',
     			bookingId : '',
     			containerTypeId : '',
     			conSizeId : '',
     			quantity : '',
     			show : false,
     			emptyCont :false
     		}
     		$scope.loadingEntry.tables[trindex].bookingDtlList.push(bookingDtl);
     	};
     	
     	
         
        
    	
    	//create new Container
    	$scope.createNewContainers = function(bookingDtl,trIndex) {
    		
    		if (bookingDtl.quantity == null || bookingDtl.quantity == '' || bookingDtl.quantity == 0) {
    			logger.logError("Quantity Field is required. Must be a positive number.");
    		} else {
    			if ($scope.loadingEntry.tables[trIndex].bookingConCargoDtlList == null) {
    				$scope.loadingEntry.tables[trIndex].bookingConCargoDtlList  = [];
    			}
    			if ( bookingDtl.quantity > $scope.loadingEntry.tables[trIndex].bookingConCargoDtlList .length) {
    				var diff = bookingDtl.quantity - $scope.loadingEntry.tables[trIndex].bookingConCargoDtlList.length;
    				for (index = 0; index < diff; index++) {					
    					$scope.addBookingConDtl(bookingDtl,trIndex);
    					$scope.contType(bookingDtl,1);
    				}
    			} else {
    				var diff = $scope.loadingEntry.tables[trIndex].bookingConCargoDtlList.length - bookingDtl.quantity;
    				for (index = 0; index < diff; index++) {
    					$scope.loadingEntry.tables[trIndex].bookingConCargoDtlList.splice($scope.loadingEntry.tables[trIndex].bookingConCargoDtlList.length - 1,1);
    				}
    			}
    		}
    	};
    	
    	
    	
    	
    	$scope.contType=function(bookingDtl,trIndex){
    		debugger
    		 if(bookingDtl.containerTypeId == 2){
    		 	for(var bookingCount=0;$scope.loadingEntry.tables[trIndex].bookingConCargoDtlList.length > bookingCount;bookingCount++){
    		 		if(bookingDtl.conSizeId == 1){
    		 			$scope.loadingEntry.tables[trIndex].bookingConCargoDtlList[bookingCount].netWt=2.2;
    		 			$scope.loadingEntry.tables[trIndex].bookingConCargoDtlList[bookingCount].grossWt=2.2;
    		 			bookingDtl.emptyCont=true;
    		 		}
    		 		else{
    		 			$scope.loadingEntry.tables[trIndex].bookingConCargoDtlList[bookingCount].netWt=4.4;
    		 			$scope.loadingEntry.tables[trIndex].bookingConCargoDtlList[bookingCount].grossWt=4.4;
    		 			bookingDtl.emptyCont=true;
    		 			

    		 		}
    		 		
    		 	}
    			 
    		 }
    		 else{
    			 for(var bookingCount=0;$scope.loadingEntry.tables[trIndex].bookingConCargoDtlList.length > bookingCount;bookingCount++){
    				 $scope.loadingEntry.tables[trIndex].bookingConCargoDtlList[bookingCount].netWt='';
    				 $scope.loadingEntry.tables[trIndex].bookingConCargoDtlList[bookingCount].grossWt='';
    			 			bookingDtl.emptyCont=false;

    			 		}
    			 		
    		 }
    	
    		}
    	
    	
    	
    	
    	$scope.createQuoatation = function(loadingEntry){
    		if(loadingEntry.mloCode != "" && loadingEntry.mloCode != null){
    			
    		
    		$state
    		.go(
    				'app.sales.quotation.addByBooking',
    				{
    					bookingDate : loadingEntry.tripStartDate,
    					mloCode : loadingEntry.mloCode,
    					lolId : loadingEntry.fromLocationCode,
    					lodId : loadingEntry.toLocationCode,
    					bookingId : loadingEntry.bookingId,
    				});
    		}
    		else{
    			logger
    			.logError("Please select the customer!");
    		}
    	}
    	
    			$scope.quotationExist=false;
    				$scope.$watch('table.mloCode',function(newValue, oldValue) {
    				if (newValue != '' &&  newValue != undefined) {
    				$http.get($stateParams.tenantid+ '/app/booking/getQuotationAndTransport?fromLocation='+ $scope.loadingEntry.tables[$scope.$index].fromLocation+ '&toLocation='+ $scope.loadingEntry.tables[$scope.$index].toLocation+ '&bookingDate='+ $scope.loadingEntry.tables[$scope.$index].tripStartDate+ '&customerNo='+ newValue).success(
    									function(datas) {
    										if (datas.bookingList.length > 0) {
    											$scope.booking.quotationNo = datas.bookingList[0].quotationNo;
    											$scope.quotationList = datas.quotationList;
    											console.log($scope.quotationList)
    											if($scope.quotationList.length > 0){
    												$scope.quotationExist=true;
    											}
    										 
     
    										}  
    						 

    									});
    							}
    			})
    			
    			$scope.$watch('table.mloCode',function(newValue, oldValue) {				
    				if (newValue != ''&& newValue != oldValue && newValue != undefined) {
    				
    				$http.get($stateParams.tenantid	+ '/app/booking/getQuotationAndTransport?fromLocation='+ $scope.loadingEntry.fromLocation+ '&toLocation='+ $scope.loadingEntry.toLocation+ '&bookingDate='+ $scope.loadingEntry.tripStartDate+ '&customerNo='+ $scope.loadingEntry.mloCode).success(
    						function(datas) {
    							$scope.loadingEntry.transportType = datas.transportType;
    							if ($scope.loadingEntry.transportType == '' || $scope.booking.transportType == null) {
    								$scope.loadingEntry.transportType = angular.copy($scope.tempType);
    							}
    							if (datas.transportType == 'L') {
    								$scope.transit = false;
    								$scope.local = true;
    							} else {
    								$scope.local = false;
    								$scope.transit = true;
    							}

    						});
    				
    				}
    			
    			});
    					

    				
    });

    app.controller('invoiceDialogIdCtrl',function($scope, $rootScope, $injector, $http, ngDialog,$location, logger, utilsService, $state,sharedProperties,
    $window, toaster, validationService,$stateParams,$timeout,$filter) {

     
        $scope.mloList=[];
        $scope.PorthdrList=[];
        $scope.voyagehdrList=[];
        $scope.customerinvoice = {
            Company : '',
            CompanyCode : '',
            CustomerName : '', 
            MloName : '', 
            Voyage : '', 
            VesselName : '', 
            currency:'',
            AccountName : '', 
           
            ServiceName : '',
            CurrencyName : '', 
            exchangeRate : '', 
            fromCurrency: '',
            toCurrency:'',
            Pol : '', 
            Pod : '', 
            consignmentNo : '',
            deliveryNo : '',
            spifRefNo : '',
            consignee : '',
            consignmentId : '',
            deliveryId : '',
            Subject : '', 
            Unit20 : '', 
            Unit40 : '', 
            workOrderNo : '',
           // Subject : '', 
            bl : '',
            exchangeRateFrom : '', 
            exchangeRateTo : '', 
            currencyValue : '',
            fraction : '', 
            InvoiceDate : '',
            totalBCamount : '', 
            totalTCamount : '', 
            BlRelated : true,
            isEdit : false,
            GIDtl : [],
            miscelList : [],
            tripIdList :[],
            deliveryGoodDescription :'',
            blNo : '',
            dispatchNo:''
        }
        
        $scope.customerinvoice.customerCode=$scope.customerinvoicepopup.customerCode;

    $scope.calculatetotalAmount = function(row){
    	if(row.vatPerc == 0){
    		row.vatAmount=0;
    	}
    	else{
    		row.vatAmount=row.amount*row.vatPerc/100;
    	}
    	row.totalAmount=parseFloat(row.vatAmount)+parseFloat(row.amount);
    }
        
        $scope.currentURL=$location.protocol() + '://'+ $location.host() +':'+  $location.port()+"/#" +$location.path();
        
        if(window.localStorage.getItem('giv')==$scope.currentURL){
            alert('window ' + $scope.currentURL + ' is already opened');
          
        }else{
            window.localStorage.setItem('giv', $scope.currentURL);
           
        }
        $(window).unload(function(){
         
             localStorage.removeItem('giv');
           });

        $scope.cancel = function() {
        	ngDialog.close();
        };
        
        
        $("#tripMultiSelect").multiselect({
            maxHeight: 200,   
            includeSelectAllOption: true,
            disableIfEmpty: true,
            enableCaseInsensitiveFiltering: true,
            onDropdownHide: function (event) {
                
            }
          });
        $(".multiselect").addClass("width_100 input-sm line-height-5");
        
        
        $scope.onLoadDropdowns = function() {
            $http.get($stateParams.tenantid+'/app/usermaster/getCompanyList?formCode='+$('#form_code_id').val()).success(function(datas) {
                $scope.companyList = datas;
                var foundItemDest = $scope.companyList[0];
        
                }).error(function(datas) {
            });
            
            
            $http.get($stateParams.tenantid+'/app/customerinvoice/getInvoiceNo').success(function(datas) {
            	console.log(" ::::::Invoice No::::::datas ::::::::::::::::");
            	console.log(datas);
                $scope.customerinvoice.invoiceNo = datas.InvoiceNo;
                }).error(function(datas) {
            });
            
            $http.get($stateParams.tenantid+'/app/commonUtility/getCountryList').success(function(datas) {
                $scope.countryList = datas;
                }).error(function(datas) {
            });
            
            $http.get($stateParams.tenantid+'/app/commonUtility/mlomaster').success(function(datas) {
            	console.log(" ::::::::::::datas ::::::::::::::::");
            	console.log(datas.commonUtilityBean);
                $scope.customerList = datas.commonUtilityBean;
                }).error(function(datas) {
            });
            

            
            $http.get($stateParams.tenantid+'/app/purchaseinvoice/getCurrencyList').success(function(datas) {
                $scope.currencyList = datas;
                }).error(function(datas) {
            });
        };
        
        $scope.onLoadDropdowns();
        
        
         
             	var customerCode = $scope.customerinvoice.customerCode;
                $http.get($stateParams.tenantid+'/app/customerinvoice/getTripList?customerCode='+customerCode).success(function(datas) {
                   
                	$scope.tripsList = datas.tripList;
                    $scope.customerinvoice.tripIdList=$scope.customerinvoicepopup.tripIdList;
                	 $timeout(function() {
    		                $('#tripMultiSelect').multiselect('deselectAll', false);
    		                $('#tripMultiSelect').multiselect('updateButtonText');
    		                $("#tripMultiSelect").multiselect('rebuild');
    		            
    		            }, 2, false);
    		            $("#multiselect-button").addClass("width_100 input-sm line-height-5");

                    }).error(function(datas) {
                });
            
            
     
        
        
        $scope.$watch('customerinvoice.currency', function(newValue, oldValue) {
            if(newValue!="" && newValue!=undefined && newValue!=null){
                
                $http.get($stateParams.tenantid+'/app/commonUtility/getExchangeRateWithCurrency?currencyCode='+newValue).success(function(data){
                	
                        $scope.customerinvoice.exchangeRate=data.exchangeRate;
                        angular.forEach($scope.customerinvoice.GIDtl, function(row, index) {                    	
                        	row.select=false;                       
                        });
                        $scope.customerinvoice.totalBCamount = 0;
                         $scope.customerinvoice.totalTCamount = 0; 	                        
                         $scope.customerinvoice.vatBCAmount = 0;
                         $scope.customerinvoice.vatTCAmount = 0; 	                        
                         $scope.customerinvoice.bcAmount = 0;
                         $scope.customerinvoice.tcAmount = 0;
                         
                }).error(function(data) {
                });
            }
        });
        
        
        
        
        
        /*$scope.$watch('customerinvoice.currency', function(newValue, oldValue) {
              if (newValue != '' && newValue != undefined) {
              	var cusCode = $scope.customerinvoice.customerCode;
                  $http.post($stateParams.tenantid+'/app/customerinvoice/getDetailsBasedCurrency',$scope.customerinvoice).success(function(datas) {
                   
                  	$scope.vatActive=false;
                   
                      $scope.customerinvoice.GIDtl = datas.lGeneralInvoiceDtlList;
                      $scope.customerinvoice.tripIdList = datas.tripIdList;

                 	 $timeout(function() {
     		                
     		                $('#tripMultiSelect').multiselect('updateButtonText');
     		                $("#tripMultiSelect").multiselect('rebuild');
     		            
     		            }, 2, false);
     		            $("#multiselect-button").addClass("width_100 input-sm line-height-5");
     		            

     		            
     		           if(datas.customerCurrency != null && datas.customerCurrency != undefined && datas.customerCurrency.length>0){
     		        	  var x = datas.customerCurrency.split('-')
     	                	if(x[0] !=$scope.customerinvoice.currency){
     	                		logger.logError("Customer currency is '"+x[0]+"', But you are selectin '"+$scope.customerinvoice.currency+"'");
     	                        }
     	                	}
                      
                      }).error(function(datas) {
                  });
              }
         });*/
        
        

        $('#invDate').datetimepicker({
            minDate: "01/01/2016",
            pickTime: false,
            format : 'DD/MM/YYYY'
        });

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
        var today = dd + '/' + mm + '/' + yyyy;
        $scope.customerinvoice.invDate = today;
      

        debugger;
        var generalObj = angular.copy($scope.customerinvoice, generalObj);
        var listVariable = Object.keys(generalObj);

       
        
        $scope.vatActive= false;
      
         
        
        $scope.$watch('customerinvoice.tripIdList', function(newValue, oldValue) {
        	$scope.customerinvoice.tripIdList=$scope.customerinvoicepopup.tripIdList;   
            	var cusCode = $scope.customerinvoice.customerCode;
                $http.post($stateParams.tenantid+'/app/customerinvoice/getTripDetails1',$scope.customerinvoice).success(function(datas) {
                    console.log("Trip Details ::::::::::::::");
                    console.log(datas);
                	$scope.vatActive=false;
                    $scope.customerinvoice.truckNo = datas.customerInvoiceBean.truckNo;
                    $scope.customerinvoice.trailerNo = datas.customerInvoiceBean.trailerNo;
                    $scope.customerinvoice.pol = datas.customerInvoiceBean.pol;
                    $scope.customerinvoice.pod = datas.customerInvoiceBean.pod;
                   $scope.customerinvoice.workNo = datas.customerInvoiceBean.workNo;
                   $scope.customerinvoice.consignmentId = datas.customerInvoiceBean.consignmentId;
                   $scope.customerinvoice.deliveryId = datas.customerInvoiceBean.deliveryId;
                   $scope.customerinvoice.consignmentNo = datas.customerInvoiceBean.consignmentNo;
                   $scope.customerinvoice.deliveryNo = datas.customerInvoiceBean.deliveryNo;
                   $scope.customerinvoice.consignee = datas.customerInvoiceBean.consignee;
                   $scope.customerinvoice.spifRefNo = datas.customerInvoiceBean.spifRefNo;
                   $scope.customerinvoice.deliveryGoodDescription = datas.customerInvoiceBean.deliveryGoodDescription;

                   
                    $scope.customerinvoice.GIDtl = datas.lGeneralInvoiceDtlList;
                    for(var i=0; i < $scope.customerinvoice.GIDtl.length;i++){
                    	if($scope.customerinvoice.GIDtl[i].vatPerc == 0){
                    		$scope.vatActive=true;
                    		
                    	}
                    }
                    if(datas.customerCurrency != null && datas.customerCurrency != undefined && datas.customerCurrency.length>0){
                    	var x = datas.customerCurrency.split('-')
    	                if(x[0] !=$scope.customerinvoice.currency){
    	                	logger.logError("Quotation currency is '"+x[0]+"', But you are selecting '"+$scope.customerinvoice.currency+"'");
                    	}
                    }else{
                		if(datas.alertList.length >0){
                			var list=datas.alertList;
                			var msg='';
                			angular.forEach(list, function(value, key) {
                				msg=msg+value;
                				msg=msg+"<br/>";
                			})
                        	logger.logError(msg);
                        }
                	}
                    
                    
                    $scope.calculateTotalAmount($scope.customerinvoice.GIDtl);
                    
                    }).error(function(datas) {
                });
      
                
       });
        
        
        
        $scope.getValueForSelect = function(listVariable, newValObj, oldValObj) {
            var singleDeclaredvariable = null;
            angular.forEach(listVariable, function(value) {
                if (newValObj[value] != oldValObj[value])
                    singleDeclaredvariable = value;
            });
            return singleDeclaredvariable;
        }

            
        $scope.submit = function(customerinvoiceForm,customerinvoice) {
            
                $scope.save();
             
        };
        
        $scope.display_limit = 50;
        
        $scope.increaseLimit = function () {
            if ($scope.display_limit < $scope.yearListVal.length) {
                $scope.display_limit += 50;
            }
          };
        $scope.logValidExgRateErrorMessage ="";
        
        $scope.save = function() {
            debugger;
            var check ;
            
            
            if($scope.validationCheck)
            	{
            	
                $scope.customerinvoice.GIDtl= $filter('filter')( $scope.customerinvoice.GIDtl, { select: true}, true);

         
                if ($scope.customerinvoice.isEdit == false) {
                        $http.post($stateParams.tenantid+'/app/customerinvoice/save', $scope.customerinvoice).success(function(data) {
                            if (data.success == true) {
                            	logger.logSuccess("Invoiced Saved Successfully!");
                            	ngDialog.close();
                            	$state.reload();
                            } else {
                                if(data.message != null && data.message !=''){
                                    logger.logError(data.message);
                                }else{
                                logger.logError("Unable to Save");
                                }
                            }
                        }).error(function(data) {
                        });
                }else{
                  
                    
                     $http.post($stateParams.tenantid+'/app/customerinvoice/update', $scope.customerinvoice).success(function(data) {
                        if (data == true) {
                            logger.logSuccess("Updated successfully!");
                            $location.path($stateParams.tenantid+"/invoice/generalinvoice/list");
                        } else {
                            logger.logError("Unable to Save");
                        }
                    }).error(function(data) {
                    });
                
                }
           
        }
        else
        	{
                 logger.logError("Please select atleast one row!");

        	}
        };
        
        $scope.logValidExgRateErrorMessage = "";
        
        $scope.validateExchangeRate = function(customerinvoice){
            debugger;
            var HdrLogErrMessage="",DtlLogErrMessage = "",loggerMsg="", isFlag=true;
            if(parseFloat(customerinvoice.exchangeRate) < parseFloat(customerinvoice.fromCurrency) 
                    || parseFloat(customerinvoice.exchangeRate) > parseFloat(customerinvoice.toCurrency)){
                HdrLogErrMessage="Please Enter Exchange Rate Between "+customerinvoice.fromCurrency+" and "+
                customerinvoice.toCurrency+"<br><br>";      
                
                $scope.customerinvoice.exchangeRate ='';
                isFlag = false;
              
            }
            var pinLength= customerinvoice.GIDtl.length;
            if(pinLength>0){
                
                loggerMsg = HdrLogErrMessage;
                if(loggerMsg !=""){
                    isFlag = false;
                    $scope.logValidExgRateErrorMessage = loggerMsg;                   
                }                   
            }         
            
            return isFlag;
        }
        
        /**
         * dropdown onchange
         */
        $scope.isFeederCompanyCurrency=false;
        $scope.selectedDropDown = function(userSelected) {
           switch (userSelected) {    
                case 'MloName':
                    if(     $scope.customerinvoice.MloName=='PFOR0004' ||
                            $scope.customerinvoice.MloName=='PWAN0002'){
                        $scope.customerinvoice.CurrencyCode = 'AED';
                        $scope.customerinvoice.CurrencyName = 'AED';
                        $scope.customerinvoice.exchangeRate =3.685;
                        $scope.customerinvoice.fromCurrency=3.660;
                        $scope.customerinvoice.toCurrency=3.686;
                    }else if($scope.customerinvoice.MloName == 'PEVE0002'||
                            $scope.customerinvoice.MloName == 'PUNI0027'){
                        $scope.customerinvoice.CurrencyCode = 'AED';
                        $scope.customerinvoice.CurrencyName = 'AED';
                        $scope.customerinvoice.exchangeRate =3.67;
                        $scope.customerinvoice.fromCurrency=3.660;
                        $scope.customerinvoice.toCurrency=3.686;
                    }else if($scope.customerinvoice.MloName == 'PACE0001'){
                        $scope.customerinvoice.CurrencyCode = 'AED';
                        $scope.customerinvoice.CurrencyName = 'AED';
                        $scope.customerinvoice.exchangeRate =3.68;
                        $scope.customerinvoice.fromCurrency=3.660;
                        $scope.customerinvoice.toCurrency=3.686;
                    }
                    else{
                        var index = $scope.getIndex($scope.mloList, $scope.customerinvoice.MloName);
                        if(index !=undefined){
                          
                            $scope.customerinvoice.CurrencyCode = $scope.mloList[index].CurrencyCode;
                            $scope.customerinvoice.CurrencyName = $scope.mloList[index].CurrencyCode;
                            if($scope.sailingDate !='' && $scope.sailingDate != undefined){
                                $http.get($stateParams.tenantid+'/app/commonUtility/getExchangeRateWithCurrencyBySailingDate?currencyCode='+ $scope.customerinvoice.CurrencyCode+'&sailingDate='+$scope.sailingDate).success(function(data) {
                                   
                                    debugger;
                                    $scope.customerinvoice.exchangeRate=data.exchangeRate;
                                    $scope.customerinvoice.fromCurrency=data.fromCurrency;
                                    $scope.customerinvoice.toCurrency=data.toCurrency;     
                                }).error(function(data) {
                                });
                            }else{
                                $http.get($stateParams.tenantid+'/app/commonUtility/getExchangeRateWithCurrencyByMaxDate?currencyCode='+ $scope.customerinvoice.CurrencyCode).success(function(data) {
                                   
                                    debugger;
                                    $scope.customerinvoice.exchangeRate=data.exchangeRate;
                                    $scope.customerinvoice.fromCurrency=data.fromCurrency;
                                    $scope.customerinvoice.toCurrency=data.toCurrency;     
                                }).error(function(data) {
                                });
                            }
                            
                        }
                    }
                   
                    break;
                    
                case 'VesselName':
                
                    $scope.dataList.then(function(voyageLists) {
        
                        $scope.voyagehdrList = voyageLists;
        
                    });
                    break;
                 
                case 'CompanyCode':
                    debugger;
                    $http.get($stateParams.tenantid+'/app/generalinvoice/getCompanyCurrency?CompanyCode='+$scope.customerinvoice.CompanyCode).success(function(datas) {
                        $scope.companyCurrency=datas.CurrencyCode;
                        }).error(function(datas) {
                    });
                    if($scope.customerinvoice.CompanyCode=="C0001"){
                        $scope.isFeederCompanyCurrency=true;
                    }else{
                        $scope.isFeederCompanyCurrency=false;
                    }
                    
                    break;
                    
                case 'Voyage':
                    
                    $scope.sailingDate='';
                 
                    $scope.dataList.then(function(customerLists) {
                        if(customerLists.length>0)
                            $scope.customerhdrList = customerLists;
                    });
                    
                  
                    $scope.dataList.then(function(PortLists) {
                        $scope.PorthdrList = PortLists;
                    });
        
                    var index = $scope.getIndex($scope.voyagehdrList, $scope.customerinvoice.Voyage);
                    $scope.customerinvoice.ServiceName = $scope.voyagehdrList[index].ServiceName;
                    break;
                    
                    
                case 'Pol':
                    debugger;
                    
               
                    $scope.dataList.then(function(mloLists) {
                        $scope.mloList = mloLists;
                        debugger;
                        console.log($scope.mloList);
                    });
                    break;
                 
                case 'CustomerName':
                   
                    $scope.dataList.then(function(mloLists) {
                        $scope.mloList = mloLists;
                        debugger;
                        console.log($scope.mloList);
                    });
                    
                 
                    $scope.dataList.then(function(blLists) {
                        $scope.blList = blLists;
                    });
                    
                    if($scope.customerinvoice.Voyage !='' && $scope.customerinvoice.Pol !='' && $scope.customerinvoice.CustomerName !=''){
                        $http.get($stateParams.tenantid+'/app/customerinvoice/getSailingDate?voyageCode=' + $scope.customerinvoice.Voyage+'&pol=' +$scope.customerinvoice.Pol+'&customer='+$scope.customerinvoice.CustomerName).success(function(datas) {
                            $scope.sailingDate = datas.sailingDate;
                            }).error(function(datas) {
                        });
                    }
                    
                break;
                
                case 'bl':
                    $http.get($stateParams.tenantid+'/app/customerinvoice/fetchDetailList?bl='+$scope.customerinvoice.bl).success(function(datas) {
                        console.log(datas.GIDtl);
                        $scope.customerinvoice.GIDtl = datas.GIDtl;
                        }).error(function(datas) {
                    });
                    
                break;
                       
                case 'CurrencyName':   
                    $scope.getcurrencyValues($scope.customerinvoice.CurrencyName);    
                    
                break;
            }
        }

        $scope.getIndex = function(list, name) {
            var foundItem = $filter('filter')(list, {
                id : name
            }, true)[0];
            var index = list.indexOf(foundItem);
            return index;
        }

        $scope.customerInvoiceDtlList = function() {
            var giRow = {
            		containerType:'',
                    containerNo:'',
                    description:'',
                    actualRate:'',
                    currency:'',
                    exRate:'',
                    rate:'',
                    qty:'',
                    total :'',
                    taxFree:'',
                    remarks:''
            };
            $scope.customerinvoice.GIDtl.push(giRow);
        }

        $scope.customerInvoiceDtlList();
        
        $scope.addRow = function(miscelList) {
        	debugger
            var table = {
                   containerType:'',
                   containerNo:'',
                   currency : '',
                   description:'',
                   actualRate:'',
                   currency:'',
                   exRate:'',
                   rate:'',
                   qty:'',
                   total :'',
                   taxFree:'',
                   remarks:''
                 
                   
            };
            
        	 $scope.customerinvoice.GIDtl.push(table);
        };
        // removeRow
        $scope.removeRow = function(GItable) {
            debugger;
            $scope.tablerow = [];
            angular.forEach(GItable, function(row, index) {
                var check = row.select;
                if (check == undefined || check == "") {
                    $scope.tablerow.push(row);
                } else {

                }
            });
            $scope.customerinvoice.GIDtl = $scope.tablerow;;
        };
       
        
       
        
        $scope.getcurrencyValues = function(currencyValue){
            if(currencyValue!=null && currencyValue!=undefined && currencyValue!=""){
                $http.get($stateParams.tenantid+'/app/commonUtility/getExchangeRateWithCurrency?currencyCode='+currencyValue).success(function(data) {
                    debugger;
                       
                    $scope.customerinvoice.exchangeRate=data.exchangeRate;
                    $scope.customerinvoice.fromCurrency=data.fromCurrency;
                    $scope.customerinvoice.toCurrency=data.toCurrency;     
                }).error(function(data) {
                });
            }else{
                $scope.customerinvoice.exchangeRate='';
                $scope.customerinvoice.fromCurrency='';
                $scope.customerinvoice.toCurrency='';
            }
        }  
        
        $scope.exchagerateGIhdr = function(exchangeRate){
            debugger; 
            if(exchangeRate>0){
                if(parseFloat(exchangeRate) < $scope.customerinvoice.fromCurrency || parseFloat(exchangeRate) > $scope.customerinvoice.toCurrency){
                    logger.logError("Please Enter Exchange Rate Between "+$scope.customerinvoice.fromCurrency+" and "+
                            $scope.customerinvoice.toCurrency);       
                    $scope.customerinvoice.exchangeRate=0;
                }else{
                    var bcAmount=0.0, tcAmount=0.0;
                    angular.forEach($scope.customerinvoice.GIDtl, function(giRow,giIndex){
                        debugger;
                        if(isNaN(parseFloat(giRow.tcAmount, 10))){
                            if(isNaN(parseFloat(giRow.bcAmount, 10))){
                             
                                var bcAmt = Math.floor(((isNaN(parseFloat(giRow.tcAmount, 10))?0:giRow.tcAmount) * parseFloat(exchangeRate))*100)/100;
                                var tcAmt = Math.floor(((isNaN(parseFloat(giRow.bcAmount, 10))?0:giRow.bcAmount) / parseFloat(exchangeRate))*100)/100;
                                giRow.tcAmount = isNaN(tcAmt)?0:tcAmt.toFixed(2); 
                                giRow.bcAmount = isNaN(bcAmt)?0:bcAmt.toFixed(2); 
                            }else{
                              
                                var tcAmt = Math.floor(((isNaN(parseFloat(giRow.bcAmount, 10))?0:giRow.bcAmount) / parseFloat(exchangeRate))*100)/100;
                                giRow.tcAmount = isNaN(tcAmt)?0:tcAmt.toFixed(2);  
                            }
                        }else {
                            
                            var bcAmt = Math.floor(((isNaN(parseFloat( giRow.tcAmount, 10))?0: giRow.tcAmount) * parseFloat(exchangeRate))*100)/100;                    
                            giRow.bcAmount = parseFloat(bcAmt).toFixed(2);
                        } 
                    });        
                }
                  
                
            }
            $scope.calculateTotalAmount($scope.customerinvoice.GIDtl);
         }
        
        $scope.calculateTCtoBCAmount = function( trIndex, row) {
            debugger;
            if (tcAmount != null) {
                if ($scope.customerinvoice.exchangeRate != 0 && $scope.customerinvoice.exchangeRate != ""){
                 
                  var bcAmount = Math.floor(((isNaN(parseFloat( tcAmount, 10))?0: tcAmount) * parseFloat($scope.customerinvoice.exchangeRate))*100)/100;
                   row.bcAmount= isNaN(bcAmount)?0:bcAmount;
                }
                else{
                    tcAmount = Math.floor(((isNaN(parseFloat( tcAmount, 10))?0: tcAmount))*100)/100;
                    row.bcAmount = (parseFloat(tcAmount)).toFixed(2);
                }                
            } else {
                row.bcAmount = 0.0;
                row.tcAmount = 0.0;
            }
            $scope.calculateTotalAmount($scope.customerinvoice.GIDtl);
        };

        $scope.calculateBCtoTCAmount = function(bcAmount, trIndex, row) {
            debugger;
            if (bcAmount != null) {
                if ($scope.customerinvoice.exchangeRate != 0 && $scope.customerinvoice.exchangeRate != ""){
                   
                    var tcAmt = Math.floor(((isNaN(parseFloat( bcAmount, 10))?0: bcAmount) / parseFloat($scope.customerinvoice.exchangeRate))*100)/100;
                    row.tcAmount =isNaN(tcAmt)?0:tcAmt;
                }                
                else{
                    bcAmount = Math.floor(((isNaN(parseFloat( bcAmount, 10))?0: bcAmount))*100)/100;
                    var tcAmt = (parseFloat(bcAmount)).toFixed(2);
                    row.tcAmount = isNaN(tcAmt)?0:tcAmt;
                }
                    
            } else {
                row.bcAmount = 0.0;
                row.tcAmount = 0.0;
            }
            $scope.calculateTotalAmount($scope.customerinvoice.GIDtl);
        };
        
        $scope.validationCheck = false;
        $scope.calculateTotalAmount = function(tables) {
            debugger;
            if ($scope.customerinvoice.currency != '' && $scope.customerinvoice.currency != undefined) {
              	var cusCode = $scope.customerinvoice.customerCode;
                  $http.post($stateParams.tenantid+'/app/customerinvoice/getDetailsBasedCurrency',$scope.customerinvoice).success(function(datas) {
                     if(datas.customerCurrency != null && datas.customerCurrency != undefined && datas.customerCurrency.length>0){
     		        	  var x = datas.customerCurrency.split('-')
     	                	if(x[0] !=$scope.customerinvoice.currency){
     	                		  angular.forEach($scope.customerinvoice.GIDtl, function(row, index) {                    	
     	                         	row.select=false;                       
     	                         });
     	                		 $scope.customerinvoice.totalBCamount = 0;
     	                        $scope.customerinvoice.totalTCamount = 0; 	                        
     	                        $scope.customerinvoice.vatBCAmount = 0;
     	                        $scope.customerinvoice.vatTCAmount = 0; 	                        
     	                        $scope.customerinvoice.bcAmount = 0;
     	                        $scope.customerinvoice.tcAmount = 0;
     	                        
     	                		logger.logError("Customer currency is '"+x[0]+"', But you are selectin '"+$scope.customerinvoice.currency+"'");
     	                        }
     	                	}
                      
                      }).error(function(datas) {
                  });
              }
            var totalBCamount = 0.0, totalTCamount = 0.0, bcAmountTot = 0.0, tcAmountTot = 0.0, vatBCamount = 0.0, vatTCamount = 0.0;
            angular.forEach(tables, function(row, index) {
            	
            	if(row.select){
            		
            		$scope.validationCheck = true;
            		
            		 if($scope.customerinvoice.currency != row.currency){
            			 
            			 var bcGrandTot = row.totalAmount , bcAmount = row.amount , bcTax = row.vatAmount,tcAmount =0,tcTax =0,tcGrandTot=0;
            		 if ($scope.customerinvoice.exchangeRate != 0 && $scope.customerinvoice.exchangeRate != ""){
            	        	
                         tcAmount = Math.floor(((isNaN(parseFloat( bcAmount, 10))?0: bcAmount) * parseFloat($scope.customerinvoice.exchangeRate))*100)/100;
                      
                         
                         tcTax = Math.floor(((isNaN(parseFloat( bcTax, 10))?0: bcTax) * parseFloat($scope.customerinvoice.exchangeRate))*100)/100;
                     
                         
                         tcGrandTot = Math.floor(((isNaN(parseFloat( bcGrandTot, 10))?0: bcGrandTot) * parseFloat($scope.customerinvoice.exchangeRate))*100)/100;
                      
                      }
            		 
            	
                   
            		 
            		 else{
                         bcAmount = Math.floor(((isNaN(parseFloat( bcAmount, 10))?0: bcAmount))*100)/100;
                         tcAmount = (parseFloat(bcAmount)).toFixed(2);
                         
                         bcTax = Math.floor(((isNaN(parseFloat( bcTax, 10))?0: bcTax))*100)/100;
                         tcTax = (parseFloat(bcTax)).toFixed(2);
                         
                         bcGrandTot = Math.floor(((isNaN(parseFloat( bcGrandTot, 10))?0: bcGrandTot))*100)/100;
                         tcGrandTot = (parseFloat(bcGrandTot)).toFixed(2);
                     } 
            		 }
            		 else{
            			 
            			 var tcGrandTot = row.totalAmount , tcAmount = row.amount , tcTax = row.vatAmount,bcAmount =0,bcTax =0,bcGrandTot=0;
                		 if ($scope.customerinvoice.exchangeRate != 0 && $scope.customerinvoice.exchangeRate != ""){
                	        	
                            
                             
                             bcAmount = Math.floor(((isNaN(parseFloat( tcAmount, 10))?0: tcAmount) / parseFloat($scope.customerinvoice.exchangeRate))*100)/100;

                       
                             
                             bcTax = Math.floor(((isNaN(parseFloat( tcTax, 10))?0: tcTax) / parseFloat($scope.customerinvoice.exchangeRate))*100)/100;
                         
                             
                             bcGrandTot = Math.floor(((isNaN(parseFloat( tcGrandTot, 10))?0: tcGrandTot) / parseFloat($scope.customerinvoice.exchangeRate))*100)/100;
                           
                          }
                		 
                		 else{
                             bcAmount = Math.floor(((isNaN(parseFloat( bcAmount, 10))?0: bcAmount))*100)/100;
                             tcAmount = (parseFloat(bcAmount)).toFixed(2);
                             
                             bcTax = Math.floor(((isNaN(parseFloat( bcTax, 10))?0: bcTax))*100)/100;
                             tcTax = (parseFloat(bcTax)).toFixed(2);
                             
                             bcGrandTot = Math.floor(((isNaN(parseFloat( bcGrandTot, 10))?0: bcGrandTot))*100)/100;
                             tcGrandTot = (parseFloat(bcGrandTot)).toFixed(2);
                         } 
                		 }
            		 
            		 totalBCamount = (parseFloat(totalBCamount) + parseFloat(bcGrandTot)).toFixed(2);
                     totalTCamount = (parseFloat(totalTCamount) + parseFloat(tcGrandTot)).toFixed(2);
                     
                     bcAmountTot = (parseFloat(bcAmountTot) + parseFloat(bcAmount)).toFixed(2);
                     tcAmountTot = (parseFloat(tcAmountTot) + parseFloat(tcAmount)).toFixed(2);
                     
                     vatBCamount = (parseFloat(vatBCamount) + parseFloat(bcTax)).toFixed(2);
                     vatTCamount = (parseFloat(vatTCamount) + parseFloat(tcTax)).toFixed(2);
            	}
               
            });
            $scope.customerinvoice.totalBCamount = totalBCamount;
            $scope.customerinvoice.totalTCamount = totalTCamount;
            
            $scope.customerinvoice.vatBCAmount = vatBCamount;
            $scope.customerinvoice.vatTCAmount = vatTCamount;
            
            $scope.customerinvoice.bcAmount = bcAmountTot;
            $scope.customerinvoice.tcAmount = tcAmountTot;
        };
        
        $scope.getEdit = function(sInvoiceNo) {
            var url = $stateParams.tenantid+'/app/customerinvoice/edit?customerinvoiceNo=' + sInvoiceNo;
            $http.get(url).success(function(result) {
                debugger;
                $scope.customerinvoice.InvoiceDate = result.InvoiceDate;
                $scope.customerinvoice.bLlist= result.bLlist;
                $scope.customerinvoice.customerList= result.customerList;
                $scope.mloList= result.mloList;
                $scope.customerinvoice.voyagehdrList= result.voyageList;
                $scope.customerinvoice.porthdrList= result.portList;
                $scope.customerinvoice.VesselhdrList= result.vesselList;

                $scope.customerinvoice.BlRelated = result.BlRelated;
                $scope.customerinvoice.Company = result.Company;
                $scope.customerinvoice.CompanyCode = result.CompanyCode;
                $scope.customerinvoice.CurrencyCode = result.CurrencyCode;
                $scope.customerinvoice.CurrencyName = result.CurrencyName;
                $scope.customerinvoice.CustomerCode = result.CustomerCode;
                $scope.customerinvoice.CustomerName = result.CustomerName;
                $scope.customerinvoice.exchangeRate = result.exchangeRate;
               
              
                var date= result.InvoiceDate;
                var d=new Date(date.split("-").reverse().join("/"));
                var dd=d.getDate();
                var mm=d.getMonth()+1;
                var yy=d.getFullYear();
                var invoiceFormattedDate=dd+"/"+mm+"/"+yy;
                
                $scope.customerinvoice.InvoiceDate = invoiceFormattedDate;
                $scope.customerinvoice.InvoiceNo = result.InvoiceNo;
            
                $scope.customerinvoice.MloName = result.MloName;
                $scope.customerinvoice.Pod = result.Pod;
                $scope.customerinvoice.Pol = result.Pol;
                $scope.customerinvoice.Port = result.Port;
                $scope.customerinvoice.PortSequence = result.PortSequence;
                $scope.customerinvoice.ServiceCode = result.ServiceCode;
                $scope.customerinvoice.ServiceName = result.ServiceName;
                $scope.customerinvoice.Subject = result.Subject;
              
                $scope.customerinvoice.Unit20 = result.Unit20;
                $scope.customerinvoice.Unit40 = result.Unit40;
                
                $scope.customerinvoice.VesselName = result.VesselName;
                $scope.customerinvoice.Voyage = result.Voyage;
                
                $scope.customerinvoice.GIDtl = result.GIDtl;
                
                $scope.calculateTotalAmount($scope.customerinvoice.GIDtl);

            }).error(function(result) {
                logger.logError("Error Please Try Again");
            });

        }

        var InvoiceNo=$stateParams.InvoiceNo;
        if(InvoiceNo == undefined || InvoiceNo == null || InvoiceNo ==""){
            $scope.customerinvoice.isEdit=false;
        }else{
            $scope.customerinvoice.isEdit =true;
            $scope.getEdit(InvoiceNo);
        }
        
        $scope.isOwner = false;
        $scope.checkOwner = function(){
            $http.get($stateParams.tenantid+'/app/cashbankreceipt/checkOwnerUser').success(function(data) {
                    console.log("owner")
                    console.log(data)
                    $scope.isOwner = data;
            });
        }
        $scope.checkOwner();
        
        /**
         * print
         */
        $scope.printCustInvoiceDiv = function(invoiceNo){
            
            console.log("Both print invoice")
            var url = $stateParams.tenantid+'/app/customerinvoice/print?invoiceNo=' + invoiceNo;
            var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
            if (wnd.print) { var done = false; if (wnd.document && wnd.document.readyState) { var rs = wnd.document.readyState; if ((rs === 'complete') || (rs === 'loaded')) { done = true; wnd.print(); } } if (!done) { if (wnd.addEventListener) { wnd.addEventListener('load', function() { this.print(); }); } else { wnd.onload = function() { this.print(); }; } } }
            
            //wnd.print(); 
            
            
            
         }
        
        $scope.printCustInvoiceLocal = function(invoiceNo){
            
            console.log("Local print invoice")
            var url = $stateParams.tenantid+'/app/customerinvoice/printLocal?invoiceNo=' + invoiceNo;
            var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
            if (wnd.print) { var done = false; if (wnd.document && wnd.document.readyState) { var rs = wnd.document.readyState; if ((rs === 'complete') || (rs === 'loaded')) { done = true; wnd.print(); } } if (!done) { if (wnd.addEventListener) { wnd.addEventListener('load', function() { this.print(); }); } else { wnd.onload = function() { this.print(); }; } } }
         
         }
     
    	 $scope.printCustInvoiceUSD = function(invoiceNo){
    	     
    	     console.log("USD print invoice")
    	     var url = $stateParams.tenantid+'/app/customerinvoice/printUSD?invoiceNo=' + invoiceNo;
    	     var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
    	     if (wnd.print) { var done = false; if (wnd.document && wnd.document.readyState) { var rs = wnd.document.readyState; if ((rs === 'complete') || (rs === 'loaded')) { done = true; wnd.print(); } } if (!done) { if (wnd.addEventListener) { wnd.addEventListener('load', function() { this.print(); }); } else { wnd.onload = function() { this.print(); }; } } }
    	   
    	  }
        


    		});

    app.controller('bulkinvoiceDialogIdCtrl',function($scope, $rootScope, $injector, $http, ngDialog,$location, logger, utilsService, $state,
    		sharedProperties, $window, toaster, validationService,$stateParams,$timeout,$filter) {
    	 
        $scope.mloList=[];
        $scope.PorthdrList=[];
        $scope.voyagehdrList=[];
        $scope.bulkinvoice = {
    		vatBCAmount :'',
    		vatTCAmount :'',
    		grandBCamount :'',
    		grandTCamount :'',
            Company : '',
            CompanyCode : '',
            CustomerName : '', 
            MloName : '', 
            Voyage : '', 
            VesselName : '', 
            currency:'',
            AccountName : '', 
           // Company : '', 
            ServiceName : '',
            currencyName : '', 
            exchangeRate : '', 
            fromCurrency: '',
            toCurrency:'',
            Pol : '', 
            Pod : '', 
            consignmentNo : '',
            deliveryNo : '',
            spifRefNo : '',
            consignee : '',
            consignmentId : '',
            deliveryId : '',
            Subject : '', 
            Unit20 : '', 
            Unit40 : '', 
            workOrderNo : '',
            remark : '', 
            bl : '',
            exchangeRateFrom : '', 
            exchangeRateTo : '', 
            currencyValue : '',
            fraction : '', 
            invoiceDate : '',
            TotalBCamount : '', 
            TotalTCamount : '', 
            BlRelated : true,
            isEdit : false,
            GIDtl : [],
            miscelList : [],
            tripIdList :[],
            deliveryGoodDescription :''
        }
        $scope.bulkinvoice.customerCode=$scope.customerinvoicepopup.customerCode;
        
        $scope.currentURL=$location.protocol() + '://'+ $location.host() +':'+  $location.port()+"/#" +$location.path();
        
        if(window.localStorage.getItem('giv')==$scope.currentURL){
            alert('window ' + $scope.currentURL + ' is already opened');
           
        }else{
            window.localStorage.setItem('giv', $scope.currentURL);
            
        }
        $(window).unload(function(){
         
             localStorage.removeItem('giv');
           });

        $scope.cancel = function() {
        	ngDialog.close();
        };
        
        
        $("#tripMultiSelect").multiselect({
            maxHeight: 200,   
            includeSelectAllOption: true,
            disableIfEmpty: true,
            enableCaseInsensitiveFiltering: true,
            onDropdownHide: function (event) {
                
            }
          });
        $(".multiselect").addClass("width_100 input-sm line-height-5");
        
        
        $scope.onLoadDropdowns = function() {
            $http.get($stateParams.tenantid+'/app/usermaster/getCompanyList?formCode='+$('#form_code_id').val()).success(function(datas) {
                $scope.companyList = datas;
                var foundItemDest = $scope.companyList[0];
          //      $scope.bulkinvoice.CompanyCode=foundItemDest.id;
                }).error(function(datas) {
            });
            
            
            $http.get($stateParams.tenantid+'/app/customerinvoice/getBulkInvoiceNo').success(function(datas) {
            	console.log(" ::::::Invoice No::::::datas ::::::::::::::::");
            	console.log(datas);
                $scope.bulkinvoice.invoiceNo = datas.bulkInvoiceNo;
                }).error(function(datas) {
            });
            
            $http.get($stateParams.tenantid+'/app/commonUtility/getCountryList').success(function(datas) {
                $scope.countryList = datas;
                }).error(function(datas) {
            });
            
            $http.get($stateParams.tenantid+'/app/commonUtility/mlomaster').success(function(datas) {
            	console.log(" ::::::::::::datas ::::::::::::::::");
            	console.log(datas.commonUtilityBean);
                $scope.customerList = datas.commonUtilityBean;
                }).error(function(datas) {
            });
            
            $http.get($stateParams.tenantid+'/app/purchaseinvoice/getCurrencyList').success(function(datas) {
                $scope.currencyList = datas;
                }).error(function(datas) {
            });
        };
        
        $scope.onLoadDropdowns();
        
        
        $scope.bulkinvoice.tripIdList =[];
        $scope.customerinvoicepopup.tripIdList;
        $scope.$watch('bulkinvoice.customerCode', function(newValue, oldValue) {
            if (newValue != '' && newValue != undefined) {
            	var customerCode = $scope.bulkinvoice.customerCode;
                $http.get($stateParams.tenantid+'/app/customerinvoice/getTripList1?customerCode='+customerCode).success(function(datas) {
                   console.log(datas);
                	$scope.tripsList = datas.tripList1;
                 	$scope.bulkinvoice.tripIdList=$scope.customerinvoicepopup.tripIdList; 
                	 $timeout(function() {
    		                $('#tripMultiSelect').multiselect('deselectAll', false);
    		                $('#tripMultiSelect').multiselect('updateButtonText');
    		                $("#tripMultiSelect").multiselect('rebuild');
    		            
    		            }, 2, false);
    		            $("#multiselect-button").addClass("width_100 input-sm line-height-5");

                    }).error(function(datas) {
                });
            }
            
            
       });
        
        
        $scope.$watch('bulkinvoice.currencyName', function(newValue, oldValue) {
            if(newValue!="" && newValue!=undefined && newValue!=null){
                
                $http.get($stateParams.tenantid+'/app/commonUtility/getExchangeRateWithCurrency?currencyCode='+newValue).success(function(data){
                	
                        $scope.bulkinvoice.exchangeRate=data.exchangeRate;
                              
                }).error(function(data) {
                });
            }
        });
        
        
        
        
        
        $scope.$watch('bulkinvoice.currencyName', function(newValue, oldValue) {
              if (newValue != '' && newValue != undefined) {
              	var cusCode = $scope.bulkinvoice.customerCode;
                  $http.post($stateParams.tenantid+'/app/customerinvoice/getDetailsBasedCurrency',$scope.bulkinvoice).success(function(datas) {
                   
                  	$scope.vatActive=false;
//                     
                      $scope.bulkinvoice.GIDtl = datas.lGeneralInvoiceDtlList;
                      $scope.bulkinvoice.tripIdList = datas.tripIdList;

                 	 $timeout(function() {
     		              
     		                $('#tripMultiSelect').multiselect('updateButtonText');
     		                $("#tripMultiSelect").multiselect('rebuild');
     		            
     		            }, 2, false);
     		            $("#multiselect-button").addClass("width_100 input-sm line-height-5");
     		            

     		            
     		           if(datas.customerCurrency != null && datas.customerCurrency != undefined && datas.customerCurrency.length>0){
     		        	  var x = datas.customerCurrency.split('-')
     	                	if(x[0] !=$scope.bulkinvoice.currencyName){
     	                		logger.logError("Customer currency is '"+x[0]+"', But you are selecting '"+$scope.bulkinvoice.currencyName+"'");
     	                        }
     	                	}
                      
                      }).error(function(datas) {
                  });
              }
         });
        
        

        $('#invoiceDate').datetimepicker({
            minDate: "01/01/2016",
            pickTime: false,
            format : 'DD/MM/YYYY'
        });

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
        var today = dd + '/' + mm + '/' + yyyy;
        $scope.bulkinvoice.invoiceDate = today;
      

        debugger;
        var generalObj = angular.copy($scope.bulkinvoice, generalObj);
        var listVariable = Object.keys(generalObj);

       
        
        $scope.vatActive= false;

        
        
        $scope.$watch('bulkinvoice.tripIdList', function(newValue, oldValue) {
        	$scope.bulkinvoice.tripIdList=$scope.customerinvoicepopup.tripIdList;   
            	var cusCode = $scope.bulkinvoice.customerCode;
                $http.post($stateParams.tenantid+'/app/customerinvoice/getTripDetails1',$scope.bulkinvoice).success(function(datas) {
                    console.log("Trip Details ::::::::::::::");
                    console.log(datas);
                	$scope.vatActive=false;
                    $scope.bulkinvoice.truckNo = datas.customerInvoiceBean.truckNo;
                    $scope.bulkinvoice.trailerNo = datas.customerInvoiceBean.trailerNo;
                    $scope.bulkinvoice.pol = datas.customerInvoiceBean.pol;
                    $scope.bulkinvoice.pod = datas.customerInvoiceBean.pod;
                   $scope.bulkinvoice.workNo = datas.customerInvoiceBean.workNo;
                   $scope.bulkinvoice.consignmentId = datas.customerInvoiceBean.consignmentId;
                   $scope.bulkinvoice.deliveryId = datas.customerInvoiceBean.deliveryId;
                   $scope.bulkinvoice.consignmentNo = datas.customerInvoiceBean.consignmentNo;
                   $scope.bulkinvoice.deliveryNo = datas.customerInvoiceBean.deliveryNo;
                   $scope.bulkinvoice.consignee = datas.customerInvoiceBean.consignee;
                   $scope.bulkinvoice.spifRefNo = datas.customerInvoiceBean.spifRefNo;
                   $scope.bulkinvoice.deliveryGoodDescription = datas.customerInvoiceBean.deliveryGoodDescription;

                   
                    $scope.bulkinvoice.GIDtl = datas.lGeneralInvoiceDtlList;
                    for(var i=0; i < $scope.bulkinvoice.GIDtl.length;i++){
                    	if($scope.bulkinvoice.GIDtl[i].vatPerc == 0){
                    		$scope.vatActive=true;
                    		
                    	}
                    }
                    if(datas.customerCurrency != null && datas.customerCurrency != undefined && datas.customerCurrency.length>0){
                    	var x = datas.customerCurrency.split('-')
    	                if(x[0] !=$scope.bulkinvoice.currency){
    	                	logger.logError("Quotation currency is '"+x[0]+"', But you are selecting '"+$scope.bulkinvoice.currency+"'");
                    	}
                    }else{
                		if(datas.alertList.length >0){
                			var list=datas.alertList;
                			var msg='';
                			angular.forEach(list, function(value, key) {
                				msg=msg+value;
                				msg=msg+"<br/>";
                			})
                        	logger.logError(msg);
                        }
                	}
                    
                    
                    $scope.calculateTotalAmount($scope.bulkinvoice.GIDtl);
                    
                    }).error(function(datas) {
                });
         
                
       });
        
        
        
        $scope.getValueForSelect = function(listVariable, newValObj, oldValObj) {
            var singleDeclaredvariable = null;
            angular.forEach(listVariable, function(value) {
                if (newValObj[value] != oldValObj[value])
                    singleDeclaredvariable = value;
            });
            return singleDeclaredvariable;
        }

            
        $scope.submit = function(bulkinvoiceForm,bulkinvoice) {
            if (new validationService().checkFormValidity(bulkinvoiceForm)) {
                $scope.save();
            } else {
                toaster.pop('error', "Please fill the required fields", 
                        logger.getErrorHtmlNew($scope.bulkinvoiceForm.$validationSummary), 5000, 'trustedHtml');
            }
        };
        
        $scope.display_limit = 50;
        
        $scope.increaseLimit = function () {
            if ($scope.display_limit < $scope.yearListVal.length) {
                $scope.display_limit += 50;
            }
          };
        $scope.logValidExgRateErrorMessage ="";
        
        $scope.save = function() {
            debugger;
            var isExgRateValid = $scope.validateExchangeRate($scope.bulkinvoice);
            if(isExgRateValid){
                if ($scope.bulkinvoice.isEdit == false) {
                    $scope.calculateTotalAmount($scope.bulkinvoice.GIDtl);
                    $scope.bulkinvoice.customerCode =$scope.Customercode1;
                    console.log($scope.bulkinvoice);
                       // $scope.bulkinvoice.InvoiceDate = $("#txtInvoiceDate").val();
                        $http.post($stateParams.tenantid+'/app/generalinvoice/save', $scope.bulkinvoice).success(function(data) {
                            if (data.success == true) {
                                logger.logSuccess("Created successfully!");
                              //$location.path($stateParams.tenantid+"/bulkinvoice/bulkinvoicelist");
                    			$location.url($stateParams.tenantid+'/bulkinvoice/bulkinvoicelist');

                            } else {
                                if(data.message != null && data.message !=''){
                                    logger.logError(data.message);
                                }else{
                                logger.logError("Unable to Save");
                                }
                            }
                        }).error(function(data) {
                        });
                }else{
                   
                    
                     $http.post($stateParams.tenantid+'/app/generalinvoice/update', $scope.bulkinvoice).success(function(data) {
                        if (data == true) {
                            logger.logSuccess("Updated successfully!");
                            $location.path($stateParams.tenantid+"/bulkinvoice/bulkinvoicelist");
                        } else {
                            logger.logError("Unable to Save");
                        }
                    }).error(function(data) {
                    });
                
                }
            }else{
                logger.logError($scope.logValidExgRateErrorMessage);
            }
            
        };
        
        $scope.logValidExgRateErrorMessage = "";
        
        $scope.validateExchangeRate = function(bulkinvoice){
            debugger;
            var HdrLogErrMessage="",DtlLogErrMessage = "",loggerMsg="", isFlag=true;
            if(parseFloat(bulkinvoice.exchangeRate) < parseFloat(bulkinvoice.fromCurrency) 
                    || parseFloat(bulkinvoice.exchangeRate) > parseFloat(bulkinvoice.toCurrency)){
                HdrLogErrMessage="Please Enter Exchange Rate Between "+bulkinvoice.fromCurrency+" and "+
                bulkinvoice.toCurrency+"<br><br>";      
                //customerinvoice.exchangeRate=0;
                $scope.bulkinvoice.exchangeRate ='';
                isFlag = false;
              
            }
            var pinLength= bulkinvoice.GIDtl.length;
            if(pinLength>0){
                
                loggerMsg = HdrLogErrMessage;
                if(loggerMsg !=""){
                    isFlag = false;
                    $scope.logValidExgRateErrorMessage = loggerMsg;                   
                }                   
            }         
            
            return isFlag;
        }
        
        /**
         * dropdown onchange
         */
        $scope.isFeederCompanyCurrency=false;
        $scope.selectedDropDown = function(userSelected) {
           switch (userSelected) {    
                case 'MloName':
                    if(     $scope.bulkinvoice.MloName=='PFOR0004' ||
                            $scope.bulkinvoice.MloName=='PWAN0002'){
                        $scope.bulkinvoice.CurrencyCode = 'AED';
                        $scope.bulkinvoice.currencyName = 'AED';
                        $scope.bulkinvoice.exchangeRate =3.685;
                        $scope.bulkinvoice.fromCurrency=3.660;
                        $scope.bulkinvoice.toCurrency=3.686;
                    }else if($scope.bulkinvoice.MloName == 'PEVE0002'||
                            $scope.bulkinvoice.MloName == 'PUNI0027'){
                        $scope.bulkinvoice.CurrencyCode = 'AED';
                        $scope.bulkinvoice.currencyName = 'AED';
                        $scope.bulkinvoice.exchangeRate =3.67;
                        $scope.bulkinvoice.fromCurrency=3.660;
                        $scope.bulkinvoice.toCurrency=3.686;
                    }else if($scope.bulkinvoice.MloName == 'PACE0001'){
                        $scope.bulkinvoice.CurrencyCode = 'AED';
                        $scope.bulkinvoice.currencyName = 'AED';
                        $scope.bulkinvoice.exchangeRate =3.68;
                        $scope.bulkinvoice.fromCurrency=3.660;
                        $scope.bulkinvoice.toCurrency=3.686;
                    }
                    else{
                        var index = $scope.getIndex($scope.mloList, $scope.bulkinvoice.MloName);
                        if(index !=undefined){
                          
                            $scope.bulkinvoice.CurrencyCode = $scope.mloList[index].CurrencyCode;
                            $scope.bulkinvoice.currencyName = $scope.mloList[index].CurrencyCode;
                            if($scope.sailingDate !='' && $scope.sailingDate != undefined){
                                $http.get($stateParams.tenantid+'/app/commonUtility/getExchangeRateWithCurrencyBySailingDate?currencyCode='+ $scope.bulkinvoice.CurrencyCode+'&sailingDate='+$scope.sailingDate).success(function(data) {
                                    //$scope.bulkinvoice.ExchangeRate=data;    
                                    debugger;
                                    $scope.bulkinvoice.exchangeRate=data.exchangeRate;
                                    $scope.bulkinvoice.fromCurrency=data.fromCurrency;
                                    $scope.bulkinvoice.toCurrency=data.toCurrency;     
                                }).error(function(data) {
                                });
                            }else{
                                $http.get($stateParams.tenantid+'/app/commonUtility/getExchangeRateWithCurrencyByMaxDate?currencyCode='+ $scope.bulkinvoice.CurrencyCode).success(function(data) {
                                    //$scope.bulkinvoice.ExchangeRate=data;    
                                    debugger;
                                    $scope.bulkinvoice.exchangeRate=data.exchangeRate;
                                    $scope.bulkinvoice.fromCurrency=data.fromCurrency;
                                    $scope.bulkinvoice.toCurrency=data.toCurrency;     
                                }).error(function(data) {
                                });
                            }
                            
                        }
                    }
                   
                    break;
                    
                case 'VesselName':
                 //   $scope.dataList = ListService.getVoyageList($scope.bulkinvoice.VesselName);
                    $scope.dataList.then(function(voyageLists) {
        
                        $scope.voyagehdrList = voyageLists;
        
                    });
                    break;
                 
                case 'CompanyCode':
                    debugger;
                    $http.get($stateParams.tenantid+'/app/generalinvoice/getCompanyCurrency?CompanyCode='+$scope.bulkinvoice.CompanyCode).success(function(datas) {
                        $scope.companyCurrency=datas.CurrencyCode;
                        }).error(function(datas) {
                    });
                    if($scope.bulkinvoice.CompanyCode=="C0001"){
                        $scope.isFeederCompanyCurrency=true;
                    }else{
                        $scope.isFeederCompanyCurrency=false;
                    }
                    
                    break;
                    
                case 'Voyage':
                    
                    $scope.sailingDate='';
                  //  $scope.dataList = ListService.getCustomerListByVoyage($scope.bulkinvoice.Voyage);
                    $scope.dataList.then(function(customerLists) {
                        if(customerLists.length>0)
                            $scope.customerhdrList = customerLists;
                    });
                    
                   // $scope.dataList = ListService.getPortList($scope.bulkinvoice.Voyage);
                    $scope.dataList.then(function(PortLists) {
                        $scope.PorthdrList = PortLists;
                    });
        
                    var index = $scope.getIndex($scope.voyagehdrList, $scope.bulkinvoice.Voyage);
                    $scope.bulkinvoice.ServiceName = $scope.voyagehdrList[index].ServiceName;
                    break;
                    
                    
                case 'Pol':
                    debugger;
                    
                //    $scope.dataList = ListService.getMloList($scope.bulkinvoice.CustomerName,$scope.bulkinvoice.Pol);
                    $scope.dataList.then(function(mloLists) {
                        $scope.mloList = mloLists;
                        debugger;
                        console.log($scope.mloList);
                    });
                    break;
                 
                case 'CustomerName':
                   // $scope.dataList = ListService.getMloList($scope.bulkinvoice.CustomerName,$scope.bulkinvoice.Pol);
                    $scope.dataList.then(function(mloLists) {
                        $scope.mloList = mloLists;
                        debugger;
                        console.log($scope.mloList);
                    });
                    
                   // $scope.dataList = ListService.getBlList($scope.bulkinvoice.Voyage,$scope.bulkinvoice.Pol,$scope.bulkinvoice.CustomerName);
                    $scope.dataList.then(function(blLists) {
                        $scope.blList = blLists;
                    });
                    
                    if($scope.bulkinvoice.Voyage !='' && $scope.bulkinvoice.Pol !='' && $scope.bulkinvoice.CustomerName !=''){
                        $http.get($stateParams.tenantid+'/app/customerinvoice/getSailingDate?voyageCode=' + $scope.bulkinvoice.Voyage+'&pol=' +$scope.bulkinvoice.Pol+'&customer='+$scope.bulkinvoice.CustomerName).success(function(datas) {
                            $scope.sailingDate = datas.sailingDate;
                            }).error(function(datas) {
                        });
                    }
                    
                break;
                
                case 'bl':
                    $http.get($stateParams.tenantid+'/app/customerinvoice/fetchDetailList?bl='+$scope.bulkinvoice.bl).success(function(datas) {
                        console.log(datas.GIDtl);
                        $scope.bulkinvoice.GIDtl = datas.GIDtl;
                        }).error(function(datas) {
                    });
                    
                break;
                /*case 'ExchangeRate':   
                    $scope.exchagerateGIhdr($scope.bulkinvoice.ExchangeRate);    
                    break;*/        
                case 'currencyName':   
                    $scope.getcurrencyValues($scope.bulkinvoice.currencyName);    
                    
                break;
            }
        }

        $scope.getIndex = function(list, name) {
            var foundItem = $filter('filter')(list, {
                id : name
            }, true)[0];
            var index = list.indexOf(foundItem);
            return index;
        }

        $scope.generalInvoiceDtlList = function() {
            var giRow = {
                    select : '',
                    subAccountCode: '',
                    subGroupCode: '',
                    accountHead : '',
                    narration : '',
                    bcAmount : '',
                    tcAmount : '',
                    voyageCode : '',
                    vesselCode : '',
                    sectorCode : '',
                    employeeCode :'',
                    portCode :'',
                    portSequence :'',
                    departmentCode :'',
                    agentCode :'',
                    countryCode :'',
                    customerCode:'',
                    supplierCode:'',
                    designationCode:'',
                    costCenter :'',
                    companyCode:'',
                    quantityGO:'',
                    quantityFO:'',
                    isVoyage :false,
                    isVessel :false,
                    isService:false,
                    isEmployee:false,
                    isPort:false,
                    isDepartment:false,
                    isAgent:false,
                    isLocation:false,
                    isCustomer:false,
                    isSupplier:false,
                    isDesignation:false,
                    isCostCenter:false,
                    isCompany:false,
                    isQuantityGO:false,
                    isQuantityFO:false,
                    isPortSequence:false,
                    isSubAccountCode :false,
                    attributeList :[],
                    vatpercent :'',
                    vatamount :''
            };
            $scope.bulkinvoice.GIDtl.push(giRow);
        }
        
        $scope.generalInvoiceDtlList();
        
        $scope.addRow = function(gitable) {
            var table = {
                    select : '',
                    subAccountCode: '',
                    subGroupCode: '',
                    accountHead : '',
                    narration : '',
                    bcAmount : '',
                    tcAmount : '',
                    voyageCode : '',
                    vesselCode : '',
                    sectorCode : '',
                    employeeCode :'',
                    portCode :'',
                    portSequence :'',
                    departmentCode :'',
                    agentCode :'',
                    countryCode :'',
                    customerCode:'',
                    supplierCode:'',
                    designationCode:'',
                    costCenter :'',
                    companyCode:'',
                    quantityGO:'',
                    quantityFO:'',
                    isVoyage :false,
                    isVessel :false,
                    isService:false,
                    isEmployee:false,
                    isPort:false,
                    isDepartment:false,
                    isAgent:false,
                    isLocation:false,
                    isCustomer:false,
                    isSupplier:false,
                    isDesignation:false,
                    isCostCenter:false,
                    isCompany:false,
                    isQuantityGO:false,
                    isQuantityFO:false,
                    isPortSequence:false,
                    isSubAccountCode:false,
                    attributeList :[],
                    vatpercent :'',
                    vatamount :''
            };
            
            gitable.push(table);
        };
        // removeRow
        $scope.removeRow = function(GItable) {
            debugger;
            $scope.tablerow = [];
            angular.forEach(GItable, function(row, index) {
                var check = row.select;
                if (check == undefined || check == "") {
                    $scope.tablerow.push(row);
                } else {

                }
            });
            $scope.bulkinvoice.GIDtl = $scope.tablerow;
        };
       
        
       
        
        $scope.getcurrencyValues = function(currencyValue){
            if(currencyValue!=null && currencyValue!=undefined && currencyValue!=""){
                $http.get($stateParams.tenantid+'/app/commonUtility/getExchangeRateWithCurrency?currencyCode='+currencyValue).success(function(data) {
                    debugger;
                    //$scope.bulkinvoice.ExchangeRate=data;                            
                    $scope.bulkinvoice.exchangeRate=data.exchangeRate;
                    $scope.bulkinvoice.fromCurrency=data.fromCurrency;
                    $scope.bulkinvoice.toCurrency=data.toCurrency;     
                }).error(function(data) {
                });
            }else{
                $scope.bulkinvoice.exchangeRate='';
                $scope.bulkinvoice.fromCurrency='';
                $scope.bulkinvoice.toCurrency='';
            }
        }  
        
        $scope.exchagerateGIhdr = function(exchangeRate){
            debugger; 
            if(exchangeRate>0){
                if(parseFloat(exchangeRate) < $scope.bulkinvoice.fromCurrency || parseFloat(exchangeRate) > $scope.bulkinvoice.toCurrency){
                    logger.logError("Please Enter Exchange Rate Between "+$scope.bulkinvoice.fromCurrency+" and "+
                            $scope.bulkinvoice.toCurrency);       
                    $scope.bulkinvoice.exchangeRate=0;
                }else{
                    var bcAmount=0.0, tcAmount=0.0;
                    angular.forEach($scope.bulkinvoice.GIDtl, function(giRow,giIndex){
                        debugger;
                        if(isNaN(parseFloat(giRow.tcAmount, 10))){
                            if(isNaN(parseFloat(giRow.bcAmount, 10))){
                              //  var bcAmt = (parseFloat(giRow.tcAmount) / exchangeRate);
                              //  var tcAmt = (parseFloat(giRow.bcAmount) * exchangeRate);
                                var bcAmt = Math.floor(((isNaN(parseFloat(giRow.tcAmount, 10))?0:giRow.tcAmount) / parseFloat(exchangeRate))*100)/100;
                                var tcAmt = Math.floor(((isNaN(parseFloat(giRow.bcAmount, 10))?0:giRow.bcAmount) * parseFloat(exchangeRate))*100)/100;
                                giRow.tcAmount = isNaN(tcAmt)?0:tcAmt.toFixed(2); 
                                giRow.bcAmount = isNaN(bcAmt)?0:bcAmt.toFixed(2); 
                            }else{
                               // var tcAmt = (parseFloat(giRow.bcAmount) * exchangeRate);
                                var tcAmt = Math.floor(((isNaN(parseFloat(giRow.bcAmount, 10))?0:giRow.bcAmount) * parseFloat(exchangeRate))*100)/100;
                                giRow.tcAmount = isNaN(tcAmt)?0:tcAmt.toFixed(2);  
                            }
                        }else {
                            //var bcAmt = (parseFloat(giRow.tcAmount) / exchangeRate);
                            //giRow.bcAmount = isNaN(bcAmt)?0:bcAmt.toFixed(2); 
                            var bcAmt = Math.floor(((isNaN(parseFloat( giRow.tcAmount, 10))?0: giRow.tcAmount) / parseFloat(exchangeRate))*100)/100;                    
                            giRow.bcAmount = parseFloat(bcAmt).toFixed(2);
                        } 
                    });        
                }
                  
                
            }
            $scope.calculateTotalAmount($scope.bulkinvoice.GIDtl);
         }
        
        $scope.calculateTCtoBCAmount = function(vatper,tcAmount, trIndex, row) {
            debugger;
            if (tcAmount != null && vatper != null) {
                if ($scope.bulkinvoice.exchangeRate != 0 && $scope.bulkinvoice.exchangeRate != ""){
                 // var bcAmount = (parseFloat(tcAmount) / $scope.bulkinvoice.exchangeRate).toFixed(2);
                  var bcAmount = Math.floor(((isNaN(parseFloat( tcAmount, 10))?0: tcAmount) / parseFloat($scope.bulkinvoice.exchangeRate))*100)/100;
                   row.bcAmount= isNaN(bcAmount)?0:bcAmount;
                   var vatamt = (vatper*tcAmount)/100;
                   row.vatamount = vatamt;
                }
                else{
                    tcAmount = Math.floor(((isNaN(parseFloat( tcAmount, 10))?0: tcAmount))*100)/100;
                    row.bcAmount = (parseFloat(tcAmount)).toFixed(2);
                    var vatamt = (vatper*tcAmount)/100;
                    row.vatamount = vatamt;
                }                
            } else {
                row.bcAmount = 0.0;
                row.tcAmount = 0.0;
            }
            $scope.calculateTotalAmount($scope.bulkinvoice.GIDtl);
        };

        $scope.calculateBCtoTCAmount = function(vatper,bcAmount, trIndex, row) {
            debugger;
            if (bcAmount != null && vatper != null) {
                if ($scope.bulkinvoice.exchangeRate != 0 && $scope.bulkinvoice.exchangeRate != ""){
                    //var tcAmt = (parseFloat(bcAmount) * $scope.bulkinvoice.exchangeRate).toFixed(2);
                    var tcAmt = Math.floor(((isNaN(parseFloat( bcAmount, 10))?0: bcAmount) * parseFloat($scope.bulkinvoice.exchangeRate))*100)/100;
                    row.tcAmount =isNaN(tcAmt)?0:tcAmt;
                    var vatamt = (vatper*row.tcAmount)/100;
                    row.vatamount = vatamt;
                }                
                else{
                    bcAmount = Math.floor(((isNaN(parseFloat( bcAmount, 10))?0: bcAmount))*100)/100;
                    var tcAmt = (parseFloat(bcAmount)).toFixed(2);
                    row.tcAmount = isNaN(tcAmt)?0:tcAmt;
                    var vatamt = (vatper*row.tcAmount)/100;
                    row.vatamount = vatamt;
                }
                    
            } else {
                row.bcAmount = 0.0;
                row.tcAmount = 0.0;
            }
            $scope.calculateTotalAmount($scope.bulkinvoice.GIDtl);
        };
        
        $scope.calculateTotalAmount = function(tables) {
            debugger;
            var TotalBCamount = 0.0, TotalTCamount = 0.0, vatTCamt = 0.0, vatBCamt = 0.0;
            angular.forEach(tables, function(row, index) {
                TotalBCamount = (parseFloat(TotalBCamount) + parseFloat(row.bcAmount)).toFixed(2);
                TotalTCamount = (parseFloat(TotalTCamount) + parseFloat(row.tcAmount)).toFixed(2);
                vatTCamt = (parseFloat(vatTCamt) + parseFloat(row.vatamount)).toFixed(2);
                vatBCamt = (parseFloat(vatBCamt) + parseFloat(row.vatamount)).toFixed(2);
            });
            $scope.bulkinvoice.TotalBCamount = TotalBCamount;
            $scope.bulkinvoice.TotalTCamount = TotalTCamount;
            $scope.bulkinvoice.vatTCAmount = vatTCamt;
            $scope.bulkinvoice.vatBCAmount = vatBCamt/$scope.bulkinvoice.exchangeRate;
            $scope.bulkinvoice.grandTCamount = (parseFloat($scope.bulkinvoice.TotalTCamount) + parseFloat($scope.bulkinvoice.vatTCAmount));
            $scope.bulkinvoice.grandBCamount = (parseFloat($scope.bulkinvoice.TotalBCamount) + parseFloat($scope.bulkinvoice.vatBCAmount));
        };
        
        $scope.validationCheck = false;
    	$scope.validationCheck = true;
       
        
        $scope.getEdit = function(sInvoiceNo) {
            var url = $stateParams.tenantid+'/app/customerinvoice/edit?customerinvoiceNo=' + sInvoiceNo;
            $http.get(url).success(function(result) {
                debugger;
                $scope.bulkinvoice.InvoiceDate = result.InvoiceDate;
                $scope.bulkinvoice.bLlist= result.bLlist;
                $scope.bulkinvoice.customerList= result.customerList;
                $scope.mloList= result.mloList;
                $scope.bulkinvoice.voyagehdrList= result.voyageList;
                $scope.bulkinvoice.porthdrList= result.portList;
                $scope.bulkinvoice.VesselhdrList= result.vesselList;

                $scope.bulkinvoice.BlRelated = result.BlRelated;
                $scope.bulkinvoice.Company = result.Company;
                $scope.bulkinvoice.CompanyCode = result.CompanyCode;
                $scope.bulkinvoice.CurrencyCode = result.CurrencyCode;
                $scope.bulkinvoice.currencyName = result.currencyName;
                $scope.bulkinvoice.CustomerCode = result.CustomerCode;
                $scope.bulkinvoice.CustomerName = result.CustomerName;
                $scope.bulkinvoice.exchangeRate = result.exchangeRate;
               
              
                var date= result.InvoiceDate;
                var d=new Date(date.split("-").reverse().join("/"));
                var dd=d.getDate();
                var mm=d.getMonth()+1;
                var yy=d.getFullYear();
                var invoiceFormattedDate=dd+"/"+mm+"/"+yy;
                
                $scope.bulkinvoice.InvoiceDate = invoiceFormattedDate;
                $scope.bulkinvoice.InvoiceNo = result.InvoiceNo;
              
                $scope.bulkinvoice.MloName = result.MloName;
                $scope.bulkinvoice.Pod = result.Pod;
                $scope.bulkinvoice.Pol = result.Pol;
                $scope.bulkinvoice.Port = result.Port;
                $scope.bulkinvoice.PortSequence = result.PortSequence;
                $scope.bulkinvoice.ServiceCode = result.ServiceCode;
                $scope.bulkinvoice.ServiceName = result.ServiceName;
                $scope.bulkinvoice.Subject = result.Subject;
                
                $scope.bulkinvoice.Unit20 = result.Unit20;
                $scope.bulkinvoice.Unit40 = result.Unit40;
             
                $scope.bulkinvoice.VesselName = result.VesselName;
                $scope.bulkinvoice.Voyage = result.Voyage;
                
                $scope.bulkinvoice.GIDtl = result.GIDtl;
                
                $scope.calculateTotalAmount($scope.bulkinvoice.GIDtl);

            }).error(function(result) {
                logger.logError("Error Please Try Again");
            });

        }

        var InvoiceNo=$stateParams.InvoiceNo;
        if(InvoiceNo == undefined || InvoiceNo == null || InvoiceNo ==""){
            $scope.bulkinvoice.isEdit=false;
        }else{
            $scope.bulkinvoice.isEdit =true;
            $scope.getEdit(InvoiceNo);
        }
        
        $scope.isOwner = false;
        $scope.checkOwner = function(){
            $http.get($stateParams.tenantid+'/app/cashbankreceipt/checkOwnerUser').success(function(data) {
                    console.log("owner")
                    console.log(data)
                    $scope.isOwner = data;
            });
        }
        $scope.checkOwner();
        
        /**
         * print
         */
        $scope.printCustInvoiceDiv = function(invoiceNo){
            
            console.log("Both print invoice")
            var url = $stateParams.tenantid+'/app/customerinvoice/print?invoiceNo=' + invoiceNo;
            var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
            if (wnd.print) { var done = false; if (wnd.document && wnd.document.readyState) { var rs = wnd.document.readyState; if ((rs === 'complete') || (rs === 'loaded')) { done = true; wnd.print(); } } if (!done) { if (wnd.addEventListener) { wnd.addEventListener('load', function() { this.print(); }); } else { wnd.onload = function() { this.print(); }; } } }
         }
        
        $scope.printCustInvoiceLocal = function(invoiceNo){
            
            console.log("Local print invoice")
            var url = $stateParams.tenantid+'/app/customerinvoice/printLocal?invoiceNo=' + invoiceNo;
            var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
            if (wnd.print) { var done = false; if (wnd.document && wnd.document.readyState) { var rs = wnd.document.readyState; if ((rs === 'complete') || (rs === 'loaded')) { done = true; wnd.print(); } } if (!done) { if (wnd.addEventListener) { wnd.addEventListener('load', function() { this.print(); }); } else { wnd.onload = function() { this.print(); }; } } }
        //    wnd.print();   
         }
     
    	 $scope.printCustInvoiceUSD = function(invoiceNo){
    	     
    	     console.log("USD print invoice")
    	     var url = $stateParams.tenantid+'/app/customerinvoice/printUSD?invoiceNo=' + invoiceNo;
    	     var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
    	     if (wnd.print) { var done = false; if (wnd.document && wnd.document.readyState) { var rs = wnd.document.readyState; if ((rs === 'complete') || (rs === 'loaded')) { done = true; wnd.print(); } } if (!done) { if (wnd.addEventListener) { wnd.addEventListener('load', function() { this.print(); }); } else { wnd.onload = function() { this.print(); }; } } }
    	 //    wnd.print();   
    	  }
        
    	 $http.get($stateParams.tenantid+'/app/generalinvoice/getAccountHeadListNew').success(function(data) {
             $scope.AccountHeadList = data;
             }).error(function(datas) {
         });
         
         
    });


    app.controller('GItableCtrl', function($scope,$http, $filter,logger,$stateParams){
        debugger;
        $scope.$watch('bulkinvoice.GIDtl[trIndex].voyageCode', function(newValue, oldValue) {
            debugger;
            if (newValue != '' && newValue != undefined) {
                    $http.get($stateParams.tenantid+'/app/commonUtility/getVesselService?voyageCode='+newValue).success(function(datas) {
                        $scope.bulkinvoice.GIDtl[$scope.$index].vesselCode=datas.vesselCode;
                        $scope.bulkinvoice.GIDtl[$scope.$index].sectorCode=datas.sectorCode;
                        }).error(function(datas) {
                    });
           
            }
        });
        
        $scope.$watch('bulkinvoice.GIDtl[trIndex].vatpercent', function(newValue, oldValue) {
            console.log(newValue);
            var index_dot, arr = String(newValue).split("");
            if (arr.length == undefined)
                return;
            else if (arr.length === 0)
                return;
            else if (arr.length === 1 && (arr[0] == '' || arr[0] === '.'))
                return;
            else if (arr.length === 2 && newValue === '.')
                return;
            else if ((newValue != undefined && newValue != '' && isNaN(newValue)) || ((index_dot = String(newValue).indexOf('.')) != -1 && String(newValue).length - index_dot > 4)) {           
                $scope.bulkinvoice.GIDtl[$scope.$index].vatpercent=oldValue;

            }
        });
        
       
        
        $scope.$watch('bulkinvoice.GIDtl[trIndex].tcAmount', function(newValue, oldValue) {
            console.log(newValue);
            var index_dot, arr = String(newValue).split("");
            if (arr.length == undefined)
                return;
            else if (arr.length === 0)
                return;
            else if (arr.length === 1 && (arr[0] == '' || arr[0] === '.'))
                return;
            else if (arr.length === 2 && newValue === '.')
                return;
            else if ((newValue != undefined && newValue != '' && isNaN(newValue)) || ((index_dot = String(newValue).indexOf('.')) != -1 && String(newValue).length - index_dot > 4)) {           
                $scope.bulkinvoice.GIDtl[$scope.$index].tcAmount=oldValue;

            }
        });
        
        $scope.$watch('bulkinvoice.GIDtl[trIndex].bcAmount', function(newValue, oldValue) {
            console.log(newValue);
            var index_dot, arr = String(newValue).split("");
            if (arr.length == undefined)
                return;
            else if (arr.length === 0)
                return;
            else if (arr.length === 1 && (arr[0] == '' || arr[0] === '.'))
                return;
            else if (arr.length === 2 && newValue === '.')
                return;
            else if ((newValue != undefined && newValue != '' && isNaN(newValue)) || ((index_dot = String(newValue).indexOf('.')) != -1 && String(newValue).length - index_dot > 4)) {           
                $scope.bulkinvoice.GIDtl[$scope.$index].bcAmount=oldValue;

            }
        });
        
        $scope.$watch('bulkinvoice.GIDtl[trIndex].accountHead', function(newValue, oldValue) {
            if (newValue != '' && newValue != undefined) {
                $scope.bulkinvoice.GIDtl[$scope.$index].voyageCode = $scope.bulkinvoice.Voyage;
                $scope.bulkinvoice.GIDtl[$scope.$index].vesselCode = $scope.bulkinvoice.VesselName;
                $scope.bulkinvoice.GIDtl[$scope.$index].sectorCode = $scope.bulkinvoice.ServiceName;
                if(newValue == '10080001' || newValue=='40090002'){
                    $scope.bulkinvoice.GIDtl[$scope.$index].isSubAccountCode =true;
                    $http.get($stateParams.tenantid+'/app/commonUtility/getSubAccountCodeListTradeDebtors').success(function(datas) {
                        $scope.bulkinvoice.GIDtl[$scope.$index].subAccountCodeList = datas;
                        }).error(function(datas) {
                    });
                }else if(newValue == '20010001'  ){
                    $scope.bulkinvoice.GIDtl[$scope.$index].isSubAccountCode =true;
                    $http.get($stateParams.tenantid+'/app/commonUtility/getSubAccountCodeListTradeCreditors').success(function(datas) {
                        $scope.bulkinvoice.GIDtl[$scope.$index].subAccountCodeList = datas;
                        }).error(function(datas) {
                    });   
                }else if(newValue == '10070001'){
                    
                    $scope.bulkinvoice.GIDtl[$scope.$index].isSubAccountCode =true;
                    $http.get($stateParams.tenantid+'/app/commonUtility/getStaffListForAdvances').success(function(datas) {
                        $scope.bulkinvoice.GIDtl[$scope.$index].subAccountCodeList = datas;
                        }).error(function(datas) {
                    });   
                }else if(newValue == '10090017'){
                    $scope.bulkinvoice.GIDtl[$scope.$index].isSubAccountCode =true;
                    $http.get($stateParams.tenantid+'/app/commonUtility/getonlySupplier').success(function(datas) {
                        $scope.bulkinvoice.GIDtl[$scope.$index].subAccountCodeList = datas;
                        }).error(function(datas) {
                    });   
                }else{
                    $scope.bulkinvoice.GIDtl[$scope.$index].subAccountCodeList=[];
                    $scope.bulkinvoice.GIDtl[$scope.$index].isSubAccountCode =false;
                }
                
                    $http.get($stateParams.tenantid+'/app/commonUtility/getAttributesList?accountCode='+newValue).success(function(datas) {
                    $scope.bulkinvoice.GIDtl[$scope.$index].attributeList=datas;
                    if(newValue==oldValue){
                        $scope.isOnChange =false;
                    }else{
                        $scope.isOnChange =true;
                    }
                    if(!$scope.bulkinvoice.isEdit || $scope.isOnChange){
                         
                    //$scope.bulkinvoice.GIDtl[$scope.$index].voyageCode='';
                    //$scope.bulkinvoice.GIDtl[$scope.$index].vesselCode='';
                    //$scope.bulkinvoice.GIDtl[$scope.$index].sectorCode='';
                    $scope.bulkinvoice.GIDtl[$scope.$index].employeeCode='';
                    $scope.bulkinvoice.GIDtl[$scope.$index].portCode='';
                    $scope.bulkinvoice.GIDtl[$scope.$index].portSequence='';
                    $scope.bulkinvoice.GIDtl[$scope.$index].departmentCode='';
                    $scope.bulkinvoice.GIDtl[$scope.$index].agentCode='';
                    $scope.bulkinvoice.GIDtl[$scope.$index].countryCode='';
                    $scope.bulkinvoice.GIDtl[$scope.$index].customerCode='';
                    $scope.bulkinvoice.GIDtl[$scope.$index].supplierCode='';
                    $scope.bulkinvoice.GIDtl[$scope.$index].designationCode='';
                    $scope.bulkinvoice.GIDtl[$scope.$index].costCenter='';
                    $scope.bulkinvoice.GIDtl[$scope.$index].companyCode='';
                    $scope.bulkinvoice.GIDtl[$scope.$index].quantityGO='';
                    $scope.bulkinvoice.GIDtl[$scope.$index].quantityFO='';
                    }
                    
                    $scope.bulkinvoice.GIDtl[$scope.$index].isVoyage=false;
                    $scope.bulkinvoice.GIDtl[$scope.$index].isVessel=false;
                    $scope.bulkinvoice.GIDtl[$scope.$index].isService=false;
                    $scope.bulkinvoice.GIDtl[$scope.$index].isEmployee=false;
                    $scope.bulkinvoice.GIDtl[$scope.$index].isPort=false;
                    $scope.bulkinvoice.GIDtl[$scope.$index].isDepartment=false;
                    $scope.bulkinvoice.GIDtl[$scope.$index].isAgent=false;
                    $scope.bulkinvoice.GIDtl[$scope.$index].isLocation=false;
                    $scope.bulkinvoice.GIDtl[$scope.$index].isCustomer=false;
                    $scope.bulkinvoice.GIDtl[$scope.$index].isSupplier=false;
                    $scope.bulkinvoice.GIDtl[$scope.$index].isDesignation=false;
                    $scope.bulkinvoice.GIDtl[$scope.$index].isCostCenter=false;
                    $scope.bulkinvoice.GIDtl[$scope.$index].isCompany=false;
                    $scope.bulkinvoice.GIDtl[$scope.$index].isQuantityGO=false;
                    $scope.bulkinvoice.GIDtl[$scope.$index].isQuantityFO=false;
                    $scope.bulkinvoice.GIDtl[$scope.$index].isPortSequence=false;
                 
                    // code added for mandatory
                    $scope.bulkinvoice.GIDtl[$scope.$index].isVoyageMan=false;
                    $scope.bulkinvoice.GIDtl[$scope.$index].isVesselMan=false;
                    $scope.bulkinvoice.GIDtl[$scope.$index].isServiceMan=false;
                    $scope.bulkinvoice.GIDtl[$scope.$index].isEmployeeMan=false;
                    $scope.bulkinvoice.GIDtl[$scope.$index].isPortMan=false;
                    $scope.bulkinvoice.GIDtl[$scope.$index].isDepartmentMan=false;
                    $scope.bulkinvoice.GIDtl[$scope.$index].isAgentMan=false;
                    $scope.bulkinvoice.GIDtl[$scope.$index].isLocationMan=false;
                    $scope.bulkinvoice.GIDtl[$scope.$index].isCustomerMan=false;
                    $scope.bulkinvoice.GIDtl[$scope.$index].isSupplierMan=false;
                    $scope.bulkinvoice.GIDtl[$scope.$index].isDesignationMan=false;
                    $scope.bulkinvoice.GIDtl[$scope.$index].isCostCenterMan=false;
                    $scope.bulkinvoice.GIDtl[$scope.$index].isQuantityGOMan=false;
                    $scope.bulkinvoice.GIDtl[$scope.$index].isQuantityFOMan=false;
                    $scope.bulkinvoice.GIDtl[$scope.$index].isPortSequenceMan=false;
                    
                    angular.forEach($scope.bulkinvoice.GIDtl[$scope.$index].attributeList, function(row, rowindex) {
                        debugger;
                        if(row.attributeName == "Trip"){
                            $scope.bulkinvoice.GIDtl[$scope.$index].isVoyage=true;                       
                           /* if($scope.bulkinvoice.Voyage !='')
                                $scope.bulkinvoice.GIDtl[$scope.$index].voyageCode=$scope.bulkinvoice.Voyage;*/
                            console.log("row.isMandatory" +row.isMandatory)
                            if(row.isMandatory == 'Y'){
                                if($scope.isOwner)
                                    $scope.bulkinvoice.GIDtl[$scope.$index].isVoyageMan=false;
                                else
                                    $scope.bulkinvoice.GIDtl[$scope.$index].isVoyageMan=true;
                            }
                        }else if(row.attributeName == "Truck"){
                            $scope.bulkinvoice.GIDtl[$scope.$index].isVessel=true;
                            
                            /*if($scope.bulkinvoice.VesselName!='')
                                $scope.bulkinvoice.GIDtl[$scope.$index].vesselCode =$scope.bulkinvoice.VesselName;*/
                            
                            if(row.isMandatory == 'Y'){
                                if($scope.isOwner)
                                    $scope.bulkinvoice.GIDtl[$scope.$index].isVesselMan=false;
                                else
                                    $scope.bulkinvoice.GIDtl[$scope.$index].isVesselMan=true;
                            }
                        }else if(row.attributeName == "Service"){
                            $scope.bulkinvoice.GIDtl[$scope.$index].isService=true;
                            if(row.isMandatory == 'Y'){
                                if($scope.isOwner)
                                    $scope.bulkinvoice.GIDtl[$scope.$index].isServiceMan=false;
                                else
                                    $scope.bulkinvoice.GIDtl[$scope.$index].isServiceMan=true;
                            }
                        }else if(row.attributeName == "Employee"){
                            $scope.bulkinvoice.GIDtl[$scope.$index].isEmployee=true;
                           /* if(row.isMandatory == 'Y'){
                                $scope.bulkinvoice.GIDtl[$scope.$index].isEmployeeMan=true;
                            }*/
                        }else if(row.attributeName == "Port"){
                            $scope.bulkinvoice.GIDtl[$scope.$index].isPort=true;
                            /*if(row.isMandatory == 'Y'){
                                $scope.bulkinvoice.GIDtl[$scope.$index].isPortMan=true;
                            }*/
                        }else if(row.attributeName == "Department"){
                            $scope.bulkinvoice.GIDtl[$scope.$index].isDepartment=true;
                            /*if(row.isMandatory == 'Y'){
                                $scope.bulkinvoice.GIDtl[$scope.$index].isDepartmentMan=true;
                            }*/
                        }else if(row.attributeName == "Agent"){
                            $scope.bulkinvoice.GIDtl[$scope.$index].isAgent=true;
                          /*  if(row.isMandatory == 'Y'){
                                $scope.bulkinvoice.GIDtl[$scope.$index].isAgentMan=true;
                            }*/
                        }else if(row.attributeName == "Location"){
                            $scope.bulkinvoice.GIDtl[$scope.$index].isLocation=true;
                           /* if(row.isMandatory == 'Y'){
                                $scope.bulkinvoice.GIDtl[$scope.$index].isLocationMan=true;
                            }*/
                        }else if(row.attributeName == "Customer"){
                            $scope.bulkinvoice.GIDtl[$scope.$index].isCustomer=true;
                           /* if(row.isMandatory == 'Y'){
                                $scope.bulkinvoice.GIDtl[$scope.$index].isCustomerMan=true;
                            }*/
                        }else if(row.attributeName == "Supplier"){
                            $scope.bulkinvoice.GIDtl[$scope.$index].isSupplier=true;
                           /* if(row.isMandatory == 'Y'){
                                $scope.bulkinvoice.GIDtl[$scope.$index].isSupplierMan=true;
                            }*/
                        }else if(row.attributeName == "Designation"){
                            $scope.bulkinvoice.GIDtl[$scope.$index].isDesignation=true;
                         /*   if(row.isMandatory == 'Y'){
                                $scope.bulkinvoice.GIDtl[$scope.$index].isDesignationMan=true;
                            }*/
                        }else if(row.attributeName == "Cost Center"){
                            $scope.bulkinvoice.GIDtl[$scope.$index].isCostCenter=true;
                          /*  if(row.isMandatory == 'Y'){
                                $scope.bulkinvoice.GIDtl[$scope.$index].isCostCenterMan=true;
                            }*/
                        }else if(row.attributeName == "Company"){
                            $scope.bulkinvoice.GIDtl[$scope.$index].isCompany=true;
                           /* if(row.isMandatory == 'Y'){
                                $scope.bulkinvoice.GIDtl[$scope.$index].isCompanyMan=true;
                            }*/
                        }else if(row.attributeName == "Quantity (MT) GO"){
                            $scope.bulkinvoice.GIDtl[$scope.$index].isQuantityGO=true;
                            /*if(row.isMandatory == 'Y'){
                                $scope.bulkinvoice.GIDtl[$scope.$index].isQuantityGOMan=true;
                            }*/
                        }else if(row.attributeName == "Quantity (MT) FO"){
                            $scope.bulkinvoice.GIDtl[$scope.$index].isQuantityFO=true;
                           /* if(row.isMandatory == 'Y'){
                                $scope.bulkinvoice.GIDtl[$scope.$index].isQuantityFOMan=true;
                            }*/
                        }else if(row.attributeName == "Port with Sequence"){
                            $scope.bulkinvoice.GIDtl[$scope.$index].isPortSequence=true;
                            /*if(row.isMandatory == 'Y'){
                                $scope.bulkinvoice.GIDtl[$scope.$index].isPortSequenceMan=true;
                            }*/
                        }
                        });
                    }).error(function(datas) {
                });
            }else{
                $scope.bulkinvoice.GIDtl[$scope.$index].subAccountCodeList=[];
            
            }
        });
    });

    app.controller('bulkinvoiceViewCtrl', function($scope, $window, $rootScope, $location, $filter, $http, logger, 
            $log, ngDialog, $modal, utilsService,  $stateParams,$timeout,validationService,toaster,$state) {
        
        $scope.bulkinvoice = {
                invoiceNo:'', invoiceDate:'', company:'', companyCode:'', blRelated:'', customerName:'', customerCode:'',
                mloCode:'', mloName:'', subject:'', currencyName:'', currencyCode:'', exchangeRate:'',
                voyage:'', vesselCode:'', vesselName:'', serviceCode:'', serviceName:'', unit20:'', unit40:'', pol:'', pod:'',
                sailingDate:'', bl:'', port:'', portSequence:'', accountHeadName:'', accountHeadCode:'', 
                TotalBCamount:'', TotalTCamount:'', giDtl:[],

                customerAddress:'', customerPhoneNo:'', customerFaxNo:'', customerEmail:'', companyAddress:'',
                companyPhoneNo:'', companyFaxNo:'', companyEmail:'', companyCurrency:'',
            }
        
        $scope.generalInvoiceDtlList = function() {
            var giRow = {
                    select : '',
                    subAccountCode: '',  subGroupCode: '', accountHead : '', narration : '', bcAmount : '',
                    tcAmount : '', voyageCode : '', vesselCode : '', sectorCode : '', employeeCode :'',
                    portCode :'', portSequence :'', departmentCode :'', agentCode :'', countryCode :'',
                    customerCode:'', supplierCode:'', designationCode:'', costCenter :'', companyCode:'',
                    quantityGO:'', quantityFO:'', 
                    isVoyage :false, isVessel :false, isService:false, isEmployee:false, isPort:false,
                    isDepartment:false, isAgent:false, isLocation:false, isCustomer:false, isSupplier:false,
                    isDesignation:false, isCostCenter:false, isCompany:false, isQuantityGO:false, isQuantityFO:false,
                    isPortSequence:false, isSubAccountCode :false,
                    attributeList :[]
            };
        }

        $scope.generalInvoiceDtlList();
        $scope.viewDisable =true;
        var invoiceNo=$stateParams.invoiceNo;
        if(invoiceNo == undefined || invoiceNo == null || invoiceNo ==""){
            $scope.viewDisable=false;
        }else{
         
                var url = $stateParams.tenantid+'/app/generalinvoice/getGeneralInvoiceView?invoiceNo=' + invoiceNo;
                $http.get(url).success(function(result) {
                    debugger;
                    console.log(result);
                    $scope.bulkinvoice = result;
                }).error(function(result) {
                    logger.logError("Error Please Try Again");
                });
        }
        
        $scope.generalInvoiceTable = false;
       
       /* var invoiceNo1=$stateParams.invoiceNo;
        if(invoiceNo1 == undefined || invoiceNo1 == null || invoiceNo1 ==""){
            $scope.viewDisable=false;
        }else{
            debugger;
            $scope.generalInvoiceTable = true;
                var url = $stateParams.tenantid+'/app/generalinvoice/getGeneralInvoiceView?invoiceNo=' + invoiceNo1;
                $http.get(url).success(function(result) {
                    debugger;
                    console.log(result);
                    $scope.generalinvoice = result;
                }).error(function(result) {
                    logger.logError("Error Please Try Again");
                });
        }*/
        
        $scope.cancel1 = function() {
        	ngDialog.close();
        };
        
        /**
         * print
         */
        $scope.printGeneralInvoiceDiv = function(invoiceNo){
            
            console.log("print invoice")
            var url = $stateParams.tenantid+'/app/generalinvoice/print?invoiceNo=' + invoiceNo;
            var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
            wnd.print();   
         }

        $scope.cancel = function() {
        	ngDialog.close();
        };
        
        /**
         * print
         */
        $scope.printCustInvoiceDiv = function(invoiceNo){
            
            console.log("print invoice")
            var url = $stateParams.tenantid+'/app/customerinvoice/print?invoiceNo=' + invoiceNo;
            var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
            wnd.print();   
         }
        
        $scope.printCustInvoiceLocal = function(invoiceNo){
            
            console.log("Local print invoice")
            var url = $stateParams.tenantid+'/app/customerinvoice/printLocal?invoiceNo=' + invoiceNo;
            var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
            wnd.print();   
         }

     	 $scope.printCustInvoiceUSD = function(invoiceNo){
     	     
     	     console.log("USD print invoice")
     	     var url = $stateParams.tenantid+'/app/customerinvoice/printUSD?invoiceNo=' + invoiceNo;
     	     var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
     	     wnd.print();   
     	  }
        
        
    });