define([ 'hospital/asset/asset' ], function(module) {

    'use strict';
    
    module.registerController('assetMaintenanceTypeListCtrl', function($scope, $state, $http, ngDialog, logger, 
            $location, $controller, $injector, sharedProperties, toaster, $rootScope,$stateParams,$filter,validationService) {
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.isUpload = true;
        $scope.numPages=0
       
        $scope.getList = function(){
            $http.get("hospital/asset/assetMaintenance/list")
            .success(function(response) {
                $scope.rowCollection = response.assetList;
            });
        };
        $scope.getList();
        
        //Add functionality
        $scope.add = function(){
            $scope.callDialog($scope, 0, $http, ngDialog, logger,$injector, sharedProperties, toaster,$rootScope);
        };
        
        
        
        //Edit functionality
        $scope.editRow = function(collection) {
            $scope.callDialog($scope, collection.assetId, $http, ngDialog, logger,$injector, sharedProperties, toaster,$rootScope);
        };
        
        //Delete functionality
        $scope.deleteRow = function(collection) {
          ngDialog.openConfirm().then(function() {
                $http.post("hospital/asset/assetMaintenance/delete",collection.assetId)
                .success(function(response) {
                   if(response.success == true){
                       logger.logSuccess("Deleted successfully!");
                       $scope.getList();
                   }else
                       logger.logError("You can't delete this record,Deletion Failed");
                }).error(function(result) {
                    logger.logError("Error Please Try Again");
                });
            });
        };
        
        $scope.callDialog = function($scope, assetId, $http, ngDialog, logger,$injector, sharedProperties, toaster,$rootScope){
            ngDialog.open({
                scope: $scope,
                template: 'views/hospital/asset/assetMaintenanceType/assetMaintenanceTypeAdd',
                controller: $controller('assetMaintenanceAddCtrl', {
                    $scope: $scope,
                    assetId: assetId,
                    $http:$http,
                    ngDialog:ngDialog,
                    logger:logger,
                    $injector:$injector, 
                    sharedProperties:sharedProperties, 
                    toaster:toaster,
                    $rootScope:$rootScope,
                    validationService:validationService
                }),
                className: 'ngdialog-theme-plain',
                showClose: false,
                closeByDocument: false,
                closeByEscape: false,
                preCloseCallback : $scope.getList
            });
        }
    });
    module.registerController('assetMaintenanceAddCtrl', function($scope, $state, $http, ngDialog, logger, assetId,
              $injector, sharedProperties, toaster, $rootScope,validationService) {
       
        
        $scope.assetMaintenance = {
                assetId : '',
                assetCode : '',
                assetName : '',
                description : '',
                active : false,
                
        };
        $scope.isEdit = false;
       
        //Edit functionality
        if(assetId != 0){
            var assetId1 = assetId;
            $scope.isEdit = true;
            $http.post("hospital/asset/assetMaintenance/edit",assetId)
            .success(function(response) {
                if(response){
                   $scope.assetMaintenance = response;
                }
            });
        }
        
        //Save functionality
        
        $scope.save = function(assetMaintenanceForm) {
            debugger;
            if (new validationService().checkFormValidity(assetMaintenanceForm)) {
                $http.post("hospital/asset/assetMaintenance/save", $scope.assetMaintenance).success(function(response) {
                    if (response == true) {
                        logger.logSuccess("Saved successfully!");
                        ngDialog.close();
                        $state.go("app.hospital.asset.assetMaintenance.list");
                    } else {
                        logger.logError("Asset Name Already Exists!");
                    }
                });
            }else {
                toaster.pop('error', "Please fill the required fields", 
                        logger.getErrorHtmlNew(assetMaintenanceForm.$validationSummary), 555000, 'trustedHtml');
            }
        };
       
        //Update functionality
        $scope.update = function(assetMaintenanceForm){ 
            if (new validationService().checkFormValidity(assetMaintenanceForm)) {
            $scope.assetMaintenance.assetId = assetId1;
            var assetMaintenance = $scope.assetMaintenance;  
            if ($scope.isEdit == true) { 
                $http.post('hospital/asset/assetMaintenance/update', assetMaintenance).success(function(result) {
                    if (result) {
                        logger.logSuccess("Updated successfully!");
                        ngDialog.close();
                    } else {
                        logger.logError("Asset Name already Exist!");
                    }
                }).error(function(result) {
                    console.log("data" + result);
                });
            } 
            }else {
                toaster.pop('error', "Please fill the required fields", 
                        logger.getErrorHtmlNew(assetMaintenanceForm.$validationSummary), 555000, 'trustedHtml');
            }
        };
        
        //Reset functionality
        $scope.reset = function(assetMaintenanceForm){
            if($scope.isEdit){
                $http.post("hospital/asset/assetMaintenance/edit",assetId)
                .success(function(response) {
                    if(response){
                        $scope.assetMaintenance = response;
                     }
                });
            }
            else{
                $scope.assetMaintenance.assetCode = '';
                $scope.assetMaintenance.assetName = '';
                $scope.assetMaintenance.description = '';
                $scope.assetMaintenance.active = false;
            }
        };
        
        $scope.cancel = function() {
            ngDialog.close();
        };
        
    });
});
