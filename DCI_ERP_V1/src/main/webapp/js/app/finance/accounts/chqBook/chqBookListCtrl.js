//define([ 'hospital/report/report' ], function(module) {

    'use strict';

    app.controller('chqBookListCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, utilsService) {

        
        
        
        
        
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.isUpload = true;
        $scope.isDelete = true;
        $scope.numPages = 0;

        $scope.chqBookmodelData = {
            validFrom : '',
            validTo : '',
            bankAccountId : '',
            statusId : ''
        };

        $scope.bankAccountList = [];
        $scope.statusList = [];

        $scope.getList = function() {
            $http.get('app/chqBook/list').success(function(response) {
                $scope.rowCollection = response.chqBookList;
            });
        };

        $scope.getList();

        var pmtType = "Bank";

        $http.get('app/cashbankPayment/getBankAcctList?paymentType=' + pmtType).success(function(data) {
            var acctList = [];

            angular.forEach(data, function(item, key) {
                var accObj = new Object();
                accObj.id = data[key].acctHeadCode;
                accObj.text = data[key].accountName;
                accObj.currencyCode = data[key].currencyCode;
                accObj.exchangeRate = data[key].exchangeRate;
                acctList.push(accObj);
            });
            $scope.bankAccountList = acctList;

        }).error(function(data) {
            logger.logError("Failed to get Bank Account List");
        });

        $scope.editChqBook = function(chqBookId) {
            $state.go('app.finance.accounts.chqBook.edit', ({
                chqBookId : chqBookId
            }));
        }

        $http.get('app/chqBook/getStatusList').success(function(data) {
            if (data.success) {
                $scope.statusList = data.statusList;
            }
        }).error(function(data) {
            logger.logError("Failed to get Status List");
        });

        $scope.add = function() {
            $state.go('app.finance.accounts.chqBook.add');
        };

        $scope.deleteChqBook = function(chqBookId, index) {
            ngDialog.openConfirm().then(function() {
                var myURL = 'app/chqBook/delete?chqBookId';
                $http({
                    method : 'post',
                    url : myURL,
                    data : chqBookId,
                }).success(function(data) {
                    if (data == true) {
                        var tableData = $scope.rowCollection;
                        $scope.rowCollection.splice(index, 1);
                        logger.logSuccess("Deleted successfully");
                        $state.go("app.hospital.accounts.chqBook.list");
                    } else {
                        logger.logError("Unable to Delete Manage Cheque Book!");
                    }
                }).error(function(data) {
                    logger.logError("Error in Delete!");
                });
            });

        };

        $scope.viewSearchList = function() {
            if ($scope.chqBookmodelData.statusId != 0) {
                $http.post('app/chqBook/searchList', $scope.chqBookmodelData).success(function(data) {
                    if (data.success) {
                        $scope.rowCollection = data.chqBookList;
                    }

                }).error(function(data) {
                    logger.logError("Error Please Try Again");
                });
            } else {
                logger.logError("Please Select Status!");
            }
        };

        $scope.$watch('chqBookmodelData.validFrom', function(newValue) {
            if (newValue != "") {
                var fromDate = $scope.chqBookmodelData.validFrom;
                var toDate = $scope.chqBookmodelData.validTo;
                fromDate = fromDate.split("/");
                fromDate = new Date(fromDate[2], fromDate[1], fromDate[0]);
                toDate = toDate.split("/");
                toDate = new Date(toDate[2], toDate[1], toDate[0]);
                if (fromDate >= toDate) {
                    $scope.chqBookmodelData.validTo = '';
                }
            }
        });

        $scope.$watch('chqBookmodelData.validTo', function(newValue, oldValue) {
            if (newValue != '' && newValue != undefined) {
                if ($scope.chqBookmodelData.validFrom == '') {
                    logger.logError("Please Select Valid From!");
                    $scope.chqBookmodelData.validTo = '';
                }
                var toDate = $scope.chqBookmodelData.validFrom;
                var fromDate = newValue;
                fromDate = fromDate.split("/");
                fromDate = new Date(fromDate[2], fromDate[1] - 1, fromDate[0]);
                toDate = toDate.split("/");
                toDate = new Date(toDate[2], toDate[1] - 1, toDate[0]);
                if (fromDate < toDate) {
                    logger.logError("Valid To Date Should be greater than Valid From Date");
                    $scope.chqBookmodelData.validTo = '';
                }
            }
        });

    //});

});
