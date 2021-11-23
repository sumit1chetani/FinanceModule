define([ 'hrms/hr/hr' ], function(module) {

    'use strict';

    module.registerController('resumeAddCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService) {
        $scope.rowCollection = [];
        $scope.imgfile = [];
        $scope.cancel = function() {
            $state.go('app.hrms.hr.others.resume.list');
        };

        $rootScope.uploadFile = function(element) {
            $scope.imgfile = element.files[0];
        }

        $scope.resume = {
            name : '',
            email : '',
            skillset : '',
            yrexp : '',
            uploadPhoto : ''
        }

        $scope.reset = function() {
            $scope.resume = {
                name : '',
                email : '',
                skillset : '',
                yrexp : '',
                uploadPhoto : ''
            }
        }

        $scope.fileName = "/pictures/no-image-icon.jpg";
        $scope.imgFilePath = "";
        $rootScope.uploadProfile = function() {
            var imgfile = $scope.imgfile;
            var fileExtension = imgfile.name;
            var frmData = new FormData();
            frmData.append("file", imgfile);
            frmData.append("fileName", $scope.resume.name);
            $scope.imgfile = frmData;

            $.ajax({
                type : "POST",
                url : "hrms/hr/others/resume/uploadfile",
                data : frmData,
                contentType : false,
                processData : false,
                success : function(result) {
                    // alert(JSON.stringify(result));
                    $scope.imgFilePath = result.imgPath + "?";
                    $scope.resume.uploadPhoto = result.imgPath;
                    if (result.success) {
                        logger.logSuccess("File Uploaded Successfully");
                    } else {
                        logger.logError("Fail to Upload");
                    }
                }
            });
        };

        // Save functionality
        $scope.save = function() {

            debugger;
            if (new validationService().checkFormValidity($scope.resumeForm)) {
                var flag = true;
                flag = $scope.validateEmail($scope.resume.email);
                if (flag == false) {
                    logger.logError("Please Enter Valid Email Address");
                }
                if ($scope.resume.uploadPhoto == "") {
                    logger.logError("Please Upload Your Document");
                } else if (flag == true && $scope.resume.uploadPhoto != "") {

                    $http.post("hrms/hr/others/resume/save", $scope.resume).success(function(response) {
                        if (response.success) {
                            logger.logSuccess("Saved Successfully!");
                            $state.go("app.hrms.hr.others.resume.list");
                        } else {
                            logger.logError(response.errors[0]);
                        }
                    });
                }
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.resumeForm.$validationSummary), 3000, 'trustedHtml');
            }
        };

        $scope.validateEmail = function(email) {
            var reg = /^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/
            if (reg.test(email)) {
                return true;
            } else {
                return false;
            }
        }

        $scope.checkYrExp = function(value) {
            var regex = /^\d{1,20}\.?\d{0,1}$/;
            var isValid = false;
            isValid = regex.test(value);
            if (value == "") {
            }
            if (isValid == true) {
                $scope.resume.yrexp = value;
            } else if (isValid == false) {
                $scope.resume.yrexp = value.slice(0, -1);
            }
        }

    });

});
