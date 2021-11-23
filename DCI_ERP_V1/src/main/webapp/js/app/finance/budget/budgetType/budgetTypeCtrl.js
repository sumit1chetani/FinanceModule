
    'use strict';
    app.controller('budgetTypeListCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, utilsService,$stateParams) {

        $scope.dataLoopCount = 0;
        $scope.from = 0;
        $scope.to = 100;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.isUpload = true;
        $scope.isDelete = true;
        $scope.isadd = true;

        $scope.staticTypes = [ {
            budgetType : 'Admin',
            expenses : 'Misc Expenses , Salaries , Communication , Travel & Entertainment'
        }, {
            budgetType : 'Operational',
            expenses : 'Professional Fees , Maintanance , Asset Purchase , Supplier Payment'
        } ]

        $scope.getBudgetListUtil = function(limit, offset) {
            var start = new Date().getTime();
            var url = $stateParams.tenantid+'/app/budget/type/typeList';
            $http.get(url).success(function(data) {
                if (data.success == true) {
                    $scope.rowCollection = $scope.rowCollection.concat(data.lBudgetTypeBean);
                    $scope.dataLoopCount++;
                } else {
                    if ($scope.dataLoopCount == 0) {
                        $scope.showEmptyLabel = true;
                    }
                    logger.logError("Error Please Try Again");
                }
                var end = new Date().getTime();
                var time = end - start;
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });

        };

        $scope.getBudgetListUtil();

        $scope.edit = function(typeId) {
            $location.url($stateParams.tenantid+'/finance/budget/budgetType/budgetTypeForm?typeId=' + typeId);
        };

        $scope.viewAllocation = function(allocationId) {
            $location.url($stateParams.tenantid+'/finance/budget/budgetAllocation/view?allocationId=' + allocationId);
        };

        $scope.deleteAllocation = function(collections, index) {
           
                var myURL = $stateParams.tenantid+'/app/budget/delete';
                $http({
                    method : 'post',
                    url : myURL,
                    data : collections,
                }).success(function(data) {
                    if (data.success) {
                        var tableData = $scope.rowCollection;
                        $scope.rowCollection.splice(index, 1);
                        logger.logSuccess("deleted successfully");
                        $state.reload();
                    } else {
                        logger.logError("Error in deleting Record!");
                    }
                }).error(function(data) {
                    logger.logSuccess("Error in Delete!");
                });
            
        };

    });

    app.controller('budgetTypeAddCtrl', function($scope, $state, $http, $location, sharedProperties, toaster, $injector, logger, $stateParams, $timeout, validationService) {

        $scope.dataLoopCount = 0;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.expenseList = [];

        $scope.budgetType = {
            budget_type_id : '',
            budget_type : '',
            expenses : '',
            expCodes : []
        };
        $scope.edit = false;

        $scope.getDropdownValue = function() {

            $http.get($stateParams.tenantid+'/app/budget/type/getDropDownList').success(function(datas) {
                $scope.expenseList = datas.lExpenseAccountsList;
                $timeout(function() { 

                    $("#txtExpenses").multiselect({
                        maxHeight : 100,
                        includeSelectAllOption : true,
                        selectAllText : 'Select All',
                        enableFiltering : true,
                        enableCaseInsensitiveFiltering : true,
                        filterPlaceholder : 'Search',
                        onChange : function(element, checked) {

                            var expenseCodes = "";
                            if ($scope.budgetType.expCodes.length > 0) {
                                angular.forEach($scope.budgetType.expCodes, function(item, key) {
                                    if (expenseCodes == "") {
                                        expenseCodes = item;
                                    } else {
                                        expenseCodes += "," + item;
                                    }
                                    $scope.budgetType.expenses = expenseCodes;
                                });
                            } else {
                                $scope.budgetType.expenses = '';
                            }
                        }
                    });
                }, 3, false);

                if ($location.search().typeId != undefined && $location.search().typeId != '') {
                    $scope.fetchEditData();
                }

            }).error(function(datas) {
            });
        }
        $scope.getDropdownValue();

        /**
         * validation
         */
        $scope.validate = function() {

            if (new validationService().checkFormValidity($scope.budgetTypeForm)) {
                $scope.save();
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.budgetTypeForm.$validationSummary), 555000, 'trustedHtml');
            }
        };

        $scope.save = function() {

            if ($scope.edit == false) {
                $http.post($stateParams.tenantid+'/app/budget/type/save', $scope.budgetType).success(function(result) {
                    if (result.success) {
                        logger.logSuccess("Saved Successfully!");
                        $location.path('/hospital/accounts/budgetType/list');
                    } else {
                        logger.logError("Error in Save!");
                    }
                }).error(function(result) {
                });
            } else {
                $http.post($stateParams.tenantid+'/app/budget/type/update', $scope.budgetType).success(function(result) {
                    if (result.success) {
                        logger.logSuccess("Updated Successfully!");
                        $location.path('/hospital/accounts/budgetType/list');
                    } else {
                        logger.logError("Error in Update");
                    }
                }).error(function(result) {
                });
            }

        };

        /***********************************************************************
         * Edit Functionality *******************************
         */
        $scope.fetchEditData = function() {

            var typeId = $location.search().typeId;

            if (typeId != undefined && typeId != null && typeId != "") {

                $scope.edit = true;
                $http.get($stateParams.tenantid+'/app/budget/type/getTypeEdit?typeId=' + typeId).success(function(data) {

                    $scope.budgetType.budget_type = data.budgetTypeBean.budget_type;
                    $scope.budgetType.budget_type_id = data.budgetTypeBean.budget_type_id;
                    $scope.budgetType.expenses = data.budgetTypeBean.expenses;

                    var valArr = data.budgetTypeBean.expenses.split(',');
                    var i = 0, size = valArr.length;
                    for (i; i < size; i++) {
                        $("#txtExpenses").multiselect('select', valArr[i]);
                    }
                    $scope.budgetType.expCodes = valArr;

                }).error(function(data) {
                });
            }
        }

        $scope.cancel = function() {
        	$state.go('app.finance.budget.budgetType.list',{tenantid:$stateParams.tenantid});
        };

        /**
         * Reset Functionality ******************************
         */
        var originalCNAcctDatas = angular.copy($scope.budgetType);

        $scope.reset = function(creditNoteForm, budgetType) {

            if ($scope.edit == false) {
                $scope.budgetType = angular.copy(originalCNAcctDatas);
                $scope.creditnoteDtlTotalAmt = angular.copy(originalCNAcctTotal);
                $scope.creditNoteForm.$setPristine();
            } else {
                $scope.fetchEditData();
            }
        }

        $scope.isEditChanged = function() {
            return !angular.equals($scope.budgetType, originalCNAcctDatas);
        };
    });

