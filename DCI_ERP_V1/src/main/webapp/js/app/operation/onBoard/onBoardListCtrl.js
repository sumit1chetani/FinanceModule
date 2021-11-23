'use strict';

app.controller('onBoardListCtrl', function($scope, $rootScope, $http, $location, logger, utilsService, ngDialog, $state,sharedProperties,$window,$stateParams,$timeout) {

    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    
    
    $scope.getList=function(){
        $http.get($stateParams.tenantid+'/app/onBoard/list').success(function(datas) {
            console.log(datas);
            $scope.rowCollection = datas.onBoardBeanList;
        	
            }).error(function(datas) {
        });
        };
        $scope.getList();
        
    $scope.add = function() {
        $state.go('app.operation.OnBoard.add',{tenantid:$stateParams.tenantid});
    };
    $scope.viewGeneralLedgerReportNew = function(quotation) {
    	if(quotation.mode==''){
    		quotation.mode==''
    	}if(quotation.carrier==''){
    		quotation.carrier==''
    	}
    	$http.post($stateParams.tenantid+'/app/onBoard/getSearchList',quotation).success(function(data) {

    	//$http.get($stateParams.tenantid+'/app/seaquotation/filterList?mode='+quotation.mode+'&polCode='+quotation.polCode+'&podCode='+quotation.podCode+'&status='+quotation.status+'&fromDate='+quotation.fromDate+'&toDate='+quotation.toDate).success(function(data) {
		debugger
        $scope.rowCollection = data.onBoardBeanList;
	});};
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
	}
	$scope.getQuotationType();
	$http.get($stateParams.tenantid+'/app/commonUtility/getcarrierList').success(function(datas) {
		debugger
	    $scope.carrierList = datas.commonUtilityBean;	    
        //$scope.transList = datas.lCommonUtilityBean;	    

	}).error(function(data) {

	});
    $scope.deleteRow = function(onBoardNo) {
        ngDialog.openConfirm().then(function() {
        
            var url = $stateParams.tenantid+'/app/onBoard/delete?onBoardNo=' + onBoardNo;
            $http.get(url).success(function(result){
                if (result.success ==  true) {
                    logger.logSuccess("Deleted successfully");
                    $state.reload();
               } else {
                    logger.logError("You Can't Delete this Record, Related Data Exist! ");
                }
            }).error(function(result) {
                logger.logError("Error Please Try Again");
            });
        }, function(reason) {
            console.log('Modal promise rejected. Reason: ', reason);
        });
    };
    
    $scope.filePath = '';
    $scope.fileName = '';

    $scope.Export = function(onBoardID) {
        $http.post($stateParams.tenantid+'/app/onBoard/generateExcelReport?onBoardID=' + onBoardID).success(function(data) {
            console.log(data);
            if (data.success == true) {
                logger.logSuccess("Report Exported successfully!");
                $scope.filePath= data.filePath;
                $scope.filePath="filePath/"+data.fileName;
                $scope.fileName=data.fileName;
                $timeout(function(){ $('#tbExcelExport').simulateClick('click')},100);
                 
            }
       }).error(function(data) {
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

    $scope.view = function(onBoardNo) {
    	 $location.path($stateParams.tenantid+'/onBoard/view/' + onBoardNo);
      }
    

    
});