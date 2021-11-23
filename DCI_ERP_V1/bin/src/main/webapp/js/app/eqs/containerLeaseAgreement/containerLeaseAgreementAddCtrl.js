
app.controller('containerLeaseAgreementAddCtrl', function($scope, $rootScope, $http, $location, logger, ngDialog,
        utilsService,$state,sharedProperties,$window,$stateParams,toaster,$timeout,validationService) {

	$scope.leaseAgreementDtl=[];
    $scope.isEdit = false;

$scope.leaseAgreement={
		agreementParty:'',
		agreementType:'',
		agreementRefNo:'',
		currency:'',
		fromDate:'',
		toDate:'',
		leaseAgreementParty:'',
		partyAgreementNo:'',
		leaseAgreementDtl : []
	
}



$scope.templeaseAgreementDtl={
		country:'', 
		port:'',
		returnport:'',
		 containerType : "",
		 noOfContainer:'',
		 rental:'',
		 pickupCharge:'',
		 dropupCharge:'',
		// handleCharge:'',
		// tax:'',
		// puCredit:'',
		// doCredit:'',
		// diCharge:'',
		select:false,
		replacementValue:'',
		portList : [],
		returnportList : []
}

var today = new Date();
var dd = today.getDate();
var mm = today.getMonth() + 1; // January is 0!
var yyyy = today.getFullYear();
if (dd < 10) {
	dd = '0' + dd
}
if (mm < 10) {
	mm = '0' + mm
}

$scope.leaseAgreement.fromDate = dd + '/' + mm + '/'+ yyyy;
$scope.leaseAgreement.toDate = dd + '/' + mm + '/'+ yyyy;


$scope.$watch('leaseAgreement.toDate',function(newvalue, oldvalue) {
	debugger;
			if ($scope.leaseAgreement.toDate != null
					&& $scope.leaseAgreement.toDate != '' 
					&& $scope.leaseAgreement.fromDate != null
					&& $scope.leaseAgreement.fromDate != "") {
				var requestDtAry = $scope.leaseAgreement.toDate.split('/');
				var oldDateAry = $scope.leaseAgreement.fromDate.split('/');
				var requestDtObj = new Date(
						requestDtAry[2],
						requestDtAry[1] - 1,
						requestDtAry[0]);
				var oldDateObj = new Date(
						oldDateAry[2],
						oldDateAry[1] - 1,
						oldDateAry[0]);
				
				if (requestDtObj < oldDateObj) {
					$scope.leaseAgreement.toDate ="";
					logger.logError("To Date should be greater than From Date - "+$scope.leaseAgreement.fromDate+" ..!!");
				}

			}
});
$scope.getcountryList=function(){
   	
   	$http.get($stateParams.tenantid+'/api/portform/countrylist').success(function(datas) {
    	console.log(datas);
        $scope.countrylist = datas;
   	console.log("portList");
   	console.log( $scope.countrylist);
   	$timeout(function() {
   	 $('.datetimepicker_country').each(function(){ 
   		$(this).find("select").multiselect({
   		maxHeight: 100, 
   		includeSelectAllOption: true,
   		selectAllText : 'Select All',
   		enableFiltering : true,	
   		/*disableIfEmpty: true,*/
   		enableCaseInsensitiveFiltering: true,
   		numberDisplayed: 1,
   		onDropdownHide: function (event) {

   		}
   		});
   		$(this).find("#multiselect-button").addClass("width_100 input-sm line-height-5");
   		});
   	 

   	 }, 2, false);
   	
   	});

   	};
   	$scope.getcountryList();
   	




$scope.show=false;	

 var values="";
$scope.countryport=function(row, trIndex){
	values = row.country;
	var countryvalues="";
	if(values!=undefined){
		for(var i=0;i<values.length;i++){
			if(countryvalues==""){
				countryvalues="'"+values[i].id+"'";
			}else{
				countryvalues+=",'"+values[i].id+"'";
			}
			
		}
	}
	
	if(countryvalues !="" ){
		$scope.port=[];
		$scope.show=true;
		$.ajax({
            type : "GET",
            url : $stateParams.tenantid+'/api/containerLeaseAgreementType/countryport?countryvalues=' +countryvalues,
            data : "",
            async: false,
            contentType: false,
            processData: false,
            success : function(response) {
                if(response.portList!=null){
                	row.portList=response.portList;
                	row.returnportList=response.portList;
                	$timeout(function() {
                		$('#port'+trIndex).multiselect('destroy')
                	   		$('#port'+trIndex).multiselect({
                	   		maxHeight: 100, 
                	   		includeSelectAllOption: true,
                	   		selectAllText : 'Select All',
                	   		enableFiltering : true,	
                	   		enableCaseInsensitiveFiltering: true,
                	   		numberDisplayed: 1,
                	   		onDropdownHide: function (event) {

                	   		}
                	   		});
                	   		$('#port'+trIndex).find("#multiselect-button").addClass("width_100 input-sm line-height-5");
                	   	 

                	   	 }, 2, false);
                	
                	$timeout(function() {
                		$('#returnport'+trIndex).multiselect('destroy')
                	   		$('#returnport'+trIndex).multiselect({
                	   		maxHeight: 100, 
                	   		includeSelectAllOption: true,
                	   		selectAllText : 'Select All',
                	   		enableFiltering : true,	
                	   		enableCaseInsensitiveFiltering: true,
                	   		numberDisplayed: 1,
                	   		onDropdownHide: function (event) {

                	   		}
                	   		});
                	   		$('#returnport'+trIndex).find("#multiselect-button").addClass("width_100 input-sm line-height-5");
                	   	 

                	   	 }, 2, false);
                }
                    
               
            }
        });
	}else{
		row.portList = [];
		row.returnportList = [];
		$timeout(function() {
		$('#port'+trIndex).multiselect('destroy')
   		$('#port'+trIndex).multiselect({
   		maxHeight: 100, 
   		includeSelectAllOption: true,
   		selectAllText : 'Select All',
   		enableFiltering : true,	
   		enableCaseInsensitiveFiltering: true,
   		numberDisplayed: 1,
   		onDropdownHide: function (event) {

   		}
   		});
   		$('#port'+trIndex).find("#multiselect-button").addClass("width_100 input-sm line-height-5");
		});
		
		$timeout(function() {
			$('#returnport'+trIndex).multiselect('destroy')
	   		$('#returnport'+trIndex).multiselect({
	   		maxHeight: 100, 
	   		includeSelectAllOption: true,
	   		selectAllText : 'Select All',
	   		enableFiltering : true,	
	   		enableCaseInsensitiveFiltering: true,
	   		numberDisplayed: 1,
	   		onDropdownHide: function (event) {

	   		}
	   		});
	   		$('#returnport'+trIndex).find("#multiselect-button").addClass("width_100 input-sm line-height-5");
			});
	}
	
	
	
	
}


$scope.addCredRow = function() {
	   
	  var tmp=angular.copy($scope.templeaseAgreementDtl);
		$scope.leaseAgreement.leaseAgreementDtl.push(tmp);
		
	 	$scope.getcountryList();
	 	//$scope.countryport();
	 	$timeout(function() {
   	   	 $('.datetimepicker_port').each(function(){ 
   	   		$(this).find("select").multiselect({
   	   		maxHeight: 200, 
   	   		includeSelectAllOption: true,
   	   		selectAllText : 'Select All',
   	   		enableFiltering : true,	
   	   		enableCaseInsensitiveFiltering: true,
   	   		numberDisplayed: 1,
   	   		onDropdownHide: function (event) {

   	   		}
   	   		});
   	   		$(this).find("#multiselect-button").addClass("width_100 input-sm line-height-5");
   	   		});
   	   	 

   	   	 }, 2, false);
	 	
	 	$timeout(function() {
	   	   	 $('.datetimepicker_returnport').each(function(){ 
	   	   		$(this).find("select").multiselect({
	   	   		maxHeight: 200, 
	   	   		includeSelectAllOption: true,
	   	   		selectAllText : 'Select All',
	   	   		enableFiltering : true,	
	   	   		enableCaseInsensitiveFiltering: true,
	   	   		numberDisplayed: 1,
	   	   		onDropdownHide: function (event) {

	   	   		}
	   	   		});
	   	   		$(this).find("#multiselect-button").addClass("width_100 input-sm line-height-5");
	   	   		});
	   	   	 

	   	   	 }, 2, false);

}
$scope.addCredRow();  	
   	
   	
   	





$scope.removeCredRow =function(){
	var count =0;
	ngDialog.openConfirm().then(function() {
		var tmpDelList = [];
		for(var i=$scope.leaseAgreement.leaseAgreementDtl.length-1;i>=0;i--){
			if($scope.leaseAgreement.leaseAgreementDtl[i].select==true){
				count++;
				tmpDelList.push($scope.leaseAgreement.leaseAgreementDtl[i]);
				$scope.leaseAgreement.leaseAgreementDtl.splice(i, 1);
			}
		}
		if(count>0){
			logger.logSuccess('Deleted Successfully');	
		}else{
			logger.logError('Please select the row to delete!');
		}

	})
}


/*$http.post($stateParams.tenantid+'/app/commonUtility/getPortByEmpAgn').success(function(data) {
	  	
		$scope.port=data;
		        		
});*/

$scope.$watchCollection('[leaseAgreement.fromDate,leaseAgreement.toDate]', function(newValue, oldValue) {
	 if($scope.leaseAgreement.fromDate != null && $scope.leaseAgreement.fromDate != '' && $scope.leaseAgreement.fromDate != undefined 
		        && $scope.leaseAgreement.toDate != null && $scope.leaseAgreement.toDate != '' && $scope.leaseAgreement.toDate != undefined){
		 noOfDays = moment($scope.leaseAgreement.toDate, 'DD/MM/YYYY').diff(moment($scope.leaseAgreement.fromDate, 'DD/MM/YYYY'), 'days');
		 if(noOfDays<0){
			 logger.logError("'To Date' should be greater than 'From Date'!");
			 $scope.leaseAgreement.toDate = "";
		 }
	 }
});

$http.get($stateParams.tenantid+'/api/containerLeaseAgreementType/getAgreementRefNo').success(function(data) {

	console.log(data);
	$scope.leaseAgreement.agreementRefNo = data.agreementRefNo;
	});
//save
$scope.save = function(LeaseAgreementForm,leaseAgreement) {
	if (new validationService().checkFormValidity($scope.LeaseAgreementForm)) {
		if(leaseAgreement.leaseAgreementDtl!=null){
			for(var c=0;c<leaseAgreement.leaseAgreementDtl.length;c++){
				$scope.countrylist1=[];
				$scope.portlist1=[];
				$scope.returnportlist1=[];
				$scope.countrylist1=leaseAgreement.leaseAgreementDtl[c].country;
				$scope.portlist1=leaseAgreement.leaseAgreementDtl[c].port;
				$scope.returnportlist1=leaseAgreement.leaseAgreementDtl[c].returnport;
				var clValues="",plValues="";rplValues="";
				for(var cl=0;$scope.countrylist1.length>cl;cl++){
					if(clValues==""){
						clValues=$scope.countrylist1[cl].id;
					}else{
						clValues+=","+$scope.countrylist1[cl].id;
					}
					
				}
				for(var pl=0;$scope.portlist1.length>pl;pl++){
					if(plValues==""){
						plValues=$scope.portlist1[pl].id;
					}else{
						plValues+=","+$scope.portlist1[pl].id;
					}
					
				}
				for(var rpl=0;$scope.returnportlist1.length>rpl;rpl++){
					if(rplValues==""){
						rplValues=$scope.returnportlist1[rpl].id;
					}else{
						rplValues+=","+$scope.returnportlist1[rpl].id;
					}
					
				}
				$scope.leaseAgreement.leaseAgreementDtl[c].country=clValues;
				$scope.leaseAgreement.leaseAgreementDtl[c].port=plValues;
				$scope.leaseAgreement.leaseAgreementDtl[c].returnport=rplValues;
			}
		}else{
			
		}
		
		var checkcountry=false;checkport=false;checkreturnport=false;
		for(var pl=0;$scope.leaseAgreement.leaseAgreementDtl.length>pl;pl++){
				if($scope.leaseAgreement.leaseAgreementDtl[pl].country==""){
					checkcountry = true;
					break;
				}else if ($scope.leaseAgreement.leaseAgreementDtl[pl].port=="" ){
					checkport = true;
					break;
				}else if ($scope.leaseAgreement.leaseAgreementDtl[pl].returnport==""){
					checkreturnport = true;
					break;
				}
			}
		
		  if(checkcountry == true){
			 logger.logError("Please Select Country..!!");
		} else if (checkport == true){
			logger.logError("Please Select Port..!!");
		} else if (checkreturnport == true){
			logger.logError("Please Select Return Port..!!");
		} 
		else{
        $http.post($stateParams.tenantid+'/api/containerLeaseAgreementType/save',leaseAgreement).success(function(data) {
            console.log("data" + data);
            if (data.isSuccess) {
                logger.logSuccess("Saved Successfully!");
                $state.go('app.eqs.containerLeaseAgreement.containerLeaseAgreementList');
            } else {
                logger.logError(data.message);
            }
        }).error(function(result) {
            console.log("data" + data);
        });
		}
	}else {
        toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.LeaseAgreementForm.$validationSummary), 555000, 'trustedHtml');
    }
    
 };
 
