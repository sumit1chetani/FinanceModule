//invoiceList.js
'use strict';
app.controller('invoiceListControllerimp', function($scope, $timeout, $stateParams,sharedProperties,toaster,
		$filter, $rootScope, $http, $location, logger, $state, ngDialog,$controller,$injector) {

    $scope.displayCollection=[];
    $scope.rowCollection=[];
    $scope.showEmptyLabel=false;
    $scope.selection = [];
    $scope.listdata = [];
    $scope.itemsByPage = 10;
    $scope.add = function() {
        $state.go('app.documentation.docsinvoiceadd',{tenantid:$stateParams.tenantid});
    };
    
    $scope.getList=function(){

    	$http.get($stateParams.tenantid+'/app/docsinvoice/list').success(function(response) {
    		console.log("invoice list",response.invoiceList);
            $scope.rowCollection = response.invoiceList;
        });


    }

    $scope.getList();
    $scope.selectCheckAll=false;
    $scope.right=false;
    $scope.wrong=false;
  $scope.viewSelectAll = function () {

        if ($scope.invView.selAll) { //add check box

            $scope.getpageNum = $rootScope.pagenum;
            if($scope.itemsByPage != null){
                $scope.getpageNumCount = $scope.itemsByPage;
            }else{
                $scope.getpageNumCount = 10;
            } 
                
          
            
            if($scope.getpageNum == null  && $scope.getpageNum == undefined){ //add first for 10 rows
                $scope.one = 1-1;
                $scope.ten = (0+$scope.getpageNumCount);
                $scope.wrong=false;
                $scope.right=true;
            }else if($scope.getpageNum == 0){
                $scope.one = 1-1;
                $scope.ten = (0+$scope.getpageNumCount);
                $scope.wrong=false;
                $scope.right=true;
            }else if($scope.getpageNum == 1){
                $scope.one = 1-1;
                $scope.ten = (0+$scope.getpageNumCount);
                $scope.wrong=false;
                $scope.right=true;
            }else{
                $scope.one = ($scope.getpageNum*$scope.getpageNumCount)-$scope.getpageNumCount;
                $scope.ten = $scope.getpageNum*$scope.getpageNumCount;
                $scope.wrong=false;
                $scope.right=true;
            }
            
        }else{  //delete check box
            
            $scope.getpageNum = $rootScope.pagenum;
            if($scope.getpageNum == null  && $scope.getpageNum == undefined){ //delete first for 10 rows
                $scope.one = 1-1;
                $scope.ten = (0+$scope.getpageNumCount);
                $scope.right=false;
                $scope.wrong=true;
            }else if($scope.getpageNum == 0){
                $scope.one = 1-1;
                $scope.ten = (0+$scope.getpageNumCount);
                $scope.right=false;
                $scope.wrong=true;
            }else if($scope.getpageNum == 1){
                $scope.one = 1-1;
                $scope.ten = (0+$scope.getpageNumCount);
                $scope.right=false;
                $scope.wrong=true;
            }else{
                $scope.one = ($scope.getpageNum*$scope.getpageNumCount)-$scope.getpageNumCount;
                $scope.ten = $scope.getpageNum*$scope.getpageNumCount;
                $scope.right=false;
                $scope.wrong=true;
                
            }
        }
        
        if($scope.right==true){  //add Check box
            var len = $scope.rowCollection.length;        
            var fruits = $scope.rowCollection;        
            $scope.citrus = fruits.slice($scope.one, $scope.ten);         
            var citrusLen = $scope.citrus.length;
            for (var k = 0; k < citrusLen; k++) {
                $scope.citrus[k].check = true;
            } 
        }
        
        if($scope.wrong==true){ //delete Check box
            var len = $scope.rowCollection.length;        
            var fruits = $scope.rowCollection;        
            $scope.citrus = fruits.slice($scope.one, $scope.ten);         
            var citrusLen = $scope.citrus.length;
            for (var k = 0; k < citrusLen; k++) {
                $scope.citrus[k].check = false;
            }
        }
        

        }
  $scope.bulkMail = function(giRowData) {
  	debugger;
      var invoiceCodes = '';
      var len = giRowData.length;
      for (var i = 0; i < len; i++) {
          var rowData = giRowData[i];
          if (typeof rowData.check == "undefined") {
              rowData["check"] = false;
          }
          if (rowData.check == true) {
              if (invoiceCodes == "") {
            	  
                  invoiceCodes = rowData.invoiceNo;
              } else {
              	invoiceCodes += "," + rowData.invoiceNo;

              }
          }
      }

      if (invoiceCodes == '') {
          logger.logError("Please select atleast one row");
      } else {
          $http.post($stateParams.tenantid+'/app/docsinvoice/bulkMail', invoiceCodes).success(function(data) {
              if (data.success)
                  logger.logSuccess("Mail Sent successfully");
              else
                  logger.logError("Unable to send mail !");

          }).error(function(data) {
              console.log("data" + data);
          });
      }

  }
  
   // $scope.FetchingValues1 = function(data) {

   
   $scope.clickInvoiceFunction = function(printinvoicevalue, selection) {
       $scope.printInvoiceoption(printinvoicevalue, selection);
   }
   
   $scope.printInvoiceoption = function(invoiceNo,selection) {
       var url = $stateParams.tenantid+'/app/docsinvoice/printoptions?invoiceno=' + invoiceNo + '&selectedDropDown=' + selection;
       var wnd = window.open(url, 'Shipping', 'height=400,width=750,top=100,left=100,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
       wnd.print();
  
};

   $scope.printInvoice = function(invoiceNo) {
           var url = $stateParams.tenantid+'/app/docsinvoice/print?invoiceno=' + invoiceNo;
           var wnd = window.open(url, 'Shipping', 'height=400,width=750,top=100,left=100,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
           wnd.print();
      
   };
   
   $scope.viewInvoice = function(invoiceNo ) {
		$location.url($stateParams.tenantid+'/documentation/imp/invoice/view?invoiceNo='+invoiceNo);
	}
   
   $scope.dodata =function(invoiceNo){
       
	   $rootScope.invoiceNo = invoiceNo;
       ngDialog.open({
           scope : $scope,
           template : 'deliveryOrderpop',
           controller : $controller('deliveryOrderpopCtrl', {
               $scope : $scope
           }),
           className : 'ngdialog-theme-plain',
           showClose : false,
           closeByDocument : false,
           closeByEscape : false,
           preCloseCallback : $scope.getList
       });
       
       
   }
   
   $rootScope.mailid = [];
   $scope.sendMail = function(invoiceNo) { 
	   $rootScope.invoice = invoiceNo;

		   $http.get($stateParams.tenantid+'/app/docsinvoice/getEmailList?invoiceno='+invoiceNo).success(function(data) {
			   $rootScope.mailid = data.emailSentList.split(',');
			   ngDialog.openConfirm({
		           template :'/views/documentation/invoice/invoicePopup',
		           controller: $controller('poPopupCtrl', {
	  	        		$scope: $scope,
	  	        		$http:$http,
	  	        		ngDialog:ngDialog,
	  	        		logger:logger,
	  	        		$injector:$injector,
	  	        		sharedProperties:sharedProperties,
	  	        		toaster:toaster,
	  	        		$rootScope:$rootScope
	  	        		}),
	  	        		className: 'ngdialog-theme-plain',
	  	        		showClose: false,
	  	        		closeByDocument: false,
	  	        		closeByEscape: false,
	  	        		preCloseCallback : $scope.getList
	  	        		});

	  	        		
			   $scope.closeUpload = function() {
				ngDialog.close();
			}
	   });
   }
		  

   
   
   $scope.getuserdetail = function(){
		  
		  $http.get($stateParams.tenantid + '/app/commonUtility/getUserdetail')
			.success(function(datas) {
				console.log(datas);
				usermailId =datas.airQuotationBean.employeeEmail
				logger.logSuccess('Mail Sent Successfully!');
			}).error(function(data) {

			});
	  }
   
   
   // shakthi added
   
   $scope.datechangeinv = function(invoiceNo,fulldtl) { 
 	  debugger;
 	   $rootScope.invoice = invoiceNo;
 	   
 	   console.log("fulldtlqwewe",fulldtl);
 	   $rootScope.ConsigneeName = fulldtl.customerName;
 	   $scope.invcode=invoiceNo;
 	  $scope.condtl=fulldtl.customerName;
 	 $scope.contax=fulldtl.custaxnum;
 	 $scope.conCode = fulldtl.consigneeCode;
 	 console.log(" $scope.conCode", $scope.conCode);
        if($scope.invcode =="" || $scope.invcode ==undefined){
            logger.logError("Please select Invoice");
        }else{
            ngDialog.open({
                scope : $scope,
                template : 'views/finance/transaction/transactionReverseDialog',
                controller : $controller('FreightInvDateCtrl', {
                    $scope : $scope,
                    sinvoiceNo: $scope.invcode,
                    consigneeName: $scope.condtl,
                    consigneeCode: $scope.conCode,
                    contax:$scope.contax,
                    $rootScope:$rootScope,
                    screenName: 'importinvoice'
                }),
                className : 'ngdialog-theme-plain',
                showClose : false,
                closeByDocument : false,
                closeByEscape : false,
                preCloseCallback : $scope.getList
            });
        }
  }
   
   
   //Consignee
   
   $scope.consigneeList=[];
   //Get Consignee Details

   $http.get($stateParams.tenantid+ '/app/docsinvoice/getConsignee').success(function(data) {
   console.log("getConsignee",data);
   $scope.consigneeList = data;

   });
   
   
   //watch function
   



   $scope.fetchSelectedConsigneeName = function($model,invoiceData){
   	console.log("inside auto fun");
   	console.log("consigneeList",$scope.consigneeList);
       if($scope.consigneeList.length>0){
           angular.forEach($scope.consigneeList, function(key,index){
               if ($model === key.text){
            	   
              // 	invoiceData.consigName = key.text;
            	   FreightDateobj.consignee = key.text;
              // 	invoiceData.consigAddress = key.consigneeAddress;    
               	FreightDateobj.consigAddress = key.consigneeAddress;    

              // 	invoiceData.consigCountry = key.consigneeCountry;    
               	FreightDateobj.consigCountry = key.consigneeCountry;    

              // 	invoiceData.custaxnum = key.consigneeTaxnumber;    
               	FreightDateobj.custaxnum = key.consigneeTaxnumber;  
               	
              // 	invoiceData.consigTel = key.consigneeTel;    
               	FreightDateobj.consigTel = key.consigneeTel;    

               	//invoiceData.consigEmail = key.consigEmail;
               	FreightDateobj.consigEmail = key.consigEmail;

               	//invoiceData.customer = key.consigneeCode;   
               	FreightDateobj.customer = key.consigneeCode;      


               }else{
               	//invoiceData.consigName=$model;
            	   FreightDateobj.consignee=$model;
               	//invoiceData.consigneeCode="";
            	   FreightDateobj.consigneeCode="";
               }  
           })
             
           
       }else{
       	//invoiceData.consigName=$model;
       	FreightDateobj.consignee=$model;

       }
       //return invoiceData.consigName;
       return FreightDateobj.consignee;

     }
   

});

app.controller('deliveryOrderpopCtrl', function($scope, $timeout, $stateParams,sharedProperties,toaster,
		$filter, $rootScope, $http, $location, logger, $state, ngDialog,$controller,$injector,validationService) {
	

	$scope.dodata = {
			invoiceNo:'',
			officeName : '',
			issuedDate : '',
			showtip : '',
			doType: '',
			blNo: '',
			quotationNo: '',
			cnee: '',
			messers: '',
			notify1: '',
			notify2: ''
	}
	
	$http.post($stateParams.tenantid+'/app/docsinvoice/branchlist').success(function(data) {
	      	
  		$scope.branchlist=data;
  		        		
	});
	
		
	 $scope.dodata.invoiceNo = $rootScope.invoiceNo;
	
	 $http.post($stateParams.tenantid+'/app/docsinvoice/getdodetails?invoNo=' +$scope.dodata.invoiceNo).success(function(result) {
		 
		 $scope.dodata = result;
		 
	 });
	
	 $scope.closePopup = function(){
	        ngDialog.close();
	        $state.reload();
	  }
	 
	 $scope.save = function(invoiceListForm,dodata){	
		 
		 if (new validationService().checkFormValidity(invoiceListForm)) {	
			 
			 $scope.dodata.invoiceNo = $rootScope.invoiceNo;
			 console.log($scope.dodata)
			 
			 $http.post($stateParams.tenantid+'/app/docsinvoice/savedo', $scope.dodata).success(function(data) {
					if (data.success == true) {
						logger.logSuccess("Saved Succesfully!");
						 ngDialog.close();
						 $state.reload();

					} else {
						logger.logError(data.message);
					}
				});
			 
			 
		 } else {
				toaster
						.pop('error',"Please fill the required fields",logger.getErrorHtmlNew(invoiceListForm.$validationSummary),5000, 'trustedHtml');
			}
		 
		
	 }
	 
	 $scope.print = function(){
		 
		 $scope.dodata.invoiceNo = $rootScope.invoiceNo;
		 var invNo = $scope.dodata.invoiceNo;
		
		 var url = $stateParams.tenantid+'/app/docsinvoice/print?invNo=' + invNo;
         var wnd = window.open(url, 'Simatech', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
         wnd.print(); 
	 }
	 
	 
});

app.controller('poPopupCtrl', function($scope, $timeout, $stateParams,sharedProperties,toaster,
		$filter, $rootScope, $http, $location, logger, $state, ngDialog,$controller,$injector,validationService) {
	
    $scope.rowCollection1 = [];
	$rootScope.invoice;

	 $scope.senttomail = function() { 
		    $http.get($stateParams.tenantid+'/app/docsinvoice/sendMail?invoiceno='+  $rootScope.invoice).success(function(data) {
         if (data == true) {
             logger.logSuccess("Mail sent successfully!");
             ngDialog.close();
         }else{
             logger.logError("Unable to send Email");
         }
     }).error(function(data) {
         console.log("data" + data);
     });
	   }
	   

	
	   $scope.closeUpload = function() {
		ngDialog.close();
	  }
	 
	
});




app.controller('FreightInvDateCtrl', function($scope, $http,ngDialog,logger,$location,sinvoiceNo,consigneeName,consigneeCode,contax,screenName,$timeout,$stateParams) {
    $scope.FreightDateobj = {dateOfIssue:'', invoiceNo:'',custaxnum:'',consignee:'',consigneeDetails:''};
    
    $scope.screenNames = screenName;
     $timeout(function() {
            $("#txtprovDate").datetimepicker({
                minDate: "01/01/2016",
                format : 'DD/MM/YYYY',
                pickTime: false
            });
         }, 1000);
     
     
 	$scope.$watch('FreightDateobj.consignee', function(newValue,oldValue) {
		if (newValue != '' && newValue != undefined ) {
			var consigneeCode=newValue;	
			console.log("consigneeCode",consigneeCode);
					  debugger;
			  		  $http.get($stateParams.tenantid+'/app/docsinvoice/getConsigneeDetails?conNo='+consigneeCode).success(function(datas) {
			  			console.log("EditConsigneeDetails",datas);
			  		$scope.FreightDateobj.consigneeDetails = datas.consignee;
			  		$scope.FreightDateobj.custaxnum = datas.custaxnum;
			  		 
		               	 
			  		  });		  	   
	  	
		}
	});
   $scope.getCurrentDate = function(){
        var today = new Date();
        var dd = today.getDate();
        var mm = today.getMonth() + 1;

        var yyyy = today.getFullYear();
        if (dd < 10) { dd = '0' + dd }
        if (mm < 10) { mm = '0' + mm }
        var today = dd + '/' + mm + '/' + yyyy;
        $scope.FreightDateobj.dateOfIssue  = today;
    }
        $scope.getCurrentDate();
    $scope.FreightDateobj.invoiceNo = sinvoiceNo;
    $scope.FreightDateobj.screenName = screenName;
    $scope.FreightDateobj.consignee = consigneeCode;
    $scope.FreightDateobj.custaxnum = contax;
    //$scope.FreightDateobj.consigneeDetails = consigneeName;
    
    console.log("$scope.FreightDateobj",$scope.FreightDateobj);
    $("#txtprovDate").on("dp.change", function(e) {
        $scope.FreightDateobj.dateOfIssue = $('#txtprovDate').val();
    });
   debugger;
    $scope.reverseConfirm = function(){
        if($scope.screenNames=="importinvoice"){
            if($scope.FreightDateobj.dateOfIssue!=""){
                $http.post($stateParams.tenantid+'/app/provinvoice/updateInvDate',$scope.FreightDateobj).success(function(datas) {
                    if(datas.success == true){
                        logger.logSuccess("Invoice  Updated SuccessFully!");
                        ngDialog.close();
                    }else{
                        logger.logError(datas.sErrorMessage);
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

