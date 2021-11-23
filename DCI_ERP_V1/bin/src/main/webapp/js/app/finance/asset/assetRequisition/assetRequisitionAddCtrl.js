define([ 'hospital/asset/asset' ], function(module) {

    'use strict';
    module.registerController('assetRequisitionAddCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope,validationService) {

        $scope.assetRequisitionObj = {
            assetrequisitionNo:'',
            assetrequisitionDate : '',
            employeeId : '',
            sourceLocation:'',
            destinationLocation : '',
            itemId : '',
            quantity : '',
            eddDate : '',
            companyId:'',
        }
        
        

        var currentDate = new Date();
        currentDate = ('0' + currentDate.getDate()).slice(-2)+"/"+('0' + (currentDate.getMonth() + 1)).slice(-2)+"/"+currentDate.getFullYear();
        $scope.assetRequisitionObj.assetrequisitionDate = currentDate;
       
        
        $scope.cancel = function() {
            $state.go("app.hospital.asset.assetRequisition.list");
        }

        $scope.getDropdownvalue = function() {
            $http.get('app/hospital/purchase/storeToPurchase/employeeList').success(function(datas) {
                $scope.employeeList = datas.employeeList;
                $scope.getItemList();
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
            
           /* $http.get("app/commonUtility/assetLocationlist").success(function(datas) {
                $scope.destLocationList = datas;
            }).error(function(datas) {
                logger.logError("Error Please Try Again");
            });*/
            $http.get("app/inventory/consignmentIn/parentlocationlist").success(function(datas) {
                $scope.destLocationList = datas;
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

        
        $scope.$watch('assetRequisitionObj.itemId', function(newValue, oldValue) {
            if(newValue != ""){
                $scope.getAssetTrackDetails(newValue);
           }
        });
        
        $('#AssetTrackDetails').hide();
        $scope.getAssetTrackDetails=function(itemId){
            if(itemId!=""){
            var url = 'hospital/asset/assetRequisition/assetTrackDetails?itemId=' +itemId+'&sourceLocation='+$scope.assetRequisitionObj.sourceLocation;
            $http.get(url).success(function(data) {
                if(data.success){
                    $('#AssetTrackDetails').show();
                    $scope.rowCollection=data.lAssetTrack;
                }else{
                    logger.log(data.errors);
                    $('#AssetTrackDetails').hide();
                    $scope.rowCollection=[];
                }
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
            }
        };
        var totalCheckedCount=0;
        $scope.onCount=function(assetTrackConfirm,obj){
            if(assetTrackConfirm){
                totalCheckedCount++;
                $scope.assetRequisitionObj.quantity=totalCheckedCount;
            }else if(!assetTrackConfirm){
                totalCheckedCount--;
                $scope.assetRequisitionObj.quantity=totalCheckedCount;
            }
        }
        var globalId=1;
        $scope.$watch('assetRequisitionObj.eddDate',function(newValue,oldValue){
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
           
        
      
        
        /*$scope.fetchItemList = function() {
            angular.forEach($scope.assetRequisitionObj.tables[0].row, function(value, index) {

                $scope.$watch('assetRequisitionObj.tables[0].row[' + index + '].itemId', function(newValue, oldValue) {
                    if (newValue != '' && newValue != undefined) {
                        angular.forEach($scope.ItemList, function(value, indexs) {
                            if (newValue == value.id) {
                                $scope.assetRequisitionObj.tables[0].row[index].itemCategoryName = value.itemCategoryName;
                                $scope.assetRequisitionObj.tables[0].row[index].uomName = value.uomName;

                            }
                        });
                    } else {
                        $scope.assetRequisitionObj.tables[0].row[index].itemCategoryName = '';
                        $scope.assetRequisitionObj.tables[0].row[index].uomName = '';

                    }
                });

            });

        }*/

        /*$scope.tables = [];
        $scope.loadTable = function() {
            var table = {};
            table.row = [ {
                itemId : '',
                itemCategoryName : '',
                uomName : '',
                quantity : '',
                eddDate : '',

            } ];
            $scope.assetRequisitionObj.tables.push(table);
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
        }*/

        
        $scope.submit = function(assetRequisitionObj,displayedCollection) {
            if (new validationService().checkFormValidity($scope.assetRequisitionForm)) {
                if(globalId == 1){
                    $scope.save(assetRequisitionObj,displayedCollection);
                }else{
                    logger.logError("Select Date greater than Today's Date or Today's Date");
                }    
                
            } else {
                toaster.pop('error', "Please fill the required fields", 
                        logger.getErrorHtmlNew($scope.assetRequisitionForm.$validationSummary), 555000, 'trustedHtml');
            }
        };
        
        
        $scope.save = function(assetRequisitionObj,displayedCollection) {
            if(displayedCollection.length > 0){
            if(Number(assetRequisitionObj.quantity) === totalCheckedCount){
            var objData = {
                'assetrequisitionDate' : assetRequisitionObj.assetrequisitionDate,
                'employeeId' : assetRequisitionObj.employeeId,
                'sourceLocationId' :assetRequisitionObj.sourceLocation,
                'designationLocationId' : assetRequisitionObj.destinationLocation,
                'formName' : 'assetRequisition',
                'itemId' : assetRequisitionObj.itemId,
                'quantity' : assetRequisitionObj.quantity,
                'eddDate' : assetRequisitionObj.eddDate,
                'companyId':assetRequisitionObj.companyId,
                'listAssetDetail' : displayedCollection
            };
                var myURL = 'hospital/asset/assetRequisition/saveAssetRequisition';
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
                        $state.go("app.hospital.asset.assetRequisition.list");
                    }

                }).error(function(data) {
                    logger.logError(" Error Not Saved!");
                });
            }else{
                toaster.pop('error',  
                        logger.logError("Check Fields Must equal to Quantity"));
            }
            }else{
                logger.logError("Asset Track Details Must");
            }
       };
       
       
       var originalObjectData = angular.copy($scope.assetRequisitionObj);
        $scope.reset = function(){
                $scope.assetRequisitionObj = angular.copy(originalObjectData);
        }
        
    });

    module.registerController('assetRequisitionEditCtrl', function($scope,$state,$stateParams, $http, ngDialog, logger,sharedProperties, toaster, $rootScope,validationService) {
        var areqId=$stateParams.assetRId;
        var areqType=$stateParams.type;
        $scope.isEdit = true;
        $scope.assetRequisitionObj = {
                assetrequisitionNo:'',
                assetrequisitionDate : '',
                employeeId : '',
                sourceLocation:'',
                destinationLocation : '',
                itemId : '',
                quantity : '',
                eddDate : '',
                companyId:'',
                deleteIds:[]
            }
       
            $scope.getDropdownvalue = function() {
                $http.get('app/hospital/purchase/storeToPurchase/employeeList').success(function(datas) {
                    $scope.employeeList = datas.employeeList;
                    
                }).error(function(data) {
                    logger.logError("Error Please Try Again");
                });
                
                /*$http.get("app/commonUtility/assetLocationlist").success(function(datas) {
                    $scope.destLocationList = datas;
                }).error(function(datas) {
                    logger.logError("Error Please Try Again");
                });*/
                $http.get("app/inventory/consignmentIn/parentlocationlist").success(function(datas) {
                    $scope.destLocationList = datas;
                }).error(function(data) {
                    logger.logError("Error Please Try Again");
                });
                
                $http.get('app/commonUtility/getCompanyList').success(function(datas) {
                    $scope.companyList = datas;
                    }).error(function(datas) {
                });
                $scope.getItemList();

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
                       
            var totalCheckedCount=0;
            $scope.getFetchEditDetails=function(areqId,reqType){
                var url = 'hospital/asset/assetRequisition/editDetailsAssetRequisition?assetRequistionId=' + areqId +'&type=' +reqType  ;
                $http.get(url).success(function(result) {
                          console.log(result);
                         $scope.assetRequisitionObj.assetrequisitionNo=result.objAssetRequisitionBean.assetrequisitionNo
                         $scope.assetRequisitionObj.assetrequisitionDate=result.objAssetRequisitionBean.assetrequisitionDate
                         $scope.assetRequisitionObj.employeeId=result.objAssetRequisitionBean.employeeId
                         $scope.assetRequisitionObj.sourceLocation=result.objAssetRequisitionBean.sourceLocationId;
                         $scope.assetRequisitionObj.destinationLocation=result.objAssetRequisitionBean.designationLocationId;
                         $scope.assetRequisitionObj.itemId=result.objAssetRequisitionBean.itemId
                         $scope.assetRequisitionObj.eddDate=result.objAssetRequisitionBean.eddDate
                         $scope.assetRequisitionObj.quantity=result.objAssetRequisitionBean.quantity
                         $scope.rowCollection=result.objAssetRequisitionBean.listAssetDetail;
                         $scope.assetRequisitionObj.companyId=result.objAssetRequisitionBean.companyId
                         totalCheckedCount=result.objAssetRequisitionBean.quantity
                }).error(function(result) {
                    logger.logError("Error Please Try Again");
                });
            }
            $scope.getFetchEditDetails(areqId,areqType);
            
            
            var globalId=1;
            $scope.$watch('assetRequisitionObj.eddDate',function(newValue,oldValue){
                if(newValue !== undefined && newValue !== ""){
                    var givenDate =newValue.split("/");
                    var from = new Date(givenDate[2], givenDate[1] - 1, givenDate[0]);
                    
                    var reqDateSplit=$scope.assetRequisitionObj.assetrequisitionDate.split("/");
                    var currentDate1 = new Date(reqDateSplit[2],reqDateSplit[1]-1,reqDateSplit[0]);
                    
                    if (from <  currentDate1 ) {
                        logger.logError("Select Date greater than Requistion's Date");
                        globalId=0;
                    }else{
                        globalId=1;
                    }
                }
            });
            
            $scope.submit = function(assetRequisitionObj,displayedCollection) {
                if (new validationService().checkFormValidity($scope.assetRequisitionForm)) {
                    if(globalId == 1){
                        $scope.update(assetRequisitionObj,displayedCollection);                        
                    }else{
                        logger.logError("Select Date greater than Requistion's Date");
                    }    
                    
                } else {
                    toaster.pop('error', "Please fill the required fields", 
                            logger.getErrorHtmlNew($scope.assetRequisitionForm.$validationSummary), 555000, 'trustedHtml');
                }
            };
            
            $scope.update = function(assetRequisitionObj,displayedCollection) {
                if(Number(assetRequisitionObj.quantity) === totalCheckedCount){
                var objData = {
                     'assetRequisitionId': areqId,
                    'assetrequisitionDate' : assetRequisitionObj.assetrequisitionDate,
                    'employeeId' : assetRequisitionObj.employeeId,
                    'sourceLocationId' :assetRequisitionObj.sourceLocation,
                    'designationLocationId' : assetRequisitionObj.destinationLocation,
                    'quantity' : assetRequisitionObj.quantity,
                    'eddDate' : assetRequisitionObj.eddDate,
                    'formName' : 'assetRequisition',
                    'companyId':assetRequisitionObj.companyId,
                    'ldeleteIds':assetRequisitionObj.deleteIds,
                    'listAssetDetail' : displayedCollection
                };
                    var myURL = 'hospital/asset/assetRequisition/updateAssetRequisition';
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
                            $state.go("app.hospital.asset.assetRequisition.list");
                        }

                    }).error(function(data) {

                    });
                }else{
                     
                            logger.logError("Check Fields Must equal to Quantity");
                }
           };
           
           $scope.cancel = function() {
               $state.go("app.hospital.asset.assetRequisition.list");
           }
           
           $scope.onCount=function(assetTrackConfirm,object){
               if(assetTrackConfirm){
                   totalCheckedCount++;
               }else if(!assetTrackConfirm){
                   totalCheckedCount--;
                   $scope.assetRequisitionObj.deleteIds.push(object.asstDetailId);
               }
           }
           
           

    });

});