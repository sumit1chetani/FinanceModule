//define([ 'hospital/accounts/accounts' ], function(module) {
    ///'use strict';
    app.controller('paymentInformationDraftList', function($scope, $state, $http, ngDialog,
            logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {

        $scope.dataLoopCount = 0;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.companyList = [];

        $scope.pmtTypeList = [ {
            id : 'bank',
            text : 'Bank'
        }, {
            id : 'cash',
            text : 'Cash'
        } ]
        $scope.dataList = [];
        $scope.bankAccountList = [];
        $scope.cashAccountList = [];
        $scope.cbpdtlAcctHeadList = [];
        $scope.subAccountCodeList = [];
        $scope.chequeList = [];
        $scope.currencyList = [];
        $scope.voyageList = [];
        $scope.vesselList = [];
        $scope.sectorList = [];
        $scope.pmtOrderNoList = [];
        $scope.paidToList = [];
        $scope.validated = false;
        $scope.edit = false;

        $scope.isDisplay = true;

        $scope.isCheque = false;

        $scope.cancel = function() {
            $state.go('app.finance.accounts.paymentInformation.list');
        };

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

        $scope.getList = function() {
            $http.get("app/paymentOrder/list").success(function(response) {
                angular.forEach(response.paymentOrderBeanslist, function(value, key) {
                    value.acctHead = '';
                    value.companyCode = '';
                });

                $scope.rowCollection = response.paymentOrderBeanslist;

            });
        }

        $scope.getList();

        $scope.chkAll = false;
        $scope.checkAll = function(rowCollection, checkBox) {
            if (checkBox) {
                $scope.chkAll = true;
            } else {
                $scope.chkAll = false;
            }

            angular.forEach($scope.rowCollection, function(row) {
                row.select = $scope.chkAll;
            });

        };

        $scope.generatePayment = function() {
            var isValid = false;
            angular.forEach($scope.rowCollection, function(value, key) {
                if (value.select == true) {
                    isValid = true;
                }
            });

            if (isValid) {
                var validChequeDate = true;
                var validChequeNumber = true;
                var validCompanyCode = true;
                var validaccountHead = true;
                var validAmt = true;
                angular.forEach($scope.rowCollection, function(value, key) {
                    if (value.select == true) {
                        if (value.companyCode == "" || value.companyCode == undefined || value.companyCode == null) {
                            validCompanyCode = false;
                        }
                        if (value.acctHead == "" || value.acctHead == undefined || value.acctHead == null) {
                            validaccountHead = false;
                        }
                        if (value.cashPayBcAmt == "" || value.cashPayBcAmt == undefined || value.cashPayBcAmt == null || value.cashPayBcAmt <= 0) {
                            validAmt = false;
                        }
                     /*   if (value.bankAccountType == "bank") {
                            if (value.chequeDate == "" || value.chequeDate == undefined || value.chequeDate == null) {
                                validChequeDate = false;
                            }
                            if (value.chequeNo == "" || value.chequeNo == undefined || value.chequeNo == null || value.chequeNo == " ") {
                                validChequeNumber = false;
                            }
                        }*/
                    }
                });

                if (validChequeDate == true && validChequeDate == true && validCompanyCode == true && validaccountHead == true && validAmt == true && validChequeNumber == true) {
                    $http.post('app/paymentOrder/generatePayment', $scope.rowCollection).success(function(datas) {
                        if (datas) {
                            logger.logSuccess("Payment Generated Successfully");
                            $scope.getList();
                        }
                    });
                } else {
                   /* if (validChequeDate == false) {
                        logger.logError("Please Select Cheque Date");
                    }
                    if (validChequeNumber == false) {
                        logger.logError("Please Select Cheque Number");
                    }*/
                    if (validCompanyCode == false) {
                        logger.logError("Please Select Company");
                    }
                    if (validaccountHead == false) {
                        logger.logError("Please Select Account");
                    }
                    if (validAmt == false) {
                        logger.logError("Amount should not be zero");
                    }
                }

            } else {
                logger.logError("Please Select at least one item");
            }
        }

        $scope.isNaNCheck = function(value) {
            if (isNaN(value)) {
                value = 0;
            }
            return value;
        }

        $scope.loadDropDownDetails = function() {

            $http.get('app/commonUtility/getCompanyList').success(function(datas) {
                $scope.companyList = datas;
            });

            $http.get('app/paymentOrder/accountlist').success(function(datas) {
                $scope.cahbankList = datas.cahbankList;
            });

        }

        $scope.loadDropDownDetails();

    })

    app.controller('tableCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {

        $scope.$watch('displayedCollection[trIndex].acctHead', function(newValue, oldValue, object) {

            if (newValue != null && newValue != undefined && newValue != '') {
                angular.forEach($scope.cahbankList, function(value, key) {
                    if (value.id == newValue) {
                        if (value.subgroupAcctCode == '1011') {
                            $scope.displayedCollection[$scope.$index].bankAccountType = "cash";
                            $scope.isCheque = true
                        } else {
                            $scope.displayedCollection[$scope.$index].bankAccountType = "bank";
                            $scope.isCheque = false
                        }
                        $scope.displayedCollection[$scope.$index].cashPaycurrency = value.currencyCode;

                        $scope.displayedCollection[$scope.$index].cashPayExRate = value.exchangeRate;
                        $scope.displayedCollection[$scope.$index].cashPayBcAmt = ($scope.displayedCollection[$scope.$index].poBcamt).toFixed(3);
                        $scope.displayedCollection[$scope.$index].cashPayTcAmt = ($scope.displayedCollection[$scope.$index].poBcamt * value.exchangeRate).toFixed(3);
                        $http.post('app/paymentOrder/getChequeList', newValue).success(function(datas) {
                            $scope.chequeList = datas.cahbankList;

                        });

                    }
                });

            }
        });

        $scope.calculateTotalBC = function(paymentOrder) {
            angular.forEach($scope.rowCollection, function(value, index) {
                if (paymentOrder == value.paymentOrderNo) {
                    if (value.cashPayBcAmt > value.poBcamt) {
                        logger.logError("Amount should not be increased")
                        value.cashPayBcAmt = 0;
                        value.cashPayTcAmt = Number($scope.isNaNCheck(value.cashPayBcAmt)) * Number($scope.isNaNCheck(value.cashPayExRate));
                    } else {
                        value.cashPayTcAmt = Number($scope.isNaNCheck(value.cashPayBcAmt)) * Number($scope.isNaNCheck(value.cashPayExRate));
                    }
                }

            });

        }

        $scope.$watch('displayedCollection[trIndex].chequeId', function(newValue, oldValue, object) {
            if (newValue != null && newValue != undefined && newValue != '') {
                var length = $scope.rowCollection.length;
                for (var i = 0; i < length; i++) {
                    for (var j = 0; j < length; j++) {
                        if (i != j) {
                            if ($scope.rowCollection[i].chequeId != null && $scope.rowCollection[i].chequeId != undefined && $scope.rowCollection[i].chequeId != '' && $scope.rowCollection[j].chequeId != null && $scope.rowCollection[j].chequeId != undefined && $scope.rowCollection[j].chequeId != '')
                                if ($scope.rowCollection[i].chequeId == $scope.rowCollection[j].chequeId) {
                                    logger.logError("Cheque Number already added");
                                    $scope.rowCollection[$scope.$index].chequeId = '';
                                    return false;
                                }
                        }
                    }
                }
                angular.forEach($scope.chequeList, function(value, key) {
                    if (newValue == value.id) {
                        $scope.displayedCollection[$scope.$index].chequeNo = value.text;

                    }
                });
            }

        });

        $scope.$watch('displayedCollection[trIndex].chequeDate', function(newValue, oldValue) {
            if (newValue != "" && newValue != undefined && newValue != '') {
                var todayDate = $scope.date;
                var toDate = newValue;
                toDate = toDate.split("/");
                toDate = new Date(toDate[2], toDate[1] - 1, toDate[0]);
                todayDate = todayDate.split("/");
                todayDate = new Date(todayDate[2], todayDate[1] - 1, todayDate[0]);
               /* if (toDate < todayDate) {
                    logger.logError("Cheque Date should be greater than or equval to current date");
                    $scope.rowCollection[$scope.$index].chequeDate = '';
                }*/

            }
        });

    });

///});