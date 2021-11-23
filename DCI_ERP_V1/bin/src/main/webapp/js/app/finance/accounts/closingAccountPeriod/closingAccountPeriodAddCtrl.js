//  define([ 'hospital/accounts/accounts' ], function(module) {
       
        'use strict';
        
app.controller('closingAccountPeriodAddCtrl', function($scope,$stateParams, $rootScope, $http, $timeout,
        $location, logger, $log, ngDialog, $modal, utilsService, toaster,$window, $state, sharedProperties,validationService) {
  
    
    $scope.closeact={
            fromDate : '' ,
            toDate  : '' ,
            status  : '' ,
            closedBy  : '',
            companyCode : 'C0002',
            company:'C0002',
   };
   
    $scope.closeact.company = "C0002";
   $scope.rowCollection=[];
   $scope.showbutton=false;

/*   $timeout(function() {
       $("#issueDate").datetimepicker({
           format : 'DD/MM/YYYY',
           pickTime : false
       })
   }, 500);
   $('#issueDate1').datetimepicker({
       format : 'DD/MM/YYYY',
       pickTime : false
   })*/
   
   $http.get($stateParams.tenantid +
			  '/app/commonUtility/getPortList').success(function(datas) {
           $scope.polList = datas;
           console.log("list&&&&&&&&&&&&&&&&")
           console.log($scope.polList)
   });
  
   
   
   

   $scope.companyListNew =[];
   
   //companylist
   $scope.getDropdownvalue = function() {
       $http.get( $stateParams.tenantid+'/app/commonUtility/getCompanyListPurchase').success(function(datas) {
           $scope.companyListNew = datas;
           }).error(function(datas) {
       });
       
   }
   $scope.getDropdownvalue();
   

   $http.get($stateParams.tenantid+'/app/closingaccountinex/groupHeadList').success(function(datas) {

       $scope.groupHeadList=datas;
   })
   
   $scope.submitAccout=function(closeact){
    //   $scope.closeact.fromDate = $('#issueDate').find(':text').val();
     //  $scope.closeact.toDate = $('#issueDate1').find(':text').val();
//       $scope.closeact.company=$scope.closeact.company.id;
       var abc = {
               fromDate:$scope.closeact.fromDate,
               toDate:$scope.closeact.toDate,
               company:$scope.closeact.company.id,
               groupHeadCode:$scope.closeact.groupHeadCode
       }
     /*  if(abc.fromDate!=null && abc.fromDate!=undefined && abc.fromDate!=''){
           if(abc.toDate!=null && abc.toDate!=undefined && $scope.closeact.toDate!=''){
               if(abc.companyCode!=null && abc.companyCode!=undefined && abc.companyCode!=''){*/
                  /* if(abc.groupHeadCode!=null &&abc.groupHeadCode!=undefined && abc.groupHeadCode!=''){*/
                 

                       $http.post("hospital/accounts/closingPeriodinex/getData",$scope.closeact).success(function(data) {
                           $scope.rowCollection = data.lClosingAccountsInExBean;
                       })
                  /* }else{
                       logger.logError("Please Select Group Code");
                   }*/
              /* }else{
                   logger.logError("Please Select Company");
               }
           }else{
               logger.logError("Please Enter To Date");    
           }
       }else{
           logger.logError("Please Enter From Date");
       }*/
   }
   
   $scope.saveData=function(values){
       $scope.closeact.rowcollectionList=[];
      // $scope.closeact.fromDate = $('#txtIssueDate').val();
      // $scope.closeact.toDate = $('#txtIssueDate1').val();
       $scope.closeact.status = 'Closed';
       
       var abc = {
               fromDate:$scope.closeact.fromDate,
               toDate:$scope.closeact.toDate,
               company:$scope.closeact.company,
               groupHeadCode:$scope.closeact.groupHeadCode,
               status : 'Closed',
               rowcollectionList :values
       }
    console.log(abc)
    
     $http.post("hospital/accounts/closingPeriodinex/save",abc).success(function(data) {

  // $http.post($stateParams.tenantid+'/app/closingaccountinex/save',abc).success(function(data) {
           console.log("data")
           console.log(data)
           $scope.success=data.success;
           logger.logSuccess("Data Save Successfully");
           $state.go('app.finance.accounts.closingAccountPeriod.list');

          // $state.go('app.finance.controlscreen.closingaccounts');
       }).error(function(data) {

       });
   }


   
   $scope.cancel = function() {
       //$state.go('app.finance.controlscreen.closingaccounts');
       $state.go('app.finance.accounts.closingAccountPeriod.list');

	   
   }
});
//});