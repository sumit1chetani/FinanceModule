'use strict';

app.controller('vendorAddCtrl', function($scope, $rootScope, $http, $location, logger, ngDialog,$injector,
        utilsService,$state,sharedProperties,$window,$stateParams,toaster,validationService,$controller) {

        $scope.manageVendorObj = [];
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

        $scope.vendorOldName = '';

        $scope.cancel = function() {
            $state.go("app.sea.vendor.list");
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

        $scope.checkVendorName = function(entityName, entityId) {
            var entityNam = entityName;
            entityNam = entityNam.replace(/ {2,}/g, ' ');
            var entityName = toUpper(entityNam);
            $scope.manageVendorObj.entityName = entityName;

            if (!$scope.edit) {
                $http.get('app/customerMaster/checkVendorName?entityName=' + entityName).success(function(datas) {
                    if (datas != 0) {
                        logger.logError('Vendor Name Already Exist!');
                        $scope.manageVendorObj.entityName = '';
                    }
                }).error(function(datas) {
                });
            } else {
                var vendOldName = toUpper($scope.vendorOldName);
                if (entityName != vendOldName) {
                    $http.get('app/customerMaster/checkVendorName?entityName=' + entityName).success(function(datas) {
                        if (datas != 0) {
                            logger.logError('Vendor Name Already Exist!!');
                            $scope.manageVendorObj.entityName = '';
                        }
                    }).error(function(datas) {
                    });
                }
            }

        };

        $scope.manageVendorObj = {

            entityName : '',
            contactPerson : '',
            jobPosition : '',
            locationAddress : '',
            phoneNo : '',
            mobile : '',
            email : '',
            fax : '',
            url : '',
            currencyCode : '',
            tinNumber : '',
            cstNumber : '',
            gstNumber : '',

            desStateCode : '',
            desState : '',
            desZipcode : '',
            desCountry : '',
            cityId : '',
            panNumber : '',
            addressId : '',
            isVendor : 'Y',
            isCollege : 'N',
            isCustomer :'N',
            isOthers : '',
            isActive : 'Y',
            vendorLocation : '',
            accountPayable : '',
            customerPayment : '',
            vendorCreditLimit : '',
            shipAddress : '',
            deliveryAddress : '',
            billingAddress : '',
            deliveryMethod : '',
            internalNotes : '',
            vendorPaymentTerm : '',
            /*responsiblePersonPurchase : '',*/
            screenName : 'manageVendor',

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
        $scope.edit = false;

        /**
         * Dropdown Datas ********************************
         */

        /**
         * Dropdown functionality
         */

        $scope.getDropdownValue = function() {
            $http.get('app/exchangerate/getCurrencyList').success(function(datas) {
                $scope.currencyList = datas.currencyList;
            }).error(function(data) {
            });

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

        $scope.isNumericValidation = function(evt) {
            evt = (evt) ? evt : window.event;
            var charCode = (evt.which) ? evt.which : evt.keyCode;
            if (charCode > 31 && (charCode < 48 || charCode > 57)) {
                return false;
            }
            return true;
        }

        /**
         * onChange City, fetch into to respective state,country,pinCode
         */
        $scope.$watch('manageVendorObj.cityId', function(newValue, oldValue) {
            if (newValue != '' && newValue != undefined) {
                $scope.onChangeMainCity($scope.manageVendorObj.cityId);
            }
        });

        /**
         * shipping address - city Id Change
         */

        $scope.$watch('manageVendorObj.customerAddressobj[0].cityAddressId', function(newValue, oldValue) {
            if (newValue != '' && newValue != undefined) {

                $scope.onChangeMainCityshipping($scope.manageVendorObj.customerAddressobj[0].cityAddressId);
            }
        });
        /**
         * delivery address - city Id Change
         */
        $scope.$watch('manageVendorObj.customerAddressobj[1].citydeliveryId', function(newValue, oldValue) {
            if (newValue != '' && newValue != undefined) {
                $scope.onChangeMainCitydelivery($scope.manageVendorObj.customerAddressobj[1].citydeliveryId);
            }
        });
        /**
         * billing address - city Id Change
         */
        $scope.$watch('manageVendorObj.customerAddressobj[2].citybillingId', function(newValue, oldValue) {
            if (newValue != '' && newValue != undefined) {
                $scope.onChangeMainCitybilling($scope.manageVendorObj.customerAddressobj[2].citybillingId);
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
                            $scope.manageVendorObj.desStateCode = datas.lManageCustomerBean[key].stateCode;
                            $scope.manageVendorObj.desState = datas.lManageCustomerBean[key].stateName;
                            $scope.manageVendorObj.desZipcode = datas.lManageCustomerBean[key].pincode;
                            $scope.manageVendorObj.desCountry = datas.lManageCustomerBean[key].countryName;
                            $scope.manageVendorObj.desCountryCode = datas.lManageCustomerBean[key].countryCode;

                        });
                    } else {
                        $scope.manageVendorObj.desStateCode = '';
                        $scope.manageVendorObj.desState = '';
                        $scope.manageVendorObj.desZipcode = '';
                        $scope.manageVendorObj.desCountryCode = '';
                        $scope.manageVendorObj.desCountry = '';
                    }
                }).error(function(data) {
                });
            } else {
                $scope.manageVendorObj.desStateCode = '';
                $scope.manageVendorObj.desState = '';
                $scope.manageVendorObj.desZipcode = '';
                $scope.manageVendorObj.desCountryCode = '';
                $scope.manageVendorObj.desCountry = '';
            }
        }

        /**
         * Shipping Address
         */
        $scope.onChangeMainCityshipping = function(cityshippingId) {
            if (cityshippingId != '' && cityshippingId != undefined) {

                $http.get('app/customerMaster/getCityStateCountryList?cityId=' + cityshippingId).success(function(datas) {

                    if (datas.lManageCustomerBean.length > 0) {
                        angular.forEach(datas.lManageCustomerBean, function(item, key) {
                            $scope.manageVendorObj.customerAddressobj[0].addressType = 130;
                            $scope.manageEntityObj.stateCodeAddress = datas.lManageCustomerBean[key].stateCode;
                            $scope.manageEntityObj.stateNameAddress = datas.lManageCustomerBean[key].stateName;
                            $scope.manageEntityObj.pincodeAddress = datas.lManageCustomerBean[key].pincode;
                            $scope.manageEntityObj.countryCodeAddress = datas.lManageCustomerBean[key].countryCode;
                            $scope.manageEntityObj.countryNameAddress = datas.lManageCustomerBean[key].countryName;
                        });
                    } else {
                        $scope.manageVendorObj.customerAddressobj[0].addressType = '';
                        $scope.manageEntityObj.stateCodeAddress = '';
                        $scope.manageEntityObj.stateNameAddress = '';
                        $scope.manageEntityObj.pincodeAddress = '';
                        $scope.manageEntityObj.countryCodeAddress = '';
                        $scope.manageEntityObj.countryNameAddress = '';
                    }

                }).error(function(data) {
                });

            } else {
                $scope.manageVendorObj.customerAddressobj[0].addressType = '';
                $scope.manageEntityObj.stateCodeAddress = '';
                $scope.manageEntityObj.stateNameAddress = '';
                $scope.manageEntityObj.pincodeAddress = '';
                $scope.manageEntityObj.countryCodeAddress = '';
                $scope.manageEntityObj.countryNameAddress = '';
            }
        }
        /**
         * Delivery Address
         */
        $scope.onChangeMainCitydelivery = function(citydeliveryId) {
            if (citydeliveryId != '' && citydeliveryId != undefined) {

                $http.get('app/customerMaster/getCityStateCountryList?cityId=' + citydeliveryId).success(function(datas) {

                    if (datas.lManageCustomerBean.length > 0) {
                        angular.forEach(datas.lManageCustomerBean, function(item, key) {
                            $scope.manageVendorObj.customerAddressobj[1].addressType = 131;
                            $scope.manageEntityObj.stateCodedelivery = datas.lManageCustomerBean[key].stateCode;
                            $scope.manageEntityObj.stateNamedelivery = datas.lManageCustomerBean[key].stateName;
                            $scope.manageEntityObj.pincodedelivery = datas.lManageCustomerBean[key].pincode;
                            $scope.manageEntityObj.countryCodedelivery = datas.lManageCustomerBean[key].countryCode;
                            $scope.manageEntityObj.countryNamedelivery = datas.lManageCustomerBean[key].countryName;
                        });
                    } else {
                        $scope.manageVendorObj.customerAddressobj[1].addressType = '';
                        $scope.manageEntityObj.stateCodedelivery = '';
                        $scope.manageEntityObj.stateNamedelivery = '';
                        $scope.manageEntityObj.pincodedelivery = '';
                        $scope.manageEntityObj.countryCodedelivery = '';
                        $scope.manageEntityObj.countryNamedelivery = '';
                    }

                }).error(function(data) {
                });

            } else {
                $scope.manageVendorObj.customerAddressobj[1].addressType = '';
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
                            $scope.manageVendorObj.customerAddressobj[2].addressType = 132;
                            $scope.manageEntityObj.stateCodeBilling = datas.lManageCustomerBean[key].stateCode;
                            $scope.manageEntityObj.stateNameBilling = datas.lManageCustomerBean[key].stateName;
                            $scope.manageEntityObj.pincodeBilling = datas.lManageCustomerBean[key].pincode;
                            $scope.manageEntityObj.countryCodeBilling = datas.lManageCustomerBean[key].countryCode;
                            $scope.manageEntityObj.countryNameBilling = datas.lManageCustomerBean[key].countryName;
                        });
                    } else {
                        $scope.manageVendorObj.customerAddressobj[2].addressType = '';
                        $scope.manageEntityObj.stateCodeBilling = '';
                        $scope.manageEntityObj.stateNameBilling = '';
                        $scope.manageEntityObj.pincodeBilling = '';
                        $scope.manageEntityObj.countryCodeBilling = '';
                        $scope.manageEntityObj.countryNameBilling = '';
                    }

                }).error(function(data) {
                });

            } else {
                $scope.manageVendorObj.customerAddressobj[2].addressType = '';
                $scope.manageEntityObj.stateCodeBilling = '';
                $scope.manageEntityObj.stateNameBilling = '';
                $scope.manageEntityObj.pincodeBilling = '';
                $scope.manageEntityObj.countryCodeBilling = '';
                $scope.manageEntityObj.countryNameBilling = '';
            }
        }

        $scope.supplier = function(supplier) {
            if (supplier == 'N') {
                $('#purchaseTab').hide();
                $('#supplierId').hide();

            } else {
                $('#purchaseTab').show();
                $('#supplierId').show();
            }
        }

        $scope.validateEmail = function(email) {
            var reg = /^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/
            if (reg.test(email)) {
                return true;
            } else {
                return false;
            }
        }

        /**
         * validation
         */
        $scope.validate = function(manageCustomerAddForm) {
            debugger;
            var flag = true;
            if (new validationService().checkFormValidity(manageCustomerAddForm)) {

                if ($scope.manageVendorObj.email == "") {
                    $scope.save(manageCustomerAddForm);
                } else {
                    flag = $scope.validateEmail($scope.manageVendorObj.email);
                    if (flag == true) {
                        $scope.save(manageCustomerAddForm);
                    } else {
                        logger.logError("Please Enter Valid Email");
                    }
                }

            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.manageCustomerAddForm.$validationSummary), 555000, 'trustedHtml');
            }
        };

        $scope.validateMobileNo = function(mobile) {
            if (mobile != "") {
                if (mobile.length < 10) {
                    logger.logError("Mobile Number Should be 10 Digit!");
                    $scope.manageVendorObj.mobile = '';
                }
            }
        };

        $scope.validatePhoneNo = function(phone) {
            if (phone != "") {
                if (phone.length < 8) {
                    logger.logError("Phone Number Should be 8 Digit!");
                    $scope.manageVendorObj.phoneNo = '';
                }
            }
        };

        /**
         * save functionality *************************
         */
        $scope.save = function(manageSupplierAddForm) {

            var manageSupplierMasterData = $scope.manageVendorObj;

            if ($scope.edit == false) {
                $http.post('app/customerMaster/save', $scope.manageVendorObj).success(function(result) {
                    if (result) {
                        logger.logSuccess("Saved Successfully!");
                        $location.path('master/vendor/list');
                    } else {
                        logger.logError("Supplier Code Already Exist!");
                    }
                }).error(function(result) {
                });
            } else {
                $http.post('app/customerMaster/update', $scope.manageVendorObj).success(function(result) {
                    if (result) {
                        logger.logSuccess("Updated Successfully!");
                        $location.path('master/vendor/list');
                        
                    } else {
                        logger.logError("Supplier Code Already Exist!");
                    }
                }).error(function(result) {
                });
            }

        };

        $scope.editVendorDtl = function() {

            $http.get('app/customerMaster/getCustomerDataOnEdit?entityId=' + entityId + '&screenName=' + screenName).success(function(data) {
                $scope.edit = true;
                $scope.manageVendorObj.entityId = entityId;
                $scope.manageVendorObj.contactPerson = data.contactPerson;
                $scope.manageVendorObj.entityName = data.entityName;
                $scope.manageVendorObj.jobPosition = data.jobPosition;
                $scope.manageVendorObj.locationAddress = data.locationAddress;
                $scope.manageVendorObj.phoneNo = data.phoneNo;
                $scope.manageVendorObj.mobile = data.mobile;
                $scope.manageVendorObj.email = data.email;
                $scope.manageVendorObj.fax = data.fax;
                $scope.manageVendorObj.supplierAcctCode = data.supplierAcctCode;
                if (data.currencyCode != undefined && data.currencyCode != null && data.currencyCode != '') {
                    $scope.manageVendorObj.currencyCode = data.currencyCode;
                } else {
                    $scope.manageVendorObj.currencyCode = "";
                }
                $scope.manageVendorObj.tinNumber = data.tinNumber;
                $scope.manageVendorObj.cstNumber = data.cstNumber;
                $scope.manageVendorObj.gstNumber = data.gstNumber;

                $scope.manageVendorObj.desStateCode = data.desStateCode;
                $scope.manageVendorObj.desState = data.desState;
                $scope.manageVendorObj.desZipcode = data.desZipcode;
                $scope.manageVendorObj.desCountry = data.desCountry;
                $scope.manageVendorObj.cityId = data.cityId;
                $scope.manageVendorObj.panNumber = data.panNumber;
                $scope.manageVendorObj.addressId = data.addressId;
                $scope.manageVendorObj.isVendor = data.isVendor;
                $scope.manageVendorObj.isCollege = data.isCollege;
                $scope.manageVendorObj.isCustomer = data.isCustomer;
                $scope.manageVendorObj.isVendor = data.isVendor;
                $scope.manageVendorObj.isCustomer = data.isCustomer;
                $scope.manageVendorObj.shipAddress = data.shipAddress;
                $scope.manageVendorObj.deliveryAddress = data.deliveryAddress;
                $scope.manageVendorObj.billingAddress = data.billingAddress;
                $scope.manageVendorObj.isOthers = data.isOthers;
                $scope.manageVendorObj.isActive = data.isActive;
                $scope.manageVendorObj.deliveryMethod = data.deliveryMethod;
                $scope.manageVendorObj.customerContactobj = data.customerContactobj;
                $scope.manageVendorObj.customerBankobj = data.customerBankobj;
                $scope.manageVendorObj.internalNotes = data.internalNotes;
                $scope.manageVendorObj.vendorPaymentTerm = data.vendorPaymentTerm;
                $scope.manageVendorObj.accountPayable = data.accountPayable;
                $scope.manageVendorObj.customerPayment = data.customerPayment;
                $scope.manageVendorObj.vendorCreditLimit = data.vendorCreditLimit;
               /* if (data.responsiblePersonPurchase != undefined && data.responsiblePersonPurchase != null && data.responsiblePersonPurchase != '') {
                    $scope.manageVendorObj.responsiblePersonPurchase = data.responsiblePersonPurchase;
                } else {
                    $scope.manageVendorObj.responsiblePersonPurchase = '';
                }*/

                $scope.manageVendorObj.website = data.website;
                $scope.manageVendorObj.vendorLocation = data.vendorLocation;
                $scope.vendorOldName = data.entityName;
                $scope.manageVendorObj.customerAddressobj = [ {
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
                $scope.manageVendorObj.screenName = "manageVendor";
                if (data.isActive == "t") {
                    $scope.manageVendorObj.isActive = 'Y';
                } else {
                    $scope.manageVendorObj.isActive = 'N';
                }
                if (data.isCustomer == "t") {
                    $scope.manageVendorObj.isCustomer = 'Y';
                } else {
                    $scope.manageVendorObj.isCustomer = 'N';
                }
                if (data.isVendor == "t") {
                    $scope.manageVendorObj.isVendor = 'Y';
                } else {
                    $scope.manageVendorObj.isVendor = 'N';
                }
                if (data.isCollege == "t") {
                    $scope.manageVendorObj.isCollege = 'Y';
                } else {
                    $scope.manageVendorObj.isCollege = 'N';
                }
                if (data.isOthers == "t") {
                    $scope.manageVendorObj.isOthers = 'Y';
                } else {
                    $scope.manageVendorObj.isOthers = 'N';
                }

                if (data.customerAddressobj != undefined && data.customerAddressobj != null && data.customerAddressobj != '') {

                    angular.forEach(data.customerAddressobj, function(value, index1) {
                        if (value.addressType == 130) {
                            $scope.manageVendorObj.shipAddress = value.shipAddress;
                            $scope.manageVendorObj.customerAddressobj[0].cityAddressId = value.cityAddressId;
                            $scope.manageVendorObj.customerAddressobj[0].entityAddressId = value.entityAddressId;
                            $scope.manageVendorObj.customerAddressobj[0].shipAddress = value.shipAddress;
                            $scope.manageVendorObj.customerAddressobj[0].shipAddressId = value.shipAddressId;

                        }
                        if (value.addressType == 131) {
                            $scope.manageVendorObj.deliveryAddress = value.deliveryAddress;
                            $scope.manageVendorObj.customerAddressobj[1].citydeliveryId = value.citydeliveryId;
                            $scope.manageVendorObj.customerAddressobj[1].entityAddressId = value.entityAddressId;
                            $scope.manageVendorObj.customerAddressobj[1].deliveryAddress = value.deliveryAddress;
                            $scope.manageVendorObj.customerAddressobj[1].deliveryAddressId = value.deliveryAddressId;
                        }
                        if (value.addressType == 132) {
                            $scope.manageVendorObj.billingAddress = value.billingAddress;
                            $scope.manageVendorObj.customerAddressobj[2].citybillingId = value.citybillingId;
                            $scope.manageVendorObj.customerAddressobj[2].billingAddress = value.billingAddress;
                            $scope.manageVendorObj.customerAddressobj[2].shipAddress = value.shipAddress;
                            $scope.manageVendorObj.customerAddressobj[2].billingAddressId = value.billingAddressId;
                        }
                    });

                } else {
                    $scope.manageVendorObj.customerAddressobj = [ {
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

        /**
         * Reset Functionality ******************************
         */

        var originalDatas = angular.copy($scope.manageVendorObj);
        var originalAddrDatas = angular.copy($scope.manageEntityObj);

        $scope.reset = function() {

            if ($scope.edit == false) {
                $scope.manageVendorObj = angular.copy(originalDatas);
                $scope.manageEntityObj = angular.copy(originalAddrDatas);
                $scope.manageCustomerAddForm.$setPristine();

            } else {
                $scope.editVendorDtl();
            }
        }

        // remove Row
        $scope.deleteAddressRow = function() {

            $scope.tablerow = [];
            angular.forEach($scope.manageVendorObj.customerContactobj, function(tables, index) {
                if (tables.select == true) {
                } else {
                    $scope.tablerow.push(tables);
                }
            });
            $scope.manageVendorObj.customerContactobj = $scope.tablerow;
        };

        // remove Row
        $scope.deleteBankRow = function() {

            $scope.tablerow = [];
            angular.forEach($scope.manageVendorObj.customerBankobj, function(tables, index) {
                if (tables.select == true) {
                } else {
                    $scope.tablerow.push(tables);
                }
            });
            $scope.manageVendorObj.customerBankobj = $scope.tablerow;
        };

        /***********************************************************************
         * Edit Functionality *******************************
         */
        var entityId = $stateParams.entityId;
        var screenName = "manageVendor";
        if (entityId != undefined && entityId != null && entityId != "") {
            $scope.editVendorDtl();
        }

        $scope.addNewAccountingDialog = function() {
            $scope.callAccountingDialog($scope, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope);
        };

        $scope.addNewContactDialog = function() {
            $scope.callContactDialog($scope, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope);
        };

        $scope.callAccountingDialog = function($scope, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope) {
        	   ngDialog.open({
                scope : $scope,
                template : 'views/sea/vendor/vendorBankAdd',
                controller : $controller('manageVendorAddBankCtrl', {
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
                template : 'views/sea/vendor/vendorAddressAdd',
                
                controller : $controller('manageVendorAddAddressCtrl', {
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

    });

    app.controller('manageVendorAddBankCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {
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
                // $scope.sessionName(userId);
            });

        };
        $scope.paymentList();
        
        
        
       /* $scope.paymentList = [ {
       	 
            id : '103',
            text : 'Saving Account'
        }, {
            id : '104',
            text : 'Other Account'
        },
        {
            id : '105',
            text : 'Current Account'
        }
        ]*/
        
       

        $scope.$watch('customerBankobj.bankCityId', function(newValue, oldValue) {
            debugger;
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

            $scope.manageVendorObj.customerBankobj.push($scope.customerBankobj);
            ngDialog.close();
        };

        $scope.cancelBank = function() {
            ngDialog.close();
        };

        $scope.cancelBank = function() {
            ngDialog.close();
        };

    });

    app.controller('manageVendorAddAddressCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {

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

        $scope.validateEmail = function(email) {
            var reg = /^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/
            if (reg.test(email)) {
                return true;
            } else {
                return false;
            }
        }

        /**
         * save Contact Row Dialog Datas into Contact tab detail..
         */

        $scope.saveRowContact = function() {

            var flag = true;
            var mblflag = true;
            var pheflag = true;
            if ($scope.customerContactobj.email != undefined && $scope.customerContactobj.email != '' && $scope.customerContactobj.email != null) {
                flag = $scope.validateEmail($scope.customerContactobj.email);
                if (flag == true) {
                } else {
                    logger.logError("Please Enter Valid Email Address");
                }
            }
            if ($scope.customerContactobj.mobile != undefined && $scope.customerContactobj.mobile != '' && $scope.customerContactobj.mobile != null) {
                if ($scope.customerContactobj.mobile.length == 10) {
                } else {
                    mblflag = false;
                    logger.logError("Mobile number should be 10 digit");
                }
            }
            if ($scope.customerContactobj.phone != undefined && $scope.customerContactobj.phone != '' && $scope.customerContactobj.phone != null) {
                if ($scope.customerContactobj.phone.length == 10) {
                } else {
                    pheflag = false;
                    logger.logError("Phone number should be 10 digit");
                }
            }
            if (flag == true && mblflag == true && pheflag == true) {
                $scope.manageVendorObj.customerContactobj.push({
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
            }
        }

    });
    app.directive('phonenumbersOnly', function(logger) {
        return {
            require : 'ngModel',
            link : function(scope, element, attrs, modelCtrl) {

                modelCtrl.$parsers.push(function(inputValue) {
                    var inputValue = modelCtrl.$viewValue;
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
