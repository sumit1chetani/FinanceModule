    'use strict';
    	app.controller('salaryfixationCtrl', function($scope,$stateParams, $rootScope, $http,validationService, $location,ngDialog, logger, utilsService,$state,sharedProperties,$window) {

        $scope.employeePaycomponenet = {
            payComponentName : '',
            amount : '',
            fromdate : '',
            todate : '',
            employeeId : '',
            departmentId : '',
            companyName : '',
            branchName : '',
            branchId : '',
            companyId : '',
            largeDateValue : '',
            isEdit : false,
            isOnLoad : false
        };
        $scope.isAuthorized = false;
        $scope.empPayComList = [];
        $scope.earningList = [];
        $scope.deductionList = [];
        $scope.employeePayComponentList = [];
        $scope.isDelete = true;
        $scope.isUpload = true;
        var employeeId = $location.search().employeeId;
        var departmentId = $location.search().departmentId;
        var companyId = $location.search().companyId;
        var branchId = $location.search().branchId;
        var isValue = $location.search().isValue;
        
        $scope.exportExcel = function(salaryfixationListForm) {

            if ($scope.employeePayComponentList != null && $scope.employeePayComponentList != "" && $scope.employeePayComponentList != undefined) {

                $http.post("payroll/payroll/employeepaycom/payrollExport", $scope.employeePayComponentList).success(function(response) {
                    console.log(response);
                    if (response.success) {
                        $scope.fileUrl = response.payrollExport.filePath;
                        $scope.downloadFilePath = response.payrollExport.filePath.split("/");
                        $scope.downloadFile = $scope.downloadFilePath[1];
                        console.log($scope.downloadFile);
                        $("#sPdfExport").attr("href", $scope.fileUrl);
                        $("#sPdfExport").bind('click', function() {
                        });
                        $('#sPdfExport').simulateClick('click');
                        logger.logSuccess("Exported Succesfully!");
                    } else {
                        logger.logError("Failed to export");
                    }
                });

            } else {
                logger.logError("List Empty");
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

       
        $scope.getCompanyList = function() {
        	$http.get(		$stateParams.tenantid	+ '/app/usermaster/getCompanyList?formCode='
					+ 'F0367')	.success(function(datas) {
          //  $http.get("payroll/payroll/payrollgeneration/getCompanyList").success(function(datas) {
                console.log("getCompanyList");
                $scope.companyList = datas;
               /* if ($scope.companyList.length >= 1) {
                    $scope.employeePaycomponenet.companyId = $scope.companyList[0].companyId;
                    $scope.employeePaycomponenet.companyName = $scope.companyList[0].companyName;
                }
*/                console.log(datas);
            })
        }

        $scope.$watch('employeePaycomponenet.companyId', function(newValue, oldValue) {

            if (newValue != '' && newValue != null && newValue != undefined) {
                var companyId = newValue;
                if ($scope.employeePaycomponenet.companyId != '' && $scope.employeePaycomponenet.isOnLoad == false) {
                    $scope.employeePaycomponenet.branchId = '';
                    $scope.employeePaycomponenet.departmentId = '';
                    $scope.employeePaycomponenet.employeeId = '';
                    $scope.employeePaycomponenet.branchName = '';
                }
                $http.post("payroll/payroll/payrollgeneration/getBranchList", companyId).success(function(datas) {
                    console.log("getBranchList");
                    $scope.employeePaycomponenet.isOnLoad = false;
                    $scope.branchList = datas.branchList;
                    if ($scope.branchList.length == 1) {
                        $scope.employeePaycomponenet.branchId = $scope.branchList[0].id;
                        $scope.employeePaycomponenet.branchName = $scope.branchList[0].text;
                    }
                    $scope.employeePaycomponenet.departmentId = '';
                    $scope.departmentList = [];
                    $scope.employeeList = [];
                    console.log($scope.branchList);
                })
            }
        });



            $scope.$watch('employeePaycomponenet.branchId', function(newValue, oldValue) {
                if ($scope.employeePaycomponenet.branchId != '' && $scope.employeePaycomponenet.isOnLoad == false) {
                    $scope.employeePaycomponenet.departmentId = '';
                    $scope.employeePaycomponenet.employeeId = '';

                }
                if (newValue != '' && newValue != null && newValue != undefined) {
                    var branchId = newValue;
                    $http.post("payroll/payroll/payrollgeneration/getDepartmentList", branchId).success(function(datas) {
                        console.log("LoginUseDepartmentList");
                        console.log(datas);
                        $scope.employeePaycomponenet.isOnLoad = false;
                        $scope.departmentList = datas.departmentList;
                        $scope.employeeList = datas.employeeList;
                        $scope.employeePaycomponenet.departmentId = '';
                        if (departmentId != undefined && departmentId != null && departmentId != '') {
                            $scope.employeePaycomponenet.departmentId = departmentId;
                            $scope.employeeList = [];

                        }

                    })
                }
            });


        $scope.getEmployeeDetails = function() {

            $http.get("payroll/payroll/payrollgeneration/getUserDetail").success(function(datas) {
                console.log("LoginUser");
                console.log(datas);
                $scope.getCompanyList();
                $scope.employeePaycomponenet.isOnLoad = true;
                if (companyId != '' && companyId != null && companyId != undefined) {
                    $scope.employeePaycomponenet.companyId = companyId;
                } else {
                    $scope.employeePaycomponenet.companyId = datas.companyId;
                }
                if (branchId != '' && branchId != null && branchId != undefined) {
                    $scope.employeePaycomponenet.branchId = branchId;
                } else {
                    $scope.employeePaycomponenet.branchId = datas.branchId;
                }

            })
        }

        $scope.getEmployeeDetails();

        $scope.$watch('employeePaycomponenet.departmentId', function(newValue, oldValue) {
            if ($scope.employeePaycomponenet.departmentId != '' && $scope.employeePaycomponenet.isOnLoad == false) {
                $scope.employeePaycomponenet.employeeId = '';
            }
            if (newValue != '' && newValue != null && newValue != undefined) {
                var dept = newValue;
                var branchId = $scope.employeePaycomponenet.branchId;
                console.log("Department ID:" + departmentId);
                console.log("Branch ID:" + branchId);
                var resultBean = {
                    branchId : branchId,
                    dept : dept
                };
                $http.post("payroll/payroll/payrollgeneration/getEmployeeList", resultBean).success(function(datas) {
                    console.log("LoginUseEmployeeList");
                    $scope.employeePaycomponenet.isOnLoad = false;
                    $scope.employeeList = datas.employeeList;
                    if (employeeId != undefined && employeeId != null && employeeId != '') {
                        $scope.employeePaycomponenet.employeeId = employeeId;
                        // employeeId='';
                    }
                    console.log(datas);
                })

            }

        });

        
        $scope.first = function(){
            if ($scope.employeePaycomponenet.employeeId == '') {
                $scope.isAdd = true;   
            }else{
                $scope.isAdd = false;
            }
            
        }
        
        $scope.first();
        
        
        
        $scope.renamingDateValue = function(paycomponenetList) {
            $scope.employeePayComponentList = paycomponenetList;
            angular.forEach($scope.employeePayComponentList, function(value, key) {   
                var startDate = value.fromdate;
                if(startDate!=null || startDate!=''){
                startDate = startDate.split("-");
                startDate = startDate[2] + "/" + startDate[1] + "/" + startDate[0];
                value.fromdate = startDate;
                }else{
                    value.fromdate='';
                    
                }
            });

        }


        $scope.checkingLargeDate = function(paycomponenetList) {
            $scope.employeePayComponentList = paycomponenetList;
            var prevsDate = null;
            angular.forEach($scope.employeePayComponentList, function(value, key) {
                if (prevsDate == null) {
                    prevsDate = value.fromdate;
                    prevsDate = prevsDate.split("/");
                    prevsDate = new Date(prevsDate[2], prevsDate[1] - 1, prevsDate[0]);
                }
                var currentDate = value.fromdate;
                currentDate = currentDate.split("/");

                currentDate = new Date(currentDate[2], currentDate[1] - 1, currentDate[0]);
                if (currentDate >= prevsDate) {
                    $scope.employeePaycomponenet.largeDateValue = value.fromdate;
                }
                prevsDate = currentDate;

            });

        }

        $scope.submit = function(salaryfixationListForm, employeePaycomponenet) {
            
            if ($scope.employeePaycomponenet.departmentId != '' && $scope.employeePaycomponenet.departmentId != null && $scope.employeePaycomponenet.departmentId != undefined
                    && $scope.employeePaycomponenet.employeeId != '' && $scope.employeePaycomponenet.employeeId != null && $scope.employeePaycomponenet.employeeId != undefined) 
            {
//                $scope.show=false;
                $scope.isAdd = false;
            } else {
                $scope.isAdd = true;
//                $scope.show=true;

            }

            if ($scope.employeePaycomponenet.departmentId != '' && $scope.employeePaycomponenet.employeeId != ''
                && $scope.employeePaycomponenet.departmentId != null && $scope.employeePaycomponenet.employeeId != null
                    && $scope.employeePaycomponenet.departmentId != undefined && $scope.employeePaycomponenet.employeeId != undefined) {
                debugger
                $http.get("payroll/payroll/employeepaycom/list?employeeId=" + employeePaycomponenet.employeeId).success(function(response) {
                    console.log("response is");
                    console.log(response);
                    $scope.renamingDateValue(response.employeeComponentList);
                    $scope.checkingLargeDate($scope.employeePayComponentList);
                    angular.forEach($scope.employeePayComponentList, function(value,key){
                        var employeeId = $scope.employeePaycomponenet.employeeId;
                        var fromDate= value.fromdate;
                        fromDate = fromDate.split("/");
                        fromDate= fromDate[1] + fromDate[2];
                        var startDate= fromDate;
                       /* $http.get('payroll/payroll/payrollgeneration/checkAlreadyGenerated?employeeId=' +employeeId+ '&startDate=' +startDate).success(function(data){
                            
                            console.log(data.checkALreadyCreated);
                                $scope.employeePayComponentList[key].checkALreadyCreated=data.checkALreadyCreated;
                          
                            
                        })*/
                        
                       /* $.ajax({
                            type : "GET",
                            url :'payroll/payroll/payrollgeneration/checkAlreadyGenerated?employeeId=' +employeeId+ '&startDate=' +startDate,
                            data : "",
                            async: false,
                            contentType: false,
                            processData: false,
                            success : function(response) {
                            if(response){
                               // checkALreadyCreated=true;
                            $scope.employeePayComponentList[key].checkALreadyCreated=response.checkALreadyCreated;
                            }
                            else{
                               // checkALreadyCreated=false;
                            }
                            }
                            });*/
                        
                        
                       /* if( $scope.employeePaycomponenet.checkALreadyCreated == true){
                                              
                            
                        }*/
                    });
                    console.log($scope.employeePaycomponenet.largeDateValue);
                    $scope.rowCollection = $scope.employeePayComponentList;
                    $scope.employeePaycomponenet.isEdit = true;

                });
            } else if (($scope.employeePaycomponenet.departmentId != '' && $scope.employeePaycomponenet.employeeId == '')
                || ($scope.employeePaycomponenet.departmentId != null && $scope.employeePaycomponenet.employeeId == null)
                    || ($scope.employeePaycomponenet.departmentId != undefined && $scope.employeePaycomponenet.employeeId == undefined)) {

                $http.get("payroll/payroll/employeepaycom/list2?departmentId=" + employeePaycomponenet.departmentId).success(function(response) {
                    console.log("response is");
                    console.log(response);
                    $scope.renamingDateValue(response.employeeComponentList);
                    $scope.checkingLargeDate($scope.employeePayComponentList);
                    
                    
                    angular.forEach($scope.employeePayComponentList, function(value,key){
                        var employeeId = $scope.employeePaycomponenet.employeeId;
                        var fromDate= value.fromdate;
                        fromDate = fromDate.split("/");
                        fromDate= fromDate[1] + fromDate[2];
                        var startDate= fromDate;
                       /* $http.get('payroll/payroll/payrollgeneration/checkAlreadyGenerated?employeeId=' +employeeId+ '&startDate=' +startDate).success(function(data){
                            
                            console.log(data.checkALreadyCreated);
                                $scope.employeePayComponentList[key].checkALreadyCreated=data.checkALreadyCreated;
                          
                            
                        })*/
                        
                      /*  $.ajax({
                            type : "GET",
                            url :'payroll/payroll/payrollgeneration/checkAlreadyGenerated?employeeId=' +employeeId+ '&startDate=' +startDate,
                            data : "",
                            async: false,
                            contentType: false,
                            processData: false,
                            success : function(response) {
                            if(response){
                               // checkALreadyCreated=true;
                            $scope.employeePayComponentList[key].checkALreadyCreated=response.checkALreadyCreated;
                            }
                            else{
                               // checkALreadyCreated=false;
                            }
                            }
                            });*/
                        
                        
                       /* if( $scope.employeePaycomponenet.checkALreadyCreated == true){
                                              
                            
                        }*/
                    });
                    
                    
                    console.log($scope.employeePaycomponenet.largeDateValue);
                    $scope.rowCollection = $scope.employeePayComponentList;
                    $scope.employeePaycomponenet.isEdit = true;

                });

            } else if (($scope.employeePaycomponenet.departmentId == '' && $scope.employeePaycomponenet.employeeId == '')
                || ($scope.employeePaycomponenet.departmentId == null && $scope.employeePaycomponenet.employeeId == null)
                    || ($scope.employeePaycomponenet.departmentId == undefined && $scope.employeePaycomponenet.employeeId == undefined)) {

                $http.get("payroll/payroll/employeepaycom/list1").success(function(response) {
                    console.log("response is");
                    console.log(response);
                    $scope.renamingDateValue(response.employeeComponentList);
                    $scope.checkingLargeDate($scope.employeePayComponentList);
                  
                    angular.forEach($scope.employeePayComponentList, function(value,key){
                        var  dept=value.departmentId;
$rootScope.dptId=departmentId;
                        var employeeId = $scope.employeePaycomponenet.employeeId;
                        var fromDate= value.fromdate;
                        fromDate = fromDate.split("/");
                        fromDate= fromDate[1] + fromDate[2];
                        var startDate= fromDate;
                       /* $http.get('payroll/payroll/payrollgeneration/checkAlreadyGenerated?employeeId=' +employeeId+ '&startDate=' +startDate).success(function(data){
                            
                            console.log(data.checkALreadyCreated);
                                $scope.employeePayComponentList[key].checkALreadyCreated=data.checkALreadyCreated;
                          
                            
                        })*/
                        
                     /*   $.ajax({
                            type : "GET",
                            url :'payroll/payroll/payrollgeneration/checkAlreadyGenerated?employeeId=' +employeeId+ '&startDate=' +startDate,
                            data : "",
                            async: false,
                            contentType: false,
                            processData: false,
                            success : function(response) {
                            if(response){
                               // checkALreadyCreated=true;
                            $scope.employeePayComponentList[key].checkALreadyCreated=response.checkALreadyCreated;
                            }
                            else{
                               // checkALreadyCreated=false;
                            }
                            }
                            });
                        */
                        
                       /* if( $scope.employeePaycomponenet.checkALreadyCreated == true){
                                              
                            
                        }*/
                    });
                    
                    
                    console.log($scope.employeePaycomponenet.largeDateValue);
                    $scope.rowCollection = $scope.employeePayComponentList;
                    $scope.employeePaycomponenet.isEdit = true;

                });

            } else if (($scope.employeePaycomponenet.departmentId == '' && $scope.employeePaycomponenet.employeeId !== '')
                || ($scope.employeePaycomponenet.departmentId == null && $scope.employeePaycomponenet.employeeId !== undefined)
                    || ($scope.employeePaycomponenet.departmentId == null && $scope.employeePaycomponenet.employeeId !== undefined)) {

                $http.get("payroll/payroll/employeepaycom/list?employeeId=" + $scope.employeePaycomponenet.employeeId ).success(function(response) {
                    console.log("response is");
                    console.log(response);
                    $scope.renamingDateValue(response.employeeComponentList);
                    $scope.checkingLargeDate($scope.employeePayComponentList);
                    
                    angular.forEach($scope.employeePayComponentList, function(value,key){
                       var  dept=value.departmentId;
                       $rootScope.dptId=departmentId;
                        var employeeId = $scope.employeePaycomponenet.employeeId;
                        var fromDate= value.fromdate;
                        fromDate = fromDate.split("/");
                        fromDate= fromDate[1] + fromDate[2];
                        var startDate= fromDate;
                       /* $http.get('payroll/payroll/payrollgeneration/checkAlreadyGenerated?employeeId=' +employeeId+ '&startDate=' +startDate).success(function(data){
                            
                            console.log(data.checkALreadyCreated);
                                $scope.employeePayComponentList[key].checkALreadyCreated=data.checkALreadyCreated;
                          
                            
                        })*/
                        
                       /* $.ajax({
                            type : "GET",
                            url :'payroll/payroll/payrollgeneration/checkAlreadyGenerated?employeeId=' +employeeId+ '&startDate=' +startDate,
                            data : "",
                            async: false,
                            contentType: false,
                            processData: false,
                            success : function(response) {
                            if(response){
                               // checkALreadyCreated=true;
                            $scope.employeePayComponentList[key].checkALreadyCreated=response.checkALreadyCreated;
                            }
                            else{
                               // checkALreadyCreated=false;
                            }
                            }
                            });*/
                        
                        
                       /* if( $scope.employeePaycomponenet.checkALreadyCreated == true){
                                              
                            
                        }*/
                    });
                    
                    console.log($scope.employeePaycomponenet.largeDateValue);
                    $scope.rowCollection = $scope.employeePayComponentList;
                    $scope.employeePaycomponenet.isEdit = true;

                });

            }

        }

        $scope.getPayComponentList = function(employeeId) {
            $scope.rowCollection = [];
            $scope.employeePaycomponenet.employeeId = employeeId;
            $http.get("payroll/payroll/employeepaycom/list?employeeId=" + $scope.employeePaycomponenet.employeeId).success(function(response) {
                console.log("response is");
                console.log(response);
                $scope.employeePayComponentList = response.employeeComponentList;
                // alert("hell0");
                $scope.employeePaycomponenet.departmentId = response.employeeComponentList[0].departmentId;
                $scope.employeePaycomponenet.employeeId = response.employeeComponentList[0].employeeId;
                // $scope.employeePaycomponenet.companyId =
                // response.employeeComponentList[0].companyId;
                // $scope.employeePaycomponenet.branchId =
                // response.employeeComponentList[0].branchId;
                $scope.renamingDateValue(response.employeeComponentList);
                $scope.checkingLargeDate($scope.employeePayComponentList);
                
                angular.forEach($scope.employeePayComponentList, function(value,key){
                    var employeeId = $scope.employeePaycomponenet.employeeId;
                    var fromDate= value.fromdate;
                    fromDate = fromDate.split("/");
                    fromDate= fromDate[1] + fromDate[2];
                    var startDate= fromDate;
                   /* $http.get('payroll/payroll/payrollgeneration/checkAlreadyGenerated?employeeId=' +employeeId+ '&startDate=' +startDate).success(function(data){
                        
                        console.log(data.checkALreadyCreated);
                            $scope.employeePayComponentList[key].checkALreadyCreated=data.checkALreadyCreated;
                      
                        
                    })*/
                    
                   /* $.ajax({
                        type : "GET",
                        url :'payroll/payroll/payrollgeneration/checkAlreadyGenerated?employeeId=' +employeeId+ '&startDate=' +startDate,
                        data : "",
                        async: false,
                        contentType: false,
                        processData: false,
                        success : function(response) {
                        if(response){
                           // checkALreadyCreated=true;
                        $scope.employeePayComponentList[key].checkALreadyCreated=response.checkALreadyCreated;
                        }
                        else{
                           // checkALreadyCreated=false;
                        }
                        }
                        });*/
                    
                    
                   /* if( $scope.employeePaycomponenet.checkALreadyCreated == true){
                                          
                        
                    }*/
                });
                
                console.log($scope.employeePaycomponenet.largeDateValue);
                $scope.rowCollection = $scope.employeePayComponentList;

            });

        }

        if (employeeId != undefined) {
            console.log(departmentId);
            console.log(employeeId);
            $scope.employeePaycomponenet.departmentId = departmentId;
            $scope.employeePaycomponenet.employeeId = employeeId;
            $scope.getPayComponentList(employeeId);

        }

        $scope.editRow = function(employeeId, fromdate) {
            debugger
            if($scope.employeePaycomponenet.departmentId!=''){
           var dept = $scope.employeePaycomponenet.departmentId;
            }else{
                var dept=$rootScope.dptId;
            }
            
            var companyId = $scope.employeePaycomponenet.companyId;
            var branchId = $scope.employeePaycomponenet.branchId;
            $location.url('/payroll/payroll/salaryfixation/edit?employeeId=' + employeeId + '&fromdate=' + fromdate + '&dept=' + dept + '&branchId=' + branchId + '&companyId=' + companyId);
        }

        $scope.add = function() {
            var dept = $scope.employeePaycomponenet.departmentId;
            var employeeId = $scope.employeePaycomponenet.employeeId;
            var companyId = $scope.employeePaycomponenet.companyId;
            var branchId = $scope.employeePaycomponenet.branchId;
            if (dept != null && dept != undefined && dept != '') {
                if (employeeId != null && employeeId != undefined && employeeId != '') {
                    $location.url('/payroll/payroll/salaryfixation/getValue?dept=' + dept + '&employeeId=' + employeeId + '&branchId=' + branchId + '&companyId=' + companyId);
                } else {
                    logger.logError("Please select Department!");
                }
            } else {
                logger.logError("Please select Employee!");
            }
        };

        $scope.deleteRow = function(employeeId, fromdate) {
            ngDialog.openConfirm().then(function() {
                var resultBean = {
                    employeeId : employeeId,   //$scope.employeePaycomponenet.employeeId,
                    fromdate : fromdate
                };
                $http.post("payroll/payroll/employeepaycom/delete", resultBean).success(function(response) {
                    if (response == true) {
                        logger.logSuccess("Deleted Successfully!");

                       // $scope.getPayComponentList($scope.employeePaycomponenet.employeeId);
                        $scope.submit(resultBean.employeeId);
                    }
                }).error(function(result) {
                    logger.logError("Error Please Try Again");
                });
            });
        };

        $scope.getEmployeeId = function(empId) {

            $scope.employeePaycomponenet.employeeId = empId;
            $scope.rowCollection = [];

        };

        $scope.fileUpload = function() {
            ngDialog.close();
            ngDialog.open({
                template : 'fileModal',
                scope : $scope
            });
        };

        $rootScope.uploadFile = function(element) {

            console.log("excel file");
            $scope.excelfile = element.files[0];
            console.log($scope.excelfile);
        }

        $rootScope.closeFileDialog = function() {
            ngDialog.close();
        };

        $rootScope.uploadSalary = function() {
            ngDialog.close();
            var excelfile = $scope.excelfile;
            var fileExtension = excelfile.name;
            var fName = [];
            fName = fileExtension.split(".");
            for (var i = 0; i < fName.length; i++) {
                if (fName[i] == "xls" || fName[i] == "xlsx") {
                    var frmData = new FormData();
                    frmData.append("file", excelfile);
                    $.ajax({
                        type : "POST",
                        url : "payroll/payroll/employeepaycom/uploadfile",
                        data : frmData,
                        contentType : false,
                        processData : false,
                        success : function(result) {
                            console.log("result")
                            console.log(result)
                            if (result.success) {
                                if (result.empPayComBean.isValid) {
                                    logger.logSuccess("File Uploaded Successfully");
                                } else {
                                    logger.logError(result.empPayComBean.errorMessage);
                                }//

                            } else {
                                logger.logError("Fail to upload");
                            }

                        }

                    });
                }

            }
        }

        $scope.viewRow = function(employeeId, fromdate) {
            debugger
            var dept = $scope.employeePaycomponenet.departmentId;
            var companyId = $scope.employeePaycomponenet.companyId;
            var branchId = $scope.employeePaycomponenet.branchId;
            $location.url('/payroll/payroll/salaryfixation/view?employeeId=' + $scope.employeePaycomponenet.employeeId + '&fromdate=' + fromdate + '&dept=' + dept + '&branchId=' + branchId + '&companyId=' + companyId);
        }
        
        $scope.exportSampleExcel = function() {
            // if (new validationService().checkFormValidity(lopListForm)){
            var companyId = $scope.employeePaycomponenet.companyId;
            var branchId = $scope.employeePaycomponenet.branchId;
            var dept = $scope.employeePaycomponenet.departmentId;
            var monthYear = $scope.employeePaycomponenet.monthYear;
            if (dept == null || dept == undefined || dept == '') {
            	dept = null;
            }
            var resultBean = {
                companyId : companyId,
                branchId : branchId,
                dept : dept,
                monthYear : monthYear
            }
            console.log("resultbean is");
            console.log(resultBean);

            $http.post('payroll/payroll/employeepaycom/exportSampleExcel', resultBean).success(function(data) {

                console.log("export report");
                console.log(data);
                if (data.success == true) {
                    $scope.employeePaycomponenet.Show = true;
                    
                    $("#Export").bind('click', function() {
                    });
                    $('#Export').simulateClick('click');

                    logger.logSuccess("File Exported Successfully");
                 /*   $('#btnRowDivIdsamp').append('<a id="captainMsglink" href="tempdoc/Sample_Employee_Salary_Upload_File.xls" class="control-label" download="Sample_Employee_Salary_Upload_File.xls"></a>');
                    $("#captainMsglink").bind('click', function() {
                    });
                    $('#captainMsglink').simulateClick('click');*/
                } else {
                    $scope.employeePaycomponenet.Show = false;
                    logger.logError("Error Please Try Again")

                }
            }).error(function(data) {
            });
            /*
             * }else { toaster.pop('error', "Please fill the required fields",
             * logger.getErrorHtmlNew(employeeTdsForm.$validationSummary),5000,
             * 'trustedHtml'); }
             */
        };

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

    
});