//Fetch Values
 $scope.isEdit = false;
 var agreementRefNo = $location.search().agreementRefNo;
 if (agreementRefNo == undefined) {

 } else {
     $http.get($stateParams.tenantid+'/api/containerLeaseAgreementType/edit?agreementRefNo=' +agreementRefNo).success(function(result) {

         if (result.isEdit == false) {
             logger.logError("Please Try Again");
         } else {

        	 $scope.leaseAgreement=result;
        	
        	 $http.get($stateParams.tenantid+'/api/portform/countrylist').success(function(data) {
               	 
        		 $scope.countrylist = data;
               	 
               	
               	 //console.log("test")
               	 for(var j=0;j<result.leaseAgreementDtl.length;j++){
               		$scope.compList = [];
               		
                  	 var valArr = result.leaseAgreementDtl[j].country.split(',');
                  	var portid = result.leaseAgreementDtl[j].port.split(',');
                  	var returnportid = result.leaseAgreementDtl[j].returnport.split(',');
                  	$scope.list=result.leaseAgreementDtl[j].portList;
                  	 var i = 0,k=0,l=0,portsize=portid.length,returnportsize=returnportid.length, size = valArr.length;
                  	
                  	 result.leaseAgreementDtl[j].country=[];
                  	 
                  	 for (i; i < size; i++) {
                  	
                  		 angular.forEach($scope.countrylist, function(value, key) {
                  	 if (valArr[i] == value.id) {
                  		result.leaseAgreementDtl[j].country.push(value);
                  	 }
                  	 });
                  	 
                  	
               	}
                  	 result.leaseAgreementDtl[j].port=[];
                  	for (k; k < portsize; k++) {
                      	
                 		 angular.forEach($scope.list, function(value1, key) {
                 	 if (portid[k] == value1.id) {
                 		result.leaseAgreementDtl[j].port.push(value1);
                 	 }
                 	 });
                 	 
                 	
              	}
                  	
                  	 result.leaseAgreementDtl[j].returnport=[];
                   	for (l; l < returnportsize; l++) {
                       	
                  		 angular.forEach($scope.list, function(value2, key) {
                  	 if (returnportid[l] == value2.id) {
                  		result.leaseAgreementDtl[j].returnport.push(value2);
                  	 }
                  	 });
                  	 
                  	
               	}
                  	/* var portLength =result.leaseAgreementDtl[j].port.split(','); 
                   	result.leaseAgreementDtl[j].port =[];
                   	for(var j=0;j<portLength.length;j++){
                   		 angular.forEach(result.leaseAgreementDtl[j].portList, function(value, key) {
                           	 if (portLength[j] == value.id) {
                           		result.leaseAgreementDtl[j].port.push(value);
                           	 }
                           	 });
                   		
                   	}*/
                  	 
                  	//result.leaseAgreementDtl[j].port=[];
                  	//result.leaseAgreementDtl[j].port=result.leaseAgreementDtl[j].portList;
               	 
               	 }
               	 $scope.leaseAgreement=result;
               	 $timeout(function() { 
               		    
               		$('.datetimepicker_country').each(function(){ 
               			$(this).find("select").multiselect('destroy');
               	   		$(this).find("select").multiselect({
               	   		maxHeight: 100, 
               	   		includeSelectAllOption: true,
               	   		selectAllText : 'Select All',
               	   		enableFiltering : true,	
               	   		/*disableIfEmpty: true,*/
               	   		enableCaseInsensitiveFiltering: true,
               	   		numberDisplayed: 1,
               	   		onDropdownHide: function (event) {

               	   		}
               	   		});
               	   		$(this).find("#multiselect-button").addClass("width_100 input-sm line-height-5");
               	   		});
                   	 }, 3, false);
               	 $timeout(function() { 
               		 
                		$('.datetimepicker_port').each(function(){ 
                			$(this).find("select").multiselect('destroy');
                	   		$(this).find("select").multiselect({
                	   		maxHeight: 100, 
                	   		includeSelectAllOption: true,
                	   		selectAllText : 'Select All',
                	   		enableFiltering : true,	
                	   		/*disableIfEmpty: true,*/
                	   		enableCaseInsensitiveFiltering: true,
                	   		numberDisplayed: 1,
                	   		onDropdownHide: function (event) {

                	   		}
                	   		});
                	   		$(this).find("#multiselect-button").addClass("width_100 input-sm line-height-5");
                	   		});
                    	 }, 3, false);
               	 
               	 $timeout(function() { 
               		 
             		$('.datetimepicker_returnport').each(function(){ 
             			$(this).find("select").multiselect('destroy');
             	   		$(this).find("select").multiselect({
             	   		maxHeight: 100, 
             	   		includeSelectAllOption: true,
             	   		selectAllText : 'Select All',
             	   		enableFiltering : true,	
             	   		/*disableIfEmpty: true,*/
             	   		enableCaseInsensitiveFiltering: true,
             	   		numberDisplayed: 1,
             	   		onDropdownHide: function (event) {

             	   		}
             	   		});
             	   		$(this).find("#multiselect-button").addClass("width_100 input-sm line-height-5");
             	   		});
                 	 }, 3, false);
               	 
               	 });
        	 $scope.agreementType=result.agreementType.toString();
         	$scope.isEdit=true;
         }
     }).error(function(data) {
         console.log("data" + data);
     });
 }

 $scope.update = function(LeaseAgreementForm,leaseAgreement) {
     if (new validationService().checkFormValidity($scope.LeaseAgreementForm)) {
          $scope.leaseAgreement.agreementRefNo = $location.search().agreementRefNo;
          if(leaseAgreement.leaseAgreementDtl!=null){
  			for(var c=0;c<leaseAgreement.leaseAgreementDtl.length;c++){
  				$scope.countrylist1=[];$scope.portlist1=[];$scope.returnportlist1=[];
  				$scope.countrylist1=leaseAgreement.leaseAgreementDtl[c].country;
  				$scope.portlist1=leaseAgreement.leaseAgreementDtl[c].port;
  				$scope.returnportlist1=leaseAgreement.leaseAgreementDtl[c].returnport;
  				var clValues="",plValues="";rplValues="";
  				for(var cl=0;$scope.countrylist1.length>cl;cl++){
  					if(clValues==""){
  						clValues=$scope.countrylist1[cl].id;
  					}else{
  						clValues+=","+$scope.countrylist1[cl].id;
  					}
  					
  				}
  				for(var pl=0;$scope.portlist1.length>pl;pl++){
  					if(plValues==""){
  						plValues=$scope.portlist1[pl].id;
  					}else{
  						plValues+=","+$scope.portlist1[pl].id;
  					}
  					
  				}
  				for(var rpl=0;$scope.returnportlist1.length>rpl;rpl++){
  					if(rplValues==""){
  						rplValues=$scope.returnportlist1[rpl].id;
  					}else{
  						rplValues+=","+$scope.returnportlist1[rpl].id;
  					}
  					
  				}
  				$scope.leaseAgreement.leaseAgreementDtl[c].country=clValues;
  				$scope.leaseAgreement.leaseAgreementDtl[c].port=plValues;
  				$scope.leaseAgreement.leaseAgreementDtl[c].returnport=rplValues;
  			}
  		}else{
  			
  		}
          var checkcountry=false;checkport=false;checkreturnport=false;
  		for(var pl=0;$scope.leaseAgreement.leaseAgreementDtl.length>pl;pl++){
  				if($scope.leaseAgreement.leaseAgreementDtl[pl].country=="" || $scope.leaseAgreement.leaseAgreementDtl[pl].country==undefined || $scope.leaseAgreement.leaseAgreementDtl[pl].country==null){
  					checkcountry = true;
  					break;
  				}else if ($scope.leaseAgreement.leaseAgreementDtl[pl].port=="" || $scope.leaseAgreement.leaseAgreementDtl[pl].port==undefined || $scope.leaseAgreement.leaseAgreementDtl[pl].port==null){
  					checkport = true;
  					break;
  				}else if ($scope.leaseAgreement.leaseAgreementDtl[pl].returnport=="" || $scope.leaseAgreement.leaseAgreementDtl[pl].returnport==undefined || $scope.leaseAgreement.leaseAgreementDtl[pl].returnport==null){
  					checkreturnport = true;
  					break;
  				}
  			}
  		
  		  if(checkcountry == true){
  			 logger.logError("Please Select Country..!!");
  		} else if (checkport == true){
  			logger.logError("Please Select Port..!!");
  		} else if (checkreturnport == true){
  			logger.logError("Please Select Return Port..!!");
  		} else {
         $http.post($stateParams.tenantid+'/api/containerLeaseAgreementType/update', $scope.leaseAgreement).success(function(result) {
             if (result) {
                 logger.logSuccess("Updated Successfully!");
                 $state.go('app.eqs.containerLeaseAgreement.containerLeaseAgreementList',{tenantid:$stateParams.tenantid});
             } else {
                 logger.logError("Error in Update");
             }
         }).error(function(data) {
             console.log("data" + data);
         });
  		}
     } else {
         toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.LeaseAgreementForm.$validationSummary), 555000, 'trustedHtml');
     }
 };
     //Dropdown for Selectivity
     $http.post($stateParams.tenantid+'/api/containerLeaseAgreementType/dropDownList').success(function(data) {
      
       		$scope.currency=data.listCurrencyList;
       		$scope.agreementType=data.listAgreementTypeList;
       		$scope.agreementParty=data.listAgreementPartyList;
//      		$scope.port=data.listPortList;
       		$scope.containerType=data.listContainerTypeList;
       		$scope.leasingPartyList=data.leasingPartyList;
       		
       });

     
