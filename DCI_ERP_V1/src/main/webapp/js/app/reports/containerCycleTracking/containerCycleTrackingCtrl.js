'use strict';
app.controller('containerCycleTrackingCtrl', function($scope, $timeout,
		$stateParams, sharedProperties, toaster, $filter, $rootScope, $http,
		$location, logger, $state, ngDialog, $controller, $injector) {
	$scope.quotationTypeList = [];
	$scope.customerDropList = [];
	$scope.consigneeDropList = [];
	$scope.shipmentList = [];
	$scope.nominatedDropList = [];
	$scope.vendorDropList = [];
	$scope.serviceParnrDropList = [];
	$scope.portList = [];
	$scope.currencyList = [];
	$scope.createQuote = false;

	var bookingDate = $stateParams.bookingDate;
	var mloCode = $stateParams.mloCode;
	var lolId = $stateParams.lolId;
	var lodId = $stateParams.lodId;
	var bookingId = parseInt($stateParams.bookingId);

	$scope.quotation = {
		fromDate : '',
		toDate : ''
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

	$scope.quotation.quotationDate = dd + '/' + mm + '/' + yyyy;

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

	/*
	 * $scope.containerreleaseCode=$location.search().containerreleaseCode;
	 * 
	 * if($scope.containerreleaseCode != '' &&
	 * $scope.containerreleaseCode!=undefined){ $scope.edit=true;
	 * $http.post($stateParams.tenantid+'/app/container/edit',$scope.containerreleaseCode).success(function(datas) {
	 * 
	 * $scope.quotation=datas.seaQuotationBean;
	 * $scope.quotation.quotationDtl=datas.lQuotationBean;
	 * $scope.quotation.sealDtl=datas.sealdtl;
	 * 
	 * 
	 * 
	 * }).error(function(datas) {
	 * 
	 * });
	 * 
	 *  }
	 */

	/*
	 * $scope.getdropdown = function() {
	 * 
	 * $http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(datas) {
	 * $scope.shipmentList=datas.getshipmentlist;
	 * $scope.portList=datas.getportlist;
	 * $scope.customerDropList=datas.getcustomerlist;
	 * $scope.conTypeList=datas.getcontypelist;
	 * $scope.depotList=datas.getportlist;
	 * $scope.chargeTypeList=datas.getchargetypelist //logger.logSuccess('Mail
	 * Sent Successfully!') }).error(function(datas) {
	 * 
	 * }); }
	 * 
	 * $scope.getdropdown();
	 */

	$scope.changecolor = function(id) {
		$('#' + id + ' .selectivityId').find('input')
				.css("border-color", "red");
	}

	$scope.changecolor = function(id) {
		$('#' + id + ' .selectivityId').find('input')
				.css("border-color", "red");

	}
	$scope.clearcolor = function(id) {
		$('#' + id + ' .selectivityId').find('input').css("border-color",
				"#e8dddd");

	}

	/*
	 * $scope.dropoffList=[
	 *  { id: 'ROAD', text: 'ROAD' }, { id: 'RAIL', text: 'RAIL' }
	 *  ]
	 */

	// $scope.getSalesType = function() {
	// var data = {};
	// data["id"] = "1";
	// data["text"] = "CROSS TRADE";
	// $scope.salesTypeList.push(data);
	// data = {};
	// data["id"] = "2";
	// data["text"] = "LOCAL";
	// $scope.salesTypeList.push(data);
	// data = {};
	// data["id"] = "3";
	// data["text"] = "NOMINATED";
	// $scope.salesTypeList.push(data);
	//	    
	//	  
	// }
	// $scope.getSalesType();
	// excel upload

	$scope.changecolor = function(id) {
		$('#' + id + ' .selectivityId').find('input')
				.css("border-color", "red");
		;

	}
	$scope.clearcolor = function(id) {
		$('#' + id + ' .selectivityId').find('input').css("border-color",
				"#e8dddd");
		;

	}

	$scope.getReport = function(container) {

	var chk=false;
if(container.fromDate!=undefined && container.fromDate!=''){
	if(container.toDate!=undefined && container.toDate!=''){
		chk=true;
	
	}
	}
	if(chk){
	$http.post($stateParams.tenantid + '/app/containerTracking/edit',
				container).success(function(datas) {

			if (datas.success) {
				$("#GLExport").bind('click', function() {
				});
				$('#GLExport').simulateClick('click');

			} else {
				logger.logError("No Record Found");

			}

		}).error(function(datas) {

		});
	
	}
	else 
		{
		
		logger.logError("Please select From Date and To Date");
		}

	}

	$.fn.simulateClick = function() {
		return this.each(function() {
			if ('createEvent' in document) {
				var doc = this.ownerDocument, evt = doc
						.createEvent('MouseEvents');
				evt.initMouseEvent('click', true, true, doc.defaultView, 1, 0,
						0, 0, 0, false, false, false, false, 0, null);
				this.dispatchEvent(evt);
			} else {
				this.click(); // IE
			}
		});
	}

	/*
	 * $.fn.simulateClick = function() { return this.each(function() { if
	 * ('createEvent' in document) { var doc = this.ownerDocument, evt =
	 * doc.createEvent('MouseEvents'); evt.initMouseEvent('click', true, true,
	 * doc.defaultView, 1, 0, 0, 0, 0, false, false, false, false, 0, null);
	 * this.dispatchEvent(evt); } else { this.click(); // IE } }); }
	 */

	/*
	 * $scope.$watch('quotation.customer', function(newValue, oldValue) { if
	 * (newValue != '' && newValue != undefined) { $scope.custId=newValue;
	 * $http.post($stateParams.tenantid+'/app/container/getcustomerdetail',$scope.custId).success(function(datas) {
	 * 
	 * $scope.bookingNoList=datas.populateBookingNO;
	 * 
	 * }).error(function(datas) {
	 * 
	 * }); } });
	 */

	/*
	 * $scope.$watch('quotation.bookingNo', function(newValue, oldValue) { if
	 * (newValue != '' && newValue != undefined) { $scope.bookingNo=newValue;
	 * $http.post($stateParams.tenantid+'/app/container/getcustomerpolpod',$scope.bookingNo).success(function(datas) {
	 * 
	 * $scope.quotation.pol=datas.seaQuotationBean.pol;
	 * $scope.quotation.pod=datas.seaQuotationBean.pod;
	 * 
	 * }).error(function(datas) {
	 * 
	 * }); } });
	 * 
	 */

});