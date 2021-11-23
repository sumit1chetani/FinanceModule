//define([ 'hospital/purchase/purchase' ], function(module) {

    'use strict';

    app.controller('storeListCtrl', function($scope, $state, $stateParams,$http, $controller, logger, ngDialog, $location, $injector, sharedProperties, toaster, $rootScope) {
        
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages = 0
        $scope.isDisplay = false;
        $scope.isUpload=true;
        $scope.isDelete=true;
        $scope.storeToStoreData= {
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
                tables : []
        };                
        $scope.getList = function() {
       
            $http.get("app/hospital/purchase/storeToStore/list").success(function(response) {
                $scope.rowCollection = response.employeeList;
            });
        };
        $scope.getList();


        $scope.editRow = function(purchaseRequisitionId) {
            $location.url($stateParams.tenantid+'/hospital/purchase/storetostore/edit?purchaseRequisitionId='+purchaseRequisitionId);
        };

        $scope.add = function() {
            $state.go("app.sea.store.add");
        };

    $scope.deleteRow = function(purchaseRequisitionId, index) {
        ngDialog.openConfirm().then(function() {
            var myURL = 'app/hospital/purchase/storeToStore/delete';
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
//});