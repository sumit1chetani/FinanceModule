'use strict';
app.controller('mrgListCtrl', function($scope, $timeout, $stateParams,
		$filter, $rootScope, $http, $location, logger, $state, ngDialog) {

    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.rowCollection = [];
    $scope.customerDropList = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    
    $scope.mrgBean = {
    		customer:'',
    		serviceType : '',
    		pol:'',
    		pod:'',
    		region:'',
    		country:''
    };
    
    if(localStorage.getItem('mrgBeanObj')!=null && localStorage.getItem('mrgBeanObj')!=undefined){
		$scope.mrgBean = JSON.parse(localStorage.getItem('mrgBeanObj'));
	}
    
    
    
    $scope.getlist=function(mrgBean){
    	localStorage.setItem('mrgBeanObj',JSON.stringify($scope.mrgBean));
        $http.post($stateParams.tenantid+'/app/mrg/list',mrgBean ).success(function(datas) {
            console.log(datas);
            $scope.rowCollection = datas;
        	
            }).error(function(datas) {
        });
        };
        $scope.getlist($scope.mrgBean);
        
    $scope.add = function() {
    	localStorage.setItem('mrgBeanObj',JSON.stringify($scope.mrgBean));
        $state.go('app.master.mrg.add',{tenantid:$stateParams.tenantid});
    };
    
    
 // Redirecting Page For Edit Functionality
    $scope.editRow = function(mrgId) {
    	debugger
    	localStorage.setItem('mrgBeanObj',JSON.stringify($scope.mrgBean));
        $location.url($stateParams.tenantid+'/marketing/mrg/edit?mrgNumber='+mrgId);
    };
    $scope.view = function(mrgId) {
    	debugger
    	localStorage.setItem('mrgBeanObj',JSON.stringify($scope.mrgBean));
        $location.url($stateParams.tenantid+'/marketing/mrg/view?mrgNumber='+mrgId);
    };
//    $scope.editRow = function(rowid) {   
//    	
//    	$location.url($stateParams.tenantid+'/master/containersize/edit?rowid='+rowid);    
//     }
//    
    $scope.deleteRow = function(mrgId) {
        ngDialog.openConfirm().then(function() {
        var url = $stateParams.tenantid+'/app/mrg/delete?mrgId=' + mrgId;
            $http.get(url).success(function(result){
                if (result.success ==  true) {
                    logger.logSuccess("Deleted Successfully");
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


	  $scope.getdropdown = function() {

		    var serviceList = [ {
		        id : '1',
		        text : 'EXPORT'
		    }, {
		        id : '2',
		        text : 'IMPORT'
		    }]
			
			$scope.servicePartnerTypelist=serviceList;
		    

			//customerDropdown
			$http.post($stateParams.tenantid+'/app/seaquotation/getServicePartnerList').success(function(datas) {
				debugger
				 $scope.customerDropList = datas.customerList;
			}).error(function(data) {

			});
			
			$http.get($stateParams.tenantid+'/app/seaquotation/getiataList').success(function(datas) {
				debugger
			    $scope.portList = datas.commonUtilityBean;	    

			}).error(function(data) {

			});
		  
			$http.post($stateParams.tenantid+'/app/ratequotation/getShipment').success(function(datas) {
					  $scope.shipmentList=datas.getshipmentlist;
					  /*$scope.portList=datas.polListTrans;

					  $scope.polList=datas.mrgPolList;*/
					  //$scope.customerDropList=datas.getcustomerlist;
					  $scope.currencyList=datas.getcurrencylist	;
					  $scope.conTypeList=datas.getcontypelist;
					   $scope.chargeTypeList=datas.getchargetypelist;
					//logger.logSuccess('Mail Sent Successfully!')
				}).error(function(datas) {

				});
			
			
			  
			  
			  $http.post($stateParams.tenantid+'/app/commonUtility/getPortByEmpAgn').success(function(data) {
					$scope.potList=data;
//					$scope.polList=data;
					
					        		
			});
		

				 $http.post($stateParams.tenantid+'/app/commonUtility/regionList').success(function(data) {
					  	
						$scope.regionList = data.lCommonUtilityBean;
						        		
				});
				
				 $http.post($stateParams.tenantid+'/app/commonUtility/getCountryListPortmaster').success(function(data) {
					  	
						$scope.countryList = data;
						        		
				});
			
			  }
			  $scope.getdropdown(); 
			  
			  $scope.reset = function(){
				   
				    $scope.mrgBean = {
				    		customer:'',
				    		pol:'',
				    		pod:'',
				    		region:'',
				    		country:''
				    };
			        $scope.getlist($scope.mrgBean);

			  }

				$scope.sendMail	= function(mrgNo){
					$scope.mrgBean.mrgNo = mrgNo;
				    $http.post($stateParams.tenantid+'/app/mrg/SendMailRRR', $scope.mrgBean).success(function(response) {
//				    alert(5);
//				        logger.logSuccess("Mail Sent successfully!");

				    	if(response.success){
					        logger.logSuccess(response.message);

				    	}else {
					        logger.logError(response.message);

				    	}
				    });
				}

			 	 // 
			 	   
			 	//import Excel
			 	        $scope.fileUpload = function() {
			 	            ngDialog.close();
			 	            ngDialog.open({
			 	                template : 'fileModal',
			 	                scope : $scope
			 	            });
			 	        };

			 	        $rootScope.uploadFile = function(element) {
			 	            
			 	            console.log("excel file");
			 	            $scope.excelfile = element.files[0];
			 	            console.log($scope.excelfile);
			 	        };
			 	        
			 	        $rootScope.closeFileDialog = function() {
			 	            ngDialog.close();
			 	        };
			 	        
			 	        $rootScope.uploadMRG = function() {
			 	            ngDialog.close();
			 	            var excelfile = $scope.excelfile;
			 	            var fileExtension = excelfile.name;
			 	            var fName = [];
			 	            fName = fileExtension.split(".");
			 	            for (var i = 0; i < fName.length; i++) {
			 	                if (fName[i] == "xls" || fName[i] == "xlsx") {
			 	                    var frmData = new FormData();
			 	                    frmData.append("file", excelfile);
			 	                    $.ajax({
			 	                        type : "POST",
			 	                        url : $stateParams.tenantid+'/app/mrg/uploadfile',
			 	                        data : frmData,
			 	                        contentType : false,
			 	                        processData : false,
			 	                        success : function(result) {
			 	                            console.log("result");
			 	                            console.log(result);
			 	                            if (result.success) {
			 	                                logger.logSuccess("File Uploaded Successfully "+result.totalImportCount+" - Rows Inserted  ");
			 	                                $scope.getList();
			 	                                $scope.getEmployeeList();  
			 	                            } else {
			 	                               var value = result.message;
//			 	                                document.getElementById("id").innerHTML =  result.message;

//			 	                                logger.logError("Fail to Upload\n" + result.message);
//			 	                                alert("I will get back to you soon\nThanks and Regards\nSaurav Kumar");
//			 	                                ngDialog.openConfirm({
//			 	                                    
//			 	                                    template : 'modalDialogId6',
//			 	                                    className : 'ngdialog-theme-default'
//			 	                                })
			 	                               if(value == "true")
				                            	   logger.logSuccess("Uploaded successfully!");

			 	                               else
			 	 	                              logger.logError(value);

//			 	                                $scope.callDialog($scope,value, $http, $controller,ngDialog, logger,  sharedProperties,  $rootScope);
//			 	                            
			 	                            }

			 	                        }

			 	                    });
			 	                }

			 	            }
			 	        };
			 	        

				 	       //Excel Export	
			 	        $scope.exportExcel = function(mrgBean){
			 	     		  var flag = false;
//			 	     		  mrgbean.mrgHdrNo = mrgNo;
			 	     	   	 $http.post($stateParams.tenantid+'/app/mrg/ExportExcel', mrgBean).success(function(response) {

			 	     	                if(response.success){
			 	     	                    debugger;
			 	     	                    $("#mrgdtl").bind('click', function() {
			 	     	                    	
			 	     	                    });
			 	     	                    $('#mrgdtl').simulateClick('click');
			 	     	                    logger.logSuccess("Exported successfully!");
			 	     	                }else{
									        logger.logError(response.message);
			 	     	                }
			 	     	                
			 	     	            }).error(function(response) {
			 	     	                logger.logError("Error Please Try Again");
			 	     	            });
//			 	       	  }
			 	     	    }
			 	        
				 	     	 $scope.exportPDFnew = function(mrgbean,mrgNo){
				 	     		  var flag = false;
				 	     		  mrgbean.mrgHdrNo = mrgNo;
				 	     	   	 $http.post($stateParams.tenantid+'/app/mrg/ExportPDF', mrgbean).success(function(response) {

				 	     	                if(response.success){
				 	     	                    debugger;
				 	     	                    $("#sailingsch").bind('click', function() {
				 	     	                    	
				 	     	                    });
				 	     	                    $('#sailingsch').simulateClick('click');
				 	     	                    logger.logSuccess("Exported successfully!");
				 	     	                }else{
										        logger.logError(response.message);
				 	     	                }
				 	     	                
				 	     	            }).error(function(response) {
				 	     	                logger.logError("Error Please Try Again");
				 	     	            });
//				 	       	  }
				 	     	    }
				 	     	    
				 	     	
			 	       
			 	       //Excel PDF	
			 	     	 $scope.exportPDF = function(mrgbean){
			 	     		  var flag = false;
//			 	       	  if($scope.blissuedreport.fromDate !='' && $scope.blissuedreport.fromDate !=null){
//			 	       		  flag = true;
//			 	       		  if($scope.blissuedreport.toDate !='' && $scope.blissuedreport.toDate !=null){
//			 	       			  flag = false;
//			 	       		  }else{
//			 	       			  logger.logError("Please select To Date...!!!");
//			 	       		  }
//			 	       	  }
			 	           	
//			 	       	  if(flag == false){
//			 	     	   	 $http.post($stateParams.tenantid+'/app/mrg/ExportPDF', mrgbean).success(function(response) {
				 	     	   	 $http.post($stateParams.tenantid+'/app/mrg/ExportPDFBulk', mrgbean).success(function(response) {

			 	     	                if(response){
			 	     	                    debugger;
			 	     	                    $("#sailingsch").bind('click', function() {
			 	     	                    	
			 	     	                    });
			 	     	                    $('#sailingsch').simulateClick('click');
			 	     	                    logger.logSuccess("Exported successfully!");
			 	     	                }else{
									        logger.logError(response.message);
			 	     	                }
			 	     	                
			 	     	            }).error(function(response) {
			 	     	                logger.logError("Error Please Try Again");
			 	     	            });
//			 	       	  }
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
			 	     	  
			 	     	  // send bulk mail ROhini
			 	     	$scope.sendMailwithPDF =  function(mrgBean){
//							$scope.mrgBean.mrgNo = mrgNo;
						    $http.post($stateParams.tenantid+'/app/mrg/SendBulkMail', $scope.mrgBean).success(function(response) {
//						    alert(5);
//						        logger.logSuccess("Mail Sent successfully!");

						    	if(response.success){
							        logger.logSuccess(response.message);

						    	}else {
							        logger.logError(response.message);

						    	}
						    });
						}
			 	     	

			 	     	$scope.importLog = function(){
						    $http.post($stateParams.tenantid+'/app/mrg/getmrgLog', $scope.mrgBean).success(function(response) {
						    $scope.mrgLog = response;
						    });

//				             template : 'views/salesmarketing/mrg/mrgLog',
					         ngDialog.open({
//					             template : 'views/sales/ratequotation/ratequotationApprovalRemarks',
					             template : 'views/salesmarketing/mrg/mrgLog',
					             scope :$scope
					         });
			 	     	}
			 	     	

			 		    $scope.downloadNewFile = function(id) {
			 		        debugger
			 		        
			 		        
			 		        $timeout(function(){ $("#tbnewExport"+id).simulateClick('click')},100);
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

			 	        $scope.cancel = function() {
			 	            ngDialog.close();    
			 	        };
//			 		   COPY MRG ...................
			 	        $scope.copyMRG = function(mrgBean){
			 	        	if(mrgBean.pol != null && mrgBean.pol != "" && mrgBean.pol != undefined)
			 	        	{
			 	        		if(mrgBean.pod != null && mrgBean.pod != "" && mrgBean.pod != undefined)
				 	        	{
//								    $http.get($stateParams.tenantid+'/app/mrg/getMRGno?pol='+ mrgBean.pol +'&pod='+mrgBean.pod).success(function(response) {
								    	
								    	if(mrgBean.mrgHdrNo != null && mrgBean.mrgHdrNo != "" && mrgBean.mrgHdrNo != undefined)
				 	        	        $location.url($stateParams.tenantid+'/marketing/mrg/copy?MRGCopy='+mrgBean.mrgHdrNo);
								    	else
									        logger.logError("MRG Not Available for POL-: "+mrgBean.pol+" and POD-: "+mrgBean.pod+" !");
//									    });
				 	        	}else{

							        logger.logError("Please Select POD !");
				 	        	}
			 	        	}else{

						        logger.logError("Please Select POL !");

			 	        	}
			 	        }
			 	        
			 	        //  END .........
});
