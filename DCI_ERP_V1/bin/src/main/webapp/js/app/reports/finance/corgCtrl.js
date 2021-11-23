'use strict';
app.controller('corgCtrl', function($scope, $rootScope, $http, $location, logger, ngDialog, utilsService,$state,sharedProperties,$window,$stateParams) {
    $scope.rowCollection=[];
    $scope.corgReport={
            companyCode:'C0000',
            selectedDate:'',           
            fromDate:'',
            toDate:'',
            year:'',
            week:'10'
            
    }
    
    $scope.weekEndDate='';
    
    $scope.reset=function(){
        $scope.corgReport={
                companyCode:'C0000',
                selectedDate:'',           
                fromDate:'',
                toDate:'',
                year:'',
                week:''
                
        }
        $('#fromDate').val('');
        $('#toDate').val('');
        $scope.corgReport.year=currentYear;
    }
    
    $('.datetimepick').datetimepicker({
        format : 'DD/MM/YYYY',
        calendarWeeks: true
    });
  
    $('#tb_fromDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime: false
    });
    
    $('#tb_toDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime: false
    });
   
    var d = new Date();
    var currentYear = d.getFullYear();
    $scope.corgReport.year=currentYear;
    $scope.getDropdownvalue = function() {
        $scope.companyList=[];
        
       var obj={
                'id':'C0001',
                'text':'Athena'
        }
        $scope.companyList.push(obj);
        
       $scope.weekList=[];
        for(var i=1;i<=53;i++){
            var week={};
            if(i<10){
            week.id='0'+i;
            }else{
                week.id=''+i;
            }
            week.text=''+i;
            $scope.weekList.push(week);
        }
        
        $scope.yearList=[];
        for(var i=2010;i<=2025;i++){
            var year={};
            year.id=i;
            year.text=''+i;
            $scope.yearList.push(year);
        }
        console.log($scope.weekList);
    }
    $scope.getDropdownvalue();
    
    $scope.$watch('corgReport.week', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
        $http.post($stateParams.tenantid+'/app/corg/getweekenddate', $scope.corgReport).success(function(data) {
            if(data.success){
                $scope.weekEndDate =data.weekEndDate;
                console.log( $scope.weekEndDate);
            }else{
                logger.logError("Error Please Try Again");
            }
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
        }
    });
    
    $scope.$watch('corgReport.year', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
        $http.post($stateParams.tenantid+'/app/corg/getweekenddate', $scope.corgReport).success(function(data) {
            if(data.success){
                $scope.weekEndDate =data.weekEndDate;
                console.log( $scope.weekEndDate);
            }else{
                logger.logError("Error Please Try Again");
            }
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
        }
    });
    
    $scope.viewCorgReport = function() {
        /*if( $('#fromDate').val()!=''){
            var fromDate=$('#fromDate').val().replace(/\//g, "-");
            $scope.corgReport.fromDate=fromDate;
          } if( $('#toDate').val()!=''){
            var toDate=$('#toDate').val().replace(/\//g, "-");   
            $scope.corgReport.toDate=toDate;
          }*/
          debugger;
          $http.post($stateParams.tenantid+'/app/corg/viewCorgReport', $scope.corgReport).success(function(data) {
              if(data.success){
                  debugger;
                  console.log(data.lCorgList);
                  $scope.rowCollection=data.lCorgList;
              }else{
                  logger.logError("Error Please Try Again");
              }
              
          }).error(function(data) {
              logger.logError("Error Please Try Again");
          });
    }
    
    $scope.viewCorgReportAsOnDate = function() {
        /*if( $('#fromDate').val()!=''){
            var fromDate=$('#fromDate').val().replace(/\//g, "-");
            $scope.corgReport.fromDate=fromDate;
          } if( $('#toDate').val()!=''){
            var toDate=$('#toDate').val().replace(/\//g, "-");   
            $scope.corgReport.toDate=toDate;
          }*/
          debugger;
          $http.post($stateParams.tenantid+'/app/corg/viewCorgReportAsOnDate', $scope.corgReport).success(function(data) {
              if(data.success){
                  debugger;
                  console.log(data.lCorgList);
                  $scope.rowCollection=data.lCorgList;
              }else{
                  logger.logError("Error Please Try Again");
              }
              
          }).error(function(data) {
              logger.logError("Error Please Try Again");
          });
    }
    
    $scope.exportCorgReport = function() {
        $http.post($stateParams.tenantid+'/app/corg/exportCorgReport', $scope.corgReport).success(function(data) {
            if(data){
                debugger;
                $("#corgExport").bind('click', function() {
                });
                $('#corgExport').simulateClick('click');
                logger.logSuccess("Exported successfully!");
            }else{
                logger.logSuccess("Failed to export");
            }
            
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
    }
    
    $scope.exportCorgReportAsOnDate = function() {
        $http.post($stateParams.tenantid+'/app/corg/exportCorgReportAsOnDate', $scope.corgReport).success(function(data) {
            if(data){
                debugger;
                $("#corgExport").bind('click', function() {
                });
                $('#corgExport').simulateClick('click');
                logger.logSuccess("Exported successfully!");
            }else{
                logger.logSuccess("Failed to export");
            }
            
        }).error(function(data) {
            logger.logError("Error Please Try Again");
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