define([ 'hospital/asset/asset' ], function(module) {

'use strict';

    module.registerController('deprecatoionAppricationMethodAddCtrl', function($scope,$state,$http,ngDialog, logger,$location,$controller,$injector, sharedProperties, toaster,$rootScope,validationService) {
        
        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.rowCollection = [];
        $scope.categoryList = [];
        $scope.displayedCollection = [];
        $scope.displayedCollectionMethod = [];
        $scope.itemsByPage = 10;
        $scope.tableSelection=[];
        
       
        $scope.isDisplay = true;
        
        $scope.isEdit = false;
        $scope.cancel = function(){
            $state.go("app.hospital.asset.deprecationApprecationMethod.list");
        };
        
        
        $scope.cancelDeprecation = function(){
             ngDialog.close();
        }
        
        $scope.depreciationMethod = {
                depreciationMethodsId:0,
                valuationType:'',
                computationMethod :'',
                computationMethodId:'',                
                aggressiveFactor  :'',
                method:'',
                methodId:'',
                noOfDepreciation   :'',
                periodLength      :'',
                endingDate      :'',
                itemCategoryId:'',
                itemCategory:'',
                id:'',
                text:''
                
        };
              
        $scope.computationMethodList=[];
        $scope.methodsList=[];
        
       
        
        
        $http.get("app/depreciationmethod/getcategoryList").success(function(datas) {
            $scope.ItemList=datas.itemList
        });
        
    
         $scope.setComputationMethod = function(){
         //   alert("appreciation"+$scope.depreciationMethod.valuationType);
            if($scope.depreciationMethod.valuationType=='A'){
                $scope.computationMethodList=$scope.appreComputationMethosList;
                $scope.methodsList=$scope.appreMethodsList;
            }
            else {
                $scope.computationMethodList=$scope.depreComputationMethosList;
                $scope.methodsList=$scope.depreMethodsList;
            }
        }
         
        $scope.getDropDownList = function(){
            $http.get("app/depreciationmethod/getDropDownList").success(function(response) {
                if(response.success == true){
                    $scope.appreComputationMethosList = response.appreComputationMethosList;
                    $scope.depreComputationMethosList = response.depreComputationMethosList;
                    $scope.appreMethodsList = response.appreMethodsList;
                    $scope.depreMethodsList = response.depreMethodsList;
                    $scope.setComputationMethod();

                }else
                    if(response.message == ''){
                        alert("edit");
                        logger.logError(response.message);
                    }
                
             });
       }
        $scope.getDropDownList();
        
        var id = $location.search().id;
        if(id != ''){
            $http.post("app/depreciationmethod/edit",id).success(function(response) {
               if(response.success == true){
//                   $scope.getDropDownList();
                   $scope.depreciationMethod = response.depreciationAppreciationBean;
                   $scope.isEdit = true;
                   if($scope.depreciationMethod.valuationType=='A'){
                       $scope.computationMethodList=$scope.appreComputationMethosList;
                       $scope.methodsList=$scope.appreMethodsList;
                   }
                   else {
                       $scope.computationMethodList=$scope.depreComputationMethosList;
                       $scope.methodsList=$scope.depreMethodsList;
                   }
                   $scope.depreciationMethod.itemCategoryId =response.depreciationAppreciationBean.itemCategoryId.toString();
                   $scope.depreciationMethod.computationMethodId =response.depreciationAppreciationBean.computationMethodId.toString();
                   $scope.depreciationMethod.methodId =response.depreciationAppreciationBean.methodId.toString();
               }else{
                   if(response.message == ''){
                       alert("edit");
                       logger.logError(response.message);
                   }
               }
            });
        }
        
        
        $scope.save = function(deprecationApprecationMethodForm,depreciationMethod) {
            if (new validationService().checkFormValidity(deprecationApprecationMethodForm)) {
                sharedProperties.clearObject();
                //console.log($scope.empAwardReward);
                if($scope.depreciationMethod.methodId=='158' || $scope.depreciationMethod.methodId=='160')
                {
                $scope.depreciationMethod.noOfDepreciation='';
                $scope.depreciationMethod.periodLength='';
                }                $http.post("app/depreciationmethod/save", $scope.depreciationMethod).success(function(response) {
                    if (response.success == true) {
                        logger.logSuccess("Saved Successfully!");
                        $state.go("app.hospital.asset.deprecationApprecationMethod.list");
                    } else {
                        logger.logError(response.message);
                    }
                });
            
            }
            else{
                toaster.pop('error', "Please fill the required fields", 
                        logger.getErrorHtmlNew(deprecationApprecationMethodForm.$validationSummary), 555000, 'trustedHtml');
            }
        }
        
       
        $scope.update = function(deprecationApprecationMethodForm,depreciationMethod) {
            if (new validationService().checkFormValidity(deprecationApprecationMethodForm)) {
                sharedProperties.clearObject();
                if($scope.depreciationMethod.methodId=='158' || $scope.depreciationMethod.methodId=='160')
                {
                $scope.depreciationMethod.noOfDepreciation='';
                $scope.depreciationMethod.periodLength='';
                }
                //console.log($scope.empAwardReward);
                $http.post("app/depreciationmethod/update", $scope.depreciationMethod).success(function(response) {
                    if (response.success == true) {
                        logger.logSuccess("Updated Successfully!");
                        $scope.cancel();
                        } else {
                        logger.logError(response.message);
                    }
                });
            
            }
            else{
                toaster.pop('error', "Please fill the required fields", 
                        logger.getErrorHtmlNew(deprecationApprecationMethodForm.$validationSummary), 555000, 'trustedHtml');
            }
            
        } 
        
               
        
        $scope.reset = function(deprecationApprecationMethodForm) {

            if ($scope.isEdit == false) {
                $scope.assetMasterData.valuationType ="A";
                $scope.assetMasterData.depreciationMethodsId ="";
                $scope.assetMasterData.computationMethod ="";
                $scope.assetMasterData.aggressiveFactor ="";
                $scope.assetMasterData.method ="";
                $scope.assetMasterData.aggressiveFactor ="";
                $scope.assetMasterData.periodLength ="";
                $scope.assetMasterData.endingDate ="";
                $scope.assetMasterData.itemCategoryId ="";
              
                

            } else {
                $http.post('app/depreciationmethod/edit', id).success(function(result) {

                    if(result.success == true){
                        $scope.assetMasterData = result.depreciationAppreciationBean;
                    //$scope.list();
                    $scope.isEdit = true;
                    }else
                        if(response.message == ''){
                            //alert("edit");
                            logger.logError(response.message);
                        }
                    

                });
            }
        };
        
      
        
        
    });        
    
});
