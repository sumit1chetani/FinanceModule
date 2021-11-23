'use strict';
app.controller('portmasterviewCtrl', function($scope, $rootScope, $http, $location,ngDialog, logger, utilsService,$state,sharedProperties,$window) {

    $scope.portlist = [];
    $scope.cancel = function() {
        $location.path("port/portMaster");
    };
    
    $scope.portMaster = {
            createdBy:'',
            createdDate :'',
          modifiedBy :'',
           modifiedDate :'',
            portCode : '',
            portName : '',
            countryId : '',
            countryName : '',
            portDesc : '',
            portEmail : '',
            portStatus : '',
            docksId : '',
            portType: '',
            berthId : '',
            rtg : '',
            qgc : '',
            rmqc : '',
            websiteAddress : '',
            rmgc : '',
            noOfCranes : '',
            referPoints : '',
            icd : '',
            reachStack : '',
            emptyHandlers : '',
            portIsoCode : '',
            transFreeDays : '',
            mulPort : [],
            test :'',
            isEdit : false

        }
    
    
    $scope.getFetchData = function(portCode) {
        

        var url = 'app/portMaster/getmulport?portNumber=' + portCode;
        $http.get(url).success(function(data) {
            $scope.portlist = data.mulPort;
               console.log("$scope.portlist");
               console.log($scope.portlist)
             

                
        });
    }
    $scope.FetchingValues = function(data) {
        console.log("viewwwwwwwwwwwwwwwwwwwwwwwww");
        console.log(data);
        $scope.portMaster.portCode  =    data.portCode;
        $scope.portMaster.mulPort  = $scope.getFetchData($scope.portMaster.portCode);
/*        console.log("$scope.portMaster.mulPort");
        console.log($scope.portMaster.mulPort)*/

        $scope.portMaster.portName =  data.portName;
        $scope.portMaster.countryId =     data.countryId ;
        $scope.portMaster.countryName = data.countryName ;
        $scope.portMaster.portDesc = data.portDesc ;
        $scope.portMaster.portEmail = data.portEmail ;
        $scope.portMaster.portStatus = data.portStatus ;
        $scope.portMaster.docksId = data.docksId ;
        $scope.portMaster.portType= data.portType ;
        $scope.portMaster.berthId = data.berthId ;
        $scope.portMaster.rtg = data.rtg ;
        $scope.portMaster.qgc = data.qgc ;
        $scope.portMaster.rmqc = data.rmqc ;
        $scope.portMaster.websiteAddress= data.websiteAddress ;
        $scope.portMaster.rmgc = data.rmgc ;
        $scope.portMaster.noOfCranes = data.noOfCranes ;
        $scope.portMaster.referPoints= data.referPoints ;
        $scope.portMaster.icd = data.icd ;
        $scope.portMaster.reachStack = data.reachStack ;
        $scope.portMaster.emptyHandlers = data.emptyHandlers ;
        $scope.portMaster.portIsoCode = data.portIsoCode ;
        $scope.portMaster.transFreeDays = data.transFreeDays ;
        $scope.portMaster.createdBy = data.createdBy ;
        $scope.portMaster.createdDate = data.createdDate ;
        $scope.portMaster.modifiedBy = data.modifiedBy ;
        $scope.portMaster.modifiedDate = data.modifiedDate ;

          
    }
    
    $scope.FetchingValues(sharedProperties.getObject());
console.log("show shared objects")
console.log(sharedProperties.getObject())
  
});
