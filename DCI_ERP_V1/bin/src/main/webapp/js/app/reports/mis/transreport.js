app.controller('transReportCtrl', function($scope, $rootScope, $http, logger, $log, ngDialog, $modal, $location, $filter, utilsService,validationService,toaster) {
    $('#fromdateDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime: false
    })
    $('#todateDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime: false
    })
    $scope.portList=[];
    $scope.mloList=[];
    $scope.messageHeaderList =[];
    $scope.rowCollection=[];
    $scope.serviceList=[];
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
    $scope.dropdown=function(){
        $scope.translo={
                pot:'',
                orginport:'',
                mlo:'',
                fromdate:'',
                service:'',
                todate:'',
                disRotation:'',
                loadRotation:'',
                loadVoyage:'',
                disVoyage:''
        }
        $http.get('app/TransQuot/getPort').success(function(datas) {
            $scope.portList = datas;
        }).error(function(data) {

        });
        
        $http.get('app/transreport/reportDesign').success(function(datas) {
            $scope.messageHeaderList  = datas.headerList;
            
        }).error(function(data) {

        });
        
        $http.get('app/Quotation/getMloMaster').success(function(datas) {
            $scope.mloList = datas.lQuotationBean;
        }).error(function(data) {

        });
        $http.get('app/commonUtility/getSector').success(function(datas) {
            $scope.serviceList = datas.commonUtilityBean;
        }).error(function(data) {

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
    
$scope.excel=function(translo){
        var d = new Date();
        var n = d.getMinutes();
        var s = d.getSeconds();
        var mon=Number(d.getMonth())+1;
        var day=d.getDate();
        var yr=d.getFullYear();
        var ms=d.getMilliseconds();
        
        $scope.translo.fromdate = $('#fromdate').val();
        $scope.translo.todate = $('#todate').val();
        
        $scope.filename="TransReport"+day+""+mon+""+yr+""+n+""+s+""+ms+".xlsx";
        
        $scope.translo.filename="TransReport"+day+""+mon+""+yr+""+n+""+s+""+ms;
        
        $scope.obj={
                headerList:$scope.messageHeaderList,
                bTransReportBean:$scope.translo,
                lTransReportBean:[]
        }
        if (new validationService().checkFormValidity(translo)) {
        $http.post('app/transreport/excellexport', $scope.translo).success(function(data) {
            

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
        }else {
            toaster.pop('error', "Please fill the required fields", 
                    logger.getErrorHtmlNew(translo.$validationSummary), 5000, 'trustedHtml');
        }
        
    }
    $scope.getData=function(){
        
        $scope.translo.fromdate = $('#fromdate').val();
        $scope.translo.todate = $('#todate').val();
        $http.post('app/transreport/reportData',$scope.translo).success(function(datas) {
            $scope.rowCollection  = datas.lTransReportBean;            
        }).error(function(data) {

        });
        
    }
    $scope.reset=function(){
        $scope.translo={
                pot:'',
                orginport:'',
                mlo:'',
                fromdate:'',
                service:'',
                todate:'',               
                disRotation:'',
                loadRotation:'',
                loadVoyage:'',
                disVoyage:''
        }
        $scope.rowCollection=[];
    }
    $scope.dropdown();
    
});