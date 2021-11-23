define([ 'payroll/payroll/payroll' ], function(module) {

    'use strict';
    
    module.registerController('advanceapprovaleditCtrl', function($scope,$state,$http,ngDialog, logger,$location,$controller,$injector, sharedProperties, toaster,$rootScope)  {
     
        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.isDisplay=true;
        
        
        $scope.advance = {
                employeeName:'',
                employeeCode:'',
                designation:'',
                joinDate:'',
                workingYear:'',
                description:'',  
                amount:0,
                disbursementdate:'',
                openingBalance:0,
                installmentPaid:'',
                type:'',
                installmentAmount:0,
                startDate:'',
                status:'',
                numberOfInstallments:'',
                isEdit:false      
         };
        
        
        var loanId = $location.search().loanId;
        var employeeId;
        if (loanId == undefined) {
            $scope.loantype.isEdit = false;
        } else {
             console.log("Coming inside else function");
            $http.post('payroll/payroll/loanentry/edit', loanId).success(function(result) {
                    console.log("Resultant Value");
                    console.log(result);
                    if(result.loanEntryListById!=null && result.loanEntryListById!=undefined){
                        $scope.advance.isEdit = true;
                        $scope.advance.employeeName=result.loanEntryListById[0].employeeId;  
                        $scope.advance.employeeCode=result.loanEntryListById[0].employeeName; 
                        $scope.advance.designation=result.loanEntryListById[0].loanId; 
                        $scope.advance.joinDate=result.loanEntryListById[0].loanTypeId; 
                        $scope.advance.workingYear=result.loanEntryListById[0].amount; 
                        $scope.advance.description=result.loanEntryListById[0].numberOfInstalments; 
                        $scope.advance.amount=result.loanEntryListById[0].interestRate; 
                        $scope.advance.disbursementdate=result.loanEntryListById[0].deductionAmount; 
                        $scope.advance.openingBalance=result.loanEntryListById[0].deductFrom; 
                        $scope.advance.installmentPaid=result.loanEntryListById[0].loanTypeName; 
                        $scope.advance.type=result.loanEntryListById[0].deductFromDisplay; 
                        $scope.advance.installmentAmount=result.loanEntryListById[0].flatOrDiminishing; 
                        $scope.advance.startDate=result.loanEntryListById[0].flatOrDiminishing; 
                        $scope.advance.numberOfInstallments=result.loanEntryListById[0].flatOrDiminishing; 
                        $scope.advance.status=result.loanEntryListById[0].status; 
                        if($scope.loantype.flatOrDiminishing==1){
                            $scope.loantype.flatOrDiminishing="Flat";
                        }else{
                            if($scope.loantype.flatOrDiminishing==2){
                                $scope.loantype.flatOrDiminishing="Diminishing";
                            }
                        }
                        if(result.loanEntryListById[0].flatOrDiminishing==1){
                            $scope.loantype.flatOrDiminishing='Flat';
                        }else{
                            $scope.loantype.flatOrDiminishing='Diminishing';    
                        }
                        $scope.getEMICalculation();  
                    }
            }).error(function(data) {

            });
        }
        
        
        $scope.update = function() {
            var loanId= $scope.loantype.loanId;
            var today =new Date();
            var month = today.getMonth()+1;
            var currentDate=today.getDate()+"/"+month+"/"+today.getFullYear();
           
            var resultbean={
                    approvedOn:currentDate,
                    approvedBy:employeeId,
                    loanId:$scope.loantype.loanId,
                    status:$scope.loantype.status
            }
           
            console.log("update");
            console.log(resultbean);
            var updateData = resultbean;
            $http.post('payroll/payroll/loanentry/approvalupdate', updateData).success(function(result) {
                    console.log("resultupdate");
                    console.log(result);
                    if (result == false) {
                        
                    } else {
                        logger.logSuccess("reimbursement request updated successfully");
                        $state.go('app.payroll.payroll.loanapproval.list');
                    }
                });
           
        } 
        $scope.cancel=function(){
            $state.go('app.payroll.payroll.advanceapproval.list');
        };
        
        
    });
    
})