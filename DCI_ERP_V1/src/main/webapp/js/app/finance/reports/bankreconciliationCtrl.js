'use strict';
app.controller('bankreconciliationCtrl', function($scope, $window, $rootScope, $location, $http, logger,toaster, $log, ngDialog, $modal, utilsService,$state,ListService,sharedProperties,$stateParams) 
        {
//    $rootScope.rowCollectionDraft=[];
//    console.log($rootScope.rowCollectionDraft);
    $scope.isReconcileList=false;
    $scope.dataLoopCount = 0;
    $scope.from = 0;
    $scope.to = 100;
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.selectAll =false;
    $scope.excludedEntry=[];		 		
    
    $scope.bankReconcile = {
    		bankDate:'',
            fromDate : '',
            toDate : '',
            bankCode : '',
            validFromDate:'',
            validToDate:''
        };
    $scope.BankList = [];
    $scope.excelfile=[];
    
    $('#from_date').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime: false
    });
    $('#to_date').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime: false
    });
    
    $('#bankDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime: false
    });
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth() + 1;

    var yyyy = today.getFullYear();
    if (dd < 10) {
        dd = '0' + dd
    }
    if (mm < 10) {
        mm = '0' + mm
    }
    var today = dd + '/' + mm + '/' + yyyy;
    $scope.bankReconcile.toDate = today;
    $scope.bankReconcile.fromDate = today;
    
    $scope.dataList = ListService.getCashBankList();
    $scope.dataList.then(function(bankLists){
        $scope.BankList = bankLists;
        console.log($scope.BankList);
    });
    $scope.downloadFile=function(){
        $("#tbPdfExport").bind('click', function() {
        });
        $('#tbPdfExport').simulateClick('click');
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
    
    $scope.isRecoDraft=true;
    $scope.isReco=true;
    
    $scope.exportExcel= function(){
console.log($scope.rowCollection);
if($scope.rowCollection.length > 0) {
	$scope.rowCollection[0]['toDate']=$scope.bankReconcile.toDate;	
	$scope.rowCollection[0]['bankCode']=$scope.bankReconcile.bankCode;
}

        $http.post($stateParams.tenantid+"/app/bankReconciliation/generateExcel",$scope.rowCollection).success(function(response) {
        	console.log(response);
            $('#exportXl').append('<a id="tbExcelExport" stype="display:none" href="filePath/BankReconcilation.xls" download="BankReconcilation.xls"></a>');
            $("#tbExcelExport").bind('click', function() {
            });
            $('#tbExcelExport').simulateClick('click');

        }).error(function(result) {
            $('#exportXl').append('<a id="tbExcelExport" stype="display:none" href="filePath/BankReconcilation.xls" download="BankReconcilation.xls"></a>');
            $("#tbExcelExport").bind('click', function() {
            });
            $('#tbExcelExport').simulateClick('click');
        });
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

    }
    
    
    
    
    
    
    
    
    
    
    
    
    $scope.exportExcel1= function(){
console.log($scope.rowCollection);
if($scope.rowCollection.length > 0) {
	$scope.rowCollection[0]['toDate']=$scope.bankReconcile.toDate;	
	$scope.rowCollection[0]['bankCode']=$scope.bankReconcile.bankCode;
	
	$scope.rowCollection[0]['balanceAsPerBank']=$scope.bankBalance.balanceAsPerBank;	
	$scope.rowCollection[0]['balanceAsPerBook']=$scope.bankBalance.balanceAsPerBook;
	$scope.rowCollection[0]['difference']=$scope.bankBalance.difference;	
	$scope.rowCollection[0]['balanceAsPerBankUsd']=$scope.bankBalance.balanceAsPerBankUsd;
	$scope.rowCollection[0]['differenceReceipt']=$scope.bankBalance.differenceReceipt;	
	$scope.rowCollection[0]['differencePayment']=$scope.bankBalance.differencePayment;	
	$scope.rowCollection[0]['rec']=$scope.isReco;	


}

        $http.post($stateParams.tenantid+"/app/bankReconciliation/generateExcelshow",$scope.rowCollection).success(function(response) {
        	console.log(response);
            $('#exportXl1').append('<a id="tbExcelExport1" stype="display:none" href="filePath/BankReconcilationshow.xls" download="BankReconcilationshow.xls"></a>');
            $("#tbExcelExport1").bind('click', function() {
            });
            $('#tbExcelExport1').simulateClick('click');

        }).error(function(result) {
            $('#exportXl1').append('<a id="tbExcelExport1" stype="display:none" href="filePath/BankReconcilationshow.xls" download="BankReconcilationshow.xls"></a>');
            $("#tbExcelExport1").bind('click', function() {
            });
            $('#tbExcelExport1').simulateClick('click');
        });
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

    }
    
    
    $scope.excludedEntry = function(temp,table,trIndex){
    	//$scope.excludedEntry.push(temp);
    	temp['bank_account_code']=$scope.bankReconcile.bankCode;
    	temp['toDate']=$scope.bankReconcile.toDate;
    	temp['fromDate']=$scope.bankReconcile.fromDate;
    	$scope.calculateExcluded(table);
    	$scope.removeRow(trIndex,table);
    	 $http.post($stateParams.tenantid+'/app/bankReconciliation/excludedrecords', temp).success(function(result) {
             if(result.message == "") {
                 sharedProperties.setObject($scope.bankReconcile);
                
                // $location.path('/reports/manualreconcillation');
             } else {
          	   logger.logError(result.message);               }
         }).error(function(result) {
         });
    }
    
    $scope.calculateExcluded = function(table){

   	 var debit=0;
   	 var credit=0;
   	 var balance=$scope.bankBalance.balanceAsPerBank;
   	 $scope.bankBalance.balanceAsPerBank=0;
   	 $scope.bankBalance.differenceReceipt=0;
   	 $scope.bankBalance.differencePayment=0;
   	angular.forEach(table, function(row, index) {
   		  var check =row.bank_date;
             if (check != '' && check != null) {
           	  if(row.debitamount !=0){
           		 // credit=credit+row.creditamount;
               	  debit=debit+row.debitamount;
               	//  $scope.bankBalance.balanceAsPerBank=$scope.bankBalance.balanceAsPerBank+debit;
               	  $scope.bankBalance.differenceReceipt=debit;
           	  }
           	  else if(row.creditamount !=0){
           		  credit=credit+row.creditamount;
               	 // debit=debit-row.debitamount;
           		//  $scope.bankBalance.balanceAsPerBank=$scope.bankBalance.balanceAsPerBank-credit;
           		  $scope.bankBalance.differencePayment=credit;
           	  }
           	 
             }else{
                 
             }
 	  });
   	
   	 
   	
   	//$scope.bankBalance.balanceAsPerBook=tempBalance1+(debit-credit);
   	$scope.getdifference($scope.bankBalance);
   
    }
    
    $scope.removeRow = function(trIndex,table) {
		if(table.length>1){
		$scope.tablerow = [];
		var count=0;
		angular.forEach(table, function(row, index) {
		
			if (trIndex != count  ) {
				$scope.tablerow.push(row);
			}  
			count++;
		});
		}
		else{
			
		}
		$scope.rowCollection = $scope.tablerow;
		logger.logSuccess("Deleted successfully!");
	};
    
    $scope.print = function(){
        debugger
        
        var url = $stateParams.tenantid+'/app/bankReconciliation/print?toDate=' + $scope.bankReconcile.toDate + '&bankCode=' 
        + $scope.bankReconcile.bankCode+'&fromDate='+$scope.bankReconcile.fromDate;
        var wnd = window
		.open(
				url,
				'ATHENA',
				'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');        
        wnd.print();   
     }
    
    
    
    $scope.print1 = function(){
        debugger
        
        var url = $stateParams.tenantid+'/app/bankReconciliation/print1?toDate=' + $scope.bankReconcile.toDate + '&bankCode=' 
        + $scope.bankReconcile.bankCode+'&fromDate='+$scope.bankReconcile.fromDate+'&difference='+$scope.bankBalance.difference+
        '&differenceReceipt='+$scope.bankBalance.differenceReceipt+'&differencePayment='+$scope.bankBalance.differencePayment+
        '&bankBalanceAsPerBook='+$scope.bankBalance.balanceAsPerBook+'&bankBalanceAsPerBank='+$scope.bankBalance.balanceAsPerBank+'&rec='+$scope.isReco;
        var wnd = window
		.open(
				url,
				'ATHENA',
				'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');        
        wnd.print();   
     }

    
     $scope.selectAllrows = function(flag) {
        debugger;

        if ($scope.rowCollection.length > 0) {
            if (flag) {
                angular.forEach($scope.rowCollection, function(row, index) {
                    row.select = true;
                });
            }else{
                angular.forEach($scope.rowCollection, function(row, index) {
                    row.select = false;
                });
            }
        } else {
            if (flag) {
            $scope.selectAll = false;
            logger.logError("No Records Found!...");
            }

        }

    }
   
     $scope.getReconcileListdraft = function() {
      
    	 if($scope.bankReconcile.fromDate =="" ||  $scope.bankReconcile.toDate=="" ){
             logger.logError("Date Should not be empty!...");    
         }
         
       
        
         
    	 else{
    	       
    	   	 $scope.bankReconcile.validFromDate =$scope.bankReconcile.fromDate;
             $scope.bankReconcile.validToDate= $scope.bankReconcile.toDate;
             $scope.bankReconcile.validbankCode=$scope.bankReconcile.bankCode;
       console.log("params" + $scope.bankReconcile.validFromDate,$scope.bankReconcile.validToDate, $scope.bankReconcile.validbankCode);
        var url = $stateParams.tenantid+'/app/bankReconciliation/getReconcileListDraft1?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount;
        url=url+'&fromDate='+ $scope.bankReconcile.validFromDate+'&toDate='+ $scope.bankReconcile.validToDate+'&bankCode='+$scope.bankReconcile.validbankCode;
        $http.get(url).success(function(data) {
            if (data.success == true) {
                
                console.log("draft list")
                console.log(data)
                $scope.rowCollectionDraft = data.lDifferenceResultList1;   
               console.log("data.lDifferenceResultList1.length" +data.lDifferenceResultList1.length)

/*               $state.go('app.finance.reports.bankreconciliationDraft',{tenantid:$stateParams.tenantid});
*/ 
               $location.url($stateParams.tenantid+'/reports/bankreconciliation/draft?fromDate='+$scope.bankReconcile.fromDate+'&toDate='+$scope.bankReconcile.toDate+'&bankCode='+$scope.bankReconcile.bankCode);
                /*if(data.lDifferenceResultList.length==0){
                    logger.logError("No Records Found!...");
                } */
               
            }else{
                logger.logError("No Records Found!...");
            }
        });
    	        }
         }
    
     $scope.getdifference = function(objTranslationItem){
    	 objTranslationItem.difference=objTranslationItem.balanceAsPerBank -objTranslationItem.balanceAsPerBook;
    	 
     }
     
    $scope.getDiffernceList = function() {
        debugger;
        $scope.selectAll = false;
        $scope.isReconcileList=false;
        $scope.dataLoopCount = 0;
        $scope.showEmptyLabel = false;
        $scope.from = 0;
        $scope.to = 100;
        $scope.rowCollection = [];
     /*   $scope.bankReconcile.fromDate = $("#fromdate").val();
        $scope.bankReconcile.toDate = $("#todate").val();*/
        if($scope.bankReconcile.fromDate =="" ||  $scope.bankReconcile.toDate=="" ){
            logger.logError("Date Should not be empty!...");    
        }else if($scope.bankReconcile.bankCode==""){
            logger.logError("Please select Bank!...");    
        }else{
        $scope.bankReconcile.validFromDate =$scope.bankReconcile.fromDate;
        $scope.bankReconcile.validToDate= $scope.bankReconcile.toDate;
        var url = $stateParams.tenantid+'/app/bankReconciliation/getDifferenceList?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount;
        url=url+'&fromDate='+$scope.bankReconcile.validFromDate+'&toDate='+$scope.bankReconcile.validToDate+'&bankCode='+$scope.bankReconcile.bankCode;
        $http.get(url).success(function(data) {
            if (data.success == true) {
                $scope.rowCollection =data.lDifferenceResultList;
                
                if(data.lDifferenceResultList.length==0){
                    logger.logError("No Records Found!...");
                }
            }else{
            	logger.logError("No Records Found!...");
            }
        });
        }
    };
    //actual list
    var tempBalance=0;
    var tempBalanceUsd=0;
	var tempBalance1=0;
	$scope.isUsdBank=false;
	
    $scope.getReconcileList = function() {
        debugger;
        var tempReceipt=0;
        var tempPayment=0;
        $scope.isReconcileList=true;
        $scope.dataLoopCount = 0;
        $scope.showEmptyLabel = false;
        $scope.from = 0;
        $scope.to = 100;
        $scope.rowCollection = [];
      /*  $scope.bankReconcile.fromDate = $("#fromdate").val();
        $scope.bankReconcile.toDate = $("#todate").val();*/
        if($scope.bankReconcile.fromDate =="" ||  $scope.bankReconcile.toDate=="" ){
            logger.logError("Date Should not be empty!...");    
        }else if($scope.bankReconcile.bankCode==""){
            logger.logError("Please select Bank!...");    
        }
        
        else{
        	
        $scope.bankReconcile.validFromDate =$scope.bankReconcile.fromDate;
        $scope.bankReconcile.validToDate= $scope.bankReconcile.toDate;
        if($scope.bankReconcile.bankCode=="10030009" || $scope.bankReconcile.bankCode=="10030013" ){
        	$scope.isUsdBank=true;
        }
        else{
        	$scope.isUsdBank=false;
        }
        var url =$stateParams.tenantid+'/app/bankReconciliation/getReconcileList?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount;
        url=url+'&fromDate='+$scope.bankReconcile.validFromDate+'&toDate='+$scope.bankReconcile.validToDate+'&bankCode='+$scope.bankReconcile.bankCode;
        $http.get(url).success(function(data) {
            if (data.success == true) {
            	if(data.lDifferenceResultList.length == 1){
            		
            		if(data.lDifferenceResultList[0].transactionNo==null){
            			
            		
            			
            			   $scope.rowCollection = [];
            			}else{
                    		$scope.rowCollection = data.lDifferenceResultList;
            			}
            	}else{
            		$scope.rowCollection = data.lDifferenceResultList;
            	}
             
                $scope.isRecoDraft=true;
        	    $scope.isReco=true;
        	    $scope.bankBalance.differenceReceipt=0;
  			  $scope.bankBalance.differencePayment=0;
        	   if(data.lDifferenceResultList.length > 0){
        		   
        		  for(var i=0;i < data.lDifferenceResultList.length;i++){
        			  $scope.bankBalance.differenceReceipt=$scope.bankBalance.differenceReceipt+data.lDifferenceResultList[i].debitamount;
        			  $scope.bankBalance.differencePayment=$scope.bankBalance.differencePayment+data.lDifferenceResultList[i].creditamount;
        		  }
        		   tempReceipt=$scope.bankBalance.differenceReceipt;
        	       tempPayment=$scope.bankBalance.differencePayment;
        	     //  $scope.bankBalance.difference=data.lDifferenceResultList[0].difference;

        		   $scope.bankBalance.balanceAsPerBook=data.lDifferenceResultList[0].balanceAsPerBank+tempReceipt-tempPayment;
        		  $scope.bankBalance.balanceAsPerBank=data.lDifferenceResultList[0].balanceAsPerBank;
        		  $scope.bankBalance.balanceAsPerBankUsd=data.lDifferenceResultList[0].balanceAsPerBankUsd;
       	       $scope.bankBalance.difference= $scope.bankBalance.balanceAsPerBank-$scope.bankBalance.balanceAsPerBook;

        		  tempBalance=data.lDifferenceResultList[0].balanceAsPerBank;
        		  tempBalanceUsd=data.lDifferenceResultList[0].balanceAsPerBankUsd;
				   tempBalance1=data.lDifferenceResultList[0].balanceAsPerBook+tempPayment-tempReceipt;
        	   }
                if(data.lDifferenceResultList.length==0){
                    logger.logError("No Records Found!...");
                    $scope.bankBalance.differenceReceipt=0;
      			  $scope.bankBalance.differencePayment=0;
      			$scope.bankBalance.balanceAsPerBook=0;
      			$scope.bankBalance.balanceAsPerBank=0;
                }
            }else{
            	logger.logError("No Records Found!...");
            }
            
        });
      
        
        }
    };
    
    
    $scope.getReconcileListNew = function() {
        debugger;
        var tempReceipt=0;
        var tempPayment=0;
        $scope.bankBalance.differenceReceipt=0;
        $scope.bankBalance.differencePayment=0;
        $scope.isReconcileList=true;
        $scope.dataLoopCount = 0;
        $scope.showEmptyLabel = false;
        $scope.from = 0;
        $scope.to = 100;
        $scope.rowCollection = [];
      /*  $scope.bankReconcile.fromDate = $("#fromdate").val();
        $scope.bankReconcile.toDate = $("#todate").val();*/
        if($scope.bankReconcile.fromDate =="" ||  $scope.bankReconcile.toDate=="" ){
            logger.logError("Date Should not be empty!...");    
        }
        else if($scope.bankReconcile.bankCode==""){
            logger.logError("Please select Bank!...");    
        }
        
        else{
/*        	if($scope.bankReconcile.bankCode=="10030009"){
            	$scope.isUsdBank=true;
            }
            else{
            	$scope.isUsdBank=false;
            }*/
        	
        $scope.bankReconcile.validFromDate =$scope.bankReconcile.fromDate;
        $scope.bankReconcile.validToDate= $scope.bankReconcile.toDate;
        var url =$stateParams.tenantid+'/app/bankReconciliation/getReconcileListNew?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount;
        url=url+'&fromDate='+$scope.bankReconcile.validFromDate+'&bankcode='+$scope.bankReconcile.bankCode+'&toDate='+$scope.bankReconcile.validToDate;
        $http.get(url).success(function(data) {
            if (data.success == true) {
                $scope.rowCollection = data.lDifferenceResultList;
                $scope.isRecoDraft=false;
        	    $scope.isReco=false;
                if(data.lDifferenceResultList.length==0){
                    logger.logError("No Records Found!...");
                }
                for(var i=0;i < data.lDifferenceResultList.length;i++){
      			  $scope.bankBalance.differenceReceipt+=data.lDifferenceResultList[i].debitamount;
      			  $scope.bankBalance.differencePayment+=data.lDifferenceResultList[i].creditamount;
      		  }
                
                for(var i =0;i<data.lDifferenceResultList.length;i++){
    	        	 if(data.lDifferenceResultList[i].chqDt != null){
    	             var dateSplitted = data.lDifferenceResultList[i].chqDt.split(" ");
    	             var dateSplitted1 = dateSplitted[0].split("/").reverse().join("/");
    	             var  ms = Date.parse(dateSplitted1);
    	             console.log(dateSplitted +" : " +ms)
    	             data.lDifferenceResultList[i].Date1=ms;
//    	             data.thirdPartyVoyageList[i].schStartDate = new Date(dateSplitted1);
    	        	 }
    	         }
                for(var i =0;i<data.lDifferenceResultList.length;i++){
   	        	 if(data.lDifferenceResultList[i].docdate != null){
   	             var dateSplitted = data.lDifferenceResultList[i].docdate.split(" ");
   	             var dateSplitted1 = dateSplitted[0].split("/").reverse().join("/");
   	             var  ms = Date.parse(dateSplitted1);
   	             console.log(dateSplitted +" : " +ms)
   	             data.lDifferenceResultList[i].Date2=ms;
//   	             data.thirdPartyVoyageList[i].schStartDate = new Date(dateSplitted1);
   	        	 }
   	         }
                for(var i =0;i<data.lDifferenceResultList.length;i++){
   	        	 if(data.lDifferenceResultList[i].bank_date != null){
   	             var dateSplitted = data.lDifferenceResultList[i].bank_date.split(" ");
   	             var dateSplitted1 = dateSplitted[0].split("/").reverse().join("/");
   	             var  ms = Date.parse(dateSplitted1);
   	             console.log(dateSplitted +" : " +ms)
   	             data.lDifferenceResultList[i].Date3=ms;
//   	             data.thirdPartyVoyageList[i].schStartDate = new Date(dateSplitted1);
   	        	 }
   	         }
                $scope.bankBalance.closingbalance=data.closingBalance;
                tempReceipt=$scope.bankBalance.differenceReceipt;
     	       tempPayment=$scope.bankBalance.differencePayment;
     	      // $scope.bankBalance.difference=data.lDifferenceResultList[0].difference;
    $scope.bankBalance.balanceAsPerBook=$scope.bankBalance.differenceReceipt-$scope.bankBalance.differencePayment+$scope.bankBalance.closingbalance;
   $scope.bankBalance.balanceAsPerBank=$scope.bankBalance.differenceReceipt-$scope.bankBalance.differencePayment+$scope.bankBalance.closingbalance;
     		  // $scope.bankBalance.balanceAsPerBook=data.lDifferenceResultList[0].balanceAsPerBank+tempReceipt-tempPayment;
     		   //$scope.bankBalance.balanceAsPerBank=data.lDifferenceResultList[0].balanceAsPerBank;
      	      $scope.bankBalance.difference= $scope.bankBalance.balanceAsPerBook-$scope.bankBalance.balanceAsPerBank;

     		   $scope.bankBalance.balanceAsPerBankUsd=data.lDifferenceResultList[0].balanceAsPerBankUsd;
     		  tempBalance=data.lDifferenceResultList[0].balanceAsPerBank;
     		  tempBalanceUsd=data.lDifferenceResultList[0].balanceAsPerBankUsd;
			  tempBalance1=data.lDifferenceResultList[0].balanceAsPerBook+tempPayment-tempReceipt;
            }else{
            	 logger.logError("No Records Found!...");
            }
            
        });
      
        
        }
    };
  
    //draft list
    
    
    
    
    
    $scope.openFileModal = function () {
        var isOpenModal=false;
        /*$scope.bankReconcile.fromDate = $("#fromdate").val();
        $scope.bankReconcile.toDate = $("#todate").val();*/
        if($scope.bankReconcile.fromDate =="" ||  $scope.bankReconcile.toDate=="" ){
            logger.logError("Please select valid date!...");    
        }else if($scope.bankReconcile.bankCode==""){
            logger.logError("Please select Bank!...");    
        }
        else{
            
            var formData=new FormData();
            $scope.bankReconcile.validFromDate =$scope.bankReconcile.fromDate;
            $scope.bankReconcile.validToDate= $scope.bankReconcile.toDate;
            formData.append("fromDate", $scope.bankReconcile.validFromDate);
            formData.append("toDate", $scope.bankReconcile.validToDate);
            formData.append('bankCode', $scope.bankReconcile.bankCode);
            $.ajax({
                type : "POST",
                url : $stateParams.tenantid+"/app/bankReconciliation/checkStatementAvailablity",
                data : formData,
                async: false,
                contentType: false,
                processData: false,
                success : function(result) {
                    if(result.success){
                        logger.logError("Data already uploaded for selected Bank Account in this date Range!...");
                        isOpenModal =false;
                    }else{
                        isOpenModal =true;
                    }
                    }
               
            });
        }
        debugger;
        if(isOpenModal){
            ngDialog.close();
            ngDialog.open({
                template : 'fileModal',
                scope :$scope
            });
        }
        
    }
    $scope.bankBalance={
    		difference : 0,
    		balanceAsPerBook : 0,
    		balanceAsPerBank : 0,
    		differenceReceipt : 0,
    		differencePayment : 0,
    		balanceAsPerBankUsd : 0
    }
    //save record   
   

    $scope.calculateTotal= function(table){
    	 var debit=0;
    	 var credit=0;
    	 var debitUsd=0;
    	 var creditUsd=0;
    	 var balanceUsd=0;
    	 var balance=$scope.bankBalance.balanceAsPerBank;
    	 if($scope.bankBalance.balanceAsPerBankUsd != ""){
    		   balanceUsd=$scope.bankBalance.balanceAsPerBankUsd; 
    	 }
    	  
    	
    	 $scope.bankBalance.balanceAsPerBank=0;
    	 $scope.bankBalance.balanceAsPerBankUsd=0;
    	 $scope.bankBalance.differenceReceipt=0;
    	 $scope.bankBalance.differencePayment=0;
    	angular.forEach(table, function(row, index) {
    		  var check =row.bank_date;
              if (check != '' && check != null) {
            	  if(row.debitamount !=0){
            		 // credit=credit+row.creditamount;
                	  debit=debit+row.debitamount;
                	  if(row.tcDebitAmount != "" && row.tcDebitAmount != null){
                	  debitUsd=debitUsd+row.tcDebitAmount;
                	  }
                	//  $scope.bankBalance.balanceAsPerBank=$scope.bankBalance.balanceAsPerBank+debit;
                	  $scope.bankBalance.differenceReceipt=debit;
            	  }
            	  else if(row.creditamount !=0){
            		  credit=credit+row.creditamount;
            		  if(row.tcCreditAmount != "" && row.tcCreditAmount != null){
            			  creditUsd=creditUsd+row.tcCreditAmount;
            		  }
            		
                	 // debit=debit-row.debitamount;
            		//  $scope.bankBalance.balanceAsPerBank=$scope.bankBalance.balanceAsPerBank-credit;
            		  $scope.bankBalance.differencePayment=credit;
            	  }
            	 
              }else{
                  
              }
  	  });
    	
    	$scope.bankBalance.balanceAsPerBank=debit-credit+tempBalance;
    	$scope.bankBalance.balanceAsPerBankUsd=debitUsd-creditUsd+tempBalanceUsd;
    	$scope.bankBalance.differenceReceipt=tempReceipt-$scope.bankBalance.differenceReceipt;
    	$scope.bankBalance.differencePayment=tempPayment-$scope.bankBalance.differencePayment;
    	
    	//$scope.bankBalance.balanceAsPerBook=tempBalance1+(debit-credit);
    	$scope.getdifference($scope.bankBalance);
    }
    
    
    $scope.reconcileRecords = function (table) {
        debugger;
        $scope.tablerow=[];
        angular.forEach(table, function(row, index) {
            var check =row.bank_date;
            if (check != '' && check != null) {
                delete row['select'];
                row['bank_account_code']=$scope.bankReconcile.bankCode;
                row['toDate']=$scope.bankReconcile.toDate;
                row['fromDate']=$scope.bankReconcile.fromDate;
                $scope.tablerow.push(row);
            }else{
                
            }
        });
        if($scope.bankBalance.difference != ''){
      	  if($scope.tablerow.length>0){
      		  $scope.tablerow[0]['difference']=$scope.bankBalance.difference;
      	  }
      	  
      }
        if($scope.bankBalance.balanceAsPerBank != ''){
        	  if($scope.tablerow.length>0){
        		  $scope.tablerow[0]['balanceAsPerBank']=$scope.bankBalance.balanceAsPerBank;
        	  }
        	  
        }
        if($scope.bankBalance.balanceAsPerBankUsd != ''){
      	  if($scope.tablerow.length>0){
      		  $scope.tablerow[0]['balanceAsPerBankUsd']=$scope.bankBalance.balanceAsPerBankUsd;
      	  }
      	  
      	  
      }
        if($scope.bankBalance.balanceAsPerBook != ''){
        	  if($scope.tablerow.length>0){
        		  $scope.tablerow[0]['balanceAsPerBook']=$scope.bankBalance.balanceAsPerBook;
        	  }
        	  
        	  
        }
        if($scope.bankBalance.differenceReceipt != ''){
        	  if($scope.tablerow.length>0){
        		  $scope.tablerow[0]['differenceReceipt']=$scope.bankBalance.differenceReceipt;
        	  }
        	  
        	  
        }
        if($scope.bankBalance.differencePayment != ''){
        	  if($scope.tablerow.length>0){
        		  $scope.tablerow[0]['differencePayment']=$scope.bankBalance.differencePayment;
        	  }
        	  
        	  
        }
        if($scope.bankReconcile.bankCode != null && $scope.bankReconcile.bankCode != ''){
       if($scope.tablerow.length>0){
           $http.post($stateParams.tenantid+'/app/bankReconciliation/reconcileRecords', $scope.tablerow).success(function(result) {
               if(result.message == "") {
                   logger.logSuccess("Reconciled successfully!");
                   sharedProperties.setObject($scope.bankReconcile);
                   $state.reload();
                  // $location.path('/reports/manualreconcillation');
               } else {
            	   logger.logError(result.message);               }
           }).error(function(result) {
               console.log("data" + result);
           });
          
       }else{
           logger.logError("Please Select Atleast one row!...");
       }
        }
        else{
        	 logger.logError("Please Select the Bank!...");
        }
    }
   
  //save in draft  
    $scope.reconcileRecordsDraft = function (table) {
        debugger;
        $scope.tablerow=[];
        angular.forEach(table, function(row, index) {
            var check =row.bank_date;
            if (check != '' && check != null) {
                delete row['select'];
                row['bank_account_code']=$scope.bankReconcile.bankCode;
                row['toDate']=$scope.bankReconcile.toDate;
                row['fromDate']=$scope.bankReconcile.fromDate;
                $scope.tablerow.push(row);
            }else{
                
            }
        });
        if($scope.bankBalance.difference != ''){
        	  if($scope.tablerow.length>0){
        		  $scope.tablerow[0]['difference']=$scope.bankBalance.difference;
        	  }
        	  
        }
          if($scope.bankBalance.balanceAsPerBank != ''){
          	  if($scope.tablerow.length>0){
          		  $scope.tablerow[0]['balanceAsPerBank']=$scope.bankBalance.balanceAsPerBank;
          	  }
          	  
          }
          if($scope.bankBalance.balanceAsPerBook != ''){
        	  if($scope.tablerow.length>0){
        		  $scope.tablerow[0]['balanceAsPerBook']=$scope.bankBalance.balanceAsPerBook;
        	  }
        	  
        }
          if($scope.bankReconcile.bankCode != ''){
        	  if($scope.tablerow.length>0){
        		  $scope.tablerow[0]['bankCode']=$scope.bankReconcile.bankCode;
        	  }
        	  
        }
          
          if($scope.bankBalance.differenceReceipt != ''){
        	  if($scope.tablerow.length>0){
        		  $scope.tablerow[0]['differenceReceipt']=$scope.bankBalance.differenceReceipt;
        	  }
        	  
        	  
        }
        if($scope.bankBalance.differencePayment != ''){
        	  if($scope.tablerow.length>0){
        		  $scope.tablerow[0]['differencePayment']=$scope.bankBalance.differencePayment;
        	  }
        	  
        	  
        }
          
        //bankReconciliationDraft
       // if($scope.bankReconcile.bankCode != null && $scope.bankReconcile.bankCode !=''){
       if($scope.tablerow.length>0){
           $http.post($stateParams.tenantid+'/app/bankReconciliation/savereconcileRecordsDraft', $scope.tablerow).success(function(result) {
               console.log("result")
              console.log(result.message)
              if(result.message == "") {
                   logger.logSuccess("Saved in draft successfully!");
                   sharedProperties.setObject($scope.bankReconcile);
                   $state.reload();
                  /* $location.path('/reports/manualreconcillation');*/
               } else {
                   logger.logError(result.message);
               }
           }).error(function(result) {
               console.log("data" + result);
           });
       }else{
           logger.logError("Please Select Atleast one row!...");
       }
//    }
//    else{
//    	 logger.logError("Please Select the Bank!...");
//    }
    }
    
    $rootScope.uploadFile = function(element){
        $scope.excelfile = element.files[0];
        console.log($scope.excelfile);
    }
    
    $rootScope.uploadBankStatement =function(){
        ngDialog.close();
        var excelfile=$scope.excelfile;
        var fileExtension= excelfile.name;
      
        var fName=[];
        fName=fileExtension.split(".");
        for(var i=1;i<fName.length;i++){
            if(fName[i] == "xls" || fName[i] == "xlsx"){
                var frmData=new FormData();
                frmData.append("file",excelfile);
                frmData.append('bankCode', $scope.bankReconcile.bankCode);
                $.ajax({
                    type : "POST",
                    url : $stateParams.tenantid+"/app/bankReconciliation/uploadfile",
                    data : frmData,
                    contentType: false,
                    processData: false,
                    success : function(result) {
                        if(result.success){
                        	$state.reload();
                            logger.logSuccess("File Uploaded Successfully");
                        }else{
                            toaster.pop('error', "", 
                                    result.message, 900000, 'trustedHtml');
                            logger.logError("Fail to Upload");    
                        }
                        
                        }
                   
                });
            }else{
            	  logger.logError("Please select valid file formate");    
            }
            
        }
    
    }
    
    $rootScope.closeThisDialog = function() {
        ngDialog.close();
     };
});


