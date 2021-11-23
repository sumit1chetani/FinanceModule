 'use strict';
app.controller('charterOutApprovalCtrl', function($scope,$rootScope, $stateParams, $controller ,$window, $location, $http, logger, $log, 
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
        var url = 'app/CharterOutApproval/list?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount + '&formCode='+$('#form_code_id').val();
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
    if(window.localStorage.getItem('chartApp')==$scope.currentURL){
        debugger;
         alert('window ' + $scope.currentURL + ' is already opened');
         //window.focus();
         //window.open($rootScope.currentURL,'_self').close();
         setTimeout(window.close(),5000);
     }else{
         window.localStorage.setItem('chartApp', $scope.currentURL);
     }

    $(window).unload(function(){
        localStorage.removeItem('chartApp');
        });
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
          $location.path('/transaction/approvals/charteroutaproval/view/' + invoiceNo);
   }
   /**
    * send mail
    */
   $scope.sendMail = function(invoiceNo) {       
       $http.get('app/CharterOutApproval/sendMail?invoiceNo='+invoiceNo).success(function(data) {
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
       var url = 'app/CharterOutApproval/print?invoiceNo=' + invoiceNo;
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
       var url = 'app/CharterOutApproval/bulkPrint?invoiceNos='+invoiceNos;
       var wnd = window.open(url, 'Shipping', 'height=400,width=750,top=100,left=100,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
       wnd.print();
   }   
});

  

app.service("ListService", function($http, $q) {

    this.getCustomerList = function() {
        var customerList = $q.defer();
        $http.get('app/generalinvoice/getCustomerList').success(function(data) {
            customerList.resolve(data);
        }).error(function(data) {
            customerList.reject("Failed to get Customer List");
        });
        return customerList.promise;
    }

    this.getMloList = function(customerCode,pol) {
        var mloList = $q.defer();
        $http.get('app/generalinvoice/getMloList?CustomerCode=' + customerCode+'&pol=' +pol).success(function(data) {
            mloList.resolve(data);
            

        }).error(function(data) {

            mloList.reject("Failed to get Mlo List");

        });
        return mloList.promise;
    }

    this.getVesselList = function() {
        var voyageList = $q.defer();
        $http.get('app/generalinvoice/getVesselList').success(function(data) {
            voyageList.resolve(data);

        }).error(function(data) {

            voyageList.reject("Failed to get Voyage Vessel List");

        });
        return voyageList.promise;
    }
    this.getVoyageList = function(vesselCode) {
        var voyageList = $q.defer();
        $http.get('app/generalinvoice/getVoyageList?vesselCode=' + vesselCode).success(function(data) {
            voyageList.resolve(data);

        }).error(function(data) {

            voyageList.reject("Failed to get Voyage Vessel List");

        });
        return voyageList.promise;
    }

    this.getCompanyCurrency = function(companyCode) {
        var voyageList = $q.defer();
        $http.get('app/generalinvoice/getVoyageList?vesselCode=' + vesselCode).success(function(data) {
            voyageList.resolve(data);

        }).error(function(data) {

            voyageList.reject("Failed to get Voyage Vessel List");

        });
        return voyageList.promise;
    }
    
    this.getBlList = function(VoyageId,pol,customer) {
        var blList = $q.defer();
        $http.get('app/generalinvoice/getBlList?voyageCode=' + VoyageId+'&pol=' +pol+'&customer='+customer).success(function(data) {
            blList.resolve(data);

        }).error(function(data) {

            blList.reject("Failed to get Mlo List");

        });
        return blList.promise;
    }

    this.getPortList = function(VoyageId) {

        var portList = $q.defer();
        $http.get('app/generalinvoice/getportList?voyageCode=' + VoyageId).success(function(data) {
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
        $http.get('app/generalinvoice/getAccountHeadList').success(function(data) {
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

app.controller('GItableCtrl', function($scope,$http, $filter,logger){
    debugger;
    $scope.$watch('invoiceForOwner.detailList[trIndex].voyageCode', function(newValue, oldValue) {
        debugger;
        if (newValue != '' && newValue != undefined) {
                $http.get('app/commonUtility/getVesselService?voyageCode='+newValue).success(function(datas) {
                    $scope.invoiceForOwner.detailList[$scope.$index].vesselCode=datas.vesselCode;
                    $scope.invoiceForOwner.detailList[$scope.$index].sectorCode=datas.sectorCode;
                    }).error(function(datas) {
                });
       
        }
    });
    
    $scope.$watch('invoiceForOwner.detailList[trIndex].accountHead', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
            
            if(newValue == '10080001'){
                $http.get('app/commonUtility/getSubAccountCodeListTradeDebtors').success(function(datas) {
                    $scope.invoiceForOwner.detailList[$scope.$index].subAccountCodeList = datas;
                    $scope.invoiceForOwner.detailList[$scope.$index].isSubAccountCode =true;
                    }).error(function(datas) {
                });
            }else if(newValue == '20010001'){
                $http.get('app/commonUtility/getSubAccountCodeListTradeCreditors').success(function(datas) {
                    $scope.invoiceForOwner.detailList[$scope.$index].subAccountCodeList = datas;
                    $scope.invoiceForOwner.detailList[$scope.$index].isSubAccountCode =true;
                    }).error(function(datas) {
                });   
            }else if(newValue == '10070001'){
                $http.get('app/commonUtility/getStaffListForAdvances').success(function(datas) {
                    $scope.invoiceForOwner.detailList[$scope.$index].subAccountCodeList = datas;
                    $scope.invoiceForOwner.detailList[$scope.$index].isSubAccountCode =true;
                    }).error(function(datas) {
                });   
            }else{
                $scope.invoiceForOwner.detailList[$scope.$index].subAccountCodeList=[];
                $scope.invoiceForOwner.detailList[$scope.$index].isSubAccountCode =false;
            }
            
                $http.get('app/commonUtility/getAttributesList?accountCode='+newValue).success(function(datas) {
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

app.controller('GItableCtrl', function($scope,$http, $filter,logger){
    debugger;
    $scope.$watch('invoiceForOwner.detailList[trIndex].voyageCode', function(newValue, oldValue) {
        debugger;
        if (newValue != '' && newValue != undefined) {
                $http.get('app/commonUtility/getVesselService?voyageCode='+newValue).success(function(datas) {
                    $scope.invoiceForOwner.detailList[$scope.$index].vesselCode=datas.vesselCode;
                    $scope.invoiceForOwner.detailList[$scope.$index].sectorCode=datas.sectorCode;
                    }).error(function(datas) {
                });
       
        }
    });
    
    $scope.$watch('invoiceForOwner.detailList[trIndex].accountHead', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
            
            if(newValue == '10080001'){
                $http.get('app/commonUtility/getSubAccountCodeListTradeDebtors').success(function(datas) {
                    $scope.invoiceForOwner.detailList[$scope.$index].subAccountCodeList = datas;
                    $scope.invoiceForOwner.detailList[$scope.$index].isSubAccountCode =true;
                    }).error(function(datas) {
                });
            }else if(newValue == '20010001'){
                $http.get('app/commonUtility/getSubAccountCodeListTradeCreditors').success(function(datas) {
                    $scope.invoiceForOwner.detailList[$scope.$index].subAccountCodeList = datas;
                    $scope.invoiceForOwner.detailList[$scope.$index].isSubAccountCode =true;
                    }).error(function(datas) {
                });   
            }else if(newValue == '10070001'){
                $http.get('app/commonUtility/getStaffListForAdvances').success(function(datas) {
                    $scope.invoiceForOwner.detailList[$scope.$index].subAccountCodeList = datas;
                    $scope.invoiceForOwner.detailList[$scope.$index].isSubAccountCode =true;
                    }).error(function(datas) {
                });   
            }else{
                $scope.invoiceForOwner.detailList[$scope.$index].subAccountCodeList=[];
                $scope.invoiceForOwner.detailList[$scope.$index].isSubAccountCode =false;
            }
            
                $http.get('app/commonUtility/getAttributesList?accountCode='+newValue).success(function(datas) {
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

app.controller('charteroutaprovalViewCtrl', function($scope, $window, $rootScope, $location, $filter, $http, logger, 
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
            var url = 'app/CharterOutApproval/getInvoiceView?invoiceNo=' + invoiceNo;
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
        var url = 'app/CharterOutApproval/print?invoiceNo=' + invoiceNo;
        var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
        wnd.print();   
     }

    $scope.cancel = function() {
        $location.path("/transaction/approvals/charteroutaproval");
    };
    
    $scope.ApproveVoucher = function(invoiceNo){
        var url = 'app/CharterOutApproval/ApproveVoucher?invoiceNo=' + invoiceNo;
        $http.get(url).success(function(result) {
            console.log("result******");
            console.log(result);
            if(result == true){
                logger.logSuccess("Approved successfully!");
                $location.path("/transaction/approvals/charteroutaproval");
            }else{
                
            }
             
        }).error(function(result) {
            logger.logError("Error Please Try Again");
        });  
     }
    
    
    $scope.RejectVoucher = function(invoiceNo){
        var url = 'app/CharterOutApproval/RejectVoucher?invoiceNo=' + invoiceNo;
        $http.get(url).success(function(result) {
                 if(result == true){
                logger.logSuccess("Rejected successfully!");
                $location.path("/transaction/approvals/charteroutaproval");
            }else{
                
            }
             
        }).error(function(result) {
            logger.logError("Error Please Try Again");
        });  
     }
    
});

app.controller('detailViewCtrl', function($scope,$http, $filter,logger){
    
    $scope.$watch('invoiceForOwner.detailList[trIndex].accountHead', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
            if(newValue == '10080001'){
                $http.get('app/commonUtility/getSubAccountCodeListTradeDebtors').success(function(datas) {
                    $scope.invoiceForOwner.detailList[$scope.$index].subAccountCodeList = datas;
                    $scope.invoiceForOwner.detailList[$scope.$index].isSubAccountCode =true;
                    }).error(function(datas) {
                });
            }else if(newValue == '20010001'){
                $http.get('app/commonUtility/getSubAccountCodeListTradeCreditors').success(function(datas) {
                    $scope.invoiceForOwner.detailList[$scope.$index].subAccountCodeList = datas;
                    $scope.invoiceForOwner.detailList[$scope.$index].isSubAccountCode =true;
                    }).error(function(datas) {
                });   
            }else if(newValue == '10070001'){
                $http.get('app/commonUtility/getStaffListForAdvances').success(function(datas) {
                    $scope.invoiceForOwner.detailList[$scope.$index].subAccountCodeList = datas;
                    $scope.invoiceForOwner.detailList[$scope.$index].isSubAccountCode =true;
                    }).error(function(datas) {
                });   
            }else{
                $scope.invoiceForOwner.detailList[$scope.$index].subAccountCodeList=[];
                $scope.invoiceForOwner.detailList[$scope.$index].isSubAccountCode =false;
            }
            
                $http.get('app/commonUtility/getAttributesList?accountCode='+newValue).success(function(datas) {
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
