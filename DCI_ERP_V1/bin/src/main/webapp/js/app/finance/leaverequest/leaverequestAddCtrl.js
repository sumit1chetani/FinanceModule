'use strict';
app.controller('leaverequestAddCtrl', function($stateParams ,$scope,$state,$http,logger,$injector, 
		sharedProperties, toaster,$rootScope,validationService,ngDialog,$window , $filter ,$location , $timeout ) {
    
    //leaveRadio:'',
   // holidayRadio:'',
    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.itemsByPage = 5;
    $scope.isAdd=true;
    $scope.isDelete=true;
    $scope.isUpload=true;
    
    var d=new Date();
    var year=d.getFullYear();
    var month=d.getMonth()+1;
    if (month<10){
    month="0" + month;
    };
    var day=d.getDate();
    if (day<10){
        day="0" + day;
    };
    var todaydate=day + "/" + month + "/" + year;
    
    var restrictedDate = todaydate;
    restrictedDate = restrictedDate.split("/");
    restrictedDate = new Date(restrictedDate[2], (restrictedDate[1]-1), restrictedDate[0]-15);
    var d1=new Date(restrictedDate);
    var year1=d1.getFullYear();
    var month1=d1.getMonth()+1;
    if (month1<10){
    month1="0" + month1;
    };
    var day1=d1.getDate();
    if (day1<10){
        day1="0" + day1;
    };
    var actualDate=day1 + "/" + month1 + "/" + year1;
    
    
    $('#clFromDate').datetimepicker({
        format : 'DD/MM/YYYY'
    })
    
    
    $('#clToDate').datetimepicker({
        format : 'DD/MM/YYYY'
    })
    
     var requestId = $location.search().leaveRequestId;
    
    $scope.leaveRequestObj={
            company : '',
            branch : '',
            grade : '',
            department : '',
            empName : '',
            leaveRadio:1,
            holidayRadio:false,
            fromDate:todaydate,
            toDate: '',
            empId : '',
            noOfDays:'',
            leaveReason:'',
            leaveAddress:'',
            leavePhone:'',
            leaveMobile:'',
            appliedOn: todaydate,
            halfFrom:'',
            halfTo:'',
            mdUrl:'',
            isHoliday:'',
            year:'',
            addressDuringLeave:'',
            alternativeEmp : '',
            dutyAgreed : '',
            clLeaveDays:'',
            cplLeaveDays:'',
            plLeaveDays:'',
            clFromDate:'',
            clToDate:'',
            cplFromDate:'',
            cplToDate:'',
            supportDoc:[],
            payType:'',
            isMl : 'NO',
            status :'',
            leaveRequestId :'',
            uploadRef  :'',
    };
    $scope.years = [];
    $scope.alternative = false;
    $scope.leaveRequestObj.isEdit= false;
    $scope.clLeave=false;
    $scope.cplLeave=false;
    $scope.addyear=function(){
       
        for (var i=2000; i<=2020; i++){
            $scope.years.push(i);}
    }
    $scope.addyear();
    
    
    
    
    $scope.OS= function() {

        var userAgent = $window.navigator.userAgent;

       var browsers = {chrome: /chrome/i, safari: /safari/i, firefox: /firefox/i, ie: /internet explorer/i};

       for(var key in browsers) {
           if (browsers[key].test(userAgent)) {
          
               return key;
           }
      };

      return 'unknown';
   }

$scope.OS();

$.fn.simulateClick1 = function() {
    return this.each(function() {
        if ('createEvent' in document) {
            var doc = this.ownerDocument, evt = doc.createEvent('MouseEvents');
            console.log(doc);
            evt.initMouseEvent('click', true, true, doc.defaultView, 1, 0, 0, 0, 0, false, false, false, false, 0, null);
            console.log(evt);
            this.dispatchEvent(evt);
        } else {
            this.click(); // IE
        }
    });
}
    
    //download by vicky
    $scope.fileDownload = function() {
       $("#fileExport").bind('click', function() {
	
        });
       $("#fileExport").simulateClick1('click');
    }

    
    
    
    
    
    

    
    //FILE UPLOAD
    
    
    
    
    
    $scope.upload = false;
    $scope.viewInvoiceHeader = {
            
            files : [] 
 
    };
    console.log($scope.viewInvoiceHeader);

    $rootScope.uploadFile = function(element) {
        $scope.excelfile = element.files[0];
    }
    $scope.files = [];
    
    $scope.viewInvoiceHeader.files = [];
    $scope.adduploadfiles = function() {
        // alert(1);
          var obj = []

          if ($scope.checkundefined($scope.excelfile)) {
              logger.logError("Please select the file");
          } else {
              obj = $filter('filter')($scope.viewInvoiceHeader.files, {
                  filename : $scope.excelfile.name
              }, true);
          }

          if (obj != undefined && obj.length > 0) {
              logger.logError($scope.excelfile.name + " same file already added");
          } else {
              $scope.files.push($scope.excelfile);
              $scope.viewInvoiceHeader.files.push({
                  filename : $scope.excelfile.name,
                  filePath : '',
                  viewInvoiceHeader : ''
              });

              $scope.excelfile
          }
          
          
          

      }
    
    
    
    $scope.deleteuploadfiles = function(filename) {
//      //alert(2);
      $scope.tempfiles = [];
      $scope.tempfilename = [];
      angular.forEach($scope.files, function(value, index) {
          if (filename != value.name) {
              $scope.tempfiles.push(value);
          }

      });

      angular.forEach($scope.viewInvoiceHeader.files, function(value, index) {
          if (filename != value.filename) {
              $scope.tempfilename.push(value);
          }

      });
      $scope.files = $scope.tempfiles;
      $scope.viewInvoiceHeader.files = $scope.tempfilename;

  }
    
    
    

    $scope.checkundefined = function(value) {
        var invalid = false;
        if (value == undefined || value == 'undefined' || value == null || value == 'null' || value == '') {
            invalid = true;
        }
        return invalid;

    }
    
  ///////////////////////////////////END/////////////////////////////////////////
    
    
    
    
    
    
    
    
    
    
    
    
    
   
    
   /* $scope.uploadMLDoc=function(){
        ngDialog.close();
        ngDialog.open({
            template : 'mlFile',
            scope :$scope
        });
    };
    
    $rootScope.uploadMLFile = function(element){
        $scope.excelfile = element.files[0];
    }
    
    $rootScope.closeML = function() {
        ngDialog.close();
    };
    
    $rootScope.uploadML =function(){
        ngDialog.close();
        var file=$scope.excelfile;
        var fileExtension= file.name;
        var fName=[];
        fName=fileExtension.split(".");
        var frmData=new FormData();
        frmData.append("file",file);
        frmData.append("fileName",fName[0]);
        $.ajax({
            type : "POST",
            url : "hrms/hr/leaverequest/uploadMLFile",
            data : frmData,
            contentType: false,
            processData: false,
            success : function(result) {
                $scope.leaveRequestObj.supportDoc = '';
                if(result.success){
                    $scope.leaveRequestObj.supportDoc=result.leaveObj.supportDoc;
                    logger.logSuccess("File Uploaded Successfully");
                }else{
                    logger.logError("Fail to Upload");    
                }
            }
        });
    }*/
//    $scope.leaveRequestObj.leaveRadio=false;
    $scope.reset=function(){
        $scope.leaveRequestObj.fromDate='';
        $scope.leaveRequestObj.toDate='';
        $scope.leaveRequestObj.noOfDays='';
        $scope.leaveRequestObj.leaveReason='';
        $scope.leaveRequestObj.leaveAddress='';
        $scope.leaveRequestObj.leavePhone='';
        $scope.leaveRequestObj.leaveMobile='';
        $scope.leaveRequestObj.halfFrom='';
        $scope.leaveRequestObj.halfTo='';
        $scope.leaveRequestObj.year='';
        $scope.leaveRequestObj.alternativeEmp='';
        $scope.leaveRequestObj.dutyAgreed='';
        $scope.leaveRequestObj.clFromDate='';
        $scope.leaveRequestObj.clToDate='';
        $scope.leaveRequestObj.clLeaveDays='';
        $scope.leaveRequestObj.cplFromDate='';
        $scope.leaveRequestObj.cplToDate='';
        $scope.leaveRequestObj.cplLeaveDays='';
        $scope.leaveRequestObj.plLeaveDays='';
    }
   
  $scope.leaveList=[];
  $scope.holidayList=[];
  $scope.clList=[];
  
//  $scope.getEmployeeList = [];
//  $http.get('hrms/hr/leaverequest/getEmployeeList').success(function(response) {
//      console.log(response); 
//      $scope.getEmployeeList = response.employeeList;
//  });
  
 $scope.daysofCL=0;
 $scope.daysofCPL=0;
 $scope.daysofEL=0;
 $scope.daysofML=0;
 
  
  $scope.employeeChange = function(){
              // $http.get("hrms/hr/leaverequest/getEmployeeDetails").success(function(response) {
        	   $http.get($stateParams.tenantid+'/finance/leaverequest/getEmployeeDetails').success(function(response) {
        	  $scope.daysofCL=response.employeeDetailsList.noOfDaysCL;
        	  $scope.daysofCPL=response.employeeDetailsList.noOfDaysCPL;
        	  $scope.daysofEL=response.employeeDetailsList.noOfDaysEL;
        	  $scope.daysofML=response.employeeDetailsList.noOfDaysML;
              $scope.leaveRequestObj.empName = response.employeeDetailsList.empName;
              $scope.leaveRequestObj.empId = response.employeeDetailsList.empId;
              $scope.leaveRequestObj.company = response.employeeDetailsList.company;
              $scope.leaveRequestObj.branch = response.employeeDetailsList.branch;
              $scope.leaveRequestObj.grade = response.employeeDetailsList.grade;
              $scope.leaveRequestObj.department = response.employeeDetailsList.department;
              if(response.employeeDetailsList.alternativeList.length!=0){
                  $scope.alternative = true;
                  $scope.alternativeList = response.employeeDetailsList.alternativeList;
              }else{
                  $scope.alternative = false;
              }
          });
       
  }
  
  $scope.employeeChange();
  
  
  
  
  $scope.mlCheck = function(){
      $scope.leaveRequestObj.isMl = 'NO';
  }
  
  
  
  
  
  
  
  
  
  
 
  $scope.holidayLeaveList=[];
    $scope.leavechange =function(){
        $scope.leaveRequestObj.fromDate='';
        $scope.leaveRequestObj.halfFrom='';
        $scope.leaveRequestObj.toDate='';
        $scope.leaveRequestObj.halfTo='';
        $scope.leaveRequestObj.noOfDays='';
        $scope.leaveRequestObj.clFromDate='';
        $scope.leaveRequestObj.clToDate='';
        $scope.leaveRequestObj.clLeaveDays='';
        $scope.leaveRequestObj.cplFromDate='';
        $scope.leaveRequestObj.cplToDate='';
        $scope.leaveRequestObj.cplLeaveDays='';
        $scope.leaveRequestObj.plLeaveDays='';
        $scope.leaveRequestObj.supportDoc=[];
        $scope.mlLeave=false;
        $scope.splLeave=false;
        $http.post($stateParams.tenantid+"/finance/leaverequest/leavelist",$scope.leaveRequestObj).success(function(datas) {

      //  $http.post("hrms/hr/leaverequest/leavelist",$scope.leaveRequestObj).success(function(datas) {
        	console.log(datas);
            $scope.leaveList=datas.leaveList;
            $scope.clList = datas.clList;
            $scope.leaveRequestObj.leaveRadio=1;
        });
    }
    $scope.leavechange();
    
    $scope.clCplChange=function(){
        $scope.leaveRequestObj.supportDoc=[];
        $scope.mlLeave=false;
        $scope.splLeave=false;
    }
    
    $scope.cancel=function(){
        $state.go("app.hr.leaverequest.list",{tenantid:$stateParams.tenantid});
    }
   
    $scope.holiday =function(){
        $scope.leaveRequestObj.fromDate='';
        $scope.leaveRequestObj.halfFrom='';
        $scope.leaveRequestObj.toDate='';
        $scope.leaveRequestObj.halfTo='';
        $scope.leaveRequestObj.noOfDays='';
        $scope.leaveRequestObj.clFromDate='';
        $scope.leaveRequestObj.clToDate='';
        $scope.leaveRequestObj.clLeaveDays='';
        $scope.leaveRequestObj.cplFromDate='';
        $scope.leaveRequestObj.cplToDate='';
        $scope.leaveRequestObj.cplLeaveDays='';
        $scope.leaveRequestObj.plLeaveDays='';
        console.log($scope.leaveRequestObj);
        $http.post($stateParams.tenantid+"/finance/leaverequest/holidaylist",$scope.leaveRequestObj).success(function(datas) {
       // $http.post('hrms/hr/leaverequest/holidaylist',$scope.leaveRequestObj).success(function(datas) {
        	console.log(datas);
            $scope.holidayList=datas.holidayList;
            $scope.holidayLeaveList=datas.leaveList;
            $scope.holidayBalance=parseInt(datas.leaveList[0].yearlyMaximum);
           });
       }
    
    $scope.holiday();
   $scope.modify=function(index,leaveList){
     
       for(var i=0;i<leaveList.length;i++){
           if(i  === index){
               leaveList[i].selctRow=true;
               if(leaveList[i].shortName=="PL"){
                   $scope.leave=true;
                   $scope.mlLeave=false;
                   $scope.splLeave =false;
                   $scope.leaveName=leaveList[i].shortName;
               }else if(leaveList[i].shortName=="ML"){
                   $scope.leave=false;
                   $scope.mlLeave=true;
                   $scope.splLeave =false;
                   $scope.leaveName=leaveList[i].shortName;
               }else if(leaveList[i].shortName=="SPL"){
                   $scope.leave=false;
                   $scope.mlLeave=false;
                   $scope.splLeave =true;
                   $scope.leaveName=leaveList[i].shortName;
               }else{
                   $scope.leave=false;
                   $scope.mlLeave=false;
                   $scope.splLeave =false;
                   $scope.leaveName=leaveList[i].shortName;
               }
           }else{
               leaveList[i].selctRow=false;
           }
       }
       $scope.leaveRequestObj.fromDate='';
       $scope.leaveRequestObj.toDate='';
       $scope.leaveRequestObj.noOfDays='';
       
   }
   

   $scope.holidaymodify=function(index,holidayList){
       
//       for(var i=0;i<holidayList.length;i++){
//           if(i  === index){
//               holidayList[i].selctRow=true;
//           }else{
//               holidayList[i].selctRow=false;
//           }
//       }
       $scope.count = 0;
       for(var i=0;i<holidayList.length;i++){
           if(holidayList[i].select==true){
               $scope.count=$scope.count+1;
           }
       }
//       if($scope.count>0){
//    	   $scope.cplLeave=true;
//       }else{
//    	   $scope.cplLeave=false;
//    	   if($scope.plDays!=undefined && $scope.leaveRequestObj.cplFromDate!="" && $scope.leaveRequestObj.cplToDate!=""){
//               	$scope.leaveRequestObj.plLeaveDays=parseInt($scope.plDays);
//           	    $scope.leaveRequestObj.noOfDays=parseInt($scope.leaveRequestObj.clLeaveDays)+parseInt($scope.plDays);
//    	   }
//    	   $scope.leaveRequestObj.cplFromDate='';
//    	   $scope.leaveRequestObj.cplToDate='';
//    	   $scope.leaveRequestObj.cplLeaveDays='';
//       }
       
   }
   
   $scope.selectCpl=function(cplList){
	   for(var i=0;i<cplList.length;i++){
           if(cplList[i].select == true){
               $scope.cplLeave=true;
           }else{
        	   $scope.cplLeave=false;
        	   if($scope.plDays!=undefined && $scope.leaveRequestObj.cplFromDate!="" && $scope.leaveRequestObj.cplToDate!=""){
                   	$scope.leaveRequestObj.plLeaveDays=parseInt($scope.plDays);
               	    $scope.leaveRequestObj.noOfDays=parseInt($scope.leaveRequestObj.clLeaveDays)+parseInt($scope.plDays);
        	   }
        	   $scope.leaveRequestObj.cplFromDate='';
        	   $scope.leaveRequestObj.cplToDate='';
        	   $scope.leaveRequestObj.cplLeaveDays='';
           }
	   }
   }
   
   
   
   
   
   
   
   
   
   
   //UPLOAD

   
    $scope.upload = false;
   $scope.data = {
           files : [] 

   };

   $rootScope.uploadFile = function(element) {
  	 for(var i=0;i<element.files.length;i++){
       $scope.excelfile = element.files[i];
       $scope.adduploadfiles();
  	 }
   }
   $scope.files = [];
 
   $scope.adduploadfiles = function() {
      // alert(1);
       var obj = []

       if ($scope.checkundefined($scope.excelfile)) {
           logger.logError("Please select the file");
       } else {
           obj = $filter('filter')($scope.data.files, {
               filename : $scope.excelfile.name
           }, true);
       }

       if (obj != undefined && obj.length > 0) {
           logger.logError($scope.excelfile.name + " same file already added");
       } else {
           $scope.files.push($scope.excelfile);
           $scope.data.files.push({
               filename : $scope.excelfile.name,
               filepath : '',
               newHigherCourseData : ''
           });

           $scope.excelfile
       }
       
   }
   
   $scope.deleteuploadfiles = function(sNo) {
  	 
  	 $scope.leaveRequestObj.uploadDetail.splice(sNo, 1);
   }
   
   $scope.checkundefined = function(value) {
       var invalid = false;
       if (value == undefined || value == 'undefined' || value == null || value == 'null' || value == '') {
           invalid = true;
       }
       return invalid;

   }
   
  
   
   
   


  
    $rootScope.uploadDocLink = function(element) {
	    $scope.imgfile = element.files[0];
	    $rootScope.uploadRef();
	}

	$rootScope.uploadRef = function() {
	    var imgfile = $scope.imgfile;
	    var fileExtension = imgfile.name;
	    var frmData = new FormData();
	    frmData.append("file", imgfile);
	    $scope.imgfile = frmData;
	    $.ajax({
	        type : "POST",
	        url : $stateParams.tenantid+"/finance/leaverequest/uploadfileleave",
	        data : frmData,
	        contentType : false,
	        processData : false,
	        success : function(result) {
	        	$scope.leaveRequestObj.uploadRef = result.imgPath;
	            if (result.success) {
	                logger.logSuccess("File Uploaded Successfully");
	            } else {
	                logger.logError("Fail to Upload");
	            }
	        }
	    });
	};
    
    
   
   
   
   
   
   
   
   
   
   
   
   
   var $validationProvider = $injector.get('$validation');
   
    $scope.submit=function(leaveReqAddForm){
    	console.log($scope.leaveRequestObj)
        if (new validationService().checkFormValidity(leaveReqAddForm)) {
        var balanceLeave;
        var selectedLeaveRow;
        for(var i=0;i<$scope.leaveList.length;i++){
            if($scope.leaveList[i].selctRow == true){
                selectedLeaveRow = $scope.leaveList[i].selctRow;
                balanceLeave = $scope.leaveList[i].balance;
            }
        }
        
//        var selectedholidayRow;
//        for(var i=0;i<$scope.holidayList.length;i++){
//            if($scope.holidayList[i].selctRow == true){
//            selectedholidayRow = $scope.holidayList[i].selctRow;
//            }
//        }
        
//        var data=$scope.holidayList;
//        console.log(data);
//        for(var key in data) {
//            var value = data[key];
//            if(value.select){
//                console.log("value");
//                console.log(value);
//                $scope.leaveRequestBatchApprovalData.selected.push(value.holidayId); 
//            } 
//        } 
        
        
        var frmDate = $scope.leaveRequestObj.fromDate;
        var toDate = $scope.leaveRequestObj.toDate;
        frmDate = frmDate.split("/");
        frmDate = new Date(frmDate[2], frmDate[1]-1, frmDate[0]);
        toDate = toDate.split("/");
        toDate = new Date(toDate[2], toDate[1]-1, toDate[0]);
        var today = todaydate;
        today = today.split("/");
        today = new Date(today[2], today[1]-1, today[0]);
       
        if($scope.leaveRequestObj.leaveRadio === 1){
           
            sharedProperties.clearObject();
              
              $scope.leaveRequestObj.isHoliday=false;
        var savedata=$scope.leaveRequestObj ;
        var data={
                'leaveList':$scope.leaveList,
                
                'leaveObj':savedata
                 }

    if(selectedLeaveRow == true){
      
//        if($scope.leaveRequestObj.halfFrom != "" && $scope.leaveRequestObj.halfTo !=""){
           if($scope.leaveRequestObj.fromDate != "" && $scope.leaveRequestObj.toDate != ""){
//             if(frmDate >= today){
             // if(frmDate <= toDate){
                 // if($scope.leaveRequestObj.noOfDays <= balanceLeave || $scope.leaveName=='PL'){
                      if($scope.leave==true && $scope.leaveRequestObj.noOfDays<=3 && $scope.leaveName=='CL' || $scope.leave==true && $scope.leaveName=='PL'){
                       $http.post($stateParams.tenantid+"/finance/leaverequest/add",data).success(function(response) {
                            if (response.success==true) {
                                logger.logSuccess("Saved Succesfully!");
                                $scope.cancel();
                            } else {
                                logger.logError(response.message);
                            }
                        })
                      }

                      
                      
               
                    
                    if($scope.leave==false) {
                        	  $http.post($stateParams.tenantid+"/finance/leaverequest/add",data).success(function(response) {
                              if (response.success==true) {
                                  logger.logSuccess("Saved Succesfully!");
                   
              
                                  $scope.cancel();
                              } else {
                                  logger.logError(response.message);
                              }
                          })
                      }else{
                          logger.logError("At a single time you can't raise request for CL leave more than 3days");
                      }
                /*  }else{
                      logger.logError("No. of days is greater than Leave Balance ");
                  }*/
                      
      /*        }else{
                  logger.logError("At a single time you can't raise request for SL leave more than 11 days");
               }*/
             /*  }else{
                  logger.logError("From Date is greater than To Date");
               }*/
               
//             }else{
//                 logger.logError("From Date should be in Today Date Or Future Date");
//                 $scope.leaveRequestObj. fromDate=todaydate;
//                 $scope.leaveRequestObj.toDate = "";
//             }  
            
           }else{
            logger.logError("Please choose the From Date and To Date");
           }
//        }else{
//            logger.logError("Please select Leave Request From and To");
//        }
    }else{
     logger.logError("Please choose anyone 'Leave Name' from the table");
    }
  } else if($scope.leaveRequestObj.leaveRadio === 2){
            

            sharedProperties.clearObject();
            $scope.leaveRequestObj.isHoliday=true;
            var savedata=$scope.leaveRequestObj ;
            var data= savedata ;
          
            var data={
                    'holidayList':$scope.holidayList,
                    'leaveObj':savedata
                     }
        if($scope.count>0){
//          if($scope.leaveRequestObj.halfFrom != "" && $scope.leaveRequestObj.halfTo !=""){ 
            if($scope.leaveRequestObj.fromDate != "" && $scope.leaveRequestObj.toDate != ""){
               if(frmDate <= toDate){
                   if($scope.count<=$scope.holidayBalance){
                       if($scope.count==$scope.leaveRequestObj.noOfDays){
                           if($scope.count<=12){
                        		   $http.post($stateParams.tenantid+"/finance/leaverequest/add",data).success(function(response) {
                                   if (response.success==true) {
                                       logger.logSuccess("Saved Succesfully!");
                                       $scope.cancel();
                                   } else {
                                       logger.logError(response.message);
                                   }
                               })
                           }else{
                               logger.logError("At a single time you can't raise request for CPL leave more than 12days");
                           }
                         }else{
                             logger.logError("Selected Holiday Worked is not equal with No. of days");
                         }
                   }else{
                       logger.logError("Can't take Holiday Worked Leave more than 20 times per year");
                   }
               }else{
                    logger.logError("From Date is greater than To Date");
                }
            }else{
                logger.logError("Please choose the From Date and To Date");
            }
//          }else{
//            logger.logError("Please select Leave Request From and To");
//          }
        }else{
            logger.logError("Please choose anyone 'Holiday Worked' from the table");
        }
            
       }else if($scope.leaveRequestObj.leaveRadio === 3){
    	    
    	   var clBalance;
           var clLeaveRow;
           
           if($scope.clList!=null){
               for(var i=0;i<$scope.clList.length;i++){
                   if($scope.clList[i].selctRow == true){
                       clLeaveRow = $scope.clList[i].selctRow;
                       clBalance = $scope.clList[i].balance;
                   }
               }
           }
           
           //CL
           
       if(clLeaveRow == true && $scope.cplLeave==false || clLeaveRow == true && $scope.cplLeave==undefined){
    	   if($scope.leaveRequestObj.clFromDate != "" && $scope.leaveRequestObj.clToDate != ""){
                  //if(parseInt($scope.leaveRequestObj.clLeaveDays) <= parseInt(clBalance)){
                	  var data={
             	                'leaveList':$scope.clList,
             	                'leaveObj':$scope.leaveRequestObj
             	                }
             		  data.leaveObj.fromDate=$scope.leaveRequestObj.clFromDate;
             		  data.leaveObj.toDate=$scope.leaveRequestObj.clToDate;
             		  data.leaveObj.noOfDays=$scope.leaveRequestObj.clLeaveDays;
                      if(parseInt($scope.leaveRequestObj.clLeaveDays)<=3){
                        	 $http.post($stateParams.tenantid+"/finance/leaverequest/add",data).success(function(response) {
                            if (response.success==true) {
                                logger.logSuccess("Saved Succesfully!");
                                $scope.cancel();
                            } else {
                                logger.logError(response.message);
                            }
                        })
                      }else{
                          logger.logError("At a single time you can't raise request for CL leave more than 3days");
                      }
                 /* }else{
                      logger.logError("No. of days is greater than Leave Balance ");
                  }*/
           }else{
            logger.logError("Please choose the CL From Date and CL To Date");
           }
       }else if(clLeaveRow == false && $scope.cplLeave==true || clLeaveRow == undefined && $scope.cplLeave==true){
    	 if($scope.count>0){
    	   if($scope.leaveRequestObj.cplFromDate != "" && $scope.leaveRequestObj.cplToDate != ""){
    		   var data={
    	                'holidayList':$scope.holidayList,
    	                'leaveObj':$scope.leaveRequestObj
    	                }
    		   data.leaveObj.fromDate=$scope.leaveRequestObj.cplFromDate;
    		   data.leaveObj.toDate=$scope.leaveRequestObj.cplToDate;
    		   data.leaveObj.noOfDays=$scope.leaveRequestObj.cplLeaveDays;
    		   var noOfDays = $scope.leaveRequestObj.cplLeaveDays;
    		   data.leaveObj.isHoliday=true;
               if($scope.count<=$scope.holidayBalance){
                   if($scope.count==parseInt($scope.leaveRequestObj.cplLeaveDays)){
                       if($scope.count<=12){
                    	   $scope.holidayCheck();
                    	   data.leaveObj.noOfDays = noOfDays;
    						data.leaveObj.cplLeaveDays = noOfDays;
                        	   $http.post($stateParams.tenantid+"/finance/leaverequest/add",data).success(function(response) {
                               if (response.success==true) {
                                   logger.logSuccess("Saved Succesfully!");
                                   $scope.cancel();
                               } else {
                                   logger.logError(response.message);
                               }
                           })
                       }else{
                           logger.logError("At a single time you can't raise request for CPL leave more than 12days");
                       }
                   }else{
                       logger.logError("Selected Holiday Worked is not equal with No. of days");
                   }
               }else{
                   logger.logError("Can't take Holiday Worked Leave more than 20 times per year");
               }
            }else{
                logger.logError("Please choose the CPL From Date and CPL To Date");
            }
         }else{
        	 logger.logError("Please choose anyone 'Holiday Worked' from the table"); 
         }
       }else if(clLeaveRow == true && $scope.cplLeave==true){
    	   var clFutureDate = $scope.leaveRequestObj.clToDate.split("/");
           clFutureDate = new Date(clFutureDate[2], clFutureDate[1]-1, clFutureDate[0]);
           clFutureDate.setDate(clFutureDate.getDate()+1);
           var cplFromDate =$scope.leaveRequestObj.cplFromDate.split('/'),
           cplFrom = new Date(cplFromDate[2], cplFromDate[1]-1, cplFromDate[0]);
           if($scope.leaveRequestObj.clFromDate != "" && $scope.leaveRequestObj.clToDate != ""){
        	if($scope.count>0){ 
        	 if($scope.leaveRequestObj.cplFromDate != "" && $scope.leaveRequestObj.cplToDate != ""){  
               if(clFutureDate.valueOf()==cplFrom.valueOf()){
	        	if($scope.leaveRequestObj.clLeaveDays<=3){
		        	if($scope.count<=$scope.holidayBalance){
	                   if(parseInt($scope.leaveRequestObj.clLeaveDays) <= parseInt(clBalance) ){
		                   if($scope.count==parseInt($scope.leaveRequestObj.cplLeaveDays)){
		                       if($scope.leaveRequestObj.noOfDays==parseInt($scope.leaveRequestObj.clLeaveDays)+parseInt($scope.leaveRequestObj.cplLeaveDays)+parseInt($scope.leaveRequestObj.plLeaveDays)){
		                    	   if($scope.leaveRequestObj.noOfDays<=12){
		                               var data={
		                    		                'leaveList' : $scope.clList,
		                    		                'holidayList':$scope.holidayList,
		                    		                'leaveObj':$scope.leaveRequestObj,
		                                         };
		                               data.leaveObj.fromDate=$scope.leaveRequestObj.clFromDate;
		                    		   data.leaveObj.toDate=$scope.leaveRequestObj.cplToDate;
		                    		   data.leaveObj.isHoliday=true;
		                    		     //  $http.post('hrms/hr/leaverequest/add',data).success(function(response){
		                    			   $http.post($stateParams.tenantid+"/finance/leaverequest/add",data).success(function(response) {
			                               if (response.success==true) {
			                                   logger.logSuccess("Saved Succesfully!");
			                                   $scope.cancel();
			                               } else {
			                                   logger.logError(response.message);
			                               }
			                           })
		                    	   }else{
		                               logger.logError("At a single time you can't raise request for CL and CPL leave more than 12days");
		                    	   }
		                       }else{
		                           logger.logError("No. of Days for CL & No. of Days for CPL is not equal with Total No. of Days");
		                       }
	                       }else{
	                           logger.logError("Selected Holiday Worked is not equal with No. Of Days for CPL");
	                       }
		               }else{
		                   logger.logError("No. of Days for CL  is greater than CL Leave Balance ");
		               }
			        }else{
			           logger.logError("Can't take Holiday Worked Leave more than 20 times per year");
			        }
	        	}else{
	        		logger.logError("At a single time you can't raise request for CL leave more than 3days");
	        	}
	    	  }else{
    			logger.logError("Allow to take leave for Continuous Date");
    			var clFutureDay=clFutureDate.getDate();
    			var clFutureMonth=clFutureDate.getMonth()+1;
    			if (clFutureDay<10){
    				clFutureDay="0" + clFutureDay;
    			};
    			if (clFutureMonth<10){
    				clFutureMonth="0" + clFutureMonth;
    			};
    			$scope.leaveRequestObj.cplFromDate=clFutureDay+"/"+clFutureMonth+"/"+clFutureDate.getFullYear();
	    		$scope.leaveRequestObj.cplToDate='';
	    		$scope.leaveRequestObj.cplLeaveDays='';
	    		$scope.leaveRequestObj.noOfDays='';
    		  }
        	 }else{
              logger.logError("Please choose the CPL From Date and CPL To Date");
             }
            }else{
              logger.logError("Please choose anyone 'Holiday Worked' from the table");             
            }
           }else{
      	    logger.logError("Please choose the CL From Date and CL To Date");
           }
	      }else{
	        logger.logError("Please atleast select either 'CL' or 'CPL' from the table");
	      }
        } 
        
        
        
       else if($scope.leaveRequestObj.leaveRadio === 4){
           
           sharedProperties.clearObject();
             
             $scope.leaveRequestObj.isHoliday=false;
       var savedata=$scope.leaveRequestObj ;
       var data={
               'leaveList':$scope.leaveList,
               
               'leaveObj':savedata
                }

   if(selectedLeaveRow == true){
     
          if($scope.leaveRequestObj.fromDate != "" && $scope.leaveRequestObj.toDate != ""){

                     if($scope.leave==true && $scope.leaveRequestObj.noOfDays<=3 && $scope.leaveName=='CL' || $scope.leave==true && $scope.leaveName=='PL'){
                      $http.post($stateParams.tenantid+"/finance/leaverequest/add",data).success(function(response) {
                           if (response.success==true) {
                               logger.logSuccess("Saved Succesfully!");
                               $scope.cancel();
                           } else {
                               logger.logError(response.message);
                           }
                       })
                     }

                     
                     
              
                   
                   if($scope.leave==false) {
                       	  $http.post($stateParams.tenantid+"/finance/leaverequest/add",data).success(function(response) {
                             if (response.success==true) {
                                 logger.logSuccess("Saved Succesfully!");
                  
             
                                 $scope.cancel();
                             } else {
                                 logger.logError(response.message);
                             }
                         })
                     }else{
                         logger.logError("At a single time you can't raise request for CL leave more than 3days");
                     }
              
           
          }else{
           logger.logError("Please choose the From Date and To Date");
          }

   }else{
    logger.logError("Please choose anyone 'Leave Name' from the table");
   }
 } 
     }else{
        toaster.pop('error', "Please fill the required fields", 
                    logger.getErrorHtmlNew(leaveReqAddForm.$validationSummary), 5000, 'trustedHtml');
     } 
       
   }
    
    $scope.clModify=function(index,clList){
        for(var i=0;i<clList.length;i++){
            if(clList[i].select == true){
                clList[i].selctRow=true;
                $scope.clLeave=true;
            }else{
                clList[i].selctRow=false;
                $scope.clLeave=false;
                if($scope.plDays!=undefined && $scope.leaveRequestObj.clFromDate!="" && $scope.leaveRequestObj.clToDate!=""){
         	    	$scope.leaveRequestObj.plLeaveDays=parseInt($scope.leaveRequestObj.plLeaveDays)-parseInt($scope.plDays);
             	    $scope.leaveRequestObj.noOfDays=parseInt($scope.leaveRequestObj.noOfDays)-(parseInt($scope.leaveRequestObj.clLeaveDays)+parseInt($scope.plDays));
         	    }
                if($scope.plDays!=undefined && $scope.leaveRequestObj.cplFromDate!="" && $scope.leaveRequestObj.cplToDate!=""){
                	var clFutureDate = $scope.leaveRequestObj.clToDate.split("/");
                    clFutureDate = new Date(clFutureDate[2], clFutureDate[1]-1, clFutureDate[0]);
                    clFutureDate.setDate(clFutureDate.getDate()+1);
                    var cplFromDate =$scope.leaveRequestObj.cplFromDate.split('/'),
                    cplFrom = new Date(cplFromDate[2], cplFromDate[1]-1, cplFromDate[0]);
                    if(clFutureDate.valueOf()!=cplFrom.valueOf()){
                    	$scope.leaveRequestObj.plLeaveDays=parseInt($scope.leaveRequestObj.plLeaveDays)-parseInt($scope.plDays);
                 	    $scope.leaveRequestObj.noOfDays=parseInt($scope.leaveRequestObj.cplLeaveDays)+parseInt($scope.leaveRequestObj.plLeaveDays);
                    }
                }
                $scope.leaveRequestObj.clFromDate='';
         	    $scope.leaveRequestObj.clToDate='';
         	    $scope.leaveRequestObj.clLeaveDays='';
            }
        }
    }
    
 /*   $scope.confirmPreviousDate= function(){
        ngDialog.close();
        ngDialog.open({
            template : 'previousDateConfirm',
            scope :$scope
        });
    }
    */
    $scope.yesLeave=function(){
    	if($scope.leaveRequestObj.leaveRadio === 1){
    		if(($scope.leaveRequestObj.fromDate!="" || $scope.leaveRequestObj.fromDate!=undefined) && ($scope.leaveRequestObj.toDate=="" || $scope.leaveRequestObj.toDate==undefined)){
	    		var fromDate = $scope.leaveRequestObj.fromDate;
		        fromDate = fromDate.split("/");
		        fromDate = new Date(fromDate[2], (fromDate[1]-1), fromDate[0]);
		        var d=new Date(fromDate);
		        d.setDate(d.getDate()-1);
		        var year=d.getFullYear();
		        var month=d.getMonth()+1;
		        if (month<10){
		        month="0" + month;
		        };
		        var day=d.getDate();
		        if (day<10){
		        day="0" + day;
		        };
		        $scope.leaveRequestObj.fromDate=day+"/"+month+"/"+year;
    		}else if(($scope.leaveRequestObj.fromDate!="" || $scope.leaveRequestObj.fromDate!=undefined) && ($scope.leaveRequestObj.toDate!="" || $scope.leaveRequestObj.toDate!=undefined)){
    			var toDate = $scope.leaveRequestObj.toDate;
    			toDate = toDate.split("/");
    			toDate = new Date(toDate[2], (toDate[1]-1), toDate[0]);
		        var d=new Date(toDate);
		        d.setDate(d.getDate()+1);
		        var year=d.getFullYear();
		        var month=d.getMonth()+1;
		        if (month<10){
		        month="0" + month;
		        };
		        var day=d.getDate();
		        if (day<10){
		        day="0" + day;
		        };
		        $scope.leaveRequestObj.toDate=day+"/"+month+"/"+year;
    		}
    	}else if($scope.leaveRequestObj.leaveRadio === 3){
    		if($scope.clLeave == true && $scope.cplLeave==false || $scope.clLeave == true && $scope.cplLeave==undefined){
	    		if(($scope.leaveRequestObj.clFromDate!="" || $scope.leaveRequestObj.clFromDate!=undefined) && ($scope.leaveRequestObj.clToDate=="" || $scope.leaveRequestObj.clToDate==undefined)){
			    	var clFromDate = $scope.leaveRequestObj.clFromDate;
			    	clFromDate = clFromDate.split("/");
			    	clFromDate = new Date(clFromDate[2], (clFromDate[1]-1), clFromDate[0]);
			        var clDateFrom=new Date(clFromDate);
			        clDateFrom.setDate(clDateFrom.getDate()-1);
			        var year=clDateFrom.getFullYear();
			        var month=clDateFrom.getMonth()+1;
			        if (month<10){
			        month="0" + month;
			        };
			        var day=clDateFrom.getDate();
			        if (day<10){
			        day="0" + day;
			        };
			        $scope.leaveRequestObj.clFromDate=day+"/"+month+"/"+year;
	    		}else if(($scope.leaveRequestObj.clFromDate!="" || $scope.leaveRequestObj.clFromDate!=undefined) && ($scope.leaveRequestObj.clToDate!="" || $scope.leaveRequestObj.clToDate!=undefined)){
	    			var clToDate = $scope.leaveRequestObj.clToDate;
	    			clToDate = clToDate.split("/");
	    			clToDate = new Date(clToDate[2], (clToDate[1]-1), clToDate[0]);
			        var clDateTo=new Date(clToDate);
			        clDateTo.setDate(clDateTo.getDate()+1);
			        var year=clDateTo.getFullYear();
			        var month=clDateTo.getMonth()+1;
			        if (month<10){
			        month="0" + month;
			        };
			        var day=clDateTo.getDate();
			        if (day<10){
			        day="0" + day;
			        };
			        $scope.leaveRequestObj.clToDate=day+"/"+month+"/"+year;
	    		}
    		}else if($scope.clLeave == false && $scope.cplLeave==true || $scope.clLeave == undefined && $scope.cplLeave==true){
    			if(($scope.leaveRequestObj.cplFromDate!="" || $scope.leaveRequestObj.cplFromDate!=undefined) && ($scope.leaveRequestObj.cplToDate=="" || $scope.leaveRequestObj.cplToDate==undefined)){
			    	var cplFromDate = $scope.leaveRequestObj.cplFromDate;
			    	cplFromDate = cplFromDate.split("/");
			    	cplFromDate = new Date(cplFromDate[2], (cplFromDate[1]-1), cplFromDate[0]);
			        var cplDateFrom=new Date(cplFromDate);
			        cplDateFrom.setDate(cplDateFrom.getDate()-1);
			        var year=cplDateFrom.getFullYear();
			        var month=cplDateFrom.getMonth()+1;
			        if (month<10){
			        month="0" + month;
			        };
			        var day=cplDateFrom.getDate();
			        if (day<10){
			        day="0" + day;
			        };
			        $scope.leaveRequestObj.cplFromDate=day+"/"+month+"/"+year;
	    		}else if(($scope.leaveRequestObj.cplFromDate!="" || $scope.leaveRequestObj.cplFromDate!=undefined) && ($scope.leaveRequestObj.cplToDate!="" || $scope.leaveRequestObj.cplToDate!=undefined)){
	    			var cplToDate = $scope.leaveRequestObj.cplToDate;
	    			cplToDate = cplToDate.split("/");
	    			cplToDate = new Date(cplToDate[2], (cplToDate[1]-1), cplToDate[0]);
			        var cplDateTo=new Date(cplToDate);
			        cplDateTo.setDate(cplDateTo.getDate()+1);
			        var year=cplDateTo.getFullYear();
			        var month=cplDateTo.getMonth()+1;
			        if (month<10){
			        month="0" + month;
			        };
			        var day=cplDateTo.getDate();
			        if (day<10){
			        day="0" + day;
			        };
			        $scope.leaveRequestObj.cplToDate=day+"/"+month+"/"+year;
	    		}
    		}else if($scope.clLeave == true && $scope.cplLeave==true){
    			if(($scope.leaveRequestObj.clFromDate!="" || $scope.leaveRequestObj.clFromDate!=undefined) && ($scope.leaveRequestObj.cplToDate=="" || $scope.leaveRequestObj.cplToDate==undefined)){
			    	var fromDate = $scope.leaveRequestObj.clFromDate;
			    	fromDate = fromDate.split("/");
			        fromDate = new Date(fromDate[2], (fromDate[1]-1), fromDate[0]);
			        var d=new Date(fromDate);
			        d.setDate(d.getDate()-1);
			        var year=d.getFullYear();
			        var month=d.getMonth()+1;
			        if (month<10){
			        month="0" + month;
			        };
			        var day=d.getDate();
			        if (day<10){
			        day="0" + day;
			        };
			        $scope.leaveRequestObj.clFromDate=day+"/"+month+"/"+year;
	    		}else if(($scope.leaveRequestObj.clFromDate!="" || $scope.leaveRequestObj.clFromDate!=undefined) && ($scope.leaveRequestObj.cplToDate!="" || $scope.leaveRequestObj.cplToDate!=undefined)){
	    			var toDate = $scope.leaveRequestObj.cplToDate;
	    			toDate = toDate.split("/");
	    			toDate = new Date(toDate[2], (toDate[1]-1), toDate[0]);
			        var d=new Date(toDate);
			        d.setDate(d.getDate()+1);
			        var year=d.getFullYear();
			        var month=d.getMonth()+1;
			        if (month<10){
			        month="0" + month;
			        };
			        var day=d.getDate();
			        if (day<10){
			        day="0" + day;
			        };
			        $scope.leaveRequestObj.cplToDate=day+"/"+month+"/"+year;
	    		}
    		}
    	}
    	ngDialog.close();
    }
    
    $scope.noLeave=function(){
        if($scope.leaveRequestObj.leaveRadio === 3){
        $scope.leaveRequestObj.noOfDays = '';
        $scope.leaveRequestObj.plLeaveDays ='';
        $scope.leaveRequestObj.cplLeaveDays = '';
        $scope.$watchCollection('[leaveRequestObj.cplFromDate,leaveRequestObj.cplToDate]', function(newValues){
            var frmDate = $scope.leaveRequestObj.cplFromDate;
            var tDate = $scope.leaveRequestObj.cplToDate;
            if(frmDate!="" && tDate!="" && frmDate.length==10 && tDate.length==10){
                var fromDate = frmDate;
                var toDate = tDate;
                fromDate = fromDate.split("/");
                fromDate = new Date(fromDate[2], fromDate[1], fromDate[0]);
                toDate = toDate.split("/");
                toDate = new Date(toDate[2], toDate[1], toDate[0]);
                if(fromDate <= toDate){
                    $scope.leaveRequestObj.cplLeaveDays=(toDate-fromDate)/(24*60*60*1000)+1;
                    
                    
                    
                    if($scope.leaveRequestObj.cplToDate!=undefined && $scope.leaveRequestObj.cplToDate!=""){
                            var holidayBean = {
                                    toDate : $scope.leaveRequestObj.cplToDate,
                                    mdUrl : 'CPL',
                            }
                            
                            $scope.leaveRequestObj.cplLeaveDays='';
                            $scope.leaveRequestObj.noOfDays='';
                            var frmDate = $scope.leaveRequestObj.cplFromDate;
                            var toDate = $scope.leaveRequestObj.cplToDate;
                            frmDate = frmDate.split("/");
                            frmDate = new Date(frmDate[2], frmDate[1]-1, frmDate[0]);
                            toDate = toDate.split("/");
                            toDate = new Date(toDate[2], toDate[1]-1, toDate[0]);
                            var clFrmDate = $scope.leaveRequestObj.clFromDate.split("/");
                            clFrmDate = new Date(clFrmDate[2], clFrmDate[1]-1, clFrmDate[0]);
                            var clFutureDate = $scope.leaveRequestObj.clToDate.split("/");
                            clFutureDate = new Date(clFutureDate[2], clFutureDate[1]-1, clFutureDate[0]);
                            clFutureDate.setDate(clFutureDate.getDate()+1);
                            var clTodate = $scope.leaveRequestObj.clToDate;
                            clTodate = clTodate.split("/");
                            clTodate = new Date(clTodate[2], clTodate[1], clTodate[0]);
                            
                            var cplFromDate =$scope.leaveRequestObj.cplFromDate.split('/'),
                            cplToDate =$scope.leaveRequestObj.cplToDate.split('/'),
                            cplFrom = new Date(cplFromDate[2], cplFromDate[1]-1, cplFromDate[0]),
                            cplTo = new Date(cplToDate[2], cplToDate[1]-1, cplToDate[0]);
                
                            var millisecondsPerDay = 1000 * 60 * 60 * 24;
                            var millisBetween = cplTo.getTime() - cplFrom.getTime();
                            var cplDays = Math.round(millisBetween / millisecondsPerDay)+1;
                            var totalNoOfDays;
                            if($scope.leaveRequestObj.clFromDate!=""){
                                var milliSecondsClToCpl=cplTo.getTime()-clFrmDate.getTime();
                                totalNoOfDays = Math.round(milliSecondsClToCpl / millisecondsPerDay)+1; 
                            }else{
                                totalNoOfDays = cplDays;
                            }
                            
                            var dateBean={
                                    fromDate : $scope.leaveRequestObj.cplFromDate,
                                    toDate : $scope.leaveRequestObj.cplToDate,
                                    noOfDays : cplDays,
                                    leaveType : 'CPL',
                            }
                            
                            $http.post($stateParams.tenantid+"/finance/leaverequest/checkHoliday",holidayBean).success(function(response) {
                          //  $http.post('hrms/hr/leaverequest/checkHoliday',holidayBean).success(function(response){
                                if(response.success==false){
                                    console.log(response);
                                        if(cplFrom >= restrictedDate){
                                            if(frmDate<=toDate){
                                                $http.post($stateParams.tenantid+"/finance/leaverequest/leaveExclude",dateBean).success(function(response) {

                                               // $http.post('hrms/hr/leaverequest/leaveExclude',dateBean).success(function(response){
                                                    if(response.success==true){
                                                            $scope.leaveRequestObj.cplLeaveDays=response.leaveObj.leaveDays;
                                                            if($scope.plDays==undefined){
                                                                if((parseInt(response.leaveObj.leaveDays)+parseInt(response.leaveObj.plLeaveDays))<=12){
                                                                    $scope.leaveRequestObj.plLeaveDays=parseInt(response.leaveObj.plLeaveDays);
                                                                    console.log($scope.leaveRequestObj.plLeaveDays);
                                                                    $scope.leaveRequestObj.noOfDays=parseInt(response.leaveObj.leaveDays)+parseInt(response.leaveObj.plLeaveDays);
                                                                }else{
                                                                    logger.logError("At a single time you can't raise request for CL and CPL leave more than 12days");  
                                                                    $scope.leaveRequestObj.cplToDate='';
                                                                    $scope.leaveRequestObj.cplLeaveDays='';
                                                                    $scope.leaveRequestObj.plLeaveDays='';
                                                                    $scope.leaveRequestObj.noOfDays='';
                                                                }
                                                            }else{
                                                                if(totalNoOfDays<=12){
                                                                    $scope.leaveRequestObj.plLeaveDays=parseInt($scope.plDays)+parseInt(response.leaveObj.plLeaveDays);
                                                                    console.log($scope.leaveRequestObj.plLeaveDays);
                                                                    $scope.leaveRequestObj.noOfDays=totalNoOfDays;
                                                                }else{
                                                                    logger.logError("At a single time you can't raise request for CL and CPL leave more than 12days");  
                                                                    $scope.leaveRequestObj.cplToDate='';
                                                                    $scope.leaveRequestObj.cplLeaveDays='';
                                                                    $scope.leaveRequestObj.plLeaveDays='';
                                                                    $scope.leaveRequestObj.noOfDays='';
                                                                }
                                                            }
                                                        
                                                    }else{
                                                        logger.logError(response.message);
                                                        $scope.leaveRequestObj.cplToDate='';
                                                    }
                                                });
                                            }else{
                                                logger.logError("CPL From Date is greater than CPL To Date");
                                                $scope.leaveRequestObj.cplToDate='';
                                                $scope.leaveRequestObj.cplLeaveDays='';
                                                $scope.leaveRequestObj.plLeaveDays='';
                                                $scope.leaveRequestObj.noOfDays='';
                                            }
                                        }else{
                                            logger.logError("Should allows you to apply leave from "+actualDate);
                                            $scope.leaveRequestObj.cplToDate='';
                                            $scope.leaveRequestObj.cplFromDate=actualDate;
                                        }
                                }else{
                                  /*  $scope.confirmPreviousDate();
                                    logger.logError(response.message);*/
                                }
                            });
                    }
                    
                    $scope.leaveRequestObj.plLeaveDays = 0;
                    $scope.leaveRequestObj.noOfDays = parseInt($scope.leaveRequestObj.cplLeaveDays)+parseInt($scope.leaveRequestObj.plLeaveDays);
                    
               }else{
                   logger.logError("End Date should be greater than Start Date");
               }
            }
      });
        }
    	ngDialog.close();
    }
    
    $scope.$watch('leaveRequestObj.clFromDate', function(newValue,oldValue){
    	if($scope.leaveRequestObj.clFromDate!=undefined && $scope.leaveRequestObj.clFromDate!=""){
    		var holidayBean = {
    				fromDate : $scope.leaveRequestObj.clFromDate,
    				mdUrl : 'CL',
    		}
    		     //$http.post('hrms/hr/leaverequest/checkHoliday',holidayBean).success(function(response){
                $http.post($stateParams.tenantid+"/finance/leaverequest/checkHoliday",holidayBean).success(function(response) {

                if(response.success==false){
                	//$scope.confirmPreviousDate();
                   // logger.logError("Are You Sure want to take leave For this Date's");
                }
            });
    	}
    });
    
    $scope.$watch('leaveRequestObj.clToDate', function(newValue,oldValue){
    	if($scope.leaveRequestObj.clToDate!=undefined && $scope.leaveRequestObj.clToDate!=""){
    		var holidayBean = {
    				toDate : $scope.leaveRequestObj.clToDate,
    				mdUrl : 'CL',
    		}
            $http.post($stateParams.tenantid+"/finance/leaverequest/checkHoliday",holidayBean).success(function(response) {

    		//$http.post('hrms/hr/leaverequest/checkHoliday',holidayBean).success(function(response){
                if(response.success==false){
                	//$scope.confirmPreviousDate();
                 //   logger.logError("Are You Sure want to take leave For this Date's");
                }
            });
    	}
    });
    
    $scope.$watch('leaveRequestObj.cplFromDate', function(newValue,oldValue){
    	if($scope.clLeave == false && $scope.cplLeave==true || $scope.clLeave == undefined && $scope.cplLeave==true){
	    	if($scope.leaveRequestObj.cplFromDate!=undefined && $scope.leaveRequestObj.cplFromDate!=""){
	    		var holidayBean = {
	    				fromDate : $scope.leaveRequestObj.cplFromDate,
	    				mdUrl : 'CPL',
	    		}
                $http.post($stateParams.tenantid+"/finance/leaverequest/checkHoliday",holidayBean).success(function(response) {

	    		//$http.post('hrms/hr/leaverequest/checkHoliday',holidayBean).success(function(response){
	                if(response.success==false){
	                	//$scope.confirmPreviousDate();
	                    //logger.logError("Are You Sure want to take leave For this Date's");
	                }
	            });
	    	}
    	}
    });
    
//    $scope.$watch('leaveRequestObj.cplToDate', function(newValue,oldValue){
//    	if($scope.leaveRequestObj.cplToDate!=undefined && $scope.leaveRequestObj.cplToDate!=""){
//    		var holidayBean = {
//    				fromDate : $scope.leaveRequestObj.clToDate,
//    				mdUrl : 'CPL',
//    		}
//    		$http.post('hrms/hr/leaverequest/checkHoliday',holidayBean).success(function(response){
//                if(response.success==true){
//                	$scope.verified=response.success;
//                }else{
//                    logger.logError(response.message);
//                    $scope.leaveRequestObj.clToDate='';
//                }
//            });
//    	}
//    });
    
    $scope.$watchCollection('[ leaveRequestObj.clFromDate,leaveRequestObj.clToDate]', function(newValue,oldValue){
    	
    	if($scope.leaveRequestObj.clToDate!=undefined && $scope.leaveRequestObj.clToDate!=""
    		&& $scope.leaveRequestObj.clToDate.length == 10 && $scope.leaveRequestObj.clToDate.length == 10){
    		var clBalance;
            var clLeaveRow;
            
            for(var i=0;i<$scope.clList.length;i++){
                if($scope.clList[i].selctRow == true){
                    clLeaveRow = $scope.clList[i].selctRow;
                    clBalance = $scope.clList[i].balance;
                }
            }
            
            var frmDate = $scope.leaveRequestObj.clFromDate;
            var toDate = $scope.leaveRequestObj.clToDate;
            frmDate = frmDate.split("/");
            frmDate = new Date(frmDate[2], frmDate[1]-1, frmDate[0]);
            toDate = toDate.split("/");
            toDate = new Date(toDate[2], toDate[1]-1, toDate[0]);
            
            var clFromDate =$scope.leaveRequestObj.clFromDate.split('/'),
            clToDate =$scope.leaveRequestObj.clToDate.split('/'),
            clFrom = new Date(clFromDate[2], clFromDate[1]-1, clFromDate[0]),
            clTo = new Date(clToDate[2], clToDate[1]-1, clToDate[0]);

	        var millisecondsPerDay = 1000 * 60 * 60 * 24;
	        var millisBetween = clTo.getTime() - clFrom.getTime();
	        var clDays = Math.round(millisBetween / millisecondsPerDay)+1;
            
            	var dateBean={
                        fromDate : $scope.leaveRequestObj.clFromDate,
                        toDate : $scope.leaveRequestObj.clToDate,
                        noOfDays : clDays,
                        leaveType : 'CL',
                }
            	
            	var CL = $scope.daysofCL;
            	var restrictedDate3 = todaydate;
            	    restrictedDate3 = restrictedDate3.split("/");
            	    restrictedDate3 = new Date(restrictedDate3[2], (restrictedDate3[1]-1), restrictedDate3[0]- CL );
            	    var d1=new Date(restrictedDate3);
            	    var year1=d1.getFullYear();
            	    var month1=d1.getMonth()+1;
            	    if (month1<10){
            	    month1="0" + month1;
            	    };
            	    var day1=d1.getDate();
            	    if (day1<10){
            	        day1="0" + day1;
            	    };
            	    var actualDate3=day1 + "/" + month1 + "/" + year1;
            	
            	if(clFrom >= restrictedDate3 ){
            	    if(frmDate<=toDate){
                        $scope.leaveRequestObj.cplFromDate='';
                        $scope.leaveRequestObj.cplToDate='';
                        $scope.leaveRequestObj.clLeaveDays='';
                        $scope.leaveRequestObj.cplLeaveDays='';
                        $scope.leaveRequestObj.plLeaveDays='';
                        $scope.leaveRequestObj.noOfDays='';
                        $http.post($stateParams.tenantid+"/finance/leaverequest/leaveExclude",dateBean).success(function(response) {

                      //  $http.post('hrms/hr/leaverequest/leaveExclude',dateBean).success(function(response){
                            if(response.success==true){
                                if(parseInt(response.leaveObj.leaveDays) <= 3){
                                    $scope.leaveRequestObj.clLeaveDays=response.leaveObj.leaveDays;
                                    $scope.leaveRequestObj.plLeaveDays=response.leaveObj.plLeaveDays;
                                    $scope.plDays=response.leaveObj.plLeaveDays;
                                    $scope.leaveRequestObj.noOfDays=parseInt(response.leaveObj.leaveDays)+parseInt($scope.leaveRequestObj.plLeaveDays);
                                }else{
                                    logger.logError("At a single time you can't raise request for CL leave more than 3days");
                                    $scope.leaveRequestObj.clToDate='';
                                }
                            }else{
                                logger.logError(response.message);
                                $scope.leaveRequestObj.clToDate='';
                                $scope.leaveRequestObj.clLeaveDays='';
                            }
                        });
                    }else{
                        logger.logError("CL From Date is greater than CL To Date");
                        $scope.leaveRequestObj.clToDate='';
                        $scope.leaveRequestObj.clLeaveDays='';
                    }
            	}else{
                    logger.logError("Should allows you to apply leave from "+actualDate3);
                    $scope.leaveRequestObj.clToDate='';
                    $scope.leaveRequestObj.clFromDate=actualDate3;
                    $scope.leaveRequestObj.clLeaveDays='';
                    $scope.leaveRequestObj.cplLeaveDays='';
                    $scope.leaveRequestObj.plLeaveDays='';
                    $scope.leaveRequestObj.noOfDays='';
                }
            	
    	}
    	
    });
    
    $scope.$watchCollection('[ leaveRequestObj.cplFromDate,leaveRequestObj.cplToDate]', function(newValue,oldValue){
    	if($scope.leaveRequestObj.cplToDate!=undefined && $scope.leaveRequestObj.cplToDate!=""
    		&& $scope.leaveRequestObj.cplToDate.length==10 && $scope.leaveRequestObj.cplToDate.length==10){
//    		if($scope.leaveRequestObj.clToDate!="" && $scope.leaveRequestObj.clToDate!=undefined){
    			var holidayBean = {
        				toDate : $scope.leaveRequestObj.cplToDate,
        				mdUrl : 'CPL',
        		}
        		
    			$scope.leaveRequestObj.cplLeaveDays='';
//                $scope.leaveRequestObj.plLeaveDays='';
                $scope.leaveRequestObj.noOfDays='';
	    		var frmDate = $scope.leaveRequestObj.cplFromDate;
	            var toDate = $scope.leaveRequestObj.cplToDate;
	            frmDate = frmDate.split("/");
	            frmDate = new Date(frmDate[2], frmDate[1]-1, frmDate[0]);
	            toDate = toDate.split("/");
	            toDate = new Date(toDate[2], toDate[1]-1, toDate[0]);
	            var clFrmDate = $scope.leaveRequestObj.clFromDate.split("/");
	            clFrmDate = new Date(clFrmDate[2], clFrmDate[1]-1, clFrmDate[0]);
	            var clFutureDate = $scope.leaveRequestObj.clToDate.split("/");
	            clFutureDate = new Date(clFutureDate[2], clFutureDate[1]-1, clFutureDate[0]);
	            clFutureDate.setDate(clFutureDate.getDate()+1);
	            var clTodate = $scope.leaveRequestObj.clToDate;
	            clTodate = clTodate.split("/");
	            clTodate = new Date(clTodate[2], clTodate[1], clTodate[0]);
	            
	            var cplFromDate =$scope.leaveRequestObj.cplFromDate.split('/'),
	            cplToDate =$scope.leaveRequestObj.cplToDate.split('/'),
	            cplFrom = new Date(cplFromDate[2], cplFromDate[1]-1, cplFromDate[0]),
	            cplTo = new Date(cplToDate[2], cplToDate[1]-1, cplToDate[0]);
	
		        var millisecondsPerDay = 1000 * 60 * 60 * 24;
		        var millisBetween = cplTo.getTime() - cplFrom.getTime();
		        var cplDays = Math.round(millisBetween / millisecondsPerDay)+1;
		        var totalNoOfDays;
		        if($scope.leaveRequestObj.clFromDate!=""){
		            var milliSecondsClToCpl=cplTo.getTime()-clFrmDate.getTime();
	                totalNoOfDays = Math.round(milliSecondsClToCpl / millisecondsPerDay)+1; 
		        }else{
		            totalNoOfDays = cplDays;
		        }
		        
	    		var dateBean={
	                    fromDate : $scope.leaveRequestObj.cplFromDate,
	                    toDate : $scope.leaveRequestObj.cplToDate,
	                    noOfDays : cplDays,
	                    leaveType : 'CPL',
	            }
	    		
	    		    //$http.post('hrms/hr/leaverequest/checkHoliday',holidayBean).success(function(response){
                    $http.post($stateParams.tenantid+"/finance/leaverequest/checkHoliday",holidayBean).success(function(response) {

                    if(response.success==true){
                    	
                    	var CPL = $scope.daysofCPL;
                    	debugger;
                    	var restrictedDate4 = todaydate;
                    	    restrictedDate4 = restrictedDate4.split("/");
                    	    restrictedDate4 = new Date(restrictedDate4[2], (restrictedDate4[1]-1), restrictedDate4[0]- CPL );
                    	    var d1=new Date(restrictedDate4);
                    	    var year1=d1.getFullYear();
                    	    var month1=d1.getMonth()+1;
                    	    if (month1<10){
                    	    month1="0" + month1;
                    	    };
                    	    var day1=d1.getDate();
                    	    if (day1<10){
                    	        day1="0" + day1;
                    	    };
                    	    var actualDate4=day1 + "/" + month1 + "/" + year1;
                    	    
                    	    var restrictedDate6 = $scope.leaveRequestObj.cplFromDate;
                    	    restrictedDate6 = restrictedDate6.split("/");
                    	    restrictedDate6 = new Date(restrictedDate6[2], (restrictedDate6[1]-1), restrictedDate6[0] );
                    	    var d3=new Date(restrictedDate6);
                    	    var year3=d3.getFullYear();
                    	    var month3=d3.getMonth()+1;
                    	    if (month3<10){
                    	    month3="0" + month3;
                    	    };
                    	    var day3=d3.getDate();
                    	    if (day3<10){
                    	        day3="0" + day3;
                    	    };
                    	    var actualDate6=year3 + "-" + month3 + "-" + day3;
                    	    
                    	    var cplEx = 0;
                    	    
                    	    debugger;
                    	    for(var i=0;i<$scope.holidayList.length;i++){
                    	         if($scope.holidayList[i].select==true){
                    	           //  $scope.count=$scope.count+1;
                    	    var restrictedDate5 =  $scope.holidayList[i].holidayWorked;
                    	    restrictedDate5 = restrictedDate5.split("/");
                    	    restrictedDate5 = new Date(restrictedDate5[2], (restrictedDate5[1]-1), restrictedDate5[0] );
                    	    var d2=new Date(restrictedDate5);
                    	    var year2=d2.getFullYear()+1;
                    	    var month2=d2.getMonth()+1;
                    	    if (month2<10){
                    	    month2="0" + month2;
                    	    };
                    	    var d5=d2.getDate();
                    	    if (d5 == 1){
							var	d11=d2.setHours(-1);
							var d12 = new Date (d11);
							day2=d12.getDate();
							var d13 = month2-1;
							month2 = d13;
                    	    }
                    	    else{
                    	    var day2=d2.getDate()-1;
                    	    if (day2<10){
                    	        day2="0" + day2;
                    	    };
                    	    }
                    	    var actualDate5=year2 + "-" + month2 + "-" + day2;
                         
                    	    
                    	    var ds12 = Date.parse(actualDate5);
                    	    var ds13 = Date.parse(actualDate6);
//                    	$scope.verified=response.success;
//        	    			if(clFutureDate.valueOf()==cplFrom.valueOf()){
                    	    if(ds13<=ds12){
                            if(cplFrom >= restrictedDate4 ){
                                if(frmDate<=toDate){
                                    $http.post($stateParams.tenantid+"/finance/leaverequest/leaveExclude",dateBean).success(function(response) {

                                   // $http.post('hrms/hr/leaverequest/leaveExclude',dateBean).success(function(response){
                                        if(response.success==true){
                                        //	response.leaveObj.leaveDays = response.leaveObj.leaveDays - parseInt(cplEx);
                                                $scope.leaveRequestObj.cplLeaveDays=response.leaveObj.leaveDays;
                                              //  cplEx =0;
                                                if($scope.plDays==undefined){
                                                    if((parseInt(response.leaveObj.leaveDays)+parseInt(response.leaveObj.plLeaveDays))<=12){
                                                        $scope.leaveRequestObj.plLeaveDays=parseInt(response.leaveObj.plLeaveDays);
                                                        $scope.leaveRequestObj.noOfDays=parseInt(response.leaveObj.leaveDays)+parseInt(response.leaveObj.plLeaveDays);
                                                    }else{
                                                        logger.logError("At a single time you can't raise request for CL and CPL leave more than 12days");  
                                                        $scope.leaveRequestObj.cplToDate='';
                                                        $scope.leaveRequestObj.cplLeaveDays='';
                                                        $scope.leaveRequestObj.plLeaveDays='';
                                                        $scope.leaveRequestObj.noOfDays='';
                                                    }
                                                }else{
                                                    if(totalNoOfDays<=12){
                                                        $scope.leaveRequestObj.plLeaveDays=parseInt($scope.plDays)+parseInt(response.leaveObj.plLeaveDays);
                                                        $scope.leaveRequestObj.noOfDays=totalNoOfDays;
                                                    }else{
                                                        logger.logError("At a single time you can't raise request for CL and CPL leave more than 12days");  
                                                        $scope.leaveRequestObj.cplToDate='';
                                                        $scope.leaveRequestObj.cplLeaveDays='';
                                                        $scope.leaveRequestObj.plLeaveDays='';
                                                        $scope.leaveRequestObj.noOfDays='';
                                                    }
                                                }
                                            
                                        }else{
                                            logger.logError(response.message);
                                            $scope.leaveRequestObj.cplToDate='';
                                        }
                                    });
                                }else{
                                    logger.logError("CPL From Date is greater than CPL To Date");
                                    $scope.leaveRequestObj.cplToDate='';
                                    $scope.leaveRequestObj.cplLeaveDays='';
                                    $scope.leaveRequestObj.plLeaveDays='';
                                    $scope.leaveRequestObj.noOfDays='';
                                }
                            }else{
                                logger.logError("Should allows you to apply leave from "+ actualDate4);
                                $scope.leaveRequestObj.cplToDate='';
                                $scope.leaveRequestObj.cplFromDate=actualDate4;
                            }
                    	    }
                    	    else{
                    	    	logger.logError("Should allows you to apply leave from "+ actualDate5);
                    	    	cplEx = cplEx + 1;
                    	    	$scope.holidayList[i].select= false;
                    	    	$scope.leaveRequestObj.cplToDate ='';
                    	    	
                    	    }
                    	         }
                    	    }
                    
        		    			
//        		    		}else{
//        		    			logger.logError("Allow to take leave for Continuous Date");
//        		    			var clFutureDay=clFutureDate.getDate();
//        		    			var clFutureMonth=clFutureDate.getMonth()+1;
//        		    			if (clFutureDay<10){
//        		    				clFutureDay="0" + clFutureDay;
//        		    			};
//        		    			if (clFutureMonth<10){
//        		    				clFutureMonth="0" + clFutureMonth;
//        		    			};
//        		    			$scope.leaveRequestObj.cplFromDate=clFutureDay+"/"+clFutureMonth+"/"+clFutureDate.getFullYear();
//        			    		$scope.leaveRequestObj.cplToDate='';
//        			    		$scope.leaveRequestObj.cplLeaveDays='';
//        			    		$scope.leaveRequestObj.noOfDays='';
//        		    		}	    			
                    }else{
                    	//$scope.confirmPreviousDate();
                      //  logger.logError("Are You Sure want to take leave For this Date's");
//                        $scope.leaveRequestObj.cplToDate='';
                    }
                });
	    		
//	    	}else{
//	    		logger.logError("Please First Choose CL From Date And CL To Date");
//	    		$scope.leaveRequestObj.cplFromDate='';
//	    		$scope.leaveRequestObj.cplToDate='';
//	    	}
    	}
    });
    
    $scope.holidayCheck=function(){
debugger;
    	if($scope.leaveRequestObj.cplToDate!=undefined && $scope.leaveRequestObj.cplToDate!=""
    		&& $scope.leaveRequestObj.cplToDate.length==10 && $scope.leaveRequestObj.cplToDate.length==10){
//    		if($scope.leaveRequestObj.clToDate!="" && $scope.leaveRequestObj.clToDate!=undefined){
    			var holidayBean = {
        				toDate : $scope.leaveRequestObj.cplToDate,
        				mdUrl : 'CPL',
        		}
        		
    			$scope.leaveRequestObj.cplLeaveDays='';
//                $scope.leaveRequestObj.plLeaveDays='';
                $scope.leaveRequestObj.noOfDays='';
	    		var frmDate = $scope.leaveRequestObj.cplFromDate;
	            var toDate = $scope.leaveRequestObj.cplToDate;
	            frmDate = frmDate.split("/");
	            frmDate = new Date(frmDate[2], frmDate[1]-1, frmDate[0]);
	            toDate = toDate.split("/");
	            toDate = new Date(toDate[2], toDate[1]-1, toDate[0]);
	            var clFrmDate = $scope.leaveRequestObj.clFromDate.split("/");
	            clFrmDate = new Date(clFrmDate[2], clFrmDate[1]-1, clFrmDate[0]);
	            var clFutureDate = $scope.leaveRequestObj.clToDate.split("/");
	            clFutureDate = new Date(clFutureDate[2], clFutureDate[1]-1, clFutureDate[0]);
	            clFutureDate.setDate(clFutureDate.getDate()+1);
	            var clTodate = $scope.leaveRequestObj.clToDate;
	            clTodate = clTodate.split("/");
	            clTodate = new Date(clTodate[2], clTodate[1], clTodate[0]);
	            
	            var cplFromDate =$scope.leaveRequestObj.cplFromDate.split('/'),
	            cplToDate =$scope.leaveRequestObj.cplToDate.split('/'),
	            cplFrom = new Date(cplFromDate[2], cplFromDate[1]-1, cplFromDate[0]),
	            cplTo = new Date(cplToDate[2], cplToDate[1]-1, cplToDate[0]);
	
		        var millisecondsPerDay = 1000 * 60 * 60 * 24;
		        var millisBetween = cplTo.getTime() - cplFrom.getTime();
		        var cplDays = Math.round(millisBetween / millisecondsPerDay)+1;
		        var totalNoOfDays;
		        if($scope.leaveRequestObj.clFromDate!=""){
		            var milliSecondsClToCpl=cplTo.getTime()-clFrmDate.getTime();
	                totalNoOfDays = Math.round(milliSecondsClToCpl / millisecondsPerDay)+1; 
		        }else{
		            totalNoOfDays = cplDays;
		        }
		        
	    		var dateBean={
	                    fromDate : $scope.leaveRequestObj.cplFromDate,
	                    toDate : $scope.leaveRequestObj.cplToDate,
	                    noOfDays : cplDays,
	                    leaveType : 'CPL',
	            }
	    		
                $http.post($stateParams.tenantid+"/finance/leaverequest/checkHoliday",holidayBean).success(function(response) {

	    		//$http.post('hrms/hr/leaverequest/checkHoliday',holidayBean).success(function(response){
                    if(response.success==true){
                    	
                    	var CPL = $scope.daysofCPL;
                    	debugger;
                    	var restrictedDate4 = todaydate;
                    	    restrictedDate4 = restrictedDate4.split("/");
                    	    restrictedDate4 = new Date(restrictedDate4[2], (restrictedDate4[1]-1), restrictedDate4[0]- CPL );
                    	    var d1=new Date(restrictedDate4);
                    	    var year1=d1.getFullYear();
                    	    var month1=d1.getMonth()+1;
                    	    if (month1<10){
                    	    month1="0" + month1;
                    	    };
                    	    var day1=d1.getDate();
                    	    if (day1<10){
                    	        day1="0" + day1;
                    	    };
                    	    var actualDate4=day1 + "/" + month1 + "/" + year1;
                    	    
                    	    var restrictedDate6 = $scope.leaveRequestObj.cplFromDate;
                    	    restrictedDate6 = restrictedDate6.split("/");
                    	    restrictedDate6 = new Date(restrictedDate6[2], (restrictedDate6[1]-1), restrictedDate6[0] );
                    	    var d3=new Date(restrictedDate6);
                    	    var year3=d3.getFullYear();
                    	    var month3=d3.getMonth()+1;
                    	    if (month3<10){
                    	    month3="0" + month3;
                    	    };
                    	    var day3=d3.getDate();
                    	    if (day3<10){
                    	        day3="0" + day3;
                    	    };
                    	    var actualDate6=year3 + "-" + month3 + "-" + day3;
                    	    
                    	    var cplEx = 0;
                    	    
                    	    debugger;
                    	    for(var i=0;i<$scope.holidayList.length;i++){
                    	         if($scope.holidayList[i].select==true){
                    	           //  $scope.count=$scope.count+1;
                    	    var restrictedDate5 =  $scope.holidayList[i].holidayWorked;
                    	    restrictedDate5 = restrictedDate5.split("/");
                    	    restrictedDate5 = new Date(restrictedDate5[2], (restrictedDate5[1]-1), restrictedDate5[0] );
                    	    var d2=new Date(restrictedDate5);
                    	    var year2=d2.getFullYear()+1;
                    	    var month2=d2.getMonth()+1;
                    	    if (month2<10){
                    	    month2="0" + month2;
                    	    };
                    	    var d5=d2.getDate();
                    	    if (d5 == 1){
							var	d11=d2.setHours(-1);
							var d12 = new Date (d11);
							day2=d12.getDate();
							var d13 = month2-1;
							month2 = d13;
                    	    }
                    	    else{
                    	    var day2=d2.getDate()-1;
                    	    if (day2<10){
                    	        day2="0" + day2;
                    	    };
                    	    }
                    	    var actualDate5=year2 + "-" + month2 + "-" + day2;
                         
                    	    
                    	    var ds12 = Date.parse(actualDate5);
                    	    var ds13 = Date.parse(actualDate6);
//                    	$scope.verified=response.success;
//        	    			if(clFutureDate.valueOf()==cplFrom.valueOf()){
                    	    if(ds13<=ds12){
                            if(cplFrom >= restrictedDate4 ){
                                if(frmDate<=toDate){
                                    $http.post($stateParams.tenantid+"/finance/leaverequest/leaveExclude",dateBean).success(function(response) {

                                  // $http.post('hrms/hr/leaverequest/leaveExclude',dateBean).success(function(response){
                                        if(response.success==true){
                                        //	response.leaveObj.leaveDays = response.leaveObj.leaveDays - parseInt(cplEx);
                                                $scope.leaveRequestObj.cplLeaveDays=response.leaveObj.leaveDays;
                                              //  cplEx =0;
                                                if($scope.plDays==undefined){
                                                    if((parseInt(response.leaveObj.leaveDays)+parseInt(response.leaveObj.plLeaveDays))<=12){
                                                        $scope.leaveRequestObj.plLeaveDays=parseInt(response.leaveObj.plLeaveDays);
                                                        $scope.leaveRequestObj.noOfDays=parseInt(response.leaveObj.leaveDays)+parseInt(response.leaveObj.plLeaveDays);
                                                    }else{
                                                        logger.logError("At a single time you can't raise request for CL and CPL leave more than 12days");  
                                                        $scope.leaveRequestObj.cplToDate='';
                                                        $scope.leaveRequestObj.cplLeaveDays='';
                                                        $scope.leaveRequestObj.plLeaveDays='';
                                                        $scope.leaveRequestObj.noOfDays='';
                                                    }
                                                }else{
                                                    if(totalNoOfDays<=12){
                                                        $scope.leaveRequestObj.plLeaveDays=parseInt($scope.plDays)+parseInt(response.leaveObj.plLeaveDays);
                                                        $scope.leaveRequestObj.noOfDays=totalNoOfDays;
                                                    }else{
                                                        logger.logError("At a single time you can't raise request for CL and CPL leave more than 12days");  
                                                        $scope.leaveRequestObj.cplToDate='';
                                                        $scope.leaveRequestObj.cplLeaveDays='';
                                                        $scope.leaveRequestObj.plLeaveDays='';
                                                        $scope.leaveRequestObj.noOfDays='';
                                                    }
                                                }
                                            
                                        }else{
                                            logger.logError(response.message);
                                            $scope.leaveRequestObj.cplToDate='';
                                        }
                                    });
                                }else{
                                    logger.logError("CPL From Date is greater than CPL To Date");
                                    $scope.leaveRequestObj.cplToDate='';
                                    $scope.leaveRequestObj.cplLeaveDays='';
                                    $scope.leaveRequestObj.plLeaveDays='';
                                    $scope.leaveRequestObj.noOfDays='';
                                }
                            }else{
                                logger.logError("Should allows you to apply leave from "+ actualDate4);
                                $scope.leaveRequestObj.cplToDate='';
                                $scope.leaveRequestObj.cplFromDate=actualDate4;
                            }
                    	    }
                    	    else{
                    	    	logger.logError("Should allows you to apply leave from "+ actualDate5);
                    	    	cplEx = cplEx + 1;
                    	    	$scope.holidayList[i].select= false;
                    	    	$scope.leaveRequestObj.cplToDate ='';
                    	    	
                    	    }
                    	         }
                    	    }
                    
        		    			
//        		    		}else{
//        		    			logger.logError("Allow to take leave for Continuous Date");
//        		    			var clFutureDay=clFutureDate.getDate();
//        		    			var clFutureMonth=clFutureDate.getMonth()+1;
//        		    			if (clFutureDay<10){
//        		    				clFutureDay="0" + clFutureDay;
//        		    			};
//        		    			if (clFutureMonth<10){
//        		    				clFutureMonth="0" + clFutureMonth;
//        		    			};
//        		    			$scope.leaveRequestObj.cplFromDate=clFutureDay+"/"+clFutureMonth+"/"+clFutureDate.getFullYear();
//        			    		$scope.leaveRequestObj.cplToDate='';
//        			    		$scope.leaveRequestObj.cplLeaveDays='';
//        			    		$scope.leaveRequestObj.noOfDays='';
//        		    		}	    			
                    }else{
                    	//$scope.confirmPreviousDate();
                      //  logger.logError("Are You Sure want to take leave For this Date's");
//                        $scope.leaveRequestObj.cplToDate='';
                    }
                });
	    		
//	    	}else{
//	    		logger.logError("Please First Choose CL From Date And CL To Date");
//	    		$scope.leaveRequestObj.cplFromDate='';
//	    		$scope.leaveRequestObj.cplToDate='';
//	    	}
    	}
    
    }
    
    $scope.$watch('leaveRequestObj.fromDate', function(newValue,oldValue){
    	if($scope.leaveRequestObj.fromDate!=undefined && $scope.leaveRequestObj.fromDate!=""){
    		if($scope.leaveName=='EL' || $scope.leaveName=='ML'){
        		var dateBean = {
        				fromDate : $scope.leaveRequestObj.fromDate,
        				mdUrl : $scope.leaveName,
        		}
        		    //$http.post('hrms/hr/leaverequest/checkHoliday',dateBean).success(function(response){
                    $http.post($stateParams.tenantid+"/finance/leaverequest/checkHoliday",dateBean).success(function(response) {

        			if(response.success==false){
                    	//$scope.confirmPreviousDate();
                    //    logger.logError("Are You Sure want to take leave For this Date's");
                    }
                });
        	}
    	}
    });
    
    $scope.$watch('leaveRequestObj.toDate', function(newValue,oldValue){
	    	if($scope.leaveRequestObj.toDate!=undefined && $scope.leaveRequestObj.toDate!=""){
	    		if($scope.leaveName=='EL' || $scope.leaveName=='ML'){
	        		var dateBean = {
	        				toDate : $scope.leaveRequestObj.toDate,
	        				mdUrl : $scope.leaveName,
	        		}
                    $http.post($stateParams.tenantid+"/finance/leaverequest/checkHoliday",dateBean).success(function(response) {

	        		//$http.post('hrms/hr/leaverequest/checkHoliday',dateBean).success(function(response){
	        			if(response.success==false){
	                    //	$scope.confirmPreviousDate();
	                        //logger.logError("Are You Sure want to take leave For this Date's");
	                    }
	                });
	        	}
	    	}
    });
    
    $scope.$watchCollection('[ leaveRequestObj.fromDate,leaveRequestObj.toDate,$scope.leaveRequestObj.halfFrom,$scope.leaveRequestObj.halfTo]', function(newValues){
        if(  $scope.leaveRequestObj.fromDate.length==10 && $scope.leaveRequestObj.toDate.length==10 ){
            $scope.changedate($scope.leaveRequestObj. halfFrom,$scope.leaveRequestObj. fromDate,$scope.leaveRequestObj. toDate,$scope.leaveRequestObj. halfTo);
        }
        
    });
    
    $scope.changedate=function(halffrom,fromdate,todate,halfto){
        
        var dt1 =fromdate.split('/'),
            dt2 =todate.split('/'),
            one = new Date(dt1[2], dt1[1]-1, dt1[0]),
            two = new Date(dt2[2], dt2[1]-1, dt2[0]);

        var millisecondsPerDay = 1000 * 60 * 60 * 24;
        var millisBetween = two.getTime() - one.getTime();
        var days = Math.round(millisBetween / millisecondsPerDay);
        
        var frmDate = fromdate;
        var toDate = todate;
        frmDate = frmDate.split("/");
        frmDate = new Date(frmDate[2], frmDate[1]-1, frmDate[0]);
        toDate = toDate.split("/");
        toDate = new Date(toDate[2], toDate[1]-1, toDate[0]);
        
        
        if(halffrom ==1 && halfto == 1){
            days= days + 0.5;
            $scope.leaveRequestObj.noOfDays=days;
        }
       if(halffrom ==1 && halfto == 2){
               days= days + 1;
               $scope.leaveRequestObj.noOfDays=days;
       }
       if(halffrom ==2 && halfto == 1){
                days= days;
              $scope.leaveRequestObj.noOfDays=days;
       }
       if(halffrom ==2 && halfto == 2){
               days= days + 0.5;
               $scope.leaveRequestObj.noOfDays=days;
       }
        
        //$scope.leaveRequestObj.noOfDays=days+1;
        
        var balanceLeave;
        var selectedLeaveRow;
        for(var i=0;i<$scope.leaveList.length;i++){
            if($scope.leaveList[i].selctRow == true){
                selectedLeaveRow = $scope.leaveList[i].selctRow;
                balanceLeave = $scope.leaveList[i].balance;
            }
        }
        var dateBean={
                fromDate : $scope.leaveRequestObj.fromDate,
                toDate : $scope.leaveRequestObj.toDate,
                noOfDays : $scope.leaveRequestObj.noOfDays,
                leaveType : $scope.leaveName,
        }
        if($scope.leaveRequestObj.toDate!=undefined && $scope.leaveRequestObj.toDate!=""){
        	 
        	var EL = $scope.daysofEL;
        	debugger;
        	var restrictedDate1 = todaydate;
        	    restrictedDate1 = restrictedDate1.split("/");
        	    restrictedDate1 = new Date(restrictedDate1[2], (restrictedDate1[1]-1), restrictedDate1[0]- EL );
        	    var d1=new Date(restrictedDate1);
        	    var year1=d1.getFullYear();
        	    var month1=d1.getMonth()+1;
        	    if (month1<10){
        	    month1="0" + month1;
        	    };
        	    var day1=d1.getDate();
        	    if (day1<10){
        	        day1="0" + day1;
        	    };
        	    var actualDate1=day1 + "/" + month1 + "/" + year1;
        	    	
        	
            if(frmDate >= restrictedDate1){
               // if(frmDate <= toDate){
                    if($scope.leaveRequestObj.leaveRadio === 1){
                        if(selectedLeaveRow==true){
                            if($scope.leave==true){
                                $http.post($stateParams.tenantid+"/finance/leaverequest/leaveExclude",dateBean).success(function(response) {

                               // $http.post('hrms/hr/leaverequest/leaveExclude',dateBean).success(function(response){
                                    if(response.success==true){
                                        $scope.leaveRequestObj.noOfDays=response.leaveObj.leaveDays;
                                    }else{
                                        logger.logError(response.message);
                                        $scope.leaveRequestObj.toDate='';
                                        $scope.leaveRequestObj.noOfDays='';
                                    }
                                });
                            }
                        }else{
                            logger.logError("Please choose anyone 'Leave Name' from the table");
                            $scope.leaveRequestObj.toDate='';
                        }
                    }else{
                        dateBean.leaveType='CPL';
                        $http.post($stateParams.tenantid+"/finance/leaverequest/leaveExclude",dateBean).success(function(response) {

                      //  $http.post('hrms/hr/leaverequest/leaveExclude',dateBean).success(function(response){
                            $scope.leaveRequestObj.noOfDays=response.leaveObj.leaveDays;
                        });
                    }
               /* }else{
                    logger.logError("From Date is greater than To Date");
                    $scope.leaveRequestObj.toDate='';
                }*/
            }else{
                logger.logError("Should allows you to apply leave from "+actualDate1);
                $scope.leaveRequestObj.toDate='';
                $scope.leaveRequestObj.fromDate=actualDate1;
            }
            
        }
       
//        if($scope.leaveRequestObj.leaveRadio == true){
//            
//            if($scope.leaveRequestObj.toDate!=""){
//                if(days==0 && halffrom==1 && halfto==2){
//                    $scope.leaveRequestObj.noOfDays = 1;
//                }else{
//                    console.log("not ok")
//                    $scope.leaveRequestObj.noOfDays = '';
//                    $scope.leaveRequestObj.toDate = "";
//                    $scope.leaveRequestObj.halfTo = "";
//                    logger.logError("From Date and To Date must be same");
//                }
//                if(halffrom ==1 && halfto == 1){
//                    days= days + 0.5;
//                    $scope.leaveRequestObj.noOfDays=days+1;
//                }
//               if(halffrom ==1 && halfto == 2){
//                       days= days + 1;
//                       $scope.leaveRequestObj.noOfDays=days;
//               }
//               if(halffrom ==2 && halfto == 1){
//                        days= days;
//                      $scope.leaveRequestObj.noOfDays=days;
//               }
//               if(halffrom ==2 && halfto == 2){
//                       days= days + 0.5;
//                       $scope.leaveRequestObj.noOfDays=days;
//               }
//            }
            
//        }else{
//            if(halffrom ==1 && halfto == 1){
//                days= days + 0.5;
//                $scope.leaveRequestObj.noOfDays=days;
//            }
//           if(halffrom ==1 && halfto == 2){
//                   days= days + 1;
//                   $scope.leaveRequestObj.noOfDays=days;
//           }
//           if(halffrom ==2 && halfto == 1){
//                    days= days;
//                  $scope.leaveRequestObj.noOfDays=days;
//           }
//           if(halffrom ==2 && halfto == 2){
//                   days= days + 0.5;
//                   $scope.leaveRequestObj.noOfDays=days;
//           }
//        }
    
}
   
  //on change date
    $scope.changemy=function(leaveRequestObj){
   
                  var fDate=$scope.leaveRequestObj.fromDate
                  var tDate=$scope.leaveRequestObj.toDate;
                 var dt1 = $scope.leaveRequestObj.fromDate.split('/'),
                  dt2 = $scope.leaveRequestObj.toDate.split('/'),
                  one = new Date(dt1[2], dt1[1]-1, dt1[0]),
                  two = new Date(dt2[2], dt2[1]-1, dt2[0]);
                 var millisecondsPerDay = 1000 * 60 * 60 * 24;
                 var millisBetween = two.getTime() - one.getTime();
                 var days = millisBetween / millisecondsPerDay;
//                 if($scope.leaveRequestObj.leaveRadio == true){
//                     if($scope.leaveRequestObj.halfTo !=""){
//                        if($scope.leaveRequestObj.halfFrom==1 && $scope.leaveRequestObj.halfTo==2){
//                             if($scope.leaveRequestObj.toDate!=""){
                                 $scope.leaveRequestObj.noOfDays = days;
//                             }
//                       }
//                     else{
//                             $scope.leaveRequestObj.noOfDays = '';
//                             $scope.leaveRequestObj.toDate = "";
//                             $scope.leaveRequestObj.halfTo = "";
//                             logger.logError("Can't choose 'Second Half' in 'Request From' and 'First Half' in 'Request To' for Holiday Leave");
//                         }
//                     }
                     
//               }else{    
//                 if($scope.leaveRequestObj.halfFrom ==1 && $scope.leaveRequestObj.halfTo == 1){
//                     days= days + 0.5;
//                     $scope.leaveRequestObj.noOfDays=days;
//                }
//          if($scope.leaveRequestObj.halfFrom ==1 && $scope.leaveRequestObj.halfTo == 2){
//              days= days + 1;
//              $scope.leaveRequestObj.noOfDays=days;
//                          
//          }
//          
//          if($scope.leaveRequestObj.halfFrom ==2 && $scope.leaveRequestObj.halfTo == 1){
//              
//              days= days;
//              $scope.leaveRequestObj.noOfDays=days;
//              
//          }
//          
//          if($scope.leaveRequestObj.halfFrom ==2 && $scope.leaveRequestObj.halfTo == 2){
//               
//                  days= days + 0.5;
//                  $scope.leaveRequestObj.noOfDays=days;
//              
//          }
//         }
//          
      } 
    
    
    
    
    
    
    
    
    
    
    
    
    
    // on change date
    $scope.change = function(leaveRequestObj) {

        var fDate = $scope.leaveRequestObj.fromDate
        var tDate = $scope.leaveRequestObj.toDate;
        var dt1 = $scope.leaveRequestObj.fromDate.split('/'), dt2 = $scope.leaveRequestObj.toDate.split('/'), one = new Date(dt1[2], dt1[1] - 1, dt1[0]), two = new Date(dt2[2], dt2[1] - 1, dt2[0]);
        var millisecondsPerDay = 1000 * 60 * 60 * 24;
        var millisBetween = two.getTime() - one.getTime();
        var days = millisBetween / millisecondsPerDay;
        if ($scope.leaveRequestObj.leaveRadio == true) {
            if ($scope.leaveRequestObj.halfTo != "") {
                if ($scope.leaveRequestObj.halfFrom == 1 && $scope.leaveRequestObj.halfTo == 2) {
                    if ($scope.leaveRequestObj.toDate != "") {
                        $scope.leaveRequestObj.noOfDays = 1;
                    }
                } //else {
                 //   $scope.leaveRequestObj.noOfDays = '';
                 //   $scope.leaveRequestObj.toDate = "";
                 //   $scope.leaveRequestObj.halfTo = "";
               //   logger.logError("Can't choose 'Second Half' in 'Request From' and 'First Half' in 'Request To' for Holiday Leave");
             //   }
            }

        } else {
            if ($scope.leaveRequestObj.halfFrom == 1 && $scope.leaveRequestObj.halfTo == 1) {
                days = days + 0.5;
                $scope.leaveRequestObj.noOfDays = days;
            }
            if ($scope.leaveRequestObj.halfFrom == 1 && $scope.leaveRequestObj.halfTo == 2) {
                days = days + 1;
                $scope.leaveRequestObj.noOfDays = days;

            }

            if ($scope.leaveRequestObj.halfFrom == 2 && $scope.leaveRequestObj.halfTo == 1) {

                days = days;
                $scope.leaveRequestObj.noOfDays = days;

            }

            if ($scope.leaveRequestObj.halfFrom == 2 && $scope.leaveRequestObj.halfTo == 2) {

                days = days + 0.5;
                $scope.leaveRequestObj.noOfDays = days;

            }
        }

    }
 
    //end
    
    var cnt =0,oldVal =0;
    
    $scope.checkPay=function(leaveRequestObj){
    	var days = $scope.leaveRequestObj.noOfDays;
    	if(cnt ==0 )
    		oldVal = days;
    	
    	if(days != undefined){
    		if($scope.leaveRequestObj.payType=='F'){
        		$scope.leaveRequestObj.noOfDays = oldVal*2;
        		
        	}else if($scope.leaveRequestObj.payType=='H'){
   	    		$scope.leaveRequestObj.noOfDays = oldVal;
   	    	}
    		
    		cnt = cnt+1;
    	}
    }
    
});

