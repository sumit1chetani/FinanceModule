//define([ 'hospital/accounts/accounts' ], function(module) {

   /// 'use strict';

    app.controller('cashpaymentAddCtrl', function($scope, $state, $http, $location, sharedProperties, $injector, logger, toaster, validationService) {

        $scope.accountHeadData = {
            accountHeadCode : '',
            subGroupAccountCode : '',
            accountHeadName : '',
            subGroupAccountName : '',
            currencyCode : 'INR',
            ispayment : 'N',
            isreceipt : 'N',
            acctHeadStatus : true,
            lAttributes : [],
            description : '',
            type : '',
            edit : false

        };

        $scope.groupHeadList = [];
        $scope.subGroupHeadList = [];
        $scope.currencyList = [];
        $scope.attributeList = [];

        $scope.getattributeList = function() {
            $scope.from = 0;
            $scope.to = 100;

            var url = 'app/paymentreceipt/getAttributeList';
            $http.get(url).success(function(data) {
                $scope.attributeList = data.lAttributeList;
            });
        };
        $scope.getattributeList();

        // Drop Down Functionality
        $scope.getDropdownvalue = function() {
            $http.get('app/paymentreceipt/getSubGroup').success(function(data) {
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
            $http.get('app/paymentreceipt/getCurrencyList').success(function(datas) {

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

        $scope.$watch('accountHeadData.subGroupAccountCode', function(newValue, oldValue) {
            if (newValue != '' && newValue != undefined) {
                $http.post('app/accounthead/getSubgroupAttributeMapping', newValue).success(function(datas) {
                    if(datas.length > 0)
                    $scope.accountHeadData.lAttributes = datas;
                }).error(function(datas) {
                    logger.logError("Error Please Try Again");
                });
            } else {
                $scope.accountHeadData.lAttributes = [];
            }
        });

        /**
         * fetch data on Edit Row Click
         */
        $scope.accountHeadData.edit = false;

        var accountHeadCode = $location.search().PrCode;
        if (accountHeadCode == undefined) {
            $scope.accountHeadData.edit = false;
        } else {
            $http.get('app/paymentreceipt/edit?accountCode=' + accountHeadCode).success(function(result) {

                $scope.accountHeadData = result;
                $scope.accountHeadData.lAttributes = result.lAttributes;
                $scope.accountHeadData.edit = true;
                if (result.ispayment == 'Y')
                    $scope.accountHeadData.ispayment = 'Y';
                else
                    $scope.accountHeadData.ispayment = 'N';
                
                if (result.isreceipt == 'Y')
                    $scope.accountHeadData.isreceipt = 'Y';
                else
                    $scope.accountHeadData.isreceipt = 'N';

                //$scope.acctHeadStatus  = true;
                // $("#isActive").prop('checked', true);
                /*else if (result.acctHeadStatus == "false") {
                    $("#isActive").prop('checked', false);
                }*/
            }).error(function(data) {
            });
        }

        /***********************************************************************
         * save and update functionality
         * ******************************************************************************
         */

        $scope.onSubmit = function(accountHeadForm, accountHeadData) {
            if (new validationService().checkFormValidity(accountHeadForm)) {
                $scope.save(accountHeadForm, accountHeadData);
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(accountHeadForm.$validationSummary), 555000, 'trustedHtml');
            }
        };

        $scope.toggleSelection = function toggleSelection(attr) {
            var idx = $scope.accountHeadData.lAttributes.indexOf(attr);

            // Is currently selected
            if (idx > -1) {
                $scope.accountHeadData.lAttributes.splice(idx, 1);
            }

            // Is newly selected
            else {
                $scope.accountHeadData.lAttributes.push(attr);
            }
        };

        $scope.save = function(accountHeadForm, accountHeadData) {
            
            $http.post('app/paymentreceipt/validate', accountHeadData).success(function(result) {
                if(result.message=='success'){
                    logger.logError("Already exist Accouut Head Name!");

                }
                else{
            if (!$scope.accountHeadData.edit) {
                
                var addRowData = accountHeadData;
                if(accountHeadData.ispayment!="N" ||accountHeadData.isreceipt!="N" ){
                $http.post('app/paymentreceipt/add', addRowData).success(function(result) {
                    if (result) {
                        logger.logSuccess("Saved Successfully!");
                        $state.go("app.finance.accounts.managepaymentreceipt.list");
                    } else {
                        logger.logError("Not Saved!");
                    }
                }).error(function(result) {
                });
                    
            } else{
                logger.logError("Please Select  Type");
	
            }
            }

                    
            else {
                var updateRowData = accountHeadData;
                if(updateRowData.ispayment!="N" ||updateRowData.isreceipt!="N" ){
                $http.post('app/paymentreceipt/update', updateRowData).success(function(result) {
                    if (result) {
                        logger.logSuccess("Updated Successfully!");
                        $state.go("app.finance.accounts.managepaymentreceipt.list");
                    } else {
                        logger.logError("Not Updated!");
                    }
                }).error(function(data) {
                });
            }
            else{
                logger.logError("Please Select  Type");
	
            }
            }
        }
        });
        }

        $scope.cancel = function() {
            $state.go("app.finance.accounts.managepaymentreceipt.list");
        };

    //});

});