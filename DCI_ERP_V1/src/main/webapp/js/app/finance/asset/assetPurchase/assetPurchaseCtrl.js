'use strict';
app.controller('assetPurchaseListCtrl', function($scope, $rootScope,$stateParams, $http, $location, logger, $log, ngDialog, $modal, utilsService, sharedProperties, $state) {

    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
  
  
    $scope.getAssetPurchaseList = function() {
       
        $http.get($stateParams.tenantid+'/app/purchaseAsset/list').success(function(data) {
            debugger;
           if (data.success == true && !utilsService.isUndefinedOrNull(data.lAssetList)) {
                $scope.rowCollection = $scope.rowCollection.concat(data.lAssetList);
                console.log($scope.rowCollection);
            }
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
    };

   $scope.getAssetPurchaseList();

   
    $scope.add = function(){
        $state.go('app.finance.asset.assetaccounting.assetPurchase.add');
    };

 });


app.controller('assetPurchaseAddCtrl', function($scope, $rootScope,sharedProperties, logger,$http,$filter, $location,$stateParams, validationService, toaster,$state,$timeout,$window) {
        $scope.purchaseAssetData = {
            assetNo : '',
            company : '',
            accountHeadCode:'',
            supplier : '',
            supplierName:'',
            description : '',
            partyInvoiceNo : '',
            partyInvoiceDate : '',
            currency : '',
            exchangeRate : '',
            puchaseInvoiceDate : '',
            bcAmount : '',
            tcAmount : '',
            dueDate  :''
        };

        $('#pi_date').datetimepicker({
            format : 'DD/MM/YYYY',
            pickTime: false
        });
        $('#party_date').datetimepicker({
            format : 'DD/MM/YYYY',
            pickTime: false
        });
         $('#du_date').datetimepicker({
            format : 'DD/MM/YYYY',
            pickTime: false
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
        $scope.purchaseAssetData.puchaseInvoiceDate = today;
       // $scope.purchaseAssetData.partyInvoiceDate = today;
        $scope.purchaseAssetData.dueDate = today;

        $scope.cancel = function() {
            $state.go('app.finance.asset.assetaccounting.assetPurchase.list');
        };

        $scope.$watch('purchaseAssetData.AssetNo', function(newValue, oldValue) {
            debugger;
            if (newValue != '' && newValue != undefined) {
                $http.post($stateParams.tenantid+'/app/purchaseAsset/getAssetInfo', newValue).success(function(datas) {
                    $scope.purchaseAssetData.company = datas.company ;
                    $scope.purchaseAssetData.accountHeadCode= datas.accountHeadCode ;
                    $scope.purchaseAssetData.supplier = datas.supplier ;
                    $scope.purchaseAssetData.supplierName= datas.supplierName ;
                    $scope.purchaseAssetData.description= datas.description ;
                    $scope.purchaseAssetData.partyInvoiceNo = datas.partyInvoiceNo ;
                    $scope.purchaseAssetData.partyInvoiceDate = datas.partyInvoiceDate ;
                    $scope.purchaseAssetData.currency = datas.currency ;
                    $scope.purchaseAssetData.exchangeRate = datas.exchangeRate ;
                    $scope.purchaseAssetData.bcAmount = datas.bcAmount ;
                    $scope.purchaseAssetData.tcAmount= datas.tcAmount ;
                    $scope.purchaseAssetData.assetNo =newValue;
                    $http.get($stateParams.tenantid+'/app/generalinvoice/getCompanyCurrency?CompanyCode='+datas.company).success(function(datas) {
                        $scope.companyCurrency=datas.CurrencyCode;
                        }).error(function(datas) {
                    });
                }).error(function(datas) {
                    logger.logError("Error Please Try Again");
                });
            }else{
                
            }
       });
        
        $scope.getUnInvoicedAssetList = function() {
            
            $http.get($stateParams.tenantid+'/app/purchaseAsset/getUnInvoicedAssetList').success(function(data) {
                $scope.AssetList=data.lAssetList;
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        };
        
        $scope.getUnInvoicedAssetList();
        
        $scope.getCompanyList = function() {
            
            $http.get($stateParams.tenantid+'/app/commonUtility/getCompanyList').success(function(data) {
                $scope.companyList=data;
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        };
        $scope.getCompanyList();
        // save functionality
        
       $scope.onSubmit = function(purchaseAssetForm,purchaseAssetData) {
           console.log($scope.purchaseAssetData);
           $scope.purchaseAssetData.puchaseInvoiceDate = $('#purchase_invoice_date').val();
           $scope.purchaseAssetData.partyInvoiceDate = $('#party_invoice_date').val();
           $scope.purchaseAssetData.dueDate = $('#due_date').val();

           if (new validationService().checkFormValidity($scope.purchaseAssetForm)) {
               $scope.save();
           } else {
               toaster.pop('error', "Please fill the required fields", 
                       logger.getErrorHtmlNew($scope.purchaseAssetForm.$validationSummary), 5000, 'trustedHtml');
           }
       };
       
       
       $scope.save = function(){
                   $http.post($stateParams.tenantid+'/app/purchaseAsset/saveAssetPurchase', $scope.purchaseAssetData).success(function(result) {
                   if (result.success) {
                       $state.go('app.finance.asset.assetaccounting.assetPurchase.list');
                       logger.logSuccess("Purchase of Asset saved successfully");
                       
                       var purchaseInvoiceNo = result.purchaseInvoiceNo;
                       $timeout(function() {
                           var url = $stateParams.tenantid+'/app/purchaseinvoice/print?purInvNo=' + purchaseInvoiceNo;
                           var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
                           wnd.print();
                       }, 1000);
                       
                   } else {
                       logger.logError("Purchase of Asset saved unsucessfull");
                   }

               }).

               error(function(data) {
                   console.log(data);
               });
       }

});
