//define([ 'hospital/accounts/accounts' ], function(module) {

    //'use strict';
    app.controller('cashpaymentListCtrl', function($scope, $state,$stateParams, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {

        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.isUpload = true;
        $scope.isDelete = true;
        $scope.emptyObject = {};

        
        $scope.accountHeadData = {
                accountHeadCode : '',
                subGroupAccountCode : '',
                accountHeadName : '',
                subGroupAccountName : '',
                currencyCode : 'INR',
                acctHeadStatus : true,
                lAttributes : [],
                edit : false

            };
        
        $scope.getList = function() {
            var url = 'app/paymentreceipt/list?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount;
            $http.get(url).success(function(data) {
                if (data.success == true) {
                    $scope.rowCollection = $scope.rowCollection.concat(data.lAccountHeadMasterBeanBean);
                    sharedProperties.setObject($scope.emptyObject);
                }
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
            $scope.offsetCount = $scope.offsetCount + $scope.limitCount;
        };

        $scope.getList();
        
        


        
        $scope.exportExcel = function(){

            $http.post('app/paymentreceipt/ExportExcel', $scope.accountHeadData).success(function(response) {
                if(response){
                    debugger;
                    $("#budgetExport").bind('click', function() {
                    });
                    $('#budgetExport').simulateClick('click');
                    logger.logSuccess("Exported successfully!");
                }else{
                    logger.logError("Failed to export");
                }
                
            }).error(function(response) {
                logger.logError("Error Please Try Again");
            });

            }


        $.fn.simulateClick = function() {
        return this.each(function() {
            if ('createEvent' in document) {
                var doc = this.ownerDocument, evt = doc.createEvent('MouseEvents');
                evt.initMouseEvent('click', true, true, doc.defaultView, 1, 0, 0, 0, 0, false, false, false, false, 0, null);
                this.dispatchEvent(evt);
            } else {
                this.click(); // IE
            }
        });
        }

        $scope.add = function() {
            $state.go("app.finance.accounts.managepaymentreceipt.add");
        };

        $scope.editRow = function(PrCode) {

            $location.url($stateParams.tenantid+'/hospital/accounts/Paymentreceipt/add?PrCode=' + PrCode);
        };

        $scope.deleteRow = function(accCode, index) {

            ngDialog.openConfirm().then(function() {
                var myURL = 'app/paymentreceipt/delete';
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

//});