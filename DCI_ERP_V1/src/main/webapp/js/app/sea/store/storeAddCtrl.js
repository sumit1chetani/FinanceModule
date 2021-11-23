//define([ 'hospital/purchase/purchase' ], function(module) {

    'use strict';

    app.controller('storeAddCtrl', function($scope, $state,$filter, $http,$stateParams, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope,validationService) {
        
        $scope.companyList =[];
        $scope.employeeList = [];
        $scope.locationList = [];
        $scope.destLocationList =[];
        $scope.isEdit = false;
        $scope.storeToStoreData = {
            purchaseRequisitionId : '',
            requisitionNumber : '',
            requisitionDate : '',
            employeeId : '',
            employeeName : '',
            requisitionType : '',
            designationName : '',
            sourceLocationName : '',
            destinationLocationName : '',
            sourceLocation : '',
            destinationLocation : '',
            designationId : '',
            companyId :'',
            tables : []
        };
        
        $scope.date = '';
        
        var today = new Date();
        var dd = today.getDate();
        var mm = today.getMonth() + 1; //January is 0!
        var yyyy = today.getFullYear();
        $scope.resetValue=false;
        $scope.resetValueNew=false;
        if (dd < 10) {
            dd = '0' + dd;
        }
        if (mm < 10) {
            mm = '0' + mm;
        }

        var today = dd + '/' + mm + '/' + yyyy;
        $scope.date = today;
       

        //Watch method for Invoice From Date
        var initializing = true;
     
            
        $scope.cancel = function() {
            $state.go("app.sea.store.list");
        };
        
    
        
        $scope.$watchCollection('[ storeToStoreData.sourceLocation,storeToStoreData.destinationLocation]', function(newValues,oldvalues){
            var newSourceValue=[];
            newSourceValue=newValues;
            newSourceValue=newSourceValue[0];
            var oldSourcevalues=[];
            oldSourcevalues=oldvalues;
            oldSourcevalues=oldSourcevalues[0];
            if($scope.storeToStoreData.sourceLocation!=undefined && $scope.storeToStoreData.sourceLocation!=null && $scope.storeToStoreData.sourceLocation!=''){
                if(newSourceValue!="" && newSourceValue!=undefined && newSourceValue!="" && newSourceValue!=',' && oldSourcevalues!=null && oldSourcevalues!="" && oldSourcevalues!=undefined && oldSourcevalues!=','){
                    if(newSourceValue!=oldSourcevalues){
                       $scope.loadTable();
                       if($scope.isEdit==false){
                            $scope.loadTable();
                        }
                      
                    }
                }
           
                
            }
            
                
            
            $scope.locationChange($scope.storeToStoreData.sourceLocation,$scope.storeToStoreData.destinationLocation);
        });
        
        $scope.locationChange=function(sourceLocation,destinationLocation){
            
             if(sourceLocation!="" && sourceLocation!=undefined && sourceLocation!=null && destinationLocation!="" && destinationLocation!=undefined && destinationLocation!=null){
                if(sourceLocation == destinationLocation){
                    if($scope.isEdit==false){
                        $scope.storeToStoreData.sourceLocation='';
                    }
                    $scope.storeToStoreData.destinationLocation='';
                 
                    logger.logError("Source Location and Destination Location Should not be Same!");
                }
            }
        };
        
        
     
        
        //load table
        $scope.loadTable = function() {
           
            $scope.storeToStoreData.tables=[];
            var table = {};

            table.storeTableRow = [ {
                slNo : '',
                purchaseRequisitionId : '',
                purchaseRequisitionSubId : '',
                itemId : '',
                itemCode : '',
                itemName : '',
                itemDesc : '',
                itemCategoryId : '',
                itemCategoryName : '',
                uomId : '',
                uomName : '',
                quantity : '',
                physicalQty :'',
                eddDate :  $scope.date,
                select : false,
                disableDate:false,
                checkPhysicalQuantity: false,
                availQty: ''
                
            } ];
            $scope.storeToStoreData.tables.push(table);
        }
        $scope.loadTable();

        //add Row
        $scope.addRow = function(tables) {
            var len = tables.storeTableRow.length;
            var table = {
                slNo : '',
                purchaseRequisitionId : '',
                purchaseRequisitionSubId : '',
                itemId : '',
                itemCode : '',
                itemName : '',
                itemDesc : '',
                itemCategoryId : '',
                itemCategoryName : '',
                uomId : '',
                uomName : '',
                quantity : '',
                physicalQty :'',
                eddDate :  $scope.date,
                select : false,
                disableDate:false,
                checkPhysicalQuantity: false,
                availQty: ''
            };

            tables.storeTableRow.push(table);
        };

        //remove Row
        $scope.removeRow = function(table) {
            $scope.tablerow = [];
            var isSelectItem=false;
            angular.forEach(table.storeTableRow, function(storeTableRow, index) {
               if (storeTableRow.select == false) {
                   $scope.tablerow.push(storeTableRow);
                }else {
                    if (storeTableRow.select == true){
                        isSelectItem=true;
                    }
                 }
            });
            table.storeTableRow = $scope.tablerow;
            
            if(isSelectItem==false){
                logger.logError("Please select atleast one item to delete");
            }
        };
        
        //Employee List
        var userId="";

        $scope.getDropdownvalue = function() {

            $http.get("app/inventory/consignmentIn/parentlocationlist").success(function(datas) {
                $scope.parentLocationList = datas;
            });
            
            $http.get( $stateParams.tenantid+'/app/commonUtility/getCompanyListPurchase').success(function(datas) {
                $scope.companyList = datas;
                }).error(function(datas) {
            });

            $http.get('app/hospital/purchase/storeToStore/employeeList').success(function(datas) {

                $scope.employeeList = datas.employeeList;
                $scope.locationList = datas.locationList;
                $scope.itemList = datas.itemList;
                $scope.destLocationList = datas.destLocationList;
                 userId=datas.userId;

                 $scope.sessionName(userId);

            }).error(function(data) {

            });
           
        }
        $scope.getDropdownvalue();

        var userName="";
        var  designationName="";
        $scope.sessionName=function(userId){

            angular.forEach($scope.employeeList,function(value,key){

                if(userId == value.employeeId){
                    userName = value.employeeId;
                    designationName =value.designationName;

                }
                $scope.storeToStoreData.employeeId=userName;
                $scope.storeToStoreData.designationName = designationName;
            });


        }

        //Fetching job Title
        $scope.reset=false;
        
        var designationName="";
        $scope.$watch('storeToStoreData.employeeId', function(newValue, oldValue) {
         angular.forEach( $scope.employeeList,function(value,key){
             if(newValue ==  value.employeeId){
                 designationName = value.designationName;
             }

             $scope.storeToStoreData.designationName=designationName;

         });

        });
        
        $scope.chkAll=false;
        $scope.checkAll = function (rowCollection,checkBox) {
          if(checkBox) {
                $scope.chkAll=true;
            } else {
                $scope.chkAll = false;
            }
            var i=0;
            angular.forEach($scope.storeToStoreData.tables[0].storeTableRow, function (value, key) {
                value.select=$scope.chkAll;
            });
       
        };
        
        //Save Functionality
        $scope.save = function(storeToStoreAddForm,storeToStoreData) {
            
            var isQuantity = 0;
            var flag=true;
            
            var objheaderData = {
                    'purchaseRequisitionId' : $scope.storeToStoreData.purchaseRequisitionId,
                    'requisitionNumber' : $scope.storeToStoreData.requisitionNumber,
                    'requisitionDate' : $scope.storeToStoreData.requisitionDate,
                    'employeeId' : $scope.storeToStoreData.employeeId,
                    'requisitionType' : $scope.storeToStoreData.requisitionType,
                    'sourceLocation' : $scope.storeToStoreData.sourceLocation,
                    'destinationLocation' : $scope.storeToStoreData.destinationLocation,
                    'companyId' : $scope.storeToStoreData.companyId
                };

                var objWholeData = {
                    'headerData' : objheaderData,
                    'subData' : $scope.storeToStoreData.tables[0].storeTableRow
                };
                
            if (new validationService().checkFormValidity($scope.storeToStoreAddForm)) {
                
                if($scope.storeToStoreData.tables[0].storeTableRow.length==0){
                    flag=false;
                }
              
              if(flag==true){
                  
                  angular.forEach($scope.storeToStoreData.tables[0].storeTableRow, function (value, key) {
                      if(value.quantity<=0){
                          isQuantity = 1;
                          value.quantity = '';
                      }
                  });
                  
                  
                  if(isQuantity==1){
                      logger.logError("Quantity Must be Greater than Zero!");
                  }else{
                      
                      var isDelete = false;
                      angular.forEach($scope.storeToStoreData.tables[0].storeTableRow, function (value) {
                          if(value.select==true){
                              isDelete = true;
                          }
                      });
                      
                      if(isDelete==false){
                          logger.logError("Please Select Atleast One Row!");
                      }else{
                          if(new validationService().checkFormValidity($scope.storeToStoreAddForm)){
                              debugger
                              if($scope.storeToStoreData.tables[0].storeTableRow.length>0){
                                  var isPhysicalQuantity = false;
                                  angular.forEach($scope.storeToStoreData.tables[0].storeTableRow,function(value,key){
                                      if(value.checkPhysicalQuantity==true){
                                          isPhysicalQuantity = true;
                                      }
                                      if(value.physicalQty==""){
                                          isPhysicalQuantity = true;
                                      }
                                  });
                                  
                                  if(isPhysicalQuantity){
                                      logger.logError("Physical Qty should not exceed Available Qty!");
                                  }else{
                                      console.log("save Data");
                                      console.log(objWholeData);
                                      var myURL = 'app/hospital/purchase/storeToStore/save';
                                      $http({
                                          url : myURL,
                                          data : objWholeData,
                                          method : 'post',
                                          dataType : 'json',
                                          headers : {
                                              'Accept' : 'application/json',
                                              'Content-Type' : 'application/json'
                                          }
                                      }).success(function(data) {

                                          if (data.success == false) {
                                              logger.logError(" Error in Store To Store");
                                          } else {

                                              logger.logSuccess("Store To Store Added Successfully");
                                              $location.url('app.sea.store.list');
                                          }

                                      }).error(function(data) {

                                      });
                                  }
                              }else{
                                  logger.logError("Please Atleast One Row!");
                              }
                          }
                      }
                      
                  }
                  
              } else{
                  logger.logError("Please Add atleast one row item");
              }

            }
            else {
                toaster.pop('error', "Please fill the required fields",
                        logger.getErrorHtmlNew($scope.storeToStoreAddForm.$validationSummary), 555000, 'trustedHtml');
            }
        }
        
        $scope.update = function(storeToStoreAddForm,storeToStoreData) {
            
            var isQuantity = 0;
            var flag=true;
            
            var objheaderData = {
                'purchaseRequisitionId' : $scope.storeToStoreData.purchaseRequisitionId,
                'requisitionNumber' : $scope.storeToStoreData.requisitionNumber,
                'requisitionDate' : $scope.storeToStoreData.requisitionDate,
                'employeeId' : $scope.storeToStoreData.employeeId,
                'requisitionType' : $scope.storeToStoreData.requisitionType,
                'sourceLocation' : $scope.storeToStoreData.sourceLocation,
                'destinationLocation' : $scope.storeToStoreData.destinationLocation,
                'companyId' : $scope.storeToStoreData.companyId
            };

            var objWholeData = {
                'headerData' : objheaderData,
                'subData' : $scope.storeToStoreData.tables[0].storeTableRow
            };
                
            if (new validationService().checkFormValidity($scope.storeToStoreAddForm)) {
                
                if($scope.storeToStoreData.tables[0].storeTableRow.length==0){
                    flag=false;
                }
              
              if(flag==true){
                  angular.forEach($scope.storeToStoreData.tables[0].storeTableRow, function (value, key) {
                      if(value.quantity<=0){
                          isQuantity = 1;
                          value.quantity = '';
                      }
                  });
                 
                  if(isQuantity==1){
                      logger.logError("Quantity Must be Greater than Zero!");
                  }else{
                      if(new validationService().checkFormValidity($scope.storeToStoreAddForm)){
                          console.log($scope.storeToStoreData.tables[0].storeTableRow);
                          debugger
                          if($scope.storeToStoreData.tables[0].storeTableRow.length>0){
                              var isPhysicalQuantity = false;
                               
                              angular.forEach($scope.storeToStoreData.tables[0].storeTableRow,function(value,key){
                                    
                                  if(value.requestedQty==undefined ||  value.requestedQty==null || value.requestedQty==''){
                                        value.requestedQty=0;
                                    }  
                                    
                                    if(value.physicalQty >= 0){
                                        
                                        var oldtotalQty= Number(value.requestedQty)+Number(value.physicalQty);
                                    }else{
                                        
                                        var oldtotalQty= Number(value.requestedQty);
                                    }
                                    
                                     var currenttotalQty= Number(value.quantity);
                                    
                                     if(currenttotalQty > oldtotalQty){
                                          isPhysicalQuantity = true;
                                          logger.logError("Please Check the Quantity in  "+ value.itemName);
                                          
                                      }
                              });
                              
                              if(isPhysicalQuantity){
                              }else{
                                  $http.get('app/hospital/purchase/storeToStore/checkStockTransfer?purchaseRequisitionId=' + purchaseRequisitionId).success(function(datas) {
                                      if(datas!=0){
                                          logger.logError('Stock Transfer initiated already and hence editing not allowed!');
                                      }else{
                                          var myURL = 'app/hospital/purchase/storeToStore/update';
                                          $http({
                                              url : myURL,
                                              data : objWholeData,
                                              method : 'post',
                                              dataType : 'json',
                                              headers : {
                                                  'Accept' : 'application/json',
                                                  'Content-Type' : 'application/json'
                                              }
                                          }).success(function(data) {
                          
                                              if (data.success == false) {
                                                  logger.logError("Error in Store To Store");
                                              } else {
                                                  logger.logSuccess("Store To Store Updated Successfully");
                                                  $location.url('app.sea.store.list');
                                              }
                                          }).error(function(data) {
                                          });
                                      }
                                  }).error(function(datas) {
                                  });
                              }
                          }else{
                              logger.logError("Please Add Atleast One Row!");
                          }
                          
                      }
                  }
                  
              } else{
                  logger.logError("Please Add atleast one row item");
              }

            }
            else {
                toaster.pop('error', "Please fill the required fields",logger.getErrorHtmlNew($scope.storeToStoreAddForm.$validationSummary), 555000, 'trustedHtml');
            }
        }

        //Edit Functionality

        var rowCount = 0;
        var purchaseRequisitionId = $location.search().purchaseRequisitionId;
        
        if (purchaseRequisitionId == undefined || purchaseRequisitionId == null || purchaseRequisitionId == "") {
            $scope.isEdit = false;
            $scope.storeToStoreData.requisitionDate = $scope.date;
        } else {

            $scope.isEdit = true;
            $http.post('app/hospital/purchase/storeToStore/edit', purchaseRequisitionId).success(function(result) {
                console.log("Edit Data");
                console.log(result);
                $scope.storeToStoreData.purchaseRequisitionId = result.headerData.purchaseRequisitionId;
                $scope.storeToStoreData.requisitionNumber = result.headerData.requisitionNumber;
                $scope.storeToStoreData.requisitionDate = result.headerData.requisitionDate;
                $scope.storeToStoreData.employeeId = result.headerData.employeeId;
                $scope.storeToStoreData.designationName = result.headerData.designationName;
                $scope.storeToStoreData.requisitionType = result.headerData.requisitionType;
                $scope.storeToStoreData.sourceLocation = parseInt(result.headerData.sourceLocation);
                $scope.storeToStoreData.destinationLocation = parseInt(result.headerData.destinationLocation);
                $scope.storeToStoreData.companyId = result.headerData.companyId;
                $scope.storeToStoreData.tables[0].storeTableRow = result.subData;
                rowCount = $scope.storeToStoreData.tables[0].storeTableRow.length;
                
                var obj = $filter('filter')($scope.parentLocationList, {
                    id : result.headerData.sourceLocation
                });
            }).error(function(data) {

            });
        }

        $scope.reset = function(storeToStoreAddForm) {
            debugger
            if ($scope.isEdit == false) {
                
                $scope.storeToStoreData.sourceLocation='';
                $scope.storeToStoreData.destinationLocation='';
                $scope.storeToStoreData.purchaseRequisitionId = '';
                $scope.storeToStoreData.requisitionDate = $scope.date;
                $scope.storeToStoreData.purchaseRequisitionId = '';
                $scope.storeToStoreData.requisitionNumber = '';
                $scope.storeToStoreData.requisitionType = '';
                $scope.storeToStoreData.companyId = '';
               // $scope.storeToStoreData.tables[0].storeTableRow.eddDate = '';
                $scope.storeToStoreData.tables[0].storeTableRow.length = 1;
                angular.forEach($scope.storeToStoreData.tables[0].storeTableRow, function(value, key) {
                    value.quantity=0;
                    value.itemId='';
                    value.itemCategoryName='';
                    value.uomName='';
                    value.eddDate='';
                    value.physicalQty='';
                    
                });
                
                
            } else {
                $http.post('app/hospital/purchase/storeToStore/edit', purchaseRequisitionId).success(function(result) {
                    console.log("result");
                    console.log(result); 
                   
                    $scope.storeToStoreData.purchaseRequisitionId = result.headerData.purchaseRequisitionId;
                    $scope.storeToStoreData.requisitionNumber = result.headerData.requisitionNumber;
                    $scope.storeToStoreData.requisitionDate = result.headerData.requisitionDate;
                    $scope.storeToStoreData.employeeId = result.headerData.employeeId;
                    $scope.storeToStoreData.designationName = result.headerData.designationName;
                    $scope.storeToStoreData.requisitionType = result.headerData.requisitionType;
                    $scope.storeToStoreData.sourceLocation = parseInt(result.headerData.sourceLocation);
                    $scope.storeToStoreData.destinationLocation = parseInt(result.headerData.destinationLocation);
                    $scope.storeToStoreData.tables[0].storeTableRow = result.subData;
                    console.log("$scope.storeToStoreData");
                    console.log($scope.storeToStoreData); 
                    rowCount = $scope.storeToStoreData.tables[0].storeTableRow.length;
                  

                });
            }
        };

    });

    app.controller('parentCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {
        console.log("Inside Module Store To Store Controller");
        $scope.onChangeItemDuplicate=function(newValue,Index){

            $http.post("app/hospital/purchase/storeToStore/itemList", newValue).success(function(response) {
                console.log("response is");
                console.log(response);
                var data = response.itemData;
                if(data!=undefined){
                    $scope.storeToStoreData.tables[0].storeTableRow[Index].itemName = data.itemName;
                    $scope.storeToStoreData.tables[0].storeTableRow[Index].itemDesc = data.itemDesc;
                    $scope.storeToStoreData.tables[0].storeTableRow[Index].itemCategoryName = data.itemCategoryName;
                    $scope.storeToStoreData.tables[0].storeTableRow[Index].uomName = data.uomName;
                    $scope.storeToStoreData.tables[0].storeTableRow[Index].itemCategoryType = data.itemCategoryType;
                   // $scope.storeToStoreData.tables[0].storeTableRow[Index].physicalQty = data.physicalQty;
                }
    
            });
            
        }
        
        $scope.$watch('storeToStoreData.tables[0].storeTableRow[trIndex].itemId', function(newValue, oldValue) {
            debugger
            console.log("insideeeeeeeeeeeeeeeeeeee watch");
            if(newValue!=undefined && newValue!=null && newValue!=''){
                if(oldValue!=undefined && oldValue!=null && oldValue!=''){
                    if(newValue!=oldValue){
                        $scope.storeToStoreData.tables[0].storeTableRow[$scope.$index].quantity=0;
                        $scope.storeToStoreData.tables[0].storeTableRow[$scope.$index].requestedQty=0;
                    }
                }
                
                if($scope.storeToStoreData.sourceLocation!=undefined && $scope.storeToStoreData.sourceLocation!='' && $scope.storeToStoreData.sourceLocation!=null){
                    if(newValue!=undefined && newValue!='' && newValue!=null){
                        var length=  $scope.storeToStoreData.tables[0].storeTableRow.length;
                          for(var i=0;i<length;i++){
                              for(var j=0;j<length;j++){
                                  if(i!=j){
                                      if($scope.storeToStoreData.tables[0].storeTableRow[i].itemId !=undefined && $scope.storeToStoreData.tables[0].storeTableRow[i].itemId!=null && $scope.storeToStoreData.tables[0].storeTableRow[i].itemId!='' &&
                                          $scope.storeToStoreData.tables[0].storeTableRow[j].itemId!=undefined && $scope.storeToStoreData.tables[0].storeTableRow[j].itemId!=null && $scope.storeToStoreData.tables[0].storeTableRow[j].itemId!='')
                                          {
                                                    if($scope.storeToStoreData.tables[0].storeTableRow[i].itemId ==$scope.storeToStoreData.tables[0].storeTableRow[j].itemId){
                                                        logger.logError("Item Code-Item Name already added");
                                                        $scope.storeToStoreData.tables[0].storeTableRow[$scope.$index].itemId='';
                                                        return false;
                                                    }
                                          }    
                                     
                                  }
                              }
                          }
                         
                          
                          
                          $.ajax({
                              type: "GET",
                              url:  $stateParams.tenantid+'/app/commonUtility/getStockAvailablity?itemId='+newValue+"&locnId="+$scope.storeToStoreData.sourceLocation,
                              data: '',
                              async: false,
                              success: function(response) {
                                console.log("insideeeeeeeeeeeeeeeeeeee");
                                $scope.storeToStoreData.tables[0].storeTableRow[$scope.$index].physicalQty = response.commonUtilityBean[0].stockQty;
                                
                              }
                          });
                          
                          var resultbean={
                                  sourceLocationId:$scope.storeToStoreData.sourceLocation,
                                  itemId:newValue
                          }
                          console.log("result bean");
                          console.log(resultbean);
                          var qcQuantity=0;
                          $http.post("app/hospital/purchase/storeToStore/checkQcItem", resultbean).success(function(response) {
                               console.log("response is");
                              console.log(response.qcItemList);
                              if(response.qcItemList.length > 0){
                                  if(response.qcItemList[0].itemId==newValue){
                                      qcQuantity=response.qcItemList[0].qcQuantity;
                                      if($scope.storeToStoreData.tables[0].storeTableRow[$scope.$index].physicalQty > 0){
                                          console.log("Quantity"+$scope.storeToStoreData.tables[0].storeTableRow[$scope.$index].physicalQty);
                                          console.log("Qc Quantity"+qcQuantity);
                                          $scope.storeToStoreData.tables[0].storeTableRow[$scope.$index].physicalQty=$scope.storeToStoreData.tables[0].storeTableRow[$scope.$index].physicalQty-qcQuantity;
                                      }else{
                                          $scope.storeToStoreData.tables[0].storeTableRow[$scope.$index].physicalQty=$scope.storeToStoreData.tables[0].storeTableRow[$scope.$index].physicalQty;  
                                      }
                                    
                                  }
                              }
                        
                          });
                         
                          $scope.onChangeItemDuplicate(newValue,$scope.$index);

                      }else{
                          $scope.storeToStoreData.tables[0].storeTableRow[$scope.$index].itemName = '';
                          $scope.storeToStoreData.tables[0].storeTableRow[$scope.$index].itemDesc = '';
                          $scope.storeToStoreData.tables[0].storeTableRow[$scope.$index].itemCategoryName ='';
                          $scope.storeToStoreData.tables[0].storeTableRow[$scope.$index].uomName ='';
                          $scope.storeToStoreData.tables[0].storeTableRow[$scope.$index].physicalQty ='';
                          $scope.storeToStoreData.tables[0].storeTableRow[$scope.$index].quantity =0;
                          $scope.storeToStoreData.tables[0].storeTableRow[$scope.$index].requestedQty=0;
                      }
                } else{
                    logger.logError("Please Select Source Location");
                    $scope.storeToStoreData.tables[0].storeTableRow[$scope.$index].itemId = '';
                    $scope.storeToStoreData.tables[0].storeTableRow[$scope.$index].itemName = '';
                    $scope.storeToStoreData.tables[0].storeTableRow[$scope.$index].itemDesc = '';
                    $scope.storeToStoreData.tables[0].storeTableRow[$scope.$index].itemCategoryName ='';
                    $scope.storeToStoreData.tables[0].storeTableRow[$scope.$index].uomName ='';
                    $scope.storeToStoreData.tables[0].storeTableRow[$scope.$index].physicalQty ='';
                    $scope.storeToStoreData.tables[0].storeTableRow[$scope.$index].quantity =0;
                    $scope.storeToStoreData.tables[0].storeTableRow[$scope.$index].requestedQty=0;
                }
            }else{
                $scope.storeToStoreData.tables[0].storeTableRow[$scope.$index].itemName = '';
                $scope.storeToStoreData.tables[0].storeTableRow[$scope.$index].itemDesc = '';
                $scope.storeToStoreData.tables[0].storeTableRow[$scope.$index].itemCategoryName ='';
                $scope.storeToStoreData.tables[0].storeTableRow[$scope.$index].uomName ='';
                $scope.storeToStoreData.tables[0].storeTableRow[$scope.$index].physicalQty ='';
                $scope.storeToStoreData.tables[0].storeTableRow[$scope.$index].quantity =0;
                $scope.storeToStoreData.tables[0].storeTableRow[$scope.$index].eddDate = '';
                $scope.storeToStoreData.tables[0].storeTableRow[$scope.$index].requestedQty=0;
            }

        });
        
        $scope.validateQty=function(locnId,itemId,qty){
               var msg="",flag=true,availQty=0,location=0,item=0;
               if(!isNaN(parseInt(locnId)))
                   location = parseInt(locnId);
             if(!isNaN(parseInt(itemId)))
                   item = parseInt(itemId);
                $.ajax({
                   type: "POST",
                   url: $stateParams.tenantid+"/app/commonUtility/getStockAvailablity?itemId="+item+"&locnId="+location,
                   data: '',
                   async: false,
                   success: function(response) {
                       availQty = response.commonUtilityBean[0].stockQty;
                       console.log(parseInt(qty),parseInt(availQty));
                       if(parseInt(qty)>parseInt(availQty)){
                           if(!$scope.isEdit){
                               flag = false;
                               msg = "Physical Qty should not exceed Available Qty :: "+availQty;
                               $scope.storeToStoreData.tables[0].storeTableRow[$scope.$index].checkPhysicalQuantity = true;
                           }
                       }else{
                           $scope.storeToStoreData.tables[0].storeTableRow[$scope.$index].checkPhysicalQuantity = false;
                       }
                   }
               });

            if(!flag){
                logger.logError(msg);
            }
            return flag;
        }
        
        $scope.$watch('storeToStoreData.tables[0].storeTableRow[trIndex].eddDate',function(newValue,oldValue){
            if(newValue !== undefined && newValue !== ""){
                if(newValue!='' && $scope.storeToStoreData.requisitionDate != ''){
                    var todayDate = $scope.date;
                    var fromDate = $scope.storeToStoreData.requisitionDate;
                    var toDate = newValue;
                    fromDate = fromDate.split("/");
                    fromDate = new Date(fromDate[2], fromDate[1], fromDate[0]);
                    toDate = toDate.split("/");
                    toDate = new Date(toDate[2], toDate[1], toDate[0]);
                    todayDate = todayDate.split("/");
                    todayDate = new Date(todayDate[2], todayDate[1], todayDate[0]);
                    
                   // if($scope.storeToStoreData.tables[0].storeTableRow[$scope.$index].disableDate==false){
                        if(fromDate <= toDate && toDate >=todayDate){
                         }else{
                            logger.logError("EDD Date should be greater than or equal to requested date and today date!");
                            $scope.storeToStoreData.tables[0].storeTableRow[$scope.$index].eddDate =  $scope.date;
                        } 
                   // }
                }
            }
        });
        
        $scope.$watch('storeToStoreData.tables[0].storeTableRow[trIndex].physicalQty', function(newValue, oldValue) {
            
            $scope.validateQty($scope.storeToStoreData.sourceLocation,$scope.storeToStoreData.tables[0].storeTableRow[$scope.$index].itemId
                    ,$scope.storeToStoreData.tables[0].storeTableRow[$scope.$index].physicalQty);
        });
    
        
        $scope.$watch('storeToStoreData.tables[0].storeTableRow[trIndex].quantity', function(newValue, oldValue) {
                if(newValue!=undefined && newValue!=null && newValue!='' && $scope.isEdit==false){
                    if($scope.storeToStoreData.tables[0].storeTableRow[$scope.$index].physicalQty < newValue){
                        logger.logError("Available Quantity is "+$scope.storeToStoreData.tables[0].storeTableRow[$scope.$index].physicalQty);
                        $scope.storeToStoreData.tables[0].storeTableRow[$scope.$index].quantity=0; 
                    }
                }
           
        });

    });

//});
