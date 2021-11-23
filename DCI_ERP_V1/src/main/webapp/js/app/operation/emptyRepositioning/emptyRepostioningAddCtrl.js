'use strict';
app.controller('emptyRepositioningAddCtrl', function($scope, $timeout, $stateParams,sharedProperties,toaster,
		$filter, $rootScope, $http, $location, logger, $state, ngDialog,$controller,$injector) {
	$scope.emptyrepositionTypeList=[];
	$scope.customerDropList = [];
	$scope.consigneeDropList  = [];
	$scope.shipmentList  = [];
	$scope.nominatedDropList  = [];
	$scope.vendorDropList = [];
	$scope.serviceParnrDropList = [];
	$scope.portList=[];
	$scope.currencyList=[];
	$scope.nlegList=[];
	$scope.createQuote=false;
	$scope.conList=[];
	$scope.conListEdit =[];
	$scope.edit = false;
	$scope.modeList=[];

	
	var bookingDate = $stateParams.bookingDate;
	var mloCode = $stateParams.mloCode;
	var lolId = $stateParams.lolId;
	var lodId = $stateParams.lodId;
	var bookingId= parseInt($stateParams.bookingId);

	
	
	$scope.emptyreposition={
			service:'',
			aol:'',
			origin:'',
			customer:'',
			salesPerson:'',
			vendor : '', 
			attention : '',
			emptyrepositionDate : '',
			branch : '',
			aod : '',
			destination : '',
			shipper : '',
			doType : 'COC',
			salesType : '',
			carrier : '',
			termConditions : '',
			mode : '',
			currency : '',
			term : '',
			commodity : '',
			consignee : '',
			nominatedBy : '',
			validityDate : '',
			remarks : '',
			vessel :'',
			nleg :2,
			dimensionName:'',
			transitDtl:[{id:0,conType:'',quantity:'',depot:'',allocDate:'',leg:'Last'}],
			depotDetail:[]
			
	}
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
		    data["text"] = "FORWARDING";
		     $scope.modeList.push(data);
		// data = {};
		// data["id"] = "2";
		// data["text"] = "SEA";
		// $scope.modeList.push(data);
	}
	
		$scope.getQuotationType();
	$scope.tmpDepotDetail ={id:0,containerNo:'',sealNo:'',releaseDate:'',outBoundMode:'',returnDate:'',returnDepot : '',inBoundMode : '',emptyReturn : ''};


	
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

	$scope.emptyreposition.emptyrepositionDate = dd + '/' + mm + '/'
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
	$scope.emptyreposition.emptyrepositionDate = today;
	
	 $scope.empId = $('#empId').val();
	 
	 $http.post($stateParams.tenantid+'/app/commonUtility/getPastDateUserRights').success(function(data) {
			$scope.pastValidrights=data.pastUserRights;
	 });
	 
	$scope.erCode=$location.search().erCode;
	$scope.edit = false;
	if($scope.erCode != '' && $scope.erCode!=undefined){
		$scope.edit=true;
		$http.post($stateParams.tenantid+'/app/emptyRepositioning/edit',$scope.erCode).success(function(datas) {
			$scope.conListEdit = datas.containerListEdit;
		    $scope.emptyreposition=datas.seaQuotationBean; 
			$scope.emptyreposition.depotDetail=datas.depot;
			$scope.emptyreposition.transitDtl=datas.lQuotationBean;
			if(datas.seaQuotationBean.chargeable=='true'){
	             document.getElementById("isChargable").checked = true;

				} else{

			     document.getElementById("isChargable").checked = false;
				}
				if(datas.seaQuotationBean.transit1=='true'){
	             document.getElementById("isTransit").checked = true;

				} else{

			     document.getElementById("isTransit").checked = false;
				}
			$scope.edit=true;
		
		}).error(function(datas) {

		});
		
		
	}
	$scope.addCredRow1 = function() {
	}
	$scope.selectallRec = function(selection) {
		angular.forEach($scope.emptyreposition.depotDetail, function(
				value, key) {
			debugger;
			if (selection)
				value.select = true;
			else {
				value.select = false;
			}
		});
	}
	$scope.search=function(emptyreposition){
		$http.post($stateParams.tenantid+'/app/emptyRepositioning/getContainerList',emptyreposition).success(function(datas) {
			if(datas.containerListEdit.length>0){
			$scope.emptyreposition.depotDetail=datas.containerListEdit;
			}else{
				logger.logError("No Results Found!..");
			}
		})
	}
	  $scope.getdropdown = function() {
	  
	$http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(datas) {
			 // $scope.portList=datas.getportlist;
			  $scope.customerDropList=datas.getcustomerlist;
			   $scope.agentList=datas.agentList;
			   $scope.conTypeList=datas.getcontypelist;
			//   $scope.conList=datas.getcontainer;
			   
		
		}).error(function(datas) {

		});
	
	
	//container No. dropdown
	  $scope.conList =[];
	$http.post($stateParams.tenantid+'/app/emptyRepositioning/containerNo').success(function(data) {

		if($scope.edit==false){
			 $scope.conList=data;	
		}
	     
});
	
	
	//portList
	$http.get($stateParams.tenantid+'/app/seaquotation/getiataList').success(function(datas) {
		debugger
	    $scope.portList = datas.commonUtilityBean;	    

	}).error(function(data) {

	});
	//container type dropdown
	 $scope.conTypeList=[];
	$http.post($stateParams.tenantid+'/app/emptyRepositioning/containerType').success(function(data) {
		  $scope.conTypeList=data;
	        		
});
	
	//vessl
	
	$http.get($stateParams.tenantid+ '/app/commonUtility/getVesselList').success(function(data) {
		$scope.vesselList = data;
//		$scope.voyageList = data.voyageList;
	});
	 $scope.$watch('emptyreposition.vessel', function(newValue, oldValue) {
	      if(newValue!=null && newValue!=undefined && newValue != ''){
	    	  $http.post($stateParams.tenantid+ '/app/commonUtility/getVoyageListByVessel',newValue).success(function(data) {
					$scope.voyageList = data;
	    	  });
	      }
	     
	    });
	
	 $scope.$watch('emptyreposition.voyage', function(newValue, oldValue) {
	      if(newValue!=null && newValue!=undefined && newValue != ''){
	    	    $http.get($stateParams.tenantid+'/app/freightmanifest/getPortByVoyage?voyage='+newValue).success(function(datas) {
					$scope.portList = datas;
	    	  });
	      }
	     
	    });
	
	 $scope.$watch('row.vessel', function(newValue, oldValue) {
	      if(newValue!=null && newValue!=undefined && newValue != ''){
	    	  $http.post($stateParams.tenantid+ '/app/commonUtility/getVoyageListByVessel',newValue).success(function(data) {
					$scope.voyageList = data;
	    	  });
	      }
	     
	    });
	
	 //vessel
	
	/*$http.get($stateParams.tenantid+ '/app/commonUtility/getVesselList').success(function(data) {
	     $scope.vesselList=data;
	});*/
	
	$http.post($stateParams.tenantid+'/app/commonUtility/getPortByEmpAgn').success(function(data) {
	  	
		$scope.depotList=data;
		//$scope.polList=data;
		        		
});
	  }
	   
	  $scope.getdropdown();
 

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

		$scope.max = Math.max.apply(Math, $scope.emptyreposition.transitDtl
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

		$scope.emptyreposition.transitDtl.push(chargedata);
		var len = $scope.emptyreposition.transitDtl.length - 1;
		$timeout(function() {
			hideActivePapers($scope.max + "0", []);
		}, 1000);
		
		/*$scope.hide=true;*/
		
}	
	$scope.removeRow = function() {
		$scope.tablerow = [];
		for (var index = 0 ; index < 1; index++) {
		angular.forEach($scope.emptyreposition.transitDtl,function(row, index) {
					var check = row.select;
					
					if (check == undefined || check == "" ) {
						$scope.tablerow.push(row);
					} else if(index > 0){
						$scope.emptyreposition.transitDtl = $scope.tablerow;

					}
				});
		}
	};
	
	
	$scope.addRow1 = function() {

		$scope.max = Math.max.apply(Math, $scope.emptyreposition.depotDetail
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
	
		
		$scope.emptyreposition.depotDetail.push(chargedata);
		var len = $scope.emptyreposition.depotDetail.length - 1;
		$timeout(function() {
			hideActivePapers($scope.max + "0", []);
		}, 1000);
		
		/*$scope.hide=true;*/
		
}
	
	$scope.removeRow1 = function() {
		var count =0;
							var tmpDelList = [];
							for (var i = $scope.emptyreposition.depotDetail.length - 1; i >= 0; i--) {
								if ($scope.emptyreposition.depotDetail[i].select == true) {
									count++;
									tmpDelList.push($scope.emptyreposition.depotDetail[i]);
									$scope.emptyreposition.depotDetail.splice(i, 1);
								}
							}
							
					
	}
		
	
	/*$scope.deleteIds = [];
		$scope.removeRow = function() {
			var len = $scope.emptyreposition.emptyrepositionDtl.length;
			for (var index = len - 1; index < len; index--) {
				if ($scope.emptyreposition.emptyrepositionDtl[index].select == true) {
					if ($scope.emptyreposition.emptyrepositionDtl[index].id != null
							&& $scope.emptyreposition.emptyrepositionDtl[index].id > 0) {
						$scope.deleteIds.push($scope.emptyreposition.emptyrepositionDtl[index].id);
					}
					$scope.emptyreposition.emptyrepositionDtl.splice(index, 1);
				}
			}
			$scope.addRow();
			var emptyrepositionDtl = {
					id:0,chargeHeads:'',unit:'',currency:'',qty:'',rate:'',paymentMethod : '',transactionType : '',buySell : '',note : ''
		} 
			$scope.emptyreposition.emptyrepositionDtl.push(emptyrepositionDtl);
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
	
	/*$scope.customerDropList = [
		  { id: 'COK', text: 'Mr. Nice' },fv
		  { id: '222', text: 'Narco' }
		 
];*/
	
	
	$scope.dropoffList=[
		 
		  { id: 'ROAD', text: 'ROAD' },
		  { id: 'RAIL', text: 'RAIL' }
		
	]
	
	
	
	$scope.nlegList=[
		 
		  { id: 2, text: '2' },
		  { id: 3, text: '3' }
		
	]
	
	
	
	
	
	$scope.legList=[
		 
		  { id: 'First', text: 'First' },
		  { id: 'second', text: 'second' },
		  { id: 'Third', text: 'Third' },
		  { id: 'Last', text: 'Last' }
		
	]

	

	 $scope.$watch('[emptyreposition.exDate]', function(newValue,oldValue) {
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
				
				var dayDiff = moment(today, "DD/MM/YYYY").diff(moment($scope.emptyreposition.exDate, "DD/MM/YYYY"),'day')
		        if ( dayDiff < 0 ) { 
		        	$scope.emptyreposition.exDate="";
		        	logger.logError("ER Date Cannot Be Greater Than the Current Date..!!");
		        }else if(dayDiff > 3){
		        	 if($scope.pastValidrights == false){
		        	$scope.emptyreposition.exDate="";
		        	logger.logError("ER Date should not be lesser than three days from current date ");
		        }
		        }
			}
		});
	

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
	    /*if ($scope.checkundefined($scope.emptyreposition.commodity)) {
	        msg = msg + "<li>Commodity:Field is required.</li>";         
	        $scope.changecolor('commodity');
	    }else{
	    	$scope.clearcolor('commodity');
	    	
pol
pod

	    }*/
	    if ($scope.checkundefined($scope.emptyreposition.agent)) {
	        msg = msg + "<li>Agent is required.</li>";         
	        $scope.changecolor('customer_id');
	    }else{
	    	$scope.clearcolor('customer_id');
	    }
	    
	    if ($scope.checkundefined($scope.emptyreposition.pol)) {
	        msg = msg + "<li>POL is required.</li>";         
	        $scope.changecolor('service');
	    }else{
	    	$scope.clearcolor('service');
	    }
	    
	    
	    if ($scope.checkundefined($scope.emptyreposition.pod)) {
	        msg = msg + "<li>POD is required.</li>";         
	        $scope.changecolor('aol');
	    }else{
	    	$scope.clearcolor('aol');
	    }
	    
	    if ($scope.emptyreposition.pod==$scope.emptyreposition.pol) {
	        msg = msg + "<li>POL and POD should not be same.</li>";         
	        $scope.changecolor('aol');
	    }else{
	    	$scope.clearcolor('aol');
	    }
	    if ($scope.checkundefined($scope.emptyreposition.exDate)) {
	        msg = msg + "<li>Er Date :Field is required.</li>";         
	        $scope.changecolor('emptyrepositionDate');
	    }else{
	    	$scope.clearcolor('emptyrepositionDate');
	    }
	   
	    
	    

	  
	  	    angular.forEach($scope.emptyreposition.transitDtl, function(chargesDetail, index) {/*     
	        if ($scope.checkundefined(chargesDetail.vessel)) {
	            msg = msg + "<li>Row :" + (index + 1) + "# vessel :Field is required.</li>";
	            //$scope.changecolor('chargeHeads'+index);
	        }else{
	        	$scope.clearcolor('chargeHeads'+index);
	        }
	        if ($scope.checkundefined(chargesDetail.voyage)) {
	            msg = msg + "<li>Row :" + (index + 1) + "# voyage :Field is required.</li>";
	            $scope.changecolor('unit'+index);
	        }else{
	        	$scope.clearcolor('unit'+index);
	        }
	        if ($scope.checkundefined(chargesDetail.pol)) {
	            msg = msg + "<li>Row :" + (index + 1) + "# POL :Field is required.</li>";
	            $scope.changecolor('qty'+index);
	            $('#qty'+index).find('input').css("border-color", "red");

	        }  else{
	        	//$('#qty'+index).find('input').css("border-color", "#e8dddd");
	        	$scope.clearcolor('qty'+index);
	        }  
	        if ($scope.checkundefined(chargesDetail.pod)) {
	            msg = msg + "<li>Row :" + (index + 1) + "# POD Date :Field is required.</li>";
	            $scope.changecolor('qty'+index);
	            $('#qty'+index).find('input').css("border-color", "red");

	        }  else{
	        	//$('#qty'+index).find('input').css("border-color", "#e8dddd");
	        	$scope.clearcolor('qty'+index);
	        }  
	        if ($scope.checkundefined(chargesDetail.leg)) {
	            msg = msg + "<li>Row :" + (index + 1) + "# LEG Date :Field is required.</li>";
	            $scope.changecolor('qty'+index);
	            $('#qty'+index).find('input').css("border-color", "red");

	        }  else{
	        	//$('#qty'+index).find('input').css("border-color", "#e8dddd");
	        	$scope.clearcolor('qty'+index);
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
	            msg = msg + "<li>Row :" + (index + 1) + "# Buy Sell:Field is required.</li>";
	        }  
	        
	        
	        
	    */});
	  	    
	  	  
	  	
	  	
	  	
	  	    
	  	    angular.forEach($scope.emptyreposition.depotDetail, function(chargesDetail, index) {     
		        if ($scope.checkundefined(chargesDetail.depot)) {
		            msg = msg + "<li>Row :" + (index + 1) + "# Depot :Field is required.</li>";
		            //$scope.changecolor('chargeHeads'+index);
		        }else{
		        	$scope.clearcolor('chargeHeads'+index);
		        }
		        if ($scope.checkundefined(chargesDetail.conType)) {
		            msg = msg + "<li>Row :" + (index + 1) + "# Container Type :Field is required.</li>";
		            $scope.changecolor('unit'+index);
		        }else{
		        	$scope.clearcolor('unit'+index);
		        }
		        if ($scope.checkundefined(chargesDetail.containerNo)) {
		            msg = msg + "<li>Row :" + (index + 1) + "# Container No :Field is required.</li>";
		            $scope.changecolor('qty'+index);
		            $('#qty'+index).find('input').css("border-color", "red");

		        }  else{
		        	//$('#qty'+index).find('input').css("border-color", "#e8dddd");
		        	$scope.clearcolor('qty'+index);
		        }  
		       /* if ($scope.checkundefined(chargesDetail.tareWeight)) {
		            msg = msg + "<li>Row :" + (index + 1) + "# Tare Weight :Field is required.</li>";
		            $scope.changecolor('qty'+index);
		            $('#qty'+index).find('input').css("border-color", "red");

		        }  else{
		        	//$('#qty'+index).find('input').css("border-color", "#e8dddd");
		        	$scope.clearcolor('qty'+index);
		        }   */ 
		        
		        
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
			var list=[];
			angular.forEach($scope.emptyreposition.depotDetail,function(row, index) {
				if(row.select==true){
					list.push(row);
				}
			})
			$scope.emptyreposition.depotDetail=list;
        if($scope.emptyreposition.depotDetail.length>0){
        	if($scope.emptyreposition.transitDtl.length>0){
        	
        
			$http.post($stateParams.tenantid+'/app/emptyRepositioning/save',$scope.emptyreposition).success(function(datas) {
				debugger
				  if(datas.success==true){					 
					  logger.logSuccess("Saved Successfully!");
					  $state.go('app.operation.emptyRepositioning.list',{tenantid:$stateParams.tenantid});
				        

				}else{
					  logger.logError(datas.message);
				  }
				}).error(function(data) {
					logger.logError("Please try again");
				});
        	
        }
        	else
        		logger.logError("Atleast One Row Required for Routing Detail ");
        
        }else{
        	logger.logError("Atleast One Row Required for empty Repositioning Deatil");
        }
		}
		
		
	}
	   
  
    
