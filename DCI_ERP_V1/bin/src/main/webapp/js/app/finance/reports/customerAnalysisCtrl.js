'use strict';
app.controller('customeranalysisCtrl', function($templateCache, $timeout, $scope, $rootScope, $http, logger, $log, ngDialog, $modal, $location, $sce, $filter,$stateParams) {

    $('#fromDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime : false
    });

    $('#toDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime : false
    });

    $scope.sailingsReport = {
        companyCode : 'C0000',
        fromDate : '',
        toDate : '',
        voyage : '',
        sectorName : '',
        mlo : '',
        mlos : '',
        vessel : '',
        top : '10',
        year : new Date().getFullYear().toString(),
        previousYear :false
    };

    $scope.pageCounters = [ 10, 15, 25, 50, 75, 100, 125, 150 ];
    $scope.itemsByPage = 10;
    $scope.companyList = [];
    $scope.mloList = [];
    $scope.sectorList = [];
    $scope.vesselist=[];
    $scope.voyageList=[];
    $scope.rowCollection=[];
    $scope.yearList = [ 
{
    id : '2010',
    text : '2010'
},
{
    id : '2011',
    text : '2011'
},
{
    id : '2012',
    text : '2012'
},
{
    id : '2013',
    text : '2013'
},
{
    id : '2014',
    text : '2014'
},
{
    id : '2015',
    text : '2015'
},
{
    id : '2016',
    text : '2016'
},
{
    id : '2017',
    text : '2017'
},
{
    id : '2018',
    text : '2018'
},
{
    id : '2019',
    text : '2019'
},
{
    id : '2020',
    text : '2020'
},
{
    id : '2021',
    text : '2021'
},
{
    id : '2022',
    text : '2022'
},
{
    id : '2023',
    text : '2023'
},
{
    id : '2024',
    text : '2024'
},
                        {
        id : '2025',
        text : '2025'
    }, {
        id : '2026',
        text : '2026'
    }, ]

    $scope.monthList = [ {
        "id" : "00",
        "text" : "ALL"
    }, {
        "id" : "01",
        "text" : "JANUARY"
    }, {
        "id" : "02",
        "text" : "FEBRUARY"
    }, {
        "id" : "03",
        "text" : "MARCH"
    }, {
        "id" : "04",
        "text" : "APRIL"
    }, {
        "id" : "05",
        "text" : "MAY"
    }, {
        "id" : "06",
        "text" : "JUNE"
    }, {
        "id" : "07",
        "text" : "JULY"
    }, {
        "id" : "08",
        "text" : "AUGUST"
    }, {
        "id" : "09",
        "text" : "SEPTEMBER"
    }, {
        "id" : "10",
        "text" : "OCTOBER"
    }, {
        "id" : "11",
        "text" : "NOVEMBER"
    }, {
        "id" : "12",
        "text" : "DECEMBER"
    } ];

    $scope.weekList = [ {
        id : '01',
        text : '01'
    }, {
        id : '02',
        text : '02'
    }, {
        id : '03',
        text : '03'
    }, {
        id : '04',
        text : '04'
    }, {
        id : '05',
        text : '05'
    }, {
        id : '06',
        text : '06'
    }, {
        id : '07',
        text : '07'
    }, {
        id : '08',
        text : '08'
    }, {
        id : '09',
        text : '09'
    }, {
        id : '10',
        text : '10'
    }, {
        id : '11',
        text : '11'
    }, {
        id : '12',
        text : '12'
    }, {
        id : '13',
        text : '13'
    }, {
        id : '14',
        text : '14'
    }, {
        id : '15',
        text : '15'
    }, {
        id : '16',
        text : '16'
    }, {
        id : '17',
        text : '17'
    }, {
        id : '18',
        text : '18'
    }, {
        id : '19',
        text : '19'
    }, {
        id : '21',
        text : '21'
    }, {
        id : '22',
        text : '22'
    }, {
        id : '23',
        text : '23'
    }, {
        id : '24',
        text : '24'
    }, {
        id : '25',
        text : '25'
    }, {
        id : '26',
        text : '26'
    }, {
        id : '27',
        text : '27'
    }, {
        id : '28',
        text : '28'
    }, {
        id : '29',
        text : '29'
    }, {
        id : '30',
        text : '30'
    }, {
        id : '31',
        text : '31'
    }, {
        id : '32',
        text : '32'
    }, {
        id : '33',
        text : '33'
    }, {
        id : '34',
        text : '34'
    }, {
        id : '35',
        text : '35'
    }, {
        id : '36',
        text : '36'
    }, {
        id : '37',
        text : '37'
    }, {
        id : '38',
        text : '38'
    }, {
        id : '39',
        text : '39'
    }, {
        id : '40',
        text : '40'
    }, {
        id : '41',
        text : '42'
    }, {
        id : '43',
        text : '43'
    }, {
        id : '44',
        text : '44'
    }, {
        id : '45',
        text : '45'
    }, {
        id : '46',
        text : '46'
    }, {
        id : '47',
        text : '47'
    }, {
        id : '48',
        text : '48'
    }, {
        id : '49',
        text : '49'
    }, {
        id : '50',
        text : '50'
    }, {
        id : '51',
        text : '51'
    }, {
        id : '52',
        text : '52'
    }, ];

    $scope.topList = [ {
        id : '10',
        text : '10'
    }, {
        id : '20',
        text : '20'
    }, {
        id : '30',
        text : '30'
    }, ]

    $scope.formreset = function() {
        $scope.sailingsReport = {
                companyCode : 'C0000',
                fromDate : '',
                toDate : '',
                voyage : '',
                sectorName : '',
                mlo : '',
                mlos : '',
                vessel : '',
                top : '10',
                previousYear :false
            };
        $scope.rowCollection=[];
    };
   
    $scope.getDropDownList = function() {

        $http.get($stateParams.tenantid+'/app/containerphcrates/getlocation').success(function(datas) {
            var tempList = [];
            for (var i = 0; i < datas.length; i++) {         
                tempList.push({
                   id: datas[i].location, 
                   text:  datas[i].locationname
               });
            }
            tempList.push({ id: 'C0000',text:  'ALL'  });
            $scope.companyList=tempList;
            //$scope.ContainerRateMasterData.location="C0003";
       }).error(function(data) {
        });  
        
        /*$http.get('app/customerAnalysis/getCompanyList').success(function(data) {
            $scope.companyList = data;
        });*/

        $http.get($stateParams.tenantid+'/app/customerAnalysis/getMLO').success(function(data) {
         $scope.mloList = data;
         console.log("mlo")
         console.log($scope.mloList)
        $timeout(function() {
                
                $("#txtCustomerCode").multiselect({
                    maxHeight: 400,
                    includeSelectAllOption: true,
                    selectAllText: 'Select All',
                    enableFiltering: true,
                    enableCaseInsensitiveFiltering: true,
                    filterPlaceholder: 'Search',
                    onChange: function(element, checked) {
                      var mlos = "", jvpShortNames="";
                      console.log("mlo")
                      console.log($scope.sailingsReport.mlo)
                      if($scope.sailingsReport.mlo.length>0){
                          debugger;
                          angular.forEach($scope.sailingsReport.mlo, function (item, key) {
                              if($scope.sailingsReport.mlo.length>0){
                                  if($scope.sailingsReport.mlo[key]!=undefined){
                                      
                                      var mlo = item.id;
                                      
                                      if(mlos==""){
                                          mlos = item.id;
                                      }else{
                                          mlos +=","+ item.id;
                                      }       
                                      $scope.sailingsReport.mlos = mlos;
                                  }                             
                              }                              
                          });
                      }else{
                          $scope.sailingsReport.mlos = '';
                      }
                      console.log( $scope.sailingsReport.mlos );
                    }
                  });
                
                $("#multiselect-button").addClass("width_100 input-sm line-height-5");
                
                }, 2, false);
        });

        $http.get($stateParams.tenantid+'/app/commonUtility/getSector').success(function(data) {
            $scope.sectorList = data.commonUtilityBean;
        });
        
        $http.post($stateParams.tenantid+'/app/commonUtility/getVesselList').success(function(data) {
            $scope.tempvesselist = data;
            $scope.vesselist = data;
        });
    };

    $scope.getDropDownList();

    $scope.$watch('sailingsReport.sectorName', function(newValue, oldValue) {
       /* if (newValue != '' && newValue != undefined) {
         var vesselFilterList=[];
         vesselFilterList=$filter('filter')($scope.vesselist,{
             sectorCode : newValue
         },true);
         $scope.vesselist=[];
         $scope.vesselist=vesselFilterList;
        }else{
            $scope.vesselist=$scope.tempvesselist;
        }*/
        if (newValue != '' && newValue != undefined) {
            var url = $stateParams.tenantid+'/app/commonUtility/getSectorVessel?sectorCode=' + newValue;
            $scope.vesselist=[];
            $http.post(url).success(function(data) {
                $scope.vesselist = data;
         });
        }else{
            $scope.vesselist=$scope.tempvesselist;
        }
    });
    
    

    $scope.$watch('sailingsReport.vessel', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
            var url = $stateParams.tenantid+'/app/loadingSummary/voyageList?vesselCode=' + newValue;
            $http.get(url).then(function(result) {
                $scope.voyageList = result.data;
            });
        }
    });
    
    /*$scope.$watch('sailingsReport.previousYear', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
            $scope.rowCollection=[];
        }else if(newValue || !newValue){
            $scope.rowCollection=[];
        }
    });*/
    


    $scope.viewTrialBalanceReport = function() {
        console.log("report")
        console.log($scope.sailingsReport)
        if($scope.sailingsReport.previousYear){
            $scope.sailingsReport = {companyCode : 'C0000', voyage : '',sectorName : '',mlos : '',vessel : '',top : '',previousYear : true};
        }
        console.log("final")
        console.log($scope.sailingsReport.mlos)
/*           if($scope.sailingsReport.mlos !=''){*/
        $http.post($stateParams.tenantid+'/app/customerAnalysis/getCustomerAnalysisReport', $scope.sailingsReport).success(function(data) {
            if (data.success == true) {
                $scope.rowCollection = data.customerAnalysisReportList;
                if ($scope.rowCollection.length == 0) {
                    logger.logError("No Records Found!...");
                }
            } else {
                logger.logError("Some errors occured.Please try again!...");
            }

        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
    /*       }
           else
               {
               if($scope.sailingsReport.mlos == '')
                   logger.logError("Please select Customer");
               
               }*/
    };
    $scope.exportTBExcel = function() {
        if($scope.sailingsReport.previousYear){
            $scope.sailingsReport = {companyCode : 'C0000', voyage : '',sectorName : '',mlos : '',vessel : '',top : '',previousYear : true};
        }
        $http.post($stateParams.tenantid+'/app/customerAnalysis/excelExport', $scope.sailingsReport).success(function(data) {
            if (data.success == true) {
                $("#custAnalysisExport").bind('click', function() {
                });
                $('#custAnalysisExport').simulateClick('click');
                logger.logSuccess("Exported successfully!");
            } else {
                logger.logError("Failed to Export!..");
            }

        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
    };

    
    $scope.rateAgainstExcel=function(){        
    
                var d = new Date();
                var n = d.getMinutes();
                var s = d.getSeconds();
                var mon=Number(d.getMonth())+1;
                var day=d.getDate();
                var yr=d.getFullYear();
                var ms=d.getMilliseconds();
              //  $scope.sailingsReport.mlos='';
                if($scope.sailingsReport.mlos!=undefined){
                    $scope.sailingsReport.mlos=$scope.sailingsReport.mlos.split(",").join("','");
                }
                if($scope.sailingsReport.year==undefined || $scope.sailingsReport.year=='' ){
                    logger.logError("Please select YEAR");
                    
                    return ;
                }
          
                
                $scope.filename="RATES_AGT_LOAD_AVGS"+day+""+mon+""+yr+""+n+""+s+""+ms+".xls";
                
                $scope.sailingsReport.filename="RATES_AGT_LOAD_AVGS"+day+""+mon+""+yr+""+n+""+s+""+ms;
                
            
                $http.post($stateParams.tenantid+'/app/customerAnalysis/rateAgainstExcel',$scope.sailingsReport).success(function(result) {
                    $('#exportXl').remove();
                    $('.test').append('<div id="exportXl"></div>');
                  var file='<a id="tbExcelExport" stype="display:none" href="filePath/'+$scope.filename+'" download="'+$scope.filename+'"></a>'
                        
                           $('#exportXl').append(file);
                           $("#tbExcelExport").bind('click', function() {
                           });
                           $('#tbExcelExport').simulateClick('click');
                    
                    }).error(function(data) {
                        logger.logError("Error Please Try Again");
                    });
             
  
            
        
    }
    
    
    $scope.rateJvAgainstExcel=function(){        
        
        var d = new Date();
        var n = d.getMinutes();
        var s = d.getSeconds();
        var mon=Number(d.getMonth())+1;
        var day=d.getDate();
        var yr=d.getFullYear();
        var ms=d.getMilliseconds();
      //  $scope.sailingsReport.mlos='';
        if($scope.sailingsReport.mlos!=undefined){
            $scope.sailingsReport.mlos=$scope.sailingsReport.mlos.split(",").join("','");
        }
        if($scope.sailingsReport.year==undefined || $scope.sailingsReport.year=='' ){
            logger.logError("Please select YEAR");
            
            return ;
        }
  
        
        $scope.filename="RATES_JV_AGT_LOAD_AVGS"+day+""+mon+""+yr+""+n+""+s+""+ms+".xls";
        
        $scope.sailingsReport.filename="RATES_JV_AGT_LOAD_AVGS"+day+""+mon+""+yr+""+n+""+s+""+ms;
        
    
        $http.post($stateParams.tenantid+'/app/customerAnalysis/rateJvAgainstExcel',$scope.sailingsReport).success(function(result) {
            $('#exportXl').remove();
            $('.test').append('<div id="exportXl"></div>');
          var file='<a id="tbExcelExport" stype="display:none" href="filePath/'+$scope.filename+'" download="'+$scope.filename+'"></a>'
                
                   $('#exportXl').append(file);
                   $("#tbExcelExport").bind('click', function() {
                   });
                   $('#tbExcelExport').simulateClick('click');
            
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