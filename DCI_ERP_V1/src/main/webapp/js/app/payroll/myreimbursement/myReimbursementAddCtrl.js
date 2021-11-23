define([ 'payroll/payroll/payroll' ], function(module) {

    'use strict';
    
    module.registerController('myReimbursementAddCtrl', function($scope,$state,$http,ngDialog, logger,$location,$controller,$injector, sharedProperties, toaster,$rootScope)  {
          

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
                status:'1',
                description:'',
                requestedby:'',
                requesteddate:'',
                reimbursementId:'',
                approvalempId:'',
                approvedDate:'',
                isEdit:false
        };
      
            
            var reimbursementId = $location.search().reimbursementId;
            if (reimbursementId == undefined) {
                $scope.reimbursementApproval.isEdit = false;
            } else {
                 console.log("Coming inside else function");
                $http.post('payroll/payroll/reimbursementreq/edit', reimbursementId).success(function(result) {
                    
                        console.log("Resultant Value");
                        console.log(result);
                        $scope.reimbursementApproval=result;
                          if($scope.reimbursementApproval.status==1){
                                $scope.reimbursementApproval.status="Pending";
                            }if($scope.reimbursementApproval.status==2){
                                    $scope.reimbursementApproval.status="Approved";
                            }if($scope.reimbursementApproval.status==3){
                                    $scope.reimbursementApproval.status="Rejected";
                            }if($scope.reimbursementApproval.status==4){
                                    $scope.reimbursementApproval.status="Closed";
                            }
                       }).error(function(data) {

                });
            }
            
            $scope.cancel =function(){
                
                $state.go('app.payroll.payroll.myreimbursement.list');
            };
              
       });

    
})