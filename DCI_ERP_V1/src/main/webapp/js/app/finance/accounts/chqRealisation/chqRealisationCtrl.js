//define([ 'hospital/accounts/accounts' ], function(module) {

    'use strict';
    app.controller('realisationCtrl', function($scope, $stateParams,$rootScope, $http, $location, logger, utilsService, ngDialog, $state, sharedProperties, $window) {

        $scope.dataLoopCount = 0;
        $scope.from = 0;
        $scope.to = 100;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.isUpload = true;
        $scope.isDelete = true;
        $scope.getJVSwapAccListUtil = function(limit, offset) {
            var start = new Date().getTime();
            var url = 'app/chqPresentation/realisationList?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount;
            $http.get(url).success(function(data) {
                if (data.success == true) {
                    $scope.pushJVSwapListUtil(data);
                    $scope.dataLoopCount++;
                } else {
                    if ($scope.dataLoopCount == 0) {
                        $scope.showEmptyLabel = true;
                    }
                    logger.logError("Error Please Try Again");
                }
                var end = new Date().getTime();
                var time = end - start;
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });

        };
        $scope.pushJVSwapListUtil = function(data) {
            if (utilsService.isUndefinedOrNull(data.swapMasterList)) {

                $scope.showEmptyLabel = true;

            } else {

                $scope.rowCollection = $scope.rowCollection.concat(data.swapMasterList);

            }
        };
        $scope.getJVSwapAccListUtil();

        $scope.add = function() {
            $state.go('app.finance.accounts.chqRealisation.add');
        };

        $scope.editSwapAcc = function(prCode) {
            $location.url($stateParams.tenantid +'/hospital/accounts/chqRealisation/add?prCode=' + prCode);

        };

    });

    'use strict';
    app.controller('realisationAddCtrl', function($scope, $window,$stateParams, $rootScope, $location, $http, logger, $log, ngDialog, $modal, $state, utilsService, $timeout, toaster, validationService) {

        $scope.realisation = {
            prCode : '',
            customerCode : '',
            customerName : '',
            chqNo : '',
            chqDate : '',
            chqAmnt : '',
            presentDate : '',
            status : '',
            realisedDate : '',
            companyCode : '',
            companyName : '',
            drwnBank : '',
            depositBank : '',
            chqRcvdDate : ''
        };

        $scope.customerList = [];
        $scope.presentationList = [];
        $scope.statusList = [];
        $scope.isEdit = false;

        angular.element(document).ready(function() {
            if ($scope.isEdit) {
                $("#presentId").attr("disabled", true);

            } else {
                $("#presentId").attr("disabled", false);
            }
        });

        $scope.onLoadDropdowns = function() {

            $http.get('app/chqPresentation/getPresentationList').success(function(datas) {
                $scope.presentationList = datas.lCommonUtilityBean;
            }).error(function(datas) {
             //   $scope.presentationList = [];
            });
            $http.get('app/chqPresentation/getchequelist').success(function(data) {
                $scope.customerList = data.lCommonUtilityBean;
            }).error(function(datas) {
            });
        };
        $scope.onLoadDropdowns();

        $scope.statusList.push({
            id : 'Bounce',
            text : 'Bounce'
        });
        $scope.statusList.push({
            id : 'Pass',
            text : 'Pass'
        });

        $scope.$watch('realisation.prCode', function(newValue, oldValue) {

            if (newValue != '' && newValue != undefined) {

                angular.forEach($scope.presentationList, function(value, indexs) {
                    if (newValue == value.id) {
                        $scope.realisation.chqNo = value.chqNo;
                        $scope.realisation.customerName = value.customerName;
                        $scope.realisation.customerCode = value.customerCode;
                        $scope.realisation.chqAmnt = value.chqAmnt;
                    }
                });
            } else {
                $scope.realisation.chqNo = '';
                $scope.realisation.customerName = '';
                $scope.realisation.customerCode = '';
                $scope.realisation.chqAmnt = '';
            }

        });

        var today = new Date();
        var dd = today.getDate();
        var mm = today.getMonth() + 1;

        var yyyy = today.getFullYear();
        if (dd < 10) {
            dd = '0' + dd;
        }
        if (mm < 10) {
            mm = '0' + mm;
        }
        var today = dd + '/' + mm + '/' + yyyy;
        $scope.realisation.realisedDate = today;

        $scope.onSubmit = function(realisationAdd) {

            if (new validationService().checkFormValidity(realisationAdd)) {
                $scope.save();
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(realisationAdd.$validationSummary), 555000, 'trustedHtml');
            }
        };

        $scope.save = function() {

            if ($scope.isEdit == false) {

                $http.post('app/chqPresentation/saveRealisation', $scope.realisation).success(function(data) {
                    if (data == true) {
                        logger.logSuccess("Cheque Realisation Saved Successfully!");
                        $location.path($stateParams.tenantid +'/hospital/accounts/chqRealisation/list');
                    } else {
                        logger.logError("Unable to Save");
                    }
                }).error(function(data) {
                });
            } else {

                $http.post('app/chqPresentation/saveRealisation', $scope.realisation).success(function(data) {
                    if (data == true) {
                        logger.logSuccess("Cheque Realisation Updated Successfully!");
                        $location.path($stateParams.tenantid +'/hospital/accounts/chqRealisation/list');
                    } else {
                        logger.logError("Unable to Update");
                    }
                }).error(function(data) {
                });
            }
        };

        $scope.cancel = function() {
            //$location.path("hospital/accounts/chqRealisation/list");
            $state.go('app.finance.accounts.chqRealisation.list');

        };

        /*
         * 
         * Edit Functionality
         */

        var prCode = $location.search().prCode;

        if (prCode != undefined) {
            var formData = new FormData();
            formData.append("prCode", prCode);
            $scope.isEdit = true;
            $scope.presentationList = [];
            $http.get('app/chqPresentation/getDataforEdit?prCode=' + prCode).success(function(data) {

                $http.get('app/chqPresentation/getPresentationListEdit').success(function(datas) {
                    $scope.presentationList = datas;
                }).error(function(datas) {
                    $scope.presentationList = [];
                });

                $scope.realisation = data;

            }).error(function(data) {
                logger.logError("Unable to Get Data");
            });

            $("#presentId").attr("disabled", true);

        } else {
            $scope.isEdit = false;
            $("#presentId").attr("disabled", false);
        }
    //});
});