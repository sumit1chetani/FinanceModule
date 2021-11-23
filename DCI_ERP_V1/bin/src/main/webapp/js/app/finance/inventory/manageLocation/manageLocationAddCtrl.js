//define([ 'hospital/inventory/inventory' ], function(module) {

    'use strict';

    app.controller('manageLocationAddCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService) {

        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages = 0;
        $scope.isEdit = false;
        $scope.manageLocationObj = {

            manageName : '',
            address : '',
            addressId : '',
            locationId : '',
            city : '',
            cityId : '',
            state : '',
            zipCode : '',
            country : '',
            isActive : '',
            parentLocation : '',
            pid : '',
            locationType : '',
            lid : '',
            locationIncharge : '',
            empId : '',
            locationActivity : '',
            stockLocation : '',
            scrapLocation : '',
            isParentAddress : '',
            addressTable : []
        }

        $('#parentAddress').show();
        $('#parentAddressReadonly').hide();

        $scope.validate = function(manageLocationAddForm, manageLocationObj) {
            if (new validationService().checkFormValidity($scope.manageLocationAddForm)) {
                if (!$scope.isEdit) {
                    $scope.save(manageLocationAddForm, manageLocationObj);
                }
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.manageLocationAddForm.$validationSummary), 555000, 'trustedHtml');
            }
        };

        $scope.save = function(manageLocationAddForm, manageLocationObj) {
            $http.post("his/inventory/settings/managelocation/save", $scope.manageLocationObj).success(function(response) {
                if (response.success == true) {
                    logger.logSuccess("Saved Successfully!");
                    $state.go('app.finance.inventory.managelocation.list');
                } else {
                    logger.logError(response.message);
                }
            });
        };

        function toUpper(mystring) {
            var sp = mystring.split(' ');
            var wl = 0;
            var f, r;
            var word = new Array();
            for (var i = 0; i < sp.length; i++) {
                f = sp[i].charAt(0).toUpperCase();
                r = sp[i].slice(1).toLowerCase();
                word[i] = f + r;
            }
            var newstring = word.join(' ');
            return newstring;
        }

        $scope.checkLocationName = function(manageName) {

            var manageNam = manageName;
            manageNam = manageNam.replace(/ {2,}/g, ' ');
            var manageName = toUpper(manageNam);
            $scope.manageLocationObj.manageName = manageName;

            $http.get('his/inventory/settings/managelocation/checkLocationName?manageName=' + manageName).success(function(datas) {

                if (datas != 0) {
                    logger.logError('Asset Location Already Exist!');
                    $scope.manageLocationObj.manageName = '';
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
            $state.go("app.finance.asset.manage.managelocation.list");
        };

        $http.get("his/inventory/settings/managelocation/citylist").success(function(datas) {
            $scope.cityList = datas.cityList;

        });

        $http.get("his/inventory/settings/managelocation/parentlocationlist").success(function(datas) {
            $scope.parentLocationList = datas.parentlocationList;
        });

        $http.get("his/inventory/settings/managelocation/locationtypelist").success(function(datas) {
            $scope.locationTypeList = datas.locationtypeList;
        });

        $http.get("his/inventory/settings/managelocation/inchargelist").success(function(datas) {
            $scope.inChargeList = datas.inchargeList;

        });

        $scope.stateList = function(cityId) {
            $http.post("his/inventory/settings/managelocation/statelist", cityId).success(function(datas) {
                $scope.stateList = datas.stateList;
                $scope.manageLocationObj.zipCode = datas.stateList.zipCode;
                $http.get("his/inventory/settings/managelocation/citylist").success(function(datas) {
                    $scope.cityList = datas.cityList;
                });
            });
        }

        $scope.country = function(cityId) {
            $http.post("his/inventory/settings/managelocation/countrylist", cityId).success(function(datas) {
                $scope.manageLocationObj.country = datas.countryList[0].country;
                $scope.manageLocationObj.state = datas.countryList[0].state;
                $scope.manageLocationObj.zipCode = datas.countryList[0].zipCode;
            });
        }

        $scope.reset = function() {

            $scope.manageLocationObj.manageName = '';
            $scope.manageLocationObj.address = '';
            $scope.manageLocationObj.addressId = '';
            $scope.manageLocationObj.locationId = '';
            $scope.manageLocationObj.city = '';
            $scope.manageLocationObj.cityId = '';
            $scope.manageLocationObj.state = '';
            $scope.manageLocationObj.zipCode = '';
            $scope.manageLocationObj.country = '';
            $scope.manageLocationObj.isActive = '';
            $scope.manageLocationObj.parentLocation = '';
            $scope.manageLocationObj.pid = '';
            $scope.manageLocationObj.locationType = '';
            $scope.manageLocationObj.lid = '';
            $scope.manageLocationObj.locationIncharge = '';
            $scope.manageLocationObj.empId = '';
            $scope.manageLocationObj.locationActivity = '';
            $scope.manageLocationObj.stockLocation = '';
            $scope.manageLocationObj.scrapLocation = '';
            $scope.manageLocationObj.isParentAddress = '';

        };

        $scope.getParentAddress = function(isParentAddress, pid) {
            if (isParentAddress == 't') {
                if (pid == "") {
                    logger.logError("Please Select Asset Parent Location");
                    $('#parentAddress').show();
                    $('#parentAddressReadonly').hide();
                    $scope.manageLocationObj.isParentAddress = 'N';
                } else {
                    $('#parentAddress').hide();
                    $('#parentAddressReadonly').show();

                    $http.post("his/inventory/settings/managelocation/parentAddress", pid).success(function(datas) {
                        $scope.manageLocationObj.country = datas.parentAddressList[0].country;
                        $scope.manageLocationObj.state = datas.parentAddressList[0].state;
                        $scope.manageLocationObj.zipCode = datas.parentAddressList[0].zipCode;
                        $scope.manageLocationObj.address = datas.parentAddressList[0].address;
                        $scope.manageLocationObj.cityId = datas.parentAddressList[0].cityId;
                        $scope.manageLocationObj.city = datas.parentAddressList[0].city;
                    });
                }
            } else {
                $('#parentAddress').show();
                $('#parentAddressReadonly').hide();
                $scope.manageLocationObj.country = '';
                $scope.manageLocationObj.state = '';
                $scope.manageLocationObj.zipCode = '';
                $scope.manageLocationObj.address = '';
                $scope.manageLocationObj.cityId = '';
                $scope.manageLocationObj.city = '';

                $scope.manageLocationObj.isParentAddress = 'N';
            }
        }

    });

    app.controller('manageLocationEditCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService) {

        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages = 0;
        $scope.isEdit = true;

        $scope.manageNameOld = '';

        $scope.manageLocationObj = {

            manageName : '',
            address : '',
            addressId : '',
            locationId : '',
            city : '',
            cityId : '',
            state : '',
            zipCode : '',
            country : '',
            isActive : '',
            parentLocation : '',
            pid : '',
            locationType : '',
            lid : '',
            locationIncharge : '',
            empId : '',
            locationActivity : '',
            stockLocation : '',
            scrapLocation : '',
            isParentAddress : '',
            addressTable : []
        }

        $('#parentAddress').show();
        $('#parentAddressReadonly').hide();

        $scope.validate = function(manageLocationAddForm, manageLocationObj) {
            if (new validationService().checkFormValidity($scope.manageLocationAddForm)) {
                if ($scope.isEdit) {
                    $scope.update(manageLocationAddForm, manageLocationObj);
                }
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.manageLocationAddForm.$validationSummary), 555000, 'trustedHtml');
            }
        };

        $scope.update = function(manageLocationAddForm, manageLocationObj) {
            $http.post("his/inventory/settings/managelocation/update", $scope.manageLocationObj).success(function(response) {
                if (response.success == true) {
                    logger.logSuccess("Updated Successfully!");
                    $state.go('app.finance.asset.manage.managelocation.list');
                } else {
                    logger.logError(response.message);
                }
            });
        };

        var locationId = $location.search().locationId;
        if (locationId != '') {

            $http.post("his/inventory/settings/managelocation/edit", locationId).success(function(response) {
                if (response) {

                    $scope.manageLocationObj.pid = parseInt(response.editList[0].pid);
                    $scope.manageLocationObj.manageName = response.editList[0].manageName;
                    $scope.manageNameOld = response.editList[0].manageName;
                    $scope.manageLocationObj.address = response.editList[0].address;
                    $scope.manageLocationObj.addressId = response.editList[0].addressId;
                    $scope.manageLocationObj.locationId = response.editList[0].locationId;
                    $scope.manageLocationObj.city = response.editList[0].city;
                    $scope.manageLocationObj.cityId = response.editList[0].cityId;
                    $scope.manageLocationObj.state = response.editList[0].state;
                    $scope.manageLocationObj.zipCode = response.editList[0].zipCode;
                    $scope.manageLocationObj.country = response.editList[0].country;
                    $scope.manageLocationObj.parentLocation = response.editList[0].parentLocation;
                    $scope.manageLocationObj.locationType = response.editList[0].locationType;
                    $scope.manageLocationObj.lid = Number(response.editList[0].lid);
                    $scope.manageLocationObj.locationIncharge = response.editList[0].locationIncharge;
                    $scope.manageLocationObj.isActive = response.editList[0].isActive;
                    $scope.manageLocationObj.empId = response.editList[0].empId;
                    $scope.manageLocationObj.locationActivity = response.editList[0].locationActivity;
                    $scope.manageLocationObj.stockLocation = response.editList[0].stockLocation;
                    $scope.manageLocationObj.scrapLocation = response.editList[0].scrapLocation;
                    $scope.manageLocationObj.isParentAddress = response.editList[0].isParentAddress;

                    if (response.editList[0].isParentAddress == 't') {
                        $('#parentAddress').hide();
                        $('#parentAddressReadonly').show();
                    } else {
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
            $state.go("app.finance.asset.manage.managelocation.list");
        };

        $http.get("his/inventory/settings/managelocation/citylist").success(function(datas) {
            $scope.cityList = datas.cityList;

        });

        $http.get("his/inventory/settings/managelocation/parentlocationlist").success(function(datas) {
            $scope.parentLocationList = datas.parentlocationList;
        });

        $http.get("his/inventory/settings/managelocation/locationtypelist").success(function(datas) {
            $scope.locationTypeList = datas.locationtypeList;
        });

        $http.get("his/inventory/settings/managelocation/inchargelist").success(function(datas) {
            $scope.inChargeList = datas.inchargeList;

        });

        $scope.stateList = function(cityId) {
            $http.post("his/inventory/settings/managelocation/statelist", cityId).success(function(datas) {
                $scope.stateList = datas.stateList;

                $scope.manageLocationObj.zipCode = datas.stateList.zipCode;

                $http.get("his/inventory/settings/managelocation/citylist").success(function(datas) {
                    $scope.cityList = datas.cityList;

                });
            });
        }

        $scope.country = function(cityId) {

            $http.post("his/inventory/settings/managelocation/countrylist", cityId).success(function(datas) {
                $scope.manageLocationObj.country = datas.countryList[0].country;
                $scope.manageLocationObj.state = datas.countryList[0].state;
                $scope.manageLocationObj.zipCode = datas.countryList[0].zipCode;
            });
        }

        $scope.reset = function() {

            $http.post("his/inventory/settings/managelocation/edit", locationId).success(function(response) {
                if (response) {

                    $scope.manageLocationObj.pid = parseInt(response.editList[0].pid);
                    $scope.manageLocationObj.manageName = response.editList[0].manageName;
                    $scope.manageLocationObj.address = response.editList[0].address;
                    $scope.manageLocationObj.addressId = response.editList[0].addressId;
                    $scope.manageLocationObj.locationId = response.editList[0].locationId;
                    $scope.manageLocationObj.city = response.editList[0].city;
                    $scope.manageLocationObj.cityId = response.editList[0].cityId;
                    $scope.manageLocationObj.state = response.editList[0].state;
                    $scope.manageLocationObj.zipCode = response.editList[0].zipCode;
                    $scope.manageLocationObj.country = response.editList[0].country;
                    $scope.manageLocationObj.parentLocation = response.editList[0].parentLocation;
                    $scope.manageLocationObj.locationType = response.editList[0].locationType;
                    $scope.manageLocationObj.lid = Number(response.editList[0].lid);
                    $scope.manageLocationObj.locationIncharge = response.editList[0].locationIncharge;
                    $scope.manageLocationObj.isActive = response.editList[0].isActive;
                    $scope.manageLocationObj.empId = response.editList[0].empId;
                    $scope.manageLocationObj.locationActivity = response.editList[0].locationActivity;
                    $scope.manageLocationObj.stockLocation = response.editList[0].stockLocation;
                    $scope.manageLocationObj.scrapLocation = response.editList[0].scrapLocation;
                    $scope.manageLocationObj.isParentAddress = response.editList[0].isParentAddress;

                    if (response.editList[0].isParentAddress == 't') {
                        $('#parentAddress').hide();
                        $('#parentAddressReadonly').show();
                    } else {
                        $('#parentAddress').show();
                        $('#parentAddressReadonly').hide();
                    }

                } else if (response.message != '') {
                    logger.logError(response.message);
                }

            });

        };

        $scope.getParentAddress = function(isParentAddress, pid) {
            if (isParentAddress == 't') {

                if (pid == "") {
                    $scope.manageLocationObj.isParentAddress = "N";
                    logger.logError("Please Select Asset Parent Location");
                    $('#parentAddress').show();
                    $('#parentAddressReadonly').hide();

                } else {

                    $('#parentAddress').hide();
                    $('#parentAddressReadonly').show();

                    $http.post("his/inventory/settings/managelocation/parentAddress", pid).success(function(datas) {

                        $scope.manageLocationObj.country = datas.parentAddressList[0].country;
                        $scope.manageLocationObj.state = datas.parentAddressList[0].state;
                        $scope.manageLocationObj.zipCode = datas.parentAddressList[0].zipCode;
                        $scope.manageLocationObj.address = datas.parentAddressList[0].address;
                        $scope.manageLocationObj.cityId = datas.parentAddressList[0].cityId;
                        $scope.manageLocationObj.city = datas.parentAddressList[0].city;

                    });

                }

            } else {
                $('#parentAddress').show();
                $('#parentAddressReadonly').hide();

                $scope.manageLocationObj.country = '';
                $scope.manageLocationObj.state = '';
                $scope.manageLocationObj.zipCode = '';
                $scope.manageLocationObj.address = '';
                $scope.manageLocationObj.cityId = '';
                $scope.manageLocationObj.city = '';

                $scope.manageLocationObj.isParentAddress = 'N';

            }
        };

        function toUpper(mystring) {
            var sp = mystring.split(' ');
            var wl = 0;
            var f, r;
            var word = new Array();
            for (var i = 0; i < sp.length; i++) {
                f = sp[i].charAt(0).toUpperCase();
                r = sp[i].slice(1).toLowerCase();
                word[i] = f + r;
            }
            var newstring = word.join(' ');
            return newstring;
        }

        $scope.checkLocationName = function(manageName) {

            var manageNam = manageName;
            manageNam = manageNam.replace(/ {2,}/g, ' ');
            var manageName = toUpper(manageNam);
            $scope.manageLocationObj.manageName = manageName;

            if (manageName != $scope.manageNameOld) {
                $http.get('his/inventory/settings/managelocation/checkLocationName?manageName=' + manageName).success(function(datas) {

                    if (datas != 0) {
                        logger.logError('Asset Location Already Exist!');
                        $scope.manageLocationObj.manageName = $scope.manageNameOld;
                    }

                }).error(function(datas) {
                });
            }

        }

    });

//});