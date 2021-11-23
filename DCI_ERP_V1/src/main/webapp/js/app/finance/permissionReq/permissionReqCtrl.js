'use strict';
app.controller('permissionReqCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope,$stateParams) {
	$scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.numPages = 0;
    $scope.isDelete = true;
    $scope.isUpload = true;

    $scope.permissionRequestData = {
        permissiondate : '',
        hoursfrom : '',
        hoursto : '',
        reason : '',
        permissionrequestid : '',
        userId : '',
        userName : '',
        edit : false
    };

    $scope.add = function() {
        $state.go('app.hr.permissionReq.add');

    };

    // Populate Grid
    $scope.getTranslationList = function() {
        $scope.dataLoopCount = 0;
        $scope.showEmptyLabel = false;
        $scope.from = 0;
        $scope.to = 100;
        $scope.rowCollection = [];
        var url = $stateParams.tenantid+'app/permissionrequest/list?limit=' + $scope.from + '&offset=' + $scope.to;
        $http.get(url).success(function(data) {
            if (data.success == true) {
                $scope.rowCollection = $scope.rowCollection.concat(data.lpermissionRequestBean);
            }
        });
    };

    $scope.getTranslationList();

    // Edit
    $scope.editRow = function(permissionrequest) {
		$location.url($stateParams.tenantid +'/hr/permissionReq/edit?permissionrequestid='
				+ permissionrequest.permissionrequestid);
	};
    
    
    /*$scope.editRow = function(permissionrequest) {
       // $location.url($stateParams.tenantid+'/hr/permissionReq/edit');

        if (permissionrequest.status != "Cancelled" && permissionrequest.status != "Approved") {
        	$location.url($stateParams.tenantid +'/hr/permissionReq/add?permissionrequestid='
    				+ permissionrequest.permissionrequestid);
        	
        	} else if (permissionrequest.status == "Approved") {
            logger.logError("Cannot Edit This Approved Permission Request");
        } else if (permissionrequest.status == "Cancelled") {
            logger.logError("Cannot Edit This Cancelled Permission Request");
        }
    }*/

    /*$scope.callDialog = function($scope, permissionrequestid, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope) {
        ngDialog.open({
            scope : $scope,
            template : 'views/hr/permissionreq/PermissionReqAdd',
            controller : $controller('PermissionReqAddCtrl', {
                $scope : $scope,
                permissionrequestid : permissionrequestid,
                $http : $http,
                ngDialog : ngDialog,
                logger : logger,
                $injector : $injector,
                sharedProperties : sharedProperties,
                toaster : toaster,
                $rootScope : $rootScope
            }),
            className : 'ngdialog-theme-plain',
            showClose : false,
            closeByDocument : false,
            closeByEscape : false,
            preCloseCallback : $scope.getTranslationList
        });
    }*/

    // Delete
    $scope.deleteRow = function(permissionrequest, index) {
        ngDialog.openConfirm().then(function() {
            var myURL = $stateParams.tenantid+'app/permissionrequest/delete';
            if (permissionrequest.status != "Cancelled" && permissionrequest.status != "Approved") {
                $http({
                    url : myURL,
                    data : permissionrequest.permissionrequestid,
                    method : 'post',
                    dataType : 'json',
                    headers : {
                        'Accept' : 'application/json',
                        'Content-Type' : 'application/json'
                    }
                }).success(function(data) {
                    if (data == true) {
                        var tableData = $scope.rowCollection;
                        $scope.rowCollection.splice(index, 1);
                        logger.logSuccess("PermissionRequest  Deleted Successfully");
                    } else {
                        logger.logSuccess("Error in Delete PermissionRequest!");
                    }
                }).error(function(data) {
                    logger.logSuccess("Error in Delete PermissionRequest!");
                })
            } else if (permissionrequest.status == "Approved") {
                logger.logError("Cannot Delete This Approved Permission Request");
            } else if (permissionrequest.status == "Cancelled") {
                logger.logError("Cannot Delete This Cancelled Permission Request");
            }
        });
    };
});