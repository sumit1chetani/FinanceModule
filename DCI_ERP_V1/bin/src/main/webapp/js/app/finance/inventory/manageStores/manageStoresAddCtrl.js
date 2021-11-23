//define([ 'hospital/inventory/inventory' ], function(module) {

    'use strict';

    app.controller('manageStoresAddCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope,validationService) {
        
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages = 0;
        $scope.isEdit = false;
        $scope.manageStoresObj = {

            manageName       : '',
            address          : '',
            addressId        : '',
            locationId       : '',
            city             : '',
            cityId           : '',
            state            : '',
            zipCode          : '',
            country          : '',
            isActive         : '',
            parentLocation   : '',
            pid              : '',
            locationType     : '',
            lid              : '',
            locationIncharge : '',
            empId            : '',
            locationActivity : '',
            stockLocation    : '',
            scrapLocation    : '',
            isParentAddress  : '',
            addressTable:[]            
        }
        
        $('#parentAddress').show();
        $('#parentAddressReadonly').hide();
        
        $scope.validate = function(manageStoresAddForm,manageStoresObj) {
            if (new validationService().checkFormValidity($scope.manageStoresAddForm)) {
                if(!$scope.isEdit){
                    $scope.save(manageStoresAddForm,manageStoresObj);
                }
            } else {
                toaster.pop('error', "Please fill the required fields", 
                        logger.getErrorHtmlNew($scope.manageStoresAddForm.$validationSummary), 555000, 'trustedHtml');
            }
        };
        
        $scope.save = function(manageStoresAddForm,manageStoresObj) {
            $http.post("his/inventory/settings/managestores/save", $scope.manageStoresObj).success(function(response) {
                if (response.success == true) {
                    logger.logSuccess("Saved Successfully!");
                    $state.go('app.finance.asset.manage.managelocation.list');
                } else {
                    logger.logError(response.message);
                }
            });
        };
        
        $scope.checkStoreName = function(manageName){
            
            $http.get('his/inventory/settings/managestores/checkStoreName?manageName=' + manageName).success(function(datas) {
                
                if(datas!=0){
                    logger.logError('Store Name Already Exist!');
                    $scope.manageStoresObj.manageName = '';
                }
                
            }).error(function(datas) {
            });
            
        }
        
        $scope.cityList = [];
        $scope.stateList = [];
        $scope.parentLocationList = [];
        $scope.locationTypeList = [];
        $scope.inChargeList = [];

        $scope.cancel = function() {
            $state.go('app.finance.asset.manage.managelocation.list');
        };

        $http.get("his/inventory/settings/managestores/citylist").success(function(datas) {
            $scope.cityList = datas.cityList;
        });

        $http.get("his/inventory/settings/managestores/parentlocationlist").success(function(datas) {
            $scope.parentLocationList = datas.parentlocationList;
        });

        $http.get("his/inventory/settings/managestores/locationtypelist").success(function(datas) {
            $scope.locationTypeList = datas.locationtypeList;
        });

        $http.get("his/inventory/settings/managestores/inchargelist").success(function(datas) {
            $scope.inChargeList = datas.inchargeList;

        });

        $scope.stateList = function(cityId) {
            $http.post("his/inventory/settings/managestores/statelist", cityId).success(function(datas) {
                $scope.stateList = datas.stateList;

                $scope.manageStoresObj.zipCode = datas.stateList.zipCode;

                $http.get("his/inventory/settings/managestores/citylist").success(function(datas) {
                    $scope.cityList = datas.cityList;

                });
            });
        }

        $scope.country = function(cityId) {
            
            $http.post("his/inventory/settings/managestores/countrylist", cityId).success(function(datas) {
                $scope.manageStoresObj.country = datas.countryList[0].country;
                $scope.manageStoresObj.state = datas.countryList[0].state;
                $scope.manageStoresObj.zipCode = datas.countryList[0].zipCode;
            });
        }

        $scope.reset = function() {
            
            $scope.manageStoresObj.manageName='';
            $scope.manageStoresObj.address='';
            $scope.manageStoresObj.addressId='';
            $scope.manageStoresObj.locationId='';
            $scope.manageStoresObj.city='';
            $scope.manageStoresObj.cityId='';
            $scope.manageStoresObj.state='';
            $scope.manageStoresObj.zipCode='';
            $scope.manageStoresObj.country='';
            $scope.manageStoresObj.isActive='';
            $scope.manageStoresObj.parentLocation='';
            $scope.manageStoresObj.pid='';            
            $scope.manageStoresObj.locationType='';
            $scope.manageStoresObj.lid='';
            $scope.manageStoresObj.locationIncharge='';
            $scope.manageStoresObj.empId='';
            $scope.manageStoresObj.locationActivity='';
            $scope.manageStoresObj.stockLocation='';
            $scope.manageStoresObj.scrapLocation='';
            $scope.manageStoresObj.isParentAddress='';
            
        };
        
        $scope.getParentAddress=function(isParentAddress,pid){
            
            if(isParentAddress=='t'){
                
                if(pid==""){
                    logger.logError("Please Select Store Parent Location");
                    $('#parentAddress').show();
                    $('#parentAddressReadonly').hide();
                    $scope.manageStoresObj.isParentAddress='N';
                    
                }else{
                    
                    $('#parentAddress').hide();
                    $('#parentAddressReadonly').show();
                    
                    $http.post("his/inventory/settings/managestores/parentAddress", pid).success(function(datas) {
                      
                        $scope.manageStoresObj.country = datas.parentAddressList[0].country;
                        $scope.manageStoresObj.state = datas.parentAddressList[0].state;
                        $scope.manageStoresObj.zipCode = datas.parentAddressList[0].zipCode;
                        $scope.manageStoresObj.address = datas.parentAddressList[0].address;
                        $scope.manageStoresObj.cityId = datas.parentAddressList[0].cityId;
                        $scope.manageStoresObj.city = datas.parentAddressList[0].city;
                        
                    });
                    
                }
                
            }else{
                $('#parentAddress').show();
                $('#parentAddressReadonly').hide();
                
                $scope.manageStoresObj.country = '';
                $scope.manageStoresObj.state = '';
                $scope.manageStoresObj.zipCode = '';
                $scope.manageStoresObj.address = '';
                $scope.manageStoresObj.cityId = '';
                $scope.manageStoresObj.city = '';
                $scope.manageStoresObj.isParentAddress='N';
                
            }
        }

    });
    
    app.controller('manageStoresEditCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope,validationService) {
        
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages = 0;
        $scope.isEdit = true;
        $scope.manageStoresObj = {

            manageName       : '',
            address          : '',
            addressId        : '',
            locationId       : '',
            city             : '',
            cityId           : '',
            state            : '',
            zipCode          : '',
            country          : '',
            isActive         : '',
            parentLocation   : '',
            pid              : '',
            locationType     : '',
            lid              : '',
            locationIncharge : '',
            empId            : '',
            locationActivity : '',
            stockLocation    : '',
            scrapLocation    : '',
            isParentAddress  : '',
            addressTable:[]            
        }
        
        $('#parentAddress').show();
        $('#parentAddressReadonly').hide();
        
        $scope.validate = function(manageStoresAddForm,manageStoresObj) {
            if (new validationService().checkFormValidity($scope.manageStoresAddForm)) {
                if($scope.isEdit){
                    $scope.update(manageStoresAddForm,manageStoresObj);
                }
            } else {
                toaster.pop('error', "Please fill the required fields", 
                        logger.getErrorHtmlNew($scope.manageStoresAddForm.$validationSummary), 555000, 'trustedHtml');
            }
        };
        
        $scope.update = function(manageStoresAddForm,manageStoresObj) {
            $http.post("his/inventory/settings/managestores/update", $scope.manageStoresObj).success(function(response) {
                if (response.success == true) {
                    logger.logSuccess("Updated Successfully!");
                    $scope.cancel();
                } else {
                    logger.logError(response.message);
                }
            });
        };
        
        var locationId = $location.search().locationId;
        if (locationId != '') {
            $http.post("his/inventory/settings/managestores/edit", locationId).success(function(response) {
                if (response) {
                    
                    $scope.manageStoresObj.pid = parseInt(response.editList[0].pid);
                    $scope.manageStoresObj.manageName = response.editList[0].manageName;
                    $scope.manageStoresObj.address = response.editList[0].address;
                    $scope.manageStoresObj.addressId = response.editList[0].addressId;
                    $scope.manageStoresObj.locationId = response.editList[0].locationId;
                    $scope.manageStoresObj.city = response.editList[0].city;
                    $scope.manageStoresObj.cityId = response.editList[0].cityId;
                    $scope.manageStoresObj.state = response.editList[0].state;
                    $scope.manageStoresObj.zipCode = response.editList[0].zipCode;
                    $scope.manageStoresObj.country = response.editList[0].country;
                    $scope.manageStoresObj.parentLocation = response.editList[0].parentLocation;
                    $scope.manageStoresObj.locationType = response.editList[0].locationType;
                    $scope.manageStoresObj.lid = response.editList[0].lid;
                    $scope.manageStoresObj.locationIncharge = response.editList[0].locationIncharge;
                    $scope.manageStoresObj.isActive = response.editList[0].isActive;                    
                    $scope.manageStoresObj.empId = response.editList[0].empId;
                    $scope.manageStoresObj.locationActivity = response.editList[0].locationActivity;
                    $scope.manageStoresObj.stockLocation = response.editList[0].stockLocation;
                    $scope.manageStoresObj.scrapLocation = response.editList[0].scrapLocation;
                    $scope.manageStoresObj.isParentAddress = response.editList[0].isParentAddress;
                    
                    if(response.editList[0].isParentAddress=='t'){
                        $('#parentAddress').hide();
                        $('#parentAddressReadonly').show();
                    }else{
                        $('#parentAddress').show();
                        $('#parentAddressReadonly').hide();
                    }
                    
                } else if (response.message != '') {
                    logger.logError(response.message);
                }

            });
        }

        $scope.cityList = [];
        $scope.stateList = [];
        $scope.parentLocationList = [];
        $scope.locationTypeList = [];
        $scope.inChargeList = [];

        $scope.cancel = function() {
            $state.go("app.finance.inventory.manageStores.list");
        };

        $http.get("his/inventory/settings/managestores/citylist").success(function(datas) {
            $scope.cityList = datas.cityList;

        });

        $http.get("his/inventory/settings/managestores/parentlocationlist").success(function(datas) {
            $scope.parentLocationList = datas.parentlocationList;
        });

        $http.get("his/inventory/settings/managestores/locationtypelist").success(function(datas) {
            $scope.locationTypeList = datas.locationtypeList;
        });

        $http.get("his/inventory/settings/managestores/inchargelist").success(function(datas) {
            $scope.inChargeList = datas.inchargeList;

        });

        $scope.stateList = function(cityId) {
            $http.post("his/inventory/settings/managestores/statelist", cityId).success(function(datas) {
                $scope.stateList = datas.stateList;

                $scope.manageStoresObj.zipCode = datas.stateList.zipCode;

                $http.get("his/inventory/settings/managestores/citylist").success(function(datas) {
                    $scope.cityList = datas.cityList;

                });
            });
        }

        $scope.country = function(cityId) {
            
            $http.post("his/inventory/settings/managestores/countrylist", cityId).success(function(datas) {
                $scope.manageStoresObj.country = datas.countryList[0].country;
                $scope.manageStoresObj.state = datas.countryList[0].state;
                $scope.manageStoresObj.zipCode = datas.countryList[0].zipCode;
            });
        }

        $scope.reset = function() {
            $http.post("his/inventory/settings/managestores/edit", locationId).success(function(response) {
                if (response) {
                    
                    $scope.manageStoresObj.pid = parseInt(response.editList[0].pid);
                    $scope.manageStoresObj.manageName = response.editList[0].manageName;
                    $scope.manageStoresObj.address = response.editList[0].address;
                    $scope.manageStoresObj.addressId = response.editList[0].addressId;
                    $scope.manageStoresObj.locationId = response.editList[0].locationId;
                    $scope.manageStoresObj.city = response.editList[0].city;
                    $scope.manageStoresObj.cityId = response.editList[0].cityId;
                    $scope.manageStoresObj.state = response.editList[0].state;
                    $scope.manageStoresObj.zipCode = response.editList[0].zipCode;
                    $scope.manageStoresObj.country = response.editList[0].country;
                    $scope.manageStoresObj.parentLocation = response.editList[0].parentLocation;
                    $scope.manageStoresObj.locationType = response.editList[0].locationType;
                    $scope.manageStoresObj.lid = response.editList[0].lid;
                    $scope.manageStoresObj.locationIncharge = response.editList[0].locationIncharge;
                    $scope.manageStoresObj.isActive = response.editList[0].isActive;                    
                    $scope.manageStoresObj.empId = response.editList[0].empId;
                    $scope.manageStoresObj.locationActivity = response.editList[0].locationActivity;
                    $scope.manageStoresObj.stockLocation = response.editList[0].stockLocation;
                    $scope.manageStoresObj.scrapLocation = response.editList[0].scrapLocation;
                    $scope.manageStoresObj.isParentAddress = response.editList[0].isParentAddress;
                    
                    if(response.editList[0].isParentAddress=='t'){
                        $('#parentAddress').hide();
                        $('#parentAddressReadonly').show();
                    }else{
                        $('#parentAddress').show();
                        $('#parentAddressReadonly').hide();
                    }
                    
                } else if (response.message != '') {
                    logger.logError(response.message);
                }

            });
        };
        
        $scope.getParentAddress=function(isParentAddress,pid){
            
            if(isParentAddress=='t'){
                
                if(pid==""){
                    logger.logError("Please Select Store Parent Location");
                    $('#parentAddress').show();
                    $('#parentAddressReadonly').hide();
                    $scope.manageStoresObj.isParentAddress='N';
                    
                }else{
                    
                    $('#parentAddress').hide();
                    $('#parentAddressReadonly').show();
                    
                    $http.post("his/inventory/settings/managestores/parentAddress", pid).success(function(datas) {
                      
                        $scope.manageStoresObj.country = datas.parentAddressList[0].country;
                        $scope.manageStoresObj.state = datas.parentAddressList[0].state;
                        $scope.manageStoresObj.zipCode = datas.parentAddressList[0].zipCode;
                        $scope.manageStoresObj.address = datas.parentAddressList[0].address;
                        $scope.manageStoresObj.cityId = datas.parentAddressList[0].cityId;
                        $scope.manageStoresObj.city = datas.parentAddressList[0].city;
                        
                    });
                    
                }
                
            }else{
                $('#parentAddress').show();
                $('#parentAddressReadonly').hide();
                
                $scope.manageStoresObj.country = '';
                $scope.manageStoresObj.state = '';
                $scope.manageStoresObj.zipCode = '';
                $scope.manageStoresObj.address = '';
                $scope.manageStoresObj.cityId = '';
                $scope.manageStoresObj.city = '';
                $scope.manageStoresObj.isParentAddress='N';
                
            }
        }

        $scope.checkStoreName = function(manageName){
            
            $http.get('his/inventory/settings/managestores/checkStoreName?manageName=' + manageName).success(function(datas) {
                
                if(datas!=0){
                    logger.logError('Store Name Already Exist!');
                    $scope.manageStoresObj.manageName = '';
                }
                
            }).error(function(datas) {
            });
            
        }

    });

//});