 'use strict';
 app.controller('holidayMasterNewEditCtrl', function($scope,$state,$http,ngDialog, logger,$location,$controller,$injector, sharedProperties, toaster,$rootScope,validationService ,$stateParams) {
       alert(5); 
        var holidayId = $stateParams.holidayId;
        
        $scope.holidayMaster = {
                branch : '',
                holidayId:'',
                companyName : '',
                holidayName : '',
                date : '',
                day : '',
                isEdit :true
            
        };
        var holidayId = $location.search().holidayId;

        $scope.isEdit = false;
        if(holidayId != 0){
      //      console.log(holidayId);
            $scope.isEdit = true;
            
            $http.post($stateParams.tenantid+"/app/hr/holiday/getholidayList",holidayId)
            .success(function(response) {
                   $scope.holidayMaster = response;
                   $scope.holidayMaster.companyId=response.companyId;
                   $scope.holidayMaster.branch=response.branch;
                 //  $scope.getCompanyList();


            });
        }
        
    
          /*  
            if( $scope.isEdit==true){
                $scope.reset = function(HolidayMasterAddForm) {
                    
                   
                    // $scope.holidayMaster.branch ='';
                      $scope.holidayMaster.holidayName=result.holidayName;
                     $scope.holidayMaster.date = result.date;
                     
                    
                 };}
           */
        
        $scope.update = function(holidayMaster) {
                $http.post($stateParams.tenantid+"/app/hr/holiday/update",  $scope.holidayMaster).success(function(result) {
                    if (result==true) {
                        logger.logSuccess("Updated Succesfully!");
                        $state.go('app.hr.manageholidayNew.list');
                    } else {
                        logger.logError("Not Updated!");
                    }
                }).error(function(result) {
                    console.log("data" + result);
                });
            
        }

        $scope.cancel = function(){
            $state.go("app.hr.manageholidayNew.list");
        };
       
        $scope.reset = function() {
            if($scope.isEdit == true){
             var holidayId = $scope.holidayMaster.holidayId;
             $scope.holidayMaster.holidayName ='';
             $scope.holidayMaster.date ='';
            
             
             $http.post($stateParams.tenantid+"/app/hr/holiday/getholidayList",holidayId)
             .success(function(response) {
                 console.log("editresultttttttttt");
                 console.log(response); 
                    $scope.holidayMaster = response;
                    
             });
            }else{
                $scope.holidayMaster.holidayName ='';
                $scope.holidayMaster.date ='';
                $scope.holidayMaster.branch='';
                $scope.holidayMaster.companyId='';
             }
            };
   
  
        
    });