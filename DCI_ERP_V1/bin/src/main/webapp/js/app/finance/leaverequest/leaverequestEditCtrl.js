'use strict';
  

app.controller('leaverequestEditCtrl', function($scope, $rootScope, $http, $location, logger, ngDialog,utilsService,$state,
		sharedProperties,$window,$stateParams ,validationService) {
	var requestId = $stateParams.requestId;
        $scope.leaveRequestObj = {
            company : '',
            branch : '',
            grade : '',
            department : '',
            empName : '',
            empId : '',
            leaveType : '',
            leaveRadio : true,
            holidayRadio : '',
            fromDate : '',
            toDate : '',
            noOfDays : '',
            leaveReason : '',
            leaveAddress : '',
            leavePhone : '',
            leaveMobile : '',
            appliedOn : '',
            halfFrom : '',
            halfTo : '',
            mdUrl : '',
            isHoliday : '',
            year : '',
            addressDuringLeave : '',
            leaveRequestId:''
            

        };


        $scope.leaveRequestObj.leaveRadio = false;
        $scope.leaveRequestObj.isEdit = true;

        $scope.leaveList = [];
        $scope.holidayList = [];
        $scope.years = [];
        $scope.employeeChange = function() {
            $http.get($stateParams.tenantid+'/finance/leaverequest/getEmployeeDetails').success(function(response) {
                $scope.leaveRequestObj.empName = response.employeeDetailsList.empName;
                $scope.leaveRequestObj.empId = response.employeeDetailsList.empId;
                $scope.leaveRequestObj.company = response.employeeDetailsList.company;
                $scope.leaveRequestObj.branch = response.employeeDetailsList.branch;
                $scope.leaveRequestObj.grade = response.employeeDetailsList.grade;
                $scope.leaveRequestObj.department = response.employeeDetailsList.department;
            });

        }

        $scope.addyear = function() {

            for (var i = 2000; i <= 2020; i++) {
                $scope.years.push(i);
            }
        }
        $scope.addyear();

        $scope.cancel = function() {

            $state.go('app.hr.leaverequest.list',{tenantid:$stateParams.tenantid});
        }
        $scope.holiday = function() {

            var url = '/hr/leaverequest/holidaylist';

            $http.get(url).success(function(datas) {
                $scope.holidayList = datas.holidayList;

            });
        }

        $scope.modify = function(index, leaveList) {
            debugger

            for (var i = 0; i < leaveList.length; i++) {
                if (i === index) {
                    leaveList[i].selctRow = true;
                    leaveList[i].select = true;
                } else {
                    leaveList[i].selctRow = false;
                    leaveList[i].select = false;
                }
            }
        }

        $scope.holidaymodify = function(index, holidayList) {

            for (var i = 0; i < holidayList.length; i++) {
                if (i === index) {
                    holidayList[i].selctRow = true;
                    holidayList[i].select = true;
                } else {
                    holidayList[i].selctRow = false;
                    holidayList[i].select = false;
                }
            }

        }
         $scope.isEdit = false;
        var leaveRequestId = $location.search(). leaveRequestId;
        if(leaveRequestId != undefined && leaveRequestId != ''){
            $scope.isEdit = true;
            $http.post($stateParams.tenantid+"/finance/leaverequest/getEditList",leaveRequestId)
            .success(function(response) {
               if(response){
            	   
                   $scope.leaveRequestObj = response;
                   $scope.leaveRequestObj.leaveMobile = response.leaveMobile;

                   $scope.leaveRequestObj.leavePhone = response.leavePhone;
                   $scope.leaveRequestObj.appliedOn = response.appliedOn;
                   $scope.leaveRequestObj.reason = response.reason;
                   $scope.leaveRequestObj.halfFrom = response.halfFrom;
                   $scope.leaveRequestObj.halfTo = response.halfTo;
                   $scope.leaveRequestObj.leaveReason = response.leaveReason
                   $scope.leaveRequestObj.leaveAddress = response.leaveAddress
                   $scope.leaveRequestObj.noOfDays = response.noOfDays;
                   $scope.leaveRequestObj.leaveRequestId = response.leaveRequestId;
                   $scope.leaveRequestObj.isHoliday = response.isHoliday
                   $scope.leaveRequestObj.empId = response.empId;
                   $scope.leaveRequestObj.leaveType = response.leaveType;
                   $scope.employeeChange();

                   $scope.leaveRequestObj.leaveRadio = response.isHoliday;
                   if ($scope.leaveRequestObj.leaveRadio == false) {
                       debugger
                      
                       $scope.leavechange = function() {
                           debugger

                           var url = $stateParams.tenantid+'/finance/leaverequest/leavelist';

                           $http.get(url).success(function(datas) {
                               $scope.leaveList = datas.leaveList;
                               for (var i = 0; i < $scope.leaveList.length; i++) {
                                   if ($scope.leaveRequestObj.empId == $scope.leaveList[i].empId && $scope.leaveRequestObj.leaveType == $scope.leaveList[i].shortName) {
                                       $scope.leaveList[i].select = true;
                                       $scope.leaveList[i].selctRow = true;
                                   } else {
                                       $scope.leaveList[i].select = false;
                                       $scope.leaveList[i].selctRow = false;
                                   }

                               }
                               document.getElementById('holidayRadio').disabled = true;

                           });
                       }
                       $scope.leavechange();

                   }
                   
                   else {

                       $scope.holiday = function() {

                           var url = $stateParams.tenantid+'/finance/leaverequest/holidaylist?isEdit=' + $scope.isEdit;

                           $http.post(url).success(function(datas) {
                               $scope.holidayList = datas.holidayList;
                               for (var i = 0; i < $scope.holidayList.length; i++) {
                                   if ($scope.leaveRequestObj.empId == $scope.holidayList[i].empId && $scope.leaveRequestObj.leaveRequestId == $scope.holidayList[i].leaveId) {
                                       $scope.holidayList[i].select = true;
                                       $scope.holidayList[i].selctRow = true;
                                   } else {
                                       $scope.holidayList[i].select = false;
                                       $scope.holidayList[i].selctRow = false;
                                   }
                               }
                               document.getElementById('leaveRadio').disabled = true;
                           });
                       }

                       $scope.holiday();

                   }
               }else{
                   if(response.message != ''){
                       logger.logError(response.message);
                   }
               }
            });
        }

        
        
     /*   var url = $stateParams.tenantid+'/finance/leaverequest/edit?leaveRequestId=' +$scope.leaveRequestObj.leaveRequestId;
        $http.get(url).success(function(result) {
            debugger
            alert("Leae List");
            $scope.leaveRequestObj.fromDate = result.fromDate;
            $scope.        $scope.employeeChange();
leaveRequestObj.toDate = result.toDate;
            $scope.leaveRequestObj.leaveMobile = result.leaveMobile;

            $scope.leaveRequestObj.leavePhone = result.leavePhone;
            $scope.leaveRequestObj.appliedOn = result.appliedOn;
            $scope.leaveRequestObj.reason = result.reason;
            $scope.leaveRequestObj.halfFrom = result.halfFrom;
            $scope.leaveRequestObj.halfTo = result.halfTo;
            $scope.leaveRequestObj.leaveReason = result.leaveReason
            $scope.leaveRequestObj.leaveAddress = result.leaveAddress
            $scope.leaveRequestObj.noOfDays = result.noOfDays;
            $scope.leaveRequestObj.leaveRequestId = result.leaveRequestId;
            $scope.leaveRequestObj.isHoliday = result.isHoliday
            $scope.leaveRequestObj.empId = result.empId;
            $scope.leaveRequestObj.leaveType = result.leaveType;

            $scope.employeeChange();

            $scope.leaveRequestObj.leaveRadio = result.isHoliday;
            if ($scope.leaveRequestObj.leaveRadio == false) {
                debugger
               
                $scope.leavechange = function() {
                    debugger

                    var url = $stateParams.tenantid+'/finance/leaverequest/leavelist';

                    $http.get(url).success(function(datas) {
                        $scope.leaveList = datas.leaveList;
                        for (var i = 0; i < $scope.leaveList.length; i++) {
                            if ($scope.leaveRequestObj.empId == $scope.leaveList[i].empId && $scope.leaveRequestObj.leaveType == $scope.leaveList[i].shortName) {
                                $scope.leaveList[i].select = true;
                                $scope.leaveList[i].selctRow = true;
                            } else {
                                $scope.leaveList[i].select = false;
                                $scope.leaveList[i].selctRow = false;
                            }

                        }
                        document.getElementById('holidayRadio').disabled = true;

                    });
                }
                $scope.leavechange();

            }

            else {

                $scope.holiday = function() {

                    var url = $stateParams.tenantid+'/finance/leaverequest/holidaylist?isEdit=' + $scope.leaveRequestObj.isEdit;

                    $http.post(url).success(function(datas) {
                        $scope.holidayList = datas.holidayList;
                        for (var i = 0; i < $scope.holidayList.length; i++) {
                            if ($scope.leaveRequestObj.empId == $scope.holidayList[i].empId && $scope.leaveRequestObj.leaveRequestId == $scope.holidayList[i].leaveId) {
                                $scope.holidayList[i].select = true;
                                $scope.holidayList[i].selctRow = true;
                            } else {
                                $scope.holidayList[i].select = false;
                                $scope.holidayList[i].selctRow = false;
                            }
                        }
                        document.getElementById('leaveRadio').disabled = true;
                    });
                }

                $scope.holiday();

            }
        });*/

        $scope.update = function(leaveReqAddForm) {
            debugger
            var falg1 = true;
            var falg2 = true;
            if (new validationService().checkFormValidity(leaveReqAddForm)) {
                var balanceLeave;
                var selectedLeaveRow;

                for (var i = 0; i < $scope.leaveList.length; i++) {
                    if ($scope.leaveList[i].selctRow == true) {
                        selectedLeaveRow = $scope.leaveList[i].selctRow;
                        balanceLeave = $scope.leaveList[i].balance;
                    }
                }

                var selectedholidayRow;
                for (var i = 0; i < $scope.holidayList.length; i++) {
                    if ($scope.holidayList[i].selctRow == true) {
                        selectedholidayRow = $scope.holidayList[i].selctRow;
                    }
                }

                var frmDate = $scope.leaveRequestObj.fromDate;
                var toDate = $scope.leaveRequestObj.toDate;
                frmDate = frmDate.split("/");
                frmDate = new Date(frmDate[2], frmDate[1], frmDate[0]);
                toDate = toDate.split("/");
                toDate = new Date(toDate[2], toDate[1], toDate[0]);

                if ($scope.leaveRequestObj.leaveRadio === false) {
                    var savedata = $scope.leaveRequestObj;
                    var data = {
                        'leaveList' : $scope.leaveList,
                        'leaveObj' : savedata
                    }

                   // if (selectedLeaveRow == true) {
                       // if ($scope.leaveRequestObj.noOfDays <= balanceLeave) {
                            if ($scope.leaveRequestObj.fromDate != "" && $scope.leaveRequestObj.toDate != "") {
                                if (frmDate <= toDate) {

                                    if ($scope.leaveRequestObj.leaveMobile != undefined && $scope.leaveRequestObj.leaveMobile != null && $scope.leaveRequestObj.leaveMobile != '') {
                                        if ($scope.leaveRequestObj.leaveMobile.length != 10) {
                                            falg1 = false;
                                        }
                                    }
                                    if ($scope.leaveRequestObj.leavePhone != undefined && $scope.leaveRequestObj.leavePhone != null && $scope.leaveRequestObj.leavePhone != '') {
                                        if ($scope.leaveRequestObj.leavePhone.length != 10) {
                                            falg2 = false;
                                        }
                                    }

                                    if (falg1 == true && falg2 == true) {

                                        $http.post($stateParams.tenantid+'/finance/leaverequest/update', data).success(function(response) {
                                            if (response.success == true) {
                                                logger.logSuccess(response.message);
                                                $state.go('app.hr.leaverequest.list',{tenantid:$stateParams.tenantid});
                                            } else {
                                                logger.logError(response.message);
                                            }

                                        }).error(function(result) {
                                        });
                                    } else {
                                        if (falg1 == false) {
                                            logger.logError("Mobile Number should be equval to 10 digit");

                                        }
                                        if (falg2 == false) {
                                            logger.logError("Contact Number should be equval to 10 digit");

                                        }
                                    }
                                } else {
                                    logger.logError("From Date Should be greater than To Date");
                                }

                            } else {
                                logger.logError("Please choose the From Date and To Date");
                            }
                       /* } else {
                            logger.logError("No. of days Should be greater than Leave Balance ");
                        }*/
                    /*} else {
                        logger.logError("Please choose anyone 'Leave Name' from the table");
                    }*/

                }

                if ($scope.leaveRequestObj.leaveRadio === true) {

                    var savedata = $scope.leaveRequestObj;
                    var data = savedata;
                    var data = {
                        'holidayList' : $scope.holidayList,
                        'leaveObj' : savedata
                    }

                    if (selectedholidayRow == true) {
                        if ($scope.leaveRequestObj.fromDate != "" && $scope.leaveRequestObj.toDate != "") {
                            if (frmDate <= toDate) {

                                if ($scope.leaveRequestObj.leaveMobile != undefined && $scope.leaveRequestObj.leaveMobile != null && $scope.leaveRequestObj.leaveMobile != '') {
                                    if ($scope.leaveRequestObj.leaveMobile.length != 10) {
                                        falg1 = false;
                                    }
                                }
                                if ($scope.leaveRequestObj.leavePhone != undefined && $scope.leaveRequestObj.leavePhone != null && $scope.leaveRequestObj.leavePhone != '') {
                                    if ($scope.leaveRequestObj.leavePhone.length != 10) {
                                        falg2 = false;
                                    }
                                }

                                if (falg1 == true && falg2 == true) {
                                    $http.post($stateParams.tenantid+'/hr/leaverequest/update', data).success(function(response) {
                                        if (response.success == true) {
                                            logger.logSuccess("Update Successfully!");
                                            $state.go('app.hr.leaverequest.list',{tenantid:$stateParams.tenantid});
                                        } else {
                                            logger.logError("Request already Exists!");
                                        }
                                    })

                                } else {
                                    if (falg1 == false) {
                                        logger.logError("Mobile Number should be equval to 10 digit");

                                    }
                                    if (falg2 == false) {
                                        logger.logError("Contact Number should be equval to 10 digit");

                                    }
                                }

                            } else {
                                logger.logError("From Date Should be greater than To Date");
                            }

                        } else {
                            logger.logError("Please choose the From Date and To Date");
                        }
                    } else {
                        logger.logError("Please choose anyone 'Holiday Worked' from the table");
                    }
                }
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(leaveReqAddForm.$validationSummary), 5000, 'trustedHtml');
            }
        }

        $scope.$watchCollection('[ leaveRequestObj.fromDate,leaveRequestObj.toDate,$scope.leaveRequestObj.halfFrom,$scope.leaveRequestObj.halfTo]', function(newValues) {

            $scope.changedate($scope.leaveRequestObj.halfFrom, $scope.leaveRequestObj.fromDate, $scope.leaveRequestObj.toDate, $scope.leaveRequestObj.halfTo);

        });

        $scope.changedate = function(halffrom, fromdate, todate, halfto) {

            var dt1 = fromdate.split('/'), dt2 = todate.split('/'), one = new Date(dt1[2], dt1[1] - 1, dt1[0]), two = new Date(dt2[2], dt2[1] - 1, dt2[0]);

            var millisecondsPerDay = 1000 * 60 * 60 * 24;
            var millisBetween = two.getTime() - one.getTime();
            var days = millisBetween / millisecondsPerDay;

            if ($scope.leaveRequestObj.leaveRadio == true) {

                if ($scope.leaveRequestObj.toDate != "") {
                    if (days == 0 && halffrom == 1 && halfto == 2) {
                        $scope.leaveRequestObj.noOfDays = 1;
                    } else {
                        $scope.leaveRequestObj.noOfDays = '';
                        $scope.leaveRequestObj.toDate = "";
                        $scope.leaveRequestObj.halfTo = "";
                        logger.logError("From Date and To Date must be same");
                    }
                }

            } else {
                if (halffrom == 1 && halfto == 1) {
                    days = days + 0.5;
                    $scope.leaveRequestObj.noOfDays = days;
                }
                if (halffrom == 1 && halfto == 2) {
                    days = days + 1;
                    $scope.leaveRequestObj.noOfDays = days;
                }
                if (halffrom == 2 && halfto == 1) {
                    days = days;
                    $scope.leaveRequestObj.noOfDays = days;
                }
                if (halffrom == 2 && halfto == 2) {
                    days = days + 0.5;
                    $scope.leaveRequestObj.noOfDays = days;
                }
            }

        }

        // on change date
        $scope.change = function(leaveRequestObj) {

            var fDate = $scope.leaveRequestObj.fromDate
            var tDate = $scope.leaveRequestObj.toDate;
            var dt1 = $scope.leaveRequestObj.fromDate.split('/'), dt2 = $scope.leaveRequestObj.toDate.split('/'), one = new Date(dt1[2], dt1[1] - 1, dt1[0]), two = new Date(dt2[2], dt2[1] - 1, dt2[0]);
            var millisecondsPerDay = 1000 * 60 * 60 * 24;
            var millisBetween = two.getTime() - one.getTime();
            var days = millisBetween / millisecondsPerDay;

            if ($scope.leaveRequestObj.leaveRadio == true) {
                if ($scope.leaveRequestObj.halfTo != "") {
                    if ($scope.leaveRequestObj.halfFrom == 1 && $scope.leaveRequestObj.halfTo == 2) {
                        if ($scope.leaveRequestObj.toDate != "") {
                            $scope.leaveRequestObj.noOfDays = 1;
                        }
                    } else {
                        $scope.leaveRequestObj.noOfDays = '';
                        $scope.leaveRequestObj.toDate = "";
                        $scope.leaveRequestObj.halfTo = "";
                        logger.logError("Can't choose 'Second Half' in 'Request From' and 'First Half' in 'Request To' for Holiday Leave");
                    }
                }

            } else {
                if ($scope.leaveRequestObj.halfFrom == 1 && $scope.leaveRequestObj.halfTo == 1) {
                    days = days + 0.5;
                    $scope.leaveRequestObj.noOfDays = days;
                }
                if ($scope.leaveRequestObj.halfFrom == 1 && $scope.leaveRequestObj.halfTo == 2) {
                    days = days + 1;
                    $scope.leaveRequestObj.noOfDays = days;

                }

                if ($scope.leaveRequestObj.halfFrom == 2 && $scope.leaveRequestObj.halfTo == 1) {

                    days = days;
                    $scope.leaveRequestObj.noOfDays = days;

                }

                if ($scope.leaveRequestObj.halfFrom == 2 && $scope.leaveRequestObj.halfTo == 2) {

                    days = days + 0.5;
                    $scope.leaveRequestObj.noOfDays = days;

                }
            }

        }

        $scope.reset = function() {

            $scope.leaveRequestObj.fromDate = ''
            $scope.leaveRequestObj.toDate = ''
            $scope.leaveRequestObj.noOfDays = ''
            $scope.leaveRequestObj.leaveReason = ''
            $scope.leaveRequestObj.leaveAddress = ''
            $scope.leaveRequestObj.leavePhone = ''
            $scope.leaveRequestObj.leaveMobile = ''
            // $scope.leaveRequestObj. appliedOn=''
            $scope.leaveRequestObj.halfFrom = ''
            $scope.leaveRequestObj.halfTo = ''
            $scope.leaveRequestObj.year = ''

            var url = $stateParams.tenantid+'/finance/leaverequest/getEditList?requestId=' + requestId;
            $http.get(url).success(function(result) {
                $scope.leaveRequestObj.fromDate = result.fromDate;
                $scope.leaveRequestObj.toDate = result.toDate;
                $scope.leaveRequestObj.leaveMobile = result.leaveMobile;
                $scope.leaveRequestObj.leavePhone = result.leavePhone;
                $scope.leaveRequestObj.appliedOn = result.appliedOn;
                $scope.leaveRequestObj.reason = result.reason;
                $scope.leaveRequestObj.halfFrom = result.halfFrom;
                $scope.leaveRequestObj.halfTo = result.halfTo;
                $scope.leaveRequestObj.leaveReason = result.leaveReason
                $scope.leaveRequestObj.leaveAddress = result.leaveAddress
                $scope.leaveRequestObj.leaveRadio = result.isHoliday;
                $scope.leaveRequestObj.noOfDays = result.noOfDays;
            });
        }

    });

app.controller('phonenumbersOnly', function(logger) {
        return {
            require : 'ngModel',
            link : function(scope, element, attrs, modelCtrl) {

                modelCtrl.$parsers.push(function(inputValue) {
                    var inputValue = modelCtrl.$viewValue;
                    if (inputValue == undefined)
                        return ''
                    var transformedInput = inputValue.replace(/[^0-9]/g, '');
                    if (transformedInput != inputValue) {
                        modelCtrl.$setViewValue(transformedInput);
                        modelCtrl.$render();
                    } else {

                    }

                    return transformedInput;
                });
            }
        };
    });
