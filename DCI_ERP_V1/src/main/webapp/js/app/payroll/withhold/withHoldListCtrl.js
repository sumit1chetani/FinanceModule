
    'use strict';
   	app.controller('withHoldListCtrl', function($stateParams,$scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService,utilsService, $window,$timeout) {

   // module.registerController('withHoldListCtrl', function($scope,$state,$http,ngDialog, logger,$location,$controller,$injector, sharedProperties, toaster,$rootScope)  {
       
        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.isDelete=true;
        $scope.isUpload=true;
//        $scope.check=false;
        $scope.withhold = {
                
                employee:'',
withholdDate   :'',
frommonth:'',
fromyear:'',
tomonth:'',
toyear:'',
withHoldCode:'',
               
         };
        
        //today date 
        var today = new Date();
        var dd = today.getDate();
        var mm = today.getMonth() + 1; // January is 0!
        var yyyy = today.getFullYear();
        var time = today.getHours() + ":" + today.getMinutes()
        if (dd < 10) {
            dd = '0' + dd
        }
        if (mm < 10) {
            mm = '0' + mm
        }

        $scope.withhold.withholdDate = dd + '/' + mm + '/'
                + yyyy +time;

        var today = new Date();
        var dd = today.getDate();
        var mm = today.getMonth() + 1;

        var yyyy = today.getFullYear();
        var time = today.getHours() + ":" + today.getMinutes()
        if (dd < 10) {
            dd = '0' + dd;
        }
        if (mm < 10) {
            mm = '0' + mm;
        } 
        var today1 = dd + '/' + mm + '/' + yyyy ;
        $scope.withhold.withholdDate = today1;
        console.log(today);
        $scope.chektoday=today1;
       
        $scope.getList = function(){
            $http.get("payroll/payroll/withhold/withHoldList")
            .success(function(response) {
                console.log("Coming inside List");
                console.log(response);
                
                $scope.rowCollection = response.withholdList;
                
                
        
            });
        };
        
        $scope.getList();
        
        
        $scope.getdateList = function(){
            $http.get("payroll/payroll/withhold/dateList")
            .success(function(response) {
                console.log("Coming inside List");
                console.log(response);
                for( var i=0;i<response.withholdAddList.length;i++){
                    $scope.dte=response.withholdAddList[i].withholdTo
                    if($scope.chektoday<$scope.dte){
                        
                        $scope.chk=true;
 
                    }
                    else{
                        $scope.chk=false;
                    }
                }
                    
                
                
        
            });
        };
        $scope.getdateList();

       
        $scope.editRow = function (withHoldCode,check){
            debugger
          $location.url($stateParams.tenantid+'/payroll/withhold/withholdedit?withHoldCode='+withHoldCode+'&check='+check);
        }
        
        
        $scope.editRow1 = function (withHoldCode){
            $location.url($stateParams.tenantid+'/payroll/withhold/withholdview?withHoldCode='+withHoldCode);
          }
        $scope.add =function(){
            
            $state.go('app.payroll.withhold.add');
          };
       
            
            $scope.deleteRow = function(withHoldCode) {
                ngDialog.openConfirm().then(function() {
                    $http.get("payroll/payroll/withhold/deletewithHold?withHoldCode="+ withHoldCode)
                    .success(function(response) {
                        console.log("result is");
                        console.log(response);
                       if(response == true){
                           logger.logSuccess("Deleted Successfully!");
                           $scope.getList();
                       }else{
                           logger.logError("Unable to delete Record");
                       }
                    }).error(function(result) {
                        logger.logError("Error Please Try Again");
                    });
                });
            };
            
           
    });
    
