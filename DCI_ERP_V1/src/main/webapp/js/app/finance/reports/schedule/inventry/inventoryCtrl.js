'use strict';
app.controller('inventoryCtrl', function($scope, $rootScope, $http, $location, logger, $log, ngDialog, $modal, utilsService,$state,$stateParams) {
    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.viewInventory=false;

    $scope.pageCounters = [ 14, 16, 17, 18, 150, 500, 1000 ];
    $scope.itemsByPage = 14;

    $scope.emptyObject = {};
    
    $scope.inventory={
            fromDate:'',
            toDate:'',
            truckId:'',
            fuelDate:'',
            fuelType:'',
            truck:'',
            units:''
         }
    

    $('#fromDate').datetimepicker({
        format : 'DD/MM/YYYY'
    });
    
    $('#toDate').datetimepicker({
        format : 'DD/MM/YYYY'
    });
    
    console.log($scope.inventory);
    
    $http.get($stateParams.tenantid+'/truckdrivermapping/trucklist').success(function(datas) {
        $scope.vesselList = datas.truckList;
       });
    
    
    
 
    
    
    $scope.InventryList = function() {
        var url = $stateParams.tenantid+'/app/inventory/list?=' + $scope.limitCount + '&offset=' + $scope.offsetCount;
        $http.get(url).success(function(data) {
            if (data.success == true) {
                $scope.rowCollection = $scope.rowCollection.concat(data.lInventryResultBean);
                sharedProperties.setObject($scope.emptyObject);
            }
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
        $scope.offsetCount = $scope.offsetCount + $scope.limitCount;
    };

   $scope.InventryList();
    
    $scope.viewInventry = function(){
        var vesselCode= $scope.inventory.vesselCode;
        var frmDate=$scope.inventory.fromDate;
     //   alert(vesselCode + " "+frmDate);
        console.log($scope.inventory.fromDate);
        debugger
//        if(vesselCode!="" && frmDate!=""){
            $scope.viewInventory=true;
            $scope.populateInventryGrid();
//        }else{
//            logger.logError("Please select required fields");
//        }
       
       /*$scope.pl.fromDate = $('#fromDate').val();
        $scope.pl.toDate = $('#toDate').val();*/
        $http.post($stateParams.tenantid+'/app/inventory/list',$scope.inventory).success(function(datas) {
            debugger;
            $scope.populateInventryGrid(datas);
            console.log(datas);
            if(datas.success){
                debugger;
                $("#inReportGrid").jqGrid('clearGridData'); 
                $scope.populateInventryGrid(datas.inventoryList);
               ListData = datas.inventoryList;
            }else{
                
            }
            }).error(function(datas) {
        });
    }
    
    
    
    $scope.populateInventryGrid = function(ListData){
        debugger;
        $("#inReportGrid").jqGrid({
            data:ListData ,
            datatype: "local",
            multiboxonly: true,
            autowidth: true,
            height: '100%',
            rowList: [10,20,30],
            loadonce: true,
            gridview:true,
            colNames:['Truck','Last Supplied Date','ROB Fuel Oil(MT)','Fuel Oil Last Rate'],
            colModel:[
                      {name:'truck',index:'truck', width:290, align:"center",searchoptions:{sopt:['cn']}},
                      {name:'fuelDate',index:'fuelDate', width:290,align:"center", searchoptions:{sopt:['cn']},hidden:false},
                      {name:'fuelType',index:'fuelType', width:290, align:"center",searchoptions:{sopt:['cn']},hidden:false},
                      {name:'units',index:'units', width:290,align:"center", searchoptions:{sopt:['cn']},hidden:false}
                      ],
            pager: "#inReportGridPage",
            viewrecords: true,
            //caption: 'Profit And Loss List',
            ignoreCase: true,
           // subGrid: true,
           /* subGridOptions: {
                "plusicon" : 'ui-icon-plus',
                "minusicon" : 'ui-icon-minus'
                "openicon" : 'fa fa-plus-circle',
                "reloadOnExpand" : true
            },*/
            

            footerrow: true,

           
        }).jqGrid('setGridParam', { data : ListData }).trigger("reloadGrid");

        
    }
    
    $scope.reset=function(){
        $scope.viewInventory=false;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
});
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  
    
  
