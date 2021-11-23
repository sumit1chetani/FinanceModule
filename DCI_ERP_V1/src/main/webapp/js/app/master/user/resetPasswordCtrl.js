'use strict';
app.controller('resetPasswordCtrl', function( $scope, $rootScope, $http, $location, $injector, logger, utilsService, $state, sharedProperties, $window,validationService,toaster, $timeout) {        
     
    $scope.userList = [];
    $scope.resetPasswordData = {
            userId: '',
            pwdName : ''             
   };
    
    $scope.getUserCompanyModuleList = function() {
        $http.get('app/usermaster/usercompanymodulelist').success(function(datas) {
            $scope.userList = datas.lUserMasterBean;
        });
    };
    $scope.getUserCompanyModuleList();
    
    
    $scope.cancel = function() {
        $location.path("/home/dashboard");
    };
   $scope.edit=true;   
    $scope.save = function(resetPasswordForm,resetPasswordData) {   
        if (new validationService().checkFormValidity($scope.resetPasswordForm)) {
            $http.post('app/password/add', resetPasswordData).success(function(result) {
                if (result) {
                    logger.logSuccess("Password Reset successfully!");   
                    $scope.resetPasswordData.userId = "";
                    $scope.resetPasswordData.pwdName = "";
                } else {
                    logger.logError("Unable to save!!");
                }
            }).error(function(result) {
                console.log("data" + result);
            });
        }else {
            toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.resetPasswordForm.$validationSummary), 555000, 'trustedHtml');
        }
                    
    };
      
});