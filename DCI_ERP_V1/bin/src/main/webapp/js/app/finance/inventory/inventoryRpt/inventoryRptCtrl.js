
app.controller('inventoryRptCtrl',  function($scope,$state,$http,ngDialog, logger,$location,$controller,$injector, sharedProperties, toaster,$rootScope)  {
        debugger;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.inventoryModel = {
            itemId:'',
            itemName:'',
            locationId:'',
            locationName:'',
            totQty :''

     };
    $scope.itemLists=[];
    $scope.locationLists=[];

    $scope.loadDropDownData = function(){
        $http.get('app/inventoryRprt/getDropDowns').success(function(response) {
            debugger;
            console.log("Drop Down List :::::::::::::::::");
            console.log(response);
            var items=[],locations=[];

            angular.forEach(response.itemList,function(item,key){
                items.push({'id' : item.itemId ,'text' : item.itemName});
            });
            console.log(items);
            angular.forEach(response.locationList,function(item,key){
                locations.push({'id' : item.locationId ,'text' : item.locationName});
            });
            console.log(locations);
            $scope.itemLists=items;
            $scope.locationLists=locations;
           }).error(function(response) {
           });
    };

    $scope.loadDropDownData();

    $scope.getInventoryReport = function(){
        console.log("MODEL :::::::::::::::::");
        console.log($scope.inventoryModel);
        var itm=0,location=0;
        if($scope.inventoryModel.itemId != undefined && $scope.inventoryModel.itemId != ''){
            itm = $scope.inventoryModel.itemId ;
        }
        if($scope.inventoryModel.locationId != undefined && $scope.inventoryModel.locationId != ''){
            location = $scope.inventoryModel.locationId;
        }

        $http.get('app/inventoryRprt/inventroyListWithParam?itm=' + itm + '&location=' + location).success(function(response) {
            console.log("inventroyListWithParam  ::::::::::::::::");
            console.log(response.inventoryMasterList);
            $('#grid').clearGridData(true);
            $('#grid').setGridParam({ data: response.inventoryMasterList, rowNum: response.inventoryMasterList.length }).trigger('reloadGrid');
           }).error(function(response) {
           });
    };

   $scope.inventoryList = function(){
        $http.get('app/inventoryRprt/inventroyList?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount).success(function(response) {
            console.log("Master List :::::::::::::::::");
            console.log(response.inventoryMasterList);
            $scope.createGrid(response.inventoryMasterList);
            //$scope.reloadGrid(response.inventoryMasterList);
           }).error(function(response) {

           });
    };

    $scope.inventoryList();
    $scope.reloadGrid = function(data){
       // $('#grid').clearGridData(true);
        $('#grid').setGridParam({ data: data, rowNum: data.length }).trigger('reloadGrid');
    };

    $scope.getSubGridList = function(item,location,subgridDivId){
        $http.get('app/inventoryRprt/inventroySubList?item=' + item + '&location=' + location).success(function(data) {
            console.log("SubGrid data :::::::::::::::;;");
            console.log(data.inventorySubList);
            var subgridTableId = subgridDivId + "_t";
           // $("#" + subgridTableId).clearGridData(true);
            $("#" + subgridTableId).setGridParam({ data: data.inventorySubList, rowNum: data.inventorySubList.length }).trigger('reloadGrid');


        });
    };

    $scope.totalInventory = function(){
        debugger;
        var prdQty=0;
        var data = $("#grid").jqGrid('getGridParam','data');
        if(data != undefined && data.length >0){
            var jsonPrdlist={"table":data};
            for (var j = 0; j < jsonPrdlist.table.length; j++)
            {
                prdQty =prdQty+parseInt(jsonPrdlist.table[j].qty);
            }

        }
            if(!isNaN(prdQty))
                $('#totalQty').val(prdQty);
            else
                $('#totalQty').val(0);

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
              colNames: ['Item Id','Item Name', 'Item Desc','Location Id','Location','Quantity'],
              colModel: [
                  { name: 'itemId', width: 250 , align : "left",searchoptions:{sopt:['cn']},hidden:true},
                  { name: 'itemName', width: 250, align : "left" ,searchoptions:{sopt:['cn']},hidden:false },
                  { name: 'itemDesc', width: 250 , align : "left" ,searchoptions:{sopt:['cn']},hidden:false},
                  { name: 'locationId', width: 250, align : "left" ,searchoptions:{sopt:['cn']},hidden:true},
                  { name: 'locationName', width: 250, align : "left" ,searchoptions:{sopt:['cn']},hidden:false},
                  { name: 'qty', width: 250, align : "right" ,searchoptions:{sopt:['cn']},hidden:false }

              ],
              loadOnce : true,
              pager: '#inventorypage',
              height: '100%',
              rowNum: 10,
              subGrid: true,
              subGridOptions: {
                  "plusicon" : 'fa fa-plus-circle',
                  "minusicon" : 'fa fa-minus-circle'/*,
                  "openicon" : 'fa fa-plus-circle',
                  "reloadOnExpand" : true*/
              },
              subGridRowExpanded: function (subgridDivId, rowId) {
                  debugger;
                  var rowData = $('#grid').jqGrid('getRowData', rowId);
                  console.log("rowData ::::::::::::::::::::::");
                  console.log(rowData.itemId+"::::::::::::::::::::::::::"+rowData.locationId);
                  $scope.getSubGridList(rowData.itemId,rowData.locationId,subgridDivId);
                  var subgridTableId = subgridDivId + "_t";
                  var pager_child_id = "p_"+subgridTableId;
                  $("#" + subgridDivId).html("<table id='" + subgridTableId + "'></table><div id='"+pager_child_id+"' class='scroll'></div>");
                  $("#" + subgridTableId).jqGrid({
                      datatype: 'local',
                      data: "",
                      colNames: ['ledger Id','Date','Doc. Type','Doc. Ref','Src. Location','Dst. Location','InQty','OutQty'],
                      autowidth : true,
                      colModel: [
                            {name:'ledgerId',index:'storageId', width:100, align:"right",searchoptions:{sopt:['cn']},hidden:true},
                            {name:'inventoryDate',index:'inventoryDate', width:80, searchoptions:{sopt:['cn']},hidden:false},
                            {name:'docType',index:'docType', width:150 ,align:"left",searchoptions:{sopt:['cn']}},
                            {name:'refDoc',index:'refDoc', width:150, align:"left",searchoptions:{sopt:['cn']}},
                            {name:'srcLocation',index:'srcLocation', width:150, align:"left",searchoptions:{sopt:['cn']},hidden:true},
                            {name:'dstLocation',index:'dstLocation', width:150, align:"left",searchoptions:{sopt:['cn']},hidden:true},
                            {name:'inQty',index:'inQty', width:80, align:"right",searchoptions:{sopt:['cn']}},
                            {name:'outQty',index:'outQty', width:80, align:"right",searchoptions:{sopt:['cn']}}
                      ],
                      autoheight:true,
                      height: '100%',
                    /*  pager: pager_child_id,*/
                      sortname: 'num',
                      sortorder: "asc",
                });

             // $("#"+subgridTableId).jqGrid('navGrid','#'+pager_child_id,{edit:false,add:false,del:false,search:false,refresh:false});


              },
              loadComplete: function(){
                  $scope.totalInventory();
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
