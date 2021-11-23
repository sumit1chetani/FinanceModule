//define([ 'hospital/accounts/accounts' ], function(module) {

    'use strict';

    app.controller
                (
                'openBalanceUploadAddCtrl',
                function($scope, $rootScope, ngDialog, $http, $location,
                        logger, utilsService, $state, sharedProperties,
                        $window, validationService, toaster, $stateParams) {
                    $scope.dataLoopCount = 0;
                    $scope.offsetCount = 0;
                    $scope.limitCount = 1000;
                    $scope.updatedData = [];
                    $scope.rowCollection = [];
                    $scope.displayedCollection = [];
                    $scope.itemsByPage = 10;
                    $scope.currency=[];
                     $scope.isEdit = false;
                     $scope.cbpdtlAcctHeadList = [];
                        $scope.subAccountCodeList = [];

                    $scope.openingBalance = {
                        invoiceNo : '',
                        transactionid:'',
                        invoiceDate : '',
                        tcAmount : '',
                        bcAmount : '',
                        oldCutomerCode : '',
                        companyId :'',
                        mloCode : '',
                        customer : '',
                        currency : 'INR',
                        exchangeRate : 1,
                        companyId : 'C0002',
                        sundryStatus : 'C',
                        finYear :'2020-2021',

                    };
                    $scope.list=function()
                    {
                          $http.get('app/finance/openingBalance/drop').success(function(data) {
                      //    $scope.currencyList=data.currecncyList;
                          //$scope.companyList=data.companyList;
                          $scope.customerList=data.customerList;
                        
                          
                          });
                    }
                    
                    

                    $scope.pmtTypeList = [
                        {
                            id : '2020-2021',
                            text : '2020-2021'
                        },
                        {
                        id : '2021-2022',
                        text : '2021-2022'
                    }, {
                        id : '2022-2023',
                        text : '2022-2023'
                    } ]
                    
                    
                    
                    
                    
                    //UPLOAD
                    
                    $scope.uploadContainerExcel = function(element) {
                        debugger
                        console.log("excel file");
                        $scope.excelfile = element.files[0];
                        console.log($scope.excelfile);

                    }
                    $scope.uploadContainer = function() {
                       
                        // loader.start();
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
                                    url : "/app/finance/openingBalance/uploadEmployeeExcel",
                                    data : frmData,
                                    contentType : false,
                                    processData : false,
                                    success : function(response) {
                                      //  loader.complete();
                                        if (response.success == true) {
                                            $scope.closeUpload();
                                            $scope.openingBalance = response.openingBalance;
                                          
                                            //$('#purchaseFor').val(response.purchaseQuotation.purchaseFor) ;
                                          //  $scope.purchaseQuotation.purchaseFor= response.purchaseQuotation.purchaseFor.toString();
                                            //$scope.purchaseQuotation = response.purchaseQuotation;
                                          //  $scope.rowCollection1 = response.purchaseQuotation.quotationDetailList;
                                            logger.logSuccess(response.message);
                                          
                                            //$scope.purchaseQuotation.purchaseFor= response.purchaseQuotation.purchaseFor.toString();
                                          //  $scope.purchaseQuotation.requisitionNo= response.purchaseQuotation.requisitionNo.toString();

                                        } else if (response.success == false) {
                                            $scope.error=true;
                                            logger.logError("Error in Upload");
                                            $scope.rowCollection1 = response.errors;
                                            for (var i = 0; i < response.errors.length; i++) {
                                                logger.logError(response.errors[i]);
                                                $scope.closeUpload();
                                            }
                                        } else if (response.errorList.length > 0) {

                                        } else {
                                            logger.logError("Sorry Error Occured");
                                            $scope.closeUpload();
                                            $scope.getMemberList();
                                        }
                                    }
                                });
                            }
                        }
                    }
                    $scope.downloadFile = function() {
                        $("#sampleDownload").bind('click', function() {
                        });
                        $('#sampleDownload').simulateClick('click');
                    }

                    $.fn.simulateClick = function() {
                        return this.each(function() {
                            if ('createEvent' in document) {
                                var doc = this.ownerDocument, evt = doc
                                        .createEvent('MouseEvents');
                                evt.initMouseEvent('click', true, true,
                                        doc.defaultView, 1, 0, 0, 0, 0, false,
                                        false, false, false, 0, null);
                                this.dispatchEvent(evt);
                            } else {
                                this.click();
                            }
                        });
                        
                        
                    }
                    
                     $scope.closeUpload=function(){
                            ngDialog.close();
                        }
                    
                    $scope.fileUpload =function(){
                        ngDialog.open({
                               template : 'fileGenModal',
                               scope :$scope
                           });
                       } 
                   
                    $http.get($stateParams.tenantid +'/app/commonUtility/getCompanyList').success(function(datas) {
                        $scope.companyList = datas;
                    }).error(function(datas) {
                    });
                    $http.get('app/generalinvoice/getAccountHeadList')
                            .success(function(datas) {  
                                $scope.cbpdtlAcctHeadList = datas;
                            }).error(function(datas) {
                                $scope.cbpdtlAcctHeadList = [];
                            });
                    $scope.list();
                    var temp='';
                     $scope.cancel = function() {
                         $state.go('app.finance.accounts.openBalanceUpload.list');
                      //    $state.go('app.finance.transaction.openBalanceUpload.list',{tenantid:$stateParams.tenantid});
                          
                             
                        };
                        var id=$location.search().transactionid;
                        if(id!=null && id!=undefined && id>0){
                            $scope.isEdit=true;
                            
                            $http.get('app/finance/openingBalance/edit?transactionid='+id).success(function(data) {
                                $scope.openingBalance.bcAmount=data.bean.bcAmount;
                                $scope.openingBalance.tcAmount=data.bean.tcAmount;
                                $scope.openingBalance.invoiceNo=data.bean.invoiceNo;
                                $scope.openingBalance.invoiceDate=data.bean.invoiceDate;
                                $scope.openingBalance.mloCode=data.bean.mloCode;
                                if(data.bean.accountHead!=''&&data.bean.accountHead!=null)
                                {
                                $scope.openingBalance.accountHead=data.bean.accountHead.toString();
                                
                                }
                                //$scope.openingBalance.currency=data.bean.currency;
                                $scope.openingBalance.exchangeRate=data.bean.exchangeRate;
                                //$scope.openingBalance.company=data.bean.companyName;
                                $scope.openingBalance.sundryStatus=data.bean.sundryStatus;
                                
                                if(data.bean.customer!=''&&data.bean.customer!=null)
                                {
                                    $scope.openingBalance.customer = data.bean.customer.toString();
                                }
                                if(data.bean.currency!=''&&data.bean.currency!=null)
                                {
                                    $scope.openingBalance.currency = data.bean.currency.toString();
                                }
                                if(data.bean.companyId!=''&& data.bean.companyId!=null)
                                {
                                    temp= data.bean.companyId.toString();
                                    $scope.openingBalance.companyId = data.bean.companyId.toString();
                                }
                                $scope.list();
                            });
                        }
                        $scope.save = function(openingBalanceForm){
                            if(($scope.openingBalance.accountHead =='10050016' || $scope.openingBalance.accountHead =='20090001') &&  ($scope.openingBalance.customer=="" || $scope.openingBalance.customer==undefined)){
                                logger.logError("Please Select the Customer/Vendor");
                            }
                            else{
                            
                            if (new validationService().checkFormValidity(openingBalanceForm)) {
                                var flag1 = true, flag2 = true, flag3 = true, flag4 = true, flag5 = true;
                                
                                    if($scope.openingBalance.invoiceNo=="" || $scope.openingBalance.invoiceNo==undefined)
                                    {
                                        $scope.openingBalance.invoiceNo=null
                                    }
                                    if($scope.openingBalance.invoiceDate=="" || $scope.openingBalance.invoiceDate==undefined)
                                    {
                                        $scope.openingBalance.invoiceDate=null
                                    }
                                    if($scope.openingBalance.tcAmount=="" || $scope.openingBalance.tcAmount==undefined)
                                    {
                                        $scope.openingBalance.tcAmount=null
                                    }
                                    if($scope.openingBalance.bcAmount=="" || $scope.openingBalance.bcAmount==undefined)
                                    {
                                        $scope.openingBalance.bcAmount=null
                                    }
                                    if($scope.openingBalance.mloCode=="" || $scope.openingBalance.mloCode==undefined)
                                    {
                                        $scope.openingBalance.mloCode=null
                                    }
                                    if($scope.openingBalance.customer=="" || $scope.openingBalance.customer==undefined)
                                    {
                                        $scope.openingBalance.customer=null
                                    }
                                    if($scope.openingBalance.currency=="" || $scope.openingBalance.currency==undefined)
                                    {
                                        $scope.openingBalance.currency=null
                                    }
                                    if($scope.openingBalance.exchangeRate=="" || $scope.openingBalance.exchangeRate==undefined)
                                    {
                                        $scope.openingBalance.exchangeRate=null
                                    }
                                    if($scope.openingBalance.company=="" || $scope.openingBalance.company==undefined)
                                    {
                                        $scope.openingBalance.company=null
                                    }
                                    if($scope.openingBalance.sundryStatus=="" || $scope.openingBalance.sundryStatus==undefined)
                                    {
                                        $scope.openingBalance.sundryStatus=null
                                    }
                                    
                                   

                                if (flag1 == true && flag2 == true && flag2 == true && flag3 == true && flag4 == true && flag5 == true) {
                                    $http.post('app/finance/openingBalance/save',$scope.openingBalance).success(function(data) {
                                        if(data.success){
                                            logger.logSuccess('Saved Successfully');
                                            $state.go('app.finance.accounts.openBalanceUpload.list');
                                            //$location.url($stateParams.tenantid+'/hbl/edit?rowid='+data.id);       

                                        //  $scope.cancel();
                                        }else{
                                            logger.logError('Unable to save!');
                                        }
                                        
                                    });
                             
                                }
                                else {
                                    if (flag1 == false) {
                                        logger.logError("Please Enter Number Value for No Of Package in Container Details");
                                    }
                                    if (flag2 == false) {
                                        logger.logError("Please Enter Number Value for UOM in Container Details");
                                    }
                                    if (flag3 == false) {
                                        logger.logError("Please Enter Number Value for NetWeight in Container Details");
                                    }
                                    if (flag4 == false) {
                                        logger.logError("Please Enter Number Value for GrossWeight in Container Details");
                                    }
                                    if (flag5 == false) {
                                        logger.logError("Please Enter Number Value for Amount in Freight Details");
                                    }
                                    if (flag6 == false) {
                                        logger.logError("Please Enter Number Value for Amount in Freight Details");
                                    }
                                    if (flag7 == false) {
                                        logger.logError("Please Enter Number Value for Amount in Freight Details");
                                    }
                                    if (flag8 == false) {
                                        logger.logError("Please Enter Number Value for Amount in Freight Details");
                                    }
                                    if (flag9 == false) {
                                        logger.logError("Please Enter Number Value for Amount in Freight Details");
                                    }
                                  
                                }
                            
                               
                        }
                       
                             else {
                                    toaster.pop('error', "Please fill the required fields", 
                                            logger.getErrorHtmlNew(openingBalanceForm.$validationSummary), 5000, 'trustedHtml');
                             }  }
                        }
                        
                        $scope.update = function(openingBalanceForm){
                            if (new validationService().checkFormValidity(openingBalanceForm)) {
                                var flag1 = true, flag2 = true, flag3 = true, flag4 = true, flag5 = true;
                                
                                    if($scope.openingBalance.invoiceNo=="" || $scope.openingBalance.invoiceNo==undefined)
                                    {
                                        $scope.openingBalance.invoiceNo=null
                                    }
                                    if($scope.openingBalance.invoiceDate=="" || $scope.openingBalance.invoiceDate==undefined)
                                    {
                                        $scope.openingBalance.invoiceDate=null
                                    }
                                    if($scope.openingBalance.tcAmount=="" || $scope.openingBalance.tcAmount==undefined)
                                    {
                                        $scope.openingBalance.tcAmount=null
                                    }
                                    if($scope.openingBalance.bcAmount=="" || $scope.openingBalance.bcAmount==undefined)
                                    {
                                        $scope.openingBalance.bcAmount=null
                                    }
                                    if($scope.openingBalance.mloCode=="" || $scope.openingBalance.mloCode==undefined)
                                    {
                                        $scope.openingBalance.mloCode=null
                                    }
                                    if($scope.openingBalance.customer=="" || $scope.openingBalance.customer==undefined)
                                    {
                                        $scope.openingBalance.customer=null
                                    }
                                    if($scope.openingBalance.currency=="" || $scope.openingBalance.currency==undefined)
                                    {
                                        $scope.openingBalance.currency=null
                                    }
                                    if($scope.openingBalance.exchangeRate=="" || $scope.openingBalance.exchangeRate==undefined)
                                    {
                                        $scope.openingBalance.exchangeRate=null
                                    }
                                    if($scope.openingBalance.company=="" || $scope.openingBalance.company==undefined)
                                    {
                                        $scope.openingBalance.company=null
                                    }
                                    if($scope.openingBalance.sundryStatus=="" || $scope.openingBalance.sundryStatus==undefined)
                                    {
                                        $scope.openingBalance.sundryStatus=null
                                    }
                                    $scope.openingBalance.transactionid=$location.search().transactionid;
                                if (flag1 == true && flag2 == true && flag2 == true && flag3 == true && flag4 == true && flag5 == true) {
                                    $http.post('/app/finance/openingBalance/update',$scope.openingBalance).success(function(data) {
                                        if(data.success){
                                            logger.logSuccess('Updated Successfully');
                                            $state.go('app.finance.accounts.openBalanceUpload.list');
                                           // $state.go('app.finance.transaction.openBalanceUpload.list',{tenantid:$stateParams.tenantid});
                                            //$location.url($stateParams.tenantid+'/hbl/edit?rowid='+data.id);       

                                        //  $scope.cancel();
                                        }else{
                                            logger.logError('Unable to save!');
                                        }
                                        
                                    });
                             
                                }
                                else {
                                    if (flag1 == false) {
                                        logger.logError("Please Enter Number Value for No Of Package in Container Details");
                                    }
                                    if (flag2 == false) {
                                        logger.logError("Please Enter Number Value for UOM in Container Details");
                                    }
                                    if (flag3 == false) {
                                        logger.logError("Please Enter Number Value for NetWeight in Container Details");
                                    }
                                    if (flag4 == false) {
                                        logger.logError("Please Enter Number Value for GrossWeight in Container Details");
                                    }
                                    if (flag5 == false) {
                                        logger.logError("Please Enter Number Value for Amount in Freight Details");
                                    }
                                    if (flag6 == false) {
                                        logger.logError("Please Enter Number Value for Amount in Freight Details");
                                    }
                                    if (flag7 == false) {
                                        logger.logError("Please Enter Number Value for Amount in Freight Details");
                                    }
                                    if (flag8 == false) {
                                        logger.logError("Please Enter Number Value for Amount in Freight Details");
                                    }
                                    if (flag9 == false) {
                                        logger.logError("Please Enter Number Value for Amount in Freight Details");
                                    }
                                  
                                }
                            
                               
                        }
                             else {
                                    toaster.pop('error', "Please fill the required fields", 
                                            logger.getErrorHtmlNew(servicePartnerAddForm.$validationSummary), 5000, 'trustedHtml');
                                }
                        }
                        
                           $scope.checkValidation = function() {

                                var alertmsg = "<ui><h4>Please fill the required fields</h4>";
                                var msg = "";
                             
                                if ($scope.checkundefined($scope.openingBalance.invoiceNo)) {
                                    msg = msg + "<li>invoiceNo:Field is required.</li>";         
                                    $scope.changecolor('invoiceNo');
                                }else{
                                    $scope.clearcolor('invoiceNo');
                                }
                                if ($scope.checkundefined($scope.openingBalance.invoiceDate)) {
                                    msg = msg + "<li>invoiceDate:Field is required.</li>";         
                                    $scope.changecolor('invoiceDate');
                                }else{
                                    $scope.clearcolor('invoiceDate');
                                }
                                if ($scope.checkundefined($scope.openingBalance.tcAmount)) {
                                    msg = msg + "<li>tcAmount:Field is required.</li>";         
                                    $scope.changecolor('tcAmount');
                                }else{
                                    $scope.clearcolor('tcAmount');
                                }
                                if ($scope.checkundefined($scope.openingBalance.bcAmount)) {
                                    msg = msg + "<li>bcAmount:Field is required.</li>";         
                                    $scope.changecolor('bcAmount');
                                }else{
                                    $scope.clearcolor('bcAmount');
                                }
                                if ($scope.checkundefined($scope.openingBalance.mloCode)) {
                                    msg = msg + "<li>mloCode:Field is required.</li>";         
                                    $scope.changecolor('mloCode');
                                }else{
                                    $scope.clearcolor('mloCode');
                                }
                                if ($scope.checkundefined($scope.openingBalance.customer)) {
                                    msg = msg + "<li>customer:Field is required.</li>";         
                                    $scope.changecolor('customer');
                                }else{
                                    $scope.clearcolor('customer');
                                }
                              if ($scope.checkundefined($scope.openingBalance.currency)) {
                                    msg = msg + "<li>currency:Field is required.</li>";         
                                    $scope.changecolor('currency');
                                }else{
                                    $scope.clearcolor('currency');
                                }
                            if ($scope.checkundefined($scope.openingBalance.exchangeRate)) {
                                msg = msg + "<li>exchangeRate:Field is required.</li>";         
                                $scope.changecolor('exchangeRate');
                            }else{
                                $scope.clearcolor('exchangeRate');
                            }
                            if ($scope.checkundefined($scope.openingBalance.company)) {
                                msg = msg + "<li>company:Field is required.</li>";         
                                $scope.changecolor('company');
                            }else{
                                $scope.clearcolor('company');
                            }if ($scope.checkundefined($scope.openingBalance.sundryStatus)) {
                                msg = msg + "<li>sundryStatus:Field is required.</li>";         
                                $scope.changecolor('sundryStatus');
                            }else{
                                $scope.clearcolor('sundryStatus');
                            }
                          
        alertmsg = alertmsg + msg + "</ui>";
        if ($scope.checkundefined(msg)) {
            return '';
        } else {
            return alertmsg;
        }

    }

                           
                           
                           
                           
                           
                           
                           
                           
                           
                           
                           
                           
                           
                           
                           
                           
                           
                           
                           
                        
                          /* $http.get($stateParams.tenantid
                                    + '/app/commonUtility/getSubAccountCodeList').success(function(datas) {
                                  $scope.subAccountCodeList = datas.commonUtilityBean;
                                  }).error(function(datas) {
                              });*/