app.controller('leaverequestEditCtrl', function( $timeout ,$location ,$scope,$state,$http,ngDialog,logger,$stateParams,toaster,validationService,$rootScope) {
    
    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.itemsByPage = 5;
    
   // var requestId = $stateParams.requestId; 
    var requestId = $location.search().leaveRequestId;
    $scope.leaveRequestObj={
            company : '',
            branch : '',
            grade : '',
            department : '',
            empName : '',
            empId:'',
            leaveRadio:1,
            holidayRadio:'',
            fromDate:'',
            toDate: '',
            noOfDays:'',
            leaveReason:'',
            leaveAddress:'',
            leavePhone:'',
            leaveMobile:'',
            appliedOn:'',
            halfFrom:'',
            halfTo:'',
            mdUrl:'',
            isHoliday:'',
            year:'',
            addressDuringLeave:'',
            alternativeEmp:'',
            supportDoc:[],
            payType:'',
            finalSupportDoc:'',
    };
   
    $scope.leaveRequestObj.isEdit=true;
    $scope.alternative = false;

  $scope.leaveList=[];
  $scope.holidayList=[];
  $scope.years = [];
  $scope.holidayLeaveList=[];
  
  $rootScope.uploadDocFile = function(element) {
      $scope.docfile = element.files;
  };

  $rootScope.uploadDocument = function(index) {
      var formdata = new FormData();
      angular.forEach($scope.docfile, function(value, key) {
          formdata.append("file", value);
      });
      $.ajax({
          type : "POST",
          url : "hrms/hr/leaverequest/uploadfile",
          data : formdata,
          contentType : false,
          processData : false,
          success : function(result) {
              if (result.success) {
                  console.log(result.fileName)
                  for(var index in result.fileName){
                	  $scope.leaveRequestObj.supportDoc.push(result.fileName[index]);
                  }
                  logger.logSuccess("File Uploaded Successfully");
              } else {
                  logger.logError("Fail to Upload");
              }
          }
      });
  };
  
  //download 
  $scope.downloadNewFile = function(downloadFile) {
      debugger

      $('#tbnewExport').attr('href',downloadFile);
      
      $("#tbnewExport").bind('click', function() {
  	   });
  	   $('#tbnewExport').simulateClick('click');
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
  
  
  $rootScope.uploadDocLink = function(element) {
	    $scope.imgfile = element.files[0];
	    $rootScope.uploadRef();
	}

	$rootScope.uploadRef = function() {
	    var imgfile = $scope.imgfile;
	    var fileExtension = imgfile.name;
	    var frmData = new FormData();
	    frmData.append("file", imgfile);
	    $scope.imgfile = frmData;
	    $.ajax({
	        type : "POST",
	        url : $stateParams.tenantid+"/finance/leaverequest/uploadfileleave",
	        data : frmData,
	        contentType : false,
	        processData : false,
	        success : function(result) {
	        	$scope.leaveRequestObj.uploadRef = result.imgPath;
	            if (result.success) {
	                logger.logSuccess("File Uploaded Successfully");
	            } else {
	                logger.logError("Fail to Upload");
	            }
	        }
	    });
	};
  
  $scope.employeeChange = function(){
	        $http.get($stateParams.tenantid+'/finance/leaverequest/getEmployeeDetails').success(function(response) {

            //$http.get("hrms/hr/leaverequest/getEmployeeDetails").success(function(response) {
                $scope.leaveRequestObj.empName = response.employeeDetailsList.empName;
                $scope.leaveRequestObj.empId = response.employeeDetailsList.empId;
                $scope.leaveRequestObj.company = response.employeeDetailsList.company;
                $scope.leaveRequestObj.branch = response.employeeDetailsList.branch;
                $scope.leaveRequestObj.grade = response.employeeDetailsList.grade;
                $scope.leaveRequestObj.department = response.employeeDetailsList.department;
                if(response.employeeDetailsList.alternativeList.length!=0){
                    $scope.alternative = true;
                    $scope.alternativeList = response.employeeDetailsList.alternativeList;
                }else{
                    $scope.alternative = false;
                }
            });
    }
    
//    $scope.employeeChange();
  
  $scope.addyear=function(){
     
      for (var i=2000; i<=2020; i++){
          $scope.years.push(i);}
  }
  $scope.addyear();
  
 
        $scope.cancel=function(){
        
            $state.go("app.hr.leaverequest.list",{tenantid:$stateParams.tenantid});
        }
    //$scope.leavechange();
    
    
    $scope.holiday =function(){
     
    //    var url = 'hrms/hr/leaverequest/holidaylist';
        var url = $stateParams.tenantid+'/finance/leaverequest/holidaylist';
        $http.get(url).success(function(datas) {
            $scope.holidayList=datas.holidayList;
            
           });
         }
   
   $scope.modify=function(index,leaveList){
     
       for(var i=0;i<leaveList.length;i++){
           if(i  === index){
               leaveList[i].selctRow=true;
           }else{
               leaveList[i].selctRow=false;
           }
       }
   }
   
 $scope.holidaymodify=function(index,holidayList){
       
     $scope.count = 0;
     for(var i=0;i<holidayList.length;i++){
         if(holidayList[i].select==true){
             $scope.count=$scope.count+1;
         }
     }
       
   }
 
 var url = $stateParams.tenantid+'/finance/leaverequest/getEditList?requestId=' + requestId;

 //var url = 'hrms/hr/leaverequest/getEditList?requestId=' + requestId;
   $http.get(url).success(function(result) {
	   debugger
     $scope.editRequest=true;
     console.log(result);
     $scope.leaveRequestObj.fromDate=result.fromDate;
     $scope.leaveRequestObj.toDate=result.toDate;
     $scope.leaveRequestObj.leaveMobile=result.leaveMobile;
     $scope.leaveRequestObj.alternativeEmp=result.alternativeEmp;
     $scope.leaveRequestObj.leavePhone=result.leavePhone;
     $scope.leaveRequestObj.appliedOn=result.appliedOn;
     $scope.leaveRequestObj.reason=result.reason;
     $scope.leaveRequestObj.halfFrom=result.halfFrom;
     $scope.leaveRequestObj.halfTo=result.halfTo;
     $scope.leaveRequestObj.leaveReason=result.leaveReason
     $scope.leaveRequestObj.leaveAddress=result.leaveAddress
     $scope.leaveRequestObj.noOfDays=result.noOfDays;
     $scope.leaveRequestObj.leaveRequestId=result.leaveRequestId;
     $scope.leaveRequestObj.isHoliday=result.isHoliday;
     $scope.leaveRequestObj.supportDoc = result.supportDoc;
     angular.forEach(result.fileuploadlist, function(value, key) {
    	
         $scope.leaveRequestObj.uploadRef=value.uploadRef;
     });
     
     
     
	 $scope.leaveRequestObj.approvalList =  result.approvalList;

   $scope.leaveRequestObj.uploadRef=result.fileuploadlist[0].uploadRef;
    //alert($scope.leaveRequestObj.uploadRef);
     $scope.employeeChange();
     if(result.isHoliday==false){
         $scope.leaveRequestObj.leaveRadio=1;
         $scope.leaveRequestObj.isMl = 'YES';
         $scope.leaveRequestObj.isMl = 'NO';
     }else{
         $scope.leaveRequestObj.leaveRadio=2;
     }
     
     
     if(result.leaveType=="AL"){ 
           document.getElementById('isMl').disabled = true;
           document.getElementById('holidayRadio').disabled = true;
           $scope.leaveRequestObj.leaveRadio=1;

       }
     
     if(result.leaveType=="SL"){ 
         document.getElementById('isMl').disabled = true;
         document.getElementById('holidayRadio').disabled = true;
         $scope.leaveRequestObj.leaveRadio=1;

     }
     
     if(result.leaveType=="CL"){ 
         document.getElementById('leaveRadio').disabled = true;
         document.getElementById('isMl').disabled = true;
         $scope.leaveRequestObj.leaveRadio=2;

     }
     
     
     if(result.leaveType=="ML"){
 	    $scope.mlLeave=true;
          $scope.splLeave=false;
          
          document.getElementById('leaveRadio').disabled = true;
          document.getElementById('holidayRadio').disabled = true;
          //document.getElementById('clCpl').disabled = true;
          document.getElementById('isMl').checked = true;
          $scope.leaveRequestObj.leaveRadio=4;
          $scope.leaveRequestObj.finalSupportDoc=result.finalSupportDoc;
          $scope.leaveRequestObj.payType=result.payType;
          $scope.leaveRequestObj.isMl = 'YES';
      }
     
     
     
     if(result.leaveType=="SPL"){
         $scope.mlLeave=false;
         $scope.splLeave=true;
         $scope.leaveRequestObj.leaveRadio=1;
         $scope.leaveRequestObj.isMl = 'YES';
         $scope.leaveRequestObj.isMl = 'NO';
         
     }
        
     /*if($scope.leaveRequestObj.leaveRadio==1){*/
    	 
    	 $http.post($stateParams.tenantid+"/finance/leaverequest/leavelist",$scope.leaveRequestObj).success(function(datas) {
             //$scope.leaveList=datas.leaveList;
             for(var i=0;i<datas.leaveList.length;i++){
                 if(datas.leaveList[i].shortName == result.leaveType){
                     //$scope.leaveList[i].select=i;
                     $scope.leaveList.push(datas.leaveList[i]);
                 }
             }
             document.getElementById('holidayRadio').disabled=true;
            });
    	 
    	 
    	 $http.post($stateParams.tenantid+"/finance/leaverequest/holidaylist",$scope.leaveRequestObj).success(function(datas) {

             $scope.holidayList=datas.holidayList;
             $scope.holidayLeaveList=datas.leaveList;
             for(var i=0;i<$scope.holidayList.length;i++){
                $scope.holidayList[i].select=true;
             }
             document.getElementById('leaveRadio').disabled=true;
         });
     
     
     /*
       }else{
    	 $http.post($stateParams.tenantid+"/finance/leaverequest/holidaylist",$scope.leaveRequestObj).success(function(datas) {

             $scope.holidayList=datas.holidayList;
             $scope.holidayLeaveList=datas.leaveList;
             for(var i=0;i<$scope.holidayList.length;i++){
                $scope.holidayList[i].select=true;
             }
             document.getElementById('leaveRadio').disabled=true;
         });
     }*/
   });
     
   
   
/*   //download by jayanthi
   $scope.downloadNewFile = function(id) {
       debugger
       
       
       $timeout(function(){ $("#tbnewExport"+id).simulateClick('click')},100);
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
   }*/
   
   
   
     $scope.update=function(leaveReqAddForm){
         if (new validationService().checkFormValidity(leaveReqAddForm)) {   
         var balanceLeave;
         var selectedLeaveRow;
         for(var i=0;i<$scope.leaveList.length;i++){
             if($scope.leaveList[i].selctRow == true){
                 selectedLeaveRow = $scope.leaveList[i].selctRow;
                 balanceLeave = $scope.leaveList[i].balance;
             }
         }
         
         
         var frmDate = $scope.leaveRequestObj.fromDate;
         var toDate = $scope.leaveRequestObj.toDate;
         frmDate = frmDate.split("/");
         frmDate = new Date(frmDate[2], frmDate[1], frmDate[0]);
         toDate = toDate.split("/");
         toDate = new Date(toDate[2], toDate[1], toDate[0]);
        
         
         if($scope.leaveRequestObj.leaveRadio === 1){
               
         var savedata=$scope.leaveRequestObj ;
         var data={
                 'leaveList':$scope.leaveList,
                 'leaveObj':savedata
                  }
         console.log(data)
         
         if($scope.leaveRequestObj.fromDate != "" && $scope.leaveRequestObj.toDate != ""){
            //if(frmDate <= toDate){
           	 $http.post($stateParams.tenantid+"/finance/leaverequest/update",data).success(function(response) {

              // $http.post('hrms/hr/leaverequest/update',data).success(function(response){
                     if (response==true) {
                         logger.logSuccess("Update Succesfully!");
                         $state.go("app.hr.leaverequest.list",{tenantid:$stateParams.tenantid});
                     } else {
                         logger.logError(response.message);
                     }
                 }).error(function(result) {
                     console.log("data" + result);
                 });
           /* }else{
                    logger.logError("From Date is greater than To Date");
            }*/
         
            }else{
            logger.logError("Please choose the From Date and To Date");
           }
         
  }
         
         if($scope.leaveRequestObj.leaveRadio === 2){
             
             var savedata=$scope.leaveRequestObj ;
             var data= savedata ;
             var data={
                     'holidayList':$scope.holidayList,
                     'leaveObj':savedata
                      }
       
         if($scope.leaveRequestObj.fromDate != "" && $scope.leaveRequestObj.toDate != ""){
           if(frmDate <= toDate){
             	 $http.post($stateParams.tenantid+"/finance/leaverequest/update",data).success(function(response) {

                //    $http.post('hrms/hr/leaverequest/update',data).success(function(response){
                             if (response==true) {
                                 logger.logSuccess("Update Succesfully!");
                                 $state.go("app.hr.leaverequest.list",{tenantid:$stateParams.tenantid});
                             } else {
                                 logger.logError(response.message);
                             }
                         })
                     }else{
                         logger.logError("From Date is greater than To Date");
                   }
             }else{
             logger.logError("Please choose the From Date and To Date");
            }
      }
         
         if($scope.leaveRequestObj.leaveRadio === 4){
             
             var savedata=$scope.leaveRequestObj ;
             var data={
                     'leaveList':$scope.leaveList,
                     'leaveObj':savedata
                      }
             console.log(data)
             
             if($scope.leaveRequestObj.fromDate != "" && $scope.leaveRequestObj.toDate != ""){
                //if(frmDate <= toDate){
               	 $http.post($stateParams.tenantid+"/finance/leaverequest/update",data).success(function(response) {

                  // $http.post('hrms/hr/leaverequest/update',data).success(function(response){
                         if (response==true) {
                             logger.logSuccess("Update Succesfully!");
                             $state.go("app.hr.leaverequest.list",{tenantid:$stateParams.tenantid});
                         } else {
                             logger.logError(response.message);
                         }
                     }).error(function(result) {
                         console.log("data" + result);
                     });
               /* }else{
                        logger.logError("From Date is greater than To Date");
                }*/
             
                }else{
                logger.logError("Please choose the From Date and To Date");
               }
             
      }
         
         
         
         
    }else{
     toaster.pop('error', "Please fill the required fields", 
                         logger.getErrorHtmlNew(leaveReqAddForm.$validationSummary), 5000, 'trustedHtml');
    } 
  }
        
         
//     $scope.$watchCollection('[ leaveRequestObj.fromDate,leaveRequestObj.toDate,$scope.leaveRequestObj.halfFrom,$scope.leaveRequestObj.halfTo]', function(newValues){
//         
//         $scope.changedate($scope.leaveRequestObj. halfFrom,$scope.leaveRequestObj. fromDate,$scope.leaveRequestObj. toDate,$scope.leaveRequestObj. halfTo);
//         
//        });
     
     $scope.changedate=function(halffrom,fromdate,todate,halfto){
         
         var dt1 =fromdate.split('/'),
             dt2 =todate.split('/'),
             one = new Date(dt1[2], dt1[1]-1, dt1[0]),
             two = new Date(dt2[2], dt2[1]-1, dt2[0]);

         var millisecondsPerDay = 1000 * 60 * 60 * 24;
         var millisBetween = two.getTime() - one.getTime();
         var days = millisBetween / millisecondsPerDay;
         
         if($scope.leaveRequestObj.leaveRadio == true){
             
//             if($scope.leaveRequestObj.toDate!=""){
//                 if(days==0 && halffrom==1 && halfto==2){
//                     $scope.leaveRequestObj.noOfDays = 1;
//                 }else{
//                     console.log("not ok")
//                     $scope.leaveRequestObj.noOfDays = '';
//                     $scope.leaveRequestObj.toDate = "";
//                     $scope.leaveRequestObj.halfTo = "";
//                     logger.logError("From Date and To Date must be same");
//                 }
//             }
             if(halffrom ==1 && halfto == 1){
                 days= days + 0.5;
                 $scope.leaveRequestObj.noOfDays=days;
             }
            if(halffrom ==1 && halfto == 2){
                    days= days + 1;
                    $scope.leaveRequestObj.noOfDays=days;
            }
            if(halffrom ==2 && halfto == 1){
                     days= days;
                   $scope.leaveRequestObj.noOfDays=days;
            }
            if(halffrom ==2 && halfto == 2){
                    days= days + 0.5;
                    $scope.leaveRequestObj.noOfDays=days;
            }
             
         }else{
             if(halffrom ==1 && halfto == 1){
                 days= days + 0.5;
                 $scope.leaveRequestObj.noOfDays=days;
             }
            if(halffrom ==1 && halfto == 2){
                    days= days + 1;
                    $scope.leaveRequestObj.noOfDays=days;
            }
            if(halffrom ==2 && halfto == 1){
                     days= days;
                   $scope.leaveRequestObj.noOfDays=days;
            }
            if(halffrom ==2 && halfto == 2){
                    days= days + 0.5;
                    $scope.leaveRequestObj.noOfDays=days;
            }
         }
         
     
 }
    
   //on change date
     $scope.change=function(leaveRequestObj){
    
                   var fDate=$scope.leaveRequestObj.fromDate
                   var tDate=$scope.leaveRequestObj.toDate;
                  var dt1 = $scope.leaveRequestObj.fromDate.split('/'),
                   dt2 = $scope.leaveRequestObj.toDate.split('/'),
                   one = new Date(dt1[2], dt1[1]-1, dt1[0]),
                   two = new Date(dt2[2], dt2[1]-1, dt2[0]);
                  var millisecondsPerDay = 1000 * 60 * 60 * 24;
                  var millisBetween = two.getTime() - one.getTime();
                  var days = millisBetween / millisecondsPerDay;
                     
                  if($scope.leaveRequestObj.leaveRadio == true){
                      if($scope.leaveRequestObj.halfTo !=""){
                         if($scope.leaveRequestObj.halfFrom==1 && $scope.leaveRequestObj.halfTo==2){
                              if($scope.leaveRequestObj.toDate!=""){
                                  $scope.leaveRequestObj.noOfDays = 1;
                              }
                        }
                      else{
                              $scope.leaveRequestObj.noOfDays = '';
                              $scope.leaveRequestObj.toDate = "";
                              $scope.leaveRequestObj.halfTo = "";
                              logger.logError("Can't choose 'Second Half' in 'Request From' and 'First Half' in 'Request To' for Holiday Leave");
                          }
                      }
                      
                }else{    
                  if($scope.leaveRequestObj.halfFrom ==1 && $scope.leaveRequestObj.halfTo == 1){
                      days= days + 0.5;
                      $scope.leaveRequestObj.noOfDays=days;
                 }
           if($scope.leaveRequestObj.halfFrom ==1 && $scope.leaveRequestObj.halfTo == 2){
               days= days + 1;
               $scope.leaveRequestObj.noOfDays=days;
                           
           }
           
           if($scope.leaveRequestObj.halfFrom ==2 && $scope.leaveRequestObj.halfTo == 1){
               
               days= days;
               $scope.leaveRequestObj.noOfDays=days;
               
           }
           
           if($scope.leaveRequestObj.halfFrom ==2 && $scope.leaveRequestObj.halfTo == 2){
                
                   days= days + 0.5;
                   $scope.leaveRequestObj.noOfDays=days;
               
           }
          }
           
       } 
  
    $scope.updateViewMLDoc=function(leaveReqAddForm){
        if (new validationService().checkFormValidity(leaveReqAddForm)) {   
          	 $http.post($stateParams.tenantid+"/finance/leaverequest/updateViewMLDoc",$scope.leaveRequestObj).success(function(response) {

           //$http.post('hrms/hr/leaverequest/updateViewMLDoc',$scope.leaveRequestObj).success(function(response){
                if (response.success==true) {
                    logger.logSuccess("Update Succesfully!");
                    $scope.cancel();
                } else {
                    logger.logError(response.message);
                }
            })
        }else{
            toaster.pop('error', "Please fill the required fields", 
                                logger.getErrorHtmlNew(leaveReqAddForm.$validationSummary), 5000, 'trustedHtml');
        }
    }
       

    
   $scope.reset=function(){

      $scope.leaveRequestObj.fromDate=''
      $scope.leaveRequestObj.toDate=''
      $scope.leaveRequestObj.noOfDays=''
      $scope.leaveRequestObj.leaveReason=''
      $scope.leaveRequestObj.leaveAddress=''
      $scope.leaveRequestObj.leavePhone=''
      $scope.leaveRequestObj.leaveMobile=''
      $scope.leaveRequestObj.halfFrom=''
      $scope.leaveRequestObj.halfTo=''
      $scope.leaveRequestObj.year=''

    	  var url = $stateParams.tenantid+'/finance/leaverequest/getEditList?requestId=' + requestId;
          // var url = 'hrms/hr/leaverequest/getEditList?requestId=' + requestId;
           $http.get(url).success(function(result) {
               $scope.leaveRequestObj.fromDate=result.fromDate;
               $scope.leaveRequestObj.toDate=result.toDate;
               $scope.leaveRequestObj.leaveMobile=result.leaveMobile;
               $scope.leaveRequestObj.leavePhone=result.leavePhone;
               $scope.leaveRequestObj.appliedOn=result.appliedOn;
               $scope.leaveRequestObj.reason=result.reason;
               $scope.leaveRequestObj.halfFrom=result.halfFrom;
               $scope.leaveRequestObj.halfTo=result.halfTo;
               $scope.leaveRequestObj.leaveReason=result.leaveReason
               $scope.leaveRequestObj.leaveAddress=result.leaveAddress
               
          	 $scope.leaveRequestObj.approvalList =  result.approvalList;

               if(result.isHoliday==false){
                   $scope.leaveRequestObj.leaveRadio=1;
               }else{
                   $scope.leaveRequestObj.leaveRadio=2;
               }
               $scope.leaveRequestObj.noOfDays=result.noOfDays;
               if(result.leaveType=="ML"){
                   $scope.mlLeave=true;
                   $scope.splLeave= false;
                   $scope.leaveRequestObj.supportDoc=result.supportDoc;
                   $scope.leaveRequestObj.payType=result.payType;
               }
               if(result.leaveType=="SPL"){
                   $scope.mlLeave=false;
                   $scope.splLeave=true;
                   $scope.leaveRequestObj.supportDoc=result.supportDoc;
               }
           });
       }
   
   
   
   /*//download by vicky
   
   $scope.fileDownload = function() {
       $("#fileExport").bind('click', function() {
       });
       $("#fileExport").simulateClick1('click');

   }
   $.fn.simulateClick1 = function() {
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
   
   
   
   
   
   
   
   
       $scope.downloadMLDoc=function(){
           $("#mlDoc").bind('click', function() {
           });
           $('#mlDoc').simulateClick('click');
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
       
       $scope.uploadViewMLDoc=function(){
           ngDialog.close();
           ngDialog.open({
               template : 'mlFileView',
               scope :$scope
           });
       };
       
       $scope.uploadViewMLFile = function(element){
           $scope.excelfile = element.files[0];
       }
       
       $scope.closeViewML = function() {
           ngDialog.close();
       };
       
       
       $scope.uploadViewML =function(){
           ngDialog.close();
           var file=$scope.excelfile;
           var fileExtension= file.name;
           var fName=[];
           fName=fileExtension.split(".");
           var frmData=new FormData();
           frmData.append("file",file);
           frmData.append("fileName",fName[0]);
           $.ajax({
               type : "POST",
               url : "hrms/hr/leaverequest/uploadMLFile",
               data : frmData,
               contentType: false,
               processData: false,
               success : function(result) {
                   $scope.leaveRequestObj.finalSupportDoc = '';
                   if(result.success){
                       $scope.leaveRequestObj.finalSupportDoc=result.leaveObj.supportDoc;
                       logger.logSuccess("File Uploaded Successfully");
                   }else{
                       logger.logError("Fail to Upload");    
                   }
               }
           });
       }*/
       
       $scope.checkPay=function(leaveRequestObj){
      		var days = $scope.leaveRequestObj.noOfDays;
      		
      		if(days != undefined){
      			if($scope.leaveRequestObj.payType=='F'){
      	    		$scope.leaveRequestObj.noOfDays = days*2;
      	    		
      	    	}else if($scope.leaveRequestObj.payType=='H'){
      	    		$scope.leaveRequestObj.noOfDays = days;
      	    	}
      		}
      	}
   
   });

