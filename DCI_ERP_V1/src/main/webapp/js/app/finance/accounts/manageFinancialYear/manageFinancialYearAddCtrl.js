//define([ 'hospital/accounts/accounts' ], function(module) {

   // 'use strict';
    app.controller('manageFinancialYearAddCtrl', function($scope, $stateParams,$window, $rootScope, $location, $http, logger, $log, ngDialog, $modal, $state, utilsService, $timeout, toaster, validationService) {

        $scope.finYear = {
            fyFrom : '',
            fyTo : '',
            iscurrent : '',
            fyId : '',
            fyShortId : '',
            companyCode : 'C0002',
            companyName : '',
            active : true

        };

        $scope.companyList = [];
        $scope.isEdit = false;

      /*  $scope.onLoadDropdowns = function() {

            $http.get($stateParams.tenantid + '/app/commonUtility/getCompanyList').success(function(datas) {
                $scope.companyList = datas;
            }).error(function(datas) {
            });
        };
        //$scope.onLoadDropdowns();
*/
        $http.get($stateParams.tenantid + '/app/commonUtility/getCompanyList').success(function(datas) {	  
            $scope.companyList = datas;
  	}).error(function(data) {

  	});	
        
        $scope.calculateExpDate = function(str) {

            var expDate = "";
            if (/^\d{2}\/\d{2}\/\d{4}$/i.test(str)) {

                var parts = str.split("/");
                var day = parts[0] && parseInt(parts[0], 10);
                var month = parts[1] && parseInt(parts[1], 10);
                var year = parts[2] && parseInt(parts[2], 10);
                var duration = parseInt(1, 10);

                if (day <= 31 && day >= 1 && month <= 12 && month >= 1) {

                    var expiryDate = new Date(year, month - 1, day);
                    expiryDate.setFullYear(expiryDate.getFullYear() + duration);

                    var day = ('0' + expiryDate.getDate()).slice(-2);
                    var month = ('0' + (expiryDate.getMonth() + 1)).slice(-2);
                    var year = expiryDate.getFullYear();

                    expDate = day + "/" + month + "/" + year;

                } else {
                    // display error message
                }
            }
            return expDate;
        }

        var today = new Date();
        var dd = today.getDate();
        var mm = today.getMonth() + 1;

        var yyyy = today.getFullYear();
        if (dd < 10) {
            dd = '0' + dd;
        }
        if (mm < 10) {
            mm = '0' + mm;
        }
        var today = dd + '/' + mm + '/' + yyyy;
        $scope.finYear.fyFrom = today;
        $scope.finYear.fyTo = $scope.calculateExpDate(today);

        $scope.validateFYwithCompany = function() {

            $http.post('app/financialyear/validateFY', $scope.finYear).success(function(data) {
                if (data)
                    return true;
                else {
                    logger.logError("Financial Already Exist for the Company");
                    return false;
                }
            }).error(function(data) {
            });

        }

        $scope.onSubmit = function(financialYear, finYear) {

            if (new validationService().checkFormValidity(financialYear)) {
                $scope.save();

            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(financialYear.$validationSummary), 555000, 'trustedHtml');
            }
        };

        $scope.save = function() {

            if ($scope.isEdit == false) {

                $http.post('app/financialyear/save', $scope.finYear).success(function(response) {
                    if (response.success) {
                        logger.logSuccess("Financial Year Saved Successfully!");
                        //$location.path("/accounts/manageFinancialYear/list");
                        $state.go('app.finance.accounts.manageFinancialYear.list');
                        
                    } else {
                        logger.logError(response.errors[0]);
                    }

                }).error(function(response) {
                });
            } else {
                $http.post('app/financialyear/update', $scope.finYear).success(function(result) {
                    if (result) {
                        logger.logSuccess("Financial Year Updated Successfully!");
                       // $location.path("/accounts/manageFinancialYear/list");
                        $state.go('app.finance.accounts.manageFinancialYear.list');

                    } else {
                        logger.logError("Not Updated!");
                    }
                }).error(function(data) {
                });

            }
        };

        $scope.cancel = function() {
            $state.go('app.finance.accounts.manageFinancialYear.list');
        };

        $scope.$watch('[finYear.fyFrom,finYear.fyTo]', function(newValue, oldValue) {

            if (newValue != "" && newValue != undefined) {
                if ($scope.finYear.fyFrom != '' && $scope.finYear.fyTo != '') {
                    var fromDate = $scope.finYear.fyFrom;
                    var toDate = $scope.finYear.fyTo;
                    fromDate = fromDate.split("/");
                    fromDate = new Date(fromDate[2], fromDate[1], fromDate[0]);
                    toDate = toDate.split("/");
                    toDate = new Date(toDate[2], toDate[1], toDate[0]);
                    if (fromDate > toDate) {
                        $scope.finYear.fyTo = '';
                        logger.logError("End Date should greater than From Date");
                    }
                }
            }
        });

        /*
         * 
         * Edit Functionality
         */

        var finId = $location.search().finId;

        if (finId != undefined) {

            $scope.isEdit = true;
            $http.get('app/financialyear/getDataforEdit?finId=' + finId).success(function(data) {

                $scope.finYear = data;

            }).error(function(data) {
                logger.logError("Unable to Get Data");
            });

        } else {
            $scope.isEdit = false;
        }

        $scope.validateAmount = function(e) {
            if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
                $("#errmsg").html("Digits Only").show().fadeOut("slow");
                return false;
            }
        };

        $scope.ValidateYear = function() {

            var flag = ValidateDate();
            if (flag != false) {

                var Text = $scope.finYear.fyId;
                var Text_Split = Text.split('-');
                var Text_Split1 = ltrim(rtrim(Text_Split[0]));
                Text_Split1 = Text_Split1.substr(Text_Split1.length - 2);
                var Text_Split2 = ltrim(rtrim(Text_Split[1]));
                var Diff = Text_Split2 - Text_Split1
                if (Diff != 1) {
                    $scope.finYear.fyId = '';
                    logger.logError('Enter a Valid Financial year');
                    return false;
                } else
                    return true;
            } else
                return false;
        }

        function ltrim(str) {

            for (var k = 0; k < str.length && isWhitespace(str.charAt(k)); k++)
                ;
            return str.substring(k, str.length);
        }

        function rtrim(str) {

            for (var j = str.length - 1; j >= 0 && isWhitespace(str.charAt(j)); j--)
                ;
            return str.substring(0, j + 1);
        }

        function isWhitespace(charToCheck) {

            var whitespaceChars = " \t\n\r\f";
            return (whitespaceChars.indexOf(charToCheck) != -1);
        }

        function ValidateDate() {

            var regexYear = /^([0-9]{4})[-]+([0-9]{2})$/;
            var Year = $scope.finYear.fyId;
            if (Year != "" && Year != null) {
                if (regexYear.test(Year) == false) {
                    $scope.finYear.fyId = '';
                    logger.logError('Enter a Valid Financial year');
                    return false;
                } else
                    return true;
            }
        }

    });
//});
