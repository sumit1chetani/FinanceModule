app.controller('pricingreportCtrl', function(
        $scope, $rootScope, $http, logger, $log, ngDialog, $modal, $location, $filter, utilsService,$timeout, $window,$localStorage) {
    
    $scope.resetData=function(){
        $scope.quotation = {              
                mloshtname : '',
                validFrom : '',
                pod : '',
                pol : '',
                mlo : '',
                validTo : '',            
                payerCode : '',
                podiso:'',
                poliso:'',
                servicehub:''
            };
    }
    
    $scope.quotation = {           
            mloshtname : '',
            validFrom : '',
            pod : '',
            pol : '',
            mlo : '',
            validTo : '',            
            payerCode : '',
            podiso:'',
            poliso:'',
            servicehub:''
        };
    $http.post('app/dashboard/getUserObj').success(function(comdatas){
        $scope.companyCode=comdatas.companyCode;
    }).error(function(datas){
        logger.logError("Error");
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
    
    $('#validFromDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime : false
    })
    $('#validToDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime : false
    })
 $scope.companyList=[];
    $scope.getCompanyData = function() {
        var data = {};
        data["id"] = "C0001";
        data["text"] = "Dubai";
        $scope.companyList.push(data);
        data = {};
        data["id"] = "C0003";
        data["text"] = "Singapore";
        $scope.companyList.push(data);
        
        

    }
    $scope.getCompanyData();
    
    $scope.clearData=function(obj){
        
        if(obj=='MLO'){
            $scope.quotation.mloshtname='';
            $('#mloshortname_id .selectivityId').click();
        }
        else if(obj=='POL'){
            $scope.quotation.pol='';
            $('#pol_id .selectivityId').click();
        }
        else if(obj=='POD'){
            $scope.quotation.pod='';
            $('#pod_id .selectivityId').click();
        }
        else if(obj=='PAYER'){
            $scope.quotation.payerCode='';
            $('#payer_id .selectivityId').click();
        }
        else if(obj=='POLISO'){
            $scope.quotation.pol='';
            $('#poliso_id .selectivityId').click();
        }
        else if(obj=='PODISO'){
            $scope.quotation.pod='';
            $('#podiso_id .selectivityId').click();
        }
       
    }
    
    
  $scope.jvtariffRateCompare=function(){
        
        var d = new Date();
        var n = d.getMinutes();
        var s = d.getSeconds();
        var mon=Number(d.getMonth())+1;
        var day=d.getDate();
        var yr=d.getFullYear();
        var ms=d.getMilliseconds();
        
        $scope.quotation.validFrom = $('#validFrom').val();
        $scope.quotation.validTo = $('#validTo').val();
        
        $scope.filename="RateCompareWithJV"+day+""+mon+""+yr+""+n+""+s+""+ms+".xlsx";
        
        $scope.quotation.filename="RateCompareWithJV"+day+""+mon+""+yr+""+n+""+s+""+ms;
        
        $http.post('app/pricingreport/jvtariffRateCompare', $scope.quotation).success(function(data) {
            

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
    $scope.currentrateonfile=function(){
        
        var d = new Date();
        var n = d.getMinutes();
        var s = d.getSeconds();
        var mon=Number(d.getMonth())+1;
        var day=d.getDate();
        var yr=d.getFullYear();
        var ms=d.getMilliseconds();
        
        $scope.quotation.validFrom = $('#validFrom').val();
        $scope.quotation.validTo = $('#validTo').val();
        
        $scope.filename="CurrentRateonfile"+day+""+mon+""+yr+""+n+""+s+""+ms+".xlsx";
        
        $scope.quotation.filename="CurrentRateonfile"+day+""+mon+""+yr+""+n+""+s+""+ms;
        
        $http.post('app/pricingreport/currentRateonfile', $scope.quotation).success(function(data) {
            

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
    
    
    
    
  $scope.tendershareandvolume=function(){
        
        var d = new Date();
        var n = d.getMinutes();
        var s = d.getSeconds();
        var mon=Number(d.getMonth())+1;
        var day=d.getDate();
        var yr=d.getFullYear();
        var ms=d.getMilliseconds();
        
        $scope.quotation.validFrom = $('#validFrom').val();
        $scope.quotation.validTo = $('#validTo').val();
        
        $scope.filename="Tendershareandvolume"+day+""+mon+""+yr+""+n+""+s+""+ms+".xlsx";
        
        $scope.quotation.filename="Tendershareandvolume"+day+""+mon+""+yr+""+n+""+s+""+ms;
        
        $http.post('app/pricingreport/tendershareandvolume', $scope.quotation).success(function(data) {
            

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
  
  $scope.transcostsreport=function(){
      
      var d = new Date();
      var n = d.getMinutes();
      var s = d.getSeconds();
      var mon=Number(d.getMonth())+1;
      var day=d.getDate();
      var yr=d.getFullYear();
      var ms=d.getMilliseconds();
      
      $scope.filename="TransCostReport"+day+""+mon+""+yr+""+n+""+s+""+ms+".xlsx";
      
      $scope.quotation.filename="TransCostReport"+day+""+mon+""+yr+""+n+""+s+""+ms;
      $scope.quotation.validFrom = $('#validFrom').val();
      $scope.quotation.validTo = $('#validTo').val();
      $http.post('app/pricingreport/transCostReport', $scope.quotation).success(function(data) {
          

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
    
    $scope.currentRateOnFileThroughCargo=function(){
        
        var d = new Date();
        var n = d.getMinutes();
        var s = d.getSeconds();
        var mon=Number(d.getMonth())+1;
        var day=d.getDate();
        var yr=d.getFullYear();
        var ms=d.getMilliseconds();
        
        $scope.quotation.validFrom = $('#validFrom').val();
        $scope.quotation.validTo = $('#validTo').val();
        $scope.filename="currentRateThroughCargo"+day+""+mon+""+yr+""+n+""+s+""+ms+".xlsx";
        
        $scope.quotation.filename="currentRateThroughCargo"+day+""+mon+""+yr+""+n+""+s+""+ms;
        
        $http.post('app/pricingreport/currentRateOnFileThroughCargo', $scope.quotation).success(function(data) {
            

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
    
 $scope.currentRateOnFilePrmoc=function(){
        
        var d = new Date();
        var n = d.getMinutes();
        var s = d.getSeconds();
        var mon=Number(d.getMonth())+1;
        var day=d.getDate();
        var yr=d.getFullYear();
        var ms=d.getMilliseconds();
        $scope.quotation.validFrom = $('#validFrom').val();
        $scope.quotation.validTo = $('#validTo').val();
        
        $scope.filename="CurrentRateOnFilePrmoc"+day+""+mon+""+yr+""+n+""+s+""+ms+".xlsx";
        
        $scope.quotation.filename="CurrentRateOnFilePrmoc"+day+""+mon+""+yr+""+n+""+s+""+ms;
        
        $http.post('app/pricingreport/currentRateOnFilePrmoc', $scope.quotation).success(function(data) {
            

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
 
 
    
    $scope.currentRateOnFileCYFO=function(){
        
        var d = new Date();
        var n = d.getMinutes();
        var s = d.getSeconds();
        var mon=Number(d.getMonth())+1;
        var day=d.getDate();
        var yr=d.getFullYear();
        var ms=d.getMilliseconds();
        
        $scope.quotation.validFrom = $('#validFrom').val();
        $scope.quotation.validTo = $('#validTo').val();
        $scope.filename="CurrentRateOnFileCYFO"+day+""+mon+""+yr+""+n+""+s+""+ms+".xlsx";
        
        $scope.quotation.filename="CurrentRateOnFileCYFO"+day+""+mon+""+yr+""+n+""+s+""+ms;
        
        $http.post('app/pricingreport/currentRateOnFileCYFO', $scope.quotation).success(function(data) {
            

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
$scope.currentRateVsJV=function(){
        
        var d = new Date();
        var n = d.getMinutes();
        var s = d.getSeconds();
        var mon=Number(d.getMonth())+1;
        var day=d.getDate();
        var yr=d.getFullYear();
        var ms=d.getMilliseconds();
        
        $scope.quotation.validFrom = $('#validFrom').val();
        $scope.quotation.validTo = $('#validTo').val();
        $scope.filename="CurrentRateVsJv"+day+""+mon+""+yr+""+n+""+s+""+ms+".xlsx";
        
        $scope.quotation.filename="CurrentRateVsJv"+day+""+mon+""+yr+""+n+""+s+""+ms;
        
        $http.post('app/pricingreport/currentRateVsJv', $scope.quotation).success(function(data) {
            

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
    $scope.getDropdownvalue = function() {

        $scope.mlomastershortname = [];
        var templist = [];
        $scope.payerList = [];
        
        $http.get('app/Quotation/getPayer').success(function(datas) {
            $scope.payerList = datas;

        }).error(function(data) {

        });
        $http.get('app/TransQuotSel/getPortIsoCode').success(function(datas) {
            $scope.portiso = datas;
        }).error(function(data) {

        });
        $http.get('app/Quotation/getPort').success(function(datas) {
            $scope.port = datas.lQuotationBean;
        $http.get('app/commonUtility/mlomaster').success(function(datas) {
            $scope.mlomastershortname = datas.commonUtilityBean;
            $scope.defaultdata = angular.copy($scope.mlomastershortname);

            angular.forEach($scope.defaultdata, function(list, index) {
                var text = list.text;
              
                list.text = text + '-' + list.id;
                list.id = text;
                templist.push(list);
            });
            $scope.mlomastershortname = templist;

        }).error(function(data) {

        });
      

        }).error(function(data) {

        });
      

    

    }
    
    $scope.$watch('quotation.mloshtname', function(newValue, oldValue) {
        if (newValue != '') {
            var list = angular.copy(newValue);
            $scope.mloname = list.text;

        } else {
            $scope.mloname = '';
        }
    });
    $scope.$watch('quotation.mlo', function(newValue, oldValue) {
        if (newValue != '') {
            var list = angular.copy(newValue);
            $scope.mloshtname = list.text;

        } else {
            $scope.mloshtname = '';
        }
    });
    
    $scope.getDropdownvalue();
});

app.controller('rateComparisonCtrl', function(
        $scope, $rootScope, $http, logger, $log, ngDialog, $modal, $location, $filter, utilsService,$timeout, $window,$localStorage) {
    
    $scope.quotation={
            fromCust:'',
            validFrom1:'',
            validTo1:'',
            toCust:'',
            validFrom2:'',
            validTo2:''
    }
    
    $scope.getDropdownvalue = function() {

        $scope.customerList = [];
        var templist = [];
        $scope.payerList = [];
        
      
        
        $http.get('app/Quotation/getPort').success(function(datas) {
            $scope.port = datas.lQuotationBean;
        $http.get('app/commonUtility/mlomaster').success(function(datas) {
            $scope.mlomastershortname = datas.commonUtilityBean;
            $scope.defaultdata = angular.copy($scope.mlomastershortname);

            angular.forEach($scope.defaultdata, function(list, index) {
                var text = list.text;
              
                list.text = text + '-' + list.id;
                list.id = text;
                templist.push(list);
            });
            $scope.customerList = templist;

        }).error(function(data) {

        });
      

        }).error(function(data) {

        });
      

    

    }
    $('#validFromDate1').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime : false
    })
    $('#validToDate1').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime : false
    })
    
      $('#validFromDate2').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime : false
    })
    $('#validToDate2').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime : false
    })

    
      $scope.resetData = function() {
        $scope.quotation={
                fromCust:'',
                validFrom1:'',
                validTo1:'',
                toCust:'',
                validFrom2:'',
                validTo2:''
        }
        
        
    }

   
  $scope.customerWiseCompare=function(){
      
      var invaild=false;
      var msg="";
        if($scope.quotation.fromCust=='' || $scope.quotation.fromCust == undefined ){
            msg=" Please select Customer 1";
            invaild=true;
        }else if($scope.quotation.toCust=='' || $scope.quotation.toCust == undefined ){
            msg=" Please select Customer 2";
            invaild=true;
        }
        if(invaild){
            logger.logError(msg);
        }else{
            

            
            var d = new Date();
            var n = d.getMinutes();
            var s = d.getSeconds();
            var mon=Number(d.getMonth())+1;
            var day=d.getDate();
            var yr=d.getFullYear();
            var ms=d.getMilliseconds();
            
         
            
            $scope.filename="CustomerWise"+day+""+mon+""+yr+""+n+""+s+""+ms+".xlsx";
            
            $scope.quotation.filename="CustomerWise"+day+""+mon+""+yr+""+n+""+s+""+ms;
            
            $http.post('app/pricingreport/customerwise', $scope.quotation).success(function(data) {
                

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
    }
  
$scope.dateWiseCompare=function(){
    var invaild=false;
    var msg="";
    $scope.quotation.validFrom1 = $('#validFrom1').val();
    $scope.quotation.validTo1 = $('#validTo1').val();
    $scope.quotation.validFrom2 = $('#validFrom2').val();
    $scope.quotation.validTo2 = $('#validTo2').val();
    var msg="";
    var invaild=false;
    if($scope.quotation.validFrom1==undefined || $scope.quotation.validFrom1== ''){
        msg="<li> Please select Vaild From 1</li>";
            invaild=true;
    } if($scope.quotation.validFrom2==undefined || $scope.quotation.validFrom2== ''){
        msg="<li> Please select Vaild From 2</li>";
        invaild=true;
    } if($scope.quotation.validTo1==undefined || $scope.quotation.validTo1== ''){
        msg="<li> Please select Vaild To 1</li>";
        invaild=true;
    } if($scope.quotation.validTo2==undefined || $scope.quotation.validTo2== ''){
        msg="<li> Please select Vaild To 2</li>";
        invaild=true;
    }
    
    if(invaild){
        logger.logError(msg);
    }else{       

        
        var d = new Date();
        var n = d.getMinutes();
        var s = d.getSeconds();
        var mon=Number(d.getMonth())+1;
        var day=d.getDate();
        var yr=d.getFullYear();
        var ms=d.getMilliseconds();
        
     
        
        $scope.filename="DateWise"+day+""+mon+""+yr+""+n+""+s+""+ms+".xlsx";
        
        $scope.quotation.filename="DateWise"+day+""+mon+""+yr+""+n+""+s+""+ms;
        
        $http.post('app/pricingreport/datewise', $scope.quotation).success(function(data) {
            

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
 $scope.clearData=function(obj){
        
        if(obj=='fromCust'){
            $scope.quotation.fromCust='';
            $('#fromCust_id .selectivityId').click();
        }
        else if(obj=='toCust'){
            $scope.quotation.toCust='';
            $('#toCust_id .selectivityId').click();
        }
       
       
    }
    
    $scope.getDropdownvalue();
    
});
