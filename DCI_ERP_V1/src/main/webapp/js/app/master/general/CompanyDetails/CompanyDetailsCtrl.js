'use strict';
app.controller('CompanyDetailsCtrl', function($scope,$stateParams, $rootScope, $http, $location, logger, $log, ngDialog, $modal, utilsService, sharedProperties, $state,$window) {     
   
    $scope.index=[];
    $scope.checked = [];
    var index="";
    $scope.itemsByPage =10 ;
    
    //Add
    $scope.add = function(){
        $state.go('app.truck.general.companydetails-add',{tenantid:$stateParams.tenantid});
    }; 
    
    //Populate Grid
    $scope.getTranslationList = function() {
        $scope.dataLoopCount = 0;
        $scope.showEmptyLabel = false;
        $scope.from = 0;
        $scope.to = 100;
        $scope.rowCollection = [];
        var url = $stateParams.tenantid+'/app/companydetails/list?limit=' + $scope.from + '&offset=' + $scope.to;
        $http.get(url).success(function(data) {
            if (data.success == true) {
                $scope.rowCollection = $scope.rowCollection.concat(data.lCompanyDetailsBean);
            }
        });
    };

    $scope.getTranslationList();
    
    
    
    $scope.view = function(distanceNo){
        $location.url($stateParams.tenantid+'/general/companydetails/view?companycode='+distanceNo);
    }
        
    //Edit
    
    $scope.editedRow = function(companycode) {
        $location.url($stateParams.tenantid+'/general/companydetails/edit?companycode='+companycode);

    };
       
    // Delete
    $scope.deleteRow = function(companycode, index) {
        ngDialog.openConfirm().then(function() {
            var myURL = $stateParams.tenantid+'/app/companydetails/delete';
            $http({
                url : myURL,
                data : companycode,
                method : 'post',
                dataType : 'json',
                headers : {
                    'Accept' : 'application/json',
                    'Content-Type' : 'application/json'
                }
            }).success(function(data) {
                console.log("delete data**************************************************8888");
                console.log(data);
                if (data == true) {
                    var tableData = $scope.rowCollection;
                    $scope.rowCollection.splice(index, 1);
                    logger.logSuccess("Company Detail Deleted Successfully");
                } else {
                    logger.logSuccess("You Can't Delete this Record, Related Data Exist");
                }
            }).error(function(data) {
                logger.logSuccess("Error in Delete Company Detail!");
            });
        });
    };
      
});
