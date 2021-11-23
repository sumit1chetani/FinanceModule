'use strict';

app.controller('leaverequestCtrl', function($location ,$stateParams ,$scope,$state,$http,ngDialog,logger,$rootScope,$injector,sharedProperties, toaster,validationService,$controller) {
    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.isEdit = false;
    $scope.leaveRequestList=[];
    
    $scope.getLeaveRequestList=function(){
    	 $http.get($stateParams.tenantid+"/finance/leaverequest/list").success(function(response) {
   
            $scope.rowCollection=response.leaveRequestList ;
        });
    }
    $scope.getLeaveRequestList();
    
    $scope.add=function(){
        $scope.isEdit = false;
        $state.go("app.hr.leaverequest.add",{tenantid:$stateParams.tenantid});

        //$state.go('app.hrms.hr.leavereq.add');
    };
    
    $scope.editRow=function(leaveRequest){
      if(leaveRequest.status == 0 && leaveRequest.action == 0 && leaveRequest.finalEmpStatus == 0){
      //  $state.go('app.hrms.hr.leavereq.edit',{ requestId:leaveRequest.leaveRequestId });
     	$location.url($stateParams.tenantid+'/hr/leaverequest/edit?leaveRequestId='+ leaveRequest.leaveRequestId); 
      }else if(leaveRequest.status == 1){
              logger.logError("Cannot Edit this Approved Leave Request");
      }else if(leaveRequest.status == 2){
    	  logger.logError("Cannot Edit this Cancelled Leave Request");
        /*  if(leaveRequest.status == 2){
              logger.logError("Cannot Edit this Rejected Leave Request");
          } else{
              logger.logError("Cannot Edit this Cancelled Leave Request");
          }*/
      }
    };
    
    
    
    $scope.viewLeave=function(leaveRequest){
      
       	$location.url($stateParams.tenantid+'/hr/leaverequest/view?leaveRequestId='+ leaveRequest.leaveRequestId); 
    
       
      };
      
    
   /* $scope.editRow=function(leaveRequest){
        if(leaveRequest.alternateEmpStatus == 0 && leaveRequest.action == 0 && leaveRequest.finalEmpStatus == 0){
        //  $state.go('app.hrms.hr.leavereq.edit',{ requestId:leaveRequest.leaveRequestId });
       	$location.url($stateParams.tenantid+'/hr/leaverequest/edit?leaveRequestId='+ leaveRequest.leaveRequestId); 
        }else if(leaveRequest.alternateEmpStatus == 0 && leaveRequest.action ==1 && leaveRequest.finalEmpStatus == 1 || leaveRequest.alternateEmpStatus == 1 && leaveRequest.action ==1 && leaveRequest.finalEmpStatus == 1 || leaveRequest.alternateEmpStatus == 1 && leaveRequest.action ==0 && leaveRequest.finalEmpStatus == 0 
                || leaveRequest.alternateEmpStatus == 0 && leaveRequest.action == 1 && leaveRequest.finalEmpStatus == 0 || leaveRequest.alternateEmpStatus == 0 && leaveRequest.action == 0 && leaveRequest.finalEmpStatus == 1){
                logger.logError("Cannot Edit this Approved Leave Request");
        }else if(leaveRequest.alternateEmpStatus == 0 && leaveRequest.action ==2 && leaveRequest.finalEmpStatus == 2 || leaveRequest.alternateEmpStatus == 2 && leaveRequest.action ==2 && leaveRequest.finalEmpStatus == 2 || leaveRequest.alternateEmpStatus == 2 && leaveRequest.action ==0 && leaveRequest.finalEmpStatus == 0 
                || leaveRequest.alternateEmpStatus == 0 && leaveRequest.action == 2 && leaveRequest.finalEmpStatus == 2 || leaveRequest.alternateEmpStatus == 0 && leaveRequest.action == 2 && leaveRequest.finalEmpStatus == 0
                || leaveRequest.alternateEmpStatus == 2 && leaveRequest.action == 2 && leaveRequest.finalEmpStatus == 0 || leaveRequest.alternateEmpStatus == 1 && leaveRequest.action ==2 && leaveRequest.finalEmpStatus == 0 
                || leaveRequest.alternateEmpStatus == 0 && leaveRequest.action == 1 && leaveRequest.finalEmpStatus == 2 || leaveRequest.alternateEmpStatus == 1 && leaveRequest.action == 1 && leaveRequest.finalEmpStatus == 2){
            if(leaveRequest.cancelRequest==false){
                logger.logError("Cannot Edit this Rejected Leave Request");
            } else{
                logger.logError("Cannot Edit this Cancelled Leave Request");
            }
        }
      };*/
  /*  $scope.viewMLLeave=function(leaveRequest){
          $state.go('app.hrms.hr.leavereq.view',{ requestId:leaveRequest.leaveRequestId });
    };
    */
    $scope.cancel=function(){
        $state.go('app.hrms.hr.leavereq.list');
    };
    
    $scope.deleteRow=function(leaveRequest){
      ngDialog.openConfirm().then(function() {
          if(leaveRequest.alternateEmpStatus == 0 && leaveRequest.action == 0 && leaveRequest.finalEmpStatus == 0){
              //    var myURL = 'hrms/hr/leaverequest/delete?leaveRequestId';
                  var myURL = $stateParams.tenantid+'/finance/leaverequest/delete?leaveRequestId';
                  $http({
                      method : 'post',
                      url : myURL,
                      data : leaveRequest.leaveRequestId,
                  }).success(function(data) {
                      if (data == true) {
                          logger.logSuccess("Deleted successfully");
                          $scope.getLeaveRequestList();
                      } else {
                          logger.logError("Error in deleting Holiday Master!");
                      }
                  }).error(function(data) {
                      logger.logError("Error in Delete!");
                  });
              }else if(leaveRequest.alternateEmpStatus == 0 && leaveRequest.action ==1 && leaveRequest.finalEmpStatus == 1 || leaveRequest.alternateEmpStatus == 1 && leaveRequest.action ==1 && leaveRequest.finalEmpStatus == 1 || leaveRequest.alternateEmpStatus == 1 && leaveRequest.action ==0 && leaveRequest.finalEmpStatus == 0 || leaveRequest.alternateEmpStatus == 0 && leaveRequest.action == 1 && leaveRequest.finalEmpStatus == 0 || leaveRequest.alternateEmpStatus == 0 && leaveRequest.action == 0 && leaveRequest.finalEmpStatus == 1){
                      logger.logError("Cannot Delete this Approved Leave Request");
              }else if(leaveRequest.alternateEmpStatus == 0 && leaveRequest.action ==2 && leaveRequest.finalEmpStatus == 2 || leaveRequest.alternateEmpStatus == 2 && leaveRequest.action ==2 && leaveRequest.finalEmpStatus == 2 || leaveRequest.alternateEmpStatus == 2 && leaveRequest.action ==0 && leaveRequest.finalEmpStatus == 0 
                      || leaveRequest.alternateEmpStatus == 0 && leaveRequest.action == 2 && leaveRequest.finalEmpStatus == 2 || leaveRequest.alternateEmpStatus == 0 && leaveRequest.action == 2 && leaveRequest.finalEmpStatus == 0
                      || leaveRequest.alternateEmpStatus == 2 && leaveRequest.action == 2 && leaveRequest.finalEmpStatus == 0 || leaveRequest.alternateEmpStatus == 1 && leaveRequest.action ==2 && leaveRequest.finalEmpStatus == 0 
                      || leaveRequest.alternateEmpStatus == 0 && leaveRequest.action == 1 && leaveRequest.finalEmpStatus == 2 || leaveRequest.alternateEmpStatus == 1 && leaveRequest.action == 1 && leaveRequest.finalEmpStatus == 2){
                      if(leaveRequest.cancelRequest==false){
                          logger.logError("Cannot Delete this Rejected Leave Request");
                      } else{
                          logger.logError("Cannot Delete this Cancelled Leave Request");
                      }
              }
        });
    }
    
    var d=new Date();
    var year=d.getFullYear();
    var month=d.getMonth()+1;
    if (month<10){
    month="0" + month;
    };
    var day=d.getDate();
    var todaydate=day + "/" + month + "/" + year;
    
    $scope.cancelRequest= function(leaveObj){
            $rootScope.leaveObject=leaveObj;
            ngDialog.close();
            ngDialog.open({
                template : 'fileModal',
                scope :$scope
            });
    }
    
    $scope.yesCancel=function(){
      var frmDate = $rootScope.leaveObject.fromDate;
      frmDate = frmDate.split("/");
      frmDate = new Date(frmDate[2], frmDate[1], frmDate[0]);
      
      var today = todaydate;
      today = today.split("/");
      today = new Date(today[2], today[1], today[0]);
      $rootScope.leaveObject.wholeLeave=true;
//      if(frmDate > today){
          if($rootScope.leaveObject.cancelRequest==false){
            //  $http.post("hrms/hr/leaverequest/cancelRequest",$rootScope.leaveObject).success(function(response){
            	  $http.post($stateParams.tenantid+"/finance/leaverequest/cancelRequest",$rootScope.leaveObject).success(function(response) {
                  if(response.success==true){
                      logger.logSuccess("You've Successfully Requested to Cancel this Leave Request");
                      $scope.getLeaveRequestList();
                      ngDialog.close();
                  }
              });
          }else{
              logger.logError("Already you've Requested to Cancel this Leave Request");
              ngDialog.close();
          }
//      }else{
//          logger.logError("Can't give Cancel Request After Leave Dates Over");  
////          logger.logError("You can cancel the Leave request before one day of your leave dates");
//          ngDialog.close();
//      }
      $rootScope.leaveObject='';
    }
    
    $scope.noCancel=function(){
        ngDialog.close();
    }
    
    $scope.cancelLeave=function(leaveObj){
        var frmDate = leaveObj.fromDate;
        frmDate = frmDate.split("/");
        frmDate = new Date(frmDate[2], frmDate[1], frmDate[0]);
        
        var today = todaydate;
        today = today.split("/");
        today = new Date(today[2], today[1], today[0]);
//        if(frmDate > today){
            if(leaveObj.cancelRequest==false){
                if(leaveObj.noOfDays>1){
                    $scope.callDialog($scope, leaveObj.leaveRequestId, $http, ngDialog, logger,$injector, sharedProperties, toaster,$rootScope,leaveObj);                    
                }else{
                    $scope.cancelRequest(leaveObj);
                }
            }else{
                logger.logError("Already you've Requested to Cancel this Leave Request");
                ngDialog.close();
            }
//        }else{
//            logger.logError("Can't give Cancel Request After Leave Dates Over");  
//            ngDialog.close();
//        }
    }
    
    $scope.callDialog = function($scope, leaveRequestId, $http, ngDialog, logger,$injector, sharedProperties, toaster,$rootScope,leaveObj){
        ngDialog.open({
            scope: $scope,
            template: 'views/finance/leaverequest/leaveCancelPOP.jsp',
            controller: $controller('leaveCancelCtrl', {
                $scope: $scope,
                leaveRequestId: leaveRequestId,
                $http:$http,
                ngDialog:ngDialog,
                logger:logger,
                $injector:$injector, 
                sharedProperties:sharedProperties, 
                toaster:toaster,
                $rootScope:$rootScope,
                leaveObj:leaveObj
            }),
            className: 'ngdialog-theme-plain',
            showClose: false,
            closeByDocument: false,
            closeByEscape: false,
            preCloseCallback : $scope.getLeaveRequestList
        });
    }

    $scope.helpVideo = function() {
        ngDialog.close();
        ngDialog.open({
            template : 'leaveRequestHelpModal',
            scope : $scope,
            controller : $controller('leaveRequestHelpCtrl', {
                $scope : $scope
            })
        });
    };
    
    app.controller('leaveRequestHelpCtrl', function($scope, $http, ngDialog, logger, $location,$stateParams) {
        $scope.closeHelpDialog = function() {
            ngDialog.close();
        };
    });
    
    
  });

