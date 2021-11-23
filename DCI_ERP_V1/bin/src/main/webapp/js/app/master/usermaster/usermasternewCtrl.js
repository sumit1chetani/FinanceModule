'use strict';
app.controller('usermasterCtrl', function($scope,$stateParams, $rootScope, $http, $location,ngDialog, logger, utilsService,$state,sharedProperties,$window) {

	             $scope.offsetCount = 0;
	            $scope.limitCount = 1000;
	            $scope.rowCollection = [];
	            $scope.displayedCollection = [];
	            $scope.itemsByPage = 75;
	            $scope.numPages=0                        
	            $scope.isDelete=true;      
	            $scope.EmployeeMasterData={
	                    status1 : '0',
	                    donorCode : '',
	                    employeeNo : '',
	                    firstName : '',
	                    middleName : '',
	                    lastName : '',
	                    empId : '',
	                    pwd : '',
	                    gender : '',
	                    dob : '',
	                    emailId : '',
	                    mobileNo : '',
	                    doj : '',
	                    esic : '',
	                    fixedGross : '',
	                    isActive : 'N',
	                    status : 'N',
	                    accessCardNo : '',
	                    uploadPhoto : '',
	                    companyCode : '',
	                    companyName : '',
	                    branch : '',
	                    branchName : '',
	                    departmentId : '',
	                    departmentCode : '',
	                    designation : '',
	                    designationName : '',
	                    division : '',
	                    divisionName : '',
	                    grade : '',
	                    gradeName : '',
	                    reportToBranch : '',
	                    reportToBranchName : '',
	                    reportDeptId : '',
	                    reportToDept : '',
	                    reportDesigId : '',
	                    reportToDesig : '',
	                    reportMangr : '',
	                    typeOfEmp : '',
	                    empTypeName : '',
	                    relieveDate : '',
	                    epfNo    : '',
	                    isEdit:false,
	                    deptContact:''
	            };            
	                   
	            $scope.status1 = [ {
	                id : '0',
	                text : 'Active'
	            }, {
	                id : '1',
	                text : 'InActive'
	            }, {
	                id : '2',
	                text : 'All'
	            },];
	            $scope.add = function() {
	            	
	                $state.go('app.master.user.userMasteradd-add',{tenantid:$stateParams.tenantid});    
	            };
	        
	        
	        
	        $scope.editRow = function (empId){
	           // alert(empId);
	            //$location.url('hrms/master/employeeMaster/edit?empId='+empId);
	            var empId=empId;
	            $state.go('app.master.user.userMasteredit-Edit',{empId:empId});
	        }
	        $scope.view = function(empId){
	        	var empId=empId;
	            $state.go('app.master.user.userloyeeMasterview-View',{empId:empId});

	        }
	        
	        
	        
	        // remove to the real data holder
	        $scope.deleteRow = function(empId, index) {
	            ngDialog.openConfirm().then(function() {
	                var myURL =$stateParams.tenantid+'/hrms/master/userAdminMaster/delete';
	                $http({
	                    method : 'post',
	                    url : myURL,
	                    data : empId,
	                }).success(function(data) {
	                    if (data == true) {
	                        $scope.displayedCollection.splice(index, 1);
	                        logger.logSuccess("Employee Deleted Successfully");
	                        $scope.getEmployeeList();
	                    } else {
	                        logger.logGeneric(data.message, data.type);
	                    }
	                }).error(function(data) {
	                    logger.logGeneric(data.message, data.type);                   
	                });
	                console.log('Modal promise resolved. Value: ');
	            }, function(reason) {
	                console.log('Modal promise rejected. Reason: ', reason);
	            });

	        };
	        
	        $scope.$watch('EmployeeMasterData.status1', function(newVal, oldVal) {

	            if (newVal != undefined && newVal != '') {
	             //alert(newVal);
	                
	              //Populate Grid
	                $scope.getEmployeeList = function() {
	                    $scope.dataLoopCount = 0;
	                    $scope.showEmptyLabel = false;
	                    $scope.from = 0;
	                    $scope.to = 100;
	                    var status1 = newVal
	                    $scope.rowCollection = [];
	                    var url = $stateParams.tenantid+'/hrms/master/userAdminMaster/list?limit=' + $scope.from + '&offset=' + $scope.to + '&status1=' + status1;
	                    $http.get(url).success(function(data) {
	                        console.log("data***************************************************");
	                        console.log(data);
	                        
	                        for(var i =0;i<data.empDataList.length;i++){
	       		        	 if(data.empDataList[i].dob != null){
	       		             var dateSplitted = data.empDataList[i].dob.split(" ");
	       		             var dateSplitted1 = dateSplitted[0].split("/").reverse().join("/");
	       		             var  ms = Date.parse(dateSplitted1);
	       		             console.log(dateSplitted +" : " +ms)
	       		             data.empDataList[i].dob1=ms;
	       		        	 }
	       		         }
	                        
	                        
	                        for(var i =0;i<data.empDataList.length;i++){
		       		        	 if(data.empDataList[i].doj != null){
		       		             var dateSplitted = data.empDataList[i].doj.split(" ");
		       		             var dateSplitted1 = dateSplitted[0].split("/").reverse().join("/");
		       		             var  ms = Date.parse(dateSplitted1);
		       		             console.log(dateSplitted +" : " +ms)
		       		             data.empDataList[i].doj1=ms;
		       		        	 }
		       		         }
	                        if (data.success == true) {
	                            $scope.rowCollection = $scope.rowCollection.concat(data.empDataList);
	                        }
	                    });
	                };
	                
	                $scope.getEmployeeList();   
	            }
	        });
	        
	                 
	
	    
	});
    