//define([ 'hrms/hr/hr' ], function(module) {

    'use strict';

	app.controller('attendanceImportCtrl', function($scope, $rootScope, $http, $location, logger,
    		utilsService, ngDialog, $state,sharedProperties,$window, $controller, $injector, toaster , $stateParams) {


        $scope.attendenceImportObj = {
            attendancefor : '',
        };

        $rootScope.uploadFile = function(element) {
            $scope.excelfile = element.files[0];
        }

        $rootScope.uploadAttendanceFile = function() {
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
                        url : "hrms/hr/attendance/uploadfile",
                        data : frmData,
                        contentType : false,
                        processData : false,
                        success : function(result) {
                            if (result.success) {
                                logger.logSuccess("File Uploaded Successfully");
                            } else {
                                logger.logError("Fail to Upload");
                            }

                        }

                    });
                }

            }
        }

        $scope.downloadFile = function() {
            $("#sPdfExport").bind('click', function() {

            });
            $('#sPdfExport').simulateClick('click');
        };

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

        $scope.exit = function() {
            $state.go('app.truck.general.designation',{tenantid:$stateParams.tenantid});
        };

    });

//});