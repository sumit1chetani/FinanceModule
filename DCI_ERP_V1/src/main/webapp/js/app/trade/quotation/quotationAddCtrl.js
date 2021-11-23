'use strict';
app.controller('quotationAddCtrl', function($scope, $timeout, $stateParams,sharedProperties,toaster,
		$filter, $rootScope, $http, $location, logger, $state, ngDialog,$controller,$injector,utilsService,$window) {
	$scope.quotationTypeList=[];
	$scope.customerDropList = [];
	$scope.consigneeDropList  = [];
	$scope.shipmentList  = [];
	$scope.SpecialList  = [];
	$scope.cargoType  = [];
	$scope.nominatedDropList  = [];
	$scope.vendorDropList = [];
	$scope.serviceParnrDropList = [];
	$scope.portList=[];
	$scope.currencyList=[];
	$scope.shipmentTermlist=[];
	$scope.createQuote=false;

	var bookingDate = $stateParams.bookingDate;
	var mloCode = $stateParams.mloCode;
	var lolId = $stateParams.lolId;
	var lodId = $stateParams.lodId;
	var bookingId= parseInt($stateParams.bookingId);
	
	$scope.edit=false;
	$scope.copy=false;

	
	$scope.checkAll = function(){ 

		angular.forEach($scope.quotation.quotationDtl, function(chargesDetail, index) { 
		if($scope.quotation.checkAll==true){

		chargesDetail.select=true;

		}else{

		chargesDetail.select=false;

		}



		});
		}
	
	$scope.checkAllFreeDays = function(){ 

		angular.forEach($scope.quotation.quotationFreeDaysDtl, function(chargesDetail, index) { 
		if($scope.quotation.checkAllFreeDays==true){

		chargesDetail.select=true;

		}else{

		chargesDetail.select=false;

		}



		});
		}
	



		//check for seal 
$scope.loadAllPorts = function (val){
		if(!val){
			 $http.post($stateParams.tenantid+'/app/commonUtility/getPortByEmpAgn').success(function(data) {
				  	
					$scope.polList=data;
					        		
			});
		}
		else{
			$http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(datas) {
				  $scope.polList=datas.getportlist;
			}).error(function(datas) {

			});
		}
	}
		$scope.checkAll1 = function(){ 

		angular.forEach($scope.quotation.sealDtl, function(chargesDetail, index) { 
		if($scope.quotation.check1==true){

		chargesDetail.select=true;

		}else{

		chargesDetail.select=false;

		}



		});
		}
	


	$scope.shipmentTermlist = [
	     {id: '1', text: 'Collect'},
	    {id: '2', text: 'Prepaid'},
	    {id: '3', text: 'Third Party Collect'}
	  ];
	

	
	$scope.cargoType = [
	     {id: '1', text: 'COCO'},
	    {id: '2', text: 'Coir'}
	  ];

	
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
			currencyName : 'USD',
			term : '',
			commodity : '',
			consignee : '',
			nominatedBy : '',
			validityDate : '',
			remarks : '',
			vessel :'',
			dimensionName:'',
			rejectRemarks :'',
			approveRemarks:'',
			allowOtherPort : false,
			soc : false,
			checkDate:'',
			rrnumber: '',
			detentionTariffType:'SC0009',
			quotationDtl:[{id:0,chargeHeads:'',unit:'',currency:'',qty:'',rate:'',localCurrency:'',paymentMethod : '',transactionType : '',buySell : '',note : '',freeDays:0}],
			quotationDtlCopy:[{id:0,chargeHeads:'',unit:'',currency:'',qty:'',rate:'',localCurrency:'',paymentMethod : '',transactionType : '',buySell : '',note : '',freeDays:0}],
			quotationFreeDaysDtl : [{id:0,conType:'',polFreeDays:'',podFreeDays:''}]
			/*quotationFreeDaysDtl : []*/
	}

	
	
	if($rootScope.quotationfromRR != null){
		$scope.quotation = $rootScope.quotationfromRR;
		
		
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
	
	$scope.$watch('quotation.validTill',function(newvalue, oldvalue) {
		debugger;
				if ($scope.quotation.validTill != null
						&& $scope.quotation.validTill != '' 
						&& $scope.quotation.quotationDate != null
						&& $scope.quotation.quotationDate != "") {
					var requestDtAry = $scope.quotation.validTill.split('/');
					var oldDateAry = $scope.quotation.quotationDate.split('/');
					var requestDtObj = new Date(
							requestDtAry[2],
							requestDtAry[1] - 1,
							requestDtAry[0]);
					var oldDateObj = new Date(
							oldDateAry[2],
							oldDateAry[1] - 1,
							oldDateAry[0]);
					
					if (requestDtObj < oldDateObj) {
						$scope.quotation.validTill ="";
						logger.logError("Quote Validity Date should be greater than quotation Date - "+$scope.quotation.quotationDate+" ..!!");
					}
	
				}
	});
	
	  $scope.getdropdown = function() {
		  
			$http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(datas) {
					  $scope.shipmentList=datas.getshipmentlist;
					  $scope.portList=datas.getportlist;
					  $scope.customerDropList=datas.getcustomerlist;
					  $scope.currencyList=datas.getcurrencylist	;
					  $scope.conTypeList=datas.getcontypelist;
					   $scope.chargeTypeList=datas.getchargetypelist
					//logger.logSuccess('Mail Sent Successfully!')
				}).error(function(datas) {

				});
			
			  //Category
			  $http.post($stateParams.tenantid+'/app/commonUtility/getCustomerCateory').success(function(data) {
			  	
					$scope.CustList=data.customercategory;
					        		
			});
			  
			  
			  $http.post($stateParams.tenantid+'/app/commonUtility/getPortByEmpAgn').success(function(data) {
				  	
					$scope.polList=data;
					        		
			});
			  $http.post($stateParams.tenantid+'/app/commonUtility/getSpecialList').success(function(data) {
				  	
					$scope.SpecialList=data;
					        		
			});
			 
			  }
			  $scope.getdropdown(); 
			  
			  $http.post($stateParams.tenantid+'/app/detection/getTariffList').success(function(data) {
			      	
			  		$scope.tariffList=data; 
			  		        		
			     });
	
	$scope.edit=true;
	$scope.quoteNo=$location.search().quotationNo;
	
	if($scope.quoteNo != '' && $scope.quoteNo!=undefined){
		
/*		$scope.customerDropList =[];

		var obj ={
				"condition" : "select distinct agre_party_id from quotation_hdr  where quotation_no ='"+$scope.quoteNo+"'"
		}
		$http.post($stateParams.tenantid+ '/app/commonUtility/getCustomerListFilter',obj).success(function(data1) {
			console.log(data1);
			$scope.customerDropList = data1;

		});*/
		var quoteNo = $scope.quoteNo;
		 $http.get($stateParams.tenantid+ '/app/quotation/getCustomereditDropdown?quoteNo=' +quoteNo).success(function(data1) {
				console.log(data1);
				$scope.customerDropList1 = data1;
		  
			});
   		
		$http.post($stateParams.tenantid+'/app/quotation/edit',$scope.quoteNo).success(function(datas) {
		
			$scope.quotation=datas.seaQuotationBean;
			$scope.quotation.checkDate = datas.seaQuotationBean.validTill;
			$scope.quotation.quotationDtl=datas.lQuotationBean;
			$scope.quotation.quotationFreeDaysDtl=datas.quotationFreeDaysDtl;
			$scope.freedays=$scope.quotation.quotationFreeDaysDtl;
			$scope.edit=true;
		
		}).error(function(datas) {

		});
		
		
	}
	  var tt = $location.path().split("/")[5]||"editforQuotationDate";
	$scope.$watch('quotation.validTill',function(newvalue, oldvalue) {
		if(tt == 'editforQuotationDate'){
		if ($scope.quotation.validTill != null
				&& $scope.quotation.validTill != '' ){
			var frmDate = $scope.quotation.checkDate;
			var toDate = $scope.quotation.validTill;
			var splitarray = new Array();
			var splitarray1 = new Array();
			splitarray = frmDate.split(" ");
			var date = splitarray[0];
			var time = splitarray[1];

			frmDate = date.split("/");
			frmDate = new Date(frmDate[2],frmDate[1] - 1, frmDate[0]);


			splitarray1 = toDate.split(" ");
			var date1 = splitarray1[0];
			var time1 = splitarray1[1];


			toDate = date1.split("/");
			toDate = new Date(toDate[2],toDate[1] - 1, toDate[0]);
			if(  frmDate > toDate  ){
				logger.logError("Extention of Quotation Date is not allowed!!");
				$scope.quotation.validTill ='';
			}	
		}else{
		}
	}
	});
    
	$scope.$watchCollection('[quotation.pol,quotation.currencyName]',function(newValue, oldValue) {
	        if ($scope.quotation.pol != '' && $scope.quotation.pol != undefined && $scope.quotation.currencyName != '' && $scope.quotation.currencyName != undefined  && $scope.edit == false  && $scope.copy == false) {
//	        	$scope.custId=newValue;
	        	$http.post($stateParams.tenantid+'/app/quotation/getdefaultchargeList?pol='+$scope.quotation.pol+'&crnyName='+$scope.quotation.currencyName).success(function(datas) {
	        		if(datas.length>0)
	        		$scope.quotation.quotationDtl=datas;
//	        		$scope.quotation.custcategory=datas.seaQuotationBean.custcategory;
	    		
	    		}).error(function(datas) {

	    		});
	        } else {
	      /*      $scope.freightReport.voyage = '';
	            $scope.voyageList = [];*/
	          
	        }
	    });
	
	
