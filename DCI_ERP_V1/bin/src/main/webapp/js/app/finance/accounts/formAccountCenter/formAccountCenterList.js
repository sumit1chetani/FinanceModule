define([ 'hospital/accounts/accounts' ], function(module) {

    'use strict';
    module.registerController('formAccountCenterList', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {

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
            var url = 'app/tds/list?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount;
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
            $state.go("app.hospital.accounts.formAccountCenter.add");
        };

        
        
        
       $scope.editRow = function(tdsauto) {

//            $state.go("app.hospital.accounts.bankCompanymapping.Add",{'accCode':accCode});      
           $location.url('/hospital/accounts/formAccountCenter/edit?tdsauto=' + tdsauto);
           
       
       };
        
       
        

        
   /////////////////delete///////////     
        $scope.deleteRow = function(tdsauto, index) {

            ngDialog.openConfirm().then(function() {
                var myURL = 'app/tds/delete?tdsauto='+tdsauto;
                $http({
                    method : 'post',
                    url : myURL,
                    data : tdsauto,
                }).success(function(data) {
                    if (data == true) {

                        $scope.rowCollection.splice(index, 1);
                
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

     

    });

});