
app.controller('soaCustomerCtrl', function($scope, $rootScope, 
            $http, logger, $log, ngDialog, $modal, $window,$location,$filter,$stateParams) {

    $scope.objSoa={
            company :'',
            mlo : '',
            fromDate :'',
            toDate :'',
            payerCode:'',
            mloCode : ''
    }
    $scope.getList = function(){
        var url = $stateParams.tenantid+"/app/receivable/soaCustomerList"
            $http.get(url).success(function(data){
                console.log(data)
                if (data.success == true){
                    $scope.customerList = data.soaCustomerList[0];
                    $scope.mloList = data.soaCustomerList[1];
                    $('#company_select').selectivity({
                        allowClear: true,
                        items:data.soaCustomerList[0],
                        placeholder: ''
                    }); 
                    $('#mlo_select').selectivity({
                        allowClear: true,
                        items:data.soaCustomerList[1],
                        placeholder: ''
                    }); 
                } 
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
            
    };
    $scope.getList();
    
    
    
    $('#company_select').on('selectivity-selected',function(obj){
        $scope.objSoa.company= obj.item.id;
    });
    $('#mlo_select').on('selectivity-selected',function(obj){
        $scope.objSoa.mlo= obj.item.id;
    });
    
    $scope.datepicker = function() {
                $scope.disabled = function(date, mode) {
                    return (mode === 'day' && (date.getDay() === 0 || date.getDay() === 6));
                };
    
                $scope.dattaxdata.colorseOptions = {
                    formatYear : 'yy',
                    startingDay : 1
                };
    
                $scope.formats = [ 'dd-MM-yyyy' ];
                $scope.format = $scope.formats[0];
            }
    
            $scope.opentime = function($event,value) {
                $event.preventDefault();
                $event.stopPropagation();
    
                $scope[value] = true;
            };
       $scope.reset = function(){
           $('.fa-remove').click();
           $scope.objSoa={company :'',mlo : '',fromDate :'',toDate :''};
       }     
     
       $scope.exportData =function(obj){
           var msg="";
           var warningStatus=false;
               if(obj.company == ''){
                   msg="<li>Company !.</li>";
                   warningStatus=true;
               }
               if(obj.mlo == ''){
                   msg+="<li>Mlo !.</li>";
                   warningStatus=true;
               }
               if(obj.fromDate == ''){
                   msg+="<li>From Date !.</li>";
                   warningStatus=true;
               }
               if(obj.toDate == '') {
                   msg+="<li>To Date !</li>";
                   warningStatus=true;
               }
                 //Save Method
               if(warningStatus){
                 "</ul>"
                 logger.logError("\n"+msg);
                 s1="";
                 warningStatus=false;
               }
        else{
           var url = $stateParams.tenantid+'/app/receivable/excelExport';
           $http({
               url:url,
               method: "post",
               data: obj
               }).success(function(data) {
               $("#tbPdfExport").bind('click', function () {
                   //  alert('clicked');
                     
                  });
                 $('#tbPdfExport').simulateClick('click');
           });
       }
       $.fn.simulateClick = function() {
           return this.each(function() {
       if('createEvent' in document) {
           var doc = this.ownerDocument,
               evt = doc.createEvent('MouseEvents');
           evt.initMouseEvent('click', true, true, doc.defaultView, 1, 0, 0, 0, 0, false, false, false, false, 0, null);
           this.dispatchEvent(evt);
       } else {
           this.click(); // IE
       }
       });
       }
      }
       var s1="";
       $scope.getProfitLossGrid = function(profitandLosssearch,profitLossData) {
           $scope.submitted=true;
           "<ul>"
             if(profitandLosssearch.company.$invalid){
               s1="<li>Company !.</li>"; 
              
           } if(profitandLosssearch.validfromDate.$invalid){
               s1+="<li>From Date!.</li>";
              
           } if(profitandLosssearch.validtoDate.$invalid ){
               s1+="<li>To Date!</li>";
           } if(profitandLosssearch.$invalid){
               //Save Method
               "</ul>"
               logger.logError("\n"+s1);
               s1="";
           }else if(profitandLosssearch.$valid){
               //Save Method
               $location.path($stateParams.tenantid+"/reports/finance/profitandlossSearch/profitLossReport");
               $scope.viewProfitAndlossAccount(profitLossData);
           }
       };
       
 });





app.controller('soaCustomerController', function($scope, $rootScope, 
            $http, logger, $log, ngDialog, $modal, $window,$location,$filter, $timeout,validationService,toaster,$stateParams) {
    $scope.soa={
            companyCode :'',
            payerCode : '',
            filterPayerCode:'',
            fromDate :'',
            toDate :'',
            paymentCode:'',
            isInvoiceAmount:false,
            bulkInvoice:[],
            isCustomer : '',
            customerCode : '',
            mode : '',
            
    }
    
    $scope.modeList=[{
        id : '1',
        text : 'Sea'
    }, {
        id : '2',
        text : 'Air'
    }, {
        id : '3',
        text : 'All'
    }];
    
    $('#soaFromDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime: false
    });
    $('#soaToDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime: false
    });
    
    $scope.isConsolidated =false;
   
    
    
    $scope.getList = function(){

        $scope.CategoryList =[];
//        var data ={
//                'id':'paymentCentre',
//                'text':'Payment centre wise'
//        };
//        
//        $scope.CategoryList.push(data);
        var data1 ={
                'id':'company',
                'text':'Company Wise'
        };
       
        $scope.CategoryList.push(data1);
       
        debugger;
        console.log("soa " + $('#form_code_id').val())
        $http.get($stateParams.tenantid+'/app/usermaster/getCompanyList?formCode='+$('#form_code_id').val()).success(function(data) {
            $scope.companyList = data;
            console.log($scope.companyList);
            var foundItemDest = $filter('filter')($scope.companyList, { baseCompany:  1 })[0];
            $scope.soa.companyCode=foundItemDest.id;

        }).error(function(data) {
        });
        
        $http.get($stateParams.tenantid+'/app/receivable/getPaymentCentreList').success(function(data) {
            $scope.paymentList = data;
        }).error(function(data) {
        });
        
//        $http.get($stateParams.tenantid+'/app/commonUtility/getSubAccountCodeListTradeDebtorsCR').success(function(datas) {
//            $scope.payerList = [];
//            $scope.payerList = datas;
//            }).error(function(datas) {
//        }); 
        
        $http.get($stateParams.tenantid+'/app/corgCustomerWise/getCustomerList').success(function(datas) {
            $scope.customerList = datas.mloList;
            }).error(function(datas) {
        }); 
    
    };
    
    $scope.getList();
    
    $scope.$watch('soa.customerCode', function(newValue, oldValue) {
//        if (newValue != '' && newValue != undefined) {
//            $scope.payerList = [];
//            $http.post($stateParams.tenantid+'/app/corgCustomerWise/getPayerForCustomer', newValue).success(function(datas) {
//                $scope.payerList = datas.payerList;
//                }).error(function(datas) {
//            });
//        }else{
//            $http.get($stateParams.tenantid+'/app/commonUtility/getSubAccountCodeListTradeDebtorsCR').success(function(datas) {
//                $scope.payerList = [];
//                $scope.payerList = datas;
//                }).error(function(datas) {
//            }); 
   //     }
    });
    
    $scope.categoryType ='company';
    $scope.isPayementCentre =false; 
    $scope.isPayerselected=false;
    $scope.$watch('categoryType', function(newValue, oldValue) {
        debugger;
        if(newValue.id =='paymentCentre'){
           $scope.soa.companyCode = '';
           $scope.isPayementCentre =true; 
        }if(newValue.id =='company'){
            $scope.soa.paymentCode = '';
            $scope.isPayementCentre =false; 
         }
    });
    
    
    $scope.objsoa={
            payerCode:$scope.soa.payerCode,
            invoiceType:'',
            bulkInvoice:[],
            invoices:''
    }
    
    $scope.invoiceTypeList =[];
    
    var data4 ={
            'id':'Sel',
            'text':'Select'
    };
    
    $scope.invoiceTypeList.push(data4);
    
    var data ={
            'id':'GI',
            'text':'General Invoice'
    };
    
    $scope.invoiceTypeList.push(data);
    
    var data1 ={
            'id':'SI',
            'text':'Freight Invoice'
    };
    $scope.invoiceTypeList.push(data1);
    
    var data2 ={
            'id':'PHC',
            'text':'PHC Invoice'
    };

    $scope.invoiceTypeList.push(data2);
    
    var data3 ={
            'id':'CN',
            'text':'Credit Note'
    };

    $scope.invoiceTypeList.push(data3);
    
    var data4 ={
            'id':'DN',
            'text':'Debit Note'
    };

    $scope.invoiceTypeList.push(data4);
    
    $scope.$watch('objsoa.invoiceType', function(newValue, oldValue) {
        $scope.invoiceList=[];
        if(newValue == 'GI')
        {
            angular.forEach($scope.outStandingList, function (row,index) {
                debugger;
                if(row.transactionNo.indexOf(newValue) > -1)
                {
                    var obj={
                            'id':row.transactionNo,
                            'text':row.transactionNo
                    }
                    $scope.invoiceList.push(obj);
                }
            });
            console.log($scope.invoiceList);
        }
        else if(newValue == 'SI')
        {
            angular.forEach($scope.outStandingList, function (row,index) {
                debugger;
                if(row.transactionNo.indexOf('IN') > -1)
                {
                    var obj={
                            'id':row.transactionNo,
                            'text':row.transactionNo
                    }
                    $scope.invoiceList.push(obj);
                }
            });
            console.log($scope.invoiceList);
        }
        else if(newValue == 'PHC')
        {
            angular.forEach($scope.outStandingList, function (row,index) {
                debugger;
                if(row.transactionNo.indexOf(newValue) > -1)
                {
                    var obj={
                            'id':row.transactionNo,
                            'text':row.transactionNo
                    }
                    $scope.invoiceList.push(obj);
                }
            });
            console.log($scope.invoiceList);
        }
        else if(newValue == 'CN')
        {
            angular.forEach($scope.outStandingList, function (row,index) {
                debugger;
                if(row.transactionNo.indexOf(newValue) > -1)
                {
                    var obj={
                            'id':row.transactionNo,
                            'text':row.transactionNo
                    }
                    $scope.invoiceList.push(obj);
                }
            });
            console.log($scope.invoiceList);
        }
        else if(newValue == 'DN')
        {
            angular.forEach($scope.outStandingList, function (row,index) {
                debugger;
                if(row.transactionNo.indexOf(newValue) > -1)
                {
                    var obj={
                            'id':row.transactionNo,
                            'text':row.transactionNo
                    }
                    $scope.invoiceList.push(obj);
                }
            });
            console.log($scope.invoiceList);
        }
        
        
        $timeout(function() { 
            
            $("#txtInvoice").multiselect({
                maxHeight: 400,
                includeSelectAllOption: true,
                selectAllText: 'Select All',
                enableFiltering: true,
                enableCaseInsensitiveFiltering: true,
                filterPlaceholder: 'Search',
                onChange: function(element, checked) {
                    debugger;
                 
                  
                }
              });
            
            $("#multiselect-button").addClass("width_75 input-sm line-height-5");
            
            
            
            }, 2, false);
        
        $timeout(function() {
            $('#txtInvoice').multiselect('deselectAll', false);
            $('#txtInvoice').multiselect('updateButtonText');
            $("#txtInvoice").multiselect('rebuild');
        
        }, 2, false);
       
    });
    
    $scope.isBulkMail=false;
    $scope.ViewBulkMailDiv=function(trialBalanceForm){
        $scope.objsoa.invoiceType='Sel';
        if (new validationService().checkFormValidity(trialBalanceForm)) {
                if($scope.soa.customerCode != ''){
                    if(!$scope.isBulkMail){
                        $scope.viewsoaConsolidated();
                        $scope.isBulkMail=true;
                        $scope.isPayerselected=true;
                        $scope.invoiceList=[];

                        $timeout(function() { 
                            
                            $("#txtInvoice").multiselect({
                                maxHeight: 400,
                                includeSelectAllOption: true,
                                selectAllText: 'Select All',
                                enableFiltering: true,
                                enableCaseInsensitiveFiltering: true,
                                filterPlaceholder: 'Search',
                               
                              });
                            
                            $("#multiselect-button").addClass("width_75 input-sm line-height-5");
                            
                            
                            
                            }, 2, false);
                            
                    }
                    else{
                        $scope.isBulkMail=false;
                    }
                }else{
                    $scope.soa.payerCode = '';
                    logger.logError("Please select Customer!..");
                }
            
        }else {
            toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(trialBalanceForm.$validationSummary), 555000, 'trustedHtml');
        }
    }

    $scope.bulkPrint=function(){
        
        var invoice = "";
        if($scope.objsoa.bulkInvoice.length>0){
            var invoice = '';
            angular.forEach($scope.objsoa.bulkInvoice, function (item, key) {
                debugger;
                if($scope.objsoa.bulkInvoice.length>0){
                    debugger;
                    if($scope.objsoa.bulkInvoice[key]!=undefined){
                        if(invoice==""){
                            invoice = item.id;
                        }else{
                            invoice +=","+ item.id;
                        }       
                        $scope.objsoa.invoices = invoice;
                    }                             
                }                              
            });
            debugger;
            console.log($scope.objsoa);
        }else{
            $scope.objsoa.invoices = '';
        }
        
        if($scope.objsoa.invoiceType=='PHC'){
            var url = $stateParams.tenantid+'/app/PHCInvoice/bulkPrint?phcInvoiceNos='+$scope.objsoa.invoices;
            var wnd = window.open(url, 'Shipping', 'height=400,width=750,top=100,left=100,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
            wnd.print();    
        }else if($scope.objsoa.invoiceType=='SI'){
            var url = $stateParams.tenantid+'/app/customerinvoice/print?invoiceNo=' + $scope.objsoa.invoices + '&selectedDropDown=both';  ///app/invoice/bulkPrint
            var wnd = window.open(url, 'Shipping', 'height=400,width=750,top=100,left=100,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
            wnd.print();
        }else if($scope.objsoa.invoiceType=='GI'){
            var url = $stateParams.tenantid+'/app/generalinvoice/bulkPrint?invoiceNos='+$scope.objsoa.invoices;
            var wnd = window.open(url, 'Shipping', 'height=400,width=750,top=100,left=100,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
            wnd.print();
        }else if($scope.objsoa.invoiceType=='CN'){
            var url = $stateParams.tenantid+'/app/creditNote/bulkPrint?creditNoteCodes='+$scope.objsoa.invoices;
            var wnd = window.open(url, 'Shipping', 'height=400,width=750,top=100,left=100,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
            wnd.print();
        }else if($scope.objsoa.invoiceType=='DN'){
            var url = $stateParams.tenantid+'/app/debitnote/bulkPrint?creditNoteCodes='+$scope.objsoa.invoices;
            var wnd = window.open(url, 'Shipping', 'height=400,width=750,top=100,left=100,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
            wnd.print();
        }
        
    }
    
    $scope.sendSOA=function(trialBalanceForm){
    	debugger;
        if (new validationService().checkFormValidity(trialBalanceForm)) {
        	
        	if($scope.soa.mode!=''){
            if($scope.soa.customerCode != ''){
                $http.post($stateParams.tenantid+'/app/receivable/sendSOA', $scope.soa).success(function(data) {
                    if(data.success){
                        logger.logSuccess("Mail sent successfully!");
                    }else{
                        logger.logError("Mail not Sent"); 
                    }
                        
                }).error(function(data) {
                    logger.logError("Error Please Try Again");
                });
            }else{
                logger.logError("Please select Customer!..");
            }
            }else{
            	logger.logError("Please select the Mode");
            }
        }else {
            toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(trialBalanceForm.$validationSummary), 555000, 'trustedHtml');
        }
    };
    
    $scope.sendBulkMail =function(){
        debugger;
        $scope.soa.bulkInvoice=[];
        var ids = jQuery("#soaConsolidatedGrid").jqGrid('getGridParam', 'selarrrow');
//        for (var i = 0; i < ids.length; i++) 
//        {
//            debugger;
//            var rowId = ids[i];
//            var rowData = jQuery('#soaConsolidatedGrid').jqGrid ('getRowData', rowId);
//            var data = {};
//            data["id"] = rowData.transactionNo;
//            data["text"] = rowData.transactionNo;
//            $scope.soa.bulkInvoice.push(data)
//        }
        console.log($scope.soa);
        
       $http.post($stateParams.tenantid+'/app/receivable/bulkMail2', $scope.soa).success(function(data) {
            if(data.success){
                logger.logSuccess("Mail sent successfully!");
            }else{
                logger.logError("Mail not Sent"); 
            }
                
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
    }
    
    $scope.viewsoaCustomerReport = function(trialBalanceForm){
        debugger;
        $scope.soa.fromDate =  $scope.returnEmptyForUndefined($("#txtFromDate").val());
        $scope.soa.toDate =   $scope.returnEmptyForUndefined($("#txtToDate").val());
        $scope.isConsolidated =false;
        if($scope.soa.mode!=''){
        if (new validationService().checkFormValidity(trialBalanceForm)) {
            $http.post($stateParams.tenantid+'/app/receivable/getSOACustomerReport', $scope.soa).success(function(data) {
                if(data.success){
                    debugger;
                    $("#soaCustomerGrid").jqGrid('clearGridData'); 
                    $scope.populateSubLedgerGrid(data.lCustomerReportList);
                }else{
                    
                }
                
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        }else {
            toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(trialBalanceForm.$validationSummary), 555000, 'trustedHtml');
        }
        }else{
        	logger.logError("Please select the Mode");
        }
    };
    
    $scope.viewsoaConsolidated = function(){
        debugger;
        $scope.soa.fromDate =  $scope.returnEmptyForUndefined($("#txtFromDate").val());
        $scope.soa.toDate =   $scope.returnEmptyForUndefined($("#txtToDate").val());
        if($scope.soa.isInvoiceAmount){
            if(!$scope.isPayementCentre){
                $scope.isConsolidated =true;
                if($scope.soa.mode!=''){
                if( $scope.soa.companyCode !=''){
                    $http.post($stateParams.tenantid+'/app/receivable/getSOAConsolidatedReport', $scope.soa).success(function(data) {
                        if(data.success){
                            debugger;
                            console.log(data.lCustomerDtlReportList);
                            $scope.outStandingList = data.lCustomerDtlReportList;
                            $("#soaConsolidatedGridinv").jqGrid('clearGridData'); 
                            $scope.populatesoaConsolidatedGridInv(data.lCustomerDtlReportList);
                        }else{
                            
                        }
                        
                    }).error(function(data) {
                        logger.logError("Error Please Try Again");
                    });
                }else{
                        logger.logError("Please select Company");
                }
                } else{
                	logger.logError("Please select the Mode");
                }
            }else{
                $scope.isConsolidated =true;
                if( $scope.soa.paymentCode !=''){
                    $http.post($stateParams.tenantid+'/app/receivable/getSOAConsolidatedReportPaymentCentre', $scope.soa).success(function(data) {
                        if(data.success){
                            debugger;
                            console.log(data.lCustomerDtlReportList);
                            $("#soaConsolidatedGridinv").jqGrid('clearGridData'); 
                            $scope.populatesoaConsolidatedGridInv(data.lCustomerDtlReportList);
                        }else{
                            
                        }
                        
                    }).error(function(data) {
                        logger.logError("Error Please Try Again");
                    });
                }else{
                        logger.logError("Please select Payment centre");
                }
            }
        }else{
            if(!$scope.isPayementCentre){
                $scope.isConsolidated =true;
                if($scope.soa.mode!=''){
                if( $scope.soa.companyCode !=''){
                    $http.post($stateParams.tenantid+'/app/receivable/getSOAConsolidatedReport', $scope.soa).success(function(data) {
                        if(data.success){
                            debugger;
                            console.log("data.lCustomerDtlReportList***********");
                            console.log(data.lCustomerDtlReportList);
                            $scope.outStandingList = data.lCustomerDtlReportList;
                            $("#soaConsolidatedGrid").jqGrid('clearGridData'); 
                            $scope.populatesoaConsolidatedGrid(data.lCustomerDtlReportList);
                        }else{
                            
                        }
                        
                    }).error(function(data) {
                        logger.logError("Error Please Try Again");
                    });
                }else{
                        logger.logError("Please select Company");
                }
                } else {
                	logger.logError("Please select the Mode");
                }
            }else{
                $scope.isConsolidated =true;
                if( $scope.soa.paymentCode !=''){
                    $http.post($stateParams.tenantid+'/app/receivable/getSOAConsolidatedReportPaymentCentre', $scope.soa).success(function(data) {
                        if(data.success){
                            debugger;
                            console.log(data.lCustomerDtlReportList);
                            $("#soaConsolidatedGrid").jqGrid('clearGridData'); 
                            $scope.populatesoaConsolidatedGrid(data.lCustomerDtlReportList);
                        }else{
                            
                        }
                        
                    }).error(function(data) {
                        logger.logError("Error Please Try Again");
                    });
                }else{
                        logger.logError("Please select Payment centre");
                }
            }
        }
        
        
    };

    $scope.exportsoaCustomerExcel = function(trialBalanceForm){
        debugger;
        $scope.soa.fromDate =  $scope.returnEmptyForUndefined($("#txtFromDate").val());
        $scope.soa.toDate =   $scope.returnEmptyForUndefined($("#txtToDate").val());
        if($scope.soa.mode!=''){
        if (new validationService().checkFormValidity(trialBalanceForm)) {
            $http.post($stateParams.tenantid+'/app/receivable/exportSOACustomerReport',$scope.soa).success(function(data) {
                if(data){
                    debugger;
                    $("#SOACustomerExport").bind('click', function() {
                    });
                    $('#SOACustomerExport').simulateClick('click');
                    logger.logSuccess("Exported successfully!");
                }else{
                    logger.logSuccess("Failed to export");
                }
                
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        }
        else {
            toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(trialBalanceForm.$validationSummary), 555000, 'trustedHtml');
        }
        }else{
        	logger.logError("Please select the Mode");
        }

    }
    
    $scope.exportsoaConsolidatedExcel = function(){
        debugger;
        $scope.soa.fromDate =  $scope.returnEmptyForUndefined($("#txtFromDate").val());
        $scope.soa.toDate =   $scope.returnEmptyForUndefined($("#txtToDate").val());
        console.log($scope.soa);
        
        if(!$scope.isPayementCentre){
        	 if($scope.soa.mode!=''){
        		 
        if( $scope.soa.companyCode !=''){
            $http.post($stateParams.tenantid+'/app/receivable/exportSOAconsolidatedReport',$scope.soa).success(function(data) {
                if(data){
                    debugger;
                    $("#SOACustomerExport").bind('click', function() {
                    });
                    $('#SOACustomerExport').simulateClick('click');
                    logger.logSuccess("Exported successfully!");
                }else{
                    logger.logSuccess("Failed to export");
                }
                
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        }
            else{
                logger.logError("Please select Company");
        }
        	 }else{
             	logger.logError("Please select the Mode");
             }
        }else{  if( $scope.soa.paymentCode !=''){
            $http.post($stateParams.tenantid+'/app/receivable/exportSOAconsolidatedReportPaymentCentre',$scope.soa).success(function(data) {
                if(data){
                    debugger;
                    $("#SOACustomerExport").bind('click', function() {
                    });
                    $('#SOACustomerExport').simulateClick('click');
                    logger.logSuccess("Exported successfully!");
                }else{
                    logger.logSuccess("Failed to export");
                }
                
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        }
            else{
                logger.logError("Please select Payment centre");
        }
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
    
    $scope.returnEmptyForUndefined=function(value){
        if(value==undefined)
            value="";
        
        return value;
    }
    
    $scope.populateSubLedgerGrid = function(ListData){
        debugger;
        var data=[];
        $("#soaCustomerGrid").jqGrid({
            data: ListData,
            datatype: "local",
            multiboxonly: false,
            autowidth: true,
            height: '100%',
            rowList: [10,20,30],
            multiselect: false,
            gridview:true,
            colNames : ['Customer Code','Customer Name','Current balance'],
            colModel:[
                {name:'customerCode',index:'customerCode', width:80, align:"left",searchoptions:{sopt:['cn']}},
                {name:'customerName',index:'customerName', width:80, align:"left",searchoptions:{sopt:['cn']},hidden:false},
                {name:'balanceAmount',index:'balanceAmount', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                ],
            pager: "#soaCustomerPage",
            viewrecords: true,
            ignoreCase: true,
            subGrid: true,
            subGridOptions: {
                "plusicon" : 'ui-icon-plus',
                "minusicon" : 'ui-icon-minus'
            },
            loadComplete: function () {
            	$('#lui_soaCustomerGrid').remove();
                var $grid = $('#soaCustomerGrid');
                var credit = $grid.jqGrid('getCol', 'bcCredit', false, 'sum');
                var debit = $grid.jqGrid('getCol', 'bcDebit', false, 'sum');
                var difference = debit - credit;
            },
          
            subGridRowExpanded: function(subgrid_id, row_id) {
                debugger;
                var subgrid_table_id, pager_id; subgrid_table_id = subgrid_id+"_t";
                pager_id = "p_"+subgrid_table_id;
                var rowData = jQuery('#soaCustomerGrid').jqGrid ('getRowData', row_id);
                $scope.soa.filterPayerCode =rowData.payerCode;
                $scope.soa.filterCustomerCode =rowData.customerCode;
                $("#"+subgrid_id).html("<table id='"+subgrid_table_id+"' class='scroll'></table><div id='"+pager_id+"' class='scroll'></div>");
                $http.post($stateParams.tenantid+'/app/receivable/getSOACustomerDtlReport',$scope.soa).success(function(data) {
                 if(data.success){
                     debugger;
                     var dtllist =data.lCustomerDtlReportList;
                     console.log(dtllist);
                     $("#"+subgrid_table_id).jqGrid({
                     datatype: "local",
                     data: dtllist,
                     colNames:['Transaction No.','Transaction Date','Transaction Amount','Received Amount','Balance Amount','Age in Days','Mode'/*'Job Order No','Pol','Pod'*/,'Location'],
                     colModel:[
                            {name:'transactionNo',index:'transactionNo', width:200, align:"left",searchoptions:{sopt:['cn']}},
                            {name:'transactionDate',index:'transactionDate', width:200, align:"left",searchoptions:{sopt:['cn']},hidden:false},
                            {name:'transactionAmount',index:'transactionAmount', width:200, align:"left",searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                            {name:'receivedAmount',index:'receivedAmount', width:200,align:"left", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                            {name:'balanceAmount',index:'balanceAmount', width:200,align:"left", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                            {name:'ageInDays',index:'exchangeRate', width:200, align:"right",searchoptions:{sopt:['cn']},hidden:false},
                           {name:'vessel',index:'vessel', width:200,align:"right", searchoptions:{sopt:['cn']},hidden:false},
                          /* {name:'voyage',index:'voyage', width:200,align:"right", searchoptions:{sopt:['cn']},hidden:false},
                            {name:'pol',index:'tcDebit', width:200,align:"right", searchoptions:{sopt:['cn']},hidden:false},
                            {name:'pod',index:'tcCredit', width:200,align:"right", searchoptions:{sopt:['cn']},hidden:false},*/
                            
                            {name:'location',index:'location', width:100, align:"left",searchoptions:{sopt:['cn']}},
                        ],
                     autowidth: true,
                     height: '100%',
                     pager: pager_id,
                     sortname: 'num',
                     sortorder: "asc"
                    
                     }).jqGrid('setGridParam', { data : dtllist }).trigger("reloadGrid");
                 }
                
                }).error(function(dtllist) {
                });
             }
        }).jqGrid('setGridParam', { data : ListData }).trigger("reloadGrid");
        
    }
    
    $scope.populatesoaConsolidatedGrid = function(ListData){
        debugger;
        var data=[];
        $("#soaConsolidatedGrid").jqGrid({
            data: ListData,
            datatype: "local",
            multiboxonly: false,
            autowidth: true,
            height: '100%',
            rowList: [10,20,30],
            multiselect: true,
            gridview:true,
            colNames:['Customer Code','Customer Name','Transaction No.','Transaction Date','Inv Amt','TOTAL Amt','TC Amount'/*'Job Order No','Pol','Pod'*/,'Age in Days','Country'],
            colModel:[
//                    {name:'payerCode',index:'payerCode', width:100, align:"left",searchoptions:{sopt:['cn']}},
//                    {name:'payerName',index:'payerName', width:200, align:"left",searchoptions:{sopt:['cn']},hidden:false},
                    {name:'customerCode',index:'customerCode', width:100, align:"left",searchoptions:{sopt:['cn']}},
                    {name:'customerName',index:'customerName', width:200, align:"left",searchoptions:{sopt:['cn']},hidden:false},
                   {name:'transactionNo',index:'transactionNo', width:100, align:"left",searchoptions:{sopt:['cn']}},
                   {name:'transactionDate',index:'transactionDate', width:100, align:"left",searchoptions:{sopt:['cn']},hidden:false},
                   {name:'transactionAmount',index:'transactionAmount', width:100, align:"left",searchoptions:{sopt:['cn']},hidden:true,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                   {name:'receivedAmount',index:'receivedAmount', width:200,align:"left", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                   {name:'balanceAmount',index:'balanceAmount', width:100, align:"left",searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},

                /*   {name:'voyage',index:'voyage', width:100,align:"left", searchoptions:{sopt:['cn']},hidden:false},
                   {name:'pol',index:'pol', width:100,align:"left", searchoptions:{sopt:['cn']},hidden:false},
                   {name:'pod',index:'pod', width:100,align:"left", searchoptions:{sopt:['cn']},hidden:false},*/
//                   {name:'sailingDate',index:'sailingDate', width:100, align:"right",searchoptions:{sopt:['cn']},hidden:false},
//                   {name:'service',index:'service', width:100, align:"right",searchoptions:{sopt:['cn']},hidden:false},
                   {name:'ageInDays',index:'ageInDays', width:100, align:"right",searchoptions:{sopt:['cn']},hidden:false},
                   {name:'location',index:'location', width:100, align:"left",searchoptions:{sopt:['cn']}},
//                   {name:'paymentCenterName',index:'paymentCenterName', width:100, align:"left",searchoptions:{sopt:['cn']},hidden:false},
               ],
            pager: "#soaConsolidatedPage",
            viewrecords: true,
            ignoreCase: true,
            
            loadComplete: function () {
            	$('#lui_soaCustomerGrid').remove();
                var $grid = $('#soaCustomerGrid');
                var credit = $grid.jqGrid('getCol', 'bcCredit', false, 'sum');
                var debit = $grid.jqGrid('getCol', 'bcDebit', false, 'sum');
                var difference = debit - credit;
            },
          
        }).jqGrid('setGridParam', { data : ListData }).trigger("reloadGrid");
    }
            
           // onSelectRow: updateIdsOfSelectedRows,
            /*onSelectAll: function (aRowids, isSelected) {
                var i, count, id;
                for (i = 0, count = aRowids.length; i < count; i++) {
                    id = aRowids[i];
                    updateIdsOfSelectedRows(id, isSelected);
                }
            },
            loadComplete: function () {
                var $grid = $('#soaCustomerGrid');
                var credit = $grid.jqGrid('getCol', 'bcCredit', false, 'sum');
                var debit = $grid.jqGrid('getCol', 'bcDebit', false, 'sum');
                var difference = debit - credit;
                
                var $this = $(this), i, count;
                for (i = 0, count = idsOfSelectedRows.length; i < count; i++) {
                    $this.jqGrid('setSelection', idsOfSelectedRows[i], false);
                }
            },
          
        }).jqGrid('setGridParam', { data : ListData }).trigger("reloadGrid");*/
        
    
    
    $scope.populatesoaConsolidatedGridInv = function(ListData){
        debugger;
        var data=[];
        $("#soaConsolidatedGridinv").jqGrid({
            data: ListData,
            datatype: "local",
            multiboxonly: false,
            autowidth: true,
            height: '100%',
            rowList: [10,20,30],
            multiselect: true,
            gridview:true,
            colNames:['Payer Code','Payer name','Transaction No.','Transaction Date','Inv Amt','TOTAL Amt','TC Amount','Voyage'/*'Pol','Pod'*/,'Sailing Date','Service','Age in Days','Country','Payment Center'],
            colModel:[
//                    {name:'payerCode',index:'payerCode', width:100, align:"left",searchoptions:{sopt:['cn']}},
//                    {name:'payerName',index:'payerName', width:200, align:"left",searchoptions:{sopt:['cn']},hidden:false},
                   {name:'transactionNo',index:'transactionNo', width:100, align:"left",searchoptions:{sopt:['cn']}},
                   {name:'transactionDate',index:'transactionDate', width:100, align:"left",searchoptions:{sopt:['cn']},hidden:false},
                   {name:'transactionAmount',index:'transactionAmount', width:100, align:"left",searchoptions:{sopt:['cn']},hidden:true,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                   {name:'receivedAmount',index:'receivedAmount', width:200,align:"left", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                   {name:'balanceAmount',index:'balanceAmount', width:100, align:"left",searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},

//                   {name:'voyage',index:'voyage', width:100,align:"left", searchoptions:{sopt:['cn']},hidden:false},
                /*   {name:'pol',index:'pol', width:100,align:"left", searchoptions:{sopt:['cn']},hidden:false},
                   {name:'pod',index:'pod', width:100,align:"left", searchoptions:{sopt:['cn']},hidden:false},*/
//                   {name:'sailingDate',index:'sailingDate', width:100, align:"right",searchoptions:{sopt:['cn']},hidden:false},
//                   {name:'service',index:'service', width:100, align:"right",searchoptions:{sopt:['cn']},hidden:false},
                   {name:'ageInDays',index:'ageInDays', width:100, align:"right",searchoptions:{sopt:['cn']},hidden:false},
                   {name:'location',index:'location', width:100, align:"left",searchoptions:{sopt:['cn']}},
//                   {name:'paymentCenterName',index:'paymentCenterName', width:100, align:"left",searchoptions:{sopt:['cn']},hidden:false},
               ],
            pager: "#soaConsolidatedPageinv",
            viewrecords: true,
            ignoreCase: true, 
            loadComplete: function () {
            	$('#lui_soaCustomerGrid').remove();
                var $grid = $('#soaCustomerGridinv');
                var credit = $grid.jqGrid('getCol', 'bcCredit', false, 'sum');
                var debit = $grid.jqGrid('getCol', 'bcDebit', false, 'sum');
                var difference = debit - credit;
            },
          
        }).jqGrid('setGridParam', { data : ListData }).trigger("reloadGrid");
        
    }
    
    /*var $grid = $("#soaConsolidatedGrid"), idsOfSelectedRows = [],
    updateIdsOfSelectedRows = function (id, isSelected) {
        debugger;
        var index = $.inArray(id, idsOfSelectedRows);
        if (!isSelected && index >= 0) {
            idsOfSelectedRows.splice(index, 1); // remove id from the list
        } else if (index < 0) {
            idsOfSelectedRows.push(id);
        }
    };*/

});