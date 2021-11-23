'use strict';
app.controller('CharterHireStatementCtrl', function($templateCache, $scope, $rootScope, $http, logger, $log, 
        ngDialog, $modal, $location, $sce, $filter, $stateParams, $state) {

    $('#chs_fromDate').datetimepicker({
        format : 'DD/MM/YYYY'
    });
    
    $('#chs_toDate').datetimepicker({
        format : 'DD/MM/YYYY'
    });

    $scope.charterHireStmt = {
            charterHireNo:'', chFromDate:'', chToDate:'', vesselCode:'', vesselName:'',
            currencyCode:'', exchangeRate:'', totalCharges:'', 
                
            commissionPercent:2.5, totalChargesWithCommission:0,
            charExpenseComn:300,charExpenRep:250,charLashingExpen:600,charterExpenseCharges:'',             
            ownersExpAcct1:687.59,ownersExpAcct2:870.36,ownersExpAcct3:851.90,
            ownersExpenceCharges: 0, deliveryBunkerFO: 169.2, deliveryBunkerRate:395,
            deliveryBunkerCharges:0, redeliveryFO:250,redeliveryRate:420,
            redeliveryBunkerCharges:0, nettDueToOwnerCharges:'',noOfDays:0
    };

    $scope.formreset = function() {
        $scope.charterHireStmt = {};
    };

    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.subGroupList = [];
    $scope.companyList = [];
    $scope.vesselList = [];
    
    $scope.getDropDownList = function() {
        $http.get('app/commonUtility/getVesselList').success(function(datas) {
            $scope.vesselList = datas;
            }).error(function(datas) {
        });
        
        $http.get('app/trialBalance/getCompanyList').success(function(data) {
            $scope.companyList = data;
        }).error(function(data) {
        });
    };
    
    $scope.getDropDownList();
    
    /**
     * View CH Statement Report with vesselCode
     */
    $scope.viewReport = function(charterHireStmtForm,charterHireStmt){
        var chFromDate = $("#txtFromDate").val();
        var chToDate = $("#txtToDate").val();
        var vesselCode = $scope.charterHireStmt.vesselCode;
        if(chFromDate!="" && chToDate!="" && vesselCode!=""){
            if(chFromDate!="" && chToDate!=""){
                $state.go('app.finance.reports.charterhirestatement.view',
                        ({ 'vesselCode': $scope.charterHireStmt.vesselCode,'chFromDate':chFromDate,'chToDate':chToDate}));    
            }else{
                logger.logError("Please Select Date Range...!")    
            }
        }
        else{
            logger.logError("Please Select Date Range and Vessel...!")
        }
    }
   
    $scope.viewSOAReport = function(charterHireStmtForm,charterHireStmt){
        var chFromDate = $("#txtFromDate").val();
        var chToDate = $("#txtToDate").val();
        var vesselCode = $scope.charterHireStmt.vesselCode;
        
        if(chFromDate!="" && chToDate!="" && vesselCode!=""){
            if(chFromDate!="" && chToDate!=""){
                $state.go('app.finance.reports.charterhirestatement.viewsoa',
                        ({ 'vesselCode': $scope.charterHireStmt.vesselCode,'chFromDate':chFromDate,'chToDate':chToDate}));    
            }else{
                logger.logError("Please Select Date Range...!")    
            }
        }
        else{
            logger.logError("Please Select Date Range and Vessel...!")
        }
    }
    
   
    
    
    
    
});


