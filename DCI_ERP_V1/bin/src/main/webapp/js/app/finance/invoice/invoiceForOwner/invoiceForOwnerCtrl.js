'use strict';
app.controller('invoiceForOwnerCtrl', function($scope, $stateParams, $controller ,$window, $rootScope, $location, $http, logger, $log, 
        ngDialog, $modal, utilsService, $state) {

    $scope.dataLoopCount = 0;
    $scope.from = 0;
    $scope.to = 100;
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;

    $scope.getTranslationList = function() {
        $scope.dataLoopCount = 0;
        $scope.showEmptyLabel = false;
        $scope.from = 0;
        $scope.to = 100;
        $scope.rowCollection = [];
        $scope.invoiceForOwnerList = [];
        var url = $stateParams.tenantid+'app/InvoiceForOwner/list?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount + '&formCode='+$('#form_code_id').val();
        $http.get(url).success(function(data) {
            console.log("data***********");
            console.log(data);
            if (data.success == true) {
                $scope.rowCollection = $scope.rowCollection.concat(data.invoiceList);
            }
        });
    };

    $scope.getTranslationList();
    $scope.currentURL=$location.protocol() + '://'+ $location.host() +':'+  $location.port()+"/#" +$location.path();
    if(window.localStorage.getItem('ivforowner_list')==$scope.currentURL){
        alert('window ' + $scope.currentURL + ' is already opened');
        //window.focus();
        //window.open($rootScope.currentURL,'_self').close();
        setTimeout(window.close(),5000);
        //localStorage.removeItem('receipt');
     }else{
         window.localStorage.setItem('ivforowner', $scope.currentURL);
         localStorage.removeItem('ivforowner');
     }
    $scope.add = function() {
        $state.go('app.finance.invoice.invoiceForOwnerAdd',{tenantid:$stateParams.tenantid});
    };

    $scope.editRowBtn = function(InvoiceNo) {
        $location.path('/invoice/invoiceForOwner/edit/' + InvoiceNo);
    }

    $scope.deleteRow = function(InvoiceNo) {
        ngDialog.close();
        ngDialog.open({
            template : 'invoiceForOwnerDeleteModal',
            scope :$scope,
            controller: $controller('GIctrlDelete', {
                $scope: $scope,
                InvoiceNo: InvoiceNo
            })
        });       
   };

   $scope.view = function(invoiceNo) {       
          $location.path('/invoice/invoiceForOwner/view/' + invoiceNo);
   }
   /**
    * send mail
    */
   $scope.sendMail = function(invoiceNo) {       
       $http.get($stateParams.tenantid+'app/InvoiceForOwner/sendMail?invoiceNo='+invoiceNo).success(function(data) {
           if (data == true) {
               logger.logSuccess("Mail sent successfully!");
           }else{
               logger.logError("Unable to send Email");
           }
       }).error(function(data) {
           console.log("data" + data);
       });

   }
   
   $scope.printinvoiceForOwner = function(invoiceNo){
       var url = $stateParams.tenantid+'app/InvoiceForOwner/print?invoiceNo=' + invoiceNo;
       var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
       wnd.print();   
    }
   
   $scope.bulkPrint = function(giRowData) {
       var invoiceNos = '';
       var len = giRowData.length;
       for (var i = 0; i < len; i++) {
           var rowData = giRowData[i];
           if (typeof rowData.check == "undefined") {
               rowData["check"] = false;
           }
           if (rowData.check == true) {
               if(invoiceNos==""){
                   invoiceNos= rowData.invoiceNo; 
               }
               else{
                   invoiceNos +=","+rowData.invoiceNo;
               }
           }
       }           
       var url = $stateParams.tenantid+'app/InvoiceForOwner/bulkPrint?invoiceNos='+invoiceNos;
       var wnd = window.open(url, 'Shipping', 'height=400,width=750,top=100,left=100,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
       wnd.print();
   }   
});

app.controller('GIctrlDelete', function($scope, $http,ngDialog,logger,$location,InvoiceNo,$stateParams) {
    $scope.DeleteConfirm = function(){
        $http.get($stateParams.tenantid+'app/invoiceForOwner/delete?invoiceNo='+InvoiceNo).success(function(data) {
            if (data == true) {
                logger.logSuccess("Deleted successfully!");
                $scope.rowCollection = $scope.rowCollection.filter(function(obj) {
                    return obj.InvoiceNo !== InvoiceNo;
                });
                ngDialog.close();
            }else{
                logger.logError("Unable to Delete");
                ngDialog.close();
            }
        }).error(function(data) {
            console.log("data" + data);
        });
       
    }
    
    $scope.closeJVAccountDialog = function() {
        ngDialog.close();
     };
});

app.controller('invoiceForOwnerAddCtrl', function($scope, $window, $rootScope, $location, $filter, $http, logger, 
        $log, ngDialog, $modal, utilsService, ListService, $stateParams,$timeout,validationService,toaster,$state) {

    $scope.mloList=[];
    $scope.PorthdrList=[];
    $scope.voyagehdrList=[];
    $scope.invoiceForOwner = {
        Company : '',
        CompanyCode : '',
        CustomerName : '', 
        MloName : '', 
        Voyage : '', 
        VesselName : '', 
        AccountName : '', 
       // Company : '', 
        ServiceName : '',
        CurrencyName : '', 
        ExchangeRate : '', 
        fromCurrency: '',
        toCurrency:'',
        Pol : '', 
        Pod : '', 
        Subject : '', 
        Unit20 : '', 
        Unit40 : '', 
       // Subject : '', 
        bl : '',
        ExchangeRateFrom : '', 
        ExchangeRateTo : '', 
        currencyValue : '',
        fraction : '', 
        InvoiceDate : '',
        TotalBCamount : '', 
        TotalTCamount : '', 
        BlRelated : true,
        isEdit : false,
        detailList : []
    }


    $scope.cancel = function() {
        $state.go('app.finance.invoice.invoiceForOwner',{tenantid:$stateParams.tenantid});
    };
    $scope.currentURL=$location.protocol() + '://'+ $location.host() +':'+  $location.port()+"/#" +$location.path();
    if(window.localStorage.getItem('ivforowner')==$scope.currentURL){
        alert('window ' + $scope.currentURL + ' is already opened');
        //window.focus();
        //window.open($rootScope.currentURL,'_self').close();
        setTimeout(window.close(),5000);
        //localStorage.removeItem('receipt');
     }else{
         window.localStorage.setItem('ivforowner', $scope.currentURL);
     }
    $(window).unload(function(){
        //debugger;
       //alert("INSIDE UNLOAD")
         localStorage.removeItem('ivforowner');
       });
    $scope.onLoadDropdowns = function() {
        $http.get($stateParams.tenantid+'app/usermaster/getCompanyList?formCode='+$('#form_code_id').val()).success(function(datas) {
            $scope.companyList = datas;
            var foundItemDest = $filter('filter')($scope.companyList, { baseCompany:  1 })[0];
            $scope.invoiceForOwner.CompanyCode=foundItemDest.id;
            }).error(function(datas) {
        });
        
        $scope.dataList = ListService.getCustomerList();
        $scope.dataList.then(function(customerLists) {
            $scope.customerhdrList = customerLists;
        });
        
        $scope.dataList = ListService.getVesselList();
        $scope.dataList.then(function(VesselLists) {
            $scope.VesselhdrList = VesselLists;
            console.log("************")
            console.log($scope.VesselhdrList)
        });
        
/*        $scope.dataList = ListService.getSubAccountList();        
        $scope.dataList.then(function(SubAccountLists) {
            $scope.subAccountCodeList = SubAccountLists;
        });*/
        
        $scope.dataList = ListService.getAccountHeadList();
        $scope.dataList.then(function(AccountHeadLists) {
            $scope.AccountHeadList = AccountHeadLists;
        });
        
        // Account Attribute implementation
        $http.get($stateParams.tenantid+'app/commonUtility/getVoyageList').success(function(datas) {
            $scope.voyageList = datas;
            }).error(function(datas) {
        });
        
        $http.get($stateParams.tenantid+'app/commonUtility/getVesselList').success(function(datas) {
            $scope.vesselList = datas;
            }).error(function(datas) {
        });

        $http.get($stateParams.tenantid+'app/commonUtility/getSupplierList').success(function(datas) {
            $scope.supplierList = datas;
            }).error(function(datas) {
        });
        
        $http.get($stateParams.tenantid+'app/commonUtility/getSectorList').success(function(datas) {
            $scope.sectorList = datas;
            }).error(function(datas) {
        });
        
        $http.get($stateParams.tenantid+'app/commonUtility/getEmployeeList').success(function(datas) {
            $scope.employeeList = datas;
            }).error(function(datas) {
        });
        
        $http.get($stateParams.tenantid+'app/commonUtility/getPortList').success(function(datas) {
            $scope.portList = datas;
            }).error(function(datas) {
        });
        
        $http.get($stateParams.tenantid+'app/commonUtility/getDepartmentList').success(function(datas) {
            $scope.departmentList = datas;
            }).error(function(datas) {
        });
        
        $http.get($stateParams.tenantid+'app/commonUtility/getAgentList').success(function(datas) {
            $scope.agentList = datas;
            }).error(function(datas) {
        });
        
        $http.get($stateParams.tenantid+'app/commonUtility/getCountryList').success(function(datas) {
            $scope.countryList = datas;
            }).error(function(datas) {
        });
        
        $http.get($stateParams.tenantid+'app/commonUtility/getCustomerList').success(function(datas) {
            $scope.customerList = datas;
            }).error(function(datas) {
        });
        
        $http.get($stateParams.tenantid+'app/commonUtility/getDesignationList').success(function(datas) {
            $scope.designationList = datas;
            }).error(function(datas) {
        });
        
        $http.get($stateParams.tenantid+'app/purchaseinvoice/getCurrencyList').success(function(datas) {
            $scope.currencyList = datas;
            }).error(function(datas) {
        });
    };
    $scope.onLoadDropdowns();

    $('#invoice_date').datetimepicker({
        minDate: "01/01/2016",
        pickTime: false,
        format : 'DD/MM/YYYY'
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
    $scope.invoiceForOwner.InvoiceDate = today;

    debugger;
    var generalObj = angular.copy($scope.invoiceForOwner, generalObj);
    var listVariable = Object.keys(generalObj);

    $scope.$watchCollection('invoiceForOwner', function(newVal, oldVal) {
        if (newVal != undefined) {
            var userSelected = $scope.getValueForSelect(listVariable, newVal, oldVal);
            if (angular.isDefined(userSelected)) {
                $scope.selectedDropDown(userSelected);
            }
        }
    }, true);

  
    $scope.getValueForSelect = function(listVariable, newValObj, oldValObj) {
        var singleDeclaredvariable = null;
        angular.forEach(listVariable, function(value) {
            if (newValObj[value] != oldValObj[value])
                singleDeclaredvariable = value;
        });
        return singleDeclaredvariable;
    }

        
    $scope.onSubmit = function(invoiceForOwnerForm,invoiceForOwner) {
        if (new validationService().checkFormValidity($scope.invoiceForOwnerForm)) {
            $scope.save();
        } else {
            toaster.pop('error', "Please fill the required fields", 
                    logger.getErrorHtmlNew($scope.invoiceForOwnerForm.$validationSummary), 5000, 'trustedHtml');
        }
    };
    
    $scope.display_limit = 50;
    
    $scope.increaseLimit = function () {
        if ($scope.display_limit < $scope.yearListVal.length) {
            $scope.display_limit += 50;
        }
      };
    $scope.logValidExgRateErrorMessage ="";
    
    $scope.save = function() {
        debugger;
        var isExgRateValid = $scope.validateExchangeRate($scope.invoiceForOwner);
        if(isExgRateValid){
            if ($scope.invoiceForOwner.isEdit == false) {
                $scope.invoiceForOwner.InvoiceDate = $("#txtInvoiceDate").val();
                $http.post($stateParams.tenantid+'app/InvoiceForOwner/save', $scope.invoiceForOwner).success(function(data) {
                    if (data == true) {
                        logger.logSuccess("Created successfully!");
                        $location.path("/invoice/invoiceForOwner/list");
                    } else {
                        logger.logError("Unable to Save");
                    }
                }).error(function(data) {
                });
            }else{
                $scope.invoiceForOwner.InvoiceDate = $("#txtInvoiceDate").val();
                
                 $http.post($stateParams.tenantid+'app/InvoiceForOwner/update', $scope.invoiceForOwner).success(function(data) {
                    if (data == true) {
                        logger.logSuccess("Updated successfully!");
                        $location.path("/invoice/invoiceForOwner/list");
                    } else {
                        logger.logError("Unable to Save");
                    }
                }).error(function(data) {
                });
            
            }
        }else{
            logger.logError($scope.logValidExgRateErrorMessage);
        }
        
    };
    
    $scope.logValidExgRateErrorMessage = "";
    
    $scope.validateExchangeRate = function(invoiceForOwner){
        debugger;
        var HdrLogErrMessage="",DtlLogErrMessage = "",loggerMsg="", isFlag=true;
        if(parseFloat(invoiceForOwner.ExchangeRate) < parseFloat(invoiceForOwner.fromCurrency) 
                || parseFloat(invoiceForOwner.ExchangeRate) > parseFloat(invoiceForOwner.toCurrency)){
            HdrLogErrMessage="Please Enter Exchange Rate Between "+invoiceForOwner.fromCurrency+" and "+
            invoiceForOwner.toCurrency+"<br><br>";      
            //invoiceForOwner.ExchangeRate=0;
            $scope.invoiceForOwner.ExchangeRate ='';
            isFlag = false;
          
        }
        var pinLength= invoiceForOwner.detailList.length;
        if(pinLength>0){
            
            loggerMsg = HdrLogErrMessage;
            if(loggerMsg !=""){
                isFlag = false;
                $scope.logValidExgRateErrorMessage = loggerMsg;                   
            }                   
        }         
        
        return isFlag;
    }
    
    /**
     * dropdown onchange
     */
    $scope.isFeederCompanyCurrency=false;
    $scope.selectedDropDown = function(userSelected) {
       switch (userSelected) {    
            case 'MloName':
                if(     $scope.invoiceForOwner.MloName=='PFOR0004' ||
                        $scope.invoiceForOwner.MloName=='PWAN0002'){
                    $scope.invoiceForOwner.CurrencyCode = 'AED';
                    $scope.invoiceForOwner.CurrencyName = 'AED';
                    $scope.invoiceForOwner.ExchangeRate =3.685;
                    $scope.invoiceForOwner.fromCurrency=3.660;
                    $scope.invoiceForOwner.toCurrency=3.686;
                }else if($scope.invoiceForOwner.MloName == 'PEVE0002'){
                    $scope.invoiceForOwner.CurrencyCode = 'AED';
                    $scope.invoiceForOwner.CurrencyName = 'AED';
                    $scope.invoiceForOwner.ExchangeRate =3.67;
                    $scope.invoiceForOwner.fromCurrency=3.660;
                    $scope.invoiceForOwner.toCurrency=3.686;
                }
                else{
                    var index = $scope.getIndex($scope.mloList, $scope.invoiceForOwner.MloName);
                    if(index !=undefined){
                      
                        $scope.invoiceForOwner.CurrencyCode = $scope.mloList[index].CurrencyCode;
                        $scope.invoiceForOwner.CurrencyName = $scope.mloList[index].CurrencyCode;
                        $http.get($stateParams.tenantid+'app/commonUtility/getExchangeRateWithCurrency?currencyCode='+ $scope.invoiceForOwner.CurrencyCode).success(function(data) {
                            //$scope.invoiceForOwner.ExchangeRate=data;                            
                            $scope.invoiceForOwner.ExchangeRate=data.exchangeRate;
                            $scope.invoiceForOwner.fromCurrency=data.fromCurrency;
                            $scope.invoiceForOwner.toCurrency=data.toCurrency;     
                        }).error(function(data) {
                        });
                    }
                }
               
                break;
                
            case 'VesselName':
                $scope.dataList = ListService.getVoyageList($scope.invoiceForOwner.VesselName);
                $scope.dataList.then(function(voyageLists) {
    
                    $scope.voyagehdrList = voyageLists;
    
                });
                break;
             
            case 'CompanyCode':
                debugger;
                $http.get($stateParams.tenantid+'app/generalinvoice/getCompanyCurrency?CompanyCode='+$scope.invoiceForOwner.CompanyCode).success(function(datas) {
                    $scope.companyCurrency=datas.CurrencyCode;
                    }).error(function(datas) {
                });
                if($scope.invoiceForOwner.CompanyCode=="C0001"){
                    $scope.isFeederCompanyCurrency=true;
                }else{
                    $scope.isFeederCompanyCurrency=false;
                }
                
                break;
                
            case 'Voyage':
                $scope.dataList = ListService.getPortList($scope.invoiceForOwner.Voyage);
                $scope.dataList.then(function(PortLists) {
                    $scope.PorthdrList = PortLists;
                });
    
                var index = $scope.getIndex($scope.voyagehdrList, $scope.invoiceForOwner.Voyage);
                $scope.invoiceForOwner.ServiceName = $scope.voyagehdrList[index].ServiceName;
                break;
                
                
            case 'Pol':
                debugger;
                $scope.dataList = ListService.getMloList($scope.invoiceForOwner.CustomerName,$scope.invoiceForOwner.Pol);
                $scope.dataList.then(function(mloLists) {
                    $scope.mloList = mloLists;
                    debugger;
                    console.log($scope.mloList);
                });
                break;
             
            case 'CustomerName':
                $scope.dataList = ListService.getMloList($scope.invoiceForOwner.CustomerName,$scope.invoiceForOwner.Pol);
                $scope.dataList.then(function(mloLists) {
                    $scope.mloList = mloLists;
                    debugger;
                    console.log($scope.mloList);
                });
                
                $scope.dataList = ListService.getBlList($scope.invoiceForOwner.Voyage,$scope.invoiceForOwner.Pol,$scope.invoiceForOwner.CustomerName);
                $scope.dataList.then(function(blLists) {
                    $scope.blList = blLists;
                });
                
            break;
            
            case 'bl':
                $http.get($stateParams.tenantid+'app/generalinvoice/fetchDetailList?bl='+$scope.invoiceForOwner.bl).success(function(datas) {
                    console.log("datas.GIDtl1111111111");
                    console.log(datas.GIDtl);
                    $scope.invoiceForOwner.detailList = datas.GIDtl;
                    }).error(function(datas) {
                });
                
            break;
            /*case 'ExchangeRate':   
                $scope.exchagerateGIhdr($scope.invoiceForOwner.ExchangeRate);    
                break;*/        
            case 'CurrencyName':   
                $scope.getcurrencyValues($scope.invoiceForOwner.CurrencyName);    
                
            break;
        }
    }

    $scope.getIndex = function(list, name) {
        var foundItem = $filter('filter')(list, {
            id : name
        }, true)[0];
        var index = list.indexOf(foundItem);
        return index;
    }

    $scope.invoiceForOwnerDtlList = function() {
        var giRow = {
                select : '',
                subAccountCode: '',
                subGroupCode: '',
                accountHead : '',
                narration : '',
                bcAmount : '',
                tcAmount : '',
                voyageCode : '',
                vesselCode : '',
                sectorCode : '',
                employeeCode :'',
                portCode :'',
                portSequence :'',
                departmentCode :'',
                agentCode :'',
                countryCode :'',
                customerCode:'',
                supplierCode:'',
                designationCode:'',
                costCenter :'',
                companyCode:'',
                quantityGO:'',
                quantityFO:'',
                isVoyage :false,
                isVessel :false,
                isService:false,
                isEmployee:false,
                isPort:false,
                isDepartment:false,
                isAgent:false,
                isLocation:false,
                isCustomer:false,
                isSupplier:false,
                isDesignation:false,
                isCostCenter:false,
                isCompany:false,
                isQuantityGO:false,
                isQuantityFO:false,
                isPortSequence:false,
                isSubAccountCode :false,
                attributeList :[]
        };
        $scope.invoiceForOwner.detailList.push(giRow);
    }

    $scope.invoiceForOwnerDtlList();
    
    $scope.addRow = function(gitable) {
        var table = {
                select : '',
                subAccountCode: '',
                subGroupCode: '',
                accountHead : '',
                narration : '',
                bcAmount : '',
                tcAmount : '',
                voyageCode : '',
                vesselCode : '',
                sectorCode : '',
                employeeCode :'',
                portCode :'',
                portSequence :'',
                departmentCode :'',
                agentCode :'',
                countryCode :'',
                customerCode:'',
                supplierCode:'',
                designationCode:'',
                costCenter :'',
                companyCode:'',
                quantityGO:'',
                quantityFO:'',
                isVoyage :false,
                isVessel :false,
                isService:false,
                isEmployee:false,
                isPort:false,
                isDepartment:false,
                isAgent:false,
                isLocation:false,
                isCustomer:false,
                isSupplier:false,
                isDesignation:false,
                isCostCenter:false,
                isCompany:false,
                isQuantityGO:false,
                isQuantityFO:false,
                isPortSequence:false,
                isSubAccountCode:false,
                attributeList :[]
        };
        
        gitable.push(table);
    };
    // removeRow
    $scope.removeRow = function(GItable) {
        debugger;
        $scope.tablerow = [];
        angular.forEach(GItable, function(row, index) {
            var check = row.select;
            if (check == undefined || check == "") {
                $scope.tablerow.push(row);
            } else {

            }
        });
        $scope.invoiceForOwner.detailList = $scope.tablerow;
    };
   
    $scope.getcurrencyValues = function(currencyValue){
        if(currencyValue!=null && currencyValue!=undefined && currencyValue!=""){
            $http.get($stateParams.tenantid+'app/commonUtility/getExchangeRateWithCurrency?currencyCode='+currencyValue).success(function(data) {
                debugger;
                //$scope.invoiceForOwner.ExchangeRate=data;                            
                $scope.invoiceForOwner.ExchangeRate=data.exchangeRate;
                $scope.invoiceForOwner.fromCurrency=data.fromCurrency;
                $scope.invoiceForOwner.toCurrency=data.toCurrency;     
            }).error(function(data) {
            });
        }else{
            $scope.invoiceForOwner.ExchangeRate='';
            $scope.invoiceForOwner.fromCurrency='';
            $scope.invoiceForOwner.toCurrency='';
        }
    }  
    
    $scope.exchagerateGIhdr = function(exchangeRate){
        debugger; 
        if(exchangeRate>0){
            if(parseFloat(exchangeRate) < $scope.invoiceForOwner.fromCurrency || parseFloat(exchangeRate) > $scope.invoiceForOwner.toCurrency){
                logger.logError("Please Enter Exchange Rate Between "+$scope.invoiceForOwner.fromCurrency+" and "+
                        $scope.invoiceForOwner.toCurrency);       
                $scope.invoiceForOwner.ExchangeRate=0;
            }else{
                var bcAmount=0.0, tcAmount=0.0;
                angular.forEach($scope.invoiceForOwner.detailList, function(giRow,giIndex){
                    debugger;
                    if(isNaN(parseFloat(giRow.tcAmount, 10))){
                        if(isNaN(parseFloat(giRow.bcAmount, 10))){
                          //  var bcAmt = (parseFloat(giRow.tcAmount) / exchangeRate);
                          //  var tcAmt = (parseFloat(giRow.bcAmount) * exchangeRate);
                            var bcAmt = Math.floor(((isNaN(parseFloat(giRow.tcAmount, 10))?0:giRow.tcAmount) / parseFloat(exchangeRate))*100)/100;
                            var tcAmt = Math.floor(((isNaN(parseFloat(giRow.bcAmount, 10))?0:giRow.bcAmount) * parseFloat(exchangeRate))*100)/100;
                            giRow.tcAmount = isNaN(tcAmt)?0:tcAmt.toFixed(2); 
                            giRow.bcAmount = isNaN(bcAmt)?0:bcAmt.toFixed(2); 
                        }else{
                           // var tcAmt = (parseFloat(giRow.bcAmount) * exchangeRate);
                            var tcAmt = Math.floor(((isNaN(parseFloat(giRow.bcAmount, 10))?0:giRow.bcAmount) * parseFloat(exchangeRate))*100)/100;
                            giRow.tcAmount = isNaN(tcAmt)?0:tcAmt.toFixed(2);  
                        }
                    }else {
                        //var bcAmt = (parseFloat(giRow.tcAmount) / exchangeRate);
                        //giRow.bcAmount = isNaN(bcAmt)?0:bcAmt.toFixed(2); 
                        var bcAmt = Math.floor(((isNaN(parseFloat( giRow.tcAmount, 10))?0: giRow.tcAmount) / parseFloat(exchangeRate))*100)/100;                    
                        giRow.bcAmount = parseFloat(bcAmt).toFixed(2);
                    } 
                });        
            }
              
            
        }
        $scope.calculateTotalAmount($scope.invoiceForOwner.detailList);
     }
    
    $scope.calculateTCtoBCAmount = function(tcAmount, trIndex, row) {
        debugger;
        if (tcAmount != null) {
            if ($scope.invoiceForOwner.ExchangeRate != 0 && $scope.invoiceForOwner.ExchangeRate != ""){
             // var bcAmount = (parseFloat(tcAmount) / $scope.invoiceForOwner.ExchangeRate).toFixed(2);
              var bcAmount = Math.floor(((isNaN(parseFloat( tcAmount, 10))?0: tcAmount) / parseFloat($scope.invoiceForOwner.ExchangeRate))*100)/100;
               row.bcAmount= isNaN(bcAmount)?0:bcAmount;
            }
            else{
                tcAmount = Math.floor(((isNaN(parseFloat( tcAmount, 10))?0: tcAmount))*100)/100;
                row.bcAmount = (parseFloat(tcAmount)).toFixed(2);
            }                
        } else {
            row.bcAmount = 0.0;
            row.tcAmount = 0.0;
        }
        $scope.calculateTotalAmount($scope.invoiceForOwner.detailList);
    };

    $scope.calculateBCtoTCAmount = function(bcAmount, trIndex, row) {
        debugger;
        if (bcAmount != null) {
            if ($scope.invoiceForOwner.ExchangeRate != 0 && $scope.invoiceForOwner.ExchangeRate != ""){
                //var tcAmt = (parseFloat(bcAmount) * $scope.invoiceForOwner.ExchangeRate).toFixed(2);
                var tcAmt = Math.floor(((isNaN(parseFloat( bcAmount, 10))?0: bcAmount) * parseFloat($scope.invoiceForOwner.ExchangeRate))*100)/100;
                row.tcAmount =isNaN(tcAmt)?0:tcAmt;
            }                
            else{
                bcAmount = Math.floor(((isNaN(parseFloat( bcAmount, 10))?0: bcAmount))*100)/100;
                var tcAmt = (parseFloat(bcAmount)).toFixed(2);
                row.tcAmount = isNaN(tcAmt)?0:tcAmt;
            }
                
        } else {
            row.bcAmount = 0.0;
            row.tcAmount = 0.0;
        }
        $scope.calculateTotalAmount($scope.invoiceForOwner.detailList);
    };
    
    $scope.calculateTotalAmount = function(tables) {
        debugger;
        var TotalBCamount = 0.0, TotalTCamount = 0.0;
        angular.forEach(tables, function(row, index) {
            TotalBCamount = (parseFloat(TotalBCamount) + parseFloat(row.bcAmount)).toFixed(2);
            TotalTCamount = (parseFloat(TotalTCamount) + parseFloat(row.tcAmount)).toFixed(2);
        });
        $scope.invoiceForOwner.TotalBCamount = TotalBCamount;
        $scope.invoiceForOwner.TotalTCamount = TotalTCamount;
    };
    
    $scope.getEdit = function(sInvoiceNo) {
        var url = $stateParams.tenantid+'app/generalinvoice/edit?invoiceForOwnerNo=' + sInvoiceNo;
        $http.get(url).success(function(result) {
            debugger;
            $scope.invoiceForOwner.InvoiceDate = result.InvoiceDate;
            $scope.invoiceForOwner.bLlist= result.bLlist;
            $scope.invoiceForOwner.customerList= result.customerList;
            $scope.mloList= result.mloList;
            $scope.invoiceForOwner.voyagehdrList= result.voyageList;
            $scope.invoiceForOwner.porthdrList= result.portList;
            $scope.invoiceForOwner.VesselhdrList= result.vesselList;

            $scope.invoiceForOwner.BlRelated = result.BlRelated;
            $scope.invoiceForOwner.Company = result.Company;
            $scope.invoiceForOwner.CompanyCode = result.CompanyCode;
            $scope.invoiceForOwner.CurrencyCode = result.CurrencyCode;
            $scope.invoiceForOwner.CurrencyName = result.CurrencyName;
            $scope.invoiceForOwner.CustomerCode = result.CustomerCode;
            $scope.invoiceForOwner.CustomerName = result.CustomerName;
            $scope.invoiceForOwner.ExchangeRate = result.ExchangeRate;
           
           // $scope.getcurrencyValues($scope.invoiceForOwner.CurrencyName);
            var date= result.InvoiceDate;
            var d=new Date(date.split("-").reverse().join("/"));
            var dd=d.getDate();
            var mm=d.getMonth()+1;
            var yy=d.getFullYear();
            var invoiceFormattedDate=dd+"/"+mm+"/"+yy;
            
            $scope.invoiceForOwner.InvoiceDate = invoiceFormattedDate;
            $scope.invoiceForOwner.InvoiceNo = result.InvoiceNo;
           // $scope.invoiceForOwner.MloCode = result.MloName;
            $scope.invoiceForOwner.MloName = result.MloName;
            $scope.invoiceForOwner.Pod = result.Pod;
            $scope.invoiceForOwner.Pol = result.Pol;
            $scope.invoiceForOwner.Port = result.Port;
            $scope.invoiceForOwner.PortSequence = result.PortSequence;
            $scope.invoiceForOwner.ServiceCode = result.ServiceCode;
            $scope.invoiceForOwner.ServiceName = result.ServiceName;
            $scope.invoiceForOwner.Subject = result.Subject;
            /*$scope.invoiceForOwner.TotalBCamount = result.TotalBCamount;
            $scope.invoiceForOwner.TotalTCamount = result.TotalTCamount;*/
            $scope.invoiceForOwner.Unit20 = result.Unit20;
            $scope.invoiceForOwner.Unit40 = result.Unit40;
            //$scope.invoiceForOwner.VesselCode = result.VesselCode;
            $scope.invoiceForOwner.VesselName = result.VesselName;
            $scope.invoiceForOwner.Voyage = result.Voyage;
            
            $scope.invoiceForOwner.detailList = result.detailList;
            
            $scope.calculateTotalAmount($scope.invoiceForOwner.detailList);

        }).error(function(result) {
            logger.logError("Error Please Try Again");
        });

    }

    /*var InvoiceNo=$stateParams.InvoiceNo;
    if(InvoiceNo == undefined || InvoiceNo == null || InvoiceNo ==""){
        $scope.invoiceForOwner.isEdit=false;
    }else{
        $scope.invoiceForOwner.isEdit =true;
        $scope.getEdit(InvoiceNo);
    }*/
    

});

app.service("ListService", function($http, $q,$stateParams) {

    this.getCustomerList = function() {
        var customerList = $q.defer();
        $http.get($stateParams.tenantid+'app/generalinvoice/getCustomerList').success(function(data) {
            customerList.resolve(data);
        }).error(function(data) {
            customerList.reject("Failed to get Customer List");
        });
        return customerList.promise;
    }

    this.getMloList = function(customerCode,pol) {
        var mloList = $q.defer();
        $http.get($stateParams.tenantid+'app/generalinvoice/getMloList?CustomerCode=' + customerCode+'&pol=' +pol).success(function(data) {
            mloList.resolve(data);
            

        }).error(function(data) {

            mloList.reject("Failed to get Mlo List");

        });
        return mloList.promise;
    }

    this.getVesselList = function() {
        var voyageList = $q.defer();
        $http.get($stateParams.tenantid+'app/generalinvoice/getVesselList').success(function(data) {
            voyageList.resolve(data);

        }).error(function(data) {

            voyageList.reject("Failed to get Voyage Vessel List");

        });
        return voyageList.promise;
    }
    this.getVoyageList = function(vesselCode) {
        var voyageList = $q.defer();
        $http.get($stateParams.tenantid+'app/generalinvoice/getVoyageList?vesselCode=' + vesselCode).success(function(data) {
            voyageList.resolve(data);

        }).error(function(data) {

            voyageList.reject("Failed to get Voyage Vessel List");

        });
        return voyageList.promise;
    }

    this.getCompanyCurrency = function(companyCode) {
        var voyageList = $q.defer();
        $http.get($stateParams.tenantid+'app/generalinvoice/getVoyageList?vesselCode=' + vesselCode).success(function(data) {
            voyageList.resolve(data);

        }).error(function(data) {

            voyageList.reject("Failed to get Voyage Vessel List");

        });
        return voyageList.promise;
    }
    
    this.getBlList = function(VoyageId,pol,customer) {
        var blList = $q.defer();
        $http.get($stateParams.tenantid+'app/generalinvoice/getBlList?voyageCode=' + VoyageId+'&pol=' +pol+'&customer='+customer).success(function(data) {
            blList.resolve(data);

        }).error(function(data) {

            blList.reject("Failed to get Mlo List");

        });
        return blList.promise;
    }

    this.getPortList = function(VoyageId) {

        var portList = $q.defer();
        $http.get($stateParams.tenantid+'app/generalinvoice/getportList?voyageCode=' + VoyageId).success(function(data) {
            portList.resolve(data);

        }).error(function(data) {

            portList.reject("Failed to get portList List");

        });
        return portList.promise;
    }
    
    this.getSubAccountList = function(){
        var subAccountList = $q.defer();
        $http.get($stateParams.tenantid+'app/commonUtility/getSubAccountCodeList').success(function(datas) {
            subAccountList.resolve(datas.commonUtilityBean);
        }).error(function(data) {
            subAccountList.reject("Failed to get Sub Account Code List");
        });
        return subAccountList.promise;
    }
    
    this.getAccountHeadList = function() {

        var accountHeadList = $q.defer();
        $http.get($stateParams.tenantid+'app/generalinvoice/getAccountHeadList').success(function(data) {
            accountHeadList.resolve(data);

        }).error(function(data) {

            accountHeadList.reject("Failed to get Account head List");

        });
        return accountHeadList.promise;
    }

    this.getDateInDDMMYYYY = function convert(str) {
        var date = new Date(str), mnth = ("0" + (date.getMonth() + 1)).slice(-2), day = ("0" + date.getDate()).slice(-2);
        return [ day, mnth, date.getFullYear() ].join("-");
    }
});

app.controller('GItableCtrl', function($scope,$http, $filter,logger,$stateParams){
    debugger;
    $scope.$watch('invoiceForOwner.detailList[trIndex].voyageCode', function(newValue, oldValue) {
        debugger;
        if (newValue != '' && newValue != undefined) {
                $http.get($stateParams.tenantid+'app/commonUtility/getVesselService?voyageCode='+newValue).success(function(datas) {
                    $scope.invoiceForOwner.detailList[$scope.$index].vesselCode=datas.vesselCode;
                    $scope.invoiceForOwner.detailList[$scope.$index].sectorCode=datas.sectorCode;
                    }).error(function(datas) {
                });
       
        }
    });
    
    $scope.$watch('invoiceForOwner.detailList[trIndex].accountHead', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
            
            if(newValue == '10080001'){
                $http.get($stateParams.tenantid+'app/commonUtility/getSubAccountCodeListTradeDebtors').success(function(datas) {
                    $scope.invoiceForOwner.detailList[$scope.$index].subAccountCodeList = datas;
                    $scope.invoiceForOwner.detailList[$scope.$index].isSubAccountCode =true;
                    }).error(function(datas) {
                });
            }else if(newValue == '20010001'){
                $http.get($stateParams.tenantid+'app/commonUtility/getSubAccountCodeListTradeCreditors').success(function(datas) {
                    $scope.invoiceForOwner.detailList[$scope.$index].subAccountCodeList = datas;
                    $scope.invoiceForOwner.detailList[$scope.$index].isSubAccountCode =true;
                    }).error(function(datas) {
                });   
            }else if(newValue == '10070001'){
                $http.get($stateParams.tenantid+'app/commonUtility/getStaffListForAdvances').success(function(datas) {
                    $scope.invoiceForOwner.detailList[$scope.$index].subAccountCodeList = datas;
                    $scope.invoiceForOwner.detailList[$scope.$index].isSubAccountCode =true;
                    }).error(function(datas) {
                });   
            }else if(newValue == '10090017'){
                $http.get($stateParams.tenantid+'app/commonUtility/getonlySupplier').success(function(datas) {
                    $scope.invoiceForOwner.detailList[$scope.$index].subAccountCodeList = datas;
                    $scope.invoiceForOwner.detailList[$scope.$index].isSubAccountCode =true;
                    }).error(function(datas) {
                });   
            }else{
                $scope.invoiceForOwner.detailList[$scope.$index].subAccountCodeList=[];
                $scope.invoiceForOwner.detailList[$scope.$index].isSubAccountCode =false;
            }
            
                $http.get($stateParams.tenantid+'app/commonUtility/getAttributesList?accountCode='+newValue).success(function(datas) {
                $scope.invoiceForOwner.detailList[$scope.$index].attributeList=datas;
                if(newValue==oldValue){
                    $scope.isOnChange =false;
                }else{
                    $scope.isOnChange =true;
                }
                if(!$scope.invoiceForOwner.isEdit || $scope.isOnChange){
                
                     
                $scope.invoiceForOwner.detailList[$scope.$index].voyageCode='';
                $scope.invoiceForOwner.detailList[$scope.$index].vesselCode='';
                $scope.invoiceForOwner.detailList[$scope.$index].sectorCode='';
                $scope.invoiceForOwner.detailList[$scope.$index].employeeCode='';
                $scope.invoiceForOwner.detailList[$scope.$index].portCode='';
                $scope.invoiceForOwner.detailList[$scope.$index].portSequence='';
                $scope.invoiceForOwner.detailList[$scope.$index].departmentCode='';
                $scope.invoiceForOwner.detailList[$scope.$index].agentCode='';
                $scope.invoiceForOwner.detailList[$scope.$index].countryCode='';
                $scope.invoiceForOwner.detailList[$scope.$index].customerCode='';
                $scope.invoiceForOwner.detailList[$scope.$index].supplierCode='';
                $scope.invoiceForOwner.detailList[$scope.$index].designationCode='';
                $scope.invoiceForOwner.detailList[$scope.$index].costCenter='';
                $scope.invoiceForOwner.detailList[$scope.$index].companyCode='';
                $scope.invoiceForOwner.detailList[$scope.$index].quantityGO='';
                $scope.invoiceForOwner.detailList[$scope.$index].quantityFO='';
                }
                
                $scope.invoiceForOwner.detailList[$scope.$index].isVoyage=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isVessel=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isService=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isEmployee=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isPort=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isDepartment=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isAgent=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isLocation=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isCustomer=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isSupplier=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isDesignation=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isCostCenter=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isCompany=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isQuantityGO=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isQuantityFO=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isPortSequence=false;
             
                // code added for mandatory
                $scope.invoiceForOwner.detailList[$scope.$index].isVoyageMan=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isVesselMan=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isServiceMan=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isEmployeeMan=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isPortMan=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isDepartmentMan=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isAgentMan=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isLocationMan=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isCustomerMan=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isSupplierMan=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isDesignationMan=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isCostCenterMan=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isQuantityGOMan=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isQuantityFOMan=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isPortSequenceMan=false;
                
                angular.forEach($scope.invoiceForOwner.detailList[$scope.$index].attributeList, function(row, rowindex) {
                    debugger;
                    if(row.attributeName == "Voyage"){
                        $scope.invoiceForOwner.detailList[$scope.$index].isVoyage=true;
                        
                        /*if($scope.invoiceForOwner.Voyage !='')
                            $scope.invoiceForOwner.detailList[$scope.$index].voyageCode=$scope.invoiceForOwner.Voyage;*/
                        
                        if(row.isMandatory == 'Y'){
                            if($scope.isOwner)
                                $scope.invoiceForOwner.detailList[$scope.$index].isVoyageMan=false;
                            else
                                $scope.invoiceForOwner.detailList[$scope.$index].isVoyageMan=true; 
                        }
                    }else if(row.attributeName == "Vessel"){
                        $scope.invoiceForOwner.detailList[$scope.$index].isVessel=true;
                        
                        /*if($scope.invoiceForOwner.VesselName!='')
                            $scope.invoiceForOwner.detailList[$scope.$index].vesselCode =$scope.invoiceForOwner.VesselName;*/
                        
                        if(row.isMandatory == 'Y'){
                            if($scope.isOwner)
                                $scope.invoiceForOwner.detailList[$scope.$index].isVesselMan=false;
                            else
                                $scope.invoiceForOwner.detailList[$scope.$index].isVesselMan=true;
                        }
                    }else if(row.attributeName == "Service"){
                        $scope.invoiceForOwner.detailList[$scope.$index].isService=true;
                        if(row.isMandatory == 'Y'){
                            if($scope.isOwner)
                                $scope.invoiceForOwner.detailList[$scope.$index].isServiceMan=false;
                            else
                                $scope.invoiceForOwner.detailList[$scope.$index].isServiceMan=true;
                        }
                    }else if(row.attributeName == "Employee"){
                        $scope.invoiceForOwner.detailList[$scope.$index].isEmployee=true;
                        if(row.isMandatory == 'Y'){
                            $scope.invoiceForOwner.detailList[$scope.$index].isEmployeeMan=true;
                        }
                    }else if(row.attributeName == "Port"){
                        $scope.invoiceForOwner.detailList[$scope.$index].isPort=true;
                        if(row.isMandatory == 'Y'){
                            $scope.invoiceForOwner.detailList[$scope.$index].isPortMan=true;
                        }
                    }else if(row.attributeName == "Department"){
                        $scope.invoiceForOwner.detailList[$scope.$index].isDepartment=true;
                        if(row.isMandatory == 'Y'){
                            $scope.invoiceForOwner.detailList[$scope.$index].isDepartmentMan=true;
                        }
                    }else if(row.attributeName == "Agent"){
                        $scope.invoiceForOwner.detailList[$scope.$index].isAgent=true;
                        if(row.isMandatory == 'Y'){
                            $scope.invoiceForOwner.detailList[$scope.$index].isAgentMan=true;
                        }
                    }else if(row.attributeName == "Location"){
                        $scope.invoiceForOwner.detailList[$scope.$index].isLocation=true;
                        if(row.isMandatory == 'Y'){
                            $scope.invoiceForOwner.detailList[$scope.$index].isLocationMan=true;
                        }
                    }else if(row.attributeName == "Customer"){
                        $scope.invoiceForOwner.detailList[$scope.$index].isCustomer=true;
                        if(row.isMandatory == 'Y'){
                            $scope.invoiceForOwner.detailList[$scope.$index].isCustomerMan=true;
                        }
                    }else if(row.attributeName == "Supplier"){
                        $scope.invoiceForOwner.detailList[$scope.$index].isSupplier=true;
                        if(row.isMandatory == 'Y'){
                            $scope.invoiceForOwner.detailList[$scope.$index].isSupplierMan=true;
                        }
                    }else if(row.attributeName == "Designation"){
                        $scope.invoiceForOwner.detailList[$scope.$index].isDesignation=true;
                        if(row.isMandatory == 'Y'){
                            $scope.invoiceForOwner.detailList[$scope.$index].isDesignationMan=true;
                        }
                    }else if(row.attributeName == "Cost Center"){
                        $scope.invoiceForOwner.detailList[$scope.$index].isCostCenter=true;
                        if(row.isMandatory == 'Y'){
                            $scope.invoiceForOwner.detailList[$scope.$index].isCostCenterMan=true;
                        }
                    }else if(row.attributeName == "Company"){
                        $scope.invoiceForOwner.detailList[$scope.$index].isCompany=true;
                        if(row.isMandatory == 'Y'){
                            $scope.invoiceForOwner.detailList[$scope.$index].isCompanyMan=true;
                        }
                    }else if(row.attributeName == "Quantity (MT) GO"){
                        $scope.invoiceForOwner.detailList[$scope.$index].isQuantityGO=true;
                        if(row.isMandatory == 'Y'){
                            $scope.invoiceForOwner.detailList[$scope.$index].isQuantityGOMan=true;
                        }
                    }else if(row.attributeName == "Quantity (MT) FO"){
                        $scope.invoiceForOwner.detailList[$scope.$index].isQuantityFO=true;
                        if(row.isMandatory == 'Y'){
                            $scope.invoiceForOwner.detailList[$scope.$index].isQuantityFOMan=true;
                        }
                    }else if(row.attributeName == "Port with Sequence"){
                        $scope.invoiceForOwner.detailList[$scope.$index].isPortSequence=true;
                        if(row.isMandatory == 'Y'){
                            $scope.invoiceForOwner.detailList[$scope.$index].isPortSequenceMan=true;
                        }
                    }
                    });
                }).error(function(datas) {
            });
        }else{
            $scope.invoiceForOwner.detailList[$scope.$index].subAccountCodeList=[];
        
        }
    });
});

app.controller('GItableCtrl', function($scope,$http, $filter,logger,$stateParams){
    debugger;
    $scope.$watch('invoiceForOwner.detailList[trIndex].voyageCode', function(newValue, oldValue) {
        debugger;
        if (newValue != '' && newValue != undefined) {
                $http.get($stateParams.tenantid+'app/commonUtility/getVesselService?voyageCode='+newValue).success(function(datas) {
                    $scope.invoiceForOwner.detailList[$scope.$index].vesselCode=datas.vesselCode;
                    $scope.invoiceForOwner.detailList[$scope.$index].sectorCode=datas.sectorCode;
                    }).error(function(datas) {
                });
       
        }
    });
    
    $scope.$watch('invoiceForOwner.detailList[trIndex].accountHead', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
            
            if(newValue == '10080001'){
                $http.get($stateParams.tenantid+'app/commonUtility/getSubAccountCodeListTradeDebtors').success(function(datas) {
                    $scope.invoiceForOwner.detailList[$scope.$index].subAccountCodeList = datas;
                    $scope.invoiceForOwner.detailList[$scope.$index].isSubAccountCode =true;
                    }).error(function(datas) {
                });
            }else if(newValue == '20010001'){
                $http.get($stateParams.tenantid+'app/commonUtility/getSubAccountCodeListTradeCreditors').success(function(datas) {
                    $scope.invoiceForOwner.detailList[$scope.$index].subAccountCodeList = datas;
                    $scope.invoiceForOwner.detailList[$scope.$index].isSubAccountCode =true;
                    }).error(function(datas) {
                });   
            }else if(newValue == '10070001'){
                $http.get($stateParams.tenantid+'app/commonUtility/getStaffListForAdvances').success(function(datas) {
                    $scope.invoiceForOwner.detailList[$scope.$index].subAccountCodeList = datas;
                    $scope.invoiceForOwner.detailList[$scope.$index].isSubAccountCode =true;
                    }).error(function(datas) {
                });   
            }else if(newValue == '10090017'){
                $http.get($stateParams.tenantid+'app/commonUtility/getonlySupplier').success(function(datas) {
                    $scope.invoiceForOwner.detailList[$scope.$index].subAccountCodeList = datas;
                    $scope.invoiceForOwner.detailList[$scope.$index].isSubAccountCode =true;
                    }).error(function(datas) {
                });   
            }else{
                $scope.invoiceForOwner.detailList[$scope.$index].subAccountCodeList=[];
                $scope.invoiceForOwner.detailList[$scope.$index].isSubAccountCode =false;
            }
            
                $http.get($stateParams.tenantid+'app/commonUtility/getAttributesList?accountCode='+newValue).success(function(datas) {
                $scope.invoiceForOwner.detailList[$scope.$index].attributeList=datas;
                if(newValue==oldValue){
                    $scope.isOnChange =false;
                }else{
                    $scope.isOnChange =true;
                }
                if(!$scope.invoiceForOwner.isEdit || $scope.isOnChange){
                
                     
                $scope.invoiceForOwner.detailList[$scope.$index].voyageCode='';
                $scope.invoiceForOwner.detailList[$scope.$index].vesselCode='';
                $scope.invoiceForOwner.detailList[$scope.$index].sectorCode='';
                $scope.invoiceForOwner.detailList[$scope.$index].employeeCode='';
                $scope.invoiceForOwner.detailList[$scope.$index].portCode='';
                $scope.invoiceForOwner.detailList[$scope.$index].portSequence='';
                $scope.invoiceForOwner.detailList[$scope.$index].departmentCode='';
                $scope.invoiceForOwner.detailList[$scope.$index].agentCode='';
                $scope.invoiceForOwner.detailList[$scope.$index].countryCode='';
                $scope.invoiceForOwner.detailList[$scope.$index].customerCode='';
                $scope.invoiceForOwner.detailList[$scope.$index].supplierCode='';
                $scope.invoiceForOwner.detailList[$scope.$index].designationCode='';
                $scope.invoiceForOwner.detailList[$scope.$index].costCenter='';
                $scope.invoiceForOwner.detailList[$scope.$index].companyCode='';
                $scope.invoiceForOwner.detailList[$scope.$index].quantityGO='';
                $scope.invoiceForOwner.detailList[$scope.$index].quantityFO='';
                }
                
                $scope.invoiceForOwner.detailList[$scope.$index].isVoyage=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isVessel=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isService=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isEmployee=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isPort=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isDepartment=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isAgent=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isLocation=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isCustomer=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isSupplier=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isDesignation=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isCostCenter=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isCompany=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isQuantityGO=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isQuantityFO=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isPortSequence=false;
             
                // code added for mandatory
                $scope.invoiceForOwner.detailList[$scope.$index].isVoyageMan=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isVesselMan=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isServiceMan=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isEmployeeMan=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isPortMan=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isDepartmentMan=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isAgentMan=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isLocationMan=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isCustomerMan=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isSupplierMan=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isDesignationMan=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isCostCenterMan=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isQuantityGOMan=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isQuantityFOMan=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isPortSequenceMan=false;
                
                angular.forEach($scope.invoiceForOwner.detailList[$scope.$index].attributeList, function(row, rowindex) {
                    debugger;
                    if(row.attributeName == "Voyage"){
                        $scope.invoiceForOwner.detailList[$scope.$index].isVoyage=true;
                        
                        if($scope.invoiceForOwner.Voyage !='')
                            $scope.invoiceForOwner.detailList[$scope.$index].voyageCode=$scope.invoiceForOwner.Voyage;
                        
                        if(row.isMandatory == 'Y'){
                            $scope.invoiceForOwner.detailList[$scope.$index].isVoyageMan=true;
                        }
                    }else if(row.attributeName == "Vessel"){
                        $scope.invoiceForOwner.detailList[$scope.$index].isVessel=true;
                        
                        if($scope.invoiceForOwner.VesselName!='')
                            $scope.invoiceForOwner.detailList[$scope.$index].vesselCode =$scope.invoiceForOwner.VesselName;
                        
                        if(row.isMandatory == 'Y'){
                            $scope.invoiceForOwner.detailList[$scope.$index].isVesselMan=true;
                        }
                    }else if(row.attributeName == "Service"){
                        $scope.invoiceForOwner.detailList[$scope.$index].isService=true;
                        if(row.isMandatory == 'Y'){
                            $scope.invoiceForOwner.detailList[$scope.$index].isServiceMan=true;
                        }
                    }else if(row.attributeName == "Employee"){
                        $scope.invoiceForOwner.detailList[$scope.$index].isEmployee=true;
                        if(row.isMandatory == 'Y'){
                            $scope.invoiceForOwner.detailList[$scope.$index].isEmployeeMan=true;
                        }
                    }else if(row.attributeName == "Port"){
                        $scope.invoiceForOwner.detailList[$scope.$index].isPort=true;
                        if(row.isMandatory == 'Y'){
                            $scope.invoiceForOwner.detailList[$scope.$index].isPortMan=true;
                        }
                    }else if(row.attributeName == "Department"){
                        $scope.invoiceForOwner.detailList[$scope.$index].isDepartment=true;
                        if(row.isMandatory == 'Y'){
                            $scope.invoiceForOwner.detailList[$scope.$index].isDepartmentMan=true;
                        }
                    }else if(row.attributeName == "Agent"){
                        $scope.invoiceForOwner.detailList[$scope.$index].isAgent=true;
                        if(row.isMandatory == 'Y'){
                            $scope.invoiceForOwner.detailList[$scope.$index].isAgentMan=true;
                        }
                    }else if(row.attributeName == "Location"){
                        $scope.invoiceForOwner.detailList[$scope.$index].isLocation=true;
                        if(row.isMandatory == 'Y'){
                            $scope.invoiceForOwner.detailList[$scope.$index].isLocationMan=true;
                        }
                    }else if(row.attributeName == "Customer"){
                        $scope.invoiceForOwner.detailList[$scope.$index].isCustomer=true;
                        if(row.isMandatory == 'Y'){
                            $scope.invoiceForOwner.detailList[$scope.$index].isCustomerMan=true;
                        }
                    }else if(row.attributeName == "Supplier"){
                        $scope.invoiceForOwner.detailList[$scope.$index].isSupplier=true;
                        if(row.isMandatory == 'Y'){
                            $scope.invoiceForOwner.detailList[$scope.$index].isSupplierMan=true;
                        }
                    }else if(row.attributeName == "Designation"){
                        $scope.invoiceForOwner.detailList[$scope.$index].isDesignation=true;
                        if(row.isMandatory == 'Y'){
                            $scope.invoiceForOwner.detailList[$scope.$index].isDesignationMan=true;
                        }
                    }else if(row.attributeName == "Cost Center"){
                        $scope.invoiceForOwner.detailList[$scope.$index].isCostCenter=true;
                        if(row.isMandatory == 'Y'){
                            $scope.invoiceForOwner.detailList[$scope.$index].isCostCenterMan=true;
                        }
                    }else if(row.attributeName == "Company"){
                        $scope.invoiceForOwner.detailList[$scope.$index].isCompany=true;
                        if(row.isMandatory == 'Y'){
                            $scope.invoiceForOwner.detailList[$scope.$index].isCompanyMan=true;
                        }
                    }else if(row.attributeName == "Quantity (MT) GO"){
                        $scope.invoiceForOwner.detailList[$scope.$index].isQuantityGO=true;
                        if(row.isMandatory == 'Y'){
                            $scope.invoiceForOwner.detailList[$scope.$index].isQuantityGOMan=true;
                        }
                    }else if(row.attributeName == "Quantity (MT) FO"){
                        $scope.invoiceForOwner.detailList[$scope.$index].isQuantityFO=true;
                        if(row.isMandatory == 'Y'){
                            $scope.invoiceForOwner.detailList[$scope.$index].isQuantityFOMan=true;
                        }
                    }else if(row.attributeName == "Port with Sequence"){
                        $scope.invoiceForOwner.detailList[$scope.$index].isPortSequence=true;
                        if(row.isMandatory == 'Y'){
                            $scope.invoiceForOwner.detailList[$scope.$index].isPortSequenceMan=true;
                        }
                    }
                    });
                }).error(function(datas) {
            });
        }else{
            $scope.invoiceForOwner.detailList[$scope.$index].subAccountCodeList=[];
        
        }
    });
});

