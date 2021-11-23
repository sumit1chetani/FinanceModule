'use strict';
app.controller('CompanyDetailsEditCtrl', function($scope,$stateParams, $rootScope, $http,$injector, $location, logger, $log, ngDialog, $modal, validationService,toaster,utilsService,sharedProperties) {

    var $validationProvider = $injector.get('$validation');
    
    //Cancel
    $scope.cancel = function() {
        $location.path($stateParams.tenantid+"/general/companydetails");
    };

    $scope.CompanyDetailsMasterData = {
            companyname : '',
            location : '',
            address:'',
            phoneno:'',
            faxno:'',
            email:'',
            personincharge:'',
            relationship:'',
            intercompgroup:'',
            success:'',
            currencyCode:'',
            edit:true,
            isOperation : 'N'
   };
    
    $scope.reset1 = function() {
        $scope.CompanyDetailsMasterData=[];   
        $scope.FetchingValues();
       
    };
    
    //$scope.CompanyDetailsMasterData=sharedProperties.getObject();
  
  //Reset on edit
    
    $scope.originalUser = angular.copy($scope.CompanyDetailsMasterData);    
    $scope.reset = function() {
        $scope.originalUser.edit=true;
        $scope.CompanyDetailsMasterData = angular.copy($scope.originalUser);
    };
    
    
       
    //Update Functionality
    $scope.update = function(CompanyDetailsMasterForm,CompanyDetailsMasterData) {  
        if (new validationService().checkFormValidity($scope.CompanyDetailsMasterForm)) {
             $http.post($stateParams.tenantid+'/app/companydetails/update', CompanyDetailsMasterData).success(function(result) {
                 if (result) {
                     logger.logSuccess("Updated Successfully!");
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
    
    //edit Functionality
    var companycode=$location.search().companycode;
    $scope.FetchingValues = function() {
        

        
        $http.get($stateParams.tenantid+'/api/company/countrylist').success(function(datas) {
            $scope.countryList=datas;
         }).error(function(data) {

         });     
        
        $http.get($stateParams.tenantid+'/app/companydetails/getCurrencyList').success(function(datas) {
            $scope.currencyList=datas;
         }).error(function(data) {

         });
        
      var myURL = $stateParams.tenantid+'/app/companydetails/edit';
       $http({
          url : myURL,
           data : companycode,
           method : 'post',
           dataType : 'json',
           headers : {
               'Accept' : 'application/json',
               'Content-Type' : 'application/json'
           }
      }).success(function(result) {
          $scope.CompanyDetailsMasterData.companycode = result.companycode;
          $scope.CompanyDetailsMasterData.companyname = result.companyname;
          $scope.CompanyDetailsMasterData.shortName = result.shortName;
          $scope.CompanyDetailsMasterData.location = result.location;
          $scope.CompanyDetailsMasterData.address=result.address;
          $scope.CompanyDetailsMasterData.currencyCode=result.currencyCode;
          $scope.CompanyDetailsMasterData.phoneno=result.phoneno;
          $scope.CompanyDetailsMasterData.faxno=result.faxno;
          $scope.CompanyDetailsMasterData.email=result.email;
          $scope.CompanyDetailsMasterData.personincharge=result.personincharge;
          $scope.CompanyDetailsMasterData.relationship=result.relationship;
          $scope.CompanyDetailsMasterData.intercompgroup=result.intercompgroup;
          $scope.CompanyDetailsMasterData.edit = result.edit;  
          $scope.CompanyDetailsMasterData.isOperation = result.isOperation;
      }).error(function(data) {         
      });
      }
    
    $scope.FetchingValues();
        
});