'use strict';
app.controller('provisionalInvoiceListCtrl', function($scope, $stateParams, $controller ,$window, $rootScope, $location, $http, logger, 
        $log, ngDialog, $modal, utilsService, $state) {

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
        $scope.GeneralInvoiceList = [];
        var url = 'app/provisionalinvoice/list?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount + '&formCode='+$('#form_code_id').val();
        $http.get(url).success(function(data) {
            console.log(data);
            if (data.success == true) {
                $scope.rowCollection = $scope.rowCollection.concat(data.lProvisionalInvoiceList);
            }
        });
    };

    $scope.getTranslationList();

    $scope.add = function() {
        $state.go('app.finance.invoice.provisionalinvoice.add');
    };

    $scope.editRowBtn = function(InvoiceNo) {
        $location.path('/invoice/provisionalinvoice/edit/' + InvoiceNo);
    }

    $scope.deleteRow = function(InvoiceNo) {
        ngDialog.close();
        ngDialog.open({
            template : 'generalInvoiceDeleteModal',
            scope :$scope,
            controller: $controller('GIctrlDelete', {
                $scope: $scope,
                InvoiceNo: InvoiceNo
            })
        });
       
   };
   
   /**
    * print
    */
   $scope.printProvisionalInvoiceDiv = function(invoiceNo){
       
       console.log("print invoice")
       var url = 'app/provisionalinvoice/print?invoiceNo=' + invoiceNo;
       var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
       wnd.print();   
    }
   
   $scope.view = function(invoiceNo) {   
          $location.path('/invoice/provisionalinvoice/view/' + invoiceNo);
   }
   
   $scope.sendMail = function(invoiceNo) {       
       $http.get('app/provisionalinvoice/sendMail?invoiceNo='+invoiceNo).success(function(data) {
           if (data == true) {
               logger.logSuccess("Mail sent successfully!");
           }else{
               logger.logError("Unable to send Email");
           }
       }).error(function(data) {
           console.log("data" + data);
       });

   }
   
});

