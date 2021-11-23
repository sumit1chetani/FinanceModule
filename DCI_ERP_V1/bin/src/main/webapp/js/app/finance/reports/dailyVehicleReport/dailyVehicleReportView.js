'use strict';
app.controller('dailyVehicleReportCtrl', function($templateCache, $scope,
		$rootScope, $http, logger, $log, ngDialog, $modal, $location, $sce,
		$filter, $stateParams,validationService,toaster,$timeout) {

	$('#tb_fromDate').datetimepicker({
		format : 'DD/MM/YYYY'
	});

	$('#tb_toDate').datetimepicker({
		format : 'DD/MM/YYYY'
	});
	

	 var d = new Date();
     var year = d.getFullYear();
     var month = d.getMonth() + 1;
     if (month < 10) {
         month = "0" + month;
     }
     ;
     var day = d.getDate();
     var todayDate = day + "/" + month + "/" + year;
     
	
	
	
	$scope.dailyVehicleReport = {
			
			
			truckId :'',
			tripId :'',
			truckIdList :[],
			fromDate : todayDate,
			toDate: todayDate,
		
	}

	
	 $scope.$watch('[dailyVehicleReport.fromDate,dailyVehicleReport.toDate]', function(newValue) {

         if (newValue != "") {
             if ($scope.dailyVehicleReport.fromDate != '' && $scope.dailyVehicleReport.toDate != '') {
                 var fromDate = $scope.dailyVehicleReport.fromDate;
                 var toDate = $scope.dailyVehicleReport.toDate;
                 fromDate = fromDate.split("/");
                 fromDate = new Date(fromDate[2], fromDate[1], fromDate[0]);
                 toDate = toDate.split("/");
                 toDate = new Date(toDate[2], toDate[1], toDate[0]);
                 if (fromDate <= toDate) {

                 } else {
                     $scope.dailyVehicleReport.toDate = '';
                     logger.logError("To Date Should be greater than From Date");
                 }
             }
         }
     });
	
	
	
    $("#truckMultiSelect").multiselect({
        maxHeight: 200,   
        includeSelectAllOption: true,
        disableIfEmpty: true,
        enableCaseInsensitiveFiltering: true,
        onDropdownHide: function (event) {
            
        }
      });
    $(".multiselect").addClass("width_100 input-sm line-height-5");
    
    
   /* $("#truckMultiSelect").multiselect({
        maxHeight : 200,
        includeSelectAllOption : true,
        disableIfEmpty : true,
    });
    $(".multiselect").addClass("width_100 input-sm line-height-5");
*/
	
	
	$scope.getList = function() {
		$http.get($stateParams.tenantid + '/app/dailyVehicle/dropDown')
				.success(function(datas) {
					
					$scope.tripList=datas.tripList
					$scope.truckList = datas.truckList;
					
					console.log(datas);
					   $timeout(function() {
			                $('#truckMultiSelect').multiselect('deselectAll', false);
			                $('#truckMultiSelect').multiselect('updateButtonText');
			                $("#truckMultiSelect").multiselect('rebuild');
			            
			            }, 2, false);
			            $("#multiselect-button").addClass("width_100 input-sm line-height-5");
					
				}).error(function(datas) {
				});
	}
	$scope.getList();
	
	
	 $scope.$watch('dailyVehicleReport.tripId', function(newValue) {
		 
		 
			$scope.dailyVehicleReport.truckIdList =[];
	

        if (newValue != "") {
        	 
        	 $http.post($stateParams.tenantid + '/app/dailyVehicle/truckByTrip',newValue)
				.success(function(datas) {
					$scope.truckList = datas.truckByTrip;
					
					 $timeout(function() {
			                $('#truckMultiSelect').multiselect('deselectAll', false);
			                $('#truckMultiSelect').multiselect('updateButtonText');
			                $("#truckMultiSelect").multiselect('rebuild');
			            
			            }, 2, false);
			            $("#multiselect-button").addClass("width_100 input-sm line-height-5");
					
					
				});
        	 
        	 
         }
   	 
		 if (newValue == "") {
			 $scope.getList();
		 }
        
     });
	 
	 
	 
	

	$scope.exportExcel = function(dailyVehicleReportForm,dailyVehicleReport) {
		
		
		
        if (new validationService().checkFormValidity(dailyVehicleReportForm)) {
        	
        	
        	
        	// $scope.dailyVehicleReport.dumCcategory = $scope.paymentMode.category

         /*    var truckId = [];
             angular.forEach($scope.dailyVehicleReport.truckIdList, function(value, key) {
            	 truckId.push(value.id);
             });

             $scope.dailyVehicleReport.truckIdList = truckId;
        	
        	*/
        	
		
		$http.post($stateParams.tenantid + '/app/dailyVehicle/excelExport',
			$scope.dailyVehicleReport).success(function(data) {
			if (data.success == true) {
				
				if(data.data==true){
			
			$scope.fileUrl = data.filePath;	
			
			$scope.downloadFilePath = data.filePath.split("/");
			$scope.actualLength=$scope.downloadFilePath.length;
			$scope.fileLength=$scope.actualLength - 1;
            $scope.downloadFile = $scope.downloadFilePath[$scope.fileLength];
            console.log($scope.downloadFile)
            
			logger.logSuccess("Exported successfully!");
			 $('#dailyExport').attr('href','filePath/'+$scope.downloadFile);
		    $("#dailyExport").bind('click', function() {
		   });
		   $('#dailyExport').simulateClick('click');
		   
			}
			else
				{
				logger.logError("No Record Found");

				}
		   
		   } else {
				logger.logError("Failed to Export!..");
			}
			

		}).error(function(data) {
			logger.logError("Error Please Try Again");
		});
		
       } else {
           toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(dailyVehicleReportForm.$validationSummary), 555000, 'trustedHtml');
           
       }
	};
	
	
	$scope.reset = function() {
		
		$scope.dailyVehicleReport.truckId='';
		$scope.dailyVehicleReport.tripId='';
		$scope.dailyVehicleReport.fromDate= '';
		$scope.dailyVehicleReport.toDate= '';
		
		
		$scope.dailyVehicleReport.truckIdList =[];
		
		
		$timeout(function() {
            $('#truckMultiSelect').multiselect('deselectAll', false);
            $("#truckMultiSelect").multiselect('rebuild');
        }, 3, false);
		$scope.getList();
	}
	
	
	
	$.fn.simulateClick = function() {
		return this.each(function() {
			if ('createEvent' in document) {
				var doc = this.ownerDocument, evt = doc
						.createEvent('MouseEvents');
				evt.initMouseEvent('click', true, true, doc.defaultView, 1, 0,
						0, 0, 0, false, false, false, false, 0, null);
				this.dispatchEvent(evt);
			} else {
				this.click(); // IE
			}
		});
	}
	
	
	
	
	
	
});
