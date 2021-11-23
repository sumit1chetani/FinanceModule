define([ 'hospital/asset/asset' ], function(module) {

    'use strict';
    module.registerController('purchaseassetRequisitionAddCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope,validationService,$timeout) {

        $scope.assetPurchaseRequisitionObj = {
            purchaseAssetrequisitionDate : '',
            employeeId : '',
            destinationLocation : '',
            companyId:'',
            tables : []
        }
        
       
        var currentDate = new Date();
        currentDate = ('0' + currentDate.getDate()).slice(-2)+"/"+('0' + (currentDate.getMonth() + 1)).slice(-2)+"/"+currentDate.getFullYear();
        $scope.assetPurchaseRequisitionObj.purchaseAssetrequisitionDate = currentDate;
        
        
        $scope.getDropdownvalue = function() {
            $http.get('app/hospital/purchase/storeToPurchase/employeeList').success(function(datas) {
                $scope.employeeList = datas.employeeList;
                $scope.getItemList();
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
            
            $http.get("app/commonUtility/assetLocationlist").success(function(datas) {
                $scope.destLocationList = datas;
            }).error(function(datas) {
                logger.logError("Error Please Try Again");
            });
            
            $http.get('app/commonUtility/getCompanyList').success(function(datas) {
                $scope.companyList = datas;
                }).error(function(datas) {
            });

        }
        //Asset Based Item  List
        $scope.getItemList = function() {
            $http.get('app/hospital/purchase/storeToPurchase/itemListBasedAsset').success(function(result) {
                $scope.ItemList = result.subData;
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        }

        $scope.getDropdownvalue();
        var globalId=1;
        $scope.fetchItemList = function() {
            angular.forEach($scope.assetPurchaseRequisitionObj.tables[0].row, function(value, index) {

                $scope.$watch('assetPurchaseRequisitionObj.tables[0].row[' + index + '].itemId', function(newValue, oldValue) {
                    if (newValue != '' && newValue != undefined) {
                        angular.forEach($scope.ItemList, function(value, indexs) {
                            if (newValue == value.id) {
                                $scope.assetPurchaseRequisitionObj.tables[0].row[index].itemCategoryName = value.itemCategoryName;
                                $scope.assetPurchaseRequisitionObj.tables[0].row[index].uomName = value.uomName;

                            }
                        });
                    } else if($scope.assetPurchaseRequisitionObj.tables.length > 0) {
                        $scope.assetPurchaseRequisitionObj.tables[0].row[index].itemCategoryName = '';
                        $scope.assetPurchaseRequisitionObj.tables[0].row[index].uomName = '';

                    }
                });
                
                
                $scope.$watch('assetPurchaseRequisitionObj.tables[0].row[' + index + '].eddDate',function(newValue,oldValue){
                    if(newValue !== undefined && newValue !== ""){
                        var givenDate =newValue.split("/");
                        var from = new Date(givenDate[2], givenDate[1] - 1, givenDate[0]);
                        
                        var currentDateSplit=currentDate.split("/");
                        var currentDate1 = new Date(currentDateSplit[2],currentDateSplit[1]-1,currentDateSplit[0]);
                        
                        if (from <  currentDate1 ) {
                            logger.logError("Select Date greater than Today's Date or Today's Date");
                            globalId=0;
                        }else{
                            globalId=1;
                        }
                    }
                });

            });

        }

        $scope.tables = [];
        $scope.loadTable = function() {
            $scope.assetPurchaseRequisitionObj.tables=[];
            var table = {};
            table.row = [ {
                itemId : '',
                itemCategoryName : '',
                uomName : '',
                quantity : '',
                eddDate : '',
            } ];
            $scope.assetPurchaseRequisitionObj.tables.push(table);
            $scope.fetchItemList();
        }

        $scope.loadTable();

        $scope.addRow = function(tables) {
            var table = {
                    itemId : '',
                    itemCategoryName : '',
                    uomName : '',
                    quantity : '',
                    eddDate : '',
                };

            tables.row.push(table);
            $scope.fetchItemList();
        }

        $scope.removeRowForm = function(table) {
            $scope.tablerow = [];
            if (table.row.length > 1) {
                angular.forEach(table.row, function(row, index) {
                    var check = row.tableId;
                    if (check == undefined || check == "") {
                        $scope.tablerow.push(row);
                    } else {

                    }
                });
                table.row = $scope.tablerow;
                $scope.fetchItemList();
            } else {
                logger.logError("Minimum 1!");

            }
        }
       
       
        $scope.submit = function(assetPurchaseRequisitionObj) {
            if ( new validationService().checkFormValidity($scope.assetPurchaseRequisitionForm)) {
                if(globalId == 1){
                    $scope.save(assetPurchaseRequisitionObj);
                }else{
                    logger.logError("Select Date greater than Today's Date or Today's Date");
                }
            } else {
                toaster.pop('error', "Please fill the required fields", 
                        logger.getErrorHtmlNew($scope.assetPurchaseRequisitionForm.$validationSummary), 555000, 'trustedHtml');
            }
        };

        $scope.save = function(assetPurchaseRequisitionObj) {
            var objData = {
                'purchaseAssetrequisitionDate' : assetPurchaseRequisitionObj.purchaseAssetrequisitionDate,
                'employeeId' : assetPurchaseRequisitionObj.employeeId,
                'designationLocationId' : assetPurchaseRequisitionObj.destinationLocation,
                'formName' : 'purchaseAssetRequisition',
                'companyId':assetPurchaseRequisitionObj.companyId,
                'listAssetDetail' : $scope.assetPurchaseRequisitionObj.tables[0].row
            };
                var myURL = 'hospital/asset/assetRequisition/savePurchaseAssetRequisition';
                $http({
                    url : myURL,
                    data : objData,
                    method : 'post',
                    dataType : 'json',
                    headers : {
                        'Accept' : 'application/json',
                        'Content-Type' : 'application/json'
                    }
                }).success(function(data) {
                    if (!data) {
                        logger.logError(" Error Not Saved!");
                    } else {
                        logger.logSuccess("Saved!");
                        $state.go("app.hospital.asset.assetPurchaseRequisitions.list");
                    }
                }).error(function(data) {

                });
        };
        
        $scope.onChangeNumber =function(id,num){
            num = num.replace(/[^0-9 ]/g, '');
                $('#quantity'+id).val(num);
            return num;
        };
        
        $scope.cancel = function() {
            $state.go("app.hospital.asset.assetPurchaseRequisitions.list");
        };
        
       var originalObjectData = angular.copy($scope.assetPurchaseRequisitionObj);
       
        $scope.reset = function(){
            
            console.log("originalObjectData");
            
            console.log(originalObjectData);
              $scope.assetPurchaseRequisitionObj = angular.copy(originalObjectData);
            
              $timeout(function(){
                  $scope.loadTable(); 
                  $scope.assetPurchaseRequisitionForm.$setPristine();
                  $scope.assetPurchaseRequisitionForm.$setUntouched();
              },.5);
              originalObjectData.tables=[];
                
        };
        
    });
    
    module.registerController('purchaseassetRequisitionEditCtrl', function($scope, $http, ngDialog, logger, $state, $stateParams, sharedProperties, toaster, $rootScope,validationService) {
        var aPreqId=$stateParams.assetPRId;
        var areqType=$stateParams.type;
        
        $scope.isEdit = true;
        $scope.assetPurchaseRequisitionObj = {
                purchaseAssetrequisitionId:'',
                purchaseAssetrequisitionNo:'',
                purchaseAssetrequisitionDate : '',
                employeeId : '',
                destinationLocation : '',
                companyId:'',
                tables : [],
                deleteIds:[]
            }
        
        $scope.clearassetPurchaseRequisitionObj = {
                purchaseAssetrequisitionId:'',
                purchaseAssetrequisitionNo:'',
                purchaseAssetrequisitionDate : '',
                employeeId : '',
                destinationLocation : '',
                companyId:'',
                tables : [],
                deleteIds:[]
            }
        
        

        $scope.assetPurchaseRequisitionObj.tables = [ {
            row : []
        } ]; 
            
            $scope.getDropdownvalue = function() {
                $http.get('app/hospital/purchase/storeToPurchase/employeeList').success(function(datas) {
                    $scope.employeeList = datas.employeeList;
                }).error(function(data) {
                    logger.logError("Error Please Try Again");
                });
                
                $http.get("app/commonUtility/assetLocationlist").success(function(datas) {
                    $scope.destLocationList = datas;
                }).error(function(datas) {
                    logger.logError("Error Please Try Again");
                });
                
                $http.get('app/commonUtility/getCompanyList').success(function(datas) {
                    $scope.companyList = datas;
                    }).error(function(datas) {
                });

            }
            //Asset Based Item  List
            $scope.getItemList = function() {
                $http.get('app/hospital/purchase/storeToPurchase/itemListBasedAsset').success(function(result) {
                    $scope.ItemList = result.subData;
                }).error(function(data) {
                    logger.logError("Error Please Try Again");
                });
            }

            $scope.getDropdownvalue();
            $scope.getItemList();
            
            var globalId=1;
            $scope.fetchItemList = function() {
                angular.forEach($scope.assetPurchaseRequisitionObj.tables[0].row, function(value, index) {

                    $scope.$watch('assetPurchaseRequisitionObj.tables[0].row[' + index + '].itemId', function(newValue, oldValue) {
                        if (newValue != "") {
                            angular.forEach($scope.ItemList, function(value, indexs) {
                                if (newValue == value.id) {
                                    $scope.assetPurchaseRequisitionObj.tables[0].row[index].itemCategoryName = value.itemCategoryName;
                                    $scope.assetPurchaseRequisitionObj.tables[0].row[index].uomName = value.uomName;

                                }
                            });
                        } else if(newValue == "" || newValue == undefined) {
                            $scope.assetPurchaseRequisitionObj.tables[0].row[index].itemCategoryName = '';
                            $scope.assetPurchaseRequisitionObj.tables[0].row[index].uomName = '';

                        }
                    });
                    
                    $scope.$watch('assetPurchaseRequisitionObj.tables[0].row[' + index + '].eddDate',function(newValue,oldValue){
                        if(newValue !== undefined && newValue !== ""){
                            var givenDate =newValue.split("/");
                            var from = new Date(givenDate[2], givenDate[1] - 1, givenDate[0]);
                            
                            var currentDateSplit=$scope.assetPurchaseRequisitionObj.purchaseAssetrequisitionDate.split("/");
                            var currentDate1 = new Date(currentDateSplit[2],currentDateSplit[1]-1,currentDateSplit[0]);
                            
                            if (from <  currentDate1 ) {
                                logger.logError("Select Date greater than Requistion's Date");
                                globalId=0;
                            }else{
                                globalId=1;
                            }
                        }
                    });

                });

            }

           
            $scope.addRow = function(tables) {
                var table = {
                    itemId : '',
                    itemCategoryName : '',
                    uomName : '',
                    quantity : '',
                    eddDate : '',
                };

                tables.row.push(table);
                $scope.fetchItemList();
            }

            $scope.removeRowForm = function(table) {
                $scope.tablerow = [];
                if (table.row.length > 1) {
                    angular.forEach(table.row, function(row, index) {
                        var check = row.tableId;
                        if (check == undefined || check == "") {
                            $scope.tablerow.push(row);
                        } else {
                            if(row.purchaseRequisitionSubId > 0){
                                $scope.assetPurchaseRequisitionObj.deleteIds.push(row.purchaseRequisitionSubId);   
                            }

                        }
                    });
                    table.row = $scope.tablerow;
                    $scope.fetchItemList();
                } else {
                    logger.logError("Minimum 1!");

                }
            }

            
            $scope.getFetchEditDetails=function(aPreqId,reqType){
                var url = 'hospital/asset/assetRequisition/editDetailsPurchaseAssetRequisition?purcahseassetRequistionId=' + aPreqId +'&type=' +reqType  ;
                $http.get(url).success(function(result) {
                         $scope.assetPurchaseRequisitionObj.purchaseAssetrequisitionNo=result.objPurchaseAssetRequisitionBean.purchaseAssetrequisitionNo
                         $scope.assetPurchaseRequisitionObj.purchaseAssetrequisitionDate=result.objPurchaseAssetRequisitionBean.purchaseAssetrequisitionDate
                         $scope.assetPurchaseRequisitionObj.employeeId=result.objPurchaseAssetRequisitionBean.employeeId
                         $scope.assetPurchaseRequisitionObj.destinationLocation=result.objPurchaseAssetRequisitionBean.designationLocationId;
                         $scope.assetPurchaseRequisitionObj.companyId=result.objPurchaseAssetRequisitionBean.companyId;
                         $scope.assetPurchaseRequisitionObj.tables[0].row=result.listAssetItemEditDetail;
                         $scope.fetchItemList();
                }).error(function(result) {
                    logger.logError("Error Please Try Again");
                });
            }
            $scope.getFetchEditDetails(aPreqId,areqType);
            
            /*$scope.editCustomValidation = function() {
                var flag =true,msg='';
                angular.forEach($scope.assetPurchaseRequisitionObj.tables[0].row, function(row, index) {
                    debugger;
                    var batchQty =0;

                    if(row.quantity == 0){
                        msg ="Quantity should be greater than  0 ";
                        flag =false;
                    }

                });
                if(!flag){
                    logger.logError(msg);
                }
                return flag;
                
              }*/
            
            
            $scope.submit = function(assetPurchaseRequisitionObj) {
                if (new validationService().checkFormValidity($scope.assetPurchaseRequisitionForm)) {
                    debugger    
                    if(globalId == 1){
                            $scope.update(assetPurchaseRequisitionObj);
                        }else{
                            logger.logError("Select Date greater than Requistion's Date");
                        }
                } else {
                    toaster.pop('error', "Please fill the required fields", 
                            logger.getErrorHtmlNew($scope.assetPurchaseRequisitionForm.$validationSummary), 555000, 'trustedHtml');
                }
            };
            
            
            $scope.update = function(assetPurchaseRequisitionObj) {
                
                var objData = {
                        'purchaseAssetRequisitionId': aPreqId,
                        'purchaseAssetrequisitionDate' : assetPurchaseRequisitionObj.purchaseAssetrequisitionDate,
                        'employeeId' : assetPurchaseRequisitionObj.employeeId,
                        'designationLocationId' : assetPurchaseRequisitionObj.destinationLocation,
                        'formName' : 'purchaseAssetRequisition',
                        'companyId':assetPurchaseRequisitionObj.companyId,
                        'listAssetDetail' : $scope.assetPurchaseRequisitionObj.tables[0].row,
                        'ldeleteIds':assetPurchaseRequisitionObj.deleteIds,
                    };
                    var myURL = 'hospital/asset/assetRequisition/updatePurchaseAssetRequisition';
                    $http({
                        url : myURL,
                        data : objData,
                        method : 'post',
                        dataType : 'json',
                        headers : {
                            'Accept' : 'application/json',
                            'Content-Type' : 'application/json'
                        }
                    }).success(function(data) {
                        if (!data) {
                            logger.logError(" Error Not Updated!");
                        } else {
                            logger.logSuccess("Updated!");
                            $state.go("app.hospital.asset.assetPurchaseRequisitions.list");
                        }

                    }).error(function(data) {

                    });
           };
           
           $scope.cancel = function() {
               $state.go("app.hospital.asset.assetPurchaseRequisitions.list");
           }
           
           $scope.onChangeNumber =function(id,num){
               num = num.replace(/[^0-9 ]/g, '');
                   $('#quantity'+id).val(num);
               return num;
           }
           
           $scope.reset=function(){
               angular.copy($scope.clearassetPurchaseRequisitionObj, $scope.assetPurchaseRequisitionObj);
               $scope.assetPurchaseRequisitionObj.tables = [ {
                   row : []
               } ];
               $scope.getDropdownvalue();
               $scope.getItemList();
               $scope.getFetchEditDetails(aPreqId,areqType);
           }

    });
    module.registerController('purchaseassetRequisitionViewCtrl', function($scope,$filter, $http, ngDialog, logger, $state, $stateParams, sharedProperties, toaster, $rootScope) {
        var aPreqId=$stateParams.assetPRId;
        var areqType=134
        $scope.assetPurchaseRequisitionObj = {
                purchaseAssetrequisitionId:'',
                purchaseAssetrequisitionNo:'',
                purchaseAssetrequisitionDate : '',
                employeeId : '',
                destinationLocation : '',
                tables : [],
                deleteIds:[]
            }

        $scope.assetPurchaseRequisitionObj.tables = [ {
            row : []
        } ]; 
            
            $scope.getDropdownvalue = function() {
                $http.get('app/hospital/purchase/storeToPurchase/employeeList').success(function(datas) {
                    $scope.employeeList = datas.employeeList;
                    $scope.destLocationList = datas.destLocationList;
                    $scope.getFetchEditDetails(aPreqId,areqType);
                }).error(function(data) {
                    logger.logError("Error Please Try Again");
                });
                
                $http.get('app/commonUtility/getCompanyList').success(function(datas) {
                    $scope.companyList = datas;
                    }).error(function(datas) {
                });

            }
            //Asset Based Item  List
            $scope.getItemList = function() {
                $http.get('app/hospital/purchase/storeToPurchase/itemListBasedAsset').success(function(result) {
                    $scope.ItemList = result.subData;
                }).error(function(data) {
                    logger.logError("Error Please Try Again");
                });
            }

            $scope.getDropdownvalue();
            $scope.getItemList();
            
            $scope.fetchItemList = function() {
                angular.forEach($scope.assetPurchaseRequisitionObj.tables[0].row, function(value, index) {

                    $scope.$watch('assetPurchaseRequisitionObj.tables[0].row[' + index + '].itemId', function(newValue, oldValue) {
                        if (newValue != "") {
                            angular.forEach($scope.ItemList, function(value, indexs) {
                                if (newValue == value.id) {
                                    $scope.assetPurchaseRequisitionObj.tables[0].row[index].itemName = value.text;
                                    $scope.assetPurchaseRequisitionObj.tables[0].row[index].itemCategoryName = value.itemCategoryName;
                                    $scope.assetPurchaseRequisitionObj.tables[0].row[index].uomName = value.uomName;

                                }
                            });
                        } else if(newValue == "" || newValue == undefined) {
                            $scope.assetPurchaseRequisitionObj.tables[0].row[index].itemCategoryName = '';
                            $scope.assetPurchaseRequisitionObj.tables[0].row[index].uomName = '';

                        }
                    });

                });

            }

            
            $scope.getFetchEditDetails=function(aPreqId,reqType){
                var url = 'hospital/asset/assetRequisition/editDetailsPurchaseAssetRequisition?purcahseassetRequistionId=' + aPreqId +'&type=' +reqType  ;
                $http.get(url).success(function(result) {
                    
                         $scope.assetPurchaseRequisitionObj.purchaseAssetrequisitionNo=result.objPurchaseAssetRequisitionBean.purchaseAssetrequisitionNo
                         $scope.assetPurchaseRequisitionObj.purchaseAssetrequisitionDate=result.objPurchaseAssetRequisitionBean.purchaseAssetrequisitionDate
                         
                         
                         var empObj = $filter('filter')($scope.employeeList, {
                             id : result.objPurchaseAssetRequisitionBean.employeeId
                         })[0];
                         $scope.assetPurchaseRequisitionObj.employeeId=empObj.text
                         
                         var destObj = $filter('filter')($scope.destLocationList, {
                             id : result.objPurchaseAssetRequisitionBean.designationLocationId
                         })[0];
                         
                         $scope.assetPurchaseRequisitionObj.destinationLocation=destObj.text
                         $scope.assetPurchaseRequisitionObj.tables[0].row=result.listAssetItemEditDetail;
                         $scope.fetchItemList();
                }).error(function(result) {
                    logger.logError("Error Please Try Again");
                });
            }
           
            
           
           
           $scope.cancel = function() {
               $state.go("app.hospital.asset.assetPurchaseRequisitions.list");
           }

    });

});
