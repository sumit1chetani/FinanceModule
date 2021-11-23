'use strict';
app.controller('thcatqtyCtrl', function($scope, $rootScope, $http, logger, $timeout, $log, ngDialog, $modal, $location, $state, $filter, utilsService) {
    $scope.hideBreadcrumb = true;
    $scope.hideEditIcon = true;
    $scope.customerlist = [];
    $scope.portList = [];
    $http.get('app/TransQuot/getPort').success(function(datas) {
        $scope.portList = datas;
    }).error(function(data) {

    });
    $http.get('app/purchaseinvoice/getCurrencyList').success(function(datas) {
        $scope.currencyList = datas;
    }).error(function(datas) {
    });
    $scope.edit = false;
    $('#validFromDate').datetimepicker({
        format : 'DD/MM/YYYY'
    });

    // $('#validToDate').datetimepicker({
    // format : 'DD/MM/YYYY'
    // });
    $http.get('app/Quotation/getMloMaster').success(function(datas) {
        $scope.customerlist = datas.lQuotationBean;
        $("#customer_id").multiselect({
            maxHeight : 200,
            includeSelectAllOption : true,
            disableIfEmpty : true,
            enableCaseInsensitiveFiltering : true,
            onDropdownHide : function(event) {

            },
            onChange : function(element, checked) {
                console.log(element);
                console.log($scope.customer);
                $scope.thcaatuqr.customer = '';
                if ($scope.customer.length > 0) {
                    $scope.thcaatuqr.customer = $scope.customer.join(",");
                }
            }
        });
        $timeout(function() {
            $('#customer_id').multiselect('deselectAll', false);
            $('#customer_id').multiselect('updateButtonText');
            $("#customer_id").multiselect('rebuild');

        }, 2, false);
    }).error(function(data) {

    });

    $scope.getTermsOfShipment = function() {

        var data = {};
        data["id"] = "FIFO";
        data["text"] = "FIFO";
        $scope.termsofshipmentList.push(data);
        data = {};
        data["id"] = "CY/FO";
        data["text"] = "CY/FO";
        $scope.termsofshipmentList.push(data);
        data = {};
        data["id"] = "FI/CY";
        data["text"] = "FI/CY";
        $scope.termsofshipmentList.push(data);
        data = {};
        data["id"] = "FI/HK";
        data["text"] = "FI/HK";
        $scope.termsofshipmentList.push(data);
        data = {};
        data["id"] = "HK/FO";
        data["text"] = "HK/FO";
        $scope.termsofshipmentList.push(data);
        data = {};
        data["id"] = "HK/CY";
        data["text"] = "HK/CY";
        $scope.termsofshipmentList.push(data);
        data = {};
        data["id"] = "CY/HK";
        data["text"] = "CY/HK";
        $scope.termsofshipmentList.push(data);

        data = {};
        data["id"] = "CY/CY";
        data["text"] = "CY/CY";
        $scope.termsofshipmentList.push(data);
        data = {};
        data["id"] = "FI/TK";
        data["text"] = "FI/TK";
        $scope.termsofshipmentList.push(data);
        data = {};
        data["id"] = "TK/FO";
        data["text"] = "TK/FO";
        $scope.termsofshipmentList.push(data);
        data = {};
        data["id"] = "CY/TK";
        data["text"] = "CY/TK";
        $scope.termsofshipmentList.push(data);
    }
    $scope.termsofshipmentList = [];
    $scope.getTermsOfShipment();
    $scope.getTranslationList = function() {
        $scope.showEmptyLabel = false;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];

        var url = 'app/thcatuqr/list?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount;
        $http.get(url).success(function(data) {
            $scope.rowCollection = data.lThcAtUqrBean;
            var datas = $scope.rowCollection;

            var len = $scope.rowCollection.length;
            for (var i = 0; i < len; i++) {
                var rowData = datas[i];

                if (rowData.validTill == null) {
                    rowData.iconview = true;
                }
            }
            if (data.success == true) {
                $scope.pushTranslationListUtil(data);
            } else {

                $scope.showEmptyLabel = true;

                logger.logError("Error Please Try Again");
            }

        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });

    };
    $scope.pushTranslationListUtil = function(data) {
        if (utilsService.isUndefinedOrNull(data.lThcAtUqrBean)) {

            $scope.showEmptyLabel = true;

        } else {
            $scope.rowCollection = data.lThcAtUqrBean;

        }
    };
    $("#customer_id").css("display", "block");
    $scope.getTranslationList();
    $scope.add = function() {
        $scope.edit = false;

        $scope.thcaatuqr = {
            customer : '',
            port : '',
            imco20 : 0.0,
            imco40 : 0.0,
            r20 : 0.0,
            m20 : 0.0,
            r40 : 0.0,
            m40 : 0.0,
            d20 : 0.0,
            d40 : 0.0,
            d45 : 0.0,
            m45 : 0.0,
            mh40 : 0.0,
            dh40 : 0.0,

            oog20 : 0.0,
            oog40 : 0.0,
            currency : '',
            shipment : '',

            ri20 : 0.0,
            ri40 : 0.0,
            di20 : 0.0,
            di40 : 0.0,
            mi20 : 0.0,
            mi40 : 0.0,
            rh40 : 0.0,
            oogi20:0.0,
            oogi40:0.0,
            generalMertic : 0.0,
            stevedore : 0.0,
            validFrom : '',
            validTill : ''
        }
        $("#customer_id").multiselect({
            maxHeight : 200,
            includeSelectAllOption : true,
            disableIfEmpty : true,
            enableCaseInsensitiveFiltering : true,
            onDropdownHide : function(event) {

            },

            onChange : function(element, checked) {
                console.log(element[0]);
                console.log($scope.customer);
                $scope.thcaatuqr.customer = '';
                if ($scope.customer.length > 0) {
                    $scope.thcaatuqr.customer = $scope.customer.join(",");
                }
            }
        });
        $timeout(function() {
            $('#customer_id').multiselect('deselectAll', false);
            $('#customer_id').multiselect('updateButtonText');
            $("#customer_id").multiselect('rebuild');

        }, 2, false);
        $("#thcatuqr").css("display", "block");
        $("#listthcatuqr").css("display", "none");
        $scope.disabled = false;

    }
    $scope.editrow = function(obj) {
        $scope.edit = true;
        $("#customer_id").multiselect("disable");
        $scope.thcaatuqr = {
            customer : obj.customer,
            customerName : obj.customerName,
            port : obj.port,
            imco20 : obj.imco20,
            imco40 : obj.imco40,
            r20 : obj.r20,
            m20 : obj.m20,
            r40 : obj.r40,
            m40 : obj.m40,
            d20 : obj.d20,
            d40 : obj.d40,
            d45 : obj.d45,
            m45 : obj.m45,
            mh40 : obj.mh40,
            dh40 : obj.dh40,
            oog20 : obj.oog20,
            oog40 : obj.oog40,
            currency : obj.currency,
            id : obj.id,
            shipment : obj.shipment,
            ri20 : obj.ri20,
            ri40 : obj.ri40,
            di20 : obj.di20,
            di40 : obj.di40,
            mi20 : obj.mi20,
            mi40 : obj.mi40,
            rh40 : obj.rh40,
            oogi20:obj.oogi20,
            oogi40:obj.oogi40,
            generalMertic : obj.generalMertic,
            stevedore : obj.stevedore,
            validFrom : obj.validFrom,
            validTill : obj.validTill
        }
        var arr = [];
        arr.push("string:" + obj.customer);
        $('#customer_id').multiselect('select', arr);
        $scope.customer = obj.customer;
        $scope.disabled = true;
    
        $("#thcatuqr").css("display", "block");
        $("#listthcatuqr").css("display", "none");
      
    }
    $scope.cancel = function() {

        $("#thcatuqr").css("display", "none");
        $("#listthcatuqr").css("display", "block");

    }
    $scope.customer = [];
    $scope.submit = function(thcaatuqr) {
        thcaatuqr.validFrom = $('#validFrom').val();

        $http.post('app/thcatuqr/add', thcaatuqr).success(function(data) {

            if (data.success == true) {
                logger.logSuccess("Data Saved Successfully");
                $scope.getTranslationList();
            
                $("#thcatuqr").css("display", "none");
                $("#listthcatuqr").css("display", "block");
            } else {
                logger.logError("Unable to save data");
            }
        }).error(function(data) {

        });
    }

    $scope.submitupdate = function(thcaatuqr) {

        thcaatuqr.validFrom = $('#validFrom').val();
        $http.post('app/thcatuqr/add', thcaatuqr).success(function(data) {

            if (data.success == true) {
                logger.logSuccess("Data Updated Successfully");
                $scope.getTranslationList();
                $("#thcatuqr").css("display", "none");
                $("#listthcatuqr").css("display", "block");
                $scope.getTranslationList();
            } else {
                logger.logError("Unable to save data");
            }
        }).error(function(data) {

        });
    }
    $scope.addthc = function() {
        $location.path('/master/thcatuqr');

    }
    $scope.deleterow = function(id) {

        ngDialog.openConfirm().then(function() {
            var url = 'app/thcatuqr/delete?id=' + id;

            $http.get(url).success(function(result) {

                if (result) {
                    logger.logSuccess("Data Deleted Successfully");
                    $state.reload();
                } else {
                    logger.logError("Error in Delete data");

                }

            }).error(function(result) {
                logger.logError("Error Please Try Again");

            })
        }, function(reason) {
            console.log('Modal promise rejected. Reason: ', reason);
        });

    }
});