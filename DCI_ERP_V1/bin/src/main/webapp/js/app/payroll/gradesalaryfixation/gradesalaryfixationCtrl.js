//define([ 'payroll/payroll/payroll' ], function(module) {
'use strict';
app.controller('gradesalaryfixationCtrl', function($scope,$state,$http,ngDialog, logger,$location,$stateParams,$controller,$injector, sharedProperties, toaster,$rootScope,validationService)  {
   
 $scope.gradePayComponenet = {
            payComponentName:'',
            amount:'',
            fromdate:'',
            todate:'',
            companyName:'',
            companyId:'',
            gradeId:'',
            largeDateValue:'',
            isEdit:false
    };
 
 $scope.empPayComList=[];
 $scope.earningList=[];
 $scope.deductionList=[];
 $scope.gradeComponentList=[];
 $scope.isAuthorized=false;
 $scope.isDelete=true;
 $scope.isUpload=true;
 var gradeId = $location.search().gradeId;
 var companyId = $location.search().companyId;
 var gradeIdEdit='';
 
 
 $scope.$watch('gradePayComponenet.companyId', function(newVal, oldVal) {
    if(newVal!="" && newVal!=undefined){
         $http.post("payroll/payroll/gradepay/getGradeList",newVal).success(function(datas) {
             console.log("GradeList");
             console.log(datas);
             $scope.gradeList = datas.gradeList;
             if(gradeId==undefined || gradeId=='' || gradeId==null){
                 $scope.gradePayComponenet.gradeId='';
             }
      })
     }
 });
 
 
 $scope.getCompanyList = function(){
     //$http.get("payroll/payroll/payrollgeneration/getCompanyList").success(function(datas) {
	 $http.get($stateParams.tenantid	+ '/app/usermaster/getCompanyList?formCode='
				+ 'F0366').success(
		function(datas) {  
	 console.log("getCompanyList");
           $scope.companyList = datas;
           $scope.getEmployeeDetails();
           console.log(datas);
       })
 }
 
 
 $scope.getGradeList = function(companyId){
     console.log("gradId");
    $http.post("payroll/payroll/gradepay/getGradeList",companyId).success(function(datas) {
           console.log("GradeList");
           console.log(datas);
           $scope.gradeList = datas.gradeList;
           if(gradeId!=undefined && gradeId!='' && gradeId!=null){
               $scope.gradePayComponenet.gradeId=gradeId
           }
        
          
    })
 }
 
 
 $scope.getEmployeeDetails = function(){
   
    $http.get("payroll/payroll/payrollgeneration/getUserDetail").success(function(datas) {
           console.log("LoginUser");
           console.log(datas);
           if($scope.companyList.length==1){
               $scope.gradePayComponenet.companyId=$scope.companyList[0].id;
               $scope.gradePayComponenet.companyName=$scope.companyList[0].companyName;
               $scope.getGradeList($scope.companyList[0].companyId);
           }else{
               if($scope.companyList.length > 1){
                   if(companyId==undefined || companyId=='' || companyId==null){
                       $scope.gradePayComponenet.companyId=datas.companyId;
                       $scope.gradePayComponenet.companyName=datas.companyName;
                       $scope.getGradeList($scope.gradePayComponenet.companyId);
                   }else{
                       $scope.gradePayComponenet.companyId=companyId;
                       $scope.getGradeList($scope.gradePayComponenet.companyId);
                   }
               }
               
           }
         
       })
 }
 
 $scope.getCompanyList();
 
 $scope.getGradeChange = function(companyId){
     console.log("gradId");
    $http.post("payroll/payroll/gradepay/getGradeList",companyId).success(function(datas) {
           console.log("GradeList");
           console.log(datas);
           $scope.gradeList = datas.gradeList;
           $scope.gradePayComponenet.gradeId='';
           
    })
 }
 
 
 $scope.renamingDateValue=function(paycomponenetList){
     $scope.employeePayComponentList=paycomponenetList;
     angular.forEach($scope.employeePayComponentList, function(value, key) {
         var startDate = value.fromdate;
         startDate = startDate.split("-");
         startDate=startDate[2]+"/"+ startDate[1]+"/"+startDate[0];
         value.fromdate=startDate;
     });
 
 }

 $scope.checkingLargeDate=function(paycomponenetList){
     $scope.gradeComponentList=paycomponenetList;
     var prevsDate=null;
     angular.forEach($scope.gradeComponentList, function(value, key) {
         if(prevsDate==null){
             prevsDate = value.fromdate;
             prevsDate = prevsDate.split("/");
             prevsDate = new Date(prevsDate[2], prevsDate[1]-1, prevsDate[0]);
         }
         var currentDate = value.fromdate;
         currentDate = currentDate.split("/");
       
         currentDate = new Date(currentDate[2], currentDate[1]-1, currentDate[0]);
         if(currentDate >= prevsDate){
            $scope.gradePayComponenet.largeDateValue=value.fromdate;
         }
         prevsDate=currentDate;
        
     });
 
 }
   
 $scope.submit1=function(gradePayComponenet,gradesalarylistForm){
     if (new validationService().checkFormValidity(gradesalarylistForm)) {
       console.log("gradeId"+gradePayComponenet.gradeId);
       $scope.gradePayComponenet.gradeId=gradePayComponenet.gradeId;
       $http.get("payroll/payroll/gradepay/list?gradeId=" + gradePayComponenet.gradeId )
         .success(function(response) {
          console.log("gradeList")
          console.log(response)
          $scope.gradeComponentList=response.gradeComponentList;
          $scope.renamingDateValue(response.gradeComponentList);
          $scope.checkingLargeDate($scope.gradeComponentList);
          console.log($scope.gradePayComponenet.largeDateValue);
          $scope.rowCollection =$scope.gradeComponentList;
           
         });
   }else{
       toaster.pop('error', "Please fill the required fields", 
               logger.getErrorHtmlNew(gradesalarylistForm.$validationSummary), 5000, 'trustedHtml');
   }
 }
 
$scope.getGradePayComponentList=function(gradeId){
    console.log("gradeId"+gradeId);
      $scope.gradePayComponenet.gradeId=gradeId;
      $http.get("payroll/payroll/gradepay/list?gradeId=" + gradeId )
        .success(function(response) {
         console.log("gradeList")
         console.log(response)
         $scope.gradeComponentList=response.gradeComponentList;
         $scope.renamingDateValue(response.gradeComponentList);
         $scope.checkingLargeDate($scope.gradeComponentList);
         console.log($scope.gradePayComponenet.largeDateValue);
         $scope.rowCollection =$scope.gradeComponentList;
          
        });
 
}

if(gradeId!=undefined && gradeId!=null && gradeId!=''){
    $scope.gradePayComponenet.gradeId=gradeId;
    $scope.getGradePayComponentList(gradeId);
    
 }


 
$scope.add=function(){
    var gradeId = $scope.gradePayComponenet.gradeId;
    var companyId = $scope.gradePayComponenet.companyId;
    $location.url($stateParams.tenantid+'/payroll/gradesalaryfixation/add?gradeId=' + gradeId + '&companyId=' + companyId);
    
 };

 
 $scope.editRow = function(gradeId,fromdate){
    
     if(gradeId!=undefined && gradeId!=null && gradeId!=''){
         $scope.gradePayComponenet.gradeId=gradeId;
     }
     var companyId = $scope.gradePayComponenet.companyId;
     $location.url($stateParams.tenantid+'/payroll/gradesalaryfixation/edit?gradeId=' + $scope.gradePayComponenet.gradeId + '&fromdate=' + fromdate + '&companyId=' + companyId);
 }

 
 
 
 $scope.deleteRow = function(gradeId,fromdate) {
     ngDialog.openConfirm().then(function() {
         var resultBean={
                 gradeId:$scope.gradePayComponenet.gradeId,
                 fromdate:fromdate
         };
         $http.post("payroll/payroll/gradepay/delete",resultBean)
          .success(function(response) {
              if(response == true){
                 logger.logSuccess("Deleted Successfully!");
                 $scope.getGradePayComponentList($scope.gradePayComponenet.gradeId);  
             }
          }).error(function(result) {
              logger.logError("Error Please Try Again");
          });
      });
  };
 
   
  

});