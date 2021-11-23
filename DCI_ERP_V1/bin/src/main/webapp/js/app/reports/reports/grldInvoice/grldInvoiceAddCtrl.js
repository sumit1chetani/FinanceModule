'use strict';
app.controller('grldInvoiceAddCtrl', function($scope,$stateParams, $rootScope, $http, $location, logger, $log, ngDialog, 
        $modal, utilsService, $window,$state,sharedProperties,$timeout,validationService, toaster) {


    $scope.rowCollection = [];
    $scope.displayedCollection = [];    
	$scope.itemsByPage = 10;	
	$scope.polList = [];
	$scope.podList = [];
	$scope.vesselList = [];
	$scope.voyageList = [];
	$scope.bankAcctList = [];
	$scope.typeList = [];
	 $scope.modeList=[];

	
	$scope.containerTypeList =[];


	$scope.grldinvoiceData = {    		
            customer : '',bankDtl:'',type:'Import',
            voyage  : '',
            vessel  : '',
            pol : '',
            pod:'',           
            status : '',
            invoiceNo : '', 
            invoiceDate : '',
            intraState: 'Y' ,
            totalpercentage: '',
            cgstpercentage: '',
            sgstpercentage: '',
            igstpercentage: '',
            grandtotalpercentage: '',
            total: '',
            cgst: '',
            sgst: '',
            igst: '',
            grandtotal: '',val:true,val1:false,
            grldInvoiceDetail:[],
            carrier:'',
            mode:''

           
            
        };	
	   //vessel list
			$http.get($stateParams.tenantid+ '/app/commonUtility/getVesselList').success(function(data) {
				$scope.vesselList = data;

			});
			
			 $scope.$watch('grldinvoiceData.vessel', function(newValue, oldValue) {
			      if(newValue!=null && newValue!=undefined && newValue != ''){
			    	  $http.post($stateParams.tenantid+ '/app/commonUtility/getVoyageListByVessel',newValue).success(function(data) {
							$scope.voyageList = data;
			    	  });
			      }
			      if(newValue!=null && newValue!=undefined && newValue != '' && $scope.bookViaQt==true){
			    	  $http.post($stateParams.tenantid+ '/app/booking/getVoyListByVsl?pol='+$scope.booking.pol+'&pod='+$scope.booking.pod+'&ves='+newValue).success(function(data) {
							$scope.voyageList = data.voyList;
				    	  })
			      }
			    });			 
	

//mode
			 
			 
				$scope.getQuotationType = function() {
				    var  data = {};
				    data["id"] = "1";
				    data["text"] = "SEA COASTAL";
				    $scope.modeList.push(data);
				    //$scope.quotation.mode='1';
				    data = {};
				    data["id"] = "2";
				    data["text"] = "SEA FOREIGN";
				    $scope.modeList.push(data);
				    data = {};
				    data["id"] = "3";
				    data["text"] = "TRUCK";
				    $scope.modeList.push(data);
				    data = {};
				    data["id"] = "4";
				    data["text"] = "LINER";
				    $scope.modeList.push(data);
				}
				$scope.getQuotationType();
				
			 
			 //carrier
			 
			 $scope.carrierList=[];


			 $http.get($stateParams.tenantid+'/app/commonUtility/getcarrierList').success(function(datas) {
			 				debugger
			 			    $scope.carrierList = datas.commonUtilityBean;	    
			 		        //$scope.transList = datas.lCommonUtilityBean;	    

			 			}).error(function(data) {

			 			});

			  $http.get($stateParams.tenantid+ '/app/commonUtility/getPort').success(function(data) {
					$scope.podList = data.commonUtilityBean;
				});
			  

	  
	    $scope.reset = function() {
	    
	    	$scope.grldinvoiceData = {
	    			customer : '',bankDtl:'',
	   	            pol : '',
	   	            pod:'',
	   	            voyage : '',
	   	            vessel : '',
	   	            bookingNo:'',
	   	            status : '',
	   	            fromDate:''	,
	             	toDate:'',
	             	
	             	 
	            };
	    	  $state.reload();
	    	}	 
	    
	    
	    //detail table
	    $scope.loadgrldTable = function() {
	        debugger;                
	        var grldtable = {};
	        grldtable = {
	               containerType:'',
	               containerNo :'',
	               dischargeDate :'',
	               releaseDate : '',
	               returnDate : '',
	               grDays : '' ,
	               grFreeDays : '' ,
	               grAmount: '' ,
	               ldDays:'' ,fe:'',fe1:'',
	               ldFreeDays:'' ,
	               ldAmount: ''
	              

	          };
	       
	          $scope.grldinvoiceData.grldInvoiceDetail.push(grldtable);
	             
	        }
	    $scope.loadgrldTable();
	    
	    //add Row
        $scope.addgrldRow = function(tables) {
          var len = tables.length;
          var table = {
                  select : '', slNo : 1, 
	               containerType:'',
	               containerNo :'',
	               dischargeDate :'',
	               releaseDate : '',
	               returnDate : '',
	               grDays : '' ,
	               grFreeDays : '' ,
	               grAmount: '' ,
	               ldDays:'' ,fe:'',fe1:'',
	               ldFreeDays:'' ,
	               ldAmount: ''
	            	   };
               
          table.siNo = len+1;
          $scope.grldinvoiceData.grldInvoiceDetail.push(table);
          
        };  
        //remove Row     

        $scope.removegrldRow = function(table) {
           
            $scope.tablerow = [];
            angular.forEach(table, function(row, index) {
                var check = row.select;
                console.log(index);
                if (check == undefined || check == "") {
                    $scope.tablerow.push(row);                    
                }
            });
            $scope.grldinvoiceData.grldInvoiceDetail = $scope.tablerow;
        };
      
	    $scope.$watch('grldinvoiceData.voyage', function(newValue, oldValue) {
		      if(newValue!=null && newValue!=undefined && newValue != ''){
		    	  $http.post($stateParams.tenantid+ '/app/commonUtility/getPortListByVoyage',newValue).success(function(data) {
		    		  $scope.polList = data;
		    	  })
		    	  
		    	  $http.post($stateParams.tenantid+ '/app/commonUtility/getPortListByVoyage',newValue).success(function(data11) {
		    		  $scope.podList = data11;
		    	  })
		      }
		})
	    
		
        $scope.$watch('grldinvoiceData.customer', function(newValue, oldValue) {
		      if(newValue!=null && newValue!=undefined && newValue != ''){
		    	  $http.post($stateParams.tenantid+ '/app/grldinvoice/getbankList',newValue).success(function(data) {
						$scope.bankAcctList = data;
		    	  });
		      }
		      
		    });			
        $scope.typeList = ['Import','Export']; 
	 
	    $scope.$watchCollection('[grldinvoiceData.pol,grldinvoiceData.pod]', function(newValue, oldValue) {
			 if($scope.grldinvoiceData.pol != null && $scope.grldinvoiceData.pol != '' && $scope.grldinvoiceData.pol != undefined 
				        && $scope.grldinvoiceData.pod != null && $scope.grldinvoiceData.pod != '' && $scope.grldinvoiceData.pod != undefined
				   ){
				 
				 if($scope.grldinvoiceData.pol == $scope.grldinvoiceData.pod){
					 logger.logError('POL and POD should be different!');
					 $scope.grldinvoiceData.pol ='';
					 $scope.grldinvoiceData.pod ='';
				 }
				 
			 }
		 });
		$http.post($stateParams.tenantid+'/app/grldinvoice/getCompany').success(function(datas) {
			 // $scope.grldinvoiceData.invoiceNo=datas.maxInvoiceNo;
			  $scope.customerList=datas.getcustomerlist;
			  $scope.containerTypeList=datas.getcontTypelist;
			
		}).error(function(datas) {

		});
	    
	    $scope.cancel = function() {
	        $state.go('app.reports.grldinvoice.list');
	    };
        $scope.$watch('grldinvoiceData.type', function(newValue, oldValue) {
	    	if(newValue=='Import'){
	    	$scope.grldinvoiceData.val=true;
	    	$scope.grldinvoiceData.val1=false;

}else if(newValue=='Export'){
	    	$scope.grldinvoiceData.val1=true;
	    	$scope.grldinvoiceData.val=false;

}
	    });
	    $scope.search = function(grldInvoiceForm,grldinvoiceData) {  
         		if($scope.grldinvoiceData.mode!=null && $scope.grldinvoiceData.mode!="" && $scope.grldinvoiceData.mode!= "undefined") {  
  		   if($scope.grldinvoiceData.mode==4 ){
  	  		   if($scope.grldinvoiceData.carrier!=null && $scope.grldinvoiceData.carrier !="" ){


                 $http.post($stateParams.tenantid+'/app/grldinvoice/getconList', $scope.grldinvoiceData).success(function(result) {
                	 if(result.success){
                		 var err='';
                		 var i =1;
                         angular.forEach(result.getcontTypelist, function (item, key) {

                             if(item.dischargeDate!='' && item.dischargeDate!=null && item.dischargeDate!=undefined){
                        	 }else{
                        		 //err='row'+i+'' + err;
                        		 err=item.containerType+'' + err;

                        	 }
                             i++;
                        	 })
                             $scope.grldinvoiceData.grldInvoiceDetail=result.getcontTypelist;
                              if(err!='' && err!=null && err!=undefined){
                            	  if($scope.grldinvoiceData.type=='Import'){
         					 logger.logError('Discharge Date is not available for this voyage !');
                            	  }else if($scope.grldinvoiceData.type=='Export'){
         					 logger.logError('OnBoard Date is not available for this voyage !');
                            	  }
                              }
                        	 }else{
             					 logger.logError(result.message);
 
                        	 }
                 }).error(function(result) {
                   //  console.log("data" + result);

                     
                 });
  		   }else{
               logger.logError("Please  fill the carrier field!");

  		   }      
  		   }
  		   
  		   else if ($scope.grldinvoiceData.mode!=4){
  			 $http.post($stateParams.tenantid+'/app/grldinvoice/getconList', $scope.grldinvoiceData).success(function(result) {
            	 if(result.success){
            		 var err='';
            		 var i =1;
                     angular.forEach(result.getcontTypelist, function (item, key) {

                         if(item.dischargeDate!='' && item.dischargeDate!=null && item.dischargeDate!=undefined){
                    	 }else{
                    		 //err='row'+i+'' + err;
                    		 err=item.containerType+'' + err;

                    	 }
                         i++;
                    	 })
                         $scope.grldinvoiceData.grldInvoiceDetail=result.getcontTypelist;
                          if(err!='' && err!=null && err!=undefined){
                        	  if($scope.grldinvoiceData.type=='Import'){
     					 logger.logError('Discharge Date is not available for this voyage !');
                        	  }else if($scope.grldinvoiceData.type=='Export'){
     					 logger.logError('OnBoard Date is not available for this voyage !');
                        	  }
                          }
                    	 }
             }).error(function(result) {
                 console.log("data" + result);
             });
  		   }/*else{
               logger.logError("LD Rates are not available for this port!");

  		   }*/
         		  }else{
                      logger.logError("Please fill the Mode field!");
	
         		    } 
  			   
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

	    $scope.grldinvoiceData.invoiceDate = dd + '/' + mm + '/'
	    + yyyy;


	    var today = new Date();
	    var dd = today.getDate();
	    var mm = today.getMonth() + 1;

	    var yyyy = today.getFullYear();
	    var hh = today.getHours();

	    var min = today.getMinutes();
	    if (dd < 10) {
	    dd = '0' + dd;
	    }
	    if (mm < 10) {
	    mm = '0' + mm;
	    }
	    var today = dd + '/' + mm + '/' + yyyy+" "+hh+":"+min;
	    var today1 = dd + '/' + mm + '/' + yyyy;

	    $scope.grldinvoiceData.invoiceDate = today1;
	   // $scope.mrg.issueDate = today1;
	    
	    
	    
	    $scope.save = function(grldInvoiceForm,grldinvoiceData) {  
            if (new validationService().checkFormValidity($scope.grldInvoiceForm)) {         	   
         	   var flag=true;         	  
         	   if(flag==true){  
         		   
         		   if($scope.grldinvoiceData.invoiceDate != null  && $scope.grldinvoiceData.invoiceDate != '' && $scope.grldinvoiceData.invoiceDate != undefined){
         			   
         			  $scope.grldinvoiceData.invoiceDate =  $scope.grldinvoiceData.invoiceDate;  
         		   }
         		  /* else {
         			  $scope.grldinvoiceData.invoiceDate = '';
         		   }*/
         		  var list=$scope.grldinvoiceData.grldInvoiceDetail;
         		 $scope.grldinvoiceData.grldInvoiceDetail=[];
                   angular.forEach(list, function (item, key) {
                	   
					 if(item.select==true){
						 $scope.grldinvoiceData.grldInvoiceDetail.push(item);
					}
                   })
                 $http.post($stateParams.tenantid+'/app/grldinvoice/save', $scope.grldinvoiceData).success(function(result) {
                     console.log("result")
                     if (result.success == true) {
                         logger.logSuccess("Saved Successfully!");
                         $state.go('app.reports.grldinvoice.list');
                     } else {
                         logger.logError("Error in save!");
                     }
                 }).error(function(result) {
                     console.log("data" + result);
                 });
            }
           
         } 
             
            else{
                toaster.pop('error', "Please fill the required fields", 
                        logger.getErrorHtmlNew($scope.grldInvoiceForm.$validationSummary), 555000, 'trustedHtml');
                  }
         }
	    
	    
	    //
	    
	    
	 
        
	    $scope.calculate = function(grldInvoiceForm,grldinvoiceData) {
	    	
	    	for(var i=0;i< $scope.grldinvoiceData.grldInvoiceDetail.length;i++){
	    		
	    		
	    		$scope.grldinvoiceData.totalpercentage = $scope.grldinvoiceData.grldInvoiceDetail[i].grAmount -  $scope.grldinvoiceData.grldInvoiceDetail[i].ldAmount;
	    		 
	    	
	    	}
	    	    	
	    	
	    }
	     //total Amount Calculation 
         
        $scope.totalAmountCalculation = function(){
           
            var grDtlRowDatas = $scope.grldinvoiceData.grldInvoiceDetail;
            var total=0,grAmount =0,ldAmount =0;
            var cnt =0;
            var rowFlag = false;
            angular.forEach(grDtlRowDatas, function (item, key) {
              	 if(item.select==true){

            	grAmount += parseFloat(grDtlRowDatas[key].grAmount);
            	ldAmount += parseFloat(grDtlRowDatas[key].ldAmount);
               
            	$scope.grldinvoiceData.totalpercentage=grAmount + ldAmount;              	
            	$scope.grldinvoiceData.total = grAmount + ldAmount;
            	cnt++;
            	rowFlag = true;
            }
            else{
//        		logger.logError('Please Select Row !');
//            	if(cnt == 0){
//            		logger.logError('Please Select Atleast Row !');
//            	}
        	}
             });
        	if(cnt == 0){
    		logger.logError('Please Select Atleast Row !');
    	}
            
          //  if(grldinvoiceData.total!=null && grldinvoiceData.total!= ""){
            if($scope.grldinvoiceData.intraState == 'Y')
            	{            	
            	$scope.grldinvoiceData.cgstpercentage = 9;
            	$scope.grldinvoiceData.sgstpercentage = 9;
            	$scope.grldinvoiceData.igstpercentage = 0; 
            	$scope.grldinvoiceData.igst = 0;
            	$scope.grldinvoiceData.cgst = $scope.grldinvoiceData.total * 0.09;
            	$scope.grldinvoiceData.sgst = $scope.grldinvoiceData.total * 0.09;
            	$scope.grldinvoiceData.grandtotal = $scope.grldinvoiceData.cgst + $scope.grldinvoiceData.sgst +$scope.grldinvoiceData.total;
            	$scope.grldinvoiceData.grandtotalpercentage = $scope.grldinvoiceData.cgst + $scope.grldinvoiceData.sgst +$scope.grldinvoiceData.total;

            	}
            
            if($scope.grldinvoiceData.intraState == 'N')
        	{            	
        	$scope.grldinvoiceData.cgstpercentage = 0;
        	$scope.grldinvoiceData.sgstpercentage = 0;
        	$scope.grldinvoiceData.cgst = 0;
        	$scope.grldinvoiceData.sgst = 0;
        	$scope.grldinvoiceData.igst =$scope.grldinvoiceData.total * 0.18;
        	$scope.grldinvoiceData.igstpercentage = 18; 
        	$scope.grldinvoiceData.grandtotal = $scope.grldinvoiceData.igst +$scope.grldinvoiceData.total;
        	$scope.grldinvoiceData.grandtotalpercentage = $scope.grldinvoiceData.igst +$scope.grldinvoiceData.total;

        	}
            
       // }
        } 
	   
});

app.controller('invoicetableCtrl', function($scope, $http, $filter, logger,
		$stateParams) {

	$scope.$watchCollection(
	'[grldinvoiceData.grldInvoiceDetail[trIndex].dischargeDate,grldinvoiceData.grldInvoiceDetail[trIndex].releaseDate]',
	function(newValue, oldValue) {
		
	//'	var flagg = false;
		//angular.forEach(http://localhost:8086/#/mbk/seaQuotation/list)
		
		
		if ((newValue[0] !=null && newValue[0] != undefined && newValue[0] != "" ) || (newValue[1] !=null && newValue[1] != undefined && newValue[1] != "" )) {
	if (newValue.length > 0) {
	var check =false,con=false;
	for(var i=0;i< $scope.grldinvoiceData.grldInvoiceDetail.length;i++){
		$scope.grldinvoiceData.grldInvoiceDetail[i].grAmount='';

	var releasedt = $scope.grldinvoiceData.grldInvoiceDetail[i].releaseDate;
	var dischargeDt = $scope.grldinvoiceData.grldInvoiceDetail[i].dischargeDate;
	releasedt = releasedt
	.split("/");
	releasedt = new Date(releasedt[2],releasedt[1] - 1,
	releasedt[0]);
	dischargeDt = dischargeDt
	.split("/");
	dischargeDt = new Date(
	dischargeDt[2],
	dischargeDt[1] - 1,
	dischargeDt[0]);
	var Difference_In_Time = releasedt.getTime() - dischargeDt.getTime() ;
	var Difference_In_Days = Difference_In_Time / (1000 *3600 *24);
	$scope.grldinvoiceData.grldInvoiceDetail[i].grDays = Difference_In_Days+1;
	
	$http.post($stateParams.tenantid+ '/app/grldinvoice/getGrfreedays',$scope.grldinvoiceData).success(function(data) {
		if(data.searchList==undefined){
			logger.logError('Rates are not available for this port !');

		}
	$scope.lsearchList = data.searchList;
if(data.searchList.length>0){
	for(var i=0;i< $scope.lsearchList.length;i++){
	if ($scope.lsearchList[0].freightElement == 'GR'){
	$scope.grldinvoiceData.grldInvoiceDetail[i].grAmount = $scope.lsearchList[i].rate;

	}
	}

	}else{
		logger.logError('Rates are not available for this port !');
	}
	})
	}
	}
	}
	
	});
	$scope.$watchCollection(
			'[grldinvoiceData.grldInvoiceDetail[trIndex].dischargeDate,grldinvoiceData.grldInvoiceDetail[trIndex].returnDate]',
			function(newValue, oldValue) {

		if ((newValue[0] !=null && newValue[0] != undefined && newValue[0] != "" ) || (newValue[1] !=null && newValue[1] != undefined && newValue[1] != "" )) {
			if (newValue.length > 0) {
			var check =false,con=false;

			for(var i=0;i< $scope.grldinvoiceData.grldInvoiceDetail.length;i++){
				$scope.grldinvoiceData.grldInvoiceDetail[i].ldAmount='';

			var returnDt = $scope.grldinvoiceData.grldInvoiceDetail[i].returnDate;
			var dischargeDt = $scope.grldinvoiceData.grldInvoiceDetail[i].dischargeDate;
			returnDt = returnDt
			.split("/");
			returnDt = new Date(returnDt[2],returnDt[1] - 1,
			returnDt[0]);
			dischargeDt = dischargeDt
			.split("/");
			dischargeDt = new Date(
			dischargeDt[2],
			dischargeDt[1] - 1,
			dischargeDt[0]);
			var Difference_In_Time = returnDt.getTime() - dischargeDt.getTime() ;
			var Difference_In_Days = Difference_In_Time / (1000 *3600 *24);
			$scope.grldinvoiceData.grldInvoiceDetail[i].ldDays = Difference_In_Days+1;
			
			$http.post($stateParams.tenantid+ '/app/grldinvoice/getGrfreedays1',$scope.grldinvoiceData).success(function(datas) {
				
			$scope.lsearchList = datas.searchList;
if(datas.searchList.length>0){
			for(var i=0;i< $scope.lsearchList.length;i++){

			if ($scope.lsearchList[0].freightElement == 'LD'){
			$scope.grldinvoiceData.grldInvoiceDetail[i].ldAmount = $scope.lsearchList[i].rate;

			}
			}
}else{
	logger.logError('Rates are not available for this port !');

}


			})
			}
			}
			}

			});
	
	$scope.$watchCollection('[grldinvoiceData.grldInvoiceDetail[trIndex].dischargeDate,grldinvoiceData.grldInvoiceDetail[trIndex].containerType]',
			function(newValue, oldValue) {
				 if(newValue!=null && newValue!=undefined && newValue != ''){				 
					
					 if ($scope.grldinvoiceData.customer != null && $scope.grldinvoiceData.customer != undefined && $scope.grldinvoiceData.customer  != '')
						 {
						 
						 if ($scope.grldinvoiceData.pol != null && $scope.grldinvoiceData.pol != undefined && $scope.grldinvoiceData.pol  != '')
						 {
							
							 if($scope.grldinvoiceData.grldInvoiceDetail[$scope.trIndex].dischargeDate != null && $scope.grldinvoiceData.grldInvoiceDetail[$scope.trIndex].dischargeDate != undefined &&
									 
									 $scope.grldinvoiceData.grldInvoiceDetail[$scope.trIndex].dischargeDate != '' && $scope.grldinvoiceData.grldInvoiceDetail[$scope.trIndex].containerType != null && $scope.grldinvoiceData.grldInvoiceDetail[$scope.trIndex].containerType != undefined 
									 
									 && $scope.grldinvoiceData.grldInvoiceDetail[$scope.trIndex].containerType != '')
								 {
								 

									
						    	  $http.post($stateParams.tenantid+ '/app/grldinvoice/getGrfreedays',$scope.grldinvoiceData).success(function(data) {
						    		  $scope.lsearchList = data.searchList
						    		  
						    		  for(var i=0;i< $scope.lsearchList.length;i++){						    			  
						    			 // $scope.grldinvoiceData.grldInvoiceDetail[i].ldFreeDays =$scope.lsearchList[0].toRate;
						    			 // $scope.grldinvoiceData.grldInvoiceDetail[i].grFreeDays =$scope.lsearchList[0].toRate;
						    			  
						    			  
						    			  if ($scope.lsearchList[0].freightElement == 'GR'){						    				  
    										  
						    				  var days=parseInt($scope.grldinvoiceData.grldInvoiceDetail[i].grDays)-parseInt($scope.grldinvoiceData.grldInvoiceDetail[i].grFreeDays);
						    				  if(Math.sign(days)==1){
						    					$scope.grldinvoiceData.grldInvoiceDetail[i].grAmount = days*$scope.lsearchList[i].rateperDay;	
						    				  }else{
						    				  $scope.grldinvoiceData.grldInvoiceDetail[i].grAmount = 0;
						    				  }
						    				  $scope.grldinvoiceData.grldInvoiceDetail[i].ldAmount = 0;

						    				  
						    			  }
						    			  if ($scope.lsearchList[0].freightElement == 'LD'){	
						    				  var days=parseInt($scope.grldinvoiceData.grldInvoiceDetail[i].ldDays)-parseInt($scope.grldinvoiceData.grldInvoiceDetail[i].ldFreeDays);
						    				  if(Math.sign(days)==1){
					                        $scope.grldinvoiceData.grldInvoiceDetail[i].ldAmount = parseFloat(days*$scope.lsearchList[i].rateperDay);
						    				  }else{
						    				  $scope.grldinvoiceData.grldInvoiceDetail[i].ldAmount = 0;	
						    				  }
						    				  $scope.grldinvoiceData.grldInvoiceDetail[i].grAmount = 0;
						    				  
						    			 
						    			  }
						    			  
						    			  
						    		  }
						    		  
						    		  
						    	  })
						    	  
										 
								 
								 }
							 
							 else{
								  logger.logError("please select  containerType and dischargeDate");
							 }						
							 
							 
							 
						 }
						 else	 {
							 logger.logError("please select Customer and POL filed");
							 
						 }
						 }
					 else	 {
						 //logger.logError("please select  filed");
						 
					 }
					
			    	  
			    	  
			      }
			});
	
	
	
	 

	
	
});
