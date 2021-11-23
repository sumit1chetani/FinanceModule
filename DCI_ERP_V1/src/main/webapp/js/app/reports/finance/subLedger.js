'use strict';
app.controller('subLedgerController', function($templateCache, $timeout, $scope, $rootScope, $http, logger, $log, ngDialog, $modal, $location, $sce, $filter,$stateParams) {

    $('#gl_fromDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime: false
    });
    
    $('#gl_toDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime: false
    });

    $scope.generalLedger = {
            companyCode:'',
            fromDate:'',
            toDate:'',
            subAccountCode:'',
            lpayer : [],
            mainAccountCode : ''
    };

    $scope.formreset = function() {
       // $scope.generalLedger = {};
    	  $scope.generalLedger = {
    	            companyCode:'',
    	            fromDate:'',
    	            toDate:'',
    	            subAccountCode:'',
    	            lpayer : [],
    	            mainAccountCode : ''
    	    };
 
        
        
    };
    

    
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.subGroupList = [];
    $scope.companyList = [];
    
    $scope.getDropDownList = function() {
  /*      $http.get('app/trialBalance/getCompanyList').success(function(data) {
            $scope.companyList = data;
        }).error(function(data) {
        });
        */
        
        $http.get($stateParams.tenantid+'/app/usermaster/getCompanyList?formCode='+$('#form_code_id').val()).success(function(datas) {
            debugger;           
            $scope.companyList = datas;
            datas["id"] = "All";
 			datas["text"] = "ALL";
 			$scope.companyList.push(datas);
            console.log("company")
              console.log($scope.companyList)
              var foundItemDest = $filter('filter')($scope.companyList, { baseCompany:  1 })[0];
            $scope.generalLedger.companyCode=foundItemDest.id;
            }).error(function(datas) {
        });
  /*      $http.get('app/commonUtility/getSubAccountCodeList').success(function(datas) {
            $scope.subAccountCodeList = [];
            $scope.subAccountCodeList = datas.commonUtilityBean;
            console.log("list")
            console.log($scope.subAccountCodeList)
            }).error(function(datas) {
        });  */
    };
    $("#lpayer").multiselect({
        maxHeight: 200,   
        includeSelectAllOption: true,
        enableCaseInsensitiveFiltering: true,
        disableIfEmpty: true,
        onDropdownHide: function (event) {
            
        }
      });
    $("#multiselect-button").addClass("width_100 input-sm line-height-5");
    $scope.getDropDownList();
    $http.get($stateParams.tenantid+'/app/commonUtility/getSubAccountCodeListnew').success(function(data) {
        $scope.subAccountCodeList = [];
        $scope.subAccountCodeList = data.commonUtilityBean;  
        
        $timeout(function() {
            $('#lpayer').multiselect('deselectAll', false);
            $('#lpayer').multiselect('updateButtonText');
            $("#lpayer").multiselect('rebuild');
       
        }, 2, false); 
        
    }).error(function(data) {

    });
    
