'use strict';

app.controller('transassignListCtrl', function($scope,$filter, $modal, $rootScope, $http, $location, logger, utilsService, ngDialog,
		$injector,validationService, $timeout,$state,sharedProperties,$window,$stateParams,toaster,$controller) {
	
    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.portList=[];
    $scope.vesselList= [];
    $scope.voyageList= [];
    
    $scope.transAssign={
    		pot:'',
    		fpod:'', 
    		vessel:'',
    		voyage:'',
    		leg:'',
    		select :false,
    			containerDtl : []
    	
    }
    
    
    $scope.routing ={
    		xVoyage:'',
			xPol:'',
			xPod:'',
			xFpod:'',
			destination:'',
    		pol:'',
    		pod:'',
    		vesselRouting:'',
    		voyageRouting:'',
    		eta:''
    
    		
    };
   $scope.poplist = {
			vessel : '',
			voyage : '',
			containerNo : '',
			dishcargePort : '',
			blNo : '',
			bookingNum:'',
			customer:'',
			select1 : false,
			
	
		
	};
  $http.get($stateParams.tenantid+'/app/transassign/bookinglist').success(function(datas) {
      console.log(datas);
      $scope.booking = datas.bookingList;
      
      for(var i =0;datas.bookingList.length;i++){
        	           
          if(datas.bookingList[i].eta != null){
              var dateSplitted = datas.bookingList[i].eta.split(" ");
              var dateSplitted1 = dateSplitted[0].split("/").reverse().join("/");
              var  ms = Date.parse(dateSplitted1);
              console.log(dateSplitted +" : " +ms)
              datas.bookingList[i].eta1=ms; } 
}

      }).error(function(datas) {
  });
  
  
  $http.get($stateParams.tenantid+'/app/transassign/icdPendingList').success(function(datas) {
      console.log(datas);
      $scope.icdPendingList = datas.icdPendingList;

      }).error(function(datas) {
  });
  
  
  $scope.viewBookinghyp = function(bookingNo,croStatus ) {
      $window.open('/#/cordelia/booking/view?bookingNo='+bookingNo+'&croStatus='+croStatus);

		//$location.url($stateParams.tenantid+'/booking/view?bookingNo='+bookingNo+'&croStatus='+croStatus);
	}
  
  
  $scope.assign = function(value){
  	$rootScope.value = value;
  //	$rootScope.blno = blno;
  	$rootScope.routing =value;
  	$scope.exvoyvessel =value;
  	$scope.callQCDialog($scope,$http, ngDialog, logger,$injector, sharedProperties,$stateParams, toaster,$rootScope);
  	};
  	
  	
  	$scope.callQCDialog = function($scope,$http, ngDialog, logger,$injector, sharedProperties,$stateParams, toaster,$rootScope){
  		ngDialog.open({
  		scope: $scope,
  		template: '/views/operation/transassign/DashboardPop',
  		controller: $controller('poPopupCtrl', {
  		$scope: $scope,
  		$http:$http,
  		ngDialog:ngDialog,
  		logger:logger,
  		$injector:$injector,
  		sharedProperties:sharedProperties,
  		toaster:toaster,
  		$rootScope:$rootScope,
  		value:$scope.exvoyvessel
  		}),
  		className: 'ngdialog-theme-plain',
  		showClose: false,
  		closeByDocument: false,
  		closeByEscape: false,
  		preCloseCallback : $scope.getList
  		});

  		}

  $scope.noCnfrm = function() {
		ngDialog.close();
	}
  
  
    
    $scope.getDropDownList=function(){
        $http.get($stateParams.tenantid+'/app/commonUtility/getPort').success(function(datas) {
            console.log(datas);
            $scope.portList = datas.lCommonUtilityBean;
        	
            }).error(function(datas) {
        });
        };
        $scope.getDropDownList();
         
   	  $scope.selectall= function(selection){
        	angular.forEach($scope.transAssign.containerDtl,function(value,key) {
        		debugger;
        		if( selection)
        		value.select=true;
        		else{
        			value.select=false;
        		}
        	});
        }

   	$scope.$watch('transAssign.vessel',function(newValue, oldValue) {
   		if(newValue!=null && newValue!=undefined && newValue!=""){
   			var obj ={
   					pot : $scope.transAssign.pot ,
   					fpod : $scope.transAssign.fpod ,
   					vessel : newValue 
   			}
   	        $http.post($stateParams.tenantid+'/app/transassign/getVoyageList',obj).success(function(data) {
   	        	if(data.success){
   	        		$scope.voyageList=data.voyageList;
   	        	}else{
   	        		logger.logError("Unable to fetch data");
   	        	}
   	        });
   		}
   	});
    
   	
   	$scope.assignInterModel = function(value){
   	  	$rootScope.value = value;
    	$rootScope.routing =value;
   	  	$scope.exvoyvessel =value;
   	  	$scope.callQCDialogICD($scope,$http, ngDialog, logger,$injector, sharedProperties,$stateParams, toaster,$rootScope);
   	  	};
   	  	
   	  	
   	  	$scope.callQCDialogICD = function($scope,$http, ngDialog, logger,$injector, sharedProperties,$stateParams, toaster,$rootScope){
   	  		ngDialog.open({
   	  		scope: $scope,
   	  		template: '/views/IcdAssignPopup',
   	  		controller: $controller('ICDPopUpCtrl', {
   	  		$scope: $scope,
   	  		$http:$http,
   	  		ngDialog:ngDialog,
   	  		logger:logger,
   	  		$injector:$injector,
   	  		sharedProperties:sharedProperties,
   	  		toaster:toaster,
   	  		$rootScope:$rootScope,
   	  		value:$scope.exvoyvessel
   	  		}),
   	  		className: 'ngdialog-theme-plain',
   	  		showClose: false,
   	  		closeByDocument: false,
   	  		closeByEscape: false,
   	  		preCloseCallback : $scope.getList
   	  		});

   	  		}
   	
   	$scope.Assign = function( transAssign) {
   		/*var msg=$scope.checkValidation();
		if(!$scope.checkundefined(msg)){   
			logger.logError(msg);
		}else{*/
   	        $http.post($stateParams.tenantid+'/app/transassign/assign',transAssign).success(function(data) {
   	            console.log("data" + data);
   	            if (data.success) {
   	                logger.logSuccess("Assigned successfully!");
   	            } else {
   	                logger.logError("Error in Assign");
   	            }
   	        }).error(function(result) {
   	            console.log("data" + data.message);
   	        });
   		//}  
   	 };
   	 
   	 
   	$scope.showAssign = function(bookingno) {
 		$location.url($stateParams.tenantid + '/operation/transAssign/assign?rowId='+ bookingno);
 	}
   	
   	$scope.assignedList = function(bookingno) {
 		$location.url($stateParams.tenantid + '/operation/transAssign/assignedListToRollOver');
 	}
   	 
	$scope.tsAssignListPage = function() {
 		$location.url($stateParams.tenantid + '/operation/transAssign/TSAssignedList');
 	}
	
    var rowId = $location.search().rowId;
	  if(rowId != null){
		  $scope.isEdit=true;
	      
		  $http.post($stateParams.tenantid+'/app/transassign/view?rowId=' +rowId).success(function(result) {
	          if (result.isEdit == false) {
	              logger.logError("Please Try Again");
	          } else {
	              console.log("result***************for viewwwwwwwwwwwwwwwwww*******");
	              console.log(result);
	              $scope.vesselArrival = result;
	              $scope.rowCollection = result.detailList;
	          }
	         }).error(function(data) {

	         });
	  }
 
   	$scope.checkValidation = function() {
	    var alertmsg = "<ui><h4 backgroundcolor=green>Please fill the required fields</h4>";
	    var msg = "";
	    if ($scope.checkundefined($scope.transAssign.pot)) {
	        msg = msg + "<li>Pot :Field is required.</li>";         
	        $scope.changecolor('pot');
	    }else{
	    	$scope.clearcolor('pot');
	    }
	    if ($scope.checkundefined($scope.transAssign.fpod)) {
	        msg = msg + "<li>fpod :Field is required.</li>";         
	        $scope.changecolor('fpod');
	    }else{
	    	$scope.clearcolor('fpod');
	    }
	    if ($scope.checkundefined($scope.transAssign.vessel)) {
	        msg = msg + "<li>vessel :Field is required.</li>";         
	        $scope.changecolor('vessel');
	    }else{
	    	$scope.clearcolor('vessel');
	    }
	    if ($scope.checkundefined($scope.transAssign.voyage)) {
	        msg = msg + "<li>voyage :Field is required.</li>";         
	        $scope.changecolor('voyage');
	    }else{
	    	$scope.clearcolor('voyage');
	    }
	  
	  var selectCheck = false;
	  	    angular.forEach($scope.transAssign.containerDtl, function(detail, index) {     
 
	        if (detail.select == true) {
	        	selectCheck = true;
	        }
	    });
	  	    
	  	  if (selectCheck == false) {
		        msg = msg + "<li>Please Select records</li>";         
		    }
	  	  
	    alertmsg = alertmsg + msg + "</ui>";
	    if ($scope.checkundefined(msg)) {
	        return '';
	    } else {
	        return alertmsg;
	    }

	}
   	
   	
   	
    $scope.checkundefined = function(value) {
	    var invalid = false;
	    if (value == undefined || value == 'undefined' || value == null || value == 'null' || value == '') {
	        invalid = true;
	    }
	    return invalid;

	}

	$scope.changecolor = function(id) {
		$('#' + id + ' .selectivityId').find('input').css( "border-color", "red");
	}

	$scope.changecolor = function(id) {
		$('#' + id + ' .selectivityId').find('input').css( "border-color", "red");
	}
	$scope.clearcolor = function(id) {
		$('#' + id + ' .selectivityId').find('input').css( "border-color", "#e8dddd");
	}
});