app.controller('CharterHireStatementViewCtrl', function($templateCache, $scope, $rootScope, $http, logger, $log, 
        ngDialog, $modal, $location, $sce, $filter, $stateParams, $state, $timeout) {
    

    
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    
  
    
    $scope.charterHireStmtData={
            charterHireNo:'', charterDate:'', chFromDate:'', chToDate:'', vesselCode:'', vesselName:'',
            currencyCode:'', exchangeRate:0, totalCharges:0, 
            
            commissionPercent:2.5, totalChargesWithCommission:0,
            charExpenseComn:300,charExpenRep:250,charLashingExpen:600,charterExpenseCharges:0,             
            ownersExpAcct1:687.59,ownersExpAcct2:870.36,ownersExpAcct3:851.90,
            ownersExpenceCharges: 0, deliveryBunkerFO: 169.2, deliveryBunkerRate:395,
            deliveryBunkerCharges:0, redeliveryFO:250,redeliveryRate:420,
            redeliveryBunkerCharges:0, nettDueToOwnerCharges:0, noOfDays:0, rowData:[]
    }
 
    $scope.getCurrentDate = function(){
        var today = new Date();
        var dd = today.getDate();
        var mm = today.getMonth() + 1;

        var yyyy = today.getFullYear();
        if (dd < 10) { dd = '0' + dd }
        if (mm < 10) { mm = '0' + mm }
        var today = dd + '/' + mm + '/' + yyyy;        
        $scope.charterHireStmtData.charterDate = today;

    }
    $scope.getCurrentDate();
    $scope.charterHireStmtData.chFromDate = $stateParams.chFromDate;
    $scope.charterHireStmtData.chToDate = $stateParams.chToDate;
    $scope.charterHireStmtData.vesselCode = $stateParams.vesselCode;
    console.log("$scope.charterHireStmt::::::::::$stateParams:::::::::::");
    console.log($scope.charterHireStmtData);
    
    $scope.getDropDownList = function() {
        $http.get('app/commonUtility/getVesselList').success(function(datas) {
            $scope.vesselList = datas;
            }).error(function(datas) {
        });
        
        $http.get('app/trialBalance/getCompanyList').success(function(data) {
            $scope.companyList = data;
        }).error(function(data) {
        });       
    };
    
    $scope.getDropDownList();
    
    $scope.getCHStmtReportList = function(){
        if($scope.charterHireStmtData.chFromDate!="" && $scope.charterHireStmtData.chToDate!=""){
            $http.post('app/charterhirestatement/getCharterHireReport',$scope.charterHireStmtData).success(function(data) {
                
                if(data.lCharterHireStatementBean.length>0){
                    $scope.rowCollection = data.lCharterHireStatementBean;    
                    $scope.charterHireStmtData.rowData = data.lCharterHireStatementBean;
                    $scope.charterHireStmtData.charterHireNo = $scope.rowCollection[0].charterHireNo;
                    $scope.charterHireStmtData.vesselName = $scope.rowCollection[0].vesselName;
                    $scope.charterHireStmtData.commissionPercent = 2.5;
                    var totalChargesInUSD = 0.0
                    angular.forEach($scope.rowCollection, function(key,index){
                        totalChargesInUSD += parseFloat(key.totalCharges);                       
                    });
                    $scope.charterHireStmtData.totalChargesWithCommission +=  ($scope.charterHireStmtData.commissionPercent/100) * totalChargesInUSD;
                    
                    $scope.charterHireStmtData.charterExpenseCharges = $scope.charterHireStmtData.charExpenseComn + $scope.charterHireStmtData.charExpenRep + $scope.charterHireStmtData.charLashingExpen;
                    
                    $scope.charterHireStmtData.ownersExpenceCharges = $scope.charterHireStmtData.ownersExpAcct1 + $scope.charterHireStmtData.ownersExpAcct2 + $scope.charterHireStmtData.ownersExpAcct3;
                    
                    $scope.charterHireStmtData.deliveryBunkerCharges = $scope.charterHireStmtData.deliveryBunkerFO * $scope.charterHireStmtData.deliveryBunkerRate;
                    
                    $scope.charterHireStmtData.redeliveryBunkerCharges = ($scope.charterHireStmtData.redeliveryFO * $scope.charterHireStmtData.redeliveryRate)/2;
                    
                    $scope.charterHireStmtData.nettDueToOwnerCharges = totalChargesInUSD - $scope.charterHireStmtData.totalChargesWithCommission
                                                + $scope.charterHireStmtData.charterExpenseCharges - $scope.charterHireStmtData.ownersExpenceCharges
                                                + $scope.charterHireStmtData.deliveryBunkerCharges - $scope.charterHireStmtData.redeliveryBunkerCharges;
                    
                    $scope.charterHireStmtData.nettDueToOwnerCharges = parseFloat($scope.charterHireStmtData.nettDueToOwnerCharges).toFixed(2);
                                                
                }                        
            }).error(function(data) {
            });    
        }else{
            logger.logError("Unable to load the record for selected date range...!");
        }        
    }
    $scope.getCHStmtReportList();
    /**
     * print Report
     */
    $scope.printCharterHireReport = function(charterHireStmtData){
        console.log($scope.charterHireStmtData);
        $http.post('app/charterhirestatement/print',$scope.charterHireStmtData).success(function(response) {
                var mywindow = window.open('', 'Shipping', 'height=400,width=750,top=100,left=100,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
                mywindow.document.write(response);
                mywindow.document.close(); // necessary for IE >= 10
                mywindow.focus(); // necessary for IE >= 10
                mywindow.print();
                
        }).error(function(data) {
        });
        
        
        
    }

    /**
     * print SOA Report
     */

    $scope.printCharterHireSOA = function(charterHireStmtData){
        console.log($scope.charterHireStmtData);
        $http.post('app/charterhirestatement/printsoa',$scope.charterHireStmtData).success(function(response) {
                var mywindow = window.open('', 'Shipping', 'height=400,width=750,top=100,left=100,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
                mywindow.document.write(response);
                mywindow.document.close(); // necessary for IE >= 10
                mywindow.focus(); // necessary for IE >= 10
                mywindow.print();
                
        }).error(function(data) {
        });
       /* var url = 'app/charterhirestatement/printsoa';
        var wnd = window.open(url, 'Shipping', 'height=400,width=750,top=100,left=100,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
        wnd.print();*/
    }
    /**
     * cancel functionality
     */
    $scope.cancel = function(){
        $state.go("app.finance.reports.charterhirestatement.list");
    }
});