//	if($scope.edit == false){
//		
//		$http.post($stateParams.tenantid+'/app/quotation/getdefaultchargeList').success(function(data) {
//			
//			
//			$scope.test=data;			
//			$scope.quotation.quotationDtl = [];
//		
//
//			//freight charges
//			for(var i=0;i<$scope.test.length;i++){			
//				
//						
//						$scope.max = Math.max.apply(Math, $scope.quotation.quotationDtl.map(function(item) {
//							return item.id;
//						}));
//				
//				$scope.max = $scope.max + 1;
//				var chargedata = {
//					id : $scope.max,
//					chargeHeads : '',
//					unit : '',
//					currency : '',
//					qty : '',
//					rate : '',
//					currencyList : angular.copy($scope.currencylist),
//					paymentMethod : '',
//					transactionType : '',
//					buySell : '',
//					note : ''
//				};
//		
//				$scope.quotation.quotationDtl.push(chargedata);
//				$scope.quotation.quotationDtl[i].chargeType = $scope.test[i].chargeCode;
//				$scope.quotation.quotationDtl[i].tariff = $scope.test[i].tariff;
//				var len = $scope.quotation.quotationDtl.length - 1;
//				$timeout(function() {
//					hideActivePapers($scope.max + "0", []);
//				}, 1000);
//				
//				
//				
//				
//			}
//			
//			
//		}).error(function(datas) {
//
//		});
//		
//	}
	
	
	
	
	/*$scope.$watchCollection('[quotation.pol,quotation.pod]',function(newValue, oldValue) {
		if (newValue[0] != '' && newValue[0] != undefined && newValue[1] != '' && newValue[1] != undefined) {
			
			if($scope.edit == false){
			
			$http.post($stateParams.tenantid+'/app/quotation/getChargeList?pol=' +newValue[0]+ '&pod=' +newValue[1]).success(function(data) {
			  	
				$scope.test=data;
				console.log($scope.test);
				$scope.quotation.quotationDtl = [];
			

				//freight charges
				for(var i=0;i<$scope.test.length;i++){			
					
							
							$scope.max = Math.max.apply(Math, $scope.quotation.quotationDtl.map(function(item) {
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
					$scope.quotation.quotationDtl[i].chargeType = $scope.test[i].chargeCode;
					var len = $scope.quotation.quotationDtl.length - 1;
					$timeout(function() {
						hideActivePapers($scope.max + "0", []);
					}, 1000);
					
					
					
					
				}
			});
			
		}
		}
		
	});*/
	

	
	
	//reject
	$scope.reject = function(quotationNo) {	
		 $scope.quotationNew = {
	        		quotationNo : '',
	        		rejectRemarks : '' 
	        };
		    $scope.quotationNew.quotationNo =  quotationNo;
             $scope.quotationNew.rejectRemarks =  '';
         ngDialog.open({
             scope : $scope,
             template : 'views/sales/quotation/quotationRejectRemarks',
             controller : $controller('quotationRejectCtrl', {
                 $stateParams :$stateParams,
                 $scope : $scope, 
                 $rootScope :$rootScope, 
                 $http:$http, 
                 $location:$location,
                 logger:logger, 
                 utilsService:utilsService, 
                 $state:$state, 
                 $window:$window,
                 preCloseCallback : $scope.getList
             }),
             showClose : false,
             closeByDocument : false,
             closeByEscape : false 
         });
		
 	};
 	
 	//Approval
	$scope.approve = function(quotationNo) {	
		 $scope.quotationNew = {
	        		quotationNo : '',
	        		approveRemarks : '' 
	        };
		    $scope.quotationNew.quotationNo =  quotationNo;
             $scope.quotationNew.approveRemarks =  '';
         ngDialog.open({
             scope : $scope,
             template : 'views/trade/quotation/quotationApprovalRemarks',
             controller : $controller('quotationApprovalCtrl', {
                 $stateParams :$stateParams,
                 $scope : $scope, 
                 $rootScope :$rootScope, 
                 $http:$http, 
                 $location:$location,
                 logger:logger, 
                 utilsService:utilsService, 
                 $state:$state, 
                 $window:$window,
                 preCloseCallback : $scope.getList
             }),
             showClose : false,
             closeByDocument : false,
             closeByEscape : false 
         });
		
 	};
	 
	// reVIew
	$scope.reView = function(quotationNo) {
	    $location.url($stateParams.tenantid+'/trade/quotationApproval/review?quotationNo=' + quotationNo);
	};
	
	$scope.SubmitreView = function(quotation){
		
		$http.post($stateParams.tenantid+'/app/quotation/savereview',$scope.quotation).success(function(datas) {
		if(datas.success){
			  logger.logSuccess("Saved Successfully!");
			    $location.url($stateParams.tenantid+'/trade/quotationApproval/view?quotationNo=' + $scope.quotation.quotationNo);


		}else{
			  logger.logError("Error in Save!");

		}
		});
	}

 	//Approval
	$scope.approve = function(quotationNo) {	
		 $scope.quotationNew = {
	        		quotationNo : '',
	        		approveRemarks : '' 
	        };
		    $scope.quotationNew.quotationNo =  quotationNo;
             $scope.quotationNew.approveRemarks =  '';
         ngDialog.open({
             scope : $scope,
             template : 'views/trade/quotation/quotationApprovalRemarks',
             controller : $controller('quotationApprovalCtrl', {
                 $stateParams :$stateParams,
                 $scope : $scope, 
                 $rootScope :$rootScope, 
                 $http:$http, 
                 $location:$location,
                 logger:logger, 
                 utilsService:utilsService, 
                 $state:$state, 
                 $window:$window,
                 preCloseCallback : $scope.getList
             }),
             showClose : false,
             closeByDocument : false,
             closeByEscape : false 
         });
		
 	};
	  
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
	            
	            $http.post($stateParams.tenantid+'/app/quickLink/getBookingNo',$scope.quoteNo).success(function(result) {
	                console.log(result);
	                $scope.bookingNo=result.id;
	                $location.url($stateParams.tenantid+$scope.qlLink + $scope.bookingNo);
	                 
	                }).error(function(datas) {
	            });

	        }
	   });
	 
	$scope.$watchCollection('[quotation.quotationDate]',function(newValue, oldValue) {
		if ($scope.quotation.quotationDate != '') {
			var frmDate = today;
			var toDate = $scope.quotation.quotationDate;
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
				logger.logError("Quotation Date should be less or equal to current date");
				$scope.quotation.quotationDate = "";
			}
		}
	});  

	


    $scope.checkundefined = function(value) {
	    var invalid = false;
	    if (value == undefined || value == 'undefined' || value == null || value == 'null' || value == '') {
	        invalid = true;
	    }
	    return invalid;

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
	

	  $rootScope.uploadFile = function(element) {
		  $scope.excelfile = element.files;
	        $scope.adduploadfiles();
	    }
	    $scope.files = [];
	    $scope.quotation.files= [];
	    $scope.adduploadfiles = function() {
	    	debugger
	        var obj = []

	        if ($scope.checkundefined1($scope.excelfile)) {
	            logger.logError("Please select the file");
	        } else {
	            obj = $filter('filter')($scope.quotation.files, {
	                filename : $scope.excelfile.name
	            }, true);
	        }

	        if (obj != undefined && obj.length > 0) {
	            logger.logError($scope.excelfile.name + " same file already added");
	        } else {$timeout(function() {
	        	for( var i=0;i<$scope.excelfile.length;i++){
		            $scope.files.push($scope.excelfile[i]);
		            $scope.quotation.files.push({
		                filename : $scope.excelfile[i].name,
		                filepath : '',
		                quotation : ''
		            });
		        	}
		        	 },200);
	        }

	    }
	    
	    $scope.deleteuploadfiles = function(filename) {
	        $scope.tempfiles = [];
	        $scope.tempfilename = [];
	        angular.forEach($scope.files, function(row, index) {
	            if (filename != row.name) {
	                $scope.tempfiles.push(row);
	            }

	        });

	        angular.forEach($scope.quotation.files, function(value, index) {
	            if (filename != value.filename) {
	                $scope.tempfilename.push(value);
	            }

	        });
	        $scope.files = $scope.tempfiles;
	        $scope.quotation.files = $scope.tempfilename;
	        
	        
	       /* $http.post($stateParams.tenantid+'/app/airquotation/deleteFiles', filepath).success(function(result) {
	               
            })
*/
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
			note : '',
			tariff : 0
		};

		$scope.quotation.quotationDtl.push(chargedata);
		var len = $scope.quotation.quotationDtl.length - 1;
		$timeout(function() {
			hideActivePapers($scope.max + "0", []);
		}, 1000);
		$scope.quotation.checkAll=false;
	}
	
	$scope.addRowFreeDays = function() {
 
 		var chargedata = {
 				conType : '',
 				polFreeDays : '',
 				podFreeDays : '',
 				polFreeDays1 : '',
 				podFreeDays1 : ''
		};

		$scope.quotation.quotationFreeDaysDtl.push(chargedata);
   	}
	
	$scope.removeRowFreeDays  = function() {
		$scope.tablerow = [];
		for (var index = 0 ; index < 1; index++) {
		angular.forEach($scope.quotation.quotationFreeDaysDtl,function(row, index) {
					var check = row.select;
					
					if (check == undefined || check == "" ) {
						$scope.tablerow.push(row);
					} else if(index > 0){
						$scope.quotation.quotationFreeDaysDtl = $scope.tablerow;

					}
				});
		}
	};
	
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
		
		$scope.checkFreedays();
	};
	
