'use strict';

app.controller('bladdingAddCtrl1', function($scope, $rootScope, $http, $location, logger, ngDialog,
        utilsService,$state,sharedProperties,$window,$stateParams,toaster,validationService,$filter) {

 $scope.displayedCollection = [];
 $scope.tableData = [];
 $scope.blcntrDtlList = [];
 $scope.vesselList = [];
 $scope.voyageList = [];
 $scope.robPolList = [];
  
 $scope.select = false;
 $scope.submitted = false;
 $scope.listAdd= false;
 $scope.showSOBDate= false;

 var date  = new Date();
 var dateString =  date.getDate() + "/" + date.getMonth() + "/" + date.getFullYear() + " " + date.getHours() + ":" + date.getMinutes();

 $scope.rowCollectionFollowup=[];
    $scope.referralList=[];
    $scope.isEdit = false;
   
    $scope.tairDetailList =[];
    
    
    $scope.blTypeList = [
	     {id: 'Normal BL', text: 'Normal BL'},
	     {id: 'Two-sector BL', text: 'Two-sector BL'},
	     {id: 'Sea WayBill', text: 'Sea WayBill'},
	     {id: 'Switch BL', text: 'Switch BL'},
	 
	  ];
    
    
    $scope.GWList = [
	     {id: 'KG', text: 'KG'},
	     {id: 'MT', text: 'MT'}
	 
	  ];
    
    
    $scope.celfahList = [
	     {id: 'C', text: 'C'},
	     {id: 'F', text: 'F'}
	   
	  ];
	
	$scope.branchList=[];
    $scope.blNoData = {
			  blNo : '',
			  jobNo : '',
			  issuePlace : '',
			  issueDate : '',
			  onBoard : '',
			  vslVoyage : '',
			  receiptAt : '',
			  pol : '',
			  pod : '',
			  pot : '',
			  fpod : '',
			  disPol:'',
			  disPod:'',
			  disFpod:'',
			  disvessel:'',
			  disvoyage:'',branch:'',
			  disPor:'',inwardId:'',
			  terms : '',
			  noBls : 3,
			  ref : '',
			  mVoyage : '',
			  loadType : '',
			  service : '',
			  client : '',
			  jobNo : '',
			  agent : '',
			  remarks : '',
			  shipment : '',
			  payer : '',
			  status : '',
			  released : '',
			  messers : '',
			  shippers : '',
			  deliveryAgent:'',
			  polSeq:'',
			  podSeq:'',
			  cnee : '',
			  notify1 : '',
			  notify2 : '',
			  forwarder : '' ,
			  maincom : 'SHIPPERS LOAD STOW AND COUNT',
			  twgt: '',
			  gwgt : '',
			  nwgt : '',
			  cbm : '',
			  pkgs : '',
			  goods : '',
			  marks : '',
			  shipperId : '',
			  cneeId : '',
			  notify1Id : '',
			  notify2Id : '',
			  forwarderId : '',
			  unCode:'',
			  imcoCharge:'',
			  otherblno:'',
			  blrelease:false,
			  rfs:false,
			  soc:false,
			  multimodel : false,
			  detentionTariff:true,
			  printstatus:false,
			  sailingstatus:false,
			  checkNetWgt:false,
			  blreleaseremeraks:'' ,
			  count:'',
			  rob:false,
			  robVessel:'',
			  robVoyage:'',vessel:'',voyage:'',
			  robFpod:'',
			  robPol:'',
			  detentionTariffType:'',
			  blcntrDtlrobPolrobPolList:[
				 { 
			 chargeList : []
				 }
			 ],
			 blpckDtlList : [{
				 packageList : [] 
			 }],
			 blCharges : [],
			 removeCntr : [],
			 removeCntrCharge : [],
			 removeCntrPckg : [],
			 removeCharge : [],
    		exportDeclarationDoc:'',
    		freightAt:'',
    		freightBy:'',
    		sobType:'',
    		billtype:'',
			gw_unit:'',
			 consigTel:'',
			 consigEmail:'',
			 consigName:'',
			 consigAddress:'',consigAddress1:'',consigCountry:'',consigTaxNumber1:'',consigneeCode1:'',shipperTel1:'',shipperAddress1:'',shipperCode1:'',
			 consigCountry:'',
			 consigTaxNumber:'',
			 consigCustName:'',
			 consigneeCode:'',
			 hsCode:'',
			 shipperTel:'',
			 shipperEmail:'',
			 shipperName:'',
			 shipperAddress:'',
			 shipperCountry:'',
			 shipperTaxNumber:'',
			 shipperCustName:'',
			 shipperCode:'',
			 temperature:'',
				vent:'',
				humidity:'',carrier:'',
				celfah:''
	    };
    $scope.blNoData.blcntrDtlList=[];
	  $scope.blNoData.removeCntr=[];
	  $scope.blNoData.removeCntrCharge=[];
	  $scope.blNoData.removeCntrPckg=[];
	  $scope.commodityList =[];
	  $scope.addRow = function() {
	  	  
	  		var chargedata = {
	  				select : true,
	  				cntrNo : '',
	  				size : '',
	  				  type : '',
	  				  sealNo : '',
	  				  tw : '',
	  				  gw : '',
	  				  cb : '',
	  				  net : '',
	  				  checkdigit:'',
	  				  fle : '',
	  				  so : '',
	  				  packageType : '',
	  				  noOfPckgs : '',
	  				  goods : '',
	  				  iso : '',
	  				  hazardous : false,
	  				  ows : false,
	  				  marks : '',
	  				  polTer : '',
	  				  podTer : '',
	  				  action : '',
	  				  unCode:'',
	  				  imcoCharge:'',
	  				  chargeList : [],
	  				  vgm:'',
	  				  temperature:'',
	  					vent:'',
	  					humidity:'',
	  					celfah:''
	  		};

	  	$scope.blNoData.blcntrDtlList.push(chargedata);
	  	}
	  $scope.removeRow = function() {
	  	$scope.tablerow = [];
	  	angular.forEach($scope.blNoData.blcntrDtlList,
	  			function(row, index) {
	  				var check = row.select;
	  				
	  				if (check == undefined || check == "") {
	  					$scope.tablerow.push(row);
	  				} else {

	  				}
	  			});
	  	$scope.blNoData.blcntrDtlList = $scope.tablerow;
	  };
	  $http.get($stateParams.tenantid+'/app/commonUtility/getcarrierList').success(function(datas) {
			debugger
		    $scope.carrierList = datas.commonUtilityBean;	    
	        //$scope.transList = datas.lCommonUtilityBean;	    

		}).error(function(data) {

		});
	    
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

		$scope.blNoData.issueDate = dd + '/' + mm + '/'+ yyyy;
		
		$scope.bookingNoList=[];
		  $http.get($stateParams.tenantid+'/api/inWard/bookingNumberlist1').success(function(datas) {
			  console.log("bookingNumberlist",datas);
		        $scope.bookingNoList = datas.bookingNoList;
		     });
		  
		    ////Shipment Order No watch
		    $scope.$watch('blNoData.bookingNo', function(newValue, oldValue) {
			      if(newValue!=null && newValue!=undefined && newValue != '' &&  $scope.isEdit == false){
			    	  $http.get($stateParams.tenantid+'/api/inWard/getJobList1?bookingNo='+newValue).success(function(datas) {
			    	         $scope.jobList = datas;
			    	         $scope.blNoData.jobNo=$scope.jobList[0].id;
			    	         console.log("$scope.blNoData.jobNowatch",$scope.jobList);
			    	     });
			      }
			      
			      $scope.calcWeight= function(){
				      	$scope.blNoData.n_wgt=0;
				      	$scope.blNoData.g_wgt=0;
				      	$scope.blNoData.cbm=0;
				      	$scope.blNoData.pkgs= 0;
				      	debugger;
				      angular.forEach($scope.blNoData.blcntrDtlList, function(value,key){
				      	debugger;
				      	 if(value.tw  != null  && value.tw  != ""  ){
				      		 $scope.blNoData.n_wgt =getNum(parseFloat($scope.blNoData.n_wgt))+parseFloat(value.tw) ;
				      		 console.log("Net Weight", $scope.blNoData.n_wgt);
				      	 }
				       if(value.gw  != null  && value.gw  != ""  ){
				      	 $scope.blNoData.g_wgt =getNum(parseFloat($scope.blNoData.g_wgt))+parseFloat(value.gw) ;
				      	 console.log("Gross Weight", $scope.blNoData.g_wgt);
				       }
				       
				       if(value.cb  != null  && value.cb  != ""  ){
				      	 $scope.blNoData.cbm =getNum(parseFloat($scope.blNoData.cbm))+parseFloat(value.cb) ;
				      	 console.log("CBM", $scope.blNoData.cbm);
				       }
				       
				       if(value.noOfPckgs  != null  && value.noOfPckgs  != ""  ){
				      	 $scope.blNoData.pkgs =getNum(parseFloat($scope.blNoData.pkgs))+parseFloat(value.noOfPckgs) ;
				      	 console.log("No of Packages", $scope.blNoData.pkgs);
				       }
				       });
				      $scope.blNoData.n_wgt = parseFloat($scope.blNoData.n_wgt.toFixed(3));
				      $scope.blNoData.g_wgt = parseFloat($scope.blNoData.g_wgt.toFixed(3));
				      $scope.blNoData.cbm =parseFloat($scope.blNoData.cbm.toFixed(3));
				      $scope.blNoData.pkgs =parseFloat($scope.blNoData.pkgs.toFixed(3));

				      } 

				      function getNum(val) {
				      	   if (isNaN(val)) {
				      	     return 0;
				      	   }
				      	   return val;
				      	}
			})
		
	  $scope.$watch('blNoData.consigCustName', function(newValue,
					oldValue) {

				if (newValue != '' && newValue != undefined  ) {


					 $http.get($stateParams.tenantid+'/api/outWard/getCustomerAddress?customerId='+newValue).success(function(datas) {
					        $scope.blNoData.consigAddress = datas.address;
					     });

				}else{
					//$scope.bookingNoList=[];
				}
			});
		 $scope.$watch('blNoData.shipperName', function(newValue,
					oldValue) {

				if (newValue != '' && newValue != undefined  ) {


					 $http.get($stateParams.tenantid+'/api/outWard/getCustomerAddress?customerId='+newValue).success(function(datas) {
					        $scope.blNoData.shipperAddress = datas.address;
					     });

				}else{
					//$scope.bookingNoList=[];
				}
			});
		 $http.post($stateParams.tenantid+'/app/seaquotation/getcommodity').success(function(data) { 
		        $scope.commodityList = data.commonUtilityBean;
		    });
    $http.get($stateParams.tenantid+'/api/inWard/getIssuePlace').success(function(datas) {
         $scope.issuePlaceList = datas;
     });
    
    $http.get($stateParams.tenantid+'/api/inWard/vslvoyagedropdown').success(function(datas) {
         $scope.vesselVoyageList = datas;
     });
    
    $http.get($stateParams.tenantid+'/api/inWard/getAgentList').success(function(datas) {
    	debugger
        $scope.agentList = datas;
     });
    
    $http.get($stateParams.tenantid+'/api/inWard/getJobList').success(function(datas) {
         $scope.jobList = datas;
     });
    
    $http.get($stateParams.tenantid+'/api/inWard/shipmentList').success(function(datas) {
        $scope.shipmentList = datas;
    });
   
   /* $http.get($stateParams.tenantid+'/api/inWard/getConatinerTypeList').success(function(datas) {
        $scope.containerTypeList = datas;
    });*/
    
    $http.get($stateParams.tenantid+ '/app/commonUtility/getContainerTypeList').success(function(data1) {
		$scope.containerTypeList = data1.containerTypeList;
	});
    
    $http.post($stateParams.tenantid+'/api/containerLeaseAgreementType/dropDownList').success(function(data) {
         
   		$scope.containerTypeList=data.listContainerTypeList;

   		
   });
  	 $http.post($stateParams.tenantid+'/app/detection/getTariffList').success(function(data) {
	      	
	  		$scope.tariffList=data; 
	  		        		
	     });
    $http.get($stateParams.tenantid+'/api/inWard/getPackageTypeList').success(function(datas) {
        $scope.packageList = datas;
    });
    
    $http.get($stateParams.tenantid+'/api/inWard/getSurChargeListByRelatedTo?relatedTo=2').success(function(datas) {
        $scope.CntrsurchargeList = datas;
    });
    $http
	.get(
			$stateParams.tenantid
					+ '/app/seaquotation/getChargeHeads')
	.success(
			function(datas) {
				$scope.BlsurchargeList = datas.commonUtilityBean;

			}).error(function(data) {

	});
   /* $http.get($stateParams.tenantid+'/api/inWard/getSurChargeListByRelatedTo?relatedTo=1').success(function(datas) {
        $scope. BlsurchargeList = datas;
    });*/
    
     
    
    $http.get($stateParams.tenantid+'/app/commonUtility/getSurChargeList?relateType=2').success(function(datas) {
    	debugger;
        $scope.surchargeListBl = datas;
         console.log($scope.surchargeListBl);
    });  
    
    
    $http.get($stateParams.tenantid+'/api/inWard/getContainerList').success(function(datas) {
        $scope.containerList = datas;
    });
    
    $http.get($stateParams.tenantid+'/app/commonUtility/getPayerList').success(function(datas) {
        $scope.payerList = datas;
    });
    
    $http.get($stateParams.tenantid+'/app/commonUtility/getPortByEmpAgn').success(function(datas) {
        $scope.polList = datas;
    });
    
    $http.get($stateParams.tenantid+'/app/commonUtility/agentList').success(function(datas) {
    	console.log(datas);
        $scope.agentList = datas;
    }).error(function(data) {

    });
    
    $http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(datas) {
   		 $scope.customerList=datas.getcustomerlist;
		  $scope.currencyList=datas.getcurrencylist	;
		  $scope.portlist =datas.getportlist;
		  $scope.polList =datas.polList;
		  $scope.portseqList=datas.portseqList;
	}).error(function(datas) {

	});
 
    
    
    $scope.consigneeList=[];
    //Get Consignee Details

    $http.get($stateParams.tenantid+ '/api/inWard/getConsignee').success(function(data) {
    console.log("getConsignee",data);
    $scope.consigneeList = data;

    });


    $scope.fetchSelectedConsigneeName = function($model,blNoData){
    	console.log("inside auto fun");
    	console.log("consigneeList",$scope.consigneeList);
        if($scope.consigneeList.length>0){
            angular.forEach($scope.consigneeList, function(key,index){
                if ($model === key.text){
                	blNoData.consigName = key.text;
                	blNoData.consigAddress = key.consigneeAddress;    
                	blNoData.consigCountry = key.consigneeCountry;    
                	blNoData.consigTaxNumber = key.consigneeTaxnumber;    
                	blNoData.consigTel = key.consigneeTel;    
                	blNoData.consigEmail = key.consigEmail;
                	blNoData.consigneeCode = key.consigneeCode;      

                }else{
                	blNoData.consigName=$model;
                	blNoData.consigneeCode="";
                }  
            })
              
            
        }else{
        	blNoData.consigName=$model;
        }
        return blNoData.consigName;
      }
    
    
    
    

    $scope.shipperList=[]; 
    
    $http.get($stateParams.tenantid+ '/api/inWard/getShipper').success(function(data) {
 	   console.log("getShipper",data);
 	   $scope.shipperList = data;

 	   });
 		    
    
    $scope.fetchSelectedShipperName = function($model,blNoData){
 	   	console.log("inside auto fun");
 	   	console.log("shipperList",$scope.shipperList);
 	       if($scope.shipperList.length>0){
 	           angular.forEach($scope.shipperList, function(key,index){
 	        	   console.log("shippername1111111",$model);
 	               if ($model === key.text){
 	               	blNoData.shipperName = key.text;
 	               	blNoData.shipperAddress = key.shipperAddress;    
 	               	blNoData.shipperCountry = key.shipperCountry;    
 	               	//blNoData.consigTaxNumber = key.consigneeTaxnumber;    
 	               	blNoData.shipperTel = key.shipperTel;    
 	               	blNoData.shipperEmail = key.shipperEmail;    
 	               	blNoData.shipperCode = key.shipperCode;  
 	               }else{
 	               	blNoData.shipperName=$model;
 	               }  
 	           })
 	             
 	           
 	       }else{
 	       	blNoData.shipperName=$model;
 	       }
 	       return blNoData.shipperName;
 	     }
 	   
    
  
    
    
    /// ROB Vessel drop down
    $http.get($stateParams.tenantid+ '/app/commonUtility/getVesselList').success(function(data) {
		$scope.vesselList = data;
	});
    
    /// ROB Voyage drop down
    $scope.$watch('blNoData.robVessel', function(newValue, oldValue) {
	      if(newValue!=null && newValue!=undefined && newValue != ''){
	    	  $http.post($stateParams.tenantid+ '/app/commonUtility/getVoyageListByVessel',newValue).success(function(data) {
					$scope.voyageList = data;
	    	  });
	      }
	    });
    /// ROB Voyage drop down
    $scope.$watch('blNoData.vessel', function(newValue, oldValue) {
	      if(newValue!=null && newValue!=undefined && newValue != ''){
	    	  $http.post($stateParams.tenantid+ '/app/commonUtility/getVoyageListByVessel',newValue).success(function(data) {
					$scope.voyageList = data;
	    	  });
	      }
	    });
    //// ROB POL & FPOD
    $scope.$watch('blNoData.robVoyage', function(newValue, oldValue) {
	      if(newValue!=null && newValue!=undefined && newValue != ''){
	    	  $http.post($stateParams.tenantid+ '/app/commonUtility/getPortListByVoyNU',newValue).success(function(data) {
	    		  $scope.robPolList = data;
	    	  })

	      }
	})
	$http.get($stateParams.tenantid+ '/app/commonUtility/getPort').success(function(data) {
						$scope.rPodList = data.commonUtilityBean;

					});
    
    var jobNo = $location.search().jobno;
    debugger;
    if(jobNo != undefined){
    	debugger;
    	$scope.blNoData.jobNo=jobNo;
    }
   
    $scope.userId=$('#empId').val();
    console.log("userId111111",$scope.userId);
    if( $scope.userId == 'COR0001' ||  $scope.userId == 'COR0023'||  $scope.userId == 'COR0008' ){
    	$scope.showSOBDate =true;
    }
	
    //Fetch Values
    $scope.isEdit = false;
    $scope.isPrintLimitExceed = false;
    $scope.sailing = false;
    var blNo = $location.search().blNo;
   $scope.fromdraft = $location.search().from;
    if (blNo == undefined) {
    } else {
    	$scope.jobList=[];
    	
    	$scope.isEdit=true;
     	  $http.get($stateParams.tenantid+ '/api/inWard/getCustomereditDropdown?blNo=' +blNo).success(function(data1) {
     			console.log(data1);
     			$scope.customerList1 = data1;

     		});
     	var vessel= $rootScope.values.vessel;
     	var voyage= $rootScope.values.vslVoyage;
        $http.get($stateParams.tenantid+'/api/inWard/edit?blNo=' +blNo+'&vessel='+vessel+'&voyage='+voyage).success(function(result) {
        	console.log("data77777",result);
        	$scope.isEdit=true;
        	if(result.goods != null && result.goods != ''){
     			 var text5 =result.goods;
                  text5 = text5.replace(/\r?<br>/g, '\n');
                 result.goods=text5;
     		}
        	if(result.shipper != null && result.shipper != ''){
    			 var text5 =result.shipper;
                 text5 = text5.replace(/\r?<br>/g, '\n');
                result.shipper=text5;
    		}
        	if(result.cnee != null && result.cnee != ''){
   			 var text5 =result.cnee;
                text5 = text5.replace(/\r?<br>/g, '\n');
               result.cnee=text5;
        	}
        	if(result.notify1 != null && result.notify1 != ''){
      			 var text5 =result.notify1;
                   text5 = text5.replace(/\r?<br>/g, '\n');
                  result.notify1=text5;
           	}
        	if(result.notify2 != null && result.notify2 != ''){
      			 var text5 =result.notify2;
                   text5 = text5.replace(/\r?<br>/g, '\n');
                  result.notify2=text5;
           	}
        	if(result.forwarder != null && result.forwarder != ''){
     			 var text5 =result.forwarder;
                  text5 = text5.replace(/\r?<br>/g, '\n');
                 result.forwarder=text5;
          	}
        	if(result.marks != null && result.marks != ''){
     			 var text5 =result.marks;
                  text5 = text5.replace(/\r?<br>/g, '\n');
                 result.marks=text5;
          	}
        	$scope.blNoData.count=result.count;
        	$scope.bltype=result.bltype;
        	// alert("1 :"+result.printstatus +" 2:"+result.sailingstatus);
        		/*if(result.userId !='E0019'&& result.userId !='E0021' && result.userId !='E0001'){
        		  if (result.printstatus == true ) { 
        			// $scope.isPrintLimitExceed = true;
        			 logger.logError("NOTE: BL print count limit exceeded. Data cannot be modified..!!");
        		  }else if (result.sailingstatus == true){
        			  $scope.sailing = true;
         			 logger.logError("NOTE: Date Range Exceeded From Vessel Sailing..!!");
        		  }
        	}*/
        	
        	console.log("testing",result.bookingno);
        	$scope.jobList=[{id : result.jobNo, text : result.jobNo}];	  
        	$scope.bookingNoList=[{id : result.bookingno, text : result.bookingno}];	  
        	$scope.blNoData=result;
        	$scope.blNoData.bookingNo=result.bookingno;
        	$scope.exportDeclarationDocFiles=[];
        	if($scope.blNoData.exportDeclarationDoc !=null  && $scope.blNoData.exportDeclarationDoc !=""){
        		
        	var filesList = $scope.blNoData.exportDeclarationDoc.split(","); 
        	for(i=0;i<filesList.length;i++){
        		 var str = filesList[i].split("/"); 
         		  console.log("str",str);
         		  $scope.exportDeclarationDocFiles.push({
         	             filename : str[str.length - 1],
         	             filepath : filesList[i],
         	            
         	         });
        	}
      		 
        }
        	
            	
         
             	$scope.blNoData.consigAddress1=result.consigAddress;
            	$scope.blNoData.consigCountry1=result.consigCountry;
            	$scope.blNoData.shipperAddress1=result.shipperAddress;
            	$scope.blNoData.shipperCountry1=result.shipperCountry;
            	$scope.blNoData.shipperTel1=result.shipperTel;
            	$scope.blNoData.shipperEmail1=result.shipperEmail;
            	$scope.blNoData.shipperCode=result.shipperCode;
             	$scope.blNoData.consigneeCode=result.consigneeCode;
            	$scope.blNoData.shipperCode1=result.shipperCode;
             	$scope.blNoData.consigneeCode1=result.consigneeCode;
             	$scope.blNoData.consigTel=result.consigTel;
             	$scope.blNoData.consigTel1=result.consigTel;
             	$scope.blNoData.consigEmail=result.consigEmail;
             	$scope.blNoData.consigEmail1=result.consigEmail;

            	$scope.blNoData.consigTaxNumber1=result.consigTaxNumber;
            	console.log("blNoData123333",$scope.blNoData);
             	for(var i=0; i < $scope.blNoData.blcntrDtlList.length;i++){
             		$scope.blNoData.blcntrDtlList[i].cntrNo=result.blcntrDtlList[i].cntrNo.toString();
             		$scope.blNoData.blcntrDtlList[i].type=result.blcntrDtlList[i].conType.toString();
             	}
            	}).error(function(data) {
            console.log("data" + data);
        });
        
        //for shipping bills files 
      
        $http.get($stateParams.tenantid+ '/api/inWard/getShippBillFiles?blNo=' +blNo).success(function(dataList) {
 			console.log(dataList);
 			  $scope.exportShippingBillFiles = [];
 			$scope.exportShippingBillFiles = dataList;

 		});
        
        
        //Rate Deviation Approval Files
      
        $http.get($stateParams.tenantid+ '/api/inWard/getRateDeviationFiles?blNo=' +blNo).success(function(dataList) {
 			console.log(dataList);
 			  $scope.rateDeviationFiles = [];
 			$scope.rateDeviationFiles = dataList;
 			

 		});
        
    }
    $scope.validateContainer=function(con,i){
if(con.length==11){

}else{
	logger.logError(" Invalid Container Number ");
		$scope.blNoData.blcntrDtlList[i].cntrNo='';

}
	}	
    $scope.Reset = function(){
        $http.get($stateParams.tenantid+'/api/inWard/edit?blNo=' +blNo).success(function(result) {

         	$scope.blNoData=result;
         	for(var i=0; i < $scope.blNoData.blcntrDtlList.length;i++){
         		$scope.blNoData.blcntrDtlList[i].cntrNo=result.blcntrDtlList[i].cntrNo.toString();
         	}
        	$scope.isEdit=true;
     }).error(function(data) {
        console.log("data" + data);
    });
    }
    
    $scope.cancel = function() {
    	/*if($scope.fromdraft == "draft")
    		{
		   	 $state.go('app.documentation.bldraft.bldraftlist',{tenantid:$stateParams.tenantid});

    		
    		}else{*/
    		   	 $state.go('app.documentation.inwardbladding.inwardlist',{tenantid:$stateParams.tenantid});

//    		/}
   };
    
   
 
   
   $scope.fleList = [
         		       {id: '1', text: 'F'},
         		    {id: '2', text: 'L'}, 
         		 {id: '3', text: 'E'} 
        		     ];
  
  $scope.socList = [
         		       {id: '1', text: 'Yes'},
         		    {id: '2', text: 'No'}, 
        		     ];

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
			
			
 
		    
		 //////////////////////////////////////////////////
		  
		  
//		  $scope.containersData = {
//				  cntrNo : '',
//				  size : '',
//				  type : '',
//				  sealNo : '',
//				  tw : '',
//				  gw : '',
//				  cb : '',
//				  net : '',
//				  fle : '',
//				  so : '',
//				  package_ : '',
//				  no : '',
//				  g : '',
//				  iso : '',
//				  vgm : '',
//				  mar : '',
//				  polTer : '',
//				  podTer : ''
//		    };
		    

    
		  $scope.termsOfPayment = [
		          		       {id: '1', text: 'Collect'},
		         		       {id: '2', text: 'Prepaid'},
		         		       {id: '3', text: 'Third Pary Collect'},
		         		     ];
		    $scope.load = [
		       {id: 'FCL', text: 'FCL'},
		       {id: 'LCL', text: 'LCL'},
		     ];
 
		    $scope.jobno = [
		        {id:'',text:'---select---'},
		       {id: 'J001', text: 'J001'},
		       {id: 'J002', text: 'J002'},
		       {id: 'J003', text: 'J003'},
		     ];

		    $scope.statusList = [
 		       {id: 'Hold', text: 'Hold'},
		     ];
		    
	
	
     $http.post($stateParams.tenantid+'/app/hr/holiday/branchlist').success(function(data) {
	      	
      		$scope.branchList=data;
      		        		
    	});
		    $scope.checkValidation = function() {
		    	var alertmsg = "<ui><h4>Please fill the required fields</h4>";
		 		var msg = "";
		 		
		 		angular.forEach($scope.blNoData.blcntrDtlList, function(cntrList, index) { 	
		 	 		  if ($scope.checkundefined(cntrList.cntrNo)) {
		 		            msg = msg + "<li>Row :" + (index + 1) + "# Container No :Field is required.</li>";
		 		            $scope.changecolor('cntrNo'+index);
		 		        }else{
		 		        	$scope.clearcolor('cntrNo'+index);
		 		        }
		 	 		if ($scope.checkundefined(cntrList.type)) {
	 		            msg = msg + "<li>Row :" + (index + 1) + "# Type :Field is required.</li>";
	 		            $scope.changecolor('type'+index);
	 		        }else{
	 		        	$scope.clearcolor('type'+index);
	 		        }
		 	 		if ($scope.checkundefined(cntrList.gw)) {
	 		            msg = msg + "<li>Row :" + (index + 1) + "# Gross Weight :Field is required.</li>";
	 		            $scope.changecolor('gw'+index);
	 		        }else{
	 		        	$scope.clearcolor('gw'+index);
	 		        }
	 		       if ($scope.checkundefined(cntrList.noOfPckgs)) {
	 		            msg = msg + "<li>Row :" + (index + 1) + "# No of Packages :Field is required.</li>";
	 		            $scope.changecolor('noo'+index);
	 		        }else{
	 		        	$scope.clearcolor('noo'+index);
	 		        }
	 		       if ($scope.checkundefined(cntrList.goods)) {
	 		            msg = msg + "<li>Row :" + (index + 1) + "# Commodity :Field is required.</li>";
	 		            $scope.changecolor('g'+index);
	 		        }else{
	 		        	$scope.clearcolor('g'+index);
	 		        }
		 	 		
		 	 		}); 
		    }

		    $scope.checkundefined = function(value) {
		 		var invalid = false;
		 		if (value == undefined || value == 'undefined'
		 				|| value == null || value == 'null'
		 				|| value == '') {
		 			invalid = true;
		 		}
		 		return invalid;
		 		

		 	}
		     $scope.changecolor = function(id) {
		 		$('#' + id + ' .selectivityId').find('input').css(
		 				"border-color", "red");
		 		;

		 	}
		 	$scope.clearcolor = function(id) {
		 		$('#' + id + ' .selectivityId').find('input').css(
		 				"border-color", "#e8dddd");
		 		;

		 	}

$scope.saveData = function(blForm) {
	var msg = $scope.checkValidation();
   	if (!$scope.checkundefined(msg)) {
			logger.logError(msg);
   	}else{
	if (new validationService() .checkFormValidity(blForm)) {
		 var chargee ;
	 		var chargee1
	 		
		var goods = $scope.blNoData.goods;
		var shipper = $scope.blNoData.shipper;
		var cnee = $scope.blNoData.cnee;
		var notify1 = $scope.blNoData.notify1;
		var notify2 = $scope.blNoData.notify2;
		var forwarder = $scope.blNoData.forwarder;
		var marks = $scope.blNoData.marks;
		if($scope.blNoData.goods != null && $scope.blNoData.goods != ''){
			 var text = $scope.blNoData.goods;
	         text = text.replace(/\r?\n/g, '<br>');
	         var res = text.replace("–", "-");
            $scope.blNoData.goods=res;
		}
		if($scope.blNoData.shipper != null && $scope.blNoData.shipper != ''){
			 var text = $scope.blNoData.shipper;
	         text = text.replace(/\r?\n/g, '<br>');
	         var res = text.replace("–", "-");
           $scope.blNoData.shipper=res;
		}
		if($scope.blNoData.cnee != null && $scope.blNoData.cnee != ''){
			 var text = $scope.blNoData.cnee;
	         text = text.replace(/\r?\n/g, '<br>');
	         var res = text.replace("–", "-");
           $scope.blNoData.cnee=res;
		}
		if($scope.blNoData.notify1 != null && $scope.blNoData.notify1 != ''){
			 var text = $scope.blNoData.notify1;
	         text = text.replace(/\r?\n/g, '<br>');
	         var res = text.replace("–", "-");
           $scope.blNoData.notify1=res;
		}
		if($scope.blNoData.notify2 != null && $scope.blNoData.notify2 != ''){
			 var text = $scope.blNoData.notify2;
	         text = text.replace(/\r?\n/g, '<br>');
	         var res = text.replace("–", "-");
           $scope.blNoData.notify2=res;
		}
		if($scope.blNoData.forwarder != null && $scope.blNoData.forwarder != ''){
			 var text = $scope.blNoData.forwarder;
	         text = text.replace(/\r?\n/g, '<br>');
	         var res = text.replace("–", "-");
          $scope.blNoData.forwarder=res;
		}
		if($scope.blNoData.marks != null && $scope.blNoData.marks != ''){
			 var text = $scope.blNoData.marks;
	         text = text.replace(/\r?\n/g, '<br>');
	         var res = text.replace("–", "-");
         $scope.blNoData.marks=res;
		}
		$scope.blNoData.blpckDtlList=[];
		
		if($scope.blNoData.blcntrDtlList.length>0){
			
			 $scope.blNoData.exportDeclarationDoc = $scope.exportDeclarationDoc.toString();

			/* 
			 var count = 0;
			 var fpod =$scope.blNoData.fpod.substring(0, 5);
			 console.log("fpod1222222222",fpod);
			 
			 if(fpod == 'AEJEA' || fpod == 'DJJIB'){
				 count = 1;
			 }	*/
			 
			/* if(count>0 && !$scope.blNoData.hsCode)
				{	 
					 logger.logError(" No shipments will be accepted without HS Code for this port.");
		     	  
				}else{			
			 */
			 $http.post($stateParams.tenantid+'/api/inWard/checkDuplicate', $scope.blNoData).success(function(result) {
				 if(result.checkNetWgt==true){
			 
				 	  $http.post($stateParams.tenantid+'/api/inWard/create', $scope.blNoData).success(function(result) {
				          console.log("result" + result);
				          if (result.isSuccess) {
				              logger.logSuccess("Saved successfully!");
				    		   	 $state.go('app.documentation.inwardbladding.inwardlist',{tenantid:$stateParams.tenantid});
				          } else {
				        	$scope.blNoData.goods = goods;
				      		$scope.blNoData.shipper = shipper;
				      		$scope.blNoData.cnee = cnee;
				      		$scope.blNoData.notify1 = notify1;
				      		$scope.blNoData.notify2 = notify2;
				      		$scope.blNoData.forwarder = forwarder;
				      		$scope.blNoData.marks = marks;
				            logger.logError(result.message);
				          }
				      }).error(function(result) {
				          console.log("data" + result);
				      });
			 }else{
    			 logger.logError("This BL number have already Exists.");

			 }
			 })
				 	  
 	  
				//}
	 		}
		
	 		
	  
} else {
	toaster.pop( 'error',
					"Please fill the required fields",
					logger
							.getErrorHtmlNew($scope.blForm.$validationSummary),
					5000, 'trustedHtml');
}
}
}


/*$scope.$watch('[blNoData.onBoard,blNoData.issueDate]', function(newValue,oldValue) {
	if (newValue != '' && newValue != undefined) {
		var today = new Date();
		var dd = today.getDate();
		var mm = today.getMonth() + 1; //January is 0!

		var yyyy = today.getFullYear();
		if (dd < 10) {
		  dd = '0' + dd;
		} 
		if (mm < 10) {
		  mm = '0' + mm;
		} 
		var today = dd + '/' + mm + '/' + yyyy;
		
		var dayDiff = moment($scope.blNoData.issueDate, "DD/MM/YYYY").diff(moment($scope.blNoData.onBoard, "DD/MM/YYYY"),'day')
        if ( dayDiff < 0 ) { 
        	$scope.blNoData.onBoard="";
        	logger.logError("OnBoard Date Cannot Be Greater Than the Issue Date..!!");
        }

	}
});*/


$scope.$watch('blNoData.shipperId', function(newValue,
		oldValue) {

	if (newValue != '' && newValue != undefined && !$scope.isEdit) {


		$http.get($stateParams.tenantid+ '/api/inWard/getCustomerAddress?customerId='+newValue).success(function(data) {
			debugger
			console.log(data);
			$scope.blNoData.shipper=data.address;
		});

	}
});

$scope.$watch('blNoData.voyage', function(newValue,
		oldValue) {

	if (newValue != '' && newValue != undefined ) {


		$http.get($stateParams.tenantid+ '/api/inWard/checkVoyage?voyage='+newValue).success(function(data) {
			debugger
			if(data.sailingstatus==false){
				logger.logError("There is no Arrival entry for this voyage.");
				$scope.blNoData.voyage='';
			}
		});

	}
});

$scope.$watch('blNoData.cneeId', function(newValue,
		oldValue) {

	if (newValue != '' && newValue != undefined && !$scope.isEdit) {


		$http.get($stateParams.tenantid+ '/api/inWard/getCustomerAddress?customerId='+newValue).success(function(data) {
			debugger
			console.log(data);
			$scope.blNoData.cnee=data.address;
		});


	}
});



$scope.$watch('blNoData.notify1Id', function(newValue,
		oldValue) {

	if (newValue != '' && newValue != undefined && !$scope.isEdit) {


		$http.get($stateParams.tenantid+ '/api/inWard/getCustomerAddress?customerId='+newValue).success(function(data) {
 			console.log(data);
			$scope.blNoData.notify1=data.address;
		});


	}
});


$scope.$watch('blNoData.notify2Id', function(newValue,
		oldValue) {

	if (newValue != '' && newValue != undefined && !$scope.isEdit) {


		$http.get($stateParams.tenantid+ '/api/inWard/getCustomerAddress?customerId='+newValue).success(function(data) {
			debugger
			console.log(data);
			$scope.blNoData.notify2=data.address;
 
		});


	}
});


$scope.$watch('blNoData.forwarderId', function(newValue,
		oldValue) {

	if (newValue != '' && newValue != undefined && !$scope.isEdit) {


		$http.get($stateParams.tenantid+ '/api/inWard/getCustomerAddress?customerId='+newValue).success(function(data) {
			debugger
			console.log(data);
			$scope.blNoData.forwarder=data.address;
		});


	}
});



$scope.$watch('blNoData.jobNo', function(newValue,oldValue) {
if(!$scope.isEdit){ 
	if (newValue != '' && newValue != undefined && !$scope.isEdit) {
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

		
		$http.get($stateParams.tenantid+ '/api/shipOrder/edit?shipmentOrderId='+newValue).success(function(data) {
			debugger
			
			$scope.blNoData= data;
			$scope.blNoData.issuePlace= data.pol;
			$scope.blNoData.receiptAt= data.pol;
			$scope.blNoData.issueDate = dd + '/' + mm + '/'+ yyyy;
			$scope.blNoData.terms=data.service;
			$scope.blNoData.blrelease=false;
			$scope.blNoData.maincom = 'SHIPPERS LOAD STOW AND COUNT';
			//$scope.blNoData.onBoard = dd + '/' + mm + '/'+ yyyy;
			$scope.blNoData.noBls=3;
						
			var cb=0;var gw=0;var noOfPckgs=0;var tw=0;
			for(var i = 0; i < $scope.blNoData.blcntrDtlList.length; i++){
				cb += $scope.blNoData.blcntrDtlList[i].cb;
		        gw += $scope.blNoData.blcntrDtlList[i].gw;
		        noOfPckgs += $scope.blNoData.blcntrDtlList[i].noOfPckgs;
		        tw += $scope.blNoData.blcntrDtlList[i].tw;
 		    }
			
			$scope.blNoData.pkgs=noOfPckgs;
			$scope.blNoData.cbm=cb;
			$scope.blNoData.g_wgt=gw;
			$scope.blNoData.n_wgt=tw;

									
		});

	}
}
});

// Change Request Watch










$scope.updateData = function(blForm) {
	$scope.blNoData.blpckDtlList=[];
	var msg = $scope.checkValidation();
   	if (!$scope.checkundefined(msg)) {
			logger.logError(msg);
   	}else{
	 if (new validationService() .checkFormValidity(blForm)) {
		 var chargee ;
	 		var chargee1

		 	var goods = $scope.blNoData.goods;
			var shipper = $scope.blNoData.shipper;
			var cnee = $scope.blNoData.cnee;
			var notify1 = $scope.blNoData.notify1;
			var notify2 = $scope.blNoData.notify2;
			var forwarder = $scope.blNoData.forwarder;
			var marks = $scope.blNoData.marks;
		 if($scope.blNoData.goods != null && $scope.blNoData.goods != ''){
			 var text = $scope.blNoData.goods;
	         text = text.replace(/\r?\n/g, '<br>');
	         var res = text.replace("–", "-");
            $scope.blNoData.goods=res;
		}
		if($scope.blNoData.shipper != null && $scope.blNoData.shipper != ''){
			 var text = $scope.blNoData.shipper;
	         text = text.replace(/\r?\n/g, '<br>');
	         var res = text.replace("–", "-");
           $scope.blNoData.shipper=res;
		}
		if($scope.blNoData.cnee != null && $scope.blNoData.cnee != ''){
			 var text = $scope.blNoData.cnee;
	         text = text.replace(/\r?\n/g, '<br>');
	         var res = text.replace("–", "-");
           $scope.blNoData.cnee=res;
		}
		if($scope.blNoData.notify1 != null && $scope.blNoData.notify1 != ''){
			 var text = $scope.blNoData.notify1;
	         text = text.replace(/\r?\n/g, '<br>');
	         var res = text.replace("–", "-");
           $scope.blNoData.notify1=res;
		}
		if($scope.blNoData.notify2 != null && $scope.blNoData.notify2 != ''){
			 var text = $scope.blNoData.notify2;
	         text = text.replace(/\r?\n/g, '<br>');
	         var res = text.replace("–", "-");
           $scope.blNoData.notify2=res;
		}
		if($scope.blNoData.forwarder != null && $scope.blNoData.forwarder != ''){
			 var text = $scope.blNoData.forwarder;
	         text = text.replace(/\r?\n/g, '<br>');
	         var res = text.replace("–", "-");
          $scope.blNoData.forwarder=res;
		}
		if($scope.blNoData.marks != null && $scope.blNoData.marks != ''){
			 var text = $scope.blNoData.marks;
	         text = text.replace(/\r?\n/g, '<br>');
	         var res = text.replace("–", "-");
         $scope.blNoData.marks=res;
		}
		
		/*var count = 0;
		var fpod =$scope.blNoData.fpod.substring(0, 5);
		 console.log("fpod1222222222",fpod);
		 
		 if(fpod == 'AEJEA' || fpod == 'DJJIB'){
			 count = 1;
		 }	
		*/
		 /*if(count>0 && !$scope.blNoData.hsCode)
			{	 
				 logger.logError(" No shipments will be accepted without HS Code for this port.");
	     	  
			}else{*/
				for(var i=0;i<$scope.exportDeclarationDocFiles.length;i++){
					if($scope.exportDeclarationDocFiles[i].filepath){
					$scope.exportDeclarationDoc.push($scope.exportDeclarationDocFiles[i].filepath)}
				}
				
				 $scope.blNoData.exportDeclarationDoc = $scope.exportDeclarationDoc.toString();
				$rootScope.BLNO = $scope.blNoData.blNo;
				
				
				$scope.blNoData.consigAddress=$scope.blNoData.consigAddress1;
            	$scope.blNoData.consigCountry=$scope.blNoData.consigCountry1;
            	$scope.blNoData.shipperAddress=$scope.blNoData.shipperAddress1;
            	$scope.blNoData.shipperCountry=$scope.blNoData.shipperCountry1;
            	$scope.blNoData.shipperTel=$scope.blNoData.shipperTel1;
            	$scope.blNoData.shipperEmail=$scope.blNoData.shipperEmail1;
            	$scope.blNoData.shipperCode=$scope.blNoData.shipperCode1;
             	$scope.blNoData.consigneeCode=$scope.blNoData.consigneeCode;
				
					  $http.post($stateParams.tenantid+'/api/inWard/update', $scope.blNoData).success(function(result) {
				        console.log("result" + result);
				        if (result.isSuccess) {
				            logger.logSuccess("Updated Successfully!");
				          // $state.go('app.documentation.outwardbladding.outwardlist',{tenantid:$stateParams.tenantid});
			    		   	 $state.go('app.documentation.inwardbladding.inwardlist',{tenantid:$stateParams.tenantid});

				       	 if ($scope.files1.length > 0) {
		                     angular.forEach($scope.files1, function(files1, index) {
		                         var frmData = new FormData();
		                         frmData.append("file1", files1);
		                         frmData.append("blNo", $rootScope.BLNO);
		                         $.ajax({
		                             type : "POST",
		                             url : $stateParams.tenantid+"/api/inWard/updateUploadBillfile",
		                             data : frmData,
		                             contentType : false,
		                             processData : false,
		                             success : function(result) {}
		                         });
		                     });

		                }
				       	 
				       	 
				       	 //Rate Deviation Approval
				       	 
				       	if ($scope.files2.length > 0) {
		                     angular.forEach($scope.files2, function(files2, index) {
		                         var frmData = new FormData();
		                         frmData.append("file2", files2);
		                         frmData.append("blNo", $rootScope.BLNO);
		                         $.ajax({
		                             type : "POST",
		                             url : $stateParams.tenantid+"/api/inWard/updateUploadRateDeviationfile",
		                             data : frmData,
		                             contentType : false,
		                             processData : false,
		                             success : function(result) {}
		                         });
		                     });

		                }
				       	
				       	
				       	 
				       	 
				       	 //
				       	 
				            if($scope.fromdraft == "draft")
				    		{
						   	 $state.go('app.documentation.bldraft.bldraftlist',{tenantid:$stateParams.tenantid});
				
				    		
				    		}else{
				    		   	 $state.go('app.documentation.inWardbladding.inWardlist',{tenantid:$stateParams.tenantid});
				
				    		}
				        } else {
				        	$scope.blNoData.goods = goods;
				      		$scope.blNoData.shipper = shipper;
				      		$scope.blNoData.cnee = cnee;
				      		$scope.blNoData.notify1 = notify1;
				      		$scope.blNoData.notify2 = notify2;
				      		$scope.blNoData.forwarder = forwarder;
				      		$scope.blNoData.marks = marks;
				        	logger.logError(result.message);
				        }
				    }).error(function(result) {
				        console.log("data" + result);
				    });
	  
			//}
	  
	  

	 }
	  else {
			toaster.pop( 'error',
							"Please fill the required fields",
							logger
									.getErrorHtmlNew($scope.blForm.$validationSummary),
							5000, 'trustedHtml');
		}
}
	}



//add Container Row
$scope.addcntrDtl = function() {
	var blcntrDtl = {
			select : true,
			cntrNo : '',
			size : '',
			  type : '',
			  sealNo : '',
			  tw : '',
			  gw : '',
			  cb : '',
			  net : '',
			  checkdigit:'',
			  fle : '',
			  so : '',
			  packageType : '',
			  noOfPckgs : '',
			  goods : '',
			  iso : '',
			  hazardous : false,
			  ows : false,
			  marks : '',
			  polTer : '',
			  podTer : '',
			  action : '',
			  unCode:'',
			  imcoCharge:'',
			  chargeList : [],
			  vgm:'',
			  temperature:'',
				vent:'',
				humidity:'',
				celfah:''
	}
	$scope.blNoData.blcntrDtlList.push(blcntrDtl);
};

//add Container inner Row
$scope.addinnercntrDtl = function(blcntrDtl) {
	debugger
	var blcntrinnerDtl = {
			chargeCode : '',
			  currency : '',
			  unitRate : '',
			  meaRate : '',
			  wgRate : '',
			  fromPlace : '',
			  toPlace : '',
			  minRate : '',
			  terms : '',
			  realAmount : ''
	}
	blcntrDtl.chargeList.push(blcntrinnerDtl);
}
//add Package Row
$scope.addpckDtl = function() {
	var blpckDtl = {
			select : false,
			cntrNo : '',
			size : '',
			  type : '',
			  sealNo : '',
			  tw : '',
			  gw : '',
			  cb : '',
			  net : '',
			  checkdigit:'',
			  fle : '',
			  so : '',
			  packageType : '',
			  noOfPckgs : '',
			  goods : '',
			  iso : '',
			  hazardous : false,
			  ows : false,
			  marks : '',
			  polTer : '',
			  podTer : '',
			  action : '',
			  unCode:'',
			  imcoCharge:'',
			  packageList : [],
			  temperature:'',
				vent:'',
				humidity:'',
				celfah:''
	}
	$scope.blNoData.blpckDtlList.push(blpckDtl);
};

$scope.addcharges = function() {
	var chrgDtl = { 
			seq : '',
			chargeCode : '',
			currency : '',
			  qty : '',
			  rate : '',
			  amount : '',
			  payAt : '',
			  terms : '',
			  fromPlace : '',
			  toPlace : '',
			  invAmount : '',
			  realAmount : '' 
	}
	if($scope.blNoData.blCharges == undefined){
		$scope.blNoData.blCharges=[];
	}
	$scope.blNoData.blCharges.push(chrgDtl);
	var i=0;
    angular.forEach($scope.blNoData.blCharges, function(row, index) {
    i++;
   row.seq=i;
    })
};


//add Package inner Row
$scope.addinnerpckDtl = function(blpckDtl) {
	debugger
	var blpckinnerDtl = {
				hsCode : '',
				packageType : '',
				noofPcks : '',
				gw_ : '',
				goods : ''
	}
	blpckDtl.packageList.push(blpckinnerDtl);
}


$scope.deletecntrDtl = function(blcntrDtlList,trIndex) {
	 var table=[];
	 if($scope.blNoData.removeCntrCharge== null){
		 	$scope.blNoData.removeCntrCharge=[];
		 }
	 
	 for(var i=0;i< blcntrDtlList.length;i++){
		 if(trIndex == i){
			 if(blcntrDtlList[i].outwardrdContChargesId != null &&
					 blcntrDtlList[i].outwardContChargesId !=0){
				 $scope.blNoData.removeCntrCharge.push(blcntrDtlList[i].outwardContChargesId);
			 }
		 }
		 else{
			 table.push(blcntrDtlList[i]);
		 }
	 }
	 blcntrDtlList=[];
	 blcntrDtlList=table;
}


$scope.removepckCharge = function(blchargeList) {
	 var table=[];
	 if($scope.blNoData.removeCharge== null){
		 	$scope.blNoData.removeCharge=[];
		 }
	 
	 for(var i=0;i< blchargeList.length;i++){
		 if(blchargeList[i].select){
			 if(blchargeList[i].packageChargeId != null &&
					 blchargeList[i].outwardContChargesId !=0){
				 $scope.blNoData.removeCharge.push(blchargeList[i].packageChargeId);
			 }
		 }
		 else{
			 table.push(blchargeList[i]);
		 }
	 }
	 blchargeList=[];
	 $scope.blNoData.blCharges=table;
}



$scope.deleteinnercntrDtl = function(blcntrDtl,bTrIndex) {
	 var table=[];
	 for(var i=0;i< blcntrDtl.chargeList.length;i++){
		 if(bTrIndex == i){
			 
		 }
		 else{
			 table.push(blcntrDtl.chargeList[i]);
		 }
	 }
	 blcntrDtl.chargeList=[];
	 blcntrDtl.chargeList=table;
}

 
$scope.deletepckDtl = function(blpckDtlList,trIndex) {
	 var table=[];
	 for(var i=0;i< blpckDtlList.length;i++){
		 if(trIndex == i){
			 
		 }
		 else{
			 table.push(blpckDtlList[i]);
		 }
	 }
	 blpckDtlList=[];
	 blpckDtlList=table;
}
$scope.deleteinnerpckDtl = function(blpckDtl,bTrIndex) {
	 var table=[];
	 if($scope.blNoData.removeCntrPckg== null){
		 	$scope.blNoData.removeCntrPckg=[];
		 }
	 for(var i=0;i< blpckDtl.packageList.length;i++){
		 if(bTrIndex == i){
			 if(blpckDtl.packageList[i].outwardPackageChargeId != null &&
					 blpckDtl.packageList[i].outwardPackageChargeId !=0){
				 $scope.blNoData.removeCntrPckg.push(blpckDtl.packageList[i].outwardPackageChargeId);
			 }
		 }
		 else{
			 table.push(blpckDtl.packageList[i]);
		 }
	 }
	 blpckDtl.packageList=[];
	 blpckDtl.packageList=table;
}

$scope.removepckDtl = function(pckgList) {
	 var table=[];
	 for(var i=0;i< pckgList.length;i++){
		 if(pckgList[i].select){
			 
		 }
		 else{
			 table.push(pckgList[i]);
		 }
	 }
	 $scope.blNoData.blpckDtlList=[];
	 $scope.blNoData.blpckDtlList=table;
}



$scope.removecntrDtl = function(blcntrDtlList) {
	 var table=[];
	 if($scope.blNoData.removeCntr== null){
		 	$scope.blNoData.removeCntr=[];
		 }
	 for(var i=0;i< blcntrDtlList.length;i++){
		 if(blcntrDtlList[i].select){
			 if(blcntrDtlList[i].outwardCntrId != null &&
					 blcntrDtlList[i].outwardCntrId != 0 ) {
				 $scope.blNoData.removeCntr.push(blcntrDtlList[i].outwardCntrId);
			 }
		 }
		 else{
			 table.push(blcntrDtlList[i]);
		 }
	 }
	 $scope.blNoData.blcntrDtlList=[];
	 $scope.blNoData.blcntrDtlList=table;
}



$scope.upload = false;
$scope.data = {
        files : [] 

};

$scope.files = [];
$scope.files1 = [];
$scope.files2 = [];

$rootScope.uploadFile = function(element) {
	 for(var i=0;i<element.files.length;i++){
   $scope.excelfile = element.files[i];
   
	 }
}

$scope.checkundefined = function(value) {
    var invalid = false;
    if (value == undefined || value == 'undefined' || value == null || value == 'null' || value == '') {
        invalid = true;
    }
    return invalid;

}
$scope.exportDeclarationDocFiles=[];
$scope.exportDeclarationDocFileName=[];
$scope.addImage = function(){
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
	         $scope.exportDeclarationDocFiles.push({
	             filename : $scope.excelfile.name,
	             filepath : '',
	            
	         });
	         $scope.exportDeclarationDocFileName.push('filePath/'+$scope.excelfile.name);
	         $scope.excelfile
	     }
}


