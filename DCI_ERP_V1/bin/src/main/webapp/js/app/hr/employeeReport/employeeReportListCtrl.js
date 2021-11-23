/*define([ 'hrms/hr/hr' ], function(module) {

    'use strict';

    module.registerController('employeeReportListCtrl', function($scope, $state, $stateParams, $http, ngDialog, $filter,logger, $injector, $location, sharedProperties, toaster, $rootScope) {
*/

'use strict';

app.controller('employeeReportListCtrl', function(sharedProperties, $templateCache, $injector, $location, $scope, $rootScope, $http, logger, $log, ngDialog, $modal, toaster, validationService,$stateParams,$state) {

        $scope.newsUpdateObj = {
            newsthoughtfor : '',
            newsupdate : '',
            Date : '',

        };

        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.employeeReportHeaderList = [];
       /*
         * if (angular.fromJson($stateParams.rowDataCollection) != undefined) {
         * var response = angular.fromJson($stateParams.rowDataCollection);
         * $scope.rowCollection = response.collection; }
         */
        $scope.itemsByPage = 10;
        $scope.numPages = 0

        $scope.EmployeeMasterData = {
    
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
            branchId :'',
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
            empTypeName : '',
            relieveDate : '',
            epfNo : '',
            isPrimary : '',
            isEdit : false,

            // Profile Info
            marritalStatus : false,
            guardianName : '',
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
            confirmationPeriod : '',
            husbWifeName : '',
            marriageDate : '',
            personalStatus : '',

            // Address
            permAddress : '',
            permPlace : '',
            permDistrict : '',
            permPin : '',
            permPhone : '',
            permMobile : '',
            isActiveAddress : 'N',
            presentAddress : '',
            presentPlace : '',
            presentDistrict : '',
            presentPin : '',
            presentPhone : '',
            presentMobile : '',
            isActiveOldAddress : 'N',

            // Rule
            overTime : false,
            esiApp : false,
            lateApp : false,
            pfApp : false,
            earlyExit : false,
            leaveOption : false,
            telephoneLimit : '',
            medicalLimit : '',

            // Nominee
            nominateName : '',
            nominateGender : '',
            nominateOccupation : '',
            nominateRelationship : '',
            nominateEmail : '',
            nominatePhone : '',
            nominateMobile : '',
            nomdateOfBirth : '',
            nomineAddress : '',
            nominatePlace : '',
            nominatePincode : '',

            // Physical
            isActiveSight : 'N',
            isActiveDumb : 'N',
            isActiveHearing : 'N',
            isActiveHand :'N',
            isActiveFeet : 'N',
            isActiveWithGlass : 'N',
            height : '',
            weight : '',

            // Emergency
            emergencyName : '',
            emergRelationship : '',
            emergEmail : '',
            emergPhone : '',
            emergMobile : '',
            emergPlace : '',
            emergencyOccu : '',
            emerAddress : '',
            emergencyPincode : '',

            // Reference
            referenceName : '',
            occupationRef : '',
            relationshipRef : '',
            emailRef : '',
            referenceAddress : '',
            pincodeRef : '',
            phoneRef : '',

            // Family
            employeetables : [],
            familyName : '',
            genderType : '',
            relationshipWithEmp : '',
            empDependence : false,

            // Education
            employeeEduTables : [],
            qualification : '',
            percentage : '',
            courseType : '',
            institution : '',
            yearPassed : '',

            // Experience
            employeeExpTables : [],
            organization : '',
            experienceYear : '',
            expDesisnation : '',
            expRemarks : '',

            // Merit
            employeeMeritTables : [],
            awardName : '',
            scholarshipName : '',
            meritDesc : '',

            // Document
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
        
        $scope.EmployeeMasterReportData = {
                astatus : '', 
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
                branchId :'',
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
                empTypeName : '',
                relieveDate : '',
                epfNo : '',
                isPrimary : '',
                isEdit : false,

                // Profile Info
                marritalStatus : undefined,
                guardianName : '',
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
                confirmationPeriod : '',
                husbWifeName : '',
                marriageDate : '',
                personalStatus : '',

                // Address
                permAddress : '',
                permPlace : '',
                permDistrict : '',
                permPin : '',
                permPhone : '',
                permMobile : '',
                isActiveAddress : 'N',
                presentAddress : '',
                presentPlace : '',
                presentDistrict : '',
                presentPin : '',
                presentPhone : '',
                presentMobile : '',
                isActiveOldAddress : 'N',

                // Rule
                overTime : false,
                esiApp : undefined,
                lateApp : false,
                pfApp : undefined,
                earlyExit : false,
                leaveOption : false,
                telephoneLimit : '',
                medicalLimit : '',

                // Nominee
                nominateName : '',
                nominateGender : '',
                nominateOccupation : '',
                nominateRelationship : '',
                nominateEmail : '',
                nominatePhone : '',
                nominateMobile : '',
                nomdateOfBirth : '',
                nomineAddress : '',
                nominatePlace : '',
                nominatePincode : '',

                // Physical
                isActiveSight : '',
                isActiveDumb : '',
                isActiveHearing : '',
                isActiveHand :'',
                isActiveFeet : '',
                isActiveWithGlass : '',
                height : '',
                weight : '',

                // Emergency
                emergencyName : '',
                emergRelationship : '',
                emergEmail : '',
                emergPhone : '',
                emergMobile : '',
                emergPlace : '',
                emergencyOccu : '',
                emerAddress : '',
                emergencyPincode : '',

                // Reference
                referenceName : '',
                occupationRef : '',
                relationshipRef : '',
                emailRef : '',
                referenceAddress : '',
                pincodeRef : '',
                phoneRef : '',

                // Family
                employeetables : [],
                familyName : '',
                genderType : '',
                relationshipWithEmp : '',
                empDependence : false,

                // Education
                employeeEduTables : [],
                qualification : '',
                percentage : '',
                courseType : '',
                institution : '',
                yearPassed : '',

                // Experience
                employeeExpTables : [],
                organization : '',
                experienceYear : '',
                expDesisnation : '',
                expRemarks : '',

                // Merit
                employeeMeritTables : [],
                awardName : '',
                scholarshipName : '',
                meritDesc : '',

                // Document
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
                visaIssuedPlace : '',
                 excelHeaderList:[]
        };
        
        $scope.astatus = [ {
            id : 't',
            text : 'Active'
        }, {
            id : 'f',
            text : 'InActive'
        },{
            id : 'N',
            text : 'All'
        },];
        
        $scope.EmployeeMasterReportData.companyCode;
        $scope.EmployeeMasterReportData.branch;
        $scope.EmployeeMasterReportData.reportToBranch;
        $scope.companyList = [];
        $scope.branchList = [];
        $scope.departmentList = [];
        $scope.designationList = [];
        $scope.bloodgroupList = [];
        $scope.divisionList = [];
        $scope.gradeList = [];
        $scope.reportToBranchList = [];
        $scope.reportToDeptList = [];
        $scope.reportToDesigList = [];
        $scope.reportToDesigList = [];
        $scope.reportToManagerList = [];
        $scope.employeeNameList = [];
        $scope.empTypeList = [];
        $scope.imgfile = [];
        $scope.docfile = [];
        $scope.showreport = [];

        $scope.checkTelephoneLimit = function(value) {
            var regex = /^\d{1,20}\.?\d{0,2}$/;
            var isValid = false;
            isValid = regex.test(value);
            if (value == "") {
            }
            if (isValid == true) {
                $scope.EmployeeMasterReportData.telephoneLimit = value;
            } else if (isValid == false) {
                $scope.EmployeeMasterReportData.telephoneLimit = value.slice(0, -1);
            }
        }

        $scope.checkMedicalLimit = function(value) {
            var regex = /^\d{1,20}\.?\d{0,2}$/;
            var isValid = false;
            isValid = regex.test(value);
            if (value == "") {
            }
            if (isValid == true) {
                $scope.EmployeeMasterReportData.medicalLimit = value;
            } else if (isValid == false) {
                $scope.EmployeeMasterReportData.medicalLimit = value.slice(0, -1);
            }
        }
        $http.get("hrms/master/employeeMaster/getDivisionList").success(function(datas) {
            $scope.divisionList = datas.divisionList;
        })
        $scope.$watch('EmployeeMasterReportData.companyCode', function(newValue, oldValue) {
            if (newValue != undefined && newValue != null && newValue != '') {
                $scope.getBranchList(newValue);
            }

        });

        $scope.$watch('EmployeeMasterReportData.doj', function(newValue, oldValue) {
            if ($scope.EmployeeMasterReportData.dob == '' && newValue != undefined && newValue != '') {
                logger.logError("Please Enter DOB!");
                $scope.EmployeeMasterReportData.doj = "";
            } else {
                if (newValue != undefined && newValue != '' && $scope.EmployeeMasterReportData.dob != '') {
                    var dob = $scope.EmployeeMasterReportData.dob;
                    var doj = newValue;
                    var oneDay = 24 * 60 * 60 * 1000;
                    var dojDate = newValue;
                    var dobDate = $scope.EmployeeMasterReportData.dob;
                    dojDate = dojDate.split("/");
                    dojDate = new Date(dojDate[2], dojDate[1] - 1, dojDate[0]);
                    dobDate = dobDate.split("/");
                    dobDate = new Date(dobDate[2], dobDate[1] - 1, dobDate[0]);
                    if (dobDate < dojDate) {
                        var todayDate = $scope.currentDate;
                        todayDate = todayDate.split("/");
                        todayDate = new Date(todayDate[2], todayDate[1] - 1, todayDate[0]);
                        if (dojDate <= todayDate) {
                            var diffDays = Math.round(Math.abs((dobDate.getTime() - dojDate.getTime()) / (oneDay)));
                            if (parseInt(diffDays) < 6205) {
                                logger.logError("Invalid Date of Joining!");
                                $scope.EmployeeMasterReportData.doj = "";
                            }
                        } else {
                            logger.logError("Invalid Date of Joining!");
                            $scope.EmployeeMasterReportData.doj = "";
                        }

                    } else {
                        logger.logError("DOB should be lesser than the DOJ");
                        $scope.EmployeeMasterReportData.dob = "";

                    }

                }
            }

        });
        var dateObj = new Date();
        var cur_month = dateObj.getUTCMonth() + 1; // months from 1-12
        var cur_year = dateObj.getUTCFullYear();
        var cur_day = dateObj.getUTCDate();
        $scope.currentDate = cur_day + "/" + cur_month + "/" + cur_year;

        $scope.$watch('EmployeeMasterReportData.dob', function(newValue, oldValue) {
          
        debugger;

        if (newValue != undefined && newValue != null && newValue != '') {
            var todayDate = $scope.currentDate;
            var oneDay = 24 * 60 * 60 * 1000;
            var toDate = newValue;
            toDate = toDate.split("/");
            toDate = new Date(toDate[2], toDate[1] - 1, toDate[0]);
            todayDate = todayDate.split("/");
            todayDate = new Date(todayDate[2], todayDate[1] - 1, todayDate[0]);
            if (toDate < todayDate) {
            } else {
                $scope.EmployeeMasterReportData.dob = "";
                logger.logError("DOB Should be lesser than the current date");
            }

            if ($scope.EmployeeMasterReportData.doj != undefined && $scope.EmployeeMasterReportData.doj != '' && $scope.EmployeeMasterReportData.doj != null) {
                var doj = $scope.EmployeeMasterReportData.doj;
                doj = doj.split("/");
                doj = new Date(doj[2], doj[1] - 1, doj[0]);
                if (doj < toDate) {
                    $scope.EmployeeMasterReportData.doj = "";
                    logger.logError("DOJ Should be greater than the DOB");
                } else {
                    var diffDays = Math.round(Math.abs((toDate.getTime() - doj.getTime()) / (oneDay)));
                    if (parseInt(diffDays) < 6205) {
                        logger.logError("Invalid Date of Joining!");
                        $scope.EmployeeMasterReportData.doj = "";
                    }
                }
            }
        }
       
    });


        $scope.getCompanyList = function() {
            var formCode = document.getElementById('formCode').value;
            if(formCode!= undefined && formCode !=''){
                $http.post("app/commonUtility/getUserCompanyList", formCode).success(function(response) {
                    $scope.companyList = response.companyList;
                    if (response.companyList.length == 1) {
                        $scope.EmployeeMasterReportData.companyCode = response.companyList[0].id;
                        $scope.disable = true;
                        $scope.getBranchList($scope.EmployeeMasterReportData.companyCode);
                    }
                })  
                
            }
            
        }
        $scope.getCompanyList();

        $scope.getBranchList = function(companyCode) {
            var myURL = 'hrms/master/employeeMaster/getBranchList?companyCode';
            $http({
                method : 'post',
                url : myURL,
                data : companyCode,
            }).success(function(datas) {
                $scope.branchList = datas.branchList;
                if (datas.branchList.length == 1) {
                    $scope.EmployeeMasterReportData.branch = datas.branchList[0].id;
                    $scope.disable = true;
                    $scope.getDepartmentList($scope.EmployeeMasterReportData.branch);
                }
            });

        }

        $scope.getDepartmentList = function(branchId) {
            $http.post('hrms/hr/shiftallocation/getDepartmentList?branchId', branchId).success(function(datas) {
                $scope.departmentList = datas.departmentList;
                debugger
               
            }).error(function(data) {

            });
        }
        // $scope.getDepartmentList();
        
        $scope.$watch('EmployeeMasterReportData.departmentCode', function(newValue, oldValue) {
            if (newValue != undefined && newValue != '' && newValue != "") {
            debugger
            var depId= $scope.EmployeeMasterReportData.departmentCode;
            var branchId = $scope.EmployeeMasterReportData.branch;
            var url = "hrms/master/employeeAdminMaster/getReportManager?depId=" + depId + "&branchId=" + branchId;
            $http.get(url).success(function(datas) {
            $scope.reportToManagerList = datas;
            }).error(function(data) {
            });
            }
         
        });
     
           
          // $scope.getReportManager();

        $scope.getDesignationList = function() {
            $http.get('hrms/master/employeeMaster/getDesignationList').success(function(datas) {
                $scope.designationList = datas.designationList;
            }).error(function(data) {

            });
        }
        $scope.getDesignationList();
        
        $scope.getBloodGroupList = function() {
            $http.get('hrms/master/employeeMaster/getBloodGroupList').success(function(datas) {
                $scope.bloodgroupList = datas.bloodgroupList;
            }).error(function(data) {

            });
        }
        $scope.getBloodGroupList();

        $scope.getEmployeeList = function() {
            $http.get('hrms/master/employeeMaster/getEmployeeNameList').success(function(datas) {
                $scope.employeeNameList = datas.employeeNameList;

            }).error(function(data) {

            });
        }
        $scope.getEmployeeList();

      

        $scope.getEmpType = function() {
            $http.get('hrms/master/employeeMaster/getEmpType').success(function(datas) {
                $scope.empTypeList = datas.empTypeList;

            }).error(function(data) {

            });
        }
        $scope.getEmpType();
        
      
        $scope.getGradeList = function() {
            $http.get('hrms/master/employeeMaster/getGradeList').success(function(datas) {
                $scope.gradeList = datas.gradeList;

            }).error(function(data) {

            });
        }
        $scope.getGradeList();

    
        $scope.showEmployeeReportList = function(EmployeeMasterReportData) {

            $scope.dataLoopCount = 0;
            $scope.showEmptyLabel = false;
            $scope.from = 0;
            $scope.to = 100;
            $scope.rowCollection = [];
            var cmp = $scope.EmployeeMasterReportData.companyCode;
            var dept = $scope.EmployeeMasterReportData.departmentId;
            var branch = $scope.EmployeeMasterReportData.branch;
            if (cmp == '') {
                cmp = '';
            } else {
                cmp = $scope.EmployeeMasterReportData.companyCode;
            }
            if (dept == '') {
                dept = 0;
            } else {
                dept = $scope.EmployeeMasterReportData.departmentId;
            }
            if (branch == '') {
                branch = '';
            } else {
                branch = $scope.EmployeeMasterReportData.branch;
            }
          
            var detailData = {};
            $http.post('hrms/master/employeeMaster/showEmployeeReportList', EmployeeMasterReportData).success(function(datas) {
              if (datas.success == true) {
                  if (datas.showreport.length > 0) {
                      
                      $scope.tableGenValue=true;
                      $scope.rowCollection = datas.showreport;
                    
                      angular.forEach($scope.rowCollection,function(value,key){
                          
                          if(value.fixedGross == null){
                              value.fixedGross = '-';
                          }
                          if(value.motherTongue == null){
                              value.motherTongue = '-';
                          }
                          if(value.nationality == null){
                              value.nationality = '-';
                          }
                          if(value.languages == null){
                              value.languages = '-';
                          }
                          if(value.bankName == null){
                              value.bankName = '-';
                          }
                          
                      });
              
                    
                  }
                 else
                  {
                      logger.logError("No Records Found"); 
                      $scope.tableGenValue=false;
                  }
                     
                    }
            })
        }

        $scope.emp = {
            empId : false
        }

        //All Select 
        $scope.selectall = true;
        $scope.selectAll = function(value){
            
            for(var index in $scope.employeeReportHeaderList){
               
                var colum = $scope.employeeReportHeaderList[index];
                if(colum.isDefault == false){
                    if(value == true){
                        colum.visible = true;
                    }else{
                        colum.visible = false;
                    }
                }
            }
                
        }
        
        $scope.getReprtHeader = function(){
            
            $http.get('hrms/master/employeeMaster/getReprtHeader')
               .success(function(datas) {
                $scope.employeeReportHeaderList =  datas.headerList;
               }).error(function(datas) {
               });
            
               
        }
           
       $scope.getReprtHeader();

       
        
        $scope.reset=function(){
            $scope.EmployeeMasterReportData.designation='';
            $scope.EmployeeMasterReportData.departmentCode='';
            $scope.EmployeeMasterReportData.branch='';
            $scope.EmployeeMasterReportData.dob='';
            $scope.EmployeeMasterReportData.reportMangrId='';
            $scope.EmployeeMasterReportData.marritalStatus=undefined;
            $scope.EmployeeMasterReportData.esiApp=undefined;
            $scope.EmployeeMasterReportData.pfApp=undefined;
            $scope.EmployeeMasterReportData.isActiveSight='';
            $scope.EmployeeMasterReportData.isActiveDumb='';
            $scope. EmployeeMasterReportData.isActiveHearing='';
            $scope.EmployeeMasterReportData.isActiveHand='';
            $scope.EmployeeMasterReportData.division='';
            $scope. EmployeeMasterReportData.isActiveFeet='';

            $scope.showreport = [];

            if($scope.tableGenValue){
                $scope.rowCollection = [];
                $scope.tableGenValue=false;
            }
        }
   $scope.exportExcel = function(EmployeeMasterReportData) {
       
       $scope.EmployeeMasterReportData.excelHeaderList= $filter('filter')($scope.employeeReportHeaderList, { visible: true}, true);
       
       
            $http.post('hrms/master/employeeMaster/exportexcel', $scope.EmployeeMasterReportData).success(function(response){
                console.log(response);
                if (response.success) {
                    if(response.filePath != null){
                        $scope.fileUrl = response.filePath;  
                        $scope.filePath = response.filePath; 
                        $scope.downloadFilePath = response.filePath.split("/");
                        $scope.actualLength=$scope.downloadFilePath.length;
                        $scope.fileLength=$scope.actualLength - 1;
                        $scope.downloadFile = $scope.downloadFilePath[$scope.fileLength];
                        console.log($scope.downloadFile)
                        
                        logger.logSuccess("Exported successfully!");
                         $('#empDtlExport').attr('href','imgFiles/' +$scope.downloadFile);
                        $("#empDtlExport").bind('click', function() {
                       });
                       $('#empDtlExport').simulateClick('click');
                        }
                        else
                            { 
                            logger.logError("No Record Found!");

                            }  
                    
            }else{
                logger.logError("Failed to export");
            }
        });
    }
        $.fn.simulateClick = function() {
            return this.each(function() {
                if ('createEvent' in document) {
                    var doc = this.ownerDocument, evt = doc.createEvent('MouseEvents');
                    evt.initMouseEvent('click', true, true, doc.defaultView, 1, 0, 0, 0, 0, false, false, false, false, 0, null);
                    this.dispatchEvent(evt);
                } else {
                    this.click();
                }
            });
        } 

    });

