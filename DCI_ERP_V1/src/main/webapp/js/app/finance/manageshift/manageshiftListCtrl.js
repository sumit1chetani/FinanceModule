
'use strict';

app.controller('manageshiftListCtrl', function($scope,$state,$http,ngDialog, $stateParams , logger,$location,$controller,$injector, sharedProperties, toaster,$rootScope) {
    
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.isUpload = false;
        $scope.numPages=0;
        $scope.isDelete=true;
        
        $scope.add = function(){
            $state.go("app.hr.manageshift.add",{tenantid:$stateParams.tenantid});

        };
        
        $scope.getShiftList=function(){
            $http.get($stateParams.tenantid+"/app/hr/manageshift/list").success(function(response) {

                $scope.rowCollection = response.shiftMasterList;
            });
        }
        $scope.getShiftList();
        
       $scope.editRow = function(shiftId){
         //   $state.go('app.hr.manageshift.edit',{ shiftId:shiftId });
            $location.url($stateParams.tenantid+'/hr/manageshift/edit?shiftId=' + shiftId);


        }
        
  /*      $scope.editRow = function(manageshift) {

        	// $state.go('app.hr.leavedeclaration.add');
        	$state.go('app.hr.manageshift.edit', {
        		shiftId : manageshift.shiftId,

        	});
        	};*/
 
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
        
        $rootScope.uploadShift = function() {
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
                        url : "/hrms/master/shiftmaster/uploadfile",
                        data : frmData,
                        contentType : false,
                        processData : false,
                        success : function(result) {
                            console.log("result")
                            console.log(result)
                            if (result.success) {
                                logger.logSuccess("File Uploaded Successfully");
                                $scope.getShiftList();
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
        $scope.deleteRow = function(shiftId, index) {
            ngDialog.openConfirm().then(function() {
               // var myURL = 'hrms/master/shiftmaster/delete?shiftId';
                var myURL = $stateParams.tenantid
				+ '/app/hr/manageshift/delete?shiftId='
				+ shiftId;
                $http({
                    method : 'post',
                    url : myURL,
                    data : shiftId,
                }).success(function(data) {
                    if (data == true) {
                        logger.logSuccess("Deleted successfully");
                        $scope.getShiftList();
                    } else {
                        logger.logError("Error in deleting Shift Master!");
                    }
                }).error(function(data) {
                    logger.logError("Error in Delete!");
                });
            });

        };
        
    });
    