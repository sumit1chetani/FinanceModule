'use strict';
app.controller('CompanyDetailsAddCtrl', function($scope,$stateParams, $rootScope, $http,$injector, $location, logger, $log, ngDialog, $modal, utilsService,validationService,toaster,sharedProperties) { 
   
    $scope.companynameList=[];
    
    //Cancel
    $scope.cancel = function() {
        $location.path($stateParams.tenantid+"/general/companydetails");
    };
   
    $scope.currencyList=[];
    $scope.CompanyDetailsMasterData = {
            companyname: '',
            shortName : '' ,
            location : '' ,
            address:'',
            phoneno:'',
            faxno:'',
            email:'',
            personincharge:'',
            relationship:'',
            intercompgroup:'' ,
            currencyCode:'',
            edit:false,
            isOperation : 'Y'
   };
    
    
    //Reset on add mode
    $scope.reset = function() {
        $scope.CompanyDetailsMasterData=[];   
        $scope.getDropdownvalue();
      if($scope.CompanyDetailsMasterData.email==undefined)
            {
            $scope.CompanyDetailsMasterData.email=null;            
            }
    };
    
    /* Fetching Drop Down */
    $scope.getDropdownvalue = function() {
         
     $http.get($stateParams.tenantid+'/app/companydetails/getcompanyname').success(function(datas) {
         $scope.companynameList=datas;
      }).error(function(data) {

      });     
     
     $http.get($stateParams.tenantid+'/app/companydetails/getCurrencyList').success(function(datas) {
         $scope.currencyList=datas;
      }).error(function(data) {

      });
    }
    $scope.getDropdownvalue();
    
   
 // Save Functionality

   
    $scope.save = function(CompanyDetailsMasterForm,CompanyDetailsMasterData) {  
       if (new validationService().checkFormValidity($scope.CompanyDetailsMasterForm)) {
            $http.post($stateParams.tenantid+'/app/companydetails/add', CompanyDetailsMasterData).success(function(result) {
                console.log("result")
                console.log(result)
                if (result) {
                    logger.logSuccess("Saved successfully!");
                    $location.path($stateParams.tenantid+'/general/companydetails');
                } else {
                    logger.logError("Company Name Already Exist!");
                }
            }).error(function(result) {
                console.log("data" + result);
            });
        }
       else{
           toaster.pop('error', "Please fill the required fields", 
                   logger.getErrorHtmlNew($scope.CompanyDetailsMasterForm.$validationSummary), 555000, 'trustedHtml');
             }
    }
    
    
  
   
    $scope.Duplicate=function(companyname)
    {
        $http.post($stateParams.tenantid+'/app/companydetails/duplicate', companyname).success(function(result) 
                {
            if (result == true) {
                logger.logError("Company Name Already Exist");           
            }
                })      
    };
    
   
  
       
    
 
});