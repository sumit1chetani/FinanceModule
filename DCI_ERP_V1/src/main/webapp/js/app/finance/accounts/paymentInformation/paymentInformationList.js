//define([ 'hospital/accounts/accounts' ], function(module) {
 //   'use strict';
    app.controller('paymentInformationList', function($scope, $state, $http, ngDialog ,logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {
        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;

        $scope.isDelete = true;
        $scope.isUpload = true;

        
        $scope.viewDraft = function(limit, offset) {
            $state.go('app.finance.accounts.paymentInformation.draft');
        };

      
        
        $scope.getList = function() {
            $http.get("app/paymentInformation/getlist").success(function(response) {
                $scope.rowCollection = response.informationBeanslist;
            });
        }

        $scope.date = '';

        var today = new Date();
        var dd = today.getDate();
        var mm = today.getMonth() + 1; // January is 0!
        var yyyy = today.getFullYear();

        if (dd < 10) {
            dd = '0' + dd;
        }
        if (mm < 10) {
            mm = '0' + mm;
        }

        var today = dd + '/' + mm + '/' + yyyy;
        $scope.date = today;

        $scope.getList();

        $scope.editRow = function(paymentOrderNo, status) {
            if (status == "Pending") {
                $location.url($stateParams.tenantid +'/hospital/accounts/paymentInformation/paymentInformationEdit?paymentOrderNo=' + paymentOrderNo);
            } else {
                logger.logError("Cannot edit approved data");
            }
        }

        $scope.cancel = function() {
            $state.go('app.appraisal.master.parameter.list');
        };
        $scope.add = function() {
            $state.go('app.finance.accounts.paymentInformation.add');
        };

        $scope.deleteRow = function(paymentOrderNo, status) {
            if (status == "Pending") {
                ngDialog.openConfirm().then(function() {
                    $http.post("app/paymentInformation/delete", paymentOrderNo).success(function(response) {
                        if (response == true) {
                            logger.logSuccess("Deleted Successfully!");
                            $scope.getList();
                        }
                    }).error(function(result) {
                        logger.logError("Error Please Try Again");
                    });
                });
            } else {
                logger.logError("Cannot delete approved data");
            }

        };

        $scope.chkAll = false;
        $scope.checkAll = function(rowCollection, checkBox) {
            if (checkBox) {
                $scope.chkAll = true;
            } else {
                $scope.chkAll = false;
            }

            angular.forEach($scope.rowCollection, function(row) {
                if (row.status != "Approved") {
                    row.select = $scope.chkAll;
                }

            });

        };

        $scope.checkAllPurchaseDisabled = function(paymentOrderNo) {
            angular.forEach($scope.rowCollection, function(value) {
                if (paymentOrderNo == value.paymentOrderNo) {
                    if (value.status == "Approved") {
                        logger.logError("Payment order number already approved");
                        value.select = false;
                    }

                }

            });
        }

        $scope.approvePaymentInformation = function(paymentOrderNo) {
            var isValid = false
            angular.forEach($scope.rowCollection, function(row) {
                row.approvedDate = $scope.date;
                if (row.select == true) {
                    isValid = true;
                }
            });
            if (isValid) {
                $http.post("app/paymentInformation/updateApprove", $scope.rowCollection).success(function(response) {
                    if (response) {
                        logger.logSuccess("Approved Successfully!");
                        $scope.getList();
                    } else {
                        logger.logError("Error Please Try Again");
                    }

                });
            } else {
                logger.logError("Please Select Atleast one item");
            }

        }

   // })
});







