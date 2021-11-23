'use strict';
app.controller('usermasterAddCtrl', function($scope,$stateParams,$controller, ngDialog, $filter ,$timeout, toaster, $injector, $rootScope, $http, $location, logger,$modal,$log, utilsService, $state, sharedProperties, $window, validationService) {


    $scope.profileEdit = false;
	$scope.isEdit=false;

    $scope.cancel = function() {
        $state.go('app.master.user.userMaster',{tenantid:$stateParams.tenantid});    

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

        
    $http.get($stateParams.tenantid+'/app/commonUtility/getCountryList').success(function(datas) {
              $scope.countryList = datas;
              }).error(function(datas) {
          });
        
        $http.post($stateParams.tenantid+'/app/seaquotation/getServicePartnerList').success(function(data) {
           	if(data){
           		
        //$scope.BranchListDetail=data.branchList;
           		$scope.vendorList=data.vendorMasterList;

           	}
           });
        $scope.agentid=false;
        //$scope.agent=function(id){
        //	if(id=='Y'){
        		$scope.agentid=true;
        		$scope.portList=[];
        	   	$scope.getportList=function(){
        	   	$http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(data) { 
        	   	debugger
        	   	$scope.portList = data.getportlist;
        	   	console.log("portList");
        	   	console.log( $scope.portList);
        	   	$timeout(function() {
        	    
        	    $("#port").multiselect({
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
        	/*}else{
        		$scope.agentid=false;
        		$scope.EmployeeMasterData.customerName="";
        	}*/
    	
    	
   // }
    
        	   	
        	   	
        	   	
        	   	
        	   	
        	   	
        	   	
        	   	
        	   	
        	   	
        		$scope.accessCatList=[];
        	   	$scope.getaccessCatList=function(){
        	   	$http.post($stateParams.tenantid+'/app/commonUtility/getAccessCategory').success(function(data) { 
        	   	debugger
        	   	$scope.accessCatList = data.commonUtilityBean;
        	   	console.log("accessCatList");
        	   	console.log( $scope.accessCatList);
        	   	$timeout(function() {
        	    
        	    $("#accessCat").multiselect({
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
        	   	
        	   	
        	   	
        	   	$scope.getaccessCatList();
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
        vendor : 'Y',
        customerName : ' ',
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
        branchId:'',
       // port: '',
    	
        files1:[],
    	 createdBy:'',
    	modifiedBy:'',
    	 createdDate:'',
          modifiedDate:'',
          userlocation :'',
    	
        country :'',
        port:[] ,
        accessCat :[] ,
        deptContact:''
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
        marritalStatus : 'true',
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

    
    
    		  
    
    
    $scope.getCustomerList=function(){
        $http.get($stateParams.tenantid+"/app/receipts/managereceipts/dropDownList").success(function(datas) {
            $scope.customerList = datas.customerList;
        })
    }
    $scope.getCustomerList(); 

   

    

    
    
    $rootScope.uploadFile = function(element) {
	     $scope.excelfile = element.files[0];
	 }
	 $scope.files1 = [];
    
    
    $scope.adduploadfiles1 = function() {
	     var obj = []

	     if ($scope.checkundefined($scope.excelfile)) {
	         logger.logError("Please select the file");
	     } else {
	         obj = $filter('filter')($scope.EmployeeMasterData.files1, {
	             filename : $scope.excelfile.name
	         }, true);
	     }

	     if (obj != undefined && obj.length > 0) {
	         logger.logError($scope.excelfile.name + " same file already added");
	     } else {
	         $scope.files1.push($scope.excelfile);
	         $scope.EmployeeMasterData.files1.push({
	             filename : $scope.excelfile.name,
	             filepath : '',
	             employeeId : ''
	         });

	     }
	 }
    
    
    
    
    
    $scope.checkundefined = function(value) {
        var invalid = false;
        if (value == undefined || value == 'undefined' || value == null || value == 'null' || value == '') {
            invalid = true;
        }
        return invalid;

    }
    

    
    
    
    
    $scope.downloadNewFile = function(id) {
        debugger;
        $("#tbnewExport" + id).bind('click', function() {
            // alert('clicked');

        });
        $("#tbnewExport" + id).simulateClick('click');
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
    
    
    
    
    
    
    
    
    
    
    
    
    // Current from Date
    
    var d = new Date();
    var year = d.getFullYear();
    var month = d.getMonth() + 1;
    if (month < 10) {
        month = "0" + month;
    }
    ;
    var day = d.getDate();
    $scope.dob = day + "/" + month + "/" + year;
    $scope.EmployeeMasterData.dob;

    // doj
    
    var d = new Date();
    var year = d.getFullYear();
    var month = d.getMonth() + 1;
    if (month < 10) {
        month = "0" + month;
    }
    ;
    var day = d.getDate();
    $scope.doj = day + "/" + month + "/" + year;
    
 //   $scope.EmployeeMasterData.doj = $scope.doj;

    

    // nomdateOfBirth
    var d = new Date();
    var year = d.getFullYear();
    var month = d.getMonth() + 1;
    if (month < 10) {
        month = "0" + month;
    }
    ;
    var day = d.getDate();
    $scope.nomdateOfBirth = day + "/" + month + "/" + year;
    $scope.EmployeeMasterData.nomdateOfBirth = null;

    $scope.secEmpList = [];
    $scope.princpalList = [];
    $scope.msList = [];
    $scope.autogen = true;
    $scope.companyDrop = false;
    
    
    //Company List
    
    $scope.getCompanyList = function() {
        if(editEmployeeID == undefined){
            $http.get($stateParams.tenantid+'/hrms/master/userAdminMaster/getCompanyList').success(function(datas) {
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
            $http.get($stateParams.tenantid+'/hrms/master/userAdminMaster/getCompanyList').success(function(datas) {
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
        var myURL = $stateParams.tenantid+'/hrms/master/userAdminMaster/getDepartmentList';
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
        var myURL = $stateParams.tenantid+'/hrms/master/userAdminMaster/getDesignationList';
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
                var url = $stateParams.tenantid+"/hrms/master/employeeAdminMaster/getBranchList",companyCode;
                $http.post(url).success(function(datas) {
                   $scope.BranchListDetail = datas.branchList;
                }).error(function(data) {

                });
            	
            }else{
            	
            }
    });

    // Validation
    
    $scope.validateProfile = function(form, EmployeeMasterData) {
        if (new validationService().checkFormValidity(form)) {
            var flag1=true;
            if(EmployeeMasterData.mobileNo!=undefined && EmployeeMasterData.mobileNo!=null && EmployeeMasterData.mobileNo!=''){
            }
           
            if(flag1==true){
                if (!$scope.isEdit) {
                    $scope.saveProfile(form, EmployeeMasterData);
                } else {
                    $scope.updateProfileDet(form, EmployeeMasterData);
                }
            }else{
                logger.logError("Please Enter Valid Mobile Number")
            }
           
        } else {
            toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(form.$validationSummary), 5000, 'trustedHtml');
        }
    };
    
    
   // Save
    
    $scope.saveProfile = function(form, EmployeeMasterData) {
        
        var indexValue = $filter('filter')($scope.tabs, {
            active : true
        })[0];
        var index = $scope.tabs.indexOf(indexValue);
        var activeVal = $filter('filter')($scope.tabs, {
            active : true
        })[0].index;
        $scope.showLabel = $scope.tabs[activeVal].name;

        if (new validationService().checkFormValidity(form)) {
            var flag = true;
            var flag1=true;
            if (EmployeeMasterData.emailId != undefined && EmployeeMasterData.emailId != null && EmployeeMasterData.emailId != '') {
               
                flag = $scope.validateEmail(EmployeeMasterData.emailId);
            }
            if(EmployeeMasterData.mobileNo!=undefined && EmployeeMasterData.mobileNo!=null && EmployeeMasterData.mobileNo!=''){
            }
           
          
            if (flag == true && flag1==true) {

                

                var companyName = $("#companyCode option:selected").text();
                var branchName = $("#branch option:selected").text();
                var departmentName = $("#departmentId option:selected").text();
                var designation = $("#designation option:selected").text();
              

            	var payerCode = "";
            	if($scope.EmployeeMasterData.port!=null){
            		 angular.forEach($scope.EmployeeMasterData.port, function(item, key) {
                         if (payerCode == "") {
                         payerCode = item.id;
                         } else {
                         payerCode += "," + item.id;
                         }
                         $scope.EmployeeMasterData.portCodes = payerCode;
                         });
            	}else{
            		$scope.EmployeeMasterData.portCodes='';
            	}
            

            	if($scope.EmployeeMasterData.port == '' || $scope.EmployeeMasterData.port == null){
            		$scope.EmployeeMasterData.port=[];
            	}    
                
            	
            	
            	


            	var accesscategoryCode = "";
            	if($scope.EmployeeMasterData.accessCat!=null){
            		 angular.forEach($scope.EmployeeMasterData.accessCat, function(item, key) {
                         if (accesscategoryCode == "") {
                        	 accesscategoryCode = item.id;
                         } else {
                        	 accesscategoryCode += "," + item.id;
                         }
                         $scope.EmployeeMasterData.accesscodes = accesscategoryCode;
                         });
            	}else{
            		$scope.EmployeeMasterData.accesscodes='';
            	}
            

            	if($scope.EmployeeMasterData.accessCat == '' || $scope.EmployeeMasterData.accessCat == null){
            		$scope.EmployeeMasterData.accessCat=[];
            	}    
                
               
                    
                	$http.post($stateParams.tenantid+'/hrms/master/userAdminMaster/save', $scope.EmployeeMasterData).success(function(result) {
                        if(result.status!=302){
                        if (result.success == true) {
                        	
                        	 if ($scope.files1.length > 0) {
    		                     angular.forEach($scope.files1, function(files1, index) {
    		                         var frmData = new FormData();
    		                         frmData.append("file1", files1);
    		                         frmData.append("employeeId", result.employeeId);
    		                         $.ajax({
    		                             type : "POST",
    		                             url : $stateParams.tenantid+"/hrms/master/userAdminMaster/saveuploadfile1",
    		                             data : frmData,
    		                             contentType : false,
    		                             processData : false,
    		                             success : function(result) {}
    		                         });
    		                     });

    		                }
                            $scope.EmployeeMasterData.empId = result.employeeId;
                            $scope.employeeId = result.employeeId;
                            
                            $scope.profileEdit = true;
                            logger.logSuccess("Saved Successfully!");
                            ngDialog.open({
                                template : 'employeeConfirm',
                                scope : $scope
                            });

                        } else {
                            logger.logSuccess("Error in Save");
                           ngDialog.open({
                                template : 'employeeConfirm',
                                scope : $scope
                            });
                           
                        }
                        }else{
                            logger.logError("User Id or Email Id already exist!");
                        }
                    });
                    
                
                
            } else {
                if(flag==false){
                    logger.logError("Please Enter Valid Email Id");
                }if(flag1==false){
                    logger.logError("Please Enter Valid Mobile No");
                }
                
            }

        } else {
            toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(form.$validationSummary), 5000, 'trustedHtml');
        }
    };
    
    
    //Popup After save
    
    $scope.employeeConfirm = function() {
        ngDialog.close();
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
        $state.go('app.master.user.userMaster',{tenantid:$stateParams.tenantid});
    };
   

    // Edit
    

    var editEmployeeID = $state.params.empId;
    
    $scope.employeeEdit = editEmployeeID;
    if (editEmployeeID == undefined) {
        $scope.EmployeeMasterData.isEdit = false;
    } else {
        $http.get($stateParams.tenantid+'/hrms/master/userAdminMaster/edit?empId=' + editEmployeeID).success(function(result) {
        	$scope.EmployeeMasterData.isEdit=true;
        	if (result.editList[0].isEdit == false) {
                logger.logError("Please Try Again");
            } else {
                console.log("Edit Result", result);
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
               	 $scope.compList = [];
               	 var valArr = result.editList[0].portCodes.split(',');
               	 var i = 0, size = valArr.length;
               	 for (i; i < size; i++) {
               	// $("#port").find("option[label=" + valArr[i] + "]").prop("selected", "selected");
               	 angular.forEach($scope.portList, function(value, key) {
               	 if (valArr[i] == value.id) {
               	 $scope.compList.push(value);
               	 }
               	 });
               	  
               	 }
               	$scope.EmployeeMasterData.port = $scope.compList;
               	 $timeout(function() { 
               		 $("#port").multiselect('destroy');
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
               	 
               	
               	 
               	 });
                
               
                
                

                $http.post($stateParams.tenantid+'/app/commonUtility/getAccessCategory').success(function(data) {
            	  $scope.accessCatList = data.commonUtilityBean;
               	 
               	 $scope.compaccList = [];
               	 var valArr = result.editList[0].accesscodes.split(',');
               	 var i = 0, size = valArr.length;
               	 for (i; i < size; i++) {
               	// $("#port").find("option[label=" + valArr[i] + "]").prop("selected", "selected");
               	 angular.forEach($scope.accessCatList, function(value, key) {
               	 if (valArr[i] == value.id) {
               	 $scope.compaccList.push(value);
               	 }
               	 });
               	  
               	 }
               	$scope.EmployeeMasterData.accessCat = $scope.compaccList;
               	 $timeout(function() { 
               		 $("#accessCat").multiselect('destroy');
               	 $("#accessCat").multiselect({
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
    
    
    //Update
    
    $scope.updateProfileDet = function(form, EmployeeMasterData) {
        var flag = true;
        var flag1=true;
        EmployeeMasterData.empId = $scope.employeeId;

        if (new validationService().checkFormValidity(form)) {
            if (EmployeeMasterData.emailId != undefined && EmployeeMasterData.emailId != null && EmployeeMasterData.emailId != '') {
                flag = $scope.validateEmail(EmployeeMasterData.emailId);
            } if(EmployeeMasterData.mobileNo!=undefined && EmployeeMasterData.mobileNo!=null && EmployeeMasterData.mobileNo!=''){
            }
           
          
            if (flag == true && flag1==true) {

                var companyName = $("#companyCode option:selected").text();
                var columnCompany = "Hospital Name";
                var branchName = $("#branch option:selected").text();
                var columnBranch = "Branch";
                var departmentName = $("#departmentId option:selected").text();
                var columnDepartment = "Department";
                var designation = $("#designation option:selected").text();
                var columnDesignation = "Designation";
                var division = $("#division option:selected").text();
                var columnDivsion = "Divsion";
                var grade = $("#grade option:selected").text();
                var columnGrade = "Grade";
                var reportToBranch = $("#reportToBranch option:selected").text();
                var columnReportToBranch = "Report To Branch";
                var reportDeptName = $("#reportDeptId option:selected").text();
                var columnReportToDepartment = "Report To Department";
                var reportMangrId = $scope.EmployeeMasterData.reportMangrId;
                var reportMangrName = $("#reportMangrId option:selected").text();
                var columnReportingAuthority = "Reporting Authority";
                var reportDesigName = $("#reportDesigId option:selected").text();
                var columnReportToDesignation = "Report To Designation";
                var typeOfEmp = $("#typeOfEmp option:selected").text();
                var columnTypeOfEmployment = "Type Of Employment";
                
                angular.forEach($scope.employeeDuplicateEdit, function(value, key) {
                    if (value.columnName == columnCompany) {
                        if (value.oldValue != companyName) {
                            value.active = true;
                            value.newValue = companyName;
                        }
                    }
                    if (value.columnName == columnBranch) {
                        if (value.oldValue != branchName) {
                            value.active = true;
                            value.newValue = branchName;
                        }
                    }
                    if (value.columnName == columnDepartment) {
                        if (value.oldValue != departmentName) {
                            value.active = true;
                            value.newValue = departmentName;
                        }
                    }
                    if (value.columnName == columnDesignation) {
                        if (value.oldValue != designation) {
                            value.active = true;
                            value.newValue = designation;
                        }
                    }
                    if (value.columnName == columnDivsion) {
                        if (value.oldValue != division) {
                            value.active = true;
                            value.newValue = division;
                        }
                    }
                    if (value.columnName == columnGrade) {
                        if (value.oldValue != grade) {
                            value.active = true;
                            value.newValue = grade;
                        }
                    }
                    if (value.columnName == columnReportToBranch) {
                        if (value.oldValue != reportToBranch) {
                            value.active = true;
                            value.newValue = reportToBranch;
                        }
                    }
                    if (value.columnName == columnReportToDepartment) {
                        if (value.oldValue != reportDeptName) {
                            value.active = true;
                            value.newValue = reportDeptName;
                        }
                    }
                    if (value.columnName == columnReportingAuthority) {
                        if (value.oldValue != reportMangrName.trim()) {
                            value.active = true;
                            value.newValue = reportMangrName;
                        }
                    }
                    if (value.columnName == columnReportToDesignation) {
                        if (value.oldValue != reportDesigName) {
                            value.active = true;
                            value.newValue = reportDesigName;
                        }
                    }
                    if (value.columnName == columnTypeOfEmployment) {
                        if (value.oldValue != typeOfEmp) {
                            value.active = true;
                            value.newValue = typeOfEmp;
                        }
                    }
                });
                
                $scope.EmployeeMasterData.employeeDuplicateList = $scope.employeeDuplicateEdit;
                console.log("update Profile data")
                var payerCode = "";
                if($scope.EmployeeMasterData.port!=null && $scope.EmployeeMasterData.port!=''){
                if($scope.EmployeeMasterData.port.length>0){
                	 angular.forEach($scope.EmployeeMasterData.port, function(item, key) {
                         if (payerCode == "") {
                         payerCode = item.id;
                         } else {
                         payerCode += "," + item.id;
                         }
                         $scope.EmployeeMasterData.portCodes = payerCode;
                         });
                }}else{
                	$scope.EmployeeMasterData.portCodes='';
                }
            
                if($scope.EmployeeMasterData.port == '' || $scope.EmployeeMasterData.port == null){
                	$scope.EmployeeMasterData.port=[];
                }
                
                



            	var accesscategoryCode = "";
            	if($scope.EmployeeMasterData.accessCat!=null && $scope.EmployeeMasterData.accessCat!=''){
            	if($scope.EmployeeMasterData.accessCat.length>0){
            		 angular.forEach($scope.EmployeeMasterData.accessCat, function(item, key) {
                         if (accesscategoryCode == "") {
                        	 accesscategoryCode = item.id;
                         } else {
                        	 accesscategoryCode += "," + item.id;
                         }
                         $scope.EmployeeMasterData.accesscodes = accesscategoryCode;
                         });
            	}}else{
            		$scope.EmployeeMasterData.accesscodes='';
            	}

            

            	if($scope.EmployeeMasterData.accessCat == '' || $scope.EmployeeMasterData.accessCat == null){
            		$scope.EmployeeMasterData.accessCat=[];
            	}    
                
               
                
                 console.log("Update Usermaster data",$scope.EmployeeMasterData);
                
                   
                        $http.post($stateParams.tenantid+'/hrms/master/userAdminMaster/updateProfile', EmployeeMasterData).success(function(result) {
                            editEmployeeID = EmployeeMasterData.empId;
                            debugger;
                            if (result == true) {
                            	

                           	 if ($scope.files1.length > 0) {
       		                     angular.forEach($scope.files1, function(files1, index) {
       		                         var frmData = new FormData();
       		                         frmData.append("file1", files1);
       		                         frmData.append("employeeId", EmployeeMasterData.empId);
       		                         $.ajax({
       		                             type : "POST",
       		                             url : $stateParams.tenantid+"/hrms/master/userAdminMaster/saveuploadfile1",
       		                             data : frmData,
       		                             contentType : false,
       		                             processData : false,
       		                             success : function(result) {}
       		                         });
       		                     });

       		                }
                                logger.logSuccess("Updated Successfully!");
                                $state.go('app.master.user.userMaster', {
                                    empId : editEmployeeID
                                });
                            } else {
                                logger.logError("Not Saved or user id already exist!");
                            }
                          
                        });
                    
                
                
            } else {
                if(flag==false){
                    logger.logError("Please Enter Valid Email Id");
                }if(flag1==false){
                    logger.logError("Please Enter Valid Mobile No");
                }
            }
        } else {
            toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(form.$validationSummary), 5000, 'trustedHtml');
        }

    }
    
   
    $scope.validateEmail = function(email) {
        var reg = /^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/
        if (reg.test(email)) {
            return true;
        } else {
            // logger.logError("Please Enter Valida Email Address");
            return false;
        }
    }

    

       
   
    $scope.checkValidation = function() {

	  	    var alertmsg = "<ui><h4>Please fill the required fields</h4>";
	  	    var msg = "";
	  	  /*  if ($scope.checkundefined($scope.quotation.commodity)) {
	  	        msg = msg + "<li>Commodity:Field is required.</li>";         
	  	        $scope.changecolor('commodity');
	  	    }else{
	  	    	$scope.clearcolor('commodity');
	  	    }*/
	  	    if ($scope.checkundefined($scope.EmployeeMasterData.firstName)) {
	  	        msg = msg + "<li>firstName:Field is required.</li>";         
	  	        $scope.changecolor('firstName');
	  	    }else{
	  	    	$scope.clearcolor('firstName');
	  	    }
	  	    if ($scope.checkundefined($scope.EmployeeMasterData.emailId)) {
	  	        msg = msg + "<li>emailId:Field is required.</li>";         
	  	        $scope.changecolor('emailId');
	  	    }else{
	  	    	$scope.clearcolor('emailId');
	  	    }
	  	    if ($scope.checkundefined($scope.EmployeeMasterData.mobileNo)) {
	  	        msg = msg + "<li>mobileNo:Field is required.</li>";         
	  	        $scope.changecolor('mobileNo');
	  	    }else{
	  	    	$scope.clearcolor('mobileNo');
	  	    }
	  	    if ($scope.checkundefined($scope.EmployeeMasterData.pwd)) {
	  	        msg = msg + "<li>pwd:Field is required.</li>";         
	  	        $scope.changecolor('pwd');
	  	    }else{
	  	    	$scope.clearcolor('pwd');
	  	    }
	  	    /*if ($scope.checkundefined($scope.EmployeeMasterData.doj)) {
	  	        msg = msg + "<li>doj:Field is required.</li>";         
	  	        $scope.changecolor('doj');
	  	    }else{
	  	    	$scope.clearcolor('doj');
	  	    }*/
	  	  if ($scope.checkundefined($scope.EmployeeMasterData.companyCode)) {
	  	        msg = msg + "<li>companyCode:Field is required.</li>";         
	  	        $scope.changecolor('companyCode');
	  	    }else{
	  	    	$scope.clearcolor('companyCode');
	  	    }
	  
	  	 alertmsg = alertmsg + msg + "</ui>";
  	    if ($scope.checkundefined(msg)) {
  	        return '';
  	    } else {
  	        return alertmsg;
  	    }
   }
   

    $scope.validateNumberChar = function(numberchar) {
        var regex = new RegExp("^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$");
        if (regex.test(numberchar)) {
            return true;
        } else {
            return false;
        }
    }

    
    

  
    
    
  
    
    
   
   
    
    
   
   
    
    
   
    
    

   
    $scope.resetProfile = function(frmProfile) {
        if ($scope.EmployeeMasterData.isEdit == false) {
            $scope.EmployeeMasterData = angular.copy(tmpEmployeeMasterData);
        } else {
        	$scope.isEdit=true
            

            $http.get($stateParams.tenantid+'/hrms/master/userAdminMaster/edit?empId=' + editEmployeeID).success(function(result) {
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
                    
                   
                    
                    /*$scope.getDepartmentList($scope.EmployeeMasterData.companyCode);
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
                  
                   */

                   
                    
                    
                    
                    
                    
                    
                    
                   
                }
            }).error(function(data) {

            });

            
        
        	
        }
    }
    
    
    
    
    
    
    
    
    

});
app.controller('empmasterUpdateCtrl', function($scope, toaster,$stateParams, $injector, $rootScope, $http, $location, logger, utilsService, $state, sharedProperties, $window, validationService,$timeout) {

	 $scope.empmasterData = {
		        profileImg : '',
		        olpwd:'',
		        pswd : '',
		        newpswd : '',
		        confrmPwd : ''
		    };

		    $scope.cancel = function() {
		        $location.path("{tenantid}/dashboard/dashboard");
		    };

		    $scope.selectFile = function(element) {
		        $scope.uplFile = element.files[0];
		    }

		    $scope.save = function() {
		        var uplFile = $scope.uplFile;
		        var fileExtension = uplFile.name;
		        var fName = [];
		        fName = fileExtension.split(".");
		        var frmData = new FormData();
		        frmData.append("file", uplFile);
		        $.ajax({
		            type : "POST",
		            url : $stateParams.tenantid+"/app/empmaster/userdetail",
		            data : frmData,
		            contentType : false,
		            processData : false,
		            success : function(result) {
		                if (result.success) {
		                    logger.logSuccess("File Uploaded Successfully");
		                    $scope.empmasterData.profileImg = result.empmasterBean.profileImg;
		                } else {
		                    logger.logError("Fail to Upload");
		                }
		            }
		        });
		    };
		    
		    if(parseInt(localStorage.getItem('getLoginDateDiff'))>30)
		        $rootScope.visibility=false;
		    

		    $scope.getData = function(empmasterForm, empmasterData, empmasterValidateData) {
		        $http.get($stateParams.tenantid+'/app/empmaster/userdetails').success(function(result) {
		            debugger;
		            $scope.empmasterData = result;

		        }).error(function(data) {
		            console.log("data" + data);
		        });
		    };
		    $scope.getData();

		    // Password Change

		    $scope.changePassword = function() {
		        if ($scope.empmasterData.newpswd != undefined && $scope.empmasterData.confrmPwd != undefined && $scope.empmasterData.newpswd != '' && $scope.empmasterData.confrmPwd != '' && $scope.empmasterData.newpswd !== null && $scope.empmasterData.confrmPwd !== null) {
		            $http.post($stateParams.tenantid+'/app/empmaster/pswdUpdate', $scope.empmasterData).success(function(data) {
		                if (data.success) {
		                    logger.logSuccess("New Password Updated Successfully!");
//		                    $location.path("{tenantid}/dashboard/dashboard");
//		                    $location.path("/login");
		                    var url = window.location.href.split("#");
		                    $timeout(function () {
		                        if(parseInt(localStorage.getItem('getLoginDateDiff'))>30){
		                            $rootScope.visibility=true;
		                            localStorage.setItem('getLoginDateDiff',0);
		                        }
		                        window.open(url[0]+"logout", '_self');
		                    }, 2000);
		                    
		                } else {
		                    logger.logError(data.message);
		                }
		            }).error(function(data) {
		                console.log("data" + data);
		            });
		        } else {
		            logger.logError("Please Fill the Fields.");
		        }
		    }

});




