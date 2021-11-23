//define([ 'hospital/purchase/purchase' ], function(module) {

    'use strict';

    app.controller('depListCtrl', function($scope, $state, $stateParams,$http, $controller, logger, ngDialog, $location, $injector, sharedProperties, toaster, $rootScope) {
        
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages = 0
        $scope.isDisplay = false;
        $scope.isUpload=true;
        $scope.isDelete=true;
        $scope.storeToPurchaseData= {
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
                isEdit : false,
                tables : []
        };                
        $scope.getList = function() {
           
       var requisitionType=$scope.storeToPurchaseData.requisitionType;
            $http.get("app/hospital/purchase/storeToPurchase/list").success(function(response) {
                $scope.rowCollection = response.employeeList;
            });
        };
        $scope.getList();

        $scope.editRow = function(purchaseRequisitionId,requisitionStatusName) {
             $location.url( $stateParams.tenantid +'/hospital/purchase/storetopurchase/edit?purchaseRequisitionId='+purchaseRequisitionId);
        };

        $scope.add = function() {
            $state.go("app.sea.dep.add");
        };

    $scope.deleteRow = function(purchaseRequisitionId, index) {
        ngDialog.openConfirm().then(function() {
            var myURL = 'app/hospital/purchase/storeToPurchase/delete';
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
                    logger.logSuccess("Record Deleted Successfully");
                    $scope.getList();
                } else
                    logger.logError("You Can't Delete this record, Related Data Exist!");
            }).error(function(data) {
            });
        }, function(reason) {
            console.log('Modal promise rejected. Reason: ', reason);
        });

    };
       
    });
//});