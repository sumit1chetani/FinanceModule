'use strict';
app.controller('earningCtrl', function($scope,$stateParams, $rootScope, $http, $location,ngDialog, logger, utilsService,$state,sharedProperties,$window) {
	   $scope.dataLoopCount = 0;
       $scope.offsetCount = 0;
       $scope.limitCount = 1000;
       $scope.updatedData = [];
       $scope.rowCollection = [];
       $scope.displayedCollection = [];
       $scope.itemsByPage = 10;
       $scope.isDelete = true;
       $scope.isUpload = true;
       $scope.earningDeduction = {
           payComponentId : '',
           payComponentName : '',
           permanant : '',
           allowance : '',
           valueType : '',
           value : '',
           percentageValue : '',
           amountValue : '',
           percentageAppliedOn : '',
           description : '',
           status : '',
           payComponentType : '',
           displayOrder : '',
           isEdit : false

       };

       $scope.getList = function() {

           $http.get("payroll/payroll/earningdeductionmaster/list").success(function(response) {
               $scope.rowCollection = response.earningDeductionMasterList;

           });
       }
       $scope.getList();
       $scope.add = function() {
           $state.go('app.payroll.earning.add');
       };
       $scope.cancel = function() {
           $state.go('app.payroll.earning.list');

       };

       $scope.editRow = function(payComponentId) {
           $location.url('/payroll/payroll/earning/edit?payComponentId=' + payComponentId);
       }
       
       $scope.deleteRow = function(payComponentId, permanant) {
           ngDialog.openConfirm().then(function() {
               if (permanant == true) {
                   logger.logError(payComponentId + " Cannot Be Deleted!");
               } else {
                   $http.post("payroll/payroll/earningdeductionmaster/delete", payComponentId).success(function(response) {
                       if (response.success == false) {
                           logger.logError(payComponentId + " Pay Component is Used in Employee Pay Component So Cannot be Deleted");
                       } else {
                           logger.logSuccess("Deleted Successfully");
                           $scope.getList();
                       }

                   })

               }
           });
       };
   });
   