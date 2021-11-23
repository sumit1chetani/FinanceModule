//define([ 'hospital/accounts/accounts' ], function(module) {

   // 'use strict';
    app.controller('chequeStatusReportCtrl', function($scope, $window, $rootScope, $location, $stateParams, $http, logger, $log, ngDialog, $modal, $state, utilsService, $timeout, toaster, validationService) {

        $scope.dataLoopCount = 0;
        $scope.from = 0;
        $scope.to = 100;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;

        $scope.isDelete = true;
        $scope.isUpload = true;
        $scope.isAdd = true;
      
        $scope.chqStatusRprt = {
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

        $scope.customerList = [];
        $scope.companyList = [];

        $scope.onLoadDropdowns = function() {

            $http.get('app/generalinvoice/getCompanyList').success(function(datas) {
                $scope.companyList = datas;
            }).error(function(datas) {
            });

            $http.get('app/generalinvoice/getCustomerList').success(function(data) {
                $scope.customerList = data;
            }).error(function(datas) {
            });

        };
        $scope.onLoadDropdowns();

        $scope.onSubmit = function(presentationAdd, presentation) {

            if (new validationService().checkFormValidity(presentationAdd)) {
                $scope.getChqStatusRprtList();
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(presentationAdd.$validationSummary), 555000, 'trustedHtml');
            }
        };

        $scope.getChequeReport = function(limit, offset) {
            $scope.rowCollection = [];
          /*  var start = new Date().getTime(), customer = $scope.chqStatusRprt.customerCode, company = $scope.chqStatusRprt.companyCode;
            if (customer == undefined || customer == null) {
                customer = '';
            }
            if (company == undefined || company == null) {
                company = '';
            }*/
            
            
            var customer = $scope.chqStatusRprt.customerCode, company = $scope.chqStatusRprt.companyCode;
            if (customer == undefined || customer == null) {
                customer = '';
            }
            if (company == undefined || company == null) {
                company = '';
            }

            var url = 'app/chqPresentation/chqStatusRprtList?customer=' + customer + '&company=' + company;
            $http.get(url).success(function(data) {
                if (data.success == true) {
                    $scope.pushChqStatusListUtil(data);
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
        $scope.pushChqStatusListUtil = function(data) {
            if (utilsService.isUndefinedOrNull(data.chqStatusRprtList)) {
                $scope.showEmptyLabel = true;
            } else {
                $scope.rowCollection = data.chqStatusRprtList;
            }
        };

        $scope.cancel = function() {
            $location.path( $stateParams.tenantid +'/hospital/accounts/chqPresentation/list');
        };

        $scope.exportChqExcel = function() {

            var customer = $scope.chqStatusRprt.customerCode, company = $scope.chqStatusRprt.companyCode;
            if (customer == undefined || customer == null) {
                customer = '';
            }
            if (company == undefined || company == null) {
                company = '';
            }

            $http.get('app/chqPresentation/exportExcel?customer=' + customer + '&company=' + company).success(function(data) {
                if (data.success) {
                    $window.open(data.filePath);
                    logger.logSuccess("Exported Successfully!");
                } else {
                    logger.logError("No Records Found");
                }

            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        }

   // });
});
