'use strict';
app.controller('avgWeightPerTeuCtrl', function($scope, $rootScope, $http, $location, logger, $log, ngDialog, $modal, utilsService, sharedProperties, $state) {
 $scope.avgWeightPerTeu = [];
    
 $scope.getList = function() {
        $http({
            url: "app/csrreports/avgWeightPerteu", 
            method: "GET",
            params: {
                'year':$scope.year
            }
         }).success(function(data) {
             $scope.avgWeightPerTeu =data;
         });
    };
  $scope.getList();
  
  $scope.onAvgWeightPerTeu=function(){
      var url = 'app/csrreports/avgWeightPerteuexcelexp';
      $http.get(url).success(function(data) {
          if(data.success){
              $scope.filePath = data.filePath;
            $("#exportDiv").html("<a id=\"errorExport\" style=\"display:none\" href="+$scope.filePath+"></a>");  
            
            $("#errorExport").bind('click', function() {
            });
            $("#errorExport").simulateClick('click');
        }
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
