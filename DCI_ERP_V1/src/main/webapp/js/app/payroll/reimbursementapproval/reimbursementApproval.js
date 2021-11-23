define([ 'payroll/payroll/payroll' ], function(module) {
    'use strict';
    module.registerController('reimbursementApprovalCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {

        $scope.reimbursementApproval = {
            departmentId : '',
            reimbursementTypeId : '',
            reimbusementName : '',
            currencyName : '',
            currencyCode : '',
            branchId : '',
            companyId : '',
            companyName : '',
            branchName : '',
            employeeId : '',
            employeeName : '',
            paymentMode : '',
            amount : '',
            departmentName : '',
            fileName : '',
            status : '',
            description : '',
            requestedby : '',
            requesteddate : '',
            reimbursementId : '',
            approvalempId : '',
            approvedDate : '',
            isEdit : false
        };

        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.isDisplay = true;

        $scope.isAdd = true;
        $scope.isDelete = true;
        $scope.isUpload = true;

        $scope.getList = function() {
            $scope.reimbursementApproval.status = "1";
            $http.post("payroll/payroll/reimbursementreq/list", $scope.reimbursementApproval.status).success(function(response) {
                $scope.rowCollection = response.reimbursementList;
            });
        };
        $scope.getList();

        $scope.exportExcel = function() {
            var resultBean = {
                status : 1
            }
            $http.post('payroll/payroll/reimbursementreq/exportExcel', resultBean).success(function(data) {
                if (data.success == true) {
                    logger.logSuccess("File Exported Successfully");
                    $('#btnRowDivId').append('<a id="captainMsglink" href="tempdoc/Reimbursement.xls" class="control-label" download="Reimbursement.xls"></a>');
                    $("#captainMsglink").bind('click', function() {
                    });
                    $('#captainMsglink').simulateClick('click');
                } else {

                    logger.logError("Error Please Try Again")

                }
            }).error(function(data) {
            });

        };

        $.fn.simulateClick = function() {
            return this.each(function() {
                if ('createEvent' in document) {
                    var doc = this.ownerDocument, evt = doc.createEvent('MouseEvents');
                    evt.initMouseEvent('click', true, true, doc.defaultView, 1, 0, 0, 0, 0, false, false, false, false, 0, null);
                    this.dispatchEvent(evt);
                } else {
                    this.click(); // IE
                }
            });
        }

        $scope.downloadfile = function() {
            $("#tbPdfExport").bind('click', function() {
            });
            $('#tbPdfExport').simulateClick('click');
        }

        $scope.showList = function(status) {

            $http.post("payroll/payroll/reimbursementreq/list", status).success(function(response) {
                $scope.rowCollection = response.reimbursementList;
            });
        };

        $scope.editRow = function(reimbursementId) {
            $location.url('/payroll/reimbursementapproval/edit?reimbursementId=' + reimbursementId);
        };
        $scope.cancel = function() {
            $state.go('app.payroll.payroll.reimbursementapproval.list');
        };
    });
});