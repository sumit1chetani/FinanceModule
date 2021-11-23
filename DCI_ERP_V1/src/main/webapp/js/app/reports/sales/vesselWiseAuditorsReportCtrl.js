 
app.filter('sumByKey', function () {
    return function (data, key) {
        if (typeof (data) === 'undefined' || typeof (key) === 'undefined') {
            return 0;
        }

        var sum = 0.0;
        for (var i = data.length - 1; i >= 0; i--) {
            sum += parseFloat(data[i][key]);
        }

        return sum;
    };
});


app.filter('sumByCost', function () {
    return function (data, sumqty, rev) {
        if (typeof (data) === 'undefined' || typeof (sumqty) === 'undefined'|| typeof (rev) === 'undefined') {
            return 0;
        }

        var sum = 0;
        for (var i = data.length - 1; i >= 0; i--) {
            sum += parseInt(data[i][sumqty]);
        }
        
        var sum1=0;
        for (var i = data.length - 1; i >= 0; i--) {
            sum1 += parseInt(data[i][rev]);
        }
        var perteus=parseFloat((sum1/sum)*100/100).toFixed(2);
        

        return perteus;
    };
});

app.filter('sumByEmpty', function () {
    return function (data) {
        if (typeof (data) === 'undefined') {
            return 0;
        }

        var rev = 0;
        for (var i = data.length - 1; i >= 0; i--) {
            rev += parseFloat(data[i]['emptyrate']) ;
        }
        var squty = 0;
        for (var i = data.length - 1; i >= 0; i--) {
            squty += parseFloat(data[i]['emptyteus'])
          
        }
      
        var sum=0;
        if(squty!=0 && rev !=0)
            sum= parseFloat((rev/squty)*100/100).toFixed(2);
        return sum;
    };
});


app.filter('sumByLaden', function () {
    return function (data) {
        if (typeof (data) === 'undefined') {
            return 0;
        }

        var rev = 0;
        for (var i = data.length - 1; i >= 0; i--) {
            rev += parseFloat(data[i]['ladenrate']);
             
        }
        var squty = 0;
        for (var i = data.length - 1; i >= 0; i--) {
            squty  += parseFloat(data[i]['ladenteus'])
           
        //    squty += (parseFloat(data[i].totalteus) -mquty);
            }
        var sum=0;
        
       
        if(squty!=0 && rev !=0)
        sum= parseFloat((rev/squty)*100/100).toFixed(2);
        
        
        return sum;
    };
});