app.controller('transAssignAddCtrl', function($scope, $rootScope, $http, $location, logger, utilsService, ngDialog, validationService, $state,sharedProperties,$window,$stateParams) {

    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.portList=[];
    $scope.vesselList= [];
    $scope.voyageList= [];
    $scope.transAssign={
    		pot:'',
    		fpod:'', 
    		vessel:'',
    		voyage:'',
    		leg:'',
    		select :false,
    			containerDtl : [],
    			transAssignBeanList:[]
    	
    }
 
   	$scope.$watch('transAssign.vessel',function(newValue, oldValue) {
   		if(newValue!=null && newValue!=undefined && newValue!=""){
   			var obj ={
   					pot : $scope.transAssign.pot ,
   					fpod : $scope.transAssign.fpod ,
   					vessel : newValue 
   			}
   	        $http.post($stateParams.tenantid+'/app/transassign/getVoyageList',obj).success(function(data) {
   	        	if(data.success){
   	        		$scope.voyageList=data.voyageList;
   	        	}else{
   	        		logger.logError("Unable to fetch data");
   	        	}
   	        });
   		}
   	});
    
   	
   	$scope.Assign = function( transAssign) {
   		/*var msg=$scope.checkValidation();
		if(!$scope.checkundefined(msg)){   
			logger.logError(msg);
		}else{*/
   		debugger;
   		console.log($scope.transAssign);
   	        $http.post($stateParams.tenantid+'/app/transassign/assign',$scope.transAssign).success(function(data) {
   	            console.log("data" + data);
   	            if (data.success) {
   	             $state.go('app.operation.tsassign.list');
   	                logger.logSuccess("Assigned successfully!");
   	            } else {
   	                logger.logError("Error in Assign");
   	            }
   	        }).error(function(result) {
   	            console.log("data" + data.message);
   	        });
   		//}  
   	 };
   	 
   	 $scope.cancel=function(){
   	   $state.go('app.operation.transassign.list');
   	 }
   	 
   	 
    var rowId = $location.search().rowId;
	  if(rowId != null){
		  $scope.isEdit=true;
	      
		  $http.post($stateParams.tenantid+'/app/transassign/view?rowId=' +rowId).success(function(result) {
	          if (result.success == false) {
	              logger.logError("Please Try Again");
	          } else {
	              console.log("result***************for viewwwwwwwwwwwwwwwwww*******");
	        
	              
	              console.log(result);
	              $scope.transAssign.transAssignBeanList = result.transAssignBeanList;
	          }
	         }).error(function(data) {

	         });
	  }
	  
	  
  
});


