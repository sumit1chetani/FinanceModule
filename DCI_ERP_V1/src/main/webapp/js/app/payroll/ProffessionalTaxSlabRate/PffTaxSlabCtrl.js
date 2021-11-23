

        'use strict';
   	app.controller('PffTaxSlabCtrl', function($stateParams,$scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService,utilsService, $window,$timeout) {

        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.isDelete=true;
        $scope.isUpload=true;
//        $scope.check=false;
  $scope.slabRate = {
                
                fromDate:'',
                toDate   :'',
         };
        
        
  $http.get('payroll/master/professionalTax/gridList').success(function(data){
      debugger
      $scope.rowCollection= data.list;
      
      
  })
  
        $scope.editRow = function (slabHdrId,fromDate,toDate){
    var fromDateTax= fromDate;
    var toDateTax=toDate;
    $rootScope.toDateTax=toDateTax;
    $rootScope.fromDateTax=fromDateTax;
            debugger
          $location.url($stateParams.tenantid+'/payroll/ProffessionalTaxSlabRate/edit?slabHdrId='+slabHdrId);
        }
  
  
  
   $scope.copyRow = function (slabHdrId,fromDate,toDate){
      var fromDateTax= fromDate;
      var toDateTax=toDate;
      $rootScope.toDateTax=toDateTax;
      $rootScope.fromDateTax=fromDateTax;
              debugger
            $location.url($stateParams.tenantid+'/payroll/ProffessionalTaxSlabRate/copyedit?slabHdrId='+slabHdrId);
          }
        
        
        $scope.add =function(){
            
            $state.go('app.payroll.ProffTaxSlabRate.add');
          };
       
            
            $scope.deleteRow = function(slabHdrId) {
                
                ngDialog.openConfirm().then(function() {
                debugger
                $http.get("payroll/master/professionalTax/delete?slabHdrId="+ slabHdrId)
                    .success(function(response) {
                        
                       if(response.deleted == true){
                           logger.logSuccess("Deleted Successfully!");
                           $http.get('payroll/master/professionalTax/gridList').success(function(data){
                               debugger
                               $scope.rowCollection= data.list;
                               
                               
                           })
                       }else{
                           logger.logError("Unable to delete Record");
                       }
                    }).error(function(result) {
                        logger.logError("Error Please Try Again");
                    });
                });
            };
            
           
   
    
});

