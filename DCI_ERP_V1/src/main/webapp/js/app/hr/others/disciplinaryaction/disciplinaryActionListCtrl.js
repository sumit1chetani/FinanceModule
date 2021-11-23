//define([ 'hrms/hr/hr' ], function(module) {
    'use strict';
    app.Controller('disciplinaryActionListCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService) {
        $scope.rowCollection = [];
        $scope.isDelete = true;
        $scope.isUpload = true;
        $scope.cancel = function() {
            $state.go('app.hrms.hr.others.disciplinaryaction.list');
        };

        $scope.add = function() {
            $state.go("app.hr.disciplinary.add");
        }

        $scope.editRow = function(disciplinary_proceedings_sk) {
            $location.path('/hrms/hr/others/disciplinaryaction/edit/' + disciplinary_proceedings_sk);
        }

        $scope.getDisciplinaryList = function() {
            $http.get('hrms/hr/others/disciplinaryaction/list').success(function(response) {
                $scope.rowCollection = response.disciplinaryList;
            });
        }

        $scope.getDisciplinaryList();

        $scope.deleteRow = function(disciplinary_proceedings_id, index) {

            var myURL = 'hrms/hr/others/disciplinaryaction/delete';
            $http({
                method : 'post',
                url : myURL,
                data : disciplinary_proceedings_id,
            }).success(function(data) {
                if (data == true) {
                    var tableData = $scope.rowCollection;
                    $scope.rowCollection.splice(index, 1);
                    logger.logSuccess("Deleted successfully");
                    $state.reload();
                } else {
                    logger.logError("Error in delete!");
                }
            }).error(function(data) {
                logger.logSuccess("Error in Delete!");
            });
        }

    });

//});