$scope.checkFreedays = function(){
		
		$scope.tempList=[]
		
		if($scope.quotation.quotationDtl.length != 0){
			for(var j=0;j<$scope.quotation.quotationDtl.length;j++){
				if($scope.quotation.quotationDtl[j].conType!= '' && $scope.quotation.quotationDtl[j].conType!= undefined){
					var period = {
							conType:$scope.quotation.quotationDtl[j].conType,
							polFreeDays:'',
							podFreeDays : '', 
							
							};
						$scope.tempList.push(period);
					
					
					
				}
			}
				
		}

//$scope.tempList = $scope.quotation.quotationDtl
		
		$scope.result = $scope.tempList.filter(function (a) {

			var key = a.conType ;
			if (!this[key]) {
			this[key] = true;
			return true;
			}
			}, Object.create(null));
			
			
		if($scope.edit==false){
			$scope.quotation.quotationFreeDaysDtl=[];
			
			for(var j=0;j<$scope.result.length;j++){
	//			if($scope.result.conType[j]!= '' || $scope.result[j].conType!= undefined){
					
					var chargedata = {
			 				conType : $scope.result[j].conType,
			 				polFreeDays : '',
			 				podFreeDays : '',
			 				polFreeDays1 : '',
			 				podFreeDays1 : ''
					};

					$scope.quotation.quotationFreeDaysDtl.push(chargedata);
	//			}

				
	}
		}else{
			for(var j=0;j<$scope.freedays.length;j++){
				//			if($scope.result.conType[j]!= '' || $scope.result[j].conType!= undefined){
								
								var chargedata = {
						 				conType : $scope.freedays[j].conType,
						 				polFreeDays : $scope.freedays[j].polFreeDays,
						 				podFreeDays : $scope.freedays[j].podFreeDays,
								};

							//	$scope.quotation.quotationFreeDaysDtl.push(chargedata);
				//			}

							
				}
		}
	
		
	}
	
	/*$scope.removeCopyRow = function() {
		$scope.tableCopyrow = [];
		for (var index = 0 ; index < 1; index++) {
		angular.forEach($scope.quotation.quotationDtlCopy,function(row, index) {
					var check = row.select;
					if (check == undefined || check == "" ) {
						$scope.tableCopyrow.push(row);
					} else if (index > 0) {
						$scope.quotation.quotationDtlCopy = $scope.tableCopyrow;
					}
				});
		}
	};*/
	
	
	/*$scope.deleteIds = [];
		$scope.removeRow = function() {
			var len = $scope.quotation.quotationDtl.length;
			for (var index = len - 1; index < len; index--) {
				if ($scope.quotation.quotationDtl[index].select == true) {
					if ($scope.quotation.quotationDtl[index].id != null
							&& $scope.quotation.quotationDtl[index].id > 0) {
						$scope.deleteIds.push($scope.quotation.quotationDtl[index].id);
					}
					$scope.quotation.quotationDtl.splice(index, 1);
				}
			}
			$scope.addRow();
			var quotationDtl = {
					id:0,chargeHeads:'',unit:'',currency:'',qty:'',rate:'',paymentMethod : '',transactionType : '',buySell : '',note : ''
		} 
			$scope.quotation.quotationDtl.push(quotationDtl);
	};*/
	
	//$scope.deleteIds = [];
		/*$scope.removeRow = function() {
			var len = $scope.joborder.joborderDtl.length;
			for (var index = len - 1; index < len; index--) {
				if ($scope.joborder.joborderDtl[index].select == true) {
					if ($scope.joborder.joborderDtl[index].joborderDtlId != null
							&& $scope.joborder.joborderDtl[index].joborderDtlId > 0) {
						$scope.deleteIds
								.push($scope.joborder.joborderDtl[index].joborderDtlId);
					}
					$scope.joborder.joborderDtl.splice(index, 1);
				}
			}

	};*/
	/*
	$scope.customerDropList = [
		  { id: 11, text: 'Mr. Nice' },
		  { id: 12, text: 'Narco' },
		  { id: 13, text: 'Bombasto' },
		  { id: 14, text: 'Celeritas' },
		  { id: 15, text: 'Magneta' }
  ];*/
	
	
	$scope.dropoffList=[
		 
		  { id: 'ROAD', text: 'ROAD' },
		  { id: 'RAIL', text: 'RAIL' }
		
	]

	

    $scope.hdrData =  $scope.joborder;
    $scope.dtlData =  $scope.jobOrderDtl;
    $scope.reset = function () {
        $scope.joborder = $scope.hdrData;
        $scope.jobOrderDtl = $scope.dtlData;
    };
	$scope.modeList=[];
	$scope.getQuotationType = function() {
	    var  data = {};
	    data["id"] = "1";
	    data["text"] = "SEA";
	    $scope.modeList.push(data);
	    $scope.quotation.mode='1';
//	    data = {};
//	    data["id"] = "2";
//	    data["text"] = "SEA";
//	    $scope.modeList.push(data);
	}
	
	  $scope.$watch('quotation.customer', function(newValue, oldValue) {
	        if (newValue != '' && newValue != undefined) {
	        	$scope.custId=newValue;
	        	$http.post($stateParams.tenantid+'/app/quotation/getcustomerdetail',$scope.custId).success(function(datas) {
	        		
	        		$scope.quotation.address=datas.seaQuotationBean.address;
	        		$scope.quotation.custcategory=datas.seaQuotationBean.custcategory;
	    		
	    		}).error(function(datas) {

	    		});
	        } else {
	      /*      $scope.freightReport.voyage = '';
	            $scope.voyageList = [];*/
	          
	        }
	    });
	
	$scope.salesTypeList=[];
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
	 $scope.transactionTypeList=[];
	
