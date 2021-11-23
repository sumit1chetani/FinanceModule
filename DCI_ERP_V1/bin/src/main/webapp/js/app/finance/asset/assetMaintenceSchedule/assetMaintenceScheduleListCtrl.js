define([ 'hospital/asset/asset','jqGrid' ], function(module) {

'use strict';

    module.registerController('assetMaintenceScheduleListCtrl', function($scope,$state,$http, ngDialog, logger,$location,$controller,$injector, sharedProperties, toaster,$rootScope) {
    
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;

        $scope.numPages=0

        $scope.add = function(){
            $state.go("app.hospital.asset.assetMaintenceSchedule.add");
        };
        $scope.getAsstSchedule = function() {
            $http.get('hospital/asset/assetmaintenanceschedule/List').success(function(data) {
                if (data.success) {
                    console.log(data);
                    $scope.rowCollection = data.liasstMaintenaceSchedule;
               } else {
                    logger.logError("Error Please Try Again");
                }
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        };

        $scope.editRow = function(assetScheduleId) {
            $state.go('app.hospital.asset.assetMaintenceSchedule.view',({ 'assetScheduleId': assetScheduleId}));
        }
        
       $scope.getAsstSchedule();
    });
module.registerController('assetMaintenceScheduleViewCtrl', function($scope,$state, $http,$compile, $controller,ngDialog,logger,sharedProperties,$injector, toaster,$rootScope,$stateParams) {
        
        var assetSChID=$stateParams.assetScheduleId;
        $scope.globalAssetLocationList=[];
        $scope.globalItemList=[];
        $scope.getEditManageItemList = function(assetSChID) {
            var url = 'hospital/asset/assetmaintenanceschedule/viewMaintenaceDetailList?assetScheduleId=' + assetSChID;
            $http.get(url).success(function(result) {
                console.log(result);
                $scope.globalAssetTrackList=result.liasstMaintenaceScheduleAsset
                $scope.globalItemList=result.liasstMaintenaceSchedule
                $scope.createGrid(result.liasstMaintenaceSchedule);
            }).error(function(result) {
                logger.logError("Error Please Try Again");
            });

        }
        $scope.getEditManageItemList(assetSChID);
        
        $scope.cancel=function(){
            $state.go('app.hospital.asset.assetMaintenceSchedule.list');
            
        }
        
        
        $scope.reloadGrid = function(data){
            // $('#grid').clearGridData(true);
             $('#grid').setGridParam({ data: data, rowNum: data.length }).trigger('reloadGrid');
         };

         $scope.getChildSubGridList = function(assetTrackId,childsubgridDivId){
             
             $http.get('hospital/asset/assetmaintenanceschedule/fetchMaintenaceTypeList?assetTrackDtlId=' + assetTrackId).success(function(data) {
                 var subgridTableId = childsubgridDivId + "_c";
                  $("#" + subgridTableId).setGridParam({ data: data.listassetProp, rowNum: data.listassetProp.length }).trigger('reloadGrid');
             });
             
         }
        $scope.createGrid = function(inventoryList){
            $("#grid").jqGrid({
                  data: inventoryList,
                  datatype: "local",
                  autowidth:true,
                  autoheight:true,
                  rowList: [5, 10, 20],
                  gridview: true,
                  sortname: 'invdate',
                  viewrecords: true,
                  sortorder: 'desc',
                  multiselect: false,
                  multiboxonly: false,
                  colNames: ['Asset Schedule Id','Item Name', 'Category Name'],
                  colModel: [
                      { name: 'assetScheduleId', width: 250 , align : "left",searchoptions:{sopt:['cn']},hidden:true},
                      { name: 'itemName', width: 250, align : "left" ,searchoptions:{sopt:['cn']},hidden:false },
                      { name: 'categoryName', width: 250 , align : "left" ,searchoptions:{sopt:['cn']},hidden:false}
                     

                  ],
                  loadOnce : true,
                  pager: '#inventorypage',
                  height: '100%',
                  rowNum: 10,
                  subGrid: true,
                  subGridOptions: {
                      "plusicon" : 'fa fa-plus-circle',
                      "minusicon" : 'fa fa-minus-circle'
                   
                  },
                  subGridRowExpanded: function (subgridDivId, rowId) {
                      var rowData = $('#grid').jqGrid('getRowData', rowId);
                      var subgridTableId = subgridDivId + "_t";
                      var pager_child_id = "p_"+subgridTableId;
                      $("#" + subgridDivId).html("<table id='" + subgridTableId + "'></table><div id='"+pager_child_id+"' class='scroll'></div>");
                      $("#" + subgridTableId).jqGrid({
                          datatype: 'local',
                          data: $scope.globalAssetTrackList,
                          colNames: ['Asset Schedule Id','Asset Track Detail Id','Asset Track Number','Asset Name','Serial No'],
                          autowidth : true,
                          colModel: [
                                {name:'assetScheduleId', width:100, align:"right",searchoptions:{sopt:['cn']},hidden:true},
                                {name:'asstDetailId', width:80, searchoptions:{sopt:['cn']},hidden:true},
                                {name:'assettrackNo', width:150 ,align:"left",searchoptions:{sopt:['cn']}},
                                {name:'assettrackName', width:150, align:"left",searchoptions:{sopt:['cn']}},
                                {name:'serialNo', width:150, align:"left",searchoptions:{sopt:['cn']}},
                                
                          ],
                          autoheight:true,
                          height: '100%',
                          rowNum: 10,
                          sortname: 'num',
                          sortorder: "asc",
                          subGrid: true,
                          subGridOptions: {
                              "plusicon" : 'fa fa-plus-circle',
                              "minusicon" : 'fa fa-minus-circle'
                           
                          },subGridRowExpanded: function (childsubgridDivId, childrowId) {
                              
                              var rowData1 = $('#grid_1_t').jqGrid('getRowData', parseInt(childrowId));
                              var trackList=$scope.getChildSubGridList(rowData1.asstDetailId,childsubgridDivId);
                              var subgrid_TableId = childsubgridDivId + "_c";
                              console.log(subgrid_TableId);
                              var pager_child_id = "pc_"+subgrid_TableId;
                              $("#" + childsubgridDivId).html("<table id='" + subgrid_TableId + "'></table><div id='"+pager_child_id+"' class='scroll'></div>");
                              $("#" + subgrid_TableId).jqGrid({
                                  datatype: 'local',
                                  data: "",
                                  colNames: ['Asset Schedule Detail Id','Schedule Date','Maintenance type','Period/Utilization','Worked By','Remarks','Actual Date','Next Schedule Date ','Status'],
                                  autowidth : true,
                                  colModel: [
                                        {name:'assetScheduleDtlId',index:'assetScheduleDtlId', width:100, align:"right",searchoptions:{sopt:['cn']},hidden:true},
                                        {name:'maintenanceScheduleDate',index:'maintenanceScheduleDate', width:150 ,align:"left",searchoptions:{sopt:['cn']}},
                                        {name:'maintenanceName',index:'maintenanceName', width:150 ,align:"left",searchoptions:{sopt:['cn']}},
                                        {name:'frequency',index:'frequency', width:150 ,align:"left",searchoptions:{sopt:['cn']}},
                                        {name:'workedbY',index:'workedbY', width:150 ,align:"left",searchoptions:{sopt:['cn']}},
                                        {name:'remarks',index:'remarks', width:150 ,align:"left",searchoptions:{sopt:['cn']}},
                                        {name:'actualDate',index:'actualDate', width:150 ,align:"left",searchoptions:{sopt:['cn']}},
                                        {name:'nextScheduleDate',index:'nextScheduleDate', width:150 ,align:"left",searchoptions:{sopt:['cn']}},
                                        {name:'status',index:'status', width:150 ,align:"left",searchoptions:{sopt:['cn']}},
                                        
                                        
                                        
                                  ],
                                  autoheight:true,
                                  height: '100%',
                                  rowNum: 10,
                                  sortname: 'num',
                                  sortorder: "asc",
                            });
                              
                          }
                    });
                  }
              });
  
              $("#grid").jqGrid('navGrid','#inventorypage',{edit:false,add:false,del:false,search:false,refresh:false});

              $("#grid").jqGrid('filterToolbar',{searchOperators : true,searchOnEnter:false});
              $("#grid").jqGrid('navButtonAdd',"#inventorypage",{caption:"",title:"Show/Hide Search box", buttonicon :'ui-icon icon-thumb-tack',
                  onClickButton:function(){
                      var myGrid = $('#grid');
                      myGrid[0].toggleToolbar();
                  }
              });
              $("#grid")[0].toggleToolbar();
              
             

             
        };
          
    });
});