'use strict';
app.controller('thirdPartyLoadingCtrl', function($scope, $rootScope, $http, $location, logger, $log, ngDialog, $modal, utilsService, sharedProperties, $state) {
    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.thirdPartyLoadings =[];
    $scope.currentYear = '';
    $scope.prevYear = '';
    
 $scope.getList = function() {
        $http({
            url: "app/csrreports/thirdpartyloadings", 
         }).success(function(data) {
             $scope.rowCollection = data[0];
             $scope.currentYear = data[1];
             $scope.prevYear = data[2];
         });
    };
  $scope.getList();
  $scope.onThirdPartyExp=function(){
      var url = 'app/csrreports/thirdpartyexcelexp';
      $http.get(url).success(function(data) {
          if(data.success){
              $scope.filePath = data.filePath;
            $("#exportDiv").html("<a id=\"errorExport\" style=\"display:none\" href="+$scope.filePath+"></a>");  
            
            $("#errorExport").bind('click', function() {
            });
            $("#errorExport").simulateClick('click');
        }
         // $scope.attributeList = data.lAttributeList;
      });
  }
  
  $.fn.simulateClick = function() {
      return this.each(function() {
          if ('createEvent' in document) {
              var doc = this.ownerDocument, evt = doc.createEvent('MouseEvents');
              evt.initMouseEvent('click', true, true, doc.defaultView, 1, 0, 0, 0, 0, false, false, false, false, 0, null);
              this.dispatchEvent(evt);
          } else {
              this.click(); // IE
          }
      });
  }
  
  
});
