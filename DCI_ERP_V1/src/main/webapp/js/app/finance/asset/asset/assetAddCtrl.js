app.controller('assetAddCtrl', function($scope, $state, $http, $filter, ngDialog, logger, 
        $injector, $location,validationService, 
    sharedProperties, $controller, toaster,$stateParams, $rootScope) {
    
    $scope.accountHeadList=[];
    $scope.companyList = [];
    $scope.supplierList = [];
    $scope.purchaseTypeList =[];
    $scope.isEdit = false;
    $scope.assetMasterData = {
            assetNo : '',
            categoryNo : '',
            noOfSimilarAsset : '',
            companyId : '',
            accountHeadCode: '',
            description : '',
            quantity :'',
            capitalisationDate:'',
            supplierCode:'',
            purchaseType:'',
            partyInvoiceNo:'',
            partyInvoiceDate:'',
            currencyCode:'',
            exchangeRate:'',
            totalBCAmount:'',
            totalTCAmount:'',
            assetUsefulPeriod:'',
            depStartDate:'',
            depEndDate:''
    };
    
    

    
    
    $scope.getTodayDate= function(){
        var today = new Date();
        var dd = today.getDate();
        var mm = today.getMonth() + 1;

        var yyyy = today.getFullYear();
        if (dd < 10) {
            dd = '0' + dd
        }
        if (mm < 10) {
            mm = '0' + mm
        }
        var today = dd + '/' + mm + '/' + yyyy;
        $scope.assetMasterData.capitalisationDate = today;    
    }
    $scope.getTodayDate();
    
    

	 $scope.$watch('[assetMasterData.fromDate,assetMasterData.depEndDate]', function(newValue) {

        if (newValue != "") {
            if ($scope.assetMasterData.depStartDate != '' && $scope.assetMasterData.depEndDate != '') {
                var fromDate = $scope.assetMasterData.depStartDate;
                var toDate = $scope.assetMasterData.depEndDate;
                fromDate = fromDate.split("/");
                fromDate = new Date(fromDate[2], fromDate[1], fromDate[0]);
                toDate = toDate.split("/");
                toDate = new Date(toDate[2], toDate[1], toDate[0]);
                if (fromDate <= toDate) {

                } else {
                    $scope.assetMasterData.depEndDate = '';
                    logger.logError("End Date  Should be greater than Start Date");
                }
            }
        }
    });
	 
    
    
    $scope.getpurchaseTypeList = function() {
        var data = {};
        data["id"] = "New Purchase";
        data["text"] = "New Purchase";
        $scope.purchaseTypeList.push(data);
        data = {};
        data["id"] = "Used Purchase";
        data["text"] = "Used Purchase";
        $scope.purchaseTypeList.push(data);

    }
   $scope.getpurchaseTypeList();
   

   $scope.generateAssetNo = function() {
       $http.get($stateParams.tenantid+'/app/assetmaster/getAssetNo').success(function(data) {
           debugger;
           $scope.assetMasterData.assetNo = data.assetNo;
           }).error(function(datas) {
       });
   }
   
   $scope.generateAssetNo();
   
   $scope.getDropdownvalue = function() {
        
        $http.get($stateParams.tenantid+'/app/exchangerate/getCurrencyList').success(function(datas) {
            $scope.currencyList =datas.currencyList;
        });
        
        $http.get($stateParams.tenantid+'/app/purchaseinvoice/getAccountList').success(function(datas) {
            $scope.accountHeadList = datas;
            }).error(function(datas) {
        });
        
        $http.get($stateParams.tenantid+'/app/purchaseinvoice/getSupplierList').success(function(datas) {
            $scope.supplierList = datas;
            }).error(function(datas) {
        });
        
        $http.get($stateParams.tenantid+'/app/commonUtility/getCompanyList').success(function(datas) {
            $scope.companyList = datas;
            }).error(function(datas) {
        });
        
        $http.get($stateParams.tenantid+'/app/assetmaster/getAssetCategory').success(function(datas) {
            $scope.categoryList = datas.lAssetMasterBean;
            }).error(function(datas) {
        });
    };
   
    
    $scope.getDropdownvalue();
    
    $scope.cancel = function(){
        $state.go("app.finance.asset.manage.asset.list");
    }
    $scope.isEdit = false;
    
    $scope.$watch('assetMasterData.currencyCode', function(newValue, oldValue) {
        debugger;
        if (newValue != '' && newValue != undefined) {
            // get exchange rate for currency
            $http.get($stateParams.tenantid+'/app/commonUtility/getExchangeRate?currencyCode='+newValue).success(function(data) {
                debugger;
                $scope.assetMasterData.exchangeRate=data;
            }).error(function(data) {
            });
            
        }
    });
    
    $scope.calculateBCAmount= function(tcAmount){
        $scope.assetMasterData.totalBCAmount =  Math.floor(((isNaN(parseFloat(tcAmount, 10))?0:tcAmount) / parseFloat($scope.assetMasterData.exchangeRate))*100)/100;

    }

    $scope.calculateEXrate= function(bcAmount){
        $scope.assetMasterData.exchangeRate = ($scope.assetMasterData.totalTCAmount/((isNaN(parseFloat(bcAmount, 10))?0:bcAmount))).toFixed(2);
    }
    
    $scope.submit = function(assetForm,assetMasterData) {
        if (new validationService().checkFormValidity($scope.assetForm)) {
            $scope.save();
        } else {
            toaster.pop('error', "Please fill the required fields", 
                    logger.getErrorHtmlNew($scope.assetForm.$validationSummary), 5000, 'trustedHtml');
        }
    };
    
    $scope.save = function(){
        debugger;
        console.log($scope.assetMasterData);
        $http.post($stateParams.tenantid+'/app/assetmaster/saveAssetMaster', $scope.assetMasterData).success(function(result) {
            if (result == false) {
                logger.logError("Unable to add Asset Details");
            } else {
                $state.go("app.finance.asset.manage.asset.list");
                logger.logSuccess("Asset Details added successfully");
            }
        })
    };
    
    
    
    $scope.reset= function(){
    	
      $scope.assetMasterData.categoryNo = '';
  	  $scope.assetMasterData.noOfSimilarAsset = '';
	  $scope.assetMasterData.companyId = '';
	  $scope.assetMasterData.accountHeadCode = '';
	  $scope.assetMasterData.quantity = '';
	  $scope.assetMasterData.capitalisationDate = '';
	  $scope.assetMasterData.supplierCode = '';
	  $scope.assetMasterData.partyInvoiceDate = '';
	  $scope.assetMasterData.purchaseType = '';
	  $scope.assetMasterData.partyInvoiceNo = '';
	  $scope.assetMasterData.currencyCode = '';
	  $scope.assetMasterData.totalBCAmount = '';
	  $scope.assetMasterData.totalTCAmount = '';
	  $scope.assetMasterData.assetUsefulPeriod = '';
	  $scope.assetMasterData.depStartDate = '';
	  $scope.assetMasterData.depEndDate = '';
	  $scope.assetMasterData.description = '';
	  $scope.assetMasterData.exchangeRate = '';
	  $scope.assetMasterData.assetName = '';



    }
    
    
    
  /*  
    ng-change="numberOnly(assetMasterData.noOfSimilarAsset)"
    
    $scope.numberWithDot = function(value){
        var regex = /^\d{1,20}\.?\d{0,2}$/; 
        var isValid = false;
        isValid = regex.test(value);
        if(value == ""){
        }
        if(isValid==true){
            $scope.assetMasterData.noOfSimilarAsset=value;
        }else if(isValid==false){
            $scope.assetMasterData.noOfSimilarAsset = value.slice(0,-1);
        }
    }
    
    
    

    $scope.numberOnly = function(value){
             var regex = /^\d{1,20}\.?\d{0,2}$/; 
             var isValid = false;
             isValid = regex.test(value);
             if(value == ""){
             }
             if(isValid==true){
                 $scope.assetMasterData.noOfSimilarAsset=value;
             }else if(isValid==false){
                 $scope.assetMasterData.noOfSimilarAsset = value.slice(0,-1);
             }
         }*/

    
    
    
/*    //update
    $scope.updateBtn = function(assetForm,assetMasterData) {
        if (new validationService().checkFormValidity($scope.assetForm)) {
            $scope.update();
        } else {
            toaster.pop('error', "Please fill the required fields", 
                    logger.getErrorHtmlNew($scope.assetForm.$validationSummary), 5000, 'trustedHtml');
        }
    };
    
    $scope.update = function(){
        debugger;
        console.log($scope.assetMasterData);
        $http.post('app/assetmaster/UpdateAssetMaster', $scope.assetMasterData).success(function(result) {
            if (result == false) {
                logger.logError("Unable to add Asset Details");
            } else {
                $state.go("app.finance.asset.asset.list");
                logger.logSuccess("Asset Details added successfully");
            }
        })
    };
    
    
    var assetId = $location.search().assetId;

    $http.post('app/assetmaster/editAssetMaster', assetId).success(function(result) {
        if (result) {
            $scope.assetMasterData=result;
            $scope.isEdit = true;

            $('#confDate').show();
            $('#leaveDate').show();

        }
    }).error(function(data) {
        console.log("data" + data);
    });*/
    
});





