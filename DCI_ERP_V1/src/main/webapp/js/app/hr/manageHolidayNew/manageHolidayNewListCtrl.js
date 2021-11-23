
    'use strict';

    app.controller('manageholidayNewListCtrl', function($scope,$state,$http,ngDialog, $stateParams,logger,$location,$controller,
    		$injector, sharedProperties, toaster,$rootScope,validationService) {
        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.holidayList = [];
        $scope.isDelete=true;
        
      /* $scope.add=function(){
            var formCode= $("#form_code").val();
            formCode="F6060";
            $scope.callDialog($scope, 0, $http, ngDialog, logger,$injector, sharedProperties, toaster,$rootScope, formCode);
        }*/
    
        $scope.add = function(){
            $state.go("app.hr.manageHolidayNewadd-add",{tenantid:$stateParams.tenantid});

        };
        
        $scope.getList = function(){
            $http.get($stateParams.tenantid+"/app/hr/holiday/list").success(function(response) {

                $scope.rowCollection = response.holidayList;
                //console.log(response.holidayList)
                
            });
        };
        
        $scope.getList();
        
        $scope.editRow = function(holidayMaster){
            var formCode= 'F0270'//$("#form_code").val();
           //$state.go('app.hr.manageHolidayNew.edit',{ holidayId:holidayId });
            $scope.callDialog($scope, holidayMaster.holidayId, $http, ngDialog, logger,$injector, sharedProperties, toaster,$rootScope,formCode);
       //$location.url($stateParams.tenantid+'/hr/manageHolidayNew/edit?holidayId='+holidayMaster.holidayId,{tenantid:$stateParams.tenantid})
       //$state.go("app.hr.manageHolidayNew.edit?holidayId="+holidayMaster.holidayId,{tenantid:$stateParams.tenantid});

        }
        
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
        
        $rootScope.uploadHoliday = function() {
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
                        url : $stateParams.tenantid+"/app/hr/holiday/uploadfile",
                        data : frmData,
                        contentType : false,
                        processData : false,
                        success : function(result) {
                            console.log("result")
                            console.log(result)
                            if (result.success) {
                                logger.logSuccess("File Uploaded Successfully");
                                $scope.getList();
                            } else {
                                logger.logError("Unable to upload the given excel due to the improper data. Please refer the sample excel for correct format.");
                            }

                        }

                    });
                }

            }
        }
        
        $scope.deleteRow=function(holidayId){
            
            ngDialog.openConfirm().then(function() {
                var myURL = $stateParams.tenantid+'/app/hr/holiday/delete?holidayId';
                $http({
                    method : 'post',
                    url : myURL,
                    data : holidayId,
                }).success(function(data) {
                    console.log("dataadeleteeee");
                    console.log(data);
                    if (data == true) {
                      
                        logger.logSuccess("Deleted successfully");
                        $scope.getList();
                    } else {
                        logger.logError("Error in deleting Holiday Master!");
                    }
                }).error(function(data) {
                    logger.logError("Error in Delete!");
                });
            });
        }
        
        
        $scope.callDialog = function($scope, holidayId, $http, ngDialog, logger,$injector, sharedProperties, toaster,$rootScope,formCode){
            ngDialog.open({
                scope: $scope,
                template: 'views/hrms/manageHolidayNew/manageHolidayNewEdit',
                controller: $controller('holidayMasterAddCtrl1', {
                    $scope: $scope,
                    holidayId: holidayId,
                    $http:$http,
                    ngDialog:ngDialog,
                    logger:logger,
                    $injector:$injector, 
                    sharedProperties:sharedProperties, 
                    toaster:toaster,
                    $rootScope:$rootScope,
                    formCode: formCode
                }),
                className: 'ngdialog-theme-plain',
                showClose: false,
                closeByDocument: false,
                closeByEscape: false,
                preCloseCallback : $scope.getList
            });
        }
        

    });
    
    
    app.controller('holidayMasterAddCtrl1', function($scope, $http,$stateParams, ngDialog,logger,holidayId,$injector, sharedProperties, toaster,$rootScope,formCode,validationService) {
        $scope.holidayMaster = {
            branch : '',
            branchId:'',
            companyName : '',
            companyId : '',
            holidayName : '',
            date : '',
            day : '',
        };
        //$scope.companyList=[];

       // $scope.branchList=[];
$scope.isBranch =false;
        
        $scope.cancel = function() {
            ngDialog.close();
        };
        
        /*$scope.getCompanyList=function(){
           // console.log($scope);
            $http.post($stateParams.tenantid+"app/commonUtility/getUserCompanyList",formCode).success(function(response) {
                console.log(response.companyList[0].id);
                console.log(response.companyList);
                $scope.companyList=response.companyList;
                if(response.companyList.length==1){
                    $scope.holidayMaster.companyId = response.companyList[0].id;
                    $scope.disable=true;
                    //$scope.getBranchList($scope.holidayMaster.companyId);
                }
              })
        }
        $scope.getCompanyList();*/
        $scope.companyList=[{
        	id:'C0001',
        	text:'MBK'
        }]
        
       /* $scope.$watch('holidayMaster.companyId', function(newValue, oldValue) {
            if(newValue!=null && newValue!=""){
                $scope.getBranchList(newValue); 
            }           
        });*/

        $http.post($stateParams.tenantid+'/app/hr/holiday/branchlist').success(function(data) {
        	      	
          		$scope.branchList=data;
          		        		
        	});
   
            
               /* $http.get($stateParams.tenantid+"/app/hr/holiday/getBranchList").success(function(datas) {
                    debugger
                    if(datas.branchList.length >0){
                        $scope.isBranch =true;
                        $scope.branchList = datas.branchList; 
                        
                        
                    }
                    else
                        {
                    $scope.branchList = []; 
                        }
                 }); */
           
                
               /* $http.get($stateParams.tenantid+'/app/hr/shiftreallocation/branchList').success(function(datas) {
                    $scope.branchList = datas;
                    }).error(function(datas) {
                });
                */
        
        $scope.isEdit = false;
        if(holidayId != 0){
      //      console.log(holidayId);
            $scope.isEdit = true;
            
            $http.post($stateParams.tenantid+"/app/hr/holiday/getholidayList",holidayId)
            .success(function(response) {
                   $scope.holidayMaster = response;
                   $scope.holidayMaster.companyId=response.companyId;
                   $scope.holidayMaster.branch=response.branchId;
                   $scope.getCompanyList();


            });
        }
        
        $scope.submit = function(holidayMasterForm) {
            console.log($scope.holidayMaster);
            sharedProperties.clearObject();
            if (new validationService().checkFormValidity(holidayMasterForm)) {
            $http.post($stateParams.tenantid+'/app/hr/holiday/add', $scope.holidayMaster).success(function(response) {
               //alert("hi");
                   if(response == true){
                       logger.logSuccess("Saved Succesfully!");
                       ngDialog.close();
                   }else{
                       logger.logError("Already Exists!");
                   }
            });
            }else{
                toaster.pop('error', "Please fill the required fields", 
                        logger.getErrorHtmlNew(holidayMasterForm.$validationSummary), 10000, 'trustedHtml');
            }
        };
        
        $scope.update = function(holidayMasterForm) {
            var holidayMaster=$scope.holidayMaster;
            sharedProperties.clearObject();
            if (new validationService().checkFormValidity(holidayMasterForm)) {
            $http.post($stateParams.tenantid+'/app/hr/holiday/update', $scope.holidayMaster).success(function(result) {
                if (result==true) {
                    logger.logSuccess("Updated Succesfully!");
                    ngDialog.close();
                   
                } else {
                    logger.logError("Not Updated!");
                }
            });
            }else{
                toaster.pop('error', "Please fill the required fields", 
                        logger.getErrorHtmlNew(holidayMasterForm.$validationSummary), 10000, 'trustedHtml');
            }
        };
        
        
        $scope.reset = function(holidayMaster) {
            if($scope.isEdit == true){
             var holidayId = $scope.holidayMaster.holidayId;
             $scope.holidayMaster.holidayName ='';
             $scope.holidayMaster.date ='';
            
             
             $http.post($stateParams.tenantid+"/app/hr/holiday/getholidayList",holidayId)
             .success(function(response) {
                 console.log("editresultttttttttt");
                 console.log(response); 
                    $scope.holidayMaster = response;
                    
             });
            }else{
                $scope.holidayMaster.holidayName ='';
                $scope.holidayMaster.date ='';
                $scope.holidayMaster.branch='';
                $scope.holidayMaster.companyId='';
             }
            };
    });
  
    