$scope.deleteuploadfiles = function(filename) {
    $scope.tempfiles = [];
    $scope.tempfilename = [];
    $scope.exportDeclarationDocFileName=[];
    angular.forEach($scope.files, function(row, index) {
        if (filename != row.name) {
            $scope.tempfiles.push(row);
        }
    });
    angular.forEach($scope.exportDeclarationDocFiles, function(row, index) {
        if (filename != row.filename) {
            $scope.tempfilename.push(row);
            $scope.exportDeclarationDocFileName.push('filePath/'+ row.filename);
        }
    });
   
    $scope.files = $scope.tempfiles;
    $scope.exportDeclarationDocFiles = $scope.tempfilename;

}


$scope.downloadNewFile = function(id) {
    debugger;
    
    document.getElementById('tbnewExport'+id).click();

}

$scope.exportDeclarationDoc=[];
$scope.saveWithUpload = function(blForm) {
	 if ($scope.files.length > 0) {
if($scope.files != ""){
            angular.forEach($scope.files, function(files, index) {
                var frmData = new FormData();
                frmData.append("file", files);
                //frmData.append("data", $stateParams.assessment_id);
                $.ajax({
                    type : "POST",
                    url :  $stateParams.tenantid+"/api/dashBoardMaster/uploadfile",
                    data : frmData,
                    contentType : false,
                    processData : false,
                    success : function(result) {	
                    	console.log("imagePath",result);
                    	$scope.exportDeclarationDoc.push(result.imgPath);
    		            if (result.success) {
    		            	$scope.saveData(blForm);
    		            } else {
    		                logger.logError("Fail to Upload");
    		            }
    		        
                    }
                
                }); 
            });
           
}else{
	logger.logError("Upload file should not empty");
}
           
        }
        else{
        	$scope.saveData(blForm);
            //logger.logError("Please choose a file and click upload button")
        }
       
    
    }