app.service("ListService",function($http,$q,$stateParams){
	
    this.getCashBankList = function(){
      

        var bankList = $q.defer();
        /*$http.get($stateParams.tenantid+'/app/bankReconciliation/getBankList').success(function(data) {
        	  if (data != null) {
                  debugger;
//              $scope.BankList = data;
         bankList.resolve(data);
         }
         
         
        }).error(function(data) {
        
            bankList.reject("Failed to get Bank List");
        
        });*/
$http.get($stateParams.tenantid+ '/app/cashbankPayment/getBankAcctList?paymentType='+ 'bank' + '&companyCode=' + 'C0001')
								.success(
										function(data) {
											console
													.log("data::::::::::::bankAccountList::getBankAcctList:::::::::");
											console.log(data);
											var acctList = [];

											angular
													.forEach(
															data,
															function(item, key) {
																var accObj = new Object();
																accObj.id = data[key].acctHeadCode;
																accObj.text = data[key].accountName;
																accObj.currencyCode = data[key].currencyCode;
																accObj.exchangeRate = data[key].exchangeRate;
																acctList
																		.push(accObj);
															});
											bankList.resolve(acctList);

										}).error(function(data) {
        
            bankList.reject("Failed to get Bank List");
        
        });
        return bankList.promise;
    }
    
    this.getDateInDDMMYYYY=function convert(str) {
        var date = new Date(str),
            mnth = ("0" + (date.getMonth()+1)).slice(-2),
            day  = ("0" + date.getDate()).slice(-2);
        return [ day, mnth, date.getFullYear() ].join("-");
    }
});