app.controller('poPopupCtrl', function($scope, $state, $http, $location, sharedProperties,toaster,
		$injector,logger,ngDialog,$rootScope,$controller,$stateParams ,value) {
			$scope.rowCollection3 = [];
			$scope.poplist=[];
			
			 $scope.newvalue = value;
			 
			 
			$scope.routing ={
		    		xVoyage:'',
					xPol:'',
					xPod:'',
					xFpod:'',
					destination:'',
		    		pol:'',
		    		pod:'',
		    		vesselRouting:'',
		    		voyageRouting:'',
		    		eta:'',
		    		blNo:'',
		    		etasailDate:'',
		    		port:'',
		    		fromPort: '',
		    		tsPot:'',
		    		etdAtPot:'',
		    		vesselService:'',
		    		dfFlag:'',
		    		
		    };
		   $scope.poplist = [{
					vessel : '',
					voyage : '',
					containerNo : '',
					dishcargePort : '',
					blNo : '',
					bookingNum:'',
					customer:'',
					blNo:'',
					etasailDate:'',
		    		port:'',
					select1 : false,
					
					
			
				
			}];
		   
		  // $scope.tempCntrList =[];
		   
		   
		   
		   $scope.routing.vesselRouting = value.vesselRouting;
			$scope.routing.voyageRouting = value.voyageRouting;
			$scope.routing.fromPort = value.fromPort;
			$scope.routing.destination = value.destination;

			
			$http.get($stateParams.tenantid+ '/app/commonUtility/getVesselList').success(function(data) {
				$scope.vesselList = data;
			});
		  

			
			
			
			 $scope.$watchCollection('[routing.voyageRouting,routing.fromPort,routing.vessel]', function(newValue, oldValue) {
				 if($scope.routing.voyageRouting != null && $scope.routing.voyageRouting != '' && $scope.routing.voyageRouting != undefined 
					        && $scope.routing.fromPort != null && $scope.routing.fromPort != '' && $scope.routing.fromPort != undefined
					        && $scope.routing.vessel != null && $scope.routing.vessel != '' && $scope.routing.vessel != undefined
					      
				
				 ){
					 
					 $http.post($stateParams.tenantid+ '/app/transassign/getVoyagebasedExpot?exvoyage='+$scope.routing.voyageRouting+'&expot='+$scope.routing.fromPort+'&vessel='+$scope.routing.vessel).success(function(data) {
							$scope.voyageList = data;

			    	  });
					 
				 }
			 });
			 
			 
			 $scope.$watchCollection('[routing.vessel,routing.voyage]', function(newValue, oldValue) {
				 if($scope.routing.vessel != null && $scope.routing.vessel != '' && $scope.routing.vessel != undefined 
					        && $scope.routing.voyage != null && $scope.routing.voyage != '' && $scope.routing.voyage != undefined
					      
				
				 ){
					 
					  $http.post($stateParams.tenantid+ '/app/booking/getVesselService?vessel='+$scope.routing.vessel+'&voyage='+$scope.routing.voyage).success(function(data) {
					  $scope.routing.vesselService	 = data.vesselService;
			    	  });
					  
					  
					  $http.post($stateParams.tenantid+ '/app/booking/getVesselServiceDf?vessel='+$scope.routing.vessel+'&voyage='+$scope.routing.voyage).success(function(data) {
					  $scope.routing.dfFlag	 = data.dfFlag;
				    	  });
					 
				 }
			 });
			
			
			 
			 
			 $scope.$watch('routing.voyage', function(newValue, oldValue) {
			      if(newValue!=null && newValue!=undefined && newValue != ''){
			  
			    	   $http.post($stateParams.tenantid+ '/app/commonUtility/getPortListByVoyage',newValue).success(function(data) {
				    		  $scope.portTSList = data;
				    	  })
		    	 
			    	  
			    	 
			      }
			})
			
			
			/// POT
			 $scope.$watchCollection('[routing.voyage,routing.tsPot]', function(newValue, oldValue) {
						 if($scope.routing.voyage != null && $scope.routing.voyage != '' && $scope.routing.voyage != undefined 
							        && $scope.routing.tsPot != null && $scope.routing.tsPot != '' && $scope.routing.tsPot != undefined
							      
						
						 ){
							 
							 $http.post($stateParams.tenantid+ '/app/booking/getSailing?voyage='+$scope.routing.voyage+'&pol='+$scope.routing.tsPot).success(function(data) {
								 $scope.routing.etdAtPot	 = data.etdsailDate;
							
								
					    	  });
							 
						 }
					 });
			
			 
			 //// NEXT PORT
			 $scope.$watchCollection('[routing.voyage,routing.port]', function(newValue, oldValue) {
						 if($scope.routing.voyage != null && $scope.routing.voyage != '' && $scope.routing.voyage != undefined 
							        && $scope.routing.port != null && $scope.routing.port != '' && $scope.routing.port != undefined
							      
						
						 ){
							 
							 $http.post($stateParams.tenantid+ '/app/booking/getSailing?voyage='+$scope.routing.voyage+'&pol='+$scope.routing.port).success(function(data) {
								 $scope.routing.etasailDate	 = data.etasailDate;
							
								
					    	  });
							 
						 }
					 });
			 
			 
			 $scope.$watch('routing.port', function(newValue, oldValue) {
			      if(newValue!=null && newValue!=undefined && newValue != ''){
			    	  
			    		var str = $scope.routing.port;
						var res = [] ;
						var port;
						var portSeq;
						res = str.split("-");
						port = res[0];
						portSeq=[1];
		    	 
			    	  if($scope.routing.fromPort == port){
			    		  logger.logError('Same POT Should be selected..Please select the next To Port');
			    		  $scope.routing.port ='';
			    		  $scope.routing.etasailDate ="";
			    	  }
			    	 
			      }
			})
			
			 $scope.$watchCollection('[routing.tsPot,routing.port]', function(newValue, oldValue) {
			 if($scope.routing.tsPot != null && $scope.routing.tsPot != '' && $scope.routing.tsPot != undefined 
				        && $scope.routing.port != null && $scope.routing.port != '' && $scope.routing.port != undefined
				   ){
				 
					

				  var str = $scope.routing.tsPot;
					 var res = [] ;
					 var pot;
					 var potseq;
					 res = str.split("-");
					 pot = res[0];
					 potseq=res[1];
					 
					 
					 
					  var str = $scope.routing.port;
						 var res = [] ;
						 var fpod;
						 var fpodseq;
						 res = str.split("-");
						 fpod = res[0];
						 fpodseq=res[1];
				 
					 if(Number(potseq) >=Number(fpodseq)){
					 logger.logError('Next Port Sequence should be greater than POT Sequence!');
					 $scope.routing.tsPot ='';
					 $scope.routing.port ='';
					 
					  
				 } 
				 
			 }
		 });
			 $scope.$watchCollection('[routing.tsPot,routing.port]', function(newValue, oldValue) {
				 if($scope.routing.tsPot != null && $scope.routing.tsPot != '' && $scope.routing.tsPot != undefined 
					        && $scope.routing.port != null && $scope.routing.port != '' && $scope.routing.port != undefined
					   ){
					  var str = $scope.routing.tsPot;
						 var res = [] ;
						 var pot;
						 var potseq;
						 res = str.split("-");
						 pot = res[0];
						 potseq=res[1];

						  var str = $scope.routing.port;
							 var res = [] ;
							 var fpod;
							 var fpodseq;
							 res = str.split("-");
							 fpod = res[0];
							 fpodseq=res[1];
					 
						 
						 if(pot == fpod){
				    		  logger.logError('POT and Next Port Should not be Same.');
				    		  $scope.routing.tsPot ='';
							  $scope.routing.port ='';
				    	  }
						 
						 
				 }
			 });
			 $scope.selectall= function(selection){
				 	angular.forEach($scope.poplist,function(value,key) {
				 		debugger;
				 		if( selection)
				 		value.select1=true;
				 		else{
				 			value.select1=false;
				 		}
				});
				}
			 
			 
			 
				$scope.DepotFlag = false;

		   var BookingData= $rootScope.routing;
			   debugger;
			   $http.post($stateParams.tenantid+'/app/transassign/routingContainer', BookingData ).success(function(datas) {
			          console.log(datas);
			          if(datas.length > 0){
			    			$scope.DepotFlag = false;

				            $scope.poplist = datas;
				            var i =1;
				            angular.forEach($scope.poplist, function(row, index) {
				            	 $scope.poplist[index].slno = i;
				            	 i++;
					        });
				           $scope.routing.vessel= datas[0].vessel;
				           $scope.routing.voyage=datas[0].voyage;
				           $scope.routing.vesselRouting = $rootScope.routing.vesselRouting;
				           $scope.routing.voyageRouting=$rootScope.routing.voyageRouting;
				    			            	
			          } else {
			    			$scope.DepotFlag = true;

			          }
			      	
			          }).error(function(datas) {
			      });
				
		   
			   $scope.saveData = function() {
					var tmpDelList = [];
					for(var i=$scope.poplist.length-1;i>=0;i--){
						if($scope.poplist[i].select1==true){
							$scope.poplist[i].vessel=$scope.routing.vessel;
							$scope.poplist[i].voyage=$scope.routing.voyage;
							tmpDelList.push($scope.poplist[i]);
						}
					}
					
					
				$scope.selectedList = tmpDelList;
				$rootScope.routing
				$rootScope.routing.vessel= $scope.routing.vessel;
				$rootScope.routing.voyage= $scope.routing.voyage;
				$rootScope.routing.port= $scope.routing.port;
				$rootScope.routing.etasailDate= $scope.routing.etasailDate;
				
				$rootScope.routing.tsPot= $scope.routing.tsPot;
				$rootScope.routing.etdAtPot= $scope.routing.etdAtPot;
				$rootScope.routing.dfFlag= $scope.routing.dfFlag;
				$rootScope.routing.vesselService =$scope.routing.vesselService;
				
				
				var obj ={
					bean:	$rootScope.routing,
					popList:$scope.selectedList
				}
				var test;
				for(var i=0;i<$scope.poplist.length;i++){
		
	    	         var dayDiff = moment($scope.routing.etdAtPot, "DD/MM/YYYY").diff(moment($scope.poplist[i].dischargeDate, "DD/MM/YYYY"),'day')
	    			 
	    	         if ( dayDiff < 0 ) { 
	    		    			if(test == null && test == undefined){
									test = "false";
								}else{
									test = test + "," + "false";
								}
	    			        	logger.logError("Row ("+$scope.poplist[i].slno+")ETD at POT date should be Greater Than the Discharge Date..!! "+$scope.poplist[i].dischargeDate+"");

	    			 }else{
	    				 if(test == null && test == undefined){
								test = "true";
							}else{
								test = test + "," + "true";
							}
	    				 
	    			 } 
				}
				
				var check =  test.split(",").includes("false") ? false : true ;
				console.log(check);
				if(check == false){
				}else{
					
				if ($scope.routing.vessel != null && $scope.routing.vessel !='' ){
					if ($scope.routing.voyage != null && $scope.routing.voyage !=''){
					if ($scope.routing.tsPot != null && $scope.routing.tsPot !='' && $scope.routing.tsPot !=undefined){
					if ($scope.routing.port != null && $scope.routing.port !='' && $scope.routing.port !=undefined){
						
							 
						$http.post($stateParams.tenantid+'/app/dashboard/saveDetail',obj).success(function(data) {
							console.log(data);
					       if(data.isSuccess==true){
					       	 logger.logSuccess("Save Successfully!"); 
 
					         $scope.noCnfrm();
					         $state.reload();
					       }else{
					       	 logger.logError(data.message);
					       }
					   });
						
						
					}else{
						 logger.logError("Please select Next Port");

					}
					}else{
						 logger.logError("Please select POT");
					}
					}
					else{
						 if($scope.routing.voyage ==null || $scope.routing.voyage  =='')
				                logger.logError("Please select Voyage");
			    	}
					
				}
				else{
					 if($scope.routing.vessel ==null || $scope.routing.vessel  =='')
			               logger.logError("Please select Vessel");
				}
				
			   }
			};
		

			

		});


