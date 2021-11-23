'use strict';
app.controller('empmasterViewCtrl', function($scope,$stateParams,$controller, ngDialog,$filter, $timeout, toaster, $injector, $rootScope, $http, $location, logger, utilsService, $state, sharedProperties, $window, validationService) {


	$scope.rowCollectionsettle =[];
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
    $scope.$watch('EmployeeMasterData.doj', function(newValue, oldValue) {
        if ($scope.EmployeeMasterData.dob == '' && newValue != undefined && newValue != '') {
            logger.logError("Please Enter DOB!");
            $scope.EmployeeMasterData.doj = "";
        }else{
            if (newValue != undefined && newValue != '' && $scope.EmployeeMasterData.dob != '') {
                var dob = $scope.EmployeeMasterData.dob;
                var doj = newValue;
                var oneDay = 24 * 60 * 60 * 1000;
                var dojDate = newValue;
                var dobDate = $scope.EmployeeMasterData.dob;
                dojDate = dojDate.split("/");
                dojDate = new Date(dojDate[2], dojDate[1] - 1, dojDate[0]);
                dobDate = dobDate.split("/");
                dobDate = new Date(dobDate[2], dobDate[1] - 1, dobDate[0]);
                if(dobDate < dojDate){
                    var todayDate = $scope.currentDate;
                    todayDate = todayDate.split("/");
                    todayDate = new Date(todayDate[2], todayDate[1] - 1, todayDate[0]);
                    if(dojDate <= todayDate){
                        var diffDays = Math.round(Math.abs((dobDate.getTime() - dojDate.getTime()) / (oneDay)));
                        if (parseInt(diffDays) < 6205) {
                            logger.logError("Invalid Date of Joining!");
                            $scope.EmployeeMasterData.doj = "";
                        }
                    }else{
                        logger.logError("Invalid Date of Joining!");
                        $scope.EmployeeMasterData.doj = "";
                    }
                  
                }else{
                    logger.logError("DOB should be lesser than the DOJ");
                    $scope.EmployeeMasterData.dob = "";
                
                }
               
            }
        }
        
    });
    
    
    $scope.rowCollectionaircliams  =[];
    $scope.displayedCollectionaircliams =[];
  //employeee changes
    $scope.displayedCollectionLeave =[];
    $scope.rowCollectionLeave =[];
    $scope.rowCollectionpay =[];
    $scope.rowCollectioncontract =[];
    
    $scope.displayedCollectioncontract  =[];
    $scope.displayedCollectionpay =[];
    $scope.EmployeeMasterDataLeave = {
            empId : '',
            leaveType : '',
            fromdate : '',
            todate : '',
            noDays : ''
        }
    
    
    
    $scope.EmployeeMasterDatacontract = {
            empId : '',
            leaveType : '',
            fromdate : '',
            todate : '',
            noDays : ''
        }
    
    $scope.EmployeeMasterDataPayd = {
            empId : '',
            changeType : '',
            effectivedate : '',
            comments : '',
            status:'',
            executed:'',
        }
    
    $scope.EmployeeMasterDatapassport = {
            
            empId : '',
            passrequestDate : '',
            passrequestcomments : '',
            passrequestType : '',
           
         
        };
    
    

    $scope.EmployeeMasterDataSettle = {
            // Address
            empId : '',
            settleType : '',
            settlelastDate : '',
            settleCurrency : '',
            settlecomments : '',
       
         
        };
    
    
    
    $scope.EmployeeMasterDataforms = {
            empId : '',
            formreviewType:'',
            formreviewDate:'',
            formsreviewcomments:'',
            formreviewtemplete:''
        }
    
   $scope.EmployeeMasterDataLoan = {
            
            empId : '',
            loanType : '',
            applicationdate : '',
            RepaystartDate : '',
            loanAmount :'',
            paid :'',
         
        };
   
   $scope.EmployeeMasterDatalere = {
           
           empId : '',
         letterReqId: '',
	 addressletter: '',
	letterPurpose: '',
	description: '',
	 letterStatus: '',
	 letterapproveDate: '',
	 letterreqDate: '',
	 letterIssueDate: '',
	 adminstatusLetter: '',
        
       };
    
   
    $scope.displayedCollectionPassport =[];
    
    $scope.rowCollectionPassport =[];
    
    
    
    
    

    $scope.EmployeeMasterDataAircliams = {
            // Address
            empId : '',
            ticksec : '',
            airclass : '',
            airselftick : '',
            airselftickAmt : '',
            airadulttick : '',
            airadulttickAmt : '',
            airdueDate : '',
            airChildtick : '',
            airChildtickAmt : '',
            airinfanttick : '',
            airinfanttickAmt : '',
            airclaimcomments : '',
         
        };

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
        	  country :'',
              fatherName :'',
              socialNo :'',
              incometaxNo :'', 
              faxName :'',
              profitCenter :'',
              unit :'',
              appraisalone :'',
              momcyName :'',
              appraisalfinal :'',
              citizen : '',
              othercitizen :'',
              homedesti : '',
              airticketclass : '',
              probationperiod :'',
              noticeperiod :'',
              workcalender :'',
              upic:'',
              confirmationDate:'',
    };
    

    $scope.EmployeeMasterDataPayRollBank = {
            // Address
            empId : '',
            paybankname : '',
            paybankacctName : '',
            iban : '',
            paybankBranch : '',
            payAcctNum : '',
            paycomments : '',
         
        };
    
    

    $scope.EmployeeMasterDataSettle = {
            // Address
            empId : '',
            settleType : '',
            settlelastDate : '',
            settleCurrency : '',
            settlecomments : '',
       
         
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
        expiryDate : '',issueDate:'',
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
    
    $scope.displayedCollectiontravel=[];
    $scope.rowCollectiontravel =[];
    
    $scope.EmployeeMasterDatatravel = {
            empId : '',
            travelrequestcode : '',
            travelType : '',
            travelrequestDate : '',
            travelStatus : '',
            status : ''
        }
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
   $scope.displayedCollectionlere =[];
   $scope.rowCollectionlere =[];
    $scope.empTypeList = [];
    $scope.imgfile = [];
    $scope.docfile = [];

    $scope.tabs = [ {
        title : 'Profile',
        name : 'Profile',
        active : true,
        index : 0
    }, {
        title : 'Personal & Contractual Info',
        name : 'Personal & Contractual Info',
        active : false,
        index : 1
    },
    {
        title : 'Contractual Change',
        name : 'Contractual Change',
        active : false,
        index : 2
    },
   
    {
        title : 'Compensation',
        name : 'Compensation',
        active : false,
        index : 3
    },
    {
        title : 'Payroll Deductions',
        name : 'Payroll Deductions',
        active : false,
        index : 4
    } 
    ,
    {
        title : 'Payroll Bank Accounts',
        name : 'Payroll Bank Accounts',
        active : false,
        index : 5
    },
    
    {
        title : 'Leave Application',
        name : 'Leave Application',
        active : false,
        index : 6
    },

    {
        title : 'Air Ticket Claims',
        name : 'Air Ticket Claims',
        active : false,
        index : 7
    } ,
    {
        title : 'Employee Docs',
        name : 'Employee Docs',
        active : false,
        index : 8
    }, 
    {
        title : 'Family Members',
        name : 'Family Members',
        active : false,
        index : 9
    },
    {
        title : 'Letter Request',
        name : 'Letter Request',
        active : false,
        index : 10
    },
    {
        title : 'Loan And Advances',
        name : 'Loan And Advances',
        active : false,
        index : 11
    } ,
    {
        title : 'Address Book',
        name : 'Address Book',
        active : false,
        index : 12
    }, {
        title : 'Qualification & Training',
        name : 'Qualification & Training',
        active : false,
        index : 13
    },
    
    {
        title : 'Travel History',
        name : 'Travel History',
        active : false,
        index : 14
    }
    ,{
        title : 'Passport Release Form',
        name : 'Passport Release Form',
        active : false,
        index : 15
    },
    {
        title : 'Manage Reporting Line',
        name : 'Manage Reporting Line',
        active : false,
        index : 16
    },  {
        title : 'Payslip',
        name : 'Payslip',
        active : false,
        index : 17
    }
    ,
    
    {
        title : 'End Of service Settlement',
        name : 'End Of service Settlement',
        active : false,
        index : 18
    },  {
        title : 'Legal Information',
        name : 'Legal Information',
        active : false,
        index : 19
    },   {
        title : 'Forms & Reviews',
        name : 'Forms & Reviews',
        active : false,
        index : 20
    },
    {
        title : 'Assets',
        name : 'Assets',
        active : false,
        index : 21
    },
   
    {
        title : 'Organization Chart',
        name : 'Organization Chart',
        active : false,
        index : 22
    },
    {
        title : 'Audit',
        name : 'Audit',
        active : false,
        index : 23
    }];

    
    $scope.truckdrivermodel = {
    	       truckName:'',
    	       truckId:'',
    	       driverName:'',
    	       driverId:'',
    	        fromDate:'',
    	        toDate:'',
    	        truckdriverId:''
    	        	
    	     };
    	/*    $scope.validateDays= function(noofDays) {
    	        var reg =/^[0-9.]*$/
    	        if (reg.test(noofDays)) {
    	            return true;
    	        } else {
    	            // logger.logError("Please Enter Valida Email Address");
    	            return false;
    	        }
    	    }*/

    	   /* $scope.cancel = function() {
    		  	  $state.go('truckdriver.list',{tenantid:$stateParams.tenantid});
    		  	  
    		          
    		    };*/
    		    $scope.truckList=[];
    		    $scope.gettruckList=function(){
    		    	 $http.get($stateParams.tenantid+'/truckdrivermapping/trucklist').success(function(datas) {
    		            $scope.truckList = datas.truckList;
    		            console.log("truckList");
    		            console.log( $scope.truckList);
    		           

    		        }).error(function(data) {

    		        });
    		        
    		     
    		    }
    		    $scope.gettruckList();
    		    $scope.driverList=[];
    		    $scope.getdriverList=function(){
    		    	 $http.get($stateParams.tenantid+'/truckdrivermapping/driverlist').success(function(datas) {
    		            $scope.driverList = datas.driverList;
    		            console.log("driverList");
    		            console.log( $scope.driverList);
    		           

    		        }).error(function(data) {

    		        });
    		        
    		     
    		    }
    		    $scope.getdriverList();
    		  
    		    
    		    $scope.validateDriver = function(truckdriverForm) {
    		        if (new validationService().checkFormValidity(truckdriverForm)) {
    		          
    		                $scope.saveDriver(truckdriverForm);
    		            }
    		         else {
    		            toaster.pop('error', "Please fill the required fields",
    		                    logger.getErrorHtmlNew(truckdriverForm.$validationSummary),5000, 'trustedHtml');
    		        }
    		    };

    		    $scope.saveDriver = function(truckdriverForm) {
    		        sharedProperties.clearObject();
    	            console.log( truckdriverForm);

    	 
    	            var frmDate = $scope.truckdrivermodel.fromDate;
    		             var toDate = $scope.truckdrivermodel.toDate;
    		             frmDate = frmDate.split("/");
    		             frmDate = new Date(frmDate[2], frmDate[1]-1, frmDate[0]);
    		             toDate = toDate.split("/");
    		             toDate = new Date(toDate[2], toDate[1]-1, toDate[0]);
    		             
    		             if(frmDate>toDate){
    		                 logger.logError(" Valid To Date should be greater than or Equal to Valid From Date");
    		                 $scope.truckdrivermodel.toDate='';
    		             }
    		         
    		             else{
    		       	 $http.post($stateParams.tenantid+'/truckdrivermapping/save',$scope.truckdrivermodel)
    		            .success(function(response) {
    		        	  
    		               if(response == 1){
    		      	            
    		      	             
    		            	   
    		            	   
    		                   logger.logSuccess("Saved Succesfully!");
    		                
    		      	             
    		                   }else{
    			            	   logger.logError("Truck and Driver already allocated on Same Date")
    		               
    		            }
    		            
    		      
    		    });}}
    		    $scope.updateDriver = function(truckdriverForm) {
    		        sharedProperties.clearObject();
    		        var frmDate = $scope.truckdrivermodel.fromDate;
    		             var toDate = $scope.truckdrivermodel.toDate;
    		             frmDate = frmDate.split("/");
    		             frmDate = new Date(frmDate[2], frmDate[1]-1, frmDate[0]);
    		             toDate = toDate.split("/");
    		             toDate = new Date(toDate[2], toDate[1]-1, toDate[0]);
    		             if(frmDate>toDate){
    		                 logger.logError(" Valid To Date should be greater than or Equal to Valid From Date");
    		                 $scope.truckdrivermodel.toDate='';
    		             }
    		         
    		             else{
    		             
    		      	 $http.post($stateParams.tenantid+'/truckdrivermapping/update',$scope.truckdrivermodel)
    		            .success(function(response) {
    		          		 console.log(response);
    		          		if(response == 1){
    		      	            
    		            	   
    		            	   
    		                   logger.logSuccess("Updated Successfully Succesfully!");
    		                
    			         	  	  $state.go('truckdriver.list',{tenantid:$stateParams.tenantid});
    		      	             
    		                   }else{
    			            	   logger.logError("Truck and Driver already allocated on Same Date")
    		               
    		            }
    		              
    		            });}}
    		        
    		   
    		  

    		var editid = $location.search().rowid;
    		    
    		    var test = parseInt(editid);
    		    if(test){
    		    $scope.isEdit=true;
    		    $http.post($stateParams.tenantid+'/truckdrivermapping/edit',test).success(function(result) {
    		    	
    		    		
    		    	console.log(result);
    		    	$scope.truckdrivermodel = result;

    		    	$scope.truckdrivermodel.truckId = result.truckId.toString();

    		    	
    		    	
    		    });
    		}
    		  $scope.reset = function(truckdriverForm) {
    		        
    		        if($scope.isEdit == true){
    		            var truckdriverId =  $scope.truckdrivermodel.truckdriverId;
    		            $scope.truckdrivermodel.truckName ='';
    		       	 $scope.truckdrivermodel.truckId ='';
    		       	 $scope.truckdrivermodel.fromDate ='';
    		       	 $scope.truckdrivermodel.driverId ='';
    		       	 $scope.truckdrivermodel.driverName ='';
    		       	 $scope.truckdrivermodel.toDate ='';

    		       	 $scope.truckdrivermodel.truckdriverId ='';
    		       	

    		         $http.post($stateParams.tenantid+'/truckdrivermapping/edit',truckdriverId)
    		            .success(function(response) {
    		               if(response.success == true){
    		                   $scope.truckdrivermodel = response.manufacturer;
    		               }
    		            });
    		        }
    		        else{
    		        	 $scope.truckdrivermodel.truckName ='';
    		        	 $scope.truckdrivermodel.truckId ='';
    		        	 $scope.truckdrivermodel.fromDate ='';
    		        	 $scope.truckdrivermodel.toDate ='';
    		        	 $scope.truckdrivermodel.driverId ='';
    		        	 $scope.truckdrivermodel.driverName ='';
    		        	 $scope.truckdrivermodel.truckdriverId ='';
    		             
    		          
    		        }
    		        
    		  }
    		  
    $scope.loadPresentAddressTable = function() {
        var presentAddressDetails = {};
        presentAddressDetails = {
            presentAddress : '',
            presentPlace : '',
            presentDistrict : '',
            presentPin : '',
            presentPhone : [],
            presentMobile : [],
            isActiveOldAddress : 'N'
        };
        $scope.EmployeeMasterDataAddress.presentAddressMultiple.push(presentAddressDetails);
    }
    $scope.loadPresentAddressTable();

    $scope.addPresentAddressRow = function(tables) {
        var length = tables.length;
        var table = {
            presentAddress : '',
            presentPlace : '',
            presentDistrict : '',
            presentPin : '',
            presentPhone : [],
            presentMobile : [],
            isActiveOldAddress : 'N'
        };
        table.slNo = length + 1;
        tables.push(table);
    };
    $scope.removePresentAddressRow = function(table) {
        $scope.tablerow = [];
        angular.forEach(table, function(row, index) {
            var check = row.select;
            if (check == undefined || check == "") {
                $scope.tablerow.push(row);
            } else {
            }
        });
        $scope.EmployeeMasterDataAddress.presentAddressMultiple = $scope.tablerow;
    }
    
    $scope.getCustomerList=function(){
        $http.get($stateParams.tenantid+"/app/receipts/managereceipts/dropDownList").success(function(datas) {
            $scope.customerList = datas.customerList;
        })
    }
    $scope.getCustomerList(); 

    // seenu List Forms changes
    $scope.getNominationList = function(employeeId) {
        $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/getNominationList', employeeId).success(function(datas) {
            $scope.rowCollectionNom = datas.employeeNominationBeanList;
        });
    }
    $scope.deleteRowProbation = function(EmployeeMasterDataProbation) {
        ngDialog.openConfirm().then(function() {
            $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/deleteProbation', EmployeeMasterDataProbation).success(function(response) {
                if (response.success == true) {
                    logger.logSuccess("Deleted Succesfully!");
                    $scope.getProbationList(empId);
                }
            }).error(function(result) {
                logger.logError("Error Please Try Again");
            });
        });
    }

    $scope.deleteRowMerits = function(EmployeeMasterDataMerit) {
        var empId = EmployeeMasterDataMerit.empId;
        ngDialog.openConfirm().then(function() {
            $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/deleteMerits', EmployeeMasterDataMerit).success(function(response) {
                if (response.success == true) {
                    logger.logSuccess("Deleted Succesfully!");
                    $scope.employeeMeritList(empId);
                }
            }).error(function(result) {
                logger.logError("Error Please Try Again");
            });
        });
    }

    $scope.deleteRowExperiance = function(EmployeeMasterDataEx) {
        var empId = EmployeeMasterDataEx.empId;
        ngDialog.openConfirm().then(function() {
            $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/deleteExperiance', EmployeeMasterDataEx).success(function(response) {
                if (response.success == true) {
                    logger.logSuccess("Deleted Succesfully!");
                    $scope.employeeExperianceList(empId);
                }
            }).error(function(result) {
                logger.logError("Error Please Try Again");
            });
        });
    }

    $scope.deleteRowEducation = function(EmployeeMasterDataEdu) {
        var empId = EmployeeMasterDataEdu.empId;
        ngDialog.openConfirm().then(function() {
            $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/deleteEducation', EmployeeMasterDataEdu).success(function(response) {
                if (response.success == true) {
                    logger.logSuccess("Deleted Succesfully!");
                    $scope.employeeEducationList(empId);
                }
            }).error(function(result) {
                logger.logError("Error Please Try Again");
            });
        });
    }
    $scope.deleteRowDoc = function(EmployeeMasterDataDoc) {
        var empId = EmployeeMasterDataDoc.empId;
        ngDialog.openConfirm().then(function() {
            $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/deleteDoc', EmployeeMasterDataDoc).success(function(response) {
                if (response.success == true) {
                    logger.logSuccess("Deleted Succesfully!");
                    $scope.employeeDocumentList(empId);
                }
            }).error(function(result) {
                logger.logError("Error Please Try Again");
            });
        });
    }
    $scope.deleteRowFamily = function(EmployeeMasterDataFam) {
        var empId = EmployeeMasterDataFam.employeeId;
        ngDialog.openConfirm().then(function() {
            $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/deleteFamily', EmployeeMasterDataFam).success(function(response) {
                if (response.success == true) {
                    logger.logSuccess("Deleted Succesfully!");
                    $scope.employeeFamilyList(empId);
                }
            }).error(function(result) {
                logger.logError("Error Please Try Again");
            });
        });
    }
    $scope.deleteRowNomination = function(EmployeeMasterDataNomination) {
        var empId = EmployeeMasterDataNomination.empId;
        ngDialog.openConfirm().then(function() {
            $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/deleteNomination', EmployeeMasterDataNomination).success(function(response) {
                if (response.success == true) {
                    logger.logSuccess("Deleted Succesfully!");
                    $scope.getNominationList(empId);
                }
            }).error(function(result) {
                logger.logError("Error Please Try Again");
            });
        });
    }
    $scope.deleteRowEmergency = function(EmployeeMasterDataEme) {
        var empId = EmployeeMasterDataEme.empId;
        ngDialog.openConfirm().then(function() {
            $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/deleteEmergency', EmployeeMasterDataEme).success(function(response) {
                if (response.success == true) {
                    logger.logSuccess("Deleted Succesfully!");
                    $scope.getEmergencyList(empId);
                }
            }).error(function(result) {
                logger.logError("Error Please Try Again");
            });
        });
    }
    $scope.deleteRowReference = function(EmployeeMasterDataRef) {
        var empId = EmployeeMasterDataRef.empId;
        ngDialog.openConfirm().then(function() {
            $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/deleteReference', EmployeeMasterDataRef).success(function(response) {
                if (response.success == true) {
                    logger.logSuccess("Deleted Succesfully!");
                    $scope.getReferenceList(empId);
                }
            }).error(function(result) {
                logger.logError("Error Please Try Again");
            });
        });
    }
    $scope.getProbationList = function(employeeId) {
        $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/getProbationList', employeeId).success(function(datas) {
            $scope.rowCollectionPro = datas.employeeProbationBeanList;
        });
    }
    $scope.getEmergencyList = function(employeeId) {
        $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/getEmergencyList', employeeId).success(function(datas) {
            $scope.rowCollectionEme = datas.employeeEmergencyBeanList;
        });
    }
    $scope.getReferenceList = function(employeeId) {
        $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/getReferenceList', employeeId).success(function(datas) {
            $scope.rowCollectionRef = datas.employeeReferanceBeanList;
        });
    }
    
    
    //LEAVAE APPLICATION
    
    $scope.getLeaveList = function(employeeId) {
        $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/getLeaveList', employeeId).success(function(datas) {
            $scope.rowCollectionLeave = datas.employeeleaveBeanList;
        });
    }
    
    $scope.employeeDocumentList = function(employeeId) {
        $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/getEmpDocumentList', employeeId).success(function(datas) {
            $scope.rowCollectionDoc = datas.employeeDocumentBeanList;
        });
    }
    $scope.employeeMeritList = function(employeeId) {
        $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/getEmpMeritList', employeeId).success(function(datas) {
            $scope.rowCollectionMerit = datas.employeeMeritsBeanList;
            angular.forEach(datas.employeeDocumentBeanList, function(value, key) {
                var file =	value.uploadDoc.split("/");
                file =  file[2];
    	    
                datas.employeeDocumentBeanList[key].uploadDoc=file;
                });
        });
        
    }
    $scope.employeeFamilyList = function(employeeId) {
        
        $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/getEmpFamList', employeeId).success(function(datas) {
            $scope.rowCollectionFam = datas.employeeFamilyBeanList;
           
        });
    }
    //suresh1
    $scope.employeeEducationList = function(employeeId) {
        $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/getEmpEduList', employeeId).success(function(datas) {
            $scope.rowCollectionEdu = datas.employeeEducationBeanList;
        });
    }
    $scope.employeeExperianceList = function(employeeId) {
        $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/getEmpExList', employeeId).success(function(datas) {
            $scope.rowCollectionEx = datas.employeeExperianceList;
        });
    }

    // $scope.secondLevelList=function(employeeId){
    // $http.get('app/commonUtility/getEmployeeList').success(function(response)
    // {
    // $scope.secEmpList=response;
    // });
    // }
    // $scope.secondLevelList();

    $scope.callDialogEmergency = function($scope, isFunction, employeeEdit, employeeId, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, rowData) {
        ngDialog.open({
            scope : $scope,
            template : 'views/master/empmaster/employeeMasterEmergencyView',
            controller : $controller('employeeEmergencyAdminAddCtrl', {
                $scope : $scope,
                isFunction : isFunction,
                employeeEdit : employeeEdit,
                employeeId : employeeId,
                $http : $http,
                ngDialog : ngDialog,
                logger : logger,
                $injector : $injector,
                sharedProperties : sharedProperties,
                toaster : toaster,
                rowData : rowData,
                $rootScope : $rootScope
            }),
            className : 'ngdialog-theme-plain',
            showClose : false,
            closeByDocument : false,
            closeByEscape : false,
            preCloseCallback : function() {
                if (employeeId == "") {
                    $scope.getEmergencyList(employeeEdit);
                } else {
                    $scope.getEmergencyList(employeeId);
                }
            }
        });
    }

    $scope.callDialogNomination = function($scope, isFunction, employeeEdit, employeeId, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, rowData) {
        ngDialog.open({
            scope : $scope,
            template : 'views/master/empmaster/employeeNominationView',
            controller : $controller('employeeNominationAdminAddCtrl', {
                $scope : $scope,
                isFunction : isFunction,
                employeeEdit : employeeEdit,
                employeeId : employeeId,
                $http : $http,
                ngDialog : ngDialog,
                logger : logger,
                $injector : $injector,
                sharedProperties : sharedProperties,
                toaster : toaster,
                rowData : rowData,
                $rootScope : $rootScope
            }),
            className : 'ngdialog-theme-plain',
            showClose : false,
            closeByDocument : false,
            closeByEscape : false,
            preCloseCallback : function() {
                if (employeeId == "") {
                    $scope.getNominationList(employeeEdit);
                } else {
                    $scope.getNominationList(employeeId);
                }
            }
        });
    }
    $scope.callDialogReference = function($scope, isFunction, employeeEdit, employeeId, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, rowData) {
        ngDialog.open({
            scope : $scope,
            template :'views/master/empmaster/employeeReferenceView',
            controller : $controller('employeeReferenceAdminAddCtrl', {
                $scope : $scope,
                isFunction : isFunction,
                employeeEdit : employeeEdit,
                employeeId : employeeId,
                $http : $http,
                ngDialog : ngDialog,
                logger : logger,
                $injector : $injector,
                sharedProperties : sharedProperties,
                toaster : toaster,
                rowData : rowData,
                $rootScope : $rootScope
            }),
            className : 'ngdialog-theme-plain',
            showClose : false,
            closeByDocument : false,
            closeByEscape : false,
            preCloseCallback : function() {
                if (employeeId == "") {
                    $scope.getReferenceList(employeeEdit);
                } else {
                    $scope.getReferenceList(employeeId);
                }
            }
        });
    }
    $scope.callDialogProbation = function($scope, isFunction, employeeEdit, employeeId, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, rowData) {
        ngDialog.open({
            scope : $scope,
            template :'views/master/empmaster/employeeProbationAddView',
            controller : $controller('employeeMasterProbationAdminAddCtrl', {
                $scope : $scope,
                isFunction : isFunction,
                employeeEdit : employeeEdit,
                employeeId : employeeId,
                $http : $http,
                ngDialog : ngDialog,
                logger : logger,
                $injector : $injector,
                sharedProperties : sharedProperties,
                toaster : toaster,
                rowData : rowData,
                $rootScope : $rootScope
            }),
            className : 'ngdialog-theme-plain',
            showClose : false,
            closeByDocument : false,
            closeByEscape : false,
            preCloseCallback : function() {
                if (employeeId == "") {
                    $scope.getProbationList(employeeEdit);
                } else {
                    $scope.getProbationList(employeeId);
                }
            }
        });
    }
    $scope.callDialogDocument = function($scope, isFunction, employeeEdit, employeeId, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, rowData) {
        ngDialog.open({
            scope : $scope,
            template :'views/master/empmaster/employeeDocumentsAddView',
            controller : $controller('employeeMasterDocumentAdminAddCtrl', {
                $scope : $scope,
                isFunction : isFunction,
                employeeEdit : employeeEdit,
                employeeId : employeeId,
                $http : $http,
                ngDialog : ngDialog,
                logger : logger,
                $injector : $injector,
                sharedProperties : sharedProperties,
                toaster : toaster,
                rowData : rowData,
                $rootScope : $rootScope
            }),
            className : 'ngdialog-theme-plain',
            showClose : false,
            closeByDocument : false,
            closeByEscape : false,
            preCloseCallback : function() {
                if (employeeId == "") {
                    $scope.employeeDocumentList(employeeEdit);
                } else {
                    $scope.employeeDocumentList(employeeId);
                }
            }
        });
    }
    $scope.callDialogFamily = function($scope,isFunction, employeeEdit, employeeId, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, rowData) {
        ngDialog.open({
            scope : $scope,
            template :'views/master/empmaster/employeeMasterFamilyView',
            controller : $controller('employeeMasterFamilyAdminAddCtrl', {
                $scope : $scope,
                isFunction : isFunction,
                employeeEdit : employeeEdit,
                employeeId : employeeId,
                $http : $http,
                ngDialog : ngDialog,
                logger : logger,
                $injector : $injector,
                sharedProperties : sharedProperties,
                toaster : toaster,
                rowData : rowData,
                $rootScope : $rootScope
            }),
            className : 'ngdialog-theme-plain',
            showClose : false,
            closeByDocument : false,
            closeByEscape : false,
            preCloseCallback : function(value) {
                if (employeeId == "") {
                    $scope.employeeFamilyList(employeeEdit);
                } else {
                    // alert(employeeId);
                    $scope.employeeFamilyList(employeeId);
                }
            }
        });
    }
    $scope.callDialogMerits = function($scope, isFunction, employeeEdit, employeeId, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, rowData) {
        ngDialog.open({
            scope : $scope,
            template :'views/master/empmaster/employeeMasterMeritsView',
            controller : $controller('employeeMasterMeritsAdminAddCtrl', {
                $scope : $scope,
                isFunction : isFunction,
                employeeEdit : employeeEdit,
                employeeId : employeeId,
                $http : $http,
                ngDialog : ngDialog,
                logger : logger,
                $injector : $injector,
                sharedProperties : sharedProperties,
                toaster : toaster,
                rowData : rowData,
                $rootScope : $rootScope
            }),
            className : 'ngdialog-theme-plain',
            showClose : false,
            closeByDocument : false,
            closeByEscape : false,
            preCloseCallback : function() {
                if (employeeId == "") {
                    $scope.employeeMeritList(employeeEdit);
                } else {
                    $scope.employeeMeritList(employeeId);
                }
            }
        });
    }

    $scope.callDialogEducation = function($scope, isFunction, employeeEdit, employeeId, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, rowData) {
        ngDialog.open({
            scope : $scope,
            template : 'views/master/empmaster/employeeMasterEducationView',
            controller : $controller('employeeMasterEducationAdminAddCtrl', {
                $scope : $scope,
                isFunction : isFunction,
                employeeEdit : employeeEdit,
                employeeId : employeeId,
                $http : $http,
                ngDialog : ngDialog,
                logger : logger,
                $injector : $injector,
                sharedProperties : sharedProperties,
                toaster : toaster,
                rowData : rowData,
                $rootScope : $rootScope
            }),
            className : 'ngdialog-theme-plain',
            showClose : false,
            closeByDocument : false,
            closeByEscape : false,
            preCloseCallback : function() {
                if (employeeId == "") {
                    $scope.employeeEducationList(employeeEdit);
                } else {
                    $scope.employeeEducationList(employeeId);
                }
            }
        });
    }
    $scope.callDialogExperiance = function($scope, isFunction, employeeEdit, employeeId, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, rowData) {
        ngDialog.open({
            scope : $scope,
            template :'views/master/empmaster/employeeExperianceAddView',
            controller : $controller('employeeExperianceAdminAddCtrl', {
                $scope : $scope,
                isFunction : isFunction,
                employeeEdit : employeeEdit,
                employeeId : employeeId,
                $http : $http,
                ngDialog : ngDialog,
                logger : logger,
                $injector : $injector,
                sharedProperties : sharedProperties,
                toaster : toaster,
                rowData : rowData,
                $rootScope : $rootScope
            }),
            className : 'ngdialog-theme-plain',
            showClose : false,
            closeByDocument : false,
            closeByEscape : false,
            preCloseCallback : function() {
                if (employeeId == "") {
                    $scope.employeeExperianceList(employeeEdit);
                } else {
                    $scope.employeeExperianceList(employeeId);
                }
            }
        });
    }
    $scope.callDialog = function($scope, designationId, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, rowData) {
        ngDialog.open({
            scope : $scope,
            template : 'views/master/empmaster/multiPhoneNoView',
            controller : $controller('employeePhoneNoAdminAddCtrl', {
                $scope : $scope,
                designationId : designationId,
                $http : $http,
                ngDialog : ngDialog,
                logger : logger,
                $injector : $injector,
                sharedProperties : sharedProperties,
                toaster : toaster,
                rowData : rowData,
                $rootScope : $rootScope
            }),
            className : 'ngdialog-theme-plain',
            showClose : false,
            closeByDocument : false,
            closeByEscape : false,
            preCloseCallback : $scope.getList
        });
    }
    $scope.callDialogMobile = function($scope, designationId, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, rowDatas) {
        ngDialog.open({
            scope : $scope,
            template : 'views/hrms/master/employeeMaster/multiMobileNoView',
            controller : $controller('employeeMobileNoAdminAddCtrl', {
                $scope : $scope,
                designationId : designationId,
                $http : $http,
                ngDialog : ngDialog,
                logger : logger,
                $injector : $injector,
                sharedProperties : sharedProperties,
                toaster : toaster,
                rowDatas : rowDatas,
                $rootScope : $rootScope
            }),
            className : 'ngdialog-theme-plain',
            showClose : false,
            closeByDocument : false,
            closeByEscape : false,
            preCloseCallback : $scope.getList
        });
    }
    $scope.familyPhoto;

    $rootScope.uploadPhoto = function(element) {
        $scope.familyPhoto = element.files[0];
    }
    $rootScope.uploadFamilyPhoto = function() {
        var imgfile = $scope.familyPhoto;
        var fileExtension = imgfile.name;
        var frmData = new FormData();
        frmData.append("file", imgfile);
        frmData.append("fileName", $scope.EmployeeMasterData.empId + "_family");
        // $scope.nomineePhoto=frmData;
        $.ajax({
            type : "POST",
            url : $stateParams.tenantid+"/hrms/master/employeeAdminMaster/uploadfile",
            data : frmData,
            contentType : false,
            processData : false,
            success : function(result) {
                // $scope.fileName=result.fileName;
                // $scope.imgFilePath=result.imgPath;
                $scope.EmployeeMasterDataFam.uploadPhotoFamily = result.imgPath;
                if (result.success) {
                    logger.logSuccess("File Uploaded Successfully");
                } else {
                    logger.logError("Fail to Upload");
                }
            }
        });
    };

    $scope.loadPhoneNoTable = function() {
        var phoneNoDetails = {};
        phoneNoDetails = {
            presentPhoneNo : ''
        };
        $scope.EmployeeMasterData.presentAddressMultiple.presentPhone.push(phoneNoDetails);
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

    // relieveDate
    var d = new Date();
    var year = d.getFullYear() + 30;
    var month = d.getMonth() + 1;
    if (month < 10) {
        month = "0" + month;
    }
    ;
    var day = d.getDate();
    $scope.relieveDate = day + "/" + month + "/" + year;
    $scope.EmployeeMasterData.relieveDate = null;

    // confirmDate
    var d = new Date();
    var year = d.getFullYear();
    var month = d.getMonth() + 1;
    if (month < 10) {
        month = "0" + month;
    }
    ;
    var day = d.getDate();
    $scope.confirmDate = day + "/" + month + "/" + year;
    $scope.EmployeeMasterDataPersonal.confirmDate = $scope.confirmDate;

    // resignationDate
    var d = new Date();
    var year = d.getFullYear();
    var month = d.getMonth() + 1;
    if (month < 10) {
        month = "0" + month;
    }
    ;
    var day = d.getDate();
    $scope.resignationDate = day + "/" + month + "/" + year;
    $scope.EmployeeMasterDataPersonal.resignationDate = $scope.resignationDate;

    // issuedDate
    var d = new Date();
    var year = d.getFullYear();
    var month = d.getMonth() + 1;
    if (month < 10) {
        month = "0" + month;
    }
    ;
    var day = d.getDate();
    $scope.issuedDate = day + "/" + month + "/" + year;
    // $scope.EmployeeMasterDataPerDet.issuedDate=null;

    // expiryDate
    var d = new Date();
    var year = d.getFullYear();
    var month = d.getMonth() + 1;
    if (month < 10) {
        month = "0" + month;
    }
    ;
    var day = d.getDate();
    $scope.expiryDate = day + "/" + month + "/" + year;
 // issueDate
    var d = new Date();
    var year = d.getFullYear();
    var month = d.getMonth() + 1;
    if (month < 10) {
        month = "0" + month;
    }
    ;
    var day = d.getDate();
    $scope.issueDate = day + "/" + month + "/" + year;
    // $scope.EmployeeMasterDataPerDet.expiryDate=null;

    // licenseIssuedDate
    var d = new Date();
    var year = d.getFullYear();
    var month = d.getMonth() + 1;
    if (month < 10) {
        month = "0" + month;
    }
    ;
    var day = d.getDate();
    $scope.licenseIssuedDate = day + "/" + month + "/" + year;
    // $scope.EmployeeMasterDataPerDet.licenseIssuedDate=null;

    // licenseexpiryDate
    var d = new Date();
    var year = d.getFullYear();
    var month = d.getMonth() + 1;
    if (month < 10) {
        month = "0" + month;
    }
    ;
    var day = d.getDate();
    $scope.licenseexpiryDate = day + "/" + month + "/" + year;
    // $scope.EmployeeMasterDataPerDet.licenseexpiryDate=null;

    // renewalDate
    var d = new Date();
    var year = d.getFullYear();
    var month = d.getMonth() + 1;
    if (month < 10) {
        month = "0" + month;
    }
    ;
    var day = d.getDate();
    $scope.renewalDate = day + "/" + month + "/" + year;
    // $scope.EmployeeMasterDataPerDet.renewalDate=null;

    // visaIssuedDate
    var d = new Date();
    var year = d.getFullYear();
    var month = d.getMonth() + 1;
    if (month < 10) {
        month = "0" + month;
    }
    ;
    var day = d.getDate();
    $scope.visaIssuedDate = day + "/" + month + "/" + year;
    // $scope.EmployeeMasterDataPerDet.visaIssuedDate=null;

    // visaExpiryDate
    var d = new Date();
    var year = d.getFullYear();
    var month = d.getMonth() + 1;
    if (month < 10) {
        month = "0" + month;
    }
    ;
    var day = d.getDate();
    $scope.visaExpiryDate = day + "/" + month + "/" + year;
    // $scope.EmployeeMasterDataPerDet.visaExpiryDate=null;

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
    $scope.getCompanyList = function() {
        if(editEmployeeID == undefined){
            $http.get($stateParams.tenantid+'/hrms/master/employeeAdminMaster/getCompanyList').success(function(datas) {
                $scope.companyList = datas.companyList;
                $scope.EmployeeMasterData.empId = datas.employeeId;
               // $scope.EmployeeMasterData.pwd = ';
                $scope.princpalList = datas.principalList;
                $scope.msList = datas.msList;
                $scope.principalCount = datas.principalCount;
                $scope.msCount = datas.msCount;
                if (datas.companyList.length == 1) {
                    $scope.companyDrop = true;
                    $scope.EmployeeMasterData.companyCode = datas.companyList[0].companyCode;
                } else {
                    $scope.companyDrop = false;
                }
              
            })
            
        }
        else{
            $http.get($stateParams.tenantid+'/hrms/master/employeeAdminMaster/getCompanyList').success(function(datas) {
                $scope.companyList = datas.companyList;
                $scope.EmployeeMasterData.empId = datas.employeeId;
                //$scope.EmployeeMasterData.pwd = 'password';
                $scope.princpalList = datas.principalList;
                $scope.msList = datas.msList;
                $scope.principalCount = datas.principalCount;
                $scope.msCount = datas.msCount;
                if (datas.companyList.length == 1) {
                    $scope.companyDrop = true;
                    $scope.EmployeeMasterData.companyCode = datas.companyList[0].companyCode;
                    $scope.getBranchList($scope.EmployeeMasterData.companyCode);
                } else {
                    $scope.companyDrop = false;
                }
              
            })
        }
        
    }

    $scope.dropdown = false;
    $scope.getBranchList = function(companyCode) {
        $scope.EmployeeMasterData.reportToBranch = '';
        if (companyCode != "") {
            var myURL = $stateParams.tenantid+'/hrms/master/employeeAdminMaster/getBranchList';
            $http({
                method : 'post',
                url : myURL,
                data : companyCode,
            }).success(function(datas) {
                $scope.branchList = datas.branchList;
                if (datas.branchList.length == 0) {
                    logger.logError("No Branches For this Company");
                } else if (datas.branchList.length == 1) {
                    debugger
                    $scope.dropdown = true;
                    $scope.EmployeeMasterData.branch = datas.branchList[0].branch;
                    $scope.EmployeeMasterData.reportToBranch = datas.branchList[0].branch;
                    $scope.getDepartmentList(companyCode);
                    $scope.getReportToDeptList(companyCode);
                    $scope.getDesignationList(companyCode);
                    $scope.getDivisionList(companyCode);
                    $scope.getGradeList(companyCode);

                } else {
                    $scope.dropdown = false;
                    $scope.branchList = datas.branchList;
                    $scope.getDepartmentList(companyCode);
                    $scope.getReportToDeptList(companyCode);
                    $scope.getDesignationList(companyCode);
                    $scope.getDivisionList(companyCode);
                    $scope.getGradeList(companyCode);
                }
            });
        } else {
            
        }

    }

    $scope.$watchCollection('[ EmployeeMasterData.relieveDate,EmployeeMasterData.doj]', function(newValue, oldValue) {
debugger
        if ($scope.EmployeeMasterData.doj != undefined && $scope.EmployeeMasterData.relieveDate != "" && $scope.EmployeeMasterData.relieveDate != null && $scope.EmployeeMasterData.relieveDate != undefined) {
            var frmDate = $scope.EmployeeMasterData.doj;
            var toDate = $scope.EmployeeMasterData.relieveDate;
            frmDate = frmDate.split("/");
            frmDate = new Date(frmDate[2], frmDate[1], frmDate[0]);
            toDate = toDate.split("/");
            toDate = new Date(toDate[2], toDate[1], toDate[0]);

            var clFromDate = $scope.EmployeeMasterData.doj.split('/'), clToDate = $scope.EmployeeMasterData.relieveDate.split('/'), clFrom = new Date(clFromDate[2], clFromDate[1] - 1, clFromDate[0]), clTo = new Date(clToDate[2], clToDate[1] - 1, clToDate[0]);

            var millisecondsPerDay = 1000 * 60 * 60 * 24;
            var millisBetween = clTo.getTime() - clFrom.getTime();
            var clDays = Math.round(millisBetween / millisecondsPerDay) + 1;

            if (frmDate >= toDate) {
                logger.logError("Relieving Date Should Be Greater than Joining Date");
                $scope.EmployeeMasterData.relieveDate = '';
            }
        }

    });
    
    
    $scope.getBranchEditList = function(companyCode) {
        var myURL = $stateParams.tenantid+'/hrms/master/employeeAdminMaster/getBranchList';
        $http({
            method : 'post',
            url : myURL,
            data : companyCode,
        }).success(function(datas) {
            $scope.branchList = datas.branchList;
        });

    }

    $scope.password = 'password';
    $scope.textValue = 'Show';
    $scope.eyeIcon = 'fa fa-eye';
    $scope.visiblePassword = function() {
        if ($scope.password == 'password') {
            $scope.password = 'text';
            $scope.textValue = 'Hide';
            $scope.eyeIcon = 'fa fa-eye-slash';
        } else {
            $scope.password = 'password';
            $scope.textValue = 'Show';
            $scope.eyeIcon = 'fa fa-eye';
        }
    }
    
   
  
    
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

  //  $scope.getDepartmentList();
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

    $scope.getDivisionList = function(companyCode)  {
            var myURL = $stateParams.tenantid+'/hrms/master/employeeAdminMaster/getDivisionList';
            $http({
                method : 'post',
                url : myURL,
                data : companyCode,
            }).success(function(datas) {
                $scope.divisionList = datas.divisionList;
            });
    }
    $scope.getDivisionList();

    $scope.getGradeList = function(companyCode) {
            var myURL = $stateParams.tenantid+'/hrms/master/employeeAdminMaster/getGradeList';
            $http({
                method : 'post',
                url : myURL,
                data : companyCode,
            }).success(function(datas) {
                $scope.gradeList = datas.gradeList;
            });
    }
    $scope.getGradeList();
    $scope.getReportToBranchList = function() {
        $http.get($stateParams.tenantid+'/hrms/master/employeeAdminMaster/getReportBranchList').success(function(datas) {
            $scope.reportToBranchList = datas.reportToBranchList;

        }).error(function(data) {

        });
    }
    // $scope.getReportToBranchList();

    $scope.getReportToDeptList = function() {
        var companyCode=$scope.EmployeeMasterData.companyCode;
        /*
         * $http.post('hrms/master/employeeMaster/getReportToDeptList',).success(function(datas) {
         * $scope.reportToDeptList = datas.reportToDeptList;
         * 
         * }).error(function(data) {
         * 
         * });
         */

        var myURL = $stateParams.tenantid+'/hrms/master/employeeAdminMaster/getDepartmentList'
        $http({
            method : 'post',
            url : myURL,
            data : companyCode,
        }).success(function(datas) {
            $scope.reportToDeptList = datas.departmentList;
        });
    }
    $scope.getReportToDeptList();

    $scope.getReportDesig = function(desig) {
        if (desig != "" && desig != null) {
            $scope.getReportToDesigList(desig);
        } else {
            $scope.EmployeeMasterData.reportDesigId = '';
        }
    }

    $scope.getReportToDesigList = function(desig) {
        $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/getReportToDesigList', desig).success(function(datas) {
            $scope.reportToDesigList = datas.reportToDesigList;
            $scope.EmployeeMasterData.reportDesigId = datas.reportToDesigList[0].reportDesigId;
        }).error(function(data) {

        });
    }

    $scope.getEmpType = function() {
        $http.get($stateParams.tenantid+'/hrms/master/employeeAdminMaster/getEmpType').success(function(datas) {
            $scope.empTypeList = datas.empTypeList;

        }).error(function(data) {

        });
    }
    $scope.getEmpType();

    $scope.getReportManager = function(depId) {
        var branchId = $scope.EmployeeMasterData.reportToBranch;
        var url = $stateParams.tenantid+"/hrms/master/employeeAdminMaster/getReportManager?depId=" + depId + "&branchId=" + branchId;
        $http.get(url).success(function(datas) {
            $scope.reportToManagerList = datas;
        }).error(function(data) {

        });
    };

    // Edit
    // var empId = $location.search().empId;

    var editEmployeeID = $state.params.empId;
    // alert(editEmployeeID);
    $scope.employeeEdit = editEmployeeID;
    if (editEmployeeID == undefined) {
        $scope.EmployeeMasterData.isEdit === false;
    } else {
        $http.get($stateParams.tenantid+'/hrms/master/employeeAdminMaster/view?empId=' + editEmployeeID).success(function(result) {
            if (result.editList[0].isEdit == false) {
                logger.logError("Please Try Again");
            } else {
                console.log("Edit Result");
                console.log(result);
                $scope.autogen = false;
                $scope.isEdit = true;
                $scope.profileEdit = true;
                $scope.resetEdit=true;
                
                $scope.branchList = result.branchList;
                $("#empid").prop('disabled', true);
                var managerID = result.editList[0].reportDesigId;
               if(result.employeeAirBeanList.length>0){
                result.editList[0].airticketclass=result.employeeAirBeanList[0].airclass;
                }
                $scope.EmployeeMasterData.isEdit = result.editList[0].isEdit;
                $scope.EmployeeMasterData = result.editList[0];
                $scope.employeeId = result.editList[0].empId;
                $scope.EmployeeMasterData.grade = result.editList[0].grade.toString();
               // $scope.EmployeeMasterData.branch = result.editList[0].branch.toString();
                $scope.leaveTypeList =  result.leaveTypeList;
               // $scope.getBranchList($scope.EmployeeMasterData.companyCode);
                $scope.getDepartmentList($scope.EmployeeMasterData.companyCode);
                $scope.getDesignationList($scope.EmployeeMasterData.companyCode);
                $scope.getDivisionList($scope.EmployeeMasterData.companyCode);
                $scope.getGradeList($scope.EmployeeMasterData.companyCode);
                $scope.EmployeeMasterData.reportToBranch = result.editList[0].reportToBranch;
                $scope.getReportToDeptList($scope.EmployeeMasterData.companyCode);
                $scope.EmployeeMasterData.reportDeptId = result.editList[0].reportDeptId;
                $scope.getReportManager($scope.EmployeeMasterData.reportDeptId);
                $scope.EmployeeMasterData.reportMangrId = result.editList[0].reportMangrId;
                $scope.EmployeeMasterData.typeOfEmp= result.editList[0].typeOfEmp.toString();
                $scope.getReportDesig($scope.EmployeeMasterData.reportMangrId);
                $scope.EmployeeMasterDataPerDet=result.employeeMAsterPerDetailsBeanList[0];
                $scope.EmployeeMasterDataPhysical=result.employeeMasterPhysicalBeanBeanList[0];
                $scope.EmployeeMasterDataPersonal=result.employeePersonalBeanList[0];
                $scope.rowCollectionHistory = result.employeeDuplicateList;
                
                $scope.esicNoOld = result.editList[0].esic;
                $scope.epfNoOld = result.editList[0].epfNo;

                $scope.EmployeeMasterData.employmentDate = $scope.date;

                var companyName = result.editList[0].companyName;
                var branchName = result.editList[0].branchName;
                var departmentName = result.editList[0].departmentCode;
                var designation = result.editList[0].designationName;
                var division = result.editList[0].divisionName;
                var grade = result.editList[0].gradeName;
                var reportToBranch = result.editList[0].reportToBranchName;
                var reportDeptName = result.editList[0].reportToDept;
                
                var reportMangrName = result.editList[0].reportMangrId+ " - "+ result.editList[0].reportManagerName;
                var reportDesigName = result.editList[0].reportToDesig;
                var typeOfEmp = result.editList[0].empTypeName;

                $scope.employeeDuplicateEdit = [ {
                    columnName : 'Hospital Name',
                    oldValue : companyName,
                    newValue : '',
                    active : false,
                    index : 0
                }, {
                    columnName : 'Branch',
                    oldValue : branchName,
                    newValue : '',
                    active : false,
                    index : 1
                }, {
                    columnName : 'Department',
                    oldValue : departmentName,
                    newValue : '',
                    active : false,
                    index : 2
                }, {
                    columnName : 'Designation',
                    oldValue : designation,
                    newValue : '',
                    active : false,
                    index : 3
                }, {
                    columnName : 'Division',
                    oldValue : division,
                    newValue : '',
                    active : false,
                    index : 4
                }, {
                    columnName : 'Grade',
                    oldValue : grade,
                    newValue : '',
                    active : false,
                    index : 5
                }, {
                    columnName : 'Report To Branch',
                    oldValue : reportToBranch,
                    newValue : '',
                    active : false,
                    index : 6
                }, {
                    columnName : 'Report To Department',
                    oldValue : reportDeptName,
                    newValue : '',
                    active : false,
                    index : 7
                }, {
                    columnName : 'Reporting Authority',
                    oldValue : reportMangrName,
                    newValue : '',
                    active : false,
                    index : 8
                }, {
                    columnName : 'Report To Designation',
                    oldValue : reportDesigName,
                    newValue : '',
                    active : false,
                    index : 9
                }, {
                    columnName : 'Type Of Employment',
                    oldValue : typeOfEmp,
                    newValue : '',
                    active : false,
                    index : 10
                } ];

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
              /*  if ($scope.EmployeeMasterData.status == "true") {

                    $scope.EmployeeMasterData.status = 'Y';
                } else {
                    $scope.EmployeeMasterData.status = 'N';
                }*/
                var fileDoc;
                if ($scope.EmployeeMasterData.joinDocUpload != undefined) {
                    fileDoc = $scope.EmployeeMasterData.joinDocUpload;
                } else {
                    fileDoc = "";
                }

                var position = fileDoc.indexOf("tmpDocFiles")
                var path = fileDoc.substr(position);
                var fileLocation = path.split("/")
                var downloadFile;
                if (fileLocation[1] != undefined) {
                    downloadFile = fileLocation[1];
                } else {
                    downloadFile = "Empty Download";
                }
//                var target = "_blank";
//                var shtml = '<a class="link" href="' + path + '" target="' + target + '" ng-if="EmployeeMasterData.isEdit">' + downloadFile + '</a>'
//                $('#fileDiv').append(shtml);
//                var imgEdit = $scope.EmployeeMasterData.uploadPhoto;
//                var image_holder = $("#image-holder");
//                var imgSplit = imgEdit.indexOf("imgFiles");
//                var imgPath = imgEdit.substr(imgSplit);
//           
//                var i = '<img src="' + imgPath + '" class="thumb-image" style="max-height: 100px;width: 150px;">'
//                $('#image-holder').append(i);
//                $('#image-holder').show();
                $scope.imgFilePath = result.editList[0].uploadPhoto + "?";
                $scope.EmployeeMasterData.uploadPhoto = result.editList[0].uploadPhoto;
                
                if(result.editList[0].uploadPhoto == "" || result.editList[0].uploadPhoto == null || result.editList[0].uploadPhoto == undefined)
                {
                	$scope.EmployeeMasterData.upic = '0';
                }
                else{
                	$scope.EmployeeMasterData.upic = '1';
                }
				
                
                $('.thumb-image').remove();
                $('#image-holder').append('<img src="" class="thumb-image" style="max-height:100px;width: 150px;">');
                $('.thumb-image').attr('src', $scope.imgFilePath + new Date().getTime());
                                 
                $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/editPersonal?empId=' + editEmployeeID).success(function(result) {
                    $scope.isEdit = true;
                    if(result.objEmployeeMasterPersonalBean!=undefined &&  result.objEmployeeMasterAddressBean!=null &&  result.objEmployeeMasterAddressBean!=''){
                        $scope.panNoOld = result.objEmployeeMasterPersonalBean.panNo
                        $scope.EmployeeMasterDataPersonal = result.objEmployeeMasterPersonalBean;
                        $scope.EmployeeMasterDataPersonal.bloodGrp = result.objEmployeeMasterAddressBean.bloodGrp.toString();
                    }
                   
                });
       /*         $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/editAddress?empId=' + editEmployeeID).success(function(result) {
                    $scope.isEdit = true;
                    if( result.objEmployeeMasterAddressBean!=undefined &&  result.objEmployeeMasterAddressBean!=null &&  result.objEmployeeMasterAddressBean!=''){
                        $scope.EmployeeMasterDataAddress = result.objEmployeeMasterAddressBean;
                    }
                    
                    // $scope.EmployeeMasterDataAddress.presentAddressMultiple=result.presentAddressMultiple;
                });*/
                $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/editRule?empId=' + editEmployeeID).success(function(result) {
                    $scope.isEdit = true;
                    if( result.objEmployeeMasterRulesBean!=undefined &&  result.objEmployeeMasterRulesBean!=null &&  result.objEmployeeMasterRulesBean!=''){
                        $scope.EmployeeMasterDataRule = result.objEmployeeMasterRulesBean;
                    }
                   
                });
                $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/editPerDet?empId=' + editEmployeeID).success(function(result) {
                    $scope.isEdit = true;
