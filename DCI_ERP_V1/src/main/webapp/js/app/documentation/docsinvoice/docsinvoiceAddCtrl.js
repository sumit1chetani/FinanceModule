'use strict';
app.controller('invoiceAddControllerimp', function($scope, $timeout, $stateParams, $filter, $rootScope, $http, $location, logger, utilsService, $state,
		sharedProperties, $window, ngDialog, $interval, validationService, toaster, $controller, $injector) {

	 $scope.consigneeList = [];

	$scope.pendingBlList = [];
	$scope.checktypeList = [];
	 $scope.checktypeList=[
		 
		  { id: '1', text: 'Factory De-Stuffing' },
		  { id: '2', text: 'Dock De-Stuffing' }
		
	]
    $scope.invoiceData = {
   		 invoiceNo :'',
   		 agent : '',
   		 agentName : '',
   		 blNo : '',
   		 billDate: '',
   		 pol: '',
   		 mode :'',
   		agentNameview : '',
   		 customer: '',
   		 customerName: '',
   		 vessel: '',
   		 vesselName: '',
   		 voyage: '',
   		 voyageName: '',
   		 bookingNo: '',
   		 total : 0,
   		 grandTotal: 0,
   		 quotation : '',
   		 exchangeRate : 1.0,
   		 currency : '',
   		 chargesDetails : [],
   		 detailList	: [],
   		 pod:'',
   		 custaxnum:'',
   		consignee:'',
   		consigTel:'',
		 consigEmail:'',
		 consigName:'',
		 consigAddress:'',
		 consigCountry:'',
		 consigTaxNumber:'',
		 consigCustName:'',
		 consigneeCode:'',
		 stufftype : '',
		 hsCode:'',
		 stufftype :''
		
    }
	   	$scope.invoiceData.stufftype='1'
	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth() + 1;

	var yyyy = today.getFullYear();
	if (dd < 10) {
		dd = '0' + dd;
	}
	if (mm < 10) {
		mm = '0' + mm;
	}
	var today = dd + '/' + mm + '/' + yyyy;
	

	//   $scope.stuffList=[];

	  
	   
 	 $scope.$watch('invoiceData.billDate', function(value, oldValue) {
	    	debugger
	        if (value != '' && value != undefined) {
	            var res = value.split("/");
	            var formCode ='F0099';
	            $http.get($stateParams.tenantid+'/app/cashbankreceipt/getloggedcompany?closingDate='+value+'&formCode='+formCode).success(function(datas) {
	                if(datas){
	                    logger.logError("Account closed for year "+ res[2]);
	                    $scope.invoiceData.billDate  = '';
 

	                }
	            })
	        }
	    }); 
 	 
     $scope.consigneeList=[];

     //Get Consignee Details

     $scope.getConsigneeNameList = function(){

  	   $http.get($stateParams.tenantid+ '/app/docsinvoice/getConsignee').success(function(data) {
  	   console.log("getConsignee",data);
  	   $scope.consigneeList = data;

  	   });
  	   }
  	   
  	   $scope.getConsigneeNameList();
  	   
  	   
  	   
  	   
  	   
  		//pop  for consigne upload


		$scope.countryList=[];
			$scope.getcountryList=function(){
			$http.get($stateParams.tenantid+'/api/portform/countrylist').success(function(data) { 
			debugger
			$scope.countryList = data;
			console.log("countrylist");
			console.log( $scope.countryList);
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

			}, 3, false);
			
		$("#multiselect-button").addClass("width_100 input-sm line-height-5");
			
		/*if(editid != null && editid != ""){
			
			 $scope.compList = [];
		 	 var valArr = $scope.consignee.countrycode.split(',');
		 	 console.log("valarr",valArr);
		 	 var i = 0, size = valArr.length;
		 	 for (i; i < size; i++) {
		 	 $("#country").find("option[value=" + valArr[i] + "]").prop("selected",  "selected");
		 	                   	 angular.forEach($scope.countryList, function(value, key) {
		 	 if (valArr[i] == value.id) {
		 	 $scope.compList.push(value);
		 	 }
		 	
		 	 });
		 	 
		 	 $scope.countryList = $scope.compList;
		 	 }

		}*/
			
			});

			};
			
			
			
			$scope.getcountryList();
			
			

			$scope.consignee ={
					consigneecode : '',
					blNo : '',
					consigname : '',
					consigaddress : '',
					consigcountry : '',
					consigtel : '',
					consigemail : '',
					consigtaxnumber : '',
					consigcustname : '',
					created_by: '',
			        created_date : '',
			      modified_by: '',
			   modified_date: '',
					
			 };
			
			
  	   
  		$scope.consigneeAdd = function() { 

			ngDialog.open({
	        template : '/views/ConsigneeAddPage.jsp',
	        scope : $scope,
	        showClose: false 
	      });
	};
	 
	$rootScope.cancelPopup = function() {
		ngDialog.close();
	};
	
	
	//save
	$scope.saveConsignee = function(consignee,consigneeForm) {
		console.log($scope.consignee); 
			
		 $http.post($stateParams.tenantid+'/api/consignee/create', $scope.consignee).success(function(result) {    	
			 console.log(result);
	         if (result.success) {
	             logger.logSuccess("Consignee Added!");
	             ngDialog.close();
	             $scope.resetConsignee();
	             $scope.getConsigneeNameList();
	             $scope.blNoData.consigName=result.consigneecode;
	             $scope.blNoData.consigAddress = result.consigaddress;    
	             $scope.blNoData.consigCountry = result.consigcountry;    
	             $scope.blNoData.consigTaxNumber = result.consigtaxnumber;    
	             $scope.blNoData.consigTel = result.consigtel;    
	             $scope.blNoData.consigEmail = result.consigemail;    
	              
	         } else {
	        	 ngDialog.close();
	        	 logger.logError("This Consignee already existing. Please select from dropdown");
	         }             
	     });
		
	};

	$scope.resetConsignee = function(){ 
		$scope.consignee ={
				consigneecode : '',
				blNo : '',
				consigname : '',
				consigaddress : '',
				consigcountry : '',
				consigtel : '',
				consigemail : '',
				consigtaxnumber : '',
				consigcustname : '',
				created_by: '',
		        created_date : '',
		      modified_by: '',
		   modified_date: '',
				
		 };
		
	}
	
    $http.get($stateParams.tenantid+'/app/docsinvoice/pendingBlList').success(function(response) {
        $scope.pendingBlList = response.list;
    });
	
    $http.get($stateParams.tenantid+ '/app/commonUtility/getPortinnsa').success(function(data) {

        $scope.terminalList = data.commonUtilityBean;


        });
    
     $scope.$watch('invoiceData.blNo', function(newValue, oldValue) {
    	 var str=$scope.invoiceData.blNo;
   		$scope.invoiceData.temp = str.substring(8, 11);
    	  	$scope.details=false;
      	  	if($scope.invoiceData.temp=="NSA"){
      	  		$scope.details=true;
      	  	}  
	      if(newValue!=null && newValue!=undefined && newValue != ''){
	    	  $http.post($stateParams.tenantid+ '/app/docsinvoice/getInvoiceDetails',newValue).success(function(data) {
	    		  if(data.success==true){
	    			  
	    			  	$scope.invoiceData = data.invoiceBean;
						$scope.invoiceData.detailList =  data.detailList;
						$scope.invoiceData.billDate = today;
						///$scope.invoiceData.terminalvar= data.invoiceBean.pol;
						//$scope.invoiceData.billDate = today;
						 /* if($scope.invoiceData.temp=="NSA"){
		    				 	//$scope.invoiceData = data.invoiceBean.quoteport;
		    				 	if(data.invoiceBean.fpod!= data.invoiceBean.quoteport){
		    				 		$scope.invoiceData.terminalvar= data.invoiceBean.fpod;
		    				}
						  }*/
	    		  }else{
	    			  logger.logError(data.message);
	    			  //$scope.reset();
	    		  }
	    	  });
	      }else{
	    	//  $scope.reset();
	      }
	 });

    	$scope.$watch('invoiceData.stufftype', function(newValue, oldValue) {
    		console.log("testing the watch collection - checktype and blno");
   // 		$scope.invoiceData=[];
    		/*if($scope.invoiceBean.pol=$scope.invoiceData.terminalvar)
    			{
    			 logger.logError("Same Terminal already Exists");
    			$scope.invoiceData.terminalvar='';
    			}*/
    	//	else{
    	//	$scope.newcount1="";
    		if(
    			$scope.invoiceData.blNo !=null && $scope.invoiceData.blNo !='' && $scope.invoiceData.blNo != undefined
    			
    			&&$scope.invoiceData.stufftype !=null && $scope.invoiceData.stufftype !='' && $scope.invoiceData.stufftype != undefined)
    		{	
    			
    			if($scope.invoiceData.terminalvar ==null || $scope.invoiceData.terminalvar =='' || $scope.invoiceData.terminalvar == undefined){
    				if($scope.invoiceData.pod=="INNSA")
    				{
    					///var terminal="INNSICT";
    					$scope.invoiceData.terminalvar="INNSICT";
    				}else{
    					$scope.invoiceData.terminalvar=$scope.invoiceData.pod;
    				}
    				//var port1=terminal;
    				///$scope.newcount1=$scope.invoiceData.terminalvar;
    			}
    	        $http.get($stateParams.tenantid+'/app/docsinvoice/getInvoiceDetailsonTerminalchange?blNo=' 
    	        		+ $scope.invoiceData.blNo+'&terminal=' +$scope.invoiceData.terminalvar+'&stufftype=' +$scope.invoiceData.stufftype).success(function(data) {

      		  if(data.success==true){
      			  	$scope.invoiceData = data.invoiceBean;
      			 // 	$scope.invoiceData.checktype=$scope.invoiceData.checktype;
  					$scope.invoiceData.detailList =  data.detailList;
  					$scope.invoiceData.billDate = today;
  					
      		  }else{
      			  logger.logError(data.message);
      			  $scope.reset();
      		  }
      	  });
    	
    		}
    		//}
    });
 
   	$scope.$watch('invoiceData.terminalvar', function(newValue, oldValue) {
   		console.log("testing the watch collection - checktype and blno");
  // 		$scope.invoiceData=[];
   		/*if($scope.invoiceBean.pol=$scope.invoiceData.terminalvar)
   			{
   			 logger.logError("Same Terminal already Exists");
   			$scope.invoiceData.terminalvar='';
   			}*/
   	//	else{
   		
   		if(
   			$scope.invoiceData.blNo !=null && $scope.invoiceData.blNo !='' && $scope.invoiceData.blNo != undefined&&
   			$scope.invoiceData.terminalvar !=null && $scope.invoiceData.terminalvar !='' && $scope.invoiceData.terminalvar != undefined )
   		{	
   			
   			if($scope.invoiceData.fpod!= $scope.invoiceData.quoteport){
   			/*if($scope.invoiceData.stufftype !=null &&$scope.invoiceData.stufftype !='' &&$scope.invoiceData.stufftype!= undefined ){
   				$scope.invoiceData.stufftype=="1";
   			}*/
   			//var stuff="1";
   			//stuff=	$scope.invoiceData.stufftype;
   		   	$scope.invoiceData.stufftype='1'
   	        $http.get($stateParams.tenantid+'/app/docsinvoice/getInvoiceDetailsonTerminalchange?blNo=' 
   	        		+ $scope.invoiceData.blNo+'&terminal=' +$scope.invoiceData.terminalvar+'&stufftype=' +$scope.invoiceData.stufftype).success(function(data) {

     		  if(data.success==true){
     			  	$scope.invoiceData = data.invoiceBean;
     			 /// 	$scope.invoiceData.checktype=$scope.invoiceData.checktype;
 					$scope.invoiceData.detailList =  data.detailList;
 					$scope.invoiceData.billDate = today;
 					
     		  }else{
     			  logger.logError(data.message);
     			  $scope.reset();
     		  }
     	  });
   		}
   		}
   		//}
   });
    $scope.save = function(invoiceForm){
    	if (new validationService() .checkFormValidity(invoiceForm)) {
    		if($scope.invoiceData.billDate !=null && $scope.invoiceData.billDate !='' ){
    		if( ($scope.invoiceData.total!=null &&  $scope.invoiceData.grandTotal!=null) && ($scope.invoiceData.total>0 || $scope.invoiceData.grandTotal>0) ){
    			$scope.invoiceData.mode="S";
    		var saveInvcData = {
                    'invoiceBean' : $scope.invoiceData ,
            };
            console.log(saveInvcData);
            $('#invoicesave').attr('disabled', true);
            $http.post($stateParams.tenantid+'/app/docsinvoice/saveimportinvoice',saveInvcData).success(function(savResult) {
                console.log(savResult);
                
                if(savResult.success == true || savResult.success == "true") {
                    logger.logSuccess('Invoice Generated Successfully');
                    $state.go('app.documentation.docsinvoice');
                } else {
                    logger.logError(savResult.message);
                }
                
            }).error(function(data) {
                logger.logError("Error Not Saved!");
            });
    	}else{
    		logger.logError("Invalid Amount!");
    	}
    		}else{
    			logger.logError("Invoice Date in Empty !");

    		}
        }else {
			toaster.pop( 'error',
					"Please fill the required fields",
					logger
							.getErrorHtmlNew(invoiceForm.$validationSummary),
					5000, 'trustedHtml');
}
    }
    
    $scope.consigneeList=[];
    //Get Consignee Details

    $http.get($stateParams.tenantid+ '/api/outWard/getConsignee').success(function(data) {
    console.log("getConsignee",data);
    $scope.consigneeList = data;

    });
    $scope.fetchSelectedConsigneeName = function($model,invoiceData){
    	console.log("inside auto fun");
    	console.log("consigneeList",$scope.consigneeList);
        if($scope.consigneeList.length>0){
            angular.forEach($scope.consigneeList, function(key,index){
                if ($model === key.text){
                	invoiceData.consigName = key.text;
                	invoiceData.consigAddress = key.consigneeAddress;    
                	invoiceData.consigCountry = key.consigneeCountry;    
                	invoiceData.custaxnum = key.consigneeTaxnumber;    
                	invoiceData.consigTel = key.consigneeTel;    
                	invoiceData.consigEmail = key.consigEmail;
                	invoiceData.customer = key.consigneeCode;      

                }else{
                	invoiceData.consigName=$model;
                	invoiceData.consigneeCode="";
                }  
            })
              
            
        }else{
        	invoiceData.consigName=$model;
        }
        return invoiceData.consigName;
      }
    
    //watch function
    
	$scope.$watch('invoiceData.consigneeCode', function(newValue,oldValue) {
		if (newValue != '' && newValue != undefined ) {
			var consigneeCode=newValue;	
			console.log("consigneeCode",consigneeCode);
					  debugger;
			  		  $http.get($stateParams.tenantid+'/app/docsinvoice/getConsigneeDetails?conNo='+consigneeCode).success(function(datas) {
			  			console.log("ImportInvConsigneeDetails",datas);
			  			$scope.invoiceData.consignee = datas.consignee;
			  			
			  			$scope.invoiceData.custaxnum=datas.custaxnum
	 		   		 	//$scope.blNoData.consigName = consigneeCode;
			  			/*$scope.blNoData.consigAddress = datas.consigAddress;    
			  			$scope.blNoData.consigCountry = datas.consigCountry;    
			  			$scope.blNoData.consigTaxNumber = datas.consigTaxNumber;    
			  			$scope.blNoData.consigTel = datas.consigTel;    
			  			$scope.blNoData.consigEmail = datas.consigEmail;*/    
			  		 
		               	 
			  		  });		  	   
	  	
		}
	});
	
	
    
