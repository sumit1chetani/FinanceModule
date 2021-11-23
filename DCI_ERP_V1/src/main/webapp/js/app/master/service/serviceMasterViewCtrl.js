'use strict';   
app.controller('serviceMasterViewCtrl', function($scope, $rootScope, $http, $location,ngDialog, logger, utilsService,$state,sharedProperties,$window,$stateParams) {
alert("helloooo")
    $scope.vendorlist = [];
    $scope.cancel = function() {
        $location.path($stateParams.tenantid+"service/servicemaster");
    };
    
    $scope.serviceMaster={
            
           
                    sectorCode : '',
                    sectorName : '',
                    operationSince : '',
                    eqmtCntrlEnable : 'Y',
                    isActive : 'Y',
                    commenceDate : '',
                    completionDate : '',
                    companyCode : '',
                    companyLocation : '',
                   isEdit : false,
                    tables : []

                };
    
    
  

                $scope.FetchingValues = function(data) {
                    console.log("ramya");
                    console.log(data);
                    $scope.serviceMaster.sectorCode  =    data.sectorCode;
                    $scope.serviceMaster.sectorName =     data.sectorName ;
                    $scope.serviceMaster.operationSince = data.operationSince ;
                    $scope.serviceMaster.eqmtCntrlEnable = data.eqmtCntrlEnable ;
                    $scope.serviceMaster.isActive = data.isActive ;
                    $scope.serviceMaster.commenceDate = data.commenceDate ;
                    $scope.serviceMaster.companyCode= data.companyCode ;
                    $scope.serviceMaster.companyLocation = data.companyLocation ;
                    
                      
                }
                
                $scope.FetchingValues(sharedProperties.getObject());
        }).error(function(data) {

        });
    
    

  

