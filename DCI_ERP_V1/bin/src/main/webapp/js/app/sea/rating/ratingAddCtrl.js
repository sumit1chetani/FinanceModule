
     'use strict';

app.controller('ratingAddCtrl', function($scope, $rootScope, $http, $location, logger, ngDialog,
        utilsService,$state,sharedProperties,$window,$stateParams,toaster,validationService,$controller) {   
        $scope.vendorRatings = {
                purchaseTables : [],
                grnNo : '',
                poNo : '',
                date : '',
                vendor : '',
                itemName : '',
                price : '',
                quantity : '',
                status : ''
        }
        
        $scope.venAddress = false;
        
        $scope.cancel = function(){
            $state.go("app.sea.rating.list");
        }
        
        $scope.getVenRatings = function(venRatings){
            if(venRatings == 1){
                $scope.vendorRatings.poNo = "4076";
                $scope.vendorRatings.vendor = "Paragon";
                $scope.vendorRatings.itemName = "Pendrive";
                $scope.vendorRatings.price = "1000";
                $scope.vendorRatings.date = "25/08/2015";
                $scope.vendorRatings.quantity = "2";
                $scope.vendorRatings.status = "Received";
            }else if(venRatings == 2){
                $scope.vendorRatings.poNo = "1608";
                $scope.vendorRatings.vendor = "Dynamics";
                $scope.vendorRatings.itemName = "Keyboard";
                $scope.vendorRatings.price = "1400";
                $scope.vendorRatings.date = "28/08/2015";
                $scope.vendorRatings.quantity = "1";
                $scope.vendorRatings.status = "Verified";
            }
            else{
                $scope.vendorRatings.poNo = "";
                $scope.vendorRatings.vendor = "";
                $scope.vendorRatings.itemName = "";
                $scope.vendorRatings.price = "";
                $scope.vendorRatings.date = "";
                $scope.vendorRatings.quantity = "";
                $scope.vendorRatings.status = "";
            }
        }
        
        $scope.save = function(){
            if($scope.vendorRatings.grnNo != null && $scope.vendorRatings.grnNo != ''){
            logger.logSuccess("Saved Successfully");
            $state.go("app.sea.rating.list");
            }else {
                logger.logError("Please select the GRN NO"); 
            }
        }
        
        var originalTableDatas = angular.copy($scope.rowCollectionItem);

        $scope.reset = function(){
            $scope.vendorRatings.grnNo = "";
            $scope.vendorRatings.poNo = "";
            $scope.vendorRatings.vendor = "";
            $scope.vendorRatings.itemName = "";
            $scope.vendorRatings.price = "";
            $scope.vendorRatings.date = "";
            $scope.vendorRatings.quantity = "";
            $scope.vendorRatings.status = "";
            $scope.vendorRatings.purchaseTables = [];
            
        }
        
      //load table
        $scope.loadpurchaseTable = function() {
            var purchaseTable = {};
           
            purchaseTable.purchaseTableRow = [{
            }];
            $scope.vendorRatings.purchaseTables.push(purchaseTable);                 
        }
        $scope.loadpurchaseTable();
        
      //add Row 
        $scope.addPurchaseRow = function(tables) { 
          var len = tables.purchaseTableRow.length;
          var table = {
                  rowheader : []
          };
          tables.purchaseTableRow.push(table);
        };
        
        
        //remove Row
        $scope.removePurchaseRow = function(table) {
            $scope.tablerow = [];
            angular.forEach(table.purchaseTableRow, function(row, index) {
                var check = row.select;
                if (check == undefined || check == "") {
                    $scope.tablerow.push(row);
                } else {

                }
            });
            table.purchaseTableRow = $scope.tablerow;            
        };
        
        
    
    
    

});