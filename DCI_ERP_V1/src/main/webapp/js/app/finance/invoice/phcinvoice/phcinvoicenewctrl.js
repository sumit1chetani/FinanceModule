/**
 * List page
 */
'use strict';
app.controller('phcinvoiceCtrl', function($scope, $window, $rootScope, $location, $http, logger, 
        $log, ngDialog, $modal, utilsService, $state, $controller,$stateParams) {

    $scope.phcTable = false;
    
    var cnt = 0;
    var gnlpenCnt = 0;
    $scope.dataLoopCount = 0;
    $scope.from = 0;
    $scope.to = 100;
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.username = '';
    $scope.currentURL=$location.protocol() + '://'+ $location.host() +':'+  $location.port()+"/#" +$location.path();
    if(window.localStorage.getItem('active_list')==$scope.currentURL){
        alert('window ' + $scope.currentURL + ' is already opened');
       // window.focus();
        setTimeout(window.close(),5000);
    }else{
        window.localStorage.setItem('active', $scope.currentURL);
        window.localStorage.removeItem('active');
    }
//    $(window).unload(function(){
//       
//        });
    $scope.getCreditNoteListUtil = function(limit, offset) {
        var start = new Date().getTime();
        var url = $stateParams.tenantid+'/app/PHCInvoice/cnlist?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount + '&formCode=' + $('#form_code_id').val();
        $http.get(url).success(function(data) {
            console.log("data::::::::::getCreditNoteListUtil:::::::::");
            console.log(data);
            if (data.success == true) {
                $scope.rowCollection = data.lPHCInvoiceBean;
                angular.forEach(data.lPHCInvoiceBean, function(row, index) {
                    data.lPHCInvoiceBean[index].printList = "both";
                });
                $scope.pushCreditNoteListUtil(data);
                $scope.dataLoopCount++;
            } else {
                if ($scope.dataLoopCount == 0) {
                    $scope.showEmptyLabel = true;
                }
                logger.logError("Error Please Try Again");
            }
            var end = new Date().getTime();
            var time = end - start;
            console.log('Execution time: ' + time);
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });

    };
    $scope.pushCreditNoteListUtil = function(data) {
        if (utilsService.isUndefinedOrNull(data.lCreditNoteBean)) {
            $scope.showEmptyLabel = true;
        } else {
            $scope.rowCollection=[];
            $scope.rowCollection = $scope.rowCollection.concat(data.lCreditNoteBean);
        }
    };

    $scope.getCreditNoteListUtil();
    
    /**
     * view PHC Invoice
     */
    $scope.viewPHCInvoice = function(phcinvoiceNo) {
        $location.path("/invoice/PHCInvoicenew/view/" + phcinvoiceNo);
    }
    
    /**
     * add - PHC Invoice new screen
     */
    $scope.add = function() {
        $state.go('app.finance.invoice.PHCInvoicenew.add',{tenantid:$stateParams.tenantid});
    };

    $scope.editRowBtn = function(creditCode) {
        //$location.url('/transaction/creditnotehdr/edit?creditCode=' + creditCode);
    };

   /**
    * dropdown
    */
    $scope.phcInvoiceHeaderData = {vesselid:'',voyageCode:''}
    
   /* $scope.getDropdownData = function() {
        $http.get('app/invoice/getVesselList').success(function(data) {
            $scope.vesselList = data.vesselList;
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
    }
    $scope.getDropdownData();*/

    $scope.$watch('phcInvoiceHeaderData.vesselid', function(newValue, oldValue) {
        $scope.phcInvoiceHeaderData.voyageCode = '';
        if ($scope.phcInvoiceHeaderData.vesselid != '') {
            $scope.phcInvoiceHeaderData.vessel = $scope.vesselObj.text;
            $http.post($stateParams.tenantid+'/app/invoice/getVoyage', $scope.phcInvoiceHeaderData.vesselid).success(function(data) {
                $scope.voyageList = data.voyageNo;
            });
        } else {
            $scope.phcInvoiceHeaderData.vessel = '';
        }
    })
    /**
     * fetch Approved date, approved by using ActiveX CONTROLS WITH DIGITAL
     * SIGNATURE ***********************************************
     */

    $scope.getUserDetail = function() {
        $http.get($stateParams.tenantid+'/app/creditNote/logindetail').success(function(datas) {
            console.log("logindetails");
            $scope.username = datas.username

        }).error(function(datas) {
        });
    }

    $scope.getUserDetail();
    
    $scope.selectedrow = [];
    $scope.appovedList = [];
  
    /**
     * PRINT
     */

    $scope.printPHCInvoice = function(phcInvoiceNo, selection, index) {
        var url = $stateParams.tenantid+'/app/PHCInvoice/print?phcInvoiceNo=' + phcInvoiceNo + '&selectedPrintOption=' + selection;
        var wnd = window.open(url, 'Shipping', 'height=400,width=750,top=100,left=100,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
        wnd.print();
    }

    /**
     * send Mail
     */
    $scope.sendPHCInvoiceMail = function(invoiceNo, selection) {

        // ngDialog.close();
        ngDialog.open({
            template : 'invoiceMail',
            scope : $scope,
            controller : $controller('phcInvoiceMailCtrl', {
                $scope : $scope,
                data : {
                    "phcInvoiceNo" : invoiceNo,
                    "selection" : selection,
                    'mailOption' :'single',
                    'phcRowData':[]
                }
            })
        });
    };

    /* delete Invoice */

    $scope.deletePHCInvoice = function(invoiceNo, index) {
        ngDialog.open({
            template : 'invoiceDelete',
            scope : $scope,
            controller : $controller('phcInvoiceDeleteCtrl', {
                $scope : $scope,
                data : {
                    "phcInvoiceNo" : invoiceNo,
                    "index" : index
                }
            })
        });
    };
    
    
    $scope.searchInvoiceDtl=function(){
        $scope.rowCollection = [];

        console.log("$scope.phcInvoiceHeaderData")
        console.log($scope.phcInvoiceHeaderData)
        $http.post($stateParams.tenantid+'/app/PHCInvoice/searchInvoiceDtl', $scope.phcInvoiceHeaderData).success(function(data) {
            if (data.success == true) {

                angular.forEach(data.invoiceBean, function(row, index) {
                    data.invoiceBean[index].printList = "both";
                });

                $scope.rowCollection = $scope.rowCollection.concat(data.invoiceBean);
                console.log($scope.rowCollection)
            } else {
                logger.logError("Error Please Try Again");
            }
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
    };
    
    $scope.bulkPrint=function(phcRowData){
        var invoiceNos = '';
        var len = phcRowData.length;
        for (var i = 0; i < len; i++) {
            var rowData = phcRowData[i];
            if (typeof rowData.select == "undefined") {
                rowData["select"] = false;
            }
            if (rowData.select == true) {
                if(invoiceNos==""){
                    invoiceNos= rowData.phcinvoiceCode; 
                }
                else{
                    invoiceNos +=","+rowData.phcinvoiceCode;
                }
            }
        } 
        console.log(invoiceNos);
        if(invoiceNos!=""){
            var url = $stateParams.tenantid+'/app/PHCInvoice/bulkPrint?phcInvoiceNos='+invoiceNos;
            var wnd = window.open(url, 'Shipping', 'height=400,width=750,top=100,left=100,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
            wnd.print();    
        }else{
            logger.logError("Please Select Atleast one row!");
        }
        
    }
    
    $scope.bulkPHCInvoiceMail = function(phcRowData, selection) {

        // ngDialog.close();
        ngDialog.open({
            template : 'invoiceMail',
            scope : $scope,
            controller : $controller('phcInvoiceMailCtrl', {
                $scope : $scope,
                data : {
                    "phcInvoiceNo" : '',
                    "selection" : '',
                    'mailOption' :'bulk',
                    'phcRowData':phcRowData
                }
            })
        });
    };
    

});

/**
 * Mail Controller
 */

app.controller('phcInvoiceMailCtrl', function($scope, $http, ngDialog, logger, data,$stateParams) {
   
    if(data.mailOption=='bulk'){
        
        var invoiceNos = '';
        var len = data.phcRowData.length;
        for (var i = 0; i < len; i++) {
            var rowData = data.phcRowData[i];
            if (typeof rowData.select == "undefined") {
                rowData["select"] = false;
            }
            if (rowData.select == true) {
                if(invoiceNos==""){
                    invoiceNos= rowData.phcinvoiceCode; 
                }
                else{
                    invoiceNos +=","+rowData.phcinvoiceCode;
                }
            }
        } 
        $scope.SendConfirm = function() {
            if(invoiceNos!=""){
                console.log("bulk mail option:::"+invoiceNos);      
                $http.get($stateParams.tenantid+'/app/PHCInvoice/sendBulkMail?phcInvoiceNos=' + invoiceNos + '&selectedDropDown=' + "both").success(function(data) {
                    if (data.success == true) {
                        logger.logSuccess("Mail Sent Successfully!");
                        ngDialog.close();
                    } else {
                        logger.logError("Unable to send mail!");
                        ngDialog.close();
                    }
                }).error(function(data) {
                    console.log("data" + data);
                });
            }else{
                logger.logError("Please Select Atleast one row!");
            }
           
        }
    }else{
        $scope.SendConfirm = function() {
            if(data.phcInvoiceNo !=""){
                $http.get($stateParams.tenantid+'/app/PHCInvoice/sendMail?phcInvoiceNo=' + data.phcInvoiceNo + '&selectedDropDown=' + data.selection).success(function(data) {
                    if (data.success == true) {
                        logger.logSuccess("Mail Sent Successfully!");
                        ngDialog.close();
                    } else {
                        logger.logError("Unable to send mail!");
                        ngDialog.close();
                    }
                }).error(function(data) {
                    console.log("data" + data);
                });
            }else{
                logger.logError("Invoice No is empty");
            }
        }
    }
    
    

    $scope.closeDialog = function() {
        ngDialog.close();
    };
});

app.controller('phcInvoiceDeleteCtrl', function($scope,$state, $http, ngDialog, logger, data,$stateParams) {
    $scope.deleteConfirm = function() {
        $http.get($stateParams.tenantid+'/app/PHCInvoice/deleteInvoice?phcInvoiceNo=' + data.phcInvoiceNo).success(function(data) {
            if (data.success == true) {
                logger.logSuccess("Invoice deleted Successfully!");
                $scope.rowCollection.splice(data.index, 1);
                ngDialog.close();
                $state.reload();

            } else {
                logger.logError("Unable to delete!");
                ngDialog.close();
            }
        }).error(function(data) {
            console.log("data" + data);
        });

    }

    $scope.closeDialog = function() {
        ngDialog.close();
    };
});

/**
 * Add form - new entry controller
 */
app.controller('phcinvoiceCtrlAdd', function($scope, $filter, $window, $rootScope, $location, $http, logger, $log, ngDialog, $modal, utilsService, sharedProperties, $state, $injector, ListService, $stateParams, validationService, toaster, $timeout) {
    $scope.phcTable = false;
    
    sharedProperties.getObject();

    $scope.dataLoopCount = 0;
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.acctHeadList = [];

    $scope.vesselList = [];
    $scope.voyageList = [];
    $scope.portList = [];

    $scope.crdtlAcctHeadList = [];
    $scope.containerList = [];
    $scope.serviceList = [];

    $scope.invoiceNoList = [];
    $scope.invoiceDetails = [];
    $scope.validated = false;
    $scope.creditnoteAcctData = {
        PHCInvoiceCode : '',
        accountName : '',
        vessel : '',
        voyage : '',
        pol : '',
        pod : '',
        pot : '',
        blNo : '',
        flag : '',
        customerCode : '',
        invoiceNo : '',
        invoiceDate : '',
        currencyCode : 'SGD',
        feeType : '',
        exchangeRate : '',
        feeRate : '0',
        noOfBill : '0',
        totalBCFee : '0',
        totalTCFee : '0',
        companyCode : 'C0003',
        company : '',
        slotStatus : 'N',
        totalTCAmount : '',
        credittables : []
    };

    $scope.edit = false;
    $scope.blList = [];
    $scope.currentURL=$location.protocol() + '://'+ $location.host() +':'+  $location.port()+"/#" +$location.path();
  
    if(window.localStorage.getItem('active')==$scope.currentURL){
        alert('window ' + $scope.currentURL + ' is already opened');
       // window.focus();
        //window.open($rootScope.currentURL,'_self').close();
        setTimeout(window.close(),1000);
    }else{
        window.localStorage.setItem('active', $scope.currentURL);
    }
    $(window).unload(function(){
        localStorage.removeItem('active');
        });

    /**
     * datepicker
     * ******************************************************************************************************
     */
    $('#invoiceDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime : false
    });
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
    $('#invoiceDate').val(today);
    $scope.creditnoteAcctData.invoiceDate = today;
  
    /**
     * Fetching Acct Head Dropdown Drop Down
     */
    $scope.getAcctHeadDropdown = function() {
        $http.get($stateParams.tenantid+'/app/creditNote/getAcctHeadCombo').success(function(datas) {
            if (datas.length > 0) {
                $scope.acctHeadList = datas;
            }

        }).error(function(data) {
        });
    };
    $scope.getAcctHeadDropdown();

    // code added for attribute dropdown list
    $scope.getDropdownList = function() {

        /*$http.get('app/commonUtility/getCompanyList').success(function(datas) {
            console.log("Company");
            console.log(datas);
            $scope.companyList = datas;

            var foundItemDest = $filter('filter')($scope.companyList, {
                baseCompany : 1
            })[0];
            $scope.creditnoteAcctData.companyCode = foundItemDest.id;
        }).error(function(datas) {
        });*/
        
        $http.get($stateParams.tenantid+'/app/containerphcrates/getlocation').success(function(datas) {
            var tempList = [];
            for (var i = 0; i < datas.length; i++) {         
                tempList.push({
                   id: datas[i].location, 
                   text:  datas[i].locationname
               });
            }
            $scope.companyList=tempList;
            $scope.creditnoteAcctData.companyCode = 'C0003';
       }).error(function(data) {
        });

        /*
         * $http.get('app/PHCInvoice/getVoyageList').success(function(datas) {
         * $scope.voyageList = datas; }).error(function(datas) {
         * logger.logError("Error Please Try Again"); });
         */

        $http.get($stateParams.tenantid+'/app/commonUtility/getVesselList').success(function(datas) {
            $scope.vesselList = datas;
        }).error(function(datas) {
        });

        $http.get($stateParams.tenantid+'/app/commonUtility/getSectorList').success(function(datas) {
            $scope.sectorList = datas;
        }).error(function(datas) {
        });

        $http.get($stateParams.tenantid+'/app/commonUtility/getEmployeeList').success(function(datas) {
            $scope.employeeList = datas;
        }).error(function(datas) {
        });

        $http.get($stateParams.tenantid+'/app/commonUtility/getPortList').success(function(datas) {
            $scope.portList = datas;
        }).error(function(datas) {
        });

        $http.get($stateParams.tenantid+'/app/commonUtility/getDepartmentList').success(function(datas) {
            $scope.departmentList = datas;
        }).error(function(datas) {
        });

        $http.get($stateParams.tenantid+'/app/commonUtility/getAgentList').success(function(datas) {
            $scope.agentList = datas;
        }).error(function(datas) {
        });

        $http.get('app/commonUtility/getCountryList').success(function(datas) {
            $scope.countryList = datas;
        }).error(function(datas) {
        });

        $http.get('app/commonUtility/getCustomerList').success(function(datas) {
            $scope.customerList = datas;
        }).error(function(datas) {
        });

        $http.get('app/commonUtility/getDesignationList').success(function(datas) {
            $scope.designationList = datas;
        }).error(function(datas) {
        });

        $http.get('app/commonUtility/getSupplierList').success(function(datas) {
            $scope.supplierList = datas;
        }).error(function(datas) {
        });

    }
    $scope.getDropdownList();
    /**
     * Fetching Invoice Dropdown with AcctHead Code
     * *****************************************************************
     */

    /*
     * $scope.$watch('creditnoteAcctData.accountName', function(newValue,
     * oldValue) {
     * 
     * if (newValue != '' && newValue != undefined) {
     * $http.get('app/PHCInvoice/getInvoiceNo?acctHeadCode=' +
     * newValue).success(function(datas) { if (datas.length > 0) {
     * $scope.invoiceNoList = datas; } else {
     * $scope.creditnoteAcctData.invoiceDate = "";
     * $scope.creditnoteAcctData.exchangeRate = ""; } }).error(function(data) {
     * }); } else { $scope.invoiceNoList = [];
     * $scope.creditnoteAcctData.invoiceDate = "";
     * $scope.creditnoteAcctData.exchangeRate = ""; } });
     */

    $scope.$watch('creditnoteAcctData.vessel', function(newValue, oldValue) {
        console.log("Company Code" + $scope.creditnoteAcctData.companyCode);
        if (newValue != '' && newValue != undefined) {
            $http.get('app/PHCInvoice/getVoyage?vesselCode=' + newValue).success(function(datas) {
                console.log(datas);
                if (datas.length > 0) {
                    $scope.voyageList = datas;
                }
            }).error(function(data) {
            });
        } else {
            $scope.voyageList = [];
        }
    });

    $scope.$watch('creditnoteAcctData.voyage', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
            $http.get('app/PHCInvoice/getPort?voyageCode=' + newValue).success(function(datas) {
                if (datas.length > 0) {
                    $scope.portList = datas;
                }
            }).error(function(data) {
            });
        } else {
            $scope.voyageList = [];
        }
    });

    $scope.$watch('creditnoteAcctData.pol', function(newValue, oldValue) {
        $scope.PHCFilterDate = {
            voyage : $scope.creditnoteAcctData.voyage,
            pol : $scope.creditnoteAcctData.pol,
            customerCode : ''
        }

        console.log($scope.PHCFilterDate);
        if (newValue != '' && newValue != undefined) {
            $http.post('app/PHCInvoice/getcustomer', $scope.PHCFilterDate).success(function(datas) {
                
                if (datas.length > 0) {
                    $scope.mloList = datas;
                    console.log("$scope.mloList:::::::::::::::::::::::::");
                    console.log($scope.mloList);
                }
            }).error(function(data) {
            });
        } else {
            $scope.mloList = [];
        }
    });

    $scope.$watch('creditnoteAcctData.customerCode', function(newValue, oldValue) {
        $scope.PHCFilterDate = {
            voyage : $scope.creditnoteAcctData.voyage,
            pol : $scope.creditnoteAcctData.pol,
            customerCode : newValue
        }
        if (newValue != '' && newValue != undefined) {
            $http.post('app/PHCInvoice/getBlList', $scope.PHCFilterDate).success(function(datas) {
                if (datas.length > 0) {
                    console.log(datas)
                    $scope.blList = datas;
                }
            }).error(function(data) {
            });

            $http.post('app/PHCInvoice/getPayerList', $scope.PHCFilterDate).success(function(datas) {
                if (datas.length > 0) {
                    $scope.acctHeadList = datas;
                }
            }).error(function(data) {
            });

        } else {
            $scope.blList = [];
        }
    });

    $scope.$watch('creditnoteAcctData.accountName', function(newValue, oldValue) {

        if ($scope.creditnoteAcctData.pol === "PSA" || $scope.creditnoteAcctData.pod === "PSA") {
            $scope.PHCFilterDate = {
                voyage : $scope.creditnoteAcctData.voyage,
                pol : $scope.creditnoteAcctData.pol,
                pod : $scope.creditnoteAcctData.pod,
                blNo : $scope.creditnoteAcctData.blNo,
                payer : newValue
            }
            console.log("$scope.PHCFilterDate::::::::::::::::::::::");
            console.log($scope.PHCFilterDate);
            if (newValue != '' && newValue != undefined) {
                $http.post('app/PHCInvoice/getFeeDetail', $scope.PHCFilterDate).success(function(datas) {
                    if (datas.sucess) {
                        $scope.creditnoteAcctData.feeType = datas.feeType;
                        //$scope.creditnoteAcctData.exchangeRate = datas.exchangeRate;
                        $scope.creditnoteAcctData.feeRate = datas.feeRate;
                        $scope.creditnoteAcctData.slotStatus = datas.slotStatus;
                        //$scope.creditnoteAcctData.slotStatus = 'Y';
                    }
                }).error(function(data) {
                });

            } else {
            }
        } else if ($scope.creditnoteAcctData.pol != "" || $scope.creditnoteAcctData.pod != "") {
            logger.logError("Either Pol Or Pod should be PSA.");
        }
    });

    $scope.$watch('creditnoteAcctData.blNo', function(newValue, oldValue) {
        var checkedList = $filter('filter')($scope.blList, {
            id : newValue
        }, true);
        if (checkedList.length > 0) {
            $scope.creditnoteAcctData.flag = checkedList[0].flag;
        }
        if(newValue!="" && newValue!=undefined && newValue!=null){
            $http.post($stateParams.tenantid+'/app/PHCInvoice/getPHCExchangeRate', newValue).success(function(datas) {
                if (datas.sucess) {
                    $scope.creditnoteAcctData.exchangeRate = datas.exchangeRate;
                    //$scope.creditnoteAcctData.slotStatus = 'Y';
                    $scope.exchageratePHChdr($scope.creditnoteAcctData.exchangeRate);
                }
            }).error(function(data) {
            });
        }
    });

    /**
     * fetch invoice date, currency code, exchange rate from invoice No
     * ***********************************************
     */

    
     /* $scope.$watch('creditnoteAcctData.companyCode', function(newValue,oldValue) {
      
          if (newValue != '' && newValue != undefined) {
              $http.get('app/generalinvoice/getCompanyCurrency?CompanyCode=' +newValue).success(function(datas) {
                  $scope.companyCurrency = datas.CurrencyCode; 
              }).error(function(datas) { 
                  
              }); 
          } 
      });*/
     

    /**
     * Credit Note Detail Table
     * ******************************************************************************************
     */

    /*
     * $http.get('app/commonUtility/getCrDtlAccountHeadData').success(function(datas) {
     * $scope.crdtlAcctHeadList = datas.commonUtilityBean;
     * }).error(function(data) { });
     */

    $http.get($stateParams.tenantid+'/app/commonUtility/getPhcContainers').success(function(datas) {
        $scope.containerList = datas.commonUtilityBean;
    }).error(function(data) {
    });

    $scope.crdtlAcctHeadList.push('THC AT SINGAPORE');
    $scope.crdtlAcctHeadList.push('THC AT UMQ');
    $scope.crdtlAcctHeadList.push('THC AT ASSALUYEH');

    $scope.serviceList.push('LOCAL');
    $scope.serviceList.push('TRANSHIPMENT');

    $scope.tcamountCalculation = function(bcamount, index, row) {
        row.bcamount = parseFloat(bcamount);
        if ($scope.creditnoteAcctData.exchangeRate != 0 && $scope.creditnoteAcctData.exchangeRate != "") {
            var tcAmt = (parseFloat(bcamount) * $scope.creditnoteAcctData.exchangeRate).toFixed(2);
            row.tcamount = tcAmt;
            $scope.totalAmountCalculation();
        } else {
            $scope.creditnoteAcctData.exchangeRate = 1.0;
            var tcAmt = (parseFloat(bcamount) * $scope.creditnoteAcctData.exchangeRate).toFixed(2);
            row.tcamount = tcAmt;
            $scope.totalAmountCalculation();
        }

    }
    
    

    $scope.feeCalculation = function() {
        // 23.2.16
        var tcamount = $scope.creditnoteAcctData.feeRate * $scope.creditnoteAcctData.noOfBill;

        $scope.creditnoteAcctData.totalTCFee = tcamount;
        console.log("Fee" + $scope.creditnoteAcctData.totalBCFee);
        if ($scope.creditnoteAcctData.exchangeRate != 0 && $scope.creditnoteAcctData.exchangeRate != "") {
            var bcAmt = (parseFloat(tcamount) / $scope.creditnoteAcctData.exchangeRate).toFixed(2);
            $scope.creditnoteAcctData.totalBCFee = bcAmt;
            $scope.totalAmountCalculation();
        } else {
            $scope.creditnoteAcctData.exchangeRate = 1.0;
            var bcAmt = (parseFloat(tcamount) / $scope.creditnoteAcctData.exchangeRate).toFixed(2);
            $scope.creditnoteAcctData.totalBCFee = bcAmt;
            $scope.totalAmountCalculation();
        }

    }

    /**
     * rate calculation - tc and bc amount will calculated with exchange rate
     */
    $scope.rateCalculation = function(qty, index, row) {
        var tcamount = qty * row.conRate;
        row.tcamount = parseFloat(tcamount);
        if ($scope.creditnoteAcctData.exchangeRate != 0 && $scope.creditnoteAcctData.exchangeRate != "") {
            var bcAmt = (parseFloat(tcamount) / $scope.creditnoteAcctData.exchangeRate).toFixed(2);
            row.bcamount = bcAmt;
            $scope.totalAmountCalculation();
        } else {
           /* $scope.creditnoteAcctData.exchangeRate = 1.0;*/
            if($scope.creditnoteAcctData.exchangeRate!="" && $scope.creditnoteAcctData.exchangeRate!=null){
                var bcAmt = (parseFloat(tcamount) / $scope.creditnoteAcctData.exchangeRate).toFixed(2);
                row.bcamount = bcAmt;
                $scope.totalAmountCalculation();    
            }else{
                row.bcamount = 0;
               // logger.logError("Please Check Exchange Rate!")
            }            
        }
    }

    $scope.exchageratePHChdr = function(exchangeRate){
         
        if(exchangeRate>0){
            angular.forEach($scope.creditnoteAcctData.credittables, function(phcRow,giIndex){
                
                if(isNaN(parseFloat(phcRow.tcamount, 10))){
                    if(isNaN(parseFloat(phcRow.bcamount, 10))){
                        var bcAmt = (parseFloat(phcRow.tcamount) / exchangeRate);
                        var tcAmt = (parseFloat(phcRow.bcamount) * exchangeRate);
                        phcRow.tcamount = isNaN(tcAmt)?0:tcAmt.toFixed(2); 
                        phcRow.bcamount = isNaN(bcAmt)?0:bcAmt.toFixed(2); 
                    }else{
                        var tcAmt = (parseFloat(phcRow.bcamount) * exchangeRate);
                        phcRow.tcamount = isNaN(tcAmt)?0:tcAmt.toFixed(2);  
                    }
                }else {
                    var bcAmt = (parseFloat(phcRow.tcamount) / exchangeRate);
                    phcRow.bcamount = isNaN(bcAmt)?0:bcAmt.toFixed(2); 
                } 
            });          
            
        }else{
            logger.logError("Please Check Exchange Rate!")
        }
        $scope.totalAmountCalculation();
     }
    
    $scope.bcamountCalculation = function(tcamount, index, row) {

        row.tcamount = parseFloat(tcamount);
        if ($scope.creditnoteAcctData.exchangeRate != 0 && $scope.creditnoteAcctData.exchangeRate != "") {
            var bcAmt = (parseFloat(tcamount) / $scope.creditnoteAcctData.exchangeRate).toFixed(2);
            row.bcamount = bcAmt;
            $scope.totalAmountCalculation();
        } else {
            $scope.creditnoteAcctData.exchangeRate = 1.0;
            var bcAmt = (parseFloat(tcamount) / $scope.creditnoteAcctData.exchangeRate).toFixed(2);
            row.bcamount = bcAmt;
            $scope.totalAmountCalculation();
        }

    }
    /**
     * load Credit Note Detail Table ******************************************
     */
    $scope.loadCrTable = function() {
        var crtable = {};

        crtable = {
            select : '',
            slNo : 1,
            crdtlAccountHead : 'THC AT SINGAPORE',
            service : '',
            conType : '',
            conRate : '',
            noOfCon : '',
            bcamount : '0',
            tcamount : '0',
            attributeList : []

        };

        $scope.creditnoteAcctData.credittables.push(crtable);

    }
    // add Row - detail table
    $scope.addCredRow = function(tables) {
        var len = tables.length;
        var table = {
            select : '',
            slNo : 1,
            crdtlAccountHead : 'THC AT SINGAPORE',
            service : '',
            conType : '',
            conRate : '',
            noOfCon : '',
            bcamount : '0',
            tcamount : '0',
            attributeList : []
        };
        table.slNo = len + 1;
        tables.push(table);
    };
    $scope.loadCrTable();

    // remove Row - detail table
    $scope.removeCredRow = function(table) {
        $scope.tablerow = [];
        angular.forEach(table, function(row, index) {
            var check = row.select;
            if (check == undefined || check == "") {
                $scope.tablerow.push(row);
            } else {
            }
        });
        angular.forEach($scope.tablerow, function(row, index) {
            row.slNo = index + 1;
        });
        $scope.creditnoteAcctData.credittables = $scope.tablerow;
        $scope.totalAmountCalculation();
    };
    $scope.removeDoRow = function(table) {
        $scope.tablerow1 = [];
        angular.forEach(table, function(row, index) {
            var check = row.select;
            if (check == undefined || check == "") {
                $scope.tablerow1.push(row);
            } else {
            }
        });
        angular.forEach($scope.tablerow1, function(row, index) {
            row.slNo = index + 1;
        });
        $scope.creditnoteAcctData.doorOpenTable = $scope.tablerow1;
        $scope.totalAmountCalculation();
    };

    // Injector

    $scope.submit = function() {
        $scope.creditnoteAcctData.invoiceDate = $('#invoiceDate').val();
        if (new validationService().checkFormValidity($scope.creditNoteForm)) {
            if ($scope.creditnoteAcctData.slotStatus == 'Y') {
                $scope.save();
            } else {
                logger.logError("Container details not uploaded for this BL no!");
            }

        } else {
            toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.creditNoteForm.$validationSummary), 5000, 'trustedHtml');
        }
    };

    
    
    $scope.error = function(message) {
        console.log('Error ' + message);
        console.log(sharedProperties);
        console.log(sharedProperties.getErrorObject());
        logger.logErrorHtml(sharedProperties.getErrorObject());
    };
    
    /**
     * 
     */
    
    $scope.save = function() {
        // $('#saveInvoice').attr('disabled', true);   
            if ($scope.edit == false) {
                console.log($scope.creditnoteAcctData);
                var myURL = $stateParams.tenantid+'/app/PHCInvoice/save';
                var PHCInvoiceNewBean = $scope.creditnoteAcctData;
                $http({
                    url : myURL,
                    data : PHCInvoiceNewBean,
                    method : 'post',
                    dataType : 'json',
                    headers : {
                        'Accept' : 'application/json',
                        'Content-Type' : 'application/json'
                    }
                }).success(function(result) {
                    if (result.success) {
                        logger.logSuccess("Saved successfully!");
                        $location.path('/invoice/phcinvoicenew/list');
                        var phcInvoiceNo = result.lPHCInvoiceBean[0].phcinvoiceCode;
                        console.log("SAVE::::::::::::phcInvoiceNo::::::" + phcInvoiceNo);
                        $timeout(function() {
                            $scope.printPHCInvoice(phcInvoiceNo, 'both', 0);
                        }, 1000);

                    } else {
                        logger.logError("Invoice not saved. Please check whether the payer has been invoiced already against this BL no!");
                    }
                }).error(function(result) {
                    console.log("data" + result);
                });
            
           
        } else {
            console.log("creditnoteMasterData ON UPDATE :::::::::::::::::::");
            console.log($scope.creditnoteAcctData);
            $http.post($stateParams.tenantid+'/app/creditNote/update', $scope.creditnoteAcctData).success(function(result) {
                console.log("result:::::::app/creditNote/Update:::::::::::");
                console.log(result);
                if (result) {
                    logger.logSuccess("Updated successfully!");
                    $location.path('/transaction/creditnotehdr/list');
                } else {
                    logger.logError("PHC Code Already Exist!");
                }
            }).error(function(result) {
                console.log("data" + result);
            });
        }
        
    };

    /**
     * print PHC Invoice
     */
    $scope.printPHCInvoice = function(phcInvoiceNo, selection, index) {
        $timeout(function() {
            var url = $stateParams.tenantid+'/app/PHCInvoice/print?phcInvoiceNo=' + phcInvoiceNo + '&selectedPrintOption=' + selection;
            var wnd = window.open(url, 'Shipping', 'height=400,width=750,top=100,left=100,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
            wnd.print();
        }, 1000);
    }
    /**
     * total Amount Calculation - calculate from credit note detail table..
     */
    $scope.totalAmountCalculation = function() {
        var crDtlRowDatas = $scope.creditnoteAcctData.credittables;
        var bcAmt = 0, tcAmt = 0;
        angular.forEach(crDtlRowDatas, function(item, key) {
            bcAmt += parseFloat(crDtlRowDatas[key].bcamount);
            tcAmt += parseFloat(crDtlRowDatas[key].tcamount);
            $scope.creditnoteAcctData.totalBCAmount = bcAmt;
            $scope.creditnoteAcctData.totalTCAmount = tcAmt;

        });
        angular.forEach($scope.creditnoteAcctData.doorOpenTable, function(item, key) {
            bcAmt += parseFloat($scope.creditnoteAcctData.doorOpenTable[key].bcamount);
            tcAmt += parseFloat($scope.creditnoteAcctData.doorOpenTable[key].tcamount);
            $scope.creditnoteAcctData.totalBCAmount = bcAmt;
            $scope.creditnoteAcctData.totalTCAmount = tcAmt;

        });
        $scope.creditnoteAcctData.totalBCAmount = (parseFloat($scope.creditnoteAcctData.totalBCAmount) + parseFloat($scope.creditnoteAcctData.totalBCFee)).toFixed(2);
        $scope.creditnoteAcctData.totalTCAmount = (parseFloat($scope.creditnoteAcctData.totalTCAmount) + parseFloat($scope.creditnoteAcctData.totalTCFee)).toFixed(2);
    }

    $scope.cancel = function() {
        $state.go('app.finance.invoice.PHCInvoicenew.list',{tenantid:$stateParams.tenantid});
    };

    var creditCode = $location.search().creditCode;

    console.log('creditCode :::::::::::::::::');
    console.log(creditCode);

    if (creditCode != undefined) {
        var formData = new FormData();
        formData.append("creditCode", creditCode);
        $scope.edit = true;
        $http.get($stateParams.tenantid+'/app/creditNote/getCreditNoteForEdit?creditCode=' + creditCode).success(function(data) {
            console.log('Edit Data:::::::::::::::::');
            console.log(data);
            $scope.acctHeadList = data.acctHeadList;
            $scope.invoiceNoList = data.invoiceList;
            $scope.creditnoteAcctData = data;
            $scope.totalAmountCalculation();
        }).error(function(data) {
            logger.logError("Unable to Get Data");
        });

    } else {
        $scope.edit = false;
    }

});
app.controller('phcInvoiceViewCtrl', function($scope, $filter, $window, $rootScope, $location, $http, logger, $log, ngDialog, $modal, utilsService, sharedProperties, $state, $injector, ListService, $stateParams, validationService, toaster, $timeout) {

    /*
     * $scope.creditnoteAcctData = { PHCInvoiceCode : '', accountName : '',
     * vessel : '', voyage : '', pol : '', pod : '', pot : '', blNo : '',
     * customerCode : '', invoiceNo : '', invoiceDate : '', currencyCode :
     * 'SGD', feeType : '', exchangeRate : '', feeRate : '0', noOfBill : '0',
     * totalBCFee : '0', totalTCFee : '0', companyCode : '', company : '',
     * bctotal : '', tctotal : '', totalTCAmount : '', credittables : [] };
     * 
     * $scope.loadCrTable = function() { var crtable = {};
     * 
     * crtable = { select : '', slNo : 1, crdtlAccountHead : '', service : '',
     * conType : '', conRate : '', noOfCon : '', bcamount : '', tcamount : '',
     * attributeList : [] };
     * $scope.creditnoteAcctData.credittables.push(crtable); }
     * $scope.loadCrTable();
     */
    /**
     * View - fetch the details on Edit with "Voucher No"
     */

    $scope.phcTable = false;
    
    var phcinvoiceNo = $stateParams.phcinvoiceNo;

    if (phcinvoiceNo == undefined || phcinvoiceNo == null || phcinvoiceNo == "") {

    } else {
        var locationurl = $location.url();
        if (locationurl.indexOf("view") > -1) {
            $scope.isView = true;
        }
    }

    var phcinvoiceNo1 = $stateParams.phcinvoiceNo1;

    if (phcinvoiceNo1 == undefined || phcinvoiceNo1 == null || phcinvoiceNo1 == "") {

    } else {
        $scope.phcTable = true;
        var locationurl = $location.url();
        if (locationurl.indexOf("view") > -1) {
            $scope.isView1 = true;
        }
    }
    
    if ($scope.isView) {
        $http.post($stateParams.tenantid+'/app/PHCInvoice/getPHCInvoiceforView?phcinvoiceNo=' + phcinvoiceNo).success(function(data) {
            console.log(data);
            $scope.creditnoteAcctData = data;

            $scope.creditnoteAcctData.totalBCAmount = data.totalbc;
            $scope.creditnoteAcctData.totalTCAmount = data.totaltc;

            // $scope.rateCalculation(data.credittables);
            // $scope.totalAmountCalculation();
        }).error(function(data) {
        });
    }
    
    if ($scope.isView1) {
        $http.post($stateParams.tenantid+'/app/PHCInvoice/getPHCInvoiceforView?phcinvoiceNo=' + phcinvoiceNo1).success(function(data) {
            console.log(data);
            $scope.creditnoteAcctData = data;

            $scope.creditnoteAcctData.totalBCAmount = data.totalbc;
            $scope.creditnoteAcctData.totalTCAmount = data.totaltc;

            // $scope.rateCalculation(data.credittables);
            // $scope.totalAmountCalculation();
        }).error(function(data) {
        });
    }

    $scope.printPHCInvoice = function(phcInvoiceNo, selection, index) {
        $timeout(function() {
            var url = $stateParams.tenantid+'/app/PHCInvoice/print?phcInvoiceNo=' + phcInvoiceNo + '&selectedPrintOption=' + selection;
            var wnd = window.open(url, 'Shipping', 'height=600,width=800,top=100,left=100,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
            wnd.print();
        }, 500);
    }

    $scope.rateCalculation = function(rowObj) {
        
        angular.forEach(rowObj, function(row, index) {
            
            var bcamount = parseInt(row.noOfCon) * parseFloat(row.conRate);
            row.bcamount = parseFloat(bcamount);
            if ($scope.creditnoteAcctData.exchangeRate != 0 && $scope.creditnoteAcctData.exchangeRate != "") {
                var tcAmt = (parseFloat(bcamount) * $scope.creditnoteAcctData.exchangeRate).toFixed(2);
                row.tcamount = tcAmt;

            } else {
                $scope.creditnoteAcctData.exchangeRate = 1.0;
                var tcAmt = (parseFloat(bcamount) * $scope.creditnoteAcctData.exchangeRate).toFixed(2);
                row.tcamount = tcAmt;

            }
        })
        /**/

    }

    $scope.feeCalculation = function() {
        var bcamount = $scope.creditnoteAcctData.feeRate * $scope.creditnoteAcctData.noOfBill;
        $scope.creditnoteAcctData.totalBCFee = bcamount;
        console.log("Fee" + $scope.creditnoteAcctData.totalBCFee);
        if ($scope.creditnoteAcctData.exchangeRate != 0 && $scope.creditnoteAcctData.exchangeRate != "") {
            var tcAmt = (parseFloat(bcamount) * $scope.creditnoteAcctData.exchangeRate).toFixed(2);
            $scope.creditnoteAcctData.totalTCFee = tcAmt;
            $scope.totalAmountCalculation();
        } else {
            $scope.creditnoteAcctData.exchangeRate = 1.0;
            var tcAmt = (parseFloat(bcamount) * $scope.creditnoteAcctData.exchangeRate).toFixed(2);
            $scope.creditnoteAcctData.totalTCFee = tcAmt;
            $scope.totalAmountCalculation();
        }

    }

    $scope.totalAmountCalculation = function() {
        var crDtlRowDatas = $scope.creditnoteAcctData.credittables;
        var bcAmt = 0, tcAmt = 0;
        angular.forEach(crDtlRowDatas, function(item, key) {
            bcAmt += parseFloat(crDtlRowDatas[key].bcamount);
            tcAmt += parseFloat(crDtlRowDatas[key].tcamount);
            $scope.creditnoteAcctData.totalBCAmount = bcAmt;
            $scope.creditnoteAcctData.totalTCAmount = tcAmt;

        });
        angular.forEach($scope.creditnoteAcctData.doorOpenTable, function(item, key) {
            bcAmt += parseFloat($scope.creditnoteAcctData.doorOpenTable[key].bcamount);
            tcAmt += parseFloat($scope.creditnoteAcctData.doorOpenTable[key].tcamount);
            $scope.creditnoteAcctData.totalBCAmount = bcAmt;
            $scope.creditnoteAcctData.totalTCAmount = tcAmt;

        });

        $scope.creditnoteAcctData.totalBCAmount = (parseFloat($scope.creditnoteAcctData.totalBCAmount) + parseFloat($scope.creditnoteAcctData.totalBCFee));
        $scope.creditnoteAcctData.totalTCAmount = (parseFloat($scope.creditnoteAcctData.totalTCAmount) + parseFloat($scope.creditnoteAcctData.totalTCFee));
    }

    /**
     * cancel
     */
    $scope.cancel = function() {
        $state.go('app.finance.invoice.PHCInvoicenew.list',{tenantid:$stateParams.tenantid});
    };
    
    $scope.cancel1 = function() {
        $state.go('app.reports.finance.invoiceInformation',{tenantid:$stateParams.tenantid});
    };

});

app.service("ListService", function($http, $q) {

    this.getDateInDDMMYYYY = function convert(str) {
        var date = new Date(str), mnth = ("0" + (date.getMonth() + 1)).slice(-2), day = ("0" + date.getDate()).slice(-2);
        return [ day, mnth, date.getFullYear() ].join("/");
    }
});

app.controller('tableCtrl', function($scope, $http, $filter, logger,$stateParams) {
    $scope.phcTable = false;
    
    $scope.$watch('creditnoteAcctData.credittables[trIndex].conType', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
            var container = $scope.creditnoteAcctData.credittables[$scope.$index].conType;
            var service = $scope.creditnoteAcctData.credittables[$scope.$index].service;
            var pol = $scope.creditnoteAcctData.pol;
            var pod = $scope.creditnoteAcctData.pod;
            console.log(container + service + pol);

            /*
             * $http.get('app/commonUtility/getSubAccountCodeListTradeDebtors').success(function(datas) {
             * 
             * $scope.creditnoteAcctData.credittables[$scope.$index].subAccountCodeList =
             * datas;
             * $scope.creditnoteAcctData.credittables[$scope.$index].isSubAccountCode =
             * true; }).error(function(datas) { });
             */

            $scope.PHCFilterDate = {
                conType : container,
                pol : pol,
                pod : pod,
                service : service
            }
            $http.post($stateParams.tenantid+'/app/PHCInvoice/getPHCRate', $scope.PHCFilterDate).success(function(datas) {
                if (datas.sucess) {
                    $scope.creditnoteAcctData.credittables[$scope.$index].conRate = datas.conRate;
                    //$scope.creditnoteAcctData.credittables[$scope.$index].noOfCon = '';
                    //$scope.creditnoteAcctData.credittables[$scope.$index].tcamount = 0;
                    //$scope.creditnoteAcctData.credittables[$scope.$index].bcamount = 0;
                    
                    $scope.rateCalculation($scope.creditnoteAcctData.credittables[$scope.$index].noOfCon , $scope.$index, $scope.creditnoteAcctData.credittables[$scope.$index]);
                }
            }).error(function(data) {
            });

        }
    });

    $scope.$watch('creditnoteAcctData.credittables[trIndex].crdtlAccountHead', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {

            if (newValue == '10080001') {
                $http.get($stateParams.tenantid+'/app/commonUtility/getSubAccountCodeListTradeDebtors').success(function(datas) {

                    $scope.creditnoteAcctData.credittables[$scope.$index].subAccountCodeList = datas;
                    $scope.creditnoteAcctData.credittables[$scope.$index].isSubAccountCode = true;
                }).error(function(datas) {
                });
            } else if (newValue == '20010001') {
                $http.get($stateParams.tenantid+'/app/commonUtility/getSubAccountCodeListTradeCreditors').success(function(datas) {
                    $scope.creditnoteAcctData.credittables[$scope.$index].subAccountCodeList = datas;
                    $scope.creditnoteAcctData.credittables[$scope.$index].isSubAccountCode = true;
                }).error(function(datas) {
                });
            } else if (newValue == '10070001') {
                $http.get($stateParams.tenantid+'/app/commonUtility/getStaffListForAdvances').success(function(datas) {
                    $scope.creditnoteAcctData.credittables[$scope.$index].subAccountCodeList = datas;
                    $scope.creditnoteAcctData.credittables[$scope.$index].isSubAccountCode = true;
                }).error(function(datas) {
                });
            } else {
                $scope.creditnoteAcctData.credittables[$scope.$index].subAccountCodeList = [];
                $scope.creditnoteAcctData.credittables[$scope.$index].isSubAccountCode = false;
            }

            $http.get($stateParams.tenantid+'/app/commonUtility/getAttributesList?accountCode=' + newValue).success(function(datas) {
                $scope.creditnoteAcctData.credittables[$scope.$index].attributeList = datas;
                if (newValue == oldValue) {
                    $scope.isOnChange = false;
                } else {
                    $scope.isOnChange = true;
                }
                if (!$scope.edit || $scope.isOnChange) {

                    $scope.creditnoteAcctData.credittables[$scope.$index].voyageCode = '';
                    $scope.creditnoteAcctData.credittables[$scope.$index].vesselCode = '';
                    $scope.creditnoteAcctData.credittables[$scope.$index].sectorCode = '';
                    $scope.creditnoteAcctData.credittables[$scope.$index].employeeCode = '';
                    $scope.creditnoteAcctData.credittables[$scope.$index].portCode = '';
                    $scope.creditnoteAcctData.credittables[$scope.$index].portSequence = '';
                    $scope.creditnoteAcctData.credittables[$scope.$index].departmentCode = '';
                    $scope.creditnoteAcctData.credittables[$scope.$index].agentCode = '';
                    $scope.creditnoteAcctData.credittables[$scope.$index].countryCode = '';
                    $scope.creditnoteAcctData.credittables[$scope.$index].customerCode = '';
                    $scope.creditnoteAcctData.credittables[$scope.$index].supplierCode = '';
                    $scope.creditnoteAcctData.credittables[$scope.$index].designationCode = '';
                    $scope.creditnoteAcctData.credittables[$scope.$index].costCenter = '';
                    $scope.creditnoteAcctData.credittables[$scope.$index].companyCode = '';
                    $scope.creditnoteAcctData.credittables[$scope.$index].quantityGO = '';
                    $scope.creditnoteAcctData.credittables[$scope.$index].quantityFO = '';
                }

                $scope.creditnoteAcctData.credittables[$scope.$index].isVoyage = false;
                $scope.creditnoteAcctData.credittables[$scope.$index].isVessel = false;
                $scope.creditnoteAcctData.credittables[$scope.$index].isService = false;
                $scope.creditnoteAcctData.credittables[$scope.$index].isEmployee = false;
                $scope.creditnoteAcctData.credittables[$scope.$index].isPort = false;
                $scope.creditnoteAcctData.credittables[$scope.$index].isDepartment = false;
                $scope.creditnoteAcctData.credittables[$scope.$index].isAgent = false;
                $scope.creditnoteAcctData.credittables[$scope.$index].isLocation = false;
                $scope.creditnoteAcctData.credittables[$scope.$index].isCustomer = false;
                $scope.creditnoteAcctData.credittables[$scope.$index].isSupplier = false;
                $scope.creditnoteAcctData.credittables[$scope.$index].isDesignation = false;
                $scope.creditnoteAcctData.credittables[$scope.$index].isCostCenter = false;
                $scope.creditnoteAcctData.credittables[$scope.$index].isCompany = false;
                $scope.creditnoteAcctData.credittables[$scope.$index].isQuantityGO = false;
                $scope.creditnoteAcctData.credittables[$scope.$index].isQuantityFO = false;
                $scope.creditnoteAcctData.credittables[$scope.$index].isPortSequence = false;

                angular.forEach($scope.creditnoteAcctData.credittables[$scope.$index].attributeList, function(row, rowindex) {

                    if (row.attributeName == "Voyage") {
                        $scope.creditnoteAcctData.credittables[$scope.$index].isVoyage = true;
                    } else if (row.attributeName == "Vessel") {
                        $scope.creditnoteAcctData.credittables[$scope.$index].isVessel = true;
                    } else if (row.attributeName == "Service") {
                        $scope.creditnoteAcctData.credittables[$scope.$index].isService = true;
                    } else if (row.attributeName == "Employee") {
                        $scope.creditnoteAcctData.credittables[$scope.$index].isEmployee = true;
                    } else if (row.attributeName == "Port") {
                        $scope.creditnoteAcctData.credittables[$scope.$index].isPort = true;
                    } else if (row.attributeName == "Department") {
                        $scope.creditnoteAcctData.credittables[$scope.$index].isDepartment = true;
                    } else if (row.attributeName == "Agent") {
                        $scope.creditnoteAcctData.credittables[$scope.$index].isAgent = true;
                    } else if (row.attributeName == "Location") {
                        $scope.creditnoteAcctData.credittables[$scope.$index].isLocation = true;
                    } else if (row.attributeName == "Customer") {
                        $scope.creditnoteAcctData.credittables[$scope.$index].isCustomer = true;
                    } else if (row.attributeName == "Supplier") {
                        $scope.creditnoteAcctData.credittables[$scope.$index].isSupplier = true;
                    } else if (row.attributeName == "Designation") {
                        $scope.creditnoteAcctData.credittables[$scope.$index].isDesignation = true;
                    } else if (row.attributeName == "Cost Center") {
                        $scope.creditnoteAcctData.credittables[$scope.$index].isCostCenter = true;
                    } else if (row.attributeName == "Company") {
                        $scope.creditnoteAcctData.credittables[$scope.$index].isCompany = true;
                    } else if (row.attributeName == "Quantity (MT) GO") {
                        $scope.creditnoteAcctData.credittables[$scope.$index].isQuantityGO = true;
                    } else if (row.attributeName == "Quantity (MT) FO") {
                        $scope.creditnoteAcctData.credittables[$scope.$index].isQuantityFO = true;
                    } else if (row.attributeName == "Port with Sequence") {
                        $scope.creditnoteAcctData.credittables[$scope.$index].isPortSequence = true;
                    }
                });
            }).error(function(datas) {
            });

        }
    });
    $scope.$watch('creditnoteAcctData.credittables[trIndex].subAcctCode', function(newValue, oldValue) {

        if (newValue != '' && newValue != undefined) {
            $scope.creditnoteAcctData.credittables[$scope.$index].subAcctCode = newValue;
        }

    });
});

