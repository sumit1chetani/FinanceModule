'use strict';
app.controller('usermasterViewCtrl', function($scope,$stateParams,$controller, ngDialog,$filter, $timeout, toaster, $injector, $rootScope, $http, $location, logger, utilsService, $state, sharedProperties, $window, validationService) {


    $scope.profileEdit = false;
    $scope.cancel = function() {
        $state.go('app.master.employee.employeeMaster',{tenantid:$stateParams.tenantid});    

    };
    $scope.employeeId = '';
    $scope.esicNoOld = '';
    $scope.epfNoOld = '';
    $scope.panNoOld = '';
    $scope.diffTwoDays = function(fromDate, toDate) {
        var oneDay = 24 * 60 * 60 * 1000;
        fromDate = fromDate.split("/");
        fromDate = new Date(fromDate[2], fromDate[1], fromDate[0]);
        toDate = toDate.split("/");
        toDate = new Date(toDate[2], toDate[1], toDate[0]);
        var diffDays = Math.round(Math.abs((fromDate.getTime() - toDate.getTime()) / (oneDay)));
        return diffDays;
    }
    $http.get($stateParams.tenantid+'/hrms/master/employeeAdminMaster/bloodgrouplist').success(function(data) {
        $scope.bloodgrouplist = data.bloodGroupList;
    });	
    // Added Newly

    $('#dob').datetimepicker({
        format : 'DD/MM/YYYY'
    })
    
     $('#relieveDate').datetimepicker({
        format : 'DD/MM/YYYY'
    })
    
     $http.get($stateParams.tenantid+'/customer/list').success(function(datas) {
        console.log(datas);
        $scope.customerdisplayedCollection = datas.list;
    	
        })
    
  //employeee changes
    $scope.EmployeeMasterDataProbation = {
        empId : '',
        frmProbation : '',
        extend : '',
        breakAny : false,
        toProbation : '',
        duration : '',
        frmBreakPro : '',
        toBreakPro : '',
        breakDuration : '',
        completion : '',
        empProbationId : ''
    }
    $scope.EmployeeMasterDataDoc = {
        empId : '',
        docName : '',
        description : '',
        uploadDoc : '',
        empDocId : ''
    }
    $scope.EmployeeMasterDataMerit = {
        empId : '',
        empMeritId : '',
        awardName : '',
        scholarshipName : '',
        meritDesc : ''
    }
    $scope.EmployeeMasterDataEx = {
        empId : '',
        empExpId : '',
        organization : '',
        experienceYear : '',
        expDesisnation : '',
        expRemarks : '',
        exFrom : '',
        exTo : ''
    }
    $scope.EmployeeMasterDataEdu = {
        empId : '',
        empEduId : '',
        qualification : '',
        percentage : '',
        courseType : '',
        institution : '',
        yearPassed : ''
    }
    $scope.EmployeeMasterDataFam = {
        empId : '',
        empFamilyId : '',
        familyName : '',
        genderType : '',
        relationshipWithEmp : '',
        empDependence : false,
        uploadPhotoFamily : ''
    }
    $scope.isPersonal = false;
    $scope.isAddress = false;
    $scope.isSave = false;
    $scope.isDocument = false;
    $scope.isPhysical = false;
    $scope.isOnLoad = false;

    $scope.employeeDuplicateEdit = [];
    $scope.rowCollectionHistory = [];
    $scope.displayedCollectionHistory = [];

  
    $scope.resetEdit=false;
    
    $scope.EmployeeMasterData = {
        uan : '',    
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
        fixedGross : 0.00,
        secondLevel : '',
        isActive : true,
        status : 'Y',
        isEmailExempted :'Y',
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
        reportMangrId : '',
        reportManagerName : '',
        typeOfEmp : '',
        category : '',
        principal : false,
        ms : false,
        empTypeName : '',
        relieveDate : '',
        epfNo : '',
        isPrimary : '',
        isEdit : false,
        insuranceNo : '',
        employmentDate : '',
        customerId : '',
        empUserId:'',
   	 createdBy:'',
 	modifiedBy:'',
 	 createdDate:'',
       modifiedDate:'',

    };

    $scope.date = '';

    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth() + 1; // January is 0!
    var yyyy = today.getFullYear();

    if (dd < 10) {
        dd = '0' + dd;
    }
    if (mm < 10) {
        mm = '0' + mm;
    }

    var today = dd + '/' + mm + '/' + yyyy;
    $scope.date = today;
    $scope.EmployeeMasterData.employmentDate = $scope.date;

    var tmpEmployeeMasterData = angular.copy($scope.EmployeeMasterData);
    $scope.EmployeeMasterDataPersonal = {
        // Profile Info
        aadharno :'',    
        empId : '',
        marritalStatus : '',
        guardianName : '',
        motherName : '',
        bloodGrp : '',
        caste : '',
        religion : '',
        motherTongue : '',
        nationality : '',
        panNo : '',
        gratuityNominee : '',
        nomineeRelation : '',
        modeConveyence : '',
        emgContactNo : '',
        emgContactName : '',
        noticePeriod : '',
        remarks : '',
        hobbies : '',
        confirmDate : '',
        resignationDate : '',
        languages : '',
        race : '',
        confirmationPeriod : '',
        husbWifeName : '',
        marriageDate : '',
        personalStatus : '',
        guardiansName : '',
    };
    var tmpEmployeeMasterDataPersonal = angular.copy($scope.EmployeeMasterDataPersonal);

    $scope.EmployeeMasterDataAddress = {
        // Address
        empId : '',
        permAddress : '',
        permPlace : '',
        permDistrict : '',
        permPin : '',
        permPhone : '',
        permState : '',
        permMobile : '',
        isActiveAddress : 'N',
        presentAddressMultiple : [],
    };
    var tmpEmployeeMasterDataAddress = angular.copy($scope.EmployeeMasterDataAddress);
    $scope.EmployeeMasterDataRule = {
        // Rule
        empId : '',
        overTime : false,
        esiApp : false,
        lateApp : false,
        pfApp : false,
        earlyExit : false,
        leaveOption : false,
        telephoneLimit : '',
        medicalLimit : '',
        noticePeriodRule : '',
    };
    var tmpEmployeeMasterDataRule = angular.copy($scope.EmployeeMasterDataRule);
    $scope.EmployeeMasterDataPhysical = {
        // Physical
        empId : '',
        isActiveSight : 'N',
        isActiveDumb : 'N',
        isActiveHearing : 'N',
        isActiveHand : 'N',
        isActiveFeet : 'N',
        isActiveWithGlass : 'N',
        height : '',
        weight : '',
        otherDisablity : '',
    };
    var tmpEmployeeMasterDataPhysical = angular.copy($scope.EmployeeMasterDataPhysical);
    $scope.EmployeeMasterDataPerDet = {
        // Document
        empId : '',
        accountNo : '',
        bankName : '',
        bankPlace : '',
        isActiveCash : 'N',
        passportNo : '',
        issuedDate : '',
        expiryDate : '',
        issuedPlace : '',
        licenseNo : '',
        licenseType : '',
        licenseIssuedDate : '',
        licenseexpiryDate : '',
        renewalDate : '',
        joinDocUpload : '',
        visaRefNo : '',
        visaType : '',
        visaExpiryDate : '',
        visaIssuedDate : '',
        visaIssuedPlace : ''
    };
    /*$scope.uploadPhoto = function(empId) {
		
		   debugger
		
		   $http.post($stateParams.tenantid+"/app/empmaster/uploadPhoto", empId).success(function(response) {

            var value = '';
            var doc = [];

            angular.forEach(response.fileList, function(value, key) {
                var url = value.doucumentUrl;
                doc.push(url);
            });
         
            if (response != null) {

                for (var i = 0; i < doc.length; i++) {
                	

        			$scope.fileUrl = doc[i];
        			
        			var profileImg =$scope.fileUrl[0];
        			
        			$scope.downloadFilePath = profileImg.split("/");
        			$scope.actualLength=$scope.downloadFilePath.length;
        			$scope.fileLength=$scope.actualLength - 1;
                    $scope.uploadPhoto = $scope.downloadFilePath[$scope.fileLength];
                    console.log($scope.uploadPhoto)

                    $("#downLoad").attr("href",'profileImg/'+$scope.uploadPhoto);
                    $("#downLoad").bind('click', function() {
                    });
                    $('#downLoad').simulateClick('click');
                }

                logger.logSuccess("Downloaded Succesfully!");
            } else {
                logger.logError("Failed to Download");
            }
        });
}
	*/

	
    
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
    
    $scope.checkPersonalInfoPANNo = function(panNo){
        if(panNo!=""){
            if(panNo!=$scope.panNoOld){
                $http.get($stateParams.tenantid+'/hrms/master/employeeAdminMaster/checkPersonalInfoPANNo?panNo=' + panNo).success(function(datas) {
                    if(datas!=0){
                        logger.logError('PAN No Already Exist!');
                        $scope.EmployeeMasterDataPersonal.panNo = '';
                    }
                }).error(function(datas) {
                });
            }
        }
    }
    
    $scope.checkESICNo=function(esic){
        var esicNo =  esic;
        esicNo = esicNo.replace(/ {2,}/g,' ');
        var esicNumber =  toUpper(esicNo);
        $scope.EmployeeMasterData.esic = esicNumber;
        
        if(!$scope.EmployeeMasterData.isEdit){
            if(esicNumber!=""){
                $http.get($stateParams.tenantid+'/hrms/master/employeeAdminMaster/checkESICNo?esic=' + esic).success(function(datas) {
                    if(datas!=0){
                        logger.logError('ESIC NO Already Exist!');
                        $scope.EmployeeMasterData.esic = '';
                    }
                }).error(function(datas) {
                });
            }
        }else{
            if(esicNumber!=$scope.esicNoOld){
                $http.get($stateParams.tenantid+'/hrms/master/employeeAdminMaster/checkESICNo?esic=' + esic).success(function(datas) {
                    if(datas!=0){
                        logger.logError('ESIC NO Already Exist!');
                        $scope.EmployeeMasterData.esic = '';
                    }
                }).error(function(datas) {
                });
            }
        }
        
    };
    
    $scope.checkEPFNo=function(epfNo){
        
        var epfNo =  epfNo;
        epfNo = epfNo.replace(/ {2,}/g,' ');
        var epfNumber =  toUpper(epfNo);
        $scope.EmployeeMasterData.epfNo = epfNumber;
        
        if(!$scope.EmployeeMasterData.isEdit){
            if(epfNumber!=""){
                $http.get($stateParams.tenantid+'/hrms/master/employeeAdminMaster/checkEPFNo?epfNo=' + epfNo).success(function(datas) {
                    if(datas!=0){
                        logger.logError('EPF No Already Exist!');
                        $scope.EmployeeMasterData.epfNo = '';
                    }
                }).error(function(datas) {
                });
            }
        }else{
            if(epfNumber!=$scope.epfNoOld){
                $http.get($stateParams.tenantid+'/hrms/master/employeeAdminMaster/checkEPFNo?epfNo=' + epfNo).success(function(datas) {
                    if(datas!=0){
                        logger.logError('EPF No Already Exist!');
                        $scope.EmployeeMasterData.epfNo = '';
                    }
                }).error(function(datas) {
                });
            }
        }
        
    };
    
    var tmpEmployeeMasterDataPerDet = angular.copy($scope.EmployeeMasterDataPerDet);
    $scope.EmployeeMasterData.companyCode;
    $scope.EmployeeMasterData.branch;
    $scope.EmployeeMasterData.reportToBranch;
    $scope.companyList = [];
    $scope.branchList = [];
    $scope.departmentList = [];
    $scope.designationList = [];
    $scope.divisionList = [];
    $scope.gradeList = [];
    $scope.reportToBranchList = [];
    $scope.reportToDeptList = [];
    $scope.reportToDesigList = [];
    $scope.reportToDesigList = [];
    $scope.reportToManagerList = [];

    $scope.empTypeList = [];
    $scope.imgfile = [];
    $scope.docfile = [];

    $scope.tabs = [ {
        title : 'Profile',
        name : 'Profile',
        active : true,
        index : 0
    }, {
        title : 'Personal Info',
        name : 'PersonalInfo',
        active : false,
        index : 1
    }, {
        title : 'Address',
        name : 'Address',
        active : false,
        index : 2
    }, {
        title : 'Family',
        name : 'Family',
        active : false,
        index : 3
    }, {
        title : 'Education',
        name : 'Education',
        active : false,
        index : 4
    }, {
        title : 'Experience',
        name : 'Experience',
        active : false,
        index : 5
    }, {
        title : 'Rule',
        name : 'Rule',
        active : false,
        index : 6
    }, {
        title : 'Personal Details',
        name : 'Personal Details',
        active : false,
        index : 7
    }, {
        title : 'Nomination',
        name : 'Nomination',
        active : false,
        index : 8
    }, {
        title : 'Merits',
        name : 'Merits',
        active : false,
        index : 9
    }, {
        title : 'Physical',
        name : 'Physical',
        active : false,
        index : 10
    }, {
        title : 'Emergency',
        name : 'Emergency',
        active : false,
        index : 11
    }, {
        title : 'Reference',
        name : 'Reference',
        active : false,
        index : 12
    }, {
        title : 'Documents',
        name : 'Documents',
        active : false,
        index : 13
    }, {
        title : 'History',
        name : 'History',
        active : false,
        index : 14
    }, {
        title : 'Driver Details',
        name : 'Driver Details',
        active : false,
        index : 15
    }, {
        title : 'Customer Details',
        name : 'Customer Details',
        active : false,
        index : 16
    }  ];

    
    $scope.truckdrivermodel = {
    	       truckName:'',
    	       truckId:'',
    	       driverName:'',
    	       driverId:'',
    	        fromDate:'',
    	        toDate:'',
    	        truckdriverId:''
    	        	
    	     };
    	;

    var editEmployeeID = $state.params.empId;
    // alert(editEmployeeID);
    $scope.employeeEdit = editEmployeeID;
    if (editEmployeeID == undefined) {
        $scope.EmployeeMasterData.isEdit === false;
    } else {

        $http.get($stateParams.tenantid+'/hrms/master/employeeAdminMaster/edit?empId=' + editEmployeeID).success(function(result) {
        	$scope.EmployeeMasterData.isEdit=true;
        	if (result.editList[0].isEdit == false) {
                logger.logError("Please Try Again");
            } else {
                console.log("Edit Result");
                console.log(result);
               // $scope.EmployeeMasterData.port = result.editList[0].portList;
                $scope.EmployeeMasterData = result.editList[0];
                $scope.EmployeeMasterData.companyCode = result.editList[0].companyCode;
                $scope.EmployeeMasterData.branchId = result.editList[0].branchId;
                if(result.editList[0].doj != null){
                	$scope.EmployeeMasterData.doj = result.editList[0].doj;	
                }else{
                	$scope.EmployeeMasterData.doj ='';
                }
                
                $scope.autogen = false;
                $scope.isEdit = true;
                $scope.profileEdit = true;
                $scope.resetEdit=true;
                $scope.vendorList=result.branchEditList;
                if(result.editList[0].vendor=='Y'){
                	$scope.agentid=true;
                	
                }
                $("#empid").prop('disabled', true);
                var managerID = result.editList[0].reportDesigId;
                $scope.EmployeeMasterData.isEdit = result.editList[0].isEdit;
                $scope.EmployeeMasterData = result.editList[0];
                $scope.employeeId = result.editList[0].empId;
                
                $http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(data) {
               	 
               	 $scope.portList = data.getportlist;
               	 
               	 $timeout(function() { 
               	 $("#port").multiselect({
               	 maxHeight : 400,
               	 includeSelectAllOption : true,
               	 selectAllText : 'Select All',
               	 enableFiltering : true,
               	 enableCaseInsensitiveFiltering : true,
               	 filterPlaceholder : 'Search',
               	 numberDisplayed: 1,
               	 });
               	 }, 3, false);
               	 $("#multiselect-button").addClass("width_100 input-sm line-height-5");
               	 
               	 $scope.compList = [];
               	 var valArr = result.editList[0].portCodes.split(',');
               	 var i = 0, size = valArr.length;
               	 for (i; i < size; i++) {
               	 $("#port").find("option[label=" + valArr[i] + "]").prop("selected", "selected");
               	 angular.forEach($scope.portList, function(value, key) {
               	 if (valArr[i] == value.id) {
               	 $scope.compList.push(value);
               	 }
               	 });
               	 
               	 $scope.EmployeeMasterData.port = $scope.compList;
               	 }
               	 
               	 });
                
               
                
                $scope.getDepartmentList($scope.EmployeeMasterData.companyCode);
                $scope.getDesignationList($scope.EmployeeMasterData.companyCode);
                $scope.EmployeeMasterData.employmentDate = $scope.date;
                
               
                

                var companyName = result.editList[0].companyName;
                var branchName = result.editList[0].branchName;
                var departmentName = result.editList[0].departmentCode;
                var designation = result.editList[0].designationName;
              

               

                if ($scope.profileEdit) {
                    $('#saveprofile').hide();
                    $("#updateprofile").removeClass("displaynone");
                    $('#updateprofile').show();
                    $("#employeeId").removeClass("displaynone");
                    $('#employeeId').show();
                    $("#pass").removeClass("displaynone");
                    $('#pass').show();
                } else {
                    $('#saveprofile').show();
                    $('#updateprofile').hide();
                    $('#employeeId').hide();
                    $('#pass').hide();
                }
              
               

               
                
                
                
                
                
                
                
               
            }
        }).error(function(data) {

        });

        
    
    }
 //Company List
    
    $scope.getCompanyList = function() {
        if(editEmployeeID == undefined){
            $http.get($stateParams.tenantid+'/hrms/master/employeeAdminMaster/getCompanyList').success(function(datas) {
                $scope.companyList = datas.companyList;
                
                var foundItemDest = $filter('filter')($scope.companyList, { id:  1 })[0];
      	         $scope.EmployeeMasterData.companyCode=foundItemDest.id;
      	         
                $scope.EmployeeMasterData.empId = datas.employeeId;
               // $scope.EmployeeMasterData.pwd = ';
                $scope.princpalList = datas.principalList;
                $scope.msList = datas.msList;
                $scope.principalCount = datas.principalCount;
                $scope.msCount = datas.msCount;
                
              
            })
            
        }
        else{
            $http.get($stateParams.tenantid+'/hrms/master/employeeAdminMaster/getCompanyList').success(function(datas) {
                $scope.companyList = datas.companyList;
                var foundItemDest = $filter('filter')($scope.companyList, { id:  1 })[0];
   	         $scope.EmployeeMasterData.companyCode=foundItemDest.id;
                
                $scope.EmployeeMasterData.empId = datas.employeeId;
                //$scope.EmployeeMasterData.pwd = 'password';
                $scope.princpalList = datas.principalList;
                $scope.msList = datas.msList;
                $scope.principalCount = datas.principalCount;
                $scope.msCount = datas.msCount;
                if (datas.companyList.length == 1) {
                    $scope.companyDrop = true;

                  
                    $scope.getDepartmentList($scope.EmployeeMasterData.companyCode);

                   
                } else {
                    $scope.companyDrop = false;
                }
              
            })
        }
        
    }
    $scope.getCompanyList();

    $scope.dropdown = false;

    $scope.password = 'password';
    $scope.textValue = 'Show';
 
    
  //DepartmentList 
  
    
    $scope.getDepartmentList = function(companyCode) {
        var myURL = $stateParams.tenantid+'/hrms/master/employeeAdminMaster/getDepartmentList';
        $http({
            method : 'post',
            url : myURL,
            data : companyCode,
        }).success(function(datas) {
            $scope.departmentList = datas.departmentList;
        });

    }

   $scope.getDepartmentList();

   //DesignationList
   
    $scope.getDesignationList = function(companyCode) {
        var myURL = $stateParams.tenantid+'/hrms/master/employeeAdminMaster/getDesignationList';
        $http({
            method : 'post',
            url : myURL,
            data : companyCode,
        }).success(function(datas) {
            $scope.designationList = datas.designationList;
        });

    }
    $scope.getDesignationList();

  //BranchList 
    
    $scope.$watch('EmployeeMasterData.companyCode', function(newValue, oldValue) {
        if (newValue != undefined && newValue != null && newValue != '') {
        	
                var companyCode = newValue;
                var url = $stateParams.tenantid+"/hrms/master/employeeAdminMaster/getBranch?&companyCode=" + companyCode;
                $http.get(url).success(function(datas) {
                   $scope.BranchListDetail = datas;
                }).error(function(data) {

                });
            	
            }else{
            	
            }
    });


   
   

});