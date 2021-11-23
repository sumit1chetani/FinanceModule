app.controller('revenueregisterCtrl', function($scope, $window, $rootScope, $location, $http, $filter, logger, $log, ngDialog, $modal, utilsService, $state, $timeout,$stateParams) {
    $scope.polList = [];
    $scope.podList = [];
    $scope.payerList = [];
    $scope.customerList = [];
    $scope.companyList = [];
    $scope.modeList = [];
    $scope.excelList = [];
    $scope.messageHeaderList = [];
    $scope.displayedCollection = [];
    $scope.categoryWiseList = [];
    $scope.customerTypelist = [];
    $scope.creditCategorylist = [];
    $scope.serviceList = [];
    $scope.paymentCenterList = [];
    $scope.revenueregister = {
        voyage : '',
        sectorId : '',
        sailingDate : '',
        accountHeadName : '',
        pol : '',
        lpol : [],
        pod : '',
        lpod : [],
        fromDate : '',
        invoiceDt : '',
        toDate : '',
        company : '',
        invoiceNo : '',
        lCustomerType : [],
        customerType : '',
        lcreditCategory : [],
        creditCategory : '',
        lcategory : [],
        category : '',
        portisocode : '',
        podisocode : '',
        payer : '',
        lpayer : [],
        customer : '',
        lcustomer : [],
        invoicefromDate : '',
        invoicetoDate: '',
        paymentCenter : ''

    }

    $scope.getListOfDropdowns = function() {
        $http.get($stateParams.tenantid+'/app/payer/getListOfDropdowns').success(function(data) {
            if (data.success == true) {
                 $scope.paymentCenterList = data.paymentCenterList;
            }
        });
    }
    $scope.getListOfDropdowns();
    

    
    
    $scope.getReprtHeader = function() {

        $http.get($stateParams.tenantid+'/app/revenuereport/getReprtHeader').success(function(datas) {
            console.log("report header")
            console.log(datas)
            $scope.messageHeaderList = datas.getRevenueHeaderList;
        }).error(function(datas) {
        });

    }

    $scope.getReprtHeader();
    // plugin add
    $scope.selectall = true;
    $scope.selectAll = function(value) {
        console.log("value")
        for ( var index in $scope.messageHeaderList) {
            console.log("$scope.messageHeaderList");
            console.log($scope.messageHeaderList[index])
            var colum = $scope.messageHeaderList[index];
            if (colum.isDefault == false) {
                if (value == true) {
                    colum.visible = true;
                } else {
                    colum.visible = false;
                }
            }
        }

    }
    $scope.selectedVisibility = [];
    $scope.getSelectedColumn = function(index) {

        var value = $scope.messageHeaderList.indexOf(index);
        var indexExsists = $scope.selectedVisibility.indexOf(index);
        if (indexExsists == -1) {
            $scope.selectedVisibility.push(value);
        }
    };

    $scope.onDropComplete = function(index, obj, evt) {
        var otherIndex = $scope.messageHeaderList.indexOf(obj);

        if (index != undefined) {
            $scope.messageHeaderList.splice(otherIndex, 1);
            $scope.messageHeaderList.splice(index, 0, obj);
        }

        else if (index = "undefined") {
            $scope.messageHeaderList.splice(otherIndex, 1);
            $scope.messageHeaderList.splice($scope.messageHeaderList.length, 0, obj);
        }
    };

    // plugin add

    // ports

    $http.get($stateParams.tenantid+'/analytical/operatingExpenses/add').success(function(datas) {
        $scope.podList = datas;
        $timeout(function() { // You might need this timeout to be sure its
            // run after DOM render.
            $("#pod").multiselect({
                maxHeight : 200,
                includeSelectAllOption : true,
                selectAllText : 'Select All',
                enableFiltering : true,
                enableCaseInsensitiveFiltering : true,
                filterPlaceholder : 'Search',
                onChange : function(element, checked) {
                    console.log(element);
                    var ct = "";
                    if ($scope.podList.length > 0) {
                        console.log($scope.revenueregister.lpod);
                        $scope.revenueregister.pod = '';
                        angular.forEach($scope.revenueregister.lpod, function(item, key) {
                            console.log("pod")
                            console.log(item);
                            if (ct == "") {
                                ct = item.id;
                            } else {
                                ct += "," + item.id;
                            }
                            $scope.revenueregister.pod = ct;
                            console.log("pod selected")
                            console.log($scope.revenueregister.pod)
                        });
                    }

                    else {
                        $scope.podList = [];
                        $scope.podList = 'Select';
                    }
                }
            });
            $("#pod").parent().find('.btn-group #multiselect-button').addClass('width_100 input-sm line-height-5');
        }, 2, false);

    });

    $http.get($stateParams.tenantid+'/analytical/operatingExpenses/add').success(function(datas) {
        $scope.polList = datas;

        // pol list

        $timeout(function() { // You might need this timeout to be sure its
            // run after DOM render.
            $("#pol").multiselect({
                maxHeight : 200,
                includeSelectAllOption : true,
                selectAllText : 'Select All',
                enableFiltering : true,
                enableCaseInsensitiveFiltering : true,
                filterPlaceholder : 'Search',
                onChange : function(element, checked) {
                    console.log(element);
                    var ct = "";
                    if ($scope.polList.length > 0) {
                        console.log($scope.revenueregister.lpol);
                        $scope.revenueregister.pol = '';
                        angular.forEach($scope.revenueregister.lpol, function(item, key) {
                            console.log("pol")
                            console.log(item);
                            if (ct == "") {
                                ct = item.id;
                            } else {
                                ct += "," + item.id;
                            }
                            $scope.revenueregister.pol = ct;
                            console.log(" pol selected")
                            console.log($scope.revenueregister.pol)
                        });
                    }

                    else {
                        $scope.polList = [];
                        $scope.polList = 'Select';
                    }
                }
            });
            $("#pol").parent().find('.btn-group #multiselect-button').addClass('width_100 input-sm line-height-5');
        }, 2, false);

    }).error(function(data) {

    });

    $http.get($stateParams.tenantid+'/app/revenuereport/getportisocode').success(function(datas) {
        $scope.portIsoList = datas;

    }).error(function(data) {

    });

    // company
    $http.get($stateParams.tenantid+'/app/usermaster/getCompanyList?formCode=' + $('#form_code_id').val()).success(function(data) {
        console.log(data)
        $scope.companyList = data;
        data["id"] = "ALL";
		data["text"] = "ALL";
		$scope.companyList.push(data);
    }).error(function(data) {
    });

    // payer list

    $http.get($stateParams.tenantid+'/app/revenuereport/getpayer').success(function(data) {
        console.log("payer")
        console.log(data)
        $scope.payerList = data;

        console.log($scope.payerList)

        // pol list

        $timeout(function() { // You might need this timeout to be sure its
            // run after DOM render.
            $("#payer").multiselect({
                maxHeight : 200,
                includeSelectAllOption : true,
                selectAllText : 'Select All',
                enableFiltering : true,
                enableCaseInsensitiveFiltering : true,
                filterPlaceholder : 'Search',
                onChange : function(element, checked) {
                    console.log(element);
                    var ct = "";
                    if ($scope.payerList.length > 0) {
                        console.log($scope.revenueregister.lpayer);
                        $scope.revenueregister.payer = '';
                        angular.forEach($scope.revenueregister.lpayer, function(item, key) {
                            console.log("payer")
                            console.log(item);
                            if (ct == "") {
                                ct = item.id;
                            } else {
                                ct += "," + item.id;
                            }
                            $scope.revenueregister.payer = ct;
                            console.log(" payer selected")
                            console.log($scope.revenueregister.payer)
                        });
                    }

                    else {
                        $scope.payerList = [];
                        $scope.payerList = 'Select';
                    }
                }
            });
            $("#payer").parent().find('.btn-group #multiselect-button').addClass('width_100 input-sm line-height-5');
        }, 2, false);

    }).error(function(data) {

    });

    $http.get($stateParams.tenantid+'/app/revenuereport/getCustomer').success(function(data) {
        console.log("Cust")
        console.log(data)
        $scope.customerList = data;

        $timeout(function() { // You might need this timeout to be sure its
            // run after DOM render.
            $("#customer").multiselect({
                maxHeight : 200,
                includeSelectAllOption : true,
                selectAllText : 'Select All',
                enableFiltering : true,
                enableCaseInsensitiveFiltering : true,
                filterPlaceholder : 'Search',
                onChange : function(element, checked) {
                    console.log(element);
                    var ct = "";
                    if ($scope.customerList.length > 0) {
                        console.log($scope.revenueregister.lcustomer);
                        $scope.revenueregister.customer = '';
                        angular.forEach($scope.revenueregister.lcustomer, function(item, key) {
                            console.log("customer")
                            console.log(item);
                            if (ct == "") {
                                ct = item.id;
                            } else {
                                ct += "," + item.id;
                            }
                            $scope.revenueregister.customer = ct;
                            console.log(" customer selected")
                            console.log($scope.revenueregister.customer)
                        });
                    }

                    else {
                        $scope.customerList = [];
                        $scope.customerList = 'Select';
                    }
                }
            });
            $("#customer").parent().find('.btn-group #multiselect-button').addClass('width_100 input-sm line-height-5');
        }, 2, false);

    }).error(function(data) {

    });

    /*
     * $http.get('app/commonUtility/getCompanyList').success(function(datas) {
     * $scope.companyList = datas; }).error(function(datas) { });
     */

    // service
    $http.get($stateParams.tenantid+'/app/agencyTariff/service').success(function(datas) {
        $scope.serviceList = datas.serviceList;
    }).error(function(data) {
    });

    // voyage


  /*  $http.get($stateParams.tenantid+'/purchaseOrder/voyageList').success(function(response) {
        if (response.success == true) {
            $scope.voyageList = response.voyageList;
        } else {
            logger.logError("Error in Trip List");
        }
    })*/

    
        $scope.modeList=[{
        id : '1',
        text : 'Sea'
    }, {
        id : '2',
        text : 'Air'
    },{
        id : '3',
        text : 'ALL'
    }];
    
    /*
     * $scope.categoryWiseList=[{id:'NV1',text:'NV-1'},{id:'NV2',text:'NV-2'},{id:'NV3',text:'NV-3'},{id:'NV4',text:'NV-4'},
     * {id:'NV5',text:'NV-5'},{id:'MLO',text:'Customer'},{id:'JVP',text:'JVP'},{id:'AGENT',text:'AGENT'}];
     * 
     * $scope.customerTypelist=
     * [{id:'MLO',text:'Customer'},{id:'NVOCC',text:'NVOCC'},{id:'JVP',text:'JVP'},{id:'AGENT',text:'AGENT'}];
     * 
     * $scope.creditCategorylist =[{id:'C',text:'CREDIT'},{id:'D',text:'DEPOSIT
     * CHEQUE'}, {id:'P',text:'PRIOR LOADING'}];
     */

    // CHANGE TO MULTI SELECT
    $scope.categoryWiseList = [ {
        id : 'NV1',
        text : 'NV-1',
        category : 'NV-1'
    }, {
        id : 'NV2',
        text : 'NV-2',
        category : 'NV-2'
    }, {
        id : 'NV3',
        text : 'NV-3',
        category : 'NV-3'
    }, {
        id : 'NV4',
        text : 'NV-4',
        category : 'NV-4'
    }, {
        id : 'NV5',
        text : 'NV-5',
        category : 'NV-5'
    }, {
        id : 'MLO',
        text : 'Customer',
        category : 'Customer'
    }, {
        id : 'JVP',
        text : 'JVP',
        category : 'JVP'
    }, {
        id : 'AGENT',
        text : 'AGENT',
        category : 'AGENT'
    } ];

    $scope.customerTypelist = [ {
        id : 'MLO',
        text : 'MLO'
    }, {
        id : 'NVOCC',
        text : 'NVOCC'
    }, {
        id : 'JVP',
        text : 'JVP'
    }, {
        id : 'AGENT',
        text : 'AGENT'
    } ];

    $scope.creditCategorylist = [ {
        id : 'C',
        text : 'CREDIT',
        creditCategory : 'CREDIT'
    }, {
        id : 'D',
        text : 'DEPOSIT CHEQUE',
        creditCategory : 'DEPOSIT CHEQUE'
    }, {
        id : 'P',
        text : 'PRIOR LOADING',
        creditCategory : 'PRIOR LOADING'
    } ];

    $scope.getCategoryOptionId = function(option) {
        return option.id;
    };
    $scope.getcreditCategoryOptionId = function(option) {
        return option.id;
    };

    $scope.getCustomerTypeId = function(option) {
        return option.id;
    };
    $scope.getpodId = function(option) {
        return option.id;
    };
    $scope.getpolId = function(option) {
        return option.id;
    };

    $scope.getpayer = function(option) {
        return option.id;
    };

    $scope.getcustomer = function(option) {
        return option.id;
    };

    // pod

    // company type list

    $timeout(function() { // You might need this timeout to be sure its run
        // after DOM render.
        $("#customerType").multiselect({
            maxHeight : 200,
            includeSelectAllOption : true,
            selectAllText : 'Select All',
            enableFiltering : true,
            enableCaseInsensitiveFiltering : true,
            filterPlaceholder : 'Search',
            onChange : function(element, checked) {
                console.log(element);
                var ct = "";
                if ($scope.customerTypelist.length > 0) {
                    console.log($scope.revenueregister.lCustomerType);
                    $scope.revenueregister.customerType = '';
                    angular.forEach($scope.revenueregister.lCustomerType, function(item, key) {
                        console.log(" customer item")
                        console.log(item);
                        if (ct == "") {
                            ct = item.id;
                        } else {
                            ct += "," + item.id;
                        }
                        $scope.revenueregister.customerType = ct;
                        console.log(" customer selected")
                        console.log($scope.revenueregister.customerType)
                    });
                }

                else {
                    $scope.customerTypelist = [];
                    $scope.customerTypelist = 'Select';
                }
            }
        });
        $("#companyType").parent().find('.btn-group #multiselect-button').addClass('width_100 input-sm line-height-5');
    }, 2, false);

    // category

    $timeout(function() { // You might need this timeout to be sure its run
        // after DOM render.
        $("#category").multiselect({
            maxHeight : 200,
            includeSelectAllOption : true,
            selectAllText : 'Select All',
            enableFiltering : true,
            enableCaseInsensitiveFiltering : true,
            filterPlaceholder : 'Search',
            onChange : function(element, checked) {
                console.log(element);
                var c = "";
                if ($scope.categoryWiseList.length > 0) {
                    $scope.revenueregister.category = '';
                    angular.forEach($scope.revenueregister.lcategory, function(item, key) {
                        if (c == "") {
                            c = item.id;
                        } else {
                            c += "," + item.id;
                        }
                        $scope.revenueregister.category = c;
                    });
                }

                else {
                    $scope.categoryWiseList = [];
                    $scope.categoryWiseList = 'Select';
                    $("#category").empty();
                }

            }
        });
        $("#category").parent().find('.btn-group #multiselect-button').addClass('width_100 input-sm line-height-5');
    }, 2, false);

    // creditcategory

    $timeout(function() { // You might need this timeout to be sure its run
        // after DOM render.
        $("#creditCategory").multiselect({
            maxHeight : 200,
            includeSelectAllOption : true,
            selectAllText : 'Select All',
            enableFiltering : true,
            enableCaseInsensitiveFiltering : true,
            filterPlaceholder : 'Search',
            onChange : function(element, checked) {
                console.log(element);
                var cc = "";
                if ($scope.creditCategorylist.length > 0) {
                    $scope.revenueregister.creditCategory = '';
                    angular.forEach($scope.revenueregister.lcreditCategory, function(item, key) {
                        if (cc == "") {
                            cc = item.id;
                        } else {
                            cc += "," + item.id;
                        }
                        $scope.revenueregister.creditCategory = cc;
                    });
                }

                else {
                    $scope.creditCategorylist = [];
                    $scope.creditCategorylist = 'Select';
                    $("#creditCategory").empty();
                }
            }
        });
        $("#creditCategory").parent().find('.btn-group #multiselect-button').addClass('width_100 input-sm line-height-5');
    }, 2, false);

    // CHANGE TO MULTI SELECT

    // function call
    $scope.onSearch = function(revenueregister) {
        console.log("revenue register  search");
        console.log(revenueregister);
        var val=$scope.valDate();
        if(val){
        $http.post($stateParams.tenantid+"/app/revenuereport/getReport", revenueregister).success(function(response) {

            $scope.rowCollection = response.lrevenueregisterlist;
            
           /* angular.forEach($scope.rowCollection, function(value,key){
            	if(value.voyage == '1'){
            		value.voyage = 'SEA';
            	}else if(value.voyage == '2'){
            		value.voyage = 'AIR';
            	}else{
            		value.voyage = '';
            	}
            	
            });*/
            console.log("final result")
            console.log($scope.rowCollection)
            $scope.excelList = response.lrevenueregisterlist;
            
           /* angular.forEach($scope.rowCollection, function(value,key){
            	if(value.voyage == '1'){
            		value.voyage = 'SEA';
            	}else if(value.voyage == '2'){
            		value.voyage = 'AIR';
            	}else{
            		value.voyage = '';
            	}
            	
            });*/

        }).error(function(result) {
            logger.logError("Error Please Try Again");
        });
    }else{
    	logger.logError($scope.errMsg1);
    	
    }
  

    }
    // excel
  
    $scope.valDate = function() {
    	  $scope.errMsg1="";
     
        if($scope.revenueregister.invoicefromDate==undefined || $scope.revenueregister.invoicefromDate==""){
        	$scope.errMsg1="Please select From Invoice Date and To Invoice Date";
        	return false;
        }else if($scope.revenueregister.invoicetoDate==undefined ||  $scope.revenueregister.invoicetoDate==""){
        	$scope.errMsg1="Please select From Invoice Date and To Invoice Date";
        	return false;
        }else if($scope.revenueregister.voyage==undefined || $scope.revenueregister.voyage=="" ){
        	$scope.errMsg1="Please select Mode";
        	return false;
        }
        else{
        	
        	return true;
        }
        	

    }
   
    $scope.reset = function() {
        $scope.revenueregister.voyage = '';
        $scope.revenueregister.sectorId = '';
        $scope.revenueregister.sailingDate = '';
        $scope.revenueregister.company = '';
        $scope.revenueregister.pol = '';
        $scope.revenueregister.pod = '';
        $scope.revenueregister.fromDate = '';
        $scope.revenueregister.toDate = '';
        $scope.revenueregister.creditCategory = '';
        $scope.revenueregister.category = '';
        $scope.revenueregister.invoiceNo = '';
        $scope.revenueregister.customerType = '';

    }

    // excel export
    $scope.excel = function(revenueregister) {

        var groupHeaderSelectedList = $filter('filter')($scope.messageHeaderList, {
            visible : true
        }, true);
        var objWholeData = {
            'lrevenueregisterlist' : $scope.excelList,
            'lrevenueheaderlist' : groupHeaderSelectedList,
            'revenueregisterBean' : revenueregister
        };

        console.log("revenue excel")
        console.log(objWholeData);

        $http.post($stateParams.tenantid+"/app/revenuereport/generateExcel", objWholeData).success(function(response) {

            $('#exportXl').append('<a id="tbExcelExport" stype="display:none" href="filePath/RevenueRegister.xls" download="RevenueRegister.xls"></a>');
            $("#tbExcelExport").bind('click', function() {
            });
            $('#tbExcelExport').simulateClick('click');

        }).error(function(result) {
            logger.logError("Error Please Try Again");
        });
        $.fn.simulateClick = function() {
            return this.each(function() {
                if ('createEvent' in document) {
                    var doc = this.ownerDocument, evt = doc.createEvent('MouseEvents');
                    evt.initMouseEvent('click', true, true, doc.defaultView, 1, 0, 0, 0, 0, false, false, false, false, 0, null);
                    this.dispatchEvent(evt);
                } else {
                    this.click(); // IE
                }
            });
        }

    }

});
