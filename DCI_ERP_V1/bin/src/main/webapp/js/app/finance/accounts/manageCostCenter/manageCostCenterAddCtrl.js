//define([ 'hospital/accounts/accounts' ], function(module) {
  //  'use strict';
    app.controller('manageCostCenterAddCtrl', function($scope,$stateParams, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService) {
        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        
        $scope.companyList =[];


        $scope.manageCostCenter = {
            costCenterName : '',
            costCenterId : '',
            costCenterCode : '',
            companyId :'C0002',
            costCenterDescription : '',
            status : '',
            isEdit : false

        };

        $scope.isEdit = false;
        
     /*   //companylist
        $scope.getDropdownvalue = function() {
            $http.get($stateParams.tenantid + 'app/commonUtility/getCompanyListPurchase').success(function(datas) {
                $scope.companyList = datas;
                }).error(function(datas) {
            });
            
        }
        $scope.getDropdownvalue();
        */

        
        $http.get($stateParams.tenantid + '/app/commonUtility/getCompanyListPurchase').success(function(datas) {	  
            $scope.companyList = datas;
  	}).error(function(data) {

  	});	
        

        var costCenterId = $location.search().costCenterId;

        if (costCenterId == undefined || costCenterId == '' || costCenterId == undefined) {
            $scope.manageCostCenter.isEdit = false;
        } else {
            $http.post("hospital/accounts/manageCostCenter/edit", costCenterId).success(function(response) {
                if (response.manageCostCenterBean != null) {
                    $scope.manageCostCenter.isEdit = true;
                    $scope.manageCostCenter = response.manageCostCenterBean;
                }
            });

        }

        $scope.submit = function(manageCostCenterAdd) {
            if (new validationService().checkFormValidity(manageCostCenterAdd)) {
                $http.post("hospital/accounts/manageCostCenter/save", $scope.manageCostCenter).success(function(response) {
                    if (response == true) {
                        logger.logSuccess("Saved Successfully!");
                        $state.go('app.finance.accounts.manageCostCenter.list');
                    } else {
                        logger.logError("Not Saved!");
                    }

                });
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(manageCostCenterAdd.$validationSummary), 5000, 'trustedHtml');
            }

        }

        $scope.cancel = function() {
            $state.go('app.finance.accounts.manageCostCenter.list');
        };

        $scope.update = function(parameterAddForm) {
            if (new validationService().checkFormValidity(parameterAddForm)) {
                $http.post("hospital/accounts/manageCostCenter/update", $scope.manageCostCenter).success(function(response) {
                    if (response == true) {
                        logger.logSuccess("Updated Successfully!");
                        $state.go('app.finance.accounts.manageCostCenter.list');
                    } else {
                        logger.logError("Not Updated!");
                    }

                });
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(parameterAddForm.$validationSummary), 5000, 'trustedHtml');
            }

        }
    })
//});