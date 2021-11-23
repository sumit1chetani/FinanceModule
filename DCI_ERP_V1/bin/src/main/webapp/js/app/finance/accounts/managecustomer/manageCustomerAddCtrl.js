//define([ 'hospital/asset/asset' ], function(module) {

  ///  'use strict';

    app.controller('manageCustomerAddCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, $stateParams, $timeout, validationService) {

        $scope.manageCustomerObj = [];
        $scope.displayedCollection = [];
        $scope.employeeList = [];
        $scope.itemsByPage = 10;
        $scope.numPages = 0;
        $scope.isDisplay = true;
        $scope.mainCityList = [];
        $scope.shippingCityList = [];
        $scope.deliveryCityList = [];
        $scope.billingCityList = [];
        $scope.customerContactobj = [];
        $scope.customerAddressobj = [];
        $scope.customerBankobj = [];
        $scope.locationList = [];
        $scope.paymentList = [];

        $scope.customerOldName = '';

        
        
        $scope.edit = false;
        $scope.customer = function(customer) {
            if (customer == 'N') {
                $('#salesTab').hide();
                $('#salesId').hide();
                $('#customerId').hide();

            } else {
                $('#salesTab').show();
                $('#salesId').show();
                $('#customerId').show();
            }
        }

        $scope.cancel = function() {
            $state.go("app.finance.accounts.managecustomer.list");
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

        $scope.checkCustomerName = function(entityName, entityId) {
            var entityNam = entityName;
            entityNam = entityNam.replace(/ {2,}/g, ' ');
            var entityName = toUpper(entityNam);
            $scope.manageCustomerObj.entityName = entityName;
            
            if (!$scope.edit) {
                $http.get('app/customerMaster/checkCustomerName?entityName=' + entityName).success(function(datas) {
                    if (datas != 0) {
                        logger.logError('Customer Name Already Exist!');
                        $scope.manageCustomerObj.entityName = '';
                    }
                }).error(function(datas) {
                });
            } else {
                var custOldName = toUpper($scope.customerOldName);
                if (entityName != custOldName) {
                    $http.get('app/customerMaster/checkVendorName?entityName=' + entityName).success(function(datas) {
                        if (datas != 0) {
                            logger.logError('Customer Name Already Exist!!');
                            $scope.manageCustomerObj.entityName = '';
                        }
                    }).error(function(datas) {
                    });
                }
            }

        };

        $scope.manageCustomerObj = {
            entityName : '',
            contactPerson : '',
            jobPosition : '',
            locationAddress : '',
            phoneNo : '',
            mobile : '',
            email : '',
            fax : '',
            url : '',
            tinNumber : '',
            cstNumber : '',
            desStateCode : '',
            desState : '',
            desZipcode : '',
            desCountry : '',
            cityId : '',
            panNumber : '',
            addressId : '',
            isVendor : 'N',
            isCollege : 'N',
            isCustomer : 'Y',
            isOthers : '',
            isActive : 'Y',
            customerLocation : '',
            accountPayable : '',
            customerPayment : '',
            creditLimit : '',
            shipAddress : '',
            deliveryAddress : '',
            billingAddress : '',
            deliveryMethod : '',
            internalNotes : '',
            custPaymentTerm : '',
            responsiblePersonSales : '',
            screenName : 'manageCustomer',
            entityId : '',
            customerAddressobj : [ {
                addressType : 0,
                cityAddressId : ''
            }, {
                addressType : 0,
                citydeliveryId : ''
            }, {
                addressType : 0,
                citybillingId : ''
            } ],

            customerContactobj : [],
            customerBankobj : []
        };
        $scope.manageEntityObj = {
            stateCodeAddress : '',
            stateNameAddress : '',
            pincodeAddress : '',
            countryCodeAddress : '',
            countryNameAddress : '',
            stateCodedelivery : '',
            stateNamedelivery : '',
            pincodedelivery : '',
            countryCodedelivery : '',
            countryNamedelivery : '',
            stateCodeBilling : '',
            stateNameBilling : '',
            pincodeBilling : '',
            countryCodeBilling : '',
            countryNameBilling : ''
        };

        /**
         * Dropdown Datas ********************************
         */

        $scope.getDropdownValue = function() {
            $http.get("app/customerMaster/paymentTerms").success(function(response) {
                $scope.paymentList = response.paymentList;
                $scope.locationList = response.locationList;
            }).error(function(data) {
            });

            $http.get('app/hospital/purchase/storeToStore/employeeList').success(function(datas) {
                $scope.employeeList = datas.employeeList;

            }).error(function(data) {
            });
            $http.get('app/customerMaster/getCityList').success(function(datas) {
                $scope.mainCityList = datas.mainCityList;
                $scope.shippingCityList = datas.mainCityList;
                $scope.deliveryCityList = datas.mainCityList;
                $scope.billingCityList = datas.mainCityList;
            }).error(function(data) {
            });
        }
        $scope.getDropdownValue();

        /**
         * onChange City, fetch into to respective state,country,pinCode
         */
        $scope.$watch('manageCustomerObj.cityId', function(newValue, oldValue) {
            if (newValue != '' && newValue != undefined) {
                $scope.onChangeMainCity($scope.manageCustomerObj.cityId);
            }
        });

        /**
         * shipping address - city Id Change
         */

        $scope.$watch('manageCustomerObj.customerAddressobj[0].cityAddressId', function(newValue, oldValue) {
            if (newValue != '' && newValue != undefined) {
                $scope.onChangeMainCityshipping($scope.manageCustomerObj.customerAddressobj[0].cityAddressId);
            }
        });
        /**
         * delivery address - city Id Change
         */
        $scope.$watch('manageCustomerObj.customerAddressobj[1].citydeliveryId', function(newValue, oldValue) {
            if (newValue != '' && newValue != undefined) {
                $scope.onChangeMainCitydelivery($scope.manageCustomerObj.customerAddressobj[1].citydeliveryId);
            }
        });
        /**
         * billing address - city Id Change
         */
        $scope.$watch('manageCustomerObj.customerAddressobj[2].citybillingId', function(newValue, oldValue) {
            if (newValue != '' && newValue != undefined) {
                $scope.onChangeMainCitybilling($scope.manageCustomerObj.customerAddressobj[2].citybillingId);
            }

        });
        /**
         * City onchange in Header
         */

        $scope.onChangeMainCity = function(cityId) {
            if (cityId != '' && cityId != undefined) {
                $http.get('app/customerMaster/getCityStateCountryList?cityId=' + cityId).success(function(datas) {
                    if (datas.lManageCustomerBean.length > 0) {
                        angular.forEach(datas.lManageCustomerBean, function(item, key) {
                            $scope.manageCustomerObj.desStateCode = datas.lManageCustomerBean[key].stateCode;
                            $scope.manageCustomerObj.desState = datas.lManageCustomerBean[key].stateName;
                            $scope.manageCustomerObj.desZipcode = datas.lManageCustomerBean[key].pincode;
                            $scope.manageCustomerObj.desCountry = datas.lManageCustomerBean[key].countryName;
                            $scope.manageCustomerObj.desCountryCode = datas.lManageCustomerBean[key].countryCode;

                        });
                    } else {
                        $scope.manageCustomerObj.desStateCode = '';
                        $scope.manageCustomerObj.desState = '';
                        $scope.manageCustomerObj.desZipcode = '';
                        $scope.manageCustomerObj.desCountryCode = '';
                        $scope.manageCustomerObj.desCountry = '';
                    }
                }).error(function(data) {
                });
            } else {
                $scope.manageCustomerObj.desStateCode = '';
                $scope.manageCustomerObj.desState = '';
                $scope.manageCustomerObj.desZipcode = '';
                $scope.manageCustomerObj.desCountryCode = '';
                $scope.manageCustomerObj.desCountry = '';
            }
        }

        /**
         * Shipping Address
         * 
         * 
         */
        $scope.onChangeMainCityshipping = function(cityshippingId) {
            if (cityshippingId != '' && cityshippingId != undefined) {

                $http.get('app/customerMaster/getCityStateCountryList?cityId=' + cityshippingId).success(function(datas) {

                    if (datas.lManageCustomerBean.length > 0) {
                        angular.forEach(datas.lManageCustomerBean, function(item, key) {
                            $scope.manageCustomerObj.customerAddressobj[0].addressType = 130;
                            $scope.manageEntityObj.stateCodeAddress = datas.lManageCustomerBean[key].stateCode;
                            $scope.manageEntityObj.stateNameAddress = datas.lManageCustomerBean[key].stateName;
                            $scope.manageEntityObj.pincodeAddress = datas.lManageCustomerBean[key].pincode;
                            $scope.manageEntityObj.countryCodeAddress = datas.lManageCustomerBean[key].countryCode;
                            $scope.manageEntityObj.countryNameAddress = datas.lManageCustomerBean[key].countryName;
                        });
                    } else {
                        $scope.manageCustomerObj.customerAddressobj[0].addressType = '';
                        $scope.manageEntityObj.stateCodeAddress = '';
                        $scope.manageEntityObj.stateNameAddress = '';
                        $scope.manageEntityObj.pincodeAddress = '';
                        $scope.manageEntityObj.countryCodeAddress = '';
                        $scope.manageEntityObj.countryNameAddress = '';
                    }

                }).error(function(data) {
                });

            } else {
                $scope.manageCustomerObj.customerAddressobj[0].addressType = '';
                $scope.manageEntityObj.stateCodeAddress = '';
                $scope.manageEntityObj.stateNameAddress = '';
                $scope.manageEntityObj.pincodeAddress = '';
                $scope.manageEntityObj.countryCodeAddress = '';
                $scope.manageEntityObj.countryNameAddress = '';
            }
        }
        /**
         * Delivery Address
         * 
         * 
         * 
         */
        $scope.onChangeMainCitydelivery = function(citydeliveryId) {
            if (citydeliveryId != '' && citydeliveryId != undefined) {

                $http.get('app/customerMaster/getCityStateCountryList?cityId=' + citydeliveryId).success(function(datas) {

                    if (datas.lManageCustomerBean.length > 0) {
                        angular.forEach(datas.lManageCustomerBean, function(item, key) {
                            $scope.manageCustomerObj.customerAddressobj[1].addressType = 131;
                            $scope.manageEntityObj.stateCodedelivery = datas.lManageCustomerBean[key].stateCode;
                            $scope.manageEntityObj.stateNamedelivery = datas.lManageCustomerBean[key].stateName;
                            $scope.manageEntityObj.pincodedelivery = datas.lManageCustomerBean[key].pincode;
                            $scope.manageEntityObj.countryCodedelivery = datas.lManageCustomerBean[key].countryCode;
                            $scope.manageEntityObj.countryNamedelivery = datas.lManageCustomerBean[key].countryName;
                        });
                    } else {
                        $scope.manageCustomerObj.customerAddressobj[1].addressType = '';
                        $scope.manageEntityObj.stateCodedelivery = '';
                        $scope.manageEntityObj.stateNamedelivery = '';
                        $scope.manageEntityObj.pincodedelivery = '';
                        $scope.manageEntityObj.countryCodedelivery = '';
                        $scope.manageEntityObj.countryNamedelivery = '';
                    }

                }).error(function(data) {
                });

            } else {
                $scope.manageCustomerObj.customerAddressobj[1].addressType = '';
                $scope.manageEntityObj.stateCodedelivery = '';
                $scope.manageEntityObj.stateNamedelivery = '';
                $scope.manageEntityObj.pincodedelivery = '';
                $scope.manageEntityObj.countryCodedelivery = '';
                $scope.manageEntityObj.countryNamedelivery = '';
            }
        }
        /**
         * Billing Address
         */

        $scope.onChangeMainCitybilling = function(citybillingId) {
            if (citybillingId != '' && citybillingId != undefined) {

                $http.get('app/customerMaster/getCityStateCountryList?cityId=' + citybillingId).success(function(datas) {

                    if (datas.lManageCustomerBean.length > 0) {
                        angular.forEach(datas.lManageCustomerBean, function(item, key) {
                            $scope.manageCustomerObj.customerAddressobj[2].addressType = 132;
                            $scope.manageEntityObj.stateCodeBilling = datas.lManageCustomerBean[key].stateCode;
                            $scope.manageEntityObj.stateNameBilling = datas.lManageCustomerBean[key].stateName;
                            $scope.manageEntityObj.pincodeBilling = datas.lManageCustomerBean[key].pincode;
                            $scope.manageEntityObj.countryCodeBilling = datas.lManageCustomerBean[key].countryCode;
                            $scope.manageEntityObj.countryNameBilling = datas.lManageCustomerBean[key].countryName;
                        });
                    } else {
                        $scope.manageCustomerObj.customerAddressobj[2].addressType = '';
                        $scope.manageEntityObj.stateCodeBilling = '';
                        $scope.manageEntityObj.stateNameBilling = '';
                        $scope.manageEntityObj.pincodeBilling = '';
                        $scope.manageEntityObj.countryCodeBilling = '';
                        $scope.manageEntityObj.countryNameBilling = '';
                    }

                }).error(function(data) {
                });

            } else {
                $scope.manageCustomerObj.customerAddressobj[2].addressType = '';
                $scope.manageEntityObj.stateCodeBilling = '';
                $scope.manageEntityObj.stateNameBilling = '';
                $scope.manageEntityObj.pincodeBilling = '';
                $scope.manageEntityObj.countryCodeBilling = '';
                $scope.manageEntityObj.countryNameBilling = '';
            }
        }

        // remove Row
        $scope.deleteAddressRow = function() {

            $scope.tablerow = [];
            angular.forEach($scope.manageCustomerObj.customerContactobj, function(tables, index) {
                if (tables.select == true) {
                } else {
                    $scope.tablerow.push(tables);
                }
            });
            $scope.manageCustomerObj.customerContactobj = $scope.tablerow;
        };

        // remove Row
        $scope.deleteBankRow = function() {

            $scope.tablerow = [];
            angular.forEach($scope.manageCustomerObj.customerBankobj, function(tables, index) {
                if (tables.select == true) {
                } else {
                    $scope.tablerow.push(tables);
                }
            });
            $scope.manageCustomerObj.customerBankobj = $scope.tablerow;
        };

        $scope.error = function(message) {
            logger.logErrorHtml(sharedProperties.getErrorObject());
        };
        /***********************************************************************
         * Save Functionality *******************************
         */
        $scope.save = function(manageCustomerAddForm) {
            if (new validationService().checkFormValidity(manageCustomerAddForm)) {
                if ($scope.manageCustomerObj.entityName == "" || $scope.manageCustomerObj.entityName == undefined || $scope.manageCustomerObj.entityName == null) {
                    logger.logError("Please Enter the Customer Name!");
                } else {
                    if ($scope.edit == false) {
                        $http.post('app/customerMaster/save', $scope.manageCustomerObj).success(function(result) {
                            if (result) {
                                logger.logSuccess("Saved Successfully!");
                                $location.path($stateParams.tenantid +'/accounts/managecustomer/list');
                            } else {
                                logger.logError("Customer Code Already Exist!");
                            }
                        }).error(function(result) {
                        });
                    } else {
                        $http.post('app/customerMaster/update', $scope.manageCustomerObj).success(function(result) {
                            if (result) {
                                logger.logSuccess("Updated Successfully!");
                                $location.path($stateParams.tenantid +'/accounts/managecustomer/list');
                            } else {
                                logger.logError("Customer Code Already Exist!");
                            }
                        }).error(function(result) {
                        });
                    }
                }

            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(manageCustomerAddForm.$validationSummary), 5000, 'trustedHtml');
            }
        };

        $scope.addNewAccountingDialog = function() {
            $scope.callAccountingDialog($scope, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope);
        };

        $scope.addNewContactDialog = function() {
            $scope.callContactDialog($scope, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope);
        };

        /**
         * save Contact Row Dialog Datas into Contact tab detail..
         */
        $scope.saveRowContact = function() {
            $scope.manageCustomerObj.customerContactobj.push({
                'contactName' : $scope.customerContactobj.contactName,
                'jobPosition' : $scope.customerContactobj.jobPosition,
                'email' : $scope.customerContactobj.email,
                'mobile' : $scope.customerContactobj.mobile,
                'address' : $scope.customerContactobj.address,
                'phone' : $scope.customerContactobj.phone
            });
            $scope.customerContactobj.contactName = '';
            $scope.customerContactobj.email = '';
            $scope.customerContactobj.jobPosition = '';
            $scope.customerContactobj.phone = '';
            $scope.customerContactobj.mobile = '';
            ngDialog.close();
        };

        $scope.callAccountingDialog = function($scope, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope) {
            ngDialog.open({
                scope : $scope,
                template : 'views/finance/accounts/managecustomer/manageCustomerBankAdd',
                controller : $controller('manageCustomerBankAdd', {
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
            });
        };

        $scope.callContactDialog = function($scope, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope) {
            ngDialog.open({
                scope : $scope,
                template : 'views/hospital/asset/managecustomer/manageCustomerAddressAdd',
                controller : $controller('manageCustomerAddAddressCtrl', {
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
            });
        };

        // Reset Functionality added by Kathir

        $scope.isEdit == false;
        $scope.reset = function(manageCustomerAddForm) {

            if ($scope.isEdit == false) {
                $scope.manageCustomerObj.entityName = '';
                $scope.manageCustomerObj.contactPerson = '';
                $scope.manageCustomerObj.jobPosition = '';
                $scope.manageCustomerObj.locationAddress = '';
                $scope.manageCustomerObj.phoneNo = '';
                $scope.manageCustomerObj.mobile = '';
                $scope.manageCustomerObj.email = '';
                $scope.manageCustomerObj.fax = '';
                $scope.manageCustomerObj.url = '';
                $scope.manageCustomerObj.tinNumber = '';
                $scope.manageCustomerObj.desStateCode = '';
                $scope.manageCustomerObj.cstNumber = '';
                $scope.manageCustomerObj.desState = '';
                $scope.manageCustomerObj.desZipcode = '';
                $scope.manageCustomerObj.desCountry = '';
                $scope.manageCustomerObj.cityId = '';
                $scope.manageCustomerObj.panNumber = '';
                $scope.manageCustomerObj.addressId = '';
                $scope.manageCustomerObj.isVendor = 'N';
                $scope.manageCustomerObj.isCollege = 'N';
                $scope.manageCustomerObj.isCustomer = 'Y';
                $scope.manageCustomerObj.isOthers = '';
                $scope.manageCustomerObj.isActive = '';
                $scope.manageCustomerObj.customerLocation = '';
                $scope.manageCustomerObj.accountPayable = '';
                $scope.manageCustomerObj.customerPayment = '';
                $scope.manageCustomerObj.creditLimit = '';
                $scope.manageCustomerObj.shipAddress = '';
                $scope.manageCustomerObj.deliveryAddress = '';
                $scope.manageCustomerObj.billingAddress = '';
                $scope.manageCustomerObj.deliveryMethod = '';
                $scope.manageCustomerObj.internalNotes = '';
                $scope.manageCustomerObj.custPaymentTerm = '';
                $scope.manageCustomerObj.responsiblePersonSales = '';
                $scope.manageCustomerObj.customerContactobj = [];
                $scope.manageCustomerObj.customerBankob = [];
                $scope.manageCustomerObj.customerAddressobj = [];
                $scope.manageEntityObj = '';

            } else {
                $http.get('app/customerMaster/getCustomerDataOnEdit?entityId=' + entityId + '&screenName=' + screenName).success(function(data) {
                    $scope.edit = true;
                    $scope.customerOldName = data.entityName;
                    $scope.manageCustomerObj.entityId = data.entityId;
                    $scope.manageCustomerObj.screenName = "manageCustomer";
                    $scope.manageCustomerObj.entityName = data.entityName;
                    $scope.manageCustomerObj.locationAddress = data.locationAddress;
                    $scope.manageCustomerObj.cityId = data.cityId;
                    $scope.manageCustomerObj.desStateCode = data.desStateCode;
                    $scope.manageCustomerObj.desState = data.desState;
                    $scope.manageCustomerObj.desZipcode = data.desZipcode;
                    $scope.manageCustomerObj.desCountryCode = data.desCountryCode;
                    $scope.manageCustomerObj.desCountry = data.desCountry;
                    $scope.manageCustomerObj.tinNumber = data.tinNumber;
                    $scope.manageCustomerObj.cstNumber = data.cstNumber;
                    $scope.manageCustomerObj.contactPerson = data.contactPerson;
                    $scope.manageCustomerObj.jobPosition = data.jobPosition;
                    $scope.manageCustomerObj.mobile = data.mobile;
                    $scope.manageCustomerObj.phoneNo = data.phoneNo;
                    $scope.manageCustomerObj.fax = data.fax;
                    $scope.manageCustomerObj.website = data.website;
                    $scope.manageCustomerObj.email = data.email;
                    $scope.manageCustomerObj.panNumber = data.panNumber;
                    $scope.manageCustomerObj.customerLocation = data.customerLocation;
                    $scope.manageCustomerObj.shipAddress = data.shipAddress;
                    $scope.manageCustomerObj.deliveryAddress = data.deliveryAddress;
                    $scope.manageCustomerObj.customerContactobj = data.customerContactobj;
                    $scope.manageCustomerObj.responsiblePersonSales = data.responsiblePersonSales;
                    $scope.manageCustomerObj.deliveryMethod = data.deliveryMethod;
                    $scope.manageCustomerObj.accountReceivable = data.accountReceivable;
                    $scope.manageCustomerObj.totalReceivable = data.totalReceivable;
                    $scope.manageCustomerObj.accountReceivable = data.accountReceivable;
                    $scope.manageCustomerObj.totalReceivable = data.totalReceivable;
                    $scope.manageCustomerObj.creditLimit = data.creditLimit;
                    $scope.manageCustomerObj.customerBankobj = data.customerBankobj;
                    $scope.manageCustomerObj.customerAcctCode = data.customerAcctCode;
                    $scope.manageCustomerObj.entityAcctCode = data.entityAcctCode;
                    $scope.manageCustomerObj.supplierAcctCode = data.supplierAcctCode;
                    $scope.manageCustomerObj.custPaymentTerm = data.custPaymentTerm;
                    // alert($scope.manageCustomerObj.custPaymentTerm);
                    $scope.manageCustomerObj.customerAddressobj = [ {
                        addressType : 0,
                        cityAddressId : '',
                        entityAddressId : '',
                        shipAddressId : '',
                        shipAddress : ''
                    }, {
                        addressType : 0,
                        citydeliveryId : '',
                        entityAddressId : '',
                        deliveryAddressId : '',
                        deliveryAddress : ''
                    }, {
                        addressType : 0,
                        citybillingId : '',
                        billingAddressId : '',
                        billingAddress : '',
                        entityAddressId : ''
                    } ];
                    $scope.manageCustomerObj.screenName = "manageCustomer";
                    if (data.isActive == "t") {
                        $scope.manageCustomerObj.isActive = 'Y';
                    } else {
                        $scope.manageCustomerObj.isActive = 'N';
                    }
                    if (data.isCustomer == "t") {
                        $scope.manageCustomerObj.isCustomer = 'Y';
                    } else {
                        $scope.manageCustomerObj.isCustomer = 'N';
                    }
                    if (data.isVendor == "t") {
                        $scope.manageCustomerObj.isVendor = 'Y';
                    } else {
                        $scope.manageCustomerObj.isVendor = 'N';
                    }
                    if (data.isCollege == "t") {
                        $scope.manageCustomerObj.isCollege = 'Y';
                    } else {
                        $scope.manageCustomerObj.isCollege = 'N';
                    }
                    if (data.isOthers == "t") {
                        $scope.manageCustomerObj.isOthers = 'Y';
                    } else {
                        $scope.manageCustomerObj.isOthers = 'N';
                    }
                    if (data.customerAddressobj != undefined && data.customerAddressobj != null && data.customerAddressobj != '') {

                        angular.forEach(data.customerAddressobj, function(value, index1) {
                            if (value.addressType == 130) {
                                $scope.manageCustomerObj.shipAddress = value.shipAddress;
                                $scope.manageCustomerObj.customerAddressobj[0].cityAddressId = value.cityAddressId;
                                $scope.manageCustomerObj.customerAddressobj[0].entityAddressId = value.entityAddressId;
                                $scope.manageCustomerObj.customerAddressobj[0].shipAddress = value.shipAddress;
                                $scope.manageCustomerObj.customerAddressobj[0].shipAddressId = value.shipAddressId;
                            }
                            if (value.addressType == 131) {
                                $scope.manageCustomerObj.deliveryAddress = value.deliveryAddress;
                                $scope.manageCustomerObj.customerAddressobj[1].citydeliveryId = value.citydeliveryId;
                                $scope.manageCustomerObj.customerAddressobj[1].entityAddressId = value.entityAddressId;
                                $scope.manageCustomerObj.customerAddressobj[1].deliveryAddress = value.deliveryAddress;
                                $scope.manageCustomerObj.customerAddressobj[1].deliveryAddressId = value.deliveryAddressId;
                            }
                            if (value.addressType == 132) {
                                $scope.manageCustomerObj.billingAddress = value.billingAddress;
                                $scope.manageCustomerObj.customerAddressobj[2].citybillingId = value.citybillingId;
                                $scope.manageCustomerObj.customerAddressobj[2].billingAddress = value.billingAddress;
                                $scope.manageCustomerObj.customerAddressobj[2].shipAddress = value.shipAddress;
                                $scope.manageCustomerObj.customerAddressobj[2].billingAddressId = value.billingAddressId;
                            }
                        });

                    } else {
                        $scope.manageCustomerObj.customerAddressobj = [ {
                            addressType : 0,
                            cityAddressId : ''
                        }, {
                            addressType : 0,
                            citydeliveryId : ''
                        }, {
                            addressType : 0,
                            citybillingId : ''
                        } ]
                    }
                }).error(function(data) {
                });
            }
        };

        /***********************************************************************
         * Edit Functionality *******************************
         * 
         * 
         */
        var entityId = $stateParams.entityId;
        var screenName = "manageCustomer";
        if (entityId == undefined || entityId == null || entityId == "") {

        } else {
            $http.get('app/customerMaster/getCustomerDataOnEdit?entityId=' + entityId + '&screenName=' + screenName).success(function(data) {
                $scope.edit = true;
                $scope.customerOldName = data.entityName;
                $scope.manageCustomerObj.entityId = data.entityId;
                $scope.manageCustomerObj.screenName = "manageCustomer";
                $scope.manageCustomerObj.entityName = data.entityName;
                $scope.manageCustomerObj.locationAddress = data.locationAddress;
                $scope.manageCustomerObj.cityId = data.cityId;
                $scope.manageCustomerObj.desStateCode = data.desStateCode;
                $scope.manageCustomerObj.desState = data.desState;
                $scope.manageCustomerObj.desZipcode = data.desZipcode;
                $scope.manageCustomerObj.desCountryCode = data.desCountryCode;
                $scope.manageCustomerObj.desCountry = data.desCountry;
                $scope.manageCustomerObj.tinNumber = data.tinNumber;
                $scope.manageCustomerObj.cstNumber = data.cstNumber;
                $scope.manageCustomerObj.contactPerson = data.contactPerson;
                $scope.manageCustomerObj.jobPosition = data.jobPosition;
                $scope.manageCustomerObj.mobile = data.mobile;
                $scope.manageCustomerObj.phoneNo = data.phoneNo;
                $scope.manageCustomerObj.fax = data.fax;
                $scope.manageCustomerObj.website = data.website;
                $scope.manageCustomerObj.email = data.email;
                $scope.manageCustomerObj.panNumber = data.panNumber;
                $scope.manageCustomerObj.customerLocation = data.customerLocation;
                $scope.manageCustomerObj.shipAddress = data.shipAddress;
                $scope.manageCustomerObj.deliveryAddress = data.deliveryAddress;
                $scope.manageCustomerObj.customerContactobj = data.customerContactobj;
                $scope.manageCustomerObj.responsiblePersonSales = data.responsiblePersonSales;
                $scope.manageCustomerObj.deliveryMethod = data.deliveryMethod;
                $scope.manageCustomerObj.accountReceivable = data.accountReceivable;
                $scope.manageCustomerObj.totalReceivable = data.totalReceivable;
                $scope.manageCustomerObj.accountReceivable = data.accountReceivable;
                $scope.manageCustomerObj.totalReceivable = data.totalReceivable;
                $scope.manageCustomerObj.creditLimit = data.creditLimit;
                $scope.manageCustomerObj.customerBankobj = data.customerBankobj;
                $scope.manageCustomerObj.customerAcctCode = data.customerAcctCode;
                $scope.manageCustomerObj.entityAcctCode = data.entityAcctCode;
                $scope.manageCustomerObj.supplierAcctCode = data.supplierAcctCode;
                $scope.manageCustomerObj.custPaymentTerm = data.custPaymentTerm;

                $scope.manageCustomerObj.customerAddressobj = [ {
                    addressType : 0,
                    cityAddressId : '',
                    entityAddressId : '',
                    shipAddressId : '',
                    shipAddress : ''
                }, {
                    addressType : 0,
                    citydeliveryId : '',
                    entityAddressId : '',
                    deliveryAddressId : '',
                    deliveryAddress : ''
                }, {
                    addressType : 0,
                    citybillingId : '',
                    billingAddressId : '',
                    billingAddress : '',
                    entityAddressId : ''
                } ];
                $scope.manageCustomerObj.screenName = "manageCustomer";
                if (data.isActive == "t") {
                    $scope.manageCustomerObj.isActive = 'Y';
                } else {
                    $scope.manageCustomerObj.isActive = 'N';
                }
                if (data.isCustomer == "t") {
                    $scope.manageCustomerObj.isCustomer = 'Y';
                } else {
                    $scope.manageCustomerObj.isCustomer = 'N';
                }
                if (data.isVendor == "t") {
                    $scope.manageCustomerObj.isVendor = 'Y';
                } else {
                    $scope.manageCustomerObj.isVendor = 'N';
                }
                if (data.isCollege == "t") {
                    $scope.manageCustomerObj.isCollege = 'Y';
                } else {
                    $scope.manageCustomerObj.isCollege = 'N';
                }
                if (data.isOthers == "t") {
                    $scope.manageCustomerObj.isOthers = 'Y';
                } else {
                    $scope.manageCustomerObj.isOthers = 'N';
                }
                if (data.customerAddressobj != undefined && data.customerAddressobj != null && data.customerAddressobj != '') {

                    angular.forEach(data.customerAddressobj, function(value, index1) {
                        if (value.addressType == 130) {
                            $scope.manageCustomerObj.shipAddress = value.shipAddress;
                            $scope.manageCustomerObj.customerAddressobj[0].cityAddressId = value.cityAddressId;
                            $scope.manageCustomerObj.customerAddressobj[0].entityAddressId = value.entityAddressId;
                            $scope.manageCustomerObj.customerAddressobj[0].shipAddress = value.shipAddress;
                            $scope.manageCustomerObj.customerAddressobj[0].shipAddressId = value.shipAddressId;
                        }
                        if (value.addressType == 131) {
                            $scope.manageCustomerObj.deliveryAddress = value.deliveryAddress;
                            $scope.manageCustomerObj.customerAddressobj[1].citydeliveryId = value.citydeliveryId;
                            $scope.manageCustomerObj.customerAddressobj[1].entityAddressId = value.entityAddressId;
                            $scope.manageCustomerObj.customerAddressobj[1].deliveryAddress = value.deliveryAddress;
                            $scope.manageCustomerObj.customerAddressobj[1].deliveryAddressId = value.deliveryAddressId;
                        }
                        if (value.addressType == 132) {
                            $scope.manageCustomerObj.billingAddress = value.billingAddress;
                            $scope.manageCustomerObj.customerAddressobj[2].citybillingId = value.citybillingId;
                            $scope.manageCustomerObj.customerAddressobj[2].billingAddress = value.billingAddress;
                            $scope.manageCustomerObj.customerAddressobj[2].shipAddress = value.shipAddress;
                            $scope.manageCustomerObj.customerAddressobj[2].billingAddressId = value.billingAddressId;
                        }
                    });

                } else {
                    $scope.manageCustomerObj.customerAddressobj = [ {
                        addressType : 0,
                        cityAddressId : ''
                    }, {
                        addressType : 0,
                        citydeliveryId : ''
                    }, {
                        addressType : 0,
                        citybillingId : ''
                    } ]
                }
            }).error(function(data) {
            });
        }
    });
    app.controller('manageCustomerBankAdd', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {

        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.accountTypeList = [];
        $scope.customerBankobj = {
            bankCityId : '',
            bankName : '',
            accountNo : '',
            accountTypeId : '',
            accountType : '',
            ifscCode : '',
            bankDetAddress : ''
        };

        /**
         * Payment Terms, Account Type List via Deftable
         */

        $scope.paymentList = function() {
            $http.get("app/customerMaster/paymentTerms").success(function(response) {
                $scope.accountTypeList = response.accountTypeList;
            });
        };
        $scope.paymentList();

        $scope.$watch('customerBankobj.bankCityId', function(newValue, oldValue) {
            
            if (newValue != '' && newValue != undefined) {
                $scope.onChangeBankDetailCity($scope.customerBankobj.bankCityId);
            }

        });

        $scope.onChangeBankDetailCity = function(cityId) {
            
            if (cityId != '' && cityId != undefined) {
                $http.get('app/customerMaster/getCityStateCountryList?cityId=' + cityId).success(function(datas) {
                    if (datas.lManageCustomerBean.length > 0) {
                        angular.forEach(datas.lManageCustomerBean, function(item, key) {
                            $scope.customerBankobj.desStateCode = datas.lManageCustomerBean[key].stateCode;
                            $scope.customerBankobj.desState = datas.lManageCustomerBean[key].stateName;
                            $scope.customerBankobj.desZipcode = datas.lManageCustomerBean[key].pincode;
                            $scope.customerBankobj.desCountry = datas.lManageCustomerBean[key].countryName;
                            $scope.customerBankobj.desCountryCode = datas.lManageCustomerBean[key].countryCode;
                        });
                    } else {
                        $scope.customerBankobj.desStateCode = '';
                        $scope.customerBankobj.desState = '';
                        $scope.customerBankobj.desZipcode = '';
                        $scope.customerBankobj.desCountryCode = '';
                        $scope.customerBankobj.desCountry = '';
                    }
                }).error(function(data) {
                });

            } else {
                $scope.customerBankobj.desStateCode = '';
                $scope.customerBankobj.desState = '';
                $scope.customerBankobj.desZipcode = '';
                $scope.customerBankobj.desCountryCode = '';
                $scope.customerBankobj.desCountry = '';
            }
        }

        /**
         * save Bank Row Dialog Datas into Bank tab detail..
         */

        $scope.addRowBank = function() {
            
            $scope.customerBankobj.bankName = $scope.customerBankobj.bankName;
            $scope.customerBankobj.accountNo = $scope.customerBankobj.accountNo;
            $scope.customerBankobj.accountTypeId = $scope.customerBankobj.accountTypeId;
            $scope.customerBankobj.accountType = $scope.customerBankobj.accountType;
            angular.forEach($scope.accountTypeList, function(key, index) {
                
                if (key.accountTypeId == $scope.customerBankobj.accountTypeId) {
                    $scope.customerBankobj.accountType = key.accountType;
                }
            });
            $scope.customerBankobj.ifscCode = $scope.customerBankobj.ifscCode;
            $scope.customerBankobj.bankDetAddress = $scope.customerBankobj.bankDetAddress;

            $scope.manageCustomerObj.customerBankobj.push($scope.customerBankobj);
            ngDialog.close();
        };
        $scope.cancelBank = function() {
            ngDialog.close();
        };
    });

    app.controller('manageCustomerAddAddressCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {

        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;

        $scope.cancelAddress = function() {
            ngDialog.close();
        };
    });

    app.directive('phonenumbersOnly', function(logger) {
        return {
            require : 'ngModel',
            link : function(scope, element, attrs, modelCtrl) {

                modelCtrl.$parsers.push(function(inputValue) {
                    var inputValue = modelCtrl.$viewValue;
                    // if (inputValue == undefined) return false;

                    if (inputValue == undefined)
                        return ''
                    var transformedInput = inputValue.replace(/[^0-9]/g, '');
                    if (transformedInput != inputValue) {
                        modelCtrl.$setViewValue(transformedInput);
                        modelCtrl.$render();
                    } else {
                        // logger.logError("Enter Valid Phone number!");
                    }

                    return transformedInput;
                });
            }
        };
    });
    app.directive('numbersOnly', function(logger) {
        return {
            require : 'ngModel',
            link : function(scope, element, attrs, modelCtrl) {

                modelCtrl.$parsers.push(function(inputValue) {
                    var inputValue = modelCtrl.$viewValue;
                    // if (inputValue == undefined) return false;

                    if (inputValue == undefined)
                        return ''
                    var transformedInput = inputValue.replace(/[^0-9]/g, '');
                    if (transformedInput != inputValue) {
                        modelCtrl.$setViewValue(transformedInput);
                        modelCtrl.$render();
                    } else {
                        // logger.logError("Enter Valid Phone number!");
                    }

                    return transformedInput;
                });
            }
        };
  //  });

});