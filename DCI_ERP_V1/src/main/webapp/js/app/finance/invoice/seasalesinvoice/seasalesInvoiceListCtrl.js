'use strict';
app.controller('SeasalesInvoiceListCtrl', function($scope, $rootScope, $http, $location, logger, $log, ngDialog, 
        $modal, utilsService, sharedProperties, $state,$window,$controller,$stateParams) {

    $scope.pageCounters = [14, 16, 17, 18, 150, 500, 1000 ];
    $('.rounded').val($rootScope.SeasalesInvoiceListCtrl);
  
    
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 14;
    $scope.initial = {}; 
    $scope.isAdd = true; 
    $scope.hideDownloadIcon= true;
    $scope.salesInvoiceList=[];
    $scope.salesInvoiceListDraft=[];
    $scope.fromToPurInvList=[];
    $scope.bulkPurInvoice = {
            fromPurInvoiceNo:'',
            toPurInvoiceNo:'',
            fromDate : '',
            toDate : ''
            
    }
    $scope.polList = [];
	$scope.podList = [];
	$scope.vesselList = [];
	$scope.voyageList = [];
    $scope.customerDropList =[];
    $scope.modeList=[];
	$scope.getQuotationType = function() {
		var data = {};
		data["id"] = "1";
		data["text"] = "SEA COASTAL";
	    $scope.modeList.push(data);
	     //$scope.bookingData.mode='1';
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
			 data = {};
    	    data["id"] = "5";
    	    data["text"] = "FORWARDING";
    	    $scope.modeList.push(data);
		// data = {};
		// data["id"] = "2";
		// data["text"] = "SEA";
		// $scope.modeList.push(data);
	}
    $scope.getQuotationType();
    		$http.get($stateParams.tenantid+ '/app/commonUtility/getVesselList').success(function(data) {
				$scope.vesselList = data;
//				$scope.voyageList = data.voyageList;
//				$scope.polList = data.polList;
//				$scope.podList = data.polList;
			});
			
			 $scope.$watch('purchaseInvoiceData.vessel', function(newValue, oldValue) {
			      if(newValue!=null && newValue!=undefined && newValue != ''){
			    	  $http.post($stateParams.tenantid+ '/app/commonUtility/getVoyageListByVessel',newValue).success(function(data) {
							$scope.voyageList = data;
			    	  });
			      }
			      
                });
                $http.post($stateParams.tenantid+'/app/seaquotation/getServicePartnerList').success(function(datas) {
		 $scope.customerDropList = datas.customerList;

		});
    $scope.purchaseInvoiceData = {
            puchaseInvoiceNo :'',
            puchaseInvoiceDate :'',
            supplier :'',
            partyInvoiceNo :'',
            partyInvoiceDate :'',
            purchaseDraftNo: '',mode:'',vessel:'',voyage:'',customer:'',
            draftMode:'',
            purchaseNo :'',
            dueDate :'',
            currency :'',
            exgRate :'',
            amountLocal :'',
            amountUSD :'',
            company :'',
            description :'',
            type:'',
            purInvDetail : [],
            detailArr:[],
            edit : false,
            fromDate : '',
            toDate : ''
         };
    $scope.currentURL=$location.protocol() + '://'+ $location.host() +':'+  $location.port()+"/#" +$location.path();
    
    if(window.localStorage.getItem('purchaseIv_list')==$scope.currentURL){
        alert('window ' + $scope.currentURL + ' is already opened');
       // window.focus();
        //window.open($rootScope.currentURL,'_self').close();
      
       // window.close();
       // localStorage.removeItem('purchaseIv');
    }else{
        window.localStorage.setItem('purchaseIv', $scope.currentURL);
        window.localStorage.removeItem('purchaseIv');
        //window.localStorage.removeItem('purchaseIv');
    }
    $scope.showSalesGrid=false;
    $http.post($stateParams.tenantid + '/app/dashboard/checkWhichUser').success(function(data) {
		if (data[1].userId=='E0003') {
			$scope.showSalesGrid=true;
			
			
		}

	/*}).error(function(data) {
		logger.logError("Error Please Try Again");*/
    });
    $http.get($stateParams.tenantid + '/app/seasalesinvoice/getlist').success(
			function(response) {
				$scope.rowCollection = response.salesInvoiceList;
			});
    
    $http.get($stateParams.tenantid + '/app/seasalesinvoice/getDraftList').success(
			function(response) {
				$scope.salesInvoiceListDraft = response.salesInvoiceListDraft;
			});
    
    
    
    
    
    $scope.verified = function(objPuInvHdrLstBean) {
        $http.post($stateParams.tenantid+'/app/purchaseinvoice/toVerify', objPuInvHdrLstBean).success(function(result) {
            if (result) {
                objPuInvHdrLstBean.verified=true;
                logger.logSuccess("Purchase Invoice verified successfully");
               // $scope.search();
            }
        });
    }
    
    $scope.saveDraft = function(salesSNo) {
    	$rootScope.SeasalesInvoiceListCtrl=$('.rounded').val();
    	debugger
		$scope.modeType=1;
		$scope.invoiceType=1;
	        $http.get($stateParams.tenantid+'/jobOrderMonthClose/getInvoiceDate?mode=' + $scope.modeType +'&invoiceId='+ salesSNo +'&invoiceType='+ $scope.invoiceType).success(function(datas) {
	            if(datas){
	                logger.logError("Job Order Closed Pls Contact IT Support");
                 }else{
                 	$location.path($stateParams.tenantid+"/invoice/seasalesinvoice/salesInvoiceDraftEdit/"+salesSNo);
                 }
	        })
 
    };
    
    
    $scope.binu = false;
    $scope.search = function(){
        $scope.rowCollection = [];
        $scope.purchaseInvoiceData.fromDate = $scope.bulkPurInvoice.fromDate;
        $scope.purchaseInvoiceData.toDate = $scope.bulkPurInvoice.toDate;
        if(($scope.purchaseInvoiceData.fromDate == "" || $scope.purchaseInvoiceData.fromDate == undefined) && 
                ($scope.purchaseInvoiceData.toDate == "" || $scope.purchaseInvoiceData.toDate == undefined)){
            $scope.getPurchaseInvoiceList();
        }else{
            $http.post($stateParams.tenantid+'/app/purchaseinvoice/getListByDate',$scope.purchaseInvoiceData).success(function(data) {
                if(data.success){
                    console.log("from date")
                    console.log(data)
                    $scope.rowCollection = $scope.rowCollection.concat(data.objPuInvHdrLstBean);
                    if($scope.rowCollection[0].loginId == 'E108')
                        $scope.binu = true;
                }
            })
        }
    }
    
   console.log("form code")
   console.log($('#form_code_id').val())
    $scope.getPurchaseInvoiceList = function() {
       $scope.rowCollection = [];
        $http.get($stateParams.tenantid+'/app/purchaseinvoice/list?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount + '&formCode='+$('#form_code_id').val()).success(function(data) {
           if (data.success == true ) {
               console.log("&&&&&&&&&&&&&&&&&&&&")
               console.log(data.objPuInvHdrLstBean)
                /*$scope.rowCollection = $scope.rowCollection.concat(data.objPuInvHdrLstBean);*/
                /*if($scope.rowCollection[0].loginId == 'E108')*/
                    $scope.binu = true;
            }
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
    };

    $scope.getPurchaseInvoiceList();

    
    $scope.getPurInvoiceDropdownList = function() {
        $http.get($stateParams.tenantid+'/app/purchaseinvoice/list?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount + '&formCode='+$('#form_code_id').val()).success(function(data) {
            if (data.success == true && !utilsService.isUndefinedOrNull(data.objPuInvHdrLstBean)) {
                var arr=[];
                angular.forEach(data.objPuInvHdrLstBean,function(row,index){
                    var obj = new Object();
                    obj.id = row.puchaseInvoiceNo;
                    obj.text = row.puchaseInvoiceNo;
                    
                    arr.push(obj);
                });
                $scope.fromToPurInvList = arr;
             }
         }).error(function(data) {
             logger.logError("Error Please Try Again");
         });
    }
    $scope.getPurInvoiceDropdownList();
    
    
    $scope.bulkPrint= function(fromPurInvoiceNo,toPurInvoiceNo){
        //bulkPurInvoice.fromPurInvoiceNo,bulkPurInvoice.toPurInvoiceNo
        var url = $stateParams.tenantid+'/app/purchaseinvoice/bulkPrint?fromPurInvoiceNo=' + fromPurInvoiceNo+"&toPurInvoiceNo="+toPurInvoiceNo;
        var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
        wnd.print();   
     }
    
    //** ********Add,Edit and Delete******** *//*
  $scope.add = function() {
	  $rootScope.SeasalesInvoiceListCtrl=$('.rounded').val();
      $scope.isAdd  = true;
      $location.path($stateParams.tenantid+"/invoice/sea/salesinvoice/SalesInvoiceAdd");
      
  };

  $scope.fileUpload = function () {
          ngDialog.open({
              template : 'fileModal',
              scope :$scope
          });
      
  }
  
  
  $scope.viewDraft = function(limit, offset) {
	  $rootScope.SeasalesInvoiceListCtrl=$('.rounded').val();
      $state.go('app.salesmarketing.seasalesinvoiceDraft',{tenantid:$stateParams.tenantid});
  };
  $rootScope.uploadPIFile = function(element){
      $scope.excelfile = element.files[0];
      console.log($scope.excelfile);
  }
  
  $rootScope.uploadPIStatement =function(){
      ngDialog.close();
      var excelfile=$scope.excelfile;
      var fileExtension= excelfile.name;
      var fName=[];
      fName=fileExtension.split(".");
      console.log(fName);
      for(var i=0;i<fName.length;i++){
          if(fName[i] == "xls" || fName[i] == "xlsx"){
              var frmData=new FormData();
              frmData.append("file",excelfile);
              $.ajax({
                  type : "POST",
                  url : "app/purchaseinvoice/bulkUpload",
                  data : frmData,
                  contentType: false,
                  processData: false,
                  success : function(result) {
                      console.log(result);
                      if(result.success){
                          logger.logSuccess("Purchase Invoices generated sucessfully");
                          $state.reload();
                      }else{
                          logger.logError(result.message);
                          $state.reload();
                      }                      
                  }
                 
              });
          }
          
      }
  }
  
  // Draft Invoice Delete
	$scope.deleteInvoice = function(sNo) {
		ngDialog
				.openConfirm()
				.then(
						function() {
							$http.post($stateParams.tenantid + '/app/seasalesinvoice/cancel?sNo=',+ sNo).success(function(data) {
							if(data.success==true){
						    logger.logSuccess('Invoice Deleted Successfully.');
						    $state.reload();
						    $location.path($stateParams.tenantid+ "/invoice/sea/seasalesinvoice/SalesInvoiceList");
							}else{
								 logger.logError(data.message);
							}
							}).error(function(data) {
					    });
				});
	};
  
  
  $scope.clickTestInvoiceMail = function(purchaseInvoiceNo) {
    
        //  var url = $stateParams.tenantid+'/app/purchaseinvoice/bulkPrint?fromPurInvoiceNo=' + fromPurInvoiceNo+"&toPurInvoiceNo="+toPurInvoiceNo;

          var myURL = $stateParams.tenantid+'/app/seasalesinvoice/sendMail?purchaseInvoiceNo=' + purchaseInvoiceNo;
          $http({
              method : 'post',
              url : myURL,
              //data : purchaseInvoiceNo1,
          }).success(function(data) {
              if (data == true) {                    
                  logger.logSuccess("Mail Sent Successfully");
                  $state.reload();
              } else {
                   logger.logSuccess("Mail Sent Successfully");
                  $state.reload();
              }
          }).error(function(data) {
              logger.logSuccess("Error in Delete!");
          });


  };
  
  $scope.fileDownload = function(){
      var url = $stateParams.tenantid+"/assets/excelDocument/PURCHASE_INV_BULK.xlsx"
      $window.location.href = url;

  }
 
  
    // Redirecting Page For Edit Functionality
    $scope.editRow = function(purchaseInvoiceNo,index) {
    	$rootScope.SeasalesInvoiceListCtrl=$('.rounded').val();
        $scope.isAdd  = false;
        $location.path($stateParams.tenantid+"/invoice/purchaseinvoice/PurchaseInvoiceEdit/"+purchaseInvoiceNo);
    };

    // remove to the real data holder
    $scope.deleteRow = function(puchaseInvoiceNo, index) {
        ngDialog.openConfirm().then(function() {
            var myURL = $stateParams.tenantid+'/app/purchaseinvoice/delete';
            $http({
                method : 'post',
                url : myURL,
                data : puchaseInvoiceNo,
            }).success(function(data) {
                if (data == true) {
                    var tableData = $scope.rowCollection;
                    $scope.rowCollection.splice(index, 1);
                    logger.logSuccess("Purchase Invoice deleted successfully");
                } else {
                    logger.logError("Error in deleting Purchase Invoice master!");
                }
            }).error(function(data) {
                logger.logSuccess("Error in Delete Purchase Invoice Master!");
            });
            console.log('Modal promise resolved. Value: ');
        }, function(reason) {
            console.log('Modal promise rejected. Reason: ', reason);
        });

    };
    
 // Redirecting Page For View Functionality
    $scope.view = function(purchaseInvoiceNo,index) {
    	$rootScope.SeasalesInvoiceListCtrl=$('.rounded').val();
        $scope.isAdd  = false;
        $location.path($stateParams.tenantid+"/invoice/seasalesinvoice/salesInvoiceView/"+purchaseInvoiceNo);
    };

    $scope.viewJob = function(jobNo) {
    	$rootScope.SeasalesInvoiceListCtrl=$('.rounded').val();
    	$location.url($stateParams.tenantid+'/jobOrderSea/view?rowid='+jobNo); 
     }
    

   
        
        $scope.reversePIN = function(reverseInvoiceNo) {
            if(reverseInvoiceNo =="" || reverseInvoiceNo ==undefined){
                logger.logError("Please select invoice");
            }else{         
                ngDialog.open({
                    scope : $scope,
                    template : 'views/finance/transaction/transactionReverseDialog',
                    controller : $controller('purchaseInvoiceReverseCtrl', {
                        $scope : $scope,
                        invoiceNo: reverseInvoiceNo,
                        screenName: 'purchaseinvoice'
                    }),
                    className : 'ngdialog-theme-plain',
                    showClose : false,
                    closeByDocument : false,
                    closeByEscape : false,
                    preCloseCallback : $scope.getList
                });
            }
        };
        
        $scope.copyInvoice =function(reverseInvoiceNo){
            if(reverseInvoiceNo =="" || reverseInvoiceNo ==undefined){
                logger.logError("Please select invoice");
            }else{
                $location.path($stateParams.tenantid+"/invoice/purchaseinvoice/PurchaseInvoiceCopy/"+reverseInvoiceNo);  
            }
            
        }
        
        var quickLinkIdList = $location.search().quickLinkIdList;
        $scope.newQukLinkList=[];
        $scope.qlt=[];
        if(quickLinkIdList!='' && quickLinkIdList != undefined){
        	 $scope.qlt=quickLinkIdList.split(',');
        	 $http.get($stateParams.tenantid + '/app/seasalesinvoice/getlist').success(
        				function(response) {
        					$scope.rowCollection=[];
        					$scope.newQukLinkList = response.salesInvoiceList;
                if($scope.newQukLinkList !=null && $scope.newQukLinkList.length>0 ){
                	angular.forEach($scope.newQukLinkList, function(value, key) {
                		
                		angular.forEach($scope.qlt, function(value1, key1) {
                    		if(value.salesSNo==value1){
                    			$scope.rowCollection.push(value);
                    		}
                    		
                    	})
                	})
                }
            	
                }).error(function(datas) {
            });
            
         }
        
        
    $scope.search=function( value){
        $scope.purchaseInvoiceData=value;
   $http.post($stateParams.tenantid + '/app/seasalesinvoice/getSearchlist', $scope.purchaseInvoiceData).success(
			function(response) {
                $scope.rowCollection = response.salesInvoiceList;
               $scope.salesInvoiceListDraft = response.salesInvoiceListDraft;

			});
       
        }
        
        
        
        
});
//draft

