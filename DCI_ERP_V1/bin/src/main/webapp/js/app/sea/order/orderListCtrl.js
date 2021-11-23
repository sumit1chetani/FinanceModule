'use strict';

app.controller('orderListCtrl', function($scope, $rootScope,ngDialog, $http, $location, logger,
        utilsService,$state,sharedProperties,$window,validationService,toaster,$stateParams) {        
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages = 0
        $scope.isDisplay = true;
        $scope.isUpload=true;
        $scope.storeApprovalData= {
                purchaseRequisitionId : '',
                requisitionNumber : '',
                requisitionDate : '',
                employeeId : '',
                employeeName : '',
                requisitionType : '',
                designationName : '',
                sourceLocation : '',
                locationName : '',
                destinationLocation : '',
                designationId : '',
                approvedDate : '',
                tables : []
        };  
        
        
       
        $scope.getList = function() {
       
            $http.get("app/master/order/list").success(function(response) {
                $scope.rowCollection = response.employeeList;
            });
        };
        
        $scope.add = function() {
            $state.go("app.sea.order.add");
        };
        $scope.getList();
        $scope.Publish = function(rowId) {
            $location.url('/master/order/publish?rowId='+rowId);
        };
        $scope.Reject = function(rowId) {
            $location.url('/master/order/reject?rowId='+rowId);
        };
   /*     $scope.Publish = function(workOrderId) {

            $http.get('app/hospital/purchase/WorkOrderApproval/publish?workOrderId=' + workOrderId).success(function(response) {
                if (response.success == true) {
                    logger.logSuccess("Published Successfully");
                    $scope.getEducationNotificationList();

                } else {
                    logger.logError("Sorry Some Error occurred");

                }
            });
        }*/
  /*      $scope.Reject = function(workOrderId) {

            $http.get('app/hospital/purchase/WorkOrderApproval/reject?workOrderId=' + workOrderId).success(function(response) {
                if (response.success == true) {
                    logger.logSuccess("Rejected Successfully");
                    $scope.getEducationNotificationList();

                } else {
                    logger.logError("Sorry Some Error occurred");

                }
            });
        }*/

        //View Functionality
        $scope.getViewInfo=function(purchaseRequisitionId){
            $location.url('master/order/view?purchaseRequisitionId='+purchaseRequisitionId);

        }

        $scope.editRow = function(purchaseRequisitionId) {
            $location.url('master/order/edit?purchaseRequisitionId='+purchaseRequisitionId);
        };

        

    $scope.deleteRow = function(purchaseRequisitionId, index) {
        ngDialog.openConfirm().then(function() {
            var myURL = 'app/master/order/delete';
            $http({
                url : myURL,
                data : purchaseRequisitionId,
                method : 'post',
                dataType : 'json',
                headers : {
                    'Accept' : 'application/json',
                    'Content-Type' : 'application/json'
                }
            }).success(function(data) {
                if (data == true) {
                    $scope.displayedCollection.splice(index, 1);
                    logger.logSuccess("Record Deleted Successfully");
                } else
                    logger.logError("You Can't Delete this record, Related Data Exist!");
            }).error(function(data) {
            });
        }, function(reason) {
            console.log('Modal promise rejected. Reason: ', reason);
        });

    };

       
    
});