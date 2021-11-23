//define([ 'hospital/accounts/accounts' ], function(module) {

    'use strict';
    app.controller('journalVoucherListCtrl', function($scope, $state, $http, ngDialog, logger, $location, $stateParams,
            $controller, $injector, sharedProperties, toaster, $rootScope) {
        $scope.dataLoopCount = 0;
        $scope.from = 0;
        $scope.to = 100;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 15;
        $scope.hideUploadIcon = true;
        $scope.isUpload = true;
        $scope.isDelete = true;
        $scope.jvcode ='';
        $scope.objCBPayment = {
                cbPaymenttDate:''
        }
        $scope.add = function() {
            $state.go("app.finance.accounts.journalvoucher.add");
        };
        $('#jvCode').selectivity({
            ajax : {
                url : 'app/journalVoucher/getJvCode',
                dataType : 'json',
                minimumInputLength : 5,
                quietMillis : 250,
                params : function(term, offset) {
                    return {
                        jvcode : term,
                        page : 1 + Math.floor(offset / 30)
                    };
                },
                processItem : function(item) {
                    return {
                        id : item.id,
                        text : item.text
                    };
                },
                results : function(data, offset) {
                    console.log("journal")
                     console.log(data)
                    return {
                      
                        results : data.lJournalVoucherBean,
                        more : (offset + data.lJournalVoucherBean.length > data.total_count)
                    };
                }
            },
            allowClear : true,
            placeholder : ' ',
            showSearchInputInDropdown : false,
            templates : {
                resultItem : function(item) {
                    return (
                    '<div class="selectivity-result-item"  data-item-id="' + item.id + '">' + '<l>' + escape(item.text) + '</l>' + '</div>'
                            );
                }
            }
        });
        

        $scope.view = function(jvNumber) {
            //  alert(5);
              $location.path($stateParams.tenantid +'/hospital/accounts/journalvoucher/view/' + jvNumber);
          }
        $scope.printJournalVoucherDiv = function(jvNumber){
            var url = 'app/journalVoucher/print?jvNumber=' + jvNumber;
            //var wnd = window.open(url, 'Simatech', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
            var wnd = window.open(url, 'Omega School', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
            //wnd.print();   
            if (wnd.print) {
                var done = false;
                if (wnd.document && wnd.document.readyState) {
                    var rs = wnd.document.readyState;
                    if ((rs === 'complete') || (rs === 'loaded')) {
                        done = true;
                        wnd.print();
                    }
                }
                if (!done) {
                    if (wnd.addEventListener) {
                        wnd.addEventListener('load', function() {
                            this.print();
                        });
                    } else {
                        wnd.onload = function() {
                            this.print();
                        };
                    }
                }
            }
         }

        $scope.getVoucherTypeList = function() {
            $http.get("app/JournalVoucherType/getJvTypeList").success(function(response) {
                $scope.journalVoucherTypeList = response.journalVoucherTypeBeans;
            });
        }
        $scope.getVoucherTypeList();

        $scope.jvBean = {
            departmentId : '',
            branchId : '',
            branchName : '',
            companyName : '',
            companyId : '',
            monthYear : '',
            month : '',
            year : '',
            isEdit : false,
            isOnLoad : false
        };

        $scope.date = '';

        var today = new Date();
        var dd = today.getDate();
        var mm = today.getMonth() + 1; // January is 0!
        var yyyy = today.getFullYear();

        if (dd < 10) {
            dd = '0' + dd;
        }
        if (mm < 10) {
            mm = '0' + mm;
        }

        var today = dd + '/' + mm + '/' + yyyy;
        $scope.todate = today;

        var now = new Date();
        now.setDate(now.getDate() + 30);

        var dd1 = now.getDate();
        var mm1 = now.getMonth() - 1; // January is 0!
        var yyyy1 = now.getFullYear();

        if (dd1 < 10) {
            dd1 = '0' + dd1;
        }
        if (mm1 < 10) {
            mm1 = '0' + mm1;
        }

        var frmdt = dd1 + '/' + mm1 + '/' + yyyy1;
        $scope.fromdate = frmdt;

        $scope.jvTypeId = '';

        $scope.$watch('todate', function(newValue, oldValue) {
            if (newValue != "" && newValue != undefined && newValue != '') {
                if ($scope.fromdate != undefined && $scope.fromdate != '' && $scope.fromdate != "") {
                    var fromDate = $scope.fromdate;
                    var toDate = newValue;
                    fromDate = fromDate.split("/");
                    fromDate = new Date(fromDate[2], fromDate[1] - 1, fromDate[0]);
                    toDate = toDate.split("/");
                    toDate = new Date(toDate[2], toDate[1] - 1, toDate[0]);
                    if (fromDate > toDate) {
                        logger.logError("To Date should be greater than the from date");
                        $scope.todate = '';
                    }
                }

            }

        });

        $scope.$watch('fromdate', function(newValue, oldValue) {
            if (newValue != "" && newValue != undefined && newValue != '') {
                if ($scope.todate != undefined && $scope.todate != '' && $scope.todate != "") {
                    var fromDate = $scope.todate;
                    var toDate = newValue;
                    fromDate = fromDate.split("/");
                    fromDate = new Date(fromDate[2], fromDate[1] - 1, fromDate[0]);
                    toDate = toDate.split("/");
                    toDate = new Date(toDate[2], toDate[1] - 1, toDate[0]);
                    if (fromDate < toDate) {
                        logger.logError("From Date should be lesser than the to date");
                        $scope.fromdate = '';
                    }
                }

            }

        });
        
        /*$scope.reverseJV = function() {
            $scope.jvcode=$("#jvCode .selectivity-single-select-input").val();
            if($scope.jvcode =="" || $scope.jvcode ==undefined){
                logger.logError("Please select voucher");
            }else{
                
                ngDialog.open({
                    scope : $scope,
                    template : 'views/hospital/accounts/journalVoucher/transactionJVReverseDialog',
                    controller : $controller('JournalVoucherReverseCtrl', {
                        $scope : $scope,
                        sJvNumber: $scope.jvcode,
                        screenName: 'journalvoucher'
                    }),
                    className : 'ngdialog-theme-plain',
                    showClose : false,
                    closeByDocument : false,
                    closeByEscape : false,
                    preCloseCallback : $scope.getList
                });
            
                
            }
       };
       */
        $scope.reverseConfirm = function() {
            if ($scope.jvcode == "" || $scope.jvcode == undefined) {
            logger.logError("Please Select JV No!");
            } else {
                if($scope.objCBPayment.cbPaymenttDate != null && $scope.objCBPayment.cbPaymenttDate != "" && 
                        $scope.objCBPayment.cbPaymenttDate != ""){
                $http.get('/app/journalVoucher/reverseJV?voucherNo='+ $scope.jvcode
                        +'&createdDate='+$scope.objCBPayment.cbPaymenttDate).success(function(datas) {
               // $http.post($stateParams.tenantid+'/app/journalVoucher/reverseJV1',$scope.jvReverseObj).success(function(datas) {
                    if(datas.success == true){
                        logger.logSuccess(datas.message);
                        ngDialog.close();
                        $state.go("app.hospital.accounts.journalvoucher.list");

                    }else{
                        logger.logError(datas.message);
                    }
                    }).error(function(datas) {
                });
                }
            }
            }
        $scope.reversePayment = function() {
            $scope.objCBPayment.cbPaymenttDate = "";
            $scope.jvcode=$("#jvCode .selectivity-single-select-input").val();
            $scope.screenNames = "payment";

            if($scope.jvcode =="" || $scope.jvcode ==undefined){
            logger.logError("Please select Journal Voucher");
            }else{
            ngDialog.open({
            template : 'views/finance/accounts/journalVoucher/transactionJVReverseDialog',
            scope :$scope
            });
            }

            };
            $scope.closeCBPReverseDialog = function() {
                ngDialog.close();
                };
        $scope.getTranslationList = function() {
            $scope.dataLoopCount = 0;
            $scope.showEmptyLabel = false;
            $scope.from = 0;
            $scope.to = 100;
            $scope.rowCollection = [];
            $scope.JVNumberList = [];
            var resultbean = {
                fromDate : $scope.fromdate,
                toDate : $scope.todate,
                jvTypeId : $scope.jvTypeId
            }

            if ($scope.fromdate != undefined && $scope.fromdate != null && $scope.fromdate != '' && $scope.todate != undefined && $scope.todate != null && $scope.todate != '') {

            }
            $http.post("app/journalVoucher/getlist", resultbean).success(function(datas) {
                $scope.rowCollection = datas.lJournalVoucherBeanDTO;
            })

        };

        $scope.getTranslationList();

        $scope.editJVRow = function(jvNumber) {
            $location.path($stateParams.tenantid +'/hospital/accounts/journalvoucher/edit/' + jvNumber);
        }
        $scope.deleteJVRow = function(jvNumber, index) {
            ngDialog.openConfirm().then(function() {
                var myURL = 'app/journalVoucher/deleteJournalVoucher';
                $http({
                    method : 'post',
                    url : myURL,
                    data : jvNumber,
                }).success(function(data) {
                    if (data == true) {
                        var tableData = $scope.rowCollection;
                        $scope.rowCollection.splice(index, 1);
                        logger.logSuccess("Deleted successfully");
                        $state.reload();
                    } else {
                        logger.logError("Error in deleting Record!");
                    }
                }).error(function(data) {
                    logger.logSuccess("Error in Delete!");
                });
            });
        }
        

        $scope.copyJournalVoucher = function(jvNumber) {
            jvNumber=$("#jvCode .selectivity-single-select-input").val();
            console.log("jvNumber")
            console.log(jvNumber)
            if(jvNumber =="" || jvNumber ==undefined){
                logger.logError("Please select voucher");
            }else{
                $location.path($stateParams.tenantid +'/hospital/accounts/journalvoucher/copyJournalVoucher/' + jvNumber);    
            }
            
        }

    });

    app.controller('journalVoucherAddCtrl', function($scope, $state, $http, $location, sharedProperties,
toaster, $timeout, $injector, logger, $stateParams, validationService) {

        $scope.isEdit = false;
        $scope.journalVoucher = {
            jvDate : '',
            jvNumber : '',
            narration : '',
            company : 'C0002',
            companyCode : '',
            companyLocation : '',
            dataOfIssue : '',
            journalvoucherTypeId : '',
            costCenter:'87',
            bankCenter:'',
            tables : []
        }

        var totCountDeb = 0;
        var totCountDebUsd = 0;
        var totCountCre = 0;
        var totCountCreUsd = 0;
        $scope.journalVoucherTypeList = [];

        $scope.getVoucherTypeList = function() {
            $http.get("app/JournalVoucherType/getJvTypeList").success(function(response) {
                $scope.journalVoucherTypeList = response.journalVoucherTypeBeans;
            });
        }
        $scope.getVoucherTypeList();
        
        
        
        

        $http.get('app/journalVoucher/getAccountHeadMapList').success(function(datas) {
            $scope.cashAccountList = datas;
        }).error(function(datas) {
            logger.logError("Error Please Try Again");
        });

        $scope.getCurrentDate = function() {
            var d = new Date();
            var year = d.getFullYear();
            var month = d.getMonth() + 1;
            if (month < 10) {
                month = "0" + month;
            }
            ;
            var day = d.getDate();
            if (day < 10) {
                day = "0" + day;
            }
            $scope.date = day + "/" + month + "/" + year;
            $scope.journalVoucher.dataOfIssue = $scope.date;
        }
        $scope.getCurrentDate();
        
        
        $scope.costList = [];

        
        $http.get("app/purchaseinvoice/costcenterlist").success(function(datas) {
            $scope.costList = datas;
        });

        
        $scope.$watch('journalVoucher.dataOfIssue', function(value, oldValue) {
            debugger
            if (value != '' && value != undefined) {
            var res = value.split("/");
            var formCode='F3817';
            $http.get('app/journalVoucher/getloggedcompany?closingDate='+value+'&formCode='+formCode).success(function(datas) {
            if(datas){
            logger.logError("Account closed for year "+ res[2]);
            $scope.journalVoucher.dataOfIssue = '';
            }
            })
            }
            });

        /**
         * validation
         */
        $scope.validate = function(journalVoucherForm, totalbcDebit, totalbcCredit, journalVoucher) {
            if (new validationService().checkFormValidity($scope.journalVoucherForm)) {

                if (!$scope.isEdit) {

                    if ($scope.totalbcDebit == $scope.totalbcCredit) {
                        $scope.save(journalVoucherForm, journalVoucher);
                    } else {
                        logger.logError("Total  Debit and  Credit must have equal");
                    }
                } else {
                    if (totalbcDebit == totalbcCredit) {
                        $scope.save(journalVoucherForm, journalVoucher);
                    } else {
                        logger.logError("Total  Debit and  Credit must have equal");
                    }
                }

            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.journalVoucherForm.$validationSummary), 555000, 'trustedHtml');
            }
        };

        /**
         * Dropdown Datas
         */

        $scope.getDropDownList = function() {

            $http.get($stateParams.tenantid +'/app/commonUtility/getCompanyListWithUser').success(function(datas) {
                $scope.journalVoucher.companyCode = datas.commonUtilityBean[0].value;
                $scope.journalVoucher.company = datas.commonUtilityBean[0].description;

            }).error(function(data) {
            });
            $http.get('app/journalVoucher/getAccountHeadList').success(function(datas) {
                $scope.accountHeadList = datas;
            }).error(function(datas) {
                logger.logError("Error Please Try Again");
            });

            $http.get('app/journalVoucher/getCurrencyList').success(function(datas) {
                $scope.currencyList = datas;
            }).error(function(datas) {
                logger.logError("Error Please Try Again");
            });

       /*     $http.get('app/purchaseinvoice/getCompanyList').success(function(datas) {
                $scope.companyList = datas;
            }).error(function(datas) {
            });
            */
            $http.get('app/journalVoucher/getCompanyList').success(function(datas) {
                $scope.companyList = datas;
            }).error(function(datas) {
            });
            
            $scope.$watch('journalVoucher.company', function(newValue, oldValue) {
                //  alert(newValue);
                   if(newValue!=null && newValue!=undefined && newValue != ''){
                   //    $http.post($stateParams.tenantid+ '/app/commonUtility/getVoyageListByVessel',newValue).success(function(data) {
                        $http.get('app/purchaseinvoice/getcompanycost?company=' + $scope.journalVoucher.company).success(function(data) {

                            $scope.journalVoucher.company = newValue;


                             if(data.length > 0)
                           {
                           $scope.costList = data;
                           }
                            /* else{
                                 
                                 logger.logError("Not Available");
                                 
                             }*/
                       });
                   }
                 });
              
            

            
            $http.get('app/journalVoucher/getAccountHeadMapList').success(function(datas) {
                $scope.banklist = datas;
            }).error(function(datas) {
                logger.logError("Error Please Try Again");
            });
          

            // sub account code --- Eg: customer, supplier will load in this
            // dropdown
       /*     $http.get('app/commonUtility/getSubAccountCodeLists').success(function(datas) {

                var subAcctList = [];
                angular.forEach(datas.commonUtilityBean, function(item, key) {
                    var subAccHdObj = new Object();
                    subAccHdObj.id = datas.commonUtilityBean[key].subAccountCode;
                    subAccHdObj.text = datas.commonUtilityBean[key].subAccountName;
                    subAcctList.push(subAccHdObj);
                });
                $scope.subAccountCodeList = subAcctList;
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });*/
            // Attributes Dropdown

            $http.get($stateParams.tenantid +'/app/commonUtility/getEmployeeList').success(function(datas) {
                $scope.employeeList = datas;
            }).error(function(datas) {
            });

            
            
            $http.get($stateParams.tenantid +'/app/commonUtility/getstudentList').success(function(datas) {
                $scope.studentList = datas;
            }).error(function(datas) {
            });
            $http.get($stateParams.tenantid +'/app/commonUtility/getDepartmentList').success(function(datas) {
                $scope.departmentList = datas;
            }).error(function(datas) {
            });

            $http.get($stateParams.tenantid +'/app/commonUtility/getCountryList').success(function(datas) {
                $scope.countryList = datas;
            }).error(function(datas) {
            });
            $http.get($stateParams.tenantid +'/app/commonUtility/getSupplierList').success(function(datas) {
                $scope.supplierList = datas;
            }).error(function(datas) {
            });
            $http.get($stateParams.tenantid +'/app/commonUtility/getCustomerAttributeList').success(function(datas) {
                $scope.customerList = datas;
            }).error(function(datas) {
            });

            $http.get($stateParams.tenantid +'/app/commonUtility/getDesignationList').success(function(datas) {
                $scope.designationList = datas;
            }).error(function(datas) {
            });
            $http.get($stateParams.tenantid +'/app/commonUtility/getCostCenter').success(function(datas) {
                $scope.costCenterList = datas;
            }).error(function(datas) {
            });

            $http.get($stateParams.tenantid +'/app/commonUtility/getPatientList').success(function(datas) {
                $scope.patientList = datas;
            }).error(function(datas) {
            });

        }

        $scope.getDropDownList();

        $scope.loadJVTable = function() {
            var jvtableRow = {};
            jvtableRow = {
                slNo : 1,
                subGropAccount : '',
                accountCode : '',
                subAccountCode : '',
                narration : '',
                currency : "INR",
                exchangeRate : 1.0,
                bcDebitAmount : 0,
                tcDebitAmount : 0,
                bcCreditAmount : 0,
                tcCreditAmount : 0,

                employeeCode : '',
                departmentCode : '',
                countryCode : '',
                customerCode : '',
                supplierCode : '',
                designationCode : '',
                costCenter : '',
                companyCode : '',
                patientCode : '',

                isEmployee : false,
                isDepartment : false,
                isLocation : false,
                isCustomer : false,
                isSupplier : false,
                isDesignation : false,
                isCostCenter : false,
                isCompany : false,
                isPatient : false,

                attributeList : []

            };
            $scope.journalVoucher.tables.push(jvtableRow);
            $scope.addRow($scope.journalVoucher.tables);
        }

        $scope.addRow = function(tables) {
            var len = tables.length;
            var table = {
                slNo : 1,
                subGropAccount : '',
                accountCode : '',
                subAccountCode : '',
                narration : '',
                currency : "INR",
                exchangeRate : 1.0,
                bcDebitAmount : 0,
                tcDebitAmount : 0,
                bcCreditAmount : 0,
                tcCreditAmount : 0,

                employeeCode : '',
                departmentCode : '',
                countryCode : '',
                customerCode : '',
                supplierCode : '',
                designationCode : '',
                costCenter : '',
                companyCode : '',
                patientCode : '',

                isEmployee : false,
                isDepartment : false,
                isLocation : false,
                isCustomer : false,
                isSupplier : false,
                isDesignation : false,
                isCostCenter : false,
                isCompany : false,
                isPatient : false,

                attributeList : []
            };
            table.slNo = len + 1;
            $scope.journalVoucher.tables.push(table);
        };

        $scope.loadJVTable();

        $scope.removeRow = function(tables) {
            $scope.tablerow = [];
            angular.forEach(tables, function(row, index) {
                var check = row.select;
                if (check == undefined || check == "") {
                    $scope.tablerow.push(row);
                }
            });
            $scope.journalVoucher.tables = $scope.tablerow;
            $scope.totalCalculation();
        };

        $scope.onChangeTcDebit = function(row, table) {
            row.bcDebitAmount = parseFloat(row.tcDebitAmount) / parseFloat(row.exchangeRate);
            $scope.totalCalculation();
        }

        $scope.onChangeBcDebit = function(row, table) {
            row.tcDebitAmount = parseFloat(row.bcDebitAmount) * parseFloat(row.exchangeRate);
            $scope.totalCalculation();
        
        }

        $scope.onChangeTcCredit = function(row, table) {
            row.bcCreditAmount = parseFloat(row.tcCreditAmount) * parseFloat(row.exchangeRate);
            $scope.totalCalculation();
        }

        $scope.onChangeBcCredit = function(row, table) {
            row.tcCreditAmount = parseFloat(row.bcCreditAmount) * parseFloat(row.exchangeRate);
            $scope.totalCalculation();
        }

        $scope.totalCalculation = function() {
            $scope.totaltcDebit = 0.0;
            $scope.totalbcDebit = 0.0;
            $scope.totaltcCredit = 0.0;
            $scope.totalbcCredit = 0.0;
            angular.forEach($scope.journalVoucher.tables, function(row, rowindex) {
                $scope.totaltcDebit = (parseFloat($scope.totaltcDebit) + parseFloat(row.tcDebitAmount)).toFixed(2);
                $scope.totalbcDebit = (parseFloat($scope.totalbcDebit) + parseFloat(row.bcDebitAmount)).toFixed(2);
                $scope.totaltcCredit = (parseFloat($scope.totaltcCredit) + parseFloat(row.tcCreditAmount)).toFixed(2);
                $scope.totalbcCredit = (parseFloat($scope.totalbcCredit) + parseFloat(row.bcCreditAmount)).toFixed(2);
            });
        }

        $scope.allowNumberCheck = function(row) {
            var newValue = row.journalDebit;
            var arr = String(newValue).split("");
            if (arr.length == undefined)
                return;
            else if (arr.length === 0)
                return;
            else if (arr.length === 1 && (arr[2] == '-' || arr[2] === '.'))
                return;

            else if ((newValue != undefined && newValue != '' && isNaN(newValue))) {
                $scope.row.journalDebit = oldValue;
            }

        }

        $scope.numberCheck = function(row) {
            if (isNaN(row.tcDebitAmount)) {
                row.tcDebitAmount = 0;
            } else if (isNaN(row.bcDebitAmount)) {
                row.bcDebitAmount = 0;
            } else if (isNaN(row.tcCreditAmount)) {
                row.tcCreditAmount = 0;
            } else if (isNaN(row.bcCreditAmount)) {
                row.bcCreditAmount = 0;
            }

        }

        $scope.cancel = function() {

            $state.go("app.finance.accounts.journalvoucher.list");
        };

        /**
         * Edit Functionality ****************************************
         */
        var rowCount = 0;

        var jvNumber = $stateParams.jvNumber;
        if (jvNumber == undefined || jvNumber == "" || jvNumber == null) {
            $scope.isEdit = false;
        } else {
            $scope.isEdit = true;
            $timeout(function() {
                $http.get('app/journalVoucher/getJournalVoucherEditData?jvNumber=' + jvNumber).success(function(data) {
                    $scope.journalVoucher = data;
                    $scope.journalVoucher.journalvoucherTypeId = data.journalvoucherTypeId;

                    $scope.totalCalculation();
                }).error(function(data) {
                });
            }, 2, false);
        }

        /***********************************************************************
         * save and update functionality
         * ********************************************************
         */

        $scope.save = function(journalVoucherForm, journalVoucher) {
            angular.forEach($scope.journalVoucher.tables, function(key, index) {

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
            if ($scope.isEdit === false) {
                $http.post('app/journalVoucher/add', $scope.journalVoucher).success(function(result) {

                    if (result == false) {
                        logger.logError("Unable to Save");
                    } else {
                        logger.logSuccess("Journal Voucher added successfully");
                        $location.path($stateParams.tenantid +'/hospital/accounts/journalvoucher/list');
                    }
                }).error(function(data) {
                });
            } else {
                $http.post('app/journalVoucher/update', $scope.journalVoucher).success(function(result) {
                    if (result) {
                        logger.logSuccess("Journal Voucher updated successfully");
                        $location.path($stateParams.tenantid +'/hospital/accounts/journalvoucher/list');
                    } else {
                        logger.logError("Unable to Update");
                    }
                }).error(function(data) {

                });
            }

        };

    });
    
    
    
    
    app.controller('tableCtrl', function($scope, $http, $filter, logger,$stateParams) {
    	
    	
    	
    	
    	 
    	
    	
        $scope.$watch('journalVoucher.tables[trIndex].accountCode', function(newValue, oldValue) {
            if (newValue != '' && newValue != undefined) {
                
                
                    debugger;
                   // if (newValue == '20090001') {
                       /* $http.get($stateParams.tenantid +'/app/commonUtility/getSubAccountCodeLists').success(function(datas) {
                        
                            var subAcctList = [];
                            angular.forEach(datas.commonUtilityBean, function(item, key) {
                                var subAccHdObj = new Object();
                                subAccHdObj.id = datas.commonUtilityBean[key].subaccountcode;
                                subAccHdObj.text = datas.commonUtilityBean[key].subaccountname;
                                subAcctList.push(subAccHdObj);
                            });
                            $scope.subAccountCodeList = subAcctList;
                        }).error(function(datas) {
                        });
*/                  ///  }  else {
                      //  $scope.objCBReceipt.cshBankDetail[$scope.$index].isTradeDebtors = false;
                       // $scope.objCBReceipt.cshBankDetail[$scope.$index].subAccountCodeList = [];
                       // $scope.objCBReceipt.cshBankDetail[$scope.$index].isSubAccountCode = false;
                  //  }

                    $http.get($stateParams.tenantid +'/app/commonUtility/getSubAcctNew?accountCode=' + newValue).success(function(datas) {

                        var subAcctList = [];
                        angular.forEach(datas.commonUtilityBean, function(item, key) {
                            var subAccHdObj = new Object();
                            subAccHdObj.id = datas.commonUtilityBean[key].subaccountcode;
                            subAccHdObj.text = datas.commonUtilityBean[key].subaccountname;
                            subAcctList.push(subAccHdObj);
                            $scope.journalVoucher.tables[$scope.$index].subAccountCode = datas.commonUtilityBean[key].subaccountcode;

                        });
                        $scope.subAccountCodeList = subAcctList;
                    }).error(function(datas) {
                    });

                
                $http.get($stateParams.tenantid +'/app/commonUtility/getAttributesList?accountCode=' + newValue).success(function(datas) {
                    $scope.journalVoucher.tables[$scope.$index].attributeList = datas;
                    if (newValue == oldValue) {
                        $scope.isOnChange = false;
                    } else {
                        $scope.isOnChange = true;
                    }
                    if (!$scope.isEdit || $scope.isOnChange) {

                        $scope.journalVoucher.tables[$scope.$index].employeeCode = '';
                        $scope.journalVoucher.tables[$scope.$index].departmentCode = '';
                        $scope.journalVoucher.tables[$scope.$index].countryCode = '';
                        $scope.journalVoucher.tables[$scope.$index].customerCode = '';
                        $scope.journalVoucher.tables[$scope.$index].supplierCode = '';
                        $scope.journalVoucher.tables[$scope.$index].designationCode = '';
                        $scope.journalVoucher.tables[$scope.$index].costCenter = '';
                        $scope.journalVoucher.tables[$scope.$index].companyCode = '';
                        $scope.journalVoucher.tables[$scope.$index].patientCode = '';
                    }

                    $scope.journalVoucher.tables[$scope.$index].isEmployee = false;

                    $scope.journalVoucher.tables[$scope.$index].isDepartment = false;

                    $scope.journalVoucher.tables[$scope.$index].isLocation = false;
                    $scope.journalVoucher.tables[$scope.$index].isCustomer = false;
                    $scope.journalVoucher.tables[$scope.$index].isSupplier = false;
                    $scope.journalVoucher.tables[$scope.$index].isDesignation = false;
                    $scope.journalVoucher.tables[$scope.$index].isCostCenter = false;
                    $scope.journalVoucher.tables[$scope.$index].isCompany = false;

                    $scope.journalVoucher.tables[$scope.$index].isPatient = false;

                    angular.forEach($scope.journalVoucher.tables[$scope.$index].attributeList, function(row, rowindex) {
                        if (row.attributeName == "Employee") {
                            $scope.journalVoucher.tables[$scope.$index].isEmployee = true;
                        } else if (row.attributeName == "Department") {
                            $scope.journalVoucher.tables[$scope.$index].isDepartment = true;
                        } else if (row.attributeName == "Students") {
                            $scope.journalVoucher.tables[$scope.$index].isLocation = true;
                        } else if (row.attributeName == "Customer") {
                            $scope.journalVoucher.tables[$scope.$index].isCustomer = true;
                        } else if (row.attributeName == "Supplier") {
                            $scope.journalVoucher.tables[$scope.$index].isSupplier = true;
                        } else if (row.attributeName == "Designation") {
                            $scope.journalVoucher.tables[$scope.$index].isDesignation = true;
                        } else if (row.attributeName == "Cost Center") {
                            $scope.journalVoucher.tables[$scope.$index].isCostCenter = true;
                        } else if (row.attributeName == "Company") {
                            $scope.journalVoucher.tables[$scope.$index].isCompany = true;
                        } else if (row.attributeName == "Patient") {
                            $scope.journalVoucher.tables[$scope.$index].isPatient = true;
                        }
                    });
                }).error(function(datas) {
                });

            }
        });
        $scope.$watch('journalVoucher.tables[trIndex].subAcctCode', function(newValue, oldValue) {
            if (newValue != '' && newValue != undefined) {
                $scope.journalVoucher.tables[$scope.$index].subAcctCode = newValue;
            }

        });
  //  });
});
/*
app.controller('JournalVoucherReverseCtrl', function($scope, $http,ngDialog,logger,$location,sJvNumber,screenName,$timeout,$stateParams) {
    $scope.jvReverseObj = {dataOfIssue:'', jvNumber:''};
    
    $scope.screenNames = screenName;
    
        $timeout(function() {
            $("#jvReverse_Date").datetimepicker({
                minDate: "01/01/2016",
                format : 'DD/MM/YYYY',
                pickTime: false
            });
         }, 1000);
        
        $("#jvReverse_Date").on("dp.change", function(e) {
            $scope.jvReverseObj.dataOfIssue = $('#txtJvReverseDate').val();
        });
        
        $timeout(function() {
            $("#txtJvReverseDate").datetimepicker({
                minDate: "01/01/2016",
                format : 'DD/MM/YYYY',
                pickTime: false
            });
         }, 1000);
        
        $("#txtJvReverseDate").on("dp.change", function(e) {
            $scope.jvReverseObj.dataOfIssue = $('#txtJvReverseDate').val();
        });
    
        
    
    $scope.getCurrentDate = function(){
        var today = new Date();
        var dd = today.getDate();
        var mm = today.getMonth() + 1;

        var yyyy = today.getFullYear();
        if (dd < 10) { dd = '0' + dd }
        if (mm < 10) { mm = '0' + mm }
        var today = dd + '/' + mm + '/' + yyyy;
        $scope.jvReverseObj.dataOfIssue  = today;
    }
        $scope.getCurrentDate();
    $scope.jvReverseObj.jvNumber = sJvNumber;
   
    $scope.reverseConfirm = function(){
        if($scope.screenNames=="journalvoucher"){
            if($scope.jvReverseObj.dataOfIssue!=""){
                $http.post($stateParams.tenantid+'/app/journalVoucher/reverseJV',$scope.jvReverseObj).success(function(datas) {
                    if(datas.success == true){
                        logger.logSuccess(datas.sErrorMessage);
                        ngDialog.close();
                    }else{
                        logger.logError(datas.sErrorMessage);
                    }
                    }).error(function(datas) {
                });
            }else{
                logger.logError("Please Select JV Date!");
            }
        }
    }
    $scope.closeCBPReverseDialog = function() {
        ngDialog.close();
     };
});*/

app.controller('JournalVoucherReverseCtrl', function($scope, $http,ngDialog,logger,$location,sJvNumber,screenName,$timeout,$stateParams) {
        $scope.jvReverseObj = {dataOfIssue:'', jvNumber:''};

$scope.screenNames = screenName;

    /*$timeout(function() {
        $("#jvReverse_Date").datetimepicker({
            minDate: "01/01/2016",
            format : 'DD/MM/YYYY',
            pickTime: false
        });
     }, 1000);
    
    $("#jvReverse_Date").on("dp.change", function(e) {
        $scope.jvReverseObj.dataOfIssue = $('#txtJvReverseDate').val();
    });*/
    
    $timeout(function() {
        $("#txtJvReverseDate").datetimepicker({
            minDate: "01/01/2016",
            format : 'DD/MM/YYYY',
            pickTime: false
        });
     }, 1000);
    
    $("#txtJvReverseDate").on("dp.change", function(e) {
        $scope.jvReverseObj.dataOfIssue = $('#txtJvReverseDate').val();
    });

    

$scope.getCurrentDate = function(){
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth() + 1;

    var yyyy = today.getFullYear();
    if (dd < 10) { dd = '0' + dd }
    if (mm < 10) { mm = '0' + mm }
    var today = dd + '/' + mm + '/' + yyyy;
    $scope.jvReverseObj.dataOfIssue  = today;
}
    $scope.getCurrentDate();
$scope.jvReverseObj.jvNumber = sJvNumber;

$scope.reverseConfirm = function(){
    if($scope.screenNames=="journalvoucher"){
        if($scope.jvReverseObj.dataOfIssue!=""){
            $http.post($stateParams.tenantid+'/app/journalVoucher/reverseJV',$scope.jvReverseObj).success(function(datas) {
                if(datas.success == true){
                    logger.logSuccess(datas.sErrorMessage);
                    ngDialog.close();
                }else{
                    logger.logError(datas.sErrorMessage);
                }
                }).error(function(datas) {
            });
        }else{
            logger.logError("Please Select JV Date!");
        }
    }
}
$scope.closeCBPReverseDialog = function() {
    ngDialog.close();
 };
});