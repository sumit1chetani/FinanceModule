app.controller('customerRateAvailableCtrl', function($templateCache, $scope, $rootScope, $http, logger, $log, ngDialog, 
        $modal, $location, $sce, $filter, $timeout,utilsService,$compile) {
    
    $scope.custRateAvailData = {
            polCode:'',
            podCode:'',
            customerCode:'',
            fromDate:'',
            toDate:''            
    }
    
    $('#cra_fromDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime: false
    });
    
    $('#cra_toDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime: false
    });
    
    $("#cra_fromDate").on("dp.change", function(e) {
        $scope.custRateAvailData.fromDate=$("#txtFromDate").val();
    });
    $("#cra_toDate").on("dp.change", function(e) {
        $scope.custRateAvailData.toDate=$("#txtToDate").val();
    });
    
    $scope.getDropdownvalue = function() {

        $http.get('app/generalinvoice/getCustomerList').success(function(datas) {
              $scope.customerList = datas;
            }).error(function(datas) {
        });
        $http.get('app/commonUtility/getPortList').success(function(datas) {
            if(datas.length>0){
                $scope.polList = datas;
                $scope.podList = datas;    
            }else{
                $scope.polList = [];
                $scope.podList = [];
            }            
        }).error(function(data) {
        });
    }
    $scope.itemsByPage = 10;
    $scope.getDropdownvalue();
    $scope.rowCollection = [];
    $scope.rowCollectionTHead = [];
    $scope.generateCRAReport = function(){
        if($scope.custRateAvailData.polCode!="" || $scope.custRateAvailData.podCode!="" || $scope.custRateAvailData.customerCode!=""
            || $scope.custRateAvailData.fromDate!="" || $scope.custRateAvailData.toDate!=""){
            
            $http.post('app/customerRateAvailability/getCustomerRateAvailReportData',$scope.custRateAvailData).success(function(datas) {
                if(datas.lCustomerRateAvailabilityList.length>0){
                    $scope.rowCollection = [];
                    $scope.rowCollectionTHead = [];
                    $scope.rowCollection= datas.lCustomerRateAvailabilityList;
                    angular.forEach(datas.lCustomerRateAvailabilityList, function(filterObj,filterIndex){
                        if(filterIndex==0){
                            angular.forEach(filterObj, function(index,key){
                                var obj = new Object();
                                obj.keyTitle = key.replace(/'/g, "");
                                $scope.rowCollectionTHead.push(obj);
                            });
                        }
                    });
                }else{
                    $scope.rowCollection = [];
                    $scope.rowCollectionTHead = [];
                    logger.logError("No Records Found");
                }
                
              }).error(function(datas) {
          });
            
        }else{
            logger.logError("Please select Either 'Customer' or 'POL' Or 'POD'")
        }
    }
    
    $scope.exportCRAExcel = function(){
        debugger;
        if($scope.custRateAvailData.polCode!="" || $scope.custRateAvailData.podCode!="" || $scope.custRateAvailData.customerCode!=""
            || $scope.custRateAvailData.fromDate!="" || $scope.custRateAvailData.toDate!=""){
            $http.post('app/customerRateAvailability/exportCRAExcel', $scope.custRateAvailData).success(function(data) {
                if(data.success == true){
                    debugger;
                    $("#CRAExport").bind('click', function() {
                    });
                    $('#CRAExport').simulateClick('click');
                    logger.logSuccess("Exported successfully!");
                }else{
                    logger.logSuccess("Failed to export");
                }
                
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        }else{
            logger.logError("Please Select Atleast one.")
        }
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
    
});
