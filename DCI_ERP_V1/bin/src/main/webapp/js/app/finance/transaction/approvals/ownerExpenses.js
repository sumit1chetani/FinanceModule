'use strict';
app.controller('ownerExpensesListCtrl', function($scope, $filter,$rootScope, $http, $location, logger, $log, ngDialog, $modal, utilsService, sharedProperties, $state,$stateParams) {
    $scope.currentURL=$location.protocol() + '://'+ $location.host() +':'+  $location.port()+"/#" +$location.path();
    if(window.localStorage.getItem('ownerexp_list')==$scope.currentURL){
         alert('window ' + $scope.currentURL + ' is already opened');
         window.focus();
         //window.open($rootScope.currentURL,'_self').close();
         window.close();
     }else{
         window.localStorage.setItem('ownerexp', $scope.currentURL);
         window.localStorage.removeItem('ownerexp');
     }
//    $(window).unload(function(){
//        //debugger;
//       //alert("INSIDE UNLOAD")
//         localStorage.removeItem('ownerexp');
//       });
    $scope.getListDetail=function(){
        $http.get($stateParams.tenantid+'/app/ownerExpense/getDAlist').success(function(datas){
            console.log(datas);
            $scope.rowCollection = datas.lDAAccountList;
            console.log($scope.rowCollection);
         });
    }

    $scope.getListDetail();
    $scope.showExcel=true;
    
    $scope.add = function() {
        $scope.isAdd  = true;
        $location.path($stateParams.tenantid+"/transaction/approvals/ownerexpenses");
        
    };
    
    $scope.printDiv = function(creditCode) {
        var url = $stateParams.tenantid+'/app/purchaseCreditNote/print?creditCode=' + creditCode;
        var wnd = window.open(url, 'Shipping', 'height=400,width=750,top=100,left=100,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
        wnd.print();
   
     }
    $.fn.simulateClick = function() {
        return this.each(function() {
            if ('createEvent' in document) {
                var doc = this.ownerDocument, evt = doc.createEvent('MouseEvents');
                evt.initMouseEvent('click', true, true, doc.defaultView, 1, 0, 0, 0, 0, false, false, false, false, 0, null);
                this.dispatchEvent(evt);
            } else {
                this.click(); // IE
            }
        });
    }
    
    $scope.excel=function(){
    //    alert("hi");
            
            var d = new Date();
            var n = d.getMinutes();
            var s = d.getSeconds();
            var mon=Number(d.getMonth())+1;
            var day=d.getDate();
            var yr=d.getFullYear();
            var ms=d.getMilliseconds();
            
            var obj = $filter('filter')($scope.rowCollection, {
                select : true
            });
            
            if(obj==undefined || obj.length==0){
                obj= $scope.rowCollection;
            }
            $scope.selectedres={
                    lOwnerExpenseList:obj,
                    filename:"OwnerExpenses"+day+""+mon+""+yr+""+n+""+s+""+ms
            }
            
            
            $scope.filename="OwnerExpenses"+day+""+mon+""+yr+""+n+""+s+""+ms+".xlsx";
            
           
            
            $http.post($stateParams.tenantid+'/app/ownerExpense/generateExcel',$scope.selectedres).success(function(data) {
                //alert("hi");

                $('#exportXls').remove();
                $('.excels').append('<div id="exportXls"></div>');
                        var file='<a id="tbExcelExport" stype="display:none" href="filePath/'+$scope.filename+'" download="'+$scope.filename+'"></a>'
                    
                       $('#exportXls').append(file);
                       $("#tbExcelExport").bind('click', function() {
                       });
                       $('#tbExcelExport').simulateClick('click');

                
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
            
        }

    
});
app.controller('ownerExpensesCtrl', function($scope, $rootScope, $http, $location, logger, $log, ngDialog, $modal, utilsService, sharedProperties, $state,$stateParams) {
    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.hideAddIcon = true;
    $scope.hideUploadIcon = true;
    $scope.hideEditIcon = true;
    $scope.hideBreadcrumb = true;   
    $scope.showEmptyLabel = false;
  
    
    $scope.getListDetail=function(){
        $http.get($stateParams.tenantid+'/app/ownerExpense/list').success(function(datas){
            console.log(datas);
            $scope.rowCollection = datas.lOwnerExpenseList;
            console.log($scope.rowCollection);
         });
    }
    
    $scope.ownersExpense ={
            vessel:'',
            vesselOwnerCode:''
    }
    
    $scope.cancel = function() {
        $state.go('app.finance.transaction.approvals.ownerexpensesList',{tenantid:$stateParams.tenantid});
        
    };
    $scope.getListvalues =function(){
        $http.get($stateParams.tenantid+'/app/commonUtility/getVesselList').success(function(datas) {
            $scope.vesselList = datas;
            }).error(function(datas) {
        });
        
        
        $http.get($stateParams.tenantid+'/app/commonUtility/getSubAccountCodeListTradeCreditors').success(function(datas) {
            $scope.vesseOwnerList = datas;
            }).error(function(datas) {
        });
    }
    
    $scope.getListvalues();
    
    $scope.typeList=[];
    var obj={
            id: 'A',
            text:'Approved'
    }
    $scope.typeList.push(obj);
    obj={
            id: 'U',
            text:'Un Allocated'   
    }
    $scope.typeList.push(obj);
    obj={
            id: 'W',
            text:'Waiting for Approval'   
    }
    $scope.typeList.push(obj);
    
    $scope.type ='U';
    
   // $scope.getListDetail();
    
    $scope.getList =function(){
        $http.post($stateParams.tenantid+'/app/ownerExpense/getFilterList',$scope.type).success(function(datas){
            console.log(datas);
            $scope.rowCollection = datas.lOwnerExpenseList;
            console.log($scope.rowCollection);
         });
    }
    
    $scope.getUnAllocatedList =function(){
        debugger;
        /*if($scope.ownersExpense.vessel !='' && $scope.ownersExpense.vesselOwnerCode !=''){*/
            $http.post($stateParams.tenantid+'/app/ownerExpense/getUnAllocatedList',$scope.ownersExpense).success(function(datas){
                console.log(datas);
                $scope.rowCollection = datas.lOwnerExpenseList;
                console.log($scope.rowCollection);
             });
        /*}else{
            logger.logError("Please select vessel and vessel owner");
        }*/
            
        
    }
    $scope.currentURL=$location.protocol() + '://'+ $location.host() +':'+  $location.port()+"/#" +$location.path();
    if(window.localStorage.getItem('ownerexp')==$scope.currentURL){
         alert('window ' + $scope.currentURL + ' is already opened');
         window.focus();
         //window.open($rootScope.currentURL,'_self').close();
         window.close();
     }else{
         window.localStorage.setItem('ownerexp', $scope.currentURL);
     }
    $(window).unload(function(){
        //debugger;
       //alert("INSIDE UNLOAD")
         localStorage.removeItem('ownerexp');
       });
    $scope.calculateTotalAmountForIA =function(){
        debugger;
        $scope.totalBCAmount=0.0;
        $scope.totalTCAmount=0.0;
        $scope.currencyCode ='';
        $scope.exchangerate ;
        var iCounter=0;
        angular.forEach($scope.rowCollection, function(row, index) {
            var check =row.select;
            if (check ==true) {
                   $scope.totalBCAmount=parseFloat($scope.totalBCAmount)+parseFloat(row.bcAmount);
                   $scope.totalTCAmount=parseFloat($scope.totalTCAmount)+parseFloat(row.tcAmount)
               
            }
        });
    }
    
    $scope.calculateBCAmount = function(rowData){
        debugger;
        rowData.bcAmount =parseFloat(rowData.tcAmount)/parseFloat(rowData.exchangeRate);
        rowData.bcAmount = rowData.bcAmount.toFixed(2);
    }
    
    $scope.calculateTCAmount = function(rowData){
        debugger;
        rowData.tcAmount =parseFloat(rowData.bcAmount)*parseFloat(rowData.exchangeRate);
        rowData.tcAmount =rowData.tcAmount.toFixed(2);
    }
    
    $scope.validateSelectedRow =function(selectedRowDatas){
        $scope.isValidateSucess = true;
        angular.forEach(selectedRowDatas, function(row, index) {
            if($scope.isValidateSucess){
                if(row.bcAmount == 0 || row.bcAmount =="" || row.bcAmount == null){
                    $scope.isValidateSucess = false;
                }
            }
        });
    };
    
    $scope.proceed=function(rowCollection){
        debugger;
        $scope.tablerow=[];
        angular.forEach(rowCollection, function(row, index) {
            var check =row.select;
            if (check ==true) {
                delete row['select'];
                $scope.tablerow.push(row);
            }else{
                // do nothing
            }
        });
        //if($scope.tablerow.length==1){
            $scope.validateSelectedRow($scope.tablerow);
            var checkProceed = false;
            if( $scope.isValidateSucess){
                for(var i = 0;i < $scope.tablerow.length;i++){
                    for(var j = i+1;j < $scope.tablerow.length;j++){
                        if($scope.tablerow[i].vessel != $scope.tablerow[j].vessel || $scope.tablerow[i].vesselOwnerCode != $scope.tablerow[i].vesselOwnerCode)
                            checkProceed = true;
                    }
                }
                if(checkProceed)
                    logger.logError("Vessel and Vessel Owner for the selected row should be same");
                else{
                    sharedProperties.setObject($scope.tablerow);
                    $state.go('app.finance.transaction.approvals.ownerexpensesAdd',{tenantid:$stateParams.tenantid});
                }
            }else{
                logger.logError("Please enter valid Amount for selected row");
            }
        /*}else{
            logger.logError("Please Select only one row!...");
        }*/
            
    }
});

app.controller('ownerExpensesAddCtrl', function($scope, $rootScope, $http, $location, logger, $log, ngDialog, $modal, utilsService, sharedProperties, $state,$stateParams) {
    console.log("sharedProperties.getObject()");
    console.log(sharedProperties.getObject());
    $scope.rowCollection = sharedProperties.getObject();
    

    $scope.currencyCode ='';
    $scope.exchangerate ;


    $scope.agencyCommision={
            subject : '',
            description:'',
            currency:'',
            exchangeRate:0.0,
            tcAmount:0.0,
            bcAmount:0.0
    }
    
    $http.get($stateParams.tenantid+'/app/purchaseinvoice/getCurrencyList').success(function(datas) {
        $scope.currencyList = datas;
        }).error(function(datas) {
    });
    
    

   
    
    $scope.$watch('agencyCommision.currency', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
            $http.get($stateParams.tenantid+'/app/commonUtility/getExchangeRateWithCurrency?currencyCode='+newValue).success(function(data){
                if(data.success){
                    $scope.fromCurrency=data.fromCurrency;
                    $scope.toCurrency=data.toCurrency;
                    $scope.agencyCommision.exchangeRate=data.exchangeRate;    
                }else{
                    $scope.agencyCommision.exchangeRate='';
                }                
            }).error(function(data) {
            });
        }
    });
    
    
    var bcAmt = 0.00;
    var tcAmt= 0.00;
    $scope.exchagerateCalculation=function(excahgerate){

        debugger;
        if(excahgerate>0){
            if(parseFloat(excahgerate) < $scope.fromCurrency || parseFloat(excahgerate) > $scope.toCurrency){
                logger.logError("Please Enter Exchange Rate Between "+$scope.fromCurrency+" and "+
                        $scope.toCurrency);       
                $scope.agencyCommision.exchangeRate=0;
            }else{
                if(isNaN(parseFloat($scope.agencyCommision.tcAmount, 10))){                   
                    if(isNaN(parseFloat($scope.agencyCommision.bcAmount, 10))){
                         bcAmt = Math.floor(((isNaN(parseFloat( $scope.agencyCommision.tcAmount, 10))?0: $scope.agencyCommision.tcAmount) / parseFloat(excahgerate))*100)/100;
                         tcAmt = Math.floor(((isNaN(parseFloat($scope.agencyCommision.bcAmount, 10))?0:$scope.agencyCommision.bcAmount) * parseFloat(excahgerate))*100)/100;
                        
                        $scope.agencyCommision.tcAmount = parseFloat(tcAmt).toFixed(2);
                        $scope.agencyCommision.bcAmount = parseFloat(bcAmt).toFixed(2);
                    }else{
                         tcAmt = Math.floor(((isNaN(parseFloat($scope.agencyCommision.bcAmount, 10))?0:$scope.agencyCommision.bcAmount) * parseFloat(excahgerate))*100)/100;
                        $scope.agencyCommision.tcAmount = parseFloat(tcAmt).toFixed(2);
                    }
                }else {
                     bcAmt = Math.floor(((isNaN(parseFloat( $scope.agencyCommision.tcAmount, 10))?0: $scope.agencyCommision.tcAmount) / parseFloat(excahgerate))*100)/100;
                    $scope.agencyCommision.bcAmount = parseFloat(bcAmt).toFixed(2);
                }
            } 
        }else{
            excahgerate=0;
            if(parseFloat(excahgerate) < $scope.agencyCommision.fromCurrency || parseFloat(excahgerate) > $scope.agencyCommision.toCurrency){
                logger.logError("Please Enter Exchange Rate Between "+$scope.agencyCommision.fromCurrency+" and "+
                        $scope.agencyCommision.toCurrency);       
                excahgerate=0;
            }else{
                $scope.agencyCommision.bcAmount = parseFloat(0).toFixed(2);
            }             
        }           
     }
    



   $scope.calculateBCAmount = function(rowData){
       debugger;
       rowData.bcAmount =parseFloat(rowData.tcAmount)/parseFloat(rowData.exchangeRate);
       rowData.bcAmount = rowData.bcAmount.toFixed(2);
     //  $scope.agencyCommision.bcAmount =  parseFloat(rowData.bcAmount);
     //  $scope.totalBC1Amount = $scope.totalBC1Amount + parseFloat($scope.agencyCommision.bcAmount);
   }
   
   $scope.calculateTCAmount = function(rowData){
       debugger;
       rowData.tcAmount =parseFloat(rowData.bcAmount)*parseFloat(rowData.exchangeRate);
       rowData.tcAmount =rowData.tcAmount.toFixed(2);
      // $scope.agencyCommision.tcAmount =  parseFloat(rowData.tcAmount);
    //   $scope.totalTC1Amount = parseFloat($scope.totalTC1Amount) + $scope.agencyCommision.tcAmount;
   } 
   


   $scope.calculate=function(){
       $scope.totalBC1Amount=0.0;
       $scope.totalTC1Amount=0.0;
       var tempobject={
               description:$scope.agencyCommision.description,
               currencyCode:$scope.agencyCommision.currency,
               exchangeRate:$scope.agencyCommision.exchangeRate,
               tcAmount:$scope.agencyCommision.tcAmount,
               bcAmount:$scope.agencyCommision.bcAmount
       }
      
   $scope.OwnerexpObj={
           lOwnerExpenseList:$scope.rowCollection,
           agencyCommision:tempobject
   }
       angular.forEach($scope.rowCollection, function(row, index) {
           
                  $scope.totalBC1Amount=parseFloat($scope.totalBC1Amount)+parseFloat(row.bcAmount);
                  $scope.totalTC1Amount=parseFloat($scope.totalTC1Amount)+parseFloat(row.tcAmount)
              
       });
       console.log("tempobject.bcAmount"+tempobject.bcAmount)
       $scope.totalBC1Amount = $scope.totalBC1Amount + parseFloat(tempobject.bcAmount );
       $scope.totalTC1Amount =   $scope.totalTC1Amount + parseFloat(tempobject.tcAmount) ;
       
   console.log("$scope.OwnerexpOb")
   console.log( $scope.totalBC1Amount)
         } 
    $scope.save=function(){
        
        var tempobject={
                hdrDescription : $scope.agencyCommision.subject,
                description:$scope.agencyCommision.description,
                currencyCode:$scope.agencyCommision.currency,
                exchangeRate:$scope.agencyCommision.exchangeRate,
                tcAmount:$scope.agencyCommision.tcAmount,
                bcAmount:$scope.agencyCommision.bcAmount
        }
       
        $scope.OwnerexpObj={
                lOwnerExpenseList:$scope.rowCollection,
                agencyCommision:tempobject
        }
        
        
        
        console.log($scope.OwnerexpObj);
       $http.post($stateParams.tenantid+'/app/ownerExpense/saveOwnersExpenselist', $scope.OwnerexpObj).success(function(result) {
            if(result.success) {
                logger.logSuccess("Saved sucessfully");
                $state.go('app.finance.transaction.approvals.ownerexpensesList',{tenantid:$stateParams.tenantid});
            } else {
                logger.logError("Vessel Owner is mandatory for the selected row");
            }
        }).error(function(result) {
            console.log("data" + result);
        });
    }
     
    $scope.cancel = function() {
        $state.go('app.finance.transaction.approvals.ownerexpensesList',{tenantid:$stateParams.tenantid});
        
    };
  
    
});