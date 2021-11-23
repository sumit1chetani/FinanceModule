'use strict';

app.controller('taxtypeCtrl', function($scope, $rootScope, $http, $location, logger, utilsService, ngDialog, $state,sharedProperties,$window,$stateParams) {

    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    
    $scope.getBookingList = function() {
		$http.post($stateParams.tenantid+'/taxtype/reportList').success(function(data) {
			
			$scope.rowCollection = data.reportBean;
		});
	};
	$scope.getBookingList();
	
	
	  $scope.exportExcel = function() {
          $http.post($stateParams.tenantid+'/taxtype/excelreportList').success(function(response){
              console.log(response);
              if (response.success) {
           
                  $scope.filePath = response.filePath;           
                  
						
                  /*$("#taxTypeExport").attr( "href",  $scope.filePath ); */
				  $('#exportXl').append('<a id="tbExcelExport" stype="display:none" href="filePath/tax_report.xls" download="tax_report.xls"></a>');
                  $("#tbExcelExport").bind('click', function() {
                  });
                  $('#tbExcelExport').simulateClick('click');
                  logger.logSuccess("Exported Succesfully!");
         
          }else{
              logger.logError("Failed to export");
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
                  this.click();
              }
          });
      } 
      
      $scope.printReport = function() {
    	  var url = $stateParams.tenantid+'/taxtype/printreportList';
          var wnd = window.open(url, 'KMC', 'height=400,width=750,top=100,left=100,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
          wnd.print();
      };
    
});