app.controller('bankreconciliationDraftCtrl', function($scope, $rootScope, $http, $location, logger, $log, ngDialog, $modal, utilsService, $window,$state,sharedProperties,$stateParams) {
	  $scope.isRecoDraft=true;
	    $scope.isReco=true;
 
    var fromDate = $location.search().fromDate;
    var toDate = $location.search().toDate;
    var bankCode = $location.search().bankCode;
    console.log(fromDate , toDate , bankCode)
    $scope.bankReconcile = {
            fromDate : '',
            toDate : '',
            bankCode : '',
            validFromDate:'',
            validToDate:''
        };
    
    $scope.bankBalance={
    		difference : 0,
    		balanceAsPerBook : 0,
    		balanceAsPerBank : 0,
    		differenceReceipt : 0,
    		differencePayment : 0
    }
 //  $scope.getReconcileListdraft = function() {

        debugger;
        $scope.isReconcileList=true;
        $scope.dataLoopCount = 0;
        $scope.showEmptyLabel = false;
        $scope.from = 0;
        $scope.to = 100;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollectionDraft = [];
       /* $scope.bankReconcile.fromDate = $("#fromdate").val();
        $scope.bankReconcile.toDate = $("#todate").val();
        */
       var  tempBalance =0;
       var  tempReceipt=0;
       var  tempPayment=0;
        $scope.bankReconcile.validFromDate =fromDate;
        $scope.bankReconcile.validToDate= toDate;
        $scope.bankReconcile.validbankCode=bankCode;
        var url = $stateParams.tenantid+'/app/bankReconciliation/getReconcileListDraft1?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount;
        url=url+'&fromDate='+ $scope.bankReconcile.validFromDate+'&toDate='+ $scope.bankReconcile.validToDate+'&bankCode='+$scope.bankReconcile.validbankCode;
       console.log("params" + $scope.bankReconcile.validFromDate,$scope.bankReconcile.validToDate, $scope.bankReconcile.validbankCode);
       /* var url = 'app/bankReconciliation/getReconcileListDraft2?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount;
        url=url+'&fromDate='+ $scope.bankReconcile.validFromDate+'&toDate='+ $scope.bankReconcile.validToDate+'&bankCode='+$scope.bankReconcile.validbankCode;*/
        $http.get(url).success(function(data) {
            if (data.success == true) {
           	    $scope.bankBalance.differenceReceipt=0;
    			  $scope.bankBalance.differencePayment=0;
                console.log("draft list")
                console.log(data)
                $scope.rowCollectionDraft = data.lDifferenceResultList1;   
                console.log("data.lDifferenceResultList1.length" +data.lDifferenceResultList1.length)
                if(data.lDifferenceResultList1.length > 0){
         		   
         		  for(var i=0;i < data.lDifferenceResultList1.length;i++){
         			  $scope.bankBalance.differenceReceipt=$scope.bankBalance.differenceReceipt+data.lDifferenceResultList1[i].debitamount;
         			  $scope.bankBalance.differencePayment=$scope.bankBalance.differencePayment+data.lDifferenceResultList1[i].creditamount;
         		  }
         		   tempReceipt=$scope.bankBalance.differenceReceipt;
         	       tempPayment=$scope.bankBalance.differencePayment;
         	      $scope.bankBalance.difference=data.lDifferenceResultList1[0].difference;
       		   $scope.bankBalance.balanceAsPerBook=data.lDifferenceResultList[0].balanceAsPerBook+tempPayment-tempReceipt;
        		  $scope.bankBalance.balanceAsPerBank=data.lDifferenceResultList1[0].balanceAsPerBank;
        		  tempBalance=data.lDifferenceResultList1[0].balanceAsPerBank;
         	   }
                 if(data.lDifferenceResultList1.length==0){
                     logger.logError("No Records Found!...");
                     $scope.bankBalance.differenceReceipt=0;
       			  $scope.bankBalance.differencePayment=0;
       			$scope.bankBalance.balanceAsPerBook=0;
       			$scope.bankBalance.balanceAsPerBank=0;
                 }
               
            }else{
           //     logger.logError("Some errors occured.Please try again!...");
            }
        });
    
  // $scope.getReconcileListdraft = function() {

    /*    debugger;
        $scope.isReconcileList=true;
        $scope.dataLoopCount = 0;
        $scope.showEmptyLabel = false;
        $scope.from = 0;
        $scope.to = 100;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollectionDraft = [];*/
       
       /* $scope.bankReconcile.validFromDate =$scope.bankReconcile.fromDate;
        $scope.bankReconcile.validToDate= $scope.bankReconcile.toDate;*/
        
     


 //  }
      /* $scope.bankReconcile.validFromDate =$scope.bankReconcile.fromDate;
         $scope.bankReconcile.validToDate= $scope.bankReconcile.toDate;
         $scope.bankReconcile.validbankCode=$scope.bankReconcile.bankCode;*/
 //  console.log("params" + $scope.bankReconcile.validFromDate,$scope.bankReconcile.validToDate, $scope.bankReconcile.validbankCode);
  /*  var url = $stateParams.tenantid+'/app/bankReconciliation/getReconcileListDraft1?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount;
   url=url+'&fromDate='+ $scope.bankReconcile.fromDate+'&toDate='+  $scope.bankReconcile.toDate+'&bankCode='$scope.bankReconcile.bankCode; ;
    $http.get(url).success(function(data) {
        if (data.success == true) {
            
            console.log("draft list")
            console.log(data)
            $scope.rowCollectionDraft = data.lDifferenceResultList1;   
           console.log("data.lDifferenceResultList1.length" +data.lDifferenceResultList1.length)

               
  
            if(data.lDifferenceResultList1.length==0){
                logger.logError("No Records Found!...");
            } 
           
        }else{
            logger.logError("No Records Found!...");
        }
    });*/
       
    
        $scope.cancel = function() {
        	
        	  	  $state.go('app.finance.reports.bankreconciliation',{tenantid:$stateParams.tenantid});
        	  	  
        	          
        	    };
        
        	    $scope.calculateTotal= function(table){
        	    	 var debit=0;
        	    	 var credit=0;
        	    	 var balance=$scope.bankBalance.balanceAsPerBank;
        	    	 $scope.bankBalance.balanceAsPerBank=0;
        	    	 $scope.bankBalance.differenceReceipt=0;
        	    	 $scope.bankBalance.differencePayment=0;
        	    	angular.forEach(table, function(row, index) {
        	    		  var check =row.bank_date;
        	              if (check != '' && check != null) {
        	            	  if(row.debitamount !=0){
        	            		 // credit=credit+row.creditamount;
        	                	  debit=debit+row.debitamount;
        	                	//  $scope.bankBalance.balanceAsPerBank=$scope.bankBalance.balanceAsPerBank+debit;
        	                	  $scope.bankBalance.differenceReceipt=debit;
        	            	  }
        	            	  else if(row.creditamount !=0){
        	            		  credit=credit+row.creditamount;
        	                	 // debit=debit-row.debitamount;
        	            		//  $scope.bankBalance.balanceAsPerBank=$scope.bankBalance.balanceAsPerBank-credit;
        	            		  $scope.bankBalance.differencePayment=credit;
        	            	  }
        	            	 
        	              }else{
        	                  
        	              }
        	  	  });
        	    	
        	    	$scope.bankBalance.balanceAsPerBank=debit-credit+tempBalance;
        	    	$scope.bankBalance.differenceReceipt=tempReceipt-$scope.bankBalance.differenceReceipt;
        	    	$scope.bankBalance.differencePayment=tempPayment-$scope.bankBalance.differencePayment;
        	    	
        	    	//$scope.bankBalance.balanceAsPerBook=tempBalance1+(debit-credit);
        	    	$scope.getdifference($scope.bankBalance);
        	    }
        	    
        $scope.reconcileRecords = function(rowCollectionDraft) {
            console.log("rowCollectionDraft")
          
            $scope.tablerow=[];
        angular.forEach(rowCollectionDraft, function(row, index) {
            var check =row.bank_date;
            if (check != '' && check != null) {
                delete row['select'];
             //   row['bank_account_code']=$scope.bankReconcile.bankCode;
                row['toDate']=$scope.bankReconcile.validToDate;
                row['fromDate']=$scope.bankReconcile.fromDate;
                $scope.tablerow.push(row);
            }else{
                
            }
        });
        if($scope.bankBalance.difference != ''){
      	  if($scope.tablerow.length>0){
      		  $scope.tablerow[0]['difference']=$scope.bankBalance.difference;
      	  }
      	  
      }
        if($scope.bankBalance.balanceAsPerBank != ''){
        	  if($scope.tablerow.length>0){
        		  $scope.tablerow[0]['balanceAsPerBank']=$scope.bankBalance.balanceAsPerBank;
        	  }
        	  
        }
        if($scope.bankBalance.balanceAsPerBook != ''){
      	  if($scope.tablerow.length>0){
      		  $scope.tablerow[0]['balanceAsPerBook']=$scope.bankBalance.balanceAsPerBook;
      	  }
      	  
      }
        if($scope.bankBalance.differenceReceipt != ''){
      	  if($scope.tablerow.length>0){
      		  $scope.tablerow[0]['differenceReceipt']=$scope.bankBalance.differenceReceipt;
      	  }
      	  
      	  
      }
      if($scope.bankBalance.differencePayment != ''){
      	  if($scope.tablerow.length>0){
      		  $scope.tablerow[0]['differencePayment']=$scope.bankBalance.differencePayment;
      	  }
      	  
      	  
      }
          
           $http.post($stateParams.tenantid+'/app/bankReconciliation/reconcileRecords', $scope.tablerow).success(function(result) {
        	   console.log(result.message)
               if(result.message == "") {
                	   logger.logSuccess("Reconciled successfully");
                	  $state.go('app.finance.reports.bankreconciliation',{tenantid:$stateParams.tenantid});
                 }  else {
                     logger.logError(result.message);
                 }
             }).error(function(result) {
                 console.log("data" + result);
             });}
           

         
     
    
})