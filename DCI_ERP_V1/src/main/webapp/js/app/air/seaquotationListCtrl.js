'use strict';
app.controller('seaquotationListCtrl', function($scope, $timeout, $stateParams,sharedProperties,toaster,
		$filter, $rootScope, $http, $location, logger, $state, ngDialog,$controller,$injector,$window) {
	$scope.itemsByPage = 10;
	

	$('.rounded').val($rootScope.seaquotationListCtrl);
	
	
	$scope.getBookingList = function() {
		$http.post($stateParams.tenantid+'/app/seaquotation/list').success(function(data) {
			debugger
			angular.forEach(data.lQuotationBean, function(row, index) { 

			if(row.modeName != null && row.modeName != ''){
				 
			    if(row.modeName==1){
					row.modeName = "SEA COASTAL";
		    }else  if(row.modeName==2){
					row.modeName = "SEA FOREIGN";
		    }else  if(row.modeName==3){
					row.modeName = "TRUCK";
		    }else  if(row.modeName==4){
					row.modeName = "LINER";
			}
			else  if(row.modeName==5){
					row.modeName = "FORWARDING";
		    }
		}
			})
			$scope.rowCollection = data.lQuotationBean;
		});
	};
	/*$scope.getBookingList = function() {
		$http.post($stateParams.tenantid+'/app/seaquotation/list').success(function(data) {
			debugger
			angular.forEach(data.lQuotationBean, function(row, index) { 
				var modevalues="";

	if(row.modeName != null && row.modeName != ''){
		
		var mode =row.modeName.split(",");
		for(var i=0;i<mode.length;i++){
			
		if(modevalues ==""){
			 if(mode[i]==1){
			    	modevalues = "SEA COASTAL";
		    }else  if(mode[i]==2){
		    	modevalues = "SEA FOREIGN";
		    }else  if(mode[i]==3){
		    	modevalues = "TRUCK";
		    }else  if(mode[i]==4){
		    	modevalues = "LINER";
		    }
		}else{
			 if(mode[i]==1){
			    	modevalues += " , SEA COASTAL";
		    }else  if(mode[i]==2){
		    	modevalues += " , SEA FOREIGN";
		    }else  if(mode[i]==3){
		    	modevalues += " , TRUCK";
		    }else  if(mode[i]==4){
		    	modevalues += " , LINER";
		    }
		}
	   
}
			
			    
			
		}
	data.lQuotationBean[index].modedesc= modevalues;
	
			})
			$scope.rowCollection = data.lQuotationBean;
		});
	};*/
	$scope.quotation={
			fromDate:'',
			toDate:'',
			status:'',deletedRemarks:'',quotationNo:'',
			polCode:'',podCode:''

	}
	/*$('#fromDate').datetimepicker({
        format : 'DD/MM/YYYY'
    })
    
     $('#toDate').datetimepicker({
        format : 'DD/MM/YYYY'
    })*/
	 $scope.jobStatusList=[];
		$scope.getjobStatus = function() {
		    var  data = {};
		    data["id"] = "All";
		    data["text"] = "All";
		    $scope.jobStatusList.push(data);
		    data = {};
		    data["id"] = "Pending";
		    data["text"] = "Pending";
		    $scope.jobStatusList.push(data); 
		    data = {};
		    data["id"] = "Approved";
		    data["text"] = "Approved";
		    $scope.jobStatusList.push(data); data = {};
		    data["id"] = "Rejected";
		    data["text"] = "Rejected";
		    $scope.jobStatusList.push(data); data = {};
		    data["id"] = "Expired";
		    data["text"] = "Expired";
		    $scope.jobStatusList.push(data); 
		    
		}
		$scope.getjobStatus();
	$scope.getBookingList();
	$http.post(	$stateParams.tenantid+ '/app/seaquotation/getServicePartnerList').success(function(datas) {
				debugger
				 $scope.customerDropList = datas.customerList;
				 $scope.consigneeDropList = datas.consigneeList;
				 $scope.shipperDropList = datas.shipperList;
				 $scope.nominatedDropList = datas.nominatedList;
				 $scope.vendorDropList = datas.vendorList;
				 $scope.serviceParnrDropList=datas.serviceParnrList;

			}).error(function(data) {
});
	
	
	$scope.modeList=[];
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
	    data["text"] = "FORWARDING";
	    $scope.modeList.push(data);
	}
	$scope.getQuotationType();
	$scope.polList=[];
	 $scope.potList=[];
	$http.post($stateParams.tenantid+'/app/ratequotation/getShipment').success(function(datas) {
		  $scope.polList=datas.polList;
		   $scope.potList = datas.getportlist;
		//logger.logSuccess('Mail Sent Successfully!')
	}).error(function(datas) {

	});
	//approve Request
	$scope.approveRow = function(QuotHdId) {
	    $location.url($stateParams.tenantid+'/seaQuotationApproval/Approval/list?QuotHdId=' + QuotHdId);
	};
	$scope.sendmail = function(quotationHdId){
		$http.get($stateParams.tenantid + '/app/seaquotation/sendMail?quotationHdId='+quotationHdId)
		.success(function(datas) {
			logger.logSuccess('Mail Sent Successfully!')
		}).error(function(data) {

		});
	}
	$scope.add = function() {
		$rootScope.seaquotationListCtrl=$('.rounded').val();
        $state.go('app.sea.quotation.add',{tenantid:$stateParams.tenantid});
    };
    
    $scope.viewGeneralLedgerReportNew = function(quotation) {
    	$http.post($stateParams.tenantid+'/app/seaquotation/filterList',quotation).success(function(data) {
    		angular.forEach(data.lQuotationBean, function(row, index) { 

    			if(row.modeName != null && row.modeName != ''){
    				 
    			    if(row.modeName==1){
    					row.modeName = "SEA COASTAL";
    		    }else  if(row.modeName==2){
    					row.modeName = "SEA FOREIGN";
    		    }else  if(row.modeName==3){
    					row.modeName = "TRUCK";
    		    }else  if(row.modeName==4){
    					row.modeName = "LINER";
    		    }else  if(row.modeName==5){
    					row.modeName = "FORWARDING";
    		    }
    		}
    			})
    	//$http.get($stateParams.tenantid+'/app/seaquotation/filterList?mode='+quotation.mode+'&polCode='+quotation.polCode+'&podCode='+quotation.podCode+'&status='+quotation.status+'&fromDate='+quotation.fromDate+'&toDate='+quotation.toDate).success(function(data) {
		debugger
		$scope.rowCollection = data.lQuotationBean;
	});};
    
	$scope.editQuot = function(QuotHdId) {
		$rootScope.seaquotationListCtrl=$('.rounded').val();
		debugger
			$location.url($stateParams.tenantid+'/seaQuotation/edit?QuotHdId='+QuotHdId);
		
	}
	$http.get($stateParams.tenantid+'/app/commonUtility/getcarrierList').success(function(datas) {
		debugger
	    $scope.carrierList = datas.commonUtilityBean;	    
        //$scope.transList = datas.lCommonUtilityBean;	    

	}).error(function(data) {

	});
	$scope.editQuot1 = function(QuotHdId1) {
		debugger
		$rootScope.seaquotationListCtrl=$('.rounded').val();
		$rootScope.QuotHdId1 = QuotHdId1;
        $state.go('app.sea.quotation.Add',{QuotHdId1: $stateParams.QuotHdId1});

	}
	
	
	
	
	
	$scope.viewQuot = function(QuotHdId) {
		$rootScope.seaquotationListCtrl=$('.rounded').val();
		debugger
			$location.url($stateParams.tenantid+'/seaQuotation/view?QuotHdId='+QuotHdId);
		
	}
	
	 $scope.printQuot = function(quotationHdId){
	        debugger
	        console.log("Both print invoice")
	        var url = $stateParams.tenantid+'/app/seaquotation/print?quotationHdId=' + quotationHdId;
	        var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
	        wnd.print();   
	     }
	    
	 
		//Approval
		$scope.deleteQ = function(quotationId,quotationNo) {	
			 $scope.quotationNew = {

						fromDate:'',
						toDate:'',
						status:'',deletedRemarks:'',quotationNo:'',
						polCode:'',podCode:''

				 
		        };
			    $scope.quotationNew.quotationNo =  quotationNo;
			    $scope.quotationNew.quotationId =  quotationId;

	             $scope.quotationNew.deleteRemarks =  '';
	         ngDialog.open({
	             scope : $scope,
	             template : 'views/air/seaQuotation/quotationDeleteRemarks',
	             controller : $controller('quotationDeleteCtrl', {
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
	 	
	 	
	 	
	 	
	 	//Excel Export	
		 $scope.exportExcelnew = function(){
			 
			/*if($scope.bookingReport.salesPersonId!='' && $scope.bookingReport.salesPersonId!=null){*/
		   	 $http.post($stateParams.tenantid+'/app/seaquotation/ExportExcel', $scope.quotation).success(function(response) {

		                if(response){
		                    debugger;
		                    $("#quotation").bind('click', function() {
		                    });
		                    $('#quotation').simulateClick('click');
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
	   




	 	
	 $scope.mailview = function(quotationHdId) {
		 //alert(quotationHdId);
         if(quotationHdId =="" || quotationHdId ==undefined){
            // logger.logError("");
         }else{         
             ngDialog.open({
                 scope : $scope,
                 template : 'views/air/seaQuotation/seaQuotationViewMail',
                 controller : $controller('seaquotationmailViewCtrl', {
                     $scope : $scope,
                     quotationid: quotationHdId,
                    // screenName: 'SeaQuotationmailView'
                 }),
                 className : 'ngdialog-theme-plain',
                 showClose : false,
                 closeByDocument : false,
                 closeByEscape : false,
                 preCloseCallback : $scope.getList
             });
         }
     };
	 
	 
  app.controller('seaquotationmailViewCtrl',
				function($scope, $timeout, $stateParams, sharedProperties,
						toaster, $filter, $rootScope, $http, $location, logger,
						$state, ngDialog, $controller, $injector,quotationid) {
	  
	  //alert("dialog"+quotationid);
	 
	  var tenantId = $stateParams.tenantid;
	  
	  var quotationid = quotationid;
	  
	  $scope.viewmaildata = function(){
			$http.get($stateParams.tenantid + '/app/seaquotation/viewSeaQuotationMail?quotationHdId='+quotationid)
			.success(function(datas) {
				console.log(datas);
				$scope.hdr=datas.seaQuotationBean;
				$scope.detailList=datas.seaQuotationBean.quotationDtl;
				//logger.logSuccess('Mail Sent Successfully!')
			}).error(function(data) {

			});
		}
	  $scope.viewmaildata();
	  
	 
	  $scope.closedialog = function(){
		  ngDialog.close();
		  
	  }
	  var usermailId='';
	  
	  $scope.sendmail = function(quotationHdId){
		  $scope.getuserdetail();
			$http.get($stateParams.tenantid + '/app/seaquotation/sendMail?quotationHdId='+quotationid)
			.success(function(datas) {
				//console.log(datas);
				logger.logSuccess('Mail Sent Successfully to '+' '+usermailId)
			}).error(function(data) {

			});
		}
	  
	  
	  $scope.getuserdetail = function(){
		  
		  $http.get($stateParams.tenantid + '/app/commonUtility/getUserdetail')
			.success(function(datas) {
				console.log(datas);
				usermailId =datas.airQuotationBean.employeeEmail

				//logger.logSuccess('Mail Sent Successfully!')
			}).error(function(data) {

			});
	  }
	  
				});
	
	
});app.controller('quotationDeleteCtrl', function($stateParams , $scope , $http, $location,logger, $state, $window,ngDialog) {
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

    	//approve
	
    		$http.post($stateParams.tenantid+'/app/seaquotation/delete',quotationNew).success(function(datas) {
    			if(datas.success){
    		    logger.logSuccess("Deleted Successfully!!!");
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
