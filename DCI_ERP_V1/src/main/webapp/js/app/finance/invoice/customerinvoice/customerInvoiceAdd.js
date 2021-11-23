app.controller('customerInvoiceAddCtrl', function($scope, $window, $rootScope, $location, $filter, $http, logger, 
        $log, ngDialog, $modal, utilsService, $stateParams,$timeout,validationService,toaster) {

    $scope.mloList=[];
    $scope.PorthdrList=[];
    $scope.voyagehdrList=[];
    $scope.customerinvoice = {
        Company : '',
        CompanyCode : '',
        CustomerName : '', 
        MloName : '', 
        Voyage : '', 
        VesselName : '', 
        currency:'KSH',
        AccountName : '', 
       // Company : '', 
        ServiceName : '',
        CurrencyName : '', 
        exchangeRate : '1.00', 
        fromCurrency: '',
        toCurrency:'',
        Pol : '', 
        Pod : '', 
        Subject : '', 
        Unit20 : '', 
        Unit40 : '', 
       // Subject : '', 
        bl : '',
        exchangeRateFrom : '', 
        exchangeRateTo : '', 
        currencyValue : '',
        fraction : '', 
        InvoiceDate : '',
        totalBCamount : '', 
        totalTCamount : '', 
        BlRelated : true,
        isEdit : false,
        GIDtl : [],
        miscelList : []
    }
    $scope.currentURL=$location.protocol() + '://'+ $location.host() +':'+  $location.port()+"/#" +$location.path();
    
    if(window.localStorage.getItem('giv')==$scope.currentURL){
        alert('window ' + $scope.currentURL + ' is already opened');
       // window.focus();
        //window.open($rootScope.currentURL,'_self').close();
      
       // window.close();
       // localStorage.removeItem('purchaseIv');
    }else{
        window.localStorage.setItem('giv', $scope.currentURL);
        //window.localStorage.removeItem('purchaseIv');
    }
    $(window).unload(function(){
      //  debugger;
       //alert("INSIDE UNLOAD")
         localStorage.removeItem('giv');
       });

    $scope.cancel = function() {
        $location.path($stateParams.tenantid+"/invoice/customerinvoice/list");
    };
    $scope.onLoadDropdowns = function() {
        $http.get($stateParams.tenantid+'/app/usermaster/getCompanyList?formCode='+$('#form_code_id').val()).success(function(datas) {
            $scope.companyList = datas;
            var foundItemDest = $filter('filter')($scope.companyList, { baseCompany:  1 })[0];
      //      $scope.customerinvoice.CompanyCode=foundItemDest.id;
            }).error(function(datas) {
        });
        
        
        $http.get($stateParams.tenantid+'/app/customerinvoice/getInvoiceNo').success(function(datas) {
        	console.log(" ::::::Invoice No::::::datas ::::::::::::::::");
        	console.log(datas);
            $scope.customerinvoice.invoiceNo = datas.InvoiceNo;
            }).error(function(datas) {
        });
        
        $http.get($stateParams.tenantid+'/app/commonUtility/getCountryList').success(function(datas) {
            $scope.countryList = datas;
            }).error(function(datas) {
        });
        
        $http.get($stateParams.tenantid+'/app/commonUtility/mlomaster').success(function(datas) {
        	console.log(" ::::::::::::datas ::::::::::::::::");
        	console.log(datas.commonUtilityBean);
            $scope.customerList = datas.commonUtilityBean;
            }).error(function(datas) {
        });
        
//        $http.get($stateParams.tenantid+'/app/commonUtility/getTripsList').success(function(datas) {
//        	console.log(" :::::::::TRIP:::datas ::::::::::::::::");
//        	console.log(datas);
//        	$scope.tripsList = datas;
//            }).error(function(datas) {
//        });
        
        $http.get($stateParams.tenantid+'/app/purchaseinvoice/getCurrencyList').success(function(datas) {
            $scope.currencyList = datas;
            }).error(function(datas) {
        });
    };
    
    $scope.onLoadDropdowns();
    
    
    
    $scope.$watch('customerinvoice.customerCode', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
        	var customerCode = $scope.customerinvoice.customerCode;
            $http.get($stateParams.tenantid+'/app/customerinvoice/getTripList?customerCode='+customerCode).success(function(datas) {
               
            	$scope.tripsList = datas.tripList;

                }).error(function(datas) {
            });
        }
   });
    
    
    
    
    

    $('#invDate').datetimepicker({
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
    $scope.customerinvoice.invDate = today;
    /*$scope.checkDatesCL = function(InvoiceDate){
        var res = $scope.customerinvoice.InvoiceDate.split("/");
        $http.get($stateParams.tenantid+'/app/cashbankreceipt/getloggedcompany?closingDate='+$scope.customerinvoice.InvoiceDate).success(function(datas) {
            if(datas){
                logger.logError("Account closed for year "+ res[2]);
                $scope.customerinvoice.InvoiceDate = today;
            }
        })
    }*/

    debugger;
    var generalObj = angular.copy($scope.customerinvoice, generalObj);
    var listVariable = Object.keys(generalObj);

   /* $scope.$watchCollection('customerinvoice', function(newVal, oldVal) {
        if (newVal != undefined) {
            var userSelected = $scope.getValueForSelect(listVariable, newVal, oldVal);
            if (angular.isDefined(userSelected)) {
                $scope.selectedDropDown(userSelected);
            }
        }
    }, true);*/

    $scope.$watch('customerinvoice.tripCode', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
        	var cusCode = $scope.customerinvoice.customerCode;
            $http.get($stateParams.tenantid+'/app/customerinvoice/getTripDetails?tripId='+newValue+'&cusCode='+cusCode).success(function(datas) {
                console.log("Trip Details ::::::::::::::");
                console.log(datas);
                
                $scope.customerinvoice.truckNo = datas.customerInvoiceBean.truckNo;
                $scope.customerinvoice.trailerNo = datas.customerInvoiceBean.trailerNo;
                $scope.customerinvoice.pol = datas.customerInvoiceBean.pol;
                $scope.customerinvoice.pod = datas.customerInvoiceBean.pod;
                $scope.customerinvoice.workNo = datas.customerInvoiceBean.workNo;
                
                $scope.customerinvoice.GIDtl = datas.lGeneralInvoiceDtlList;
                
                }).error(function(datas) {
            });
        }
   });
  
    $scope.getValueForSelect = function(listVariable, newValObj, oldValObj) {
        var singleDeclaredvariable = null;
        angular.forEach(listVariable, function(value) {
            if (newValObj[value] != oldValObj[value])
                singleDeclaredvariable = value;
        });
        return singleDeclaredvariable;
    }

        
    $scope.submit = function(customerinvoiceForm,customerinvoice) {
        if (new validationService().checkFormValidity($scope.customerinvoiceForm)) {
            $scope.save();
        } else {
            toaster.pop('error', "Please fill the required fields", 
                    logger.getErrorHtmlNew($scope.customerinvoiceForm.$validationSummary), 5000, 'trustedHtml');
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
        var check ;
        
        
        if($scope.validationCheck)
        	{
        	
            $scope.customerinvoice.GIDtl= $filter('filter')( $scope.customerinvoice.GIDtl, { select: true}, true);

        /*var isExgRateValid = $scope.validateExchangeRate($scope.customerinvoice);
        if(isExgRateValid){*/
            if ($scope.customerinvoice.isEdit == false) {
                    $http.post($stateParams.tenantid+'/app/customerinvoice/save', $scope.customerinvoice).success(function(data) {
                        if (data.success == true) {
                            logger.logSuccess("Created successfully!");
                            $location.path($stateParams.tenantid+"/invoice/customerinvoice/list");
                        } else {
                            if(data.message != null && data.message !=''){
                                logger.logError(data.message);
                            }else{
                            logger.logError("Unable to Save");
                            }
                        }
                    }).error(function(data) {
                    });
            }else{
                //$scope.customerinvoice.InvoiceDate = $("#txtInvoiceDate").val();
                
                 $http.post($stateParams.tenantid+'/app/customerinvoice/update', $scope.customerinvoice).success(function(data) {
                    if (data == true) {
                        logger.logSuccess("Updated successfully!");
                        $location.path($stateParams.tenantid+"/invoice/generalinvoice/list");
                    } else {
                        logger.logError("Unable to Save");
                    }
                }).error(function(data) {
                });
            
            }
        /*}else{
            logger.logError($scope.logValidExgRateErrorMessage);
        }*/
    }
    else
    	{
             logger.logError("Please select atleast one row!");

    	}
    };
    
    $scope.logValidExgRateErrorMessage = "";
    
    $scope.validateExchangeRate = function(customerinvoice){
        debugger;
        var HdrLogErrMessage="",DtlLogErrMessage = "",loggerMsg="", isFlag=true;
        if(parseFloat(customerinvoice.exchangeRate) < parseFloat(customerinvoice.fromCurrency) 
                || parseFloat(customerinvoice.exchangeRate) > parseFloat(customerinvoice.toCurrency)){
            HdrLogErrMessage="Please Enter Exchange Rate Between "+customerinvoice.fromCurrency+" and "+
            customerinvoice.toCurrency+"<br><br>";      
            //customerinvoice.exchangeRate=0;
            $scope.customerinvoice.exchangeRate ='';
            isFlag = false;
          
        }
        var pinLength= customerinvoice.GIDtl.length;
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
                if(     $scope.customerinvoice.MloName=='PFOR0004' ||
                        $scope.customerinvoice.MloName=='PWAN0002'){
                    $scope.customerinvoice.CurrencyCode = 'AED';
                    $scope.customerinvoice.CurrencyName = 'AED';
                    $scope.customerinvoice.exchangeRate =3.685;
                    $scope.customerinvoice.fromCurrency=3.660;
                    $scope.customerinvoice.toCurrency=3.686;
                }else if($scope.customerinvoice.MloName == 'PEVE0002'||
                        $scope.customerinvoice.MloName == 'PUNI0027'){
                    $scope.customerinvoice.CurrencyCode = 'AED';
                    $scope.customerinvoice.CurrencyName = 'AED';
                    $scope.customerinvoice.exchangeRate =3.67;
                    $scope.customerinvoice.fromCurrency=3.660;
                    $scope.customerinvoice.toCurrency=3.686;
                }else if($scope.customerinvoice.MloName == 'PACE0001'){
                    $scope.customerinvoice.CurrencyCode = 'AED';
                    $scope.customerinvoice.CurrencyName = 'AED';
                    $scope.customerinvoice.exchangeRate =3.68;
                    $scope.customerinvoice.fromCurrency=3.660;
                    $scope.customerinvoice.toCurrency=3.686;
                }
                else{
                    var index = $scope.getIndex($scope.mloList, $scope.customerinvoice.MloName);
                    if(index !=undefined){
                      
                        $scope.customerinvoice.CurrencyCode = $scope.mloList[index].CurrencyCode;
                        $scope.customerinvoice.CurrencyName = $scope.mloList[index].CurrencyCode;
                        if($scope.sailingDate !='' && $scope.sailingDate != undefined){
                            $http.get($stateParams.tenantid+'/app/commonUtility/getExchangeRateWithCurrencyBySailingDate?currencyCode='+ $scope.customerinvoice.CurrencyCode+'&sailingDate='+$scope.sailingDate).success(function(data) {
                                //$scope.customerinvoice.ExchangeRate=data;    
                                debugger;
                                $scope.customerinvoice.exchangeRate=data.exchangeRate;
                                $scope.customerinvoice.fromCurrency=data.fromCurrency;
                                $scope.customerinvoice.toCurrency=data.toCurrency;     
                            }).error(function(data) {
                            });
                        }else{
                            $http.get($stateParams.tenantid+'/app/commonUtility/getExchangeRateWithCurrencyByMaxDate?currencyCode='+ $scope.customerinvoice.CurrencyCode).success(function(data) {
                                //$scope.customerinvoice.ExchangeRate=data;    
                                debugger;
                                $scope.customerinvoice.exchangeRate=data.exchangeRate;
                                $scope.customerinvoice.fromCurrency=data.fromCurrency;
                                $scope.customerinvoice.toCurrency=data.toCurrency;     
                            }).error(function(data) {
                            });
                        }
                        
                    }
                }
               
                break;
                
            case 'VesselName':
             //   $scope.dataList = ListService.getVoyageList($scope.customerinvoice.VesselName);
                $scope.dataList.then(function(voyageLists) {
    
                    $scope.voyagehdrList = voyageLists;
    
                });
                break;
             
            case 'CompanyCode':
                debugger;
                $http.get($stateParams.tenantid+'/app/generalinvoice/getCompanyCurrency?CompanyCode='+$scope.customerinvoice.CompanyCode).success(function(datas) {
                    $scope.companyCurrency=datas.CurrencyCode;
                    }).error(function(datas) {
                });
                if($scope.customerinvoice.CompanyCode=="C0001"){
                    $scope.isFeederCompanyCurrency=true;
                }else{
                    $scope.isFeederCompanyCurrency=false;
                }
                
                break;
                
            case 'Voyage':
                
                $scope.sailingDate='';
              //  $scope.dataList = ListService.getCustomerListByVoyage($scope.customerinvoice.Voyage);
                $scope.dataList.then(function(customerLists) {
                    if(customerLists.length>0)
                        $scope.customerhdrList = customerLists;
                });
                
               // $scope.dataList = ListService.getPortList($scope.customerinvoice.Voyage);
                $scope.dataList.then(function(PortLists) {
                    $scope.PorthdrList = PortLists;
                });
    
                var index = $scope.getIndex($scope.voyagehdrList, $scope.customerinvoice.Voyage);
                $scope.customerinvoice.ServiceName = $scope.voyagehdrList[index].ServiceName;
                break;
                
                
            case 'Pol':
                debugger;
                
            //    $scope.dataList = ListService.getMloList($scope.customerinvoice.CustomerName,$scope.customerinvoice.Pol);
                $scope.dataList.then(function(mloLists) {
                    $scope.mloList = mloLists;
                    debugger;
                    console.log($scope.mloList);
                });
                break;
             
            case 'CustomerName':
               // $scope.dataList = ListService.getMloList($scope.customerinvoice.CustomerName,$scope.customerinvoice.Pol);
                $scope.dataList.then(function(mloLists) {
                    $scope.mloList = mloLists;
                    debugger;
                    console.log($scope.mloList);
                });
                
               // $scope.dataList = ListService.getBlList($scope.customerinvoice.Voyage,$scope.customerinvoice.Pol,$scope.customerinvoice.CustomerName);
                $scope.dataList.then(function(blLists) {
                    $scope.blList = blLists;
                });
                
                if($scope.customerinvoice.Voyage !='' && $scope.customerinvoice.Pol !='' && $scope.customerinvoice.CustomerName !=''){
                    $http.get($stateParams.tenantid+'/app/customerinvoice/getSailingDate?voyageCode=' + $scope.customerinvoice.Voyage+'&pol=' +$scope.customerinvoice.Pol+'&customer='+$scope.customerinvoice.CustomerName).success(function(datas) {
                        $scope.sailingDate = datas.sailingDate;
                        }).error(function(datas) {
                    });
                }
                
            break;
            
            case 'bl':
                $http.get($stateParams.tenantid+'/app/customerinvoice/fetchDetailList?bl='+$scope.customerinvoice.bl).success(function(datas) {
                    console.log(datas.GIDtl);
                    $scope.customerinvoice.GIDtl = datas.GIDtl;
                    }).error(function(datas) {
                });
                
            break;
            /*case 'ExchangeRate':   
                $scope.exchagerateGIhdr($scope.customerinvoice.ExchangeRate);    
                break;*/        
            case 'CurrencyName':   
                $scope.getcurrencyValues($scope.customerinvoice.CurrencyName);    
                
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
    
    $scope.addRow = function(miscelList) {
    	debugger
        var table = {
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
        
    	 $scope.customerinvoice.GIDtl.push(table);
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
        $scope.customerinvoice.GIDtl = $scope.tablerow;;
    };
   
    
   
    
    $scope.getcurrencyValues = function(currencyValue){
        if(currencyValue!=null && currencyValue!=undefined && currencyValue!=""){
            $http.get($stateParams.tenantid+'/app/commonUtility/getExchangeRateWithCurrency?currencyCode='+currencyValue).success(function(data) {
                debugger;
                //$scope.customerinvoice.ExchangeRate=data;                            
                $scope.customerinvoice.exchangeRate=data.exchangeRate;
                $scope.customerinvoice.fromCurrency=data.fromCurrency;
                $scope.customerinvoice.toCurrency=data.toCurrency;     
            }).error(function(data) {
            });
        }else{
            $scope.customerinvoice.exchangeRate='';
            $scope.customerinvoice.fromCurrency='';
            $scope.customerinvoice.toCurrency='';
        }
    }  
    
    $scope.exchagerateGIhdr = function(exchangeRate){
        debugger; 
        if(exchangeRate>0){
            if(parseFloat(exchangeRate) < $scope.customerinvoice.fromCurrency || parseFloat(exchangeRate) > $scope.customerinvoice.toCurrency){
                logger.logError("Please Enter Exchange Rate Between "+$scope.customerinvoice.fromCurrency+" and "+
                        $scope.customerinvoice.toCurrency);       
                $scope.customerinvoice.exchangeRate=0;
            }else{
                var bcAmount=0.0, tcAmount=0.0;
                angular.forEach($scope.customerinvoice.GIDtl, function(giRow,giIndex){
                    debugger;
                    if(isNaN(parseFloat(giRow.tcAmount, 10))){
                        if(isNaN(parseFloat(giRow.bcAmount, 10))){
                          //  var bcAmt = (parseFloat(giRow.tcAmount) / exchangeRate);
                          //  var tcAmt = (parseFloat(giRow.bcAmount) * exchangeRate);
                            var bcAmt = Math.floor(((isNaN(parseFloat(giRow.tcAmount, 10))?0:giRow.tcAmount) * parseFloat(exchangeRate))*100)/100;
                            var tcAmt = Math.floor(((isNaN(parseFloat(giRow.bcAmount, 10))?0:giRow.bcAmount) / parseFloat(exchangeRate))*100)/100;
                            giRow.tcAmount = isNaN(tcAmt)?0:tcAmt.toFixed(2); 
                            giRow.bcAmount = isNaN(bcAmt)?0:bcAmt.toFixed(2); 
                        }else{
                           // var tcAmt = (parseFloat(giRow.bcAmount) * exchangeRate);
                            var tcAmt = Math.floor(((isNaN(parseFloat(giRow.bcAmount, 10))?0:giRow.bcAmount) / parseFloat(exchangeRate))*100)/100;
                            giRow.tcAmount = isNaN(tcAmt)?0:tcAmt.toFixed(2);  
                        }
                    }else {
                        //var bcAmt = (parseFloat(giRow.tcAmount) / exchangeRate);
                        //giRow.bcAmount = isNaN(bcAmt)?0:bcAmt.toFixed(2); 
                        var bcAmt = Math.floor(((isNaN(parseFloat( giRow.tcAmount, 10))?0: giRow.tcAmount) * parseFloat(exchangeRate))*100)/100;                    
                        giRow.bcAmount = parseFloat(bcAmt).toFixed(2);
                    } 
                });        
            }
              
            
        }
        $scope.calculateTotalAmount($scope.customerinvoice.GIDtl);
     }
    
    $scope.calculateTCtoBCAmount = function( trIndex, row) {
        debugger;
        if (tcAmount != null) {
            if ($scope.customerinvoice.exchangeRate != 0 && $scope.customerinvoice.exchangeRate != ""){
             // var bcAmount = (parseFloat(tcAmount) / $scope.customerinvoice.exchangeRate).toFixed(2);
              var bcAmount = Math.floor(((isNaN(parseFloat( tcAmount, 10))?0: tcAmount) * parseFloat($scope.customerinvoice.exchangeRate))*100)/100;
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
        $scope.calculateTotalAmount($scope.customerinvoice.GIDtl);
    };

    $scope.calculateBCtoTCAmount = function(bcAmount, trIndex, row) {
        debugger;
        if (bcAmount != null) {
            if ($scope.customerinvoice.exchangeRate != 0 && $scope.customerinvoice.exchangeRate != ""){
                //var tcAmt = (parseFloat(bcAmount) * $scope.customerinvoice.exchangeRate).toFixed(2);
                var tcAmt = Math.floor(((isNaN(parseFloat( bcAmount, 10))?0: bcAmount) / parseFloat($scope.customerinvoice.exchangeRate))*100)/100;
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
        $scope.calculateTotalAmount($scope.customerinvoice.GIDtl);
    };
    
    $scope.validationCheck = false;
    $scope.calculateTotalAmount = function(tables) {
        debugger;
        
        var totalBCamount = 0.0, totalTCamount = 0.0, bcAmountTot = 0.0, tcAmountTot = 0.0, vatBCamount = 0.0, vatTCamount = 0.0;
        angular.forEach(tables, function(row, index) {
        	
        	if(row.select){
        		
        		$scope.validationCheck = true;
        		
        		 var tcGrandTot = row.totalAmount , tcAmount = row.amount , tcTax = row.vatAmount,bcAmount =0,bcTax =0,bcGrandTot=0; 
        		 
        		 if ($scope.customerinvoice.exchangeRate != 0 && $scope.customerinvoice.exchangeRate != ""){
        	        	
                     bcAmount = Math.floor(((isNaN(parseFloat( tcAmount, 10))?0: tcAmount) * parseFloat($scope.customerinvoice.exchangeRate))*100)/100;
                   //  $scope.customerinvoice.bcAmount = isNaN(bcAmount)?0:bcAmount;
                     
                     bcTax = Math.floor(((isNaN(parseFloat( tcTax, 10))?0: tcTax) * parseFloat($scope.customerinvoice.exchangeRate))*100)/100;
                  //   $scope.customerinvoice.vatBCAmount = isNaN(bcTax)?0:bcTax;
                     
                     bcGrandTot = Math.floor(((isNaN(parseFloat( tcGrandTot, 10))?0: tcGrandTot) * parseFloat($scope.customerinvoice.exchangeRate))*100)/100;
                   //  $scope.customerinvoice.totalBCamount = isNaN(bcGrandTot)?0:bcGrandTot;
                  }
                  else{
                      tcAmount = Math.floor(((isNaN(parseFloat( tcAmount, 10))?0: tcAmount))*100)/100;
                      bcAmount = (parseFloat(tcAmount)).toFixed(2);
                      
                      tcTax = Math.floor(((isNaN(parseFloat( tcTax, 10))?0: tcTax))*100)/100;
                      bcTax = (parseFloat(tcTax)).toFixed(2);
                      
                      tcGrandTot = Math.floor(((isNaN(parseFloat( tcGrandTot, 10))?0: tcGrandTot))*100)/100;
                      bcGrandTot = (parseFloat(tcGrandTot)).toFixed(2);
                  } 
        		 
        		 totalBCamount = (parseFloat(totalBCamount) + parseFloat(bcGrandTot)).toFixed(2);
                 totalTCamount = (parseFloat(totalTCamount) + parseFloat(tcGrandTot)).toFixed(2);
                 
                 bcAmountTot = (parseFloat(bcAmountTot) + parseFloat(bcAmount)).toFixed(2);
                 tcAmountTot = (parseFloat(tcAmountTot) + parseFloat(tcAmount)).toFixed(2);
                 
                 vatBCamount = (parseFloat(vatBCamount) + parseFloat(bcTax)).toFixed(2);
                 vatTCamount = (parseFloat(vatTCamount) + parseFloat(tcTax)).toFixed(2);
        	}
           
        });
        $scope.customerinvoice.totalBCamount = totalBCamount;
        $scope.customerinvoice.totalTCamount = totalTCamount;
        
        $scope.customerinvoice.vatBCAmount = vatBCamount;
        $scope.customerinvoice.vatTCAmount = vatTCamount;
        
        $scope.customerinvoice.bcAmount = bcAmountTot;
        $scope.customerinvoice.tcAmount = tcAmountTot;
    };
    
    $scope.getEdit = function(sInvoiceNo) {
        var url = $stateParams.tenantid+'/app/customerinvoice/edit?customerinvoiceNo=' + sInvoiceNo;
        $http.get(url).success(function(result) {
            debugger;
            $scope.customerinvoice.InvoiceDate = result.InvoiceDate;
            $scope.customerinvoice.bLlist= result.bLlist;
            $scope.customerinvoice.customerList= result.customerList;
            $scope.mloList= result.mloList;
            $scope.customerinvoice.voyagehdrList= result.voyageList;
            $scope.customerinvoice.porthdrList= result.portList;
            $scope.customerinvoice.VesselhdrList= result.vesselList;

            $scope.customerinvoice.BlRelated = result.BlRelated;
            $scope.customerinvoice.Company = result.Company;
            $scope.customerinvoice.CompanyCode = result.CompanyCode;
            $scope.customerinvoice.CurrencyCode = result.CurrencyCode;
            $scope.customerinvoice.CurrencyName = result.CurrencyName;
            $scope.customerinvoice.CustomerCode = result.CustomerCode;
            $scope.customerinvoice.CustomerName = result.CustomerName;
            $scope.customerinvoice.exchangeRate = result.exchangeRate;
           
           // $scope.getcurrencyValues($scope.customerinvoice.CurrencyName);
            var date= result.InvoiceDate;
            var d=new Date(date.split("-").reverse().join("/"));
            var dd=d.getDate();
            var mm=d.getMonth()+1;
            var yy=d.getFullYear();
            var invoiceFormattedDate=dd+"/"+mm+"/"+yy;
            
            $scope.customerinvoice.InvoiceDate = invoiceFormattedDate;
            $scope.customerinvoice.InvoiceNo = result.InvoiceNo;
           // $scope.customerinvoice.MloCode = result.MloName;
            $scope.customerinvoice.MloName = result.MloName;
            $scope.customerinvoice.Pod = result.Pod;
            $scope.customerinvoice.Pol = result.Pol;
            $scope.customerinvoice.Port = result.Port;
            $scope.customerinvoice.PortSequence = result.PortSequence;
            $scope.customerinvoice.ServiceCode = result.ServiceCode;
            $scope.customerinvoice.ServiceName = result.ServiceName;
            $scope.customerinvoice.Subject = result.Subject;
            /*$scope.customerinvoice.totalBCamount = result.totalBCamount;
            $scope.customerinvoice.totalTCamount = result.totalTCamount;*/
            $scope.customerinvoice.Unit20 = result.Unit20;
            $scope.customerinvoice.Unit40 = result.Unit40;
            //$scope.customerinvoice.VesselCode = result.VesselCode;
            $scope.customerinvoice.VesselName = result.VesselName;
            $scope.customerinvoice.Voyage = result.Voyage;
            
            $scope.customerinvoice.GIDtl = result.GIDtl;
            
            $scope.calculateTotalAmount($scope.customerinvoice.GIDtl);

        }).error(function(result) {
            logger.logError("Error Please Try Again");
        });

    }

    var InvoiceNo=$stateParams.InvoiceNo;
    if(InvoiceNo == undefined || InvoiceNo == null || InvoiceNo ==""){
        $scope.customerinvoice.isEdit=false;
    }else{
        $scope.customerinvoice.isEdit =true;
        $scope.getEdit(InvoiceNo);
    }
    
    $scope.isOwner = false;
    $scope.checkOwner = function(){
        $http.get($stateParams.tenantid+'/app/cashbankreceipt/checkOwnerUser').success(function(data) {
                console.log("owner")
                console.log(data)
                $scope.isOwner = data;
        });
    }
    $scope.checkOwner();
    
    /**
     * print
     */
    $scope.printCustInvoiceDiv = function(invoiceNo){
        
        console.log("Both print invoice")
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
    

});