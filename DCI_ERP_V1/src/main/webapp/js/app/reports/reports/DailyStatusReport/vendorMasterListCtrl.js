'use strict';
app.controller('vendorMasterController', function($scope, $rootScope, $http, $location, logger, utilsService,$state,sharedProperties,$window,ngDialog,$stateParams) {

    $scope.rowCollection=[];
    $scope.emptyObject={};
    $scope.itemsByPage = 10;
    
    $scope.pageCounters = [14, 16, 17, 18, 150, 500, 1000 ];
    $scope.itemsByPage = 14;
    
    $scope.add=function(){
        $state.go('app.finance.controlscreen.vendormasteradd',{tenantid:$stateParams.tenantid});
    }
    
    
    $scope.getCharterhireList = function() {
        
        $http.get($stateParams.tenantid+'/app/vendorMaster/list').success(function(data) {
          console.log("list data")
console.log(data)
          $scope.rowCollection= data;
                console.log($scope.rowCollection);
                sharedProperties.setObject($scope.emptyObject);
           }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
    };

   $scope.getCharterhireList();
   
    
   $scope.editVendorMaster = function(vendorCode) {
          $location.path($stateParams.tenantid+'/controlscreen/vendorMasterEdit/' + vendorCode);
   }
   
   /**
    * Delete Row
    */
     
   $scope.deleteRow = function(vendorCode) {
       debugger;
       ngDialog.openConfirm().then(function() {
           var myURL =$stateParams.tenantid+'/app/vendorMaster/delete?vendorCode=' + vendorCode;
           $http({
               method : 'post',
               url : myURL,
               data : "",
           }).success(function(data) {
               if (data == true) {
                   logger.logSuccess("deleted successfully");
                   $state.reload();
               } else {
                   logger.logError("Error in deleting Record!");
               }
           }).error(function(data) {
               logger.logSuccess("Error in Delete!");
           });
       });

   };
  
   
   $scope.view = function(objvendorMaster ) {
       
       
       console.log("from view data")
      console.log( objvendorMaster)
       sharedProperties.setObject(objvendorMaster );
       $state.go('app.finance.controlscreen.vendormasterview',{tenantid:$stateParams.tenantid});
       

   }
   
   
   
   
});