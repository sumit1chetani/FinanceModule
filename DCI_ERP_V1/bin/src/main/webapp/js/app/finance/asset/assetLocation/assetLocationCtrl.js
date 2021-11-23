define([ 'hospital/inventory/inventory' ,'jqGrid' ], function(module) {
    'use strict';
    module.registerController('assetLocationCtrl',  function($scope,$state,$http,ngDialog, $filter,logger,$location,$controller,$injector, sharedProperties, toaster,$rootScope)  {
        
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.assetLocation = {
                itemId:'',
                locationId:'',
            };
        $scope.itemLists=[];
        $scope.locationLists=[];
        
        $scope.getDropDownValues = function(){
            $http.get('hospital/asset/assetLocation/getDropDownValues').success(function(response){
                $scope.itemLists = response.itemList;
                $scope.locationLists = response.locationList;
                
            });
          
        }
        $scope.getDropDownValues();
        
        
     
        $scope.itemMainList = function(){
            
            $http.get('hospital/asset/assetLocation/getItemMainList?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount).success(function(response){
                $scope.globalItemList=response.itemMainList;
                $scope.createGrid(response.itemMainList);
            }).error(function(response) {

            });
        }
        $scope.itemMainList();
        
        $scope.reloadGrid = function(data){
            $('#grid').setGridParam({ data: data, rowNum: data.length }).trigger('reloadGrid');
        };
        
        $scope.getItemList = function(assetLocation){
            var item = $scope.assetLocation.itemId;
            var location = $scope.assetLocation.locationId;
            if(item != "" && location !="" ){
                $http.get('hospital/asset/assetLocation/getItemListWithId?item=' + item + '&location=' + location).success(function(response){
                    $('#grid').clearGridData(true);
                    $('#grid').setGridParam({ data: response.itemMainList, rowNum: response.itemMainList.length }).trigger('reloadGrid');
                });  
                
            }else if(item !== ""){
                var itmId=Number(item);
                var obj=$filter('filter')($scope.globalItemList,{
                    itemId : itmId
                },true);
                $('#grid').clearGridData(true);
                $('#grid').setGridParam({ data: obj, rowNum: 10 }).trigger('reloadGrid');
            }
            }

        $scope.reset=function(){
            $scope.assetLocation.itemId="";
            $scope.assetLocation.locationId="";
            $('#grid').clearGridData(true);
            $('#grid').jqGrid('clearGridData').setGridParam({ data: $scope.globalItemList, rowNum: 10 }).trigger('reloadGrid');
            
        }

        $scope.itemSubList = function(itemId,locationId,subgridDivId){
            $http.get('hospital/asset/assetLocation/getItemSubList?itemId=' + itemId + '&locationId=' + locationId).success(function(response){
             if(response.itemSubList.length > 0){
                 var subgridTableId = subgridDivId + "_t";
                 $("#" + subgridTableId).setGridParam({ data: response.itemSubList, rowNum: response.itemSubList.length }).trigger('reloadGrid'); 
             }else{
                 logger.log("No Records To found");
             }
             });
        }
        $scope.createGrid = function(itemMainList){
            $("#grid").jqGrid({
                  data: itemMainList,
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
                  colNames: ['Item Id','Item Code', 'Item Name','Location Id','Location','Quantity'],
                  colModel: [
                      { name: 'itemId', width: 250 , align : "left",hidden:true},
                      { name: 'itemCode', width: 250, align : "left" ,hidden:false },
                      { name: 'itemName', width: 250 , align : "left" ,hidden:false},
                      { name: 'locationId', width: 250, align : "left" ,hidden:true},
                      { name: 'locationName', width: 250, align : "left" ,hidden:false},
                      { name: 'qty', width: 250, align : "right" ,hidden:false }

                  ],
                  loadOnce : true,
                  pager: '#assetLocation',
                  height: '100%',
                  rowNum: 10,
                  subGrid: true,
                  subGridOptions: {
                      "plusicon" : 'fa fa-plus-circle',
                      "minusicon" : 'fa fa-minus-circle'
                  },
                  subGridRowExpanded: function (subgridDivId, rowId) {
                      var rowData = $('#grid').jqGrid('getRowData', rowId);
                      $scope.itemSubList(rowData.itemId,rowData.locationId,subgridDivId);
                      var subgridTableId = subgridDivId + "_t";
                      var pager_child_id = "p_"+subgridTableId;
                      $("#" + subgridDivId).html("<table id='" + subgridTableId + "'></table><div id='"+pager_child_id+"' class='scroll'></div>");
                      $("#" + subgridTableId).jqGrid({
                          datatype: 'local',
                          data:  "",
                          colNames: ['Asset Id','Asset Number','Location Name','Asset Date'],
                          autowidth : true,
                          colModel: [
                                {name:'assetId',index:'assetId', width:100, align:"right",hidden:true},
                                {name:'assetTrackNo',index:'assetTrackNo', width:80, hidden:false},
                                {name:'locationName',index:'locationName', width:150 ,align:"left",hidden:false},
                                {name:'assetDate',index:'assetDate', width:150 ,align:"left",hidden:false},
                          ],
                          autoheight:true,
                          height: '100%',
                          sortname: 'num',
                          sortorder: "asc",
                    });
                  }
              });
              $("#grid").jqGrid('navGrid','#assetLocation',{edit:false,add:false,del:false,search:false,refresh:false});

              $("#grid").jqGrid('filterToolbar',{searchOperators : true,searchOnEnter:false});
              $("#grid").jqGrid('navButtonAdd',"#assetLocation",{caption:"",title:"Show/Hide Search box", buttonicon :'ui-icon icon-thumb-tack',
                  onClickButton:function(){
                      var myGrid = $('#grid');
                      myGrid[0].toggleToolbar();
                  }
              });
              $("#grid")[0].toggleToolbar();
          };

   });
});
