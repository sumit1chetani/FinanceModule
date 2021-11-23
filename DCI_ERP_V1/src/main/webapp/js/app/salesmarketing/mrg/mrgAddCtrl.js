'use strict';
app.controller('mrgAddCtrl', function($scope, $timeout, $stateParams,sharedProperties,toaster,
		$filter, $rootScope, $http, $location, logger, $state, ngDialog,$controller,$injector,utilsService,$window) {
	$scope.mrgTypeList=[];
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
	$scope.commodityList  =[];

	$scope.createQuote=false;

	var bookingDate = $stateParams.bookingDate;
	var mloCode = $stateParams.mloCode;
	var lolId = $stateParams.lolId;
	var lodId = $stateParams.lodId;
	var bookingId= parseInt($stateParams.bookingId);
	
	$scope.edit=false;
	$scope.copy=false;
//	$scope.mrg.mrgDtlorigin = [];
//	$scope.mrg.mrgDtldestination = [];
	
	$scope.checkAllorigin = function(){ 

		angular.forEach($scope.mrg.mrgDtlorigin, function(chargesDetail, index) { 
		if($scope.mrg.checkAllorigin==true){

		chargesDetail.select2=true;

		}else{

		chargesDetail.select2=false;

		}



		});
		}
	
	$scope.checkAll = function(){ 

		angular.forEach($scope.mrg.mrgDtl, function(chargesDetail, index) { 
		if($scope.mrg.checkAll==true){

		chargesDetail.select=true;

		}else{

		chargesDetail.select=false;

		}



		});
		}
	
	$scope.checkAlldest = function(){ 

		angular.forEach($scope.mrg.mrgDtldestination, function(chargesDetail, index) { 
		if($scope.mrg.checkAlldest==true){

		chargesDetail.select1=true;

		}else{

		chargesDetail.select1=false;

		}



		});
		}
	
	$scope.checkAllFreeDays = function(){ 

		angular.forEach($scope.mrg.mrgFreeDaysDtl, function(chargesDetail, index) { 
		if($scope.mrg.checkAllFreeDays==true){

		chargesDetail.select=true;

		}else{

		chargesDetail.select=false;

		}



		});
		}
	



		//check for seal 
/*$scope.loadAllPorts = function (val){
		if(!val){
			 $http.post($stateParams.tenantid+'/app/commonUtility/getPortByEmpAgn').success(function(data) {
				  	
					$scope.polList=data;
//					$scope.potList = data;	
			});
		}
		else{
			$http.post($stateParams.tenantid+'/app/mrg/getShipment').success(function(datas) {
				  $scope.polList=datas.getportlist;
			}).error(function(datas) {

			});
		}
	}*/
		$scope.checkAll1 = function(){ 

		angular.forEach($scope.mrg.sealDtl, function(chargesDetail, index) { 
		if($scope.mrg.check1==true){

		chargesDetail.select=true;

		}else{

		chargesDetail.select=false;

		}



		});
		}
	


	$scope.shipmentTermlist = [
	     {id: '1', text: 'Collect'},
	    {id: '2', text: 'Prepaid'},
	    {id: '3', text: 'Third Party Collect'},
	    {id: '4', text: 'Others'}
	  ];
	

	
//	$scope.cargoType = [
//	     {id: '1', text: 'COCO'},
//	    {id: '2', text: 'Coir'}
//	  ];
	/*$scope.blTypeList = [
	     {id: '1', text: 'Direct'},
	     {id: '2', text: 'Two sector'},
	     {id: '3', text: 'Seaway BL'},
	     {id: '4', text: 'Split'},
	 
	  ];*/
	$scope.blTypeList = [
	     {id: '1', text: 'Normal BL'},
	     {id: '2', text: 'Two-sector BL'},
	     {id: '3', text: 'Sea WayBill'},
	     {id: '4', text: 'Switch BL'},
	 
	  ];
	
	$scope.statusList = [
	  
	     {id: 'Approved', text: 'Approved'},
	     {id: 'Reject', text: 'Reject'},
	     {id: 'Counter Offer', text: 'Counter Offer'},
	 
	  ];
	$scope.mrg={
			serviceType:'',
			customer:'',
			contractType:'',
			service:'',
			aol:'',
			origin:'',
			customer:'',
			salesPerson:'',
			vendor : '', 
			attention : '',
			mrgDate : '',
			branch : '',
			aod : '',
			destination : '',
			shipper : '',
			salesType : '',
			carrier : '',
			termConditions : '',
			mode : '1',
			currencyName : '2',
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
			pot:'',
			servicetype:'',
			freightRemarks:'',
			bltype:'',
			cargoDesc:'',
			filePath:'',
			filePath1:'',
			issueDate:'',
			freightRequested:'',
			calssval:'',
			humiditySetting:'',
			ventsetting:'',
			temp:'',		
			created_by: '',
            created_date : '',
          modified_by: '',
       modified_date: '',
		carrier : '',
		commodity : '',commodityL:'',
			detentionmrgType:'SC0009',
			mrgDtl:[{id:0,chargeHeads:'',unit:'',currency:'',qty:'',rate:'',paymentMethod : '',transactionType : '',buySell : '',note : ''}],
			mrgDtlorigin : [{id:0,conType:'',polFreeDays:'',podFreeDays:'',polGRFreeDays:'',podGRFreeDays:''}]	
	
			/*mrgDtl:[{id:0,chargeHeads:'',unit:'',currency:'',qty:'',rate:'',localCurrency:'USD',paymentMethod : '',transactionType : '',buySell : '',note : '',freeDays:0,volume:'',approvedRate:0, localchargFlag:'freight'}],
			mrgDtlorigin:[{id:0,chargeHeads:'',unit:'',currency:'',qty:'',rate:'',localCurrency:'',paymentMethod : '',transactionType : '',buySell : '',note : '',freeDays:0,volume:'',approvedRate:0, localchargFlag:'origin'}],
			mrgDtldestination:[{id:0,chargeHeads:'',unit:'',currency:'',qty:'',rate:'',localCurrency:'',paymentMethod : '',transactionType : '',buySell : '',note : '',freeDays:0,volume:'',approvedRate:0,localchargFlag:'destnation'}],

			mrgDtlCopy:[{id:0,chargeHeads:'',unit:'',currency:'',qty:'',rate:'',localCurrency:'',paymentMethod : '',transactionType : '',buySell : '',note : '',freeDays:0}],
			mrgFreeDaysDtl : [{id:0,conType:'',polFreeDays:'',podFreeDays:'',polFreeDaysdemurrage:'',podFreeDaysdemurrage:'',polFreeDaysApproved:'',podFreeDaysApproved:'',polFreeDaysDMApproved:'',podFreeDaysDMApproved:''}]*/
			/*mrgFreeDaysDtl : []*/
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

	$scope.mrg.mrgDate = dd + '/' + mm + '/'
			+ yyyy;


    var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth() + 1;

	var yyyy = today.getFullYear();
	var hh = today.getHours();

	var min = today.getMinutes();
	if (dd < 10) {
		dd = '0' + dd;
	}
	if (mm < 10) {
		mm = '0' + mm;
	}
	var today = dd + '/' + mm + '/' + yyyy+" "+hh+":"+min;
	var today1 = dd + '/' + mm + '/' + yyyy;

	$scope.mrg.mrgDate = today1;
	$scope.mrg.issueDate = today1;
	$scope.$watch('mrg.validTill',function(newvalue, oldvalue) {
		debugger;
				if ($scope.mrg.validTill != null
						&& $scope.mrg.validTill != '' 
						&& $scope.mrg.mrgDate != null
						&& $scope.mrg.mrgDate != "") {
					var requestDtAry = $scope.mrg.validTill.split('/');
					var oldDateAry = $scope.mrg.mrgDate.split('/');
					var requestDtObj = new Date(
							requestDtAry[2],
							requestDtAry[1] - 1,
							requestDtAry[0]);
					var oldDateObj = new Date(
							oldDateAry[2],
							oldDateAry[1] - 1,
							oldDateAry[0]);
					
					if (requestDtObj < oldDateObj) {
						$scope.mrg.validTill ="";
						logger.logError("MRG Validity Date should be greater than mrg Date - "+$scope.mrg.mrgDate+" ..!!");
					}
	
				}
	});
	
	  $scope.getdropdown = function() {

			var serviceList = [ {
	            id : '1',
	            text : 'EXPORT'
	        }, {
	            id : '2',
	            text : 'IMPORT'
	        }]
			
			$scope.servicePartnerTypelist=serviceList;
			$http.get($stateParams.tenantid+'/app/seaquotation/getiataList').success(function(datas) {
				debugger
			    $scope.portList = datas.commonUtilityBean;	    

			}).error(function(data) {

			});
		  //ChargeHeads
		  $http.get($stateParams.tenantid+'/app/seaquotation/getChargeHeads').success(function(datas) {
				 $scope.chargeHeadList = datas.commonUtilityBean;
			    
			}).error(function(data) {

			});
		  //UnitdropDown
			$http.get($stateParams.tenantid+'/app/seaquotation/getUnitList').success(function(datas) {
				 $scope.UnitList = datas.commonUtilityBean;
			    
			}).error(function(data) {

			});
			//TransactionList
			$http.get($stateParams.tenantid + '/app/airquotation/getTransactionList')
			.success(function(datas) {
				$scope.transactionTypeList = datas.commonUtilityBean;

			}).error(function(data) {

			});
			$http.post($stateParams.tenantid+'/app/ratequotation/getShipment').success(function(datas) {
					  $scope.shipmentList=datas.getshipmentlist;
					  //$scope.portList=datas.getportlist;
					  $scope.currencyList=datas.getcurrencylist	;
					  $scope.conTypeList=datas.getcontypelist;
					  $scope.chargeTypeList=datas.getchargetypelist;
					  $scope.potList = datas.getportlist;
					//logger.logSuccess('Mail Sent Successfully!')
				}).error(function(datas) {

				});
			//contractType
			$http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(datas) {	
				  $scope.contractTypeList=datas.contractType;
			}).error(function(data) {

			});
			//customerDropdown
			$http.post($stateParams.tenantid+'/app/seaquotation/getServicePartnerList').success(function(datas) {
				debugger
				 $scope.customerDropList = datas.customerList;
			}).error(function(data) {

			});
			
			  //Category
			  $http.post($stateParams.tenantid+'/app/commonUtility/getCustomerCateory').success(function(data) {
			  	
					$scope.CustList=data.customercategory;
					        		
			});
			  
			  
			  $http.post($stateParams.tenantid+'/app/commonUtility/getPortByEmpAgn').success(function(data) {
//					$scope.potList=data;
					$scope.polList=data;
					
					        		
			});
			  $http.post($stateParams.tenantid+'/app/commonUtility/getSpecialList').success(function(data) {
				  	
					$scope.SpecialList=data;
					        		
			});
			 // cargo type List ..... 
			  $http.post($stateParams.tenantid+'/app/commonUtility/cargotype').success(function(data) {
				  	
					$scope.cargoType=data;
					        		
			});
				 // service  List ..... 
			  $http.post($stateParams.tenantid+'/app/commonUtility/getServiceList').success(function(data) {
				  	
					$scope.ServiceList=data;
					        		
			});
			  $http.post($stateParams.tenantid+'/app/commonUtility/getOriginDestination').success(function(data) {
				  	
					$scope.originList=data;
					$scope.destinationList=data;
					        		
			});
			  }
			  $scope.getdropdown(); 
			  
			  $http.post($stateParams.tenantid+'/app/detection/getmrgList').success(function(data) {
			      	
			  		$scope.mrgList=data; 
			  		        		
			     });
	
	//new
			  
			  
							    //carrier
			    
			    $http.get($stateParams.tenantid+'/app/commonUtility/getcarrierList').success(function(datas) {
					debugger
				    $scope.carrierList = datas.commonUtilityBean;	    
		            //$scope.transList = datas.lCommonUtilityBean;	    

				}).error(function(data) {

				});

			    
			  
			  
	$scope.quoteNo=$location.search().mrgNo;
	
//	if($scope.quoteNo != '' && $scope.quoteNo!=undefined){
		
/*		$scope.customerDropList =[];

		var obj ={
				"condition" : "select distinct agre_party_id from mrg_hdr  where mrg_no ='"+$scope.quoteNo+"'"
		}
		$http.post($stateParams.tenantid+ '/app/commonUtility/getCustomerListFilter',obj).success(function(data1) {
			console.log(data1);
			$scope.customerDropList = data1;

		});*/
//		var quoteNo = $scope.quoteNo;
//		 $http.get($stateParams.tenantid+ '/app/mrg/getCustomereditDropdown?quoteNo=' +quoteNo).success(function(data1) {
//				console.log(data1);
//				$scope.customerDropList1 = data1;
//		  
//			});
   		
//		$http.get($stateParams.tenantid+'/app/mrg/edit?mrgId=',$scope.quoteNo).success(function(datas) {
//		
//			$scope.flagquote = datas.flagquote;
//			$scope.mrg=datas.seamrgBean;
//			$scope.mrg.checkDate = datas.seamrgBean.validTill;
//			$scope.mrg.mrgDtl=datas.lmrgBean;
//			$scope.mrg.mrgFreeDaysDtl=datas.mrgFreeDaysDtl;
//			$scope.mrg.files = datas.l1file1;
//			$scope.mrg.files1 = datas.l1file2;
//			$scope.mrg.files2 = datas.l1file3;
//
//			$scope.freedays=$scope.mrg.mrgFreeDaysDtl;
//			$scope.edit=true;
//		
//		}).error(function(datas) {

//		});
		
		
//	}
	
	
	$scope.getDropDownListprt = function() {
        $http.post($stateParams.tenantid+'/app/seaquotation/getcommodity').success(function(data){
        	$scope.commodityList=data.commonUtilityBean;
            
            $timeout(function() { 
                $("#commodityL").multiselect({
                    maxHeight: 200,
                    includeSelectAllOption: true,
                    selectAllText: 'Select All',
                    enableFiltering: true,
                    enableCaseInsensitiveFiltering: true,
                    filterPlaceholder: 'Search',
                    onChange: function(element, checked) {
                        debugger;
                        var ct=""; 
                      if($scope.commodityList.length>0){   
                          $scope.quotation.commodity ='';
                         angular.forEach($scope.quotation.commodityL, function (item, key) {
                             if(ct==""){
                                 ct = item.id;
                             }else{
                                 ct +=","+ item.id;
                             }       
                             $scope.quotation.commodity = ct;
                         });
                      }else{
                    	  $scope.quotation.commodity = '';
                      }
                    }
                  });
                $("#commodityL").parent().find('.btn-group #multiselect-button').addClass('width_100 input-sm line-height-5'); 
                
                }, 2, false);
            
            $timeout(function() { 
                $("#commodityL").multiselect({
                    maxHeight: 200,
                    includeSelectAllOption: true,
                    selectAllText: 'Select All',
                    enableFiltering: true,
                    enableCaseInsensitiveFiltering: true,
                    filterPlaceholder: 'Search',
                    onChange: function(element, checked) {
                        debugger;
                        var ct=""; 
                      if($scope.commodityList.length>0){   
                          $scope.quotation.commodity ='';
                         angular.forEach($scope.quotation.commodityL, function (item, key) {
                             if(ct==""){
                                 ct = item.id;
                             }else{
                                 ct +=","+ item.id;
                             }       
                             $scope.quotation.commodity = ct;
                         });
                      }else{
                    	  $scope.quotation.commodity = '';
                      }
                    }
                  });
                $("#commodityL").parent().find('.btn-group #multiselect-button').addClass('width_100 input-sm line-height-5'); 
                
                }, 2, false);
        }).error(function(data) {
        });

    }
    $scope.getDropDownListprt();

	$scope.createquotefromRR =  function(RRVal){

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
				rrnumber:'',
				detentionTariffType:'SC0009',
				quotationDtl:[{id:0,chargeHeads:'',unit:'',currency:'',qty:'',rate:'',localCurrency:'',paymentMethod : '',transactionType : '',buySell : '',note : '',freeDays:0}],
				quotationDtlCopy:[{id:0,chargeHeads:'',unit:'',currency:'',qty:'',rate:'',localCurrency:'',paymentMethod : '',transactionType : '',buySell : '',note : '',freeDays:0}],
				quotationFreeDaysDtl : [{id:0,conType:'',polFreeDays:'',podFreeDays:''}]
				/*quotationFreeDaysDtl : []*/
		}

		$scope.quotation.customer = RRVal.customer;
		$scope.quotation.quotationDate = RRVal.mrgDate;
		$scope.quotation.validTill = RRVal.validTill;
		$scope.quotation.pod = RRVal.pod;
		$scope.quotation.pol = RRVal.pol;
		
		$scope.quotation.cargoType = RRVal.cargoType;
		$scope.quotation.currencyName = RRVal.currencyName;
		$scope.quotation.freight = RRVal.freight;
		$scope.quotation.soc = RRVal.soc;
		$scope.quotation.rrnumber = $scope.quoteNo;


        angular.forEach(RRVal.mrgDtl, function(row, index) {
        	if(index > 0){
//        		$scope.quotation.quotationDtl.push($scope.quotation.quotationDtl[0]);
				var quotedtl = {id:0,chargeHeads:'',unit:'',currency:'',qty:'',rate:'',localCurrency:'',paymentMethod : '',transactionType : '',buySell : '',note : '',freeDays:0};
				$scope.quotation.quotationDtl.push(quotedtl);
        	}
        	$scope.quotation.quotationDtl[index].chargeType=row.chargeType;
        	$scope.quotation.quotationDtl[index].conType=row.conType;
        	$scope.quotation.quotationDtl[index].hazardous=row.hazardous;
        	$scope.quotation.quotationDtl[index].oog=row.oog;
        	$scope.quotation.quotationDtl[index].tariff=row.tariff;
        	$scope.quotation.quotationDtl[index].localCurrency=row.localCurrency;
        	$scope.quotation.quotationDtl[index].quotedRate=row.approvedRate;

        });
 angular.forEach(RRVal.mrgFreeDaysDtl, function(row1, index1) {
	  	if(index1 > 0){
    		$scope.quotation.quotationFreeDaysDtl.push($scope.quotation.quotationFreeDaysDtl);
    	}
	 $scope.quotation.quotationFreeDaysDtl[index1].conType=row1.conType;
 	$scope.quotation.quotationFreeDaysDtl[index1].polFreeDays=row1.polFreeDays;
 	$scope.quotation.quotationFreeDaysDtl[index1].podFreeDays=row1.podFreeDays;
        });
 $rootScope.quotationfromRR = $scope.quotation;
 $location.url($stateParams.tenantid+"/master/inventory/quotation/Add");

//		alert(7);
	}
	  var tt = $location.path().split("/")[5]||"editformrgDate";
	$scope.$watch('mrg.validTill',function(newvalue, oldvalue) {
		if(tt == 'editformrgDate'){
		if ($scope.mrg.validTill != null
				&& $scope.mrg.validTill != '' ){
			var frmDate = $scope.mrg.checkDate;
			var toDate = $scope.mrg.validTill;
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
				logger.logError("Extention of mrg Date is not allowed!!");
				$scope.mrg.validTill ='';
			}	
		}else{
		}
	}
	});
    
	$scope.$watchCollection('[mrg.origin,mrg.currencyName]',function(newValue, oldValue) {
	        if ($scope.mrg.origin != '' && $scope.mrg.origin != undefined && $scope.mrg.currencyName != '' && $scope.mrg.currencyName != undefined  && $scope.edit == false  && $scope.copy == false) {
//	        	$scope.custId=newValue;
	        	if($scope.edit == false){
	        	$http.get($stateParams.tenantid+'/app/mrg/getdefaultchargeList?pol='+$scope.mrg.origin+'&crnyName='+$scope.mrg.currencyName +'&type='+ "Export").success(function(datas) {
//	        		$scope.mrg.mrgDtlorigin = [];
	        		if(datas.length > 0){
	        		$scope.mrg.mrgDtlorigin=datas;
//	        		$scope.mrg.custcategory=datas.seamrgBean.custcategory;
	        		}
	    		}).error(function(datas) {

	    		});
	        	}
	        } else {
	      /*      $scope.freightReport.voyage = '';
	            $scope.voyageList = [];*/
	          
	        }
	    });
	
	$scope.$watchCollection('[mrg.destination1,mrg.currencyName]',function(newValue, oldValue) {
        if ($scope.mrg.destination1 != '' && $scope.mrg.destination1 != undefined && $scope.mrg.currencyName != '' && $scope.mrg.currencyName != undefined  && $scope.edit == false  && $scope.copy == false) {
//        	$scope.custId=newValue;
        	if($scope.edit == false){	
        	$http.get($stateParams.tenantid+'/app/mrg/getdefaultchargeList?pol='+$scope.mrg.destination1+'&crnyName='+$scope.mrg.currencyName +'&type='+ "Import").success(function(datas) {
//        		$scope.mrg.mrgDtldestination = [];
        		if(datas.length > 0){
            		$scope.mrg.mrgDtldestination=datas;

        		}
//        		$scope.mrg.custcategory=datas.seamrgBean.custcategory;
    		
    		}).error(function(datas) {

    		});
        	}
        } else {
      /*      $scope.freightReport.voyage = '';
            $scope.voyageList = [];*/
          
        }
    });

