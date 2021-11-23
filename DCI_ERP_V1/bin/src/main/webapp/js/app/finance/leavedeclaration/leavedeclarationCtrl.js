'use strict';
app.controller('leavedeclarationCtrl', function($scope, $rootScope, $http, $location, logger, ngDialog,
        utilsService,$state,sharedProperties,$window,$stateParams) {
    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.leaveDeclareList = [];
    $scope.isUpload = true;
    $scope.isDelete = true;

    $scope.list = function() {

        $http.get($stateParams.tenantid+"/finance/leave/leavelist").success(function(response) {
            $scope.rowCollection = response.leaveDeclareList;
        });

    }
    $scope.list();
    
    $scope.add = function() {
        $state.go('app.hr.leavedeclaration.add');
    };
    $scope.editRow = function(leavedeclaration) {

        // $state.go('app.hr.leavedeclaration.add');
/*        $state.go('app.hr.leavedeclaration.edit', {
            gradeId : leavedeclaration.gradeId,
            year : leavedeclaration.yearValue
            */
            $location.url($stateParams.tenantid+'/hr/leavedeclaration/edit?branchCode='+leavedeclaration.branchCode+'&yearValue='+ leavedeclaration.yearValue)

            
       // });
    };
    $scope.cancel = function() {
        $state.go('app.hr.leavedeclaration.list');
    };

    $scope.deleteRow = function(leavedeclaration, index) {
        ngDialog.openConfirm().then(function() {
            var url = $stateParams.tenantid+'/finance/leave/delete?year=' + leavedeclaration.yearValue + '&gradeId=' + leavedeclaration.gradeId;
            $http.get(url).success(function(data) {
                if (data) {
                    var tableData = $scope.rowCollection;
                    $scope.rowCollection.splice(index, 1);
                    logger.logSuccess("Deleted successfully");
                    $state.go('app.hr.leavedeclaration.list');
                } else {
                    logger.logError("Error in deleting  Leave Declare!");
                }
            }).error(function(data) {
                logger.logError("Error in Delete!");
            });
        });
    }

    $scope.applyLeavesToEmployees = function(displayedCollection) {
        var isCheck = false;
        angular.forEach(displayedCollection, function(value, key) {
            if (value.select == true) {
                isCheck = true;
            }
        });
        var data = {
            'getSelectedGradeList' : displayedCollection,
        }

        var Array = [ "employee_id", "financial_year", "leave_type", "number_of_days" ];

        if (isCheck) {
            $http.post($stateParams.tenantid+'/finance/leave/applyGradeLeavesToEmployees', data).success(function(result) {
                if (result == true) {
                    logger.logSuccess("Applied successfully");
                    $scope.list();
                }
            })
        } else {
            logger.logError("Select Atleast one Value");
        }

    };

});