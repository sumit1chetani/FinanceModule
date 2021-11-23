
app.controller('voyageAddCtrl', function($scope, $rootScope, $http, $location, logger, ngDialog,
        utilsService,$state,sharedProperties,$window,$stateParams,toaster,validationService) {
	
	$scope.voyagedetailList=[];
    $scope.isEdit = false;

$scope.voyageAdd={
		voyageid: '',
		vesselCode:'',
		vessel:'',
		voyageCode:'',
		voyagedetailList:[]
}
var index = $scope.voyageAdd.voyagedetailList;
index = 0;

$scope.tempvoyagedetailList={
		 select:false,
		 portCode : "",
		 portSeq:index,
		 eta:null,
		 ata:null,
		 etd:null,
		 atd:null,
		 cutoffdt:null,
		 rotationNo : '',
		 vesselsailing_id:false
}
$scope.addCredRow = function() {
	  var tmp=angular.copy($scope.tempvoyagedetailList);
	  if($scope.isEdit==false){
		  var index = $scope.voyageAdd.voyagedetailList.length;
	  tmp.portSeq=++index;
	  } else if($scope.isEdit==true){
		  var index = $scope.voyageAdd.voyagedetailList.length;
		  tmp.portSeq=++index;
	  }
	  $scope.voyageAdd.voyagedetailList.push(tmp);
}
$scope.addCredRow();

$scope.removeCredRow =function(){
	var count =0;
	ngDialog.openConfirm().then(function() {
		var tmpDelList = [];
		for(var i=$scope.voyageAdd.voyagedetailList.length-1;i>=0;i--){
			if($scope.voyageAdd.voyagedetailList[i].select==true){
				count++;
				tmpDelList.push($scope.voyageAdd.voyagedetailList[i]);
				$scope.voyageAdd.voyagedetailList.splice(i, 1);
			}
		}
		for(var i=0;i<$scope.voyageAdd.voyagedetailList.length;i++){
			$scope.voyageAdd.voyagedetailList[i].portSeq=i+1;
		}
		if(count>0){
			logger.logSuccess('Deleted Successfully');	
		}else{
			logger.logError('Please select the row to delete!');
		}
	})
}
//save
$scope.save = function(voyageForm,voyageAdd) {
	if (new validationService().checkFormValidity($scope.voyageForm)) {
		var countves = $scope.voyageAdd.vesselCode.length + 1;
		var countvoy = $scope.voyageAdd.voyageCode.length;
		var count = countves + countvoy;
		var count1 = 0;
		if(count<=20){
			for(i=0;i<$scope.voyageAdd.voyagedetailList.length;i++){
				if(($scope.voyageAdd.voyagedetailList[i].eta != null && $scope.voyageAdd.voyagedetailList[i].eta != "") &&
				   ($scope.voyageAdd.voyagedetailList[i].etd != null && $scope.voyageAdd.voyagedetailList[i].etd != "")){
					
						count1++
				}
				
			}
			
			if($scope.voyageAdd.voyagedetailList.length==count1){
				$http.post($stateParams.tenantid+'/api/voyagemaster/create',voyageAdd).success(function(data) {
		            console.log("data" + data);
		            if (data.isSuccess) {
		                logger.logSuccess("Saved Successfully!");
		                $state.go('app.master.voyage.list');
		            } else {
		                logger.logError(data.message);
		            }
		        }).error(function(result) {
		            console.log("data" + data);
		        });
			}else{
				logger.logError("ETA & ETD Should not be Empty..!");
			}		 
		
	}
		else {
            logger.logError("Voyage Code - Maximum Char Length Should not Exceed 20!");
        }
	} else {
        toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.departmentAddForm.$validationSummary), 555000, 'trustedHtml');
    }
    
 };
 //reset
 $scope.reset = function(voyageAdd) {
	 var voyageid = $location.search().voyageid;
	 if (voyageid == undefined) {
	 $scope.voyageAdd={
			 voyageid: '',
				vesselCode:'',
				vessel:'',
				voyageCode:'',
				voyagedetailList:[{
					select:false,
					 portCode : "",
					 portSeq:++index,
					 eta:'',
					 ata:'',
					 etd:'',
					 atd:'',
					 rotationNo : '',
					 vesselsailing_id:false
				}]
		}
	 } else {
		 $http.get($stateParams.tenantid+'/api/voyagemaster/edit?voyageid=' +voyageid).success(function(result) {

	         if (result.isEdit == false) {
	             logger.logError("Please Try Again");
	         } else {
//	         	$scope.vesselsailing.vessel=result.vessel;
//	         	$scope.vesselsailing.voyage=result.voyage;
//	         	$scope.vesselsailing.port =result.port;
//	         	$scope.vesselsailing.sail_Date=result.sail_Date;
	        	 $scope.voyageAdd=result;
	         	$scope.isEdit=true;
	         }
	     }).error(function(data) {
	         console.log("data" + data);
	     });
	 }

 }