//	$scope.getTransactionType = function() {
//	    var  data = {};
//	    data["id"] = "1";
//	    data["text"] = "BUY";
//	    $scope.transactionTypeList.push(data);
//	    data = {};
//	    data["id"] = "2";
//	    data["text"] = "SELL";
//	    $scope.transactionTypeList.push(data);  
//	    
//	    
//	  
//	}
//	$scope.getTransactionType();
	 $scope.quotation.mode='1';
	$scope.PaymentMethodList=[];
//	$scope.getpaymentMethod = function() {
//	    var  data = {};
//	    data["id"] = "1";
//	    data["text"] = "PREAPID TO COLLECT";
//	    $scope.PaymentMethodList.push(data);
////	    data = {};
////	    data["id"] = "2";
////	    data["text"] = "SELL";
////	    $scope.PaymentMethodList.push(data);  
//	    
//	    
//	  
//	}
//	$scope.getpaymentMethod();
	
	$scope.chargeList =[];
	$scope.dropdown=function(){/*
		$scope.getQuotationType();
		$http.post($stateParams.tenantid+'/app/seaquotation/getServicePartnerList').success(function(datas) {
			debugger
		//	 $scope.customerDropList = datas.customerList;
			 $scope.consigneeDropList = datas.consigneeList;
			 $scope.shipperDropList = datas.shipperList;
			 $scope.nominatedDropList = datas.nominatedList;
			 $scope.vendorDropList = datas.vendorList;
			 $scope.serviceParnrDropList=datas.serviceParnrList;
		  
		  
		}).error(function(data) {

		});
		$http.get($stateParams.tenantid+'/app/seaquotation/getiataList').success(function(datas) {
			debugger
		    $scope.portList = datas.commonUtilityBean;	    

		}).error(function(data) {

		});
		
		$http.get($stateParams.tenantid+'/app/seaquotation/getcommodity').success(function(datas) {
			
		    $scope.commodityList = datas.commonUtilityBean;	    

		}).error(function(data) {

		});
		
		
		$http.get($stateParams.tenantid+'/app/seaquotation/getBranch').success(function(datas) {
			 $scope.branchList = datas.commonUtilityBean;
		    
		}).error(function(data) {

		});
		$http.get($stateParams.tenantid+'/app/seaquotation/getCurrencyList').success(function(datas) {	  
			$scope.currencylist= angular.copy(datas.commonUtilityBean);
		}).error(function(data) {

		});
		
		$http.get($stateParams.tenantid+'/app/seaquotation/getServicePartnerType').success(function(datas) {	  
			$scope.servicePartnerTypelist= angular.copy(datas.commonUtilityBean);
		}).error(function(data) {

		});
		
		var serviceList = [ {
            id : '1',
            text : 'EXPORT'
        }, {
            id : '2',
            text : 'IMPORT'
        }]
		
		$scope.servicePartnerTypelist=serviceList;
		
		$http.get($stateParams.tenantid+'/app/seaquotation/getEmployeeList').success(function(datas) {
			 $scope.employeeList = datas.commonUtilityBean;
		    
		}).error(function(data) {

		});
		
		$http.get($stateParams.tenantid + '/app/airquotation/getSalesList')
		.success(function(datas) {
			$scope.salesTypeList = datas.commonUtilityBean;

		}).error(function(data) {

		});
		
		$http.get($stateParams.tenantid + '/app/airquotation/getServiceList')
		.success(function(datas) {
			console.log("test");
			console.log(datas);
			console.log("test");
			$scope.servicePartnerTypelist = datas.commonUtilityBean;

		}).error(function(data) {

		});
		
		var serviceList = [ {
            id : '1',
            text : 'EXPORT'
        }, {
            id : '2',
            text : 'IMPORT'
        }]
		
		$scope.servicePartnerTypelist=serviceList;
		
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
		
		$http.get($stateParams.tenantid+'/app/seaquotation/getChargeHeads').success(function(datas) {
			 $scope.chargeHeadList = datas.commonUtilityBean;
		    
		}).error(function(data) {

		});
		
		
		$http.get($stateParams.tenantid+'/app/seaquotation/getTerms').success(function(datas) {
			 $scope.TermList = datas.commonUtilityBean;
		    
		}).error(function(data) {

		});
		
		$http.get($stateParams.tenantid+'/app/seaquotation/getUnitList').success(function(datas) {
			 $scope.UnitList = datas.commonUtilityBean;
		    
		}).error(function(data) {

		});
		
		
		
	*/}
	$scope.editdata=function(quotation){/*
		
		
		$scope.getQuotationType();
		$http.post($stateParams.tenantid+'/app/seaquotation/getServicePartnerList').success(function(datas) {
			debugger
			$scope.customerDropList = datas.customerList;
			 $scope.consigneeDropList = datas.consigneeList;
			 $scope.shipperDropList = datas.shipperList;
			 $scope.nominatedDropList = datas.nominatedList;
			 $scope.vendorDropList = datas.vendorList;
			 $scope.serviceParnrDropList=datas.serviceParnrList;
		  
		

		}).error(function(data) {

		});
	*/}


	$scope.edit=false;
	if(!$scope.checkundefined($location.search().quotation)){
		$scope.editdata($location.search().quotation);
		$scope.edit=true;

	}else{
		$scope.edit=false;
		$scope.dropdown();
	}


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
	   /* if ($scope.checkundefined($scope.quotation.customer)) {
	        msg = msg + "<li>Customer:Field is required.</li>";         
	        $scope.changecolor('customer_id');
	    }else{
	    	$scope.clearcolor('customer_id');
	    }
	 */
	    if ($scope.checkundefined($scope.quotation.custcategory)) {
	        msg = msg + "<li>customer category :Field is required.</li>";         
	        $scope.changecolor('service');
	    }else{
	    	$scope.clearcolor('service');
	    }
	    
	    
	    if ($scope.checkundefined($scope.quotation.quotationDate)) {
	        msg = msg + "<li>quotationDate :Field is required.</li>";         
	        $scope.changecolor('aol');
	    }else{
	    	$scope.clearcolor('aol');
	    }
	    if ($scope.checkundefined($scope.quotation.pol)) {
	        msg = msg + "<li>pol :Field is required.</li>";         
	        $scope.changecolor('quotationDate');
	    }else{
	    	$scope.clearcolor('quotationDate');
	    }
	    if ($scope.checkundefined($scope.quotation.pod)) {
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
	    }
	    if ($scope.checkundefined($scope.quotation.currencyName)) {
	        msg = msg + "<li>Currency : Field is required.</li>";         
	        $scope.changecolor('aod');
	    }else{
	    	$scope.clearcolor('aod');
	    }
	    
	   /* if ($scope.checkundefined($scope.quotation.dropoff)) {
	        msg = msg + "<li>valid Till :Drop off is required.</li>";         
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
	  
	  	    angular.forEach($scope.quotation.quotationDtl, function(quotationDtl, index) {     
//	        if ($scope.checkundefined(chargesDetail.conType)) {
//	            msg = msg + "<li>Row :" + (index + 1) + "# container Type :Field is required.</li>";
//	            //$scope.changecolor('chargeHeads'+index);
//	        }else{
//	        	$scope.clearcolor('chargeHeads'+index);
//	        }
	       /* if ($scope.checkundefined(chargesDetail.chargeType)) {
	            msg = msg + "<li>Row :" + (index + 1) + "# charge Type :Field is required.</li>";
	            $scope.changecolor('unit'+index);
	        }else{
	        	$scope.clearcolor('unit'+index);
	        }
	        if ($scope.checkundefined(chargesDetail.quotedRate)) {
	            msg = msg + "<li>Row :" + (index + 1) + "# quoted Rate :Field is required.</li>";
	            $scope.changecolor('qty'+index);
	            $('#qty'+index).find('input').css("border-color", "red");

	        }  else{
	        	 if (isNaN(chargesDetail.quotedRate)) {
	        	       msg = msg + "<li>Row :" + (index + 1) + "# quoted Rate :Not a valid input.</li>";
	     	          
	   	            $scope.changecolor('qty'+index);
	   	            $('#qty'+index).find('input').css("border-color", "red");
	        		  } else {
	        			  $scope.clearcolor('qty'+index);
	        		  }
	        	
	        }*/
	       /* if ($scope.checkundefined(chargesDetail.tariff)) {
	            msg = msg + "<li>Row :" + (index + 1) + "# Tariff :Field is required.</li>";
	            $scope.changecolor('qty'+index);
	            $('#qty'+index).find('input').css("border-color", "red");

	        }  else{
	        	//$('#qty'+index).find('input').css("border-color", "#e8dddd");
	        	$scope.clearcolor('qty'+index);
	        }
	        if ($scope.checkundefined(chargesDetail.noOfBox)) {
	            msg = msg + "<li>Row :" + (index + 1) + "# No Of Box :Field is required.</li>";
	            $scope.changecolor('qty'+index);
	            $('#qty'+index).find('input').css("border-color", "red");

	        }  else{
	        	//$('#qty'+index).find('input').css("border-color", "#e8dddd");
	        	$scope.clearcolor('qty'+index);
	        }*/
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

	$scope.draftSubmit=function(){
		
		var msg=$scope.checkValidation();
		if(!$scope.checkundefined(msg)){   
			logger.logError(msg);
		}else{
        if($scope.quotation.quotationDtl.length>0 && $scope.quotation.quotationFreeDaysDtl.length>0 ){
        	$scope.quotation.status="Draft";
			 $scope.check = true;
			$http.post($stateParams.tenantid+'/app/quotation/save',$scope.quotation).success(function(datas) {
				debugger
				  if(datas.success==true){					 
					  logger.logSuccess("Saved Successfully!");
					  $state.go('app.trade.quotation.list',{tenantid:$stateParams.tenantid});
				        

				}else{
					  logger.logError(datas.message);
						$scope.check = false;
				  }
				}).error(function(data) {
					logger.logError("Please try again");
					$scope.check = false;
				});
			 
			 
        }else{
        	logger.logError("Atleast One Row Required");
        }
		}
		
		
	}
	
	$scope.Submit=function(){
		
		var count = 0;
		for(var i=0 ; i < $scope.quotation.quotationFreeDaysDtl.length; i++){

			if($scope.quotation.quotationFreeDaysDtl[i].polFreeDays=='' || $scope.quotation.quotationFreeDaysDtl[i].polFreeDays==undefined
				&& $scope.quotation.quotationFreeDaysDtl[i].podFreeDays=='' || $scope.quotation.quotationFreeDaysDtl[i].podFreeDays==undefined){
				 count++;
				
			}
		}
		if(count > 0){
			logger.logError("Please Enter the POL & POD Freedays");
		}else{
		
			var msg=$scope.checkValidation();
			if(!$scope.checkundefined(msg)){   
				logger.logError(msg);
			}else{
	        if($scope.quotation.quotationDtl.length>0){
	        	$scope.quotation.status="Pending";
				$scope.check = true;
				if($scope.quotation.special == undefined){
					$scope.quotation.special ='';
				}
				if($scope.quotation.cargoType ==undefined){
					$scope.quotation.cargoType ='';
				}
				
	        	$http.get($stateParams.tenantid+'/app/quotation/checkQuoteExists?pol='+$scope.quotation.pol+'&pod='+$scope.quotation.pod+'&customer='+$scope.quotation.customer+'&special='+$scope.quotation.special+'&cargoType='+$scope.quotation.cargoType).success(function(data) {
					  if(data.success==true){
				$http.post($stateParams.tenantid+'/app/quotation/save',$scope.quotation).success(function(datas) {
					debugger
					  if(datas.success==true){					 
						  logger.logSuccess("Saved Successfully!!!");
						  $state.go('app.trade.quotation.list',{tenantid:$stateParams.tenantid});
					        

					}else{
						  logger.logError(datas.message);
							$scope.check = false;
					  }
					}).error(function(data) {
						logger.logError("Please try again");
						$scope.check = false;

					});
	        }else{

	      		
	    	      ngDialog.open({
	                scope : $scope,
	                template : 'views/master/inventory/quotation/quotationAlertForExists',
	                controller : $controller('quotationAlertCtrl', {
	                    $scope : $scope, 
	                   // screenName: 'SeaQuotationmailView'
	                }),
	                className : 'ngdialog-theme-plain',
	                showClose : false,
	                closeByDocument : false,
	                closeByEscape : false,
	                preCloseCallback : $scope.getList
	            });

	      	
	        }
	        	});
			}
	        else{
	        	logger.logError("Atleast One Row Required");
	        }
	        }
			
	         
			
		}
		
		
	}
	
	
	   
    $scope.checkundefined1 = function(value) {
        var invalid = false;
        if (value == undefined || value == 'undefined' || value == null || value == 'null' || value == '') {
            invalid = true;
        }
        return invalid;

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
    
$scope.submitupdatePending=function(){
		
		var msg=$scope.checkValidation();
		if(!$scope.checkundefined(msg)){
			logger.logError(msg);
		}else{
			 if($scope.quotation.quotationDtl.length>0 && $scope.quotation.quotationFreeDaysDtl.length>0 ){
				 $scope.quotation.status="Pending";
			$http.post($stateParams.tenantid+'/app/quotation/update',$scope.quotation).success(function(datas) {
				  if(datas.success==true){					
					  
					  logger.logSuccess("Updated Successfully!!!");
					    $state.go('app.trade.quotation.list',{tenantid:$stateParams.tenantid});

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


$scope.submitupdatePendingApp=function(){
	
	var msg=$scope.checkValidation();
	if(!$scope.checkundefined(msg)){
		logger.logError(msg);
	}else{
		 if($scope.quotation.quotationDtl.length>0){
			 $scope.quotation.status="Pending";
		$http.post($stateParams.tenantid+'/app/quotation/update',$scope.quotation).success(function(datas) {
			  if(datas.success==true){					
				  
				  logger.logSuccess("Updated Successfully!");
				    $state.go('app.trade.quotation.list',{tenantid:$stateParams.tenantid});
				  //$state.go('app.trade.quotation.list',{tenantid:$stateParams.tenantid});
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
    
	$scope.submitupdate=function(){
		
		var msg=$scope.checkValidation();
		if(!$scope.checkundefined(msg)){
			logger.logError(msg);
		}else{
			 if($scope.quotation.quotationDtl.length>0 && $scope.quotation.quotationFreeDaysDtl.length>0 ){
			$http.post($stateParams.tenantid+'/app/quotation/update',$scope.quotation).success(function(datas) {
				  if(datas.success==true){					
					  
					  logger.logSuccess("Updated Successfully!!!");
					  $state.go('app.trade.quotation.list',{tenantid:$stateParams.tenantid});;

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
	
	
	$scope.submitupdateApp=function(){
		
		var msg=$scope.checkValidation();
		if(!$scope.checkundefined(msg)){
			logger.logError(msg);
		}else{
			 if($scope.quotation.quotationDtl.length>0 && $scope.quotation.quotationFreeDaysDtl.length>0 ){
			$http.post($stateParams.tenantid+'/app/quotation/update',$scope.quotation).success(function(datas) {
				  if(datas.success==true){					
					  
					  logger.logSuccess("Updated Successfully!!!");
					  $state.go('app.trade.quotation.list',{tenantid:$stateParams.tenantid});					  //$state.go('app.trade.quotation.list',{tenantid:$stateParams.tenantid});

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

	$scope.quoteNo1=$location.search().quotationNumber;
	
   	if($scope.quoteNo1 != '' && $scope.quoteNo1!=undefined){
   		
   	
   		$scope.quotation.quotationDtl = [];
   		$http.post($stateParams.tenantid+'/app/quotation/edit',$scope.quoteNo1).success(function(datas) {
   			$scope.copy=true;
   			$scope.quotation = datas.seaQuotationBean;
   			$scope.quotation.quotationDtl=datas.lQuotationBean;
   			$scope.quotation.quotationFreeDaysDtl=datas.quotationFreeDaysDtl;
   		}).error(function(datas) {

   		});
    		
   	}

   	$scope.copyView=function(quotationNumber){
   		$location.url($stateParams.tenantid+'/trade/quotation/copy?quotationNumber=' + quotationNumber);
   	}
   	
	$scope.cancelDraft=function(){
		
		$state.go('app.trade.quotation.list',{tenantid:$stateParams.tenantid});
	}
	
	//approval cancel
	$scope.cancelApproval=function(){
		
		$state.go('app.trade.quotation.list',{tenantid:$stateParams.tenantid});
	}
$scope.cancelReview=function(quotationNo){
		
    $location.url($stateParams.tenantid+'/trade/quotationApproval/view?quotationNo=' + quotationNo);
	}

	/*$scope.sendmail = function(quotationHdId){
		$http.get($stateParams.tenantid + '/app/seaquotation/sendMail?quotationHdId='+quotationHdId)
		.success(function(datas) {
			logger.logSuccess('Mail Sent Successfully!')
		}).error(function(data) {

		});
	}
	
		
	$scope.printQuot = function(quotationHdId){
        debugger
        console.log("Both print invoice")
        var url = $stateParams.tenantid+'/app/seaquotation/print?quotationHdId=' + quotationHdId;
        var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
        wnd.print();   
     }*/
	
	  $scope.Calculation = function(trindex,row) {
		  
		  if (row.noOfBox != 0 && row.noOfBox != "") {
			  if (row.quotedRate != 0 && row.quotedRate != "") {
			  
			  row.tariff=row.noOfBox*row.quotedRate;
			  
			  }  
		  }
		  

		  }
	
});

app.controller('quotationtableCtrl', function($scope, $http, $filter, logger,$stateParams,ngDialog) {
	
	$scope.$watchCollection('[quotation.quotationDtl[trIndex].chargeType,quotation.quotationDtl[trIndex].conType,quotation.quotationDtl[trIndex].hazardous]',function(newValue, oldValue) {
	 var k=0;
		if($scope.quotation.quotationDtl[$scope.trIndex].chargeType != null && 
			 $scope.quotation.quotationDtl[$scope.trIndex].conType != null && $scope.quotation.quotationDtl[$scope.trIndex].hazardous != null){
		 
		 for(var i=0; i < $scope.quotation.quotationDtl.length; i++){
				if(i != $scope.trIndex){
					if($scope.quotation.quotationDtl[i].conType != null && 
							$scope.quotation.quotationDtl[i].conType != "" &&
							$scope.quotation.quotationDtl[i].conType != undefined  &&
							$scope.quotation.quotationDtl[i].chargeType != null && 
							$scope.quotation.quotationDtl[i].chargeType != "" &&
							$scope.quotation.quotationDtl[i].chargeType	 != undefined	&& 
							$scope.quotation.quotationDtl[i].hazardous != "" &&
							$scope.quotation.quotationDtl[i].hazardous	 != undefined){
						
						if($scope.quotation.quotationDtl[i].conType ==  $scope.quotation.quotationDtl[$scope.trIndex].conType  
								&& $scope.quotation.quotationDtl[i].chargeType ==  $scope.quotation.quotationDtl[$scope.trIndex].chargeType  
								&& $scope.quotation.quotationDtl[i].hazardous ==  $scope.quotation.quotationDtl[$scope.trIndex].hazardous ){
							$scope.quotation.quotationDtl[$scope.trIndex].conType='';
							 $scope.quotation.quotationDtl[$scope.trIndex].chargeType='';
							k++;
						}
						
					}
					
				}
			 
			}
	 }
		
		if(k > 0){
			 logger.logError("Same container type and charge type not allowed to select!");
		}
	});
	
	
	$scope.$watch('quotation.quotationDtl[trIndex].select', function(newValue, oldValue) {
		if(newValue==false){
		$scope.quotation.checkAll=false;
		}
		else{


		}

		});
	
	$scope.$watch('quotation.quotationFreeDaysDtl[trIndex1].conType', function(newValue, oldValue) {
		var count=0;
		if(newValue != "" && newValue != null && newValue != undefined ){ 
			
			for(var i = 0;i < $scope.quotation.quotationFreeDaysDtl.length;i++){
				if(i != $scope.trIndex1){
                if(newValue == $scope.quotation.quotationFreeDaysDtl[i].conType){
                	count++;	
                	$scope.quotation.quotationFreeDaysDtl[$scope.trIndex1].conType='';
                }					
					
				}
				
			}
			
			
		}
		if(count > 0){
			  logger.logError("Same container type not allowed to select!");
		}
	 

		});
	
	
	$scope.$watchCollection('[quotation.pol,quotation.pol,quotation.quotationDtl[trIndex].chargeType,quotation.quotationDtl[trIndex].conType,quotation.quotationDtl[trIndex].hazardous,quotation.quotationDtl[trIndex].oog]',function(newValue, oldValue) {
	if (newValue[0] != '' && newValue[0] != undefined && newValue[1] != '' && newValue[1] != undefined && newValue[2] != '' && newValue[2] != undefined && newValue[3] != '' && newValue[3] != undefined
			) {
		  
		console.log(newValue[0]);
		console.log(newValue[1]);
		console.log(newValue[2]);
		console.log(newValue[3]);
		console.log(newValue[4]);
		console.log(newValue[5]);
		
		 
		$http.post($stateParams.tenantid+'/app/quotation/getChargeList?pol=' +newValue[0]+ '&pod=' +newValue[1] +'&chargeType=' +newValue[2]+'&conType=' +newValue[3]+'&hazardous=' +newValue[4]+'&oog=' +newValue[5]).success(function(data) {
			
			if(data.length > 0){
				$scope.bean=data[0];			
				$scope.quotation.quotationDtl[$scope.$parent.$index].tariff = $scope.bean.tariff;
				console.log($scope.quotation.quotationDtl[$scope.$parent.$index].tariff);
				$scope.checkFreedays();
			}else{
				$scope.quotation.quotationDtl[$scope.$parent.$index].tariff = 0;
			}
			
		});
		/*
		
		if($scope.edit == false){
		
		$http.post($stateParams.tenantid+'/app/quotation/getChargeList?pol=' +newValue[0]+ '&pod=' +newValue[1]).success(function(data) {
		  	
			$scope.test=data;
			console.log($scope.test);
			$scope.quotation.quotationDtl = [];
		

			//freight charges
			for(var i=0;i<$scope.test.length;i++){			
				
						
						$scope.max = Math.max.apply(Math, $scope.quotation.quotationDtl.map(function(item) {
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
				$scope.quotation.quotationDtl[i].chargeType = $scope.test[i].chargeCode;
				var len = $scope.quotation.quotationDtl.length - 1;
				$timeout(function() {
					hideActivePapers($scope.max + "0", []);
				}, 1000);
				
				
				
				
			}
		});
		
	}
	*/}
	
	
});
	
	$scope.$watch('quotation.quotationDtl[trIndex].conType', function(newValue, oldValue) {
		if(newValue!="" && newValue!=undefined){
			
			$scope.result = $scope.quotation.quotationDtl.filter(function (a) {

				var key = a.conType ;
				if (!this[key]) {
				this[key] = true;
				return true;
				}
				}, Object.create(null));
			
			if($scope.edit==false){
				$scope.quotation.quotationFreeDaysDtl=[];
				
				for(var j=0;j<$scope.result.length;j++){
					if($scope.result[j].conType !=''){
					
						var chargedata = {
				 				conType : $scope.result[j].conType,
				 				polFreeDays : '',
				 				podFreeDays : ''
						};

						$scope.quotation.quotationFreeDaysDtl.push(chargedata);
					}

					
		}
			}else{
				for(var j=0;j<$scope.freedays.length;j++){
					//			if($scope.result.conType[j]!= '' || $scope.result[j].conType!= undefined){
									
									var chargedata = {
							 				conType : $scope.freedays[j].conType,
							 				polFreeDays : $scope.freedays[j].polFreeDays,
							 				podFreeDays : $scope.freedays[j].podFreeDays,
									};

								//	$scope.quotation.quotationFreeDaysDtl.push(chargedata);
					//			}

								
					}
			}
					
				
				
	 
		}
		
		});
	
	/* $scope.$watch('quotation.quotationDtl[trIndex].transactionType', function(newValue, oldValue) {
		 var id = newValue;
			$http.get($stateParams.tenantid+'/app/seaquotation/getServicePartnerListid?id='+ id).success(function(datas) {
				console.log(datas);				
				 $scope.serviceParnrDropList=datas.serviceParnrList;
			  
			}).error(function(data) {

			});
	  });*/
	
	$scope.quoterate = function(index, Row,quotation) {
		
		var mlo = quotation.customer;
		var pod = quotation.pod; 
		var pol = quotation.pol;
		var containerType = Row.conType;
		
//		 $http.get($stateParams.tenantid+ '/app/quotation/gettariffRate?mlo=' +mlo +
//				 '&pod=' + pod +"&pol=" + pol + "&containerType=" + containerType).success(function(data1) {
//					 $scope.mrgRate =data1.quotedRatemrg;
//					 $scope.tariffRate =data1.quotedRateTariff;
//					 
//					 if(Row.quotedRate > $scope.mrgRate){
//						 $scope.quotation.quotationDtl[index].quotedRate = "";
//						 ngDialog.open({
//		                        template : 'mrgRateCheck',
//		                        scope : $scope
//		                    });	
//					 }	else if(Row.quotedRate < $scope.tariffRate){
//						 ngDialog.open({
//		                        template : 'tariffRateCheck',
//		                        scope : $scope
//		                    });	
//					 }
//		 });
	}

	$scope.closeFileDialog = function(){
		ngDialog.close();
	}
	
});



app.controller('quotationAlertCtrl', function($scope, $http, $filter, logger,$stateParams,ngDialog) { 
	
	$scope.confirm = function(){
		$http.post($stateParams.tenantid+'/app/quotation/saveQuotationDtl',$scope.quotation).success(function(datas) {
		debugger
		  if(datas.success==true){	
			  ngDialog.close();    
			  logger.logSuccess("Saved Successfully!!!");
			  $state.go('app.trade.quotation.list',{tenantid:$stateParams.tenantid});
		        

		}else{
			  logger.logError(datas.message);
			  ngDialog.close();    
		  }
		}).error(function(data) {
			logger.logError("Please try again");
		});
 
}
	
	$scope.no = function(){
		

		$http.post($stateParams.tenantid+'/app/quotation/saveNewQuotation',$scope.quotation).success(function(datas) {
			debugger
			  if(datas.success==true){	
				  ngDialog.close();    
				  logger.logSuccess("Saved Successfully!!!");
				  $state.go('app.trade.quotation.list',{tenantid:$stateParams.tenantid});
			        

			}else{
				  logger.logError(datas.message);
			  }
			}).error(function(data) {
				logger.logError("Please try again");
			});
    
	}
});	




app.controller('quotationRejectCtrl', function($stateParams , $scope , $rootScope, $http, $location,logger, utilsService, $state, $window,ngDialog) {
    debugger;
     
        
        $scope.quotationNew.quotationNo= $scope.quotationNew.quotationNo;  
        $scope.quotationNew.rejectRemarks= '';
 
        $scope.cancel = function() {
            ngDialog.close();    
        };
        
        $scope.rejectQuote = function(quotationNew){

        $http.post($stateParams.tenantid+'/app/quotation/reject',quotationNew).success(function(datas) {
			if(datas.success){
				 ngDialog.close();    
		    logger.logSuccess("Rejected Successfully");
		    ngDialog.close();  
		    //$state.go('app.salesmarketing.quotationApproval.list',{tenantid:$stateParams.tenantid});
		    $state.go('app.trade.quotation.list',{tenantid:$stateParams.tenantid});
			}else{
				logger.logError(datas.message);
			}
		}).error(function(datas) {

		});
        }
      
});
app.controller('quotationApprovalCtrl', function($stateParams , $scope , $rootScope, $http, $location,logger, utilsService, $state, $window,ngDialog) {
    debugger;
     
        
      $scope.quotationNew.quotationNo= $scope.quotationNew.quotationNo;  
     $scope.quotationNew.approveRemarks= '';
 
        $scope.cancel = function() {
            ngDialog.close();    
        };
        
       $scope.approveQuote = function(quotationNew){

        	//approve
  	
        		$http.post($stateParams.tenantid+'/app/quotation/approve',quotationNew).success(function(datas) {
        			if(datas.success){
        		    logger.logSuccess("Approved Successfully!!!");
        		    ngDialog.close();  
        		    //$state.go('app.salesmarketing.quotationApproval.list',{tenantid:$stateParams.tenantid});
        		    $state.go('app.trade.quotation.list',{tenantid:$stateParams.tenantid});
        			}else{
        				logger.logError(datas.message);
        			}
        			 
        		
        	
        	}).error(function(datas) {

        	});
        	
        	
        }
      
});


