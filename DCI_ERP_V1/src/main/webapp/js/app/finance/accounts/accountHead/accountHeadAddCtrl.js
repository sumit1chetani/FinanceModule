//define([ 'hospital/accounts/accounts' ], function(module) {

   /// 'use strict';

    app.controller('accountHeadAddCtrl', function($scope, $state, $http, $location, sharedProperties, $injector, logger, toaster, validationService) {

        $scope.accountHeadData = {
            accountHeadCode : '',
            subGroupAccountCode : '',
            accountHeadName : '',
            subGroupAccountName : '',
            currencyCode : 'INR',
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
            $http.get('app/accounthead/getCurrencyList').success(function(datas) {

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

        var accountHeadCode = $location.search().accCode;
        if (accountHeadCode == undefined) {
            $scope.accountHeadData.edit = false;
        } else {
            $http.get('app/accounthead/edit?accountCode=' + accountHeadCode).success(function(result) {

                $scope.accountHeadData = result;
                $scope.accountHeadData.lAttributes = result.lAttributes;
                $scope.accountHeadData.edit = true;
                if (result.acctHeadStatus == "true")
                    $scope.accountHeadData.acctHeadStatus = true;
                else
                    $scope.accountHeadData.acctHeadStatus = false;

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
            
            $http.post('app/accounthead/validate', accountHeadData).success(function(result) {
                if(result.message=='success'){
                    logger.logError("Already exist Accouut Head Name!");

                }
                else{
            if (!$scope.accountHeadData.edit) {
                
                var addRowData = accountHeadData;
                $http.post('app/accounthead/add', addRowData).success(function(result) {
                    if (result) {
                        logger.logSuccess("Saved Successfully!");
                        $state.go("app.finance.accounts.accountHead.list");
                    } else {
                        logger.logError("Not Saved!");
                    }
                }).error(function(result) {
                });
                    
            } 

                    
            else {
                var updateRowData = accountHeadData;
                $http.post('app/accounthead/update', updateRowData).success(function(result) {
                    if (result) {
                        logger.logSuccess("Updated Successfully!");
                        $state.go("app.finance.accounts.accountHead.list");
                    } else {
                        logger.logError("Not Updated!");
                    }
                }).error(function(data) {
                });
            }
        }
        });
        }

        $scope.cancel = function() {
            $state.go("app.finance.accounts.accountHead.list");
        };

    //});

});