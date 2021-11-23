
app.controller('ratematrixctrl', function($scope, $stateParams, validationService, $rootScope, $http, logger, $log, ngDialog, $timeout, $modal, $injector, sharedProperties, $location, $filter, utilsService, toaster) {
  
    $scope.mloList=[];
    $scope.categoryList=[];
    $scope.port=[];
    $scope.clearData=function(obj){
        
        if(obj=='MLO'){
            $scope.quotation.mlo='';
            $('#mlo_id .selectivityId').click();
        }else if(obj=='CATEGORY'){
            $scope.quotation.category='';
            $('#category_id .selectivityId').click();
        }
        else if(obj=='POL'){
            $scope.quotation.pol='';
            $('#pol_id .selectivityId').click();
        }
        else if(obj=='POD'){
            $scope.quotation.pod='';
            $('#pod_id .selectivityId').click();
        }  else if(obj=='shipment'){
            $scope.quotation.pod='';
            $('#shipment_id .selectivityId').click();
        }

       
    }
    $scope.companydetails={};
    $http.get('app/commonUtility/companyName').success(function(datas) {
        $scope.companydetails = datas;
        
    }).error(function(datas) {
    });
    $scope.termsofshipmentList=[];
    $scope.getTermsOfShipment = function() {

        
        var data = {};
        data["id"] = "'FIFO'";
        data["text"] = "FI/FO";
        $scope.termsofshipmentList.push(data);
        data = {};
        data["id"] = "'CYFO','CY/FO'";
        data["text"] = "CY/FO";
        $scope.termsofshipmentList.push(data);
        data = {};
        data["id"] = "'FICY','FI/CY'";
        data["text"] = "FI/CY";
        $scope.termsofshipmentList.push(data);
        data = {};
        data["id"] = "'FIHK','FI/HK'";
        data["text"] = "FI/HK";
        $scope.termsofshipmentList.push(data);
        data = {};
        data["id"] = "'HKFO','HK/FO'";
        data["text"] = "HK/FO";
        $scope.termsofshipmentList.push(data);
        data = {};
        data["id"] = "'HKCY','HK/CY'";
        data["text"] = "HK/CY";
        $scope.termsofshipmentList.push(data);
        data = {};
        data["id"] = "'CYHK','CY/HK'";
        data["text"] = "CY/HK";
        $scope.termsofshipmentList.push(data);
        
        data = {};
        data["id"] = "'CYCY','CY/CY'";
        data["text"] = "CY/CY";
        $scope.termsofshipmentList.push(data);
        data = {};
        data["id"] = "'FITK','FI/TK'";
        data["text"] = "FI/TK";
        $scope.termsofshipmentList.push(data);
        data = {};
        data["id"] = "'TKFO','TK/FO'";
        data["text"] = "TK/FO";
        $scope.termsofshipmentList.push(data);
    }
  $scope.getTermsOfShipment();
    
    $scope.quotation={
            mlo:'',
            pol:'',
            pod:'',
            category:'',
            validTo:'',
            validFrom:'',
            termsofshipment:''
                
    }
    $('#validFromDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime : false
    })
    $('#validToDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime : false
    })

    $scope.dropdown=function(){
  var templist=[];
    $http.get('app/commonUtility/mlomaster').success(function(datas) {
        $scope.mloList = datas.commonUtilityBean;
        $scope.defaultdata = angular.copy($scope.mloList);

        angular.forEach($scope.defaultdata, function(list, index) {
            var text = list.text;
            list.id = list.id;
            list.text = text + '-' + list.id;
            templist.push(list);
        });
        $scope.mloList = templist;

    }).error(function(data) {

    });
    
    $http.get('app/Quotation/getPort').success(function(datas) {
        $scope.port = datas.lQuotationBean;

    }).error(function(data) {

    });
    
    $http.get('app/jvTariffcategory/custCategory').success(function(datas) {
        $scope.categoryList = datas.lJvTariffBean;

    }).error(function(data) {

    });
    }
    $scope.dropdown();
    $scope.rowdata=[];
    $scope.search=function(){
      //  $('#search12').attr('disabled',true);
        $scope.quotation.validFrom = $('#validFrom').val();
        $scope.quotation.validTo = $('#validTo').val();
        
        $http.post('app/ratematrixreport/search', $scope.quotation).success(function(data) {
            $scope.rowdata = data.lRateMatrixReportBean;
            $('#search12').attr('disabled',false);
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
        
       
    }
    $scope.resetData=function(){
        $scope.rowdata=[];
        $scope.quotation={
                mlo:'',
                pol:'',
                pod:'',
                category:'',
                validTo:'',
                validFrom:'',
                termsofshipment:''
                    
        }
    }
    $scope.rateCompare=function(){
          $('#rateComparebut').attr('disabled',true);
          $scope.quotation.validFrom = $('#validFrom').val();
          $scope.quotation.validTo = $('#validTo').val();
          
           $http.post('app/ratematrixreport/compare', $scope.quotation).success(function(data) {
               $scope.rowdata = data.lRateMatrixReportBean;
               $('#rateComparebut').attr('disabled',false);
           }).error(function(data) {
               logger.logError("Error Please Try Again");
           });
           
          
       }
    
    $scope.exportexcel=function(){
        $('#excelexportbut').attr('disabled',true);
        
        $scope.data={
                lRateMatrixReportBean:$scope.rowdata
        }
         $http.post('app/ratematrixreport/excelexport', $scope.data).success(function(data) {
         
             $('#excelexportbut').attr('disabled',false);
             
             $("#tbexcelExport").bind('click', function() {
                 //  alert('clicked');

             });
             $('#tbexcelExport').simulateClick('click');
         }).error(function(data) {
             logger.logError("Error Please Try Again");
         });
         
        
     }
    
    $scope.sendmail=function(){
       
        
        $scope.data={
                lRateMatrixReportBean:$scope.rowdata
        }
         $http.post('app/ratematrixreport/sendmail', $scope.data).success(function(data) {
             logger.logSuccess("Send mail successfully");
       
         }).error(function(data) {
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

});
