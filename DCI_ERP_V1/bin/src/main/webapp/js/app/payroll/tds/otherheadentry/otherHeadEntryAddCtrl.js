define([ 'payroll/tds/tds' ], function(module) {
'use strict';
module.registerController('otherHeadEntryAddCtrl', function($scope,$state,$http,ngDialog, logger,$location,$controller,$injector, sharedProperties, toaster,$rootScope)  {
    
    $scope.otherhead = {
            otherIncomeHeadId:'',
            otherIncomeHeadName:'',
            description:'',
            isEdit:false
           
     };
  /*  var otherIncomeHeadId = $location.search().otherIncomeHeadId;
    if (otherIncomeHeadId == undefined) {
        $scope.otherhead.isEdit = false;
    } else {

        $http.post('payroll/tds/taxsection/edit', otherhead).success(function(result) {
            if (result.isEdit == false) {
                logger.logError("Please Try Again");
            } else {
                console.log("result");
                console.log(result);
                $scope.taxSection = result;
            }

        }).error(function(data) {

        });
    }
    */
    $scope.cancel =function(){
        
        $state.go('app.payroll.tds.taxsection.list');
    };
      
    
  
   // var $validationProvider = $injector.get('$validation');
    $scope.submit=function(othrHeadEntryAddForm){
    //    if($scope.taxSection.isEdit !=true){
            console.log("save data");
            var saveData = $scope.otherhead;
            console.log(saveData);
           //sharedProperties.clearObject();
          //  $validationProvider.validate(taxSectionForm).success(function(){
           $http.post("payroll/tds/otherheadentry/save", saveData).success(function(result) {
                if (result == false) {
                   // logger.logError("Tax Section Code already exist");
                }else{
                   //$state.go('app.payroll.tds.taxsection.list');
                }
                
            })
            
      /*  }).error(function(){
            toaster.pop('error', "Please correct the errors", logger.getErrorHtml(sharedProperties.getErrorObject()), 0, 'trustedHtml');
        });*/
        
       //}     
    }
    $scope.update = function(taxSectionForm) {
        var updateData = $scope.taxSection;
        sharedProperties.clearObject();
        $validationProvider.validate(taxSectionForm).success(function() {
            $http.post('payroll/tds/taxsection/update', updateData).success(function(result) {
                if (result == false) {
                   
                } else {
                    logger.logSuccess("Tax Section Code updated successfully");
                    $state.go('app.payroll.tds.taxsection.list');
                }
            });
        }).error(function() {
            console.log(sharedProperties.getErrorObject())
            toaster.pop('error', "Please correct the errors", logger.getErrorHtml(sharedProperties.getErrorObject()), 0, 'trustedHtml');
        });
      }
   
});
});