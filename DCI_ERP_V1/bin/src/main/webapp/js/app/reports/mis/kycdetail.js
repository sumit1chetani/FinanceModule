app.controller('kycdetailCtrl', function($scope, $rootScope, $http, $filter, $location, logger, $log, ngDialog, $modal, utilsService, sharedProperties, $state, $timeout, $window) {
    
    $http.get('app/Quotation/getMloMaster').success(function(datas) {
        $scope.mloList = datas.lQuotationBean;
    }).error(function(data) {

    });
    $('#validFromDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime : false
    })
    $('#validToDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime : false
    })
        $scope.clearData = function(obj) {
        if (obj == 'MLO') {
            $scope.kyc.customer = '';
            $('#mlo_id .selectivityId').click();
        }
    }
    $('#validTo').val('');
    $('#validFrom').val('');
    $scope.kyc={
            customer:'',
            validfrom:'',
            validto:''
    }
    $scope.resetData=function(){
        $('#validTo').val('');
        $('#validFrom').val('');
        $scope.kyc={
                customer:'',
                validfrom:'',
                validto:''
        }
        $scope.rowCollection=[];
    }
    
    $scope.hideAddIcon = true;
    $scope.hideUploadIcon = true;
    $scope.hideEditIcon = true;
    $scope.hideBreadcrumb = true;
    $scope.showEmptyLabel = false;
    
    $scope.submit = function() {
        $scope.displayedCollection = [];
        $scope.rowCollection = [];
        
        $scope.kyc.validto = $('#validTo').val();
        $scope.kyc.validfrom = $('#validFrom').val();
        $http.post('feeder/mobileApp/kycdetails?customer='+$scope.kyc.customer+"&validfrom="+$scope.kyc.validfrom+"&validtill="+$scope.kyc.validto).success(function(datas) {
            $scope.type = 'notsearch'
            $scope.rowCollection = $scope.rowCollection.concat(datas.mobileCustCommDetail);         
            console.log($scope.rowCollection);
            if ($scope.rowCollection == undefined || $scope.rowCollection.length == 0) {
                logger.logError("No Records found");
            }
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
    
 $scope.excelexport=function(){
        
        var d = new Date();
        var n = d.getMinutes();
        var s = d.getSeconds();
        var mon=Number(d.getMonth())+1;
        var day=d.getDate();
        var yr=d.getFullYear();
        var ms=d.getMilliseconds();
        
        $scope.kyc.validto = $('#validTo').val();
        $scope.kyc.validfrom = $('#validFrom').val();
        $scope.filename="KycDetails"+day+""+mon+""+yr+""+n+""+s+""+ms+".xlsx";
        
        $scope.kyc.filename="KycDetails"+day+""+mon+""+yr+""+n+""+s+""+ms;
        
        $http.post('feeder/mobileApp/excelexport?customer='+$scope.kyc.customer+"&validfrom="+$scope.kyc.validfrom+"&validtill="+$scope.kyc.validto+"&filename="+$scope.kyc.filename).success(function(datas) {
            

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
});