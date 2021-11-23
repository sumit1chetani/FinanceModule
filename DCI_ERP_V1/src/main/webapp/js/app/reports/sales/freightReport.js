'use strict';
app.controller('freightreportCtrl', function($scope, $rootScope, $http, logger, $log, ngDialog, $modal, $location, $filter, utilsService) {
    $('#validFromDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime: false
    })
    $('#validToDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime: false
    })
      $scope.vesselList =[];
    $scope.voyageList=[];
    $scope.freightReport = {
        mloshtname : '',
        validFrom : '',
        pod : '',
        pol : '',
        validTo : '',
        quotationNo : '',
        contType : '',
        vessel:'',
        voyage:''
    };
    
 

    $scope.$watch('freightReport.vessel', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
            $http.post('app/portmsg/voyage', newValue).success(function(datas) {
                $scope.voyageList = datas.commonUtilityBean;

            }).error(function(data) {

            });
        } else {
            $scope.freightReport.voyage = '';
            $scope.voyageList = [];
          
        }
    });
    $scope.containerList=[];
    $scope.messageHeaderList = [];
    $scope.port=[];
    $scope.mlomaster=[];
    $scope.getContainerTypeList = function() {

        var data = {};
        data["id"] = "D20";
        data["text"] = "D20";
        $scope.containerList.push(data);
        data = {};
        data["id"] = "D40";
        data["text"] = "D40";
        $scope.containerList.push(data);
        data = {};
        data["id"] = "M20";
        data["text"] = "M20";
        $scope.containerList.push(data);
        data = {};
        data["id"] = "M40";
        data["text"] = "M40";
        $scope.containerList.push(data);
        data = {};
        data["id"] = "R20";
        data["text"] = "R20";
        $scope.containerList.push(data);
        data = {};
        data["id"] = "R40";
        data["text"] = "R40";
        $scope.containerList.push(data);
      
    }
    $scope.getDropdownvalue = function() {
        $http.get('app/freightReport/reportDesign').success(function(datas) {
            $scope.messageHeaderList  = datas.headerList;
            
        }).error(function(data) {

        });
        
        var formCode = $('#form_code_id').val();
        $http.post('portCosting/vessel', formCode).success(function(data) {
            $scope.vesselList = data.vesselList;
        });

        $http.get('app/Quotation/getMloMaster').success(function(datas) {
            $scope.mlomaster = datas.lQuotationBean;
        }).error(function(data) {

        });

        $http.get('app/TransQuot/getPort').success(function(datas) {
            $scope.port = datas;
        }).error(function(data) {

        });
        $scope.getContainerTypeList();
    }
    
   
    $scope.getDropdownvalue();
    $scope.doMloShortName = function(mloName) {
        $scope.qtyrate.mlo = mloName;
    };

    $scope.doMloName = function(mloName) {
        $scope.qtyrate.mloshtname = mloName;

    };

    $scope.onSelectmlo = function($item, $model, $label) {
        $scope.qtyrate.mlo = $item.mloName;
    };

    $scope.onSelectmloName = function($item, $model, $label) {
        $scope.qtyrate.mloshtname = $item.mloName;

    };

    $scope.exportData = function(qtyrate) {
        console.log(qtyrate);
        $scope.searchObject = {
            mloshortname : '',
            validfrom : '',
            pod : '',
            pol : '',
            validto : '',
            quotationNo : '',
            contType:''
        };

        $scope.freightReport.validFrom = $('#validFrom').val();
        $scope.freightReport.validTo = $('#validTo').val();

 

        console.log($scope.qtyrate);
        $http.post('app/freightReport/viewExcel', $scope.freightReport).success(function(data) {
            $("#tbPdfExport").bind('click', function() {
                //  alert('clicked');

            });
            $('#tbPdfExport').simulateClick('click');
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
    };
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
    
    $scope.reset=function(){
        $scope.freightReport = {
                mloshtname : '',
                validFrom : '',
                pod : '',
                pol : '',
                validTo : '',
                quotationNo : '',
                contType : '',
                vessel:'',
                voyage:''
            };
        $scope.rowCollection=[];
    }
    $scope.search = function(qtyrate) {
      
        $scope.searchObject = {
            mloshortname : '',
            validfrom : '',
            pod : '',
            pol : '',
            validto : '',
            quotationNo : ''
        };
        $scope.rowCollection = [];
        $scope.freightReport.validFrom = $('#validFrom').val();
        $scope.freightReport.validTo = $('#validTo').val();

       

        console.log($scope.qtyrate);
        $http.post('app/freightReport/list', $scope.freightReport).success(function(data) {
            if (data.success == true) {
                $scope.pushTranslationListUtil(data);
                
          
               
            } else {

                $scope.showEmptyLabel = true;

                logger.logError("Error Please Try Again");
            }
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
    }

    $scope.pushTranslationListUtil = function(data) {
        if (utilsService.isUndefinedOrNull(data.lFreightReportBean)) {

            $scope.showEmptyLabel = true;

        } else {

            $scope.rowCollection = $scope.rowCollection.concat(data.lFreightReportBean);

        }
    
    };
    $scope.selectedVisibility = [];
    $scope.getSelectedColumn = function(index) {

        var value = $scope.messageHeaderList.indexOf(index);
        var indexExsists = $scope.selectedVisibility.indexOf(index);
        if (indexExsists == -1) {
            $scope.selectedVisibility.push(value);
        }
     
    };
    
    
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
   
    $scope.visiablefun=function(title){
        var data = $filter('filter')($scope.messageHeaderList, {
            title:""+title
           
        });
        var sdsds=false;
        var index=$scope.messageHeaderList.indexOf(data[0]);
        if($scope.messageHeaderList[index]!=undefined)
         sdsds=$scope.messageHeaderList[index]['visible'];
        
        return sdsds;
    }
});