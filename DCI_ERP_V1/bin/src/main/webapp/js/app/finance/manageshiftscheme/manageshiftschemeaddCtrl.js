
'use strict';

app.controller('manageshiftschemeAddCtrl', function($scope,$state,$http,ngDialog,$stateParams, logger,$location,
		$controller,$injector, sharedProperties, toaster,
		$rootScope,validationService) {
    
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages=0;
        $scope.isEdit = false;
        
        
        $('#validityTo').datetimepicker({
            format : 'DD/MM/YYYY'
        })
          $('#validityFrom').datetimepicker({
            format : 'DD/MM/YYYY'
        })
       
      
        
        $scope.cancel = function() {
            $state.go("app.hr.manageshiftscheme.list",{tenantid:$stateParams.tenantid});

        };

    
        $('#schemeName').show();
        $('#schemeNameReadOnly').hide();
        $scope.disableDate= function(view, dates, leftDate, upDate, rightDate) {
            minDate = new Date().setHours(0,0,0,0) // Set minimum date to whatever you want here
            for(d in $dates){         
                if($dates[d].utcDateValue>minDate){
                    $dates[d].selectable = false
                }
            }
        }
        $scope.reset = function(shiftSchemeMasterAddForm) {
            $scope.shiftSchemeMasterobj.schemeName = '';
            $scope.shiftSchemeMasterobj.validityFrom = '';
            $scope.shiftSchemeMasterobj.validityTo = '';
            $scope.shiftSchemeMasterobj.sundayCompany = '',
            $scope.shiftSchemeMasterobj.mondayCompany = '',
            $scope.shiftSchemeMasterobj.tuesdayCompany = '',
            $scope.shiftSchemeMasterobj.wednesdayCompany = '',
            $scope.shiftSchemeMasterobj.thursdayCompany = '',
            $scope.shiftSchemeMasterobj.fridayCompany = '',
            $scope.shiftSchemeMasterobj.saturdayCompany = ''
        };
        
        $scope.shiftSchemeMasterobj={
            schemeName : '',
            validityFrom : '',
            validityTo : '',
            shiftCode : '',
            sunday : 'Sunday',
            monday : 'Monday',
            tuesday : 'Tuesday',
            wednesday : 'Wednesday',
            thursday : 'Thursday',
            friday : 'Friday',
            saturday : 'Saturday',
            shiftId : '',
            shiftName : '',
            sundayCompany : '',
            mondayCompany : '',
            tuesdayCompany : '',
            wednesdayCompany : '',
            thursdayCompany : '',
            fridayCompany : '',
            saturdayCompany : ''
        };
            
        $scope.shiftNameList = [];
        
        $scope.$watchCollection('[ shiftSchemeMasterobj.validityFrom,shiftSchemeMasterobj.validityTo]', function(newValues){
            $scope.dateChange($scope.shiftSchemeMasterobj.validityFrom,$scope.shiftSchemeMasterobj.validityTo);
        });
        
        $scope.dateChange=function(frmDate,tDate){
            if(frmDate!="" && tDate!=""){
                var fromDate = frmDate;
                var toDate = tDate;
                fromDate = fromDate.split("/");
                fromDate = new Date(fromDate[2], fromDate[1], fromDate[0]);
                toDate = toDate.split("/");
                toDate = new Date(toDate[2], toDate[1], toDate[0]);
                if(fromDate <= toDate){
                    $http.post($stateParams.tenantid+"/app/hr/shiftschememaster/getShiftNameList", $scope.shiftSchemeMasterobj).success(function(result) {


                    $scope.shiftNameList = result.shiftNameList; 
                });
               }else{
                   $scope.shiftSchemeMasterobj.validityTo="";
                   logger.logError("Validity From Should be greater than Validity To");
               }
            }
        }
        
        $scope.validate = function(shiftSchemeMasterAddForm,shiftSchemeMasterobj) {
            if (new validationService().checkFormValidity($scope.shiftSchemeMasterAddForm)) {
                if(!$scope.isEdit){
                    $scope.save(shiftSchemeMasterAddForm,shiftSchemeMasterobj);
                }
            } else {
                toaster.pop('error', "Please fill the required fields", 
                        logger.getErrorHtmlNew($scope.shiftSchemeMasterAddForm.$validationSummary), 555000, 'trustedHtml');
            }
        };
        
        function toUpper(mystring) {
            var sp = mystring.split(' ');
            var wl=0;
            var f ,r;
            var word = new Array();
            for (var i = 0 ; i < sp.length ; i ++ ) {
                f = sp[i].charAt(0).toUpperCase();
                r = sp[i].slice(1).toLowerCase();
                word[i] = f+r;
            }
            var newstring = word.join(' ');
            return newstring;   
        }
        
        $scope.save = function(shiftSchemeMasterAddForm,shiftSchemeMasterobj) {
            
            var schemeNam =  $scope.shiftSchemeMasterobj.schemeName;
            schemeNam = schemeNam.replace(/ {2,}/g,' ');
            var schemeName =  toUpper(schemeNam);
            $scope.shiftSchemeMasterobj.schemeName = schemeName;
            
            if($scope.shiftSchemeMasterobj.sundayCompany != "" && $scope.shiftSchemeMasterobj.mondayCompany != ""  && $scope.shiftSchemeMasterobj.tuesdayCompany != ""  && $scope.shiftSchemeMasterobj.wednesdayCompany != ""  && $scope.shiftSchemeMasterobj.thrusdayCompany != ""  && $scope.shiftSchemeMasterobj.fridayCompany != "" && $scope.shiftSchemeMasterobj.saturdayCompany != ""){
               $http.post($stateParams.tenantid+"/app/hr/shiftschememaster/add", $scope.shiftSchemeMasterobj).success(function(result) {

            	   delete result.errors;
                    if (result.success==true) {
                        logger.logSuccess("Saved Succesfully!");
                        
                        $state.go("app.hr.manageshiftscheme.list",{tenantid:$stateParams.tenantid});

                        
                    } else {
                        logger.logError(result.message);
                    }
                });
            }else{
                logger.logError("Please select Shift name for all Days");
            }
        }
        
    });
    
  app.controller('shiftSchemeMasterEditCtrl', function($scope,$state,$http,$location,ngDialog,logger,$stateParams,$controller,$injector,sharedProperties, toaster,$rootScope,validationService) {
        
        var schemeName = $stateParams.schemeName;
        
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages=0;
        $scope.isEdit = true;
        
        
        $scope.cancel = function() {
            $state.go("app.hr.manageshiftscheme.list",{tenantid:$stateParams.tenantid});

        };

        
        $('#schemeName').hide();
        $('#schemeNameReadOnly').show();
        
        $scope.shiftSchemeMasterobj={
            schemeName : '',
            validityFrom : '',
            validityTo : '',
            shiftCode : '',
            sunday : 'Sunday',
            monday : 'Monday',
            tuesday : 'Tuesday',
            wednesday : 'Wednesday',
            thursday : 'Thursday',
            friday : 'Friday',
            saturday : 'Saturday',
            shiftId : '',
            shiftName : '',
            sundayCompany : '',
            mondayCompany : '',
            tuesdayCompany : '',
            wednesdayCompany : '',
            thursdayCompany : '',
            fridayCompany : '',
            saturdayCompany : ''
        };
            
        $scope.shiftNameList = [];
        $scope.$watchCollection('[ shiftSchemeMasterobj.validityFrom,shiftSchemeMasterobj.validityTo]', function(newValues){
            $scope.dateChange($scope.shiftSchemeMasterobj.validityFrom,$scope.shiftSchemeMasterobj.validityTo);
        });
        
        $scope.dateChange=function(frmDate,tDate){
            if(frmDate!="" && tDate!=""){
                var fromDate = frmDate;
                var toDate = tDate;
                fromDate = fromDate.split("/");
                fromDate = new Date(fromDate[2], fromDate[1], fromDate[0]);
                toDate = toDate.split("/");
                toDate = new Date(toDate[2], toDate[1], toDate[0]);
                if(fromDate <= toDate){
                $http.post($stateParams.tenantid+"/app/hr/shiftschememaster/getShiftNameList",$scope.shiftSchemeMasterobj).success(function(datas) {
	
                	
                    console.log(datas);
                    $scope.shiftNameList = datas.shiftNameList; 
                });
               }else{
                   $scope.shiftSchemeMasterobj.validityTo="";
                   logger.logError("Validity From Should be greater than Validity To");
               }
            }
        }
        var schemeName = $location.search().schemeName;

       
     //   var url = 'hrms/master/shiftschememaster/getShiftSchemeMasterEditList?schemeName=' + schemeName;
        var url = $stateParams.tenantid+ '/app/hr/shiftschememaster/getShiftSchemeMasterEditList?schemeName='+ schemeName;
        $http.get(url).success(function(result) {
            console.log(result);
            $scope.shiftSchemeMasterobj.schemeName = result.schemeName;
            $scope.shiftSchemeMasterobj.validityFrom = result.validityFrom;
            $scope.shiftSchemeMasterobj.validityTo = result.validityTo;
            
            angular.forEach(result.weekList, function(value, key){
                if(value.weekDay == 1){
                    $scope.shiftSchemeMasterobj.sundayCompany = value.shiftName;
                 }else if(value.weekDay == 2){
                     $scope.shiftSchemeMasterobj.mondayCompany = value.shiftName;
                 }else if(value.weekDay == 3){
                     $scope.shiftSchemeMasterobj.tuesdayCompany = value.shiftName;
                 }else if(value.weekDay == 4){
                     $scope.shiftSchemeMasterobj.wednesdayCompany = value.shiftName;
                 }else if(value.weekDay == 5){
                     $scope.shiftSchemeMasterobj.thursdayCompany = value.shiftName;
                 }else if(value.weekDay == 6){
                     $scope.shiftSchemeMasterobj.fridayCompany = value.shiftName;
                 }else if(value.weekDay == 7){
                     $scope.shiftSchemeMasterobj.saturdayCompany = value.shiftName;
                 }
                     
             });
            
        }).error(function(result) {
            logger.logError("Error Please Try Again");
        });
        
        $scope.shiftSchemeMasterobjClear={};
        
        $scope.reset = function(shiftSchemeMasterAddForm) {
          $scope.isEdit = true;
            if($scope.isEdit == true){
               // var url = 'hrms/master/shiftschememaster/getShiftSchemeMasterEditList?schemeName=' + schemeName;
                var url = $stateParams.tenantid
        		+ '/app/hr/shiftschememaster/getShiftSchemeMasterEditList?schemeName='
        		+ schemeName;
                $http.get(url).success(function(result) {
                    
                    $scope.shiftSchemeMasterobj.schemeName = result.schemeName;
                    $scope.shiftSchemeMasterobj.validityFrom = result.validityFrom;
                    $scope.shiftSchemeMasterobj.validityTo = result.validityTo;
                    
                    angular.forEach(result.weekList, function(value, key){
                        if(value.weekDay == 1){
                            $scope.shiftSchemeMasterobj.sundayCompany = value.shiftName;
                         }else if(value.weekDay == 2){
                             $scope.shiftSchemeMasterobj.mondayCompany = value.shiftName;
                         }else if(value.weekDay == 3){
                             $scope.shiftSchemeMasterobj.tuesdayCompany = value.shiftName;
                         }else if(value.weekDay == 4){
                             $scope.shiftSchemeMasterobj.wednesdayCompany = value.shiftName;
                         }else if(value.weekDay == 5){
                             $scope.shiftSchemeMasterobj.thursdayCompany = value.shiftName;
                         }else if(value.weekDay == 6){
                             $scope.shiftSchemeMasterobj.fridayCompany = value.shiftName;
                         }else if(value.weekDay == 7){
                             $scope.shiftSchemeMasterobj.saturdayCompany = value.shiftName;
                         }
                             
                     });
                    
                });
            }
        };
        
        $scope.validate = function(shiftSchemeMasterAddForm,shiftSchemeMasterobj) {
            if (new validationService().checkFormValidity($scope.shiftSchemeMasterAddForm)) {
                if($scope.isEdit){
                    $scope.update(shiftSchemeMasterAddForm,shiftSchemeMasterobj);
                }
            } else {
                toaster.pop('error', "Please fill the required fields", 
                        logger.getErrorHtmlNew($scope.shiftSchemeMasterAddForm.$validationSummary), 555000, 'trustedHtml');
            }
        };
        
        function toUpper(mystring) {
            var sp = mystring.split(' ');
            var wl=0;
            var f ,r;
            var word = new Array();
            for (var i = 0 ; i < sp.length ; i ++ ) {
                f = sp[i].charAt(0).toUpperCase();
                r = sp[i].slice(1).toLowerCase();
                word[i] = f+r;
            }
            var newstring = word.join(' ');
            return newstring;   
        }
        
        $scope.update = function(shiftSchemeMasterAddForm,shiftSchemeMasterobj) {
            
            var schemeNam =  $scope.shiftSchemeMasterobj.schemeName;
            schemeNam = schemeNam.replace(/ {2,}/g,' ');
            var schemeName =  toUpper(schemeNam);
            $scope.shiftSchemeMasterobj.schemeName = schemeName;
            
            if($scope.shiftSchemeMasterobj.sundayCompany != "" && $scope.shiftSchemeMasterobj.mondayCompany != ""  && $scope.shiftSchemeMasterobj.tuesdayCompany != ""  && $scope.shiftSchemeMasterobj.wednesdayCompany != ""  && $scope.shiftSchemeMasterobj.thrusdayCompany != ""  && $scope.shiftSchemeMasterobj.fridayCompany != "" && $scope.shiftSchemeMasterobj.saturdayCompany != ""){
                $http.post($stateParams.tenantid+'/app/hr/shiftschememaster/update', shiftSchemeMasterobj).success(function(result) {
                    if (result.success==true) {
                        logger.logSuccess("Updated Succesfully!");
                        $state.go('app.hr.shiftschememaster.list');
                    } else {
                        logger.logError(result.message);
                    }
                });
            }else{
                    logger.logError("Please select Shift name for all Days");
            }
        }
    });
    