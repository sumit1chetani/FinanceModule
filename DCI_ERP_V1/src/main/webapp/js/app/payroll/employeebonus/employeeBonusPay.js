//define([ 'payroll/payroll/payroll' ], function(module) {
    'use strict';
   // module.registerController('employeeBonusPayCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService) {
   	app.controller('employeeBonusPayCtrl', function($stateParams,$scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService,utilsService, $window,$timeout) {

        $scope.employeebonus = {
            declaredAmount : '',
            paidAmount : '',
            bonusId : '',
            paidOn : '',
            employeeId : '',
            employeeName : '',
            balanceAmount : '',
            isEdit : false
        };

        $scope.employeeBonusList = [];
        var bonusId = $location.search().bonusId;
        if (bonusId != undefined && bonusId != null && bonusId != '') {
            $http.post("payroll/payroll/employeebonus/edit", bonusId).success(function(data) {
                $scope.employeebonus = data;
                $scope.employeebonus.balanceAmount = data.declaredAmount - data.paidAmount
                $scope.employeebonus.paidAmount = ''

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

        $scope.$watch('employeebonus.paidOn', function(newValue, oldValue) {
            if (newValue != "") {
                var fromDate = newValue;
                var toDate = $scope.date;
                fromDate = fromDate.split("/");
                fromDate = new Date(fromDate[2], fromDate[1] - 1, fromDate[0]);
                toDate = toDate.split("/");
                toDate = new Date(toDate[2], toDate[1] - 1, toDate[0]);

                if (fromDate > toDate) {
                    logger.logError("Paid on Date should be lesser than or equal to the today date");
                    $scope.employeebonus.paidOn = '';
                }

            }

        });

        $scope.submit = function(employeeBonusPay) {
            if (new validationService().checkFormValidity(employeeBonusPay)) {
                var resultBean = {
                    bonusId : $scope.employeebonus.bonusId,
                    paidOn : $scope.employeebonus.paidOn
                };
                var isValid = true;
                $scope.employeeBonusList.push(resultBean);
                if ($scope.employeebonus.paidAmount > $scope.employeebonus.balanceAmount) {
                    isValid = false;
                    logger.logError("Paid amount should be less than or equal to to the balance or declared bonus amount!!!");
                } else {
                    if (isValid) {
                        $http.post("payroll/payroll/employeebonus/checkEmployeeBonusByDate", resultBean).success(function(datas) {
                            if (datas.paidOn != undefined && datas.paidOn != null && datas.paidOn != '') {
                                var fromDate = datas.paidOn;
                                var toDate = $scope.employeebonus.paidOn;
                                fromDate = fromDate.split("/");
                                fromDate = new Date(fromDate[2], fromDate[1] - 1, fromDate[0]);
                                toDate = toDate.split("/");
                                toDate = new Date(toDate[2], toDate[1] - 1, toDate[0]);
                                if (toDate > fromDate) {
                                    var saveData = $scope.employeebonus;
                                    $http.post("payroll/payroll/employeebonus/update", saveData).success(function(datas) {
                                        $state.go('app.payroll.payroll.employeebonus.list');
                                    });
                                } else {
                                    logger.logError("Paid on Date Should be greater than the " + datas.paidOn);
                                }
                            } else {
                                var saveData = $scope.employeebonus;
                                $http.post("payroll/payroll/employeebonus/update", saveData).success(function(datas) {
                                    $state.go('app.payroll.payroll.employeebonus.list');
                                });
                            }

                        })
                    }
                }
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(employeeBonusPay.$validationSummary), 5000, 'trustedHtml');
            }
        }

        $scope.reset = function(earningDeductionForm) {
            $scope.employeebonus.paidAmount = '';
            $scope.employeebonus.paidOn = '';

        }

        $scope.cancel = function() {
            $state.go('app.payroll.payroll.employeebonus.list');
        };

    
});