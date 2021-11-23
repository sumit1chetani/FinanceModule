'use strict';
app.controller('trucktrailerAddCtrl', function($scope, $rootScope,ngDialog, $http, $location, logger,
        utilsService,$state,sharedProperties,$window,validationService,toaster,$stateParams,$filter){

    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.isEdit = false;
    $scope.trucktrailermodel = {
           
       truckName:'',
       truckId:'',
       trailerName:'',
       trailerId:'',
	  
       
          fromDate:'',
          toDate:'',
      
        trucktrailerId:''
        
        	
     };
/*    $scope.validateDays= function(noofDays) {
        var reg =/^[0-9.]*$/
        if (reg.test(noofDays)) {
            return true;
        } else {
            // logger.logError("Please Enter Valida Email Address");
            return false;
        }
    }*/
    /*      if($scope.isEdit=true){
	$scope.$watchCollection('[ trucktrailermodel.toDate]',function(newValue, oldValue) {
		if ($scope.trucktrailermodel.toDate != '') {
			
			var toDate = $scope.trucktrailermodel.toDate
			var splitarray = new Array();
			splitarray = toDate.split(" ");
			var date = splitarray[0];
			var time = splitarray[1];
			
			toDate = toDate.split("/");
			toDate = new Date(toDate[2],
					toDate[1] - 1, toDate[0]);
			
			 var test = parseInt(editid);
			    $scope.trucktrailermodel.trucktrailerId=test;
			 $http.get($stateParams.tenantid+'/trucktrailermapping/trucktrailerdateId?=',+$scope.trucktrailermodel.trucktrailerI).success(function(data) {
		         	console.log(data);
		         	
		         		
		         	
		         	
		         	
		         	

		         })
			if (toDate <tripDate) {
				logger.logError(" To Date should  be greater than Trip Date");
			
			}
		}
	});}*/
    $scope.cancel = function() {
	  	  $state.go('app.truck.trucktrailer.list',{tenantid:$stateParams.tenantid});
	  	  
	          
	    };
	    $scope.truckList=[];
	    $scope.gettruckList=function(){
	    	 $http.get($stateParams.tenantid+'/trucktrailermapping/trucklist').success(function(datas) {
	            $scope.truckList = datas.truckList;
	            console.log("truckList");
	            console.log( $scope.truckList);
	           

	        }).error(function(data) {

	        });
	        
	     
	    }
	    $scope.gettruckList();
	    $scope.trailerList=[];
	    $scope.gettrailerList=function(){
	    	 $http.get($stateParams.tenantid+'/trucktrailermapping/trailerlist').success(function(datas) {
	            $scope.trailerList = datas.trailerList;
	            console.log("trailerList");
	            console.log( $scope.trailerList);
	           

	        }).error(function(data) {

	        });
	        
	     
	    }
	    $scope.gettrailerList();
	    

	    $scope.validate = function(trucktrailerForm) {
	        if (new validationService().checkFormValidity(trucktrailerForm)) {
	            if(!$scope.isEdit){
	                $scope.save(trucktrailerForm);
	            }else{
	                $scope.update(trucktrailerForm);
	            }
	        } else {
	            toaster.pop('error', "Please fill the required fields",
	                    logger.getErrorHtmlNew(trucktrailerForm.$validationSummary),5000, 'trustedHtml');
	        }
	    };
		   
	var editid = $location.search().rowid;
		    
		    var test = parseInt(editid);
		    $scope.trucktrailermodel.trucktrailerId=test;
		    $scope.count1=[];
	   $scope.$watch('trucktrailermodel.trucktrailerId', function(newValue, oldValue) {
	            
	            if (newValue != '' && newValue != undefined) {      
	            	
	                $http.get($stateParams.tenantid+'/trucktrailermapping/trucktrailerId?truck_trailer_mapping_id='+newValue).success(function(datas) {
	                	console.log(datas);
	                	
	                		$scope.count = datas;
	                	

	                	

	                })
	            }
	        });
	  
	/*   var test = parseInt(editid);
	    $scope.trucktrailermodel.trucktrailerId=test;
	    
  $scope.$watch('trucktrailermodel.trucktrailerId', function(newValue, oldValue) {
           
           if (newValue != '' && newValue != undefined) {      
           	
               $http.get($stateParams.tenantid+'/trucktrailermapping/trucktrailerdateId?truck_trailer_mapping_id='+newValue).success(function(datas) {
               	console.log(datas);
               	
               		$scope.count = datas;
               	
               	
               	

               })
           }
       });
	   */
	   
	   
	    
	    $scope.save = function(trucktrailerForm) {
	        sharedProperties.clearObject();
            console.log( trucktrailerForm);

 
            
  
            var frmDate = $scope.trucktrailermodel.fromDate;
	             var toDate = $scope.trucktrailermodel.toDate;
	             frmDate = frmDate.split("/");
	             frmDate = new Date(frmDate[2], frmDate[1]-1, frmDate[0]);
	             toDate = toDate.split("/");
	             toDate = new Date(toDate[2], toDate[1]-1, toDate[0]);
	             
	             if(frmDate>toDate){
	                 logger.logError(" Valid To Date should be greater than or Equal to Valid From Date");
	                 $scope.trucktrailermodel.toDate='';
	             }
	         
	             else{
	       	 $http.post($stateParams.tenantid+'/trucktrailermapping/save',$scope.trucktrailermodel)
	            .success(function(response) {
	        	  
	               if(response == 1){
	      	            
	      	             
	            	   
	            	   
	                   logger.logSuccess("Saved Succesfully!");
	                
		         	  	  $state.go('app.truck.trucktrailer.list',{tenantid:$stateParams.tenantid});
	      	             
	                   }else{
		            	   logger.logError("Truck and Trailer Already Allocated on Same Date")
	               
	            }
	            
	      
	    });}
	             
	    
	    }
	    $scope.update = function(trucktrailerForm) {
	        sharedProperties.clearObject();
	        var frmDate = $scope.trucktrailermodel.fromDate;
	             var toDate = $scope.trucktrailermodel.toDate;
	             frmDate = frmDate.split("/");
	             frmDate = new Date(frmDate[2], frmDate[1]-1, frmDate[0]);
	             toDate = toDate.split("/");
	              toDate = new Date(toDate[2], toDate[1]-1, toDate[0]);
	             if(frmDate>toDate){
	                 logger.logError(" Valid To Date should be greater than or Equal to Valid From Date");
	                 $scope.trucktrailermodel.toDate='';
	             }
	         
	             else{
	            	 if ($scope.trucktrailermodel.toDate != ''  && ($scope.count>0)) {
							
		 					
							var editid = $location.search().rowid;
						    
						    var test = parseInt(editid);
						    $http.post($stateParams.tenantid+'/trucktrailermapping/gettripdate',test).success(function(result) {
						    	$scope.tripDate=[];
						    	
						    	$scope.tripDate = result.ltripDate;
				                for(var i=0;i<=$scope.tripDate.length;i++)
				                	{
				                	 var frmDate =  $scope.tripDate[i].startDate;	
				      	             var toDate = $scope.trucktrailermodel.toDate;
				      	             frmDate = frmDate.split("/");
				      	             frmDate = new Date(frmDate[2], frmDate[1]-1, frmDate[0]);
				      	             toDate = toDate.split("/");
				      	             toDate = new Date(toDate[2], toDate[1]-1, toDate[0]);
				        			
				      	           if (toDate <frmDate) {
										logger.logError(" To Date should  be greater than Trip Start Date");
										$scope.trucktrailermodel.toDate='';
									}
				      	     	 else{
				      	     	 	 $http.post($stateParams.tenantid+'/trucktrailermapping/update',$scope.trucktrailermodel)
				     	            .success(function(response) {
				     	          		 console.log(response);
				     	          		if(response == 1){
				     	      	            
				     	            	   
				     	            	   
				     	                   logger.logSuccess("Updated Successfully Succesfully!");
				     	                
				     		         	  	  $state.go('app.truck.trucktrailer.list',{tenantid:$stateParams.tenantid});
				     	      	             
				     	                   }else{
				     		            	   logger.logError("Truck and Trailer Already Allocated on Same Date")
				     	               
				     	            }
				     	              
				     	            });
				             } 	
				      	           
				      	           
				                	}

						    	
						    	
						
					});
						}
	            	 else{
	      	 $http.post($stateParams.tenantid+'/trucktrailermapping/update',$scope.trucktrailermodel)
	            .success(function(response) {
	          		 console.log(response);
	          		if(response == 1){
	      	            
	            	   
	            	   
	                   logger.logSuccess("Updated Successfully Succesfully!");
	                
		         	  	  $state.go('master.trucktrailer.list',{tenantid:$stateParams.tenantid});
	      	             
	                   }else{
		            	   logger.logError("Truck and Trailer Already Allocated on Same Date")
	               
	            }
	              
	            });
	      	 }}
	             }
	        
	   
	   var currentDate = new Date();
	     currentDate = ('0' + currentDate.getDate()).slice(-2)+"/"+('0' + (Number(currentDate.getMonth())+1)).slice(-2)+"/"+currentDate.getFullYear();
	   
	     

	var editid = $location.search().rowid;
	    
	    var test = parseInt(editid);
	    if(test){
	    $scope.isEdit=true;
	    $http.post($stateParams.tenantid+'/trucktrailermapping/edit',test).success(function(result) {
	    	
	    		
	    	console.log(result);
	    	$scope.trucktrailermodel = result;

	    	$scope.trucktrailermodel.truckId = result.truckId.toString();
	    	$scope.trucktrailermodel.trailerId = result.trailerId.toString();

	    	
	    	
	    });
	}
	
		/*		$scope.$watchCollection('[ trucktrailermodel.toDate]',function(newValue, oldValue) {
					if ($scope.trucktrailermodel.toDate != ''  && ($scope.count>0)) {
						
					
						var editid = $location.search().rowid;
					    
					    var test = parseInt(editid);
					    $http.post($stateParams.tenantid+'/trucktrailermapping/gettripdate',test).success(function(result) {
					    	$scope.tripDate=[];
					    	
					    	$scope.tripDate = result.ltripDate;
			                for(var i=0;i<=$scope.tripDate.length;i++)
			                	{
			                	 var frmDate =  $scope.tripDate[i].startDate;	
			      	             var toDate = $scope.trucktrailermodel.toDate;
			      	             frmDate = frmDate.split("/");
			      	             frmDate = new Date(frmDate[2], frmDate[1]-1, frmDate[0]);
			      	             toDate = toDate.split("/");
			      	             toDate = new Date(toDate[2], toDate[1]-1, toDate[0]);
			        			
			      	           if (toDate <frmDate) {
									logger.logError(" To Date should  be greater than Trip Start Date");
									$scope.trucktrailermodel.toDate='';
								}
			                	
			                	}

					    	
					    	
					
				});
					}});*/
	  $scope.reset = function(trucktrailerForm) {
	        
	        if($scope.isEdit = true){
	            var trucktrailerId =  $scope.trucktrailermodel.trucktrailerId;
	            $scope.trucktrailermodel.truckName ='';
	       	 $scope.trucktrailermodel.truckId ='';
	       	 $scope.trucktrailermodel.fromDate ='';
	       	 $scope.trucktrailermodel.trailerId ='';
	       	 $scope.trucktrailermodel.trailerName ='';
	       	 $scope.trucktrailermodel.toDate ='';

	       	 $scope.trucktrailermodel.trucktrailerId ='';
	       	

	         $http.post($stateParams.tenantid+'/trucktrailermapping/edit',test).success(function(result) {
	 	    	
		    		
	 	    	console.log(result);
	 	    	$scope.trucktrailermodel = result;

	 	    	$scope.trucktrailermodel.truckId = result.truckId.toString();
	 	    	$scope.trucktrailermodel.trailerId = result.trailerId.toString();

	               
	            });
	        }
	        else{
	        	 $scope.trucktrailermodel.truckName ='';
	        	 $scope.trucktrailermodel.truckId ='';
	        	 $scope.trucktrailermodel.fromDate ='';
	        	 $scope.trucktrailermodel.toDate ='';
	        	 $scope.trucktrailermodel.trailerId ='';
	        	 $scope.trucktrailermodel.trailerName ='';
	        	 $scope.trucktrailermodel.trucktrailerId ='';
	      	  
	          
	        }  $rootScope.evtList=[];
       	 $scope.showShdBtn=false;
   	  $rootScope.$emit("hideScheduler", {});
	        
	  }
	  
	  

			  $scope.trukDtl={
				 truckId:$scope.trucktrailermodel.truckId,
				 truckName:$scope.trucktrailermodel.truckName,
				 trailerId:$scope.trucktrailermodel.trailerId,
				 trailerName:$scope.trucktrailermodel.trailerName,
				 fromDate:$scope.trucktrailermodel.fromDate,
				 toDate:$scope.trucktrailermodel.toDate,
				 trucktrailerId:$scope.trucktrailermodel.trucktrailerId,
				 }
			  
			 
			  $scope.getTruckNameById=function(){
				  var value1 = $scope.truckList;
				  angular.forEach(value1, function(value, key) {
					  if(value.id == $scope.trukDtl.truckId){
						  $scope.trukDtl.truckName=value.text;
					  }
					});
			  }
			  $scope.getTrailerNameById=function(){
				  var value2 = $scope.trailerList
				  angular.forEach(value2, function(value, key) {
					  if(value.id == $scope.trukDtl.trailerId){
						  $scope.trukDtl.trailerName=value.text;
					  }
					});
			  }
			  
		  $scope.monthSchedule=[];
		  $scope.monthScheduleTemp=[];
		  $scope.monthSchedule1=[];
		  $rootScope.evtList=[];
		  $scope.evtListTemp=[];
	      $scope.trEvt=[];
	      $scope.trRes=[];
	      $scope.showShdBtn=false;
		  
		  /*$scope.$watch('trucktrailermodel.fromDate', function(newValue, oldValue) {
			  
			  var d = $filter('date')($scope.trucktrailermodel.fromDate, "yyyy-mm-dd")
				var a = $scope.trucktrailermodel.fromDate;
			    var x = a.split('/')
			    var d=x[1]+'/'+x[0]+'/'+x[2];
			    $rootScope.goToDate=d;
			    if( $rootScope.evtList.length > 0){
			    	$rootScope.$emit("goToSelectedDate",{});
			    }
		  });*/
		  
	     /*$scope.$watch('trucktrailermodel.truckId', function(newValue, oldValue) {
			  $scope.trukDtl.truckId=$scope.trucktrailermodel.truckId;
			  if($scope.trucktrailermodel.truckId !='' && $scope.trucktrailermodel.truckId != undefined){
				  $http.post($stateParams.tenantid+'/trucktrailermapping/getTruckDltById',$scope.trukDtl).success(function(datas) {
					  $scope.loadScheCalValues(datas,'1');
				  }).error(function(datas) {

			        });  
			  }else{
				  if($scope.trucktrailermodel.truckId !='' || $scope.trucktrailermodel.truckId != undefined){
					  $scope.loadEmptyValues('1');  
					  
				  }
			  }
			  
		  });*/
	     
	     /*$scope.$watch('trucktrailermodel.trailerId', function(newValue, oldValue) {
			  $scope.trukDtl.trailerId=$scope.trucktrailermodel.trailerId;
			  if($scope.trucktrailermodel.trailerId !='' && $scope.trucktrailermodel.trailerId != undefined){
				  $http.post($stateParams.tenantid+'/trucktrailermapping/getTrailerDltById',$scope.trukDtl).success(function(datas) {
					  
					  $scope.loadScheCalValues(datas,'2')
				  }).error(function(datas) {

			        });  
			  }else{
				  	if($scope.trucktrailermodel.trailerId !='' || $scope.trucktrailermodel.trailerId != undefined){
				  		
				  		 $scope.loadEmptyValues('2');
				  		
				  	}
			  }
			  
		  });*/
	     
	     /*$scope.loadCalValues = function() {
			  $('#truckTrailMapScheduler').fullCalendar('destroy');
			  $('#truckTrailMapScheduler').fullCalendar({
				  schedulerLicenseKey: 'GPL-My-Project-Is-Open-Source',
					now: new Date(),
					editable: false,
					aspectRatio: 4,
					scrollTime: '00:00',
					header: {
						left: 'today prev,next',
						center: 'title',
						right: 'timelineMonth,timelineYear'
					},
					defaultView: 'timelineMonth',
					displayEventTime : false,
					views: {
					},
					navLinks: true,
					resourceAreaWidth: '25%',
					
					resourceColumns: [
					  				{
					  					labelText: 'Truck/Trailer Availability',
					  					field: 'truck'
					  				}
					  				
					  			],
		  			   eventMouseover: function (data, event, view) {
		  		    	var fD = $filter('date')(data.fromDate, "dd-MM-y");
		  		    	var tD = $filter('date')(data.toDate, "dd-MM-y")
		  		    	  
		  		    	 var tooltip = '<div class="tooltiptopicevent" style="width:auto;height:auto;background:#6dbdd6;position:absolute;z-index:10001;padding:10px 10px 10px 10px ;  line-height: 200%;">' +
		  		    	 'Truck : ' + '<span style="color:#5f265a">' + data.mtitle+'</span>'+'</br>' + 'Trailer : ' + '<span style="color:#5f265a">' + data.trailerName +'</span>'+
		  		    	'</br>' +''+ 'From Date : ' + '<span style="color:#5f265a">' + fD +'</span>'+ '</br>' + 'To Date : ' + '<span style="color:#5f265a">' + tD +'</span>'+ '</div>';


		  	            $("body").append(tooltip);
		  	            $(this).mouseover(function (e) {
		  	                $(this).css('z-index', 1000000);
		  	                $('.tooltiptopicevent').fadeIn('500');
		  	                $('.tooltiptopicevent').fadeTo('10', 1.9);
		  	            }).mousemove(function (e) {
		  	                $('.tooltiptopicevent').css('top', e.pageY + 10);
		  	                $('.tooltiptopicevent').css('left', e.pageX + 20);
		  	            });


		  	        },
		  	        eventMouseout: function (data, event, view) {
		  	            $(this).css('z-index', 8);
		  	            $('.tooltiptopicevent').remove();
		  	          $scope.scheViewData='';

		  	        },
					
					
					resources: $scope.monthSchedule,
					events: $scope.monthSchedule
				});
			  
			  
			  if($scope.trucktrailermodel.fromDate !='' && $scope.trucktrailermodel.fromDate != undefined){
				   var d = $filter('date')($scope.trucktrailermodel.fromDate, "yyyy-mm-dd")
					var a = $scope.trucktrailermodel.fromDate;
				    var x = a.split('/')
				    var d=x[1]+'/'+x[0]+'/'+x[2]
				  
				  $('#truckTrailMapScheduler').fullCalendar('gotoDate',d);
			  }
			  
			  $( "#truckTrailMapScheduler" ).find( ".fc-content" ).find("tbody").find("tr").find("th").find("a").attr( "data-goto", "" );
			  $( "#truckTrailMapScheduler" ).find( ".fc-content" ).find("tbody").find("tr").find("th").find("a").css('cursor','auto');
			  $( "#truckTrailMapScheduler" ).find( ".fc-content" ).find("tbody").find("tr").find("th").find("a").hover(
					    function() {
					        $(this).css('color', '#181818')
					         $(this).css('text-decoration', 'none')
					    }, function() {
					        $(this).css('color', '#181818')
					         $(this).css('text-decoration', 'none')
			   });
			  
		  }*/
	     
	     /*$scope.loadScheCalValues=function(datas,num){
	          $scope.monthScheduleTemp =[];
	          $scope.monthScheduleTemp =datas;
	          
	          $scope.trRes=[]
	          if($scope.monthScheduleTemp.length > 0){
	        	  $scope.evtListTemp=[];
	          	if($rootScope.evtList.length > 0){
	          		var monSch1 =$rootScope.evtList;
	          		$scope.evtListTemp=[];
		            	angular.forEach(monSch1, function(value, key) {
		            		$scope.trRes=[];
		            		if(value.id !=num &&  value.start != ''){
		            		$scope.trRes.id=value.id,
		            		$scope.trRes.text=value.text,
		            		$scope.trRes.resource=value.resource,
		            		$scope.trRes.start=value.start,
		            		$scope.trRes.end=value.end,
		            		$scope.trRes.bubbleHtml=value.bubbleHtml
		            		$scope.trRes.moveDisabled=true;
		            		$scope.trRes.resizeDisabled=true;
		            	   $scope.evtListTemp.push($scope.trRes);
		            	}
		            		
		            	});
	          	}
	          	
	          	var monSch2 =$scope.monthScheduleTemp;
	          	if(monSch2.length >= 1){
	          	angular.forEach(monSch2, function(value, key) {
	          		$scope.trRes=[];
	          		if(value.id ==num &&  value.start != ''){
	          		$scope.trRes.id=value.id,
	          		$scope.trRes.text=value.title;
	          		$scope.trRes.resource=value.id;
	          		$scope.trRes.start=value.start.length > 0 ?  value.start+"T00:00:00" : "";
				    $scope.trRes.end=value.end.length > 0 ?  value.end+"T12:50:00" : "";
				    var fD = $filter('date')(value.start, "dd-MM-y");
	  		    	var tD = $filter('date')(value.end, "dd-MM-y");
	  		    	$scope.trRes.moveDisabled=true;
	  		    	$scope.trRes.resizeDisabled=true;
	  		    	$scope.trRes.bubbleHtml='<div style="background-color: #46bde2;border:2px solid #181818;padding:3px;">'+'<span style="color:#011954">'+'Truck '+'&nbsp;&nbsp;&nbsp;'+': '+'</span>'+'<span style="color:#fff">'+value.mtitle+'</span>'+'<br/>'+'<span style="color:#0d308f">'+'<span style="color:#011954">'+'Trailer '+'&nbsp;&nbsp;'+': '+'</span>'+'<span style="color:#fff">'+value.trailerName+'</span>'+'<br/>'+'<span style="color:#011954">'+'Start '+'&nbsp;&nbsp;&nbsp;&nbsp;'+': '+'</span>'+'<span style="color:#fff">'+fD+'</span>'+'<br/>'+'<span style="color:#011954">'+'End '+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+': '+'</span>'+'<span style="color:#fff">'+tD+'</span>'+'</div>';
	          	   $scope.evtListTemp.push($scope.trRes);
	          	}
	          		
	          	});
	          	}
	          	
	          }
	          
	          if($scope.evtListTemp.length ==0){
	        	  $rootScope.evtList=[];
	          }else{
	        	  $rootScope.evtList=$scope.evtListTemp;
	          }
	          $scope.showShdBtn=true;
	          $rootScope.$emit("CallSchLoadMethod", {});
		  }
	     
	     $scope.loadEmptyValues=function(num){
			  
			  var monSch2 = $rootScope.evtList;
	      	if(monSch2.length > 0){
	      		$scope.evtListTemp=[];
	      		angular.forEach(monSch2, function(value, key) {
	          		$scope.trRes=[];
	          		if(value.id !=num){
	          		$scope.trRes.id=value.id,
	          		$scope.trRes.text=value.text,
	          		$scope.trRes.resource=value.resource,
	          		$scope.trRes.start=value.start,
	          		$scope.trRes.end=value.end,
	          		$scope.trRes.bubbleHtml=value.bubbleHtml
	          		$scope.trRes.moveDisabled=true;
	          		$scope.trRes.resizeDisabled=true;
	          	   $scope.evtListTemp.push($scope.trRes);
	          	}
	          		
	          	});
	      		$rootScope.evtList=[];
		           $rootScope.evtList=$scope.evtListTemp;
		           if($rootScope.evtList.length==0){
		        	  $scope.showShdBtn=false;
		        	$rootScope.$emit("hideScheduler", {});
		           }else{
		        	   $scope.showShdBtn=true;
		               $rootScope.$emit("CallSchLoadMethod", {});
		           }
	      }
			  
		  }*/
	       

	    
});