/*                    $scope.copyPasIssueDate=result.objEmployeeMAsterPerDetailsBean.issuedDate;
                    $scope.copyPasExpDate=result.objEmployeeMAsterPerDetailsBean.expiryDate;
                    $scope.copylinExpDate=result.objEmployeeMAsterPerDetailsBean.licenseexpiryDate;
                    $scope.copylinIssueDate=result.objEmployeeMAsterPerDetailsBean.licenseIssuedDate;
                    $scope.copylinReDate=result.objEmployeeMAsterPerDetailsBean.renewalDate;
                    $scope.copyvisaIssueDate=result.objEmployeeMAsterPerDetailsBean.visaIssuedDate;
                    $scope.copyvisaExpDate=result.objEmployeeMAsterPerDetailsBean.visaExpiryDate;*/
                    if(result.objEmployeeMAsterPerDetailsBean!=undefined &&  result.objEmployeeMAsterPerDetailsBean!=null &&  result.objEmployeeMAsterPerDetailsBean!=''){
                        $scope.EmployeeMasterDataPerDet = result.objEmployeeMAsterPerDetailsBean;
                    }
                });
                $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/editPhysical?empId=' + editEmployeeID).success(function(result) {
                    $scope.isEdit = true;
                    if(result.objEmployeeMasterPhysicalBean!=undefined &&  result.objEmployeeMasterPhysicalBean!=null &&  result.objEmployeeMasterPhysicalBean!=''){
                        $scope.EmployeeMasterDataPhysical = result.objEmployeeMasterPhysicalBean;
                    }
                   
                });
                
                $scope.getLeaveList = function(employeeId) {
                    $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/getLeaveList', editEmployeeID).success(function(datas) {
                        $scope.rowCollectionLeave = datas.employeeLeaveBeanList;
                    });
                }
                
                
                $scope.getPayslipList = function(employeeId) {
                    $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/getPayslipList', editEmployeeID).success(function(datas) {
                        $scope.rowCollectionPay = datas.employeePayslipBeanList;
                    });
                }
                
                
                
                $scope.getAssetsList = function(employeeId) {
                    $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/getAssetsList', editEmployeeID).success(function(datas) {
                        $scope.rowCollectionAssets = datas.employeeLetterAssetsBeanList;
                    });
                }
                
                $scope.getAirClaimList = function(employeeId) {
                    $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/getAirClaimList', editEmployeeID).success(function(datas) {
                        $scope.rowCollectionaircliams = datas.employeeAirBeanList;
                    });
                }
                
                
            $scope.getLetterRequestList = function(employeeId) {
                    $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/getLetterRequestList', editEmployeeID).success(function(datas) {
                        $scope.rowCollectionlere = datas.employeeLetterReqBeanList;
                    });
            }
                
         
            
            $scope.getAddressBookList = function(employeeId) {
                $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/getAddressBookList', editEmployeeID).success(function(datas) {
                    $scope.rowCollectionaddress = datas.employeeadddressBeanList;
                });
        }
            
                
                $scope.getSettlementList = function(employeeId) {
                    $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/getSettlementList', editEmployeeID).success(function(datas) {
                        $scope.rowCollectionsettle = datas.employeeSettleBeanList;
                    });
                }
                
                $scope.getPassportRelease = function(employeeId) {
                    $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/getPassportRelease', editEmployeeID).success(function(datas) {
                        $scope.rowCollectionpassport = datas.employeePassportBeanList;
                    });
                }
                
                $scope.getpayrolldeductionList = function(employeeId) {
                    $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/getpayrolldeductionList', editEmployeeID).success(function(datas) {
                        $scope.rowCollectionPayd = datas.employeePayrolldedBeanList;
                    });
                }
                
                
                
                $scope.geformrevieList = function(employeeId) {
                    $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/getformList', editEmployeeID).success(function(datas) {
                        $scope.rowCollectionform = datas.employeeFormrevList;
                    });
                }
                
                
                $scope.getConsume = function(employeeId) {
                    $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/getEndofserviceList', editEmployeeID).success(function(datas) {
                        $scope.rowCollectionconsuem = datas.employeeEndsetBeanList;
                    });
                }
                
                $scope.getTravelhistoryList = function(employeeId) {
                    $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/gettravelHistorysList', editEmployeeID).success(function(datas) {
                        $scope.rowCollectiontravel = datas.employeeTravelhistoryBeanList;
                    });
                }
                
                $scope.getPayrollBankList = function(employeeId) {
                    $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/getPayrollBankList', editEmployeeID).success(function(datas) {
                        $scope.rowCollectionpay = datas.employeePayrollBankBeanList;
                    });
                }
                
                
                
                
                $scope.getLoanList = function(employeeId) {
                    $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/getLoanList', editEmployeeID).success(function(datas) {
                        $scope.rowCollectionLoan = datas.employeeLoanBeanList;
                    });
                }
                
                
                $scope.getReferenceList = function(employeeId) {
                    $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/getReferenceList', editEmployeeID).success(function(datas) {
                    	 $scope.rowCollectionRef = datas.employeeReferanceBeanList;
                    });
                }
                
                
                
                
                $scope.getContractList = function(employeeId) {
                    $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/getContractList', editEmployeeID).success(function(datas) {
                        $scope.rowCollectioncontract = datas.employeecontractBeanList;
                    });
                }
                
                $scope.employeeExperianceList(editEmployeeID);
                $scope.employeeEducationList(editEmployeeID);
                $scope.employeeMeritList(editEmployeeID);
                $scope.getProbationList(editEmployeeID);
                $scope.getReferenceList(editEmployeeID);
                $scope.getEmergencyList(editEmployeeID);
                $scope.employeeDocumentList(editEmployeeID);
                $scope.employeeFamilyList(editEmployeeID);
                $scope.getNominationList(editEmployeeID);
                $scope.getLeaveList(editEmployeeID);
                $scope.getpayrolldeductionList(editEmployeeID);
                $scope.getPayrollBankList(editEmployeeID);
                $scope.getAirClaimList(editEmployeeID);
                $scope.getSettlementList(editEmployeeID);
                $scope.getTravelhistoryList(editEmployeeID);
                $scope.getLetterRequestList(editEmployeeID);
                $scope.getAddressBookList(editEmployeeID);
                $scope.getPassportRelease(editEmployeeID);
                $scope.getAssetsList(editEmployeeID);
                $scope.getPayslipList(editEmployeeID);
                $scope.geformrevieList(editEmployeeID);
                $scope.getContractList(editEmployeeID);
            }
        }).error(function(data) {

        });

        // $scope.EmployeeMasterData.empId=editEmployeeID;
    }

    $scope.setForm = function(form) {
        $scope.myForm = form;
    }
    $scope.showLabel = "Personal Info";

    var isLoad = true;
    var oldVal = $filter('filter')($scope.tabs, {
        active : true
    })[0].index;
    $scope.showBtnLabel = $scope.tabs[oldVal + 1].name;
    $scope.tabLabel = function(newVal) {
        $scope.showLabel = $scope.tabs[newVal].name;
        if ($scope.employeeId == "" || $scope.employeeId == null) {
            logger.logError("Please Save Profile");
        } else {
            $scope.tabs[oldVal].active = false;
            $scope.tabs[newVal + 1].active = true;
            oldVal = newVal;
            newVal = newVal + 1;
            $("#" + newVal).show();
        }
    }
    var flag;
    $scope.validate = function(profileForm, EmployeeMasterData) {
        var formName = profileForm;
        if (new validationService().checkFormValidity($scope.myForm[formName])) {
            if (!$scope.isEdit) {
                flag = false;
                return flag;
            }
        } else {
            toaster.pop('error', "Please fill the required fields in " + formName, logger.getErrorHtmlNew($scope.myForm[formName].$validationSummary), 555000, 'trustedHtml');
            flag = true;
            return flag;
        }
        return flag;
    };
    $scope.setInActive = function(index) {
        var activeVal = $scope.EmployeeMasterData.isEdit
        if (activeVal == false) {
            $scope.showLabel = $scope.tabs[index].name;
            $scope.tabs[index].active = false;
            $scope.tabs[oldVal].active = true;
            activeVal = index;
        } else if (activeVal == true) {
            $scope.tabs[index].active = true;
        }
        
        if(index == 11){
        	 var editEmployeeID = $state.params.empId;
        	$scope.getLoanList(editEmployeeID);
        }
        if(index == 6){
       	 var editEmployeeID = $state.params.empId;
       	$scope.getLeaveList(editEmployeeID);
       }
    }
    $scope.next = function() {
        var index1 = oldVal;
        var activeVal = $filter('filter')($scope.tabs, {
            active : true
        })[0].index;
        var val = $filter('filter')($scope.tabs, {
            index : oldVal
        })[0];
        $scope.showLabel = $scope.tabs[activeVal].name;
        if ($scope.employeeId == "" || $scope.employeeId == null) {
            logger.logError("Please Save Profile");
        } else {
            oldVal = oldVal + 1;
            val = $filter('filter')($scope.tabs, {
                index : activeVal + 1
            })[0];
            $scope.tabs[val.index].active = true;
        }
    }
    
    $scope.next1 = function() {
}
    $scope.previous = function() {
        var activeVal = $filter('filter')($scope.tabs, {
            active : true
        })[0].index;
        var val = $filter('filter')($scope.tabs, {
            index : oldVal
        })[0];
        $scope.showLabel = $scope.tabs[activeVal].name;
        flag = false;
        if (flag == false) {
            oldVal = oldVal - 1;
            if (oldVal == -1) {
                oldVal = 0;
            }
            activeVal = activeVal - 1;
            val = $filter('filter')($scope.tabs, {
                index : activeVal
            })[0];
            $scope.tabs[val.index].active = true;
        }
    }
    $scope.tabLabelPrevious = function() {
        var activeVal = $filter('filter')($scope.tabs, {
            active : true
        })[0].index;
        var val = $filter('filter')($scope.tabs, {
            index : oldVal
        })[0];
        $scope.showLabel = $scope.tabs[activeVal].name;
        flag = false;
        if (flag == false) {
            oldVal = oldVal - 1;
            if (oldVal == -1) {
                oldVal = 0;
            }
            activeVal = activeVal - 1;
            val = $filter('filter')($scope.tabs, {
                index : activeVal
            })[0];
            $scope.tabs[val.index].active = true;
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
    $scope.search  = function(bean){

        $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/getLeaveListSeach', bean).success(function(datas) {
            $scope.rowCollectionLeave = datas.employeeLeaveBeanList;
        });
        }
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

    var employeefirstId = '';

    $scope.$watch('EmployeeMasterData.dob', function(newValue, oldValue) {
        if (newValue != undefined && newValue != null && newValue != '') {
            var todayDate = $scope.currentDate;
            var oneDay = 24 * 60 * 60 * 1000;
            var toDate = newValue;
            toDate = toDate.split("/");
            toDate = new Date(toDate[2], toDate[1] - 1, toDate[0]);
            todayDate = todayDate.split("/");
            todayDate = new Date(todayDate[2], todayDate[1] - 1, todayDate[0]);
            if (toDate <= todayDate) {
            } else {
                $scope.EmployeeMasterData.dob = "";
                logger.logError("DOB Should be lesser than the current date");
            }
            
            if($scope.EmployeeMasterData.doj!=undefined && $scope.EmployeeMasterData.doj!='' && $scope.EmployeeMasterData.doj!=null){
                var doj = $scope.EmployeeMasterData.doj;
                doj = doj.split("/");
                doj = new Date(doj[2], doj[1] - 1, doj[0]);
                if(doj < toDate){
                    $scope.EmployeeMasterData.doj = "";
                    logger.logError("DOJ Should be greater than the DOB");
                }else{
                    var diffDays = Math.round(Math.abs((toDate.getTime() - doj.getTime()) / (oneDay)));
                    if (parseInt(diffDays) < 6205) {
                        logger.logError("Invalid Date of Joining!");
                        $scope.EmployeeMasterData.doj = "";
                    }
                }
            }
        }
        
    });

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

                /**
                 * ******************* Added for Employee History
                 * ***********************************
                 */

                var companyName = $("#companyCode option:selected").text();
                var branchName = $("#branch option:selected").text();
                var departmentName = $("#departmentId option:selected").text();
                var designation = $("#designation option:selected").text();
                var division = $("#division option:selected").text();
                var grade = $("#grade option:selected").text();
                var reportToBranch = $("#reportToBranch option:selected").text();
                var reportDeptName = $("#reportDeptId option:selected").text();
                var reportMangrName = $("#reportMangrId option:selected").text();
                var reportDesigName = $("#reportDesigId option:selected").text();
                var typeOfEmp = $("#typeOfEmp option:selected").text();

                $scope.employeeDuplicate = [ {
                    columnName : 'Hospital Name',
                    oldValue : '',
                    newValue : companyName,
                    active : false,
                    index : 0
                }, {
                    columnName : 'Branch',
                    oldValue : '',
                    newValue : branchName,
                    active : false,
                    index : 1
                }, {
                    columnName : 'Department',
                    oldValue : '',
                    newValue : departmentName,
                    active : false,
                    index : 2
                }, {
                    columnName : 'Designation',
                    oldValue : '',
                    newValue : designation,
                    active : false,
                    index : 3
                }, {
                    columnName : 'Division',
                    oldValue : '',
                    newValue : division,
                    active : false,
                    index : 4
                }, {
                    columnName : 'Grade',
                    oldValue : '',
                    newValue : grade,
                    active : false,
                    index : 5
                }, {
                    columnName : 'Report To Branch',
                    oldValue : '',
                    newValue : reportToBranch,
                    active : false,
                    index : 6
                }, {
                    columnName : 'Report To Department',
                    oldValue : '',
                    newValue : reportDeptName,
                    active : false,
                    index : 7
                }, {
                    columnName : 'Reporting Authority',
                    oldValue : '',
                    newValue : reportMangrName,
                    active : false,
                    index : 8
                }, {
                    columnName : 'Report To Designation',
                    oldValue : '',
                    newValue : reportDesigName,
                    active : false,
                    index : 9
                }, {
                    columnName : 'Type Of Employment',
                    oldValue : '',
                    newValue : typeOfEmp,
                    active : false,
                    index : 10
                } ];

                $scope.EmployeeMasterData.employeeDuplicateList = $scope.employeeDuplicate;

                /**
                 * ******************* Added for Employee History
                 * ***********************************
                 */
                
                if($scope.EmployeeMasterData.esic!=''&& $scope.EmployeeMasterData.esic!=null && $scope.EmployeeMasterData.esic!=undefined && $scope.EmployeeMasterData.epfNo!=''&&$scope.EmployeeMasterData.epfNo!=null && $scope.EmployeeMasterData.epfNo!=undefined){
                    if($scope.EmployeeMasterData.esic!=$scope.EmployeeMasterData.epfNo){
                        $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/save', $scope.EmployeeMasterData).success(function(result) {                               
                            if (result.success == true) {
                                console.log(result.success);
                                    $scope.EmployeeMasterData.empId = result.employeeId;
                                    $scope.EmployeeMasterData.empUserId = result.empUserId;
                                    $scope.employeeId = result.employeeId;
                                    employeefirstId = result.employeeId;
                                    $scope.profileEdit = true;
                                    $scope.resetEdit=true;
                                    logger.logSuccess("Saved Succesfully!");
                                    ngDialog.open({
                                        template : 'employeeConfirm',
                                        scope : $scope
                                    });

                                } else {
                                    logger.logError("User Id or Email Id already exist!");
                                }
                        });
                    }else{
                        logger.logError("ESIC No and EPF No Should be different!");
                    }
                }else{
                    $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/save', $scope.EmployeeMasterData).success(function(result) {
                        if(result.status!=302){
                        if (result.success == true) {
                            $scope.EmployeeMasterData.empId = result.employeeId;
                            $scope.employeeId = result.employeeId;
                            employeefirstId = result.employeeId;
                            $scope.profileEdit = true;
                            logger.logSuccess("Saved Succesfully!");
                            ngDialog.open({
                                template : 'employeeConfirm',
                                scope : $scope
                            });

                        } else {
                            logger.logSuccess("Saved Succesfully!");
                           ngDialog.open({
                                template : 'employeeConfirm',
                                scope : $scope
                            });
                           // $state.go('app.hrms.master.employeeMaster.adminlist');
                        }
                        }else{
                            logger.logError("User Id or Email Id already exist!");
                        }
                    });
                }
                
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
                 console.log($scope.EmployeeMasterData)
                if($scope.EmployeeMasterData.esic!=''&& $scope.EmployeeMasterData.esic!=null && $scope.EmployeeMasterData.esic!=undefined && $scope.EmployeeMasterData.epfNo!=''&&$scope.EmployeeMasterData.epfNo!=null && $scope.EmployeeMasterData.epfNo!=undefined){
                    if($scope.EmployeeMasterData.esic!=$scope.EmployeeMasterData.epfNo){
                        $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/updateProfile', EmployeeMasterData).success(function(result) {
                            editEmployeeID = EmployeeMasterData.empId;
                            if (result == true) {
                                logger.logSuccess("Updated Succesfully!");
                                $state.go('app.hrms.master.employeeAdminMaster.edit', {
                                    empId : editEmployeeID
                                });
                            } else {
                                logger.logError("Not Saved  or user id already exist!");
                            }
                        });
                    }else{
                        logger.logError("ESIC No and EPF No Should be different!");
                    }
                }else{
                    $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/updateProfile', EmployeeMasterData).success(function(result) {
                        editEmployeeID = EmployeeMasterData.empId;
                        debugger;
                        if (result == true) {
                            logger.logSuccess("Updated Succesfully!");
                            $state.go('app.hrms.master.employeeAdminMaster.edit', {
                                empId : editEmployeeID
                            });
                        } else {
                            logger.logError("Not Saved or user id already exist!");
                        }
                      
                    });
                }
                
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
    };
   
    $scope.savePersonalInfo = function(frmPersonal, EmployeeMasterDataPersonal) {
        EmployeeMasterDataPersonal.empId = $scope.employeeId;
        if (new validationService().checkFormValidity(frmPersonal)) {
            var isPanNo=true,isMBl=true;
            if(EmployeeMasterDataPersonal.panNo!=undefined && EmployeeMasterDataPersonal.panNo!=null && EmployeeMasterDataPersonal.panNo!=''){
            } if(EmployeeMasterDataPersonal.emgContactNo!=undefined && EmployeeMasterDataPersonal.emgContactNo!=null && EmployeeMasterDataPersonal.emgContactNo!=''){
            }
            if(isPanNo==true && isMBl==true){
                $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/savePersonal', EmployeeMasterDataPersonal).success(function(result) {
                    if (result.success == true) {
                        $scope.employeeId = result.empId;
                        $scope.isPersonal = true;
                        logger.logSuccess("Saved Succesfully!");

                    } else {
                        logger.logError("Not Saved!");
                    }
                });
            }else{
                if(isPanNo==false){
                    logger.logError("Please Enter Valid Pan Number");
                }if(isMBl==false){
                    logger.logError("Please Enter Valid Contact Number");
                }
                
                
            }
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(frmPersonal.$validationSummary), 5000, 'trustedHtml');
            }
        
    };
    $scope.EmployeeMasterDataAddress.isActiveAddress = "N"
    
    $scope.copyAddress = function(EmployeeMasterDataAddress) {
        console.log($scope.EmployeeMasterDataAddress);
        if (EmployeeMasterDataAddress.isActiveAddress == "Y") {
            EmployeeMasterDataAddress.presentAddress = EmployeeMasterDataAddress.permAddress;
            EmployeeMasterDataAddress.presentMobile = EmployeeMasterDataAddress.permMobile;
            EmployeeMasterDataAddress.presentPhone = EmployeeMasterDataAddress.permPhone;
            EmployeeMasterDataAddress.presentPin = EmployeeMasterDataAddress.permPin;
            EmployeeMasterDataAddress.presentDistrict = EmployeeMasterDataAddress.permDistrict;
            EmployeeMasterDataAddress.presentPlace = EmployeeMasterDataAddress.permPlace;
        } else {
            if (EmployeeMasterDataAddress.isActiveAddress == "N") {
                // alert(editEmployeeID);
                if (editEmployeeID != undefined && editEmployeeID != null && editEmployeeID != '') {
                    $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/editAddress?empId=' + editEmployeeID).success(function(result) {
                        console.log(result);

                        if (result.objEmployeeMasterAddressBean != undefined && result.objEmployeeMasterAddressBean != null && result.objEmployeeMasterAddressBean != '') {
                            $scope.EmployeeMasterDataAddress.presentAddress = result.objEmployeeMasterAddressBean.presentAddress;
                            $scope.EmployeeMasterDataAddress.presentMobile = result.objEmployeeMasterAddressBean.presentMobile;
                            $scope.EmployeeMasterDataAddress.presentPhone = result.objEmployeeMasterAddressBean.presentPhone;
                            $scope.EmployeeMasterDataAddress.presentPin = result.objEmployeeMasterAddressBean.presentPin;
                            $scope.EmployeeMasterDataAddress.presentDistrict = result.objEmployeeMasterAddressBean.presentDistrict;
                            $scope.EmployeeMasterDataAddress.presentPlace = result.objEmployeeMasterAddressBean.presentPlace;
                        } else {
                            EmployeeMasterDataAddress.presentAddress = '';
                            EmployeeMasterDataAddress.presentMobile = '';
                            EmployeeMasterDataAddress.presentPhone = '';
                            EmployeeMasterDataAddress.presentPin = '';
                            EmployeeMasterDataAddress.presentDistrict = '';
                            EmployeeMasterDataAddress.presentPlace = '';
                        }

                    })

                } else {
                    $scope.EmployeeMasterDataAddress.presentAddress = '';
                    $scope.EmployeeMasterDataAddress.presentMobile = '';
                    $scope.EmployeeMasterDataAddress.presentPhone = '';
                    $scope.EmployeeMasterDataAddress.presentPin = '';
                    $scope.EmployeeMasterDataAddress.presentDistrict = '';
                    $scope.EmployeeMasterDataAddress.presentPlace = '';
                }

            }
        }

        console.log($scope.EmployeeMasterDataAddress);
    }
    $scope.saveAddress = function(frmAddress, EmployeeMasterDataAddress) {
        var flag1 = true, flag2 = true, flag3 = true, flag4 = true, flag5 = true, flag6 = true;
        EmployeeMasterDataAddress.empId = $scope.employeeId;
            if (new validationService().checkFormValidity(frmAddress)) {
                if (EmployeeMasterDataAddress.permPin != undefined && EmployeeMasterDataAddress.permPin != null && EmployeeMasterDataAddress.permPin != '') {
                    flag1 = validatePinCode(EmployeeMasterDataAddress.permPin);
             }
            if (EmployeeMasterDataAddress.permPhone != undefined && EmployeeMasterDataAddress.permPhone != null && EmployeeMasterDataAddress.permPhone != '') {
                    flag2 = validateMobileNumber(EmployeeMasterDataAddress.permPhone);
            }
            if (EmployeeMasterDataAddress.permMobile != undefined && EmployeeMasterDataAddress.permMobile != null && EmployeeMasterDataAddress.permMobile != '') {
                    flag3 = validatePhoneNumber(EmployeeMasterDataAddress.permMobile);;
            }
            if (EmployeeMasterDataAddress.presentPin != undefined && EmployeeMasterDataAddress.presentPin != null && EmployeeMasterDataAddress.presentPin != '') {
                    flag4 = validatePinCode(EmployeeMasterDataAddress.presentPin);
            }
            if (EmployeeMasterDataAddress.presentPhone != undefined && EmployeeMasterDataAddress.presentPhone != null && EmployeeMasterDataAddress.presentPhone != '') {
                    flag5 = validatePhoneNumber(EmployeeMasterDataAddress.presentPhone);
            }
            if (EmployeeMasterDataAddress.presentMobile != undefined && EmployeeMasterDataAddress.presentMobile != null && EmployeeMasterDataAddress.presentMobile != '') {
                    flag6 = validateMobileNumber(EmployeeMasterDataAddress.presentMobile);
            }
            if (flag1 == true && flag2 == true && flag2 == true && flag3 == true && flag4 == true && flag5 == true && flag6 == true) {
                $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/saveAddress', EmployeeMasterDataAddress).success(function(result) {
                    console.log("result is" + result);
                    console.log(result);
                    if (result.success == true) {
                        $scope.employeeId = result.empId;
                        $scope.isAddress = true;
                        $scope.isOnLoad = true;
                        logger.logSuccess("Saved Succesfully!");
                    } else {
                        logger.logError("Not Saved!");
                    }
                });
            } else {
                if (flag1 == false) {
                    logger.logError("Please Enter Valid Pin Number");
                }
                if (flag2 == false) {
                    logger.logError("Please Enter Valid Phone Number");
                }
                if (flag3 == false) {
                    logger.logError("Please Enter Valid Permanent Mobile Number");
                }
                if (flag4 == false) {
                    logger.logError("Please Enter Valid Persent Pin Number");
                }
                if (flag5 == false) {
                    logger.logError("Please Enter Valid Persent Phone Number");
                }
                if (flag6 == false) {
                    logger.logError("Please Enter Valid Persent Mobile Number");
                }
            }
        } else {
            toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(frmAddress.$validationSummary), 5000, 'trustedHtml');
        }
    };

    /*
     * $scope.validateRule = function(frmRule,EmployeeMasterDataRule) { if
     * (new validationService().checkFormValidity(frmRule)) {
     * if(!$scope.isEdit){ $scope.saveRules(frmRule,EmployeeMasterDataRule);
     * }else{ $scope.updateRules(frmRule,EmployeeMasterDataRule); } } else {
     * toaster.pop('error', "Please fill the required fields",
     * logger.getErrorHtmlNew(frmRule.$validationSummary),5000,
     * 'trustedHtml'); } };
     */
    $scope.saveRules = function(frmRule, EmployeeMasterDataRule) {
        EmployeeMasterDataRule.empId = $scope.employeeId;
        if (new validationService().checkFormValidity(frmRule)) {
            $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/saveRules', EmployeeMasterDataRule).success(function(result) {
                if (result.success == true) {
                    $scope.employeeId = result.empId;
                    $scope.isSave = true;
                    logger.logSuccess("Saved Succesfully!");

                } else {
                    logger.logError("Not Saved!");
                }
            });
        } else {
            toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(frmRule.$validationSummary), 5000, 'trustedHtml');
        }
    };

    $scope.validateNumberChar = function(numberchar) {
        var regex = new RegExp("^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$");
        if (regex.test(numberchar)) {
            return true;
        } else {
            return false;
        }
    }

    var dateObj = new Date();
    var cur_month = dateObj.getUTCMonth() + 1; // months from 1-12
    var cur_year = dateObj.getUTCFullYear();
    var cur_day = dateObj.getUTCDate();
    $scope.currentDate = cur_day + "/" + cur_month + "/" + cur_year;
    

  

    $scope.$watch('EmployeeMasterDataPerDet.issuedDate', function(newValue, oldValue) {
        if (newValue != undefined && newValue != null && newValue != '') {
         
            if(!$scope.isEdit || $scope.isEdit==undefined){
                var todayDate = $scope.currentDate;
                var dobDate = $scope.EmployeeMasterData.dob;
                dobDate = dobDate.split("/");
                dobDate = new Date(dobDate[2], dobDate[1] - 1, dobDate[0]);
                var toDate = newValue;
                toDate = toDate.split("/");
                toDate = new Date(toDate[2], toDate[1] - 1, toDate[0]);
                todayDate = todayDate.split("/");
                todayDate = new Date(todayDate[2], todayDate[1] - 1, todayDate[0]);
                if (toDate < todayDate && toDate >  dobDate) {
                } else {
                    $scope.EmployeeMasterDataPerDet.issuedDate = "";
                    logger.logError("Issued date Should be lesser than the current date and greater than employee date of birth");
                }
            }
           
        }
    });

    

    $scope.$watch('EmployeeMasterDataPerDet.licenseIssuedDate', function(newValue, oldValue) {
        if (newValue != undefined && newValue != null && newValue != '') {
            if(!$scope.isEdit || $scope.isEdit==undefined){
                var dobDate = $scope.EmployeeMasterData.dob;
                dobDate = dobDate.split("/");
                dobDate = new Date(dobDate[2], dobDate[1] - 1, dobDate[0]);
                var todayDate = $scope.currentDate;
                var toDate = newValue;
                toDate = toDate.split("/");
                toDate = new Date(toDate[2], toDate[1] - 1, toDate[0]);
                todayDate = todayDate.split("/");
                todayDate = new Date(todayDate[2], todayDate[1] - 1, todayDate[0]);
                if (toDate < todayDate && toDate > dobDate) {
                } else {
                    $scope.EmployeeMasterDataPerDet.licenseIssuedDate = "";
                    logger.logError("License Issued date should be lesser than the current date and greater than the Employee dob date");
                }
            }
        }
    });

   
    $scope.$watch('EmployeeMasterDataPerDet.visaIssuedDate', function(newValue, oldValue) {
        if (newValue != undefined && newValue != null && newValue != '') {
                if(!$scope.isEdit || $scope.isEdit==undefined){
                var todayDate = $scope.currentDate;
                var dobDate = $scope.EmployeeMasterData.dob;
                dobDate = dobDate.split("/");
                dobDate = new Date(dobDate[2], dobDate[1] - 1, dobDate[0]);
                var toDate = newValue;
                toDate = toDate.split("/");
                toDate = new Date(toDate[2], toDate[1] - 1, toDate[0]);
                todayDate = todayDate.split("/");
                todayDate = new Date(todayDate[2], todayDate[1] - 1, todayDate[0]);
                if (toDate < todayDate && toDate > dobDate) {
                } else {
                    $scope.EmployeeMasterDataPerDet.visaIssuedDate = "";
                    logger.logError("Vissa Issue date Should be lesser than the current date");
                }
            }
        }
    });

    $scope.$watch('EmployeeMasterDataPerDet.expiryDate', function(newValue, oldValue) {
        if (newValue != undefined && newValue != null && newValue != '') {
            if(!$scope.isEdit || $scope.isEdit==undefined){
                var isExp=true;
                var toDate = newValue;
                toDate = toDate.split("/");
                toDate = new Date(toDate[2], toDate[1] - 1, toDate[0]);
                var currentDate = $scope.date;
                currentDate = currentDate.split("/");
                currentDate = new Date(currentDate[2], currentDate[1] - 1, currentDate[0]);
                if(toDate >  currentDate){
                if($scope.EmployeeMasterDataPerDet.issuedDate!=undefined && $scope.EmployeeMasterDataPerDet.issuedDate!=null && $scope.EmployeeMasterDataPerDet.issuedDate!=''){
                    var issueDate = $scope.EmployeeMasterDataPerDet.issuedDate;
                     issueDate = issueDate.split("/");
                    issueDate = new Date(issueDate[2], issueDate[1] - 1, issueDate[0]);
                    if (toDate > issueDate) {
                    } else {
                        isExp=false;
                    }
                  }
                }else{
                    isExp=false;
                }if(isExp==false){
                    $scope.EmployeeMasterDataPerDet.expiryDate = "";
                    logger.logError("Passport Expiry Date should be greater than Passport Issue date and current date");

                }
            }
        }
    });
    

    
    $scope.$watch('EmployeeMasterDataPerDet.licenseexpiryDate', function(newValue, oldValue) {
        if (newValue != undefined && newValue != null && newValue != '') {
            if(!$scope.isEdit || $scope.isEdit==undefined){
                var isExp=true;
                var toDate = newValue;
                toDate = toDate.split("/");
                toDate = new Date(toDate[2], toDate[1] - 1, toDate[0]);
                var currentDate = $scope.date;
                currentDate = currentDate.split("/");
                currentDate = new Date(currentDate[2], currentDate[1] - 1, currentDate[0]);
                if(toDate >  currentDate){
                if($scope.EmployeeMasterDataPerDet.licenseIssuedDate!=undefined && $scope.EmployeeMasterDataPerDet.licenseIssuedDate!=null && $scope.EmployeeMasterDataPerDet.licenseIssuedDate!=''){
                    var issueDate = $scope.EmployeeMasterDataPerDet.licenseIssuedDate;
                     issueDate = issueDate.split("/");
                    issueDate = new Date(issueDate[2], issueDate[1] - 1, issueDate[0]);
                    if (toDate > issueDate) {
                    } else {
                        isExp=false;
                    }
                  }
                }else{
                    isExp=false;
                }if(isExp==false){
                    $scope.EmployeeMasterDataPerDet.licenseexpiryDate = "";
                    logger.logError("Driving License Expiry Date should be greater than Driving License Issue date and current date");
                }
            }
        }
    });
    
 
    $scope.$watch('EmployeeMasterDataPerDet.visaExpiryDate', function(newValue, oldValue) {
        if (newValue != undefined && newValue != null && newValue != '') {
            if (!$scope.isEdit || $scope.isEdit==undefined){
                var isExp=true;
                var toDate = newValue;
                toDate = toDate.split("/");
                toDate = new Date(toDate[2], toDate[1] - 1, toDate[0]);
                var currentDate = $scope.date;
                currentDate = currentDate.split("/");
                currentDate = new Date(currentDate[2], currentDate[1] - 1, currentDate[0]);
                if(toDate >  currentDate){
                if($scope.EmployeeMasterDataPerDet.visaIssuedDate!=undefined && $scope.EmployeeMasterDataPerDet.visaIssuedDate!=null && $scope.EmployeeMasterDataPerDet.visaIssuedDate!=''){
                    var issueDate = $scope.EmployeeMasterDataPerDet.visaIssuedDate;
                     issueDate = issueDate.split("/");
                    issueDate = new Date(issueDate[2], issueDate[1] - 1, issueDate[0]);
                    if (toDate > issueDate) {
                    } else {
                        isExp=false;
                    }
                  }
                }else{
                    isExp=false;
                }if(isExp==false){
                    $scope.EmployeeMasterDataPerDet.visaExpiryDate = "";
                    logger.logError("Visa Expiry Date should be greater than Visa Issue date and current date");

                }
            }
        }
    });
    
    
    $scope.$watch('EmployeeMasterDataPerDet.renewalDate', function(newValue, oldValue) {
        if (newValue != undefined && newValue != null && newValue != '') {
            if (!$scope.isEdit || $scope.isEdit==undefined){
                var isExp=true;
                var toDate = newValue;
                toDate = toDate.split("/");
                toDate = new Date(toDate[2], toDate[1] - 1, toDate[0]);
                var currentDate = $scope.date;
                currentDate = currentDate.split("/");
                currentDate = new Date(currentDate[2], currentDate[1] - 1, currentDate[0]);
                if(toDate >  currentDate){
                if($scope.EmployeeMasterDataPerDet.licenseexpiryDate!=undefined && $scope.EmployeeMasterDataPerDet.licenseexpiryDate!=null && $scope.EmployeeMasterDataPerDet.licenseexpiryDate!=''){
                    var expDate = $scope.EmployeeMasterDataPerDet.licenseexpiryDate;
                    expDate = expDate.split("/");
                    expDate = new Date(expDate[2], expDate[1] - 1, expDate[0]);
                    if (toDate < expDate) {
                    } else {
                        isExp=false;
                    }
                  }
                }else{
                    isExp=false;
                }if(isExp==false){
                    $scope.EmployeeMasterDataPerDet.renewalDate = "";
                    logger.logError("Renewal Date should be greater than current date and lesser Expiry than the ");

                }
            }
        }
    });

 

    $scope.saveDocumentDet = function(frmPersonalDetails, EmployeeMasterDataPerDet) {
        EmployeeMasterDataPerDet.empId = $scope.employeeId;
        var flag = true;
        var flag1 = true;
        console.log("saveDocument");
        console.log(EmployeeMasterDataPerDet);
        if (new validationService().checkFormValidity(frmPersonalDetails)) {
            if (EmployeeMasterDataPerDet.licenseNo != undefined && EmployeeMasterDataPerDet.licenseNo != null && EmployeeMasterDataPerDet.licenseNo != '') {
                flag = $scope.validateNumberChar(EmployeeMasterDataPerDet.licenseNo);
            }
            if (EmployeeMasterDataPerDet.passportNo != undefined && EmployeeMasterDataPerDet.passportNo != null && EmployeeMasterDataPerDet.passportNo != '') {
                flag1 = validatePassPortNumber(EmployeeMasterDataPerDet.passportNo);
            }
            if (flag == true && flag1 == true) {
                $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/saveDocument', EmployeeMasterDataPerDet).success(function(result) {
                    if (result.success == true) {
                        $scope.employeeId = result.empId;
                        $scope.isDocument = true;
                        logger.logSuccess("Saved Succesfully!");
                        // $state.go('app.hrms.master.employeeMaster.list');
                    } else {
                        logger.logError("Not Saved!");
                    }
                });
            } else {
                if (flag == false) {
                    logger.logError("Please Enter valid license number!");
                }
                if (flag1 == false) {
                    logger.logError("Please Enter valid passport number!");
                }
            }

        } else {
            toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(frmPersonalDetails.$validationSummary), 5000, 'trustedHtml');
        }
    };
    /*
     * $scope.vaildatePhysical =
     * function(frmPhysical,EmployeeMasterDataPhysical) { if (new
     * validationService().checkFormValidity(frmPhysical)) {
     * if(!$scope.isEdit){
     * $scope.savePhysical(frmPhysical,EmployeeMasterDataPhysical); }else{
     * $scope.updatePhysical(frmPhysical,EmployeeMasterDataPhysical); } }
     * else { toaster.pop('error', "Please fill the required fields",
     * logger.getErrorHtmlNew(frmPhysical.$validationSummary),5000,
     * 'trustedHtml'); } };
     */

    $scope.savePhysical = function(form, EmployeeMasterDataPhysical) {
        EmployeeMasterDataPhysical.empId = $scope.employeeId;
        if (new validationService().checkFormValidity(form)) {
            $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/savePhysical', EmployeeMasterDataPhysical).success(function(result) {
                if (result.success == true) {
                    $scope.employeeId = result.empId;
                    $scope.isPhysical = true;
                    logger.logSuccess("Saved Succesfully!");
                } else {
                    logger.logError("Not Saved!");
                }
            });
        } else {
            toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(frmPhysical.$validationSummary), 5000, 'trustedHtml');
        }
    };
    $scope.addEmergency = function(rowData) {
        var employeeId = "";
        if ($scope.employeeId == "") {
            employeeId = editEmployeeID;
        } else {
            employeeId = $scope.employeeId;
        }
        $scope.isFunction = true;
        $scope.ispop5Edit = false;
        $scope.callDialogEmergency($scope, $scope.isFunction, $scope.employeeEdit, $scope.employeeId, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, rowData);
    }
    $scope.addNomination = function(rowData) {
        var employeeId = "";
        if ($scope.employeeId == "") {
            employeeId = editEmployeeID;
        } else {
            employeeId = $scope.employeeId;
        }
        $scope.isFunction = true;
        $scope.ispop3Edit = false;
        $scope.callDialogNomination($scope, $scope.isFunction, $scope.employeeEdit, $scope.employeeId, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, rowData);
    }
    $scope.addReference = function(rowData) {
        var employeeId = "";
        if ($scope.employeeId == "") {
            employeeId = editEmployeeID;
        } else {
            employeeId = $scope.employeeId;
        }
        $scope.isFunction = true;
        $scope.ispop6Edit = false;
        $scope.callDialogReference($scope, $scope.isFunction, $scope.employeeEdit, $scope.employeeId, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, rowData);
    }
    $scope.addProbation = function(rowData) {
        $scope.isFunction = true;
        $scope.callDialogProbation($scope, $scope.isFunction, $scope.employeeEdit, $scope.employeeId, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, rowData);
    }
    $scope.addDocuments = function(rowData) {
        $scope.isFunction = true;
        $scope.callDialogDocument($scope, $scope.isFunction, $scope.employeeEdit, $scope.employeeId, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, rowData);
    }
    $scope.addFamily = function(rowData) {
        $scope.isFunction = true;
        $scope.callDialogFamily($scope, $scope.isFunction, $scope.employeeEdit, $scope.employeeId, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, rowData);
    }
    $scope.addMerits = function(rowData) {
        $scope.isFunction = true;
        $scope.callDialogMerits($scope, $scope.isFunction, $scope.employeeEdit, $scope.employeeId, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, rowData);
    }
    $scope.addExperiance = function(rowData) {
        $scope.isFunction = true;
        $scope.callDialogExperiance($scope, $scope.isFunction, $scope.employeeEdit, $scope.employeeId, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, rowData);
    }
    $scope.addEducation = function(rowData) {
        $scope.isFunction = true;
        $scope.callDialogEducation($scope, $scope.isFunction, $scope.employeeEdit, $scope.employeeId, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, rowData);
    }
    $scope.addPhoneNo = function(rowData) {
        $scope.callDialog($scope, 0, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, rowData);
    }
    $scope.addMobileNo = function(rowDatas) {
        $scope.callDialogMobile($scope, 0, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, rowDatas);
    }
    $scope.downloadDoc = function(EmployeeMasterDataDoc) {
        if (EmployeeMasterDataDoc.uploadDoc == "" || EmployeeMasterDataDoc.uploadDoc == null) {
            logger.logError("File Not Found..!");
        } else {
            $("#TBExport").bind('click', function() {
            });
            $('#TBExport').simulateClick('click');
        }
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
    $scope.editRowProbation = function(rowData) {
        $scope.isFunction = false;
        $scope.callDialogProbation($scope, $scope.isFunction, $scope.employeeEdit, $scope.employeeId, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, rowData);
    }
    $scope.editRowDoc = function(rowData) {
        $scope.isFunction = false;
        $scope.callDialogDocument($scope, $scope.isFunction, $scope.employeeEdit, $scope.employeeId, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, rowData);
    }
    $scope.editRowFamily = function(rowData) {
        $scope.isFunction = false;
        $scope.callDialogFamily($scope, $scope.isFunction, $scope.employeeEdit, $scope.employeeId, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, rowData);
    }
    $scope.editRowMerits = function(rowData) {
        $scope.isFunction = false;
        $scope.callDialogMerits($scope, $scope.isFunction, $scope.employeeEdit, $scope.employeeId, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, rowData);
    }
    $scope.editRowEducation = function(rowData) {
        $scope.isFunction = false;
        $scope.callDialogEducation($scope, $scope.isFunction, $scope.employeeEdit, $scope.employeeId, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, rowData);
    }
    $scope.editRowExperiance = function(rowData) {
        $scope.isFunction = false;
        $scope.callDialogExperiance($scope, $scope.isFunction, $scope.employeeEdit, $scope.employeeId, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, rowData);
    }
    $scope.editRowEmergency = function(rowData) {
        $scope.isFunction = false;
        $scope.callDialogEmergency($scope, $scope.isFunction, $scope.employeeEdit, $scope.employeeId, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, rowData);
    }
    $scope.editRowNomination = function(rowData) {
        $scope.isFunction = false;
        $scope.callDialogNomination($scope, $scope.isFunction, $scope.employeeEdit, $scope.employeeId, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, rowData);
    }
    $scope.editRowReference = function(rowData) {
        $scope.isFunction = false;
        $scope.callDialogReference($scope, $scope.isFunction, $scope.employeeEdit, $scope.employeeId, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, rowData);
    }
    $scope.getCompanyList();

    $scope.updatePersonalInfo = function(frmPersonal, EmployeeMasterDataPersonal) {
        EmployeeMasterDataPersonal.empId = $scope.employeeId;
        if (new validationService().checkFormValidity(frmPersonal)) {
            var isPanNo=true,isMBl=true;
          
           
            if(isPanNo==true && isMBl==true){
               $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/updatePersonalInfo', EmployeeMasterDataPersonal).success(function(result) {
                   if (result == true) {
                       logger.logSuccess("Updated Succesfully!");
                       $state.go('app.hrms.master.employeeAdminMaster.edit', {
                           empId : $scope.employeeId
                       });
                   } else {
                       logger.logError("Not Saved!");
                   }
               });
           }else{
               if(isPanNo==false){
                   logger.logError("Please Enter Valid Pan Number");
               }if(isMBl==false){
                   logger.logError("Please Enter Valid Contact Number");
               }
               
               
           }
          
        } else {
            toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(frmPersonal.$validationSummary), 5000, 'trustedHtml');
        }
    };

    $scope.updateAddress = function(frmAddress, EmployeeMasterDataAddress) {
        var flag1 = true, flag2 = true, flag3 = true, flag4 = true, flag5 = true, flag6 = true;
        console.log("update Addrss");
        console.log(EmployeeMasterDataAddress);
        EmployeeMasterDataAddress.empId = $scope.employeeId;
        if (new validationService().checkFormValidity(frmAddress)) {
            if (EmployeeMasterDataAddress.permPin != undefined && EmployeeMasterDataAddress.permPin != null && EmployeeMasterDataAddress.permPin != '') {
                    flag1 = validatePinCode(EmployeeMasterDataAddress.permPin);
             }
            if (EmployeeMasterDataAddress.permPhone != undefined && EmployeeMasterDataAddress.permPhone != null && EmployeeMasterDataAddress.permPhone != '') {
                    flag2 = validatePhoneNumber(EmployeeMasterDataAddress.permPhone);
            }
            if (EmployeeMasterDataAddress.permMobile != undefined && EmployeeMasterDataAddress.permMobile != null && EmployeeMasterDataAddress.permMobile != '') {
                    flag3 = validateMobileNumber(EmployeeMasterDataAddress.permMobile);;
            }
            if (EmployeeMasterDataAddress.presentPin != undefined && EmployeeMasterDataAddress.presentPin != null && EmployeeMasterDataAddress.presentPin != '') {
                    flag4 = validatePinCode(EmployeeMasterDataAddress.presentPin);
            }
            if (EmployeeMasterDataAddress.presentPhone != undefined && EmployeeMasterDataAddress.presentPhone != null && EmployeeMasterDataAddress.presentPhone != '') {
                    flag5 = validatePhoneNumber(EmployeeMasterDataAddress.presentPhone);
            }
            if (EmployeeMasterDataAddress.presentMobile != undefined && EmployeeMasterDataAddress.presentMobile != null && EmployeeMasterDataAddress.presentMobile != '') {
                    flag6 = validateMobileNumber(EmployeeMasterDataAddress.presentMobile);
            }
            if (flag1 == true && flag2 == true && flag2 == true && flag3 == true && flag4 == true && flag5 == true && flag6 == true) {
                $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/updateAddress', EmployeeMasterDataAddress).success(function(result) {
                    editEmployeeID = EmployeeMasterDataAddress.empId;
                    if (result == true) {
                        logger.logSuccess("Updated Succesfully!");
                        $state.go('app.hrms.master.employeeAdminMaster.edit', {
                            empId : editEmployeeID
                        });
                    } else {
                        logger.logError("Not Saved!");
                    }
                });
            } else {
                if (flag1 == false) {
                    logger.logError("Please Enter Valid Pin Number");
                }
                if (flag2 == false) {
                    logger.logError("Please Enter Valid Phone Number");
                }
                if (flag3 == false) {
                    logger.logError("Please Enter Valid Mobile Number");
                }
                if (flag4 == false) {
                    logger.logError("Please Enter Valid Persent Pin Number");
                }
                if (flag5 == false) {
                    logger.logError("Please Enter Valid Persent Phone Number");
                }
                if (flag6 == false) {
                    logger.logError("Please Enter Valid Persent Persent Mobile Number");
                }
            }
        } else {
            toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(frmAddress.$validationSummary), 5000, 'trustedHtml');
        }
    }
    $scope.updateRules = function(frmRule, EmployeeMasterDataRule) {
        EmployeeMasterDataRule.empId = $scope.employeeId;
        if (new validationService().checkFormValidity(frmRule)) {
            $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/updateRules', EmployeeMasterDataRule).success(function(result) {
                if (result == true) {
                    logger.logSuccess("Updated Succesfully!");
                    $scope.isOnLoad = true;
                    $state.go('app.hrms.master.employeeAdminMaster.edit', {
                        empId : editEmployeeID
                    });
                } else {
                    logger.logError("Not Saved!");
                }
            });
        } else {
            toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(frmRule.$validationSummary), 5000, 'trustedHtml');
        }
    }
    $scope.updateDocumentDet = function(frmPersonalDetails, EmployeeMasterDataPerDet) {
        if (new validationService().checkFormValidity(frmPersonalDetails)) {
        EmployeeMasterDataPerDet.empId = $scope.employeeId;
        console.log("updateDocument");
        console.log(EmployeeMasterDataPerDet);
        var todayDate = $scope.date;
        todayDate = todayDate.split("/");
        todayDate = new Date(todayDate[2], todayDate[1] - 1, todayDate[0]);
        var flag = true,flag1 = true,flag2 = true,flag3=true,flag4=true,flag5=true,flag8=true,flag6=true,flag7=true;
        if (EmployeeMasterDataPerDet.licenseNo != undefined && EmployeeMasterDataPerDet.licenseNo != null && EmployeeMasterDataPerDet.licenseNo != '') {
            flag = $scope.validateNumberChar(EmployeeMasterDataPerDet.licenseNo);
        }
        if (EmployeeMasterDataPerDet.passportNo != undefined && EmployeeMasterDataPerDet.passportNo != null && EmployeeMasterDataPerDet.passportNo != '') {
            flag1 = validatePassPortNumber(EmployeeMasterDataPerDet.passportNo);
        }
        if($scope.EmployeeMasterDataPerDet.issuedDate!=undefined && $scope.EmployeeMasterDataPerDet.issuedDate!=null && $scope.EmployeeMasterDataPerDet.issuedDate!=''){
            if($scope.copyPasIssueDate !=$scope.EmployeeMasterDataPerDet.issuedDate){
               var fromDate = $scope.EmployeeMasterDataPerDet.issuedDate;
               var dobDate = $scope.EmployeeMasterData.dob;
               dobDate = dobDate.split("/");
               dobDate = new Date(dobDate[2], dobDate[1] - 1, dobDate[0]);
               fromDate = fromDate.split("/");
               fromDate = new Date(fromDate[2], fromDate[1] - 1, fromDate[0]);
               if (fromDate < todayDate && fromDate > dobDate) {
               } else {
                   flag2=false;
                   
               }
           }
        }if($scope.EmployeeMasterDataPerDet.expiryDate!=undefined && $scope.EmployeeMasterDataPerDet.expiryDate!=null && $scope.EmployeeMasterDataPerDet.expiryDate!=''){
           var isExp =true;
           var fromDate = $scope.EmployeeMasterDataPerDet.expiryDate;
           fromDate = fromDate.split("/");
           fromDate = new Date(fromDate[2], fromDate[1] - 1, fromDate[0]);
           
           if($scope.copyPasExpDate !=$scope.EmployeeMasterDataPerDet.expiryDate){
               if (fromDate > todayDate ) {
                   if($scope.EmployeeMasterDataPerDet.issuedDate!=undefined && $scope.EmployeeMasterDataPerDet.issuedDate!=null && $scope.EmployeeMasterDataPerDet.issuedDate!=''){
                       var IssueDate = $scope.EmployeeMasterDataPerDet.issuedDate;
                       IssueDate = IssueDate.split("/");
                       IssueDate = new Date(IssueDate[2], IssueDate[1] - 1, IssueDate[0]);
                       if (fromDate > IssueDate) {
                       } else {
                           isExp=false;
                       }
                   }
               } else {
                   isExp=false
               }if(isExp==false){
                   flag3=false;
               }
           }
        } if($scope.EmployeeMasterDataPerDet.licenseIssuedDate!=undefined && $scope.EmployeeMasterDataPerDet.licenseIssuedDate!=null && $scope.EmployeeMasterDataPerDet.licenseIssuedDate!=''){
            if($scope.copylinExpDate !=$scope.EmployeeMasterDataPerDet.licenseIssuedDate){
                var dobDate = $scope.EmployeeMasterData.dob;
                dobDate = dobDate.split("/");
                dobDate = new Date(dobDate[2], dobDate[1] - 1, dobDate[0]);
                var fromDate = $scope.EmployeeMasterDataPerDet.licenseIssuedDate;
                fromDate = fromDate.split("/");
                fromDate = new Date(fromDate[2], fromDate[1] - 1, fromDate[0]);
                if (fromDate < todayDate && fromDate > dobDate) {
                } else {
                    flag4=false;
                }
            }
         }if($scope.EmployeeMasterDataPerDet.licenseexpiryDate!=undefined && $scope.EmployeeMasterDataPerDet.licenseexpiryDate!=null && $scope.EmployeeMasterDataPerDet.licenseexpiryDate!=''){
            var isExp1 =true;
            var fromDate = $scope.EmployeeMasterDataPerDet.licenseexpiryDate;
            fromDate = fromDate.split("/");
            fromDate = new Date(fromDate[2], fromDate[1] - 1, fromDate[0]);
            var dobDate = $scope.EmployeeMasterData.dob;
            dobDate = dobDate.split("/");
            dobDate = new Date(dobDate[2], dobDate[1] - 1, dobDate[0]);
            if($scope.copylinIssueDate !=$scope.EmployeeMasterDataPerDet.licenseexpiryDate){
                if (fromDate > todayDate ) {
                    if($scope.EmployeeMasterDataPerDet.licenseIssuedDate!=undefined && $scope.EmployeeMasterDataPerDet.licenseIssuedDate!=null && $scope.EmployeeMasterDataPerDet.licenseIssuedDate!=''){
                        var IssueDate = $scope.EmployeeMasterDataPerDet.licenseIssuedDate;
                        IssueDate = IssueDate.split("/");
                        IssueDate = new Date(IssueDate[2], IssueDate[1] - 1, IssueDate[0]);
                        if (fromDate > IssueDate && fromDate > dobDate) {
                        } else {
                            isExp1=false;
                        }
                    }
                } else {
                    isExp1=false
                }if(isExp1==false){
                    flag5=false;
                }
            }
         }if($scope.EmployeeMasterDataPerDet.renewalDate!=undefined && $scope.EmployeeMasterDataPerDet.renewalDate!=null && $scope.EmployeeMasterDataPerDet.renewalDate!=''){
             var isExp1 =true;
             var fromDate = $scope.EmployeeMasterDataPerDet.renewalDate;
             fromDate = fromDate.split("/");
             fromDate = new Date(fromDate[2], fromDate[1] - 1, fromDate[0]);
             if($scope.copylinReDate !=$scope.EmployeeMasterDataPerDet.renewalDate){
                 if (fromDate > todayDate ) {
                     if($scope.EmployeeMasterDataPerDet.licenseexpiryDate!=undefined && $scope.EmployeeMasterDataPerDet.licenseexpiryDate!=null && $scope.EmployeeMasterDataPerDet.licenseexpiryDate!=''){
                         var expDate = $scope.EmployeeMasterDataPerDet.licenseexpiryDate;
                         expDate = expDate.split("/");
                         expDate = new Date(expDate[2], expDate[1] - 1, expDate[0]);
                         if (fromDate < expDate) {
                         } else {
                             isExp1=false;
                         }
                     }
                 } else {
                     isExp1=false
                 }if(isExp1==false){
                     flag8=false;
                 }
             }
          }  
         if($scope.EmployeeMasterDataPerDet.visaIssuedDate!=undefined && $scope.EmployeeMasterDataPerDet.visaIssuedDate!=null && $scope.EmployeeMasterDataPerDet.visaIssuedDate!=''){
             if($scope.copyvisaIssueDate !=$scope.EmployeeMasterDataPerDet.visaIssuedDate){
                 var dobDate = $scope.EmployeeMasterData.dob;
                 dobDate = dobDate.split("/");
                 dobDate = new Date(dobDate[2], dobDate[1] - 1, dobDate[0]);
                 var fromDate = $scope.EmployeeMasterDataPerDet.visaIssuedDate;
                 fromDate = fromDate.split("/");
                 fromDate = new Date(fromDate[2], fromDate[1] - 1, fromDate[0]);
                 if (fromDate < todayDate && fromDate > dobDate) {
                 } else {
                     flag6=false;
                 }
             }
          }if($scope.EmployeeMasterDataPerDet.visaExpiryDate!=undefined && $scope.EmployeeMasterDataPerDet.visaExpiryDate!=null && $scope.EmployeeMasterDataPerDet.visaExpiryDate!=''){
             var isExp2 =true;
             var fromDate = $scope.EmployeeMasterDataPerDet.visaExpiryDate;
             fromDate = fromDate.split("/");
             fromDate = new Date(fromDate[2], fromDate[1] - 1, fromDate[0]);
             if($scope.copyvisaExpDate !=$scope.EmployeeMasterDataPerDet.visaExpiryDate){
                 if (fromDate > todayDate ) {
                     if($scope.EmployeeMasterDataPerDet.visaIssuedDate!=undefined && $scope.EmployeeMasterDataPerDet.visaIssuedDate!=null && $scope.EmployeeMasterDataPerDet.visaIssuedDate!=''){
                         var IssueDate = $scope.EmployeeMasterDataPerDet.visaIssuedDate;
                         IssueDate = IssueDate.split("/");
                         IssueDate = new Date(IssueDate[2], IssueDate[1] - 1, IssueDate[0]);
                         if (fromDate > IssueDate) {
                         } else {
                             isExp2=false;
                         }
                     }
                 } else {
                     isExp2=false
                 }if(isExp2==false){
                     flag7=false;
                 }
             }
          }
     
            if (flag == true && flag1 == true && flag3 == true && flag2 == true && flag4 == true && flag5 == true && flag6 == true && flag7 == true &&  flag8 == true) {
                $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/updateDocument', EmployeeMasterDataPerDet).success(function(result) {
                    if (result == true) {
                        logger.logSuccess("Updated Succesfully!");
                        $state.go('app.hrms.master.employeeAdminMaster.edit', {
                            empId : editEmployeeID
                        });
                    } else {
                        logger.logError("Not Saved!");
                    }
                });
            } else {
                if (flag == false) {
                    logger.logError("Please Enter valid license number!");
                }
                if (flag1 == false) {
                    logger.logError("Please Enter valid passport number!");
                }if (flag2 == false) {
                    $scope.EmployeeMasterDataPerDet.issuedDate = "";
                    logger.logError("Passport Issue Date Should be lesser than the current date and greater than the dob");
                }
                if (flag3 == false) {
                    $scope.EmployeeMasterDataPerDet.expiryDate = "";
                    logger.logError("Passport Expiry Date should be greater than Passport Issue date and current date");

                }if (flag4 == false) {
                    $scope.EmployeeMasterDataPerDet.licenseIssuedDate = "";
                    logger.logError("License IssuedDate Should be lesser than the current date and greater than the dob");
                }
                if (flag5 == false) {
                    $scope.EmployeeMasterDataPerDet.licenseexpiryDate = "";
                    logger.logError("Driving License Expiry Date should be greater than Driving License Issue date and current date");

                }if (flag6 == false) {
                    $scope.EmployeeMasterDataPerDet.visaIssuedDate = "";
                    logger.logError("Vissa Issue date Should be lesser than the current date and greater than the dob");
                }
                if (flag7 == false) {
                    $scope.EmployeeMasterDataPerDet.visaExpiryDate = "";
                    logger.logError("Visa Expiry Date should be greater than Visa Issue date and current date");
                }if (flag8 == false) {
                    $scope.EmployeeMasterDataPerDet.renewalDate = "";
                    logger.logError("Visa Renewal Date should be lesser than Visa Issue date and greate than the current date");
                }
            }

        } else {
            toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(frmPersonalDetails.$validationSummary), 5000, 'trustedHtml');
        }
    }
    $scope.updatePhysical = function(frmPhysical, EmployeeMasterDataPhysical) {
        EmployeeMasterDataPhysical.empId = $scope.employeeId;
        if (new validationService().checkFormValidity(frmPhysical)) {
            $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/updatePhysical', EmployeeMasterDataPhysical).success(function(result) {
                if (result == true) {
                    logger.logSuccess("Updated Succesfully!");
                    $state.go('app.hrms.master.employeeAdminMaster.edit', {
                        empId : editEmployeeID
                    });
                } else {
                    logger.logError("Not Saved!");
                }
            });
        } else {
            toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(frmPhysical.$validationSummary), 5000, 'trustedHtml');
        }
    }
    $scope.resetProfile = function(frmProfile) {
        if ($scope.EmployeeMasterData.isEdit == false) {
            $scope.EmployeeMasterData = angular.copy(tmpEmployeeMasterData);
        } else {
            $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/edit?empId=' + editEmployeeID).success(function(result) {
                if (result.isEdit == false) {
                    logger.logError("Please Try Again");
                } else {
                    $scope.EmployeeMasterData = result.editList[0];
                    $scope.EmployeeMasterData.isEdit = result.isEdit;
                    // $scope.EmployeeMasterData.presentAddressMultiple=result.presentAddressMultiple;
                    // $scope.category($scope.EmployeeMasterData.category);
                    if ($scope.EmployeeMasterData.status == "true") {
                        $scope.EmployeeMasterData.status = 'Y';
                    } else {
                        $scope.EmployeeMasterData.status = 'N';
                    }

                }

            })
        }
    }
    $scope.resetPersonal = function(frmPersonalInfo) {
        if ($scope.resetEdit == false) {
            $scope.EmployeeMasterDataPersonal = angular.copy(tmpEmployeeMasterDataPersonal);
        } else {             
            $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/editPersonal?empId=' + editEmployeeID).success(function(result) {
                console.log(result);
                $scope.isEdit = true;
                if(result.objEmployeeMasterPersonalBean!=null && result.objEmployeeMasterAddressBean!=undefined && result.objEmployeeMasterAddressBean!=''){
                    $scope.EmployeeMasterDataPersonal = result.objEmployeeMasterPersonalBean;
                }else{
                    $scope.EmployeeMasterDataPersonal = {
                        
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
                }
               
            })
        }
    }
    $scope.resetAddress = function(EmployeeMasterDataAddress) {
        debugger
        if ($scope.resetEdit == false) {
            $scope.EmployeeMasterDataAddress = angular.copy(tmpEmployeeMasterDataAddress);
        } else {
            $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/editAddress?empId=' + editEmployeeID).success(function(result) {
                console.log(result);
                $scope.isEdit = true;
                if(result.objEmployeeMasterAddressBean!=null && result.objEmployeeMasterAddressBean!=undefined && result.objEmployeeMasterAddressBean!=""){
                    $scope.EmployeeMasterDataAddress = result.objEmployeeMasterAddressBean;
                }else{
                    $scope.EmployeeMasterDataAddress = {
                        // Address
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
                   
                }
                
             
            })
        }
    }
    $scope.resetRule = function(frmRule) {
        if ($scope.resetEdit == false) {
            $scope.EmployeeMasterDataRule = angular.copy(tmpEmployeeMasterDataRule);
        } else {
            $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/editRule?empId=' + editEmployeeID).success(function(result) {
                console.log(result);
                $scope.isEdit = true;
              if(result.objEmployeeMasterRulesBean!=null && result.objEmployeeMasterRulesBean!=undefined && result.objEmployeeMasterAddressBean!=""){
                
                  $scope.EmployeeMasterDataRule = result.objEmployeeMasterRulesBean;
                }else{
                  
                    $scope.EmployeeMasterDataRule = {
                            overTime : false,
                            esiApp : '',
                            lateApp : '',
                            pfApp : '',
                            earlyExit : false,
                            leaveOption : '',
                            telephoneLimit : '',
                            medicalLimit : '',
                            noticePeriodRule : '',
                        };
                }
              
            })
        }
    }
    $scope.resetPersonalDetails = function(frmPersonalDetails) {
        
        if($scope.resetEdit == false) {
            $scope.EmployeeMasterDataPerDet = angular.copy(tmpEmployeeMasterDataPerDet);
        } else {
            $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/editPerDet?empId=' + editEmployeeID).success(function(result) {
                $scope.isEdit = true;
                if(result.objEmployeeMAsterPerDetailsBean!=null && result.objEmployeeMAsterPerDetailsBean!=undefined && result.objEmployeeMAsterPerDetailsBean!=""){
                    $scope.EmployeeMasterDataPerDet = result.objEmployeeMAsterPerDetailsBean;
                }else{
                    $scope.EmployeeMasterDataPerDet = {
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

                }
                
            })
        }
    }
    $scope.resetPhysical = function(frmPhysical) {
        if ($scope.resetEdit == false) {
            $scope.EmployeeMasterDataPhysical = angular.copy(tmpEmployeeMasterDataPhysical);
        } else {
            $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/editPhysical?empId=' + editEmployeeID).success(function(result) {
                $scope.isEdit = true;
                if(result.objEmployeeMasterPhysicalBean!=null && result.objEmployeeMasterPhysicalBean!=undefined && result.objEmployeeMasterPhysicalBean!=""){
                    $scope.EmployeeMasterDataPhysical = result.objEmployeeMasterPhysicalBean;
                }else{
                    $scope.EmployeeMasterDataPhysical = {
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
                }
               
            })
        }
    }
    // TIF GIF PNG JPG
    $rootScope.uploadFile = function(element) {
        $scope.imgfile = element.files[0];
    }

    $scope.fileName = "/pictures/no-image-icon.jpg";
    $scope.imgFilePath = "";
    $rootScope.uploadProfile = function() {
        var imgfile = $scope.imgfile;
        var fileExtension = imgfile.name;
        var frmData = new FormData();
        frmData.append("file", imgfile);
        frmData.append("fileName", $scope.EmployeeMasterData.empId);
        $scope.imgfile = frmData;
        $.ajax({
            type : "POST",
            url : $stateParams.tenantid+"/hrms/master/employeeAdminMaster/uploadfile",
            data : frmData,
            contentType : false,
            processData : false,
            success : function(result) {
                // $scope.fileName=result.fileName;
                $scope.imgFilePath = result.imgPath + "?";
                $scope.EmployeeMasterData.uploadPhoto = result.imgPath;
                if (result.success) {
                    $('.thumb-image').remove();
                    $('#image-holder').append('<img src="" class="thumb-image" style="max-height:100px;width: 150px;">');
                    $('.thumb-image').attr('src', $scope.imgFilePath + new Date().getTime());
                    logger.logSuccess("File Uploaded Successfully");
                } else {
                    logger.logError("Fail to Upload");
                }
            }
        });
    };
    
    $scope.$watch('EmployeeMasterData.designation', function(newVal, oldVal) {
    	if(newVal!=null && newVal!=undefined && newVal!="")
    	  $http.get($stateParams.tenantid+'/hrms/master/employeeAdminMaster/getDesignationStatus?designationId='+newVal).success(function(response) {
              $scope.driverTab = response.designationStatus;
              $scope.salesTab = response.salesStatus;

          });
    });


    $rootScope.uploadDocFile = function(element) {
        $scope.docfile = element.files[0];
    }
    $scope.docFileName = "";
    $scope.docFilePath = "";
    $rootScope.uploadDocument = function() {
        var docfile = $scope.docfile;
        var fileExtension = docfile.name;
        var frmData = new FormData();
        frmData.append("file", docfile);
        $scope.docfile = frmData;
        $.ajax({
            type : "POST",
            url : $stateParams.tenantid+"/hrms/master/employeeAdminMaster/uploadDocfile",
            data : frmData,
            contentType : false,
            processData : false,
            success : function(result) {
                $scope.docFileName = result.docFileName;
                $scope.docFilePath = result.docPath;
                $scope.EmployeeMasterData.joinDocUpload = result.docPath;
                if (result.success) {
                    logger.logSuccess("Document Uploaded Successfully");
                } else {
                    logger.logError("Fail to Upload");
                }

            }
        });
    };
    $rootScope.closeThisDialog = function() {
        ngDialog.close();
    };

    $("#fileUpload").on('change', function() {
        if (typeof (FileReader) != "undefined") {

            var image_holder = $("#image-holder");
            image_holder.empty();

            var reader = new FileReader();
            reader.onload = function(e) {
                $("<img />", {
                    "src" : e.target.result,
                    "class" : "thumb-image",
                    "style" : " max-height:100px;width: 150px; "
                }).appendTo(image_holder);

            }
            image_holder.show();
            reader.readAsDataURL($(this)[0].files[0]);
        } else {
            alert("This browser does not support FileReader.");
        }
    });

    // Number Only Validation
    $scope.$watch('EmployeeMasterData.fixedGross', function(newVal, oldVal) {
        var newValue = $scope.EmployeeMasterData.fixedGross;
        var arr = String(newValue).split("");
        var oldValue;
        if (arr.length == undefined)
            return;
        else if (arr.length === 0)
            return;
        else if (arr.length === 1 && (arr[2] == '-' || arr[2] === '.'))
            return;

        else if ((newValue != undefined && newValue != '' && isNaN(newValue))) {
            $scope.EmployeeMasterData.fixedGross = oldValue;
            logger.logError("Number Only Allowed");
        }
    });

    // Number Only Validation for Confirmation Period
    $scope.$watch('EmployeeMasterData.confirmationPeriod', function(newVal, oldVal) {
        var newValue = $scope.EmployeeMasterData.confirmationPeriod;
        var arr = String(newValue).split("");
        var oldValue;
        if (arr.length == undefined)
            return;
        else if (arr.length === 0)
            return;
        else if (arr.length === 1 && (arr[2] == '-' || arr[2] === '.'))
            return;

        else if ((newValue != undefined && newValue != '' && isNaN(newValue))) {
            $scope.EmployeeMasterData.confirmationPeriod = oldValue;
            logger.logError("Number Only Allowed");
        }
    });

    // Number Only Validation for Notice Period
    $scope.$watch('EmployeeMasterData.noticePeriod', function(newVal, oldVal) {
        var newValue = $scope.EmployeeMasterData.noticePeriod;
        var arr = String(newValue).split("");
        var oldValue;
        if (arr.length == undefined)
            return;
        else if (arr.length === 0)
            return;
        else if (arr.length === 1 && (arr[2] == '-' || arr[2] === '.'))
            return;

        else if ((newValue != undefined && newValue != '' && isNaN(newValue))) {
            $scope.EmployeeMasterData.noticePeriod = oldValue;
            logger.logError("Number Only Allowed");
        }
    });

    // Number Only Validation for Percentage
    $scope.$watch('EmployeeMasterData.percentage', function(newVal, oldVal) {
        var newValue = $scope.EmployeeMasterData.percentage;
        var arr = String(newValue).split("");
        var oldValue;
        if (arr.length == undefined)
            return;
        else if (arr.length === 0)
            return;
        else if (arr.length === 1 && (arr[2] == '-' || arr[2] === '.'))
            return;

        else if ((newValue != undefined && newValue != '' && isNaN(newValue))) {
            $scope.EmployeeMasterData.percentage = oldValue;
            logger.logError("Number Only Allowed");
        }
    });

    // Number Only Validation for Year of Experience
    $scope.$watch('EmployeeMasterData.experienceYear', function(newVal, oldVal) {
        var newValue = $scope.EmployeeMasterData.experienceYear;
        var arr = String(newValue).split("");
        var oldValue;
        if (arr.length == undefined)
            return;
        else if (arr.length === 0)
            return;
        else if (arr.length === 1 && (arr[2] == '-' || arr[2] === '.'))
            return;

        else if ((newValue != undefined && newValue != '' && isNaN(newValue))) {
            $scope.EmployeeMasterData.experienceYear = oldValue;
            logger.logError("Number Only Allowed");
        }
    });

    // Number Only Validation for Telephone Limit
    $scope.$watch('EmployeeMasterData.telephoneLimit', function(newVal, oldVal) {
        var newValue = $scope.EmployeeMasterData.telephoneLimit;
        var arr = String(newValue).split("");
        var oldValue;
        if (arr.length == undefined)
            return;
        else if (arr.length === 0)
            return;
        else if (arr.length === 1 && (arr[2] == '-' || arr[2] === '.'))
            return;

        else if ((newValue != undefined && newValue != '' && isNaN(newValue))) {
            $scope.EmployeeMasterData.telephoneLimit = oldValue;
            logger.logError("Number Only Allowed");
        }
    });

    // Number Only Validation for Telephone Limit medicalLimit
    $scope.$watch('EmployeeMasterData.medicalLimit', function(newVal, oldVal) {
        var newValue = $scope.EmployeeMasterData.medicalLimit;
        var arr = String(newValue).split("");
        var oldValue;
        if (arr.length == undefined)
            return;
        else if (arr.length === 0)
            return;
        else if (arr.length === 1 && (arr[2] == '-' || arr[2] === '.'))
            return;

        else if ((newValue != undefined && newValue != '' && isNaN(newValue))) {
            $scope.EmployeeMasterData.medicalLimit = oldValue;
            logger.logError("Number Only Allowed");
        }
    });

    // Number Only Validation for Telephone Limit Height
    $scope.$watch('EmployeeMasterData.height', function(newVal, oldVal) {
        var newValue = $scope.EmployeeMasterData.height;
        var arr = String(newValue).split("");
        var oldValue;
        if (arr.length == undefined)
            return;
        else if (arr.length === 0)
            return;
        else if (arr.length === 1 && (arr[2] == '-' || arr[2] === '.'))
            return;

        else if ((newValue != undefined && newValue != '' && isNaN(newValue))) {
            $scope.EmployeeMasterData.height = oldValue;
            logger.logError("Number Only Allowed");
        }
    });

    // Number Only Validation for Telephone Limit Weight
    $scope.$watch('EmployeeMasterData.weight', function(newVal, oldVal) {
        var newValue = $scope.EmployeeMasterData.weight;
        var arr = String(newValue).split("");
        var oldValue;
        if (arr.length == undefined)
            return;
        else if (arr.length === 0)
            return;
        else if (arr.length === 1 && (arr[2] == '-' || arr[2] === '.'))
            return;

        else if ((newValue != undefined && newValue != '' && isNaN(newValue))) {
            $scope.EmployeeMasterData.weight = oldValue;
            logger.logError("Number Only Allowed");
        }
    });
    app.controller('employeeMasterFamilyAdminAddCtrl', function($scope, isFunction, employeeEdit, employeeId, $state, $http, ngDialog, $controller, logger, $injector, $location, sharedProperties, toaster, $rootScope, $filter, validationService, rowData) {
        $scope.ispopEdit = false;
        $scope.EmployeeMasterDataFam = {
            aadharno1 : '',
            mobileno : '',           
            employeeId : '',
            dependentId : '',
            dependentDob : null,
            age : '',
            sex : '',
            relativeName : '',
            relationToEmployee : '',
            dependentOnEmployee : false,
            dependentPassportNo : '',
            dependentPassportIssuedDate : null,
            dependentPassportExpiryDate : null,
            dependentPassportIssuedPlace : '',
            dependentVisaReferenceNumber : '',
            dependentVisaType : '',
            dependentVisaIssuedPlace : '',
            dependentVisaIssuedDate : null,
            dependentVisaExpirationDate : null,
            dependentPhotoUrl : null,
            dependentMedicalEntitlement : ''
        }
        var tempCopy = angular.copy($scope.EmployeeMasterDataFam);
        
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
        $('#dependentDob').datetimepicker({
            format : 'DD/MM/YYYY'
        })
        var today = dd + '/' + mm + '/' + yyyy;
        $scope.date = today;
        
        
        $scope.$watch('EmployeeMasterDataFam.dependentPassportIssuedDate', function(newValue, oldValue) {
            if (newValue != undefined && newValue != null && newValue != '') {
                if (!$scope.ispopEdit){
                 if($scope.EmployeeMasterDataFam.dependentDob!=undefined && $scope.EmployeeMasterDataFam.dependentDob!='' && $scope.EmployeeMasterDataFam.dependentDob!=null){
                    var todayDate = $scope.date;
                    todayDate = todayDate.split("/");
                    todayDate = new Date(todayDate[2], todayDate[1] - 1, todayDate[0]);
                    var dobDate = $scope.EmployeeMasterDataFam.dependentDob;
                    dobDate = dobDate.split("/");
                    dobDate = new Date(dobDate[2], dobDate[1] - 1, dobDate[0]);
                    var toDate = newValue;
                    toDate = toDate.split("/");
                    toDate = new Date(toDate[2], toDate[1] - 1, toDate[0]);
                    if (toDate < todayDate && toDate > dobDate) {
                    } else {
                        $scope.EmployeeMasterDataFam.dependentPassportIssuedDate = "";
                        $scope.EmployeeMasterDataFam.dependentPassportExpiryDate = "";
                        logger.logError("Passport Issue date Should be lesser than the current date and greater than the dob");
                    }
               }else{
                    logger.logError("Please Enter dob");
                    $scope.EmployeeMasterDataFam.dependentPassportIssuedDate = "";
                    $scope.EmployeeMasterDataFam.dependentPassportExpiryDate = "";
                }
               }
            }
        });
        
        
        $scope.$watch('EmployeeMasterDataFam.dependentDob', function(newValue, oldValue) {
            if (newValue != undefined && newValue != null && newValue != '') {
                if (!$scope.ispopEdit){
                var todayDate = $scope.date;
                var toDate = newValue;
                toDate = toDate.split("/");
                toDate = new Date(toDate[2], toDate[1] - 1, toDate[0]);
                todayDate = todayDate.split("/");
                todayDate = new Date(todayDate[2], todayDate[1] - 1, todayDate[0]);
                if (toDate < todayDate) {
                } else {
                    $scope.EmployeeMasterDataFam.dependentDob = "";
                    $scope.EmployeeMasterDataFam.dependentPassportIssuedDate = '';
                    $scope.EmployeeMasterDataFam.dependentPassportExpiryDate = '';
                    $scope.EmployeeMasterDataFam.dependentVisaExpirationDate = "";
                    $scope.EmployeeMasterDataFam.dependentVisaIssuedDate = "";
                    logger.logError("Date of Birth Should be lesser than the current date");
                }
                }
            }
        });
        
        
        
        $scope.$watch('EmployeeMasterDataFam.dependentPassportExpiryDate', function(newValue, oldValue) {
            if (newValue != undefined && newValue != null && newValue != '') {
                if (!$scope.ispopEdit){
                    var isExp=true;
                    var toDate = newValue;
                    toDate = toDate.split("/");
                    toDate = new Date(toDate[2], toDate[1] - 1, toDate[0]);
                    var currentDate = $scope.date;
                    currentDate = currentDate.split("/");
                    currentDate = new Date(currentDate[2], currentDate[1] - 1, currentDate[0]);
                    if($scope.EmployeeMasterDataFam.dependentPassportIssuedDate!=undefined && $scope.EmployeeMasterDataFam.dependentPassportIssuedDate!=null && $scope.EmployeeMasterDataFam.dependentPassportIssuedDate!=''){
                        if(toDate >  currentDate){
                            var issueDate = $scope.EmployeeMasterDataFam.dependentPassportIssuedDate;
                            issueDate = issueDate.split("/");
                            issueDate = new Date(issueDate[2], issueDate[1] - 1, issueDate[0]);
                       }else{
                           $scope.EmployeeMasterDataFam.dependentPassportExpiryDate = "";
                           logger.logError("Passport Expiry date Should be greater than the Passport Issue date and Current Date");
                      }
                    }else{
                        logger.logError("Please Enter Passport Issue Date");
                        $scope.EmployeeMasterDataFam.dependentPassportExpiryDate = "";
                    }
                }
            }
        });
        
        
        
        
       $scope.$watch('EmployeeMasterDataFam.dependentVisaIssuedDate', function(newValue, oldValue) {
            if (newValue != undefined && newValue != null && newValue != '') {
                 if (!$scope.ispopEdit){
                   if($scope.EmployeeMasterDataFam.dependentDob!=undefined && $scope.EmployeeMasterDataFam.dependentDob!='' && $scope.EmployeeMasterDataFam.dependentDob!=null){
                   var todayDate = $scope.date;
                   var toDate = newValue;
                   toDate = toDate.split("/");
                   toDate = new Date(toDate[2], toDate[1] - 1, toDate[0]);
                   todayDate = todayDate.split("/");
                   var dobDate = $scope.EmployeeMasterDataFam.dependentDob;
                   dobDate = dobDate.split("/");
                   dobDate = new Date(dobDate[2], dobDate[1] - 1, dobDate[0]);
                   todayDate = new Date(todayDate[2], todayDate[1] - 1, todayDate[0]);
                   if (toDate < todayDate && toDate > dobDate) {
                   } else {
                       $scope.EmployeeMasterDataFam.dependentVisaIssuedDate = "";
                       $scope.EmployeeMasterDataFam.dependentVisaExpirationDate = "";
                       logger.logError("Visa Issue date Should be lesser than the current date and greater than the dob");
                   }
                   }else{
                       logger.logError("Please Enter dob");
                       $scope.EmployeeMasterDataFam.dependentVisaIssuedDate = "";
                       $scope.EmployeeMasterDataFam.dependentVisaExpirationDate = "";
                   }
               }
           }
            
        });
        
        
        
        $scope.$watch('EmployeeMasterDataFam.dependentVisaExpirationDate', function(newValue, oldValue) {
            if (newValue != undefined && newValue != null && newValue != '') {
                var isEdit=false;
                if (!$scope.ispopEdit) {
                    var isEXp=true;
                    var currentDate = $scope.date;
                    currentDate = currentDate.split("/");
                    currentDate = new Date(currentDate[2], currentDate[1] - 1, currentDate[0]);
                    var toDate = newValue;
                    toDate = toDate.split("/");
                    toDate = new Date(toDate[2], toDate[1] - 1, toDate[0]);
                    if($scope.EmployeeMasterDataFam.dependentVisaIssuedDate!=undefined && $scope.EmployeeMasterDataFam.dependentVisaIssuedDate!=null && $scope.EmployeeMasterDataFam.dependentVisaIssuedDate!=''){
                              if(toDate >  currentDate){
                                var issuedate = $scope.EmployeeMasterDataFam.dependentVisaIssuedDate;
                                issuedate = issuedate.split("/");
                                issuedate = new Date(issuedate[2], issuedate[1] - 1, issuedate[0]);
                               
                            }else{
                                $scope.EmployeeMasterDataFam.dependentVisaExpirationDate = "";
                                logger.logError("Visa Expiry date Should be greater than the Visa Issue date and current date");
                            }
                        }else{
                            logger.logError("Please Enter Visa Issue Date");
                            $scope.EmployeeMasterDataFam.dependentVisaExpirationDate = "";
                        }
                    }
               
            }
        });
        
        
        $scope.validateFamily = function(EmployeeMasterDataFam, familyForm) {
            
            if (new validationService().checkFormValidity(familyForm)) {               
                var isPassport= true;
                if(EmployeeMasterDataFam.dependentPassportNo!=undefined && EmployeeMasterDataFam.dependentPassportNo!=null && EmployeeMasterDataFam.dependentPassportNo!=''){
                    isPassport=validatePassPortNumber(EmployeeMasterDataFam.dependentPassportNo);
                }
                if(isPassport==true){
                        if (!$scope.ispopEdit) {
                            $scope.saveEmployeeFamily(EmployeeMasterDataFam, familyForm);
                        } else {
                            $scope.updateEmployeeFamily(EmployeeMasterDataFam, familyForm);
                        }
                    
                    }else{
                        logger.logError("Please Enter Valid Passport Number"); 
                    }
                    
                
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(familyForm.$validationSummary), 5000, 'trustedHtml');
            }
        };

        $scope.calculateAge = function() {
            if ($scope.EmployeeMasterDataFam.dependentDob != null && $scope.EmployeeMasterDataFam.dependentDob != '') {
                var dob = $scope.EmployeeMasterDataFam.dependentDob;
                var now = new Date();
                var birthdate = dob.split("/");
                var born = new Date(birthdate[2], birthdate[1] - 1, birthdate[0]);
                var age;
                var birthday = new Date(now.getFullYear(), born.getMonth(), born.getDate());
                if (now >= birthday)
                    age = now.getFullYear() - born.getFullYear();
                else
                    age = now.getFullYear() - born.getFullYear() - 1;

                console.log(birthdate[2] + " : " + birthdate[1] + " : " + birthdate[0]);
                console.log("AGE:");
                console.log(age);
                $scope.EmployeeMasterDataFam.age = age;
            } else {
                $scope.EmployeeMasterDataFam.age = null;
            }
        }

        $scope.saveEmployeeFamily = function(EmployeeMasterDataFam, familyForm) {
            console.log("Coming Inside Save Employee Family");
            console.log("EmployeeID:");
            console.log(employeeId);
            $scope.EmployeeMasterDataFam.employeeId = employeeId;
            $scope.calculateAge();
            console.log("Employee Family List Details");
            console.log($scope.EmployeeMasterDataFam);
            var resultbean = {
                aadharno : $scope.EmployeeMasterDataFam.aadharno1,
                mobileno : $scope.EmployeeMasterDataFam.mobileno,    
                employeeId : $scope.EmployeeMasterDataFam.employeeId,
                dependentDob : $scope.EmployeeMasterDataFam.dependentDob,
                age : $scope.EmployeeMasterDataFam.age,
                sex : $scope.EmployeeMasterDataFam.sex,
                relativeName : $scope.EmployeeMasterDataFam.relativeName,
                relationToEmployee : $scope.EmployeeMasterDataFam.relationToEmployee,
                dependentOnEmployee : $scope.EmployeeMasterDataFam.dependentOnEmployee,
                dependentPassportNo : $scope.EmployeeMasterDataFam.dependentPassportNo,
                dependentPassportIssuedDate : $scope.EmployeeMasterDataFam.dependentPassportIssuedDate,
                dependentPassportExpiryDate : $scope.EmployeeMasterDataFam.dependentPassportExpiryDate,
                dependentPassportIssuedPlace : $scope.EmployeeMasterDataFam.dependentPassportIssuedPlace,
                dependentVisaReferenceNumber : $scope.EmployeeMasterDataFam.dependentVisaReferenceNumber,
                dependentVisaType : $scope.EmployeeMasterDataFam.dependentVisaType,
                dependentVisaIssuedPlace : $scope.EmployeeMasterDataFam.dependentVisaIssuedPlace,
                dependentVisaIssuedDate : $scope.EmployeeMasterDataFam.dependentVisaIssuedDate,
                dependentVisaExpirationDate : $scope.EmployeeMasterDataFam.dependentVisaExpirationDate,
                dependentPhotoUrl : $scope.EmployeeMasterDataFam.dependentPhotoUrl,
                dependentMedicalEntitlement : $scope.EmployeeMasterDataFam.dependentMedicalEntitlement
            };

            $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/saveFamily', resultbean).success(function(datas) {
                console.log("successul save data");
                console.log(datas);
                logger.logSuccess("Saved Successfully");
                ngDialog.close();
                /*
                 * if(datas.success){ logger.logSuccess("Saved Successfully");
                 * ngDialog.close(); }
                 */
            });
           
        }
        if (isFunction == false) {
            $scope.copyPasIssueDate=null;
            $scope.copyPasExpDate=null;
            $scope.copyVisaIssueDate=null;
            $scope.copyVisaExpDate=null;
            $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/editEmployeeFamily', rowData).success(function(datas) {
                $scope.ispopEdit = true;
                debugger 
              
                $scope.EmployeeMasterDataFam.isEdit = true;
                console.log("edit Family data");
                console.log(datas.objEmployeeFamilyBean);
                $scope.EmployeeMasterDataFam = datas.objEmployeeFamilyBean;
                $scope.EmployeeMasterDataFam.aadharno1 = datas.objEmployeeFamilyBean.aadharno;
                $scope.EmployeeMasterDataFam.uploadDependentPhoto=datas.objEmployeeFamilyBean.dependentPhotoUrl;
                
              /*  var imgSplit = imgEdit.indexOf("imgFiles");
                var imgPath = imgEdit.substr(imgSplit);
                var i = '<img src="' + imgPath + '" class="thumb-image" style="max-height: 100px;width: 150px;">'
                $('#image-holder').append(i);
                $('#image-holder').show();*/
                
                
                
               
               
//                jQuery('.thumb-image').remove();
//                jQuery('#dependent-image-holder').append('<img src="" class="thumb-image" style="width: 200px;">');
//             alert("Hello Test");
//                jQuery('.thumb-image').attr('src', imgPath);
                
                
                $scope.copyPasIssueDate=datas.objEmployeeFamilyBean.dependentPassportIssuedDate;
                $scope.copyPasExpDate=datas.objEmployeeFamilyBean.dependentPassportExpiryDate;
                $scope.copyVisaIssueDate=datas.objEmployeeFamilyBean.dependentVisaIssuedDate;
                $scope.copyVisaExpDate=datas.objEmployeeFamilyBean.dependentVisaExpirationDate;
                $scope.copydob=datas.objEmployeeFamilyBean.dependentDob;
                if ($scope.EmployeeMasterDataFam.sex == 't') {
                    $scope.EmployeeMasterDataFam.sex = 'Male';
                } else {
                    $scope.EmployeeMasterDataFam.sex = 'Female';
                }
                if ($scope.EmployeeMasterDataFam.dependentOnEmployee == true) {
                    $scope.EmployeeMasterDataFam.dependentOnEmployee = true;
                } else {
                    $scope.EmployeeMasterDataFam.dependentOnEmployee = false;
                }
                console.log("Final");
                console.log($scope.EmployeeMasterDataFam);
                var imgSplit = datas.objEmployeeFamilyBean.dependentPhotoUrl.indexOf("imgFiles");
                
                var imgPath = datas.objEmployeeFamilyBean.dependentPhotoUrl.substr(imgSplit);
               
            });
        } else {
            $scope.EmployeeMasterDataFam = angular.copy(tempCopy);
        }
        $scope.updateEmployeeFamily = function(EmployeeMasterDataFam, familyForm) {
            var todayDate = $scope.date;
            todayDate = todayDate.split("/");
            todayDate = new Date(todayDate[2], todayDate[1] - 1, todayDate[0]);
            var flag1=true,flag2=true,flag3=true,flag4=true,flag5=true;
            if($scope.EmployeeMasterDataFam.dependentDob!=undefined && $scope.EmployeeMasterDataFam.dependentDob!=null && $scope.EmployeeMasterDataFam.dependentDob!=''){
               if($scope.copydob !=$scope.EmployeeMasterDataFam.dependentDob){
                    var fromDate = $scope.EmployeeMasterDataFam.dependentDob;
                    fromDate = fromDate.split("/");
                    fromDate = new Date(fromDate[2], fromDate[1] - 1, fromDate[0]);
                    if (fromDate < todayDate) {
                    } else {
                        flag5=false;
                    }
                }
             }
             if($scope.EmployeeMasterDataFam.dependentPassportIssuedDate!=undefined && $scope.EmployeeMasterDataFam.dependentPassportIssuedDate!=null && $scope.EmployeeMasterDataFam.dependentPassportIssuedDate!=''){
                     if($scope.copyPasIssueDate !=$scope.EmployeeMasterDataFam.dependentPassportIssuedDate){
                        var fromDate = $scope.EmployeeMasterDataFam.dependentPassportIssuedDate;
                        fromDate = fromDate.split("/");
                        fromDate = new Date(fromDate[2], fromDate[1] - 1, fromDate[0]);
                        var dobDate = $scope.EmployeeMasterDataFam.dependentDob;
                        dobDate = dobDate.split("/");
                        dobDate = new Date(dobDate[2], dobDate[1] - 1, dobDate[0]);
                        if (fromDate < todayDate && fromDate > dobDate) {
                        } else {
                            flag1=false;
                        }
                    }
             }
          
             if($scope.EmployeeMasterDataFam.dependentPassportExpiryDate!=undefined && $scope.EmployeeMasterDataFam.dependentPassportExpiryDate!=null && $scope.EmployeeMasterDataFam.dependentPassportExpiryDate!=''){
                    var isExp =true;
                    var fromDate = $scope.EmployeeMasterDataFam.dependentPassportExpiryDate;
                    fromDate = fromDate.split("/");
                    fromDate = new Date(fromDate[2], fromDate[1] - 1, fromDate[0]);
                    if($scope.copyPasExpDate !=$scope.EmployeeMasterDataFam.dependentPassportExpiryDate){
                       if (fromDate > todayDate ) {
                            if($scope.EmployeeMasterDataFam.dependentPassportIssuedDate!=undefined && $scope.EmployeeMasterDataFam.dependentPassportIssuedDate!=null && $scope.EmployeeMasterDataFam.dependentPassportIssuedDate!=''){
                                var IssueDate = $scope.EmployeeMasterDataFam.dependentPassportIssuedDate;
                                IssueDate = IssueDate.split("/");
                                IssueDate = new Date(IssueDate[2], IssueDate[1] - 1, IssueDate[0]);
                                if (fromDate > IssueDate) {
                                } else {
                                    isExp=false;
                                }
                            }else{
                                isExp=false;
                            }
                        } else {
                            isExp=false
                        }if(isExp==false){
                            flag2=false;
                        }
                       
                    }
              
             }
            
                if($scope.EmployeeMasterDataFam.dependentVisaIssuedDate!=undefined && $scope.EmployeeMasterDataFam.dependentVisaIssuedDate!=null && $scope.EmployeeMasterDataFam.dependentVisaIssuedDate!=''){
                     if($scope.copyVisaIssueDate !=$scope.EmployeeMasterDataFam.dependentVisaIssuedDate){
                         var fromDate = $scope.EmployeeMasterDataFam.dependentVisaIssuedDate;
                         fromDate = fromDate.split("/");
                         fromDate = new Date(fromDate[2], fromDate[1] - 1, fromDate[0]);
                         var dobDate = $scope.EmployeeMasterDataFam.dependentDob;
                         dobDate = dobDate.split("/");
                         dobDate = new Date(dobDate[2], dobDate[1] - 1, dobDate[0]);
                         if (fromDate < todayDate && fromDate > dobDate) {
                         } else {
                             flag3=false;
                         }
                     }
                  } 
            
            
               if($scope.EmployeeMasterDataFam.dependentVisaExpirationDate!=undefined && $scope.EmployeeMasterDataFam.dependentVisaExpirationDate!=null && $scope.EmployeeMasterDataFam.dependentVisaExpirationDate!=''){
                     var isExp1 =true;
                     var fromDate = $scope.EmployeeMasterDataFam.dependentVisaExpirationDate;
                     fromDate = fromDate.split("/");
                     fromDate = new Date(fromDate[2], fromDate[1] - 1, fromDate[0]);
                     if($scope.copyVisaExpDate !=$scope.EmployeeMasterDataFam.dependentVisaExpirationDate){
                         if (fromDate > todayDate ) {
                             if($scope.EmployeeMasterDataFam.dependentVisaIssuedDate!=undefined && $scope.EmployeeMasterDataFam.dependentVisaIssuedDate!=null && $scope.EmployeeMasterDataFam.dependentVisaIssuedDate!=''){
                                 var IssueDate = $scope.EmployeeMasterDataFam.dependentVisaIssuedDate;
                                 IssueDate = IssueDate.split("/");
                                 IssueDate = new Date(IssueDate[2], IssueDate[1] - 1, IssueDate[0]);
                                 if (fromDate > IssueDate) {
                                 } else {
                                     isExp1=false;
                                 }
                             }
                         } else {
                             isExp1=false
                         }if(isExp1==false){
                             flag4=false;
                         }
                     }
              } 
              
            if(flag1==true && flag2==true && flag3==true && flag4==true && flag5==true){
                $scope.EmployeeMasterDataFam.employeeId = employeeId;
                $scope.calculateAge();
                console.log("Employee Family List Details");
                console.log($scope.EmployeeMasterDataFam);

            var updateBean = {
                aadharno : $scope.EmployeeMasterDataFam.aadharno1,
                mobileno : $scope.EmployeeMasterDataFam.mobileno, 
                dependentId : $scope.EmployeeMasterDataFam.dependentId,
                employeeId : $scope.EmployeeMasterDataFam.employeeId,
                dependentDob : $scope.EmployeeMasterDataFam.dependentDob,
                age : $scope.EmployeeMasterDataFam.age,
                sex : $scope.EmployeeMasterDataFam.sex,
                relativeName : $scope.EmployeeMasterDataFam.relativeName,
                relationToEmployee : $scope.EmployeeMasterDataFam.relationToEmployee,
                dependentOnEmployee : $scope.EmployeeMasterDataFam.dependentOnEmployee,
                dependentPassportNo : $scope.EmployeeMasterDataFam.dependentPassportNo,
                dependentPassportIssuedDate : $scope.EmployeeMasterDataFam.dependentPassportIssuedDate,
                dependentPassportExpiryDate : $scope.EmployeeMasterDataFam.dependentPassportExpiryDate,
                dependentPassportIssuedPlace : $scope.EmployeeMasterDataFam.dependentPassportIssuedPlace,
                dependentVisaReferenceNumber : $scope.EmployeeMasterDataFam.dependentVisaReferenceNumber,
                dependentVisaType : $scope.EmployeeMasterDataFam.dependentVisaType,
                dependentVisaIssuedPlace : $scope.EmployeeMasterDataFam.dependentVisaIssuedPlace,
                dependentVisaIssuedDate : $scope.EmployeeMasterDataFam.dependentVisaIssuedDate,
                dependentVisaExpirationDate : $scope.EmployeeMasterDataFam.dependentVisaExpirationDate,
                dependentPhotoUrl : $scope.EmployeeMasterDataFam.dependentPhotoUrl,
                dependentMedicalEntitlement : $scope.EmployeeMasterDataFam.dependentMedicalEntitlement
            };

            if (EmployeeMasterDataFam.genderType == 'Male') {
                $scope.EmployeeMasterDataFam.genderType = true;
            } else {
                $scope.EmployeeMasterDataFam.genderType = false;
            }
            $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/updateEmployeeFamily', EmployeeMasterDataFam).success(function(datas) {
                console.log("update family");
                console.log(datas);
                // if(datas.success){
                logger.logSuccess("Updated Successfully");
                ngDialog.close();
                // }
            });
            }else{
                if(flag1==false){
                    logger.logError("Passport Issue date Should be lesser than the current date and greater than the dob date");
                    $scope.EmployeeMasterDataFam.dependentPassportIssuedDate = '';
                   
                }if(flag2==false){
                    if($scope.EmployeeMasterDataFam.dependentPassportIssuedDate!=undefined && $scope.EmployeeMasterDataFam.dependentPassportIssuedDate!=null && $scope.EmployeeMasterDataFam.dependentPassportIssuedDate!=''){
                        if($scope.EmployeeMasterDataFam.dependentPassportIssuedDate!=undefined && $scope.EmployeeMasterDataFam.dependentPassportIssuedDate!=null && $scope.EmployeeMasterDataFam.dependentPassportIssuedDate!=''){
                            logger.logError("Passport Expiry Date Should be greater than the current date and passport issue date"); 
                        }
                    }else{
                        logger.logError("Please Enter Passport Issue Date");  
                    }
                    $scope.EmployeeMasterDataFam.dependentPassportExpiryDate = '';
                } if(flag4==false){
                    if($scope.EmployeeMasterDataFam.dependentVisaIssuedDate!=undefined && $scope.EmployeeMasterDataFam.dependentVisaIssuedDate!=null && $scope.EmployeeMasterDataFam.dependentVisaIssuedDate!=''){
                       logger.logError("Visa Expiry Date Should be greater than the current date and Visa issue date");
                    }else{
                        logger.logError("Please Enter Passport Issue Date");  
                    } 
                    $scope.EmployeeMasterDataFam.dependentVisaExpirationDate = "";
                    
                }if(flag3==false){
                    $scope.EmployeeMasterDataFam.dependentVisaIssuedDate = "";
                   
                    logger.logError("Visa Issue date Should be lesser than the current date and greater than the dob date");
                   
                }if(flag5==false){
                    $scope.EmployeeMasterDataFam.dependentDob = "";
                   
                    logger.logError("DOB Should be lesser than the current date");
                }
            
            
            }
        }

        $scope.fileName = "/pictures/no-image-icon.jpg";
        $scope.imgFilePath = "";
        $rootScope.uploadDependentProfile = function() {
            var imgfile = $scope.imgfile;
            var fileExtension = imgfile.name;
            var frmData = new FormData();
            var timeval = new Date().getTime();
            frmData.append("file", imgfile);
            frmData.append("fileName", employeeId + "_dependent" + "_" + timeval);
            console.log("Inside uploadDependentProfile");
            console.log("EMP ID:");
            console.log(employeeId);
            $scope.imgfile = frmData;

             $.ajax({
                type : "POST",
                url : $stateParams.tenantid+"/hrms/master/employeeAdminMaster/uploadEmpDependnentPhoto",
                data : frmData,
                contentType : false,
                processData : false,
                progress : function(e) {
                },
                success : function(result) {
                    console.log("Result");
                    console.log(result);
                    $scope.dependentFileName = result.dependentFileName;
                    $scope.imgFilePath = result.imgPath + "?";
                    $scope.EmployeeMasterDataFam.dependentPhotoUrl = '';
                    console.log("Dependent Phot URL:");
                    console.log($scope.EmployeeMasterDataFam.dependentPhotoUrl);
                    if (result.success) {
                        $scope.EmployeeMasterDataFam.dependentPhotoUrl=$scope.imgFilePath;
                        /*$('.thumb-image').remove();
                        $('#dependent-image-holder').append('<img src="" class="thumb-image" style="width: 200px;">');
                     
                        $('.thumb-image').attr('src', $scope.imgFilePath + result.dependentFileName);*/
                        logger.logSuccess("File Uploaded Successfully");
                    } else {
                        logger.logError("Failed to Upload");
                    }
                }
            });
        };

        $scope.cancelEmployeeFamily = function() {
            ngDialog.close();
        }
    });
    app.controller('employeeExperianceAdminAddCtrl', function($scope, isFunction, employeeEdit, employeeId, $state, $http, ngDialog, $controller, logger, $injector, $location, sharedProperties, toaster, $rootScope, $filter, validationService, rowData) {
        var empExId = '';
        $scope.EmployeeMasterDataEx = {
            contactname :'',
            contactno :'',
            empId : '',
            empExpId : '',
            organization : '',
            experienceYear : '',
            expDesisnation : '',
            expRemarks : '',
            exFrom : '',
            exTo : ''
        }
       var tempCopy = $scope.EmployeeMasterDataEx;
        $scope.ispop2Edit = false;
        /*$scope.$watch('EmployeeMasterDataEx.exFrom', function(newValue, oldValue) {
            if (newValue != undefined && newValue != null && newValue != '') {
                   var todayDate = $scope.date;
                   var toDate = newValue;
                   toDate = toDate.split("/");
                   toDate = new Date(toDate[2], toDate[1] - 1, toDate[0]);
                   todayDate = todayDate.split("/");
                   todayDate = new Date(todayDate[2], todayDate[1] - 1, todayDate[0]);
                   var dobDate = $scope.EmployeeMasterData.dob;
                   dobDate = dobDate.split("/");
                   dobDate = new Date(dobDate[2], dobDate[1] - 1, dobDate[0]);
                   if (toDate < todayDate && toDate > dobDate) {
                   } else {
                       $scope.EmployeeMasterDataEx.exFrom = "";
                       logger.logError("From Date Should be lesser than the current date and greater than the dob");
                   }
               
           }
            
        });
        
        $scope.$watch('EmployeeMasterDataEx.exTo', function(newValue, oldValue) {
            if (newValue != undefined && newValue != null && newValue != '') {
                    var currentDate = $scope.date;
                    currentDate = currentDate.split("/");
                    currentDate = new Date(currentDate[2], currentDate[1] - 1, currentDate[0]);
                    var toDate = newValue;
                    toDate = toDate.split("/");
                    toDate = new Date(toDate[2], toDate[1] - 1, toDate[0]);
                    if($scope.EmployeeMasterDataEx.exFrom!=undefined && $scope.EmployeeMasterDataEx.exFrom!=null && $scope.EmployeeMasterDataEx.exFrom!=''){
                        var fromDate = $scope.EmployeeMasterDataEx.exFrom;
                        fromDate = fromDate.split("/");
                        fromDate = new Date(fromDate[2], fromDate[1] - 1, fromDate[0]);
                        if(toDate <  currentDate && toDate > fromDate){
                        }else{
                            $scope.EmployeeMasterDataEx.exTo = "";
                            logger.logError("To date Should be greater than the From date and lesser than the current date");
                        }
                       }else{
                            logger.logError("Please Enter From Date"); 
                            $scope.EmployeeMasterDataEx.exTo = "";
                      }
              
            }
        });*/
        
        
        $scope.validateExperience = function(EmployeeMasterDataEx, experianceForm) {
           // if (new validationService().checkFormValidity(experianceForm)) {
//                var toDate = EmployeeMasterDataEx.exTo;
//                var fromDate = EmployeeMasterDataEx.exFrom;
//                fromDate = fromDate.split("/");
//                fromDate = new Date(fromDate[2], fromDate[1] - 1, fromDate[0]);
//                toDate = toDate.split("/");
//                toDate = new Date(toDate[2], toDate[1] - 1, toDate[0]);
//                var ynew = toDate.getFullYear();
//                var mnew = toDate.getMonth()+1;
//                var dnew = toDate.getDate();
//                var yold = fromDate.getFullYear();
//                var mold = fromDate.getMonth()+1;
//                var dold = fromDate.getDate();
//                var diff = ynew - yold;
//                var diffMon=mnew-mold;
//                diff=Number(diff+"."+diffMon);
               // if(diff >=0.1){
                  // EmployeeMasterDataEx.experienceYear=diff;
                   if (!$scope.ispop2Edit) {
                         $scope.saveEmployeeExperiance(EmployeeMasterDataEx, experianceForm);
                     } else {
                        $scope.updateEmployeeExperiance(EmployeeMasterDataEx, experianceForm);
                     }
                //}else{
                //    logger.logError("Please Enter Valid From Date and To Date");
                //}
               
//            } else {
//                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(experianceForm.$validationSummary), 5000, 'trustedHtml');
//            }
        };
        $scope.saveEmployeeExperiance = function(EmployeeMasterDataEx, experianceForm) {
            empExId = EmployeeMasterDataEx.empId
            if (employeeId == "") {
                EmployeeMasterDataEx.empId = employeeEdit;
                employeeId = employeeEdit;
            } else {
                EmployeeMasterDataEx.empId = employeeId;
            }
            $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/saveExperianceDetail', EmployeeMasterDataEx).success(function(datas) {
                if (datas.success) {
                    logger.logSuccess("Saved Successfully");
                    ngDialog.close();
                }
            });
        }
        if (isFunction == false) {
            $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/editEmployeeExperiance', rowData).success(function(datas) {
                $scope.ispop2Edit = true;
                if(datas.objEmployeeExperianceBean.exFrom == '01/01/0001'){
                    datas.objEmployeeExperianceBean.exFrom = '';
                }
                
                if(datas.objEmployeeExperianceBean.exTo == '01/01/0001'){
                    datas.objEmployeeExperianceBean.exTo = '';
                }
                $scope.EmployeeMasterDataEx = datas.objEmployeeExperianceBean;
                
            });
        } else {
            $scope.EmployeeMasterDataEx = angular.copy(tempCopy);
        }
        $scope.updateEmployeeExperiance = function(EmployeeMasterDataEx, experianceForm) {
//            var todayDate = $scope.date;
//            todayDate = todayDate.split("/");
//            todayDate = new Date(todayDate[2], todayDate[1] - 1, todayDate[0]);
//            var flag1=true,flag2=true;
//            if($scope.EmployeeMasterDataEx.exFrom!=undefined && $scope.EmployeeMasterDataEx.exFrom!=null && $scope.EmployeeMasterDataEx.exFrom!=''){
//                if($scope.copyFromDate !=$scope.EmployeeMasterDataEx.exFrom){
//                   var fromDate = $scope.EmployeeMasterDataEx.exFrom;
//                   fromDate = fromDate.split("/");
//                   fromDate = new Date(fromDate[2], fromDate[1] - 1, fromDate[0]);
//                   if (fromDate < todayDate) {
//                   } else {
//                       flag1=false;
//                   }
//               }
//            }if($scope.EmployeeMasterDataEx.exTo!=undefined && $scope.EmployeeMasterDataEx.exTo!=null && $scope.EmployeeMasterDataEx.exTo!=''){
//               var isExp =true;
//               var fromDate = $scope.EmployeeMasterDataEx.exTo;
//               fromDate = fromDate.split("/");
//               fromDate = new Date(fromDate[2], fromDate[1] - 1, fromDate[0]);
//               if($scope.copyToDate !=$scope.EmployeeMasterDataEx.exTo){
//                   if (fromDate < todayDate ) {
//                       if($scope.EmployeeMasterDataEx.exFrom!=undefined && $scope.EmployeeMasterDataEx.exFrom!=null && $scope.EmployeeMasterDataEx.exFrom!=''){
//                           var FrmDate = $scope.EmployeeMasterDataEx.exFrom;
//                           FrmDate = FrmDate.split("/");
//                           FrmDate = new Date(FrmDate[2], FrmDate[1] - 1, FrmDate[0]);
//                           if (fromDate > FrmDate) {
//                           } else {
//                               isExp=false;
//                           }
//                       }
//                   } else {
//                       isExp=false
//                   }if(isExp==false){
//                       flag2=false;
//                   }
//               }
//            }
            
            
            
                $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/UpdateExperianceDetail', EmployeeMasterDataEx).success(function(datas) {
                    if (datas.success) {
                        logger.logSuccess("Updated Successfully");
                        ngDialog.close();
                    }
                });
