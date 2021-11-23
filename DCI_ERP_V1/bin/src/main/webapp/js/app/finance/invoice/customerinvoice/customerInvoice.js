'use strict';
app.controller('customerInvoiceCtrl', function($scope, $stateParams, $controller ,$window, $rootScope, $location, $http, logger, $log, 
        ngDialog, $modal, utilsService, $state) {

    $scope.dataLoopCount = 0;
    $scope.from = 0;
    $scope.to = 100;
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
$scope.currentURL=$location.protocol() + '://'+ $location.host() +':'+  $location.port()+"/#" +$location.path();
    
    if(window.localStorage.getItem('giv_list')==$scope.currentURL){
        alert('window ' + $scope.currentURL + ' is already opened');
       // window.focus();
        //window.open($rootScope.currentURL,'_self').close();
      
       // window.close();
       // localStorage.removeItem('purchaseIv');
    }else{
        window.localStorage.setItem('giv', $scope.currentURL);
        window.localStorage.removeItem('giv');
    }
//    $(window).unload(function(){
//      //  debugger;
//       //alert("INSIDE UNLOAD")
//         localStorage.removeItem('giv');
//       });

    $scope.getTranslationList = function() {
        $scope.dataLoopCount = 0;
        $scope.showEmptyLabel = false;
        $scope.from = 0;
        $scope.to = 100;
        $scope.rowCollection = [];
        $scope.GeneralInvoiceList = [];
        var url = $stateParams.tenantid+'/app/customerinvoice/list?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount + '&formCode='+$('#form_code_id').val();
        $http.get(url).success(function(data) {
            console.log("data");
            console.log(data);
            if (data.success == true) {
                $scope.rowCollection = $scope.rowCollection.concat(data.lGeneralInvoiceList);
            }
        });
    };

    $scope.getTranslationList();

    $scope.add = function() {
    	
        $state.go('app.finance.invoice.CustomerInvoiceAdd',{tenantid:$stateParams.tenantid});
    };

    $scope.editRowBtn = function(InvoiceNo) {
        $location.path($stateParams.tenantid+'/invoice/customerinvoice/edit/' + InvoiceNo);
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
   
     $scope.viewCustomerInvoice = function(invoiceNo) {       
          $location.path($stateParams.tenantid+'/invoice/customerinvoice/view/' + invoiceNo);
   }
   /**
    * send mail
    */
   $scope.sendMail = function(invoiceNo) {       
       $http.get($stateParams.tenantid+'/app/customerinvoice/sendMail?invoiceNo='+invoiceNo).success(function(data) {
           if (data == true) {
               logger.logSuccess("Mail sent successfully!");
           }else{
               logger.logError("Please check Customer Mail Id / Unable to send Email");
           }
       }).error(function(data) {
           console.log("data" + data);
       });

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
       var url = $stateParams.tenantid+'/app/customerinvoice/bulkPrint?invoiceNos='+invoiceNos;
       var wnd = window.open(url, 'Shipping', 'height=400,width=750,top=100,left=100,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
       wnd.print();
   }   
   
   $scope.verified = function(objTranslationItem) {
       $http.post($stateParams.tenantid+'/app/customerinvoice/toVerify', objTranslationItem).success(function(result) {
           if (result) {
               objTranslationItem.verified = true;
               logger.logSuccess("General Invoice verified successfully");
          //     $scope.getTranslationList();
           }
       });
   }
   
   
   /**
    * print
    */
   $scope.printCustInvoiceDiv = function(invoiceNo){
       
       console.log("print invoice")
       var url = $stateParams.tenantid+'/app/customerinvoice/print?invoiceNo=' + invoiceNo;
       var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
       wnd.print();   
    }
   
   $scope.printCustInvoiceLocal = function(invoiceNo){
       
       console.log("Local print invoice")
       var url = $stateParams.tenantid+'/app/customerinvoice/printLocal?invoiceNo=' + invoiceNo;
       var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
       wnd.print();   
    }

	 $scope.printCustInvoiceUSD = function(invoiceNo){
	     
	     console.log("USD print invoice")
	     var url = $stateParams.tenantid+'/app/customerinvoice/printUSD?invoiceNo=' + invoiceNo;
	     var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
	     wnd.print();   
	  }
	 
	 $scope.fileDownload1 = function() {
		    $("#fileExport1").bind('click', function() {
		    	console.log($(this).attr('href'));
		    });
		    $("#fileExport1").simulateClick('click');

		}
	 
	 $scope.fileDownload = function() {
		    $("#fileExport").bind('click', function() {
		    	console.log($(this).attr('href'));
		    });
		    $("#fileExport").simulateClick('click');

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
   
});

app.controller('GIctrlDelete', function($scope, $http,ngDialog,logger,$location,InvoiceNo,$stateParams) {
    $scope.DeleteConfirm = function(){
        $http.get($stateParams.tenantid+'/app/customerinvoice/delete?invoiceNo='+InvoiceNo).success(function(data) {
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



app.controller('customerInvoiceViewCtrl', function($scope, $window, $rootScope, $location, $filter, $http, logger, 
        $log, ngDialog, $modal, utilsService, ListService, $stateParams,$timeout,validationService,toaster,$state) {
    
    $scope.customerinvoice = {
            invoiceNo:'', invoiceDate:'', company:'', companyCode:'', blRelated:'', customerName:'', customerCode:'',
            mloCode:'', mloName:'', subject:'', currencyName:'', currencyCode:'', exchangeRate:'',
            voyage:'', vesselCode:'', vesselName:'', serviceCode:'', serviceName:'', unit20:'', unit40:'', pol:'', pod:'',
            sailingDate:'', bl:'', port:'', portSequence:'', accountHeadName:'', accountHeadCode:'', 
            TotalBCamount:'', TotalTCamount:'', GIDtl:[],

            customerAddress:'', customerPhoneNo:'', customerFaxNo:'', customerEmail:'', companyAddress:'',
            companyPhoneNo:'', companyFaxNo:'', companyEmail:'', companyCurrency:'',
        }
    
    $scope.generalInvoiceDtlList = function() {
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

    $scope.generalInvoiceDtlList();
    
    $scope.customerInvoiceDtlList = function() {
        var giRow = {
        		containerType:'',
                containerNo:'',
                description:'',
                actualRate:'',
                currency:'',
                exRate:'',
                rate:'',
                qty:'',
                total :'',
                taxFree:'',
                remarks:''
        };
        $scope.customerinvoice.GIDtl.push(giRow);
    }

    $scope.customerInvoiceDtlList();
    
    $scope.viewDisable =true;
    var invoiceNo=$stateParams.invoiceNo;
    if(invoiceNo == undefined || invoiceNo == null || invoiceNo ==""){
        $scope.viewDisable=false;
    }else{
     
            var url = $stateParams.tenantid+'/app/customerinvoice/getInvoiceView?invoiceNo=' + invoiceNo;
            $http.get(url).success(function(result) {
                debugger;
                console.log(" View Data :::::::::::::::::::::::::::");
                console.log(result);
                $scope.customerinvoice = result;
                $scope.customerinvoice.GIDtl = result.giDtl;
            }).error(function(result) {
                logger.logError("Error Please Try Again");
            });
    }
    
    $scope.generalInvoiceTable = false;
   
    var invoiceNo1=$stateParams.invoiceNo1;
    if(invoiceNo1 == undefined || invoiceNo1 == null || invoiceNo1 ==""){
        $scope.viewDisable=false;
    }else{
        debugger;
        $scope.generalInvoiceTable = true;
            var url = $stateParams.tenantid+'/app/customerinvoice/getGeneralInvoiceView?invoiceNo=' + invoiceNo1;
            $http.get(url).success(function(result) {
                debugger;
                console.log(result);
                $scope.customerinvoice = result;
            }).error(function(result) {
                logger.logError("Error Please Try Again");
            });
    }
    
    $scope.cancel1 = function() {
        $state.go('app.reports.finance.invoiceInformation',{tenantid:$stateParams.tenantid});
    };
    
    /**
     * print
     */
    $scope.printCustInvoiceDiv = function(invoiceNo){
        
        console.log("print invoice")
        var url = $stateParams.tenantid+'/app/customerinvoice/print?invoiceNo=' + invoiceNo;
        var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
        wnd.print();   
     }
    
    $scope.printCustInvoiceLocal = function(invoiceNo){
        
        console.log("Local print invoice")
        var url = $stateParams.tenantid+'/app/customerinvoice/printLocal?invoiceNo=' + invoiceNo;
        var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
        wnd.print();   
     }

 	 $scope.printCustInvoiceUSD = function(invoiceNo){
 	     
 	     console.log("USD print invoice")
 	     var url = $stateParams.tenantid+'/app/customerinvoice/printUSD?invoiceNo=' + invoiceNo;
 	     var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
 	     wnd.print();   
 	  }

    $scope.cancel = function() {
        $location.path($stateParams.tenantid+"/invoice/customerinvoice/list");
    };
});

app.service("ListService", function($http, $q,$stateParams) {

    this.getCustomerList = function() {
        var customerList = $q.defer();
        $http.get($stateParams.tenantid+'/app/customerinvoice/getCustomerList').success(function(data) {
            customerList.resolve(data);
        }).error(function(data) {
            customerList.reject("Failed to get Customer List");
        });
        return customerList.promise;
    }

    this.getCustomerListByVoyage = function(VoyageCode) {
        var customerList = $q.defer();
        $http.get($stateParams.tenantid+'/app/customerinvoice/getCustomerListByVoyage?VoyageCode=' + VoyageCode).success(function(data) {
            customerList.resolve(data);
        }).error(function(data) {
            customerList.reject("Failed to get Customer List");
        });
        return customerList.promise;
    }
    
    this.getMloList = function(customerCode,pol) {
        var mloList = $q.defer();
        $http.get($stateParams.tenantid+'/app/customerinvoice/getMloList?CustomerCode=' + customerCode+'&pol=' +pol).success(function(data) {
            mloList.resolve(data);
            

        }).error(function(data) {

            mloList.reject("Failed to get Mlo List");

        });
        return mloList.promise;
    }

    this.getVesselList = function() {
        var voyageList = $q.defer();
        $http.get($stateParams.tenantid+'/app/customerinvoice/getVesselList').success(function(data) {
            voyageList.resolve(data);

        }).error(function(data) {

            voyageList.reject("Failed to get Voyage Vessel List");

        });
        return voyageList.promise;
    }
    this.getVoyageList = function(vesselCode) {
        var voyageList = $q.defer();
        $http.get($stateParams.tenantid+'/app/customerinvoice/getVoyageList?vesselCode=' + vesselCode).success(function(data) {
            voyageList.resolve(data);

        }).error(function(data) {

            voyageList.reject("Failed to get Voyage Vessel List");

        });
        return voyageList.promise;
    }

    this.getCompanyCurrency = function(companyCode) {
        var voyageList = $q.defer();
        $http.get('app/customerinvoice/getVoyageList?vesselCode=' + vesselCode).success(function(data) {
            voyageList.resolve(data);

        }).error(function(data) {

            voyageList.reject("Failed to get Voyage Vessel List");

        });
        return voyageList.promise;
    }
    
    this.getBlList = function(VoyageId,pol,customer) {
        var blList = $q.defer();
        $http.get($stateParams.tenantid+'/app/customerinvoice/getBlList?voyageCode=' + VoyageId+'&pol=' +pol+'&customer='+customer).success(function(data) {
            blList.resolve(data);

        }).error(function(data) {

            blList.reject("Failed to get Mlo List");

        });
        return blList.promise;
    }

    this.getPortList = function(VoyageId) {

        var portList = $q.defer();
        $http.get($stateParams.tenantid+'/app/customerinvoice/getportList?voyageCode=' + VoyageId).success(function(data) {
            portList.resolve(data);

        }).error(function(data) {

            portList.reject("Failed to get portList List");

        });
        return portList.promise;
    }
    
    this.getSubAccountList = function(){
        var subAccountList = $q.defer();
        $http.get($stateParams.tenantid+'/app/commonUtility/getSubAccountCodeList').success(function(datas) {
            subAccountList.resolve(datas.commonUtilityBean);
        }).error(function(data) {
            subAccountList.reject("Failed to get Sub Account Code List");
        });
        return subAccountList.promise;
    }
    
    this.getAccountHeadList = function() {

        var accountHeadList = $q.defer();
        $http.get($stateParams.tenantid+'/app/customerinvoice/getAccountHeadList').success(function(data) {
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
    $scope.$watch('customerinvoice.GIDtl[trIndex].voyageCode', function(newValue, oldValue) {
        debugger;
        if (newValue != '' && newValue != undefined) {
                $http.get($stateParams.tenantid+'/app/commonUtility/getVesselService?voyageCode='+newValue).success(function(datas) {
                    $scope.customerinvoice.GIDtl[$scope.$index].vesselCode=datas.vesselCode;
                    $scope.customerinvoice.GIDtl[$scope.$index].sectorCode=datas.sectorCode;
                    }).error(function(datas) {
                });
       
        }
    });
    
    $scope.$watch('customerinvoice.GIDtl[trIndex].accountHead', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
            $scope.customerinvoice.GIDtl[$scope.$index].voyageCode = $scope.customerinvoice.Voyage;
            $scope.customerinvoice.GIDtl[$scope.$index].vesselCode = $scope.customerinvoice.VesselName;
            $scope.customerinvoice.GIDtl[$scope.$index].sectorCode = $scope.customerinvoice.ServiceName;
            if(newValue == '10080001'){
                $scope.customerinvoice.GIDtl[$scope.$index].isSubAccountCode =true;
                $http.get($stateParams.tenantid+'/app/commonUtility/getSubAccountCodeListTradeDebtors').success(function(datas) {
                    $scope.customerinvoice.GIDtl[$scope.$index].subAccountCodeList = datas;
                    }).error(function(datas) {
                });
            }else if(newValue == '20010001'){
                $scope.customerinvoice.GIDtl[$scope.$index].isSubAccountCode =true;
                $http.get($stateParams.tenantid+'/app/commonUtility/getSubAccountCodeListTradeCreditors').success(function(datas) {
                    $scope.customerinvoice.GIDtl[$scope.$index].subAccountCodeList = datas;
                    }).error(function(datas) {
                });   
            }else if(newValue == '10070001'){
                
                $scope.customerinvoice.GIDtl[$scope.$index].isSubAccountCode =true;
                $http.get($stateParams.tenantid+'/app/commonUtility/getStaffListForAdvances').success(function(datas) {
                    $scope.customerinvoice.GIDtl[$scope.$index].subAccountCodeList = datas;
                    }).error(function(datas) {
                });   
            }else if(newValue == '10090017'){
                $scope.customerinvoice.GIDtl[$scope.$index].isSubAccountCode =true;
                $http.get($stateParams.tenantid+'/app/commonUtility/getonlySupplier').success(function(datas) {
                    $scope.customerinvoice.GIDtl[$scope.$index].subAccountCodeList = datas;
                    }).error(function(datas) {
                });   
            }else{
                $scope.customerinvoice.GIDtl[$scope.$index].subAccountCodeList=[];
                $scope.customerinvoice.GIDtl[$scope.$index].isSubAccountCode =false;
            }
            
                $http.get($stateParams.tenantid+'/app/commonUtility/getAttributesList?accountCode='+newValue).success(function(datas) {
                $scope.customerinvoice.GIDtl[$scope.$index].attributeList=datas;
                if(newValue==oldValue){
                    $scope.isOnChange =false;
                }else{
                    $scope.isOnChange =true;
                }
                if(!$scope.customerinvoice.isEdit || $scope.isOnChange){
                     
                //$scope.customerinvoice.GIDtl[$scope.$index].voyageCode='';
                //$scope.customerinvoice.GIDtl[$scope.$index].vesselCode='';
                //$scope.customerinvoice.GIDtl[$scope.$index].sectorCode='';
                $scope.customerinvoice.GIDtl[$scope.$index].employeeCode='';
                $scope.customerinvoice.GIDtl[$scope.$index].portCode='';
                $scope.customerinvoice.GIDtl[$scope.$index].portSequence='';
                $scope.customerinvoice.GIDtl[$scope.$index].departmentCode='';
                $scope.customerinvoice.GIDtl[$scope.$index].agentCode='';
                $scope.customerinvoice.GIDtl[$scope.$index].countryCode='';
                $scope.customerinvoice.GIDtl[$scope.$index].customerCode='';
                $scope.customerinvoice.GIDtl[$scope.$index].supplierCode='';
                $scope.customerinvoice.GIDtl[$scope.$index].designationCode='';
                $scope.customerinvoice.GIDtl[$scope.$index].costCenter='';
                $scope.customerinvoice.GIDtl[$scope.$index].companyCode='';
                $scope.customerinvoice.GIDtl[$scope.$index].quantityGO='';
                $scope.customerinvoice.GIDtl[$scope.$index].quantityFO='';
                }
                
                $scope.customerinvoice.GIDtl[$scope.$index].isVoyage=false;
                $scope.customerinvoice.GIDtl[$scope.$index].isVessel=false;
                $scope.customerinvoice.GIDtl[$scope.$index].isService=false;
                $scope.customerinvoice.GIDtl[$scope.$index].isEmployee=false;
                $scope.customerinvoice.GIDtl[$scope.$index].isPort=false;
                $scope.customerinvoice.GIDtl[$scope.$index].isDepartment=false;
                $scope.customerinvoice.GIDtl[$scope.$index].isAgent=false;
                $scope.customerinvoice.GIDtl[$scope.$index].isLocation=false;
                $scope.customerinvoice.GIDtl[$scope.$index].isCustomer=false;
                $scope.customerinvoice.GIDtl[$scope.$index].isSupplier=false;
                $scope.customerinvoice.GIDtl[$scope.$index].isDesignation=false;
                $scope.customerinvoice.GIDtl[$scope.$index].isCostCenter=false;
                $scope.customerinvoice.GIDtl[$scope.$index].isCompany=false;
                $scope.customerinvoice.GIDtl[$scope.$index].isQuantityGO=false;
                $scope.customerinvoice.GIDtl[$scope.$index].isQuantityFO=false;
                $scope.customerinvoice.GIDtl[$scope.$index].isPortSequence=false;
             
                // code added for mandatory
                $scope.customerinvoice.GIDtl[$scope.$index].isVoyageMan=false;
                $scope.customerinvoice.GIDtl[$scope.$index].isVesselMan=false;
                $scope.customerinvoice.GIDtl[$scope.$index].isServiceMan=false;
                $scope.customerinvoice.GIDtl[$scope.$index].isEmployeeMan=false;
                $scope.customerinvoice.GIDtl[$scope.$index].isPortMan=false;
                $scope.customerinvoice.GIDtl[$scope.$index].isDepartmentMan=false;
                $scope.customerinvoice.GIDtl[$scope.$index].isAgentMan=false;
                $scope.customerinvoice.GIDtl[$scope.$index].isLocationMan=false;
                $scope.customerinvoice.GIDtl[$scope.$index].isCustomerMan=false;
                $scope.customerinvoice.GIDtl[$scope.$index].isSupplierMan=false;
                $scope.customerinvoice.GIDtl[$scope.$index].isDesignationMan=false;
                $scope.customerinvoice.GIDtl[$scope.$index].isCostCenterMan=false;
                $scope.customerinvoice.GIDtl[$scope.$index].isQuantityGOMan=false;
                $scope.customerinvoice.GIDtl[$scope.$index].isQuantityFOMan=false;
                $scope.customerinvoice.GIDtl[$scope.$index].isPortSequenceMan=false;
                
                angular.forEach($scope.customerinvoice.GIDtl[$scope.$index].attributeList, function(row, rowindex) {
                    debugger;
                    if(row.attributeName == "Voyage"){
                        $scope.customerinvoice.GIDtl[$scope.$index].isVoyage=true;                       
                       /* if($scope.customerinvoice.Voyage !='')
                            $scope.customerinvoice.GIDtl[$scope.$index].voyageCode=$scope.customerinvoice.Voyage;*/
                        console.log("row.isMandatory" +row.isMandatory)
                        if(row.isMandatory == 'Y'){
                            if($scope.isOwner)
                                $scope.customerinvoice.GIDtl[$scope.$index].isVoyageMan=false;
                            else
                                $scope.customerinvoice.GIDtl[$scope.$index].isVoyageMan=true;
                        }
                    }else if(row.attributeName == "Vessel"){
                        $scope.customerinvoice.GIDtl[$scope.$index].isVessel=true;
                        
                        /*if($scope.customerinvoice.VesselName!='')
                            $scope.customerinvoice.GIDtl[$scope.$index].vesselCode =$scope.customerinvoice.VesselName;*/
                        
                        if(row.isMandatory == 'Y'){
                            if($scope.isOwner)
                                $scope.customerinvoice.GIDtl[$scope.$index].isVesselMan=false;
                            else
                                $scope.customerinvoice.GIDtl[$scope.$index].isVesselMan=true;
                        }
                    }else if(row.attributeName == "Service"){
                        $scope.customerinvoice.GIDtl[$scope.$index].isService=true;
                        if(row.isMandatory == 'Y'){
                            if($scope.isOwner)
                                $scope.customerinvoice.GIDtl[$scope.$index].isServiceMan=false;
                            else
                                $scope.customerinvoice.GIDtl[$scope.$index].isServiceMan=true;
                        }
                    }else if(row.attributeName == "Employee"){
                        $scope.customerinvoice.GIDtl[$scope.$index].isEmployee=true;
                       /* if(row.isMandatory == 'Y'){
                            $scope.customerinvoice.GIDtl[$scope.$index].isEmployeeMan=true;
                        }*/
                    }else if(row.attributeName == "Port"){
                        $scope.customerinvoice.GIDtl[$scope.$index].isPort=true;
                        /*if(row.isMandatory == 'Y'){
                            $scope.customerinvoice.GIDtl[$scope.$index].isPortMan=true;
                        }*/
                    }else if(row.attributeName == "Department"){
                        $scope.customerinvoice.GIDtl[$scope.$index].isDepartment=true;
                        /*if(row.isMandatory == 'Y'){
                            $scope.customerinvoice.GIDtl[$scope.$index].isDepartmentMan=true;
                        }*/
                    }else if(row.attributeName == "Agent"){
                        $scope.customerinvoice.GIDtl[$scope.$index].isAgent=true;
                      /*  if(row.isMandatory == 'Y'){
                            $scope.customerinvoice.GIDtl[$scope.$index].isAgentMan=true;
                        }*/
                    }else if(row.attributeName == "Location"){
                        $scope.customerinvoice.GIDtl[$scope.$index].isLocation=true;
                       /* if(row.isMandatory == 'Y'){
                            $scope.customerinvoice.GIDtl[$scope.$index].isLocationMan=true;
                        }*/
                    }else if(row.attributeName == "Customer"){
                        $scope.customerinvoice.GIDtl[$scope.$index].isCustomer=true;
                       /* if(row.isMandatory == 'Y'){
                            $scope.customerinvoice.GIDtl[$scope.$index].isCustomerMan=true;
                        }*/
                    }else if(row.attributeName == "Supplier"){
                        $scope.customerinvoice.GIDtl[$scope.$index].isSupplier=true;
                       /* if(row.isMandatory == 'Y'){
                            $scope.customerinvoice.GIDtl[$scope.$index].isSupplierMan=true;
                        }*/
                    }else if(row.attributeName == "Designation"){
                        $scope.customerinvoice.GIDtl[$scope.$index].isDesignation=true;
                     /*   if(row.isMandatory == 'Y'){
                            $scope.customerinvoice.GIDtl[$scope.$index].isDesignationMan=true;
                        }*/
                    }else if(row.attributeName == "Cost Center"){
                        $scope.customerinvoice.GIDtl[$scope.$index].isCostCenter=true;
                      /*  if(row.isMandatory == 'Y'){
                            $scope.customerinvoice.GIDtl[$scope.$index].isCostCenterMan=true;
                        }*/
                    }else if(row.attributeName == "Company"){
                        $scope.customerinvoice.GIDtl[$scope.$index].isCompany=true;
                       /* if(row.isMandatory == 'Y'){
                            $scope.customerinvoice.GIDtl[$scope.$index].isCompanyMan=true;
                        }*/
                    }else if(row.attributeName == "Quantity (MT) GO"){
                        $scope.customerinvoice.GIDtl[$scope.$index].isQuantityGO=true;
                        /*if(row.isMandatory == 'Y'){
                            $scope.customerinvoice.GIDtl[$scope.$index].isQuantityGOMan=true;
                        }*/
                    }else if(row.attributeName == "Quantity (MT) FO"){
                        $scope.customerinvoice.GIDtl[$scope.$index].isQuantityFO=true;
                       /* if(row.isMandatory == 'Y'){
                            $scope.customerinvoice.GIDtl[$scope.$index].isQuantityFOMan=true;
                        }*/
                    }else if(row.attributeName == "Port with Sequence"){
                        $scope.customerinvoice.GIDtl[$scope.$index].isPortSequence=true;
                        /*if(row.isMandatory == 'Y'){
                            $scope.customerinvoice.GIDtl[$scope.$index].isPortSequenceMan=true;
                        }*/
                    }
                    });
                }).error(function(datas) {
            });
        }else{
            $scope.customerinvoice.GIDtl[$scope.$index].subAccountCodeList=[];
        
        }
    });
});
app.controller('GItableViewCtrl', function($scope,$http, $filter,logger,$stateParams){
    
    $scope.$watch('customerinvoice.giDtl[trIndex].accountHead', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
            if(newValue == '10080001'){
                $http.get($stateParams.tenantid+'/app/commonUtility/getSubAccountCodeListTradeDebtors').success(function(datas) {
                    $scope.customerinvoice.giDtl[$scope.$index].subAccountCodeList = datas;
                    $scope.customerinvoice.giDtl[$scope.$index].isSubAccountCode =true;
                    }).error(function(datas) {
                });
            }else if(newValue == '20010001'){
                $http.get($stateParams.tenantid+'/app/commonUtility/getSubAccountCodeListTradeCreditors').success(function(datas) {
                    $scope.customerinvoice.giDtl[$scope.$index].subAccountCodeList = datas;
                    $scope.customerinvoice.giDtl[$scope.$index].isSubAccountCode =true;
                    }).error(function(datas) {
                });   
            }else if(newValue == '10070001'){
                $http.get($stateParams.tenantid+'/app/commonUtility/getStaffListForAdvances').success(function(datas) {
                    $scope.customerinvoice.giDtl[$scope.$index].subAccountCodeList = datas;
                    $scope.customerinvoice.giDtl[$scope.$index].isSubAccountCode =true;
                    }).error(function(datas) {
                });   
            }else{
                $scope.customerinvoice.giDtl[$scope.$index].subAccountCodeList=[];
                $scope.customerinvoice.giDtl[$scope.$index].isSubAccountCode =false;
            }
            
                debugger;
                $http.get($stateParams.tenantid+'/app/commonUtility/getAttributesList?accountCode='+newValue).success(function(datas) {
                $scope.customerinvoice.giDtl[$scope.$index].attributeList=datas;
                if(newValue==oldValue){
                    $scope.isOnChange =false;
                }else{
                    $scope.isOnChange =true;
                }
                if(!$scope.viewDisable || $scope.isOnChange){
                   // $scope.customerinvoice.giDtl[$scope.$index].voyageCode='';
                   // $scope.customerinvoice.giDtl[$scope.$index].vesselCode='';
                   // $scope.customerinvoice.giDtl[$scope.$index].sectorCode='';
                    $scope.customerinvoice.giDtl[$scope.$index].employeeCode='';
                    $scope.customerinvoice.giDtl[$scope.$index].portCode='';
                    $scope.customerinvoice.giDtl[$scope.$index].portSequence='';
                    $scope.customerinvoice.giDtl[$scope.$index].departmentCode='';
                    $scope.customerinvoice.giDtl[$scope.$index].agentCode='';
                    $scope.customerinvoice.giDtl[$scope.$index].countryCode='';
                    $scope.customerinvoice.giDtl[$scope.$index].customerCode='';
                    $scope.customerinvoice.giDtl[$scope.$index].supplierCode='';
                    $scope.customerinvoice.giDtl[$scope.$index].designationCode='';
                    $scope.customerinvoice.giDtl[$scope.$index].costCenter='';
                    $scope.customerinvoice.giDtl[$scope.$index].companyCode='';
                    $scope.customerinvoice.giDtl[$scope.$index].quantityGO='';
                    $scope.customerinvoice.giDtl[$scope.$index].quantityFO='';
                }
                
                $scope.customerinvoice.giDtl[$scope.$index].isVoyage=false;
                $scope.customerinvoice.giDtl[$scope.$index].isVessel=false;
                $scope.customerinvoice.giDtl[$scope.$index].isService=false;
                $scope.customerinvoice.giDtl[$scope.$index].isEmployee=false;
                $scope.customerinvoice.giDtl[$scope.$index].isPort=false;
                $scope.customerinvoice.giDtl[$scope.$index].isDepartment=false;
                $scope.customerinvoice.giDtl[$scope.$index].isAgent=false;
                $scope.customerinvoice.giDtl[$scope.$index].isLocation=false;
                $scope.customerinvoice.giDtl[$scope.$index].isCustomer=false;
                $scope.customerinvoice.giDtl[$scope.$index].isSupplier=false;
                $scope.customerinvoice.giDtl[$scope.$index].isDesignation=false;
                $scope.customerinvoice.giDtl[$scope.$index].isCostCenter=false;
                $scope.customerinvoice.giDtl[$scope.$index].isCompany=false;
                $scope.customerinvoice.giDtl[$scope.$index].isQuantityGO=false;
                $scope.customerinvoice.giDtl[$scope.$index].isQuantityFO=false;
                $scope.customerinvoice.giDtl[$scope.$index].isPortSequence=false;
             
                angular.forEach($scope.customerinvoice.giDtl[$scope.$index].attributeList, function(row, rowindex) {
                    if(row.attributeName == "Voyage"){
                        $scope.customerinvoice.giDtl[$scope.$index].isVoyage=true;
                    }else if(row.attributeName == "Vessel"){
                        $scope.customerinvoice.giDtl[$scope.$index].isVessel=true;
                    }else if(row.attributeName == "Service"){
                        $scope.customerinvoice.giDtl[$scope.$index].isService=true;
                    }else if(row.attributeName == "Employee"){
                        $scope.customerinvoice.giDtl[$scope.$index].isEmployee=true;
                    }else if(row.attributeName == "Port"){
                        $scope.customerinvoice.giDtl[$scope.$index].isPort=true;
                    }else if(row.attributeName == "Department"){
                        $scope.customerinvoice.giDtl[$scope.$index].isDepartment=true;
                    }else if(row.attributeName == "Agent"){
                        $scope.customerinvoice.giDtl[$scope.$index].isAgent=true;
                    }else if(row.attributeName == "Location"){
                        $scope.customerinvoice.giDtl[$scope.$index].isLocation=true;
                    }else if(row.attributeName == "Customer"){
                        $scope.customerinvoice.giDtl[$scope.$index].isCustomer=true;
                    }else if(row.attributeName == "Supplier"){
                        $scope.customerinvoice.giDtl[$scope.$index].isSupplier=true;
                    }else if(row.attributeName == "Designation"){
                        $scope.customerinvoice.giDtl[$scope.$index].isDesignation=true;
                    }else if(row.attributeName == "Cost Center"){
                        $scope.customerinvoice.giDtl[$scope.$index].isCostCenter=true;
                    }else if(row.attributeName == "Company"){
                        $scope.customerinvoice.giDtl[$scope.$index].isCompany=true;
                    }else if(row.attributeName == "Quantity (MT) GO"){
                        $scope.customerinvoice.giDtl[$scope.$index].isQuantityGO=true;
                    }else if(row.attributeName == "Quantity (MT) FO"){
                        $scope.customerinvoice.giDtl[$scope.$index].isQuantityFO=true;
                    }else if(row.attributeName == "Port with Sequence"){
                        $scope.customerinvoice.giDtl[$scope.$index].isPortSequence=true;
                    }
                    });
                }).error(function(datas) {
            });
        }else{
            $scope.customerinvoice.giDtl[$scope.$index].subAccountCodeList=[];
        
        }
    });
    
    
});