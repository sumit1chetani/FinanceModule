
'use strict';

app.controller('manageshiftschemeListCtrl', function($scope,$state,$http,ngDialog,$stateParams, logger,$location,$controller,$injector, sharedProperties, toaster,$rootScope) {
    
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages=0;
        $scope.isDelete=true;
  
        $scope.add = function(){
            $state.go("app.hr.manageshiftscheme.add",{tenantid:$stateParams.tenantid});

        };
        
        $scope.getList=function(){
                $http.get($stateParams.tenantid+"/app/hr/shiftschememaster/list").success(function(response) {

                $scope.rowCollection = response.shiftSchemeMasterList;
                console.log("row collection list");
                console.log($scope.rowCollection);
            });
        }
        
        $scope.getList();
        
    /*    $scope.editRow = function(schemeName){
            $state.go('app.hrms.master.shiftschememaster.edit',{ schemeName:schemeName });
        }
        */
        
		$scope.editRow = function(schemeName) {
		/*	$location.path($stateParams.tenantid
					+ "/hr/manageshiftscheme/edit"+ schemeName);*/
            $location.url($stateParams.tenantid+'/hr/manageshiftscheme/edit?schemeName=' + schemeName);


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
        
        $rootScope.uploadShiftScheme = function() {
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
                        url : "/hrms/master/shiftschememaster/uploadfile",
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
        /**
         * Delete Row
         */
        $scope.deleteRow = function(schemeId,schemeName,index) {
            var resultbean={
                    schemeId:schemeId,
                    schemeName:schemeName
            }
            console.log("result bean");
            console.log(resultbean);
            ngDialog.openConfirm().then(function() {
                //var myURL = 'hrms/master/shiftschememaster/delete';
                var myURL = $stateParams.tenantid
				+ '/app/hr/shiftschememaster/delete';
		
                $http({
                    method : 'post',
                    url : myURL,
                    data : resultbean,
                }).success(function(data) {
                    if (data == true) {
                        logger.logSuccess("Deleted successfully");
                        $scope.getList();
                       
                    } else {
                        logger.logError("Error in deleting Shift Scheme Master!");
                    }
                }).error(function(data) {
                    logger.logError("Error in Delete!");
                });
            });

        };
    
    });
    