//            else{
//                if(flag1==false){
//                    $scope.EmployeeMasterDataEx.exFrom = "";
//                    logger.logError("From Date Should be lesser than the current date");
//                }if(flag2==false){
//                    $scope.EmployeeMasterDataEx.exTo = "";
//                    logger.logError("To date Should be greater than the From date and lesser than the current date");
//                }
//            }
          
        }
        $scope.cancelEmployeeExperiance = function() {
            ngDialog.close();
        }
    });

    app.controller('employeeMobileNoAdminAddCtrl', function($scope, $state, $http, ngDialog, $controller, logger, $injector, $location, sharedProperties, toaster, $rootScope, $filter, validationService, rowDatas) {
        $scope.tempMobileNoList = [];
        if (rowDatas.presentMobile.length > 0) {
            angular.forEach(rowDatas.presentMobile, function(row, index) {
                row.slNo = index + 1;
                $scope.tempMobileNoList.push(row);
            });
        } else {
            $scope.tempObject = {
                slNo : 1,
                presentMobileNo : '',
                select : false
            }
            $scope.tempMobileNoList.push($scope.tempObject);
        }
        $scope.addMobileNoDtl = function() {
            $scope.tablePh = {
                slNo : 1,
                presentMobileNo : '',
                select : false
            };

            $scope.tablePh.slNo = $scope.tempMobileNoList.length + 1;
            $scope.tempMobileNoList.push($scope.tablePh);
        }

        $scope.deleteMobileNoRow = function() {
            $scope.TemprowData = [];
            angular.forEach($scope.tempMobileNoList, function(row, index) {
                var check = row.select;
                if (check == undefined || check == "") {
                    $scope.TemprowData.push(row);
                } else {
                }
            });
            $scope.tempMobileNoList = [];
            angular.forEach($scope.TemprowData, function(row, index) {
                row.slNo = index + 1;
                $scope.tempMobileNoList.push(row);
            });
        }
        $scope.save2 = function() {
            rowDatas.presentMobile = $scope.tempMobileNoList;
            ngDialog.close();
        }
        $scope.cancel = function() {
            ngDialog.close();
        }
    });

});
app.controller('employeeEmergencyAdminAddCtrl', function($scope,$stateParams, isFunction, employeeEdit, employeeId, $state, $http, ngDialog, $controller, logger, $injector, $location, sharedProperties, toaster, $rootScope, $filter, validationService, rowData) {
    $scope.EmployeeMasterDataEme = {
        empId : '',
        emplEmerId : '',
        emergencyName : '',
        emergRelationship : '',
        emergEmail : '',
        phoneNoMultiple : [],
        mobileNoMultiple : [],
        emergPlace : '',
        emergencyOccu : '',
        emerAddress : '',
        emergencyPincode : '',
    }
    var tempCopy = angular.copy($scope.EmployeeMasterDataEme);
    $scope.loadEmpEmePhone = function() {
        var empEmetable = {};
        empEmetable = {
            emergPhone : '',
            select : false
        };
        $scope.EmployeeMasterDataEme.phoneNoMultiple.push(empEmetable);
    }
    $scope.loadEmpEmePhone();
    // add Row
    $scope.addEmpEmePhoneRow = function(tables) {
        var len = tables.length;
        var table = {
            emergPhone : '',
            select : false
        };
        tables.push(table);
    };

    // remove Row
    $scope.removeEmpEmePhoneRow = function(table) {
        $scope.EmployeeMasterDataEme.phoneNoMultiple = [];
        angular.forEach(table, function(row, index) {
            var check = row.select;// $('#section' + index +
            // ':checked').val();
            if (check == undefined || check == "") {
                $scope.EmployeeMasterDataEme.phoneNoMultiple.push(row);
            } else {

            }
        });
    };

    $scope.loadEmpEmeMobile = function() {
        var empEmetable = {};
        empEmetable = {
            emergMobile : '',
            select : false
        };
        $scope.EmployeeMasterDataEme.mobileNoMultiple.push(empEmetable);
    }
    $scope.loadEmpEmeMobile();
    // add Row
    $scope.addEmpEmeMobileRow = function(tables) {
        var len = tables.length;
        var table = {
            emergMobile : '',
            select : false
        };
        tables.push(table);
    };
    // remove Row
    $scope.removeEmpEmeMobileRow = function(table) {
        $scope.EmployeeMasterDataEme.mobileNoMultiple = [];
        angular.forEach(table, function(row, index) {
            var check = row.select;// $('#section' + index +
            // ':checked').val();
            if (check == undefined || check == "") {
                $scope.EmployeeMasterDataEme.mobileNoMultiple.push(row);
            } else {

            }
        });
    };

    $scope.validateEmail = function(email) {
        var reg = /^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/
        if (reg.test(email)) {
            return true;
        } else {

            return false;
        }
    }

    $scope.validateEmergency = function(frmEmergency, EmployeeMasterDataEme) {
        var flag1=true,flag2=true,flag3=true,flag4=true;
            if (new validationService().checkFormValidity(frmEmergency)) {
                if(EmployeeMasterDataEme.emergEmail!=undefined && EmployeeMasterDataEme.emergEmail!='' && EmployeeMasterDataEme.emergEmail!=''){
                        flag4=validateEmailAddress(EmployeeMasterDataEme.emergEmail);
                }
                if (EmployeeMasterDataEme.emergencyPincode != undefined && EmployeeMasterDataEme.emergencyPincode != null && EmployeeMasterDataEme.emergencyPincode != '') {
                        flag1 = validatePinCode(EmployeeMasterDataEme.emergencyPincode);
                 }
                if (EmployeeMasterDataEme.emergPhone != undefined && EmployeeMasterDataEme.emergPhone != null && EmployeeMasterDataEme.emergPhone != '') {
                        flag2 = validatePhoneNumber(EmployeeMasterDataEme.emergPhone);
                }
                if (EmployeeMasterDataEme.emergMobile != undefined && EmployeeMasterDataEme.emergMobile != null && EmployeeMasterDataEme.emergMobile != '') {
                        flag3 = validateMobileNumber(EmployeeMasterDataEme.emergMobile);
                }
                if(flag1==true && flag2==true && flag3==true && flag4==true){
                    if (!$scope.ispop5Edit) {
                        $scope.saveEmployeeEme(frmEmergency, EmployeeMasterDataEme);
                    } else {
                        $scope.updateEmployeeEme(frmEmergency, EmployeeMasterDataEme);
                    }
                }else{
                    if (flag4 == false) {
                        logger.logError("Please Enter Valid Email Address");
                    }
                    if (flag3 == false) {
                        logger.logError("Please Enter Valid Mobile Number");
                    }
                    if (flag1 == false) {
                        logger.logError("Please Enter Valid Pin Code");
                    }if (flag2 == false) {
                        logger.logError("Please Enter Valid  Phone Number");
                    }
                }
            
            
          
        } else {
            toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(frmEmergency.$validationSummary), 5000, 'trustedHtml');
        }
    };

    $scope.saveEmployeeEme = function(frmEmergency, EmployeeMasterDataEme) {
        var flag = true
        if (employeeId == "") {
            EmployeeMasterDataEme.empId = employeeEdit;
        } else {
            EmployeeMasterDataEme.empId = employeeId;
        }
       
            $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/saveEmergency', EmployeeMasterDataEme).success(function(datas) {
                if (datas.success) {
                    logger.logSuccess("Saved Successfully");
                    ngDialog.close();
                }
            });
      

    }
    if (isFunction == false) {
        $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/editEmployeeEmergency', rowData).success(function(datas) {
            $scope.ispop5Edit = true;
            $scope.EmployeeMasterDataEme = datas.objEmployeeEmergencyBean;
            // $scope.EmployeeMasterDataEme.mobileNoMultiple=datas.employeeEmeMobNoList;
            // $scope.EmployeeMasterDataEme.phoneNoMultiple=datas.employeeEmePhNoList;
        });
    } else {
        $scope.EmployeeMasterDataEme = angular.copy(tempCopy);
    }
    $scope.updateEmployeeEme = function(frmEmergency, EmployeeMasterDataEme) {
        $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/updateEmployeeEmergency', EmployeeMasterDataEme).success(function(datas) {
                $scope.ispop5Edit = true;
                if (datas.success) {
                    logger.logSuccess("Updated Successfully");
                    ngDialog.close();
                }
                ;
            });
        
    }
    $scope.cancelEmployeeEme = function() {
        ngDialog.close();
    }
});
app.controller('employeeNominationAdminAddCtrl', function($scope,$stateParams, isFunction, employeeEdit, employeeId, $state, $http, ngDialog, $controller, logger, $injector, $location, sharedProperties, toaster, $rootScope, $filter, validationService, rowData) {
    $scope.EmployeeMasterDataNomination = {
        aadharno2 :'',
        empId : '',
        employeeNomId : '',
        nominateName : '',
        nominateGender : '',
        nominateOccupation : '',
        nominateRelationship : '',
        nominateEmail : '',
        uploadPhotoNominee : '',
        nominatePhoneMultiple : [],
        nominateMobileMultiple : [],
        nomdateOfBirth : '',
        nomineAddress : '',
        nominatePlace : '',
        nominatePincode : ''
    }
    var tempCopy = angular.copy($scope.EmployeeMasterDataNomination);
    $rootScope.uploadPhoto = function(element) {
        $scope.nomineePhoto = element.files[0];
    }

    $scope.$watch('EmployeeMasterDataNomination.nomdateOfBirth', function(newValue, oldValue) {
        if (newValue != undefined && newValue != null && newValue != '') {
            var todayDate = $scope.currentDate;
            var toDate = newValue;
            toDate = toDate.split("/");
            toDate = new Date(toDate[2], toDate[1] - 1, toDate[0]);
            todayDate = todayDate.split("/");
            todayDate = new Date(todayDate[2], todayDate[1] - 1, todayDate[0]);
            if (toDate < todayDate) {
            } else {
                $scope.EmployeeMasterDataNomination.nomdateOfBirth = "";
                logger.logError("DOB Should be lesser than the current date");
            }
        }
        
    });
    
    $rootScope.uploadNomineePhoto = function() {
        var imgfile = $scope.nomineePhoto;
        var fileExtension = imgfile.name;
        var frmData = new FormData();
        frmData.append("file", imgfile);
        frmData.append("fileName", $scope.EmployeeMasterData.empId + "_nominee");
        // $scope.nomineePhoto=frmData;
        $.ajax({
            type : "POST",
            url : $stateParams.tenantid+"/hrms/master/employeeAdminMaster/uploadfile",
            data : frmData,
            contentType : false,
            processData : false,
            success : function(result) {
                // $scope.fileName=result.fileName;
                // $scope.imgFilePath=result.imgPath;
                $scope.EmployeeMasterDataNomination.uploadPhotoNominee = result.imgPath;
                if (result.success) {
                    logger.logSuccess("File Uploaded Successfully");
                } else {
                    logger.logError("Fail to Upload");
                }
            }
        });
    };
    $scope.loadEmpNomPhone = function() {
        var empNomtable = {};
        empNomtable = {
            emergPhone : '',
            select : false
        };
        $scope.EmployeeMasterDataNomination.nominatePhoneMultiple.push(empNomtable);
    }
    $scope.loadEmpNomPhone();
    // add Row
    $scope.addEmpNomPhoneRow = function(tables) {
        var len = tables.length;
        var table = {
            emergPhone : '',
            select : false
        };
        tables.push(table);
    };

    // remove Row
    $scope.removeEmpNomPhoneRow = function(table) {
        $scope.EmployeeMasterDataNomination.nominatePhoneMultiple = [];
        angular.forEach(table, function(row, index) {
            var check = row.select;// $('#section' + index +
            // ':checked').val();
            if (check == undefined || check == "") {
                $scope.EmployeeMasterDataNomination.nominatePhoneMultiple.push(row);
            } else {

            }
        });
        // table.empTblRow = $scope.tablerow;
    };

    $scope.loadEmpNomMobile = function() {
        var empNomtable = {};
        empNomtable = {
            emergPhone : '',
            select : false
        };
        $scope.EmployeeMasterDataNomination.nominateMobileMultiple.push(empNomtable);
    }
    $scope.loadEmpNomMobile();
    // add Row
    $scope.addEmpNomMobileRow = function(tables) {
        var len = tables.length;
        var table = {
            emergPhone : '',
            select : false
        };
        tables.push(table);
    };

    // remove Row
    $scope.removeEmpNomMobileRow = function(table) {
        $scope.EmployeeMasterDataNomination.nominateMobileMultiple = [];
        angular.forEach(table, function(row, index) {
            var check = row.select;// $('#section' + index +
            // ':checked').val();
            if (check == undefined || check == "") {
                $scope.EmployeeMasterDataNomination.nominateMobileMultiple.push(row);
            } else {

            }
        });
    };
    $scope.validateNomination = function(nomform, EmployeeMasterDataNomination) {
        var flag1=true,flag2=true,flag3=true,flag4=true;
        if (new validationService().checkFormValidity(nomform)) {
            if(EmployeeMasterDataNomination.nominateEmail!=undefined && EmployeeMasterDataNomination.nominateEmail!='' && EmployeeMasterDataNomination.nominateEmail!=''){
                flag4=validateEmailAddress(EmployeeMasterDataNomination.nominateEmail);
            }
             if (EmployeeMasterDataNomination.nominatePincode != undefined && EmployeeMasterDataNomination.nominatePincode != null && EmployeeMasterDataNomination.nominatePincode != '') {
                    flag1 = validatePinCode(EmployeeMasterDataNomination.nominatePincode);
            }
            if (EmployeeMasterDataNomination.emergPhone != undefined && EmployeeMasterDataNomination.emergPhone != null && EmployeeMasterDataNomination.emergPhone != '') {
                    flag2 = validateMobileNumber(EmployeeMasterDataNomination.emergPhone);
               
            }
            if (EmployeeMasterDataNomination.emergMobile != undefined && EmployeeMasterDataNomination.emergMobile != null && EmployeeMasterDataNomination.emergMobile != '') {
                    flag3 = validateMobileNumber(EmployeeMasterDataNomination.emergMobile);
            }
            if(flag1==true && flag2==true && flag3==true && flag4==true)
            if (!$scope.ispop3Edit) {
                $scope.saveEmployeeNom(nomform, EmployeeMasterDataNomination);
            } else {
                $scope.updateEmployeeNom(nomform, EmployeeMasterDataNomination);
            }else{
                if (flag1 == false) {
                    logger.logError("Please Enter Valid Pin Number");
                }
                if (flag2 == false) {
                    logger.logError("Please Enter Valid Phone Number");
                 }
                if (flag3 == false) {
                    logger.logError("Please Enter Valid Mobile Number");
                }if (flag4 == false) {
                    logger.logError("Please Enter Valid Email Address");
                    
                }
            }
        } else {
            toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(nomform.$validationSummary), 5000, 'trustedHtml');
        }
    };
    $scope.saveEmployeeNom = function(nomform, EmployeeMasterDataNomination) {
        if (employeeId == "") {
            EmployeeMasterDataNomination.empId = employeeEdit;
        } else {
            EmployeeMasterDataNomination.empId = employeeId;
        }
        if (EmployeeMasterDataNomination.nominateGender == 'Male') {
            EmployeeMasterDataNomination.nominateGender = true;
        } else {
            EmployeeMasterDataNomination.nominateGender = false;
        }
        if ($scope.EmployeeMasterDataNomination.nomdateOfBirth == undefined || $scope.EmployeeMasterDataNomination.nomdateOfBirth == '' || $scope.EmployeeMasterDataNomination.nomdateOfBirth == null) {
            $scope.EmployeeMasterDataNomination.nomdateOfBirth = null
        }
        console.log("Nomination");
        console.log(EmployeeMasterDataNomination);
        $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/saveNomination', EmployeeMasterDataNomination).success(function(datas) {
            if (datas.success) {
                logger.logSuccess("Saved Successfully");
                ngDialog.close();
            }
            ;
        });
    }
    if (isFunction == false) {
        $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/editEmployeeNomination', rowData).success(function(datas) {
            $scope.ispop3Edit = true;
            if (datas.objEmployeeNominationBean.nominateGender == false) {
                datas.objEmployeeNominationBean.nominateGender = 'Female';
            } else {
                datas.objEmployeeNominationBean.nominateGender = 'Male';
            }
            $scope.EmployeeMasterDataNomination = datas.objEmployeeNominationBean;
            // $scope.EmployeeMasterDataNomination.nominatePhoneMultiple=datas.employeePhoneNoList;
            // $scope.EmployeeMasterDataNomination.nominateMobileMultiple=datas.employeeMobileNoList;
        });
    } else {
        $scope.EmployeeMasterDataNomination = angular.copy(tempCopy);
    }
    $scope.updateEmployeeNom = function(nomform, EmployeeMasterDataNomination) {
        if (EmployeeMasterDataNomination.nominateGender == 'Female') {
            EmployeeMasterDataNomination.nominateGender = false;
        } else if(EmployeeMasterDataNomination.nominateGender == 'Male'){
            EmployeeMasterDataNomination.nominateGender = true;
        }
        if ($scope.EmployeeMasterDataNomination.nomdateOfBirth == undefined || $scope.EmployeeMasterDataNomination.nomdateOfBirth == '' || $scope.EmployeeMasterDataNomination.nomdateOfBirth == null) {
            $scope.EmployeeMasterDataNomination.nomdateOfBirth = null
        }
        $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/updateEmployeeNomination', EmployeeMasterDataNomination).success(function(datas) {
            $scope.ispop3Edit = true;
            var empId = EmployeeMasterDataNomination.empId;
            if (datas.success) {
                logger.logSuccess("Updated Successfully");
            }
            ;
            ngDialog.close();
        });
    }
    $scope.cancelEmployeeNom = function() {
        ngDialog.close();
    }
});
app.controller('employeeReferenceAdminAddCtrl', function($scope,$stateParams, isFunction, employeeEdit, employeeId, $state, $http, ngDialog, $controller, logger, $injector, $location, sharedProperties, toaster, $rootScope, $filter, validationService, rowData) {
    // $scope.showLabel="Profile";
    // var path = $location.path();
    // var splitPath = path.split("/");
    // var search= splitPath[5];
    // var employeeId=$state.params.empId;
    $scope.EmployeeMasterDataRef = {
        empId : '',
        referenceName : '',
        occupationRef : '',
        relationshipRef : '',
        emailRef : '',
        referenceAddress : '',
        pincodeRef : '',
        phoneRefMultiple : []
    }
    var tempCopy = $scope.EmployeeMasterDataRef;
    $scope.loadEmpRefPhone = function() {
        var empReftable = {};
        empReftable = {
            emergPhone : '',
            select : false
        };
        $scope.EmployeeMasterDataRef.phoneRefMultiple.push(empReftable);
    }
    $scope.loadEmpRefPhone();
    // add Row
    $scope.addEmpRefPhoneRow = function(tables) {
        var len = tables.length;
        var table = {
            emergPhone : '',
            select : false
        };
        tables.push(table);
    };
    // remove Row
    $scope.removeEmpRefPhoneRow = function(table) {
        $scope.EmployeeMasterDataRef.phoneRefMultiple = [];
        angular.forEach(table, function(row, index) {
            var check = row.select;// $('#section' + index +
            // ':checked').val();
            if (!check) {
                $scope.EmployeeMasterDataRef.phoneRefMultiple.push(row);
            } else {

            }
        });
    };

    $scope.validateEmail = function(email) {
        var reg = /^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/
        if (reg.test(email)) {
            return true;
        } else {
            // logger.logError("Please Enter Valida Email Address");
            return false;
        }
    }

    $scope.validateReference = function(refform, EmployeeMasterDataRef) {
        if (new validationService().checkFormValidity(refform)) {
            if (!$scope.ispop6Edit) {
                $scope.saveEmployeeRef(refform, EmployeeMasterDataRef);
            } else {
                $scope.updateEmployeeRef(refform, EmployeeMasterDataRef);
            }
        } else {
            toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(refform.$validationSummary), 5000, 'trustedHtml');
        }
    };
    $scope.saveEmployeeRef = function(refform, EmployeeMasterDataRef) {
        var flag = true;
        var flag2 = true;
        var flag3 = true;
        if (employeeId == "") {
            EmployeeMasterDataRef.empId = employeeEdit;
        } else {
            EmployeeMasterDataRef.empId = employeeId;
        }
        var empId = employeeId;
      /*  if (EmployeeMasterDataRef.emailRef != undefined && EmployeeMasterDataRef.emailRef != null && EmployeeMasterDataRef.emailRef != '') {
            flag = $scope.validateEmail(EmployeeMasterDataRef.emailRef);
        }
        if (EmployeeMasterDataRef.emergPhone != undefined && EmployeeMasterDataRef.emergPhone != null && EmployeeMasterDataRef.emergPhone != '') {
            flag2 = validatePhoneNumber(EmployeeMasterDataRef.emergPhone);
        }
        if (EmployeeMasterDataRef.pincodeRef != undefined && EmployeeMasterDataRef.pincodeRef != null && EmployeeMasterDataRef.pincodeRef != '') {
            flag3 = validatePinCode(EmployeeMasterDataRef.pincodeRef);
           
        }*/
        if (flag == true && flag2 == true && flag3 == true) {
            $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/saveReference', EmployeeMasterDataRef).success(function(datas) {
                console.log(datas);
                if (datas.success) {
                    logger.logSuccess("Save Successfully");
                    ngDialog.close();
                }
                ;
            });
        } else {
            if (flag == false) {
                logger.logError("Please Enter Valid Email Address");
            }
            if (flag2 == false) {
                logger.logError("Please Enter Valid Phone Number");
            }
            if (flag3 == false) {
                logger.logError("Please Enter Valid Pin Code");
            }

        }

    }

    if (isFunction == false) {
        $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/editEmployeeReference', rowData).success(function(datas) {
            $scope.ispop6Edit = true;
            $scope.EmployeeMasterDataRef = datas.objEmployeeReferanceBean;
            $scope.EmployeeMasterDataRef.phoneRefMultiple = datas.employeeReferanceBeanList;
        });
    } else {
        $scope.EmployeeMasterDataRef = angular.copy(tempCopy);
    }
    $scope.updateEmployeeRef = function(refform, EmployeeMasterDataRef) {
        var flag = true;
        var flag2 = true;
        var flag3 = true;
        var empId = EmployeeMasterDataRef.empId;
        if (EmployeeMasterDataRef.emailRef != undefined && EmployeeMasterDataRef.emailRef != null && EmployeeMasterDataRef.emailRef != '') {
            flag = $scope.validateEmail(EmployeeMasterDataRef.emailRef);
        }
        if (EmployeeMasterDataRef.emergPhone != undefined && EmployeeMasterDataRef.emergPhone != null && EmployeeMasterDataRef.emergPhone != '') {
            flag2 = validateMobileNumber(EmployeeMasterDataRef.emergPhone);
           
        }
        if (EmployeeMasterDataRef.pincodeRef != undefined && EmployeeMasterDataRef.pincodeRef != null && EmployeeMasterDataRef.pincodeRef != '') {
                flag3 = validatePinCode(EmployeeMasterDataRef.pincodeRef);
        }
        if (flag == true && flag2 == true && flag3 == true) {

            $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/updateEmployeeReference', EmployeeMasterDataRef).success(function(datas) {
                $scope.ispop6Edit = true;
                if (datas.success) {
                    logger.logSuccess("Updated Successfully");
                    ngDialog.close();
                }
                ;
            });
        } else {
            if (flag == false) {
                logger.logError("Please Enter Valid Email Address");
            }
            if (flag2 == false) {
                logger.logError(" Please Enter Valid Mobile Number");
            }
            if (flag3 == false) {
                logger.logError("Please Enter Valid Pin Code");
            }
        }
    }
    $scope.cancelEmployeeRef = function() {
        ngDialog.close();
    }
});

