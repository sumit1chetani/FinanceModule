//define([ 'hospital/accounts/accounts', 'jqGrid' ], function(module) {

    'use strict';
    app.controller('pendingPaymentReportListCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, utilsService, $window) {

        $scope.dataLoopCount = 0;
        $scope.from = 0;
        $scope.to = 100;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.isUpload = true;
        $scope.pendingPaymentData = {
            supplier : ''
        }

        $scope.pendingPaymentData = {
                company:'C0002',
                supplier:'',
                fromDate:'',
                toDate:''
           
        };
        $scope.getDropdownvalue = function() {
            $http.get('app/purchaseinvoice/getSupplierList').success(function(datas) {
                $scope.supplierList = datas;
          //  }).error(function(datas) {
            });
        };
        $scope.getDropdownvalue();
        $scope.getList = function(){
            $http.get("app/pendingPaymentRpt/getList").success(function(response) {
                if(response.lpaymentreport.length>0){
                    $scope.rowCollection = response.lpaymentreport;    
                }else{
                    $scope.rowCollection = [];
                }
                               
            });            
        };
        $http.get('app/journalVoucher/getCompanyList').success(function(datas) {
            $scope.companyList = datas;
        }).error(function(datas) {
        });
        $scope.getList();
        $scope.exportPendingPaymentExcel = function() {
            if ($scope.pendingPaymentData.supplier != undefined && $scope.pendingPaymentData.supplier != "") {
                $http.post('app/pendingPaymentRpt/exportPendingPaymentExcel', $scope.pendingPaymentData).success(function(data) {
                    if (data.success) {
                        $window.open(data.filePath);
                        logger.logSuccess("Exported Sucessfully!...");
                    } else {
                        logger.logError("No Records Found");
                    }

                }).error(function(data) {
                 //   logger.logError("Error Please Try Again");
                });
            } else {
                logger.logError("Please Select Vendor...!");
            }
        }
        
       
        
      
      /*//Excel PDF	
   	 $scope.exportPDF = function(){
   		  var flag = false;
   		  //if(bean.port != "" && bean.port != undefined && bean.port != null){
   	        $scope.generalLedger.fromDate = $('#fromDate').val();
   	        $scope.generalLedger.toDate = $('#toDate').val();
   	        if($scope.generalLedger.toDate !='' && $scope.generalLedger.fromDate != '' && $scope.generalLedger.companyCode !=''){
  	     	   	 $http.post('app/pendingPaymentRpt/ExportPDF',$scope.generalLedger).success(function(response) {

   	                if(response){
   	                    debugger;
   	                    $("#exportPDF").bind('click', function() {
   	                    	
   	                    });
   	                    $('#exportPDF').simulateClick('click');
   	                    logger.logSuccess("Exported successfully!");
   	                }else{
  					        logger.logError(response.message);
   	                }
   	                
   	            }).error(function(response) {
   	                logger.logError("Error Please Try Again");
   	            });
  	     	   	 
   	       }else{
   	            if(($scope.generalLedger.toDate =='' || $scope.generalLedger.fromDate == '') && $scope.generalLedger.companyCode =='')
   	                logger.logError("Please select Company and valid date range");
   	            else if($scope.generalLedger.companyCode =='')
   	                logger.logError("Please select Company");
   	            else if($scope.generalLedger.toDate =='' && $scope.generalLedger.fromDate == '')
   	                logger.logError("Please select valid date range");
   	        }
   	    }*/
        $scope.getSearchList = function() {
            
            $http.post('app/pendingPaymentRpt/SearchList',$scope.pendingPaymentData).success(function(datas) {
                 console.log(datas);
                 $scope.rowCollection = datas;
              
                 }).error(function(datas) {
             });
       }
        $scope.viewPendingPaymentReport = function() {
            if ($scope.pendingPaymentData.supplier != undefined && $scope.pendingPaymentData.supplier != "") {
                var url = 'app/cashbankPayment/getPendingPaymentRptInvoiceDetails?supplierCode=' + $scope.pendingPaymentData.supplier;
                $http.post(url).success(function(data) {
                    $("#pendingPaymentReportGrid").jqGrid('clearGridData');
                    $scope.populatePendingPaymentReportGrid(data.lPendingPaymentReportBean);
                    if (!$('body').hasClass('left-side-collapsed')) {
                        $("td#grid_bcBalanceAmt").addClass('grid_bcBalanceAmt');
                    }

                }).error(function(data) {
                  //  logger.logError("Error Please Try Again");
                });
            } else {
                logger.logError("Please Select Vendor...!");
            }

        };
        $scope.$watch("pendingPaymentData.supplier", function(newValue, oldValue) {
            if (newValue != undefined && newValue != "") {
                $scope.viewPendingPaymentReport();
            }
        });

        $scope.populatePendingPaymentReportGrid = function(lCashbankpaymentList) {
            var data = [];
            $("#pendingPaymentReportGrid").jqGrid({
                data : lCashbankpaymentList,
                datatype : "local",
                multiboxonly : false,
                /* autowidth: true, */
                height : '100%',
                rowList : [ 10, 20, 30 ],
                multiselect : false,
                loadonce : true,
                gridview : true,
                colNames : [ 'Invoice No', 'Invoice Dt', 'Invoice Amt', 'Inv Amt TC', 'Currency', 'Exchange Rate', 'Paid Amt', 'TC Paid Amt', 'Balance Amt', 'TC Balance Amt' ],
                colModel : [ {
                    name : 'purInvoiceNo',
                    index : 'purInvoiceNo',
                    width : 160,
                    align : "left",
                    searchoptions : {
                        sopt : [ 'cn' ]
                    }
                }, {
                    name : 'purInvoiceDate',
                    index : 'purInvoiceDate',
                    width : 130,
                    align : "left",
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    hidden : false
                }, {
                    name : 'invoiceBCAmt',
                    index : 'invoiceBCAmt',
                    width : 160,
                    align : "right",
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    hidden : false
                }, {
                    name : 'invoiceTCAmt',
                    index : 'invoiceTCAmt',
                    width : 160,
                    align : "right",
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    hidden : true
                }, {
                    name : 'currencyCode',
                    index : 'currencyCode',
                    width : 160,
                    align : "left",
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    hidden : false
                }, {
                    name : 'exchangeRate',
                    index : 'exchangeRate',
                    width : 160,
                    align : "right",
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    hidden : false
                }, {
                    name : 'paidAmountBC',
                    index : 'paidAmountBC',
                    width : 160,
                    align : "right",
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    hidden : false
                }, {
                    name : 'paidAmountTC',
                    index : 'paidAmountTC',
                    width : 160,
                    align : "right",
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    hidden : true
                }, {
                    name : 'bcBalanceAmt',
                    index : 'bcBalanceAmt',
                    width : 160,
                    align : "right",
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    hidden : false
                }, {
                    name : 'tcBalanceAmt',
                    index : 'tcBalanceAmt',
                    width : 160,
                    align : "right",
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    hidden : true
                }, ],

                pager : "#pendingPaymentReportPage",
                viewrecords : true,
                ignoreCase : true

            }).jqGrid('setGridParam', {
                data : lCashbankpaymentList
            }).trigger("reloadGrid");
            $("#pendingPaymentReportGrid").jqGrid('navGrid', '#pendingPaymentReportPage', {
                edit : false,
                add : false,
                del : false,
                search : false,
                refresh : false
            });
            $("#pendingPaymentReportGrid").jqGrid('filterToolbar', {
                searchOnEnter : false,
                searchOperators : true
            });

        }
 //export pdf
        $scope.exportPDF = function(){
    		  var flag = false;
    		  //if(bean.port != "" && bean.port != undefined && bean.port != null){
    	       // $scope.balsheet.fromDate = $('#fromDate').val();
    	//        $scope.balsheet.toDate = $('#toDate').val();
            if ($scope.pendingPaymentData.supplier != undefined && $scope.pendingPaymentData.supplier != "") {
   	     	   	 $http.post('app/pendingPaymentRpt/ExportPDF',$scope.pendingPaymentData).success(function(response) {

    	                if(response){
    	                    debugger;
    	                    $("#exportPDF").bind('click', function() {
    	                    	
    	                    });
    	                    $('#exportPDF').simulateClick('click');
    	                    logger.logSuccess("Exported successfully!");
    	                }else{
   					        logger.logError(response.message);
    	                }
    	                
    	            }).error(function(response) {
    	                logger.logError("Error Please Try Again");
    	            });
   	     	   	 
    	      
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
  	    
        
  	        
      
        
    //});
        }        
});