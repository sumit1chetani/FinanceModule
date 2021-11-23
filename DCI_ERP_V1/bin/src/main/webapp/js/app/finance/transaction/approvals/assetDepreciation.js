'use strict';
app.controller('assetDepreciationCtrl', function($scope,$filter,$controller, $rootScope, $http, $location, logger, $log, ngDialog, $modal, utilsService, sharedProperties, $state,$stateParams) {
    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    
    $scope.getListDetail=function(){
        $http.get($stateParams.tenantid+'/app/assetDepreciation/list').success(function(datas){
            console.log(datas);
            $scope.rowCollection = datas.lAssetDepreciationList;
            console.log($scope.rowCollection);
         });
    }
    
    $scope.getListDetail();
    $scope.currentURL=$location.protocol() + '://'+ $location.host() +':'+  $location.port()+"/#" +$location.path();
    if(window.localStorage.getItem('assetdep')==$scope.currentURL){
        debugger;
       
         alert('window ' + $scope.currentURL + ' is already opened');
         //window.focus();
         //window.open($rootScope.currentURL,'_self').close();
         //window.open('$scope.currentURL', '_self', '');
         setTimeout(window.close(),5000);
     }else{
         window.localStorage.setItem('assetdep', $scope.currentURL);
     }
    $(window).unload(function(){
        localStorage.removeItem('assetdep');
        });


    $scope.approve=function(table){
        debugger;
        $scope.tablerow=[];
        angular.forEach(table, function(row, index) {
            var check =row.select;
            if (check ==true) {
                delete row['select'];
                $scope.tablerow.push(row);
            }else{
                
            }
        });
       
       if($scope.tablerow.length>0){
           ngDialog.open({
               scope : $scope,
               template : 'views/finance/transaction/transactionReverseDialog',
               controller : $controller('assetDepreciationApproveCtrl', {
                   $scope : $scope,
                   sVoucherNo: '21',
                   screenName: 'approvalDialog'
               }),
               className : 'ngdialog-theme-plain',
               showClose : false,
               closeByDocument : false,
               closeByEscape : false,
               preCloseCallback :  $scope.getListDetail
           });
       }else{
           logger.logError('Please select check box.')
       }
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
      // alert("hi");
            
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
            $scope.selectinterest={
                    lAssetDepreciationList:obj,
                    filename:"AssetDepreciation"+day+""+mon+""+yr+""+n+""+s+""+ms
            }
            
            
            $scope.filename="AssetDepreciation"+day+""+mon+""+yr+""+n+""+s+""+ms+".xlsx";
            
           
            
            $http.post($stateParams.tenantid+'/app/assetDepreciation/generateExcel',$scope.selectinterest).success(function(data) {
                console.log(data);
               // alert(JSON.stringify(data));

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
app.controller('assetDepreciationApproveCtrl', function($scope, $http,ngDialog,logger,$location,sVoucherNo,screenName,$timeout,$stateParams) {
    $scope.prepaidExp = {approvalDate:''};
    
    $scope.screenNames = screenName;
    
        $timeout(function() {
            $("#approval_Date").datetimepicker({
                minDate: "01/01/2016",
                format : 'DD/MM/YYYY',
                pickTime: false
            });
         }, 1000);
    
       
        
        $("#approval_Date").on("dp.change", function(e) {
            alert("dsd"+$('#approvalDate').val())
            $scope.prepaidExp.approvalDate = $('#approvalDate').val();
        });

    $scope.reverseConfirm = function(){
        $scope.prepaidExp.approvalDate = $('#approvalDate').val();
        if($scope.screenNames=="approvalDialog"){
            if($scope.prepaidExp.approvalDate!=""){
                var obj={
                        lAssetDepreciationList:$scope.tablerow,
                        approvalDate:$scope.prepaidExp.approvalDate
                }
                
                $http.post($stateParams.tenantid+'/app/assetDepreciation/createJvForAssetDepreciation', obj).success(function(result) {
                    if(result.success) {
                        logger.logSuccess("Approved successfully!");
                        ngDialog.close();
                    } else {
                        logger.logError("Unable to Approve");
                    }
                }).error(function(result) {
                    console.log("data" + result);
                });
            }else{
                logger.logError("Please Select Approval Date!");
            }
        }
    }
    $scope.closeCBPReverseDialog = function() {
        ngDialog.close();
     };
});