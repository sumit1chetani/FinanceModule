/**
 * 
 */'use strict';
app.controller('staffMasterCtrl', function($scope, $rootScope, $http, $location, logger, utilsService,$state,sharedProperties,$window,ngDialog,toaster, $stateParams) {

        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        
       
        $scope.add = function() {
            $state.go('app.finance.staffMaster.add');    
        };

       
        $scope.getList = function() {
            var url = $stateParams.tenantid+'/app/staffmaster/list?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount;
            $http.get(url).success(function(data) {
                if (data.success == true && !utilsService.isUndefinedOrNull(data.listBean)) {
                    $scope.rowCollection = $scope.rowCollection.concat(data.listBean);
                    sharedProperties.setObject($scope.emptyObject);
                }
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
            $scope.offsetCount = $scope.offsetCount + $scope.limitCount;
        };

        $scope.getList();
        
        
        $scope.deleteRow = function(deptCode) {
            ngDialog.openConfirm().then(function() {
            
                var url = $stateParams.tenantid+'/app/staffmaster/delete?companyCode=' + deptCode;
                $http.get(url).success(function(result){
                    if (result ==  true) {
                        logger.logSuccess("Deleted successfully");
                        $state.reload();
                   } else {
                        logger.logError("You Can't Delete this Record, Related Data Exist!");
                    }
                }).error(function(result) {
                    logger.logError("Error Please Try Again");
                });
            }, function(reason) {
                console.log('Modal promise rejected. Reason: ', reason);
            });
        };
        
        
        $scope.editRow = function(deptCode) {
            $location.url($stateParams.tenantid+'/finance/staffMaster/edit?companyCode='+deptCode);
        };
        
        $scope.view = function(deptCode) {
            $location.url('/finance/staffMaster/edit?companyCode='+deptCode);
        };
        
    });

