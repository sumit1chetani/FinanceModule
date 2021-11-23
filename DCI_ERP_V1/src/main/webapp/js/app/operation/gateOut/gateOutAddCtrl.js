'use strict';
app.controller('gateOutAddCtrl', function($scope, $timeout, $stateParams,sharedProperties,toaster,
		$filter, $rootScope, $http, $location, logger, $state, ngDialog,$controller,$injector) {
	$scope.quotationTypeList=[];
	$scope.customerDropList = [];
	$scope.consigneeDropList  = [];
	$scope.shipmentList  = [];
	$scope.nominatedDropList  = [];
	$scope.vendorDropList = [];
	$scope.serviceParnrDropList = [];
	$scope.portList=[];
	$scope.tripNoList=[];
	$scope.loadList=[];
	$scope.currencyList=[];
	$scope.createQuote=false;
debugger;
$scope.croCount=0;
	var bookingDate = $stateParams.bookingDate;
	var mloCode = $stateParams.mloCode;
	var lolId = $stateParams.lolId;
	var lodId = $stateParams.lodId;
	var bookingId= parseInt($stateParams.bookingId);
	$scope.edit=false;

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
			shipper : '',gateoutnoE:'',
			salesType : '',
			carrier : '',
			termConditions : '',
			mode : '',
			currency : '',
			term : '',
			type : 'Export',
			consignee : '',
			nominatedBy : '',
			validityDate : '',
			remarks : '',
			vessel :'',voyage:'',
			dimensionName:'',
			createdBy: '',
			createdOn : '',
			modifiedBy: '',
          modifiedOn: '',

			quotationDtl:[{id:0,conType:'',quantity:'',depot:'',allocDate:''}],
			sealDtl:[{id:0,sealNo:'',sealFrom:'',sealTo:'',count:''}],
			bookingNo:''
	
	}
	if($rootScope.doType=="Import"){
		$scope.quotation.type = 'Import';
	}else{
		$scope.quotation.type = 'Export' ;
	}
	
	$scope.saveButtonDisble = false;
	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth() + 1; // January is 0!
	var yyyy = today.getFullYear();
	var HH = today.getHours();
	var MM = today.getMinutes();
	if (dd < 10) {
		dd = '0' + dd
	}
	if (mm < 10) {
		mm = '0' + mm
	}
	if (HH < 10) {
		HH = '0' + HH
	}
	if (MM < 10) {
		MM = '0' + MM
	}

	$scope.quotation.releaseDate = dd + '/' + mm + '/'
			+ yyyy+ ' ' + HH+':'+ MM;


    var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth() + 1;
	var yyyy = today.getFullYear();
	var HH = today.getHours();
	var MM = today.getMinutes();
	if (dd < 10) {
		dd = '0' + dd;
	}
	if (mm < 10) {
		mm = '0' + mm;
	}
	if (HH < 10) {
		HH = '0' + HH
	}
	if (MM < 10) {
		MM = '0' + MM
	}
	var today = dd + '/' + mm + '/' + yyyy+ ' ' + HH+':'+ MM;
	$scope.quotation.releaseDate = today;
	
	 $('#releaseDate').datetimepicker({
		 format : 'DD/MM/YYYY HH:mm'
		 })
		 $('#disDate').datetimepicker({
		 format : 'DD/MM/YYYY HH:mm'
		 })

	
   	var croNo = $location.search().croNo;
	
	if(croNo != null && croNo != ""){
	$scope.quotation.croNo=croNo;
	}
	$scope.modeList= [];
	$http.get($stateParams.tenantid+'/app/commonUtility/getcarrierList').success(function(datas) {
		debugger
	    $scope.carrierList = datas.commonUtilityBean;	    
        //$scope.transList = datas.lCommonUtilityBean;	    

	}).error(function(data) {

	});
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
		    data["id"] = "4";
		    data["text"] = "LINER";
			 $scope.modeList.push(data);
			 data = {};
		    data["id"] = "5";
		    data["text"] = "Forwarding";
		     $scope.modeList.push(data);
		// data = {};
		// data["id"] = "2";
		// data["text"] = "SEA";
		// $scope.modeList.push(data);
	}
	$scope.getQuotationType();
	$scope.gateOutCode=$location.search().gateOutCode;
	var gateOutNo =$scope.gateOutCode;
	if($scope.gateOutCode != '' && $scope.gateOutCode!=undefined){
		 $http.get($stateParams.tenantid+ '/app/gateOut/getCustomereditDropdown?gateOutNo=' +gateOutNo).success(function(data1) {
				console.log(data1);
				$scope.customerList1 = data1;
		  
			});
		$scope.edit=true;
		$http.post($stateParams.tenantid+'/app/gateOut/edit',$scope.gateOutCode).success(function(datas) {
			$scope.conNoList=datas.getcontainer;
			$scope.quotation=datas.seaQuotationBean;
			$scope.quotation.quotationDtl=datas.lQuotationBean;
		}).error(function(datas) {

		});
		
		
	}

	
	  $scope.getdropdown = function() {
	  
	$http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(datas) {
		  //$scope.customerList=datas.getcustomerlist;
		  $scope.conTypeList=datas.getcontypelist;
		  // $scope.depotList=datas.getportlist;
		  //$scope.depotList=datas.polList;
		   $scope.conNoList=datas.getcontainer;
		   $scope.quotation.gateOutNo1=datas.maxGateOutNo;
		}).error(function(datas) {

		});
	$http.post($stateParams.tenantid+'/app/gateOut/gettripNoList').success(function(datas) {
		  $scope.tripNoList=datas;
		 		}).error(function(datas) {

		});
	
	
	

	/*$http.get($stateParams.tenantid+ '/app/commonUtility/getshipConsigneeList').success(function(data1) {
		$scope.customerList = data1;
	});*/
	$http.get($stateParams.tenantid+'/app/seaquotation/getiataList').success(function(datas) {
	    $scope.depotList = datas.commonUtilityBean;	    

	}).error(function(data) {

	});
	$http.post($stateParams.tenantid+'/app/seaquotation/getServicePartnerList').success(function(datas) {
		debugger
		 $scope.customerList = datas.customerList;
		 /*$scope.consigneeDropList = datas.consigneeList;
		 $scope.shipperDropList = datas.shipperList;
		 $scope.nominatedDropList = datas.nominatedList;
		 $scope.vendorDropList = datas.vendorList;
		 $scope.serviceParnrDropList=datas.serviceParnrList;*/
	}).error(function(data) {

	});
	 $scope.$watchCollection('quotation.mode', function(newValue, oldValue) {
	        if (newValue != '' && newValue != undefined) {
if($scope.quotation.type=='Export'){
	    $http.get($stateParams.tenantid+'/api/outWard/getBookingList_modeCarrier?carrier='+$scope.quotation.carrier+'&mode='+newValue).success(function(datas) {
	        $scope.bookNoList = datas;
	    });
	        /*}else{
	        	$scope.bookNoList=[];
	        }*/
	        }else if ($scope.quotation.type=='Import'){
	    		$http.post($stateParams.tenantid+'/app/gateOut/getcroNo1',$scope.quotation).success(function(datas) {

	         		
	        		$scope.croList=datas.croList;
	        		$scope.doList=datas.doList;
	        	
	        	}).error(function(datas) {

	        	});
	        }
	        }
	    })
    $scope.$watchCollection('quotation.carrier', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
        	if($scope.quotation.type=='Export'){
        		
    $http.get($stateParams.tenantid+'/api/outWard/getBookingList_modeCarrier?carrier='+newValue+'&mode='+$scope.quotation.mode).success(function(datas) {
        $scope.bookNoList = datas;
    });
        
        }else if ($scope.quotation.type=='Import'){
    		$http.post($stateParams.tenantid+'/app/gateOut/getcroNo1',$scope.quotation).success(function(datas) {

     		
        		$scope.croList=datas.croList;
        		$scope.doList=datas.doList;
        	
        	}).error(function(datas) {

        	});
        }
        }
    })
    
    //getDo
    //do
   /*   $scope.$watchCollection('quotation.carrier', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {

    $http.get($stateParams.tenantid+'/api/outWard/getDo?carrier='+newValue).success(function(datas) {
        $scope.bookNoList = datas;
    });
        }else{
        	$scope.bookNoList=[];
        }
    })*/
  
   /* $http.get($stateParams.tenantid+'/api/outWard/getBookingList').success(function(datas) {
        $scope.bookList = datas;
    });*/
    
	
    
	//Get Booking NO
	/*$http.post($stateParams.tenantid+'/app/gateOut/getBookingNo').success(function(datas) {
			console.log("getBookingNo",datas)
			$scope.bookNoList=datas.bookNoList;
		
		}).error(function(datas) {
	
		});*/

	
	
	/*$http.post($stateParams.tenantid+'/app/gateOut/getcroNo?gateOutNo='+$scope.quotation.bookingNo).success(function(datas) {
		
		$scope.croList=datas.croList;
		$scope.doList=datas.doList;
	
	}).error(function(datas) {

	});*/
	

	 
	  }
	   
	  $scope.getdropdown();
	  
	  
	  //fetch container Details
	  
	  $scope.fetch = function() {
		  
		  var msg=$scope.checkValidation1();
			if(!$scope.checkundefined(msg)){  
				logger.logError(msg);
			}else{
		  $timeout(function() {

		  $http.post($stateParams.tenantid+'/app/gateOut/getEmptyContainerList',$scope.quotation).success(function(datas) {
				debugger
				  if(datas.success==true){					 
					
					  if(datas.sealdtl.length>0){
						  
						  $scope.quotation.popUpDtl=datas.sealdtl;
						  ngDialog.close();
				          ngDialog.open({
				              template : 'views/operation/gateOut/gateOutPopUp',
				              scope : $scope,
				              closeByEscape: true
				    });
						  
						  
					  }else{
						  
						  logger.logError("Containers not available in selected Depot");
						  
					  }
				
				        

				}else{
					  logger.logError("Error in Fetch");
				  }
				}).error(function(data) {
					logger.logError("Please try again");
				});
				}, 1000);
   
			}  }
	  
	  
	  
	  
	  $scope.selectall= function(selection){
      	angular.forEach($scope.quotation.popUpDtl,function(value,key) {
      		debugger;
      		if( selection)
      		value.select=true;
      		else{
      			value.select=false;
      		}
  });
      }
	  
	  $scope.popupsubmit = function() {
		  
	
		  $scope.loadList=[];
		  
      var i=0,count=0;
		  angular.forEach($scope.quotation.popUpDtl, function(chargesDetail, index) { 
			  
			  if (chargesDetail.select==true) {
				  
				 i++
				 // $scope.quotation.quotationDtl[i].containerNo=chargesDetail.containerNo;
				// $scope.quotation.quotationDtl[i].conType=chargesDetail.conType;
				 var  data = {};
				    data["containerNo"] = chargesDetail.containerNo;
				    data["conType"] = chargesDetail.conType;
                    data["gateoutnoE"] = chargesDetail.gateoutnoE;
				    data["previousStatusDate"] = chargesDetail.previousStatusDate;
				    $scope.loadList.push(data);
				    count=count+1;
		        }
		       
		     
		 
		        
		    });
		  $scope.croCount=count;
		  if($scope.quotation.type=="Export"){
		  
		  if(i<= $scope.quotation.countTotal){
			  
			  ngDialog.close();
	  
		  $scope.quotation.quotationDtl=$scope.loadList;
		  
		  }else {
			  
			  
			  logger.logError("container count should not exceed CRO count");
			  
		  }
	  }else{
		  
		  ngDialog.close();
		  
		  $scope.quotation.quotationDtl=$scope.loadList;
	  }
		  
	  

  
  }
	  $scope.apply = function(detailDate){
			for(var i=0;i<$scope.quotation.quotationDtl.length;i++){
				$scope.quotation.quotationDtl[i].gateOutDate = detailDate;

			}
		
		}
     
     
	  // Upload container
  
	  $scope.uploadContainer =function(){
			 ngDialog.open({
	                template : 'uploadContainer',
	                scope :$scope
	            });
			}
	  
	  $scope.uploadContainer1 = function() {
			// loader.start();
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
								url : $stateParams.tenantid+'/app/gateOut/uploadContainerExcel',
								data : frmData,
								contentType : false,
								processData : false,
								success : function(response) {
									// loader.complete();
			                            if (response.success==true) {
			                            	
			                            	$scope.quotation.popUpDtlold = $scope.quotation.popUpDtl
			                            	$scope.tempList =[]
			                            	$scope.quotation.popUpDtlnew=[]
			                            	$scope.quotation.popUpDtl=[]
			                            	
			                            	if(response.quotationinnerDtl.length>0){
			                            		for(var i=0;i<$scope.quotation.popUpDtlold.length;i++){
			                            			for(var j=0;j<response.quotationinnerDtl.length;j++){
			                            				if(response.quotationinnerDtl[j].containerNo == $scope.quotation.popUpDtlold[i].containerNo){
			                            					
			                            					$scope.quotation.popUpDtl.push($scope.quotation.popUpDtlold[i])
			                            					//$scope.tempList.push($scope.quotation.popUpDtlold[i])
			                            				}
			                            				
			                            			}
			                            			
			                            		}
			                            		
			                            //		$scope.quotation.popUpDtlnew.push($scope.tempList);
			                            		
			                            //		$scope.quotation.popUpDtl = $scope.quotation.popUpDtlnew;
			                            		
			                            	ngDialog.close();
			          				          ngDialog.open({
			          				              template : 'views/operation/gateOut/gateOutPopUp',
			          				              scope : $scope,
			          				              closeByEscape: true
			          				    });
			          				          
			          				       // $scope.quotation.popUpDtl.push($scope.quotation.popUpDtlnew);
			                            	}
			                            	/*for(var j=0;j<response.membersList.length;j++){
			                            		$scope.containerMovementMaster.nextmoveDtlBean.push(response.membersList[j])
			                            	}
			                            	        
			                            	$scope.rowCollection1=$scope.containerMovementMaster.nextmoveDtlBean;*/
			                            	            
			                            	        

			                                logger.logSuccess("Container data's Uploaded Successfully");
			                            //    $scope.closeUpload();
			                              
			                            }else if(response.success==false)
			                            	{
			                            	
			                            	// $scope.containerMovementMaster.nextmoveDtlBean.push(response.membersList);

			                            //	logger.logError("Container already used");
			                            	
			                            	for (var i = 0; i < response.errorList.length; i++) {
			                                    logger.logError(response.errorList[i]);
			                                    $scope.closeUpload();
			                                }
			                            	}
			                            else if (response.errorList.length > 0) {
			                                

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
	 $scope.selectallRec = function(selection) {
			angular.forEach($scope.quotation.quotationDtl, function(
					value, key) {
				debugger;
				if (selection)
					value.select = true;
				else {
					value.select = false;
				}
			});
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
		$scope.tablerow = [];
		for (var index = 0 ; index < 1; index++) {
		angular.forEach($scope.quotation.sealDtl,function(row, index) {
					var check = row.select;
					
					if (check == undefined || check == "" ) {
						$scope.tablerow.push(row);
					} else if(index > 0){
						$scope.quotation.sealDtl = $scope.tablerow;

					}
				});
		}
	};
	
	

	/*
	$scope.dropoffList=[
		 
		  { id: 'ROAD', text: 'ROAD' },
		  { id: 'RAIL', text: 'RAIL' }
		
	]
*/
	$scope.typeList=[
		 
		  { id: 'Export', text: 'Export' },
		  { id: 'Import', text: 'Import' }
		
	]
	

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
	
	$scope.checkValidation1 = function() {

	    var alertmsg = "<ui><h4 backgroundcolor=green>Please fill the required fields</h4>";
	    var msg = "";
	
	    if($scope.quotation.type=="Export"){
	    
	    if ($scope.checkundefined($scope.quotation.croNo)) {
	        msg = msg + "<li>please select CRO number.</li>";         
	        $scope.changecolor('customer_id');
	    }else{
	    	$scope.clearcolor('customer_id');
	    }
	}else{
	    if ($scope.checkundefined($scope.quotation.doNo)) {
	        msg = msg + "<li>please select D.O. number.</li>";         
	        $scope.changecolor('customer_id');
	    }else{
	    	$scope.clearcolor('customer_id');
	    }
}
	    
	    
	    
	 	    
	    alertmsg = alertmsg + msg + "</ui>";
	    if ($scope.checkundefined(msg)) {
	        return '';
	    } else {
	        return alertmsg;
	    }

	}

	
	//Export Excel
	
	
	$scope.excelexport=function(gateOutNo){
		
		debugger
		//$http.post($stateParams.tenantid+'/app/gateOut/excelexport',$scope.quotation).success(function(datas){
			$http.post($stateParams.tenantid+'/app/gateOut/excelexport?gateOutNo='+gateOutNo).success(function(datas){
			debugger;
            $("#gateOutExport").bind('click', function() {
            });
            $('#gateOutExport').simulateClick('click');
            logger.logSuccess("Exported Successfully!");
       /* }else{
            logger.logError("Failed to export");
        }*/
     }).error(function(result) {
         console.log("data" + result);
		});


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
	    if($scope.quotation.type=="Export"){
	    if ($scope.checkundefined($scope.quotation.croNo)) {
	        msg = msg + "<li>croNo :Field is required.</li>";         
	        $scope.changecolor('customer_id');
	    }else{
	    	$scope.clearcolor('customer_id');
	    }
	    }
	    
	    if ($scope.checkundefined($scope.quotation.releaseDate)) {
	        msg = msg + "<li>Gate Out Date :Field is required.</li>";         
	        $scope.changecolor('service');
	    }else{
	    	$scope.clearcolor('service');
	    }
	    
	    
	    /*if ($scope.checkundefined($scope.quotation.croDate)) {
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
	   */
	    
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
	  
	  	    angular.forEach($scope.quotation.quotationDtl, function(chargesDetail, index) {     
	        if ($scope.checkundefined(chargesDetail.conType)) {
	            msg = msg + "<li>Row :" + (index + 1) + "# container Type :Field is required.</li>";
	            //$scope.changecolor('chargeHeads'+index);
	        }else{
	        	$scope.clearcolor('chargeHeads'+index);
	        }
	        if ($scope.checkundefined(chargesDetail.containerNo)) {
	            msg = msg + "<li>Row :" + (index + 1) + "# Container No :Field is required.</li>";
	            $scope.changecolor('unit'+index);
	        }else{
	        	$scope.clearcolor('unit'+index);
	        }
	        if ($scope.checkundefined(chargesDetail.gateOutDate)) {
	            msg = msg + "<li>Row :" + (index + 1) + "# Gate Out Date :Field is required.</li>";
	            $scope.changecolor('unit'+index);
	        }/*else{
	        	$scope.clearcolor('unit'+index);
	        	var pastsevenDay = new Date();

	            var startDate=pastsevenDay.getDate()+"/"+(pastsevenDay.getMonth()+1)+"/"+pastsevenDay.getFullYear();
	            var dayBeforeNineDays=moment().subtract(7, 'days').format('DD/MM/YYYY');
	            startDate=dayBeforeNineDays;
	            
	        	var pastsevenDay = startDate;
	        	 var t = moment(chargesDetail.gateOutDate,"DD/MM/YYYY").isSameOrBefore(moment(pastsevenDay, 'DD/MM/YYYY'));
	             if(t == true){
	 	            msg = msg + "<li>Row :" + (index + 1) + "# Gate Out Date should be within past seven days from current date.</li>";
	             }
	    
	        }*/
	        
	        
	       /* if ($scope.checkundefined(chargesDetail.depot)) {
	            msg = msg + "<li>Row :" + (index + 1) + "# Depot :Field is required.</li>";
	            $scope.changecolor('qty'+index);
	            $('#qty'+index).find('input').css("border-color", "red");

	        }  else{
	        	//$('#qty'+index).find('input').css("border-color", "#e8dddd");
	        	$scope.clearcolor('qty'+index);
	        }  
	        if ($scope.checkundefined(chargesDetail.allocDate)) {
	            msg = msg + "<li>Row :" + (index + 1) + "# Alloc Date :Field is required.</li>";
	            $scope.changecolor('qty'+index);
	            $('#qty'+index).find('input').css("border-color", "red");

	        }  else{
	        	//$('#qty'+index).find('input').css("border-color", "#e8dddd");
	        	$scope.clearcolor('qty'+index);
	        }    
	        */
	        
	       /* if ($scope.checkundefined(chargesDetail.rate)) {
	            msg = msg + "<li>Row :" + (index + 1) + "# Rate :Field is required.</li>";
	        }  
	        if ($scope.checkundefined(chargesDetail.paymentMethod)) {
	            msg = msg + "<li>Row :" + (index + 1) + "# Payment Method :Field is required.</li>";
	        }  
	        if ($scope.checkundefined(chargesDetail.currency)) {
	            msg = msg + "<li>Row :" + (index + 1) + "# Currency :Field is required.</li>";
	        }  
	        if ($scope.checkundefined(chargesDetail.transactionType)) {
	            msg = msg + "<li>Row :" + (index + 1) + "# Transaction Type :Field is required.</li>";
	        }  
	        if ($scope.checkundefined(chargesDetail.buySell)) {
	            msg = msg + "<li>Row :" + (index + 1) + "# Buy Sell:Field is required.</li>";
	        }  
	        */
	        
	        
	    });
	  	    
	 	    
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
			$scope.saveButtonDisble = true;
        if($scope.quotation.quotationDtl.length>0){
        	/*if($scope.quotation.quotationDtl.length<=$scope.quotation.countTotal){*/
        	
        	var obj = $scope.quotation;
        	 $http.post($stateParams.tenantid+'/app/gateOut/ContainerStatusDateList',obj).success(function(datas) {
				   debugger
			          console.log(datas);
				          $scope.StatusDate = datas;
				          var chk=true;
				          if($scope.StatusDate.length>0){
				     	 for(var i=0;i< $scope.StatusDate.length;i++){
				     		 
				     				
				     		 var t = moment($scope.StatusDate[i].previousStatusDate,"DD/MM/YYYY HH:mm").isSameOrBefore(moment($scope.quotation.releaseDate, 'DD/MM/YYYY HH:mm'));
				             /*if(t == false){
				             logger.logError("Row ("+(i+1)+") Gate Out Should be Greater than Previous Status Date !!!  The Previous Status Date is: "+$scope.StatusDate[i].previousStatusDate+"");
				             $scope.saveButtonDisble = false;
				             chk=false;
				             }*/
				             
				     	 }
				          }
				             if(chk){
				            	 $scope.saveButtonDisble = true;
				            		$http.post($stateParams.tenantid+'/app/gateOut/save',$scope.quotation).success(function(datas) {
				        				debugger
				        				  if(datas.success==true){					 
				        					  logger.logSuccess("Saved Successfully!");
				        					  $scope.saveButtonDisble = true;
				        					 $state.go('app.operation.gateOut.list',{tenantid:$stateParams.tenantid});
				        				        

				        				}else{
				        					  logger.logError(datas.message);
				        					  $scope.saveButtonDisble = false;
				        				  }
				        				}).error(function(data) {
				        					logger.logError("Please try again");
				        					$scope.saveButtonDisble = false;
				        				});
				             }
				     	
			          }).error(function(datas) {
			      });
        	  
        
		
        	/*}
        	else{
        		
        		logger.logError("Detail count exceeds CRO Count");
        	}*/
        	}else{
        	logger.logError("Atleast One Row Required");
        	$scope.saveButtonDisble = false;
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
		if(!$scope.checkundefined(msg)){//
			logger.logError(msg);
		}else{
			 if($scope.quotation.quotationDtl.length>0){
				 /*if($scope.quotation.quotationDtl.length<=$scope.quotation.countTotal){*/
			$http.post($stateParams.tenantid+'/app/gateOut/update',$scope.quotation).success(function(datas) {
				  if(datas.success==true){					
					  
					  logger.logSuccess("Updated Successfully!");
					  $state.go('app.operation.gateOut.list',{tenantid:$stateParams.tenantid});

				  }else{
					  logger.logError(datas.message);
				  }
				}).error(function(data) {
					logger.logError("Please try again");
				});
			
				 /*}
				 else{
		        		
		        		logger.logError("Detail count exceeds CRO Count");
		        	}*/
			 
			 }else{
		        	logger.logError("Atleast One Row Required");
		        }
		}
		
		
	}
	$scope.cancel=function(){
	
		$state.go('app.operation.gateOut.list',{tenantid:$stateParams.tenantid});
	}
	
	
    $scope.$watch('quotation.bookingNo', function(newValue, oldValue) {
    	if($scope.edit==false){
        if (newValue != '' && newValue != undefined) {
        	$scope.quotation.bookingNo=newValue;
        	console.log("$scope.quotation.bookingNo1123",$scope.quotation.bookingNo)
        	$http.post($stateParams.tenantid+'/app/gateOut/getcroNo?bookingNo='+$scope.quotation.bookingNo).success(function(datas) {
        		console.log("getcroNo1233",datas);
        		$scope.croList=datas.croList;
    		
    		}).error(function(datas) {

    		});
        } }
    });
    $scope.$watch('quotation.bookingNo', function(newValue, oldValue) {
    	if($scope.edit==true){
        if (newValue != '' && newValue != undefined) {
        	$scope.quotation.bookingNo=newValue;
        	console.log("$scope.quotation.bookingNo1123",$scope.quotation.bookingNo)
        	$http.post($stateParams.tenantid+'/app/gateOut/getcroNo?bookingNo='+$scope.quotation.bookingNo).success(function(datas) {
        		console.log("getcroNo1233",datas);
        		$scope.croList=datas.croList;
    		
    		}).error(function(datas) {

    		});
        }
    	}
    });

    $scope.$watch('quotation.croNo', function(newValue, oldValue) {
    	if($scope.edit==false){
        if (newValue != '' && newValue != undefined) {
        	$scope.croId=newValue;
        	$http.post($stateParams.tenantid+'/app/gateOut/getcrodetail',$scope.croId).success(function(datas) {
        		
        		if(datas.success){
        		
        		$scope.quotation.bookingNo=datas.seaQuotationBean.bookingNo;

        		$scope.quotation.customer=datas.seaQuotationBean.customer;
        		
        		$scope.quotation.depot=datas.seaQuotationBean.depot;
        		$scope.quotation.vessel=datas.seaQuotationBean.vessel;
        		$scope.quotation.voyage=datas.seaQuotationBean.voyage;

        		$scope.quotation.countTotal=datas.seaQuotationBean.countTotal;
        		}
        		else{
        			
        			$scope.quotation.croNo=oldValue;
        			logger.logError(newValue+" "+datas.message);	
        			
        		}
        		
    		
    		}).error(function(datas) {

    		});
        } }
    });
    
    $scope.$watch('quotation.doNo', function(newValue, oldValue) {
    	if($scope.edit==false){
        if (newValue != '' && newValue != undefined) {
        	$scope.croId=newValue;
        	$http.post($stateParams.tenantid+'/app/gateOut/DOdetail',$scope.croId).success(function(datas) {
        		
        		if(datas.success){
        			
        			
        		
        		/*$scope.quotation.bookingNo=datas.seaQuotationBean.bookingNo;*/

        		$scope.quotation.customer=datas.seaQuotationBean.customer;
        		//$scope.quotation.gateoutnoE=datas.seaQuotationBean.gateoutnoE;
        		$scope.quotation.depot=datas.seaQuotationBean.depot;
        		$scope.quotation.disDate=datas.seaQuotationBean.disDate;
        		$scope.quotation.vessel=datas.seaQuotationBean.vessel;
        		$scope.quotation.voyage=datas.seaQuotationBean.voyage;
        		/*$scope.quotation.countTotal=datas.seaQuotationBean.countTotal;*/
        		}
        		else{
        			
        			/*$scope.quotation.croNo=oldValue;*/
        			logger.logError(newValue+" "+datas.message);	
        			
        		}
        		
    		
    		}).error(function(datas) {

    		});
        } }
    });
    
    
    $scope.$watch('quotation.type', function(newValue, oldValue) {
    	if($scope.edit==false){
        if (newValue != '' && newValue != undefined) {
        	
        	$scope.quotation.bookingNo='';

    		$scope.quotation.customer='';
    		
    		$scope.quotation.depot='';
    		
    		$scope.quotation.countTotal='';
        	
        	
        	
        	
        } }
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