$scope.updateWithUpload = function(blForm) {
	 if ($scope.files.length > 0) {
if($scope.files != ""){
           angular.forEach($scope.files, function(files, index) {
               var frmData = new FormData();
               frmData.append("file", files);
               //frmData.append("data", $stateParams.assessment_id);
               $.ajax({
                   type : "POST",
                   url :  $stateParams.tenantid+"/api/dashBoardMaster/uploadfile",
                   data : frmData,
                   contentType : false,
                   processData : false,
                   success : function(result) {	
                   	console.log("imagePath",result);
                   	$scope.exportDeclarationDoc.push(result.imgPath);
   		            if (result.success) {
   		            	$scope.updateData(blForm);
   		            } else {
   		                logger.logError("Fail to Upload");
   		            }
   		        
                   }
               
               }); 
           });
          
}else{
	logger.logError("Upload file should not empty");
}
          
       }
       else{
       	$scope.updateData(blForm);
           //logger.logError("Please choose a file and click upload button")
       }
      
   
   }


$scope.userLogHistory = function(){
	$http.get($stateParams.tenantid+'/api/inWard/getUserlogHistory?blNo='+blNo).success(function(result) {
     	$scope.rowCollection=result.userLogHistoryList;
     	console.log("getUserlogHistory",$scope.rowCollection);
     	
     
 }).error(function(data) {
    console.log("data" + data);
});
}
$scope.userLogHistory();

