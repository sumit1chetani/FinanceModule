'use strict';
app.controller('leavetypeAddCtrl', function($scope, $state,$location,sharedProperties,toaster,$injector,logger,$http,$stateParams,$timeout) {
        $scope.leaveType = {
        	leaveRequestId : '',
            shortName : '',
            leaveTypeName : '',
            canCarryForward : false,
            carryForwardLimit : null,
            encashable : false,
            applicableUnderProbation : false,
            medical : false,
            maternityLeave : false,
            maxDaysUnderProbation : null,
            maxDaysMedicalLeave : null,
            maxDaysMaternityLeave : null,
            gender : 0,
            status : false,
            year : '',
            empId :'',
            branch : ''
        };
        $scope.male=false;
        $scope.both=false;
        
//        $scope.sickChange=function(sick){
//            $scope.leaveType.maternityLeave = false;
//            $scope.leaveType.maxDaysMedicalLeave = '';
//            $scope.male=false;
//            $scope.both=false;
//        }
        $scope.employeeList  = [];
        
        $http.get($stateParams.tenantid+'/app/commonUtility/getEmployeeList').success(function(datas) {
            $scope.employeeList = datas;
            }).error(function(datas) {
        });
        
        
        		$scope.branchList=[];
        	   	$scope.getportList=function(){
        	   	$http.post($stateParams.tenantid+'/app/hr/holiday/branchlist').success(function(data) { 
        	   	debugger
        	   	$scope.branchList = data;
        	   	
        
        	   	console.log("branchList");
        	   	console.log( $scope.branchList);
        	   	$timeout(function() {
        	    
        	    $("#branch").multiselect({
        	    maxHeight: 200, 
        	    includeSelectAllOption: true,
        	    selectAllText : 'Select All',
        	    enableFiltering : true,	
        	    disableIfEmpty: true,
        	    enableCaseInsensitiveFiltering: true,
        	    numberDisplayed: 1,
        	    onDropdownHide: function (event) {

        	    }
        	    });
        	    $("#multiselect-button").addClass("width_100 input-sm line-height-5");

        	   	}, 2, false);
        	   	
        	   	});

        	   	};
        	   	
        	   	
        	   	
        	   	$scope.getportList();
   
    	
    
        $scope.checkNoOfDays = function(value){
            var regex = /^\d{1,20}\.?\d{0,2}$/;
            var isValid = false;
            isValid = regex.test(value);
            if(value == ""){
            }
            if(isValid==true){
                $scope.leaveType.maxDaysUnderProbation=value;
            }else if(isValid==false){
                $scope.leaveType.maxDaysUnderProbation = value.slice(0,-1);
            }
        }
        $scope.checkmaxDaysMedicalLeave = function(value){
            var regex = /^\d{1,20}\.?\d{0,2}$/;
            var isValid = false;
            isValid = regex.test(value);
            if(value == ""){
            }
            if(isValid==true){
                $scope.leaveType.maxDaysMedicalLeave=value;
            }else if(isValid==false){
                $scope.leaveType.maxDaysMedicalLeave = value.slice(0,-1);
            }
        }
        $scope.checkmaxDaysMaternityLeave = function(value){
            var regex = /^\d{1,20}\.?\d{0,2}$/;
            var isValid = false;
            isValid = regex.test(value);
            if(value == ""){
            }
            if(isValid==true){
                $scope.leaveType.maxDaysMaternityLeave=value;
            }else if(isValid==false){
                $scope.leaveType.maxDaysMaternityLeave = value.slice(0,-1);
            }
        }
        
        $scope.maternityChange=function(maternity){
            if(maternity==true){
            $scope.leaveType.medical = false;
            $scope.leaveType.gender=2;
            $scope.leaveType.maxDaysMaternityLeave = '';
            $scope.male=true;
            $scope.both=true
            }else{
                $scope.male=false;
                $scope.both=false;
            }
        }
        
        $scope.cancel = function() {
            $state.go("app.hr.leavetype.list");
        };
        $scope.isEdit = false;
        var shortName = $location.search().shortName;
        if(shortName != undefined && shortName != ''){
            $scope.isEdit = true;
            $http.post($stateParams.tenantid+"/finance/leavetype/edit",shortName)
            .success(function(response) {
               if(response.success == true){
                   $scope.leaveType = response.leaveType;
                   

           		$scope.branchList=[];
           	   	$scope.getportList=function(){
           	   	$http.post($stateParams.tenantid+'/app/invoice/branchlist').success(function(data) { 
           	   	debugger
           	   	$scope.branchList = data;
           	   	
           
           	   	console.log("branchList");
           	   	console.log( $scope.branchList);
           	   	$timeout(function() {
           	    
           	    $("#branch").multiselect({
           	    maxHeight: 200, 
           	    includeSelectAllOption: true,
           	    selectAllText : 'Select All',
           	    enableFiltering : true,	
           	    disableIfEmpty: true,
           	    enableCaseInsensitiveFiltering: true,
           	    numberDisplayed: 1,
           	    onDropdownHide: function (event) {

           	    }
           	    });
           	    $("#multiselect-button").addClass("width_100 input-sm line-height-5");

           	   	}, 2, false);
           	   	
           	   	});

           	   	};
           	   	
           	   	
           	   	
           	   	$scope.getportList();
      
               }else{
                   if(response.message != ''){
                       logger.logError(response.message);
                   }
               }
            });
        }
        var $validationProvider = $injector.get('$validation');
        $scope.save = function(leaveTypeForm) {
            sharedProperties.clearObject();
            $validationProvider.validate(leaveTypeForm).success(function(){
              	var payerCode = "";
            	if($scope.leaveType.branch!=null){
            		 angular.forEach($scope.leaveType.branch, function(item, key) {
                         if (payerCode == "") {
                         payerCode = item.id;
                         } else {
                         payerCode += "," + item.id;
                         }
                         $scope.leaveType.branch= payerCode;
                         });
            	}else{
            		$scope.leaveType.branch='';
            	}
            
                $http.post($stateParams.tenantid+"/finance/leavetype/save",$scope.leaveType)
                .success(function(response) {
                   if(response == true){
                       logger.logSuccess("Saved Successfully!");
                       $scope.cancel();
                   }else{
                       logger.logError(response.message);
                   }
                });
            }).error(function(){
                toaster.pop('error', "Please correct the errors", logger.getErrorHtml(sharedProperties.getErrorObject()), 10000, 'trustedHtml');
//                logger.logError(logger.getErrorHtml(sharedProperties.getErrorObject()), 0, 'trustedHtml');
            });
        };
        $scope.update = function(leaveTypeForm) {
            sharedProperties.clearObject();
            $validationProvider.validate(leaveTypeForm).success(function(){
                $http.post($stateParams.tenantid+"/finance/leavetype/update",$scope.leaveType)
                .success(function(response) {
                   if(response.success == true){
                       logger.logSuccess("Updated Successfully!");
                       $scope.cancel();
                   }else{
                       logger.logError(response.message);
                   }
                });
            }).error(function(){
                console.log(sharedProperties.getErrorObject());
                toaster.pop('error', "Please correct the errors", logger.getErrorHtml(sharedProperties.getErrorObject()), 10000, 'trustedHtml');
            });
        };
        $scope.reset = function(form) {
            if($scope.isEdit == true){
                var shortName = $location.search().shortName;
                $http.post($stateParams.tenantid+"/finance/leavetype/edit",shortName)
                .success(function(response) {
                    $scope.leaveType = response.leaveType;
                
                });
            }
                else {
            $scope.leaveType.leaveTypeName ='';
            $scope.leaveType.shortName = '';
            $scope.leaveType.canCarryForward = false;
            $scope.leaveType.carryForwardLimit = '';
            $scope.leaveType.encashable = false;
            $scope.leaveType.applicableUnderProbation = false;
            $scope.leaveType.medical = false;
            $scope.leaveType.maternityLeave = false;
            $scope.leaveType.maxDaysUnderProbation = '';
            $scope.leaveType.maxDaysMedicalLeave = '';
            $scope.leaveType.maxDaysMaternityLeave = '';
            $scope.leaveType.gender = 0;
            $scope.leaveType.status = false;
            }
        };
    });