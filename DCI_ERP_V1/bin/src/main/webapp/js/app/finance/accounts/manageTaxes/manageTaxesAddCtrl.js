define([ 'hospital/accounts/accounts' ], function(module) {

    'use strict';

    module.registerController('manageTaxesAddCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, $stateParams, $filter, validationService) {
        $scope.edit = false;
        $scope.manageTax = {
            taxId : '',
            taxName : '',
            taxTypeId : '',
            taxType : '',
            taxMethodId : '',
            taxMethod : '',
            taxFixedAmount : '',
            taxMethodAmount : '',
            taxPercentage : '',
            taxAccount : '',
            isactive : false,
            subTaxId : '',
            subTaxName : '',
            code : ''
        };

        $scope.ValueList = [];
        $scope.ValueList1 = [];
        $scope.SubTaxList = [];
        $scope.taxAccountList = [];

        $scope.onchange2 = function() {
            $('#percentage').hide();
        };

        $('#percentage').hide();
        $('#salesType').show();
        $('#purchaseType').hide();
        $('#serviceType').hide();

        /**
         * Dropdown
         */
        $scope.valueList = function() {
            $http.get("hospital/accounts/manageTax/methodList").success(function(response) {
                $scope.ValueList = response.valueList; // Tax Method
            });

            $http.get("hospital/accounts/manageTax/acctList?subGrp=4010").success(function(response) {
                $scope.taxAccountList = response.acctList; // Tax Account List
                                                            // with 4010
                                                            // subgroup
            });
            $http.get("hospital/accounts/manageTax/subTaxList").success(function(response) {
                $scope.SubTaxList = response.subTaxList;
            });
        };
        $scope.valueList();

        $scope.changeAmountDiscount = function(taxMethodAmount) {

            if ($scope.manageTax.taxMethodId == 10) {
                if (taxMethodAmount <= 0) {
                    logger.logError("Tax Amount should not be greater than 0!");
                    $scope.manageTax.taxMethodAmount = '';
                }
            } else if (taxMethodAmount > 100) {
                logger.logError("Tax Discount Percentage should not be greater than 100!");
                $scope.manageTax.taxMethodAmount = '';
            }
        }

        $scope.typeList = function() {
            $http.get("hospital/accounts/manageTax/typeList").success(function(response) {
                $scope.ValueList1 = response.typeList; // Tax Type Field
            });
        };
        $scope.typeList();

        var taxMethod = "";
        var taxType = "";
        $scope.onchange1 = function(taxMethodId) {
            var taxMethodId = $scope.manageTax.taxMethodId;
            angular.forEach($scope.ValueList, function(value, key) {
                if (taxMethodId == value.taxMethodId) {
                    taxMethod = value.taxMethod;
                }
            });
            if (taxMethod == "Percentage") {
                $('#percentage').show();
                $scope.manageTax.taxMethodAmount = '';
            } else if (taxMethod != "Percentage") {
                $('#percentage').hide();
                $scope.manageTax.taxMethodAmount = '';
            }
        };

        /**
         * tax type - on change
         */
        $scope.focusTypes = function(taxTypeId) {
            var taxTypeId1 = taxTypeId;
            $scope.haveCode = false;
            $http.get("hospital/accounts/manageTax/checkAccount?taxTypeId=" + taxTypeId + "&formCode=tax").success(function(response) {
                if (response.accountCode != undefined && response.accountCode != null && response.accountCode != 0) {

                    angular.forEach($scope.taxAccountList, function(value, key) {
                        if (response.accountCode == value.id) {
                            $scope.manageTax.taxAccount = value.id;
                            $scope.manageTax.acctName = value.text;
                            $scope.haveCode = true;
                        }
                    });
                } else {
                    $scope.manageTax.taxAccount = '';
                    $scope.manageTax.acctName = '';
                }
            });

            if (taxTypeId1 == 11) {
                $('#salesType').show();
                $('#purchaseType').hide();
                $('#serviceType').hide();
            } else if (taxTypeId1 == 12) {
                $('#purchaseType').show();
                $('#salesType').hide();
                $('#serviceType').hide();
            } else if (taxTypeId1 == 13) {
                $('#serviceType').show();
                $('#purchaseType').hide();
                $('#salesType').hide();
            }
        };

        // manageTax.subTaxId
        $scope.isSubTaxPercentage = false;
        $scope.loadChildTaxDetails = function() {
            $scope.$watch("manageTax.subTaxId", function(newValue, oldValue) {
                if (newValue != "" && newValue != undefined && newValue != null) {
                    $http.get('hospital/accounts/manageTax/getChildTaxDetails?subTaxId=' + newValue).success(function(data) {
                        if (data.manageTax.subTaxMethod == "Percentage") {

                            $scope.subTaxMethod = data.manageTax.subTaxMethod;
                            $scope.subTaxValue = data.manageTax.subTaxPercentage;
                            $scope.isSubTaxPercentage = true;
                        } else if (data.manageTax.subTaxMethod == "Fixed Amount") {
                            $scope.subTaxMethod = data.manageTax.subTaxMethod;
                            $scope.subTaxValue = data.manageTax.subTaxAmount;
                            $scope.isSubTaxPercentage = false;
                        }
                    }).error(function(datas) {
                    });
                } else {

                }
            });
        }
        // Top find which object Property is Updated
        var manageTaxObj = angular.copy($scope.manageTax, manageTaxObj);
        var arrayOfValues = Object.keys(manageTaxObj);
        $scope.checkWhichVariableHasUpdated = function(watchGroupList, newValuesObj, oldValuesObj) {
            var _lastUpdatedValue = null;
            angular.forEach(watchGroupList, function(value) {
                if (newValuesObj[value] != oldValuesObj[value])
                    _lastUpdatedValue = value;
            });
            $scope.selectedObj = newValuesObj;
            return _lastUpdatedValue;
        };

        // To load Dependent DropDown
        $scope.loadDropDown = function(changedVariable) {
            switch (changedVariable) {
            case "subTaxId": // Child Tax Dropdown
                $scope.loadChildTaxDetails();
                break;
            }
        };

        // To watch a Object Collection
        $scope.$watchCollection('manageTax', function(newVal, oldVal) {
            if (newVal != undefined) {
                var last_changed = $scope.checkWhichVariableHasUpdated(arrayOfValues, newVal, oldVal);
                if (angular.isDefined(last_changed) && last_changed != null) {
                    $scope.loadDropDown(last_changed);
                }
            }
        }, true);

        // Save functionality
        $scope.save = function(manageTaxForm, manageTax) {
            if (new validationService().checkFormValidity($scope.manageTaxForm)) {
                $http.post("hospital/accounts/manageTax/save", manageTax).success(function(response) {
                    if (response.success) {
                        logger.logSuccess("Saved Successfully!");
                        $state.go("app.hospital.accounts.manageTaxes.list");
                    } else {
                        logger.logError(response.errors[0]);
                    }
                });
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.manageTaxForm.$validationSummary), 555000, 'trustedHtml');
            }
        };

        // Edit functionality
        var taxId = $location.search().taxId;
        if (taxId == undefined || taxId == null || taxId == "") {
            $scope.edit = false;
        } else {
            $scope.edit = true;
            $http.post("hospital/accounts/manageTax/edit", taxId).success(function(response) {
                if (response) {

                    $scope.manageTax = response;
                    if (response.taxAccount != null)
                        $scope.manageTax.taxAccount = response.taxAccount;
                    $scope.loadChildTaxDetails();
                    $scope.focusTypes(response.taxTypeId);
                }
            }).error(function(data) {
                logger.logError("Unable to fetch");
            });

        }

        // Update functionality
        $scope.update = function(manageTaxForm, manageTax) {

            if (new validationService().checkFormValidity($scope.manageTaxForm)) {
                $http.post('hospital/accounts/manageTax/update', manageTax).success(function(result) {
                    if (result == true) {
                        logger.logSuccess("Updated Successfully!");
                        $state.go('app.hospital.accounts.manageTaxes.list');
                    } else {
                        logger.logError("Error In Update!");
                    }
                }).error(function(result) {
                });

            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.manageTaxForm.$validationSummary), 555000, 'trustedHtml');
            }
        };

        // Cancel functionality
        $scope.cancel = function() {
            $state.go("app.hospital.accounts.manageTaxes.list");
        };

        $scope.onChangeNumber = function(num) {
            num = num.replace(/[^0-9 .]/g, '');
            $('#taxMethodAmount').val(num);
            return num;
        }

        // Reset functionality
        $scope.reset = function(manageTaxForm) {
            if ($scope.manageTax.edit != true) {
                $scope.manageTax.code = '';
                $scope.manageTax.taxName = '';
                $scope.manageTax.taxMethodId = '';
                $scope.manageTax.taxMethodAmount = '';
                $scope.manageTax.taxTypeId = '';
                $scope.manageTax.taxAccount = '';
                $scope.manageTax.isactive = false;
                $scope.onchange2();
                $scope.typeList();
                $('#salesType').show();
                $('#purchaseType').hide();
                $('#serviceType').hide();
            } else {
                $http.post("hospital/accounts/manageTax/edit", $scope.manageTax.taxId).success(function(response) {
                    $scope.manageTax = response;
                    $scope.onchange1(response.taxMethodId);
                    $scope.focusTypes(response.taxTypeId);
                });
            }
        };

    });

});