//Destination Charges

$scope.bldesCurrency="";
$scope.paymentTerms="";
$scope.destinationCharges = function(){
	$http.get($stateParams.tenantid+'/api/inWard/getdestinationCharges?blNo='+blNo).success(function(result) {
		console.log("editresult",result);
		$scope.paymentTerms = result.terms;
		
		console.log("$scope.paymentTerms",$scope.paymentTerms);
		$scope.destinationCharge = result.destinationCharge;
		console.log("$scope.destinationCharge",$scope.destinationCharge);

     	$scope.bldesChargesList=result.destinationChargesList;
     	$scope.bldesCurrency = $scope.bldesChargesList[0].currency;
     	console.log("$scope.bldesCurrency",$scope.bldesCurrency);
     	console.log("destinationCharges",$scope.bldesChargesList);
     
 }).error(function(data) {
    console.log("data" + data);
});
	
}
$scope.destinationCharges();




//BL Attachments

$scope.blAttachments = function(){
	$http.get($stateParams.tenantid+'/api/inWard/getblAttachments?blNo='+blNo).success(function(result) {
		$scope.blAttach = result.blAttachmentList;
		console.log("blAttachments",$scope.blAttach);
     
 }).error(function(data) {
    console.log("data" + data);
});
	
}
$scope.blAttachments();


