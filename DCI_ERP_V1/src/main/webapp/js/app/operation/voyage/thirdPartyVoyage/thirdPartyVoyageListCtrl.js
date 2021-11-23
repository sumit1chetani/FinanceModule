'use strict';
app.factory('THIRDPARTYVOYAGE',function($http,$q,logger,$stateParams){
    var THIRDPARTYVOYAGE=new Object();
    THIRDPARTYVOYAGE.getThirdPartyVoyageList=function(obj){
        var voyageData=$q.defer();
        var List;
        $http.post($stateParams.tenantid+'/voyage/thirdPartyVoyage/getThirdPartyVoyageList',obj).success(function(thirdPartyVoyageResultBean){
            if(thirdPartyVoyageResultBean.success=true){
                voyageData.resolve(thirdPartyVoyageResultBean);
            }else{
                logger.logError("Error Please Try Again");
            }
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
        return voyageData.promise;
    }
    THIRDPARTYVOYAGE.getVoyageList = function(obj){
        var serviceData=$q.defer();
        $http.post($stateParams.tenantid+'/voyage/thirdPartyVoyage/getVoyageList',obj).success(function(thirdPartyVoyageResultBean){
            if (thirdPartyVoyageResultBean.success = true) {
                serviceData.resolve(thirdPartyVoyageResultBean);
            } else {
                logger.logError("Error Please Try Again");
            } 
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
        return serviceData.promise;
    }
    THIRDPARTYVOYAGE.getServiceList = function(thirdPartyHeader){
        var serviceData=$q.defer();
        $http.post($stateParams.tenantid+'/voyage/thirdPartyVoyage/getServiceList',thirdPartyHeader).success(function(ThirdPartyVoyageResultBean){
            if (ThirdPartyVoyageResultBean.success = true) {
                serviceData.resolve(ThirdPartyVoyageResultBean);
            } else {
                logger.logError("Error Please Try Again");
            } 
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
        return serviceData.promise;
    }
    THIRDPARTYVOYAGE.getThirdPartyHeaderList = function(formCode,voyageId) {
        var vesselData = $q.defer();
        var url=$stateParams.tenantid+'/voyage/thirdPartyVoyage/addThirdPartyHeaderList?formCode='+formCode+'&voyageId='+voyageId;
        $http.post(url).success(function(ThirdPartyVoyageResultBean) {
            if (ThirdPartyVoyageResultBean.success = true) {
                vesselData.resolve(ThirdPartyVoyageResultBean);
            } else {
                logger.logError("Error Please Try Again");
            }
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
        return vesselData.promise;
    }
    return THIRDPARTYVOYAGE;
    
})
app.controller('thirdPartyVoyageCtrl', function($scope, $rootScope,$stateParams,$timeout, $http, logger, $log, ngDialog, $modal, $location, $filter, utilsService,THIRDPARTYVOYAGE,$state,sharedProperties) {
    $scope.voyageList = [];
    $scope.reasonList=[{id:'Dry Dock',text:'Dry Dock'},
                       {id:'OFF Hire',text:'OFF Hire'},
                       {id:'Repair',text:'Repair'},
                       {id:'Voyage Cut',text:'Voyage Cut'},
                       {id:'Bunker Supply',text:'Bunker Supply'}]
    $scope.thirdPartyVoyageList = [];
    $scope.searchPlanVoyageList =[];
    $scope.portList = [];
    $scope.rowCollection = [];
    $scope.voyageHeader={
            voyageId:'',
            formCode: '',
            vesselCode:'',
            activityCode:'',
            voyageIdnew:[],
            fromDate:'',
            toDate:''
    };
    
     /// F6068 F0174

    var formCode = 'F0174';
     $scope.voyageHeader.formCode = formCode;
    
    $scope.getThirdPartyVoyageList=function(){
     $scope.tempList=THIRDPARTYVOYAGE.getThirdPartyVoyageList($scope.voyageHeader);
     debugger;
     $scope.tempList.then(function(data){
       //forloop date time split
         for(var i =0;i<data.thirdPartyVoyageList.length;i++){
             var dateSplitted = data.thirdPartyVoyageList[i].schStartDate.split(" ");
             var dateSplitted1 = dateSplitted[0].split("/").reverse().join("/");
             var  ms = Date.parse(dateSplitted1+ " " +dateSplitted[1]);
             console.log(dateSplitted +" : " +ms)
             data.thirdPartyVoyageList[i].vesselName1=ms;
             
         }
         //forloop date time split
         for(var i =0;i<data.thirdPartyVoyageList.length;i++){
             var dateSplitted = data.thirdPartyVoyageList[i].schEndDate.split(" ");
             var dateSplitted1 = dateSplitted[0].split("/").reverse().join("/");
             var  ms = Date.parse(dateSplitted1+ " " +dateSplitted[1]);
             console.log(dateSplitted +" : " +ms)
             data.thirdPartyVoyageList[i].voyageId1=ms;
             
         }
         
         
        
         
         $scope.thirdPartyVoyageList=data.thirdPartyVoyageList;
       //  $scope.voyageList=data.voyageList;
         $scope.vesselList=data.vesselList;
         $scope.activityTypes=data.activityTypes;
         $scope.rowCollection = [];
         $scope.rowCollection = $scope.rowCollection.concat($scope.thirdPartyVoyageList);
     })
    }
    $scope.getThirdPartyVoyageList();
    
    $scope.add =function(){
        $state.go("app.operation.voyage.thirdPartyVoyage-add");
       
    }
    $scope.editVoyage = function(objVoyage){
        console.log(objVoyage);
        $location.url($stateParams.tenantid+'/operation/thirdPartyVoyage/add?vesselCode='+objVoyage.vesselCode+'&voyageId='+objVoyage.voyageId+'&sectorId='+objVoyage.sectorId+'&vesselName='+objVoyage.vesselName);
    }
    $scope.viewVoyage = function(objVoyage) {
        $location.url($stateParams.tenantid+'/operation/voyage/thirdPartyVoyage/view?vesselCode=' + objVoyage.vesselCode + '&voyageId=' + objVoyage.voyageId + '&sectorId=' + objVoyage.sectorId+'&vesselName='+objVoyage.vesselName+'&focusFlag=V');
    }
    $scope.copyVoyage = function(){
        $scope.voyageHeader.flag = 'COPY';
        if($scope.voyageHeader.voyageId != ''){
        $location.url($stateParams.tenantid+'/operation/voyage/thirdPartyVoyage/add?voyageId='+$scope.voyageHeader.voyageId + '&flag='+$scope.voyageHeader.flag);
        }else{
            logger.logError('Please select voyage');
        }
    }
    $scope.deleteRow = function(voyageId, index) {
        ngDialog.openConfirm().then(function() {
            var myURL = $stateParams.tenantid+'/voyage/thirdPartyVoyage/deleteThirdPartyVoyage';
            $http({
                method : 'post',
                url : myURL,
                data : voyageId,
            }).success(function(data) {
                if (data) {
                    $scope.rowCollection.splice(index, 1);
                    logger.logSuccess("Third Party Voyage deleted Successfully.");
                } else {
                    logger.logError("Please try again later.");
                }
            }).error(function(data) {
                logger.logSuccess("Please try again later.");
            });
        }, function(reason) {
            console.log('Modal promise rejected. Reason: ', reason);
        });
    };
 
   $scope.searchThirtPartyVoyage =function(){
       $scope.getThirdPartyVoyageList();
   }
   $scope.serviceList=[];
//   $http.post($stateParams.tenantid+'/voyage/thirdPartyVoyage/getVoyageDtlList',$scope.voyageHeader).success(function(ThirdPartyVoyageResultBean){
//       $http.post($stateParams.tenantid+'/voyage/thirdPartyVoyage/getServiceList',$scope.voyageHeader).success(function(ThirdPartyVoyageResultBean){
//
//	   //   $http.post(url).success(function(ThirdPartyVoyageResultBean) {
//       if (ThirdPartyVoyageResultBean.success = true) {
//           vesselData.resolve(ThirdPartyVoyageResultBean);
//           $scope.serviceList = ThirdPartyVoyageResultBean.serviceList;
//       } else {
////           logger.logError("Error Please Try Again");
//       }
//   });

// $scope.handsonData.splice(0,$scope.handsonData.length);
// thirdPartyHandson.updateSettings({data:$scope.handsonData});
 $scope.tempList = THIRDPARTYVOYAGE.getServiceList($scope.voyageHeader);
 $scope.tempList.then(function(data){
     console.log(data);
     $scope.serviceList = data.serviceList;
     if( $location.search().sectorId != undefined){
         $scope.thirdPartyHeader.sectorId=$location.search().sectorId;
     }
     
 })

   $scope.$watch('voyageHeader.vesselCode',function(newValue,oldValue){
       $scope.voyageHeader.voyageId='';
       $scope.voyageHeader.activityCode='';
       $scope.voyageList=[];
       console.log($scope.planVoyageHeader)
       if($scope.voyageHeader.vesselCode != '' ){
           $scope.getVoyageList();
       }
   });
   
   
   
   $scope.$watch('voyageHeader.vesselCode',function(newValue,oldValue){
       $scope.voyageHeader.voyageId='';
       $scope.voyageHeader.activityCode='';
       $scope.voyageList=[];
       console.log($scope.planVoyageHeader)
       if($scope.voyageHeader.vesselCode != '' ){
           $scope.getVoyageList();
       }
   });
   $scope.getVoyageList = function(){
	   $("#voyageId").multiselect({
           maxHeight: 200,   
           includeSelectAllOption: true,
           disableIfEmpty: true,
           enableCaseInsensitiveFiltering: true,
           onDropdownHide: function (event) {
               
           }
         });
       
       $scope.tempList = THIRDPARTYVOYAGE.getVoyageList($scope.voyageHeader);
       $scope.tempList.then(function(data){
           console.log(data);
           $scope.voyageList = data.voyageList; 
           $timeout(function() {
               $('#voyageId').multiselect('deselectAll', false);
               $('#voyageId').multiselect('updateButtonText');
               $("#voyageId").multiselect('rebuild');
           
           }, 2, false);
           $("#multiselect-button").addClass("width_100 input-sm line-height-5");
           }).error(function(datas) {
       });
	   

   }
   

   
   //Excel Export	
 	 $scope.exportExcel = function(){
 		  var flag = false;
//   	  if($scope.blissuedreport.fromDate !='' && $scope.blissuedreport.fromDate !=null){
//   		  flag = true;
//   		  if($scope.blissuedreport.toDate !='' && $scope.blissuedreport.toDate !=null){
//   			  flag = false;
//   		  }else{
//   			  logger.logError("Please select To Date...!!!");
//   		  }
//   	  }
       	
//   	  if(flag == false){
 	   	 $http.post($stateParams.tenantid+'/voyage/thirdPartyVoyage/ExportExcel', $scope.voyageHeader).success(function(response) {

 	                if(response){
 	                    debugger;
 	                    $("#BLReport").bind('click', function() {
 	                    	
 	                    });
 	                    $('#BLReport').simulateClick('click');
 	                    logger.logSuccess("Exported successfully!");
 	                }else{
 	                    logger.logError("Failed to export");
 	                }
 	                
 	            }).error(function(response) {
 	                logger.logError("Error Please Try Again");
 	            });
//   	  }
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

 	
 	 $scope.getThirdPartyHeaderList = function() {
         $scope.tempList = THIRDPARTYVOYAGE.getThirdPartyHeaderList(formCode,"");
         $scope.tempList.then(function(data) {
             $('#sch_start_date').find(':text').attr('disabled','disabled')
             $('#sch_end_date').find(':text').attr('disabled','disabled')
             $scope.vesselList = data.vesselList;
             $scope.vesselList1 = data.vesselList1;
            /* $scope.speed=data.vesselList[0].speed;
             console.log($scope.speed)*/
             $scope.activityTypes = data.activityTypes;
             $scope.mloShortNameList=data.mloShortNameList;
             $scope.thirdPartyAddHandson();
             if( $location.search().vesselCode != undefined){
                 $scope.thirdPartyHeader.vesselCode=$location.search().vesselCode;
             }
             if( $location.search().vesselName != undefined){
                 $scope.thirdPartyHeader.vesselName=$location.search().vesselName;
             }
             if($location.search().flag == "COPY"){
                 $scope.thirdPartyHeader.flag=$location.search().flag;
             }
             
         })
         
         $http.get($stateParams.tenantid+'/app/usermaster/getCompanyList?formCode='+formCode).success(function(datas) {
             debugger;
             $scope.companyList = datas;
              }).error(function(datas) {
         });
     }
 	   $scope.getThirdPartyHeaderList();
 	  //copy voyage
 	 $scope.copyVoyage = function(){
         $scope.voyageHeader.flag = 'COPY';
         if($scope.voyageHeader.voyageIdnew != ''){
         $location.url($stateParams.tenantid+'/operation/thirdPartyVoyage/add?voyageId='+$scope.voyageHeader.voyageIdnew + '&flag='+$scope.voyageHeader.flag);
         }else{
             logger.logError('Please select voyage');
         }
     }
 	  
 	 
 	 // 
	   
  	//import Excel
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
  	        };
  	        
  	        $rootScope.closeFileDialog = function() {
  	            ngDialog.close();
  	        };
  	        
  	        $rootScope.uploadMaterialIssueRecord = function() {
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
  	                        url : $stateParams.tenantid+'/voyage/thirdPartyVoyage/uploadfile',
  	                        data : frmData,
  	                        contentType : false,
  	                        processData : false,
  	                        success : function(result) {
  	                            console.log("result");
  	                            console.log(result);
  	                            if (result.success) {
  	                                logger.logSuccess("File Uploaded Successfully");
  	                                $scope.getList();
  	                                $scope.getEmployeeList();  
  	                            } else {
  	                               var value = result.message;
//  	                                document.getElementById("id").innerHTML =  result.message;

//  	                                logger.logError("Fail to Upload\n" + result.message);
//  	                                alert("I will get back to you soon\nThanks and Regards\nSaurav Kumar");
//  	                                ngDialog.openConfirm({
//  	                                    
//  	                                    template : 'modalDialogId6',
//  	                                    className : 'ngdialog-theme-default'
//  	                                })
  	                               if(value == "true")
 	                            	   logger.logSuccess("Uploaded successfully!");

  	                               else
  	 	                              logger.logError(value);

//  	                                $scope.callDialog($scope,value, $http, $controller,ngDialog, logger,  sharedProperties,  $rootScope);
//  	                            
  	                            }

  	                        }

  	                    });
  	                }

  	            }
  	        };
  	        $scope.callDialog = function($scope, value, $http, $controller,ngDialog, logger,  sharedProperties, $rootScope) {
  	            ngDialog.open({
  	                scope : $scope,
  	                template : 'modalDialogId6',
  	                controller : $controller('ConsErrorCtrl', {
  	                    $scope : $scope,
  	                    value : value,
  	                    $http : $http,
  	                    ngDialog : ngDialog,
  	                    logger : logger,
  	                    sharedProperties : sharedProperties, 	                    
  	                    $rootScope : $rootScope
  	                }),
  	                className : 'ngdialog-theme-plain',
  	                showClose : false,
  	                closeByDocument : false,
  	                closeByEscape : false,
  	                preCloseCallback : $scope.getList
  	            });
  	        } 
 	 
    });





app.controller('ConsErrorCtrl', function($scope, $state, $http, $controller, logger, ngDialog, $location,  sharedProperties,  $rootScope,value) {
	alert(7);
    $scope.value = value;
//    alert($scope.value);
});

