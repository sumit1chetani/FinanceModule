
    'use strict';

    app.controller('manageshiftAddCtrl', function($scope, $state, $http, ngDialog, $stateParams ,logger, $location, $controller,
    		 $log,  $modal, $window,$injector, sharedProperties, toaster, $rootScope, validationService) {

        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages = 0

        
        $('#thresholdTime').datetimepicker({
       	 use24hours: true,
            format: 'HH:mm',
            pickDate: false,
       	 //use24hours: true
       })
       $('#startTime').datetimepicker({
         	 use24hours: true,
              format: 'HH:mm',
              pickDate: false,
         	 //use24hours: true
         })
        
        
        $('#endTime').datetimepicker({
        	 use24hours: true,
             format: 'HH:mm',
             pickDate: false,
        	 //use24hours: true
        })
        
        
        
        $('#breakStartTime').datetimepicker({
       	 use24hours: true,
            format: 'HH:mm',
            pickDate: false,
       	 //use24hours: true
       })
       
      
       
       $('#breakEndTime').datetimepicker({
      	 use24hours: true,
           format: 'HH:mm',
           pickDate: false,
      	 //use24hours: true
      })
      
      
      
      $('#lateAfter').datetimepicker({
     	 use24hours: true,
          format: 'HH:mm',
          pickDate: false,
     	 //use24hours: true
     })
     $('#earlyExit').datetimepicker({
     	 use24hours: true,
          format: 'HH:mm',
          pickDate: false,
     	 //use24hours: true
     })
        $scope.cancel = function() {
            $state.go("app.hr.manageshift.list",{tenantid:$stateParams.tenantid});

        };

        $('#shiftValue').show();
        $('#shiftCodeReadOnly').hide();
        $('#shiftNameValue').show();
        $('#shiftNameReadOnly').hide();

        $scope.reset = function(shiftMasterAddForm) {
            $scope.shiftMasterobj.shiftName = '';
            $scope.shiftMasterobj.shiftCode = '';
            $scope.shiftMasterobj.description = '';
            $scope.shiftMasterobj.effectFromDate = '', $scope.shiftMasterobj.startTime = '', $scope.shiftMasterobj.endTime = '', $scope.shiftMasterobj.breakStartTime = '', $scope.shiftMasterobj.breakEndTime = '', $scope.shiftMasterobj.nightShift = 'Y', $scope.shiftMasterobj.lateAfter = '', $scope.shiftMasterobj.earlyExit = ''
            $scope.shiftMasterobj.noOfTimeAllowed = '', $scope.shiftMasterobj.halfDay = '', $scope.shiftMasterobj.fullDay = ''
        };

        $scope.shiftMasterobj = {
            shiftId : 0,
            shiftName : '',
            shiftCode : '',
            description : '',
            effectFromDate : '',
            startTime : '',
            endTime : '',
            breakStartTime : '',
            breakEndTime : '',
            thresholdTime : '',
            nightShift : 'N',
            lateAfter : '',
            earlyExit : '',
            noOfTimeAllowed : '',
            halfDay : '',
            fullDay : ''
        };

        $scope.shiftMasterobjClear = {};

        $scope.shiftMasterValidateData = {
            isEdit : false,
            sMEdit : false
        };

        var currentDate = new Date();

        currentDate = ('0' + currentDate.getDate()).slice(-2) + "/" + ('0' + (Number(currentDate.getMonth()) + 1)).slice(-2) + "/" + currentDate.getFullYear();

        $scope.shiftMasterobj.effectFromDate = currentDate;
        var currentDate1 = currentDate;

        $scope.$watch('shiftMasterobj.effectFromDate', function(newVal, oldVal) {

            newVal = newVal.split("/");
            newVal = new Date(newVal[2], newVal[1], newVal[0]);
            oldVal = currentDate1.split("/");
            oldVal = new Date(oldVal[2], oldVal[1], oldVal[0]);

            if (newVal < oldVal) {
                $scope.shiftMasterobj.effectFromDate = currentDate;
                logger.logError("Cannot able to choose Previous Date");
            }
        });

        $scope.time = function() {

            $scope.shiftMasterobj.startTime = '';
            $scope.shiftMasterobj.endTime = '';
            $scope.shiftMasterobj.breakStartTime = '';
            $scope.shiftMasterobj.breakEndTime = '';
            $scope.shiftMasterobj.lateAfter = '';
            $scope.shiftMasterobj.earlyExit = '';

        };

        $scope.$watchCollection('[ shiftMasterobj.startTime,shiftMasterobj.endTime]', function(newValues) {

            $scope.timeChange($scope.shiftMasterobj.startTime, $scope.shiftMasterobj.endTime);

        });

        $scope.timeChange = function(strtTime, edTime) {
            if (strtTime != "" && edTime != "") {
                var startTime = strtTime;
                var endTime = edTime;

                // var date1 = Date.parse('01/01/1970 ' + startTime + ':00')
                // var date2 = Date.parse('01/01/1970 ' + endTime + ':00')

                startTime = startTime.split(":");
                startTime = parseInt(startTime[0] + startTime[1]);
                endTime = endTime.split(":");
                endTime = parseInt(endTime[0] + endTime[1]);

                if ($scope.shiftMasterobj.nightShift == 'N') {

                    if ((startTime < endTime)) {
                    } else {
                        $scope.shiftMasterobj.endTime = "";
                        logger.logError("End Time should be greater than Start Time");
                    }
                } else {
                    if ((startTime >= 1800) && (startTime < 2359)) {
                        if ((startTime <= endTime) || ((startTime - endTime) < 800)) {
                            $scope.shiftMasterobj.endTime = "";
                            logger.logError("Night Shift Time Difference is more");
                        }
                    } else {
                        $scope.shiftMasterobj.startTime = "";
                        $scope.shiftMasterobj.endTime = "";
                        logger.logError("Night Shift Start Time is Less than 18:00 hrs");
                    }
                }

                // if ($scope.shiftMasterobj.nightShift == 'N') {
                //
                // if ((date1 <= date2) && ((date2 - date1) > 1600)) {
                //
                // } else {
                // $scope.shiftMasterobj.endTime = "";
                // logger.logError("End Time should be greater than Start
                // Time");
                // }
                // } else {
                // if ((date1 <= date2) ) {
                // $scope.shiftMasterobj.endTime = "";
                // logger.logError("start time less than end time");
                // }
                // }
            }
        }

        $scope.$watchCollection('[ shiftMasterobj.startTime,shiftMasterobj.endTime,shiftMasterobj.breakStartTime]', function(newValues) {

            $scope.breakstartChange($scope.shiftMasterobj.startTime, $scope.shiftMasterobj.endTime, $scope.shiftMasterobj.breakStartTime);

        });

        $scope.breakstartChange = function(strtTime, edTime, sttime) {
            if (strtTime != "" && edTime != "" && sttime != "") {
                var startTime = strtTime;
                var endTime = edTime;
                var btime = sttime;

                startTime = startTime.split(":");
                startTime = parseInt(startTime[0] + startTime[1]);
                endTime = endTime.split(":");
                endTime = parseInt(endTime[0] + endTime[1]);
                btime = btime.split(":");
                btime = parseInt(btime[0] + btime[1]);

                if ($scope.shiftMasterobj.nightShift == 'N') {

                    if ((btime > startTime) && (btime < endTime)) {

                    } else {
                        $scope.shiftMasterobj.breakStartTime = "";

                        logger.logError("Break Start Time should be between Shift Start and End Time");
                    }
                } else {
                    if ((btime >= endTime) && (btime <= startTime)) {
                        $scope.shiftMasterobj.breakStartTime = "";

                        logger.logError("Break Time should be between Shift Start and End Time");
                    }
                }
            }
        }

        $scope.$watchCollection('[ shiftMasterobj.breakStartTime,shiftMasterobj.breakEndTime,shiftMasterobj.endTime]', function(newValues) {

            $scope.breakendChange($scope.shiftMasterobj.breakStartTime, $scope.shiftMasterobj.breakEndTime, $scope.shiftMasterobj.endTime);

        });

        $scope.breakendChange = function(bsTime, betime, edTime) {
            if (bsTime != "" && betime != "" && edTime != "") {
                var bstime = bsTime;
                var endTime = edTime;
                var betim = betime;

                bstime = bstime.split(":");
                bstime = parseInt(bstime[0] + bstime[1]);
                endTime = endTime.split(":");
                endTime = parseInt(endTime[0] + endTime[1]);
                betim = betim.split(":");
                betim = parseInt(betim[0] + betim[1]);

                if ($scope.shiftMasterobj.nightShift == 'N') {
                    if ((betim < endTime) && (betim > bstime)) {

                    } else {
                        $scope.shiftMasterobj.breakEndTime = "";
                        logger.logError("Break End Time Should be Between Break Start Time and Shift End Time");
                    }
                }
                // else {
                // if ((betim >= endTime) && (betim <= bstime)) {
                // $scope.shiftMasterobj.breakEndTime = "";
                // logger.logError("Break End Time Should be Between Break Start
                // Time and Shift End Time");
                // }
                // }

                else {
                    if ((bstime <= 2359) && (betim <= 2359) && (bstime >= 1800) && (betim >= 1800)) {
                        if ((betim >= endTime) && (betim <= bstime)) {

                            $scope.shiftMasterobj.breakEndTime = "";
                            logger.logError("Break End Time Should be Between Break Start Time and Shift End Time");
                        }
                    } else if ((bstime >= 0) && (betim >= 0) && (bstime <= endTime) && (betim <= endTime)) {
                        if ((betim <= endTime) && (betim <= bstime)) {

                            $scope.shiftMasterobj.breakEndTime = "";
                            logger.logError("Break End Time Should be Between Break Start Time and Shift End Time");
                        }
                    } else if ((bstime >= 1800) && (betim <= 2359) && (betim <= endTime) && (betim >= 0)) {
                        if ((betim < endTime) && (betim < bstime)) {

                        }
                    } else {
                        $scope.shiftMasterobj.breakStartTime = "";
                        $scope.shiftMasterobj.breakEndTime = "";
                        logger.logError("Break End Time Should be Between Break Start Time and Shift End Time");
                    }
                }
            }

        }

        $scope.$watchCollection('[ shiftMasterobj.startTime,shiftMasterobj.lateAfter,shiftMasterobj.breakStartTime]', function(newValues) {

            $scope.lateChange($scope.shiftMasterobj.startTime, $scope.shiftMasterobj.lateAfter, $scope.shiftMasterobj.breakStartTime);

        });

        $scope.lateChange = function(strtTime, lttime, bTime) {
            if (strtTime != "" && bTime != "" && lttime != "") {
                var startTime = strtTime;
                var bsTime = bTime;
                var lttim = lttime;
                startTime = startTime.split(":");
                startTime = parseInt(startTime[0] + startTime[1]);
                bsTime = bsTime.split(":");
                bsTime = parseInt(bsTime[0] + bsTime[1]);
                lttim = lttim.split(":");
                lttim = parseInt(lttim[0] + lttim[1]);

                if ($scope.shiftMasterobj.nightShift == 'N') {
                    if ((startTime < lttim) && (lttim < bsTime)) {

                    } else {
                        $scope.shiftMasterobj.lateAfter = "";
                        logger.logError("Late After Should be between Shift Start and Break Start Time");
                    }
                } else {
                    if (bsTime > startTime) {
                        if ((lttim < bsTime) && (lttim > startTime)) {

                        } else {
                            $scope.shiftMasterobj.lateAfter = "";
                            logger.logError("Late After Should be between Shift Start and Break Start Time");
                        }
                    }
                    if (bsTime < startTime) {
                        if ((lttim > bsTime) && (lttim < startTime)) {
                            $scope.shiftMasterobj.lateAfter = "";
                            logger.logError("Late After Should be between Shift Start and Break Start Time");

                        }
                    }
                    // else {
                    // if((bsTime<=2359) && (lttim<=2359)&& (bsTime>=1800) &&
                    // (lttim>=1800)){
                    // if((lttim > bsTime) || (lttim <= startTime))
                    // {
                    // $scope.shiftMasterobj.lateAfter = "";
                    // logger.logError("Late After Should be between Shift Start
                    // and Break Start Time");
                    // }
                    // }
                    // else if((bsTime>=0) && (bsTime<1800)&& (lttim>=0)){
                    // if((bsTime < lttim) )
                    // {
                    // $scope.shiftMasterobj.lateAfter = "";
                    // logger.logError("Late After Should be between Shift Start
                    // and Break Start Time");
                    // }
                    // }
                    // else if((bsTime<1800) &&
                    // (bsTime>0)&&(lttim>=1800)&&(lttim<=2359)){
                    // if((lttim < startTime) && (lttim > bsTime))
                    // {
                    // $scope.shiftMasterobj.lateAfter = "";
                    // logger.logError("Late After Should be between Shift Start
                    // and Break Start Time");
                    // }
                    // }
                    // else {
                    // $scope.shiftMasterobj.lateAfter = "";
                    // logger.logError("Late After Should be between Shift Start
                    // and Break Start Time");
                    // }
                }
            }
        }

        $scope.$watchCollection('[ shiftMasterobj.breakEndTime,shiftMasterobj.endTime,shiftMasterobj.earlyExit]', function(newValues) {

            $scope.earlyChange($scope.shiftMasterobj.breakEndTime, $scope.shiftMasterobj.endTime, $scope.shiftMasterobj.earlyExit);

        });

        $scope.earlyChange = function(betime, edTime, extime) {
            if (betime != "" && edTime != "" && extime != "") {
                var endTime = edTime;
                var btim = betime;
                var extim = extime;
                endTime = endTime.split(":");
                endTime = parseInt(endTime[0] + endTime[1]);
                btim = btim.split(":");
                btim = parseInt(btim[0] + btim[1]);
                extim = extim.split(":");
                extim = parseInt(extim[0] + extim[1]);

                if ($scope.shiftMasterobj.nightShift == 'N') {
                    if ((btim < extim) && (extim < endTime)) {

                    } else {
                        $scope.shiftMasterobj.earlyExit = "";
                        logger.logError("Early Exit Should Be Between Break End After and Shift End Time");
                    }
                } else {
                    if (btim < endTime) {
                        if ((extim < endTime) && (extim > btim)) {

                        } else {
                            $scope.shiftMasterobj.earlyExit = "";
                            logger.logError("Early Exit Should Be Between Break End After and Shift End Time");
                        }
                    }
                    if (btim > endTime) {
                        if ((extim < btim) && (extim > endTime)) {
                            $scope.shiftMasterobj.earlyExit = "";
                            logger.logError("Early Exit Should Be Between Break End After and Shift End Time");

                        }
                    }
                }

                // else {
                // if ((extim <= btim) && (extim >= endTime)) {
                // $scope.shiftMasterobj.earlyExit = "";
                // logger.logError("Early Exit Should Be Between Break End After
                // and Shift End Time");
                // }
                // }
            }
        }

        function toUpper(mystring) {
            var sp = mystring.split(' ');
            var wl = 0;
            var f, r;
            var word = new Array();
            for (var i = 0; i < sp.length; i++) {
                f = sp[i].charAt(0).toUpperCase();
                r = sp[i].slice(1).toLowerCase();
                word[i] = f + r;
            }
            var newstring = word.join(' ');
            return newstring;
        }

        $scope.save = function(shiftMasterobj, shiftMasterAddForm) {
            sharedProperties.clearObject();
            if (new validationService().checkFormValidity(shiftMasterAddForm)) {

                var shiftCode = $scope.shiftMasterobj.shiftCode;
                shiftCode = shiftCode.replace(/ {2,}/g, ' ');
                var shiftCod = toUpper(shiftCode);
                $scope.shiftMasterobj.shiftCode = shiftCod;

                var shiftName = $scope.shiftMasterobj.shiftName;
                shiftName = shiftName.replace(/ {2,}/g, ' ');
                var shiftNam = toUpper(shiftName);
                $scope.shiftMasterobj.shiftName = shiftNam;

                var startTime, endTime, StEddiff, breakStartTime, breakEndTime, halftime, BreakStEddiff, TotalCal;
                var sttime = $scope.shiftMasterobj.startTime;// document.getElementById("sttime").value;
                var edtime = $scope.shiftMasterobj.endTime;// document.getElementById("edtime").value;
                startTime = sttime.split(":");
                startTime = parseInt(startTime[0] + startTime[1]);

                endTime = edtime.split(":");
                endTime = parseInt(endTime[0] + endTime[1]);

                StEddiff = startTime - endTime;
                var breaksttime = $scope.shiftMasterobj.breakStartTime;// document.getElementById("breaksttime").value;
                var breakedtime = $scope.shiftMasterobj.breakEndTime;// document.getElementById("breakedtime").value;

                breakStartTime = breaksttime.split(":");
                breakStartTime = parseInt(breakStartTime[0] + breakStartTime[1]);

                breakEndTime = breakedtime.split(":");
                breakEndTime = parseInt(breakEndTime[0] + breakEndTime[1]);

                BreakStEddiff = breakStartTime - breakEndTime;

                TotalCal = StEddiff - BreakStEddiff;

                TotalCal = TotalCal.toString();
                TotalCal = TotalCal.replace(/\-/g, " ");

                var halftime = parseFloat($scope.shiftMasterobj.halfDay).toFixed(2);
                var halftim = halftime.replace(/\./g, '');
                // document.getElementById("halftime").value.replace(/\./g, '');
                var fulltime = parseFloat($scope.shiftMasterobj.fullDay).toFixed(2);// document.getElementById("fulltime").value.replace(/\./g,
                // '');

                var fulltim = fulltime.replace(/\./g, '');

                if (parseInt(TotalCal) <= fulltim) {
                    logger.logError("Full Days working hours Should not be greater than Shift Hours");
                } else if (halftim >= parseInt(TotalCal)) {
                    logger.logError("Half Days working hours Should not be greater than Shift Hours");
                }

                else if (parseInt(halftim) > parseInt(fulltim)) {
                    logger.logError("Half Days working hours Should not be greater than Full Days working hours");
                } else {
                    $http.post($stateParams.tenantid+"/app/hr/manageshift/add", $scope.shiftMasterobj).success(function(result) {
delete result.errors;
                        if (result.success == true) {
                            logger.logSuccess("Saved Succesfully!");
                            $state.go("app.hr.manageshift.list",{tenantid:$stateParams.tenantid});

                        } else {
                            logger.logError(result.message);
                        }
                    }).error(function(result) {
                        console.log("data" + result);
                    });
                }
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(shiftMasterAddForm.$validationSummary), 555000, 'trustedHtml');
            }
        };

    });

    app.controller('shiftMasterEditCtrl', function($scope, $state, $http, ngDialog,  logger, $location,
    		$controller, $injector, sharedProperties, toaster, $rootScope, $stateParams, validationService) {

        var shiftId = $stateParams.shiftId;

        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages = 0

        $('#shiftValue').hide();
        $('#shiftCodeReadOnly').show();
        $('#shiftNameValue').hide();
        $('#shiftNameReadOnly').show();

        $scope.cancel = function() {
            $state.go("app.hr.manageshift.list",{tenantid:$stateParams.tenantid});
        };

        $scope.time = function() {

            $scope.shiftMasterobj.startTime = '';
            $scope.shiftMasterobj.endTime = '';
            $scope.shiftMasterobj.breakStartTime = '';
            $scope.shiftMasterobj.breakEndTime = '';
            $scope.shiftMasterobj.lateAfter = '';
            $scope.shiftMasterobj.earlyExit = '';

        };

        $scope.$watchCollection('[ shiftMasterobj.startTime,shiftMasterobj.endTime]', function(newValues) {

            $scope.timeChange($scope.shiftMasterobj.startTime, $scope.shiftMasterobj.endTime);

        });

        $scope.timeChange = function(strtTime, edTime) {
            if (strtTime != "" && edTime != "") {
                var startTime = strtTime;
                var endTime = edTime;

                startTime = startTime.split(":");
                startTime = parseInt(startTime[0] + startTime[1]);
                endTime = endTime.split(":");
                endTime = parseInt(endTime[0] + endTime[1]);

                if ($scope.shiftMasterobj.nightShift == 'N') {

                    if ((startTime < endTime)) {
                    } else {
                        $scope.shiftMasterobj.endTime = "";
                        logger.logError("End Time should be greater than Start Time");
                    }
                } else {
                    if ((startTime >= 1800) && (startTime < 2359)) {
                        if ((startTime <= endTime) || ((startTime - endTime) < 800)) {
                            $scope.shiftMasterobj.endTime = "";
                            logger.logError("Night Shift Time Difference is more");
                        }
                    } else {
                        $scope.shiftMasterobj.startTime = "";
                        $scope.shiftMasterobj.endTime = "";
                        logger.logError("Night Shift Start Time is Less than 18:00 hrs");
                    }
                }

            }
        }

        $scope.$watchCollection('[ shiftMasterobj.startTime,shiftMasterobj.endTime,shiftMasterobj.breakStartTime]', function(newValues) {

            $scope.breakstartChange($scope.shiftMasterobj.startTime, $scope.shiftMasterobj.endTime, $scope.shiftMasterobj.breakStartTime);

        });

        $scope.breakstartChange = function(strtTime, edTime, sttime) {
            if (strtTime != "" && edTime != "" && sttime != "") {
                var startTime = strtTime;
                var endTime = edTime;
                var btime = sttime;

                startTime = startTime.split(":");
                startTime = parseInt(startTime[0] + startTime[1]);
                endTime = endTime.split(":");
                endTime = parseInt(endTime[0] + endTime[1]);
                btime = btime.split(":");
                btime = parseInt(btime[0] + btime[1]);

                if ($scope.shiftMasterobj.nightShift == 'N') {

                    if ((btime > startTime) && (btime < endTime)) {

                    } else {
                        $scope.shiftMasterobj.breakStartTime = "";

                        logger.logError("Break Start Time should be between Shift Start and End Time");
                    }
                } else {
                    if ((btime >= endTime) && (btime <= startTime)) {
                        $scope.shiftMasterobj.breakStartTime = "";

                        logger.logError("Break Time should be between Shift Start and End Time");
                    }
                }
            }
        }

        $scope.$watchCollection('[ shiftMasterobj.breakStartTime,shiftMasterobj.breakEndTime,shiftMasterobj.endTime]', function(newValues) {

            $scope.breakendChange($scope.shiftMasterobj.breakStartTime, $scope.shiftMasterobj.breakEndTime, $scope.shiftMasterobj.endTime);

        });

        $scope.breakendChange = function(bsTime, betime, edTime) {
            if (bsTime != "" && betime != "" && edTime != "") {
                var bstime = bsTime;
                var endTime = edTime;
                var betim = betime;

                bstime = bstime.split(":");
                bstime = parseInt(bstime[0] + bstime[1]);
                endTime = endTime.split(":");
                endTime = parseInt(endTime[0] + endTime[1]);
                betim = betim.split(":");
                betim = parseInt(betim[0] + betim[1]);

                if ($scope.shiftMasterobj.nightShift == 'N') {
                    if ((betim < endTime) && (betim > bstime)) {

                    } else {
                        $scope.shiftMasterobj.breakEndTime = "";
                        logger.logError("Break End Time Should be Between Break Start Time and Shift End Time");
                    }
                }

                else {
                    if ((bstime <= 2359) && (betim <= 2359) && (bstime >= 1800) && (betim >= 1800)) {
                        if ((betim >= endTime) && (betim <= bstime)) {
                            $scope.shiftMasterobj.breakEndTime = "";
                            logger.logError("Break End Time Should be Between Break Start Time and Shift End Time");
                        }
                    } else if ((bstime >= 0) && (betim >= 0) && (bstime <= endTime) && (betim <= endTime)) {
                        if ((betim <= endTime) && (betim <= bstime)) {
                            $scope.shiftMasterobj.breakEndTime = "";
                            logger.logError("Break End Time Should be Between Break Start Time and Shift End Time");
                        }
                    } else if ((bstime >= 1800) && (betim <= 2359) && (betim <= endTime) && (betim >= 0)) {
                        if ((betim < endTime) && (betim < bstime)) {

                        }
                    } else {
                        $scope.shiftMasterobj.breakEndTime = "";
                        logger.logError("Break End Time Should be Between Break Start Time and Shift End Time");
                    }
                }
            }

        }

        $scope.$watchCollection('[ shiftMasterobj.startTime,shiftMasterobj.lateAfter,shiftMasterobj.breakStartTime]', function(newValues) {

            $scope.lateChange($scope.shiftMasterobj.startTime, $scope.shiftMasterobj.lateAfter, $scope.shiftMasterobj.breakStartTime);

        });

        $scope.lateChange = function(strtTime, lttime, bTime) {
            if (strtTime != "" && bTime != "" && lttime != "") {
                var startTime = strtTime;
                var bsTime = bTime;
                var lttim = lttime;
                startTime = startTime.split(":");
                startTime = parseInt(startTime[0] + startTime[1]);
                bsTime = bsTime.split(":");
                bsTime = parseInt(bsTime[0] + bsTime[1]);
                lttim = lttim.split(":");
                lttim = parseInt(lttim[0] + lttim[1]);

                if ($scope.shiftMasterobj.nightShift == 'N') {
                    if ((startTime < lttim) && (lttim < bsTime)) {

                    } else {
                        $scope.shiftMasterobj.lateAfter = "";
                        logger.logError("Late After Should be between Shift Start and Break Start Time");
                    }
                } else {
                    if (bsTime > startTime) {
                        if ((lttim < bsTime) && (lttim > startTime)) {

                        } else {
                            $scope.shiftMasterobj.lateAfter = "";
                            logger.logError("Late After Should be between Shift Start and Break Start Time");
                        }
                    }
                    if (bsTime < startTime) {
                        if ((lttim > bsTime) && (lttim < startTime)) {
                            $scope.shiftMasterobj.lateAfter = "";
                            logger.logError("Late After Should be between Shift Start and Break Start Time");

                        }
                    }

                }
            }
        }

        $scope.$watchCollection('[ shiftMasterobj.breakEndTime,shiftMasterobj.endTime,shiftMasterobj.earlyExit]', function(newValues) {

            $scope.earlyChange($scope.shiftMasterobj.breakEndTime, $scope.shiftMasterobj.endTime, $scope.shiftMasterobj.earlyExit);

        });

        $scope.earlyChange = function(betime, edTime, extime) {
            if (betime != "" && edTime != "" && extime != "") {
                var endTime = edTime;
                var btim = betime;
                var extim = extime;
                endTime = endTime.split(":");
                endTime = parseInt(endTime[0] + endTime[1]);
                btim = btim.split(":");
                btim = parseInt(btim[0] + btim[1]);
                extim = extim.split(":");
                extim = parseInt(extim[0] + extim[1]);

                if ($scope.shiftMasterobj.nightShift == 'N') {
                    if ((btim < extim) && (extim < endTime)) {

                    } else {
                        $scope.shiftMasterobj.earlyExit = "";
                        logger.logError("Early Exit Should Be Between Break End After and Shift End Time");
                    }
                } else {
                    if (btim < endTime) {
                        if ((extim < endTime) && (extim > btim)) {

                        } else {
                            $scope.shiftMasterobj.earlyExit = "";
                            logger.logError("Early Exit Should Be Between Break End After and Shift End Time");
                        }
                    }
                    if (btim > endTime) {
                        if ((extim < btim) && (extim > endTime)) {
                            $scope.shiftMasterobj.earlyExit = "";
                            logger.logError("Early Exit Should Be Between Break End After and Shift End Time");

                        }
                    }
                }
            }
        }

        $scope.reset = function(shiftSchemeMasterAddForm) {
            $scope.isEdit = true;
            if ($scope.isEdit == true) {
               // var url = 'hrms/master/shiftmaster/getShiftMasterEditList?shiftId=' + shiftId;
                var url = $stateParams.tenantid
				+ '/app/hr/manageshift/getShiftMasterEditList?shiftId='
				+ shiftId;
                $http.get(url).success(function(result) {
                    console.log(result);
                    $scope.shiftMasterobj.breakEndTime = result.breakEndTime;
                    $scope.shiftMasterobj.breakStartTime = result.breakStartTime;
                    $scope.shiftMasterobj.description = result.description;
                    $scope.shiftMasterobj.earlyExit = result.earlyExit;
                    $scope.shiftMasterobj.effectFromDate = result.effectFromDate;
                    $scope.shiftMasterobj.endTime = result.endTime;
                    $scope.shiftMasterobj.fullDay = result.fullDay;
                    $scope.shiftMasterobj.halfDay = result.halfDay;
                    $scope.shiftMasterobj.lateAfter = result.lateAfter;

                    if (result.nightShift == "true") {
                        $scope.shiftMasterobj.nightShift = 'Y';
                    } else {
                        $scope.shiftMasterobj.nightShift = 'N';
                    }

                    $scope.shiftMasterobj.noOfTimeAllowed = result.noOfTimeAllowed;
                    $scope.shiftMasterobj.shiftCode = result.shiftCode;
                    $scope.shiftMasterobj.shiftId = result.shiftId;
                    $scope.shiftMasterobj.shiftName = result.shiftName;
                    $scope.shiftMasterobj.startTime = result.startTime;
                    $scope.shiftMasterobj.thresholdTime = result.thresholdTime;

                });
            }
        };

        $scope.shiftMasterobj = {
            shiftId : '',
            shiftName : '',
            shiftCode : '',
            description : '',
            effectFromDate : '',
            startTime : '',
            endTime : '',
            breakStartTime : '',
            breakEndTime : '',
            thresholdTime : '',
            nightShift : 'N',
            lateAfter : '',
            earlyExit : '',
            noOfTimeAllowed : '',
            halfDay : '',
            fullDay : ''
        };

        $scope.shiftMasterobjClear = {};

        $scope.shiftMasterValidateData = {
            isEdit : true,
            sMEdit : true
        };
        var shiftId = $location.search().shiftId;


        //var url = 'hrms/master/shiftmaster/getShiftMasterEditList?shiftId=' + shiftId;
        var url = $stateParams.tenantid + '/app/hr/manageshift/getShiftMasterEditList?shiftId=' + shiftId;

        $http.get(url).success(function(result) {

            $scope.shiftMasterobj.breakEndTime = result.breakEndTime;
            $scope.shiftMasterobj.breakStartTime = result.breakStartTime;
            $scope.shiftMasterobj.description = result.description;
            $scope.shiftMasterobj.earlyExit = result.earlyExit;
            $scope.shiftMasterobj.effectFromDate = result.effectFromDate;
            $scope.shiftMasterobj.endTime = result.endTime;
            $scope.shiftMasterobj.fullDay = result.fullDay;
            $scope.shiftMasterobj.halfDay = result.halfDay;
            $scope.shiftMasterobj.lateAfter = result.lateAfter;

            if (result.nightShift == "true") {
                $scope.shiftMasterobj.nightShift = 'Y';
            } else {
                $scope.shiftMasterobj.nightShift = 'N';
            }

            $scope.shiftMasterobj.noOfTimeAllowed = result.noOfTimeAllowed;
            $scope.shiftMasterobj.shiftCode = result.shiftCode;
            $scope.shiftMasterobj.shiftId = result.shiftId;
            $scope.shiftMasterobj.shiftName = result.shiftName;
            $scope.shiftMasterobj.startTime = result.startTime;
            $scope.shiftMasterobj.thresholdTime = result.thresholdTime;

        }).error(function(result) {
            logger.logError("Error Please Try Again");
        });

        function toUpper(mystring) {
            var sp = mystring.split(' ');
            var wl = 0;
            var f, r;
            var word = new Array();
            for (var i = 0; i < sp.length; i++) {
                f = sp[i].charAt(0).toUpperCase();
                r = sp[i].slice(1).toLowerCase();
                word[i] = f + r;
            }
            var newstring = word.join(' ');
            return newstring;
        }

        $scope.save = function(shiftMasterobj, shiftMasterAddForm) {

            sharedProperties.clearObject();

            if (new validationService().checkFormValidity(shiftMasterAddForm)) {

                var shiftCode = $scope.shiftMasterobj.shiftCode;
                shiftCode = shiftCode.replace(/ {2,}/g, ' ');
                var shiftCod = toUpper(shiftCode);
                $scope.shiftMasterobj.shiftCode = shiftCod;

                var shiftName = $scope.shiftMasterobj.shiftName;
                shiftName = shiftName.replace(/ {2,}/g, ' ');
                var shiftNam = toUpper(shiftName);
                $scope.shiftMasterobj.shiftName = shiftNam;
                
                var startTime, endTime, StEddiff, breakStartTime, breakEndTime, halftime, BreakStEddiff, TotalCal;
                var sttime = $scope.shiftMasterobj.startTime;// document.getElementById("sttime").value;
                var edtime = $scope.shiftMasterobj.endTime;// document.getElementById("edtime").value;

                startTime = sttime.split(":");
                startTime = parseInt(startTime[0] + startTime[1]);

                endTime = edtime.split(":");
                endTime = parseInt(endTime[0] + endTime[1]);

                StEddiff = startTime - endTime;
                var breaksttime = $scope.shiftMasterobj.breakStartTime;// document.getElementById("breaksttime").value;
                var breakedtime = $scope.shiftMasterobj.breakEndTime;// document.getElementById("breakedtime").value;

                breakStartTime = breaksttime.split(":");
                breakStartTime = parseInt(breakStartTime[0] + breakStartTime[1]);

                breakEndTime = breakedtime.split(":");
                breakEndTime = parseInt(breakEndTime[0] + breakEndTime[1]);

                BreakStEddiff = breakStartTime - breakEndTime;

                TotalCal = StEddiff - BreakStEddiff;

                TotalCal = TotalCal.toString();
                TotalCal = TotalCal.replace(/\-/g, " ");

                var halftime = parseFloat($scope.shiftMasterobj.halfDay).toFixed(2);
                var halftim = halftime.replace(/\./g, '');
                // document.getElementById("halftime").value.replace(/\./g, '');
                var fulltime = parseFloat($scope.shiftMasterobj.fullDay).toFixed(2);// document.getElementById("fulltime").value.replace(/\./g,
                // '');

                var fulltim = fulltime.replace(/\./g, '');
                if (parseInt(TotalCal) <= fulltim) {
                    logger.logError("Full Days working hours Should not be greater than Shift Hours");
                } else if (halftim >= parseInt(TotalCal)) {
                    logger.logError("Half Days working hours Should not be greater than Shift Hours");
                }
                else if (parseInt(halftim) > parseInt(fulltim)) {
                    logger.logError("Half Days working hours Should not be greater than Full Days working hours");
                } else {
                    $http.post($stateParams.tenantid+"/app/hr/manageshift/update", $scope.shiftMasterobj).success(function(result) {
                        if (result.success == true) {
                            logger.logSuccess("Updated Succesfully!");
                            $state.go("app.hr.manageshift.list",{tenantid:$stateParams.tenantid});
                        } else {
                            logger.logError(result.message);
                        }
                    }).error(function(result) {
                        console.log("data" + result);
                    });
                }

            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(shiftMasterAddForm.$validationSummary), 555000, 'trustedHtml');
            }
        };

    });

