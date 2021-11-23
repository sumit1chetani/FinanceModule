'use strict';
app.controller('permissionReqAddCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector,validationService, sharedProperties, toaster, $rootScope,$stateParams) {
	 
	$scope.permissionRequestData = {
		        permissiondate : '',
		        hoursfrom : '',
		        hoursto : '',
		        reason : '',
		        permissionrequestid : '',
		        userId : '',
		        userName : '',
		        edit : false
		    };
	$scope.isEdit = false;
	$scope.hoursChange='';
	
	
    $('#hoursform').datetimepicker({
   	 use24hours: true,
        format: 'HH:mm',
        pickDate: false,
   	 //use24hours: true
   })
    $('#hoursto').datetimepicker({
   	 use24hours: true,
        format: 'HH:mm',
        pickDate: false,
   	 //use24hours: true
   })
    $('#permissiondate').datetimepicker({
        format : 'DD/MM/YYYY'
    })
   
    //$scope.permissionRequestData.permissiondate = '';
    $scope.permissionRequestData.hoursfrom = '';
    $scope.permissionRequestData.hoursto = '';
    $scope.permissionRequestData.permissionrequestid = '';
    $scope.permissionRequestData.reason = '';
    $scope.permissionRequestData.shiftName = ''
    $scope.permissionRequestData.startTime = ''
    $scope.permissionRequestData.endTime = ''

    $scope.cancel = function() {
        $location.url($stateParams.tenantid+'/hr/permissionReq/list');
    };

    $scope.submit = function(permissionrequestForm) {

        $validationProvider.validate(permissionrequestForm).success($scope.success).error($scope.error);

    };

    // Injector
    var $validationProvider = $injector.get('$validation');

    $scope.error = function(message) {
        logger.logErrorHtml(sharedProperties.getErrorObject());
    };

    $scope.save = function(permissionRequestData, permissionrequestForm) {
        debugger
        if (new validationService().checkFormValidity($scope.permissionrequestForm)) {
            $http.post($stateParams.tenantid+"app/permissionrequest/add", $scope.permissionRequestData).success(function(result) {
                if (result) {
                    logger.logSuccess("Saved Successfully!");
                    $location.url($stateParams.tenantid+'/hr/permissionReq/list');
                    $scope.permissionRequestData.permissionrequestid=permissionrequestid;
                } else {
                    logger.logError("Permission Date Already Exist! / It Is HoliDay!");
                }
            });
        } else {
            toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(permissionrequestForm.$validationSummary), 5000, 'trustedHtml');
        }
    };

  

   
 
    var permissionrequestid = $location.search().permissionrequestid;
    if(permissionrequestid != undefined && permissionrequestid != ''){
        $scope.isEdit = true;
        $http.post($stateParams.tenantid+"app/permissionrequest/edit",permissionrequestid)
        .success(function(responsenew) {
           if(responsenew.success == true){
               $scope.permissionRequestData = responsenew;
               
               $scope.permissionRequestData.permissiondate = responsenew.permissiondate 
               $scope.permissionRequestData.hoursfrom = responsenew.hoursfrom
               $scope.permissionRequestData.hoursto = responsenew.hoursto
               $scope.permissionRequestData.reason = responsenew.reason
              
              // $scope.permissionRequestData.permissiondate = response.permissiondate;

           }else{
               if(response.message != ''){
                   logger.logError(response.message);
               }
           }
        });
    }
    
    
	if($scope.isEdit == false){
		$scope.employeeChange = function() {
	        $http.get($stateParams.tenantid+'/finance/leaverequest/getEmployeeDetails').success(function(response) {
	            debugger
	            $scope.permissionRequestData.userName = response.employeeDetailsList.empName;
	            $scope.permissionRequestData.userId = response.employeeDetailsList.empId;
	        });
		
	    }
		
	    $scope.employeeChange();
	}
    
    
    $scope.getShiftDetails = function() {
        debugger
        var restultbeannew = {
            permissiondate : $scope.permissionRequestData.permissiondate,
            userId : $scope.permissionRequestData.userId
        }
        $http.post($stateParams.tenantid+"app/permissionrequest/getEmployeeDetails", restultbeannew).success(function(response) {
            if (response.lpermissionRequestBean.length >= 1) {
                debugger
                $scope.permissionRequestData.shiftName = response.lpermissionRequestBean[0].shiftName;
                $scope.permissionRequestData.startTime = response.lpermissionRequestBean[0].startTime;
                $scope.permissionRequestData.endTime = response.lpermissionRequestBean[0].endTime;
            } else {
                $scope.permissionRequestData.shiftName = '';
                $scope.permissionRequestData.startTime = '';
                $scope.permissionRequestData.endTime = '';
                $scope.permissionRequestData.permissiondate = '';
                logger.logError("Shift is not allocated for the selected date");
                $scope.permissionRequestData.permissiondate = '';
            }

        });
    }

    /*$scope.$watch('permissionRequestData.permissiondate', function(newValue, oldValue) {
        if (newValue != "") {
            if ($scope.permissionRequestData.permissiondate != '' && $scope.permissionRequestData.permissiondate != null && $scope.permissionRequestData.permissiondate != undefined) {
                $scope.getShiftDetails();

            }
        }

    });
*/
    $scope.hoursChange = function(hoursfrom, hoursto) {
        debugger
        if (hoursfrom != undefined && hoursfrom != null && hoursfrom != '' && hoursto != undefined && hoursto != null && hoursto != '') {
            if ($scope.permissionRequestData.permissiondate != '' && $scope.permissionRequestData.permissiondate != null && $scope.permissionRequestData.permissiondate != undefined) {
                var startTime = hoursfrom;
                var endTime = hoursto;
                startTime = startTime.split(":");
                startTime = parseInt(startTime[0] + startTime[1]);
                endTime = endTime.split(":");
                endTime = parseInt(endTime[0] + endTime[1]);
                var shiftStarttime = $scope.permissionRequestData.startTime;
                shiftStarttime = shiftStarttime.split(":");
                shiftStarttime = parseInt(shiftStarttime[0] + shiftStarttime[1]);
                var shiftEndtime = $scope.permissionRequestData.endTime;
                shiftEndtime = shiftEndtime.split(":");
                shiftEndtime = parseInt(shiftEndtime[0] + shiftEndtime[1]);
                if (shiftStarttime >= 1200 && shiftEndtime <= 1200) {
                    if (startTime >= shiftStarttime || (startTime <= shiftEndtime && startTime > 0)) {
                        if (endTime >= shiftStarttime || (endTime <= shiftEndtime && endTime > 0)) {
                            if (startTime <= 1200 && endTime <= 1200) {
                                if ((endTime <= startTime)) {
                                    $scope.permissionRequestData.hoursto = '';
                                    logger.logError("Hours To Should be greater than Hours From!");
                                }
                            }
                            if (startTime >= 1200 && endTime >= 1200) {
                                if ((endTime <= startTime)) {
                                    $scope.permissionRequestData.hoursto = '';
                                    logger.logError("Hours To Should be greater than Hours From!");
                                }
                            }
                        } else {
                            $scope.permissionRequestData.hoursto = '';
                            $scope.permissionRequestData.hoursfrom = '';
                            logger.logError("Please Select Valid Hours From/Hours To");
                        }
                    } else {
                        $scope.permissionRequestData.hoursto = '';
                        $scope.permissionRequestData.hoursfrom = '';
                        logger.logError("Please Select Valid Hours From/Hours To!");
                    }

                } else if (shiftStarttime >= 1200 && shiftEndtime >= 1200) {
                    if (startTime >= shiftStarttime && startTime <= shiftEndtime && endTime >= shiftStarttime && endTime <= shiftEndtime) {
                        if ((endTime <= startTime)) {
                            $scope.permissionRequestData.hoursto = "";
                            logger.logError("Hours To Should be greater than Hours From!");
                        }
                    } else {
                        logger.logError("Please Select Valid Hours From/Hours To!");
                        $scope.permissionRequestData.hoursto = '';
                        $scope.permissionRequestData.hoursfrom = '';
                    }
                } else {
                    if (startTime >= shiftStarttime && startTime <= shiftEndtime && endTime >= shiftStarttime && endTime <= shiftEndtime) {
                        if ((endTime <= startTime)) {
                            $scope.permissionRequestData.hoursto = "";
                            logger.logError("Hours To Should be greater than Hours From!");
                        }
                    } else {
                        logger.logError("Please Select Valid Start Time/End Time!");
                        $scope.permissionRequestData.hoursto = '';
                        $scope.permissionRequestData.hoursfrom = '';
                    }
                }
            } else {
                logger.logError("Please Select Permission Date!");
                $scope.permissionRequestData.hoursto = '';
                $scope.permissionRequestData.hoursfrom = '';

            }
        }
    }

    // Save
    $scope.update = function(permissionRequestData, permissionrequestForm) {
        sharedProperties.clearObject();
        var permissionRequestData = $scope.permissionRequestData;
        if ($scope.permissionRequestData.edit == true) {
            var updateRowData = permissionRequestData;
            if (new validationService().checkFormValidity(permissionrequestForm)) {
                $http.post($stateParams.tenantid+'app/permissionrequest/update', updateRowData).success(function(result) {
                    if (result) {
                        logger.logSuccess("Updated Successfully!");
                        $location.url($stateParams.tenantid+'/hr/permissionReq/list');
                    } else {
                        logger.logError("Permission Date already Exist! / It Is HoliDay!");
                    }
                }).error(function(result) {
                });
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(permissionrequestForm.$validationSummary), 5000, 'trustedHtml');
            }
        }
    };
    $scope.isEdit = false;
    var permissionrequestid = $location.search().permissionrequestid;
    if(permissionrequestid != undefined && permissionrequestid != ''){
        $scope.isEdit = true;
        $http.post($stateParams.tenantid+"app/permissionrequest/edit",permissionrequestid)
        .success(function(response) {
           if(response.success == true){
               $scope.permissionRequestData = response.permissionRequestData;
           }else{
               if(response.message != ''){
                   logger.logError(response.message);
               }
           }
        });
    }

    $scope.reset = function() {
        $scope.permissionRequestData.hoursfrom = '';
        $scope.permissionRequestData.hoursto = '';
        $scope.permissionRequestData.reason = '';
        $scope.permissionRequestData.permissiondate = '';
        if (permissionrequestid != 0) {
            $scope.permissionRequestData.edit = true;
            $http.post($stateParams.tenantid+"app/permissionrequest/edit", permissionrequestid).success(function(result) {
                if (result.success == true) {
                    $scope.permissionRequestData.permissionrequestid = result.permissionrequestid;
                    $scope.permissionRequestData.hoursfrom = result.hoursfrom;
                    $scope.permissionRequestData.hoursto = result.hoursto;
                    $scope.permissionRequestData.permissiondate = result.permissiondate;
                    $scope.permissionRequestData.reason = result.reason;
                    $scope.permissionRequestData.edit = result.edit;
                }
            });
        }
    };

});