app.controller('salesInvoiceListDraftCtrl', function($scope, $rootScope, $http, $location, logger, $log, ngDialog, 
        $modal, utilsService, sharedProperties, $state,$window,$controller,$stateParams) {

    $scope.pageCounters = [14, 16, 17, 18, 150, 500, 1000 ];

    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 14;
    $scope.initial = {}; 
    $scope.isAdd = true; 
    $scope.hideDownloadIcon= true;
    
    $scope.fromToPurInvList=[];
    $scope.bulkPurInvoice = {
            fromPurInvoiceNo:'',
            toPurInvoiceNo:''
    }
    
    $scope.purchaseInvoiceData = {
    		salesSNO:'',
    		puchaseInvoiceNo :'',
            puchaseInvoiceDate :'',
            supplier :'',
            partyInvoiceNo :'',
            partyInvoiceDate :'',
            purchaseDraftNo: '',
            draftMode:'',
            purchaseNo :'',
            dueDate :'',
            currency :'',
            exgRate :'',
            amountLocal :'',
            amountUSD :'',
            company :'',
            description :'',
            type:'',
            purInvDetail : [],
            detailArr:[],
            edit : false,
            fromDate : '',
            toDate : ''
         };
    
 $scope.editRowSales = function(salesSNo) {   
	 $rootScope.SeasalesInvoiceListCtrl=$('.rounded').val();
     $location.path($stateParams.tenantid+"/invoice/salesinvoice/salesInvoiceAdd/"+salesSNo);

     }
    
  
    $http.get($stateParams.tenantid + '/app/seasalesinvoice/getDraftList').success(
			function(response) {
				console.log(response);
				$scope.rowCollection = response.salesInvoiceList;
			});
    
    // Redirecting Page For Edit Functionality

    $scope.editRow = function(purchaseInvoiceNo,index) {
    	$rootScope.SeasalesInvoiceListCtrl=$('.rounded').val();
        $scope.isAdd  = false;
        $location.path($stateParams.tenantid+"/invoice/purchaseinvoice/PurchaseInvoiceEditTemp/"+purchaseInvoiceNo);
    };

    $scope.saveDraft = function(salesSNo) {
    	$rootScope.SeasalesInvoiceListCtrl=$('.rounded').val();
    	$location.path($stateParams.tenantid+"/invoice/seasalesinvoice/salesInvoiceDraftEdit/"+salesSNo);
       	 
    	 /*$http.post($stateParams.tenantid + '/app/seasalesinvoice/saveSalesDraft?salesSNo=',+salesSNo).success(function(data) {
			    logger.logSuccess('Sales Invoice added successfully.')
			    $location.path($stateParams.tenantid+ "/invoice/sea/seasalesinvoice/SalesInvoiceList");
				}).error(function(data) {
		    });*/
    };
    
    $scope.backToList = function() {
		$state.go('app.salesmarketing.seasalesinvoice',
				{
					tenantid : $stateParams.tenantid
				});
	}
    
    // remove to the real data holder
    $scope.deleteRow = function(puchaseInvoiceNo, index) {
        ngDialog.openConfirm().then(function() {
            var myURL = $stateParams.tenantid+'/app/purchaseinvoice/delete';
            $http({
                method : 'post',
                url : myURL,
                data : puchaseInvoiceNo,
            }).success(function(data) {
                if (data == true) {
                    var tableData = $scope.rowCollection;
                    $scope.rowCollection.splice(index, 1);
                    logger.logSuccess("Purchase Invoice deleted successfully");
                } else {
                    logger.logError("Error in deleting Purchase Invoice master!");
                }
            }).error(function(data) {
                logger.logSuccess("Error in Delete Purchase Invoice Master!");
            });
            console.log('Modal promise resolved. Value: ');
        }, function(reason) {
            console.log('Modal promise rejected. Reason: ', reason);
        });

    };
    
 // Redirecting Page For View Functionality
    $scope.view = function(purchaseInvoiceNo,index) {
    	$rootScope.SeasalesInvoiceListCtrl=$('.rounded').val();
        $scope.isAdd  = false;
        $location.path($stateParams.tenantid+"/invoice/purchaseinvoice/PurchaseInvoiceView/"+purchaseInvoiceNo);
    };

        
});

