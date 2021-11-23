'use strict';
    app.controller('financereportCtrl', function($scope, $rootScope,$http, logger, $log, ngDialog, $modal, $window,$location,$filter,$timeout,$stateParams) {
        $scope.financereport={
                fromDate:'',
                toDate:'',
                company:'',
                financeyear:''
             }
        $scope.lastyearList=[];
        $('#pl_fromDate').datetimepicker({
            format : 'DD/MM/YYYY',
            pickTime: false
        });
        
        $('#pl_toDate').datetimepicker({
            format : 'DD/MM/YYYY',
            pickTime: false
        });
        $('#financeyear').datetimepicker({
            format : 'YYYY',
            pickTime: false
        });
      
        $scope.getYear = function() {
            $scope.lastyearList = [];
            var d = new Date();
           
            for (var i = 15; i >=1; i--) {
                var data = {};               
                var year = d.getFullYear() - i;
                data['id'] = "" + year;
                data['text'] = "" + year;
                $scope.lastyearList.push(data);
            }
            var data = {};  
            var year = d.getFullYear();
            data['id'] = "" + year;
            data['text'] = "" + year;
            $scope.lastyearList.push(data);
            
            for (var i = 1; i < 5; i++) {
                var data = {};                
                var year = d.getFullYear() + i;
                data['id'] = "" + year;
                data['text'] = "" + year;
                $scope.lastyearList.push(data);
            }
            $scope.financereport.financeyear=d.getFullYear();
          
            return $scope.lastyearList;
        }
        $scope.getYear();
        var d = new Date();
        $scope.financereport.financeyear="" +d.getFullYear();
        $scope.toggleBlock = function(blockId) {
            $('#'+blockId).slideToggle(10);
    }
    //$("div[id$='Block']").slideToggle(10);

        $("#txtCompanyCode").multiselect({
            maxHeight: 200,   
            includeSelectAllOption: true,
            disableIfEmpty: true,
            enableCaseInsensitiveFiltering: true,
            onDropdownHide: function (event) {
                
            }
          });
        
        console.log($('#form_code_id').val());
        $http.get($stateParams.tenantid+'/app/usermaster/getCompanyList?formCode='+$('#form_code_id').val()).success(function(datas) {
            debugger;           
            $scope.companyList = datas;    
            console.log("company")
            console.log($scope.companyList)
            var foundItemDest = $filter('filter')($scope.companyList, { baseCompany:  1 })[0];
          $scope.financereport.company=foundItemDest.id;
            
            
            /*$timeout(function() {
                $('#txtCompanyCode').multiselect('deselectAll', false);
                $('#txtCompanyCode').multiselect('updateButtonText');
                $("#txtCompanyCode").multiselect('rebuild');
            
            }, 2, false);
            $("#multiselect-button").addClass("width_100 input-sm line-height-5");*/
            }).error(function(datas) {
        });
        
        $scope.viewProfitLoss = function(){
            $scope.financereport.fromDate = $('#fromDate').val();
            $scope.financereport.toDate = $('#toDate').val();
            
           
            $http.post($stateParams.tenantid+'/app/profitloss/generatePLReport',$scope.financereport).success(function(datas) {
                debugger;
                $scope.populateProfitAndLossGrid(datas);
                console.log(datas);
                }).error(function(datas) {
            });
        }
        
       
        
        $scope.exportPLExcel = function(){
            $scope.financereport.fromDate = $('#fromDate').val();
            $scope.financereport.toDate = $('#toDate').val();
            
            if($scope.companyCodes!=undefined && $scope.companyCodes!=null && $scope.companyCodes!='' && $scope.companyCodes.length>0){
                $scope.financereport.company=$scope.companyCodes.join(",");
            }
            
            var d = new Date();
            var n = d.getMinutes();
            var s = d.getSeconds();
            var mon=Number(d.getMonth())+1;
            var day=d.getDate();
            var yr=d.getFullYear();
            var ms=d.getMilliseconds();
           
            $scope.filename="FinanceStmt"+day+""+mon+""+yr+""+n+""+s+""+ms+".xls";
            
            $scope.financereport.filename="FinanceStmt"+day+""+mon+""+yr+""+n+""+s+""+ms;
            
            $http.post($stateParams.tenantid+'/app/financeStmt/excelexport',$scope.financereport).success(function(data) {
                if(data){
                    $('#exportXl').remove();
                    $('.excel').append('<div id="exportXl"></div>');
                            var file='<a id="tbExcelExport" stype="display:none" href="filePath/'+$scope.filename+'" download="'+$scope.filename+'"></a>'
                        
                           $('#exportXl').append(file);
                           $("#tbExcelExport").bind('click', function() {
                           });
                           $('#tbExcelExport').simulateClick('click');

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


