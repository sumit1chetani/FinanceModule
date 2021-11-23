'use strict';

app.controller('blChargesListAddCtrl', function($scope, $rootScope, $http, $location, logger, ngDialog,
        utilsService,$state,sharedProperties,$window,$stateParams,toaster,validationService) {
	
	$scope.blchargedetailList=[];
    $scope.isEdit = false;
    $scope.update = false;

    //Static Drop Down
    $scope.imp_exp = [
        {id: 'import', text: 'Import'},
       {id: 'export', text: 'Export'},
       {id: 'both', text: 'Both'}
     ];
    
    $scope.yes_no = [
        {id: 'yes', text: 'Yes'},
       {id: 'no', text: 'No'}
     ];

    
    $scope.blchargesAdd={
    		chargeCode: '',
    		seq: '',
    		importExport: '',
    		line: '',
    		port: '',
    		portTo: '',
    		chargeItem: '',
    		is_deposit: '',
    		applyDate: '',
    		validity: '',
    		baseOn: '',
    		currency: '',
    		defaultAmount: '',
    		divideinLCL: '',
    		condition: '',
    		tax: '',
    		toll: '',
    		description: '',
    		client: '',
    		blChargeId: '',
    		blchargedetailList:[]
    }


$scope.tempblchargedetailList={
		 select:false,
		 cntrType: '',
		 isFull: '',
		 soc: '',
		 shipmentType: '',
		 imco: '',
		 _20Inch: '',
		 _40Inch: '',
		 _45Inch: ''
}
    
    $scope.$watchCollection('[ blchargesAdd.validity]',function(newValue, oldValue) {
		if ($scope.blchargesAdd.validity != '') {
			var frmDate = $scope.blchargesAdd.applyDate;
			var toDate = $scope.blchargesAdd.validity;
			var splitarray = new Array();
			splitarray = frmDate.split(" ");
			var date = splitarray[0];
			var time = splitarray[1];
			frmDate = date.split("/");
			frmDate = new Date(frmDate[2],
					frmDate[1] - 1, frmDate[0]);
			toDate = toDate.split("/");
			toDate = new Date(toDate[2],
					toDate[1] - 1, toDate[0]);
			if ( frmDate>toDate ) {
				logger
						.logError(" Validity Date should  be greater than Apply Date");
				$scope.blchargesAdd.validity = '';
			}
		}
	});
    
//List Function
 $scope.find=function(chargeCode){
	 if(!chargeCode==null||!chargeCode==undefined||!chargeCode==''){
        $http.get($stateParams.tenantid+'/api/blcharges/list?chargeCode=' +chargeCode).success(function(datas) {
        	console.log(datas);
            $scope.rowCollection = datas;
        	}).error(function(datas) {
     }); 
        } else {
    	 logger.logError("Please choose the charge code! ");
    	 }
  };
  
//Delete Function
$scope.deleteRow = function(blChargeId) {
    ngDialog.openConfirm().then(function() {
    	var url = $stateParams.tenantid+'/api/blcharges/delete?blChargeId=' + blChargeId;
        $http.get(url).success(function(result){
            if (result.isSuccess ==  true) {
                logger.logSuccess("Deleted successfully");
                $state.reload();
           } else {
                logger.logError("You Can't Delete this Record, Related Data Exist! ");
            }
        }).error(function(result) {
            logger.logError("Error Please Try Again");
        });
    }, function(reason) {
        console.log('Modal promise rejected. Reason: ', reason);
    });
};

$scope.addCredRow = function() {
	  var tmp=angular.copy($scope.tempblchargedetailList);
	  $scope.blchargesAdd.blchargedetailList.push(tmp);
}
$scope.addCredRow();

$scope.removeCredRow =function(){
	var count =0;
		var tmpDelList = [];
		for(var i=$scope.blchargesAdd.blchargedetailList.length-1;i>=0;i--){
			if($scope.blchargesAdd.blchargedetailList[i].select==true){
				count++;
				tmpDelList.push($scope.blchargesAdd.blchargedetailList[i]);
				$scope.blchargesAdd.blchargedetailList.splice(i, 1);
			}
		}
		for(var i=0;i<$scope.blchargesAdd.blchargedetailList.length;i++){
			$scope.blchargesAdd.blchargedetailList[i].portSeq=i+1;
		}
		if(count>0){
			logger.logSuccess('Deleted Successfully');	
		}else{
			logger.logError('Please select the row to delete!');
		}
}


//save
$scope.save = function(blChargesForm,blchargesAdd) {
	if (new validationService().checkFormValidity($scope.blChargesForm)) {
        $http.post($stateParams.tenantid+'/api/blcharges/add',blchargesAdd).success(function(data) {
            console.log("data" + data);
            if (data.isSuccess) {
                logger.logSuccess("Saved successfully!");
                $scope.reset();
            } else {
                logger.logError("Error!!");
            }
        }).error(function(result) {
            console.log("data" + data);
        });
	} else {
        toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.blChargesForm.$validationSummary), 555000, 'trustedHtml');
    }
    
 };
 
 //Update function
 $scope.update = function(blChargesForm,blchargesAdd) {
     if (new validationService().checkFormValidity($scope.blChargesForm)) {
          $scope.blchargesAdd.blChargeId = $location.search().blChargeId;
          $http.post($stateParams.tenantid+'/api/blcharges/update', $scope.blchargesAdd).success(function(result) {
             if (result) {
                 logger.logSuccess("Updated successfully!");
                 $scope.update=true;
                 $scope.reset();
             } else {
                 logger.logError("Error in update!");
             }
         }).error(function(data) {
             console.log("data" + data);
         });

     } else {
         toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.departmentAddForm.$validationSummary), 555000, 'trustedHtml');
     }
 };
 
