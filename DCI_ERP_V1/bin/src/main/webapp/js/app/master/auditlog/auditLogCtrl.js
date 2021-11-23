'use strict';

app.controller('userloglistctrl', function($scope, $rootScope, $http,
		$location, logger, utilsService, ngDialog, $state, sharedProperties,
		$window, $stateParams) {

    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.formCodeList = [];
    $scope.employeeList = [];
    $scope.tableNameList = [];

    $scope.isDisplay = true;

    $scope.userLog = {
        dateFrom : '',
        dateTo : '',
        employeeId : '',
        formCode : '',
        identifier: '',
        actionType:''
    };

    $scope.getUserLogList = function() {
        console.log($scope.userLog)
         if($scope.userLog.dateTo != '' && $scope.userLog.dateFrom == ''){
        	 
        	 logger.logError("Please Select From Date");
         }else{
        	 $http.post($stateParams.tenantid+'/app/userlog/list', $scope.userLog).success(function(response) {
             	
             	console.log(response.userLogList.length);
             	if(response.userLogList.length == 0){
             		 logger.logError("No Records has been found");
             	}else{
             		 $scope.rowCollection = response.userLogList;
             	}
             	
                
             }); 
         }
    };

    $scope.getEmployeeList = function() {
        $http.get($stateParams.tenantid+'/app/userlog/employeelist').success(function(response) {
            $scope.employeeList = response.employeeList[0].okker;
            $scope.formCodeList = response.formCodeList[0].onkk;
            console.log("*************")
            console.log(response.formCodeList[0].onkk)
            $scope.tableNameList = response.tableNameList;
            $scope.actionList=[{
                actionType :'ADD',
                id:'ADD', 
                text:'ADD'
            },{
                actionType :'UPDATE',
                id:'UPDATE', 
                text:'UPDATE'
            },{
                actionType :'DELETE',
                id:'DELETE', 
                text:'DELETE'
            }]
        });
    };

    $scope.getEmployeeList();

});

