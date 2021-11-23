'use strict';

app.controller('voyageListCtrl', function($scope, $rootScope, $http, $location, logger, utilsService, ngDialog, $state,sharedProperties,$window,$stateParams) {

    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.rowCollection = [];
    $scope.pollist=[];
    $scope.podlist=[];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.voyageAdd={
    vessel : '',fromDate:'',
    toDate:'',
    voyage : '',
    pol : '',pod:''
}
   
    
    $http.get($stateParams.tenantid+ '/api/voyagemaster/getPortListByVoyage').success(function(data) {
    	debugger
		  $scope.pollist = data;
  }).error(function(data) {
  });
	   $http.get($stateParams.tenantid+ '/api/voyagemaster/getPortListByVoyage').success(function(data) {
	    		  $scope.podlist = data;
	   }).error(function(data) {
	    });
    $scope.$watch('voyageAdd.vessel', function(newValue,
			oldValue) {

		if (newValue != '' && newValue != undefined) {

			$http.get(
					$stateParams.tenantid
							+ '/api/voyagemaster/voyagelist?vessel='
							+ newValue).success(
					function(datas) {
						$scope.voyagelist = datas;

					}).error(function(data) {
				logger.logError("Unable to fetch");
			});
			console.log("inside the voyage",newValue);
			 $http.post($stateParams.tenantid+'/app/voyagemaster/getVoyage?vesselCode='+newValue).success(function(data) {
		        	if(data.success){
		        		console.log("data",data);
		        		$scope.voyagelist=data.voyageList;
		        	}else{
		        		logger.logError("Unable to fetch data");
		        	}
		        });

		}
	});
    $http.get($stateParams.tenantid+'/api/voyagemaster/vessellist').success(function(datas) {
        $scope.vessellist = datas;
    }).error(function(datas) {
    });
    
    $scope.getlist=function(){
        $http.get($stateParams.tenantid+'/api/voyagemaster/list').success(function(datas) {
            console.log(datas);
            $scope.rowCollection = datas;
        	
            }).error(function(datas) {
        });
        };
        $scope.getlist();
        
        $scope.search=function(voyageForm,voyageData){
			$http.post($stateParams.tenantid+'/api/voyagemaster/listSearch',$scope.voyageAdd).success(function(datas) {

                console.log(datas);
                $scope.rowCollection = datas;
            	
                }).error(function(datas) {
            });
            };
    $scope.add = function() {
        $state.go('app.master.voyage.add',{tenantid:$stateParams.tenantid});
    };
    
    
 // Redirecting Page For Edit Functionality
    $scope.editRow = function(voyageid) {
    	debugger
        $location.url($stateParams.tenantid+'/master/voyage/edit?voyageid='+voyageid);
    };
    
    $scope.view = function(voyageid) {
		$location.url($stateParams.tenantid + '/master/voyage/view?voyageid='+ voyageid);
	}
   
//    $scope.editRow = function(rowid) {   
//    	
//    	$location.url($stateParams.tenantid+'/master/containersize/edit?rowid='+rowid);    
//     }
//    
    $scope.deleteRow = function(voyageid) {
        ngDialog.openConfirm().then(function() {
        
            var url = $stateParams.tenantid+'/api/voyagemaster/delete?voyageid=' + voyageid;
            $http.get(url).success(function(result){
                if (result.isSuccess ==  true) {
                    logger.logSuccess("Deleted successfully");
                    $state.reload();
               } else {
                    logger.logError("You Can't Delete this Record, Related Data Exist! ");
                }
            }).error(function(result) {
                logger.logError("Error Please Try Again");
            });
        }, function(reason) {
            console.log('Modal promise rejected. Reason: ', reason);
        });
    };

  	//import Excel
  	        $scope.fileUpload = function() {
  	            ngDialog.close();
  	            ngDialog.open({
  	                template : 'fileModal',
  	                scope : $scope
  	            });
  	        };

  	        $rootScope.uploadFile = function(element) {
  	            
  	            console.log("excel file");
  	            $scope.excelfile = element.files[0];
  	            console.log($scope.excelfile);
  	        };
  	        
  	        $rootScope.closeFileDialog = function() {
  	            ngDialog.close();
  	        };
  	        
  	        $rootScope.uploadMaterialIssueRecord = function() {
  	            ngDialog.close();
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
  	                        url : $stateParams.tenantid+'/api/voyagemaster/uploadfile',
  	                        data : frmData,
  	                        contentType : false,
  	                        processData : false,
  	                        success : function(result) {
  	                            console.log("result");
  	                            console.log(result);
  	                            if (result.success) {
  	                                logger.logSuccess(result.totalCount + " Rows  Uploaded Successfully");
  	                                $scope.getlist();
  	                            } else {
  	                               var value = result.message;

  	                               if(value == "true")
 	                            	   logger.logSuccess("Uploaded successfully!");

  	                               else
  	 	                              logger.logError(value);
 
  	                            }

  	                        }

  	                    });
  	                }

  	            }
  	        };
   
});