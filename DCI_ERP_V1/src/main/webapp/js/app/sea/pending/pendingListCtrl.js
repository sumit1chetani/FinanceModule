
	'use strict';

	app.controller('pendingListCtrl', function($scope, $rootScope,ngDialog, $http, $location, logger,
	        utilsService,$state,sharedProperties,$window,validationService,toaster,$stateParams) {
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages = 0;
        $scope.isDisplay = true;
        $scope.isUpload = true;
        $scope.rowCollection = [];
        $scope.statusList=[];
        $scope.itemList = [];
        $scope.vendorList = [];
        $scope.add = function(){
            $state.go("app.sea.pending.add");
        }
        $scope.purchaseFilter= {
                startDate:'',
                endDate:'',
                vendorId:'',
                itemId:'',
                statusId:''
        };
       
        $scope.purchaseFilter.startDate = moment().startOf('month').format('DD/MM/YYYY');
        $scope.purchaseFilter.endDate = moment().format('DD/MM/YYYY');
        $scope.isShow = true;
        var filter = angular.copy($scope.purchaseFilter);
              
        $scope.getListOfDropdowns = function() {
            $http.get('app/master/pending/filterDropDownList').success(function(data) {
                if (data.success == true) {
                    $scope.itemList=data.itemList;
                    $scope.vendorList = data.vendorList;
                    $scope.statusList= data.purchaseStatus;
                }
            });
        };
        $scope.getListOfDropdowns();
        
        $scope.editRow =function(collections){
            $location.url('/master/pending/add?purchaseOrderId='+collections.purchaseOrderId);
           
        }
        
        $scope.deleteRow=function(collections){
            ngDialog.openConfirm().then(function() { 
            var url='app/master/pending/deletePurchaseOrder?purchaseOrderId='+collections.purchaseOrderId;
            $http.get(url).success(function(success){
                if(success){
                    logger.logSuccess("Purchase Order deleted successfully");
                    $scope.getPurchaseOrderList();
                }else{
                    logger.logError("Error Please Try Again");
                }
            }).error(function(data) {
                logger.logSuccess("Error in Delete!");
            });
            }, function(reason) {
                console.log('Modal promise rejected. Reason: ', reason);
            });
        };
        $scope.viewRow = function(collections){
            $location.url('/master/pending/view?purchaseOrderId='+collections.purchaseOrderId); 
        };
       $scope.filterPurchaseOrder = function(purchaseFilter){
           console.log("purchaseFilter");
           console.log(purchaseFilter);
          // if($scope.validateFilterOptions(purchaseFilter)){
           $http.post('app/master/pending/filteredPurchaseOrderList', purchaseFilter).success(function(data) {
               if(data.success == true){
                   $scope.rowCollection = data.purchaseOrders;
                   $scope.isShow = false;
               }else{
                   logger.logError("Error Please Try Again");
               }
           });
        //   }
       };
       $scope.validateFilterOptions = function(purchaseFilter){
         $scope.isValid = true;
         if(purchaseFilter.startDate !='' && purchaseFilter.endDate != ''){
             $scope.isValid = false;
                         if(moment(purchaseFilter.startDate).isSame(purchaseFilter.endDate)||
                                 moment(purchaseFilter.endDate).isAfter(purchaseFilter.startDate)){
                             $scope.isValid = true;
                         }else{
                             logger.logError("PO End Date Should Not Be Less Than Po Start Date");
                         }
         }
         return $scope.isValid ;
       };
       
       $scope.filterPurchaseOrder(filter);
        
        
    });
    