$scope.cancel = function() {
    $state.go('app.eqs.containerLeaseAgreement.containerLeaseAgreementList',{tenantid:$stateParams.tenantid});
};


//$http.get($stateParams.tenantid+'/app/commonUtility/getLeaseAggTypeList').success(function(datas) {
//    console.log(datas);
//    $scope.agreementType = datas.LeaseAggTypeList;
//
//    });
//reset
$scope.reset = function(leaseAgreement) {
if (agreementRefNo == undefined) {
	$http.get($stateParams.tenantid+'/api/containerLeaseAgreementType/getAgreementRefNo').success(function(data){
		console.log(data);
		$scope.leaseAgreement.agreementRefNo = data.agreementRefNo;
	});
$scope.leaseAgreement={
		agreementParty:'',
		agreementType:'',
		currency:'',
		fromDate:'',
		toDate:'',
		leaseAgreementDtl : []

}
} else {
$http.get($stateParams.tenantid+'/api/containerLeaseAgreementType/edit?agreementRefNo=' +agreementRefNo).success(function(result) {

if (result.isEdit == false) {
logger.logError("Please Try Again");
} else {

$scope.leaseAgreement=result;
$scope.isEdit=true;
}
}).error(function(data) {
console.log("data" + data);
});
}

}




	
});

