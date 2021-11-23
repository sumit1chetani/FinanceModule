    'use strict';
    app.controller('staffnotificationListCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller,
    		$injector, sharedProperties, toaster, $rootScope, validationService , $stateParams) {

        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.itemsByPage = 10;
        $scope.isDelete = true;
        $scope.isUpload = true;
        $scope.staffNotification = {

                department : [],
                designation : [],
                division : [],
                grade : [],
                reporting : [],
                notificationContent : '',
                status : '',
                staffNotificationId:''

            }
        $scope.add = function() {
            $state.go("app.hr.staffnotification.add",{tenantid:$stateParams.tenantid});
        }
       /* $scope.editRow = function(permissionrequest) {
    		$location.url($stateParams.tenantid +'/hr/permissionReq/edit?permissionrequestid='
    				+ permissionrequest.permissionrequestid);
    	};*/
        $scope.editRow = function(staffNotificationDetailId) {
            $location.url($stateParams.tenantid+'/hr/staffnotification/edit?staffNotificationDetailId=' + staffNotificationDetailId);
        };

        $scope.getEducationNotificationList = function()

        {
            //$http.get('hr/employeeinfo/staffnotification/getstaffnotification').success(function(response) {
                $http.get($stateParams.tenantid+'/app/hr/staffnotification/getstaffnotification').success(function(response) {


                $scope.rowCollection = response.lstaffNotificationBeanDetail;
                console.log(response.educationnotificationList)
            })
        };
        $scope.getEducationNotificationList();
/*        $scope.deleteRow = function(eduNotificationId) {
            ngDialog.openConfirm().then(function() {
                $http.get("app/hrms/educationnotification/delete?eduNotificationId=" + eduNotificationId).success(function(response) {
                    // alert(JSON.stringify(response));
                    // alert(JSON.stringify(response.success));
                    if (response.success == true) {
                        logger.logSuccess("Deleted Succesfully!!!");
                        $http.get('hr/employeeinfo/staffnotification/getstaffnotification').success(function(response) {

                            $scope.rowCollection = response.lstaffNotificationBeanDetail;
                        })
                    }
                }).error(function(response) {
                    logger.logError("Error Please Try Again");
                });
            });
        };*/

        $scope.deleteRow = function(staffNotificationId,Index) {
            ngDialog.openConfirm().then(function() {
                $http.get($stateParams.tenantid+'/app/hr/staffnotification/deletestaffnotification?staffNotificationId=' + staffNotificationId).success(function(response) {

               // $http.get("hr/employeeinfo/staffnotification/deletestaffnotification?staffNotificationId=" + staffNotificationId).success(function(response) {
                    // alert(JSON.stringify(response));
                    // alert(JSON.stringify(response.success));
                    if (response.success == true) {
                        logger.logSuccess("Deleted Succesfully!!!");
                        $http.get('hr/employeeinfo/staffnotification/getstaffnotification').success(function(response) {
                            $scope.rowCollection = response.lstaffNotificationBeanDetail;
                        })
                    }
                }).error(function(response) {
                    logger.logError("Error Please Try Again");
                });
            });
        };
        
        $scope.Publishflag = function(staffNotificationId) {

            $http.get('hr/employeeinfo/staffnotification/publish?staffNotificationId=' + staffNotificationId).success(function(response) {
                if (response.success == true) {
                    logger.logSuccess("Published Successfully");
                    $scope.getEducationNotificationList();

                } else {
                    logger.logError("Sorry Some Error occurred");

                }
            });
        }
        $scope.unPublishflag = function(staffNotificationId) {

            $http.get('hr/employeeinfo/staffnotification/unpublish?staffNotificationId=' + staffNotificationId).success(function(response) {
                if (response.success == true) {
                    logger.logError("unPublished");
                    $scope.getEducationNotificationList();

                } else {
                    logger.logError("Sorry Some Error occurred");

                }
            });
        }
        $scope.Publish = function(staffNotificationId) {

            $http.get('hr/employeeinfo/staffnotification/publishstaffnotification?staffNotificationId=' + staffNotificationId).success(function(response) {
                if (response.success == true) {
                    logger.logSuccess("Published Successfully");
                    $scope.getEducationNotificationList();

                } else {
                    logger.logError("Sorry Some Error occurred");

                }
            });
        }

        /*
         * $scope.deleteRow = function(eduNotificationId, index) {
         * ngDialog.openConfirm().then(function(){ var myURL =
         * 'app/hrms/educationnotification/delete'; alert(eduNotificationId);
         * $http({ method : 'post', url : myURL, data : eduNotificationId,
         * }).success(function(data) { alert(JSON.stringify(data)); if (data !=
         * true) { var tableData = $scope.rowCollection;
         * $scope.rowCollection.splice(index, 1); logger.logSuccess("Deleted
         * successfully"); $state.reload(); } else { logger.logError("Unable To
         * delete this Record!"); } }).error(function(data) {
         * logger.logSuccess("Error in Delete!"); });
         *  }) }
         */
    });

    app.controller('staffNotification', function($scope, $stateParams, $timeout, $rootScope, $http, $location, logger, $log, $state, ngDialog, utilsService, $injector, sharedProperties, toaster, $controller, validationService) {

        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.isDelete = true;
        $scope.isUpload = true;
        $scope.numPages = 0;
        $scope.searchFlag = false;
        $scope.isAdd = true;
        $scope.getEducationNotificationList = function() {

            $http.get('app/hrms/educationnotification/staffNotification').success(function(response) {
                console.log("response")
                $scope.rowCollection = response.lstaffNotification;
            });
        };
        $scope.getEducationNotificationList();

    });