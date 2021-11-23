///define([ 'hospital/accounts/accounts' ], function(module) {

    //'use strict';

    app.controller('budgetReportAddCtrl', function($scope, $state, $filter ,$http, $location, sharedProperties, $injector, logger, toaster, validationService) {

        $scope.tdscompanyData = {
            tdsname : '',
            tdscode : '',
            tdsType:'',
            tdsDesc:'',
            acctHeadStatus : 'Yes',
            edit: false

        };

        $scope.groupHeadList = [];
        $scope.subGroupHeadList = [];
        $scope.currencyList = [];
        $scope.attributeList = [];
        $scope.companyList =[];
        
      
        

        

        /**
         * fetch data on Edit Row Click
         */
        $scope.tdscompanyData.edit = false;
        
        var tdsauto = $location.search().tdsauto;
        if (tdsauto == undefined) {
            $scope.tdscompanyData.edit = false;
        } else {
            $http.post('app/tds/edit',  tdsauto).success(function(result) {
                
                $scope.tdscompanyData = result;
                //$scope.tdscompanyData.companyName = result.companyCode.toString();
               // $scope.tdscompanyData.lAttributes= result.lAttributes;
                $scope.tdscompanyData.edit = true;
                if (result.acctHeadStatus == "true")
                    $("#isActive").prop('checked', true);
                else if (result.acctHeadStatus == "false") {
                    $("#isActive").prop('checked', false);
                }
            }).error(function(data) {
            });
        }

        /***********************************************************************
         * save and update functionality
         * ******************************************************************************
         */

        $scope.onSubmit = function(tdsform, tdscompanyData) {
            if (new validationService().checkFormValidity(tdsform)) {
                $scope.save(tdsform, tdscompanyData);
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.tdsform.$validationSummary), 555000, 'trustedHtml');
            }
        };
        
        

        $scope.save = function(tdsform, tdscompanyData) {

            if (!$scope.tdscompanyData.edit) {
                var addRowData = tdscompanyData;
                $http.post('app/tds/add', addRowData).success(function(result) {
                    if (result) {
                        logger.logSuccess("Saved Successfully!");
                        $state.go("app.hospital.accounts.formAccountCenter.list");
                    } else {
                        logger.logError("Not Saved!");
                    }
                }).error(function(result) {
                });
            } else {
                var updateRowData = tdscompanyData;
                $http.post('app/tds/update', updateRowData).success(function(result) {
                    if (result) {
                        logger.logSuccess("Updated Successfully!");
                        $state.go("app.hospital.accounts.formAccountCenter.list");
                    } else {
                        logger.logError("Not Updated!");
                    }
                }).error(function(data) {
                });
            }
        }

        $scope.cancel = function() {
            $state.go("app.hospital.accounts.formAccountCenter.list");
        };

    //});

});