//                           
//                            $scope
//                            .$watch(
//                                    'openingBalance.accountHead',
//                                    function(newValue, oldValue) {
//                                        debugger;
//                                        if (newValue != ''
//                                                && newValue != undefined) {
//                                            /*
//                                             * var isFlag=true; var
//                                             * foundItemDest =
//                                             * $filter('filter')($scope.cashbankpaymentModelData.cbptables, {
//                                             * accountHead: newValue });
//                                             * if(foundItemDest.length>=2){
//                                             * isFlag = false; } if(isFlag){
//                                             */
//                                            var subAcct = $scope.openingBalance.subAccount;
//                                            $scope.openingBalance.isCurrencyBlocked = false;
//                                            $scope.openingBalance.subAccount = '';
//                                            if (newValue == '10080001' || newValue == '10070008' || newValue=='20020002') {
//                                                $scope.openingBalance.isSubAccountCode = true;
//                                                $scope.openingBalance.subAccount = subAcct;
//                                                $http
//                                                        .get(
//                                                                $stateParams.tenantid
//                                                                        + '/app/commonUtility/getonlySupplier')
//                                                        .success(
//                                                                function(datas) {
//                                                                    debugger;
//                                                                    $scope.openingBalance.subAccountCodeList = datas;
//                                                                })
//                                                        .error(function(datas) {
//                                                        });
//                                            } else if (newValue == '20010001' || newValue == '10080001' || newValue == '20040001'
//                                                    || newValue == '10090017' || newValue == '20010003' || newValue == '20010002' 
//                                                    || newValue == '10080003' || newValue == '10080002' ||newValue == '10090018' 
//                                                    ||newValue == '20020007' ||newValue == '20160002' ||newValue == '20160003' 
//                                                    ||newValue == '20160001' || newValue == '10060016') {
//                                                $scope.openingBalance.isTradeCreditors = true;
//                                                $scope.openingBalance.isSubAccountCode = true;
//                                                $http
//                                                        .get(
//                                                                $stateParams.tenantid
//                                                                        + '/app/commonUtility/getonlySupplier')
//                                                        .success(
//                                                                function(datas) {
//                                                                    $scope.openingBalance.subAccountCodeList = datas;
//                                                                })
//                                                        .error(function(datas) {
//                                                        });
//                                            } else if (newValue == '10070002'
//                                                    || newValue == '10120001'
//                                                    || newValue == '10070004'
//                                                    || newValue == '20020002') {
//                                                $scope.openingBalance.isSubAccountCode = true;
//                                                $scope.openingBalance.subAccount = subAcct;
//                                                $http
//                                                        .get(
//                                                                $stateParams.tenantid
//                                                                        + '/app/commonUtility/getSubAccountCodeListTradeCreditors')
//                                                        .success(
//                                                                function(datas) {
//                                                                    if (newValue == '10070002')
//                                                                        $scope.openingBalance.isTradeCreditors = true;
//                                                                    else if (newValue == '20010001' || newValue == '10080001')
//                                                                        $scope.openingBalance.isTradeCreditors = false;
//
//                                                                    $scope.openingBalance.subAccountCodeList = datas;
//                                                                })
//                                                        .error(function(datas) {
//                                                        });
//                                            } else if (newValue == '10070001'||newValue == '10070007') {
//                                                
//                                            /*  if ($scope.openingBalance..companyCode == 'C0001')
//                                                    $scope.currencyList = [ {
//                                                        id : 'KSH',
//                                                        text : 'KSH'
//                                                    } ];*/
//                                                $scope.openingBalance.isSubAccountCode = true;
//                                                $scope.openingBalance.subAccount = subAcct;
//                                                $http
//                                                        .get(
//                                                                $stateParams.tenantid
//                                                                        + '/app/commonUtility/getStaffListForAdvances')
//                                                        .success(
//                                                                function(datas) {
//                                                                    $scope.openingBalance.isTradeCreditors = false;
//                                                                    $scope.openingBalance.subAccountCodeList = datas;
//                                                                })
//                                                        .error(function(datas) {
//                                                        });
//                                            } else if (newValue == '20010004') {
//                                                $scope.openingBalance.isSubAccountCode = true;
//                                                $scope.openingBalance.subAccount = subAcct;
//                                                $http
//                                                        .get(
//                                                                $stateParams.tenantid
//                                                                        + '/app/commonUtility/getJvPartnerAccount')
//                                                        .success(
//                                                                function(datas) {
//                                                                    $scope.openingBalance.isTradeCreditors = false;
//                                                                    $scope.openingBalance.subAccountCodeList = datas;
//                                                                })
//                                                        .error(function(datas) {
//                                                        });
//                                            } else if (newValue == '20010002') {
//                                                $scope.openingBalance.isSubAccountCode = true;
//                                                $scope.openingBalance.subAccount = subAcct;
//                                                $http
//                                                        .get(
//                                                                $stateParams.tenantid
//                                                                        + '/app/commonUtility/getAgentList')
//                                                        .success(
//                                                                function(datas) {
//                                                                    $scope.openingBalance.isTradeCreditors = false;
//                                                                    $scope.openingBalance.subAccountCodeList = datas;
//                                                                })
//                                                        .error(function(datas) {
//                                                        });
//                                            } else {
//                                                $scope.openingBalance.isTradeCreditors = false;
//                                                $scope.openingBalance.subAccountCodeList = [];
//                                                $scope.openingBalance.isSubAccountCode = false;
//                                            }
//
//                                            if (newValue.substring(0, 4) == '1000') {
//                                                $scope.openingBalance.isAsset = true;
//                                                $http
//                                                        .get(
//                                                                $stateParams.tenantid
//                                                                        + '/app/commonUtility/getassetList')
//                                                        .success(
//                                                                function(datas) {
//                                                                    debugger;
//                                                                    $scope.openingBalance.assetList = datas;
//                                                                })
//                                                        .error(function(datas) {
//                                                        });
//                                            }
//
//
//
//
//                                            
//
//                                    
//                                            /*
//                                             * }else{
//                                             * $scope.openingBalance..accountHead='';
//                                             * logger.logError("Account already
//                                             * selected.Please select
//                                             * others!.."); }
//                                             */
//                                        } else {
//                                            $scope.openingBalance.subAccountCodeList = [];
//                                        }
//                                    });            
               // });
});
