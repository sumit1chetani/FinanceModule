'use strict';
app.controller('truckScheduleCtrl', function($scope,$timeout, $state, $http, ngDialog, logger,$location, $controller, $injector, sharedProperties, toaster, $rootScope,$stateParams,$filter,validationService) {
	
  
	
	
	 
       
       $scope.defaultDate1 = new Date();
       $scope.evtList =[];
       $scope.truckSelectivity=[];
       $scope.truckListselected=''; 
       
       $http.post($stateParams.tenantid+'/truckSchedule/getTruckSelectivity').success(function(data) {
			if(data.success = true){
				$scope.truckSelectivity = data.selectivitybean;
			}
		});
       
       $http.post($stateParams.tenantid+'/truckSchedule/calendarEvents').success(function(data) {
			if(data.success = true){
				$scope.evtList = data.trkEvtCalender;
				$scope.loadCalValues();
			}
		});
       
       $scope.searchTruck  =function(){
    	   
    	   if($scope.truckListselected != ''){
    		   $http.post($stateParams.tenantid+'/truckSchedule/searchTruck',$scope.truckListselected).success(function(data) {
   				if(data.success = true){
   					$scope.evtList = data.trkEvtCalender;
   					$scope.loadCalValues();
   					
   				}
   			})
    	   }else{
    		   logger.logError("Please Select Truck");
    	   }
			
        }
    
       
       	$scope.truckViewId='';
       	
	    $scope.loadCalValues = function() {
	    $('#calendar').fullCalendar('destroy');
		$('#calendar').fullCalendar({
			schedulerLicenseKey: 'GPL-My-Project-Is-Open-Source',
			header : {
				left : 'prev,next today',
				center : 'title',
				right : 'month,agendaWeek,agendaDay,listWeek'
			},
			defaultDate : $scope.defaultDate1,
			navLinks : true, // can click day/week names to navigate views
			editable : false,
			eventLimit : true, // allow "more" link when too many events
			events : $scope.evtList,
			eventClick : function(calEvent, jsEvent, view) {
				// For click Event display
				/*alert('Event: ' + calEvent.title);
				alert('Coordinates: ' + jsEvent.pageX + ',' + jsEvent.pageY);
				alert('View: ' + view.name);

				// change the border color just for fun
				$(this).css('border-color', 'red');*/
				
				
				 $scope.truckViewId=calEvent.planTripId;
				 $scope.viewTruckEvents($scope, $http, ngDialog, logger,$injector, sharedProperties, toaster,$rootScope);
			},dayClick: function(date, allDay, jsEvent, view) {
				
				 $http.post($stateParams.tenantid+'/truckSchedule/updateValue').success(function(data) {
						if(data.success = true){
						}
					});
				
			    $scope.clickDate=date._d;
		      /*$scope.trip.tripStartDate = $filter('date')($scope.clickDate, "dd-MM-yyyy HH:mm");
		      
			  $scope.trip.etd = $filter('date')($scope.clickDate, "dd-MM-yyyy HH:mm");
		      $scope.trip.eta = $filter('date')($scope.clickDate, "dd-MM-yyyy HH:mm");*/
		      $scope.trip.tripStartDate = $filter('date')($scope.clickDate, "dd/MM/yyyy");
		      
			  $scope.trip.etd = $filter('date')($scope.clickDate, "dd/MM/yyyy");
		      $scope.trip.eta = $filter('date')($scope.clickDate, "dd/MM/yyyy");
			  
			  $scope.trip.truckId='';
			  $scope.trip.trailerId='';
			  $scope.trip.fromLocation='';
			  $scope.trip.driverId='';
			  $scope.trip.toLocation='';
			  
			  if($("#calendar") .hasClass("modCalClass")){
				  $("#calendar").removeClass("modCalClass");
			  }else{
				  $("#calendar").addClass("modCalClass");
			  }
			  
			  if($(".accTruckEvt") .hasClass("modTrkEvt")){
				  $(".accTruckEvt").removeClass("modTrkEvt");
			  }else{
				  $(".accTruckEvt").addClass("modTrkEvt");
			  }
			  
			  
			 
			  
			  $('#calendar').fullCalendar('gotoDate', $scope.clickDate);
			  $('.fc-agendaWeek-button').click();
			  
			  $('#calendar').block({ message: null });  
			 
			   
			  
			 /* $scope.addEvtVis =true;
			  alert($scope.addEvtVis);*/
			  
			    //$(".accTruckEvt > wrapper-md").addClass("intro");
			    /*$( "truckAddClass" ).css( "background-color", "red !important" );*/
			    //$(".accTruckEvt > wrapper-md").css("background-color","red !important" );
			    //$( ".accTruckEvt" ).find( "wrapper-md" ).addClass("intro");
			    
			    /*$scope.createTruckEvent($scope, $http, ngDialog, logger,$injector, sharedProperties, toaster,$rootScope);*/
			    //$scope.viewTruckEvents($scope, $http, ngDialog, logger,$injector, sharedProperties, toaster,$rootScope);
			   /* ngDialog.open({
		            template : 'views/trip/tripadd',
		            scope : $scope,
		            controller : $controller('tripAddCtrl', {
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
		})*/
			}
			
		});
	}
	    
	    
	    
	    $scope.createTruckEvent = function($scope, $http, ngDialog, logger,$injector, sharedProperties, toaster,$rootScope){
	    	$scope.myModalInstance = ngDialog.open({
	            template : 'views/trip/tripadd',
	            scope : $scope,
	            controller : $controller('truckSchEvntAdd', {
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
	    
	    

		$scope.viewTruckEvents = function($scope, $http, ngDialog, logger,$injector, sharedProperties, toaster,$rootScope){
			ngDialog.open({
	            template : 'truckScheduleAlert',
	            scope : $scope,
	            controller : $controller('truckScheduleAltCtrl', {
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
		 $scope.truckViewList =[];
		 $scope.truckView={
				 id :'',
				 truck : '',
				 start :'',
				 end :'',
				 fromLoc :'',
				 toLoc : ''
		 }
		 
		 $scope.updateCalendar = function(){
			 
			 $http.post($stateParams.tenantid+'/truckSchedule/searchTruck',$scope.truckListselected).success(function(data) {
					if(data.success = true){
						$scope.evtList = data.trkEvtCalender;
						$scope.loadCalValues();
						var d = $filter('date')($scope.trip.etd, "yyyy-mm-dd")
						var a = $scope.trip.etd;
					    var x = a.split('/')
					    var d=x[1]+'/'+x[0]+'/'+x[2]
						$('#calendar').fullCalendar('gotoDate', d);
						/*$('#calendar').fullCalendar('updateEvent', event);
						$('#calendar').fullCalendar('gotoDate', currentDate);*/
					}
				});
		 }
		 
		
		 
		 app.controller('truckScheduleAltCtrl', function($scope, $timeout, $stateParams,
					$filter, $rootScope, $http, $location, logger, $state, ngDialog) {
				if($scope.truckViewId != '' && $scope.truckViewId != undefined){
				$http.post($stateParams.tenantid+'/truckSchedule/viewSelectedTruck',$scope.truckViewId).success(function(data) {
					if(data.success = true){
						$scope.truckViewList = data.trkEvtCalender;
						 $scope.truckView.id= $scope.truckViewList[0].id;
						 $scope.truckView.truck= $scope.truckViewList[0].tripNo;
						 $scope.truckView.fromLoc= $scope.truckViewList[0].fromLocation;
						 $scope.truckView.toLoc= $scope.truckViewList[0].toLocation;
						 $scope.truckView.start= $scope.truckViewList[0].start;
						 $scope.truckView.end= $scope.truckViewList[0].end;
						 
					}
				})
				}
			});
		 
		 
		 
		 /*
		 
		 $scope.organisation = {};
			$scope.rowCollection = [];
			$scope.displayedCollection = [];
			
			
			$scope.test=true;
			
			$scope.ch = function(){
				 $scope.showAddPanel();
			} 
			 $scope.showAddPanel = function () {
		         //If DIV is visible it will be hidden and vice versa.
		         $scope.test = $scope.test ? false : true;
		     }

			$scope.trip={
					truckId: '',
					tripNo : '',
					trailerId: '',
					fromLocation : '',
					toLocation : '',
					eta : '',
					etd : '',
					truckRegNo : '',
					trailerNo : '',
					truckTrailerMappingId : '',
		            tripStartDate	: '',
		            driverId : '',
		            driverMappingId : ''


					
			}
			
			$scope.trip1={		
					tripNo : '',			
					fromLocation : '',
					toLocation : '',
					eta : '',
					etd : '',
					truckRegNo : '',
					trailerNo : '',
					driversName :''


					
			}
			
			$scope.$watchCollection('[ trip.fromLocation,trip.toLocation]', function(newValue, oldValue) {
				if($scope.trip.fromLocation != "" && $scope.trip.fromLocation != undefined &&
						$scope.trip.toLocation != "" && $scope.trip.toLocation != undefined){
//			        $http.get($stateParams.tenantid+'/app/plantrip/timeCalculateInMins?fromLocation='+$scope.trip.fromLocation+'&toLocation='+$scope.trip.toLocation+'&truckId='+$scope.trip.truckId).success(function(datas) {
//			             $scope.timeDiff =datas.timeCalculation;
//			          
//			        });
					
				}
				
			});
			
			 //Truck Details
		    $scope.trip1=[];
		    $scope.$watch('trip.truckId', function(newValue, oldValue) {
		        
		        if (newValue != '' && newValue != undefined) {      
		        	
		            $http.get($stateParams.tenantid+'/app/plantrip/truckid?truck_id='+newValue).success(function(datas) {
		            	console.log(datas);
		            	
		            		$scope.trip1 = datas;
		            	
		            	
		            	

		            }).error(function(data) {
		            	logger.logError("Unable to fetch");
		            });    

		        }
		    });
			
			$scope.save= function(trip,TripForm){
				if (new validationService().checkFormValidity($scope.TripForm)) {
				$http.post($stateParams.tenantid+'/app/plantrip/add',
						$scope.trip).success(function(datas) {
							if(datas){
								$('#calendar').unblock(); 
				                logger.logSuccess("Saved Successfully!");
				                $http.post($stateParams.tenantid+'/truckSchedule/calendarEvents').success(function(data) {
				        			if(data.success = true){
				        				$scope.evtList = data.trkEvtCalender;
				        				$scope.loadCalValues();
										var d = $filter('date')($scope.trip.etd, "yyyy-mm-dd")
										var a = $scope.trip.etd;
									    var x = a.split('/')
									    var d=x[1]+'/'+x[0]+'/'+x[2]
										$('#calendar').fullCalendar('gotoDate', d);
						                
						                if($("#calendar") .hasClass("modCalClass")){
						  				  $("#calendar").removeClass("modCalClass");
						  			  }
						  			  
						  			  if($(".accTruckEvt") .hasClass("modTrkEvt")){
						  				  $(".accTruckEvt").removeClass("modTrkEvt");
						  			  }
				        			}
				        		});
							}
							else{
								  logger.logError("Error in save!");
							}
					
				})
				
				}
			    else{
		            toaster.pop('error', "Please fill the required fields", 
		                    logger.getErrorHtmlNew($scope.TripForm.$validationSummary), 555000, 'trustedHtml');
		                       }
				
			}
			

		    $scope.getDropdownvalue = function() { 
		        $http.get($stateParams.tenantid+'/app/distance/getPort').success(function(datas) {
		             $scope.portList =datas.portList;
		          
		        });
		        
		        $http.get($stateParams.tenantid+'/truckdrivermapping/trucklist').success(function(datas) {
		        	console.log(datas);
		            $scope.truckList =datas.truckList;
		            console.log(datas.truckList);
		         
		       });
		        
		        
		    }
			   $scope.trailerList = [];
			   $scope.driverList=[];
			   
			   
			   
			   $scope.$watchCollection('[trip.truckId,trip.tripStartDate]', function(newValue, oldValue) {
				   debugger
			        if (newValue != '' && newValue != undefined) {
			           if($scope.trip.tripStartDate != '' && $scope.trip.tripStartDate != undefined
			        && $scope.trip.truckId != '' && $scope.trip.truckId != undefined){

			                $http.get($stateParams.tenantid+'/app/plantrip/getTrailerByTruck?truckCode='+$scope.trip.truckId+'&tripStartDate='+$scope.trip.tripStartDate).success(function(datas) {
			                    $scope.trailerList = datas.list;
			                    $scope.trip.truckTrailerMappingId=datas.mappingId;
			                    if(datas.trailerId != null){
				                    $scope.trip.trailerId=datas.trailerId.toString();
				                    }
				                    else{
				                    	 $scope.trip.trailerId='';
				                    }
			                   
			                    
			                    console.log(datas);
			                    }).error(function(datas) {
			                });   
			                

			                $http.get($stateParams.tenantid+'/app/plantrip/getDriverByTruck?truckId='+$scope.trip.truckId+'&tripStartDate='+$scope.trip.tripStartDate).success(function(datas) {
			                    $scope.driverList = datas.list;
			                    $scope.trip.driverId=datas.list[0].id;
			                    console.log(datas);
			                    }).error(function(datas) {
			                }); 
			                
			        }
			          
			        }
			    });
			    
			   
			   
			   $scope.$watchCollection('[trip.truckId,trip.driverId]', function(newValue, oldValue) {
				   debugger
			        if (newValue != '' && newValue != undefined) {
			           if($scope.trip.driverId != '' && $scope.trip.driverId != undefined
			        && $scope.trip.truckId != '' && $scope.trip.truckId != undefined){

			                $http.get($stateParams.tenantid+'/app/plantrip/getMappingIdbyTruckDriver?truckId='+parseInt($scope.trip.truckId)+'&driverId='+$scope.trip.driverId).success(function(datas) {
			                    $scope.trip.driverMappingId=datas.driverMappingId;
			                   
			                    
			                    console.log(datas);
			                    }).error(function(datas) {
			                });   
			        }
			          
			        }
			    });
			    
			   
			    
		    
		    
		    
		    $scope.$watch('trip.trailerId', function(newValue, oldValue) {
		        if (newValue != '' && newValue != undefined) {
		           if($scope.trip.truckId != '' && $scope.trip.truckId != undefined &&
		        	 $scope.trip.truckTrailerMappingId != '' && $scope.trip.truckTrailerMappingId != undefined){

		                $http.get($stateParams.tenantid+'/app/plantrip/autoGenTripNo?truckId='+$scope.trip.truckId+'&mappingId='+$scope.trip.truckTrailerMappingId).success(function(datas) {
		                    $scope.trip.tripNo = datas.autoGenTripNo;
		                    
		                    
		                    console.log(datas);
		                    }).error(function(datas) {
		                });               
		        }
		           else
		        	   {
		        	   logger.logError("Please Select Start Trip Date!");
		        	   }
		        }
		        else{
		       	 $scope.trip.tripNo = '';
		       }
		    });
		    */
		    
		    
		    
		    
		    $scope.cancel=function(){
		    	
		    	$('#calendar').unblock(); 
		    	  $scope.trip.etd = '';
			      $scope.trip.eta = '';
				  $scope.trip.tripStartDate = '';
				  $scope.trip.driverId='';
				  $scope.trip.workOrderNo='';
				  $http.post($stateParams.tenantid+'/truckSchedule/updateValue').success(function(data) {
						if(data.success = true){
						}
					});
		    	 $('.fc-month-button').click();
		    	 if($("#calendar") .hasClass("modCalClass")){
	  				  $("#calendar").removeClass("modCalClass");
	  			  }
	  			  
	  			  if($(".accTruckEvt") .hasClass("modTrkEvt")){
	  				  $(".accTruckEvt").removeClass("modTrkEvt");
	  			  }
	  			
	  			
		    }
		    
		    $scope.reset=function(){
		    	$scope.trip.truckId= '';
		    	$scope.trip.tripNo = '';
		    	$scope.trip.trailerId= '';
		    	$scope.trip.fromLocation = '';
		    	$scope.trip.toLocation = '';
		    	$scope.trip.eta = '';
		    	$scope.trip.etd = '';
		    	$scope.trip.truckRegNo = '';
		    	$scope.trip.trailerNo = '';
		    	$scope.trip.truckTrailerMappingId = '';
		    	$scope.trip.tripStartDate	= '';
		    	$scope.trip.driverId = '';
		    	$scope.trip.driverMappingId = '';
		    }
		  
		   
			/*
			 $('#fromDate').datetimepicker({
			        format : 'DD/MM/YYYY HH:MM'
			    })
			    
			     $('#toDate').datetimepicker({
			        format : 'DD/MM/YYYY  HH:MM'
			    })
			    
			    	     $('#tripStartDate').datetimepicker({
			        format : 'DD/MM/YYYY HH:MM'
			    })*/
			    

				/*$scope.organisation = {};
				$scope.rowCollection = [];
				$scope.displayedCollection = [];
				$scope.tripReallocate=false;
				
				var lolId = $stateParams.lolId;
				var lodId = $stateParams.lodId;
				

				$scope.trip={
						truckId: '',
						tripNo : '',
						trailerId: '',
						fromLocation : '',
						toLocation : '',
						eta : '',
						etd : '',
						truckRegNo : '',
						trailerNo : '',
						truckTrailerMappingId : '',
			            tripStartDate	: '',
			            driverId : '',
			            driverMappingId : '',
			            refId : ''
			            


						
				}
				
				$scope.trip1={		
						tripNo : '',			
						fromLocation : '',
						toLocation : '',
						eta : '',
						etd : '',
						truckRegNo : '',
						trailerNo : '',
						driversName :''


						
				}
				
				if(lolId != '' && lolId != null && lodId != '' && lodId != null){
					$scope.trip.fromLocation=lolId;
					$scope.trip.toLocation=lodId;
					$scope.tripReallocate=true;
				}
				
				$scope.$watchCollection('[ trip.fromLocation,trip.toLocation]', function(newValue, oldValue) {
					if($scope.trip.fromLocation != "" && $scope.trip.fromLocation != undefined &&
							$scope.trip.toLocation != "" && $scope.trip.toLocation != undefined){
//				        $http.get($stateParams.tenantid+'/app/plantrip/timeCalculateInMins?fromLocation='+$scope.trip.fromLocation+'&toLocation='+$scope.trip.toLocation+'&truckId='+$scope.trip.truckId).success(function(datas) {
//				             $scope.timeDiff =datas.timeCalculation;
//				          
//				        });
						
					}
					
				});
				
				 //Truck Details
			    $scope.trip1=[];
			    $scope.$watch('trip.truckId', function(newValue, oldValue) {
			        
			        if (newValue != '' && newValue != undefined) {      
			        	
			            $http.get($stateParams.tenantid+'/app/plantrip/truckid?truck_id='+newValue).success(function(datas) {
			            	console.log(datas);
			            	
			            		$scope.trip1 = datas;
			            	
			            	
			            	

			            }).error(function(data) {
			            	logger.logError("Unable to fetch");
			            });    

			        }
			    });
				
				$scope.save= function(trip,TripForm){
					if (new validationService().checkFormValidity($scope.TripForm)) {
					$http.post($stateParams.tenantid+'/app/plantrip/add',
							$scope.trip).success(function(datas) {
								if(datas){
									$('#calendar').unblock(); 
					                logger.logSuccess("Saved Successfully!");
					                if($scope.truckListselected != ''){
					         		   $http.post($stateParams.tenantid+'/truckSchedule/searchTruck',$scope.truckListselected).success(function(data) {
					        				if(data.success = true){
						        				$scope.evtList = data.trkEvtCalender;
						        				$scope.loadCalValues();
												var d = $filter('date')($scope.trip.etd, "yyyy-mm-dd")
												var a = $scope.trip.etd;
											    var x = a.split('/')
											    var d=x[1]+'/'+x[0]+'/'+x[2]
												$('#calendar').fullCalendar('gotoDate', d);
								                
								                if($("#calendar") .hasClass("modCalClass")){
								  				  $("#calendar").removeClass("modCalClass");
								  			  }
								  			  
								  			  if($(".accTruckEvt") .hasClass("modTrkEvt")){
								  				  $(".accTruckEvt").removeClass("modTrkEvt");
								  			  }
						        			}
					        			})
					         	   }else{
					         		  $http.post($stateParams.tenantid+'/truckSchedule/calendarEvents').success(function(data) {
						        			if(data.success = true){
						        				$scope.evtList = data.trkEvtCalender;
						        				$scope.loadCalValues();
												var d = $filter('date')($scope.trip.etd, "yyyy-mm-dd")
												var a = $scope.trip.etd;
											    var x = a.split('/')
											    var d=x[1]+'/'+x[0]+'/'+x[2]
												$('#calendar').fullCalendar('gotoDate', d);
								                
								                if($("#calendar") .hasClass("modCalClass")){
								  				  $("#calendar").removeClass("modCalClass");
								  			  }
								  			  
								  			  if($(".accTruckEvt") .hasClass("modTrkEvt")){
								  				  $(".accTruckEvt").removeClass("modTrkEvt");
								  			  }
						        			}
						        		});
					         	   }
								}
								else{
									  logger.logError("Error in save!");
								}
						
					})
					
					}
				    else{
			            toaster.pop('error', "Please fill the required fields", 
			                    logger.getErrorHtmlNew($scope.TripForm.$validationSummary), 555000, 'trustedHtml');
			                       }
					
				}
				

			    $scope.getDropdownvalue = function() { 
			        $http.get($stateParams.tenantid+'/app/distance/getPort').success(function(datas) {
			             $scope.portList =datas.portList;
			             console.log("HI");
			             console.log(datas.portList);
			           
			          
			        });
			        
			        $http.get($stateParams.tenantid+'/truckdrivermapping/trucklist').success(function(datas) {
			            $scope.truckList =datas.truckList;
			            console.log(datas.truckList);
			         
			       });
			        
			        
			    }
				   $scope.trailerList = [];
				   $scope.driverList=[];
				   
				   
				   
				   $scope.$watchCollection('[trip.truckId,trip.tripStartDate]', function(newValue, oldValue) {
					   debugger
				        if (newValue != '' && newValue != undefined) {
				           if($scope.trip.tripStartDate != '' && $scope.trip.tripStartDate != undefined
				        && $scope.trip.truckId != '' && $scope.trip.truckId != undefined){

				                $http.get($stateParams.tenantid+'/app/plantrip/getTrailerByTruck?truckCode='+$scope.trip.truckId+'&tripStartDate='+$scope.trip.tripStartDate).success(function(datas) {
				                    $scope.trailerList = datas.list;
				                    $scope.trip.truckTrailerMappingId=datas.mappingId;
				                    if(datas.trailerId != null){
					                    $scope.trip.trailerId=datas.trailerId.toString();
					                    }
					                    else{
					                    	 $scope.trip.trailerId='';
					                    }
				                   
				                    
				                    console.log(datas);
				                    }).error(function(datas) {
				                });   
				                

				                $http.get($stateParams.tenantid+'/app/plantrip/getDriverByTruck?truckId='+$scope.trip.truckId+'&tripStartDate='+$scope.trip.tripStartDate).success(function(datas) {
				                    $scope.driverList = datas.list;
				                    $scope.trip.driverId=datas.list[0].id;
				                    console.log(datas);
				                    }).error(function(datas) {
				                }); 
				                
				        }
				          
				        }
				    });
				    
				   
				   
				   $scope.$watchCollection('[trip.truckId,trip.driverId]', function(newValue, oldValue) {
					   debugger
				        if (newValue != '' && newValue != undefined) {
				           if($scope.trip.driverId != '' && $scope.trip.driverId != undefined
				        && $scope.trip.truckId != '' && $scope.trip.truckId != undefined){

				                $http.get($stateParams.tenantid+'/app/plantrip/getMappingIdbyTruckDriver?truckId='+parseInt($scope.trip.truckId)+'&driverId='+$scope.trip.driverId).success(function(datas) {
				                    $scope.trip.driverMappingId=datas.driverMappingId;
				                   
				                    
				                    console.log(datas);
				                    }).error(function(datas) {
				                });   
				        }
				          
				        }
				    });
				    
				   
				    
			    
			    
			    
			    $scope.$watch('trip.trailerId', function(newValue, oldValue) {
			        if (newValue != '' && newValue != undefined) {
			           if($scope.trip.truckId != '' && $scope.trip.truckId != undefined &&
			        	 $scope.trip.truckTrailerMappingId != '' && $scope.trip.truckTrailerMappingId != undefined){

			                $http.get($stateParams.tenantid+'/app/plantrip/autoGenTripNo?truckId='+$scope.trip.truckId+'&mappingId='+$scope.trip.truckTrailerMappingId).success(function(datas) {
			                    $scope.trip.tripNo = datas.autoGenTripNo;
			                    
			                    
			                    console.log(datas);
			                    }).error(function(datas) {
			                });               
			        }
			           else
			        	   {
			        	   logger.logError("Please Select Start Trip Date!");
			        	   }
			        }
			        else{
			       	 $scope.trip.tripNo = '';
			       }
			    });
			    
			    
			    
			    $scope.getDropdownvalue();*/
			    
			    
			    
			    

				$scope.organisation = {};
				$scope.rowCollection = [];
				$scope.displayedCollection = [];
				$scope.tripReallocate=false;
				
				var lolId = $stateParams.lolId;
				var lodId = $stateParams.lodId;
				
				$scope.changeTrailerMapping = function(editid){    
					if($scope.trip.truckTrailerMappingId != '' && $scope.trip.truckTrailerMappingId != null){
						$location.url($stateParams.tenantid+'/trucktrailer/edit?rowid='+editid);   
					}
					else{
						  logger.logError("Please Select Trailer!");
					}
			        
					
				}
				
				

				$scope.trip={
						truckId: '',
						tripNo : '',
						trailerId: '',
						fromLocation : '',
						toLocation : '',
						eta : '',
						etd : '',
						truckRegNo : '',
						trailerNo : '',
						truckTrailerMappingId : '',
			            tripStartDate	: '',
			            driverId : [],
			            driverMappingId : '',
			            refId : ''
			            


						
				}
				
				$scope.trip1={		
						tripNo : '',			
						fromLocation : '',
						toLocation : '',
						eta : '',
						etd : '',
						truckRegNo : '',
						trailerNo : '',
						driversName :''


						
				}
				$scope.transportType='';
				
				
				if(lolId != '' && lolId != null && lodId != '' && lodId != null){
					$scope.trip.fromLocation=lolId;
					$scope.trip.toLocation=lodId;
					$scope.tripReallocate=true;
				}
				
				$scope.$watchCollection('[ trip.fromLocation,trip.toLocation]', function(newValue, oldValue) {
					if($scope.trip.fromLocation != "" && $scope.trip.fromLocation != undefined &&
							$scope.trip.toLocation != "" && $scope.trip.toLocation != undefined){
				        $http.get($stateParams.tenantid+'/app/booking/getLocalOrTransit?fromLocation='+$scope.trip.fromLocation+'&toLocation='+$scope.trip.toLocation).success(function(datas) {
				             $scope.transportType =datas.transportType;
				          
				        });
						
					}
					
				});
				
			  
				 //Truck Details
			    $scope.trip1=[];
			    $scope.$watch('trip.truckId', function(newValue, oldValue) {
			        
			        if (newValue != '' && newValue != undefined) {      
			        	
			            $http.get($stateParams.tenantid+'/app/plantrip/truckid?truck_id='+newValue).success(function(datas) {
			            	console.log(datas);
			            	
			            		$scope.trip1 = datas;
			            	
			            	
			            	

			            }).error(function(data) {
			            	logger.logError("Unable to fetch");
			            });    

			        }
			    });
				
				$scope.save= function(trip,TripForm){
					if (new validationService().checkFormValidity($scope.TripForm)) {
					$http.post($stateParams.tenantid+'/app/plantrip/add',
							$scope.trip).success(function(datas) {
								if(datas){
									$('#calendar').unblock(); 
					                logger.logSuccess("Saved Successfully!");
					                $http.post($stateParams.tenantid+'/truckSchedule/calendarEvents').success(function(data) {
					        			if(data.success = true){
					        				$scope.evtList = data.trkEvtCalender;
					        				$scope.loadCalValues();
											var d = $filter('date')($scope.trip.etd, "yyyy-mm-dd")
											var a = $scope.trip.etd;
										    var x = a.split('/')
										    var d=x[1]+'/'+x[0]+'/'+x[2]
											$('#calendar').fullCalendar('gotoDate', d);
							                
							                if($("#calendar") .hasClass("modCalClass")){
							  				  $("#calendar").removeClass("modCalClass");
							  			  }
							  			  
							  			  if($(".accTruckEvt") .hasClass("modTrkEvt")){
							  				  $(".accTruckEvt").removeClass("modTrkEvt");
							  			  }
					        			}
					        		});
								}
								else{
									  logger.logError("Error in save!");
								}
						
					})
					
					}
				    else{
			            toaster.pop('error', "Please fill the required fields", 
			                    logger.getErrorHtmlNew($scope.TripForm.$validationSummary), 555000, 'trustedHtml');
			                       }
					
				}
				

			    $scope.getDropdownvalue = function() { 
			        $http.get($stateParams.tenantid+'/app/distance/getPort').success(function(datas) {
			             $scope.portList =datas.portList;
			             console.log("HI");
			             console.log(datas.portList);
			           
			          
			        });
			        
			        $http.get($stateParams.tenantid+'/truckdrivermapping/trucklist').success(function(datas) {
			            $scope.truckList =datas.truckList;
			            console.log(datas.truckList);
			         
			       });
			        
			        
			    }
				   $scope.trailerList = [];
				  
					
				    $("#driverListSelect").multiselect({
				        maxHeight: 200,   
				        includeSelectAllOption: true,
				        disableIfEmpty: true,
				        enableCaseInsensitiveFiltering: true,
				        onDropdownHide: function (event) {
				            
				        }
				      });
				    $(".multiselect").addClass("width_100 input-sm line-height-5");
				    
				   
				   
				   $scope.$watchCollection('[trip.truckId,trip.tripStartDate]', function(newValue, oldValue) {
					   debugger
				        if (newValue != '' && newValue != undefined) {
				           if($scope.trip.tripStartDate != '' && $scope.trip.tripStartDate != undefined
				        && $scope.trip.truckId != '' && $scope.trip.truckId != undefined){

				                $http.get($stateParams.tenantid+'/app/plantrip/getTrailerByTruck?truckCode='+$scope.trip.truckId+'&tripStartDate='+$scope.trip.tripStartDate).success(function(datas) {
				                    $scope.trailerList = datas.list;
				                    $scope.trip.truckTrailerMappingId=datas.mappingId;
				                    if(datas.trailerId != null){
					                    $scope.trip.trailerId=datas.trailerId.toString();
					                    }
					                    else{
					                    	 $scope.trip.trailerId='';
					                    }
				                   
				                    
				                    console.log(datas);
				                    }).error(function(datas) {
				                });   
				                

				                $http.get($stateParams.tenantid+'/app/plantrip/getDriverByTruck?truckId='+$scope.trip.truckId+'&tripDate='+$scope.trip.tripStartDate).success(function(datas) {
				                	
				                	 $scope.driverList = datas.list;
				                 //   $scope.trip.driverId=datas.list[0].id;
				                    console.log(datas);
				                    
				                    $timeout(function() {
						                $('#driverListSelect').multiselect('deselectAll', false);
						                $('#driverListSelect').multiselect('updateButtonText');
						                $("#driverListSelect").multiselect('rebuild');
						            
						            }, 2, false);
						            $("#multiselect-button").addClass("width_100 input-sm line-height-5");
								
				                    
				                    }).error(function(datas) {
				                }); 
				                
				        }
				          
				        }
				    });
				    
				   
				   
				   $scope.$watchCollection('[trip.truckId,trip.driverId]', function(newValue, oldValue) {
					   debugger
				        if (newValue != '' && newValue != undefined) {
				           if($scope.trip.driverId != '' && $scope.trip.driverId != undefined
				        && $scope.trip.truckId != '' && $scope.trip.truckId != undefined){

				                $http.get($stateParams.tenantid+'/app/plantrip/getMappingIdbyTruckDriver?truckId='+parseInt($scope.trip.truckId)+'&driverId='+$scope.trip.driverId+'&tripDate='+$scope.trip.tripStartDate).success(function(datas) {
				                    $scope.trip.driverMappingId=datas.driverMappingId;
				                   
				                    
				                    console.log(datas);
				                    }).error(function(datas) {
				                });   
				        }
				          
				        }
				    });
				    
				   
				    
			    
			    
			    
			    $scope.$watch('trip.trailerId', function(newValue, oldValue) {
			        if (newValue != '' && newValue != undefined) {
			           if($scope.trip.truckId != '' && $scope.trip.truckId != undefined &&
			        	 $scope.trip.truckTrailerMappingId != '' && $scope.trip.truckTrailerMappingId != undefined){

			                $http.get($stateParams.tenantid+'/app/plantrip/autoGenTripNo?truckId='+$scope.trip.truckId+'&mappingId='+$scope.trip.truckTrailerMappingId).success(function(datas) {
			                    $scope.trip.tripNo = datas.autoGenTripNo;
			                    
			                    
			                    console.log(datas);
			                    }).error(function(datas) {
			                });               
			        }
			           else
			        	   {
			        	   logger.logError("Please Select Start Trip Date!");
			        	   }
			        }
			        else{
			       	 $scope.trip.tripNo = '';
			       }
			    });
			    
			    
			    
			    
			    
			   /* $scope.cancel=function(){
			    	$state.go("app.operation.trip.list");
			    }*/
			    
			   /* $scope.reset=function(){
			    	$state.reload();
			    }*/
			  
			    $scope.getDropdownvalue();
				
				 $('#fromDate').datetimepicker({
				        format : 'DD/MM/YYYY HH:MM'
				    })
				    
				     $('#toDate').datetimepicker({
				        format : 'DD/MM/YYYY  HH:MM'
				    })
				    
				    	     $('#tripStartDate').datetimepicker({
				        format : 'DD/MM/YYYY '
				    })
				    
				    
//				    $scope.$watch('trip.eta', function(newValue, oldValue) {
//				    	start_date, period, number
//				    	var start_date=$scope.trip.eta;
//				    	var period='Hours';
//				    	var number=$scope.timeDiff;
//				    	var dailyDrivingPeriod=9;
//				        if (newValue != '' && newValue != undefined) {
//				            // For Change MM-DD-YYYY Format
//				            var startDate = '';
//				            if (typeof start_date == 'string') {
//				                var dateTime = start_date.split(' ');
//				                var sDate = dateTime[0].split('/');
//				                startDate = sDate[1] + '/' + sDate[0] + '/' + sDate[2] + ' ' + dateTime[1];
//				            } else {
//				                startDate = start_date;
//				            }
//				            var d1=moment(startDate).add(period, number)
//					           $scope.trip.etd= d1.format("dd/mm/yyyy HH24:MM");
//				        };
			//
//				    });
				    
				    

				    

			    
			    
			    
			    
			    
			    
			    
			    
});
