//define([ 'hospital/accounts/accounts' ], function(module) {

    'use strict';

    app.controller
                ('openingBalanceListCtrl',
                function($scope, $rootScope, ngDialog, $http, $location,
                        logger, utilsService, $state, sharedProperties,
                        $window, validationService, toaster, $stateParams) {
                    $scope.dataLoopCount = 0;
                    $scope.offsetCount = 0;
                    $scope.limitCount = 1000;
                    $scope.updatedData = [];
                    $scope.rowCollection = [];
                    $scope.displayedCollection = [];
                    $scope.itemsByPage = 10;

                    $scope.add = function() {
                        $state.go('app.finance.accounts.openBalanceUpload.add', {
                            tenantid : $stateParams.tenantid
                        });
                    };
                    $scope.getList = function() {
                        $http.get('app/finance/openingBalance/list').success(
                                        function(datas) {
                                            console.log(datas);
                                            $scope.rowCollection = datas.openingBalanceList;

                                        }).error(function(datas) {
                                });
                    };
                    $scope.getList();
                    
                /*   $scope.$watch('openingBalance.companyCode', function(newValue, oldValue) {
                            var classId =  $scope.openingBalance.companyCode;
                            if(classId!=""){
                            $http.get($stateParams.tenantid
                                    + '/app/finance/openingBalance/list').success(function(data) {
                                        $scope.rowCollection = datas.openingBalanceList;
                            });
                            }
                        })*/
                    
                    
                    $scope.cancel = function() {
                       $state.go('app.finance.accounts.openBalanceUpload.list');
                       // $state.go('app.finance.transaction.openBalanceUpload.list',{tenantid:$stateParams.tenantid});
                         
                            
                       };
                    $scope.openingBalance = {
                        invoiceNo : '',
                        invoiceDate : '',
                        transactionid:'',
                        tcAmount : '',
                        bcAmount : '',
                        oldCutomerCode : '',
                        customerCode : '',
                        customerName : '',
                        companyCode : '',
                        companyName : '',
                        accountHead : '',
                        companyId :'',

                    };
                    
                    
                    
                    $scope.accountingYearClose ={
                            fromdate :'',
                            todate :'',
                            companyCode :'',
                            companyId : 'C0002',
                         
                          
                            //groupname:''
                            
                    }
                    $scope.list=function()
                    {
                          $http.post('app/finance/openingBalance/drop').success(function(data) {
                          $scope.currencyList=data.currecncyList;
                          $scope.companyList=data.companyList;
                          $scope.customerList=data.customerList;
                          if(temp != '' && temp != null){
                              $scope.openingBalance.companyId =temp;
                          }
                          
                          });
                    }
                    
                    $scope.list();
                    
                    
                    
                    
                    $scope.generateJv = function(openingBalanceForm){
                                             
                          $http.post('/app/finance/openingBalance/generateJv',$scope.openingBalance).success(function(data) {
                          if(data.success){
                          logger.logSuccess('Jv Generated Successfully');
                          $state.go('app.finance.accounts.openBalanceUpload.list');
                          }else{
                          logger.logError('Unable to Generate Jv!');
                          }
                          });
                         
                 
                    }
                    
                    

                    $scope.submit=function(closeact){

                        var abc = {
                                fromDate:$scope.accountingYearClose.fromDate,
                                toDate:$scope.accountingYearClose.toDate,
                                company:$scope.accountingYearClose.companyId,
                                groupHeadCode:$scope.accountingYearClose.groupHeadCode
                        }
                   
                        $http.post('/app/finance/openingBalance/getData',$scope.accountingYearClose).success(function(data) {
                            $scope.rowCollection = data.openingBalanceList;
                    
                    })
                    }
                        
                    

                    $scope.companyList =[];
                    
                    //companylist
                    $scope.getDropdownvalue = function() {
                        $http.get($stateParams.tenantid+'/app/commonUtility/getCompanyListPurchase').success(function(datas) {
                            $scope.companyList = datas;
                            }).error(function(datas) {
                        });
                        
                    }
                    $scope.getDropdownvalue();
                    
                    $scope.generateOBJv = function(limit, offset) {
                        $state.go('app.finance.accounts.openBalanceUpload.jvList');
                    };
                    
                    
                    
                    
       //UPLOAD
                
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
                    

                    $rootScope.uploadPIN = function() {
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
                                    url : "app/finance/openingBalance/uploadfile",
                                    data : frmData,
                                    contentType : false,
                                    processData : false,
                                    success : function(result) {
                                        console.log("result");
                                        console.log(result);
                                        if (result.success) {
                                            logger.logSuccess("File Uploaded Successfully");
                                            $scope.rowCollection=[];
                                            $scope.getPurchaseInvoiceList();
                                        } else {
                                            logger.logError(result.message);
                                        }
                                    }
                                });
                            }
                        }
                    };
                    
                    
                    //END
                    
                    
                    $scope.deleteRow = function(rowid) {

                        ngDialog
                                .openConfirm()
                                .then(
                                        function() {
                                            var myURL = $stateParams.tenantid
                                                    + '/app/master/servicepartner/delete?servicePartnerId='
                                                    + rowid;
                                            $http({
                                                method : 'post',
                                                url : myURL,
                                                data : rowid,
                                            })
                                                    .success(
                                                            function(data) {
                                                                if (data.success == true) {
                                                                    logger
                                                                            .logSuccess("Deleted Successfully");
                                                                    $state
                                                                            .reload();
                                                                } else {
                                                                    logger
                                                                            .logError("Error in deleting Record!");
                                                                }
                                                            })
                                                    .error(
                                                            function(data) {
                                                                logger
                                                                        .logSuccess("Error in Delete!");
                                                            });
                                        });

                    };

                    $scope.getList();
                    $scope.editRow = function(transactionid) {
                        $location.url($stateParams.tenantid+'/hospital/accounts/openBalanceUpload/edit?transactionid=' + transactionid);
                    }

                    $scope.view = function(transactionid) {
                        $location.url($stateParams.tenantid
                                + '/transaction/openingbalance/view?transactionid=' + transactionid);
                    }
                     $scope.exportExcel = function(){

                            $http.post('app/finance/openingBalance/ExportExcel', $scope.openingBalance).success(function(response) {
                                if(response){
                                    debugger;
                                    $("#Export").bind('click', function() {
                                    });
                                    $('#Export').simulateClick('click');
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

              //  });
});
