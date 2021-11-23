/*define([ 'hospital/inventory/inventory' ], function(module) {

    'use strict';
    module.registerController('gatePassListCtrl', function($scope, $window, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {*/
    
    app.controller('gatePassListCtrl', function($scope, $state, $window, $rootScope, $location, $http, logger, $log, ngDialog, $modal, utilsService) {
    
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages = 0;

        $scope.isDisplay = false;
        $scope.isUpload = true;
        $scope.isDelete = true;

        $scope.add = function() {
            $state.go("app.finance.inventory.gatePass.add");
        };

        $scope.getGatePassList = function() {
            $http.get("his/inventory/gatePass/list").success(function(response) {
                $scope.rowCollection = response.gatePassList;
            });
        }
        $scope.getGatePassList();

        $scope.editRow = function(gatepassId) {
            $location.url('/hospital/inventory/gatePass/add?gatepassId=' + gatepassId);
        };
        
        
        //print
        $scope.GRNprint = function(gatepassId){
            //var url='/hospital/inventory/gatePass/print?gatepassId='+gatepassId;
            var url='his/inventory/gatePass/print?gatepassId='+gatepassId;

            var wnd = $window.open(url, 'Omega', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
           // wnd.print();  
            if (wnd.print) {
                var done = false;
                if (wnd.document && wnd.document.readyState) {
                    var rs = wnd.document.readyState;
                    if ((rs === 'complete') || (rs === 'loaded')) {
                        done = true;
                        wnd.print();
                    }
                }
                if (!done) {
                    if (wnd.addEventListener) {
                        wnd.addEventListener('load', function() {
                            this.print();
                        });
                    } else {
                        wnd.onload = function() {
                            this.print();
                        };
                    }
                }
            }
         
        } 

        $scope.deleteRow = function(gatepassId) {
            ngDialog.openConfirm().then(function() {
                $http.post("his/inventory/gatePass/delete", gatepassId).success(function(response) {
                    if (response.success == true) {
                        logger.logSuccess("Deleted Successfully!");
                        $scope.getGatePassList();
                    } else {
                        if (response.message != '') {
                            logger.logError(response.message);
                        }
                    }
                }).error(function(result) {
                    logger.logError("Error Please Try Again");
                });
            });
        };

    
});