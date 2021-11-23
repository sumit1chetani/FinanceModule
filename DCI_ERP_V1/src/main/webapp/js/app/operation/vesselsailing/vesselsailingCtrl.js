'use strict';
app.controller('vesselSailingCtrl', function($scope,$stateParams, $rootScope, $http, $location, logger, utilsService,$state,sharedProperties,$window,ngDialog) {

        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.hideUploadIcon = true;
       
        $scope.emptyObject={};
        $scope.add = function() {
            $state.go('app.operation.vesselsailing.add',{tenantid:$stateParams.tenantid});    
        };
        
        // Redirecting Page For Edit Functionality
        $scope.editRow = function(vessel) {
        	debugger
            $location.url($stateParams.tenantid+'/operation/vesselsailing/edit?vesselSailingId='+vessel);
        };
        
        $scope.View = function(vessel) {
        	debugger
            $location.url($stateParams.tenantid+'/operation/vesselsailing/view?vesselSailingId='+vessel);
        };
        
        $scope.getList = function() {
         
            var url = $stateParams.tenantid+'/api/vesselsailing/list';
            $http.get(url).success(function(data) {
                if (data.length > 0) {
                	angular.forEach(data, function(row, index) { 

            			if(row.mode != null && row.mode != ''){
            				 
            			    if(row.mode==1){
            					row.mode = "SEA COASTAL";
            		    }else  if(row.mode==2){
            					row.mode = "SEA FOREIGN";
            		    }else  if(row.mode==3){
            					row.mode = "TRUCK";
            		    }else  if(row.mode==4){
            					row.mode = "LINER";
            		    }else  if(row.mode==5){
            					row.mode = "FORWARDING";
            		    }
            		}
            			})
                    $scope.rowCollection = $scope.rowCollection.concat(data);
                    sharedProperties.setObject($scope.emptyObject);
                }
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
            $scope.offsetCount = $scope.offsetCount + $scope.limitCount;
        };

        $scope.getList();
        
      

/**
 * Delete Row
 */
$scope.deleteRow = function(vessel) {
    ngDialog.openConfirm().then(function() {
    
        var url = $stateParams.tenantid+'/api/vesselsailing/delete?vessel=' + vessel;
        $http.get(url).success(function(result){
            if (result.isSuccess ==  true) {
                logger.logSuccess("Deleted Successfully");
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

$scope.view = function(deptCode) {
	$location.url($stateParams.tenantid+'/vesselsailing/view?deptCode='+deptCode); 
 }



$scope.getReport = function(voyagecost) {

	var chk=false;
if(voyagecost.voyage!=undefined && voyagecost.voyage!=''){
	if(voyagecost.vessel!=undefined && voyagecost.vessel!=''){
		chk=true;
	
	}
	}
	if(chk){
	$http.post($stateParams.tenantid + '/app/voyagecosting/getVoyageCosting',
			voyagecost).success(function(datas) {

			if (datas.success) {
				$("#GLExport").bind('click', function() {
				});
				$('#GLExport').simulateClick('click');

			} else {
				logger.logError("No Record Found");

			}

		}).error(function(datas) {

		});
	
	}
	else 
		{
		
		logger.logError("Please select Vessel and Voyage");
		}

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
	
	 //send mail
    $scope.sendMail = function(value) {

            $http.post($stateParams.tenantid+'/api/vesselsailing/sendmail', value).success(function(result) {
                console.log("result" + result);
                if (result.isSuccess) {
                    logger.logSuccess(result.message);     
                } else {
                    logger.logError(result.message);
                    
                    
                }
            }).error(function(result) {
                console.log("data" + result);
                
            });    
    };

	//Excel Export	
 	 $scope.getReport = function(value){
 	   	 $http.post($stateParams.tenantid+'/api/vesselsailing/getVoyageCosting', value).success(function(response) {

 	                if(response.Success){
 	                    debugger;
 	                    $("#vesselsailingsave").bind('click', function() {
 	                    });
 	                    $('#vesselsailingsave').simulateClick('click');
 	                    logger.logSuccess("Exported successfully!");
 	                }else{
 	                    logger.logError("Failed to export");
 	                }
 	                
 	            }).error(function(response) {
 	                logger.logError("Error Please Try Again");
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


 	  //print
     $scope.printsailingportDiv = function(voyage,port){
         console.log("print")
          var url = $stateParams.tenantid+'/api/vesselsailing/print?voyage='+voyage+'&port='+port;
         var wnd = window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
         wnd.print();
    
      }
     
     
    });

