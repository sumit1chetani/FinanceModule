'use strict';
app.factory('THIRDPARTYVOYAGEADD', function($http, $q, logger,$stateParams) {
    var THIRDPARTYVOYAGEADD = new Object();
    THIRDPARTYVOYAGEADD.getThirdPartyHeaderList = function(formCode,voyageId) {
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
    
    THIRDPARTYVOYAGEADD.getServiceList = function(thirdPartyHeader){
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
    
    THIRDPARTYVOYAGEADD.getVoyageDtlList = function(thirdPartyHeader){
        var voyageDtlData=$q.defer();
        $http.post($stateParams.tenantid+'/voyage/thirdPartyVoyage/getVoyageDtlList',thirdPartyHeader).success(function(ThirdPartyVoyageResultBean){
            if(ThirdPartyVoyageResultBean.success == true){
            	
                voyageDtlData.resolve(ThirdPartyVoyageResultBean);
            }else{
                logger.logError("Error Please Try Again");
            }
        }).error(function(data){
            logger.logErroe("Error Please Try Again");
        })
        return voyageDtlData.promise;
    }
    
    THIRDPARTYVOYAGEADD.getEditThirdPartyHeaderList = function(thirdPartyHeader){
        var editVoyageHeaderData=$q.defer();
        $http.post($stateParams.tenantid+'/voyage/thirdPartyVoyage/getEditThirdPartyHeaderList',thirdPartyHeader).success(function(ThirdPartyVoyageResultBean){
            if(ThirdPartyVoyageResultBean.success == true){
                editVoyageHeaderData.resolve(ThirdPartyVoyageResultBean);
            }else{
                logger.logError("Error Please Try Again");
            }
        }).error(function(data){
            logger.logError("Error Please Try Again");
        })
        return editVoyageHeaderData.promise;
    }
    
    THIRDPARTYVOYAGEADD.getEditVoyageDtlList =function(thirdPartyHeader){
        var editVoyageDtlData=$q.defer();
        $http.post($stateParams.tenantid+'/voyage/thirdPartyVoyage/getEditVoyageDtlList',thirdPartyHeader).success(function(ThirdPartyVoyageResultBean){
            if(ThirdPartyVoyageResultBean.success == true){
                editVoyageDtlData.resolve(ThirdPartyVoyageResultBean);
            }else{
                logger.logError("Error Please Try Again");
            }
        }).error(function(data){
            logger.logError("Error Please Try Again");
        })
        return editVoyageDtlData.promise;
    }
    return THIRDPARTYVOYAGEADD;

}) 
app.controller('thirdPartyVoyageAddCtrl', function($scope,  $http, $location, logger,ngDialog, utilsService, $state, sharedProperties,
		$window, $stateParams, toaster, validationService,$controller,THIRDPARTYVOYAGEADD, $rootScope) {
    $scope.vesselList = [];
    $scope.vesselList1 = [];
    $scope.companyList = [];
    $scope.serviceList = [];
    $scope.activityTypes = [];
    $scope.handsonData=[];
    $scope.startportList=[];
    $scope.endPortList=[];
    $scope.distanceList=[];
    $scope.handsonCol=[];
    $scope.mergeCells = [];  
    $scope.voyageMergeCells = [];  
    $scope.vesselMergeCells = [];
    $scope.addRowIndex =[];
    $scope.mloShortNameList=[];
    $scope.addNewRowIndex ='';
    $scope.speed='14';
    $scope.totalPortStayTime='0';
    $scope.totalSteamingTime='0';
    $scope.totalVoyageTime='0';
    $scope.isEdit=false;
    $scope.isView=false;
    var isRender = true;
    var checkboxIndex=1;
    
    /// F6068 F6096

    var formCode = 'F6096';
  
    
    $scope.hourExp=/^[0-9]{1,10}$/;
     $scope.minExp= /^([0-5][0-9])$/;
    $scope.speedExp=/^[0-9]{1,10}$/;
        $scope.thirdPartyHeader ={
      voyageId:'',
      companyCode:'',
      vesselCode:'',
      vesselCode1:'',
      schStartDate:'',
      portCost:0,
      miscCost:0,
      gobunkerCost:0,
      sectorId:'',
      schEndDate:'',
      hireCost:0,
      otherExpenses:0,
      reasonId:'',
      activityeId:'',
      foBunkerCost:0,
      vlsfobunkerCost:0,
      lsmgobunkerCost:0,
      agencyCost:0,
      proformaInsurance:0,
      mloshortName:'',
      charterLiability:0,
      awrp:0,
      addComm:0,
      ewri:0,
      isFirstVoyage:'N',
      flag:'',
      thirdPartyDetailList:[]
    };
        $scope.thirdPartyDtl ={
        		vesselCode:'',
        		voyageId:'',
        		fromPort:'',
        		toPort:'',
        		eta:'',
        		etb:'',
        		etd:0,
        		rotationId:0,
        		nextVoyage:0,
        		remarks:'',
        		cutoffdt:'',
        		
        	    };
        	
        
//        $scope.addRow = function(){
//        	$scope.thirdPartyDtl.push(voyageDtlData);
//        }
       /* $scope.$watchCollection('[thirdPartyHeader.vesselCode, thirdPartyHeader.sectorId,thirdPartyHeader.schStartDate]', function(newValue,oldValue)  {
            $scope.thirdPartyHeader.voyageNo = ''
            $scope.voyageList = [];
            if($scope.thirdPartyHeader.vesselCode != ''){
                
                $http.get('app/commonUtility/voyageList?vesselCode='+$scope.thirdPartyHeader.vesselCode).success(function(data) {
                 
                    if(data.length==0){
                        $scope.thirdPartyHeader.isFirstVoyage='N';
                    }
                    
                });
                
                $scope.onChangeVesselNew($scope.thirdPartyHeader.vesselCode);
            }
        });*/
        
        
        $scope.$watch('thirdPartyHeader.vesselCode1',function(newValue,oldValue){
            console.log($scope.thirdPartyHeader)
            if(newValue !=""){
                $scope.getServiceList();
            }else{
                $scope.thirdPartyHeader.sectorId='';
            }
        });
        $scope.getServiceList = function(){
//            $scope.handsonData.splice(0,$scope.handsonData.length);
//            thirdPartyHandson.updateSettings({data:$scope.handsonData});
            $scope.tempList = THIRDPARTYVOYAGEADD.getServiceList($scope.thirdPartyHeader);
            $scope.tempList.then(function(data){
                console.log(data);
                $scope.serviceList = data.serviceList;
                if( $location.search().sectorId != undefined){
                    $scope.thirdPartyHeader.sectorId=$location.search().sectorId;
                }
                
            })
        }
        
        /*Start Date*/
//        $scope.$watch('thirdPartyHeader.schStartDate',function(newValue,oldValue){
//            if(newValue !=''){
//            	if(!$scope.isEdit){
//            	angular.forEach($scope.thirdPartyHeader.thirdPartyDetailList,function(value,key){
//            		$scope.thirdPartyHeader.thirdPartyDetailList[key].eta = newValue;
//            	});
//            	}
//            	
//            }
//        });
        /*End Date*/
//        $scope.$watch('thirdPartyHeader.schEndDate',function(newValue,oldValue){
//            if(newValue !=''){
//            	if(!$scope.isEdit){
//            		angular.forEach($scope.thirdPartyHeader.thirdPartyDetailList,function(value,key){
//                		$scope.thirdPartyHeader.thirdPartyDetailList[key].etd = newValue;
//                	});
//            	}
//            
//            	
//            	
//            }
//        });
    
        
//   	 $scope.$watch('thirdPartyHeader.thirdPartyDetailList[trIndex].eta', function(newValue, oldValue) {
//   		 alert(8);
//   		$scope.thirdPartyHeader.schStartDate = $scope.thirdPartyHeader.thirdPartyDetailList[0].eta;
//   	 });
//	 $scope.$watch('thirdPartyHeader.thirdPartyDetailList[trIndex].etd', function(newValue, oldValue) {
//   		 alert(9);
//   		 var len = $scope.thirdPartyHeader.thirdPartyDetailList.length;
//   		$scope.thirdPartyHeader.schEndDate = $scope.thirdPartyHeader.thirdPartyDetailList[len].etd;
//   	 });  
        
        /*Service On Change*/
        $scope.$watch('thirdPartyHeader.sectorId',function(newValue,oldValue){
           
            if(newValue !=''){
                $scope.getVoyageDtlList();
            }else{
                $('#sch_start_date').find(':text').attr('disabled','disabled')
                $('#sch_end_date').find(':text').attr('disabled','disabled')
            }
        })
    
        /*voyage*/
        $scope.$watch('voyage',function(newValue,oldValue){ 
        	if(newValue !=''){
       
        	angular.forEach($scope.thirdPartyHeader.thirdPartyDetailList,function(value,key){
        		$scope.thirdPartyHeader.thirdPartyDetailList[key].voyageId = newValue;
        	
        	});
        	}
        	})

        
        /*service on select function*/
      
        $scope.getVoyageDtlList = function(){
        	$scope.thirdPartyHeader.thirdPartyDetailList = [];
            if(($location.search().vesselCode != undefined && $location.search().sectorId != undefined) ||($location.search().voyageId != undefined)) {
                $scope.tempList = THIRDPARTYVOYAGEADD.getEditVoyageDtlList($scope.thirdPartyHeader);
            }else{
            $scope.tempList = THIRDPARTYVOYAGEADD.getVoyageDtlList($scope.thirdPartyHeader);
            }
            $scope.handsonData.splice(0,$scope.handsonData.length);
            $('#portTime').val('');
            $('#steamingTime').val('') 
            $('#voyageTime').val('');
            $scope.tempList.then(function(data){
                console.log(data);
                console.log(data.voyageDtlList.length);
                $scope.portList = [];
                $scope.portList1 = [];
                angular.forEach(data.voyageDtlList,function(value,key){
                  
                	$scope.portList.push( {id:value.fromPort , text: value.fromPort});
                	if(value.toPort != null)
                	$scope.portList1.push( {id:value.toPort , text: value.toPort});

//                    if(key == 0)
//                        $scope.thirdPartyHeader.schStartDate=value.eta;
//                      if(key+1 == data.voyageDtlList.length)  
//                          $scope.thirdPartyHeader.schEndDate=value.etd;
                      //For Copy voyage Data
                      if($location.search().vesselCode1 == undefined && $location.search().sectorId == undefined && $location.search().voyageId != undefined) {
                          value.voyageId='';
                      }else{
//                          thirdPartyHandson.updateSettings({
//                              cells : function(row, col, prop) {
//                                  var cellProperties = {};
//                                  if ($scope.thirdPartyHeader.bookingCount > 0 && col ==1) {
//                                      cellProperties.readOnly = true;
//                                  }
//                                  return cellProperties;
//                              }
//                          }) 
                          
                      }
//                     delete value.portStayContHour;
//                     delete value.steamingContHour;
                      if(($location.search().vesselCode != undefined && $location.search().sectorId != undefined) ||($location.search().voyageId != undefined)) {
                        var voy = value.voyageId;
                        var val = voy.split("-");
                        if(val[1] == undefined || val[1] == "" || val[1] == null){
                        	 $scope.voyage =val[2];
                        }
                        	 if(val[2] == undefined || val[1] == "" || val[1] == null){
                        		   $scope.voyage =val[1];
                        	 }
                        	 if(value.nextVoyage == "Y")
                        	 value.nextVoyage = true;
                        	 else
                        		 value.nextVoyage = false; 
                   
                      }else{
                    	   value.voyageId =$scope.voyage;
                      }
                      $scope.thirdPartyHeader.thirdPartyDetailList.push(value);
//                    $scope.handsonData.push(value);
                });
                console.log($scope.handsonData);
                //FOR HIDE LOADED PORTS
                if(data.voyageDtlList.length == 0) {
                    /* $scope.reloadHandson();*/
                  }
                  else{
//                      thirdPartyHandson.updateSettings({
//                          cells : function(row, col, prop) {
//                              var cellProperties = {};
//                              if (typeof $scope.handsonData[row] != 'undefined' && $scope.handsonData[row].loadingFlag=='Y' && $scope.handsonData[row].loadingFlag!=" ") {
//                                  console.log('Green---------------------');_
//                                  $('.del_voyage:eq(' + row + ')').closest('tr').find('td').css('color', 'green');
//                                  $('.del_voyage:eq(' + row + ')').css('visibility', 'hidden');
//                                  $('.add_voyage:eq(' + row + ')').css('visibility', 'hidden','!important');
//                                  cellProperties.readOnly = true;
//                              }else{
//                               //   $('.del_voyage:eq(' + row + ')').closest('tr').find('td').css('color', 'black');
//                              }
//                              return cellProperties;
//                          }
//                      }) 
                      
                      $('#sch_start_date').find(':text').removeAttr('disabled')
                      $('#sch_end_date').find(':text').removeAttr('disabled')
//                      $scope.thirdPartyHeader.voyageId=$scope.handsonData[0].voyageId;
//                      thirdPartyHandson.updateSettings({data:$scope.handsonData});
//                     for(var index=0;index<$scope.handsonData.length;index++){
//                      vesselsumRowSpan(thirdPartyHandson,index);
//                      voyagesumRowSpan(thirdPartyHandson,index);
//                      $scope.renderMergeCell();
//                      }
//                      timeCalculation($scope.handsonData.length)
                  } 
              /*  console.log(data.totalTime)
                $scope.totalPortStayTime=data.totalTime.totalPortStayTime;
                $scope.totalSteamingTime=data.totalTime.totalSteamingTime;
                $scope.totalVoyageTime=data.totalTime.totalVoyageTime;*/
//                $scope.startportList.splice(0,$scope.startportList.length);
//                $scope.endPortList.splice(0,$scope.endPortList.length);
//                $scope.distanceList.splice(0,$scope.distanceList.length);
//                   angular.forEach(data.portList,function(value,key){
//                      //  voyageHandson.setDataAtCell(key,2,value.port);
//                       $scope.startportList.push(value.fromPort);
//                       $scope.endPortList.push(value.toPort);
//                       $scope.distanceList.push(value.distance);
//                   })
//                   angular.forEach(data.voyageDtlList,function(value,key){
//                       if(value.nextVoyage == 'Y'){
//                           var index=key+1;
//                           $('#port_'+index).prop('checked','checked');
//                       }
//                   });   
            })
            
        }

        $scope.addRow = function(tables, index) {
            var len = tables.length;
            var table = {

            		vesselCode:'',
            		voyageId:'',
            		fromPort:'',
            		toPort:'',
            		eta:'',
            		etb:'',
            		etd:'',
            		rotationId:0,
            		nextVoyage:0,
            		remarks:'',
            		cutoffdt:'',
            		
            	    };
            $scope.thirdPartyHeader.thirdPartyDetailList.splice(index + 1, 0, table);
         

        }

    
        $scope.removeCredRow = function(table,index1) {
            console.log(table);
            $scope.tablerow = [];
            angular.forEach(table.thirdPartyDetailList, function(row, index) {
                console.log(index);
                if (index1 != index) {
                    $scope.tablerow.push(row);
                } else {

                }
            });
            $scope.thirdPartyHeader.thirdPartyDetailList = $scope.tablerow;
        };

        
        
        
        
        $scope.$watchCollection('[thirdPartyHeader.vesselCode1]', function(newValue,oldValue)  {
            $scope.thirdPartyHeader.voyageNo = ''
            $scope.voyageList1 = [];
            if($scope.thirdPartyHeader.vesselCode1 != ''){
                
                $http.get($stateParams.tenantid+'/app/commonUtility/voyageList?vesselCode='+$scope.thirdPartyHeader.vesselCode1).success(function(data) {
                    $scope.voyageList1 = data;
                    if(data.length==0){
                        $scope.thirdPartyHeader.isFirstVoyage='N';
                    }
                    
                    if( $scope.prevVoyage!=null &&  $scope.prevVoyage!=undefined){
                        $scope.thirdPartyHeader.voyageNo = $scope.prevVoyage;
                    }
                    
                });
               
               // $scope.onChangeVesselNew($scope.thirdPartyHeader.vesselCode);
            }
        });
        
        //Get Voyage dropDown
        $scope.onChangeVesselNew = function(vesselId) {
            
            if( ($scope.thirdPartyHeader.sectorId!=undefined &&  $scope.thirdPartyHeader.sectorId!='')  
                    && ($scope.thirdPartyHeader.schStartDate!=undefined &&  $scope.thirdPartyHeader.schStartDate!='')){
            $http.get($stateParams.tenantid+'/app/commonUtility/getVoyageListforGalex?vesselCode='+vesselId+'&service='+$scope.thirdPartyHeader.sectorId+'&startDate='+$scope.thirdPartyHeader.schStartDate).success(function(data) {
              
                if(data!=undefined && data.length!=0 ){
                 $scope.voyageList1 = data;
                }else{
                    
                   $scope.thirdPartyHeader.isFirstVoyage='Y';
                }
             
                if( $scope.prevVoyage!=null &&  $scope.prevVoyage!=undefined){
                    $scope.thirdPartyHeader.voyageNo = $scope.prevVoyage;
                }
                
               
            });
            
            
            }
        };
  
        
      /*  $timeout(function() {
            $scope.thirdPartyHeader.voyageNo;
        }, 2, false);
        */
        
       /* View*/
        
        $scope.viewMode=function(){

            $scope.isEdit=false;
            $scope.isView=true;
//            alert($scope.isEdit);
//            $('#save').hide();
            const x = document. getElementById("save");
            x.style.visibility = 'hidden';
            $location.url($stateParams.tenantid+'/operation/voyage/thirdPartyVoyage/view?vesselCode=' + $location.search().vesselCode + '&voyageId=' + $location.search().voyageId + '&sectorId=' + $location.search().sectorId+'&vesselName='+$location.search().vesselName+'&focusFlag=V');
//            $state.go("app.operation.voyage.thirdPartyVoyage");

        }
        
        
        
        /*Save Functionality*/
        
        $scope.saveThirdPartyVoyage =function(){
            var flag='';
            var isValid=true;
            var warningMsg="";
            var firstVoyageId='';
//            var thirdPartyHandsonData=thirdPartyHandson.getData();
            var thirdPartyHeader=$scope.thirdPartyHeader;
            var noOfDays=0;
            if($location.search().voyageId != undefined && $location.search().sectorId != undefined){
                flag='E';
            }else{
                flag='S';
            }
            if(thirdPartyHeader.vesselCode1 == null || thirdPartyHeader.vesselCode1 == '' ){
                warningMsg+="<li>Please Select Vessel Name</li>"
                    isValid=false;
            } 
            /*else if(thirdPartyHeader.vlsfobunkerCost == null || thirdPartyHeader.vlsfobunkerCost == '' 
                || thirdPartyHeader.vlsfobunkerCost == '0') {
                warningMsg+="<li>Please Enter VLSFO-RV Bunker Cost</li>"
                    isValid=false;
            }else if(thirdPartyHeader.lsmgobunkerCost == null || thirdPartyHeader.lsmgobunkerCost == '' 
                || thirdPartyHeader.lsmgobunkerCost == '0'){
                warningMsg+="<li>Please Enter LSMGO-RV Bunker Cost</li>"
                    isValid=false;
            }*/
            else if(thirdPartyHeader.sectorId == null || thirdPartyHeader.sectorId == '' ){
                warningMsg+="<li>Please Select Service Id</li>"
                    isValid=false;
            } else if(thirdPartyHeader.schStartDate == null || thirdPartyHeader.schStartDate == '' ){
                warningMsg+="<li>Please Select Schedule Start date</li>"
                    isValid=false;
            }else if(thirdPartyHeader.schEndDate == null || thirdPartyHeader.schEndDate == '' ){
                warningMsg+="<li>Please Select Schedule End date</li>"
                    isValid=false;
            }else if(thirdPartyHeader.mloShortName == null || thirdPartyHeader.mloShortName == '' ){
                warningMsg+="<li>Please Select Vessel Operator</li>"
                    isValid=false;
            }
            else if(!utilsService.isUndefinedOrNull(thirdPartyHeader.schStartDate) && !utilsService.isUndefinedOrNull(thirdPartyHeader.schEndDate)){
                debugger;
                    noOfDays = moment(thirdPartyHeader.schEndDate, 'DD/MM/YYYY').diff(moment(thirdPartyHeader.schStartDate, 'DD/MM/YYYY'), 'days');
                if (noOfDays < 0) {
                    $scope.thirdPartyHeader.schEndDate='';
                    warningMsg="End date should be greater than Start date";
                    isValid=false;
                }else{
                    if(flag == "S"){
                    var before10Day=moment(new Date(new Date().setDate(new Date().getDate() - 10))).format('DD/MM/YYYY');
                    noOfDays = moment(thirdPartyHeader.schStartDate, 'DD/MM/YYYY').diff(moment(before10Day, 'DD/MM/YYYY'), 'days');
                    if (noOfDays < 0) {
                        warningMsg="Schedule Start date should not be earlier to 10 days from today.";
                        isValid=false;
                    }
                    }
                }
            
            }
            else if(thirdPartyHeader.voyageNo == null || thirdPartyHeader.voyageNo == '' ){
                if($scope.voyageList1.length>0){
                    if( ($scope.thirdPartyHeader.sectorId=='GALEX') && ($scope.thirdPartyHeader.activityCode=='A0004' ||  $scope.thirdPartyHeader.activityCode=='A0009')){
                        if($scope.thirdPartyHeader.isFirstVoyage!='Y'){
                            warningMsg+="<li>Please Select Previous Voyage</li>"
                                isValid=false;
                        }
                    }
                
                }
            }
            
          
            for(var objThirdPartyDtl in $scope.thirdPartyHeader.thirdPartyDetailList){
            	
//            	$scope.thirdPartyHeader.thirdPartyDetailList[objThirdPartyDtl].steamingHour=thirdPartyHandson.getCell(objThirdPartyDtl,13).innerHTML;
//            	$scope.thirdPartyHeader.thirdPartyDetailList[objThirdPartyDtl].steamingMin=thirdPartyHandson.getCell(objThirdPartyDtl,14).innerHTML;
//            	$scope.thirdPartyHeader.thirdPartyDetailList[objThirdPartyDtl].etd=thirdPartyHandson.getCell(objThirdPartyDtl,9).innerHTML;
                var voyageId=$scope.thirdPartyHeader.thirdPartyDetailList[objThirdPartyDtl].voyageId;
                var eta=$scope.thirdPartyHeader.thirdPartyDetailList[objThirdPartyDtl].eta;
                var etb=$scope.thirdPartyHeader.thirdPartyDetailList[objThirdPartyDtl].etb;
                var etd=$scope.thirdPartyHeader.thirdPartyDetailList[objThirdPartyDtl].etd;
                var startPort=$scope.thirdPartyHeader.thirdPartyDetailList[objThirdPartyDtl].fromPort;
                var rotationNo=$scope.thirdPartyHeader.thirdPartyDetailList[objThirdPartyDtl].rotationId;
                var checkBoxIndex=objThirdPartyDtl;
                if(firstVoyageId == '' && voyageId !=''){
                    firstVoyageId=voyageId;
                    $scope.thirdPartyHeader.voyageId=firstVoyageId;
                }
                if((firstVoyageId == '' || firstVoyageId == null ) && isValid){
                    warningMsg+="Please Enter voyage Id";
                    isValid=false;
                }
//                else{
//                	$scope.thirdPartyHeader.thirdPartyDetailList[objThirdPartyDtl].voyageId='test';
//                }
                if((eta == '' || eta == null) && isValid){
                    warningMsg+="<li>Please Select Eta</li>"
                    isValid=false;
                }
                if((etb == '' || etb == null) && isValid){
                    warningMsg+="<li>Please Select Etb</li>"
                    isValid=false;
                }
                if((etd == '' || etd == null) && isValid){
                    warningMsg+="<li>Please Select Etd</li>"
                    isValid=false;
                }
                if((startPort == '' || startPort == null) && isValid){
                    warningMsg+="<li>Please Select Start Port</li>"
                    isValid=false;
                }
                
                if($scope.thirdPartyHeader.thirdPartyDetailList[objThirdPartyDtl].cutoffdt == ""){
                	$scope.thirdPartyHeader.thirdPartyDetailList[objThirdPartyDtl].cutoffdt = null;
                }
                /*if((rotationNo == '' || rotationNo == null) && isValid){
                    warningMsg+="<li>Please Enter Rotation Number</li>"
                    isValid=false;
                }*/
                checkBoxIndex++;
//                if($('#port_'+checkBoxIndex).is(':checked')){
//                	$scope.thirdPartyHeader.thirdPartyDetailList[objThirdPartyDtl].nextVoyage='Y';
//                }else{
//                	$scope.thirdPartyHeader.thirdPartyDetailList[objThirdPartyDtl].nextVoyage='N';
//                }
                
                
            }
            /*else if($scope.thirdPartyHeader.voyageNo == '' && ($scope.thirdPartyHeader.isFirstVoyage=='' || $scope.thirdPartyHeader.isFirstVoyage=='N')){
                warningMsg+="<li>Please Select First Voyage / Previous Voyage</li>"
                    isValid=false;
            }*/
         if(isValid){   
            /*if(thirdPartyHeader.vesselCode != null || thirdPartyHeader.vesselCode != '' && isValid){
                thirdPartyHeader.vesselCode=thirdPartyHeader.vesselCode+"-";
            }*/
             if($scope.thirdPartyHeader.voyageNo != ''){
                 $scope.thirdPartyHeader.isFirstVoyage='N';
             }
            console.log($scope.thirdPartyHeader)
//            console.log(thirdPartyHandsonData)
            var objThirdPartyVoyageData={
                    thirtyPartyVoyageHeader : $scope.thirdPartyHeader,
                    voyageDtlList  : $scope.thirdPartyHeader.thirdPartyDetailList,
                    voyageFlag:flag
            }
      
           console.log(objThirdPartyVoyageData);
           
        $http.post($stateParams.tenantid+'/voyage/thirdPartyVoyage/saveThirdPartyVoyage',objThirdPartyVoyageData).success(function(data){
                console.log(data);
                if(data.status == 'true'){
                    if(flag == "E"){
                        logger.logSuccess('Sailing Schedule Updated Successfully.')
//                        logger.logSuccess('Third Party Voyage Updated Successfully.')

                    }else{
                    logger.logSuccess('Sailing Schedule Saved Successfully.')
                    }
                    /*if(data.purchaseQutMsg != null && data.purchaseQutMsg != ''){
                        logger.logError(data.purchaseQutMsg); 
                        var dtlList = $.grep(thirdPartyHandsonData, function(n, i) {
                            return $.inArray(i, data.removedIndex) ==-1;
                        });
                        thirdPartyHandson.updateSettings({data:dtlList});
                    }*/
//                    $scope.viewMode();
                    $state.go("app.operation.voyage.thirdPartyVoyage");

                }
                else if(data.status == 'Exist'){
                    logger.logError('Voyage already Exist.')
                }else if(data.status == 'RepeatPort'){
                    logger.logError('Repeated ports are not allowed in Third party!')
                }else if(data.status == 'false'){
                    logger.logError('Sailing Schedule Not Saved.');
                    logger.logError( data.message);
                    /*if(data.purchaseQutMsg != null && data.purchaseQutMsg != ''){
                        logger.logError(data.purchaseQutMsg); 
                    }*/
                }
                else{
                    logger.logError(data.status +" Service Can't Be Added.");
                }
                /*if(data.message != null && data.message != '' && 
                        data.message != 'null' && data.message!='Repeated ports are not allowed in Third party!'){
                    objThirdPartyVoyageData.message=data.message;
                    logger.logError(data.message);
                    $http.post($stateParams.tenantid+'voyage/thirdPartyVoyage/sendMail', objThirdPartyVoyageData).success(function(result) {
                        if (result.success == true) {
                            logger.logSuccess('Mail Sending Successfully.');

                        } else {
                            logger.logSuccess('Mail Not Sending.')
                        }
                    })
                }*/
                /*if(data.purchaseQuotMailMsg != null && data.purchaseQuotMailMsg != '' && 
                        data.purchaseQuotMailMsg != 'null'){
                    objThirdPartyVoyageData.purchaseQuotMailMsg=data.purchaseQuotMailMsg;
                    $http.post('voyage/thirdPartyVoyage/sendMailForPurchaseQuote', objThirdPartyVoyageData).success(function(result) {
                        
                    })
                }*/
               
        }).error(function(data){
            logger.logError("Error Please Try Again");
        })
       }else{
           logger.logError("\n"+warningMsg);
           isValid=true;
       }
    }
        if(($location.search().focusFlag == 'V' )) {
//          $scope.isEdit=false;
//          $scope.isView=true;
          $scope.viewMode();
        }
        
        /* $scope.renderMergeCell();*/
        $scope.cancel = function() {
             $state.go("app.operation.voyage.list");
          }; 
        
        
          
          
          
          
          
          
          
    $scope.reasonList=[{id:'Dry Dock',text:'Dry Dock'},
                       {id:'OFF Hire',text:'OFF Hire'},
                       {id:'Repair',text:'Repair'},
                       {id:'Voyage Cut',text:'Voyage Cut'},
                       {id:'Bunker Supply',text:'Bunker Supply'}]
    $scope.getThirdPartyHeaderList = function() {
        $scope.tempList = THIRDPARTYVOYAGEADD.getThirdPartyHeaderList(formCode,$location.search().voyageId === undefined ? '':$location.search().voyageId);
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
    
    $scope.add =function(){
        $location.url('operations/voyage/thirdPartyVoyage/add');
    }
    $scope.getThirdPartyHeaderList();
    
    
    
   $scope.voyage ="";
    
     $scope.thirdPartyHeader ={
             companyCode :'',
      voyageId:'',
      vesselCode:'',
      vesselCode1:'',
      schStartDate:'',
      portCost:0,
      miscCost:0,
      gobunkerCost:0,
      sectorId:'',
      schEndDate:'',
      hireCost:0,
      otherExpenses:0,
      reasonId:'',
      activityCode:'',
      foBunkerCost:0,
      vlsfobunkerCost:0,
      lsmgobunkerCost:0,
      agencyCost:0,
      proformaInsurance:0,
      mloShortName:'',
      charterLiability:0,
      awrp:0,
      addComm:0,
      ewri:0,
      flag:''
    };
     $scope.diffminutes = function(dt2, dt1) 
     {

      var diff =(dt2.getTime() - dt1.getTime()) / 1000;
      diff /= 60;
//      alert(diff);
      return Math.abs(Math.round(diff));
      
     }

   var  dt1 = new Date("March 14, 2020 11:11:00");
    var dt2 = new Date("March 15, 2020 12:13:00");
    var a = get_time_diff(dt1,dt2);
//    alert(a);

    function get_time_diff( datetime , enddate)
    {
    	
//    	  var  dt1 = new Date(document. getElementById("voyageTime"));
//    	    var dt2 = new Date("March 15, 2020 12:13:00");
    	
    var datetime = typeof datetime !== 'undefined' ? datetime : "2014-01-01 01:02:03.123456";

    var datetime = new Date( datetime ).getTime();
    var now = new Date(enddate).getTime();

    if( isNaN(datetime) )
    {
    return "";
    }

    console.log( datetime + " " + now);

    if (datetime < now) {
    var milisec_diff = now - datetime;
    }else{
    var milisec_diff = datetime - now;
    }

    var days = Math.floor(milisec_diff / 1000 / 60 / (60 * 24));

    var date_diff = new Date( milisec_diff );
    $('#voyageTime').val(parseInt(days) +" Days "+  date_diff.getHours() +" Hours "+ date_diff.getMinutes() +" Mins");

    return days + " Days "+ date_diff.getHours() + " Hours " + date_diff.getMinutes() + " Minutes " + date_diff.getSeconds() + " Seconds";
    }
     
    


    

    
    //Excel Export	
  	 $scope.exportExcelDetail = function(){
  		  var flag = false;
//    	  if($scope.blissuedreport.fromDate !='' && $scope.blissuedreport.fromDate !=null){
//    		  flag = true;
//    		  if($scope.blissuedreport.toDate !='' && $scope.blissuedreport.toDate !=null){
//    			  flag = false;
//    		  }else{
//    			  logger.logError("Please select To Date...!!!");
//    		  }
//    	  }
        	
//    	  if(flag == false){
  		$scope.thirdPartyHeader.voyageIdnew = [];
  		$scope.thirdPartyHeader.voyageIdnew.push($scope.thirdPartyHeader.voyageId);
  	   	 $http.post($stateParams.tenantid+'/voyage/thirdPartyVoyage/ExportExcel',  $scope.thirdPartyHeader).success(function(response) {

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
//    	  }
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
    
    
    
    
    
    
    if($location.search().voyageId != undefined && $location.search().sectorId != undefined){
        $scope.isEdit=true;
        $scope.thirdPartyHeader.voyageId=$location.search().voyageId;
        $scope.thirdPartyHeader.oldVoyageId=$location.search().voyageId;
        $scope.thirdPartyHeader.sectorId=$location.search().sectorId;
     //   $timeout(callAtTimeout, 3000);
        $scope.tempList = THIRDPARTYVOYAGEADD.getEditThirdPartyHeaderList($scope.thirdPartyHeader);
        $scope.tempList.then(function(data){
            console.log(data);
            var thirdPartyHeader=data.editThirdPartyVoyageHeaderList[0];
            $scope.prevVoyage=data.editThirdPartyVoyageHeaderList[0].voyageNo;
            $scope.thirdPartyHeader=thirdPartyHeader;
            if( $location.search().vesselCode != undefined){
                $scope.thirdPartyHeader.vesselCode=$location.search().vesselCode;
                $scope.thirdPartyHeader.oldVoyageId=$location.search().voyageId;
            }
            if( $location.search().vesselName != undefined){
                $scope.thirdPartyHeader.vesselName=$location.search().vesselName;
            }
            
            if($location.search().flag == "COPY"){
                $scope.thirdPartyHeader.flag=$location.search().flag;
            }
          
        })
    }else if($location.search().flag == "COPY"){
        debugger;
        $scope.thirdPartyHeader.voyageId=$location.search().voyageId;
        $scope.thirdPartyHeader.flag = $location.search().flag;
        $scope.tempList = THIRDPARTYVOYAGEADD.getEditThirdPartyHeaderList($scope.thirdPartyHeader);
        $scope.tempList.then(function(data){
            console.log(data);
            var thirdPartyHeader=data.editThirdPartyVoyageHeaderList[0];
            $scope.thirdPartyHeader=angular.copy(thirdPartyHeader);
          
        })
    }else if($location.search().voyageId != undefined){
        debugger;
        $scope.thirdPartyHeader.voyageId=$location.search().voyageId;
        $scope.tempList = THIRDPARTYVOYAGEADD.getEditThirdPartyHeaderList($scope.thirdPartyHeader);
        $scope.tempList.then(function(data){
            console.log(data);
            var thirdPartyHeader=data.editThirdPartyVoyageHeaderList[0];
            $scope.thirdPartyHeader=angular.copy(thirdPartyHeader);
          
        })
    }
    var check_box_renderer = function(instance, td, row, col, prop, value, cellProperties) {
        var checkbox = document.createElement('input');
        checkbox.type = "checkbox";
        checkbox.name = "nextVoyage";
        checkbox.value = false;
        checkbox.id = "port_"+checkboxIndex;
        checkbox.className="next_voyage";
        if($(td).find('input').length > 0){
            
        }else{
        td.appendChild(checkbox);
        checkboxIndex++;
        }
    }    
    
//    var delete_row_renderer = function(instance, td, row, col, prop, value, cellProperties) {
//             var div;
//             var div1;
//             if(!$(td).find('div').hasClass('del_voyage')){
//             $(td).children('.del_voyage').remove();
//             div = document.createElement('div');
//             div.className = 'del_voyage fa fa-trash-o text-danger-dker text';
//             div.title ='click to delete port';
//             td.appendChild(div);
//             }
//             if(!$(td).find('div').hasClass('add_voyage')){
//             $(td).children('.add_voyage').remove();
//             div1 = document.createElement('div');
//             div1.className = 'add_voyage fa fa-plus';
//            // div1.style.visibility = "hidden";
//             div1.title='click to add port';
//             td.appendChild(div1);
//             }
//             $(div1).on('click', function() {
//                 if (instance.getDataAtCell(row, 11) != null && instance.getDataAtCell(row, 11) != ''){
//                   instance.alter('insert_row', row+1);
//                   instance.setDataAtCell(row+1, 12,$scope.speed,'loadData');
//                   instance.setDataAtCell(row+1, 4,2,'loadData');
//                   instance.setDataAtCell(row+1, 5,0,'loadData');
//                   instance.setDataAtCell(row+1, 7,2,'loadData');
//                   instance.setDataAtCell(row+1, 8,0,'loadData');
////                   instance.setDataAtCell(row+1, 9,2,'loadData');
//                   instance.setDataAtCell(row+1, 13,0,'loadData');
//                   instance.setDataAtCell(row+1, 14,0,'loadData');
////                   instance.setDataAtCell(row+1, 15,0,'loadData');
//                 $scope.addRowSpan(row,this);
//                 $scope.renderMergeCell();
//                 if(!$(this).parent().prev().find('.next_voyage').is(':checked')){
//                     $('.next_voyage:checked').eq(0).parent().parent().nextAll().find('.next_voyage').prop('checked',true);
//                     $('.next_voyage:checked').eq(0).prop('checked',false);
//                 }else if($('.next_voyage').is(':checked')){
//                     $('.next_voyage:checked').eq(0).parent().parent().nextAll().find('.next_voyage').prop('checked',true)
//                     }
//                 }else{
//                     logger.logError('please select end port')
//                 }
//                 
//          });
//             if(isRender){
//                 vesselsumRowSpan(instance,row);   
//                 voyagesumRowSpan(instance,row);
//                 }
//                   
//              $(div).on('click', function() {
//                 ngDialog.openConfirm().then(function() {
//                     var vsl_voyage_dt_bean=instance.getSourceDataAtRow(row);
//                     if(vsl_voyage_dt_bean.nextVoyage !='Y'){
//                         $('.next_voyage:checked').eq(0).parent().parent().prev().find('.next_voyage').prop('checked',true);
//                     }
//                      instance.alter('remove_row', row);
//                      $scope.deleteRowSpan(row-1,this,vsl_voyage_dt_bean);
//                      console.log(instance.getSourceDataAtRow(row));
//                      isRender = false;
//                      $scope.renderMergeCell();
//                  }, function(reason) {
//                      console.log('Modal promise rejected. Reason: ', reason);
//                  });
//                
//         });
//               
//         return td;
//     }
    
//    $scope.handsonCol= [
//                     {
//                            data : 'vesselCode',readOnly:true ,renderer: customRenderer
//                     },
//                     {
//                         data : 'voyageId',type : 'text'
//                     },
//                    
//                     {
//                         data : 'fromPort',type : 'autocomplete',source : $scope.startportList
//                     }, {
//                         data : 'eta',type:'date'
//                     },
//                     {
//                         data : 'berthingHour',type : 'text',validator : $scope.hourExp,allowInvalid : false
//                     }, {
//                         data : 'berthingMin',type : 'text',validator : $scope.speedExp,allowInvalid : false
//                     }, {
//                         data : 'etb',type : 'text',readOnly : true
//                     },
//                     {
//                         data : 'portStayHour',type:'text',validator: $scope.hourExp,allowInvalid: false
//                     },
//                     {
//                         data : 'portStayMin',type:'text',validator:$scope.speedExp,allowInvalid: false
//                     },
//                    
////                     {
////                        data :'portStayContHour',type:'text',validator: $scope.hourExp,allowInvalid: false
////                     }, 
//                     {
//                         data : 'etd',type :'text',readOnly:true
//                     },
//                     {
//                         data : 'toPort',type : 'autocomplete',source : $scope.startportList
//                     },
//                     {
//                         data : 'distance',readOnly:true
//                     },
//                     {
//                         data : 'speed',validator:$scope.speedExp,allowInvalid: false
//                     },
//                     {
//                         data : 'steamingHour',readOnly:true
//                     },
//                     {
//                         data : 'steamingMin',readOnly:true
//                     },
////                     {
////                         data : 'steamingContHour'
////                     },
//                     {
//                         data : 'rotationId', renderer: $scope.customRenderer
//                     },
//                     {
//                         data : 'nextVoyage',renderer:check_box_renderer,readOnly:true
//                     },
//                     {
//                         data : 'remarks',type : 'text'
//                     },
//                     {
//                         data : 'button',renderer:delete_row_renderer,readOnly:true
//                     }
//               ];
    

    
//    $scope.thirdPartyAddHandson= function() {
//        var container = document.getElementById('thirdParty'), save = $('save'), thirdPartyHandson;
//        thirdPartyHandson = new Handsontable(container, {
//            data : $scope.handsonData,
//            minSpareRows : 0,
//            fixedColumnsLeft : 0,
//            manualColumnFreeze : true,
//            stretchH : 'all',
//            columns : $scope.handsonCol,
//            contextMenu : false,
//            nativeScrollbars : true,           
//            formulas : true,
//            autoWrapRow:true,
//            colWidths :  [40,45,55,70,40,40,70,40,40,65,70,50,50,50,40,40,65,40,40,40],
//            onSelection:function(r, c, r2, c2){
//                
//            },
//              afterInit : function(){
//                  $scope.buildHandsonHeader();    
//                  
//              },
//              afterRender :function(){
//                  var addFlag=true;
//                      angular.forEach($scope.addRowIndex,function(value,key){
//                         // $('#thirdParty').find('table tbody tr:eq('+value+')').find('.add_voyage').css('visibility','');
//                          if(value == 0){
//                              $('.del_voyage:eq('+value+')').closest('tr').find('td[rowspan]:first').css('background','rgb(229, 247, 7)')
//                              $('.del_voyage:eq('+value+')').closest('tr').find('td[rowspan]:last').css('background','rgb(229, 247, 7)')
//                          }else{
//                              if(addFlag){
//                                  $('.del_voyage:eq('+value+')').closest('tr').prevAll().find('td[rowspan]:first').last().css('background','rgb(229, 247, 7)');
//                                  $('.del_voyage:eq('+value+')').closest('tr').prevAll().find('td[rowspan]:last').last().css('background','rgb(229, 247, 7)');
//                                  addFlag=false;
//                              }else{
//                                  $('.del_voyage:eq('+value+')').closest('tr').prevAll().find('td[rowspan]:first').last().css('background','rgb(68, 234, 45)');
//                                  $('.del_voyage:eq('+value+')').closest('tr').prevAll().find('td[rowspan]:last').last().css('background','rgb(229, 247, 7)');
//                                  addFlag=true;
//                              }
//                          }
//                          //For check box event
//                          $('.next_voyage').change(function(){
//                              if($(this).is(':checked')){
//                              $(this).parent().parent().nextAll().find('.next_voyage').prop('checked',true)
//                              }
//                              else
//                              {
//                              $('.next_voyage:checked').prop('checked',false);
//                              }
//                              })
//
//                      });
//                      $('#port_1').css('visibility','hidden');
//                      if($location.search().focusFlag == 'V'){
//                          $('.del_voyage,.add_voyage').css('visibility','hidden');
//                          $('td[rowspan]').css('background','white');
//                          $('.next_voyage').prop('disabled','true')
//                      } 
//              },
//              afterChange : function(change, source) {
//                  //$scope.buildHandsonHeader();
//                  $scope.eta='';
//                  $scope.berthingTime='';
//                  $scope.berthingHour='';
//                  $scope.berthingMin='';
//                  $scope.fromPort='';
//                  $scope.toPort='';
//                  if (source === 'loadData') {
//                      return;
//                  } else {
//                      var selectedColumn = change[0];
//                      var selectedRowNum=selectedColumn[0];
//                      var colIndex=selectedRowNum+1;
//                      if(selectedColumn[1] == 'eta' || selectedColumn[1] == 'berthingHour' || selectedColumn[1] == 'berthingMin'){
//                          etbFormula(thirdPartyHandson, selectedRowNum, colIndex);
//                          timeCalculation($scope.handsonData.length);
//                      }else if(selectedColumn[1] == 'portStayHour' || selectedColumn[1] == 'portStayMin' )
////                    	  ||   selectedColumn[1] =='portStayContHour')
//                      {
//                          etdFormula(thirdPartyHandson, selectedRowNum, colIndex)
//                      }
//                      else if(selectedColumn[1] =='toPort'  || selectedColumn[1] == 'fromPort'){
//                          var validPort=$filter('filter')($scope.startportList,selectedColumn[3],true);
//                          if(validPort ==0 && selectedColumn[3] != ''){
//                              logger.logError('Please select valid port');
//                              thirdPartyHandson.setDataAtRowProp(selectedRowNum,selectedColumn[1],selectedColumn[2],'loadData');
//                          }else{
//                          if(selectedColumn[2] != selectedColumn[3])
//                              distanceCalculation(thirdPartyHandson, selectedRowNum, colIndex);                          }
//                      }
//                      else if(selectedColumn[1] =='speed'){
//                          distanceAndSpeedFormula(thirdPartyHandson, selectedRowNum, colIndex);
//                      }else {//if(selectedColumn[1] == 'steamingContHour'){
//                          etaFormula(thirdPartyHandson, selectedRowNum, colIndex);
//                      }
//                    
//                  }
//                  
//              
//              }
//        })
////        function etbFormula(thirdPartyHandson, selectedRowNum, colIndex) {
////            var eta = thirdPartyHandson.getDataAtRowProp(selectedRowNum, 'eta');
////            var berthingHour = thirdPartyHandson.getDataAtRowProp(selectedRowNum, 'berthingHour');
////            var berthingMin = thirdPartyHandson.getDataAtRowProp(selectedRowNum, 'berthingMin');
////            if (eta != '' && eta != null) {
////                thirdPartyHandson.setDataAtCell(selectedRowNum, 6, '=FEEDERFORMATTEDMOMENT(MOMENTADD(MOMENTADD(D' + colIndex + ',"MINUTES",F' + colIndex + '),"HOURS",E' + colIndex + '))','loadData');
////                /* distanceCalculation(voyageHandson, selectedRowNum, colIndex); */
////                etdFormula(thirdPartyHandson, selectedRowNum, colIndex);
////            }
////        }
////        function etdFormula(thirdPartyHandson, selectedRowNum, colIndex){
////            var eta=thirdPartyHandson.getDataAtRowProp(selectedRowNum,'eta');
////            if(eta != '' && eta != null){
////                thirdPartyHandson.setDataAtCell(selectedRowNum,9,'=FEEDERFORMATTEDMOMENT(MOMENTADD(MOMENTADD(MOMENTADD(G'+colIndex+',"MINUTES",I'+colIndex+'),"HOURS",H'+colIndex+')))','loadData');
////
//////                thirdPartyHandson.setDataAtCell(selectedRowNum,9,'=FEEDERFORMATTEDMOMENT(MOMENTADD(MOMENTADD(MOMENTADD(G'+colIndex+',"MINUTES",I'+colIndex+'),"HOURS",H'+colIndex+'),"HOURS",J'+colIndex+'))','loadData');
////                etaFormula(thirdPartyHandson, selectedRowNum, colIndex);
////                var endDate=thirdPartyHandson.getDataAtRowProp(thirdPartyHandson.countRows()-1,'eta');
////                var startDate=thirdPartyHandson.getDataAtRowProp(0,'eta');
////                $('#sch_end_date').find(':text').val(endDate);
////                $('#sch_start_date').find(':text').val(startDate);
////                $scope.thirdPartyHeader.schEndDate=endDate;
////                $scope.thirdPartyHeader.schStartDate=startDate;
////            }
////        }
////        function etaFormula(thirdPartyHandson, selectedRowNum, colIndex){
////            var nextRowSpanIndex = $('.add_voyage:eq('+selectedRowNum+')').closest('tr').next().index(); 
////            if(nextRowSpanIndex !=-1){
////                
////            var etd=thirdPartyHandson.getDataAtRowProp(selectedRowNum,'etd') ;
////            var steamingHour=thirdPartyHandson.getDataAtRowProp(selectedRowNum,'steamingHour') ;
////            var steamingMin= thirdPartyHandson.getDataAtRowProp(selectedRowNum,'steamingMin');
////            var distance =thirdPartyHandson.getDataAtRowProp(selectedRowNum,'distance');
////            var speed=thirdPartyHandson.getDataAtRowProp(selectedRowNum,'speed');
////            var endPort =thirdPartyHandson.getDataAtRowProp(selectedRowNum,"endPort");
////            if(etd!= null && etd !='' && steamingHour !=null && steamingMin !=null 
////                    ){
////                var nextRowIndex = selectedRowNum+1;
////                var index = $('.add_voyage:eq('+selectedRowNum+')').closest('tr').nextAll().find('td[rowspan]:first').first().closest('tr').index();
////                
////                var exsitingValue= thirdPartyHandson.getCell(nextRowIndex,0).innerHTML;
////                thirdPartyHandson.setDataAtCell(nextRowIndex,1,'=FEEDERFORMATTEDMOMENT(MOMENTADD(MOMENTADD(MOMENTADD(J'+colIndex+',"MINUTES",O'+colIndex+'),"HOURS",N'+colIndex+'),"HOURS",P'+colIndex+'))');
////
//////                thirdPartyHandson.setDataAtCell(nextRowIndex,1,'=FEEDERFORMATTEDMOMENT(MOMENTADD(MOMENTADD(MOMENTADD(K'+colIndex+',"MINUTES",P'+colIndex+'),"HOURS",O'+colIndex+'),"HOURS",Q'+colIndex+'))');
////                var nextEta= thirdPartyHandson.getCell(nextRowIndex,1).innerHTML;
////                thirdPartyHandson.setDataAtCell(nextRowIndex,3,nextEta);
////                thirdPartyHandson.setDataAtCell(nextRowIndex,1,exsitingValue);
////               
////                }
////            }
////        }
//        
////        function distanceCalculation(thirdPartyHandson,selectedRowNum,colIndex){
////            $scope.fromPort =thirdPartyHandson.getDataAtRowProp(selectedRowNum,"fromPort");
////            $scope.toPort =thirdPartyHandson.getDataAtRowProp(selectedRowNum,"toPort");
////            var gtdata = thirdPartyHandson.getData();
////            var len = parseInt(gtdata.length);
////            if ($scope.fromPort == $scope.toPort) {
////                logger.logError("Consequtive ports are same, Please verify");
////            } else if (len > selectedRowNum + 1) {
////                thirdPartyHandson.setDataAtCell(selectedRowNum + 1, 2, $scope.toPort);
////            }
////            if ($scope.fromPort != null && $scope.fromPort != '' && $scope.toPort != null && $scope.toPort != '') {
////            var portUrl=$stateParams.tenantid+"/voyage/thirdPartyVoyage/getDistance";
////            $http({
////                method:'post',
////                url:portUrl,
////                params:{
////                    fromPort:$scope.fromPort,
////                    toPort:$scope.toPort
////                }
////            }).success(function(data){
////                if(data == '' || data == null){
////                    thirdPartyHandson.setDataAtCell(selectedRowNum,12,0,'loadData');
////                    thirdPartyHandson.setDataAtCell(selectedRowNum,13,14,'loadData');
////                    thirdPartyHandson.setDataAtCell(selectedRowNum,14,0,'loadData');
////                    thirdPartyHandson.setDataAtCell(selectedRowNum,15,0,'loadData');
////                    etdFormula(thirdPartyHandson, selectedRowNum, colIndex);
////                }
////                else{
////                thirdPartyHandson.setDataAtCell(selectedRowNum,12,data,'loadData');
////                distanceAndSpeedFormula(thirdPartyHandson, selectedRowNum, colIndex);
////                }
////            })
////            }
////    }
////    function distanceAndSpeedFormula(thirdPartyHandson, selectedRowNum, colIndex){
////        if(thirdPartyHandson.getDataAtRowProp(selectedRowNum,'distance') != '' && thirdPartyHandson.getDataAtRowProp(selectedRowNum,'speed') != '' &&
////                thirdPartyHandson.getDataAtRowProp(selectedRowNum,'speed') != 0 && thirdPartyHandson.getDataAtRowProp(selectedRowNum,'speed') != '0'){
////            thirdPartyHandson.setDataAtCell(selectedRowNum,14,'=QUOTIENT(M'+colIndex+',N'+colIndex+')','loadData');
////            thirdPartyHandson.setDataAtCell(selectedRowNum,15,'=MOD(M'+colIndex+',N'+colIndex+')','loadData');
////             }else{
////                 thirdPartyHandson.setDataAtCell(selectedRowNum,14,'=QUOTIENT(0,1)','loadData');
////                 thirdPartyHandson.setDataAtCell(selectedRowNum,15,'=MOD(0,1)','loadData');
////             }
////        etaFormula(thirdPartyHandson, selectedRowNum, colIndex);
////        timeCalculation($scope.handsonData.length);
////    }
//    
////    function timeCalculation(handsonLength){
////        var totalPortTime;
////        var totalSteamingTime;
////        var totVoyageTime;
////        var totPortHour=0;
////        var totPortMin=0;
////        var totSteamingHour=0;
////        var totSteamingMin=0;
////       
////        for(var index=0;index<handsonLength;index++){
////            
////            var nextVoyage=thirdPartyHandson.getDataAtRowProp(index,'nextVoyage');
////            if(nextVoyage=='N'){
////            
////            var portHour=thirdPartyHandson.getDataAtRowProp(index,'portStayHour');
//////            var portContHour=thirdPartyHandson.getDataAtRowProp(index,'portStayContHour');
////            var portMin=thirdPartyHandson.getDataAtRowProp(index,'portStayMin');
////            var steamingHour=thirdPartyHandson.getCell(index,14).innerHTML;
//////            var steamingContHour=thirdPartyHandson.getDataAtRowProp(index,'steamingContHour');
////            var steamingMin=thirdPartyHandson.getCell(index,15).innerHTML;
////            if(portHour != null && portHour != '' )
////                totPortHour +=parseInt(portHour);
//////            if(portContHour != null && portContHour !='')
//////                totPortHour += parseInt(portContHour);
////            if(portMin != null && portMin != '')
////                totPortMin +=parseInt(portMin);
////           if(steamingHour != null && steamingHour != '')
////               totSteamingHour += parseInt(steamingHour);
//////           if(steamingContHour != null && steamingContHour != '')
//////               totSteamingHour += parseInt(steamingContHour);
////           if(steamingMin != null && steamingMin !='')
////               totSteamingMin+=parseInt(steamingMin);
////           
////            }
////            }
////        if(totPortMin > 60){
////            totPortHour+=parseInt(totPortMin)/60;
////            totPortMin=parseInt(totPortMin)%60;
////        }
////        if(totSteamingMin > 60){
////            totSteamingHour+=parseInt(totSteamingMin)/60;
////            totSteamingMin=parseInt(totSteamingMin)%60;
////        }
////        /*$scope.totalPortStayTime='sasa';
////        $scope.totalPortStayTime=parseInt(totPortHour);*/
////        var totVoyageDays=(parseInt(totPortHour)+parseInt(totSteamingHour))/24;
////        var totVoyageHours=(parseInt(totPortHour)+parseInt(totSteamingHour))%24;
////        var totVoyageMins=parseInt(totPortMin)+parseInt(totSteamingMin);
////        if(totVoyageMins > 60){
////            totVoyageHours+=parseInt(totVoyageMins)/60;
////            totVoyageMins=parseInt(totVoyageMins)%60;
////        }
////        $('#portTime').val(parseInt(totPortHour) +" Hrs " +parseInt(totPortMin) +" Mins");
////        $('#steamingTime').val(parseInt(totSteamingHour) +" Hrs "+ parseInt(totSteamingMin) +" Mins") 
////        $('#voyageTime').val(parseInt(totVoyageDays) +" Days "+ parseInt(totVoyageHours) +" Hours "+ parseInt(totVoyageMins) +" Mins");
////       
////    }
//        
////        $scope.renderMergeCell = function(){
////            $scope.mergeCells = [];
////            $scope.mergeCells = $scope.mergeCells.concat($scope.vesselMergeCells);
////            $scope.mergeCells = $scope.mergeCells.concat($scope.voyageMergeCells);
////            isRender = false;
////            thirdPartyHandson.mergeCells = new Handsontable.MergeCells($scope.mergeCells);
////            $scope.addRowIndex = [];
////            console.log($scope.vesselMergeCells);
////            angular.forEach($scope.vesselMergeCells,function(value){
////               var addRowIndex = value.row+value.rowspan-1;
////               $scope.addRowIndex.push(addRowIndex);
////            });
////            thirdPartyHandson.render(); 
////           }
// 
//        
//        $scope.deleteRow = function(){
//            var $container = $("#scheduleVoyage");
//            var data = thirdPartyHandson.getData();
//            if (data.length > 1) {
//                thirdPartyHandson.alter('remove_row', parseInt(data.length - 1));
//            }
//            $scope.buildHandsonHeader();
//        }
//        $scope.deleteRowSpan = function(row,obj,vsl_voyage_dt_bean){
//            var index = $('.del_voyage:eq('+row+')').closest('tr').find('td[rowspan]:last').closest('tr').index()
//            if(index == -1){
//                index = $('.del_voyage:eq('+row+')').closest('tr').prevAll().find('td[rowspan]:last').last().closest('tr').index();
//            }
//            
//            var removeIndex = -1;
//            var tempIndex = 0;
//            var isContinue = true;
//            angular.forEach($scope.vesselMergeCells,function(value){
//                if(isContinue){
//                    /*alert('index '+index);*/
//                    if(parseInt(value.row) == index ){
//                        if(value.rowspan > 1){
//                            value.rowspan = value.rowspan-1;
//                            
//                            /*alert('rowspan '+value.rowspan);*/
//                            if(vsl_voyage_dt_bean.vesselCode!=''&&vsl_voyage_dt_bean.vesselCode!=null)
//                                {
//                            //thirdPartyHandson.setDataAtCell(value.row, 0,vsl_voyage_dt_bean.vesselCode);
//                            //thirdPartyHandson.setDataAtCell(value.row, 1,vsl_voyage_dt_bean.voyageId);
//                                }
//                        }else{
//                            removeIndex = tempIndex;
//                        }
//                        angular.forEach($scope.vesselMergeCells,function(value1){
//                            if(parseInt(value1.row) > index ){
//                                value1.row = value1.row-1;
//                            }
//                        });
//                        isContinue = false;
//                        
//                    }
//                }
//                tempIndex++;
//            });
//            console.log($scope.vesselMergeCells);
//            isContinue = true;
//            angular.forEach($scope.voyageMergeCells,function(value){
//                if(isContinue){
//                if(value.row == index ){
//                    if(value.rowspan > 1){
//                        value.rowspan = value.rowspan-1;
//                    }
//                    angular.forEach($scope.voyageMergeCells,function(value1){
//                        if(parseInt(value1.row) > index ){
//                            value1.row = value1.row-1;
//                        }
//                    });
//                    isContinue = false;
//                }
//                }
//            });
//            console.log($scope.vesselMergeCells)
//            if(removeIndex != -1){
//                $scope.vesselMergeCells.splice(removeIndex,1);
//                $scope.voyageMergeCells.splice(removeIndex,1);
//            }
//            if(thirdPartyHandson.countRows() != row+1){
//                thirdPartyHandson.setDataAtCell(row , 10,vsl_voyage_dt_bean.toPort);
//                 // etaFormula(thirdPartyHandson, row, row+1);
//                 
//                  for(var index=row+1;index<thirdPartyHandson.countRows();index++){
//                      var colIndex=index+1;
//                      thirdPartyHandson.setDataAtCell(index,14,'=QUOTIENT(M'+colIndex+',N'+colIndex+')','loadData');
//                      thirdPartyHandson.setDataAtCell(index,15,'=MOD(M'+colIndex+',N'+colIndex+')','loadData');
//                  }
//
//              }
//            
//        }
//            $scope.addRowSpan = function(row,obj){
//                
//                var index = $('.add_voyage:eq('+row+')').closest('tr').find('td[rowspan]:last').closest('tr').index();
//                if(index == -1){
//                    index = $('.add_voyage:eq('+row+')').closest('tr').prevAll().find('td[rowspan]:last').last().closest('tr').index();
//                }
//                var toPort = thirdPartyHandson.getDataAtRowProp(row,'toPort');
//                if(toPort != null && toPort != '')
//                  thirdPartyHandson.setDataAtCell(row+1,2,toPort,'loadData');
//                etaFormula(thirdPartyHandson, row, row+1);
////              instance.setDataAtRowProp(row+1,'voyageId',instance.getSourceDataAtRow(index).voyageId);
//                var isContinue = true;
//                console.log($scope.vesselMergeCells)
//               angular.forEach($scope.vesselMergeCells,function(value){
//                   if(isContinue == true){
//                       if(parseInt(value.row) == index ){
//                           value.rowspan = value.rowspan+1;
//                           angular.forEach($scope.vesselMergeCells,function(value1){
//                               if(parseInt(value1.row) > index ){
//                                   value1.row = value1.row+1;
//                               }
//                           });
//                           isContinue=false;
//                       }
//                   }
//                   
//                });
//               isContinue = true;
//                angular.forEach($scope.voyageMergeCells,function(value){
//                    if(isContinue == true){
//                        if(value.row == index ){
//                            value.rowspan = value.rowspan+1;
//                            angular.forEach($scope.voyageMergeCells,function(value1){
//                                if(parseInt(value1.row) > index ){
//                                    value1.row = value1.row+1;
//                                }
//                            });
//                            isContinue=false;
//                        }
//                    }
//                    
//                });
//                console.log($scope.vesselMergeCells)
//        };
//      
//    
//       
//        
//        $("#sch_end_date").on("dp.change", function(e) {
//            var from = $scope.thirdPartyHeader.schStartDate;
//            if(from != '' && from != null){
//                var dateTime=from.split(' ');
//                var time=dateTime[1].split(':')
//                var date = dateTime[0].split("/");
//                from = new Date(date[2], date[1] - 1, date[0],time[0],time[1]);
//                var to = e.date._d;
//                if (to < from) {
//                    logger.logError("End date should be greater than start Date");
//                    $scope.thirdPartyHeader.schEndDate=' ';
//                }
//            }
//
//        });
//        $("#sch_start_date").on("dp.change", function(e) {
//              var to = $scope.thirdPartyHeader.schEndDate;
//              var from = e.date._d;
//               if(from != '' && from != null){
//                      var selectedDate=$('#sch_start_date').find(':text').val();
//                      $scope.thirdPartyHeader.schStartDate=selectedDate;
//                      thirdPartyHandson.setDataAtRowProp(0,'eta',selectedDate);
//                  }
//              
//
//          });
//    }
    
    
    
    function customRenderer(instance, td) {
        $('#thirdParty thead:last th:eq(0)').css({'border-right':'0px'})
        Handsontable.renderers.TextRenderer.apply(this, arguments);
          td.style.borderRight = '0px';
        return td;
      }
    $('#thirdParty thead:last th:eq(0)').css({'border-right':'0px'})
    
    
        $scope.buildHandsonHeader =function(){
            $('table.htCore thead').html('');
            $('table.htCore thead').append('<tr></tr>')
            $('table.htCore thead').append('<tr>'
                    +'<th colspan=2>VOYAGE*</th>'
                    +'<th>FROM<br>PORT</th>'
                    +'<th>ETA*</th>'
                    + '<th colspan=2>BERTHING<br>TIME</th>' 
                    + '<th>ETB</th>'
                    +'<th colspan=2>PORT STAY</th>'
                   /* +'<th>PORT STAY<br>CONTIGENCY</th>'*/
                    +'<th>ETD</th>'
                    +'<th>TO PORT</th>'
                    +'<th> DISTANCE</th>'
                    +'<th>SPEED</th>'
                    +'<th colspan=2> STEAMING <br> TIME</th>'
               /*    +'<th>STEAMING<br>CONTIGENCY</th>'*/
                    +'<th>ROT NO</th>'
                    +'<th>Next<br>Voyage</th>'
                  +'<th>Remarks</th>'
                    +'<th></th>'
                   +'</tr>');
            $('table.htCore thead').append('<tr>'
                    +'<th></th>'
                    +'<th></th>'
                    +'<th></th>'
                    +'<th></th>'
                    +'<th>Hr</th><th>Min</th>'
                    +'<th></th>'
                    +'<th>Hr</th><th>Min</th>'
                    /*+'<th>Hr</th>'*/
                    +'<th></th>'
                    +'<th></th>'
                    +'<th></th>'
                    +'<th></th>'
                    +'<th>Hr</th><th>Min</th>'
                  /* +'<th>Hr</th>'*/              
                    +'<th></th>'
                    +'<th></th>'
                    +'<th></th>'
                      +'<th></th>'
                    +'<th></th>'
                    +'</tr>'); 
        }
  
    
 $('table.htCore thead').closest('.wtHolder').css('overflow','hidden');
    
    var vslRowObject = {row:0,col:0,rowspan:1,colspan:1};
    var vogRowObject = {row:0,col:1,rowspan:1,colspan:1};
    function vesselsumRowSpan(instance,row){
        var rowNum = row;
        var currentRowSpan = $scope.vesselMergeCells.length;
       var totalLength= $scope.handsonData.length;
       var handsonLength = instance.countRows();
      
       if(totalLength == 1){
           $scope.addRowIndex.push(row)
       }
        if(rowNum == 0){
            $scope.currentRow = {} ;
            angular.copy(vslRowObject,$scope.currentRow);
            $scope.vesselMergeCells = [];
            $scope.vesselMergeCells.push({row:0,col:0,rowspan:1,colspan:1});
        }
        else{
            if((instance.getDataAtCell(row,0)) === instance.getDataAtCell(row-1,0)){
                var rowSpan = $scope.vesselMergeCells[currentRowSpan-1].rowspan;
                rowSpan++;
                if(rowSpan <= $scope.handsonData.length)
                    $scope.vesselMergeCells[currentRowSpan-1].rowspan = rowSpan;
                
                if(totalLength == row+1){
                    $scope.addRowIndex.push(row);
                }
               }
            else {
                $scope.addRowIndex.push(row-1);
                $scope.currentRowSel = {} ;
                angular.copy(vslRowObject,$scope.currentRowSel);
                $scope.vesselMergeCells.push($scope.currentRowSel);
                $scope.vesselMergeCells[currentRowSpan].row = rowNum;
            }
        }
    }
    function voyagesumRowSpan(instance,row){
        var rowNum = row;
        var currentRowSpan = $scope.voyageMergeCells.length;
        if(rowNum == 0){
            $scope.currentRow = {} ;
            angular.copy(vogRowObject,$scope.currentRow);
            $scope.voyageMergeCells = [];
            $scope.voyageMergeCells.push($scope.currentRow);
        }
        else{
            if((instance.getDataAtCell(row,1)) === instance.getDataAtCell(row-1,1)){
                var rowSpan = $scope.voyageMergeCells[currentRowSpan-1].rowspan;
                rowSpan++;
                if(rowSpan <= $scope.handsonData.length)
                    $scope.voyageMergeCells[currentRowSpan-1].rowspan = rowSpan;
               }
            else {
                $scope.currentRowSel = {} ;
                angular.copy(vogRowObject,$scope.currentRowSel);
                $scope.voyageMergeCells.push($scope.currentRowSel);
                $scope.voyageMergeCells[currentRowSpan].row = rowNum;
            }
        }
    }
    
});


app.controller('tablectrl', function($scope,  $http, $location, logger,ngDialog, utilsService, $state, sharedProperties,
		$window, $stateParams, toaster, validationService,$controller,THIRDPARTYVOYAGEADD, $rootScope) {
//	alert(2);
    
//    $scope.getstartDate =  function(date,index){
//    	alert(index);
//    }
    
	 $scope.$watch('thirdPartyHeader.thirdPartyDetailList[trIndex].eta', function(newValue, oldValue) {
//		 alert(8);
		$scope.thirdPartyHeader.schStartDate = $scope.thirdPartyHeader.thirdPartyDetailList[0].eta;
	 });
	 $scope.$watch('thirdPartyHeader.thirdPartyDetailList[trIndex].etd', function(newValue, oldValue) {
//	 alert(9);
	 var len = $scope.thirdPartyHeader.thirdPartyDetailList.length;
	$scope.thirdPartyHeader.schEndDate = $scope.thirdPartyHeader.thirdPartyDetailList[len].etd;
}); 
});