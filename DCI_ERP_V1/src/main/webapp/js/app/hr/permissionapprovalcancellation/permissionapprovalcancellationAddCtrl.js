'use strict';
app.controller('permissionapprovalcancellationAddCtrl', function($stateParams,$scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService) {
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;

    $scope.numPages = 0

    $scope.cancel = function() {
        $state.go('app.hr.permissionapprovalcancellation.list');
    };

    $scope.PermissionApprovalData = {
        permissionrequestid : '',
        requestedby : '',
        permissiondate : '',
        requesteddate : '',
        reason : '',
        fromtime : '',
        totime : '',
        status : '',
        remarks : '',
        empId : '',
        edit : false
    };

    var id = $location.search().id;
    var myURL = $stateParams.tenantid+'app/permissionrequestapproval/edit';
    $http({
        url : myURL,
        data : id,
        method : 'post',
        dataType : 'json',
        headers : {
            'Accept' : 'application/json',
            'Content-Type' : 'application/json'
        }
    }).success(function(result) {
        $scope.PermissionApprovalData.permissionrequestid = result.permissionrequestid;
        $scope.PermissionApprovalData.requestedby = result.requestedby;
        $scope.PermissionApprovalData.permissiondate = result.permissiondate;
        $scope.PermissionApprovalData.requesteddate = result.requesteddate;
        $scope.PermissionApprovalData.reason = result.reason;
        $scope.PermissionApprovalData.fromtime = result.fromtime;
        $scope.PermissionApprovalData.totime = result.totime;
        $scope.PermissionApprovalData.remarks = result.remarks;
        $scope.PermissionApprovalData.status = result.status;
        if (result.status == "Approved") {
            $('#status').attr("disabled", true);
            $('#remarks').attr("disabled", "disabled");
        }
        if (result.status == "Cancelled") {
            $('#status').attr("disabled", true);
            $('#remarks').attr("disabled", "disabled");
        }
        $scope.PermissionApprovalData.edit = result.edit;

    }).error(function(data) {
    });

    // Injector

    // Save
    $scope.update = function(PermissionApprovalData, permissionrequestapprovalForm) {
        sharedProperties.clearObject();
        var PermissionApprovalData = $scope.PermissionApprovalData;
        if (PermissionApprovalData.edit == true) {
            var updateRowData = PermissionApprovalData;
            if (new validationService().checkFormValidity(permissionrequestapprovalForm)) {
                $http.post($stateParams.tenantid+'app/permissionrequestapproval/update', updateRowData).success(function(result) {
                    if (result) {
                        logger.logSuccess("Updated Successfully!");
                        $state.go('app.hr.permissionapprovalcancellation.list');
                    } else {
                        logger.logError("Permission Approval/Cancel Update Failed!");
                    }
                }).error(function(result) {
                });
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(permissionrequestapprovalForm.$validationSummary), 5000, 'trustedHtml');
            }
        }
    };

    $scope.reset = function() {
        $scope.PermissionApprovalData.remarks = '', $scope.PermissionApprovalData.status = ''
        if (id != 0) {
            $scope.isEdit = true;
            $http.post($stateParams.tenantid+"app/permissionrequestapproval/edit", id).success(function(result) {
                if (result.success == true) {
                    $scope.PermissionApprovalData.remarks = result.remarks;
                    $scope.PermissionApprovalData.status = result.status;
                    $scope.PermissionRequestData.edit = result.edit;
                }
            });
        }
    };

});
