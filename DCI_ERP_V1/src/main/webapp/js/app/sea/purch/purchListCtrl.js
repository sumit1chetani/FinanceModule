'use strict';

app.controller('purchListCtrl', function($scope, $rootScope,ngDialog, $http, $location, logger,
        utilsService,$state,sharedProperties,$window,validationService,toaster,$stateParams) {

        $scope.quotationList = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages = 0;
        $scope.isUpload=true;
        $scope.isDelete=true;
        $scope.rowCollection = [];
        
        $scope.add = function(){
            $state.go("app.sea.purch.add");
        }
        
        $scope.getList = function(){
            $http.get("master/purch/getQuotationList").success(function(response) {
                console.log(response.quotationList)
                $scope.rowCollection = response.quotationList;
            });
        }
        $scope.getList();
        $scope.deleteRow = function(quotationId){
            ngDialog.openConfirm().then(function() {
                $http.post("master/purch/delete",quotationId).success(function(response) {
                    if (response.success == true) {
                        logger.logSuccess("Deleted Successfully");
                        $scope.getList();
                    }else{
                        logger.logError("Unable to Delete the Record!");
                    }
                });
            });
        }
        
        $scope.editRow=function(collections){
            $location.url('/master/purch/edit/quotationId='+collections.quotationId);
        }
        $scope.viewPQRow=function(collections){
            $location.url('/master/purch/view/quotationId='+collections.quotationId);
        }
    });
    