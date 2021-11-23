'use strict';

app.controller('ratingListCtrl', function($scope, $rootScope,ngDialog, $http, $location, logger,
        utilsService,$state,sharedProperties,$window,validationService,toaster,$stateParams) {
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages = 0;
        $scope.isUpload = true;
        $scope.isDelete = true;
        
        $scope.rowCollection = [];
        
        $scope.add = function(vendorRatings){
            $state.go("app.sea.rating.add");
        }
        
        $scope.editRow = function(vendorRatings){
            $state.go("app.sea.rating.add");
        }
        
        
    });
    
