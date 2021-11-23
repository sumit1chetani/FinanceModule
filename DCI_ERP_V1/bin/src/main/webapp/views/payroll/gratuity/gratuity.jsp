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
		           <th class="width_1"></th>
		           <th class="sorting width_10" st-sort="companyName">Company</th>
		           <th class="sorting width_10" st-sort="branchName">Branch</th>
		           <th class="sorting width_10" st-sort="departmentName">Department</th>
		           <th class="sorting width_10" st-sort="employeeId">Employee No.</th>
		           <th class="sorting width_10" st-sort="employeeName">Employee Name</th>
		           <th class="sorting width_10" st-sort="periodFrom">Gratuity Period From</th>
		           <th class="sorting width_10" st-sort="periodTo">Gratuity Period To</th>
		          <th class="sorting width_10" st-sort="Action">Action</th>
		          </tr>
		         </thead>
		         <tbody class="dataTables-Main-Body">
		          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="gratutityCollection in displayedCollection">
		           <td cs-select="objVesselMasterItem"></td>
					<td>{{gratutityCollection.companyName}}</td>
					<td>{{gratutityCollection.branchName}}</td>
					<td>{{gratutityCollection.departmentName}}</td>
					<td>{{gratutityCollection.employeeId}}</td>
					<td>{{gratutityCollection.employeeName}}</td>
					<td>{{gratutityCollection.periodFrom}}</td>
					<td>{{gratutityCollection.periodTo}}</td>
					
				 <td class=" td-actions text-center">
		        <span>
		         <i class="fa  fa-pencil text-success text" data-ng-click="editRow(loanEntryCollection.loanId)"></i>
		        </span>
		        <span>
		         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(loanEntryCollection.loanId)"></i>
		        </span>
		       </td>
		          </tr>
         	</tbody>
		        </table>
		      </div>
		         <div class="dt-toolbar-footer" data-smart-include="views/layout/toolbar-footer.tpl"></div>
	        </div>
	       </div>
	      </div>
   </article>
  </div>
 </section>
</div>