app.controller('tableViewCtrl', function($scope, $http, $filter, logger,$stateParams) {
    $scope.phcTable = false;
    
    $scope.$watch('creditnoteAcctData.credittables[trIndex].conType', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
            // $scope.creditnoteAcctData.credittables[$scope.$index].conRate =
            // '5';
        }
    });

    $scope.$watch('creditnoteAcctData.credittables[trIndex].crdtlAccountHead', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {

            if (newValue == '10080001') {
                $http.get($stateParams.tenantid+'/app/commonUtility/getSubAccountCodeListTradeDebtors').success(function(datas) {

                    $scope.creditnoteAcctData.credittables[$scope.$index].subAccountCodeList = datas;
                    $scope.creditnoteAcctData.credittables[$scope.$index].isSubAccountCode = true;
                }).error(function(datas) {
                });
            } else if (newValue == '20010001') {
                $http.get($stateParams.tenantid+'/app/commonUtility/getSubAccountCodeListTradeCreditors').success(function(datas) {
                    $scope.creditnoteAcctData.credittables[$scope.$index].subAccountCodeList = datas;
                    $scope.creditnoteAcctData.credittables[$scope.$index].isSubAccountCode = true;
                }).error(function(datas) {
                });
            } else if (newValue == '10070001') {
                $http.get($stateParams.tenantid+'/app/commonUtility/getStaffListForAdvances').success(function(datas) {
                    $scope.creditnoteAcctData.credittables[$scope.$index].subAccountCodeList = datas;
                    $scope.creditnoteAcctData.credittables[$scope.$index].isSubAccountCode = true;
                }).error(function(datas) {
                });
            } else {
                $scope.creditnoteAcctData.credittables[$scope.$index].subAccountCodeList = [];
                $scope.creditnoteAcctData.credittables[$scope.$index].isSubAccountCode = false;
            }

            $http.get($stateParams.tenantid+'/app/commonUtility/getAttributesList?accountCode=' + newValue).success(function(datas) {
                $scope.creditnoteAcctData.credittables[$scope.$index].attributeList = datas;
                if (newValue == oldValue) {
                    $scope.isOnChange = false;
                } else {
                    $scope.isOnChange = true;
                }
                if (!$scope.isView || $scope.isOnChange) {
                    $scope.creditnoteAcctData.credittables[$scope.$index].voyageCode = '';
                    $scope.creditnoteAcctData.credittables[$scope.$index].vesselCode = '';
                    $scope.creditnoteAcctData.credittables[$scope.$index].sectorCode = '';
                    $scope.creditnoteAcctData.credittables[$scope.$index].employeeCode = '';
                    $scope.creditnoteAcctData.credittables[$scope.$index].portCode = '';
                    $scope.creditnoteAcctData.credittables[$scope.$index].portSequence = '';
                    $scope.creditnoteAcctData.credittables[$scope.$index].departmentCode = '';
                    $scope.creditnoteAcctData.credittables[$scope.$index].agentCode = '';
                    $scope.creditnoteAcctData.credittables[$scope.$index].countryCode = '';
                    $scope.creditnoteAcctData.credittables[$scope.$index].customerCode = '';
                    $scope.creditnoteAcctData.credittables[$scope.$index].supplierCode = '';
                    $scope.creditnoteAcctData.credittables[$scope.$index].designationCode = '';
                    $scope.creditnoteAcctData.credittables[$scope.$index].costCenter = '';
                    $scope.creditnoteAcctData.credittables[$scope.$index].companyCode = '';
                    $scope.creditnoteAcctData.credittables[$scope.$index].quantityGO = '';
                    $scope.creditnoteAcctData.credittables[$scope.$index].quantityFO = '';
                }

                $scope.creditnoteAcctData.credittables[$scope.$index].isVoyage = false;
                $scope.creditnoteAcctData.credittables[$scope.$index].isVessel = false;
                $scope.creditnoteAcctData.credittables[$scope.$index].isService = false;
                $scope.creditnoteAcctData.credittables[$scope.$index].isEmployee = false;
                $scope.creditnoteAcctData.credittables[$scope.$index].isPort = false;
                $scope.creditnoteAcctData.credittables[$scope.$index].isDepartment = false;
                $scope.creditnoteAcctData.credittables[$scope.$index].isAgent = false;
                $scope.creditnoteAcctData.credittables[$scope.$index].isLocation = false;
                $scope.creditnoteAcctData.credittables[$scope.$index].isCustomer = false;
                $scope.creditnoteAcctData.credittables[$scope.$index].isSupplier = false;
                $scope.creditnoteAcctData.credittables[$scope.$index].isDesignation = false;
                $scope.creditnoteAcctData.credittables[$scope.$index].isCostCenter = false;
                $scope.creditnoteAcctData.credittables[$scope.$index].isCompany = false;
                $scope.creditnoteAcctData.credittables[$scope.$index].isQuantityGO = false;
                $scope.creditnoteAcctData.credittables[$scope.$index].isQuantityFO = false;
                $scope.creditnoteAcctData.credittables[$scope.$index].isPortSequence = false;

                angular.forEach($scope.creditnoteAcctData.credittables[$scope.$index].attributeList, function(row, rowindex) {

                    if (row.attributeName == "Voyage") {
                        $scope.creditnoteAcctData.credittables[$scope.$index].isVoyage = true;
                    } else if (row.attributeName == "Vessel") {
                        $scope.creditnoteAcctData.credittables[$scope.$index].isVessel = true;
                    } else if (row.attributeName == "Service") {
                        $scope.creditnoteAcctData.credittables[$scope.$index].isService = true;
                    } else if (row.attributeName == "Employee") {
                        $scope.creditnoteAcctData.credittables[$scope.$index].isEmployee = true;
                    } else if (row.attributeName == "Port") {
                        $scope.creditnoteAcctData.credittables[$scope.$index].isPort = true;
                    } else if (row.attributeName == "Department") {
                        $scope.creditnoteAcctData.credittables[$scope.$index].isDepartment = true;
                    } else if (row.attributeName == "Agent") {
                        $scope.creditnoteAcctData.credittables[$scope.$index].isAgent = true;
                    } else if (row.attributeName == "Location") {
                        $scope.creditnoteAcctData.credittables[$scope.$index].isLocation = true;
                    } else if (row.attributeName == "Customer") {
                        $scope.creditnoteAcctData.credittables[$scope.$index].isCustomer = true;
                    } else if (row.attributeName == "Supplier") {
                        $scope.creditnoteAcctData.credittables[$scope.$index].isSupplier = true;
                    } else if (row.attributeName == "Designation") {
                        $scope.creditnoteAcctData.credittables[$scope.$index].isDesignation = true;
                    } else if (row.attributeName == "Cost Center") {
                        $scope.creditnoteAcctData.credittables[$scope.$index].isCostCenter = true;
                    } else if (row.attributeName == "Company") {
                        $scope.creditnoteAcctData.credittables[$scope.$index].isCompany = true;
                    } else if (row.attributeName == "Quantity (MT) GO") {
                        $scope.creditnoteAcctData.credittables[$scope.$index].isQuantityGO = true;
                    } else if (row.attributeName == "Quantity (MT) FO") {
                        $scope.creditnoteAcctData.credittables[$scope.$index].isQuantityFO = true;
                    } else if (row.attributeName == "Port with Sequence") {
                        $scope.creditnoteAcctData.credittables[$scope.$index].isPortSequence = true;
                    }
                });
            }).error(function(datas) {
            });

        }
    });
    $scope.$watch('creditnoteAcctData.credittables[trIndex].subAcctCode', function(newValue, oldValue) {

        if (newValue != '' && newValue != undefined) {
            $scope.creditnoteAcctData.credittables[$scope.$index].subAcctCode = newValue;
        }

    });
});

