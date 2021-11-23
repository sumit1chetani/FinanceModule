////define([ 'hospital/report/report', 'jqGrid' ], function(module) {


'use strict';
app.controller('receiptPaymentCtrl', function($templateCache, $scope, $rootScope, $http, logger, $log, ngDialog, 
        $modal, $location, $sce,$state, $filter, $timeout,utilsService,$compile,$stateParams) {
    
     $scope.sub = true;
     $scope.test=true;
        $scope.main = true;
        $scope.generalLedger = {
                subGroupCode:'',
                groupCode:'',
                companyCode:'C0002',
                fromDate:'',
                toDate:'',
                accountHeadCode:'',
                filterAccountHeadCode:'',           
                isEdit : false,
                mainAccountCode:'',
                subAccountCode:'',
                costCenter :'',
                totalAmount:'',

        };
        
        $scope.isEdit = false;

        $('#gl_fromDate').datetimepicker({
            format : 'DD/MM/YYYY',
            pickTime: false
        });
        
        $('#gl_toDate').datetimepicker({
            format : 'DD/MM/YYYY',
            pickTime: false
        });
        
        
        var currentDate = new Date();
        currentDate = ('0' + currentDate.getDate()).slice(-2) + "/" + ('0' + (Number(currentDate.getMonth()) + 1)).slice(-2) + "/" + currentDate.getFullYear();
        $scope.generalLedger.fromDate = currentDate;

        
        
        var currentDate = new Date();
        currentDate = ('0' + currentDate.getDate()).slice(-2) + "/" + ('0' + (Number(currentDate.getMonth()) + 1)).slice(-2) + "/" + currentDate.getFullYear();
       // $scope.generalLedger.toDate = currentDate;

        $scope.companyList = [];
        $scope.subGroupList = []
        
        
        $http.get('app/cashbankPayment/subAccountCodeList').success(function(datas) {
            $scope.subGroupList = datas;
        }).error(function(datas) {
        });
        
        
        
        
        
        $http.get('app/receiptPayment/getGroupHeadList').success(function(datas) {
            $scope.GroupList = datas;
        }).error(function(datas) {
        });
        
        
        $http.get('app/receiptPayment/mainaccountList').success(function(datas) {
            $scope.mainaccountlist = datas;
        }).error(function(datas) {
        });
        
        
      
      
       
        
        
        $http.get($stateParams.tenantid+'/app/commonUtility/getCompanyListcompany').success(function(datas) {
            $scope.companyList = datas;

                var foundItemDest = $filter('filter')($scope.companyList, {
                    baseCompany : 1
                    
                })[0];
                $scope.cashbankpaymentModelData.companyName=foundItemDest.id;
        }).error(function(datas) {
        });
        
        
        
        
        
        
        $scope.costList =[];
        
        
        
        $scope.$watch('generalLedger.companyCode', function(newValue, oldValue) {
            //  alert(newValue);
               if(newValue!=null && newValue!=undefined && newValue != ''){
               //    $http.post($stateParams.tenantid+ '/app/commonUtility/getVoyageListByVessel',newValue).success(function(data) {
                    $http.get('app/purchaseinvoice/getcompanycost?company=' + $scope.generalLedger.companyCode).success(function(data) {

                        $scope.generalLedger.companyCode = newValue;


                         if(data.length > 0)
                       {
                       $scope.costList = data;
                       }
                         else{
                             
                             logger.logError("Not Available");
                             
                         }
                   });
               }
             });
          
        /*
        
                 $scope.agentid=true;
                 $scope.companyList=[];
                 $scope.getcompanyList=function(){
                 $http.get('app/commonUtility/getCompanyList').success(function(data) {

              //   $http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(data) { 
                 debugger
                 $scope.companyList = data;
                 console.log("companyList");
                 console.log( $scope.companyList);
                 $timeout(function() {
                 
                 $("#companyCode").multiselect({
                 maxHeight: 200, 
                 includeSelectAllOption: true,
                 selectAllText : 'Select All',
                 enableFiltering : true, 
                 disableIfEmpty: true,
                 enableCaseInsensitiveFiltering: true,
                 numberDisplayed: 1,
                 onDropdownHide: function (event) {

                 }
                 });
                 $("#multiselect-button").addClass("width_100 input-sm line-height-5");

                 }, 2, false);
                 
                 });

                 };
                 
                 
                 
                 $scope.getcompanyList();
           */
/*
                 $scope.getDropDownList = function() {
                     $http.get('app/commonUtility/getSubGroupAcctList').success(function(data) {
                         $scope.subGroupList = data;
                        
                     }).error(function(data) {
                     });

                 };*/
        
        
        

        
        $scope.companyId=$location.search().companyId;
        $scope.fromDate=$location.search().fromDate;
        $scope.toDate=$location.search().toDate;

        $scope.costCenter=$location.search().costCenter;

        $scope.toDate=$location.search().toDate;
        $scope.id=$location.search().id;
        $scope.subGroupCode=$location.search().subGroupCode;
        $scope.groupCode=$location.search().groupCode;
        
        if($scope.companyId != undefined && $scope.fromDate != undefined && $scope.toDate != undefined && $scope.id !=undefined){
            $scope.test=false;
            /*$scope.generalLedger.companyCode=$scope.companyId;
            $scope.generalLedger.fromDate=$scope.fromDate;
            $scope.generalLedger.toDate=$scope.toDate;*/
            
             $scope.testing={
                    companyCode : $scope.companyId,
                    fromDate : $scope.fromDate,
                    toDate : $scope.toDate,
                    subGroupCode:$scope.subGroupCode,
            // groupCode:$scope.groupCode,
                    mainAccountCode:$scope.groupCode
            };
            
                   
            
        }
        
        if($scope.testing!=undefined ){
            
            $scope.Report = function(){
                
                    var url ='app/subgroupacct/list1?subgroup=' + $scope.testing.subGroupCode ;
                    $http.get(url).success(function(data) {
                        console.log("****datasubgroup***");
                        console.log(data);
                        $scope.testing.groupCode=data.objSubGroupAccountBeanBean[0].grpHeadCode;
                        $scope.generalLedger.groupCode=data.objSubGroupAccountBeanBean[0].grpHeadCode;
                        
                    }).error(function(data) {
                        logger.logError("Error Please Try Again");
                    });
            
                    
                
                debugger;
                
                if($scope.testing!=undefined ){
                   console.log($scope.generalLedger);
                       
                   $http.post('app/receiptPayment/getGeneralLedgerReport', $scope.testing).success(function(data) {
                        if(data.success){
                         
                            $("#generalLedgerGrid").jqGrid('clearGridData');
                            jQuery('#generalLedgerGrid').jqGrid('clearGridData').jqGrid('setGridParam', {data: data, datatype: 'json'}).trigger('reloadGrid');
                            $scope.populateGeneralLedgerGrid1(data);
                        }else{
                        }
                   }).error(function(data) {
                        logger.logError("Error Please Try Again");
                   });
                }else{
                    if(($scope.generalLedger.toDate =='' || $scope.generalLedger.fromDate == '') && $scope.generalLedger.companyCode =='')
                        logger.logError("Please select Company and valid date range");
                    else if($scope.generalLedger.companyCode =='')
                        logger.logError("Please select Company");
                    else if($scope.generalLedger.toDate =='' || $scope.generalLedger.fromDate == '')
                        logger.logError("Please select valid date range");
                }
            };
            $scope.Report(); 
        }

   
 

   

    $scope.formreset = function() {
        debugger;
        $scope.generalLedger = {
                subGroupCode:'',
                groupCode:'',
                companyCode:'',
                fromDate:'',
                toDate:'',
                accountHeadCode:'',
                filterAccountHeadCode:'',
                mainAccountCode:'',
                subAccountCode:'',
    
                
        };
       
        
        $timeout(function() {
            $("#txtCompanyCode").multiselect("refresh");
            $("#txtCompanyCode").multiselect({
                maxHeight: 400,
                includeSelectAllOption: true,
                selectAllText: 'Select All',
                enableFiltering: true,
                enableCaseInsensitiveFiltering: true,
                filterPlaceholder: 'Search',
                onChange: function(element, checked) {
                    debugger;
                  var companyCodes = "", jvpShortNames="";
                  if($scope.generalLedger.objCompanyCodes.length>0){
                      angular.forEach($scope.generalLedger.objCompanyCodes, function (item, key) {
                          debugger;
                          if($scope.generalLedger.objCompanyCodes.length>0){
                              debugger;
                              if($scope.generalLedger.objCompanyCodes[key]!=undefined){
                                  
                                  var companyCode = item.id;
                                  
                                  if(companyCodes==""){
                                      companyCodes = item.id;
                                  }else{
                                      companyCodes +=","+ item.id;
                                  }       
                                  $scope.generalLedger.companyCode = companyCodes;
                              }                             
                          }                              
                      });
                  }else{
                      $scope.generalLedger.companyCode = '';
                  }
                  
                }
              });
            
            $("#multiselect-button").addClass("width_100 input-sm line-height-5");
            
            }, 2, false);
    };

    
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.rowCollection1 = [];
    $scope.displayedCollection1	 = [];
    $scope.rowCollection2 = [];
    $scope.displayedCollection2	 = [];
    $scope.rowCollection3 = [];
    $scope.displayedCollection3	 = [];
    $scope.itemsByPage = 10;
    $scope.subGroupList = [];
    $scope.companyList = [];
    $scope.totalAmount=0.0;
    $scope.preTotalAmount=0.0;
    $scope.totalAmount1=0.0;
    $scope.preTotalAmount1=0.0;
    $scope.totalAmount2=0.0;
    $scope.preTotalAmount2=0.0;
    $scope.totalAmount3=0.0;
    $scope.preTotalAmount3=0.0;
    $scope.totalPayment=0.0;
	$scope.totalReceipt=0.0;
    $scope.getDropDownList = function() {
       /* $http.get($stateParams.tenantid+'/app/trialBalance/getSubGroupList').success(function(data) {
            $scope.subGroupList = data;
        }).error(function(data) {
        });*/
/*        
        $http.get('app/usermaster/getCompanyList?formCode='+$('#form_code_id').val()).success(function(datas) {
            debugger;           
            $scope.companyList = datas;           
            }).error(function(datas) {
        });*/
        
/*
        $http.get('app/usermaster/getCompanyList?formCode='+$('#form_code_id').val()).success(function(data) {
            console.log("data")
            console.log(data)
            $scope.companyList = data;
            var data = {};
            data["id"] = "All";
            data["text"] = "ALL";
            $scope.companyList.push(data);
       

            
            console.log("company")
            console.log($scope.companyList)
            var foundItemDest = $filter('filter')($scope.companyList, { baseCompany:  1 })[0];
            $scope.generalLedger.companyCode=foundItemDest.id;
            
            
            $timeout(function() {
                $("#txtCompanyCode").multiselect({
                    maxHeight: 400,
                    includeSelectAllOption: true,
                    selectAllText: 'Select All',
                    enableFiltering: true,
                    enableCaseInsensitiveFiltering: true,
                    filterPlaceholder: 'Search',
                    onChange: function(element, checked) {
                        debugger;
                      var companyCodes = "", jvpShortNames="";
                      if($scope.generalLedger.objCompanyCodes.length>0){
                          angular.forEach($scope.generalLedger.objCompanyCodes, function (item, key) {
                              debugger;
                              if($scope.generalLedger.objCompanyCodes.length>0){
                                  debugger;
                                  if($scope.generalLedger.objCompanyCodes[key]!=undefined){
                                      
                                      var companyCode = item.id;
                                      
                                      if(companyCodes==""){
                                          companyCodes = item.id;
                                      }else{
                                          companyCodes +=","+ item.id;
                                      }       
                                      $scope.generalLedger.companyCode = companyCodes;
                                  }                             
                              }                              
                          });
                      }else{
                          $scope.generalLedger.companyCode = '';
                      }
                      
                    }
                  });
                
                $("#multiselect-button").addClass("width_100 input-sm line-height-5");
                
                }, 2, false);
        }).error(function(data) {
        });
        */
     /*   $http.get('app/receiptPayment/getGroupHeadList').success(function(data) {
            $scope.groupHeadList = data;
            
            $timeout(function() { 
                
                $("#txtGroupCode").multiselect({
                    maxHeight: 400,
                    includeSelectAllOption: true,
                    selectAllText: 'Select All',
                    enableFiltering: true,
                    enableCaseInsensitiveFiltering: true,
                    filterPlaceholder: 'Search',
                    onChange: function(element, checked) {
                        debugger;
                      var groupCodes = "";
                      if($scope.generalLedger.objGroupCodes.length>0){
                          angular.forEach($scope.generalLedger.objGroupCodes, function (item, key) {
                              debugger;
                              if($scope.generalLedger.objGroupCodes.length>0){
                                  debugger;
                                  if($scope.generalLedger.objGroupCodes[key]!=undefined){
                                      
                                      var companyCode = item.id;
                                      
                                      if(groupCodes==""){
                                          groupCodes = item.id;
                                      }else{
                                          groupCodes +=","+ item.id;
                                      }       
                                      $scope.generalLedger.groupCode = groupCodes;
                                  }                             
                              }                              
                          });
                      }else{
                          $scope.generalLedger.groupCode = '';
                      }
                      console.log($scope.generalLedger.groupCode);
                    }
                  });
                $("#txtGroupCode").parent().find('.btn-group #multiselect-button').addClass('width_100 input-sm line-height-5'); 
                
                }, 2, false);
        }).error(function(data) {
        });
        */
        
       /* $http.get($stateParams.tenantid+'/app/purchaseinvoice/getAccountList').success(function(datas) {
            $scope.accountHeadList = datas;
            }).error(function(datas) {
        });*/
    };
    
    $scope.getDropDownList();
    
    $scope.subAccountCodeList = [];
    $http.get('app/commonUtility/getSubAccountCodeList').success(function(datas) {
    //    $scope.subAccountCodeList = datas;
         $scope.subAccountCodeList = datas.commonUtilityBean;
        console.log("sub acct 7")
        console.log(datas);
        }).error(function(datas) {
    });  
    
    $scope.$watch('generalLedger.mainAccountCode', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
            $scope.subAccountCodeList = [];
            debugger;
            $scope.generalLedger.subGroupCode=newValue.substring(0, 4);
            if(newValue == '10080001' ||newValue == '10080003' || newValue == '10080002' ||   newValue =='10040001'  ){
                $scope.subAccountCodeList = [];
                $http.get('app/commonUtility/getSubAccountCodeListTradeDebtors').success(function(datas) {
                    console.log("sub acct 1")
                    $scope.subAccountCodeList = datas
                    console.log(datas);
                    }).error(function(datas) {
                });               
            }else if(newValue == '20010001' || newValue =='20010003' || newValue=='10120001' || newValue =='20010002' ||   newValue =='20000001'){
                $scope.subAccountCodeList = [];
                $http.get('app/commonUtility/getSubAccountCodeListTradeCreditors').success(function(datas) {
                    console.log("sub acct 2")                   
                    $scope.subAccountCodeList = datas;
                  
                    }).error(function(datas) {
                });   
            }else if(newValue == '20010004'){
                $scope.subAccountCodeList = [];
                $http.get('app/commonUtility/getJvPartnerAccount').success(function(datas) {
                    console.log("sub acct 3")
                      console.log(datas)
                    $scope.subAccountCodeList = datas;
                    }).error(function(datas) {
                });   
            }else if(newValue == '10070001'){
                $scope.subAccountCodeList = [];
                $http.get('app/commonUtility/getStaffList').success(function(datas) {
                    console.log("sub acct 4")
                      console.log(datas)
                    $scope.subAccountCodeList = datas;
                    }).error(function(datas) {
                });   
            }
            else if(newValue == '10040004'){
                $scope.subAccountCodeList = [];
                $http.get('app/commonUtility/getVendorList').success(function(datas) {
                    console.log("sub acct 5")
                      console.log(datas)
                    $scope.subAccountCodeList = datas;
                    }).error(function(datas) {
                });   
            }else if(newValue == '10070004' || newValue == '10050001' ||newValue == '10050002' || newValue == '50060004' || newValue == '50000002'){
                
                $scope.subAccountCodeList = [];
                $http.get('app/commonUtility/getVessel').success(function(datas) {
                    console.log("sub acct 6")
                      console.log(datas)
                    $scope.subAccountCodeList = datas;
                    }).error(function(datas) {
                });   
            }/*else{
                $scope.subAccountCodeList = [];
                $http.get('app/commonUtility/getSubAccountCodeList').success(function(datas) {
                    console.log("sub acct 6")
                      console.log(datas)
                    $scope.subAccountCodeList = datas.commonUtilityBean;
                    }).error(function(datas) {
                });  
            }*/
        }else{
            $scope.subAccountCodeList = [];
            $http.get('app/commonUtility/getSubAccountCodeList').success(function(datas) {
            //    $scope.subAccountCodeList = datas;
                 $scope.subAccountCodeList = datas.commonUtilityBean;
                console.log("sub acct 7")
                console.log(datas);
                }).error(function(datas) {
            });  
        }
    });
    
    $scope.costCenter=$location.search().costCenter;
    
    $scope.viewGeneralLedgerReport = function(){
	$scope.totalAmount=0.0;
	$scope.preTotalAmount=0.0;
	$scope.totalPayment=0.0;
	$scope.totalReceipt=0.0;
	$scope.totalAmount1=0.0;
	$scope.preTotalAmount1=0.0;
	$scope.totalAmount2=0.0;
	$scope.preTotalAmount2=0.0;
	$scope.totalAmount3=0.0;
	$scope.preTotalAmount3=0.0;
        debugger;
 var financial_year = "";
        var today = new Date();
        if ((today.getMonth() + 1) <= 3) {
            financial_year = (today.getFullYear() - 1) + "-" + today.getFullYear()
        } else {
            financial_year = today.getFullYear() + "-" + (today.getFullYear() + 1)
        }
       // $scope.generalLedger.fromDate = $('#fromDate').val();
       // $scope.generalLedger.toDate = $('#toDate').val();
     
        if($scope.generalLedger.companyCode !='' ){
           console.log($scope.generalLedger);
           $scope.generalLedger.financialYear=financial_year;
               
           $http.post('app/receiptPayment/getGLTransactionLevel', $scope.generalLedger).success(function(data) {

                if(data.success){
	  $scope.rowCollection2 =data.lGeneralLedgerList;
      $scope.rowCollection =data.lGeneralLedgerTransactionList;
      $scope.rowCollection1 =data.lGeneralLedgerAHList;
      $scope.rowCollection3 =data.lGeneralLedgerBankList;
  angular.forEach(data.lGeneralLedgerList, function (bean, key) {
	$scope.totalAmount2=$scope.totalAmount2+bean.amoount;
	$scope.preTotalAmount2=$scope.preTotalAmount2+bean.preAmount;
	
	})
angular.forEach(data.lGeneralLedgerTransactionList, function (bean, key) {
	$scope.totalAmount=$scope.totalAmount+bean.amount;
	$scope.preTotalAmount=$scope.preTotalAmount+bean.preAmount;
	
	})
 angular.forEach(data.lGeneralLedgerAHList, function (bean, key) {
	$scope.totalAmount1=$scope.totalAmount1+bean.amount;
	$scope.preTotalAmount1=$scope.preTotalAmount1+bean.preAmount;
	
	})
angular.forEach(data.lGeneralLedgerBankList, function (bean, key) {
	$scope.totalAmount3=$scope.totalAmount3+bean.amoount;
	$scope.preTotalAmount3=$scope.preTotalAmount3+bean.preAmount;
	
	})  
	$scope.totalAmount1=$scope.totalAmount1+$scope.totalAmount3; 
	$scope.totalAmount=$scope.totalAmount+$scope.totalAmount2;  
	$scope.preTotalAmount1=$scope.preTotalAmount1+$scope.preTotalAmount3; 
	$scope.preTotalAmount=$scope.preTotalAmount+$scope.preTotalAmount2;  
//	$scope.totalReceipt= $sope.totalAmount+$sope.totalAmount2;
//	$scope.totalPayment= $sope.totalAmount1+$sope.totalAmount3;  		
	  }else{
                    
                    logger.logError("No Records Found");
                    $scope.rowCollection=[];
                }
           }).error(function(data) {
                logger.logError("Error Please Try Again");
           });
        }else{
            if( $scope.generalLedger.fromDate == '' && $scope.generalLedger.companyCode =='')
                logger.logError("Please select Company and valid date range");
            else if($scope.generalLedger.companyCode =='')
                logger.logError("Please select Company");
            else if($scope.generalLedger.toDate =='' || $scope.generalLedger.fromDate == '')
                logger.logError("Please select valid date range");
        }
    };
  //Excel PDF	
    $scope.exportPDF = function(){
		  var flag = false;
		  //if(bean.port != "" && bean.port != undefined && bean.port != null){
	       // $scope.balsheet.fromDate = $('#fromDate').val();
	//        $scope.balsheet.toDate = $('#toDate').val();
	     	   	 $http.post('app/receiptPayment/ExportPDF',$scope.generalLedger).success(function(response) {

	                if(response){
	                    debugger;
	                    $("#exportPDF").bind('click', function() {
	                    	
	                    });
	                    $('#exportPDF').simulateClick('click');
	                    logger.logSuccess("Exported successfully!");
	                }else{
					        logger.logError(response.message);
	                }
	                
	            }).error(function(response) {
	                logger.logError("Error Please Try Again");
	            });
	     	    
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
  	   	 
	     	   	 
	    
   
  
    
  
    // export excel by account head
    $scope.exportGeneralLedgerExcel = function(){
        debugger;
      ////  $scope.generalLedger.fromDate = $('#fromDate').val();
       // $scope.generalLedger.toDate = $('#toDate').val();
        if( $scope.generalLedger.companyCode !=''){
            $http.post('app/receiptPayment/exportGeneralLedgerExcel', $scope.generalLedger).success(function(data) {
                if(data){
                    debugger;
                    $("#GLExport").bind('click', function() {
                    });
                    $('#GLExport').simulateClick('click');
                    logger.logSuccess("Exported successfully!");
                }else{
                    logger.logError("Failed to export");
                }
                
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        	
        	/*$http.post('app/receiptPayment/exportGeneralLedgerExcel', $scope.generalLedger).success(function(data) {
                $('#GLExport').append('<a id="tbExcelExport" stype="display:none" href="filepath/DayBook.xls" download="DayBook.xls"></a>');
                $("#tbExcelExport").bind('click', function() {
                });
                $('#tbExcelExport').simulateClick('click');

            }).error(function(result) {
                logger.logError("Error Please Try Again");
            });*/
        }else{
            if(($scope.generalLedger.toDate =='' || $scope.generalLedger.fromDate == '') && $scope.generalLedger.companyCode =='')
                logger.logError("Please select Company and valid date range");
            else if($scope.generalLedger.companyCode =='')
                logger.logError("Please select Company");
            else if($scope.generalLedger.toDate =='' && $scope.generalLedger.fromDate == '')
                logger.logError("Please select valid date range");
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
    }
    
    //
   
    /*
    
    //print
    $scope.printgeneralLedger = function(){
          $scope.generalLedger.fromDate = $('#fromDate').val();
          $scope.generalLedger.toDate = $('#toDate').val();
          console.log($scope.generalLedger); 
          if($scope.generalLedger.toDate !='' && $scope.generalLedger.fromDate != '' && $scope.generalLedger.companyCode !=''){

       var url = $stateParams.tenantid+'/app/dayBook/print'+$scope.generalLedger;

       var wnd = window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
               wnd.print();
          }
        
        else{
            if(($scope.generalLedger.toDate =='' || $scope.generalLedger.fromDate == '') && $scope.generalLedger.companyCode =='')
                logger.logError("Please select Company and valid date range");
            else if($scope.generalLedger.companyCode =='')
                logger.logError("Please select Company");
            else if($scope.generalLedger.toDate =='' && $scope.generalLedger.fromDate == '')
                logger.logError("Please select valid date range");
        }
        
     }*/
    
    
    
    

    $scope.printgeneralLedger = function(generalLedger){
         $scope.generalLedger.fromDate = $('#fromDate').val();
         $scope.generalLedger.toDate = $('#toDate').val();
         console.log($scope.generalLedger);         
        if($scope.generalLedger.toDate !='' && $scope.generalLedger.fromDate != '' && $scope.generalLedger.companyCode !=''){

        $http.post('app/receiptPayment/print',$scope.generalLedger).success(function(response) {
                var mywindow = window.open('', 'Shipping', 'height=400,width=750,top=100,left=100,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
                mywindow.document.write(response);
                mywindow.document.close(); // necessary for IE >= 10
                mywindow.focus(); // necessary for IE >= 10
                mywindow.print();
                
        }).error(function(data) {
            logger.logError("Error Please Try Again");

        
        });
        }
        else{
            if(($scope.generalLedger.toDate =='' || $scope.generalLedger.fromDate == '') && $scope.generalLedger.companyCode =='')
                logger.logError("Please select Company and valid date range");
            else if($scope.generalLedger.companyCode =='')
                logger.logError("Please select Company");
            else if($scope.generalLedger.toDate =='' && $scope.generalLedger.fromDate == '')
                logger.logError("Please select valid date range");
        }
        
    }
    //export excel
    $scope.exportGeneralLedgerExcelOP = function(){
        debugger;
        $scope.generalLedger.fromDate = $('#fromDate').val();
        $scope.generalLedger.toDate = $('#toDate').val();
        console.log($scope.generalLedger);
        if($scope.generalLedger.toDate !='' && $scope.generalLedger.fromDate != '' && $scope.generalLedger.companyCode !=''){
            $http.post('app/receiptPayment/exportGeneralLedgerExcelOP', $scope.generalLedger).success(function(data) {
                if(data){
                    debugger;
                    $("#GLExport").bind('click', function() {
                    });
                    $('#GLExport').simulateClick('click');
                    logger.logSuccess("Exported successfully!");
                }else{
                    logger.logError("Failed to export");
                }
                
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        }else{
            if(($scope.generalLedger.toDate =='' || $scope.generalLedger.fromDate == '') && $scope.generalLedger.companyCode =='')
                logger.logError("Please select Company and valid date range");
            else if($scope.generalLedger.companyCode =='')
                logger.logError("Please select Company");
            else if($scope.generalLedger.toDate =='' && $scope.generalLedger.fromDate == '')
                logger.logError("Please select valid date range");
        }
    }
    
    
    $scope.exportTransactionLevelExcel = function(){
        debugger;
        $scope.generalLedger.fromDate = $('#fromDate').val();
        $scope.generalLedger.toDate = $('#toDate').val();
        if($scope.generalLedger.toDate !='' && $scope.generalLedger.fromDate != '' && $scope.generalLedger.companyCode !=''){
            $http.post('app/receiptPayment/exportTransactionLevelExcel', $scope.generalLedger).success(function(data) {
                if(data){
                    debugger;
                    $("#GLExport").bind('click', function() {
                    });
                    $('#GLExport').simulateClick('click');
                    logger.logSuccess("Exported successfully!");
                }else{
                    logger.logError("Failed to export");
                }
                
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        }else{
            if(($scope.generalLedger.toDate =='' || $scope.generalLedger.fromDate == '') && $scope.generalLedger.companyCode =='')
                logger.logError("Please select Company and valid date range");
            else if($scope.generalLedger.companyCode =='')
                logger.logError("Please select Company");
            else if($scope.generalLedger.toDate =='' && $scope.generalLedger.fromDate == '')
                logger.logError("Please select valid date range");
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
    function test(rowObject) {
        debugger;
        alert("rer");
        console.log(rowObject);
        
        $( "#generalLeddialog" ).dialog();
        if ($("#generalLeddialog").dialog ("isOpen")) alert ("Already open !");
          else $("#generalLeddialog").dialog ("open");
    }

    //
    $scope.closeThisDialog = function(){
            
            ngDialog.close();
           
        }
    $scope.populateGeneralLedgerGrid1 = function(sgListData){
           
    
        var companyCode = $("#companyCode").val();
        //alert(companyCode);
        if(companyCode==''){
            $scope.currencCode= "(INR)";
        }else{
            $scope.currencCode= "";
        }
        console.log("sgListData")
        console.log(sgListData)
        
     $scope.geneSubgroupData=[];
        $http.post('app/receiptPayment/getGeneralLedgerALLLevel',$scope.testing).success(function(data) {
            $scope.geneSubgroupData =sgListData.lGeneralLedgerList ;
            $scope.geneSubgroupData[0].lGeneralLedgerAHList=data.lGeneralLedgerAHList;
            console.log($scope.geneSubgroupData); 
            
             angular.forEach($scope.geneSubgroupData[0].lGeneralLedgerAHList, function (bean, key) {
                $scope.geneSubgroupData[0].lGeneralLedgerAHList[key].showaccounthead=bean.accountHeadCode
                  $("#plus" + key).css("display", "none");
                   $("#minus" + key).css("display", "block");
             
          });
             
            
        });
        
        debugger;
        var data=[];
        $("#generalLedgerGrid").GridUnload();
        $("#generalLedgerGrid").jqGrid({
            data: sgListData.lGeneralLedgerList,
            datatype: "local",
            multiboxonly: false,
            autowidth: true,
            height: '50%',
            rowNum: 100,
            rowList: [100,200,300],
            multiselect: false,
            loadonce: true,
            gridview:true,
            colNames : [ 'Sub Group Head Code', 'Sub Group Head Name','Debit'+$scope.currencCode, 'Credit'+$scope.currencCode,'Balance'+$scope.currencCode],
            colModel:[
                {name:'subGroupCode',index:'subGroupCode', width:80, align:"left",searchoptions:{sopt:['cn']}},
                {name:'subGroupName1',index:'subGroupName1', width:80, align:"left",searchoptions:{sopt:['cn']},hidden:false},
            //    {name:'tcDebit',index:'tcDebit', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
              //  {name:'tcCredit',index:'tcCredit', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                {name:'bcDebit',index:'tcDebit', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                {name:'bcCredit',index:'tcCredit', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
               // {name:'currentTCBalance',index:'currentTCBalance', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                {name:'currentBalance',index:'currentBalance', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}}
                ],
            pager: "#generalLedgerPage",
            viewrecords: true,
            ignoreCase: true,
            subGrid: true,
            subGridOptions: {
               /* "plusicon" : 'ui-icon-plus',
                "minusicon" : 'ui-icon-minus',*/
                expandOnLoad: true, 

            },
            footerrow: true,
            loadComplete: function () {
            debugger;
                var $grid = $('#generalLedgerGrid');
                
                var tcCredit = $grid.jqGrid('getCol', 'tcCredit', false, 'sum');
                var tcDebit = $grid.jqGrid('getCol', 'tcDebit', false, 'sum');
                var credit = $grid.jqGrid('getCol', 'bcCredit', false, 'sum');
                var debit = $grid.jqGrid('getCol', 'bcDebit', false, 'sum');
                
                var difference = debit - credit;
                var tcDifference = tcDebit - tcCredit;
                console.log("-BCdifference"+difference);
                console.log("-TCdifference"+tcDifference);
       
                console.log("difference")
                 console.log(sgListData.amt.closingBalance)

                $(this).jqGrid('footerData','set',{ subGroupName:'Total', tcDebit:tcDebit.toFixed(2),tcCredit:tcCredit.toFixed(2),
                    bcDebit:debit.toFixed(2),bcCredit:credit.toFixed(2),currentTCBalance:tcDifference.toFixed(2),currentBalance:difference.toFixed(2)});
            },
             
            subGridRowExpanded: function(subgrid_id, row_id) {
                //alert(row_id)
                debugger;
                var subgrid_table_id, pager_id; subgrid_table_id = subgrid_id+"_t";
                pager_id = "p_"+subgrid_table_id;
                $rootScope.value=$scope.testing;


                var rowData = jQuery('#generalLedgerGrid').jqGrid ('getRowData', row_id);
                $scope.generalLedger.subGroupCode =rowData.subGroupCode;
                $("#"+subgrid_id).html("<table id='"+subgrid_table_id+"' class='scroll'></table><div id='"+pager_id+"' class='scroll'></div>");
                $http.post('app/receiptPayment/getGeneralLedgerAHLevel',$scope.testing).success(function(data) {
                 if(data.success){
                     debugger;
                     var glAHlevelDataList =data.lGeneralLedgerAHList;
                     $("#"+subgrid_table_id).jqGrid({
                     datatype: "local",
                     data: glAHlevelDataList,
                     colNames:['Acct Head Code','Acct Head Name','Debit', 'Credit','Balance','Actions'],
                                        
                     colModel:[
                            {name:'accountHeadCode',index:'accountHeadCode', width:200, align:"left",searchoptions:{sopt:['cn']}},
                            {name:'accountHeadName',index:'accountHeadName', width:200, align:"left",searchoptions:{sopt:['cn']},hidden:false},
                           // {name:'tcDebit',index:'tcDebit', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                           // {name:'tcCredit',index:'tcCredit', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                            {name:'bcDebit',index:'bcDebit', width:200,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                            {name:'bcCredit',index:'bcCredit', width:200,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                          //  {name:'currentTCBalance',index:'currentTCBalance', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                            {name:'currentBalance',index:'currentBalance', width:200,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                            /*{name:'slabact',index:'slabact', formatter: addLink1 , width:80, align:"left",searchoptions:{sopt:['cn']},hidden:false,classes: 'level_class1'},*/
                            /*{name: 'slabact', index: 'slabact', width: 100, sortable: false, align: 'center',key:true,formatter: addLink,
                                formatter: function (cellvalue, options, rowObject) {
                            return "<button onclick=\"slabPopup('"+rowObject+"');\"><span class=\"ui-icon ui-icon ui-icon-pencil edit-blue\"></span></button>";//\"
                            },resizable: false} */
                            {name:'actions',index:'actions',align:"center", width: 50, search: false}
                        ],
                     autowidth: true,
                     height: '50%',
                     pager: pager_id,
                     sortname: 'num',
                     sortorder: "asc",
                     // transaction level
                     subGrid: true,
                     subGridOptions: {
                         /*"plusicon" : 'ui-icon-plus',
                         "minusicon" : 'ui-icon-minus',*/
                        // expandOnLoad: true,
                     },
                     
                    gridComplete: function(){
                        var ids = jQuery("#"+subgrid_table_id).jqGrid('getDataIDs');
                        var fulldata = jQuery("#"+subgrid_table_id).jqGrid('getGridParam','data');
                        console.log(ids);
                        var test=$scope.testing;
                        for(var i=0;i < ids.length;i++){
                            var cl = fulldata[i].accountHeadCode;
                        var pdf = "<div style='width:20%;float:left;cursor:pointer;' title=\'"+cl+"' \" onclick=\"slabPopup('"+cl+"','"+test+"')\">" +
                                "<span class=\"ui-icon ui-icon ui-icon-pencil edit-blue\"></span></div>";
                            $("#"+subgrid_table_id).jqGrid('setRowData',ids[i],{actions:pdf});
                        }
                    },

                     footerrow: true,
                   

                     subGridRowExpanded: function(subgrid_child_id, row_id) {
                         debugger;
                       
                                console.log('it works' + new Date());
                            
                         
                         var subgridchild_table_id, pager_id; subgridchild_table_id = subgrid_child_id+"_t";
                         pager_id = "p_"+subgridchild_table_id;
                         var rowData = jQuery('#'+subgrid_table_id).jqGrid ('getRowData', row_id);
                         $scope.testing.accountHeadCode =rowData.accountHeadCode;
                         $rootScope.acc=$scope.testing.accountHeadCode
                         console.log($rootScope.acc);
                         
                         
                         $("#"+subgrid_child_id).html("<table id='"+subgridchild_table_id+"' class='scroll'></table><div id='"+pager_id+"' class='scroll'></div>");
                         $http.post('app/receiptPayment/getGLTransactionLevel',$scope.testing).success(function(data) {
                          if(data.success){
                              debugger;
                              var glTransactionlevelDataList =data.lGeneralLedgerTransactionList;
                              $("#"+subgridchild_table_id).jqGrid({
                              datatype: "local",
                              data: glTransactionlevelDataList,
                              colNames:['Transaction No','Ledger Dt','Party Inv No','SA Name','Currency','Ex-Rate',,'Debit','Credit','Status','Allocated to'],
                              colModel:[
                                 {name:'transactionNo',index:'transactionNo', width:100, align:"left",
                                     searchoptions:{sopt:['cn']},classes: 'cursor-pointer'},
                                 /*{name:'voucherNo',index:'voucherNo', width:100, align:"left",searchoptions:{sopt:['cn']},hidden:false}, */   
                                 {name:'ledgerDate',index:'ledgerDate', width:100, align:"left",searchoptions:{sopt:['cn']},hidden:false},
                                 {name:'partyInvoiceNo',index:'partyInvoiceNo', width:100, align:"left",searchoptions:{sopt:['cn']},hidden:false},
                                 /*{name:'narration',index:'narration', width:200,align:"left", searchoptions:{sopt:['cn']},hidden:false},*/
                                 /*{name:'subAccountCode',index:'subAccountCode', width:70, align:"left",searchoptions:{sopt:['cn']}},*/
                                 {name:'subAccountName',index:'subAccountName', width:300, align:"left",searchoptions:{sopt:['cn']},hidden:false},
                                 {name:'currency',index:'currency', width:50,align:"left", searchoptions:{sopt:['cn']},hidden:false},
                                 {name:'exchangeRate',index:'exchangeRate', width:50,align:"right", searchoptions:{sopt:['cn']},hidden:false},
                              //   {name:'tcDebit',index:'tcDebit', width:150,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                               //  {name:'tcCredit',index:'tcCredit', width:150,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                                 {name:'bcDebit',index:'bcDebit', width:150,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                                 {name:'bcCredit',index:'bcCredit', width:150,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                                 {name:'allocationStatus',index:'allocationStatus', width:100, align:"left",searchoptions:{sopt:['cn']},hidden:false},
                                 {name:'allocatedTo',index:'allocatedTo', width:100, align:"left",searchoptions:{sopt:['cn']},hidden:false}
                         
                                 ],
                                 onCellSelect: function(rowid, iCol)
                                 {
                                     debugger;
                                     /* Row Click Based Event ******************** Start */
                                     var cm = jQuery("#"+subgridchild_table_id).jqGrid("getGridParam", "colModel");
                                     var transactionNoCell = jQuery("#"+subgridchild_table_id).jqGrid("getCell", rowid, "transactionNo");
                                     var colName = cm[iCol];
                                     console.log(colName);
                                     if(colName.name=="transactionNo"){
                                         utilsService.reportVoucherPrint(transactionNoCell);
                                     }
                                     //jqGridRowClickBasedEvent('productMasterGrid',rowid,'viewRow','editrow',iCol,colName.name);
                                     /* Row Click Based Event ******************** Endss */ 
                                 },
                              autowidth: true,
                              height: '50%',
                              pager: pager_id,
                              sortname: 'num',
                              sortorder: "asc", }).jqGrid('setGridParam', { data : glTransactionlevelDataList }).trigger("reloadGrid");
                          }
                         
                         }).error(function(tbAHlevelDataList) {
                         });
                    
                      } }).jqGrid('setGridParam', { data : glAHlevelDataList }).trigger("reloadGrid");
                 }
                
                }).error(function(glAHlevelDataList) {
                });
             }
        }).jqGrid('setGridParam', { data : sgListData }).trigger("reloadGrid");
     
   
    }
    $( document ).ready(function() {

    
            
    });
   
    $scope.exportGeneralLedgerExcelOP1 = function(){
        debugger;
        console.log($scope.testing);
        console.log($rootScope.acc);
        var acct=$rootScope.acc;
        $scope.testing.accountHeadCode=acct;
        if($scope.testing.toDate !='' && $scope.testing.fromDate != '' && $scope.testing.companyCode !=''){
            $http.post('app/receiptPayment/exportGeneralLedgerExcelOP', $scope.testing).success(function(data) {
                if(data){
                    debugger;
                    $("#GLExport").bind('click', function() {
                    });
                    $('#GLExport').simulateClick('click');
                    logger.logSuccess("Exported successfully!");
                }else{
                    logger.logError("Failed to export");
                }
                
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        }else{
            if(($scope.testing.toDate =='' || $scope.testing.fromDate == '') && $scope.testing.companyCode =='')
                logger.logError("Please select Company and valid date range");
            else if($scope.testing.companyCode =='')
                logger.logError("Please select Company");
            else if($scope.generalLedger.toDate =='' && $scope.generalLedger.fromDate == '')
                logger.logError("Please select valid date range");
        }
    }
    
    $scope.doubleshowTable = function(index, accounthead,status,list,showaccounthead) {
         if(status=='minus'){
               $("#plus" + index).css("display", "block");
               $("#minus" + index).css("display", "none");
               $scope.geneSubgroupData[0].lGeneralLedgerAHList[index].showaccounthead='';
         }else{
               $("#minus" + index).css("display", "block");
               $("#plus" + index).css("display", "none");
               $scope.geneSubgroupData[0].lGeneralLedgerAHList[index].showaccounthead=accounthead;
              
         }
        
        
       
    }
    
    $scope.exportGeneralLedgerExcelAccountHead = function(accountHead){
        debugger;
        console.log($scope.testing);
        console.log($rootScope.acc);
        var acct=$rootScope.acc;
        $scope.testing.accountHeadCode=accountHead;
        $scope.testing.mainAccountCode=accountHead;
        if($scope.testing.toDate !='' && $scope.testing.fromDate != '' && $scope.testing.companyCode !=''){
            $http.post('app/receiptPayment/exportGeneralLedgerExcelOP', $scope.testing).success(function(data) {
                if(data){
                    debugger;
                    $("#GLExport").bind('click', function() {
                    });
                    $('#GLExport').simulateClick('click');
                    logger.logSuccess("Exported successfully!");
                }else{
                    logger.logError("Failed to export");
                }
                
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        }else{
            if(($scope.testing.toDate =='' || $scope.testing.fromDate == '') && $scope.testing.companyCode =='')
                logger.logError("Please select Company and valid date range");
            else if($scope.testing.companyCode =='')
                logger.logError("Please select Company");
            else if($scope.generalLedger.toDate =='' && $scope.generalLedger.fromDate == '')
                logger.logError("Please select valid date range");
        }
    }
    $scope.exportGeneralLedgerExcel1 = function(){
        debugger;
        console.log($scope.testing);
        console.log($rootScope.acc);
        var acct=$rootScope.acc;
        $scope.testing.accountHeadCode=acct;
        if($scope.testing.toDate !='' && $scope.testing.fromDate != '' && $scope.testing.companyCode !=''){
            $http.post('app/receiptPayment/exportGeneralLedgerExcel', $scope.testing).success(function(data) {
                if(data){
                    debugger;
                    $("#GLExport").bind('click', function() {
                    });
                    $('#GLExport').simulateClick('click');
                    logger.logSuccess("Exported successfully!");
                }else{
                    logger.logError("Failed to export");
                }
                
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        }else{
            if(($scope.testing.toDate =='' || $scope.testing.fromDate == '') && $scope.testing.companyCode =='')
                logger.logError("Please select Company and valid date range");
            else if($scope.testing.companyCode =='')
                logger.logError("Please select Company");
            else if($scope.testing.toDate =='' && $scope.testing.fromDate == '')
                logger.logError("Please select valid date range");
        }
    }
    
    $scope.exportTransactionLevelExcel1 = function(){
        debugger;
        var acct=$rootScope.acc;
        $scope.testing.accountHeadCode=acct;
        if($scope.testing.toDate !='' && $scope.testing.fromDate != '' && $scope.testing.companyCode !=''){
            $http.post('app/receiptPayment/exportTransactionLevelExcel', $scope.testing).success(function(data) {
                if(data){
                    debugger;
                    $("#GLExport").bind('click', function() {
                    });
                    $('#GLExport').simulateClick('click');
                    logger.logSuccess("Exported successfully!");
                }else{
                    logger.logError("Failed to export");
                }
                
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        }else{
            if(($scope.testing.toDate =='' || $scope.testing.fromDate == '') && $scope.testing.companyCode =='')
                logger.logError("Please select Company and valid date range");
            else if($scope.testing.companyCode =='')
                logger.logError("Please select Company");
            else if($scope.testing.toDate =='' && $scope.testing.fromDate == '')
                logger.logError("Please select valid date range");
        }
    }
  
    
    function addLink(cellvalue, options, rowObject) 
    {
        $scope.companyId = $scope.generalLedger.companyCode;
        $scope.fromDate = $scope.generalLedger.fromDate;
        $scope.toDate = $scope.generalLedger.toDate ; 
        $scope.subGroupCode = rowObject.subGroupCode;
        $scope.id=cellvalue;
        return "<a href='#/"+$stateParams.tenantid+"/reports/finance/generalLedgersubgroup?companyId="+$scope.generalLedger.companyCode+"&subGroupCode="+$scope.subGroupCode+"&id="+cellvalue+"&fromDate="+$scope.generalLedger.fromDate+"&toDate="+$scope.generalLedger.toDate +"'  style='height:25px;width:120px;' type='button' title='Click to here view ledger'  target=\"_blank\" >"+cellvalue+"</a>";
    }
    $scope.populateGeneralLedgerGrid = function(sgListData){
        var companyCode = $("#companyCode").val();

        if(companyCode==''){
            $scope.currencCode= "(INR)";
        }else{
            $scope.currencCode= "";
        }
        console.log("sgListData")
        console.log(sgListData)
        debugger;
        var data=[];
        $("#generalLedgerGrid").GridUnload();
        $("#generalLedgerGrid").jqGrid({
            data: sgListData.lGeneralLedgerList,
            datatype: "local",
            multiboxonly: false,
            autowidth: true,
            height: '100%',
            rowNum: 100,
            rowList: [100,200,300],
            multiselect: false,
            loadonce: true,
            gridview:true,
            colNames : [ 'Sub Group Head Code', 'Sub Group Head Name','Debit'+$scope.currencCode, 'Credit'+$scope.currencCode,' Balance'+$scope.currencCode],
            colModel:[
                {name:'subGroupCode',index:'subGroupCode', width:80, align:"left",searchoptions:{sopt:['cn']}},
                {name:'subGroupName1',index:'subGroupName1',  formatter: addLink ,width:80, align:"left",searchoptions:{sopt:['cn']},hidden:false},
               // {name:'tcDebit',index:'tcDebit', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
               // {name:'tcCredit',index:'tcCredit', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                {name:'bcDebit',index:'tcDebit', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                {name:'bcCredit',index:'tcCredit', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
             //   {name:'currentTCBalance',index:'currentTCBalance', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                {name:'currentBalance',index:'currentBalance', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}}
             
                ],
            pager: "#generalLedgerPage",
            viewrecords: true,
            ignoreCase: true,
            subGrid: true,
            subGridOptions: {
                "plusicon" : 'ui-icon-plus',
                "minusicon" : 'ui-icon-minus'
            },
            footerrow: true,
            loadComplete: function () {
                var $grid = $('#generalLedgerGrid');
                var tcCredit = $grid.jqGrid('getCol', 'tcCredit', false, 'sum');
                var tcDebit = $grid.jqGrid('getCol', 'tcDebit', false, 'sum');
                var credit = $grid.jqGrid('getCol', 'bcCredit', false, 'sum');
                var debit = $grid.jqGrid('getCol', 'bcDebit', false, 'sum');
                
                var difference = debit - credit;
                var tcDifference = tcDebit - tcCredit;
                console.log("-BCdifference"+difference);
                console.log("-TCdifference"+tcDifference);
       
                console.log("difference")
                 console.log(sgListData.amt.closingBalance)

                $(this).jqGrid('footerData','set',{ subGroupName:'Total', tcDebit:tcDebit.toFixed(2),tcCredit:tcCredit.toFixed(2),
                    bcDebit:debit.toFixed(2),bcCredit:credit.toFixed(2),currentTCBalance:tcDifference.toFixed(2),currentBalance:difference.toFixed(2)});
            },
           
          
            subGridRowExpanded: function(subgrid_id, row_id) {
                //alert(row_id)
                debugger;
                var subgrid_table_id, pager_id; subgrid_table_id = subgrid_id+"_t";
                pager_id = "p_"+subgrid_table_id;
                var rowData = jQuery('#generalLedgerGrid').jqGrid ('getRowData', row_id);
                $scope.generalLedger.subGroupCode =rowData.subGroupCode;
                $("#"+subgrid_id).html("<table id='"+subgrid_table_id+"' class='scroll'></table><div id='"+pager_id+"' class='scroll'></div>");
                $http.post('app/receiptPayment/getGeneralLedgerAHLevel',$scope.generalLedger).success(function(data) {
                 if(data.success){
                     debugger;
                     var glAHlevelDataList =data.lGeneralLedgerAHList;
                     $("#"+subgrid_table_id).jqGrid({
                     datatype: "local",
                     data: glAHlevelDataList,
                     colNames:['Acct Head Code','Acct Head Name','Debit', 'Credit','Balance'],
                                        
                     colModel:[
                            {name:'accountHeadCode',index:'accountHeadCode', width:200, align:"left",searchoptions:{sopt:['cn']}},
                            {name:'accountHeadName',index:'accountHeadName', width:200, align:"left",searchoptions:{sopt:['cn']},hidden:false},
                          //  {name:'tcDebit',index:'tcDebit', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                            //{name:'tcCredit',index:'tcCredit', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                            {name:'bcDebit',index:'bcDebit', width:200,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                            {name:'bcCredit',index:'bcCredit', width:200,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                          //  {name:'currentTCBalance',index:'currentTCBalance', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                            {name:'currentBalance',index:'currentBalance', width:200,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}}
                        ],
                     autowidth: true,
                     height: '100%',
                     pager: pager_id,
                     sortname: 'num',
                     sortorder: "asc",
                     // transaction level
                     subGrid: true,
                     subGridOptions: {
                         "plusicon" : 'ui-icon-plus',
                         "minusicon" : 'ui-icon-minus'
                     },
                     

                     footerrow: true,

                     subGridRowExpanded: function(subgrid_child_id, row_id) {
                         debugger;
                         var subgridchild_table_id, pager_id; subgridchild_table_id = subgrid_child_id+"_t";
                         pager_id = "p_"+subgridchild_table_id;
                         var rowData = jQuery('#'+subgrid_table_id).jqGrid ('getRowData', row_id);
                         $scope.generalLedger.accountHeadCode =rowData.accountHeadCode;
                         $("#"+subgrid_child_id).html("<table id='"+subgridchild_table_id+"' class='scroll'></table><div id='"+pager_id+"' class='scroll'></div>");
                         $http.post('app/receiptPayment/getGLTransactionLevel', $scope.generalLedger).success(function(data) {
                          if(data.success){
                              debugger;
                              var glTransactionlevelDataList =data.lGeneralLedgerTransactionList;
                              $("#"+subgridchild_table_id).jqGrid({
                              datatype: "local",
                              data: glTransactionlevelDataList,
                              colNames:['Transaction No','Ledger Dt','Party Inv No','SA Name','Currency','Ex-Rate','Debit','Credit','Status','Allocated to'],
                              colModel:[
                                 {name:'transactionNo',index:'transactionNo', width:100, align:"left",
                                     searchoptions:{sopt:['cn']},classes: 'cursor-pointer'},
                                 /*{name:'voucherNo',index:'voucherNo', width:100, align:"left",searchoptions:{sopt:['cn']},hidden:false}, */   
                                 {name:'ledgerDate',index:'ledgerDate', width:100, align:"left",searchoptions:{sopt:['cn']},hidden:false},
                                 {name:'partyInvoiceNo',index:'partyInvoiceNo', width:100, align:"left",searchoptions:{sopt:['cn']},hidden:false},
                                 /*{name:'narration',index:'narration', width:200,align:"left", searchoptions:{sopt:['cn']},hidden:false},*/
                                 /*{name:'subAccountCode',index:'subAccountCode', width:70, align:"left",searchoptions:{sopt:['cn']}},*/
                                 {name:'subAccountName',index:'subAccountName', width:300, align:"left",searchoptions:{sopt:['cn']},hidden:false},
                                 {name:'currency',index:'currency', width:50,align:"left", searchoptions:{sopt:['cn']},hidden:false},
                                 {name:'exchangeRate',index:'exchangeRate', width:50,align:"right", searchoptions:{sopt:['cn']},hidden:false},
                             //    {name:'tcDebit',index:'tcDebit', width:150,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                              //   {name:'tcCredit',index:'tcCredit', width:150,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                                 {name:'bcDebit',index:'bcDebit', width:150,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                                 {name:'bcCredit',index:'bcCredit', width:150,align:"right", searchoptions:{sopt:['cn']},hidden:false,formatter:'currency',formatoptions: { thousandsSeparator:','}},
                                 {name:'allocationStatus',index:'allocationStatus', width:100, align:"left",searchoptions:{sopt:['cn']},hidden:false},
                                 {name:'allocatedTo',index:'allocatedTo', width:100, align:"left",searchoptions:{sopt:['cn']},hidden:false},
                                 
                                 ],
                                 onCellSelect: function(rowid, iCol)
                                 {
                                     debugger;
                                     /* Row Click Based Event ******************** Start */
                                     var cm = jQuery("#"+subgridchild_table_id).jqGrid("getGridParam", "colModel");
                                     var transactionNoCell = jQuery("#"+subgridchild_table_id).jqGrid("getCell", rowid, "transactionNo");
                                     var colName = cm[iCol];
                                     console.log(colName);
                                     if(colName.name=="transactionNo"){
                                         utilsService.reportVoucherPrint(transactionNoCell);
                                     }
                                     //jqGridRowClickBasedEvent('productMasterGrid',rowid,'viewRow','editrow',iCol,colName.name);
                                     /* Row Click Based Event ******************** Endss */ 
                                 },
                              autowidth: true,
                              height: '100%',
                              pager: pager_id,
                              sortname: 'num',
                              sortorder: "asc", }).jqGrid('setGridParam', { data : glTransactionlevelDataList }).trigger("reloadGrid");
                          }
                         
                         }).error(function(tbAHlevelDataList) {
                         });
                      } }).jqGrid('setGridParam', { data : glAHlevelDataList }).trigger("reloadGrid");
                 }
                
                }).error(function(glAHlevelDataList) {
                });
             }
        }).jqGrid('setGridParam', { data : sgListData }).trigger("reloadGrid");
        
    }
    
    
    //group code
/*   
         $scope.$watch('generalLedger.objGroupCodes', function(newValue, oldValue) {
                
                if (newValue != '' && newValue != undefined) {
                    
                     $scope.subcollection = [];
                     $scope.test = [];
                     for(var i=0;i<newValue.length;i++){
                         $scope.subcollection.push(newValue[i].text);
                     }
                     $scope.test= $scope.subcollection;
                     
                     $scope.subcollection.push(newValue);
                     $http.get('app/receiptPayment/getsubgroupList?subgroup='+ $scope.test).success(function(datas) {
                         if(datas != null){
                              $scope.subGroupList = datas;
                              $scope.sub = false;
                         }
                       
                         }).error(function(datas) {
                     });
                }
            });*/
         
   
    //sub code
   /* $scope.$watch('generalLedger.subGroupCode', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
            
             $http.get('app/receiptPayment/getmaingroupList?maingroup='+  newValue).success(function(datas) {
                 if(datas != null){
                      $scope.accountHeadList = datas;
                      $scope.main = false;
                 }
               
                 }).error(function(datas) {
             });
        }
    });*/
    
    $scope.cancel=function(){
        
        $state.go('app.reports.finance.dayBook',{tenantid:$stateParams.tenantid});
    }
   
    
    
    
   
    
});
     
//});