
    'use strict';

   	app.controller('loantypeCtrl', function($stateParams,$scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService,utilsService, $window,$timeout) {
    //  module.registerController('loantypeCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.isDisplay = false;
        $scope.numPages = 0
        $scope.isDelete=true;
        $scope.isUpload=true;
      /*  console.log("moudleeee");
        console.log(module);*/
        $scope.add = function() {

            $scope.callDialog($scope, 0, $http, ngDialog,$stateParams,  $injector, sharedProperties, toaster, $rootScope);
        };

        $scope.callDialog = function($scope, loanTypeId, $stateParams,   $injector, sharedProperties, toaster, $rootScope) {
            ngDialog.open({
                scope : $scope,
                template : 'views/payroll/loantype/loanTypeAdd',
                controller : $controller('loanTypeAddCtrl', {
                    $scope : $scope,
                    loanTypeId : loanTypeId,
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
        $scope.getList = function() {
            $http.get('payroll/payroll/loantype/list').success(function(response) {
                console.log("response.loanTypeList:::::::::::::::::::::");
                console.log(response.loanTypeList);
                $scope.rowCollection = response.loanTypeList;
            });
        };
        $scope.getList();
        
        $scope.getInterestRate=function(){
            console.log("Coming Inside getInterestRate");
            if($scope.loanMaster.isEdit!=true){
            if($scope.loanMaster.flatOrDiminishing=='2'){
                console.log("Coming Inside Diminishing");
                $scope.loanMaster.interestRate=1;    
            }else{
                $scope.loanMaster.interestRate=0;   
            }
            }
        }
        
        
        $scope.editRow = function(loanTypeId) {

            $scope.callDialog($scope,loanTypeId, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope);
        };
        $scope.deleteRow = function(loanTypeId) {
            console.log("Loan Type ID:"+loanTypeId);
            ngDialog.openConfirm().then(function() {
                $http.post("payroll/payroll/loantype/delete", loanTypeId).success(function(response) {
                    console.log("Coming Inside Delete Function");
                    console.log(response);
                    if(response.success==false){
                        logger.logError(loanTypeId+" Loan Type is Used in Employee Pay Component So it Cannot be Deleted");
                    }else{
                        logger.logSuccess("Deleted Successfully");
                        $scope.getList();
                    }
                }).error(function(response) {
                    logger.logError("Error Please Try Again");
                });
            });

        };
    });
   //	app.controller('loanTypeAddCtrl', function($stateParams,$scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService,utilsService, ) {

   		app.controller('loanTypeAddCtrl', function($scope, $http, ngDialog, logger, loanTypeId, $injector, sharedProperties, toaster, $rootScope,validationService,$stateParams,$state,$window,$timeout) {
        $scope.loanMaster = {
            loanTypeId : '',
            loanTypeName : '',
            interestRate :0,
            flatId :'',
            flatName : '',
            status : false
        };
       
        $scope.flatOrDiminishing = [ {
            id : 1,
            text : 'Flat'
        }, {
            id : 2,
            text : 'Diminishing'
        },]
     

       
        
        $scope.loanMaster.isEdit = false;
        $scope.cancel = function() {
            ngDialog.close();
        };

        if (loanTypeId != 0 && loanTypeId != undefined && loanTypeId != null) {
            console.log("Coming Inside Edit Form");
            console.log("Loan Type ID:"+loanTypeId);
            $http.post("payroll/payroll/loantype/loantypelistbyid", loanTypeId).success(function(response) {
                console.log("Edit Values:");
                console.log(response);
                console.log("Edit Values:loanTypeListById");
                console.log(response.loanTypeListById[0].flatId);
                if (response.loanTypeListById.length>0) {
                    $scope.loanMaster = response.loanTypeListById[0];
                    $scope.loanMaster.isEdit = true;
                }
            });
        }

       // var $validationProvider = $injector.get('$validation');
        $scope.save = function(loantypeMasterForm) {
            if (new validationService().checkFormValidity(loantypeMasterForm)) {
            var saveData = $scope.loanMaster;
            console.log("Inside Save Function");
            console.log(saveData);
          //  $validationProvider.validate(loantypeMasterForm).success(function() {
            var resultBean={
                    loanTypeId:$scope.loanMaster.loanTypeId,
                    loanTypeName:$scope.loanMaster.loanTypeName,
                    //flatOrDiminishing:$scope.loanMaster.flatOrDiminishing,
                    flatId:$scope.loanMaster.flatId,
                    interestRate:$scope.loanMaster.interestRate,
                    status:$scope.loanMaster.status
                    };
                var isValid=false;
                if($scope.loanMaster.interestRate  >=0){
                    isValid=true
                }
                if(isValid){
                    $http.post("payroll/payroll/loantype/save", resultBean).success(function(response){
                                if (response == true) {
                                    logger.logSuccess("Saved Successfully!");
                                    ngDialog.close();
                                } else {
                                    logger.logError("Sorry Loan Type Already Exists!");
                                }
                            });
                }else{
                    logger.logError("Interset Rate should be greater than or equval to zero");
                }
              
            }else {
                toaster.pop('error', "Please fill the required fields",
                        logger.getErrorHtmlNew(loantypeMasterForm.$validationSummary),5000, 'trustedHtml');
            }
         
        };
        
        $scope.update = function(loantypeMasterForm) {
        
            console.log("Inside Update Function");
            console.log($scope.loanMaster);
            var isValid=false;
            var resultBean={
                    loanTypeId:$scope.loanMaster.loanTypeId,
                    loanTypeName:$scope.loanMaster.loanTypeName,
                    flatOrDiminishing:$scope.loanMaster.flatId,
                    interestRate:$scope.loanMaster.interestRate,
                    status:$scope.loanMaster.status
                    };
            if($scope.loanMaster.interestRate  >=0){
                isValid=true
            }
            if(isValid){
               $http.post("payroll/payroll/loantype/update",resultBean).success(function(response) {
                    if (response == true) {
                        logger.logSuccess("Updated Successfully!");
                        ngDialog.close();
                    } else {
                        logger.logError("Sorry Some Error Occurred! Please Try again later");
                    }
                });
            }else{
                logger.logError("Interset Rate should be greater than or equval to zero");
            }   
               
        };
        $scope.deleteSelected = function() {
        }

        $scope.reset = function(loantypeMasterForm) {
            console.log("Inside Reset");
            console.log($scope.loanMaster.isEdit);
            if ( $scope.loanMaster.isEdit ==false) {
                console.log("Inside If");
                var loanTypeId = $scope.loanMaster.loanTypeId;
                $scope.loanMaster.loanTypeId = '';
                $scope.loanMaster.loanTypeName = '';
                $scope.loanMaster.flatOrDiminishing = '';
                $scope.loanMaster.interestRate = 0;
                $scope.loanMaster.status = false;
                       } else {
                           console.log("Inside Else");
                           var loanTypeId = $scope.loanMaster.loanTypeId;
               
                $http.post("payroll/payroll/loantype/loantypelistbyid", loanTypeId).success(function(response) {
                    
                    console.log("Edit Values:");
                    console.log(response);
                    console.log("Edit Values:loanTypeListById");
                    console.log(response.loanTypeListById);
                    if (response.loanTypeListById.length>0) {
                        $scope.loanMaster = response.loanTypeListById[0];
                        $scope.loanMaster.loanTypeName = '';
                        $scope.loanMaster.flatOrDiminishing = '';
                        $scope.loanMaster.interestRate = 0;
                        $scope.loanMaster.status = false;
                        $scope.loanMaster.isEdit = true;
                    }
                });

            }

        };

    });

