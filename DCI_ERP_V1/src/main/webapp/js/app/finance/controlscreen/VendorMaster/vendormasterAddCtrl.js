'use strict';
app.controller('vendorMasterAddCtrl', function($scope, $timeout, $stateParams,sharedProperties,toaster,
		$filter,validationService, $rootScope, $http, $location, logger, $state, ngDialog,$controller,$injector) {

	 $scope.displayedCollection = [];
	var date  = new Date();
	var dateString =  date.getDate() + "/" + date.getMonth() + "/" + date.getFullYear() + " " + date.getHours() + ":" + date.getMinutes();
		$scope.rowCollectionFollowup=[];
	    $scope.referralList=[];
	    $scope.isEdit = false;
	    $scope.tairDetailList =[];
	    $scope.commo='';
		
		  var userid=$('#dumm').val();

	    $scope.cancel = function() {
		  	  $state.go('app.finance.controlscreen.vendormaster',{tenantid:$stateParams.tenantid});
		  	  
		          
		    };
	    
		   
			    $scope.servicePartnerTable =[];
			    $scope.servicePartnerCharge =[];
			    $scope.commodityList=[];
			    $scope.servicePartner = {
			            
			    		servicePartnerCode:'',
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
			  $scope.tempservicePartnerChargeList = {
						select 		:false,
						charge:'',select1:false,
						unit:'',
						amt:'',
						currency:'',commodity:'',	commodity1:'',datetimepicker_port:'',uploadRef:'',
				    	date:'',
				    	pol:'',	 qty:'',
				    	pod:'',	 
				    	cntrType:'',	 
					};
			  $scope.tempservicePartnerChargeList1 = {
						select 		:false,select1:false,
						charge:'',
						unit:'',
						amt:'',
						currency:'',commodity:'',commodity1:'',	datetimepicker_port:'',uploadRef:'',
				    	date:'',
				    	pol:'',	 qty:'',
				    	pod:'',	 
				    	cntrType:'',	 
					};
			    $scope.sundryList=[{
			        id : '20010002',
			        text : 'Creditors - Local'
			    }, {
			        id : '20010003',
			        text : 'Creditors - Overseas'
			    },{
			        id : '10080003',
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
			                   {title:"Vendor Details", active: true},
			                   {title:"KYC", active:false, disabled: true}
			    ];
			  $scope.checkBox='0';
				 $scope.userId=$('#empId').val();

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
			    $scope.portList=[];
			    $scope.UnitList=[];
			    $scope.chargeHeadList=[];
			    $scope.conTypeList=[];
			    $scope.currencylist=[];
			    $http.get($stateParams.tenantid+'/app/seaquotation/getCurrencyList').success(function(datas) {	  
					$scope.currencylist= angular.copy(datas.commonUtilityBean);
				}).error(function(data) {

				});
			    $http.get($stateParams.tenantid+'/app/seaquotation/getChargeHeads').success(function(datas) {
					 $scope.chargeHeadList = datas.commonUtilityBean;
				    
				}).error(function(data) {

				});
			    
				$http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(datas) {	  
					  $scope.conTypeList=datas.getcontypelist;

				}).error(function(data) {

				});
			    $http.get($stateParams.tenantid+'/app/seaquotation/getiataList').success(function(datas) {
					debugger
				    $scope.portList = datas.commonUtilityBean;	    

				}).error(function(data) {

				});
				
				
				$http.get($stateParams.tenantid+'/app/seaquotation/getUnitList').success(function(datas) {
					 $scope.UnitList = datas.commonUtilityBean;
				    
				}).error(function(data) {

				});  
				
				 $scope.getDropDownListprt = function() {
					  $scope.servicePartnerCharge;
					  $http.post($stateParams.tenantid+'/app/seaquotation/getcommodity').success(function(data) {
				        	$scope.commodityList=data.commonUtilityBean;
				        	$timeout(function() {
				        		
				        		//$('#commodity1'+trIndex).multiselect('destroy')
				        	   	 $('.datetimepicker_port').each(function(){ 
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
				            
				            
				        }).error(function(data) {
				        });

				    }
				    //$scope.getDropDownListprt();
				    
			    
		 //add Row
		  $scope.addCredRow = function() {
		   
			  var tmp=angular.copy($scope.tempservicePartnerList);
				$scope.servicePartnerTable.push(tmp);

		  }
		  $scope.addCredRow();
		  $scope.addCredRow11 = function() {
			   
			  var tmp=angular.copy($scope.tempservicePartnerChargeList);
				$scope.servicePartnerCharge.push(tmp);
				
				$scope.getDropDownListprt();
				

		  }
		  $scope.addCredRow11();
		  $scope.removeCredRow11 =function(){
				$scope.tablerow = [];
				angular.forEach($scope.servicePartnerCharge,
						function(row, index) {
							var check = row.select;
							
							if (check == undefined || check == "") {
								$scope.tablerow.push(row);
							} else {

							}
						});
				$scope.servicePartnerCharge = $scope.tablerow;
			}
		  
		 
			$scope.removeCredRow =function(){
				$scope.tablerow = [];
				angular.forEach($scope.servicePartnerTable,
						function(row, index) {
							var check = row.select;
							
							if (check == undefined || check == "") {
								$scope.tablerow.push(row);
							} else {

							}
						});
				$scope.servicePartnerTable = $scope.tablerow;
			}
			//add Row1
			  $scope.addCredRow1 = function() {
			   
				  var tmp=angular.copy($scope.tempsalesPersonList);
					$scope.salesTable.push(tmp);

			  }
			  $scope.addCredRow1();
			  
			//download 
			  $scope.downloadNewFile = function(downloadFile) {
			      debugger

			      $('#tbnewExport').attr('href',downloadFile);
			      
			      $("#tbnewExport").bind('click', function() {
			  	   });
			  	   $('#tbnewExport').simulateClick('click');
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
			  $rootScope.uploadDocLink = function(element,i) {
				    $scope.imgfile = element.files[0];
				    $rootScope.uploadRef();
				}

				$rootScope.uploadRef = function() {
				    var imgfile = $scope.imgfile;
				    var fileExtension = imgfile.name;
				    var frmData = new FormData();
				    frmData.append("file", imgfile);
				    $scope.imgfile = frmData;
				    $.ajax({
				        type : "POST",
				        url : $stateParams.tenantid+"/app/master/servicepartnerNew/uploadfileleave",
				        data : frmData,
				        contentType : false,
				        processData : false,
				        success : function(result) {
				        	$scope.servicePartnerCharge.uploadRef = result.imgPath;
				            if (result.success) {
				                logger.logSuccess("File Uploaded Successfully");
				            } else {
				                logger.logError("Fail to Upload");
				            }
				        }
				    });
				};
				$scope.$watchCollection('servicePartnerTable[trIndex].remarks', function(newValue, oldValue) {
					
					 debugger;
					 
				  });
			var servicePartnerId = $location.search().rowid;
			if(servicePartnerId!=null && servicePartnerId!=undefined && servicePartnerId>0){
				$scope.isEdit=true;
				
		        $http.post($stateParams.tenantid+'/app/master/servicepartnerNew/edit?servicePartnerId='+servicePartnerId).success(function(data) {
		        	if(data.success){
		        		$scope.servicePartner = data.servicePartner;
		        		$scope.servicePartnerTable=data.servicePartnerTable;
						$scope.servicePartnerType=data.servicePartnerType;
	 					$scope.servicePartnerCharge=data.servicePartnerCharge;
	 					$scope.checkBox='';
	 					  
	 					  angular.forEach(data.servicePartnerType,function(val,key)
	 		  	        		{
	 						  if((val.id==3 && val.visible==true) && ($scope.userId=='E0001' || $scope.userId=='E0002' || $scope.userId=='E0003'|| $scope.userId=='E0006'  || $scope.userId=='E0016')){
	 		 						  $scope.checkBox='3';
	 		 					  }else  if((val.id==4&& val.visible==true) && ($scope.userId=='E0001' || $scope.userId=='E0002' || $scope.userId=='E0003'|| $scope.userId=='E0006' || $scope.userId=='E0016')){
	 		 						  $scope.checkBox='4';

	 		 					  }
	 		  	        		});
	 					 /* if($scope.checkBox='3'){
		 						$scope.servicePartnerCharge=data.servicePartnerCharge;
		 						$scope.servicePartnerCharge1=[];

	 					  }else  if($scope.checkBox='4'){
		 						$scope.servicePartnerCharge1=data.servicePartnerCharge;
		 						$scope.servicePartnerCharge=[];

	 					  }*/
	 				  
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
					//$scope.getDropDownListprt();

		        	/*  $http.post($stateParams.tenantid+'/app/seaquotation/getcommodity').success(function(data) {
				        	$scope.commodityList=data.commonUtilityBean;
				        	$timeout(function() {
				        		
				        		//$('#commodity1'+trIndex).multiselect('destroy')
				        	   	 $('.datetimepicker_port').each(function(){ 
				        	   		$(this).find("select").multiselect({
				        	   		maxHeight: 100, 
				        	   		includeSelectAllOption: true,
				        	   		selectAllText : 'Select All',
				        	   		enableFiltering : true,	
				        	   		disableIfEmpty: true,
				        	   		enableCaseInsensitiveFiltering: true,
				        	   		numberDisplayed: 1,
				        	   		onDropdownHide: function (event) {

				        	   		}
				        	   		});
				        	   		$(this).find("#multiselect-button").addClass("width_100 input-sm line-height-5");
				        	   		});
				        	   	 

				        	   	 
				        		
				        	}, 2, false);
				            
				            
				        });*/
		        	$http.post($stateParams.tenantid+'/app/seaquotation/getcommodity').success(function(datas) {
			        	$scope.commodityList=datas.commonUtilityBean;
			           	 angular.forEach(data.servicePartnerCharge, function(value1, key1) {
			             	 $scope.compaccList = [];

		             	 var valArr = value1.commodity.split(',');
		             	 var i = 0, size = valArr.length;
		             	 for (i; i < size; i++) {
		             	 angular.forEach($scope.commodityList, function(value, key) {
		             	 if (valArr[i] == value.id) {
		             	 $scope.compaccList.push(value);
		             	 }
		             	 });
		             	  
		             	 }
			             $scope.servicePartnerCharge[key1].commodity1 = $scope.compaccList;

			           	 });
			           	$timeout(function() {$('.datetimepicker_port').each(function(){
			           		$(this).find("select").multiselect('destroy');
			           		$(this).find("select").multiselect({
			           		maxHeight: 100,
			           		includeSelectAllOption: true,
			           		selectAllText : 'Select All',
			           		enableFiltering : true,
			           		disableIfEmpty: true,
			           		enableCaseInsensitiveFiltering: true,
			           		numberDisplayed: 1,
			           		onDropdownHide: function (event) {

			           		}
			           		});
			           		$(this).find("#multiselect-button").addClass("width_100 input-sm line-height-5");
			           		});
			           		}, 3, false);
		             	 
		             	
		             	 
		             	 });
		        	
		        });
			}
			
			  if( $scope.isEdit == false){
				  $http.post($stateParams.tenantid+'/app/master/servicepartnerNew/getMapDetail').success(function(data) {
			          	if(data.success){
			          		$scope.servicePartnerType=data.servicePartnerType;
			          	}
			          });  
			  }
			
			  $http.post($stateParams.tenantid+'/app/master/servicepartnerNew/dropDownList').success(function(data) {
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
		       
				
			 /* $http.get($stateParams.tenantid+'/app/seaquotation/getcommodity').success(function(datas) {
					
				    $scope.commodityList = datas.commonUtilityBean;	    

				}).error(function(data) {

				});*/
			  
			  
			  $http.get($stateParams.tenantid+'/app/airquotation/getEmployeeList').success(function(datas) {
					 $scope.employeeList = datas.commonUtilityBean;
				    
				});
				
			  $scope.$watch('servicePartner.city', function(newValue,oldValue) {
					if (newValue != '' && newValue != undefined) {
						$http.post($stateParams.tenantid + '/app/master/servicepartnerNew/countryList',newValue).success(function(datas) {
							console.log(datas);
							$scope.servicePartner.country = datas.country;
							$scope.servicePartner.region= datas.region;
						});
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
			  $scope.flag=true;

			  $scope.visible=function(val,visible){
				  $scope.getDropDownListprt();
				  if((val==3 && visible==true) && ($scope.userId=='E0001' || $scope.userId=='E0002' || $scope.userId=='E0003'|| $scope.userId=='E0006' || $scope.userId=='E0016')){
					  $scope.checkBox='3';
				  }else  if((val==4 && visible==true) && ($scope.userId=='E0001' || $scope.userId=='E0002' || $scope.userId=='E0003'|| $scope.userId=='E0006' || $scope.userId=='E0016')){
					  $scope.checkBox='4';
				  }else{
					  $scope.checkBox='';
				  }
				  angular.forEach($scope.servicePartnerType,function(value,key)
	  	        		{
					  if(val==3 ){
						  if((value.id==4 && value.visible==true) && ($scope.userId=='E0001' || $scope.userId=='E0002' || $scope.userId=='E0003'|| $scope.userId=='E0006' || $scope.userId=='E0016')){
							  $scope.checkBox='3';
							  value.visible=false;
							  logger.logError("Both Carrier and Transport selection is not allowed ");

						  }
						 }else if(val==4 ){
							  if((value.id==3 && value.visible==true) && ($scope.userId=='E0001' || $scope.userId=='E0002' || $scope.userId=='E0003'|| $scope.userId=='E0006' || $scope.userId=='E0016')){
								  $scope.checkBox='4';
								  value.visible=false;

				            		logger.logError("Both Carrier and Transport selection is not allowed ");

							  }
							 }
					});
			  }
			$scope.save = function(servicePartnerAddForm){
				if (new validationService().checkFormValidity(servicePartnerAddForm)) {
					$scope.servicePartnerTypeList=[];
					var flag=$scope.ValidateEmail($scope.servicePartner.emailId);
					if(flag==true){
					for(var i=0;i<$scope.servicePartnerType.length;i++)
						{
						if($scope.servicePartnerType[i].visible==true)
							{
							$scope.servicePartnerTypeList.push($scope.servicePartnerType[i].id)	

							}
						}
					angular.forEach($scope.servicePartnerCharge, function(item1, index1) {
			               $scope.servicePartnerCharge[index1].commodity1=item1.commodity1;

						var commodity='';
						if(item1.commodity1!=''){
			        	angular.forEach(item1.commodity1, function(item, index) {
		                	if(commodity!=null && commodity!=''){
		                    	commodity=commodity+','+item.id;
		                  }else{
		                    	commodity=item.id;
		                	}
		                	
		                })
						}else{
							item1.commodity1=[];
						}
		               $scope.servicePartnerCharge[index1].commodity=commodity;

			        	})
					var obj = {
							servicePartner : $scope.servicePartner,
							servicePartnerTable	: $scope.servicePartnerTable,
							servicePartnerCharge	: $scope.servicePartnerCharge,

							servicePartnerTypeList:$scope.servicePartnerTypeList
					}
					var v =0;
					angular.forEach($scope.servicePartnerTypeList,function(value,key)
		    	        		{
						if(value==3 || value==4){
							v=v+1;	
		    					}
						});
					if(v!=2){
					
					
		            $http.post($stateParams.tenantid+'/app/master/servicepartnerNew/save',obj).success(function(data) {
		            	
		            	if(data.success){
		            		logger.logSuccess("Vendor Id is "+data.code);
		            		$scope.tabs[1].active = true;
		            		//$scope.cancel();
		            	}else{
		            		logger.logError(data.message);
		            	}
		            	
		            });
					}
		            else{
	            		logger.logError("Both Carrier and Transport selection is not allowed ");

		            	}
		           
					}else{
						logger.logError("You have entered an invalid email address!");
					}
				}else {
		            toaster.pop('error', "Please fill the required fields", 
		                    logger.getErrorHtmlNew(servicePartnerAddForm.$validationSummary), 5000, 'trustedHtml');
		        }
			}
			$scope.update = function(servicePartnerAddForm){
				if (new validationService().checkFormValidity(servicePartnerAddForm)) {
					$scope.servicePartnerTypeList=[];
					var flag=$scope.ValidateEmail($scope.servicePartner.emailId);
					if(flag==true){
					for(var i=0;i<$scope.servicePartnerType.length;i++)
						{
						if($scope.servicePartnerType[i].visible==true)
							{
							$scope.servicePartnerTypeList.push($scope.servicePartnerType[i].id)	

							}
						}
		        	angular.forEach($scope.servicePartnerCharge, function(item1, index1) {
			               $scope.servicePartnerCharge[index1].commodity1=item1.commodity1;

					var commodity='';
					if(item1.commodity1!=''){

		        	angular.forEach(item1.commodity1, function(item, index) {
	                	if(commodity!=null && commodity!=''){
	                    	commodity=commodity+','+item.id;
	                  }else{
	                    	commodity=item.id;
	                	}
	                	
	                })
					}else{
						item1.commodity1=[];
					}
					
	               $scope.servicePartnerCharge[index1].commodity=commodity;
		        	})
					var obj = {
							servicePartner : $scope.servicePartner,
							servicePartnerTable	: $scope.servicePartnerTable,
							servicePartnerCharge	: $scope.servicePartnerCharge,

							servicePartnerTypeList:$scope.servicePartnerTypeList

					}
					/*var v =0;
					angular.forEach($scope.servicePartnerTypeList,function(value,key)
		    	        		{
						if(value==3 || value==4){
							v=v+1;	
		    					}
						});
					if(v!=2){*/
					
		            $http.post($stateParams.tenantid+'/app/master/servicepartnerNew/update',obj).success(function(data) {
		            	if(data.success){
		            		logger.logSuccess('Updated Successfully');
		            		$scope.cancel();
		            	}else{
		            		logger.logError(data.message);
		            	}
		            	
		            });
					/*}
		            else{
	            		logger.logError("Both Carrier and Transport selection is not allowed ");

		            	}*/
					}else{
						logger.logError("You have entered an invalid email address!");
					}
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
			$scope.reset=function(){
		         
		         if( $scope.isEdit == false){ 
		        	 $scope.servicePartner = {
		 		            
		 		    		servicePartnerCode:'',
		 		    		servicePartnerName:'',
		 		    		branch:'',
		 		    		servicePartnerLedgerName:'',
		 		    		creditDaysOffered:'',
		 		    		active:'',
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
		 	        $http.post($stateParams.tenantid+'/app/master/servicepartnerNew/edit?servicePartnerId='+$location.search().rowid).success(function(data) {

		                 if (data.success == true) {
		                	 $scope.servicePartner = data.servicePartner;
		 	        		$scope.servicePartnerTable=data.servicePartnerTable;
		 					$scope.servicePartnerType=data.servicePartnerType;
		 					$scope.servicePartnerCharge=data.servicePartnerCharge;
		 					angular.forEach(data.servicePartnerType,function(val,key)
		 		  	        		{
		 						  if((val.id==3 && val.visible==true) && ($scope.userId=='E0001' || $scope.userId=='E0002' || $scope.userId=='E0003'|| $scope.userId=='E0006' || $scope.userId=='E0016')){
		 		 						  $scope.checkBox='3';
		 		 					  }else  if((val.id==4&& val.visible==true) && ($scope.userId=='E0001' || $scope.userId=='E0002' || $scope.userId=='E0003'|| $scope.userId=='E0006' || $scope.userId=='E0016')){
		 		 						  $scope.checkBox='4';

		 		 					  }
		 		  	        		});
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
		                 $http.post($stateParams.tenantid+'/app/seaquotation/getcommodity').success(function(datas) {
		 		        	$scope.commodityList=datas.commonUtilityBean;
		 		           	 angular.forEach(data.servicePartnerCharge, function(value1, key1) {
		 		             	 $scope.compaccList = [];

		 	             	 var valArr = value1.commodity.split(',');
		 	             	 var i = 0, size = valArr.length;
		 	             	 for (i; i < size; i++) {
		 	             	 angular.forEach($scope.commodityList, function(value, key) {
		 	             	 if (valArr[i] == value.id) {
		 	             	 $scope.compaccList.push(value);
		 	             	 }
		 	             	 });
		 	             	  
		 	             	 }
		 		             $scope.servicePartnerCharge[key1].commodity1 = $scope.compaccList;

		 		           	 });
		 		           	$timeout(function() {$('.datetimepicker_port').each(function(){
		 		           		$(this).find("select").multiselect('destroy');
		 		           		$(this).find("select").multiselect({
		 		           		maxHeight: 100,
		 		           		includeSelectAllOption: true,
		 		           		selectAllText : 'Select All',
		 		           		enableFiltering : true,
		 		           		disableIfEmpty: true,
		 		           		enableCaseInsensitiveFiltering: true,
		 		           		numberDisplayed: 1,
		 		           		onDropdownHide: function (event) {

		 		           		}
		 		           		});
		 		           		$(this).find("#multiselect-button").addClass("width_100 input-sm line-height-5");
		 		           		});
		 		           		}, 3, false);
		 	             	 
		 	             	
		 	             	 
		 	             	 });
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
		            $state.go('app.finance.controlscreen.vendormaster',{tenantid:$stateParams.tenantid});
		        
		    }
			
			$scope.submitDetail = function(CommDetails){
			    
				
			    CommDetails.customId = $scope.servicePartner.servicePartnerCode ;
			   if($scope.customComm.subject != ""  || $scope.customComm.assignedTo != "" ||$scope.customComm.bookingCntctPrsn != "" || $scope.customComm.pricingCntctPrsn != "" || $scope.customComm.operationsCntctPrsn != "" || $scope.customComm.financeCntctPrsn != "" || $scope.customComm.teleNumber != "" || $scope.customComm.bookingCntctPrsnEmail != "" || $scope.customComm.pricingCntctPrsnEmail != "" || $scope.customComm.operationsCntctPrsnEmail != "" || $scope.customComm.financeCntctPrsnEmail != "" || $scope.customComm.faxNum != "" ){
			    if($scope.servicePartner.servicePartnerCode !='' && $scope.servicePartner.servicePartnerCode !=undefined)
			    {  
			    if(!$scope.isCustomFollowEdit ){
			     
			        debugger
			        $http.post($stateParams.tenantid+'/app/master/servicepartnerNew/saveCustomerDetail', CommDetails).success(function(result) {
			          
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
			        $http.post($stateParams.tenantid+'/app/master/servicepartnerNew/updateCustomerDetail', CommDetails).success(function(result) {
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
			    var url=$stateParams.tenantid+'/app/master/servicepartnerNew/deleteCustomerComm?customCommId='+index+'&customId='+customId;
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

app.controller('quotationtableCtrl', function( $http, $filter, logger,$stateParams,$scope,
		$timeout, sharedProperties,toaster, $rootScope, $location, $state, ngDialog,$controller,$injector) {
	var index1=0;
	
	 $rootScope.uploadDocLink = function(element) {
		 debugger
		    $scope.imgfile = element.files[0];
		    $rootScope.uploadRef();
		}

		$rootScope.uploadRef = function() {
		    var imgfile = $scope.imgfile;
		    var fileExtension = imgfile.name;
		    var frmData = new FormData();
		    frmData.append("file", imgfile);
		    $scope.imgfile = frmData;
		    $.ajax({
		        type : "POST",
		        url : $stateParams.tenantid+"/app/master/servicepartnerNew/uploadfileleave",
		        data : frmData,
		        contentType : false,
		        processData : false,
		        success : function(result) {
		        	$scope.servicePartnerCharge[index1].uploadRef = result.imgPath;
		            if (result.success) {
		                logger.logSuccess("File Uploaded Successfully");
		            } else {
		                logger.logError("Fail to Upload");
		            }
		        }
		    });
		};
	 $scope.watch= function(i) {
		 debugger
			 index1 = i;
			
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
	
	 $scope.userId=$('#empId').val();


    $scope.cancel = function() {
	  	  $state.go('app.finance.controlscreen.vendormaster',{tenantid:$stateParams.tenantid});
	  	  
	          
	    };
    
	   
		    $scope.servicePartnerTable =[];
		    $scope.servicePartner = {
		            
		    		servicePartnerCode:'',
		    		servicePartnerName:'',
		    		branch:'',
		    		servicePartnerLedgerName:'',
		    		creditDaysOffered:'',
		    		active:'',
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
		        id : '20010002',
		        text : 'Creditors - Local'
		    }, {
		        id : '20010003',
		        text : 'Creditors - Overseas'
		    },{
		        id : '10080003',
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
		    
		    $scope.servicePartnerCharge=[{
			select 		:false,
			charge:'',
			unit:'',
			amt:'',
			currency:'',commodity:'',	commodity1:'',uploadRef:'',
	    	date:'',
	    	pol:'',	 qty:'',
	    	pod:'',	 
	    	cntrType:''
	    		}]	 
		
		    
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
			
	        $http.post($stateParams.tenantid+'/app/master/servicepartnerNew/view?servicePartnerId='+servicePartnerId).success(function(data) {
	        	if(data.success){
	        		$scope.servicePartner = data.servicePartner;
	        		$scope.servicePartnerCharge=data.servicePartnerCharge;
	        		$scope.servicePartnerTable=data.servicePartnerTable;
					$scope.servicePartnerType=data.servicePartnerType;
					$scope.salesTable=data.salesTable;
	        		$scope.servicePartner.city = data.servicePartner.city.toString();
	        		$scope.servicePartner.defaultType = data.servicePartner.defaultType.toString();;
	        		if(data.servicePartner.partnerClassification!=null&&data.servicePartner.partnerClassification!='')
	        			{
		        		$scope.servicePartner.partnerClassification = data.servicePartner.partnerClassification.toString();;

	        			}
	        		$scope.checkBox='';
	        		angular.forEach(data.servicePartnerType,function(value,key){
	        			if((value.id==3 && value.visible ==true) && ($scope.userId=='E0001' || $scope.userId=='E0002' || $scope.userId=='E0003'|| $scope.userId=='E0006' || $scope.userId=='E0016')){
	        				$scope.checkBox='3';
	        			}else if((value.id==4 && value.visible ==true) && ($scope.userId=='E0001' || $scope.userId=='E0002' || $scope.userId=='E0003'|| $scope.userId=='E0006' || $scope.userId=='E0016')){
	        				$scope.checkBox='4';
	        			}
	        			
	        	})
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
			  $http.post($stateParams.tenantid+'/app/master/servicepartnerNew/getMapDetail').success(function(data) {
		          	if(data.success){
		          		$scope.servicePartnerType=data.servicePartnerType;
		          	}
		          });  
		  }
		
		  $http.post($stateParams.tenantid+'/app/master/servicepartnerNew/dropDownList').success(function(data) {
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
					$http.post($stateParams.tenantid + '/app/master/servicepartnerNew/countryList',newValue).success(function(datas) {
						console.log(datas);
						$scope.servicePartner.country = datas.country;
						$scope.servicePartner.region= datas.region;
					});
				}
			});
		
		//download 
		  $scope.downloadNewFile = function(downloadFile) {
		      debugger

		      $('#tbnewExport').attr('href',downloadFile);
		      
		      $("#tbnewExport").bind('click', function() {
		  	   });
		  	   $('#tbnewExport').simulateClick('click');
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
		  $rootScope.uploadDocLink = function(element,i) {
			    $scope.imgfile = element.files[0];
			    $rootScope.uploadRef();
			}

			$rootScope.uploadRef = function() {
			    var imgfile = $scope.imgfile;
			    var fileExtension = imgfile.name;
			    var frmData = new FormData();
			    frmData.append("file", imgfile);
			    $scope.imgfile = frmData;
			    $.ajax({
			        type : "POST",
			        url : $stateParams.tenantid+"/app/master/servicepartnerNew/uploadfileleave",
			        data : frmData,
			        contentType : false,
			        processData : false,
			        success : function(result) {
			        	$scope.servicePartnerCharge.uploadRef = result.imgPath;
			            if (result.success) {
			                logger.logSuccess("File Uploaded Successfully");
			            } else {
			                logger.logError("Fail to Upload");
			            }
			        }
			    });
			};
		//kyc
		
		$scope.cancelCustomDetail = function(){
	        if($scope.rowCollectionFollowup.length > 0)
	        {  
	            // $scope.isLead = false;
	            $scope.isShow = true;
	            }
	        else                                            
	            $state.go('app.finance.controlscreen.vendormaster',{tenantid:$stateParams.tenantid});
	        
	    }
		
		$scope.editFollowRow = function(objLeadItem,index){
		    $scope.isCustomFollowEdit = true;
		    angular.copy(objLeadItem,$scope.customComm);
		    $scope.isShow = false; 
		}
		$scope.deleteFollow = function(customId,index){
		    var url=$stateParams.tenantid+'/app/master/servicepartnerNew/deleteCustomerComm?customCommId='+index+'&customId='+customId;
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


