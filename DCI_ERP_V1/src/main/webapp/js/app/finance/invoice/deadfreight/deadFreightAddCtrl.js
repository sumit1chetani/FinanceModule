app.controller('deadFreightCtrl', function($scope, $stateParams, $window, $rootScope, $location, $http, logger, $log, ngDialog, $modal, utilsService, $state,$stateParams) {

});

app.controller('deadFreightAddCtrl', function($scope, $window, $rootScope, $location, $filter, $http, logger, $log, ngDialog, $modal, utilsService, ListService, $stateParams) {
    $scope.deadfreight = {
        customerName : '',
        dfQuotationNo : '',
        vesselName : '',
        slotName : '',
        voyageName : '',

    }

    $scope.onLoadDropdown = function() {

        $scope.dataList = ListService.getCustomerList();
        $scope.dataList.then(function(customerLists) {
            $scope.customerList = customerLists;
        });

        $scope.dataList = ListService.getVesselList();
        $scope.dataList.then(function(customerLists) {
            $scope.vesselList = customerLists;
        })

        $scope.dataList = ListService.getSlotList();
        $scope.dataList.then(function(slotLists) {
            $scope.slotList = slotLists;
        })

    }
    // onload dropdown
    $scope.onLoadDropdown();

 

})

app.service("ListService", function($http, $q,$stateParams) {

    this.getCustomerList = function() {
        var customerList = $q.defer();

        $http.get($stateParams.tenantid+'deadfreight/getCustomerList').success(function(data) {

            customerList.resolve(data.customerList);

        }).error(function(data) {

            customerList.reject("failed to get customer List");
        });

        return customerList.promise;

    }

    this.getVesselList = function() {
        var vesselList = $q.defer();
        $http.get($stateParams.tenantid+'deadfreight/getVesselList').success(function(data) {
            vesselList.resolve(data.vesselList);

        }).error(function(data) {
            vesselList.reject("failed to get vessel List");
        });
        return vesselList.promise;
    }

    this.getSlotList = function() {
        var slotList = $q.defer();
        $http.get($stateParams.tenantid+'deadfreight/getSlotList').success(function(data) {
            slotList.resolve(data.slotList);

        }).error(function(data) {
            slotList.reject("failed to get slot List");
        });
        return slotList.promise;
    }

 /*   this.getVoyageList = function(vesselCode) {
        var voyageList = $q.defer();
        $http.get('app/generalinvoice/getVoyageList?vesselCode=' + vesselCode).success(function(data) {
            voyageList.resolve(data);

        }).error(function(data) {

            voyageList.reject("Failed to get Voyage Vessel List");

        });
        return voyageList.promise;
    }
*/
})