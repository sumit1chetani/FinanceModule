app.controller('revecompletClosureAddCtrl', function($scope, $rootScope, $http, logger, $log, ngDialog, $modal, $location, $filter, utilsService, $window,sharedProperties,$stateParams) {
console.log(sharedProperties.getObject());
var formCode = $('#form_code_id').val();
$scope.rowCollection=sharedProperties.getObject();

$scope.invoiceType='';
$scope.invoiceTypeList=[];
$scope.getInvoiceType = function() {
    var data = {};
    data["id"] = "To be invoiced";
    data["text"] = "To be invoiced";
    $scope.invoiceTypeList.push(data);
    data = {};
    data["id"] = "Dead Freight";
    data["text"] = "Dead Freight";
    $scope.invoiceTypeList.push(data);
    data = {};
    data["id"] = "Not to be Invoiced";
    data["text"] = "Not to be Invoiced";
    $scope.invoiceTypeList.push(data);
    data = {};
    data["id"] = "JV Loading";
    data["text"] = "JV Loading";
    $scope.invoiceTypeList.push(data);
    data = {};
    data["id"] = "Swap Loading";
    data["text"] = "Swap Loading";
    $scope.invoiceTypeList.push(data);
    data = {};
    data["id"] = "T/S Loading";
    data["text"] = "T/S Loading";
    $scope.invoiceTypeList.push(data);
    
    $scope.invoiceType='To be invoiced';

}

$scope.getInvoiceType();
$scope.checkAll=function(selectAll){
    angular.forEach($scope.rowCollection, function(row, index) {
        row.select=$scope.selectAll;
        
    });
}

    $scope.check=function(){
        angular.forEach($scope.rowCollection, function(row, index) {
            if(!row.select){
                $scope.selectAll=false;
            }
            
            
        });
    }

    
    $scope.excel=function(rowCollection){   
        
        var objWholeData = 
            {
                'lRevenueCompletionClosureBean' :rowCollection
            }

        console.log("objWholeData");
        console.log(objWholeData);
$http.post($stateParams.tenantid+"/app/revenueCompletionClosure/generateExcel",objWholeData).success(function(response) {
    
       $('#exportXl').append('<a id="tbExcelExport" stype="display:none" href="filePath/RevenueCompletionClosure.xlsx" download="RevenueCompletionClosure.xlsx"></a>');
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

$scope.close=function(){
    var seleted=[];
    angular.forEach($scope.rowCollection, function(row, index) {
        if(row.select){
            row.type=$scope.invoiceType
            seleted.push(index);
        }
        
        
    });
    if(seleted.length>0){
        $scope.obj={
                lRevenueCompletionClosureBean:  $scope.rowCollection
        }
        $http.post($stateParams.tenantid+'/app/revenueCompletionClosure/closeData', $scope.rowCollection).success(function(datas) {            
            
           
             logger.logSuccess("Closed Successfully");
             $location.path($stateParams.tenantid+"/reports/income/revecompletClosuresearch");
        }).error(function(data) {

        });
    }
    
   
}
$scope.cancel=function(){
    $location.path($stateParams.tenantid+"/reports/income/revecompletClosuresearch");
}
});
app.filter('sumBySTKey', function () {
   
       return function (data, key,polId,podId) {    
           if (typeof (data) === 'undefined' || typeof (key) === 'undefined') {
               return 0;
           }
         
           var sum = 0;
           for (var i = data.length - 1; i >= 0; i--) {
               
               if(data[i]['pol']==polId && data[i]['pod']==podId)
                  
                   if(data[i][key]!=null && data[i][key]!="" && data[i][key]!=undefined && data[i][key]!='NaN' && data[i][key]!="-"){
                       //console.log("sum==="+data[i][key]+"="+(data[i][key]).length);
                       sum += parseInt(data[i][key]);
                   }
           }          
           return sum;
       };
   });
   

app.filter('sumByKey', function () {
    //   alert("filer");
       return function (data, key) {    
           if (typeof (data) === 'undefined' || typeof (key) === 'undefined') {
               return 0;
           }
         
           var sum = 0;
           for (var i = data.length - 1; i >= 0; i--) {
               if(data[i][key]!=null && data[i][key]!="" && data[i][key]!=undefined && data[i][key]!='NaN' && data[i][key]!="-"){
               sum += parseInt(data[i][key]);
               }
           }          
           return sum;
       };
   });
app.controller('revecompletClosureSearchCtrl', function($scope, validationService,toaster,$rootScope, $http, logger, $log, ngDialog, $modal, $location, $filter, utilsService, $window,sharedProperties,$stateParams) {

    $scope.search = {
        vessel : '',
        voyage : '',
        service : '',
        pol : '',
        pod : '',
        slotact : '',
        fromDate : '',
        toDate : ''
    }
    $scope.vesselList=[];
    $scope.serviceList=[];
    $scope.portList=[];
    $scope.slotList=[]
    $scope.voyageList=[];
    $scope.dropdown = function() {
        
        var formCode = $('#form_code_id').val();
        console.log(formCode)
/*       alert(formCode);*/
/*        if(formCode==undefined ||  formCode == '' || formCode=='null'){
            formCode="F0371";
            console.log("he")
        }*/
        $http.post($stateParams.tenantid+'/portCosting/vessel', formCode).success(function(data) {
            $scope.vesselList = data.vesselList;
        });
       /* $http.get('app/revenueCompletionClosure/getVesselData').success(function(datas) {
            $scope.vesselList = datas.lRevenueCompletionClosureBean;
        }).error(function(data) {

        });
*/
        $http.get($stateParams.tenantid+'/app/revenueCompletionClosure/getServiceData').success(function(datas) {
            $scope.serviceList = datas.lRevenueCompletionClosureBean;
        }).error(function(data) {

        });
   
        $http.get($stateParams.tenantid+'/app/revenueCompletionClosure/getSlotData').success(function(datas) {
            $scope.slotList = datas.lRevenueCompletionClosureBean;
        }).error(function(data) {

        });
        $('#fromDateId').datetimepicker({
            format : 'DD/MM/YYYY',
            pickTime : false
        })
        $('#toDateId').datetimepicker({
            format : 'DD/MM/YYYY',
            pickTime : false
        })
        $('#fromDateId').on("dp.change", function(e) {
            var from = $('#toDateId').val();
            var date = from.split("/");
            from = new Date(date[2], date[1] - 1, date[0]);
            var to = e.date._d;
            if (to < from) {
                logger.logError("Please Select From Date Less then  To Date");
                $('#fromDateId').val('')
            }

        });
        
        $('#toDateId').on("dp.change", function(e) {
            var from = $('#fromDateId').val();
            var date = from.split("/");
            from = new Date(date[2], date[1] - 1, date[0]);
            var to = e.date._d;
            if (to < from) {
                logger.logError("Please Select To Date Greater then  From Date");
                $('#toDateId').val('')
            }

        });
    }
    $scope.dropdown();
    $scope.$watch('search.vessel', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
            $http.post($stateParams.tenantid+'/app/revenueCompletionClosure/getVoyageData', newValue).success(function(datas) {
                $scope.voyageList = datas.lRevenueCompletionClosureBean;
               
            }).error(function(data) {

            });
        } else {
            $scope.search.service='';
            $scope.voyageList=[];
        }
    });
    
    $scope.$watch('search.voyage', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
            var obj = [];
             obj = $filter('filter')($scope.voyageList, {
                id : newValue
            });
            $scope.search.service =obj.length > 0 ? obj[0].sector : '';           
            $http.post($stateParams.tenantid+'/app/revenueCompletionClosure/getPortData',newValue).success(function(datas) {
                $scope.portList = datas.lRevenueCompletionClosureBean;
            }).error(function(data) {

            });
            
            
        } else {
            $scope.portList=[];
            $scope.search.service = '';
            
        }
    });
    $scope.add = function(revenuecompForm) {
        $scope.addform(revenuecompForm);
        /*if (new validationService().checkFormValidity($scope.revenuecompForm)) {
            $scope.addform(revenuecompForm);
        } else {
            toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.revenuecompForm.$validationSummary), 5500, 'trustedHtml');
        }*/
    };
    
    $scope.edit = function(revenuecompForm) {
        $scope.editform(revenuecompForm);
       /* if (new validationService().checkFormValidity($scope.revenuecompForm)) {
            $scope.editform(revenuecompForm);
        } else {
            toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.revenuecompForm.$validationSummary), 5500, 'trustedHtml');
        }*/
    };
    
    $scope.view = function(revenuecompForm) {

        $scope.viewform(revenuecompForm);
     /*   if (new validationService().checkFormValidity($scope.revenuecompForm)) {
            $scope.viewform(revenuecompForm);
        } else {
            toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.revenuecompForm.$validationSummary), 5500, 'trustedHtml');
        }*/
    };
    
    $scope.addform=function(){
       
      $scope.search.fromDate =   $('#fromDateId').val();
        $scope.search.toDate =   $('#toDateId').val();
       /* if($scope.search.vessel =='' && 
                $scope.search.voyage =='' && 
                $scope.search.service =='' && 
                $scope.search.pol =='' && 
                $scope.search.pod =='' && 
                $scope.search.slotact =='' && 
                $scope.search.fromDate =='' && $scope.search.toDate =='' ){
            logger.logError('Please select any search criteria');
            return false;
        }*/
        
        $http.post($stateParams.tenantid+'/app/revenueCompletionClosure/add', $scope.search).success(function(datas) {
            var data=[];
             data=datas.lRevenueCompletionClosureBean
            
             sharedProperties.setObject(datas.lRevenueCompletionClosureBean);
             if(data.length ==0){
                 logger.logError("No records found");
                 return false;
             }
             $location.path($stateParams.tenantid+"/reports/income/revecompletClosure/add");
        }).error(function(data) {

        });
        
    }
  $scope.viewform=function(){
        
        $scope.search.fromDate =   $('#fromDateId').val();
          $scope.search.toDate =   $('#toDateId').val();
        /*  if($scope.search.vessel =='' && 
                  $scope.search.voyage =='' && 
                  $scope.search.service =='' && 
                  $scope.search.pol =='' && 
                  $scope.search.pod =='' && 
                  $scope.search.slotact =='' && 
                  $scope.search.fromDate =='' && $scope.search.toDate =='' ){
              logger.logError('Please select any search criteria');
              return false;
          }*/
          
          $http.post($stateParams.tenantid+'/app/revenueCompletionClosure/view', $scope.search).success(function(datas) {
              var data=[];
               data=datas.lRevenueCompletionClosureBean
              
               sharedProperties.setObject(datas.lRevenueCompletionClosureBean);
               if(data.length ==0){
                   logger.logError("No records found");
                   return false;
               }
               $location.path($stateParams.tenantid+"/reports/income/revecompletClosure/view");
          }).error(function(data) {

          });
          
      }
    $scope.editform=function(){
        
        $scope.search.fromDate =   $('#fromDateId').val();
          $scope.search.toDate =   $('#toDateId').val();
        /*  if($scope.search.vessel =='' && 
                  $scope.search.voyage =='' && 
                  $scope.search.service =='' && 
                  $scope.search.pol =='' && 
                  $scope.search.pod =='' && 
                  $scope.search.slotact =='' && 
                  $scope.search.fromDate =='' && $scope.search.toDate =='' ){
              logger.logError('Please select any search criteria');
              return false;
          }*/
          
          $http.post($stateParams.tenantid+'/app/revenueCompletionClosure/edit', $scope.search).success(function(datas) {
              var data=[];
               data=datas.lRevenueCompletionClosureBean
              
               sharedProperties.setObject(datas.lRevenueCompletionClosureBean);
               if(data.length ==0){
                   logger.logError("No records found");
                   return false;
               }
               $location.path($stateParams.tenantid+"/reports/income/revecompletClosure/add");
          }).error(function(data) {

          });
          
      }
    

});
