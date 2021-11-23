//define([ 'hospital/accounts/accounts' ], function(module) {

    'use strict';

    app.controller('bankReconcillationCtrl', function($scope, $state, $http, $stateParams,
            ngDialog, logger, validationService, $location, $controller, $injector, sharedProperties,
            toaster, $rootScope, ListService) {

        $scope.isReconcileList = false;
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
            validFromDate : '',
            validToDate : '',
            differencePayment:'',
            differenceReceipt:'',
            dtl :[]
        };
        $scope.bankList = [];
        $scope.excelfile = [];

        $scope.getBankAccountList = function() {
            var pmtType = "bankreco";
            $scope.dataList = ListService.getBankAcctList(pmtType);

            $scope.dataList.then(function(data) {
                $scope.bankList = data;
            });
        };
        $scope.getBankAccountList();

        $scope.getDateInDDMMYYYY = function convert(str) {
            var date = new Date(str), mnth = ("0" + (date.getMonth() + 1)).slice(-2), day = ("0" + date.getDate()).slice(-2);
            return [ day, mnth, date.getFullYear() ].join("-");
        }

        
        $scope.bankReconcile.bankBalanceAsPerBank=0;
        $scope.balanceAsPerBook=0;
        $scope.difference=0;
        $scope.details=false;
        $scope.differenceReceipt=0;
        $scope.differencePayment=0;
        $scope.getDiffernceList = function() {
            $scope.isReconcileList = false;
            $scope.dataLoopCount = 0;
            $scope.showEmptyLabel = false;
            $scope.from = 0;
            $scope.to = 100;
            $scope.rowCollection = [];
            
            if ($scope.bankReconcile.fromDate == "" || $scope.bankReconcile.toDate == "" || (angular.equals($scope.bankReconcile.fromDate, $scope.bankReconcile.toDate))) {
                logger.logError("Please select valid date range!...");
            } else {
                var url = 'app/bankReconciliation/getDifferenceList?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount;
                url = url + '&fromDate=' + $scope.bankReconcile.fromDate + '&toDate=' + $scope.bankReconcile.toDate + '&bankCode=' + $scope.bankReconcile.bankCode;
                $http.get(url).success(function(data) {
                    $scope.details=true;
                    $scope.bankReconcile.bankBalanceAsPerBank=data.bankBalanceAsPerBank;
                    $scope.bankReconcile.bankBalanceAsPerBook=data.bankBalanceAsPerBank;

                    $scope.balanceAsPerBook=data.balanceAsPerBook+data.differenceReceipt-data.differencePayment;
                    $scope.bankReconcile.differenceReceipt=data.differenceReceipt;
                    $scope.bankReconcile.differencePayment=data.differencePayment;
                    $scope.difference=$scope.bankReconcile.bankBalanceAsPerBank- $scope.balanceAsPerBook;
                    $scope.differReceiptAmt=data.differenceReceipt;
                    $scope.differPaymentAmt=data.differencePayment;
                    $scope.bankBalAsPerBankTotal=data.bankBalanceAsPerBank;

                  /*  var debit=0;
                    var credit=0;
                    
                    if(data.lDifferenceResultList.length > 0){
                        
                        for(var i=0;i < data.lDifferenceResultList.length;i++){
                            $scope.differenceReceipt=debit+data.lDifferenceResultList[i].book_credit_amt;
                            $scope.differencePayment=credit+data.lDifferenceResultList[i].book_debit_amt;
                        }
                    }
                    $scope.differencePayment= 7155*/;
                    if (data.success == true) {
                        $scope.rowCollection = $scope.rowCollection.concat(data.lDifferenceResultList);
                        $scope.bankReconcile.dtl=$scope.rowCollection;
                        if (data.lDifferenceResultList.length == 0) {
                            logger.logError("No Records Found!...");
                        }
                    } else {
                        logger.logError("Some errors occured.Please try again!...");
                    }
                });
            }
        };

        
        
        $scope.getReconcileList = function() {
            $scope.isReconcileList = true;
            $scope.dataLoopCount = 0;
            $scope.showEmptyLabel = false;
            $scope.from = 0;
            $scope.to = 100;
            $scope.rowCollection = [];
            if ($scope.bankReconcile.fromDate == "" || $scope.bankReconcile.toDate == "" || (angular.equals($scope.bankReconcile.fromDate, $scope.bankReconcile.toDate))) {
                logger.logError("Please select valid date range!...");
            } else {
                var url = 'app/bankReconciliation/getReconcileList?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount;
                url = url + '&fromDate=' + $scope.bankReconcile.fromDate + '&toDate=' + $scope.bankReconcile.toDate + '&bankCode=' + $scope.bankReconcile.bankCode;
                $http.get(url).success(function(data) {
                    if (data.success == true) {
//                        $scope.rowCollection = $scope.rowCollection.concat(data.lDifferenceResultList);
                        $scope.rowCollection =data.lDifferenceResultList;
                        $scope.bankReconcile.dtl = data.lDifferenceResultList;
                        $scope.bankReconcile.bankBalanceAsPerBank=data.bankBalanceAsPerBank;
                        $scope.balanceAsPerBook=$scope.bankReconcile.bankBalanceAsPerBook;
                        ///data.differenceReceipt-data.differencePayment;
                        $scope.difference=($scope.bankReconcile.bankBalanceAsPerBook-$scope.bankReconcile.bankBalanceAsPerBook);
                        $scope.details=false;
                        if (data.lDifferenceResultList.length == 0) {
                            logger.logError("No Records Found!...");
                            $scope.rowCollection  = [];
                        }
                    } else {
                        logger.logError("Some errors occured.Please try again!...");
                    }
                });
            }
        };

        $scope.openFileModal = function() {
            var isOpenModal = false;
            if ($scope.bankReconcile.fromDate == "" || $scope.bankReconcile.toDate == "" || (angular.equals($scope.bankReconcile.fromDate, $scope.bankReconcile.toDate))) {
                logger.logError("Please select valid date range!...");
            } else if ($scope.bankReconcile.bankCode == "") {
                logger.logError("Please select Bank!...");
            } else {

                var formData = new FormData();
                formData.append("fromDate", $scope.bankReconcile.fromDate);
                formData.append("toDate", $scope.bankReconcile.toDate);
                formData.append('bankCode', $scope.bankReconcile.bankCode);
//                $.ajax({
//                    type : "POST",
//                    url : "app/bankReconciliation/checkStatementAvailablity",
//                    data : formData,
//                    async : false,
//                    contentType : false,
//                    processData : false,
//                    success : function(result) {
//                        if (result.success) {
//                            logger.logError("Data already uploaded for selected Bank Account in this date Range!...");
//                            isOpenModal = false;
//                        } else {
//                            isOpenModal = true;
//                        }
//                    }
//
//                });
                $http.get('app/bankReconciliation/checkStatementAvailablity?fromDate=' +  $scope.bankReconcile.fromDate + '&toDate=' + $scope.bankReconcile.toDate +'&bankCode=' + $scope.bankReconcile.bankCode).success(function(result) {

                  if (result.success) {
                      logger.logError("Data already uploaded for selected Bank Account in this date Range!...");
                      isOpenModal = false;
                  } else {
                      isOpenModal = true;
                      
                      if (isOpenModal) {
                          ngDialog.close();
                          ngDialog.open({
                              template : 'fileModal',
                              scope : $scope
                          });
                      }
                  }
                });
                
                
                

            }
        

        }
        
        
        
     
        
        
        
        
        
        
        
             $scope.reconcileRecords = function(table) {
            $scope.tablerow = [];
            angular.forEach(table, function(row, index) {
                var check = row.select;
                if (check == true && row.bank_date != '' &&  row.bank_date != null && row.bank_date != undefined ) {
                    delete row['select'];
                    $scope.tablerow.push(row);
                } else {

                }
            });
            if ($scope.tablerow.length > 0) {
                
                $http.post('app/bankReconciliation/reconcileRecords', $scope.tablerow).success(function(result) {
                    if (result.success) {
                        logger.logSuccess("Reconciled Successfully!");
                        $location.path($stateParams.tenantid+'/hospital/accounts/bankReconciliation/list');
                    } else {
                        logger.logError("Unable to reconcile");
                    }
                }).error(function(result) {
                });
            } else {
                logger.logError("Please Select Atleast one row and Enter Bank Date !...");
            }

        }

        $rootScope.uploadFile = function(element) {
            $scope.excelfile = element.files[0];
        }

        $rootScope.uploadBankStatement = function() {
            ngDialog.close();
            var excelfile = $scope.excelfile;
            var fileExtension = excelfile.name;
            var fName = [];
            fName = fileExtension.split(".");
            for (var i = 0; i < fName.length; i++) {
                if (fName[i] == "xls" || fName[i] == "xlsx") {
                    var frmData = new FormData();
                    frmData.append("file", excelfile);
                    frmData.append('bankCode', $scope.bankReconcile.bankCode);
                    $.ajax({
                        type : "POST",
                        url : "app/bankReconciliation/uploadfile",
                        data : frmData,
                        contentType : false,
                        processData : false,
                        success : function(result) {
                            if (result.success) {
                                logger.logSuccess("File Uploaded Successfully");
                                $scope.getDiffernceList();
                            } else {
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
        
        
        $scope.calculateTotalSum= function(table){
            alert(6);
            
             
       }

        //Excel Export  
         $scope.exportExcel = function(){
             if ($scope.bankReconcile.fromDate == "" || $scope.bankReconcile.toDate == "" || (angular.equals($scope.bankReconcile.fromDate, $scope.bankReconcile.toDate))) {
                 logger.logError("Please select valid date range!...");
             } else {
              var flag = false;
//             $http.post($stateParams.tenantid+'/app/surcharge/ExportExcel').success(function(response) {
                 var url = 'app/bankReconciliation/ExportExcel?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount;
                 url = url + '&fromDate=' + $scope.bankReconcile.fromDate + '&toDate=' + $scope.bankReconcile.toDate + '&bankCode=' + $scope.bankReconcile.bankCode;
//                 $http.post(url).success(function(response) {
                 $http.get(url).success(function(response) {

                        if(response){
                            debugger;


                            $("#bankId").bind('click', function() {
                            });
                            $('#bankId').simulateClick('click');
                            logger.logSuccess("Exported successfully!");
                        
                        }else{
                            logger.logError("No Records Found");
                        }
                        
                    }).error(function(response) {
                        logger.logError("Error Please Try Again");
                    });
//            }
            }
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
         
        $scope.checkAll = function(){
            

            angular.forEach($scope.bankReconcile.dtl, function(row, index) { 
            if($scope.bankReconcile.checkAll==true){

                row.select=true;

            }else{

                row.select=false;

            }



            });
        }

        
    });
    app.factory("ListService", function($http, $q, logger) {
        var cbPaymentService = new Object();

        cbPaymentService.getBankAcctList = function(pmtType) {
            var bankAccountList = $q.defer();

            $http.get('app/cashbankPayment/getBankAcctList?paymentType=' + pmtType).success(function(data) {
                var acctList = [];

                angular.forEach(data, function(item, key) {
                    var accObj = new Object();
                    accObj.id = data[key].acctHeadCode;
                    accObj.text = data[key].accountName;
                    accObj.currencyCode = data[key].currencyCode;
                    accObj.exchangeRate = data[key].exchangeRate;
                    acctList.push(accObj);
                });
                bankAccountList.resolve(acctList);

            }).error(function(data) {

                bankAccountList.reject("Failed to get Bank Account List");

            });
            return bankAccountList.promise;
        }

        return cbPaymentService;
        
    });




app.controller('bankReconcillationCtrlcal', function($scope, $state, $http, 
        ngDialog, logger, validationService, $location, $controller, $injector, sharedProperties,
        toaster, $rootScope, ListService) {

    
    
    $scope.bankBalance={
            difference : 0,
            balanceAsPerBook : 0,
            balanceAsPerBank : 0,
            differenceReceipt : 0,
            differencePayment : 0,
            balanceAsPerBankUsd : 0
    }
    
    
    $scope.$watch('bankReconcile.dtl[trIndex].bank_date', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
   
        var debit=0;
        var credit=0;
        var debitUsd=0;
        var creditUsd=0;
        var balanceUsd=0;
        var balance=$scope.bankBalance.balanceAsPerBank;
        
        $scope.bankBalance.balanceAsPerBank=0;
        $scope.bankBalance.balanceAsPerBankUsd=0;
        $scope.bankBalance.differenceReceipt=0;
        $scope.bankBalance.differencePayment=0;
             var check =newValue;
             if (check != '' && check != null) {
                 if($scope.bankReconcile.dtl[$scope.$index].book_debit_amt !=0){
                     debit=debit+$scope.bankReconcile.dtl[$scope.$index].book_debit_amt;
                   
                     $scope.bankReconcile.differenceReceipt=debit;
                 }
                 else if($scope.bankReconcile.dtl[$scope.$index].book_credit_amt !=0){
                     credit=credit+$scope.bankReconcile.dtl[$scope.$index].book_credit_amt;
                 
                     $scope.bankReconcile.differencePayment=credit;
                 }
                
             }else{
                 
                 
                 
             }
   
       
             var tempBalance=0;
             var tempBalanceUsd=0;
             var tempBalance1=0;
             var tempReceipt=0;
             var tempPayment=0;
             
       $scope.balanceAsPerBank=debit-credit+tempBalance;
//       $scope.bankReconcile.differenceReceipt=tempReceipt-$scope.bankReconcile.differenceReceipt;
//       $scope.bankReconcile.differencePayment=tempPayment-$scope.bankReconcile.differencePayment;       
       $scope.balanceAsPerBook=tempBalance1+(debit-credit);
//       $scope.getdifference($scope.differencePayment);
       
       
       
//       Payment and Receipt Total CAl

   //  alert( $scope.differReceiptAmt);
//           $scope.differPaymentAmt
//       $scope.bankBalAsPerBankTotal
       var paymentTotAmt = 0;
       var receiptTotAmt = 0;
       var balAsPerBankPayment = 0;
       var balAsPerBankReceipt = 0;
       angular.forEach($scope.bankReconcile.dtl,function(row,index){
           
           if(row.type == 'Payment'){
               if(row.bank_date != null && row.bank_date != '' && row.bank_date != undefined){
               paymentTotAmt = paymentTotAmt + row.book_credit_amt + row.book_debit_amt;
               balAsPerBankPayment = balAsPerBankPayment +  row.book_credit_amt + row.book_debit_amt;
               }
           }
           if(row.type == 'Receipt'){
               if(row.bank_date != null && row.bank_date != '' && row.bank_date != undefined){
               receiptTotAmt = receiptTotAmt + row.book_debit_amt+  row.book_credit_amt;

               balAsPerBankReceipt = balAsPerBankReceipt + row.book_debit_amt+  row.book_credit_amt;
               }
           }
       })
//           alert(paymentTotAmt);
//       alert($scope.bankBalAsPerBankTotal);
//       alert(balAsPerBankPayment);
//       alert(balAsPerBankReceipt);
       $scope.bankReconcile.differenceReceipt=$scope.differReceiptAmt-receiptTotAmt;
       $scope.bankReconcile.differencePayment=$scope.differPaymentAmt-paymentTotAmt;
       $scope.bankReconcile.bankBalanceAsPerBank =  ($scope.bankBalAsPerBankTotal - balAsPerBankPayment) + balAsPerBankReceipt;
//       alert($scope.bankBalanceAsPerBank);
//     $scope.bankReconcile.differencePayment=tempPayment-$scope.bankReconcile.differencePayment;  
       
//       END 
       
       
    }else{
        var paymentTotAmt = 0;
        var receiptTotAmt = 0;
        var balAsPerBankPayment = 0;
        var balAsPerBankReceipt = 0;
        angular.forEach($scope.bankReconcile.dtl,function(row,index){
            
            if(row.type == 'Payment'){
                if(row.bank_date != null && row.bank_date != '' && row.bank_date != undefined){
                paymentTotAmt = paymentTotAmt + row.book_credit_amt + row.book_debit_amt;
                balAsPerBankPayment = balAsPerBankPayment +  row.book_credit_amt + row.book_debit_amt;
                }
            }
            if(row.type == 'Receipt'){
                if(row.bank_date != null && row.bank_date != '' && row.bank_date != undefined){
                receiptTotAmt = receiptTotAmt + row.book_debit_amt+  row.book_credit_amt;

                balAsPerBankReceipt = balAsPerBankReceipt + row.book_debit_amt+  row.book_credit_amt;
                }
            }
        })
//            alert(paymentTotAmt);
//        alert($scope.bankBalAsPerBankTotal);
//        alert(balAsPerBankPayment);
//        alert(balAsPerBankReceipt);
        $scope.bankReconcile.differenceReceipt=$scope.differReceiptAmt-receiptTotAmt;
        $scope.bankReconcile.differencePayment=$scope.differPaymentAmt-paymentTotAmt;
        $scope.bankReconcile.bankBalanceAsPerBank =  ($scope.bankBalAsPerBankTotal - balAsPerBankPayment) + balAsPerBankReceipt;
        
    }
        
    });



    $scope.getdifference = function(objTranslationItem){
        $scope.difference=$scope.balanceAsPerBank -$scope.balanceAsPerBook;
        
    }


});

//});