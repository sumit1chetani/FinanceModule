'use strict';
app.controller('operationBudgetAndProjectionCtrl', function($scope, $window, $rootScope, $location, $http, 
        logger, $log, ngDialog, $modal, utilsService,$state,$stateParams) {
    $scope.dataLoopCount = 0;
    $scope.from = 0;
    $scope.to = 100;
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    
    $scope.getOperationBudgetListUtil = function(limit, offset) {
      var start = new Date().getTime();

        var url = $stateParams.tenantid+'/app/operationbudgetandprojection/budgetlist?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount;
        $http.get(url).success(function(data) {
           
            if (data.success == true) {
                $scope.pushOperationBudgetListUtil(data);
                $scope.dataLoopCount++;
            } else {
                if ($scope.dataLoopCount == 0) {
                    $scope.showEmptyLabel = true;
                }
                logger.logError("Error Please Try Again");
            }
            var end = new Date().getTime();
            var time = end - start;
            console.log('Execution time: ' + time);
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });

    };
    $scope.pushOperationBudgetListUtil = function(data) {
        if (utilsService.isUndefinedOrNull(data.lOperationBudgetandProjectionBean)) {
            console.log("data.lOperationBudgetandProjectionBean::::::::::::::ragsthala::::::::::::::::::::::::::::::::");
            console.log(data.lOperationBudgetandProjectionBean);
            $scope.showEmptyLabel = true;
        } else {
            $scope.rowCollection = $scope.rowCollection.concat(data.lOperationBudgetandProjectionBean);
        }
    };
    $scope.getOperationBudgetListUtil();
    
    $scope.add = function(){
        $state.go('app.finance.reports.analytical.operationbudgetAdd',{tenantid:$stateParams.tenantid});
    }
    
    
});
app.controller('operationBudgetAndProjectionAddCtrl', function($scope,$filter, $rootScope, $http, $location, logger, utilsService, $state, sharedProperties, $window, $modal, ngDialog,$stateParams) {
    
    $scope.vesselList = [];
    $scope.voyageList = [];
    $scope.sectorList = [];
    $scope.accountHeadList = [];
    $scope.operationBudget = {
        vesselCode : '',
        voyageId : '',
        sectorCode : '',
        fromDate : '',
        toDate : '',
        accountHead : '',
        currentYear:'',
        
        cYearRevenue : 0,
        pYearRevenue : 0,
        cYearVolumeExpectation : 0,
        pYearVolumeExpectation : 0,
        cYearUtilization :0,
        pYearUtilization : 0,
        cYearVarianceExpected : 0,
        pYearVarianceExpected : 0,
        cYearPerTeuCost : 0,
        pYearPerTeuCost : 0,
        cYearVoyageTotal : 0,
        pYearVoyageTotal : 0,
        cYearSectorTotal : 0,
        pYearSectorTotal : 0,
        cYearPeriodTotal : 0,
        pYearPeriodTotal : 0
    };
    /**
     * get Current Date and Year
     */
    $scope.getCurrentDate = function(){
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
        $scope.operationBudget.currentYear = yyyy;
        $scope.operationBudget.fromDate=today;
        $scope.operationBudget.toDate=today;
    }
    $scope.getCurrentDate();
    /**
     * onchange *********************************
     */
    $scope.getDropdownValues = function(){
        //Get Vessel dropDown
        $http.get($stateParams.tenantid+'/app/operationbudgetandprojection/vessel').success(function(data) {
            if(data.success == true){             
                $scope.vesselList = data.vesselList;
            }
        });
        //service list
        $http.get($stateParams.tenantid+'/app/commonUtility/getSectorList').success(function(datas) {
            $scope.sectorList = datas;
            }).error(function(datas) {
        });
        
        $http.get($stateParams.tenantid+'/app/commonUtility/getCrDtlAccountHeadData').success(function(datas) {
            $scope.accountHeadList = datas.commonUtilityBean;
        }).error(function(data) {
        });   
    }
    $scope.getDropdownValues();
    
    $scope.$watch('operationBudget.vesselCode', function(newValue, oldValue) {
        if(newValue != undefined && newValue != '' && newValue!=null){
            $scope.getVoyage($scope.operationBudget.vesselCode);
        }
    });    
    //Get Voyage dropDown
    $scope.getVoyage = function(vesselCode) {
        if(vesselCode != undefined && vesselCode != '' && vesselCode!=null){
            $http.post($stateParams.tenantid+'/app/operationbudgetandprojection/voyage', vesselCode).success(function(data) {
                if(data.success == true){
                    $scope.voyageList = data.voyageList;
                }
            });
        }
    };    
    $scope.$watch('operationBudget.voyageId', function(newValue, oldValue) {      
        if(newValue != undefined && newValue != '' && newValue!=null){            
            $scope.getSector(newValue);
        }
    });
    
    $scope.getSector = function(voyageId) {
        if(voyageId != undefined && voyageId != '' && voyageId!=null){
            $http.post($stateParams.tenantid+'/app/operationbudgetandprojection/sector', voyageId).success(function(data) {            
                if(data.success == true){
                    angular.forEach($scope.sectorList, function(key, index){
                       if(key.id==data.operationBudget.sectorCode){                
                           $scope.operationBudget.sectorCode = data.operationBudget.sectorCode;       
                       } 
                    });
                    
                }
            });
        }
    }; 
    
    
    /**
     * Save Functionality
     */
    
    $scope.save = function(operationBudgetForm,operationBudget) {
        $http.post($stateParams.tenantid+'/app/operationbudgetandprojection/save', $scope.operationBudget).success(function(data) {
            if(data.success == true){
                logger.logSuccess("Data saved successfully.")
                $location.path($stateParams.tenantid+'/reports/analytical/operationbudget');
            }
        });
    };
    
    $scope.cancel= function(){
        $location.path($stateParams.tenantid+'/reports/analytical/operationbudget');
    }
   
});