////////////// ICD shipments Update

app.controller('ICDPopUpCtrl', function($scope, $state, $http, $location, sharedProperties,toaster,
		$injector,logger,ngDialog,$rootScope,$controller,$stateParams ,value) {
			$scope.rowCollection3 = [];
			$scope.poplist=[];
			
			 $scope.newvalue = value;
			 
			 
			$scope.routing ={
		    		xVoyage:'',
					xPol:'',
					xPod:'',
					xFpod:'',
					destination:'',
		    		pol:'',
		    		pod:'',
		    		vesselRouting:'',
		    		voyageRouting:'',
		    		eta:'',
		    		blNo:'',
		    		etasailDate:'',
		    		port:'',
		    		fromPort: '',
		    		vechicleType:'',
		    		vechicleNum:'',
		    		tofDate:''
		    		
		    		
		    
		    		
		    };
		   $scope.poplist = [{
					vessel : '',
					voyage : '',
					containerNo : '',
					dishcargePort : '',
					blNo : '',
					bookingNum:'',
					customer:'',
					blNo:'',
					etasailDate:'',
		    		port:'',
					select1 : false,
					
			
				
			}];
		   
		   
		   $scope.vechicleTypeList = [{
				id:'Train',
				text:'Train'
			},{
				id:'Truck',
				text:'Truck'
			}];
		   
		   $scope.routing.vesselRouting = value.vesselRouting;
			$scope.routing.voyageRouting = value.voyageRouting;
			$scope.routing.fromPort = value.fromPort;
			
		   $http.get($stateParams.tenantid+ '/app/commonUtility/getVesselList').success(function(data) {
				$scope.vesselList = data;
			});
		   
 
				$scope.DepotFlag = false;

		   var BookingData= $rootScope.routing;
			   debugger;
			   $http.post($stateParams.tenantid+'/app/dashboard/ICDContainerList', BookingData ).success(function(datas) {
			          console.log(datas);
			          if(datas.length > 0){
			    			$scope.DepotFlag = false;

				            $scope.poplist = datas;
				            var i =1;
				            angular.forEach($scope.poplist, function(row, index) {
				            	 $scope.poplist[index].slno = i;
				            	 i++;
					        });
				         
				           $scope.routing.xPol= datas[0].xPol;
				           $scope.routing.xPod=datas[0].xPod;
				           $scope.routing.xFpod=datas[0].xFpod;
				           $scope.routing.destination=datas[0].destination;
 				           $scope.routing.xVoyage=$rootScope.routing.voyageRouting;
				    			            	
			          } else {
			    			$scope.DepotFlag = true;

			          }
			      	
			          }).error(function(datas) {
			      });
				
		   
			   $scope.saveData = function() {
					var tmpDelList = [];
					for(var i=$scope.poplist.length-1;i>=0;i--){
						if($scope.poplist[i].select1==true){
							tmpDelList.push($scope.poplist[i]);
						}
					}
					
					
				$scope.selectedList = tmpDelList;
				
				$rootScope.routing.xVoyage= $scope.routing.xVoyage;
				$rootScope.routing.xPol= $scope.routing.xPol;
				$rootScope.routing.xPod= $scope.routing.xPod;
 				$rootScope.routing.xFpod= $scope.routing.xFpod;
 				$rootScope.routing.destination= $scope.routing.destination;
				$rootScope.routing.vechicleType= $scope.routing.vechicleType;
				$rootScope.routing.vechicleNum= $scope.routing.vechicleNum;
 				$rootScope.routing.tofDate= $scope.routing.tofDate;
				var obj ={
					bean:	$rootScope.routing,
					popList:$scope.selectedList
				}
				if ($scope.routing.vechicleType != null && $scope.routing.vechicleType !='' ){
					if ($scope.routing.tofDate != null && $scope.routing.tofDate !=''){
						$http.post($stateParams.tenantid+'/app/dashboard/saveICDDetail',obj).success(function(data) {
							console.log(data);
					       if(data.isSuccess==true){
					       	 logger.logSuccess("Save Successfully!"); 
					         $scope.noCnfrm();
					         $state.reload();
					       }else{
					       	 logger.logError(data.message);
					       }
					   });
					}
					else{
						 if($scope.routing.tofDate ==null || $scope.routing.tofDate  =='')
				                logger.logError("Please select the  Transfer Out Date");
			    	}
					
				}
				else{
					 if($scope.routing.vechicleType ==null || $scope.routing.vechicleType  =='')
			               logger.logError("Please select the Vehicle Type");
				}
				
				
			};
		$scope.selectall= function(selection){
		 	angular.forEach($scope.poplist,function(value,key) {
		 		debugger;
		 		if( selection)
		 		value.select1=true;
		 		else{
		 			value.select1=false;
		 		}
		});
		}

			

		});