//Edit Functionality
 $scope.editRow = function(blChargeId) {
 	debugger
     $location.url($stateParams.tenantid+'/documentation/blcharges/edit?blChargeId='+blChargeId);

 //Fetch Values
 $scope.isEdit = false;
 var blChargeId = $location.search().blChargeId;
 if (blChargeId == undefined) {
//     var deptName = $scope.departmentData.deptName;
//     var deptHeadName = $scope.departmentData.deptHeadName;
 //
//     var deptDesc = $scope.departmentData.deptDesc;
//     var deptHead = $scope.departmentData.deptHead;
//     var isActive = $scope.departmentData.isActive;
//     $scope.departmentData.isEdit = false;
 } else {
     $http.get($stateParams.tenantid+'/api/blcharges/edit?blChargeId=' +blChargeId).success(function(result) {

         if (result.isEdit == false) {
             logger.logError("Please Try Again");
         } else {
//         	$scope.vesselsailing.vessel=result.vessel;
//         	$scope.vesselsailing.voyage=result.voyage;
//         	$scope.vesselsailing.port =result.port;
//         	$scope.vesselsailing.sail_Date=result.sail_Date;
        	 $scope.blchargesAdd=result;
          $scope.isEdit=true;
         }
     }).error(function(data) {
         console.log("data" + data);
     });
 }
 };
 //reset
 $scope.reset = function() {
	 var blChargeId = $location.search().blChargeId;
	 if (blChargeId == undefined||$scope.update==true) {
		 $scope.blchargesAdd={
		    		seq: '',
		    		importExport: '',
		    		line: '',
		    		port: '',
		    		portTo: '',
		    		is_deposit: '',
		    		applyDate: '',
		    		validity: '',
		    		baseOn: '',
		    		currency: '',
		    		defaultAmount: '',
		    		divideinLCL: '',
		    		condition: '',
		    		tax: '',
		    		toll: '',
		    		description: '',
		    		client: '',
		    		blChargeId: '',
		    		blchargedetailList:[{
		    			 select:false,
		    			 cntrType: '',
		    			 isFull: '',
		    			 soc: '',
		    			 shipmentType: '',
		    			 imco: '',
		    			 _20Inch: '',
		    			 _40Inch: '',
		    			 _45Inch: ''
		    	}]
		    }
	 } else {
		 $http.get($stateParams.tenantid+'/api/blcharges/edit?blChargeId=' +blChargeId).success(function(result) {

	         if (result.isEdit == false) {
	             logger.logError("Please Try Again");
	         } else {
//	         	$scope.vesselsailing.vessel=result.vessel;
//	         	$scope.vesselsailing.voyage=result.voyage;
//	         	$scope.vesselsailing.port =result.port;
//	         	$scope.vesselsailing.sail_Date=result.sail_Date;
	        	 $scope.blchargesAdd=result;
	         	$scope.isEdit=true;
	         }
	     }).error(function(data) {
	         console.log("data" + data);
	     });
	 }

 }

/*$scope.cancel = function() {
    $state.go('app.master.voyage.list',{tenantid:$stateParams.tenantid});
};*/

//Dropdown for Selectivity
$http.post($stateParams.tenantid+'/api/blcharges/dropdown').success(function(data) {
		$scope.chargeCode=data.listChargeCode;
  		$scope.importExport=data.listImportExport;
  		$scope.line=data.listLine;
  		$scope.port=data.listPort;
  		$scope.portTo=data.listPortTo;
  		$scope.chargeItem=data.listChargeItem;
  		$scope.baseOn=data.listBaseOn;
  		$scope.currency=data.listCurrency;
  		$scope.condition=data.listCondition;
  		$scope.client=data.listClient;
  		$scope.cntrType=data.listCntrType;
  		$scope.shipmentType=data.listShipmentType;
  });

$scope.changecolor=function(id){
    $('#'+id+' .selectivityId').find('input').css("border-color", "red");;

}
$scope.clearcolor=function(id){
    $('#'+id+' .selectivityId').find('input').css("border-color", "#e8dddd");;

}	

});

