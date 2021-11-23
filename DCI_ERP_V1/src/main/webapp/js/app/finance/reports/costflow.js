app.controller('costflowCtri', function($scope, $stateParams, validationService, $rootScope, $http, logger, $log, 
        ngDialog, $timeout, $modal, $injector, sharedProperties, $location, $filter, utilsService, toaster,$stateParams) {
    
    $scope.costflow={
            pol:'',
            customer:'',
            pod:'',
            slot:'',
            validTo:'',
            validFrom:'',
            jvtype:'',
            voyage:'',
            sector:''
    }
    $scope.portList=[];
    $scope.slotList=[];
    $scope.customerList=[];
    $scope.reportData=[];
    $scope.voyageList=[];
    $scope.jvTypeList=[];
    $scope.reset=function(){
        $scope.reportData=[];
        $scope.costflow={
                pol:'',
                customer:'',
                pod:'',
                slot:'',
                validTo:'',
                validFrom:'',
                jvtype:'',
                voyage:'',
                sector:''
        }
    }
 

    
       $("#voyage_id").multiselect({
        maxHeight: 200,   
        includeSelectAllOption: true,
        disableIfEmpty: true,
        enableCaseInsensitiveFiltering: true,
        onDropdownHide: function (event) {
            
        }
      });
    $("#multiselect-button").addClass("width_100 input-sm line-height-5");
    $http.get($stateParams.tenantid+'/app/commonUtility/getSector').success(function(datas) {
        $scope.sectorList = datas.commonUtilityBean;
    }).error(function(data) {

    });
    $http.get($stateParams.tenantid+'/transbooking/request/slot').success(function(datas) {
        $scope.slotList = datas.slotList;
    }).error(function(data) {

    });
    
  
    
    $http.get($stateParams.tenantid+'/app/jvreport/voyage').success(function(datas) {
        $scope.voyageList = datas.lJvTariffBean;
        
        $timeout(function() {
            $('#voyage_id').multiselect('deselectAll', false);
            $('#voyage_id').multiselect('updateButtonText');
            $("#voyage_id").multiselect('rebuild');
        
        }, 2, false);
        
        }).error(function(datas) {
    });
  
    
    
    $http.get($stateParams.tenantid+'/app/jvTariff/getJvPartner').success(function(datas) {
        $scope.jvPartnerList = datas.lJvTariffBean;
    }).error(function(data) {

    });
 
    
    
    
    
    
    $scope.excel=function(){  
        
      
        $scope.costflow.voyage='';
        if($scope.voyage.length>0){
            $scope.costflow.voyage=$scope.voyage.join(",");
        }
        
        if($scope.costflow.jvtype ==undefined ||    $scope.costflow.jvtype =='' ||   $scope.costflow.jvtype ==null ||   $scope.costflow.jvtype =='undefined'){
            logger.logError("Please select jv type");
            return false;
        }       
        var d = new Date();
        var n = d.getMinutes();
        var s = d.getSeconds();
        var mon=Number(d.getMonth())+1;
        var day=d.getDate();
        var yr=d.getFullYear();
        var ms=d.getMilliseconds();
        
        $scope.filename="CostFlow"+day+""+mon+""+yr+""+n+""+s+""+ms+".xlsx";
        
        $scope.costflow.filename="CostFlow"+day+""+mon+""+yr+""+n+""+s+""+ms;
        
        $scope.obj={
                bean:$scope.costflow
        };
        $http.post("app/jointvoureport/cashflowexcel",$scope.obj).success(function(response) {
            $('#exportXl').remove();
            $('.btn-info').append('<div id="exportXl"></div>');
          var file='<a id="tbExcelExport" stype="display:none" href="filePath/'+$scope.filename+'" download="'+$scope.filename+'"></a>'
                
                   $('#exportXl').append(file);
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
  