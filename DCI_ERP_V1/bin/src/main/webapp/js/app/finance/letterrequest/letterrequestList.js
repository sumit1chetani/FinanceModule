
    'use strict';

    app.controller('letterrequestListCtrl', function( $stateParams ,$scope,$state,$http,ngDialog, logger,$location,$controller,$injector, sharedProperties, toaster,$rootScope,validationService) {
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages=0;
        $scope.isAdd=true;
        
        $scope.getList = function(){
                // $http.get("hrms/master/leaveTypeLimit/list").success(function(response) {
              	 $http.get($stateParams.tenantid+"/finance/letterRequest/letterReqList").success(function(response) {

                $scope.rowCollection = response.letterReqList;
            });
        };
        $scope.getList();
        
        $scope.add = function(){
            $state.go("app.hr.letterrequest.add",{tenantid:$stateParams.tenantid});

        };                                               
        
      //Edit functionality
        $scope.editRow = function(letterReqId) {
//            $state.go("app.hr.letterrequest.edit",{tenantid:$stateParams.tenantid});
            $location.url($stateParams.tenantid+'/hr/letterrequest/Edit?letterReqId=' + letterReqId);
            
        };
        $scope.viewRow = function(letterReqId) {
//          $state.go("app.hr.letterrequest.edit",{tenantid:$stateParams.tenantid});
          $location.url($stateParams.tenantid+'/hr/letterrequest/View?letterReqId=' + letterReqId);
          
      };
      $scope.Issue = function(letterReqId) {
//        $state.go("app.hr.letterrequest.edit",{tenantid:$stateParams.tenantid});
        $location.url($stateParams.tenantid+'/hr/letterrequest/Issue?letterReqId=' + letterReqId);
        
    };
        //Delete functionality
        $scope.deleteRow = function(collection) {
          ngDialog.openConfirm().then(function() {
               //  $http.post("hrms/master/leaveTypeLimit/delete",collection.feeId)
                  $http.post($stateParams.tenantid+"/finance/letterRequest/deleteLR",collection)

                .success(function(response) {
                   if(response == true){
                       logger.logSuccess("Deleted Succesfully!");
                       $scope.getList();
                   }else
                       logger.logError("You can't delete this record,Deletion Failed");
                }).error(function(result) {
                    logger.logError("Error Please Try Again");
                });
            });
        };
        
    });
    
    



    app.controller('letterrequestADDCtrl', function($scope, $state, $http, ngDialog, logger, $injector, $location,
    		sharedProperties, toaster, $rootScope, $timeout, validationService , $stateParams) {
    	 $scope.letterrequest = {
    			 letterReqId:'',
         		letterReqTypeId : '', 
         		letterReqTypeName : '',
         		address : '',
         		purpose : '',
         		issuedDate: ''
         };  
    	
    	 $scope.isEdit = false;
    	 $scope.letterReqTypeList = [];
    	
    	 
    	 
    	 
    	  $scope.save = function(letterReqTypeAddForm) {
              if (new validationService().checkFormValidity(letterReqTypeAddForm)) {
                    	 $http.post($stateParams.tenantid+"/finance/letterRequest/saveLR",$scope.letterrequest).success(function(response) {

                      if (response == true) {
                          logger.logSuccess("Saved Succesfully!");
                          ngDialog.close();
                          $state.go("app.hr.letterrequest.list");
                      } else {
                          logger.logError("Error in Save !");
                      }
                  });
              }else {
                  toaster.pop('error', "Please fill the required fields", 
                          logger.getErrorHtmlNew(letterreqTypeForm.$validationSummary), 555000, 'trustedHtml');
              }
          };

          var letterReqId = $location.search().letterReqId;
          
          if(letterReqId != undefined && letterReqId != null && letterReqId != ""){

              $scope.isEdit = true;
        	 $http.get($stateParams.tenantid+"/finance/letterRequest/editLR?letterReqId=" +letterReqId).success(function(response) {
        		 $scope.letterrequest = response;
        		 $scope.letterrequest.letterReqTypeId =response.letterReqTypeId.toString();
//        		 $scope.letterrequest.purpose = response.purpose;

        	 });
          
          }
          $scope.getletterReqTypeList = function(){
        		 $http.post($stateParams.tenantid+"/finance/letterRequest/getLetterReqTypeList").success(function(response) {
             		 $scope.letterReqTypeList = response;
             	 });
 
          }
          $scope.getletterReqTypeList();
          
          $scope.update = function(letterReqTypeAddForm) {
        	  $scope.letterrequest.letterReqId = $location.search().letterReqId;
              if (new validationService().checkFormValidity(letterReqTypeAddForm)) {
                    	 $http.post($stateParams.tenantid+"/finance/letterRequest/updateLR",$scope.letterrequest).success(function(response) {

                      if (response == true) {
                          logger.logSuccess("Saved Succesfully!");
                          ngDialog.close();
                          $state.go("app.hr.letterrequest.list");
                      } else {
                          logger.logError("Error in Update !");
                      }
                  });
              }else {
                  toaster.pop('error', "Please fill the required fields", 
                          logger.getErrorHtmlNew(letterreqTypeForm.$validationSummary), 555000, 'trustedHtml');
              }
          };
          $scope.cancel = function(){
              $state.go("app.hr.letterrequest.list",{tenantid:$stateParams.tenantid});

          } 
          $scope.Approve = function(){
        	  $scope.letterrequest.letterReqId = $location.search().letterReqId;
        	 	 $http.post($stateParams.tenantid+"/finance/letterRequest/approve",$scope.letterrequest).success(function(response) {
        	 		 if (response == true) {
                         logger.logSuccess("Saved Succesfully!");
                         $state.go("app.hr.letterrequest.list");

        	 		 }else{
                         logger.logError("Error in Approve !");

        	 		 }
        	 	 });
          }
          $scope.IssueVal = function(){
        	  $scope.letterrequest.letterReqId = $location.search().letterReqId;
        	 	 $http.post($stateParams.tenantid+"/finance/letterRequest/issueVal",$scope.letterrequest).success(function(response) {
        	 		 if (response == true) {
                         logger.logSuccess("Submitted Succesfully!");
                         $state.go("app.hr.letterrequest.list");

        	 		 }else{
                         logger.logError("Error in Approve !");

        	 		 }
        	 	 });
          }
          
          $scope.reset =  function(){
        	   var letterReqId = $location.search().letterReqId;
               
               if(letterReqId != undefined && letterReqId != null && letterReqId != ""){

                   $scope.isEdit = true;
             	 $http.get($stateParams.tenantid+"/finance/letterRequest/editLR?letterReqId=" +letterReqId).success(function(response) {
             		 $scope.letterrequest = response;
             		 $scope.letterrequest.letterReqTypeId =response.letterReqTypeId.toString();
//             		 $scope.letterrequest.purpose = response.purpose;

             	 });
               
               }else{
            		 $scope.letterrequest = {
                			 letterReqId:'',
                     		letterReqTypeId : '', 
                     		letterReqTypeName : '',
                     		address : '',
                     		purpose : '',
                     		issuedDate: ''
                     };  
               }
          }
    });
    
    