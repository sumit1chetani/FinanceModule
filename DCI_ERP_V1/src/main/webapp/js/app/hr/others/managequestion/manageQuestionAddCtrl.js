define([ 'hrms/hr/hr' ], function(module) {
    'use strict';
    module.registerController('manageQuestionAddCtrl', function($scope, $state, $http, ngDialog, logger, $stateParams, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService) {
        $scope.rowCollection = [];
        $scope.cancel = function() {
            $state.go('app.hrms.hr.others.managequestion.list');
        };

        $scope.question = {
            question_id : '',
            question_desc : '',
            status : '',
        }
        $scope.reset = function() {
            $scope.question.question_desc = '';
            $scope.question.status = '';
        }

        $scope.getAutoGenarateNumber = function() {
            $http.get('hrms/hr/others/managequestion/getAutoGenarateNumber').success(function(response) {
                $scope.question.question_id = response.question_id;
            });
        }
        $scope.getAutoGenarateNumber();

        $scope.submit = function(QuestionMasterForm, question) {
            if (new validationService().checkFormValidity(QuestionMasterForm)) {
                $scope.save(question);
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.QuestionMasterForm.$validationSummary), 5000, 'trustedHtml');
            }
        };

        $scope.save = function(question) {
            var jsonData = {
                'questionData' : question,
            }
            $http.post('hrms/hr/others/managequestion/save', jsonData).success(function(data) {
                if (data) {
                    logger.logSuccess("Question Successfully Added!");
                    $state.go('app.hrms.hr.others.managequestion.list');

                } else {
                    logger.logError("Error Not Saved!");
                }
            }).error(function(data) {
                logger.logSuccess("Error Not Savedd!");
            });

        }

    });
    module.registerController('manageQuestionEditCtrl', function($scope, $state, $http, ngDialog, logger, $stateParams, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService) {
        $scope.rowCollection = [];
        $scope.cancel = function() {
            $state.go('app.hrms.hr.others.managequestion.list');
        };
        $scope.questionObj = {
            edit : true
        };

        $scope.question = {
            question_id : '',
            question_desc : '',
            status : '',
        }

        var id = $stateParams.id;
        if (id == undefined) {
            $scope.questionObj.edit = false;
        } else {
            $scope.questionObj.edit = true;
            $http.get('hrms/hr/others/managequestion/getQuestionDataEdit?questionId=' + id).success(function(result) {
//                alert("hai");
                // alert(JSON.stringify(result));
                $scope.question.question_id = result.question_id;
                $scope.question.question_desc = result.question_desc;
                $scope.question.status = result.status;
                $scope.question.id = result.id;

            }).error(function(data) {

            });
        }

        $scope.submit = function(QuestionMasterForm, question) {
            if (new validationService().checkFormValidity(QuestionMasterForm)) {
                $scope.update(question);
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.QuestionMasterForm.$validationSummary), 5000, 'trustedHtml');
            }

        };
        $scope.update = function(question) {

            debugger;
            var jsonData = {
                'questionData' : question,
            }
            $http.post('hrms/hr/others/managequestion/update', jsonData).success(function(data) {
                if (data) {
                    logger.logSuccess("Question Successfully Updated!");
                    $state.go('app.hrms.hr.others.managequestion.list');

                } else {
                    logger.logError("Error Not Saved!");
                }
            }).error(function(data) {
                logger.logSuccess("Error Not Saved!");
            });
        }

        $scope.reset = function() {
            $state.reload();
        }

    });

});
