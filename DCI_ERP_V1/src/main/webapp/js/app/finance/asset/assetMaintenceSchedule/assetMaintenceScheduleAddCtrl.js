define([ 'hospital/asset/asset' ], function(module) {

    'use strict';

    module.registerController('assetMaintenceScheduleAddCtrl', function($scope,$filter, $state, $http, $location, sharedProperties, toaster, $injector, logger, ngDialog, $rootScope, $controller,validationService) {
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages = 0
        $scope.isEdit = false;
        $scope.isDisplay = true;
        var globalIndex = 1;
        $scope.cancel = function() {
            $state.go("app.hospital.asset.assetMaintenceSchedule.list");
        };
        
        $scope.assetMaintenanceObj = {
            itemId : '',
            sitemCategoryId : '',
            assetTrackList:[],
            assetMaintenaceProp : []
        };
        $scope.ItemList = [];
        $scope.getItemDetails = function() {
            $http.get("hospital/asset/assetmaintenanceContract/getDropDownList").success(function(response) {
                $scope.ItemList = response.alItemList;
            });
        }
        $scope.getItemDetails();

        
        $scope.getAsstSchedule = function() {
            $http.get('hospital/asset/assetmaintenanceschedule/List').success(function(data) {
                if (data.success) {
                    $scope.checkItemExistorNotList = data.liasstMaintenaceSchedule;
               } else {
                    logger.logError("Error Please Try Again");
                }
            }).error(function(data) {
                
            });
        };

       $scope.getAsstSchedule();
        
   
        $scope.itemCategory = function() {
            if ($scope.assetMaintenanceObj.itemId != "") {
                var checkexist=true;
                /*angular.forEach($scope.checkItemExistorNotList, function(value, key) {
                    if ($scope.assetMaintenanceObj.itemId === value.itemId) {
                        checkexist=false  
                    }
                });
                */
                if(checkexist){
                    angular.forEach($scope.ItemList, function(value, key) {
                        if ($scope.assetMaintenanceObj.itemId === value.id) {
                            $scope.assetMaintenanceObj.itemCategoryId = value.itemCategoryName;
                            $scope.getAssetTrackDetails($scope.assetMaintenanceObj.itemId);
                        }
                    });
                }else{
                    logger.logError("Item Already Scheduled ");
                    $('#itemId').val('')
                    $scope.rowCollection = [];
                }
               
            } else {
                $scope.assetMaintenanceObj.itemId = "";
                $scope.rowCollection = [];
            }
        };

        $scope.$watch('assetMaintenanceObj.itemId', function(newValue, oldValue) {
            if (newValue != "" && newValue !=undefined) {
                $scope.itemCategory();
            } else {
                $('#itemId').val()
            }
        });

        $scope.getAssetTrackDetails = function(itemId) {
            var url = 'hospital/asset/assetmaintenanceschedule/assetTrackDetails?itemId=' +itemId;
            $http.get(url).success(function(data) {
                if (data.success) {
                    $scope.assetTrackrowCollection = data.lAssetTrack;
                    } else {
                    logger.log(data.errors);
                    $scope.assetTrackrowCollection = [];
                }

            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        };

        $scope.addNew = function() {
            $scope.callDialog($scope, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope,$filter);
        };

        $scope.addNew1 = function() {
            $scope.assetMaintenanceObj.assetTrackList=[];
            $scope.callDialog1($scope, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope);
        };

        $scope.callDialog = function($scope, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope,$filter) {
            ngDialog.open({
                scope : $scope,
                template : 'views/hospital/asset/assetMaintenceSchedule/assetMaintenceScheduleProperty',
                controller : $controller('assetMaintenceScheduleAddScheduleCtrl', {
                    $scope : $scope,
                    $http : $http,
                    $filter :$filter,
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
                preCloseCallback : $scope.getList
            });

        }
        $scope.callDialog1 = function($scope, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope) {
            ngDialog.open({
                scope : $scope,
                template : 'views/hospital/asset/assetMaintenceSchedule/assetMaintenanceScheduleTrackProperty',
                controller : $controller('assetMaintenceScheduleAddTrackScheduleCtrl', {
                    $scope : $scope,
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
                preCloseCallback : $scope.getList
            });

        }
        
        $scope.submit = function(assetMaintenanceObj) {
            if (new validationService().checkFormValidity($scope.assetmaintenaceScheduleForm)) {
                    $scope.save(assetMaintenanceObj);
            } else {
                toaster.pop('error', "Please fill the required fields", 
                        logger.getErrorHtmlNew($scope.assetmaintenaceScheduleForm.$validationSummary), 555000, 'trustedHtml');
            }
        };
        
        $scope.save=function(assetMaintenanceObj){
            var jsonData={
                    'itemId':assetMaintenanceObj.itemId,
                    'assetProp':assetMaintenanceObj.assetMaintenaceProp,
                    'listAssetTrackDetails':assetMaintenanceObj.assetTrackList[0],
            }
            console.log(assetMaintenanceObj);
            var myURL = 'hospital/asset/assetmaintenanceschedule/save';
            $http({
                url : myURL,
                data : jsonData,
                method : 'post',
                dataType : 'json',
                headers : {
                    'Accept' : 'application/json',
                    'Content-Type' : 'application/json'
                }
            }).success(function(data) {
                if (!data) {
                    logger.logError(" Error Not Saved!");
                } else {
                    logger.logSuccess("Saved!");
                    $state.go("app.hospital.asset.assetMaintenceSchedule.list");
                }

            }).error(function(data) {

            });
        }

    });

    module.registerController('assetMaintenceScheduleAddScheduleCtrl', function($scope,$filter, $state, $http, $location, sharedProperties, toaster, $injector, logger, ngDialog, $rootScope, $controller) {

        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        
        var assetTrackExist=$scope.assetMaintenanceObj.assetMaintenaceProp;
        console.log(assetTrackExist);
        $scope.itemsByPage = 10;
        $scope.numPages = 0;

        
        $scope.assetMaintenanceSchedule = {
            maintenanceType : '',
            maintenanceName:'',
            usage : '',
            days:'',
            frequency : '',
            maintenanceScheduleDate : ''
        }
        
        $scope.assetMaintenanceSchedule.usage=1;
        $scope.getMaintenanceDetails = function() {
            $http.get("hospital/asset/assetmaintenanceschedule/assetMaintenanceList").success(function(response) {
                console.log(response);
                $scope.maintenaceList = response.alMaintenaceList;
            });
        }
        $scope.getMaintenanceDetails();
        
        $scope.saveAssetTrackMaintenaceDetails = function(assetMaintenanceSchedule,maintenaceList) {
            
            var obj=$filter('filter')($scope.maintenaceList,{
                id:assetMaintenanceSchedule.maintenanceType
            });
            assetMaintenanceSchedule.maintenanceName=obj[0].text;
            
            $scope.assetMaintenanceObj.assetMaintenaceProp.push(assetMaintenanceSchedule);
            ngDialog.close();
        }
        
        $scope.ngcancel = function() {
            ngDialog.close();
        }


    });

    module.registerController('assetMaintenceScheduleAddTrackScheduleCtrl', function($scope, $state, $http, $location, sharedProperties, toaster, $injector, logger, ngDialog, $rootScope, $controller) {

        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection2 = [];
        $scope.displayedCollection2 = [];
        $scope.itemsByPage = 10;
        $scope.numPages = 0;

        $scope.ngcancel = function() {
            ngDialog.close();
        }
        
       
       
       $scope.assetTrackDEtailList=$scope.assetTrackrowCollection;
       
       $scope.addAssetTrackDetails = function(assetTrackList) {
           $scope.assetMaintenanceObj.assetTrackList.push(assetTrackList);
           ngDialog.close();
       }
    });

});