app.controller('transAssignedCtrl', function($scope, $rootScope, $http, $location, logger, utilsService, ngDialog, validationService, $state,sharedProperties,$window,$stateParams) {

    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.portList=[];
    $scope.vesselList= [];
    $scope.voyageList= [];
    $scope.newVesselList= [];
    $scope.newVoyageList= [];
    $scope.transAssign={
    		pol:'',
    		pod:'',
    		pot:'',
    		fpod:'', 
    		vessel:'',
    		voyage:'',
    		vesselTo:'',
    		voyageto:'',
    		polTo:'',
    		podTo:'',
    		fpodTo:'',
    		leg:'',
    		etasailDate:null,
    		etdAtPot:null,
    		select :false,
    			containerDtl : [],
    			transAssignBeanList:[]
    	
    }
 
    $http.get($stateParams.tenantid+ '/app/commonUtility/getVesselList').success(function(data) {
		$scope.vesselList = data;
		$scope.newVesselList = data;
	});
    
    $scope.$watch('transAssign.vessel', function(newValue, oldValue) {
	      if(newValue!=null && newValue!=undefined && newValue != '' ){
	    	  $http.post($stateParams.tenantid+ '/app/commonUtility/getVoyageListByVessel',newValue).success(function(data) {
					$scope.voyageList = data;
	    	  });
	      }
    })
    
     $scope.$watch('transAssign.vesselTo', function(newValue, oldValue) {
	      if(newValue!=null && newValue!=undefined && newValue != ''){
	    	  $http.post($stateParams.tenantid+ '/app/commonUtility/getVoyageListByVessel',newValue).success(function(data) {
					if(data.length > 0)
	    		  {
	    		  $scope.voyageListTo = data;
	    		  }
					else{
						
						logger.logError("Voyage is not available for the given vessel");
						
					}
	    	  });
	      }
	    });
    
    $scope.$watch('transAssign.voyage',function(newValue, oldValue) {
			if(newValue!=null && newValue!=undefined && newValue!=""){
		    
			    	  $http.post($stateParams.tenantid+ '/app/commonUtility/getPortListByVoyage',newValue).success(function(data) {
			    			if(data.length > 0)
				    		  {
							$scope.polList = data;
				    		  }
			    			else{
								
								logger.logError("Voyage is not available for the given vessel");
								
							}
			    	  });
			}
		});
    
    $scope.$watch('transAssign.voyageTo',function(newValue, oldValue) {
		if(newValue!=null && newValue!=undefined && newValue!=""){
	     
			
		    	  $http.post($stateParams.tenantid+ '/app/commonUtility/getPortListByVoyage',newValue).success(function(data) {
		    		  if(data.length > 0)
		    		  {
						$scope.polListTo = data;
		    		  }
		    		  else{
							
							logger.logError("Voyage is not available for the given vessel");
							
						}
		    	  });
		}
	});
    
    
	// Voyage based PodFrom

	 
	$scope.$watch('transAssign.voyage',function(newValue, oldValue) {
		if(newValue!=null && newValue!=undefined && newValue!=""){
	     
			
		    	  $http.post($stateParams.tenantid+ '/app/commonUtility/getPortListByVoyage',newValue).success(function(data) {
						$scope.podList = data;
		    	  });
		}
	});

	 
	    //Check box multiselect
	   $scope.multiSelect = function(obj) {

       angular.forEach(obj, function(row, index) {
           if (row.select) {
               row.select = false;
           } else {
               row.select = true;
           }
       });

   };
	// Voyage based PodTo

	
	$scope.$watch('transAssign.voyageTo',function(newValue, oldValue) {
		if(newValue!=null && newValue!=undefined && newValue!=""){
	     
			
		    	  $http.post($stateParams.tenantid+ '/app/commonUtility/getPortListByVoyage',newValue).success(function(data) {
						$scope.podListTo = data;
		    	  });
		}
	});
	
	   $http.get($stateParams.tenantid+'/app/portactivity/portlist').success(function(datas) {
           $scope.fpodList = datas;
       }).error(function(datas) {
       });
	   
	   
	   
	   
	   //// NEXT PORT
		 $scope.$watchCollection('[transAssign.voyageTo,transAssign.podTo]', function(newValue, oldValue) {
					 if($scope.transAssign.voyageTo != null && $scope.transAssign.voyageTo != '' && $scope.transAssign.voyageTo != undefined 
						        && $scope.transAssign.podTo != null && $scope.transAssign.podTo != '' && $scope.transAssign.podTo != undefined
						      
					
					 ){
						 
						 $http.post($stateParams.tenantid+ '/app/booking/getSailing?voyage='+$scope.transAssign.voyageTo+'&pol='+$scope.transAssign.podTo).success(function(data) {
							 $scope.transAssign.etasailDate	 = data.etasailDate;
						
							
				    	  });
						 
					 }
				 });
				 
				 
				 /// POT
		 $scope.$watchCollection('[transAssign.voyageTo,transAssign.polTo]', function(newValue, oldValue) {
					 if($scope.transAssign.voyageTo != null && $scope.transAssign.voyageTo != '' && $scope.transAssign.voyageTo != undefined 
						        && $scope.transAssign.polTo != null && $scope.transAssign.polTo != '' && $scope.transAssign.polTo != undefined
						      
					
					 ){
						 
						 $http.post($stateParams.tenantid+ '/app/booking/getSailing?voyage='+$scope.transAssign.voyageTo+'&pol='+$scope.transAssign.polTo).success(function(data) {
							 $scope.transAssign.etdAtPot	 = data.etdsailDate;
						
							
				    	  });
						 
					 }
				 });
		 
		 
		 $scope.$watch('transAssign.podTo', function(newValue, oldValue) {
		      if(newValue!=null && newValue!=undefined && newValue != ''){
		    	  
		    		var str = $scope.transAssign.podTo;
					var res = [] ;
					var port;
					var portSeq;
					res = str.split("-");
					port = res[0];
					portSeq=[1];
					
					var str1 = $scope.transAssign.polTo;
					var res = [] ;
					var pto;
					var ptoSeq;
					res1 = str1.split("-");
					pto = res1[0];
					ptoSeq=[1];
	    	 
		    	  if(pto == port){
		    		  logger.logError('Same POT Should be selected..Please select the next To POD');
		    		  $scope.transAssign.podTo ='';
		    		  $scope.transAssign.etasailDate ="";
		    	  }
		    	 
		      }
		})
		
		 $scope.$watchCollection('[transAssign.polTo,transAssign.podTo]', function(newValue, oldValue) {
		 if($scope.transAssign.polTo != null && $scope.transAssign.polTo != '' && $scope.transAssign.polTo != undefined 
			        && $scope.transAssign.podTo != null && $scope.transAssign.podTo != '' && $scope.transAssign.podTo != undefined
			   ){
			 
				

			  var str = $scope.transAssign.polTo;
				 var res = [] ;
				 var pot;
				 var potseq;
				 res = str.split("-");
				 pot = res[0];
				 potseq=res[1];
				 
				 
				 
				  var str = $scope.transAssign.podTo;
					 var res = [] ;
					 var fpod;
					 var fpodseq;
					 res = str.split("-");
					 fpod = res[0];
					 fpodseq=res[1];
			 
				 if(Number(potseq) >=Number(fpodseq)){
				 logger.logError('To POD Sequence should be greater than TO POT Sequence!');
				 $scope.transAssign.polTo ='';
				 $scope.transAssign.podTo ='';
				 
				  
			 } 
			 
		 }
	 });
    
   	$scope.transAssignBeanList=[];
   	$scope.searchAssignedData = function() {
   		debugger;
   		$scope.transAssignBeanList=[];
   		console.log($scope.transAssign);
   	        $http.post($stateParams.tenantid+'/app/transassign/getAssignedData',$scope.transAssign).success(function(data) {
   	            console.log("data" + data);
   	            if (data.success) {
   	             $scope.transAssignBeanList = data.transAssignBeanList;
   	            } else {
   	                logger.logError("Error in List Fetch");
   	            }
   	        }).error(function(result) {
   	            console.log("data" + data.message);
   	        });
   		//}  
   	 };
   	 
   	$scope.updateVslDtls = function(item) {
   		if($scope.transAssign.vesselTo !='' && $scope.transAssign.vesselTo !=null && $scope.transAssign.vesselTo != undefined){
   			if($scope.transAssign.voyageTo !='' && $scope.transAssign.voyageTo !=null && $scope.transAssign.voyageTo != undefined){
   				if($scope.transAssign.polTo !='' && $scope.transAssign.polTo !=null && $scope.transAssign.polTo != undefined){
   					if($scope.transAssign.podTo !='' && $scope.transAssign.podTo !=null && $scope.transAssign.podTo != undefined){
   						
   					
   		debugger;
   		
   		var tmpDelList = [];
		for(var i=$scope.transAssignBeanList.length-1;i>=0;i--){
			if($scope.transAssignBeanList[i].select==true){
				tmpDelList.push($scope.transAssignBeanList[i]);
			}
		}
		
		if(tmpDelList.length !=0){
			
		
   		var obj={
				bean:$scope.transAssign,
				transAssignBeanList:tmpDelList
		};
   	        $http.post($stateParams.tenantid+'/app/transassign/updateVslDtls',obj).success(function(data) {
   	            console.log("data" + data);
   	            if (data.success) {
   	         	 logger.logSuccess("Updated Successfully!"); 
   	          $state.reload();
   	            } else {
   	                logger.logError(data.message);
   	            }
   	        }).error(function(result) {
   	            console.log("data" + data.message);
   	        });
   		//}  
   	        
   				}else{
   	                logger.logError("Please Select the Booking to Roll Over..!!");

   				}
   				}else{
   					
   					logger.logError("Please Select To POD..!!");
   				}
		
		
   				}else{
   	                logger.logError("Please Select To POL..!!");

   				}
   	   		}else{
	                logger.logError("Please Select To Voyage..!!");

   	   		}
   	   		}else{
                logger.logError("Please Select To Vessel..!!");

   	   		}
   	 };
   	 
   	 $scope.cancel=function(){
   	   $state.go('app.operation.transassign.list');
   	 }
   	 
   	 
    var rowId = $location.search().rowId;
	  if(rowId != null){
		  $scope.isEdit=true;
	      
		  $http.post($stateParams.tenantid+'/app/transassign/view?rowId=' +rowId).success(function(result) {
	          if (result.success == false) {
	              logger.logError("Please Try Again");
	          } else {
	              console.log("result***************for viewwwwwwwwwwwwwwwwww*******");
	              console.log(result);
	              $scope.transAssign.transAssignBeanList = result.transAssignBeanList;
	          }
	         }).error(function(data) {

	         });
	  }
	  
	  
  
});
app.controller('tableAddCtrl', function($scope, $state,
		$http, ngDialog, logger, $location, $controller, $injector,
		sharedProperties, toaster, $rootScope, validationService,
		$stateParams) {
	 
	 $scope.$watch('transAssignBeanList[trindex].vesselName', function(newValue, oldValue) {
		 debugger;
		 console.log( $scope.transAssignBeanList[$scope.$index]);
		 if (newValue != "" && newValue != undefined  && newValue != ""  ) {
			  $http.post($stateParams.tenantid+ '/app/commonUtility/getVoyageListByVessel',newValue).success(function(data) {
				  $scope.newVoyageList = data;
	    	  });
		 }
		 })
 
});