app.controller('invoiceForOwnerViewCtrl', function($scope, $window, $rootScope, $location, $filter, $http, logger, 
        $log, ngDialog, $modal, utilsService, ListService, $stateParams,$timeout,validationService,toaster,$state) {
    
    $scope.invoiceForOwner = {
            invoiceNo:'', invoiceDate:'', company:'', companyCode:'', blRelated:'', customerName:'', customerCode:'',
            mloCode:'', mloName:'', subject:'', currencyName:'', currencyCode:'', exchangeRate:'',
            voyage:'', vesselCode:'', vesselName:'', serviceCode:'', serviceName:'', unit20:'', unit40:'', pol:'', pod:'',
            sailingDate:'', bl:'', port:'', portSequence:'', accountHeadName:'', accountHeadCode:'', 
            TotalBCamount:'', TotalTCamount:'', detailList:[],

            customerAddress:'', customerPhoneNo:'', customerFaxNo:'', customerEmail:'', companyAddress:'',
            companyPhoneNo:'', companyFaxNo:'', companyEmail:'', companyCurrency:'',
        }
    
    $scope.invoiceForOwnerDtlList = function() {
        var giRow = {
                select : '',
                subAccountCode: '',  subGroupCode: '', accountHead : '', narration : '', bcAmount : '',
                tcAmount : '', voyageCode : '', vesselCode : '', sectorCode : '', employeeCode :'',
                portCode :'', portSequence :'', departmentCode :'', agentCode :'', countryCode :'',
                customerCode:'', supplierCode:'', designationCode:'', costCenter :'', companyCode:'',
                quantityGO:'', quantityFO:'', 
                isVoyage :false, isVessel :false, isService:false, isEmployee:false, isPort:false,
                isDepartment:false, isAgent:false, isLocation:false, isCustomer:false, isSupplier:false,
                isDesignation:false, isCostCenter:false, isCompany:false, isQuantityGO:false, isQuantityFO:false,
                isPortSequence:false, isSubAccountCode :false,
                attributeList :[]
        };
    }
    $scope.invoiceForOwnerDtlList();
    
    $scope.viewDisable =true;
    var invoiceNo=$stateParams.invoiceNo;
    if(invoiceNo == undefined || invoiceNo == null || invoiceNo ==""){
        $scope.viewDisable=false;
    }else{
            var url = $stateParams.tenantid+'app/InvoiceForOwner/getInvoiceView?invoiceNo=' + invoiceNo;
            $http.get(url).success(function(result) {
                console.log("result******");
                console.log(result);
                $scope.invoiceForOwner = result;
            }).error(function(result) {
                logger.logError("Error Please Try Again");
            });
    }
    
    /**
     * print
     */
    $scope.printinvoiceForOwner = function(invoiceNo){
        var url = $stateParams.tenantid+'app/InvoiceForOwner/print?invoiceNo=' + invoiceNo;
        var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
        wnd.print();   
     }

    $scope.cancel = function() {
        $location.path($stateParams.tenantid+"/invoice/invoiceForOwner/list");
    };
});

