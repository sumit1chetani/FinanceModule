'use strict';
app.controller('adminBudgetAndProjectionCtrl', function($scope, $window, $rootScope, $location, $http, 
        logger, $log, ngDialog, $modal, utilsService,$state,$stateParams) {
    $scope.dataLoopCount = 0;
    $scope.from = 0;
    $scope.to = 100;
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    
    $scope.getAdminBudgetListUtil = function(limit, offset) {
      var start = new Date().getTime();

        var url = $stateParams.tenantid+'/app/adminbudgetprojection/budgetlist?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount;
        $http.get(url).success(function(data) {
           
            if (data.success == true) {
                $scope.pushAdminBudgetListUtil(data);
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
    $scope.pushAdminBudgetListUtil = function(data) {
        if (utilsService.isUndefinedOrNull(data.lAdminBudgetAndProjectionBean)) {
            console.log("data.lAdminBudgetAndProjectionBean::::::::::::::ragsthala::::::::::::::::::::::::::::::::");
            console.log(data.lAdminBudgetAndProjectionBean);
            $scope.showEmptyLabel = true;
        } else {
            $scope.rowCollection = $scope.rowCollection.concat(data.lAdminBudgetAndProjectionBean);
        }
    };
    $scope.getAdminBudgetListUtil();
    
    $scope.add = function(){
        $state.go('app.mis.analytical.adminbudget.add',{tenantid:$stateParams.tenantid});

       // $state.go('app.mis.analytical.adminbudget.add',{tenantid:$stateParams.tenantid});
    }
    
    
});

app.controller('adminBudgetAndProjectionAddCtrl', function($scope, $filter, $rootScope, $http, $location, 
        logger, utilsService, $state, sharedProperties, $window, $modal, ngDialog) {

    $scope.costCentreList = [];
    $scope.accountHeadList = [];
    
    $scope.adminBudget = {
        budgetNo:'',fromDate : '', toDate : '', costCentre : '', accountHead : '', currentYear:'',
        
        currentVolume:'', emptyTues:'', ladenTues:'', totalTues:'',
        
        currentvariance:'', previousVariance:'',  currentPerTeuCost:'', previousPerTeuCost:'',
        
        currentTotalAccount:'', previousTotalAccount:'',  currentTotalCostCentre:'', previousTotalCostCentre:'',
            
        currentTotalPeriod:'', previousTotalPeriod:'', increaseDecrease:''            
    }
    
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
        $scope.adminBudget.currentYear = yyyy;
        $scope.adminBudget.fromDate=today;
        $scope.adminBudget.toDate=today;
    }
    $scope.getCurrentDate();
    /**
     * dropdown datas
     */
    
    $scope.getDropdownValue = function(){
        $http.get($stateParams.tenantid+'/app/commonUtility/getCrDtlAccountHeadData').success(function(datas) {
            $scope.accountHeadList = datas.commonUtilityBean;
        }).error(function(data) {
        });    
        
        $http.get($stateParams.tenantid+'/app/commonUtility/getCostCentreData').success(function(datas) {
            $scope.costCentreList = datas.commonUtilityBean;
        }).error(function(data) {
        });    
    }
    $scope.getDropdownValue();

    /**
     * Get Prev Year Loading Container Tues
     */
    $scope.getPrevYearLoadingContainerTues = function(){
        $http.get($stateParams.tenantid+'/app/adminbudgetprojection/getPrevYearLoadingContainerTues').success(function(datas) {
            $scope.adminBudget.emptyTues = datas.adminBudgetProjectionBean.emptyTues;
            $scope.adminBudget.ladenTues = datas.adminBudgetProjectionBean.ladenTues;
            $scope.adminBudget.totalTues = datas.adminBudgetProjectionBean.totalTues;
        }).error(function(data) {
        }); 
    }
    $scope.getPrevYearLoadingContainerTues();
    
    /**
     * Calculate Current Volume Expected from Current Variance
     */
    $scope.calculateCurrentVolume = function(currentvariance){
        var prevVolume= $scope.adminBudget.totalTues
        
        if($scope.adminBudget.accountHead!=""){            
            $scope.adminBudget.currentVolume= (parseFloat(prevVolume*currentvariance)/100);
        }
        else{
            logger.logError("Please Select Account Head");
        }
    }
    /**
     * get Prev Balance for Selected Account Head
     */
    $scope.$watch("adminBudget.accountHead", function(newValue, oldValue){
        if(newValue!=undefined && newValue!="" && newValue!=null){            
            $http.get($stateParams.tenantid+'/app/adminbudgetprojection/getAccountHeadPreviousBalance?accountHead='+newValue).success(function(datas) {
                $scope.adminBudget.previousTotalAccount = datas.lAdminBudgetAndProjectionBean[0].accountPrevBalance;
                var totalBalance = datas.lAdminBudgetAndProjectionBean[0].accountPrevBalance;
                var pertuecost = totalBalance / $scope.adminBudget.totalTues;
                 
                $scope.adminBudget.previousPerTeuCost = parseFloat(pertuecost).toFixed(3);
            }).error(function(data) {
            }); 
        }else{
            
        }
    });
    
    /**
     * calculate current perTeuCost with increase/decrease
     */
    $scope.calculateCurrentCurrentPerTueCost = function(increaseDecrease){
        var prevTotalAcc=$scope.adminBudget.previousTotalAccount;
        //var prevCostTotal=$scope.adminBudget.previousTotalCostCentre;  
        var curVolume= $scope.adminBudget.currentVolume;
        $scope.adminBudget.currentTotalAccount=parseFloat(prevTotalAcc*increaseDecrease);
        //$scope.adminBudget.currentTotalCostCentre=parseFloat(prevCostTotal*increaseDecrease);
        var curTotAcct =$scope.adminBudget.currentTotalAccount;        
        $scope.adminBudget.currentPerTeuCost=parseFloat(curTotAcct/curVolume).toFixed(2);
    }
    
    /**
     * generate Admin budget - save
     */
    
    $scope.generateAdminBudgetProjection = function(adminBudgetForm,adminBudget){
        $http.post($stateParams.tenantid+'/app/adminbudgetprojection/generateAdminBudget', $scope.adminBudget).success(function(result) {
            if(result) {
                logger.logSuccess("Budget Created Successfully!");
                $location.path('/reports/analytical/adminbudget');
            } else {
                logger.logError("Unable to Create Budget, Please Try Again...!");
            }
        }).error(function(result) {
            console.log("data" + result);
        });
    }
    
    
    $scope.cancel = function(){
        $location.path($stateParams.tenantid+'/reports/analytical/adminbudget');
    }
});
