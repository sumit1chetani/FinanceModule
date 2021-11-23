//define([ 'hospital/accounts/accounts' ], function(module) {

    'use strict';
    app.controller('presentationCtrl', function($scope, $rootScope, $stateParams,$http, $location, logger, utilsService, ngDialog, $state, sharedProperties, $window) {

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
            var url = 'app/chqPresentation/list?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount;
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
            $state.go('app.finance.accounts.chqPresentation.add');
        };

        $scope.editPresentation = function(prCode) {
            $location.url($stateParams.tenantid +'/hospital/accounts/chqPresentation/add?prCode=' + prCode);

        };

        $scope.deleteRow = function(prCode, index) {

            ngDialog.openConfirm().then(function() {
                var myURL = 'app/chqPresentation/delete';
                $http({
                    method : 'post',
                    url : myURL,
                    data : prCode,
                }).success(function(data) {
                    if (data == true) {
                        var tableData = $scope.rowCollection;
                        $scope.rowCollection.splice(index, 1);
                        logger.logSuccess("deleted successfully");
                        $state.reload();
                    } else {
                        logger.logError("Error in deleting Record!");
                    }
                }).error(function(data) {
                    logger.logSuccess("Error in Delete!");
                });
            });

        };

    });

    'use strict';
    app.controller('presentationAddCtrl', function($scope, $window, $rootScope,$stateParams, $location, $http, logger, $log, ngDialog, $modal, $state, utilsService, $timeout, toaster, validationService) {

        $scope.presentation = {
            prCode : '',
            customerCode : '',
            customerName : '',
            chqNo : '',
            chqDate : '',
            chqAmnt : '',
            presentDate : '',
            status : '',
            realisedDate : '',
            companyCode : 'C0002',
            companyName : '',
            drwnBank : '',
            depositBank : '',
            chqRcvdDate : ''
        };
        $scope.presentation.companyCode = "C0002";

        $scope.customerList = [];
        $scope.companyList = [];
        $scope.isEdit = false;

        $scope.onLoadDropdowns = function() {
/*
            $http.get('app/generalinvoice/getCompanyList').success(function(datas) {
                $scope.companyList = datas;
            }).error(function(datas) {
            });
*/
            
            
            $http.get($stateParams.tenantid +'/app/commonUtility/getCompanyListcompany').success(function(datas) {
                $scope.companyList = datas;

                    var foundItemDest = $filter('filter')($scope.companyList, {
                        baseCompany : 1
                        
                    })[0];
                    $scope.presentation.companyCode=foundItemDest.id;
            }).error(function(datas) {
            });
            
            
            $http.get('app/chqPresentation/getchequelist').success(function(data) {
                $scope.customerList = data.lCommonUtilityBean;
            }).error(function(datas) {
            });

        };
        $scope.onLoadDropdowns();

        
        $http.get('app/journalVoucher/getAccountHeadMapList').success(function(datas) {
            $scope.cashAccountList = datas;
        }).error(function(datas) {
            logger.logError("Error Please Try Again");
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
        $scope.presentation.presentDate = today;
        $scope.presentation.chqRcvdDate = today;

        $scope.onSubmit = function(presentationAdd, presentation) {

            if (new validationService().checkFormValidity(presentationAdd)) {
                $scope.save();
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(presentationAdd.$validationSummary), 555000, 'trustedHtml');
            }
        };

        $scope.save = function() {

            if ($scope.isEdit == false) {

                $http.post('app/chqPresentation/save', $scope.presentation).success(function(data) {
                    if (data == true) {
                        logger.logSuccess("Cheque Deposit Saved Successfully!");
                        $location.path($stateParams.tenantid +'/hospital/accounts/chqPresentation/list');
                    } else {
                        logger.logError("Unable to Save");
                    }
                }).error(function(data) {
                });
            } else {
                $http.post('app/chqPresentation/update', $scope.presentation).success(function(result) {
                    if (result) {
                        logger.logSuccess("Cheque Deposit Updated Successfully!");
                        $location.path($stateParams.tenantid +'/hospital/accounts/chqPresentation/list');
                    } else {
                        logger.logError("Not Updated!");
                    }
                }).error(function(data) {
                });

            }
        };

        $scope.cancel = function() {
           // $location.path("hospital/accounts/chqPresentation/list");
            $state.go('app.finance.accounts.chqPresentation.list');

        };

        $scope.$watch('[presentation.chqRcvdDate,presentation.presentDate]', function(newValue, oldValue) {

            if (newValue != "" && newValue != undefined) {
                if ($scope.presentation.chqRcvdDate != '' && $scope.presentation.presentDate != '') {
                    var fromDate = $scope.presentation.chqRcvdDate;
                    var toDate = $scope.presentation.presentDate;
                    fromDate = fromDate.split("/");
                    fromDate = new Date(fromDate[2], fromDate[1], fromDate[0]);
                    toDate = toDate.split("/");
                    toDate = new Date(toDate[2], toDate[1], toDate[0]);
                    if (fromDate > toDate) {
                        $scope.presentation.presentDate = '';
                        logger.logError("Deposit Date should greater than Received Date");
                    }
                }
            }
        });

     /*   $scope.$watch('[presentation.chqDate,presentation.presentDate]', function(newValue, oldValue) {

            if (newValue != "" && newValue != undefined) {
                if ($scope.presentation.chqDate != '' && $scope.presentation.presentDate != '') {
                    var fromDate = $scope.presentation.presentDate;
                    var toDate = $scope.presentation.chqDate;
                    fromDate = fromDate.split("/");
                    fromDate = new Date(fromDate[2], fromDate[1], fromDate[0]);
                    toDate = toDate.split("/");
                    toDate = new Date(toDate[2], toDate[1], toDate[0]);
                    if (fromDate > toDate) {
                        $scope.presentation.chqDate = '';
                        logger.logError("Cheque Date should greater than Deposit Date");
                    }
                }
            }
        });*/

        /*
         * 
         * Edit Functionality
         */

        var prCode = $location.search().prCode;

        if (prCode != undefined) {
            var formData = new FormData();
            formData.append("prCode", prCode);
            $scope.isEdit = true;
            $http.get('app/chqPresentation/getDataforEdit?prCode=' + prCode).success(function(data) {

                $scope.presentation = data;

            }).error(function(data) {
                logger.logError("Unable to Get Data");
            });

        } else {
            $scope.isEdit = false;
        }

        $scope.onChangeNumber = function(num) {
            num = num.replace(/[^0-9 .]/g, '');
            $('#prChqAmt').val(num);
            return num;
        }

        $scope.reset = function() {
            $scope.presentation = {
                prCode : '',
                customerCode : '',
                customerName : '',
                chqNo : '',
                chqDate : '',
                chqAmnt : '',
                presentDate : today,
                status : '',
                realisedDate : '',
                companyCode : 'C0002',
                companyName : '',
                drwnBank : '',
                depositBank : '',
                chqRcvdDate : today
            };
        }

        $scope.resetEdit = function() {

            var formData = new FormData();
            formData.append("prCode", prCode);
            $scope.isEdit = true;
            $http.get('app/chqPresentation/getDataforEdit?prCode=' + prCode).success(function(data) {
                $scope.presentation = data;
            }).error(function(data) {
                logger.logError("Unable to Get Data");
            });
        }

//    });
});