$scope.downloadblAttachFile = function(id) {
    debugger;    
    document.getElementById('bldownloadFiles'+id).click();
}


// shipping bill file upload   
$scope.exportShippingBillFiles=[];
$scope.exportShippingBillFilesFileName=[];
$scope.addShipFile = function(){
    var obj = []

    if ($scope.checkundefined($scope.excelfile)) {
        logger.logError("Please select the file");
    } else {
        obj = $filter('filter')($scope.exportShippingBillFiles, {
            filename : $scope.excelfile.name
        }, true);
    }

    if (obj != undefined && obj.length > 0) {
        logger.logError($scope.excelfile.name + " same file already added");
    } else {
        $scope.files1.push($scope.excelfile);
        $scope.exportShippingBillFiles.push({
            filename : $scope.excelfile.name,
            filepath : '',
            employeeId : ''
        });

    }
}

$scope.downloadNewBillFile = function(id) {
    debugger;    
    document.getElementById('tbnewShippBill'+id).click();
}



$scope.deleteShippBillfiles = function(filename) {
    $scope.tempfiles = [];
    $scope.tempfiles1 = [];
    $scope.DBdelete= [];
    $scope.tempfilename = [];
    //$scope.exportShippingBillFiles=[];
    angular.forEach($scope.files1, function(row, index) {
        if (filename != row.name) {
            $scope.tempfiles.push(row);
            $scope.tempfiles1.push(row);
        }
    });
    angular.forEach($scope.exportShippingBillFiles, function(row, index) {
        if (filename != row.filename) {
            $scope.tempfilename.push(row);
            $scope.exportShippingBillFilesFileName.push('filePath/'+ row.filename);
        }else{
        	 $scope.DBdelete.push(row);
        }
    });
   
    $scope.files = $scope.tempfiles;
    $scope.exportShippingBillFiles = $scope.tempfilename;
    $scope.files1 =$scope.tempfiles1;

    
  	 if ($scope.DBdelete.length > 0) {  		 
        angular.forEach($scope.DBdelete, function(ddaa, index) { 
        	$http.get($stateParams.tenantid+'/api/inWard/deleteShippBill?uID='+ddaa.uid+'&blNo='+ddaa.blNo).success(function(datas) {
       	 
        });
        	});

   }
  	      
}


