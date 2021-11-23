//define([ 'hospital/inventory/inventory' ], function(module) {
    'use strict';
    app.controller('stockMovementCtrl', function($window,$scope,$stateParams, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {
        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.isDisplay = false;
        $scope.isUpload = true;
        $scope.isDelete = true;

        $scope.add = function() {
        
            $state.go('app.inventory.stockmovement.add');
        }

        $scope.editRow = function(row) {
            sharedProperties.setObject(row.id);
            $location.url($stateParams.tenantid +'/hospital/inventory/stockMovement/edit?stockId=' + row.id);

        }

        $scope.viewRow = function(row) {
            sharedProperties.setObject(row.id);
            $location.url($stateParams.tenantid + '/hospital/inventory/stockMovement/view?stockId=' + row.id);

        }
        $scope.print = function(id){       
            var url = 'hospital/inventory/stocktransfer/print?id=' + id;
            var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
            //wnd.print();   
            if (wnd.print) {
                var done = false;
                if (wnd.document && wnd.document.readyState) {
                    var rs = wnd.document.readyState;
                    if ((rs === 'complete') || (rs === 'loaded')) {
                        done = true;
                        wnd.print();
                    }
                }
                if (!done) {
                    if (wnd.addEventListener) {
                        wnd.addEventListener('load', function() {
                            this.print();
                        });
                    } else {
                        wnd.onload = function() {
                            this.print();
                        };
                    }
                }
            }
         }

        $scope.getList = function() {
            $http.get("hospital/inventory/stocktransfer/getList").success(function(response) {
                $scope.rowCollection = response.lStockTransferBean;
            });
            
        }
        $scope.getList();
        $scope.deleteRow = function(row) {
            ngDialog.openConfirm().then(function() {
                $http.post("hospital/inventory/stocktransfer/delete", row.id).success(function(response) {
                    if (response.success == true) {
                        logger.logSuccess("Deleted Successfully!");
                        $scope.getList();
                    }
                }).error(function(result) {
                    logger.logError("Error Please Try Again");
                });
            });
        };
//import Excel
        $scope.fileUpload = function() {
            ngDialog.close();
            ngDialog.open({
                template : 'fileModal',
                scope : $scope
            });
        };

        $rootScope.uploadFile = function(element) {
            
            console.log("excel file");
            $scope.excelfile = element.files[0];
            console.log($scope.excelfile);
        };
        
        $rootScope.closeFileDialog = function() {
            ngDialog.close();
        };
        
        $rootScope.uploadMaterialIssueRecord = function() {
            ngDialog.close();
            var excelfile = $scope.excelfile;
            var fileExtension = excelfile.name;
            var fName = [];
            fName = fileExtension.split(".");
            for (var i = 0; i < fName.length; i++) {
                if (fName[i] == "xls" || fName[i] == "xlsx") {
                    var frmData = new FormData();
                    frmData.append("file", excelfile);
                    $.ajax({
                        type : "POST",
                        url : "hospital/inventory/stocktransfer/uploadExefile",
                        data : frmData,
                        contentType : false,
                        processData : false,
                        success : function(result) {
                            console.log("result");
                            console.log(result);
                            if (result.success) {
                                logger.logSuccess("File Uploaded Successfully");
                                $scope.getList();
                                $scope.getEmployeeList();  
                            } else {
                               var value = result.message;
//                                document.getElementById("id").innerHTML =  result.message;

//                                logger.logError("Fail to Upload\n" + result.message);
//                                alert("I will get back to you soon\nThanks and Regards\nSaurav Kumar");
//                                ngDialog.openConfirm({
//                                    
//                                    template : 'modalDialogId6',
//                                    className : 'ngdialog-theme-default'
//                                })

                                $scope.callDialog($scope,value, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope);
//                            
                            }

                        }

                    });
                }

            }
        };
        $scope.callDialog = function($scope, value, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope) {
            ngDialog.open({
                scope : $scope,
                template : 'modalDialogId6',
                controller : $controller('ConsErrorCtrl', {
                    $scope : $scope,
                    value : value,
                    $http : $http,
                    ngDialog : ngDialog,
                    logger : logger,
                    $injector : $injector,
                    sharedProperties : sharedProperties,
                    toaster : toaster,
                    $rootScope : $rootScope
                }),
                className : 'ngdialog-theme-plain',
                showClose : false,
                closeByDocument : false,
                closeByEscape : false,
                preCloseCallback : $scope.getList
            });
        }
        
    });
    app.controller('ConsErrorCtrl', function($scope, $state, $http, $controller, logger, ngDialog, $location, $injector, sharedProperties, toaster, $rootScope,value) {
        $scope.value = value;
//        alert($scope.value);
    });
//});

