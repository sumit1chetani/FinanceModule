
    'use strict';

    app.controller('letterreqtypeListCtrl', function( $stateParams ,$scope,$state,$http,ngDialog, logger,$location,$controller,$injector, sharedProperties, toaster,$rootScope,validationService) {
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages=0;
        $scope.isAdd=true;
        
        $scope.getList = function(){
                // $http.get("hrms/master/leaveTypeLimit/list").success(function(response) {
              	 $http.get($stateParams.tenantid+"/finance/letterRequest/list").success(function(response) {

                $scope.rowCollection = response.letterReqList;
            });
        };
        $scope.getList();
        
        $scope.add = function(){
            $scope.callDialog($scope, 0, $http, ngDialog, logger,$injector, sharedProperties, toaster,$rootScope);
        };                                               
        
      //Edit functionality
        $scope.editRow = function(collection) {
            $scope.callDialog($scope, collection.letterReqTypeId, $http, ngDialog, logger,$injector, sharedProperties, toaster,$rootScope);
        };
        
        //Delete functionality
        $scope.deleteRow = function(collection) {
          ngDialog.openConfirm().then(function() {
               //  $http.post("hrms/master/leaveTypeLimit/delete",collection.feeId)
                  $http.post($stateParams.tenantid+"/finance/letterRequest/delete",collection)

                .success(function(response) {
                   if(response == true){
                       logger.logSuccess("Deleted Succesfully!");
                       $scope.getList();
                   }else
                       logger.logError("You can't delete this record,Deletion Failed");
                }).error(function(result) {
                    logger.logError("Error Please Try Again");
                });
            });
        };
        
        $scope.callDialog = function($scope, letterReqTypeId, $http, ngDialog, logger,$injector, sharedProperties, toaster,$rootScope){
            ngDialog.open({
                scope: $scope,
                template: 'views/finance/letterreqtype/letterreqtypeAdd',
                controller: $controller('letterReqTypeAddAddCtrl', {
                    $scope: $scope,
                    letterReqTypeId: letterReqTypeId,
                    $http:$http,
                    ngDialog:ngDialog,
                    logger:logger,
                    $injector:$injector, 
                    sharedProperties:sharedProperties, 
                    toaster:toaster,
                    $rootScope:$rootScope
                }),
                className: 'ngdialog-theme-plain',
                showClose: false,
                closeByDocument: false,
                closeByEscape: false,
                preCloseCallback : $scope.getList
            });
        };
    });
    
    

    app.controller('letterReqTypeAddAddCtrl', function( $stateParams ,$scope, $http, ngDialog,logger,letterReqTypeId,$injector, sharedProperties, toaster,$rootScope,validationService) {
        $scope.letterreqType = {
        		letterReqTypeId : '', 
        		letterReqTypeName : '',
        		descripiton : '',
        		companyCode : ''
        };    
        $scope.isEdit = false;
        
        //Save functionality
        $scope.save = function(letterReqTypeAddForm) {
            if (new validationService().checkFormValidity(letterReqTypeAddForm)) {
                  	 $http.post($stateParams.tenantid+"/finance/letterRequest/save",$scope.letterreqType).success(function(response) {

                    if (response == true) {
                        logger.logSuccess("Saved Succesfully!");
                        ngDialog.close();
                        $state.go("app.hr.letterreqtype.list");
                    } else {
                        logger.logError("Error in Save !");
                    }
                });
            }else {
                toaster.pop('error', "Please fill the required fields", 
                        logger.getErrorHtmlNew(letterreqTypeForm.$validationSummary), 555000, 'trustedHtml');
            }
        };
        
        $scope.update = function(letterReqTypeAddForm) {
            if (new validationService().checkFormValidity(letterReqTypeAddForm)) {
                  	 $http.post($stateParams.tenantid+"/finance/letterRequest/update",$scope.letterreqType).success(function(response) {

                    if (response == true) {
                        logger.logSuccess("Saved Succesfully!");
                        ngDialog.close();
                        $state.go("app.hr.letterreqtype.list");
                    } else {
                        logger.logError("Error in Save !");
                    }
                });
            }else {
                toaster.pop('error', "Please fill the required fields", 
                        logger.getErrorHtmlNew(letterreqTypeForm.$validationSummary), 555000, 'trustedHtml');
            }
        };
        
        if(letterReqTypeId != 0){
            $scope.isEdit = true;
      	 $http.get($stateParams.tenantid+"/finance/letterRequest/edit?letterReqId=" +letterReqTypeId).success(function(response) {
      		 $scope.letterreqType = response;
      	 });
        }
        $scope.cancel = function() {
            ngDialog.close();
        };
    });

    
    
    