/*module.controller('countryCtrl',function($scope, $state, $http, $filter, ngDialog,logger,
 		$injector, sharedProperties,toaster, $rootScope, validationService,$timeout,$stateParams) {
	
	 $scope.$watch('authentication.attorneydetail[trIndex].attorney', function(newValue, oldValue) {
			            if (newValue != "" && newValue != undefined  && newValue != "" && newValue != 0) {
			            	debugger;
			            	$http.get($stateParams.tenantid+'/poa/getPartDtls?partyCode='+newValue).success(function(response){
			        			debugger;
			        			$scope.authentication.attorneydetail[$scope.$index].address=response.address;
			        			});
			        }
			     })
	$scope.getportList=function(){
	   	$http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(data) { 
	   	debugger
	   	$scope.portList = data.getportlist;
	   	console.log("portList");
	   	console.log( $scope.portList);
	   	$timeout(function() {
	    
	    $("#country").multiselect({
	    maxHeight: 200, 
	    includeSelectAllOption: true,
	    selectAllText : 'Select All',
	    enableFiltering : true,	
	    disableIfEmpty: true,
	    enableCaseInsensitiveFiltering: true,
	    numberDisplayed: 1,
	    onDropdownHide: function (event) {

	    }
	    });
	    $("#multiselect-button").addClass("width_100 input-sm line-height-5");

	   	}, 2, false);
	   	
	   	});

	   	};
	   	
	   	
	   	
	   	$scope.getportList();

	        

});*/

