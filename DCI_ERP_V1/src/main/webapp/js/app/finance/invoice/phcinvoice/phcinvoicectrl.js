app.controller('phcinvoiceCtrl', function($scope, $stateParams, $window, $rootScope, $location, $http, logger, $log, ngDialog, $modal, utilsService, $state) {

    $scope.dataLoopCount = 0;
    $scope.from = 0;
    $scope.to = 100;
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;

    $scope.getList = function() {
        var url = 'phcinvoice/list';

        $http.get(url).success(function(data) {

            $scope.rowCollection = $scope.rowCollection.concat(data.phcList);
            console.log(data.phcList);
            sharedProperties.setObject($scope.emptyObject);

            $scope.showEmptyLabel = $scope.rowCollection.length == 0 ? true : false;
            console.log($scope.showEmptyLabel);
        }).error(function(data) {

            logger.logError("Please Try Again");
        });

    }

    $scope.getList();

    $scope.add = function() {
        $state.go('app.finance.invoice.PHCInvoice.add');
    }

    $scope.edit = function(obj) {
        /*
         * $rootScope.editValue=edit;
         * $state.go('app.commercial.bunkerRate.edit');
         */
        $location.url('');

    }

})

app.controller('phcinvoiceCtrlAdd', function($scope, $window, $rootScope, $location, $filter, $http, logger, $log, ngDialog, $modal, utilsService, $stateParams) {
    $scope.currentURL=$location.protocol() + '://'+ $location.host() +':'+  $location.port()+"/#" +$location.path();
    if(window.localStorage.getItem('phciv')==$scope.currentURL){
        alert('window ' + $scope.currentURL + ' is already opened');
       // window.focus();
        setTimeout(window.close(),5000);
    }else{
        window.localStorage.setItem('phciv', $scope.currentURL);
    }
    $(window).unload(function(){
        localStorage.removeItem('phciv');
        });

    $scope.phcinvoice = {

        customerName : '',
        voyageName : '',
        pot : '',
        blNo : '',
        pol : '',
        mlo : '',
        vesselName : '',
        pod : '',
    }

    $scope.onLoadDropDown = function() {
        $http.get('app/purchaseinvoice/getCompanyList').success(function(datas) {

            $scope.companyList = datas;
        }).error(function(datas) {
        });

        $http.get('app/generalinvoice/getVesselList').success(function(datas) {

            $scope.vesselList = datas;
        }).error(function(datas) {
        });

    }

    $scope.onLoadDropDown();

    var generalObj = angular.copy($scope.phcinvoice, generalObj);
    var listVariable = Object.keys(generalObj);

    $scope.$watchCollection('phcinvoice', function(newVal, oldVal) {
        if (newVal != undefined) {
            var userSelected = $scope.getValueForSelect(listVariable, newVal, oldVal);
            if (angular.isDefined(userSelected)) {
                $scope.selectedDropDown(userSelected);
            }
        }
    }, true);

    $scope.getValueForSelect = function(listVariable, newValObj, oldValObj) {
        var singleDeclaredvariable = null;
        angular.forEach(listVariable, function(value) {
            if (newValObj[value] != oldValObj[value])
                singleDeclaredvariable = value;
        });
        return singleDeclaredvariable;
    }

    $scope.selectedDropDown = function(userSelected) {
        switch (userSelected) {
        case 'vesselName':
            $http.get('app/generalinvoice/getVoyageList?vesselCode=' + $scope.phcinvoice.vesselName).success(function(datas) {

                $scope.voyageList = datas;
            }).error(function(datas) {
            });
            break;
        case 'voyageName':

            var url = 'phcinvoice/getPolList?voyageName=' + $scope.phcinvoice.voyageName;

            $http.get(url).success(function(datas) {
                var lport = [];
                angular.forEach(datas.polList, function(item, key) {
                    var portListObj = new Object();
                    portListObj.id = datas.polList[key].id;
                    portListObj.text = datas.polList[key].text;
                    if (portListObj.id != " ")
                        lport.push(portListObj);
                  
                });
                $scope.portList = lport;

            }).error(function(datas) {
            });
            break;
        case 'pol':
            
            var getPolData ={
                       'vessel' :  $scope.phcinvoice.vesselName,
                       'voyage' : $scope.phcinvoice.voyageName,
                       'pol' : $scope.phcinvoice.pol,
               }
               
             $http.post('phcinvoice/getMloList', getPolData).success(function(datas) {
               var lmlo=[];
               var lbl=[];
               angular.forEach(datas.mloList,function(item,key){
                   var mloListObj = new Object();
                   var blListObj =new Object();
                   mloListObj.id=datas.mloList[key].mlo;
                   mloListObj.text=datas.mloList[key].mloName;
                   blListObj.id=datas.mloList[key].blNo;
                   blListObj.text=datas.mloList[key].blNo;
                    if (mloListObj.id != " ")
                        lmlo.push(mloListObj);
                    
                    if(blListObj.id!= " ")
                        lbl.push(blListObj);
                    
                    $scope.mloList = lmlo;
                    $scope.blList =lbl ;


               })
           }).error(function(datas) {

           });
            
            break;
        case 'mlo':
           
               
       

           $http.get('phcinvoice/getCustomer?mloCode='+$scope.phcinvoice.mlo ).then(function(data){
               var lpayer=[];
              
               angular.forEach(data.data.customerList,function(item,key){
                   var payerListObj = new Object();
                   payerListObj.id = data.data.customerList[key].id;
                   payerListObj.text = data.data.customerList[key].text;
                   
                   lpayer.push(payerListObj);
               })
               
               $scope.customerList=lpayer;
           })
       }
   }

})
