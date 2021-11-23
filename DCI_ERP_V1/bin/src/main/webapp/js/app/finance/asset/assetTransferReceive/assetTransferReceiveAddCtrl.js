define([ 'hospital/inventory/inventory' ], function(module) {
    'use strict';
    module.registerController('assetTransferReceiveAddCtrl', function($scope, $state, $http, ngDialog, $filter, logger, $location, $controller, validationService, $injector, sharedProperties, toaster, $rootScope) {
        $scope.assetTransferObj = {
            requisitionDate : '',
            requisitionBy : '',
            sourceLocationId : '',
            destLocationId : '',
            sourceLocName : '',
            destLocName : '',
            requisitionquantity : '',
            itemName : '',
            itemCategory : '',
            itemId : '',
            purchaseRequisitionDtlId : '',
            eddDate : '',
            transferquantity : '',
            transportType : '',
            serviceName : '',
            personName : '',
            requisition : '',
            deliveryMet : '',
            status : '',
            transferDate : '',
            reason : '',
            companyId:'',
            pendingquantity : '',
        };

        $scope.assetTransferObjView = {
            requisitionDate : '',
            requisitionBy : '',
            sourceLocationId : '',
            destLocationId : '',
            sourceLocName : '',
            destLocName : '',
            requisitionquantity : '',
            itemName : '',
            itemCategory : '',
            itemId : '',
            purchaseRequisitionDtlId : '',
            eddDate : '',
            transferquantity : '',
            transportType : '',
            serviceName : '',
            personName : '',
            requisition : '',
            deliveryMet : '',
            status : '',
            transferDate : '',
            reason : '',
            pendingquantity : '',
            rowCollection : []
        };
        $scope.edit = false;

        var d = new Date();
        var year = d.getFullYear();
        var month = d.getMonth() + 1;
        if (month < 10) {
            month = "0" + month;
        }
        ;
        var day = d.getDate();
        if (day < 10) {
            day = "0" + day;
        }
        ;
        $scope.date = day + "/" + month + "/" + year;
        $scope.assetTransferObj.transferDate = $scope.date;

        $scope.dropdownvalue = function() {

            $http.get("hospital/asset/assetTransferReceive/getDropdownData").success(function(response) {
                $scope.RequisitionList = response.assetTransferReceiveBeano[0];
                $scope.assetTransferObj.pendingquantity = $scope.RequisitionList[0].pendingquantity;
                
            }).error(function(result) {
                logger.logError("Error Please Try Again dv");
            });

            $http.get('app/hospital/purchase/storeToStore/employeeList').success(function(datas) {
                $scope.assetTransferObj.receiviedBy = datas.userId;
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
                $scope.assetTransferObj.purchaseRequisitionId = "";
                $scope.assetTransferObj.purchaseRequisitionDtlId = "";
                $scope.assetTransferObj.eddDate = "";
                $scope.assetTransferObj.requisitionquantity = "";
                $scope.rowCollection = [];

            }

        });
        $scope.trackList = [];
        $scope.requistiononchange = function(requisition) {

            var obj = $filter('filter')($scope.RequisitionList, {
                id : requisition
            });

            $http.get('app/hospital/purchase/storeToStore/employeeList').success(function(datas) {
                $scope.assetTransferObj.receiviedBy = datas.userId;
                $scope.employeeList = datas.employeeList;
            }).error(function(result) {
                logger.logError("Error Please Try Again dv");
            });
            
            $scope.assetTransferObj.transferNo = obj[0].text;
            $scope.assetTransferObj.requisitionDate = obj[0].requisitionDate;
            $scope.assetTransferObj.requisitionBy = obj[0].requisitionBy;
            $scope.assetTransferObj.sourceLocationId = obj[0].sourceLocationId;
            $scope.assetTransferObj.destLocationId = obj[0].destLocationId;
            $scope.assetTransferObj.sourceLocName = obj[0].sourceLocName;
            $scope.assetTransferObj.destLocName = obj[0].destLocName;
            $scope.assetTransferObj.itemName = obj[0].itemName;
            $scope.assetTransferObj.itemCategory = obj[0].itemCategory;
            $scope.assetTransferObj.itemId = obj[0].itemId;
            $scope.assetTransferObj.assetTransferId = obj[0].assetTransferId;

            $scope.assetTransferObj.purchaseRequisitionDtlId = obj[0].purchaseRequisitionDtlId;
            $scope.assetTransferObj.eddDate = obj[0].eddDate;
            $scope.assetTransferObj.requisitionquantity = obj[0].requisitionquantity;
            $scope.assetTransferObj.pendingquantity = obj[0].pendingquantity;
            $scope.rowCollection = obj[0].lassetTrackDetails;
            $http.post("hospital/asset/assetTransferReceive/itemTrackList", requisition).success(function(response) {
                $scope.manageAssetlist = response.manageAssetlist;
            }).error(function(result) {
                logger.logError("Error Please Try Again ");
            });

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
        
        
        $scope.reset = function() {
            $scope.assetTransferObj = {};
            $scope.assetTransferObj.transferDate = $scope.date;
            $scope.dropdownvalue();
        }
        
        $scope.reset1 = function() {


            $http.get('hospital/asset/assetTransferReceive/view?id=' + id).success(function(data) {
                $scope.edit = true;
                $scope.assetTransferObjView = data.assetTransferReceiveBeanl[0];

                $scope.assetTransferObjView.rowCollection = $scope.assetTransferObjView.lassetTrackDetails;

                rowCount = $scope.assetTransferObjView.rowCollection.length;

                console.log("data***********");
                console.log($scope.assetTransferObjView.rowCollection);

            }).error(function(data) {
            });
        
        }

        //Edit Functionality
        var rowCount = 0;
        $scope.viewReceiveData = function() {
            
            $http.get('app/hospital/purchase/storeToStore/employeeList').success(function(datas) {
                $scope.assetTransferObj.receiviedBy = datas.userId;
            }).error(function(result) {
                logger.logError("Error Please Try Again dv");
            });
            $http.get('hospital/asset/assetTransferReceive/view?id=' + id).success(function(data) {
                $scope.edit = true;
                $scope.assetTransferObjView = data.assetTransferReceiveBeanl[0];
                $scope.assetTransferObjView.rowCollection = $scope.assetTransferObjView.lassetTrackDetails;
                rowCount = $scope.assetTransferObjView.rowCollection.length;
            }).error(function(data) {
            });
        }

        var rowCount = 0;
        var id = $location.search().id;

        if (id == undefined || id == null || id == "") {
            $scope.edit = false;
            $scope.dropdownvalue();
        } else {
            $scope.edit = true;
            $scope.viewReceiveData();
        }

             
              $scope.reset1 = function() {
                  
                      $scope.assetTransferObjView = [];
                      $scope.assetTransferObjView.date = $scope.date;
                      $scope.dropdownvalue();
                  
                  
              }
         

      
        $scope.cancel1 = function() {
            $state.go('app.hospital.asset.assetTransferReceive.list');
        };

        $scope.submit = function(assetTransferObj,displayedCollection) {
            if (new validationService().checkFormValidity($scope.assetTransferReceiveForm)) {
                    $scope.save(assetTransferObj,displayedCollection);
            } else {
                toaster.pop('error', "Please fill the required fields", 
                        logger.getErrorHtmlNew($scope.assetTransferReceiveForm.$validationSummary), 555000, 'trustedHtml');
            }
        };
        
        $scope.save = function(assetTransferObj, assetTrack) {
            var jsonData = {
                'requisition' : assetTransferObj.requisition,
                'transportType' : assetTransferObj.transportType,
                'serviceName' : assetTransferObj.serviceName,
                'personName' : assetTransferObj.personName,
                'deliveryMet' : assetTransferObj.deliveryMet,
                'status' : assetTransferObj.status,
                'transferDate' : assetTransferObj.transferDate,
                'sourceLocationId' : assetTransferObj.sourceLocationId,
                'destLocationId' : assetTransferObj.destLocationId,
                'receiviedBy' : assetTransferObj.receiviedBy,
                'itemId' : assetTransferObj.itemId,
                'eddDate' : assetTransferObj.eddDate,
                'reason' : assetTransferObj.reason,
                'transferNo' : assetTransferObj.transferNo,
                'transferquantity' : assetTransferObj.transferquantity,
                'pendingquantity' : assetTransferObj.pendingquantity,
                'companyId':assetTransferObj.companyId,
                'lassetTrackDetails' : assetTrack
            }
            console.log(jsonData);
           var myURL = 'hospital/asset/assetTransferReceive/save';
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
                    $state.go("app.hospital.asset.assetTransferReceive.list");
                }

            }).error(function(data) {

            });

        }

    });

});