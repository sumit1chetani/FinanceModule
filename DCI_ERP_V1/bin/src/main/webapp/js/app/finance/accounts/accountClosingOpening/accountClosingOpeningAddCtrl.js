///  define([ 'hospital/accounts/accounts' ], function(module) {
       
     ///   'use strict';
        
app.controller('accountClosingOpeningListCtrl', function($scope,$stateParams, $rootScope, $http, $stateParams,
        $location, logger, $log, ngDialog, $modal, utilsService, toaster,$window, $state, sharedProperties,validationService) {
  
    $scope.rowCollection=[];
    $scope.hideEditIcon=true;
    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.isUpload = true;
    $scope.isDelete = true;
    $scope.emptyObject = {};
    
    
    $scope.getList = function() {
        var url = 'hospital/accounts/closingAccounts/list?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount;
        $http.get(url).success(function(data) {
            if (data.success == true) {
               // $scope.rowCollection = $scope.rowCollection.concat(data.List);
                $scope.rowCollection = data.list;

                sharedProperties.setObject($scope.emptyObject);
            }
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
        $scope.offsetCount = $scope.offsetCount + $scope.limitCount;
    };

    $scope.getList();
    
    $scope.editRow = function(closingAccountId) {

        $location.url($stateParams.tenantid+'/hospital/accounts/accountclosingopening/edit?closingAccountId=' + closingAccountId);
    }
   
    
    $scope.deleteRow = function(closingAccountId) {

        ngDialog.openConfirm().then(function() {
            $http.post("hospital/accounts/closingAccounts/delete", closingAccountId).success(function(response) {
                logger.logSuccess("Deleted Successfully!");
                $scope.getList();
            }).error(function(result) {
                logger.logError("Error Please Try Again");
            });
        });
    };

            
    
    $scope.accountingYearClose ={
            fromdate :'',
            todate :'',
            companyId : '',
            closingAccountId : '',
            companyCode :'',
    }
    $scope.add=function(){
        //$location.path("/hospital/accounts/accountclosingopening/add");
        $state.go('app.finance.accounts.accountclosingopening.add');

    }
    

});

 

    
    //add controller
      
   
app.controller('accountClosingOpeningAddCtrl', function($scope,$stateParams, $rootScope, $http, $location, logger, $log, ngDialog, $modal, utilsService, toaster,$window,$state, sharedProperties,validationService, $timeout) {
  
    
    $scope.accountingYearClose ={
            fromdate :'',
            todate :'',
            companyCode :'',
            companyId : 'C0002',
            closingAccountId : '',
            //groupid:'',
            companyId:'C0002',
            isEdit : false

            //groupname:''
            
    }
    $scope.isEdit = false;
    
    

    $scope.companyList =[];
    
    //companylist
    $scope.getDropdownvalue = function() {
        $http.get(  $stateParams.tenantid+'/app/commonUtility/getCompanyListPurchase').success(function(datas) {
            $scope.companyList = datas;
            }).error(function(datas) {
        });
        
    }
    $scope.getDropdownvalue();
    
    
    //save for add page
    $scope.submit = function(accountingyearcloseForm) {
        if (new validationService().checkFormValidity(accountingyearcloseForm)) {
            $http.post("hospital/accounts/closingAccounts/save", $scope.accountingYearClose).success(function(response) {
//                if (response == true) {
                    logger.logSuccess("Saved Successfully!");
                    $state.go('app.finance.accounts.accountclosingopening.list');
//                }
//                else {
//                    logger.logError("Not Saved!");
//                }

            });
        } else {
            toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(manageCostCenterAdd.$validationSummary), 5000, 'trustedHtml');
        }

    }
    
    $scope.update = function(accountingyearcloseForm) {
        if (new validationService().checkFormValidity(accountingyearcloseForm)) {
            $http.post("hospital/accounts/closingAccounts/update", $scope.accountingYearClose).success(function(response) {
               // if (response == true) {
                    logger.logSuccess("Updated Successfully!");
                    $state.go('app.finance.accounts.accountclosingopening.list');
              //  } else {
             //       logger.logError("Not Updated!");
             //   }

            });
        } else {
            toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(parameterAddForm.$validationSummary), 5000, 'trustedHtml');
        }

    }
    
    
    //Edit for add page
    var closingAccountId = $location.search().closingAccountId;

  if (closingAccountId == undefined || closingAccountId == '' || closingAccountId == undefined) {
        $scope.accountingYearClose.isEdit = false;
    } else {
//        $http.post("hospital/accounts/closingAccounts/edit", companyId).success(function(response) {
        $http.post("hospital/accounts/closingAccounts/edit",closingAccountId).success(function(response) {
            if (response.closingaccounts != null) {
                $scope.accountingYearClose.isEdit = true;
                $scope.accountingYearClose =response.closingaccounts; 
            }
        });

    }

    
    $scope.reset = function(){
        $scope.accountingYearClose = angular.copy(temp);
    };
    

    $scope.cancel = function() {
        $state.go('app.finance.accounts.accountclosingopening.list');
    };
    
    
   
    
                                                                        
    
});
//    });
