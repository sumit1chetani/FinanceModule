        'use strict';

app.controller('kitchenListCtrl', function($scope, $rootScope,ngDialog, $http, $location, logger,
        utilsService,$state,sharedProperties,$window,validationService,toaster,$stateParams) {
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages = 0
        $scope.isDisplay = false;
        $scope.isUpload=true;
        $scope.isDelete=true;
        
        $scope.consignmentRequestData= {
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
       
            $http.get("app/master/kitchen/list").success(function(response) {
                $scope.rowCollection = response;
            });
        };
        $scope.getList();


        $scope.editRow = function(rowId) {
            $location.url('/master/kitchen/edit?rowId='+rowId);
        };

        $scope.add = function() {
            $state.go("app.sea.kitchen.add");
        };

        $scope.deleteRow = function(rowId) {
            ngDialog.openConfirm().then(function() {
            
                var url = 'app/master/kitchen/delete?rowId=' + rowId;
                $http.get(url).success(function(result){
                    if (result.isSuccess ==  true) {
                        logger.logSuccess("Deleted successfully");
                        $state.reload();
                   } else {
                        logger.logError("You Can't Delete this Record, Related Data Exist! ");
                    }
                }).error(function(result) {
                    logger.logError("Error Please Try Again");
                });
            }, function(reason) {
                console.log('Modal promise rejected. Reason: ', reason);
            });
        };
        $scope.print = function(id){       
            var url = 'app/master/kitchen/print?id=' + id;
            var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
            //wnd.print();   
            if (wnd.print) {
                var done = false;
                if (wnd.document && wnd.document.readyState) {
                    var rs = wnd.document.readyState;
                    if ((rs === 'complete') || (rs === 'loaded')) {
                        done = true;
                        wnd.print();
                    }
                }
                if (!done) {
                    if (wnd.addEventListener) {
                        wnd.addEventListener('load', function() {
                            this.print();
                        });
                    } else {
                        wnd.onload = function() {
                            this.print();
                        };
                    }
                }
            }
         }
       
    });
