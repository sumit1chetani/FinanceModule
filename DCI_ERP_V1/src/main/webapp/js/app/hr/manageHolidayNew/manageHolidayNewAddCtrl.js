
    'use strict';

    app.controller('manageHolidayNewAddCtrl', function($scope,$state,$http,ngDialog,$stateParams, logger,$location,$controller,$injector, sharedProperties, toaster,$rootScope,validationService) {
        $scope.holidayMaster = {
                branch : '',
branchId:1,
                companyName : '',
                companyId :  '',
                holidayName : '',
                date : '',
                day : '',
                isEdit : false,
        };
        
        $scope.companyList =[];

        
        
        $('#date').datetimepicker({
            format : 'DD/MM/YYYY'
        })
        $scope.disable=false;

        $scope.cancel = function(){
            $state.go("app.hr.manageHolidayNew.list",{tenantid:$stateParams.tenantid});

        };
        $scope.companyList=[{
        	id:'C0001',
        	text:'MBK'
        }]
        
     /*   $http.get($stateParams.tenantid+'/app/usermaster/getCompanyList?formCode=F4059').success(function(datas) {
            $scope.companyList = datas;
            var foundItemDest = $filter('filter')($scope.companyList, { id:  1 })[0];
            $scope.journalVoucher.companyCode=foundItemDest.id;
            }).error(function(datas) {
        });
*/
      

        $http.post($stateParams.tenantid+'/app/hr/holiday/branchlist').success(function(data) {
        	      	
          		$scope.branchList=data;
          		        		
        	});
        
        $scope.$watch('holidayMaster.companyName', function(newValue, oldValue) {
            if(newValue!=null && newValue!=""){
                $scope.getBranchList(newValue); 
            }           
        });
        
     /*   $scope.getBranchList=function(companyId){
            if(companyId!=""){
                $http.post('hrms/hr/shiftallocation/getBranchList',companyId).success(function(datas) {
                    $scope.branchList = datas.branchList; 
                 }); 
            }   
        }*/
        
        $scope.save = function(HolidayMasterAddForm) {
            if (new validationService().checkFormValidity(HolidayMasterAddForm)) {
                $http.post($stateParams.tenantid+"/app/hr/holiday/add", $scope.holidayMaster).success(function(result) {

                console.log(result);
                if (result==true) {
                    logger.logSuccess("Saved Succesfully!");
            $state.go("app.hr.manageHolidayNew.list",{tenantid:$stateParams.tenantid});
                } else {
                    logger.logError(" Already Exists!");
                }
            }).error(function(result) {
                console.log("data" + result);
            });
            }else{
                toaster.pop('error', "Please fill the required fields", 
                        logger.getErrorHtmlNew(HolidayMasterAddForm.$validationSummary), 10000, 'trustedHtml');
            }
        }
        $scope.reset = function() {
        	debugger
            if($scope.isEdit == true){
             var holidayId = $scope.holidayMaster.holidayId;
             $scope.holidayMaster.holidayName ='';
             $scope.holidayMaster.date ='';
            
             
             $http.post($stateParams.tenantid+"/app/hr/holiday/getholidayList",holidayId)
             .success(function(response) {
                 console.log("editresultttttttttt");
                 console.log(response); 
                    $scope.holidayMaster = response;
                    
             });
            }else{
                $scope.holidayMaster.holidayName ='';
                $scope.holidayMaster.date ='';
                //$scope.holidayMaster.branch='';
               // $scope.holidayMaster.companyId='';
             }
            };
   
  
        
    });
    
    app.controller('holidayMasterNewEditCtrl', function($scope,$state,$http,ngDialog, logger,$location,$controller,$injector, sharedProperties, toaster,$rootScope,validationService ,$stateParams) {
        
        var holidayId = $stateParams.holidayId;
        
        $scope.holidayMaster = {
                branch : '',
                holidayId:'',
                companyName : '',
                holidayName : '',
                date : '',
                day : '',
                isEdit :true
            
        };
        var holidayId = $location.search().holidayId;

        $scope.isEdit = false;
        if(holidayId != 0){
      //      console.log(holidayId);
            $scope.isEdit = true;
            
            $http.post($stateParams.tenantid+"/app/hr/holiday/getholidayList",holidayId)
            .success(function(response) {
                   $scope.holidayMaster = response;
                   $scope.holidayMaster.companyId=response.companyId;
                   $scope.holidayMaster.branch=response.branch;
                 //  $scope.getCompanyList();


            });
        }
        
    
          /*  
            if( $scope.isEdit==true){
                $scope.reset = function(HolidayMasterAddForm) {
                    
                   
                    // $scope.holidayMaster.branch ='';
                      $scope.holidayMaster.holidayName=result.holidayName;
                     $scope.holidayMaster.date = result.date;
                     
                    
                 };}
           */
        
        $scope.update = function(holidayMaster) {
                $http.post($stateParams.tenantid+"/app/hr/holiday/update",  $scope.holidayMaster).success(function(result) {
                    if (result==true) {
                        logger.logSuccess("Updated Succesfully!");
                        $state.go('app.hr.manageholidayNew.list');
                    } else {
                        logger.logError("Not Updated!");
                    }
                }).error(function(result) {
                    console.log("data" + result);
                });
            
        }

        $scope.cancel = function(){
            $state.go("app.hr.manageHolidayNew.list",{tenantid:$stateParams.tenantid});
        };
       
        $scope.reset = function() {
            if($scope.isEdit == true){
             var holidayId = $scope.holidayMaster.holidayId;
             $scope.holidayMaster.holidayName ='';
             $scope.holidayMaster.date ='';
            
             
             $http.post($stateParams.tenantid+"/app/hr/holiday/getholidayList",holidayId)
             .success(function(response) {
                 console.log("editresultttttttttt");
                 console.log(response); 
                    $scope.holidayMaster = response;
                    
             });
            }else{
                $scope.holidayMaster.holidayName ='';
                $scope.holidayMaster.date ='';
                $scope.holidayMaster.branch='';
                $scope.holidayMaster.companyId='';
             }
            };
   
  
        
    });

