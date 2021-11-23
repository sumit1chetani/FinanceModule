<div id="content">
 <!-- widget grid -->
 <section widget-grid id="widget-grid">
  <div class="row">
   <article class="col-sm-12">
    <div jarvis-widget id="standard-datatable-widget" data-widget-color="sttropaz" data-widget-editbutton="false" data-widget-deletebutton="false">
     <header>
      <span class="widget-icon">
       <i class="fa fa-table"></i>
      </span>
       <span><state-breadcrumbs></state-breadcrumbs>  </span>
     </header>
	     <div role="content">
	      <div class="widget-body no-padding">
	       <div class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all" st-table="displayedCollection" st-safe-src="rowCollection">
		       <div class="dt-toolbar" data-smart-include="views/layout/toolbar-header.tpl"></div>
		        <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="dt_basic_info">
		         <thead class="dataTables-Main-Head">
		          <tr>
		           <th ></th>
		           <th  st-sort="companyName">Hospital</th>
		           <th  st-sort="branchName">Branch</th>
		            <th  st-sort="financialYear">Financial Year</th>
		            <th  st-sort="rangeFrom">Range From</th>
		             <th  st-sort="rangeTo">Range To</th>
		              <th  st-sort="charge">Charge</th>
		          	 <th>Action</th>
		          </tr>
		         </thead>
		          <tbody class="dataTables-Main-Body">
		          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="ptSlabCollection in displayedCollection">
		           <td cs-select="objVesselMasterItem"></td>
					<td>{{ptSlabCollection.companyName}}</td>
					<td>{{ptSlabCollection.branchName}}</td>
					<td>{{ptSlabCollection.financialYear}}</td>
					<td>{{ptSlabCollection.rangeFrom}}</td>
					<td>{{ptSlabCollection.rangeTo}}</td>
					<td>{{ptSlabCollection.charge}}</td>
				 <td class=" td-actions text-center">
		        <span>
		       <i class="fa  fa-pencil text-success text" data-ng-click="editRow(ptSlabCollection.branchId,ptSlabCollection.financialYear,ptSlabCollection.rangeFrom)"></i> 
		        </span>
		        <span>
		        <!--  <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(ptSlabCollection.branchId,ptSlabCollection.financialYear,ptSlabCollection.rangeFrom)"></i> -->
		        </span>
		       </td>
		          </tr>
         		</tbody>
		        </table>
		         <div class="dt-toolbar-footer" data-smart-include="views/layout/toolbar-footer.tpl"></div>
	        </div>
	       </div>
	      </div>
     </div>
   </article>
  </div>
 </section>
</div>