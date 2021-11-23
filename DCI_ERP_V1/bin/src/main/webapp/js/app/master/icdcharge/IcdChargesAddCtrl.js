
app.controller('IcdChargesAddCtrl', function($scope, $rootScope, $http, $location, logger, ngDialog,
        utilsService,$state,sharedProperties,$window,$stateParams,toaster,validationService) {

	$scope.icdDtl=[];
    $scope.isEdit = false;

    $scope.icd = {
    		icdNo:'',
			agent : '',
			pod : '',
			pol : '',
            surcharge:'',
			fromDate : '',
			toDate : '',
			icdDtl : [],


		}

		$scope.tempIcdDtl = {
    		dock:"",
			berth : "",
			containerType : "",
			hazardous : "",
            stuffing: "",
			currency: "",
			amount: "",
			transport: "",
			select : false
		}
$scope.addCredRow = function() {
	   
	  var tmp=angular.copy($scope.tempIcdDtl);
		$scope.icd.icdDtl.push(tmp);

}
$scope.addCredRow();



$scope.removeCredRow =function(){
	ngDialog.openConfirm().then(function() {
		var tmpDelList = [];
		for(var i=$scope.icd.icdDtl.length-1;i>=0;i--){
			if($scope.icd.icdDtl[i].select==true){
				tmpDelList.push($scope.icd.icdDtl[i]);
				$scope.icd.icdDtl.splice(i, 1);
			}
		}
	})
}
$http.get($stateParams.tenantid+ '/api/icdcharges/getlcNo').success(function(data) {
	console.log(data);
$scope.icd.lcNo = data.lcNo;
});
// Dropdown for Selectivity
$http.post($stateParams.tenantid+ '/api/containerOnHire/dropDownList').success(function(data) {

					$scope.containerType = data.listContainerTypeList;

				});
$http.post($stateParams.tenantid+ '/api/localcharges/dropDown').success(function(data) {

	$scope.dockList = data.getdocklist;
	$scope.berthList = data.getberthlist;
	  $scope.surchargeList=data.getsurchargelist	;
	  $scope.agentList=data.getagencylist	;
	  $scope.stuffList=data.getstufflist;

});


//dropdown


$http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(datas) {
	
	  $scope.currencyList=datas.getcurrencylist	;

	//logger.logSuccess('Mail Sent Successfully!')


});

$scope.transportList=[ 
              {id: 'Road', text: 'Road'},
              {id: 'Rail', text: 'Rail'},
               {id: 'Air', text: 'Air'},

            ];

	

  $scope.getDropdownvalue = function() {
    	
    	$http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(datas) {
  		  $scope.portlist =datas.getportlist;
  	}).error(function(datas) {

  	});
     
        $http.get($stateParams.tenantid+'/api/vesselsailing/vessellist').success(function(datas) {
            $scope.vessellist = datas;
        }).error(function(datas) {
        });

    }
    $scope.getDropdownvalue();

    //date validation
	$scope.$watchCollection('[ icd.fromDate]',function(newValue, oldValue) {
		if ($scope.icd.toDate!= '') {
			var frmDate = $scope.icd.fromDate;
			var toDate = $scope.icd.toDate;
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
						.logError(" From Date should  be lesser than To Date");
				$scope.icd.fromDate = "";
			}
		}
	});
	$scope.$watchCollection('[ icd.toDate]',function(newValue, oldValue) {
						if ($scope.icd.fromDate != '') {
							var frmDate = $scope.icd.fromDate;
							var toDate = $scope.icd.toDate;
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
							if (toDate <frmDate) {
								logger.logError(" To Date should  be greater than From Date");
								$scope.icd.toDate = "";
							}
						}
					});
//save
$scope.save = function(icdForm,icd) {
   if (new validationService().checkFormValidity($scope.icdForm)) {
//	$scope.container.containerDtl=$scope.rowCollection;
        $http.post($stateParams.tenantid+'/api/icdcharges/save',icd).success(function(data) {
            console.log("data" + data);
            if (data.isSuccess) {
                logger.logSuccess("Saved successfully!");
                $state.go('app.master.icdcharge.list');
            } else {
                logger.logError("Error!!");
            }
        }).error(function(result) {
            console.log("data" + data);
        });
    } else {
      toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.icdForm.$validationSummary), 555000, 'trustedHtml');
   }
    
 };
 
//Fetch Values
 $scope.isEdit = false;
 var icdNo = $location.search().icdNo;
 if (icdNo == undefined) {

 } else {

     $http.get($stateParams.tenantid+'/api/icdcharges/edit?icdNo=' +icdNo).success(function(result) {

         if (result.isEdit == false) {
             logger.logError("Please Try Again");
         } else {

        	 $scope.icd=result;
         	$scope.isEdit=true;
         }
     }).error(function(data) {
         console.log("data" + data);
     });
 }
//update
 $scope.update = function(icdForm, icd) {
     if (new validationService().checkFormValidity($scope.icdForm)) {
          $scope.icd.lcNo = $location.search().lcNo;
          
         $http.post($stateParams.tenantid+'/api/icdcharges/update', $scope.icd).success(function(result) {
             if (result) {
                 logger.logSuccess("Updated successfully!");
                 $state.go('app.master.icdcharge.list',{tenantid:$stateParams.tenantid});
             } else {
                 logger.logError("Error in update!");
             }
         }).error(function(data) {
             console.log("data" + data);
         });

     } else {
        toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.icdForm.$validationSummary), 555000, 'trustedHtml');
    }
 };
    
     
$scope.cancel = function() {
    $state.go('app.master.icdcharge.list',{tenantid:$stateParams.tenantid});
};


//reset
$scope.reset = function(icd) {
	 if (icdNo == undefined) {
		 
	
		 $scope.icd={
					icdNo:'',
					agent : '',
					pol : '',
					pod: '',
					surcharge:'',
					fromDate : '',
					toDate : '',
					icdDtl : [],
				
			}

	 } else {
	     $http.get($stateParams.tenantid+'/api/icdcharges/edit?icdNo=' +icdNo).success(function(result) {

	         if (result.isEdit == false) {
	             logger.logError("Please Try Again");
	         } else {

	        	 $scope.icd=result;
	         	$scope.isEdit=true;
	         }
	     }).error(function(data) {
	         console.log("data" + data);
	     });
	 }
}


	
});

