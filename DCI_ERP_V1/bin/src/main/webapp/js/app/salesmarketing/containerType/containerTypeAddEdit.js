'use strict';
app.controller('containerTypeCtrlAdEd', function($scope, $rootScope, $http, $location, logger, $log, ngDialog, $modal, utilsService, $window,$state,sharedProperties) {
    
      var maybeObject = {};
    maybeObject = sharedProperties.getObject();
    console.log(maybeObject)
    $scope.containerAddEditDataClear = {};
    $scope.containerAddEditData = {
            container_type_id :'',
            container_type : '',
            group_id : '',
            description : '',
    };
    
    $scope.submitted=false;
    $scope.containerAddEditValidateData = {
        isEdit : false,
        };
    $scope.bresult=true;
        
     $scope.containerAddEditDataClear = angular.copy($scope.containerAddEditData);

    $scope.reset = function() {
        if ($scope.containerAddEditValidateData.isEdit == false){
        $scope.containerAddEditData.container_type = "";
        $scope.containerAddEditData.group_id = "";
        $scope.containerAddEditData.description = ""; }
        else{
            $scope.FetchingValues = function(data){
                    $scope.containerAddEditData.container_type_id = data.container_type_id;
                    $scope.containerAddEditData.container_type = data.container_type;
                    $scope.containerAddEditData.group_id = data.group_id;
                    $scope.containerAddEditData.description = data.description;
                    $scope.containerAddEditValidateData.isEdit = true;
                }
            $scope.FetchingValues(sharedProperties.getObject());
            }
    }
    
    $scope.cancelb = function() {
        $scope.containerAddEditData = angular.copy($scope.containerAddEditDataClear);
        $state.go('app.salesmarketing.containerType.cntType');

    }
    
    $scope.FetchingValues = function(data) {
        if (data == undefined) {
            $scope.containerAddEditData = angular.copy($scope.containerAddEditDataClear);
            $scope.containerAddEditValidateData.isEdit = false;
         } else {
            $scope.containerAddEditData.container_type_id = data.container_type_id;
            $scope.containerAddEditData.container_type = data.container_type;
            $scope.containerAddEditData.group_id = data.group_id;
            $scope.containerAddEditData.description = data.description;
            $scope.containerAddEditValidateData.isEdit = true;
        }

    }
    
    $scope.FetchingValues(sharedProperties.getObject());
      
    
   
    var s1="";
    
    $scope.save = function(containerAddEditForm,containerAddEditData,containerAddEditValidateData) {
       $scope.submitted=true;
            
                           
        if (containerAddEditValidateData.isEdit == false) 
        {
            "<ul>"
            if (containerAddEditForm.container_type.$invalid  ) {
                s1="<li>Container Type!</li>";
            }
            if (containerAddEditForm.group_id.$invalid) {
                s1+="<li>Group ID!</li>";
            }
            "</ul>"
            if (containerAddEditForm.$invalid) {
                logger.logError(s1);
                s1="";
              
            }else{
                
                var updateRowData = containerAddEditData ;
                $http.post('containertype/request/check', updateRowData).success(function(result) {
                 if (result) {
                     s1="<li>Container Type Aleardy Exists!</li>";
                     logger.logError("Container Type Aleardy Exists !");
                    
                 } else {
                     
                     var addRowData = containerAddEditData ;
                     console.log(addRowData);
                     $http.post('containertype/request/add', addRowData).success(function(result) {
                         console.log("result" + result);
                         console.log(result);
                         if (result) {
                             logger.logSuccess("Details Saved successfully!");
                             $state.go('app.salesmarketing.containerType.cntType');
                         } else {
                             logger.logError("Details Not Saved!");
                         }
                     }).error(function(data) {
                         console.log("data" + data);
                     });
                     
                     }
                 }).error(function(data) {
                     
               
                 console.log("data" + data);
                 });
            }
        } else {
                                    
                  
            "<ul>"
            if (containerAddEditForm.container_type.$invalid ) {
                s1="<li>Enter a valid Container Type!</li>";
            }
            if (containerAddEditForm.group_id.$invalid) {
                s1+="<li>Group ID!</li>";
            }
            
            "</ul>"
            if (containerAddEditForm.$invalid) {
                logger.logError(s1);
                s1="";
              
            }           
            
        else
            {
            var updateRowData = containerAddEditData ;
            $http.post('containertype/request/check', updateRowData).success(function(result) {
             if (result) {
                 s1="<li>Container Type Aleardy Exists!</li>";
                 logger.logError("Container Type Aleardy Exists !");
                
             } else {
                 
                 var updateRowData = containerAddEditData ;
                 $http.post('containertype/request/update', updateRowData).success(function(result) {
                 if (result) {
                     logger.logSuccess("Details Updated successfully!");
                     $state.go('app.salesmarketing.containerType.cntType');
                 } else {
                     logger.logError("Details Not Updated!");
                 }
             }).error(function(data) {
                 console.log("data" + data);
             });
                 
                 }
             }).error(function(data) {
                 
           
             console.log("data" + data);
             });
                             
            
            }
        }
        }

       
        });