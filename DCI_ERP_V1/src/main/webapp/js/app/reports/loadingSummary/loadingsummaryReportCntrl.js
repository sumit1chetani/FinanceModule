app.controller('loadingsummaryReportCtrl', function($scope, $rootScope, $http,
			$filter, $location, logger, $log, ngDialog, $modal, utilsService,
			sharedProperties, $state, $timeout, $window, $stateParams,validationService,toaster) {

		$scope.rowCollection = [];
		$scope.displayedCollection = [];

		$scope.hideAddIcon = true;
		$scope.hideUploadIcon = true;
		$scope.hideEditIcon = true;
		$scope.hideBreadcrumb = true;
		$scope.showEmptyLabel = false;
		$scope.isCollapsed = false;
		$scope.isExport = false;
		
		/* $('#date').datetimepicker({
		        format : 'DD/MM/YYYY'
		    })*/
		$scope.loadingType = [
		    {id: 'FCL', text: 'FCL'},
		    {id: 'LCL', text: 'LCL'}
		  ];
		$scope.week = [
		     {id: '1', text: '1'},
		     {id: '2', text: '2'},
		     {id: '3', text: '3'},
		     {id: '4', text: '4'},
		     {id: '5', text: '5'},
		     {id: '6', text: '6'},
		     {id: '7', text: '7'},
		     {id: '8', text: '8'},
		     {id: '9', text: '9'},
		     {id: '10', text: '10'},
		     {id: '11', text: '11'},
		     {id: '12', text: '12'},
		     {id: '13', text: '13'},
		     {id: '14', text: '14'},
		     {id: '15', text: '15'},
		     {id: '16', text: '16'},
		     {id: '17', text: '17'},
		     {id: '18', text: '18'},
		     {id: '19', text: '19'},
		     {id: '20', text: '20'},
		     {id: '21', text: '21'},
		     {id: '22', text: '22'},
		     {id: '23', text: '23'},
		     {id: '24', text: '24'},
		     {id: '25', text: '25'},
		     {id: '26', text: '26'},
		     {id: '27', text: '27'},
		     {id: '28', text: '28'},
		     {id: '29', text: '29'},
		     {id: '30', text: '30'},
		     {id: '31', text: '31'},
		     {id: '32', text: '32'},
		     {id: '33', text: '33'},
		     {id: '34', text: '34'},
		     {id: '35', text: '35'},
		     {id: '36', text: '36'},
		     {id: '37', text: '37'},
		     {id: '38', text: '38'},
		     {id: '39', text: '39'},
		     {id: '40', text: '40'},
		     {id: '41', text: '41'},
		     {id: '42', text: '42'},
		     {id: '43', text: '43'},
		     {id: '44', text: '44'},
		     {id: '45', text: '45'},
		     {id: '46', text: '46'},
		     {id: '47', text: '47'},
		     {id: '48', text: '48'},
		     {id: '49', text: '49'},
		     {id: '50', text: '50'},
		     {id: '51', text: '51'},
		     {id: '52', text: '52'},
		     {id: '53', text: '53'}
		];
		$scope.month = [
		    {id: 'JAN', text: 'JANUARY'},
		    {id: 'FEB', text: 'FEBRUARY'},
		    {id: 'MAR', text: 'MARCH'},
		    {id: 'APR', text: 'APRIL'},
		    {id: 'MAY', text: 'MAY'},
		    {id: 'JUN', text: 'JUNE'},
		    {id: 'JUL', text: 'JULY'},
		    {id: 'AUG', text: 'AUGUST'},
		    {id: 'SEP', text: 'SEPTEMBER'},
		    {id: 'OCT', text: 'OCTOBER'},
		    {id: 'NOV', text: 'NOVEMBER'},
		    {id: 'DEC', text: 'DECEMBER'}
		  ];
		/*reset*/
		$scope.reset = function(loadingSummaryForm,loadingReport) {
			$scope.loadingReport = {};
//			customerHdr :'';
//			datefromHdr:'';
//			voyageHdr:'';
//			datetoHdr:'';
//			weekHdr:'';
//			monthHdr:'';
//			loadingTypeHdr:'';	
		}
		
		//Cancel
		$scope.cancel = function() {
			$scope.isCollapsed = false;
			$scope.isExport = false;	
		}
		
		$scope.loadingReport = {
			customerHdr :'',
			datefromHdr:'',
			voyageHdr:'',
			datetoHdr:'',
			weekHdr:'',
			monthHdr:'',
			loadingTypeHdr:'',
			excelHeaderList:[]
			
		}
		//Dropdown for Selectivity
		$http.post($stateParams.tenantid+'/app/loadingsummaryreport/dropDownList').success(function(data) {
			$scope.customer=data.listcustomer;
		  	$scope.voyage=data.listvoyage;
		});
		
		 $scope.getReprtHeader = function(){
			 $http.get($stateParams.tenantid + '/app/loadingsummaryreport/getReprtHeader')
				.success(function(datas) {
					$scope.dailyLoadingHeaderList =  datas.headerList;
				}).error(function(datas) {
				});
			 
		        
		 }
		$scope.getReprtHeader();

		//View
		$scope.getLoadingSummaryData = function(loadingSummaryForm,loadingReport) {
			$http.post($stateParams.tenantid + '/app/loadingsummaryreport/viewReport',$scope.loadingReport)
					.success(function(data) {
						
						if(data.loadingsummaryReportList.length > 0 && data.success) {
							if($scope.loadingReport.month != '' && $scope.loadingReport.week != ''){
								$scope.loadingReport.date='';
							}
							$scope.rowCollection=data.loadingsummaryReportList
							$scope.isExport = true;
							$scope.isCollapsed = true;
							} else {
								if($scope.loadingReport.month != '' && $scope.loadingReport.week != ''){
								$scope.loadingReport.date='';
								}
							logger.logError("No record to view");

						}
					
					}).error(function(datas) {
					});
			 
		}
		

		$scope.selectall = true;
		    $scope.selectAll = function(value){
		        
		        for(var index in $scope.dailyLoadingHeaderList){
		           
		            var colum = $scope.dailyLoadingHeaderList[index];
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
		        
		        var value = $scope.dailyLoadingHeaderList.indexOf(index);
		        var indexExsists = $scope.selectedVisibility.indexOf(index);
		        if(indexExsists ==-1)
		            {
		                $scope.selectedVisibility.push(value);
		            }
		    };
		    
		    
		    $scope.onDropComplete = function (index, obj, evt) {
		
		        var otherIndex = $scope.dailyLoadingHeaderList.indexOf(obj);
		        
		        if(index !=undefined){
		            $scope.dailyLoadingHeaderList.splice(otherIndex, 1);
		            $scope.dailyLoadingHeaderList.splice(index, 0, obj);
		        }

		        else if(index = "undefined"){
		            $scope.dailyLoadingHeaderList.splice(otherIndex, 1);
		            $scope.dailyLoadingHeaderList.splice($scope.dailyLoadingHeaderList.length, 0, obj);
		        }
		    };
		
		

		//Export Excel
		$scope.exportExcel = function(loadingReportForm,loadingReport) {
			
			debugger;
			$scope.loadingReport.excelHeaderList= $filter('filter')($scope.dailyLoadingHeaderList, { visible: true}, true);
			$http.post($stateParams.tenantid + '/app/loadingsummaryreport/excelExport',
				$scope.loadingReport).success(function(data) {
				if (data.isSuccess == true) {
					if(data.filePath != null){
				$scope.fileUrl = data.filePath;	 
				
				$scope.downloadFilePath = data.filePath.split("/");
				$scope.actualLength=$scope.downloadFilePath.length;
				$scope.fileLength=$scope.actualLength - 1;
	            $scope.downloadFile = $scope.downloadFilePath[$scope.fileLength];
	            console.log($scope.downloadFile)
				
				logger.logSuccess("Exported successfully!");
//				 $('#loadingsummaryExport').attr('href','filePath/' +$scope.downloadFile);
			    $("#loadingsummaryExport").bind('click', function() {
			   });
			   $('#loadingsummaryExport').simulateClick('click');
			   if($scope.loadingReport.month != '' && $scope.loadingReport.year != ''){
					$scope.loadingReport.date='';
				}
			   
				}
				else
					{
					if($scope.loadingReport.month != '' && $scope.loadingReport.year != ''){
						$scope.loadingReport.date='';
					}
					logger.logError("No Record Found!");

					}
			   
			   
			   } else {
				   if($scope.loadingReport.month != '' && $scope.loadingReport.year != ''){
						$scope.loadingReport.date='';
					}
					logger.logError("Failed to Export!..");
				}

			}).error(function(data) {
				if($scope.loadingReport.month != '' && $scope.loadingReport.year != ''){
					$scope.loadingReport.date='';
				}
				logger.logError("Error Please Try Again");
			});
			
		       
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
		
		/*//upload
		$scope.uploadFile = function(element) {
	        $scope.excelfile = element.files[0];
	        console.log($scope.excelfile);
	    }

		$scope.uploadExcel = function() {
	      if($scope.excelfile != undefined && $scope.excelfile.size > 0){
	        var excelfile = $scope.excelfile;
	        var fileExtension = excelfile.name;
	        var fName = [];
	        fName = fileExtension.split(".");
	        for (var i = 0; i < fName.length; i++) {
	            if (fName[i] == "xls" || fName[i] == "xlsx") {
	                var frmData = new FormData();
	                frmData.append("file", excelfile);                    
	                $.ajax({
	                    type : "POST",  
	                    url : $stateParams.tenantid+"/app/loadingReport/excelExportContainer",
	                    data : frmData,
	                    contentType : false,
	                    processData : false,
	                    success : function(response) {
	                    	if(response.error1 == "Successfully uploaded"){
	                    		logger.logSuccess(response.error1); 
	                    		if($scope.loadingReport.month != '' && $scope.loadingReport.year != ''){
	    							$scope.loadingReport.date='';
	    						}
	                    	}else if(response.error1 == '' && response.error1 == null){
	                    		logger.logError("Failed to Upload"); 
	                    		if($scope.loadingReport.month != '' && $scope.loadingReport.year != ''){
	    							$scope.loadingReport.date='';
	    						}
	                    	}
	                    	else{
	                    		logger.logError(response.error1);
	                    		if($scope.loadingReport.month != '' && $scope.loadingReport.year != ''){
	    							$scope.loadingReport.date='';
	    						}
	                    	}
	                    }
	                });
	            }
	        }
	      }else{
	          logger.logError('Please choose a file !');
	      }
	    }*/
		
	});

