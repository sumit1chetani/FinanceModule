//define([ 'hospital/accounts/accounts' ], function(module) {

    //'use strict';

    app.controller('creditNoteAddCtrl', function($scope, $state, $http, $location, sharedProperties,
            toaster,$injector,logger,$stateParams, $timeout,validationService) {

        $scope.dataLoopCount = 0;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.acctHeadList = [];
        $scope.companyList = [];
        $scope.costCenterList = [];
        $scope.crdtlAcctHeadList = [];
        $scope.invoiceNoList = [];
        $scope.invoiceDetails=[];
        $scope.dtlSubAcctList=[];
        $scope.validated = false;
        $scope.paymentList=[];

        
        $scope.creditnoteAcctData = {
                accountName : '',  invoiceNo : '', invoiceDate :'', currencyCode : '', exchangeRate: '', 
                creditNoteDate: '', companyCode : '',company :'', narration: '',credittables: []
        };
        $scope.creditnoteDtlTotalAmt={
                totalBCAmount:'',totalTCAmount :''
        }
        $scope.edit =false;

       
        /**
         * fetch Current Date into PQ Date, Valid From Date
         */
        $scope.getCurrentDate = function(){
            var d=new Date();
            var year=d.getFullYear();
            var month=d.getMonth()+1;
            if (month<10){
                month="0" + month;
            };
            var day=d.getDate();
            if(day<10){
                day="0" + day;
            }
            $scope.date=day + "/" + month + "/" + year;
            
            $scope.creditnoteAcctData.creditNoteDate=$scope.date;
        }
        $scope.getCurrentDate();
        
        
        $scope.compareDate = function(creditNoteDate) {
            
            var isValidDate = false;
            var dateEntered = creditNoteDate; 
            var date = dateEntered.substring(0, 2);
            var month = dateEntered.substring(3, 5);
            var year = dateEntered.substring(6, 10);

            var dateToCompare = new Date(year, month - 1, date);
            var currentDate = new Date();

            
            if (dateToCompare > currentDate) {
                isValidDate = false;
            }
            else {                
                isValidDate = true;
            }
            return isValidDate;
        }
        
        /**
         * validation
         */
        $scope.checkBCAmount = function(){
            var isFlag=true;
            var crLength= $scope.creditnoteAcctData.credittables;
            
            angular.forEach($scope.creditnoteAcctData.credittables, function(row,index){
                if(parseFloat(row.bcamount)==0)
                     isFlag = false;
                else if(parseFloat($scope.isNaNCheck(row.bcamount))==0)
                    isFlag = false;
                else if(parseFloat($scope.isUndefinedAndNullCheck(row.bcamount))==0)
                    isFlag = false;                
             });
            return isFlag;
        }
        
        $scope.checkDtlTblRows = function(){
            var isFlag=true;
            var crLength= $scope.creditnoteAcctData.credittables;
            if(crLength == 0){
                isFlag=false;
            }
            return isFlag;
        }
        
        /**
         * is NaNCheck
         */
        $scope.isNaNCheck = function(value){
            if(isNaN(value)){
                value=0;
            }
            return value;
        }
        $scope.isUndefinedAndNullCheck = function(value){
            if(value==undefined && value==null && value==""){
                value=0;
            }
            return value;
        }
        
        $scope.validate = function(creditNoteForm,creditnoteAcctData) {
            
            var isValidDate = $scope.compareDate($scope.creditnoteAcctData.creditNoteDate);
            if(isValidDate){
                
                    if (new validationService().checkFormValidity($scope.creditNoteForm)) {
                        if(!$scope.edit){
                           $scope.save(creditNoteForm,creditnoteAcctData);
                        }else{
                            $scope.save(creditNoteForm,creditnoteAcctData);                      
                        }
                    } else {
                        toaster.pop('error', "Please fill the required fields", 
                                logger.getErrorHtmlNew($scope.creditNoteForm.$validationSummary), 555000, 'trustedHtml');
                    }
                            
            }else{
                logger.logError("Credit Note Date should not be a Future Date");
            }
        };
        
        $scope.getDropdownValue = function(){
            $http.get('app/commonUtility/getCompanyListWithUser').success(function(datas) {
                $scope.creditnoteAcctData.companyCode = datas.commonUtilityBean[0].value;
                $scope.creditnoteAcctData.company = datas.commonUtilityBean[0].description;
            }).error(function(data) {
            });
            
            /*$http.get('app/commonUtility/getCustomerList').success(function(datas) {
                var custList = [];
                angular.forEach(datas.commonUtilityBean, function (item, key) {
                    var cusObj = new Object();
                    cusObj.id = datas.commonUtilityBean[key].value;
                    cusObj.text = datas.commonUtilityBean[key].text;
                    custList.push(cusObj);
                });      
                $scope.acctHeadList = custList;
            }).error(function(data) {
            });*/

           
            $http.get($stateParams.tenantid+'/app/commonUtility/getCrDtlAccountHeadDataNew').success(function(datas) {
                if(datas.commonUtilityBean.length>0){
                    var acctHeadList = [];
                    angular.forEach(datas.commonUtilityBean, function (item, key) {
                        var accHdObj = new Object();
                        accHdObj.id = datas.commonUtilityBean[key].accountHeadCode;
                        accHdObj.text = datas.commonUtilityBean[key].accountHeadName;
                        acctHeadList.push(accHdObj);
                    });
                    $scope.crdtlAcctHeadList = acctHeadList;
                }
            }).error(function(data) {
            });
            
            //sub account code --- Eg: customer, supplier will load in this dropdown
            $http.get($stateParams.tenantid+'/app/commonUtility/getSubAccountCodeLists').success(function(datas) {
                if(datas.commonUtilityBean.length>0){

                var subAcctList = [];
                angular.forEach(datas.commonUtilityBean, function (item, key) {
                    var subAccHdObj = new Object();
                    subAccHdObj.id = datas.commonUtilityBean[key].subaccountcode;
                    subAccHdObj.text = datas.commonUtilityBean[key].subaccountname;
                    subAcctList.push(subAccHdObj);
                }); 
                $scope.dtlSubAcctList = subAcctList;
                $scope.acctHeadList = subAcctList;
                }
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
            
            
            //Attributes Dropdown
            
            $http.get($stateParams.tenantid+'/app/commonUtility/getEmployeeList').success(function(datas) {
                $scope.employeeList = datas;
                }).error(function(datas) {
            });          
            
            
            $http.get($stateParams.tenantid+'/app/commonUtility/getDepartmentList').success(function(datas) {
                $scope.departmentList = datas;
                }).error(function(datas) {
            });
            
              
            $http.get($stateParams.tenantid+'/app/commonUtility/getCountryList').success(function(datas) {
                $scope.countryList = datas;
                }).error(function(datas) {
            });
            $http.get($stateParams.tenantid+'/app/commonUtility/getSupplierList').success(function(datas) {
                $scope.supplierList = datas;
                }).error(function(datas) {
            });
            $http.get($stateParams.tenantid+'/app/commonUtility/getCustomerAttributeList').success(function(datas) {
                $scope.customerList = datas;
                }).error(function(datas) {
            });
            
            $http.get($stateParams.tenantid+'/app/commonUtility/getDesignationList').success(function(datas) {
                $scope.designationList = datas;
                }).error(function(datas) {
            });          
          
            
            $http.get($stateParams.tenantid+'/app/commonUtility/getstudentList').success(function(datas) {
                $scope.studentList = datas;
            }).error(function(datas) {
            });

            
            $http.get($stateParams.tenantid+'/app/commonUtility/getCostCenter').success(function(datas) {
                 $scope.costCenterList = datas;
                }).error(function(datas) {
            });          
            
               
            $http.get('app/purchaseinvoice/getCompanyList').success(function(datas) {
                $scope.companyList = datas;
                }).error(function(datas) {
            });
            $http.get($stateParams.tenantid+'/app/commonUtility/getPatientList').success(function(datas) {
                $scope.patientList = datas;
                }).error(function(datas) {
            });
        }
        $scope.getDropdownValue();
        
        
        /**
         * Fetching Invoice Dropdown with AcctHead Code *****************************************************************
         */

        $scope.$watch('creditnoteAcctData.accountName', function(newValue, oldValue) {
            if (newValue != '' && newValue != undefined) {
                $http.get('app/creditNote/getInvoiceNo?acctHeadCode='+newValue).success(function(datas) {
                    
                    if(datas.length>0){
                        $scope.invoiceNoList = datas;
                    }else{
                        $scope.invoiceNoList = [];
                        $scope.creditnoteAcctData.invoiceDate = "";
                        $scope.creditnoteAcctData.currencyCode = "";
                        $scope.creditnoteAcctData.exchangeRate = "";
                    }
                }).error(function(data) {
                });
            }else{
                $scope.invoiceNoList = [];
                $scope.creditnoteAcctData.invoiceDate = "";
                $scope.creditnoteAcctData.currencyCode = "";
                $scope.creditnoteAcctData.exchangeRate = "";
            }
       });

        /**
         * fetch invoice date, currency code, exchange rate from invoice No  ***********************************************
         */

        $scope.$watch('creditnoteAcctData.invoiceNo', function(newValue, oldValue) {
            var invList =  $scope.invoiceNoList;
            if (newValue != '' && newValue != undefined) {
                angular.forEach(invList, function (item, key) {
                    if(newValue==invList[key].invoiceNo){
                        $scope.creditnoteAcctData.invoiceDate = invList[key].invoiceDate;
                        $scope.creditnoteAcctData.currencyCode = invList[key].currencyCode;
                        $scope.creditnoteAcctData.exchangeRate = invList[key].exgRate;
                    }
                 });

            }else{
                $scope.creditnoteAcctData.invoiceDate = "";
                $scope.creditnoteAcctData.currencyCode = "";
                $scope.creditnoteAcctData.exchangeRate = "";
            }
       });
        $scope.getInvoiceNo= function(accountName){
            if (accountName != '' && accountName != undefined) {
                $http.get('app/creditNote/getInvoiceNo?acctHeadCode='+accountName).success(function(datas) {
                    if(datas.length>0){
                        $scope.invoiceNoList = datas;
                    }else{
                        $scope.invoiceNoList =[];
                        $scope.creditnoteAcctData.invoiceDate = "";
                        $scope.creditnoteAcctData.currencyCode = "";
                        $scope.creditnoteAcctData.exchangeRate = "";
                    }
                }).error(function(data) {
                });
            }else{
                $scope.invoiceNoList = [];
                $scope.creditnoteAcctData.invoiceDate = "";
                $scope.creditnoteAcctData.currencyCode = "";
                $scope.creditnoteAcctData.exchangeRate = "";
            }
        }
        $scope.fetchInvoiceDetails = function(invoiceNo,invoiceNoList){
            if (invoiceNo != '' && invoiceNo != undefined) {
                angular.forEach(invoiceNoList, function (item, key) {
                    if(invoiceNo==invoiceNoList[key].invoiceNo){
                        $scope.creditnoteAcctData.invoiceDate = invoiceNoList[key].invoiceDate;
                        $scope.creditnoteAcctData.currencyCode = invoiceNoList[key].currencyCode;
                        $scope.creditnoteAcctData.exchangeRate = invoiceNoList[key].exgRate;
                    }
                 });

            }else{
                $scope.creditnoteAcctData.invoiceDate = "";
                $scope.creditnoteAcctData.currencyCode = "";
                $scope.creditnoteAcctData.exchangeRate = "";
            }
        }
        
        
        $scope.amountBCtoTCcalculation= function(bcamount,index,row){
            
            row.bcamount =parseFloat(bcamount);
            if($scope.creditnoteAcctData.exchangeRate!=0 && $scope.creditnoteAcctData.exchangeRate!=""){
                row.tcamount = parseFloat(bcamount) / $scope.creditnoteAcctData.exchangeRate;
                $scope.totalAmountCalculation();
            }
            else{
                row.tcamount = 0;
                $scope.totalAmountCalculation();
            }

        }
        $scope.amountTCtoBCcalculation= function(tcamount,index,row){          
            row.tcamount =parseFloat(tcamount);
            if($scope.creditnoteAcctData.exchangeRate!=0 && $scope.creditnoteAcctData.exchangeRate!=""){
                row.bcamount = parseFloat(tcamount) * $scope.creditnoteAcctData.exchangeRate;
                $scope.totalAmountCalculation();
            }
            else{
                row.bcamount = 0;
                $scope.totalAmountCalculation();
            }
        }
        
        /**
         * total Amount Calculation - calculate from credit note detail table..
         */
        $scope.totalAmountCalculation = function(){
            
            var crDtlRowDatas = $scope.creditnoteAcctData.credittables;
            var bcAmt=0,tcAmt=0;
            angular.forEach(crDtlRowDatas, function (item, key) {
                bcAmt += parseFloat(crDtlRowDatas[key].bcamount);
                tcAmt += parseFloat(crDtlRowDatas[key].tcamount);
                $scope.creditnoteDtlTotalAmt.totalBCAmount=bcAmt;
                $scope.creditnoteDtlTotalAmt.totalTCAmount=tcAmt;               
             });
        }
        /**
         * load Credit Note Detail Table ******************************************
         */
        $scope.loadCrTable = function() {
              var crtable = {};
              crtable = {
                  select : '',  slNo:1, crdtlAccountHead : '', subAcctCode : '',  cbpdtlpaymentreceipt:'',narration : '', bcamount : '',
                  tcamount : '',       
                  
                  employeeCode :'', departmentCode :'', countryCode :'', customerCode:'', supplierCode:'',                  
                  designationCode:'', costCenter :'', companyCode:'', patientCode : '',
                  
                  isEmployee:false, isDepartment:false, isLocation:false, isCustomer:false, isSupplier:false,
                  isDesignation:false, isCostCenter:false, isCompany:false, isPatient: false,attributeList :[]
                      
              };
              $scope.creditnoteAcctData.credittables.push(crtable);
          }
          //add Row - detail table
          $scope.addCredRow = function(tables) {
            var len = tables.length;
            var table = {
                select : '',  slNo:1, crdtlAccountHead : '', subAcctCode : '', narration : '', bcamount : '', tcamount : '',  cbpdtlpaymentreceipt:'',
               
                employeeCode :'', departmentCode :'', countryCode :'', customerCode:'', supplierCode:'',
                designationCode:'', costCenter :'', companyCode:'', patientCode : '',
                
                isEmployee:false, isDepartment:false, isLocation:false, isCustomer:false, isSupplier:false,
                isDesignation:false, isCostCenter:false, isCompany:false, isPatient: false,attributeList :[]
            };
            table.slNo = len+1;
            tables.push(table);
          };
          $scope.loadCrTable();

          //remove Row - detail table
          $scope.removeCredRow = function(table) {
              $scope.tablerow = [];
              angular.forEach(table, function(row, index) {
                  var check = row.select;
                  if (check == undefined || check == "") {
                      $scope.tablerow.push(row);
                  } else {
                  }
              });
              angular.forEach($scope.tablerow,function(row,index){              
                 row.slNo=index+1;             
              });
              $scope.creditnoteAcctData.credittables = $scope.tablerow;
              $scope.totalAmountCalculation();
          };

         
        
        $scope.submit = function() {

            if($scope.creditnoteAcctData.creditNoteDate != ""){
            if($scope.creditnoteAcctData.accountName != ""){
                if($scope.creditnoteAcctData.invoiceNo != ""){
                        $scope.save();
                    } else
                        logger.logError("Please Select Invoice");
                } else
                    logger.logError("Please Select Account");
            }else
                logger.logError("Please Select Credit Date");

        };

       
        $scope.save = function(creditNoteForm,creditnoteAcctData) {
            var creditnoteMasterData = $scope.creditnoteAcctData;
            var isBcAmount = $scope.checkBCAmount();
            var isCrDtlRows = $scope.checkDtlTblRows();
            
            if(isCrDtlRows){
                if(isBcAmount){
                    if($scope.edit==false){
                        angular.forEach($scope.creditnoteAcctData.credittables, function(key,index){
                            
                            delete key['isEmployee'];
                            delete key['isDepartment'];
                            delete key['isLocation'];
                            delete key['isCustomer'];
                            delete key['isSupplier'];
                            delete key['isDesignation'];
                            delete key['isCostCenter'];
                            delete key['isPatient'];
                            delete key['isCompany'];
                            delete key['attributeList'];
                        });      
                        $http.post('app/creditNote/save', $scope.creditnoteAcctData).success(function(result) {
                            if(result) {
                                logger.logSuccess("Saved Successfully!");
                                $location.path($stateParams.tenantid+'/hospital/accounts/creditNote/list');
                            } else {
                                logger.logError("Credit Note Code Already Exist!");
                            }
                        }).error(function(result) {
                        });
                    }else{
                        angular.forEach($scope.creditnoteAcctData.credittables, function(key,index){
                            
                            delete key['isEmployee'];
                            delete key['isDepartment'];
                            delete key['isLocation'];
                            delete key['isCustomer'];
                            delete key['isSupplier'];
                            delete key['isDesignation'];
                            delete key['isCostCenter'];
                            delete key['isPatient'];
                            delete key['isCompany'];
                            delete key['attributeList'];
                        });      
                        $http.post('app/creditNote/update', $scope.creditnoteAcctData).success(function(result) {
                            if(result) {
                                logger.logSuccess("Updated Successfully!");
                                $location.path($stateParams.tenantid+'/hospital/accounts/creditNote/list');
                            } else {
                                logger.logError("Credit Note Code Already Exist!");
                            }
                        }).error(function(result) {
                        });
                    }
                }else{
                    logger.logError("Please Enter  Amount!");
                }
            }else{
                logger.logError("Please Add Atleast One Row!");
            }
           
            

        };
        
        /***
         * Edit Functionality *******************************
         */
            $scope.fetchEditData= function(){
                var creditNoteCode = $stateParams.creditNoteCode;
                
                if(creditNoteCode == undefined || creditNoteCode == null || creditNoteCode ==""){
                }else{
                    $scope.edit =true;
                        $http.get('app/creditNote/getCreditNoteForEdit?creditCode='+creditNoteCode).success(function(data) {
                            $scope.creditnoteAcctData = data;
                            
                            
                            $scope.totalAmountCalculation();
                        }).error(function(data) {
                        });     
                }    
            }
            $scope.fetchEditData();
        
        $scope.cancel = function() {
            $state.go("app.finance.accounts.creditNote.list");
        };  
        
        /**
         * Reset Functionality ******************************
         */
        var originalCNAcctDatas = angular.copy($scope.creditnoteAcctData);
        var originalCNAcctTotal = angular.copy($scope.creditnoteDtlTotalAmt);
        
        $scope.reset = function(creditNoteForm,creditnoteAcctData){
            if($scope.edit==false){
                $scope.creditnoteAcctData = angular.copy(originalCNAcctDatas);
                $scope.creditnoteDtlTotalAmt = angular.copy(originalCNAcctTotal);
                $scope.creditNoteForm.$setPristine();
            }else{
                $scope.fetchEditData();
            }
        }
        
        $scope.isEditChanged = function (){
            return !angular.equals($scope.creditnoteAcctData, originalCNAcctDatas);
        };
    });

    app.controller('creditNoteApprovalCtrl', function($scope, $state, $http, $location, sharedProperties,
            toaster,$injector,logger,$stateParams, $timeout,validationService) {
        $scope.creditnoteAcctData = {
                accountName : '',  invoiceNo : '', invoiceDate :'', currencyCode : '', exchangeRate: '', 
                creditNoteDate: '', companyCode : '',company :'', narration: '',credittables: []
        };
        $scope.creditnoteDtlTotalAmt={
                totalBCAmount:'',totalTCAmount :''
        }
        $scope.getDropdownValue = function(){
            
            
            $http.get($stateParams.tenantid+'/app/commonUtility/getCompanyListWithUser').success(function(datas) {
                $scope.creditnoteAcctData.companyCode = datas.commonUtilityBean[0].value;      
                $scope.creditnoteAcctData.company = datas.commonUtilityBean[0].description;
                
            }).error(function(data) {
            });
            
            $http.get($stateParams.tenantid+'/app/commonUtility/getCustomerList').success(function(datas) {
              
                var custList = [];
                angular.forEach(datas.commonUtilityBean, function (item, key) {
                    var cusObj = new Object();
                    cusObj.id = datas.commonUtilityBean[key].value;
                    cusObj.text = datas.commonUtilityBean[key].text;
                    custList.push(cusObj);
                });      
                $scope.acctHeadList = custList;
            }).error(function(data) {
            });

           
            $http.get($stateParams.tenantid+'/app/commonUtility/getCrDtlAccountHeadData').success(function(datas) {
                
                if(datas.commonUtilityBean.length>0){
                    var acctHeadList = [];
                    angular.forEach(datas.commonUtilityBean, function (item, key) {
                        var accHdObj = new Object();
                        accHdObj.id = datas.commonUtilityBean[key].accountHeadCode;
                        accHdObj.text = datas.commonUtilityBean[key].accountHeadName;
                        acctHeadList.push(accHdObj);
                    });      
                    $scope.crdtlAcctHeadList = acctHeadList;
                }
            }).error(function(data) {
            }); 
            
            //sub account code --- Eg: customer, supplier will load in this dropdown
            $http.get($stateParams.tenantid+'/app/commonUtility/getSubAccountCodeLists').success(function(datas) {
                
                var subAcctList = [];
                angular.forEach(datas.commonUtilityBean, function (item, key) {
                    var subAccHdObj = new Object();
                    subAccHdObj.id = datas.commonUtilityBean[key].subaccountcode;
                    subAccHdObj.text = datas.commonUtilityBean[key].subaccountname;
                    subAcctList.push(subAccHdObj);
                }); 
                $scope.dtlSubAcctList = subAcctList;
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
            
            
            //Attributes Dropdown
            
            $http.get($stateParams.tenantid+'/app/commonUtility/getEmployeeList').success(function(datas) {
                $scope.employeeList = datas;
                }).error(function(datas) {
            });          
            
            
            $http.get($stateParams.tenantid+'/app/commonUtility/getDepartmentList').success(function(datas) {
                $scope.departmentList = datas;
                }).error(function(datas) {
            });
            
              
            $http.get($stateParams.tenantid+'/app/commonUtility/getCountryList').success(function(datas) {
                $scope.countryList = datas;
                }).error(function(datas) {
            });
            $http.get($stateParams.tenantid+'/app/commonUtility/getSupplierList').success(function(datas) {
                $scope.supplierList = datas;
                }).error(function(datas) {
            });
            $http.get($stateParams.tenantid+'/app/commonUtility/getCustomerAttributeList').success(function(datas) {
                $scope.customerList = datas;
                }).error(function(datas) {
            });
            
            $http.get($stateParams.tenantid+'/app/commonUtility/getDesignationList').success(function(datas) {
                $scope.designationList = datas;
                }).error(function(datas) {
            });          
            
               
            $http.get('app/purchaseinvoice/getCompanyList').success(function(datas) {
                $scope.companyList = datas;
                }).error(function(datas) {
            });
            $http.get($stateParams.tenantid+'/app/commonUtility/getPatientList').success(function(datas) {
                $scope.patientList = datas;
                }).error(function(datas) {
            });
        }
        $scope.getDropdownValue();
        
        
        /**
         * Fetching Invoice Dropdown with AcctHead Code *****************************************************************
         */

        $scope.$watch('creditnoteAcctData.accountName', function(newValue, oldValue) {
            if (newValue != '' && newValue != undefined) {
                $http.get('app/creditNote/getInvoiceNo?acctHeadCode='+newValue).success(function(datas) {
                    if(datas.length>0){
                        $scope.invoiceNoList = datas;
                    }else{
                        $scope.creditnoteAcctData.invoiceDate = "";
                        $scope.creditnoteAcctData.currencyCode = "";
                        $scope.creditnoteAcctData.exchangeRate = "";
                    }
                }).error(function(data) {
                });
            }else{
                $scope.invoiceNoList = [];
                $scope.creditnoteAcctData.invoiceDate = "";
                $scope.creditnoteAcctData.currencyCode = "";
                $scope.creditnoteAcctData.exchangeRate = "";
            }
       });

        /**
         * fetch invoice date, currency code, exchange rate from invoice No  ***********************************************
         */

        $scope.$watch('creditnoteAcctData.invoiceNo', function(newValue, oldValue) {
            
            var invList =  $scope.invoiceNoList;
            if (newValue != '' && newValue != undefined) {
                angular.forEach(invList, function (item, key) {
                    if(newValue==invList[key].invoiceNo){
                        $scope.creditnoteAcctData.invoiceDate = invList[key].invoiceDate;
                        $scope.creditnoteAcctData.currencyCode = invList[key].currencyCode;
                        $scope.creditnoteAcctData.exchangeRate = invList[key].exgRate;
                    }
                 });

            }else{
                $scope.creditnoteAcctData.invoiceDate = "";
                $scope.creditnoteAcctData.currencyCode = "";
                $scope.creditnoteAcctData.exchangeRate = "";
            }
       });
        /***
         * Edit Functionality *******************************
         */
        var creditNoteCode = $stateParams.creditNoteCode;
        
        if(creditNoteCode == undefined || creditNoteCode == null || creditNoteCode ==""){
        }else{
            $scope.edit =true;
            $timeout(function() {
                $http.get('app/creditNote/getCreditNoteForEdit?creditCode='+creditNoteCode).success(function(data) {
                    $scope.creditnoteAcctData = data;
                    
                    $scope.totalAmountCalculation();
                }).error(function(data) {
                });              
            }, 2,false);
        }
        
        
        /**
         * total Amount Calculation - calculate from credit note detail table..
         */
        $scope.totalAmountCalculation = function(){
            var crDtlRowDatas = $scope.creditnoteAcctData.credittables;
            var bcAmt=0,tcAmt=0;
            angular.forEach(crDtlRowDatas, function (item, key) {
                bcAmt += parseFloat(crDtlRowDatas[key].bcamount);
                tcAmt += parseFloat(crDtlRowDatas[key].tcamount);
                $scope.creditnoteDtlTotalAmt.totalBCAmount=bcAmt;
                $scope.creditnoteDtlTotalAmt.totalTCAmount=tcAmt;               
             });
        }
        
        $scope.cancel = function() {
            $state.go("app.finance.accounts.creditNote.list");
        };
        
    });
    app.controller('tableCtrl', function($scope,$http, $filter,logger, $stateParams){
    	
    	
    	
    	  $http.get("app/cashbankPayment/paymentreceiptList").success(function(datas) {
              $scope.paymentList = datas;
          });
       

    	
        $scope.$watch('creditnoteAcctData.credittables[trIndex].crdtlAccountHead', function(newValue, oldValue) {
            if (newValue != '' && newValue != undefined) {
                    $http.get($stateParams.tenantid+'/app/commonUtility/getAttributesList?accountCode='+newValue).success(function(datas) {
                    $scope.creditnoteAcctData.credittables[$scope.$index].attributeList=datas;
                    if(newValue==oldValue){
                        $scope.isOnChange =false;
                    }else{
                        $scope.isOnChange =true;
                    }
                    if(!$scope.edit || $scope.isOnChange){
                        
                        $scope.creditnoteAcctData.credittables[$scope.$index].employeeCode='';
                        $scope.creditnoteAcctData.credittables[$scope.$index].departmentCode='';                        
                        $scope.creditnoteAcctData.credittables[$scope.$index].countryCode='';
                        $scope.creditnoteAcctData.credittables[$scope.$index].customerCode='';
                        $scope.creditnoteAcctData.credittables[$scope.$index].supplierCode='';
                        $scope.creditnoteAcctData.credittables[$scope.$index].designationCode='';
                        $scope.creditnoteAcctData.credittables[$scope.$index].costCenter='';
                        $scope.creditnoteAcctData.credittables[$scope.$index].companyCode='';
                        $scope.creditnoteAcctData.credittables[$scope.$index].patientCode='';
                    }
                    
                    
                    $scope.creditnoteAcctData.credittables[$scope.$index].isEmployee=false;
                    
                    $scope.creditnoteAcctData.credittables[$scope.$index].isDepartment=false;
                    
                    $scope.creditnoteAcctData.credittables[$scope.$index].isLocation=false;
                    $scope.creditnoteAcctData.credittables[$scope.$index].isCustomer=false;
                    $scope.creditnoteAcctData.credittables[$scope.$index].isSupplier=false;
                    $scope.creditnoteAcctData.credittables[$scope.$index].isDesignation=false;
                    $scope.creditnoteAcctData.credittables[$scope.$index].isCostCenter=false;
                    $scope.creditnoteAcctData.credittables[$scope.$index].isCompany=false;
                    
                    $scope.creditnoteAcctData.credittables[$scope.$index].isPatient=false;
                 
                    angular.forEach($scope.creditnoteAcctData.credittables[$scope.$index].attributeList, function(row, rowindex) {
                        if(row.attributeName == "Employee"){
                            $scope.creditnoteAcctData.credittables[$scope.$index].isEmployee=true;
                        }else if(row.attributeName == "Students"){
                            $scope.creditnoteAcctData.credittables[$scope.$index].isDepartment=true;
                        }else if(row.attributeName == "Location"){
                            $scope.creditnoteAcctData.credittables[$scope.$index].isLocation=true;
                        }else if(row.attributeName == "Customer"){
                            $scope.creditnoteAcctData.credittables[$scope.$index].isCustomer=true;
                        }else if(row.attributeName == "Supplier"){
                            $scope.creditnoteAcctData.credittables[$scope.$index].isSupplier=true;
                        }else if(row.attributeName == "Designation"){
                            $scope.creditnoteAcctData.credittables[$scope.$index].isDesignation=true;
                        }else if(row.attributeName == "Cost Center"){
                            $scope.creditnoteAcctData.credittables[$scope.$index].isCostCenter=true;
                        }else if(row.attributeName == "Company"){
                            $scope.creditnoteAcctData.credittables[$scope.$index].isCompany=true;
                        }else if(row.attributeName == "Patient"){
                            $scope.creditnoteAcctData.credittables[$scope.$index].isPatient=true;
                        }
                      });
                    }).error(function(datas) {
                });
                 
            }
        });
        $scope.$watch('creditnoteAcctData.credittables[trIndex].subAcctCode', function(newValue, oldValue) {
            if (newValue != '' && newValue != undefined) {
                $scope.creditnoteAcctData.credittables[$scope.$index].subAcctCode=newValue;
            }
           
        });
    //});
});