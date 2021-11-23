//define([ 'hospital/accounts/accounts' ], function(module) {

   // 'use strict';
    app.controller('budgetReportListCtrl', function($scope, $state, $http,$filter, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {

        
        

        $scope.budgetReportData = {
            companyName :'',
            financeyear :'',
            amount : '',

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
        
        
        
        $http.get('app/commonUtility/getCompanyListcompany').success(function(datas) {
            $scope.companyList = datas;

                var foundItemDest = $filter('filter')($scope.companyList, {
                    baseCompany : 1
                    
                })[0];
                $scope.budgetReportData.companyName=foundItemDest.id;
        }).error(function(datas) {
        });
        
        
        

        $http.get('app/budget/getFinYearbudget').success(function(datas) {
            $scope.finanacelist = datas.finYearList;
        }).error(function(datas) {
            logger.logError("Error Please Try Again");
        });
        
        
        
        

        
        $scope.onSearchpia = function() {
     
         $http.post('app/budgetreport/searchlist',$scope.budgetReportData).success(function(datas) {
                console.log(datas);
                $scope.rowCollection = datas.searchList;
                $scope.details = false;
                }).error(function(datas) {
            });

        }
        
        
        
        
        
        
        
        

        
        $scope.exportExcel = function(){

            $http.post('app/budgetreport/ExportExcel', $scope.budgetReportData).success(function(response) {
                if(response){
                    debugger;
                    $("#budgetExport").bind('click', function() {
                    });
                    $('#budgetExport').simulateClick('click');
                    logger.logSuccess("Exported successfully!");
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
       /* 
        $scope.editRow = function(formCode) {
            $state.go('app.master.form.edit',{'formCode':formCode})    
       };
*/
        $scope.add = function() {
            $state.go("app.finance.accounts.formAccountCenter.add");
        };

        
        
        
       $scope.editRow = function(tdsauto) {

//            $state.go("app.hospital.accounts.bankCompanymapping.Add",{'accCode':accCode});      
           $location.url('/hospital/accounts/formAccountCenter/edit?tdsauto=' + tdsauto);
           
       
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
                
                        logger.logSuccess("deleted successfully");
                        $state.reload();
                        
                    } else {
                        logger.logError("Error in deleting Record!");
                    }
                }).error(function(data) {
                    logger.logSuccess("Error in Delete!");
                });
            });

        };

     

    //});

});