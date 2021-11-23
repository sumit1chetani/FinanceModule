'use strict';
app.controller('accountPayableSettledInvoicesCtrl', function($templateCache, $scope, $rootScope, $http, logger, $log, ngDialog, $modal, $location, $sce, $filter,$stateParams) {

    $('#tb_fromDate').datetimepicker({
        format : 'DD/MM/YYYY'
    });
    
    $('#tb_toDate').datetimepicker({
        format : 'DD/MM/YYYY'
    });
    
    
    $('#tb_week').datetimepicker({
        format : 'DD/MM/YYYY',
        calendarWeeks: true
    });

    $scope.accountSettledInvoices = {
            companyCode: '',
            fromDate: '',
            toDate: '',
            mloCode: '',
            vendorCode:'',
            invoice: '',
            docNo: '',
            docDate: '',
            recNo: '',
            recDt: '',
            chqNo: '',
            chqDt: '',
            localAmt:'',
            usdAmt :''
    };

    $scope.formreset = function() {
        $scope.accountSettledInvoices = {};
    };
    $scope.pageCounters = [ 10,15, 25, 50, 75, 100, 125,150 ];
    $scope.index=[];
    $scope.checked = [];
    var index="";
    $scope.itemsByPage = 10;
    $scope.hideUploadIcon=true;
    $scope.hideDeleteIcon=true;
    
    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.rowCollection = [];
    $scope.displayedCollection = [];

    $scope.subGroupList = [];
    $scope.companyList = [];
    $scope.vendorList = [];
    $scope.invoiceList = [];
    
    $scope.getDropDownList = function() {      
        
/*        $http.get('app/accountSettledInvoiceController/getCompanyList').success(function(data) {
            $scope.companyList = data;
        }).error(function(data) {
        });*/
        
        $http.get($stateParams.tenantid+'/app/usermaster/getCompanyList?formCode='+$('#form_code_id').val()).success(function(data) {
            $scope.companyList=data;
        }).error(function(data) {
        });
   
        $http.get($stateParams.tenantid+'/app/accountSettledInvoiceController/getPurchaseInvoiceList').success(function(data) {
            debugger;
            $scope.invoiceList = data;
        }).error(function(data) {
        });
        
        $http.get($stateParams.tenantid+'/app/accountSettledInvoiceController/getVendorList').success(function(data) {
            debugger;
            $scope.vendorList = data;
        }).error(function(data) {
        });
        
        
        $scope.$watch('accountSettledInvoices.vendorCode',function(newValue,oldValue){
            console.log(newValue);
           if(newValue != null && newValue != undefined){
                $http.get($stateParams.tenantid+'/app/accountSettledInvoiceController/getInvoiceListForVendor?vendorCode='+newValue).success(function(datas) {                    
                    $scope.invoiceList = datas;
                }).error(function(data) {

                });
           }
        });
    };
        

    
    $scope.getDropDownList();
    
    $scope.ViewaccountSettledInvoicesReport = function(){
        debugger;
        $scope.rowCollection =[];
        $scope.accountSettledInvoices.fromDate = $('#fromDate').val();
        $scope.accountSettledInvoices.toDate = $('#toDate').val();
        if( $scope.accountSettledInvoices.companyCode !=''){
            
            $http.post($stateParams.tenantid+'/app/accountSettledInvoiceController/getAccountPayableSettledInvoiceReport', $scope.accountSettledInvoices).success(function(data) {
                console.log("data??????>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                console.log(data.accountSettledInvoiceList[0]);
                 if (data.success == true) {
                    $scope.rowCollection = $scope.rowCollection.concat(data.accountSettledInvoiceList);
                    if(data.accountSettledInvoiceList.length==0){
                        logger.logError("No Records Found!...");
                    }
                }else{
                    logger.logError("Some errors occured.Please try again!...");
                } 
                
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        }else{
            if($scope.accountSettledInvoices.companyCode ==null || $scope.accountSettledInvoices.companyCode ==undefined ||$scope.accountSettledInvoices.companyCode ==''){
                logger.logError("Please select Company");
            }
                
        }
    };
    
    $scope.exportaccountSettledInvoicesExcel = function(){
        $scope.accountSettledInvoices.fromDate = $('#fromDate').val();
        $scope.accountSettledInvoices.toDate = $('#toDate').val();
        if( $scope.accountSettledInvoices.companyCode !=''){
            
            $http.post($stateParams.tenantid+'/app/accountSettledInvoiceController/payableAcctExcelExport', $scope.accountSettledInvoices).success(function(data) {
                console.log(data);
                if (data.success == true) {
                    $("#AccountSettledInvoicesExport").bind('click', function() {
                    });
                    $('#AccountSettledInvoicesExport').simulateClick('click');
                    logger.logSuccess("Exported successfully!");
                }else{
                    logger.logError("Failed to Export!..");
                }
                
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        }else{
            if($scope.accountSettledInvoices.companyCode ==null || $scope.accountSettledInvoices.companyCode ==undefined ||$scope.accountSettledInvoices.companyCode ==''){
                logger.logError("Please select Company");
            } 
                
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