app.controller('detailViewCtrl', function($scope,$http, $filter,logger,$stateParams){
    
    $scope.$watch('invoiceForOwner.detailList[trIndex].accountHead', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
            if(newValue == '10080001'){
                $http.get($stateParams.tenantid+'app/commonUtility/getSubAccountCodeListTradeDebtors').success(function(datas) {
                    $scope.invoiceForOwner.detailList[$scope.$index].subAccountCodeList = datas;
                    $scope.invoiceForOwner.detailList[$scope.$index].isSubAccountCode =true;
                    }).error(function(datas) {
                });
            }else if(newValue == '20010001'){
                $http.get($stateParams.tenantid+'app/commonUtility/getSubAccountCodeListTradeCreditors').success(function(datas) {
                    $scope.invoiceForOwner.detailList[$scope.$index].subAccountCodeList = datas;
                    $scope.invoiceForOwner.detailList[$scope.$index].isSubAccountCode =true;
                    }).error(function(datas) {
                });   
            }else if(newValue == '10070001'){
                $http.get($stateParams.tenantid+'app/commonUtility/getStaffListForAdvances').success(function(datas) {
                    $scope.invoiceForOwner.detailList[$scope.$index].subAccountCodeList = datas;
                    $scope.invoiceForOwner.detailList[$scope.$index].isSubAccountCode =true;
                    }).error(function(datas) {
                });   
            }else{
                $scope.invoiceForOwner.detailList[$scope.$index].subAccountCodeList=[];
                $scope.invoiceForOwner.detailList[$scope.$index].isSubAccountCode =false;
            }
            
                $http.get($stateParams.tenantid+'app/commonUtility/getAttributesList?accountCode='+newValue).success(function(datas) {
                $scope.invoiceForOwner.detailList[$scope.$index].attributeList=datas;
                if(newValue==oldValue){
                    $scope.isOnChange =false;
                }else{
                    $scope.isOnChange =true;
                }
                if(!$scope.viewDisable || $scope.isOnChange){
                    $scope.invoiceForOwner.detailList[$scope.$index].voyageCode='';
                    $scope.invoiceForOwner.detailList[$scope.$index].vesselCode='';
                    $scope.invoiceForOwner.detailList[$scope.$index].sectorCode='';
                    $scope.invoiceForOwner.detailList[$scope.$index].employeeCode='';
                    $scope.invoiceForOwner.detailList[$scope.$index].portCode='';
                    $scope.invoiceForOwner.detailList[$scope.$index].portSequence='';
                    $scope.invoiceForOwner.detailList[$scope.$index].departmentCode='';
                    $scope.invoiceForOwner.detailList[$scope.$index].agentCode='';
                    $scope.invoiceForOwner.detailList[$scope.$index].countryCode='';
                    $scope.invoiceForOwner.detailList[$scope.$index].customerCode='';
                    $scope.invoiceForOwner.detailList[$scope.$index].supplierCode='';
                    $scope.invoiceForOwner.detailList[$scope.$index].designationCode='';
                    $scope.invoiceForOwner.detailList[$scope.$index].costCenter='';
                    $scope.invoiceForOwner.detailList[$scope.$index].companyCode='';
                    $scope.invoiceForOwner.detailList[$scope.$index].quantityGO='';
                    $scope.invoiceForOwner.detailList[$scope.$index].quantityFO='';
                }
                
                $scope.invoiceForOwner.detailList[$scope.$index].isVoyage=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isVessel=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isService=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isEmployee=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isPort=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isDepartment=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isAgent=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isLocation=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isCustomer=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isSupplier=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isDesignation=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isCostCenter=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isCompany=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isQuantityGO=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isQuantityFO=false;
                $scope.invoiceForOwner.detailList[$scope.$index].isPortSequence=false;
             
                angular.forEach($scope.invoiceForOwner.detailList[$scope.$index].attributeList, function(row, rowindex) {
                    if(row.attributeName == "Voyage"){
                        $scope.invoiceForOwner.detailList[$scope.$index].isVoyage=true;
                    }else if(row.attributeName == "Vessel"){
                        $scope.invoiceForOwner.detailList[$scope.$index].isVessel=true;
                    }else if(row.attributeName == "Service"){
                        $scope.invoiceForOwner.detailList[$scope.$index].isService=true;
                    }else if(row.attributeName == "Employee"){
                        $scope.invoiceForOwner.detailList[$scope.$index].isEmployee=true;
                    }else if(row.attributeName == "Port"){
                        $scope.invoiceForOwner.detailList[$scope.$index].isPort=true;
                    }else if(row.attributeName == "Department"){
                        $scope.invoiceForOwner.detailList[$scope.$index].isDepartment=true;
                    }else if(row.attributeName == "Agent"){
                        $scope.invoiceForOwner.detailList[$scope.$index].isAgent=true;
                    }else if(row.attributeName == "Location"){
                        $scope.invoiceForOwner.detailList[$scope.$index].isLocation=true;
                    }else if(row.attributeName == "Customer"){
                        $scope.invoiceForOwner.detailList[$scope.$index].isCustomer=true;
                    }else if(row.attributeName == "Supplier"){
                        $scope.invoiceForOwner.detailList[$scope.$index].isSupplier=true;
                    }else if(row.attributeName == "Designation"){
                        $scope.invoiceForOwner.detailList[$scope.$index].isDesignation=true;
                    }else if(row.attributeName == "Cost Center"){
                        $scope.invoiceForOwner.detailList[$scope.$index].isCostCenter=true;
                    }else if(row.attributeName == "Company"){
                        $scope.invoiceForOwner.detailList[$scope.$index].isCompany=true;
                    }else if(row.attributeName == "Quantity (MT) GO"){
                        $scope.invoiceForOwner.detailList[$scope.$index].isQuantityGO=true;
                    }else if(row.attributeName == "Quantity (MT) FO"){
                        $scope.invoiceForOwner.detailList[$scope.$index].isQuantityFO=true;
                    }else if(row.attributeName == "Port with Sequence"){
                        $scope.invoiceForOwner.detailList[$scope.$index].isPortSequence=true;
                    }
                    });
                }).error(function(datas) {
            });
        }else{
            $scope.invoiceForOwner.detailList[$scope.$index].subAccountCodeList=[];
        
        }
    });
    
    
});
