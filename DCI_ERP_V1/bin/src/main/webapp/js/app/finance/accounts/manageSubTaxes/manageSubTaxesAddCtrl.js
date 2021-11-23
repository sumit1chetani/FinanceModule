define([ 'hospital/accounts/accounts' ], function(module) {

    'use strict';

    module.registerController('manageSubTaxesAddCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, $stateParams, $filter, validationService) {

        $scope.manageSubTax = {
            subTaxId : '',
            subTaxCode : '',
            subTaxName : '',
            subTaxTypeId : '',
            subTaxType : '',
            subTaxMethodId : '',
            subTaxMethod : '',
            subTaxMethodAmount : '',
            subTaxAccount : '',
            isactive : false,
            edit : false

        };

        $scope.validate = function(manageSubTaxForm) {
            if (new validationService().checkFormValidity($scope.manageSubTaxForm)) {
                if (!$scope.manageSubTax.edit) {
                    if ($scope.verifyUniqueTaxCode($scope.manageSubTax.subTaxCode) && $scope.verifyUniqueTaxName($scope.manageSubTax.subTaxName))
                        $scope.save(manageSubTaxForm);
                } else {
                    $scope.update(manageSubTaxForm);
                }
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.manageSubTaxForm.$validationSummary), 555000, 'trustedHtml');
            }
        };

        $scope.ValueList = [];
        $scope.ValueList1 = [];

        $scope.manageSubTax = {
            subTaxId : '',
            subTaxCode : '',
            subTaxName : '',
            subTaxTypeId : '',
            subTaxType : '',
            subTaxMethodId : '',
            subTaxMethod : '',
            subTaxMethodAmount : '',
            subTaxAccount : '',
            isactive : false,
            edit : false

        };

        $scope.onchange2 = function() {
            $('#percentage').hide();
        };

        var subTaxMethod = "";
        var subTaxType = "";

        $('#percentage').hide();
        $('#salesType').show();
        $('#purchaseType').hide();
        $('#serviceType').hide();

        $scope.changeAmountDiscount = function(subTaxMthdAmount) {

            if ($scope.manageSubTax.subTaxMethodId == 10) {
                if (subTaxMthdAmount <= 0) {
                    logger.logError("Tax Amount should not be greater than 0!");
                    $scope.manageSubTax.subTaxMethodAmount = '';
                }
            } else if (subTaxMthdAmount > 100) {
                logger.logError("Tax Discount Percentage should not be greater than 100!");
                $scope.manageSubTax.subTaxMethodAmount = '';
            }
        }

        /**
         * Duplicate
         */
        $scope.verifyUniqueTaxCode = function(taxCode) {

            var flag = true, msg = '';
            angular.forEach($scope.subtaxList, function(key, index) {

                if (taxCode.toLowerCase() == key.subTaxCode.toLowerCase()) {
                    msg = "Sub Tax Code Already Exists..!";
                    flag = false;
                }
            });

            if (!flag) {
                logger.logError(msg);
            }
            return flag;
        };
        $scope.verifyUniqueTaxName = function(taxName) {

            var flag = true, msg = '';
            angular.forEach($scope.subtaxList, function(key, index) {

                if (taxName.toLowerCase() == key.subTaxName.toLowerCase()) {
                    msg = "Sub Tax Name Already Exists..!";
                    flag = false;
                }
            });

            if (!flag) {
                logger.logError(msg);
            }
            return flag;
        };

        // Edit functionality

        var subTaxId = $location.search().subTaxId;
        if (subTaxId != undefined) {
            $http.get("hospital/accounts/manageSubTax/edit?subTaxId=" + subTaxId).success(function(response) {
                if (response.subTaxId != undefined) {
                    if (response.subTaxAccount != undefined && response.subTaxAccount != '') {
                        $scope.haveCode = true;
                    }
                    $scope.manageSubTax = response;
                    $scope.onchange1(response.subTaxMethodId);
                    $scope.focusTypes(response.subTaxTypeId);
                }
            });
        }

        // Save functionality
        var $validationProvider = $injector.get('$validation');
        $scope.save = function(manageSubTaxForm) {
            sharedProperties.clearObject();
            $http.post("hospital/accounts/manageSubTax/save", $scope.manageSubTax).success(function(response) {
                if (response == true) {
                    logger.logSuccess("Saved Successfully!");
                    $state.go("app.hospital.accounts.manageSubTaxes.list");
                } else {
                    logger.logError("Tax Name Already Exists!");
                }
            });

        };

        // Update functionality
        $scope.update = function(manageSubTaxForm) {
            sharedProperties.clearObject();
            var manageSubTax = $scope.manageSubTax;
            if (manageSubTax.edit == true) {
                var updateRow = manageSubTax;
                $http.post('hospital/accounts/manageSubTax/update', updateRow).success(function(result) {
                    if (result) {
                        logger.logSuccess("Updated Successfully!");
                        $state.go('app.hospital.accounts.manageSubTaxes.list');
                    } else {
                        logger.logError("Name already Exist!");
                    }
                }).error(function(result) {
                });

            }
        };

        // Reset functionality
        $scope.reset = function(manageSubTaxForm) {
            if ($scope.manageSubTax.edit != true) {
                $scope.manageSubTax.subTaxCode = '';
                $scope.manageSubTax.subTaxName = '';
                $scope.manageSubTax.subTaxMethodId = '';
                $scope.manageSubTax.subTaxMethodAmount = '';
                $scope.manageSubTax.subTaxTypeId = '';
                $scope.manageSubTax.subTaxAccount = '';
                $scope.manageSubTax.isactive = false;
                $scope.onchange2();
                $scope.typeList();
                $('#salesType').show();
                $('#purchaseType').hide();
                $('#serviceType').hide();
            } else {
                $http.get("hospital/accounts/manageSubTax/edit?subTaxId=" + $scope.manageSubTax.subTaxId).success(function(response) {
                    if (response.subTaxId != undefined) {
                        $scope.manageSubTax = response;
                        $scope.onchange1(response.subTaxMethodId);
                        $scope.focusTypes(response.subTaxTypeId);
                    }

                });
            }
        };

        // Cancel functionality
        $scope.cancel = function() {
            $state.go("app.hospital.accounts.manageSubTaxes.list");
        };

        $scope.taxAccountList = [];
        $scope.subtaxList = [];
        $scope.valueList = function() {
            $http.get("hospital/accounts/manageSubTax/methodList").success(function(response) {
                $scope.ValueList = response.valueList;
            });

            $http.get("hospital/accounts/manageTax/acctList?subGrp=4011").success(function(response) {
                $scope.taxAccountList = response.acctList;
            });

            $http.get("hospital/accounts/manageSubTax/list").success(function(response) {
                $scope.subtaxList = response.subTaxList;
            });

        };
        $scope.valueList();

        $scope.onchange1 = function(subTaxMethodId) {
            var subTaxMethodID = $scope.manageSubTax.subTaxMethodId;
            angular.forEach($scope.ValueList, function(value, key) {
                if (subTaxMethodID == value.subTaxMethodId) {
                    subTaxMethod = value.subTaxMethod;
                }

            });
            if (subTaxMethod == "Percentage") {
                $('#percentage').show();
                $scope.manageSubTax.subTaxMethodAmount = '';
            } else if (subTaxMethod != "Percentage") {
                $('#percentage').hide();
                $scope.manageSubTax.subTaxMethodAmount = '';
            }
        };

        $scope.typeList = function() {
            $http.get("hospital/accounts/manageSubTax/typeList").success(function(response) {
                $scope.ValueList1 = response.typeList;
                if ($scope.manageSubTax.edit == false) {
                    $scope.focusTypes($scope.manageSubTax.subTaxTypeId);
                }

            });
        };
        $scope.typeList();

        $scope.focusTypes = function(subTaxTypeId) {

            var subTaxTypeId = $scope.manageSubTax.subTaxTypeId;
            $scope.haveCode = false;

            if (subTaxTypeId != undefined) {
                $http.get("hospital/accounts/manageTax/checkAccount?taxTypeId=" + subTaxTypeId + "&formCode=subTax").success(function(response) {
                    if (response.accountCode != undefined && response.accountCode != null && response.accountCode != 0) {

                        angular.forEach($scope.taxAccountList, function(value, key) {
                            if (response.accountCode == value.acctCode) {

                                $scope.manageSubTax.subTaxAccount = value.accountCode;
                                $scope.manageSubTax.acctName = value.acctName;
                                $scope.haveCode = true;
                            }
                        });

                    } else {
                        $scope.manageSubTax.subTaxAccount = '';
                        $scope.manageSubTax.acctName = '';
                    }
                });
            }

            if (subTaxTypeId == 11) {
                $('#salesType').show();
                $('#purchaseType').hide();
                $('#serviceType').hide();
            } else if (subTaxTypeId == 12) {
                $('#purchaseType').show();
                $('#salesType').hide();
                $('#serviceType').hide();
            } else if (subTaxTypeId == 13) {
                $('#serviceType').show();
                $('#purchaseType').hide();
                $('#salesType').hide();
            }
        };

        $scope.onChangeNumber = function(num) {
            num = num.replace(/[^0-9 .]/g, '');
            $('#subTaxAmount').val(num);
            return num;
        }

    });

});