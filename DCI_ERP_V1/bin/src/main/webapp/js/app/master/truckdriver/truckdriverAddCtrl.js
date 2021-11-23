'use strict';
app.controller('truckdriverAddCtrl', function($scope, $rootScope,ngDialog, $http, $location, logger,
        utilsService,$state,sharedProperties,$window,validationService,toaster,$stateParams,$filter){

    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.isEdit = false;
    $scope.truckdrivermodel = {
           
       truckName:'',
       truckId:'',
       driverName:'',
       driverId:'',
       trucklicenseNo:'',
       sdriverId:'',
       sdriverName:'',
          fromDate:'',
          toDate:'',
       
        truckdriverId:''
        
        	
     };
    $scope.scheEvntList=[
 	           		    /*{start: "2017-09-09T00:00:00", end: "2017-09-10T18:00:00", id: "1", resource: "1", text: "Event 9",},
 	        		    {start: "2017-09-09T00:00:00", end: "2017-09-12T16:00:00", id: "2", resource: "2", text: "Event 10",},
 	        		    {start: "2017-09-12T00:00:00", end: "2017-09-14T16:00:00", id: "3", resource: "3", text: "Event 11",},*/
 	        		    ];
    
    $scope.$watch('truckdrivermodel.sdriverId', function(newValue, oldValue) {
        if($scope.truckdrivermodel.sdriverId != null && $scope.truckdrivermodel.sdriverId != "" && $scope.truckdrivermodel.sdriverId != undefined){
    if($scope.truckdrivermodel.sdriverId ==  $scope.truckdrivermodel.driverId)
    	{
    	$scope.truckdrivermodel.sdriverId='';
        logger.logError("Already allocated as Primary Driver");

    	}else{
    		/*$scope.getSDriverDtl();*/
    	}
    }else{
    	/*$scope.getSDriverDtl();*/
    }});
/*    $scope.validateDays= function(noofDays) {
        var reg =/^[0-9.]*$/
        if (reg.test(noofDays)) {
            return true;
        } else {
            // logger.logError("Please Enter Valida Email Address");
            return false;
        }
    }*/

    $scope.cancel = function() {
	  	  $state.go('app.truck.truckdriver.list',{tenantid:$stateParams.tenantid});
	  	  
	          
	    };
	    $scope.truckList=[];
	    $scope.gettruckList=function(){
	    	 $http.get($stateParams.tenantid+'/truckdrivermapping/trucklist').success(function(datas) {
	            $scope.truckList = datas.truckList;
	            console.log("truckList");
	           

	        }).error(function(data) {

	        });
	        
	     
	    }
	    
	    $scope.gettruckList();
	    $scope.driverList=[];
	    $scope.getdriverList=function(){
	    	 $http.get($stateParams.tenantid+'/truckdrivermapping/driverlist').success(function(datas) {
	            $scope.driverList = datas.driverList;
	            console.log("driverList");
	            console.log( $scope.driverList);
	           

	        }).error(function(data) {

	        });
	        
	     
	    }
	    $scope.getdriverList();
	    $scope.sdriverList=[];
	    $scope.getsdriverList=function(){
	    	 $http.get($stateParams.tenantid+'/truckdrivermapping/driverlist').success(function(datas) {
	            $scope.sdriverList = datas.driverList;
	            console.log("driverList");
	            console.log( $scope.sdriverList);
	           

	        }).error(function(data) {

	        });
	        
	     
	    }
	    $scope.getsdriverList();
	    
	    $scope.validate = function(truckdriverForm) {
	        if (new validationService().checkFormValidity(truckdriverForm)) {
	            if(!$scope.isEdit){
	                $scope.save(truckdriverForm);
	            }else{
	                $scope.update(truckdriverForm);
	            }
	        } else {
	            toaster.pop('error', "Please fill the required fields",
	                    logger.getErrorHtmlNew(truckdriverForm.$validationSummary),5000, 'trustedHtml');
	        }
	    };

	    $scope.save = function(truckdriverForm) {
	        sharedProperties.clearObject();
            console.log( truckdriverForm);

 
            var frmDate = $scope.truckdrivermodel.fromDate;
	             var toDate = $scope.truckdrivermodel.toDate;
	             frmDate = frmDate.split("/");
	             frmDate = new Date(frmDate[2], frmDate[1]-1, frmDate[0]);
	             toDate = toDate.split("/");
	             toDate = new Date(toDate[2], toDate[1]-1, toDate[0]);
	             
	             if(frmDate>toDate){
	                 logger.logError(" Valid To Date should be greater than or Equal to Valid From Date");
	                 $scope.truckdrivermodel.toDate='';
	             }
	         
	             else{
	       	 $http.post($stateParams.tenantid+'/truckdrivermapping/save',$scope.truckdrivermodel)
	            .success(function(response) {
	        	  
	               if(response == 1){
	      	            
	      	             
	            	   
	            	   
	                   logger.logSuccess("Saved Succesfully!");
	                
		         	  	  $state.go('app.truck.truckdriver.list',{tenantid:$stateParams.tenantid});
	      	             
	                   }else{
		            	   logger.logError("Truck and Driver already allocated on Same Date")
	               
	            }
	            
	      
	    });}}
	    $scope.update = function(truckdriverForm) {
	        sharedProperties.clearObject();
	        var frmDate = $scope.truckdrivermodel.fromDate;
	             var toDate = $scope.truckdrivermodel.toDate;
	             frmDate = frmDate.split("/");
	             frmDate = new Date(frmDate[2], frmDate[1]-1, frmDate[0]);
	             toDate = toDate.split("/");
	             toDate = new Date(toDate[2], toDate[1]-1, toDate[0]);
	             if(frmDate>toDate){
	                 logger.logError(" Valid To Date should be greater than or Equal to Valid From Date");
	                 $scope.truckdrivermodel.toDate='';
	             }
	         
	             else{
	             
	      	 $http.post($stateParams.tenantid+'/truckdrivermapping/update',$scope.truckdrivermodel)
	            .success(function(response) {
	          		 console.log(response);
	          		if(response == 1){
	      	            
	            	   
	            	   
	                   logger.logSuccess("Updated Successfully!");
	                
		         	  	  $state.go('app.truck.truckdriver.list',{tenantid:$stateParams.tenantid});
	      	             
	                   }else{
		            	   logger.logError("Truck and Driver already allocated on Same Date")
	               
	            }
	              
	            });}}
	        
	   
	  

	var editid = $location.search().rowid;
	    
	    var test = parseInt(editid);
	    if(test){
	    $scope.isEdit=true;
	    $http.post($stateParams.tenantid+'/truckdrivermapping/edit',test).success(function(result) {
	    	
	    		
	    	console.log(result);
	    	$scope.truckdrivermodel = result;

	    	$scope.truckdrivermodel.truckId = result.truckId.toString();

	    	
	    	
	    });
	}
	  $scope.reset = function(truckdriverForm) {
	        
	        if($scope.isEdit == true){
	            var truckdriverId =  $scope.truckdrivermodel.truckdriverId;
	            $scope.truckdrivermodel.truckName ='';
	       	 $scope.truckdrivermodel.truckId ='';
	       	 $scope.truckdrivermodel.fromDate ='';
	       	 $scope.truckdrivermodel.driverId ='';
	       	 $scope.truckdrivermodel.driverName ='';
	       	 $scope.truckdrivermodel.toDate ='';



	       	 $http.post($stateParams.tenantid+'/truckdrivermapping/edit',test).success(function(result) {
	 	    	
		    		
	 	    	console.log(result);
	 	    	$scope.truckdrivermodel = result;

	 	    	$scope.truckdrivermodel.truckId = result.truckId.toString();

	               
	            });
	        }
	        else{
	        	 $scope.truckdrivermodel.truckName ='';
	        	 $scope.truckdrivermodel.truckId ='';
	        	 $scope.truckdrivermodel.fromDate ='';
	        	 $scope.truckdrivermodel.toDate ='';
	        	 $scope.truckdrivermodel.driverId ='';
	        	 $scope.truckdrivermodel.driverName ='';
	        	 $scope.truckdrivermodel.truckdriverId ='';
	        	 
	        	 $rootScope.evtList=[];
	        	 $scope.showShdBtn=false;
	        	  $rootScope.$emit("hideScheduler", {});
	        	 
	        }
	        
	  }
	  
	  $scope.trukDtl={
				 truckId:$scope.truckdrivermodel.truckId,
				 driverId:$scope.truckdrivermodel.driverId,
				 sdriverId:$scope.truckdrivermodel.sdriverId,
				 trkDrvMapId:$scope.truckdrivermodel.trkDrvMapId,
				 driverName:$scope.truckdrivermodel.driverName,
				 sdriverName:$scope.truckdrivermodel.sdriverName,
				 truckName:$scope.truckdrivermodel.truckName
		 }
	  
	 
	 /* $scope.getTruckNameById=function(){
		  var value1 = $scope.truckList;
		  angular.forEach(value1, function(value, key) {
			  if(value.id == $scope.trukDtl.truckId){
				  $scope.trukDtl.truckName=value.text;
			  }
			});
	  }
	  $scope.getDriverNameById=function(){
		  var value2 = $scope.driverList;
		  angular.forEach(value2, function(value, key) {
			  if(value.id == $scope.trukDtl.driverId){
				  $scope.trukDtl.driverName=value.text;
			  }
			});
	  }
	  $scope.getsDriverNameById=function(){
		  var value3 = $scope.driverList;
		  angular.forEach(value3, function(value, key) {
			  if(value.id == $scope.trukDtl.sdriverId){
				  $scope.trukDtl.sdriverName=value.text;
			  }
			});
	  }
	  $scope.$watch('truckdrivermodel.fromDate', function(newValue, oldValue) {
		  
		  var d = $filter('date')($scope.truckdrivermodel.fromDate, "yyyy-mm-dd")
			var a = $scope.truckdrivermodel.fromDate;
		    var x = a.split('/')
		    var d=x[1]+'/'+x[0]+'/'+x[2];
		    $rootScope.goToDate=d;
		    //if( $rootScope.evtList.length > 0){
		    	$rootScope.$emit("goToSelectedDate",{});
		    //}
		    
		  $('#schedularMapcalendar').fullCalendar('gotoDate',d);
	  });*/
	  $scope.monthSchedule=[];
	  $scope.monthScheduleTemp=[];
	  $scope.monthSchedule1=[];
	  $rootScope.evtList=[];
	  $scope.evtListTemp=[];
      $scope.trEvt=[];
      $scope.trRes=[];
      $scope.showShdBtn=false;
	  /*$scope.$watch('truckdrivermodel.truckId', function(newValue, oldValue) {
		  $scope.trukDtl.truckId=$scope.truckdrivermodel.truckId;
		  $scope.getTruckNameById();
		  if($scope.truckdrivermodel.truckId !='' && $scope.truckdrivermodel.truckId != undefined){
			  $http.post($stateParams.tenantid+'/truckdrivermapping/selectedTruckList',$scope.trukDtl).success(function(datas) {
		           
		            $scope.loadScheCalValues(datas,'1');
		            
		            if($rootScope.evtList.length > 0){
		            	var monSch =$rootScope.evtList;
		            	var count=0;
		            	$scope.evtListTemp=[];
		            	angular.forEach(monSch, function(value, key) {
		            		$scope.evtTemp=[];
		            		if(value.id !='1'){
		            			$scope.evtTemp.id=value.id;
		            			$scope.evtTemp.name=value.name;
		            			$scope.evtListTemp.push($scope.evtTemp);
		            		}else{
		            			count=1;
		            			$scope.evtTemp=[];
				            	$scope.evtTemp.id=$scope.monthScheduleTemp[0].id;
		            			$scope.evtTemp.name=$scope.monthScheduleTemp[0].truck;
		            			$scope.evtListTemp.push($scope.evtTemp);
		            		}
		            	})
		            	if(count==0){
		            		$scope.evtTemp=[];
		            		$scope.evtTemp.id=$scope.monthScheduleTemp[0].id;
	            			$scope.evtTemp.name=$scope.monthScheduleTemp[0].truck;
	            			$scope.evtListTemp.push($scope.evtTemp);
		            	}
		            }else{
		            	$scope.evtListTemp.push($scope.trEvt);
		            }
		            
		            $rootScope.evtList=$scope.evtListTemp;
		            
		            
		           
		        }).error(function(data) {

		        });  
		  }else{
			  if($scope.truckdrivermodel.truckId !='' || $scope.truckdrivermodel.truckId != undefined){
				  $scope.loadEmptyValues('1');
			  }
		  }
		  
	  });
	  
	  $scope.$watch('truckdrivermodel.driverId', function(newValue, oldValue) {
		  $scope.trukDtl.driverId=$scope.truckdrivermodel.driverId;
		  $scope.getDriverNameById();
		  if($scope.truckdrivermodel.driverId !='' && $scope.truckdrivermodel.driverId != undefined){
			  $http.post($stateParams.tenantid+'/truckdrivermapping/selectedPrmDrvList',$scope.trukDtl).success(function(datas) {
				  $scope.loadScheCalValues(datas,'2')
		        }).error(function(data) {

		        });  
		  }else{
			  	if($scope.truckdrivermodel.driverId !='' || $scope.truckdrivermodel.driverId != undefined){
			  		 $scope.loadEmptyValues('2');
			  	}
		  }
		  
	  });
	  */
	  /*$scope.getSDriverDtl = function() {
		  $scope.trukDtl.sdriverId=$scope.truckdrivermodel.sdriverId;
		  $scope.getsDriverNameById();
		  if($scope.truckdrivermodel.sdriverId !='' && $scope.truckdrivermodel.sdriverId != undefined){
			  $http.post($stateParams.tenantid+'/truckdrivermapping/selectedSecDrvList',$scope.trukDtl).success(function(datas) {
				  $scope.loadScheCalValues(datas,'3')
		        }).error(function(data) {

		        });  
		  }else{
			  if($scope.truckdrivermodel.sdriverId !='' || $scope.truckdrivermodel.sdriverId != undefined){
				  $scope.loadEmptyValues('3');
			  }
		  }
		  
	  };*/
	  
	  
	  /*$scope.loadScheCalValues=function(datas,num){
          $scope.monthScheduleTemp =[];
          $scope.monthScheduleTemp =datas;
          $scope.trEvt={
          		id:$scope.monthScheduleTemp[0].id,
          		name:$scope.monthScheduleTemp[0].truck,
          }
          
          $scope.trRes=[]
          if($scope.monthScheduleTemp.length > 0){
          	
          	if($rootScope.evtList.length > 0){
          		var monSch1 =$rootScope.evtList;
          		$scope.evtListTemp=[];
	            	angular.forEach(monSch1, function(value, key) {
	            		$scope.trRes=[];
	            		if(value.id !=num && value.start != ''){
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
          		$scope.trRes.text=value.title,
          		$scope.trRes.resource=value.id,
          		$scope.trRes.start=value.start.length > 0 ?  value.start+"T00:00:00" : "",
				    $scope.trRes.end=value.end.length > 0 ?  value.end+"T12:50:00" : "",
          		$scope.trRes.pdriver=value.pdriver,
          		$scope.trRes.sdriver=value.sdriver;
				    var fD = $filter('date')(value.start, "dd-MM-y");
	  		    	var tD = $filter('date')(value.end, "dd-MM-y");
	  		    	$scope.trRes.moveDisabled=true;
	  		    	$scope.trRes.resizeDisabled=true;
	  		    	$scope.trRes.bubbleHtml='<div style="background-color: #46bde2;border:2px solid #181818;padding:3px;">'+'<span style="color:#011954">'+'Truck '+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+': '+'</span>'+'<span style="color:#fff">'+value.mtitle+'</span>'+'<br/>'+'<span style="color:#011954">'+'Prm. Driver : '+'</span>'+'<span style="color:#fff">'+value.pDriver+'</span>'+'<br/>'+'<span style="color:#011954">'+'Sec. Driver '+'&nbsp;'+': '+'</span>'+'<span style="color:#fff">'+value.sDriver+'</span>'+'<br/>'+'<span style="color:#011954">'+'Start '+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+': '+'</span>'+'<span style="color:#fff">'+fD+'</span>'+'<br/>'+'<span style="color:#011954">'+'End '+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+' : '+'</span>'+'<span style="color:#fff">'+tD+'</span>'+'</div>';
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
	  }*/
	  
	  /*$scope.loadEmptyValues=function(num){
		  
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





/*var trkDrivrapp = angular.module('main', ['daypilot']);
	
	'use strict';
	trkDrivrapp.controller('DemoCtrl', function($scope, $rootScope,ngDialog, $http, $location, logger,
	        utilsService,$state,sharedProperties,$window,validationService,toaster,$stateParams,$filter){
	
		$scope.showShedr=false;
		
		
		
		 $scope.scheEvntList=[];
		
		
		$rootScope.$on("CallSchLoadMethod", function(){
	        $scope.loadCurrMonDate();
	     });
		$rootScope.$on("goToSelectedDate", function(){
	        var d= $rootScope.goToDate;
	        var x = d.split('/')
	        var da=new Date(x[2],x[0]-1,x[1])
	        $scope.loadGoToDate(da);
	        
	     });
		
		$rootScope.$on("hideScheduler", function(){
			 $scope.showShedr=false;
		})
		
	     $scope.childMethod = function(date,days) {
	    	 $scope.showShedr=true;
	    	 $scope.scheEvntList= $rootScope.sch;
	    	 $scope.loadScheduleCal(date,days);
	    	 var date = new Date();
    		 var d = $filter('date')(new Date(date.getFullYear(), date.getMonth() + 1, 1), "yyyy-mm-dd")
	    	 $scope.scrollTo(d);
	     }
		
	$scope.loadScheduleCal = function(date,days){
		  $scope.evtLt=[]
		  $scope.evtLt =$rootScope.evtList;
    $scope.config = {
        scale: "Day",
        days: days,
        bubble: new DayPilot.Bubble(),
        startDate: new Date(date.getFullYear(), date.getMonth(), 2),
        
        
        timeHeaders: [
            { groupBy: "Month" },
		    { groupBy: "Cell", format: "d" }
        ],
        resources:[
        { name: "Truck", id: "1" },
        { name: "Primary Driver", id: "2" },
        { name: "Secondary Driver", id: "3" }],

       
        rowMinHeight:50,
        rowMinWidth:50,
        headerHeight:40,
        durationBarVisible:false,
        durationBarColor:"red",
        barBackColor:"red",
        cellWidthSpec:'Auto',
        
        
    };
    $scope.events=[];
    $http.post($stateParams.tenantid+'/truckSchedule/updateValue').success(function(data) {
		if(data.success = true){
			 $scope.events = $scope.evtLt;
		}
	});
    
    $scope.add = function() {
        $scope.events.push(
            {
                start: new DayPilot.Date("2017-09-05T00:00:00"),
                end: new DayPilot.Date("2017-09-06T00:00:00"),
                id: DayPilot.guid(),
                resource: "B",
                text: "One-Day Event",
                bubbleHtml: "Details"
            }
        );
    };

    $scope.move = function() {
        var event = $scope.events[0];
        event.start = event.start.addDays(1);
        event.end = event.end.addDays(1);
    };

    $scope.rename = function() {
        $scope.events[0].text = "New name";
    };

    

    $scope.scale = function(val) {
        $scope.config.scale = val;
    };
    
    
    
	} 
	
	$scope.scrollTo = function(date) {
        $scope.dp.scrollTo(date);
    };
    
    $scope.loadCurrMonDate=function(){
    	var date;
    	var sp = $rootScope.goToDate.split('/');
    	if(sp[1].length > 0){
    		var d= $rootScope.goToDate;
            var x = d.split('/')
            date=new Date(x[2],x[0]-1,x[1]);
    	}else{
    		 date = new Date();
    	}
    	
    	
	 
	  $scope.CurrDt=date;
	  var firstDay = new Date(date.getFullYear(), date.getMonth(), 1);
	  var lastDay = new Date(date.getFullYear(), date.getMonth() + 1, 0);
	  var diff = new Date(lastDay - firstDay);
	  var days = diff/1000/60/60/24;
	  days=days+1;
	  $scope.childMethod(date,days);
    }
    
    $scope.loadGoToDate=function(date){
    	if(date.getFullYear() >0){
    		$scope.CurrDt=date;
    	  	  var firstDay = new Date(date.getFullYear(), date.getMonth(), 1);
    	  	  var lastDay = new Date(date.getFullYear(), date.getMonth() + 1, 0);
    	  	  var diff = new Date(lastDay - firstDay);
    	  	  var days = diff/1000/60/60/24;
    	  	  days=days+1;
    	  	  $scope.childMethod(date,days);
    	}
      }
    
    $scope.gotoNextYear=function(){
    	 var d= $scope.CurrDt;
    	 var m;
    	 var y;
    	 var dys;
    	 if(d.getMonth() == 11){
    		 m=0;
    		 y=d.getFullYear()+1
    	  }else{
    	     m=d.getMonth()+1;
    	     y=d.getFullYear()
    	  }
      var firstDay = new Date(y, m, 1);
   	  var lastDay = new Date(y, m+1, 0);
   	  var diff = new Date(lastDay - firstDay);
   	   dys = diff/1000/60/60/24;
   	   dys=dys+1;
   	  $scope.CurrDt = new Date(y,m,1)
   	  var date = $scope.CurrDt;
      $scope.childMethod(date,dys);
    	
    }
    
    $scope.gotoPrevYear=function(){var d= $scope.CurrDt;
	 var m;
	 var y;
	 var dys;
	 if(d.getMonth() == 11){
		 m=10;
		 y=d.getFullYear()
	  }else{
	     m=d.getMonth()-1;
	     y=d.getFullYear()
	  }
  var firstDay = new Date(y, m, 1);
	  var lastDay = new Date(y, m+1, 0);
	  var diff = new Date(lastDay - firstDay);
	   dys = diff/1000/60/60/24;
	   dys=dys+1;
	  $scope.CurrDt = new Date(y,m,1)
	  var date = $scope.CurrDt;
  $scope.childMethod(date,dys);}
	

});*/







