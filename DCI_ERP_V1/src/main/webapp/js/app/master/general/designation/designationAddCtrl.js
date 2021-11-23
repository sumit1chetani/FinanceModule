'use strict';
app.controller('designationAddCtrl', function($scope,$stateParams, $rootScope, $http, $location, logger, utilsService, $state, sharedProperties, $window, validationService, toaster) {

    $scope.designationData = {
        desgnCode : '',
        desgnName : '',
        desgnDesc : '',
        isActive : 'Y'
    };

    $scope.viewDisable = true;

    $scope.desgnList = [];

    $scope.cancel = function() {
        $state.go('app.truck.general.designation',{tenantid:$stateParams.tenantid});
    };

    $scope.designationValidateData = {
        isEdit : false
    }

    $scope.getDropdownvalue = function() {
        $http.get($stateParams.tenantid+'/app/designation/getDesignation').success(function(datas) {
            $scope.desgnList = datas;
        }).error(function(datas) {
        });
    }
    $scope.getDropdownvalue();

    $scope.save = function(designationAddForm, designationData, designationValidateData) {
        $scope.submitted = true;
        if (new validationService().checkFormValidity($scope.designationAddForm)) {
            var addRowData = designationData;
            $http.post($stateParams.tenantid+'/app/designation/add', addRowData).success(function(result) {
                console.log("result" + result);
                if (result) {
                    logger.logSuccess("Saved successfully!");
                    $state.go('app.truck.general.designation',{tenantid:$stateParams.tenantid});
                } else {
                    logger.logError("Designation Name Already Exists!");
                }
            }).error(function(result) {
                console.log("data" + result);
            });

        } else {
            toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.designationAddForm.$validationSummary), 555000, 'trustedHtml');
        }
    };

    $scope.update = function(designationAddForm, designationData, designationValidateData) {
        if (new validationService().checkFormValidity($scope.designationAddForm)) {
            var desgnCode = $location.search().desgnCode;
            $scope.designationData.desgnCode = $location.search().desgnCode;
            var updateRowData = designationData;
            $http.post($stateParams.tenantid+'/app/designation/update', updateRowData).success(function(result) {
                if (result) {
                    logger.logSuccess("Updated successfully!");
                    $state.go('app.truck.general.designation',{tenantid:$stateParams.tenantid});
                } else {
                    logger.logError("Designation Name Already Exists!!");
                }
            }).error(function(data) {
                console.log("data" + data);
            });

        } else {

            toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.designationAddForm.$validationSummary), 555000, 'trustedHtml');
        }
    }

    $scope.isEdit = false;
    var desgnCode = $location.search().desgnCode;
    if (desgnCode == undefined) {
        var desgnName = $scope.designationData.desgnName;
        var desgnDesc = $scope.designationData.desgnDesc;
        var isActive = $scope.designationData.isActive;
        $scope.designationData.isEdit = false;
    } else {
        $http.post($stateParams.tenantid+'/app/designation/edit', desgnCode).success(function(result) {

            if (result.isEdit == false) {
                logger.logError("Please Try Again");
            } else {
                console.log("result");
                console.log(result);

                $scope.designationData.desgnName = result.desgnName;
                $scope.designationData.isActive = result.isActive;
                $scope.designationValidateData.isEdit = true;
                $scope.designationData.isEdit = true;
            }
        }).error(function(data) {
            console.log("data" + data);
        });
    }
});