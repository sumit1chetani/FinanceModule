app.controller('jvTariffreportCtrl', function(
        $scope, $rootScope, $http, logger, $log, ngDialog, $modal, $location, $filter, utilsService,$timeout, $window,$localStorage) {
    $scope.jvtariffreport={
            voyageNo:'',
            vesselId:'',
            jvType:'',
            filename:''
    }
    $http.get('app/TransQuot/getVessel').success(function(datas) {
        $scope.vesselList = datas;       
    }).error(function(data) {

    });
    $http.get('app/jvTariff/getJvPartner').success(function(datas) {
        $scope.jvPartnerList = datas.lJvTariffBean;
    }).error(function(data) {

    });
    $scope.$watch('jvtariffreport.vesselId', function(newValue, oldValue) {
        
        if (newValue != '' && newValue != undefined) {

            $http.post('app/portTariffDetails/voyage', newValue).success(function(datas) {
                $scope.voyageList = datas.lPortTariffBean;
            }).error(function(data) {

            });

        } else {
            $scope.voyageList = [];
            $scope.voyage = '';
            $scope.jvtariffreport.voyageNo = '';

        }
    });
    $scope.checkundefined = function(value) {
        var invalid = false;
        if (value == undefined || value == 'undefined' || value == null || value == 'null' || value == '') {
            invalid = true;
        }
        return invalid;

    }
    $scope.validation=function(){
        var msg='';
        if($scope.checkundefined($scope.jvtariffreport.vesselId)){
            msg="<li>+Please select the vessel+</li>"
        } if($scope.checkundefined($scope.jvtariffreport.voyageNo)){
            msg="<li>+Please select the voyage+</li>"
        } if($scope.checkundefined($scope.jvtariffreport.jvType)){
            msg="<li>+Please select the JV Type+</li>"
        }        
        return msg;
    }
    
    $scope.jvtariffInvoice=function(){
        var msg=$scope.validation();
        if($scope.checkundefined(msg) && msg!=''){
            logger.logError(msg);
        }else{

            
            var d = new Date();
            var n = d.getMinutes();
            var s = d.getSeconds();
            var mon=Number(d.getMonth())+1;
            var day=d.getDate();
            var yr=d.getFullYear();
            var ms=d.getMilliseconds();
            
          
            
            $scope.filename="JVVSINVOICE"+day+""+mon+""+yr+""+n+""+s+""+ms+".xlsx";
            
            $scope.jvtariffreport.filename="JVVSINVOICE"+day+""+mon+""+yr+""+n+""+s+""+ms;
            
            $http.post('app/pricingreport/jvvsinvoiceamt', $scope.jvtariffreport).success(function(data) {
                

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
    
    $scope.jvtariffPendingInvoice=function(){
        var msg=$scope.validation();
        if($scope.checkundefined(msg) && msg!=''){
            logger.logError(msg);
        }else{

            
            var d = new Date();
            var n = d.getMinutes();
            var s = d.getSeconds();
            var mon=Number(d.getMonth())+1;
            var day=d.getDate();
            var yr=d.getFullYear();
            var ms=d.getMilliseconds();
            
          
            
            $scope.filename="JVVSPENDINVOICE"+day+""+mon+""+yr+""+n+""+s+""+ms+".xlsx";
            
            $scope.jvtariffreport.filename="JVVSPENDINVOICE"+day+""+mon+""+yr+""+n+""+s+""+ms;
            
            $http.post('app/pricingreport/jvvspendinginvoice', $scope.jvtariffreport).success(function(data) {
                

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
});
    