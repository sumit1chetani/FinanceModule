'use strict';
app.controller('qtyRateReportCtrl', function($scope, $rootScope, $http, logger, $log, ngDialog, $modal, $location, $filter, utilsService) {
    $('#validFromDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime: false
    })
    $('#validToDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime: false
    })
    $scope.qtyrate = {
        mloshtname : '',
        validFrom : '',
        pod : '',
        pol : '',
        validTo : '',
        quotationNo : '',
        contType : '',
        sector:''
    };
    $scope.containerList=[];
    $scope.messageHeaderList = [];
    $scope.port=[];
    $scope.mlomaster=[];
    $scope.sectorList =[];
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
    $scope.termsofshipmentList = [];
    $scope.getTermsOfShipment = function() {

        var data = {};
        data["id"] = "FI/FO";
        data["text"] = "FI/FO";
        $scope.termsofshipmentList.push(data);
        data = {};
        data["id"] = "CY/FO";
        data["text"] = "CY/FO";
        $scope.termsofshipmentList.push(data);
        data = {};
        data["id"] = "FI/CY";
        data["text"] = "FI/CY";
        $scope.termsofshipmentList.push(data);
        data = {};
        data["id"] = "FI/HK";
        data["text"] = "FI/HK";
        $scope.termsofshipmentList.push(data);
        data = {};
        data["id"] = "HK/FO";
        data["text"] = "HK/FO";
        $scope.termsofshipmentList.push(data);
        data = {};
        data["id"] = "HK/CY";
        data["text"] = "HK/CY";
        $scope.termsofshipmentList.push(data);
        data = {};
        data["id"] = "CY/HK";
        data["text"] = "CY/HK";
        $scope.termsofshipmentList.push(data);

        data = {};
        data["id"] = "CY/CY";
        data["text"] = "CY/CY";
        $scope.termsofshipmentList.push(data);
        data = {};
        data["id"] = "FI/TK";
        data["text"] = "FI/TK";
        $scope.termsofshipmentList.push(data);
        data = {};
        data["id"] = "TK/FO";
        data["text"] = "TK/FO";
        $scope.termsofshipmentList.push(data);
        
        data = {};
        data["id"] = "CY/TK";
        data["text"] = "CY/TK";
        $scope.termsofshipmentList.push(data);
        
        data = {};
        data["id"] = "TK/CY";
        data["text"] = "TK/CY";
        $scope.termsofshipmentList.push(data);
        
        
        data = {};
        data["id"] = "HK/TK";
        data["text"] = "HK/TK";
        $scope.termsofshipmentList.push(data);
        
        data = {};
        data["id"] = "TK/HK";
        data["text"] = "TK/HK";
        $scope.termsofshipmentList.push(data);
        
        
        
    }
    $scope.getDropdownvalue = function() {
        $http.get('app/quantityRate/reportDesign').success(function(datas) {
            $scope.messageHeaderList  = datas.headerList;
            
        }).error(function(data) {

        });

        $http.get('app/Quotation/getMloMaster').success(function(datas) {
            $scope.mlomaster = datas.lQuotationBean;
        }).error(function(data) {

        });
        $http.get('app/commonUtility/getSector').success(function(datas) {
            $scope.sectorList = datas.commonUtilityBean;
        }).error(function(data) {

        });

        $http.get('app/TransQuot/getPort').success(function(datas) {
            $scope.port = datas;
        }).error(function(data) {

        });
        $scope.getContainerTypeList();
        $scope.getTermsOfShipment();
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
    $scope.resetData=function(){
        $scope.qtyrate = {
                mloshtname : '',
                validFrom : '',
                pod : '',
                pol : '',
                validTo : '',
                quotationNo : '',
                contType : '',
                sector:'',
                shipmentterms:''
                    
            };
        
        $scope.rowCollection = [];
    }

    $scope.exportData = function(qtyrate) {
        console.log(qtyrate);
        $scope.searchObject = {
            mloshortname : '',
            validfrom : '',
            pod : '',
            pol : '',
            validto : '',
            quotationNo : '',
            contType:'',
            sector:'',
            shipmentterms:''
        };

        $scope.qtyrate.validFrom = $('#validFrom').val();
        $scope.qtyrate.validTo = $('#validTo').val();
        
        var d = new Date();
        var n = d.getMinutes();
        var s = d.getSeconds();
        var mon=Number(d.getMonth())+1;
        var day=d.getDate();
        var yr=d.getFullYear();
        var ms=d.getMilliseconds();
        
       
        $scope.filename="QtyrateReport"+day+""+mon+""+yr+""+n+""+s+""+ms+".xls";
        
        $scope.qtyrate.filename="QtyrateReport"+day+""+mon+""+yr+""+n+""+s+""+ms;

        $scope.obj={
                bean:$scope.qtyrate,
                lQuantityRateReportBean:$scope.rowCollection
        }

        console.log($scope.qtyrate);
        $http.post('app/quantityRate/viewExcel', $scope.obj).success(function(data) {
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
    $scope.search = function(qtyrate) {
        console.log(qtyrate);
        $scope.searchObject = {
            mloshortname : '',
            validfrom : '',
            pod : '',
            pol : '',
            validto : '',
            quotationNo : '',
            shipmentterms:''
        };
        $scope.rowCollection = [];
        $scope.qtyrate.validFrom = $('#validFrom').val();
        $scope.qtyrate.validTo = $('#validTo').val();

       

        console.log($scope.qtyrate);
        $http.post('app/quantityRate/list', $scope.qtyrate).success(function(data) {
            if (data.success == true) {
                $scope.pushTranslationListUtil(data);
                
                if($scope.qtyrate.contType !=''){
                
                    angular.forEach($scope.messageHeaderList, function(column, index) {
                        column.visible=true;
                        if(column.title!='TERMS OF SHIPMENT' && column.title!='Quotation' && column.title!='Quotation Date' &&
                                column.title!='POL' &&   column.title!='POL' && column.title!='POD' && column.title!='Valid From' 
                                && column.title!='Valid To' && column.title !=$scope.qtyrate.contType){
                            column.visible=false;
                        }
                       
                    });
                }
               
            } else {

                $scope.showEmptyLabel = true;

                logger.logError("Error Please Try Again");
            }
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
    }

    $scope.pushTranslationListUtil = function(data) {
        if (utilsService.isUndefinedOrNull(data.lQuantityRateReportBean)) {

            $scope.showEmptyLabel = true;

        } else {

            $scope.rowCollection = $scope.rowCollection.concat(data.lQuantityRateReportBean);

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
