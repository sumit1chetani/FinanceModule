'use strict';
app.controller('earningaddCtrl', function($scope,$stateParams, validationService,$timeout, $rootScope, $http, $location,ngDialog, logger, toaster,utilsService,$state,sharedProperties,$window) {

    $scope.earningDeductionMasterList = [];
    $scope.earningDeductionList = [];

    $scope.earningDeduction = {
        payComponentId : '',
        payComponentName : '',
        permanant : '',
        allowance : '',
        valueType : '',
        value : '',
        percentageValue : '',
        amountValue : '',
        percentageAppliedOn : '',
        description : '',
        status : true,
        payComponentType : '',
        displayOrder : '',
        payComponentTypeName : '',
        nonStandardDeduction : false,
        isEdit : false,
        accountHead:'',
        debitaccountHead:'',
        jvMapping:false
    };

    $scope.getPayComponentList = function() {
        
        $http.get($stateParams.tenantid+'/app/journalVoucher/getAccountHeadList').success(function(datas) {
            $scope.accountHeadList = datas;
        }).error(function(datas) {
            logger.logError("Error Please Try Again");
        });
        
        
        
        
        
        $http.get("payroll/payroll/earningdeductionmaster/paycomponentlist").success(function(response) {
            $scope.earningDeductionMasterList = response.earningDeductionMasterList;

            $timeout(function() {
                $("#percentageAppliedOn").multiselect({
                    maxHeight : 400,
                    includeSelectAllOption : true,
                    selectAllText : 'Select All',
                    enableFiltering : true,
                    enableCaseInsensitiveFiltering : true,
                    numberDisplayed : 1,
                    onChange : function(element, checked) {
                        $scope.getPayComponentValue($scope.earningDeduction.percentageAppliedOn);
                    }
                });
                $("#multiselect-button").addClass("width_100 input-sm line-height-5");
            }, 2, false);
        });
    }

    $scope.getPayComponentList();
    
 

    $scope.getOptionId = function(option) {
        return option.id;
    }

    $scope.isEdit = false;

    $scope.cancel = function() {
        $state.go('app.payroll.earning.list');
    };

    $scope.validatepercentage = function(percentage) {
        if (percentage <= 0 || percentage > 100) {
            logger.logError("Percentage should be less than 100");
            $scope.earningDeduction.percentageValue = '';
        }
    };

    $scope.getPayComponentValue = function(percentage) {
        if (percentage != "" && percentage != null && percentage.length > 0) {
            $("#paycomponentPercentage").prop("disabled", false);
            $("#paycomponentValue").prop("disabled", true);
            $scope.earningDeduction.valueType = 2;
            $scope.earningDeduction.amountValue = '';
        } else {
            $("#paycomponentValue").prop("disabled", false);
            $("#paycomponentPercentage").prop("disabled", true);
            $scope.earningDeduction.percentageValue = '';
            $scope.earningDeduction.valueType = 1;
        }

    }

    $scope.submit = function(earningDeduction, earningDeductionForm) {
        if (new validationService().checkFormValidity(earningDeductionForm)) {
            var componenetType = $scope.earningDeduction.payComponentTypeName;
            if (componenetType == "earning") {
                $scope.earningDeduction.payComponentType = 1;
            }
            if (componenetType == "deduction") {
                $scope.earningDeduction.payComponentType = 2;
            }

            $scope.earningDeduction.value = '';
            var percentageAppliedOnStr = '';
            var percentage = $scope.earningDeduction.percentageAppliedOn;
            if (percentage != "" && percentage != null && percentage != undefined) {
                $scope.earningDeduction.value = $scope.earningDeduction.percentageValue;
                $scope.earningDeduction.valueType = 2;
                if ($scope.earningDeduction.percentageAppliedOn != null && $scope.earningDeduction.percentageAppliedOn != undefined && $scope.earningDeduction.percentageAppliedOn != '') {
                    var percentAppliedValue = $scope.earningDeduction.percentageAppliedOn;
                    $scope.earningDeduction.value = $scope.earningDeduction.percentageValue;
                    var percentageAppliedOnStr = '';
                    var j = 0;
                    for (var i = 0; i < $scope.earningDeduction.percentageAppliedOn.length; i++) {
                        percentageAppliedOnStr = percentageAppliedOnStr + $scope.earningDeduction.percentageAppliedOn[i].id;
                        j++;
                        if (j < $scope.earningDeduction.percentageAppliedOn.length) {
                            percentageAppliedOnStr = percentageAppliedOnStr + ",";
                        }
                    }
                }
                $scope.earningDeduction.percentageAppliedOn = percentageAppliedOnStr;

            } else {
                $scope.earningDeduction.value = $scope.earningDeduction.amountValue;
                $scope.earningDeduction.valueType = 1;
                $scope.earningDeduction.percentageAppliedOn = null;
            }
            var saveData = $scope.earningDeduction;
            if ($scope.earningDeduction.isEdit != true) {
                var isValid = true;
                var saveData = $scope.earningDeduction;
                if ($scope.earningDeduction.payComponentId == null || $scope.earningDeduction.payComponentId == "" || $scope.earningDeduction.payComponentId == undefined) {
                    logger.logError("Pay Component Id - This should be Required!!");
                    isValid = false;
                }
                if ($scope.earningDeduction.payComponentName == null || $scope.earningDeduction.payComponentName == "" || $scope.earningDeduction.payComponentName == undefined) {
                    logger.logError("Pay Component Name - This should be Required!!");
                    isValid = false;
                }
                if ($scope.earningDeduction.payComponentType == "" || $scope.earningDeduction.payComponentType == null || $scope.earningDeduction.payComponentType == undefined) {
                    logger.logError("Pay Component Type - This should be Required!!");
                    isValid = false;
                }
                if ($scope.earningDeduction.displayOrder == "" || $scope.earningDeduction.displayOrder == null || $scope.earningDeduction.displayOrder == undefined) {
                    logger.logError("Display Order - This should be Required!!");
                    isValid = false;
                } else {
                    if (isValid) {
                        $http.post("payroll/payroll/earningdeductionmaster/save", saveData).success(function(result) {
                            if (result == false) {
                                logger.logError("Not Saved");
                            } else {
                                logger.logError(" Save Successfully");
                                $state.go('app.payroll.earning.list');
                            }
                        });
                    }
                }

            }
        } else {
            toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(earningDeductionForm.$validationSummary), 5000, 'trustedHtml');
        }
    };

    $scope.reset = function(earningDeductionForm) {
        if ($scope.earningDeduction.isEdit != true) {
            $scope.earningDeduction = {
                    payComponentId : '',
                    payComponentName : '',
                    permanant : '',
                    allowance : '',
                    valueType : '',
                    value : '',
                    percentageValue : '',
                    amountValue : '',
                    percentageAppliedOn : '',
                    description : '',
                    status : true,
                    payComponentType : '',
                    displayOrder : '',
                    payComponentTypeName : '',
                    nonStandardDeduction : false,
                    isEdit : false,
                    accountHead:'',
                    debitaccountHead:'',
                    jvMapping:false
                };
        }
    }
    $scope.jvmapFlag = false;

    $scope.getAccountHead = function(jvmap){
        if(jvmap){
            $scope.jvmapFlag = true;

        }else{
            $scope.jvmapFlag = false;

        }
    }
//    $scope.jvmapFlag = true;
//    $scope.$watch('earningDeduction.jvMapping',function(newVal, oldVal){
//        
//        if (newVal != undefined && newVal != '' && newVal != null) {
//            alert(9);
//            if ($scope.earningDeduction.jvMapping)
//              
//            else
//                $scope.jvmapFlag = false;
//
//}
//    });
    
});