//Fetch Values
 $scope.isEdit = false;
 var voyageid = $location.search().voyageid;
 if (voyageid == undefined) {
//     var deptName = $scope.departmentData.deptName;
//     var deptHeadName = $scope.departmentData.deptHeadName;
//
//     var deptDesc = $scope.departmentData.deptDesc;
//     var deptHead = $scope.departmentData.deptHead;
//     var isActive = $scope.departmentData.isActive;
//     $scope.departmentData.isEdit = false;
 } else {
     $http.get($stateParams.tenantid+'/api/voyagemaster/edit?voyageid=' +voyageid).success(function(result) {

         if (result.isEdit == false) {
             logger.logError("Please Try Again");
         } else {
//         	$scope.vesselsailing.vessel=result.vessel;
//         	$scope.vesselsailing.voyage=result.voyage;
//         	$scope.vesselsailing.port =result.port;
//         	$scope.vesselsailing.sail_Date=result.sail_Date;
        	 $scope.voyageAdd=result;
         	$scope.isEdit=true;
         }
     }).error(function(data) {
         console.log("data" + data);
     });
 }

 $scope.update = function(voyageForm,voyageAdd) {


     if (new validationService().checkFormValidity($scope.voyageForm)) {
          $scope.voyageAdd.voyageid = $location.search().voyageid;
          
          var msg=$scope.checkValidation();
			if(!$scope.checkundefined(msg)){   
				logger.logError(msg);
			}else{
          
           
        	  $http.post($stateParams.tenantid+'/api/voyagemaster/update', $scope.voyageAdd).success(function(result) {
                  if (result) {
                      logger.logSuccess("Updated Successfully!");
                      $state.go('app.master.voyage.list',{tenantid:$stateParams.tenantid});
                  } else {
                      logger.logError("Error in Update");
                  }
              }).error(function(data) {
                  console.log("data" + data);
              });  
          } 
         

     } else {
         toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.departmentAddForm.$validationSummary), 555000, 'trustedHtml');
     }
 };
     
 $scope.checkundefined = function(value) {
	    var invalid = false;
	    if (value == undefined || value == 'undefined' || value == null || value == 'null' || value == '') {
	        invalid = true;
	    }
	    return invalid;

	}

	$scope.changecolor = function(id) {
		$('#' + id + ' .selectivityId').find('input').css(
				"border-color", "red");
	}

	$scope.changecolor = function(id) {
		$('#' + id + ' .selectivityId').find('input').css(
				"border-color", "red");

	}
	$scope.clearcolor = function(id) {
		$('#' + id + ' .selectivityId').find('input').css(
				"border-color", "#e8dddd");

	}

	
	$scope.checkValidation = function() {

	    var alertmsg = "<ui><h4 backgroundcolor=green>Please fill the required fields</h4>";
	    var msg = "";
	     
	  	    angular.forEach($scope.voyageAdd.voyagedetailList, function(row, index) {     

	  	    	if(row.vesselsailing_id == false){
	  	    		
	  	    	
	        if ($scope.checkundefined(row.eta)) {
	            msg = msg + "<li>Row :" + (index + 1) + "# ETA :Field is required.</li>";
	            $scope.changecolor('unit'+index);
	        }else{
	        	$scope.clearcolor('unit'+index);
	        }
	        
	        if ($scope.checkundefined(row.etd)) {
	            msg = msg + "<li>Row :" + (index + 1) + "# ETD :Field is required.</li>";
	            $scope.changecolor('unit'+index);
	        }else{
	        	$scope.clearcolor('unit'+index);
	        }
	        
	  	    	}
	  
	        
	    });
	    alertmsg = alertmsg + msg + "</ui>";
	    if ($scope.checkundefined(msg)) {
	        return '';
	    } else {
	        return alertmsg;
	    }

	}
 
 
 
 
 
 
$scope.cancel = function() {
    $state.go('app.master.voyage.list',{tenantid:$stateParams.tenantid});
};

//Dropdown for Selectivity
$http.get($stateParams.tenantid+'/app/seaquotation/getiataList').success(function(datas) {
	debugger
    $scope.portCode = datas.commonUtilityBean;	    

}).error(function(data) {

});


$http.get($stateParams.tenantid+'/app/commonUtility/getService').success(function(data) {
	$scope.servicelist = data;
});
  



$http.post($stateParams.tenantid+'/api/voyagemaster/dropDownList').success(function(data) {
		$scope.vesselCode=data.listvesselCode_Name;
  		//$scope.portCode=data.listportCode_Type;
  });

$scope.changecolor=function(id){
    $('#'+id+' .selectivityId').find('input').css("border-color", "red");;

}
$scope.clearcolor=function(id){
    $('#'+id+' .selectivityId').find('input').css("border-color", "#e8dddd");;

}	
$scope.isEdit=false;
var voyageid = $location.search().voyageid;
if(voyageid != null){
	  $scope.isEdit=true;
    
	  $http.post($stateParams.tenantid+'/api/voyagemaster/view?voyageid=' +voyageid).success(function(result) {
        
        if (result.isEdit == false) {
            logger.logError("Please Try Again");
        } else {
        	$scope.voyageAdd=result;
           $scope.check = true;
        }
          
       }).error(function(data) {

       });
}

});