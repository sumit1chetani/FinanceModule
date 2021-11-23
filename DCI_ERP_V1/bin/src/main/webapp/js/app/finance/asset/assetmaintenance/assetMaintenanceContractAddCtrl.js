define([ 'hospital/asset/asset' ], function(module) {

'use strict';

    module.registerController('assetmaintenanceContractAddCtrl', function($scope,$state,$http,$location,ngDialog,logger,assetDropDownlistService,validationService,toaster,$filter) {
        
        $scope.isEdit=false;
        $scope.assetMaintenanceObj={
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
                quantity:0,
                amount:'',
                subAmount:'',
                taxId:'',
                taxAmount:'',
                subtaxId:'',
                subtax:'',
                subtaxAmount:'',
                totalAmount:'',
                url:''
                    
        };
        $scope.isUpload=true;
        $scope.subTax=true;
        $scope.CustomerList = [];
        assetDropDownlistService.vendorList().then(function(result){
            $scope.CustomerList =result.data.customerList;
        });
     
        
        var currentDate = new Date();
        currentDate = ('0' + currentDate.getDate()).slice(-2)+"/"+('0' + currentDate.getMonth()).slice(-2)+"/"+currentDate.getFullYear();
        $scope.assetMaintenanceObj.assetMaintenanceDate = currentDate;
       
        assetDropDownlistService.dropDownList().then(function(response){
            if(response){
                $scope.ItemList=response.data.alItemList
                $scope.employeeList=response.data.alEmployeeList
                $scope.maintenanceList=response.data.alMaintenaceList
                $scope.taxList=response.data.alTaxList;
                $scope.subTaxList=response.data.subTaxList;
            }
        });
       
        //Top find which object Property is Updated  
        var purchaseObj = angular.copy($scope.assetMaintenanceObj,purchaseObj);
        var arrayOfValues = Object.keys(purchaseObj);
        $scope.checkWhichVariableHasUpdated = function(watchGroupList, newValuesObj, oldValuesObj) {
          var _lastUpdatedValue = null;
          angular.forEach(watchGroupList, function(value) {
              if (newValuesObj[value] != oldValuesObj[value])
                  _lastUpdatedValue = value;
          });
          $scope.selectedObj = newValuesObj;
          return _lastUpdatedValue;
      };

      //To load Dependent DropDown 
      $scope.loadDropDown = function(changedVariable) {
          switch (changedVariable) {
              case "entityId":
                  $scope.loadvendorDetails() ;
                  break;
              case "itemId":
                  $scope.itemCategory();
                  break;
              case "verifyId":
                  $scope.jobTitle();
                  break;
              case "taxId"  :
                  $scope.subTax=true;
                  $scope.assetMaintenanceObj.taxAmount="";
                  $scope.assetMaintenanceObj.subtaxAmount="";
                  $scope.assetMaintenanceObj.subtax="";
                  $scope.assetMaintenanceObj.totalAmount="";
                  $scope.taxAmount();
                  break;
               }
      };

      //To watch a Object Collection
      $scope.$watchCollection('assetMaintenanceObj', function(newVal, oldVal) {
          if(newVal !=undefined){
          var last_changed = $scope.checkWhichVariableHasUpdated(arrayOfValues, newVal, oldVal);
          if (angular.isDefined(last_changed) && last_changed != null) {
              $scope.loadDropDown(last_changed);
          }
          }
      },true);
      
      
      $scope.loadvendorDetails = function(){
          var customerId=$scope.assetMaintenanceObj.entityId
          if(customerId != ""){
              assetDropDownlistService.vendorDetails(customerId).then(function(result){
                  
                  $scope.assetMaintenanceObj.vendorAddres = result.data.custAddressList.street;
                  $scope.assetMaintenanceObj.vendorCity = result.data.custAddressList.city;
                  $scope.assetMaintenanceObj.vendorZip = result.data.custAddressList.zipcode;
                  $scope.assetMaintenanceObj.vendorState = result.data.custAddressList.state;
                  $scope.assetMaintenanceObj.vendorCountry = result.data.custAddressList.country;
              });
              
                
          } else{
              $scope.assetMaintenanceObj.vendorAddres ='';
              $scope.assetMaintenanceObj.vendorCity = '';
              $scope.assetMaintenanceObj.vendorZip = '';
              $scope.assetMaintenanceObj.vendorState = '';
              $scope.assetMaintenanceObj.vendorCountry = '';
          }   
          
           
      }
      
      $scope.itemCategory=function(){
          if($scope.assetMaintenanceObj.itemId  != ""){
              angular.forEach($scope.ItemList,function(value,key){
                  if($scope.assetMaintenanceObj.itemId === value.id){
                      $scope.assetMaintenanceObj.itemCategoryId=value.itemCategoryName;
                      $scope.getAssetTrackDetails($scope.assetMaintenanceObj.itemId);
                     
                 } 
              });    
          }else{
              $scope.assetMaintenanceObj.itemId ="";   
              $('#AssetTrackDetails').hide();
              $scope.rowCollection=[];
          }
      };
      
      $scope.jobTitle=function(){
          if($scope.assetMaintenanceObj.verifyId != ""){
              angular.forEach($scope.employeeList,function(value,key){
                  if($scope.assetMaintenanceObj.verifyId === value.id){
                      $scope.assetMaintenanceObj.jobTitle=value.designationName;
                 } 
              });    
          }else{
              $scope.assetMaintenanceObj.jobTitle ="";
          }
          
      };
      $('#AssetTrackDetails').hide();
      $scope.getAssetTrackDetails=function(itemId){
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
      };
      $scope.onChangeNumber =function(num){
          num = num.replace(/[^0-9 .]/g, '');
              $('#amount').val(num);  
          return num;
      }
      
      $scope.submit = function(assetmaintenaceContractForm,assetMaintenanceObj,rowCollection) {
          if (new validationService().checkFormValidity($scope.assetmaintenaceContractForm)) {
                  $scope.save(assetMaintenanceObj,rowCollection);
          } else {
              toaster.pop('error', "Please fill the required fields", 
                      logger.getErrorHtmlNew($scope.assetmaintenaceContractForm.$validationSummary), 555000, 'trustedHtml');
          }
      };
      
      
      $scope.save=function(assetMaintenanceObj,assetTrackDetails){
         if(assetTrackDetails.length > 0){
          var jsonData={
                  'assetMaintenanceDate' :assetMaintenanceObj.assetMaintenanceDate,
                  'entityId' :assetMaintenanceObj.entityId,
                  'itemId' :assetMaintenanceObj.itemId,
                  'maintenanceId' :assetMaintenanceObj.maintenanceId,
                  'contactPerson' :assetMaintenanceObj.contactPerson,
                  'verifyId':assetMaintenanceObj.verifyId,
                  'contactNo' :assetMaintenanceObj.contactNo,
                  'startDate' :assetMaintenanceObj.startDate,
                  'endDate' :assetMaintenanceObj.endDate,
                  'quantity':assetMaintenanceObj.quantity,
                  'amount':assetMaintenanceObj.amount,
                   'taxId':assetMaintenanceObj.taxId,
                  'subtaxId':assetMaintenanceObj.subtaxId,
                  'totalAmount':assetMaintenanceObj.totalAmount,
                  'listAssetTrackDetails' : assetTrackDetails,
                  'url':$scope.assetMaintenanceObj.url,
                  'docName':$scope.assetMaintenanceObj.docName,
                  
          }
      $http.post('hospital/asset/assetmaintenanceContract/save',jsonData).success(function(data){
              if (data) {
                  logger.logSuccess("Saved!");
                  $state.go('app.hospital.asset.maintenancecontract.list');
                  } else {
                      logger.logError("Error Not Saved!");
              }
          }).error(function(data) {
              logger.logSuccess("Error Not Saved!");
          });
          console.log(jsonData);
         }else{
             logger.logError("Asset Track Details Must");
         }
      }
      
      $scope.cancel = function(){
          $state.go("app.hospital.asset.maintenancecontract.list");
      };
      
      
      $scope.choosefile=function(element){
          if(element.files.length > 0){
          var excelfile=element.files[0];
          var file=new FormData();
          file.append("file",excelfile);
          $.ajax({
              type : "POST",
              url : "hospital/asset/assetmaintenanceContract/fileUpload?file="+file +"&docName="+$scope.assetMaintenanceObj.docName,
              data : file,
              contentType: false,
              processData: false,
              success : function(result) {
                  if(result != undefined){
                      logger.logSuccess("File Uploaded Successfully");
                      $scope.assetMaintenanceObj.url=result;
                      $scope.isUpload=false;
                      
                  }else{
                      logger.logError("Fail to Upload");    
                  }
                  }
             
          });
      }
      }
      
      
      var totalCheckedCount=0;
      $scope.onCount=function(assetTrackConfirm){
          if(assetTrackConfirm){
              totalCheckedCount++;
              $scope.assetMaintenanceObj.quantity=totalCheckedCount;
              if($scope.assetMaintenanceObj.amount !== ""){
                  $scope.calculateSubAmount($scope.assetMaintenanceObj.amount,$scope.assetMaintenanceObj.quantity);    
              }
              
              
          }else if(!assetTrackConfirm){
              totalCheckedCount--;
              $scope.assetMaintenanceObj.quantity=totalCheckedCount;
              if($scope.assetMaintenanceObj.amount !== ""){
                  $scope.calculateSubAmount($scope.assetMaintenanceObj.amount,$scope.assetMaintenanceObj.quantity);    
              }
              
          }
      }
      
      $scope.calculateSubAmount=function(amount,qty){
          
          if(amount !== "" && parseInt(qty) > 0){
          var amountCalculation=parseFloat(amount) * parseInt(qty);
          $scope.assetMaintenanceObj.subAmount=amountCalculation.toFixed(2);
              if($scope.assetMaintenanceObj.taxId !== ""){
                  $scope.taxAmount();
              }
          }else{
              $scope.subTax=true;
              $scope.assetMaintenanceObj.subAmount="";
              $scope.assetMaintenanceObj.taxId="";
              $scope.assetMaintenanceObj.taxAmount=0.00;
              $scope.assetMaintenanceObj.subtaxAmount=0.00;
              $scope.assetMaintenanceObj.subtax="";
              $scope.assetMaintenanceObj.totalAmount=0.00;
          }
      }
      
      $scope.taxAmount=function(){
          var taxAmount,taxPercentage;
          var subTaxId,subtaxAmount,subtaxPercentage;
          if($scope.assetMaintenanceObj.taxId !== "" || $scope.assetMaintenanceObj.subAmount > 0 ){
          var obj = $filter('filter')($scope.taxList, {
              id : $scope.assetMaintenanceObj.taxId
          },true)[0];
          taxAmount=parseFloat(obj.taxFixedAmount);
          taxPercentage= parseFloat(obj.taxPercentage);
          
          
          if(taxAmount !== 0 &&  taxPercentage === 0){
              $scope.assetMaintenanceObj.taxAmount=parseFloat(taxAmount).toFixed(2);
          }else {
              var calculat= taxPercentage * (parseFloat($scope.assetMaintenanceObj.subAmount) / 100);
              $scope.assetMaintenanceObj.taxAmount=parseFloat(calculat).toFixed(2);
          }
      
          var subTaxobj = $filter('filter')($scope.subTaxList, {
              taxId : $scope.assetMaintenanceObj.taxId
          },true)[0];
      
          $scope.assetMaintenanceObj.totalAmount= (parseFloat($scope.assetMaintenanceObj.subAmount) + parseFloat($scope.assetMaintenanceObj.taxAmount)).toFixed(2);
          if(subTaxobj != undefined){
              
          subtaxAmount=parseFloat(subTaxobj.subTaxFixedAmount);
          subtaxPercentage=parseFloat(subTaxobj.subTaxPercentage);
          $scope.assetMaintenanceObj.subtaxId=subTaxobj.subTaxId;         
          $scope.assetMaintenanceObj.subtax=subTaxobj.subTaxName;
          $scope.subTax=false;
          if(subtaxAmount !== 0 &&  subtaxPercentage === 0){
              $scope.assetMaintenanceObj.subtaxAmount=parseFloat(subtaxAmount).toFixed(2);
          }else {
              var calculat= subtaxPercentage * ($scope.assetMaintenanceObj.taxAmount / 100);
              $scope.assetMaintenanceObj.subtaxAmount=parseFloat(calculat).toFixed(2);
          }
          $scope.assetMaintenanceObj.totalAmount= (parseFloat($scope.assetMaintenanceObj.totalAmount)  + parseFloat($scope.assetMaintenanceObj.subtaxAmount)).toFixed(2);
          }
          
       
          
          }else{
              $scope.subTax=true;
              $scope.assetMaintenanceObj.taxAmount=0.00;
              $scope.assetMaintenanceObj.subtaxAmount=0.00;
              $scope.assetMaintenanceObj.subtax="";
              $scope.assetMaintenanceObj.totalAmount=0.00;
          }
      
      }
      $scope.cancelUpload=function(){
          var url=   "hospital/asset/assetmaintenanceContract/filedelete?filePath="+$scope.assetMaintenanceObj.url
          $http.get(url).success(function(data){
              if (data) {
                      logger.logSuccess("File Successfully Removed!");
                      $scope.assetMaintenanceObj.url="";
                      $scope.isUpload=true;
                      } else {
                          logger.logError("File Not Successfully Removed!!");
                  }
              }).error(function(data) {
                  logger.logError("Error!");
              });
      };
     
      
    });
    
module.registerController('assetmaintenanceContractEditCtrl', function($scope,$filter,$timeout,$stateParams,$state,$http,$location,ngDialog,logger,assetDropDownlistService,validationService,toaster) {
        
      $scope.isEdit=true; 
    console.log($stateParams);
    var amcId=$stateParams.amcNo;
    var globalIndex=1;
    $scope.assetMaintenanceObj={
                amcId:'',
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
                totalAmount:''
        };
    
    $scope.CustomerList = [];
    assetDropDownlistService.vendorList().then(function(result){
        $scope.CustomerList =result.data.customerList;
    });
    $scope.subTax=true;
    $scope.isUpload=false;
    
    $scope.onChangeNumber =function(num){
        num = num.replace(/[^0-9 .]/g, '');
            $('#amount').val(num);  
        return num;
    }
    
    assetDropDownlistService.dropDownList().then(function(response){
        if(response){
            $scope.ItemList=response.data.alItemList
            $scope.employeeList=response.data.alEmployeeList
            $scope.maintenanceList=response.data.alMaintenaceList
            $scope.taxList=response.data.alTaxList;
            $scope.subTaxList=response.data.subTaxList;
        }
        $scope.fetchEditDetails(amcId);
    });
    
    $scope.fetchEditDetails = function(amcId) {
            var url = 'hospital/asset/assetmaintenanceContract/editDetails?amcontractId=' + amcId;
            $http.get(url).success(function(result) {
                $scope.assetMaintenanceObj =    result.obContractBeans;
               
                $scope.globalrowCollection=result.lAssetTrack;
                debugger;
                if($scope.assetMaintenanceObj.url === null){
                    $scope.isUpload=true
                }
                var totalCheckedCount=result.lAssetTrack.length;
                $scope.assetMaintenanceObj.quantity=result.lAssetTrack.length;
                $scope.calculateSubAmount($scope.assetMaintenanceObj.amount,$scope.assetMaintenanceObj.quantity)
            }).error(function(result) {
                logger.logError("Error Please Try Again");
            });

        }
        
       
      
      $scope.$watch('assetMaintenanceObj.entityId', function(newValue, oldValue) {
          if(newValue != ""){
              $scope.loadvendorDetails() ;
            }else{
              
            }
      }); 
      
      $scope.$watch('assetMaintenanceObj.taxId', function(newValue, oldValue) {
          if(newValue != ""){
              $scope.taxAmount() ;
            }else{
              
            }
      }); 
      
      $scope.$watch('assetMaintenanceObj.verifyId', function(newValue, oldValue) {
          if(newValue != ""){
              $scope.jobTitle();
            }else{
             
            }
      }); 
      $scope.$watch('assetMaintenanceObj.itemId', function(newValue, oldValue) {
          if(newValue != ""){
              $scope.itemCategory();
            }else{
                
            }
      }); 
      $scope.loadvendorDetails = function(){
          var customerId=$scope.assetMaintenanceObj.entityId
          if(customerId != ""){
              assetDropDownlistService.vendorDetails(customerId).then(function(result){
                  
                  $scope.assetMaintenanceObj.vendorAddres = result.data.custAddressList.street;
                  $scope.assetMaintenanceObj.vendorCity = result.data.custAddressList.city;
                  $scope.assetMaintenanceObj.vendorZip = result.data.custAddressList.zipcode;
                  $scope.assetMaintenanceObj.vendorState = result.data.custAddressList.state;
                  $scope.assetMaintenanceObj.vendorCountry = result.data.custAddressList.country;
              });
              
                
          } else{
              $scope.assetMaintenanceObj.vendorAddres ='';
              $scope.assetMaintenanceObj.vendorCity = '';
              $scope.assetMaintenanceObj.vendorZip = '';
              $scope.assetMaintenanceObj.vendorState = '';
              $scope.assetMaintenanceObj.vendorCountry = '';
          }   
          
           
      }
      
          
          $scope.itemCategory=function(){
              if($scope.assetMaintenanceObj.itemId  != ""){
                  angular.forEach($scope.ItemList,function(value,key){
                      if($scope.assetMaintenanceObj.itemId === value.id){
                          $scope.assetMaintenanceObj.itemCategoryId=value.itemCategoryName;
                          $scope.getAssetTrackDetails($scope.assetMaintenanceObj.itemId);
                     } 
                  });    
              }else{
                  $scope.assetMaintenanceObj.itemId ="";   
                  $('#AssetTrackDetails').hide();
                  $scope.rowCollection=[];
              }
          };
          
          $scope.jobTitle=function(){
              if($scope.assetMaintenanceObj.verifyId != ""){
                  angular.forEach($scope.employeeList,function(value,key){
                      if($scope.assetMaintenanceObj.verifyId === value.id){
                          $scope.assetMaintenanceObj.jobTitle=value.designationName;
                     } 
                  });    
              }else{
                  $scope.assetMaintenanceObj.jobTitle ="";
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
          
      
      
      
      
      $scope.submit = function(assetmaintenaceContractForm,assetMaintenanceObj,rowCollection) {
          if (new validationService().checkFormValidity($scope.assetmaintenaceContractForm)) {
                  $scope.update(assetMaintenanceObj,rowCollection);
          } else {
              toaster.pop('error', "Please fill the required fields", 
                      logger.getErrorHtmlNew($scope.assetmaintenaceContractForm.$validationSummary), 555000, 'trustedHtml');
          }
      };
      
      
      $scope.update=function(assetMaintenanceObj,assetTrackDetails){
          var jsonData={
                  'amcId' : assetMaintenanceObj.amcId,
                  'assetMaintenanceDate' :assetMaintenanceObj.assetMaintenanceDate,
                  'entityId' :assetMaintenanceObj.entityId,
                  'itemId' :assetMaintenanceObj.itemId,
                  'maintenanceId' :assetMaintenanceObj.maintenanceId,
                  'contactPerson' :assetMaintenanceObj.contactPerson,
                  'verifyId':assetMaintenanceObj.verifyId,
                  'contactNo' :assetMaintenanceObj.contactNo,
                  'startDate' :assetMaintenanceObj.startDate,
                  'endDate' :assetMaintenanceObj.endDate,
                  'quantity':assetMaintenanceObj.quantity,
                  'amount':assetMaintenanceObj.amount,
                   'taxId':assetMaintenanceObj.taxId,
                  'subtaxId':assetMaintenanceObj.subtaxId,
                  'totalAmount':assetMaintenanceObj.totalAmount,
                  'url':$scope.assetMaintenanceObj.url,
                  'docName':$scope.assetMaintenanceObj.docName,
                  'listAssetTrackDetails' : assetTrackDetails,
          }
          console.log(jsonData);
          $http.post('hospital/asset/assetmaintenanceContract/update',jsonData).success(function(data){
          if (data) {
                  logger.logSuccess("Updated!");
                  $state.go('app.hospital.asset.maintenancecontract.list');
                  } else {
                      logger.logError("Error Not Updated!");
              }
          }).error(function(data) {
              logger.logError("Error Not Updated!");
          });
          
      
      }
      
      $scope.choosefile=function(element){
          if(element.files.length > 0){
          var excelfile=element.files[0];
          var file=new FormData();
          file.append("file",excelfile);
          $.ajax({
              type : "POST",
              url : "hospital/asset/assetmaintenanceContract/fileUpload?file="+file +"&docName="+$scope.assetMaintenanceObj.docName,
              data : file,
              contentType: false,
              processData: false,
              success : function(result) {
                  if(result != undefined){
                      logger.logSuccess("File Uploaded Successfully");
                      $scope.assetMaintenanceObj.url=result;
                      $scope.isUpload=false;
                  }else{
                      logger.logError("Fail to Upload");    
                  }
                  }
             
          });
      }
      }
      
      $scope.cancel = function(){
          $state.go("app.hospital.asset.maintenancecontract.list");
      };
      
      
     
      
      $scope.onCount=function(assetTrackConfirm){
          if(assetTrackConfirm){
              totalCheckedCount++;
              $scope.assetMaintenanceObj.quantity=totalCheckedCount;
              if($scope.assetMaintenanceObj.amount !== ""){
                  $scope.calculateSubAmount($scope.assetMaintenanceObj.amount,$scope.assetMaintenanceObj.quantity);    
              }
              
              
          }else if(!assetTrackConfirm){
              totalCheckedCount--;
              $scope.assetMaintenanceObj.quantity=totalCheckedCount;
              if($scope.assetMaintenanceObj.amount !== ""){
                  $scope.calculateSubAmount($scope.assetMaintenanceObj.amount,$scope.assetMaintenanceObj.quantity);    
              }
              
          }
      }
      
      $scope.calculateSubAmount=function(amount,qty){
          
          if(amount !== "" && parseInt(qty) > 0){
          var amountCalculation=parseFloat(amount) * parseInt(qty);
          $scope.assetMaintenanceObj.subAmount=amountCalculation.toFixed(2);
              if($scope.assetMaintenanceObj.taxId !== ""){
                  $scope.taxAmount();
              }
          }else{
              $scope.subTax=true;
              $scope.assetMaintenanceObj.subAmount=0.00;
              $scope.assetMaintenanceObj.taxId="";
              $scope.assetMaintenanceObj.taxAmount=0.00;
              $scope.assetMaintenanceObj.subtaxAmount=0.00;
              $scope.assetMaintenanceObj.subtax="";
              $scope.assetMaintenanceObj.totalAmount=0.00;
          }
      }
      
      $scope.taxAmount=function(){
          var taxAmount,taxPercentage;
          var subTaxId,subtaxAmount,subtaxPercentage;
          if($scope.assetMaintenanceObj.taxId !== "" ){
          var obj = $filter('filter')($scope.taxList, {
              id : $scope.assetMaintenanceObj.taxId
          },true)[0];
          taxAmount=parseFloat(obj.taxFixedAmount);
          taxPercentage= parseFloat(obj.taxPercentage);
          
          
          if(taxAmount !== 0 &&  taxPercentage === 0){
              $scope.assetMaintenanceObj.taxAmount=parseFloat(taxAmount).toFixed(2);
          }else {
              var calculat= taxPercentage * (parseFloat($scope.assetMaintenanceObj.subAmount) / 100);
              $scope.assetMaintenanceObj.taxAmount=parseFloat(calculat).toFixed(2);
          }
      
          var subTaxobj = $filter('filter')($scope.subTaxList, {
              taxId : $scope.assetMaintenanceObj.taxId
          },true)[0];
      
          $scope.assetMaintenanceObj.totalAmount= (parseFloat($scope.assetMaintenanceObj.subAmount) + parseFloat($scope.assetMaintenanceObj.taxAmount)).toFixed(2);
          if(subTaxobj != undefined){
              
          subtaxAmount=parseFloat(subTaxobj.subTaxFixedAmount);
          subtaxPercentage=parseFloat(subTaxobj.subTaxPercentage);
          $scope.assetMaintenanceObj.subtaxId=subTaxobj.subTaxId;         
          $scope.assetMaintenanceObj.subtax=subTaxobj.subTaxName;
          $scope.subTax=false;
          if(subtaxAmount !== 0 &&  subtaxPercentage === 0){
              $scope.assetMaintenanceObj.subtaxAmount=parseFloat(subtaxAmount).toFixed(2);
          }else {
              var calculat= subtaxPercentage * ($scope.assetMaintenanceObj.taxAmount / 100);
              $scope.assetMaintenanceObj.subtaxAmount=parseFloat(calculat).toFixed(2);
          }
          $scope.assetMaintenanceObj.totalAmount= (parseFloat($scope.assetMaintenanceObj.totalAmount)  + parseFloat($scope.assetMaintenanceObj.subtaxAmount)).toFixed(2);
          }
          
       
          
          }else{
              $scope.subTax=true;
              $scope.assetMaintenanceObj.taxAmount=0.00;
              $scope.assetMaintenanceObj.subtaxAmount=0.00;
              $scope.assetMaintenanceObj.subtax="";
              $scope.assetMaintenanceObj.totalAmount=0.00;
          }
      
      }
      $scope.cancelUpload=function(){
          var url=   "hospital/asset/assetmaintenanceContract/filedelete?filePath="+$scope.assetMaintenanceObj.url
          $http.get(url).success(function(data){
              debugger
              if (data) {
                      logger.logSuccess("File Successfully Removed!");
                      $scope.assetMaintenanceObj.url="";
                      $scope.isUpload=true;
                      } else {
                          logger.logError("File Not Successfully Removed!!");
                  }
              }).error(function(data) {
                  logger.logError("Error!");
              });
      };
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