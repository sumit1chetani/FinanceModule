//define([ 'hospital/accounts/accounts' ], function(module) {

   // 'use strict';
    app.controller('TDSReportListCtrl', function($scope, $state, $http,$stateParams,$filter, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {

        
        

        $scope.budgetReportData = {
            companyName :'C0002',
            financeyear :'',
            amount : '',
            vendor :'',

        };
    
        
        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.isUpload = true;
        $scope.isDelete = true;
        $scope.emptyObject = {};
        $scope.companyList = [];
        $scope.vendorList = [];
        
        
        $http.get($stateParams.tenantid+'/app/commonUtility/getCompanyListcompany').success(function(datas) {
            $scope.companyList = datas;

                var foundItemDest = $filter('filter')($scope.companyList, {
                    baseCompany : 1
                    
                })[0];
                $scope.budgetReportData.companyName=foundItemDest.id;
        }).error(function(datas) {
        });
        
        
        
/*
        $http.get('app/budget/getTdsType').success(function(datas) {
            $scope.tdsList = datas.tdsList;
        }).error(function(datas) {
            logger.logError("Error Please Try Again");
        });
        */
        
        $http.get('app/budget/getVendorList').success(function(datas) {
            $scope.vendorList = datas.vendorList;
        }).error(function(datas) {
            logger.logError("Error Please Try Again");
        });
        
        
        $http.get('app/budget/getaccontnameTds').success(function(datas) {
            $scope.tdsList = datas.tdsList;
        }).error(function(datas) {
            logger.logError("Error Please Try Again");
        });
        
        
        
        
        

        
        $scope.onSearchpia = function() {
     
         $http.post('app/tdsreport/searchlist',$scope.budgetReportData).success(function(datas) {
                console.log(datas);
                $scope.rowCollection = datas.searchList;
                $scope.details = false;
                }).error(function(datas) {
            });

        }
        
        
        
        
        
        
        //Excel PDF	
      	 $scope.exportPDF = function(){
      		  var flag = false;
      		  //if(bean.port != "" && bean.port != undefined && bean.port != null){

    	     	   	 $http.post('app/tdsreport/ExportPDF',$scope.budgetReportData).success(function(response) {

      	                if(response){
      	                    debugger;
      	                    $("#exportPDF").bind('click', function() {
      	                    	
      	                    });
      	                    $('#exportPDF').simulateClick('click');
      	                    logger.logSuccess("Exported successfully!");
      	                }else{
    					        logger.logError(response.message);
      	                }
      	                
      	            }).error(function(response) {
      	                logger.logError("Error Please Try Again");
      	            });
    	     	   	 
      
      	    }
        
        

        
        $scope.exportExcel = function(){

            $http.post('app/tdsreport/ExportExcel', $scope.budgetReportData).success(function(data) {
                /*if(response.searchList.length() > 0){

            	// if(response){
                    debugger;
                    $("#budgetExport").bind('click', function() {
                    });
                    $('#budgetExport').simulateClick('click');
                    logger.logSuccess("Exported Successfully!");
                }else{
                    logger.logError("No Records Found!");
                }*/
            	
            	if (data) {
					debugger;
					$("#budgetExport").bind('click', function() {
					});
					$('#budgetExport').simulateClick('click');
					logger.logSuccess("Exported successfully!");
				} else {
					logger.logError("No Records Found");
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
        
        $scope.getList = function() {
            var url = 'app/tds/list?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount;
            $http.get(url).success(function(data) {
                if (data.success == true) {
                    $scope.rowCollection = $scope.rowCollection.concat(data.lAccountHeadMasterBeanBean);
                    sharedProperties.setObject($scope.emptyObject);
                }
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
            $scope.offsetCount = $scope.offsetCount + $scope.limitCount;
        };

        $scope.getList();

        $scope.add = function() {
            $state.go("app.finance.accounts.formAccountCenter.add");
        };

        
        
        
       $scope.editRow = function(tdsauto) {

           $location.url($stateParams.tenantid+'/hospital/accounts/formAccountCenter/edit?tdsauto=' + tdsauto);
           
       
       };
        
       
        

        
   /////////////////delete///////////     
        $scope.deleteRow = function(tdsauto, index) {

            ngDialog.openConfirm().then(function() {
                var myURL = 'app/tds/delete?tdsauto='+tdsauto;
                $http({
                    method : 'post',
                    url : myURL,
                    data : tdsauto,
                }).success(function(data) {
                    if (data == true) {

                        $scope.rowCollection.splice(index, 1);
                
                        logger.logSuccess("Deleted Successfully");
                        $state.reload();
                        
                    } else {
                        logger.logError("Error In Deleting Record!");
                    }
                }).error(function(data) {
                    logger.logSuccess("Error In Delete!");
                });
            });

        };

     

    //});

});