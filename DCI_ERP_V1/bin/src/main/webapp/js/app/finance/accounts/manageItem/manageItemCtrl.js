//define([ 'hospital/purchase/purchase' ], function(module) {

'use strict';

    app.controller('manageItemListCtrl', function($scope,$state,$http,$location,ngDialog,logger) {
    
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;

        $scope.numPages=0;
        $scope.isDisplay = false;
        $scope.isUpload=true;
        $scope.isDelete=true;

        $scope.add = function(){
            $state.go("app.finance.accounts.manageitem.add");
        };
        
        
        $scope.getManageItemList = function() {
            $http.get('hospital/inventory/manageitem/list').success(function(data) {
                if (data.success) {
                    $scope.rowCollection = data.itemList;
               } else {
                    logger.logError("Error Please Try Again");
                }
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        };

       $scope.getManageItemList();

       $scope.editRow = function(manageItem) {
           debugger;
           $state.go('app.finance.accounts.manageitem.edit',({ itemId: manageItem.itemId}));
       }
       $scope.deleteRow=function(manageItem,index){
           ngDialog.openConfirm().then(function() {
           var itemId=manageItem.itemId;
           var myURL = 'hospital/inventory/manageitem/delete';
           $http({
               method : 'post',
               url : myURL,
               data : itemId,
           }).success(function(data) {
               if (data) {
                   var tableData = $scope.rowCollection;
                   $scope.rowCollection.splice(index, 1);
                   logger.logSuccess("Deleted successfully");
                   $state.reload();
               } else {
                   logger.logError("Error in delete!");
               }
           }).error(function(data) {
               logger.logSuccess("Error in Delete!");
           });                  
           });

       }
       
       $scope.viewRow = function(manageItem) {
           $state.go('app.finance.accounts.manageitem.view',({ itemId: manageItem.itemId}));
       }
    
       
       $scope.exportExcel = function(managerequest) {
           debugger;
//           $scope.managerequest = "";
           $http.post('hospital/inventory/manageitem/exportManageItemReport', managerequest[0]).success(function(data) {
               if (data) {
                   debugger;

                   $('#manageitemExcel').append('<a id="exportdown" stype="display:none" href="tempdoc/Manageitemdetail.xls" class="control-label" download="Manageitemdetail.xls"></a>');

                   $("#exportdown").bind('click', function() {
                   });
                   $('#exportdown').simulateClick('click');
                   
                   
                   
                   logger.logSuccess("Exported successfully!");
               } else {
                   logger.logError("Failed to export");
               }

           }).error(function(response) {
               logger.logError("Error Please Try Again");
           });

       }

      /* $.fn.simulateClick = function() {
           return this.each(function() {
               if ('createEvent' in document) {
                   var doc = this.ownerDocument, evt = doc.createEvent('MouseEvents');
                   evt.initMouseEvent('click', true, true, doc.defaultView, 1, 0, 0, 0, 0, false, false, false, false, 0, null);
                   this.dispatchEvent(evt);
               } else {
                   this.click(); // IE
               }
           });
       }*/
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
   
});
//});
    





    