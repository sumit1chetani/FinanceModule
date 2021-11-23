'use strict';
app.controller('manualReconcillationCtrl', function($scope, $window, $rootScope, $location, $http, logger, $log, ngDialog, $modal, utilsService,$state,ListService,sharedProperties, $timeout,$stateParams) {
   
    $scope.isReconcileList=false;
    $scope.dataLoopCount = 0;
    $scope.from = 0;
    $scope.to = 100;
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.bankReconcile = {
            fromDate : '',
            toDate : '',
            bankCode : '',
            validFromDate:'',
            validToDate:''
        };
    $scope.BankList = [];
    $scope.excelfile=[];
    $scope.approvedBookData=[];
    $scope.approvedBankData=[];
    $('#from_date').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime: false
    });
    $('#to_date').datetimepicker({
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
    
    $timeout(function() {
    $scope.tempObj=sharedProperties.getObject();
    if($scope.tempObj.fromDate !=undefined && $scope.tempObj.toDate !=undefined && $scope.tempObj.bankCode !=undefined){
        debugger;
        console.log($scope.tempObj);
        $scope.bankReconcile=$scope.tempObj;
        $("#fromdate").val($scope.bankReconcile.fromDate)
        $("#todate").val($scope.bankReconcile.toDate);
        $scope.getDiffernceList();
    }
    }, 500);
    
    $scope.getDiffernceList = function() {
        debugger;
        $scope.isReconcileList=false;
        $scope.dataLoopCount = 0;
        $scope.showEmptyLabel = false;
        $scope.from = 0;
        $scope.to = 100;
        $scope.rowCollection = [];
        $scope.bankReconcile.fromDate = $("#fromdate").val();
        $scope.bankReconcile.toDate = $("#todate").val();
        if($scope.bankReconcile.fromDate =="" ||  $scope.bankReconcile.toDate=="" || (angular.equals($scope.bankReconcile.fromDate, $scope.bankReconcile.toDate))){
            logger.logError("Please select valid date range!...");    
        }else if($scope.bankReconcile.bankCode==""){
            logger.logError("Please select Bank!...");    
        }else{
        $scope.bankReconcile.validFromDate =$scope.bankReconcile.fromDate;
        $scope.bankReconcile.validToDate= $scope.bankReconcile.toDate;
        var url = $stateParams.tenantid+'/app/bankReconciliation/getDifferenceListForManual?';
        url=url+'&fromDate='+$scope.bankReconcile.validFromDate+'&toDate='+$scope.bankReconcile.validToDate+'&bankCode='+$scope.bankReconcile.bankCode;
        $http.get(url).success(function(data) {
            if (data.success == true) {
                debugger;
                $scope.bookStatementList =data.lBookStatementList;
                $scope.bankStatementList =data.lBankStatementList;
               
            }else{
                logger.logError("Some errors occured.Please try again!...");
            }
        });
        }
    };
    
    $scope.checkValidBookList = function(){
        $scope.approvedBookData=[];
        var iCounter=0;
        angular.forEach($scope.bookStatementList, function(row, index) {
            $scope.approvedBookData.push(row);
    /*        var check =row.select;
            if (check ==true) {
                if(iCounter ==0){
                    $scope.approvedBookData.push(row);
                }
                else{
                    logger.logError("Cannot select more than one row");
                    row.select=false;
                }
                iCounter++;     
            }*/

        });
    }
    
    $scope.checkValidBankList = function(){
        $scope.approvedBankData=[];
        var iCounter=0;
        angular.forEach($scope.bankStatementList, function(row, index) {
            $scope.approvedBankData.push(row);
  /*          var check =row.select;
            if (check ==true) {
                if(iCounter ==0){
                    $scope.approvedBankData.push(row);
                    iCounter++;
                }
                else{
                    logger.logError("Cannot select more than one row");
                    row.select=false;
                }
                    
            }*/

        });
    }

    $scope.reconcileRecords = function () {
        $scope.tablerow=[];
        console.log("Book Data and Bank Data");
        console.log($scope.approvedBankData);
        console.log($scope.approvedBookData);
        $scope.tempRow={
            bank_account_code: '',
            bank_cheque_no: '',
            bank_closing_balance: 0,
            bank_code: '',
            bank_credit_amt: 0,
            bank_date: '',
            bank_debit_amt: 0,
            bank_narration: '',
            bank_stmt_id: 0,
            book_cheque_date: '',
            book_cheque_no: '',
            book_credit_amt: 0,
            book_date: '',
            book_debit_amt: 0,
            book_narration: '',
            remarks: '',
            transaction_no: ''
        }
     /*   if($scope.approvedBankData.length ==1 && $scope.approvedBookData.length==1)
        {*/
        $scope.tempRow.bank_account_code = $scope.approvedBankData[0].bank_account_code;
        $scope.tempRow.bank_cheque_no = $scope.approvedBankData[0].bank_cheque_no;
        $scope.tempRow.bank_closing_balance = $scope.approvedBankData[0].bank_closing_balance;
        $scope.tempRow.bank_code = $scope.approvedBankData[0].bank_code;
        $scope.tempRow.bank_credit_amt = $scope.approvedBankData[0].bank_credit_amt;
        $scope.tempRow.bank_date = $scope.approvedBankData[0].bank_date;
        $scope.tempRow.bank_debit_amt = $scope.approvedBankData[0].bank_debit_amt;
        $scope.tempRow.bank_narration = $scope.approvedBankData[0].bank_narration;
        $scope.tempRow.bank_stmt_id = $scope.approvedBankData[0].bank_stmt_id;
        
        $scope.tempRow.book_cheque_date = $scope.approvedBookData[0].book_cheque_date;
        $scope.tempRow.book_cheque_no = $scope.approvedBookData[0].book_cheque_no;
        $scope.tempRow.book_credit_amt = $scope.approvedBookData[0].book_credit_amt;
        $scope.tempRow.book_date = $scope.approvedBookData[0].book_date;
        $scope.tempRow.book_debit_amt = $scope.approvedBookData[0].book_debit_amt;
        $scope.tempRow.book_narration = $scope.approvedBookData[0].book_narration;
        $scope.tempRow.remarks = $scope.approvedBookData[0].remarks;
        $scope.tempRow.transaction_no = $scope.approvedBookData[0].transaction_no;
        console.log($scope.tempRow);
        
            // check for amount match
            $scope.tablerow.push($scope.tempRow);
           if(($scope.tempRow.bank_debit_amt==$scope.tempRow.book_credit_amt)&&($scope.tempRow.bank_credit_amt==$scope.tempRow.book_debit_amt))
            {
                $http.post($stateParams.tenantid+'/app/bankReconciliation/reconcileRecords', $scope.tablerow).success(function(result) {
                    if(result) {
                        logger.logSuccess("Reconciled successfully!");
                        $location.path('/reports/manualreconcillation');
                    } else {
                        logger.logError("Unable to reconcile");
                    }
                }).error(function(result) {
                    console.log("data" + result);
                });
            }else{
               if($scope.remarks =='' || $scope.remarks ==undefined || $scope.remarks==null){
                   logger.logError("Please enter remarks");
               }else{
                   $scope.tempRow.remarks=$scope.remarks;
                   $http.post($stateParams.tenantid+'/app/bankReconciliation/reconcileRecords', $scope.tablerow).success(function(result) {
                       if(result) {
                           logger.logSuccess("Reconciled successfully!");
                           $location.path('/reports/manualreconcillation');
                       } else {
                           logger.logError("Unable to reconcile");
                       }
                   }).error(function(result) {
                       console.log("data" + result);
                   });
               }
            }
       /* }else{
            logger.logError("Please select one row on both list");
        }*/
        
    }
    
    $scope.exportunReconciledBankRecord = function() {
        debugger;
        $scope.bankReconcile.bankCode;
        $scope.bankReconcile.fromDate = $("#fromdate").val();
        $scope.bankReconcile.toDate = $("#todate").val();
        /*if($scope.bankReconcile.fromDate =="" ||  $scope.bankReconcile.toDate=="" || (angular.equals($scope.bankReconcile.fromDate, $scope.bankReconcile.toDate))){
            logger.logError(" select valid date range!...");    
        }else if($scope.bankReconcile.bankCode==""){
            logger.logError("Please select Bank!...");    
        }else{*/
            $scope.bankReconcile.validFromDate =$scope.bankReconcile.fromDate;
            $scope.bankReconcile.validToDate= $scope.bankReconcile.toDate;
            var url = $stateParams.tenantid+'/app/bankReconciliation/exportunReconciledBankRecord'
            url=url+'?fromDate='+$scope.bankReconcile.validFromDate+'&toDate='+$scope.bankReconcile.validToDate+'&bankCode='+$scope.bankReconcile.bankCode;
            $http.post(url).success(function(data) {
                if(data){
                    debugger;
                    $("#BankReconcileExport").bind('click', function() {
                    });
                    $('#BankReconcileExport').simulateClick('click');
                    logger.logSuccess("Exported successfully!");
                }else{
                    logger.logSuccess("Failed to export");
                }
                
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        /*}*/
    };
    
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
    
    $scope.getReconcileList = function() {
        debugger;
        $scope.isReconcileList=true;
        $scope.dataLoopCount = 0;
        $scope.showEmptyLabel = false;
        $scope.from = 0;
        $scope.to = 100;
        $scope.rowCollection = [];
        $scope.bankReconcile.fromDate = $("#fromdate").val();
        $scope.bankReconcile.toDate = $("#todate").val();
        if($scope.bankReconcile.fromDate =="" ||  $scope.bankReconcile.toDate=="" || (angular.equals($scope.bankReconcile.fromDate, $scope.bankReconcile.toDate))){
            logger.logError("Please select valid date range!...");    
        }else{
        $scope.bankReconcile.validFromDate =$scope.bankReconcile.fromDate;
        $scope.bankReconcile.validToDate= $scope.bankReconcile.toDate;
        var url = $stateParams.tenantid+'/app/bankReconciliation/getReconcileList?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount;
        url=url+'&fromDate='+$scope.bankReconcile.validFromDate+'&toDate='+$scope.bankReconcile.validToDate+'&bankCode='+$scope.bankReconcile.bankCode;
        $http.get(url).success(function(data) {
            if (data.success == true) {
                $scope.rowCollection = $scope.rowCollection.concat(data.lDifferenceResultList);
                if(data.lDifferenceResultList.length==0){
                    logger.logError("No Records Found!...");
                }
            }else{
                logger.logError("Some errors occured.Please try again!...");
            }
        });
        }
    };
    
    $scope.openFileModal = function () {
        var isOpenModal=false;
        $scope.bankReconcile.fromDate = $("#fromdate").val();
        $scope.bankReconcile.toDate = $("#todate").val();
        if($scope.bankReconcile.fromDate =="" ||  $scope.bankReconcile.toDate=="" || (angular.equals($scope.bankReconcile.fromDate, $scope.bankReconcile.toDate))){
            logger.logError("Please select valid date range!...");    
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
        for(var i=0;i<fName.length;i++){
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
                            logger.logSuccess("File Uploaded Successfully");
                        }else{
                            logger.logError("Fail to Upload");    
                        }
                        
                        }
                   
                });
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
        $http.get($stateParams.tenantid+'/app/bankReconciliation/getBankList').success(function(data) {
        
            bankList.resolve(data);
        
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