// Print Preview functionality
    $scope.printpreviewInvoice = function(invoiceForm){
    	if (new validationService() .checkFormValidity(invoiceForm)) {
    		if($scope.invoiceData.billDate !=null && $scope.invoiceData.billDate !='' ){
    		if( ($scope.invoiceData.total!=null &&  $scope.invoiceData.grandTotal!=null) && ($scope.invoiceData.total>0 || $scope.invoiceData.grandTotal>0) ){
    			$scope.invoiceData.mode="P";
        		var saveInvcData = {
                        'invoiceBean' : $scope.invoiceData ,
                };
          $http.post($stateParams.tenantid+'/app/docsinvoice/save',saveInvcData).success(function(savResult) {
        	  console.log(savResult);
        	  if(savResult.message !=null && savResult.message !=''){
        		  logger.logError(savResult.message);
        	  }
        	  else{
        	  var invdraftNo = savResult.draftinvoiceNo;
              $timeout(function() {
                  var url = $stateParams.tenantid+'/app/docsinvoice/printinvoicepreview1?invoiceno=' + invdraftNo;
                  var wnd = window.open(url, 'Simatech', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
                  wnd.print();
              }, 1000);
        	  }
           
                
            }).error(function(data) {
                logger.logError("Error Not Saved!");
            });
    	}else{
    		logger.logError("Invalid Amount!");
    	}
    		}else{
    			logger.logError("Invoice Date in Empty !");

    		}
        }else {
			toaster.pop( 'error',
					"Please fill the required fields",
					logger
							.getErrorHtmlNew(invoiceForm.$validationSummary),
					5000, 'trustedHtml');
}
    }
    
    
   


    $scope.cancel = function() {
    	$state.go('app.documentation.docsinvoice');
//        $location.path("/documentation/invoice");
    };
    /*
    $scope.reset = function(){
    	$scope.invoiceData = {
    	   		 invoiceNo :'',
    	   		 agent : '',
    	   		 agentName : '',
    	   		 blNo : '',
    	   		 billDate: '',
    	   		 customer: '',
    	   		 customerName: '',
    	   		 vessel: '',
    	   		 vesselName: '',
    	   		 voyage: '',
    	   		 voyageName: '',
    	   		 bookingNo: '',
    	   		 total : 0,
    	   		 grandTotal: 0,
    	   		 quotation : '',
    	   		 exchangeRate : 1.0,
    	   		 currency : '',
    	   		 chargesDetails : [],
    	   		 detailList	: []
    	    }
    }*/
    
    
    $scope.showaddchargespopup = function(tables) {
      	 ngDialog.open({
               scope : $scope,
               template : 'views/documentation/invoice/additionalchargespopup',
               controller : $controller('additionalChargesCtrl', {
                   $scope : $scope,
                   rowData : tables
               }),
               className : 'ngdialog-theme-plain',
               showClose : false,
               closeByDocument : false,
               closeByEscape : false,
               preCloseCallback : $scope.getList
           });
           
       };
       
       
       $scope.showaddchargesbookpopup = function(tables) {
        	 ngDialog.open({
                 scope : $scope,
                 template : 'views/documentation/invoice/additionalchargespopupBook',
                 controller : $controller('additionalChargesBookCtrl', {
                     $scope : $scope,
                     rowData : tables
                 }),
                 className : 'ngdialog-theme-plain',
                 showClose : false,
                 closeByDocument : false,
                 closeByEscape : false,
                 preCloseCallback : $scope.getList
             });
             
         };
       
       
    
       
        
});


