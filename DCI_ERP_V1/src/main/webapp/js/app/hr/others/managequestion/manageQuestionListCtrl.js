define([ 'hrms/hr/hr' ], function(module) {
    'use strict';

    module.registerController('manageQuestionListCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService) {
        $scope.rowCollection = [];
        $scope.isDelete = true;
        $scope.isUpload = true;
        $scope.add = function() {
            $state.go("app.hrms.hr.others.managequestion.add");
        }

        $scope.cancel = function() {
            $state.go('app.hrms.hr.others.managequestion.list');
        };

        
       /* $scope.editRow = function(typeId) {
            $state.go('app.club.groupcreation.edit',{typeId:typeId});
        };
        */
        
       /* 
        $scope.editRow = function(id) {
            $location.path('/hrms/hr/others/managequestion/edit/' + id);
        }
        */
        

        $scope.getQuestionList = function() {
            $http.get('hrms/hr/others/managequestion/list').success(function(response) {
                $scope.rowCollection = response.questionList;
            });
        }
        $scope.getQuestionList();

        
        $scope.editRow = function(id, index) {
            $location.url('/hrms/hr/others/managequestion/edit?candidateId=' + id, index);
        };
             
        $scope.deleteRow = function(disciplinaryCollection) {
            var Id=disciplinaryCollection.id;
            var myURL = 'hrms/hr/others/managequestion/delete';
            $http({
                method : 'post',
                url : myURL,
                data : Id,
            }).success(function(data) {
                if (data == false) {
                    var tableData = $scope.rowCollection;
                    $scope.rowCollection.splice(index, 1);
                    logger.logSuccess("Deleted successfully");
                    $state.reload();
                } else {
                    logger.logError("Unable To delete this Record!");
                }
            }).error(function(data) {
                logger.logSuccess("Error in Delete!");
            });
        }
        
        /*$scope.deleteRow = function(id, index) {
            ngDialog.openConfirm().then(function() {
                    $http.post("app/groupcreation/delete?clubGroupId="+typeId).success(function(response) {
                        if (response.success) {
                                logger.logSuccess("Deleted Succesfully!");
                                $scope.getList();
                        } else {
                            if (response.message != '') {
                                logger.logError(response.message);
                            }
                        }
                    }).error(function(result) {
                        logger.logError("Error Please Try Again");
                    });
            });
        };*/
        
        
        
    });

});