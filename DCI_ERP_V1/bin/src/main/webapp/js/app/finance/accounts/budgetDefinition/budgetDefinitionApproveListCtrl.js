//define([ 'hospital/accounts/accounts' ], function(module) {

    'use strict';
    app.controller('budgetDefinitionApproveListCtrl', function($scope,$stateParams, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, utilsService) {

        $scope.dataLoopCount = 0;
        $scope.from = 0;
        $scope.to = 100;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.isUpload = true;
        $scope.isDelete = true;

/*$scope.getAllbudgetDefinition = function(){
            
            var budgetDefinitionId = $stateParams.budgetDefinitionId;
            $http.get('app/budgetDefinition/getAllBudgetDefinitionList').success(function(datas) {
             if(datas.success == true)
             {
                 $scope.rowCollection = datas;
             }
             else
                 log.loggerError("Error! Please Try AAgain Later!");
            });
            
            
        }
        
        $scope.getAllbudgetDefinition();*/
        
        

//        $scope.getBudgetListUtil();

        $scope.getBudgetListUtil = function(limit, offset) {
            var start = new Date().getTime();
            var url = 'app/budgetDefinition/getAllBudgetDefinitionList';
            $http.get(url).success(function(data) {
                if (data.success == true) {
                    $scope.pushListUtil(data);
                    $scope.dataLoopCount++;
                } else {
                    if ($scope.dataLoopCount == 0) {
                        $scope.showEmptyLabel = true;
                    }
                    logger.logError("Error Please Try Again");
                }
                var end = new Date().getTime();
                var time = end - start;
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });

        };
        $scope.pushListUtil = function(data) {
            if (utilsService.isUndefinedOrNull(data.allList)) {
                $scope.showEmptyLabel = true;
            } else {
                $scope.rowCollection = $scope.rowCollection.concat(data.allList);
            }
        };

        $scope.getBudgetListUtil();
//        $scope.add = function() {
//            $state.go("app.hospital.accounts.budgetDefinitions.add");
//        };

        $scope.editbudgetdefinition = function(budgetdefinitionId) {
            $location.url($stateParams.tenantid +'/hospital/accounts/budgetDefinitions/edit/'+budgetdefinitionId);
        };

        $scope.view = function(budgetdefinitionId) {
            $location.url($stateParams.tenantid +'/hospital/accounts/budgetDefinitions/view/'+budgetdefinitionId);
        };
//        Approve

        $scope.Approve = function(budgetdefinitionId) {
            $location.url($stateParams.tenantid +'/hospital/accounts/budgetDefinitions/approve/'+budgetdefinitionId);
        };
      
        $scope.deleteAllocation = function(collections, index) {
            ngDialog.openConfirm().then(function() {
                var myURL = 'app/budgetDefinition/delete';
                $http({
                    method : 'post',
                    url : myURL,
                    data : collections,
                }).success(function(data) {
                    if (data.success) {
                        var tableData = $scope.rowCollection;
                        $scope.rowCollection.splice(index, 1);
                        logger.logSuccess("deleted successfully");
                        $scope.getBudgetListUtil();
                        $state.reload();
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