//Rate Deivation Approval

$scope.rateDeviationFiles=[];
$scope.rateDeviationFilesFileName=[];

$scope.addRateDeviationFile = function(){
    var obj = []

    if ($scope.checkundefined($scope.excelfile)) {
        logger.logError("Please select the file");
    } else {
        obj = $filter('filter')($scope.rateDeviationFiles, {
            filename : $scope.excelfile.name
        }, true);
    }

    if (obj != undefined && obj.length > 0) {
        logger.logError($scope.excelfile.name + " same file already added");
    } else {
        $scope.files2.push($scope.excelfile);
        $scope.rateDeviationFiles.push({
            filename : $scope.excelfile.name,
            filepath : '',
            employeeId : ''
        });

    }
}

$scope.downloadRateDeviationFile = function(id) {
    debugger;    
    document.getElementById('rateDeviationBill'+id).click();
}



$scope.deleteRateDeviationfiles = function(filename) {
    $scope.tempfiles = [];
    $scope.tempfiles1 = [];
    $scope.DBdelete= [];
    $scope.tempfilename = [];
    //$scope.exportShippingBillFiles=[];
    angular.forEach($scope.files2, function(row, index) {
        if (filename != row.name) {
            $scope.tempfiles.push(row);
            $scope.tempfiles1.push(row);
        }
    });
    angular.forEach($scope.rateDeviationFiles, function(row, index) {
        if (filename != row.filename) {
            $scope.tempfilename.push(row);
            $scope.rateDeviationFilesFileName.push('filePath/'+ row.filename);
        }else{
        	 $scope.DBdelete.push(row);
        }
    });
   
    $scope.files = $scope.tempfiles;
    $scope.rateDeviationFiles = $scope.tempfilename;
    $scope.files2 =$scope.tempfiles1;

    
  	 if ($scope.DBdelete.length > 0) {  		 
        angular.forEach($scope.DBdelete, function(ddaa, index) { 
        	$http.get($stateParams.tenantid+'/api/inWard/deleteRateDeviation?uID='+ddaa.uid+'&blNo='+ddaa.blNo).success(function(datas) {
       	 
        });
        	});

   }
  	      
}

 




});
app.controller('chargeableCtrl', function($scope, $http, $filter, logger,$stateParams) {

	$scope.$watchCollection('[blNoData.blCharges[trIndex1].qty,blNoData.blCharges[trIndex1].rate]', function(newValue, oldValue) {
		var index = $scope.$index;
				$scope.blNoData.blCharges[index].amount=$scope.blNoData.blCharges[index].rate*$scope.blNoData.blCharges[index].qty;
				});
});
