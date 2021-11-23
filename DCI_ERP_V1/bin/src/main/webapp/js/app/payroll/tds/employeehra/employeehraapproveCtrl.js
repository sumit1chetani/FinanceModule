define([ 'payroll/tds/tds'], function(module) {

    'use strict';
    
    module.registerController('employeehraapproveCtrl', function($scope,$state,$http,ngDialog, logger,$location,$controller,$injector, sharedProperties, toaster,$rootScope)  {
       
        $scope.employeehra = {
                departmentId:'',
                branchId:'',
                companyId:'',
                companyName:'',
                branchName:'',
                employeeId:'',
                employeeName:'',
                rentPaid:'',
                hraStatus:'',
                monthYear:'',
                departmentName:'',
                fileName:'',
                isEdit:false
        };
        
        
        var employeeId = $location.search().employeeId;
        var monthYear= $location.search().monthYear;
        var loginemployeeId;
        if (employeeId == undefined) {
            $scope.employeehra.isEdit = false;
        } else {
            
            var resultbean={
                    employeeId:employeeId,
                    monthYear:monthYear
            }
            $scope.employeehra.isEdit=true;
             console.log("Coming inside else function");
            $http.post('payroll/tds/employeeHraReceipts/edit', resultbean).success(function(result) {
                    console.log("Resultant Value");
                    $scope.employeehra.branchName=result.branchName;
                    $scope.employeehra.employeeName=result.employeeName;
                    $scope.employeehra.departmentName=result.departmentName;
                    $scope.employeehra.companyName=result.companyName;
                    $scope.employeehra.employeeId=result.employeeId;
                    $scope.employeehra.rentPaid=result.rentPaid;
                    $scope.employeehra.fileName=result.fileName;
                    var month = result.monthYear.substring(0,2);
                    var financialyear = result.monthYear.substring(2, result.monthYear.length);
                    var nextyear = financialyear.substring(2, result.monthYear.length);
                    nextyear=Number(nextyear)+1;
                    var newVal = financialyear+"-"+nextyear;
                    $scope.employeehra.monthYear=newVal;
                    $scope.employeehra.month=month;
                    console.log("final");
                    console.log($scope.employeehra);
                   
            }).error(function(data) {

            });
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
        
        
        $scope.downloadfile=function(){
         //   alert(index);
            $("#tbPdfExport").bind('click', function() {
                 

            });
            $('#tbPdfExport').simulateClick('click');
        }
        
        $scope.cancel =function(){
            
            $state.go('app.payroll.tds.employeehra.list');
          };
      
       $scope.approvesubmit=function(){
            if($scope.employeehra.isEdit ==true){
                console.log("update data");
               
                var resultBean={
                        employeeId:$scope.employeehra.employeeId,
                        hraStatus:$scope.employeehra.hraStatus,
                        monthYear:monthYear
                }
                var saveData = resultBean;
                console.log(saveData);
                $http.post("payroll/tds/employeeHraReceipts/approveupdate", saveData).success(function(result) {
                    if (result == false) {
                        logger.logError("Employee Id already exist");
                    }else{
                       $state.go('app.payroll.tds.employeehra.list');
                       logger.logSucces("Employeehra Recepecipt Updated Successfully");
                    }
                    
                })
          }     
        }
        
        
      
       
    });
    
})