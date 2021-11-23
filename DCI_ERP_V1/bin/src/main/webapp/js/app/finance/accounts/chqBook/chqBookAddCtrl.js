///define([ 'hospital/report/report' ], function(module) {

   // 'use strict';

    
    app.controller('chqBookAddCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, utilsService, validationService) {

        $scope.isEdit = false;

        $scope.manageChqBookObj = {
            bankAccountId : '',
            startingLeaves : '',
            noOfLeaves : '',
            validFrom : '',
            validTo : '',
            statusId : 180,
            chequeNumber : '',
            chequeDate : '',
            narration : '',
            chequeAmount : '',
            chqNo : '',
            chequeStatus : ''
        };

        $scope.$watch('manageChqBookObj.validTo', function(newValue, oldValue) {
            if (newValue != '' && newValue != undefined) {
                var toDate = $scope.manageChqBookObj.validFrom;
                var fromDate = newValue;
                fromDate = fromDate.split("/");
                fromDate = new Date(fromDate[2], fromDate[1] - 1, fromDate[0]);
                toDate = toDate.split("/");
                toDate = new Date(toDate[2], toDate[1] - 1, toDate[0]);
                if (fromDate <= toDate) {
                    logger.logError("Valid To Date Should be greater than Valid From Date");
                    $scope.manageChqBookObj.validTo = '';
                }
            }
        });

        $scope.bankAccountList = [];
        $scope.statusList = [];

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

        $scope.cancel = function() {
            $state.go('app.finance.accounts.chqBook.list');
        };

        $scope.reset = function() {
            $scope.manageChqBookObj = {
                bankAccountId : '',
                startingLeaves : '',
                noOfLeaves : '',
                validFrom : $scope.date,
                validTo : '',
                statusId : 180,
                chequeNumber : '',
                chequeDate : $scope.date,
                narration : '',
                chequeAmount : '',
                chqNo : '',
                chequeStatus : ''
            };
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

        $scope.manageChqBookObj.validFrom = $scope.date;
        $scope.manageChqBookObj.chequeDate = $scope.date;

        // Save
        $scope.validate = function(manageChqBookAddForm, manageChqBookObj) {
            if (new validationService().checkFormValidity(manageChqBookAddForm)) {
                $scope.save(manageChqBookObj);
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(manageChqBookAddForm.$validationSummary), 555000, 'trustedHtml');
            }
        };

        
        
        $scope.save = function(manageItemObj) {
            $http.post('app/chqBook/save', manageItemObj).success(function(response) {
                if (response.success == true) {
                    logger.logSuccess("Saved Successfully!");
                    $state.go('app.hospital.accounts.chqBook.list');
                } else {
                    logger.logError("Not Saved!");
                }
            }).error(function(data) {
                logger.logError("Error Not Saved!");
            });
        };

    });

    module.registerController('chqBookEditCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, utilsService, validationService, $stateParams) {

        $scope.isEdit = true;

        $scope.manageChqBookObj = {
            bankAccountId : '',
            startingLeaves : '000657',
            noOfLeaves : 5,
            validFrom : '',
            validTo : '',
            statusId : 180,
            chequeNumber : '',
            chequeDate : '',
            narration : '',
            chequeAmount : '',
            chqNo : '',
            chequeStatus : ''
        };

        $scope.bankAccountList = [];
        $scope.statusList = [];

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

        $scope.cancel = function() {
            $state.go('app.hospital.accounts.chqBook.list');
        };

        var chqBookId = $stateParams.chqBookId;

        if (chqBookId != '') {

            var url = 'app/chqBook/edit?chqBookId=' + chqBookId;
            $http.get(url).success(function(response) {
                if (response) {
                    $scope.manageChqBookObj.bankAccountId = response.editList[0].bankAccountId;
                    $scope.manageChqBookObj.chqBookId = response.editList[0].chqBookId;
                    $scope.manageChqBookObj.chqNo = response.editList[0].chqNo;
                    $scope.manageChqBookObj.validFrom = response.editList[0].validFrom;
                    $scope.manageChqBookObj.validTo = response.editList[0].validTo;
                    $scope.manageChqBookObj.chequeDate = response.editList[0].chequeDate;
                    $scope.manageChqBookObj.statusId = response.editList[0].statusId;
                    $scope.manageChqBookObj.chequeStatus = response.editList[0].statusName;

                } else if (response.message != '') {
                    logger.logError(response.message);
                }

            });
        }

        $scope.reset = function() {
            var url = 'app/chqBook/edit?chqBookId=' + chqBookId;
            $http.get(url).success(function(response) {
                if (response) {
                    $scope.manageChqBookObj.bankAccountId = response.editList[0].bankAccountId;
                    $scope.manageChqBookObj.chqBookId = response.editList[0].chqBookId;
                    $scope.manageChqBookObj.chqNo = response.editList[0].chqNo;
                    $scope.manageChqBookObj.validFrom = response.editList[0].validFrom;
                    $scope.manageChqBookObj.validTo = response.editList[0].validTo;
                    $scope.manageChqBookObj.chequeDate = response.editList[0].chequeDate;
                    $scope.manageChqBookObj.statusId = response.editList[0].statusId;
                    $scope.manageChqBookObj.chequeStatus = response.editList[0].statusName;

                } else if (response.message != '') {
                    logger.logError(response.message);
                }

            });
        }

        $scope.$watch('manageChqBookObj.validTo', function(newValue, oldValue) {
            if (newValue != "") {
                if ($scope.manageChqBookObj.validFrom >= newValue) {
                    logger.logError("Valid To Should be greater than Valid From!");
                    $scope.manageChqBookObj.validTo = '';
                }
            }

        });

        // Save
        $scope.validate = function(manageChqBookAddForm, manageChqBookObj) {
            if (new validationService().checkFormValidity(manageChqBookAddForm)) {
                $scope.update(manageChqBookObj);
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(manageChqBookAddForm.$validationSummary), 555000, 'trustedHtml');
            }
        };

        $scope.update = function(manageItemObj) {
            $http.post('app/chqBook/update', manageItemObj).success(function(response) {
                if (response.success == true) {
                    logger.logSuccess("Updated Successfully!");
                    $state.go('app.hospital.accounts.chqBook.list');
                } else {
                    logger.logError("Not Updated!");
                }
            }).error(function(data) {
                logger.logError("Error Not Updated!");
            });
        };

   // });

});
