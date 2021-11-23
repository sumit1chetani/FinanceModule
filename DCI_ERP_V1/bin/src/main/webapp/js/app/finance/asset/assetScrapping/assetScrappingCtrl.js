app.controller('assetScrappingAddCtrl', function($scope,$stateParams, $state, $http, $filter, ngDialog, logger,$injector, $location,validationService,sharedProperties, $controller, toaster, $rootScope) {
    
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.isUpload = true;

    $scope.numPages=0;
    
    $scope.assetScrap = {
            companyCode : '',
            assetCode : '',
            scrapDate :'',
            currentValue : ''
    }
    
    $('#cn_date').datetimepicker({
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
    $scope.assetScrap.scrapDate = today;
    
    $scope.cancel = function() {
    	 $state.go('app.finance.asset.assetaccount.assetScrappinglist',{tenantid:$stateParams.tenantid});
    };
    
    $scope.companyList = [];
    $scope.assetList = [];
    
    $scope.getDropdownvalue = function() {
        $http.get($stateParams.tenantid+'/app/finance/assetsale/getCompany').success(function(datas) {
            $scope.companyList = datas.lCompanyList;
        });
        $http.get($stateParams.tenantid+'/app/finance/assetsale/getAssetList').success(function(datas) {
            $scope.assetList = datas.lAssetList;
        });
    }
    
    $scope.getDropdownvalue();
    
    $scope.$watch('assetScrap.assetCode', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
            $http.post($stateParams.tenantid+'/app/finance/assetsale/getAssetCurrentValue',newValue).success(function(datas) {
                $scope.assetScrap.currentValue = datas.currentValue;
            }); 
        }
   });
    
    
    $scope.submit = function(assetScrapForm,assetScrap) {
        if (new validationService().checkFormValidity($scope.assetScrapForm)) {
            $scope.saveAssetScrap();
        } else {
            toaster.pop('error', "Please fill the required fields", 
                    logger.getErrorHtmlNew($scope.assetScrapForm.$validationSummary), 5000, 'trustedHtml');
        }
    }
    
    $scope.saveAssetScrap=function(){
        $http.post($stateParams.tenantid+'/app/finance/assetsale/saveAssetScrap',$scope.assetScrap).success(function(datas) {
           if(datas.success){
               logger.logSuccess("Saved successfully");           
               
               $state.go('app.finance.asset.assetaccount.assetScrappinglist',{tenantid:$stateParams.tenantid});
           }              
           else
               logger.logError("Unable to save");
        }); 
    }
});

app.controller('assetScrappingListCtrl', function($scope, $stateParams,$state, $http, $filter, ngDialog, logger, 
        $injector, $location,validationService, 
    sharedProperties, $controller, toaster, $rootScope) {


    
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.isUpload = true;

    $scope.numPages=0;
    
    
    $scope.getAssetScrapList = function() {
        
        $http.get($stateParams.tenantid+'/app/finance/assetsale/getAssetScrapList').success(function(data) {
            console.log(data);  
                $scope.rowCollection = $scope.rowCollection.concat(data.lAssetScrapList);
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
    };

    $scope.getAssetScrapList();
    
    $scope.printJournalVoucherDiv = function(journalNo){
        var url = $stateParams.tenantid+'/app/journalVoucher/print?journalNo=' + journalNo;
        var wnd = window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
        wnd.print();   
     }
    

    $scope.add=function(){      
        $state.go('app.finance.asset.assetaccount.assetScrappingadd',{tenantid:$stateParams.tenantid});
    }
});