app.controller('employeeMasterDocumentAdminAddCtrl', function($scope,$stateParams, isFunction, employeeEdit, employeeId, $state, $http, ngDialog, $controller, logger, $injector, $location, sharedProperties, toaster, $rootScope, $filter, validationService, rowData) {
    // rowData.empId=$scope.employeeId
    $scope.EmployeeMasterDataDoc = {
        empId : '',
        docName : '',
        description : '',
        uploadDoc : '',
        empDocId : ''
    }
    var tempCopy = $scope.EmployeeMasterDataDoc;
    $scope.fileName = "/pictures/no-image-icon.jpg";
    $scope.ispop7Edit = false;
    $scope.tempDoc;
    $rootScope.uploadDocument = function(element) {
        $scope.tempDoc = element.files[0];
    }
    $rootScope.uploadDocumentFiles = function() {
        var imgfile = $scope.tempDoc;
        var fileExtension = imgfile.name.split(".");
        var newName = fileExtension[0];
        var frmData = new FormData();
        frmData.append("file", imgfile);
        frmData.append("fileName", $scope.EmployeeMasterData.empId + "_" + newName);
        // $scope.nomineePhoto=frmData;
        $.ajax({
            type : "POST",
            url : $stateParams.tenantid+"/hrms/master/employeeAdminMaster/uploadfile",
            data : frmData,
            contentType : false,
            processData : false,
            success : function(result) {
                $scope.fileName = result.fileName;
                // $scope.imgFilePath=result.imgPath;
                $scope.EmployeeMasterDataDoc.uploadDoc = result.imgPath;
                if (result.success) {
                    logger.logSuccess("File Uploaded Successfully");
                } else {
                    logger.logError("Fail to Upload");
                }
            }
        });
    }
    $scope.validateDocument = function(EmployeeMasterDataDoc, frmDocument) {
        if (new validationService().checkFormValidity(frmDocument)) {
            if (!$scope.ispop7Edit) {
                $scope.saveEmployeeDoc(EmployeeMasterDataDoc, frmDocument);
            } else {
                $scope.updateEmployeeDoc(EmployeeMasterDataDoc, frmDocument);
            }
        } else {
            toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(frmDocument.$validationSummary), 5000, 'trustedHtml');
        }
    };

    $scope.saveEmployeeDoc = function(EmployeeMasterDataDoc, frmDocument) {
        if (employeeId == "") {
            EmployeeMasterDataDoc.empId = employeeEdit;
        } else {
            EmployeeMasterDataDoc.empId = employeeId;
        }
        $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/saveDoc', EmployeeMasterDataDoc).success(function(datas) {
            if (datas.success) {
                logger.logSuccess("Saved Successfully");
                ngDialog.close();
            }
        });
    }
    if (isFunction == false) {
        $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/editEmployeeDoc', rowData).success(function(datas) {
            $scope.ispop7Edit = true;
            $scope.EmployeeMasterDataDoc = datas.objEmployeeDocumentBean;
        });
    } else {
        $scope.EmployeeMasterDataDoc = angular.copy(tempCopy);
    }
    $scope.updateEmployeeDoc = function(EmployeeMasterDataDoc, frmDocument) {
        $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/updateEmployeeDoc', EmployeeMasterDataDoc).success(function(datas) {
            if (datas.success) {
                logger.logSuccess("Updated Successfully");
                ngDialog.close();
            }
        });
    }
    $scope.cancelEmployeeDocument = function() {
        ngDialog.close();
    }
});
app.controller('employeeMasterMeritsAdminAddCtrl', function($scope,$stateParams, isFunction, employeeEdit, employeeId, $state, $http, ngDialog, $controller, logger, $injector, $location, sharedProperties, toaster, $rootScope, $filter, validationService, rowData) {
    $scope.EmployeeMasterDataMerit = {
        empId : '',
        empMeritId : '',
        awardName : '',
        scholarshipName : '',
        meritDesc : ''
    }
    var tempCopy = angular.copy($scope.EmployeeMasterDataMerit);
    $scope.ispop4Edit = false;
    var empMerId = '';
    $scope.validateMerits = function(EmployeeMasterDataMerit, meritsForm) {
        if (new validationService().checkFormValidity(meritsForm)) {
            if (!$scope.ispop4Edit) {
                $scope.saveEmployeeMerit(EmployeeMasterDataMerit, meritsForm);
            } else {
                $scope.updateEmployeeMerit(EmployeeMasterDataMerit, meritsForm);
            }
        } else {
            toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(meritsForm.$validationSummary), 5000, 'trustedHtml');
        }
    };
    $scope.saveEmployeeMerit = function(EmployeeMasterDataMerit, meritsForm) {
        empMerId = EmployeeMasterDataMerit.empId
        if (employeeId == "") {
            EmployeeMasterDataMerit.empId = employeeEdit;
        } else {
            EmployeeMasterDataMerit.empId = employeeId;
        }
        $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/saveMerits', EmployeeMasterDataMerit).success(function(datas) {
            if (datas.success) {
                logger.logSuccess("Saved Successfully");
                ngDialog.close();
            }
        });
    }
    if (isFunction == false) {
        $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/editEmployeeMerits', rowData).success(function(datas) {
            $scope.ispop4Edit = true;
            $scope.EmployeeMasterDataMerit = datas.objEmployeeMeritsBean;
        });
    } else {
        $scope.EmployeeMasterDataMerit = angular.copy(tempCopy);
    }
    $scope.updateEmployeeMerit = function(EmployeeMasterDataMerit, meritsForm) {
        $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/updateEmployeeMerit', EmployeeMasterDataMerit).success(function(datas) {
            if (datas.success) {
                logger.logSuccess("Updated Successfully");
                ngDialog.close();
            }
        });
    }
    $scope.cancelEmployeeMerit = function() {
        ngDialog.close();
    }
});

