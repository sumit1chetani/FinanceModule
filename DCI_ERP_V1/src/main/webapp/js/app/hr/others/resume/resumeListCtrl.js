define([ 'hrms/hr/hr' ], function(module) {

    'use strict';

    module.registerController('resumeListCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {
        $scope.rowCollection = [];

        $scope.isUpload = true;
        $scope.isDelete = true;

        $scope.add = function() {
            $state.go("app.hrms.hr.others.resume.add");
        }
        $scope.getResumeList = function() {

            var url = 'hrms/hr/others/resume/list';
            $http.get(url).success(function(result) {
                $scope.rowCollection = result.resumeList;

            }).error(function(result) {
                logger.logError("Error Please Try Again");
            });

        }

        $scope.getResumeList();

        $scope.deleteRow = function(resumeId, index) {
            ngDialog.openConfirm().then(function() {
                if (resumeId==0) {
                    logger.logError("Error Please Try Again")
                } else {
            var myURL = 'hrms/hr/others/resume/delete';
            $http({
                method : 'post',
                url : myURL,
                data : resumeId,
            }).success(function(data) {
                if (data == true) {
                    var tableData = $scope.rowCollection;
                    $scope.rowCollection.splice(index, 1);
                    logger.logSuccess("Deleted successfully");
                    $state.reload();
                } else {
                    logger.logError("Error in delete!");
                }
            }).error(function(data) {
                logger.logSuccess("Error in Delete!");
            });
           }
         });
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

        $scope.downloadfile = function() {
            $("#tbPdfExport").bind('click', function() {
            });
            $('#tbPdfExport').simulateClick('click');
        }

    });

});