app.controller('tsAssignListCtrl', function($scope, $rootScope, $http, $location, logger, utilsService, ngDialog, validationService, $state,sharedProperties,$window,$stateParams) {

    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
     $scope.vesselList= [];
    $scope.voyageList= [];
 
    
    $scope.tsAssignList={
    		vesselSearch:'',
    		voyageSearch:'',
    		potSearch:''

    }
 
    $http.get($stateParams.tenantid+ '/app/commonUtility/getVesselList').success(function(data) {
		$scope.vesselList = data;
		$scope.newVesselList = data;
	});
    
    $scope.$watch('tsAssignList.vesselSearch', function(newValue, oldValue) {
	      if(newValue!=null && newValue!=undefined && newValue != '' ){
	    	  $http.post($stateParams.tenantid+ '/app/commonUtility/getVoyageListByVessel',newValue).success(function(data) {
					$scope.voyageList = data;
	    	  });
	      }
    })
     
    $scope.$watch('tsAssignList.voyageSearch',function(newValue, oldValue) {
			if(newValue!=null && newValue!=undefined && newValue!=""){
			    	  $http.post($stateParams.tenantid+ '/app/commonUtility/getPortListByVoyage',newValue).success(function(data) {
			    			if(data.length > 0)
				    		  {
							$scope.potList = data;
				    		  }
			    			else{
								logger.logError("Voyage is not available for the given vessel");
								
							}
			    	  });
			}
		});
        
   	 
   	$scope.searchAssignedList = function() {
   		debugger;
    	        $http.post($stateParams.tenantid+'/app/transassign/tsAssignedListPage',$scope.tsAssignList).success(function(data) {
   	             $scope.rowCollection1 = data.tsList;
   	             
   	          for(var i =0;data.tsList.length;i++){
 	           	 
   	              	           if(data.tsList[i].assignedDate != null){
   	               var dateSplitted = data.tsList[i].assignedDate.split(" ");
   	               var dateSplitted1 = dateSplitted[0].split("/").reverse().join("/");
   	               var  ms = Date.parse(dateSplitted1);
   	               console.log(dateSplitted +" : " +ms)
   	               data.tsList[i].assignedDate1=ms; } 
   	 }
   	             
   	        }).error(function(result) {
   	            console.log("data" + data.message);
   	        });
   		 
   	 };
   	 
   	$scope.searchAssignedList();
   	 
    
   	 
   	 $scope.cancel=function(){
   	   $state.go('app.operation.transassign.list');
   	 }
   	 
   	 
   	 $scope.reset = function() {
   	   $scope.tsAssignList={
       		vesselSearch:'',
       		voyageSearch:'',
       		potSearch:''

       }
   	$scope.searchAssignedList();
   	 };
   	  
});