app.controller('employeeMasterEducationAdminAddCtrl', function($scope, $stateParams,isFunction, employeeEdit, employeeId, $state, $http, ngDialog, $controller, logger, $injector, $location, sharedProperties, toaster, $rootScope, $filter, validationService, rowData) {
    $scope.ispop1Edit = false;
    $scope.EmployeeMasterDataEdu = {
        specialization : '',
        empId : '',
        empEduId : '',
        qualification : '',
        percentage : '',
        courseType : '',
        institution : '',
        yearPassed : ''
    }
    $scope.getYearList = function() {
        $http.get($stateParams.tenantid+'/hrms/master/employeeAdminMaster/getYearList').success(function(datas) {
            console.log("year list");
            console.log(datas);
            if (datas.success == true) {
                $scope.yearList = datas.yearsList;
                console.log($scope.yearList);
            }
        });
    }
    
    $scope.reset = function() {
       if($scope.ispop1Edit==false){
           $scope.EmployeeMasterDataEdu = {
                   specialization : '',
                   empId : '',
                   empEduId : '',
                   qualification : '',
                   percentage : '',
                   courseType : '',
                   institution : '',
                   yearPassed : ''
               }
       }else{
           if($scope.ispop1Edit==true){
               $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/editEmployeeEducation', rowData).success(function(datas) {
                   $scope.ispop1Edit = true;
                   if (datas.success == true) {
                       $scope.EmployeeMasterDataEdu = datas.objEmployeeEducationBean;
                   }
               });
           }
          
       }
    }
    
    $scope.getYearList();
    var tempCopy = angular.copy($scope.EmployeeMasterDataEdu);
    $scope.validateEducation = function(EmployeeMasterDataEdu, eduForm) {
        if (new validationService().checkFormValidity(eduForm)) {
            var dobDate = $scope.EmployeeMasterData.dob;
            dobDate = dobDate.split("/");
            dobDate = new Date(dobDate[2], dobDate[1] - 1, dobDate[0]);
            var dobYear = dobDate.getFullYear();
           // var differenceYears = Number(EmployeeMasterDataEdu.yearPassed) - Number(dobYear) ;
           // if(differenceYears >= 15){
                //if(EmployeeMasterDataEdu.percentage >=50 && EmployeeMasterDataEdu.percentage < 100){
                    if (!$scope.ispop1Edit) {
                        $scope.saveEmployeeEducation(EmployeeMasterDataEdu, eduForm);
                    } else {
                        $scope.updateEmployeeEducation(EmployeeMasterDataEdu, eduForm);
                    }
                //}else{
                //  logger.logError("Please Enter Valid Percentage")  
                //}
               
           // }else{
           //     logger.logError("Please Enter Valid Year of Passing")
           // }
            
        } else {
            toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(eduForm.$validationSummary), 5000, 'trustedHtml');
        }
    };
    $scope.saveEmployeeEducation = function(EmployeeMasterDataEdu, eduForm) {
        if (employeeId == "") {
            EmployeeMasterDataEdu.empId = employeeEdit;
        } else {
            EmployeeMasterDataEdu.empId = employeeId;
        }
        $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/saveEducationDetail', EmployeeMasterDataEdu).success(function(datas) {
            if (datas.success) {
                logger.logSuccess("Saved Successfully");
                ngDialog.close();
                $scope.employeeEducationList(empId);

            }
        });
        ngDialog.close();
    }
    if (isFunction == false) {
        $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/editEmployeeEducation', rowData).success(function(datas) {
            $scope.ispop1Edit = true;
            if (datas.success == true) {
                $scope.EmployeeMasterDataEdu = datas.objEmployeeEducationBean;
            }
        });
    } else {
        $scope.EmployeeMasterDataEdu = angular.copy(tempCopy);
    }
    $scope.updateEmployeeEducation = function(EmployeeMasterDataEdu, eduForm) {
        $http.post($stateParams.tenantid+'/hrms/master/employeeAdminMaster/updateEmployeeEducation', EmployeeMasterDataEdu).success(function(datas) {
            if (datas.success) {
                logger.logSuccess("Updated Successfully");
                ngDialog.close();
                $scope.employeeEducationList(empId);

            }
        });
    }
    $scope.cancelEmployeeEducation = function() {
        ngDialog.close();
    }
});

