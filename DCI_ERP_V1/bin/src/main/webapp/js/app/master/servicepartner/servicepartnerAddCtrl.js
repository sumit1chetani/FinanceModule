'use strict';

app.controller('servicepartnerAddCtrl', function($scope, $rootScope, $http, $location, logger, ngDialog,
        utilsService,$state,sharedProperties,$window,$stateParams,toaster,validationService) {

 $scope.displayedCollection = [];
var date  = new Date();
var dateString =  date.getDate() + "/" + date.getMonth() + "/" + date.getFullYear() + " " + date.getHours() + ":" + date.getMinutes();
	$scope.rowCollectionFollowup=[];
    $scope.referralList=[];
    $scope.isEdit = false;
    $scope.tairDetailList =[];
	
	

    $scope.cancel = function() {
	  	  $state.go('app.master.servicepartner.list',{tenantid:$stateParams.tenantid});
	  	  
	          
	    };
    
	   
		    $scope.servicePartnerTable =[];
		    $scope.servicePartner = {
		            
		    		servicePartnerCode:'',creditAmt:'',
		    		servicePartnerName:'',
		    		branch:'',
		    		servicePartnerLedgerName:'',
		    		creditDaysOffered:'',
		    		active:true,
		    		city:'',
		    		region:'',
		            address:'',
		            country:'',
		    		zipCode:'',
		    		personToContact:'',
			    	designation:'',	 
			    	emailId:'',
			    	landLineNo:'',	
			    	mobileNo:'',
			    	salesPerson : '',
                     skypeId:'',	 
			    	 webSite:'',
			    	servicePartnerDescription:'',
		    		 pANNo:'',
		    	    partnerClassification:'',
		        	 gSTNStateCode:'',
		        	 defaultType:'',
		        	 gSTNNo:'',
		        	 exemptionUnder:'',
		        	 gststatecode:'',
		        	 createdBy:'',
		        	 createdDate:'',
		        	 modifiedBy:'',
		        	 modifiedDate:'',
		        	 sundryStatus:'',
		        	 defaultTypeCheck:false,
		        	 prtyCount:'0',
		        	 lServicePartnerBean:[]
		         };
		    $scope.check=true;
		  $scope.tempservicePartnerList = {
			select 		:false,
			contactName:'',
			keyDesignation:'',
			keyEmail:'',
			keyLandLineNo:'',	
	    	keyMobileNo:'',
	    	keySkypeId:'',	 
	    	keyCityId:'',	 
	    	remarks:'',	 
		};
    
		    $scope.sundryList=[{
		        id : '20000003',
		        text : 'Creditors - Local'
		    }, {
		        id : '20010003',
		        text : 'Creditors - Overseas'
		    },{
		        id : '10010004',
		        text : 'Debtors - Local'
		    }, {
		        id : '10080002',
		        text : 'Debtors - Overseas'
		    }];

		    
		 
		    $scope.networkList=[{
		        id : 'Cargo connection',
		        text : 'Cargo connection'
		    }, {
		        id : 'Carvre 7',
		        text : 'Carvre 7'
		    },{
		        id : 'GAA',
		        text : 'GAA'
		    }, {
		        id : 'Flag network',
		        text : 'Flag network'
		    },
		    
		    {
		        id : 'Friends',
		        text : 'Friends'
		    }
		    
		    
		    
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
			
			
			
			
		  $scope.salesTable =[];
		  $scope.tempsalesPersonList = {
					select1 :false,
					servicePartnerId:'',
					salesPerson:'',
					createdDate:'',
					ToDate:'',	
			    	 
				};
		  
		  $scope.tempsalesPersonList.FromDate = today;
		//kyc
		  $scope.tabs = [
		                   {title:"Customer Details", active: true},
		                   {title:"KYC", active:false, disabled: true}
		    ];
		  
		  $scope.CustomerMasterData = {
		            customerName : '',
		            address : '',
		            area : '',
		            countryName : '',
		            faxNo : '',
		            email : '',
		            currency : '',
		            bookingCntctPrsn : '',
		            pricingCntctPrsn : '',
		            operationsCntctPrsn : '',
		            financeCntctPrsn : '',
		            teleNumber : '',
		            shipper : '',
		            consignee : '',
		            notifyParty : '',
		            agreementParty : '',
		            jVPartner : '',
		            shareOfRVC : '',
		            slotSwap : '',
		            costRevenueSpaceShare : '',
		            deadFreight : '',
		            paymentCenter : '',
		            active : true,
		            slotOperator : "N",
		            subSlot : "N",
		            emailBooking : '',
		            emailPricing : '',
		            emailOperations : '',
		            emailFinance : '',
		            blRelated : "N",
		            city : '',
		            attachFileGroup : "P",
		            isVesselGrp : "N",
		            customerShortName : '',
		            address1 : '',
		            typeofCustomer : 'MLO',
		            telOfficeNum : '',
		            telexNum : '',
		            crLimit : '',
		            bankName:'',
		    		accountNumber:'',
		    		vatNum:'',
		    		cinNum :'',
		            exchangeRate : '',
		            bookingCntctPrsnEmail : '',
		            pricingCntctPrsnEmail : '',
		            operationsCntctPrsnEmail : '',
		            financeCntctPrsnEmail : '',
		            faxNum : '',
		            customer_category : '',
		            creditCustType : "N",
		            typeOfCustGrp : "P",
		            depositAmt : '',
		            companyTypeGrp : "MLO",
		            categoryWise : '',
		            controllingAgent : '',
		            customerVoyageList : [],
		            customerCode:'',
		            leadStatus:false,
		            leadId:'',
		            edit:false,
		            bankRTGS:'',
		            salesPerson:''
		    };

		  
		  $scope.addFollowUpRow = function() {
		        $scope.customComm = {
		                customCommunicate : '',
		                customBound : '',
		                subject : '',
		                message : '',
		                meetCallDate : dateString,
		                customId: '',
		                customCommId : '',
		                referral:'',
		                nextFollowUpDate:'',
		                assignedTo:'',
		                bookingCntctPrsn : '',
		                pricingCntctPrsn : '',
		                operationsCntctPrsn : '',
		                financeCntctPrsn : '',
		                teleNumber : '',
		                bookingCntctPrsnEmail : '',
		                pricingCntctPrsnEmail : '',
		                operationsCntctPrsnEmail : '',
		                financeCntctPrsnEmail : '',
		                faxNum : ''
		                
		            };
		        
		       $scope.isShow = false;
		        // $scope.rowCollectionFollowup.push(followUp1);
		    };
		    $scope.customComm = {
	                customCommunicate : '',
	                customBound : '',
	                subject : '',
	                message : '',
	                meetCallDate : dateString,
	                customId: '',
	                customCommId : '',
	                referral:'',
	                nextFollowUpDate:'',
	                assignedTo:'',
	                bookingCntctPrsn : '',
	                pricingCntctPrsn : '',
	                operationsCntctPrsn : '',
	                financeCntctPrsn : '',
	                teleNumber : '',
	                bookingCntctPrsnEmail : '',
	                pricingCntctPrsnEmail : '',
	                operationsCntctPrsnEmail : '',
	                financeCntctPrsnEmail : '',
	                faxNum : ''
	                
	            };
		    
		    
	 //add Row
	  $scope.addCredRow = function() {
	   
		  var tmp=angular.copy($scope.tempservicePartnerList);
			$scope.servicePartnerTable.push(tmp);

	  }
	  $scope.addCredRow();

		$scope.removeCredRow =function(){
			ngDialog.openConfirm().then(function() {
			if($scope.isEdit==false){
				var tmpDelList = [];
				for(var i=$scope.servicePartnerTable.length-1;i>=0;i--){
					if($scope.servicePartnerTable[i].select==true){
						tmpDelList.push($scope.servicePartnerTable[i]);
						$scope.servicePartnerTable.splice(i, 1);
					}
				}
				logger.logSuccess('Deleted Successfully');
			}else if($scope.isEdit==true){
				var tmpDelList = [];
				for(var i=$scope.servicePartnerTable.length-1;i>=0;i--){
					if($scope.servicePartnerTable[i].select==true){
						tmpDelList.push($scope.servicePartnerTable[i]);
					}
				}
				$http.post($stateParams.tenantid+'/app/master/servicepartner/deleteKeyDetail',$scope.servicePartnerTable).success(function(data) {
		        	if(data.success){
		        		for(var i=$scope.servicePartnerTable.length-1;i>=0;i--){
		    				if($scope.servicePartnerTable[i].select==true){
		    					$scope.servicePartnerTable.splice(i, 1);
		    				}
		    			}
		        		logger.logSuccess('Deleted Successfully');
		        	}else{
		        		logger.logError('Unable to delete');
		        	}
				})
			}
			})
		}
		//add Row1
		  $scope.addCredRow1 = function() {
		   
			  var tmp=angular.copy($scope.tempsalesPersonList);
				$scope.salesTable.push(tmp);

		  }
		  $scope.addCredRow1();
		  var userid=$('#dumm').val();
		var servicePartnerId = $location.search().rowid;
		if(servicePartnerId!=null && servicePartnerId!=undefined && servicePartnerId>0){
			$scope.isEdit=true;
			
	        $http.post($stateParams.tenantid+'/app/master/servicepartner/edit?servicePartnerId='+servicePartnerId).success(function(data) {
	        	if(data.success){
	        		$scope.servicePartner = data.servicePartner;
	        		$scope.servicePartnerTable=data.servicePartnerTable;
					$scope.servicePartnerType=data.servicePartnerType;
					$scope.salesTable=data.salesTable;
	        		$scope.servicePartner.city = data.servicePartner.city.toString();
	        		$scope.servicePartner.defaultType = data.servicePartner.defaultType.toString();;
	        		if(data.servicePartner.partnerClassification!=null&&data.servicePartner.partnerClassification!='')
	        			{
		        		$scope.servicePartner.partnerClassification = data.servicePartner.partnerClassification.toString();;

	        			}
	        		
	        		angular.forEach(data.servicePartnerTable,function(value,key)
	    	        		{
	    	        			 if(value.keyCityId!=null && value.keyCityId!='')
	    	         			{
	    	             		$scope.servicePartnerTable[key].keyCityId = value.keyCityId.toString();;

	    	         			}
	    	        		});
	        		if(data.servicePartner.gSTNStateCode!=null && data.servicePartner.gSTNStateCode!='')
        			{
		        		$scope.servicePartner.gSTNStateCode = data.servicePartner.gSTNStateCode.toString();;

        			}if(data.servicePartner.sundryStatus == null || data.servicePartner.sundryStatus == '')
        				{
        				$scope.unique = true;
        				}
        			else{
        				$scope.unique = false;
        			}

	        		
	        	}else{
	        		logger.logError("Unable to fetch data");
	        	}
	        });
		}
		  if( $scope.isEdit == false){
			  $http.post($stateParams.tenantid+'/app/master/servicepartner/getMapDetail').success(function(data) {
		          	if(data.success){
		          		$scope.servicePartnerType=data.servicePartnerType;
		          	}
		          });  
		  }
		
		  $http.post($stateParams.tenantid+'/app/master/servicepartner/dropDownList').success(function(data) {
	          	if(data.success){
	          		$scope.countryList=data.counryList;
	          		$scope.branchList=data.branchList;
	          		$scope.regionList=data.regionList;
	          		$scope.cityList=data.cityList;
	          		$scope.defaultTypeList=data.defaultTypeList;
	          		$scope.gstnStateList=data.gstnStateList;
	          		$scope.partnerClassificationList=data.partnerClassificationList;
	          		$scope.serviceList=data.serviceList;
	          		$scope.classificationList=data.classificationList;
	          	}
	          });
		  
		  $http.get($stateParams.tenantid+'/app/airquotation/getEmployeeList').success(function(datas) {
				 $scope.employeeList = datas.commonUtilityBean;
			    
			});
			
		  $scope.$watch('servicePartner.city', function(newValue,oldValue) {
				if (newValue != '' && newValue != undefined) {
					$http.post($stateParams.tenantid + '/app/master/servicepartner/countryList',newValue).success(function(datas) {
						console.log(datas);
						$scope.servicePartner.country = datas.country;
						$scope.servicePartner.region= datas.region;
					});
				}
			});
		  $scope.$watch('servicePartner.gSTNNo', function(newValue,oldValue) {
				if (newValue != '' && newValue != undefined) {
					$scope.servicePartner.gSTNStateCode=newValue.substring(0,2);
				}
			});
		  $scope.$watch('servicePartner.servicePartnerName', function(newValue,oldValue) {
				if (newValue != '' && newValue != undefined) {
					$scope.servicePartner.servicePartnerLedgerName=newValue;
				}
			});
		  $scope.$watch('servicePartner.defaultType', function(newValue,oldValue) {
				if (newValue != '' && newValue != undefined) {
					if(newValue==6 || newValue==15 || newValue==18){
						$scope.servicePartner.defaultTypeCheck=true;
					}else{
						$scope.servicePartner.defaultTypeCheck=false;
					}
				}
			});
		  
		  
		$scope.save = function(servicePartnerAddForm){
			if (new validationService().checkFormValidity(servicePartnerAddForm)) {
				$scope.servicePartnerTypeList=[];
				//if($scope.servicePartner.emailId!=null && $scope.servicePartner.emailId!=''){

			var flag=$scope.ValidateEmail($scope.servicePartner.emailId);
				
			if(flag==true){
				for(var i=0;i<$scope.servicePartnerType.length;i++)
					{
					if($scope.servicePartnerType[i].visible==true)
						{
						$scope.servicePartnerTypeList.push($scope.servicePartnerType[i].id)	

						}
					}
				var obj = {
						servicePartner : $scope.servicePartner,
						servicePartnerTable	: $scope.servicePartnerTable,
						servicePartnerTypeList:$scope.servicePartnerTypeList
				}
	            $http.post($stateParams.tenantid+'/app/master/servicepartner/save',obj).success(function(data) {
	            	
	            	if(data.success){
	            		logger.logSuccess("Customer Id is "+data.code);
	            		$scope.tabs[1].active = true;
	            		//$scope.cancel();
	            	}else{
	            		logger.logError(data.message);
	            	}
	            	
	            });
				/*}else{
					logger.logError("You have entered an invalid email address!");
				}*/
				}else{

					for(var i=0;i<$scope.servicePartnerType.length;i++)
						{
						if($scope.servicePartnerType[i].visible==true)
							{
							$scope.servicePartnerTypeList.push($scope.servicePartnerType[i].id)	

							}
						}
					var obj = {
							servicePartner : $scope.servicePartner,
							servicePartnerTable	: $scope.servicePartnerTable,
							servicePartnerTypeList:$scope.servicePartnerTypeList
					}
		            $http.post($stateParams.tenantid+'/app/master/servicepartner/save',obj).success(function(data) {
		            	
		            	if(data.success){
		            		logger.logSuccess("Customer Id is "+data.code);
		            		$scope.tabs[1].active = true;
		            		//$scope.cancel();
		            	}else{
		            		logger.logError(data.message);
		            	}
		            	
		            });
					
				}}else {
	            toaster.pop('error', "Please fill the required fields", 
	                    logger.getErrorHtmlNew(servicePartnerAddForm.$validationSummary), 5000, 'trustedHtml');
	        }
			
		}
		$scope.update = function(servicePartnerAddForm){
			if (new validationService().checkFormValidity(servicePartnerAddForm)) {
				$scope.servicePartnerTypeList=[];
				//var flag=$scope.ValidateEmail($scope.servicePartner.emailId);
				//if(flag==true){
				for(var i=0;i<$scope.servicePartnerType.length;i++)
					{
					if($scope.servicePartnerType[i].visible==true)
						{
						$scope.servicePartnerTypeList.push($scope.servicePartnerType[i].id)	

						}
					}
				var obj = {
						servicePartner : $scope.servicePartner,
						servicePartnerTable	: $scope.servicePartnerTable,
						servicePartnerTypeList:$scope.servicePartnerTypeList

				}
	            $http.post($stateParams.tenantid+'/app/master/servicepartner/update',obj).success(function(data) {
	            	if(data.success){
	            		logger.logSuccess('Updated Successfully');
	            		$scope.cancel();
	            	}else{
	            		logger.logError(data.message);
	            	}
	            	
	            });
				/*}else{
					logger.logError("You have entered an invalid email address!");
				}*/
			}else {
	            toaster.pop('error', "Please fill the required fields", 
	                    logger.getErrorHtmlNew(servicePartnerAddForm.$validationSummary), 5000, 'trustedHtml');
	        }
			
			
			
		}
		
		 $scope.checkValidation = function() {

		  	    var alertmsg = "<ui><h4>Please fill the required fields</h4>";
		  	    var msg = "";
		  	  /*  if ($scope.checkundefined($scope.quotation.commodity)) {
		  	        msg = msg + "<li>Commodity:Field is required.</li>";         
		  	        $scope.changecolor('commodity');
		  	    }else{
		  	    	$scope.clearcolor('commodity');
		  	    }*/
		  	    if ($scope.checkundefined($scope.servicePartner.servicePartnerCode)) {
		  	        msg = msg + "<li>servicePartnerCode:Field is required.</li>";         
		  	        $scope.changecolor('servicePartnerCode');
		  	    }else{
		  	    	$scope.clearcolor('servicePartnerCode');
		  	    }
		  	    if ($scope.checkundefined($scope.servicePartner.servicePartnerName)) {
		  	        msg = msg + "<li>servicePartnerName:Field is required.</li>";         
		  	        $scope.changecolor('servicePartnerName');
		  	    }else{
		  	    	$scope.clearcolor('servicePartnerName');
		  	    }
		  	    if ($scope.checkundefined($scope.servicePartner.branch)) {
		  	        msg = msg + "<li>branch:Field is required.</li>";         
		  	        $scope.changecolor('branch');
		  	    }else{
		  	    	$scope.clearcolor('branch');
		  	    }
		  	    if ($scope.checkundefined($scope.servicePartner.servicePartnerLedgerName)) {
		  	        msg = msg + "<li>servicePartnerLedgerName:Field is required.</li>";         
		  	        $scope.changecolor('servicePartnerLedgerName');
		  	    }else{
		  	    	$scope.clearcolor('servicePartnerLedgerName');
		  	    }
		  	    if ($scope.checkundefined($scope.servicePartner.city)) {
		  	        msg = msg + "<li>city:Field is required.</li>";         
		  	        $scope.changecolor('city');
		  	    }else{
		  	    	$scope.clearcolor('city');
		  	    }
		  	  if ($scope.checkundefined($scope.servicePartner.defaultType)) {
		  	        msg = msg + "<li>defaultType:Field is required.</li>";         
		  	        $scope.changecolor('defaultType');
		  	    }else{
		  	    	$scope.clearcolor('defaultType');
		  	    }
		  
		  	 alertmsg = alertmsg + msg + "</ui>";
	  	    if ($scope.checkundefined(msg)) {
	  	        return '';
	  	    } else {
	  	        return alertmsg;
	  	    }
	   }
			$scope.visi=function(id,visible){
				if(id==4 || id==5){
					if(visible==false){
						$scope.check=false;
					}else {
						$scope.check=true;
					}
				}
			}
		$scope.reset=function(){
	         
	         if( $scope.isEdit == false){ 
	        	 $scope.servicePartner = {
	 		            
	 		    		servicePartnerCode:'',
	 		    		servicePartnerName:'',
	 		    		branch:'',
	 		    		servicePartnerLedgerName:'',
	 		    		creditDaysOffered:'',creditAmt:'',
	 		    		active:true,
	 		    		city:'',
	 		    		region:'',
	 		            address:'',
	 		            country:'',
	 		    		zipCode:'',
	 		    		personToContact:'',
	 		    		salesPerson : '',
	 			    	designation:'',	 
	 			    	emailId:'',
	 			    	landLineNo:'',	
	 			    	mobileNo:'',
	 			    	skypeId:'',	 
	 			    	 webSite:'',
	 			    	servicePartnerDescription:'',
	 		    		 pANNo:'',
	 		    	    partnerClassification:'',
	 		        	 gSTNStateCode:'',
	 		        	 defaultType:'',
	 		        	 gSTNNo:'',
	 		        	 exemptionUnder:'',
	 		        	 createdBy:'',
	 		        	 createdDate:'',
	 		        	 modifiedBy:'',
	 		        	 modifiedDate:'',
	 		        	 lServicePartnerBean:[]
	 		         };
	 		    $scope.servicePartnerTable =[];

	         }else {
	 	        $http.post($stateParams.tenantid+'/app/master/servicepartner/edit?servicePartnerId='+$location.search().rowid).success(function(data) {

	                 if (data.success == true) {
	                	 $scope.servicePartner = data.servicePartner;
	 	        		$scope.servicePartnerTable=data.servicePartnerTable;
	 					$scope.servicePartnerType=data.servicePartnerType;
	 	        		$scope.servicePartner.city = data.servicePartner.city.toString();
	 	        		$scope.servicePartner.defaultType = data.servicePartner.defaultType.toString();;
	 	        		if(data.servicePartner.partnerClassification!=null&&data.servicePartner.partnerClassification!='')
	 	        			{
	 		        		$scope.servicePartner.partnerClassification = data.servicePartner.partnerClassification.toString();;

	 	        			}
	 	        		
	 	        		angular.forEach(data.servicePartnerTable,function(value,key)
	 	    	        		{
	 	    	        			 if(value.keyCityId!=null && value.keyCityId!='')
	 	    	         			{
	 	    	             		$scope.servicePartnerTable[key].keyCityId = value.keyCityId.toString();;

	 	    	         			}
	 	    	        		});
	 	        		if(data.servicePartner.gSTNStateCode!=null && data.servicePartner.gSTNStateCode!='')
	         			{
	 		        		$scope.servicePartner.gSTNStateCode = data.servicePartner.gSTNStateCode.toString();;

	         			}	               
	 	        		
	                 }
	             });
	         }
	     }
		
		//kyc
		
		$scope.cancelCustomDetail = function(){
	        if($scope.rowCollectionFollowup.length > 0)
	        {  
	            // $scope.isLead = false;
	            $scope.isShow = true;
	            }
	        else                                            
	            $state.go('app.master.servicepartner.list',{tenantid:$stateParams.tenantid});
	        
	    }
		
		$scope.submitDetail = function(CommDetails){
		    
			
		    CommDetails.customId = $scope.servicePartner.servicePartnerCode ;
		   if($scope.customComm.subject != ""  || $scope.customComm.assignedTo != "" ||$scope.customComm.bookingCntctPrsn != "" || $scope.customComm.pricingCntctPrsn != "" || $scope.customComm.operationsCntctPrsn != "" || $scope.customComm.financeCntctPrsn != "" || $scope.customComm.teleNumber != "" || $scope.customComm.bookingCntctPrsnEmail != "" || $scope.customComm.pricingCntctPrsnEmail != "" || $scope.customComm.operationsCntctPrsnEmail != "" || $scope.customComm.financeCntctPrsnEmail != "" || $scope.customComm.faxNum != "" ){
		    if($scope.servicePartner.servicePartnerCode !='' && $scope.servicePartner.servicePartnerCode !=undefined)
		    {  
		    if(!$scope.isCustomFollowEdit ){
		     
		        debugger
		        $http.post($stateParams.tenantid+'/app/master/servicepartner/saveCustomerDetail', CommDetails).success(function(result) {
		          
		            if(result.success){
		                $scope.rowCollectionFollowup = result.customerMasterCommDetails;
		                $scope.isShow = true; 
		                logger.logSuccess("Customer Communication added successfully");
		            }else{
		                $scope.isShow = true; 
		                logger.logError("Customer not added");
		                return false;
		            }
		        }); 
		    }
		    else if ($scope.isCustomFollowEdit){
		        $http.post($stateParams.tenantid+'/app/master/servicepartner/updateCustomerDetail', CommDetails).success(function(result) {
		            console.log(result);
		            if(result.success){
		                $scope.rowCollectionFollowup = result.customerMasterCommDetails;
		                $scope.isShow = true; 
		                logger.logSuccess("Customer Communication updated successfully");
		                
		            }else{
		                $scope.isShow = true; 
		                logger.logError("Customer not updated");
		                return false;
		            }
		        });
		        $scope.isCustomFollowEdit = false;
		    }
		    
		     
		    // $scope.isShow = true;
		    //if($scope.status == '')
		    {
		    $scope.status = 0;
		    }
		   } 
		    }
		    else{
		        logger.logError("Please Fill Customer Details First.");
		    }
		    
		}
		$scope.editFollowRow = function(objLeadItem,index){
		    $scope.isCustomFollowEdit = true;
		    angular.copy(objLeadItem,$scope.customComm);
		    $scope.isShow = false; 
		}
		$scope.deleteFollow = function(customId,index){
		    var url=$stateParams.tenantid+'/app/master/servicepartner/deleteCustomerComm?customCommId='+index+'&customId='+customId;
		    $http.get(url).success(function(data){
		        if(data.success){
		            logger.logSuccess("Customer Communication deleted successfully");
		            $scope.rowCollectionFollowup = data.customerMasterCommDetails;
		            if(!$scope.rowCollectionFollowup.length > 0)
		                $scope.addFollowUpRow(); 
		        }else{
		            logger.logError("Error Please Try Again");
		        }
		    }).error(function(data) {
		        logger.logSuccess("Error in Delete!");
		    });
		}
		
		//email
		
		$scope.ValidateEmail=function(inputText)
		{
		var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
		if(inputText.match(mailformat))
		{
		
		return true;
		}
		else
		{
		logger.logError("You have entered an invalid email address!");
		$scope.servicePartner.emailId='';
		return false;
		}
		}

		});

app.controller('servicepartnerViewCtrl', function($scope, $rootScope, $http, $location, logger, ngDialog,
        utilsService,$state,sharedProperties,$window,$stateParams,toaster,validationService) {

 $scope.displayedCollection = [];
var date  = new Date();
var dateString =  date.getDate() + "/" + date.getMonth() + "/" + date.getFullYear() + " " + date.getHours() + ":" + date.getMinutes();
	$scope.rowCollectionFollowup=[];
    $scope.referralList=[];
    $scope.isEdit = false;
    $scope.tairDetailList =[];
	
	

    $scope.cancel = function() {
	  	  $state.go('app.master.servicepartner.list',{tenantid:$stateParams.tenantid});
	  	  
	          
	    };
    
	   
		    $scope.servicePartnerTable =[];
		    $scope.servicePartner = {
		            
		    		servicePartnerCode:'',
		    		servicePartnerName:'',
		    		branch:'',
		    		servicePartnerLedgerName:'',
		    		creditDaysOffered:'',creditAmt:'',
		    		active:true,
		    		city:'',
		    		region:'',
		            address:'',
		            country:'',
		    		zipCode:'',
		    		personToContact:'',
			    	designation:'',	 
			    	emailId:'',
			    	landLineNo:'',	
			    	mobileNo:'',
			    	salesPerson : '',
                     skypeId:'',	 
			    	 webSite:'',
			    	servicePartnerDescription:'',
		    		 pANNo:'',
		    	    partnerClassification:'',
		        	 gSTNStateCode:'',
		        	 defaultType:'',
		        	 gSTNNo:'',
		        	 exemptionUnder:'',
		        	 createdBy:'',
		        	 createdDate:'',
		        	 modifiedBy:'',
		        	 modifiedDate:'',
		        	 sundryStatus:'',
		        	 lServicePartnerBean:[]
		         };
		    
		  $scope.tempservicePartnerList = {
			select 		:false,
			contactName:'',
			keyDesignation:'',
			keyEmail:'',
			keyLandLineNo:'',	
	    	keyMobileNo:'',
	    	keySkypeId:'',	 
	    	keyCityId:'',	 
	    	remarks:'',	 
		};
    
		    $scope.sundryList=[{
		        id : '20000003',
		        text : 'Creditors - Local'
		    }, {
		        id : '20010003',
		        text : 'Creditors - Overseas'
		    },{
		        id : '10010004',
		        text : 'Debtors - Local'
		    }, {
		        id : '10080002',
		        text : 'Debtors - Overseas'
		    }];

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
			
			
			
			
		  $scope.salesTable =[];
		  $scope.tempsalesPersonList = {
					select1 :false,
					servicePartnerId:'',
					salesPerson:'',
					createdDate:'',
					ToDate:'',	
			    	 
				};
		  
		  $scope.tempsalesPersonList.FromDate = today;
		//kyc
		  $scope.tabs = [
		                   {title:"Customer Details", active: true},
		                   {title:"KYC", active:false, disabled: true}
		    ];
		  
		  $scope.CustomerMasterData = {
		            customerName : '',
		            address : '',
		            area : '',
		            countryName : '',
		            faxNo : '',
		            email : '',
		            currency : '',
		            bookingCntctPrsn : '',
		            pricingCntctPrsn : '',
		            operationsCntctPrsn : '',
		            financeCntctPrsn : '',
		            teleNumber : '',
		            shipper : '',
		            consignee : '',
		            notifyParty : '',
		            agreementParty : '',
		            jVPartner : '',
		            shareOfRVC : '',
		            slotSwap : '',
		            costRevenueSpaceShare : '',
		            deadFreight : '',
		            paymentCenter : '',
		            active : "Y",
		            slotOperator : "N",
		            subSlot : "N",
		            emailBooking : '',
		            emailPricing : '',
		            emailOperations : '',
		            emailFinance : '',
		            blRelated : "N",
		            city : '',
		            attachFileGroup : "P",
		            isVesselGrp : "N",
		            customerShortName : '',
		            address1 : '',
		            typeofCustomer : 'MLO',
		            telOfficeNum : '',
		            telexNum : '',
		            crLimit : '',
		            bankName:'',
		    		accountNumber:'',
		    		vatNum:'',
		    		cinNum :'',
		            exchangeRate : '',
		            bookingCntctPrsnEmail : '',
		            pricingCntctPrsnEmail : '',
		            operationsCntctPrsnEmail : '',
		            financeCntctPrsnEmail : '',
		            faxNum : '',
		            customer_category : '',
		            creditCustType : "N",
		            typeOfCustGrp : "P",
		            depositAmt : '',
		            companyTypeGrp : "MLO",
		            categoryWise : '',
		            controllingAgent : '',
		            customerVoyageList : [],
		            customerCode:'',
		            leadStatus:false,
		            leadId:'',
		            edit:false,
		            bankRTGS:'',
		            salesPerson:''
		    };

		  
		  $scope.addFollowUpRow = function() {
		        $scope.customComm = {
		                customCommunicate : '',
		                customBound : '',
		                subject : '',
		                message : '',
		                meetCallDate : dateString,
		                customId: '',
		                customCommId : '',
		                referral:'',
		                nextFollowUpDate:'',
		                assignedTo:'',
		                bookingCntctPrsn : '',
		                pricingCntctPrsn : '',
		                operationsCntctPrsn : '',
		                financeCntctPrsn : '',
		                teleNumber : '',
		                bookingCntctPrsnEmail : '',
		                pricingCntctPrsnEmail : '',
		                operationsCntctPrsnEmail : '',
		                financeCntctPrsnEmail : '',
		                faxNum : ''
		                
		            };
		        
		       $scope.isShow = false;
		        // $scope.rowCollectionFollowup.push(followUp1);
		    };
		    $scope.customComm = {
	                customCommunicate : '',
	                customBound : '',
	                subject : '',
	                message : '',
	                meetCallDate : dateString,
	                customId: '',
	                customCommId : '',
	                referral:'',
	                nextFollowUpDate:'',
	                assignedTo:'',
	                bookingCntctPrsn : '',
	                pricingCntctPrsn : '',
	                operationsCntctPrsn : '',
	                financeCntctPrsn : '',
	                teleNumber : '',
	                bookingCntctPrsnEmail : '',
	                pricingCntctPrsnEmail : '',
	                operationsCntctPrsnEmail : '',
	                financeCntctPrsnEmail : '',
	                faxNum : ''
	                
	            };
		    
		    
	 //add Row
	  $scope.addCredRow = function() {
	   
		  var tmp=angular.copy($scope.tempservicePartnerList);
			$scope.servicePartnerTable.push(tmp);

	  }
	  $scope.addCredRow();

		//add Row1
		  $scope.addCredRow1 = function() {
		   
			  var tmp=angular.copy($scope.tempsalesPersonList);
				$scope.salesTable.push(tmp);

		  }
		  $scope.addCredRow1();
		  var userid=$('#dumm').val();
		var servicePartnerId = $location.search().rowid;
		if(servicePartnerId!=null && servicePartnerId!=undefined && servicePartnerId>0){
			$scope.isEdit=true;
			
	        $http.post($stateParams.tenantid+'/app/master/servicepartner/view?servicePartnerId='+servicePartnerId).success(function(data) {
	        	if(data.success){
	        		$scope.servicePartner = data.servicePartner;
	        		$scope.servicePartnerTable=data.servicePartnerTable;
					$scope.servicePartnerType=data.servicePartnerType;
					$scope.salesTable=data.salesTable;
	        		$scope.servicePartner.city = data.servicePartner.city.toString();
	        		$scope.servicePartner.defaultType = data.servicePartner.defaultType.toString();;
	        		if(data.servicePartner.partnerClassification!=null&&data.servicePartner.partnerClassification!='')
	        			{
		        		$scope.servicePartner.partnerClassification = data.servicePartner.partnerClassification.toString();;

	        			}
	        		
	        		angular.forEach(data.servicePartnerTable,function(value,key)
	    	        		{
	    	        			 if(value.keyCityId!=null && value.keyCityId!='')
	    	         			{
	    	             		$scope.servicePartnerTable[key].keyCityId = value.keyCityId.toString();;

	    	         			}
	    	        		});
	        		if(data.servicePartner.gSTNStateCode!=null && data.servicePartner.gSTNStateCode!='')
        			{
		        		$scope.servicePartner.gSTNStateCode = data.servicePartner.gSTNStateCode.toString();;

        			}if(data.servicePartner.sundryStatus == null || data.servicePartner.sundryStatus == '')
        				{
        				$scope.unique = true;
        				}
        			else{
        				$scope.unique = false;
        			}

	        		
	        	}else{
	        		logger.logError("Unable to fetch data");
	        	}
	        });
		}
		  if( $scope.isEdit == false){
			  $http.post($stateParams.tenantid+'/app/master/servicepartner/getMapDetail').success(function(data) {
		          	if(data.success){
		          		$scope.servicePartnerType=data.servicePartnerType;
		          	}
		          });  
		  }
		
		  $http.post($stateParams.tenantid+'/app/master/servicepartner/dropDownList').success(function(data) {
	          	if(data.success){
	          		$scope.countryList=data.counryList;
	          		$scope.branchList=data.branchList;
	          		$scope.regionList=data.regionList;
	          		$scope.cityList=data.cityList;
	          		$scope.defaultTypeList=data.defaultTypeList;
	          		$scope.gstnStateList=data.gstnStateList;
	          		$scope.partnerClassificationList=data.partnerClassificationList;
	          		$scope.serviceList=data.serviceList;
	          		$scope.classificationList=data.classificationList;
	          	}
	          });
		  
		  $http.get($stateParams.tenantid+'/app/airquotation/getEmployeeList').success(function(datas) {
				 $scope.employeeList = datas.commonUtilityBean;
			    
			});
			
		  $scope.$watch('servicePartner.city', function(newValue,oldValue) {
				if (newValue != '' && newValue != undefined) {
					$http.post($stateParams.tenantid + '/app/master/servicepartner/countryList',newValue).success(function(datas) {
						console.log(datas);
						$scope.servicePartner.country = datas.country;
						$scope.servicePartner.region= datas.region;
					});
				}
			});
		
		
		//kyc
		
		$scope.cancelCustomDetail = function(){
	        if($scope.rowCollectionFollowup.length > 0)
	        {  
	            // $scope.isLead = false;
	            $scope.isShow = true;
	            }
	        else                                            
	            $state.go('app.master.servicepartner.list',{tenantid:$stateParams.tenantid});
	        
	    }
		
		$scope.editFollowRow = function(objLeadItem,index){
		    $scope.isCustomFollowEdit = true;
		    angular.copy(objLeadItem,$scope.customComm);
		    $scope.isShow = false; 
		}
		$scope.deleteFollow = function(customId,index){
		    var url=$stateParams.tenantid+'/app/master/servicepartner/deleteCustomerComm?customCommId='+index+'&customId='+customId;
		    $http.get(url).success(function(data){
		        if(data.success){
		            logger.logSuccess("Customer Communication deleted successfully");
		            $scope.rowCollectionFollowup = data.customerMasterCommDetails;
		            if(!$scope.rowCollectionFollowup.length > 0)
		                $scope.addFollowUpRow(); 
		        }else{
		            logger.logError("Error Please Try Again");
		        }
		    }).error(function(data) {
		        logger.logSuccess("Error in Delete!");
		    });
		}

		});
//});

