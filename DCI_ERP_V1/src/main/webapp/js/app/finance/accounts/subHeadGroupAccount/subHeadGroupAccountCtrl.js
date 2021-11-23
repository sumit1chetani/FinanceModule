//define([ 'hrms/master/master' ], function(module) {

  ///  'use strict';

    app.controller('subHeadGroupAccountListCtrl', function($scope, $state, $http,$stateParams,
            ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.initial = {};
        $scope.isUpload = true;
        $scope.isDelete = true;

        $scope.getSubGrpList = function() {
            var url = 'app/subheadgroupacct/list?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount;
            $http.get(url).success(function(data) {
                if (data.success == true) {
                    $scope.rowCollection = $scope.rowCollection.concat(data.objSubGroupAccountBeanBean);
                }
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
            $scope.offsetCount = $scope.offsetCount + $scope.limitCount;
        };

        $scope.getSubGrpList();

        $scope.add = function() {
            if ($scope.isAdd == true) {
                sharedProperties.setObject(angular.copy($scope.initial));
            }
            $state.go('app.finance.accounts.subHeadGroupAccount.add');
        };

        $scope.editRow = function(subGroupCode) {

            $location.url( $stateParams.tenantid+'/hospital/accounts/subHeadGroupAccount/add?subGroupCode=' + subGroupCode);
        };

        $scope.deleteRow = function(accCode, index) {

            ngDialog.openConfirm().then(function() {
                var myURL = 'app/subheadgroupacct/delete';
                $http({
                    method : 'post',
                    url : myURL,
                    data : accCode,
                }).success(function(data) {
                    if (data == true) {

                        $scope.rowCollection.splice(index, 1);
                        $state.reload();
                        logger.logSuccess("deleted successfully");
                    } else {
                        logger.logError("Error in deleting Record!");
                    }
                }).error(function(data) {
                    logger.logSuccess("Error in Delete!");
                });
            });

        };

    });
    app.controller('subHeadGroupAccountAddCtrl', function($scope, $state, $http, $injector, $location, ngDialog, logger, sharedProperties, toaster, $rootScope, validationService) {

        sharedProperties.getObject();
        $scope.accountType = [];
        $scope.validated = false;
        $scope.grpHeadTypeList = [];

        $scope.subGroupData = {
            grpHeadCode : '',
            sgType : '',
            subGroupName : '',
            subGroupDesc : ''

        }

        $scope.grpHeadList = function() {
            $http.get('app/subheadgroupacct/getGrpHdDrpDwn').success(function(datas) {
                if (datas.objGrpHeadBeanBean.length > 0) {
                    $scope.grpHeadTypeList = datas.objGrpHeadBeanBean;
                }
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        }

        $scope.grpHeadList();

        /**
         * ************* Fedch Data on Edit Row from list page
         * ********************
         */
        $scope.isEdit = false;
        var subGroupCode = $location.search().subGroupCode;
        if (subGroupCode == undefined) {
            $scope.isEdit = false;
        } else {
            $http.get('app/subheadgroupacct/edit?subGroupCode=' + subGroupCode).success(function(data) {
                $scope.isEdit = true;
                $scope.grpHeadTypeList = data.listGroupHead.objGrpHeadBeanBean;
                $scope.subGroupData = data.editSubGroupAccountBean;
                if (data.editSubGroupAccountBean.sgType == null) {
                    $scope.subGroupData.sgType = 'select';
                }

            }).error(function(data) {
            });
        }

        $scope.submit = function(subGroupAccountForm, subGroupData) {

            if (new validationService().checkFormValidity(subGroupAccountForm)) {
                $scope.save(subGroupAccountForm, subGroupData);
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(subGroupAccountForm.$validationSummary), 555000, 'trustedHtml');
            }
        };

        // Save Method
        $scope.save = function(subGroupAccountForm, subGroupData) {
         /* $http.post('app/subheadgroupacct/validate', subGroupData).success(function(result) {
                if(result.message=='success'){
                    logger.logError("Already exist Sub Account Name!");

                }
                else{*/
            if ($scope.isEdit) {
                $http.post('app/subheadgroupacct/update', subGroupData).success(function(result) {
                    if (result == false) {
                        logger.logError("Subgroup Account Code  Already Exist");
                    } else {
                        logger.logSuccess("Subgroup Account Code updated successfully");
                        $state.go('app.finance.accounts.subHeadGroupAccount.list');
                    }

                }).error(function(data) {
                });
            } else {
                $http.post('app/subheadgroupacct/add', subGroupData).success(function(result) {
                    if (result == false) {
                        logger.logError("Subgroup Account Name Already Exist");
                    } else {
                        logger.logSuccess("Subgroup Account Code added successfully");
                        $state.go('app.finance.accounts.subHeadGroupAccount.list');
                    }

                }).error(function(data) {
                });
            }
        
         //  }
      //  });
            }

        // cancel Functionality
        $scope.cancel = function() {
            $state.go('app.finance.accounts.subHeadGroupAccount.list');
        };

    });
//});