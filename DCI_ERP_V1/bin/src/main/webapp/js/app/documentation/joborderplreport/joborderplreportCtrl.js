


'use strict';
app.controller('joborderplctrl', function($scope, $timeout, $stateParams,sharedProperties,toaster,
		$filter, $rootScope, $http, $location, logger, $state, ngDialog,$controller,$injector) {
    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.detailList=[];
    $scope.isRemarks = false;
	$scope.vesselList = [];
	$scope.voyageList = [];
	 $scope.blInventroy = "";
	 $scope.blLocation = "";
	 $scope.hideAddIcon=true;
	 $scope.isAdd=true;
     $scope.customerList=[];
	 $scope.vendorList =[];
     $scope.salesPersonList=[];

	 
	 $scope.viewBlDetail = function(blNo){
	  		ngDialog.close();
	  		$location.url($stateParams.tenantid+'/reports/BLDetail?blNo='+blNo+'&from=bldraft');
	  	 };



$scope.plreport = {
		vessel:'',
		voyage:'',
		dateFrom:'',
		dateTo:'',
		carrier:'',
		quotationDtl:[{id:0,chargeHeads:'',unit:'',currency:'',qty:'',rate:'',paymentMethod : '',transactionType : '',buySell : '',note : ''}],

};



$http.get($stateParams.tenantid+ '/app/commonUtility/getVesselList').success(function(data) {
	$scope.vesselList = data;
});

$http.post($stateParams.tenantid+'/app/seaquotation/getServicePartnerList').success(function(datas) {
			debugger
			 $scope.customerList = datas.customerList;
			 $scope.vendorList = datas.vendorList;
		  
		  
		}).error(function(data) {

		});
			$http
						.get(
								$stateParams.tenantid
										+ '/app/seaquotation/getEmployeeList')
						.success(
								function(datas) {
									$scope.salesPersonList = datas.commonUtilityBean;

								}).error(function(data) {

						});
		 $http.get($stateParams.tenantid+'/app/seaquotation/getServicePartnerList').success(function(data) {
    	
        $scope.vendorList = data.vendorMasterList;
})
$scope.$watch('plreport.vessel', function(newValue, oldValue) {
      if(newValue!=null && newValue!=undefined && newValue != ''){
    	  $http.post($stateParams.tenantid+ '/app/commonUtility/getVoyageListByVessel',newValue).success(function(data) {
				$scope.voyageList = data;
    	  });
      }
      
    });

/*$scope.search = function() {
		
			$scope.buy=0,$scope.sell=0,$scope.total=0;
			 $http.post($stateParams.tenantid+'/api/joborderpl/list',$scope.plreport).success(function(datas) {
				 if(datas.list.length>0){
					 $scope.rowCollection = datas.list;
		                $scope.createGrid(datas.list);

				        for(var i=0;i<datas.list.length;i++){
				        	$scope.buy +=  datas.list[i].buy; 
				        	$scope.sell += datas.list[i].sell;
				        	$scope.total += datas.list[i].total; 
				        }
				 }else{
					 logger.logError("No Data Found!!!");
					 $scope.rowCollection = [];
					 
				 }
			       
			        
			        }).error(function(datas) {
			    });
		
		
		
	};

$scope.search();

*/





$scope.search = function() {


	$scope.buy=0,$scope.sell=0,$scope.total=0;
	 $http.post($stateParams.tenantid+'/api/joborderpl/list',$scope.plreport).success(function(response) {
	        for(var i=0;i<response.list.length;i++){
	        	$scope.buy +=  response.list[i].buy; 
	        	$scope.sell += response.list[i].sell;
	        	$scope.total += response.list[i].total; 
	        }
	 

		// $scope.rowCollection = datas.list;
		 

            $('#bankbookGrid').setGridParam({
          data : response.list
            }).trigger('reloadGrid');
          //  $scope.getOutstandingBalance();
        }).error(function(datas) {
        });
    
};

$scope.search();



$scope.searchNEW = function() {

	  //  $("#bankbookGrid").hide();
	  $("#loader").hide();

	$scope.buy=0,$scope.sell=0,$scope.total=0;
	 $http.post($stateParams.tenantid+'/api/joborderpl/list',$scope.plreport).success(function(datas) {
		 $scope.rowCollection = datas.list;

         $("#generalLedgerGrid").jqGrid('clearGridData');
         jQuery('#generalLedgerGrid').jqGrid('clearGridData').jqGrid('setGridParam', {data: datas, datatype: 'json'}).trigger('reloadGrid');
         $scope.populateGeneralLedgerGrid(datas);
          //  $scope.getOutstandingBalance();
        }).error(function(response) {
        });
    
};

//$scope.searchNEW();





$scope.reset = function(){
	$scope.plreport = {
			vessel:'',
			voyage:'',
			dateFrom:'',
			dateTo:'',
			carrier:''
	};
	  $scope.search();
}



$scope.reloadGrid = function(data) {
    $('#bankbookGrid').setGridParam({
        data : data,
        rowNum : data.length
    }).trigger('reloadGrid');
};

$scope.getSubGridList = function(bookingNo, subgridDivId) {
    var newValue =bookingNo ;
$http
.post($stateParams.tenantid+ '/app/seaquotation/editjore',newValue)
.success(
	function(data) {

        var subgridTableId = subgridDivId + "_t";
        $("#" + subgridTableId).setGridParam({
	data : data.lQuotationBean[0].quotationDtl,
    rowNum : data.lQuotationBean[0].quotationDtl.length

        }).trigger('reloadGrid');
    });
};



/*
$scope.getSubGridListnew = function(bookingNo, subgridDivId) {
    var newValue =bookingNo ;
$http
.post($stateParams.tenantid+ '/app/seaquotation/editjore',newValue)
.success(
	function(data) {

        var subgridTableId = subgridDivId + "_t";
        $("#" + subgridTableId).setGridParam({
	data : data.lQuotationBean[0].quotationDtl,
    rowNum : data.lQuotationBean[0].quotationDtl.length

        }).trigger('reloadnewGrid');
    });
};



*/
$scope.createGrid = function(search) {
    $("#bankbookGrid").jqGrid({
        data : search,
        datatype : "local",
        autowidth : true,
        autoheight : true,
        rowList : [ 5, 10, 20 ],
        gridview : true,
        sortname : 'invdate',
        viewrecords : true,
        sortorder : 'desc',
        multiselect : false,
        multiboxonly : false,
colNames : [ 'Booking No', 'Job No', 'Vessel', 'Voyage', 'POL', 'POD','Customer', 'Volume','Buy','Sell','Profit / Loss' ],
        colModel : [ /*{
    name : 'bookingno',
    index : 'bookingno',
    align : 'left',
    width : 40,
    searchoptions : {
        sopt : [ 'cn' ]
    },
    hidden : true
},*/
{
    name : 'bookingno',
    index : 'bookingno',
    align : 'left',
    width : 60,
    searchoptions : {
        sopt : [ 'cn' ]
    },
    hidden : false
},
{
    name : 'jobNo',
    index : 'jobNo',
    align : 'left',
    width : 80,
    searchoptions : {
        sopt : [ 'cn' ]
    },
    hidden : false
}, {
    name : 'vessel',
    index : 'vessel',
    width : 50,
    align : "left",
    searchoptions : {
        sopt : [ 'cn' ]
    }
}, {
    name : 'voyage',
    index : 'voyage',
    width : 65,
    align : "right",
    searchoptions : {
        sopt : [ 'cn' ]
    }
}, {
    name : 'pol',
    index : 'pol',
    align : 'right',
    width : 65,
    searchoptions : {
        sopt : [ 'cn' ]
    }
}, {
    name : 'pod',
    index : 'pod',
    width : 100,
    align : "right",
    searchoptions : {
        sopt : [ 'cn' ]
    }
    
}, {
    name : 'customer',
    index : 'customer',
    align : 'right',
    width : 65,
    searchoptions : {
        sopt : [ 'cn' ]
    }
}, {
    name : 'volume',
    index : 'volume',
    width : 100,
    align : "right",
    searchoptions : {
        sopt : [ 'cn' ]
    }
    
}, 

{
    name : 'buy',
    index : 'buy',
    width : 90,
    align : "right",
    searchoptions : {
        sopt : [ 'cn' ]
    }
    
}, 

{
    name : 'sell',
    index : 'sell',
    width : 90,
    align : "right",
    searchoptions : {
        sopt : [ 'cn' ]
    }
    
}, 

{
    name : 'total',
    index : 'total',
    width : 100,
    align : "right",
    searchoptions : {
        sopt : [ 'cn' ]
    },
    
}, 



],  loadOnce : true,
        pager : '#bankbookdiv',
        height : '100%',
        rowNum : 10,
        subGrid : true,
        subGridOptions : {
        	  "plusicon" : 'ui-icon-plus',
              "minusicon" : 'ui-icon-minus'
        },
        
        footerrow: true,
        loadComplete : function() {
         	   

                debugger;
                    var $grid = $('#bankbookGrid');
                    
                    var buy = $grid.jqGrid('getCol', 'buy', false, 'sum');
                    var sell = $grid.jqGrid('getCol', 'sell', false, 'sum');
                    var total = $grid.jqGrid('getCol', 'total', false, 'sum');
                   

                    $(this).jqGrid('footerData','set',{ pod:'Total', buy:buy,sell:sell,
                   	 total:total});
                
     },
        
        
        
           subGridRowExpanded : function(subgridDivId, rowId) {

            var rowData = $('#bankbookGrid').jqGrid('getRowData', rowId);
    var booking =rowData.bookingno;

            $scope.getSubGridList(rowData.bookingno, subgridDivId);
            var subgridTableId = subgridDivId + "_t";
            var pager_child_id = "p_" + subgridTableId;
            $("#" + subgridDivId).html("<table id='" + subgridTableId + "'></table><div id='" + pager_child_id + "' class='scroll'></div>");
            $("#" + subgridTableId).jqGrid({
                datatype : 'local',
                data : "",
        colNames : [ 'Charge Heads', 'Unit', 'Container Type ', 'Qty','Rate','Currency','Transaction Type','Buy/Sell Party','Notes'],
        colModel : [ {
            name : 'chargeHeads1',
            index : 'chargeHeads1',
            width : 270,
            searchoptions : {
                sopt : [ 'cn' ]
            }
        }, {
            name : 'unitName',
            index : 'unitName',
            width : 270,
            align : "left",
            searchoptions : {
                sopt : [ 'cn' ]
            }
        }, {
            name : 'conType',
            index : 'conType',
            width : 267,
            align : "right",
            searchoptions : {
                sopt : [ 'cn' ]
            }
        }, {
            name : 'qty',
            index : 'qty',
            width : 267,
            align : "right",
            searchoptions : {
                sopt : [ 'cn' ]
            }
        },
        
        {
            name : 'rate',
            index : 'rate',
            width : 267,
            align : "right",
            searchoptions : {
                sopt : [ 'cn' ]
            }
        } ,
        
        
        
        
        {
            name : 'currencyName',
            index : 'currencyName',
            width : 267,
            align : "right",
            searchoptions : {
                sopt : [ 'cn' ]
            }
        } ,
        
        
        {
            name : 'transactionType1',
            index : 'transactionType1',
            width : 267,
            align : "right",
            searchoptions : {
                sopt : [ 'cn' ]
            }
        } ,
        
        {
            name : 'tranType',
            index : 'tranType',
            width : 267,
            align : "right",
            searchoptions : {
                sopt : [ 'cn' ]
            }
        } ,
       
        {
            name : 'note',
            index : 'note',
            width : 267,
            align : "right",
            searchoptions : {
                sopt : [ 'cn' ]
            },
        } ,
      
        
        ],
        autoheight : true,
        height : '100%',
        sortname : 'num',
        sortorder : "asc",
    
    }).error(function() {
    });


},
        });

    $("#bankbookGrid").jqGrid('navGrid', '#bankbookdiv', {
        edit : false,
        add : false,
        del : false,
        search : false,
        refresh : false
    });

    $("#bankbookGrid").jqGrid('filterToolbar', {
        searchOperators : true,
        searchOnEnter : false
    });
    $("#bankbookGrid")[0].toggleToolbar();
};

$scope.createGrid();








$scope.populateGeneralLedgerGrid = function(sgListData){

    console.log("sgListData")
    console.log(sgListData)
    debugger;
    var data=[];
    $("#generalLedgerGrid").GridUnload();
    $("#generalLedgerGrid").jqGrid({
        data: sgListData.list,
        datatype: "local",
        multiboxonly: false,
        autowidth: true,
        height: '100%',
        rowNum: 100,
        rowList: [100,200,300],
        multiselect: false,
        loadonce: true,
        gridview:true,
        
        colNames : [ 'Booking No ', 'Job No', 'Vessel', 'Voyage', 'POL', 'POD', 'Customer', 'Volume','Buy','Sell','Profit / Loss' ],
        colModel : [ /*{
    name : 'bookingno',
    index : 'bookingno',
    align : 'left',
    width : 40,
    searchoptions : {
        sopt : [ 'cn' ]
    },
    hidden : true
},*/
{
    name : 'bookingno',
    index : 'bookingno',
    align : 'left',
    width : 60,
    searchoptions : {
        sopt : [ 'cn' ]
    },
    hidden : false
},
{
    name : 'jobNo',
    index : 'jobNo',
    align : 'left',
    width : 80,
    searchoptions : {
        sopt : [ 'cn' ]
    },
    hidden : false
}, {
    name : 'vessel',
    index : 'vessel',
    width : 50,
    align : "left",
    searchoptions : {
        sopt : [ 'cn' ]
    }
}, {
    name : 'voyage',
    index : 'voyage',
    width : 65,
    align : "right",
    searchoptions : {
        sopt : [ 'cn' ]
    }
}, {
    name : 'pol',
    index : 'pol',
    align : 'right',
    width : 65,
    searchoptions : {
        sopt : [ 'cn' ]
    }
}, {
    name : 'pod',
    index : 'pod',
    width : 100,
    align : "right",
    searchoptions : {
        sopt : [ 'cn' ]
    }
    
}, {
    name : 'customer',
    index : 'customer',
    align : 'right',
    width : 65,
    searchoptions : {
        sopt : [ 'cn' ]
    }
}, {
    name : 'volume',
    index : 'volume',
    width : 100,
    align : "right",
    searchoptions : {
        sopt : [ 'cn' ]
    }
    
}, 

{
    name : 'buy',
    index : 'buy',
    width : 90,
    align : "right",
    searchoptions : {
        sopt : [ 'cn' ]
    }
    
}, 

{
    name : 'sell',
    index : 'sell',
    width : 90,
    align : "right",
    searchoptions : {
        sopt : [ 'cn' ]
    }
    
}, 

{
    name : 'total',
    index : 'total',
    width : 100,
    align : "right",
    searchoptions : {
        sopt : [ 'cn' ]
    },
    
}, 



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
        loadComplete : function() {
         	   

                debugger;
                    var $grid = $('#generalLedgerGrid');
                    
                    var buy = $grid.jqGrid('getCol', 'buy', false, 'sum');
                    var sell = $grid.jqGrid('getCol', 'sell', false, 'sum');
                    var total = $grid.jqGrid('getCol', 'total', false, 'sum');
                   

                    $(this).jqGrid('footerData','set',{ pod:'Total', buy:buy.toFixed(2),sell:sell.toFixed(2),
                   	 total:total.toFixed(2)});
                
     },
        
       
      
        subGridRowExpanded: function(subgrid_id, row_id) {
        	//alert(row_id)
            debugger;
            var subgrid_table_id, pager_id; subgrid_table_id = subgrid_id+"_t";
            pager_id = "p_"+subgrid_table_id;
            var rowData = jQuery('#generalLedgerGrid').jqGrid ('getRowData', row_id);
            var booking =rowData.bookingno;
   		 var newValue = booking;
            $("#"+subgrid_id).html("<table id='"+subgrid_table_id+"' class='scroll'></table><div id='"+pager_id+"' class='scroll'></div>");
            $http.post($stateParams.tenantid+'/app/seaquotation/editjore',newValue).success(function(data) {
             if(data.success){
                 debugger;
                // var glAHlevelDataList =data.lGeneralLedgerAHList;
             	var glAHlevelDataList=data.lQuotationBean[0].quotationDtl;
                 $("#"+subgrid_table_id).jqGrid({
                 datatype: "local",
                 data: glAHlevelDataList,
                 colNames : [ 'Charge Heads', 'Unit', 'Container Type ', 'Qty','Rate','Currency','Transaction Type','Buy/Sell Party','Notes'],
                 colModel : [ {
                     name : 'chargeHeads1',
                     index : 'chargeHeads1',
                     width : 270,
                     searchoptions : {
                         sopt : [ 'cn' ]
                     }
                 }, {
                     name : 'unitName',
                     index : 'unitName',
                     width : 270,
                     align : "left",
                     searchoptions : {
                         sopt : [ 'cn' ]
                     }
                 }, {
                     name : 'conType',
                     index : 'conType',
                     width : 267,
                     align : "right",
                     searchoptions : {
                         sopt : [ 'cn' ]
                     }
                 }, {
                     name : 'qty',
                     index : 'qty',
                     width : 267,
                     align : "right",
                     searchoptions : {
                         sopt : [ 'cn' ]
                     }
                 },
                 
                 {
                     name : 'rate',
                     index : 'rate',
                     width : 267,
                     align : "right",
                     searchoptions : {
                         sopt : [ 'cn' ]
                     }
                 } ,
                 
                 
                 
                 
                 {
                     name : 'currencyName',
                     index : 'currencyName',
                     width : 267,
                     align : "right",
                     searchoptions : {
                         sopt : [ 'cn' ]
                     }
                 } ,
                 
                 
                 {
                     name : 'transactionType1',
                     index : 'transactionType1',
                     width : 267,
                     align : "right",
                     searchoptions : {
                         sopt : [ 'cn' ]
                     }
                 } ,
                 
                 {
                     name : 'tranType',
                     index : 'tranType',
                     width : 267,
                     align : "right",
                     searchoptions : {
                         sopt : [ 'cn' ]
                     }
                 } ,
                
                 {
                     name : 'note',
                     index : 'note',
                     width : 267,
                     align : "right",
                     searchoptions : {
                         sopt : [ 'cn' ]
                     },
                 } ,
               
                 
                 ],                 autowidth: true,
                 height: '100%',
                 pager: pager_id,
                 sortname: 'num',
                 sortorder: "asc",
                 // transaction level
                 


                  }).jqGrid('setGridParam', { data : glAHlevelDataList }).trigger("reloadGrid");
             }
            
            }).error(function(glAHlevelDataList) {
            });
         }
    }).jqGrid('setGridParam', { data : sgListData }).trigger("reloadGrid");
    
}













/*

$scope.createnewGrid = function(searchNEW) {
    $("#bankGrid").jqGrid({
        data : searchNEW,
        datatype : "local",
        autowidth : true,
        autoheight : true,
        rowList : [ 5, 10, 20 ],
        gridview : true,
        sortname : 'invdate',
        viewrecords : true,
        sortorder : 'desc',
        multiselect : false,
        multiboxonly : false,
colNames : [ 'Booking No', 'Job No', 'Vessel', 'Voyage', 'POL', 'POD','Buy','Sell','Profit / Loss' ],
        colModel : [ {
    name : 'bookingno',
    index : 'bookingno',
    align : 'left',
    width : 40,
    searchoptions : {
        sopt : [ 'cn' ]
    },
    hidden : true
},
{
    name : 'bookingno',
    index : 'bookingno',
    align : 'left',
    width : 60,
    searchoptions : {
        sopt : [ 'cn' ]
    },
    hidden : false
},
{
    name : 'jobNo',
    index : 'jobNo',
    align : 'left',
    width : 80,
    searchoptions : {
        sopt : [ 'cn' ]
    },
    hidden : false
}, {
    name : 'vessel',
    index : 'vessel',
    width : 50,
    align : "left",
    searchoptions : {
        sopt : [ 'cn' ]
    }
}, {
    name : 'voyage',
    index : 'voyage',
    width : 65,
    align : "right",
    searchoptions : {
        sopt : [ 'cn' ]
    }
}, {
    name : 'pol',
    index : 'pol',
    align : 'right',
    width : 65,
    searchoptions : {
        sopt : [ 'cn' ]
    }
}, {
    name : 'pod',
    index : 'pod',
    width : 100,
    align : "right",
    searchoptions : {
        sopt : [ 'cn' ]
    }
    
}, 

{
    name : 'buy',
    index : 'buy',
    width : 90,
    align : "right",
    searchoptions : {
        sopt : [ 'cn' ]
    }
    
}, 

{
    name : 'sell',
    index : 'sell',
    width : 90,
    align : "right",
    searchoptions : {
        sopt : [ 'cn' ]
    }
    
}, 

{
    name : 'total',
    index : 'total',
    width : 100,
    align : "right",
    searchoptions : {
        sopt : [ 'cn' ]
    },
    
}, 



],  loadOnce : true,
        pager : '#bankdiv',
        height : '100%',
        rowNum : 10,
        subGrid : true,
        subGridOptions : {
            "plusicon" : 'fa fa-plus',
            "minusicon" : 'fa fa-minus-circle'
        },
        
        footerrow: true,
        loadComplete : function() {
       //  $scope.totalInventory();
         	   

                debugger;
                    var $grid = $('#bankbookGrid1');
                    
                    var buy = $grid.jqGrid('getCol', 'buy', false, 'sum');
                    var sell = $grid.jqGrid('getCol', 'sell', false, 'sum');
                    var total = $grid.jqGrid('getCol', 'total', false, 'sum');
                   

                    $(this).jqGrid('footerData','set',{ pod:'Total', buy:buy.toFixed(2),sell:sell.toFixed(2),
                   	 total:total.toFixed(2)});
                
     },
        subGridRowExpanded : function(subgridDivId, rowId) {

            var rowData = $('#bankGrid').jqGrid('getRowData', rowId);
    var booking =rowData.bookingno;

            $scope.getSubGridListnew(rowData.bookingno, subgridDivId);
            var subgridTableId = subgridDivId + "_t";
            var pager_child_id = "p_" + subgridTableId;
            $("#" + subgridDivId).html("<table id='" + subgridTableId + "'></table><div id='" + pager_child_id + "' class='scroll'></div>");
            $("#" + subgridTableId).jqGrid({
                datatype : 'local',
                data : "",
        colNames : [ 'Charge Heads', 'Unit', 'Container Type ', 'Qty','Rate','Currency','Transaction Type','Buy/Sell Party','Notes'],
        colModel : [ {
            name : 'chargeHeads1',
            index : 'chargeHeads1',
            width : 270,
            searchoptions : {
                sopt : [ 'cn' ]
            }
        }, {
            name : 'unitName',
            index : 'unitName',
            width : 270,
            align : "left",
            searchoptions : {
                sopt : [ 'cn' ]
            }
        }, {
            name : 'conType',
            index : 'conType',
            width : 267,
            align : "right",
            searchoptions : {
                sopt : [ 'cn' ]
            }
        }, {
            name : 'qty',
            index : 'qty',
            width : 267,
            align : "right",
            searchoptions : {
                sopt : [ 'cn' ]
            }
        },
        
        {
            name : 'rate',
            index : 'rate',
            width : 267,
            align : "right",
            searchoptions : {
                sopt : [ 'cn' ]
            }
        } ,
        
        
        
        
        {
            name : 'currencyName',
            index : 'currencyName',
            width : 267,
            align : "right",
            searchoptions : {
                sopt : [ 'cn' ]
            }
        } ,
        
        
        {
            name : 'transactionType1',
            index : 'transactionType1',
            width : 267,
            align : "right",
            searchoptions : {
                sopt : [ 'cn' ]
            }
        } ,
        
        {
            name : 'buy',
            index : 'buy',
            width : 267,
            align : "right",
            searchoptions : {
                sopt : [ 'cn' ]
            }
        } ,
       
        {
            name : 'note',
            index : 'note',
            width : 267,
            align : "right",
            searchoptions : {
                sopt : [ 'cn' ]
            },
        } ,
        {
            name : 'qty',
            index : 'qty',
            width : 267,
            align : "right",
            searchoptions : {
                sopt : [ 'cn' ]
            },
        } ,
       
        
        ],
        autoheight : true,
        height : '100%',
        sortname : 'num',
        sortorder : "asc",
    
    }).error(function() {
    });


},
        loadComplete : function() {
  //  $scope.totalInventory();
}
    });

    $("#bankGrid").jqGrid('navGrid', '#bankdiv', {
        edit : false,
        add : false,
        del : false,
        search : false,
        refresh : false
    });

    $("#bankGrid").jqGrid('filterToolbar', {
        searchOperators : true,
        searchOnEnter : false
    });
    $("#bankGrid").jqGrid('navButtonAdd', "#bankdiv", {
        caption : "",
        title : "Show/Hide Search box",
        buttonicon : 'ui-icon icon-thumb-tack',
        onClickButton : function() {
            var myGrid = $('#bankGrid');
            myGrid[0].toggleToolbar();
        }
    });
    $("#bankGrid")[0].toggleToolbar();
};

$scope.createnewGrid();*/



 //Excel Export	
 $scope.exportExcel = function(){

	 $http.post($stateParams.tenantid+'/api/joborderpl/excelExport',$scope.plreport).success(function(datas) {
                if(datas){
                    debugger;
                    $("#Export").bind('click', function() {
                    });
                    $('#Export').simulateClick('click');
                    logger.logSuccess("Exported successfully!");
                }else{
                    logger.logError("Failed to export");
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
  

	// var bookingNo1 = $rootScope.bookingNo1;

		
	
	
	

	 
	    
	    




});


