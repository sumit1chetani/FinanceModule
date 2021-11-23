'use strict';
app.controller('permissionapprovalcancellationCtrl', function($stateParams,$scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {

    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.isDisplay = true;
    $scope.numPages = 0

    $scope.edit = function() {
        $state.go('app.hr.permissionapprovalcancellation.add');
    };

    // Populate Grid
    $scope.getTranslationList = function() {
        $scope.dataLoopCount = 0;
        $scope.showEmptyLabel = false;
        $scope.from = 0;
        $scope.to = 100;
        $scope.rowCollection = [];
        var url = $stateParams.tenantid+'app/permissionrequestapproval/list?limit=' + $scope.from + '&offset=' + $scope.to;
        $http.get(url).success(function(data) {
            if (data.success == true) {
                $scope.rowCollection = $scope.rowCollection.concat(data.lPermissionApprovalCancellationBean);
            }
        });
    };

    $scope.getTranslationList();

    $scope.viewrecent = function() {
        $scope.dataLoopCount = 0;
        $scope.showEmptyLabel = false;
        $scope.from = 0;
        $scope.to = 100;
        $scope.rowCollection = [];
        var url = $stateParams.tenantid+'app/permissionrequestapproval/getrecentlist?limit=' + $scope.from + '&offset=' + $scope.to;
        $http.get(url).success(function(data) {
            if (data.success == true) {
                $scope.rowCollection = $scope.rowCollection.concat(data.lPermissionApprovalCancellationBean);
            }
        });
    }

    // Edit
    $scope.editRow = function(id) {
      //  $location.url('/hr/permissionapprovalcancellation/edit?id=' + id);
     	$location.url($stateParams.tenantid+'/hr/permissionapprovalcancellation/add?id='+ id); 

    }

    $scope.request = function() {
        $scope.getTranslationList();
    }

});

