app.controller('profitAndLossJobwiseController', function($scope, $window, $rootScope, $location, $http, $filter, logger, $log, ngDialog, $modal, utilsService, $state, $timeout,$stateParams,
		validationService,toaster) {
    $scope.polList = [];
    $scope.podList = [];
    $scope.payerList = [];
    $scope.customerList = [];
    $scope.companyList = [];
    $scope.voyageList = [];
    $scope.excelList = [];
    $scope.messageHeaderList = [];
    $scope.displayedCollection = [];
    $scope.categoryWiseList = [];
    $scope.customerTypelist = [];
    $scope.creditCategorylist = [];
    $scope.serviceList = [];
    $scope.paymentCenterList = [];
    $scope.joborder = {
        voyage : '',
        sectorId : '',
        sailingDate : '',
        accountHeadName : '',
        pol : '',
        lpol : [],
        lservice : [],
        lsales : [],
        lstatus: [],
        lterm: [],

        service :'',
        sales :'',
        status:'',
        jobStatus: '2',
        term:'',
        pod : '',
        lpod : [],
        aol : '',
        laol : [],
        aod : '',
        laod : [],
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
        fromDate : '',
    toDate: '',
        paymentCenter : ''

    }
    
   



    
    $scope.getReprtHeader = function() {

        $http.get($stateParams.tenantid+'/app/profitloss/getReprtHeader').success(function(datas) {
            console.log("report header")
            console.log(datas)
            $scope.messageHeaderList = datas.getJobOrderReportHeaderList;
            $scope.printMessageHeaderList=$scope.messageHeaderList;
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
                        console.log($scope.joborder.lpod);
                        $scope.joborder.pod = '';
                        angular.forEach($scope.joborder.lpod, function(item, key) {
                            console.log("pod")
                            console.log(item);
                            if (ct == "") {
                                ct = item.id;
                            } else {
                                ct += "," + item.id;
                            }
                            $scope.joborder.pod = ct;
                            console.log("pod selected")
                            console.log($scope.joborder.pod)
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
                        console.log($scope.joborder.lpol);
                        $scope.joborder.pol = '';
                        angular.forEach($scope.joborder.lpol, function(item, key) {
                            console.log("pol")
                            console.log(item);
                            if (ct == "") {
                                ct = item.id;
                            } else {
                                ct += "," + item.id;
                            }
                            $scope.joborder.pol = ct;
                            console.log(" pol selected")
                            console.log($scope.joborder.pol)
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

   
    
    
    
 // ports

    $http.get($stateParams.tenantid+'/app/freightmanifest/add').success(function(datas) {
        $scope.aodList = datas;
        $timeout(function() { // You might need this timeout to be sure its
            // run after DOM render.
            $("#aod").multiselect({
                maxHeight : 200,
                includeSelectAllOption : true,
                selectAllText : 'Select All',
                enableFiltering : true,
                enableCaseInsensitiveFiltering : true,
                filterPlaceholder : 'Search',
                onChange : function(element, checked) {
                    console.log(element);
                    var ct = "";
                    if ($scope.aodList.length > 0) {
                        console.log($scope.joborder.laod);
                        $scope.joborder.aod = '';
                        angular.forEach($scope.joborder.laod, function(item, key) {
                            console.log("aod")
                            console.log(item);
                            if (ct == "") {
                                ct = item.id;
                            } else {
                                ct += "," + item.id;
                            }
                            $scope.joborder.aod = ct;
                            console.log("aod selected")
                            console.log($scope.joborder.aod)
                        });
                    }

                    else {
                        $scope.aodList = [];
                        $scope.aodList = 'Select';
                    }
                }
            });
            $("#aod").parent().find('.btn-group #multiselect-button').addClass('width_100 input-sm line-height-5');
        }, 2, false);

    });

    $http.get($stateParams.tenantid+'/app/freightmanifest/add').success(function(datas) {
        $scope.aolList = datas;

        // aol list

        $timeout(function() { // You might need this timeout to be sure its
            // run after DOM render.
            $("#aol").multiselect({
                maxHeight : 200,
                includeSelectAllOption : true,
                selectAllText : 'Select All',
                enableFiltering : true,
                enableCaseInsensitiveFiltering : true,
                filterPlaceholder : 'Search',
                onChange : function(element, checked) {
                    console.log(element);
                    var ct = "";
                    if ($scope.aolList.length > 0) {
                        console.log($scope.joborder.laol);
                        $scope.joborder.aol = '';
                        angular.forEach($scope.joborder.laol, function(item, key) {
                            console.log("aol")
                            console.log(item);
                            if (ct == "") {
                                ct = item.id;
                            } else {
                                ct += "," + item.id;
                            }
                            $scope.joborder.aol = ct;
                            console.log(" aol selected")
                            console.log($scope.joborder.aol)
                        });
                    }

                    else {
                        $scope.aolList = [];
                        $scope.aolList = 'Select';
                    }
                }
            });
            $("#aol").parent().find('.btn-group #multiselect-button').addClass('width_100 input-sm line-height-5');
        }, 2, false);

    }).error(function(data) {

    });

    
    
	

    $scope.servicePartnerTypelist = [];
    /*$scope.servicePartnerType=function(){
    
    $http.get(
			$stateParams.tenantid
					+ '/app/airquotation/getServicePartnerType').success(
			function(datas) {
				$scope.servicePartnerTypelist = angular
						.copy(datas.commonUtilityBean);
			});
    }*/
    $scope.servicePartnerType = function() {
		var data = {};
		data["id"] = "1";
		data["text"] = "Export";
		$scope.servicePartnerTypelist.push(data);
		data = {};
		data["id"] = "2";
		data["text"] = "Import";
		$scope.servicePartnerTypelist.push(data);
		data = {};
		

	}
    $scope.servicePartnerType()	  
			  	 // Service

			  	    $timeout(function() { // You might need this timeout to be sure its run
			  	        // after DOM render.
			  	        $("#service").multiselect({
			  	            maxHeight : 200,
			  	            includeSelectAllOption : true,
			  	            selectAllText : 'Select All',
			  	            enableFiltering : true,
			  	            enableCaseInsensitiveFiltering : true,
			  	            filterPlaceholder : 'Search',
			  	            onChange : function(element, checked) {
			  	                console.log(element);
			  	                var cc = "";
			  	                if ($scope.servicePartnerTypelist.length > 0) {
			  	                    $scope.joborder.service = '';
			  	                    angular.forEach($scope.joborder.lservice, function(item, key) {
			  	                        if (cc == "") {
			  	                            cc = item.id;
			  	                        } else {
			  	                            cc += "," + item.id;
			  	                        }
			  	                        $scope.joborder.service = cc;
			  	                    });
			  	                }

			  	                else {
			  	                    $scope.servicePartnerTypelist = [];
			  	                    $scope.servicePartnerTypelist = 'Select';
			  	                    $("#service").empty();
			  	                }
			  	            }
			  	        });
			  	        $("#service").parent().find('.btn-group #multiselect-button').addClass('width_100 input-sm line-height-5');
			  	    }, 2, false);
			  
   
    
    
    $scope.salesTypeList = [];
	$scope.getSalesType = function() {
		var data = {};
		data["id"] = "1";
		data["text"] = "CROSS TRADE";
		$scope.salesTypeList.push(data);
		data = {};
		data["id"] = "2";
		data["text"] = "LOCAL";
		$scope.salesTypeList.push(data);
		data = {};
		data["id"] = "3";
		data["text"] = "NOMINATED";
		$scope.salesTypeList.push(data);

	}
	$scope.getSalesType();

	$scope.statusList = [];

	$scope.getStatus = function() {
		var data = {};
		data["id"] = "1";
		data["text"] = "Open";
		$scope.statusList.push(data);
		data = {};
		data["id"] = "2";
		data["text"] = "Close";
		$scope.statusList.push(data);
		data = {};
		

	}
	$scope.getStatus();
	
	
	 $scope.TermList = [];
	 $scope.getTerm=function(){
	$http.get($stateParams.tenantid + '/app/airquotation/getTerms')
							.success(function(datas) {
								$scope.TermList = datas.commonUtilityBean;

							});}
	 $scope.getTerm();
						  	    $timeout(function() { // You might need this timeout to be sure its run
						  	        // after DOM render.
						  	        $("#term").multiselect({
						  	            maxHeight : 200,
						  	            includeSelectAllOption : true,
						  	            selectAllText : 'Select All',
						  	            enableFiltering : true,
						  	            enableCaseInsensitiveFiltering : true,
						  	            filterPlaceholder : 'Search',
						  	            onChange : function(element, checked) {
						  	                console.log(element);
						  	                var cc = "";
						  	                if ($scope.TermList.length > 0) {
						  	                    $scope.joborder.term = '';
						  	                    angular.forEach($scope.joborder.lterm, function(item, key) {
						  	                        if (cc == "") {
						  	                            cc = item.id;
						  	                        } else {
						  	                            cc += "," + item.id;
						  	                        }
						  	                        $scope.joborder.term = cc;
						  	                    });
						  	                }

						  	                else {
						  	                    $scope.TermList = [];
						  	                    $scope.TermList = 'Select';
						  	                    $("#term").empty();
						  	                }
						  	            }
						  	        });
						  	        $("#term").parent().find('.btn-group #multiselect-button').addClass('width_100 input-sm line-height-5');
						  	    }, 2, false);
								
								


    
    
    
    

    
    
    
    
    
    $timeout(function() { // You might need this timeout to be sure its run
	        // after DOM render.
	        $("#sales").multiselect({
	            maxHeight : 200,
	            includeSelectAllOption : true,
	            selectAllText : 'Select All',
	            enableFiltering : true,
	            enableCaseInsensitiveFiltering : true,
	            filterPlaceholder : 'Search',
	            onChange : function(element, checked) {
	                console.log(element);
	                var cc = "";
	                if ($scope.salesTypeList.length > 0) {
	                    $scope.joborder.sales = '';
	                    angular.forEach($scope.joborder.lsales, function(item, key) {
	                        if (cc == "") {
	                            cc = item.id;
	                        } else {
	                            cc += "," + item.id;
	                        }
	                        $scope.joborder.sales = cc;
	                    });
	                }

	                else {
	                    $scope.salesTypeList = [];
	                    $scope.salesTypeList = 'Select';
	                    $("#sales").empty();
	                }
	            }
	        });
	        $("#sales").parent().find('.btn-group #multiselect-button').addClass('width_100 input-sm line-height-5');
	    }, 2, false);
    
    $timeout(function() { // You might need this timeout to be sure its run
        // after DOM render.
        $("#status").multiselect({
            maxHeight : 200,
            includeSelectAllOption : true,
            selectAllText : 'Select All',
            enableFiltering : true,
            enableCaseInsensitiveFiltering : true,
            filterPlaceholder : 'Search',
            onChange : function(element, checked) {
                console.log(element);
                var cc = "";
                if ($scope.salesTypeList.length > 0) {
                    $scope.joborder.status = '';
                    angular.forEach($scope.joborder.lstatus, function(item, key) {
                        if (cc == "") {
                            cc = item.id;
                        } else {
                            cc += "," + item.id;
                        }
                        $scope.joborder.status = cc;
                    });
                }

                else {
                    $scope.statusList = [];
                    $scope.statusList = 'Select';
                    $("#status").empty();
                }
            }
        });
        $("#status").parent().find('.btn-group #multiselect-button').addClass('width_100 input-sm line-height-5');
    }, 2, false);


    
    
    
    
/*    $timeout(function() { // You might need this timeout to be sure its run
	        // after DOM render.
	        $("#term").multiselect({
	            maxHeight : 200,
	            includeSelectAllOption : true,
	            selectAllText : 'Select All',
	            enableFiltering : true,
	            enableCaseInsensitiveFiltering : true,
	            filterPlaceholder : 'Search',
	            onChange : function(element, checked) {
	                console.log(element);
	                var cc = "";
	                if ($scope.TermList.length > 0) {
	                    $scope.joborder.term = '';
	                    angular.forEach($scope.joborder.lterm, function(item, key) {
	                        if (cc == "") {
	                            cc = item.id;
	                        } else {
	                            cc += "," + item.id;
	                        }
	                        $scope.joborder.term = cc;
	                    });
	                }

	                else {
	                    $scope.TermList = [];
	                    $scope.TermList = 'Select';
	                    $("#term").empty();
	                }
	            }
	        });
	        $("#term").parent().find('.btn-group #multiselect-button').addClass('width_100 input-sm line-height-5');
	    }, 2, false);
    */
    
    
    
    
    $http.post($stateParams.tenantid+'/app/master/servicepartner/dropDownList').success(function(data) {
  		$scope.branchList=data.branchList;
    
  	  // creditcategory

  	    $timeout(function() { // You might need this timeout to be sure its run
  	        // after DOM render.
  	        $("#branch").multiselect({
  	            maxHeight : 200,
  	            includeSelectAllOption : true,
  	            selectAllText : 'Select All',
  	            enableFiltering : true,
  	            enableCaseInsensitiveFiltering : true,
  	            filterPlaceholder : 'Search',
  	            onChange : function(element, checked) {
  	                console.log(element);
  	                var cc = "";
  	                if ($scope.branchList.length > 0) {
  	                    $scope.joborder.branch = '';
  	                    angular.forEach($scope.joborder.lbranch, function(item, key) {
  	                        if (cc == "") {
  	                            cc = item.id;
  	                        } else {
  	                            cc += "," + item.id;
  	                        }
  	                        $scope.joborder.branch = cc;
  	                    });
  	                }

  	                else {
  	                    $scope.branchList = [];
  	                    $scope.branchList = 'Select';
  	                    $("#branch").empty();
  	                }
  	            }
  	        });
  	        $("#branch").parent().find('.btn-group #multiselect-button').addClass('width_100 input-sm line-height-5');
  	    }, 2, false);
    });
    

  
   

    
    $scope.customerTypelist = [ {
        id : 'AIR',
        text : 'AIR'
    }, {
        id : 'SEA',
        text : 'SEA'
    }/*, {
        id : 'JVP',
        text : 'JVP'
    }, {
        id : 'AGENT',
        text : 'AGENT'
    }*/ ];

  /*  $scope.creditCategorylist = [ {
        id : 'A',
        text : 'DEMO LOGISTICS - CHN',
        creditCategory : 'DEMO LOGISTICS - CHN'
    }, {
        id : 'B',
        text : 'MBK',
        creditCategory : 'MBK'
    }, {
        id : 'C',
        text : 'ATHENA GLOBAL LOGISTICS PTE. LTD.',
        creditCategory : 'ATHENA GLOBAL LOGISTICS PTE. LTD.'
    } , {
        id : 'D',
        text : 'MBK',
        creditCategory : 'MBK'
    }, {
        id : 'E',
        text : 'MBK',
        creditCategory : 'MBK'
    }, {
        id : 'F',
        text : 'MBK',
        creditCategory : 'MBK'
    }];*/

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
    $scope.getserviceId = function(option) {
        return option.id;
    };
    $scope.getsalesId = function(option) {
        return option.id;
    };
    $scope.gettermId = function(option) {
        return option.id;
    };
    $scope.getstatusId = function(option) {
        return option.id;
    };
    $scope.getpolId = function(option) {
        return option.id;
    };
    $scope.getbranchId = function(option) {
        return option.id;
    };

    $scope.getpayer = function(option) {
        return option.id;
    };

    $scope.getcustomer = function(option) {
        return option.id;
    };
    
    $scope.getaodId = function(option) {
        return option.id;
    };
    $scope.getaolId = function(option) {
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
                    console.log($scope.joborder.lCustomerType);
                    $scope.joborder.customerType = '';
                    angular.forEach($scope.joborder.lCustomerType, function(item, key) {
                        console.log(" customer item")
                        console.log(item);
                        if (ct == "") {
                            ct = item.id;
                        } else {
                            ct += "," + item.id;
                        }
                        $scope.joborder.customerType = ct;
                        console.log(" customer selected")
                        console.log($scope.joborder.customerType)
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
                    $scope.joborder.category = '';
                    angular.forEach($scope.joborder.lcategory, function(item, key) {
                        if (c == "") {
                            c = item.id;
                        } else {
                            c += "," + item.id;
                        }
                        $scope.joborder.category = c;
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

  

    // CHANGE TO MULTI SELECT

    // function call
    
    $scope.jobStatusList = [];
	$scope.getjobStatus = function() {
		var data = {};
		data["id"] = "4";
		data["text"] = "ALL";
		$scope.jobStatusList.push(data);
		
		data = {};
		data["id"] = "1";
		data["text"] = "PENDING";
		$scope.jobStatusList.push(data);
		data = {};
		data["id"] = "3";
		data["text"] = "DRAFT";
		$scope.jobStatusList.push(data);
		data = {};
		data["id"] = "2";
		data["text"] = "CLOSED";
		$scope.jobStatusList.push(data);

	}
	$scope.getjobStatus();
	
    $scope.onSearch = function(joborder,profitLossForm) {
    	if (new validationService().checkFormValidity(profitLossForm)) {
    		console.log("delivery order  search");
            console.log(joborder);

            $http.post($stateParams.tenantid+"/app/joborderreport/getReport", joborder).success(function(response) {

                $scope.rowCollection = response.ljobOrderReportlist;
                $scope.printRowCollection=$scope.rowCollection;
                console.log("final result")
                console.log($scope.rowCollection)
                $scope.excelList = response.ljobOrderReportlist;

            }).error(function(result) {
                logger.logError("Error Please Try Again");
            });
    	}else {
            toaster.pop('error', "Please fill the required fields", 
                    logger.getErrorHtmlNew(profitLossForm.$validationSummary), 5000, 'trustedHtml');
            
        }
        

    }
    
   
/*    // excel

    $scope.reset = function() {
        $scope.freightmanifest.voyage = '';
        $scope.freightmanifest.sectorId = '';
        $scope.freightmanifest.sailingDate = '';
        $scope.freightmanifest.company = '';
        $scope.freightmanifest.pol = '';
        $scope.freightmanifest.pod = '';
        $scope.freightmanifest.fromDate = '';
        $scope.freightmanifest.toDate = '';
        $scope.freightmanifest.creditCategory = '';
        $scope.freightmanifest.category = '';
        $scope.freightmanifest.invoiceNo = '';
        $scope.freightmanifest.customerType = '';

    }*/
    
    $scope.reset = function() {
    	var value=true;
        
        
        for ( var index in $scope.messageHeaderList) {
            
            
            var colum = $scope.messageHeaderList[index];
            if (colum.isDefault == false) {
                if (value == true) {
                    colum.visible = false;
                } else {
                    colum.visible = false;
                }
            }
        }

    }

    // excel export
    $scope.printBean=[];
    $scope.excel = function(joborder) {

        var groupHeaderSelectedList = $filter('filter')($scope.messageHeaderList, {
            visible : true
        }, true);
        var objWholeData = {
            'ljobOrderReportlist' : $scope.excelList,
            'ljobOrderReportheaderlist' : groupHeaderSelectedList,
            'JobOrderReportBean' : joborder
        };

        console.log("Delivery Order excel")
        console.log(objWholeData);

        $http.post($stateParams.tenantid+"/app/joborderreport/generateExcel", objWholeData).success(function(response) {

            $('#exportXl').append('<a id="tbExcelExport" stype="display:none" href="filePath/JobOrder.xls" download="JobOrder.xls"></a>');
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
    $scope.loginUsrDept=[];
    $scope.loginUsrDetails=[];
    $http.post($stateParams.tenantid + '/app/dashboard/checkWhichUser').success(function(data) {
		if (data) {
			$scope.loginUsrDept=data[0];
			$scope.loginUsrDetails=data[1];
			$scope.getCompanyDetails();
		}
	})
	$scope.getCompanyDetails=function(){
    	if($scope.loginUsrDetails.companyCode!=null && $scope.loginUsrDetails.companyCode!=undefined){
    		$http.post($stateParams.tenantid+"/app/profitloss/getCompanyDetails", $scope.loginUsrDetails.companyCode).success(function(response) {
    	           var res=response;
    	           $scope.comName=res.companyDetails.companyName;
    	           $scope.comAddress=res.companyDetails.compAddress;

    	        }).error(function(result) {
    	            logger.logError("Error Please Try Again");
    	        });
    	}
    }
	
    $scope.comName='';
    $scope.comAddress='';
    $scope.printProfitAndLoss=function(joborder,profitLossForm){
    	if (new validationService().checkFormValidity(profitLossForm)) {
    		
    		$http.post($stateParams.tenantid+"/app/joborderreport/getReport", joborder).success(function(response) {

                $scope.rowCollection = response.ljobOrderReportlist;
                $scope.printRowCollection=$scope.rowCollection;
                $scope.excelList = response.ljobOrderReportlist;

                var groupHeaderSelectedList = $filter('filter')($scope.messageHeaderList, {
    	            visible : true
    	        }, true);
    	    	
    	        $scope.printRowCollection=$scope.excelList;
    	        $scope.printMessageHeaderList=groupHeaderSelectedList;
    	        $http.post($stateParams.tenantid + '/app/dashboard/checkWhichUser').success(function(data) {
    	    		if (data) {
    	    			$scope.loginUsrDept=data[0];
    	    			$scope.loginUsrDetails=data[1];
    	    			$scope.getCompanyDetails();
    	    			$scope.printPL();
    	    		}
    	    	})
                
            }).error(function(result) {
                logger.logError("Error Please Try Again");
            });
    	}else {
            toaster.pop('error', "Please fill the required fields", 
                    logger.getErrorHtmlNew(profitLossForm.$validationSummary), 5000, 'trustedHtml');
            
        }
    	  
    }
    
    $scope.printPL=function(){
      var printContents = document.getElementById('printableTableId').innerHTML;
  	  var popupWin = window.open('', '_blank', 'height=700,width=850,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
  	  popupWin.document.open();
  	  popupWin.document.write('<html><head><link rel="stylesheet" type="text/css" href="style.css" />'+
  			  '<style>table{font-size:12px;}body{font-family: "Open Sans";}table, th, td {border: 1px solid black;border-collapse: collapse;}'+
  			  'table>thead>tr>th{background-color:#34b7e8;}</style>'+
  			  '</head><body onload="window.print()">' + printContents + '</body></html>');
  	  popupWin.document.close();
    }
    
  $scope.exportAsExcel=function(joborder,profitLossForm){
	  
	  if (new validationService().checkFormValidity(profitLossForm)) {
		  
		  $http.post($stateParams.tenantid+"/app/joborderreport/getReport", joborder).success(function(response) {
              $scope.rowCollection = response.ljobOrderReportlist;
              $scope.printRowCollection=$scope.rowCollection;
              $scope.excelList = response.ljobOrderReportlist;

              var groupHeaderSelectedList = $filter('filter')($scope.messageHeaderList, {
    	          visible : true
    	      }, true);
    	      var objWholeData = {
    	          'ljobOrderReportlist' : $scope.excelList,
    	          'ljobOrderReportheaderlist' : groupHeaderSelectedList,
    	      };
    	      $http.post($stateParams.tenantid+"/app/profitloss/exportExcel", objWholeData).success(function(data) {
    				if (data.success == true) {
    					if(data.excelExportPath != null){
    				var debitNoteFileUrl = data.excelExportPath.split("/");
    				var actualLength=debitNoteFileUrl.length;
    				var fileLength=actualLength - 1;
    	            var downloadFile = debitNoteFileUrl[fileLength];
    				logger.logSuccess("Exported successfully!");
    				 $('#prfitLosExpId').attr('href','filePath/' +downloadFile);
    			    $("#prfitLosExpId").bind('click', function() {
    			   });
    			   $('#prfitLosExpId').simulateClick('click');
    			   
    				}
    				else{
    					logger.logError("No Record Found!");
    					}
    			   } else {
    					logger.logError("Failed to Export!..");
    				}

    			}).error(function(result) {
    	          logger.logError("Error Please Try Again");
    	      });
              
              
          }).error(function(result) {
              logger.logError("Error Please Try Again");
          });
		  
  		
  	}else {
          toaster.pop('error', "Please fill the required fields", 
                  logger.getErrorHtmlNew(profitLossForm.$validationSummary), 5000, 'trustedHtml');
          
      }
	  
      
  }  
  
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
    

});
