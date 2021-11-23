'use strict';
app.controller('containerAddCtrl', function($scope, $timeout, $stateParams,sharedProperties,toaster,
		$filter, $rootScope, $http, $location, logger, $state, ngDialog,$controller,$injector) {
	$scope.quotationTypeList=[];
	$scope.customerDropList = [];
	$scope.consigneeDropList  = [];
	$scope.shipmentList  = [];
	$scope.nominatedDropList  = [];
	$scope.vendorDropList = [];
	$scope.serviceParnrDropList = [];
	$scope.portList=[];
	$scope.currencyList=[];
	$scope.createQuote=false;
	$scope.saveCount = 0;

	var bookingDate = $stateParams.bookingDate;
	var mloCode = $stateParams.mloCode;
	var lolId = $stateParams.lolId;
	var lodId = $stateParams.lodId;
	var bookingId= parseInt($stateParams.bookingId);

	$scope.quotation={
			service:'',
			aol:'',
			origin:'',
			customer:'',
			salesPerson:'',
			vendor : '', 
			attention : '',
			quotationDate : '',
			branch : '',
			aod : '',
			destination : '',
			shipper : '',
			salesType : '',
			carrier : '',
			termConditions : '',
			mode : '1',
			currency : '',
			term : '',
			commodity : '',
			consignee : '',
			nominatedBy : '',
			validityDate : '',
			remarks : '',
			vessel :'',
			dimensionName:'',
			conNumber:'',
			containerreleaseCode:'',
			quotationDtl:[{id:0,conType:'',quantity:'',depot:'',allocDate:''}],
			sealDtl:[{id:0,sealNo:'',sealFrom:'',sealTo:'',count:''}]
	
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

	$scope.quotation.quotationDate = dd + '/' + mm + '/'
			+ yyyy;


    var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth() + 1;

	var yyyy = today.getFullYear();
	if (dd < 10) {
		dd = '0' + dd;
	}
	if (mm < 10) {
		mm = '0' + mm;
	}
	var today = dd + '/' + mm + '/' + yyyy;
	$scope.quotation.quotationDate = today;
	
	$scope.edit=false;
	$scope.containerreleaseCode=$location.search().containerreleaseCode;
	
	if($scope.containerreleaseCode != '' && $scope.containerreleaseCode!=undefined){
		$scope.edit=true;
		$http.post($stateParams.tenantid+'/app/container/edit',$scope.containerreleaseCode).success(function(datas) {
			
			$scope.quotation=datas.seaQuotationBean;
			$scope.quotation.bookingNo=datas.seaQuotationBean.bookingNo;
			$scope.quotation.quotationDtl=datas.lQuotationBean;
			$scope.quotation.sealDtl=datas.sealdtl;
			
			
		
		}).error(function(datas) {

		});
		
		
	}
	
	   
	   
	
	  $scope.getdropdown = function() {
		  $http.post($stateParams.tenantid+'/api/report/containerNo').success(function(data) {
		      	
		  		$scope.containerNoList=data;
		  		        		
		  });
	$http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(datas) {
			/*  $scope.shipmentList=datas.getshipmentlist;*/
			 /* $scope.portList=datas.getportlist;*/
			  //$scope.customerDropList=datas.getcustomerlist;
			  $scope.conTypeList=datas.getcontypelist;
			  /* $scope.depotList=datas.getportlist;*/
			  /* $scope.chargeTypeList=datas.getchargetypelist*/
			//logger.logSuccess('Mail Sent Successfully!')
		}).error(function(datas) {

		});
	$http.post($stateParams.tenantid+'/app/seaquotation/getServicePartnerList').success(function(datas) {
		debugger
		 $scope.customerDropList = datas.customerList;
		 /*$scope.consigneeDropList = datas.consigneeList;
		 $scope.shipperDropList = datas.shipperList;
		 $scope.nominatedDropList = datas.nominatedList;
		 $scope.vendorDropList = datas.vendorList;*/
		// $scope.serviceParnrDropList=datas.serviceParnrList;
	  
	  
	}).error(function(data) {

	});
	$http.get($stateParams.tenantid+'/app/seaquotation/getiataList').success(function(datas) {
		debugger
	    $scope.depotList = datas.commonUtilityBean;	    

	}).error(function(data) {

	});
	/*$http.post($stateParams.tenantid+'/app/commonUtility/getPortByEmpAgn').success(function(data) {
		  	
			$scope.depotList=data;
			        		
	});*/
	
//	$http.post($stateParams.tenantid+'/app/container/containerType').success(function(data) {
//	  	
//		$scope.conTypeList=data;
//		        		
//});
	
	
	  }
	   
	  $scope.getdropdown();
	  
	  $http.post($stateParams.tenantid+'/app/quickLink/getqlList').success(function(datas) {
			debugger
		    $scope.qlList = datas;	    

		}).error(function(data) {

		});
		
		$scope.$watch('qukLinkVal', function(newValue, oldValue) {
	        if (newValue != '' && newValue != undefined) {
	        	
	            $http.post($stateParams.tenantid+'/app/quickLink/getqlDtl',newValue).success(function(datas) {
	                console.log(datas);
	                $scope.qlLink=datas.qlLink;
	                
	                 
	                }).error(function(datas) {
	            });
	            
	            $http.post($stateParams.tenantid+'/app/quickLink/getGout',$scope.containerreleaseCode).success(function(result) {
	                console.log(result);
	                $scope.bookingNo=result.id;
	                $location.url($stateParams.tenantid+$scope.qlLink + $scope.bookingNo);
	                 
	                }).error(function(datas) {
	            });
	            
	            
	            
			
	        }
	   });



		
		
 
	  if($location.search().bookingCode != null && $location.search().bookingCode != ''){
		  $http.post($stateParams.tenantid+ '/app/salesBooking/edit',$location.search().bookingCode).success(function(data) {
			 debugger
			  $scope.quotation.bookingNo = data.bookingBean.bookingNo;
			 $scope.quotation.customer=data.bookingBean.customer;
			 $scope.quotation.depot=data.bookingBean.pol;
			 $scope.quotation.croDate = today;
			 $scope.quotation.quotationDtl=[];
			 $scope.quotation.sealDtl=[];
			 for(var i=0;i < data.bookingBean.boxData.length;i++){
				 $scope.temp={
						 conType : '',
						 quantity : '',
						 allocDate : '',
						 depot : ''
				 }
				 $scope.temp.conType = data.bookingBean.boxData[i].cntrType;
				 $scope.temp.quantity = data.bookingBean.boxData[i].noOfBox; 
				 $scope.quotation.quotationDtl.push($scope.temp);
				  
			 }

				$http.post($stateParams.tenantid+'/app/ratequotation/getShipment').success(function(datas) {
					  $scope.conTypeList=datas.getcontypelist;
				}).error(function(datas) {

				});
	}); 
	  }
 	 

	




	$scope.changecolor = function(id) {
		$('#' + id + ' .selectivityId').find('input').css(
				"border-color", "red");
	}

	$scope.changecolor = function(id) {
		$('#' + id + ' .selectivityId').find('input').css(
				"border-color", "red");

	}
	$scope.clearcolor = function(id) {
		$('#' + id + ' .selectivityId').find('input').css(
				"border-color", "#e8dddd");

	}
	

	
	
	    
	    
	$scope.addRow = function() {

		$scope.max = Math.max.apply(Math, $scope.quotation.quotationDtl
				.map(function(item) {
					return item.id;
				}));
		$scope.max = $scope.max + 1;
		var chargedata = {
			id : $scope.max,
			chargeHeads : '',
			unit : '',
			currency : '',
			qty : '',
			rate : '',
			currencyList : angular.copy($scope.currencylist),
			paymentMethod : '',
			transactionType : '',
			buySell : '',
			note : ''
		};

		$scope.quotation.quotationDtl.push(chargedata);
		var len = $scope.quotation.quotationDtl.length - 1;
		$timeout(function() {
			hideActivePapers($scope.max + "0", []);
		}, 1000);
		
		/*$scope.hide=true;*/
		
}
	
	$scope.removeRow = function() {
		$scope.tablerow = [];
		for (var index = 0 ; index < 1; index++) {
		angular.forEach($scope.quotation.quotationDtl,function(row, index) {
					var check = row.select;
					
					if (check == undefined || check == "" ) {
						$scope.tablerow.push(row);
					} else if(index > 0){
						$scope.quotation.quotationDtl = $scope.tablerow;

					}
				});
		}
	};
	
	
	
	//Seal Table
	$scope.addRow1 = function() {

		$scope.max = Math.max.apply(Math, $scope.quotation.sealDtl
				.map(function(item) {
					return item.id;
				}));
		$scope.max = $scope.max + 1;
		var chargedata = {
			id : $scope.max,
			chargeHeads : '',
			unit : '',
			currency : '',
			qty : '',
			rate : '',
			currencyList : angular.copy($scope.currencylist),
			paymentMethod : '',
			transactionType : '',
			buySell : '',
			note : ''
		};

		$scope.quotation.sealDtl.push(chargedata);
		var len = $scope.quotation.sealDtl.length - 1;
		$timeout(function() {
			hideActivePapers($scope.max + "0", []);
		}, 1000);
		
		/*$scope.hide=true;*/
		
}
	

	$scope.removeRow1 = function() {
							var tmpDelList = [];
							for (var i = $scope.quotation.sealDtl.length - 1; i >= 0; i--) {
								if ($scope.quotation.sealDtl[i].select == true) {
									tmpDelList.push($scope.quotation.sealDtl[i]);
									$scope.quotation.sealDtl.splice(i, 1);
								}
							}
							
						
	}
	

	/*
	$scope.dropoffList=[
		 
		  { id: 'ROAD', text: 'ROAD' },
		  { id: 'RAIL', text: 'RAIL' }
		
	]
*/
	


	

//	$scope.getSalesType = function() {
//	    var  data = {};
//	    data["id"] = "1";
//	    data["text"] = "CROSS TRADE";
//	    $scope.salesTypeList.push(data);
//	    data = {};
//	    data["id"] = "2";
//	    data["text"] = "LOCAL";
//	    $scope.salesTypeList.push(data);  
//	    data = {};
//	    data["id"] = "3";
//	    data["text"] = "NOMINATED";
//	    $scope.salesTypeList.push(data);  
//	    
//	  
//	}
//	$scope.getSalesType();
	
	//excel upload
	
	
	   $scope.openFileModal = function(trindex) {
		$scope.trId=trindex;
        var isOpenModal = false;
        isOpenModal = true;
        if (isOpenModal) {
            ngDialog.close();
            ngDialog.open({
                template : 'fileModal',
                scope : $scope
            });
        }

    }

	$scope.url1=$stateParams.tenantid+"/app/container/uploadEmployeeExcel";
	
    $scope.uploadInvoice = function() {
        $scope.error=false;
        loader.start();
        var excelfile = $scope.excelfile;
        var fileExtension = excelfile.name;
        var fName = [];
        fName = fileExtension.split(".");
        for (var i = 0; i < fName.length; i++) {
            if (fName[i] == "xls" || fName[i] == "xlsx") {
                var frmData = new FormData();
                frmData.append("file", excelfile);
                $.ajax({
                    type : "POST",
                    url : $scope.url1,
                    data : frmData,
                    contentType : false,
                    processData : false,
                    success : function(response) {
                        loader.complete();
                        if (response.success == true) {
                            $scope.closeUpload();
                            logger.logSuccess(response.message);
                            $scope.quotation.quotationDtl[$scope.trId].quotationinnerDtl = response.quotationinnerDtl;

                        } else if (response.success == false){
                            $scope.error=true;
                            logger.logError("Error in Upload");
                            $scope.rowCollection1 = response.errorExcelList;
                            for (var i = 0; i < response.errorList.length; i++) {
                                logger.logError(response.errorList[i]);
                                $scope.closeUpload();
                            }
                        } else if (response.errorList.length > 0) {

                        } else {
                            logger.logError("Sorry Error Occured");
                            $scope.closeUpload();
                            $scope.getMemberList();
                        }
                    }
                });
            }
        }
    }
    
    $scope.DownloadSample = function() {
        $("#sampleDownload").bind('click', function() {
        });
        $('#sampleDownload').simulateClick('click');
    }
    
    $.fn.simulateClick = function() {
        return this.each(function() {
            if ('createEvent' in document) {
                var doc = this.ownerDocument, evt = doc.createEvent('MouseEvents');
                evt.initMouseEvent('click', true, true, doc.defaultView, 1, 0, 0, 0, 0, false, false, false, false, 0, null);
                this.dispatchEvent(evt);
            } else {
                this.click();
            }
        });
    }
    
    $rootScope.closeUpload = function() {
        ngDialog.close();
    };
	
    
    $rootScope.uploadFile = function(element) {
        $scope.excelfile = element.files[0];
        console.log($scope.excelfile);
    }
    
    var loader = $injector.get("cfpLoadingBar");


	$scope.changecolor=function(id){
	    $('#'+id+' .selectivityId').find('input').css("border-color", "red");;

	}
	$scope.clearcolor=function(id){
	    $('#'+id+' .selectivityId').find('input').css("border-color", "#e8dddd");;

	}

	//add valid
	$scope.checkValidation = function() {

	    var alertmsg = "<ui><h4 backgroundcolor=green>Please fill the required fields</h4>";
	    var msg = "";
	    /*if ($scope.checkundefined($scope.quotation.commodity)) {
	        msg = msg + "<li>Commodity:Field is required.</li>";         
	        $scope.changecolor('commodity');
	    }else{
	    	$scope.clearcolor('commodity');
	    }*/
	    if ($scope.checkundefined($scope.quotation.customer)) {
	        msg = msg + "<li>Customer:Field is required.</li>";         
	        $scope.changecolor('customer_id');
	    }else{
	    	$scope.clearcolor('customer_id');
	    }
	    
	    if ($scope.checkundefined($scope.quotation.depot)) {
	        msg = msg + "<li>Depot :Field is required.</li>";         
	        $scope.changecolor('service');
	    }else{
	    	$scope.clearcolor('service');
	    }
	    
	    
	    if ($scope.checkundefined($scope.quotation.croDate)) {
	        msg = msg + "<li> CRO Date :Field is required.</li>";         
	        $scope.changecolor('aol');
	    }else{
	    	$scope.clearcolor('aol');
	    }
	    if ($scope.checkundefined($scope.quotation.bookingNo)) {
	        msg = msg + "<li>bookingNo :Field is required.</li>";         
	        $scope.changecolor('quotationDate');
	    }else{
	    	$scope.clearcolor('quotationDate');
	    }
	   
	    
	   /* if ($scope.checkundefined($scope.quotation.pod)) {
	        msg = msg + "<li>pod :Field is required.</li>";         
	        $scope.changecolor('branch');
	    }else{
	    	$scope.clearcolor('branch');
	    }
	    if ($scope.checkundefined($scope.quotation.validTill)) {
	        msg = msg + "<li>valid Till :Field is required.</li>";         
	        $scope.changecolor('aod');
	    }else{
	    	$scope.clearcolor('aod');
	    }*/
	      /* if ($scope.checkundefined($scope.quotation.salesType)) {
	        msg = msg + "<li>SalesType:Field is required.</li>";         
	        $scope.changecolor('salesType');
	    }else{
	    	$scope.clearcolor('salesType');
	    }
	    if ($scope.checkundefined($scope.quotation.mode)) {
	        msg = msg + "<li>Mode:Field is required.</li>";         
	        $scope.changecolor('mode');
	    }else{
	    	$scope.clearcolor('mode');
	    }
	    if ($scope.checkundefined($scope.quotation.currency)) {
	        msg = msg + "<li>Currency:Field is required.</li>";         
	        $scope.changecolor('currency');
	    }else{
	    	$scope.clearcolor('currency');
	    }
	    if ($scope.checkundefined($scope.quotation.term)) {
	        msg = msg + "<li>Term:Field is required.</li>";         
	        $scope.changecolor('term');
	    }else{
	    	$scope.clearcolor('term');
	    }
	    if ($scope.checkundefined($scope.quotation.validityDate)) {
	        msg = msg + "<li>ValidityDate:Field is required.</li>";         
	        $scope.changecolor('validityDate');
	    }else{
	    	$scope.clearcolor('validityDate');
	    }*/
	       var countdtl=0;
	       var countseal=0;
	  	    angular.forEach($scope.quotation.quotationDtl, function(chargesDetail, index) { 
	  	    	
	  	    	countdtl = countdtl + chargesDetail.quantity;
	        if ($scope.checkundefined(chargesDetail.conType)) {
	            msg = msg + "<li>Row :" + (index + 1) + "# container Type :Field is required.</li>";
	            //$scope.changecolor('chargeHeads'+index);
	        }else{
	        	$scope.clearcolor('chargeHeads'+index);
	        }
	        if ($scope.checkundefined(chargesDetail.quantity)) {
	            msg = msg + "<li>Row :" + (index + 1) + "# Quantity :Field is required.</li>";
	            $scope.changecolor('unit'+index);
	        }else{
	        	$scope.clearcolor('unit'+index);
	        }
	       
	        
	        
	    });
	  	 
//	 	    angular.forEach($scope.quotation.sealDtl, function(chargesDetail, index) { 
//	 	    	
//	 	    	countseal = countseal + chargesDetail.count;
//		        if ($scope.checkundefined(chargesDetail.sealFrom)) {
//		            msg = msg + "<li>Row :" + (index + 1) + "# Seal From  :Field is required.</li>";
//		            //$scope.changecolor('chargeHeads'+index);
//		        }else{
//		        	$scope.clearcolor('chargeHeads'+index);
//		        }
//		        if ($scope.checkundefined(chargesDetail.sealTo)) {
//		            msg = msg + "<li>Row :" + (index + 1) + "# Seal To :Field is required.</li>";
//		            $scope.changecolor('unit'+index);
//		        }else{
//		        	$scope.clearcolor('unit'+index);
//		        }
//		        if ($scope.checkundefined(chargesDetail.count)) {
//		            msg = msg + "<li>Row :" + (index + 1) + "# Count :Field is required.</li>";
//		            $scope.changecolor('unit'+index);
//		        }else{
//		        	$scope.clearcolor('unit'+index);
//		        }
//		 
//		        
//		    });
//	 	    
//	 	   if(countseal!=countdtl)
//	 		   {
//	 		   
//	 		        msg = msg + "<li>Quantity and Count should be equal</li>";    
//	 		   
//	 		   }
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
	$scope.submit=function(){
		
		var msg=$scope.checkValidation();
		if(!$scope.checkundefined(msg)){   
			logger.logError(msg);
		}else{
        if($scope.quotation.quotationDtl.length>0){
        	if($scope.saveCount==0){
        		$http.post($stateParams.tenantid+'/app/container/save',$scope.quotation).success(function(datas) {
    				debugger
    				  if(datas.success==true){
    					  $scope.saveCount++;
    					  $scope.croNoTmp = datas.message;
    					  logger.logSuccess("Saved Successfully!");
    					  ngDialog.openConfirm({
    				            template :

    				            ' <div class="modal-header">CONFIRMATION</div> ' + '  <div class="row"> ' + '  <div class="col-lg-12"> ' + '   <div class="col-lg-12">   Do you want to proceed with Print/Mail ?    </div> ' + '   </div>  ' + '  </div> ' + '  <div class="modal-footer">' +

    				            '    <button class="btn btn-info" id="croGatein" type="button" ng-click="confirm()">Print</button> <button class="btn btn-info" id="croMail" type="button" ng-click="closeThisDialog();sendMail()">Mail</button>' + '   <button class="btn btn-danger" ng-click="closeThisDialog();cancel()">NO</button>' + '  </div>',
    				            plain : true,
    				            scope : $scope
    				        }).then(function(value) {
    				        	
    				        	var url = $stateParams.tenantid+'/app/container/printCRO?containerreleaseCode=' + $scope.croNoTmp;
    				            
    				              var wnd = window.open(url, 'Shipping', 'height=400,width=750,top=100,left=100,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
    				              wnd.print();
    				              $scope.cancel();
    				        })
//    					  $state.go('app.operation.containerReleaseOrder.list',{tenantid:$stateParams.tenantid});
    				        

    				}else{
    					$scope.saveCount=0;
    					  logger.logError(datas.message);
    				  }
    				}).error(function(data) {
    					logger.logError("Please try again");
    				});
        	}else{
        		logger.logError("Already saved!");
        	}
        }else{
        	logger.logError("Atleast One Row Required");
        }
		}
		
		
	}
	   
    
/*    $scope.showPopup=function(){
      ngDialog.open({
                scope : $scope,
                template : 'views/master/inventory/quotation/popDetail',
                controller : $controller('popUpDtlAddCtrl', {
                    $scope : $scope,
                    rowData:'',                                                                               
                    selectedRowId : ''
                }),
                className : 'ngdialog-theme-plain',
                showClose : false,
                closeByDocument : false,
                closeByEscape : true
                preCloseCallback : $scope.getList
            });
        
        
    }*/
    
    
	$scope.submitupdate=function(){
		
		var msg=$scope.checkValidation();
		if(!$scope.checkundefined(msg)){
			logger.logError(msg);
		}else{
			 if($scope.quotation.quotationDtl.length>0){
			$http.post($stateParams.tenantid+'/app/container/update',$scope.quotation).success(function(datas) {
				  if(datas.success==true){					
					  
					  logger.logSuccess("Updated Successfully!");
					  $state.go('app.operation.containerReleaseOrder.list',{tenantid:$stateParams.tenantid});

				  }else{
					  logger.logError(datas.message);
				  }
				}).error(function(data) {
					logger.logError("Please try again");
				});
			 }else{
		        	logger.logError("Atleast One Row Required");
		        }
		}
		
		
	}
	$scope.cancel=function(){
	  if($location.search().bookingCode != null && $location.search().bookingCode != ''){
		  $state.go('app.salesmarketing.salebooking.list', {
				tenantid : $stateParams.tenantid
			});
	  }
	  else{
		  $state.go('app.operation.containerReleaseOrder.list',{tenantid:$stateParams.tenantid});
	  }
		
	}
	
	
	$scope.sendMail = function() {
		   $http.post($stateParams.tenantid+'/app/container/sendMail',$scope.croNoTmp).success(function(datas) {
			   if(datas.success==true){
				   logger.logSuccess("Mail sent!");
				   $scope.cancel();
			   }else{
				   logger.logError("Unable to send!");
				   $scope.cancel();
			   }
		   });
	}
	
	
	//Export Excel
	
	
	$scope.excelexport=function(containerreleaseCode){
		
		debugger
		$http.post($stateParams.tenantid+'/app/container/excelexport?containerreleaseCode=' + containerreleaseCode).success(function(datas){
			
			debugger;
            $("#emptyExport").bind('click', function() {
            });
            $('#emptyExport').simulateClick('click');
            logger.logSuccess("Exported successfully!");
       /* }else{
            logger.logError("Failed to export");
        }*/
     }).error(function(result) {
         console.log("data" + result);
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
	
	  
	
    $scope.$watch('quotation.customer', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
        	$scope.custId=newValue;
        	$http.post($stateParams.tenantid+'/app/container/getcustomerdetail',$scope.custId).success(function(datas) {
        		
        		$scope.bookingNoList=datas.populateBookingNO;
    		
    		}).error(function(datas) {

    		});
        } 
    });
    $scope.conTypeList=[];
    $scope.$watch('quotation.bookingNo', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
         	$http.get($stateParams.tenantid+'/app/container/getContainerTypeByBooking?bookingNo='+newValue+'&isEdit='+$scope.edit+'&conHdrCode='+$location.search().containerreleaseCode).success(function(datas) {
        		
        		$scope.conTypeList=datas;
    		
    		}).error(function(datas) {

    		});
        } 
    });
    
    
   /* $scope.$watch('quotation.bookingNo', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
        	$scope.bookingNo=newValue;
        	$http.post($stateParams.tenantid+'/app/container/getcustomerpolpod',$scope.bookingNo).success(function(datas) {
        		
        		$scope.quotation.pol=datas.seaQuotationBean.pol;
        		$scope.quotation.pod=datas.seaQuotationBean.pod;
    		
    		}).error(function(datas) {

    		});
        } 
    });
	
*/

});
app.controller('quotationtableCtrl', function($scope, $http, $filter, logger,$stateParams) {/*
	 $scope.$watch('quotation.quotationDtl[trIndex].transactionType', function(newValue, oldValue) {
		 var id = newValue;
			$http.get($stateParams.tenantid+'/app/seaquotation/getServicePartnerListid?id='+ id).success(function(datas) {
				console.log(datas);				
				 $scope.serviceParnrDropList=datas.serviceParnrList;
			  
			}).error(function(data) {

			});
	  });
*/});