/*    $scope.showPopup=function(){
      ngDialog.open({
                scope : $scope,
                template : 'views/master/inventory/emptyreposition/popDetail',
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
			 if($scope.emptyreposition.depotDetail.length>0){
		        	if($scope.emptyreposition.transitDtl.length>0){
			$http.post($stateParams.tenantid+'/app/emptyRepositioning/update',$scope.emptyreposition).success(function(datas) {
				  if(datas.success==true){					
					  
					  logger.logSuccess("Updated Successfully!");
					  $state.go('app.operation.emptyRepositioning.list',{tenantid:$stateParams.tenantid});

				  }else{
					  logger.logError(datas.message);
				  }
				}).error(function(data) {
					logger.logError("Please try again");
				});
			 
			 }else{
				 logger.logError("Atleast One Row Required");
			 }
			 }else{
		        	logger.logError("Atleast One Row Required");
		        }
		}
		
		
	}
	$scope.cancel=function(){
	
		$state.go('app.operation.emptyRepositioning.list',{tenantid:$stateParams.tenantid});
	}
	
    $scope.$watch('emptyreposition.customer', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
        	$scope.custId=newValue;
        	$http.post($stateParams.tenantid+'/app/container/getcustomerdetail',$scope.custId).success(function(datas) {
        		
        		$scope.bookingNoList=datas.populateBookingNO;
    		
    		}).error(function(datas) {

    		});
        } 
    });
    
    $scope.$watch('emptyreposition.bookingNo', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
        	$scope.bookingNo=newValue;
        	$http.post($stateParams.tenantid+'/app/container/getcustomerpolpod',$scope.bookingNo).success(function(datas) {
        		
        		$scope.emptyreposition.pol=datas.seaemptyrepositionBean.pol;
        		$scope.emptyreposition.pod=datas.seaemptyrepositionBean.pod;
    		
    		}).error(function(datas) {

    		});
        } 
    });
	
	// upload
	debugger

	$scope.closeUpload = function() {
		ngDialog.close();
	}

	
	$scope.uploadContainerExcel = function(element) {
		debugger
		console.log("excel file");
		$scope.excelfile = element.files[0];
		console.log($scope.excelfile);

	}
	$scope.uploadContainer = function() {
		// loader.start();
		var excelfile = $scope.excelfile;
		var fileExtension = excelfile.name;
		var fName = [];
		fName = fileExtension.split(".");
		for (var i = 0; i < fName.length; i++) {
			if (fName[i] == "xls" || fName[i] == "xlsx") {
				var frmData = new FormData();
				frmData.append("file", excelfile);
				$
						.ajax({
							type : "POST",
							url : $stateParams.tenantid+'/app/emptyRepositioning/uploadfile',
							data : frmData,
							contentType : false,
							processData : false,
							success : function(response) {
								// loader.complete();
								if (response.success == true) {
									for(var i=0; i < response.lQuotationBean.length;i++){
										$scope.emptyreposition.depotDetail.push(response.lQuotationBean[i]);
									}
									$('#buttontemp').simulateClick('click');
									//	$scope.containerOnHire.containerDtl=angular.copy(response.containerDtl);
									if(response.lQuotationBean.length > 0 ){
											logger.logSuccess("Container Details Uploaded Successfully!");
									}else{
										logger.logError("Sorry Error Occured in Upload");
									}
									$scope.closeUpload();
								} else if (response.success == false) {

									for (var i = 0; i < response.errorList.length; i++) {
										logger
												.logError(response.errorList[i]);
										$scope.closeUpload();
										
									}
								} else if (response.errorList.length > 0) {

								} else {
									logger
											.logError("Sorry Error Occured");
									$scope.closeUpload();
									$scope.getMemberList();
								}
							}
						});
			}
		}
	}
	$scope.downloadFile = function() {
		$("#ERSDownload").bind('click', function() {
		});
		$('#ERSDownload').simulateClick('click');
	}

	$.fn.simulateClick = function() {
		return this.each(function() {
			if ('createEvent' in document) {
				var doc = this.ownerDocument, evt = doc
						.createEvent('MouseEvents');
				evt.initMouseEvent('click', true, true,
						doc.defaultView, 1, 0, 0, 0, 0, false,
						false, false, false, 0, null);
				this.dispatchEvent(evt);
			} else {
				this.click();
			}
		});
		
		
	}
	
	 $scope.genCancel=function(){
            ngDialog.close();
        }
	 
	$scope.fileUpload =function(){
		 ngDialog.open({
                template : 'fileGenModal',
                scope :$scope
            });
		} 


});
app.controller('emptyrepositiontableCtrl', function($scope, $http, $filter, logger,$stateParams) {
	  $scope.$watch('emptyreposition.transitDtl[trIndex].vessel', function(newValue,
				oldValue) {

			if (newValue != '' && newValue != undefined) {

				$http.get(
						$stateParams.tenantid
								+ '/api/vesselsailing/voyagelist?vessel='
								+ newValue).success(
						function(datas) {
							$scope.voyageList = datas;

						}).error(function(data) {
					logger.logError("Unable to fetch");
				});

			}
		});			

});


app.controller('emptyrepositionContainerCtrl', function($scope, $http, $filter, logger,$stateParams) {
	  $scope.$watch('emptyreposition.depotDetail[trIndex].containerNo', function(newValue,
				oldValue) {

			if (newValue != '' && newValue != undefined) {

				$http.get($stateParams.tenantid+ '/app/emptyRepositioning/ContainerTypeList?containerNo='+ newValue).success(
						function(datas) {
							$scope.emptyreposition.depotDetail[$scope.trIndex].conType = datas.conType;

						}).error(function(data) {
					logger.logError("Unable to fetch");
				});

			}
		});			

});