
'use strict';
app.controller('permissionReqEditCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope,$stateParams) {
	 $scope.offsetCount = 0;
     $scope.limitCount = 1000;
     $scope.rowCollection = [];
     $scope.displayedCollection = [];
     $scope.itemsByPage = 10;
     $scope.numPages = 0
     
     // Cancel
     $scope.cancel = function() {
         $location.url($stateParams.tenantid+'/hr/permissionReq/list');
     };

     $scope.PermissionRequestData = {

         permissiondate : '',
         permissionrequestid:'',
         userId : '',
	        userName : '',
         hoursfrom : '',
         hoursto : '',
         reason : '',
         edit : false
     };

     $scope.isEdit = false;
     var permissionrequestid = $location.search().permissionrequestid;
     if(permissionrequestid != undefined && permissionrequestid != ''){
         $scope.isEdit = true;
         $http.post($stateParams.tenantid+"app/permissionrequest/edit",permissionrequestid)
         .success(function(response) {
            if(response){
                $scope.permissionRequestData = response;
                $scope.permissionRequestData.userId = response.employeeno;


            }else{
                if(response.message != ''){
                    logger.logError(response.message);
                }
            }
         });
     }

     $scope.update = function(permissionRequestData, permissionrequestForm) {
         debugger
             $http.post($stateParams.tenantid+"app/permissionrequest/update", $scope.permissionRequestData).success(function(result) {
                 if (result) {
                     logger.logSuccess("update Successfully!");
                     $location.url($stateParams.tenantid+'/hr/permissionReq/list');
                     $scope.permissionRequestData.permissionrequestid=permissionrequestid;
                 } else {
                     logger.logError("Permission Date Already Exist! / It Is HoliDay!");
                 }
             });
         
     };
     $scope.submit = function(permissionrequestForm) {
         $validationProvider.validate(permissionrequestForm).success($scope.success).error($scope.error);
     };

     // Injector
     var $validationProvider = $injector.get('$validation');

     // Callback method
     $scope.success = function(message) {
         $scope.update();
     };

     $scope.error = function(message) {
         logger.logErrorHtml(sharedProperties.getErrorObject());
     };

     $scope.reset = function() {
         $scope.PermissionRequestData.hoursfrom = '', $scope.PermissionRequestData.hoursto = '', $scope.PermissionRequestData.reason = ''

     };

 });