app.controller('provisionalInvoiceDeleteCtrl', function($scope, $http,ngDialog,logger,$location,InvoiceNo) {
    $scope.DeleteConfirm = function(){
        $http.get('app/provisionalinvoice/delete?invoiceNo='+InvoiceNo).success(function(data) {
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

app.controller('provisionalInvoiceAddCtrl', function($scope, $window, $rootScope, $location, $filter, $http, logger, 
        $log, ngDialog, $modal, utilsService, ListService, $stateParams,$timeout,
        validationService,toaster) {

    $scope.mloList=[];
    $scope.PorthdrList=[];
    $scope.voyagehdrList=[];
    $scope.provisionalinvoice = {
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
        BlRelated : false,
        isEdit : false,
        priDtl : []
    }


    $scope.viewDisable=true;
    $('#blcheck').hide();
    $scope.blCheck = function() {
        $('#blcheck').show();
    }

    $scope.cancel = function() {
        $location.path("/invoice/provisionalinvoice/list");
    };
    $scope.onLoadDropdowns = function() {
        $http.get('app/usermaster/getCompanyList?formCode='+$('#form_code_id').val()).success(function(datas) {
            $scope.companyList = datas;
            var foundItemDest = $filter('filter')($scope.companyList, { baseCompany:  1 })[0];
            $scope.provisionalinvoice.CompanyCode=foundItemDest.id;
            }).error(function(datas) {
        });
        
        $scope.dataList = ListService.getCustomerList();
        $scope.dataList.then(function(customerLists) {
            $scope.customerhdrList = customerLists;
        });
        
        $scope.dataList = ListService.getVesselList();
        $scope.dataList.then(function(VesselLists) {
            $scope.VesselhdrList = VesselLists;
        });
        
       
        $scope.dataList = ListService.getAccountHeadList();
        $scope.dataList.then(function(AccountHeadLists) {
            $scope.AccountHeadList = AccountHeadLists;
        });
        
        // Account Attribute implementation
        $http.get('app/commonUtility/getVoyageList').success(function(datas) {
            $scope.voyageList = datas;
            }).error(function(datas) {
        });
        
        $http.get('app/commonUtility/getVesselList').success(function(datas) {
            $scope.vesselList = datas;
            }).error(function(datas) {
        });

        $http.get('app/commonUtility/getSupplierList').success(function(datas) {
            $scope.supplierList = datas;
            }).error(function(datas) {
        });
        
        $http.get('app/commonUtility/getSectorList').success(function(datas) {
            $scope.sectorList = datas;
            }).error(function(datas) {
        });
        
        $http.get('app/commonUtility/getEmployeeList').success(function(datas) {
            $scope.employeeList = datas;
            }).error(function(datas) {
        });
        
        $http.get('app/commonUtility/getPortList').success(function(datas) {
            $scope.portList = datas;
            }).error(function(datas) {
        });
        
        $http.get('app/commonUtility/getDepartmentList').success(function(datas) {
            $scope.departmentList = datas;
            }).error(function(datas) {
        });
        
        $http.get('app/commonUtility/getAgentList').success(function(datas) {
            $scope.agentList = datas;
            }).error(function(datas) {
        });
        
        $http.get('app/commonUtility/getCountryList').success(function(datas) {
            $scope.countryList = datas;
            }).error(function(datas) {
        });
        
        $http.get('app/commonUtility/getCustomerList').success(function(datas) {
            $scope.customerList = datas;
            }).error(function(datas) {
        });
        
        $http.get('app/commonUtility/getDesignationList').success(function(datas) {
            $scope.designationList = datas;
            }).error(function(datas) {
        });
    };
    
    $scope.onLoadDropdowns();

    $('#invoice_date').datetimepicker({
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
    $scope.provisionalinvoice.InvoiceDate = today;

    debugger;
    var generalObj = angular.copy($scope.provisionalinvoice, generalObj);
    var listVariable = Object.keys(generalObj);

    $scope.$watchCollection('provisionalinvoice', function(newVal, oldVal) {
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

        
    $scope.onSubmit = function(provisionalInvoiceForm,provisionalinvoice) {
        if (new validationService().checkFormValidity($scope.provisionalInvoiceForm)) {
            $scope.save();
        } else {
            toaster.pop('error', "Please fill the required fields", 
                    logger.getErrorHtmlNew($scope.provisionalInvoiceForm.$validationSummary), 5000, 'trustedHtml');
        }
    };
    
    $scope.display_limit = 50;
    
    $scope.increaseLimit = function () {
        if ($scope.display_limit < $scope.yearListVal.length) {
            $scope.display_limit += 50;
        }
      };

    $scope.save = function() {

        if ($scope.provisionalinvoice.isEdit == false) {
            $scope.provisionalinvoice.InvoiceDate = $("#txtInvoiceDate").val();
            $http.post('app/provisionalinvoice/save', $scope.provisionalinvoice).success(function(data) {
                if (data == true) {
                    logger.logSuccess("Created successfully!");
                    $location.path("/invoice/provisionalinvoice/list");
                } else {
                    logger.logError("Unable to Save");
                }
            }).error(function(data) {
            });
        }else{
            $scope.provisionalinvoice.InvoiceDate = $("#txtInvoiceDate").val();
            
             $http.post('app/provisionalinvoice/update', $scope.provisionalinvoice).success(function(data) {
                if (data == true) {
                    logger.logSuccess("Updated successfully!");
                    $location.path("/invoice/provisionalinvoice/list");
                } else {
                    logger.logError("Unable to Save");
                }
            }).error(function(data) {
            });
        
        }
    };

    $scope.selectedDropDown = function(userSelected) {
        debugger;
        switch (userSelected) {

        case 'MloName':
            if($scope.provisionalinvoice.MloName == 'PEVE0002' ||
                    $scope.provisionalinvoice.MloName=='PFOR0004' ||
                    $scope.provisionalinvoice.MloName=='PWAN0002'){
                $scope.provisionalinvoice.CurrencyCode = 'AED';
                $scope.provisionalinvoice.CurrencyName = 'AED';
                $scope.provisionalinvoice.ExchangeRate =3.685;
            }else{
                var index = $scope.getIndex($scope.mloList, $scope.provisionalinvoice.MloName);
                if(index !=undefined){
                    $scope.provisionalinvoice.CurrencyCode = $scope.mloList[index].CurrencyCode;
                    $scope.provisionalinvoice.CurrencyName = $scope.mloList[index].CurrencyCode;
                    $http.get('app/commonUtility/getExchangeRate?currencyCode='+ $scope.provisionalinvoice.CurrencyCode).success(function(data) {
                        debugger;
                        $scope.provisionalinvoice.ExchangeRate=data;
                    }).error(function(data) {
                    });
                }
            }
           
            break;
            
        case 'VesselName':
            $scope.dataList = ListService.getVoyageList($scope.provisionalinvoice.VesselName);
            $scope.dataList.then(function(voyageLists) {

                $scope.voyagehdrList = voyageLists;

            });
            break;
         
        case 'CompanyCode':
            debugger;
            $http.get('app/provisionalinvoice/getCompanyCurrency?CompanyCode='+$scope.provisionalinvoice.CompanyCode).success(function(datas) {
                $scope.companyCurrency=datas.CurrencyCode;
                }).error(function(datas) {
            });
            
            break;
            
        case 'Voyage':
            $scope.dataList = ListService.getPortList($scope.provisionalinvoice.Voyage);
            $scope.dataList.then(function(PortLists) {
                $scope.PorthdrList = PortLists;
            });

            var index = $scope.getIndex($scope.voyagehdrList, $scope.provisionalinvoice.Voyage);
            $scope.provisionalinvoice.ServiceName = $scope.voyagehdrList[index].ServiceName;
            break;
            
            
        case 'Pol':
            debugger;
            
            $scope.dataList = ListService.getMloList($scope.provisionalinvoice.CustomerName,$scope.provisionalinvoice.Pol);
            $scope.dataList.then(function(mloLists) {
                $scope.mloList = mloLists;
                debugger;
                console.log($scope.mloList);
            });
            break;
         
        case 'CustomerName':
            $scope.dataList = ListService.getMloList($scope.provisionalinvoice.CustomerName,$scope.provisionalinvoice.Pol);
            $scope.dataList.then(function(mloLists) {
                $scope.mloList = mloLists;
                debugger;
                console.log($scope.mloList);
            });
            
            $scope.dataList = ListService.getBlList($scope.provisionalinvoice.Voyage,$scope.provisionalinvoice.Pol,$scope.provisionalinvoice.CustomerName);
            $scope.dataList.then(function(blLists) {
                $scope.blList = blLists;
            });
            
        break;
        
        case 'bl':
            $http.get('app/provisionalinvoice/fetchDetailList?bl='+$scope.provisionalinvoice.bl).success(function(datas) {
                $scope.provisionalinvoice.priDtl = datas.priDtl;
                }).error(function(datas) {
            });
            
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

    $scope.provisionalInvoiceDtlList = function() {
        var priRow = {
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
        $scope.provisionalinvoice.priDtl.push(priRow);
    }

    $scope.provisionalInvoiceDtlList();
    
    $scope.addRow = function(pritable) {

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
        
        pritable.push(table);
    };
    // removeRow
    $scope.removeRow = function(pritable) {
        debugger;
        $scope.tablerow = [];
        angular.forEach(pritable, function(row, index) {
            var check = row.select;
            if (check == undefined || check == "") {
                $scope.tablerow.push(row);
            } else {

            }
        });
        $scope.provisionalinvoice.priDtl = $scope.tablerow;
    };
   
    $scope.calculateTCtoBCAmount = function(tcAmount, trIndex, row) {
        debugger;
        if (tcAmount != null) {
            if ($scope.provisionalinvoice.ExchangeRate != 0 && $scope.provisionalinvoice.ExchangeRate != "")
                row.bcAmount = (parseFloat(tcAmount) / $scope.provisionalinvoice.ExchangeRate).toFixed(2);
            else
                row.bcAmount = (parseFloat(tcAmount)).toFixed(2);
        } else {
            row.bcAmount = 0.0;
            row.tcAmount = 0.0;
        }
        $scope.calculateTotalAmount($scope.provisionalinvoice.priDtl);
    };

    $scope.calculateBCtoTCAmount = function(bcAmount, trIndex, row) {
        debugger;
        if (bcAmount != null) {
            if ($scope.provisionalinvoice.ExchangeRate != 0 && $scope.provisionalinvoice.ExchangeRate != "")
                row.tcAmount = (parseFloat(bcAmount) * $scope.provisionalinvoice.ExchangeRate).toFixed(2);
            else
                row.tcAmount = (parseFloat(bcAmount)).toFixed(2);
        } else {
            row.bcAmount = 0.0;
            row.tcAmount = 0.0;
        }
        $scope.calculateTotalAmount($scope.provisionalinvoice.priDtl);
    };
    
    $scope.calculateTotalAmount = function(tables) {
        debugger;
        var TotalBCamount = 0.0, TotalTCamount = 0.0;
        angular.forEach(tables, function(row, index) {
            TotalBCamount = (parseFloat(TotalBCamount) + parseFloat(row.bcAmount)).toFixed(2);
            TotalTCamount = (parseFloat(TotalTCamount) + parseFloat(row.tcAmount)).toFixed(2);
        });
        $scope.provisionalinvoice.TotalBCamount = TotalBCamount;
        $scope.provisionalinvoice.TotalTCamount = TotalTCamount;
    };
    
    $scope.getEdit = function(sInvoiceNo) {
        var url = 'app/provisionalinvoice/edit?generalInvoiceNo=' + sInvoiceNo;
        $http.get(url).success(function(result) {
            debugger;
            $scope.provisionalinvoice.InvoiceDate = result.InvoiceDate;
            $scope.provisionalinvoice.bLlist= result.bLlist;
            $scope.provisionalinvoice.customerList= result.customerList;
            $scope.mloList= result.mloList;
            $scope.provisionalinvoice.voyagehdrList= result.voyageList;
            $scope.provisionalinvoice.porthdrList= result.portList;
            $scope.provisionalinvoice.VesselhdrList= result.vesselList;

            $scope.provisionalinvoice.BlRelated = result.BlRelated;
            $scope.provisionalinvoice.Company = result.Company;
            $scope.provisionalinvoice.CompanyCode = result.CompanyCode;
            $scope.provisionalinvoice.CurrencyCode = result.CurrencyCode;
            $scope.provisionalinvoice.CurrencyName = result.CurrencyName;
            $scope.provisionalinvoice.CustomerCode = result.CustomerCode;
            $scope.provisionalinvoice.CustomerName = result.CustomerName;
            $scope.provisionalinvoice.ExchangeRate = result.ExchangeRate;
           

            var date= result.InvoiceDate;
            var d=new Date(date.split("-").reverse().join("/"));
            var dd=d.getDate();
            var mm=d.getMonth()+1;
            var yy=d.getFullYear();
            var invoiceFormattedDate=dd+"/"+mm+"/"+yy;
            
            $scope.provisionalinvoice.InvoiceDate = invoiceFormattedDate;
            $scope.provisionalinvoice.InvoiceNo = result.InvoiceNo;
           // $scope.provisionalinvoice.MloCode = result.MloName;
            $scope.provisionalinvoice.MloName = result.MloName;
            $scope.provisionalinvoice.Pod = result.Pod;
            $scope.provisionalinvoice.Pol = result.Pol;
            $scope.provisionalinvoice.Port = result.Port;
            $scope.provisionalinvoice.PortSequence = result.PortSequence;
            $scope.provisionalinvoice.ServiceCode = result.ServiceCode;
            $scope.provisionalinvoice.ServiceName = result.ServiceName;
            $scope.provisionalinvoice.Subject = result.Subject;
            /*$scope.provisionalinvoice.TotalBCamount = result.TotalBCamount;
            $scope.provisionalinvoice.TotalTCamount = result.TotalTCamount;*/
            $scope.provisionalinvoice.Unit20 = result.Unit20;
            $scope.provisionalinvoice.Unit40 = result.Unit40;
            //$scope.provisionalinvoice.VesselCode = result.VesselCode;
            $scope.provisionalinvoice.VesselName = result.VesselName;
            $scope.provisionalinvoice.Voyage = result.Voyage;
            
            $scope.provisionalinvoice.priDtl = result.priDtl;
            $scope.calculateTotalAmount($scope.provisionalinvoice.priDtl);

        }).error(function(result) {
            logger.logError("Error Please Try Again");
        });

    }

    var InvoiceNo=$stateParams.InvoiceNo;
    if(InvoiceNo == undefined || InvoiceNo == null || InvoiceNo ==""){
        $scope.provisionalinvoice.isEdit=false;
    }else{
        $scope.provisionalinvoice.isEdit =true;
        $scope.getEdit(InvoiceNo);
    }
    
   

});

app.controller('provisionalInvoiceViewCtrl', function($scope, $window, $rootScope, $location, $filter, $http, logger, 
        $log, ngDialog, $modal, utilsService, ListService, $stateParams,$timeout,validationService,toaster) {
    
    $scope.provisionalinvoice = {
            invoiceNo:'', invoiceDate:'', company:'', companyCode:'', blRelated:'', customerName:'', customerCode:'',
            mloCode:'', mloName:'', subject:'', currencyName:'', currencyCode:'', exchangeRate:'',
            voyage:'', vesselCode:'', vesselName:'', serviceCode:'', serviceName:'', unit20:'', unit40:'', pol:'', pod:'',
            sailingDate:'', bl:'', port:'', portSequence:'', accountHeadName:'', accountHeadCode:'', 
            TotalBCamount:'', TotalTCamount:'', priDtl:[],

            customerAddress:'', customerPhoneNo:'', customerFaxNo:'', customerEmail:'', companyAddress:'',
            companyPhoneNo:'', companyFaxNo:'', companyEmail:'', companyCurrency:'',
        }
    
    $scope.generalInvoiceDtlList = function() {
        var priRow = {
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

    $scope.generalInvoiceDtlList();
    $scope.viewDisable =true;
    var invoiceNo=$stateParams.invoiceNo;
    if(invoiceNo == undefined || invoiceNo == null || invoiceNo ==""){
        $scope.viewDisable=false;
    }else{
     
            var url = 'app/provisionalinvoice/getProvisionalInvoiceView?invoiceNo=' + invoiceNo;
            $http.get(url).success(function(result) {
                console.log(result);
                $scope.provisionalinvoice = result;
            }).error(function(result) {
                logger.logError("Error Please Try Again");
            });
    }
    
    /**
     * print
     */
    $scope.printProvisionalInvoiceDiv = function(invoiceNo){
        var url = 'app/provisionalinvoice/print?invoiceNo=' + invoiceNo;
        var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
        wnd.print();   
     }

    $scope.cancel = function() {
        $location.path("/invoice/provisionalinvoice/list");
    };
});

app.service("ListService", function($http, $q) {

    this.getCustomerList = function() {
        var customerList = $q.defer();
        $http.get('app/provisionalinvoice/getCustomerList').success(function(data) {
            customerList.resolve(data);
        }).error(function(data) {
            customerList.reject("Failed to get Customer List");
        });
        return customerList.promise;
    }

    this.getMloList = function(customerCode,pol) {
        var mloList = $q.defer();
        $http.get('app/provisionalinvoice/getMloList?CustomerCode=' + customerCode+'&pol=' +pol).success(function(data) {
            mloList.resolve(data);
            

        }).error(function(data) {

            mloList.reject("Failed to get Mlo List");

        });
        return mloList.promise;
    }

    this.getVesselList = function() {
        var voyageList = $q.defer();
        $http.get('app/provisionalinvoice/getVesselList').success(function(data) {
            voyageList.resolve(data);

        }).error(function(data) {

            voyageList.reject("Failed to get Voyage Vessel List");

        });
        return voyageList.promise;
    }
    this.getVoyageList = function(vesselCode) {
        var voyageList = $q.defer();
        $http.get('app/provisionalinvoice/getVoyageList?vesselCode=' + vesselCode).success(function(data) {
            voyageList.resolve(data);

        }).error(function(data) {

            voyageList.reject("Failed to get Voyage Vessel List");

        });
        return voyageList.promise;
    }

    this.getCompanyCurrency = function(companyCode) {
        var voyageList = $q.defer();
        $http.get('app/provisionalinvoice/getVoyageList?vesselCode=' + vesselCode).success(function(data) {
            voyageList.resolve(data);

        }).error(function(data) {

            voyageList.reject("Failed to get Voyage Vessel List");

        });
        return voyageList.promise;
    }
    
    this.getBlList = function(VoyageId,pol,customer) {
        var blList = $q.defer();
        $http.get('app/provisionalinvoice/getBlList?voyageCode=' + VoyageId+'&pol=' +pol+'&customer='+customer).success(function(data) {
            blList.resolve(data);

        }).error(function(data) {

            blList.reject("Failed to get Mlo List");

        });
        return blList.promise;
    }

    this.getPortList = function(VoyageId) {

        var portList = $q.defer();
        $http.get('app/provisionalinvoice/getportList?voyageCode=' + VoyageId).success(function(data) {
            portList.resolve(data);

        }).error(function(data) {

            portList.reject("Failed to get portList List");

        });
        return portList.promise;
    }
    
    this.getSubAccountList = function(){
        var subAccountList = $q.defer();
        $http.get('app/commonUtility/getSubAccountCodeList').success(function(datas) {
            subAccountList.resolve(datas.commonUtilityBean);
        }).error(function(data) {
            subAccountList.reject("Failed to get Sub Account Code List");
        });
        return subAccountList.promise;
    }
    
    this.getAccountHeadList = function() {

        var accountHeadList = $q.defer();
        $http.get('app/provisionalinvoice/getAccountHeadList').success(function(data) {
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

app.controller('priTableCtrl', function($scope,$http, $filter,logger){
    debugger;
    $scope.$watch('provisionalinvoice.priDtl[trIndex].voyageCode', function(newValue, oldValue) {
        debugger;
        if (newValue != '' && newValue != undefined) {
                $http.get('app/commonUtility/getVesselService?voyageCode='+newValue).success(function(datas) {
                    $scope.provisionalinvoice.priDtl[$scope.$index].vesselCode=datas.vesselCode;
                    $scope.provisionalinvoice.priDtl[$scope.$index].sectorCode=datas.sectorCode;
                    }).error(function(datas) {
                });
       
        }
    });
    
    $scope.$watch('provisionalinvoice.priDtl[trIndex].accountHead', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
            if(newValue == '10080001'){
                $http.get('app/commonUtility/getSubAccountCodeListTradeDebtors').success(function(datas) {
                    $scope.provisionalinvoice.priDtl[$scope.$index].subAccountCodeList = datas;
                    $scope.provisionalinvoice.priDtl[$scope.$index].isSubAccountCode =true;
                    }).error(function(datas) {
                });
            }else if(newValue == '20010001'){
                $http.get('app/commonUtility/getSubAccountCodeListTradeCreditors').success(function(datas) {
                    $scope.provisionalinvoice.priDtl[$scope.$index].subAccountCodeList = datas;
                    $scope.provisionalinvoice.priDtl[$scope.$index].isSubAccountCode =true;
                    }).error(function(datas) {
                });   
            }else if(newValue == '10070001'){
                $http.get('app/commonUtility/getStaffListForAdvances').success(function(datas) {
                    $scope.provisionalinvoice.priDtl[$scope.$index].subAccountCodeList = datas;
                    $scope.provisionalinvoice.priDtl[$scope.$index].isSubAccountCode =true;
                    }).error(function(datas) {
                });   
            }else{
                $scope.provisionalinvoice.priDtl[$scope.$index].subAccountCodeList=[];
                $scope.provisionalinvoice.priDtl[$scope.$index].isSubAccountCode =false;
            }
            
                $http.get('app/commonUtility/getAttributesList?accountCode='+newValue).success(function(datas) {
                $scope.provisionalinvoice.priDtl[$scope.$index].attributeList=datas;
                if(newValue==oldValue){
                    $scope.isOnChange =false;
                }else{
                    $scope.isOnChange =true;
                }
                if(!$scope.provisionalinvoice.isEdit || $scope.isOnChange){
                
                     
                $scope.provisionalinvoice.priDtl[$scope.$index].voyageCode='';
                $scope.provisionalinvoice.priDtl[$scope.$index].vesselCode='';
                $scope.provisionalinvoice.priDtl[$scope.$index].sectorCode='';
                $scope.provisionalinvoice.priDtl[$scope.$index].employeeCode='';
                $scope.provisionalinvoice.priDtl[$scope.$index].portCode='';
                $scope.provisionalinvoice.priDtl[$scope.$index].portSequence='';
                $scope.provisionalinvoice.priDtl[$scope.$index].departmentCode='';
                $scope.provisionalinvoice.priDtl[$scope.$index].agentCode='';
                $scope.provisionalinvoice.priDtl[$scope.$index].countryCode='';
                $scope.provisionalinvoice.priDtl[$scope.$index].customerCode='';
                $scope.provisionalinvoice.priDtl[$scope.$index].supplierCode='';
                $scope.provisionalinvoice.priDtl[$scope.$index].designationCode='';
                $scope.provisionalinvoice.priDtl[$scope.$index].costCenter='';
                $scope.provisionalinvoice.priDtl[$scope.$index].companyCode='';
                $scope.provisionalinvoice.priDtl[$scope.$index].quantityGO='';
                $scope.provisionalinvoice.priDtl[$scope.$index].quantityFO='';
                }
                
                $scope.provisionalinvoice.priDtl[$scope.$index].isVoyage=false;
                $scope.provisionalinvoice.priDtl[$scope.$index].isVessel=false;
                $scope.provisionalinvoice.priDtl[$scope.$index].isService=false;
                $scope.provisionalinvoice.priDtl[$scope.$index].isEmployee=false;
                $scope.provisionalinvoice.priDtl[$scope.$index].isPort=false;
                $scope.provisionalinvoice.priDtl[$scope.$index].isDepartment=false;
                $scope.provisionalinvoice.priDtl[$scope.$index].isAgent=false;
                $scope.provisionalinvoice.priDtl[$scope.$index].isLocation=false;
                $scope.provisionalinvoice.priDtl[$scope.$index].isCustomer=false;
                $scope.provisionalinvoice.priDtl[$scope.$index].isSupplier=false;
                $scope.provisionalinvoice.priDtl[$scope.$index].isDesignation=false;
                $scope.provisionalinvoice.priDtl[$scope.$index].isCostCenter=false;
                $scope.provisionalinvoice.priDtl[$scope.$index].isCompany=false;
                $scope.provisionalinvoice.priDtl[$scope.$index].isQuantityGO=false;
                $scope.provisionalinvoice.priDtl[$scope.$index].isQuantityFO=false;
                $scope.provisionalinvoice.priDtl[$scope.$index].isPortSequence=false;
             
                angular.forEach($scope.provisionalinvoice.priDtl[$scope.$index].attributeList, function(row, rowindex) {
                    debugger;
                    if(row.attributeName == "Voyage"){
                        $scope.provisionalinvoice.priDtl[$scope.$index].isVoyage=true;
                    }else if(row.attributeName == "Vessel"){
                        $scope.provisionalinvoice.priDtl[$scope.$index].isVessel=true;
                    }else if(row.attributeName == "Service"){
                        $scope.provisionalinvoice.priDtl[$scope.$index].isService=true;
                    }else if(row.attributeName == "Employee"){
                        $scope.provisionalinvoice.priDtl[$scope.$index].isEmployee=true;
                    }else if(row.attributeName == "Port"){
                        $scope.provisionalinvoice.priDtl[$scope.$index].isPort=true;
                    }else if(row.attributeName == "Department"){
                        $scope.provisionalinvoice.priDtl[$scope.$index].isDepartment=true;
                    }else if(row.attributeName == "Agent"){
                        $scope.provisionalinvoice.priDtl[$scope.$index].isAgent=true;
                    }else if(row.attributeName == "Location"){
                        $scope.provisionalinvoice.priDtl[$scope.$index].isLocation=true;
                    }else if(row.attributeName == "Customer"){
                        $scope.provisionalinvoice.priDtl[$scope.$index].isCustomer=true;
                    }else if(row.attributeName == "Supplier"){
                        $scope.provisionalinvoice.priDtl[$scope.$index].isSupplier=true;
                    }else if(row.attributeName == "Designation"){
                        $scope.provisionalinvoice.priDtl[$scope.$index].isDesignation=true;
                    }else if(row.attributeName == "Cost Center"){
                        $scope.provisionalinvoice.priDtl[$scope.$index].isCostCenter=true;
                    }else if(row.attributeName == "Company"){
                        $scope.provisionalinvoice.priDtl[$scope.$index].isCompany=true;
                    }else if(row.attributeName == "Quantity (MT) GO"){
                        $scope.provisionalinvoice.priDtl[$scope.$index].isQuantityGO=true;
                    }else if(row.attributeName == "Quantity (MT) FO"){
                        $scope.provisionalinvoice.priDtl[$scope.$index].isQuantityFO=true;
                    }else if(row.attributeName == "Port with Sequence"){
                        $scope.provisionalinvoice.priDtl[$scope.$index].isPortSequence=true;
                    }
                    });
                }).error(function(datas) {
            });
        }else{
            $scope.provisionalinvoice.priDtl[$scope.$index].subAccountCodeList=[];
        
        }
    });
});
app.controller('pritableViewCtrl', function($scope,$http, $filter,logger){
    
    $scope.$watch('provisionalinvoice.priDtl[trIndex].accountHead', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
            if(newValue == '10080001'){
                $http.get('app/commonUtility/getSubAccountCodeListTradeDebtors').success(function(datas) {
                    $scope.provisionalinvoice.priDtl[$scope.$index].subAccountCodeList = datas;
                    $scope.provisionalinvoice.priDtl[$scope.$index].isSubAccountCode =true;
                    }).error(function(datas) {
                });
            }else if(newValue == '20010001'){
                $http.get('app/commonUtility/getSubAccountCodeListTradeCreditors').success(function(datas) {
                    $scope.provisionalinvoice.priDtl[$scope.$index].subAccountCodeList = datas;
                    $scope.provisionalinvoice.priDtl[$scope.$index].isSubAccountCode =true;
                    }).error(function(datas) {
                });   
            }else if(newValue == '10070001'){
                $http.get('app/commonUtility/getStaffListForAdvances').success(function(datas) {
                    $scope.provisionalinvoice.priDtl[$scope.$index].subAccountCodeList = datas;
                    $scope.provisionalinvoice.priDtl[$scope.$index].isSubAccountCode =true;
                    }).error(function(datas) {
                });   
            }else{
                $scope.provisionalinvoice.priDtl[$scope.$index].subAccountCodeList=[];
                $scope.provisionalinvoice.priDtl[$scope.$index].isSubAccountCode =false;
            }
            
                $http.get('app/commonUtility/getAttributesList?accountCode='+newValue).success(function(datas) {
                $scope.provisionalinvoice.priDtl[$scope.$index].attributeList=datas;
                if(newValue==oldValue){
                    $scope.isOnChange =false;
                }else{
                    $scope.isOnChange =true;
                }
                if(!$scope.viewDisable || $scope.isOnChange){
                    $scope.provisionalinvoice.priDtl[$scope.$index].voyageCode='';
                    $scope.provisionalinvoice.priDtl[$scope.$index].vesselCode='';
                    $scope.provisionalinvoice.priDtl[$scope.$index].sectorCode='';
                    $scope.provisionalinvoice.priDtl[$scope.$index].employeeCode='';
                    $scope.provisionalinvoice.priDtl[$scope.$index].portCode='';
                    $scope.provisionalinvoice.priDtl[$scope.$index].portSequence='';
                    $scope.provisionalinvoice.priDtl[$scope.$index].departmentCode='';
                    $scope.provisionalinvoice.priDtl[$scope.$index].agentCode='';
                    $scope.provisionalinvoice.priDtl[$scope.$index].countryCode='';
                    $scope.provisionalinvoice.priDtl[$scope.$index].customerCode='';
                    $scope.provisionalinvoice.priDtl[$scope.$index].supplierCode='';
                    $scope.provisionalinvoice.priDtl[$scope.$index].designationCode='';
                    $scope.provisionalinvoice.priDtl[$scope.$index].costCenter='';
                    $scope.provisionalinvoice.priDtl[$scope.$index].companyCode='';
                    $scope.provisionalinvoice.priDtl[$scope.$index].quantityGO='';
                    $scope.provisionalinvoice.priDtl[$scope.$index].quantityFO='';
                }
                
                $scope.provisionalinvoice.priDtl[$scope.$index].isVoyage=false;
                $scope.provisionalinvoice.priDtl[$scope.$index].isVessel=false;
                $scope.provisionalinvoice.priDtl[$scope.$index].isService=false;
                $scope.provisionalinvoice.priDtl[$scope.$index].isEmployee=false;
                $scope.provisionalinvoice.priDtl[$scope.$index].isPort=false;
                $scope.provisionalinvoice.priDtl[$scope.$index].isDepartment=false;
                $scope.provisionalinvoice.priDtl[$scope.$index].isAgent=false;
                $scope.provisionalinvoice.priDtl[$scope.$index].isLocation=false;
                $scope.provisionalinvoice.priDtl[$scope.$index].isCustomer=false;
                $scope.provisionalinvoice.priDtl[$scope.$index].isSupplier=false;
                $scope.provisionalinvoice.priDtl[$scope.$index].isDesignation=false;
                $scope.provisionalinvoice.priDtl[$scope.$index].isCostCenter=false;
                $scope.provisionalinvoice.priDtl[$scope.$index].isCompany=false;
                $scope.provisionalinvoice.priDtl[$scope.$index].isQuantityGO=false;
                $scope.provisionalinvoice.priDtl[$scope.$index].isQuantityFO=false;
                $scope.provisionalinvoice.priDtl[$scope.$index].isPortSequence=false;
             
                angular.forEach($scope.provisionalinvoice.priDtl[$scope.$index].attributeList, function(row, rowindex) {
                    if(row.attributeName == "Voyage"){
                        $scope.provisionalinvoice.priDtl[$scope.$index].isVoyage=true;
                    }else if(row.attributeName == "Vessel"){
                        $scope.provisionalinvoice.priDtl[$scope.$index].isVessel=true;
                    }else if(row.attributeName == "Service"){
                        $scope.provisionalinvoice.priDtl[$scope.$index].isService=true;
                    }else if(row.attributeName == "Employee"){
                        $scope.provisionalinvoice.priDtl[$scope.$index].isEmployee=true;
                    }else if(row.attributeName == "Port"){
                        $scope.provisionalinvoice.priDtl[$scope.$index].isPort=true;
                    }else if(row.attributeName == "Department"){
                        $scope.provisionalinvoice.priDtl[$scope.$index].isDepartment=true;
                    }else if(row.attributeName == "Agent"){
                        $scope.provisionalinvoice.priDtl[$scope.$index].isAgent=true;
                    }else if(row.attributeName == "Location"){
                        $scope.provisionalinvoice.priDtl[$scope.$index].isLocation=true;
                    }else if(row.attributeName == "Customer"){
                        $scope.provisionalinvoice.priDtl[$scope.$index].isCustomer=true;
                    }else if(row.attributeName == "Supplier"){
                        $scope.provisionalinvoice.priDtl[$scope.$index].isSupplier=true;
                    }else if(row.attributeName == "Designation"){
                        $scope.provisionalinvoice.priDtl[$scope.$index].isDesignation=true;
                    }else if(row.attributeName == "Cost Center"){
                        $scope.provisionalinvoice.priDtl[$scope.$index].isCostCenter=true;
                    }else if(row.attributeName == "Company"){
                        $scope.provisionalinvoice.priDtl[$scope.$index].isCompany=true;
                    }else if(row.attributeName == "Quantity (MT) GO"){
                        $scope.provisionalinvoice.priDtl[$scope.$index].isQuantityGO=true;
                    }else if(row.attributeName == "Quantity (MT) FO"){
                        $scope.provisionalinvoice.priDtl[$scope.$index].isQuantityFO=true;
                    }else if(row.attributeName == "Port with Sequence"){
                        $scope.provisionalinvoice.priDtl[$scope.$index].isPortSequence=true;
                    }
                    });
                }).error(function(datas) {
            });
        }else{
            $scope.provisionalinvoice.priDtl[$scope.$index].subAccountCodeList=[];
        
        }
    });
    
    
});