app.controller('algorithmModalCtrl', function($scope, $http, ngDialog, logger, $location) {

    $scope.closeHelpDialog = function() {
        ngDialog.close();
    };
});


app.controller('additionalChargesCtrl', function($scope, $stateParams,$rootScope, $http, $filter, logger, ngDialog,$timeout,rowData) {
	console.log(rowData);

/*	$scope.getdropdown = function() {*/
		  
		$http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(datas) {
				  $scope.shipmentList=datas.getshipmentlist;
				  $scope.portList=datas.getportlist;
				  $scope.customerDropList=datas.getcustomerlist;
				  $scope.currencyList=datas.getcurrencylist	;
				  $scope.conTypeList=datas.getcontypelist;
				  // $scope.chargeTypeList=datas.getchargetypelist
			}).error(function(datas) {

			});
		
		
		$http.post($stateParams.tenantid + '/app/ratequotation/getShipment').success(function(datas) {
			$scope.chargeTypeList = datas.getchargetypelistRRR;
			}).error(function(datas) {

			});
		
         /*}
		  $scope.getdropdown(); */
		  
		  $scope.shipmentList  = [];
			$scope.SpecialList  = [];
			$scope.cargoType  = [];
			$scope.nominatedDropList  = [];
			$scope.vendorDropList = [];
			$scope.serviceParnrDropList = [];
			$scope.portList=[];
			$scope.currencyList=[];
			$scope.shipmentTermlist=[]; 
			$http.post($stateParams.tenantid+ '/api/localcharges/dropDown').success(function(data) {

				$scope.uomList = data.getuomList;
			    

			});
				/*  $scope.uomList=[
						 
					  { id: 'PER CTR', text: 'PER CTR' },
					  { id: 'PER DAY PER CNTR', text: 'PER DAY PER CNTR' },
					  { id: 'PER DAY PER MOVE', text: 'PER DAY PER MOVE' },
					  { id: 'PER CHASSIS', text: 'PER CHASSIS' },
					  { id: 'PER BL', text: 'PER BL' },
					  { id: 'PER DO', text: 'PER DO' }
					
				]*/
				  
				  $scope.contTypeList=[
						 
					  { id: 'Freight', text: 'Freight' },
					  { id: 'Local', text: 'Local' },
					  { id: 'LocalDest', text: 'LocalDest' }
					
				]
				  
				
					$http.get($stateParams.tenantid + '/app/ratequotation/getCountAddChargeDtlimp?rrno='+rowData.quotation).success(
							function(data) {
								if(data> 0)
									{
									$http.get($stateParams.tenantid + '/app/ratequotation/getAddChargeDtlimp?rrno='+rowData.quotation).success(
											function(response1) {
												$scope.quote = response1[0].bookingStatus;
												 
												$scope.invoiceaddcharge.Dtl = response1;
											 
											});
									
									}else{

										$http.get($stateParams.tenantid + '/app/ratequotation/getAddChargeDtlimpbooking?rrno='+rowData.quotation).success(
												function(response2) {
													$scope.quote = response2[0].bookingStatus;
												 
												});
									}
							 
							});
				  

			$scope.addRow = function() {

				$scope.max = Math.max.apply(Math, $scope.invoiceaddcharge.Dtl
						.map(function(item) {
							return item.id;
						}));
				$scope.max = $scope.max + 1;
				var chargedata = {
					id : $scope.max,
					quotationNoNew:rowData.quotation,
					termName:rowData.blNo,
					surcharge:'',
					chargeType:'',
					uom:'',
					conType:'',
					hazardous:'',
					oog:'',
					localCurrency : '',
					taxinvoice : 0,
					approvedRate : '',
					remarks : ''
				};

				$scope.invoiceaddcharge.Dtl.push(chargedata);
				var len = $scope.invoiceaddcharge.Dtl.length - 1;
				$timeout(function() {
					//hideActivePapers($scope.max + "0", []);
				}, 1000);
				//$scope.quotation.checkAll=false;
			}
			 
			 $scope.removeRow = function() {
					$scope.tablerow = [];
					for (var index = 0 ; index < 1; index++) {
					angular.forEach($scope.invoiceaddcharge.Dtl,function(row, index) {
								var check = row.select;
								
								if (check == undefined || check == "" ) {
									$scope.tablerow.push(row);
								} else if(index > 0){
									$scope.invoiceaddcharge.Dtl = $scope.tablerow;

								}
							});
					}
					
				};
				
				$scope.invoiceaddcharge={
						
						currencyName : 'USD',
						Dtl:[
							
							{
								id:0,
								quotationNoNew:rowData.quotation,
								termName:rowData.blNo,
								surcharge:'',
								chargeType:'',
								uom:'',
								conType:'',
								hazardous:'',
								oog:'',
								localCurrency : '',
								taxinvoice : 0,
								approvedRate : '',
								remarks : ''
								
							}
							]
		
				}
        


			    $scope.cancelng = function() {
			        ngDialog.close();
			    }
				

			    $scope.addAdditionalCharges = function(displayedCollection) {
			        debugger;
			        var isFlag = true;
			        var saveInvcData = {
		                    'invoiceBean' : rowData ,
		            };
		            console.log(saveInvcData);
		            
		            
		            
		            
		            $http.get($stateParams.tenantid + '/app/ratequotation/getCountAddChargeDtlimp?rrno='+rowData.quotation).success(
							function(datacount) {
								if(datacount > 0)
									{
								      $http.post($stateParams.tenantid+ '/app/ratequotation/delAddChargeDtlimp',rowData.quotation).success(function(datanew) {
				         	    		  if(datanew==true){
				         	    			  
				         	    			  
				         	    			 angular.forEach(displayedCollection, function(row, index) {

				        			        	 $http.post($stateParams.tenantid+'/app/ratequotation/impaddquotefrominv', row).success(function(result) {
				        		                        console.log("result")
				        		                        if (result.success) {
				        		                        	//alert(result.code);
				        		                        	$scope.invoiceData.blNo=rowData.blNo;
				        		                        	
				        		                        	var blno=$scope.invoiceData.blNo;
				        		                        	
				        		                        	$http.post($stateParams.tenantid+ '/app/docsinvoice/getInvoiceDetails',blno).success(function(data) {
				        		                        	/*}
				        		                        	 $http.post($stateParams.tenantid+'/app/docsinvoice/getInvoiceDetails?blNo='+$scope.invoiceData.blNo).success(function(data) {*/
				        		               	    		  if(data.success==true){
				        		               	    			  	$scope.invoiceData = data.invoiceBean;
				        		               						$scope.invoiceData.detailList =  data.detailList;
				        		               						
				        		               	    		  }else{
				        		               	    			  logger.logError(data.message);
				        		               	    			  //$scope.reset();
				        		               	    		  }
				        		               	    	  });
				        		                        } 

				        		                    }).error(function(data) {
				        		                        $('#addBtn,#updateBtn').attr('disabled', false);
				        		                        console.log(data);
				        		                    });

				        			        });
				         	    			  
				         				       ngDialog.close();
			               						logger.logSuccess('Charges Added Successfully');
				         	    			  
				         	    		  }else{
				         	    			  logger.logError(datanew.message);
				         	    			
				         	    		  }
				         	    	  });
									
									}
								
								else{
									
									 angular.forEach(displayedCollection, function(row, index) {

		        			        	 $http.post($stateParams.tenantid+'/app/ratequotation/impaddquotefrominv', row).success(function(result) {
		        		                        console.log("result")
		        		                        if (result.success) {
		        		                        	//alert(result.code);
		        		                        	$scope.invoiceData.blNo=rowData.blNo;
		        		                        	
		        		                        	var blno=$scope.invoiceData.blNo;
		        		                        	
		        		                        	$http.post($stateParams.tenantid+ '/app/docsinvoice/getInvoiceDetails',blno).success(function(data) {
		        		                        	/*}
		        		                        	 $http.post($stateParams.tenantid+'/app/docsinvoice/getInvoiceDetails?blNo='+$scope.invoiceData.blNo).success(function(data) {*/
		        		               	    		  if(data.success==true){
		        		               	    			  	$scope.invoiceData = data.invoiceBean;
		        		               						$scope.invoiceData.detailList =  data.detailList;
		        		               					
		        		               	    		  }else{
		        		               	    			  logger.logError(data.message);
		        		               	    			 // $scope.reset();
		        		               	    		  }
		        		               	    	  });
		        		                        } 

		        		                    }).error(function(data) {
		        		                        $('#addBtn,#updateBtn').attr('disabled', false);
		        		                        console.log(data);
		        		                    });

		        			        });
							        ngDialog.close();
               						logger.logSuccess('Charges Added Successfully');
									
									
									
									
								}
							 
							});
		       }
			  
});


