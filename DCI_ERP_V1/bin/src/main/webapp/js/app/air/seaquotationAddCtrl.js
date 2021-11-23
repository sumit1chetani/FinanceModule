'use strict';
app.controller('seaquotationAddCtrl', function($scope, $timeout, $stateParams,sharedProperties,toaster,
		$filter, $rootScope, $http, $location, logger, $state, ngDialog,$controller,$injector) {
	$scope.quotationTypeList=[];
	$scope.customerDropList = [];
	$scope.consigneeDropList  = [];
	$scope.shipperDropList  = [];
	$scope.nominatedDropList  = [];
	$scope.vendorDropList = [];
	$scope.serviceParnrDropList = [];
	$scope.portList=[];
	$scope.currencyList=[];
	$scope.createQuote=false;
	$scope.contractTypeList=[];
	 $scope.conTypeList=[];
	 $scope.transList = [];
	 $scope.pickupList=[];
	 $scope.mode='';
		$scope.userId='';

	var bookingDate = $stateParams.bookingDate;
	var mloCode = $stateParams.mloCode;
	var lolId = $stateParams.lolId;
	var lodId = $stateParams.lodId;
	var bookingId= parseInt($stateParams.bookingId);
	 $scope.userId=$('#empId').val();
		$scope.checking=false;

if($scope.userId=='E0001' || $scope.userId=='E0002' || $scope.userId=='E0003'|| $scope.userId=='E0006' || $scope.userId=='E0016'){
$scope.checking=true;
}
	$scope.quotation={
			service:'1',pot:'',fpod:'',
			aol:'',transOrg:'',transDeg:'',
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
			mode : '',
			currency : '',
			term : '',picPoint:'',
			commodity : '',commodityL:'',
			consignee : '',
			nominatedBy : '',
			validityDate : '',
			remarks : '',
			vessel :'',
			cargoType :'',
			addchargeData:[],
			dimensionName:'',freightTerm:'',contractType:'',sellAmt:'',butsellAmt:'',butAmt:'',opr:false,otherSelling:'',
			quotationDtl:[{id:0,chargeHeads:'',unit:'',conType:'',currency:'',qty:'',rate:'',paymentMethod : '',transactionType : '',buySell : '',note : ''}],
			quotationFreeDaysDtl : [{id:0,conType:'',polFreeDays:'',polFreeDays1:'',podFreeDays:'',podFreeDays1:''}],
			consolidated:[{tranType:'',credit:0,creditDays:0}]
			//quotationGroundFreeDaysDtl : [{id:0,conTypes:'',polFreeDays:'',podFreeDays:''}]


	}
$scope.contractType=[];
$scope.freightTerm=[];
$scope.addAdditionalRow = function(){
	var tempBoxData = {
			quotationDtlId : '',
			surcharge : '',
			chargeType : '',
			uom : '',
			conType: '',
			addchrgcurrency: '',bookremarks:'',bookingRate:'',bookingqty:'',
			addchrgtax: '',
			rate: '',
			qty: '',
			remarks: '',
			hazardous : false,
			isOog : false
	}
	$scope.quotation.addchargeData.push( tempBoxData);
}
$scope.removequoRow=function(){
	  var data=[];
	  angular.forEach($scope.quotation.addchargeData, function(value,key){
	  if(value.select==undefined || value.select==false){
		  data.push(value);
	  }
	  })
	  $scope.quotation.addchargeData=data;
}
$scope.checkAll = function(){ 

	angular.forEach($scope.quotation.quotationDtl, function(chargesDetail, index) { 
	if($scope.quotation.checkAll==true){

	chargesDetail.select=true;

	}else{

	chargesDetail.select=false;

	}



	});
	}


$scope.getQuotationType=function(){
    
		$http.post($stateParams.tenantid+'/app/seaquotation/modelist').success(function(data) {
			debugger
			$scope.modelistHeader =[];
			angular.forEach(data.lQuotationBean, function(row, index) { 
		

	if(row.modeName != null && row.modeName != ''){
		
		var mode =row.modeName.split(",");
		for(var i=0;i<mode.length;i++){
			
			 var  data = {};
			
				 if(mode[i]==1){
	                   
	                    data["id"] = "1";
	                    data["text"] = "SEA COASTAL";
		            
			    }else  if(mode[i]==2){
	                     
	                     data["id"] = "2";
	                     data["text"] = "SEA FOREIGN";
		           
			    }else  if(mode[i]==3){
	                   
	                     data["id"] = "3";
	                     data["text"] = "TRUCK";
		            

			    }else  if(mode[i]==4){
	                 
	                 data["id"] = "4";
	                 data["text"] = "LINER";
		         

				}
				else  if(mode[i]==5){
	                 
	                 data["id"] = "5";
	                 data["text"] = "FORWARDING";
		         

			    }
				 $scope.modelistHeader.push(data);
	   
}	    
			
		}else{
			 var  data = {};
      	    data["id"] = "1";
    	    data["text"] = "SEA COASTAL";
    	    $scope.modelistHeader.push(data);
    	    //$scope.quotation.mode='1';
    	    data = {};
    	    data["id"] = "2";
    	    data["text"] = "SEA FOREIGN";
    	    $scope.modelistHeader.push(data);
    	    data = {};
    	    data["id"] = "3";
    	    data["text"] = "TRUCK";
    	    $scope.modelistHeader.push(data);
    	    data = {};
    	    data["id"] = "4";
    	    data["text"] = "LINER";
			$scope.modelistHeader.push(data);
			data = {};
    	    data["id"] = "5";
    	    data["text"] = "FORWARDING";
    	    $scope.modelistHeader.push(data);
         

		}
	
	// $scope.modelistHeader.push(data);

			})
		});
}; $scope.getQuotationType();

/*$scope.getListMode1=function(){
    $http.get($stateParams.tenantid+'/app/seaquotation/modelist').success(function(datas) {
        console.log(datas);
        $scope.modeList = data.commonUtilityBean;
    	
        }).error(function(datas) {
    });
    };
    $scope.getListMode1();*/

$scope.checkAllFreeDays = function(){ 

	angular.forEach($scope.quotation.quotationFreeDaysDtl, function(chargesDetail, index) { 
	if($scope.quotation.checkAllFreeDays==true){

	chargesDetail.select=true;

	}else{

	chargesDetail.select=false;

	}



	});
	}

$scope.checkAllFreeDays1 = function(){ 

	angular.forEach($scope.quotation.quotationGroundFreeDaysDtl, function(chargesDetail, index) { 
	if($scope.quotation.checkAllFreeDays1==true){

	chargesDetail.select=true;

	}else{

	chargesDetail.select=false;

	}



	});
	}


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
	
	$scope.$watchCollection('quotation.mode', function(newValue, oldValue) {
		if(newValue != "" && newValue != null && newValue != undefined ){ 	
			if($scope.quotation.mode=='4'){
				$scope.quotation.contractType='Port-Port';
			}
			if($scope.quotation.mode=='1'){
				$scope.quotation.currency='1';
		}
		}
		
		

		});
	$scope.$watchCollection('quotation.customer', function(newValue, oldValue) {
		if(newValue != "" && newValue != null && newValue != undefined ){
			if($scope.edit==false){
			for(var i = 0;i < $scope.quotation.quotationDtl.length;i++){
                	$scope.quotation.quotationDtl[i].transactionType='2';
              
				}
			$scope.quotation.consolidated[0].tranType=newValue;
			if($scope.quotation.commodityL==''){
				$scope.quotation.commodityL=null;
			}
			
        	$http.post($stateParams.tenantid+'/app/seaquotation/creditDays',$scope.quotation).success(function(datas) {
	               if(datas.success){
	            	   $scope.quotation.consolidated[0].credit=datas.consol[0].credit;
	            	   $scope.quotation.consolidated[0].creditDays=datas.consol[0].creditDays;
	               }
			})
			$http.get($stateParams.tenantid+'/app/seaquotation/getsalesPerson?id='+newValue).success(function(datas) {
				            	   $scope.quotation.salesPerson=datas.customer;
			            })
		}
		}
		

		});
	$scope.$watchCollection('quotation.quotationDtl[trIndex].unit', function(newValue, oldValue) {
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
	
	$scope.$watchCollection('quotation.customer', function(newValue, oldValue) {
		if(newValue != "" && newValue != null && newValue != undefined ){
			if($scope.edit==false){
			for(var i = 0;i < $scope.quotation.quotationDtl.length;i++){
                	$scope.quotation.quotationDtl[i].transactionType='2';
              
				}
			$scope.quotation.consolidated[0].tranType=newValue;
			if($scope.quotation.commodityL==''){
				$scope.quotation.commodityL=null;
			}
			
        	$http.post($stateParams.tenantid+'/app/seaquotation/creditDays',$scope.quotation).success(function(datas) {
	               if(datas.success){
	            	   $scope.quotation.consolidated[0].credit=datas.consol[0].credit;
	            	   $scope.quotation.consolidated[0].creditDays=datas.consol[0].creditDays;
	               }
			})
			$http.get($stateParams.tenantid+'/app/seaquotation/getsalesPerson?id='+newValue).success(function(datas) {
				            	   $scope.quotation.salesPerson=datas.customer;
			            })
		}
		}
		

		});

	
	$scope.checkDatesCL = function(quotationDate) {
		var res = $scope.quotation.quotationDate
				.split("/");
		$http
				.get(
						$stateParams.tenantid
								+ '/app/cashbankreceipt/getloggedcompany?closingDate='
								+ $scope.quotation.quotationDate)
				.success(
						function(datas) {
							if (datas) {
								logger
										.logError("Account closed for year "
												+ res[2]);
								$scope.quotation.quotationDate = today;
							}
						})
	}


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
			conType:'',
			currency : '',
			qty : '',
			rate : '',
			currencyList : angular.copy($scope.currencylist),
			paymentMethod : '',
			transactionType : '2',
			buySell : '',
			note : ''
		};

		$scope.quotation.quotationDtl.push(chargedata);
		var len = $scope.quotation.quotationDtl.length - 1;
		$timeout(function() {
			hideActivePapers($scope.max + "0", []);
		}, 1000);
		
		/*if($scope.quotation.customer!=null && $scope.quotation.customer!='' && $scope.quotation.customer!=undefined){
			for(var i = 0;i < $scope.quotation.quotationDtl.length;i++){
            	$scope.quotation.quotationDtl[i].transactionType='2';
          
			}
		}*/
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
	$scope.removeRowGroundFreeDays  = function() {
		$scope.tablerow = [];
		for (var index = 0 ; index < 1; index++) {
		angular.forEach($scope.quotation.quotationGroundsFreeDaysDtl,function(row, index) {
					var check = row.select;
					
					if (check == undefined || check == "" ) {
						$scope.tablerow.push(row);
					} else if(index > 0){
						$scope.quotation.quotationGroundFreeDaysDtl = $scope.tablerow;

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
		for(var i=0;i<$scope.quotation.quotationFreeDaysDtl.length;i++){
			var check=false;
			for(var j=0;j<$scope.quotation.quotationDtl.length;j++){
				if($scope.quotation.quotationFreeDaysDtl[i].conType==$scope.quotation.quotationDtl[j].conType){
					check=true;
				}
			}
			if(check==true){
				
			}else{
				$scope.quotation.quotationFreeDaysDtl.pop($scope.quotation.quotationFreeDaysDtl[j]);
					}
	
	}
		
	};
	
	
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
	
	
	

    $scope.hdrData =  $scope.joborder;
    $scope.dtlData =  $scope.jobOrderDtl;
    $scope.reset = function () {
        $scope.joborder = $scope.hdrData;
        $scope.jobOrderDtl = $scope.dtlData;
    };
	$scope.modeList=[];
	/*$scope.getQuotationType = function() {
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
	}*/
	
	$scope.salesTypeList=[];
	$scope.getSalesType = function() {
    var  data = {};
	    data["id"] = "1";
	    data["text"] = "CROSS TRADE";
	    $scope.salesTypeList.push(data);
	    data = {};
	    data["id"] = "2";
	    data["text"] = "LOCAL";
	    $scope.salesTypeList.push(data);  
	    data = {};
	    data["id"] = "3";
	    data["text"] = "NOMINATED";
	    $scope.salesTypeList.push(data);
	    data = {};
	    data["id"] = "4";
	    data["text"] = "FREEHAND";
	    $scope.salesTypeList.push(data);
	    	  
	}
$scope.getSalesType();
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
	// $scope.quotation.mode='1';
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
	$scope.dropdown=function(){
		$scope.getQuotationType();
		$http.post($stateParams.tenantid+'/app/seaquotation/getServicePartnerList').success(function(datas) {
			debugger
			 $scope.customerDropList = datas.customerList;
			 $scope.consigneeDropList = datas.consigneeList;
			 $scope.shipperDropList = datas.shipperList;
			 $scope.nominatedDropList = datas.nominatedList;
			 $scope.vendorDropList = datas.vendorList;
			// $scope.serviceParnrDropList=datas.serviceParnrList;
		  
		  
		}).error(function(data) {

		});
		$http.get($stateParams.tenantid+'/app/seaquotation/getiataList').success(function(datas) {
			debugger
		    $scope.portList = datas.commonUtilityBean;	    

		}).error(function(data) {

		});
		$http.get($stateParams.tenantid+'/app/seaquotation/getpicList').success(function(datas) {
			debugger
		    $scope.pickupList = datas.commonUtilityBean;	    

		}).error(function(data) {

		});
		/*$http.get($stateParams.tenantid+'/app/seaquotation/getcommodity').success(function(datas) {
			
		    $scope.commodityList = datas.commonUtilityBean;	    

		}).error(function(data) {

		});*/
		
	           
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
		
		/*$scope.carrierList = [
			{id: '1', text: 'SIMA MARINE (INDIA) PRIVATE LIMITED'},
		    {id: '2', text: 'TCI SEAWAYS'},
		    {id: '3', text: 'THE SHIPPING CORPORATION OF INDIA LIMITED'},
		    {id: '4', text: 'AVANA LOGISTEK LIMITED'},
		    {id: '5', text: 'CONTAINER CORPORATION OF INDIA LIMITED'}
		  ];
		  */
		$http.get($stateParams.tenantid+'/app/commonUtility/getcarrierList').success(function(datas) {
			debugger
		    $scope.carrierList = datas.commonUtilityBean;	    
            //$scope.transList = datas.lCommonUtilityBean;	    

		}).error(function(data) {

		});
		$http.get($stateParams.tenantid+'/app/commonUtility/gettransportList').success(function(datas) {
			debugger
            $scope.transList = datas.lCommonUtilityBean;	    

		}).error(function(data) {

		});
		
		
		/*$http.get($stateParams.tenantid+'/app/seaquotation/getBranch').success(function(datas) {
			 $scope.branchList = datas.commonUtilityBean;
		    
		}).error(function(data) {

		});
		*/

		/*$scope.cargoTypeList = [
		     {id: '1', text: 'COCO'},
		    {id: '2', text: 'Coir'}
		  ];
		
	    */// cargo type List ..... 
		  $http.post($stateParams.tenantid+'/app/commonUtility/cargotype').success(function(data) {
			  	
				$scope.cargoTypeList=data;
				        		
		});
		

		
	    $http.post($stateParams.tenantid+'/app/hr/holiday/branchlist').success(function(data) {
	      	
      		$scope.branchList=data;
      		        		
    	});
		$http.get($stateParams.tenantid+'/app/seaquotation/getCurrencyList').success(function(datas) {	  
			$scope.currencylist= angular.copy(datas.commonUtilityBean);
		}).error(function(data) {

		});
		 
		$http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(datas) {	  
			  $scope.conTypeList=datas.getcontypelist;
			  $scope.contractTypeList=datas.contractType;

		}).error(function(data) {

		});
		
		/*$http.get($stateParams.tenantid+'/app/seaquotation/getServicePartnerType').success(function(datas) {	  
			$scope.servicePartnerTypelist= angular.copy(datas.commonUtilityBean);
		}).error(function(data) {

		});*/
		
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
		
		/*$http.get($stateParams.tenantid + '/app/airquotation/getSalesList')
		.success(function(datas) {
			$scope.salesTypeList = datas.commonUtilityBean;

		}).error(function(data) {

		});
*/		
		/*$http.get($stateParams.tenantid + '/app/airquotation/getServiceList')
		.success(function(datas) {
			console.log("test");
			console.log(datas);
			console.log("test");
			$scope.servicePartnerTypelist = datas.commonUtilityBean;

		}).error(function(data) {

		});*/
		
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
		
		
		
	}
	$scope.editdata=function(quotation){
		
		
		$scope.getQuotationType();
		$http.post($stateParams.tenantid+'/app/seaquotation/getServicePartnerList').success(function(datas) {
			debugger
			$scope.customerDropList = datas.customerList;
			 $scope.consigneeDropList = datas.consigneeList;
			 $scope.shipperDropList = datas.shipperList;
			 $scope.nominatedDropList = datas.nominatedList;
			 $scope.vendorDropList = datas.vendorList;
			
		

		}).error(function(data) {

		});
	}


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
	    if ($scope.checkundefined($scope.quotation.service)) {
	        msg = msg + "<li>Service:Field is required.</li>";         
	        $scope.changecolor('service');
	    }else{
	    	$scope.clearcolor('service');
	    }
	    if ($scope.checkundefined($scope.quotation.aol)) {
	        msg = msg + "<li>POL:Field is required.</li>";         
	        $scope.changecolor('aol');
	    }else{
	    	$scope.clearcolor('aol');
	    }
	    if ($scope.checkundefined($scope.quotation.quotationDate)) {
	        msg = msg + "<li>QuotationDate:Field is required.</li>";         
	        $scope.changecolor('quotationDate');
	    }else{
	    	$scope.clearcolor('quotationDate');
	    }
	    if ($scope.checkundefined($scope.quotation.branch)) {
	        msg = msg + "<li>Branch:Field is required.</li>";         
	        $scope.changecolor('branch');
	    }else{
	    	$scope.clearcolor('branch');
	    }
	    if ($scope.checkundefined($scope.quotation.aod)) {
	        msg = msg + "<li>POD:Field is required.</li>";         
	        $scope.changecolor('aod');
	    }else{
	    	$scope.clearcolor('aod');
	    }
	    if ($scope.checkundefined($scope.quotation.salesType)) {
	        msg = msg + "<li>SalesType:Field is required.</li>";         
	        $scope.changecolor('salesType');
	    }else{
	    	$scope.clearcolor('salesType');
	    }
	    
	    if ($scope.checkundefined($scope.quotation.cargoType)) {
	        msg = msg + "<li>Cargo Type:Field is required.</li>";         
	        $scope.changecolor('cargoType');
	    }else{
	    	$scope.clearcolor('cargoType');
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
	    }
        if($scope.quotation.mode!=5){

	    if ($scope.checkundefined($scope.quotation.commodityL)) {
	        msg = msg + "<li>Commodity:Field is required.</li>";         
	        $scope.changecolor('Commodity');
	    }else{
	    	$scope.clearcolor('Commodity');
	    }
        }
	  	    angular.forEach($scope.quotation.quotationDtl, function(chargesDetail, index) {     
	        if ($scope.checkundefined(chargesDetail.chargeHeads)) {
	            msg = msg + "<li>Row :" + (index + 1) + "# Charge Heads :Field is required.</li>";
	            //$scope.changecolor('chargeHeads'+index);
	        }else{
	        	$scope.clearcolor('chargeHeads'+index);
	        }
	        if ($scope.checkundefined(chargesDetail.unit)) {
	            msg = msg + "<li>Row :" + (index + 1) + "# Unit :Field is required.</li>";
	            $scope.changecolor('unit'+index);
	        }else{
	        	$scope.clearcolor('unit'+index);
	        }
	        
	        if(chargesDetail.unit=='47'){
	        if ($scope.checkundefined(chargesDetail.conType)) {
	            msg = msg + "<li>Row :" + (index + 1) + "# Container Type :Field is required.</li>";
	            $scope.changecolor('conType'+index);
	        }else{
	        	$scope.clearcolor('conType'+index);
	        }
	  	    }
	        
	        
	        if ($scope.checkundefined(chargesDetail.qty)) {
	            msg = msg + "<li>Row :" + (index + 1) + "# Quantity :Field is required.</li>";
	            $scope.changecolor('qty'+index);
	            $('#qty'+index).find('input').css("border-color", "red");

	        }  else{
	        	//$('#qty'+index).find('input').css("border-color", "#e8dddd");
	        	$scope.clearcolor('qty'+index);
	        }
	        if ($scope.checkundefined(chargesDetail.rate)) {
	            msg = msg + "<li>Row :" + (index + 1) + "# Rate :Field is required.</li>";
	        }  
	        /*if ($scope.checkundefined(chargesDetail.paymentMethod)) {
	            msg = msg + "<li>Row :" + (index + 1) + "# Payment Method :Field is required.</li>";
	        }  
*/	        if ($scope.checkundefined(chargesDetail.currency)) {
	            msg = msg + "<li>Row :" + (index + 1) + "# Currency :Field is required.</li>";
	        }  
	        if ($scope.checkundefined(chargesDetail.transactionType)) {
	            msg = msg + "<li>Row :" + (index + 1) + "# Transaction Type :Field is required.</li>";
	        }  
	        if ($scope.checkundefined(chargesDetail.buySell)) {
	            msg = msg + "<li>Row :" + (index + 1) + "# Buy Sell:Field is required.</li>";
	        }  
	        
	        
	        
	    });
	    alertmsg = alertmsg + msg + "</ui>";
	    if ($scope.checkundefined(msg)) {
	        return '';
	    } else {
	        return alertmsg;
	    }

	}

	$scope.addRowFreeDays = function() {
 
 		var chargedata = {
 				conType : '',
 				polFreeDays : '',
 				podFreeDays : ''
		};

		$scope.quotation.quotationFreeDaysDtl.push(chargedata);
   	}
	$scope.addRowGroundFreeDays = function() {
		 
 		var chargedata = {
 				conType : '',
 				polFreeDays : '',
 				podFreeDays1 : '',
 				polFreeDays : '',
 				podFreeDays1 : ''
		};

		$scope.quotation.quotationGroundFreeDaysDtl.push(chargedata);
   	}

	$scope.$watch('quotation.quotationDtl[trIndex].unit', function(newValue, oldValue) {
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
		$scope.$watch('quotation.quotationDtl[trIndex1].transactionType', function(newValue, oldValue) {
			var count=0;
			debugger;
			if(newValue != "" && newValue != null && newValue != undefined ){ 
				$http.post($stateParams.tenantid+'/app/seaquotation/getServicePartnerList').success(function(datas) {
				 
					if(newValue==1){
					 
					 $scope.serviceParnrDropList=datas.vendorMasterList;
				 }else if(newValue==2){
					 $scope.serviceParnrDropList=datas.serviceParnrList;
					 if($scope.quotation.customer!=null && $scope.quotation.customer!='' && $scope.quotation.customer!=undefined){
					 $scope.quotation.quotationDtl.buySell=$scope.quotation.customer;
					 }
				 }
				}).error(function(data) {

				});
			}
				
			})
			
			
		if(count > 0){
			  logger.logError("Same container type not allowed to select!");
		}
	 

		});
	
	
	
	$scope.submit=function(){
		
		var msg=$scope.checkValidation();
		if(!$scope.checkundefined(msg)){
			logger.logError(msg);
		}else{
	        if($scope.quotation.quotationDtl.length>0){
				var cond=true;var msg='';var j=1,i=1,l=1;	
				if($scope.quotation.mode!=5){
	            angular.forEach($scope.quotation.quotationFreeDaysDtl, function(files, index) {
	            	if(((files.polFreeDays==null || files.polFreeDays=='' || files.polFreeDays==undefined) && 
	            			 (files.polFreeDays1==null || files.polFreeDays1=='' || files.polFreeDays1==undefined) )
	            			 && ((files.podFreeDays==null || files.podFreeDays=='' || files.podFreeDays==undefined) 
	            					 && (files.podFreeDays1==null || files.podFreeDays1=='' || files.podFreeDays1==undefined))){
	            		cond=false;
						msg=msg+" Row "+i+" Atleast One Free Days Required! ";

	            }
				})
			}
				 angular.forEach($scope.quotation.quotationDtl, function(val, index) {
		            	if(val.unit=='1'){
		            		if(val.conType!=null && val.conType!='' &&val.conType!=undefined){
		            			
		            		}else{
								msg=msg+"Freight Charges Row "+j+" Container Type is Required! ";
		            			cond=false;
		            			
		            		}
		            	}j++;
		            })
		             angular.forEach($scope.quotation.addchargeData, function(val, index) {
		            	if(val.unit=='1'){
		            		if(val.conType!=null && val.conType!='' &&val.conType!=undefined){
		            			
		            		}else{
								msg=msg+"Local Charges Row "+l+" Container Type is Required! ";
		            			cond=false;
		            			
		            		}
		            	}l++;
		            })
	            if(cond==true){
	            	$scope.quotation.commodityL=$scope.quotation.commodityL;

	            	var commodity='';
	            	angular.forEach($scope.quotation.commodityL, function(item, index) {
	                	if(commodity!=null && commodity!=''){
	                    	commodity=commodity+','+item.id;
	                  }else{
	                    	commodity=item.id;
	                	}
	                	
	                })
	               $scope.quotation.commodity=commodity;
	            	if($scope.quotation.mode!=5){
	            		if($scope.quotation.commodityL!=[] && $scope.quotation.commodityL!=null && $scope.quotation.commodityL.length!=0){
         	   if($scope.quotation.carrier!='' && $scope.quotation.carrier!=null){

			$http.post($stateParams.tenantid+'/app/seaquotation/save',$scope.quotation).success(function(datas) {
				debugger
				  if(datas.success==true){
					  if ($scope.files.length > 0) {

	                        angular.forEach($scope.files, function(files, index) {
	                        	
	                        	
	                            var quotationNo = datas.code;
	                            
	                            var frmData = new FormData();
	                            frmData.append("file", files);
	                            frmData.append("quotationNo", quotationNo);
	                           
	                            $.ajax({
	                                type : "POST",
	                                url : $stateParams.tenantid+"/app/seaquotation/saveuploadfile",
	                                data : frmData,
	                                contentType : false,
	                                processData : false,
	                                success : function(result) {
	                                	
	                                	  logger.logSuccess("File uploaded successfully!");
	                                	  
	                                }
	                            });
	                            
	                        });
	                    	
	                    }
					  
					  logger.logSuccess(datas.message);
  					  $state.go('app.sea.quotation.list',{tenantid:$stateParams.tenantid});
					  
				        

				  }else{
					  logger.logError(datas.message);
				  }
				}).error(function(datas) {
					logger.logError("Please try again");
				});
        	 
         	  }else{
	 				logger.logError("Carrier field is Mandatory!.");

	             }
         	   }else{
 				logger.logError("Commodity field is Mandatory!.");

             }}else{
		         	   if($scope.quotation.carrier!='' && $scope.quotation.carrier!=null){

					$http.post($stateParams.tenantid+'/app/seaquotation/save',$scope.quotation).success(function(datas) {
						debugger
						  if(datas.success==true){
							  if ($scope.files.length > 0) {

			                        angular.forEach($scope.files, function(files, index) {
			                        	
			                        	
			                            var quotationNo = datas.code;
			                            
			                            var frmData = new FormData();
			                            frmData.append("file", files);
			                            frmData.append("quotationNo", quotationNo);
			                           
			                            $.ajax({
			                                type : "POST",
			                                url : $stateParams.tenantid+"/app/seaquotation/saveuploadfile",
			                                data : frmData,
			                                contentType : false,
			                                processData : false,
			                                success : function(result) {
			                                	
			                                	  logger.logSuccess("File uploaded successfully!");
			                                	  
			                                }
			                            });
			                            
			                        });
			                    	
			                    }
							  
							  logger.logSuccess(datas.message);
		  					  $state.go('app.sea.quotation.list',{tenantid:$stateParams.tenantid});
							  
						        

						  }else{
							  logger.logError(datas.message);
						  }
						}).error(function(datas) {
							logger.logError("Please try again");
						});
		        	 
		         	  }else{
			 				logger.logError("Carrier field is Mandatory!.");

			             }
		         	   
             }
        }
        else{
        	logger.logError(msg);
        }
        }else{
        	logger.logError("Atleast One Row Required");
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
    
	$scope.submitupdate=function(){
		
		var msg=$scope.checkValidation();
		if(!$scope.checkundefined(msg)){
			logger.logError(msg);
		}else{
			 if($scope.quotation.quotationDtl.length>0){
				 var cond=true;var msg="";var i=1,j=1,l=1;
				 if($scope.quotation.mode!=5){
		            angular.forEach($scope.quotation.quotationFreeDaysDtl, function(files, index) {
		            	if(((files.polFreeDays==null || files.polFreeDays=='' || files.polFreeDays==undefined) && 
		            			 (files.polFreeDays1==null || files.polFreeDays1=='' || files.polFreeDays1==undefined) )
		            			 && ((files.podFreeDays==null || files.podFreeDays=='' || files.podFreeDays==undefined) 
		            					 && (files.podFreeDays1==null || files.podFreeDays1=='' || files.podFreeDays1==undefined))){
		            		cond=false;
							msg=msg+" Row "+i+" Atleast One Free Days Required! ";

		            }
					})
				}
				 angular.forEach($scope.quotation.quotationDtl, function(val, index) {
		            	if(val.unit=='1'){
		            		if(val.conType!=null && val.conType!='' &&val.conType!=undefined){
		            			
		            		}else{
								msg=msg+"Freight Charges Row "+j+" Container Type is Required! ";
		            			cond=false;
		            			
		            		}
		            	}j++;
		            })
		             angular.forEach($scope.quotation.addchargeData, function(val, index) {
		            	if(val.uom=='1'){
		            		if(val.conType!=null && val.conType!='' &&val.conType!=undefined){
		            			
		            		}else{
								msg=msg+"Local Charges Row "+l+" Container Type is Required! ";
		            			cond=false;
		            			
		            		}
		            	}l++;
		            })
		            if(cond==true){
		            	$scope.quotation.commodityL=$scope.quotation.commodityL;

		            	var commodity='';
		            	angular.forEach($scope.quotation.commodityL, function(item, index) {
		                	if(commodity!=null && commodity!=''){
		                    	commodity=commodity+','+item.id;
                          }else{
		                    	commodity=item.id;
		                	}
		                	
		                })
		               $scope.quotation.commodity=commodity;
		            	if($scope.quotation.commodity=="")
		            		$scope.quotation.commodityL = null;
		            	//if($scope.quotation.commodityL!=[] && $scope.quotation.commodityL!=null && $scope.quotation.commodityL.length!=0){
			            	if($scope.quotation.carrier!='' && $scope.quotation.carrier!=null){

			$http.post($stateParams.tenantid+'/app/quotation/update',$scope.quotation).success(function(datas) {
				  if(datas.success==true){
					  logger.logSuccess(datas.message);
					  if ($scope.files.length > 0) {
//							
							
							if($scope.files == null || $scope.files == '' || $scope.files == undefined){
								var quotationNo = $scope.quotation.quotationNo;
								$http.post($stateParams.tenantid + '/app/seaquotation/uploaddelete',quotationNo).success(
										function(data) {
											
											
										}).error(function(data) {
								});
							}
							
							
							
							
							for(var i=0;i<$scope.files.length;i++){
								 var quotationNo = $scope.quotation.quotationNo;
								 if($scope.files[i].name != null && $scope.files[i].name != undefined){
									 var file = $scope.files[i];
									 frmData.append("file", file);									 
									 frmData.append("quotationNo", quotationNo);
								 }else{
									var  filepaths = $scope.files[i];
									 frmData.append("filepaths", filepaths);
		                             frmData.append("quotationNo", quotationNo);
								 }
							}
							
							
							 $.ajax({
                             type : "POST",
                             url : $stateParams.tenantid+"/app/seaquotation/updateuploadfile",
                             data : frmData,
                             contentType : false,
                             processData : false,
                             success : function(result) {
                             }
                         });
                      }
					  $state.go('app.sea.quotation.list',{tenantid:$stateParams.tenantid});

				  }else{
					  logger.logError(datas.message);
				  }
				}).error(function(data) {
					logger.logError("Please try again");
				}); 
			}else{
					logger.logError("Carrier field is Mandatory!.");

	            }
		            	/*}else{
							logger.logError("Commodity field is Mandatory!.");

			            }*/
			
		            }
		            else{
		            	logger.logError(msg);
		            }
			 }else{
		        	logger.logError("Atleast One Row Required");
		        }
		}
		
		
	}
	$scope.cancel=function(){
	
		$state.go('app.sea.quotation.list',{tenantid:$stateParams.tenantid});
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
});

app.controller('quotationtableCtrl', function($scope, $http, $filter, logger,$stateParams) {
	 $scope.$watch('quotation.quotationDtl[trIndex].transactionType', function(newValue, oldValue) {
		 var id = newValue;
			var index = $scope.$index;
			if($scope.edit==false){
			//$scope.quotation.quotationDtl[index].buySell='';
			}
		 debugger;
		 $http.post($stateParams.tenantid+'/app/seaquotation/getServicePartnerList').success(function(datas) {
			 
				if(newValue==1){
				 
				 $scope.serviceParnrDropList=datas.vendorMasterList;
			 }else if(newValue==2){
				 $scope.serviceParnrDropList=datas.serviceParnrList;
				 if($scope.quotation.customer!=null && $scope.quotation.customer!='' && $scope.quotation.customer!=undefined){
					 $scope.quotation.quotationDtl[index].buySell=$scope.quotation.customer.toString();
					 }

			 }
			}).error(function(data) {

			});
	  });
	 $scope.$watch('quotation.quotationDtl[trIndex].conType', function(newValue, oldValue) {
		 var id = newValue;
			var index = $scope.$index;
   var check=true;
			debugger;
			if(newValue != "" && newValue != null && newValue != undefined ){
		        angular.forEach($scope.quotation.quotationFreeDaysDtl, function(row1, index1) {

		        	if(row1.conType==newValue){
		        		check=false;
		        	}
		        })
                    if(check==true){
		        		var count=$scope.quotation.quotationFreeDaysDtl.length;
		        		if(count==1){
		        			if($scope.quotation.quotationFreeDaysDtl[0].conType==null || $scope.quotation.quotationFreeDaysDtl[0].conType==''){
								$scope.quotation.quotationFreeDaysDtl[0].conType=newValue;

		        			}else {
		        				$scope.addRowFreeDays();
								$scope.quotation.quotationFreeDaysDtl[1].conType=newValue;

		        			}
		        		}else{
	        				$scope.addRowFreeDays();

						$scope.quotation.quotationFreeDaysDtl[count].conType=newValue;
		        		}
		        	}
		        	
		        
				}
				
			})
	 $scope.$watch('quotation.quotationDtl[trIndex].unit', function(newValue, oldValue) {
			var count=0;
			var index = $scope.$index;
			var service = $scope.quotation.service.toString();
			var customer = $scope.quotation.customer;
			var pol = parseInt($scope.quotation.aol);
			var pod = parseInt($scope.quotation.aod);
			var contractType = $scope.quotation.contractType;
			var validityDate = $scope.quotation.validityDate;
			var Currency = $scope.quotation.currency;
			var chrgID = parseInt($scope.quotation.quotationDtl[index].chargeHeads);
			var unitID = parseInt($scope.quotation.quotationDtl[index].unit);
			if(newValue != "" && newValue != null && newValue != undefined ){
				if (Currency != null && Currency != '' && Currency != undefined && service != null && service != '' && service != undefined &&  customer != null && customer != '' && customer != undefined && !isNaN(pol) && !isNaN(pod) && !isNaN(chrgID) && !isNaN(unitID)) {
					$http.post($stateParams.tenantid + '/app/seaquotation/checkAmountfromMRG?service='+service+'&customer='+customer+
					'&pol='+pol+'&pod='+pod+'&contractType='+contractType+'&validityDate='+validityDate+'&Currency='+Currency+'&chrgID='+chrgID+'&unitID='+unitID).success(function(datas) {
						if (datas != null && datas != 0.0) {
							$scope.quotation.quotationDtl[index].rate = datas;
						}
					})
			}
			} 

			});
});



app.controller('quotationtableCtrl1', function($scope, $http, $filter, logger,$stateParams) {
	 $scope.$watch('quotation.addchargeData[trIndex].transactionType', function(newValue, oldValue) {
		 var id = newValue;
			var index = $scope.$index;
			if($scope.edit==false){
			//$scope.quotation.quotationDtl[index].buySell='';
			}
		 debugger;
		 $http.post($stateParams.tenantid+'/app/seaquotation/getServicePartnerList').success(function(datas) {
			 
				if(newValue==1){
				 
				 $scope.serviceParnrDropList=datas.vendorMasterList;
			 }else if(newValue==2){
				 $scope.serviceParnrDropList=datas.serviceParnrList;
				 if($scope.quotation.customer!=null && $scope.quotation.customer!='' && $scope.quotation.customer!=undefined){
					 $scope.quotation.quotationDtl[index].buySell=$scope.quotation.customer.toString();
					 }

			 }
			}).error(function(data) {

			});
	  });
	 $scope.$watch('quotation.addchargeData[trIndex].conType', function(newValue, oldValue) {
		 var id = newValue;
			var index = $scope.$index;
   var check=true;
			debugger;
			if(newValue != "" && newValue != null && newValue != undefined ){
		        angular.forEach($scope.quotation.quotationFreeDaysDtl, function(row1, index1) {

		        	if(row1.conType==newValue){
		        		check=false;
		        	}
		        })
                    if(check==true){
		        		var count=$scope.quotation.quotationFreeDaysDtl.length;
		        		if(count==1){
		        			if($scope.quotation.quotationFreeDaysDtl[0].conType==null || $scope.quotation.quotationFreeDaysDtl[0].conType==''){
								$scope.quotation.quotationFreeDaysDtl[0].conType=newValue;

		        			}else {
		        				$scope.addRowFreeDays();
								$scope.quotation.quotationFreeDaysDtl[1].conType=newValue;

		        			}
		        		}else{
	        				$scope.addRowFreeDays();

						$scope.quotation.quotationFreeDaysDtl[count].conType=newValue;
		        		}
		        	}
		        	
		        
				}
				
			})
	 $scope.$watch('quotation.addchargeData[trIndex].unit', function(newValue, oldValue) {
			var count=0;
			var index = $scope.$index;
			var service = $scope.quotation.service.toString();
			var customer = $scope.quotation.customer;
			var pol = parseInt($scope.quotation.aol);
			var pod = parseInt($scope.quotation.aod);
			var contractType = $scope.quotation.contractType;
			var validityDate = $scope.quotation.validityDate;
			var Currency = $scope.quotation.currency;
			var chrgID = parseInt($scope.quotation.quotationDtl[index].chargeHeads);
			var unitID = parseInt($scope.quotation.quotationDtl[index].unit);
			if(newValue != "" && newValue != null && newValue != undefined ){
				if (Currency != null && Currency != '' && Currency != undefined && service != null && service != '' && service != undefined &&  customer != null && customer != '' && customer != undefined && !isNaN(pol) && !isNaN(pod) && !isNaN(chrgID) && !isNaN(unitID)) {
					$http.post($stateParams.tenantid + '/app/seaquotation/checkAmountfromMRG?service='+service+'&customer='+customer+
					'&pol='+pol+'&pod='+pod+'&contractType='+contractType+'&validityDate='+validityDate+'&Currency='+Currency+'&chrgID='+chrgID+'&unitID='+unitID).success(function(datas) {
						if (datas != null && datas != 0.0) {
							$scope.quotation.quotationDtl[index].rate = datas;
						}
					})
			}
			} 

			});
});
app
.controller(
		'seaquotationEditCtrl',
		function($scope, $timeout, $stateParams, sharedProperties,
				toaster, $filter, $rootScope, $http, $location, logger,
				$state, ngDialog, $controller, $injector,$window) {
			$scope.quotationTypeList = [];
			$scope.customerDropList = [];
			$scope.consigneeDropList  = [];
			$scope.shipperDropList  = [];
			$scope.nominatedDropList  = [];
			$scope.vendorDropList = [];
			$scope.serviceParnrDropList = [];
			$scope.portList = [];
			$scope.commodityList  =[];
			$scope.userId='';
			$scope.currencyList = [];
			$scope.createQuote = false;
			$scope.contractType=[];
			$scope.conTypeList=[];
			var QuotHdId = parseInt($location.search().QuotHdId);
			 var QuotHdId1 = $rootScope.QuotHdId1;
			 $scope.userId=$('#empId').val();
				$scope.checking=false;

if($scope.userId=='E0001' || $scope.userId=='E0002' || $scope.userId=='E0003'|| $scope.userId=='E0006' || $scope.userId=='E0016'){
	$scope.checking=true;
}


			$scope.quotation={
					service:'1',check:false,
					aol:'',transOrg:'',transDeg:'',
					origin:'',
					customer:'',pot:'',fpod:'',
					salesPerson:'',
					vendor : '', 
					attention : '',picPoint:'',
					quotationDate : '',
					branch : '',
					aod : '',
					destination : '',
					shipper : '',
					salesType : '',
					carrier : '',
					termConditions : '',
					mode : '',
					currency : '',
					term : '',
					commodity : '',commodityL:'',
					consignee : '',
					nominatedBy : '',
					validityDate : '',
					remarks : '',
					vessel :'',
					dimensionName:'',
					addchargeData:[],
					quotationDtl:[{id:0,chargeHeads:'',unit:'',currency:'',qty:'',rate:'',paymentMethod : '',transactionType : '',buySell : '',note : ''}]
			}
			$scope.checkundefined = function(value) {
				var invalid = false;
				if (value == undefined || value == 'undefined'
						|| value == null || value == 'null'
						|| value == '') {
					invalid = true;
				}
				return invalid;

			}
			
			
			/* $scope.downloadNewFile = function(id,downloadFile) {
			        debugger;
			        $('#' + id).attr('href',downloadFile);
			        
			        $("#" + id).bind('click', function() {
			    	  });
			    	 
			        $('#' + id).simulateClick('click');
			    	   
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
			    }*/
			/*$scope.downloadNewFile = function(id) {
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
			}*/

			$scope.addAdditionalRow = function(){
				var tempBoxData = {
						quotationDtlId : '',
						surcharge : '',
						chargeType : '',
						uom : '',
						conType: '',
						addchrgcurrency: '',bookremarks:'',bookingRate:'',bookingqty:'',
						addchrgtax: '',
						rate: '',
						qty: '',
						remarks: '',
						hazardous : false,
						isOog : false
				}
				$scope.quotation.addchargeData.push( tempBoxData); 	
			}
			  //download 

		    $scope.downloadNewFile = function(id,filepath,downloadFile) {
		        $('#tbnewExport' + id).attr('href',downloadFile);
		            // alert('clicked');
			        $("#tbnewExport" + id).bind('click', function() {

		        });
		        $("#tbnewExport" + id).simulateClick('click');
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
			 /* $scope.downloadNewFile = function(id,filepath,downloadFile) {
			      debugger

			      $('#' + id).attr('href',downloadFile);
			      
			      $('#' + id).bind('click', function() {
			  	   });
			      $('#' + id).simulateClick('click');
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
			  }*/
			/*$scope.downloadNewFile=function(id,downloadFile){
			    $("#" + id).bind('click', function() {
			    });
			    $("#" + id).simulateClick('click');
			*
			
		        debugger;
		        $('#' + id).attr('href',downloadFile);
		        
		        $("#" + id).bind('click', function() {
		    	  });
		    	 
		        $('#' + id).simulateClick('click');
		    	   
		        
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
				*/
			
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
			    
			    $http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(datas) {	  
					  $scope.conTypeList=datas.getcontypelist;
					  $scope.contractTypeList=datas.contractType;

				}).error(function(data) {

				});
			    $scope.deleteuploadfiles = function(filename) {
			      /*  $scope.tempfiles = [];
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
			        $scope.quotation.files = $scope.tempfilename;*/
			        
			        
			    	 $http.post($stateParams.tenantid+'/app/seaquotation/deleteFiles', filename).success(function(result) {
				        	
				        	$scope.getEdit();
				               
			            })
		
			    }
			    
			    
			    
				$scope.$watchCollection('quotation.customer', function(newValue, oldValue) {
					if(newValue != "" && newValue != null && newValue != undefined ){ 
						if($scope.edit==false){

						for(var i = 0;i < $scope.quotation.quotationDtl.length;i++){
			                	$scope.quotation.quotationDtl[i].transactionType='2';
			              
							}
						$scope.quotation.consolidated[0].tranType=newValue;
						if($scope.quotation.commodityL==''){
							$scope.quotation.commodityL=null;
						}
						
			        	$http.post($stateParams.tenantid+'/app/seaquotation/creditDays',$scope.quotation).success(function(datas) {
				               if(datas.success){
				            	   $scope.quotation.consolidated[0].credit=datas.consol[0].credit;
				            	   $scope.quotation.consolidated[0].creditDays=datas.consol[0].creditDays;
				               }
			            })		

			        	$http.get($stateParams.tenantid+'/app/seaquotation/getsalesPerson?id='+newValue).success(function(datas) {
				            	   $scope.quotation.salesPerson=datas.customer;
				               
			            })	
					}
				}
					

					});

			$scope.addslab = function(row, index) {
				$scope.max = Math.max.apply(Math, row.weightslab
						.map(function(item) {
							return item.wid;
						}));
				var len = row.weightslab.length - 1;
				$scope.max = $scope.max + 1;
				var json = {
					wid : $scope.max,
					fromweight : row.weightslab[len].toweight + 1,
					toweight : row.weightslab[len].toweight + 2,
					charges : []
				}
				row.weightslab.push(json);
				len = row.weightslab.length - 1;
				$timeout(function() {
					hideActivePapers(row.id + "" + $scope.max, []);
				}, 1000);
			}
			$scope.addRow = function() {

				$scope.max = Math.max.apply(Math,
						$scope.quotation.quotationDtl
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
				if($scope.quotation.customer!=null && $scope.quotation.customer!='' && $scope.quotation.customer!=undefined){
					for(var i = 0;i < $scope.quotation.quotationDtl.length;i++){
		            	$scope.quotation.quotationDtl[i].transactionType='2';
		          
					}
				}
			}
			$scope.removeRow = function() {
				$scope.tablerow = [];
				angular.forEach($scope.quotation.quotationDtl,
						function(row, index) {
							var check = row.select;
							
							if (check == undefined || check == "") {
								$scope.tablerow.push(row);
							} else {

							}
						});
				$scope.quotation.quotationDtl = $scope.tablerow;
			};
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
			$scope.doubleshowTable = function(wtIndex, trIndex) {

				var n = $("#handsondiv" + trIndex + wtIndex).css(
						"display");

				if (n == 'none') {
					$("#handsondiv" + trIndex + wtIndex).css("display",
							"block");
					$scope.addindex = trIndex + "" + wtIndex;
				} else if (n == 'block') {
					$("#handsondiv" + trIndex + wtIndex).css("display",
							"none");

				}

			}

			var today = new Date();
			var dd = today.getDate();
			var mm = today.getMonth() + 1;

			var yyyy = today.getFullYear();
			if (dd < 10) {
				dd = '0' + dd
			}
			if (mm < 10) {
				mm = '0' + mm
			}
			var today = dd + '/' + mm + '/' + yyyy;
			$scope.quotation.dataOfIssues = today;
			
			
			
			$scope.getQuotationType=function(){
			    
				$http.post($stateParams.tenantid+'/app/seaquotation/modelist').success(function(data) {
					debugger
					$scope.modelistHeader =[];
					angular.forEach(data.lQuotationBean, function(row, index) { 
				

			if(row.modeName != null && row.modeName != ''){
				
				var mode =row.modeName.split(",");
				for(var i=0;i<mode.length;i++){
					
					 var  data = {};
					
						 if(mode[i]==1){
			                   
			                    data["id"] = "1";
			                    data["text"] = "SEA COASTAL";
				            
					    }else  if(mode[i]==2){
			                     
			                     data["id"] = "2";
			                     data["text"] = "SEA FOREIGN";
				           
					    }else  if(mode[i]==3){
			                   
			                     data["id"] = "3";
			                     data["text"] = "TRUCK";
				            

					    }else  if(mode[i]==4){
			                 
			                 data["id"] = "4";
			                 data["text"] = "LINER";
				         

					    }else  if(mode[i]==5){
	                 
	                 data["id"] = "5";
	                 data["text"] = "FORWARDING";
		         

			    }
						 $scope.modelistHeader.push(data);
			   
		}	    
					
				}else{
					 var  data = {};
		      	    data["id"] = "1";
		    	    data["text"] = "SEA COASTAL";
		    	    $scope.modelistHeader.push(data);
		    	    //$scope.quotation.mode='1';
		    	    data = {};
		    	    data["id"] = "2";
		    	    data["text"] = "SEA FOREIGN";
		    	    $scope.modelistHeader.push(data);
		    	    data = {};
		    	    data["id"] = "3";
		    	    data["text"] = "TRUCK";
		    	    $scope.modelistHeader.push(data);
		    	    data = {};
		    	    data["id"] = "4";
		    	    data["text"] = "LINER";
		    	    $scope.modelistHeader.push(data);
		         data = {};
    	    data["id"] = "5";
    	    data["text"] = "FORWARDING";
    	    $scope.modelistHeader.push(data);

				}
			
			// $scope.modelistHeader.push(data);

					})
				});
		}; $scope.getQuotationType();
			
			
			/*$scope.modeList = [];
			$scope.getQuotationType = function() {
				var data = {};
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
				// data = {};
				// data["id"] = "2";
				// data["text"] = "SEA";
				// $scope.modeList.push(data);
			}*/

			$scope.salesTypeList = [];
			$scope.getSalesType = function() {
			    var  data = {};
				    data["id"] = "1";
				    data["text"] = "CROSS TRADE";
				    $scope.salesTypeList.push(data);
				    data = {};
				    data["id"] = "2";
				    data["text"] = "LOCAL";
				    $scope.salesTypeList.push(data);  
				    data = {};
				    data["id"] = "3";
				    data["text"] = "NOMINATED";
				    $scope.salesTypeList.push(data);  
				    	  
				}
			$scope.getSalesType();
//			$scope.getSalesType = function() {
//				var data = {};
//				data["id"] = "1";
//				data["text"] = "CROSS TRADE";
//				$scope.salesTypeList.push(data);
//				data = {};
//				data["id"] = "2";
//				data["text"] = "LOCAL";
//				$scope.salesTypeList.push(data);
//				data = {};
//				data["id"] = "3";
//				data["text"] = "NOMINATED";
//				$scope.salesTypeList.push(data);
//
//			}
//			$scope.getSalesType();
			$scope.transactionTypeList = [];

//			$scope.getTransactionType = function() {
//				var data = {};
//				data["id"] = "1";
//				data["text"] = "BUY";
//				$scope.transactionTypeList.push(data);
//				data = {};
//				data["id"] = "2";
//				data["text"] = "SELL";
//				$scope.transactionTypeList.push(data);
//
//			}
//			$scope.getTransactionType();

			$scope.PaymentMethodList = [];
//			$scope.getpaymentMethod = function() {
//				var data = {};
//				data["id"] = "1";
//				data["text"] = "PREAPID TO COLLECT";
//				$scope.PaymentMethodList.push(data);
//				// data = {};
//				// data["id"] = "2";
//				// data["text"] = "SELL";
//				// $scope.PaymentMethodList.push(data);
//
//			}
//			$scope.getpaymentMethod();

			$scope.chargeList = [];
			$scope.dropdown = function() {
				$scope.getQuotationType();
				$http
						.post(
								$stateParams.tenantid
										+ '/app/seaquotation/getServicePartnerList')
						.success(
								function(datas) {
									debugger
									 $scope.customerDropList = datas.customerList;
									 $scope.consigneeDropList = datas.consigneeList;
									 $scope.shipperDropList = datas.shipperList;
									 $scope.nominatedDropList = datas.nominatedList;
									 $scope.vendorDropList = datas.vendorList;
									// $scope.serviceParnrDropList=datas.serviceParnrList;

								}).error(function(data) {

						});
				$http.get(
						$stateParams.tenantid
								+ '/app/seaquotation/getiataList')
						.success(function(datas) {
							debugger
							$scope.portList = datas.commonUtilityBean;

						}).error(function(data) {

						});
				$http.get($stateParams.tenantid+'/app/seaquotation/getpicList').success(function(datas) {
					debugger
				    $scope.pickupList = datas.commonUtilityBean;	    

				}).error(function(data) {

				});
				/*$http
						.get(
								$stateParams.tenantid
										+ '/app/seaquotation/getBranch')
						.success(
								function(datas) {
									$scope.branchList = datas.commonUtilityBean;

								}).error(function(data) {

						});*/
				$http
						.get(
								$stateParams.tenantid
										+ '/app/seaquotation/getCurrencyList')
						.success(
								function(datas) {
									$scope.currencylist = angular
											.copy(datas.commonUtilityBean);
								}).error(function(data) {

						});

				/*$http
						.get(
								$stateParams.tenantid
										+ '/app/seaquotation/getServicePartnerType')
						.success(
								function(datas) {
									$scope.servicePartnerTypelist = angular
											.copy(datas.commonUtilityBean);
								}).error(function(data) {

						});*/
				
				var serviceList = [ {
		            id : '1',
		            text : 'EXPORT'
		        }, {
		            id : '2',
		            text : 'IMPORT'
		        }]
				
				$scope.servicePartnerTypelist=serviceList;
				

				$http
						.get(
								$stateParams.tenantid
										+ '/app/seaquotation/getEmployeeList')
						.success(
								function(datas) {
									$scope.employeeList = datas.commonUtilityBean;

								}).error(function(data) {

						});

				
				/*$http.get($stateParams.tenantid + '/app/airquotation/getSalesList')
				.success(function(datas) {
					$scope.salesTypeList = datas.commonUtilityBean;

				}).error(function(data) {

				});
*/				
				/*$http.get($stateParams.tenantid + '/app/airquotation/getServiceList')
				.success(function(datas) {
					$scope.servicePartnerTypelist = datas.commonUtilityBean;

				}).error(function(data) {

				});*/
				
				var serviceList = [ {
		            id : '1',
		            text : 'EXPORT'
		        }, {
		            id : '2',
		            text : 'IMPORT'
		        }]
				
				$scope.servicePartnerTypelist=serviceList;
				
				/*$http.get($stateParams.tenantid+'/app/seaquotation/getcommodity').success(function(datas) {
					
				    $scope.commodityList = datas.commonUtilityBean;	    

				}).error(function(data) {

				});*/
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
				
				$http
						.get(
								$stateParams.tenantid
										+ '/app/seaquotation/getChargeHeads')
						.success(
								function(datas) {
									$scope.chargeHeadList = datas.commonUtilityBean;

								}).error(function(data) {

						});

				$http.get(
						$stateParams.tenantid
								+ '/app/seaquotation/getTerms')
						.success(function(datas) {
							$scope.TermList = datas.commonUtilityBean;

						}).error(function(data) {

						});

				$http.get(
						$stateParams.tenantid
								+ '/app/seaquotation/getUnitList')
						.success(function(datas) {
							$scope.UnitList = datas.commonUtilityBean;

						}).error(function(data) {

						});

			}
			$scope.editdata = function(quotation) {

				$scope.getQuotationType();
				$http
						.post(
								$stateParams.tenantid
										+ '/app/seaquotation/getServicePartnerList')
						.success(
								function(datas) {
									debugger
									 $scope.customerDropList = datas.customerList;
									 $scope.consigneeDropList = datas.consigneeList;
									 $scope.shipperDropList = datas.shipperList;
									 $scope.nominatedDropList = datas.nominatedList;
									 $scope.vendorDropList = datas.vendorList;
									// $scope.serviceParnrDropList=datas.serviceParnrList;

								}).error(function(data) {

						});
			}

			
			$scope.$watch('quotation.quotationDtl[trIndex].transactionType', function(newValue, oldValue) {
				 var id = newValue;
					var index = $scope.$index;
					$scope.quotation.quotationDtl[index].buySell='';
				 debugger;
				 $http.post($stateParams.tenantid+'/app/seaquotation/getServicePartnerList').success(function(datas) {
					 
						if(newValue==1){
						 
						 $scope.serviceParnrDropList=datas.vendorMasterList;
					 }else if(newValue==2){
						 $scope.serviceParnrDropList=datas.serviceParnrList;
						 if($scope.quotation.customer!=null && $scope.quotation.customer!='' && $scope.quotation.customer!=undefined){
							 $scope.quotation.quotationDtl[index].buySell=$scope.quotation.customer.toString();
							 }

					 }
					}).error(function(data) {

					});
			  });

			$scope.changecolor = function(id) {
				$('#' + id + ' .selectivityId').find('input').css(
						"border-color", "red");
				;

			}
			$scope.clearcolor = function(id) {
				$('#' + id + ' .selectivityId').find('input').css(
						"border-color", "#e8dddd");
				;

			}

			$scope.checkValidation = function() {

			    var alertmsg = "<ui><h4>Please fill the required fields</h4>";
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
			    if ($scope.checkundefined($scope.quotation.service)) {
			        msg = msg + "<li>Service:Field is required.</li>";         
			        $scope.changecolor('service');
			    }else{
			    	$scope.clearcolor('service');
			    }
			    if ($scope.checkundefined($scope.quotation.aol)) {
			        msg = msg + "<li>POL:Field is required.</li>";         
			        $scope.changecolor('aol');
			    }else{
			    	$scope.clearcolor('aol');
			    }
			    if ($scope.checkundefined($scope.quotation.quotationDate)) {
			        msg = msg + "<li>QuotationDate:Field is required.</li>";         
			        $scope.changecolor('quotationDate');
			    }else{
			    	$scope.clearcolor('quotationDate');
			    }
			    if ($scope.checkundefined($scope.quotation.branch)) {
			        msg = msg + "<li>Branch:Field is required.</li>";         
			        $scope.changecolor('branch');
			    }else{
			    	$scope.clearcolor('branch');
			    }
			    if ($scope.checkundefined($scope.quotation.aod)) {
			        msg = msg + "<li>POD:Field is required.</li>";         
			        $scope.changecolor('aod');
			    }else{
			    	$scope.clearcolor('aod');
			    }
			    if ($scope.checkundefined($scope.quotation.salesType)) {
			        msg = msg + "<li>SalesType:Field is required.</li>";         
			        $scope.changecolor('salesType');
			    }else{
			    	$scope.clearcolor('salesType');
			    }
			    if ($scope.checkundefined($scope.quotation.cargoType)) {
			        msg = msg + "<li>Cargo Type:Field is required.</li>";         
			        $scope.changecolor('cargoType');
			    }else{
			    	$scope.clearcolor('cargoType');
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
			    }
			    if ($scope.checkundefined($scope.quotation.validityDate)) {
			        msg = msg + "<li>ValidityDate:Field is required.</li>";         
			        $scope.changecolor('validityDate');
			    }else{
			    	$scope.clearcolor('validityDate');
			    }
			    
			    if($scope.quotation.mode!=5){
				    if ($scope.checkundefined($scope.quotation.commodityL)) {
				        msg = msg + "<li>Commodity:Field is required.</li>";         
				        $scope.changecolor('Commodity');
				    }else{
				    	$scope.clearcolor('Commodity');
				    }
				}
			  	    angular.forEach($scope.quotation.quotationDtl, function(chargesDetail, index) {     
			        if ($scope.checkundefined(chargesDetail.chargeHeads)) {
			            msg = msg + "<li>Row :" + (index + 1) + "# Charge Heads :Field is required.</li>";
			            $scope.changecolor('chargeHeads'+index);
			        }else{
			        	$scope.clearcolor('chargeHeads'+index);
			        }
			        if ($scope.checkundefined(chargesDetail.unit)) {
			            msg = msg + "<li>Row :" + (index + 1) + "# Unit :Field is required.</li>";
			            $scope.changecolor('unit'+index);
			        }else{
			        	$scope.clearcolor('unit'+index);
			        }
			        if ($scope.checkundefined(chargesDetail.qty)) {
			            msg = msg + "<li>Row :" + (index + 1) + "# Quantity :Field is required.</li>";
			            $scope.changecolor('qty'+index);
			            $('#qty'+index).find('input').css("border-color", "red");

			        }  else{
			        	$('#qty'+index).find('input').css("border-color", "#e8dddd");
			        }
			        if ($scope.checkundefined(chargesDetail.rate)) {
			            msg = msg + "<li>Row :" + (index + 1) + "# Rate :Field is required.</li>";
			        }  
			   /*     if ($scope.checkundefined(chargesDetail.paymentMethod)) {
			            msg = msg + "<li>Row :" + (index + 1) + "# Payment Method :Field is required.</li>";
			        }  */
			        if ($scope.checkundefined(chargesDetail.currency)) {
			            msg = msg + "<li>Row :" + (index + 1) + "# Currency :Field is required.</li>";
			        }  
			        if ($scope.checkundefined(chargesDetail.transactionType)) {
			            msg = msg + "<li>Row :" + (index + 1) + "# Transaction Type :Field is required.</li>";
			        }  
			        if ($scope.checkundefined(chargesDetail.buySell)) {
			            msg = msg + "<li>Row :" + (index + 1) + "# Buy/Sell Party:Field is required.</li>";
			        }  
			        
			        
			        
			    });
			    alertmsg = alertmsg + msg + "</ui>";
			    if ($scope.checkundefined(msg)) {
			        return '';
			    } else {
			        return alertmsg;
			    }

			}
			
			
			$scope.checkundefined1 = function(value) {
		        var invalid = false;
		        if (value == undefined || value == 'undefined' || value == null || value == 'null' || value == '') {
		            invalid = true;
		        }
		        return invalid;

		    }
		

			$scope.addRowFreeDays = function() {
				 
		 		var chargedata = {
		 				conType : '',
		 				polFreeDays : '',
		 				podFreeDays : ''
				};

				$scope.quotation.quotationFreeDaysDtl.push(chargedata);
		   	}
			$scope.addRowGroundFreeDays = function() {
				 
		 		var chargedata = {
		 				conType : '',
		 				polFreeDays : '',
		 				podFreeDays1 : '',
		 				polFreeDays : '',
		 				podFreeDays1 : ''
				};

				$scope.quotation.quotationGroundFreeDaysDtl.push(chargedata);
		   	}
			$scope.edit = false;
			$scope.getEdit = function() {
			if (QuotHdId != '' && QuotHdId != undefined && $.isNumeric(QuotHdId)) {
				$scope.edit = true;
				$scope.dropdown();
				$http
						.post(
								$stateParams.tenantid
										+ '/app/seaquotation/edit',
								QuotHdId)
						.success(
								function(data) {
									console.log(data);
									debugger
									$scope.quotation = data.lQuotationBean[0];
									$scope.quotation.addchargeData=data.lQuotationBean[0].addchargeData;
									angular.forEach($scope.quotation.addchargeData, function(chargesDetail, index) { 
										chargesDetail.addchrgcurrency=chargesDetail.addchrgcurrency.toString();
									})
									//$scope.quotation.quotationFreeDaysDtl=data.lQuotationBean[0].quotationFreeDaysDtl[0];
									$scope.quotation.consolidated=data.consol;

									$scope.files=[];
									if(data.lQuotationBean[0].commodity != null && data.lQuotationBean[0].commodity != ''){
										$scope.quotation.commodity = data.lQuotationBean[0].commodity.toString();
									}
									if(data.lQuotationBean[0].transDeg != null && data.lQuotationBean[0].transDeg != ''){
										$scope.quotation.transDeg = data.lQuotationBean[0].transDeg.toString();
									}
									if(data.lQuotationBean[0].transOrg != null && data.lQuotationBean[0].transOrg != ''){
										$scope.quotation.transOrg = data.lQuotationBean[0].transOrg.toString();
									}
									if(data.lQuotationBean[0].pot != null && data.lQuotationBean[0].pot != ''){
										$scope.quotation.pot = data.lQuotationBean[0].pot.toString();
									}if(data.lQuotationBean[0].fpod != null && data.lQuotationBean[0].fpod != ''){
										$scope.quotation.fpod = data.lQuotationBean[0].fpod.toString();
									}
									
									if(data.lQuotationBean[0].service != null && data.lQuotationBean[0].service != ''){
										$scope.quotation.service = data.lQuotationBean[0].service
										.toString();
									}
									if(data.lQuotationBean[0].branch != null && data.lQuotationBean[0].branch != ''){

									$scope.quotation.branch = data.lQuotationBean[0].branch
											.toString();
									}
									if(data.lQuotationBean[0].mode != null && data.lQuotationBean[0].mode != ''){

									$scope.quotation.mode = data.lQuotationBean[0].mode
											.toString();
									}
									if(data.lQuotationBean[0].aol != null && data.lQuotationBean[0].aol != ''){

									$scope.quotation.aol = data.lQuotationBean[0].aol
											.toString();
									}
									if(data.lQuotationBean[0].aod != null && data.lQuotationBean[0].aod != ''){

									$scope.quotation.aod = data.lQuotationBean[0].aod
											.toString();
									}
									if(data.lQuotationBean[0].pot != null && data.lQuotationBean[0].pot != ''){

										$scope.quotation.pot = data.lQuotationBean[0].pot
												.toString();
										}if(data.lQuotationBean[0].fpod != null && data.lQuotationBean[0].fpod != ''){

											$scope.quotation.fpod = data.lQuotationBean[0].fpod
													.toString();
											}
									if(data.lQuotationBean[0].term != null && data.lQuotationBean[0].term != ''){

									$scope.quotation.term = data.lQuotationBean[0].term
											.toString();
									}
									if(data.lQuotationBean[0].origin != null && data.lQuotationBean[0].origin != ''){

									$scope.quotation.origin = data.lQuotationBean[0].origin
											.toString();
									}
									if(data.lQuotationBean[0].destination != null && data.lQuotationBean[0].destination != ''){

									$scope.quotation.destination = data.lQuotationBean[0].destination
											.toString();
									}
									if(data.lQuotationBean[0].customer != null && data.lQuotationBean[0].customer != ''){

									$scope.quotation.customer = data.lQuotationBean[0].customer
											.toString();
									}
									if(data.lQuotationBean[0].shipper != null && data.lQuotationBean[0].shipper != ''){

									$scope.quotation.shipper = data.lQuotationBean[0].shipper
											.toString();
									}
									if(data.lQuotationBean[0].consignee != null && data.lQuotationBean[0].consignee != ''){

									$scope.quotation.consignee = data.lQuotationBean[0].consignee
											.toString();
									}
									if(data.lQuotationBean[0].nominatedBy != null && data.lQuotationBean[0].nominatedBy != ''){

									$scope.quotation.nominatedBy = data.lQuotationBean[0].nominatedBy
											.toString();
									}
									if(data.lQuotationBean[0].vendor != null && data.lQuotationBean[0].vendor != ''){

									$scope.quotation.vendor = data.lQuotationBean[0].vendor
											.toString();
									}
									if(data.lQuotationBean[0].currency != null && data.lQuotationBean[0].currency != ''){

									$scope.quotation.currency = data.lQuotationBean[0].currency
											.toString();
									}
									if(data.lQuotationBean[0].salesType != null && data.lQuotationBean[0].salesType != ''){

									$scope.quotation.salesType = data.lQuotationBean[0].salesType
											.toString();
									}

									for (var i = 0; i < $scope.quotation.quotationDtl.length; i++) {
										$scope.quotation.quotationDtl[i].chargeHeads = $scope.quotation.quotationDtl[i].chargeHeads
												.toString();
										$scope.quotation.quotationDtl[i].unit = $scope.quotation.quotationDtl[i].unit
												.toString();
										$scope.quotation.quotationDtl[i].currency = $scope.quotation.quotationDtl[i].currency
												.toString();
									/*	$scope.quotation.quotationDtl[i].paymentMethod = $scope.quotation.quotationDtl[i].paymentMethod
												.toString();*/
										$scope.quotation.quotationDtl[i].transactionType = $scope.quotation.quotationDtl[i].transactionType
												.toString();
										$scope.quotation.quotationDtl[i].buySell = $scope.quotation.quotationDtl[i].buySell.toString();
									}
									
									 angular.forEach(data.filel, function(value, index) {
				                          	
										  var dummy = value.fileName;
										  
										  
										  $scope.files.push(dummy);
										 
									  });
									 
									  var dum = []; 
										for (var i = 0; i < $scope.files.length; i++) {
											debugger
											var subString = "/"; 
											 if($scope.files[i].indexOf(subString) !== -1){
												                        
													if ($scope.files[i].indexOf(subString) !== -1) {                            
														var val = $scope.files[i].split("/");                            
														//var	value = val[val.length - 1];  
														
														var value ={ 
																
																filename : val[val.length - 1],
												                //filepath : '/mbk'+$scope.files[i],
												                filepath : $scope.files[i],

												                quotation : ''
															   }
														
														dum.push(value);                        
														} else {                            
															var val = $scope.files[i].split("\\");                           
															//var value = val[val.length - 1]; 
															var value ={ 
																	
																	filename : val[val.length - 1],
													                //filepath : '/mbk'+$scope.files[i],
													                filepath : $scope.files[i],

													                quotation : ''
																   }
															dum.push(value);    
															
															}   
											 }else{
												                        
													if ($scope.files[i].indexOf(subString) !== -1) {                            
														var val = $scope.files[i].split("/");                            
														var value ={ 
														
														filename : val[0],
										                //filepath : '/mbk'+$scope.files[i],
										                filepath : $scope.files[i],

										                quotation : ''
													   }
														
														dum.push(value);                        
														} else {                            
															var val = $scope.files[i].split("\\");                           
															var value ={ 
																	
																	filename : val[0],
													               // filepath : '/mbk'+$scope.files[i],
													                filepath : $scope.files[i],

													                quotation : ''
																   }                            
															dum.push(value); 
															
															}   
											 }
											 
											 
											                 
											}
									$scope.quotation.files=dum;
									 /*bean.push($scope.quotation.files);*/
									$scope.quotation.quotationFreeDaysDtl=data.lQuotationBean[0].quotationFreeDaysDtl;
									//rowCollectionNew=$scope.quotation.quotationFreeDaysDtl;
									/*$http.get($stateParams.tenantid+'/app/seaquotation/getcommodity').success(function(datas) {
										
									    $scope.commodityList = datas.commonUtilityBean;	    

									}).error(function(data) {

									});
									
							  	    angular.forEach($scope.quotation.quotationDtl, function(chargesDetail, index) {     
							  	    	
							  	    })
								var com=
								$scope.quotation.commodityL=$scope.commodityList;*/
									  $http.post($stateParams.tenantid+'/app/seaquotation/getcommodity').success(function(data) { 
							              $scope.commodityList = data.commonUtilityBean;
							           	 $scope.compaccList = [];
							           	 var valArr = $scope.quotation.commodity.split(',');
							           	 var i = 0, size = valArr.length;
							           	 for (i; i < size; i++) {
							           	// $("#port").find("option[label=" + valArr[i] + "]").prop("selected", "selected");
							           	 angular.forEach($scope.commodityList, function(value, key) {
							           	 if (valArr[i] == value.id) {
							           	 $scope.compaccList.push(value);
							           	 }
							           	 });
							           	  
							           	 }
							             $scope.quotation.commodityL = $scope.compaccList;

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
								})
			    }
			}
			
		 	$scope.getEdit();
		 	
		 	
			$scope.view = false;
			

			if (QuotHdId1 != '' && QuotHdId1 != undefined && $.isNumeric(QuotHdId1)) {
				$scope.edit = false;
				$scope.dropdown();
				$http
						.post(
								$stateParams.tenantid
										+ '/app/seaquotation/edit',
								QuotHdId1)
						.success(
								function(data) {
									console.log(data);
									debugger

									$scope.quotation = data.lQuotationBean[0];
									$scope.quotation.addchargeData=data.lQuotationBean[0].addchargeData;
									angular.forEach($scope.quotation.addchargeData, function(chargesDetail, index) { 
										chargesDetail.addchrgcurrency=chargesDetail.addchrgcurrency.toString();
									})
									$scope.quotation.consolidated=data.consol;

									//$scope.quotation.quotationFreeDaysDtl=data.lQuotationBean[0].quotationFreeDaysDtl[0];

									$scope.files=[];
									if(data.lQuotationBean[0].commodity != null && data.lQuotationBean[0].commodity != ''){
										$scope.quotation.commodity = data.lQuotationBean[0].commodity.toString();
									}
									
									if(data.lQuotationBean[0].service != null && data.lQuotationBean[0].service != ''){
										$scope.quotation.service = data.lQuotationBean[0].service
										.toString();
									}
									if(data.lQuotationBean[0].branch != null && data.lQuotationBean[0].branch != ''){

									$scope.quotation.branch = data.lQuotationBean[0].branch
											.toString();
									}
									if(data.lQuotationBean[0].mode != null && data.lQuotationBean[0].mode != ''){

									$scope.quotation.mode = data.lQuotationBean[0].mode
											.toString();
									}
									if(data.lQuotationBean[0].aol != null && data.lQuotationBean[0].aol != ''){

									$scope.quotation.aol = data.lQuotationBean[0].aol
											.toString();
									}
									if(data.lQuotationBean[0].aod != null && data.lQuotationBean[0].aod != ''){

									$scope.quotation.aod = data.lQuotationBean[0].aod
											.toString();
									}if(data.lQuotationBean[0].pot != null && data.lQuotationBean[0].pot != ''){

										$scope.quotation.pot = data.lQuotationBean[0].pot
												.toString();
										}if(data.lQuotationBean[0].fpod != null && data.lQuotationBean[0].fpod != ''){

											$scope.quotation.fpod = data.lQuotationBean[0].fpod
													.toString();
											}
									if(data.lQuotationBean[0].term != null && data.lQuotationBean[0].term != ''){

									$scope.quotation.term = data.lQuotationBean[0].term
											.toString();
									}
									if(data.lQuotationBean[0].origin != null && data.lQuotationBean[0].origin != ''){

									$scope.quotation.origin = data.lQuotationBean[0].origin
											.toString();
									}
									if(data.lQuotationBean[0].destination != null && data.lQuotationBean[0].destination != ''){

									$scope.quotation.destination = data.lQuotationBean[0].destination
											.toString();
									}
									if(data.lQuotationBean[0].customer != null && data.lQuotationBean[0].customer != ''){

									$scope.quotation.customer = data.lQuotationBean[0].customer
											.toString();
									}
									if(data.lQuotationBean[0].shipper != null && data.lQuotationBean[0].shipper != ''){

									$scope.quotation.shipper = data.lQuotationBean[0].shipper
											.toString();
									}
									if(data.lQuotationBean[0].consignee != null && data.lQuotationBean[0].consignee != ''){

									$scope.quotation.consignee = data.lQuotationBean[0].consignee
											.toString();
									}
									if(data.lQuotationBean[0].nominatedBy != null && data.lQuotationBean[0].nominatedBy != ''){

									$scope.quotation.nominatedBy = data.lQuotationBean[0].nominatedBy
											.toString();
									}
									if(data.lQuotationBean[0].vendor != null && data.lQuotationBean[0].vendor != ''){

									$scope.quotation.vendor = data.lQuotationBean[0].vendor
											.toString();
									}
									if(data.lQuotationBean[0].currency != null && data.lQuotationBean[0].currency != ''){

									$scope.quotation.currency = data.lQuotationBean[0].currency
											.toString();
									}
									if(data.lQuotationBean[0].salesType != null && data.lQuotationBean[0].salesType != ''){

									$scope.quotation.salesType = data.lQuotationBean[0].salesType
											.toString();
									}
									for (var i = 0; i < $scope.quotation.quotationDtl.length; i++) {
										$scope.quotation.quotationDtl[i].chargeHeads = $scope.quotation.quotationDtl[i].chargeHeads
												.toString();
										$scope.quotation.quotationDtl[i].unit = $scope.quotation.quotationDtl[i].unit
												.toString();
										$scope.quotation.quotationDtl[i].currency = $scope.quotation.quotationDtl[i].currency
												.toString();
									/*	$scope.quotation.quotationDtl[i].paymentMethod = $scope.quotation.quotationDtl[i].paymentMethod
												.toString();*/
										$scope.quotation.quotationDtl[i].transactionType = $scope.quotation.quotationDtl[i].transactionType
												.toString();
										$scope.quotation.quotationDtl[i].buySell = $scope.quotation.quotationDtl[i].buySell
												.toString();
									}
									
									 angular.forEach(data.filel, function(value, index) {
				                          	
										  var dummy = value.fileName;
										  
										  
										  $scope.files.push(dummy);
										 
									  });
									 
									  var dum = []; 
										for (var i = 0; i < $scope.files.length; i++) {
											debugger
											var subString = "/"; 
											 if($scope.files[i].indexOf(subString) !== -1){
												                        
													if ($scope.files[i].indexOf(subString) !== -1) {                            
														var val = $scope.files[i].split("/");                            
														//var	value = val[val.length - 1];  
														
														var value ={ 
																
																filename : val[val.length - 1],
												                filepath : '',
												                quotation : ''
															   }
														
														dum.push(value);                        
														} else {                            
															var val = $scope.files[i].split("\\");                           
															//var value = val[val.length - 1]; 
															var value ={ 
																	
																	filename : val[val.length - 1],
													                filepath : '',
													                quotation : ''
																   }
															dum.push(value);    
															
															}   
											 }else{
												                        
													if ($scope.files[i].indexOf(subString) !== -1) {                            
														var val = $scope.files[i].split("/");                            
														var value ={ 
														
														filename : val[0],
										                filepath : '',
										                quotation : ''
													   }
														-+
														dum.push(value);                        
														} else {                            
															var val = $scope.files[i].split("\\");                           
															var value ={ 
																	
																	filename : val[0],
													                filepath : '',
													                quotation : ''
																   }                            
															dum.push(value); 
															
															}   
											 }
											 
											 
											                 
											}
									$scope.quotation.files=dum;
									 /*bean.push($scope.quotation.files);*/
									$scope.quotation.quotationFreeDaysDtl=data.lQuotationBean[0].quotationFreeDaysDtl;
									//rowCollectionNew=$scope.quotation.quotationFreeDaysDtl;
									 $http.post($stateParams.tenantid+'/app/seaquotation/getcommodity').success(function(data) { 
							              $scope.commodityList = data.commonUtilityBean;
							           	 $scope.compaccList = [];
							           	 var valArr = $scope.quotation.commodity.split(',');
							           	 var i = 0, size = valArr.length;
							           	 for (i; i < size; i++) {
							           	// $("#port").find("option[label=" + valArr[i] + "]").prop("selected", "selected");
							           	 angular.forEach($scope.commodityList, function(value, key) {
							           	 if (valArr[i] == value.id) {
							           	 $scope.compaccList.push(value);
							           	 }
							           	 });
							           	  
							           	 }
							             $scope.quotation.commodityL = $scope.compaccList;

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
								});
			    }

	       

	    
		 	
			$scope.submit=function(){
				
				var msg=$scope.checkValidation();
				if(!$scope.checkundefined(msg)){
					logger.logError(msg);
				}else{
			        if($scope.quotation.quotationDtl.length>0){
						var cond=true;var msg='';var j=1,i=1,l=1;	
						if($scope.quotation.mode!=5){
			            angular.forEach($scope.quotation.quotationFreeDaysDtl, function(files, index) {
			            	if(((files.polFreeDays==null || files.polFreeDays=='' || files.polFreeDays==undefined) && 
			            			 (files.polFreeDays1==null || files.polFreeDays1=='' || files.polFreeDays1==undefined) )
			            			 && ((files.podFreeDays==null || files.podFreeDays=='' || files.podFreeDays==undefined) 
			            					 && (files.podFreeDays1==null || files.podFreeDays1=='' || files.podFreeDays1==undefined))){
			            		cond=false;
								msg=msg+" Row "+i+" Atleast One Free Days Required! ";

			            }
						})
					}
						 angular.forEach($scope.quotation.quotationDtl, function(val, index) {
				            	if(val.unit=='1'){
				            		if(val.conType!=null && val.conType!='' &&val.conType!=undefined){
				            			
				            		}else{
										msg=msg+"Freight Charges Row "+j+" Container Type is Required! ";
				            			cond=false;
				            			
				            		}
				            	}j++;
				            })
				             angular.forEach($scope.quotation.addchargeData, function(val, index) {
		            	if(val.uom=='1'){
		            		if(val.conType!=null && val.conType!='' &&val.conType!=undefined){
		            			
		            		}else{
								msg=msg+"Local Charges Row "+l+" Container Type is Required! ";
		            			cond=false;
		            			
		            		}
		            	}l++;
		            })
			            if(cond==true){
			            	$scope.quotation.commodityL=$scope.quotation.commodityL;

			            	var commodity='';
			            	angular.forEach($scope.quotation.commodityL, function(item, index) {
			                	if(commodity!=null && commodity!=''){
			                    	commodity=commodity+','+item.id;
			                  }else{
			                    	commodity=item.id;
			                	}
			                	
			                })
			               $scope.quotation.commodity=commodity;
			            	if($scope.quotation.mode!=5){
			            		if($scope.quotation.commodityL!=[] && $scope.quotation.commodityL!=null && $scope.quotation.commodityL.length!=0){
		         	   if($scope.quotation.carrier!='' && $scope.quotation.carrier!=null){

					$http.post($stateParams.tenantid+'/app/seaquotation/save',$scope.quotation).success(function(datas) {
						debugger
						  if(datas.success==true){
							  if ($scope.files.length > 0) {

			                        angular.forEach($scope.files, function(files, index) {
			                        	
			                        	
			                            var quotationNo = datas.code;
			                            
			                            var frmData = new FormData();
			                            frmData.append("file", files);
			                            frmData.append("quotationNo", quotationNo);
			                           
			                            $.ajax({
			                                type : "POST",
			                                url : $stateParams.tenantid+"/app/seaquotation/saveuploadfile",
			                                data : frmData,
			                                contentType : false,
			                                processData : false,
			                                success : function(result) {
			                                	
			                                	  logger.logSuccess("File uploaded successfully!");
			                                	  
			                                }
			                            });
			                            
			                        });
			                    	
			                    }
							  
							  logger.logSuccess(datas.message);
		  					  $state.go('app.sea.quotation.list',{tenantid:$stateParams.tenantid});
							  
						        

						  }else{
							  logger.logError(datas.message);
						  }
						}).error(function(datas) {
							logger.logError("Please try again");
						});
		        	 
		         	  }else{
			 				logger.logError("Carrier field is Mandatory!.");

			             }
		         	   }else{
		 				logger.logError("Commodity field is Mandatory!.");

		             }}else{
				         	   if($scope.quotation.carrier!='' && $scope.quotation.carrier!=null){

							$http.post($stateParams.tenantid+'/app/seaquotation/save',$scope.quotation).success(function(datas) {
								debugger
								  if(datas.success==true){
									  if ($scope.files.length > 0) {

					                        angular.forEach($scope.files, function(files, index) {
					                        	
					                        	
					                            var quotationNo = datas.code;
					                            
					                            var frmData = new FormData();
					                            frmData.append("file", files);
					                            frmData.append("quotationNo", quotationNo);
					                           
					                            $.ajax({
					                                type : "POST",
					                                url : $stateParams.tenantid+"/app/seaquotation/saveuploadfile",
					                                data : frmData,
					                                contentType : false,
					                                processData : false,
					                                success : function(result) {
					                                	
					                                	  logger.logSuccess("File uploaded successfully!");
					                                	  
					                                }
					                            });
					                            
					                        });
					                    	
					                    }
									  
									  logger.logSuccess(datas.message);
				  					  $state.go('app.sea.quotation.list',{tenantid:$stateParams.tenantid});
									  
								        

								  }else{
									  logger.logError(datas.message);
								  }
								}).error(function(datas) {
									logger.logError("Please try again");
								});
				        	 
				         	  }else{
					 				logger.logError("Carrier field is Mandatory!.");

					             }
				         	   
		             }
		        }
		        else{
		        	logger.logError(msg);
		        }
		        }else{
		        	logger.logError("Atleast One Row Required");
		        }
				}
				
				
			}
		 	
			$scope.submitupdate = function() {
				
				var msg = $scope.checkValidation();
				if (!$scope.checkundefined(msg)) {
					logger.logError(msg);
				} else {
					if($scope.quotation.quotationDtl.length>0){
	 var cond=true;var msg="";var i=1,j=1,l=1;
		if($scope.quotation.mode!=5){

       angular.forEach($scope.quotation.quotationFreeDaysDtl, function(files, index) {
       	if(((files.polFreeDays==null || files.polFreeDays=='' || files.polFreeDays==undefined) && 
       			 (files.polFreeDays1==null || files.polFreeDays1=='' || files.polFreeDays1==undefined) )
       			 && ((files.podFreeDays==null || files.podFreeDays=='' || files.podFreeDays==undefined) 
       					 && (files.podFreeDays1==null || files.podFreeDays1=='' || files.podFreeDays1==undefined))){
       		cond=false;
			msg=msg+" Row "+i+" Atleast One Free Days Required! ";

       }
       })
		}
	
				 angular.forEach($scope.quotation.quotationDtl, function(val, index) {
		            	if(val.unit=='1'){
		            		if(val.conType!=null && val.conType!='' &&val.conType!=undefined){
		            			
		            		}else{
								msg=msg+"Freight Charges Row "+j+" Container Type is Required! ";
		            			cond=false;
		            			
		            		}
		            	}j++;
		            })
		             angular.forEach($scope.quotation.addchargeData, function(val, index) {
		            	if(val.uom=='1'){
		            		if(val.conType!=null && val.conType!='' &&val.conType!=undefined){
		            			
		            		}else{
								msg=msg+"Freight Charges Row "+l+" Container Type is Required! ";
		            			cond=false;
		            			
		            		}
		            	}l++;
		            })
		            
       if(cond==true){
       	$scope.quotation.commodityL=$scope.quotation.commodityL;

    	   var commodity='';
    	   angular.forEach($scope.quotation.commodityL, function(item, index) {
           	if(commodity!=null && commodity!=''){
               	commodity=commodity+','+item.id;
             }else{
               	commodity=item.id;
           	}
           	
           })
          $scope.quotation.commodity=commodity;
    		if($scope.quotation.commodity=="")
        		$scope.quotation.commodityL = null;
    	  // if($scope.quotation.commodityL!=[] && $scope.quotation.commodityL!=null && $scope.quotation.commodityL.length!=0){
        	   if($scope.quotation.carrier!='' && $scope.quotation.carrier!=null){

					$http.post($stateParams.tenantid + '/app/seaquotation/update',
							$scope.quotation).success(function(datas) {
						debugger
						if (datas.success == true) {
							
							
							if($scope.files == null || $scope.files == '' || $scope.files != undefined){
								var quotationNo = $scope.quotation.quotationNo;
								/*$http.post($stateParams.tenantid + '/app/seaquotation/uploaddelete',quotationNo).success(*/
									/*	function(data) {*/
											/*if(data==true){*/
												for(var i=0;i<$scope.files.length;i++){
													 var quotationNo = $scope.quotation.quotationNo;
							                            var frmData = new FormData();

														 var file = $scope.files[i];
														 frmData.append("file", file);									 
														 frmData.append("quotationNo", quotationNo);
														 
														 $.ajax({
								                             type : "POST",
								                             url : $stateParams.tenantid+"/app/seaquotation/saveuploadfile",
								                             data : frmData,
								                             contentType : false,
								                             processData : false,
								                             success : function(result) {
								                             }
								                         });
												}	
											/*}*/
											
											
										/*}).error(function(data) {
								});*/
							}
						  
							
							
							
							
							logger.logSuccess("Quotation Updated Successfully");
							  $state.go('app.sea.quotation.list',{tenantid:$stateParams.tenantid});

						} else {
							logger.logError(datas.message);
						}
					}).error(function(data) {
						logger.logError("Please try again");
					});
        	   }else{
       			logger.logError("Carrier field is Mandatory!.");

              }
        	/*   }else{
			logger.logError("Commodity field is Mandatory!.");

       }*/
       }
       else{
       	logger.logError(msg);
       }
					}else{
			        	logger.logError("Atleast One Row Required");
			        }
				}

			}

			/*$scope.cargoTypeList = [
			     {id: '1', text: 'COCO'},
			    {id: '2', text: 'Coir'}
			  ];
			*/ 
			
			/*$scope.carrierList = [
			     {id: '1', text: 'SIMA MARINE (INDIA) PRIVATE LIMITED'},
			    {id: '2', text: 'TCI SEAWAYS'},
			    {id: '3', text: 'THE SHIPPING CORPORATION OF INDIA LIMITED'},
			    {id: '4', text: 'AVANA LOGISTEK LIMITED'},
			    {id: '5', text: 'CONTAINER CORPORATION OF INDIA LIMITED'}
			    
			    
			  ];*/
			$http.get($stateParams.tenantid+'/app/commonUtility/getcarrierList').success(function(datas) {
				debugger
			    $scope.carrierList = datas.commonUtilityBean;	    
			}).error(function(data) {

			});
			$http.get($stateParams.tenantid+'/app/commonUtility/gettransportList').success(function(datas) {
				debugger
	            $scope.transList = datas.lCommonUtilityBean;	    

			}).error(function(data) {

			});
			  $http.post($stateParams.tenantid+'/app/commonUtility/cargotype').success(function(data) {
				  	
					$scope.cargoTypeList=data;
					        		
			});
			
     
		


			
			
			$http.post($stateParams.tenantid+'/app/hr/holiday/branchlist').success(function(data) {
			      	
		      		$scope.branchList=data;
		      		        		
		    	});
			$scope.cancel = function() {
				$state.go('app.sea.quotation.list', {
					tenantid : $stateParams.tenantid
				});
			}
			
			
			
			
			$scope.sendmail = function(quotationHdId){
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
		     }
			
			
			var qkLinkQuon = parseInt($location.search().qkLinkQuon);
			if(qkLinkQuon != '' && qkLinkQuon!=undefined && $.isNumeric(qkLinkQuon)){
					$scope.edit = true;
					$scope.dropdown();
					$http
							.post(
									$stateParams.tenantid
											+ '/app/seaquotation/edit',
											qkLinkQuon)
							.success(
									function(data) {
										debugger
										$scope.quotation = data.lQuotationBean[0];
																			$scope.quotation.consolidated=data.consol;

										if(data.lQuotationBean[0].service != null && data.lQuotationBean[0].service != ''){
											$scope.quotation.service = data.lQuotationBean[0].service
											.toString();
										}
										if(data.lQuotationBean[0].branch != null && data.lQuotationBean[0].branch != ''){

										$scope.quotation.branch = data.lQuotationBean[0].branch
												.toString();
										}
										if(data.lQuotationBean[0].transDeg != null && data.lQuotationBean[0].transDeg != ''){
											$scope.quotation.transDeg = data.lQuotationBean[0].transDeg.toString();
										}
										if(data.lQuotationBean[0].transOrg != null && data.lQuotationBean[0].transOrg != ''){
											$scope.quotation.transOrg = data.lQuotationBean[0].transOrg.toString();
										}
										if(data.lQuotationBean[0].mode != null && data.lQuotationBean[0].mode != ''){

										$scope.quotation.mode = data.lQuotationBean[0].mode
												.toString();
										}
										if(data.lQuotationBean[0].aol != null && data.lQuotationBean[0].aol != ''){

										$scope.quotation.aol = data.lQuotationBean[0].aol
												.toString();
										}
										if(data.lQuotationBean[0].aod != null && data.lQuotationBean[0].aod != ''){

										$scope.quotation.aod = data.lQuotationBean[0].aod
												.toString();
										}
										if(data.lQuotationBean[0].term != null && data.lQuotationBean[0].term != ''){

										$scope.quotation.term = data.lQuotationBean[0].term
												.toString();
										}
										if(data.lQuotationBean[0].origin != null && data.lQuotationBean[0].origin != ''){

										$scope.quotation.origin = data.lQuotationBean[0].origin
												.toString();
										}
										if(data.lQuotationBean[0].destination != null && data.lQuotationBean[0].destination != ''){

										$scope.quotation.destination = data.lQuotationBean[0].destination
												.toString();
										}
										if(data.lQuotationBean[0].customer != null && data.lQuotationBean[0].customer != ''){

										$scope.quotation.customer = data.lQuotationBean[0].customer
												.toString();
										}
										if(data.lQuotationBean[0].shipper != null && data.lQuotationBean[0].shipper != ''){

										$scope.quotation.shipper = data.lQuotationBean[0].shipper
												.toString();
										}
										if(data.lQuotationBean[0].consignee != null && data.lQuotationBean[0].consignee != ''){

										$scope.quotation.consignee = data.lQuotationBean[0].consignee
												.toString();
										}
										if(data.lQuotationBean[0].nominatedBy != null && data.lQuotationBean[0].nominatedBy != ''){

										$scope.quotation.nominatedBy = data.lQuotationBean[0].nominatedBy
												.toString();
										}
										if(data.lQuotationBean[0].vendor != null && data.lQuotationBean[0].vendor != ''){

										$scope.quotation.vendor = data.lQuotationBean[0].vendor
												.toString();
										}
										if(data.lQuotationBean[0].currency != null && data.lQuotationBean[0].currency != ''){

										$scope.quotation.currency = data.lQuotationBean[0].currency
												.toString();
										}
										if(data.lQuotationBean[0].salesType != null && data.lQuotationBean[0].salesType != ''){

										$scope.quotation.salesType = data.lQuotationBean[0].salesType
												.toString();
										}

										for (var i = 0; i < $scope.quotation.quotationDtl.length; i++) {
											$scope.quotation.quotationDtl[i].chargeHeads = $scope.quotation.quotationDtl[i].chargeHeads
													.toString();
											$scope.quotation.quotationDtl[i].unit = $scope.quotation.quotationDtl[i].unit
													.toString();
											$scope.quotation.quotationDtl[i].currency = $scope.quotation.quotationDtl[i].currency
													.toString();
										/*	$scope.quotation.quotationDtl[i].paymentMethod = $scope.quotation.quotationDtl[i].paymentMethod
													.toString();*/
											$scope.quotation.quotationDtl[i].transactionType = $scope.quotation.quotationDtl[i].transactionType
													.toString();
											$scope.quotation.quotationDtl[i].buySell = $scope.quotation.quotationDtl[i].buySell
													.toString();
										}
										$scope.quotation.quotationFreeDaysDtl=data.lQuotationBean[0].quotationFreeDaysDtl;
										//rowCollectionNew=$scope.quotation.quotationFreeDaysDtl;
										 $http.post($stateParams.tenantid+'/api/grldrates/getcommodityList').success(function(data) { 
								              $scope.commodityList = data;
								           	 $scope.compaccList = [];
								           	 var valArr = result.commodity.split(',');
								           	 var i = 0, size = valArr.length;
								           	 for (i; i < size; i++) {
								           	// $("#port").find("option[label=" + valArr[i] + "]").prop("selected", "selected");
								           	 angular.forEach($scope.commodityList, function(value, key) {
								           	 if (valArr[i] == value.id) {
								           	 $scope.compaccList.push(value);
								           	 }
								           	 });
								           	  
								           	 }
								             $scope.quotation.commodityL = $scope.compaccList;

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
									});

				
			}

		});


app
.controller(
		'seaquotationViewCtrl',
		function($scope, $timeout, $stateParams, sharedProperties,
				toaster, $filter, $rootScope, $http, $location, logger,
				$state, ngDialog, $controller, $injector,$window) {
			$scope.quotationTypeList = [];
			$scope.customerDropList = [];
			$scope.consigneeDropList  = [];
			$scope.shipperDropList  = [];
			$scope.nominatedDropList  = [];
			$scope.vendorDropList = [];
			$scope.serviceParnrDropList = [];
			$scope.portList = [];
			$scope.commodityList  =[];
			$scope.userId='';

			$scope.currencyList = [];
			$scope.createQuote = false;
			var QuotHdId = parseInt($location.search().QuotHdId);
	 		 $scope.userId=$('#empId').val();
				$scope.checking=false;

if($scope.userId=='E0001' || $scope.userId=='E0002' || $scope.userId=='E0003'|| $scope.userId=='E0006' || $scope.userId=='E0016'){
	$scope.checking=true;
}
			$scope.quotation={
					service:'1',cargoType:'',transOrg:'',transDeg:'',
					aol:'',
					origin:'',pot:'',fpod:'',
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
					carrier : '',commodityL:'',
					termConditions : '',
					mode : '',
					currency : '',
					term : '',picPoint:'',
					commodity : '',
					consignee : '',
					nominatedBy : '',
					validityDate : '',
					remarks : '',
					vessel :'',
					dimensionName:'',addchargeData:[],
					quotationDtl:[{id:0,chargeHeads:'',unit:'',currency:'',qty:'',rate:'',paymentMethod : '',transactionType : '',buySell : '',note : ''}],
					consolidated:[{tranType:'',credit:'',creditDays:''}]
			}
			$scope.checkundefined = function(value) {
				var invalid = false;
				if (value == undefined || value == 'undefined'
						|| value == null || value == 'null'
						|| value == '') {
					invalid = true;
				}
				return invalid;

			}
			
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
			      /*  $scope.tempfiles = [];
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
			        $scope.quotation.files = $scope.tempfilename;*/
			        
			        
			    	 $http.post($stateParams.tenantid+'/app/seaquotation/deleteFiles', filename).success(function(result) {
				        	
				        	$scope.getEdit();
				               
			            })
		
			    }
			    
			    
			    
			    

			$scope.addslab = function(row, index) {
				$scope.max = Math.max.apply(Math, row.weightslab
						.map(function(item) {
							return item.wid;
						}));
				var len = row.weightslab.length - 1;
				$scope.max = $scope.max + 1;
				var json = {
					wid : $scope.max,
					fromweight : row.weightslab[len].toweight + 1,
					toweight : row.weightslab[len].toweight + 2,
					charges : []
				}
				row.weightslab.push(json);
				len = row.weightslab.length - 1;
				$timeout(function() {
					hideActivePapers(row.id + "" + $scope.max, []);
				}, 1000);
			}
			$scope.addRow = function() {

				$scope.max = Math.max.apply(Math,
						$scope.quotation.quotationDtl
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
			}
			$scope.removeRow = function() {
				$scope.tablerow = [];
				angular.forEach($scope.quotation.quotationDtl,
						function(row, index) {
							var check = row.select;
							
							if (check == undefined || check == "") {
								$scope.tablerow.push(row);
							} else {

							}
						});
				$scope.quotation.quotationDtl = $scope.tablerow;
			};

			$scope.doubleshowTable = function(wtIndex, trIndex) {

				var n = $("#handsondiv" + trIndex + wtIndex).css(
						"display");

				if (n == 'none') {
					$("#handsondiv" + trIndex + wtIndex).css("display",
							"block");
					$scope.addindex = trIndex + "" + wtIndex;
				} else if (n == 'block') {
					$("#handsondiv" + trIndex + wtIndex).css("display",
							"none");

				}

			}

			var today = new Date();
			var dd = today.getDate();
			var mm = today.getMonth() + 1;

			var yyyy = today.getFullYear();
			if (dd < 10) {
				dd = '0' + dd
			}
			if (mm < 10) {
				mm = '0' + mm
			}
			var today = dd + '/' + mm + '/' + yyyy;
			$scope.quotation.dataOfIssues = today;
			$scope.modeList = [];
			$scope.customerDropList=[];
			$scope.getQuotationType = function() {
				var data = {};
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
				// data = {};
				// data["id"] = "2";
				// data["text"] = "SEA";
				// $scope.modeList.push(data);
			}

			$scope.salesTypeList = [];
//			$scope.getSalesType = function() {
//				var data = {};
//				data["id"] = "1";
//				data["text"] = "CROSS TRADE";
//				$scope.salesTypeList.push(data);
//				data = {};
//				data["id"] = "2";
//				data["text"] = "LOCAL";
//				$scope.salesTypeList.push(data);
//				data = {};
//				data["id"] = "3";
//				data["text"] = "NOMINATED";
//				$scope.salesTypeList.push(data);
//
//			}
//			$scope.getSalesType();
			$scope.transactionTypeList = [];

//			$scope.getTransactionType = function() {
//				var data = {};
//				data["id"] = "1";
//				data["text"] = "BUY";
//				$scope.transactionTypeList.push(data);
//				data = {};
//				data["id"] = "2";
//				data["text"] = "SELL";
//				$scope.transactionTypeList.push(data);
//
//			}
//			$scope.getTransactionType();

			$scope.PaymentMethodList = [];
//			$scope.getpaymentMethod = function() {
//				var data = {};
//				data["id"] = "1";
//				data["text"] = "PREAPID TO COLLECT";
//				$scope.PaymentMethodList.push(data);
//				// data = {};
//				// data["id"] = "2";
//				// data["text"] = "SELL";
//				// $scope.PaymentMethodList.push(data);
//
//			}
//			$scope.getpaymentMethod();

			$scope.chargeList = [];
			$scope.dropdown = function() {
				$scope.getQuotationType();
				$http
						.post(
								$stateParams.tenantid
										+ '/app/seaquotation/getServicePartnerList')
						.success(
								function(datas) {
									debugger
									 $scope.customerDropList = datas.customerList;
									 
								}).error(function(data) {

						});
				debugger
				$http.get(
						$stateParams.tenantid
								+ '/app/seaquotation/getiataList')
						.success(function(datas) {
							debugger
							$scope.portList = datas.commonUtilityBean;

						}).error(function(data) {

						});
				$http.get($stateParams.tenantid+'/app/seaquotation/getpicList').success(function(datas) {
					debugger
				    $scope.pickupList = datas.commonUtilityBean;	    

				}).error(function(data) {

				});
				/*$http
						.get(
								$stateParams.tenantid
										+ '/app/seaquotation/getBranch')
						.success(
								function(datas) {
									$scope.branchList = datas.commonUtilityBean;

								}).error(function(data) {

						});*/
/*
				$scope.cargoTypeList = [
				     {id: '1', text: 'COCO'},
				    {id: '2', text: 'Coir'}
				  ];*/
				  $http.post($stateParams.tenantid+'/app/commonUtility/cargotype').success(function(data) {
					  	
						$scope.cargoTypeList=data;
						        		
				});
				/*$scope.carrierList = [
					{id: '1', text: 'SIMA MARINE (INDIA) PRIVATE LIMITED'},
				    {id: '2', text: 'TCI SEAWAYS'},
				    {id: '3', text: 'THE SHIPPING CORPORATION OF INDIA LIMITED'},
				    {id: '4', text: 'AVANA LOGISTEK LIMITED'},
				    {id: '5', text: 'CONTAINER CORPORATION OF INDIA LIMITED'}
				  ];*/
				  
				
				  $http.get($stateParams.tenantid+'/app/commonUtility/getcarrierList').success(function(datas) {
						debugger
					    $scope.carrierList = datas.commonUtilityBean;	    
					}).error(function(data) {

					});
				  $http.get($stateParams.tenantid+'/app/commonUtility/gettransportList').success(function(datas) {
						debugger
			            $scope.transList = datas.lCommonUtilityBean;	    

					}).error(function(data) {

					});
			    $http.post($stateParams.tenantid+'/app/hr/holiday/branchlist').success(function(data) {
        	      	
	          		$scope.branchList=data;
	          		        		
	        	});
				$http
						.get(
								$stateParams.tenantid
										+ '/app/seaquotation/getCurrencyList')
						.success(
								function(datas) {
									$scope.currencylist = angular
											.copy(datas.commonUtilityBean);
								}).error(function(data) {

						});

				/*$http
						.get(
								$stateParams.tenantid
										+ '/app/seaquotation/getServicePartnerType')
						.success(
								function(datas) {
									$scope.servicePartnerTypelist = angular
											.copy(datas.commonUtilityBean);
								}).error(function(data) {

						});*/
				
				var serviceList = [ {
		            id : '1',
		            text : 'EXPORT'
		        }, {
		            id : '2',
		            text : 'IMPORT'
		        }]
				
				$scope.servicePartnerTypelist=serviceList;
				

				$http
						.get(
								$stateParams.tenantid
										+ '/app/seaquotation/getEmployeeList')
						.success(
								function(datas) {
									$scope.employeeList = datas.commonUtilityBean;

								}).error(function(data) {

						});

				
				$http.get($stateParams.tenantid + '/app/airquotation/getSalesList')
				.success(function(datas) {
					$scope.salesTypeList = datas.commonUtilityBean;

				}).error(function(data) {

				});
				
				/*$http.get($stateParams.tenantid + '/app/airquotation/getServiceList')
				.success(function(datas) {
					$scope.servicePartnerTypelist = datas.commonUtilityBean;

				}).error(function(data) {

				});*/
				
				var serviceList = [ {
		            id : '1',
		            text : 'EXPORT'
		        }, {
		            id : '2',
		            text : 'IMPORT'
		        }]
				
				$scope.servicePartnerTypelist=serviceList;
				
				/*$http.get($stateParams.tenantid+'/app/seaquotation/getcommodity').success(function(datas) {
					
				    $scope.commodityList = datas.commonUtilityBean;	    

				}).error(function(data) {

				});*/
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
				
				$http
						.get(
								$stateParams.tenantid
										+ '/app/seaquotation/getChargeHeads')
						.success(
								function(datas) {
									$scope.chargeHeadList = datas.commonUtilityBean;

								}).error(function(data) {

						});

				$http.get(
						$stateParams.tenantid
								+ '/app/seaquotation/getTerms')
						.success(function(datas) {
							$scope.TermList = datas.commonUtilityBean;

						}).error(function(data) {

						});

				$http.get(
						$stateParams.tenantid
								+ '/app/seaquotation/getUnitList')
						.success(function(datas) {
							$scope.UnitList = datas.commonUtilityBean;

						}).error(function(data) {

						});

			}
			$scope.editdata = function(quotation) {

				$scope.getQuotationType();
				$http
						.post(
								$stateParams.tenantid
										+ '/app/seaquotation/getServicePartnerList')
						.success(
								function(datas) {
									debugger
									 $scope.customerDropList = datas.customerList;
									 $scope.consigneeDropList = datas.consigneeList;
									 $scope.shipperDropList = datas.shipperList;
									 $scope.nominatedDropList = datas.nominatedList;
									 $scope.vendorDropList = datas.vendorList;
									// $scope.serviceParnrDropList=datas.serviceParnrList;

								}).error(function(data) {

						});
			}

			
			

			$scope.changecolor = function(id) {
				$('#' + id + ' .selectivityId').find('input').css(
						"border-color", "red");
				;

			}
			$scope.clearcolor = function(id) {
				$('#' + id + ' .selectivityId').find('input').css(
						"border-color", "#e8dddd");
				;

			}

			$scope.checkValidation = function() {

			    var alertmsg = "<ui><h4>Please fill the required fields</h4>";
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
			    if ($scope.checkundefined($scope.quotation.service)) {
			        msg = msg + "<li>Service:Field is required.</li>";         
			        $scope.changecolor('service');
			    }else{
			    	$scope.clearcolor('service');
			    }
			    if ($scope.checkundefined($scope.quotation.aol)) {
			        msg = msg + "<li>POL:Field is required.</li>";         
			        $scope.changecolor('aol');
			    }else{
			    	$scope.clearcolor('aol');
			    }
			    if ($scope.checkundefined($scope.quotation.quotationDate)) {
			        msg = msg + "<li>QuotationDate:Field is required.</li>";         
			        $scope.changecolor('quotationDate');
			    }else{
			    	$scope.clearcolor('quotationDate');
			    }
			    if ($scope.checkundefined($scope.quotation.branch)) {
			        msg = msg + "<li>Branch:Field is required.</li>";         
			        $scope.changecolor('branch');
			    }else{
			    	$scope.clearcolor('branch');
			    }
			    if ($scope.checkundefined($scope.quotation.aod)) {
			        msg = msg + "<li>POD:Field is required.</li>";         
			        $scope.changecolor('aod');
			    }else{
			    	$scope.clearcolor('aod');
			    }
			    if ($scope.checkundefined($scope.quotation.salesType)) {
			        msg = msg + "<li>SalesType:Field is required.</li>";         
			        $scope.changecolor('salesType');
			    }else{
			    	$scope.clearcolor('salesType');
			    }
			    if ($scope.checkundefined($scope.quotation.cargoType)) {
			        msg = msg + "<li>Cargo Type:Field is required.</li>";         
			        $scope.changecolor('cargoType');
			    }else{
			    	$scope.clearcolor('cargoType');
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
			    }
			    
			    if($scope.quotation.mode!=5){
			    if ($scope.checkundefined($scope.quotation.commodityL)) {
			        msg = msg + "<li>Commodity:Field is required.</li>";         
			        $scope.changecolor('Commodity');
			    }else{
			    	$scope.clearcolor('Commodity');
			    }
			}
			  	    angular.forEach($scope.quotation.quotationDtl, function(chargesDetail, index) {     
			        if ($scope.checkundefined(chargesDetail.chargeHeads)) {
			            msg = msg + "<li>Row :" + (index + 1) + "# Charge Heads :Field is required.</li>";
			            $scope.changecolor('chargeHeads'+index);
			        }else{
			        	$scope.clearcolor('chargeHeads'+index);
			        }
			        if ($scope.checkundefined(chargesDetail.unit)) {
			            msg = msg + "<li>Row :" + (index + 1) + "# Unit :Field is required.</li>";
			            $scope.changecolor('unit'+index);
			        }else{
			        	$scope.clearcolor('unit'+index);
			        }
			        if ($scope.checkundefined(chargesDetail.qty)) {
			            msg = msg + "<li>Row :" + (index + 1) + "# Quantity :Field is required.</li>";
			            $scope.changecolor('qty'+index);
			            $('#qty'+index).find('input').css("border-color", "red");

			        }  else{
			        	$('#qty'+index).find('input').css("border-color", "#e8dddd");
			        }
			        if ($scope.checkundefined(chargesDetail.rate)) {
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
			            msg = msg + "<li>Row :" + (index + 1) + "# Buy/Sell Party:Field is required.</li>";
			        }  
			        
			        
			        
			    });
			    alertmsg = alertmsg + msg + "</ui>";
			    if ($scope.checkundefined(msg)) {
			        return '';
			    } else {
			        return alertmsg;
			    }

			}
			
			
			$scope.checkundefined1 = function(value) {
		        var invalid = false;
		        if (value == undefined || value == 'undefined' || value == null || value == 'null' || value == '') {
		            invalid = true;
		        }
		        return invalid;

		    }

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
		             template : 'views/air/seaQuotation/quotationRejectRemarks',
		             controller : $controller('quotationRejectCtrl', {
		                 $stateParams :$stateParams,
		                 $scope : $scope, 
		                 $rootScope :$rootScope, 
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
		 	
		 	//Approval
			$scope.approve = function(quotationNo,cosolidated) {	
				 $scope.quotationNew = {
						 quotationNo : '',
			        		approveRemarks : '' ,credit:'',consolidated:[{tranType:'',credit:'',creditDays:''}]
			        };
				 $scope.quotationNew.consolidated=cosolidated; 
				    $scope.quotationNew.quotationNo =  quotationNo;
		             $scope.quotationNew.approveRemarks =  '';
		         ngDialog.open({
		             scope : $scope,
		             template : 'views/air/seaQuotation/quotationApprovalRemarks',
		             controller : $controller('quotationApprovalCtrl', {
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
			
			$scope.edit = false;
			$scope.view = function() {
			if (QuotHdId != '' && QuotHdId != undefined && $.isNumeric(QuotHdId)) {
				$scope.edit = true;
				$scope.dropdown();
				debugger

				$http
						.post(
								$stateParams.tenantid
										+ '/app/seaquotation/view',
								QuotHdId)
						.success(
								function(data) {
									console.log(data);
									debugger
									$scope.quotation = data.lQuotationBean[0];
									$scope.quotation.consolidated=data.consol;
									$scope.mode=data.lQuotationBean[0].mode;
									$scope.quotation.addchargeData  = data.lQuotationBean[0].addchargeData ;

									$scope.quotation.opr = data.lQuotationBean[0].opr;
									$scope.files=[];
									if(data.lQuotationBean[0].commodity != null && data.lQuotationBean[0].commodity != ''){
										$scope.quotation.commodity = data.lQuotationBean[0].commodity.toString();
									}
									if(data.lQuotationBean[0].transDeg != null && data.lQuotationBean[0].transDeg != ''){
										$scope.quotation.transDeg = data.lQuotationBean[0].transDeg.toString();
									}
									if(data.lQuotationBean[0].transOrg != null && data.lQuotationBean[0].transOrg != ''){
										$scope.quotation.transOrg = data.lQuotationBean[0].transOrg.toString();
									}
									if(data.lQuotationBean[0].service != null && data.lQuotationBean[0].service != '' && data.lQuotationBean[0].service == 1){
										$scope.quotation.service = "EXPORT";
									}
									else
									
										{
										$scope.quotation.service = "IMPORT";

										}
										
									
									if(data.lQuotationBean[0].branch != null && data.lQuotationBean[0].branch != ''){

									$scope.quotation.branch = data.lQuotationBean[0].branch
											.toString();
									}
									if(data.lQuotationBean[0].mode != null && data.lQuotationBean[0].mode != ''){
										 
										    if(data.lQuotationBean[0].mode==1){
												$scope.quotation.mode = "SEA COASTAL";
									    }else  if(data.lQuotationBean[0].mode==2){
												$scope.quotation.mode = "SEA FOREIGN";
									    }else  if(data.lQuotationBean[0].mode==3){
												$scope.quotation.mode = "TRUCK";
									    }else  if(data.lQuotationBean[0].mode==4){
												$scope.quotation.mode = "LINER";
									    }else  if(data.lQuotationBean[0].mode==5){
												$scope.quotation.mode = "FORWARDING";
									    }
									}
									if(data.lQuotationBean[0].aol != null && data.lQuotationBean[0].aol != ''){

									$scope.quotation.aol = data.lQuotationBean[0].aol
											.toString();
									}
									if(data.lQuotationBean[0].aod != null && data.lQuotationBean[0].aod != ''){

									$scope.quotation.aod = data.lQuotationBean[0].aod
											.toString();
									}
									if(data.lQuotationBean[0].term != null && data.lQuotationBean[0].term != ''){

									$scope.quotation.term = data.lQuotationBean[0].term
											.toString();
									}if(data.lQuotationBean[0].potName != null && data.lQuotationBean[0].potName != ''){

										$scope.quotation.term = data.lQuotationBean[0].potName
												.toString();
										}
									if(data.lQuotationBean[0].fpodName != null && data.lQuotationBean[0].fpodName != ''){

										$scope.quotation.term = data.lQuotationBean[0].fpodName
												.toString();
										}
									if(data.lQuotationBean[0].origin != null && data.lQuotationBean[0].origin != ''){

									$scope.quotation.origin = data.lQuotationBean[0].origin
											.toString();
									}
									if(data.lQuotationBean[0].destination != null && data.lQuotationBean[0].destination != ''){

									$scope.quotation.destination = data.lQuotationBean[0].destination
											.toString();
									}
									if(data.lQuotationBean[0].customer != null && data.lQuotationBean[0].customer != ''){

									$scope.quotation.customer = data.lQuotationBean[0].customer
											.toString();
									}
									if(data.lQuotationBean[0].shipper != null && data.lQuotationBean[0].shipper != ''){

									$scope.quotation.shipper = data.lQuotationBean[0].shipper
											.toString();
									}
									if(data.lQuotationBean[0].consignee != null && data.lQuotationBean[0].consignee != ''){

									$scope.quotation.consignee = data.lQuotationBean[0].consignee
											.toString();
									}
									if(data.lQuotationBean[0].nominatedBy != null && data.lQuotationBean[0].nominatedBy != ''){

									$scope.quotation.nominatedBy = data.lQuotationBean[0].nominatedBy
											.toString();
									}
									if(data.lQuotationBean[0].vendor != null && data.lQuotationBean[0].vendor != ''){

									$scope.quotation.vendor = data.lQuotationBean[0].vendor
											.toString();
									}
									if(data.lQuotationBean[0].currency != null && data.lQuotationBean[0].currency != ''){

									$scope.quotation.currency = data.lQuotationBean[0].currency
											.toString();
									}
									if(data.lQuotationBean[0].cargoType != null && data.lQuotationBean[0].cargoType != ''){

										$scope.quotation.cargoType = data.lQuotationBean[0].cargoType
												.toString();
										}
									if(data.lQuotationBean[0].salesType != null && data.lQuotationBean[0].salesType != ''){

									$scope.quotation.salesType = data.lQuotationBean[0].salesType
											.toString();
									}if(data.lQuotationBean[0].rier != null && data.lQuotationBean[0].rier != ''){
                                           if($scope.quotation.rier=='1'){
                                        	   $scope.quotation.rier='SIMA MARINE (INDIA) PRIVATE LIMITED';
                               			    
                                           }else if($scope.quotation.rier=='2'){
                                        	   $scope.quotation.rier='TCI SEAWAYS';
                                           }
										/*$scope.quotation.rier = data.lQuotationBean[0].rier
												.toString();*/
										}

									for (var i = 0; i < $scope.quotation.quotationDtl.length; i++) {
										$scope.quotation.quotationDtl[i].chargeHeads = $scope.quotation.quotationDtl[i].chargeHeads
												.toString();
										$scope.quotation.quotationDtl[i].unit = $scope.quotation.quotationDtl[i].unit
												.toString();
										$scope.quotation.quotationDtl[i].currency = $scope.quotation.quotationDtl[i].currency
												.toString();
										
										if( $scope.quotation.quotationDtl[i].paymentMethod != null &&  $scope.quotation.quotationDtl[i].paymentMethod != ''){
										
										$scope.quotation.quotationDtl[i].paymentMethod = $scope.quotation.quotationDtl[i].paymentMethod.toString();
										
										}
										
										if( $scope.quotation.quotationDtl[i].transactionType != null &&  $scope.quotation.quotationDtl[i].transactionType != ''){
										
										$scope.quotation.quotationDtl[i].transactionType = $scope.quotation.quotationDtl[i].transactionType.toString();
										
										}
												
										$scope.quotation.quotationDtl[i].buySell = $scope.quotation.quotationDtl[i].buySell
												.toString();
									}
									 angular.forEach(data.filel, function(value, index) {
				                          	
										  var dummy = value.fileName;
										  
										  
										  $scope.files.push(dummy);
										 
									  });
									 
									  var dum = []; 
										for (var i = 0; i < $scope.files.length; i++) {
											debugger
											var subString = "/"; 
											 if($scope.files[i].indexOf(subString) !== -1){
												                        
													if ($scope.files[i].indexOf(subString) !== -1) {                            
														var val = $scope.files[i].split("/");                            
														//var	value = val[val.length - 1];  
														
														var value ={ 
																
																filename : val[val.length - 1],
												                filepath : '',
												                quotation : ''
															   }
														
														dum.push(value);                        
														} else {                            
															var val = $scope.files[i].split("\\");                           
															//var value = val[val.length - 1]; 
															var value ={ 
																	
																	filename : val[val.length - 1],
													                filepath : '',
													                quotation : ''
																   }
															dum.push(value);    
															
															}   
											 }else{
												                        
													if ($scope.files[i].indexOf(subString) !== -1) {                            
														var val = $scope.files[i].split("/");                            
														var value ={ 
														
														filename : val[0],
										                filepath : '',
										                quotation : ''
													   }
														
														dum.push(value);                        
														} else {                            
															var val = $scope.files[i].split("\\");                           
															var value ={ 
																	
																	filename : val[0],
													                filepath : '',
													                quotation : ''
																   }                            
															dum.push(value); 
															
															}   
											 }
											 
											 
											                 
											}
									$scope.quotation.files=dum;
									$scope.quotation.quotationFreeDaysDtl=data.lQuotationBean[0].quotationFreeDaysDtl;

									 /*bean.push($scope.quotation.files);*/

								});
			    }
			}
			
		 	$scope.view();
		 	
		 	
		
			
		 	
		 	
		 	
		 	
			$scope.submitupdate = function() {
				
				var msg = $scope.checkValidation();
				if (!$scope.checkundefined(msg)) {
					logger.logError(msg);
				} else {
					
					if($scope.quotation.quotationDtl.length>0){
						var cond=true;var msg="";var j=0,l=1;
			            angular.forEach($scope.quotation.quotationFreeDaysDtl, function(files, index) {
			            	if(((files.polFreeDays==null || files.polFreeDays=='' || files.polFreeDays==undefined) && 
			            			 (files.polFreeDays1==null || files.polFreeDays1=='' || files.polFreeDays1==undefined) )
			            			 && ((files.podFreeDays==null || files.podFreeDays=='' || files.podFreeDays==undefined) 
			            					 && (files.podFreeDays1==null || files.podFreeDays1=='' || files.podFreeDays1==undefined))){
			            		msg=msg+" Row "+j+" Atleast One Free Days Required! ";
			            		cond=false;
				            }
							})
						}
					var i=0;
								 angular.forEach($scope.quotation.quotationDtl, function(val, index) {
						            	if(val.unit=='1'){
						            		if(val.conType!=null && val.conType!='' &&val.conType!=undefined){
						            			
						            		}else{
												msg=msg+"Freight Charges Row "+i+" Container Type is Required! ";
						            			cond=false;
						            			
						            		}
						            	}i++;
						            })
						             angular.forEach($scope.quotation.addchargeData, function(val, index) {
						            	if(val.uom=='1'){
						            		if(val.conType!=null && val.conType!='' &&val.conType!=undefined){
						            			
						            		}else{
												msg=msg+"Local Charges Row "+l+" Container Type is Required! ";
						            			cond=false;
						            			
						            		}
						            	}i++;
						            })
			            if(cond==true){
			            	$scope.quotation.commodityL=$scope.quotation.commodityL;

						var commodity='';
		                angular.forEach($scope.quotation.commodityL, function(item, index) {
		                	if(commodity!=null && commodity!=''){
		                    	commodity=commodity+','+item.id;
                          }else{
		                    	commodity=item.id;
		                	}
		                	
		                })
		               $scope.quotation.commodity=commodity;
		               // if($scope.quotation.commodityL!=[] && $scope.quotation.commodityL!=null){
		                if($scope.quotation.commodity=="")
		                $scope.quotation.commodityL =null;
		                	if($scope.quotation.carrier!='' && $scope.quotation.carrier!=null){
					$http.post($stateParams.tenantid + '/app/seaquotation/update',
							$scope.quotation).success(function(datas) {
						debugger
						if (datas.success == true) {
							
							
							if($scope.files == null || $scope.files == '' || $scope.files != undefined){
								var quotationNo = $scope.quotation.quotationNo;
								/*$http.post($stateParams.tenantid + '/app/seaquotation/uploaddelete',quotationNo).success(*/
									/*	function(data) {*/
											/*if(data==true){*/
												for(var i=0;i<$scope.files.length;i++){
													 var quotationNo = $scope.quotation.quotationNo;
							                            var frmData = new FormData();

														 var file = $scope.files[i];
														 frmData.append("file", file);									 
														 frmData.append("quotationNo", quotationNo);
														 
														 $.ajax({
								                             type : "POST",
								                             url : $stateParams.tenantid+"/app/seaquotation/saveuploadfile",
								                             data : frmData,
								                             contentType : false,
								                             processData : false,
								                             success : function(result) {
								                             }
								                         });
												}	
											/*}*/
											
											
										/*}).error(function(data) {
								});*/
							}
						  
							
							
							
							
							logger.logSuccess("Quotation Updated Successfully");
							  $state.go('app.sea.quotation.list',{tenantid:$stateParams.tenantid});

						} else {
							logger.logError(datas.message);
						}
					}).error(function(data) {
						logger.logError("Please try again");
					}); 
					}else{
		 				logger.logError("Carrier field is Mandatory!.");

		             }
	         	  /* }else{
	 				logger.logError("Commodity field is Mandatory!.");

	             }*/
			            }
			            else{
			            	logger.logError(msg);
			            }
					}
				}

			
			$scope.cancel = function() {
				$state.go('app.sea.quotation.list', {
					tenantid : $stateParams.tenantid
				});
			}
			
			
			
			
			$scope.sendmail = function(quotationHdId){
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
		     }
			
			
			var qkLinkQuon = parseInt($location.search().qkLinkQuon);
			if(qkLinkQuon != '' && qkLinkQuon!=undefined && $.isNumeric(qkLinkQuon)){
					//$scope.edit = true;
					$scope.dropdown();
					$http
							.post(
									$stateParams.tenantid
											+ '/app/seaquotation/view',
											qkLinkQuon)
							.success(
									function(data) {
										debugger
										$scope.quotation = data.lQuotationBean[0];
										
																			$scope.quotation.consolidated=data.consol;

/*										   angular.forEach($scope.quotation, function(value, key) {

							                    if (value.lQuotationBean[0].service == 1) {

							                        value.lQuotationBean[0].service = 'EXPORT'

							                    } else {
							                        value.lQuotationBean[0].service = 'IMPORT'

							                    }

							                });	*/			
										
										
										if(data.lQuotationBean[0].service != null && data.lQuotationBean[0].service != ''){
											$scope.quotation.service = "text";
										}
										if(data.lQuotationBean[0].transDeg != null && data.lQuotationBean[0].transDeg != ''){
											$scope.quotation.transDeg = data.lQuotationBean[0].transDeg.toString();
										}
										if(data.lQuotationBean[0].transOrg != null && data.lQuotationBean[0].transOrg != ''){
											$scope.quotation.transOrg = data.lQuotationBean[0].transOrg.toString();
										}
										if(data.lQuotationBean[0].branch != null && data.lQuotationBean[0].branch != ''){

										$scope.quotation.branch = data.lQuotationBean[0].branch
												.toString();
										}
										if(data.lQuotationBean[0].mode != null && data.lQuotationBean[0].mode != '' && data.lQuotationBean[0].mode == '1'){

										$scope.quotation.mode = "Sea";

										}
										if(data.lQuotationBean[0].aol != null && data.lQuotationBean[0].aol != ''){

										$scope.quotation.aol = data.lQuotationBean[0].aol
												.toString();
										}
										if(data.lQuotationBean[0].aod != null && data.lQuotationBean[0].aod != ''){

										$scope.quotation.aod = data.lQuotationBean[0].aod
												.toString();
										}
										if(data.lQuotationBean[0].term != null && data.lQuotationBean[0].term != ''){

										$scope.quotation.term = data.lQuotationBean[0].term
												.toString();
										}
										if(data.lQuotationBean[0].origin != null && data.lQuotationBean[0].origin != ''){

										$scope.quotation.origin = data.lQuotationBean[0].origin
												.toString();
										}
										if(data.lQuotationBean[0].destination != null && data.lQuotationBean[0].destination != ''){

										$scope.quotation.destination = data.lQuotationBean[0].destination
												.toString();
										}
										if(data.lQuotationBean[0].customer != null && data.lQuotationBean[0].customer != ''){

										$scope.quotation.customer = data.lQuotationBean[0].customer
												.toString();
										}
										if(data.lQuotationBean[0].shipper != null && data.lQuotationBean[0].shipper != ''){

										$scope.quotation.shipper = data.lQuotationBean[0].shipper
												.toString();
										}
										if(data.lQuotationBean[0].consignee != null && data.lQuotationBean[0].consignee != ''){

										$scope.quotation.consignee = data.lQuotationBean[0].consignee
												.toString();
										}
										if(data.lQuotationBean[0].nominatedBy != null && data.lQuotationBean[0].nominatedBy != ''){

										$scope.quotation.nominatedBy = data.lQuotationBean[0].nominatedBy
												.toString();
										}
										if(data.lQuotationBean[0].vendor != null && data.lQuotationBean[0].vendor != ''){

										$scope.quotation.vendor = data.lQuotationBean[0].vendor
												.toString();
										}
										if(data.lQuotationBean[0].currency != null && data.lQuotationBean[0].currency != ''){

										$scope.quotation.currency = data.lQuotationBean[0].currency
												.toString();
										}
										if(data.lQuotationBean[0].salesType != null && data.lQuotationBean[0].salesType != ''){

										$scope.quotation.salesType = data.lQuotationBean[0].salesType
												.toString();
										}

										for (var i = 0; i < $scope.quotation.quotationDtl.length; i++) {
											$scope.quotation.quotationDtl[i].chargeHeads = $scope.quotation.quotationDtl[i].chargeHeads
													.toString();
											$scope.quotation.quotationDtl[i].unit = $scope.quotation.quotationDtl[i].unit
													.toString();
											$scope.quotation.quotationDtl[i].currency = $scope.quotation.quotationDtl[i].currency
													.toString();
											$scope.quotation.quotationDtl[i].paymentMethod = $scope.quotation.quotationDtl[i].paymentMethod
													.toString();
											$scope.quotation.quotationDtl[i].transactionType = $scope.quotation.quotationDtl[i].transactionType
													.toString();
											$scope.quotation.quotationDtl[i].buySell = $scope.quotation.quotationDtl[i].buySell
													.toString();
										}
										
										
										

									});

				
			}

		});



app.controller('quotationRejectCtrl', function($stateParams , $scope , $rootScope, $http, $location,logger, $state, $window,ngDialog) {
    debugger;
     
        
        $scope.quotationNew.quotationNo= $scope.quotationNew.quotationNo;  
        $scope.quotationNew.rejectRemarks= '';
 
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
        
        $scope.rejectQuote = function(quotationNew){

        $http.post($stateParams.tenantid+'/app/seaquotation/rejectQuotation',quotationNew).success(function(datas) {
			if(datas.success){
				 ngDialog.close();    
		    logger.logSuccess("Rejected Successfully");
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
app.controller('quotationApprovalCtrl', function($stateParams , $scope , $http, $location,logger, $state, $window,ngDialog) {
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
        
        $scope.approveQuote = function(quotationNew){

        	//approve
  	
        		$http.post($stateParams.tenantid+'/app/seaquotation/approveQuotation',quotationNew).success(function(datas) {
        			if(datas.success){
        		    logger.logSuccess("Approved Successfully!!!");
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