/*var trkTrailApp = angular.module('main', [ 'daypilot' ]);

'use strict';
trkTrailApp.controller('DemoCtrl', function($scope, $rootScope, ngDialog, $http,
		$location, logger, utilsService, $state, sharedProperties, $window,
		validationService, toaster, $stateParams, $filter) {

	$scope.showShedr = false;

	$scope.scheEvntList = [];

	$rootScope.$on("CallSchLoadMethod", function() {
		$scope.loadCurrMonDate();
	});
	$rootScope.$on("goToSelectedDate", function() {
		var d = $rootScope.goToDate;
		var x = d.split('/')
		var da = new Date(x[2], x[0] - 1, x[1])
		$scope.loadGoToDate(da);

	});

	$rootScope.$on("hideScheduler", function() {
		$scope.showShedr = false;
	})

	$scope.childMethod = function(date, days) {
		$scope.showShedr = true;
		$scope.scheEvntList = $rootScope.sch;
		$scope.loadScheduleCal(date, days);
		 var date = new Date(); 
		var d = $filter('date')(
				new Date(date.getFullYear(), date.getMonth() + 1, 1),
				"yyyy-mm-dd")
		$scope.scrollTo(d);
	}

	$scope.loadScheduleCal = function(date, days) {
		$scope.evtLt = []
		$scope.evtLt = $rootScope.evtList;
		$scope.config = {}
		$scope.config = {
			scale : "Day",
			days : days,
			bubble : new DayPilot.Bubble(),
			startDate : new Date(date.getFullYear(), date.getMonth(), 2),

			timeHeaders : [ {
				groupBy : "Month"
			}, {
				groupBy : "Cell",
				format : "d"
			} ],
			resources : [ {
				name : "Truck",
				id : "1"
			}, {
				name : "Trailer",
				id : "2"
			} ],

			rowMinHeight : 50,
			rowMinWidth : 50,
			headerHeight : 40,
			durationBarVisible : false,
			durationBarColor : "red",
			barBackColor : "red",
			cellWidthSpec : 'Auto',

		};
		$scope.events = [];
		
		//this update for update EVENTS without this method it won't update
		
		$http.post($stateParams.tenantid+'/truckSchedule/updateValue').success(function(data) {
			if(data.success = true){
				$scope.events =$rootScope.evtList;
			}
		});
		

	}

	$scope.scrollTo = function(date) {
		$scope.dp.scrollTo(date);
	};

	$scope.loadCurrMonDate = function() {
		var date;
		var sp = $rootScope.goToDate.split('/');
		if (sp[1].length > 0) {
			var d = $rootScope.goToDate;
			var x = d.split('/')
			date = new Date(x[2], x[0] - 1, x[1]);
		} else {
			date = new Date();
		}

		$scope.CurrDt = date;
		var firstDay = new Date(date.getFullYear(), date.getMonth(), 1);
		var lastDay = new Date(date.getFullYear(), date.getMonth() + 1, 0);
		var diff = new Date(lastDay - firstDay);
		var days = diff / 1000 / 60 / 60 / 24;
		days = days + 1;
		$scope.childMethod(date, days);
	}

	$scope.loadGoToDate = function(date) {
		if (date.getFullYear() > 0) {
			$scope.CurrDt = date;
			var firstDay = new Date(date.getFullYear(), date.getMonth(), 1);
			var lastDay = new Date(date.getFullYear(), date.getMonth() + 1, 0);
			var diff = new Date(lastDay - firstDay);
			var days = diff / 1000 / 60 / 60 / 24;
			days = days + 1;
			$scope.childMethod(date, days);
		}
	}

	$scope.gotoNextYear = function() {
		var d = $scope.CurrDt;
		var m;
		var y;
		var dys;
		if (d.getMonth() == 11) {
			m = 0;
			y = d.getFullYear() + 1
		} else {
			m = d.getMonth() + 1;
			y = d.getFullYear()
		}
		var firstDay = new Date(y, m, 1);
		var lastDay = new Date(y, m + 1, 0);
		var diff = new Date(lastDay - firstDay);
		dys = diff / 1000 / 60 / 60 / 24;
		dys = dys + 1;
		$scope.CurrDt = new Date(y, m, 1)
		var date = $scope.CurrDt;
		$scope.childMethod(date, dys);

	}

	$scope.gotoPrevYear = function() {
		var d = $scope.CurrDt;
		var m;
		var y;
		var dys;
		if (d.getMonth() == 11) {
			m = 10;
			y = d.getFullYear()
		} else {
			m = d.getMonth() - 1;
			y = d.getFullYear()
		}
		var firstDay = new Date(y, m, 1);
		var lastDay = new Date(y, m + 1, 0);
		var diff = new Date(lastDay - firstDay);
		dys = diff / 1000 / 60 / 60 / 24;
		dys = dys + 1;
		$scope.CurrDt = new Date(y, m, 1)
		var date = $scope.CurrDt;
		$scope.childMethod(date, dys);
	}

});
*/