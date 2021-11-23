//define([ 'hospital/accounts/accounts' ], function(module) {

    'use strict';

    app.controller('bankCompanymappingAddCtrl', function($scope, $state,$stateParams, $http, $location, sharedProperties, $injector, logger, toaster, validationService) {

        $scope.bankcompanyData = {
            accountHeadCode : '',
            subGroupAccountCode : '',
            accountHeadName : '',
            subGroupAccountName : '',
            currencyCode : '',
            acctHeadStatus : 'Y',
            lAttributes : [],
            companyName :'C0002',
            accountName :'',
            branch :'',
            bankacctname :'',
            bankshort :  '',
            bankCode :'',
            edit: false,
            cashbankPayment:'',

        };

        $scope.groupHeadList = [];
        $scope.subGroupHeadList = [];
        $scope.currencyList = [];
        $scope.attributeList = [];
        $scope.companyList =[];
        
        
        $http.get('app/journalVoucher/getAccountHeadMapList').success(function(datas) {
            $scope.cashAccountList = datas;
        }).error(function(datas) {
            logger.logError("Error Please Try Again");
        });
        
        
        
        $http.get('app/journalVoucher/getAccountHeadCashMapList').success(function(datas) {
            $scope.cashbankAccountList = datas;
        }).error(function(datas) {
            logger.logError("Error Please Try Again");
        });
        
        

        $scope.pmtTypeList = [ {
            id : 'bank',
            text : 'Bank'
        }, {
            id : 'cash',
            text : 'Cash'
        } ]
        
        $http.get($stateParams.tenantid+'/app/commonUtility/getCompanyListcompany').success(function(datas) {
            $scope.companyList = datas;

                var foundItemDest = $filter('filter')($scope.companyList, {
                    baseCompany : 1
                    
                })[0];
                $scope.cashbankpaymentModelData.companyName=foundItemDest.id;
        }).error(function(datas) {
        });
        
        

        $scope.getattributeList = function() {
            $scope.from = 0;
            $scope.to = 100;

            var url = 'app/accounthead/getAttributeList';
            $http.get(url).success(function(data) {
                $scope.attributeList = data.lAttributeList;
            });
        };
        $scope.getattributeList();

        // Drop Down Functionality
        $scope.getDropdownvalue = function() {
            $http.get('app/accounthead/getSubGroup').success(function(data) {
                var grpList = [];
                for (var i = 0; i < data.subGroupHeadList.length; i++) {
                    grpList.push({
                        id : data.subGroupHeadList[i].subGroupAccountCode,
                        text : data.subGroupHeadList[i].subGroupAccountName
                    });
                    $scope.subGroupHeadList = grpList;
                }

            });

            var curList = [];
            $http.get('app/bankcompany/getCurrencyList').success(function(datas) {

                for (var i = 0; i < datas.currencyList.length; i++) {
                    curList.push({
                        id : datas.currencyList[i].currencyCode,
                        text : datas.currencyList[i].currencyName
                    });
                    $scope.currencyList = curList;
                }

            });
        };

        $scope.getDropdownvalue();
        
        
        $scope.$watch('bankcompanyData.subGroupAccountCode', function(newValue, oldValue) {
            if (newValue != '' && newValue != undefined) {
                $http.post('app/bankcompany/getSubgroupAttributeMapping', newValue).success(function(datas) {
                    $scope.bankcompanyData.lAttributes = datas;
                }).error(function(datas) {
                    logger.logError("Error Please Try Again");
                });
            }else{
                $scope.bankcompanyData.lAttributes = [];
            }
       });
        

        /**
         * fetch data on Edit Row Click
         */
        $scope.bankcompanyData.edit = false;
        
        var bankCode = $location.search().bankCode;
        if (bankCode == undefined) {
            $scope.bankcompanyData.edit = false;
        } else {
            $http.post('app/bankcompany/edit',  bankCode).success(function(result) {
                
                $scope.bankcompanyData = result;
                $scope.bankcompanyData.companyName = result.companyCode.toString();
                $scope.bankcompanyData.lAttributes= result.lAttributes;
                $scope.bankcompanyData.edit = true;
                if (result.acctHeadStatus == "Y")
                    $("#Active").prop('checked', true);
                else if (result.acctHeadStatus == "false") {
                    $("#Active").prop('checked', false);
                }
            }).error(function(data) {
            });
        }

        /***********************************************************************
         * save and update functionality
         * ******************************************************************************
         */

        $scope.onSubmit = function(cashBankcomPaymentForm, bankcompanyData) {
            if (new validationService().checkFormValidity(cashBankcomPaymentForm)) {
                $scope.save(cashBankcomPaymentForm, bankcompanyData);
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(cashBankcomPaymentForm.$validationSummary), 555000, 'trustedHtml');
            }
        };

        $scope.save = function(cashBankcomPaymentForm, bankcompanyData) {

            if (!$scope.bankcompanyData.edit) {
                var addRowData = bankcompanyData;
                $http.post('app/bankcompany/add', addRowData).success(function(result) {
                    if (result) {
                        logger.logSuccess("Saved Successfully!");
                        $state.go("app.finance.accounts.bankCompanymapping.list");
                    } else {
                        logger.logError("Not Saved!..Data already Exist..");
                    }
                }).error(function(result) {
                });
            } else {
                var updateRowData = bankcompanyData;
                $http.post('app/bankcompany/update', updateRowData).success(function(result) {
                    if (result) {
                        logger.logSuccess("Updated Successfully!");
                        $state.go("app.finance.accounts.bankCompanymapping.list");
                    } else {
                        logger.logError("Not Updated!");
                    }
                }).error(function(data) {
                });
            }
        }

        $scope.cancel = function() {
            $state.go("app.finance.accounts.bankCompanymapping.list");
        };

   // });

});