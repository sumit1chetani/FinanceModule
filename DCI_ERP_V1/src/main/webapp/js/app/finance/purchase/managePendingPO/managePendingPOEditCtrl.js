define([ 'hospital/purchase/purchase' ], function(module) {

    'use strict';
    module.registerController('managePendingPOAddCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {
        
        $scope.purchaseData = {
                vendorId : '',
                city : '',
                state : '',
                zipcode : '',
                country : '',
                desCity : '',
                desState : '',
                desZipcode : '',
                desCountry : ''
        }
        $scope.venAddress = false;
        
        $scope.cancel = function(){
            $state.go("app.hospital.purchase.managePendingPO.list");
        }
        
        $scope.save = function(){
            $state.go("app.hospital.purchase.managePendingPO.list");
            logger.logSuccess("Saved Successfully");
        }
        
        $scope.getVendorAdd = function(venId){
            if(venId != null && venId != ""){
                $scope.venAddress = true;
            }else{
                $scope.venAddress = false;
            }
        }
        
        $scope.getVenAdd = function(cityId){
            if(cityId == 1){
                $scope.purchaseData.state = "Maharashtra";
                $scope.purchaseData.zipcode = "600256";
                $scope.purchaseData.country = "India";
            }else if(cityId == 2){
                $scope.purchaseData.state = "Kalang";
                $scope.purchaseData.zipcode = "350142";
                $scope.purchaseData.country = "Singapore";
            }
            else{
                $scope.purchaseData.state = "";
                $scope.purchaseData.zipcode = "";
                $scope.purchaseData.country = "";
            }
        }
        
        $scope.getDesAdd = function(cityId){
            if(cityId == 1){
                $scope.purchaseData.desState = "Maharashtra";
                $scope.purchaseData.desZipcode = "600256";
                $scope.purchaseData.desCountry = "India";
            }else if(cityId == 2){
                $scope.purchaseData.desState = "Kalang";
                $scope.purchaseData.desZipcode = "350142";
                $scope.purchaseData.desCountry = "Singapore";
            }
            else{
                $scope.purchaseData.desState = "";
                $scope.purchaseData.desZipcode = "";
                $scope.purchaseData.desCountry = "";
            }
        }
        
        
        $scope.addPurchaseRow = function() {
            $scope.callDialog($scope, 0, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope);
        }
        
        $scope.callDialog = function($scope, requestCode, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope) {
            ngDialog.open({
                scope : $scope,
                template : 'views/hospital/purchase/managePendingPO/ManagePendingPOListAdd',
                controller : $controller('managePendingPOListAddCtrl', {
                    $scope : $scope,
                    requestCode : requestCode,
                    $http : $http,
                    ngDialog : ngDialog,
                    logger : logger,
                    $injector : $injector,
                    sharedProperties : sharedProperties,
                    toaster : toaster,
                    $rootScope : $rootScope
                }),
                className : 'ngdialog-theme-plain',
                showClose : false,
                closeByDocument : false,
                closeByEscape : false,
                preCloseCallback : $scope.getList
            });
        }
        
//      //load table
//        $scope.loadpurchaseTable = function() {
//            var purchaseTable = {};
//           
//            purchaseTable.purchaseTableRow = [{
//            }];
//            $scope.purchaseData.purchaseTables.push(purchaseTable);                 
//        }
//        $scope.loadpurchaseTable();
//        
//      //add Row 
//        $scope.addPurchaseRow = function(tables) { 
//          var len = tables.purchaseTableRow.length;
//          var table = {
//                  rowheader : []
//          };
//          tables.purchaseTableRow.push(table);
//        };
//        
//        
//        //remove Row
//        $scope.removePurchaseRow = function(table) {
//            $scope.tablerow = [];
//            angular.forEach(table.purchaseTableRow, function(row, index) {
//                var check = row.select;
//                if (check == undefined || check == "") {
//                    $scope.tablerow.push(row);
//                } else {
//
//                }
//            });
//            table.purchaseTableRow = $scope.tablerow;            
//        };
        
        
    });
    
    module.registerController('managePendingPOListAddCtrl', function($scope, $http, ngDialog, logger, requestCode, $injector, sharedProperties, toaster, $rootScope) {
        
        $scope.isEdit = false;
        $scope.cancelReq = function() {
            ngDialog.close();
        };
        
        $scope.addQuoteList = {
               status:'1',
        }
        
        $scope.reqAddress = false;
        
        $scope.getRequestAdd = function(reqId){
            if(reqId != null && reqId != ""){
                $scope.reqAddress = true;
            }else{
                $scope.reqAddress = false;
            }
        }
        
    });    
    

});