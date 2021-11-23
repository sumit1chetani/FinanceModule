'use strict';
app.controller('voyagePLCtrl', function($scope, $rootScope, $http, $location, logger, $log, ngDialog, $modal, utilsService,$state) {
    
    $scope.voyagePL = {
        vesselId : '',
        vesselName : '',
        voyageNo : '',
        isEdit : false
    };
    
    $scope.getDropdownvalue = function() {

        
        //Get Vessel dropDown
        var formCode = $('#form_code_id').val();
        $http.post('portCosting/vessel', formCode).success(function(data) {
            $scope.vesselList = data.vesselList;
        });
    };
    
    $scope.$watch('voyagePL.vesselId', function(newValue, oldValue) {
        $scope.voyagePL.voyageNo = ''
        $scope.voyageList = [];
        if(newValue != ''){
            $scope.onChangeVessel($scope.voyagePL.vesselId);
        }
    });
    
  //Get Voyage dropDown
    $scope.onChangeVessel = function(vesselId) {
        $http.post('voyagePL/voyage', vesselId).success(function(data) {
            $scope.voyageList = data.voyageList;
            console.log( $scope.voyageList);
            $('#voyageNo').on('selectivity-selected',function(obj){
                $scope.voyagePL.voyageNo = obj.item.voyageNo;
            });
        });
    };  
    
    $scope.getDropdownvalue();    
    
    $scope.resetAll = function(){
        $('#vesselId').find('.fa-remove').click();
        $('#voyageNo').find('.fa-remove').click();
    }
    
    $scope.exportData = function() {
        var url = 'voyagePL/exportExcel?voyage=' + $scope.voyagePL.voyageNo ;
        $http.get(url).success(function(data) {
            if (data.success == true) {
                logger.logSuccess("Report Exported successfully!");
            
                $('#exportXl').append('<a id="tbExcelExport" stype="display:none" href="filePath/VoyagePL.xlsx" download="VoyagePL.xlsx"></a>');
                $("#tbExcelExport").bind('click', function() {
                 });
                 $('#tbExcelExport').simulateClick('click');
            }
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
    }
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

    
