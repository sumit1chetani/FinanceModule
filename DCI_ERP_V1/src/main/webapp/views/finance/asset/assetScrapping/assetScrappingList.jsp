 <div class="wrapper-md"> 
  <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
  	<%@include file="/views/templates/panel-header.jsp"%>
    <div class="panel panel-default">
	 <div class="panel-body">
      <div class="table-responsive">        
       <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="dt_basic_info">
        <thead class="dataTables-Main-Head">
         <tr>
          <th class="width_1 text-center table-heading">
           <label class="i-checks m-b-none">
            <input type="checkbox" ng-model="selectedAll" ng-change="checkAll(displayedCollection,selectedAll)">
            <i></i>
           </label>
          </th>
          <th class="sorting width_10" st-sort="assetName">Asset Name</th>
          <th class="sorting width_10" st-sort="scrapDate">Date Of Scrap </th>
          <th class="sorting width_10" st-sort="journalNo">Journal No </th>
          <th class="width_2 text-center table-heading">Action</th>
         </tr>
        </thead>
        <tbody class="dataTables-Main-Body">
         <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objAssetSale in displayedCollection">           
         <td class="text-center">
           <div class="checkbox">
           	<label class="i-checks m-b-none">
			  <input type="checkbox" ng-model="objAssetSale.select" ng-change="checkSelected(objAssetSale.select,objAssetSale.assetSaleId)"><i></i>
			</label>
			</div>
          </td>
          <td>{{objAssetSale.assetName}}</td>
          <td>{{objAssetSale.scrapDate}}</td>
           <td>
            <span>
	       <a ng-click="printJournalVoucherDiv(objAssetSale.journalNo)">
			 <span tooltip="{{objAssetSale.journalNo}}" class="tool-tip-span font-blue">{{objAssetSale.journalNo}}</span>
	         </a></span>
	         </td>
          <td class=" td-actions text-center">
          <security:authorize access="hasRole('${form_code}_${modify}')">
	        <span>
         		<i class="fa  fa-pencil text-success text" data-ng-click="editRow(objAssetSale.assetSaleId)"></i>
        	</span>
	        </security:authorize>
	        <security:authorize access="hasRole('${form_code}_${delete}')">
	        <span>
         		<i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(objAssetSale.assetSaleId)"></i>
        	</span>
	        </security:authorize>
	   </td>
         </tr>
        </tbody>
       </table>
      </div> <!-- /table-responsive -->
       <footer class="panel-footer">
	    <%@include file="/views/templates/panel-footer-static.jsp"%>
	   </footer>
     </div> <!-- /panel-body -->	
    </div>  <!-- /panel panel-default -->
   </div> <!-- /panel-default-list -->
</div><!-- /wrapper-md -->