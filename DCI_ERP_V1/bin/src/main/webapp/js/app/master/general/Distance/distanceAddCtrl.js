'use strict';
app.controller('distanceAddCtrl', function($scope, $rootScope, $injector, $http, $location, logger, utilsService, $state, sharedProperties, $window,toaster,validationService,$stateParams) {

   
    $scope.viewDisable=true;
    $scope.cancel = function() {
        $location.path($stateParams.tenantid+"/general/distance");
    };

   

    $scope.reset=function(){
        $scope.distanceData=[];
        $scope.getDropdownvalue();
    }

    $scope.distanceData = {
            dNo : '',
        fromPort : '',
        toPort : '',        
        disMiles : '',
        isEdit : false
    };
 
    $scope.portList = [];
    
    // Drop Down Functionality

    $scope.getDropdownvalue = function() { 
        $http.get($stateParams.tenantid+'/app/distance/getPort').success(function(datas) {
             $scope.portList =datas.portList;
             console.log("HI");
             console.log(datas.portList);
          
        });
    }
    $scope.getDropdownvalue();
    
    $scope.isEdit=false;
    var dNo = $location.search().dNo;
    if(dNo == undefined){
       var fromPort = $scope.distanceData.fromPort; 
       var toPort = $scope.distanceData.toPort; 
        var disMiles = $scope.distanceData.disMiles;
        $scope.distanceData.isEdit=false;
    }else {
    $http.post($stateParams.tenantid+'/app/distance/edit',dNo).success(function(result) {
        if (result.isEdit == false) {
            logger.logError("Please Try Again");
        } else {
            console.log("************")
            console.log(result)
            $scope.distanceData.fromPort=result.fromPort;
            console.log(result.fromPort);
            $scope.distanceData.toPort=result.toPort;
            $scope.distanceData.disMiles=result.disMiles;
            $scope.distanceData.isEdit=true;
        }
    }).error(function(data) {
        console.log("data" + data);
    });
    }

    $scope.save = function(distanceAddForm,distanceData) {
        if (new validationService().checkFormValidity($scope.distanceAddForm)) {
          if(distanceData.fromPort == distanceData.toPort)
              {
              logger.logError("Fromport and Toport should be different");
              }
          else{
          $http.post($stateParams.tenantid+'/app/distance/add', distanceData).success(function(result) {
                console.log("result" + result);
                if (result) {
                    logger.logSuccess("Saved successfully!");
                    $state.go('app.master.general.distance',{tenantid:$stateParams.tenantid});
                } else {
                    logger.logError("Data Already Exist, Please use edit option");
                }
            }).error(function(result) {
                console.log("data" + result);
            });
            }
      }
        else{
            toaster.pop('error', "Please fill the required fields", 
                    logger.getErrorHtmlNew($scope.distanceAddForm.$validationSummary), 555000, 'trustedHtml');
                       }
    };
    
        
        
        
    $scope.reset1=function(){
        $scope.distanceData=[];
        $http.post($stateParams.tenantid+'/app/distance/edit',dNo).success(function(result) {
            if (result.isEdit == false) {
                logger.logError("Please Try Again");
            } else {
                $scope.distanceData.fromPort=result.fromPort;
                console.log(result.fromPort);
                $scope.distanceData.toPort=result.toPort;
                $scope.distanceData.disMiles=result.disMiles;
                $scope.distanceData.isEdit=true;
            }
        }).error(function(data) {
            console.log("data" + data);
        });
        
    }
        
        
        
    $scope.update = function(distanceAddForm,distanceData) {
        if (new validationService().checkFormValidity($scope.distanceAddForm)) {
          if(distanceData.fromPort == distanceData.toPort)
          {
          logger.logError("Fromport and Toport should be different");
          }
      else{
            var dNo = $location.search().dNo;
            $scope.distanceData.dNo = $location.search().dNo;
            $http.post($stateParams.tenantid+'/app/distance/update', distanceData).success(function(result) {
                if (result) {
                    logger.logSuccess("Updated successfully!");
                    $state.go('app.master.general.distance',{tenantid:$stateParams.tenantid});
                } else {
                    logger.logError("Not Updated!");
                }
            }).error(function(data) {
                console.log("data" + data);
            });
        }
      }
        
        else{
            toaster.pop('error', "Please fill the required fields", 
                    logger.getErrorHtmlNew($scope.distanceAddForm.$validationSummary), 555000, 'trustedHtml');
                       }
    }
});