app.controller('invoiceViewControllerimp', function($scope, $timeout, $stateParams, $filter, $rootScope, $http, $location, logger, utilsService, $state,
		sharedProperties, $window, ngDialog, $interval, validationService, toaster, $controller, $injector) {

	$scope.pendingBlList = [];
    $scope.invoiceData = {
   		 invoiceNo :'',
   		 blNo : '',
   		 billDate: '',
   		 customer: '',
   		 customerName: '',
   		 agent : '',
   		 agentName : '',
   		 vessel: '',
   		 vesselName: '',
   		 voyage: '',
   		 voyageName: '',
   		 bookingNo: '',
   		 total : 0,
   		 grandTotal: 0,
   		 quotation : '',
  		 exchangeRate : 1.0,
  		 currency : '',
   		 chargesDetails : [],
   		 detailList	: [],
   		 pod:'',
   		 custaxnum:'',
   		consignee:''
    }
    
	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth() + 1;

	var yyyy = today.getFullYear();
	if (dd < 10) {
		dd = '0' + dd;
	}
	if (mm < 10) {
		mm = '0' + mm;
	}
	var today = dd + '/' + mm + '/' + yyyy;
//	$scope.invoiceData.billDate = today;
	
//    $http.get($stateParams.tenantid+'/app/invoice/pendingBlList').success(function(response) {
//        $scope.pendingBlList = response.list;
//    });
    
	var invoiceNo = $location.search().invoiceNo;
	
	if(invoiceNo!=null && invoiceNo!=undefined && invoiceNo!=''){
		  $http.post($stateParams.tenantid+ '/app/docsinvoice/viewDetails',invoiceNo).success(function(data) {
    		  if(data.success==true){
    			  	$scope.invoiceData = data.invoiceBean;
					$scope.invoiceData.chargesDetails =  data.invoiceBean.detailList;
					$scope.subtotal=0;
					for(var i = 0; i<$scope.invoiceData.chargesDetails.length;i++ ){
						var exchangeAmt = 0;
						if($scope.invoiceData.chargesDetails[i].exchangeRate > 0 && $scope.invoiceData.chargesDetails[i].exchangeRate !=null){
							$scope.invoiceData.chargesDetails[i].exchangeAmt =$scope.invoiceData.chargesDetails[i].quantity*$scope.invoiceData.chargesDetails[i].rate* $scope.invoiceData.chargesDetails[i].exchangeRate;
						}
						else{
							$scope.invoiceData.chargesDetails[i].exchangeAmt =$scope.invoiceData.chargesDetails[i].quantity*$scope.invoiceData.chargesDetails[i].rate;
						}
						$scope.invoiceData.chargesDetails[i].exchangeAmt = $scope.invoiceData.chargesDetails[i].exchangeAmt.toString();
						$scope.invoiceData.chargesDetails[i].exchangeAmt =$scope.invoiceData.chargesDetails[i].exchangeAmt.split('.')[0];
						$scope.invoiceData.chargesDetails[i].exchangeAmt = parseInt($scope.invoiceData.chargesDetails[i].exchangeAmt);
						$scope.subtotal =$scope.subtotal+ parseInt($scope.invoiceData.chargesDetails[i].exchangeAmt);
					}
//					$scope.invoiceData.billDate = today;
    		  }else{
    			  logger.logError(data.message);
    		  }
    	  });
	}
    
    $scope.cancel = function() {
    	$state.go('app.documentation.docsinvoice');
    };
    
    $scope.printInvoice = function() {
        var url = $stateParams.tenantid+'/app/docsinvoice/print?invoiceno=' + invoiceNo;
        var wnd = window.open(url, 'Shipping', 'height=400,width=750,top=100,left=100,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
        wnd.print();
   
};
        
});

app.service("DateService",function($http,$q){
    
    this.getDateInDDMMYYYY=function convert(str) {
        var date = str.split('/');
        var datForChg = date[1]+"-"+date[0]+"-"+date[2];
        return datForChg;
    }
    this.getyear=function convert(str) {
        var date = str.split('/');
        var year = date[2];
        return year;
    }
});




app.controller('additionalChargesBookCtrl', function($scope, $stateParams,$rootScope, $http, $filter, logger, ngDialog,$timeout,rowData) {
	console.log(rowData);

	/*$scope.getdropdown = function() {*/
		  
		$http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(datas) {
				 
				  $scope.currencyList=datas.getcurrencylist	;
				  $scope.conTypeList=datas.getcontypelist;
				 //$scope.chargeTypeList=datas.getchargetypelist
			}).error(function(datas) {

			});
		
		
		$http.post($stateParams.tenantid + '/app/ratequotation/getShipment').success(function(datas) {
			$scope.chargeTypeList = datas.getchargetypelistRRR;
			}).error(function(datas) {

			});
		
  /*       }
		  $scope.getdropdown(); */
		  
		  
		  $scope.uomList=[
				 
			  { id: 'PER CTR', text: 'PER CTR' },
			  { id: 'PER DAY PER CTR', text: 'PER DAY PER CTR' },
			  { id: 'PER DAY PER MOVE', text: 'PER DAY PER MOVE' },
			  { id: 'PER CHASSIS', text: 'PER CHASSIS' },
			  { id: 'PER BL', text: 'PER BL' },
			  { id: 'PER DO', text: 'PER DO' }
			
		]
		  
		  
		  $scope.contTypeList=[
				 
			  { id: 'Freight', text: 'Freight' },
			  { id: 'Local', text: 'Origin' },
			  { id: 'LocalDest', text: 'Destination' }
			
		]
		  
		  $scope.shipmentList  = [];
			$scope.SpecialList  = [];
			$scope.cargoType  = [];
			$scope.nominatedDropList  = [];
			$scope.vendorDropList = [];
			$scope.serviceParnrDropList = [];
			$scope.portList=[];
			$scope.currencyList=[];
			$scope.shipmentTermlist=[]; 
			$http.post($stateParams.tenantid+ '/api/localcharges/dropDown').success(function(data) {

				$scope.uomList = data.getuomList;
			    

			});
				/*  $scope.uomList=[
						 
					  { id: 'PER CTR', text: 'PER CTR' },
					  { id: 'PER DAY PER CNTR', text: 'PER DAY PER CNTR' },
					  { id: 'PER DAY PER MOVE', text: 'PER DAY PER MOVE' },
					  { id: 'PER CHASSIS', text: 'PER CHASSIS' },
					  { id: 'PER BL', text: 'PER BL' },
					  { id: 'PER DO', text: 'PER DO' }
					
				]*/
				  
				  $scope.contTypeList=[
						 
					  { id: 'Freight', text: 'Freight' },
					  { id: 'Local', text: 'Local' },
					  { id: 'LocalDest', text: 'LocalDest' }
					
				]
				  
				  
				  
				  
				  
				  
					$http.get($stateParams.tenantid + '/app/booking/getCountBookAddChargeDtlimp?bkno='+rowData.bookingNo).success(
							function(data) {
								if(data> 0)
									{
								
									$http.get($stateParams.tenantid + '/app/booking/getAddChargeDtlimp?bkno='+rowData.bookingNo).success(
											function(response1) {
												$scope.bookingData.addchargeData = response1;
											 
											});
									}
							 
							});
				  
				  
			
									
									

			$scope.addAdditionalRow = function() {

				$scope.max = Math.max.apply(Math, $scope.bookingData.addchargeData
						.map(function(item) {
							return item.id;
						}));
				$scope.max = $scope.max + 1;
				var chargedata = {
					bookingDtlId : $scope.max,
					bookingNo:rowData.bookingNo,
					surcharge : '',
					chargeType : '',
					uom : '',
					conType: '',
					addchrgcurrency: '',
					addchrgtax: '',
					bookingrate: '',
					bookingqty: '',
					bookremarks: '',
					hazardous : false,
					isOog : false
				};

				$scope.bookingData.addchargeData.push(chargedata);
				var len = $scope.bookingData.addchargeData.length - 1;
				$timeout(function() {
					//hideActivePapers($scope.max + "0", []);
				}, 1000);
				//$scope.quotation.checkAll=false;
			}
			 
			 $scope.removeAddRow = function() {
					$scope.tablerow = [];
					for (var index = 0 ; index < 1; index++) {
					angular.forEach($scope.bookingData.addchargeData,function(row, index) {
								var check = row.select;
								
								if (check == undefined || check == "" ) {
									$scope.tablerow.push(row);
								} else if(index > 0){
									$scope.bookingData.addchargeData = $scope.tablerow;

								}
							});
					}
					
				};
				
				$scope.bookingData={
						
						currencyName : 'USD',
						addchargeData:[
							
							{
							
								bookingDtlId :0,
								bookingNo:rowData.bookingNo,
								surcharge : '',
								chargeType : '',
								uom : '',
								conType: '',
								addchrgcurrency: '',
								addchrgtax: '',
								bookingrate: '',
								bookingqty: '',
								bookremarks: '',
								hazardous : false,
								isOog : false
								
							}
							]
		
				}
        


			    $scope.cancelngBook = function() {
			        ngDialog.close();
			    }
				

			    $scope.addAdditionalChargesBook = function(displayedCollection) {
			        debugger;
			        var isFlag = true;
			        var saveInvcData = {
		                    bookingBean : $scope.bookingData ,
		            };
		            console.log(saveInvcData);
		            
		            
		            $http .post( $stateParams.tenantid + '/app/booking/ImpinvoiceAdd', saveInvcData) .success(	function(data) {
						if (data.success == true) {
							
							
						  	$scope.invoiceData.blNo=rowData.blNo;
                        	
                        	var blno=$scope.invoiceData.blNo;
                        	
                        	$http.post($stateParams.tenantid+ '/app/docsinvoice/getInvoiceDetails',blno).success(function(data) {
                        	/*}
                        	 $http.post($stateParams.tenantid+'/app/docsinvoice/getInvoiceDetails?blNo='+$scope.invoiceData.blNo).success(function(data) {*/
               	    		  if(data.success==true){
               	    			  	$scope.invoiceData = data.invoiceBean;
               						$scope.invoiceData.detailList =  data.detailList;
               						
               	    		  }else{
               	    			  logger.logError(data.message);
               	    			  //$scope.reset();
               	    		  }

               	    	  });
                        	
                         	ngDialog.close();
     						logger.logSuccess('Charges Added Successfully');
                        	
				} else {
							if (data.message != null && data.message != '') {
								logger.logError(data.message)
							} else {
								logger.logError("Cannot be saved. Please try again");
							}
						}
					});	
		            
		          
		       }
			  
});




    