app.controller('assetEditCtrl', function($scope, $state, $http, $filter, ngDialog, logger, 
        $injector, $location,validationService, 
    sharedProperties, $controller, toaster,$stateParams, $rootScope) {
    
    $scope.accountHeadList=[];
    $scope.companyList = [];
    $scope.supplierList = [];
    $scope.purchaseTypeList =[];
    $scope.assetMasterData = {
    		
    		assetName:'',
    		assetId:'',
            assetNo : '',
            categoryNo : '',
            noOfSimilarAsset : '',
            companyId : '',
            accountHeadCode: '',
            description : '',
            quantity :'',
            capitalisationDate:'',
            supplierCode:'',
            purchaseType:'',
            partyInvoiceNo:'',
            partyInvoiceDate:'',
            currencyCode:'',
            exchangeRate:'',
            totalBCAmount:'',
            totalTCAmount:'',
            assetUsefulPeriod:'',
            depStartDate:'',
            depEndDate:''
    };
    
    $scope.getTodayDate= function(){
        var today = new Date();
        var dd = today.getDate();
        var mm = today.getMonth() + 1;

        var yyyy = today.getFullYear();
        if (dd < 10) {
            dd = '0' + dd
        }
        if (mm < 10) {
            mm = '0' + mm
        }
        var today = dd + '/' + mm + '/' + yyyy;
        $scope.assetMasterData.capitalisationDate = today;    
    }
    $scope.getTodayDate();
    
    
    

	 $scope.$watch('[assetMasterData.fromDate,assetMasterData.depEndDate]', function(newValue) {

       if (newValue != "") {
           if ($scope.assetMasterData.depStartDate != '' && $scope.assetMasterData.depEndDate != '') {
               var fromDate = $scope.assetMasterData.depStartDate;
               var toDate = $scope.assetMasterData.depEndDate;
               fromDate = fromDate.split("/");
               fromDate = new Date(fromDate[2], fromDate[1], fromDate[0]);
               toDate = toDate.split("/");
               toDate = new Date(toDate[2], toDate[1], toDate[0]);
               if (fromDate <= toDate) {

               } else {
                   $scope.assetMasterData.depEndDate = '';
                   logger.logError("End Date  Should be greater than Start Date");
               }
           }
       }
   });
    
    
    $scope.getpurchaseTypeList = function() {
        var data = {};
        data["id"] = "New Purchase";
        data["text"] = "New Purchase";
        $scope.purchaseTypeList.push(data);
        data = {};
        data["id"] = "Used Purchase";
        data["text"] = "Used Purchase";
        $scope.purchaseTypeList.push(data);

    }
   $scope.getpurchaseTypeList();
   
//   $scope.generateAssetNo = function() {
//       $http.get('app/assetmaster/getAssetNo').success(function(data) {
//           debugger;
//           $scope.assetMasterData.assetNo = data.assetNo;
//           }).error(function(datas) {
//       });
//   }
//   
//   $scope.generateAssetNo();
   
   $scope.getDropdownvalue = function() {
        
        $http.get($stateParams.tenantid+'/app/exchangerate/getCurrencyList').success(function(datas) {
            $scope.currencyList =datas.currencyList;
        });
        
        $http.get($stateParams.tenantid+'/app/purchaseinvoice/getAccountList').success(function(datas) {
            $scope.accountHeadList = datas;
            }).error(function(datas) {
        });
        
        $http.get($stateParams.tenantid+'/app/purchaseinvoice/getSupplierList').success(function(datas) {
            $scope.supplierList = datas;
            }).error(function(datas) {
        });
        
        $http.get($stateParams.tenantid+'/app/commonUtility/getCompanyList').success(function(datas) {
            $scope.companyList = datas;
            }).error(function(datas) {
        });
        
        $http.get($stateParams.tenantid+'/app/assetmaster/getAssetCategory').success(function(datas) {
            $scope.categoryList = datas.lAssetMasterBean;
            }).error(function(datas) {
        });
    };
    
    $scope.getDropdownvalue();
    
    $scope.cancel = function(){
        $state.go("app.finance.asset.manage.asset.list");
    }
    
    $scope.$watch('assetMasterData.currencyCode', function(newValue, oldValue) {
        debugger;
        if (newValue != '' && newValue != undefined) {
            // get exchange rate for currency
            $http.get($stateParams.tenantid+'/app/commonUtility/getExchangeRate?currencyCode='+newValue).success(function(data) {
                debugger;
                $scope.assetMasterData.exchangeRate=data;
            }).error(function(data) {
            });
            
        }
    });
    
    $scope.calculateBCAmount= function(tcAmount){
        $scope.assetMasterData.totalBCAmount =  Math.floor(((isNaN(parseFloat(tcAmount, 10))?0:tcAmount) / parseFloat($scope.assetMasterData.exchangeRate))*100)/100;
        
    }

    $scope.calculateEXrate= function(bcAmount){
        $scope.assetMasterData.exchangeRate = ($scope.assetMasterData.totalTCAmount/((isNaN(parseFloat(bcAmount, 10))?0:bcAmount))).toFixed(2);
    }
    
    $scope.submit = function(assetForm,assetMasterData) {
        if (new validationService().checkFormValidity($scope.assetForm)) {
            $scope.save();
        } else {
            toaster.pop('error', "Please fill the required fields", 
                    logger.getErrorHtmlNew($scope.assetForm.$validationSummary), 5000, 'trustedHtml');
        }
    };
    
/*    $scope.save = function(){
        debugger;
        console.log($scope.assetMasterData);
        $http.post('app/assetmaster/saveAssetMaster', $scope.assetMasterData).success(function(result) {
            if (result == false) {
                logger.logError("Unable to add Asset Details");
            } else {
                $state.go("app.finance.asset.asset.list");
                logger.logSuccess("Asset Details added successfully");
            }
        })
    };*/
    
    //update
    
    $scope.resetedit = function(){
    	
    	$scope.getEdit();
    	
    }
    
    
    
    
    $scope.updateBtn = function(assetForm,assetMasterData) {
        if (new validationService().checkFormValidity($scope.assetForm)) {
            $scope.update();
        } else {
            toaster.pop('error', "Please fill the required fields", 
                    logger.getErrorHtmlNew($scope.assetForm.$validationSummary), 5000, 'trustedHtml');
        }
    };
    
    $scope.update = function(){
        debugger;
        console.log($scope.assetMasterData);
        $http.post($stateParams.tenantid+'/app/assetmaster/UpdateAssetMaster', $scope.assetMasterData).success(function(result) {
            if (result == false) {
                logger.logError("Unable to add Asset Details");
            } else {
                $state.go("app.finance.asset.manage.asset.list");
                logger.logSuccess("Asset Details Updated successfully");
            }
        })
    };
    
    
    var assetId = $location.search().assetId;

    
    $scope.getEdit = function(){
    	
    $http.post($stateParams.tenantid+'/app/assetmaster/editAssetMaster', assetId).success(function(result) {
        if (result) {
            $scope.assetMasterData=result;
            $scope.isEdit = true;

            $('#confDate').show();
            $('#leaveDate').show();

        }
    }).error(function(data) {
        console.log("data" + data);
    });
}
    $scope.getEdit();




    
});