//draft
app.controller('purchaseInvoiceReverseCtrl', function($scope, $http,ngDialog,logger,$location,invoiceNo,screenName,$timeout,$stateParams) {
    $scope.pinReverseObj = {puchaseInvoiceDate:'', puchaseInvoiceNo:''};
    
    $scope.screenNames = screenName;
    
        /*$timeout(function() {
            $("#pinReverse_Date").datetimepicker({
                format : 'DD/MM/YYYY',
                pickTime: false
            });
         }, 1000);
    
       
        
        $("#pinReverse_Date").on("dp.change", function(e) {
            $scope.pinReverseObj.puchaseInvoiceDate = $('#txtPinReverseDate').val();
        });*/
    
    $timeout(function() {
        $("#txtPinReverseDate").datetimepicker({
            minDate: "01/01/2016",
            format : 'DD/MM/YYYY',
            pickTime: false
        });
     }, 1000);
    
    $("#txtPinReverseDate").on("dp.change", function(e) {
        $scope.pinReverseObj.puchaseInvoiceDate = $('#txtPinReverseDate').val();
    });
    
        
    
    $scope.getCurrentDate = function(){
        var today = new Date();
        var dd = today.getDate();
        var mm = today.getMonth() + 1;

        var yyyy = today.getFullYear();
        if (dd < 10) { dd = '0' + dd }
        if (mm < 10) { mm = '0' + mm }
        var today = dd + '/' + mm + '/' + yyyy;
        $scope.pinReverseObj.puchaseInvoiceDate = today;
    }
    $scope.getCurrentDate();
        
    $scope.pinReverseObj.puchaseInvoiceNo = invoiceNo;
   
    $scope.reverseConfirm = function(){
        if($scope.screenNames=="purchaseinvoice"){
            if($scope.pinReverseObj.puchaseInvoiceDate!=""){
                $http.post($stateParams.tenantid+'/app/purchaseinvoice/reversePIN',$scope.pinReverseObj).success(function(datas) {
                    debugger;
                    if(datas.success == true){
                        if(datas.message =='Invoice is already reversed !..'){
                            logger.logError(datas.message);
                            ngDialog.close();
                        }else{
                            logger.logSuccess(datas.message);
                            ngDialog.close();
                        }
                    }else{
                        logger.logError(datas.message);
                    }
                    }).error(function(datas) {
                });
            }else{
                logger.logError("Please Select Invoice Date!");
            }
        }
    }
    $scope.closeCBPReverseDialog = function() {
        ngDialog.close();
     };
});
