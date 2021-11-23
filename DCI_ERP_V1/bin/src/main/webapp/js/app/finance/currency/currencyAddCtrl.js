'use strict';
app.controller('currencyAddCtrl', function($scope, $rootScope, $http, $location, logger, utilsService, $state, sharedProperties, $window,validationService,toaster,$stateParams ) {
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.currencyList = [];
    $scope.viewDisable=true;
    $scope.$watch('currencyData.currencyCode', function(newVal, oldVal) {
        if (newVal.length > 3) {
            $scope.currencyData.currencyCode = oldVal;
        }
    });
    $scope.$watch('currencyData.fromc', function(newVal, oldVal) {
        if (newVal.length > 5) {
            $scope.currencyData.fromc = oldVal;
        }
    });
    $scope.$watch('currencyData.toc', function(newVal, oldVal) {
        if (newVal.length > 10) {
            $scope.currencyData.toc = oldVal;
        }
    });
    $scope.$watch('currencyData.currencyDefault', function(newVal, oldVal) {
        if (newVal.length > 100) {
            $scope.currencyData.currencyDefault = oldVal;
        }
    });
    $scope.$watch('currencyData.currencyFraction', function(newVal, oldVal) {
        if (newVal.length > 1) {
            $scope.currencyData.currencyFraction = oldVal;
        }
    });

    $scope.cancel = function() {
        $state.go('app.finance.configuration.currency.list',{tenantid:$stateParams.tenantid});

        //$location.path($stateParams.tenantid+"/controlscreen/currency");
    };
    
    
    
    
    $rootScope.isEdit = false;
    $scope.currencyData = {
    		currencyId:'',
        currencyCode : '',
        currencyName : '',
        currencyDefault : '',
        currencyFraction : '',
        fromc : '',
        toc : '',
        symbol:'',
        category:'',
        description:'',
        bookCurrency : 'N',
        isActive : true,
        isRound :false,
        fromCurrency: 0,
        toCurrency : 0,
        defaultCurrency : 0
    };
    $scope.currencyDataClear = {};
    $scope.currencyValidateData = {
        isEdit : false,
    };
    $scope.currencyDataClear = angular.copy($scope.currencyData);

    //for validation

    $scope.validate = function(currencyAddForm,currencyData,currencyValidateData) {
        if (new validationService().checkFormValidity($scope.currencyAddForm)) {
            if(!$scope.currencyValidateData.isEdit){
                
                var isCurrCodeExists = $scope.checkUniqueCode(currencyData.currencyCode);
                var isCurrNameExists =  $scope.checkUniqueName(currencyData.currencyName);
                if(isCurrCodeExists && isCurrNameExists){
                    if(isCurrCodeExists)
                        toaster.pop('error', "Currency Code Already Exists");
                    else if(isCurrNameExists)
                        toaster.pop('error', "Currency Name Already Exists");
                }else{
                  $scope.save(currencyAddForm,currencyData,currencyValidateData);
                }
            }else{
                $scope.save(currencyAddForm,currencyData,currencyValidateData);
            }
        } else {
            toaster.pop('error', "Please fill the required fields",
                    logger.getErrorHtmlNew($scope.currencyAddForm.$validationSummary), 555000, 'trustedHtml');
        }
    };

    /**
     * get Currency List
     */
    $scope.getCurrencyNameList = function() {
        var url = $stateParams.tenantid+'/app/currency/list?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount;
        $http.get(url).success(function(data) {
            if (data.success == true && !utilsService.isUndefinedOrNull(data.lCurrencyBean)) {
                $scope.currencyList = data.lCurrencyBean;
            }
        }).error(function(data) {

            $scope.currencyList = [];
        });

    };
    $scope.getCurrencyNameList();

    /**
     * auto suggest text box for 'Currency Code' field
     */
    $scope.fetchSelectedCurrencyCode = function($model,currencyData){
        if($scope.currencyList.length>0){
            angular.forEach($scope.currencyList, function(key,index){
                if ($model === key.currencyCode){
                    currencyData.currencyCode = key.currencyCode;
                }else{
                    currencyData.currencyCode=$model;
                }
            })


        }else{
            currencyData.currencyCode=$model;
        }
        return currencyData.currencyCode;
      }

    /**
     * check Duplicate Code
     */
    $scope.checkUniqueCode = function(currencyCode){
        var screenName= 'currency',fieldName='currencyCode', isExists=false;

        $.ajax({
            type : "GET",
            url : $stateParams.tenantid+'/app/commonUtility/checkUniqueNameExists?codeAndName='+currencyCode+'&formfield='+fieldName+'&screenName='+screenName,
            data : "",
            async: false,
            contentType: false,
            processData: false,
            success : function(response) {
                if(response)
                    isExists=true;
                else
                    isExists=false;
            }
        });
        return isExists;
    }
    /**
     * check Duplicate Name
     */
    $scope.checkUniqueName = function(currencyName){
        var screenName= 'currency', fieldName='currencyName', isExists=false;
        $.ajax({
            type : "GET",
            url : $stateParams.tenantid+'/app/commonUtility/checkUniqueNameExists?codeAndName='+currencyName+'&formfield='+fieldName+'&screenName='+screenName,
            data : "",
            async: false,
            contentType: false,
            processData: false,
            success : function(response) {
                if(response)
                    isExists=true;
                else
                    isExists=false;
            }
        });
        return isExists;
    }
    /**
     * auto suggest text box for 'Currency Name' field
     */
    $scope.fetchSelectedcurrencyName = function($model,currencyData){
        if($scope.currencyList.length>0){
            angular.forEach($scope.currencyList, function(key,index){
                if ($model === key.currencyName){
                    currencyData.currencyName = key.currencyName;
                }else{
                    currencyData.currencyName=$model;
                }
            })

        }else{
            currencyData.currencyName=$model;
        }
        return currencyData.currencyName;
      }
    // Validation for Vessel Capacity for allowing decimal with 2 digits after
    // point.
    $scope.$watch('currencyData.fromc', function(newValue, oldValue) {
        console.log(newValue);
        var index_dot, arr = String(newValue).split("");
        if (arr.length == undefined)
            return;
        else if (arr.length === 0)
            return;
        else if (arr.length === 1 && (arr[0] == '' || arr[0] === '.'))
            return;
        else if (arr.length === 2 && newValue === '.')
            return;
        else if ((newValue != undefined && newValue != '' && isNaN(newValue)) || ((index_dot = String(newValue).indexOf('.')) != -1 && String(newValue).length - index_dot > 3)) {
            $scope.currencyData.fromc = oldValue;

        }
    });

    // Validation for Vessel Capacity for allowing decimal with 2 digits after
    // point.
    $scope.$watch('currencyData.toc', function(newValue, oldValue) {
        console.log(newValue);
        var index_dot, arr = String(newValue).split("");
        if (arr.length == undefined)
            return;
        else if (arr.length === 0)
            return;
        else if (arr.length === 1 && (arr[0] == '' || arr[0] === '.'))
            return;
        else if (arr.length === 2 && newValue === '.')
            return;
        else if ((newValue != undefined && newValue != '' && isNaN(newValue)) || ((index_dot = String(newValue).indexOf('.')) != -1 && String(newValue).length - index_dot > 3)) {
            $scope.currencyData.toc = oldValue;

        }
    });

    // Validation for Vessel Capacity for allowing decimal with 2 digits after
    // point.
    $scope.$watch('currencyData.capacity', function(newValue, oldValue) {
        console.log(newValue);
        var index_dot, arr = String(newValue).split("");
        if (arr.length == undefined)
            return;
        else if (arr.length === 0)
            return;
        else if (arr.length === 1 && (arr[0] == '' || arr[0] === '.'))
            return;
        else if (arr.length === 2 && newValue === '.')
            return;
        else if ((newValue != undefined && newValue != '' && isNaN(newValue)) || ((index_dot = String(newValue).indexOf('.')) != -1 && String(newValue).length - index_dot > 3)) {
            $scope.currencyData.capacity = oldValue;

        }
    });

    // Validation for Vessel Capacity for allowing decimal with 2 digits after
    // point.
    $scope.$watch('currencyData.currencyDefault', function(newValue, oldValue) {
        console.log(newValue);
        var index_dot, arr = String(newValue).split("");
        if (arr.length == undefined)
            return;
        else if (arr.length === 0)
            return;
        else if (arr.length === 1 && (arr[0] == '' || arr[0] === '.'))
            return;
        else if (arr.length === 2 && newValue === '.')
            return;
        else if ((newValue != undefined && newValue != '' && isNaN(newValue)) || ((index_dot = String(newValue).indexOf('.')) != -1 && String(newValue).length - index_dot > 4)) {
            $scope.currencyData.currencyDefault = oldValue;

        }
    });

    // Validation for Basic Pay For only allowing numbers
    $scope.$watch('currencyData.currencyFraction', function(newValue, oldValue) {
        console.log(newValue);
        var index_dot, arr = String(newValue).split("");
        if (arr.length == undefined)
            return;
        else if (arr.length === 0)
            return;
        else if (arr.length === 1 && (arr[0] == '' || arr[0] === '.'))
            return;
        else if (arr.length === 2 && newValue === '.')
            return;
        else if ((newValue != undefined && newValue != '' && isNaN(newValue)) || ((index_dot = String(newValue).indexOf('.')) != -1 && String(newValue).length - index_dot > 3)) {
            $scope.currencyData.currencyFraction = oldValue;

        }
    });

    $scope.checkValidation = function() {

  	    var alertmsg = "<ui><h4>Please fill the required fields</h4>";
  	    var msg = "";
  	  /*  if ($scope.checkundefined($scope.quotation.commodity)) {
  	        msg = msg + "<li>Commodity:Field is required.</li>";         
  	        $scope.changecolor('commodity');
  	    }else{
  	    	$scope.clearcolor('commodity');
  	    }*/
  	    if ($scope.checkundefined($scope.currencyData.currencyCode)) {
  	        msg = msg + "<li>currencyCode:Field is required.</li>";         
  	        $scope.changecolor('currencyCode');
  	    }else{
  	    	$scope.clearcolor('currencyCode');
  	    }
  	    if ($scope.checkundefined($scope.currencyData.currencyName)) {
  	        msg = msg + "<li>currencyName:Field is required.</li>";         
  	        $scope.changecolor('currencyName');
  	    }else{
  	    	$scope.clearcolor('currencyName');
  	    }
  	    if ($scope.checkundefined($scope.currencyData.symbol)) {
  	        msg = msg + "<li>symbol:Field is required.</li>";         
  	        $scope.changecolor('symbol');
  	    }else{
  	    	$scope.clearcolor('symbol');
  	    }
  	    if ($scope.checkundefined($scope.currencyData.category)) {
  	        msg = msg + "<li>category:Field is required.</li>";         
  	        $scope.changecolor('category');
  	    }else{
  	    	$scope.clearcolor('category');
  	    }
  	    
  	 alertmsg = alertmsg + msg + "</ui>";
	    if ($scope.checkundefined(msg)) {
	        return '';
	    } else {
	        return alertmsg;
	    }
}

    var s1;
    $scope.save = function(currencyAddForm, currencyData, currencyValidateData) {
    	
      console.log("hello");
      console.log(currencyAddForm, currencyData, currencyValidateData);
        $scope.submitted = true;

        if (currencyValidateData.isEdit == false) {
            if (currencyAddForm.$invalid) {
                logger.logError(s1);
                s1 = "";

            } else {

                var addRowData = currencyData;
                console.log("addRowData");
                console.log(addRowData);


                $http.post($stateParams.tenantid+'/app/currency/add', addRowData).success(function(data) {
                    console.log("result");
                    console.log(data);
                   if (data.success == false) {
                        logger.logError(data.errors);
                    }
                    else if (data.success==true) {
                        logger.logSuccess("Saved successfully!");
                        $state.go('app.finance.configuration.currency.list',{tenantid:$stateParams.tenantid});
                    }
                }).error(function(data) {
                    console.log("data");
                });

            }
        } else {

            var updateRowData = currencyData;

            console.log("Update");
            console.log(updateRowData);

            $http.post($stateParams.tenantid+'/app/currency/update', updateRowData).success(function(result) {
                if (result == false) {
                    logger.logError(" Currency Name Already Exist");
                }

                else if (result) {
                    logger.logSuccess("Updated successfully!");
                    $state.go('app.finance.configuration.currency.list',{tenantid:$stateParams.tenantid});
                } else {
                    logger.logError("Not Updated!");
                }
            }).error(function(result) {
                console.log("data" + result);
            });

        }
    }
    // Fetch Values

    $scope.FetchingValues = function(data) {
        debugger;
        console.log("Edit Values");
        console.log(data);
        if (data.$$hashKey == undefined) {
            $scope.currencyData = angular.copy($scope.currencyDataClear);
            $scope.currencyValidateData.isEdit = false;
        } else {
        	 $scope.currencyData.currencyId = data.currencyId;
            $scope.currencyData.currencyCode = data.currencyCode;
            $scope.currencyData.currencyName = data.currencyName;
            $scope.currencyData.defaultCurrency = data.defaultCurrency;
            $scope.currencyData.currencyFraction = data.currencyFraction;
            $scope.currencyData.fromCurrency= data.fromCurrency;
            $scope.currencyData.toCurrency = data.toCurrency;
            $scope.currencyData.isActive = data.isActive;
            $scope.currencyData.isRound = data.isRound;
            $scope.currencyData.symbol = data.symbol;
            $scope.currencyData.category = data.category;
            $scope.currencyData.description = data.description;
            $scope.currencyData.bookCurrency = data.bookCurrency;
            $scope.currencyValidateData.isEdit = true;
            $scope.currencyValidateData.currencyCodeEdit = true;
        }
    }
    $scope.FetchingValues(sharedProperties.getObject());

});