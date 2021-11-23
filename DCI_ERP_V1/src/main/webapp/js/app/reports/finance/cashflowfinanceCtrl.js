'use strict';
    app.controller('cashflowController', function($scope,$rootScope,$http, logger, $log, ngDialog, $modal, $window,$location,$filter,$stateParams) {
        $scope.cashflow={
                fromDate:'',
                toDate:'',
                company:'',
             }
        
        $('#fromDate').datetimepicker({
            format : 'DD/MM/YYYY',
            pickTime: false
        });
        
        $('#toDate').datetimepicker({
            format : 'DD/MM/YYYY',
            pickTime: false
        });

        console.log($('#form_code_id').val());
        $http.get($stateParams.tenantid+'/app/usermaster/getCompanyList?formCode='+$('#form_code_id').val()).success(function(datas) {
            debugger;           
            $scope.companyList = datas; 
            var foundItemDest = $filter('filter')($scope.companyList, { baseCompany:  1 })[0];
            $scope.cashflow.company=foundItemDest.id;
            }).error(function(datas) {
        });
        
        $scope.viewProfitLoss = function(){
            var date=new Date();
            $scope.month = $filter('date')(date, 'MMMM');//December-November like
            $scope.day = $filter('date')(date, 'dd'); //01-31 like
            $scope.year = $filter('date')(date,'yyyy');
            
            $scope.currYear = Number($scope.year);
            $scope.prevYear = Number($scope.year) - 1;
            $scope.pl.company =   $scope.cashflow.company;
            $scope.pl.fromDate = $('#fromDate').val();
            $scope.pl.toDate = $('#toDate').val();
            $http.post($stateParams.tenantid+'/app/profitloss/generatePLReport', $scope.pl).success(function(datas) {
                debugger;
                $scope.populateProfitAndLossGrid(datas);
                console.log(datas);
                }).error(function(datas) {
            });
        }
        
        $scope.exportPLExcel = function(){
            $scope.pl.fromDate = $('#fromDate').val();
            $scope.pl.toDate = $('#toDate').val();
            $http.post($stateParams.tenantid+'/app/profitloss/exportPLExcel',$scope.pl).success(function(data) {
                if(data){
                    debugger;
                    $("#PLExport").bind('click', function() {
                    });
                    $('#PLExport').simulateClick('click');
                    logger.logSuccess("Exported successfully!");
                }else{
                    logger.logSuccess("Failed to export");
                }
                }).error(function(datas) {
            });
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
        
     
    });


