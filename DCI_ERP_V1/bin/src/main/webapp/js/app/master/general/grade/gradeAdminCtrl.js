
    'use strict';
app.controller('gradeAdminCtrl', function($scope,ngDialog,$stateParams,$rootScope, $http, $location, logger, utilsService, $state, sharedProperties, $window,validationService,toaster) {

  $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages=0;
        $scope.isDelete=true;
        $scope.isUpload=true;
        $scope.add = function(){
            $state.go("app.truck.general.grade.gradeadd",{tenantid:$stateParams.tenantid});
        };
        $scope.getList = function(){
            $http.get($stateParams.tenantid+"/hrms/master/gradeadmin/list")
            .success(function(response) {
                $scope.rowCollection = response.gradeList;
            });
        };
        $scope.getList();
        
        $scope.editRow = function(gradeMaster) {
        	$location.url($stateParams.tenantid+'/grade/gradeedit?gradeId='+gradeMaster.gradeId);
        };
        $scope.deleteRow = function(gradeMaster) {
            ngDialog.openConfirm().then(function() {
                $http.post($stateParams.tenantid+"/hrms/master/gradeadmin/delete",gradeMaster.gradeId)
                .success(function(response) {
                   if(response.success == true){
                       logger.logSuccess("Deleted Succesfully!");
                       $scope.getList();
                   }
                }).error(function(result) {
                    logger.logError("Error Please Try Again");
                });
            });
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
        
        $rootScope.uploadGrade = function() {
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
                        url : $stateParams.tenantid+"/hrms/master/gradeadmin/uploadfile",
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
                                logger.logError("Fail to Upload");
                            }

                        }

                    });
                }

            }
        }
        
        $scope.callDialog = function($scope, gradeId, $http, ngDialog, logger,$injector, sharedProperties, toaster,$rootScope){
            ngDialog.open({
                scope: $scope,
                template: $stateParams.tenantid+'/views/hrms/master/gradeadmin/gradeAdminAdd',
                controller: $controller('gradeAdminAddCtrl', {
                    $scope: $scope,
                   gradeId: gradeId,
                    $http:$http,
                    ngDialog:ngDialog,
                    logger:logger,
                    $injector:$injector, 
                    sharedProperties:sharedProperties, 
                    toaster:toaster,
                    $rootScope:$rootScope
                }),
                className: 'ngdialog-theme-plain',
                showClose: false,
                closeByDocument: false,
                closeByEscape: false,
                preCloseCallback : $scope.getList
            });
        }
    });
app.controller('gradeAdminAddCtrl', function($scope,$stateParams,$rootScope, $http, $location, logger, utilsService, $state, sharedProperties, $window,validationService,toaster) {

        $scope.gradeMaster = {
            gradeId : '',
            gradeName : '',
            description : '',
            status : true,
            hospitalName : '',
            companyId : ''
            
        };
        
        $scope.companyList=[];
        $scope.getCompanyList=function(){
            $http.get('$stateParams.tenantid+/hrms/master/branchadmin/companyList').success(function(datas) {
              //  alert(JSON.stringify(datas));
                $scope.companyList = datas.companyList;
            }).error(function(data) {

            });
         
        }
        $scope.getCompanyList();
        
        
        
        $scope.isEdit = false;
        $scope.cancel = function() {
        	$state.go("app.truck.general.grade.gradelist",{tenantid:$stateParams.tenantid});
        };
        var gardeId=$location.search().gradeId;
        if(gardeId != 0 && gardeId !=undefined){
            $scope.isEdit = true;
            $http.post($stateParams.tenantid+"/hrms/master/gradeadmin/edit",gardeId)
            .success(function(response) {
               if(response.success == true){
                   $scope.gradeMaster = response.grade;
               }
               console.log(response);
            });
        }
        $scope.submit = function(gradeMaster,gradeMasterForm) {
           
            sharedProperties.clearObject();
                if (new validationService().checkFormValidity(gradeMasterForm)) {
                console.log($scope.gradeMaster);
                         $http.post($stateParams.tenantid+"/hrms/master/gradeadmin/save",$scope.gradeMaster)
                .success(function(response) {
                   if(response == true){
                       logger.logSuccess("Saved Succesfully!");
                       $scope.cancel();
                   }else{
                       logger.logError("Grade Already Exists!");
                   }
                });
            }else{
                toaster.pop('error', "Please fill the required fields", 
                        logger.getErrorHtmlNew(gradeMasterForm.$validationSummary), 555000, 'trustedHtml');
            }
        };
        $scope.update = function(gradeMaster,gradeMasterForm) {
            sharedProperties.clearObject();
            if (new validationService().checkFormValidity(gradeMasterForm)) {
                $http.post($stateParams.tenantid+"/hrms/master/gradeadmin/update",$scope.gradeMaster)
                .success(function(response) {
                   if(response == true){
                       logger.logSuccess("Updated Succesfully!");
                       $scope.cancel();
                   }else{
                       logger.logError("Grade Already Exists!");
                   }
                });
            }else{
                toaster.pop('error', "Please fill the required fields", 
                        logger.getErrorHtmlNew(gradeMasterForm.$validationSummary), 555000, 'trustedHtml');
            }
        };
        $scope.deleteSelected = function(){
        }
        $scope.reset = function(gradeMasterForm) {
            if($scope.isEdit == true){
             var gradeId = $scope.gradeMaster.gradeId;
             $scope.gradeMaster.gradeId ='';
             $scope.gradeMaster.gradeName ='';
             $scope.gradeMaster.description ='';
             $scope.gradeMaster.status = false;
             $scope.gradeMaster.companyId='';
             $http.post($stateParams.tenantid+"/hrms/master/gradeadmin/edit",gradeId)
             .success(function(response) {
                $scope.gradeMaster = response.grade;
             });
                
                
            }
            else{
            $scope.gradeMaster.gradeId ='';
            $scope.gradeMaster.gradeName ='';
            $scope.gradeMaster.description ='';
            $scope.gradeMaster.status = false;
            $scope.gradeMaster.companyId='';
            }
            };
       
    });

