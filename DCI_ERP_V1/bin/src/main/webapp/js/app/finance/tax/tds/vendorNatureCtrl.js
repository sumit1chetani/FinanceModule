   
'use strict';
     app.controller('vendorNatureListCtrl', function($scope, $rootScope, $http, $location, logger, $log, ngDialog, $modal, utilsService,$filter,sharedProperties,$state,$stateParams) {

         $scope.pageCounters = [ 10,15, 25, 50, 75, 100, 125,150 ];
         $scope.index=[];
         $scope.checked = [];
         var index="";
         $scope.itemsByPage = 10;
         $scope.hideUploadIcon=true;
       
         //Add
         $scope.add = function(){
             $state.go('app.finance.tax.tds.vendornature.add',{tenantid:$stateParams.tenantid});
         };
         $scope.edit = function(natureCode){
             $state.go('app.finance.tax.tds.vendornature.edit',{natureCode:natureCode});
         };
         $scope.vendorNature={
               vendorNatureCode:'',
               vendorName:'',
               vendorCode:'',
               tdsNatureCode:'',
               tdsNature:'',
               tdsNatureType:'',
               description:'',
               userId:''
             }
                 
         $scope.getTdsNatureList = function() {
             $scope.dataLoopCount = 0;
             $scope.showEmptyLabel = false;
             $scope.from = 0;
             $scope.to = 100;
             $scope.rowCollection = [];

             var url = $stateParams.tenantid+'/app/vendornature/list';
             $http.get(url).success(function(data) {
                 console.log(data);
                     $scope.rowCollection = $scope.rowCollection.concat(data);
             });
         };
         $scope.getTdsNatureList();
         
         
         $scope.deleteTdsNature=function(natureCode,index){
             ngDialog.openConfirm().then(function() { 
             var url=$stateParams.tenantid+'/app/vendornature/deleteTdsNature?natureCode='+natureCode;
             $http.get(url).success(function(success){
                 if(success){
                     logger.logSuccess("Vendor Nature deleted successfully");
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


     app.controller('vendorNatureAddCtrl', function($scope, $rootScope, $http, $location, logger, $log, ngDialog, $modal, utilsService,$filter,sharedProperties,$state,$injector,$stateParams) {

         $scope.vendorNature={
                 vendorNatureCode:'',
                 vendorName:'',
                 vendorCode:'',
                 tdsNatureCode:'',
                 tdsNature:'',
                 tdsNatureType:'',
                 description:'',
                 userId:''
               }
         $scope.isEdit=false;
         var $validationProvider = $injector.get('$validation');
         $scope.checkValid = $validationProvider.checkValid;
         $scope.submit = function(vendorNatureForm) {
             sharedProperties.clearObject();
             $validationProvider.validate(vendorNatureForm).success($scope.success).error($scope.error);

         };
         $scope.success = function(message) {
             var msg="";
             if($scope.vendorNature.vendorCode==undefined || $scope.vendorNature.vendorCode==null || $scope.vendorNature.vendorCode==""){
                 msg+="Vendor Name - This should be Required!!"
             }else if($scope.vendorNature.tdsNatureCode==undefined || $scope.vendorNature.tdsNatureCode==null || $scope.vendorNature.tdsNatureCode==""){
                 msg+="Nature - This should be Required!!"
             }
             else if($scope.vendorNature.tdsNatureType==undefined || $scope.vendorNature.tdsNatureType==null || $scope.vendorNature.tdsNatureType==""){
                 msg+="Type - This should be Required!!"
             }
             if(msg!=""){
                 logger.logError('Please correct the errors  <bar>'+ msg);
             }
             else{
             $scope.save();
             }
         };
         $scope.error = function(message) {
            // toaster.pop('error', "Please correct the errors", logger.getErrorHtml(sharedProperties.getErrorObject()), 555000, 'trustedHtml');
             logger.logError('Please correct the errors'+ logger.getErrorHtml(sharedProperties.getErrorObject()));
         };
         
         
         $scope.save = function() {
             console.log("save");
                 $http.post($stateParams.tenantid+'/app/vendornature/save', $scope.vendorNature).success(function(result) {
                     if(result.success) {
                         logger.logSuccess("Saved successfully!");
                         $location.path($stateParams.tenantid+'/tds/vendornature/list');
                     } else {
                         logger.logError("Record Not Saved!");
                     }
                 }).error(function(result) {
                     console.log("data" + result);
                 });
         };

         $scope.getDropDown = function() {          
             var url = $stateParams.tenantid+'/app/vendornature/getDropDown';
             $http.get(url).success(function(data) {
                 console.log(data);
                 if(data.success)
                     $scope.vendorList = data.vendorNatureBean;
                 $scope.tdrNatureList = data.vendorNatureBean1;
             });
         };
         $scope.getDropDown ();
         $scope.cancel = function() {
             $location.path($stateParams.tenantid+"/tds/vendornature/list");
         };
    });

     app.controller('vendorNatureEditCtrl', function($scope, $rootScope, $http, $location, logger, $log, ngDialog, $modal, utilsService,$filter,sharedProperties,$state,$stateParams) {

         $scope.vendorNature={
                 vendorNatureCode:'',
                 vendorName:'',
                 vendorCode:'',
                 tdsNatureCode:'',
                 tdsNature:'',
                 tdsNatureType:'',
                 description:'',
                 userId:''
               }
         $scope.isEdit=true;
         $scope.getDropDown = function() {          
             var url = $stateParams.tenantid+'/app/vendornature/getDropDown';
             $http.get(url).success(function(data) {
                 console.log(data);
                 if(data.success)
                     $scope.vendorList = data.vendorNatureBean;
                 $scope.tdrNatureList = data.vendorNatureBean1;
             });
         };
         $scope.getDropDown ();
         $scope.edit = function() {
             console.log("edit");
                 $http.get($stateParams.tenantid+'/app/vendornature/edit?natureCode='+$stateParams.natureCode).success(function(result) {
                     $scope.vendorNature=result;
                     console.log(result);
                 }).error(function(result) {
                     console.log("data" + result);
                 });
         };
         $scope.edit();
         
         $scope.update = function() {
             console.log("save");
                 $http.post($stateParams.tenantid+'/app/vendornature/update', $scope.vendorNature).success(function(result) {
                     if(result.success) {
                         logger.logSuccess("Update successfully!");
                         $location.path($stateParams.tenantid+'/tds/vendornature/list');
                     } else {
                         logger.logError("Record Not Update!");
                     }
                 }).error(function(result) {
                     console.log("data" + result);
                 });
         };
         
         $scope.cancel = function() {
             $location.path($stateParams.tenantid+"/tds/vendornature/list");
         };
    });