app.controller('leaveCancelCtrl', function($stateParams ,$scope, $http, ngDialog,logger,leaveRequestId,$injector, sharedProperties, toaster,$rootScope,validationService,leaveObj) {
    
    var frmDate=leaveObj.fromDate;
    frmDate = frmDate.split("/");
    frmDate = new Date(frmDate[2], (frmDate[1]-1), frmDate[0]);
    var d=new Date(frmDate);
    d.setDate(d.getDate() +1);
    var year=d.getFullYear();
    var month=d.getMonth()+1;
    if (month<10){
    month="0" + month;
    };
    var day=d.getDate();
    if (day<10){
    day="0" + day;
    };
    var canFromDate=day + "/" + month + "/" + year;
    
    $scope.leaveCancel={
            wholeLeave:false,
            fromDate:leaveObj.fromDate,
            toDate:leaveObj.toDate,
            cancelDays:'',
    }
    
    $scope.cancel=function(){
        ngDialog.close();
    }
    
    $scope.cancellationLeave=function(cancelLeaveForm){
            sharedProperties.clearObject();
            if (new validationService().checkFormValidity(cancelLeaveForm)) {
                var fromdate = leaveObj.fromDate;
                var changeFromDate = $scope.leaveCancel.fromDate;
                var changeToDate = $scope.leaveCancel.toDate;
                var todate = leaveObj.toDate;
                todate = todate.split("/");
                todate = new Date(todate[2], todate[1], todate[0]);
                fromdate = fromdate.split("/");
                fromdate = new Date(fromdate[2], fromdate[1], fromdate[0]);
                changeFromDate = changeFromDate.split("/");
                changeFromDate = new Date(changeFromDate[2], changeFromDate[1], changeFromDate[0]);
                changeToDate = changeToDate.split("/");
                changeToDate = new Date(changeToDate[2], changeToDate[1], changeToDate[0]);
                
                var cancelObj={
                        wholeLeave:$scope.leaveCancel.wholeLeave,
                        cancelFromDate:$scope.leaveCancel.fromDate,
                        cancelToDate:$scope.leaveCancel.toDate,
                        cancelDays:$scope.leaveCancel.cancelDays,
                        noOfDays:leaveObj.noOfDays-$scope.leaveCancel.cancelDays,
                        fromDate:leaveObj.fromDate,
                        toDate:leaveObj.toDate,
                        mdUrl:'',
                        leaveType:leaveObj.leaveType,
                        leaveRequestId:leaveObj.leaveRequestId,
                }
                    if(changeFromDate.valueOf() == fromdate.valueOf() && changeToDate < todate){
                        cancelObj.mdUrl='B';
                     //   $http.post("hrms/hr/leaverequest/cancelRequest",cancelObj).success(function(response){
                        	 $http.post($stateParams.tenantid+"/finance/leaverequest/cancelRequest",cancelObj).success(function(response) {
                            if(response.success==true){
                                logger.logSuccess("You've Successfully Requested to Cancel this Leave Request");
                                ngDialog.close();
                            }
                        }); 
                    }else if(changeFromDate > fromdate && changeToDate.valueOf() == todate.valueOf()){
                        cancelObj.mdUrl='E';
                     //   $http.post("hrms/hr/leaverequest/cancelRequest",cancelObj).success(function(response){
                       	 $http.post($stateParams.tenantid+"/finance/leaverequest/cancelRequest",cancelObj).success(function(response) {

                            if(response.success==true){
                                logger.logSuccess("You've Successfully Requested to Cancel this Leave Request");
                                ngDialog.close();
                            }
                        }); 
                    }else if(changeFromDate.valueOf() == fromdate.valueOf() && changeToDate.valueOf() == todate.valueOf()){
                        cancelObj.wholeLeave=true;
                      //  $http.post("hrms/hr/leaverequest/cancelRequest",cancelObj).success(function(response){
                   	 $http.post($stateParams.tenantid+"/finance/leaverequest/cancelRequest",cancelObj).success(function(response) {

                            if(response.success==true){
                                logger.logSuccess("You've Successfully Requested to Cancel this Leave Request");
                                ngDialog.close();
                            }
                        }); 
                    }else{
                        cancelObj.mdUrl='M';
                   	 $http.post($stateParams.tenantid+"/finance/leaverequest/cancelRequest",cancelObj).success(function(response) {

                      //  $http.post("hrms/hr/leaverequest/cancelRequest",cancelObj).success(function(response){
                            if(response.success==true){
                                logger.logSuccess("You've Successfully Requested to Cancel this Leave Request");
                                ngDialog.close();
                            }
                        }); 
                    }
                
            }else{
                toaster.pop('error', "Please fill the required fields", 
                        logger.getErrorHtmlNew(cancelLeaveForm.$validationSummary), 5000, 'trustedHtml');
            }
        
    }
    
    
    $scope.$watchCollection('[ leaveCancel.fromDate,leaveCancel.toDate]', function(newValues){
        if(newValues!=""||newValues!=null){
            var fromdate = leaveObj.fromDate;
            var changeFromDate = $scope.leaveCancel.fromDate;
            var changeToDate = $scope.leaveCancel.toDate;
            var todate = leaveObj.toDate;
            todate = todate.split("/");
            todate = new Date(todate[2], todate[1], todate[0]);
            fromdate = fromdate.split("/");
            fromdate = new Date(fromdate[2], fromdate[1], fromdate[0]);
            changeFromDate = changeFromDate.split("/");
            changeFromDate = new Date(changeFromDate[2], changeFromDate[1], changeFromDate[0]);
            changeToDate = changeToDate.split("/");
            changeToDate = new Date(changeToDate[2], changeToDate[1], changeToDate[0]);
            
            if(changeFromDate < fromdate || changeToDate > todate){
                logger.logError("Can't give Leave Cancel Request for out of Leave Dates");
                $scope.leaveCancel.fromDate=leaveObj.fromDate;
                $scope.leaveCancel.toDate=leaveObj.toDate;
            }else if(changeFromDate > changeToDate){
                logger.logError("Cancel From Date is greater than Cancel To Date");
                $scope.leaveCancel.fromDate=leaveObj.fromDate;
                $scope.leaveCancel.toDate=leaveObj.toDate;
            }else{
                var millisecondsPerDay = 1000 * 60 * 60 * 24;
                  var millisBetween = changeToDate.getTime() - changeFromDate.getTime();
                  var days = Math.round(millisBetween / millisecondsPerDay);
                  $scope.leaveCancel.cancelDays=days+1;
                var dateBean={
                        fromDate : $scope.leaveCancel.fromDate,
                        toDate : $scope.leaveCancel.toDate,
                        noOfDays : $scope.leaveCancel.cancelDays,
                        leaveType : leaveObj.leaveType
                }
              //  $http.post('hrms/hr/leaverequest/leaveExclude',dateBean).success(function(response){
               	 $http.post($stateParams.tenantid+"/finance/leaverequest/leaveExclude",dateBean).success(function(response) {

                    if(response.success==true){
                        $scope.leaveCancel.cancelDays=response.leaveObj.leaveDays;
                    }else{
                        logger.logError(response.message);
                        $scope.leaveCancel.toDate='';
                        $scope.leaveCancel.cancelDays='';
                    }
                });
            }
        }
    });
    
    });
