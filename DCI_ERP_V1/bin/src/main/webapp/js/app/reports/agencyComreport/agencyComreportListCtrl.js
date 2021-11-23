'use strict';

 

app.controller('agencyComreportListCtrl', function($scope,$stateParams,$injector, ngDialog, $rootScope, toaster,$http, $location, logger, utilsService, $state, sharedProperties, $window,AGFService,$controller) {

    $scope.emptyobject = {};
    

    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.vesselList = [];
	$scope.voyageList = [];
	$scope.polList = [];
	$scope.podList = [];
	$scope.typeList = [];
	
    $scope.agencyComReport = {
            year : '',
            month : '',
            vessel : '',
            voyage : ''
            
        }
    
    $scope.typeList=[
		 
		  { id: 'Export', text: 'Export' },
		  { id: 'Import', text: 'Import' }
		
	]
    
    
    $scope.yearList=[
		 
		  { id: '2019', text: '2019' },
		  { id: '2020', text: '2020' },
		  { id: '2021', text: '2021' },
		  { id: '2022', text: '2022' },
		  { id: '2023', text: '2023' },
		  { id: '2024', text: '2024' },
		  { id: '2025', text: '2025' }
		
	]
    
    $scope.monthList=[
		 
		  { id: '1', text: 'January' },
		  { id: '2', text: 'February' },
		  { id: '3', text: 'March' },
		  { id: '4', text: 'April' },
		  { id: '5', text: 'May' },
		  { id: '6', text: 'June' },
		  { id: '7', text: 'July' },
		  { id: '8', text: 'August' },
		  { id: '9', text: 'September' },
		  { id: '10', text: 'October' },
		  { id: '11', text: 'November' },
		  { id: '12', text: 'December' }
		
	]
    
  //Vessel List
	  
	  $http.get($stateParams.tenantid+ '/app/commonUtility/getVesselList').success(function(data) {
			$scope.vesselList = data;
//			$scope.voyageList = data.voyageList;
//			$scope.polList = data.polList;
//			$scope.podList = data.polList;
		});
		
		$scope.$watch('agencyComReport.voyage', function(newValue, oldValue) {
		      if(newValue!=null && newValue!=undefined && newValue != ''){
		    	  $http.post($stateParams.tenantid+ '/app/commonUtility/getPortListByVoy',newValue).success(function(data) {
		    		  $scope.polList = data;
		    	  })
		    	  
		    	  $http.post($stateParams.tenantid+ '/app/commonUtility/getPortListByVoyNU',newValue).success(function(data11) {
		    		  $scope.podList = data11;
		    	  })
		      }
		})
		
		$scope.$watch('agencyComReport.vessel', function(newValue, oldValue) {
		      if(newValue!=null && newValue!=undefined && newValue != '' ){
		    	  $http.post($stateParams.tenantid+ '/app/commonUtility/getVoyageListByVessel',newValue).success(function(data) {
						$scope.voyageList = data;
		    	  });
		      }
		      if(newValue!=null && newValue!=undefined && newValue != '' && $scope.bookViaQt==true){
		    	  $http.post($stateParams.tenantid+ '/app/booking/getVoyListByVsl?pol='+$scope.agencyTariff.pol+'&pod='+$scope.agencyTariff.pod+'&ves='+newValue).success(function(data) {
						$scope.voyageList = data.voyList;
			    	  })
		      }
		    });
		
    /*$scope.onSearch=function(agencyTariff){
        $http.post($stateParams.tenantid+'/app/agencyTariffDetails/search', agencyTariff).success(function(datas) {
            if (datas.success == true) {
                console.log(datas)
                $scope.rowCollection=datas.lAgencyTariffDetailBean;
            }
        }).error(function(datas) {
    
        });
    }*/
		
		$scope.onSearch=function(agencyComReport){
			
						
						$http.post($stateParams.tenantid+'/app/agencyComReport/search', $scope.agencyComReport).success(function(datas) {
				        	
				        	if (datas.success == true) {
				                console.log(datas)
				                $scope.rowCollection=datas.lAgencyTariffDetailBean;
				                if(datas.lAgencyTariffDetailBean.length>0){
				                	logger.logSuccess("Details Fetched!");
				                }else{
				                	logger.logError("Details Not Available");
				                }
				            }
				        }).error(function(datas) {
				        	 logger.logError("Error Please Try Again");
				        });
					
			/*$rootScope.vessel=$scope.agencyTariff1.vessel;
			$rootScope.voyage=$scope.agencyTariff1.voyage;
			$rootScope.impExp=$scope.agencyTariff1.impExp;
			$rootScope.port=$scope.agencyTariff1.port;*/
	      
	        
	        
	    }
		
    $scope.approveRow=function(agencyTariffObj,indx){
        $http.post($stateParams.tenantid+'app/agencyComReport/saveEstimate', agencyTariffObj).success(function(datas) {
            if(datas.success){                
                logger.logSuccess(datas.message);
            }else{
                logger.logError(datas.message);
            }         
        }).error(function(data) {

        });
    }
    
     
        $rootScope.$on('$stateChangeStart', 
                function(event, toState, toParams, fromState, fromParams){ 
            console.log("from state");
                    console.log(fromState);
                    console.log(toState);
                    if(  fromState.url=="/controlscreen/tariff/agencytariffdetailview/:agencyTariffCode" || toState.url=="/controlscreen/tariff/agencytariffdetailview/:agencyTariffCode"){
                        console.log("loscal if");
                    
                       
                    }else{
                        console.log("else local");
                        $scope.agencyTariff = {
                                voyage : '',
                                vessel : '',
                                port:''
                            }
                        AGFService.setObject($scope.agencyTariff);
                    }
                });
        
        $scope.reset = function(agencyTariffAddForm) {
        	$scope.rowCollection = ''
        	$scope.agencyComReport = {
					    year : '',
		                month : '',
	                	vessel : '',
	                    voyage : ''
	                		                	
			    };
   	    	
		        $scope.getList();

   	    }
         
    
    $scope.getAGFList = function(){
         
            var obj=AGFService.getObject();
            console.log("SEarch service");
            
            console.log(obj);
            if(obj.vessel!=''){
                $scope.agencyTariff=obj;
            }else{
                AGFService.setObject($scope.agencyTariff);
            }
            
          //  $scope.onSearch($scope.agencyTariff);
           /* $scope.arrivalReportList = ARRIVALREPORT.getArrivalReportList($scope.agencyTariff);
            $scope.arrivalReportList.then(function(data){
                $scope.arrivalReportList = data;
                $scope.rowCollection = [];
                    $scope.rowCollection = $scope.rowCollection.concat(data);
            });*/
        };
        
        $scope.getAGFList();
        
        $scope.agencyComm=function(){
            $location.path('controlscreen/tariff/agencyCommission')
        }
        
        
        $scope.viewRowBtn = function(agencyTariffCode) { 
        	$scope.agencyTariffCode = agencyTariffCode;
        	ngDialog.open({
        	template : 'views/finance/controlscreen/agencyTariffDetail/agencyTariffAmountView.jsp',
        	scope : $scope,
        	controller : $controller('agencyTariffDetailViewCtrl', {
        	$scope : $scope,
        	$http : $http,
        	ngDialog : ngDialog,
        	logger : logger,
        	$injector : $injector,
        	sharedProperties : sharedProperties,
        	toaster : toaster,
        	$rootScope : $rootScope
        	}),
        	closeByEscape : false,
        	})

        	}
        
       /* $scope.callQCDialog = function($scope,$http, ngDialog, logger,$injector, sharedProperties,$stateParams, toaster,$rootScope){
        	$scope.agencytariffcode = 
      		ngDialog.open({
      		scope: $scope,
      		template: 'views/finance/controlscreen/agencyTariffDetail/agencyTariffAmountView.jsp',
      		controller: $controller('agencyTariffDetailViewCtrl', {
      		$scope: $scope,
      		$http:$http,
      		ngDialog:ngDialog,
      		logger:logger,
      		$injector:$injector,
      		sharedProperties:sharedProperties,
      		toaster:toaster,
      		$rootScope:$rootScope
      		}),
      		className: 'ngdialog-theme-plain',
      		showClose: false,
      		closeByDocument: false,
      		closeByEscape: false,
      		preCloseCallback : $scope.getList
      		});

      		}*/
        
        
      //Excel Export	
	  	 $scope.exportExcel = function(agencyComReport){
	  	   	 $http.post($stateParams.tenantid+'/app/agencyComReport/ExportExcel', $scope.agencyComReport).success(function(response) {

	  	                if(response){
	  	                    if(response.lAgencyTariffDetailBean.length>0){
	  	                      $("#bookingreport").bind('click', function() {
		  	                    });
		  	                    $('#bookingreport').simulateClick('click');
		  	                    logger.logSuccess("Exported successfully!");	
	  	                    }else{
	  	                    	logger.logError("Commission Not Calculated");
	  	                    }
	  	                  
	  	                }else{
	  	                    logger.logError("Failed to export");
	  	                }
	  	                
	  	            }).error(function(response) {
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
app.controller('agencyTariffDetailViewCtrl', function($scope, ngDialog,toaster, $stateParams,$injector, $rootScope, $http, $location, logger, utilsService, $state, sharedProperties,$controller, $window) {
    var agencyTariffCode= $state.params.agencyTariffCode;
   
    $scope.agencyTariffView={
             vessel:'',
             voyage:'',
             emptyImport:'',
             emptyImportRates:'',
             totalEmptyImport:'',
             emptyExport:'',
             emptyExportRates:'',
             totalEmptyExport:'',
             ladenImport:'',
             ladenImportRates:'',
             totalLadenImport:'',
             ladenExport:'',
             ladenExportRates:'',
             totalLadenExport:'',
             buc:'',
             caf:'',
             amount:'',
             quotation:'',
             quotedRate:'',
             total:'',
            	bof:'' 
    }
    //$scope.agencyTariffCode 
/*    $http.post($stateParams.tenantid+'/app/agencyTariffDetails/edit', agencyTariffCode).success(function(datas) {
        if (datas.success == true) {
            $scope.agencyTariffView=datas.lAgencyTariffDetailViewBean[0];
            $scope.agencyTariffViewNextVoyList=datas.lAgencyTariffDetailViewBeanNextVoyage;
            $scope.agencyTariffViewNextVoy=datas.lAgencyTariffDetailViewBeanNextVoyage[0];
        }
    }).error(function(datas) {

    });
    */
  //edit
    var agencyTariffCode = $scope.agencyTariffCode 
    if(agencyTariffCode != null){

    	  $http.post($stateParams.tenantid+'/app/agencyTariffDetails/edit', agencyTariffCode).success(function(datas) {
    	        if (datas.success == true) {
    	            $scope.agencyTariffView=datas.lAgencyTariffDetailViewBean[0];
    	            $scope.agencyTariffViewNextVoyList=datas.lAgencyTariffDetailViewBeanNextVoyage;
    	            $scope.agencyTariffViewNextVoy=datas.lAgencyTariffDetailViewBeanNextVoyage[0];
    	        }
    	    });
    }
    
    
    
    
    
    
    $scope.cancel=function(){
        
        ngDialog.close();
    }
    /*$scope.viewbreakUp=function(agencyTariffView){
        debugger;
        var data =agencyTariffView.port+"_"+agencyTariffView.voyage;
        $location.path("/controlscreen/tariff/agencytariffbreakupCalc/"+data);
    }*/
    $scope.viewbreakUp=function(agencyTariffView){
        debugger;
        var agencyTariffCode =agencyTariffView.port+"_"+agencyTariffView.voyage;
    $state.go('app.finance.controlscreen.agencytariffdetail.view1',{agencyTariffCode:agencyTariffCode});
    }
});


app.controller('agencyTariffBreakUpCtrl', function($scope, ngDialog, $stateParams, $rootScope, $http, $location, logger, utilsService, $state, sharedProperties, $window) {
  debugger;
  var agencyTariffCode= $state.params.agencyTariffCode;
    console.log(agencyTariffCode);
    $scope.rowCollection=[];
    $scope.agencyTariffView={
             vessel:'',
             voyage:'',
             emptyImport:'',
             emptyImportRates:'',
             totalEmptyImport:'',
             emptyExport:'',
             emptyExportRates:'',
             totalEmptyExport:'',
             ladenImport:'',
             ladenImportRates:'',
             totalLadenImport:'',
             ladenExport:'',
             ladenExportRates:'',
             totalLadenExport:'',
             buc:'',
             caf:'',
             total:''
    }
    $http.post($stateParams.tenantid+'/app/agencyTariffDetails/viewBreakUp', agencyTariffCode).success(function(datas) {
        if (datas.success == true) {
            $scope.agencyTariffView=datas.lAgencyTariffDetailViewBean[0];
            $scope.agencyTariffViewNextVoyList=datas.lAgencyTariffDetailViewBeanNextVoyage;
            $scope.agencyTariffViewNextVoy=datas.lAgencyTariffDetailViewBeanNextVoyage[0];
        }
    }).error(function(datas) {

    }); 
    $scope.cancel=function(){
        $state.go('app.finance.controlscreen.agencytariffdetail.list');
    }
  
    
});


app.controller('agencyTariffCommissionCtrl', function($scope, ngDialog, $rootScope, $http, $location, logger, utilsService, 
        $state, sharedProperties, $window, $timeout) {
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    
    $('#mnthYear').datetimepicker({
        format: "MMMM-YYYY",
        viewMode: "months", 
          
})


 $scope.voyHubList = [ {"id" : "C0001","text" : "DUBAI"},{"id" : "C0003","text" : "SINGAPORE"}];
    
    $scope.traiffComObj={fromDate:'',toDate:'',pol:''};
    $scope.polList =[];
    
    $http.get($stateParams.tenantid+'/app/agencyTariff/pol').success(function(result) {
        $scope.polList=result.polList;
        console.log(result)
    })
    $scope.dropDownList = function() {
        $http.post($stateParams.tenantid+'/app/agencyTariff/getAgentList').success(function(result) {
            $scope.agentList=result.agentList;
            console.log(result)
        }).error(function(result) {
            console.log("data" + result);
        });
    };
    $scope.dropDownList();
    
    $scope.agencyTariffComm = function() {
        $scope.traiffComObj.monthYear = $('#mnthYear').find(':text').val();
        var submit=true;
        if(($scope.traiffComObj.monthYear!=null && $scope.traiffComObj.monthYear!=undefined &&$scope.traiffComObj.monthYear!='' )&&(($scope.traiffComObj.fromDate!=null && $scope.traiffComObj.fromDate!=undefined && $scope.traiffComObj.fromDate!='' ) || ($scope.traiffComObj.toDate!=null && $scope.traiffComObj.toDate!=undefined && $scope.traiffComObj.toDate!=''))){
            logger.logError("Please select either month based or date based!");
            submit=false;
            $scope.traiffComObj.fromDate='';$scope.traiffComObj.toDate='';
        }
        if(submit==true) {
            $http.post($stateParams.tenantid+'app/agencyTariff/getAgencyCommissionList', $scope.traiffComObj).success(function(result) {
                $scope.rowCollection=result.agencyCommissionList;
            }).error(function(result) {
                console.log("data" + result);
            });
        }
    };
    $scope.agencyTariffComm();
    
    
    
    
    $scope.exportData = function(obj) {
        debugger;
        
        var url = 'app/agencyTariff/getAgencyCommissionListReport';
        $http.post(url,obj).success(function(data) {
            if (data.success ) {
                $("#BQExport").bind('click', function() {
                });
                $('#BQExport').simulateClick('click');
                logger.logSuccess("Exported successfully!");
            }else{
                logger.logError("Error Please Try Again");
            }
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
    }
    
//    $scope.exportData = function(obj) {
//    $http.post('app/agencyTariff/getAgencyCommissionListReport', obj).success(function(datas) {
//        $('#BQExport').remove();
//        $('.excelfile').append('<div id="exportXl"></div>');
//        var file = '<a id="tbExcelExport" stype="display:none" href="filePath/agencyCommission.xls" download="agencyCommission.xls"></a>'
//
//        $('#BQExport').append(file);
//        $("#tbExcelExport").bind('click', function() {
//        });
//        $('#tbExcelExport').simulateClick('click');
//
//    }).error(function(data) {
//        logger.logError("Error Please Try Again");
//    });
//    } 
//    
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