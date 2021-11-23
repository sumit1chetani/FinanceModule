/**
 * 
 */'use strict';
app.controller('staffMasterAddCtrl', function($scope, $rootScope, $http, $location, logger, utilsService,$state,sharedProperties,$window,ngDialog,validationService, $stateParams) {

        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.isEdit=false;
        
        $scope.staffmodel = {
                staffCode : '',
                staffName : '',
                dept: '',
                dsgn:'',
                unit:  '',
                position:  '',
                companyCode:  '',
                companyName:  '',
                balance:  '',                
                doj:  '',
                employeeCode :'',
                isActive : 'N'
        };
        
        $http.get($stateParams.tenantid+'/app/staffmaster/companycode').success(function(response) {
            console.log(response);      
            $scope.comapnyList = response.companyCode;
        });
        
        $http.get($stateParams.tenantid+'/app/staffmaster/getDepartment').success(function(datas) {
            $scope.departmentList = datas.departmentList;
        });
        $http.get($stateParams.tenantid+'/app/staffmaster/getDesignation').success(function(datas) {
            $scope.designationList = datas.designationList;
        });
        
        $scope.save = function(staffAddForm,staffmodel,staffmodelValidateData) {
            
            if (new validationService().checkFormValidity($scope.staffAddForm)) {
                            var addRowData = staffmodel;
                            $http.post($stateParams.tenantid+'/app/staffmaster/save', addRowData).success(function(result) {
                                console.log("result" + result);
                                if (result) {
                                    logger.logSuccess("Saved successfully!");
                                    $state.go('app.master.employee.staffmaster');
                                } else {
                                    logger.logError("Staff Name Already Exists!");
                                }
                            }).error(function(result) {
                                console.log("data" + result);
                            });
                        
                    } else {
                        toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.staffAddForm.$validationSummary), 555000, 'trustedHtml');
                    }
            };
        
            
            $scope.update = function(staffAddForm,staffmodel,staffmodelValidateData) { 
                if (new validationService().checkFormValidity($scope.staffAddForm)) {
                        
                        var updateRowData = staffmodel;
                        $http.post($stateParams.tenantid+'/app/staffmaster/update', updateRowData).success(function(result) {
                            if (result) {
                                logger.logSuccess("Updated successfully!");
                                $state.go('app.master.employee.staffmaster');
                            } else {
                                logger.logError("Staff Name Already Exists!");
                            }
                        }).error(function(data) {
                            console.log("data" + data);
                        });

                    }
                else{

                    toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.staffAddForm.$validationSummary), 555000, 'trustedHtml');
                }
                }
            
            $scope.cancel = function(){
                $state.go('app.finance.staffMaster.list');
            }
            
            
       
          
            var staffCode = $location.search().companyCode;
            if(staffCode != null){
                $scope.isEdit=true;
            $http.post($stateParams.tenantid+'/app/staffmaster/edit',staffCode).success(function(result) {
                console.log(result);     
                $scope.staffmodel =result; 
    	    	$scope.staffmodel.dept = result.dept.toString();
    	    	$scope.staffmodel.dsgn = result.dsgn.toString();

               
            }).error(function(data) {
                console.log("data" + data);
            });
            }
        
    });

