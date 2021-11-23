'use strict';
app.controller('trackingListCtrl', function($templateCache,$timeout, $scope, $rootScope, $http, logger, $log, ngDialog, $modal, $location, $sce, $filter,utilsService,$stateParams) {

 
	 $scope.trackingList=[];
    
    $scope.tracking = {
    		trackingNo:'',
    		trackingBy:'',
    		selectBox:false
    };

    $scope.reset = function() {
        $scope.tracking = {};
        $scope.trackingList=[];
    };

    $scope.selectAll = function(tables) {
        debugger;
        
            angular.forEach(tables, function (value, key) {
         	   var check =value.select;
                if ($scope.tracking.selectBox ==true) {
     	              value.select=true;
     	             
                }else if($scope.tracking.selectBox ==false) {
             	   value.select=false;
                }
                
        });
       
       
    };
    
    $scope.getTrackingReport = function(tracking){

     
       if($scope.tracking.trackingNo !=''  && $scope.tracking.trackingNo !=''  && $scope.tracking.trackingBy !=''&& $scope.tracking.trackingBy !="" ){
            $http.post($stateParams.tenantid+'/app/tracking/getReport?trackingNo='+$scope.tracking.trackingNo+'&trackingBy='+$scope.tracking.trackingBy).success(function(datas) {
            	$scope.trackingList=[];
            	if(datas.success==true)
                	   {
                	   $scope.trackingList= datas.lTrackingBean;
                	   }
            
                   }).error(function(datas) {
               });
        }else{
        	if($scope.tracking.trackingNo ==''  && $scope.tracking.trackingNo ==''  && $scope.tracking.trackingBy =='' && $scope.tracking.trackingBy =="" )
                logger.logError("Please Fill Tracking No and Tracking By Field");
            else if($scope.tracking.trackingBy =='' || $scope.tracking.trackingBy =="")
                logger.logError("Please Fill Tracking By Field");
            
            else if($scope.tracking.trackingNo =='' || $scope.tracking.trackingNo =="")
                logger.logError("Please Fill Tracking No Field");
        }
    }
   
        $http.post($stateParams.tenantid+'/app/tracking/getList').success(function(datas) {
               if(datas.success==true)
            	   {
            	   $scope.trackingList= datas.lTrackingBean;
            	   }
        
               }).error(function(datas) {
           });
    
   /* $scope.populateTrackingGrid=function(listdata){
        var date=[];
           debugger;
           var data=[];
           $("#JournalMainGrid").jqGrid({
               data: $scope.jvData,
               datatype: "local",
               multiboxonly: false,
               autowidth: true,
               height: '100%',
               rowList: [10,20,30],
               multiselect: false,
               loadonce: true,
               gridview:true,
               colNames:['JV Date','Company','JV No','Particulars','Account Head Name','Sub Account','Currency','TC Credit','TC Debit','BC Credit','BC Debit'],
               colModel:[
                   {name:'dataOfIssue',index:'dataOfIssue', width:200, align: "left",sorttype:'text',searchoptions:{sopt:['cn']},resizable: false},//Added for avoid resizing the grid.
                   {name:'companyName',index:'companyName', width:200, align: "left",sorttype:'text',searchoptions:{sopt:['cn']},resizable: false},//Added for avoid resizing the grid.
                   {name:'jvNumber',index:'jvNumber', width:200, align: "left",searchoptions:{sopt:['cn']},resizable: false,sorttype:'text'},
                   {name:'narration',index:'narration', width:400, align: "right",searchoptions:{sopt:['cn']},resizable: false,sorttype:'number'},
                   {name:'accountName',index:'accountName', width:400, align: "left",searchoptions:{sopt:['cn']},resizable: false,sorttype:'text'},
                   {name:'subGroupAcctName',index:'subGroupAcctName', width:300, align: "right",searchoptions:{sopt:['cn']},resizable: false,sorttype:'text'},
                   {name:'currency',index:'currency', width:100, align: "right",searchoptions:{sopt:['cn']},resizable: false,sorttype:'number'},
                   {name:'tcCreditAmount',index:'tcCreditAmount', width:200, align: "right",searchoptions:{sopt:['cn']},resizable: false,sorttype:'number'},
                   {name:'tcDebitAmount',index:'tcDebitAmount', width:200, align: "right",searchoptions:{sopt:['cn']},resizable: false,sorttype:'number'},
                   {name:'bcCreditAmount',index:'bcCreditAmount', width:200, align: "right",searchoptions:{sopt:['cn']},resizable: false,sorttype:'number'},
                   {name:'bcDebitAmount',index:'bcDebitAmount', width:200, align: "right",searchoptions:{sopt:['cn']},resizable: false,sorttype:'number'},
               ],
               pager: '#JournalBookPage',
               viewrecords: true,
               ignoreCase: true,
               footerrow: true,
               rowNum: 10,
           });
           $("#JournalMainGrid").jqGrid('setGridParam', { data : listdata }).trigger('reloadGrid');
           
       
       }*/
        
        $scope.excel = function(tracking) {

        	
        	   $scope.approvedData=[];
               angular.forEach($scope.trackingList, function(row, index) {
                   var check =row.select;
                   if (check ==true) {
                       $scope.approvedData.push(row);  
                       $scope.trackingList=$scope.approvedData;
                   }
               });
            var objWholeData = {
            	
            		
                'getServiceList' : $scope.trackingList
            };
         
            console.log("freight excel")
            console.log(objWholeData);

            $http.post($stateParams.tenantid+"/app/tracking/generateExcel1",objWholeData).success(function(response) {

                $('#exportXl').append('<a id="tbExcelExport" stype="display:none" href="filePath/tracking.xls" download="tracking.xls"></a>');
                $("#tbExcelExport").bind('click', function() {
                });
                $('#tbExcelExport').simulateClick('click');

            }).error(function(result) {
                logger.logError("Error Please Try Again");
            });
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
    
    
    
    
    
    
    
    
    
});

