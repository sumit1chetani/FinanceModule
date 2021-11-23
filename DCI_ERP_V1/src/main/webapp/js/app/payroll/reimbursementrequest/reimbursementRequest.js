define([ 'payroll/payroll/payroll' ], function(module) {
'use strict';
module.registerController('reimbursementReqCtrl', function($scope,$state,$http,ngDialog, logger,$location,$controller,$injector, sharedProperties, toaster,$rootScope)  {
    
    $scope.reimbursementReq = {
                    departmentId:'',
                    reimbursementTypeId:'',
                    reimbusementName:'',
                    currencyName:'',
                    currencyCode:'',
                    branchId:'',
                    companyId:'',
                    companyName:'',
                    branchName:'',
                    employeeId:'',
                    employeeName:'',
                    paymentMode:'',
                    amount:'',
                    fileName:'',
                    departmentName:'',
                    description:'',
                    requestedby:'',
                    requesteddate:'',
                    reimbursementId:'',
                    status:'1',
                    isEdit:false
                   
            };
 
    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.isDelete=true;
    $scope.isUpload=true;
  
  
    
    $scope.getList = function(){
        $http.post("payroll/payroll/reimbursementreq/list",$scope.reimbursementReq.status)
        .success(function(response) {
            console.log("success");
            console.log(response.reimbursementList);
           $scope.rowCollection = response.reimbursementList;
        });
    };
    $scope.getList();
    
    $scope.editRow = function (reimbursementId){
       
        $location.url('/payroll/reimbursementreq/edit?reimbursementId='+reimbursementId);
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
    
    
    $scope.downloadfile=function(){
        
        $("#tbPdfExport").bind('click', function() {
            //  alert('clicked');

        });
        $('#tbPdfExport').simulateClick('click');
        
     //   alert(index);
        /*$("#tbPdfExport").bind('click', function() {
             

        });
        $('#tbPdfExport').simulateClick('click');*/
    }
    
    
    $scope.add=function(){
        $state.go('app.payroll.payroll.reimbursementreq.add');
    };
   
 
    $scope.deleteRow = function(reimbursementId) {
        ngDialog.openConfirm().then(function() {
           
            $http.post("payroll/payroll/reimbursementreq/delete",reimbursementId)
            .success(function(response) {
                console.log("result is");
                console.log(response);
               if(response == true){
                   logger.logSuccess("Deleted Successfully!");
                   $scope.getList();
               }
            }).error(function(result) {
                logger.logError("Error Please Try Again");
            });
        });
    };
});
});