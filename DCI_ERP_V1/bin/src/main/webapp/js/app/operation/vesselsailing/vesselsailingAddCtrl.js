'use strict';
app.controller('vesselSailingAddCtrl', function($scope,$stateParams,$rootScope, $http, $location, logger, utilsService, $state, sharedProperties, $window,validationService,toaster) {

    $scope.vesselsailing = {
    	 vessel : '',
        voyage : '',
        port : '',mode:'',carrier:'',
        sail_Date : '',
        vesselSailingId : '',
		containerDtl : [{
			booktype:'',
			leg:'',
			onboardStatusDate:'',
			slotOperator:'',
			soc : false
		}]
    };


    $scope.slotList =[];
	$scope.$watch('vesselsailing.vessel', function(newValue,
			oldValue) {

		if (newValue != '' && newValue != undefined) {

			/*$http.get(
					$stateParams.tenantid
							+ '/api/vesselsailing/voyagelist?vessel='
							+ $scope.vesselsailing.vessel).success(
					function(datas) {
						$scope.voyagelist = datas;

					}).error(function(data) {
				logger.logError("Unable to fetch");
			});*/
			console.log("inside the voyage",newValue);
			 $http.post($stateParams.tenantid+'/app/onBoard/getVoyage?vesselCode='+newValue).success(function(data) {
		        	if(data.success){
		        		console.log("data",data);
		        		$scope.voyagelist=data.voyageList;
		        	}else{
		        		logger.logError("Unable to fetch data");
		        	}
		        });

		}
	});
	$scope.isEdit = false;
	$scope.$watch('[vesselsailing.sail_Date]', function(newValue,oldValue) {
		if (newValue != '' && newValue != undefined) {
 		var today = new Date();
			var dd = today.getDate();
			var mm = today.getMonth() + 1; //January is 0!

			var yyyy = today.getFullYear();
			if (dd < 10) {
			  dd = '0' + dd;
			} 
			if (mm < 10) {
			  mm = '0' + mm;
			} 
			var today = dd + '/' + mm + '/' + yyyy;
			
			var dayDiff = moment(today, "DD/MM/YYYY").diff(moment($scope.vesselsailing.sail_Date, "DD/MM/YYYY"),'day')
	        if ( dayDiff < 0 ) { 
	        	$scope.vesselsailing.sail_Date="";
	        	logger.logError("Vessel Sailing Date Cannot Be Greater Than the Current Date..!!");
	        }

		}
	});

	 $scope.modeList=[];
	 $scope.carrierList=[];
	    
		$scope.getQuotationType = function() {
		    var  data = {};
		    data["id"] = "1";
		    data["text"] = "SEA COASTAL";
		    $scope.modeList.push(data);
		    //$scope.quotation.mode='1';
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
		    data["text"] = "Forwarding";
		    $scope.modeList.push(data);
		}
		$scope.getQuotationType();
		
		
		$http.get($stateParams.tenantid+'/app/commonUtility/getcarrierList').success(function(datas) {
			debugger
		    $scope.carrierList = datas.commonUtilityBean;	    
	        //$scope.transList = datas.lCommonUtilityBean;	    

		}).error(function(data) {

		});
		
	 $scope.$watch('vesselsailing.voyage', function(newValue, oldValue) {
	      if(newValue!=null && newValue!=undefined && newValue != ''){
	    	  $http.post($stateParams.tenantid+ '/api/vesselsailing/getPortListByVoyage',newValue).success(function(data) {
	    		  $scope.portlist = data;
	    	  })
	    	  
	    	  $scope.vesselsailing.containerDtl =[];
	    	 
	      }
	    });
	 
	 $('#onboardStatusDate').datetimepicker({
		 format : 'DD/MM/YYYY HH:mm'
	})

	 $scope.getData = function(onBoardForm,onBoard) {
	 	
	 	if($scope.vesselsailing.vessel !=''){
	         if($scope.vesselsailing.voyage !=''){
	         	if($scope.vesselsailing.port !=''){
	         		if($scope.vesselsailing.mode !=''){
	         		 $scope.vesselsailing.containerDtl= [];
	                 $scope.vesselsailing.countNew=[];
	         		$http.post($stateParams.tenantid+'/api/vesselsailing/getContainerData',onBoard).success(function(data) {
	         	
	             console.log("data" + data);
	             if (data.success) {
	                 $scope.vesselsailing.containerDtl= data.onBoardBeanList;
	                 $scope.vesselsailing.countNew= data.contList;
	                 $scope.check1 = false;

	             } else {
	                 logger.logError(data.message);
	                 $scope.check1 = true;
	             }
	         }).error(function(result) {
	             console.log("data" + data);
	         });
	         		}else{
	         		 	  if($scope.vesselsailing.port=='')
	         		             logger.logError("Please select Mode");
	         		 	}
	 	}else{
	 	  if($scope.vesselsailing.port=='')
	             logger.logError("Please select Port");
	 	}
	 }
	 else{
	     if($scope.onBoard.voyage=='')
	         logger.logError("Please select Voyage");
	 }
	 }
	  else{
	     logger.logError("Please select  Vessel");
	 }
	     
	  };
	  
	//reset
		$scope.reset = function() {
			 $scope.vesselsailing = {
			    	 vessel : '',
			        voyage : '',
			        port : '',
			        sail_Date : '',
			        vesselSailingId : '',
					detailDate:'',
					containerDtl : [{
						booktype:'',
						leg:'',
						onboardStatusDate:'',
						slotOperator:'',
						soc:false
					}]
			    };
		}

		 $scope.apply = function(detailDate){
				for(var i=0;i<$scope.vesselsailing.containerDtl.length;i++){
					$scope.vesselsailing.containerDtl[i].onboardStatusDate = detailDate;

				}
			
			}
		 
    $scope.cancel = function() {
        $state.go('app.operation.vesselsailing.list',{tenantid:$stateParams.tenantid});
    };

    $scope.departmentValidateData = {
        isEdit : false,
        deptCodeEdit : false
    }
    $scope.employeeList = [];
    $scope.deptList = [];
    // Drop Down Functionality

    $scope.getDropdownvalue = function() {
    	
    	$http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(datas) {
    		  $scope.customerList=datas.getcustomerlist;
  		  $scope.currencyList=datas.getcurrencylist	;
  		 // $scope.portlist =datas.getportlist;
  	}).error(function(datas) {

  	});
    	
    	 
		 $scope.$watchCollection('[vesselsailing.vessel,vesselsailing.voyage,vesselsailing.port]', function(newValue, oldValue) {
			 if($scope.vesselsailing.vessel != null && $scope.vesselsailing.vessel != '' && $scope.vesselsailing.vessel != undefined 
				        && $scope.vesselsailing.voyage != null && $scope.vesselsailing.voyage != '' && $scope.vesselsailing.voyage != undefined
				        && $scope.vesselsailing.port != null && $scope.vesselsailing.port != '' && $scope.vesselsailing.port != undefined){
				 $http.post($stateParams.tenantid+ '/api/vesselsailing/CheckONBOARDdate?vessel='+$scope.vesselsailing.vessel+'&voyage='+$scope.vesselsailing.voyage+'&port='+$scope.vesselsailing.port).success(function(data) {
					if(data.count == 0){
						 $scope.check = true;
						 logger.logError("Onboard is not present for Voyage & Port . Vessel Sailing Cannot Be Saved ..!!");
					}else{
						 $scope.check = false;
					}
					
		    	  });
			 }
		 });
     
        $http.get($stateParams.tenantid+'/api/vesselsailing/vessellist').success(function(datas) {
            $scope.vessellist = datas;
        }).error(function(datas) {
        });
        $http.post($stateParams.tenantid+'/app/onBoard/dropDownList').success(function(data) {
      		$scope.slotList=data.slotList;
      });

    }
    $scope.getDropdownvalue();

    $scope.check=false;
    $scope.save = function(departmentAddForm, departmentData, departmentValidateData) {

        $scope.submitted = true;
        $scope.check=true;
        if (new validationService().checkFormValidity($scope.departmentAddForm)) {
            $http.post($stateParams.tenantid+'/api/vesselsailing/create', $scope.vesselsailing).success(function(result) {
                console.log("result" + result);
                if (result.isSuccess) {
                    logger.logSuccess(result.message);
                    $scope.check=true;
                    $state.go('app.operation.vesselsailing.list',{tenantid:$stateParams.tenantid});
                } else {
                    logger.logError(result.message);
                    $scope.check=false;
                   // $state.go('app.operation.vesselsailing.list',{tenantid:$stateParams.tenantid});
                }
            }).error(function(result) {
                console.log("data" + result);
                $scope.check=false;
            });

        } else {
            toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.departmentAddForm.$validationSummary), 555000, 'trustedHtml');
        }
    };

    $scope.update = function(departmentAddForm, vesselsailing, departmentValidateData) {
    	$scope.check=true;
        if (new validationService().checkFormValidity($scope.departmentAddForm)) {
             $scope.vesselsailing.vesselSailingId = $location.search().vesselSailingId;
             
            $http.post($stateParams.tenantid+'/api/vesselsailing/update', $scope.vesselsailing).success(function(result) {
                if (result) {
                    logger.logSuccess("Updated Successfully!");
                    $scope.check=true;
                    $state.go('app.operation.vesselsailing.list',{tenantid:$stateParams.tenantid});
                } else {
                    logger.logError("Error in Update");
                    $scope.check=false;
                }
            }).error(function(data) {
                console.log("data" + data);
                $scope.check=false;
            });

        } else {
            toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.departmentAddForm.$validationSummary), 555000, 'trustedHtml');
        }
    };
    
    //send mail
    $scope.sendMail = function() {

            $http.post($stateParams.tenantid+'/api/vesselsailing/sendmail', $scope.vesselsailing).success(function(result) {
                console.log("result" + result);
                if (result.isSuccess) {
                    logger.logSuccess(result.message);     
                } else {
                    logger.logError(result.message);
                    
                    
                }
            }).error(function(result) {
                console.log("data" + result);
                
            });    
    };

    //Fetch Values
    $scope.isEdit = false;
    var vesselSailingId = $location.search().vesselSailingId;
    if (vesselSailingId == undefined) {
//        var deptName = $scope.departmentData.deptName;
//        var deptHeadName = $scope.departmentData.deptHeadName;
//
//        var deptDesc = $scope.departmentData.deptDesc;
//        var deptHead = $scope.departmentData.deptHead;
//        var isActive = $scope.departmentData.isActive;
//        $scope.departmentData.isEdit = false;
    } else {
        $http.get($stateParams.tenantid+'/api/vesselsailing/edit?vesselSailingId=' +vesselSailingId).success(function(result) {

            if (result.isEdit == false) {
                logger.logError("Please Try Again");
            } else {
            	 

        			if(result.mode != null && result.mode != ''){
        				 
        			    if(result.mode==1){
        					result.mode = "SEA COASTAL";
        		    }else  if(result.mode==2){
        					result.mode = "SEA FOREIGN";
        		    }else  if(result.mode==3){
        					result.mode = "TRUCK";
        		    }else  if(result.mode==4){
        					result.mode = "LINER";
        		    }else  if(result.mode==4){
        					result.mode = "LINER";
        		    }else  if(result.mode==5){
        					result.mode = "Forwarding";
        		    }
        		}
        			
            	$scope.vesselsailing.vessel=result.vessel;
            	$scope.vesselsailing.voyage=result.voyage;
            	$scope.vesselsailing.port =result.port;
            	$scope.vesselsailing.sail_Date=result.sail_Date;
            	$scope.vesselsailing.mode =result.mode;
            	$scope.vesselsailing.carrier =result.carrier;

            	$scope.isEdit=true;
            }
        }).error(function(data) {
            console.log("data" + data);
        });
    }
    
    
	//Excel Export	
	 $scope.getReport = function(){
	   	 $http.post($stateParams.tenantid+'/api/vesselsailing/getVoyageCosting', $scope.vesselsailing).success(function(response) {

	                if(response.Success){
	                    debugger;
	                    $("#vesselsailingsave").bind('click', function() {
	                    });
	                    $('#vesselsailingsave').simulateClick('click');
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

  /*//Excel Export	
  	 $scope.getReport = function(){
  	   	 $http.post($stateParams.tenantid+'/api/vesselsailing/getVoyageCosting', $scope.vesselsailing).success(function(response) {

  	                if(response.Success){
  	                    debugger;
  	                    $("#vesselsailingsave").bind('click', function() {
  	                    });
  	                    $('#vesselsailingsave').simulateClick('click');
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


  	  //print
      $scope.printsailingportDiv = function(journalNo){
          console.log("print")
          console.log(journalNo)
          var url = $stateParams.tenantid+'/api/vesselsailing/print?voyage='+$scope.vesselsailing.voyage+'&port='+$scope.vesselsailing.port;
          var wnd = window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
          wnd.print();
     
       }*/


});


app.controller('onBoardtableCtrl', function($scope, $http, $filter, logger,	$stateParams) {
	$scope.$watchCollection('[vesselsailing.containerDtl[trIndex].onboardStatusDate]', function(newValue, oldValue) {
	 
		//alert($scope.isEdit);
		if($scope.vesselsailing.containerDtl[$scope.$index].onboardStatusDate != null && $scope.vesselsailing.containerDtl[$scope.$index].onboardStatusDate != '' ){
			var today = new Date();
			var dd = today.getDate();
			var mm = today.getMonth() + 1; //January is 0!

			var yyyy = today.getFullYear();
			if (dd < 10) {
			  dd = '0' + dd;
			} 
			if (mm < 10) {
			  mm = '0' + mm;
			} 
			var today = dd + '/' + mm + '/' + yyyy; 
			noOfDays = moment(today, 'DD/MM/YYYY').diff(moment($scope.vesselsailing.containerDtl[$scope.$index].onboardStatusDate, 'DD/MM/YYYY'), 'days');
			 if(noOfDays<0){
				 logger.logError("OnBoard Date Cannot Be Greater Than the Current Date..!!");
				 $scope.vesselsailing.containerDtl[$scope.$index].onboardStatusDate = "";
			 }	 
		  
		}
	});
});

