app.controller('dailystatusreportCtrl', function($scope, $rootScope, $http,
		$filter, $location, logger, $log, ngDialog, $modal, utilsService,
		sharedProperties, $state, $timeout, $window, $stateParams,validationService,toaster) {

	$scope.rowCollection = [];
	$scope.displayedCollection = [];

	$scope.hideAddIcon = true;
	$scope.hideUploadIcon = true;
	$scope.hideEditIcon = true;
	$scope.hideBreadcrumb = true;
	$scope.showEmptyLabel = false;
	
	$scope.isExport = false;

	$('#validFromDate').datetimepicker({
		format : 'DD/MM/YYYY',
		pickTime : false
	})
	$('#validToDate').datetimepicker({
		format : 'DD/MM/YYYY',
		pickTime : false
	})

	
	$scope.dailyStatusReport = {
		
		year:'',
		month:'',
		excelHeaderList:[]
		
	}

	
	$scope.getDropDown = function() {
		$http.get($stateParams.tenantid + '/app/dailystatusreport/dropDown')
				.success(function(datas) {
					$scope.monthList = datas.monthList;
					$scope.yearList = datas.yearList;
				}).error(function(datas) {
				});
	}
	$scope.getDropDown();
	
	
	
	
	 $scope.getReprtHeader = function(){
		 
		 $http.get($stateParams.tenantid + '/app/dailystatusreport/getReprtHeader')
			.success(function(datas) {
				$scope.dailyStatusHeaderList =  datas.headerList;
			}).error(function(datas) {
			});
		 
	        
	 }
	    
	$scope.getReprtHeader();

	$scope.selectall = true;
	    $scope.selectAll = function(value){
	        //console.log("value")
	        for(var index in $scope.dailyStatusHeaderList){
	            //console.log($scope.dailyStatusHeaderList[index])
	            var colum = $scope.dailyStatusHeaderList[index];
	            if(colum.isDefault == false){
	                if(value == true){
	                    colum.visible = true;
	                }else{
	                    colum.visible = false;
	                }
	            }
	        }
	            
	    }
	    
	    $scope.selectedVisibility = [];
	    $scope.getSelectedColumn=function(index){
	        
	        var value = $scope.dailyStatusHeaderList.indexOf(index);
	        var indexExsists = $scope.selectedVisibility.indexOf(index);
	        if(indexExsists ==-1)
	            {
	                $scope.selectedVisibility.push(value);
	            }
	    };
	    
	    
	    $scope.onDropComplete = function (index, obj, evt) {
	
	        var otherIndex = $scope.dailyStatusHeaderList.indexOf(obj);
	        
	        if(index !=undefined){
	            $scope.dailyStatusHeaderList.splice(otherIndex, 1);
	            $scope.dailyStatusHeaderList.splice(index, 0, obj);
	        }

	        else if(index = "undefined"){
	            $scope.dailyStatusHeaderList.splice(otherIndex, 1);
	            $scope.dailyStatusHeaderList.splice($scope.dailyStatusHeaderList.length, 0, obj);
	        }
	    };
	
	 
	
	$scope.reset = function() {
		
		$scope.dailyStatusReport.month='';
		$scope.dailyStatusReport.year='';
		$scope.rowCollection = [];
		
	}
	
	
	$scope.viewReport = function(dailyStatusReportForm,dailyStatusReport) {
		
		 if (new validationService().checkFormValidity(dailyStatusReportForm)) {
			 
		$http.post($stateParams.tenantid + '/app/dailystatusreport/viewReport',$scope.dailyStatusReport)
				.success(function(data) {
					
					if(data.dailyStatusReportList.length > 0)
						{
						$scope.rowCollection=data.dailyStatusReportList
						$scope.isExport = true;
						}
					else{
						logger.logError("No record to view");

					}
				
				}).error(function(datas) {
				});
		 }
	   else {
          toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(dailyStatusReportForm.$validationSummary), 555000, 'trustedHtml');
         
      }
	}

	
	$scope.exportExcel = function(dailyStatusReportForm,dailyStatusReport) {
		
		debugger;
		
	   if (new validationService().checkFormValidity(dailyStatusReportForm)) {
		   
        $scope.dailyStatusReport.excelHeaderList= $filter('filter')($scope.dailyStatusHeaderList, { visible: true}, true);
		   
		$http.post($stateParams.tenantid + '/app/dailystatusreport/excelExport',
			$scope.dailyStatusReport).success(function(data) {
			if (data.success == true) {
				if(data.filePath != null){
			$scope.fileUrl = data.filePath;	 
			
			$scope.downloadFilePath = data.filePath.split("/");
			$scope.actualLength=$scope.downloadFilePath.length;
			$scope.fileLength=$scope.actualLength - 1;
            $scope.downloadFile = $scope.downloadFilePath[$scope.fileLength];
            console.log($scope.downloadFile)
			
			logger.logSuccess("Exported successfully!");
			 $('#dailyExport').attr('href','filePath/' +$scope.downloadFile);
		    $("#dailyExport").bind('click', function() {
		   });
		   $('#dailyExport').simulateClick('click');
		   
			}
			else
				{

				logger.logError("No Record Found!");

				}
		   
		   
		   } else {
				logger.logError("Failed to Export!..");
			}

		}).error(function(data) {
			logger.logError("Error Please Try Again");
		});
		
	        } else {
	            toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(dailyStatusReportForm.$validationSummary), 555000, 'trustedHtml');
	           
	        }
	};
	
	
	
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