//PHC invoice New Search Page

app.controller('phcInvoiceSearchCtrl', function($scope, $rootScope, $http, $location, ngDialog,logger,$controller, utilsService, $state, $window, sharedProperties,$timeout,$stateParams) {

    $scope.phcTable = false;
    
    $scope.phcInvoiceSearch = {
        vessel : '',
        voyage : '',
        pol : '',
        pod : '',
        blNo : '',
        customerCode : '',
        payer:''
    };
    $scope.vesselList = [];
    $scope.voyageList = [];
    $scope.portList = [];
    $scope.customerList = [];
    $scope.blList = [];
    $scope.payerList=[];
    $scope.activity='';
    $scope.company='';
    $scope.service='';
    $scope.rowCollection = [];
    $scope.globalRowCollection=[];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;

    $scope.getVesselList=function(){
        $http.get($stateParams.tenantid+'/app/commonUtility/getVesselList').success(function(datas) {
            $scope.vesselList = datas;
        }).error(function(datas) {
        });        
    }
        $scope.getPortList=function(){
            $http.get($stateParams.tenantid+'/app/PHCInvoice/getPort?voyageCode=' + $scope.phcInvoiceSearch.voyage).success(function(datas) {
                if (datas.length > 0) {
                    $scope.portList = datas;
                }
            }).error(function(data) {
            });
    }
    $scope.getCustomerList=function(){
        $http.post($stateParams.tenantid+'/app/PHCInvoice/getcustomer', $scope.phcInvoiceSearch).success(function(datas) {
            if (datas.length > 0) {
                $scope.customerList = datas;
            }
        }).error(function(data) {
        });
    }
    $scope.getBlNo=function(){
        $http.post($stateParams.tenantid+'/app/PHCInvoice/getBlList', $scope.phcInvoiceSearch).success(function(datas) {
            if (datas.length > 0) {
                $scope.blList = datas;
            }
        }).error(function(data) {
        });
    }
    $scope.getPayerList=function(){
        $http.post($stateParams.tenantid+'/app/PHCInvoice/getPayerList', $scope.phcInvoiceSearch).success(function(datas) {
            if (datas.length > 0) {
                $scope.payerList = datas;
            }
        }).error(function(data) {
        });
    }
    $scope.getActivityAndCompanyAndService = function() {
        var url1 = $stateParams.tenantid+'/app/PHCInvoice/activityAndCmpAndService?voyageId='+$scope.phcInvoiceSearch.voyage;
        $http.post(url1).success(function(data) {
            $scope.activity = data.activity;
            $scope.company = data.company;
            $scope.service = data.service;
        }).error(function(data) {

            logger.logError("Please Try Again");
        });

    }


    $scope.getVesselList();
    
    $scope.$watch('phcInvoiceSearch.vessel', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined && oldValue!= '' && oldValue != undefined ) {
            $scope.voyageList = [];
            $scope.portList = [];
            $http.get($stateParams.tenantid+'/app/PHCInvoice/getVoyageFilter?vesselCode=' + newValue).success(function(datas) {
                if (datas.length > 0) {
                    $scope.voyageList = datas;
                }
            }).error(function(data) {
            });
        }else if (newValue != '' && newValue != undefined) {
            $scope.voyageList = [];
            $scope.phcInvoiceSearch.voyage='';
            $scope.phcInvoiceSearch.pol='';
            $scope.phcInvoiceSearch.pod='';
            $scope.phcInvoiceSearch.blNo='';
            $scope.phcInvoiceSearch.payer='';
            $scope.phcInvoiceSearch.customerCode='';
            $http.get($stateParams.tenantid+'/app/PHCInvoice/getVoyageFilter?vesselCode=' + newValue).success(function(datas) {
                if (datas.length > 0) {
                    $scope.voyageList = datas;
                    }else{
                        logger.logError("Please complete phc export in desktop app!");
                    }
            }).error(function(data) {
            });
        } else {
            $scope.voyageList = [];
        }
    });

    $scope.$watch('phcInvoiceSearch.voyage', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined && oldValue!= '' && oldValue != undefined ) {
            $scope.getPortList();
            $scope.getCustomerList();
            $scope.getActivityAndCompanyAndService();
        }else  if (newValue != '' && newValue != undefined) {
            $scope.portList = [];
            $scope.customerList=[];
            $scope.phcInvoiceSearch.pol='';
            $scope.phcInvoiceSearch.pod='';
            $scope.phcInvoiceSearch.slot='';
            $scope.phcInvoiceSearch.customerCode='';
            $scope.getPortList();
            $scope.getCustomerList();
            $scope.getActivityAndCompanyAndService();
        }
    });
    $scope.$watch('phcInvoiceSearch.customerCode', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
            $scope.blList = [];
            $scope.payerList=[];
            $scope.getBlNo();
            $scope.getPayerList();
        } 
    });
    $scope.viewPhcPendingList=function(){
        
        if($scope.phcInvoiceSearch.vessel =='' || $scope.phcInvoiceSearch.vessel == undefined){
            logger.logError("Select Vessel");
        }else if($scope.phcInvoiceSearch.voyage =='' || $scope.phcInvoiceSearch.voyage == undefined){
            logger.logError("Select Voyage");
        }else if(($scope.phcInvoiceSearch.pol==''&&$scope.phcInvoiceSearch.pod=='')||($scope.phcInvoiceSearch.pol==undefined&&$scope.phcInvoiceSearch.pod==undefined)){
            logger.logError("Please select Pol or Pod");
        }else if(($scope.phcInvoiceSearch.pol!='PSA')&&($scope.phcInvoiceSearch.pod!='PSA')){
            logger.logError("Please select PSA ports");
        }else {
        sharedProperties.setObject($scope.phcInvoiceSearch);
        $state.go('app.finance.invoice.PHCInvoicenew.pendingList',
                ({
                    voyage : $scope.phcInvoiceSearch.voyage,
                    pol : $scope.phcInvoiceSearch.pol,
                    pod : $scope.phcInvoiceSearch.pod,
                    blNo :$scope.phcInvoiceSearch.blNo,
                    customerCode : $scope.phcInvoiceSearch.customerCode,
                    payer:$scope.phcInvoiceSearch.payer
                }),{tenantid:$stateParams.tenantid});
        }
    };
    
    $scope.getCreditNoteTempListUtil = function(limit, offset) {
        $scope.limitCount=0;
        $scope.offsetCount=1000;
        var start = new Date().getTime();
        //var url = 'app/PHCInvoice/cnlisttemp?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount + '&formCode=' + $('#form_code_id').val();
        var url = $stateParams.tenantid+'/app/PHCInvoice/cnlist?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount + '&formCode=' + $('#form_code_id').val();
        $http.get(url).success(function(data) {
            if (data.success == true) {
                angular.forEach(data.lPHCInvoiceBean, function(row, index) {
                    data.lPHCInvoiceBean[index].printList = "both";
                });
                $scope.rowCollection = data.lPHCInvoiceBean;
                $scope.globalRowCollection =data.lPHCInvoiceBean;
            } else {
                logger.logError("Error Please Try Again");
            }
            var end = new Date().getTime();
            var time = end - start;
            console.log('Execution time: ' + time);
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });

    };
    

    $scope.getCreditNoteTempListUtil();
    
    /**
     * view PHC Invoice
     */
    $scope.viewPHCInvoice = function(phcinvoiceNo) {
        $location.path("/invoice/PHCInvoicenewtemp/tempview/" + phcinvoiceNo);
    }
    $scope.reset=function(){
        $scope.phcInvoiceSearch.vessel='';
        $scope.phcInvoiceSearch.voyage='';
        $scope.phcInvoiceSearch.pol='';
        $scope.phcInvoiceSearch.pod='';
        $scope.phcInvoiceSearch.blNo='';
        $scope.phcInvoiceSearch.payer='';
        $scope.phcInvoiceSearch.customerCode='';
        $scope.activity = '';
        $scope.company ='';
        $scope.service = '';
        $scope.rowCollection = [];
        $scope.rowCollection=$scope.globalRowCollection;
    }
    /**
     * PRINT
     */
    
   $scope.printPHCInvoice = function(phcInvoiceNo, selection, index) {
        //var url = 'app/PHCInvoice/printtemp?phcInvoiceNo=' + phcInvoiceNo + '&selectedPrintOption=' + selection; 
        var url = $stateParams.tenantid+'/app/PHCInvoice/print?phcInvoiceNo=' + phcInvoiceNo + '&selectedPrintOption=' + selection;
        var wnd = window.open(url, 'Shipping', 'height=400,width=750,top=100,left=100,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
        wnd.print();
    }

    /**
     * send Mail
     */
    $scope.sendPHCInvoiceMail = function(invoiceNo, selection) {

        // ngDialog.close();
        //phcInvoiceMailCtrltemp
        ngDialog.open({
            template : 'invoiceMail',
            scope : $scope,
            controller : $controller('phcInvoiceMailCtrl', {
                $scope : $scope,
                data : {
                    "phcInvoiceNo" : invoiceNo,
                    "selection" : selection,
                    'mailOption' :'single',
                    'phcRowData':[]
                }
            })
        });
    };

    /* delete Invoice */

    $scope.deletePHCInvoice = function(invoiceNo, index) {
        ngDialog.open({
            template : 'invoiceDelete',
            scope : $scope,
            controller : $controller('phcInvoiceDeleteCtrl', {
                $scope : $scope,
                data : {
                    "phcInvoiceNo" : invoiceNo,
                    "index" : index
                }
            })
        });
    };
    
    $scope.bulkPrint=function(phcRowData){
        var invoiceNos = '';
        var len = phcRowData.length;
        for (var i = 0; i < len; i++) {
            var rowData = phcRowData[i];
            if (typeof rowData.select == "undefined") {
                rowData["select"] = false;
            }
            if (rowData.select == true) {
                if(invoiceNos==""){
                    invoiceNos= rowData.phcinvoiceCode; 
                }
                else{
                    invoiceNos +=","+rowData.phcinvoiceCode;
                }
            }
        } 
        if(invoiceNos!=""){
            //var url = 'app/PHCInvoice/bulkPrinttemp?phcInvoiceNos='+invoiceNos;
            var url = $stateParams.tenantid+'/app/PHCInvoice/bulkPrint?phcInvoiceNos='+invoiceNos;
            var wnd = window.open(url, 'Shipping', 'height=400,width=750,top=100,left=100,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
            wnd.print();    
        }else{
            logger.logError("Please Select Atleast one row!");
        }
        
    }
    
    $scope.bulkPHCInvoiceMail = function(phcRowData, selection) {

        // ngDialog.close();
        //phcInvoiceMailCtrltemp
        ngDialog.open({
            template : 'invoiceMail',
            scope : $scope,
            controller : $controller('phcInvoiceMailCtrl', {
                $scope : $scope,
                data : {
                    "phcInvoiceNo" : '',
                    "selection" : '',
                    'mailOption' :'bulk',
                    'phcRowData':phcRowData
                }
            })
        });
    };
    var obj=sharedProperties.getObject();
    if(obj.voyage != ''){
        $scope.phcInvoiceSearch.vessel=obj.vessel;
        $scope.phcInvoiceSearch.voyage=obj.voyage;
        $scope.phcInvoiceSearch.pol=obj.pol;
        $scope.phcInvoiceSearch.pod=obj.pod;
        $scope.phcInvoiceSearch.blNo=obj.blNo;
        $scope.phcInvoiceSearch.customerCode=obj.customerCode;
        $scope.phcInvoiceSearch.payer=obj.payer;
    }
        

     $scope.searchInvoiceDtl = function() {
         if($scope.phcInvoiceSearch.vessel =='' || $scope.phcInvoiceSearch.vessel == undefined){
             logger.logError("Select Vessel");
         }else if($scope.phcInvoiceSearch.voyage =='' || $scope.phcInvoiceSearch.voyage == undefined){
             logger.logError("Select Voyage");
         }else if(($scope.phcInvoiceSearch.pol==''&&$scope.phcInvoiceSearch.pod=='')||($scope.phcInvoiceSearch.pol==undefined&&$scope.phcInvoiceSearch.pod==undefined)){
             logger.logError("Please select Pol or Pod");
         }else if(($scope.phcInvoiceSearch.pol!='PSA')&&($scope.phcInvoiceSearch.pod!='PSA')){
             logger.logError("Please select PSA ports");
         }else {
            $http.post($stateParams.tenantid+'/app/PHCInvoice/phcfilterlist', $scope.phcInvoiceSearch).success(function(data) {
                if (data.success) {
                    angular.forEach(data.lPHCInvoiceBean, function(row, index) {
                        data.lPHCInvoiceBean[index].printList = "both";
                    });
                    $scope.rowCollection = [];
                    $scope.rowCollection = data.lPHCInvoiceBean;
                } else {
                    logger.logError("Error Please Try Again");
                }
            }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
         }

    };
    
    $scope.exceptionList = function() {
        ngDialog.close();
        ngDialog.open({
            template : 'exceptionListTemplate',
            scope : $scope,
            controller : [ '$scope', 'ngDialog', function($scope, ngDialog) {
                $scope.headerName = "Exclusion List";
                $scope.closeHelpDialog = function() {
                    ngDialog.close();
                };
            } ]
        });
    };
    
    $scope.ifxSector=["CMA","HMM","KMTC","TS LINES","IAL","ZIM","RCL"];
    $scope.agiSector=["COSCO","EVERGREEN","KMTC"];
    $scope.ciscSector=["EVERGREEN","HAPAG LLOYD","NYK","TS LINES","YANG MING LINES","K LINE"];
    $scope.ifx2Sector=["PIL","COSCO","K LINE","WAN HAI","SCI"];
    $scope.scsSector=["MERCHANT","SAMUDERA"];
    
    
});
app.controller('pendingPhcCtrl', function($scope, $rootScope, $http, $location, logger, utilsService, $state, $window, sharedProperties,$stateParams) {
    $scope.phcTable = false;
    
    $scope.phcInvoiceSearch = {
        voyage : '',
        pol : '',
        pod : '',
        blNo : '',
        customerCode : '',
        payer : ''
    };
    $scope.viewPhcPendingList = function() {
        //$http.post('app/PHCInvoice/viewPhcPendingList', $scope.phcInvoiceSearch).success(function(datas) {
        $http.post($stateParams.tenantid+'/app/phc/vwPendingBlList', $scope.phcInvoiceSearch).success(function(datas) {
            if (datas.length > 0) {
                $scope.pendingRowCollection = datas;
            }
        }).error(function(data) {
        });
    }
    if ($stateParams != undefined) {
        $scope.phcInvoiceSearch = angular.copy($stateParams);
        $scope.viewPhcPendingList();
    }
    $scope.getPendingPhCDetails=function(objListItem){
        if(objListItem.available){
            $state.go('app.finance.invoice.PHCInvoicenew-add',{tenantid:$stateParams.tenantid} ({
                'blNo' : objListItem.blNo,
                'flag' : objListItem.flag,
                'bookdtl' : objListItem.bookdtlid,
                'slNo' : objListItem.slNo
            }));
        }else{
            logger.logError("Either Out Bound/In Bound details not Uploaded/Exported for this BL !");
        }
    };
    
    $scope.cancel = function() {
        $state.go('app.finance.invoice.PHCInvoicenew.search',{tenantid:$stateParams.tenantid});
    };

});
/**
 * Add form - new entry controller
 */
app.controller('phcinvoiceCtrlAddNew', function($scope, $filter, $window, $rootScope, $location, $http, logger, $log, ngDialog, $modal, utilsService, sharedProperties, $state, $injector, ListService, $stateParams, validationService, toaster, $timeout) {
    
    $scope.phcTable = false;

    /*var splitPath = $location.url().split("/");
    $scope.globalSlno = splitPath[splitPath.length - 1];
    $scope.globalBdlid = splitPath[splitPath.length - 2];
    $scope.globalflag = splitPath[splitPath.length - 3];
    $scope.globalBl = splitPath[splitPath.length - 4];
    */
    $scope.globalObject= {
            blNo :'',
            flag :'',
            bookdtl:'',
            slNo : ''
    }
    
    $scope.globalObject = $stateParams;
    $scope.dataLoopCount = 0;
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.acctHeadList = [];
    $scope.portList = [];

    $scope.crdtlAcctHeadList = [];
    $scope.containerList = [];
    $scope.serviceList = [];
    $scope.blList=[];
    $scope.error="";

    $scope.phcinvoiceObj = {
        PHCInvoiceCode : '',
        accountName : '',
        vessel : '',
        voyage : '',
        pol : '',
        pod : '',
        pot : '',
        blNo : '',
        flag : '',
        customerCode : '',
        customer:'',
        invoiceNo : '',
        invoiceDate : '',
        currencyCode : 'SGD',
        feeType : '',
        exchangeRate : '',
        feeRate : '0',
        noOfBill : '0',
        totalBCFee : '0',
        totalTCFee : '0',
        companyCode : '',
        company : '',
        slotStatus : 'N',
        totalTCAmount : '',
        credittables : []
    };
    $scope.globalaccountName="";
    $scope.globalacctHeadList=[];
    $scope.getDropdownList = function() {
        $http.get($stateParams.tenantid+'/app/containerphcrates/getlocation').success(function(datas) {
            var tempList = [];
            for (var i = 0; i < datas.length; i++) {         
                tempList.push({
                   id: datas[i].location, 
                   text:  datas[i].locationname
               });
            }
            $scope.companyList=tempList;
       }).error(function(data) {
        });  

      }
    
    $scope.getDropdownList();
    $scope.load1=false;
    $scope.viewPhcPendingList = function() {
        $('#saveInvoice').attr('disabled', true);
        //var url='app/PHCInvoice/filterPhcBil?blNo='+ $scope.globalBl+'&flag='+$scope.globalflag+'&bookdtlid='+$scope.globalBdlid;
        var url=$stateParams.tenantid+'/app/phc/getPhcDetailBasedBil?blNo='+ $scope.globalObject.blNo+'&flag='+ $scope.globalObject.flag+'&bookdtlid='+$scope.globalObject.bookdtl+'&slNo='+$scope.globalObject.slNo;
        $http.post(url).success(function(datas) {
                $scope.rowObject = datas.phcInvoice;
                $scope.error=datas.errors[0];
                $scope.phcinvoiceObj.customerCode = $scope.rowObject.mlo;
                $scope.phcinvoiceObj.customer=$scope.rowObject.customerName;
                $scope.phcinvoiceObj.pol = $scope.rowObject.pol;
                $scope.phcinvoiceObj.pod = $scope.rowObject.pod;
                $scope.phcinvoiceObj.pot = $scope.rowObject.pot === "-" ? $scope.rowObject.fpod : $scope.rowObject.pot ;
                $scope.phcinvoiceObj.vessel = $scope.rowObject.vessel;
                $scope.phcinvoiceObj.voyage = $scope.rowObject.voyage;
                $scope.phcinvoiceObj.blNo = $scope.rowObject.blNo;
                $scope.phcinvoiceObj.companyCode = "C0003";
                $scope.phcinvoiceObj.exchangeRate = $scope.rowObject.exchangeRate;
                $scope.phcinvoiceObj.feeType = $scope.rowObject.feeType ;
                $scope.phcinvoiceObj.flag = $scope.rowObject.flag === "0" ? '1' : $scope.rowObject.flag ;
                $scope.phcinvoiceObj.credittables=$scope.rowObject.credittables;
                $scope.phcinvoiceObj.doorOpenTable=$scope.rowObject.doorOpenTable;
                $scope.phcinvoiceObj.shipment=$scope.rowObject.shipment;
                $scope.phcinvoiceObj.noOfBill=$scope.rowObject.noOfBill;
                $scope.phcinvoiceObj.feeRate =$scope.rowObject.feeRate;
                $scope.totContainers=$scope.rowObject.totContainers;
                if($scope.phcinvoiceObj.pod === "PSA"){
                    $scope.phcinvoiceObj.accountName=$scope.rowObject.accountName;
                    $scope.phcinvoiceObj.acctName=$scope.rowObject.acctName;
                }
                $scope.feeCalculation();
                
                $scope.load1=true;
                
                $http.post($stateParams.tenantid+'/app/PHCInvoice/checkSlotStatus', $scope.phcinvoiceObj.blNo).success(function(data) {
                    $scope.phcinvoiceObj.slotStatus =data.status;
                   $('#saveInvoice').attr('disabled', false);
                    $scope.load1=false;
                });

                
                $scope.totalAmountCalculation();
                if($scope.rowObject.credittables.length == 0){
                    $scope.phcinvoiceObj.totalBCFee=0;
                    $scope.phcinvoiceObj.totalTCFee=0;
                    $scope.phcinvoiceObj.totalTCAmount=0;
                    $scope.phcinvoiceObj.totalBCAmount=0;
                }
                
                if($scope.phcinvoiceObj.pol === "PSA" && $scope.phcinvoiceObj.credittables.length == 0){
                    logger.logError("Out Bound details not Uploaded/Exported for this BL !");
                }else if($scope.phcinvoiceObj.pod === "PSA" && $scope.phcinvoiceObj.credittables.length == 0){
                    logger.logError("In Bound details not Uploaded/Exported for this BL !");
                }
                if(datas.message!=null && datas.message!=undefined && datas.message!=''){
                    logger.logError(datas.message);
                }
                
        }).error(function(data) {
        });
    }

    $scope.viewPhcPendingList();

    /**
     * datepicker
     * ******************************************************************************************************
     */
    $('#invoiceDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime : false
    });
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
    $('#invoiceDate').val(today);
    $scope.phcinvoiceObj.invoiceDate = today;
    $scope.allPayer=true;
    $scope.checkAllPayer=false;
 
    
        $scope.getPayerDtlList = function(allPayerChecked) {
            if(allPayerChecked){
                $scope.allPayer = false;
                $scope.phcinvoiceObj.accountName = '';
                $http.post($stateParams.tenantid+'/app/PHCInvoice/getPayerFullList').success(function(datas) {
                    if (datas.length > 0) {
                        $scope.acctHeadList = datas;
                    }
                }).error(function(data) {
                });
            }else{
                $scope.allPayer = true;
                $scope.acctHeadList=$scope.globalacctHeadList;
                $scope.phcinvoiceObj.accountName = $scope.globalaccountName;
            }
        };
    
        $scope.$watch('phcinvoiceObj.companyCode', function(newValue, oldValue) {
        $scope.PHCFilterDate = {
                voyage : $scope.phcinvoiceObj.voyage,
                pol : $scope.phcinvoiceObj.pol,
                pod : $scope.phcinvoiceObj.pod,
                customerCode : $scope.phcinvoiceObj.customerCode,
                blNo : $scope.phcinvoiceObj.blNo,
                company : newValue,
                slNo :$scope.globalObject.slNo
            }
        
            if (newValue != '' && newValue != undefined && $scope.PHCFilterDate.pol == 'PSA') {
                $http.post($stateParams.tenantid+'/app/PHCInvoice/getPayerNewList', $scope.PHCFilterDate).success(function(datas) {
                    if (datas.length > 0) {
                        $scope.phcinvoiceObj.accountName='';
                        $scope.acctHeadList = datas;
                        $scope.phcinvoiceObj.accountName= datas[0].id;
                        $scope.globalaccountName= datas[0].id;
                        $scope.globalacctHeadList= datas;
                    }else{
                        $scope.acctHeadList = [];
                    }
                }).error(function(data) {
                });

            } 
    });
   

    $http.get($stateParams.tenantid+'/app/commonUtility/getPhcContainers').success(function(datas) {
        $scope.containerList = datas.commonUtilityBean;
    }).error(function(data) {
    });

    $scope.crdtlAcctHeadList.push('THC AT SINGAPORE');
    $scope.crdtlAcctHeadList.push('THC AT UMQ');
    $scope.crdtlAcctHeadList.push('THC AT ASSALUYEH');

    $scope.serviceList.push('LOCAL');
    $scope.serviceList.push('TRANSHIPMENT');

    $scope.tcamountCalculation = function(bcamount, index, row) {
        row.bcamount = parseFloat(bcamount);
        if ($scope.phcinvoiceObj.exchangeRate != 0 && $scope.phcinvoiceObj.exchangeRate != "") {
            var tcAmt = (parseFloat(bcamount) * $scope.phcinvoiceObj.exchangeRate).toFixed(2);
            row.tcamount = tcAmt;
            $scope.totalAmountCalculation();
        } else {
            $scope.phcinvoiceObj.exchangeRate = 1.0;
            var tcAmt = (parseFloat(bcamount) * $scope.phcinvoiceObj.exchangeRate).toFixed(2);
            row.tcamount = tcAmt;
            $scope.totalAmountCalculation();
        }

    }

    $scope.feeCalculation = function() {
        var tcamount = $scope.phcinvoiceObj.feeRate * $scope.phcinvoiceObj.noOfBill;
        $scope.phcinvoiceObj.totalTCFee = tcamount;
        if ($scope.phcinvoiceObj.exchangeRate != 0 && $scope.phcinvoiceObj.exchangeRate != "") {
            var bcAmt = (parseFloat(tcamount) / $scope.phcinvoiceObj.exchangeRate).toFixed(2);
            $scope.phcinvoiceObj.totalBCFee = bcAmt;
            $scope.totalAmountCalculation();
        } else {
            $scope.phcinvoiceObj.exchangeRate = 1.0;
            var bcAmt = (parseFloat(tcamount) / $scope.phcinvoiceObj.exchangeRate).toFixed(2);
            $scope.phcinvoiceObj.totalBCFee = bcAmt;
            $scope.totalAmountCalculation();
        }

    }

    /**
     * rate calculation - tc and bc amount will calculated with exchange rate
     */
    $scope.rateCalculation = function(qty, index, row) {
        var tcamount = qty * row.conRate;
        row.tcamount = parseFloat(tcamount);
        if ($scope.phcinvoiceObj.exchangeRate != 0 && $scope.phcinvoiceObj.exchangeRate != "") {
            var bcAmt = (parseFloat(tcamount) / $scope.phcinvoiceObj.exchangeRate).toFixed(2);
            row.bcamount = bcAmt;
            $scope.totalAmountCalculation();
        } else {
            if ($scope.phcinvoiceObj.exchangeRate != "" && $scope.phcinvoiceObj.exchangeRate != null) {
                var bcAmt = (parseFloat(tcamount) / $scope.phcinvoiceObj.exchangeRate).toFixed(2);
                row.bcamount = bcAmt;
                $scope.totalAmountCalculation();
            } else {
                row.bcamount = 0;
            }
        }

    }

    $scope.exchageratePHChdr = function(exchangeRate) {
        if (exchangeRate > 0) {
            $scope.feeCalculation();
            angular.forEach($scope.phcinvoiceObj.credittables, function(phcRow, giIndex) {
                if (isNaN(parseFloat(phcRow.tcamount, 10))) {
                    if (isNaN(parseFloat(phcRow.bcamount, 10))) {
                        var bcAmt = (parseFloat(phcRow.tcamount) / exchangeRate);
                        var tcAmt = (parseFloat(phcRow.bcamount) * exchangeRate);
                        phcRow.tcamount = isNaN(tcAmt) ? 0 : tcAmt.toFixed(2);
                        phcRow.bcamount = isNaN(bcAmt) ? 0 : bcAmt.toFixed(2);
                    } else {
                        var tcAmt = (parseFloat(phcRow.bcamount) * exchangeRate);
                        phcRow.tcamount = isNaN(tcAmt) ? 0 : tcAmt.toFixed(2);
                    }
                } else {
                    var bcAmt = (parseFloat(phcRow.tcamount) / exchangeRate);
                    phcRow.bcamount = isNaN(bcAmt) ? 0 : bcAmt.toFixed(2);
                }
            });
            angular.forEach($scope.phcinvoiceObj.doorOpenTable, function(item, key) {
                if (isNaN(parseFloat(item.tcamount, 10))) {
                    if (isNaN(parseFloat(item.bcamount, 10))) {
                        var bcAmt = (parseFloat(item.tcamount) / exchangeRate);
                        var tcAmt = (parseFloat(item.bcamount) * exchangeRate);
                        item.tcamount = isNaN(tcAmt) ? 0 : tcAmt.toFixed(2);
                        item.bcamount = isNaN(bcAmt) ? 0 : bcAmt.toFixed(2);
                    } else {
                        var tcAmt = (parseFloat(item.bcamount) * exchangeRate);
                        item.tcamount = isNaN(tcAmt) ? 0 : tcAmt.toFixed(2);
                    }
                } else {
                    var bcAmt = (parseFloat(item.tcamount) / exchangeRate);
                    item.bcamount = isNaN(bcAmt) ? 0 : bcAmt.toFixed(2);
                }
                
                
//                bcAmt += parseFloat($scope.phcinvoiceObj.doorOpenTable[key].bcamount);
//                tcAmt += parseFloat($scope.phcinvoiceObj.doorOpenTable[key].tcamount);
//                $scope.phcinvoiceObj.totalBCAmount = bcAmt;
//                $scope.phcinvoiceObj.totalTCAmount = tcAmt;

            });

        } else {
            logger.logError("Please Check Exchange Rate!")
        }
        $scope.totalAmountCalculation();
    }

    $scope.bcamountCalculation = function(tcamount, index, row) {

        row.tcamount = parseFloat(tcamount);
        if ($scope.phcinvoiceObj.exchangeRate != 0 && $scope.phcinvoiceObj.exchangeRate != "") {
            var bcAmt = (parseFloat(tcamount) / $scope.phcinvoiceObj.exchangeRate).toFixed(2);
            row.bcamount = bcAmt;
            $scope.totalAmountCalculation();
        } else {
            $scope.phcinvoiceObj.exchangeRate = 1.0;
            var bcAmt = (parseFloat(tcamount) / $scope.phcinvoiceObj.exchangeRate).toFixed(2);
            row.bcamount = bcAmt;
            $scope.totalAmountCalculation();
        }

    }
    /**
     * load Credit Note Detail Table ******************************************
     */
    /*$scope.loadCrTable = function() {
        var crtable = {};

        crtable = {
            select : '',
            slNo : 1,
            crdtlAccountHead : 'THC AT SINGAPORE',
            service : '',
            conType : '',
            conRate : '',
            noOfCon : '',
            bcamount : '0',
            tcamount : '0',
            attributeList : []

        };

        $scope.phcinvoiceObj.credittables.push(crtable);

    }
    // add Row - detail table
    $scope.addCredRow = function(tables) {
        var len = tables.length;
        var table = {
            select : '',
            slNo : 1,
            crdtlAccountHead : 'THC AT SINGAPORE',
            service : '',
            conType : '',
            conRate : '',
            noOfCon : '',
            bcamount : '0',
            tcamount : '0',
            attributeList : []
        };
        table.slNo = len + 1;
        tables.push(table);
    };
    $scope.loadCrTable();
*/
    // remove Row - detail table
    $scope.removeCredRow = function(table) {
        $scope.tablerow = [];
        angular.forEach(table, function(row, index) {
            var check = row.select;
            if (check == undefined || check == "") {
                $scope.tablerow.push(row);
            } else {
            }
        });
        angular.forEach($scope.tablerow, function(row, index) {
//            row.slNo = index + 1;
            row.select = true;
        });
        
        $scope.phcinvoiceObj.credittables = $scope.tablerow;
        $scope.totalAmountCalculation();
    };

    $scope.removeDoRow = function(table) {
        $scope.tablerow1 = [];
        angular.forEach(table, function(row, index) {
            var check = row.select;
            if (check == undefined || check == "") {
                $scope.tablerow1.push(row);
            } else {
            }
        });
        angular.forEach($scope.tablerow1, function(row, index) {
//            row.slNo = index + 1;
            row.select = true;
        });
        $scope.phcinvoiceObj.doorOpenTable = $scope.tablerow1;
        $scope.totalAmountCalculation();
    };
    
    // Injector
    $scope.isNotExist=true;
    $scope.submit = function() {
        
        if($scope.error === ""){
            if (new validationService().checkFormValidity($scope.phcinvoiceForm)) {
                var totSum = (parseFloat($scope.phcinvoiceObj.totalBCAmount) + parseFloat($scope.phcinvoiceObj.totalTCAmount)).toFixed(2);
                if($scope.phcinvoiceObj.pol === "PSA" && $scope.phcinvoiceObj.credittables.length == 0){
                    logger.logError("Out Bound details not uploaded for this BL no!");
                }else if($scope.phcinvoiceObj.pod === "PSA" && $scope.phcinvoiceObj.credittables.length == 0){
                    logger.logError("In Bound details not uploaded for this BL no!");
                }else if(parseFloat(totSum) == 0){
                    logger.logError("Total amount should not be zero");
                }else if($scope.phcinvoiceObj.accountName == "" || $scope.phcinvoiceObj.accountName == null || $scope.phcinvoiceObj.accountName == undefined){
                    logger.logError("Payer is mandatory!");
                }
                else if($scope.phcinvoiceObj.slotStatus === "N"){
                    logger.logError("Fls Slot Variance for this BL no!");
                }else if ($scope.phcinvoiceObj.slotStatus == 'Y' && $scope.phcinvoiceObj.credittables.length > 0) {
                    var selTotCont=0,selectdList=[];
                    selectdList=$filter('filter')($scope.phcinvoiceObj.credittables,{
                        select : true,
                    },true);
                    if(selectdList.length > 0){
                        angular.forEach(selectdList,function(valu,inde){
                            console.log(valu.noOfCon)
                            selTotCont +=Number(valu.noOfCon);
                        });
                        $scope.save();
                        /*if((selTotCont == $scope.totContainers) || $scope.phcinvoiceObj.pod === "PSA"){
                            $scope.save();
                        }else{
                            logger.logError("Total Container for this BL no is "+$scope.totContainers+" ,but selected no of Container is "+selTotCont);
                        }*/
                    }else{
                        logger.logError("Select Container Details");
                    }
                } 

            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.phcinvoiceForm.$validationSummary), 5000, 'trustedHtml');
            }
        }else{
            logger.logError($scope.error);
        }
        
    };

    
    $scope.save = function() {
            var myURL = $stateParams.tenantid+'/app/PHCInvoice/saveTEMP';
            var PHCInvoiceNewBean = $scope.phcinvoiceObj;
            $http({
                url : myURL,
                data : PHCInvoiceNewBean,
                method : 'post',
                dataType : 'json',
                headers : {
                    'Accept' : 'application/json',
                    'Content-Type' : 'application/json'
                }
            }).success(function(result) {
                if (result.success) {
                    logger.logSuccess("Saved successfully!");
                    if(result.message!=null && result.message!= undefined && result.message!=''){
                        logger.logSuccess(result.message);
                    }
                    $state.go("app.finance.invoice.PHCInvoicenew.search");
                    var phcInvoiceNo = result.lPHCInvoiceBean[0].phcinvoiceCode;
                    $timeout(function() {
                        $scope.printPHCInvoice(phcInvoiceNo, 'both', 0);
                    }, 1000);

                } else {
                    logger.logError("Invoice not saved. Please check whether the payer has been invoiced already against this BL no!");
                }
            }).error(function(result) {
                console.log("data" + result);
            });
       };

    $scope.printPHCInvoice = function(phcInvoiceNo, selection, index) {
        //var url = 'app/PHCInvoice/printtemp?phcInvoiceNo=' + phcInvoiceNo + '&selectedPrintOption=' + selection; 
        var url = $stateParams.tenantid+'/app/PHCInvoice/print?phcInvoiceNo=' + phcInvoiceNo + '&selectedPrintOption=' + selection;
        var wnd = window.open(url, 'Shipping', 'height=400,width=750,top=100,left=100,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
        wnd.print();
    }
    /**
     * total Amount Calculation - calculate from credit note detail table..
     */
    $scope.totalAmountCalculation = function() {
        var crDtlRowDatas = $scope.phcinvoiceObj.credittables;
        var bcAmt = 0, tcAmt = 0;
        $scope.phcinvoiceObj.totalBCAmount=0;
        $scope.phcinvoiceObj.totalTCAmount=0;
        angular.forEach(crDtlRowDatas, function(item, key) {
            bcAmt += parseFloat(crDtlRowDatas[key].bcamount);
            tcAmt += parseFloat(crDtlRowDatas[key].tcamount);
            $scope.phcinvoiceObj.totalBCAmount = bcAmt;
            $scope.phcinvoiceObj.totalTCAmount = tcAmt;

        });
        angular.forEach($scope.phcinvoiceObj.doorOpenTable, function(item, key) {
            bcAmt += parseFloat($scope.phcinvoiceObj.doorOpenTable[key].bcamount);
            tcAmt += parseFloat($scope.phcinvoiceObj.doorOpenTable[key].tcamount);
            $scope.phcinvoiceObj.totalBCAmount = bcAmt;
            $scope.phcinvoiceObj.totalTCAmount = tcAmt;

        });
        
        $scope.phcinvoiceObj.totalBCAmount = (parseFloat($scope.phcinvoiceObj.totalBCAmount) + parseFloat($scope.phcinvoiceObj.totalBCFee)).toFixed(2);
        $scope.phcinvoiceObj.totalTCAmount = (parseFloat($scope.phcinvoiceObj.totalTCAmount) + parseFloat($scope.phcinvoiceObj.totalTCFee)).toFixed(2);
    }

    $scope.cancelTopendingList = function() {
        $state.go('app.finance.invoice.PHCInvoicenew.search',{tenantid:$stateParams.tenantid});
    };
    
    $scope.tcAmountCalculation=function(selectedRow,index){
        if(selectedRow && $scope.phcinvoiceObj.credittables[index].conRate){
            $scope.phcinvoiceObj.totalBCAmount =parseFloat($scope.phcinvoiceObj.totalBCAmount) + parseFloat($scope.phcinvoiceObj.credittables[index].bcamount);
            $scope.phcinvoiceObj.totalTCAmount =parseFloat($scope.phcinvoiceObj.totalTCAmount) + parseFloat($scope.phcinvoiceObj.credittables[index].tcamount);
            
//            $scope.phcinvoiceObj.totalBCAmount = (parseFloat($scope.phcinvoiceObj.totalBCAmount) + parseFloat($scope.phcinvoiceObj.totalBCFee)).toFixed(2);
//            $scope.phcinvoiceObj.totalTCAmount = (parseFloat($scope.phcinvoiceObj.totalTCAmount) + parseFloat($scope.phcinvoiceObj.totalTCFee)).toFixed(2);
        }else if(!selectedRow && $scope.phcinvoiceObj.credittables[index].conRate > 0){
            $scope.phcinvoiceObj.totalBCAmount =parseFloat($scope.phcinvoiceObj.totalBCAmount) - parseFloat($scope.phcinvoiceObj.credittables[index].bcamount);
            $scope.phcinvoiceObj.totalTCAmount =parseFloat($scope.phcinvoiceObj.totalTCAmount) - parseFloat($scope.phcinvoiceObj.credittables[index].tcamount);
            
//            $scope.phcinvoiceObj.totalBCAmount = (parseFloat($scope.phcinvoiceObj.totalBCAmount) + parseFloat($scope.phcinvoiceObj.totalBCFee)).toFixed(2);
//            $scope.phcinvoiceObj.totalTCAmount = (parseFloat($scope.phcinvoiceObj.totalTCAmount) + parseFloat($scope.phcinvoiceObj.totalTCFee)).toFixed(2);
        }
      }
    
    $scope.tcAmountCalculationDO=function(selectedRow,index){
        if(selectedRow && $scope.phcinvoiceObj.doorOpenTable[index].conRate){
            $scope.phcinvoiceObj.totalBCAmount =parseFloat($scope.phcinvoiceObj.totalBCAmount) + parseFloat($scope.phcinvoiceObj.doorOpenTable[index].bcamount);
            $scope.phcinvoiceObj.totalTCAmount =parseFloat($scope.phcinvoiceObj.totalTCAmount) + parseFloat($scope.phcinvoiceObj.doorOpenTable[index].tcamount);
            
//            $scope.phcinvoiceObj.totalBCAmount = (parseFloat($scope.phcinvoiceObj.totalBCAmount) + parseFloat($scope.phcinvoiceObj.totalBCFee)).toFixed(2);
//            $scope.phcinvoiceObj.totalTCAmount = (parseFloat($scope.phcinvoiceObj.totalTCAmount) + parseFloat($scope.phcinvoiceObj.totalTCFee)).toFixed(2);
        }else if(!selectedRow && $scope.phcinvoiceObj.doorOpenTable[index].conRate > 0){
            $scope.phcinvoiceObj.totalBCAmount =parseFloat($scope.phcinvoiceObj.totalBCAmount) - parseFloat($scope.phcinvoiceObj.doorOpenTable[index].bcamount);
            $scope.phcinvoiceObj.totalTCAmount =parseFloat($scope.phcinvoiceObj.totalTCAmount) - parseFloat($scope.phcinvoiceObj.doorOpenTable[index].tcamount);
            
//            $scope.phcinvoiceObj.totalBCAmount = (parseFloat($scope.phcinvoiceObj.totalBCAmount) + parseFloat($scope.phcinvoiceObj.totalBCFee)).toFixed(2);
//            $scope.phcinvoiceObj.totalTCAmount = (parseFloat($scope.phcinvoiceObj.totalTCAmount) + parseFloat($scope.phcinvoiceObj.totalTCFee)).toFixed(2);
        }
      }
   
});
app.controller('tablePhcCalcCtrl', function($scope, $http, $filter, logger,$stateParams) {
    $scope.phcTable = false;
    
    $scope.$watch('phcinvoiceObj.credittables[trIndex].service', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined && !$scope.load1) {
            var container = $scope.phcinvoiceObj.credittables[$scope.$index].conType;
            var service = $scope.phcinvoiceObj.credittables[$scope.$index].service;
            var pol = $scope.phcinvoiceObj.pol;
            var pod = $scope.phcinvoiceObj.pod;
            
            $scope.PHCFilterDate = {
                conType : container,
                pol : pol,
                pod : pod,
                service : service
            }
            $http.post($stateParams.tenantid+'/app/PHCInvoice/getPHCRate', $scope.PHCFilterDate).success(function(datas) {
                if (datas.sucess) {
                    $scope.phcinvoiceObj.credittables[$scope.$index].conRate = datas.conRate;
                    var tcamt = $scope.phcinvoiceObj.credittables[$scope.$index].noOfCon * datas.conRate;
                    $scope.phcinvoiceObj.credittables[$scope.$index].tcamount=tcamt;
                    var bcAmt = (parseFloat(tcamt) / $scope.phcinvoiceObj.exchangeRate).toFixed(2);
                    $scope.phcinvoiceObj.credittables[$scope.$index].bcamount=bcAmt;
                    $scope.totalAmtCalculation();
                }
            }).error(function(data) {
            });

        }
    });
    
    /**
     * total Amount Calculation - calculate from credit note detail table..
     */
    $scope.totalAmtCalculation = function() {
        var crDtlRowDatas = $scope.phcinvoiceObj.credittables;
        var bcAmt = 0, tcAmt = 0;
        angular.forEach(crDtlRowDatas, function(item, key) {
            bcAmt += parseFloat(crDtlRowDatas[key].bcamount);
            tcAmt += parseFloat(crDtlRowDatas[key].tcamount);
            $scope.phcinvoiceObj.totalBCAmount = bcAmt;
            $scope.phcinvoiceObj.totalTCAmount = tcAmt;

        });
        
        angular.forEach($scope.phcinvoiceObj.doorOpenTable, function(item, key) {
            bcAmt += parseFloat($scope.phcinvoiceObj.doorOpenTable[key].bcamount);
            tcAmt += parseFloat($scope.phcinvoiceObj.doorOpenTable[key].tcamount);
            $scope.phcinvoiceObj.totalBCAmount = bcAmt;
            $scope.phcinvoiceObj.totalTCAmount = tcAmt;

        });

        $scope.phcinvoiceObj.totalBCAmount = (parseFloat($scope.phcinvoiceObj.totalBCAmount) + parseFloat($scope.phcinvoiceObj.totalBCFee)).toFixed(2);
        $scope.phcinvoiceObj.totalTCAmount = (parseFloat($scope.phcinvoiceObj.totalTCAmount) + parseFloat($scope.phcinvoiceObj.totalTCFee)).toFixed(2);
    }

    
});

