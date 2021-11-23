app.controller('assetSaleAddCtrl', function($scope,$state,$http,$location,ngDialog,logger,validationService,toaster,$stateParams) {
            
            $scope.offsetCount = 0;
            $scope.limitCount = 1000;
            $scope.rowCollection = [];
            $scope.displayedCollection = [];
            $scope.itemsByPage = 10;
            $scope.isUpload = true;

            $scope.numPages=0;
            
            $scope.assetSale = {
                    companyCode : '',
                    assetCode : '',
                    customerCode :'',
                    contactPerson : '',
                    saleDate :'',
                    currentValue : '',
                    saleValue : ''
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
            $scope.assetSale.saleDate = today;
            
            $scope.cancel = function() {
            	$state.go("app.finance.asset.assetaccounting.assetsale.list",{tenantid:$stateParams.tenantid});
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
                $http.get($stateParams.tenantid+'/app/commonUtility/getSubAccountCodeListTradeDebtorsCP').success(function(datas) {
                    $scope.customerList = datas;
                    }).error(function(datas) {
                });
            }
            
            $scope.getDropdownvalue();
            
            $scope.$watch('assetSale.assetCode', function(newValue, oldValue) {
                if (newValue != '' && newValue != undefined) {
                    $http.post($stateParams.tenantid+'/app/finance/assetsale/getAssetCurrentValue',newValue).success(function(datas) {
                        $scope.assetSale.currentValue = datas.currentValue;
                    }); 
                }
           });
            
            
            $scope.submit = function(assetSaleForm,assetSale) {
                if (new validationService().checkFormValidity($scope.assetSaleForm)) {
                    $scope.saveAssetSale();
                } else {
                    toaster.pop('error', "Please fill the required fields", 
                            logger.getErrorHtmlNew($scope.assetSaleForm.$validationSummary), 5000, 'trustedHtml');
                }
            }
            
            $scope.saveAssetSale=function(){
                $http.post($stateParams.tenantid+'/app/finance/assetsale/saveAssetSale',$scope.assetSale).success(function(datas) {
                   if(datas.success){
                       logger.logSuccess("Saved successfully");                       
                       $state.go("app.finance.asset.assetaccounting.assetsale.list",{tenantid:$stateParams.tenantid});
                   }
                   else
                       logger.logError("Unable to save");
                }); 
            }
        });
        
        
