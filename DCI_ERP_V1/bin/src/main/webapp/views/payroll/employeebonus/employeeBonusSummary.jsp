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
	       <div class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all" st-table="displayedCollection" st-safe-src="bonussummaryList">
		       <div class="dt-toolbar" data-smart-include="views/layout/toolbar-header.tpl"></div>
		        <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="dt_basic_info">
		         <thead class="dataTables-Main-Head">
		          <tr>
		           <th class="sorting width_10" st-sort="employeeNo">Employee No</th>
		           <th class="sorting width_10" st-sort="employeeName">Employee Name</th>
		           <th class="sorting width_10" st-sort="declaredAmount">Declared Amount</th>
		           <th class="sorting width_10" st-sort="paidAmount">Paid Amount</th>
		           <th class="sorting width_10" st-sort="paidOn">Paid On</th>
		          </tr>
		         </thead>
		         <tbody class="dataTables-Main-Body">
                <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="summaryList in bonussummaryList">
                <td>{{summaryList.employeeId}}</td>
			    <td>{{summaryList.employeeName}}</td>
			    <td>{{summaryList.declaredAmount}}</td>
			    <td>{{summaryList.paidAmount}}</td>
			    <td>{{summaryList.paidOn}}</td>
		         </tr>
		         </tbody>
		        </table>
		        <div class="form-actions">
					<div class="row">
							<div class="col-md-12">
								<button class="btn btn-success" class="btn btn-success" type="button" ng-click="ok()">
									  <i ></i>
									       Ok
						        </button>
						</div>
					</div>
			 </div>
	        </div>
	       </div>
	      </div>
     </div>
   </article>
  </div>
 </section>
</div>