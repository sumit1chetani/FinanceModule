define([ 'hospital/accounts/accounts' ], function(module) {

    'use strict';
    module.registerController('salesorderAddCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, $filter, $stateParams, validationService) {

        $scope.cancel = function() {

            $state.go("app.hospital.accounts.salesorder.list");
        }

        $scope.salesOrder = {
            salesOrderId : 0,
            salesOrderNo : '',
            salesOrderDate : '',
            haspitalCode : '',
            haspitalName : '',
            employeeId : '',
            employeeName : '',
            customerCode : '',
            customerName : '',
            jobTitleCode : '',
            jobTitleName : '',
            billingAddress : '',
            billingCity : '',
            billingState : '',
            billingCountry : '',
            billingCityCode : '',
            billingStateCode : '',
            billingCountryCode : '',
            billingPinCode : '',
            contactPerson : '',
            deliveryAddress : '',
            deliveryCity : '',
            deliveryCityCode : '',
            deliveryState : '',
            deliveryCountry : '',
            deliveryPinCode : '',
            deliveryStateCode : '',
            deliveryCountryCode : '',
            deliveryPinCodeCode : '',
            status : '',
            customerNote : '',
            totalTax : '',
            totalAmount : '',
            netAmount : '',
            salesOrderTables : []
        }

        // load table

        $scope.loadcreditTable = function() {
            var salesTable = {
                salesOrderDtlId : 0,
                itemId : '',
                itemCode : '',
                itemName : '',
                itemDesc : '',
                itemCategory : '',
                itemCategoryId : '',
                taxCode : '',
                taxId : '',
                unit : '',
                unitId : '',
                qty : '',
                taxPercent : 0,
                price : '',
                amount : '',
                taxAmount : ''
            };

            $scope.salesOrder.salesOrderTables.push(salesTable);
        }
        $scope.loadcreditTable();

        // add Row
        $scope.addsalesRow = function(tables) {
            var salesTable = {
                salesOrderDtlId : 0,
                itemId : '',
                itemCode : '',
                itemName : '',
                itemDesc : '',
                itemCategory : '',
                itemCategoryId : '',
                taxCode : '',
                taxId : '',
                unit : '',
                unitId : '',
                qty : '',
                taxPercent : 0,
                price : '',
                amount : '',
                taxAmount : ''
            };
            var len = tables.length;
            var table = {
                rowheader : []
            };
            tables.push(salesTable);
            $scope.calculateTotalAmount($scope.salesOrder.salesOrderTables);
        };

        $scope.removesalesRow = function(table) {
            $scope.tablerow = [];
            var isItem = false;
            angular.forEach(table, function(row, index) {
                var check = row.select;
                if (check == true) {
                    isItem = true;
                }
            });
            if (isItem == false) {
                logger.logError("Please select atleast one item to delete");
            }

            angular.forEach(table, function(row, index) {
                var check = row.select;
                if (check == undefined || check == "" || check == false) {
                    $scope.tablerow.push(row);
                }
            });
            $scope.salesOrder.salesOrderTables = $scope.tablerow;
            $scope.calculateTotalAmount($scope.salesOrder.salesOrderTables);
        };

        var currentDate = new Date();
        currentDate = ('0' + currentDate.getDate()).slice(-2) + "/" + ('0' + (Number(currentDate.getMonth()) + 1)).slice(-2) + "/" + currentDate.getFullYear();
        $scope.salesOrder.salesOrderDate = currentDate;

        $scope.validate = function(salesOrderForm, salesOrderObj) {
            if (new validationService().checkFormValidity($scope.salesOrderForm)) {
                if (!$scope.isEdit) {
                    $scope.save();
                } else {
                    $scope.update();
                }
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.salesOrderForm.$validationSummary), 555000, 'trustedHtml');
            }
        };

        $scope.chkAll = false;
        $scope.checkAll = function(checkBox) {
            if (checkBox) {
                $scope.chkAll = true;
            } else {
                $scope.chkAll = false;
            }

            angular.forEach($scope.salesOrder.salesOrderTables, function(row) {
                row.select = $scope.chkAll;
            });

        };

        $scope.save = function() {
            var isQuantity = true;
            var isUnit = true;
            if ($scope.salesOrder.salesOrderTables.length > 0) {
                angular.forEach($scope.salesOrder.salesOrderTables, function(value, key) {
                    if (value.qty <= 0 || value.qty == undefined || value.qty == null || value.qty == '') {
                        isQuantity = false;
                    }
                });
                angular.forEach($scope.salesOrder.salesOrderTables, function(value1, key) {
                    if (value1.price <= 0 || value1.price == undefined || value1.price == null || value1.price == '') {
                        isUnit = false;
                    }
                });
                if (isQuantity == true && isUnit == true) {
                    $http.post('app/salesorder/save', $scope.salesOrder).success(function(datas) {
                        if (datas.success == true) {
                            logger.logSuccess("Saved Successfully!");
                            $state.go("app.hospital.accounts.salesorder.list");
                        }

                    }).error(function(data) {
                        logger.logError("Not Saved!");
                    });
                } else {
                    if (isQuantity == false) {
                        logger.logError("Quantity cannot be zero");
                    }
                    if (isUnit == false) {
                        logger.logError("Unit Price cannot be zero");
                    }

                }

            } else {
                logger.logError("Please Select an Item");
            }

        };
        $scope.update = function() {
            var isQuantity = true;
            var isUnit = true;
            if ($scope.salesOrder.salesOrderTables.length > 0) {
                angular.forEach($scope.salesOrder.salesOrderTables, function(value, key) {
                    if (value.qty <= 0 || value.qty == undefined || value.qty == null || value.qty == '') {
                        isQuantity = false;
                    }
                });
                angular.forEach($scope.salesOrder.salesOrderTables, function(value1, key1) {
                    if (value1.price <= 0 || value1.price == undefined || value1.price == null || value1.price == '') {
                        isUnit = false;
                    }
                });
                if (isQuantity == true && isUnit == true) {
                    $http.post('app/salesorder/update', $scope.salesOrder).success(function(datas) {
                        if (datas.success == true) {
                            logger.logSuccess("Updated Successfully!");
                            $state.go("app.hospital.accounts.salesorder.list");
                        }

                    }).error(function(data) {
                        logger.logError("Not update!");
                    });
                } else {
                    if (isQuantity == false) {
                        logger.logError("Quantity cannot be zero");
                    }
                    if (isUnit == false) {
                        logger.logError("Unit Price cannot be zero");
                    }

                }
            } else {
                logger.logError("Please Select an Item");
            }
        };
        $scope.reset = function() {
            if (!$scope.isEdit) {
                var salesOrder1 = {
                    salesOrderId : 0,
                    salesOrderNo : '',
                    salesOrderDate : '',
                    haspitalCode : '',
                    haspitalName : '',
                    employeeId : '',
                    employeeName : '',
                    customerCode : '',
                    customerName : '',
                    jobTitleCode : '',
                    jobTitleName : '',
                    billingAddress : '',
                    billingCity : '',
                    billingState : '',
                    billingCountry : '',
                    billingCityCode : '',
                    billingStateCode : '',
                    billingCountryCode : '',
                    billingPinCode : '',
                    contactPerson : '',
                    deliveryAddress : '',
                    deliveryCity : '',
                    deliveryCityCode : '',
                    deliveryState : '',
                    deliveryCountry : '',
                    deliveryPinCode : '',
                    deliveryStateCode : '',
                    deliveryCountryCode : '',
                    deliveryPinCodeCode : '',
                    status : '',
                    customerNote : '',
                    totalTax : '',
                    totalAmount : '',
                    netAmount : '',
                    salesOrderTables : []
                }

                var salesTable = {
                    salesOrderDtlId : 0,
                    itemId : '',
                    itemCode : '',
                    itemName : '',
                    itemDesc : '',
                    itemCategory : '',
                    itemCategoryId : '',
                    taxCode : '',
                    taxId : '',
                    unit : '',
                    unitId : '',
                    qty : '',
                    taxPercent : '',
                    price : '',
                    amount : '',
                    taxAmount : ''
                };
                salesOrder1.salesOrderTables.push(salesTable);
                $scope.salesOrder = salesOrder1;
            } else {
                $http.get('app/salesorder/edit?salesOrderId=' + salesOrderId).success(function(data) {
                    $scope.salesOrder = data;
                    salesOrderOld = data;
                    if ($scope.salesOrder.totalTax != null && $scope.salesOrder.totalTax != undefined && $scope.salesOrder.totalTax != '') {
                        $scope.salesOrder.totalTax = $scope.salesOrder.totalTax.toFixed(2);

                    }
                    if ($scope.salesOrder.netAmount != null && $scope.salesOrder.netAmount != undefined && $scope.salesOrder.netAmount != '') {
                        $scope.salesOrder.netAmount = $scope.salesOrder.netAmount.toFixed(2);

                    }

                    $scope.getContactPerson($scope.salesOrder.customerCode);
                }).error(function(data) {
                });
            }
        };

        $scope.getItem = function(trIndex, itemId) {
            angular.forEach($scope.itemList, function(value, key) {
                if (itemId == value.itemId) {
                    $scope.salesOrder.salesOrderTables[trIndex].itemDesc = value.itemDesc;
                    $scope.salesOrder.salesOrderTables[trIndex].itemCategory = value.itemCategory;
                    $scope.salesOrder.salesOrderTables[trIndex].unit = value.unit;
                    if (value.taxId == '' || value.taxId == undefined || value.taxId == null) {
                        value.taxId = 0;
                    }
                    $scope.salesOrder.salesOrderTables[trIndex].taxId = value.taxId;
                    $scope.salesOrder.salesOrderTables[trIndex].taxCode = value.taxCode;
                    $scope.getTax(trIndex, value.taxId);
                }
            });

        };

        $scope.onChangeItem = function(trIndex, itemId) {

            if (itemId != undefined && itemId != '') {
                var length = $scope.salesOrder.salesOrderTables.length;
                for (var i = 0; i < length; i++) {
                    for (var j = 0; j < length; j++) {
                        if (i != j) {
                            if ($scope.salesOrder.salesOrderTables[i].itemId != undefined && $scope.salesOrder.salesOrderTables[i].itemId != null && $scope.salesOrder.salesOrderTables[i].itemId != '' && $scope.salesOrder.salesOrderTables[i].itemId != undefined && $scope.salesOrder.salesOrderTables[i].itemId != null && $scope.salesOrder.salesOrderTables[i].itemId != '') {
                                if ($scope.salesOrder.salesOrderTables[i].itemId == $scope.salesOrder.salesOrderTables[j].itemId) {
                                    logger.logError("Item Code-Item Name already added");
                                    $scope.salesOrder.salesOrderTables[trIndex].itemId = '';
                                    $scope.salesOrder.salesOrderTables[trIndex].itemCategory = '';
                                    $scope.salesOrder.salesOrderTables[trIndex].unit = '';
                                    $scope.salesOrder.salesOrderTables[trIndex].taxCode = '';
                                    return false;
                                }
                            }
                        }
                    }
                }
                $scope.getItem(trIndex, itemId);
            } else {
                $scope.salesOrder.salesOrderTables[trIndex].itemCategory = '';
                $scope.salesOrder.salesOrderTables[trIndex].unit = '';
                $scope.salesOrder.salesOrderTables[trIndex].taxCode = '';
            }

        };

        $scope.getDropdownList = function() {
            $http.get('app/salesorder/getDropDownList').success(function(datas) {
                if (datas.success == true) {
                    $scope.employeeList = datas.employeeList;
                    $scope.companyList = datas.companyList;
                    $scope.cityList = datas.cityList;
                    $scope.cityList1 = datas.cityList1;
                    $scope.customerList = datas.customerList;

                    $scope.itemList = datas.itemList;
                    $scope.taxList = datas.taxList;
                    $scope.getContactPerson($scope.salesOrder.customerCode);
                }

            }).error(function(data) {
            });
        };
        $scope.getDropdownList();

        $scope.getContactPerson = function(customerCode) {
            var salesOrderObj = $filter('filter')($scope.customerList, {
                customerCode : customerCode
            }, true)[0];
            if (salesOrderObj != undefined) {
                $scope.salesOrder.jobTitleName = salesOrderObj.jobTitleName;
                $scope.salesOrder.contactPerson = salesOrderObj.contactPerson;

                $scope.salesOrder.billingAddress = salesOrderObj.billingAddress;
                $scope.salesOrder.billingCityCode = salesOrderObj.billingCityCode;
                $scope.salesOrder.billingCity = salesOrderObj.billingCity;
                $scope.salesOrder.billingState = salesOrderObj.billingState;
                $scope.salesOrder.billingCountry = salesOrderObj.billingCountry;
                $scope.salesOrder.billingPinCode = salesOrderObj.billingPinCode;

                $scope.salesOrder.deliveryAddress = salesOrderObj.billingAddress;
                $scope.salesOrder.deliveryCityCode = salesOrderObj.billingCityCode;
                $scope.salesOrder.deliveryCity = salesOrderObj.billingCity;
                $scope.salesOrder.deliveryState = salesOrderObj.billingState;
                $scope.salesOrder.deliveryCountry = salesOrderObj.billingCountry;
                $scope.salesOrder.deliveryPinCode = salesOrderObj.billingPinCode;
            }

        };

        $scope.getBillingState = function(billingCityCode) {

            var salesOrderObj = $filter('filter')($scope.cityList, {
                billingCityCode : billingCityCode
            }, true)[0];
            if (salesOrderObj != null && salesOrderObj != undefined && salesOrderObj != "") {
                $scope.salesOrder.billingCity = salesOrderObj.billingCity;
                $scope.salesOrder.billingState = salesOrderObj.billingState;
                $scope.salesOrder.billingCountry = salesOrderObj.billingCountry;
                $scope.salesOrder.billingPinCode = salesOrderObj.billingPinCode;
            } else {
                $scope.salesOrder.billingCity = '';
                $scope.salesOrder.billingState = '';
                $scope.salesOrder.billingCountry = '';
                $scope.salesOrder.billingPinCode = '';
            }
        };
        $scope.getDeliveryState = function(deliveryCityCode) {
            var salesOrderObj = $filter('filter')($scope.cityList1, {
                deliveryCityCode : deliveryCityCode
            }, true)[0];
            if (salesOrderObj != null && salesOrderObj != undefined && salesOrderObj != "") {
                $scope.salesOrder.deliveryCity = salesOrderObj.deliveryCity;
                $scope.salesOrder.deliveryState = salesOrderObj.deliveryState;
                $scope.salesOrder.deliveryCountry = salesOrderObj.deliveryCountry;
                $scope.salesOrder.deliveryPinCode = salesOrderObj.deliveryPinCode;
            } else {
                $scope.salesOrder.deliveryCity = '';
                $scope.salesOrder.deliveryState = '';
                $scope.salesOrder.deliveryCountry = '';
                $scope.salesOrder.deliveryPinCode = '';
            }
        };

        $scope.getTax = function(trindex, taxId) {
            var itemObj = $filter('filter')($scope.taxList, {
                taxId : taxId
            }, true)[0];
            if (itemObj != null && itemObj != undefined && itemObj != "") {
                if (itemObj.taxId == '' || itemObj.taxId == undefined || itemObj.taxId == null) {
                    itemObj.taxId = 0;
                }
                $scope.salesOrder.salesOrderTables[trindex].taxId = itemObj.taxId;
                $scope.salesOrder.salesOrderTables[trindex].taxAmount = itemObj.taxAmount;
                if ($scope.salesOrder.salesOrderTables[trindex].taxAmount == undefined || $scope.salesOrder.salesOrderTables[trindex].taxAmount == '' || isNaN($scope.salesOrder.salesOrderTables[trindex].taxAmount)) {
                    $scope.salesOrder.salesOrderTables[trindex].taxPercent = itemObj.taxPercent;
                }

            } else {
            }
            $scope.calculateTotalAmount($scope.salesOrder.salesOrderTables);
        };

        $scope.calculateAmount = function(row) {

            var qty = 0;
            var price = 0.0;
            if (row != null && row != undefined && row != '') {
                if (row.qty != null && row.qty != undefined && row.qty != '') {
                    qty = row.qty;
                } else {
                    qty = 0;
                }
                if (row.price != null && row.price != undefined && row.price != '') {
                    price = row.price;
                } else {
                    price = 0;
                }
                row.amount = qty * price;

                if (!isNaN(row.taxPercent)) {
                    if (row.taxPercent != undefined && row.taxPercent != '') {

                        row.taxAmount = row.amount * row.taxPercent / 100;
                    }
                }

            }
            $scope.calculateTotalAmount($scope.salesOrder.salesOrderTables);

        };
        $scope.calculateTotalAmount = function(tables) {

            var totalTaxAmount = 0.0, totalAmount = 0.0, taxAmount = 0.0, amount = 0.0;
            angular.forEach(tables, function(row, index) {
                if (row.taxAmount != null && row.taxAmount != undefined && row.taxAmount != '') {
                    taxAmount = row.taxAmount;
                } else {
                    taxAmount = 0;
                }
                if (row.amount != null && row.amount != undefined && row.amount != '') {
                    amount = row.amount;
                } else {
                    amount = 0;
                }
                totalTaxAmount = parseFloat(totalTaxAmount) + parseFloat(taxAmount);
                totalAmount = parseFloat(totalAmount) + parseFloat(amount);
            });
            var totalTaxAmount1 = 0, totalAmount1 = 0;
            $scope.salesOrder.totalTax = totalTaxAmount;
            $scope.salesOrder.totalAmount = totalAmount;
            if ($scope.salesOrder.totalTax != null && $scope.salesOrder.totalTax != undefined && $scope.salesOrder.totalTax != '') {
                totalTaxAmount1 = $scope.salesOrder.totalTax;
            } else {
                totalTaxAmount1 = 0;
            }
            if ($scope.salesOrder.totalAmount != null && $scope.salesOrder.totalAmount != undefined && $scope.salesOrder.totalAmount != '') {
                totalAmount1 = $scope.salesOrder.totalAmount;
            } else {
                totalAmount1 = 0;
            }
            $scope.salesOrder.netAmount = parseFloat(totalTaxAmount1) + parseFloat(totalAmount1);

            if ($scope.salesOrder.totalTax != null && $scope.salesOrder.totalTax != undefined && $scope.salesOrder.totalTax != '') {
                $scope.salesOrder.totalTax = $scope.salesOrder.totalTax.toFixed(2);

            }
            if ($scope.salesOrder.netAmount != null && $scope.salesOrder.netAmount != undefined && $scope.salesOrder.netAmount != '') {
                $scope.salesOrder.netAmount = $scope.salesOrder.netAmount.toFixed(2);

            }
        };
        var salesOrderOld;
        var salesOrderId = $stateParams.salesOrderId;
        if (salesOrderId == undefined || salesOrderId == null || salesOrderId == "") {
            $scope.isEdit = false;
        } else {
            // fetching edit details
            $scope.isEdit = true;
            $http.get('app/salesorder/edit?salesOrderId=' + salesOrderId).success(function(data) {
                $scope.salesOrder = data;
                salesOrderOld = data;
                if ($scope.salesOrder.totalTax != null && $scope.salesOrder.totalTax != undefined && $scope.salesOrder.totalTax != '') {
                    $scope.salesOrder.totalTax = $scope.salesOrder.totalTax.toFixed(2);

                }
                if ($scope.salesOrder.netAmount != null && $scope.salesOrder.netAmount != undefined && $scope.salesOrder.netAmount != '') {
                    $scope.salesOrder.netAmount = $scope.salesOrder.netAmount.toFixed(2);

                }

            }).error(function(data) {
            });

        }

    });

});