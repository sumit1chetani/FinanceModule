///define([ 'hospital/accounts/accounts' ], function(module) {

    'use strict';
    app.controller('bankCompanymappingListCtrl', function($scope, $stateParams,$state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {

        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.isUpload = true;
        $scope.isDelete = true;
        $scope.emptyObject = {};

        $scope.getList = function() {
            var url = 'app/bankcompany/list?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount;
            $http.get(url).success(function(data) {
                if (data.success == true) {
                    $scope.rowCollection = $scope.rowCollection.concat(data.lAccountHeadMasterBeanBean);
                    sharedProperties.setObject($scope.emptyObject);
                }
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
            $scope.offsetCount = $scope.offsetCount + $scope.limitCount;
        };

        $scope.getList();
       /* 
        $scope.editRow = function(formCode) {
            $state.go('app.master.form.edit',{'formCode':formCode})    
       };
*/
        $scope.add = function() {
            $state.go("app.finance.accounts.bankCompanymapping.Add");
        };

        
        
        
       $scope.editRow = function(bankCode) {

//            $state.go("app.hospital.accounts.bankCompanymapping.Add",{'accCode':accCode});      
           $location.url(    $stateParams.tenantid +'/hospital/accounts/bankCompanymapping/bankCompanymappingEdit?bankCode=' + bankCode);
           
       
       };
        
        
        /*
        

        $scope.deleteRow = function(bankCode, index) {

            ngDialog.openConfirm().then(function() {
                var myURL = 'app/bankcompany/delete';
                $http({
                    method : 'post',
                    url : myURL,
                    data : accCode,
                }).success(function(data) {
                    if (data == false) {

                        $scope.rowCollection.splice(index, 1);
                        $state.reload();
                        logger.logSuccess("deleted successfully");
                    } else {
                        logger.logError("Error in deleting Record!");
                    }
                }).error(function(data) {
                    logger.logSuccess("Error in Delete!");
                });
            });

        };
        
        
        */
  
       ///////////////////delete ////////
     $scope.deleteRow = function(bankCode, index) {

           ngDialog.openConfirm().then(function() {
               var myURL = 'app/bankcompany/delete?bankCode='+bankCode;
               $http({
                   method : 'post',
                   url : myURL,
                   data : bankCode,
               }).success(function(data) {
                   if (data == true) {

                       $scope.rowCollection.splice(index, 1);
                       $state.reload();
                       logger.logSuccess("deleted successfully");
                   } else {
                       logger.logError("Error in deleting Record!");
                   }
               }).error(function(data) {
                   logger.logSuccess("Error in Delete!");
               });
           });

       };
       
       
       
        
   // });

});