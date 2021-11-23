define([ 'hospital/inventory/inventory' ], function(module) {
    'use strict';
    module.registerController('assetTransferAddCtrl', function($scope, $state, $http, ngDialog, $filter, logger, $location, $controller, validationService, $injector, sharedProperties, toaster, $rootScope) {
        $scope.assetTransferObj = {
              requisitionDate: '' ,
              requisitionBy: '' ,
              sourceLocationId: '' ,
              destLocationId: '' ,
              sourceLocName: '' ,
              destLocName: '' ,
              requisitionquantity:'',
              itemName: '' ,
              itemCategory: '' ,
              itemId: '' ,
              requisition:'',
              purchaseRequisitionDtlId: '' ,
              eddDate: '' ,
              transferquantity: '' ,
              transportType : '',
              serviceName : '',
              personName : '',
              deliveryMet : '',
              status : '',
              transferDate : '',
              companyId:'',
        };
        $scope.edit = false;

        $scope.assetTransferObj.transferDate = moment().format('DD/MM/YYYY');

        $scope.dropdownvalue = function() {
                // 1 --> New Data
            $http.get("hospital/asset/assettransfer/getDropdownData?id="+1).success(function(response) {
                if (response.success == true) {
                    $scope.RequisitionList = response.assetTransferBeano[0];
                    $scope.Delivery = response.assetTransferBeano[1];
                    $scope.Transportation = response.assetTransferBeano[2];
                }
            }).error(function(result) {
                logger.logError("Error Please Try Again dv");
            });
            
            $http.get('app/commonUtility/getCompanyList').success(function(datas) {
                $scope.companyList = datas;
                }).error(function(datas) {
            });
        }

        $scope.dropdownvalue();

        $scope.$watch('assetTransferObj.requisition', function(newValue, oldValue) {
            if (newValue != undefined && newValue != '') {
                $scope.requistiononchange(newValue);
            } else {

                $scope.assetTransferObj.requisitionDate = "";
                $scope.assetTransferObj.requisitionBy = "";
                $scope.assetTransferObj.sourceLocationId = "";
                $scope.assetTransferObj.destLocationId = "";
                $scope.assetTransferObj.sourceLocName = "";
                $scope.assetTransferObj.destLocName = "";
                $scope.assetTransferObj.itemName = "";
                $scope.assetTransferObj.itemCategory = "";
                $scope.assetTransferObj.itemId = "";
                $scope.assetTransferObj.purchaseRequisitionId="";
                $scope.assetTransferObj.purchaseRequisitionDtlId = "";
                $scope.assetTransferObj.eddDate = "";
                $scope.assetTransferObj.requisitionquantity = "";
                $scope.rowCollection = [];

            }

        });

        $scope.requistiononchange = function(requisition) {

            var obj = $filter('filter')($scope.RequisitionList, {
                id : requisition
            });
            $scope.assetTransferObj.requisitionDate = obj[0].requisitionDate;
            $scope.assetTransferObj.requisitionBy = obj[0].requisitionBy;
            $scope.assetTransferObj.sourceLocationId = obj[0].sourceLocationId;
            $scope.assetTransferObj.destLocationId = obj[0].destLocationId;
            $scope.assetTransferObj.sourceLocName = obj[0].sourceLocName;
            $scope.assetTransferObj.destLocName = obj[0].destLocName;
            $scope.assetTransferObj.itemName = obj[0].itemName;
            $scope.assetTransferObj.itemCategory = obj[0].itemCategory;
            $scope.assetTransferObj.itemId = obj[0].itemId;
            
            $scope.assetTransferObj.purchaseRequisitionDtlId = obj[0].purchaseRequisitionDtlId
            $scope.assetTransferObj.eddDate = obj[0].eddDate
            $scope.assetTransferObj.requisitionquantity = obj[0].requisitionquantity
            $scope.rowCollection = obj[0].lassetTrackDetails;

        }

        $scope.reset = function() {
            $scope.assetTransferObj = {};
            $scope.assetTransferObj.date = moment().format('DD/MM/YYYY');
            $scope.dropdownvalue();
        }

        $scope.$watch('assetTransferObj.transportType', function(newValue, oldValue) {
            if (newValue != undefined && newValue != '') {
                $scope.transportationonchange(newValue);
            }
        });

        $scope.transportationonchange = function(transportType) {

            var obj = $filter('filter')($scope.Transportation, {
                id : transportType
            });
            if (obj[0].text == "By Person") {
                $('#personname').show();
                $('#servicename').hide();
            }
            if (obj[0].text == "Courier") {
                $('#servicename').show();
                $('#personname').hide();
            }
        }
        var totalCheckedCount = 0;
        $scope.onCount = function(assetTrackConfirm) {
            if (assetTrackConfirm) {
                totalCheckedCount++;
                $scope.assetTransferObj.transferquantity=totalCheckedCount;
            } else if (!assetTrackConfirm) {
                totalCheckedCount--;
                $scope.assetTransferObj.transferquantity=totalCheckedCount;
            }
        }
        $scope.cancel1 = function() {
            $state.go('app.hospital.asset.assettransfer.list');
        };

        $scope.submit = function(assetTransferObj,rowCollection) {
            if (new validationService().checkFormValidity($scope.assetTransferForm)) {
                    $scope.save(assetTransferObj,rowCollection);
            } else {
                toaster.pop('error', "Please fill the required fields", 
                        logger.getErrorHtmlNew($scope.assetTransferForm.$validationSummary), 555000, 'trustedHtml');
            }
        };
        
        $scope.save = function(assetTransferObj,assetTrack) {
            var jsonData={
                    'requisition':assetTransferObj.requisition,
                    'transportType': assetTransferObj.transportType,
                    'serviceName' :assetTransferObj.serviceName,
                    'personName' : assetTransferObj.personName,
                    'deliveryMet' :assetTransferObj.deliveryMet,
                    'status' : assetTransferObj.status,
                    'transferDate' : assetTransferObj.transferDate,
                    'sourceLocationId': assetTransferObj.sourceLocationId ,
                    'destLocationId': assetTransferObj.destLocationId ,
                    'requisitionBy':  assetTransferObj.requisitionBy ,
                    'itemId': assetTransferObj.itemId ,
                    'eddDate': assetTransferObj.eddDate ,
                    'transferquantity': assetTransferObj.transferquantity,
                    'companyId':assetTransferObj.companyId,
                    'lassetTrackDetails':assetTrack
            }
            var myURL = 'hospital/asset/assettransfer/save';
            $http({
                url : myURL,
                data : jsonData,
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
                    $state.go("app.hospital.asset.assettransfer.list");
                }

            }).error(function(data) {

            });
            
            
        }

    });
    
    module.registerController('assetTransferEditCtrl', function($scope,$stateParams, $state, $http, ngDialog, $filter, logger, $location, $controller, validationService, $injector, sharedProperties, toaster, $rootScope) {
        
        var assTransferId=$stateParams.assetTransferId;
        
        $scope.assetTransferObj = {
              assetTransferId:'',
              assetTransferNo:'',
              requisitionDate: '' ,
              requisitionBy: '' ,
              sourceLocationId: '' ,
              destLocationId: '' ,
              sourceLocName: '' ,
              destLocName: '' ,
              requisitionquantity:'',
              itemName: '' ,
              itemCategory: '' ,
              itemId: '' ,
              requisition:'',
              purchaseRequisitionDtlId: '' ,
              eddDate: '' ,
              transferquantity: '' ,
              transportType : '',
              serviceName : '',
              personName : '',
              deliveryMet : '',
              status : '',
              transferDate : '',
              assetTransferDetailID:'',
              companyId:'',
        };
        
        $scope.edit = true;
        

        $scope.dropdownvalue = function() {
         // 2 -->Edit Data
            $http.get("hospital/asset/assettransfer/getDropdownData?id="+2).success(function(response) {
                
                if (response.success) {
                    $scope.RequisitionList = response.assetTransferBeano[0];
                    $scope.Delivery = response.assetTransferBeano[1];
                    $scope.Transportation = response.assetTransferBeano[2];
                    $scope.editfunc(assTransferId);
                }
            }).error(function(result) {
                logger.logError("Error Please Try Again dv");
            });
            
            $http.get('app/commonUtility/getCompanyList').success(function(datas) {
                $scope.companyList = datas;
                }).error(function(datas) {
            });
        }

        $scope.dropdownvalue();
        
        
        $scope.$watch('assetTransferObj.requisition', function(newValue, oldValue) {
            if (newValue != undefined && newValue != '' ) {
                $scope.requistiononchange(newValue);
            } else {
                $scope.assetTransferObj.requisitionDate = "";
                $scope.assetTransferObj.requisitionBy = "";
                $scope.assetTransferObj.sourceLocationId = "";
                $scope.assetTransferObj.destLocationId = "";
                $scope.assetTransferObj.sourceLocName = "";
                $scope.assetTransferObj.destLocName = "";
                $scope.assetTransferObj.itemName = "";
                $scope.assetTransferObj.itemCategory = "";
                $scope.assetTransferObj.itemId = "";
                $scope.assetTransferObj.purchaseRequisitionId="";
                $scope.assetTransferObj.purchaseRequisitionDtlId = "";
                $scope.assetTransferObj.eddDate = "";
                $scope.assetTransferObj.requisitionquantity = "";
                $scope.rowCollection = [];
            }

        });
        
        // To Load Old Values
        var k=0;
        
        $scope.requistiononchange = function(requisition) {

            var obj = $filter('filter')($scope.RequisitionList, {
                id : requisition
            });
            $scope.assetTransferObj.requisitionDate = obj[0].requisitionDate;
            $scope.assetTransferObj.requisitionBy = obj[0].requisitionBy;
            $scope.assetTransferObj.sourceLocationId = obj[0].sourceLocationId;
            $scope.assetTransferObj.destLocationId = obj[0].destLocationId;
            $scope.assetTransferObj.sourceLocName = obj[0].sourceLocName;
            $scope.assetTransferObj.destLocName = obj[0].destLocName;
            $scope.assetTransferObj.itemName = obj[0].itemName;
            $scope.assetTransferObj.itemCategory = obj[0].itemCategory;
            $scope.assetTransferObj.itemId = obj[0].itemId;
            $scope.assetTransferObj.purchaseRequisitionDtlId = obj[0].purchaseRequisitionDtlId
            $scope.assetTransferObj.eddDate = obj[0].eddDate
            $scope.assetTransferObj.requisitionquantity = obj[0].requisitionquantity
            if(k > 0){
                $scope.rowCollection = obj[0].lassetTrackDetails;
            }
            k=1;
            

        }
        var totalCheckedCount = 0;
        $scope.editfunc = function(assTransferId) {
                  $http.post("hospital/asset/assettransfer/edit", assTransferId).success(function(response) {
                      
                      $scope.transfer = response.assetTransferBeanl[0];
                        $scope.assetTransferObj.assetTransferId=$scope.transfer.assetTransferId;
                        $scope.assetTransferObj.assetTransferDetailID=$scope.transfer.assetTransferDtlId;
                        $scope.assetTransferObj.requisition = $scope.transfer.requisition;
                        $scope.assetTransferObj.transportType = $scope.transfer.transportType;
                        $scope.assetTransferObj.deliveryMet = $scope.transfer.deliveryMet.toString();
                        $scope.assetTransferObj.status = $scope.transfer.status;
                        $scope.assetTransferObj.serviceName = $scope.transfer.serviceName;
                        $scope.assetTransferObj.personName = $scope.transfer.personName;
                        $scope.assetTransferObj.assetTransferNo = $scope.transfer.assetTransferNo;
                        $scope.assetTransferObj.transferDate=$scope.transfer.transferDate;
                        $scope.assetTransferObj.transferquantity=$scope.transfer.transferquantity;
                        $scope.rowCollection = $scope.transfer.lassetTrackDetails;
                        totalCheckedCount=$scope.assetTransferObj.transferquantity;
                        $scope.transportationonchange($scope.transfer.transportType);
                        $scope.assetTransferObj.companyId=$scope.transfer.companyId;
          
                    }).error(function(result) {
                        logger.logError("Error Please Try Again ");
                    });

         
        }

        
        $scope.reset1 = function() {
            $http.post("hospital/asset/assettransfer/edit", stockId).success(function(response) {

                $scope.transfer = response.assetTransferBeanl[0];

                $scope.data = $scope.transfer;
                $scope.assetTransferObj.requisition = $scope.transfer.requisition.toString();
                $scope.assetTransferObj.transportType = $scope.transfer.transportType.toString();
                $scope.assetTransferObj.deliveryMet = $scope.transfer.deliveryMet.toString();
                $scope.assetTransferObj.status = $scope.transfer.status;
                $scope.status = $scope.transfer.status;
                $scope.assetTransferObj.serviceName = $scope.transfer.serviceName;
                $scope.assetTransferObj.personName = $scope.transfer.personName;
                $scope.assetTransferObj.stockId = $scope.transfer.stockId;
                var obj = $filter('filter')($scope.RequisitionList, {
                    id : $scope.transfer.requisition
                });

                $scope.assetTransferObj.requisitionDate = obj[0].requisitionDate;
                $scope.assetTransferObj.requisitionBy = obj[0].requisitionBy;
                $scope.assetTransferObj.sourceLoc = obj[0].sourceLocationId;
                $scope.assetTransferObj.destLoc = obj[0].destLoc;
                $scope.assetTransferObj.sourceLocName = obj[0].sourceLocName;
                $scope.assetTransferObj.destLocName = obj[0].destLocName;

                $scope.ItemList = $scope.transfer.itemlist
                $scope.transportationonchange($scope.transfer.transportType);
                $scope.assetTransferObj.rowCollection = [];
                

            }).error(function(result) {
                logger.logError("Error Please Try Again ");
            });
        }

        $scope.$watch('assetTransferObj.transportType', function(newValue, oldValue) {
            if (newValue != undefined && newValue != '') {
                $scope.transportationonchange(newValue);
            }
        });
        $scope.transportationonchange = function(transportType) {
            var obj = $filter('filter')($scope.Transportation, {
                id : transportType
            });
            if (obj[0].text == "By Person") {
                $('#personname').show();
                $('#servicename').hide();
            }
            if (obj[0].text == "Courier") {
                $('#servicename').show();
                $('#personname').hide();
            }
        }
        
        
        
        
        $scope.onCount = function(assetTrackConfirm) {
            if (assetTrackConfirm) {
                totalCheckedCount++;
                $scope.assetTransferObj.transferquantity=totalCheckedCount;
            } else if (!assetTrackConfirm) {
                totalCheckedCount--;
                $scope.assetTransferObj.transferquantity=totalCheckedCount;
            }
        }
        $scope.cancel1 = function() {
            $state.go('app.hospital.asset.assettransfer.list');
        };

        
        $scope.submit = function(assetTransferObj,rowCollection) {
            if (new validationService().checkFormValidity($scope.assetTransferForm)) {
                    $scope.update(assetTransferObj,rowCollection);
            } else {
                toaster.pop('error', "Please fill the required fields", 
                        logger.getErrorHtmlNew($scope.assetTransferForm.$validationSummary), 555000, 'trustedHtml');
            }
        };
        $scope.update = function(assetTransferObj,assetTrack) {
            
            var jsonData={
                    'assetTransferId':assetTransferObj.assetTransferId,
                    'assetTransferDtlId':assetTransferObj.assetTransferDetailID,
                     'assetTransferNo':assetTransferObj.assetTransferNo,
                    'requisition':assetTransferObj.requisition,
                    'transportType': assetTransferObj.transportType,
                    'serviceName' :assetTransferObj.serviceName,
                    'personName' : assetTransferObj.personName,
                    'deliveryMet' :assetTransferObj.deliveryMet,
                    'status' : assetTransferObj.status,
                    'transferDate' : assetTransferObj.transferDate,
                    'sourceLocationId': assetTransferObj.sourceLocationId ,
                    'destLocationId': assetTransferObj.destLocationId ,
                    'requisitionBy':  assetTransferObj.requisitionBy ,
                    'itemId': assetTransferObj.itemId ,
                    'eddDate': assetTransferObj.eddDate ,
                    'transferquantity': assetTransferObj.transferquantity,
                    'companyId':assetTransferObj.companyId,
                    'lassetTrackDetails':assetTrack
            }
            var myURL = 'hospital/asset/assettransfer/update';
            $http({
                url : myURL,
                data : jsonData,
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
                    $state.go("app.hospital.asset.assettransfer.list");
                }

            }).error(function(data) {

            });
            
            
        }

    });

});