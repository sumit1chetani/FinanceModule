
    'use strict';
   	app.controller('advanceCtrl', function($stateParams,$scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService,utilsService, $window,$timeout) {

   // module.registerController('advanceCtrl', function($scope,$state,$http,ngDialog, logger,$location,$controller,$injector, sharedProperties, toaster,$rootScope)  {
       
        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.isDelete=true;
        $scope.isUpload=true;
        $scope.advance = {
                
                advanceCode:'',
                employee:'',
                employeeName:'',
                employeeCode:'',
                designation:'',
                joinDate:'',
                workingYear:'',
                description:'',  
                amount:0,
                disbursementDate:'',
                openingBalance:0,
                installmentPaid:'',
                recoverytype:'',
                installmentAmount:0,
                month:'',
                year:'',
                startDate:'',
                numberOfInstallments:'',
                balanceAmountReturn:'',
                isEdit:false  
               
                 
         };
        
       
        $scope.getList = function(){
            $http.get("payroll/payroll/advance/advanceList")
            .success(function(response) {
                console.log("Coming inside List");
                console.log(response);
                $scope.rowCollection = response.advanceList;
                
                angular.forEach($scope.rowCollection,function(value,key){
                    if(value.recoverytype =='1'){
                        value.recoverytype = 'Monthly';
                    }else if(value.recoverytype =='2'){
                        value.recoverytype = 'Quarterly';
                    }else if(value.recoverytype =='3'){
                        value.recoverytype = 'Half Yearly';
                    }else {
                        value.recoverytype = 'Yearly';
                    }
                });
            });
        };
        $scope.getList();
        
       
        $scope.editRow = function (advanceCode){
          $location.url($stateParams.tenantid+'/payroll/advance/advanceedit?advanceCode='+advanceCode);
        }
        
        $scope.add =function(){
            
            $state.go('app.payroll.advance.add');
          };
       
            
            $scope.deleteRow = function(advanceCode) {
                ngDialog.openConfirm().then(function() {
                    $http.get("payroll/payroll/advance/deleteAdvance?advanceCode="+ advanceCode)
                    .success(function(response) {
                        console.log("result is");
                        console.log(response);
                       if(response == true){
                           logger.logSuccess("Deleted Successfully!");
                           $scope.getList();
                       }else{
                           logger.logError("Unable to delete Record");
                       }
                    }).error(function(result) {
                        logger.logError("Error Please Try Again");
                    });
                });
            };
            
           
    });
    
