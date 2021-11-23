'use strict';
app.controller('reportCtrl', function($scope, $rootScope, $http, $location, logger, ngDialog,
        utilsService,$state,sharedProperties,$window,$stateParams) {
    
    $scope.showExcel = true;
   /* $scope.pageCounters = [ 10, 15, 20, 25, 50,75,100,125, 150];*/
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.customerList = [];
    $scope.isAgent = false;
    $scope.itemsByPage = 10;
    $scope.getList = function() {
        var url = $stateParams.tenantid+'/app/reportEIR/list';
        $http.get(url).success(function(data) {
            if (data.headerList!=null && data.headerList.length>0 ) {
            	console.log(data.headerList);
                console.log("list")
                $scope.customerList = data.headerList;
            }
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
    };

    $scope.getList();
    
    
    $scope.add = function() {
        $state.go('app.operation.report.reportsubmenuadd',{tenantid:$stateParams.tenantid});
    };




  //Redirecting Page For Edit Functionality
    $scope.editRow = function(rowData) {
        $location.url($stateParams.tenantid+'/master/report/reportEIRAdd?eirHdrId='+rowData.eirHdrId);
    };
    $scope.viewRow = function(rowData) {
        $location.url($stateParams.tenantid+'/master/report/reportEIRView?eirHdrId='+rowData.eirHdrId);
    };

    $scope.deleteRow = function(rowData){
    	$http.post($stateParams.tenantid+'/app/reportEIR/delete',rowData.eirHdrId).success(function(data) {
            if (data.success ) {
            	logger.logSuccess("Deleted Successfully");
            	$scope.getList();
            }else{
            	logger.logError("Unable to delete!");
            }
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
    }
});