app.controller('earningEditCtrl', function($stateParams,$scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService, $timeout) {
    $('#tb_fromDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime: false
    });
    
    $('#tb_toDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime: false
    });
    $scope.earningDeductionMasterList = [];
    $scope.earningDeductionList = [];

    $scope.earningDeduction = {
        payComponentId : '',
        payComponentName : '',
        permanant : '',
        allowance : '',
        valueType : '',
        value : '',
        percentageValue : '',
        amountValue : '',
        percentageAppliedOn : '',
        description : '',
        status : '',
        payComponentType : '',
        displayOrder : '',
        payComponentTypeName : '',
        isEdit : true,
    };

    $scope.getOptionId = function(option) {
        return option.id;
    }
    $http.get($stateParams.tenantid+'/app/journalVoucher/getAccountHeadList').success(function(datas) {
        $scope.accountHeadList = datas;
    }).error(function(datas) {
        logger.logError("Error Please Try Again");
    });
    
    $scope.isEdit = true;
    $scope.onLoad = true;
    var payComponentId = $location.search().payComponentId;

    $scope.earningDeduction.isEdit = true;
    $http.post('payroll/payroll/earningdeductionmaster/edit', payComponentId).success(function(result) {
        if (result.isEdit == false) {
            logger.logError("Please Try Again");
        } else {
            $scope.earningList = [];
            $scope.earningDeduction = result;
            $scope.getAccountHead($scope.earningDeduction.jvMapping);
            var componenetType = result.payComponentType;
            if (componenetType == 1) {
                $scope.earningDeduction.payComponentTypeName = "earning";
            }
            if (componenetType == 2) {
                $scope.earningDeduction.payComponentTypeName = "deduction";
            }


            $http.get("payroll/payroll/earningdeductionmaster/paycomponentlist").success(function(response) {
                $scope.earningDeductionMasterList = response.earningDeductionMasterList;

                $timeout(function() {
                    $("#percentageAppliedOn").multiselect({
                        maxHeight : 400,
                        includeSelectAllOption : true,
                        selectAllText : 'Select All',
                        enableFiltering : true,
                        enableCaseInsensitiveFiltering : true,
                        numberDisplayed : 2,
                        onChange : function(element, checked) {
                            $scope.getPayComponentValue($scope.earningDeduction.percentageAppliedOn);
                        }
                    });
                    $("#multiselect-button").addClass("width_100 input-sm line-height-5");
                }, 2, false);

                var percentage = result.percentageAppliedOn;
                if (percentage != "" && percentage != null && percentage != undefined) {
                    var percentageStr = percentage.split(",");
                    for (var i = 0; i < percentageStr.length; i++) {
                        $("#percentageAppliedOn").find("option[label=" + percentageStr[i] + "]").prop("selected", "selected");

                        angular.forEach($scope.earningDeductionMasterList, function(value, key) {
                            if (percentageStr[i] == value.id) {
                                $scope.earningList.push(value);
                            }
                        });

                        $scope.earningDeduction.percentageAppliedOn = $scope.earningList;
                    }
                    $scope.earningDeduction.percentageValue = result.value;
                    $scope.earningDeduction.valueType = 2;
                    $("#paycomponentPercentage").prop("disabled", false);
                    $("#paycomponentValue").prop("disabled", true);

                } else {
                    $scope.earningDeduction.amountValue = result.value;
                    $scope.earningDeduction.valueType = 1;
                    $scope.earningDeduction.percentageAppliedOn = null;
                    $("#paycomponentValue").prop("disabled", false);
                    $("#paycomponentPercentage").prop("disabled", true);
                }
            });

        }

    }).error(function(data) {
    });

    $scope.cancel = function() {
        $state.go('app.payroll.earning.list');
    };
    $scope.jvmapFlag = false;

    $scope.getAccountHead = function(jvmap){
        if(jvmap){
            $scope.jvmapFlag = true;

        }else{
            $scope.jvmapFlag = false;

        }
    }
    $scope.validatepercentage = function(percentage) {
        if (percentage <= 0 || percentage > 100) {
            logger.logError("Percentage should be less than 100");
            $scope.earningDeduction.percentageValue = '';
        }
    };

    /*
     * $scope.$watch('earningDeduction.percentageAppliedOn',
     * function(newVal, oldVal) { var newValue =
     * $scope.earningDeduction.percentageAppliedOn; var arr =
     * String(newValue).split(""); $scope.getPayComponentValue(newVal);
     * 
     * });
     */
 
    $scope.getPayComponentValue = function(percentage) {
        if (percentage != "" && percentage != null) {
            $("#paycomponentPercentage").prop("disabled", false);
            $("#paycomponentValue").prop("disabled", true);
            $scope.earningDeduction.valueType = 2;
            $scope.earningDeduction.amountValue = '';
        } else {
            $("#paycomponentValue").prop("disabled", false);
            $("#paycomponentPercentage").prop("disabled", true);
            $scope.earningDeduction.percentageValue = '';
            $scope.earningDeduction.valueType = 1;

        }

    }

    $scope.update = function(earningDeduction, earningDeductionForm) {
        var isvalid = true;
        var componenetType = $scope.earningDeduction.payComponentTypeName;
        if (componenetType == "earning") {
            $scope.earningDeduction.payComponentType = 1;
        }
        if (componenetType == "deduction") {
            $scope.earningDeduction.payComponentType = 2;
        }

        var percentage = $scope.earningDeduction.percentageAppliedOn;
        if (percentage == "" || percentage == undefined || percentage == null) {
            $scope.earningDeduction.value = $scope.earningDeduction.amountValue;
            $scope.earningDeduction.valueType = 1;
            $scope.earningDeduction.percentageAppliedOn = null;
        } else {
            $scope.earningDeduction.value = $scope.earningDeduction.percentageValue;
            $scope.earningDeduction.valueType = 2;

            var percentageAppliedOnStr = '';
            var percentage = $scope.earningDeduction.percentageAppliedOn;
            if (percentage != "" && percentage != null && percentage != undefined) {
                $scope.earningDeduction.value = $scope.earningDeduction.percentageValue;
                $scope.earningDeduction.valueType = 2;
                if ($scope.earningDeduction.percentageAppliedOn != null && $scope.earningDeduction.percentageAppliedOn != undefined && $scope.earningDeduction.percentageAppliedOn != '') {
                    var percentAppliedValue = $scope.earningDeduction.percentageAppliedOn;
                    $scope.earningDeduction.value = $scope.earningDeduction.percentageValue;
                    var percentageAppliedOnStr = '';
                    var j = 0;
                    for (var i = 0; i < $scope.earningDeduction.percentageAppliedOn.length; i++) {
                        percentageAppliedOnStr = percentageAppliedOnStr + $scope.earningDeduction.percentageAppliedOn[i].id;
                        j++;
                        if (j < $scope.earningDeduction.percentageAppliedOn.length) {
                            percentageAppliedOnStr = percentageAppliedOnStr + ",";
                        }
                    }
                }
                $scope.earningDeduction.percentageAppliedOn = percentageAppliedOnStr;

            } else {
                $scope.earningDeduction.value = $scope.earningDeduction.amountValue;
                $scope.earningDeduction.valueType = 1;
                $scope.earningDeduction.percentageAppliedOn = null;
            }

        }
        var updateData = $scope.earningDeduction;
        sharedProperties.clearObject();
        if ($scope.earningDeduction.payComponentName == null || $scope.earningDeduction.payComponentName == "" || $scope.earningDeduction.payComponentName == undefined) {
            logger.logError("Pay Component Name - This should be Required!!");
            isValid = false;
        }
        if (new validationService().checkFormValidity(earningDeductionForm)) {
            if (isvalid) {
                $http.post('payroll/payroll/earningdeductionmaster/update', updateData).success(function(result) {
                    if (result == false) {

                    } else {
                        logger.logSuccess("Earning/ Deduction Code updated successfully");
                        $state.go('app.payroll.earning.list');
                    }
                });
            }
        } else {
            toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(earningDeductionForm.$validationSummary), 5000, 'trustedHtml');
        }
    }
    $scope.reset = function(earningDeductionForm) {
        if ($scope.earningDeduction.isEdit != true) {
            $scope.earningDeduction = [];
        } else {
            $scope.earningDeduction.value = '';
            $scope.earningDeduction.displayOrder = '';
            $scope.earningDeduction.payComponentName = '';
            $scope.earningDeduction.percentageAppliedOn = '';
            $scope.earningDeduction.permanant = '';
            $scope.earningDeduction.allowance = '';
            $scope.earningDeduction.status = true;
            $scope.earningDeduction.amountValue = '';
            $scope.earningDeduction.percentageValue = '';
        }
    }
    

});