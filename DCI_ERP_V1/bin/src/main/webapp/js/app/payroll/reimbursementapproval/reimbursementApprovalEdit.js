define([ 'payroll/payroll/payroll' ], function(module) {
'use strict';
module.registerController('reimbursementeditCtrl', function($scope,$state,$http,ngDialog, logger,$location,$controller,$injector, sharedProperties, toaster,$rootScope)  {

    $scope.reimbursementApproval= {
            departmentId:'',
            reimbursementTypeId:'',
            reimbusementName:'',
            currencyName:'',
            currencyCode:'',
            branchId:'',
            companyId:'',
            companyName:'',
            branchName:'',
            employeeId:'',
            employeeName:'',
            paymentMode:'',
            amount:'',
            departmentName:'',
            description:'',
            fileName:'',
            requestedby:'',
            requesteddate:'',
            reimbursementId:'',
            approvalempId:'',
            approvedDate:'',
            isEdit:false
    };
    
    $scope.isEdit=false;
    var reimbursementId = $location.search().reimbursementId;
    
    var employeeId;
    
    if (reimbursementId == undefined) {
        
        $scope.reimbursementApproval.isEdit = false;
    } else {

        $http.post('payroll/payroll/reimbursementreq/edit', reimbursementId).success(function(result) {
            if (result.isEdit == false) {
                logger.logError("Please Try Again");
            } else {
                console.log("edit");
                console.log(result);
                $scope.reimbursementApproval=result;
                $scope.reimbursementApproval.description='';
            }

        }).error(function(data) {

        });
    }
    
    $scope.cancel=function(){
        $state.go('app.payroll.payroll.reimbursementapproval.list');
    };
    
    
    
    $scope.getEmployeeDetails = function(){
        
        $http.get("payroll/payroll/payrollgeneration/getUserDetail").success(function(datas) {
              console.log("LoginUser");
              console.log(datas);
              $scope.reimbursementApproval.approvalempId=datas.loginUserEmpId;
              employeeId= $scope.reimbursementApproval.approvalempId;
         })
    }
    
    
    
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
    
    $scope.downloadFile = function(fileName) {  
        $('#btnRowDivId').append('<a id="captainMsglink" href="{{fileName}}" class="control-label"></a>');
        $("#captainMsglink").bind('click', function() {
        });
        $('#captainMsglink').simulateClick('click');
    }

    
    
    $scope.getEmployeeDetails();
    
    $scope.update = function(reimbursememtReqAddForm) {
        var today =new Date();
        var currentDate=today.getDate()+"/"+today.getMonth()+"/"+today.getFullYear();
        $scope.reimbursementApproval.approvedDate=currentDate;
        $scope.reimbursementApproval.approvalempId=employeeId;
        console.log("update");
        console.log($scope.reimbursementApproval);
        var updateData = $scope.reimbursementApproval;
        $http.post('payroll/payroll/reimbursementreq/approvalupdate', updateData).success(function(result) {
                console.log("resultupdate");
                console.log(result);
                if (result == false) {
                    
                } else {
                    logger.logSuccess("reimbursement request updated successfully");
                    $state.go('app.payroll.payroll.reimbursementapproval.list');
                }
            });
       
    }   
  
  
   
});
});