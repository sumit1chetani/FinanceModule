define([ 'hospital/asset/asset' ], function(module) {

'use strict';

    module.registerController('assetmaintenanceContractApprovalCtrl', function($scope,$state,$http,$location,ngDialog,logger) {
    
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;

        $scope.numPages=0
        $scope.isUpload=true;
        $scope.isAdd=true
        $scope.isDelete=true

        $scope.add = function(){
            $state.go("app.hospital.asset.maintenancecontract.add");
        };
        
        
        $scope.getAsstMaintContract = function() {
            $http.get('hospital/asset/assetmaintenanceContract/list').success(function(data) {
                if (data.success) {
                    $scope.rowCollection = data.alAssetMaintenaceContractBeans;
               } else {
                    logger.logError("Error Please Try Again");
                }
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        };

       $scope.getAsstMaintContract();
        
      

       $scope.editRow = function(amcId) {
           $state.go('app.hospital.asset.amcapproval.confirm',({ amcNo: amcId,id:0}));
       }
       $scope.viewRow = function(amcId) {
           $state.go('app.hospital.asset.amcapproval.confirm',({ amcNo: amcId,id:1}));
       }
       
    });
    
    
    module.registerController('assetmaintenanceContractApprovalAddCtrl', function($scope,$filter,$timeout,$stateParams,$state,$http,$location,ngDialog,logger,assetDropDownlistService,validationService,toaster) {
        
      console.log($stateParams);
      var amcId=$stateParams.amcNo;
      var id=Number($stateParams.id);
      
      if(id === 1){
          $scope.isView=true;
      }else{
          $scope.isView=false;
      }
      var globalIndex=1;
      $scope.assetMaintenanceApprovalObj={
              assetApprovedBy:'',
              assetMaintenanceContractNo :'',
                  assetMaintenanceDate:'',
                  entityId:'',
                  vendorCity:'',
                  vendorAddres:'',
                  vendorZip:'',
                  vendorState:'',
                  vendorCountry:'',
                  verifyId:'',
                  jobTitle:'',
                  itemId:'',
                  itemCategoryId:'',
                  maintenanceId:'',
                  contactPerson :'',
                  contactNo:'',
                  startDate:'',
                  endDate:'',
                  quantity:'',
                  amount:'',
                  subAmount:'',
                  taxId:'',
                  taxAmount:'',
                  subtaxId:'',
                  subtax:'',
                  subtaxAmount:'',
                  totalAmount:'',
                  statusId:''
                  
          };
      
      $scope.CustomerList = [];
      assetDropDownlistService.vendorList().then(function(result){
          $scope.CustomerList =result.data.customerList;
      });
      
              
              $scope.getStatus = function() {
                  $http.get('hospital/asset/assetmaintenanceContract/statusList').success(function(data) {
                      if (data.success) {
                          $scope.StatusList =data.statusList;
                     } else {
                          logger.logError("Error Please Try Again");
                      }
                  }).error(function(data) {
                      logger.logError("Error Please Try Again");
                  });
              };

             
              
      assetDropDownlistService.dropDownList().then(function(response){
          if(response){
              $scope.ItemList=response.data.alItemList
              $scope.employeeList=response.data.alEmployeeList
              
              $scope.maintenanceList=response.data.alMaintenaceList
              $scope.taxList=response.data.alTaxList;
              $scope.subTaxList=response.data.subTaxList;
          }
          $scope.fetchEditDetails(amcId);
          $scope.getStatus();
      });
      $scope.subTax=true;
      $scope.fetchEditDetails = function(amcId) {
              var url = 'hospital/asset/assetmaintenanceContract/editDetails?amcontractId=' + amcId;
              $http.get(url).success(function(result) {
                  $scope.assetMaintenanceApprovalObj =    result.obContractBeans;
                  $scope.globalrowCollection=result.lAssetTrack;
                  if($scope.assetMaintenanceApprovalObj.url === null){
                     $scope.isUpload=true
                  }
                  var totalCheckedCount=result.lAssetTrack.length;
                  $scope.assetMaintenanceApprovalObj.quantity=result.lAssetTrack.length;
                  if(id === 0){
                      $scope.assetMaintenanceApprovalObj.statusId=169;
                      $scope.assetMaintenanceApprovalObj.assetApprovedBy="";
                  }
                  
                  $scope.calculateSubAmount($scope.assetMaintenanceApprovalObj.amount,$scope.assetMaintenanceApprovalObj.quantity)
              }).error(function(result) {
                  logger.logError("Error Please Try Again");
              });

          }
          
         
        
        $scope.$watch('assetMaintenanceApprovalObj.entityId', function(newValue, oldValue) {
            if(newValue != ""){
                $scope.loadvendorDetails() ;
              }else{
                
              }
        }); 
        
        $scope.$watch('assetMaintenanceApprovalObj.taxId', function(newValue, oldValue) {
            if(newValue != ""){
                $scope.taxAmount() ;
              }else{
                
              }
        }); 
        
        $scope.$watch('assetMaintenanceApprovalObj.verifyId', function(newValue, oldValue) {
            if(newValue != ""){
                $scope.jobTitle();
              }else{
               
              }
        }); 
        $scope.$watch('assetMaintenanceApprovalObj.itemId', function(newValue, oldValue) {
            if(newValue != ""){
                $scope.itemCategory();
              }
            }); 
        $scope.loadvendorDetails = function(){
            var customerId=$scope.assetMaintenanceApprovalObj.entityId
            if(customerId != ""){
                assetDropDownlistService.vendorDetails(customerId).then(function(result){
                    $scope.assetMaintenanceApprovalObj.vendorAddres = result.data.custAddressList.street;
                    $scope.assetMaintenanceApprovalObj.vendorCity = result.data.custAddressList.city;
                    $scope.assetMaintenanceApprovalObj.vendorZip = result.data.custAddressList.zipcode;
                    $scope.assetMaintenanceApprovalObj.vendorState = result.data.custAddressList.state;
                    $scope.assetMaintenanceApprovalObj.vendorCountry = result.data.custAddressList.country;
                });
            }
        }
        
            
            $scope.itemCategory=function(){
                if($scope.assetMaintenanceApprovalObj.itemId  != ""){
                    angular.forEach($scope.ItemList,function(value,key){
                        if($scope.assetMaintenanceApprovalObj.itemId === value.id){
                            $scope.assetMaintenanceApprovalObj.itemCategoryId=value.itemCategoryName;
                            $scope.getAssetTrackDetails($scope.assetMaintenanceApprovalObj.itemId);
                       } 
                    });    
                }else{
                    $scope.assetMaintenanceApprovalObj.itemId ="";   
                    $('#AssetTrackDetails').hide();
                    $scope.rowCollection=[];
                }
            };
            
            $scope.jobTitle=function(){
                if($scope.assetMaintenanceApprovalObj.verifyId != ""){
                    angular.forEach($scope.employeeList,function(value,key){
                        if($scope.assetMaintenanceApprovalObj.verifyId === value.id){
                            $scope.assetMaintenanceApprovalObj.jobTitle=value.designationName;
                       } 
                    });    
                }
             };
            $('#AssetTrackDetails').show();
            $scope.getAssetTrackDetails=function(itemId){
                if(globalIndex > 1){
                    
                
                var url = 'hospital/asset/assetmaintenanceContract/assetTrackDetails?itemId=' +itemId;
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
                }else if(globalIndex === 1){
                    $scope.rowCollection=$scope.globalrowCollection;
                }
                globalIndex =globalIndex + 1;
            };
            
        
        
        $scope.submit = function(assetMaintenanceApprovalObj) {
            if (new validationService().checkFormValidity($scope.assetmaintenaceContractApprovalForm)) {
                    $scope.update(assetMaintenanceApprovalObj);
            } else {
                toaster.pop('error', "Please fill the required fields", 
                        logger.getErrorHtmlNew($scope.assetmaintenaceContractApprovalForm.$validationSummary), 555000, 'trustedHtml');
            }
        };
        
        
        $scope.update=function(assetMaintenanceApprovalObj){
            var url="hospital/asset/assetmaintenanceContract/updateApproval?amcId="+amcId +"&approvedBy="+assetMaintenanceApprovalObj.assetApprovedBy +"&statusId=" +assetMaintenanceApprovalObj.statusId
            $http.get(url).success(function(data){
            if (data) {
                    logger.logSuccess("Updated!");
                    $state.go('app.hospital.asset.amcapproval.list');
                    } else {
                        logger.logError("Error Not Updated!");
                }
            }).error(function(data) {
                logger.logError("Error!");
            });
            
        
        }
        
        
        
        $scope.cancel = function(){
            $state.go("app.hospital.asset.amcapproval.list");
        };
        
        
        $scope.calculateSubAmount=function(amount,qty){
            
            if(amount !== "" && parseInt(qty) > 0){
            var amountCalculation=parseFloat(amount) * parseInt(qty);
            $scope.assetMaintenanceApprovalObj.subAmount=amountCalculation.toFixed(2);
                if($scope.assetMaintenanceApprovalObj.taxId !== ""){
                    $scope.taxAmount();
                }
            }
        }
        
        $scope.taxAmount=function(){
            var taxAmount,taxPercentage;
            var subTaxId,subtaxAmount,subtaxPercentage;
            if($scope.assetMaintenanceApprovalObj.taxId !== "" ){
            var obj = $filter('filter')($scope.taxList, {
                id : $scope.assetMaintenanceApprovalObj.taxId
            },true)[0];
            taxAmount=parseFloat(obj.taxFixedAmount);
            taxPercentage= parseFloat(obj.taxPercentage);
            
            
            if(taxAmount !== 0 &&  taxPercentage === 0){
                $scope.assetMaintenanceApprovalObj.taxAmount=parseFloat(taxAmount).toFixed(2);
            }else {
                var calculat= taxPercentage * (parseFloat($scope.assetMaintenanceApprovalObj.subAmount) / 100);
                $scope.assetMaintenanceApprovalObj.taxAmount=parseFloat(calculat).toFixed(2);
            }
        
            var subTaxobj = $filter('filter')($scope.subTaxList, {
                taxId : $scope.assetMaintenanceApprovalObj.taxId
            },true)[0];
        
            $scope.assetMaintenanceApprovalObj.totalAmount= (parseFloat($scope.assetMaintenanceApprovalObj.subAmount) + parseFloat($scope.assetMaintenanceApprovalObj.taxAmount)).toFixed(2);
            if(subTaxobj != undefined){
                
            subtaxAmount=parseFloat(subTaxobj.subTaxFixedAmount);
            subtaxPercentage=parseFloat(subTaxobj.subTaxPercentage);
            $scope.assetMaintenanceApprovalObj.subtaxId=subTaxobj.subTaxId;         
            $scope.assetMaintenanceApprovalObj.subtax=subTaxobj.subTaxName;
            $scope.subTax=false;
            if(subtaxAmount !== 0 &&  subtaxPercentage === 0){
                $scope.assetMaintenanceApprovalObj.subtaxAmount=parseFloat(subtaxAmount).toFixed(2);
            }else {
                var calculat= subtaxPercentage * ($scope.assetMaintenanceApprovalObj.taxAmount / 100);
                $scope.assetMaintenanceApprovalObj.subtaxAmount=parseFloat(calculat).toFixed(2);
            }
            $scope.assetMaintenanceApprovalObj.totalAmount= (parseFloat($scope.assetMaintenanceApprovalObj.totalAmount)  + parseFloat($scope.assetMaintenanceApprovalObj.subtaxAmount)).toFixed(2);
            }
            }
        
        }
        
        
      });
    module.registerController('assetmaintenanceContractApprovalViewCtrl', function($scope,$filter,$timeout,$stateParams,$state,$http,$location,ngDialog,logger,assetDropDownlistService,validationService,toaster) {
        
        console.log($stateParams);
        var amcId=$stateParams.amcNo;
        var id=Number($stateParams.id);
        
        if(id === 1){
            $scope.isView=true;
        }else{
            $scope.isView=false;
        }
        var globalIndex=1;
        $scope.assetMaintenanceApprovalObj={
                assetApprovedBy:'',
                assetMaintenanceContractNo :'',
                    assetMaintenanceDate:'',
                    entityId:'',
                    vendorCity:'',
                    vendorAddres:'',
                    vendorZip:'',
                    vendorState:'',
                    vendorCountry:'',
                    verifyId:'',
                    jobTitle:'',
                    itemId:'',
                    itemCategoryId:'',
                    maintenanceId:'',
                    contactPerson :'',
                    contactNo:'',
                    startDate:'',
                    endDate:'',
                    quantity:'',
                    amount:'',
                    subAmount:'',
                    taxId:'',
                    taxAmount:'',
                    subtaxId:'',
                    subtax:'',
                    subtaxAmount:'',
                    totalAmount:'',
                    statusId:''
                    
            };
        
        $scope.CustomerList = [];
        assetDropDownlistService.vendorList().then(function(result){
            $scope.CustomerList =result.data.customerList;
        });
        
                
                $scope.getStatus = function() {
                    $http.get('hospital/asset/assetmaintenanceContract/statusList').success(function(data) {
                        if (data.success) {
                            $scope.StatusList =data.statusList;
                       } else {
                            logger.logError("Error Please Try Again");
                        }
                    }).error(function(data) {
                        logger.logError("Error Please Try Again");
                    });
                };

               
                
        assetDropDownlistService.dropDownList().then(function(response){
            if(response){
                $scope.ItemList=response.data.alItemList
                $scope.employeeList=response.data.alEmployeeList
                
                $scope.maintenanceList=response.data.alMaintenaceList
                $scope.taxList=response.data.alTaxList;
                $scope.subTaxList=response.data.subTaxList;
            }
            $scope.fetchEditDetails(amcId);
            $scope.getStatus();
        });
        $scope.subTax=true;
        $scope.fetchEditDetails = function(amcId) {
                var url = 'hospital/asset/assetmaintenanceContract/editDetails?amcontractId=' + amcId;
                $http.get(url).success(function(result) {
                    $scope.assetMaintenanceApprovalObj =    result.obContractBeans;
                    $scope.globalrowCollection=result.lAssetTrack;
                    if($scope.assetMaintenanceApprovalObj.url === null){
                       $scope.isUpload=true
                    }
                    var totalCheckedCount=result.lAssetTrack.length;
                    $scope.assetMaintenanceApprovalObj.quantity=result.lAssetTrack.length;
                    if(id === 0){
                        $scope.assetMaintenanceApprovalObj.statusId=169;
                        $scope.assetMaintenanceApprovalObj.assetApprovedBy="";
                    }
                    
                    $scope.calculateSubAmount($scope.assetMaintenanceApprovalObj.amount,$scope.assetMaintenanceApprovalObj.quantity)
                }).error(function(result) {
                    logger.logError("Error Please Try Again");
                });

            }
            
           
          
          $scope.$watch('assetMaintenanceApprovalObj.entityId', function(newValue, oldValue) {
              if(newValue != ""){
                  $scope.loadvendorDetails() ;
                }else{
                  
                }
          }); 
          
          $scope.$watch('assetMaintenanceApprovalObj.taxId', function(newValue, oldValue) {
              if(newValue != ""){
                  $scope.taxAmount() ;
                }else{
                  
                }
          }); 
          
          $scope.$watch('assetMaintenanceApprovalObj.verifyId', function(newValue, oldValue) {
              if(newValue != ""){
                  $scope.jobTitle();
                }else{
                 
                }
          }); 
          $scope.$watch('assetMaintenanceApprovalObj.itemId', function(newValue, oldValue) {
              if(newValue != ""){
                  $scope.itemCategory();
                }
              }); 
          $scope.loadvendorDetails = function(){
              var customerId=$scope.assetMaintenanceApprovalObj.entityId
              if(customerId != ""){
                  assetDropDownlistService.vendorDetails(customerId).then(function(result){
                      $scope.assetMaintenanceApprovalObj.vendorAddres = result.data.custAddressList.street;
                      $scope.assetMaintenanceApprovalObj.vendorCity = result.data.custAddressList.city;
                      $scope.assetMaintenanceApprovalObj.vendorZip = result.data.custAddressList.zipcode;
                      $scope.assetMaintenanceApprovalObj.vendorState = result.data.custAddressList.state;
                      $scope.assetMaintenanceApprovalObj.vendorCountry = result.data.custAddressList.country;
                  });
              }
          }
          
              
              $scope.itemCategory=function(){
                  if($scope.assetMaintenanceApprovalObj.itemId  != ""){
                      angular.forEach($scope.ItemList,function(value,key){
                          if($scope.assetMaintenanceApprovalObj.itemId === value.id){
                              $scope.assetMaintenanceApprovalObj.itemCategoryId=value.itemCategoryName;
                              $scope.getAssetTrackDetails($scope.assetMaintenanceApprovalObj.itemId);
                         } 
                      });    
                  }else{
                      $scope.assetMaintenanceApprovalObj.itemId ="";   
                      $('#AssetTrackDetails').hide();
                      $scope.rowCollection=[];
                  }
              };
              
              $scope.jobTitle=function(){
                  if($scope.assetMaintenanceApprovalObj.verifyId != ""){
                      angular.forEach($scope.employeeList,function(value,key){
                          if($scope.assetMaintenanceApprovalObj.verifyId === value.id){
                              $scope.assetMaintenanceApprovalObj.jobTitle=value.designationName;
                         } 
                      });    
                  }
               };
              $('#AssetTrackDetails').show();
              $scope.getAssetTrackDetails=function(itemId){
                  if(globalIndex > 1){
                      
                  
                  var url = 'hospital/asset/assetmaintenanceContract/assetTrackDetails?itemId=' +itemId;
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
                  }else if(globalIndex === 1){
                      $scope.rowCollection=$scope.globalrowCollection;
                  }
                  globalIndex =globalIndex + 1;
              };
              
          
          
          $scope.submit = function(assetMaintenanceApprovalObj) {
              if (new validationService().checkFormValidity($scope.assetmaintenaceContractApprovalForm)) {
                      $scope.update(assetMaintenanceApprovalObj);
              } else {
                  toaster.pop('error', "Please fill the required fields", 
                          logger.getErrorHtmlNew($scope.assetmaintenaceContractApprovalForm.$validationSummary), 555000, 'trustedHtml');
              }
          };
          
          
          $scope.update=function(assetMaintenanceApprovalObj){
              var url="hospital/asset/assetmaintenanceContract/updateApproval?amcId="+amcId +"&approvedBy="+assetMaintenanceApprovalObj.assetApprovedBy +"&statusId=" +assetMaintenanceApprovalObj.statusId
              $http.get(url).success(function(data){
              if (data) {
                      logger.logSuccess("Updated!");
                      $state.go('app.hospital.asset.amcapproval.list');
                      } else {
                          logger.logError("Error Not Updated!");
                  }
              }).error(function(data) {
                  logger.logError("Error!");
              });
              
          
          }
          
          
          
          $scope.cancel = function(){
              $state.go("app.hospital.asset.maintenancecontract.list");
          };
          
          
          $scope.calculateSubAmount=function(amount,qty){
              
              if(amount !== "" && parseInt(qty) > 0){
              var amountCalculation=parseFloat(amount) * parseInt(qty);
              $scope.assetMaintenanceApprovalObj.subAmount=amountCalculation.toFixed(2);
                  if($scope.assetMaintenanceApprovalObj.taxId !== ""){
                      $scope.taxAmount();
                  }
              }
          }
          
          $scope.taxAmount=function(){
              var taxAmount,taxPercentage;
              var subTaxId,subtaxAmount,subtaxPercentage;
              if($scope.assetMaintenanceApprovalObj.taxId !== "" ){
              var obj = $filter('filter')($scope.taxList, {
                  id : $scope.assetMaintenanceApprovalObj.taxId
              },true)[0];
              taxAmount=parseFloat(obj.taxFixedAmount);
              taxPercentage= parseFloat(obj.taxPercentage);
              
              
              if(taxAmount !== 0 &&  taxPercentage === 0){
                  $scope.assetMaintenanceApprovalObj.taxAmount=parseFloat(taxAmount).toFixed(2);
              }else {
                  var calculat= taxPercentage * (parseFloat($scope.assetMaintenanceApprovalObj.subAmount) / 100);
                  $scope.assetMaintenanceApprovalObj.taxAmount=parseFloat(calculat).toFixed(2);
              }
          
              var subTaxobj = $filter('filter')($scope.subTaxList, {
                  taxId : $scope.assetMaintenanceApprovalObj.taxId
              },true)[0];
          
              $scope.assetMaintenanceApprovalObj.totalAmount= (parseFloat($scope.assetMaintenanceApprovalObj.subAmount) + parseFloat($scope.assetMaintenanceApprovalObj.taxAmount)).toFixed(2);
              if(subTaxobj != undefined){
                  
              subtaxAmount=parseFloat(subTaxobj.subTaxFixedAmount);
              subtaxPercentage=parseFloat(subTaxobj.subTaxPercentage);
              $scope.assetMaintenanceApprovalObj.subtaxId=subTaxobj.subTaxId;         
              $scope.assetMaintenanceApprovalObj.subtax=subTaxobj.subTaxName;
              $scope.subTax=false;
              if(subtaxAmount !== 0 &&  subtaxPercentage === 0){
                  $scope.assetMaintenanceApprovalObj.subtaxAmount=parseFloat(subtaxAmount).toFixed(2);
              }else {
                  var calculat= subtaxPercentage * ($scope.assetMaintenanceApprovalObj.taxAmount / 100);
                  $scope.assetMaintenanceApprovalObj.subtaxAmount=parseFloat(calculat).toFixed(2);
              }
              $scope.assetMaintenanceApprovalObj.totalAmount= (parseFloat($scope.assetMaintenanceApprovalObj.totalAmount)  + parseFloat($scope.assetMaintenanceApprovalObj.subtaxAmount)).toFixed(2);
              }
              }
          
          }
          
          
        });
      
      module.registerFactory('assetDropDownlistService', function($http) {

          return {
              vendorList : function() {
                  return $http.get('his/inventory/deliveryOrder/getCustomerList').then(function(result) {
                      return result;
                  });
              },
              vendorDetails : function(customerId) {
                  return $http.post("his/inventory/deliveryOrder/getCustomerAddress", customerId).then(function(result) {
                      return result;
                  });
              },
              dropDownList : function(){
                  return $http.get("hospital/asset/assetmaintenanceContract/getDropDownList").then(function(result) {
                      return result;
                  });
              }
              
          }

      });
});