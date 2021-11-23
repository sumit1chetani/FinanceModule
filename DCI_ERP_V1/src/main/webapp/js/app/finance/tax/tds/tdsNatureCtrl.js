   
'use strict';
     app.controller('tdsNatureListCtrl', function($scope, $rootScope, $http, $location, logger, $log, ngDialog, $modal, utilsService,$filter,sharedProperties,$state,$injector,$stateParams) {

         $scope.pageCounters = [ 10,15, 25, 50, 75, 100, 125,150 ];
         $scope.index=[];
         $scope.checked = [];
         var index="";
         $scope.itemsByPage = 10;
         $scope.hideUploadIcon=true;
       
         //Add
         $scope.add = function(){
             $state.go('app.finance.tax.tds.tdsnature.add',{tenantid:$stateParams.tenantid});
         };
         $scope.edit = function(natureCode){
             $state.go('app.finance.tax.tds.tdsnature.edit',{natureCode:natureCode});
         };
         $scope.tdsNature={
                 natureCode:'',
                 nature:'',
                 section:'',
                 companyTax:'',
                 companySurcharge:'',
                 companyEduCess:'',
                 individualTax:'',
                 individualSurcharge:'',
                 individualEduCess:''
             }
                 
         $scope.getTdsNatureList = function() {
             $scope.dataLoopCount = 0;
             $scope.showEmptyLabel = false;
             $scope.from = 0;
             $scope.to = 100;
             $scope.rowCollection = [];

             var url = $stateParams.tenantid+'/app/tdsnature/list';
             $http.get(url).success(function(data) {
                 console.log(data);
                     $scope.rowCollection = $scope.rowCollection.concat(data);
             });
         };

         $scope.getTdsNatureList();
         
         
         $scope.deleteTdsNature=function(natureCode,index){
             ngDialog.openConfirm().then(function() { 
             var url=$stateParams.tenantid+'/app/tdsnature/deleteTdsNature?natureCode='+natureCode;
             $http.get(url).success(function(success){
                 if(success){
                     logger.logSuccess("TDS Nature deleted successfully");
                     $scope.rowCollection.splice(index,1);
                 }else{
                     logger.logError("Error Please Try Again");
                 }
             }).error(function(data) {
                 logger.logSuccess("Error in Delete!");
             });
             }, function(reason) {
                 console.log('Modal promise rejected. Reason: ', reason);
             });
         }; 
        
         
    });


     app.controller('tdsNatureAddCtrl', function($scope, $rootScope, $http, $location, logger, $log, ngDialog, $modal, utilsService,$filter,sharedProperties,$state,$injector,$stateParams) {

         $scope.tdsNature={
                 natureCode:'',
                 nature:'',
                 section:'',
                 companyTax:'',
                 companySurcharge:'',
                 companyEduCess:'',
                 individualTax:'',
                 individualSurcharge:'',
                 individualEduCess:'',
                 accountHeadCode:''
             }
         $scope.isEdit=false;
         
         
         $scope.getDropDown = function() {          
             var url = $stateParams.tenantid+'/app/tdstax/getDropDown';
             $http.get(url).success(function(data) {
            	 debugger
                 console.log(data);
                 if(data.success){
                     //$scope.vendorList = data.vendorList;
                     //$scope.tdsNatureList = data.tdsNatureList;
                     //$scope.currencyList = data.currencyList;
                     $scope.accountHeadList = data.accountHeadList;
                 }
                 
             });
         };
         $scope.getDropDown ();
         
         var $validationProvider = $injector.get('$validation');
         $scope.checkValid = $validationProvider.checkValid;
         $scope.submit = function(tdsNatureForm) {
             sharedProperties.clearObject();
             $validationProvider.validate(tdsNatureForm).success($scope.success).error($scope.error);

         };
         $scope.success = function(message) {
           
             $scope.save();
           
         };
         $scope.error = function(message) {
            // toaster.pop('error', "Please correct the errors", logger.getErrorHtml(sharedProperties.getErrorObject()), 555000, 'trustedHtml');
             logger.logError('Please correct the errors'+ logger.getErrorHtml(sharedProperties.getErrorObject()));
         };
         
         $scope.save = function() {
             console.log("save");
             if($scope.tdsNature.accountHeadCode != null && $scope.tdsNature.accountHeadCode != undefined && $scope.tdsNature.accountHeadCode != ''){
            	 $http.post($stateParams.tenantid+'/app/tdsnature/save', $scope.tdsNature).success(function(result) {
                     if(result.success) {
                         logger.logSuccess("Saved successfully!");
                         $location.path($stateParams.tenantid+'/tds/tdsnature/list');
                     } else {
                         logger.logError("Record Not Saved!");
                     }
                 }).error(function(result) {
                     console.log("data" + result);
                 });
             }else{
            	 logger.logError("Select Account Head");
             }
                 
         };
         $scope.cancel = function() {
             $location.path($stateParams.tenantid+"/tds/tdsnature/list");
         };
    });

     app.controller('tdsNatureEditCtrl', function($scope, $rootScope, $http, $location, logger, $log, ngDialog, $modal, utilsService,$filter,sharedProperties,$state,$stateParams) {

         $scope.tdsNature={
                 natureCode:'',
                 nature:'',
                 section:'',
                 companyTax:'',
                 companySurcharge:'',
                 companyEduCess:'',
                 individualTax:'',
                 individualSurcharge:'',
                 individualEduCess:'',
                 accountHeadCode:''
             }
         $scope.isEdit=true;
         $scope.edit = function() {
             console.log("edit");
                 $http.get($stateParams.tenantid+'/app/tdsnature/edit?natureCode='+$stateParams.natureCode).success(function(result) {
                     $scope.tdsNature=result;
                     console.log(result);
                 }).error(function(result) {
                     console.log("data" + result);
                 });
         };
         $scope.edit();
         
         $scope.getDropDown = function() {          
             var url = $stateParams.tenantid+'/app/tdstax/getDropDown';
             $http.get(url).success(function(data) {
                 console.log(data);
                 if(data.success)
                    
                     $scope.vendorList = data.vendorList;
                     $scope.tdsNatureList = data.tdsNatureList;
                     $scope.currencyList = data.currencyList;
                     $scope.accountHeadList = data.accountHeadList;
             });
         };
         $scope.getDropDown ();
         
         $scope.update = function() {
             console.log("save");
             if($scope.tdsNature.accountHeadCode != null && $scope.tdsNature.accountHeadCode != undefined && $scope.tdsNature.accountHeadCode != ''){
            	 $http.post($stateParams.tenantid+'/app/tdsnature/update', $scope.tdsNature).success(function(result) {
                     if(result.success) {
                         logger.logSuccess("Update successfully!");
                         $state.go('app.finance.tax.tds.tdsnature.list');
                         $location.path($stateParams.tenantid+'tds/tdsnature/list');
                     } else {
                         logger.logError("Record Not Update!");
                     }
                 }).error(function(result) {
                     console.log("data" + result);
                 });
             }else{
            	 logger.logError("Select Account Head");
             }
                 
         };
         
         $scope.cancel = function() {
             $location.path($stateParams.tenantid+"/tds/tdsnature/list");
         };
    });