app.controller('phcInvoicetempViewCtrl', function($scope, $filter, $window, $rootScope, $location, $http, logger, $log, ngDialog, $modal, utilsService, sharedProperties, $state, $injector, ListService, $stateParams, validationService, toaster, $timeout) {

    $scope.phcTable = false;
    
    var phcinvoiceNo = $stateParams.phcinvoiceNo;

    if (phcinvoiceNo == undefined || phcinvoiceNo == null || phcinvoiceNo == "") {

    } else {
        var locationurl = $location.url();
        if (locationurl.indexOf("tempview") > -1) {
            $scope.isView = true;
        }
    }

    if ($scope.isView) {
        $http.post($stateParams.tenantid+'/app/PHCInvoice/getPHCInvoiceforView?phcinvoiceNo=' + phcinvoiceNo).success(function(data) {
            $scope.creditnoteAcctData = data;
            $scope.creditnoteAcctData.totalBCAmount = data.totalbc;
            $scope.creditnoteAcctData.totalTCAmount = data.totaltc;
        }).error(function(data) {
        });
    }

    $scope.printPHCInvoice = function(phcInvoiceNo, selection, index) {
        $timeout(function() {
            var url = $stateParams.tenantid+'/app/PHCInvoice/print?phcInvoiceNo=' + phcInvoiceNo + '&selectedPrintOption=' + selection;
            var wnd = window.open(url, 'Shipping', 'height=600,width=800,top=100,left=100,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
            wnd.print();
        }, 500);
    }

    $scope.rateCalculation = function(rowObj) {
        
        angular.forEach(rowObj, function(row, index) {
            
            var bcamount = parseInt(row.noOfCon) * parseFloat(row.conRate);
            row.bcamount = parseFloat(bcamount);
            if ($scope.creditnoteAcctData.exchangeRate != 0 && $scope.creditnoteAcctData.exchangeRate != "") {
                var tcAmt = (parseFloat(bcamount) * $scope.creditnoteAcctData.exchangeRate).toFixed(2);
                row.tcamount = tcAmt;

            } else {
                $scope.creditnoteAcctData.exchangeRate = 1.0;
                var tcAmt = (parseFloat(bcamount) * $scope.creditnoteAcctData.exchangeRate).toFixed(2);
                row.tcamount = tcAmt;

            }
        })
        /**/

    }

    $scope.feeCalculation = function() {
        var bcamount = $scope.creditnoteAcctData.feeRate * $scope.creditnoteAcctData.noOfBill;
        $scope.creditnoteAcctData.totalBCFee = bcamount;
        console.log("Fee" + $scope.creditnoteAcctData.totalBCFee);
        if ($scope.creditnoteAcctData.exchangeRate != 0 && $scope.creditnoteAcctData.exchangeRate != "") {
            var tcAmt = (parseFloat(bcamount) * $scope.creditnoteAcctData.exchangeRate).toFixed(2);
            $scope.creditnoteAcctData.totalTCFee = tcAmt;
            $scope.totalAmountCalculation();
        } else {
            $scope.creditnoteAcctData.exchangeRate = 1.0;
            var tcAmt = (parseFloat(bcamount) * $scope.creditnoteAcctData.exchangeRate).toFixed(2);
            $scope.creditnoteAcctData.totalTCFee = tcAmt;
            $scope.totalAmountCalculation();
        }

    }

    $scope.totalAmountCalculation = function() {
        var crDtlRowDatas = $scope.creditnoteAcctData.credittables;
        var bcAmt = 0, tcAmt = 0;
        angular.forEach(crDtlRowDatas, function(item, key) {
            bcAmt += parseFloat(crDtlRowDatas[key].bcamount);
            tcAmt += parseFloat(crDtlRowDatas[key].tcamount);
            $scope.creditnoteAcctData.totalBCAmount = bcAmt;
            $scope.creditnoteAcctData.totalTCAmount = tcAmt;

        });
        
        angular.forEach($scope.creditnoteAcctData.doorOpenTable, function(item, key) {
            bcAmt += parseFloat($scope.creditnoteAcctData.doorOpenTable[key].bcamount);
            tcAmt += parseFloat($scope.creditnoteAcctData.doorOpenTable[key].tcamount);
            $scope.creditnoteAcctData.totalBCAmount = bcAmt;
            $scope.creditnoteAcctData.totalTCAmount = tcAmt;

        });        

        $scope.creditnoteAcctData.totalBCAmount = (parseFloat($scope.creditnoteAcctData.totalBCAmount) + parseFloat($scope.creditnoteAcctData.totalBCFee));
        $scope.creditnoteAcctData.totalTCAmount = (parseFloat($scope.creditnoteAcctData.totalTCAmount) + parseFloat($scope.creditnoteAcctData.totalTCFee));
    }

    /**
     * cancel
     */
    $scope.cancel = function() {
        $state.go("app.finance.invoice.PHCInvoicenew.search",{tenantid:$stateParams.tenantid});
    };

});
