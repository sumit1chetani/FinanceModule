/**
 * list page
 */
app.controller('corgBySectorCtrl', function($scope,$filter, $controller,$window, $rootScope, $location, $http, logger, $log, 
        ngDialog, $modal, utilsService,$state,validationService,toaster,$stateParams) {

    $scope.dataLoopCount = 0;
    $scope.from = 0;
    $scope.to = 100;
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.isDelete=true;
    $scope.isUpload=true;
    $scope.companyList =[];
    
/*    $scope.getDropDownList = function() {
        $http.get('app/sailingsreport/getCompanyList').success(function(data) {
            $scope.companyList = data;
        }).error(function(data) {
        });
    };
    $scope.getDropDownList();*/
    
    $scope.yearList = [ {
        id : '2017',
        text : '2017'
    }, {
        id : '2016',
        text : '2016'
    },{
        id : '2015',
        text : '2015'
    },{
        id : '2014',
        text : '2014'
    },{
        id : '2013',
        text : '2013'
    },{
        id : '2012',
        text : '2012'
    }, {
        id : '2011',
        text : '2011'
    },];
    
    
    /*$scope.companyList = [ {
        id : 'C0003',
        text : 'SINGAPORE'
    }, {
        id : 'C0001',
        text : 'DUBAI'
    }, 
    ]*/
    $http.get($stateParams.tenantid+'/app/usermaster/getCompanyList?formCode='+$('#form_code_id').val()).success(function(datas) {
        debugger;           
        $scope.companyList = datas; 
       
        
        console.log("company")
        console.log($scope.companyList)
        var foundItemDest = $filter('filter')($scope.companyList, { baseCompany:  1 })[0];
        $scope.coreBySector.company=foundItemDest.id;
        
        /* 
        $timeout(function() {
            $('#txtCompanyCode').multiselect('deselectAll', false);
            $('#txtCompanyCode').multiselect('updateButtonText');
            $("#txtCompanyCode").multiselect('rebuild');
        
        }, 2, false);
        $("#multiselect-button").addClass("width_100 input-sm line-height-5");*/
        }).error(function(datas) {
    });
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
    },{
        id : '14',
        text : '14'
    },{
        id : '15',
        text : '15'
    },{
        id : '16',
        text : '16'
    },{
        id : '17',
        text : '17'
    },{
        id : '18',
        text : '18'
    },{
        id : '19',
        text : '19'
    },{
        id : '20',
        text : '20'
    },{
        id : '21',
        text : '21'
    },{
        id : '22',
        text : '22'
    },{
        id : '23',
        text : '23'
    },{
        id : '24',
        text : '24'
    },{
        id : '25',
        text : '25'
    },{
        id : '26',
        text : '26'
    },{
        id : '27',
        text : '27'
    },{
        id : '28',
        text : '28'
    },{
        id : '29',
        text : '29'
    },{
        id : '30',
        text : '30'
    },{
        id : '31',
        text : '31'
    },{
        id : '32',
        text : '32'
    },{
        id : '33',
        text : '33'
    },{
        id : '34',
        text : '34'
    },{
        id : '35',
        text : '35'
    },{
        id : '36',
        text : '36'
    },{
        id : '37',
        text : '37'
    },{
        id : '38',
        text : '38'
    },{
        id : '39',
        text : '39'
    },{
        id : '40',
        text : '40'
    },{
        id : '41',
        text : '42'
    },{
        id : '43',
        text : '43'
    },{
        id : '44',
        text : '44'
    },{
        id : '45',
        text : '45'
    },{
        id : '46',
        text : '46'
    },{
        id : '47',
        text : '47'
    },{
        id : '48',
        text : '48'
    },{
        id : '49',
        text : '49'
    },{
        id : '50',
        text : '50'
    },{
        id : '51',
        text : '51'
    },{
        id : '52',
        text : '52'
    },];
    
    $scope.coreBySector = {
            company : 'C0001',
            year : '2017',
            week : '',
            reportType : 'C',
            cumulative : true,
            sfpl : '1'
                
            
    }
    $scope.weekEndDate='';
   // $scope.coreBySector.year = $scope.yearList[0];
    $scope.$watch('coreBySector.week', function(newValue, oldValue) {
        debugger;
        if (newValue != '' && newValue != undefined) {
        $http.post($stateParams.tenantid+'/app/corg/getweekenddate', $scope.coreBySector).success(function(data) {
            if(data.success){
                $scope.weekEndDate =data.weekEndDate;
                console.log( $scope.weekEndDate);
            }else{
                logger.logError("Error Please Try Again");
            }
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
        }
    });
    
    $scope.$watch('coreBySector.year', function(newValue, oldValue) {
        debugger;
        if (newValue != '' && newValue != undefined) {
        $http.post($stateParams.tenantid+'/app/corg/getweekenddate', $scope.coreBySector).success(function(data) {
            if(data.success){
                $scope.weekEndDate =data.weekEndDate;
                console.log( $scope.weekEndDate);
            }else{
                logger.logError("Error Please Try Again");
            }
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
        }
    });


    $scope.headerlist =[];
    $scope.detaillist =[];
    $scope.search = function(coreBySectorForm) {
        if (new validationService().checkFormValidity($scope.coreBySectorForm)) {
            $http.post($stateParams.tenantid+"/app/CorgBySector/list", $scope.coreBySector).success(function(response) {
                console.log("final result")
                console.log(response)
                $scope.headerlist = response.header;
                $scope.rowCollection = response.detail;
    
            }).error(function(result) {
                logger.logError("Error Please Try Again");
            });
        }else {
            toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.coreBySectorForm.$validationSummary), 555000, 'trustedHtml');
        }

    }
    
    $scope.search1 = function(coreBySectorForm) {
        $scope.rowCollection1 = [];
        $scope.rowCollection2 = [];
        $scope.rowCollection3 = [];
        if (new validationService().checkFormValidity($scope.coreBySectorForm)) {
            $http.post($stateParams.tenantid+"/app/CorgBySector/corgList", $scope.coreBySector).success(function(response) {
                console.log("final result")
                console.log(response)
                $scope.headerlist = response.header;
                $scope.rowCollection = response.detail;
                $scope.rowCollection1 = $scope.rowCollection[$scope.rowCollection.length-4];
                $scope.rowCollection2 = $scope.rowCollection[$scope.rowCollection.length-3];
                for(var i = 0;i < $scope.rowCollection1.length ;i++){
                    if(i!=0)
                        $scope.rowCollection3[i] = $scope.rowCollection1[i]-$scope.rowCollection2[i];
                    else
                        $scope.rowCollection3[i] = "7. PROFIT"
                }
                $scope.rowCollection.push($scope.rowCollection3);
            }).error(function(result) {
                logger.logError("Error Please Try Again");
            });
        }else {
            toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.coreBySectorForm.$validationSummary), 555000, 'trustedHtml');
        }

    }
    
    $scope.excel=function(){
        
        var objWholeData = {
           'lEmpmasterBeanHeader'  :  $scope.headerlist  ,   
           'lEmpmasterBeanDetail'  :  $scope.rowCollection  
           
                          };  
        
       console.log("report")
        console.log(objWholeData)
                        $http.post($stateParams.tenantid+"/app/CorgBySector/generateExcel",$scope.coreBySector).success(function(response) {
                       $('#exportXl').append('<a id="tbExcelExport" stype="display:none" href="filePath/CorgBySector.xlsx" download="CorgBySector.xlsx"></a>');
                                $("#tbExcelExport").bind('click', function() {
                                });
                                $('#tbExcelExport').simulateClick('click');
                
                         }).error(function(result) {
                             logger.logError("Error Please Try Again");
                         });
                                       $.fn.simulateClick = function() {   return this.each(function() {
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
    
})