/*    $http.get($stateParams.tenantid+'/app/purchaseinvoice/getAccountList').success(function(datas) {
        $scope.accountHeadList = datas;
        }).error(function(datas) {
    });*/
    $scope.accountHeadList=[];
    $scope.getaccounthead = function() {
	    var  data = {};
	    data["id"] = "10010004";
	    data["text"] = "Sundry Debtors";
	    $scope.accountHeadList.push(data);
	   /* data = {};
	    data["id"] = "10080002";
	    data["text"] = "Sundry Debtors-Overseas";
	    $scope.accountHeadList.push(data);  */
	    data = {};
	    data["id"] = "20000003";
	    data["text"] = "Sundry Creditors";
	    $scope.accountHeadList.push(data);  
	  /* data = {};
	    data["id"] = "20010003";
	    data["text"] = "Sundry Creditors-Overseas";
	    $scope.accountHeadList.push(data);  */
	    
	}
	$scope.getaccounthead();
    $http.get($stateParams.tenantid+'/app/commonUtility/getSubAccountCodeListnew').success(function(datas) {
        $scope.subAccountCodeList = [];
        $scope.subAccountCodeList = datas.commonUtilityBean;
        $timeout(function() {
            $('#lpayer').multiselect('deselectAll', false);
            $('#lpayer').multiselect('updateButtonText');
            $("#lpayer").multiselect('rebuild');
       
        }, 2, false); 
        console.log(datas);
        }).error(function(datas) {
    });  

    
    $scope.$watch('generalLedger.mainAccountCode', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
            $scope.generalLedger.subAccountCode = '';
            $scope.generalLedger.subGroupCode=newValue.substring(0, 4);
            if(newValue == '10010004'){
                $http.get($stateParams.tenantid+'/app/commonUtility/getcustomerlocal').success(function(datas) {
                    $scope.subAccountCodeList = [];
                    $scope.subAccountCodeList = datas.commonUtilityBean;
                    $timeout(function() {
                        $('#lpayer').multiselect('deselectAll', false);
                        $('#lpayer').multiselect('updateButtonText');
                        $("#lpayer").multiselect('rebuild');
                   
                    }, 2, false); 
                    console.log(datas);
                    }).error(function(datas) {
                });
            }else if(newValue == '10080002'){
                $http.get($stateParams.tenantid+'/app/commonUtility/getcustomeroverseas').success(function(datas) {
                    $scope.subAccountCodeList = [];
                    $scope.subAccountCodeList = datas.commonUtilityBean;
                    $timeout(function() {
                        $('#lpayer').multiselect('deselectAll', false);
                        $('#lpayer').multiselect('updateButtonText');
                        $("#lpayer").multiselect('rebuild');
                   
                    }, 2, false); 
                    }).error(function(datas) {
                });   
            }
            else if(newValue == '20000003'){
                $http.get($stateParams.tenantid+'/app/commonUtility/getsupplierlocal').success(function(datas) {
                    $scope.subAccountCodeList = [];
                    $scope.subAccountCodeList = datas.commonUtilityBean;
                    $timeout(function() {
                        $('#lpayer').multiselect('deselectAll', false);
                        $('#lpayer').multiselect('updateButtonText');
                        $("#lpayer").multiselect('rebuild');
                   
                    }, 2, false); 
                    }).error(function(datas) {
                });   
            }
            else if(newValue == '20010003'){
                $http.get($stateParams.tenantid+'/app/commonUtility/getsupplieroverseas').success(function(datas) {
                    $scope.subAccountCodeList = [];
                    $scope.subAccountCodeList = datas.commonUtilityBean;
                    $timeout(function() {
                        $('#lpayer').multiselect('deselectAll', false);
                        $('#lpayer').multiselect('updateButtonText');
                        $("#lpayer").multiselect('rebuild');
                   
                    }, 2, false); 
                    }).error(function(datas) {
                });   
            }
        }else{
            //$scope.generalLedger.mainAccountCode = '';
        } 
    });
    
    $scope.viewSubLedgerReport = function(){
        var subAcct = "";
        if($scope.lpayer != undefined){
            angular.forEach($scope.lpayer, function (item, key) {
                if(subAcct == ""){
                    subAcct = item.id;
                }else{
                    subAcct +=","+ item.id;
                }       
                $scope.generalLedger.subAccountCode = subAcct;
            });
               
            }
        $scope.generalLedger.fromDate = $('#fromDate').val();
        $scope.generalLedger.toDate = $('#toDate').val();
        if($scope.generalLedger.subAccountCode !=''){
        if($scope.generalLedger.toDate !='' && $scope.generalLedger.fromDate != '' && $scope.generalLedger.companyCode !=''){
            $http.post($stateParams.tenantid+'/app/generalLedger/getsubLedgerReport', $scope.generalLedger).success(function(data) {
                if(data.success){
                    console.log(data.lGeneralLedgerList);
                    $("#subLedgerGrid").jqGrid('clearGridData'); 
                    $scope.populateSubLedgerGrid(data.lGeneralLedgerList);
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
            else if($scope.generalLedger.toDate =='' && $scope.generalLedger.fromDate == '')
                logger.logError("Please select valid date range");
        }
       }else{
            logger.logError("Please select sub account");
        }
        
    };
    
    $scope.exportSubLedgerExcel = function(){
        var subAcct = "";
        if($scope.lpayer!=undefined){
            angular.forEach($scope.lpayer, function (item, key) {
                if(subAcct == ""){
                    subAcct = item.id;
                }else{
                    subAcct +=","+ item.id;
                }       
                $scope.generalLedger.subAccountCode = subAcct;
            });
            }
        $scope.generalLedger.fromDate = $('#fromDate').val();
        $scope.generalLedger.toDate = $('#toDate').val();
        if($scope.generalLedger.subAccountCode !=''){
        if($scope.generalLedger.toDate !='' && $scope.generalLedger.fromDate != '' && $scope.generalLedger.companyCode !=''){
            $http.post($stateParams.tenantid+'/app/generalLedger/exportSubLedgerExcel', $scope.generalLedger).success(function(data) {
                if(data.success){
                  
                  $("#SLExport").bind('click', function() {
                  });
                  $("#SLExport").simulateClick('click');
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
        }else{
            logger.logError("Please select sub account");
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
    
    $scope.populateSubLedgerGrid = function(ListData){
        var data=[];
        $("#subLedgerGrid").jqGrid({
            data: ListData,
            datatype: "local",
            multiboxonly: false,
            autowidth: true,
            height: '100%',
            rowList: [10,20,30],
            multiselect: false,
            loadonce: true,
            gridview:true,
            colNames : [ 'Party','Transaction No', 'Transaction Date','Narration',' Debit','Credit','Debit(USD)','Credit(USD)'],
            colModel:[
            	{name:'subAccountName',index:'partyInvoiceNo', width:80,align:"left", searchoptions:{sopt:['cn']},hidden:false},
                {name:'transactionNo',index:'transactionNo', width:80, align:"left",searchoptions:{sopt:['cn']}},
                {name:'transactionDate',index:'transactionDate', width:80, align:"left",searchoptions:{sopt:['cn']},hidden:false},
                {name:'narration',index:'narration', width:100,align:"right", searchoptions:{sopt:['cn']},hidden:false},
                {name:'bcDebit',index:'bcDebit', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false},
                {name:'bcCredit',index:'bcCredit', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false},
                {name:'tcDebit',index:'tcDebit', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false},
                {name:'tcCredit',index:'tcCredit', width:80,align:"right", searchoptions:{sopt:['cn']},hidden:false}
                ],
            pager: "#subLedgerPage",
            viewrecords: true,
            ignoreCase: true,
            //subGrid: true,
            
            //footerrow: true,
            loadComplete: function () {
                var $grid = $('#subLedgerGrid');
                var credit = $grid.jqGrid('getCol', 'bcCredit', false, 'sum');
                var debit = $grid.jqGrid('getCol', 'bcDebit', false, 'sum');
                var difference = debit - credit;
            },
          
        }).jqGrid('setGridParam', { data : ListData }).trigger("reloadGrid");
        
    }
    
});

