//define([ 'hospital/purchase/purchase' ], function(module) {

    'use strict';

    app.controller('quotAddCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, $stateParams, $filter, validationService) {
        
        $scope.itemsByPage = 10;
        $scope.numPages = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.isUpload=true;
        $scope.isDelete=true;

        $scope.requestQuotation = {
            rfqId : '',
            rfqNum : '',
            rfqDate : '',
            rfqsendBy : '',
            rfqStatus : ''
        };

        $scope.add = function() {
            $state.go("app.fiance.purchase.requestQuotation.add");
        };

        $scope.getRfqList = function() {
            $http.get("app/requestQuotation/rfqList").success(function(response) {
                console.log("List Data::::::::::::::::::::;");
                console.log(response)
                $scope.rowCollection = response.lRequestQuotationBean;
            });
        };
        $scope.getRfqList();

        //Edit functionality
        $scope.editRow = function(collection) {
            var rfqId = collection.rfqId;
            var rfqStatusName = collection.rfqStatusName;
            $location.url('hospital/purchase/requestQuotation/editview?rfqId=' + rfqId+'&rfqStatusName='+rfqStatusName);
        };

        //Delete functionality
        $scope.deleteRow = function(collection) {
            var rfqId = collection.rfqId;
            if(collection.rfqStatus==165){
                ngDialog.openConfirm().then(function() {
                    var myURL = 'app/requestQuotation/deleteRfq';
                    $http({
                        url : myURL,
                        data : rfqId,
                        method : 'post',
                        dataType : 'json',
                        headers : {
                            'Accept' : 'application/json',
                            'Content-Type' : 'application/json'
                        }
                    }).success(function(data) {
                        console.log(data);
                        if (data == true) {
                            logger.logSuccess("Record Deleted Successfully");
                            $scope.getRfqList();
                        } else
                            logger.logError("You Can't Delete this record, Related Data Exist!");
                    }).error(function(data) {
                    });
                }, function(reason) {
                    console.log('Modal promise rejected. Reason: ', reason);
                });
            }else{
                logger.logError("You Can't Delete this record");
            }
           
            
        };

    });

//});