'use strict';
app.controller('leavedeclarationEditCtrl', function($scope, $state, $http,  ngDialog, logger, $injector,
		sharedProperties, toaster, $rootScope, validationService,$stateParams) {
	alert(2);
	var gradeId = $stateParams.gradeId;

	var year = $stateParams.year;

	$scope.leaveDeclareObj = {
	    companyName : '',
	    companyId : '',
	    gradeId : '',
	    year : '',
	    isEdit : false

	}
	
	$scope.gradeTypeList = [];
	$scope.gradeList = [];

	 $scope.getCompanyList = function() {
	        var formCode = document.getElementById('formCode').value;
	        $http.post($stateParams.tenantid+'/app/commonUtility/getCompanyList', formCode).success(function(response) {
	            $scope.companyList = response;
	            if ($scope.companyList.length == 1) {
	                $scope.leaveDeclareObj.companyId = $scope.companyList[0].id;
	                $scope.disable = true;

	            }
	        })
	    }
	    $scope.getCompanyList();

	// GradeDropDown
	$scope.getGradeList = function(companyId) {

	    $http.post($stateParams.tenantid+'/finance/leave/gradeList', companyId).success(function(datas) {
	        $scope.gradeList = datas.gradeList;
	    }).error(function(data) {

	    });

	}
	$scope.reset = function() {
	    $scope.leaveDeclareObj.gradeId = ''
	    $scope.leaveDeclareObj.year = ''
	    $scope.gradeTypeList = []
	    var url = $stateParams.tenantid+'/finance/leave/getEditList?gradeId=' + gradeId + '&year=' + year;
	    $http.get(url).success(function(result) {
	        $scope.gradeTypeList = result.gradeTypeList;
	        $scope.leaveDeclareObj.gradeId = result.leaveDeclareObj.gradeId;
	        $scope.leaveDeclareObj.year = result.leaveDeclareObj.year;
	        $scope.leaveDeclareObj.isEdit = result.leaveDeclareObj.isEdit;
	        $scope.leaveDeclareObj.isEdit = true;

	    });
	}

	var url = $stateParams.tenantid+'/finance/leave/getEditList?gradeId=' + gradeId + '&year=' + year;
	$http.get(url).success(function(result) {
	    console.log(result);
	    $scope.gradeTypeList = result.gradeTypeList;
	    $scope.leaveDeclareObj.gradeId = result.leaveDeclareObj.gradeId;
	    $scope.leaveDeclareObj.year = result.leaveDeclareObj.year;
	    $scope.leaveDeclareObj.isEdit = result.leaveDeclareObj.isEdit;
	    $scope.leaveDeclareObj.companyName='INTER AFRICA';

	    $scope.getCompanyList();
	    $scope.getGradeList();

	    $scope.leaveDeclareObj.isEdit = true;
	    $scope.checked = true;

	});


	// onchange
	$scope.change = function() {

	    var gradeid = $scope.leaveDeclareObj.gradeId;

	    var yearId = $scope.leaveDeclareObj.year;

	    var url = $stateParams.tenantid+'/finance/leave/getType?gradeid=' + $scope.leaveDeclareObj.gradeId + '&yearId=' + $scope.leaveDeclareObj.year;

	    $http.get(url).success(function(datas) {
	        $scope.gradeTypeList = datas.gradeTypeList;

	    });
	}

	$scope.update = function(leaveDeclareObj, leaveDeclarationAddForm) {
	    sharedProperties.clearObject();
	    if (new validationService().checkFormValidity($scope.leaveDeclarationAddForm)) {
	        var data = {
	            'gradeTypeList' : $scope.gradeTypeList,
	            'leaveDeclareObj' : $scope.leaveDeclareObj

	        }

	        $http.post($stateParams.tenantid+'/finance/leave/add', data).success(function(result) {
	            if (result) {
	                logger.logSuccess("Update Successfully!");
	                $state.go('app.hr.leavedeclaration.list');
	            } else {
	                logger.logError(" Already Exists!");
	            }
	        })

	    } else {
	        toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(leaveDeclarationAddForm.$validationSummary), 555000, 'trustedHtml');
	    }

	}

	$scope.cancel = function() {
	    $state.go('app.hr.leavedeclaration.list');
	}
	});