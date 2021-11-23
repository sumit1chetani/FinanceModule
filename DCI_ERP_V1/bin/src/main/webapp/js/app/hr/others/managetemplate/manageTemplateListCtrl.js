define([ 'hrms/hr/hr' ], function(module) {
    'use strict';

    module.registerController('manageTemplateListCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService) {
        $scope.rowCollection = [];
        $scope.isDelete = true;
        $scope.isUpload = true;
        $scope.add = function() {
            $state.go("app.hrms.hr.others.managetemplate.add");
        }

        $scope.cancel = function() {
            $state.go('app.hrms.hr.others.managetemplate.list');
        };

        $scope.editRow = function(id) {
            $location.path('/hrms/hr/others/managetemplate/edit/' + id);
        }

        $scope.getTemplateList = function() {
            $http.get('hrms/hr/others/managetemplate/list').success(function(response) {
                $scope.rowCollection = response.templateList;
            });
        }
        $scope.getTemplateList();

        $scope.deleteRow = function(tempid, index) {
            var myURL = 'hrms/hr/others/managetemplate/delete';
            $http({
                method : 'post',
                url : myURL,
                data : tempid,
            }).success(function(data) {
                if (data == true) {
                    var tableData = $scope.rowCollection;
                    $scope.rowCollection.splice(index, 1);
                    logger.logSuccess("Deleted successfully");
                    $state.reload();
                } else {
                    logger.logError("Unable to delete this Record");
                }
            }).error(function(data) {
                logger.logSuccess("Error in Delete!");
            });
        }
    });

});