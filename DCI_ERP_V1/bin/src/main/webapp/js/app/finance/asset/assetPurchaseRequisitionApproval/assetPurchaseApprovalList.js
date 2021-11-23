define([ 'hospital/asset/asset' ], function(module) {

    'use strict';

    module.registerController('purchaseAssetApprovalListCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {

        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages = 0;
        $scope.isUpload = true;
        $scope.isAdd = true;
        $scope.isDelete = true;
        
        $scope.add = function(){
            $state.go("app.hospital.asset.assetPurchaseRequisitions.add");
        }
        
        $scope.getAssetRequisitionList = function() {
            $http.get('hospital/asset/assetApproval/list').success(function(data) {
                if (data.success) {
                    $scope.rowCollection = data.listAssetApprovalBean;
               } else {
                    logger.logError("Error Please Try Again");
                }
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        };

       $scope.getAssetRequisitionList();
        
       $scope.editRow = function(assetReqid) {
           $state.go('app.hospital.asset.assetPurchaseRequisitionsApproval.edit',({ 'assetPRId': assetReqid}));
       }
       
       $scope.viewRow = function(assetReqid) {
           $state.go('app.hospital.asset.assetPurchaseRequisitionsApproval.view',({ 'assetPRId': assetReqid,'ID' : 1}));
       }
       
       
       $scope.deleteRow=function(amcId,index){
           
           var myURL = 'hospital/asset/assetmaintenanceContract/delete';
           $http({
               method : 'post',
               url : myURL,
               data : amcId,
           }).success(function(data) {
               if (data == true) {
                   var tableData = $scope.rowCollection;
                   $scope.rowCollection.splice(index, 1);
                   logger.logSuccess("Deleted successfully");
                   $state.reload();
               } else {
                   logger.logError("Error in delete!");
               }
           }).error(function(data) {
               logger.logSuccess("Error in Delete!");
           });
       }
    });
    
    module.registerController('purchaseAssetApprovalEditCtrl', function($scope,$stateParams, $state,$filter, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope,validationService) {

        var aPreqId=$stateParams.assetPRId;
        var formName="";
        var id=$stateParams.ID;
        
        if(id == 1){
            $scope.isView = true;    
            formName="viewDetails"
        }else{
            $scope.isView = false;
            formName="editDetails"
        }
        
        $scope.assetApproval = {
                purchaseAssetrequisitionId:'',
                purchaseAssetrequisitionNo:'',
                purchaseAssetrequisitionDate : '',
                assetApprovalStatusId :'',
                approveDate :'',
                employeeName : '',
                validatedBy:'',
                designationLocationName : '',
                tables : []
            }

        $scope.assetApproval.tables = [ {
            row : []
        } ]; 
       
        var currentDate = new Date();
        currentDate = ('0' + currentDate.getDate()).slice(-2)+"/"+('0' + (currentDate.getMonth() + 1)).slice(-2)+"/"+currentDate.getFullYear();
        $scope.assetApproval.approveDate = currentDate;
       
        $scope.getDropdownvalue = function() {
            $http.get('app/hospital/purchase/storeApproval/employeeList').success(function(datas) {
                $scope.statusList = datas.statusList;
                console.log($scope.statusList)
                $scope.employeeList = datas.employeeList;
                $scope.getFetchEditDetails(aPreqId,formName);
            }).error(function(data) {
            });
        }
        $scope.getDropdownvalue();

           $scope.getFetchEditDetails=function(aPreqId,formName){
                var url = 'hospital/asset/assetApproval/'+formName+'?assetRequistionId=' + aPreqId
                $http.get(url).success(function(result) {
                        $scope.assetApproval.purchaseAssetrequisitionNo=result.objAssetApprovalBean.purchaseAssetrequisitionNo;
                         $scope.assetApproval.purchaseAssetrequisitionDate=result.objAssetApprovalBean.purchaseAssetrequisitionDate;
                         $scope.assetApproval.employeeName=result.objAssetApprovalBean.employeeName;
                         $scope.assetApproval.designationLocationName=result.objAssetApprovalBean.designationLocationName;
                         if(result.objAssetApprovalBean.validatedBy !== null){
                             $scope.assetApproval.validatedBy=result.objAssetApprovalBean.validatedBy;    
                         }if(result.objAssetApprovalBean.assetApprovalStatusId !== null){
                             $scope.assetApproval.assetApprovalStatusId=result.objAssetApprovalBean.assetApprovalStatusId;
                         }
                         
                         if(id == 1){
                             var empObj = $filter('filter')($scope.employeeList, {
                                 id :  $scope.assetApproval.validatedBy
                             })[0];
                             $scope.employeeName=empObj.text
                             
                             var statObj = $filter('filter')($scope.statusList, {
                                 requisitionStatus : $scope.assetApproval.assetApprovalStatusId
                             })[0];
                             $scope.statusName=statObj.requisitionStatusName      
                         }
                         
                         $scope.assetApproval.tables[0].row=result.listAssetEditDetail;
                         $scope.assetApproval.assetApprovalStatusId=67
                }).error(function(result) {
                    logger.logError("Error Please Try Again");
                });
            }
           
           $scope.submit = function(assetApproval) {
               if (new validationService().checkFormValidity($scope.assetPurchaseApprovalViewForm)) {
                       $scope.approve(assetApproval);
               } else {
                   toaster.pop('error', "Please fill the required fields", 
                           logger.getErrorHtmlNew($scope.assetPurchaseApprovalViewForm.$validationSummary), 555000, 'trustedHtml');
               }
           };
            $scope.approve = function(assetApproval) {
                var objData = {
                        'purchaseAssetRequisitionId': aPreqId,
                        'approveDate' : assetApproval.approveDate,
                        'validatedBy':assetApproval.validatedBy,
                        'assetApprovalStatusId' : assetApproval.assetApprovalStatusId,
                    };
                    var myURL = 'hospital/asset/assetApproval/update';
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
                            $state.go("app.hospital.asset.assetPurchaseRequisitionsApproval.list");
                        }

                    }).error(function(data) {

                    });
           };
           
           $scope.cancel = function() {
               $state.go("app.hospital.asset.assetPurchaseRequisitionsApproval.list");
           }
       
     
    });
    
});