app.filter('sumByTotalQt', function () {
    return function (data) {
        if (typeof (data) === 'undefined') {
            return 0;
        }

        var rev = 0;
        for (var i = data.length - 1; i >= 0; i--) {
            rev += parseFloat(data[i].revenue) 
            
        }
        var squty = 0;
        for (var i = data.length - 1; i >= 0; i--) {
            squty += parseFloat(data[i].totalteus) 
            }
        var sum=0;
        
       
        if(squty!=0 && rev !=0)
        sum= parseFloat((rev/squty)*100/100).toFixed(2);
        
        
        return sum;
    };
});
app.controller('vesselWiseAuditorsReportSearchCtrl', function($scope, $rootScope,validationService,toaster, $http, logger, $log, ngDialog, $modal, $location, $filter, utilsService,sharedProperties) {
     $scope.auditrept={vessel:'',voyage:'',pol:'',pod:'',mlo:'',slotac:'',validTo:'',validFrom:'',invoiceValidTo:'',invoiceValidFrom:''};
     
     $scope.dropdown=function(){
         $http.get('app/Quotation/getMloMaster').success(function(datas) {
             $scope.mlomaster = datas.lQuotationBean;
         
         }).error(function(data) {

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
       /*  $http.get('app/TransQuot/getVoyage').success(function(datas) {
             $scope.voyageList = datas;
             $scope.defaultvoyageList = angular.copy($scope.voyageList);
         }).error(function(data) {

         });*/
         //Get Vessel dropDown
         var formCode = $('#form_code_id').val();
         $http.post('portCosting/vessel', formCode).success(function(data) {
             $scope.vesselList = data.vesselList;
         });
         $http.get('app/TransQuot/getPort').success(function(datas) {
             $scope.port = datas;

         }).error(function(data) {

         });
         $http.get('app/vesselWiseAuditorsReport/slotac').success(function(datas) {
             $scope.slotacs = datas.lvesselWiseAuditorsReportBean;

         }).error(function(data) {

         });
        
         $scope.$watch('auditrept.vessel', function(newValue, oldValue) {
             var tempvoyagelist = [];
             if (newValue != '' && newValue != undefined) {
               
                 $http.post('app/TransQuot/getVesselVoyage',  newValue).success(function(datas) {
                     $scope.voyageList = datas;
                 }).error(function(data) {

                 });

                 $scope.voyage = '';
             } else {
           
                 $scope.voyageList = $scope.defaultvoyageList;               
                 $scope.auditrept.voyage = ''
             }
         });
        
         $scope.$watch('auditrept.voyage', function(newValue, oldValue) {
             if (newValue != '' && newValue != undefined) {
                
                 $http.post('app/vesselWiseAuditorsReport/port',  newValue).success(function(datas) {
                     $scope.port = datas.lvesselWiseAuditorsReportBean;
                 }).error(function(data) {

                 });
              

             } else {

                
               
             }
         });
         $('#validFromDate').datetimepicker({
             format : 'DD/MM/YYYY',
             pickTime: false
         })
          $('#validToDate').datetimepicker({
              format : 'DD/MM/YYYY',
              pickTime: false
         })
         
          $('#invoiceValidFrom').datetimepicker({
             format : 'DD/MM/YYYY',
             pickTime: false
         })
          $('#invoiceValidTo').datetimepicker({
              format : 'DD/MM/YYYY',
              pickTime: false
         })
         
         var today = new Date();
         var yesterday = new Date(new Date().setDate(new Date().getDate()-1));

         var dd = today.getDate();
         var mm = today.getMonth() + 1;
         
         var ydd = yesterday.getDate();
         var ymm = yesterday.getMonth() + 1;
         var Yyyyy = yesterday.getFullYear();
         
         var yyyy = today.getFullYear();
         if (dd < 10) {
             dd = '0' + dd
         }
         if (ydd < 10) {
             ydd = '0' + ydd
         }
         if (ymm < 10) {
             ymm = '0' + ymm
         }
         if (mm < 10) {
             mm = '0' + mm
         }
         var today = dd + '/' + mm + '/' + yyyy;
         var fromdate = ydd + '/' + ymm + '/' + Yyyyy;
//         $scope.auditrept.validTo = today;
  //       $scope.auditrept.validFrom = fromdate;
     }
    
     $scope.dropdown();
     
     $scope.onSearch = function(vesselwiseaudreport) {
         $scope.searchVal(vesselwiseaudreport);
        /* if (new validationService().checkFormValidity($scope.vesselwiseaudreport)) {
             $scope.searchVal(vesselwiseaudreport);
         } else {
             toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.vesselwiseaudreport.$validationSummary), 5500, 'trustedHtml');
         }*/
     };
     
     $scope.searchVal=function(vesselwiseaudreport){
         $scope.objsearch={vessel:'',voyage:'',pol:'',pod:'',mlo:'',slotac:'',validTo:'',validFrom:''};
         $scope.auditrept.validTo=  $('#validTo').val();
         $scope.auditrept.validFrom=  $('#validFrom').val();
         sharedProperties.setObject($scope.auditrept);
         $location.path('/reports/vesselWiseAuditorsReport');
        
         
     }
     
 $scope.onInvoiceSearch = function(vesselwiseaudreport) {
     $scope.onInvoice(vesselwiseaudreport);
       /*  if (new validationService().checkFormValidity($scope.vesselwiseaudreport)) {
             $scope.onInvoice(vesselwiseaudreport);
         } else {
             toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.vesselwiseaudreport.$validationSummary), 5500, 'trustedHtml');
         }*/
     };
     $scope.searchVal=function(vesselwiseaudreport){
         $scope.objsearch={vessel:'',voyage:'',pol:'',pod:'',mlo:'',slotac:'',validTo:'',validFrom:''};
         $scope.auditrept.validTo=  $('#validTo').val();
         $scope.auditrept.validFrom=  $('#validFrom').val();
         sharedProperties.setObject($scope.auditrept);
         $location.path('/reports/vesselWiseAuditorsReport');
        
         
     }
     
     $scope.onInvoice=function(auditrept){
         $scope.objsearch={vessel:'',voyage:'',pol:'',pod:'',mlo:'',slotac:'',validTo:'',validFrom:''};
       
         
         $scope.auditrept.validTo=  $('#validTo').val();
         $scope.auditrept.validFrom=  $('#validFrom').val();
         sharedProperties.setObject($scope.auditrept);
         $location.path('/reports/vesselWiseAuditorsInvoiceReport');
             
         
         
     }
     $scope.onInvoiceExport = function(auditrept) {

         $scope.auditrept.validTo=  $('#validTo').val();
         $scope.auditrept.validFrom=  $('#validFrom').val();
         sharedProperties.setObject($scope.auditrept);         
         var d = new Date();
         var n = d.getMinutes();
         var s = d.getSeconds();
         var mon=Number(d.getMonth())+1;
         var day=d.getDate();
         var yr=d.getFullYear();
         var ms=d.getMilliseconds();
         
        
         $scope.filename="InvoiceReconciliation"+day+""+mon+""+yr+""+n+""+s+""+ms+".xls";
         
         $scope.auditrept.filename="InvoiceReconciliation"+day+""+mon+""+yr+""+n+""+s+""+ms;


         
         $http.post('app/vesselWiseAuditorsReport/invoiceexcelexport', $scope.auditrept).success(function(data) {
             $('#exportXl').remove();
             $('.excel').append('<div id="exportXl"></div>');
                     var file='<a id="tbExcelExport" stype="display:none" href="filePath/'+$scope.filename+'" download="'+$scope.filename+'"></a>'
                 
                    $('#exportXl').append(file);
                    $("#tbExcelExport").bind('click', function() {
                    });
                    $('#tbExcelExport').simulateClick('click');

         }).error(function(data) {
             logger.logError("Error Please Try Again");
         });
         
     }
     
     $scope.exportData = function(auditrept) {
         $scope.auditrept.validTo=  $('#validTo').val();
         $scope.auditrept.validFrom=  $('#validFrom').val();
         sharedProperties.setObject($scope.auditrept);         
         var d = new Date();
         var n = d.getMinutes();
         var s = d.getSeconds();
         var mon=Number(d.getMonth())+1;
         var day=d.getDate();
         var yr=d.getFullYear();
         var ms=d.getMilliseconds();
         
        
         $scope.filename="VesselWiseAuditorsReport"+day+""+mon+""+yr+""+n+""+s+""+ms+".xls";
         
         $scope.auditrept.filename="VesselWiseAuditorsReport"+day+""+mon+""+yr+""+n+""+s+""+ms;


         
         $http.post('app/vesselWiseAuditorsReport/excelexport', $scope.auditrept).success(function(data) {
             $('#exportXl').remove();
             $('.excel').append('<div id="exportXl"></div>');
                     var file='<a id="tbExcelExport" stype="display:none" href="filePath/'+$scope.filename+'" download="'+$scope.filename+'"></a>'
                 
                    $('#exportXl').append(file);
                    $("#tbExcelExport").bind('click', function() {
                    });
                    $('#tbExcelExport').simulateClick('click');

         }).error(function(data) {
             logger.logError("Error Please Try Again");
         });
     };
     
     
     
     $scope.onInvoiceDateExport = function(auditrept) {
         $scope.auditrept.invoiceValidTo=  $('#invoiceValidTo').val();
         $scope.auditrept.invoiceValidFrom=  $('#invoiceValidFrom').val();
         if($scope.auditrept.mlo==undefined || $scope.auditrept.mlo==''){
             logger.logError("Please select the customer");
             return false;
         }
         else if($scope.auditrept.invoiceValidTo==undefined || $scope.auditrept.invoiceValidTo==''){
             logger.logError("Please select the INVOICE TO");
             return false;
         }else if($scope.auditrept.invoiceValidFrom==undefined || $scope.auditrept.invoiceValidFrom==''){
             logger.logError("Please select the INVOICE FROM");
             return false;
         }
         
     
         sharedProperties.setObject($scope.auditrept);         
         var d = new Date();
         var n = d.getMinutes();
         var s = d.getSeconds();
         var mon=Number(d.getMonth())+1;
         var day=d.getDate();
         var yr=d.getFullYear();
         var ms=d.getMilliseconds();
         
        
         $scope.filename="InvoiceReconciliationWithDate"+day+""+mon+""+yr+""+n+""+s+""+ms+".xlsx";
         
         $scope.auditrept.filename="InvoiceReconciliationWithDate"+day+""+mon+""+yr+""+n+""+s+""+ms;


         
         $http.post('app/vesselWiseAuditorsReport/invoiceDateWiseexcelexport', $scope.auditrept).success(function(data) {
             $('#exportXl1').remove();
             $('.excel1').append('<div id="exportXl1"></div>');
                     var file='<a id="tbExcelExport1" stype="display:none" href="filePath/'+$scope.filename+'" download="'+$scope.filename+'"></a>'
                 
                    $('#exportXl1').append(file);
                    $("#tbExcelExport1").bind('click', function() {
                    });
                    $('#tbExcelExport1').simulateClick('click');

         }).error(function(data) {
             logger.logError("Error Please Try Again");
         });
         
     }
     
    
 });
 
 app.controller('vesselWiseAuditorsReportSubmitCtrl', function($scope, $rootScope, $http, logger, $log, ngDialog, $modal, $location, $filter, utilsService,sharedProperties) {
     var obj=sharedProperties.getObject();
     $scope.val=0.0;
     if(obj!=undefined){
         $http.post('app/vesselWiseAuditorsReport/generateDynamicContainer',obj).success(function(datas) {
             $scope.reportData = datas.lvesselWiseAuditorsReportBean;

         }).error(function(data) {

         });
     }
    
     $scope.cancel=function(){
         $location.path('/reports/vesselWiseAuditorsReportSearch');
     }
     
     
     
     $scope.excel=function(vesselWiseSummaryForm,reportData){  
      
         var objWholeData = {
                'lvesselWiseAuditorsReportBean'  : reportData,
 
           };  
         console.log("objWholeData");
      console.log(objWholeData);
  $http.post("app/vesselWiseAuditorsReport/generateExcel",objWholeData).success(function(response) {
       console.log("response")
       console.log(response);
         
            $('#exportXl').append('<a id="tbExcelExport" stype="display:none" href="filePath/VesselWiseAuditorReport.xlsx" download="VesselWiseAuditorReport.xlsx"></a>');
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
 
 app.controller('vesselWiseAuditorsReportInvoiceCtrl', function($scope, $rootScope, $http, logger, $log, ngDialog, $modal, $location, $filter, utilsService,sharedProperties) {
   
     var obj=sharedProperties.getObject();
     $scope.val=0.0;
     if(obj!=undefined){
         $http.post('app/vesselWiseAuditorsReport/generateDynamicInvoiceContainer',obj).success(function(datas) {
             $scope.reportData = datas.lvesselWiseAuditorsReportBean;
             console.log(datas.lvesselWiseAuditorsReportBean.length)

         }).error(function(data) {

         });
     }
     $scope.cancel=function(){
         $location.path('/reports/vesselWiseAuditorsReportSearch');
     }
     
     $scope.excelInvoice =function(reportData){  
         
         var objWholeData = {
                'lvesselWiseAuditorsReportBean'  : reportData,
           };  
         console.log("objWholeData");
      console.log(objWholeData);
  $http.post("app/vesselWiseAuditorsReport/generateExcelInvoice",objWholeData).success(function(response) {

         
            $('#exportXl').append('<a id="tbExcelExport" stype="display:none" href="filePath/VesselWiseAuditorReportInvoice.xlsx" download="VesselWiseAuditorReportInvoice.xlsx"></a>');
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