//	if($scope.edit == false){
//		
//		$http.post($stateParams.tenantid+'/app/mrg/getdefaultchargeList').success(function(data) {
//			
//			
//			$scope.test=data;			
//			$scope.mrg.mrgDtl = [];
//		
//
//			//freight charges
//			for(var i=0;i<$scope.test.length;i++){			
//				
//						
//						$scope.max = Math.max.apply(Math, $scope.mrg.mrgDtl.map(function(item) {
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
//				$scope.mrg.mrgDtl.push(chargedata);
//				$scope.mrg.mrgDtl[i].chargeType = $scope.test[i].chargeCode;
//				$scope.mrg.mrgDtl[i].mrg = $scope.test[i].mrg;
//				var len = $scope.mrg.mrgDtl.length - 1;
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
	
	
	
	
	/*$scope.$watchCollection('[mrg.pol,mrg.pod]',function(newValue, oldValue) {
		if (newValue[0] != '' && newValue[0] != undefined && newValue[1] != '' && newValue[1] != undefined) {
			
			if($scope.edit == false){
			
			$http.post($stateParams.tenantid+'/app/mrg/getChargeList?pol=' +newValue[0]+ '&pod=' +newValue[1]).success(function(data) {
			  	
				$scope.test=data;
				console.log($scope.test);
				$scope.mrg.mrgDtl = [];
			

				//freight charges
				for(var i=0;i<$scope.test.length;i++){			
					
							
							$scope.max = Math.max.apply(Math, $scope.mrg.mrgDtl.map(function(item) {
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
			
					$scope.mrg.mrgDtl.push(chargedata);
					$scope.mrg.mrgDtl[i].chargeType = $scope.test[i].chargeCode;
					var len = $scope.mrg.mrgDtl.length - 1;
					$timeout(function() {
						hideActivePapers($scope.max + "0", []);
					}, 1000);
					
					
					
					
				}
			});
			
		}
		}
		
	});*/
	

	
	
	//reject
	$scope.reject = function(mrgNo) {	
		 $scope.mrgNew = {
	        		mrgNo : '',
	        		rejectRemarks : '' 
	        };
		    $scope.mrgNew.mrgNo =  mrgNo;
             $scope.mrgNew.rejectRemarks =  '';
         ngDialog.open({
             scope : $scope,
             template : 'views/sales/mrg/mrgRejectRemarks',
             controller : $controller('mrgRejectCtrl', {
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
	$scope.approve = function(mrgNo) {	
		 $scope.mrgNew = {
	        		mrgNo : '',
	        		approveRemarks : '' 
	        };
		    $scope.mrgNew.mrgNo =  mrgNo;
             $scope.mrgNew.approveRemarks =  '';
//         ngDialog.open({
//             scope : $scope,
//             template : 'views/sales/mrg/mrgApprovalRemarks',
////             controller : $controller('mrgApprovalCtrl', {
////                 $stateParams :$stateParams,
//                 $scope : $scope
////                 $rootScope :$rootScope, 
////                 $http:$http, 
////                 $location:$location,
////                 logger:logger, 
////                 utilsService:utilsService, 
////                 $state:$state, 
////                 $window:$window,
////                 preCloseCallback : $scope.getList
////             }),
////             showClose : false,
////             closeByDocument : false,
////             closeByEscape : false 
//         });
         ngDialog.open({
             template : 'views/sales/mrg/mrgApprovalRemarks',
             scope :$scope
         });
 	};
 	  $scope.cancel = function() {
          ngDialog.close();    
      };
      $scope.mrg.approveRemarks= '';
    $scope.approveQuote = function(mrgNew){

    	//approve

//        $scope.mrg.mrgNo= $scope.mrgNew.mrgNo;  
    
    	
    		$http.post($stateParams.tenantid+'/app/mrg/approve',$scope.mrg).success(function(datas) {
    			if(datas.success){
    		    logger.logSuccess("Approved Successfully!!!");
    		    ngDialog.close();  
    		    //$state.go('app.salesmarketing.mrgApproval.list',{tenantid:$stateParams.tenantid});
    		    $state.go('app.master.mrg.list',{tenantid:$stateParams.tenantid});
    			}else{
    				logger.logError(datas.message);
    			}
    			 
    		
    	
    	}).error(function(datas) {

    	});
    	
    	
    }
 	

 	//counterOffer
	$scope.counterOffer = function(mrgNo) {	
		 $scope.mrgNew = {
	        		mrgNo : '',
	        		approveRemarks : '' 
	        };
		    $scope.mrgNew.mrgNo =  mrgNo;
             $scope.mrgNew.approveRemarks =  '';
//         ngDialog.open({
//             scope : $scope,
//             template : 'views/sales/mrg/mrgApprovalRemarks',
//             controller : $controller('mrgCounterOfferCtrl', {
//                 $stateParams :$stateParams,
//                 $scope : $scope, 
//                 $rootScope :$rootScope, 
//                 $http:$http, 
//                 $location:$location,
//                 logger:logger, 
//                 utilsService:utilsService, 
//                 $state:$state, 
//                 $window:$window,
//                 preCloseCallback : $scope.getList
//             }),
//             showClose : false,
//             closeByDocument : false,
//             closeByEscape : false 
//         });
             ngDialog.open({
                 template : 'views/sales/mrg/mrgApprovalRemarks',
                 scope :$scope
             });
 	};
 	

    $scope.counterQuote = function(mrgNew){

    	//approve
	
    		$http.post($stateParams.tenantid+'/app/mrg/counterOffer',$scope.mrg).success(function(datas) {
    			if(datas.success){
    		    logger.logSuccess("Counter Offer Successfully!!!");
    		    ngDialog.close();  
    		    //$state.go('app.salesmarketing.mrgApproval.list',{tenantid:$stateParams.tenantid});
    		    $state.go('app.master.mrg.list',{tenantid:$stateParams.tenantid});
    			}else{
    				logger.logError(datas.message);
    			}
    			 
    		
    	
    	}).error(function(datas) {

    	});
    	
    	
    }
 	
 	
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
	 
	$scope.$watchCollection('[mrg.mrgDate]',function(newValue, oldValue) {
		if ($scope.mrg.mrgDate != '') {
			var frmDate = today;
			var toDate = $scope.mrg.mrgDate;
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
				logger.logError("mrg Date should be less or equal to current date");
				$scope.mrg.mrgDate = "";
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
	    $scope.mrg.files= [];
	    $scope.adduploadfiles = function() {
	    	debugger
	        var obj = []

	        if ($scope.checkundefined1($scope.excelfile)) {
	            logger.logError("Please select the file");
	        } else {
	            obj = $filter('filter')($scope.mrg.files, {
	                filename : $scope.excelfile.name
	            }, true);
	        }

	        if (obj != undefined && obj.length > 0) {
	            logger.logError($scope.excelfile.name + " same file already added");
	        } else {$timeout(function() {
	        	for( var i=0;i<$scope.excelfile.length;i++){
		            $scope.files.push($scope.excelfile[i]);
		            $scope.mrg.files.push({
		                filename : $scope.excelfile[i].name,
		                filepath : '',
		                mrg : ''
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

	        angular.forEach($scope.mrg.files, function(value, index) {
	            if (filename != value.filename) {
	                $scope.tempfilename.push(value);
	            }

	        });
	        $scope.files = $scope.tempfiles;
	        $scope.mrg.files = $scope.tempfilename;
	        
	        
	       /* $http.post($stateParams.tenantid+'/app/airmrg/deleteFiles', filepath).success(function(result) {
	               
            })
*/
	    }
	    
		$scope.addRow = function() {

			$scope.max = Math.max.apply(Math, $scope.mrg.mrgDtl
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

			$scope.mrg.mrgDtl.push(chargedata);
			var len = $scope.mrg.mrgDtl.length - 1;
			$timeout(function() {
				hideActivePapers($scope.max + "0", []);
			}, 1000);
		}
	    
	$scope.addRowFreeDays = function() {		 
 		var chargedata = {
 				conType : '',
 				polFreeDays : '',
 				podFreeDays : '',
 				polGRFreeDays : '',
 				podGRFreeDays : ''
		};
		$scope.mrg.mrgDtlorigin.push(chargedata);
   	}
	$scope.addRowGroundFreeDays = function() {		 
 		var chargedata = {
 				conType : '',
 				polFreeDays : '',
 				podFreeDays : ''
		};
		$scope.mrg.mrgDtldestination.push(chargedata);
   	}
		

	
	$scope.removeRow = function() {
		$scope.tablerow = [];
		for (var index = 0 ; index < 1; index++) {
		angular.forEach($scope.mrg.mrgDtl,function(row, index) {
					var check = row.select;
					
					if (check == undefined || check == "" ) {
						$scope.tablerow.push(row);
					} else if(index > 0){
						$scope.mrg.mrgDtl = $scope.tablerow;

					}
				});
		}
	};
	$scope.removeRowFreeDays  = function() {
		$scope.tablerow = [];
		for (var index = 0 ; index < 1; index++) {
		angular.forEach($scope.mrg.mrgDtlorigin,function(row, index) {
					var check = row.select;
					
					if (check == undefined || check == "" ) {
						$scope.tablerow.push(row);
					} else if(index > 0){
						$scope.mrg.mrgDtlorigin = $scope.tablerow;

					}
				});
		}
	};
	$scope.removeRowGroundFreeDays  = function() {
		$scope.tablerow = [];
		for (var index = 0 ; index < 1; index++) {
		angular.forEach($scope.mrg.mrgDtldestination,function(row, index) {
					var check = row.select;
					
					if (check == undefined || check == "" ) {
						$scope.tablerow.push(row);
					} else if(index > 0){
						$scope.mrg.mrgDtldestination = $scope.tablerow;

					}
				});
		}
	};
	
$scope.checkFreedaysorigin = function(){
		
		$scope.tempList=[]
//		$scope.mrg.mrgDtl = $scope.mrg.mrgDtlorigin;
//		
//		angular.forEach(	$scope.mrg.mrgDtldestination, function(row,index){
//			$scope.mrg.mrgDtl.push(row);
//		})
//		
		
		if($scope.mrg.mrgDtl.length != 0){
			for(var j=0;j<$scope.mrg.mrgDtlorigin.length;j++){
				if($scope.mrg.mrgDtlorigin[j].conType!= '' && $scope.mrg.mrgDtlorigin[j].conType!= undefined){
					var period = {
							conType:$scope.mrg.mrgDtlorigin[j].conType,
							polFreeDays:'',
							podFreeDays : '', 
							
							};
						$scope.tempList.push(period);
					
					
					
				}
			}
				
		}

//$scope.tempList = $scope.mrg.mrgDtl
		
		$scope.result = $scope.tempList.filter(function (a) {

			var key = a.conType ;
			if (!this[key]) {
			this[key] = true;
			return true;
			}
			}, Object.create(null));
			
			
		if($scope.edit==false){
			$scope.mrg.mrgFreeDaysDtl=[];
			
			for(var j=0;j<$scope.result.length;j++){
	//			if($scope.result.conType[j]!= '' || $scope.result[j].conType!= undefined){
					
					var chargedata = {
			 				conType : $scope.result[j].conType,
			 				polFreeDays : '',
			 				podFreeDays : ''
					};

					$scope.mrg.mrgFreeDaysDtl.push(chargedata);
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

//								$scope.mrg.mrgFreeDaysDtl.push(chargedata);
				//			}

							
				}
		}
	
		
	}

$scope.checkFreedaysdestination = function(){
		
		$scope.tempList=[]
//		$scope.mrg.mrgDtl = $scope.mrg.mrgDtlorigin;
//		
//		angular.forEach(	$scope.mrg.mrgDtldestination, function(row,index){
//			$scope.mrg.mrgDtl.push(row);
//		})
//		
		
		if($scope.mrg.mrgDtl.length != 0){
			for(var j=0;j<$scope.mrg.mrgDtldestination.length;j++){
				if($scope.mrg.mrgDtldestination[j].conType!= '' && $scope.mrg.mrgDtldestination[j].conType!= undefined){
					var period = {
							conType:$scope.mrg.mrgDtldestination[j].conType,
							polFreeDays:'',
							podFreeDays : '', 
							
							};
						$scope.tempList.push(period);
					
					
					
				}
			}
				
		}

//$scope.tempList = $scope.mrg.mrgDtl
		
		$scope.result = $scope.tempList.filter(function (a) {

			var key = a.conType ;
			if (!this[key]) {
			this[key] = true;
			return true;
			}
			}, Object.create(null));
			
			
		if($scope.edit==false){
			$scope.mrg.mrgFreeDaysDtl=[];
			
			for(var j=0;j<$scope.result.length;j++){
	//			if($scope.result.conType[j]!= '' || $scope.result[j].conType!= undefined){
					
					var chargedata = {
			 				conType : $scope.result[j].conType,
			 				polFreeDays : '',
			 				podFreeDays : ''
					};

					$scope.mrg.mrgFreeDaysDtl.push(chargedata);
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

//								$scope.mrg.mrgFreeDaysDtl.push(chargedata);
				//			}

							
				}
		}
	
		
	}
	/*$scope.removeCopyRow = function() {
		$scope.tableCopyrow = [];
		for (var index = 0 ; index < 1; index++) {
		angular.forEach($scope.mrg.mrgDtlCopy,function(row, index) {
					var check = row.select;
					if (check == undefined || check == "" ) {
						$scope.tableCopyrow.push(row);
					} else if (index > 0) {
						$scope.mrg.mrgDtlCopy = $scope.tableCopyrow;
					}
				});
		}
	};*/
	
	
	/*$scope.deleteIds = [];
		$scope.removeRow = function() {
			var len = $scope.mrg.mrgDtl.length;
			for (var index = len - 1; index < len; index--) {
				if ($scope.mrg.mrgDtl[index].select == true) {
					if ($scope.mrg.mrgDtl[index].id != null
							&& $scope.mrg.mrgDtl[index].id > 0) {
						$scope.deleteIds.push($scope.mrg.mrgDtl[index].id);
					}
					$scope.mrg.mrgDtl.splice(index, 1);
				}
			}
			$scope.addRow();
			var mrgDtl = {
					id:0,chargeHeads:'',unit:'',currency:'',qty:'',rate:'',paymentMethod : '',transactionType : '',buySell : '',note : ''
		} 
			$scope.mrg.mrgDtl.push(mrgDtl);
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
	$scope.getmrgType = function() {
	    var  data = {};
	    data["id"] = "1";
	    data["text"] = "SEA";
	    $scope.modeList.push(data);
	    $scope.mrg.mode='1';
//	    data = {};
//	    data["id"] = "2";
//	    data["text"] = "SEA";
//	    $scope.modeList.push(data);
	}
	
	  $scope.$watch('mrg.customer', function(newValue, oldValue) {
	        if (newValue != '' && newValue != undefined) {
	        	$scope.custId=newValue;
	        	$http.post($stateParams.tenantid+'/app/mrg/getcustomerdetail',$scope.custId).success(function(datas) {
	        		
	        		$scope.mrg.address=datas.seamrgBean.address;
	        		$scope.mrg.custcategory=datas.seamrgBean.custcategory;
	    		
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
	 $scope.mrg.mode='1';
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
		$scope.getmrgType();
		$http.post($stateParams.tenantid+'/app/seamrg/getServicePartnerList').success(function(datas) {
			debugger
		//	 $scope.customerDropList = datas.customerList;
			 $scope.consigneeDropList = datas.consigneeList;
			 $scope.shipperDropList = datas.shipperList;
			 $scope.nominatedDropList = datas.nominatedList;
			 $scope.vendorDropList = datas.vendorList;
			 $scope.serviceParnrDropList=datas.serviceParnrList;
		  
		  
		}).error(function(data) {

		});
		$http.get($stateParams.tenantid+'/app/seamrg/getiataList').success(function(datas) {
			debugger
		    $scope.portList = datas.commonUtilityBean;	    

		}).error(function(data) {

		});
		
		$http.get($stateParams.tenantid+'/app/seamrg/getcommodity').success(function(datas) {
			
		    $scope.commodityList = datas.commonUtilityBean;	    

		}).error(function(data) {

		});
		
		
		$http.get($stateParams.tenantid+'/app/seamrg/getBranch').success(function(datas) {
			 $scope.branchList = datas.commonUtilityBean;
		    
		}).error(function(data) {

		});
		$http.get($stateParams.tenantid+'/app/seamrg/getCurrencyList').success(function(datas) {	  
			$scope.currencylist= angular.copy(datas.commonUtilityBean);
		}).error(function(data) {

		});
		
		$http.get($stateParams.tenantid+'/app/seamrg/getServicePartnerType').success(function(datas) {	  
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
		
		$http.get($stateParams.tenantid+'/app/seamrg/getEmployeeList').success(function(datas) {
			 $scope.employeeList = datas.commonUtilityBean;
		    
		}).error(function(data) {

		});
		
		$http.get($stateParams.tenantid + '/app/airmrg/getSalesList')
		.success(function(datas) {
			$scope.salesTypeList = datas.commonUtilityBean;

		}).error(function(data) {

		});
		
		$http.get($stateParams.tenantid + '/app/airmrg/getServiceList')
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
		
		$http.get($stateParams.tenantid + '/app/airmrg/getPaymentList')
		.success(function(datas) {
			$scope.PaymentMethodList = datas.commonUtilityBean;

		}).error(function(data) {

		});
		
		
		$http.get($stateParams.tenantid + '/app/airmrg/getTransactionList')
		.success(function(datas) {
			$scope.transactionTypeList = datas.commonUtilityBean;

		}).error(function(data) {

		});
		
		$http.get($stateParams.tenantid+'/app/seamrg/getChargeHeads').success(function(datas) {
			 $scope.chargeHeadList = datas.commonUtilityBean;
		    
		}).error(function(data) {

		});
		
		
		$http.get($stateParams.tenantid+'/app/seamrg/getTerms').success(function(datas) {
			 $scope.TermList = datas.commonUtilityBean;
		    
		}).error(function(data) {

		});
		
		$http.get($stateParams.tenantid+'/app/seamrg/getUnitList').success(function(datas) {
			 $scope.UnitList = datas.commonUtilityBean;
		    
		}).error(function(data) {

		});
		
		
		
	*/}
	$scope.editdata=function(mrg){/*
		
		
		$scope.getmrgType();
		$http.post($stateParams.tenantid+'/app/seamrg/getServicePartnerList').success(function(datas) {
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
$scope.rejectflag = $location.search().status; 
//alert($scope.rejectflag);
	$scope.edit=false;
	if(!$scope.checkundefined($location.search().mrg)){
		$scope.editdata($location.search().mrg);
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
	    if ($scope.checkundefined($scope.mrg.serviceType)) {
	        msg = msg + "<li>Service :Field is required.</li>";         
	        $scope.changecolor('aol');
	    }else{
	    	$scope.clearcolor('aol');
	    }
	    /*if ($scope.checkundefined($scope.mrg.customer)) {
	        msg = msg + "<li>Customer :Field is required.</li>";         
	        $scope.changecolor('aol');
	    }else{
	    	$scope.clearcolor('aol');
	    }*/
	    if ($scope.checkundefined($scope.mrg.commodityL)) {
	        msg = msg + "<li>Commodity :Field is required.</li>";         
	        $scope.changecolor('aol');
	    }else{
	    	$scope.clearcolor('aol');
	    }
	    
	    
	    if ($scope.checkundefined($scope.mrg.carrier)) {
	        msg = msg + "<li>Carrier :Field is required.</li>";         
	        $scope.changecolor('aol');
	    }else{
	    	$scope.clearcolor('aol');
	    }
	 
	    
	    if ($scope.checkundefined($scope.mrg.contractType)) {
	        msg = msg + "<li>Contract Type :Field is required.</li>";         
	        $scope.changecolor('aol');
	    }else{
	    	$scope.clearcolor('aol');
	    }
	    if ($scope.checkundefined($scope.mrg.mrgDate)) {
	        msg = msg + "<li>mrgDate :Field is required.</li>";         
	        $scope.changecolor('aol');
	    }else{
	    	$scope.clearcolor('aol');
	    }
	    if ($scope.checkundefined($scope.mrg.pol)) {
	        msg = msg + "<li>pol :Field is required.</li>";         
	        $scope.changecolor('mrgDate');
	    }else{
	    	$scope.clearcolor('mrgDate');
	    }
	    if ($scope.checkundefined($scope.mrg.pod)) {
	        msg = msg + "<li>pod :Field is required.</li>";         
	        $scope.changecolor('branch');
	    }else{
	    	$scope.clearcolor('branch');
	    }
	    if ($scope.checkundefined($scope.mrg.validTill)) {
	        msg = msg + "<li>valid Till :Field is required.</li>";         
	        $scope.changecolor('aod');
	    }else{
	    	$scope.clearcolor('aod');
	    }
	    if ($scope.checkundefined($scope.mrg.currencyName)) {
	        msg = msg + "<li>Currency : Field is required.</li>";         
	        $scope.changecolor('aod');
	    }else{
	    	$scope.clearcolor('aod');
	    }
	    
	   /* if ($scope.checkundefined($scope.mrg.dropoff)) {
	        msg = msg + "<li>valid Till :Drop off is required.</li>";         
	        $scope.changecolor('aod');
	    }else{
	    	$scope.clearcolor('aod');
	    }*/
	    
	      /* if ($scope.checkundefined($scope.mrg.salesType)) {
	        msg = msg + "<li>SalesType:Field is required.</li>";         
	        $scope.changecolor('salesType');
	    }else{
	    	$scope.clearcolor('salesType');
	    }
	    if ($scope.checkundefined($scope.mrg.mode)) {
	        msg = msg + "<li>Mode:Field is required.</li>";         
	        $scope.changecolor('mode');
	    }else{
	    	$scope.clearcolor('mode');
	    }
	    if ($scope.checkundefined($scope.mrg.currency)) {
	        msg = msg + "<li>Currency:Field is required.</li>";         
	        $scope.changecolor('currency');
	    }else{
	    	$scope.clearcolor('currency');
	    }
	    if ($scope.checkundefined($scope.mrg.term)) {
	        msg = msg + "<li>Term:Field is required.</li>";         
	        $scope.changecolor('term');
	    }else{
	    	$scope.clearcolor('term');
	    }
	    if ($scope.checkundefined($scope.mrg.validityDate)) {
	        msg = msg + "<li>ValidityDate:Field is required.</li>";         
	        $scope.changecolor('validityDate');
	    }else{
	    	$scope.clearcolor('validityDate');
	    }*/
	  
	  	    angular.forEach($scope.mrg.mrgDtl, function(chargesDetail, index) {
	        if ($scope.checkundefined(chargesDetail.chargeHeads)) {
	            msg = msg + "<li>Row :" + (index + 1) + "# Charge Head :Field is required.</li>";
	            $scope.changecolor('unit'+index);
	        }else{
	        	$scope.clearcolor('unit'+index);
	        }
	        if ($scope.checkundefined(chargesDetail.unit)) {
	            msg = msg + "<li>Row :" + (index + 1) + "# Unit :Field is required.</li>";
	            $scope.changecolor('qty'+index);
	            $('#qty'+index).find('input').css("border-color", "red");

	        }  else{
	        	 if (isNaN(chargesDetail.unit)) {
	        	       msg = msg + "<li>Row :" + (index + 1) + "# Unit :Not a valid input.</li>";
	     	          
	   	            $scope.changecolor('qty'+index);
	   	            $('#qty'+index).find('input').css("border-color", "red");
	        		  } else {
	        			  $scope.clearcolor('qty'+index);
	        		  }
	        	
	        }
	        /*if ($scope.checkundefined(chargesDetail.qty)) {
	            msg = msg + "<li>Row :" + (index + 1) + "# Qty :Field is required.</li>";
	            $scope.changecolor('qty'+index);
	            $('#qty'+index).find('input').css("border-color", "red");

	        }  else{
	        	 if (isNaN(chargesDetail.qty)) {
	        	       msg = msg + "<li>Row :" + (index + 1) + "# Qty :Not a valid input.</li>";
	     	          
	   	            $scope.changecolor('qty'+index);
	   	            $('#qty'+index).find('input').css("border-color", "red");
	        		  } else {
	        			  $scope.clearcolor('qty'+index);
	        		  }
	        	
	        }*/
	        if ($scope.checkundefined(chargesDetail.rate)) {
	            msg = msg + "<li>Row :" + (index + 1) + "# Rate :Field is required.</li>";
	            $scope.changecolor('qty'+index);
	            $('#qty'+index).find('input').css("border-color", "red");

	        }  else{
	        	 if (isNaN(chargesDetail.rate)) {
	        	       msg = msg + "<li>Row :" + (index + 1) + "# Rate :Not a valid input.</li>";
	     	          
	   	            $scope.changecolor('qty'+index);
	   	            $('#qty'+index).find('input').css("border-color", "red");
	        		  } else {
	        			  $scope.clearcolor('qty'+index);
	        		  }	        	
	        }	       
	        if ($scope.checkundefined(chargesDetail.currency)) {
	            msg = msg + "<li>Row :" + (index + 1) + "# Currency :Field is required.</li>";
	            $scope.changecolor('unit'+index);
	        }else{
	        	$scope.clearcolor('unit'+index);
	        }
	        if ($scope.checkundefined(chargesDetail.transactionType)) {
	            msg = msg + "<li>Row :" + (index + 1) + "# Transaction Type :Field is required.</li>";
	            $scope.changecolor('unit'+index);
	        }else{
	        	$scope.clearcolor('unit'+index);
	        }
	        if ($scope.checkundefined(chargesDetail.buySell)) {
	            msg = msg + "<li>Row :" + (index + 1) + "# Buy/Sell :Field is required.</li>";
	            $scope.changecolor('unit'+index);
	        }else{
	        	$scope.clearcolor('unit'+index);
	        }
	    });

	    alertmsg = alertmsg + msg + "</ui>";
	    if ($scope.checkundefined(msg)) {
	        return '';
	    } else {
	        return alertmsg;
	    }

	}

	$scope.checkMrgDetail =  function(MRG){
		
//		$scope.mrg.mrgDtl = MRG.mrgDtlorigin;
		
		angular.forEach(MRG.mrgDtldestination, function(row,index){
			if(row.chargeType != null && row.chargeType != "" && row.chargeType != undefined)
				{
				row.localchargFlag = "origin";
			$scope.mrg.mrgDtl.push(row);
				}
		})
			angular.forEach(MRG.mrgDtlorigin, function(row,index){
				if(row.chargeType != null && row.chargeType != "" && row.chargeType != undefined)
					{
					row.localchargFlag = "destnation";
					$scope.mrg.mrgDtl.push(row);
					}
				
		})
		
	}
	$scope.Submit=function(){
		/*$scope.checkMrgDetail($scope.mrg);
		delete $scope.mrg.mrgDtlorigin;
		delete $scope.mrg.mrgDtldestination;*/
		$scope.validation = true;
		if($scope.freightothersFlag)
		{
			
			if($scope.mrg.freightRemarks == ''|| $scope.mrg.freightRemarks == undefined || $scope.mrg.freightRemarks == null)
			{	$scope.validation = false;
				logger.logError("Please Enter Freight Other Remarks !");
			}
		}
		if($scope.mrg.cargoType == 'RFR' ||$scope.mrg.cargoType == '9'){
		if($scope.mrg.temp == ''|| $scope.mrg.temp == undefined || $scope.mrg.temp == null)
		{	$scope.validation = false;
			logger.logError("Please Enter Temp in Celcius!");
		}
		if($scope.mrg.humiditySetting == ''|| $scope.mrg.humiditySetting == undefined || $scope.mrg.humiditySetting == null)
		{	$scope.validation = false;
			logger.logError("Please Enter Humidity Setting !");
		}
		if($scope.mrg.ventsetting == ''|| $scope.mrg.ventsetting == undefined || $scope.mrg.ventsetting == null)
		{	$scope.validation = false;
			logger.logError("Please Enter Vent Setting !");
		}}
//		if($scope.files.length == 0){
//			$scope.validation = false;
//			logger.logError("Please Choose Cargo File Upload !");
//
//		}
		var count = 0;
//		for(var i=0 ; i < $scope.mrg.mrgFreeDaysDtl.length; i++){
//
//			if($scope.mrg.mrgFreeDaysDtl[i].polFreeDays=='' || $scope.mrg.mrgFreeDaysDtl[i].polFreeDays==undefined
//				&& $scope.mrg.mrgFreeDaysDtl[i].podFreeDays=='' || $scope.mrg.mrgFreeDaysDtl[i].podFreeDays==undefined){
//				 count++;
//				
//			}
//		}
		if(count > 0){
//			logger.logError("Please Enter the POL & POD Freedays");
		}else{
			if($scope.validation){
			var msg=$scope.checkValidation();
			if(!$scope.checkundefined(msg)){   
				logger.logError(msg);	
			}else{
	        if($scope.mrg.mrgDtl.length>0){
	        	$scope.mrg.status="Pending";
				$scope.check = true;
				if($scope.mrg.special == undefined){
					$scope.mrg.special ='';
				}
				if($scope.mrg.cargoType ==undefined){
					$scope.mrg.cargoType ='';
				}
				
//	        	$http.get($stateParams.tenantid+'/app/mrg/checkQuoteExists?pol='+$scope.mrg.pol+'&pod='+$scope.mrg.pod+'&customer='+$scope.mrg.customer+'&special='+$scope.mrg.special+'&cargoType='+$scope.mrg.cargoType).success(function(data) {
//					  if(data.success==true){
				$http.post($stateParams.tenantid+'/app/mrg/save',$scope.mrg).success(function(datas) {
					debugger
					  if(datas.success==true){					 
						  logger.logSuccess("Saved Successfully!!!");						  
						  $state.go('app.master.mrg.list',{tenantid:$stateParams.tenantid});
					        

					}else{
						  logger.logError(datas.message);
							$scope.check = false;
					  }
					}).error(function(data) {
						logger.logError("Please try again");
						$scope.check = false;

					});
//	        }else{
//
//	      		
//	    	      ngDialog.open({
//	                scope : $scope,
//	                template : 'views/master/inventory/mrg/mrgAlertForExists',
//	                controller : $controller('mrgAlertCtrl', {
//	                    $scope : $scope, 
//	                   // screenName: 'SeamrgmailView'
//	                }),
//	                className : 'ngdialog-theme-plain',
//	                showClose : false,
//	                closeByDocument : false,
//	                closeByEscape : false,
//	                preCloseCallback : $scope.getList
//	            });
//
//	      	
//	        }
//	        	});
			}
	        else{
	        	logger.logError("Atleast One Row Required");
	        }
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
                template : 'views/master/inventory/mrg/popDetail',
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
		
		$scope.checkMrgDetail($scope.mrg);

		

		$scope.validation = true;
		if($scope.freightothersFlag)
		{
			
			if($scope.mrg.freightRemarks == ''|| $scope.mrg.freightRemarks == undefined || $scope.mrg.freightRemarks == null)
			{	$scope.validation = false;
				logger.logError("Please Enter Freight Other Remarks !");
			}
		}
//		if($scope.mrg.cargoType == 'HAZ' ||$scope.mrg.cargoType == '4'){
//			if($scope.files1.length == 0 && $scope.mrg.files1 == 0){
//				$scope.validation = false;
//				logger.logError("Please Choose Approval File Upload !");
//
//			}
//		}
//		if($scope.mrg.classval == ''|| $scope.mrg.classval == undefined || $scope.mrg.classval == null)
//		{	$scope.validation = false;
//			logger.logError("Please Enter Class !");
//		}
//		if($scope.files.length == 0  && $scope.mrg.files == 0){
//			$scope.validation = false;
//			logger.logError("Please Choose Cargo File Upload !");
//
//		}
		var msg=$scope.checkValidation();
		if(!$scope.checkundefined(msg)){
			logger.logError(msg);
		}else{
			if($scope.validation){
			 if($scope.mrg.mrgDtl.length>0){
			$http.post($stateParams.tenantid+'/app/mrg/update',$scope.mrg).success(function(datas) {
				  if(datas.success==true){					
					  
					  logger.logSuccess("Updated Successfully!!!");					  					 		  
					  
					    $state.go('app.master.mrg.list',{tenantid:$stateParams.tenantid});

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
		
		
	}
	
	

	$scope.quoteNo1=$location.search().mrgNumber;
	
   	if($scope.quoteNo1 != '' && $scope.quoteNo1!=undefined){
   		

   		$scope.edit=true;
   		$scope.mrg.mrgDtl = [];
   		$http.post($stateParams.tenantid+'/app/mrg/edit',$scope.quoteNo1).success(function(datas) {
   			$scope.copy=true;
   			$scope.mrg = datas.mrgBean;
   			$scope.mrg.mrgDtl = datas.lmrgBean;
   			$scope.mrg.mrgDtlorigin =  datas.lmrgBeanorigin;
   			$scope.mrg.mrgDtldestination = datas.lmrgBeandestination;
   			
   			



   		 $http.post($stateParams.tenantid+'/app/seaquotation/getcommodity').success(function(data) { 
             $scope.commodityList = data.commonUtilityBean;
          	 $scope.compaccList = [];
          	 var valArr = $scope.mrg.commodity.split(',');
          	 var i = 0, size = valArr.length;
          	 for (i; i < size; i++) {
          	// $("#port").find("option[label=" + valArr[i] + "]").prop("selected", "selected");
          	 angular.forEach($scope.commodityList, function(value, key) {
          	 if (valArr[i] == value.id) {
          	 $scope.compaccList.push(value);
          	 }
          	 });
          	  
          	 }
            $scope.mrg.commodityL = $scope.compaccList;

          //	$scope.EmployeeMasterData.accessCat = $scope.compaccList;
          	 $timeout(function() { 
          		 $("#commodityL").multiselect('destroy');
          	 $("#commodityL").multiselect({
          	 maxHeight : 400,
          	 includeSelectAllOption : true,
          	 selectAllText : 'Select All',
          	 enableFiltering : true,
          	 enableCaseInsensitiveFiltering : true,
          	 filterPlaceholder : 'Search',
          	 numberDisplayed: 1,
          	 });
          	 }, 3, false);
          	 $("#multiselect-button").addClass("width_100 input-sm line-height-5");
          	 
          	
          	 
          	 });

   			for (var i = 0; i < $scope.mrg.mrgDtl.length; i++) {
   				$scope.mrg.mrgDtl[i].chargeHeads = $scope.mrg.mrgDtl[i].chargeHeads.toString();
   				$scope.mrg.mrgDtl[i].unit =$scope.mrg.mrgDtl[i].unit.toString();
   				$scope.mrg.mrgDtl[i].currency = $scope.mrg.mrgDtl[i].currency.toString();
   				$scope.mrg.mrgDtl[i].transactionType = $scope.mrg.mrgDtl[i].transactionType.toString();
   				$scope.mrg.mrgDtl[i].buySell = $scope.mrg.mrgDtl[i].buySell.toString();
			}
   		}).error(function(datas) {

   		});
    		
   	}
   	// MRG COPY 
   	$scope.MRGCopy=$location.search().MRGCopy;
   	if($scope.MRGCopy != '' && $scope.MRGCopy!=undefined){
		$scope.mrg.mrgDtl = [];
		$http.post($stateParams.tenantid+'/app/mrg/edit',$scope.MRGCopy).success(function(datas) {
			$scope.copy=true;
			
			$scope.mrg = datas.mrgBean;
			$scope.mrg.mrgDtl = [];
			$scope.mrg.mrgDtlorigin = [];
			$scope.mrg.mrgDtldestination = [];
			angular.forEach(datas.lmrgBean, function(row, index){
				if(row.localchargFlag == 'freight' ||row.localchargFlag == null ){
					
					$scope.mrg.mrgDtl.push(row);

				}
				if(row.localchargFlag == 'origin'){
					
	   			$scope.mrg.mrgDtlorigin.push(row);
				}
				if(row.localchargFlag == 'destnation'){
				
	   			$scope.mrg.mrgDtldestination.push(row);
				}
			});
			$scope.mrg.mrgFreeDaysDtl=datas.mrgFreeDaysDtl;

		$scope.freedays=$scope.mrg.mrgFreeDaysDtl;
		}).error(function(datas) {

		});
   	}
	
//   	?? END .........

   	$scope.copyView=function(mrgNumber){
   		$location.url($stateParams.tenantid+'/master/inventory/mrg/copy?mrgNumber=' + mrgNumber);
   	}
   	
	$scope.cancelDraft=function(){
		
		$state.go('app.master.mrg.list',{tenantid:$stateParams.tenantid});
	}
	
	//approval cancel
	$scope.cancelApproval=function(){
		
		$state.go('app.master.mrg.list',{tenantid:$stateParams.tenantid});
	}
	

	/*$scope.sendmail = function(mrgHdId){
		$http.get($stateParams.tenantid + '/app/seamrg/sendMail?mrgHdId='+mrgHdId)
		.success(function(datas) {
			logger.logSuccess('Mail Sent Successfully!')
		}).error(function(data) {

		});
	}
	
		
	$scope.printQuot = function(mrgHdId){
        debugger
        console.log("Both print invoice")
        var url = $stateParams.tenantid+'/app/seamrg/print?mrgHdId=' + mrgHdId;
        var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
        wnd.print();   
     }*/
	
	  $scope.Calculation = function(trindex,row) {
		  
		  if (row.noOfBox != 0 && row.noOfBox != "") {
			  if (row.quotedRate != 0 && row.quotedRate != "") {
			  
			  row.mrg=row.noOfBox*row.quotedRate;
			  
			  }  
		  }
		  


	  }
		$http.get($stateParams.tenantid+'/app/commonUtility/getcarrierList').success(function(datas) {
			debugger
		    $scope.carrierList = datas.commonUtilityBean;	    
            //$scope.transList = datas.lCommonUtilityBean;	    

		}).error(function(data) {

		});

	  
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
	    
	    $scope.checkundefined = function(value) {
	        var invalid = false;
	        if (value == undefined || value == 'undefined' || value == null || value == 'null' || value == '') {
	            invalid = true;
	        }
	        return invalid;

	    }
	    // END ...........
		$scope.secondFileUploadValdiationFlag = false;
		$scope.remarksFlag = false;
		$scope.rfrFlag =false;
//	    $scope.fileupload2man  = function(cargotype)  {
		
		  $scope.$watch('mrg.cargoType', function(newValue, oldValue) {
	    	if(newValue == 4 || newValue == "HAZ"){
	    		$scope.secondFileUploadValdiationFlag = true;
	    	}else{
	    		$scope.secondFileUploadValdiationFlag = false;
	    	} 
	    	if(newValue == 8 || newValue == "OOG"){
	    		$scope.remarksFlag = true;
	    	}else{
	    		$scope.remarksFlag = false;
	    	}
	    	if(newValue == 9 || newValue == "RFR"){
	    		$scope.rfrFlag = true;
	    	}else{
	    		$scope.rfrFlag = false;
	    	}
	    });
			$scope.freightothersFlag = false;
		  $scope.$watch('mrg.freight', function(newValue, oldValue) {
		    	if(newValue == 4 || newValue == "Others"){
		    		$scope.freightothersFlag = true;
//		    		var check = document.getElementById("freightRemarks");
//		    		check.
		    		var x = document.getElementById("freightRemarks");   // Get the element with id="demo"
//		    		x.validation = "required";   
		    	}else{
		    		$scope.freightothersFlag = false;
		    	}
		    	
		    });
		  
		  $scope.feederRateList = [];
			$scope.$watchCollection('[mrg.pol,mrg.pod,mrg.mrgDate,mrg.validTill]',function(newValue, oldValue) {
				if($scope.mrg.pol != null && $scope.mrg.pol != undefined && $scope.mrg.pol != "" &&
						$scope.mrg.pod != null && $scope.mrg.pod != undefined && $scope.mrg.pod != ""&&
						$scope.mrg.validTill != null && $scope.mrg.validTill != undefined && $scope.mrg.validTill != ""){
					if(true == true){

					$http.get($stateParams.tenantid+'/app/mrg/getFeederDetail?pol='+ $scope.mrg.pol + '&pod='+$scope.mrg.pod+ '&validfrom='+$scope.mrg.mrgDate+ '&validTill='+$scope.mrg.validTill).success(function(datas) {
						  $scope.feederRateList = [];
						angular.forEach(datas, function(row,index){
		   	   				if(row.quotedRate != 0){
		   	   			  $scope.feederRateList.push(row);
		   	   				}
		   	   			});
					});
					}
				}
			});	    
});



app.controller('mrgdetailtableCtrl', function($scope, $http, $filter, logger,$stateParams) {
	 $scope.$watch('mrg.mrgDtl[trIndex].transactionType', function(newValue, oldValue) {
		 var id = newValue;

			if(newValue != "" && newValue != null && newValue != undefined ){ 
				$http.post($stateParams.tenantid+'/app/seaquotation/getServicePartnerList').success(function(datas) {				 
					if(newValue==1){					 
					 $scope.serviceParnrDropList=datas.vendorMasterList;
				 }else if(newValue==2){
					 $scope.serviceParnrDropList=datas.serviceParnrList;
				 }
				}).error(function(data) {

				});
			}
			/*$http.get($stateParams.tenantid+'/app/seaquotation/getServicePartnerListid?id='+ id).success(function(datas) {
				console.log(datas);				
				 $scope.serviceParnrDropList=datas.serviceParnrList;
			  
			}).error(function(data) {

			});*/
	  });
});

app.controller('mrgViewCtrl', function($scope, $timeout, $stateParams,sharedProperties,toaster,
		$filter, $rootScope, $http, $location, logger, $state, ngDialog,$controller,$injector,utilsService,$window) {

//   	$scope.Viewmrg =  function(){
//    location.reload();
	var grantTotal = 0;
	$scope.shipmentTermlist = [
	     {id: '1', text: 'Collect'},
	    {id: '2', text: 'Prepaid'},
	    {id: '3', text: 'Third Party Collect'},
	    {id: '4', text: 'Others'}
	  ];

	$scope.cancelDraft=function(){		
		$state.go('app.master.mrg.list',{tenantid:$stateParams.tenantid});
	}
   		$scope.quoteNo1=$location.search().mrgNumber;
   		
   	   	if($scope.quoteNo1 != '' && $scope.quoteNo1!=undefined){
   	   		$scope.edit=true;
   	   		$http.post($stateParams.tenantid+'/app/mrg/view',$scope.quoteNo1).success(function(datas) {
   	   			$scope.copy=true;
   	   			
   	   			$scope.mrg = datas.mrgBean;
   	   			$scope.mrg.mrgDtl=datas.lmrgBean;
   	   			$scope.mrg.mrgDtlorigin =datas.lmrgBeanorigin;
   	   			$scope.mrg.mrgDtldestination = datas.lmrgBeandestination;
   	   		}).error(function(datas) {

   	   		});
   	    		
//   	   	}
   	   	
   	}
   	   	
   	   	
   	   	
   	   	
   		$scope.quickLinkMethd=function(mrg,qulkVal){
   			if(qulkVal == 'Customer Master'){
//   				/customer/Edit?custCode=CU0021
				$location.url($stateParams.tenantid+'/customer/View?custCode='+mrg.customer1); 

   			}
   			if(qulkVal == 'Cost Matrix'){

   				/*
   			    $scope.local = {
   						    		lcNo:'',
   									agent : '',
   									port : '',
   									surcharge:'',
   									fromDate : '',
   									basis :'Type',
   									toDate : '',
   									localDtl : [],
   									localDtl1 : []
   					    		}

   					$scope.tempLocalDtl = {
   			    		dock:'',
   						berth : '',
   						surcharge:'',
   						containerType : '',
   						hazardous : '',
   						hazardous5_1:'',
   						emptyRepo:'',
   			            stuffing: '',
   						currency: '',
   						amount: '',
   						amountline: '',
   						select : false,
   						tax:'',
   						revenueRecovery:'',
   						creditToagent:'',
   						creditToprinicipal:'',
   						slabRate :[{
   							from:'',
   				    		to:'',
   				    		rateDay:''
   						}]
   					}	
   			    
   				$scope.tempLocalDtl1 = {
   						surcharge:'',
   						containerType : '',
   						currency: '',
   						amount: '',
   						select : false,
   						type : '',
   						revenueRecovery:'',
   						creditToagent:'',
   						creditToprinicipal:''
   					}	
   			    
   			   $scope.local.localDtl.push($scope.tempLocalDtl);
   			   $scope.local.localDtl1.push($scope.tempLocalDtl1);

   			   
   			   

  				$scope.local.fromDate = mrg.mrgDate;
  				$scope.local.toDate = mrg.validTill;
  				$scope.local.port = mrg.pol1;
  			

  		        angular.forEach(mrg.mrgDtl, function(row, index) {
  		        	if(index > 0){

  	   					$scope.tempLocalDtlnew = {
  	   			    		dock:'',
  	   						berth : '',
  	   						surcharge:'',
  	   						containerType : '',
  	   						hazardous : '',
  	   						hazardous5_1:'',
  	   						emptyRepo:'',
  	   			            stuffing: '',
  	   						currency: '',
  	   						amount: '',
  	   						amountline: '',
  	   						select : false,
  	   						tax:'',
  	   						revenueRecovery:'',
  	   						creditToagent:'',
  	   						creditToprinicipal:'',
  	   						slabRate :[{
  	   							from:'',
  	   				    		to:'',
  	   				    		rateDay:''
  	   						}]
  	   					}	
  	   			    
//  		        		$scope.quotation.quotationDtl.push($scope.quotation.quotationDtl[0]);
  		   			   $scope.local.localDtl.push($scope.tempLocalDtlnew);
  		        	}
  		        	$scope.local.localDtl[index].surcharge=row.chargeType1;
  		        	$scope.local.localDtl[index].containerType=row.conType;
   		        	$scope.local.localDtl[index].currency=row.currencyCode;
  		        	$scope.local.localDtl[index].amount=row.quotedRate;

  		        });
  		 

	   		 $rootScope.costMatrixfromMRG = $scope.local;*/
	   		 $location.url($stateParams.tenantid+"/operation/costmatrix/list"); 
//	   		 $state.go('app.operation.localchargescost.add',{tenantid:$stateParams.tenantid});
			}
   			if(qulkVal == 'Sailing schedule'){
//				/customer/Edit?custCode=CU0021
			$location.url($stateParams.tenantid+'/voyage/thirdPartyVoyage/thirdPartyVoyageList'); 

			}
   			if(qulkVal == 'Rate request'){
//				/customer/Edit?custCode=CU0021
   		

   				$scope.ratequotation={
   						service:'',
   						aol:'',
   						origin:'',
   						customer:'',
   						salesPerson:'',
   						vendor : '', 
   						attention : '',
   						ratequotationDate : '',
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
   						files : '',
   						files1 : '',
   						files2 : '',
   						pot:'',
   						servicetype:'',
   						freightRemarks:'',
   						bltype:'',
   						cargoDesc:'',
   						filePath:'',
   						filePath1:'',
   						issueDate:'',
   						freightRequested:'',
   						calssval:'',
   						humiditySetting:'',
   						ventsetting:'',
   						temp:'',	
   						ApproveFlagMRG:false,
   						detentionratequotationType:'SC0009',
   						ratequotationDtl:[{id:0,chargeHeads:'',unit:'',currency:'',qty:'',rate:'',localCurrency:'',paymentMethod : '',transactionType : '',buySell : '',note : '',freeDays:0,volume:'',approvedRate:0}],
   						ratequotationDtlCopy:[{id:0,chargeHeads:'',unit:'',currency:'',qty:'',rate:'',localCurrency:'',paymentMethod : '',transactionType : '',buySell : '',note : '',freeDays:0}],
   						ratequotationFreeDaysDtl : [{id:0,conType:'',polFreeDays:'',podFreeDays:'',polFreeDaysdemurrage:'',podFreeDaysdemurrage:'',polFreeDaysApproved:'',podFreeDaysApproved:'',polFreeDaysDMApproved:'',podFreeDaysDMApproved:''}]
   						/*ratequotationFreeDaysDtl : []*/
   				}

   				
   				
   				$scope.ratequotation.customer = mrg.customer1;
   				$scope.ratequotation.quotationDate = mrg.mrgDate;
   				$scope.ratequotation.validTill = mrg.validTill;
   				$scope.ratequotation.pod = mrg.pod1;
   				$scope.ratequotation.pol = mrg.pol1;
   				$scope.ratequotation.pot = mrg.pot1;
   				$scope.ratequotation.cargoType = mrg.cargoType1;
   				$scope.ratequotation.currencyName = mrg.currencyCode;
   				$scope.ratequotation.freight = mrg.freight1;
   				$scope.ratequotation.origin = mrg.origin1;
   				$scope.ratequotation.destination1 = mrg.destinationName;
   				$scope.ratequotation.cargoDesc = mrg.cargoDesc;
   				
   				
   		        angular.forEach(mrg.mrgDtl, function(row, index) {
   		        	if(index > 0){
//   		        		$scope.quotation.quotationDtl.push($scope.quotation.quotationDtl[0]);
   						var ratequotedtl = {id:0,chargeHeads:'',unit:'',currency:'',qty:'',rate:'',localCurrency:'',paymentMethod : '',transactionType : '',buySell : '',note : '',freeDays:0,volume:'',approvedRate:0};
   						$scope.ratequotation.ratequotationDtl.push(ratequotedtl);
   		        	}
   		        	$scope.ratequotation.ratequotationDtl[index].chargeType=row.chargeType1;
   		        	$scope.ratequotation.ratequotationDtl[index].conType=row.conType;
   		        	$scope.ratequotation.ratequotationDtl[index].hazardous=row.hazardous;
   		        	$scope.ratequotation.ratequotationDtl[index].oog=row.oog;
   		        	$scope.ratequotation.ratequotationDtl[index].tariff=row.tariff;
   		        	$scope.ratequotation.ratequotationDtl[index].localCurrency=row.localCurrency;
   		        	$scope.ratequotation.ratequotationDtl[index].quotedRate=row.quotedRate;

   		        });
   		 angular.forEach(mrg.mrgFreeDaysDtl, function(row1, index1) {
   			  	if(index1 > 0){
   		    		$scope.ratequotation.ratequotationFreeDaysDtl.push($scope.ratequotation.ratequotationFreeDaysDtl);
   		    	}
   			 $scope.ratequotation.ratequotationFreeDaysDtl[index1].conType=row1.conType;
   		 	$scope.ratequotation.ratequotationFreeDaysDtl[index1].polFreeDays=row1.polFreeDays;
   		 	$scope.ratequotation.ratequotationFreeDaysDtl[index1].polFreeDaysdemurrage=row1.polFreeDaysdemurrage;
   		 	$scope.ratequotation.ratequotationFreeDaysDtl[index1].podFreeDays=row1.podFreeDays;
   		 	$scope.ratequotation.ratequotationFreeDaysDtl[index1].podFreeDaysdemurrage=row1.podFreeDaysdemurrage;
   		        });
   		 
   		 $rootScope.ratequotationfromMRG = $scope.ratequotation;
//   		 $location.url($stateParams.tenantid+"/master/inventory/ratequotation/Add"); 
//   		 $state.go('app.commercial.ratequotation.add',{tenantid:$stateParams.tenantid});
   		 $state.go('app.crm.ratequotation.list',{tenantid:$stateParams.tenantid});

			}
   			

 			if(qulkVal == 'Feeder Matrix'){
//				/customer/Edit?custCode=CU0021
			$location.url($stateParams.tenantid+'/operation/FeederRates/list'); 

			}
 			if(qulkVal == 'SRG'){
//				/customer/Edit?custCode=CU0021
			$location.url($stateParams.tenantid+'/search/StandardRoutingGuide/list'); 

			}
   		}
   		$
   		$scope.searchView = function(pol , pod,hdrpol,hdrpod, conType,Haz,rfr,oog){
   			
   			var hdrpolNew = hdrpol.split("-");
   			hdrpol = hdrpolNew[0];
   			var hdrpodNew = hdrpod.split("-");
   			hdrpod = hdrpodNew[0];
   			if(conType == undefined){
					conType = '';
				}
				if(Haz == undefined){
					Haz = false;
				}
				if(rfr == undefined){
					rfr = false;
				}
				if(oog == undefined){
					oog = false;
				}
   			if(hdrpol == pol && hdrpod == hdrpod){
   				
   			  			
   			
//   			$scope.mrgDtlTemp = $scope.mrg.mrgDtl;
//   			$scope.mrgDtlTemporigin = $scope.mrg.mrgDtlorigin;
//   			$scope.mrgDtlTempdest = $scope.mrg.mrgDtldestination;
   				if(conType == undefined){
   					conType = '';
   				}
   				if(Haz == undefined){
   					Haz = false;
   				}
   				if(rfr == undefined){
   					rfr = false;
   				}
   				if(oog == undefined){
   					oog = false;
   				}
   				
   			if(conType!= null && conType!= undefined && conType!= "" && Haz ==  false && rfr ==  false && oog ==  false){
   				var conTypenew = [];
   				conTypenew.push(conType);
   			var total = 0;
   			var freight = 0;
   			var origin = 0;
   			var dest = 0;
   			$scope.mrg.mrgDtl = [];
   			$scope.mrg.mrgDtlorigin = [];
   			$scope.mrg.mrgDtldestination = [];
   			angular.forEach(conTypenew, function(row,index){

   			angular.forEach($scope.mrgDtlTemp, function(row1,index1){
   				if(row1.conType == row){
   					if(row1.chargeType != "IMCO / HAZARDOUS SURCHARGE"  &&  row1.chargeType != "REEFER SURCHARGE" 
   						&&  row1.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES" &&  row1.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){
   					$scope.mrg.mrgDtl.push(row1);
   					freight = freight + row1.quotedRate;
   					}
   				}
   			})
   			
   			angular.forEach($scope.mrgDtlTemporigin, function(row2,index2){
   				if(row2.conType == row){
   					if(row2.chargeType != "IMCO / HAZARDOUS SURCHARGE" &&  row2.chargeType != "REEFER SURCHARGE"
   						&&  row2.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES" &&  row2.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){
   					$scope.mrg.mrgDtlorigin.push(row2);
   					origin = origin + row2.quotedRate;
   					}
   				}
   			})
   			
   			angular.forEach($scope.mrgDtlTempdest, function(row3,index3){
   				if(row3.conType == row){
   					if(row3.chargeType != "IMCO / HAZARDOUS SURCHARGE" &&  row3.chargeType != "REEFER SURCHARGE"
   						&&  row3.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES" &&  row3.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){
   					$scope.mrg.mrgDtldestination.push(row3);
   					dest = dest + row3.quotedRate;
   					}
   				}
   			})
   			});
   			$scope.mrgtotal =  Number(freight + origin + dest ).toFixed(2); 
   			$scope.mrgFreighttotal =  Number(freight ).toFixed(2);
   			$scope.mrgOrigintotal =  Number(origin).toFixed(2); 
   			$scope.mrgDesttotal =  Number(dest ).toFixed(2); 
//   			$scope.mrgtotal = 	$scope.mrgFreighttotal + 	$scope.mrgOrigintotal + 	$scope.mrgDesttotal; 

   		}else if(conType == null || conType == undefined || conType == "" && Haz ==  true  && rfr ==  false && oog ==  false){
//   		 if(conType!= null && conType!= undefined && conType!= "" && Haz ==  true)

   			var total = 0;

   			var freight = 0;
   			var origin = 0;
   			var dest = 0;
   			$scope.mrg.mrgDtl = [];
   			$scope.mrg.mrgDtlorigin = [];
   			$scope.mrg.mrgDtldestination = [];
//   			angular.forEach(conType, function(row,index){

   			angular.forEach($scope.mrgDtlTemp, function(row1,index1){
//   				if(row1.hazardous == Haz){
   				if(row1.chargeType == "IMCO / HAZARDOUS SURCHARGE" ){
   					$scope.mrg.mrgDtl.push(row1);
   					freight = freight + row1.quotedRate;
   				}
   			})
   			
   			angular.forEach($scope.mrgDtlTemporigin, function(row2,index2){
//   				if(row1.hazardous  ==  Haz){
   				if(row2.chargeType == "IMCO / HAZARDOUS SURCHARGE" ){
   					$scope.mrg.mrgDtlorigin.push(row2);
   					origin = origin + row2.quotedRate;
   				}
   			})
   			
   			angular.forEach($scope.mrgDtlTempdest, function(row3,index3){
//   				if(row1.hazardous  ==  Haz){
   				if(row3.chargeType == "IMCO / HAZARDOUS SURCHARGE" ){
   					$scope.mrg.mrgDtldestination.push(row3);
   					dest = dest + row3.quotedRate;
   				}
   			})
//   			});
   			$scope.mrgtotal =  Number(freight + origin + dest ).toFixed(2); 
   			$scope.mrgFreighttotal =  Number(freight ).toFixed(2);
   			$scope.mrgOrigintotal =  Number(origin).toFixed(2); 
   			$scope.mrgDesttotal =  Number(dest ).toFixed(2); 
//   			$scope.mrgtotal = 	$scope.mrgFreighttotal + 	$scope.mrgOrigintotal + 	$scope.mrgDesttotal; 

   		}else if(conType!= null && conType!= undefined && conType!= "" && Haz ==  true && rfr ==  false && oog ==  false){

   			var total = 0;

   			var freight = 0;
   			var origin = 0;
   			var dest = 0;
   				var conTypeNew = [conType];
//   				conTypeNew.push();
   				
   			var total = 0;
   			$scope.mrg.mrgDtl = [];
   			$scope.mrg.mrgDtlorigin = [];
   			$scope.mrg.mrgDtldestination = [];
   			angular.forEach(conTypeNew, function(row,index){

   			angular.forEach($scope.mrgDtlTemp, function(row1,index1){
   				if(row1.conType == row){
   					if(row1.chargeType != "IMCO / HAZARDOUS SURCHARGE" &&  row1.chargeType != "REEFER SURCHARGE" 
   						&&  row1.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES" &&  row1.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){
   					$scope.mrg.mrgDtl.push(row1);
	   					freight = freight + row1.quotedRate;	 
   					}if(row1.chargeType == "IMCO / HAZARDOUS SURCHARGE"){
   					$scope.mrg.mrgDtl.push(row1);
	   					freight = freight + row1.quotedRate;	 
   					}
//   					if(row1.hazardous  ==  Haz){
//   					if(row1.chargeType == "IMCO / HAZARDOUS SURCHARGE" ){
//   					$scope.mrg.mrgDtl.push(row1);
//   					freight = freight + row1.quotedRate;
   				}
//   					if(row1.chargeType == "IMCO / HAZARDOUS SURCHARGE" ){
//   	   					$scope.mrg.mrgDtl.push(row1);
//   	   					freight = freight + row1.quotedRate;
//   	   				}
//   				}
   			});
   			
   			angular.forEach($scope.mrgDtlTemporigin, function(row2,index2){
   				if(row2.conType == row){
//   					if(row1.hazardous  ==  Haz){
					if(row2.chargeType != "IMCO / HAZARDOUS SURCHARGE" &&  row2.chargeType != "REEFER SURCHARGE" 
   						&&  row2.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES" &&  row2.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){

   					$scope.mrg.mrgDtlorigin.push(row2);
   					origin = origin + row2.quotedRate;
   					}
					if(row2.chargeType == "IMCO / HAZARDOUS SURCHARGE"){

	   					$scope.mrg.mrgDtlorigin.push(row2);
	   					origin = origin + row2.quotedRate;
					}
   				}
//   				if(row2.chargeType == "IMCO / HAZARDOUS SURCHARGE" ){
//   					$scope.mrg.mrgDtlorigin.push(row2);
//   					origin = origin + row2.quotedRate;
//   					}
   			});
   			
   			angular.forEach($scope.mrgDtlTempdest, function(row3,index3){
   				if(row3.conType == row){
//   					if(row1.hazardous  ==  Haz){
					if(row3.chargeType != "IMCO / HAZARDOUS SURCHARGE" &&  row3.chargeType != "REEFER SURCHARGE" 
   						&&  row3.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES" &&  row3.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){

   					$scope.mrg.mrgDtldestination.push(row3);
   					dest = dest + row3.quotedRate;   					}
					if(row3.chargeType == "IMCO / HAZARDOUS SURCHARGE"){

	   					$scope.mrg.mrgDtldestination.push(row3);
	   					dest = dest + row3.quotedRate;					}
   				}
//   					if(row1.hazardous  ==  Haz){
//   					if(row3.chargeType == "IMCO / HAZARDOUS SURCHARGE" ){
//   					$scope.mrg.mrgDtldestination.push(row3);
//   					dest = dest + row3.quotedRate;
//   					}
//   				}
   			})
   			});
   			$scope.mrgtotal =  Number(freight + origin + dest ).toFixed(2); 
   			$scope.mrgFreighttotal =  Number(freight ).toFixed(2);
   			$scope.mrgOrigintotal =  Number(origin).toFixed(2); 
   			$scope.mrgDesttotal =  Number(dest ).toFixed(2); 
//   			$scope.mrgtotal = 	$scope.mrgFreighttotal + 	Number($scope.mrgOrigintotal,0) + 	$scope.mrgDesttotal; 

   		}
   		else if(conType!= null && conType!= undefined && conType!= "" && Haz ==  true && rfr ==  true && oog ==  false){

   			var total = 0;

   			var freight = 0;
   			var origin = 0;
   			var dest = 0;
   				var conTypeNew = [conType];
//   				conTypeNew.push();
   				
   			var total = 0;
   			$scope.mrg.mrgDtl = [];
   			$scope.mrg.mrgDtlorigin = [];
   			$scope.mrg.mrgDtldestination = [];
   			angular.forEach(conTypeNew, function(row,index){

   			angular.forEach($scope.mrgDtlTemp, function(row1,index1){
   				if(row1.conType == row){
   					if(row1.chargeType != "IMCO / HAZARDOUS SURCHARGE" &&  row1.chargeType != "REEFER SURCHARGE" 
   						&&  row1.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES" &&  row1.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){
   					$scope.mrg.mrgDtl.push(row1);
	   					freight = freight + row1.quotedRate;	 
   					}
   					if(row1.chargeType == "REEFER SURCHARGE" || row1.chargeType == "IMCO / HAZARDOUS SURCHARGE" 
   						&&  row1.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES" &&  row1.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){
   					$scope.mrg.mrgDtl.push(row1);
	   					freight = freight + row1.quotedRate;	 
   					}
//   					if(row1.hazardous  ==  Haz){
//   					if(row1.chargeType == "IMCO / HAZARDOUS SURCHARGE" ){
//   					$scope.mrg.mrgDtl.push(row1);
//   					freight = freight + row1.quotedRate;
   				}
//   					if(row1.chargeType == "IMCO / HAZARDOUS SURCHARGE" ){
//   	   					$scope.mrg.mrgDtl.push(row1);
//   	   					freight = freight + row1.quotedRate;
//   	   				}
//   				}
   			});
   			
   			angular.forEach($scope.mrgDtlTemporigin, function(row2,index2){
   				if(row2.conType == row){
//   					if(row1.hazardous  ==  Haz){
					if(row2.chargeType != "IMCO / HAZARDOUS SURCHARGE" &&  row2.chargeType != "REEFER SURCHARGE" 
   						&&  row2.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES" &&  row2.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){

   					$scope.mrg.mrgDtlorigin.push(row2);
					origin = origin + row2.quotedRate;
   					}
					if(row2.chargeType == "REEFER SURCHARGE" ||  row2.chargeType == "IMCO / HAZARDOUS SURCHARGE" 
   						&&  row2.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES" &&  row2.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){

	   					$scope.mrg.mrgDtlorigin.push(row2);
   					origin = origin + row2.quotedRate;
					}
   				}
//   				if(row2.chargeType == "IMCO / HAZARDOUS SURCHARGE" ){
//   					$scope.mrg.mrgDtlorigin.push(row2);
//   					origin = origin + row2.quotedRate;
//   					}
   			});
   			
   			angular.forEach($scope.mrgDtlTempdest, function(row3,index3){
   				if(row3.conType == row){
//   					if(row1.hazardous  ==  Haz){
					if(row3.chargeType != "IMCO / HAZARDOUS SURCHARGE" &&  row3.chargeType != "REEFER SURCHARGE" 
   						&&  row3.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES" &&  row3.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){

   					$scope.mrg.mrgDtldestination.push(row3);
					dest = dest + row3.quotedRate;
   					}
					if(row3.chargeType == "REEFER SURCHARGE" ||  row3.chargeType == "IMCO / HAZARDOUS SURCHARGE" 
   						&&  row3.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES" &&  row3.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){

	   					$scope.mrg.mrgDtldestination.push(row3);
   					dest = dest + row3.quotedRate;
					}
   				}
//   					if(row1.hazardous  ==  Haz){
//   					if(row3.chargeType == "IMCO / HAZARDOUS SURCHARGE" ){
//   					$scope.mrg.mrgDtldestination.push(row3);
//   					dest = dest + row3.quotedRate;
//   					}
//   				}
   			})
   			});
   			$scope.mrgtotal =  Number(freight + origin + dest ).toFixed(2); 
   			$scope.mrgFreighttotal =  Number(freight ).toFixed(2);
   			$scope.mrgOrigintotal =  Number(origin).toFixed(2); 
   			$scope.mrgDesttotal =  Number(dest ).toFixed(2); 
//   			$scope.mrgtotal = 	$scope.mrgFreighttotal + 	Number($scope.mrgOrigintotal,0) + 	$scope.mrgDesttotal; 

   		}
   			
   		else if(conType!= null && conType!= undefined && conType!= "" && Haz ==  false && rfr ==  true && oog ==  false){

   			var total = 0;

   			var freight = 0;
   			var origin = 0;
   			var dest = 0;
   				var conTypeNew = [conType];
//   				conTypeNew.push();
   				
   			var total = 0;
   			$scope.mrg.mrgDtl = [];
   			$scope.mrg.mrgDtlorigin = [];
   			$scope.mrg.mrgDtldestination = [];
   			angular.forEach(conTypeNew, function(row,index){

   			angular.forEach($scope.mrgDtlTemp, function(row1,index1){
   				if(row1.conType == row){
   					if(row1.chargeType != "IMCO / HAZARDOUS SURCHARGE" &&  row1.chargeType != "REEFER SURCHARGE" 
   						&&  row1.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES" &&  row1.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){
   					$scope.mrg.mrgDtl.push(row1);
	   					freight = freight + row1.quotedRate;	 
   					}
   					if(row1.chargeType == "REEFER SURCHARGE" && row1.chargeType != "IMCO / HAZARDOUS SURCHARGE" 
   						&&  row1.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES" &&  row1.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){
   					$scope.mrg.mrgDtl.push(row1);
	   					freight = freight + row1.quotedRate;	 
   					}
//   					if(row1.hazardous  ==  Haz){
//   					if(row1.chargeType == "IMCO / HAZARDOUS SURCHARGE" ){
//   					$scope.mrg.mrgDtl.push(row1);
//   					freight = freight + row1.quotedRate;
   				}
//   					if(row1.chargeType == "IMCO / HAZARDOUS SURCHARGE" ){
//   	   					$scope.mrg.mrgDtl.push(row1);
//   	   					freight = freight + row1.quotedRate;
//   	   				}
//   				}
   			});
   			
   			angular.forEach($scope.mrgDtlTemporigin, function(row2,index2){
   				if(row2.conType == row){
//   					if(row1.hazardous  ==  Haz){
					if(row2.chargeType != "IMCO / HAZARDOUS SURCHARGE" &&  row2.chargeType != "REEFER SURCHARGE" 
   						&&  row2.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES" &&  row2.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){

   					$scope.mrg.mrgDtlorigin.push(row2);
   					origin = origin + row2.quotedRate;
   					}
					if(row2.chargeType == "REEFER SURCHARGE"  &&  row2.chargeType != "IMCO / HAZARDOUS SURCHARGE" 
   						&&  row2.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES" &&  row2.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){

	   					$scope.mrg.mrgDtlorigin.push(row2);
	   					origin = origin + row2.quotedRate;
					}
   				}
//   				if(row2.chargeType == "IMCO / HAZARDOUS SURCHARGE" ){
//   					$scope.mrg.mrgDtlorigin.push(row2);
//   					origin = origin + row2.quotedRate;
//   					}
   			});
   			
   			angular.forEach($scope.mrgDtlTempdest, function(row3,index3){
   				if(row3.conType == row){
//   					if(row1.hazardous  ==  Haz){
					if(row3.chargeType != "IMCO / HAZARDOUS SURCHARGE" &&  row3.chargeType != "REEFER SURCHARGE" 
   						&&  row3.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES" &&  row3.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){

   					$scope.mrg.mrgDtldestination.push(row3);
   					dest = dest + row3.quotedRate;
   					}
					if(row3.chargeType == "REEFER SURCHARGE"  &&  row2.chargeType != "IMCO / HAZARDOUS SURCHARGE" 
   						&&  row3.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES" &&  row3.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){

	   					$scope.mrg.mrgDtldestination.push(row3);
	   					dest = dest + row3.quotedRate;
					}
   				}
//   					if(row1.hazardous  ==  Haz){
//   					if(row3.chargeType == "IMCO / HAZARDOUS SURCHARGE" ){
//   					$scope.mrg.mrgDtldestination.push(row3);
//   					dest = dest + row3.quotedRate;
//   					}
//   				}
   			})
   			});
   			$scope.mrgtotal =  Number(freight + origin + dest ).toFixed(2); 
   			$scope.mrgFreighttotal =  Number(freight ).toFixed(2);
   			$scope.mrgOrigintotal =  Number(origin).toFixed(2); 
   			$scope.mrgDesttotal =  Number(dest ).toFixed(2); 
//   			$scope.mrgtotal = 	$scope.mrgFreighttotal + 	Number($scope.mrgOrigintotal,0) + 	$scope.mrgDesttotal; 

   		}

   		else if(conType== null && conType== undefined && conType== "" && Haz ==  false && rfr ==  true && oog ==  false){

   			var total = 0;

   			var freight = 0;
   			var origin = 0;
   			var dest = 0;
   				var conTypeNew = [conType];
//   				conTypeNew.push();
   				
   			var total = 0;
   			$scope.mrg.mrgDtl = [];
   			$scope.mrg.mrgDtlorigin = [];
   			$scope.mrg.mrgDtldestination = [];
   			angular.forEach(conTypeNew, function(row,index){

   			angular.forEach($scope.mrgDtlTemp, function(row1,index1){
   				if(row1.conType == row){
//   					if(row1.chargeType != "IMCO / HAZARDOUS SURCHARGE" &&  row1.chargeType != "REEFER SURCHARGE" 
//   						&&  row1.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES" &&  row1.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){
//   					$scope.mrg.mrgDtl.push(row1);
//	   					freight = freight + row1.quotedRate;	 
//   					}
   					if(row1.chargeType == "REEFER SURCHARGE" ){
   					$scope.mrg.mrgDtl.push(row1);
	   					freight = freight + row1.quotedRate;	 
   					}
//   					if(row1.hazardous  ==  Haz){
//   					if(row1.chargeType == "IMCO / HAZARDOUS SURCHARGE" ){
//   					$scope.mrg.mrgDtl.push(row1);
//   					freight = freight + row1.quotedRate;
   				}
//   					if(row1.chargeType == "IMCO / HAZARDOUS SURCHARGE" ){
//   	   					$scope.mrg.mrgDtl.push(row1);
//   	   					freight = freight + row1.quotedRate;
//   	   				}
//   				}
   			});
   			
   			angular.forEach($scope.mrgDtlTemporigin, function(row2,index2){
   				if(row2.conType == row){
//   					if(row1.hazardous  ==  Haz){
//					if(row1.chargeType != "IMCO / HAZARDOUS SURCHARGE" &&  row2.chargeType != "REEFER SURCHARGE" 
//   						&&  row2.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES" &&  row2.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){
//
//   					$scope.mrg.mrgDtlorigin.push(row2);
//   					origin = origin + row2.quotedRate;
//   					}
   					if(row2.chargeType == "REEFER SURCHARGE" ){
	   					$scope.mrg.mrgDtlorigin.push(row2);
	   					origin = origin + row2.quotedRate;
					}
   				}
//   				if(row2.chargeType == "IMCO / HAZARDOUS SURCHARGE" ){
//   					$scope.mrg.mrgDtlorigin.push(row2);
//   					origin = origin + row2.quotedRate;
//   					}
   			});
   			
   			angular.forEach($scope.mrgDtlTempdest, function(row3,index3){
   				if(row3.conType == row){
//   					if(row1.hazardous  ==  Haz){
//					if(row1.chargeType != "IMCO / HAZARDOUS SURCHARGE" &&  row3.chargeType != "REEFER SURCHARGE" 
//   						&&  row3.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES" &&  row3.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){
//
//   					$scope.mrg.mrgDtlorigin.push(row3);
//   					origin = origin + row3.quotedRate;
//   					}
   					if(row3.chargeType == "REEFER SURCHARGE" ){
	   					$scope.mrg.mrgDtldestination.push(row3);
	   					dest = dest + row3.quotedRate;
					}
   				}
//   					if(row1.hazardous  ==  Haz){
//   					if(row3.chargeType == "IMCO / HAZARDOUS SURCHARGE" ){
//   					$scope.mrg.mrgDtldestination.push(row3);
//   					dest = dest + row3.quotedRate;
//   					}
//   				}
   			})
   			});
   			$scope.mrgtotal =  Number(freight + origin + dest ).toFixed(2); 
   			$scope.mrgFreighttotal =  Number(freight ).toFixed(2);
   			$scope.mrgOrigintotal =  Number(origin).toFixed(2); 
   			$scope.mrgDesttotal =  Number(dest ).toFixed(2); 
//   			$scope.mrgtotal = 	$scope.mrgFreighttotal + 	Number($scope.mrgOrigintotal,0) + 	$scope.mrgDesttotal; 

   		}

   			
   		else if(conType!= null && conType!= undefined && conType!= "" && Haz ==  false && rfr ==  false && oog ==  true){

   			var total = 0;

   			var freight = 0;
   			var origin = 0;
   			var dest = 0;
   				var conTypeNew = [conType];
//   				conTypeNew.push();
   				
   			var total = 0;
   			$scope.mrg.mrgDtl = [];
   			$scope.mrg.mrgDtlorigin = [];
   			$scope.mrg.mrgDtldestination = [];
   			angular.forEach(conTypeNew, function(row,index){

   			angular.forEach($scope.mrgDtlTemp, function(row1,index1){
   				if(row1.conType == row){
   					if(row1.chargeType != "IMCO / HAZARDOUS SURCHARGE" &&  row1.chargeType != "REEFER SURCHARGE" 
   						&&  row1.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES" &&  row1.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){
   					$scope.mrg.mrgDtl.push(row1);
	   					freight = freight + row1.quotedRate;	 
   					}
   					if(row1.chargeType != "REEFER SURCHARGE" && row1.chargeType != "IMCO / HAZARDOUS SURCHARGE" 
   						&&  row1.chargeType == "CRANAGE / OOG SPECIAL GEAR SURCHARGES" ||  row1.chargeType ==  "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){
   					$scope.mrg.mrgDtl.push(row1);
	   					freight = freight + row1.quotedRate;	 
   					}
//   					if(row1.hazardous  ==  Haz){
//   					if(row1.chargeType == "IMCO / HAZARDOUS SURCHARGE" ){
//   					$scope.mrg.mrgDtl.push(row1);
//   					freight = freight + row1.quotedRate;
   				}
//   					if(row1.chargeType == "IMCO / HAZARDOUS SURCHARGE" ){
//   	   					$scope.mrg.mrgDtl.push(row1);
//   	   					freight = freight + row1.quotedRate;
//   	   				}
//   				}
   			});
   			
   			angular.forEach($scope.mrgDtlTemporigin, function(row2,index2){
   				if(row2.conType == row){
//   					if(row1.hazardous  ==  Haz){
					if(row2.chargeType != "IMCO / HAZARDOUS SURCHARGE" &&  row2.chargeType != "REEFER SURCHARGE" 
   						&&  row2.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES" &&  row2.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){

   					$scope.mrg.mrgDtlorigin.push(row2);
   					origin = origin + row2.quotedRate;
   					}
					if(row2.chargeType  !=  "REEFER SURCHARGE"  &&  row2.chargeType != "IMCO / HAZARDOUS SURCHARGE" 
   						&&  row2.chargeType== "CRANAGE / OOG SPECIAL GEAR SURCHARGES"  || row2.chargeType== "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){

	   					$scope.mrg.mrgDtlorigin.push(row2);
	   					origin = origin + row2.quotedRate;
					}
   				}
//   				if(row2.chargeType == "IMCO / HAZARDOUS SURCHARGE" ){
//   					$scope.mrg.mrgDtlorigin.push(row2);
//   					origin = origin + row2.quotedRate;
//   					}
   			});
   			
   			angular.forEach($scope.mrgDtlTempdest, function(row3,index3){
   				if(row3.conType == row){
//   					if(row1.hazardous  ==  Haz){
					if(row3.chargeType != "IMCO / HAZARDOUS SURCHARGE" &&  row3.chargeType != "REEFER SURCHARGE" 
   						&&  row3.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES" &&  row3.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){

   					$scope.mrg.mrgDtldestination.push(row3);
   					dest = dest + row3.quotedRate;
   					}
					if(row3.chargeType !=  "REEFER SURCHARGE"  &&  row3.chargeType != "IMCO / HAZARDOUS SURCHARGE" 
   						&&  row3.chargeType ==  "CRANAGE / OOG SPECIAL GEAR SURCHARGES"  || row3.chargeType == "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){

	   					$scope.mrg.mrgDtldestination.push(row3);
	   					dest = dest + row3.quotedRate;
					}
   				}
//   					if(row1.hazardous  ==  Haz){
//   					if(row3.chargeType == "IMCO / HAZARDOUS SURCHARGE" ){
//   					$scope.mrg.mrgDtldestination.push(row3);
//   					dest = dest + row3.quotedRate;
//   					}
//   				}
   			})
   			});
   			$scope.mrgtotal =  Number(freight + origin + dest ).toFixed(2); 
   			$scope.mrgFreighttotal =  Number(freight ).toFixed(2);
   			$scope.mrgOrigintotal =  Number(origin).toFixed(2); 
   			$scope.mrgDesttotal =  Number(dest ).toFixed(2); 
//   			$scope.mrgtotal = 	$scope.mrgFreighttotal + 	Number($scope.mrgOrigintotal,0) + 	$scope.mrgDesttotal; 

   		}

   			
   		else if(conType!= null && conType!= undefined && conType!= "" && Haz ==  true && rfr ==  false && oog ==  true){

   			var total = 0;

   			var freight = 0;
   			var origin = 0;
   			var dest = 0;
   				var conTypeNew = [conType];
//   				conTypeNew.push();
   				
   			var total = 0;
   			$scope.mrg.mrgDtl = [];
   			$scope.mrg.mrgDtlorigin = [];
   			$scope.mrg.mrgDtldestination = [];
   			angular.forEach(conTypeNew, function(row,index){

   			angular.forEach($scope.mrgDtlTemp, function(row1,index1){
   				if(row1.conType == row){
   					if(row1.chargeType != "IMCO / HAZARDOUS SURCHARGE" &&  row1.chargeType != "REEFER SURCHARGE" 
   						&&  row1.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES" &&row1.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){
   					$scope.mrg.mrgDtl.push(row1);
	   					freight = freight + row1.quotedRate;	 
   					}
   					if( row1.chargeType == "IMCO / HAZARDOUS SURCHARGE" ){
   					$scope.mrg.mrgDtl.push(row1);
	   					freight = freight + row1.quotedRate;	 
   					}
   					if( row1.chargeType =="CRANAGE / OOG SPECIAL GEAR SURCHARGES" ){
   					$scope.mrg.mrgDtl.push(row1);
	   					freight = freight + row1.quotedRate;	 
   					}
   					if(row1.chargeType ==  "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){
   					$scope.mrg.mrgDtl.push(row1);
	   					freight = freight + row1.quotedRate;	 
   					}
//   					if(row1.hazardous  ==  Haz){
//   					if(row1.chargeType == "IMCO / HAZARDOUS SURCHARGE" ){
//   					$scope.mrg.mrgDtl.push(row1);
//   					freight = freight + row1.quotedRate;
   				}
//   					if(row1.chargeType == "IMCO / HAZARDOUS SURCHARGE" ){
//   	   					$scope.mrg.mrgDtl.push(row1);
//   	   					freight = freight + row1.quotedRate;
//   	   				}
//   				}
   			});
   			
   			angular.forEach($scope.mrgDtlTemporigin, function(row2,index2){
   				if(row2.conType == row){
//   					if(row1.hazardous  ==  Haz){
					if(row2.chargeType != "IMCO / HAZARDOUS SURCHARGE"
						&&  row2.chargeType !=  "REEFER SURCHARGE" 
   						&&  row2.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES" 
   						&&  row2.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){

   					$scope.mrg.mrgDtlorigin.push(row2);
   					origin = origin + row2.quotedRate;
   					}
					if( row2.chargeType == "IMCO / HAZARDOUS SURCHARGE"){

	   					$scope.mrg.mrgDtlorigin.push(row2);
	   					origin = origin + row2.quotedRate;
					}
					if(row2.chargeType== "CRANAGE / OOG SPECIAL GEAR SURCHARGES"){

	   					$scope.mrg.mrgDtlorigin.push(row2);
	   					origin = origin + row2.quotedRate;
					}
					if(row2.chargeType== "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){

	   					$scope.mrg.mrgDtlorigin.push(row2);
	   					origin = origin + row2.quotedRate;
					}
   				}
//   				if(row2.chargeType == "IMCO / HAZARDOUS SURCHARGE" ){
//   					$scope.mrg.mrgDtlorigin.push(row2);
//   					origin = origin + row2.quotedRate;
//   					}
   			});
   			
   			angular.forEach($scope.mrgDtlTempdest, function(row3,index3){
   				if(row3.conType == row){
//   					if(row1.hazardous  ==  Haz){
					if(row3.chargeType != "IMCO / HAZARDOUS SURCHARGE" &&  row3.chargeType != "REEFER SURCHARGE" 
   						&&  row3.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES" && row3.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){

   					$scope.mrg.mrgDtldestination.push(row3);
   					dest = dest + row3.quotedRate;
   					}
					if(  row3.chargeType ==  "IMCO / HAZARDOUS SURCHARGE"){

	   					$scope.mrg.mrgDtldestination.push(row3);
	   					dest = dest + row3.quotedRate;
					}
					if(row3.chargeType ==  "CRANAGE / OOG SPECIAL GEAR SURCHARGES"){

	   					$scope.mrg.mrgDtldestination.push(row3);
	   					dest = dest + row3.quotedRate;
					}
					if(row3.chargeType == "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){

	   					$scope.mrg.mrgDtldestination.push(row3);
	   					dest = dest + row3.quotedRate;
					}
   				}
//   					if(row1.hazardous  ==  Haz){
//   					if(row3.chargeType == "IMCO / HAZARDOUS SURCHARGE" ){
//   					$scope.mrg.mrgDtldestination.push(row3);
//   					dest = dest + row3.quotedRate;
//   					}
//   				}
   			})
   			});
   			$scope.mrgtotal =  Number(freight + origin + dest ).toFixed(2); 
   			$scope.mrgFreighttotal =  Number(freight ).toFixed(2);
   			$scope.mrgOrigintotal =  Number(origin).toFixed(2); 
   			$scope.mrgDesttotal =  Number(dest ).toFixed(2); 
//   			$scope.mrgtotal = 	$scope.mrgFreighttotal + 	Number($scope.mrgOrigintotal,0) + 	$scope.mrgDesttotal; 

   		}
   		else if(conType!= null && conType!= undefined && conType!= "" && Haz ==  false && rfr ==  true && oog ==  true){

   			var total = 0;

   			var freight = 0;
   			var origin = 0;
   			var dest = 0;
   				var conTypeNew = [conType];
//   				conTypeNew.push();
   				
   			var total = 0;
   			$scope.mrg.mrgDtl = [];
   			$scope.mrg.mrgDtlorigin = [];
   			$scope.mrg.mrgDtldestination = [];
   			angular.forEach(conTypeNew, function(row,index){

   			angular.forEach($scope.mrgDtlTemp, function(row1,index1){
   				if(row1.conType == row){
   					if(row1.chargeType != "IMCO / HAZARDOUS SURCHARGE" &&  row1.chargeType != "REEFER SURCHARGE" 
   						&&  row1.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES" && row1.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){
   					$scope.mrg.mrgDtl.push(row1);
	   					freight = freight + row1.quotedRate;	 
   					}
   					if(row1.chargeType == "REEFER SURCHARGE"){
   					$scope.mrg.mrgDtl.push(row1);
	   					freight = freight + row1.quotedRate;	 
   					}
//   					if(row1.chargeType != "IMCO / HAZARDOUS SURCHARGE"){
//   					$scope.mrg.mrgDtl.push(row1);
//	   					freight = freight + row1.quotedRate;	 
//   					}
   					if(row1.chargeType == "CRANAGE / OOG SPECIAL GEAR SURCHARGES" || row1.chargeType ==  "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){
   					$scope.mrg.mrgDtl.push(row1);
	   					freight = freight + row1.quotedRate;	 
   					}
//   					if(row1.hazardous  ==  Haz){
//   					if(row1.chargeType == "IMCO / HAZARDOUS SURCHARGE" ){
//   					$scope.mrg.mrgDtl.push(row1);
//   					freight = freight + row1.quotedRate;
   				}
//   					if(row1.chargeType == "IMCO / HAZARDOUS SURCHARGE" ){
//   	   					$scope.mrg.mrgDtl.push(row1);
//   	   					freight = freight + row1.quotedRate;
//   	   				}
//   				}
   			});
   			
   			angular.forEach($scope.mrgDtlTemporigin, function(row2,index2){
   				if(row2.conType == row){
//   					if(row1.hazardous  ==  Haz){
					if(row2.chargeType != "IMCO / HAZARDOUS SURCHARGE" &&  row2.chargeType != "REEFER SURCHARGE" 
   						&&  row2.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES" &&  row2.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){

   					$scope.mrg.mrgDtlorigin.push(row2);
   					origin = origin + row2.quotedRate;
   					}
					if(row2.chargeType == "REEFER SURCHARGE"){

	   					$scope.mrg.mrgDtlorigin.push(row2);
	   					origin = origin + row2.quotedRate;
					}
					if(row2.chargeType== "CRANAGE / OOG SPECIAL GEAR SURCHARGES" || row2.chargeType== "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){

	   					$scope.mrg.mrgDtlorigin.push(row2);
	   					origin = origin + row2.quotedRate;
					}
					
   				}
//   				if(row2.chargeType == "IMCO / HAZARDOUS SURCHARGE" ){
//   					$scope.mrg.mrgDtlorigin.push(row2);
//   					origin = origin + row2.quotedRate;
//   					}
   			});
   			
   			angular.forEach($scope.mrgDtlTempdest, function(row3,index3){
   				if(row3.conType == row){
//   					if(row1.hazardous  ==  Haz){
					if(row3.chargeType != "IMCO / HAZARDOUS SURCHARGE" &&  row3.chargeType != "REEFER SURCHARGE" 
   						&&  row3.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES" && row3.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){

   					$scope.mrg.mrgDtldestination.push(row3);
   					dest = dest + row3.quotedRate;
   					}
					if(row3.chargeType == "REEFER SURCHARGE"){

	   					$scope.mrg.mrgDtldestination.push(row3);
	   					dest = dest + row3.quotedRate;
					}
					
					if(row3.chargeType ==  "CRANAGE / OOG SPECIAL GEAR SURCHARGES" ||  row3.chargeType == "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){

	   					$scope.mrg.mrgDtlorigin.push(row3);
	   					dest = dest + row3.quotedRate;
					}
   				}
//   					if(row1.hazardous  ==  Haz){
//   					if(row3.chargeType == "IMCO / HAZARDOUS SURCHARGE" ){
//   					$scope.mrg.mrgDtldestination.push(row3);
//   					dest = dest + row3.quotedRate;
//   					}
//   				}
   			})
   			});
   			$scope.mrgtotal =  Number(freight + origin + dest ).toFixed(2); 
   			$scope.mrgFreighttotal =  Number(freight ).toFixed(2);
   			$scope.mrgOrigintotal =  Number(origin).toFixed(2); 
   			$scope.mrgDesttotal =  Number(dest ).toFixed(2); 
//   			$scope.mrgtotal = 	$scope.mrgFreighttotal + 	Number($scope.mrgOrigintotal,0) + 	$scope.mrgDesttotal; 

   		}


   		else if(conType!= null && conType!= undefined && conType!= "" && Haz ==  true && rfr ==  true && oog ==  true){

   			var total = 0;

   			var freight = 0;
   			var origin = 0;
   			var dest = 0;
   				var conTypeNew = [conType];
//   				conTypeNew.push();
   				
   			var total = 0;
   			$scope.mrg.mrgDtl = [];
   			$scope.mrg.mrgDtlorigin = [];
   			$scope.mrg.mrgDtldestination = [];
   			angular.forEach(conTypeNew, function(row,index){

   			angular.forEach($scope.mrgDtlTemp, function(row1,index1){
   				if(row1.conType == row){
   					if(row1.chargeType != "IMCO / HAZARDOUS SURCHARGE" &&  row1.chargeType != "REEFER SURCHARGE" 
   						&&  row1.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES" && row1.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){
   					$scope.mrg.mrgDtl.push(row1);
	   					freight = freight + row1.quotedRate;	 
   					}
   					if(row1.chargeType == "REEFER SURCHARGE"){
   					$scope.mrg.mrgDtl.push(row1);
	   					freight = freight + row1.quotedRate;	 
   					}
   					if( row1.chargeType ==  "IMCO / HAZARDOUS SURCHARGE"){
   					$scope.mrg.mrgDtl.push(row1);
	   					freight = freight + row1.quotedRate;	 
   					}
   					if(row1.chargeType == "CRANAGE / OOG SPECIAL GEAR SURCHARGES" || row1.chargeType ==  "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){
   					$scope.mrg.mrgDtl.push(row1);
	   					freight = freight + row1.quotedRate;	 
   					}
//   					if(row1.hazardous  ==  Haz){
//   					if(row1.chargeType == "IMCO / HAZARDOUS SURCHARGE" ){
//   					$scope.mrg.mrgDtl.push(row1);
//   					freight = freight + row1.quotedRate;
   				}
//   					if(row1.chargeType == "IMCO / HAZARDOUS SURCHARGE" ){
//   	   					$scope.mrg.mrgDtl.push(row1);
//   	   					freight = freight + row1.quotedRate;
//   	   				}
//   				}
   			});
   			
   			angular.forEach($scope.mrgDtlTemporigin, function(row2,index2){
   				if(row2.conType == row){
//   					if(row1.hazardous  ==  Haz){
					if(row2.chargeType != "IMCO / HAZARDOUS SURCHARGE" &&  row2.chargeType != "REEFER SURCHARGE" 
   						&&  row2.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES" && row2.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){

   					$scope.mrg.mrgDtlorigin.push(row2);
   					origin = origin + row2.quotedRate;
   					}
					if(row2.chargeType == "REEFER SURCHARGE"){

	   					$scope.mrg.mrgDtlorigin.push(row2);
	   					origin = origin + row2.quotedRate;
					}
					if( row2.chargeType == "IMCO / HAZARDOUS SURCHARGE"){

	   					$scope.mrg.mrgDtlorigin.push(row2);
	   					origin = origin + row2.quotedRate;
					}
					if( row2.chargeType== "CRANAGE / OOG SPECIAL GEAR SURCHARGES" || row2.chargeType== "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){

	   					$scope.mrg.mrgDtlorigin.push(row2);
	   					origin = origin + row2.quotedRate;
					}
   				}
//   				if(row2.chargeType == "IMCO / HAZARDOUS SURCHARGE" ){
//   					$scope.mrg.mrgDtlorigin.push(row2);
//   					origin = origin + row2.quotedRate;
//   					}
   			});
   			
   			angular.forEach($scope.mrgDtlTempdest, function(row3,index3){
   				if(row3.conType == row){
//   					if(row1.hazardous  ==  Haz){
					if(row3.chargeType != "IMCO / HAZARDOUS SURCHARGE" &&  row3.chargeType != "REEFER SURCHARGE" 
   						&&  row3.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES" &&  row3.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){

   					$scope.mrg.mrgDtldestination.push(row3);
   					dest = dest + row3.quotedRate;
   					}
					if(row3.chargeType == "REEFER SURCHARGE"){

	   					$scope.mrg.mrgDtldestination.push(row3);
	   					dest = dest + row3.quotedRate;
					}
					if( row3.chargeType  == "IMCO / HAZARDOUS SURCHARGE"){

	   					$scope.mrg.mrgDtlorigin.push(row3);
	   					dest = dest + row3.quotedRate;
					}
					if(row3.chargeType ==  "CRANAGE / OOG SPECIAL GEAR SURCHARGES" ||  row3.chargeType == "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){

	   					$scope.mrg.mrgDtlorigin.push(row3);
	   					dest = dest + row3.quotedRate;
					}
   				}
//   					if(row1.hazardous  ==  Haz){
//   					if(row3.chargeType == "IMCO / HAZARDOUS SURCHARGE" ){
//   					$scope.mrg.mrgDtldestination.push(row3);
//   					dest = dest + row3.quotedRate;
//   					}
//   				}
   			})
   			});
   			$scope.mrgtotal =  Number(freight + origin + dest ).toFixed(2); 
   			$scope.mrgFreighttotal =  Number(freight ).toFixed(2);
   			$scope.mrgOrigintotal =  Number(origin).toFixed(2); 
   			$scope.mrgDesttotal =  Number(dest ).toFixed(2); 
//   			$scope.mrgtotal = 	$scope.mrgFreighttotal + 	Number($scope.mrgOrigintotal,0) + 	$scope.mrgDesttotal; 

   		}

   		else if(conType== null && conType== undefined && conType== "" && Haz ==  false && rfr ==  false && oog ==  true){

   			var total = 0;

   			var freight = 0;
   			var origin = 0;
   			var dest = 0;
   				var conTypeNew = [conType];
//   				conTypeNew.push();
   				
   			var total = 0;
   			$scope.mrg.mrgDtl = [];
   			$scope.mrg.mrgDtlorigin = [];
   			$scope.mrg.mrgDtldestination = [];
   			angular.forEach(conTypeNew, function(row,index){

   			angular.forEach($scope.mrgDtlTemp, function(row1,index1){
   				if(row1.conType == row){
//   					if(row1.chargeType != "IMCO / HAZARDOUS SURCHARGE" &&  row1.chargeType != "REEFER SURCHARGE" 
//   						&&  row1.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES" &&  row1.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){
//   					$scope.mrg.mrgDtl.push(row1);
//	   					freight = freight + row1.quotedRate;	 
//   					}
   					if(row1.chargeType ==   "CRANAGE / OOG SPECIAL GEAR SURCHARGES" ||  row3.chargeType == "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)" ){
   					$scope.mrg.mrgDtl.push(row1);
	   					freight = freight + row1.quotedRate;	 
   					}
//   					if(row1.hazardous  ==  Haz){
//   					if(row1.chargeType == "IMCO / HAZARDOUS SURCHARGE" ){
//   					$scope.mrg.mrgDtl.push(row1);
//   					freight = freight + row1.quotedRate;
   				}
//   					if(row1.chargeType == "IMCO / HAZARDOUS SURCHARGE" ){
//   	   					$scope.mrg.mrgDtl.push(row1);
//   	   					freight = freight + row1.quotedRate;
//   	   				}
//   				}
   			});
   			
   			angular.forEach($scope.mrgDtlTemporigin, function(row2,index2){
   				if(row2.conType == row){
//   					if(row1.hazardous  ==  Haz){
//					if(row1.chargeType != "IMCO / HAZARDOUS SURCHARGE" &&  row2.chargeType != "REEFER SURCHARGE" 
//   						&&  row2.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES" &&  row2.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){
//
//   					$scope.mrg.mrgDtlorigin.push(row2);
//   					origin = origin + row2.quotedRate;
//   					}
   					if(row2.chargeType ==   "CRANAGE / OOG SPECIAL GEAR SURCHARGES" ||  row3.chargeType == "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)" ){
	   					$scope.mrg.mrgDtlorigin.push(row2);
	   					origin = origin + row2.quotedRate;
					}
   				}
//   				if(row2.chargeType == "IMCO / HAZARDOUS SURCHARGE" ){
//   					$scope.mrg.mrgDtlorigin.push(row2);
//   					origin = origin + row2.quotedRate;
//   					}
   			});
   			
   			angular.forEach($scope.mrgDtlTempdest, function(row3,index3){
   				if(row3.conType == row){
//   					if(row1.hazardous  ==  Haz){
//					if(row1.chargeType != "IMCO / HAZARDOUS SURCHARGE" &&  row3.chargeType != "REEFER SURCHARGE" 
//   						&&  row3.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES" &&  row3.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){
//
//   					$scope.mrg.mrgDtlorigin.push(row3);
//   					origin = origin + row3.quotedRate;
//   					}
   					if(row3.chargeType ==  "CRANAGE / OOG SPECIAL GEAR SURCHARGES" ||  row3.chargeType == "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){
	   					$scope.mrg.mrgDtldestination.push(row3);
	   					dest = dest + row3.quotedRate;
					}
   				}
//   					if(row1.hazardous  ==  Haz){
//   					if(row3.chargeType == "IMCO / HAZARDOUS SURCHARGE" ){
//   					$scope.mrg.mrgDtldestination.push(row3);
//   					dest = dest + row3.quotedRate;
//   					}
//   				}
   			})
   			});
   			$scope.mrgtotal =  Number(freight + origin + dest ).toFixed(2); 
   			$scope.mrgFreighttotal =  Number(freight ).toFixed(2);
   			$scope.mrgOrigintotal =  Number(origin).toFixed(2); 
   			$scope.mrgDesttotal =  Number(dest ).toFixed(2); 
//   			$scope.mrgtotal = 	$scope.mrgFreighttotal + 	Number($scope.mrgOrigintotal,0) + 	$scope.mrgDesttotal; 

   		}

   		else if(conType== null && conType== undefined && conType== "" && Haz ==  true && rfr ==  true && oog ==  false){

   			var total = 0;

   			var freight = 0;
   			var origin = 0;
   			var dest = 0;
   				var conTypeNew = [conType];
//   				conTypeNew.push();
   				
   			var total = 0;
   			$scope.mrg.mrgDtl = [];
   			$scope.mrg.mrgDtlorigin = [];
   			$scope.mrg.mrgDtldestination = [];
   			angular.forEach(conTypeNew, function(row,index){

   			angular.forEach($scope.mrgDtlTemp, function(row1,index1){
   				if(row1.conType == row){
//   					if(row1.chargeType != "IMCO / HAZARDOUS SURCHARGE" &&  row1.chargeType != "REEFER SURCHARGE" 
//   						&&  row1.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES" &&  row1.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){
//   					$scope.mrg.mrgDtl.push(row1);
//	   					freight = freight + row1.quotedRate;	 
//   					}
   					if(row1.chargeType ==  "IMCO / HAZARDOUS SURCHARGE" ||row1.chargeType ==  "REEFER SURCHARGE" ){
   					$scope.mrg.mrgDtl.push(row1);
	   					freight = freight + row1.quotedRate;	 
   					}
//   					if(row1.hazardous  ==  Haz){
//   					if(row1.chargeType == "IMCO / HAZARDOUS SURCHARGE" ){
//   					$scope.mrg.mrgDtl.push(row1);
//   					freight = freight + row1.quotedRate;
   				}
//   					if(row1.chargeType == "IMCO / HAZARDOUS SURCHARGE" ){
//   	   					$scope.mrg.mrgDtl.push(row1);
//   	   					freight = freight + row1.quotedRate;
//   	   				}
//   				}
   			});
   			
   			angular.forEach($scope.mrgDtlTemporigin, function(row2,index2){
   				if(row2.conType == row){
//   					if(row1.hazardous  ==  Haz){
//					if(row1.chargeType != "IMCO / HAZARDOUS SURCHARGE" &&  row2.chargeType != "REEFER SURCHARGE" 
//   						&&  row2.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES" &&  row2.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){
//
//   					$scope.mrg.mrgDtlorigin.push(row2);
//   					origin = origin + row2.quotedRate;
//   					}
   					if(row2.chargeType ==  "IMCO / HAZARDOUS SURCHARGE" ||row2.chargeType ==  "REEFER SURCHARGE" ){
	   					$scope.mrg.mrgDtlorigin.push(row2);
	   					origin = origin + row2.quotedRate;
					}
   				}
//   				if(row2.chargeType == "IMCO / HAZARDOUS SURCHARGE" ){
//   					$scope.mrg.mrgDtlorigin.push(row2);
//   					origin = origin + row2.quotedRate;
//   					}
   			});
   			
   			angular.forEach($scope.mrgDtlTempdest, function(row3,index3){
   				if(row3.conType == row){
//   					if(row1.hazardous  ==  Haz){
//					if(row1.chargeType != "IMCO / HAZARDOUS SURCHARGE" &&  row3.chargeType != "REEFER SURCHARGE" 
//   						&&  row3.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES" &&  row3.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){
//
//   					$scope.mrg.mrgDtlorigin.push(row3);
//   					origin = origin + row3.quotedRate;
//   					}
   					if(row3.chargeType ==  "IMCO / HAZARDOUS SURCHARGE" ||row3.chargeType ==  "REEFER SURCHARGE" ){
	   					$scope.mrg.mrgDtldestination.push(row3);
	   					dest = dest + row3.quotedRate;
					}
   				}
//   					if(row1.hazardous  ==  Haz){
//   					if(row3.chargeType == "IMCO / HAZARDOUS SURCHARGE" ){
//   					$scope.mrg.mrgDtldestination.push(row3);
//   					dest = dest + row3.quotedRate;
//   					}
//   				}
   			})
   			});
   			$scope.mrgtotal =  Number(freight + origin + dest ).toFixed(2); 
   			$scope.mrgFreighttotal =  Number(freight ).toFixed(2);
   			$scope.mrgOrigintotal =  Number(origin).toFixed(2); 
   			$scope.mrgDesttotal =  Number(dest ).toFixed(2); 
//   			$scope.mrgtotal = 	$scope.mrgFreighttotal + 	Number($scope.mrgOrigintotal,0) + 	$scope.mrgDesttotal; 

   		}

   		else if(conType== null && conType== undefined && conType== "" && Haz ==  true && rfr ==  true && oog ==  true){

   			var total = 0;

   			var freight = 0;
   			var origin = 0;
   			var dest = 0;
   				var conTypeNew = [conType];
//   				conTypeNew.push();
   				
   			var total = 0;
   			$scope.mrg.mrgDtl = [];
   			$scope.mrg.mrgDtlorigin = [];
   			$scope.mrg.mrgDtldestination = [];
   			angular.forEach(conTypeNew, function(row,index){

   			angular.forEach($scope.mrgDtlTemp, function(row1,index1){
   				if(row1.conType == row){
//   					if(row1.chargeType != "IMCO / HAZARDOUS SURCHARGE" &&  row1.chargeType != "REEFER SURCHARGE" 
//   						&&  row1.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES" &&  row1.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){
//   					$scope.mrg.mrgDtl.push(row1);
//	   					freight = freight + row1.quotedRate;	 
//   					}
   					if(row1.chargeType ==  "IMCO / HAZARDOUS SURCHARGE" ||row1.chargeType ==  "REEFER SURCHARGE" ||
   							row1.chargeType == "CRANAGE / OOG SPECIAL GEAR SURCHARGES" || row1.chargeType == "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){
   					$scope.mrg.mrgDtl.push(row1);
	   					freight = freight + row1.quotedRate;	 
   					}
//   					if(row1.hazardous  ==  Haz){
//   					if(row1.chargeType == "IMCO / HAZARDOUS SURCHARGE" ){
//   					$scope.mrg.mrgDtl.push(row1);
//   					freight = freight + row1.quotedRate;
   				}
//   					if(row1.chargeType == "IMCO / HAZARDOUS SURCHARGE" ){
//   	   					$scope.mrg.mrgDtl.push(row1);
//   	   					freight = freight + row1.quotedRate;
//   	   				}
//   				}
   			});
   			
   			angular.forEach($scope.mrgDtlTemporigin, function(row2,index2){
   				if(row2.conType == row){
//   					if(row1.hazardous  ==  Haz){
//					if(row1.chargeType != "IMCO / HAZARDOUS SURCHARGE" &&  row2.chargeType != "REEFER SURCHARGE" 
//   						&&  row2.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES" &&  row2.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){
//
//   					$scope.mrg.mrgDtlorigin.push(row2);
//   					origin = origin + row2.quotedRate;
//   					}
   					if(row2.chargeType ==  "IMCO / HAZARDOUS SURCHARGE" ||row2.chargeType ==  "REEFER SURCHARGE" ||
   							row2.chargeType == "CRANAGE / OOG SPECIAL GEAR SURCHARGES" || row2.chargeType == "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){	   					$scope.mrg.mrgDtlorigin.push(row2);
	   					origin = origin + row2.quotedRate;
					}
   				}
//   				if(row2.chargeType == "IMCO / HAZARDOUS SURCHARGE" ){
//   					$scope.mrg.mrgDtlorigin.push(row2);
//   					origin = origin + row2.quotedRate;
//   					}
   			});
   			
   			angular.forEach($scope.mrgDtlTempdest, function(row3,index3){
   				if(row3.conType == row){
//   					if(row1.hazardous  ==  Haz){
//					if(row1.chargeType != "IMCO / HAZARDOUS SURCHARGE" &&  row3.chargeType != "REEFER SURCHARGE" 
//   						&&  row3.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES" &&  row3.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){
//
//   					$scope.mrg.mrgDtlorigin.push(row3);
//   					origin = origin + row3.quotedRate;
//   					}
   					if(row3.chargeType ==  "IMCO / HAZARDOUS SURCHARGE" ||row3.chargeType ==  "REEFER SURCHARGE" ||
   							row3.chargeType == "CRANAGE / OOG SPECIAL GEAR SURCHARGES" || row3.chargeType == "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){	   					$scope.mrg.mrgDtlorigin.push(row3);
   	   					$scope.mrg.mrgDtldestination.push(row3);
	   					dest = dest + row3.quotedRate;
					}
   				}
//   					if(row1.hazardous  ==  Haz){
//   					if(row3.chargeType == "IMCO / HAZARDOUS SURCHARGE" ){
//   					$scope.mrg.mrgDtldestination.push(row3);
//   					dest = dest + row3.quotedRate;
//   					}
//   				}
   			})
   			});
   			$scope.mrgtotal =  Number(freight + origin + dest ).toFixed(2); 
   			$scope.mrgFreighttotal =  Number(freight ).toFixed(2);
   			$scope.mrgOrigintotal =  Number(origin).toFixed(2); 
   			$scope.mrgDesttotal =  Number(dest ).toFixed(2); 
//   			$scope.mrgtotal = 	$scope.mrgFreighttotal + 	Number($scope.mrgOrigintotal,0) + 	$scope.mrgDesttotal; 

   		}

   		else if(conType== null && conType== undefined && conType== "" && Haz ==  true && rfr ==  false && oog ==  true){

   			var total = 0;

   			var freight = 0;
   			var origin = 0;
   			var dest = 0;
   				var conTypeNew = [conType];
//   				conTypeNew.push();
   				
   			var total = 0;
   			$scope.mrg.mrgDtl = [];
   			$scope.mrg.mrgDtlorigin = [];
   			$scope.mrg.mrgDtldestination = [];
   			angular.forEach(conTypeNew, function(row,index){

   			angular.forEach($scope.mrgDtlTemp, function(row1,index1){
   				if(row1.conType == row){
//   					if(row1.chargeType != "IMCO / HAZARDOUS SURCHARGE" &&  row1.chargeType != "REEFER SURCHARGE" 
//   						&&  row1.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES" &&  row1.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){
//   					$scope.mrg.mrgDtl.push(row1);
//	   					freight = freight + row1.quotedRate;	 
//   					}
   					if(row1.chargeType ==  "IMCO / HAZARDOUS SURCHARGE" || "CRANAGE / OOG SPECIAL GEAR SURCHARGES" || "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){
   					$scope.mrg.mrgDtl.push(row1);
	   					freight = freight + row1.quotedRate;	 
   					}
//   					if(row1.hazardous  ==  Haz){
//   					if(row1.chargeType == "IMCO / HAZARDOUS SURCHARGE" ){
//   					$scope.mrg.mrgDtl.push(row1);
//   					freight = freight + row1.quotedRate;
   				}
//   					if(row1.chargeType == "IMCO / HAZARDOUS SURCHARGE" ){
//   	   					$scope.mrg.mrgDtl.push(row1);
//   	   					freight = freight + row1.quotedRate;
//   	   				}
//   				}
   			});
   			
   			angular.forEach($scope.mrgDtlTemporigin, function(row2,index2){
   				if(row2.conType == row){
//   					if(row1.hazardous  ==  Haz){
//					if(row1.chargeType != "IMCO / HAZARDOUS SURCHARGE" &&  row2.chargeType != "REEFER SURCHARGE" 
//   						&&  row2.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES" &&  row2.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){
//
//   					$scope.mrg.mrgDtlorigin.push(row2);
//   					origin = origin + row2.quotedRate;
//   					}
   					if(row2.chargeType ==  "IMCO / HAZARDOUS SURCHARGE" || "CRANAGE / OOG SPECIAL GEAR SURCHARGES" || "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){
	   					$scope.mrg.mrgDtlorigin.push(row2);
	   					origin = origin + row2.quotedRate;
					}
   				}
//   				if(row2.chargeType == "IMCO / HAZARDOUS SURCHARGE" ){
//   					$scope.mrg.mrgDtlorigin.push(row2);
//   					origin = origin + row2.quotedRate;
//   					}
   			});
   			
   			angular.forEach($scope.mrgDtlTempdest, function(row3,index3){
   				if(row3.conType == row){
//   					if(row1.hazardous  ==  Haz){
//					if(row1.chargeType != "IMCO / HAZARDOUS SURCHARGE" &&  row3.chargeType != "REEFER SURCHARGE" 
//   						&&  row3.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES" &&  row3.chargeType != "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){
//
//   					$scope.mrg.mrgDtlorigin.push(row3);
//   					origin = origin + row3.quotedRate;
//   					}
   					if(row3.chargeType ==  "IMCO / HAZARDOUS SURCHARGE" || "CRANAGE / OOG SPECIAL GEAR SURCHARGES" || "CRANAGE / OOG SPECIAL GEAR SURCHARGES (SGS)"){
	   					$scope.mrg.mrgDtldestination.push(row3);
	   					dest = dest + row3.quotedRate;
					}
   				}
//   					if(row1.hazardous  ==  Haz){
//   					if(row3.chargeType == "IMCO / HAZARDOUS SURCHARGE" ){
//   					$scope.mrg.mrgDtldestination.push(row3);
//   					dest = dest + row3.quotedRate;
//   					}
//   				}
   			})
   			});
   			$scope.mrgtotal =  Number(freight + origin + dest ).toFixed(2); 
   			$scope.mrgFreighttotal =  Number(freight ).toFixed(2);
   			$scope.mrgOrigintotal =  Number(origin).toFixed(2); 
   			$scope.mrgDesttotal =  Number(dest ).toFixed(2); 
//   			$scope.mrgtotal = 	$scope.mrgFreighttotal + 	Number($scope.mrgOrigintotal,0) + 	$scope.mrgDesttotal; 

   		}
   			else{

			$scope.mrg.mrgDtl = $scope.mrgDtlTemp  ;
			$scope.mrg.mrgDtlorigin = $scope.mrgDtlTemporigin  ;
			$scope.mrg.mrgDtldestination = $scope.mrgDtlTempdest  ;
			$scope.mrgtotal = 0; 
   			$scope.mrgFreighttotal =  0;
   			$scope.mrgOrigintotal =  0; 
   			$scope.mrgDesttotal =  0; 
//			var grantTotal = 0;
//   			$scope.mrgtotal = grantTotal;
//			$scope.mrgDtlTemporigin = $scope.mrg.mrgDtlorigin;
//			$scope.mrgDtlTempdest = $scope.mrg.mrgDtldestination;
   		}
   		  /*
   				$scope.mrgfilter = {
   						hdrpod:'',
   						hdrpol:'',
   						pol:'',
   						pod:'',
   						haz:'',
   						rfr:'',
   						oognew:'',
   						containerType:''
   				}
   	   			$scope.mrgfilter.hdrpol = hdrpol;
   	   		$scope.mrgfilter.hdrpod = hdrpod;
   	 	$scope.mrgfilter.pol = pol;
   		$scope.mrgfilter.pod = pod;
   		$scope.mrgfilter.haz = Haz;
   		$scope.mrgfilter.rfr = rfr;
   		$scope.mrgfilter.oognew = oog;
   		$scope.mrgfilter.containerType = conType;
   		$scope.mrgfilter.mrgNo = $scope.quoteNo1;

   		
	   	   		$http.post($stateParams.tenantid+'/app/mrg/viewFilter',$scope.mrgfilter).success(function(datas) {
	   	   		$scope.mrg.mrgDtl=datas.mrgDtl;
	   			$scope.mrg.mrgDtlorigin =datas.mrgDtlorigin;
	   			$scope.mrg.mrgDtldestination = datas.mrgDtldestination;
	   			$scope.mrgFreighttotal =  Number(datas.filterTotal ).toFixed(2);
	   			$scope.mrgOrigintotal =  Number(datas.filterTotalorigin).toFixed(2); 
	   			$scope.mrgDesttotal =  Number(datas.filterTotaldest ).toFixed(2); 
	   			$scope.mrgtotal =  Number(freight + origin + dest ).toFixed(2); 

	   	   		});*/

   			
   			
   			}else{
			$http.get($stateParams.tenantid+'/app/mrg/getMRGno?pol='+pol+'&pod='+ pod).success(function(datas) {
				$scope.mrhnewNo = datas.mrgNewNo;
				if($scope.mrhnewNo != "" && $scope.mrhnewNo != null){
//				$state.go('app.master.mrg.list',{tenantid:$stateParams.tenantid});
		        $location.url($stateParams.tenantid+'/marketing/mrg/view?mrgNumber='+$scope.mrhnewNo);

		   	   		$scope.edit=true;
		   	   		$http.post($stateParams.tenantid+'/app/mrg/view',$scope.mrhnewNo).success(function(datas) {
		   	   			$scope.copy=true;
		   	   			
		   	   			$scope.mrg = datas.mrgBean;
		   	 		$scope.mrg.freight1 = $scope.mrg.freight;
//		   	   			angular.forEach($scope.shipmentTermlist, function(row,index){
//		   	   				if(row.id == $scope.mrg.freight){
//		   	   					$scope.mrg.freight = row.text;
//		   	   				}
//		   	   			});
		   	 		
		   	   			$scope.mrg.mrgDtl=datas.lmrgBean;
		   			$scope.mrg.mrgDtlorigin =datas.lmrgBeanorigin;
		   			$scope.mrg.mrgDtldestination = datas.lmrgBeandestination;
		   			
		   			$scope.mrgDtlTemp = $scope.mrg.mrgDtl;
		   			$scope.mrgDtlTemporigin = $scope.mrg.mrgDtlorigin;
		   			$scope.mrgDtlTempdest = $scope.mrg.mrgDtldestination;
		   	   			$scope.mrg.mrgFreeDaysDtl=datas.mrgFreeDaysDtl;
		   	   			
		   	              	 $scope.containerTypeList = datas.conTypeList;
		   	              $scope.containerType = 'D20';
		   	              

		   	   			var hdrpol = $scope.mrg.pol.split("-");
		   	   		var	pol = hdrpol[0];
		   	   			var hdrpod = $scope.mrg.pod.split("-");
		   	   		var	pod = hdrpod[0];
		   	              
		   	           $scope.searchView(pol , pod,$scope.mrg.pol,$scope.mrg.pod, $scope.containerType,false);

		   	            
		   	   			/*/ .................. end ...........................
		*/   	   			
		   	   		}).error(function(datas) {

		   	   		});
		   	    		
			}else{
				 logger.logError(" MRG not available for this port pair! ");
			}
			});
   		}
   		}
});
app.controller('mrgtableCtrl', function($scope, $http, $filter, logger,$stateParams,ngDialog) {
	
	$scope.$watchCollection('[mrg.mrgDtl[trIndex].chargeType,mrg.mrgDtl[trIndex].conType,mrg.mrgDtl[trIndex].hazardous]',function(newValue, oldValue) {
	 var k=0;
		if($scope.mrg.mrgDtl[$scope.trIndex].chargeType != null && 
			 $scope.mrg.mrgDtl[$scope.trIndex].conType != null && $scope.mrg.mrgDtl[$scope.trIndex].hazardous != null){
		 
		 for(var i=0; i < $scope.mrg.mrgDtl.length; i++){
				if(i != $scope.trIndex){
					if($scope.mrg.mrgDtl[i].conType != null && 
							$scope.mrg.mrgDtl[i].conType != "" &&
							$scope.mrg.mrgDtl[i].conType != undefined  &&
							$scope.mrg.mrgDtl[i].chargeType != null && 
							$scope.mrg.mrgDtl[i].chargeType != "" &&
							$scope.mrg.mrgDtl[i].chargeType	 != undefined	&& 
							$scope.mrg.mrgDtl[i].hazardous != "" &&
							$scope.mrg.mrgDtl[i].hazardous	 != undefined){
						
						if($scope.mrg.mrgDtl[i].conType ==  $scope.mrg.mrgDtl[$scope.trIndex].conType  
								&& $scope.mrg.mrgDtl[i].chargeType ==  $scope.mrg.mrgDtl[$scope.trIndex].chargeType  
								&& $scope.mrg.mrgDtl[i].hazardous ==  $scope.mrg.mrgDtl[$scope.trIndex].hazardous ){
							$scope.mrg.mrgDtl[$scope.trIndex].conType='';
							 $scope.mrg.mrgDtl[$scope.trIndex].chargeType='';
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
	
	
	$scope.$watch('mrg.mrgDtl[trIndex].select', function(newValue, oldValue) {
		if(newValue==false){
		$scope.mrg.checkAll=false;
		}
		else{


		}

		});
	
	$scope.$watch('mrg.mrgFreeDaysDtl[trIndex1].conType', function(newValue, oldValue) {
		var count=0;
		if(newValue != "" && newValue != null && newValue != undefined ){ 
			
			for(var i = 0;i < $scope.mrg.mrgFreeDaysDtl.length;i++){
				if(i != $scope.trIndex1){
                if(newValue == $scope.mrg.mrgFreeDaysDtl[i].conType){
                	count++;	
                	$scope.mrg.mrgFreeDaysDtl[$scope.trIndex1].conType='';
                }					
					
				}
				
			}
			
			
		}
		if(count > 0){
			  logger.logError("Same container type not allowed to select!");
		}
	 

		});
	
	
	$scope.$watchCollection('[mrg.pol,mrg.pol,mrg.mrgDtl[trIndex].chargeType,mrg.mrgDtl[trIndex].conType,mrg.mrgDtl[trIndex].hazardous,mrg.mrgDtl[trIndex].oog]',function(newValue, oldValue) {
	if (newValue[0] != '' && newValue[0] != undefined && newValue[1] != '' && newValue[1] != undefined && newValue[2] != '' && newValue[2] != undefined && newValue[3] != '' && newValue[3] != undefined
			) {
		  
		console.log(newValue[0]);
		console.log(newValue[1]);
		console.log(newValue[2]);
		console.log(newValue[3]);
		console.log(newValue[4]);
		console.log(newValue[5]);
		
		 
		$http.post($stateParams.tenantid+'/app/mrg/getChargeList?pol=' +newValue[0]+ '&pod=' +newValue[1] +'&chargeType=' +newValue[2]+'&conType=' +newValue[3]+'&hazardous=' +newValue[4]+'&oog=' +newValue[5]).success(function(data) {
			
			if(data.length > 0){
				
				
				
				
				
				$scope.bean=data[0];			
				$scope.mrg.mrgDtl[$scope.$parent.$index].mrg = $scope.bean.mrg;
				console.log($scope.mrg.mrgDtl[$scope.$parent.$index].mrg);
				$scope.checkFreedays();
			}else{
				$scope.mrg.mrgDtl[$scope.$parent.$index].mrg = 0;
			}
			
		});
		/*
		
		if($scope.edit == false){
		
		$http.post($stateParams.tenantid+'/app/mrg/getChargeList?pol=' +newValue[0]+ '&pod=' +newValue[1]).success(function(data) {
		  	
			$scope.test=data;
			console.log($scope.test);
			$scope.mrg.mrgDtl = [];
		

			//freight charges
			for(var i=0;i<$scope.test.length;i++){			
				
						
						$scope.max = Math.max.apply(Math, $scope.mrg.mrgDtl.map(function(item) {
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
		
				$scope.mrg.mrgDtl.push(chargedata);
				$scope.mrg.mrgDtl[i].chargeType = $scope.test[i].chargeCode;
				var len = $scope.mrg.mrgDtl.length - 1;
				$timeout(function() {
					hideActivePapers($scope.max + "0", []);
				}, 1000);
				
				
				
				
			}
		});
		
	}
	*/}
	
});


//	$scope.$watch('mrg.mrgDtl[trIndex].chargeType', function(newValue, oldValue) {
//		if($scope.edit==false){
//			if(newValue != null && newValue != undefined && newValue != ""){
//			$http.get($stateParams.tenantid+'/app/mrg/getfreightType?chargeType='+newValue+'&pol='+ $scope.mrg.pol).success(function(datas) {
//				  $scope.mrg.mrgDtl[$scope.$index].localCurrency = datas.localCurrency;
//			debugger
//  
//		
//		}).error(function(data) {
//
//		});
//			}
//		}
//	});

	$scope.$watch('mrg.mrgDtl[trIndex].conType', function(newValue, oldValue) {
		if(newValue!="" && newValue!=undefined){
//			$scope.mrg.mrgFreeDaysDtl=[];
//			$scope.mrg.mrgDtl = $scope.mrg.mrgDtlorigin;
			$scope.containerList = [];
			angular.forEach($scope.mrg.mrgDtldestination, function(row,index){
				if(row.conType != null && row.conType != "" && row.conType != undefined)
				$scope.containerList.push(row);
			})
			
				angular.forEach($scope.mrg.mrgDtlorigin, function(row,index){
				if(row.conType != null && row.conType != "" && row.conType != undefined)
				$scope.containerList.push(row);
			})
			
				angular.forEach($scope.mrg.mrgDtl, function(row,index){
				if(row.conType != null && row.conType != "" && row.conType != undefined)
				$scope.containerList.push(row);
			})
			
			$scope.result = $scope.containerList.filter(function (a) {

				var key = a.conType ;
				if (!this[key]) {
				this[key] = true;
				return true;
				}
				}, Object.create(null));
			
			if($scope.edit==false){
				$scope.mrg.mrgFreeDaysDtl=[];
				
				for(var j=0;j<$scope.result.length;j++){
					if($scope.result[j].conType !=''){
					
						var chargedata = {
				 				conType : $scope.result[j].conType,
				 				polFreeDays : '',
				 				podFreeDays : ''
						};

						$scope.mrg.mrgFreeDaysDtl.push(chargedata);
					}

					
		}
			}else{
				for(var j=0;j<$scope.freedays.length;j++){
//								if($scope.result.conType[j]!= '' || $scope.result[j].conType!= undefined){
									
									var chargedata = {
							 				conType : $scope.freedays[j].conType,
							 				polFreeDays : $scope.freedays[j].polFreeDays,
							 				podFreeDays : $scope.freedays[j].podFreeDays,
									};

//									$scope.mrg.mrgFreeDaysDtl.push(chargedata);
//								}

								
					}
			}
					
				
				
	 
		}
		
		});
	$scope.$watch('mrg.mrgDtlorigin[trIndex].conType', function(newValue, oldValue) {
		if(newValue!="" && newValue!=undefined){
//			$scope.mrg.mrgFreeDaysDtl=[];
//			$scope.mrg.mrgDtl = $scope.mrg.mrgDtlorigin;
			$scope.containerList = [];
			
			angular.forEach($scope.mrg.mrgDtlorigin, function(row,index){
				if(row.conType != null && row.conType != "" && row.conType != undefined)
				$scope.containerList.push(row);
			})
			
			angular.forEach($scope.mrg.mrgDtldestination, function(row,index){
				if(row.conType != null && row.conType != "" && row.conType != undefined)
				$scope.containerList.push(row);
			})
			
			angular.forEach($scope.mrg.mrgDtl, function(row,index){
				if(row.conType != null && row.conType != "" && row.conType != undefined)
				$scope.containerList.push(row);
			})
			
			
			$scope.result = $scope.containerList.filter(function (a) {

				var key = a.conType ;
				if (!this[key]) {
				this[key] = true;
				return true;
				}
				}, Object.create(null));
			
			if($scope.edit==false){
				$scope.mrg.mrgFreeDaysDtl=[];
				
				for(var j=0;j<$scope.result.length;j++){
					if($scope.result[j].conType !=''){
					
						var chargedata = {
				 				conType : $scope.result[j].conType,
				 				polFreeDays : '',
				 				podFreeDays : ''
						};

						$scope.mrg.mrgFreeDaysDtl.push(chargedata);
					}

					
		}
			}else{
				for(var j=0;j<$scope.freedays.length;j++){
//								if($scope.result.conType[j]!= '' || $scope.result[j].conType!= undefined){
									
									var chargedata = {
							 				conType : $scope.freedays[j].conType,
							 				polFreeDays : $scope.freedays[j].polFreeDays,
							 				podFreeDays : $scope.freedays[j].podFreeDays,
									};

//									$scope.mrg.mrgFreeDaysDtl.push(chargedata);
//								}

								
					}
			}
					
				
				
	 
		}
		
		});

	$scope.$watch('mrg.mrgDtldestination[trIndex].conType', function(newValue, oldValue) {
		if(newValue!="" && newValue!=undefined){
			$scope.containerList = [];
			angular.forEach($scope.mrg.mrgDtldestination, function(row,index){
				if(row.conType != null && row.conType != "" && row.conType != undefined)
				$scope.containerList.push(row);
			})
			
				angular.forEach($scope.mrg.mrgDtlorigin, function(row,index){
				if(row.conType != null && row.conType != "" && row.conType != undefined)
				$scope.containerList.push(row);
			})
			
				angular.forEach($scope.mrg.mrgDtl, function(row,index){
				if(row.conType != null && row.conType != "" && row.conType != undefined)
				$scope.containerList.push(row);
			})
			
			
			$scope.result = $scope.containerList.filter(function (a) {

				var key = a.conType ;
				if (!this[key]) {
				this[key] = true;
				return true;
				}
				}, Object.create(null));
			
			if($scope.edit==false){
				$scope.mrg.mrgFreeDaysDtl=[];
				
				for(var j=0;j<$scope.result.length;j++){
					if($scope.result[j].conType !=''){
					
						var chargedata = {
				 				conType : $scope.result[j].conType,
				 				polFreeDays : '',
				 				podFreeDays : ''
						};

						$scope.mrg.mrgFreeDaysDtl.push(chargedata);
					}

					
		}
			}else{
				for(var j=0;j<$scope.freedays.length;j++){
//								if($scope.result.conType[j]!= '' || $scope.result[j].conType!= undefined){
									
									var chargedata = {
							 				conType : $scope.freedays[j].conType,
							 				polFreeDays : $scope.freedays[j].polFreeDays,
							 				podFreeDays : $scope.freedays[j].podFreeDays,
									};

//									$scope.mrg.mrgFreeDaysDtl.push(chargedata);
//								}

								
					}
			}
					
				
				
	 
		}
		
		});
	
	/* $scope.$watch('mrg.mrgDtl[trIndex].transactionType', function(newValue, oldValue) {
		 var id = newValue;
			$http.get($stateParams.tenantid+'/app/seamrg/getServicePartnerListid?id='+ id).success(function(datas) {
				console.log(datas);				
				 $scope.serviceParnrDropList=datas.serviceParnrList;
			  
			}).error(function(data) {

			});
	  });*/
	

//	$scope.mrgrate = function(index, Row,quotation) {
//		
//		var mlo = quotation.customer;
//		var pod = quotation.pod;
//		var pol = quotation.pol;
//		var containerType = Row.conType;
//		
//		 $http.get($stateParams.tenantid+ '/app/quotation/getmrgRate?mlo=' +mlo +
//				 '&pod=' + pod +"&pol=" + pol + "&containerType=" + containerType).success(function(data1) {
//					 $scope.mrgRate =data1.quotedRatemrg;
//					   
//					 if(Row.quotedRate > $scope.mrgRate){
//						 $scope.mrg.mrgDtl[index].quotedRate = "";
//						 ngDialog.open({
//		                        template : 'mrgRate',
//		                        scope : $scope
//		                    });	
//					 }	 
//					 
//					 
//		 });
//	}
	
	$scope.closeFileDialog = function(){
		ngDialog.close();
	}
});



app.controller('mrgAlertCtrl', function($scope, $http, $filter, logger,$stateParams,ngDialog) { 
	
	$scope.confirm = function(){
		$http.post($stateParams.tenantid+'/app/mrg/savemrgDtl',$scope.mrg).success(function(datas) {
		debugger
		  if(datas.success==true){	
			  ngDialog.close();    
			  logger.logSuccess("Saved Successfully!!!");
			  $state.go('app.master.mrg.list',{tenantid:$stateParams.tenantid});
		        

		}else{
			  logger.logError(datas.message);
			  ngDialog.close();    
		  }
		}).error(function(data) {
			logger.logError("Please try again");
		});
 
}
	
	$scope.no = function(){
		

		$http.post($stateParams.tenantid+'/app/mrg/saveNewmrg',$scope.mrg).success(function(datas) {
			debugger
			  if(datas.success==true){	
				  ngDialog.close();    
				  logger.logSuccess("Saved Successfully!!!");
				  $state.go('app.master.mrg.list',{tenantid:$stateParams.tenantid});
			        

			}else{
				  logger.logError(datas.message);
			  }
			}).error(function(data) {
				logger.logError("Please try again");
			});
    
	}
});	




app.controller('mrgRejectCtrl', function($stateParams , $scope , $rootScope, $http, $location,logger, utilsService, $state, $window,ngDialog) {
    debugger;
     
        
        $scope.mrgNew.mrgNo= $scope.mrgNew.mrgNo;  
        $scope.mrgNew.rejectRemarks= '';
 
        $scope.cancel = function() {
            ngDialog.close();    
        };
        
        $scope.rejectQuote = function(mrgNew){

        $http.post($stateParams.tenantid+'/app/mrg/reject',mrgNew).success(function(datas) {
			if(datas.success){
				 ngDialog.close();    
		    logger.logSuccess("Rejected Successfully");
		    ngDialog.close();  
		    //$state.go('app.salesmarketing.mrgApproval.list',{tenantid:$stateParams.tenantid});
		    $state.go('app.master.mrg.list',{tenantid:$stateParams.tenantid});
			}else{
				logger.logError(datas.message);
			}
		}).error(function(datas) {

		});
        }
      
});
app.controller('mrgApprovalCtrl', function($stateParams , $scope , $rootScope, $http, $location,logger, utilsService, $state, $window,ngDialog) {
    debugger;
     
        
        $scope.mrgNew.mrgNo= $scope.mrgNew.mrgNo;  
        $scope.mrgNew.approveRemarks= '';
 
        $scope.cancel = function() {
            ngDialog.close();    
        };
        
        $scope.approveQuote = function(mrgNew){

        	//approve
  	
        		$http.post($stateParams.tenantid+'/app/mrg/approve',mrgNew).success(function(datas) {
        			if(datas.success){
        		    logger.logSuccess("Approved Successfully!!!");
        		    ngDialog.close();  
        		    //$state.go('app.salesmarketing.mrgApproval.list',{tenantid:$stateParams.tenantid});
        		    $state.go('app.master.mrg.list',{tenantid:$stateParams.tenantid});
        			}else{
        				logger.logError(datas.message);
        			}
        			 
        		
        	
        	}).error(function(datas) {

        	});
        	
        	
        }
});


app.controller('mrgCounterOfferCtrl', function($stateParams , $scope , $rootScope, $http, $location,logger, utilsService, $state, $window,ngDialog) {
    debugger;
     
        
        $scope.mrgNew.mrgNo= $scope.mrgNew.mrgNo;  
        $scope.mrgNew.approveRemarks= '';
 
        $scope.cancel = function() {
            ngDialog.close();    
        };
        
        $scope.approveQuote = function(mrgNew){

        	//approve
  	
        		$http.post($stateParams.tenantid+'/app/mrg/counterOffer',mrgNew).success(function(datas) {
        			if(datas.success){
        		    logger.logSuccess("Approved Successfully!!!");
        		    ngDialog.close();  
        		    //$state.go('app.salesmarketing.mrgApproval.list',{tenantid:$stateParams.tenantid});
        		    $state.go('app.master.mrg.list',{tenantid:$stateParams.tenantid});
        			}else{
        				logger.logError(datas.message);
        			}
        			 
        		
        	
        	}).error(function(datas) {

        	});
        	
        	
        }
      
});

