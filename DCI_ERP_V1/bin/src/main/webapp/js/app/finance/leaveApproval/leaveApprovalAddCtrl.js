'use strict';
app.controller('leaveApprovalAddCtrl', function($scope, $state, $stateParams, $http, logger, toaster, validationService ,$location){

    var leaveRequestId = $location.search().leaveRequestId;

   // var leaveRequestId = $stateParams.leaveRequestId;
    $scope.leaveAppCancel = {
        leaveRequestId : '',
        leaveType : '',
        dateFrom : '',
        dateTo : '',
        reason : '',
        appliedOn : '',
        halfFrom : '',
        halfTo : '',
        firstName : '',
        action : '',
        status : '',
        descrip : '' ,
        stepOrder:'',

    };

    var url = $stateParams.tenantid+'/finance/leaveapp/getEdit?leaveRequestId=' + leaveRequestId;
    $http.get(url).success(function(result) {
        $scope.leaveAppCancel.leaveRequestId = result.leaveRequestId;
        $scope.leaveAppCancel.firstName = result.firstName;
        $scope.leaveAppCancel.appliedOn = result.appliedOn;
        $scope.leaveAppCancel.leaveType = result.leaveType;
        $scope.leaveAppCancel.dateFrom = result.dateFrom;
        $scope.leaveAppCancel.dateTo = result.dateTo;
        $scope.leaveAppCancel.halfFrom = result.halfFrom;
        $scope.leaveAppCancel.halfTo = result.halfTo;
        $scope.leaveAppCancel.reason = result.reason;
        $scope.leaveAppCancel.action = result.action;
        $scope.leaveAppCancel.descrip = result.descrip
        $scope.leaveAppCancel.status = result.status;

        if (result.status == "Approved") {
            $('#status').attr("disabled", true);
        }
        if (result.status == "Cancelled") {
            $('#status').attr("disabled", true);
        }
        $scope.leaveAppCancel.edit = result.edit;

    });

    $scope.update = function(leaveAppCancel, leaveApproveAddForm) {

    	  $scope.leaveAppCancel.stepOrder = $location.search().stepOrder;
        if (new validationService().checkFormValidity(leaveApproveAddForm)) {
            $http.post($stateParams.tenantid+'/finance/leaveapp/update', $scope.leaveAppCancel).success(function(response) {
                if (response == true) {
                    logger.logSuccess("Update Successfully!");
                    $state.go("app.hr.leaveApproval.list",{tenantid:$stateParams.tenantid});
                } else {
                    logger.logError("Not Updated!");
                }
            }).error(function(result) {
            });
        } else {
            toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(leaveApproveAddForm.$validationSummary), 555000, 'trustedHtml');
        }

    }

    $scope.cancel = function() {
        $state.go("app.hr.leaveApproval.list",{tenantid:$stateParams.tenantid});
        
    }

});
