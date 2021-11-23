'use strict';
app.controller('lpoListCtrl', function($scope, $rootScope, $http, $location, logger, $log, ngDialog, $modal, utilsService, sharedProperties, $state,$controller,$stateParams) {

    $scope.pageCounters = [14, 16, 17, 18, 150, 500, 1000 ];

    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 14;
    $scope.initial = {}; 
    $scope.isAdd = true; 
    $scope.purchaseInvoiceData = {
            puchaseInvoiceNo :'',
            puchaseInvoiceDate :'',
            supplier :'',
            partyInvoiceNo :'',
            partyInvoiceDate :'',
            purchaseNo :'',
            dueDate :'',
            currency :'',
            exgRate :'',
            amountLocal :'',
            amountUSD :'',
            company :'',
            description :'',
            type:'',
            purInvDetail : [],
            detailArr:[],
            edit : false
         };
    $scope.currentURL=$location.protocol() + '://'+ $location.host() +':'+  $location.port()+"/#" +$location.path();
    
    if(window.localStorage.getItem('lpo_list')==$scope.currentURL){
        alert('window ' + $scope.currentURL + ' is already opened');
       // window.focus();
        setTimeout(window.close(),1000);
        //localStorage.removeItem('lpo');
       // window.close();
        
    }else{
        window.localStorage.setItem('lpo', $scope.currentURL);
        localStorage.removeItem('lpo');
    }  
//    $(window).unload(function(){
//       // debugger;
//      // alert("INSIDE UNLOAD")
//         
//       });
  
    $scope.getPurchaseInvoiceList = function() {
       debugger;
        $http.get($stateParams.tenantid+'/app/invoice/lpo/list?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount + '&formCode='+$('#form_code_id').val()).success(function(data) {
           if (data.success == true && !utilsService.isUndefinedOrNull(data.lpoList)) {
               console.log("LPO List *****");
               console.log(data.lpoList);
                $scope.rowCollection = $scope.rowCollection.concat(data.lpoList);
            }
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
    };

    $scope.getPurchaseInvoiceList();
    
    
    $scope.copyLPO = function(reverseLpoNo) {
        
        console.log("first step copyLPO")
        console.log(reverseLpoNo)
        if(reverseLpoNo =="" || reverseLpoNo ==undefined){
            logger.logError("Please select LPO Number");
        }else{
                   
            $location.path($stateParams.tenantid+'/invoice/lpo/copyLPO/'+reverseLpoNo);    
        }
        
    }
    
    $scope.getReverseLpoNo = function() {
         $http.get($stateParams.tenantid+'/app/invoice/lpo/reverseLpoNo').success(function(data) {
             $scope.reverseLpoList=data;
             
             console.log("reverse list")
             console.log($scope.reverseLpoList)
         }).error(function(data) {
             logger.logError("Error Please Try Again");
         });
     };
     $scope.getReverseLpoNo();   
     
  debugger;
     $scope.reverseLpo = function(lpoNo) {
         $scope.lpoNo = lpoNo;
         if($scope.lpoNo =="" || $scope.lpoNo ==undefined){
             logger.logError("Please select LPO Number");
         }else{
             ngDialog.open({
                 scope : $scope,
                 template : 'views/finance/transaction/transactionReverseDialog',
                 controller : $controller('LPOReverseCtrl', {
                     $scope : $scope,
                     lpoNo: $scope.lpoNo,
                     screenName: 'lpo'
                 }),
                 className : 'ngdialog-theme-plain',
                 showClose : false,
                 closeByDocument : false,
                 closeByEscape : false,
                 preCloseCallback : $scope.getList
             });
         }
         
         /*console.log(lpoNo)
              $http.get('app/invoice/lpo/reverseLpo?lpoNo='+lpoNo).success(function(data) {
             if (data.success) {
                 logger.logSuccess("LPO Reversed successfully");
                 $scope.getReverseLpoNo();   
             }else{
                 if(data.message != null && data.message != ''){
                     logger.logError(data.message);
                 }else{
                     logger.logError("Unable to reverse LPO:"+lpoNo);
                 }
             }
         }).error(function(data) {
             logger.logError("Error Please Try Again");
         });*/
       
     };

    //** ********Add,Edit and Delete******** *//*
  $scope.add = function() {
      $scope.isAdd  = true;
      $location.path($stateParams.tenantid+"/invoice/lpo/lpoAdd");
      
  };

    // Redirecting Page For Edit Functionality
    $scope.editRow = function(lpoNo,index) {
        $scope.isAdd  = false;
        $location.path($stateParams.tenantid+"/invoice/lpo/lpoEdit/"+lpoNo);
    };

    // remove to the real data holder
    $scope.deleteRow = function(lpoNo, index) {
        ngDialog.openConfirm().then(function() {
            var myURL = $stateParams.tenantid+'/app/invoice/lpo/delete';
            $http({
                method : 'post',
                url : myURL,
                data : lpoNo,
            }).success(function(data) {
                if (data == true) {
                    var tableData = $scope.rowCollection;
                    $scope.rowCollection.splice(index, 1);
                    logger.logSuccess("Purchase Invoice deleted successfully");
                } else {
                    logger.logError("Error in deleting Purchase Invoice master!");
                }
            }).error(function(data) {
                logger.logSuccess("Error in Delete Purchase Invoice Master!");
            });
            console.log('Modal promise resolved. Value: ');
        }, function(reason) {
            console.log('Modal promise rejected. Reason: ', reason);
        });

    };
    
 // Redirecting Page For View Functionality
    $scope.view = function(lpoNo,index) {
        $scope.isAdd  = false;
        $location.path($stateParams.tenantid+"/invoice/lpo/lpoView/"+lpoNo);
    };

    });

app.controller('LPOReverseCtrl', function($scope, $http,ngDialog,logger,$location,lpoNo,screenName,$timeout,$stateParams ) {
    
    $scope.lpoData = {lpoDate:'', lpoNo:''};
    
    $scope.screenNames = screenName;
    
        /*$timeout(function() {
            $("#jvReverse_Date").datetimepicker({
                minDate: "01/01/2016",
                format : 'DD/MM/YYYY',
                pickTime: false
            });
         }, 1000);
        
        $("#jvReverse_Date").on("dp.change", function(e) {
            $scope.jvReverseObj.dataOfIssue = $('#txtJvReverseDate').val();
        });*/
        
        $timeout(function() {
            $("#txtLpoReverseDate").datetimepicker({
                minDate: "01/01/2016",
                format : 'DD/MM/YYYY',
                pickTime: false
            });
         }, 1000);
        
        $("#txtLpoReverseDate").on("dp.change", function(e) {
            $scope.lpoData.lpoDate = $('#txtLpoReverseDate').val();
        });
    
        
    
    $scope.getCurrentDate = function(){
        var today = new Date();
        var dd = today.getDate();
        var mm = today.getMonth() + 1;

        var yyyy = today.getFullYear();
        if (dd < 10) { dd = '0' + dd }
        if (mm < 10) { mm = '0' + mm }
        var today = dd + '/' + mm + '/' + yyyy;
        $scope.lpoData.lpoDate  = today;
    }
        $scope.getCurrentDate();
    $scope.lpoData.lpoNo = lpoNo;
   
    $scope.reverseConfirm = function(){
        if($scope.screenNames=="lpo"){
            if($scope.lpoData.lpoDate != ""){
                $http.post($stateParams.tenantid+'/app/invoice/lpo/reverseLpo',$scope.lpoData).success(function(data) {
                    if (data.success) {
                        logger.logSuccess("LPO Reversed successfully");
                        $scope.closeLPOReverseDialog();   
                    }else{
                        if(data.message != null && data.message != ''){
                            logger.logError(data.message);
                        }else{
                            logger.logError("LPO is already reversed"+lpoNo);
                        }
                    }
                }).error(function(data) {
                    logger.logError("Error Please Try Again");
                });
                
            }else{
                logger.logError("Please Select LPO Date!");
            }
        }
    }
    $scope.closeLPOReverseDialog = function() {
        ngDialog.close();
     };
});
