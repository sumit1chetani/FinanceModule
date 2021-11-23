//define([ 'hospital/accounts/accounts' ], function(module) {

  // 'use strict';

    app.controller('budgetDefinitionAddCtrl', function($scope, $state, $stateParams,$http, $location, sharedProperties, toaster, $injector, logger, $stateParams, $compile, $timeout, $parse, validationService) {
        
        $scope.companyList = [];
        $scope.finYearList = [];
        $scope.budgetTypeList = [];
        $scope.budgetData = {
                company: 'C0002',
                budgetType: '',
                financial_year: '',
                capexno: '',
                projectName: '',
                flag : '',
                amount:0
        }
//        $scope.capex = false;
//        $scope.revex = false;
        
        $scope.edit = false;
        $scope.getDropdownValue = function() {
            var expenseObj = [], stausObj = [];
            $http.get('app/budget/getDropDownList').success(function(datas) {
                $scope.companyList = datas.companyList;
                // $scope.finYearList = datas.finYearList;
            }).error(function(datas) {
            });
            
            $http.get('app/budgetDefinition/getBudgetType').success(function(datas) {
                $scope.budgetTypeList = datas.budgetTypeList;
                // $scope.finYearList = datas.finYearList;
            }).error(function(datas) {
            });
        }
        $scope.getDropdownValue();
        
        //get financial Year based on company
        
        $scope.$watch('budgetData.company', function(newValue, oldValue) {
            if (newValue != '' && newValue != undefined) {
                $http.get('app/budget/getFinYear?company=' + newValue).success(function(datas) {
                    if (datas.finYearList.length > 0) {
                        $scope.finYearList = datas.finYearList;
                    } else {
                        $scope.finYearList = [];
                        $scope.budgetData.financial_year = "";
                    }
                }).error(function(data) {
                });
                
                $http.get('app/purchaseOrder/costcenterList?companyId=' + newValue).success(function(datas) {
                    $scope.costList = datas;
                });
            } else {
                $scope.finYearList = [];
                $scope.budgetData.financial_year = "";
            }
        });
        
        //save
        
        $scope.save = function() {
            if($scope.budgetData.amount !=0 && $scope.budgetData.amount != null && $scope.budgetData.amouny != ""
                && $scope.budgetData.amount != undefined){
            if ($scope.edit == false) {
                if($scope.revex == true && $scope.capex == false)
                    {
                    $scope.budgetData.flag = 'R';
                    }else if ($scope.capex == true && $scope.revex == false){
                        $scope.budgetData.flag = 'C';

                    }
                $http.post('app/budgetDefinition/saveBudgetDefinitionList', $scope.budgetData).success(function(result) {
                    if (result) {
                        logger.logSuccess("Saved Successfully!");
                        $location.path($stateParams.tenantid+'/hospital/accounts/budgetDefinitions/list');
                    } else {
                        logger.logError("Error in Save!");
                    }
                }).error(function(result) {
                });
            }
        }else{
            logger.logError("Amount Should Be Higher Then 0 ! ");
        }
        }
       
        
        //cancel 
        
        $scope.cancel = function(){
            $state.go('app.finance.accounts.budgetDefinitions.list');
        }
        
        
        // change capex and revex
//        $scope.capex = false;
//        $scope.revex = false;
        $scope.capexNo = true;
        $scope.capex1 = function(value){

          $scope.revex = false;
            if(value == true)
            $scope.capexNo = true;
            else
                $scope.capexNo = false;

//            $scope.revex = false;

        }
        $scope.revex1 = function(value){
            $scope.capex = false;
//          $scope.revex = false;
         
            if(value == true)
            $scope.capexNo = false;
            else
                $scope.capexNo = true;
            //            $scope.revex = true;        
            }
    });

    app.controller('budgetDefinitionEditCtrl', function($scope, $state, $http, $location, sharedProperties, toaster, $injector, logger, $stateParams, $compile, $timeout, $parse, validationService) {
        
        $scope.companyList = [];
        $scope.finYearList = [];
        $scope.budgetTypeList = [];
        $scope.budgetData = {
                company: '',
                budgetType: '',
                financial_year: '',
                capexno: '',
                projectName: '',
                flag : ''
        }
        
        $scope.edit = true;
        $scope.getDropdownValue = function() {
            var expenseObj = [], stausObj = [];
            $http.get('app/budget/getDropDownList').success(function(datas) {
                $scope.companyList = datas.companyList;
                // $scope.finYearList = datas.finYearList;
            }).error(function(datas) {
            });
            
            $http.get('app/budgetDefinition/getBudgetType').success(function(datas) {
                $scope.budgetTypeList = datas.budgetTypeList;
                // $scope.finYearList = datas.finYearList;
            }).error(function(datas) {
            });
        }
        $scope.getDropdownValue();
        
        $scope.$watch('budgetData.company', function(newValue, oldValue) {
            if (newValue != '' && newValue != undefined) {
                $http.get('app/budget/getFinYear?company=' + newValue).success(function(datas) {
                    if (datas.finYearList.length > 0) {
                        $scope.finYearList = datas.finYearList;
                    } else {
                        $scope.finYearList = [];
                        $scope.budgetData.financial_year = "";
                    }
                }).error(function(data) {
                });

                $http.get('app/purchaseOrder/costcenterList?companyId=' + newValue).success(function(datas) {
                    $scope.costList = datas;
                });
            } else {
                $scope.finYearList = [];
                $scope.budgetData.financial_year = "";
            }
        });
        
        $scope.editbudgetDefinition = function(){
            
            var budgetDefinitionId = $stateParams.budgetDefinitionId;
            $http.get('app/budgetDefinition/editBudgetDefinitionList?budgetDefinitionId=' + budgetDefinitionId).success(function(datas) {
             if(datas.success == true)
             {
                 
                     if(datas.flag == 'C'){
                     
                     $scope.capex = true;
                     $scope.revex = false;

                         $scope.capexNo = true;
                     }
                     else    if(datas.flag == 'R'){
                         $scope.capex = false;
                         $scope.revex = true;

                               $scope.capexNo = false;


                       }
                 $scope.budgetData = datas;
                 $scope.budgetData.budgetType = datas.budgetType.toString();
             }
             else
                 log.loggerError("Error in Edit!!");
            });
            
            
        }
        
        $scope.editbudgetDefinition();
        
        //update
        $scope.update = function() {

            if($scope.budgetData.amount !=0 && $scope.budgetData.amount != null && $scope.budgetData.amouny != ""
                && $scope.budgetData.amount != undefined){
            if ($scope.edit == true) {
                $scope.budgetData.budgetDefinitionId = $stateParams.budgetDefinitionId;

                    if($scope.revex == true && $scope.capex == false)
                        {
                        $scope.budgetData.flag = 'R';
                        }else if ($scope.capex == true && $scope.revex == false){
                            $scope.budgetData.flag = 'C';

                        }
                $http.post('app/budgetDefinition/updateBudgetDefinitionList', $scope.budgetData).success(function(result) {
                    if (result.success) {
                        logger.logSuccess("Updated Successfully!");
                        $location.path($stateParams.tenantid +'/hospital/accounts/budgetDefinitions/list');
                    } else {
                        logger.logError("Error in Update!");
                    }
                }).error(function(result) {
                });
            }
            }else{
                logger.logError("Amount Should Be Higher Then 0 ! ");
            }
        }
        
     //cancel 
        
        $scope.cancel = function(){
            $state.go('app.finance.accounts.budgetDefinitions.list');
        }

        $scope.cancel1 = function(){
//            alert(8);
            $state.go('app.finance.accounts.budgetDefinitionsApprove.list');
        }
        
        $scope.capexNo = true;
        $scope.capex1 = function(value){

          $scope.revex = false;
            if(value == true)
            $scope.capexNo = true;
            else
                $scope.capexNo = false;

//            $scope.revex = false;

        }
        $scope.revex1 = function(value){
            $scope.capex = false;
//          $scope.revex = false;
         
            if(value == true)
            $scope.capexNo = false;
            else
                $scope.capexNo = true;
            //            $scope.revex = true;        
            }
        
        $scope.approve = function(){
            if($scope.budgetData.amount !=0 && $scope.budgetData.amount != null && $scope.budgetData.amouny != ""
                && $scope.budgetData.amount != undefined){
            if ($scope.edit == true) {
                $scope.budgetData.budgetDefinitionId = $stateParams.budgetDefinitionId;

                    if($scope.revex == true && $scope.capex == false)
                        {
                        $scope.budgetData.flag = 'R';
                        }else if ($scope.capex == true && $scope.revex == false){
                            $scope.budgetData.flag = 'C';

                        }
                $http.post('app/budgetDefinition/approveBudgetDefinitionList', $scope.budgetData).success(function(result) {
                    if (result.success) {
                        logger.logSuccess("Updated Successfully!");
                        $location.path($stateParams.tenantid +'/hospital/accounts/budgetDefinitionsApprove/list');
                    } else {
                        logger.logError("Error in Update!");
                    }
                }).error(function(result) {
                });
            }
        }else{
            logger.logError("Amount Should Be Higher Then 0 ! ");
        }
        }
        
        
   // });

});