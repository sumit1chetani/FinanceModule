define([ 'payroll/tds/tds'], function(module) {

    'use strict';
    
    module.registerController('employeehraCtrl', function($scope,$state,$http,ngDialog, logger,$location,$controller,$injector, sharedProperties, toaster,$rootScope)  {
       
        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.tableSelection=[];
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.isDelete=true;
        $scope.isUpload=true;
        $scope.getList = function(){
          
            $http.get("payroll/tds/employeeHraReceipts/list")
            .success(function(response) {
                console.log("employeeHraReceiptsList");
                console.log(response);
                $scope.rowCollection =response.employeeHraReceiptsList;

            });
        }
        $scope.getList();
       
        
          $scope.add =function(){
            $state.go('app.payroll.tds.employeehra.add');
          };
         
          $scope.approve =function(employeeId,monthyear){
              $location.url('/payroll/tds/employeehra/approve?employeeId=' + employeeId +'&monthYear='+monthyear);
           };
           
          
          $scope.editRow=function(employeeId,monthyear){
              $location.url('/payroll/tds/employeehra/edit?employeeId=' + employeeId+ '&monthYear='+monthyear);
          };
          
          
          
        
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
           //   alert(index);
              $("#tbPdfExport").bind('click', function() {
                   // alert('clicked');

              });
              $('#tbPdfExport').simulateClick('click');
          }
          
          
          
         
          
          $scope.deleteRow = function(employeeId,monthYear) {
              ngDialog.openConfirm().then(function() {
                  var resultbean={
                          employeeId:employeeId,
                          monthYear:monthYear
                  }
                   $http.post("payroll/tds/employeeHraReceipts/delete",resultbean)
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
    
})